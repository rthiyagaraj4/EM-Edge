<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<jsp:useBean id="accessRightRecSet" class="webbeans.eCommon.RecordSet" scope="session"/> 
<script language='javascript' src='../../eMP/js/PatientSeriesGroupForUser.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?";
		String params = request.getQueryString() ;
		String source = url + params ;
		Connection con=null;
	Statement stmt=null;
	ResultSet rSet=null;
	String patcode="";
	String shortdesc="";
	String patSerAccByuser="N";
	try{
		request.setCharacterEncoding("UTF-8");
		con = ConnectionManager.getConnection(request);
		stmt=con.createStatement();
		rSet=stmt.executeQuery("select pat_ser_access_by_user_yn from mp_param");
		if(rSet!=null && rSet.next()){
			patSerAccByuser=rSet.getString("pat_ser_access_by_user_yn")==null?"N":rSet.getString("pat_ser_access_by_user_yn");
		}
		if(patSerAccByuser.equals("Y")){
%>


<frameset rows='45,*,45 'id='PatSerGrpUserID'>
      <!--venkat-->
		<frame name='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize>
		<frame name='f_query_add_mod' 	src='../../eCommon/html/blank.html' frameborder=0 noresize>		
		<frame name='messageFrame'		src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'>

</frameset>
<%
	}else{%>
	<html>
		<Script language="JavaScript">
			document.location.href="../../eCommon/html/blank.html";
			alert(getMessage("PAT_SER_ACC_BY_USER",'MP'));
			document.location.href='../../eCommon/jsp/dmenu.jsp';
		</Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</html>
	<%}
	}catch(Exception e){
		//out.println(e);
		e.printStackTrace(); // Added by lakshmanan for security issue ID 174103026 on 31-08-2023
	}finally { 
		ConnectionManager.returnConnection(con,request);
	}
%>

