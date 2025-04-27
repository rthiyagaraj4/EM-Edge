<!DOCTYPE html>
<html>

<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<head>
<script Language="JavaScript"  src="../eCommon/js/ValidateControl.js" ></script> 			    
<script language="JavaScript">
function formload()
{	  
	parent.result.location.href="../../eXH/jsp/XHTranslationManagerResultN.jsp?&module_id="+document.forms[0].module_id.value+"&masterName="+document.forms[0].masterName.value+"&application="+document.forms[0].application.value+"&display="+document.forms[0].display.value+"&searchText="+document.forms[0].searchText.value+"&Searchbymod="+document.forms[0].mod_id.value+"&SearchbyFunct="+document.forms[0].SearchbyFunct.value+"&start_ends_contains="+document.forms[0].start_ends_contains.value+"&outbound_yn=X&searchpk2="+document.forms[0].searchpk2.value+"&searchpk3="+document.forms[0].searchpk3.value+"&outbound_yn=X";	
}

</script>
<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>
															  
</head>
<BODY CLASS="MESSAGE" BGCOLOR="#B2B6D7" onLoad="formload();">
<form name='ViewResult' id='ViewResult'>
<p align="left">
<%
 String module_id=request.getParameter("module_id")==null?"":request.getParameter("module_id");
String masterName=request.getParameter("masterName")==null?"":request.getParameter("masterName");
String appl=request.getParameter("application")==null?"":request.getParameter("application");
String display=request.getParameter("display")==null?"":request.getParameter("display");
String searchText=request.getParameter("searchText")==null?"":request.getParameter("searchText");
String Searchbymod=request.getParameter("Searchbymod")==null?"":request.getParameter("Searchbymod");
String SearchbyFunct=request.getParameter("SearchbyFunct")==null?"":request.getParameter("SearchbyFunct");
String start_ends_contains=request.getParameter("start_ends_contains")==null?"":request.getParameter("start_ends_contains");
String outbound_yn = request.getParameter("outbound_yn");			 
String searchpk2=request.getParameter("searchpk2")==null?"":request.getParameter("searchpk2");
String searchpk3=request.getParameter("searchpk3")==null?"":request.getParameter("searchpk3");	 

%> 
					 
</p>
<input type=hidden name="module_id" id="module_id" id="module_id" value='<%=module_id%>'>
<input type=hidden name="masterName" id="masterName" id="masterName" value='<%=masterName%>'>
<input type=hidden name="application" id="application" id="application" value='<%=appl%>'>
<input type=hidden name="display" id="display" id="display" value='<%=display%>'>
<input type=hidden name="searchText" id="searchText" id="searchText" value='<%=searchText%>'>
<input type=hidden name="Searchbymod" id="Searchbymod" id="Searchbymod" value='<%=Searchbymod%>'>
<input type=hidden name="SearchbyFunct" id="SearchbyFunct" id="SearchbyFunct" value='<%=SearchbyFunct%>'>
<input type=hidden name="start_ends_contains" id="start_ends_contains" id="start_ends_contains" value='<%=start_ends_contains%>'>	 
<input type=hidden name="outbound_yn" id="outbound_yn" id="outbound_yn" value='<%=outbound_yn%>'>
<input type=hidden name="searchpk2" id="searchpk2" id="searchpk2" value='<%=searchpk2%>'>
<input type=hidden name="searchpk3" id="searchpk3" id="searchpk3" value='<%=searchpk3%>'>
<input type=hidden name="mod_id" id="mod_id" id="mod_id" value='<%=Searchbymod%>'>


</form>										   
</BODY>
</html>

