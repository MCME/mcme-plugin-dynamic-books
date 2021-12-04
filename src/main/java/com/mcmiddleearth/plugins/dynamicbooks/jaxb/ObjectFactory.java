//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2021.12.04 um 01:37:14 AM CET 
//


package com.mcmiddleearth.plugins.dynamicbooks.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mcmiddleearth.plugins.dynamicbooks.jaxb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _XmlBookXmlPageXmlLineTpl_QNAME = new QName("", "tpl");
    private final static QName _XmlBookXmlPageXmlLineObj_QNAME = new QName("", "obj");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mcmiddleearth.plugins.dynamicbooks.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link XmlBook }
     * 
     */
    public XmlBook createXmlBook() {
        return new XmlBook();
    }

    /**
     * Create an instance of {@link XmlTemplate }
     * 
     */
    public XmlTemplate createXmlTemplate() {
        return new XmlTemplate();
    }

    /**
     * Create an instance of {@link XmlBook.XmlPage }
     * 
     */
    public XmlBook.XmlPage createXmlBookXmlPage() {
        return new XmlBook.XmlPage();
    }

    /**
     * Create an instance of {@link XmlBook.XmlPage.XmlLine }
     * 
     */
    public XmlBook.XmlPage.XmlLine createXmlBookXmlPageXmlLine() {
        return new XmlBook.XmlPage.XmlLine();
    }

    /**
     * Create an instance of {@link XmlBook.XmlPermissions }
     * 
     */
    public XmlBook.XmlPermissions createXmlBookXmlPermissions() {
        return new XmlBook.XmlPermissions();
    }

    /**
     * Create an instance of {@link XmlBook.XmlTemplates }
     * 
     */
    public XmlBook.XmlTemplates createXmlBookXmlTemplates() {
        return new XmlBook.XmlTemplates();
    }

    /**
     * Create an instance of {@link XmlTemplate.XmlOptions }
     * 
     */
    public XmlTemplate.XmlOptions createXmlTemplateXmlOptions() {
        return new XmlTemplate.XmlOptions();
    }

    /**
     * Create an instance of {@link XmlBook.XmlPage.XmlLine.XmlTpl }
     * 
     */
    public XmlBook.XmlPage.XmlLine.XmlTpl createXmlBookXmlPageXmlLineXmlTpl() {
        return new XmlBook.XmlPage.XmlLine.XmlTpl();
    }

    /**
     * Create an instance of {@link XmlBook.XmlPage.XmlLine.XmlObj }
     * 
     */
    public XmlBook.XmlPage.XmlLine.XmlObj createXmlBookXmlPageXmlLineXmlObj() {
        return new XmlBook.XmlPage.XmlLine.XmlObj();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XmlBook.XmlPage.XmlLine.XmlTpl }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XmlBook.XmlPage.XmlLine.XmlTpl }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "tpl", scope = XmlBook.XmlPage.XmlLine.class)
    public JAXBElement<XmlBook.XmlPage.XmlLine.XmlTpl> createXmlBookXmlPageXmlLineTpl(XmlBook.XmlPage.XmlLine.XmlTpl value) {
        return new JAXBElement<XmlBook.XmlPage.XmlLine.XmlTpl>(_XmlBookXmlPageXmlLineTpl_QNAME, XmlBook.XmlPage.XmlLine.XmlTpl.class, XmlBook.XmlPage.XmlLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XmlBook.XmlPage.XmlLine.XmlObj }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XmlBook.XmlPage.XmlLine.XmlObj }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "obj", scope = XmlBook.XmlPage.XmlLine.class)
    public JAXBElement<XmlBook.XmlPage.XmlLine.XmlObj> createXmlBookXmlPageXmlLineObj(XmlBook.XmlPage.XmlLine.XmlObj value) {
        return new JAXBElement<XmlBook.XmlPage.XmlLine.XmlObj>(_XmlBookXmlPageXmlLineObj_QNAME, XmlBook.XmlPage.XmlLine.XmlObj.class, XmlBook.XmlPage.XmlLine.class, value);
    }

}
