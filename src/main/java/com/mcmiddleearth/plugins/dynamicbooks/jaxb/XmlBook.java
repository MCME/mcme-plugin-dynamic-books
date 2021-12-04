//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2021.12.04 um 01:37:14 AM CET 
//


package com.mcmiddleearth.plugins.dynamicbooks.jaxb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="permissions" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="give" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="open" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="giveremote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="openremote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="templates" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="template" type="{}template" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="page" maxOccurs="100"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="line" maxOccurs="14"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;choice maxOccurs="unbounded"&gt;
 *                             &lt;element name="tpl" maxOccurs="unbounded"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                                     &lt;attribute name="ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                     &lt;attribute name="arg1" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                     &lt;attribute name="arg2" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                     &lt;attribute name="arg3" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                     &lt;attribute name="arg4" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                     &lt;attribute name="arg5" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                     &lt;attribute name="styles" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                     &lt;attribute name="color" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                     &lt;attribute name="auto-type" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                     &lt;attribute name="page" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                     &lt;attribute name="url" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                     &lt;attribute name="hover-text" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                     &lt;attribute name="execute" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                     &lt;attribute name="open-book" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                     &lt;attribute name="give-book" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                   &lt;/extension&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="obj" maxOccurs="unbounded"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                                     &lt;attribute name="styles" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                     &lt;attribute name="color" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                     &lt;attribute name="auto-type" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                     &lt;attribute name="page" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                     &lt;attribute name="url" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                     &lt;attribute name="hover-text" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                     &lt;attribute name="execute" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                     &lt;attribute name="open-book" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                     &lt;attribute name="give-book" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                   &lt;/extension&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/choice&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="author" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "permissions",
    "templates",
    "page"
})
@XmlRootElement(name = "book")
public class XmlBook {

