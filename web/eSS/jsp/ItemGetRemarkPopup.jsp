<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<title>Remarks&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Web Page Dialog&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                                               
		</title>
	<script language='javascript'>
	function closeMe()
	{
		 
		var data=formRemark.remark.value;

		if(data==null||data==""){
			//parent.returnValue="" ;
			parent.document.getElementById('dialog-body').contentWindow.returnValue = "";
		}
		else
		{
		   // parent.returnValue=data ;
		   parent.document.getElementById('dialog-body').contentWindow.returnValue = data;
		}
		parent.document.getElementById("dialog_tag").close(); 
	}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body>
<form id='formRemark' name='formRemark' id='formRemark'>
  <p>
	<table width='297' height='100%' border='0'cellpadding='0' cellspacing='0'>
	  <tr>
		  <td>&nbsp;
		  </td>
	  </tr>
	  <tr>
		  <td align='center' valign='top'>
			  <textarea rows="5" name="remark" cols="38"><%=request.getParameter("remarks")%></textarea>
	      </td>
	  </tr>
	  <tr>
		<td align='center'>
			<input type="Button"  class="BUTTON" value="Close" name="close" id="close" onclick="closeMe();">
		</td>
		</tr>
  </p>
</form>
</body>
</html>

