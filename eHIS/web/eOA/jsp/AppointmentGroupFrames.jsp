<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
<script src='../js/AppointmentGroup.js'  language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String params = request.getQueryString() ;
	String source = url + params ; 
	request.setCharacterEncoding("UTF-8");
	
	String flag=""; 
    String facilityid  = (String) session.getValue("facility_id");	 
    String sql="";
    Connection con = null;
    con=ConnectionManager.getConnection(request);
    Statement stmt=null;
    ResultSet rset=null ;
           try{		 
		  stmt=con.createStatement();
		 sql="select GROUP_APPT_YN from oa_param where  MODULE_ID ='OA' " ;
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
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%>  scrolling='no' noresize frameborder="0" style='height:8vh;width:100vw'></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html'  frameborder="0" style='height:83vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder="0" noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
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

