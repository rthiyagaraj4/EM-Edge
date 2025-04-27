<?xml version="1.0" encoding="Windows-874"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"   
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

	<xsl:value-of select="$msgStart"/>
	<xsl:value-of select="$segStart"/>
	<xsl:text>SMH</xsl:text>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/stmdat/period/@desc"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/stmdat/hcode"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/stmdat/hname"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/stmdat/stmno"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/stmdat/cases"/>
	<xsl:value-of select="$segEnd"/>

<xsl:for-each select="STMLIST/Bills/Bill">

	<xsl:value-of select="$segStart"/>
	<xsl:text>SMD</xsl:text>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="rid"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:variable name="p" select="position()"/>
	<xsl:value-of select="$p"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="hn"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="an"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="pid"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="name"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="dateadm"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="datedsc"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="ft"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="bf"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="drg"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="rw"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="adjrw"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="hmain"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="hcode"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="hproc"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="careas"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="sc"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="ed"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="due"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="pstm"/>
	<xsl:value-of select="$segEnd"/>
</xsl:for-each>

</xsl:template>

</xsl:stylesheet> 

