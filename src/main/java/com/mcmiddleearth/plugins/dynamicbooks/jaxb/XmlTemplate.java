//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2021.12.04 um 01:37:14 AM CET 
//


package com.mcmiddleearth.plugins.dynamicbooks.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für template complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="template"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="options"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="auto-type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="color" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="execute" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="give-book" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="hover-text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="open-book" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="page" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="styles" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "template", propOrder = {
    "name",
    "options"
})
public class XmlTemplate {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected XmlTemplate.XmlOptions options;

    /**
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Ruft den Wert der options-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XmlTemplate.XmlOptions }
     *     
     */
    public XmlTemplate.XmlOptions getOptions() {
        return options;
    }

    /**
     * Legt den Wert der options-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlTemplate.XmlOptions }
     *     
     */
    public void setOptions(XmlTemplate.XmlOptions value) {
        this.options = value;
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
     *         &lt;element name="auto-type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="color" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="execute" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="give-book" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="hover-text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="open-book" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="page" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="styles" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
        "autoType",
        "color",
        "execute",
        "giveBook",
        "hoverText",
        "openBook",
        "page",
        "styles",
        "url"
    })
    public static class XmlOptions {

        @XmlElement(name = "auto-type", required = true)
        protected String autoType;
        @XmlElement(required = true)
        protected String color;
        @XmlElement(required = true)
        protected String execute;
        @XmlElement(name = "give-book", required = true)
        protected String giveBook;
        @XmlElement(name = "hover-text", required = true)
        protected String hoverText;
        @XmlElement(name = "open-book", required = true)
        protected String openBook;
        @XmlElement(required = true)
        protected String page;
        @XmlElement(required = true)
        protected String styles;
        @XmlElement(required = true)
        protected String url;

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

    }

}
