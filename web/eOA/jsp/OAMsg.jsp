<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %> 
<html>
 <%
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String OperationYN=request.getParameter("successyn")==null?"":request.getParameter("successyn");
String errorValue=request.getParameter("errorValue")==null?"":request.getParameter("errorValue");
String callMode=request.getParameter("callingMode")==null?"":request.getParameter("callingMode");


%>
<head>
    <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
        <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
        <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>   
        <script language='javascript' src='../eOA/js/ApptWaitList.js'></script>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<%if(OperationYN.equals("Y"))
{%>

<script>alert("<%=errorValue%>");window.close();</script>
<%}

if(callMode.equals("OP"))
{%>
	<script> var error="<%=errorValue%>";
	var error1=error.substring(64,70);
	var final_val=error1+"$"+"Y";
	parent.window.returnValue=final_val;parent.window.close();</script>
<%}
%>

</head>


<BODY CLASS="MESSAGE" onKeyDown = 'lockKey()'>

</body>

