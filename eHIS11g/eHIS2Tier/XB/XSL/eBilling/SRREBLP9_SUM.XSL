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
	<xsl:text>CMS</xsl:text>
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

	<xsl:value-of select="STMSUMM/stmdat/datestart"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/stmdat/dateend"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/stmdat/docdate"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/stmdat/letdate"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/hgroup/cases"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/hgroup/amlim"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/hgroup/amreim/baserate"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/hgroup/amreim/adjrw"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/hgroup/amreim/cmihm"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/hgroup/amreim/cmilt"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/hgroup/amreim/amreim100"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/hgroup/amreim/amreim80"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/hgroup/amount"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/hgroup/thamount"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/reps/rep/rep1"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/reps/rep/rep2"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/reps/rep/rep3"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/reps/rep/rep4"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/reps/rep/rep5"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/reps/rep/rep6"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/reps/rep/rep7"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/reps/rep/rep8"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/reps/rep/rep9"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/reps/rep/rep10"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/reps/rep/rep11"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/reps/rep/rep12"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/reps/rep/rep13"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/reps/rep/rep14"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/reps/rep/rep15"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/reps/rep/rep16"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/ticket/id"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/remarks/remark"/>

	<xsl:value-of select="$segEnd"/>
	<xsl:value-of select="$msgEnd"/>

 </xsl:template>

</xsl:stylesheet> 

