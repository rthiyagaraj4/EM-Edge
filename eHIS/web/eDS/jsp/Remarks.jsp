<!DOCTYPE html>
<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<title><fmt:message key="eDS.Remarks.Label" bundle="${ds_labels}" /></title>
<script type="text/javascript" src="../../eDS/js/PlaceDietOrder.js"></script>
<script type="text/javascript" src="../../eDS/js/DSCommon.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<head>
<%
	String remarkHdr = java.net.URLDecoder.decode(request.getParameter("remarkHdr"),"UTF-8");
	// Start AMRI-SCF-0385 [IN:056722]		
	if(remarkHdr.equals("") || remarkHdr.equals("undefined") || remarkHdr.equals("null"))
	{
		remarkHdr ="";
	}
	// End AMRI-SCF-0385 [IN:056722]		
	
%>
<body>
<form>
	<table>
 		<tr>
			<td><textarea name="REMARKS" id="REMARKS" style="resize:none;height: 150px;" rows=10 cols=50 onkeyup="textAreaLimit1(this,150);" onkeypress="restrictSpecialChars(event)"></textarea></td>
  		</tr>
  		<tr>
  			<td align="center">
				<input type="button" name="" id="" value='<fmt:message key="eOT.Ok.label" bundle="${ot_labels}" />' onClick='geRemarks(document.getElementById("REMARKS").value)' class="button" >
				<input name="cancel" id="cancel" type="button" value="<fmt:message key="eOT.Cancel.label" bundle="${ot_labels}" />" class="button" onClick="parent.document.getElementById('dialog_tag').close();" />
			</td>
  		</tr>
	</table>
	<input type="hidden" name="remarks1" id="remarks1" value="<%=remarkHdr%>" />
</form>
</body>
<script type="text/javascript">
//document.getElementById("REMARKS").value = unescape(decodeURIComponent(document.getElementById("remarks1").value));
document.getElementById("REMARKS").value = unescape(document.getElementById("remarks1").value);
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
</html>

