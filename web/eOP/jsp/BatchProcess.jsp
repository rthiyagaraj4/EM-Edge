<!DOCTYPE html>

<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='/eCIS/common/html/IeStyle.css'></link> -->
<%
request.setCharacterEncoding("UTF-8");

request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript'>




</script>
<script src="../../eOP/js/BatchProcess.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String url 	= "../../eCommon/jsp/commonToolbar.jsp?" ;
	
	String params	= request.getQueryString() ;
	String module_id = request.getParameter("module_id");

	String source   = url+params ;

	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	
	try{

	int operator_station_access=0;
	con = ConnectionManager.getConnection(request);
	pstmt=con.prepareStatement("select count(*) as total from op_param");
	rset=pstmt.executeQuery();

	if(rset != null)
	{
		if(rset.next())
		{
			operator_station_access=rset.getInt(1);
		}
	}
	
	if(operator_station_access == 0)
	{
		%>
		<script>
		alert(getMessage('OP_PARAM_NOT_FOUND','OP'));
		</script>
		<%
		out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");%>
		<%
	}

	if(rset != null) rset.close();
	if(pstmt != null) pstmt.close();

%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling=no noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod'    src='../../eOP/jsp/BatchProcessList.jsp?module_id=<%=module_id%>' frameborder='0' scrolling='no' noresize style='height:84vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>
</head>

<%
   }catch(Exception e)
	   {
		 e.printStackTrace();
	   }
	   finally
	   {
			if(con != null) ConnectionManager.returnConnection(con,request);
	   }
%>

</html>

