<!DOCTYPE html>
<%@ page import="java.sql.*, java.text.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String called_mod=request.getParameter("called_mod") == null ? "N" : request.getParameter("called_mod");
//out.println("called_mod="+called_mod);
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src='../js/rowcolor.js' language='javascript'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<script>
		function OnOkClick()
		{
			var finalString="";
			for (i=1;i<=parent.problemsframe1.document.getElementById("tb1").rows.length;i++ )
			{
				if(parent.problemsframe1.document.getElementById("ch"+i)!=null)
				{
					if(parent.problemsframe1.document.getElementById("ch"+i).checked==true)
					{
						finalString+=parent.problemsframe1.document.getElementById("hid"+i).value+"||";
					}
				}
			}
			window.returnValue=finalString;
			window.close();
		}

		function OnCancelClick()
		{
			/* window.returnValue="";
			window.close(); */
			toCloseTopShowModal("");
		}
		function OnCloseClick()
		{			
			/* window.returnValue="";*/
			//window.close();	 
			toCloseTopShowModal("");
		}
	</script>

<head>
<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name=okFrm>
	<table id='tblOk' width='100%' >
		<tr  align=right>
			<td align=right>
			<%
			if(called_mod.equals("BL")) { %>			
			<input class=button type='button' name=closeButton value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="OnCloseClick();">
			<% } %>
			<%
			if(!(called_mod.equals("BL"))) { %>
			<input class=button type='button' name=okButton value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onclick="OnOkClick();">
			
			<input class=button type='button' name=Button value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onclick="OnCancelClick();">
			<% } %>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>

