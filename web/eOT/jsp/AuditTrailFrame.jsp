<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

	<html>
	<script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
	
	 String  Changetype_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ChangeType.Label","ot_labels")+",";
	 String  Doneby_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DoneBy.label","common_labels")+",";
	 String  ActionDateTime_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ActionDateTime.label","common_labels")+",";
	 String  ChangeDescription_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ChangeDescription.label","common_labels")+",";

	// String strLegends="Change Type,Done By,Action Date/Time,Change Description";
	 //String strLegends=""+Changetype_title+","+Doneby_title+","+ActionDateTime_title+","+ChangeDescription_title+"";
	 String strLegends=Changetype_title+Doneby_title+ActionDateTime_title+ChangeDescription_title;

	 String strSizes="20,20,25,35";
	 String source="../../eOT/jsp/HdrComDisplay.jsp?";
	 String param="legends="+strLegends+"&sizes="+strSizes;
	 source=source+param;
	 %>
	 <title><fmt:message key="Common.AuditTrail.label" bundle="${common_labels}"/></title>


<!--  <frame name='schedule_hdr' id='schedule_hdr'	src='<%=source%>'
	 frameborder=0  scrolling='auto' noresize>	 -->
 <iframe name='f_query_add' id='f_query_add'	src='../../eOT/jsp/AuditTrailDtl.jsp?<%=request.getQueryString()%>'
	   noresize scrolling='auto' style="height:90vh;width:95vw" frameborder="0"></iframe>	
<iframe name='group_tail' id='group_tail' src='../../eCommon/jsp/GeneralCancel.jsp' noresize   marginheight=0 marginwidth=0 style="height:5vh;width:95vw" frameborder="0"></iframe>

</html>

