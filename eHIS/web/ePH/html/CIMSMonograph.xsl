<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output
	method="html"
	omit-xml-declaration="yes"
	indent="no"/>
<xsl:template match="/">
<html>
<head>
    <link type="text/css" href="../../ePH/html/jquery-ui-1.8.6.custom.css" rel="stylesheet" />
    <link type="text/css" href="../../ePH/html/mims.css" rel="stylesheet" />
 
    <script type="text/javascript" src="../../ePH/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="../../ePH/js/jquery-ui-1.8.6.custom.min.js"></script>
    <script type="text/javascript" src="../../ePH/js/monograph.js"></script>
    <style>body { <!-- Added for CIMS POC Issue - GHL-ICN-0036 [IN:070172]  Start -->
             font-size:8px;
             font-family : arial,sans serif,helvetica;
     }</style> <!-- Added for CIMS POC Issue - GHL-ICN-0036 [IN:070172]   End -->
	 
</head>
<body>

    <div id="tabs">
        <ul>
			<xsl:if test="//MONOGRAPH">
            <li><a href="#tab-generic">Generic</a></li>
            </xsl:if>
            <xsl:if test="//BRIEFMONO">
            <li><a href="#tab-brief">Brief</a></li>
            </xsl:if>
         	<xsl:if test="//FULLMONO">
            <li><a href="#tab-full">Full</a></li>
            </xsl:if>
        </ul>
      <xsl:if test="//FULLMONO">
        <div id="tab-full">
          <xsl:apply-templates select="//FULLMONO"/>
        </div>
      </xsl:if>
      <xsl:if test="//BRIEFMONO">
        <div id="tab-brief">
          <xsl:apply-templates select="//BRIEFMONO"/>
        </div>
      </xsl:if>
      <xsl:if test="//MONOGRAPH">
        <div id="tab-generic">
          <xsl:apply-templates select="//MONOGRAPH"/>
        </div>
      </xsl:if>
    </div>
</body>
</html>
</xsl:template>

