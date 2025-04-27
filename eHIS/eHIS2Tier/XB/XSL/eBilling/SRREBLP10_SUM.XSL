<?xml version="1.0" encoding="Windows-874"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"   
xmlns:msxsl="urn:schemas-microsoft-com:xslt" 
xmlns:user="script:user"
xmlns:user1="script:user1">

<xsl:output method="text" indent="yes"/>

<xsl:variable name="fieldSeparator">|</xsl:variable>
<xsl:variable name="msgStart">MSG_START</xsl:variable>
<xsl:variable name="msgEnd">MSG_END</xsl:variable>
<xsl:variable name="segStart">SEG_START</xsl:variable>
<xsl:variable name="segEnd">SEG_END</xsl:variable>

<xsl:template match="/">

	<xsl:value-of select="$segStart"/>
	<xsl:text>CQS</xsl:text>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/stmAccountID"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/chi/image"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/stmdat/hcode"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/stmdat/hname"/>
	<xsl:value-of select="$fieldSeparator"/>	
	
	<xsl:value-of select="STMSUMM/stmdat/accperiod"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/stmdat/stmno"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/stmdat/mainno"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/stmdat/adjno"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/stmdat/letdate"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/stmdat/datadate"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/stmdat/docdate"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/hgroup/hcode"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/hgroup/cases"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/hgroup/amount"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/hgroup/thamount"/>
	<xsl:value-of select="$fieldSeparator"/>

<xsl:for-each select="STMSUMM/hgroup/sumdat">
	<xsl:for-each select="datagroup">
		
		<xsl:value-of select="data/amlim"/>
		<xsl:value-of select="$fieldSeparator"/>

		<xsl:for-each select="data/amreim">
			<xsl:if test="count(*) = 0">
				<xsl:value-of select="."/>
			</xsl:if>			
			<xsl:value-of select="baserate"/>
			<xsl:value-of select="$fieldSeparator"/>
			<xsl:value-of select="adjrw"/>
			<xsl:value-of select="$fieldSeparator"/>
			<xsl:value-of select="cmihm"/>
			<xsl:value-of select="$fieldSeparator"/>
			<xsl:value-of select="cmilt"/>
			<xsl:value-of select="$fieldSeparator"/>
			<xsl:value-of select="amreim100"/>
			<xsl:value-of select="$fieldSeparator"/>
		</xsl:for-each>

		<xsl:value-of select="data/total"/>
		<xsl:value-of select="$fieldSeparator"/>
		
		<xsl:value-of select="gtotal"/>
		<xsl:value-of select="$fieldSeparator"/>		

	</xsl:for-each>
</xsl:for-each>	

	<xsl:value-of select="STMSUMM/ticket/id"/>

<xsl:value-of select="$segEnd"/>
<xsl:value-of select="$msgEnd"/>

 </xsl:template>

</xsl:stylesheet> 

