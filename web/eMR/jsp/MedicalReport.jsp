<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.sql.*,java.text.*,java.net.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script>
		function reset()
		{
			tabsFrame.location.reload();
		}
	</script>
</head>
<%
	Connection con	= null;
	Statement stmt	= null;
	ResultSet rs	= null;
	String ca_install_yn = "N";

try
{
	con = ConnectionManager.getConnection(request);
	stmt	= con.createStatement();
	rs		= stmt.executeQuery("SELECT install_yn from SM_MODULE WHERE module_id = 'CA'");	

	if ((rs != null) && (rs.next()))
		ca_install_yn = checkForNull(rs.getString("install_yn"),"N");
	if(rs	 != null)   rs.close();
	if(stmt !=null) stmt.close();
}catch(Exception exp)
{
	//out.println("Exception in CA Install.jsp : "+exp.toString());
	exp.printStackTrace();
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

if(ca_install_yn.equals("Y"))
{
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;
	String call_function=request.getParameter("function_id")==null?"":request.getParameter("function_id");
	%>
		<!--Modified by Ashwini on 25-Feb-2019 for MO-CRF-20149-->
		<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder='0' scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
			<iframe name='tabsFrame' id='tabsFrame' src='../../eMR/jsp/MedicalReportTabs.jsp?function_id=<%=call_function%>&call_function=<%=call_function%>&function_id=<%=call_function%>' frameborder='0' scrolling='no' noresize style='height:5vh;width:100vw'></iframe>
			<iframe scrolling="no" name='criteriaFrame' id='criteriaFrame' src='../../eCommon/html/blank.html' noresize frameborder=0 style='height:49vh;width:100vw'></iframe>
			<iframe scrolling="auto" name='resultFrame' id='resultFrame' src='../../eCommon/html/blank.html'   frameborder=0 style='height:32vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 scrolling='auto' style='height:6vh;width:100vw'></iframe>
	</html>
<%
}
else
{
	out.println("<script>alert(getMessage('CA_NOT_INSTALLED','Common'));</script>");
	out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
}

%>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	? "" : inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	? defaultValue : inputString;
	}
%>

