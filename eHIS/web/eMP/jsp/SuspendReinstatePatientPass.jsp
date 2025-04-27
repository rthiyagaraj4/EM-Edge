<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
    request.setCharacterEncoding("UTF-8");
	Connection con = null;
    PreparedStatement stmt = null;  
    ResultSet rs=null;
    String sql="select suspend_service_yn from mp_param";
    String suspend_service_yn="";
    try
    {
	   con = ConnectionManager.getConnection(request);
       stmt = con.prepareStatement(sql);
       rs=stmt.executeQuery();
       if (rs.next())
	       suspend_service_yn=rs.getString("suspend_service_yn");	 
	   else
	   {
	       out.println("<script>alert(parent.parent.frames[0].getMessage('MP_PARAM_NOT_FOUND','MP'));");
	       out.println("window.location.href ='../../eCommon/jsp/dmenu.jsp'</script>") ; 
	   }
    }
    catch(Exception e)
    {
    }
    finally
    {
            if (stmt != null) stmt.close();
            if (rs != null) rs.close();
            if(con!=null) ConnectionManager.returnConnection(con,request);
    }
%>
<html>
<head>
<Script language='javascript' src='../js/SuspendReinstatePatient.js'></Script>
<Script language='javascript' src='../../eCommon/js/common.js'></Script>

<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<script>

function retback()
{
  //alert(getMessage("PATIENT_SUSP_NOT_ALLOWED","MP"));
	 window.location.href ="../../eCommon/jsp/dmenu.jsp"; 
}  
</script>
<%
if(suspend_service_yn.equals("Y"))
{
    String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
    String params = request.getQueryString() ;
    String source = url + params ;
%>
</head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'    src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
    <iframe name='plineFrame' id='plineFrame'    src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
    <iframe name='f_query_add_mod' id='f_query_add_mod' src='../jsp/blank.jsp?step_1=1' frameborder=0  scrolling='auto' style='height:75vh;width:100vw'></iframe>
    <iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
<%}
else
{%>
</head>
<body onload='retback()' onKeyDown = 'lockKey()'></body>
<%}%>
</html>

