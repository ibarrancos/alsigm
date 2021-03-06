//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v@@BUILD_VERSION@@ 
// 	See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 	Any modifications to this file will be lost upon recompilation of the source schema. 
// 	Generated on: 2011.07.04 en 12:38:50 CEST 
//


package org.notariado.ancert.xml.plusvalias.liquidacion;


/**
 * Java content class for DireccionExtranjeraType complex type.
 * 	<p>The following schema fragment specifies the expected 	content contained within this java content object. 	(defined at file:/C:/Sun/jwsdp-1.5/jaxb/bin/IIVTNU-WS-Ayto.xsd line 961)
 * <p>
 * <pre>
 * &lt;complexType name="DireccionExtranjeraType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PAIS" type="{http://ancert.notariado.org/XML/Plusvalias/Liquidacion}CODIGO_PAISType"/>
 *         &lt;element name="EST_PRV" minOccurs="0">
 *           &lt;restriction base="{http://ancert.notariado.org/XML/Plusvalias/Liquidacion}STRINGType">
 *             &lt;maxLength value="40"/>
 *             &lt;minLength value="1"/>
 *           &lt;/restriction>
 *         &lt;/element>
 *         &lt;element name="DESC_MUNICIPIO">
 *           &lt;restriction base="{http://ancert.notariado.org/XML/Plusvalias/Liquidacion}POBLACIONType">
 *             &lt;minLength value="1"/>
 *           &lt;/restriction>
 *         &lt;/element>
 *         &lt;element name="DIRECCION_NO_ESTRUCTURADA">
 *           &lt;restriction base="{http://ancert.notariado.org/XML/Plusvalias/Liquidacion}STRINGType">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="255"/>
 *           &lt;/restriction>
 *         &lt;/element>
 *         &lt;element name="DISTRITO_POSTAL" minOccurs="0">
 *           &lt;restriction base="{http://ancert.notariado.org/XML/Plusvalias/Liquidacion}STRINGType">
 *             &lt;maxLength value="10"/>
 *             &lt;minLength value="1"/>
 *           &lt;/restriction>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface DireccionExtranjeraType {


    /**
     * Nombre del municipio
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getDESCMUNICIPIO();

    /**
     * Nombre del municipio
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setDESCMUNICIPIO(java.lang.String value);

    /**
     * Estado o provincia
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getESTPRV();

    /**
     * Estado o provincia
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setESTPRV(java.lang.String value);

    /**
     * Direcci�n completa de residencia en formato texto libre.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getDIRECCIONNOESTRUCTURADA();

    /**
     * Direcci�n completa de residencia en formato texto libre.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setDIRECCIONNOESTRUCTURADA(java.lang.String value);

    /**
     * Distrito postal
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getDISTRITOPOSTAL();

    /**
     * Distrito postal
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setDISTRITOPOSTAL(java.lang.String value);

    /**
     * C�digo de pa�s, seg�n la codificaci�n oficial de Pa�ses y Territorios aprobada por OM 9-12-99
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getPAIS();

    /**
     * C�digo de pa�s, seg�n la codificaci�n oficial de Pa�ses y Territorios aprobada por OM 9-12-99
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setPAIS(java.lang.String value);

}
