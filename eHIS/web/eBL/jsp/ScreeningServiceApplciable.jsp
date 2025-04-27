<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*, eBL.BLScreenServiceBean" contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript">
function formXMLStringMain(frmObj)
{
	
if( frmObj!=null && frmObj != "undefined" && frmObj.length >0)
{
	var xmlStr ="<root><SEARCH ";
	if(true)
	{
	var arrObj = frmObj.elements;
	for(var i=0;i<arrObj.length;i++)
	{
		var val = "" ;
		if(arrObj[i].type == "checkbox")
		{
			val = arrObj[i].value;
			if(arrObj[i].name != null && arrObj[i].name != "")
				xmlStr+= arrObj[i].name+"=\"" + val + "\" " ;
     }
		
		 else if(arrObj[i].type == "radio")
		{
			if(arrObj[i].checked)
			{
				val = arrObj[i].value;
		        if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
         }
	    }
		
		else if(arrObj[i].type == "select-multiple" )
		{
			for(var j=0; j<arrObj[i].options.length; j++)
		    {
				if(arrObj[i].options[j].selected)
					val+=arrObj[i].options[j].value +"~"
         }
	        val= val.substring(0,val.lastIndexOf('~'))
		    if(arrObj[i].name != null && arrObj[i].name != "")
			    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
	       
		}
		else
		{
			val = arrObj[i].value;
			if(arrObj[i].name != null && arrObj[i].name != "")
	        {
	        		xmlStr+= arrObj[i].name+"=\"" + val + "\" " ;
	        }
		 }
	}
}
xmlStr +=" /></root>";	
}
return xmlStr;
}
function checkSelected(obj)
{
	var chkCount=0;
	var rowCount =  document.getElementById("panel_categories_table").rows.length;  
	
	
	if(obj.checked)
	{
		obj.value = "Y";
		obj.checked=true;
	}
	else
	{
		obj.value = "N";
		obj.checked=false;
		
		
	}
	if(rowCount>1)
	{
		for(var index=0;index<rowCount-1;index++)
		{
			if(document.getElementById("chk"+index).checked == true)
				chkCount++;
		}
	}
	//document.getElementById("chkCount").value=chkCount;
	//alert(chkCount);
	if(chkCount == rowCount-1)
	{
		document.getElementById('select_all').checked = true;
	}
	else
	{
		document.getElementById('select_all').checked = false;
	}
}

function selectAll(table,obj)
{
	
	var rowCount =  document.getElementById(table).rows.length;  
	document.getElementById("rowCount").value=rowCount;
	//alert(rowCount);
	if(rowCount>1)
	{
		if(obj.checked==true)
		{
			obj.value="Y";			
			obj.checked=true;
			if (obj.name=="select_all")
			{
				
				for(var index=0;index<rowCount-1;index++)
				{	
					if(document.getElementById('chk'+index).disabled == false)
					{
					document.getElementById('chk'+index).checked=true;
					document.getElementById('chk'+index).value="Y";
					}
				}
			}
		}
		else
		{
			obj.value="N";			
			obj.checked=false;
			if (obj.name=="select_all")
			{
				for(var index=0;index<rowCount-1;index++)
				{
					document.getElementById('chk'+index).checked=false;
					document.getElementById('chk'+index).value="N";
				}
			}	
		}
	}
	else
	{
		obj.value="N";			
		obj.checked=false;
	}
	
}

function SaveScreeningServiceApplicableCriteria()
{
	var rowCount =  document.getElementById("panel_categories_table").rows.length;  
	document.getElementById("rowCount").value=rowCount;
	//alert("AAA::"+document.getElementById("rowCount").value);
	var frmObj=document.ScreeningServiceApplciable;
	if(frmObj!="" && frmObj!=null && frmObj !=undefined )
	{
		var xmlString=formXMLStringMain(frmObj);
		var updation=formValidationScreeningServiceApplicableCriteria(xmlString); 
		
	}
	 var rowCount =  document.getElementById("panel_categories_table").rows.length;  
	var chkCount=0;
	document.getElementById("rowCount").value=rowCount;
	if(rowCount>1)
	{
		for(var index=0;index<rowCount-1;index++)
		{
			if(document.getElementById("chk"+index).checked == true)
				chkCount++;
		}
	}
	document.getElementById("chkCount").value=chkCount;
	window.returnValue = chkCount;
	parent.window.close(); 
	return retModal(this);
	
}

