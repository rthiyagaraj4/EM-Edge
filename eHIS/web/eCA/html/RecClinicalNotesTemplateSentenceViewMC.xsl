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
				<link rel='StyleSheet' type='text/css' >
				 <xsl:attribute name="href">../../eCA/html/SpecialityStyle.css</xsl:attribute>
				</link>

				<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"/>
				<xsl:apply-templates select="STYLE"/> -->
			</head>
			<body onKeyDown='lockKey()'>
				<form>
					<xsl:attribute name="name"><xsl:value-of select="@FORM-NAME"/></xsl:attribute>
					<xsl:apply-templates/>
					<xsl:apply-templates select="FREE-TAG"/>
				</form>
			</body>
		</html>
	</xsl:template>
	<!--=====================================================================================-->
	<!--======================traversing through the template================================-->
	<!--Matrix Component starts-->
	<xsl:template match="MATRIX">
		<tr>
			<td align="center" colspan="3">
				<table border="1" width="95%" cellspacing="0" cellpadding="1" class='MCTABLE'>
					<xsl:attribute name="ID"><xsl:value-of select="@NAME"/></xsl:attribute>
					<xsl:apply-templates/>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="3">
			&#160;
			</td>
		</tr>
	</xsl:template>
	<xsl:template match="MATRIX-TH">
		<tr>
			<td colspan="6" class='MCLABEL'>
					<xsl:value-of select="../@MATRIX-DESC"/>
			</td>
		</tr>
		<tr>
			<td align="right" class='MCDATA'>
				 &#160;
			</td>
			<xsl:for-each select="TH">
				<th class='MCTH'>
					<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
					<xsl:attribute name="width"><xsl:value-of select="@WIDTH"/></xsl:attribute>
					<xsl:value-of select="."/>
				</th>
			</xsl:for-each>
		</tr>
	</xsl:template>
	<xsl:template match="MATRIX-ROW">
		<tr>
			<td align="left" class='MCMATRIX' style="width:250px;">
				<xsl:value-of select="@YAXISPROMPT"/>
			</td>
			<xsl:apply-templates/>
		</tr>
	</xsl:template>
	<xsl:template match="MATRIX-COL">
		<xsl:apply-templates/>
	</xsl:template>
	<!--Matrix Component ends-->
	<!--grid component starts-->
	<xsl:template match="GRID">
		<tr>
			<td colspan="3" align="center">
				<table border="1" width="95%" cellspacing="0" cellpadding="1" class='MCTABLE'>
					<xsl:attribute name="ID"><xsl:value-of select="@NAME"/></xsl:attribute>
					<xsl:apply-templates/>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="3">
			&#160;
			</td>
		</tr>
	</xsl:template>
	<xsl:template match="GRID-TH">
		<tr>
			<td align="left" colspan="100" class='MCLABEL'>
					<xsl:value-of select="../@DESCRIPTION"/>
			</td>
		</tr>
		<tr>
			<xsl:for-each select="EMPTY-TH">
				<th class='MCTH'>
					 &#32;
				</th>
			</xsl:for-each>
			<xsl:for-each select="TH">
				<th class='MCTH'>
					<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
					<xsl:value-of select="."/>
				</th>
			</xsl:for-each>
		</tr>
	</xsl:template>
	<xsl:template match="EMPTY-COLUMN">
		<xsl:if test="@GRID-COMP|@MATRIX-COMP">
			<td>
				
				<xsl:if test="@GRID-COMP|@MATRIX-COMP">
					<xsl:attribute name="width">
						 5%
					</xsl:attribute>
				</xsl:if>
				<xsl:if test="@MATRIX-COMP = 'Y'">
					<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
					 &#160;
				 </xsl:if>
			</td>
		</xsl:if>
	</xsl:template>
	<xsl:template match="GRID-ROW">
		<tr>
			<xsl:apply-templates/>
		</tr>
	</xsl:template>
	<xsl:template match="GRID-COL">
		<xsl:apply-templates/>
	</xsl:template>
	<!--grid component ends-->
	<!--Multi choice component starts-->
	<xsl:template match="MULTI-LIST">

		<tr>
			<td class='MCLABEL'>
					<xsl:value-of select="@HEADER"/>
			</td>
			<td class='MCDATA'>
					<b>:</b>&#160;&#160;&#160;
			</td>
			<td class='MCDATA'>
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
					<xsl:if test="../../@LIST_SELECTION = 'S'">
						<xsl:value-of select="."/>
					</xsl:if>
					<xsl:if test="../../@LIST_SELECTION = 'M'" >
						<xsl:value-of select="."/>,
					</xsl:if>
			</xsl:when>
		</xsl:choose>
	</xsl:template>
	<xsl:template match="TEXT">
			<xsl:value-of select="@VALUE"/>
	</xsl:template>
	<!--Multi choice Component ends-->
	<xsl:template match="USER-TEMPLATE">
	<xsl:param name="LANGID" select="@LANGID"/>
	 <center>
	   <table border='0' cellpadding='0' cellspacing='0' width='100%' style="font-family:Verdana">
            <td>
	       <table border="0" cellpadding='0' cellspacing='0' width="100%" style="font-family:Verdana">
		 <xsl:for-each select="ROW">
		  <tr>
			<xsl:for-each select="COL">
				 <xsl:apply-templates>
					<xsl:with-param name="LANGID" select="$LANGID"/>
				</xsl:apply-templates>
			</xsl:for-each>
			<xsl:apply-templates select="EMPTY-ROW"/>
		  </tr>
		 </xsl:for-each>
		</table>
	    </td>
	   </table>
		<xsl:apply-templates select="USER-TEMPLATE-ADDENDUM"/>
	</center>
	</xsl:template>
	<!--===========================================================================================-->
	<!--==================for Paragraph template =========================-->
	<xsl:template match="PARAGRAPH">
		<tr>
			<td align="left" class="MCLABEL" colspan="2">
				<xsl:attribute name="style">hyphens:auto</xsl:attribute>
				<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
				<xsl:apply-templates/>
			</td>
		</tr>
	</xsl:template>
	

	<!--========================================================================================-->
	<!--==================for Formula template =========================-->
	<xsl:template match="FORMULA-COMP">
		<xsl:param name="LANGID"/>	
		<xsl:if test="not(/USER-TEMPLATE/@ONLYFILLED) or /USER-TEMPLATE/@ONLYFILLED = 'N' or (/USER-TEMPLATE/@ONLYFILLED = 'Y' and @VALUE != '' ) or @GRID-COMP='Y' or @MATRIX-COMP='Y' ">
		<tr>
			<td class='MCLABEL'>
				<!--<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>-->
				<xsl:attribute name="align"><xsl:value-of select="@ALIGN"/></xsl:attribute>
					<xsl:value-of select="@PROMPT"/>&#160;&#160;&#160;
			</td>
			<td class='MCDATA'>
					<b>:</b>&#160;&#160;&#160;
			</td>
			<td class='MCDATA'>
				<xsl:choose>
					 <xsl:when test="@COMPTYPE='A' and @RESULTTYPE='D' and $LANGID != 'en'">				
						<xsl:value-of select="@OTHLANGVAL"/>				
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="@VALUE"/>													
					</xsl:otherwise>		
				</xsl:choose>
				<xsl:if test="@VALUE != ''">
						&#160;<xsl:value-of select="@UNIT"/>
				</xsl:if>
			</td>
		</tr>
		</xsl:if>
	</xsl:template>
	<!--========================================================================================-->
	<!--=====================================template for text-box====================================-->
	<xsl:template match="TEXT-BOX">
		<td align="right" class='MCLABEL'>
			<!--<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>-->
			<xsl:attribute name="align"><xsl:value-of select="@ALIGN"/></xsl:attribute>
			<xsl:value-of select="@PROMPT"/>
		</td>
		<td align="left">
			<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
			<b>
				<xsl:value-of select="@VALUE"/>
			</b>
		</td>
	</xsl:template>
	<!--===========================================================================================-->
	<!--===============================template for checkbox=======================================-->
	<xsl:template match="CHECK-BOX">
		<xsl:choose>
			<xsl:when test="(@GRID-COMP|@MATRIX-COMP)">
				<td align="center" class='MCDATA'>
					<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
					<xsl:call-template name="CHECK-BOX-WTD"/>
				</td>
			</xsl:when>
			<xsl:otherwise>
				<tr>
					<td align="left" width="20%" class='MCLABEL'>
					<xsl:attribute name="nowrap"></xsl:attribute>
						<xsl:value-of select="@PROMPT"/>&#160;&#160;&#160;
					</td>
					<td width="3%" class='MCDATA'>
							<b>:</b>&#160;&#160;&#160;
					</td>
					<td align="left" class='MCDATA'>
						<xsl:attribute name="align"><xsl:value-of select="@ALIGN"/></xsl:attribute>
						<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
						<xsl:call-template name="CHECK-BOX-WTD"/>
					</td>
				</tr>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<xsl:template name="CHECK-BOX-WTD" match="CHECK-BOX-WTD">
		<xsl:if test="@VALUE='Y'">
			Yes
		</xsl:if>
		<xsl:if test="not(@VALUE)">
			No
		</xsl:if>
		<xsl:if test="@VALUE=''">
			No
		</xsl:if>
		<xsl:if test="@VALUE='N'">
			No
		</xsl:if>
		<xsl:if test="not(@GRID-COMP|@MATRIX-COMP)"/>
	</xsl:template>
	<!--===========================================================================================-->
	<!--=======================================for Combo-box===================================-->
	<xsl:template match="LIST-BOX">
		<xsl:if test="not(/USER-TEMPLATE/@ONLYFILLED) or (/USER-TEMPLATE/@ONLYFILLED = 'N' or  (/USER-TEMPLATE/@ONLYFILLED = 'Y' and count(.//DATA[@SELECTED='true']) &gt; 0)  or (@GRID-COMP|@MATRIX-COMP) ) or @STD_COMP_VALUE != '' ">
			<xsl:choose>
				<xsl:when test="(@GRID-COMP|@MATRIX-COMP)">
					<td align="center" class='MCDATA'>
						<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
						<xsl:call-template name="LIST-BOX-WTD"/>
					</td>
				</xsl:when>
				<xsl:otherwise>
					<tr>
						<td align="left" width="20%" class='MCLABEL'>
							<xsl:attribute name="nowrap"></xsl:attribute>
								<xsl:value-of select="@PROMPT"/>&#160;&#160;&#160;
						</td>
						<td width="3%" class='MCDATA'>
								<b>:</b>&#160;&#160;&#160;
						</td>
						<td align="left" class='MCDATA'>
							<xsl:choose>
								<xsl:when test="@STD_COMP_RESULT_TYPE != ''">
									<xsl:choose>
										<xsl:when test="@STD_COMP_RESULT_TYPE ='L'">
												<xsl:value-of select="@STD_COMP_VALUE"/>
										</xsl:when>
										<xsl:otherwise>
										</xsl:otherwise>
									</xsl:choose>
								</xsl:when>
								<xsl:otherwise>
									<xsl:call-template name="LIST-BOX-WTD"/>
								</xsl:otherwise>
							</xsl:choose>
							<xsl:if test="@MANDATORY='Y'">
								&#32;
								<image src="../../eCommon/images/mandatory.gif"/>
							   </xsl:if>
						</td>
					</tr>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:if>
	</xsl:template>
	<xsl:template name="LIST-BOX-WTD" match="LIST-BOX-WTD">
		
		<xsl:choose>
		  <xsl:when test="@STD_COMP_RESULT_TYPE ='L'">
			<xsl:value-of select="@STD_COMP_VALUE"/>
		  </xsl:when>
		<xsl:otherwise>
		<xsl:for-each select="DATA">
			<xsl:if test="@SELECTED='true'">
				<xsl:value-of select="."/>
			</xsl:if>
		</xsl:for-each>
		</xsl:otherwise>

		</xsl:choose>
        &#160;
   </xsl:template>
	<!--===========================================================================================-->
	<!--=======================================for Text Area in short text=========================-->
	<xsl:template match="SHORT-TEXT">
		<xsl:if test="not(/USER-TEMPLATE/@ONLYFILLED) or /USER-TEMPLATE/@ONLYFILLED = 'N' or (/USER-TEMPLATE/@ONLYFILLED = 'Y' and text() != '' ) or (@GRID-COMP='Y' or @MATRIX-COMP='Y') ">
			<xsl:choose>
				<xsl:when test="(@GRID-COMP|@MATRIX-COMP)">
					<td align="left" class='MCDATA'>
						<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
						<xsl:call-template name="SHORT-TEXT-WTD">
							<xsl:with-param name="GRID-NAME" select="@GRID-NAME"/>
							<xsl:with-param name="GRID-COMP" select="@GRID-COMP"/>
							<xsl:with-param name="MATRIX-COMP" select="@MATRIX-COMP"/>
						</xsl:call-template>
						&#160;
					</td>
				</xsl:when>
				<xsl:otherwise>
					<tr>
						<td align="left" colspan="1" valign="top" width="20%" class='MCLABEL'>
							<xsl:attribute name="nowrap"></xsl:attribute>
								<xsl:value-of select="@PROMPT"/>
						</td>
						<td width="3%" class='MCDATA'>
								<b>:</b>&#160;&#160;&#160;
						</td>
						<td class='MCDATA'>
							<xsl:attribute name="style">hyphens:auto</xsl:attribute>
							<xsl:attribute name="align"><xsl:value-of select="@ALIGN"/></xsl:attribute>
							<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
							<xsl:call-template name="SHORT-TEXT-WTD">
								<xsl:with-param name="GRID-NAME" select="@GRID-NAME"/>
								<xsl:with-param name="GRID-COMP" select="@GRID-COMP"/>
								<xsl:with-param name="MATRIX-COMP" select="@MATRIX-COMP"/>
							</xsl:call-template>
						</td>
					</tr>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:if>
	</xsl:template>
	<xsl:template name="SHORT-TEXT-WTD" match="SHORT-TEXT-WTD">
			<xsl:if test="@GRID-COMP|@MATRIX-COMP">
				
			</xsl:if>
			<xsl:if test="not(@GRID-COMP|@MATRIX-COMP)">
				
			</xsl:if>
			<xsl:value-of select="." disable-output-escaping="yes"/>                              &#160;
	</xsl:template>
	<!--===========================================================================================-->
	<!--=======================================for Text Area in LONG text=========================-->
	<xsl:template match="LONG-TEXT">
		<xsl:if test="not(/USER-TEMPLATE/@ONLYFILLED) or /USER-TEMPLATE/@ONLYFILLED = 'N' or (/USER-TEMPLATE/@ONLYFILLED = 'Y' and text() != '' ) ">
			<tr>
				<td width="20%" valign="top" class='MCLABEL'>
					<xsl:attribute name="nowrap"></xsl:attribute>
						<xsl:value-of select="@PROMPT"/>
					&#160;
				</td>
				<td valign="top" width="3%" class='MCDATA'>
						<b>:</b>&#160;&#160;&#160;
				</td>
				<td align="left" class='MCDATA'>
					<xsl:attribute name="style">hyphens:auto</xsl:attribute>
					<xsl:call-template name="LONG-TEXT-WTD"/>
				</td>
			</tr>
		</xsl:if>
	</xsl:template>
	<xsl:template name="LONG-TEXT-WTD" match="LONG-TEXT-WTD">
			<xsl:param name="text" select="."/>
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
				<xsl:if test="not($firststr = '&#x20;')">
					<xsl:value-of select="substring-before($subtext,'&#x20;')"/>
					<xsl:call-template name="LONG-TEXT-WTS">
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
	<!--=======================================for Title Text =========================-->
	<xsl:template match="TITLE-TEXT">
		<tr>
			<td>
			<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
			&#160;
			</td>
		</tr>
		<tr class='MCINNERHEADER'>
			<td>
			<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
				<xsl:if test="@TYPE='T'">
						<xsl:value-of select="."/>
				</xsl:if>
				<xsl:if test="@TYPE='C'">
						<xsl:value-of select="."/>
				</xsl:if>
			</td>
			
		</tr>
	</xsl:template>
	<!--===========================================================================================-->
	<!--==================for DATE,TIME,DATE/TIME,INTEGER,DECIMAL FIELD =========================-->
	<xsl:template match="DATE-TIME-NUMERIC">
		<xsl:if test="not(/USER-TEMPLATE/@ONLYFILLED) or /USER-TEMPLATE/@ONLYFILLED = 'N' or (/USER-TEMPLATE/@ONLYFILLED = 'Y' and @VALUE != '' ) or @GRID-COMP='Y' or @MATRIX-COMP='Y' ">
			<xsl:choose>
				<xsl:when test="(@GRID-COMP|@MATRIX-COMP)">
					<td align="center" class='MCDATA'>
						<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
						<xsl:call-template name="DATE-TIME-NUMERIC-WTD"/>
						&#160;
					</td>
				</xsl:when>
				<xsl:otherwise>
					<tr>
						<td align="left" width="20%" class='MCLABEL'>
							<xsl:attribute name="nowrap"></xsl:attribute>
								<xsl:value-of select="@PROMPT"/>
							&#160;
						</td>
						<td width="3%" class='MCDATA'>
								<b>:</b>&#160;&#160;&#160;
						</td>
						<td class='MCDATA'>
							<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
							<xsl:attribute name="align"><xsl:value-of select="@ALIGN"/></xsl:attribute>
							<xsl:call-template name="DATE-TIME-NUMERIC-WTD"/>
						</td>
					</tr>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:if>
	</xsl:template>
	<xsl:template name="DATE-TIME-NUMERIC-WTD" match="DATE-TIME-NUMERIC-WTD">
		<xsl:if test="@NUM_PREFIX_REQUIRED_YN = 'Y'">
				<xsl:value-of select="@PREFIX_CHAR"/>&#160;&#160;
		</xsl:if>

		<xsl:choose>
			<xsl:when test="@COMPTYPE='D'">
			    <xsl:value-of select="@OTHLANGVAL"/>&#160;
			</xsl:when>
			<xsl:when test="@COMPTYPE='E'">
			    <xsl:value-of select="@OTHLANGVAL"/>&#160;
			</xsl:when>
			<xsl:otherwise>
			    <xsl:value-of select="@VALUE"/>&#160;
			</xsl:otherwise>
		</xsl:choose>
				<xsl:value-of select="@UNIT"/>
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
	<!-- <xsl:template match="STYLE">
		<style>
			<xsl:attribute name="type"><xsl:value-of select="@TYPE"/></xsl:attribute>
			<xsl:value-of select="."/>
		</style>
	</xsl:template> -->
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
		<table border="0" cellspacing="0" width="100%" style="font-face:verdana:font-size:9pt;">
			<tr>
				<td width="100%" colspan ="8" style="font-family:Verdana;font-size:9pt">
					<i>Addendum Created By: <xsl:value-of select="@CREATED-BY"/>, Date/Time: <xsl:value-of select="@DATE"/>
					</i>
				</td>
			</tr>
			<tr>
				<td class="BODYCOLORFILLED" width="100%" style="font-family:Verdana;font-size:9pt;hyphens:auto;">
					<xsl:value-of select="."/>
				</td>
			</tr>
		</table>
	</xsl:template>
	<xsl:template match="PRE">
	<xsl:value-of select="." disable-output-escaping="yes"/>
<!--		<xsl:call-template name="TEXT-DISP"/>  -->
	</xsl:template>
	<!--========================================================================================-->
</xsl:stylesheet>

