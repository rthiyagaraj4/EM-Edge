<?xml version="1.0" encoding="Windows-874"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"   
xmlns:msxsl="urn:schemas-microsoft-com:xslt" 
xmlns:user="script:user"
xmlns:user1="script:user1">

<xsl:output method="text" indent="yes"/>

<xsl:comment> 
	SUM Files will be read by engine after associated STM file is read.
	SUM file data will be appended to the message that is build from the STM file data,
	hence this file contains only message end and no message start.
</xsl:comment>

<xsl:variable name="fieldSeparator">|</xsl:variable>
<xsl:variable name="msgStart">MSG_START</xsl:variable>
<xsl:variable name="msgEnd">MSG_END</xsl:variable>
<xsl:variable name="segStart">SEG_START</xsl:variable>
<xsl:variable name="segEnd">SEG_END</xsl:variable>

<xsl:template match="/">

	<xsl:value-of select="$segStart"/>
	<xsl:text>CHS</xsl:text>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/stmAccountID"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/hcode"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/hname"/>
	<xsl:value-of select="$fieldSeparator"/>	

	<xsl:value-of select="STMSUMM/stmno"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/acount"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/amount"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/thamount"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/chi/image"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/STMdat/AccPeriod"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/STMdat/STMdoc"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/STMdat/dateStart"/>
	<xsl:value-of select="$fieldSeparator"/>	

	<xsl:value-of select="STMSUMM/STMdat/dateEnd"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/STMdat/dateDue"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/STMdat/dateIssue"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/STMdat/amount"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/STMdat/Tcount"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/STMdat/Ttotal"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/STMdat/TFeecount"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/STMdat/TFeetotal"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/STMdat/tst"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/HD/amount"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/HD/STMdat/Tcount"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/HD/STMdat/Ttotal"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/HD/STMdat/tst"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSUMM/ticket/id"/>

	<xsl:value-of select="$segEnd"/>
	<xsl:value-of select="$msgEnd"/>

 </xsl:template>

</xsl:stylesheet> 

