<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
	<title></title>
	 <link rel='StyleSheet1' href='../../eCommon/html/body.css' type='text/css'/>
	<head>
		
		<%
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ?
			(String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
			if(sStyle==null)sStyle="IeStyle.css";
			String dialogMessage = request.getParameter("dialogMessage");
			System.out.println("dialogMessage---->"+dialogMessage);
		%>
		<script type="text/javascript" src="../../eDS/js/PlaceDietOrder.js">
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script>
		function commonClose(breturn)
		{
			parent.window.returnValue=breturn; 
			top.close();
		}
		</script>
	</head>
	<form>
	<div id="popup">
		<table>
			<tr><td><br/></td></tr>
			<tr>
				<td style="align:left;vertical-align:top"><img src="../../eCommon/images/continue.gif"/></td>
				<td><%=dialogMessage%></td>
			</tr>
			<tr><td><br/></td></tr>
		</table>
		<table>		
			<tr align=center>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 
				
				<td align=right>
					<input type="button" name="yes" id="yes" value='&nbsp;&nbsp;&nbsp;<fmt:message key="Common.yes.label" bundle="${common_labels}" />&nbsp;&nbsp;&nbsp;' class="button" onClick='commonClose(true);'/> </td>
				<td align=right><input type="button" name="no" id="no"  value="&nbsp;&nbsp;&nbsp;<fmt:message key="Common.no.label" bundle="${common_labels}" />&nbsp;&nbsp;&nbsp;" class="button" onClick='commonClose(false);' />
				</td>
			</tr>
		</table>
	</div>
	</form>
</html>

