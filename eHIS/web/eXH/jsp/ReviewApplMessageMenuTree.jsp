<!DOCTYPE html>
<%@ page import ="java.sql.*,java.io.*,webbeans.eCommon.*,eXH.XHReturnArray"%>
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<%
String applicationId="";
String applicationName="";
String facilityId="";  
String facilityName="";
String msgId="";
String eventType="";							 
//String eventName="";

String mode=request.getParameter("protocol_mode");
if(mode!=null && mode.equalsIgnoreCase("I") ){
	 applicationName=request.getParameter("applicationName");
	 facilityName=request.getParameter("facilityName");
	 msgId=request.getParameter("msgId"); 
	}
else if(mode!=null && mode.equalsIgnoreCase("O")) {
	 applicationId=request.getParameter("applicationId");
	 applicationName=request.getParameter("applicationName");
	 facilityId=request.getParameter("facility_Id");
	 facilityName=request.getParameter("facilityName");
	 msgId=request.getParameter("msgId");
	 eventType=request.getParameter("eventType"); 
	 //eventName=(String)session.getAttribute("eventName");
}
%>
<form name="menu_tree" id="menu_tree">                            
<div class='dtree'>
<script type='text/javascript' src='../../eXH/js/dtree.js'></script>
<script type='text/javascript'>
	d = new dTree('d');
	d.config.useStatusText=true;
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body class='TREEBODY'>
<script>
<%
try{
   if(mode!=null && mode.equalsIgnoreCase("I") ){
			if(applicationName!=null) 
			{
			  out.println("d.add(0,-1,'"+applicationName+"','','"+applicationName+"');"); 
			  if(facilityName!=null) out.println("d.add(1,0,'"+facilityName+"','','"+facilityName+"');"); 
			  if(msgId!=null) out.println("d.add(2,1,'"+msgId+"','','"+msgId+"');"); 
			}
		
	}
	else if(mode!=null && mode.equalsIgnoreCase("O")) {
		if(applicationName!=null){
		out.println("d.add(0,-1,'"+applicationName+"','','"+applicationName+"');"); 
		if(facilityName!=null) out.println("d.add(1,0,'"+facilityName+"','','"+facilityName+"');"); 
		if(eventType!=null) out.println("d.add(2,1,'"+eventType+"','','"+eventType+"');"); 
		if(msgId!=null)out.println("d.add(3,2,'"+msgId+"','','"+msgId+"');"); 
		}
	}
}catch (Exception e) {
		out.println(e) ;
		e.printStackTrace() ;
}
%>
document.write(d);
d.openAll();
</script>
</form>
</body>
</div>
</HTML>