function formValidationScreeningServiceApplicableCriteria(xmlStr)
{	 	
	//alert("INSIDE formValidation:::: ");
var temp_jsp="../../eBL/jsp/BillingSaveScreeningServiceApplicableCriteria.jsp";  
/*var xmlDoc = new ActiveXObject( "Microsoft.XMLDom" ) ;
var xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" ) ;
xmlDoc.loadXML(xmlStr);*/
var xmlHttp = new XMLHttpRequest();
var xmlDoc = "";
new DOMParser().parseFromString(getXMLString(xmlStr), "text/xml");
if (xmlDoc.parseError.errorCode != 0)
{
alert("Error in line " + xmlDoc.parseError.line +
" position " + xmlDoc.parseError.linePos +
"\nError Code: " + xmlDoc.parseError.errorCode +
"\nError Reason: " + xmlDoc.parseError.reason +
"Error Line: " + xmlDoc.parseError.srcText);
return(null);
}
xmlHttp.open("POST",temp_jsp,false);
xmlHttp.send(xmlDoc);
var responseText=xmlHttp.responseText ;
//alert(responseText);
//eval(responseText);
return true; 
}	
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%!
int returnInteger(String inputValue){
	if(inputValue==null || inputValue.equals("")){
		return 0;
	}
	else{
		return Integer.parseInt(inputValue);
	}	
}
%>
<%!
double returnDouble(String inputValue){
	if(inputValue==null || inputValue.equals("")){
		return 0.0;
	}
	else{
		return Double.parseDouble(inputValue);
	}	
}
%>


<title><fmt:message key="eBL.ScreeningServiceApplicable.label" bundle="${common_labels}" /></title><!-- Karthik changed label -->
</head>
<body>
<form name="ScreeningServiceApplciable" id="ScreeningServiceApplciable" id="ScreeningServiceApplciable">
<TABLE width="100%" CELLSPACING=0 cellpadding=3 align='center'>
			<tr >
			
			
					<td  class="columnheader" ><fmt:message key="eBL.ScreeningServiceApplicabilityStatus.label" bundle="${common_labels}" /></td></tr>	<!-- Karthik changed label -->	
</TABLE>
<br>
<%
String locale																				=	"";
String facilityId																			=	"";
ArrayList screenServiceCriteriaList 														=   null;
HashMap screenServiceCriteriaListMap														=   null;
String p_patient_id																			=	null;
String p_episode_type																		=	null;
String p_episode_id																			=	null;
String p_visit_id 																			=	null;
String beanId 																				= 	"";
String beanName 																			= 	"";
String loginUser																			= 	null;
String disable_flag	=				"readonly onfocus='this.blur()'";


