package com.mcmiddleearth.plugins.dynamicbooks.command;

import com.mcmiddleearth.plugins.dynamicbooks.library.BookLibrary;
import com.mcmiddleearth.plugins.dynamicbooks.library.LibraryBookAddedListener;
import com.mcmiddleearth.plugins.dynamicbooks.library.LibraryBookRemovedListener;
import com.mojang.brigadier.LiteralMessage;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

public class CommandBookArgument implements ArgumentType<String> {

    Set<String> options;

    public CommandBookArgument(BookLibrary library) {
        options = new HashSet<>();

        library.addListener((LibraryBookAddedListener) (bookId, book) -> options.add(bookId));
        library.addListener((LibraryBookRemovedListener) (bookId) -> options.add(bookId));

        options.addAll(library.getAllBookIds());
    }

    @Override
    public String parse(StringReader reader) throws CommandSyntaxException {
        String o = reader.readString();
        if (options.contains(o)) {
            return o;
        }
        throw new CommandSyntaxException(new SimpleCommandExceptionType(new LiteralMessage("Failed parsing during action evaluation")), new LiteralMessage("Failed parsing during action evaluation on action:" + o));
    }

    @Override
    public Collection<String> getExamples() {
        return options;
    }

    @Override
    public <S> CompletableFuture<Suggestions> listSuggestions(final CommandContext<S> context, final SuggestionsBuilder builder) {
        Logger.getGlobal().info("CommandBookArgument Start");
        for (String option : options) {
            if (option.toLowerCase().startsWith(builder.getRemaining().toLowerCase())) {
                builder.suggest(option);
            }
        }
        return builder.buildFuture();
    }
}
