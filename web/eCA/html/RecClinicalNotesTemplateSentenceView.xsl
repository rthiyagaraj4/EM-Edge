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
	<!--=====================================================================================-->
	<!--======================traversing through the template================================-->
	<!--Matrix Component starts-->
	<xsl:template match="MATRIX">
		<xsl:if test="(not(@DISPLAYMATRIX) or @DISPLAYMATRIX = 'Y' or @DISPLAYMATRIX = null )">
			<tr>
				<td align="center" colspan="3">
			<!-- IN067625 STARTS -->
<!-- 				<table border="1" width="100%" cellspacing="0" cellpadding="1" style="border-style:dashed"> -->
				<table border="1" width="100%" cellspacing="0" cellpadding="1" >
				<!-- IN067625 ENDS -->
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
		</xsl:if>
	</xsl:template>
	<xsl:template match="MATRIX-TH">
		<tr>
		<!-- IN067625 STARTS -->
<!-- 			<td colspan="6" style="BORDER-STYLE:dashed;FONT-SIZE:9pt;font-weight:bold;"> -->
			<td colspan="6" style="FONT-SIZE:9pt;font-weight:bold;">
			<!-- IN067625 ENDS -->
				<b>
					<xsl:value-of select="../@MATRIX-DESC"/>
				</b>
			</td>
		</tr>
		<tr>
		<!-- IN067625 STARTS -->
<!-- 			<td align="right" style="BORDER-STYLE:dashed;"> -->
<th align="right" >
<!-- IN067625 ENDS -->
                &#160; 
            </th>
			<xsl:for-each select="TH">
			<!-- IN067625 STARTS -->
<!-- 				<th style="font-size:9pt;font-weight:bold;border-style:dashed;"> -->
				<th style="font-size:9pt;font-weight:bold;">
				<!-- IN067625 ENDS -->
					<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
					<xsl:attribute name="width"><xsl:value-of select="@WIDTH"/></xsl:attribute>
					<xsl:value-of select="."/>
				</th>
			</xsl:for-each>
		</tr>
	</xsl:template>
	<xsl:template match="MATRIX-ROW">
		<tr>
		<!-- IN067625 STARTS -->
<!-- 			<td align="right" style="font-size:9pt;font-weight:bold;border-style:dashed;" width="5%"> -->
			<td align="left" style="font-size:9pt;font-weight:bold;width:250px;" valign="top"> 
			<!-- IN067625 ENDS -->
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
		<xsl:if test="(not(@DISPLAYGRID) or @DISPLAYGRID = 'Y' or @DISPLAYGRID = null )">
		<tr>
			<td colspan="3">
			<!-- IN067625 STARTS -->
<!-- 				<table border="1" width="100%" cellspacing="0" cellpadding="1" style="border-style:dashed;border-width:thin;"> -->
<table border="1" width="100%" cellspacing="0" cellpadding="1" >
<!-- IN067625 ENDS -->
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
		</xsl:if>
	</xsl:template>
	<xsl:template match="GRID-TH">
		<tr>
		<!-- IN067625 STARTS -->
<!-- 			<td align="left" style="border-style:dashed;FONT-SIZE:9pt;font-weight:bold;"> -->
			<td colspan="6" align="left" style="FONT-SIZE:9pt;font-weight:bold;">
			<!-- IN067625 ENDS -->
				<b>
					<xsl:attribute name="colspan"><xsl:value-of select="(../@COLSPAN) -1"></xsl:value-of></xsl:attribute>
					<xsl:value-of select="../@DESCRIPTION"/>
				</b>
			</td>
		</tr>
		<tr>
			<xsl:for-each select="EMPTY-TH">
				<th style="font-size:9pt;font-weight:bold;">
                        &#32;
                    </th>
			</xsl:for-each>
			<xsl:for-each select="TH">
			<!-- IN067625 STARTS -->
<!-- 				<th style="border-style:dashed;font-size:9pt;font-weight:boldl;"> -->
				<th style="font-size:9pt;font-weight:boldl;">
				<!-- IN067625 ENDS -->
					<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
					<xsl:value-of select="."/>
				</th>
			</xsl:for-each>
		</tr>
	</xsl:template>
	<xsl:template match="EMPTY-COLUMN">
		<xsl:if test="@GRID-COMP|@MATRIX-COMP">
			<td>
			<!-- IN067625 STARTS -->
