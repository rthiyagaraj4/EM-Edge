<!DOCTYPE html>
<%@page import="java.sql.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<head>
	<title>RecClinicalNotesLinkDocs.jsp</title>
	
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<%
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;

	String		result_linked_rec_type	=	"",		hist_rect_type			=	"";	
	String		event_date					=	"",		query_doc_details	=	"";
	String		result_str					=	"",		event_short_desc		=	"";

	String		encounter_id					=	"",		whereClause			=	"";
	String		classValue					=	"",		selectBlockId			=	"";
	String		resp_id = (String)session.getValue("responsibility_id");

	if(resp_id == null)resp_id ="";
	int selectIndex = 0;

%>
	<center>
	<form name='RecClinicalNotesLinkDocsForm' id='RecClinicalNotesLinkDocsForm'>
		<table border='1' cellpadding='3' cellspacing='0' width='100%' height='100%' align='center'>
		<td class='columnheader'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
		<td class='columnheader'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td class='columnheader'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
	<%
		try
		{
			con				=	ConnectionManager.getConnection(request);


			result_linked_rec_type	=	request.getParameter("result_linked_rec_type");			
			encounter_id				=	request.getParameter("encounter_id");
			

			//out.println("Query String : "+request.getQueryString());

			if(result_linked_rec_type==null)		result_linked_rec_type	= "";



			//query_doc_details = "Select a.hist_rec_type, a.contr_sys_id, a.accession_num, contr_sys_event_code, b.long_desc event_short_desc, to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date, a.hist_data_type, a.result_num, a.result_num_uom, result_str from cr_encounter_detail a, cr_clin_event_mast b where a.hist_rec_type = ? and a.encounter_id = ? "+whereClause+" and b.hist_rec_type = a.hist_rec_type and a.event_code = b.event_code  and (nvl(PROTECTION_IND,'N')!='Z' OR						(nvl(PROTECTION_IND,'N')='Z'  and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'"+resp_id+"',NULL)='A')) ";
			query_doc_details = "Select	 a.hist_rec_type, a.contr_sys_id, a.accession_num, contr_sys_event_code, b.long_desc event_short_desc, to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date, a.hist_data_type, a.result_num, a.result_num_uom, result_str from cr_encounter_detail a, CR_CLN_EVT_MST_LANG_VW b where a.hist_rec_type = ? and a.encounter_id = ? "+whereClause+" and b.language_id = ?  and b.hist_rec_type = a.hist_rec_type and a.event_code = b.event_code  and (nvl(PROTECTION_IND,'N')!='Z' OR	(nvl(PROTECTION_IND,'N')='Z'  and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'"+resp_id+"',NULL)='A')) ";
			//out.println("<br>result_linked_rec_type	: "+result_linked_rec_type);
			//out.println("<br>query_doc_details	: "+query_doc_details);

			pstmt		=	con.prepareStatement(query_doc_details);

			pstmt.setString(1,result_linked_rec_type);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,locale);


			rs			=	pstmt.executeQuery();

			while(rs.next())
			{
				hist_rect_type			=	rs.getString("hist_rec_type");				
				event_short_desc		=	rs.getString("event_short_desc");
				event_date				=	rs.getString("event_date");				
				result_str				=	rs.getString("result_str");
				if(result_str==null)	result_str	=	"&nbsp;";

				selectBlockId		=	"block_id"	  + selectIndex ;

				if( (selectIndex%2)==0 )
					classValue = "QRYEVEN";
				else
					classValue = "QRYODD";

				selectIndex ++ ;
	%>
				<tr>
					<td class='<%=classValue%>' ><%=event_date%></td>
					<td class='<%=classValue%>' ><%=event_short_desc%></td>
					<td class='<%=classValue%>' ><input type='checkbox' name='<%=selectBlockId%>' id='<%=selectBlockId%>' value='Y'>
					</td>
				</tr>
	<%
			}

		
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		catch(Exception e)
		{
			//out.println("Exception@1: "+e);//common-icn-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}
	%>
		</table>
		<input type='hidden' name='hist_rect_type' id='hist_rect_type' value='<%=hist_rect_type%>'>
	</form>
	</center>
</body>
</html>

