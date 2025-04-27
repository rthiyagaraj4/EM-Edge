<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import ="java.util.*,java.sql.*, java.text.*,webbeans.eCommon.*" %>
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
	<script language='javascript' src='../../eFM/js/FMTransferFile.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body OnMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<script>parent.transfer_criteria.document.getElementById("hdr_tab1").style.visibility = 'Visible';</script>
<form name='FMTransferFileResult_form' id='FMTransferFileResult_form' method='post' target='messageFrame' action='../../servlet/eFM.FMTransferFileServlet'>
<table id='tb1' border='1' cellpadding='0' cellspacing='0' width='100%' >
<%
		Connection conn = ConnectionManager.getConnection(request);

		String facility_id			= (String) session.getValue("facility_id");
		String FromLocn				= request.getParameter("FromLocn");	
		String ToLocn				= request.getParameter("ToLocn");	
		String ToLocnDesc			= request.getParameter("ToLocnDesc");
		String ToNarration			= request.getParameter("ToNarration");
		String FileNo				= request.getParameter("FileNo");
		String doc_type_code		= request.getParameter("doc_type_code");
		String doc_folder_id		= request.getParameter("doc_folder_id");
		String trans_from			= request.getParameter("trans_from");
		String trans_to				= request.getParameter("trans_to");
		String auto_rec_ward_yn		= request.getParameter("auto_rec_ward_yn");
		String auto_rec_clinic_yn	= request.getParameter("auto_rec_clinic_yn");
		String auto_rec_pract_yn	= request.getParameter("auto_rec_pract_yn");
				
		String sql             = "";
		String classValue      = "";		
		String file_type_code  = "";
		String p_doc_folder_id = "";
		String p_doc_type_code = "";
		StringBuffer moreCriteria	= null;
		moreCriteria					= new StringBuffer();

		int rowid=0;
		int i = 0, p_rec_cnt = 0;

		java.sql.Statement stmt	=	null;
		ResultSet rs			=	null;

		if(auto_rec_ward_yn == null || auto_rec_ward_yn.equals("null")) auto_rec_ward_yn = "";
		if(auto_rec_clinic_yn == null || auto_rec_clinic_yn.equals("null")) auto_rec_clinic_yn = "";
		if(auto_rec_pract_yn == null || auto_rec_pract_yn.equals("null"))  auto_rec_pract_yn = "";

		if(FromLocn == null || FromLocn.equals("null")) 
			FromLocn = "";
		if(ToLocn == null || ToLocn.equals("null")) 
			ToLocn = "";
		if(ToLocnDesc == null || ToLocnDesc.equals("null")) 
			ToLocnDesc = "";
		if(doc_folder_id == null || doc_folder_id.equals("null")) 
			doc_folder_id = "";
		if(doc_type_code == null || doc_type_code.equals("null")) 
			doc_type_code = "";
		if(FileNo == null ||  FileNo.equals("null")) 
			FileNo = "";	
		if(trans_from == null || trans_from.equals("null")) 
			trans_from = "";
		if(trans_to == null || trans_to.equals("null")) 
			trans_to = "";
		if(ToNarration == null || ToNarration.equals("null")) 
			ToNarration = "";
		if(!(doc_folder_id == null || doc_folder_id.equals("")))
			moreCriteria.append(" AND a.doc_folder_id in ("+doc_folder_id+") ");
		if(!(doc_type_code == null || doc_type_code.equals("")))
			moreCriteria.append(" AND a.doc_type_code in ("+doc_type_code+") ");
