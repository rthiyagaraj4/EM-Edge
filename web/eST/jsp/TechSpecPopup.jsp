<html>
	<head>
	<%
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<title>Technical Specification                                        
		</title>
		<style>
textarea {
  resize: none;
}
</style>
	<script language='javascript'>
	function closeMe()
	{
		var data=formRemark.remark.value;
		if(data==null)
			data="";	
		//parent.returnValue=data;
		let dialogBody = parent.document.getElementById('dialog-body');
        dialogBody.contentWindow.returnValue = data;
		//window.close();
		var dialogTag = parent.document.getElementById("dialog_tag");    
	    dialogTag.close(); 
	}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>

<%
String rdonly="";
if(request.getParameter("disabled123").equals("disabled"))
{
	rdonly="readonly";
}
%>
	<body>
<form id='formRemark' name='formRemark' id='formRemark'>
  <p>
	<table width='90%' height='90%' border='0'cellpadding='0' cellspacing='0' align="center">
	  <tr>
		  <td>&nbsp;
		  </td>
	  </tr>
	  <tr>
		  <td align='center' valign='top'>
			  <textarea rows="15" name="remark" id="remark" cols="87" <%=rdonly%>></textarea>
	      </td>
	  </tr>
	  <tr>
		<td align='right'>
			<input type="Button"  class="BUTTON" value="Close" name="close" id="close" onclick="closeMe();">
		</td>
		</tr>
		</table>
	</p>  
</form>
	<script>
		document.formRemark.remark.value = parent.f_query_add_mod.document.getElementById("technical_specification_textarea").value;
	</script>
</body>
</html>

