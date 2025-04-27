<!DOCTYPE html>

<%@ page import ="eCommon.Common.CommonBean,eOT.*,eOT.Common.*,eCommon.XSSRequestWrapper,eCommon.Common.*" %>                
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<html>
<head > </head>
<script type="text/javascript" src="../../eOT/js/OTCommon.js"></script>
<script type="text/javascript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script language="JavaScript" src="../../eOT/js/ItemDetails.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			String function_id=request.getParameter("function_id");
			if(function_id==null || function_id.equals("")) function_id="";
			String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
			String source = url + params ;
			String booking_no=request.getParameter("booking_no");
			String order_id=request.getParameter("orderid");
%>
<%
    String title="";
    title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ItemRequestDetails.Label","ot_labels");
    source=source+"&access=NYNNN&home_required_yn=N";
	System.err.println("orderId=="+order_id+"=bookingNum==1s111="+booking_no);
%>
<TITLE><%=title%></TITLE>
<iframe name="commontoolbarFrame" id="commontoolbarFrame"  scrolling="no" src='<%=source%>' noresize style='height:5vh;width:100vw'></iframe>
	 <iframe name="OTPatientLineFrame" id="OTPatientLineFrame"  scrolling="no" noresize src="../../eOT/jsp/OTPatLineFrame.jsp?<%=request.getQueryString()%>" style='height:12vh;width:100vw'></iframe>
	 <iframe name='header_frame' id='header_frame'	src="../../eOT/jsp/RequestDetails.jsp?<%=request.getQueryString()%>"   scrolling="no"   nowrap style='height:20vh;width:100vw'></iframe>
	<iframe name='itemHdrLegend' id='itemHdrLegend'	 src='../../eOT/jsp/ItemHdrLegend.jsp'  scrolling='no' style='height:4vh;width:100vw' ></iframe>
	<iframe name='itemRequestData' id='itemRequestData'	 src="../../eOT/jsp/ItemRequestData.jsp?<%=request.getQueryString()%>"   noresize style='height:50vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp'  noresize style='height:9vh;width:100vw'></iframe>
	

</html>