<!-- 				<xsl:attribute name="style"> -->
<!--                     BORDER-STYLE:dashed; -->
                    <xsl:attribute name="style">
                    
                    <!-- IN067625 ENDS -->
            </xsl:attribute>
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
		<xsl:if test="not(/USER-TEMPLATE/@ONLYFILLED) or (/USER-TEMPLATE/@ONLYFILLED = 'N' or  (/USER-TEMPLATE/@ONLYFILLED = 'Y' and (count(.//MULTI-LIST-DATA[@SELECTED='true']) &gt; 0) or (.//TEXT/@VALUE != '')) or (@GRID-COMP|@MATRIX-COMP) ) or @STD_COMP_VALUE != '' "> <!--IN033230-->
		<tr>
			<td>
				<font style="COLOR:black;FONT-SIZE:9pt;font-weight:bold;">
					<xsl:value-of select="@HEADER"/>
				</font>
			</td>
			<td valign="top">
				<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">
					:&#160;&#160;&#160;
				</font>
			</td>
			<td>
				<xsl:apply-templates/>
			</td>
		</tr>
		</xsl:if> <!--IN033230-->
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
		<xsl:param name="LANGID" select="@LANGID"/>
		<!--IN066793 STARTS -->
		 <table border="0" cellpadding='0' cellspacing='4' width="100%" style="font-family:Verdana"> 

		<!--IN066793 ENDS -->
			<xsl:for-each select="ROW">			
				<xsl:for-each select="COL">
					<xsl:choose>
						<xsl:when test="not(node())">							
							<td colspan="3">&#160; </td>
						</xsl:when>
						<xsl:otherwise> 							
							 <xsl:apply-templates>
								<xsl:with-param name="LANGID" select="$LANGID"/>
							</xsl:apply-templates>
						 </xsl:otherwise>
					</xsl:choose> 	    
					<!-- <xsl:apply-templates/> -->
				</xsl:for-each>
				<xsl:apply-templates select="EMPTY-ROW"/>
			</xsl:for-each>
		</table>		 
		<xsl:apply-templates select="USER-TEMPLATE-ADDENDUM"/>
		<xsl:apply-templates select="USER-TEMPLATE-ADDENDUM-RECORDED"/>
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
		<xsl:param name="LANGID"/>	
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
			<td valign="top">
				<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">
					:&#160;&#160;&#160;
				</font>
			</td>
			<td>
				<font style="COLOR:NAVY;FONT-SIZE:9pt">
					<xsl:choose>
					    <xsl:when test="@COMPTYPE='A' and @RESULTTYPE='D' and $LANGID != 'en'">		    
						<xsl:value-of select="@OTHLANGVAL"/>&#160;
					    </xsl:when>
					    <xsl:otherwise>
						 <xsl:value-of select="@VALUE"/>&#160;
					    </xsl:otherwise>
				       </xsl:choose>              					
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
	<!--========================================================================================-->
	<!--=====================================template for text-box====================================-->
	<xsl:template match="TEXT-BOX">
	     <tr>
		<td align="right">
			<!--<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>-->
			<xsl:attribute name="align"><xsl:value-of select="@ALIGN"/></xsl:attribute>
			<xsl:attribute name="class"><xsl:value-of select="@CLASS"/></xsl:attribute>
			<xsl:value-of select="@PROMPT"/>
		</td>
		<td align="left">
			<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
			<B>
				<xsl:value-of select="@VALUE"/>
			</B>
		</td>
	     </tr>
	</xsl:template>
	<!--===========================================================================================-->
	<!--===============================template for checkbox=======================================-->
	<xsl:template match="CHECK-BOX">
		<xsl:choose>
			<xsl:when test="(@GRID-COMP|@MATRIX-COMP)">
			<!-- IN067625 STARTS -->
