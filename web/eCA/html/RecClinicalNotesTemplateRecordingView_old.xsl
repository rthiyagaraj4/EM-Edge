<?xml version="1.0" encoding="UTF-8" ?> 
<!--
    Document   : RecClinicalNotesTemplateRecordingView.xsl
    Created on : September 3, 2003, 3:35 PM
    Author     : ankursetia
    Description:
                 This transformation is for viewing the template in recording mode. Using this transformation, the user
                 would be able to enter his contents into the template.          
		 
-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <!--======================start of parsing================================-->
    <xsl:template match="CSS">
        <link rel='StyleSheet' type='text/css' >
            <xsl:attribute name="href">../../eCommon/html/<xsl:value-of select="@sStyle"/></xsl:attribute>
        </link>
    </xsl:template>
    <xsl:template match="DOCUMENT">
     <html>
        <head>            
            <link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"/>
            <style type='text/css'>
            .YAXISHEAD
            {
                BACKGROUND-COLOR: #FFFFFF;
                COLOR: white ;
                FONT-SIZE: 8pt; 
            }
            </style>            
            <xsl:apply-templates select="STYLE"/>
            </head>
            <body>
	           	<!--IN069884, starts --> 
		           	<xsl:if test="SITE-SPECIFIC/@RESTRICT_RIGHT_CLICK = 'Y'">
						<xsl:attribute name="onMouseDown">CodeArrest()</xsl:attribute>
						<xsl:attribute name="onKeyDown">lockKey()</xsl:attribute>
					</xsl:if>
				<!--IN069884, ends -->
				<xsl:if test="SITE-SPECIFIC/@FORMULA_COMP_DELETE_ENABLE = 'N'"> <!-- IN072304 -->
                <xsl:attribute name="onLoad"><xsl:value-of select="USER-TEMPLATE/CALL-ON-LOAD/@VALUE"/><xsl:value-of select="@ONLOAD"/></xsl:attribute>
                </xsl:if> <!-- IN072304 -->
				<form>
                    <xsl:attribute name="name"><xsl:value-of select="@FORM-NAME"/></xsl:attribute>
                    <xsl:apply-templates/><!--for USER-TEMPLATE-->                    
                </form>
        </body>
            <!--added for calling formula functions on click of OK on trasactions-->
            <script>
                function callForLoadingFormulaResults()
                {
					<xsl:if test="SITE-SPECIFIC/@FORMULA_COMP_DELETE_ENABLE = 'N'">
						<xsl:value-of select="USER-TEMPLATE/CALL-ON-UNLOAD/@VALUE"/>
					</xsl:if>
                }
				
            </script>
     </html>
    </xsl:template>
    <!--=======================================================================-->
    <!--======================traversing through the template================================-->
    <!--=======================================================================-->
    <xsl:template match="MATRIX">
        <td>            
            <xsl:attribute name="COLSPAN">
                <xsl:value-of select="@COLSPAN">
                </xsl:value-of>
            </xsl:attribute>
            <table border="1" width="100%" cellspacing="0" cellpadding="0">
                <xsl:attribute name="ID"><xsl:value-of select="@NAME"/></xsl:attribute>                        
                <xsl:apply-templates/>
            </table>            
        </td>       
    </xsl:template>
    <xsl:template match="MATRIX-TH">
        <tr>
            <th colspan="100" align='left'>
                <xsl:value-of select="../@MATRIX-DESC"/>
            </th>
        </tr>
        <tr>                         
            <th align="right" width="5%">
            </th>
            <xsl:for-each select="TH">
                <th style ="BACKGROUND-COLOR:#9499C7;color:black;font-size:10pt;font-weight:bold">
                    <xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"></xsl:value-of></xsl:attribute>
                    <xsl:attribute name="width"><xsl:value-of select="@WIDTH"></xsl:value-of></xsl:attribute>
                    <xsl:value-of select="."/>
                </th>
            </xsl:for-each>
            <xsl:for-each select="EMPTY-TH">
                <th style="BACKGROUND-COLOR:#9499C7;color:black;">
                    &#32;
                </th>
            </xsl:for-each>
        </tr>
    </xsl:template>
    <xsl:template match="MATRIX-ROW">
        <tr>
            <th align="left" width="21%" style = "BACKGROUND-COLOR:#9499C7;color:black;font-size:10pt;font-weight:bold;">
                <xsl:value-of select="@YAXISPROMPT"/>
            </th>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>
    <xsl:template match="MATRIX-COL">
            <xsl:apply-templates/>
    </xsl:template>
    
    
    <!--=======================================================================-->
    <!--======================traversing for the grid component================-->
    <!--=======================================================================-->   
    
    
    <xsl:template match="GRID">
        <td>
        <xsl:attribute name="COLSPAN">
            <xsl:value-of select="@COLSPAN">
            </xsl:value-of>
        </xsl:attribute>
        <table border="3" width="100%" cellspacing="0" cellpadding="0" >
            <xsl:attribute name="ID"><xsl:value-of select="@NAME"/></xsl:attribute>
            <xsl:apply-templates/>
        </table>
        </td>
  </xsl:template>
  <xsl:template match="GRID-TH">
    <tr>
        <th align="left" colspan="100"  >
            <b><xsl:value-of select="../@DESCRIPTION"/></b>
        </th>
    </tr>
    <tr>
        <xsl:for-each select="EMPTY-TH">
            <th style='BACKGROUND-COLOR:#9499C7;color:black;'>
                &#32;
            </th>
        </xsl:for-each>
        <xsl:for-each select ="TH">
        <th style='BACKGROUND-COLOR:#9499C7;color:black;font-weight:bold;'>
            <xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"></xsl:value-of></xsl:attribute>
            <xsl:value-of select=".">
            </xsl:value-of>
        </th>
        </xsl:for-each>
        <th style='BACKGROUND-COLOR:#9499C7;color:black;font-weight:normal;' width="3%">
            
        </th>
    </tr>
  </xsl:template>
  <xsl:template name="GRID-OPERATIONS">
    <table>
        <tr>
            <td align='center'>
                <a>
                <xsl:if test="@ROWINDEX='1'">
                    <xsl:attribute name="style">display:none</xsl:attribute>
                </xsl:if>
                <xsl:attribute name="id">anchor_delete_this_row<xsl:value-of select="../@NAME"/></xsl:attribute>
                <xsl:attribute name="href">javaScript:removeRow('<xsl:value-of select="../@NAME"/>',<xsl:value-of select="@ROWINDEX"/>);</xsl:attribute>
                <!--<img src="../../eCA/jsp/cut.gif"/>
                <u>Del</u>-->
                <B>-</B>
                </a>
            </td>
            <td align='center'>
                <a>
                <xsl:attribute name="id">anchor_adding_row_below<xsl:value-of select="../@NAME"/></xsl:attribute>
                <xsl:attribute name="href">javaScript:addNewRow('<xsl:value-of select="../@NAME"/>',<xsl:value-of select="@ROWINDEX"/>+1);</xsl:attribute>
                <!--<img src="../../eCA/jsp/add.gif"/>
                <u>Add</u>-->
                <B>+</B>
                </a>
	  </td>
        </tr>
    </table>            
  </xsl:template>
  <xsl:template match="GRID-ROW">      
    <tr>
        <xsl:apply-templates/>
        <td>           
            <xsl:call-template name="GRID-OPERATIONS"/>
        </td>    
    </tr>
  </xsl:template>
  <xsl:template match="GRID-COL">
     <xsl:apply-templates/>
  </xsl:template>
  <!--=======================================================================-->
  
  <!--=======================Multi Choice Component==========================-->
  <xsl:template match="MULTI-LIST">
    <td>
    <xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"></xsl:value-of></xsl:attribute>
    <table width="100%" cellspacing='5' cellpadding='0'  border="0" bordercolor="blue">
        <TR>
            <th colspan="10" align="left">
                <xsl:value-of select="@HEADER"/>
            </th>
        </TR>
        <tr>
            <td align="center">
                <table width="100%" BORDER="0">
                    <xsl:apply-templates/>
                </table>
            </td>            
        </tr>        
    </table>
    </td>
  </xsl:template>
  <xsl:template match="MULTI-LIST-ROW">
    <tr>
        <xsl:apply-templates/>
    </tr>
  </xsl:template>
  <xsl:template match = "MULTI-LIST-DATA">
    
    <td colspan='2'>
        <xsl:choose>			
            <xsl:when test="../../@LIST_SELECTION='M'">
				<xsl:attribute name="class">label</xsl:attribute>
                <input type="checkbox">					
                    <xsl:if test="@SELECTED='true'">
                        <xsl:attribute name="checked"></xsl:attribute>
                    </xsl:if>
                    <xsl:attribute name="name"><xsl:value-of select="@NAME"></xsl:value-of></xsl:attribute>
                </input>				
				<xsl:value-of select="."/>
            </xsl:when>
            <xsl:otherwise>
				 <xsl:attribute name="class">label</xsl:attribute>
                <input type="radio">					
                    <xsl:if test="@SELECTED='true'">
                        <xsl:attribute name="checked"></xsl:attribute>
                    </xsl:if>
                    <xsl:attribute name="onclick">
                        if(document.all.<xsl:value-of select="../../TEXT/@NAME"/>.value != '')
                        {
                            document.all.<xsl:value-of select="../../TEXT/@NAME"/>.value='';
                            document.all.<xsl:value-of select="../../TEXT/@NAME"/>.disabled = true;
                        }
                    </xsl:attribute>
                    <xsl:attribute name="name"><xsl:value-of select="../../@NAME"></xsl:value-of></xsl:attribute>
                    <xsl:attribute name="value"><xsl:value-of select="@NAME"></xsl:value-of></xsl:attribute>
                </input>				
				<xsl:value-of select="."/>
            </xsl:otherwise>
        </xsl:choose>		
    </td>
  </xsl:template>
  <xsl:template match="TEXT">
    <tr>
        <td colspan="1" align="right" class="label">
			<input >
				<xsl:attribute name="type"><xsl:choose><xsl:when test="../@LIST_SELECTION='S'">radio</xsl:when><xsl:otherwise>checkbox</xsl:otherwise></xsl:choose>
				</xsl:attribute>
				<xsl:if test="../@LIST_SELECTION='S'">
						<xsl:attribute name="name">
								<xsl:value-of select="../@NAME"/>
						</xsl:attribute>
				</xsl:if>
				<xsl:if test="string-length(@VALUE) != 0">
					<xsl:attribute name="checked">true</xsl:attribute>
				</xsl:if>
				<xsl:attribute name="onclick">
					document.all.<xsl:value-of select="@NAME"/>.value      = "";
					//document.all.<xsl:value-of select="@NAME"/>.disabled   = !document.all.<xsl:value-of select="@NAME"/>.disabled;
					//alert(this.checked);
					document.all.<xsl:value-of select="@NAME"/>.disabled   = !this.checked;
				</xsl:attribute>
			</input>
			<xsl:value-of select="@MISCDISP1"/>
        </td>
        <td colspan="9" align="left">
            <table>
                <tr>
                    <td class="label" colspan="9" align="left">
                    	   <xsl:value-of select="@MISCDISP2"/>          
                    </td>
                    <td>
                        <input type="text">
                            <xsl:if test="string-length(@VALUE) = 0">
                                <xsl:attribute name="disabled">true</xsl:attribute>
                            </xsl:if>
                            <xsl:attribute name="name"><xsl:value-of select="@NAME"></xsl:value-of></xsl:attribute>
                            <xsl:attribute name="value"><xsl:value-of select="@VALUE"/></xsl:attribute>
                        </input>
                    </td>
                 </tr>
              </table>
        </td>
    </tr>
  </xsl:template>
  <!--=======================================================================-->
  
    <xsl:template match="USER-TEMPLATE">
       <xsl:param name="LANGID" select="@LANGID"/>
        <table border='0' cellpadding='0' cellspacing='0' width='100%'>
                 <td>
                <table border="0" cellpadding='0' cellspacing='0' width="100%">
                <xsl:for-each select="ROW">
                <tr>
                <xsl:for-each select="COL">
                <xsl:apply-templates>
			<xsl:with-param name="LANGID" select="$LANGID"/>
		</xsl:apply-templates>
                </xsl:for-each>
                <xsl:apply-templates select="EMPTY-ROW"/>
                </tr>
            </xsl:for-each>
           </table>
                 </td>
        </table>
            <xsl:for-each select="HIDDEN-FIELD">
                <xsl:apply-templates select="."/>
            </xsl:for-each>
       
    </xsl:template>
    <!--=======================================================================================-->
   <!--==================for Paragraph template =========================-->
   <xsl:template match="PARAGRAPH" >
          <td align="left" class="label">			
			<xsl:attribute name="style">hyphens:auto</xsl:attribute>
            <xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
            <table width="100%" style="font-face:verdana;" border="0">
				<tbody >
					<tr>
						<td class="label" >
							<xsl:apply-templates/>
						</td>
					</tr>
				</tbody>
			</table>
        </td>
	   </xsl:template>
   <!--========================================================================================-->
   <!--==================for Formula template =========================-->
   <xsl:template match="FORMULA-COMP" >
	<xsl:param name="LANGID"/>	
        <xsl:apply-templates/>
        <td align="right" nowrap="true">
            <xsl:attribute name="class"><xsl:value-of select="@CLASS"/></xsl:attribute>
            <xsl:value-of select="@PROMPT"/>&#160;
        </td>
        <td align="left" nowrap="true">
            <xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
            <!-- IN072304 Start -->
			<!-- <input readonly="true" onKeyDown='restrictBackSpace(this)'> -->
			<input type="text">
				<xsl:if test="@FORMULA_COMP_DELETE_ENABLE = 'N'">
					<xsl:attribute name="readonly">readonly</xsl:attribute>
					<xsl:attribute name="onKeyDown">restrictBackSpace(this)</xsl:attribute>
				</xsl:if>
				<xsl:if test="@FORMULA_COMP_DELETE_ENABLE = 'Y'">
					<xsl:attribute name="onKeyDown">return allowDelinFormulaComp(this)</xsl:attribute>
				</xsl:if>
			<!-- IN072304 End -->
				<xsl:attribute name="name"><xsl:value-of select="@NAME"/></xsl:attribute>
                <xsl:attribute name="value">
			<xsl:choose>
			    <xsl:when test="@COMPTYPE='A' and @RESULTTYPE='D' and $LANGID != 'en'">		    
				<xsl:value-of select="@OTHLANGVAL"/>
			    </xsl:when>
			    <xsl:otherwise>
				 <xsl:value-of select="@VALUE"/>
			    </xsl:otherwise>
		       </xsl:choose>			
		</xsl:attribute>
                <xsl:attribute name="title"><xsl:value-of select="@HINT_MESSAGE"/></xsl:attribute>
            </input>
	    <xsl:attribute name="class">label</xsl:attribute>
	    <xsl:value-of select="@UNIT"/>&#160;
            <image src="../../eCA/images/calcResult.gif" title='Click here to find the formula result' style="cursor:hand">
                <xsl:attribute name="onclick"><xsl:value-of select="@FORMULA-FUNC"/></xsl:attribute>
            </image>
        </td>
   </xsl:template>
   <!--===============================for Empty row and column=====================================-->
   <xsl:template match="EMPTY-COLUMN">
        <xsl:if test="not(@GRID-COMP|@MATRIX-COMP)">
        <td>
	   <xsl:attribute name="width">
                  17%
           </xsl:attribute>
	</td><!--ONE FOR PROMPT MESSAGE AND OTHER FOR ACTUAL COMPONENT-->
        </xsl:if>
        <td>
            <xsl:if test="@GRID-COMP|@MATRIX-COMP">
                <xsl:attribute name="width">
                    15%
                </xsl:attribute>
            </xsl:if>        
            <xsl:if test="@MATRIX-COMP = 'Y'">
                <xsl:attribute name="colspan">
                    <xsl:value-of select="@COLSPAN"/>
                </xsl:attribute>
            </xsl:if>
        </td>
   </xsl:template>
   <xsl:template match="EMPTY-ROW">
        <td><font color='#E2E3F0'>_&#32;</font></td>
   </xsl:template>
  <!--===========================================================================================-->


   <!--===============================template for checkbox=======================================-->
   <xsl:template match="CHECK-BOX">
   
       <td align="left" colspan='2' nowrap="true"> 			
			<xsl:attribute name="class">label</xsl:attribute>
            <xsl:attribute name="align"><xsl:value-of select="@ALIGN"/></xsl:attribute>
            <xsl:if test="@GRID-COMP = 'Y'">
            </xsl:if>
            <xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
            <xsl:apply-templates select="POST-ITEM-ACTIONS"/>            
            <xsl:call-template name="CHECK-BOX-WTD">            
                <xsl:with-param name="GRID-NAME" select="@GRID-NAME"></xsl:with-param>
                <xsl:with-param name="GRID-COMP" select ="@GRID-COMP" ></xsl:with-param>
            </xsl:call-template>  
			 <xsl:if test = "not(@GRID-COMP|@MATRIX-COMP)">			            
					
					<xsl:if test="@NOWRAP='true'">
						<xsl:attribute name="nowrap"></xsl:attribute>
					</xsl:if>
				   <xsl:value-of select="@PROMPT"/>&#160;			 
			</xsl:if>
            
	    <xsl:if test="@MANDATORY='Y'">
		&#32;
		<IMAGE SRC="../../eCommon/images/mandatory.gif"/>
 	   </xsl:if>
        </td>
   </xsl:template>
   <xsl:template name="CHECK-BOX-WTD" match="CHECK-BOX-WTD">
        <input type="checkbox">
            <xsl:if test="@GRID-COMP='Y'">
                <xsl:attribute name="id">check_box_component_of_<xsl:value-of select="@GRID-NAME"/><xsl:value-of select="../@COLINDEX"/></xsl:attribute>
            </xsl:if>
	    <xsl:attribute name="class">label</xsl:attribute>
                <xsl:attribute name="value"><xsl:value-of select="@VALUE"/></xsl:attribute>
                <xsl:attribute name="name"><xsl:value-of select="@NAME"/></xsl:attribute>
		<xsl:attribute name="title"><xsl:value-of select="@HINT_MESSAGE"/></xsl:attribute>
                <xsl:attribute name="onclick">if(this.checked) this.value='Y'; else this.value='';<xsl:value-of select="@ONCLICK"/></xsl:attribute>
                <xsl:if test="@CHECKED='true'">
                    <xsl:attribute name="checked"></xsl:attribute>
                </xsl:if>
                <xsl:if test="@VALUE='Y'">
                    <xsl:attribute name="checked"></xsl:attribute>
                </xsl:if>
                <xsl:if test="@DISABLED='true'">
                    <xsl:attribute name="disabled"></xsl:attribute>
                </xsl:if>
          </input>
   </xsl:template>
  <!--===========================================================================================-->


  <!--=======================================for Combo-box===================================-->
  <xsl:template match="LIST-BOX" >
    <xsl:if test="not(@GRID-COMP|@MATRIX-COMP)">
        <td align="right" nowrap="true" width="13%">
            <xsl:attribute name="class">label</xsl:attribute>
	    <xsl:attribute name="style">word-break:break-strict</xsl:attribute>
	    <xsl:attribute name="title"><xsl:value-of select ="@HINT_MESSAGE" /></xsl:attribute>
	    <xsl:value-of select="@PROMPT"/>&#160;
            <xsl:if test="@NOWRAP='true'">
                <xsl:attribute name="nowrap"></xsl:attribute>
            </xsl:if>
       </td>
    </xsl:if>
 <!--   <xsl:choose>
	<xsl:when test="@LINK_HIST_YN = 'Y'">
	      <xsl:apply-templates select="LINK-HISTORY-BUTTON"/>
      </xsl:when>
  <xsl:otherwise>-->
       <td align="left" nowrap="true"  >
            <xsl:if test="@GRID-COMP = 'Y'">
                <xsl:attribute name="align">center</xsl:attribute>                
            </xsl:if>
            <xsl:attribute name="colspan">
	         <xsl:value-of select="@COLSPAN"/>
	    </xsl:attribute>
	   <xsl:attribute name="title">
	         <xsl:value-of select ="@HINT_MESSAGE" />
	    </xsl:attribute>
	
	    <xsl:apply-templates select="POST-ITEM-ACTIONS"/>
            <xsl:choose>
				<xsl:when test="@STD_COMP_RESULT_TYPE ='L'">
				 	<!--  <input type="text" onKeyDown='restrictBackSpace(this)'> -->
					 <input type="text"> 	
						<xsl:if test="@GRID-COMP = 'Y'">
						<xsl:attribute name="id">list_box_component_of_<xsl:value-of select="@GRID-NAME"/><xsl:value-of select="../@COLINDEX"/></xsl:attribute>
						</xsl:if>
						
						<xsl:attribute name="name"><xsl:value-of select="@NAME"/></xsl:attribute>
						<xsl:attribute name="value"><xsl:value-of select="@STD_COMP_VALUE"/></xsl:attribute>
						<!-- <xsl:attribute name="readonly"></xsl:attribute>  -->
						 <!--<xsl:attribute name="onBlur">lookUp<xsl:value-of select="@NAME"/>(this);</xsl:attribute>-->
						<xsl:attribute name="onBlur">
						  return lookUpOnBlur<xsl:value-of select="@NAME"/>(this.value);
						</xsl:attribute>
					</input>
					<!-- ONBLUR LOOKUP FUNCTION -->
			
			<script>
						function lookUpOnBlur<xsl:value-of select="@NAME"/>(search_text)
						{ 
							var str = "<xsl:value-of select="@NAME"/>";
							
							if(search_text!=""){
							var encounter_id ="";
							var patient_id ="";
							var tempTitle ="";
							var speciality_code = "";
							var facility_id = "";

							if("<xsl:value-of select="@PROMPT"/>" != "") tempTitle = "Lookup For <xsl:value-of select="@PROMPT"/>";
							else tempTitle = "Common Lookup";

							if (parent.parent.RecClinicalNotesHeaderFrame != null)
							{
								encounter_id = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.encounter_id.value
								patient_id = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.patient_id.value
								speciality_code = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.speciality_code.value
								facility_id = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.sel_facility_id.value
								
							}
							
							var action_url = "<xsl:value-of select="@LOOKUP_URL"/>?std_comp_id=<xsl:value-of select="@STD_COMP_ID"/>&amp;title="+tempTitle+"&amp;encounter_id="+encounter_id+"&amp;patient_id="+patient_id+"&amp;speciality_code="+speciality_code+"&amp;facility_id="+facility_id+"&amp;search_text="+search_text+"";
							var returnArray		=	new Array();
							var dialogHeight	=	"25" ;
							var dialogWidth		=	"38" ;
							var status			=	"no";
							var arguments		=	"" ;
							var features		=	"dialogHeight:"+dialogHeight+";dialogWidth:"+dialogWidth+";scroll=yes;status:" + status;
							returnArray		=	window.showModalDialog(action_url,arguments,features);
							//window.open(action_url,arguments,features);
							
							if(returnArray != null)
							{
								//document.getElementById(str).focus();
								eval("document.all."+str).value =unescape(returnArray[1]);
								// document.all.<xsl:value-of select="@NAME"/>.value = unescape(returnArray[1]);
								// document.all.<xsl:value-of select="@NAME"/>_desc.value = returnArray[0];							
								
							}else{
								eval("document.all."+str).value = "";
							}
							}
							return  false;
						}

					</script>
			
			<!-- ONBLUR LOOKUP FUNCTION END -->
					<script>
						function lookUp<xsl:value-of select="@NAME"/>(str)
						{
							var encounter_id ="";
							var patient_id ="";
							var tempTitle ="";
							var speciality_code = "";
							var facility_id = "";

							if("<xsl:value-of select="@PROMPT"/>" != "") tempTitle = "Lookup For <xsl:value-of select="@PROMPT"/>";
							else tempTitle = "Common Lookup";

							if (parent.parent.RecClinicalNotesHeaderFrame != null)
							{
								encounter_id = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.encounter_id.value
								patient_id = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.patient_id.value
								speciality_code = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.speciality_code.value
								facility_id = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.sel_facility_id.value
								
							}
							
							var action_url = "<xsl:value-of select="@LOOKUP_URL"/>?std_comp_id=<xsl:value-of select="@STD_COMP_ID"/>&amp;title="+tempTitle+"&amp;encounter_id="+encounter_id+"&amp;patient_id="+patient_id+"&amp;speciality_code="+speciality_code+"&amp;facility_id="+facility_id+"";
							var returnArray		=	new Array();
							var dialogHeight	=	"25" ;
							var dialogWidth		=	"38" ;
							var status			=	"no";
							var arguments		=	"" ;
							var features		=	"dialogHeight:"+dialogHeight+";dialogWidth:"+dialogWidth+";scroll=yes;status:" + status;
							
							returnArray		=	window.showModalDialog(action_url,arguments,features);
							//window.open(action_url,arguments,features);
							
							if(returnArray != null)
							{
								//document.getElementById(str).focus();
								eval("document.all."+str).value =unescape(returnArray[1]);
								// document.all.<xsl:value-of select="@NAME"/>.value = unescape(returnArray[1]);
								// document.all.<xsl:value-of select="@NAME"/>_desc.value = returnArray[0];							
								
							}

							return  false;
						}

					</script>
					<!--<input type="button" value="?" class="button">-->
					<input type="image" src = "../../eCA/images/Lookup.gif">
						<xsl:if test="@GRID-COMP='Y'">
				         <xsl:attribute name="id">lookup_component_of_<xsl:value-of select="@GRID-NAME"/><xsl:value-of select="../@COLINDEX"/></xsl:attribute>
				         </xsl:if>
						
						<xsl:attribute name="value">
							<xsl:value-of select="@NAME"/>
						</xsl:attribute>
						<xsl:attribute name="onClick">
						  return lookUp<xsl:value-of select="@NAME"/>(this.value);
						</xsl:attribute>
					</input> 
				</xsl:when>

				
				<xsl:otherwise>
					
				<xsl:call-template name="LIST-BOX-WTD">
						<xsl:with-param name="GRID-NAME" select ="@GRID-NAME" ></xsl:with-param>
						<xsl:with-param name="GRID-COMP" select ="@GRID-COMP" ></xsl:with-param>				
					</xsl:call-template>
				</xsl:otherwise>
           </xsl:choose>
	   <xsl:if test="@MANDATORY='Y'">
		&#32;
		<IMAGE SRC="../../eCommon/images/mandatory.gif"/>
 	   </xsl:if>
	<!--checking if any hidden field is to present and if yes the calling the template for constructing the template-->            
            <!--<xsl:apply-templates select="IMAGE" />-->
            <!--<xsl:apply-templates select="HIDDEN-FIELD"/> -->
            <!--========-->
        </td>
   </xsl:template>
   <xsl:template name="LIST-BOX-WTD" match="LIST-BOX-WTD">
          
	   <xsl:choose>
				<xsl:when test="@STD_COMP_RESULT_TYPE ='L'">
					<input type="text" onKeyDown='restrictBackSpace(this)'>
						<xsl:if test="@GRID-COMP = 'Y'">
						 <xsl:attribute name="id">list_box_component_of_<xsl:value-of select="@GRID-NAME"/><xsl:value-of select="../@COLINDEX"/></xsl:attribute>
						</xsl:if>
						<xsl:attribute name="name"><xsl:value-of select="@NAME"/></xsl:attribute>
						<xsl:attribute name="value"><xsl:value-of select="@STD_COMP_VALUE"/></xsl:attribute>
						
					</input>
					<script>
						function lookUp<xsl:value-of select="@NAME"/>()
						{
							
							//alert("##############");
							var encounter_id ="";
							var patient_id ="";
							var tempTitle = "";

							if("<xsl:value-of select="@PROMPT"/>" != "") tempTitle = "Lookup For <xsl:value-of select="@PROMPT"/>";
							else tempTitle = "Common Lookup";

							if (parent.parent.RecClinicalNotesHeaderFrame != null)
							{
								encounter_id = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.encounter_id.value
								patient_id = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.patient_id.value
							}
							
							var action_url = "<xsl:value-of select="@LOOKUP_URL"/>?std_comp_id=<xsl:value-of select="@STD_COMP_ID"/>&amp;title="+tempTitle+"&amp;encounter_id="+encounter_id+"&amp;patient_id="+patient_id+"";
							var returnArray		=	new Array();
							var dialogHeight	=	"25" ;
							var dialogWidth		=	"50" ;
							var status			=	"no";
							var arguments		=	"" ;
							var features		=	"dialogHeight:"+dialogHeight+";dialogWidth:"+dialogWidth+";scroll=yes;status:" + status;
							returnArray		=	window.showModalDialog(action_url,arguments,features);
							//window.open(action_url,arguments,features);
							if(returnArray != null)
							{
								document.all.<xsl:value-of select="@NAME"/>.value = unescape(returnArray[1]);
								document.all.<xsl:value-of select="@NAME"/>_desc.value = returnArray[0];
								
								//alert(returnArray);
							}
							return  false;
						}
						
					</script>
					<input type="image" src = "../../eCA/images/Lookup.gif">
						<xsl:attribute name="onClick">
							return lookUp<xsl:value-of select="@NAME"/>();
						</xsl:attribute>
						<xsl:attribute name="name">
							<xsl:value-of select="@NAME"/>_searchButton
						</xsl:attribute>
					</input>
				</xsl:when>
				<xsl:otherwise>
				<!--	<xsl:call-template name="LIST-BOX-WTD">
						<xsl:with-param name="GRID-NAME" select ="@GRID-NAME" ></xsl:with-param>
						<xsl:with-param name="GRID-COMP" select ="@GRID-COMP" ></xsl:with-param>				
					</xsl:call-template> -->
				</xsl:otherwise>
           </xsl:choose>	
	   <xsl:if test="@STD_COMP_RESULT_TYPE !='L'">
	   <select>
                <xsl:if test="@GRID-COMP = 'Y'">
                    <xsl:attribute name="id">list_box_component_of_<xsl:value-of select="@GRID-NAME"/><xsl:value-of select="../@COLINDEX"/></xsl:attribute>
                </xsl:if>
                <xsl:attribute name="name"><xsl:value-of select="@NAME"/></xsl:attribute>				
                <xsl:attribute name="onchange"><xsl:value-of select="@ONCHANGE"/></xsl:attribute>
                <xsl:if test="@DISABLED='true'">
                    <xsl:attribute name="disabled"></xsl:attribute>
                </xsl:if>
                <xsl:if test="@READONLY='true'">
                    <xsl:attribute name="readonly"></xsl:attribute>
                </xsl:if>
               
				
		<option value="">----- <xsl:value-of select="@DFLTSEL"/> -----</option>
                <xsl:for-each select="DATA">
		
                    <option>
                        <xsl:attribute name="value">
							<xsl:choose>
								<xsl:when test="@LIST_ITEM_ID">
									<xsl:value-of select="@LIST_ITEM_ID"/>
								</xsl:when>
								<xsl:otherwise>
									<xsl:value-of select="@VALUE"/>
								</xsl:otherwise>

							</xsl:choose>							
						</xsl:attribute>
                        <xsl:attribute name="score"><xsl:value-of select="@SCORE"/></xsl:attribute>
                        <xsl:if test="@SELECTED='true'">
                            <xsl:attribute name="selected"></xsl:attribute>
                        </xsl:if>
                        <xsl:value-of select="."/>
                    </option>
                </xsl:for-each>
		 
            </select>
	    </xsl:if>

	     <xsl:if test="@LIST_SELECTION ='S'">
	   <select>
                <xsl:if test="@GRID-COMP = 'Y'">
                    <xsl:attribute name="id">list_box_component_of_<xsl:value-of select="@GRID-NAME"/><xsl:value-of select="../@COLINDEX"/></xsl:attribute>
                </xsl:if>
                <xsl:attribute name="name"><xsl:value-of select="@NAME"/></xsl:attribute>				
                <xsl:attribute name="onchange"><xsl:value-of select="@ONCHANGE"/></xsl:attribute>
                <xsl:if test="@DISABLED='true'">
                    <xsl:attribute name="disabled"></xsl:attribute>
                </xsl:if>
                <xsl:if test="@READONLY='true'">
                    <xsl:attribute name="readonly"></xsl:attribute>
                </xsl:if>
               
				
		<option value="">----- <xsl:value-of select="@DFLTSEL"/> -----</option>
                <xsl:for-each select="DATA">
		     <!--  <xsl:sort select="." data-type="number" order="ascending" />
		       <xsl:sort select="." data-type="text" order="ascending" case-order="upper-first"/> -->

                    <option>
                        <xsl:attribute name="value">
							<xsl:choose>
								<xsl:when test="@LIST_ITEM_ID">
									<xsl:value-of select="@LIST_ITEM_ID"/>
								</xsl:when>
								<xsl:otherwise>
								      <xsl:value-of select="@VALUE"/>
								</xsl:otherwise>

							</xsl:choose>							
						</xsl:attribute>
                        <xsl:attribute name="score"><xsl:value-of select="@SCORE"/></xsl:attribute>
                        <xsl:if test="@SELECTED='true'">
                            <xsl:attribute name="selected"></xsl:attribute>
                       </xsl:if>
                        
			<xsl:value-of select="."/>
                    </option>
                </xsl:for-each>
		 
            </select>
	    </xsl:if>

	<!-- shaiju checking if any hidden field is to present and if yes the calling the template for constructing the template-->            
           <xsl:apply-templates select="IMAGE" /> 
           <xsl:apply-templates select="HIDDEN-FIELD"/> 
   </xsl:template>
  <!--===========================================================================================-->
  <!--=========================for writing the script code from POST-ITEM-ACTIONS================-->
  <xsl:template match="POST-ITEM-ACTIONS">
  <script>
        function fireOnAction<xsl:value-of select="../@NAME"/>(obj)
        {
	     var oOption = "";
            var calender_image_obj;
            <xsl:if test="@TYPE='L'">
                <xsl:for-each select="ACTION">
                    if(obj.value=="<xsl:value-of select="@CODE"/>")
                    {
                        <xsl:for-each select="COMPONENT">
			    if (document.forms(0).<xsl:value-of select="@NAME"/>!=null)
			    {	
                            <xsl:if test="@TYPE!='L'">
                                document.forms(0).<xsl:value-of select="@NAME"/>.disabled = <xsl:value-of select="@STATUS"/>;
                                <xsl:if test="@STATUS='true'">
                                document.forms(0).<xsl:value-of select="@NAME"/>.value = '';
				if(document.forms(0).<xsl:value-of select="@NAME"/>_number_prefix!=null)
				{
					document.forms(0).<xsl:value-of select="@NAME"/>_number_prefix.disabled = <xsl:value-of select="@STATUS"/>;	
					document.forms(0).<xsl:value-of select="@NAME"/>_number_prefix.value = '';
				}
                                </xsl:if>
                                calender_image_obj = document.all.calender_for_<xsl:value-of select="@NAME"/>;
                                if( calender_image_obj != null)
                                {
                                    calender_image_obj.disabled = <xsl:value-of select="@STATUS"/>;
                                    //alert('disabled by a list box...\n status of the component-->' + calender_image_obj.disabled);
                                }
                            </xsl:if>
                            <xsl:if test="@TYPE='L'">
				<xsl:if test="@COMP_TYPE_LINKED=''"><!--INC61905-->
					var obj_ref=document.forms(0).<xsl:value-of select="@NAME"/>;				
					obj_ref.disabled = <xsl:value-of select="@STATUS"/>;
					var len=obj_ref.length;
					for(i=0;i&lt;len;i++)
					   obj_ref.remove(0);					
					<xsl:for-each select="LIST-DATA">
					    oOption = document.createElement("OPTION");
					    oOption.text="<xsl:value-of select="@VALUE"/>";
					    oOption.value="<xsl:value-of select="@CODE"/>";
					    obj_ref.add(oOption);
					</xsl:for-each>
					obj_ref.value="<xsl:value-of select="@DEFAULT-CODE"/>";
					obj_ref.onchange();//INC61905
				</xsl:if><!--INC61905-->
				<xsl:if test="@COMP_TYPE_LINKED != ''"><!--INC61905-->
					var obj_ref=document.forms(0).<xsl:value-of select="@NAME"/>;
					obj_ref.disabled = <xsl:value-of select="@STATUS"/>;
				</xsl:if><!--INC61905-->
                            </xsl:if>
			   }
                        </xsl:for-each>
                    }
                </xsl:for-each>
            </xsl:if>
            <xsl:if test="@TYPE='C'">
		if(obj.checked)
		   obj.value ='Y';
		else
		   obj.value ='N';

                <xsl:for-each select="ACTION">
                    <xsl:if test="@CODE='Y'">
                    if(obj.checked)
                    </xsl:if>
                    <xsl:if test="@CODE!='Y'">
                    if(!obj.checked)
                    </xsl:if>
                    {
                        <xsl:for-each select="COMPONENT">
			if (document.forms(0).<xsl:value-of select="@NAME"/>!=null)
			{
                            <xsl:if test="@TYPE!='L'">
                                
				document.forms(0).<xsl:value-of select="@NAME"/>.disabled = <xsl:value-of select="@STATUS"/>;
				if(document.forms(0).Link_Doc_<xsl:value-of select="@NAME"/>!=null)
					document.forms(0).Link_Doc_<xsl:value-of select="@NAME"/>.disabled = <xsl:value-of select="@STATUS"/>;
                                <xsl:if test="@STATUS='true'">
                                document.forms(0).<xsl:value-of select="@NAME"/>.value = '';
                                </xsl:if>
                                calender_image_obj = document.all.calender_for_<xsl:value-of select="@NAME"/>;
                                if( calender_image_obj != null)
                                {
                                    calender_image_obj.disabled = <xsl:value-of select="@STATUS"/>;
                                    //alert('disabled by a check box..\n status of the component-->' + calender_image_obj.disabled);
                                }
                            </xsl:if>
                            <xsl:if test="@TYPE='L'">
				<xsl:if test="@COMP_TYPE_LINKED=''"><!--INC61905-->
					var obj_ref=document.forms(0).<xsl:value-of select="@NAME"/>;
					obj_ref.disabled = <xsl:value-of select="@STATUS"/>;
					var len=obj_ref.length;
					for(i=0;i&lt;len;i++)
					   obj_ref.remove(0);
					<xsl:for-each select="LIST-DATA">
					    oOption = document.createElement("OPTION");
					    oOption.text="<xsl:value-of select="@VALUE"/>";
					    oOption.value="<xsl:value-of select="@CODE"/>";
					    obj_ref.add(oOption);
					</xsl:for-each>
					obj_ref.value="<xsl:value-of select="@DEFAULT-CODE"/>";
					obj_ref.onchange();//INC61905
				</xsl:if><!--INC61905-->
				<xsl:if test="@COMP_TYPE_LINKED != ''"><!--INC61905-->
					var obj_ref=document.forms(0).<xsl:value-of select="@NAME"/>;
					obj_ref.disabled = <xsl:value-of select="@STATUS"/>;
				</xsl:if><!--INC61905-->
                            </xsl:if>
			 }
                        </xsl:for-each>
                    }
                </xsl:for-each>
            </xsl:if>
        }
    </script>
  </xsl:template>
  <!--===========================================================================================-->

   <!--=======================================for Text Area in short text=========================-->
  <xsl:template match="SHORT-TEXT">
    <xsl:if test="not(@GRID-COMP|@MATRIX-COMP)">
       <td align="right" colspan="1" width="13%">
            <xsl:attribute name="class">label</xsl:attribute>
            <xsl:value-of select="@PROMPT"/>&#160;
            <xsl:if test="@NOWRAP='true'">
                    <xsl:attribute name="nowrap"></xsl:attribute>
            </xsl:if>
     	 </td>
      </xsl:if>
       <td align="left">
        <xsl:if test="@GRID-COMP = 'Y'">
            <xsl:attribute name="align">center</xsl:attribute>            
        </xsl:if>
        <xsl:if test="not(@GRID-COMP = 'Y')">
            <xsl:attribute name="align"><xsl:value-of select="@ALIGN"/></xsl:attribute>
            <xsl:attribute name="nowrap">true</xsl:attribute>
        </xsl:if>
            <xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>

	    <xsl:call-template name="SHORT-TEXT-WTD">
                <xsl:with-param name="GRID-NAME" select ="@GRID-NAME" ></xsl:with-param>
                <xsl:with-param name="GRID-COMP" select ="@GRID-COMP" ></xsl:with-param>
            </xsl:call-template>
	    <xsl:if test="@LINK_HIST_YN = 'Y'">
		    <xsl:apply-templates select="LINK-HISTORY-BUTTON"/>
	    </xsl:if>
	    <xsl:if test="@MANDATORY='Y'">
		&#32;
		<IMAGE SRC="../../eCommon/images/mandatory.gif"/>
 	   </xsl:if>
	   
	</td>

  </xsl:template>
   <xsl:template name="SHORT-TEXT-WTD" match="SHORT-TEXT-WTD">  
   	<textarea rows="1">            
            <xsl:if test="@GRID-COMP = 'Y'">
               <xsl:attribute name="id">short_text_component_of_<xsl:value-of select="@GRID-NAME"/><xsl:value-of select="../@COLINDEX"/></xsl:attribute>           
               <xsl:attribute name="rows"><xsl:value-of select="@ROWS"/></xsl:attribute>
            </xsl:if>
            <xsl:attribute name="name"><xsl:value-of select="@NAME"/></xsl:attribute>
			<xsl:attribute name="title"><xsl:value-of select="@HINT_MESSAGE"/></xsl:attribute>
            <xsl:attribute name="cols"><xsl:value-of select="@COLS"/></xsl:attribute>
            <xsl:if test="@DISABLED='true'">
                <xsl:attribute name="disabled"></xsl:attribute>
		<xsl:attribute name="onKeyDown">return restrictBackSpace(this)</xsl:attribute>
            </xsl:if>
            <xsl:if test="@READONLY='true'">
                <xsl:attribute name="readonly"></xsl:attribute>
		<xsl:attribute name="onKeyDown">return restrictBackSpace(this)</xsl:attribute>
            </xsl:if>
	     <xsl:attribute name="OnBlur">CheckMaximumLength('<xsl:value-of select="@PROMPT"/>',this,'<xsl:value-of select="@SIZE"/>',top.messageFrame)</xsl:attribute> 
            <xsl:value-of select="."/>
        </textarea>
   </xsl:template>
  <!--===========================================================================================-->


  <!--=======================================for Text Area in LONG text=========================-->
  <xsl:template match="LONG-TEXT">    
       <td align="right" colspan="1" width="13%">
            <xsl:attribute name="class">label</xsl:attribute>
            <xsl:value-of select="@PROMPT"/>&#160;
            <xsl:if test="@NOWRAP='true'">
                    <xsl:attribute name="nowrap"></xsl:attribute>
            </xsl:if>
       </td>
       <td align="left" nowrap="true">
            <xsl:attribute name="align"><xsl:value-of select="@ALIGN"/></xsl:attribute>
            <xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>            
            <xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
			<xsl:attribute name="style">hyphens:auto</xsl:attribute>
            <xsl:call-template name="LONG-TEXT-WTD"/>
            <xsl:if test="@RECORD-TYPE!=''">
                <input type="button" class="button" value="Link Doc" name = "" onClick="" >
                   
		   <xsl:attribute name="name">Link_Doc_<xsl:value-of select="@NAME"/></xsl:attribute>
		   <!--IN061907 Start-->
		   <!-- <xsl:attribute name="onClick">showLinkDocumentsFromTemplate('<xsl:value-of select="@RECORD-TYPE"/>','<xsl:value-of select="@NAME"/>')</xsl:attribute>-->
		   <xsl:attribute name="onClick">showLinkDocumentsFromTemplate('<xsl:value-of select="@RECORD-TYPE"/>','<xsl:value-of select="@NAME"/>','<xsl:value-of select="@LINKDOC-YN"/>')</xsl:attribute>
		   <!--IN061907 ends-->
                </input>
            </xsl:if>
			<xsl:if test="@RECORD-TYPE='DIAG'">						
				<IMAGE SRC="../../eCA/images/MI_Diagnosis.gif">
					<xsl:attribute name="onClick">showRecordDiagnosis()</xsl:attribute>
				</IMAGE>
			</xsl:if>
			<input type="button" class="button" value="Canned Text" name = "" onClick="" >
				<xsl:attribute name="name">Can_Txt_<xsl:value-of select="@NAME"/></xsl:attribute>
				<xsl:attribute name="onClick">showCanTxtTemplates('<xsl:value-of select="@NAME"/>','TEMPLATES')</xsl:attribute>							
			</input>
		<xsl:if test="@MANDATORY='Y'">
		&#32;
		<IMAGE SRC="../../eCommon/images/mandatory.gif"/>
 	   </xsl:if>


        </td>
   </xsl:template>
   <xsl:template name="LONG-TEXT-WTD" match="LONG-TEXT-WTD">
        <textarea rows="3" cols="80">
                <xsl:attribute name="name"><xsl:value-of select="@NAME"/></xsl:attribute>
				<xsl:attribute name="id">TEXTA_AREA_<xsl:value-of select="@NAME"/></xsl:attribute>
				<xsl:attribute name="title"><xsl:value-of select="@HINT_MESSAGE"/></xsl:attribute>
                <xsl:if test="@DISABLED='true'">
                    <xsl:attribute name="disabled"></xsl:attribute>
                </xsl:if>
                <xsl:if test="@READONLY='true'">
                    <xsl:attribute name="readonly"></xsl:attribute>
		    <xsl:attribute name="onKeyDown">return restrictBackSpace(this)</xsl:attribute>
                </xsl:if>
		<xsl:attribute name="onBlur">chkMaxLenForLongTest('<xsl:value-of select="@NAME"/>','<xsl:value-of select="@PROMPT"/>')</xsl:attribute>
                <xsl:value-of select="." disable-output-escaping="yes"/>
           </textarea>

   </xsl:template>
  <!--===========================================================================================-->
