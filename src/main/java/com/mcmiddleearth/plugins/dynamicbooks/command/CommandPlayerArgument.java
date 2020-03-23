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
import org.bukkit.Server;
import org.bukkit.entity.HumanEntity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CommandPlayerArgument implements ArgumentType<String> {

    private final Server server;

    public CommandPlayerArgument(Server server) {
        this.server = server;
    }

    @Override
    public String parse(StringReader reader) throws CommandSyntaxException {
        String o = reader.readString();
        if (server.getOnlinePlayers().stream().map(HumanEntity::getName).collect(Collectors.toSet()).contains(o)) {
            return o;
        }
        throw new CommandSyntaxException(new SimpleCommandExceptionType(new LiteralMessage("Failed parsing during action evaluation")), new LiteralMessage("Failed parsing during action evaluation on action:" + o));
    }

    @Override
    public Collection<String> getExamples() {
        return server.getOnlinePlayers().stream().map(HumanEntity::getName).collect(Collectors.toSet());
    }

    @Override
    public <S> CompletableFuture<Suggestions> listSuggestions(final CommandContext<S> context, final SuggestionsBuilder builder) {
        Logger.getGlobal().info("CommandPlayerArgument Start");
        for (String option : server.getOnlinePlayers().stream().map(HumanEntity::getName).collect(Collectors.toSet())) {
            if (option.toLowerCase().startsWith(builder.getRemaining().toLowerCase())) {
                builder.suggest(option);
            }
        }
        return builder.buildFuture();
    }
}
