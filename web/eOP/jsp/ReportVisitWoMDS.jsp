<!DOCTYPE html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,javax.servlet.jsp.JspWriter,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<script src="../../eOP/js/repMDSEx.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>


<%
	Connection conn=null;
	PreparedStatement pstmt   =null;
	ResultSet rs=null;

	conn=ConnectionManager.getConnection (request);
	request.setCharacterEncoding("UTF-8");

	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String cainstall="N";
          
			try
			{
			pstmt=conn.prepareStatement("select install_yn from sm_module where module_id='CA'");
			rs=pstmt.executeQuery();
    		if(rs!=null && rs.next())
			{			
				cainstall=rs.getString("install_yn");           
			
            
			}
			}catch(Exception e)
			{
			}finally
				{
					if ( pstmt != null ) pstmt.close() ;
					if ( rs != null ) rs.close() ;
					if(conn!=null) ConnectionManager.returnConnection(conn,request);
				}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();	

	if(cainstall.equals("Y"))
	{

%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 		src='../../eOP/jsp/repMDSExForm.jsp' frameborder=0 style='height:80vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
<%}else{%>

<script>		
			alert(getMessage("CA_NOT_INSTALLED","COMMON"));
            document.location.href ='../../eCommon/jsp/dmenu.jsp'
		</script>
<%}%>

