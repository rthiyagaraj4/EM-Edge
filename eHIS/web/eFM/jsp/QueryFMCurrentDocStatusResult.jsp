<!DOCTYPE html>
  <!-- Developed By	   :-	Prashant Bhalsingh
	 Created on   	   :	21/06/2001
	 Module Name 	   :	FM\File current storage location
-->
<%@ page import="java.sql.*, java.util.*, webbeans.eCommon.* , java.text.* , java.sql.Date"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eFM/js/QueryFMCurrentFileStatus.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 <head>

 <BODY onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
 <form name="QueryFMSearchResult" id="QueryFMSearchResult" action="../../eFM/jsp/QueryFMCurrentDocStatusResult.jsp" method="post" 	>

 <%
		Connection con				= ConnectionManager.getConnection(request);
		java.sql.Statement stmt		= null;
		ResultSet rset				= null;
		java.sql.Statement stmt1	= null;
		ResultSet rset1				= null;
		java.sql.Statement stmt2	= null;
		ResultSet rs				= null;

	//	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy") ;

		String fcy_id = (String) session.getValue("facility_id");
		String queryCriteria	= (request.getParameter("criteria")==null)?"":request.getParameter("criteria") ;
		String volume_no	= (request.getParameter("volume_no")==null)?"":request.getParameter("volume_no") ;
		String facility			= (request.getParameter("facility")==null)?"":request.getParameter("facility") ;
		String patientid		= (request.getParameter("patientid")==null)?"":request.getParameter("patientid") ;
		String currStatDesc		= (request.getParameter("currStatDesc")==null)?"":request.getParameter("currStatDesc") ;
		String currIdDesc		= (request.getParameter("currIdDesc")==null)?"":request.getParameter("currIdDesc") ;
		String Curr_locn_desc		= (request.getParameter("Curr_locn_desc")==null)?"":request.getParameter("Curr_locn_desc") ;
		String appointmentDays		= (request.getParameter("appointmentDays")==null)?"":request.getParameter("appointmentDays") ;
		String bookingDays		= (request.getParameter("bookingDays")==null)?"":request.getParameter("bookingDays") ;

		String sql				= "" ;		
 %>

  <%try{%>

	 <%

	 String p_nursing_unit 		= "";
	 String p_room_num		= "";
	 String p_bed_num		= "";
	 int p_count			= 0;
	 int count			    = 0;
	 int appt_count  = 0;

	 stmt2 = con.createStatement();

	 sql = "select count(1) from oa_appt where patient_id='"+patientid+"' and facility_id ='"+fcy_id+"' and trunc(appt_date)>=trunc(sysdate) and nvl(appt_status,1) != 'A'";
	 rs = stmt2.executeQuery(sql);
	 if (rs.next())
	  {
		 appt_count = rs.getInt(1);
	  }
	 if(rs!=null)  rs.close();
		
	if (appt_count==0)
    {
		sql="select count(1) from ip_booking_list_vw where patient_id is not null and patient_id='"+patientid+"' and trunc(preferred_date)>=trunc(sysdate) and nvl(booking_status,1)=1";

		if(stmt2!=null)  stmt2.close();
		stmt2=con.createStatement();
		rs=stmt2.executeQuery(sql);
		 if (rs.next())
			 appt_count = rs.getInt(1);
	}
	if(rs!=null) rs.close();	
	sql = "select count(*) rec_cnt from sm_module where module_id='IP' ";
    rs = stmt2.executeQuery(sql);
	 while (rs.next())
	 {
	 	p_count = rs.getInt("rec_cnt");
	 }if(rs!=null) rs.close();
	 if (p_count == 1)
	 {
		 sql = "select a.nursing_unit_short_desc,nvl(a.room_no,'&nbsp;')room_no,nvl(a.bed_no,'&nbsp;')bed_no from ip_open_encounter_vw a, fm_curr_locn_vw b where a.facility_id=b.curr_facility_id and a.patient_id=b.patient_id and b.facility_id='"+facility+"' and b.file_no='"+queryCriteria+"' ";

		rs = stmt2.executeQuery(sql);
  		while (rs.next())
		{
		p_nursing_unit	=
		(rs.getString("nursing_unit_short_desc")==null)?"":rs.getString("nursing_unit_short_desc");
		p_room_num	=(rs.getString("room_no")==null)?"":rs.getString("room_no");
		p_bed_num	=(rs.getString("bed_no")==null)?"":rs.getString("bed_no");
			++count ;
		 }
		 if(rs!=null)	rs.close();

	 //This logic to adjust the length
		if(count >= 1)
			{
					int add = 0;
					int len = p_nursing_unit.length();

					add = 18 -len ;

					for(int i=0;i<add;i++)
						p_nursing_unit = p_nursing_unit +  "&nbsp;"	;

					len=0;
					add=0;

					len = p_room_num.length();

					add = 8 -len ;

					for(int k=0;k<add;k++)
						p_room_num = p_room_num +  "&nbsp;"	;


		  	}

	}
	int record_count = 0;

	sql = "SELECT COUNT(*) record_count FROM fm_curr_locn_vw a,fm_transit_file b,fm_storage_locn c, fm_storage_locn d, sm_appl_user e, sm_appl_user f, fm_storage_locn g, sm_appl_user h WHERE a.facility_id='"+ facility + "' And a.file_no='" + queryCriteria + "'  And  a.volume_no="+volume_no+" AND a.facility_id = b.facility_id(+) AND a.file_no = b.file_no(+) AND b.facility_id = c.facility_id(+)    AND b.dest_fs_locn_code = c.fs_locn_code(+) AND a.curr_facility_id = d.facility_id AND a.curr_fs_locn_code = d.fs_locn_code AND c.holder_name = e.appl_user_id(+) AND d.holder_name = f.appl_user_id(+) AND a.prev_fs_locn_code = g.fs_locn_code(+) AND g.holder_name = h.appl_user_id(+)";
	stmt			= con.createStatement();
	rset		 	= stmt.executeQuery(sql) ;
	if ((rset!=null) && (rset.next()))
		record_count = rset.getInt("record_count");
	if (stmt != null) stmt.close();
	if (rset != null) rset.close();

	if (record_count==0)
	{
	%>
		<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
			parent.searchResultFrame.document.location.href="../../eCommon/html/blank.html";
			parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp";
		</script>
	<%
	}
	else
	{
	sql = " SELECT a.file_no,get_patient_line(a.patient_id,'"+localeName+"') patient_line,a.curr_fs_locn_code, a.CURR_FS_LOCN_SHORT_DESC,a.prev_fs_locn_code, a.prev_fs_locn_desc,h.appl_user_name prev_holder_name,g.holder_phone_no prev_phone_no ,DECODE(a.curr_fs_locn_identity,'D','Department','T','Practitioner','C','Clinic','N','Nursing Unit','X','External' ,'E','Procedure Unit','Y','Daycare Unit')curr_fs_locn_identity,DECODE (a.prev_fs_locn_identity, 'D', 'Department', 'T', 'Practitioner', 'C', 'Clinic', 'N', 'Nursing Unit', 'E', 'External' ) prev_fs_locn_identity,a.curr_file_status file_status, DECODE(a.curr_file_status,'I','Inside','O','Outside','L','Lost','T','Issued-InTransit','R','Returned-InTransit' ,'A','Archived','E','Other Facility')curr_file_status,(CASE WHEN a.curr_file_status='T' THEN ' / ' || c.short_desc || ' (' || DECODE(c.locn_identity,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','E','Procedure Unit','Y','Daycare Unit') ||')' ELSE ' ' END)dest_locn, TO_CHAR(a.iss_date_time,'dd/mm/rrrr hh24:mi') iss_date_time, TO_CHAR(a.return_date_time,'dd/mm/rrrr hh24:mi') return_date_time, (CASE WHEN a.facility_id<>a.curr_facility_id THEN ' / ' || curr_facility_name ELSE ' ' END)curr_facility_name,(CASE WHEN a.facility_id <> a.prev_facility_id THEN ' / ' || prev_facility_name ELSE ' ' END ) prev_facility_name,(CASE WHEN a.curr_file_status='T' THEN e.appl_user_name ELSE f.appl_user_name END)HOLDER_NAME,(CASE WHEN a.curr_file_status = 'T' THEN c.holder_phone_no ELSE d.holder_phone_no END ) holder_phone_no, a.req_remarks,(case when (a.curr_facility_id = a.facility_id and a.curr_fs_locn_code=a.mr_pat_fs_locn_code and a.curr_file_status='I') then 'Y' else 'N' end ) owner_locn_yn, a.curr_locn_id, c.locn_identity, A.DOC_FOLDER_ID, A.DOC_FOLDER_NAME,A.DOC_TYPE_NAME, I.PATIENT_ID, I.FROM_PERIOD, I.TO_PERIOD, I.PATIENT_PERIOD_SPECIFIC,(CASE WHEN I.PATIENT_PERIOD_SPECIFIC='D' THEN ', ' || TO_CHAR(I.FROM_PERIOD,'DD/MM/YYYY ') || ' - ' || TO_CHAR(I.TO_PERIOD,'DD/MM/YYYY ')  ELSE ', ' || GET_PATIENT_LINE(I.PATIENT_ID) END)DOC_TYPE,j.TRANSPORT_MODE ,j.carried_by_name, k.long_desc transport_desc FROM fm_curr_locn_vw a,fm_transit_file b,fm_storage_locn c, fm_storage_locn d, sm_appl_user e, sm_appl_user f, fm_storage_locn g, sm_appl_user h, fm_doc_folder i,  fm_movement_log j, am_transport_mode k WHERE a.facility_id='"+ facility + "' And a.file_no='" + queryCriteria + "'  And  a.volume_no="+volume_no+" AND a.facility_id = b.facility_id(+) AND a.file_no = b.file_no(+) AND b.facility_id = c.facility_id(+)    AND b.dest_fs_locn_code = c.fs_locn_code(+) AND a.curr_facility_id = d.facility_id AND a.curr_fs_locn_code = d.fs_locn_code AND c.holder_name = e.appl_user_id(+) AND d.holder_name = f.appl_user_id(+) AND a.prev_fs_locn_code = g.fs_locn_code(+) AND g.holder_name = h.appl_user_id(+) and a.DOC_FOLDER_ID = i.DOC_FOLDER_ID(+) AND a.FACILITY_ID = i.FACILITY_ID AND a.ISS_DATE_TIME = j.sent_date_time(+) AND a.file_no = j.file_no(+) AND a.volume_no = j.volume_no(+) AND a.facility_id = j.facility_id(+) AND j.TRANSPORT_MODE = k.TRANSPORT_MODE(+)" ;	
		stmt			= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                     ResultSet.CONCUR_UPDATABLE);
    	rset		 	= stmt.executeQuery(sql) ;
	String location_identity = "";
	String current_locn		 = "";
	String sqlString		 = "";	
	String location_desc	 = "";	
	String doc_folder_id	 = "";
	String doc_folder_name	 = "";
	String doc_type	 = "";


%>

<br>
<%
		int i = 0;
		String p_req_remarks = "", p_owner_locn_yn="", p_owner_phone_yn="";
		if(rset.next())
		{
			doc_folder_id = rset.getString("doc_folder_id")==null?"&nbsp;":rset.getString("doc_folder_id");
			doc_folder_name = rset.getString("doc_folder_name")==null?"&nbsp;":rset.getString("doc_folder_name");
			doc_type = 
			rset.getString("doc_type")==null?"&nbsp;":rset.getString("doc_type");
			


			p_req_remarks = rset.getString("req_remarks");
			p_owner_locn_yn = rset.getString("owner_locn_yn");
			if (p_owner_locn_yn.trim().equals("Y"))
			{
				p_owner_locn_yn="Holder Name";
				p_owner_phone_yn="Holder Phone No.";
			}
			else
			{
				p_owner_locn_yn="Requestor Name";
				p_owner_phone_yn="Requestor Phone No.";
			}
%>

<table border="0" cellpadding="0" cellspacing="0" align='center' width="98%" border=0>
	<tr>
		<td colspan='4' class='PATIENTLINECOLOR'>
	<font size=1 color='white'><b><%=doc_folder_name%>&nbsp;<%=doc_type%>&nbsp;</b></font>	
		</td>
	
	</tr>
</table>
<br>
<table border="0" cellpadding="0" cellspacing="0" align='center' width="98%" style="border:1x solid black">		
		<td class='columnheader' width="2%" style="background:#1E3F64">&nbsp;</td>
		<td class='columnheader' width=100% colspan='2' style="background:#1E3F64"><fmt:message key="eFM.CurrentDocumentStatus.label" bundle="${fm_labels}"/></td>
		<td class='columnheader' width=100% colspan='1' style="background:#1E3F64"> <fmt:message key="eFM.PreviousDocumentStatus.label" bundle="${fm_labels}"/></td>
		<tr>
		<td  width="18%" height="20" class='label' ><fmt:message key="eFM.CurrentFSLocation.label" bundle="${fm_labels}"/></td>
		<td width="2%">&nbsp;</td>
		<%
			String identity = 			(rset.getString("curr_fs_locn_identity")==null)?"&nbsp":rset.getString("curr_fs_locn_identity");
			String prev_identity = 			(rset.getString("prev_fs_locn_identity")==null)?"&nbsp":rset.getString("prev_fs_locn_identity");
			location_identity	= rset.getString("locn_identity");
			current_locn		= rset.getString("curr_locn_id");
			if ((location_identity==null) || (location_identity.equals("null")))
				location_identity = "";
			if ((current_locn==null) || (current_locn.equals("null")))
				current_locn = "";
			if (location_identity.equals("N"))
				sqlString	=	"SELECT long_desc short_desc FROM ip_nursing_unit WHERE nursing_unit_code = '"+current_locn+"'  AND facility_id = '"+facility+"' AND eff_status = 'E' ";
			else if (location_identity.equals("C"))
				sqlString	=	"SELECT long_desc short_desc FROM op_clinic WHERE clinic_code = '"+current_locn+"' AND facility_id = '"+facility+"' AND eff_status = 'E' ";
			else if (location_identity.equals("T"))
				sqlString	=	"SELECT practitioner_name short_desc FROM am_practitioner WHERE practitioner_id = '"+current_locn+"' AND eff_status = 'E' ";
			if (!sqlString.equals(""))
			{
				if(stmt2!=null)	stmt2.close();
				stmt2 = con.createStatement();
				rs = stmt2.executeQuery(sqlString);
				if ((rs!=null) && (rs.next()))
					location_desc = rs.getString("short_desc");
				location_desc = ((location_desc==null) || (location_desc.equals("null"))) ? "&nbsp;" : (" / ("+location_desc+") ");
			}
			
		%>
	   	<td  width="40%" height="20" class='label' >&nbsp;<b><%=(rset.getString("CURR_FS_LOCN_SHORT_DESC")==null)?"&nbsp":rset.getString("CURR_FS_LOCN_SHORT_DESC") + "(" + identity + ")"%><%=rset.getString("curr_facility_name")%></td>
	   	<td  width="40%" height="20"  class='label' >&nbsp;<b><%=(rset.getString("prev_fs_locn_desc")==null)?"&nbsp":rset.getString("prev_fs_locn_desc") + "(" + prev_identity + ")"%><%=rset.getString("prev_facility_name")%></td>
		</tr>
		<tr><td  colspan="4" height="2" ></td></tr>
		<tr>
		<td  width="18%" height="20" class='label'>
			<fmt:message key="eFM.DocumentStatus.label" bundle="${fm_labels}"/></td>
		<td width="2%">&nbsp;</td>
		<td  width="40%" height="20" class='label'>&nbsp;<b><%=(rset.getString("curr_file_status")==null)?"&nbsp":rset.getString("curr_file_status")%><%=location_desc%>
		</td>
		<td  width="40%" height="20" class='label'>&nbsp;</td>
		</tr>
<%
		if(count >= 1){
%>
		<tr>
		<td  width="18%" height="20" class='label'>&nbsp;</td>
		<td width="2%">&nbsp;</td>
		<td  width="40%" height="20" class='label'>&nbsp;<fmt:message key="Common.FromNursingUnit.label" bundle="${common_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.room.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Bed.label" bundle="${common_labels}"/>
		</td>
		<td  width="40%" height="20" class='label'>&nbsp;<fmt:message key="Common.FromNursingUnit.label" bundle="${common_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.room.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Bed.label" bundle="${common_labels}"/>
		</td>
		</tr>
		<tr>
		<td  width="18%" height="20"  class='label'><fmt:message key="eFM.InpatientDetails.label" bundle="${fm_labels}"/></td>
		<td width="2%">&nbsp;</td>
		<td  width="40%" height="20" class='label'>&nbsp;<b><%=p_nursing_unit%><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=p_room_num%>&nbsp;<b><%=p_bed_num%></td>
		<td  width="40%" height="20" class='label'>&nbsp;<b><%=p_nursing_unit%><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=p_room_num%>&nbsp;<b><%=p_bed_num%></td>
		</tr>
<%
		}
%>
		<tr><td  colspan="4" height="2" class='label'></td></tr>
		<tr>
		<td  width="18%" height="20" class='label'><fmt:message key="Common.issueddatetime.label" bundle="${common_labels}"/></td>
		<td width="2%">&nbsp;</td>
		<td  width="40%" height="20" class='label'>&nbsp;<b><%=(rset.getString("iss_date_time")==null)?"&nbsp":rset.getString("iss_date_time")%></td>
		<td  width="40%" height="20" class='label'>&nbsp;</td>
		</tr>
		<tr><td  colspan="4" height="2" ></td></tr>
		<tr>
		<td  width="18%" height="20" class='label'><fmt:message key="eFM.ReturnDueDateTime.label" bundle="${fm_labels}"/></td>
		<td width="2%">&nbsp;</td>
		<td  width="40%" height="20" class='label'>&nbsp;<B><%=(rset.getString("return_date_time")==null)?"&nbsp":rset.getString("return_date_time")%></td>
		<td  width="40%" height="20" class='label'>&nbsp;</td>
		</tr>
		<tr><td  colspan="4" height="2" ></td></tr>
		<tr><td  colspan="4" height="2" ></td></tr>
		<tr>
		<td  width="18%" height="20"  class='label'><%=p_owner_locn_yn%></td>
		<td width="2%">&nbsp;</td>
		<td  width="40%" height="20" class='label'>&nbsp;<B><%=(rset.getString("HOLDER_NAME")==null)?"&nbsp":rset.getString("HOLDER_NAME")%></td>
		<td  width="40%" height="20" class='label'>&nbsp;<B><%=(rset.getString("prev_holder_name")==null)?"&nbsp":rset.getString("prev_holder_name")%></td>
		</tr>
		<tr>
		<td  width="18%" height="20" class='label'><%=p_owner_phone_yn%></td>
		<td width="2%">&nbsp;</td>
		<td  width="40%" height="20" class='label'>&nbsp;<b><%=(rset.getString("holder_phone_no")==null)?"&nbsp":rset.getString("holder_phone_no")%></td>
		<td  width="40%" height="20" class='label'>&nbsp;<b><%=(rset.getString("prev_phone_no")==null)?"&nbsp":rset.getString("prev_phone_no")%></td>
		</tr>	
<%
	if (p_req_remarks!=null)
	{
%>		<tr>
		<td  width="18%" height="20" class='label'>&nbsp;</td>
		<td width="2%">&nbsp;</td>
		<td  width="40%" height="20" class='label'>&nbsp;
	   <a href='javascript:GetShowRemarks("ReqComm<%=i%>","<%=p_req_remarks%>","R")'>Requestor Remarks</a></font></td>
		<td  width="40%" height="20" class='label'>&nbsp;</td>
		 </tr>
<%
	}
	String file_status = rset.getString("file_status")==null?"":rset.getString("file_status");
		if(file_status.equals("T") || file_status.equals("R"))
	   {
%>
		<tr>
		<td  width="18%" height="20" class='label'><fmt:message key="eFM.TransportDetail.label" bundle="${fm_labels}"/></td>
		<td width="2%">&nbsp;</td>
		<td  width="40%" height="20" class='label'>&nbsp;<b><%=(rset.getString("transport_desc")==null)?"&nbsp":rset.getString("transport_desc")%><% 
		if(!(rset.getString("carried_by_name")==null)){			%>&nbsp-&nbsp<%=(rset.getString("carried_by_name")==null)?"&nbsp":rset.getString("carried_by_name")%><% } %></td>		
		<td  width="40%" height="20" class='label'></td>
		</tr> 
<%	   }
%>
		<tr><td  colspan="4" height="2" ></td></tr>
<%
			String flag="true"	;
			String p_rec_cnt_flag = "" ;
			sql="SELECT 'X' total_records FROM oa_appt_mr_list_vw WHERE facility_id='" + facility + "' AND  " +				 "patient_id='" + patientid  + "'  AND TRUNC(appt_date)<= SYSDATE+" + appointmentDays ;
			//out.println(sql);
			stmt1			= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                   ResultSet.CONCUR_UPDATABLE);
			rset1		 	= stmt1.executeQuery(sql) ;
			while (rset1.next())
			{
				p_rec_cnt_flag = rset1.getString("total_records");
			}
			if(p_rec_cnt_flag.equals("X"))
			flag = "enabled" ;
			else
			flag = "disabled";
%>		

		<tr><td  colspan="4" height="5" ></td></tr>
<%		}
%>
	</table>
