<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
06/09/2011    IN31901        NijithaS    Incident No: IN31901 - Bru-HIMS-CRF-263		 
-------------------------------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<%
	//String facility_id = (String)session.getValue("facility_id");
	//	out.println(facility_id);
    request.setCharacterEncoding("UTF-8");
	String mode			= request.getParameter( "mode" ) ;
	String function_id  = request.getParameter("function_id") ;
	String bean_id		= "performing_location" ;
	String bean_name	= "eOR.PerformingLocation";
	//String disabled		= "" ;

	PerformingLocation bean = (PerformingLocation)getBeanObject( bean_id,  bean_name , request) ;
	bean.setFunctionId(bean.checkForNull(function_id));
	bean.clear() ;
	bean.setMode(mode) ;

	//ArrayList all_location_type = new ArrayList();
	//all_location_type = (ArrayList)bean.loadLocationType(facility_id);
	//all_location_type=null;

%>

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>

<body  onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='perform_locn_top' id='perform_locn_top' target='messageFrame' >
	<table cellpadding=3 cellspacing=0 border="0" width='100%' height='100%' align='center'>
	<tr>
		<td  class="label" ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<td class="fields">
		<select name="locn_type" id="locn_type">
			<option value=""> ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
<%
		/*	for(int i=0; i<all_location_type.size(); i++){

				String[] location_type = (String[])all_location_type.get(0);
				if(location_type[0].equals("RL") && location_type[1].equals("N")){
					out.println("<option value=\"L\">Laboratory Site</option>");
				}
				if(location_type[0].equals("RD") && location_type[1].equals("N")){
					out.println("<option value=\"R\">Radiology Wing</option>");
				}
			}*/

%>		
			<option value="I"><fmt:message key="eOR.DepartmentalDiagnostics.label" bundle="${or_labels}"/> </option>
			
			<%//if (!bean.getLbInstall("RL").equalsIgnoreCase("Y")) {commented on 7/19/2007 by uma for labinstal chk%>
			<Option value='L'><fmt:message key="eOR.LaboratorySite.label" bundle="${or_labels}"/></Option>
			<%//}%>
			
			<option value="M"><fmt:message key="eOR.MiscellaneousService Location.label" bundle="${or_labels}"/></option>
			<option value="P"><fmt:message key="Common.PatientCare.label" bundle="${common_labels}"/></option>
			
			 <%if (!bean.getLbInstall("RD").equalsIgnoreCase("Y")) {%>
			<Option value='R'><fmt:message key="Common.RadiologyWing.label" bundle="${common_labels}"/></Option><%}%>

			<option value="T"><fmt:message key="eOR.TreatmentLocation.label" bundle="${or_labels}"/></option>
			<option value="O"><fmt:message key="eOR.NonOTRooms.label" bundle="${or_labels}"/></option><!-- IN31901 -->
		</select><img src="../../eCommon/images/mandatory.gif"></img></td>
	</tr>
	
	</table>
</form>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>

