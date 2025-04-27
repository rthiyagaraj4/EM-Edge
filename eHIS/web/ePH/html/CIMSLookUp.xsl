<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output
	method="html"
	omit-xml-declaration="yes"
	indent="no"/>
	<xsl:template match="/">
	<html>
		<head>
 		    <title>MIMS Drug Lookup</title>
			<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
			<style>
				table.SUHCIMS{width="100%" border=1 cellpadding="0" cellspacing="0"}
				td.interaction{BACKGROUND-COLOR: #FFFFFF;  FONT-SIZE: 11pt ; BORDER-STYLE: SOLID;border-left-color: #D5E2E5; border-right-color: #D5E2E5;border-top-color: #D5E2E5;border-bottom-color: #D5E2E5;height:18;text-align:LEFT;}
			</style>
			<script>
				function closeSearch(obj){
					parent.window.returnValue =trimString(obj.innerText);
					parent.window.close();
				}
			</script>
		</head>
		<body>
			<form name="frmCIMSLookUp" id="Look Up" >
				<xsl:apply-templates select="Result"/>
			</form>
		</body>
	  </html>
	</xsl:template>
	
	<xsl:template match="Result">
		<xsl:apply-templates/>
	</xsl:template>

	  <xsl:template match="List">
		<xsl:variable name="GGPI_COUNT" select="count(GGPI)"/>
		<xsl:variable name="PRODUCT_COUNT" select="count(Product)"/>
		<xsl:variable name="GENERIC_COUNT" select="count(GenericItem)"/>
		<xsl:variable name="MOLECULE_COUNT" select="count(Molecule)"/>
		<xsl:variable name="SUBSTANCE_COUNT" select="count(SubstanceClass)"/>
		<xsl:variable name="ACTIVE_COMPOSITION_GROUP_COUNT" select="count(ActiveCompositionGroup)"/>
		<table class="SUHCIMS">
			<xsl:if test="$GGPI_COUNT &gt; 0 or $PRODUCT_COUNT &gt; 0 or $GENERIC_COUNT &gt; 0 or $MOLECULE_COUNT &gt; 0 or $SUBSTANCE_COUNT &gt; 0 or $ACTIVE_COMPOSITION_GROUP_COUNT &gt; 0"> 
				<tr>
					<td CLASS="interaction">
						<b>
							<xsl:if test="$GGPI_COUNT &gt; 0"> GGPI </xsl:if>
							<xsl:if test="$PRODUCT_COUNT &gt; 0"> Product </xsl:if>
							<xsl:if test="$GENERIC_COUNT &gt; 0"> GenericItem </xsl:if>
							<xsl:if test="$MOLECULE_COUNT &gt; 0"> Molecule </xsl:if>
							<xsl:if test="$SUBSTANCE_COUNT &gt; 0"> SubstanceClass </xsl:if>
							<xsl:if test="$ACTIVE_COMPOSITION_GROUP_COUNT &gt; 0"> ActiveCompositionGroup </xsl:if>
							Code
						</b>
					</td>	
					<td CLASS="interaction"><b>Drug Name</b></td>	 	  
				</tr>
				<xsl:if test="$GGPI_COUNT &gt; 0"> 
 					<xsl:for-each select="GGPI">
					<tr>
						<td width="45%" CLASS="interaction"><a href="#" onClick="closeSearch(this)" > <xsl:value-of select="@reference"/>
						</a>
						
						</td>	
						<td CLASS="interaction"><xsl:value-of select="@name"/></td>	 	  
					</tr>
				 	</xsl:for-each>
				</xsl:if> 
				<!--<xsl:for-each select="Result/List/Product">-->
				<xsl:if test="$PRODUCT_COUNT &gt; 0"> 
					<xsl:for-each select="Product">
						<tr>
							<td width="45%" CLASS="interaction"><a href="#" onClick="closeSearch(this)"><xsl:value-of select="@reference"/></a></td>	
							<td CLASS="interaction"><xsl:value-of select="@name"/></td>	 	  
						</tr>
					</xsl:for-each>
				</xsl:if>
				<xsl:if test="$GENERIC_COUNT &gt; 0"> 
					<xsl:for-each select="GenericItem">
						<tr>
							<td width="45%" CLASS="interaction"><a href="#" onClick="closeSearch(this)"><xsl:value-of select="@reference"/></a></td>	
							<td CLASS="interaction"><xsl:value-of select="@name"/></td>	 	  
						</tr>
					</xsl:for-each>
				</xsl:if>
				<xsl:if test="$MOLECULE_COUNT &gt; 0"> 
					<xsl:for-each select="Molecule">
						<tr>
							<td width="45%" CLASS="interaction"><a href="#" onClick="closeSearch(this)"><xsl:value-of select="@reference"/></a></td>	
							<td CLASS="interaction"><xsl:value-of select="@name"/></td>	 	  
						</tr>
					</xsl:for-each>
				</xsl:if>
				<xsl:if test="$SUBSTANCE_COUNT &gt; 0"> 
					<xsl:for-each select="SubstanceClass">
						<tr>
							<td width="45%" CLASS="interaction"><a href="#" onClick="closeSearch(this)"><xsl:value-of select="@reference"/></a></td>	
							<td CLASS="interaction"><xsl:value-of select="@name"/></td>	 	  
						</tr>
					</xsl:for-each>
				</xsl:if>
				<xsl:if test="$ACTIVE_COMPOSITION_GROUP_COUNT &gt; 0"> 
					<xsl:for-each select="ActiveCompositionGroup">
						<tr>
							<td width="45%" CLASS="interaction"><a href="#" onClick="closeSearch(this)"><xsl:value-of select="@reference"/></a></td>	
							<td CLASS="interaction"><xsl:value-of select="@name"/></td>	 	  
						</tr>
					</xsl:for-each>
				</xsl:if>
				

			</xsl:if>
		    </table>
		</xsl:template>	

</xsl:stylesheet>  
 


