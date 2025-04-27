<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : RecClinicalNotesTemplateDispay.xsl
    Created on : December 18, 2003, 9:40 AM
    Author     : arvindkrishnan
    Description:
                This transformation is to view the template in a sentence mode where the user would not be able
                to enter anything into the components. This would help the user in viewing the template in a sentence format.
                Only the components that have been entered into would be viewed after this transformation. The values would be seperated 
                by semicolons
-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html"/>
	<!--======================start of parsing================================-->
	<xsl:template match="DOCUMENT">
		<html>
			<head>
				<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"/>
				<xsl:apply-templates select="STYLE"/>
			</head>
			<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
				<form>
					<xsl:attribute name="name"><xsl:value-of select="@FORM-NAME"/></xsl:attribute>
					<table width="100%" border="2" cellspacing="0" cellpadding="0" style="font-family:Verdana">
						<tbody>
							<xsl:variable name="testvalue">0</xsl:variable>
							<xsl:apply-templates/>
							<xsl:apply-templates select="FREE-TAG"/>
						</tbody>
					</table>
				</form>
			</body>
		</html>
	</xsl:template>

	<xsl:template match="GRID">
		<table border="1" width="100%">		
			<xsl:apply-templates/>			
		</table>		
	</xsl:template>
	<xsl:template match="GRID-TH">			
		<thead>	
			<tr>
				<xsl:for-each select="TH">				
					<th><xsl:value-of select="."/></th>
				</xsl:for-each>			
			</tr>
		</thead>
	</xsl:template>	
	<xsl:template match="GRID-ROW">
		<tr>
			<xsl:apply-templates/>
		</tr>
	</xsl:template>
	<xsl:template match="GRID-COL">
		<td>
			<xsl:apply-templates/>
		</td>
	</xsl:template>
	<!--grid component ends-->
	<!--Multi choice component starts-->
	<xsl:template match="MULTI-LIST">
		<tr>
			<td>
				<font style="COLOR:black;FONT-SIZE:9pt;font-weight:bold;">
					<xsl:value-of select="@HEADER"/>
				</font>
			</td>
			<td>
				<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">
					:&#160;&#160;&#160;
				</font>
			</td>
			<td>
				<xsl:apply-templates/>
			</td>
		</tr>
	</xsl:template>
	
	<xsl:template match="MULTI-LIST-ROW">
		<xsl:apply-templates/>
	</xsl:template>
	<xsl:template match="MULTI-LIST-DATA">
		<xsl:choose>
			<xsl:when test="@SELECTED='true'">
					<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;">
					<xsl:if test="../../@LIST_SELECTION = 'S'">
						<xsl:value-of select="."/>
					</xsl:if>
					<xsl:if test="../../@LIST_SELECTION = 'M'" >
						<xsl:value-of select="."/>,
					</xsl:if>
				</font>
			</xsl:when>
		</xsl:choose>
	</xsl:template>
	<xsl:template match="TEXT">
		<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;">
			<xsl:value-of select="@VALUE"/>
		</font>
	</xsl:template>
	<!--Multi choice Component ends-->
	<xsl:template match="USER-TEMPLATE">
		<table border="0" cellpadding='0' cellspacing='4' width="100%" style="font-family:Verdana">
			<xsl:for-each select="ROW">			
				<xsl:for-each select="COL">
					<xsl:choose>
						<xsl:when test="not(node())">							
							<td colspan="3">&#160; </td>
						</xsl:when>
						<xsl:otherwise> 							
							<xsl:apply-templates/>
						 </xsl:otherwise>
					</xsl:choose> 	    
					<!-- <xsl:apply-templates/> -->
				</xsl:for-each>
				<xsl:apply-templates select="EMPTY-ROW"/>
			</xsl:for-each>
		</table>		 
		<xsl:apply-templates select="USER-TEMPLATE-ADDENDUM"/>
	</xsl:template>
	<!--===========================================================================================-->
	<!--==================for Paragraph template =========================-->
	<xsl:template match="PARAGRAPH">
		<tr>
			<td align="left" class="QRYEVEN" colspan="2" style="COLOR:navy;FONT-SIZE:9pt;font-weight:normal;hyphens:auto;"  >
				<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
				<xsl:attribute name="class"><xsl:value-of select="@CLASS"/></xsl:attribute>
				<xsl:apply-templates/>
			</td>
		</tr>
	</xsl:template>
	

	<!--========================================================================================-->
	<!--==================for Formula template =========================-->
	<xsl:template match="FORMULA-COMP">
		<xsl:if test="not(/USER-TEMPLATE/@ONLYFILLED) or /USER-TEMPLATE/@ONLYFILLED = 'N' or (/USER-TEMPLATE/@ONLYFILLED = 'Y' and @VALUE != '' ) or @GRID-COMP='Y' or @MATRIX-COMP='Y' ">
		<tr>
			<td>
				<xsl:attribute name="class"><xsl:value-of select="@CLASS"/></xsl:attribute>
				<!--<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>-->
				<xsl:attribute name="align"><xsl:value-of select="@ALIGN"/></xsl:attribute>
				<font>
					<xsl:attribute name="style">FONT-SIZE:9pt;font-weight:bold;</xsl:attribute>
					<xsl:value-of select="@PROMPT"/>&#160;&#160;&#160;
				</font>
			</td>
			<td>
				<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">
					:&#160;&#160;&#160;
				</font>
			</td>
			<td>
				<font>
					<xsl:attribute name="style">COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;</xsl:attribute>
					<xsl:value-of select="@VALUE"/>
				</font>
				<xsl:if test="@VALUE != ''">
					<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">
						&#160;<xsl:value-of select="@UNIT"/>
					</font>
				</xsl:if>
			</td>
		</tr>
		</xsl:if>
	</xsl:template>	
	<!--===========================================================================================-->
	<!--=======================================for Text Area in short text=========================-->
	<xsl:template match="SHORT-TEXT">
		<xsl:if test="@GRID-COMP='Y'">
			<xsl:choose>
				<xsl:when test="@GRID-COMP">						
					<xsl:call-template name="SHORT-TEXT-WTD">
						<xsl:with-param name="GRID-NAME" select="@GRID-NAME"/>
						<xsl:with-param name="GRID-COMP" select="@GRID-COMP"/>			
					</xsl:call-template>						
				</xsl:when>
				<xsl:otherwise>&nbsp;					
				</xsl:otherwise>
			</xsl:choose>
		</xsl:if>
	</xsl:template>
	<xsl:template name="SHORT-TEXT-WTD" match="SHORT-TEXT-WTD">
		<xsl:value-of select="."/>	
		<font>
			<xsl:if test="@GRID-COMP|@MATRIX-COMP">
				<xsl:attribute name="style">
					COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;hyphens:auto; <!--IN066793 -->
				</xsl:attribute>
			</xsl:if>
			<xsl:if test="not(@GRID-COMP|@MATRIX-COMP)">
				<xsl:attribute name="style">
					COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;hyphens:auto; <!--IN066793 -->
				</xsl:attribute>
			</xsl:if>
			<!-- <xsl:value-of select="." disable-output-escaping="yes"/> -->
			
			<xsl:choose>
				<xsl:when test="contains($text, '&#xA;')">
					<xsl:call-template name="SHORT-TEXT-WTS">
						<xsl:with-param name="subtext" select="substring-before($text, '&#xA;')"/>
					</xsl:call-template>
					<br/> 
					<xsl:call-template name="SHORT-TEXT-WTD">
						<xsl:with-param name="text" select="substring-after($text,'&#xA;')"/>
					</xsl:call-template>
				</xsl:when>		
					
				<xsl:otherwise>
					<xsl:call-template name="SHORT-TEXT-WTS">
						<xsl:with-param name="subtext" select="$text"/>
					</xsl:call-template>
				</xsl:otherwise>
			</xsl:choose>
		</font>
	</xsl:template>
	<xsl:template name="SHORT-TEXT-WTS" match="SHORT-TEXT-WTS">
		<xsl:param name="subtext"/>	
	    <xsl:choose>
			<xsl:when test="contains($subtext, '&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;')"> 
				<xsl:variable name="firststr" select="substring($subtext,2,1)"/>
				<xsl:if test="$firststr = '&#x20;'">&#160;
					<xsl:call-template name="SHORT-TEXT-WTS">
						<xsl:with-param name="subtext" select="substring($subtext,2)"/>
					</xsl:call-template>
				</xsl:if>
				<xsl:if test="not($firststr = '&#x20;')">&#160;
					<xsl:value-of select="substring-before($subtext,'&#x20;')"/>										 					
					 <xsl:call-template name="SHORT-TEXT-WTS">
						<xsl:with-param name="subtext" select="substring-after($subtext,'&#x20;')"/>
					</xsl:call-template>  
				</xsl:if>
			
			</xsl:when>
			<xsl:otherwise>				
				<xsl:value-of select="$subtext"/> 
			</xsl:otherwise>
	    </xsl:choose>	
   </xsl:template>
	<!--===========================================================================================-->
	<!--=======================================for Text Area in LONG text=========================-->
	<xsl:template match="LONG-TEXT">
		<xsl:if test="not(/USER-TEMPLATE/@ONLYFILLED) or /USER-TEMPLATE/@ONLYFILLED = 'N' or (/USER-TEMPLATE/@ONLYFILLED = 'Y' and text() != '' ) ">
			<tr>
				<td width="20%" valign="top">
					<xsl:attribute name="nowrap"></xsl:attribute>
					<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">
						<xsl:value-of select="@PROMPT"/>
					</font>
					<font color="#E2E3F0">&#160;</font>
				</td>
				<td valign="top" width="3%">
					<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">
						:&#160;&#160;&#160;
					</font>
				</td>
				<td  align="left">				 
				<xsl:attribute name="style">hyphens:auto</xsl:attribute>				
				<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;">					
					 <xsl:call-template name="LONG-TEXT-WTD"/> 
				</font>
				</td>
			</tr>
		</xsl:if>
	</xsl:template>
	<xsl:template name="LONG-TEXT-WTD" match="LONG-TEXT-WTD">
			<xsl:param name="text" select="."/>
		<!--<xsl:value-of select="$text"/>-->
		 <xsl:choose>
			<xsl:when test="contains($text, '&#xA;')">			
				<xsl:call-template name="LONG-TEXT-WTS">
					<xsl:with-param name="subtext" select="substring-before($text, '&#xA;')"/>
				</xsl:call-template>
				<br/>
				<xsl:call-template name="LONG-TEXT-WTD">
					<xsl:with-param name="text" select="substring-after($text,'&#xA;')"/>
				</xsl:call-template>
			</xsl:when>
						
			<xsl:otherwise>				
				<xsl:call-template name="LONG-TEXT-WTS">
					<xsl:with-param name="subtext" select="$text"/>
				</xsl:call-template>
			</xsl:otherwise>
		</xsl:choose> 
	</xsl:template>
	<xsl:template name="LONG-TEXT-WTS" match="LONG-TEXT-WTS">
		<xsl:param name="subtext"/>
		<xsl:choose>
			<xsl:when test="contains($subtext, '&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;&#x20;')"> 
				<xsl:variable name="firststr" select="substring($subtext,2,1)"/>
				<xsl:if test="$firststr = '&#x20;'">&#160;
					<xsl:call-template name="LONG-TEXT-WTS">
						<xsl:with-param name="subtext" select="substring($subtext,2)"/>
					</xsl:call-template>
				</xsl:if>
				<xsl:if test="not($firststr = '&#x20;')">&#160;
					<xsl:value-of select="substring-before($subtext,'&#x20;')"/>
					<xsl:call-template name="LONG-TEXT-WTS">
						<xsl:with-param name="subtext" select="substring-after($subtext,'&#x20;')" />
					</xsl:call-template>
				</xsl:if>
			
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="$subtext"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<!--===========================================================================================-->
	<!--=======================================for Title Text =========================-->
	<xsl:template match="TITLE-TEXT">
		<component> 
			<section> 
				<!-- <code code="11450-4" codeSystem="2.16.840.1.113883.6.1" codeSystemName="LOINC" displayName="Problem List"/>  -->
				<title><xsl:value-of select="."/>	</title>			
				<text>
					<xsl:call-template name="GRID"/>				
				</text> 
				<!-- <confidentialityCode code="R" codeSystem="2.16.840.1.113883.5.25"/> -->
			</section> 
		</component> 		
	</xsl:template>
	<!--===========================================================================================-->
	<!--==================for DATE,TIME,DATE/TIME,INTEGER,DECIMAL FIELD =========================-->
	<xsl:template match="DATE-TIME-NUMERIC">
		<xsl:if test="@GRID-COMP='Y'">
			<xsl:choose>
				<xsl:when test="(@GRID-COMP)">											
					<xsl:call-template name="DATE-TIME-NUMERIC-WTD"/>						
				</xsl:when>
				<xsl:otherwise>		
					&#160;						
				</xsl:otherwise>
			</xsl:choose>
		</xsl:if>
	</xsl:template>
	<xsl:template name="DATE-TIME-NUMERIC-WTD" match="DATE-TIME-NUMERIC-WTD">
		<xsl:value-of select="@VALUE"/>		
	</xsl:template>
	<!--========================================================================================-->
	<!--====================================for script ================================-->
	<xsl:template match="SCRIPT">
    <script>
        <xsl:if test="@LANGUAGE">
            <xsl:attribute name="language"><xsl:value-of select="@LANGUAGE"/></xsl:attribute>
        </xsl:if>
        <xsl:if test="@TYPE">
            <xsl:attribute name="type"><xsl:value-of select="@TYPE"/></xsl:attribute>
        </xsl:if>
        <xsl:if test="@SRC">
            <xsl:attribute name="src"><xsl:value-of select="@SRC"/></xsl:attribute>
        </xsl:if>
        <xsl:value-of select="."/>
    </script>
	</xsl:template>
	<!--=====================================================================================-->
	<!--====================================for CSS Style ================================-->
	<xsl:template match="STYLE">
		<style>
			<xsl:attribute name="type"><xsl:value-of select="@TYPE"/></xsl:attribute>
			<xsl:value-of select="."/>
		</style>
	</xsl:template>
	<!--=====================================================================================-->
	<!--================for any extra thigs added from the jsp page directly ================-->
	<xsl:template match="FREE-TAG">
		<xsl:value-of select="." disable-output-escaping="yes"/>
