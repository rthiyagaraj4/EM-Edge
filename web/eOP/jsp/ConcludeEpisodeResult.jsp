<!DOCTYPE html>
<%@ page import="java.util.*, java.sql.*, java.net.*, java.text.*, webbeans.eCommon.*,com.ehis.util.*" contentType="text/html; charset=UTF-8" %>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script> 
	<script language="javascript" src="../../eOP/js/ConcludeEpisode.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>

</head>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<form name="conclude_episode_result" id="conclude_episode_result">
<%
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;	
 	String classValue = "";
	String practname = "";
	String clinic_code = "";
	String clinic_desc = "";
	String service_code = "";
	String service_desc = "";
	String whereClause = "";
	//String endOfRes="1";
	String gender = "";
	String locale=(String)session.getAttribute("LOCALE");
	whereClause = request.getParameter("whereclause");	
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
	String visDtTm = "";
	String visDtTm_display = "";

	String patient_menu = "";
	String start_date = "";
	String sydate = "";

	if(whereClause == null || whereClause.equals("null")) whereClause="";
	
	if ((whereClause == null || whereClause.equals("")))
	{		
		whereClause = request.getParameter("where_clause");
	}
	int start = 0 ;
    int end = 0 ;
	int i = 1;
    

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from );

    if ( to == null )
        end = 14 ;
    else
        end = Integer.parseInt( to ) ;
	
	String facility_id = (String) session.getValue("facility_id"); 

	//int maxRecord = 0;
	try
	{
		con = ConnectionManager.getConnection(request);

        // The sql query results Episode id, patient id, patient name, age, last visit date time, Practitioner name and displays the results in the result screen   ---  Srijagadeesh. 		

		//String sql = "SELECT a.CLINIC_CODE, c.short_desc CLINIC_DESC, a.SERVICE_CODE, f.short_desc SERVICE_DESC, a.EPISODE_ID, b.PATIENT_ID, DECODE('"+locale+"', 'en', b.patient_name, NVL(b.patient_name_loc_lang, b.patient_name)) PATIENT_NAME, CALCULATE_AGE(TO_CHAR(b.DATE_OF_BIRTH,'DD/MM/YYYY'),1) AGE, b.SEX GENDER, a.LAST_ENCOUNTER_ID, TO_CHAR(a.LAST_VISIT_DATE,'DD/MM/YYYY HH24:MI') LAST_VISIT_DATE_TIME, e.practitioner_id ATTEND_PRACTITIONER_ID, decode(e.practitioner_id,'*ALL','*ALL',am_get_desc.am_practitioner(e.practitioner_id,'"+locale+"','1')) PRACTITIONER_NAME FROM OP_EPISODE_FOR_SERVICE A, MP_PATIENT B, op_patient_queue E, op_clinic_lang_vw c, am_service_lang_vw f WHERE A.EPISODE_STATUS = '01' AND A.PATIENT_ID = B.PATIENT_ID AND A.OPERATING_FACILITY_ID = E.FACILITY_ID AND A.LAST_ENCOUNTER_ID = E.ENCOUNTER_ID "+whereClause+" AND A.LAST_VISIT_FU_REQD_YN='N' AND (E.queue_status IN ('07','08') OR e.queue_status = '99') AND a.operating_facility_id = c.facility_id AND a.clinic_code = c.clinic_code AND c.language_id = '"+locale+"' AND a.service_code = f.service_code AND f.language_id = '"+locale+"' GROUP BY a.CLINIC_CODE, c.short_desc, a.SERVICE_CODE, f.short_desc, a.EPISODE_ID, b.PATIENT_ID, DECODE('"+locale+"', 'en', b.patient_name, NVL(b.patient_name_loc_lang, b.patient_name)), b.DATE_OF_BIRTH, b.SEX, a.LAST_ENCOUNTER_ID, a.LAST_VISIT_DATE, e.PRACTITIONER_ID  ORDER BY CLINIC_DESC, SERVICE_DESC,TO_DATE(LAST_VISIT_DATE_TIME,'DD/MM/YYYY HH24:MI')";

		String sql = "SELECT a.CLINIC_CODE, op_get_desc.op_clinic('"+facility_id+"',a.CLINIC_CODE,'"+locale+"',2) CLINIC_DESC, get_patient_line(a.patient_id,'"+locale+"') patient_menu , a.SERVICE_CODE, am_get_desc.AM_SERVICE(a.SERVICE_CODE,'"+locale+"',2) SERVICE_DESC, a.EPISODE_ID, b.PATIENT_ID, DECODE('"+locale+"', 'en', b.patient_name, NVL(b.patient_name_loc_lang, b.patient_name)) PATIENT_NAME, CALCULATE_AGE(TO_CHAR(b.DATE_OF_BIRTH,'DD/MM/YYYY'),1) AGE, b.SEX GENDER, a.LAST_ENCOUNTER_ID, TO_CHAR(a.start_date_time,'dd/mm/yyyy hh24:mi') start_date, TO_CHAR(a.LAST_VISIT_DATE,'DD/MM/YYYY HH24:MI') LAST_VISIT_DATE_TIME, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') sydate, e.practitioner_id ATTEND_PRACTITIONER_ID, decode(e.practitioner_id,'*ALL','*ALL', am_get_desc.am_practitioner(e.practitioner_id,'"+locale+"','1')) PRACTITIONER_NAME FROM OP_EPISODE_FOR_SERVICE A, MP_PATIENT B, op_patient_queue E WHERE A.EPISODE_STATUS = '01' AND A.PATIENT_ID = B.PATIENT_ID AND A.OPERATING_FACILITY_ID = E.FACILITY_ID AND A.LAST_ENCOUNTER_ID = E.ENCOUNTER_ID "+whereClause+" AND A.LAST_VISIT_FU_REQD_YN='N' AND (E.queue_status IN ('07','08') OR e.queue_status = '99') ORDER BY CLINIC_DESC, SERVICE_DESC, TO_DATE(LAST_VISIT_DATE_TIME,'DD/MM/YYYY HH24:MI')";
		
	//	System.out.println("sql in conclude----->"+sql);
		
		pstmt = con.prepareStatement(sql);		
		rs = pstmt.executeQuery();	

		if ( start != 1 )
		     for( int k=1; k<start; i++,k++ )				
			     rs.next() ;		
		
		int cnt = 0;

		while( i <= end && rs.next() )
		{ //rs.previous();
		  if (cnt==0)
			{%>	
			<p>
			<table align='right'>
			<tr>			
			<%
				if ( !(start <= 1) )
					out.println("<td align ='right'><A HREF='../../eOP/jsp/ConcludeEpisodeResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(whereClause)+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");				
			%>
			<td align ='right' id='next' style='visibility:hidden'>
			<%
				
				out.println("<A  HREF='../../eOP/jsp/ConcludeEpisodeResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(whereClause)+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			%>
			</td>
			</tr>
			</table>
			<br>
			</p>
			<table width="100%" border='1' cellpadding="0" cellspacing="0">
			<th class='columnheader' style="background-color: color: white;" >&nbsp;</th>
			<th class='columnheader' style="background-color: color: white;" nowrap><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/></th>
			<th class='columnheader' style="background-color: color: white;"><fmt:message key="Common.VisitDateTime.label" bundle="${common_labels}"/></th>
			<th class='columnheader' style="background-color: color: white;"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
			<th class='columnheader' style="background-color: color: white;"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
			<th class='columnheader' style="background-color: color: white;"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
			<th class='columnheader' style="background-color: color: white;"><fmt:message key="Common.age.label" bundle="${common_labels}"/></th>
			<th class='columnheader' style="background-color: color: white;"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
			<% }
			
				if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;

				clinic_desc	= rs.getString("CLINIC_DESC");
				service_desc = rs.getString("SERVICE_DESC");

				if(i == 1)
					{
						clinic_code	= rs.getString("CLINIC_CODE");
						service_code = rs.getString("SERVICE_CODE");
					%>
				
						<tr><td colspan='8' class='CAGROUPHEADING'> <%=clinic_desc%> / <%=service_desc%></td></tr>
					<%
					}else
					{
						if(!clinic_code.equals(rs.getString("CLINIC_CODE")) && !service_code.equals(rs.getString("SERVICE_CODE")))
						{
							clinic_code = rs.getString("CLINIC_CODE");
							service_code = rs.getString("SERVICE_CODE");
					%>	
							<tr><td colspan='8' class='CAGROUPHEADING'> <%=clinic_desc%> / <%=service_desc%></td></tr>
					<%
					}else if(!service_code.equals(rs.getString("SERVICE_CODE")))
						 {
								service_code = rs.getString("SERVICE_CODE");
					%>
								<tr><td colspan='8' class='CAGROUPHEADING'> <%=clinic_desc%> / <%=service_desc%></td></tr>

					<%
								}else if(!clinic_code.equals(rs.getString("CLINIC_CODE")))
							 {
								clinic_code = rs.getString("CLINIC_CODE");
					%>	
								<tr><td colspan='8'class='CAGROUPHEADING'> <%=clinic_desc%> / <%=service_desc%></td></tr>
					<%
							 }
						}				    

					practname = rs.getString("PRACTITIONER_NAME");
					if(practname == null || practname.equals("null")) practname = "&nbsp;";

					patient_menu = rs.getString("patient_menu") == null?"":rs.getString("patient_menu");
					start_date = rs.getString("start_date") == null?"":rs.getString("start_date");
					sydate = rs.getString("sydate") == null?"":rs.getString("sydate"); 		
					
					

					out.println("<tr><td class='"+classValue+"' ><a href='javascript:showpPrevEncounters(\""+rs.getString("EPISODE_ID")+"\")'>&nbsp;+&nbsp;</a></td>");
					out.println("<td class='"+classValue+"' nowrap><a href=\"javascript:conclude('"+rs.getString("EPISODE_ID")+"','"+rs.getString("PATIENT_ID")+"','"+patient_menu+"','"+practname+"','"+clinic_desc+"','"+service_desc+"','"+start_date+"','"+sydate+"')\">"+rs.getString("EPISODE_ID")+"</a></td>");
					visDtTm = rs.getString("LAST_VISIT_DATE_TIME");
					visDtTm_display = DateUtils.convertDate(visDtTm,"DMYHM","en",locale); 
%>					
					<td class=<%=classValue%> nowrap><%=visDtTm_display%></td>
					<td class=<%=classValue%> nowrap><%=rs.getString("PATIENT_ID")%></td>
					<td class=<%=classValue%> nowrap><%=rs.getString("PATIENT_NAME")%></td>

					<% 
					   gender = rs.getString("GENDER"); 
					   if(gender.equals("M")) 
						  gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					   else if(gender.equals("F"))
						  gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					   else if(gender.equals("U"))
						  gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");	
					%>

					<td class=<%=classValue%> nowrap><%=gender%></td>
					<td class=<%=classValue%> nowrap><%=rs.getString("AGE")%> Y </td>
					<td class=<%=classValue%> nowrap><%=practname%></td></tr>
			<%		
					i++;
					cnt++;
		} //end while
			//}

   //rs.previous();  

if (cnt==0)
{	
   out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
}	

if ( cnt < 14 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById("next"))
		document.getElementById("next").style.visibility='hidden';
	</script>
	<% 
		} else {%>
	<script >
	if (document.getElementById("next"))
		document.getElementById("next").style.visibility='visible';
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}
	
}catch(Exception e)
{ 
	e.printStackTrace();
}
	finally
	{
		try{
		out.println("<script>parent.frames[1].document.forms[0].search.disabled = false ;</script>");
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(con != null)
			ConnectionManager.returnConnection(con,request);
	}
%>
</table>
</form>
</body>
</html>

