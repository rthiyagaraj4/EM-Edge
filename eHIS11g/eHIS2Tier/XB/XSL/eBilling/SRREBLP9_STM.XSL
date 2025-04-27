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
	<xsl:text>CMH</xsl:text>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/stmAccountID"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/stmdat/hcode"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/stmdat/hname"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/stmdat/accperiod"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/stmdat/stmno"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/stmdat/datestart"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/stmdat/dateend"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/stmdat/docdate"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/stmdat/letdate"/>
	<xsl:value-of select="$fieldSeparator"/>

<xsl:comment>	STMLIST/stmdat -- End	</xsl:comment>

<xsl:comment>	STMLIST/hgroup -- Start	</xsl:comment>

	<xsl:value-of select="STMLIST/hgroup/hcode"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/hgroup/cases"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/hgroup/amlim"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/hgroup/amreims/amlim"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/hgroup/amreims/amreim80"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/hgroup/amreims/amreim20"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/hgroup/amreim/baserate"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/hgroup/amreim/adjrw"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/hgroup/amreim/pamlim"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/hgroup/amreim/amreim"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/hgroup/amreim/payerreduce"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/hgroup/amreim/latereduce"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/hgroup/amreim/amreim100"/>
	<xsl:value-of select="$fieldSeparator"/>

<xsl:comment>	STMLIST/stmdat -- End	</xsl:comment>

	<xsl:value-of select="STMLIST/hgroup/sumdrg/room/pre"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="STMLIST/hgroup/sumdrg/room/reduce"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="STMLIST/hgroup/sumdrg/room/total"/>

	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="STMLIST/hgroup/sumdrg/reim/predrg"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="STMLIST/hgroup/sumdrg/reim/adjdrg"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="STMLIST/hgroup/sumdrg/reim/latereduce"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="STMLIST/hgroup/sumdrg/reim/payerreduce"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="STMLIST/hgroup/sumdrg/reim/total"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="STMLIST/hgroup/sumdrg/reim/gtotal"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/hgroup/sumdrg/cmiamreim/cmi"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="STMLIST/hgroup/sumdrg/cmiamreim/cmihm"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="STMLIST/hgroup/sumdrg/cmiamreim/cmilt"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMLIST/hgroup/amount"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="STMLIST/hgroup/thamount"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="$segEnd"/>
	<xsl:value-of select="$segStart"/>
	<xsl:text>CMF</xsl:text>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="STMLIST/factors/factor/code"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="STMLIST/factors/factor/range"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="STMLIST/factors/factor/baserate"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="STMLIST/factors/factor/cmihm"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="STMLIST/factors/factor/cmilt"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="STMLIST/factors/factor/ratio"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="STMLIST/factors/factor/case[@gov='C']"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="STMLIST/factors/factor/case[@gov='L']"/>
	<xsl:value-of select="$segEnd"/>
<xsl:comment>	Detail records	</xsl:comment>

<xsl:for-each select="STMLIST/thismonip">
<xsl:value-of select="$segStart"/>
<xsl:text>CMD</xsl:text>
<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="an"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="namepat"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="datedsc"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="atype"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="rid"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="baserate"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="fact"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="ccuf"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="sys"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="pcode"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="amlim"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="amreimb"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="drg"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="adjrw"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="tamreim"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="pamreim"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="ramreim"/>
	<xsl:value-of select="$fieldSeparator"/>

<xsl:variable name="percentage" select="latereduce/@perc"/>

	<xsl:value-of select="substring($percentage, 0, string-length($percentage))"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="latereduce"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="payers/payer/@code"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="payers/payer/@paid"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="payers/total"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="payers/ramlim"/>
	<xsl:value-of select="$fieldSeparator"/>
	<xsl:value-of select="payers/ramreim"/>
	<xsl:value-of select="$segEnd"/>

</xsl:for-each>


</xsl:template>

</xsl:stylesheet> 

