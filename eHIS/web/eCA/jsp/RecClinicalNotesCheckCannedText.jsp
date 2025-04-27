<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html><head>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript'>

<%
	Connection			con		=	null;
	PreparedStatement	pstmt	=	null;
	ResultSet			rs		=	null;

	String	query_canned_text	=	"",		service_code	=	"";
	String	login_user_id		=	"",		note_type		=	"";
	String	sec_hdg_code		=	"";

	boolean	enable_cannedtext	=	false;

	try
	{
		con				=	ConnectionManager.getConnection(request);
		login_user_id	=	(String) session.getValue("login_user");
		service_code	=	(request.getParameter("service_code")==null) ?	""	:	request.getParameter("service_code");
		note_type		=	(request.getParameter("note_type")==null)	 ?	""	:	request.getParameter("note_type");
		sec_hdg_code	=	(request.getParameter("sec_hdg_code")==null) ?	""	:	request.getParameter("sec_hdg_code");

		//out.println("Query String : "+request.getQueryString());

		if(service_code==null)		service_code	= "";

		//query_canned_text = "Select text_blk_id, text_blk from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and nvl(note_type, ?) = ? and nvl(sec_hdg_code, nvl(?,'***') ) = nvl(?,'***') ";
		query_canned_text = "Select text_blk_id, CA_GET_DESC.CA_TEXT_BLK_BY_SERV_PRACT(text_blk_id,?,'1') text_blk 	from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and nvl(note_type, ?) = ? and nvl(sec_hdg_code, nvl(?,'***') ) = nvl(?,'***')";
		/*
		out.println("<br>service_code	: "+service_code);
		out.println("<br>login_user_id	: "+login_user_id);
		out.println("<br>note_type		: "+note_type);
		out.println("<br>sec_hdg_code	: "+sec_hdg_code);
		out.println("<br>query_canned_text	: "+query_canned_text);
		*/
		
		pstmt		=	con.prepareStatement(query_canned_text);

		pstmt.setString(1,locale);
		pstmt.setString(2,service_code);
		pstmt.setString(3,service_code);
		pstmt.setString(4,login_user_id);
		pstmt.setString(5,login_user_id);
		pstmt.setString(6,note_type);
		pstmt.setString(7,note_type);
		pstmt.setString(8,sec_hdg_code);
		pstmt.setString(9,sec_hdg_code);
		
		rs			=	pstmt.executeQuery();

		if(rs.next())
		{
			enable_cannedtext = true;
		} // end of if(rs.next())
		else
		{
			enable_cannedtext = false;
		} // end of else if(rs.next())
	%>
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.enable_cannedtext.value = '<%=enable_cannedtext%>';
		var url = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.location.href;
//		alert(url);
		if(url.indexOf('/eCA/jsp/RTEditor.jsp')!=-1 || url.indexOf('/eCA/jsp/RecClinicalNotesEditorsFrame.jsp')!=-1)
		{
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.canned_text.disabled = <%=(!(enable_cannedtext))%>;
		}
	<%	
	
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		//out.println("Exception@1:"+e);//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
%>
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>
</head><body class='message' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'></body></html>
<%
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>

