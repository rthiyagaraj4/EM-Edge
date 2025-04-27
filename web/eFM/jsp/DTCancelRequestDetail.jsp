<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMCancelRequestFiles.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
		Connection conn			= ConnectionManager.getConnection(request);
		 
		Statement stmt			= null;
		ResultSet rs			= null;
		
		String facility_id			= (String) session.getValue("facility_id");	
		String FSLocation			= request.getParameter("FSLocation");
		String file_num				= request.getParameter("fileno");
		String patient_id			= request.getParameter("patient_id");
		String doc_folder_id		= request.getParameter("doc_folder_id");
		String doc_type_code		= request.getParameter("doc_type_code");
		String request_date			= request.getParameter("ReqDate");
		String sql				= "";
		String classValue		= "";
		String moreCriteria		= "";
		
		int i = 1, p_rec_cnt = 0;
				
		if(FSLocation == null || FSLocation.equals("null"))
			FSLocation = "";
		if(patient_id == null || patient_id.equals("null"))
			patient_id = "";
		if(doc_folder_id == null || doc_folder_id.equals("null"))
			doc_folder_id = "";
		if(doc_type_code == null || doc_type_code.equals("null"))
			doc_type_code = "";
		if(request_date == null || request_date.equals("null"))
			request_date = "";
		if(file_num == null || file_num.equals("null")) 
			file_num = "";

		if(!(doc_folder_id == null || doc_folder_id.equals("")))
			moreCriteria =moreCriteria + " AND a.doc_folder_id in ("+doc_folder_id+") ";

		if(!(doc_type_code == null || doc_type_code.equals("")))
			moreCriteria = moreCriteria + " AND a.doc_type_code = '"+doc_type_code+"' ";
//		if(!(file_num == null || file_num.equals("")))
//			moreCriteria += " AND a.file_no in ("+file_num+") ";
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
<form name='CancelRequestDtl_form' id='CancelRequestDtl_form' action='../../servlet/eFM.FMCancelRequestServlet' method='post' target='messageFrame'>
<script>
	parent.frames[2].document.getElementById("hdr_tab0").style.visibility = 'Visible';
	parent.frames[2].document.getElementById("hdr_tab1").style.visibility = 'Visible';
