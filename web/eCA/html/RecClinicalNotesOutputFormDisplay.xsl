<?xml version="1.0" encoding="UTF-8" ?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>
	<xsl:template match="CSS">
		<link rel='StyleSheet' type='text/css' >
		    <xsl:attribute name="href">../../eCommon/html/<xsl:value-of select="@sStyle"/></xsl:attribute>
		</link>
	</xsl:template>
	<xsl:template match="DOCUMENT">
	<html>
        <head>            
            <link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"/>
            <style type='text/css'>
            .YAXISHEAD
            {
                BACKGROUND-COLOR: #FFFFFF;
                COLOR: white ;
                FONT-SIZE: 8pt; 
            }
            </style>            
            <xsl:apply-templates select="STYLE"/>
            </head>
            <body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
                <xsl:attribute name="onLoad"><xsl:value-of select="USER-TEMPLATE/CALL-ON-LOAD/@VALUE"/><xsl:value-of select="@ONLOAD"/></xsl:attribute>
                <form>
                    <xsl:attribute name="name"><xsl:value-of select="@FORM-NAME"/></xsl:attribute>
                    <xsl:apply-templates/><!--for USER-TEMPLATE-->                    
                </form>
	     </body>
	     <!--added for calling formula functions on click of OK on trasactions-->
             <script>
                function callForLoadingFormulaResults()
                {
                    <xsl:value-of select="USER-TEMPLATE/CALL-ON-UNLOAD/@VALUE"/>
                }
             </script>
	 </html>
	 </xsl:template>
<!--=======================FOR FIELD AND TEXT TAGS==================================-->
	   <xsl:template match="TEXT">
		<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
	   </xsl:template>

	    <xsl:template match="FIELD">	
			<xsl:choose>
				<xsl:when test="(@TYPE='F')">
				<xsl:call-template name="TXT-WTD"/>
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
				</xsl:otherwise>
			</xsl:choose>		
	</xsl:template> 	
	<xsl:template name="TXT-WTD" match="TXT-WTD">
    	<xsl:param name="text" select="." /> 	
		<xsl:choose>
			<xsl:when test="contains($text, '&lt;T') or contains($text, '&lt;t')">
				<xsl:value-of select="$text" disable-output-escaping="yes"/>
			</xsl:when>						
			<xsl:otherwise>
				<xsl:call-template name="TEXT-WTD"/>
			</xsl:otherwise>
		</xsl:choose> 		
	</xsl:template>
	<xsl:template name="TEXT-WTD" match="TEXT-WTD">             
	  <!-- <xsl:param name="text" select="." disable-output-escaping="yes"/> --> 
		<xsl:param name="text" select="." /> 
	 <font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;"> 
	<xsl:choose>
			<xsl:when test="contains($text, '&#xA;')">
				<xsl:call-template name="TEXT-WTS">
					<xsl:with-param name="subtext" select="substring-before($text, '&#xA;')"/>
				</xsl:call-template>
				<br/>
				<xsl:call-template name="TEXT-WTD">
					<xsl:with-param name="text" select="substring-after($text,'&#xA;')"/>
				</xsl:call-template>
			</xsl:when>
			<xsl:otherwise>
				<xsl:call-template name="TEXT-WTS">
					<xsl:with-param name="subtext" select="$text"/>
				</xsl:call-template>
			</xsl:otherwise>
		</xsl:choose>
	</font>
	</xsl:template>
  <xsl:template name="TEXT-WTS" match="TEXT-WTS">
	<xsl:param name="subtext"/>
	     <xsl:choose>
		  <xsl:when test="contains($subtext, '&#x20;&#x20;')">
			<xsl:variable name="firststr" select="substring($subtext,1,1)"/>
				<xsl:if test="$firststr = '&#x20;'">&#160;
					<xsl:call-template name="TEXT-WTS">
						<xsl:with-param name="subtext" select="substring($subtext,2)"/>
					</xsl:call-template>
				</xsl:if>
				<xsl:if test="not($firststr = '&#x20;')">&#160;
					<xsl:value-of select="substring-before($subtext,'&#x20;')"/>
					<xsl:call-template name="TEXT-WTS">
						<xsl:with-param name="subtext" select="substring-after($subtext,'&#x20;')" />
					</xsl:call-template>
				</xsl:if>
		   </xsl:when>
		   <xsl:otherwise>
				<xsl:value-of select="$subtext" />
		   </xsl:otherwise>
	    </xsl:choose>
   </xsl:template> 
<!--==========================================================================-->

</xsl:stylesheet>