<%
		}
	if(rset!=null)	rset.close();
	if(rset1!=null)	rset1.close();
	if(rs!=null)	rs.close();
	if(stmt!=null)	stmt.close();
	if(stmt1!=null)	stmt1.close();
	if(stmt2!=null)	stmt2.close();
	}catch(Exception e){
	out.println("Exception while fetching connection :" + e ) ;
	}finally{
	ConnectionManager.returnConnection(con, request);
	}
%>
<script>
	//parent.frames[1].document.forms[0].search[1].disabled=false;
</script>
  <input type='hidden' name='criteria' id='criteria' value='<%=queryCriteria%>' >
  <input type='hidden' name='facility' id='facility' value='<%=facility%>' >
  <input type='hidden' name='patientid' id='patientid' value=<%=patientid%> >
  <input type='hidden' name='currStatDesc' id='currStatDesc' value='<%=currStatDesc%>'>
  <input type='hidden' name='currIdDesc' id='currIdDesc' value='<%=currIdDesc%>'>
  <input type='hidden' name='Curr_locn_desc' id='Curr_locn_desc' value='<%=Curr_locn_desc%>'>
  <input type='hidden' name='sappointmentDays' id='sappointmentDays' value='<%=appointmentDays%>'>
  <input type='hidden' name='bookingDays' id='bookingDays' value='<%=bookingDays%>'>
</form>
</body>
</html>

