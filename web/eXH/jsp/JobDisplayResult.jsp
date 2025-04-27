<!DOCTYPE html>
<html> 
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<link rel='StyleSheet' href='../eCommon/html/<%=sStyle%>' type='text/css'></link>
<head>
<script language="JavaScript" src="../eCommon/js/showModalDialog.js" ></script>
<script Language="JavaScript"  src="../eCommon/js/ValidateControl.js" ></script>
<script language="JavaScript">
//function load 
function load() 
{
<% 
 String status=XHDBAdapter.checkNull((String)request.getAttribute("status"));


 String p_action=(String)request.getAttribute("p_action");	   
  if((status.equals("0")) ||(status.equals("2")))
	{ %>
			  
   jobform.action='../eXH/jsp/AdminOracleJobProcessList.jsp?functionID='+document.getElementById("functionID").value;
   jobform.target="queue_frame";
   jobform.submit();																	  
																	    

<%	} %>
	if('<%=p_action%>'=='R')
	{
/*
var formObj=parent.action_frame.AdminOracleJobProcessActionForm;
for(var i=0;i<formObj.process.length;i++){
	if(	formObj.process.options[i].value=="")
    	formObj.process.options[i].selected=true;
	}
		*/
	}

}
</script>
<!-- <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script> -->

</head>
<BODY CLASS="MESSAGE" onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="load();">
<form name='jobform' id='jobform'>
<p align="left">
<%
String result=(String)request.getParameter( "message" );
 String functionID = XHDBAdapter.checkNull(request.getParameter("functionID")) ;
  //System.out.println("functionID :"+functionID);
%>
<br>
<br>
<%=result%>
</p>	
<input type=hidden name=functionID id='functionID' value='<%=functionID%>'>
</form>
</BODY>
</html>

