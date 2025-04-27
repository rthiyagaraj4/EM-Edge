<!DOCTYPE html>
<!-- 
Sr No        Version           TFS/Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V201118            8071/74237        MOHE-CRF-0050.4      Mohana Priya K
 -->

<%-- JSP Page specific attributes start --%>
<%@ page    contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eBL/js/BLInvoiceReport.js'></script>		
<html>
<head>
<%
	  String sStyle	=
	 (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<%
    	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%= source %>' frameborder=0 scrolling='no' noresize style='height:10vh;width:100vw'></iframe>
	<iframe name='invoice_report' id='invoice_report' id='summaryreport' src='BLInvoiceReports.jsp'  frameborder=0 style='height:80vh;width:100vw'></iframe>
	<iframe name="dummy_frame" id="dummy_frame" src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:0vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
	<body>
	</form>	
	</body>	
</html>

