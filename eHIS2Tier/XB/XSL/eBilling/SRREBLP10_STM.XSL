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

	<xsl:value-of select="$msgStart"/>
	<xsl:value-of select="$segStart"/>
	<xsl:text>CQH</xsl:text>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/stmAccountID"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/stmdat/hcode"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/stmdat/hname"/>
	<xsl:value-of select="$fieldSeparator"/>
	
	<xsl:value-of select="STMLIST/stmdat/accperiod/@desc"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="STMLIST/stmdat/accperiod/@desc1"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/stmdat/accperiod"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/stmdat/stmno"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/stmdat/cases"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/stmdat/total"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/stmdat/adjrw"/>
<xsl:text>
</xsl:text>

<xsl:variable name="factorVal" select="STMLIST/factors/@both"/>

<xsl:for-each select="STMLIST/factors/factor">
	<xsl:text>CQF</xsl:text>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="normalize-space($factorVal)"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="normalize-space(@accp)"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="normalize-space(@cmihm)"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="normalize-space(@cmilt)"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="normalize-space(@ratio)"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="normalize-space(@cases)"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="normalize-space(@ccase)"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="normalize-space(@bcase)"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="normalize-space(@adjrw)"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="normalize-space(@baserate)"/>
	<xsl:value-of select="$segEnd"/>

</xsl:for-each>

<xsl:for-each select="STMLIST/thisip">
	<xsl:value-of select="$segStart"/>
	<xsl:text>CQD</xsl:text>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="an"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="namepat"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="datedsc"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="baserate"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="rid"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="atype"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="adj"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="month/ptype"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="month/drg"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="month/adjrw"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="month/fact"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="month/ccuf"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="month/accp"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="month/amlim"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="month/amreim"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="trimester/ptype"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="trimester/sys"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="trimester/drg"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="trimester/adjrw"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="trimester/fact"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="trimester/ccuf"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="trimester/accp"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="trimester/amlim"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="trimester/amreim"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="trimester/cp"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="trimester/copayers/copayer"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="trimester/copayers/total"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="trimester/copayers/ramlim"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="trimester/copayers/ramreim"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="trimester/gamlim"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="trimester/gamreim"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="trimester/gtotal"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="trimester/extravalue"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="trimester/latereduce/@perc"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="trimester/latereduce"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="trimester/copayers/copayer/@code"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="trimester/copayers/copayer/@paid"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="trimester/copayers/copayer/total"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="trimester/copayers/copayer/ramlim"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="trimester/copayers/copayer/ramreim"/>
	<xsl:value-of select="$segEnd"/>

</xsl:for-each>

</xsl:template>
</xsl:stylesheet>