<xsl:template match="BRIEFMONO">		
		<table class="ui-widget" width="95%" cellspacing="0" cellpadding="3">

            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Contents</xsl:with-param>
                <xsl:with-param name="SectionData" select="BC"/>
            </xsl:call-template>

            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Indications</xsl:with-param>
                <xsl:with-param name="SectionData" select="BI"/>
            </xsl:call-template>
            
            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Dosage</xsl:with-param>
                <xsl:with-param name="SectionData" select="BD"/>
            </xsl:call-template>

            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">MIMS Class</xsl:with-param>
                <xsl:with-param name="SectionData" select="BC"/>
            </xsl:call-template>

            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">ATC Classification</xsl:with-param>
                <xsl:with-param name="SectionData" select="ATCDET"/>
            </xsl:call-template>

            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Poison Schedule</xsl:with-param>
                <xsl:with-param name="SectionData" select="BPOI"/>
            </xsl:call-template>

            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Packing/Presentation</xsl:with-param>
                <xsl:with-param name="SectionData" select="BPP"/>
            </xsl:call-template>

		  </table>
	</xsl:template>  
    
	<xsl:template match="FULLMONO">		

		<table class="ui-widget" width="95%" cellspacing="0" cellpadding="3">
            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Contents</xsl:with-param>
                <xsl:with-param name="SectionData" select="FDESC"/>
            </xsl:call-template>

            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Indications</xsl:with-param>
                <xsl:with-param name="SectionData" select="FI"/>
            </xsl:call-template>

            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Dosage</xsl:with-param>
                <xsl:with-param name="SectionData" select="FD"/>
            </xsl:call-template>

            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">OverDosage</xsl:with-param>
                <xsl:with-param name="SectionData" select="FOD"/>
            </xsl:call-template>
            
            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Contraindications</xsl:with-param>
                <xsl:with-param name="SectionData" select="FCI"/>
            </xsl:call-template>

            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Special precautions</xsl:with-param>
                <xsl:with-param name="SectionData" select="FSP"/>
            </xsl:call-template>
            
            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Adverse Drug Reactions</xsl:with-param>
                <xsl:with-param name="SectionData" select="FAR"/>
            </xsl:call-template>

            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Side effects</xsl:with-param>
                <xsl:with-param name="SectionData" select="FSE"/>
            </xsl:call-template>

            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Mechanism of Action</xsl:with-param>
                <xsl:with-param name="SectionData" select="FA"/>
            </xsl:call-template>

            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">ATC Classification</xsl:with-param>
                <xsl:with-param name="SectionData" select="ATCDET"/>
            </xsl:call-template>

            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Poison Schedule</xsl:with-param>
                <xsl:with-param name="SectionData" select="FPOI"/>
            </xsl:call-template>
            
            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Storage</xsl:with-param>
                <xsl:with-param name="SectionData" select="FSTO"/>
            </xsl:call-template>

            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Packing/Presentation</xsl:with-param>
                <xsl:with-param name="SectionData" select="FPP"/>
            </xsl:call-template>
		</table>
	</xsl:template>  
    
    <xsl:template match="MONOGRAPH">
		<table class="ui-widget" width="95%" cellspacing="0" cellpadding="3">
            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Contents</xsl:with-param>
                <xsl:with-param name="SectionData" select="GENMONO"/>
            </xsl:call-template>

            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Indications</xsl:with-param>
                <xsl:with-param name="SectionData" select="BI"/>
            </xsl:call-template>
            
            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Dosage</xsl:with-param>
                <xsl:with-param name="SectionData" select="GDOSE"/>
            </xsl:call-template>

            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Contraindications</xsl:with-param>
                <xsl:with-param name="SectionData" select="GCI"/>
            </xsl:call-template>

            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Special precautions</xsl:with-param>
                <xsl:with-param name="SectionData" select="GSP"/>
            </xsl:call-template>

            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Adverse reactions</xsl:with-param>
                <xsl:with-param name="SectionData" select="GAR"/>
            </xsl:call-template>

            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Drug interactions</xsl:with-param>
                <xsl:with-param name="SectionData" select="GDI"/>
            </xsl:call-template>

            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Mechanism of action</xsl:with-param>
                <xsl:with-param name="SectionData" select="GACTION"/>
            </xsl:call-template>
            
            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">MIMS Class</xsl:with-param>
                <xsl:with-param name="SectionData" select="translate(GCLS, '*', '')"/>
            </xsl:call-template>

            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">ATC Classification</xsl:with-param>
                <xsl:with-param name="SectionData" select="GATC2"/>
            </xsl:call-template>

            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Poison Schedule</xsl:with-param>
                <xsl:with-param name="SectionData" select="BPOI"/>
            </xsl:call-template>

            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Pregnancy Category</xsl:with-param>
                <xsl:with-param name="SectionData" select="BPCAT"/>
            </xsl:call-template>
            
            <xsl:call-template name="ShowSection">
                <xsl:with-param name="SectionName">Packing/Presentation</xsl:with-param>
                <xsl:with-param name="SectionData" select="BPP"/>
            </xsl:call-template>
        </table>
    </xsl:template>

    <xsl:template name="ShowSection">
    <xsl:param name="SectionName"/>
    <xsl:param name="SectionData"/>
    <xsl:if test="normalize-space($SectionData)">
        <tr>
            <td style="width: 40%;vertical-align:top" class="ui-widget-content">
              <span style="font-weight: bold"><xsl:value-of select="$SectionName"/>
              </span>
            </td>
            <td class="ui-widget-content">
                <xsl:value-of select="$SectionData" disable-output-escaping="yes"/>
            </td>
        </tr>
    </xsl:if>
    </xsl:template>
    
    
    </xsl:stylesheet>

