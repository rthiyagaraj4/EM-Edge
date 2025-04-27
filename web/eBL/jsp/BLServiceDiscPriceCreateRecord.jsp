<!DOCTYPE html>
<!-- Page Added by Rajesh V. Price Discount Create Record -->

<%@page import="eBL.BlServiceDiscPriceBean"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>

<%@page import="eBL.Common.BlRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%!
     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	
	String param = request.getQueryString();
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="eBL.PriceDetails.label" bundle="${bl_labels }"></fmt:message></title>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/BLServiceDiscountPrice.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

	<iframe name="BLServiceDiscPrice" id="BLServiceDiscPrice" src='../../eBL/jsp/BLAmendMultiServicePriceMain.jsp?<%=param %>' noresize="noresize" frameborder=0 style='height:34vh;width:99vw'></iframe>
	<iframe name="BLMultiPricedtls" id="BLMultiPricedtls" src='../../eBL/jsp/BLAmendMultiServicePriceDtls.jsp?<%=param %>'  noresize="noresize" frameborder=0 style='height:30vh;width:99vw'></iframe> 
	<iframe name="BLMultiDiscPrice" id="BLMultiDiscPrice" src='../../eCommon/html/blank.html'  noresize="noresize" frameborder=0 style='height:20vh;width:99vw'></iframe> 
	<iframe name="RecordPriceDisc" id="RecordPriceDisc" src='../../eBL/jsp/BLRecordAmendprice.jsp?<%=param %>'  noresize="noresize" frameborder=0 style='height:5vh;width:99vw'></iframe> 
	<iframe name='messageFrame1' id='messageFrame1'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize="noresize" scrolling='auto' noresize style='height:9vh;width:99vw'></iframe> 

</html>