try  
{
	sStyle 																					=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 																					= 	(String)session.getAttribute("LOCALE");
	facilityId																				=   (String) session.getValue( "facility_id" ) ;
	loginUser																				= 	(String)session.getValue("login_user");
	screenServiceCriteriaListMap 															= 	new HashMap();
	screenServiceCriteriaList 																= 	new ArrayList();
	p_patient_id																			=	checkForNull(request.getParameter("p_patient_id"));
	p_episode_type																			=	checkForNull(request.getParameter("p_episode_type"));
	p_episode_id																			=	checkForNull(request.getParameter("p_episode_id"));
	p_visit_id																				=	checkForNull(request.getParameter("p_visit_id"));
	beanId 																					= 	"BLScreenServiceBean";
	beanName 																				= 	"eBL.BLScreenServiceBean";
	BLScreenServiceBean bllScreenServiceBean 												=  (BLScreenServiceBean)getBeanObject(beanId, beanName, request);
	
%>
<div id="card_type_div" name="card_type_div" style=" height:320px; overflow: auto; " >		 
	<table align='center'  cellpadding=3 cellspacing=0  width="100%" id="panel_categories_table" name="panel_categories_table" id="panel_categories_table" border="1"  >	 
	
			
			<th class='CAFLOWSHEETLEVEL1'	align="left"	><fmt:message key="Common.OrdercatalogCode.label" bundle="${common_labels}" /></th><!-- Karthik changed label -->
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	><fmt:message key="Common.OrderCatalogDesc.label" bundle="${common_labels}" /></th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	><fmt:message key="eBL.ApplicableQuantity.label" bundle="${common_labels}" /></th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	><fmt:message key="eBL.ApplicableAmount.label" bundle="${common_labels}" /></th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	><fmt:message key="eBL.AVAILD_QTY.label" bundle="${common_labels}" /></th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	><fmt:message key="eBL.AVAILD_AMT.label" bundle="${common_labels}" /></th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	><input type="Checkbox" id="select_all" name="select_all" id="select_all" onClick ="selectAll('panel_categories_table',this)"></th>
			
<%

screenServiceCriteriaListMap = bllScreenServiceBean.getScreenServiceCriteria(facilityId,locale,p_patient_id,p_episode_type,p_episode_id,p_visit_id,loginUser); 
Iterator iterator= screenServiceCriteriaListMap.keySet().iterator();
String chkBoxStatus="enabled";

int totalApplicableQty;
int totalAvailableQty;
double totalApplicableAmt;
double totalAvailableAmt;
String strAvailedQty="";
String strAvailedAmt="";

while(iterator.hasNext())
{
	
	int index =    (Integer)iterator.next();
	bllScreenServiceBean = (BLScreenServiceBean) screenServiceCriteriaListMap.get(index); 

		 totalApplicableQty=	returnInteger(bllScreenServiceBean.getScreeningApplicableQty());
		 totalAvailableQty=	returnInteger(bllScreenServiceBean.getScreeningAvailedQty());
		 totalApplicableAmt=	returnDouble(bllScreenServiceBean.getScreeningApplicableAmt());
		 totalAvailableAmt=	returnDouble(bllScreenServiceBean.getScreeningAvailedAmt());				
		
				  chkBoxStatus="";
				  strAvailedQty=bllScreenServiceBean.getScreeningAvailedQty();
				  strAvailedAmt=bllScreenServiceBean.getScreeningAvailedAmt();	
		if(((totalApplicableQty > 0)  &&  (totalApplicableQty <= totalAvailableQty) )||  (( totalApplicableAmt>0.0) && (totalApplicableAmt <= totalAvailableAmt)))
				{
				  strAvailedQty=bllScreenServiceBean.getScreeningApplicableQty();
				  strAvailedAmt=bllScreenServiceBean.getScreeningApplicableAmt();	  
				  chkBoxStatus="disabled";
				}

%>
		<tr>
				<td class="fields" align="left" ><input type="text" id="criteria<%=index%>" name="criteria<%=index%>" 	value="<%=bllScreenServiceBean.getScreeningCategoryCode() 	!=null 	? 	bllScreenServiceBean.getScreeningCategoryCode()		: 	"" %>"  	<%=disable_flag%>	/></td> 
				<td class="fields" align="left"><input type="text" id="cd0<%=index%>" name="cd0<%=index%>" 				value="<%=bllScreenServiceBean.getScreeningCategoryDesc() 	!=null 	? 	bllScreenServiceBean.getScreeningCategoryDesc()		: 	"" %>" 	<%=disable_flag%>		/></td> 
				<td class="fields" align="left"><input type="text" id="cd1<%=index%>" name="cd1<%=index%>" 				value="<%=bllScreenServiceBean.getScreeningApplicableQty() 	!=null 	? 	bllScreenServiceBean.getScreeningApplicableQty()	: 	"" %>" 	<%=disable_flag%>		/></td>
				<td class="fields" align="left"><input type="text" id="cd2<%=index%>" name="cd2<%=index%>" 				value="<%=bllScreenServiceBean.getScreeningApplicableAmt()	!=null 	? 	bllScreenServiceBean.getScreeningApplicableAmt()	: 	"" %>" 	<%=disable_flag%>		/></td> 
				<td class="fields" align="left"><input type="text" id="cd3<%=index%>" name="cd3<%=index%>" 				value="<%=strAvailedQty		!=null 	? 	strAvailedQty		: 	"" %>" 	<%=disable_flag%>		/></td> 
				<td class="fields" align="left"><input type="text" id="cd4<%=index%>" name="cd4<%=index%>" 				value="<%=strAvailedAmt		!=null 	? 	strAvailedAmt		: 	"" %>" 	<%=disable_flag%>		/></td>
				<td class="fields" align="left"><input type="Checkbox" id="chk<%=index%>" name="chk<%=index%>" 	<%=chkBoxStatus%>	value="true" onClick ="checkSelected(this)"></td> 
								
			</tr>
<%
}	
%>			
	</table>
	</div>
	<TABLE border='0' cellpadding='1' cellspacing='0' width='100%'>
				<tr>
					<td class='fields' width="32%"></td>
					<td class='fields' width="55%"></td>
					<td class='fields' width="15%"><input type="button" class='button' name="add_mod" id="add_mod"	id="add_mod"   value="Close" onClick="SaveScreeningServiceApplicableCriteria();"  /></td>
					
				</tr>
			</TABLE>	
			<input type='hidden' name='rowCount' id='rowCount' 			id='rowCount'				value="" >
			<input type='hidden' name='chkCount' id='chkCount' 			id='chkCount'				value="" >
</form>		
</body>
</body>
<%
}
catch(Exception e)
{   
	System.out.println("Exception in ScreeningServiceApplciable.jsp::"+e);
}
%>
<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>
</html>

