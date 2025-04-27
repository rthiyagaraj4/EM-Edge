<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="com.iba.framework.core.util.Constants" %>
<%@ include file="/framework/html/Tag.text" %>
<ibaHTML:html locale="true">
<head>
	<%
	String facilityId=(String)session.getAttribute("facility_id");
	String addedById = (String) session.getAttribute("login_user");
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";
					String qryEven = "QRYEVEN";
					String qryOdd = "QRYODD";

			String locale = (String)session.getValue("LOCALE");
			locale = (locale == null || locale.equals(""))?"en":locale;
			//java.util.Locale loc = new java.util.Locale(locale);
			session.setAttribute(org.apache.struts.Globals.LOCALE_KEY,new java.util.Locale(locale,""));
		
	%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	<script type="text/javascript"	src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenRequest.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>

<script type="text/javascript">
var contentList =new Hashtable();
function callWards()
{
var sourceType="";
var val=document.getElementById("sourceType").value;
var el = document.getElementsByTagName("SELECT").item(0);
if (el != null) {
	for (i=0; i<el.options.length; i++) {
           	if(el.options(i).value==val)
       		{
       		sourceType=el.options(i).text;
   			}
    }
}
 var sourceCode=document.getElementById("sourceCode").value;
 var source=document.getElementById("source").value;
  if(sourceType!=""&& source!=="")
	{
	// var arr = new Array();
	 var str="";
	 var functionId="LC_REQ_FOR_LINEN";
	 str=contextPath + 	"/eLC/RequestForLinen/jsp/RequestForLinenMain.jsp?sourceType="+sourceType+"&source="+source+"&sourceCode="+sourceCode+"&sourcetype="+val+"&functionId="+functionId;
	 top.returnValue=str;
	 top.close();
	}
	 else{
			
			document.getElementById("sourceCode").setfocus;
		}
	

}
function showCancel()
{
if('<%=request.getParameter("title")%>'=='Delivery')
 document.getElementById("CancelFrame").style.visibility="hidden";
 
}
function checkLookup()
{
	var sourceType=document.getElementById("sourceType").value;
	var source=document.getElementById("source").value;
	if(sourceType!="" && source!="")
	{
	showLookup();
	}
}
function showLookup() {
	var sourceType=document.getElementById("sourceType").value;
	var facilityId=document.getElementById("operatingFacilityId").value;
	var languageId=document.getElementById("languageId").value;
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array(facilityId,languageId);
	var datatypesArray = new Array();
	
	if(sourceType=="W")
		{	argArray[0] = "ehis.lc.standardStock.nursingUnit"
		    
		}
		else if(sourceType=="C")
		{	argArray[0] = "ehis.lc.standardStock.clinic"
			
		}
		else if(sourceType=="D")
		{	argArray[0] = "ehis.lc.standardStock.deptCode"
			
		}
		else 	argArray[0] = "ehis.lc.standardStock.nursingUnit"
	
	namesArray[0]="facilityId";
	namesArray[1]="languageId"
	
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
			//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] =document.getElementById("source").value;
	retArr = Lookup("SourceCode", argArray);
	txtUser1 = document.getElementById("sourceCode");
	txtUser = document.getElementById("source");
	if(retArr!=null)
			{
			//Set the data in to the fields
			txtUser.value = retArr[1];
			txtUser1.value= retArr[0];
			}
			else
			{	
			txtUser.value ="";
			txtUser1.value="";
			}
		
	
}

</script>
</head>
<title><ibaBean:message key="com.iba.ehis.lc.laundryUser.user" bundle="lcLabels" /></title>

<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="UserForm" id="UserForm"  target="messageFrame">

<table align="center" border=0 cellspacing=0 cellpadding=2 width=100% height=100%>
<tr>
<td class="label"><ibaBean:message key="com.iba.ehis.lc.standardStock.sourceType" bundle="lcLabels" /></td>
<td>
			<select name="sourceType" id="sourceType" >
							<option value="W"><ibaBean:message key="com.iba.ehis.lc.ward" bundle="lcLabels" />
							</option>
							<option value="C"><ibaBean:message key="com.iba.ehis.lc.clinic" bundle="lcLabels" />
							</option>
							<option value="D"><ibaBean:message key="com.iba.ehis.lc.department" bundle="lcLabels" />
							</option>
			</select>
</td>
</tr>
<tr>
<td  class="label"><ibaBean:message key="com.iba.ehis.lc.standardStock.source" bundle="lcLabels" /></td>
<td>
<input type="hidden" name="sourceCode" id="sourceCode" />
<input type="text" maxlength=30 name="source" id="source" onblur="checkLookup()"/>
<input type='button' class="BUTTON"  value='?' onclick='showLookup()' />
</td>
</tr>
<tr>
<td align="right">
<input class="BUTTON" type="button" value="Ok" name="Ok" id="Ok" onclick="callWards()"/></td><td><input class="BUTTON" type="reset" value="Cancel" name="Cancel" id="Cancel" onclick="window.close()"/>
</td>
</tr>
</table>
<input type="hidden" name="operatingFacilityId" id="operatingFacilityId" value="<%=facilityId%>"/>
<input type="hidden" name="languageId" id="languageId" value="<%=locale%>"/>
</form>

</body>
</ibaHTML:html>