<!-- 				<td align="center" style="border-style:dashed"> -->
				<td align="center" >
				<!-- IN067625 ENDS -->
					<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
					<xsl:call-template name="CHECK-BOX-WTD"/>
				</td>
			
			</xsl:when>
			<xsl:otherwise>
				<tr>
					<td align="left" width="20%">
					<xsl:attribute name="nowrap"></xsl:attribute>
						<xsl:attribute name="class"><xsl:value-of select="@CLASS"/></xsl:attribute>
						<font>
							<xsl:attribute name="style">FONT-SIZE:9pt;font-weight:bold;</xsl:attribute>
							<xsl:value-of select="@PROMPT"/>&#160;&#160;&#160;
						</font>
					</td>
					<td width="3%" valign="toop">
						<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">
							:&#160;&#160;&#160;
						</font>
					</td>
					<td align="left">
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
			<font>
				<xsl:if test="@GRID-COMP|@MATRIX-COMP">
					<xsl:attribute name="style">COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;</xsl:attribute>
				</xsl:if>
				<xsl:if test="not(@GRID-COMP|@MATRIX-COMP)">
					<xsl:attribute name="style">COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;</xsl:attribute>
				</xsl:if>        
                Yes
            </font>
		</xsl:if>
		<xsl:if test="not(@VALUE)">
			<font>
				<xsl:if test="@GRID-COMP|@MATRIX-COMP">
					<xsl:attribute name="style">COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;</xsl:attribute>
				</xsl:if>
				<xsl:if test="not(@GRID-COMP|@MATRIX-COMP)">
					<xsl:attribute name="style">COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;</xsl:attribute>
				</xsl:if>            
                No
            </font>
		</xsl:if>
		<xsl:if test="@VALUE=''">
			<font>
				<xsl:if test="@GRID-COMP|@MATRIX-COMP">
					<xsl:attribute name="style">COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;</xsl:attribute>
				</xsl:if>
				<xsl:if test="not(@GRID-COMP|@MATRIX-COMP)">
					<xsl:attribute name="style">COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;</xsl:attribute>
				</xsl:if>
                No
            </font>
		</xsl:if>
		<xsl:if test="@VALUE='N'">
			<font>
				<xsl:if test="@GRID-COMP|@MATRIX-COMP">
					<xsl:attribute name="style">COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;</xsl:attribute>
				</xsl:if>
				<xsl:if test="not(@GRID-COMP|@MATRIX-COMP)">
					<xsl:attribute name="style">COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;</xsl:attribute>
				</xsl:if>                
                No
            </font>
		</xsl:if>
		<xsl:if test="not(@GRID-COMP|@MATRIX-COMP)"/>
	</xsl:template>
	<!--===========================================================================================-->
	<!--=======================================for Combo-box===================================-->
	<xsl:template match="LIST-BOX">
		<xsl:if test="not(/USER-TEMPLATE/@ONLYFILLED) or (/USER-TEMPLATE/@ONLYFILLED = 'N' or  (/USER-TEMPLATE/@ONLYFILLED = 'Y' and count(.//DATA[@SELECTED='true']) &gt; 0)  or (@GRID-COMP|@MATRIX-COMP) ) or @STD_COMP_VALUE != '' ">
			<xsl:choose>
				<xsl:when test="(@GRID-COMP|@MATRIX-COMP)">
				<!-- IN067625 STARTS -->
<!-- 					<td align="center" style="border-style:dashed"> -->
					<td align="center" >
					<!-- IN067625 ENDS -->
						<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
						<xsl:call-template name="LIST-BOX-WTD"/>
					</td>
				
				</xsl:when>
				<xsl:otherwise>
				<tr>	
						<td align="left" width="20%">
							<xsl:attribute name="nowrap"></xsl:attribute>
							<xsl:attribute name="class"><xsl:value-of select="@CLASS"/></xsl:attribute>
							<font style="FONT-SIZE:9pt;font-weight:bold;">
								<xsl:value-of select="@PROMPT"/>&#160;&#160;&#160;
							</font>
						</td>
						<td width="3%" valign="top">
							<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">
								:&#160;&#160;&#160;
						</font>
						</td>
						<td align="left">
							<xsl:choose>
								<xsl:when test="@STD_COMP_RESULT_TYPE != ''">
									<xsl:choose>
										<xsl:when test="@STD_COMP_RESULT_TYPE ='L'">
											<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;">
												<xsl:value-of select="@STD_COMP_VALUE"/>
											</font>
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
								<IMAGE SRC="../../eCommon/images/mandatory.gif"/>
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
			<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;">
			<xsl:value-of select="@STD_COMP_VALUE"/>
			
			</font>
			</xsl:when>
		  <xsl:otherwise>
		<xsl:for-each select="DATA">
			<xsl:if test="@SELECTED='true'">
				<font>
						<xsl:attribute name="style">
                        COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;
                        </xsl:attribute>
					<xsl:value-of select="."/>
				</font>
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
				<!-- IN067625 STARTS -->
