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
	<xsl:text>CHH</xsl:text>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSTM/stmAccountID"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSTM/hcode"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSTM/hname"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSTM/amount"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSTM/thamount"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSTM/gst"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSTM/STMdat/AccPeriod"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSTM/STMdat/STMdoc"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSTM/STMdat/dateStart"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSTM/STMdat/dateEnd"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSTM/STMdat/datedue"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSTM/STMdat/dateIssue"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSTM/STMdat/amount"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSTM/STMdat/Tamount"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSTM/STMdat/Tcount"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSTM/STMdat/Ttotal"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSTM/STMdat/TFeecount"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSTM/STMdat/TFeetotal"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSTM/STMdat/tst"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSTM/HD/amount"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSTM/HD/STMdat/Tcount"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSTM/HD/STMdat/Ttotal"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="STMSTM/HD/STMdat/tst"/>
	<xsl:value-of select="$segEnd"/>

<xsl:for-each select="STMSTM/TBills/TBill">

	<xsl:value-of select="$segStart"/>
	<xsl:text>CHD</xsl:text>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="station"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="hreg"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="hn"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="invno"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="dttran"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="amount"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="paid"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="rid"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="cstat"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:text>N</xsl:text>	
	<xsl:value-of select="$segEnd"/>

</xsl:for-each>

<xsl:for-each select="STMSTM/HDBills/TBill">

	<xsl:value-of select="$segStart"/>
	<xsl:text>CHD</xsl:text>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="station"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="hreg"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="hn"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="invno"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="dttran"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="amount"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="paid"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="rid"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="cstat"/>
	<xsl:value-of select="$fieldSeparator"/>

	<xsl:value-of select="HDflag"/>
	<xsl:value-of select="$segEnd"/>

</xsl:for-each>

</xsl:template>

</xsl:stylesheet> 

