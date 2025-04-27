<!DOCTYPE html>
<html>
<%@ page import ="eXH.*,java.util.Map.Entry"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
String protocolLinkID = XHDBAdapter.checkNull((String)request.getParameter("protocolLinkID"));
String message = XHDBAdapter.checkNull((String)request.getParameter("message"));
HashMap<String,String> gatewayServers = GatewayServiceBean.getConfGatewayServers(protocolLinkID);
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<head>
<script Language="javascript" src="../../eCommon/js/ValidateControl.js"/>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function submitForm()
{	
	var gatewayID = document.getElementById("gatewayID").value;	
	if(gatewayID == "")
	{
		alert("Please select a gateway server...");
	}
	else
	{		
		//window.close();
		//window.returnValue = gatewayID;
		toCloseTopShowModal(gatewayID);
	}
}
function initFunc()
{	
	var totGatewayServers = document.getElementById("totGateways").value;
	if(totGatewayServers == 0) 
	{
		alert("No gateway servers configured");
		window.close();
	}
	else if(totGatewayServers == 1)
	{
		var gatewayID = document.getElementById("gatewayID").options[1].value;		
		window.returnValue = gatewayID;
		window.close();
	}
}
</script>
<TITLE>Gateway Servers</TITLE>
</head>
<BODY onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="initFunc()">
<FORM name='GatewatListForm' id='GatewatListForm'>
<br>
	<table WIDTH='100%'>
	<th class='COLUMNHEADER' COLSPAN='3'>Gateway Machine to <%= message %></th>
	</table>
	<br>
	<table align="center">
		<tr>		
			<td class="label"><fmt:message key="eXH.Gateway.Label" bundle="${xh_labels}"/></td>		       

			<td class="field">
				<SELECT name="gatewayID" id="gatewayID" ID="gatewayID" style="width: 150px">
					<OPTION VALUE=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></OPTION>
				<%
					for(Map.Entry<String, String> gatewayServer : gatewayServers.entrySet())
					{
						System.out.println("Server Key "+gatewayServer.getKey());
				%>
						<OPTION VALUE="<%= gatewayServer.getKey() %>"><%= gatewayServer.getValue() %></OPTION>
				<%
					}
				%>
				</SELECT>
				<IMG SRC='../../eCommon/images/mandatory.gif'>
			</td>
			<td CLASS="button"><INPUT TYPE="button" VALUE="Submit" onClick="submitForm()"></td>
		</tr>
	</table>
<input type="hidden" id="totGateways" value="<%= gatewayServers.size() %>">
</form>
</BODY>
</html>

