<!DOCTYPE html>
<%@page import="java.sql.*, webbeans.eCommon.ConnectionManager,eIP.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function doClose(){
   window.close();
}
</script>
<%
 String statusCode = checkForNull(request.getParameter("statusCode")); 
%>
<title><%=statusCode%></title>
<%
  Connection con =null;
  try{
	 con = ConnectionManager.getConnection(request);
	String cancelrejectcode = checkForNull(request.getParameter("cancelrejectcode"));
	
	System.err.println("CancelRejectRemarks.jsp statusCode===>"+statusCode);
	System.err.println("CancelRejectRemarks.jsp cancelrejectcode===>"+cancelrejectcode);
	String cancelRejectRemarks=eIP.IPCommonBean.getCancelRejectReason(con,cancelrejectcode);
	System.err.println("CancelRejectRemarks.jsp cancelRejectRemarks===>"+cancelRejectRemarks);
	%>
<table width='100%' border='0' cellspacing='0' cellpadding='2' align=center>
	<tr>
		<td  class='label' width='10%'></td>
	</tr>
	<tr> 
		<td  width='90%' class='labelcenter'>
		 <textarea name="comments" rows="5" readonly cols="70"><%=cancelRejectRemarks%></textarea> 		
	</td>
	</tr>
<tr>
	<td class='labelcenter'><input type='Button' class='Button' name='Ok' id='Ok' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onclick='doClose()'></td>
	</tr>
	</table>
	
</body>
<%}catch(Exception e){
   e.printStackTrace();
}finally
	{	
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}%>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