<!--==============================  IMAGE-TAG Start.====================================-->
<xsl:template match="IMAGE-TAG">    
       <td align="right" colspan="1" width="13%">
            <xsl:attribute name="class">label</xsl:attribute>
            <xsl:value-of select="@PROMPT"/>&#160;
            <xsl:if test="@NOWRAP='true'">
                    <xsl:attribute name="nowrap"></xsl:attribute>
            </xsl:if>
       </td>
       <td align="left" nowrap="true"> &#32;
           
        </td>
   </xsl:template>
<!--================================= IMAGE-TAG End.=================================-->

  <!--=======================================for Title Text =========================-->
  <xsl:template match="TITLE-TEXT">
     <xsl:if test="@TYPE='T'">
       <td >
	   		<xsl:attribute name="style">hyphens:auto</xsl:attribute>	
           <xsl:attribute name="align"><xsl:value-of select="@ALIGN"/></xsl:attribute>
	   <xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
           <font style="FONT-SIZE:9pt;font-weight:bold;background-color:#ADADAD;">
           <xsl:value-of select="."/></font>
       </td>
     </xsl:if>
     <xsl:if test="@TYPE='C'">
       <td>
			<xsl:attribute name="style">hyphens:auto</xsl:attribute>
           <xsl:attribute name="align"><xsl:value-of select="@ALIGN"/></xsl:attribute>
           <xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
           <xsl:attribute name="class"><xsl:value-of select="@CLASS"/></xsl:attribute>
	   <b><xsl:value-of select="."/></b>
       </td>
     </xsl:if>
   </xsl:template>
  <!--===========================================================================================-->


  <!--==================for DATE,TIME,DATE/TIME,INTEGER,DECIMAL FIELD =========================-->
  <xsl:template match="DATE-TIME-NUMERIC">
   <xsl:param name="LANGID"/>	
    <xsl:if test="not(@GRID-COMP|@MATRIX-COMP)">
       <td align="right" nowrap="true" width="13%">
            <xsl:attribute name="class">label</xsl:attribute>
            <xsl:value-of select="@PROMPT"/>&#160;
            <xsl:if test="@NOWRAP='true'">
                    <xsl:attribute name="nowrap"></xsl:attribute>
            </xsl:if>
	</td>
    </xsl:if>
        <td align="left" nowrap="true">
            <xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
            <xsl:attribute name="align"><xsl:value-of select="@ALIGN"/></xsl:attribute>