//		if(!(FileNo == null || FileNo.equals("")))
//			moreCriteria += " AND a.file_no in ("+FileNo+") ";

		try
		{
			sql="SELECT a.patient_id,decode('"+localeName+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) PATIENT_NAME,d.encounter_id,a.file_type_code,a.file_no,a.doc_folder_id,a.doc_folder_name,a.doc_type_code,a.doc_type_name,a.volume_no,(CASE WHEN c.patient_period_specific = 'D' THEN '' || TO_CHAR(c.from_period,'dd/mm/rrrr') || '-' || TO_CHAR(to_period,'dd/mm/rrrr')  ELSE  ', ' || GET_PATIENT_LINE(c.PATIENT_ID,'"+localeName+"') END) docline, DECODE (b.locn_identity,'D', 'Department','C', 'Clinic','N', 'Nursing Unit', 'T', 'Practitioner','X', 'External','E','Procedure Unit','Y','Daycare Unit') locn_iden FROM fm_curr_locn_vw a, fm_storage_locn b,fm_doc_folder c, FM_ENCOUNTER_DOC_TYPE_LINK d WHERE curr_facility_id = '"+facility_id+"' AND a.facility_id = c.facility_id AND a.facility_id = D.facility_id AND a.file_no = d.file_no AND a.doc_folder_id = c.doc_folder_id AND curr_fs_locn_code = '"+FromLocn+"' AND curr_file_status = 'O' "+moreCriteria+" AND a.curr_locn_id = '"+trans_from+"' AND a.curr_facility_id = b.facility_id AND b.fs_locn_code = '"+ToLocn+"' ORDER BY a.doc_folder_id";
		
			stmt =conn.createStatement();
			rs = stmt.executeQuery(sql);

			if(rs != null)
			{
				while(rs.next())
				{
					classValue	=	( (i%2)==0 )? "QRYEVEN" : "QRYODD";
					rowid++;
					String docline			= rs.getString("docline");
					String doc_folder_name	= rs.getString("doc_folder_name");
					String doc_type_name	= rs.getString("doc_type_name");
					p_doc_folder_id			= rs.getString("doc_folder_id");
					p_doc_type_code			= rs.getString("doc_type_code");
					file_type_code			= rs.getString("file_type_code");
					String patientid		= rs.getString("PATIENT_ID");
					String patientname		= rs.getString("PATIENT_NAME");
					String encounterid		= rs.getString("ENCOUNTER_ID");

					if(docline == null || docline.equals("null"))
						docline = "&nbsp;";
					if(doc_type_name == null || doc_type_name.equals("null"))
						doc_type_name = "&nbsp;";
					if(doc_folder_name == null || doc_folder_name.equals("null"))
						doc_folder_name = "&nbsp;";
					if(p_doc_folder_id == null || p_doc_folder_id.equals("null"))
						p_doc_folder_id = "";
					if(p_doc_type_code == null || p_doc_type_code.equals("null"))
						p_doc_type_code = "";
					if(file_type_code == null || file_type_code.equals("null"))
						file_type_code = "";

					out.println("<tr><td class='"+classValue+"' width='30%'><font size='1'><B>");
					out.println(p_doc_folder_id+"</B><BR>&nbsp;&nbsp;"+doc_folder_name+"&nbsp;&nbsp;"+docline);
					out.println("</font></td><td class='"+classValue+"' width='15%'><font size='1'><CENTER>");
					out.println(doc_type_name+"</CENTER>");
					out.println("</font></td>");
					//ragha
					%>
					<td  class='<%=classValue%>' width='10%'>
					<A HREF onMouseover="changeCursor(this)" onClick="callPatDetails('<%=patientid%>')"><font size=1><%=patientid%></A><br><%=patientname%></font></td>

					<td  CLASS='<%=classValue%>' width='12%'>
					<A HREF onMouseover="changeCursor(this)" onClick="showEncounter('<%=encounterid%>','<%=patientid%>','<%=rs.getString("file_no")%>')"><font size=1><%=encounterid%></font></A></td>

					<%
					out.println("<td class='"+classValue+"' align=center width='23%'><font size='1'>");
					out.println(ToLocnDesc+"<br>&nbsp;&nbsp;&nbsp;("+rs.getString("LOCN_IDEN")+")");
					out.println("</font></td><td align='center' class='"+classValue+"' width='10%'><font size='1'>");
					out.println("<input type='checkbox' name='confirm"+rowid+"' id='confirm"+rowid+"' checked>");
					out.println("</font></td></tr>");
					out.println("<input type='hidden' name='docfolder"+rowid+"' id='docfolder"+rowid+"' value='"+p_doc_folder_id+"'>");
					out.println("<input type='hidden' name='doctype"+rowid+"' id='doctype"+rowid+"' value='"+p_doc_type_code+"'>"); 
					out.println("<input type='hidden' name='file"+rowid+"' id='file"+rowid+"' value='"+rs.getString("file_no")+"'>");
					out.println("<input type='hidden' name='filetype"+rowid+"' id='filetype"+rowid+"' value='"+file_type_code+"'>"); 
					out.println("<input type='hidden' name='volume"+rowid+"' id='volume"+rowid+"' value='"+rs.getString("volume_no")+"'>"); 
					out.println("<input type='hidden' name='tolocns"+rowid+"' id='tolocns"+rowid+"' value='"+ToLocn+"'>");
					out.println("<input type='hidden' name='tonarration"+rowid+"' id='tonarration"+rowid+"' value='"+ToNarration+"'>");
					out.println("<input type='hidden' name='trans_to"+rowid+"' id='trans_to"+rowid+"' value='"+trans_to+"'>");
					
					i++;
					p_rec_cnt++;
				}
			}
