<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<html>
<head> 
	
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eOA/js/QueryGroupApptDtls.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	StringBuffer source = new StringBuffer();
	source.append(url);
	source.append(params);
	String flag=""; 
    String facilityid  = (String) session.getValue("facility_id");	 
    String sql="";
    Connection con = null;
    con=ConnectionManager.getConnection(request);
    Statement stmt=null;
    ResultSet rset=null ;
           try{		 
		  stmt=con.createStatement();
		 sql="select GROUP_APPT_YN from oa_param where MODULE_ID ='OA' " ;
	       rset=stmt.executeQuery(sql);

			if(rset.next())
			 {
				flag=rset.getString("GROUP_APPT_YN");
				if(flag==null) flag="";
			 }
		
		   if(flag.equals("N")) {
		 		out.println("<script>alert(getMessage('GROUP_APP_NOT_ALLOWED','OA'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		   }else{
             
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='frame1' id='frame1' 	src='../../eOA/jsp/QueryGroupApptCriteria.jsp' frameborder=0 scrolling='no' noresize style='height:25vh;width:100vw'></iframe>
	<iframe name='frame2' id='frame2' 	src='../../eCommon/html/blank.html' frameborder=0  style='height:61vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:6vh;width:100vw'></iframe>
<%		
		}
    }
    catch (Exception e) { 
//out.println(e) ; 
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
	finally{
	 if(con != null) ConnectionManager.returnConnection(con,request);
	 if(rset!=null) rset.close();
	 if(stmt!=null) stmt.close();
}
%>
</html>

