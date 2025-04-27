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
//String applicationId="";
String applicationName="";
//String facilityId="";
String facilityName="";
String msgId="";
//String eventType="";
//String eventName="";
 			//applicationName=(String)session.getAttribute("applicationName");
facilityName=request.getParameter("facilityName");
applicationName=request.getParameter("applicationName");
 msgId=(String)session.getAttribute("msgId");								    
String mode=(String)session.getAttribute("mode");
//System.out.println(applicationName+" b"+facilityName);
%>

<form name="menu_tree" id="menu_tree">                            
<div class='dtree'>
<script type='text/javascript' src='../../eXH/js/dtree.js'></script>
<script type='text/javascript'>
	d = new dTree('d');
	d.config.useStatusText=true;
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




<body class='TREEBODY'>
<script>
<%
try{
if(mode!=null){
if(mode.equalsIgnoreCase("A")){

if(applicationName!=null) 
{
if(facilityName==null) 
	{

facilityName="All Facility";
	}
  
  out.println("d.add(0,-1,'"+applicationName+"','','"+applicationName+"');"); 
  if(facilityName!=null) out.println("d.add(1,0,'"+facilityName+"','','"+facilityName+"');"); 
  if(msgId!=null) out.println("d.add(2,1,'"+msgId+"','','"+msgId+"');"); 
}
else
	{
applicationName="All Application";
if(facilityName==null) 
	{

facilityName="All Facility";
	}
	out.println("d.add(1,0,'"+applicationName+"','','"+applicationName+"');"); 
  if(facilityName!=null) out.println("d.add(2,1,'"+facilityName+"','','"+facilityName+"');"); 
  if(msgId!=null) out.println("d.add(3,2,'"+msgId+"','','"+msgId+"');"); 
	}



}
}

else{
if(applicationName!=null){

if(facilityName==null) 
	{

facilityName="All Facility";
	}


out.println("d.add(1,0,'"+applicationName+"','','"+applicationName+"');"); 
if(facilityName!=null) out.println("d.add(2,1,'"+facilityName+"','','"+facilityName+"');"); 
//if(eventName!=null) out.println("d.add(2,1,'"+eventName+"','','"+eventName+"');"); 
if(msgId!=null)out.println("d.add(3,2,'"+msgId+"','','"+msgId+"');"); 

}

else
	{
applicationName="All Application";
if(facilityName==null) 
	{

facilityName="All Facility";
	}

	out.println("d.add(1,0,'"+applicationName+"','','"+applicationName+"');"); 
  if(facilityName!=null) out.println("d.add(2,1,'"+facilityName+"','','"+facilityName+"');"); 
  if(msgId!=null) out.println("d.add(3,2,'"+msgId+"','','"+msgId+"');"); 
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

