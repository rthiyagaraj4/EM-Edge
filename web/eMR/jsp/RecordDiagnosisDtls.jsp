<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;	
%>

<html>
<head>
	<%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../ecommon/js/common.js'></script>
	
	<script>
 function reset()
 {
	//searchFrame.document.forms[0].search[1].disabled=false;
	searchResultFrame.document.location.href="../../eCommon/html/blank.html"  
	//searchFrame.document.getElementById("PatientDetail").innerHTML = "&nbsp;"
	searchFrame.document.forms[0].reset(); 
	searchFrame.document.forms[0].p_patient_id.focus(); 
 }
</script>
 <head>
<%
PreparedStatement pstmt =null;
ResultSet rs	= null;
Connection conn	= null;
String ca_install_yn="N";
 

try{
	conn=ConnectionManager.getConnection(request);
	pstmt=conn.prepareStatement("select install_yn from sm_module where module_id='CA'");
	rs=pstmt.executeQuery();
	if(rs != null)
	{
		rs.next();
		ca_install_yn=rs.getString(1);	
		
	}
if(rs != null) rs.close();
if(pstmt != null) pstmt.close();
	
}catch(Exception e){System.out .println("exception in recdiagProcencdtls="+e);}
finally
{
	ConnectionManager.returnConnection(conn,request);
}
if(ca_install_yn.equals("Y"))
{

%>
	
<iframe name='commontoolbarFrame' id='commontoolbarFrame'      src='<%=source%>' scrolling='NO' frameborder=0  noresize style='height:08%;width:100vw'></iframe>
	<iframe name='searchFrame' id='searchFrame'       src="../../eMR/jsp/recDiagProcEncDtlsSearch.jsp?function_id=DIAGNOSES"	scrolling='No' frameborder=0 noresize style='height:25%;width:100vw'></iframe>
	<iframe name='searchResultFrame' id='searchResultFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:57%;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='NO' frameborder='0' noresize style='height:100vh;width:100vw'></iframe>

		<%
}
	else
	{
		%>
			<script>
			alert(getMessage("CA_NOT_INSTALLED","Common"));
			</script>
			<%
	}
	%>

