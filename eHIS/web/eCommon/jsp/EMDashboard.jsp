<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<HTML>
<HEAD>
<title>EM Dashboard</title>
</HEAD>
<script>

function openDashBoard()
{		
	

	//window.open("../../eCommon/jsp/EMDashboardValidate.jsp?username="+document.forms[0].username.value, 'EM', 'location=0,height=700,width=1050,top=0,left=200,resizable=yes,titlebar=yes,title=EMDashboard');

	var url_arr=document.forms[0].url.value.split(".jsp");
	var dash_url=url_arr[0]+"Validate.jsp?username="+document.forms[0].username.value;
	MyObject = new ActiveXObject( "WScript.Shell" )   

		  
	
   try{	 
       MyObject.Exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe --new-window " +dash_url	);
      
   }catch(exception){
	   window.open("../../eCommon/jsp/EMDashboardValidate.jsp?username="+document.forms[0].username.value, 'EM', 'location=0,height=700,width=1600,top=0,left=0,resizable=yes,titlebar=yes,title=EMDashboard');
   }
          

	parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
	
}


</script>
<%
String user_id				= (String) session.getAttribute( "login_user" ) ;
String url=request.getRequestURL().toString();


	%>

<BODY >

<form name="emdash" id="emdash" >
  <input type="hidden" name="username" id="username" value="<%=user_id%>">
  <input type="hidden" name="url" id="url" value="<%=url%>">
  
</form>

</BODY>
 

</HTML>
	<script >

	openDashBoard();
	</script>


