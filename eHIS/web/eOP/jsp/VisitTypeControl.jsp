<!DOCTYPE html>
<html>
<head>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'>
</link> -->
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script  src='../../eOP/js/VisitTypeControl.js'   language='javascript' ></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

</head>
<%
    String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
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
		 sql="select OVERRIDE_VTYPE_ON_EPSD_YN from op_param where    OPERATING_FACILITY_ID ='"+facilityid+"' " ;
	       rset=stmt.executeQuery(sql);

			if(rset.next())
			 {
				flag=rset.getString("OVERRIDE_VTYPE_ON_EPSD_YN");
				if(flag==null) flag="";
			 }
		
		   if(flag.equals("Y"))
	        {
		 out.println("<script>alert(getMessage('VIS_TYPE_CNTRL_NOT_APPLICABLE','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		      }

           else
	        {
             %>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'    src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
    <iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eCommon/html/blank.html" frameborder=0 scrolling=no style='height:80vh;width:100vw'></iframe>
    <iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
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

