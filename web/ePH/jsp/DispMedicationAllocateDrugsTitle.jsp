<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
10/05/2019	  	IN068344	     	Manickavasagam 		  								AMS-CRF-0204 
--------------------------------------------------------------------------------------------------------------
 -->

  
<%-- JSP Page specific attributes start --%> 
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<!-- java.sql.*,webbeans.eCommon.* added for AMS-CRF-204-->
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<%
	    request.setCharacterEncoding("UTF-8");
		//Added  for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
		String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DispMedicationAllStages.js"></SCRIPT>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</HEAD>
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name="DispMedicationAllocateDrugsTitle" id="DispMedicationAllocateDrugsTitle">
<% 
Connection con			= null;  // Added for ML-MMOH-CRF-0468
try{
String	bean_id				=	"DispMedicationAllStages" ;
String	bean_name			=	"ePH.DispMedicationAllStages";
	
DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject( bean_id, bean_name, request ) ;
String	bean_id_1			=	"DispMedicationBean" ;
String	bean_name_1			=	"ePH.DispMedicationBean";

DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
//bean_1.setLanguageId(locale);
String fill_list = bean_1.getFillList();
String strChangedDispPeriod		= bean_1.getStrChangedDispensePeriod();

String strChangedDispUnit		= bean_1.getStrChangedDispenseUnit();
String strDispLocationCategory	= bean_1.getDispLocnCatg()==null?"":bean_1.getDispLocnCatg();
Hashtable legend			    = bean_1.getLegendsFromParam();

String	alloc_durn_display="";
String strDurationType = bean_1.getStrIPFillPeriodUnit()==null?"":bean_1.getStrIPFillPeriodUnit();
con				= ConnectionManager.getConnection(request);//added for AMS-CRF-204
String bl_install_yn= CommonBean.checkForNull((String) session.getValue( "bl_operational" ),"N") ; //added for AMS-CRF-204
boolean item_type_site_app = eCommon.Common.CommonBean.isSiteSpecific(con,"PH","ITEM_TYPE_APP");//added for AMS-CRF-204


if(strDispLocationCategory.equals("I"))
{
	if(strDurationType.equals("P")){		
	   alloc_durn_display="display:none";
	   strChangedDispPeriod       ="999";
	   strChangedDispUnit         ="D";
	}
}


String strQueryString = request.getQueryString();

String title				=	"";

			if(legend.containsKey("A"))
					title	=	(String)legend.get("A");


		String module_id	=	bean.getModuleId(); 
		if(module_id.equals("1")) { 
%>

<table cellpadding="0" cellspacing="0" width="97%"  border="1">
<tr>
	<%	if(bl_install_yn.equals("Y") && item_type_site_app){	 //AMS-CRF-204
 %>		
 <td width="5%" class= "COLUMNHEADER" ></td>
 <td width="5%" class= "COLUMNHEADER" style="font-size:9" nowrap><fmt:message key="ePH.ItemType.label" bundle="${ph_labels}"/></td>
 <%}%>
		<td class= 'COLUMNHEADER'   style="font-size:9" width="50%"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></th>
		<td class= 'COLUMNHEADER'  style="font-size:9" width="25%"><%=title%> <fmt:message key="Common.Qty.label" bundle="${common_labels}"/></th>
		<td class= 'COLUMNHEADER' style="font-size:9" width="20%"><fmt:message key="ePH.BalanceQuantity.label" bundle="${ph_labels}"/></th> <!-- modified for AMS-CRF-204 -->
</tr>
</table>
<%	}	else	{	%>
<table cellpadding="0" cellspacing="0" width="97%"  border="1">
<tr>
	<%	if(bl_install_yn.equals("Y") && item_type_site_app){	 //AMS-CRF-204
 %>	 <td width="5%" class= "COLUMNHEADER" ></td>	<td width="5%" class= "COLUMNHEADER" style="font-size:9" nowrap><fmt:message key="ePH.ItemType.label" bundle="${ph_labels}"/></td>
 <%}%>
		<td class= 'COLUMNHEADER' style="font-size:9" width="60%"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></th>
		<td class= 'COLUMNHEADER' style="font-size:9" width="15%"><%=title%> <fmt:message key="Common.Qty.label" bundle="${common_labels}"/></th>
		<td class= 'COLUMNHEADER' style="font-size:9" width="15%"><fmt:message key="ePH.BalanceQuantity.label" bundle="${ph_labels}"/></th>
		
</tr>
</table>

<%	}	

if(!fill_list.equals("AF"))
{

%>
<table cellpadding="0" cellspacing="0" width="97%"  border="1">
	<tr>
		<td class="label" width="75%">&nbsp;</td>
		<td class="label" width="2%" align = "right" nowrap style="<%=alloc_durn_display%>"> <fmt:message key="ePH.ALLOCATEDFOR.label" bundle="${ph_labels}"/> : </td>
		<td class="label" width="9%" nowrap style="<%=alloc_durn_display%>"> <input size="3" maxlength="2" type = "text" name ="durationVal" value = "<%=strChangedDispPeriod%>" style="text-align:right" onKeyPress="if(event.keyCode!=13) {return allowValidNumber(this,event,3,0);}else{return false;}" onblur="changeDurationValue(this,document.DispMedicationAllocateDrugsTitle);">&nbsp;
			<select name="durnType" id="durnType" onchange="changeDurationValue(document.DispMedicationAllocateDrugsTitle.durationVal,document.DispMedicationAllocateDrugsTitle)" >
				<%if(strDispLocationCategory.equals("I")){%>
				<option value= "H"><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></option>
				<%}%>
				<option value= "D" ><fmt:message key="Common.Day(s).label" bundle="${common_labels}"/></option>
				<option value= "W" > <fmt:message key="ePH.WEEKS.label" bundle="${ph_labels}"/></option>
				<option value= "M" > <fmt:message key="ePH.MONTHS.label" bundle="${ph_labels}"/></option>
			</select>
		</td>
	</tr>
</table>
<script>
document.DispMedicationAllocateDrugsTitle.durnType.value = "<%=strChangedDispUnit%>";
</script>
<%
}
%>
<input type = "hidden" name="QueryString" id="QueryString" value = "<%=strQueryString%>" />
</form>
</body>
</html>

<%
}catch(Exception e){ //added for AMS-CRf-0204
 e.printStackTrace();
}finally{
			          	
 if(con != null)
  ConnectionManager.returnConnection(con,request);	
}

//putObjectInBean(bean_id,bean,request);
//putObjectInBean(bean_id_1,bean_1,request);
%>

