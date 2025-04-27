<!DOCTYPE html>
<!--  
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
16/03/2022       41064             krishna pranay             16/03/2023     Ramesh Goli              AAKH-CRF-0172

---------------------------------------------------------------------------------------------------------
-->
<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*,java.text.*,com.ehis.util.*" contentType="text/html;charset=UTF-8"%> 
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<title>
	<fmt:message key="eCA.viewAuditedTrail.label" bundle="${ca_labels}"/> 
</title>
<head>
<%
String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eCA/js/CoderFunction.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");	
    Properties p;
    session = request.getSession(false);
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String bean_id				= "CACoderFunction" ;
	String bean_name			= "eCA.CACoderFunction";
	CACoderFunction bean	= (CACoderFunction)getBeanObject( bean_id, bean_name , request) ;
	String locale = (String) p.getProperty("LOCALE");
    String patient_id = request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id");
	String facility	= (String) session.getValue( "facility_id" ) ;
	String slClassValue = "gridData";
	ArrayList auditDetailsList = bean.getAuditDetails(patient_id,encounter_id,facility,locale);
%>
<form name="caCoderFunctionAuditForm" id="caCoderFunctionAuditForm">
	<table  class='grid' width="100%">
		<tr>
			<td class="COLUMNHEADER" width="20%" style="text-align: center">
				<fmt:message key="eCA.oldcoding.label" bundle="${ca_labels}" />
			</td>
			<td class="COLUMNHEADER" width="20%" style="text-align: center">
				<fmt:message key="eCA.newcoding.label" bundle="${ca_labels}" />
			</td>
			<td class="COLUMNHEADER" width="15%" style="text-align: center">
				<fmt:message key="eCA.ActionDateTime.label" bundle="${ca_labels}" />
			</td>
			<td class="COLUMNHEADER" width="25%" style="text-align: center">
				<fmt:message key="Common.user.label" bundle="${common_labels}" />
			</td>
			<td class="COLUMNHEADER" width="20%" style="text-align: center">
				<fmt:message key="Common.remarks.label" bundle="${common_labels}" />
			</td>
		</tr>

		<%
        if(auditDetailsList.size()>0){
        	for(int i=0;i<auditDetailsList.size();i++){
        		HashMap<String, String> recAuditDetails = (HashMap<String, String>)auditDetailsList.get(i);
        		String previActionStatus="";
        		String actionStatus="";
        		if("DQ".equals((String)recAuditDetails.get("PREV_ACTION_STATUS"))){
        			previActionStatus="Doctor Query";
        		}else if("SQ".equals((String)recAuditDetails.get("PREV_ACTION_STATUS"))){
        			previActionStatus="Supervisor Query";
        		}else if("HD".equals((String)recAuditDetails.get("PREV_ACTION_STATUS"))){
        			previActionStatus="Hold";
        		}else if("PC".equals((String)recAuditDetails.get("PREV_ACTION_STATUS"))){
        			previActionStatus="Partially Completed";
        		}else if("CO".equals((String)recAuditDetails.get("PREV_ACTION_STATUS"))){
        			previActionStatus="Complete";
        		}else if("SC".equals((String)recAuditDetails.get("PREV_ACTION_STATUS"))){
        			previActionStatus="Supervisor Clearance Completed";
        		}else if("NW".equals((String)recAuditDetails.get("PREV_ACTION_STATUS"))){
        			previActionStatus="In Progress";
        		}
        		
        		if("DQ".equals((String)recAuditDetails.get("ACTION_STATUS"))){
        			actionStatus="Doctor Query";
        		}else if("SQ".equals((String)recAuditDetails.get("ACTION_STATUS"))){
        			actionStatus="Supervisor Query";
        		}else if("HD".equals((String)recAuditDetails.get("ACTION_STATUS"))){
        			actionStatus="Hold";
        		}else if("PC".equals((String)recAuditDetails.get("ACTION_STATUS"))){
        			actionStatus="Partially Completed";
        		}else if("CO".equals((String)recAuditDetails.get("ACTION_STATUS"))){
        			actionStatus="Complete";
        		}else if("SC".equals((String)recAuditDetails.get("ACTION_STATUS"))){
        			actionStatus="Supervisor Clearance Completed";
        		}else if("NW".equals((String)recAuditDetails.get("ACTION_STATUS"))){
        			actionStatus="In Progress";
        		}
            %>
			<tr>
				<td style="text-align: left" class='<%=slClassValue %>'><%=previActionStatus%></td>
				<td style="text-align: left" class='<%=slClassValue %>'><%=actionStatus%></td>
				<td style="text-align: left" class='<%=slClassValue %>'><%=recAuditDetails.get("ACTION_DATE_TIME")%></td>
				<td style="text-align: left" class='<%=slClassValue %>'><%=recAuditDetails.get("ACTION_BY")%></td>
				<td style="text-align: left" class='<%=slClassValue %>'><%=recAuditDetails.get("REMARKS")%></td>
			</tr>
			<%
            }
        }else{
        	 %>
 			<tr>
 				<td style="text-align: center" class='<%=slClassValue %>' colspan=5 >Query caused no records .</td>
 				
 			</tr>
 			<%
        }%> 
		</table>
<input type=hidden name='function_id' id='function_id' value="caCoderFunctionAuditForm">

</form>
</body>
</html>