</script>
<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center' id="test">
<%
		sql ="SELECT   a.req_no, a.remarks, a.file_no,a.PATIENT_ID, a.file_type_code, a.doc_type_code, d.doc_type_name, a.doc_folder_id, f.ENCOUNTER_ID, e.doc_folder_name,a.volume_no,(CASE WHEN e.patient_period_specific = 'D'  THEN ' ' || TO_CHAR (e.from_period, 'dd/mm/rrrr ') || ' - ' || TO_CHAR (e.to_period, 'dd/mm/rrrr ') ELSE  ', ' || GET_PATIENT_LINE(e.PATIENT_ID,'"+localeName+"') END) docline, TO_CHAR (a.added_date, 'DD/MM/RRRR HH24:MI') added_date, a.cancel_yn, a.req_to_facility_id, a.req_to_fs_locn_code, c.short_desc req_to_fs_locn_desc FROM fm_req_dtl a,fm_req_hdr b,fm_storage_locn c,fm_doc_type d,fm_doc_folder e,FM_ENCOUNTER_DOC_TYPE_LINK f WHERE a.req_to_facility_id = e.facility_id AND a.doc_folder_id = e.doc_folder_id AND  a.doc_type_code = d.doc_type_code(+) AND a.req_no = b.req_no AND B.REQ_FS_LOCN_CODE =  '"+FSLocation+"' AND b.req_facility_id = '"+facility_id+"' AND a.iss_yn = 'N'  AND TRUNC (a.added_date) =NVL ('"+request_date+"',(TRUNC (a.added_date))) AND a.cancel_yn = 'N' AND a.req_to_facility_id = c.facility_id and a.req_to_facility_id = f.facility_id and a.file_no = f.file_no AND a.req_to_fs_locn_code = c.fs_locn_code AND NVL (a.cancel_yn, 'N') = 'N' "+moreCriteria+" ORDER BY 7 ";
		
		try 
		{
			stmt =conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs != null)
			{
				while(rs.next())
				{
					if ( i % 2 == 0 )
						classValue = "QRYODD" ;
					else
						classValue = "QRYEVEN" ;
					String docline			= rs.getString("docline");
					String fileno			= rs.getString("file_no");
					String doctypecode		= rs.getString("doc_type_code");
					String doctypename		= rs.getString("doc_type_name");
					String docfolderid		= rs.getString("doc_folder_id");
					String docfoldername	= rs.getString("doc_folder_name");
					String filetypecode		= rs.getString("file_type_code");
					String volumeno			= rs.getString("volume_no");
					String reqno			= rs.getString("req_no");
					String requestDate		= rs.getString("added_date");	
					String senderlocndesc	= rs.getString("req_to_fs_locn_desc");		
					String PATIENTID		= rs.getString("PATIENT_ID");				
					String ENCOUNTER_ID		= rs.getString("ENCOUNTER_ID");				
					String issuedate		= "";
					String p_req_remarks	= rs.getString("remarks");
					
					if(reqno == null || reqno.equals("null"))
						reqno="";
					if(docline == null || docline.equals("null"))
						docline="&nbsp";
					if(fileno == null || fileno.equals("null"))
						fileno="";
					if(doctypecode == null || doctypecode.equals("null"))
						doctypecode="";
					if(doctypename == null || doctypename.equals("null"))
						doctypename="&nbsp;";
					if(docfolderid == null || docfolderid.equals("null"))
						docfolderid="";
					if(docfoldername == null || docfoldername.equals("null"))
						docfoldername="";
					if(requestDate == null || requestDate.equals("null"))
						requestDate="";
					if(filetypecode == null || filetypecode.equals("null"))
						filetypecode="";
					if(volumeno == null || volumeno.equals("null"))
						volumeno="";
					if(p_req_remarks == null || p_req_remarks.equals("null"))
						p_req_remarks="";
					if(p_req_remarks == null || p_req_remarks.equals("null"))
						p_req_remarks="";
					if(issuedate == null || issuedate.equals("null"))
						issuedate = "&nbsp;";
					if(senderlocndesc == null || senderlocndesc.equals("null"))
						senderlocndesc = "&nbsp;";
				
					out.println("<tr><td  class='"+classValue+"' width='25%'>");
					out.println("<font size=1><B>"+docfolderid+"</B><BR>&nbsp;&nbsp;"+docfoldername+"&nbsp;&nbsp;"+docline+"</font></td>");
					out.println("<td  class='"+classValue+"' width='11%'><font size=1><CENTER>");
					out.println(doctypename+"</CENTER></font></td>");
				//ragha	
					%>

					<td  class='<%=classValue%>' width='10%'>
					<A HREF onMouseover="changeCursor(this)" onClick="callPatDetails('<%=PATIENTID%>')"><font size=1><%=PATIENTID%></font></A> </font></td>

					<td  CLASS='<%=classValue%>' width='10%'>
					<A HREF onMouseover="changeCursor(this)" onClick="showEncounter('<%=ENCOUNTER_ID%>','<%=PATIENTID%>','<%=fileno%>')"><font size=1><%=ENCOUNTER_ID%></font></A></td>
					
					<%
					out.println("<td  class='"+classValue+"' width='13%'>");
					out.println("<font size=1>"+requestDate+"</font></td>");
					out.println("<td  class='"+classValue+"'width='12%'>");
					if(senderlocndesc == null || senderlocndesc.equals("null"))
						out.println("&nbsp;</td>");
					else
						out.println("<font size=1>"+senderlocndesc+" </font></td>");
					out.println("<td  align='center' class='"+classValue+"' width='9%'>");
%>
					<input type='checkbox' name='cancelbox<%=i%>' id='cancelbox<%=i%>' value='Y' onClick='cancelSelection(this);'></td>
<%
					out.println("<td id='td1"+i+"'  class='"+classValue+"' width='10%'><font size=1>");
%>
				   <a href='javascript:GetRemarks(<%= i %>)'>&nbsp;</a></font></td>
<%
					out.println("<td id='td2"+i+"' style='display:none'  class='"+classValue+"' width='10%'><font size=1> ");
%>
				    <a href='javascript:GetRemarks(<%= i %>)'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></font></td></tr>
				    <input type="hidden" name="rem_recnum_<%=i%>" id="rem_recnum_<%=i%>" value="">
				    <input type="hidden" name="p_req_remarks<%=i%>" id="p_req_remarks<%=i%>" value="<%=p_req_remarks.trim()%>">
<%
					out.println("<input type='hidden' name='file"+i+"' id='file"+i+"' value='"+fileno+"'>");
					out.println("<input type='hidden' name='docfolder"+i+"' id='docfolder"+i+"' value='"+docfolderid+"'>");
					out.println("<input type='hidden' name='doctypecode"+i+"' id='doctypecode"+i+"' value='"+doctypecode+"'>");
					out.println("<input type='hidden' name='filetype"+i+"' id='filetype"+i+"' value='"+filetypecode+"'>");
					out.println("<input type='hidden' name='volume"+i+"' id='volume"+i+"' value='"+volumeno+"'>");
					out.println("<input type='hidden' name='req_no"+i+"' id='req_no"+i+"' value='"+reqno+"'>");

					i++;
					p_rec_cnt++;
				}

			}
%>
			<script>
				var p_rec_cnt = '<%=p_rec_cnt %>'

				if (p_rec_cnt==0)
				{
					alert(getMessage('NO_DOC_AVA_CANCEL','FM'));
					parent.frames[3].location.href='../../eCommon/html/blank.html';
					
				}
				for (i=0;i<6;i++)
				{
					if ((document.getElementById("test").rows[i+1] != null) && (document.getElementById("test").rows[i+1].cells[i] != null))
					{
						parent.cancel_criteria.document.getElementById("hdr_tab1").rows[0].cells[i].width = document.getElementById("test").rows[i+1].cells[i].width; 
					}
				}

			</script>
<%
	if(rs!=null)	rs.close();
	if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		out.println(e.toString());
	}
	finally
	{		
		ConnectionManager.returnConnection(conn,request);
	}
%>
	</table>
<input type='hidden' name='reccount' id='reccount' value='<%=i%>'>
<input type='hidden' name='filenos' id='filenos' value=''>
<input type='hidden' name='docfoldernos' id='docfoldernos' value=''>
<input type='hidden' name='doctypenos' id='doctypenos' value=''>
<input type='hidden' name='volumenos' id='volumenos' value=''>
<input type='hidden' name='req' id='req' value=''>
<input type='hidden' name='remarks' id='remarks' value=''>
<input type='hidden' name='can_locn_code' id='can_locn_code' value=''>
</form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

