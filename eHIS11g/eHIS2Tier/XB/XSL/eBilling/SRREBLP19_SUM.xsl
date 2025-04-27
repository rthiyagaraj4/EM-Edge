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
	<xsl:text>SMS</xsl:text>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/period/@desc"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/hcode"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/hname"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/dateDue"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/stmno"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:variable name="theaderVal" select="STMSUMM/cfgs/theader"/>

	<xsl:value-of select="substring-after($theaderVal,': ')"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/STMdats/STMdat/@desc"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/cfgs/throw"/>
	<xsl:value-of select="$fieldSeparator"/>

<xsl:for-each select="STMSUMM/STMdats/STMdat/dat">	
	<xsl:value-of select="cases[@IPtype='1']"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="cases[@IPtype='2']"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="cases[@IPtype='3']"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="cases[@IPtype='S']"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="adjrw[@IPtype='1']"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="adjrw[@IPtype='2']"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="adjrw[@IPtype='3']"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="adjrw[@IPtype='S']"/>
</xsl:for-each>

	<xsl:value-of select="$segEnd"/>
	<xsl:value-of select="$msgEnd"/>

</xsl:template>

</xsl:stylesheet> 

