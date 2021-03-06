//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.31 at 07:55:34 PM CEST 
//


package com.mcmiddleearth.plugins.dynamicbooks.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for template complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the name property.
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
     * Sets the value of the name property.
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
     * Gets the value of the options property.
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
     * Sets the value of the options property.
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
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
         * Gets the value of the autoType property.
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
         * Sets the value of the autoType property.
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
         * Gets the value of the color property.
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
         * Sets the value of the color property.
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
         * Gets the value of the execute property.
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
         * Sets the value of the execute property.
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
         * Gets the value of the giveBook property.
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
         * Sets the value of the giveBook property.
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
         * Gets the value of the hoverText property.
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
         * Sets the value of the hoverText property.
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
         * Gets the value of the openBook property.
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
         * Sets the value of the openBook property.
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
         * Gets the value of the page property.
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
         * Sets the value of the page property.
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
         * Gets the value of the styles property.
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
         * Sets the value of the styles property.
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
         * Gets the value of the url property.
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
         * Sets the value of the url property.
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
