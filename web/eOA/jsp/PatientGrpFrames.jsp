<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
<script language='javascript' src='../../eOA/js/PatientGroup1.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;	
	String flag=""; 
    	 
    String sql="";
    Connection con = null;
    con=ConnectionManager.getConnection(request);
    Statement stmt=null;
    ResultSet rset=null ;
    String facilityid  = (String) session.getValue("facility_id");
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


<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>		
		<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eOA/jsp/PatientGroupsFrameset.jsp' frameborder='0' scrolling='no' style='height:85vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no' frameborder='0' noresize style='height:7vh;width:100vw'></iframe>
	
	
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