<!-- 					<td align="left" style="border-style:dashed"> -->
					<td align="left" valign="top"> 
					<!-- IN067625 ENDS -->
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
					<xsl:if test="not(@TXTALLIGNYN) or @TXTALLIGNYN='N'">
						<tr>
							<td align="left" colspan="1" valign="top" width="20%">
								<xsl:attribute name="nowrap"></xsl:attribute>
								<!-- <xsl:attribute name="class"><xsl:value-of select="@CLASS"/></xsl:attribute> -->
								<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;hyphens:auto;"><!--IN066793 -->
									<xsl:value-of select="@PROMPT"/>
								</font>
							</td>
							<td width="3%" valign="top">
								<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">
									:&#160;&#160;&#160;
							</font>
							</td>
							<td>
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
					</xsl:if>
					<xsl:if test="@TXTALLIGNYN='Y'">
						<tr>
							<td align="left" colspan="1" valign="top" width="20%">
								<xsl:attribute name="nowrap"></xsl:attribute>
								<!-- <xsl:attribute name="class"><xsl:value-of select="@CLASS"/></xsl:attribute> -->
								<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;hyphens:auto;"><!--IN066793 -->
									<xsl:value-of select="@PROMPT"/>
								</font>
							</td>
							<td width="3%" valign="top">
								<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;"><!--IN066793 -->
									:&#160;&#160;&#160;
							</font>
							</td>
							<td  align="left">&#160;</td>
						</tr>
						<tr>
							<td  colspan='3' align="left">
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
					</xsl:if>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:if>
	</xsl:template>
	<xsl:template name="SHORT-TEXT-WTD" match="SHORT-TEXT-WTD">
	<xsl:param name="text" select="." /> 
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
		<xsl:if test="(not(/USER-TEMPLATE/@ONLYFILLED) or /USER-TEMPLATE/@ONLYFILLED = 'N' or (/USER-TEMPLATE/@ONLYFILLED = 'Y' and text() != '' )) and (not(@TXTALLIGNYN) or @TXTALLIGNYN='N') ">
			<tr>
				<td width="20%" valign="top">
					<xsl:attribute name="nowrap"></xsl:attribute>
					<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;"> <!--IN066793 -->
						<xsl:value-of select="@PROMPT"/>
					</font>
					<font color="#E2E3F0">&#160;</font>
				</td>
				<td valign="top" width="3%">
					<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;"> <!--IN066793 -->
						:&#160;&#160;&#160;
					</font>
				</td>
				<td  align="left">	
				<xsl:attribute name="colspan">
				  <xsl:value-of select="@COLSPAN" /> 
				</xsl:attribute>
				<xsl:attribute name="style">hyphens:auto</xsl:attribute>
				<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal; ">	<!--IN066793 -->				
					 <xsl:call-template name="LONG-TEXT-WTD"/> 
				</font>
				</td>
			</tr>
		</xsl:if>
		<xsl:if test="(not(/USER-TEMPLATE/@ONLYFILLED) or /USER-TEMPLATE/@ONLYFILLED = 'N' or (/USER-TEMPLATE/@ONLYFILLED = 'Y' and text() != '' )) and @TXTALLIGNYN='Y' ">
			<tr>
				<td width="20%" valign="top">					
					<xsl:attribute name="nowrap"></xsl:attribute>
					<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;"> <!--IN066793 -->
						<xsl:value-of select="@PROMPT"/>
					</font>
					<font color="#E2E3F0">&#160;</font>
				</td>
				<td valign="top" width="3%">
					<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;"> <!--IN066793 -->
						:&#160;&#160;&#160;
					</font>
				</td>
				<td  align="left">&#160;</td>
			</tr>
			<tr>
				<td align="left">
				<xsl:attribute name="colspan">
				  <xsl:value-of select="@COLSPAN" /> 
				</xsl:attribute>
				<xsl:attribute name="style">hyphens:auto</xsl:attribute>
				<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;">	<!--IN066793 -->				
					 <xsl:call-template name="LONG-TEXT-WTD"/> 
				</font>
				</td>
			</tr>
		</xsl:if>
	</xsl:template>
	<xsl:template name="LONG-TEXT-WTD" match="LONG-TEXT-WTD">
		<xsl:param name="text" select="."/>
		<xsl:choose>
			<xsl:when test="contains($text, '&lt;T') or contains($text, '&lt;t')">
				<xsl:value-of select="$text" disable-output-escaping="yes"/>
			</xsl:when>						
			<xsl:otherwise>
				<xsl:call-template name="LONG-TXT-WTD"/>
			</xsl:otherwise>
		</xsl:choose> 		
	</xsl:template>
	<xsl:template name="LONG-TXT-WTD" match="LONG-TXT-WTD">
		<xsl:param name="text" select="."/>
		<xsl:choose>
			<xsl:when test="contains($text, '&#xA;')">			
				<xsl:call-template name="LONG-TEXT-WTS">
					<xsl:with-param name="subtext" select="substring-before($text, '&#xA;')"/>
				</xsl:call-template>
				<br/>
				<xsl:call-template name="LONG-TXT-WTD">
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
				<xsl:value-of select="$subtext" disable-output-escaping="yes"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	
	<!--===========================================================================================-->
	<!--=======================================for Title Text =========================-->
	<xsl:template match="TITLE-TEXT">
		<!--<tr>
			<td>
			<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
			&#160;
			</td>
		</tr>-->
		<tr>
			<td>
			<xsl:attribute name="align"><xsl:value-of select="@ALIGN"/></xsl:attribute>
			<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
			<xsl:attribute name="style">word-break:break-strict</xsl:attribute>
				<xsl:if test="@TYPE='T'">
					<font style="FONT-SIZE:9pt;font-weight:bold;background-color:#ADADAD;hyphens:auto;">
						<i>
							<xsl:value-of select="."/>
						</i>
					</font>
				</xsl:if>
				<xsl:if test="@TYPE='C'">
					<font style="FONT-SIZE:12pt;font-weight:bold;hyphens:auto;">
						<i>
							<xsl:value-of select="."/>
						</i>
					</font>
				</xsl:if>
			</td>
			
		</tr>
	</xsl:template>
	<!--===========================================================================================-->
	<!--==================for DATE,TIME,DATE/TIME,INTEGER,DECIMAL FIELD =========================-->
	<xsl:template match="DATE-TIME-NUMERIC">
		<xsl:param name="LANGID"/>
		<xsl:if test="not(/USER-TEMPLATE/@ONLYFILLED) or /USER-TEMPLATE/@ONLYFILLED = 'N' or (/USER-TEMPLATE/@ONLYFILLED = 'Y' and @VALUE != '' ) or @GRID-COMP='Y' or @MATRIX-COMP='Y' ">
			<xsl:choose>
				<xsl:when test="(@GRID-COMP|@MATRIX-COMP)">
				<!-- IN067625 STARTS -->
