<!DOCTYPE html>
<%--
	FileName	: VisitRuleForPract.jsp
	Version	    : 31
	Modified On	: 03.11.2011
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eOP/js/VisitRuleForPract.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String flag=""; 
    String facilityid  = (String) session.getValue("facility_id");	 
    String sql="";
    Connection con = null;
    con=ConnectionManager.getConnection(request);
    Statement stmt=null;
    ResultSet rset=null ;
           try{		 
		  stmt=con.createStatement();
		 sql="select VISIT_TYPE_DERV_RULE from op_param where   OPERATING_FACILITY_ID ='"+facilityid+"' " ;
	       rset=stmt.executeQuery(sql);

			if(rset.next())
			 {
				flag=rset.getString("VISIT_TYPE_DERV_RULE");
				if(flag==null) flag="";
			 }
		
		   if(!flag.equals("P"))
	        {
		 out.println("<script>alert(getMessage('VISIT_TYPE_PRACT_BASED','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		      }

           else
	        {
             
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eCommon/html/blank.html" frameborder=0 style='height:80vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
<%		
		}
    }
    catch (Exception e) { out.println(e) ; }
	finally{
	 if(con != null) ConnectionManager.returnConnection(con,request);
	 if(rset!=null) rset.close();
	 if(stmt!=null) stmt.close();
}
%>
</html>

