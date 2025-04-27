<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<html>
	<head>
	<title><fmt:message key="eMO.StartPostmortem.label" bundle="${mo_labels}"/></title>
	<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");
	 Connection conn = null;

%>
      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eMO/js/MOManageDeceased.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body  onKeyDown="lockKey()" >
	<center>
    <form name='AEMPAllowedOperationsForm' id='AEMPAllowedOperationsForm'>
	<%String fac_id				 = (String) session.getValue("facility_id") ;
	String select_registration	= "";
	String select_name			= "";
	String or_installyn=(request.getParameter("or_installyn")==null)? "" : request.getParameter("or_installyn");
	String order_catalog_code=(request.getParameter("order_catalog_code")==null)? "" : request.getParameter("order_catalog_code");
	String encounterId=(request.getParameter("encounterId")==null)? "" : request.getParameter("encounterId");
	String patient_id=(request.getParameter("patient_id")==null)? "" : request.getParameter("patient_id");
	select_registration			=	(request.getParameter("select_registration")==null)? "" : request.getParameter("select_registration");
	select_name			=	(request.getParameter("select_name")==null)? "" : request.getParameter("select_name");
	String select_pmyn	=	request.getParameter("select_pmyn");
	select_pmyn			=	((select_pmyn==null) || (select_pmyn.equals(""))) ? "" : select_pmyn;
	String assign_area_code	=	request.getParameter("assign_area_code");
	assign_area_code		=	((assign_area_code==null) || (assign_area_code.equals(""))) ? "" : assign_area_code;
	String select_pmstatus	=	request.getParameter("select_pmstatus");
	select_pmstatus			=	((select_pmstatus==null) || (select_pmstatus.equals(""))) ? "" : select_pmstatus;
	
	String area_type		=	request.getParameter("area_type")==null?"":request.getParameter("area_type");
	String CLAIMANT_TYPE=	(request.getParameter("CLAIMANT_TYPE")==null)? "" : request.getParameter("CLAIMANT_TYPE"); // Bru-HIMS-CRF-366 [IN-039612]
	String RELEASE_TO_FACILITY=	(request.getParameter("RELEASE_TO_FACILITY")==null)? "" : request.getParameter("RELEASE_TO_FACILITY"); // Bru-HIMS-CRF-366 [IN-039612]
	Statement stmt=null;
	ResultSet rset=null;
	String patient_class="";
	String deceased_yn="";
	String postmortem_type="";
	String postmortem_status="";
	String body_part_yn="";
	String patient_age="";
	String date_of_birth="";
	String body_received_date="";
	try{
		conn     = ConnectionManager.getConnection(request);
		stmt	 = conn.createStatement();
		String sql="SELECT patient_class,date_of_birth,deceased_yn,postmortem_status,postmortem_type,BODY_RECEIVED_DATE,BODY_PART_OBTAINED_FROM,age FROM mo_mortuary_regn_vw where registration_no='"+select_registration+"' and facility_id='"+fac_id+"' ";
		
		
		rset	= stmt.executeQuery(sql);
		if(rset!=null && rset.next()){
			patient_class=rset.getString("patient_class")==null?"":rset.getString("patient_class");
			date_of_birth=rset.getString("date_of_birth")==null?"":rset.getString("date_of_birth");
			deceased_yn=rset.getString("deceased_yn")==null?"N":rset.getString("deceased_yn");
			postmortem_status=rset.getString("postmortem_status")==null?"":rset.getString("postmortem_status");
			postmortem_type=rset.getString("postmortem_type")==null?"":rset.getString("postmortem_type");
			
			patient_age=rset.getString("age")==null?"":rset.getString("age");
			body_received_date=rset.getString("BODY_RECEIVED_DATE")==null?"":rset.getString("BODY_RECEIVED_DATE");
			body_part_yn=rset.getString("body_part_obtained_from")==null?"N":rset.getString("body_part_obtained_from");
		}
		if(rset!=null)  rset.close();
		if(stmt!=null)  stmt.close();
	%>
	<table border='1' cellpadding='0' cellspacing='0' width='100%'>
	<%
   
	if (select_registration.equalsIgnoreCase(""))
	{
	%>
	<th><%=select_name%></th>	
	<tr><td class='QRYODD'>
		<a href='javascript:callOperation("RegisterDeceased")'><fmt:message key="eMO.DeceasedReg.label" bundle="${mo_labels}"/></a>
		</td></tr>
			

	<%
	}
	else	if (((select_pmyn.equalsIgnoreCase("Y")) && (select_pmstatus.equalsIgnoreCase("D"))))
	{
	%>
		<th><%=select_name%></th>	
	<tr><td class='QRYODD'>
	
	<a href='javascript:callexecuteEnd()'><fmt:message key="eMO.EndPostmortem.label" bundle="${mo_labels}"/></a>
	
	</td></tr>
	<tr><td class='QRYODD'>
		<a href='javascript:viewMovmentHist()'><fmt:message key="eMO.ViewMovementHistory.label" bundle="${mo_labels}"/></a>
	 </td>
		
	</tr>
	
	<%
	}
	else	if (((select_pmyn.equalsIgnoreCase("Y")) && (select_pmstatus.equalsIgnoreCase("A"))))
	{
	%>
		<th><%=select_name%></th>	
	<tr><td class='QRYODD'>
	<%if(assign_area_code.equals("Unassigned"))
		{%>
	
	<a href='javascript:callOperation("AssignArea")'><fmt:message key="Common.assignarea.label" bundle="${common_labels}"/></a>
	 
		<%}else{%>
	<a href='javascript:callOperation("ReassignArea")'><fmt:message key="eMO.ReassignArea.label" bundle="${mo_labels}"/></a>
		<%
		
		}%>
		</td>
		</tr>
	
	<tr><td class='QRYODD'>
	
	<a href="javascript:postmortemRequest('<%=or_installyn%>','<%=order_catalog_code%>','<%=	encounterId%>','<%=fac_id%>')"><fmt:message key="eMO.PostmortemRequest.label" bundle="${mo_labels}"/></a>
	</td></tr>
	<tr><td class='QRYODD'>
		<a href='javascript:viewMovmentHist()'><fmt:message key="eMO.ViewMovementHistory.label" bundle="${mo_labels}"/></a>
	 </td></tr>
	
	<%
	}
	else if (((select_pmyn.equalsIgnoreCase("Y")) && (select_pmstatus.equalsIgnoreCase("R"))))
	{
	%>
		<th><%=select_name%></th>	
	<tr><td class='QRYODD'>
	<%if(assign_area_code.equals("Unassigned"))
		{%>
	
	<a href='javascript:callOperation("AssignArea")'><fmt:message key="Common.assignarea.label" bundle="${common_labels}"/></a>
	 
		<%}else{%>
	<a href='javascript:callOperation("ReassignArea")'><fmt:message key="eMO.ReassignArea.label" bundle="${mo_labels}"/></a>
		<%}%>
		</td>
		</tr>
		
	
	
	<%if(area_type.equalsIgnoreCase("P"))	{%>
	<tr><td class='QRYODD'>
	<a href='javascript:callexecuteStart()'><fmt:message key="eMO.RecordPostmortem.label" bundle="${mo_labels}"/></a>
	</td></tr>
	<%}%> 
	
	<tr><td class='QRYODD'>
		<a href='javascript:viewMovmentHist()'><fmt:message key="eMO.ViewMovementHistory.label" bundle="${mo_labels}"/></a>
	 </td></tr>
	
	<%
	}


	else	if (((select_pmyn.equalsIgnoreCase("Y")) || (select_pmyn.equalsIgnoreCase("N"))) && (assign_area_code.equals("Unassigned")))
	{
	%>
	<th><%=select_name%></th>	
	<tr><td class='QRYODD'>
		<a href='javascript:callOperation("AssignArea")'><fmt:message key="Common.assignarea.label" bundle="${common_labels}"/></a>
		</td></tr><tr><td class='QRYODD'>
		<a href='javascript:viewMovmentHist()'><fmt:message key="eMO.ViewMovementHistory.label" bundle="${mo_labels}"/></a>
	 </td></tr>
	<%
	}
	else if (((select_pmyn.equalsIgnoreCase("Y")) || (select_pmyn.equalsIgnoreCase("N"))) && (!assign_area_code.equals("Unassigned")))
	{ 
	%>
	<th><%=select_name%></th>
	<%
	/*Below line modified for this CRF Bru-HIMS-CRF-407*/
	if ((select_pmstatus.equalsIgnoreCase("E")||select_pmstatus.equalsIgnoreCase("PM Completed")||(select_pmstatus.equalsIgnoreCase("PM Cancelled"))||(select_pmstatus.equalsIgnoreCase("N"))||(select_pmstatus.equals("A")) ||(select_pmstatus.equals("R"))))
	{
	%>
	<tr><td class='QRYODD'>
			<a href='javascript:callOperation("ReassignArea")'><fmt:message key="eMO.ReassignArea.label" bundle="${mo_labels}"/></a>
	</td>
	</tr>
		<tr><td class='QRYODD'>
		<a href='javascript:viewMovmentHist()'><fmt:message key="eMO.ViewMovementHistory.label" bundle="${mo_labels}"/></a>
	 </td></tr>
	<%
	}
	if ((select_pmyn.equalsIgnoreCase("Y")) && (!assign_area_code.equals("Unassigned")) && (select_pmstatus.equals("A")) && 
		(area_type.equals("P")))
	{
	%>
	<tr><td class='QRYODD'>
		<a href='javascript:callexecuteStart()'><fmt:message key="eMO.StartPostmortem.label" bundle="${mo_labels}"/></a>
	</td></tr>
	<%
		}
		if ((select_pmyn.equalsIgnoreCase("Y")) && (!assign_area_code.equals("Unassigned")) && (select_pmstatus.equalsIgnoreCase("S")))
		{
	%>
	<tr><td class='QRYODD'>
		<a href='javascript:callexecuteStart()'><fmt:message key="eMO.RecordPostmortem.label" bundle="${mo_labels}"/></a>
	</td></tr>
	<tr><td class='QRYODD'>
	<a href='javascript:viewMovmentHist()'><fmt:message key="eMO.ViewMovementHistory.label" bundle="${mo_labels}"/></a>
	</td></tr>
	<%
		}
	}
	
	%>
	</table>
	</center>
	
	<input type='hidden' name='patient_id' id='patient_id'		value='<%=patient_id%>'>
		<input type='hidden' name='pmstatus' id='pmstatus'		value=''>
		<input type='hidden' name='registration' id='registration'	value='<%=select_registration%>'>
		<input type='hidden' name='endPM' id='endPM'			value=''>
		<input type='hidden' name='cancelPM' id='cancelPM'		value=''>
		<input type='hidden' name='startPM' id='startPM'			value=''>
		<input type='hidden' name='or_installyn' id='or_installyn'	value='<%=or_installyn%>'>
		<input type='hidden' name='patient_class' id='patient_class'	value='<%=patient_class%>'>
		<input type='hidden' name='deceased_yn' id='deceased_yn'	value='<%=deceased_yn%>'>
		<input type='hidden' name='postmortem_type' id='postmortem_type'	value='<%=postmortem_type%>'>
		<input type='hidden' name='postmortem_status' id='postmortem_status'	value='<%=postmortem_status%>'>
		<input type='hidden' name='body_part_yn' id='body_part_yn'	value='<%=body_part_yn%>'>
		<input type='hidden' name='patient_age' id='patient_age'	value='<%=patient_age%>'>
		<input type='hidden' name='date_of_birth' id='date_of_birth'	value='<%=date_of_birth%>'>
		<input type='hidden' name='body_received_date' id='body_received_date'	value='<%=body_received_date%>'>
		<%// Below two Fileds Newly Added Bru-HIMS-CRF-366 [IN-039612]  %>
		<input type='hidden' name='CLAIMANT_TYPE' id='CLAIMANT_TYPE'		value='<%=CLAIMANT_TYPE%>'>
		<input type='hidden' name='RELEASE_TO_FACILITY' id='RELEASE_TO_FACILITY'		value='<%=RELEASE_TO_FACILITY%>'>
	<% 
	}catch ( Exception e ){
		out.println("Exception in MOManageDeceasedSearchResult "+e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(conn,request);
	}
	%>
</form>
</body>
</html>