<!-- 					<td align="center" style="border-style:dashed"> -->
					<td align="center" valign="top" > 
					<!-- IN067625 ENDS -->
						<xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
						<xsl:call-template name="DATE-TIME-NUMERIC-WTD"/>
						&#160;
					</td>
				</xsl:when>
				<xsl:otherwise>
					<tr>
						<td align="left" width="20%">
							<xsl:attribute name="nowrap"></xsl:attribute>
							<!-- <xsl:attribute name="class"><xsl:value-of select="@CLASS"/></xsl:attribute> -->
							<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">
								<xsl:value-of select="@PROMPT"/>
							</font>
							&#160;
						</td>
						<td width="3%" valign="top">
							<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">
								:&#160;&#160;&#160;
						</font>
						</td>
						<td>
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
			<font style="COLOR:NAVY;FONT-SIZE:9pt">
				<xsl:value-of select="@PREFIX_CHAR"/>&#160;&#160;
			</font>
		</xsl:if>
		<font style="COLOR:NAVY;FONT-SIZE:9pt">

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
			<font style="COLOR:NAVY;FONT-SIZE:9pt">
				<xsl:value-of select="@UNIT"/>
			</font>
		</font>
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
			<table border="0" cellspacing="0" width="100%" style="font-face:verdana:font-size:9pt;hyphens:auto;">
				<tr>
					<td width="100%" colspan ="8" style="font-family:Verdana;font-size:9pt;hyphens:auto;">
						<I><B>Addendum Created By:</B> <xsl:value-of select="@CREATED-BY"/>, Date/Time: <xsl:value-of select="@DATE"/>
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
	<!-- ========================IN034871 Start===================================  -->
	<xsl:template match="USER-TEMPLATE-ADDENDUM-RECORDED">
	<tr>
		<td colspan="3">
			<table border="0" cellspacing="0" width="100%" style="font-face:verdana:font-size:9pt;hyphens:auto;">
				<tr>
					<td width="100%" colspan ="8" style="font-family:Verdana;font-size:9pt;hyphens:auto;">
						<I><B>Addendum Recorded By:</B> <xsl:value-of select="@RECORDED-BY"/>, Date/Time: <xsl:value-of select="@DATE"/>
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
	<!-- ========================IN034871 End===================================  -->
	<xsl:template match="PRE">
	<xsl:value-of select="." disable-output-escaping="yes"/>
<!--		<xsl:call-template name="TEXT-DISP"/>  -->
	</xsl:template>
	<!--========================================================================================-->
</xsl:stylesheet>