    protected XmlBook.XmlPermissions permissions;
    protected XmlBook.XmlTemplates templates;
    @XmlElement(required = true)
    protected List<XmlBook.XmlPage> page;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "author", required = true)
    protected String author;

    /**
     * Ruft den Wert der permissions-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XmlBook.XmlPermissions }
     *     
     */
    public XmlBook.XmlPermissions getPermissions() {
        return permissions;
    }

    /**
     * Legt den Wert der permissions-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlBook.XmlPermissions }
     *     
     */
    public void setPermissions(XmlBook.XmlPermissions value) {
        this.permissions = value;
    }

    /**
     * Ruft den Wert der templates-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XmlBook.XmlTemplates }
     *     
     */
    public XmlBook.XmlTemplates getTemplates() {
        return templates;
    }

    /**
     * Legt den Wert der templates-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlBook.XmlTemplates }
     *     
     */
    public void setTemplates(XmlBook.XmlTemplates value) {
        this.templates = value;
    }

    /**
     * Gets the value of the page property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the page property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XmlBook.XmlPage }
     * 
     * 
     */
    public List<XmlBook.XmlPage> getPage() {
        if (page == null) {
            page = new ArrayList<XmlBook.XmlPage>();
        }
        return this.page;
    }

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Ruft den Wert der author-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Legt den Wert der author-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthor(String value) {
        this.author = value;
    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="line" maxOccurs="14"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;choice maxOccurs="unbounded"&gt;
     *                   &lt;element name="tpl" maxOccurs="unbounded"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *                           &lt;attribute name="ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                           &lt;attribute name="arg1" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                           &lt;attribute name="arg2" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                           &lt;attribute name="arg3" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                           &lt;attribute name="arg4" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                           &lt;attribute name="arg5" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                           &lt;attribute name="styles" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                           &lt;attribute name="color" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                           &lt;attribute name="auto-type" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                           &lt;attribute name="page" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                           &lt;attribute name="url" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                           &lt;attribute name="hover-text" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                           &lt;attribute name="execute" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                           &lt;attribute name="open-book" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                           &lt;attribute name="give-book" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                         &lt;/extension&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="obj" maxOccurs="unbounded"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *                           &lt;attribute name="styles" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                           &lt;attribute name="color" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                           &lt;attribute name="auto-type" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                           &lt;attribute name="page" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                           &lt;attribute name="url" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                           &lt;attribute name="hover-text" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                           &lt;attribute name="execute" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                           &lt;attribute name="open-book" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                           &lt;attribute name="give-book" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                         &lt;/extension&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/choice&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "line"
    })
    public static class XmlPage {

        @XmlElement(required = true)
        protected List<XmlBook.XmlPage.XmlLine> line;
        @XmlAttribute(name = "ref")
        protected String ref;

        /**
         * Gets the value of the line property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the line property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLine().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link XmlBook.XmlPage.XmlLine }
         * 
         * 
         */
        public List<XmlBook.XmlPage.XmlLine> getLine() {
            if (line == null) {
                line = new ArrayList<XmlBook.XmlPage.XmlLine>();
            }
            return this.line;
        }

        /**
         * Ruft den Wert der ref-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRef() {
            return ref;
        }

        /**
         * Legt den Wert der ref-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRef(String value) {
            this.ref = value;
        }


        /**
         * <p>Java-Klasse für anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;choice maxOccurs="unbounded"&gt;
         *         &lt;element name="tpl" maxOccurs="unbounded"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
         *                 &lt;attribute name="ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                 &lt;attribute name="arg1" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                 &lt;attribute name="arg2" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                 &lt;attribute name="arg3" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                 &lt;attribute name="arg4" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                 &lt;attribute name="arg5" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                 &lt;attribute name="styles" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                 &lt;attribute name="color" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                 &lt;attribute name="auto-type" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                 &lt;attribute name="page" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                 &lt;attribute name="url" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                 &lt;attribute name="hover-text" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                 &lt;attribute name="execute" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                 &lt;attribute name="open-book" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                 &lt;attribute name="give-book" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *               &lt;/extension&gt;
         *             &lt;/simpleContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="obj" maxOccurs="unbounded"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
         *                 &lt;attribute name="styles" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                 &lt;attribute name="color" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                 &lt;attribute name="auto-type" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                 &lt;attribute name="page" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                 &lt;attribute name="url" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                 &lt;attribute name="hover-text" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                 &lt;attribute name="execute" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                 &lt;attribute name="open-book" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                 &lt;attribute name="give-book" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *               &lt;/extension&gt;
         *             &lt;/simpleContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/choice&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "content"
        })
        public static class XmlLine {

            @XmlElementRefs({
                @XmlElementRef(name = "tpl", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "obj", type = JAXBElement.class, required = false)
            })
            @XmlMixed
            protected List<Serializable> content;

            /**
             * Gets the value of the content property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the content property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getContent().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link JAXBElement }{@code <}{@link XmlBook.XmlPage.XmlLine.XmlTpl }{@code >}
             * {@link JAXBElement }{@code <}{@link XmlBook.XmlPage.XmlLine.XmlObj }{@code >}
             * {@link String }
             * 
             * 
             */
            public List<Serializable> getContent() {
                if (content == null) {
                    content = new ArrayList<Serializable>();
                }
                return this.content;
            }


            /**
             * <p>Java-Klasse für anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;simpleContent&gt;
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
             *       &lt;attribute name="styles" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *       &lt;attribute name="color" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *       &lt;attribute name="auto-type" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *       &lt;attribute name="page" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *       &lt;attribute name="url" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *       &lt;attribute name="hover-text" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *       &lt;attribute name="execute" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *       &lt;attribute name="open-book" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *       &lt;attribute name="give-book" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *     &lt;/extension&gt;
             *   &lt;/simpleContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class XmlObj {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "styles")
                protected String styles;
                @XmlAttribute(name = "color")
                protected String color;
                @XmlAttribute(name = "auto-type")
                protected String autoType;
                @XmlAttribute(name = "page")
                protected String page;
                @XmlAttribute(name = "url")
                protected String url;
                @XmlAttribute(name = "hover-text")
                protected String hoverText;
                @XmlAttribute(name = "execute")
                protected String execute;
                @XmlAttribute(name = "open-book")
                protected String openBook;
                @XmlAttribute(name = "give-book")
                protected String giveBook;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der styles-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getStyles() {
                    return styles;
                }

                /**
                 * Legt den Wert der styles-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setStyles(String value) {
                    this.styles = value;
                }

                /**
                 * Ruft den Wert der color-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getColor() {
                    return color;
                }

                /**
                 * Legt den Wert der color-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setColor(String value) {
                    this.color = value;
                }

                /**
                 * Ruft den Wert der autoType-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAutoType() {
                    return autoType;
                }

                /**
                 * Legt den Wert der autoType-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAutoType(String value) {
                    this.autoType = value;
                }

                /**
                 * Ruft den Wert der page-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPage() {
                    return page;
                }

                /**
                 * Legt den Wert der page-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPage(String value) {
                    this.page = value;
                }

                /**
                 * Ruft den Wert der url-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUrl() {
                    return url;
                }

                /**
                 * Legt den Wert der url-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUrl(String value) {
                    this.url = value;
                }

                /**
                 * Ruft den Wert der hoverText-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getHoverText() {
                    return hoverText;
                }

                /**
                 * Legt den Wert der hoverText-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setHoverText(String value) {
                    this.hoverText = value;
                }

                /**
                 * Ruft den Wert der execute-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getExecute() {
                    return execute;
                }

                /**
                 * Legt den Wert der execute-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setExecute(String value) {
                    this.execute = value;
                }

                /**
                 * Ruft den Wert der openBook-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOpenBook() {
                    return openBook;
                }

                /**
                 * Legt den Wert der openBook-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOpenBook(String value) {
                    this.openBook = value;
                }

                /**
                 * Ruft den Wert der giveBook-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getGiveBook() {
                    return giveBook;
                }

                /**
                 * Legt den Wert der giveBook-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setGiveBook(String value) {
                    this.giveBook = value;
                }

            }


            /**
             * <p>Java-Klasse für anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;simpleContent&gt;
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
             *       &lt;attribute name="ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *       &lt;attribute name="arg1" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *       &lt;attribute name="arg2" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *       &lt;attribute name="arg3" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *       &lt;attribute name="arg4" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *       &lt;attribute name="arg5" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *       &lt;attribute name="styles" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *       &lt;attribute name="color" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *       &lt;attribute name="auto-type" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *       &lt;attribute name="page" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *       &lt;attribute name="url" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *       &lt;attribute name="hover-text" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *       &lt;attribute name="execute" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *       &lt;attribute name="open-book" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *       &lt;attribute name="give-book" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *     &lt;/extension&gt;
             *   &lt;/simpleContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class XmlTpl {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "ref", required = true)
                protected String ref;
                @XmlAttribute(name = "arg1")
                protected String arg1;
                @XmlAttribute(name = "arg2")
                protected String arg2;
                @XmlAttribute(name = "arg3")
                protected String arg3;
                @XmlAttribute(name = "arg4")
                protected String arg4;
                @XmlAttribute(name = "arg5")
                protected String arg5;
                @XmlAttribute(name = "styles")
                protected String styles;
                @XmlAttribute(name = "color")
                protected String color;
                @XmlAttribute(name = "auto-type")
                protected String autoType;
                @XmlAttribute(name = "page")
                protected String page;
                @XmlAttribute(name = "url")
                protected String url;
                @XmlAttribute(name = "hover-text")
                protected String hoverText;
                @XmlAttribute(name = "execute")
                protected String execute;
                @XmlAttribute(name = "open-book")
                protected String openBook;
                @XmlAttribute(name = "give-book")
                protected String giveBook;

                /**
                 * Ruft den Wert der value-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Legt den Wert der value-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Ruft den Wert der ref-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getRef() {
                    return ref;
                }

                /**
                 * Legt den Wert der ref-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setRef(String value) {
                    this.ref = value;
                }

                /**
                 * Ruft den Wert der arg1-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getArg1() {
                    return arg1;
                }

                /**
                 * Legt den Wert der arg1-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setArg1(String value) {
                    this.arg1 = value;
                }

                /**
                 * Ruft den Wert der arg2-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getArg2() {
                    return arg2;
                }

                /**
                 * Legt den Wert der arg2-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setArg2(String value) {
                    this.arg2 = value;
                }

                /**
                 * Ruft den Wert der arg3-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getArg3() {
                    return arg3;
                }

                /**
                 * Legt den Wert der arg3-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setArg3(String value) {
                    this.arg3 = value;
                }

                /**
                 * Ruft den Wert der arg4-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getArg4() {
                    return arg4;
                }

                /**
                 * Legt den Wert der arg4-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setArg4(String value) {
                    this.arg4 = value;
                }

                /**
                 * Ruft den Wert der arg5-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getArg5() {
                    return arg5;
                }

                /**
                 * Legt den Wert der arg5-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setArg5(String value) {
                    this.arg5 = value;
                }

                /**
                 * Ruft den Wert der styles-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getStyles() {
                    return styles;
                }

                /**
                 * Legt den Wert der styles-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setStyles(String value) {
                    this.styles = value;
                }

                /**
                 * Ruft den Wert der color-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getColor() {
                    return color;
                }

                /**
                 * Legt den Wert der color-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setColor(String value) {
                    this.color = value;
                }

                /**
                 * Ruft den Wert der autoType-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAutoType() {
                    return autoType;
                }

                /**
                 * Legt den Wert der autoType-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAutoType(String value) {
                    this.autoType = value;
                }

                /**
                 * Ruft den Wert der page-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPage() {
                    return page;
                }

                /**
                 * Legt den Wert der page-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPage(String value) {
                    this.page = value;
                }

                /**
                 * Ruft den Wert der url-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUrl() {
                    return url;
                }

                /**
                 * Legt den Wert der url-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUrl(String value) {
                    this.url = value;
                }

                /**
                 * Ruft den Wert der hoverText-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getHoverText() {
                    return hoverText;
                }

                /**
                 * Legt den Wert der hoverText-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setHoverText(String value) {
                    this.hoverText = value;
                }

                /**
                 * Ruft den Wert der execute-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getExecute() {
                    return execute;
                }

                /**
                 * Legt den Wert der execute-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setExecute(String value) {
                    this.execute = value;
                }

                /**
                 * Ruft den Wert der openBook-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOpenBook() {
                    return openBook;
                }

                /**
                 * Legt den Wert der openBook-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOpenBook(String value) {
                    this.openBook = value;
                }

                /**
                 * Ruft den Wert der giveBook-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getGiveBook() {
                    return giveBook;
                }

                /**
                 * Legt den Wert der giveBook-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setGiveBook(String value) {
                    this.giveBook = value;
                }

            }

        }

    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="give" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="open" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="giveremote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="openremote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "give",
        "open",
        "giveremote",
        "openremote"
    })
    public static class XmlPermissions {

        protected String give;
        protected String open;
        protected String giveremote;
        protected String openremote;

        /**
         * Ruft den Wert der give-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGive() {
            return give;
        }

        /**
         * Legt den Wert der give-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGive(String value) {
            this.give = value;
        }

        /**
         * Ruft den Wert der open-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOpen() {
            return open;
        }

        /**
         * Legt den Wert der open-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOpen(String value) {
            this.open = value;
        }

        /**
         * Ruft den Wert der giveremote-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGiveremote() {
            return giveremote;
        }

        /**
         * Legt den Wert der giveremote-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGiveremote(String value) {
            this.giveremote = value;
        }

        /**
         * Ruft den Wert der openremote-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOpenremote() {
            return openremote;
        }

        /**
         * Legt den Wert der openremote-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOpenremote(String value) {
            this.openremote = value;
        }

    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="template" type="{}template" maxOccurs="unbounded"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "template"
    })
    public static class XmlTemplates {

        @XmlElement(required = true)
        protected List<XmlTemplate> template;

        /**
         * Gets the value of the template property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the template property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTemplate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link XmlTemplate }
         * 
         * 
         */
        public List<XmlTemplate> getTemplate() {
            if (template == null) {
                template = new ArrayList<XmlTemplate>();
            }
            return this.template;
        }

    }

}
