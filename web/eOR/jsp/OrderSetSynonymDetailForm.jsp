<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>


<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>

<body onLoad="parent.parent.parent.defaultIntLowerFrame();" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='detailUpperForm' id='detailUpperForm' target='messageFrame' >
<%

try{

	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */
	
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_CareSet" ;
	String bean_name = "eOR.CareSetBean";
	//String disabled = "" ;


	CareSetBean bean = (CareSetBean)getBeanObject(bean_id, bean_name,request ) ;
	bean.setLanguageId(localeName);
	//headerStore
	HashMap careSetHeaderStr =	bean.getCareSetHeaderStr();

	String eff_status					   = "E" ; //For modify mode Only

	//to display the tab
	String StyleDefaultSyn				   = "bottom-margin:0;"  ;
	/**/



	/**********UPDATABLE DEF******************/
	 //Syn  Tab
	String catalog_synonym_directCare_updatable			 = "Y";
	String effective_status_directCare_updatable		 = "Y";
	String catalog_synonym_ancillaryDept_updatable		 = "Y";
	String effective_status_ancillaryDept_updatable		 = "Y";


	/******Retriving Store for this tab*******/
	ArrayList  synonymsRecStr =  bean.getsynonymsRecStr();

  	if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )){
		//In modify mode if the eff status is no then all shold be disabled
		eff_status  = (String)careSetHeaderStr.get("eff_status");
		eff_status	= eff_status.trim();
	}


%>


<!-- ------------------Synonyms------------------------- -->

<table class='grid' id="synonyms" width="98%" style="<%=StyleDefaultSyn%>">



	<%if(eff_status.trim().equalsIgnoreCase("D")){//only in mod mode if eff_staus is disabled
	catalog_synonym_directCare_updatable	 =  "N" ;
	catalog_synonym_ancillaryDept_updatable  =  "N" ;
	effective_status_directCare_updatable	 =  "N"	;
	effective_status_ancillaryDept_updatable =  "N"	;
	}%>

 <tr>
	   <th class=columnheader id="" align="left"><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
	   <th class=columnheader id="" align="left"><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
	   <th class=columnheader id="" align="left"><fmt:message key="Common.active.label" bundle="${common_labels}"/></td>
 </tr>


 <TR><td colspan='3'></td></TR>


 <tr style="bottom-margin:0;display:none">
		<td class="gridData" style="bottom-margin:0;display:none" ><fmt:message key="Common.primary.label" bundle="${common_labels}"/></td>
		<td class='gridData'><input type=text size='40' maxlength="40"
		onBlur="parent.parent.parent.makeValidString(this);"
		name='catalog_synonym_primary' id='catalog_synonym_primary' value="<%=bean.getdefaultArrListValue(synonymsRecStr,0,"catalog_synonym_primary","")%>" readonly></td>
		<td class='gridData'><input type='checkbox' value='Y'  name='effective_status_primary' id='effective_status_primary'  <%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(synonymsRecStr,0,"effective_status_primary",""))%>  checked></td>
 </tr>

  <TR><td colspan='3'></td></TR>

 <tr>
		<td class="gridData"><fmt:message key="eOR.DirectCare.label" bundle="${or_labels}"/></td>
		<td class='gridData'><input type=text size='40' maxlength="40"
		onBlur="parent.parent.parent.makeValidString(this);" <%=eHISFormatter.chkReturn("y",catalog_synonym_directCare_updatable,"","disabled")%>
		name='catalog_synonym_directCare' value="<%=bean.getdefaultArrListValue(synonymsRecStr,0,"catalog_synonym_directCare","")%>"></td>
		<td class='gridData'><input type='checkbox' value='Y'
		<%=eHISFormatter.chkReturn("y",effective_status_directCare_updatable,"","disabled")%>
		name='effective_status_directCare' <%=eHISFormatter.ChkBoxChecked("y",  bean.getdefaultArrListValue(synonymsRecStr,0,"effective_status_directCare",""))%>  ></td>
 </tr>

 <TR><td colspan='3'></td></TR>

 <tr>
		<td class="gridData"><fmt:message key="eOR.AncillaryDept.label" bundle="${or_labels}"/></td>
		<td class='gridData'><input type=text size='40' name='catalog_synonym_ancillaryDept' id='catalog_synonym_ancillaryDept' maxlength="40"
		onBlur="parent.parent.parent.makeValidString(this);"
		<%=eHISFormatter.chkReturn("y",catalog_synonym_ancillaryDept_updatable,"","disabled")%>	value="<%=bean.getdefaultArrListValue(synonymsRecStr,0,"catalog_synonym_ancillaryDept","")%>"></td>
		<td class='gridData'><input type='checkbox'name='effective_status_ancillaryDept'  value='Y'
		<%=eHISFormatter.chkReturn("y",effective_status_ancillaryDept_updatable,"","disabled")%>
		<%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(synonymsRecStr,0,"effective_status_ancillaryDept",""))%> ></td>
 </tr>

 <TR><td colspan='3'></td></TR>

</table>

 <tr><td colspan></td></tr>

</table>

<!-- ---------------------The  End-------------------------------- -->
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
	<input type="hidden" name="tabType" id="tabType" value="S">
		<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">

 </form>

<%
 putObjectInBean(bean_id,bean,request);	
}catch(Exception e){
	e.printStackTrace();
}%>
</body>
</html>

