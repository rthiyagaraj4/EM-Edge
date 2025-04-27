<?xml version="1.0" encoding="UTF-8" ?> 
<!--
    Document   : RecClinicalNotesTemplateRecordingView.xsl
    Description:
                 This transformation is for viewing the template in recording mode for Mobile. Using this transformation, the user
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
            <link rel="stylesheet" type="text/css" href="../../eIPAD/css/CommonCalendar.css"/>
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
            <body onKeyDown='lockKey()'>
                <xsl:attribute name="onLoad"><xsl:value-of select="USER-TEMPLATE/CALL-ON-LOAD/@VALUE"/><xsl:value-of select="@ONLOAD"/></xsl:attribute>
                <form>
                    <xsl:attribute name="name"><xsl:value-of select="@FORM-NAME"/></xsl:attribute>
                    <xsl:apply-templates/><!--for USER-TEMPLATE-->                    
                </form>
        </body>
            <!--added for calling formula functions on click of OK on trasactions-->
            <script>
                function callForLoadingFormulaResults()
                {
                    <xsl:value-of select="USER-TEMPLATE/CALL-ON-UNLOAD/@VALUE"/>
                }
            </script>
     </html>
    </xsl:template>
    <!--=======================================================================-->
    <!--======================traversing through the template================================-->
    <!--=======================================================================-->
    <xsl:template match="MATRIX">
        <td class='matScrollTable'>            
            <xsl:attribute name="COLSPAN">
                <xsl:value-of select="@COLSPAN">
                </xsl:value-of>
            </xsl:attribute>
	    <div id="matrixScroll">          
            <table style="display:block;overflow:hidden;width:100%;" border="1" cellspacing="0" cellpadding="0">
                <xsl:attribute name="id"><xsl:value-of select="@NAME"/></xsl:attribute>
                <xsl:attribute name="data-matrix"><xsl:value-of select="@NAME"/></xsl:attribute>             
                <xsl:apply-templates/>
            </table>
             </div>        
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
            <th align="right" width="5%" style = "BACKGROUND-COLOR:#9499C7;color:black;font-size:10pt;font-weight:bold;min-width:190px;max-width:245px;text-align: center;">
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
        <td class='matScrollTable'>
        <xsl:attribute name="COLSPAN">
            <xsl:value-of select="@COLSPAN">
            </xsl:value-of>
        </xsl:attribute>
       <div id="gridScroll" class="matrixWidth">    
        <table class="gridClass" border="3" cellspacing="0" cellpadding="0" >
            <xsl:attribute name="ID"><xsl:value-of select="@NAME"/></xsl:attribute>
            <xsl:apply-templates/>
        </table>
        </div>      
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
            <td  style=" min-width: 50px;max-width: 245px;" align='center'>
                <a>
                <xsl:if test="@ROWINDEX='1'">
                    <xsl:attribute name="style">display:block</xsl:attribute>
                </xsl:if>
                <xsl:attribute name="id">anchor_delete_this_row<xsl:value-of select="../@NAME"/></xsl:attribute>
                <xsl:attribute name="href">javaScript:removeRow('<xsl:value-of select="../@NAME"/>',<xsl:value-of select="@ROWINDEX"/>);</xsl:attribute>
                
                <B>-</B>
                </a>
            </td>
            <td style=" min-width: 50px;max-width: 245px;" align='left'>
                <a>
                <xsl:attribute name="id">anchor_adding_row_below<xsl:value-of select="../@NAME"/></xsl:attribute>
                <xsl:attribute name="href">javaScript:addNewRow('<xsl:value-of select="../@NAME"/>',<xsl:value-of select="@ROWINDEX"/>+1);</xsl:attribute>
                
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
    <td class="matScrollTable">
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
    <TD class="label" ALIGN="RIGHT">
        <xsl:value-of select="."/>
    </TD>
    <td>
        <xsl:choose>
            <xsl:when test="../../@LIST_SELECTION='M'">
                <input type="checkbox" style="height:20px; width:20px;">
                    <xsl:if test="@SELECTED='true'">
                        <xsl:attribute name="checked"></xsl:attribute>
                    </xsl:if>
                    <xsl:attribute name="name"><xsl:value-of select="@NAME"></xsl:value-of></xsl:attribute>
                </input>
            </xsl:when>
            <xsl:otherwise>
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
            </xsl:otherwise>
        </xsl:choose>
    </td>
  </xsl:template>
  <xsl:template match="TEXT">
    <tr>
        <td colspan="1" align="right" class="label">
		<xsl:value-of select="@MISCDISP1"/>
        </td>
        <td colspan="9" align="left">
            <table>
                <tr>
                    <td class="label" colspan="9" align="left">
                            <input style="height:20px; width:20px;" >
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
                 <tr>
                 <td>
                <table border="0" cellpadding='0' cellspacing='0' width="100%" style='table-layout:fixed' id='xmlTemplate'>
                <xsl:for-each select="ROW">
                <tr style="padding:5px">
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
                 </tr>
        </table>
            <xsl:for-each select="HIDDEN-FIELD">
                <xsl:apply-templates select="."/>
            </xsl:for-each>
              <script type="text/javascript">
         function baseStructure(){
         var tableStructure = document.getElementById('xmlTemplate').rows.length;
           
         var firstRowColumns = document.getElementById('xmlTemplate').rows[0].cells.length; 
		   
           if(firstRowColumns == "1"){
			  var checkFirstCell = document.getElementById('xmlTemplate').rows[0].cells[0];
			  var checkFirstCellId = $(checkFirstCell).find("div:first").attr("id");
			  var cellHasAttribute = $(checkFirstCell).find("table:first-child").attr("data-matrix");
			  
			  	 if(checkFirstCellId == "matrixScroll" || checkFirstCellId == "gridScroll")
				 {
					$(checkFirstCell).attr('colspan',1); 
				 }

			  
			  if(cellHasAttribute != undefined || cellHasAttribute != null){
			     $('#matrixScroll').addClass('matrixWidth');
				 $('#xmlTemplate').find('tr:first').append('<td class='matScrollTable' colspan="3"></td>');
                 $('#xmlTemplate').find('tr:first').append('<td class='matScrollTable' colspan="3"></td>');
			  }
			  else{
			     $('#xmlTemplate').find('tr:first').append('<td class='matScrollTable'></td>');
                 $('#xmlTemplate').find('tr:first').append('<td class='matScrollTable'></td>');
			  }
           }
           else if(firstRowColumns == "2"){
              $('#xmlTemplate').find('tr:first').append('<td class='matScrollTable'></td>'); 
           }
           else if(firstRowColumns == "0"){
              $('#xmlTemplate').find('tr:first').append('<td class='matScrollTable'></td>');
              $('#xmlTemplate').find('tr:first').append('<td class='matScrollTable'></td>');
              $('#xmlTemplate').find('tr:first').append('<td class='matScrollTable'></td>'); 
           }
        }
		
		
	
	$(document).ready(function(){
	
    document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false); 	
	baseStructure();	
	$('textarea').each(function(index){
			$(this).bind('touchmove', function(event){
		    	event.stopPropagation();
			});
		});
	$("input[data-dater]").each( function (index, value) {
	var getValues =$(this).attr('data-dater');
	var dateOrDateTime =$(this).attr('data-max');	
	if(dateOrDateTime==10){
	
	$("#"+getValues).kendoDatePicker({
	interval: 5,
	format: "dd/MM/yyyy",
	open : function (e) 
	{ 
	if( /Android/i.test(navigator.userAgent) ) {

	      $("#"+getValues).focus();
        
        }            
    }
	});	
	}else if(dateOrDateTime==5){
	$("#"+getValues).kendoTimePicker({
	open : function (e) 
	{   if( /Android/i.test(navigator.userAgent) ) {

	      $("#"+getValues).focus();
         }
                    
    },
	format: "HH:mm"
	 });
	
	}
	else 
	{	
	$("#"+getValues).kendoDateTimePicker({
	open : function (e) 
	{  if( /Android/i.test(navigator.userAgent) ) {

	      $("#"+getValues).focus();
          }
                    
    },
    format: "dd/MM/yyyy HH:mm",
	});	
	}
//	$("#"+getValues).attr("readonly","readonly");	
    $("#"+getValues).parent('span').parent('span').css({"border-top": "1px solid #62a0ba",border: "1px solid #d6d6d6", "box-shadow": "inset 0px 1px 0px 0px #ffffff","border-radius": "3px","-moz-border-radius": "3px", height:"42px"});
	 $("#"+getValues).parent('span').parent('span').addClass("controlsWidth");
	});
	$("input[data-dropper]").each( function (index, value) {
	var getcomp_id =$(this).attr('comp_id');
	var getValues =$(this).attr('data-dropper');
	$.ajax({
		  method: "GET",
		  url:"../../../mobile/charts/notes/MRecClinicalNotesTemplateSFS",
		  data: {search_id: getcomp_id}
	})
	.done(function(response) {

	if(response==null){
	return;
	}
	$("#"+getValues).kendoComboBox({
	dataTextField: "desc",
	dataValueField: "code",
	dataSource: response,
	filter: "contains",
	suggest: true,
	index: 3,
	open : function (e) 
	{  
	if( /Android/i.test(navigator.userAgent) ) {

	      $("#inp_"+getValues+"_listbox").focus();    
      }   
       
                
    },
	change : function (e) 
	{    
          $("#list_boxes"+getValues).val(this.text());
                    
    }
	});
	
	$("input[aria-owns]").each( function (index, value) {
	    var aria_owns =$(this).attr('aria-owns');
		$(this).attr("id","inp_"+aria_owns);
		
		});
		
$("#"+getValues).data("kendoComboBox");	
		
var prevValue=$("#list_boxes"+getValues).val();

var comboboxValue = $("#"+getValues).data("kendoComboBox");

   comboboxValue.value(prevValue);
	$(".k-input").css({"width":"161px"});	
    $(".k-list-container").css({"word-wrap": "break-word"});	
	$("#"+getValues).parent('span').css({"border-top": "1px solid #62a0ba",border: "1px solid #d6d6d6", "box-shadow": "inset 0px 1px 0px 0px #ffffff","border-radius": "3px","-moz-border-radius": "3px",height:"42px","margin-left":"5px",width:""});	
	$("#"+getValues).parent('span').addClass("controlsWidth");
	});
	});
	var stdLinkComponent=$('input[name=std_component_information]').val();

	if((stdLinkComponent!='')){

	$.ajax({
	method: "GET",
	url:"../../../eIPAD/jsp/chartwidgets/clinicalnotes/MRecRecClinicalNotesStdCompLinking.jsp",
	data: {std_component_information: stdLinkComponent}
	})
	.done(function(response) 
	{
		var data=response;
		data.forEach(function(objs) 
		{
			var code=objs.code;
			var desc=objs.desc;	
			var getCurrentObj = $("#"+code).attr('compid');
			if(getCurrentObj=='N'||getCurrentObj=='I')
			{
				$("#"+code).val(desc);
			}
			else
			{
		if(getCurrentObj!=undefined){
	var datepicker = $("#"+code).data("kendoDateTimePicker");
	var res = desc.split("/");
	var dateConvert=res[1]+"/"+res[0]+"/"+res[2];
	var curentValue=$("#"+code).val();

if(curentValue==""){
if(dateConvert!=null){
var dateValue = new Date(dateConvert);

var dateOrDateTime =$("#"+code).attr('data-max');

if(dateOrDateTime==10){

$("#"+code).data("kendoDatePicker").value(dateValue);

}else{

$("#"+code).data("kendoDateTimePicker").value(dateValue);

}

}
}
}
	
	 
	 }
    
   

	});

	});

	}

	<!-- var matScroll=$("#matrixScroll1").outerHeight()+"px";
	$("#matrixScroll").mCustomScrollbar({
	axis:"yx",
	setHeight: matScroll,
	setWidth: "auto" ,
	theme:"dark"
	});
	var gridScroll=$("#gridScroll1").outerHeight()+"px";
	$("#gridScroll").mCustomScrollbar({
	axis:"yx",
	setHeight: "70px",
	setWidth: "auto" ,
	theme:"dark"
	});
 -->
	});
       
       </script>
            
       
    </xsl:template>
    <!--=======================================================================================-->
   <!--==================for Paragraph template =========================-->
   <xsl:template match="PARAGRAPH" >
          <td align="left" class="label matScrollTable">			
            <xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
            <table width="98%" style="font-face:verdana;" border="0">
				<tbody >
					<tr>
						<td class="label matScrollTable" >
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
        <td style="padding:5px" class="matScrollTable">
         <div style="width: 245px">
            <xsl:attribute name="class"><xsl:value-of select="@CLASS"/></xsl:attribute>
            <xsl:value-of select="@PROMPT"/>&#160;
         </div>   

        <div style="width: 245px">
            <xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
            <input readonly="true" onKeyDown='restrictBackSpace(this)' class="controlsWidth" style="height: 38px; -webkit-appearance: none;border-top: 1px solid rgb(191, 191, 191);border-bottom: 1px solid rgb(191, 191, 191);border-left: 1px solid rgb(191, 191, 191);border-right: 1px solid rgb(191, 191, 191);border-radius:3px;">
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

            <image SRC="../../../eIPAD/images/calcResult.gif" title='Click here to find the formula result' style="cursor:hand">
                <xsl:attribute name="onclick"><xsl:value-of select="@FORMULA-FUNC"/></xsl:attribute>
            </image>
         </div>   
        </td>
   </xsl:template>
   <!--===============================for Empty row and column=====================================-->
   <xsl:template match="EMPTY-COLUMN">
   <xsl:if test="@GRID-COMP|@MATRIX-COMP">
        <td>
            <xsl:if test="@GRID-COMP|@MATRIX-COMP">
                <xsl:attribute name="width">
                   
                </xsl:attribute>
            </xsl:if>        
            <xsl:if test="@MATRIX-COMP = 'Y'">
                <xsl:attribute name="colspan">
                    <xsl:value-of select="@COLSPAN"/>
                </xsl:attribute>
            </xsl:if>
        </td>
   </xsl:if>    
   </xsl:template>
   <xsl:template match="EMPTY-ROW">
        
   </xsl:template>
  <!--===========================================================================================-->


   <!--===============================template for checkbox=======================================-->
   <xsl:template match="CHECK-BOX">
    <xsl:if test = "not(@GRID-COMP|@MATRIX-COMP)">
       <td nowrap="true" class="matScrollTable">           
            <xsl:value-of select="@PROMPT"/>
            <xsl:if test="@NOWRAP='true'">
                <xsl:attribute name="nowrap"></xsl:attribute>
            </xsl:if>
           
		    <xsl:if test="@MANDATORY='Y'">
		&#32;
		<font style="color: red">*</font>
		<script>
		mandatoryCheck = true;
		 var JSONObj = {};
		         JSONObj.id="<xsl:value-of select="@NAME" />";
		         JSONObj.value=mandatoryCheck;
		         JSONObj.component="checkbox";
		         CheckValArray.push(JSONObj);
		</script>
 	   </xsl:if>
 	   <xsl:attribute name="align"><xsl:value-of select="@ALIGN"/></xsl:attribute>
            <xsl:if test="@GRID-COMP = 'Y'">
            </xsl:if>
            <xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
            <xsl:apply-templates select="POST-ITEM-ACTIONS"/>            
            <xsl:call-template name="CHECK-BOX-WTD">            
                <xsl:with-param name="GRID-NAME" select="@GRID-NAME"></xsl:with-param>
                <xsl:with-param name="GRID-COMP" select ="@GRID-COMP" ></xsl:with-param>
            </xsl:call-template>            
	     <xsl:attribute name="id"><xsl:value-of select="@NAME"/></xsl:attribute>
       </td>
    </xsl:if>
       
   </xsl:template>
   <xsl:template name="CHECK-BOX-WTD" match="CHECK-BOX-WTD">
        <input type="checkbox" style="height:20px; width:20px;">
            <xsl:if test="@GRID-COMP='Y'">
                <xsl:attribute name="id">check_box_component_of_<xsl:value-of select="@GRID-NAME"/><xsl:value-of select="../@COLINDEX"/></xsl:attribute>
            </xsl:if>
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
          </input><br></br>
           <label style="font-size:11px;font-style: italic;color:#c5c5c5;"> 
            <xsl:value-of select="@HINT_MESSAGE"/>
         </label>
   </xsl:template>
  <!--===========================================================================================-->


  <!--=======================================for Combo-box===================================-->

	<xsl:template match="LIST-BOX">
		<!-- <xsl:if test="not(@GRID-COMP|@MATRIX-COMP)"> -->
		<td style="padding: 5px" class="matScrollTable">
			<div class="controlsWidth">
				<xsl:attribute name="class">label</xsl:attribute>
				<xsl:attribute name="style">word-break:break-strict</xsl:attribute>
				<xsl:attribute name="title"><xsl:value-of select="@HINT_MESSAGE" /></xsl:attribute>
				<xsl:value-of select="@PROMPT" />
				&#160;
				<xsl:if test="@NOWRAP='true'">
					<xsl:attribute name="nowrap"></xsl:attribute>
				</xsl:if>
				<xsl:if test="@MANDATORY='Y'">
		        &#32;
		        <font style="color: red">*</font>
		        <script>
		         mandatoryCheck = true;		         
		         var JSONObj = {};		         
		         JSONObj.id="<xsl:value-of select="@NAME" />";
		         JSONObj.value=mandatoryCheck;
		         JSONObj.component="dropdown";		         
		         CheckValArray.push(JSONObj);         

		        </script>
 	            </xsl:if>
			</div>
			<div style="width: 245px">
			 <xsl:attribute name="id"><xsl:value-of select="@NAME"/></xsl:attribute>
				<xsl:if test="@GRID-COMP = 'Y'">
					<xsl:attribute name="align">center</xsl:attribute>
				</xsl:if>
				<xsl:attribute name="colspan">
	                <xsl:value-of select="@COLSPAN" />
	            </xsl:attribute>
				<xsl:attribute name="title">
	               <xsl:value-of select="@HINT_MESSAGE" />
	            </xsl:attribute>

				<xsl:apply-templates select="POST-ITEM-ACTIONS" />
				<xsl:choose>
					<xsl:when test="@STD_COMP_RESULT_TYPE ='L'">
						<input style="background-color:white; width: 200px;">
							<xsl:attribute name="id"><xsl:value-of
								select="@NAME" /></xsl:attribute>
							<xsl:attribute name="data-dropper"><xsl:value-of
								select="@NAME" /></xsl:attribute>
							<xsl:attribute name="comp_id"><xsl:value-of
								select="@STD_COMP_ID" /></xsl:attribute>
						</input>
												<input type="hidden">
							<xsl:attribute name="id">list_boxes<xsl:value-of
								select="@NAME" /></xsl:attribute>
							<xsl:attribute name="name"><xsl:value-of
								select="@NAME" /></xsl:attribute>
							<xsl:attribute name="value"><xsl:value-of select="@STD_COMP_VALUE"/></xsl:attribute>
							
						</input>
	
					</xsl:when>


					<xsl:otherwise>
						<xsl:call-template name="LIST-BOX-WTD">
							<xsl:with-param name="GRID-NAME" select="@GRID-NAME"></xsl:with-param>
							<xsl:with-param name="GRID-COMP" select="@GRID-COMP"></xsl:with-param>
						</xsl:call-template>
					</xsl:otherwise>
				</xsl:choose>
				
 	        </div>
 	        <label style="font-size:11px;font-style: italic;color:#c5c5c5;"> 
            <xsl:value-of select="@HINT_MESSAGE"/>
            </label>
        </td>
   </xsl:template>
    
   <xsl:template name="LIST-BOX-WTD" match="LIST-BOX-WTD">
          
	   <xsl:choose>
				<xsl:when test="@STD_COMP_RESULT_TYPE ='L'">
					<input type="text" onKeyDown='restrictBackSpace(this)' class="controlsWidth">
						<xsl:if test="@GRID-COMP = 'Y'">
						 <xsl:attribute name="id">list_box_component_of_<xsl:value-of select="@GRID-NAME"/><xsl:value-of select="../@COLINDEX"/></xsl:attribute>
						</xsl:if>
						<xsl:attribute name="name"><xsl:value-of select="@NAME"/></xsl:attribute>
						<xsl:attribute name="value"><xsl:value-of select="@STD_COMP_VALUE"/></xsl:attribute>
						
					</input>
					<script>
						function lookUp<xsl:value-of select="@NAME"/>()
						{
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
				</xsl:otherwise>
           </xsl:choose>	
	   <xsl:if test="@STD_COMP_RESULT_TYPE !='L'">
	   <select class="controlsWidth" style="height: 38px;">
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
	   <select class="controlsWidth" style="height: 38px;">
	          
                <xsl:if test="@GRID-COMP = 'Y'">
                    <xsl:attribute name="id">list_box_component_of_<xsl:value-of select="@GRID-NAME"/><xsl:value-of select="../@COLINDEX"/></xsl:attribute>
                </xsl:if>
                
                <xsl:attribute name="id">list_box_component_of_<xsl:value-of select="@NAME"/></xsl:attribute>
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
    <!-- <xsl:if test="not(@GRID-COMP|@MATRIX-COMP)"> -->
       <td class="matScrollTable">
       <div>
            <xsl:attribute name="class">label</xsl:attribute>
            <xsl:value-of select="@PROMPT"/>&#160;
            <xsl:if test="@NOWRAP='true'">
                    <xsl:attribute name="nowrap"></xsl:attribute>
            </xsl:if>
			<xsl:if test="@MANDATORY='Y'">
		&#32;
	<font style="color: red">*</font>
		<script>
		   mandatoryCheck = true;
		    var JSONObj = {};
		         JSONObj.id="<xsl:value-of select="@NAME" />";
		         JSONObj.value=mandatoryCheck;
		         JSONObj.component="textarea";
		         CheckValArray.push(JSONObj);

		</script>
 	   </xsl:if>
        </div>
        <div class="controlsWidth">
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
	    
	 </div>  
	</td>
  </xsl:template>
  
   <xsl:template name="SHORT-TEXT-WTD" match="SHORT-TEXT-WTD">  
   	<textarea class="controlsWidth" style="height: 38px; -webkit-appearance: none; border-top: 1px solid rgb(191, 191, 191);
    border-bottom: 1px solid rgb(191, 191, 191);
    border-left: 1px solid rgb(191, 191, 191);
    border-right: 1px solid rgb(191, 191, 191);border-radius:3px;" rows="1" >            
            <xsl:if test="@GRID-COMP = 'Y'">
               <xsl:attribute name="id">short_text_component_of_<xsl:value-of select="@GRID-NAME"/><xsl:value-of select="../@COLINDEX"/></xsl:attribute>           
               <xsl:attribute name="rows"><xsl:value-of select="@ROWS"/></xsl:attribute>
            </xsl:if>
	    <xsl:attribute name="name"><xsl:value-of select="@NAME"/></xsl:attribute>
            <xsl:attribute name="id"><xsl:value-of select="@NAME"/></xsl:attribute>
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
        </textarea><br></br>
        <label style="font-size:11px;font-style: italic;color:#c5c5c5;"> 
            <xsl:value-of select="@HINT_MESSAGE"/>
         </label>
   </xsl:template>
  <!--===========================================================================================-->


  <!--=======================================for Text Area in LONG text=========================-->
  <xsl:template match="LONG-TEXT">
       <td class="matScrollTable">
       <div>
            <xsl:attribute name="class">label</xsl:attribute>
            <xsl:value-of select="@PROMPT"/>&#160;
            <xsl:if test="@NOWRAP='true'">
                    <xsl:attribute name="nowrap"></xsl:attribute>
            </xsl:if>
			<xsl:if test="@MANDATORY='Y'">
		&#32;
		<font style="color: red">*</font>
		<script>
		   mandatoryCheck = true;
		    var JSONObj = {};
		         JSONObj.id="<xsl:value-of select="@NAME" />";
		         JSONObj.value=mandatoryCheck;
		         JSONObj.component="textarea";	         
		         CheckValArray.push(JSONObj);

		</script>
 	   </xsl:if>
       </div>
       <div class="controlsWidth">
            <xsl:attribute name="align"><xsl:value-of select="@ALIGN"/></xsl:attribute>
            <xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>            
            <xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
            <xsl:call-template name="LONG-TEXT-WTD"/>
            <xsl:if test="@RECORD-TYPE!=''">
                <input type="button" class="button" value="Link Doc" name = "" onClick="" >
                   
		   <xsl:attribute name="name">Link_Doc_<xsl:value-of select="@NAME"/></xsl:attribute>
		    <xsl:attribute name="onClick">showLinkDocumentsFromTemplate('<xsl:value-of select="@RECORD-TYPE"/>','<xsl:value-of select="@NAME"/>')</xsl:attribute>
                </input>
            </xsl:if>

	  </div>
      </td>

   </xsl:template>
   <xsl:template name="LONG-TEXT-WTD" match="LONG-TEXT-WTD">
               <textarea rows="3" cols="80" style="height:100px; -webkit-appearance: none;border-top: 1px solid rgb(191, 191, 191);border-bottom: 1px solid rgb(191, 191, 191);border-left: 1px solid rgb(191, 191, 191);border-right: 1px solid rgb(191, 191, 191);border-radius:3px;">
	           <xsl:attribute name="name"><xsl:value-of select="@NAME"/></xsl:attribute>
                <xsl:attribute name="id"><xsl:value-of select="@NAME"/></xsl:attribute>
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
           </textarea><br></br>
             <label style="font-size:11px;font-style: italic;color:#c5c5c5;"> 
               <xsl:value-of select="@HINT_MESSAGE"/>
            </label>

   </xsl:template>
  <!--===========================================================================================-->


  <!--=======================================for Title Text =========================-->
  <xsl:template match="TITLE-TEXT">
     <xsl:if test="@TYPE='T'">
       <td class="matScrollTable" colspan='1'>	
           <xsl:attribute name="align"><xsl:value-of select="@ALIGN"/></xsl:attribute>
	       
           <font style="font-size:14px;color:#2a7fa1;font-weight:bold;background-color:#fafafa;">
           <xsl:value-of select="."/></font>
       </td>
     </xsl:if>
     <xsl:if test="@TYPE='C'">
       <td class="matScrollTable" colspan='1'>
           <xsl:attribute name="align"><xsl:value-of select="@ALIGN"/></xsl:attribute>
           
           <xsl:attribute name="class"><xsl:value-of select="@CLASS"/></xsl:attribute>
	   <b><xsl:value-of select="."/></b>
       </td>
     </xsl:if>
      <label style="font-size:11px;font-style: italic;color:#c5c5c5;"> 
            <xsl:value-of select="@HINT_MESSAGE"/>
      </label>
   </xsl:template>
  <!--===========================================================================================-->


  <!--==================for DATE,TIME,DATE/TIME,INTEGER,DECIMAL FIELD =========================-->
  <xsl:template match="DATE-TIME-NUMERIC">
   <xsl:choose>
     <xsl:when test="not(@GRID-COMP|@MATRIX-COMP)">
    
       <td class="matScrollTable">
       <div>
            <xsl:attribute name="class">label</xsl:attribute>
            <xsl:value-of select="@PROMPT"/>&#160;
            <xsl:if test="@NOWRAP='true'">
                    <xsl:attribute name="nowrap"></xsl:attribute>
            </xsl:if>
      <xsl:if test="@MANDATORY='Y'">
		&#32;
		<font style="color: red">*</font>
		<script>
		   mandatoryCheck = true;
		    var JSONObj = {};
		         JSONObj.id="<xsl:value-of select="@NAME" />";
		         JSONObj.value=mandatoryCheck;
		         JSONObj.component="input";
		         CheckValArray.push(JSONObj);
	
		</script>
      </xsl:if>
      </div> 
	
	 	<div>
            <xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
            <xsl:attribute name="align"><xsl:value-of select="@ALIGN"/></xsl:attribute>
          <xsl:if test="@GRID-COMP='Y'">                
                <xsl:attribute name="align">center</xsl:attribute>                
            </xsl:if>
            <xsl:call-template name="DATE-TIME-NUMERIC-WTD">
                <xsl:with-param name="GRID-NAME"	select = "@GRID-NAME"></xsl:with-param>
                <xsl:with-param name="GRID-COMP"	select = "@GRID-COMP" ></xsl:with-param>
                <xsl:with-param name="HINT_MESSAGE"	select = "@HINT_MESSAGE" ></xsl:with-param>
		<xsl:with-param name="COMP_TYPE"	select = "@COMPTYPE" ></xsl:with-param>
            </xsl:call-template>
     </div>
        </td>	
			
          </xsl:when>		  
          <xsl:otherwise> 	
    
       <td class="matScrollTable" >
       <div>
            <xsl:attribute name="class">label</xsl:attribute>
            <xsl:value-of select="@PROMPT"/>&#160;
            <xsl:if test="@NOWRAP='true'">
                    <xsl:attribute name="nowrap"></xsl:attribute>
            </xsl:if>
      <xsl:if test="@MANDATORY='Y'">
		&#32;
		<font style="color: red">*</font>
		<script>
		   mandatoryCheck = true;
		    var JSONObj = {};         
		         JSONObj.id="<xsl:value-of select="@NAME" />";
		         JSONObj.value=mandatoryCheck;
		         JSONObj.component="input";
		         CheckValArray.push(JSONObj);
		</script>
       </xsl:if>
       </div> 

	 	<div class="controlsWidth">
            <xsl:attribute name="colspan"><xsl:value-of select="@COLSPAN"/></xsl:attribute>
            <xsl:attribute name="align"><xsl:value-of select="@ALIGN"/></xsl:attribute>
          <xsl:if test="@GRID-COMP='Y'">                
                <xsl:attribute name="align">center</xsl:attribute>                
            </xsl:if>
            <xsl:call-template name="DATE-TIME-NUMERIC-WTD">
                <xsl:with-param name="GRID-NAME"	select = "@GRID-NAME"></xsl:with-param>
                <xsl:with-param name="GRID-COMP"	select = "@GRID-COMP" ></xsl:with-param>
                <xsl:with-param name="HINT_MESSAGE"	select = "@HINT_MESSAGE" ></xsl:with-param>
		        <xsl:with-param name="COMP_TYPE"	select = "@COMPTYPE" ></xsl:with-param>
            </xsl:call-template>
        </div>
     </td>
          </xsl:otherwise>
		  </xsl:choose>
   </xsl:template>
   
   
   <xsl:template name="DATE-TIME-NUMERIC-WTD" match="DATE-TIME-NUMERIC-WTD">    
		<xsl:choose>
			<xsl:when test="@NUM_PREFIX_REQUIRED_YN = 'Y'">
				<input type="text" size="1" maxlength="1" class="controlsWidth" style="height: 38px; -webkit-appearance: none;border-top: 1px solid rgb(191, 191, 191);border-bottom: 1px solid rgb(191, 191, 191);border-left: 1px solid rgb(191, 191, 191);border-right: 1px solid rgb(191, 191, 191);border-radius:3px;">
					<xsl:attribute name="name"><xsl:value-of select="@NAME"/>_number_prefix</xsl:attribute>
					<xsl:attribute name="OnKeyPress">return allowValidChar()</xsl:attribute>
					<xsl:attribute name="value"><xsl:value-of select="@PREFIX_CHAR"/></xsl:attribute>
				</input>
			</xsl:when>
		</xsl:choose>
       <input class="controlsWidth">
		   <xsl:attribute name="title">
			   <xsl:value-of select="@HINT_MESSAGE"/>
		   </xsl:attribute>
		   
            <xsl:if test="@GRID-COMP='Y'">
	            <xsl:attribute name="id">date_time_numeric_component_of_<xsl:value-of select="@GRID-NAME"/><xsl:value-of select="../@COLINDEX"/></xsl:attribute>
            </xsl:if>
                <xsl:attribute name="size"><xsl:value-of select="@SIZE"/></xsl:attribute>
                <xsl:attribute name="maxlength"><xsl:value-of select="@MAXLENGTH"/></xsl:attribute>

                
                <xsl:attribute name="name"><xsl:value-of select="@NAME"/></xsl:attribute>
                <xsl:attribute name="id"><xsl:value-of select="@NAME"/></xsl:attribute> 
               <xsl:attribute name="compId"><xsl:value-of select="@COMPTYPE"/></xsl:attribute>
                
              
                                  
                <xsl:if test="@READONLY='true'">
                <xsl:attribute name="compId"><xsl:value-of select="@COMPTYPE"/></xsl:attribute>
                    <xsl:attribute name="readonly"></xsl:attribute>
		    <xsl:attribute name="onKeyDown">return restrictBackSpace(this)</xsl:attribute>
                </xsl:if>
                <xsl:if test="@DISABLED='true'">
                <xsl:attribute name="compId"><xsl:value-of select="@COMPTYPE"/></xsl:attribute>
                    <xsl:attribute name="disabled"></xsl:attribute>
		    <xsl:attribute name="onKeyDown">return restrictBackSpace(this)</xsl:attribute>
                </xsl:if>
		
		
		<xsl:choose>
			<xsl:when test="@COMPTYPE='D'">
			<xsl:if test="@GRID-COMP='Y'"> <!--IN033507 Start Modified-->

				 <xsl:attribute name="data-dater"><xsl:value-of select="@NAME"/></xsl:attribute>
				 <xsl:attribute name="data-max"><xsl:value-of select="@MAXLENGTH"/></xsl:attribute>
				 
				<xsl:attribute name="value"><xsl:value-of select="@VALUE"/></xsl:attribute>
				<xsl:attribute name="compId"><xsl:value-of select="@COMPTYPE"/></xsl:attribute>
			</xsl:if>
			<xsl:if test="not(@GRID-COMP)"> 

				 <xsl:attribute name="data-dater"><xsl:value-of select="@NAME"/></xsl:attribute>
				 	 <xsl:attribute name="data-max"><xsl:value-of select="@MAXLENGTH"/></xsl:attribute>
				<xsl:attribute name="value"><xsl:value-of select="@OTHLANGVAL"/></xsl:attribute>
			<xsl:attribute name="compId"><xsl:value-of select="@COMPTYPE"/></xsl:attribute>
			</xsl:if>
				
		
			</xsl:when>
			<xsl:when test="@COMPTYPE='E'">
			<xsl:if test="@GRID-COMP='Y'">

				 <xsl:attribute name="data-dater"><xsl:value-of select="@NAME"/></xsl:attribute>
				 	 <xsl:attribute name="data-max"><xsl:value-of select="@MAXLENGTH"/></xsl:attribute>
				<xsl:attribute name="value"><xsl:value-of select="@VALUE"/></xsl:attribute>
			<xsl:attribute name="compId"><xsl:value-of select="@COMPTYPE"/></xsl:attribute>
			</xsl:if>
			<xsl:if test="not(@GRID-COMP)">

				 <xsl:attribute name="data-dater"><xsl:value-of select="@NAME"/></xsl:attribute>
				 	 <xsl:attribute name="data-max"><xsl:value-of select="@MAXLENGTH"/></xsl:attribute>
				<xsl:attribute name="value"><xsl:value-of select="@OTHLANGVAL"/></xsl:attribute>
			<xsl:attribute name="compId"><xsl:value-of select="@COMPTYPE"/></xsl:attribute>
			</xsl:if> <!--IN033507 End - Modified -->
			</xsl:when>
			<xsl:when test="@COMPTYPE='T'">

				 <xsl:attribute name="data-dater"><xsl:value-of select="@NAME"/></xsl:attribute>
				 	 <xsl:attribute name="data-max"><xsl:value-of select="@MAXLENGTH"/></xsl:attribute>
				<xsl:attribute name="value"><xsl:value-of select="@VALUE"/></xsl:attribute>
			<xsl:attribute name="compId"><xsl:value-of select="@COMPTYPE"/></xsl:attribute>
			</xsl:when>
			<xsl:when test="@COMPTYPE='I'">
			
			<xsl:attribute name="style">
   <xsl:value-of select="'height: 38px;-webkit-appearance: none;border-top: 1px solid rgb(191, 191, 191);border-bottom: 1px solid rgb(191, 191, 191);border-left: 1px solid rgb(191, 191, 191);border-right: 1px solid rgb(191, 191, 191);border-radius:3px;'"/>
</xsl:attribute>
	<xsl:attribute name="class">
   <xsl:value-of select="'controlsWidth'"/>
</xsl:attribute>

 <xsl:attribute  name="tabindex" >0</xsl:attribute> 

  <xsl:attribute name="onblur">return checkValidRange1Ipad(this,'<xsl:value-of select="@NAME"/>',<xsl:value-of select="@MIN_DIGIT"/>,0,'<xsl:value-of select="@PROMPT"/>')</xsl:attribute> 
 <xsl:attribute name="onkeyup">return allowValidNumberLocalIpad(this,event, <xsl:value-of select="@SIZE" /> ,0,'I')</xsl:attribute>


				<xsl:attribute name="value"><xsl:value-of select="@VALUE"/></xsl:attribute>
			<xsl:attribute name="compId"><xsl:value-of select="@COMPTYPE"/></xsl:attribute>
			</xsl:when>
			<xsl:when test="@COMPTYPE='N'">
			<xsl:attribute name="style">
   <xsl:value-of select="'height: 38px;-webkit-appearance: none;border-top: 1px solid rgb(191, 191, 191);border-bottom: 1px solid rgb(191, 191, 191);border-left: 1px solid rgb(191, 191, 191);border-right: 1px solid rgb(191, 191, 191);border-radius:3px;'"/>
</xsl:attribute>
	<xsl:attribute name="class">
   <xsl:value-of select="'controlsWidth'"/>
</xsl:attribute>

 <xsl:attribute  name="tabindex" >0</xsl:attribute>
 				<xsl:attribute name="onblur">return checkValidRange1Ipad(this,'<xsl:value-of select="@NAME"/>',<xsl:value-of select="@MIN_DIGIT"/>,<xsl:value-of select="@DEC_DIGIT"/>,"<xsl:value-of select="@PROMPT"/>")</xsl:attribute>
				<xsl:attribute name="onkeyup">return allowValidNumberLocalIpad(this,event,<xsl:value-of select="@SIZE"/>,<xsl:value-of select="@DEC_DIGIT"/>,'N')</xsl:attribute>
				<xsl:attribute name="value"><xsl:value-of select="@VALUE"/></xsl:attribute> 
			<xsl:attribute name="compId"><xsl:value-of select="@COMPTYPE"/></xsl:attribute>
			</xsl:when>
		</xsl:choose>
         </input><br></br>
          <label style="font-size:11px;font-style: italic;color:#c5c5c5;"> 
            <xsl:value-of select="@HINT_MESSAGE"/>
         </label>


	 
	<xsl:choose>
	      <xsl:when test="@LINK_HIST_YN='Y'">
		<xsl:apply-templates select="LINK-HISTORY-BUTTON"/>
	      </xsl:when>
	      <xsl:otherwise>
			<xsl:if test="@COMPTYPE='D' or @COMPTYPE ='E'">  
			<xsl:attribute name="compId"><xsl:value-of select="@COMPTYPE"/></xsl:attribute>

		    </xsl:if>
	      </xsl:otherwise>
	   </xsl:choose>	


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
        <xsl:if test="@LANGUAGE">
            <xsl:attribute name="language"><xsl:value-of select="@LANGUAGE"/></xsl:attribute>
        </xsl:if>
        <xsl:if test="@TYPE">
            <xsl:attribute name="type"><xsl:value-of select="@TYPE"/></xsl:attribute>
        </xsl:if>
        <xsl:if test="@SRC">
            <xsl:attribute name="src"><xsl:value-of select="@SRC"/></xsl:attribute>
        </xsl:if>
        <xsl:value-of select="."/>
    </script>
	</xsl:template>
    <!--=====================================================================================-->
   
   

  
  
   <xsl:template match="link">
      <xsl:element name="links">
                <xsl:attribute name="rel"><xsl:value-of select="@rel"/></xsl:attribute>
                <xsl:attribute name="href"><xsl:value-of select="@href"/></xsl:attribute>
              
         </xsl:element>
   </xsl:template>
   <!--=====================================================================================-->


   <!--====================================for Calander ================================-->
   <xsl:template match="CALANDER">            
            <input type="image" src = "../../../eIPAD/images/CommonCalendar.gif">
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
            </input><br></br>
            
             <label style="font-size:11px;font-style: italic;color:#c5c5c5;"> 
            <xsl:value-of select="@HINT_MESSAGE"/>
         </label>
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
	</input><br></br>
	  <label style="font-size:11px;font-style: italic;color:#c5c5c5;"> 
	      <xsl:value-of select="@HINT_MESSAGE"/>
      </label>
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
	    <font style="font-size:9pt;font-face:verdana;font-style:normal;"  class="QRYEVEN"><xsl:value-of select="." disable-output-escaping="yes"/></font>
  </xsl:template>
  <!--=====================================================================================-->
   
   <!--================for any extra thigs added from the jsp page directly ================-->

  <xsl:template match="CALL-ON-UNLOAD">
            <xsl:attribute name="value"><xsl:value-of select="@VALUE" disable-output-escaping="yes"/></xsl:attribute>
  </xsl:template>
  <!--=====================================================================================-->      
 </xsl:stylesheet>