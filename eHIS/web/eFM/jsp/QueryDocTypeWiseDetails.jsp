<!DOCTYPE html>
<!-- by Meghanath -->
<%@ page import=" java.sql.*,java.text.*,java.util.*,webbeans.eCommon.* " contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
	<HEAD>
		<!-- <LINK rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></LINK> -->
		<%
		request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<SCRIPT language='javascript' src='../../eFM/js/QueryDocTypeWise.js'></SCRIPT>
		<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<BODY onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
		<SCRIPT>parent.QueryDocTypeCriteria.document.getElementById("tab1").style.visibility = "visible";</SCRIPT>
		<TABLE border='1' cellpadding='0' cellspacing='0' width='100%' align='center' id='tab2'>
<%
		String facility_id	 = (String) session.getValue("facility_id");

		Connection conn		 = null;
		Statement stmt		 = null;
		ResultSet rst		 = null;

		conn = ConnectionManager.getConnection(request);
		
		String doc_type_code = "";
		String mysql		 = "";
		String classValue    = "";
		String fromPeriod    = "";
		String toPeriod      = "";

		int i			= 0;
		int recordCount = 0;

		doc_type_code = request.getParameter("doc_type_code");
		if(doc_type_code == null || doc_type_code.equals("null"))
			doc_type_code = "";

		mysql = " SELECT a.doc_folder_id,c.doc_folder_name,TO_CHAR(c.from_period, 'dd/mm/rrrr') from_period,TO_CHAR(c.to_period, 'dd/mm/rrrr') to_period,c.patient_id,b.curr_fs_locn_desc, DECODE(b.curr_file_status,'A','Archive','E','External','I','Inside','L','Lost','O','Outside','R','Returned','T','Transit') curr_file_status FROM fm_encounter_doc_type_link a,fm_curr_locn_vw b,fm_doc_folder c WHERE a.facility_id = c.facility_id AND a.doc_folder_id = c.doc_folder_id AND a.facility_id=b.facility_id AND a.doc_folder_id = b.doc_folder_id AND a.file_no = b.file_no AND a.doc_type_code='"+doc_type_code+"' AND a.facility_id='"+facility_id+"' ORDER BY c.doc_folder_name";
	
		try
		{
			stmt = conn.createStatement();
			rst	 = stmt.executeQuery(mysql);
			
			while(rst != null && rst.next())
			{
				fromPeriod  = rst.getString("from_period");
				toPeriod	= rst.getString("to_period");

				if(fromPeriod == null || fromPeriod.equals("null"))
					fromPeriod = "&nbsp;";
				if(toPeriod == null || toPeriod.equals("null"))
					toPeriod = "&nbsp;";

				classValue =   ((i%2) == 0) ? "QRYEVEN" : "QRYODD";
				
				out.println("<TR><TD class='"+classValue+"' width='20%'><FONT size='1'>");
				out.println(((rst.getString("doc_folder_name")== null) || (rst.getString("doc_folder_name").equals("null"))) ? "" : rst.getString("doc_folder_name")+"</FONT></TD>");

				out.println("<TD class='"+classValue+"' width='25%'><FONT size='1'><CENTER>");
				out.println(fromPeriod+"&nbsp;-&nbsp;"+toPeriod+"</CENTER></FONT></TD>");

				out.println("<TD class='"+classValue+"' width='20%'><FONT size='1'>");
				out.println(((rst.getString("patient_id")== null) || (rst.getString("patient_id").equals("null"))) ? "&nbsp;" : rst.getString("patient_id")+"</FONT></TD>");

				out.println("<TD class='"+classValue+"' width='25%'><FONT size='1'>");
				out.println(((rst.getString("curr_fs_locn_desc")== null) || (rst.getString("curr_fs_locn_desc").equals("null"))) ? "" : rst.getString("curr_fs_locn_desc")+"</FONT></TD>");

				out.println("<TD class='"+classValue+"' width='10%'><FONT size='1'>");
				out.println(((rst.getString("curr_file_status")== null) || (rst.getString("curr_file_status").equals("null"))) ? "" : rst.getString("curr_file_status")+"</FONT></TD></TR>");

				i++;
				recordCount++;
			}
%>
		<SCRIPT>
			var recCount = '<%=recordCount%>';
			if(recCount == 0)
			{
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
				parent.QueryDocTypeResult.document.location.href='../../eCommon/html/blank.html';
			}
			else if(recCount != 0)
			{
				for(i=0;i<5;i++)
				{
					if((document.getElementById("tab2").rows[i+1] != null) && (document.getElementById("tab2").rows[i+1].cells[i] != null))
					{
						parent.QueryDocTypeCriteria.document.getElementById("tab1").rows[0].cells[i].width = document.getElementById("tab2").rows[i+1].cells[i].width;
					}
				}
			}
			parent.QueryDocTypeCriteria.document.forms[0].Search.disabled = "true";
	</SCRIPT>
<%
		if(rst  != null) rst.close();
		if(stmt != null) stmt.close();
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
	</TABLE>
	</BODY>
</HTML>

