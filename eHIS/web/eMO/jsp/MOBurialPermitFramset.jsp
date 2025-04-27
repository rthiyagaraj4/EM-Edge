<!DOCTYPE html>
<%@ page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
 <head>
  <%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");

  %>
 <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
 </head>
 <script src='../../eMO/js/MOBurialPermit.js' language='javascript'></script>
 <script language='javascript' src='../../eCommon/js/common.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 <%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String parmeters = request.getQueryString() ;
	String source = url + parmeters ;
	String function_id=request.getParameter("function_id");
    if(function_id == null) function_id = "";
	
/*Below Code Added for this incident[33932] */		
String	facility_id =  (String) session.getValue( "facility_id" ) ;
Connection con		=	null;
Statement	st		=	null;
ResultSet	rs		=	null;
String interval="";           
    try 
		{ 			
			con	 =	(Connection)ConnectionManager.getConnection(request);			
			st	 =con.createStatement();
			rs=st.executeQuery("select QUEUE_REFRESH_INTERVAL from mo_parameter where facility_id='"+facility_id+"'");
			if(rs.next())
			{
			interval=rs.getString("QUEUE_REFRESH_INTERVAL")==null?"0":rs.getString("QUEUE_REFRESH_INTERVAL");			   
			}
			if (rs!=null) rs.close();
			if (st!=null) st.close();
			}catch(Exception e)
	        {
	        e.printStackTrace();
	        }finally {
	           ConnectionManager.returnConnection(con,request);
             }
			 
if(interval.equals("")){%>
<script>
		alert(getMessage("MO_PARAM_NOT_FOUND","MO"));	      			
		document.location.href='../../eCommon/jsp/dmenu.jsp';
</script>
<%}%>
 

   <iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
		<iframe name='patientFrame' id='patientFrame' src='../../eMO/jsp/MOBurialPermitQueryCriteria.jsp?<%=parmeters%>&callfrom=callfrommoreg' frameborder=0 scrolling='no' noresize style='height:17vh;width:100vw'></iframe>
		<iframe name='patientDetailsFrame' id='patientDetailsFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:61vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eMO/jsp/MOManageDeceasedColor.jsp' frameborder=0 noresize scrolling='no' style='height:5vh;width:100vw'></iframe><iframe name='dispfr' id='dispfr' src='../../eMO/jsp/MOManageDeceasedColor.jsp?decesregn=burialpermit' frameborder=0 noresize scrolling='no' style='height:4vh;width:100vw'></iframe>
	<form>
	<input type='hidden' name='function_id' id='function_id' value=<%=function_id%>>
	</form>

</html>

