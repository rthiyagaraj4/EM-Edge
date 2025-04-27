<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
	<title>Refer to Dietician</title>
	 <link rel='StyleSheet1' href='../../eCommon/html/body.css' type='text/css'/>
	<head>
		
		<%
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ?
			(String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
			if(sStyle==null)sStyle="IeStyle.css";
			String dieticianReferral = request.getParameter("dieticianReferral");			
		%>
		<script type="text/javascript" src="../../eDS/js/PlaceDietOrder.js"></script>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	</head>
	<form>
	<div id="popup">
		<table>
			<tr>
				<td>
					<br><br>
					&nbsp;&nbsp;
					<img src = "../../eCommon/images/Alert.png"/><span id="msg"></span>
					    				
					<script language="javascript">
						document.getElementById('msg').innerHTML=getMessage('DS_REFERTODIET_WITHOUT_DIETORD','DS');
					</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

				</td>
			</tr>
			<tr>
				<td align="right">
					<input type="button" name="yes" id="yes" value='<fmt:message key="eOT.yes.Label" bundle="${ot_labels}" />' class="button" onClick='getReferDietcian(document.getElementById("referDietcian").value);'/>&nbsp;
					<input type="button" name="no" id="no"  value="<fmt:message key="eOT.no.Label" bundle="${ot_labels}" />" class="button" onClick='notToRefer(document.getElementById("notToReferDietcian").value);' />
				</td>
			</tr>
		</table>
	</div>
		<input type="hidden" name="referDietcian" id="referDietcian" value="<%=dieticianReferral%>" />
		<input type="hidden" name="notToReferDietcian" id="notToReferDietcian" value="" />
	</form>
</html>

