<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<frameset rows='0%,*'> 

 <%
	   

	String orderCategory =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels")+",";
	
	String orderedAt =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedAt.label",
	"or_labels")+",";
	String	orderType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderType.label","common_labels")+",";
	String	orderCatalog=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ordercatalog.label","common_labels")+",";
	String orderedBY=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderedBy.label","common_labels")+",";
	String status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+",";
	String  select  =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		 
	 
	 
 String strLegends=
	 orderCategory+orderedAt+orderType+orderCatalog+orderedBY+status+select ;


	 String strSizes="11,10,10,25,20,15,10";
	 String source="../../eOT/jsp/HdrComDisplay.jsp?";
	 String param="legends="+strLegends+"&sizes="+strSizes;
	 source=source+param;
	 	 
 %>
 <frame name='schedule_hdr'	src='<%=source%>'
	 frameborder=0 scrolling='no' noresize>	
<frame name='schdule_dtl' 		src="../../eOT/jsp/PreOperativeDtl.jsp?<%=request.getQueryString()%>" frameborder=0>
</frameset>