%>
			<script>
				parent.frames[2].document.forms[0].tofslocn.disabled=false;				
				parent.frames[2].document.forms[0].narration.disabled=false;
				parent.frames[2].document.forms[0].FS_LOCN_ID.disabled=false;			
								
				var p_rec_cnt = '<%=p_rec_cnt%>';
				if (p_rec_cnt==0)	
				{
					alert(getMessage('NO_DOC_FOR_TRANSFER','FM'));
					parent.frames[4].document.location.href='../../eCommon/html/blank.html';
					parent.frames[2].document.forms[0].tofslocn.disabled=false;
					parent.frames[2].document.forms[0].narration.disabled=false;
					parent.frames[2].document.forms[0].FS_LOCN_ID.disabled=false;			
				}
			</script>
<%
		if(rs!=null)	rs.close();
		if(stmt!=null) stmt.close();
		}
		catch(Exception e)
		{
			out.println("Exception :"+e.toString());
		}
		finally
		{			
			ConnectionManager.returnConnection(conn,request);
		}
%>
	</table>
<script>
	for (i=0;i<4;i++)
	{
		if ((document.getElementById("tb1").rows(i+1) != null) && (document.getElementById("tb1").rows(i+1).cells(i) != null))
		{
			parent.transfer_criteria.document.getElementById("hdr_tab1").rows(0).cells(i).width = document.getElementById("tb1").rows(i+1).cells(i).width; 
		}
	}
</script>
	<input type='hidden' name='count' id='count' value='<%=rowid%>'>
	<input type='hidden' name='FileList' id='FileList' value=''>
	<input type='hidden' name='DocFolderList' id='DocFolderList' value=''>
	<input type='hidden' name='DocTypeList' id='DocTypeList' value=''>
	<input type='hidden' name='FileTypeList' id='FileTypeList' value=''>
	<input type='hidden' name='VolumeList' id='VolumeList' value=''>
	<input type='hidden' name='FromLocnCode' id='FromLocnCode' value=''>
	<input type='hidden' name='TransferUserId' id='TransferUserId' value=''>
	<input type='hidden' name='iss_remarks' id='iss_remarks' value=''>
	<input type='hidden' name='resultPage_carried_by_name' id='resultPage_carried_by_name' value=''>
	<input type='hidden' name='resultPage_file_trans_mode' id='resultPage_file_trans_mode' value=''>
	<input type='hidden' name='auto_rec_ward_yn' id='auto_rec_ward_yn' value='<%=auto_rec_ward_yn%>'>
	<input type='hidden' name='auto_rec_clinic_yn' id='auto_rec_clinic_yn' value='<%=auto_rec_clinic_yn%>'>
	<input type='hidden' name='auto_rec_pract_yn' id='auto_rec_pract_yn' value='<%=auto_rec_pract_yn%>'>
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

