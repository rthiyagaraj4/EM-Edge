<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*, java.sql.*, java.net.*, java.text.*, webbeans.eCommon.*,com.ehis.util.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>
<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script> 
</head>
<title><fmt:message key="eOP.EpisodeVisitDetails.label" bundle="${op_labels}"/></title>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<form name="conclude_episode_episodes" id="conclude_episode_episodes">
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int i = 1;
	String practname = "";
 	String classValue = "";
	String Pat_Details = "";
	
	String Episodeid = request.getParameter("Episode");
	String facilityid    = (String) session.getValue( "facility_id" ) ;
	String locale=(String)session.getAttribute("LOCALE");
	String visitDt = "";
	String visitDt_display = "";

	try
	{
		con = ConnectionManager.getConnection(request);
		//String sql = "Select to_char(PR_ENCOUNTER.VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI') VISIT_DATE, PR_ENCOUNTER.ENCOUNTER_ID ENCOUNTER_ID, OP_VISIT_TYPE.SHORT_DESC VISIT_TYPE_DESC, OP_CLINIC.SHORT_DESC  CLINIC_NAME, AM_SERVICE.SHORT_DESC SERVICE_DESC, AM_PRACTITIONER.PRACTITIONER_NAME PRACTITIONER_NAME, get_patient_line(PR_ENCOUNTER.PATIENT_ID) PATIENT_MENU FROM PR_ENCOUNTER, OP_VISIT_TYPE, OP_CLINIC, AM_PRACTITIONER, AM_SERVICE WHERE PR_ENCOUNTER.EPISODE_ID = '"+Episodeid+"' AND PR_ENCOUNTER.FACILITY_ID = '"+facilityid+"' AND PR_ENCOUNTER.FACILITY_ID = OP_VISIT_TYPE.FACILITY_ID AND PR_ENCOUNTER.VISIT_ADM_TYPE = OP_VISIT_TYPE.VISIT_TYPE_CODE AND PR_ENCOUNTER.FACILITY_ID = OP_CLINIC.FACILITY_ID AND PR_ENCOUNTER.ASSIGN_CARE_LOCN_CODE = OP_CLINIC.CLINIC_CODE AND PR_ENCOUNTER.ATTEND_PRACTITIONER_ID = AM_PRACTITIONER.PRACTITIONER_ID (+) AND PR_ENCOUNTER.SERVICE_CODE = AM_SERVICE.SERVICE_CODE (+) ORDER BY PR_ENCOUNTER.VISIT_ADM_DATE_TIME";

		String sql = "SELECT TO_CHAR(a.queue_date,'DD/MM/YYYY HH24:MI') VISIT_DATE , a.ENCOUNTER_ID ENCOUNTER_ID , op_get_desc.OP_VISIT_TYPE(a.facility_id, a.VISIT_TYPE_code,'"+locale+"',2) VISIT_TYPE_DESC  ,op_get_desc.op_clinic(a.facility_id, a.LOCN_CODE,'"+locale+"',1 ) CLINIC_NAME, am_get_desc.am_service(a.service_code,'"+locale+"',2) SERVICE_DESC, am_get_desc.am_practitioner(a.PRACTITIONER_ID,'"+locale+"',2) PRACTITIONER_NAME ,get_patient_line(a.PATIENT_ID,'"+locale+"') PATIENT_MENU  FROM op_patient_queue a WHERE a.EPISODE_ID = '"+Episodeid+"' AND a.FACILITY_ID = '"+facilityid+"' ORDER BY a.queue_date ";

		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();

		if(rs != null)
		{
			while(rs.next())
			{
				if( i == 1)
				{
					Pat_Details = rs.getString("PATIENT_MENU");
					Pat_Details = Pat_Details.substring(0,Pat_Details.length()-7);
					practname = rs.getString("PRACTITIONER_NAME");
					if(practname == null || practname.equals("null")) practname = "&nbsp;";

			%>
					<center><table border='0' cellpadding='0' cellspacing='0' width='100%'>
					<tr><td class='PATIENTLINECOLOR' width='75%' style='position:relative;' colspan='2'><%=Pat_Details%></td></tr>
					<tr><td class='PATIENTLINECOLOR' width='75%' style='position:relative;'><%=practname%> / <%=rs.getString("CLINIC_NAME")%> / <%=rs.getString("SERVICE_DESC")%></td>
					<td class='PATIENTLINECOLOR' width='25%' align='right' nowrap><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/>:<%=Episodeid%></td></tr>
					<tr><td colspan='2' class='BLANKWHITEROW'>&nbsp;</td></tr>
					</table></center>
					<table width='100%' border='1' cellpadding='0' cellspacing='0'>
					<th class='columnheader' style="background-color: color: white;" ><fmt:message key="Common.VisitDateTime.label" bundle="${common_labels}"/></th>
					<th class='columnheader' style="background-color: color: white;" ><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></th>
					<th class='columnheader' style="background-color: color: white;" ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
					<th class='columnheader' style="background-color: color: white;" ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
					<th class='columnheader' style="background-color: color: white;" ><fmt:message key="Common.service.label" bundle="${common_labels}"/></th>
					<th class='columnheader' style="background-color: color: white;" ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
			<%	
				}

				if ( i % 2 == 0 )
                    classValue = "QRYEVEN" ;
                else
					classValue = "QRYODD" ;

				practname = rs.getString("PRACTITIONER_NAME");
				if(practname == null || practname.equals("null")) practname = "&nbsp;";
				visitDt = rs.getString("VISIT_DATE");	
				visitDt_display=DateUtils.convertDate(visitDt,"DMYHM","en",locale);
			%>
				<tr><td class=<%=classValue%> nowrap><%=visitDt_display%></td>
				<td class=<%=classValue%> nowrap><%=rs.getString("VISIT_TYPE_DESC")%></td>
				<td class=<%=classValue%> nowrap><%=rs.getString("ENCOUNTER_ID")%></td>
				<td class=<%=classValue%> nowrap><%=rs.getString("CLINIC_NAME")%></td>
				<td class=<%=classValue%> nowrap><%=rs.getString("SERVICE_DESC")%> Y </td>
				<td class=<%=classValue%> nowrap><%=practname%></td></tr>
			<%	
				i++;
			}
		}
	
	
		if(rs != null)	rs.close();
		if(pstmt != null)	pstmt.close();
	
	}catch(Exception e)
	{ 
		e.printStackTrace(); 
	}

	finally
	{
		try{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		if(con != null)
			ConnectionManager.returnConnection(con,request);
	}
%>
</table>
</form>
</body>
<html>

