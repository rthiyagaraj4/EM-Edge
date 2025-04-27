<!DOCTYPE html>

<%--
	FileName	: DiscretePanel.jsp
	Version	    : 3	
	Created On	: 5-5-2005
	Created By	: Jupitora 
--%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eAM/js/DiscrMeasure.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

</head>
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
		//String facility_id = (String)session.getValue( "facility_id" );
		String install_yn_ca="";
		Connection con = null;
		Statement stmt=null;
		ResultSet rset=null ;
	

try
	{

	con =ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		
		rset = stmt.executeQuery("select install_yn from sm_module where module_id='CA'");
		if(rset!= null && rset.next())
		{
			install_yn_ca = rset.getString("install_yn");
			if(install_yn_ca !=null) install_yn_ca="";
			if(install_yn_ca.equals("N") )
			{	
				%>
				<script>alert(getMessage("CA_NOT_INSTALLED","Common"));history.go(-1);
				</script>
		<%	}
			else
			{	%>
<html>
<head>
<title><fmt:message key="eAM.DiscretePanel.label" bundle="${am_labels}"/></title>


		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language='javascript' src='../../eAM/js/DiscretePanel.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<frameset id='discrete' rows='14%,34%,*,8%'>
	<frame name='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize>
	<frame name='f_query_add_mod' 	src='../../eAM/jsp/DiscretePanelAddModify.jsp?mode=insert' frameborder=no scrolling='no'>

	<frameset cols="50%,50%" border="0" framespacing=2>
	<frame name="paneldetails" src = "../../eCommon/html/blank.html "
	 marginheight='0' marginwidth='0' scrolling=auto  BORDERCOLOR='green' frameborder=no noresize>
	<frame name="paneladd" src = "../../eCommon/html/blank.html" marginheight='0' marginwidth='0'  frameborder=no  scrolling=no noresize >
</frameset> 
<frame name='messageFrame'		src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'>
</frameset>
</html>
	<%
			}
		}else
		{
		%>
				<script>alert(getMessage("CA_NOT_INSTALLED","Common"));history.go(-1);
				</script>
	
	<%
		}
	}catch(Exception e)
	{
//		out.print("Exception "+e);
		e.printStackTrace();
	}
	finally
	{
		try{
		if(stmt != null) stmt.close();
		if(rset != null) rset.close();
		}catch(Exception e){}
		 if( con != null) ConnectionManager.returnConnection(con,request);
	}
%>

