<%
/*
This Jsp is used for Mp-Parameter Setup.(Called from mp_param.jsp)
@author - Gomathi. 
@version - V3
*/
%>
<%@ page import="java.sql.*, webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/mp_param.js"></script>
<%
	request.setCharacterEncoding("UTF-8");
    String toolBarUrl   = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
    String toolBarParams    = request.getQueryString() ;
    String toolBarSource    = toolBarUrl + toolBarParams ;
    String formUrl			= "mp_param_form.jsp?" ;
    String formParams       = "" ;
    String formSource       = "" ;

	Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs        = null;

	try{
			con = ConnectionManager.getConnection(request);
			pstmt   = con.prepareStatement( "select 1 from MP_PARAM" ) ;
			rs      = pstmt.executeQuery() ;

			if ( rs != null && rs.next() )
				formParams = "operation=modify" ;
			else
				formParams = "operation=insert" ;

	}catch(Exception e) { 
		//out.println(e.toString());
		e.printStackTrace(); // Added by lakshmanan for security issue ID 174160823 on 24-08-2023
		}
	finally
	{
    if (pstmt != null) pstmt.close();
    if (rs != null) rs.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
	}
    formSource = formUrl + formParams ;

	//	out.println("<script>alert(\"toolBarSource"+toolBarSource+"\");</script>");	
		//out.println("<script>alert(\"formSource"+formSource+"\");</script>");	
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'    src='<%= toolBarSource %>' frameborder=0 scrolling='auto' noresize style='height:8vh;width:100vw'></iframe>
    <iframe name='f_query_add_mod' id='f_query_add_mod'   src='<%= formSource %>' frameborder=0 noresize scrolling='auto' style='height:85vh;width:100vw'></iframe>
    <iframe name='messageFrame' id='messageFrame'      src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
    <iframe name='dummy' id='dummy'  frameborder=0 noresize scrolling='auto' style='height:0vh;width:100vw'></iframe>