<!--    <xsl:attribute name="class"><xsl:value-of select="@CLASS"/></xsl:attribute>-->
            <xsl:if test="@GRID-COMP='Y'">                
                <xsl:attribute name="align">center</xsl:attribute>                
            </xsl:if>
            <xsl:call-template name="DATE-TIME-NUMERIC-WTD">
                <xsl:with-param name="GRID-NAME"	select = "@GRID-NAME"></xsl:with-param>
                <xsl:with-param name="GRID-COMP"	select = "@GRID-COMP" ></xsl:with-param>
                <xsl:with-param name="HINT_MESSAGE"	select = "@HINT_MESSAGE" ></xsl:with-param>
		<xsl:with-param name="COMP_TYPE"	select = "@COMPTYPE" ></xsl:with-param>
            </xsl:call-template>
	   <!-- <xsl:choose>
	       <xsl:when test="@LINK_HIST_YN='Y'">
		<xsl:apply-templates select="LINK-HISTORY-BUTTON"/>
	      </xsl:when>
	      <xsl:otherwise>
			<xsl:if test="@COMPTYPE='D' or @COMPTYPE ='E'">  
			<input type="image" src = "../../eCommon/images/CommonCalendar.gif">
				<xsl:if test="@GRID-COMP='Y'">
				    <xsl:attribute name="id">calender_component_of_<xsl:value-of select="@GRID-NAME"/><xsl:value-of select="../@COLINDEX"/></xsl:attribute>
				</xsl:if>
				<xsl:attribute name="value"><xsl:value-of select="@NAME"/></xsl:attribute>
				<xsl:if test="@COMPTYPE='D'">
					<xsl:attribute name="onClick">return templateCalendarValidate(this.value,'N')</xsl:attribute>
				</xsl:if>
				<xsl:if test="@COMPTYPE='E'">
					<xsl:attribute name="onClick">return templateCalendarValidate(this.value,'Y')</xsl:attribute>
				</xsl:if>
				 <xsl:if test="not(@GRID-COMP|@MATRIX-COMP)">              
					<xsl:attribute name="name">calender_for_<xsl:value-of select="@NAME"/></xsl:attribute>	
				</xsl:if>
		    </input>
		    </xsl:if>
	      </xsl:otherwise>
	   </xsl:choose>  
	   <xsl:if test="@MANDATORY='Y'">
		&#32;
		<IMAGE SRC="../../eCommon/images/mandatory.gif"/>
	   </xsl:if>  -->


            <!--checking if any hidden field is to present and if yes the calling the template for constructing the template-->
            <!--  <xsl:apply-templates select="HIDDEN-FIELD"/> -->
            <!--========-->
        </td>
   </xsl:template>
   <xsl:template name="DATE-TIME-NUMERIC-WTD" match="DATE-TIME-NUMERIC-WTD">    
		<xsl:choose>
			<xsl:when test="@NUM_PREFIX_REQUIRED_YN = 'Y'">
				<input type="text" size="1" maxlength="1">
					<xsl:attribute name="name"><xsl:value-of select="@NAME"/>_number_prefix</xsl:attribute>
					<xsl:attribute name="OnKeyPress">return allowValidChar()</xsl:attribute>
					<xsl:attribute name="value"><xsl:value-of select="@PREFIX_CHAR"/></xsl:attribute>
				</input>
			</xsl:when>
		</xsl:choose>
       <input>
		   <xsl:attribute name="title">
			   <xsl:value-of select="@HINT_MESSAGE"/>
		   </xsl:attribute>
		   
            <xsl:if test="@GRID-COMP='Y'">
	            <xsl:attribute name="id">date_time_numeric_component_of_<xsl:value-of select="@GRID-NAME"/><xsl:value-of select="../@COLINDEX"/></xsl:attribute>
            </xsl:if>
                <xsl:attribute name="size"><xsl:value-of select="@SIZE"/></xsl:attribute>
                <xsl:attribute name="maxlength"><xsl:value-of select="@MAXLENGTH"/></xsl:attribute>

                
                <xsl:attribute name="name"><xsl:value-of select="@NAME"/></xsl:attribute>                
                <xsl:if test="@READONLY='true'">
                    <xsl:attribute name="readonly"></xsl:attribute>
		    <xsl:attribute name="onKeyDown">return restrictBackSpace(this)</xsl:attribute>
                </xsl:if>
                <xsl:if test="@DISABLED='true'">
                    <xsl:attribute name="disabled"></xsl:attribute>
		    <xsl:attribute name="onKeyDown">return restrictBackSpace(this)</xsl:attribute>
                </xsl:if>
		
		
		<xsl:choose>
			<xsl:when test="@COMPTYPE='D'">
			<xsl:if test="@GRID-COMP='Y'"> <!--IN033507 Start Modified-->
				<!--<xsl:attribute name="onBlur">return CheckDate(this);getFormulaResult()</xsl:attribute> Commented for IN071708 -->
				<xsl:attribute name="onBlur">return CheckDateNew(this);getFormulaResult()</xsl:attribute><!--Added for IN071708 -->
				<xsl:attribute name="value"><xsl:value-of select="@VALUE"/></xsl:attribute>
			</xsl:if>
			<xsl:if test="not(@GRID-COMP)"> 
				<!--<xsl:attribute name="onBlur">return CheckDate(this);getFormulaResult()</xsl:attribute>--><!--INC61905-->
				<!--<xsl:attribute name="onBlur">if(CheckDate(this)){getFormulaResult();<xsl:value-of select="@ONBLUR"/>}</xsl:attribute>-->
				<!--INC61905--><!--Commented for IN071708-->
				<xsl:attribute name="onBlur">if(CheckDateNew(this)){getFormulaResult();<xsl:value-of select="@ONBLUR"/>}</xsl:attribute><!--Added for IN071708-->
				<xsl:attribute name="value"><xsl:value-of select="@OTHLANGVAL"/></xsl:attribute>
			</xsl:if>
				
			<!--<xsl:if test="@ONBLURREQ='Y' and @COMPID='C_LMP'">
				<xsl:attribute name="onBlur">getFormulaResult()</xsl:attribute>
			</xsl:if> -->
				<!--<xsl:attribute name="OnMouseOver">return displaytt(this)</xsl:attribute>-->
			</xsl:when>
			<xsl:when test="@COMPTYPE='E'">
			<xsl:if test="@GRID-COMP='Y'">
				<xsl:attribute name="onBlur">return callCheckDateTime(this)</xsl:attribute>
				<xsl:attribute name="value"><xsl:value-of select="@VALUE"/></xsl:attribute>
			</xsl:if>
			<xsl:if test="not(@GRID-COMP)">
				<!--<xsl:attribute name="onBlur">return callCheckDateTime(this)</xsl:attribute>--><!--INC61905-->
				<xsl:attribute name="onBlur">if(callCheckDateTime(this)){<xsl:value-of select="@ONBLUR"/>;return false;}</xsl:attribute><!--INC61905-->
				<xsl:attribute name="value"><xsl:value-of select="@OTHLANGVAL"/></xsl:attribute>
			</xsl:if> <!--IN033507 End - Modified -->
			</xsl:when>
			<xsl:when test="@COMPTYPE='T'">
				<xsl:attribute name="onBlur">return callCheckTime(this)</xsl:attribute>
				<xsl:attribute name="value"><xsl:value-of select="@VALUE"/></xsl:attribute>
			</xsl:when>
			<xsl:when test="@COMPTYPE='I'">
				<!--<xsl:attribute name="onBlur">return checkValidRange1(this,'<xsl:value-of select="@NAME"/>',<xsl:value-of select="@MIN_DIGIT"/>,0,"<xsl:value-of select="@PROMPT"/>")</xsl:attribute>--><!--INC61905-->
				<xsl:attribute name="onBlur">checkValidRange1(this,'<xsl:value-of select="@NAME"/>',<xsl:value-of select="@MIN_DIGIT"/>,0,"<xsl:value-of select="@PROMPT"/>");<xsl:value-of select="@ONBLUR"/></xsl:attribute><!--INC61905-->
				<xsl:attribute name="OnKeyPress">return allowValidNumberLocal(this,event,<xsl:value-of select="@SIZE"/>,0)</xsl:attribute>
				<!--<xsl:attribute name="OnMouseOver">return displaytt(this)</xsl:attribute>-->
				<xsl:attribute name="value"><xsl:value-of select="@VALUE"/></xsl:attribute>
			</xsl:when>
			<xsl:when test="@COMPTYPE='N'">
				<!--<xsl:attribute name="onBlur">return checkValidRange1(this,'<xsl:value-of select="@NAME"/>',<xsl:value-of select="@MIN_DIGIT"/>,<xsl:value-of select="@DEC_DIGIT"/>,"<xsl:value-of select="@PROMPT"/>")</xsl:attribute>--><!--INC61905-->
				<xsl:attribute name="onBlur">checkValidRange1(this,'<xsl:value-of select="@NAME"/>',<xsl:value-of select="@MIN_DIGIT"/>,<xsl:value-of select="@DEC_DIGIT"/>,"<xsl:value-of select="@PROMPT"/>");<xsl:value-of select="@ONBLUR"/></xsl:attribute><!--INC61905-->
				<xsl:attribute name="OnKeyPress">return allowValidNumberLocal(this,event,<xsl:value-of select="@SIZE"/>,<xsl:value-of select="@DEC_DIGIT"/>)</xsl:attribute>
				<xsl:attribute name="value"><xsl:value-of select="@VALUE"/></xsl:attribute>
			</xsl:when>
		</xsl:choose>
         </input>
	 <xsl:value-of select="@UNIT"/>&#160;

	 
	<xsl:choose>
	      <xsl:when test="@LINK_HIST_YN='Y'">
		<xsl:apply-templates select="LINK-HISTORY-BUTTON"/>
	      </xsl:when>
	      <xsl:otherwise>
			<xsl:if test="@COMPTYPE='D' or @COMPTYPE ='E'">  
			<input type="image" src = "../../eCommon/images/CommonCalendar.gif">
				<xsl:if test="@GRID-COMP='Y'">
				    <xsl:attribute name="id">calender_component_of_<xsl:value-of select="@GRID-NAME"/><xsl:value-of select="../@COLINDEX"/></xsl:attribute>
				</xsl:if>
				<xsl:attribute name="value"><xsl:value-of select="@NAME"/></xsl:attribute>
				<xsl:if test="@COMPTYPE='D'">
					<!--<xsl:attribute name="onClick">return templateCalendarValidate(this.value,'N')</xsl:attribute>--><!--INC61905-->
					<xsl:attribute name="onClick">templateCalendarValidate(this.value,'N');<xsl:value-of select="@ONBLUR"/>;return false;</xsl:attribute><!--INC61905-->			
				</xsl:if>
				<xsl:if test="@COMPTYPE='E'">
					<!--<xsl:attribute name="onClick">return templateCalendarValidate(this.value,'Y')</xsl:attribute>--><!--INC61905-->
					<xsl:attribute name="onClick">templateCalendarValidate(this.value,'Y');<xsl:value-of select="@ONBLUR"/>;return false;</xsl:attribute><!--INC61905-->
				</xsl:if>
				 <xsl:if test="not(@GRID-COMP|@MATRIX-COMP)">              
					<xsl:attribute name="name">calender_for_<xsl:value-of select="@NAME"/></xsl:attribute>	
				</xsl:if>
		    </input>
		    </xsl:if>
	      </xsl:otherwise>
	   </xsl:choose>
	
	<xsl:if test="@MANDATORY='Y'">
		&#32;
		<IMAGE SRC="../../eCommon/images/mandatory.gif"/>
	   </xsl:if>

	   <!--checking if any hidden field is to present and if yes the calling the template for constructing the template-->
            <xsl:apply-templates select="HIDDEN-FIELD"/>
            <!--========-->
		
   </xsl:template>
   <!--========================================================================================-->


   <!--====================================for hidden field================================-->
   <xsl:template match="HIDDEN-FIELD">
            <input type="hidden">
                <xsl:attribute name="name"><xsl:value-of select="@NAME"/></xsl:attribute>
                <xsl:attribute name="value"><xsl:value-of select="@VALUE"/></xsl:attribute>
            </input>
   </xsl:template>
   <!--=====================================================================================-->


   <!--====================================for script ================================-->
   <xsl:template match="SCRIPT">
            <script>
                <xsl:attribute name="language"><xsl:value-of select="@LANGUAGE"/></xsl:attribute>
                <xsl:attribute name="type"><xsl:value-of select="@TYPE"/></xsl:attribute>
                <xsl:attribute name="src"><xsl:value-of select="@SRC"/></xsl:attribute>
                <xsl:value-of select="."/>
            </script>
   </xsl:template>
   <!--=====================================================================================-->


   <!--====================================for Calander ================================-->
   <xsl:template match="CALANDER">            
            <input type="image" src = "../../eCommon/images/CommonCalendar.gif">
                <xsl:if test="../@GRID-COMP = 'Y'">
                    <xsl:attribute name="id">calender_component_of_<xsl:value-of select="../@GRID-NAME"/><xsl:value-of select="../../@COLINDEX"/></xsl:attribute>
                </xsl:if>
		<xsl:attribute name="value"><xsl:value-of select="../@NAME"/></xsl:attribute>
		<xsl:if test="../@COMPTYPE = 'D'">
			<xsl:attribute name="onClick">return templateCalendarValidate(this.value,'N')</xsl:attribute>
		</xsl:if>
		<xsl:if test="../@COMPTYPE = 'E'">
			<xsl:attribute name="onClick">return templateCalendarValidate(this.value,'Y')</xsl:attribute>
		</xsl:if>
		<xsl:attribute name="name">calender_for_<xsl:value-of select="../@NAME"/></xsl:attribute>
            </input>
   </xsl:template>
   <!--=====================================================================================-->


   <!--=====================================================================================-->

      <!--====================================for LINK HISTORY TYPE BUTTON ================================-->
   <xsl:template match="LINK-HISTORY-BUTTON">
       <input type="button" value="H" class="button" >
		<xsl:attribute name="name">
		<xsl:value-of select="@NAME"/>_histsearchButton
		</xsl:attribute>
		<xsl:attribute name="onClick">
		<xsl:value-of select="@ONCLICK"/>
		</xsl:attribute>
	</input>
  </xsl:template>
   <!--=====================================================================================-->


   <!--====================================for CSS Style ================================-->
   <xsl:template match="STYLE">
            <style>
                <xsl:attribute name="type"><xsl:value-of select="@TYPE"/></xsl:attribute>
                <xsl:value-of select="."></xsl:value-of>
            </style>
   </xsl:template>
   <!--=====================================================================================-->
   <!--================for any extra thigs added from the jsp page directly ================-->

  <xsl:template match="FREE-TAG">
            <xsl:value-of select="." disable-output-escaping="yes"/>
  </xsl:template>
  <!--=====================================================================================-->
  <!--================for any extra thigs added from the jsp page directly ================-->

  <xsl:template match="PRE" >
	    <font style="font-size:9pt;font-face:verdana;font-style:normal;hyphens:auto;"  class="QRYEVEN"><xsl:value-of select="." disable-output-escaping="yes"/></font>
  </xsl:template>
  <!--=====================================================================================-->
   
   <!--================for any extra thigs added from the jsp page directly ================-->

  <xsl:template match="CALL-ON-UNLOAD">
            <xsl:attribute name="value"><xsl:value-of select="@VALUE" disable-output-escaping="yes"/></xsl:attribute>
  </xsl:template>
  <!--=====================================================================================-->
  
 </xsl:stylesheet>