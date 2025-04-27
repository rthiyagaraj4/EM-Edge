<!DOCTYPE html>

<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String queryString = request.getQueryString() == null ? "" : request.getQueryString();
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script src='../../eCA/js/CAMainMenu.js' language='javascript'></script>
	<script src='../../eCA/js/MaternityConsTree.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>	
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<%

/*Connection con = null;
	CallableStatement cs = null;	
		
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");	

	{
		con = ConnectionManager.getConnection(request);
		cs = con.prepareCall("{call CA_SPL_AUTO_UPD_ENT_STATUS(?) }");
		cs.setString(1,patient_id);
		cs.execute();
			
		if(cs!=null) cs.close();
	}
	catch (Exception e) 
	{
		e.printStackTrace();
		
    }
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request);
	}*/



%>
<script>
/** Modified by kishore kumar N 0o 03/12/2008 for 0387 CRF**/
	top.content.workArea.cols="0%,200px,*,0%";
	
/** ends here **/
		top.content.matFrame.location.href='../../eCA/jsp/ProgressNotesTreeMain.jsp?<%=queryString%>'
	//top.content.workAreaFrame.location.href='../../eCommon/html/blank.html'
	
		top.content.workAreaFrame.location.href='../../eCA/jsp/ProgressNotesMain.jsp?<%=queryString%>'
	</script>
</html>

