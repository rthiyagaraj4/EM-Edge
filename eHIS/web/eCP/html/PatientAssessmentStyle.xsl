<?xml version="1.0" encoding="UTF-8" ?>
<!--
  Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
   
  Warning: This computer program is protected by copyright law and international treaties.
  Unauthorized reproduction or distribution of this program, or any portion of it, 
  may result in severe civil and criminal penalties, and will be prosecuted to 
  the maximum extent possible under the law.
-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
  <!--=======================================================================-->
    <xsl:template match="CSS">
        <link rel='StyleSheet' type='text/css' >
            <xsl:attribute name="href">../../eCommon/html/<xsl:value-of select="@sStyle"/></xsl:attribute>
        </link>
    </xsl:template>

    <xsl:template match="DOCUMENT">
	<html>
	     <head>            
	           <xsl:apply-templates select="CSS"/>
	     </head>
		<body >
		     <xsl:apply-templates select="USER-TEMPLATE"/>
	     </body>
         </html>
    </xsl:template>
	   
    <xsl:template match="USER-TEMPLATE">
	<table border="0" cellpadding='0' cellspacing='0' width="100%">
		<tr>
			<th colspan='2' width='45%' align='left'>
				Assessment Category
			</th>
			<th width='45%' align='left' >
				Component
			</th>
			<th width='7%' align='left'>
				Score
			</th>
			<th width='3%'>
			</th>
		</tr>
		<xsl:for-each select="ASSESS_CATG_CODE">
			<tr>
				<td colspan='5' >
					<xsl:attribute name="class">
						CAGROUPHEADING
					</xsl:attribute>
					<xsl:value-of select="@DESC" />
				</td>
			</tr>
			<tr>
			<xsl:for-each select="ASSESS_COMP_ID">
				<tr>
					<td colspan='2' width='45%' class='label'>
					</td>
					<td width='45%' class='label'>
						<xsl:apply-templates select="ASSESS_COMP_DESC"/>
					</td>
					<td width='7%' class='label' align='right'>
						<xsl:apply-templates select="SCORE"/>
					</td>
					<td width='3%'>
					</td>
				</tr>
			</xsl:for-each>
			</tr>
			<tr>
				<td class='label' width='10%'></td>
				<td colspan='2' class='label' align='left'>
					<b>Assessment Category Total Score</b>
				</td>
				<td class='label' align='right'>
					<b><xsl:apply-templates select="ASSESS_CATG_TOTAL_SCORE"/></b>
				</td>
				<td>
				</td>
			</tr>
		</xsl:for-each>
		<tr>
			<td colspan='5'>&#32;</td>
		</tr>
		<tr>
			<th width='10%' ></th>
			<th colspan='2' align='left'>
				<b>Assessment Score</b>
			</th>
			<th  align='right'>
				<b><xsl:apply-templates select="ASSESS_TOTAL_SCORE"/></b>
			</th>
			<th>
			</th>
		</tr>
	</table>
    </xsl:template>


    <xsl:template match="ASSESS_COMP_DESC">
	<xsl:value-of select="."/>
    </xsl:template>

    <xsl:template match="SCORE">
	<xsl:value-of select="."/>
    </xsl:template>

    <xsl:template match="ASSESS_CATG_TOTAL_SCORE">
	<xsl:value-of select="."/>
    </xsl:template>

    <xsl:template match="ASSESS_TOTAL_SCORE">
	<xsl:value-of select="."/>
    </xsl:template>

 </xsl:stylesheet>