<!--		<xsl:call-template name="TEXT-DISP"/>  -->
	</xsl:template>
<!--
       <xsl:template name="TEXT-DISP" match="TEXT-DISP">
  	<xsl:param name="text" select="."/>
	<xsl:choose>

		<xsl:when test="contains($text, '&#60;br/&#62;')">
		<xsl:value-of select="substring-before($text, '&#60;br/&#62;')"/>
			<br/>
			<xsl:call-template name="TEXT-DISP">
				<xsl:with-param name="text" select="substring-after($text,'&#60;br/&#62;')"/>
			</xsl:call-template>
		</xsl:when>

		<xsl:when test="contains($text, '&amp;#160;')">
		<xsl:value-of select="substring-before($text, '&amp;#160;')"/>
			&nbsp;
			<xsl:call-template name="TEXT-DISP">
				<xsl:with-param name="text" select="substring-after($text,'&amp;#160;')"/>
			</xsl:call-template>
		</xsl:when>

		<xsl:otherwise>
			<xsl:value-of select="$text"/>
		</xsl:otherwise>
	 </xsl:choose>
	</xsl:template>
-->
	<!--=====================================================================================-->
	<!--==================for Simple Data to be shown in TD =========================-->
	<xsl:template match="TD-DATA">
		<td>
			<xsl:attribute name="style">hyphens:auto</xsl:attribute>
			<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
			<xsl:attribute name="class"><xsl:value-of select="@CLASS"/></xsl:attribute>
			<xsl:attribute name="align"><xsl:value-of select="@ALIGN"/></xsl:attribute>
			<xsl:apply-templates/>
			<xsl:if test="@TAG='N'">
				<xsl:value-of select="."/>
			</xsl:if>
		</td>
	</xsl:template>
	<!--========================================================================================-->
	<!--=====================for Addendum to inserted as part of template====================-->
	<xsl:template match="USER-TEMPLATE-ADDENDUM">
	<tr>
		<td colspan="3">
			<table border="0" cellspacing="0" width="100%" style="font-face:verdana:font-size:9pt;">
				<tr>
					<td width="100%" colspan ="8" style="font-family:Verdana;font-size:9pt">
						<I>Addendum Created By: <xsl:value-of select="@CREATED-BY"/>, Date/Time: <xsl:value-of select="@DATE"/>
						</I>
					</td>
				</tr>
				<tr>
					<td class="BODYCOLORFILLED" colspan ="8" width="100%" style="font-family:Verdana;font-size:9pt;hyphens:auto;">
						<!-- <xsl:value-of select="."/> -->
						<xsl:call-template name="LONG-TEXT-WTD"/> 
					</td>
				</tr>
			</table>
		</td>
	</tr>
	</xsl:template>
	<xsl:template match="PRE">
	<xsl:value-of select="." disable-output-escaping="yes"/>
<!--		<xsl:call-template name="TEXT-DISP"/>  -->
	</xsl:template>
	<!--========================================================================================-->
</xsl:stylesheet>
