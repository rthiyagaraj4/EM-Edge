<!DOCTYPE html>
<%@page import="eIP.advbedmgmt.common.resourcebundle.BundleManager"%>
<%@page import="eCommon.Common.CommonBean"%>
<%@page import="eIP.advbedmgmt.common.model.BedLegend"%>
<%@page import="java.util.List"%>
<%@page import="eIP.advbedmgmt.common.bedlegend.response.BedLegendResponse"%>
<%@page import="eIP.advbedmgmt.common.bedlegend.bc.BedLegendBC"%>
<%@page import="eIP.advbedmgmt.common.bedlegend.BedLegendConstants"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="eIP.advbedmgmt.GBMConstants"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="eIP.advbedmgmt.common.bedlegend.request.BedLegendRequest"%>
<%@page import="eIP.advbedmgmt.common.model.BedStatusEnum"%><!--Added By Dharma on 16th Mar 2016-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<% String sStyle = (String)session.getAttribute("PREFERRED_STYLE");
	sStyle = CommonBean.checkForNull(sStyle, "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<link rel='stylesheet' type='text/css'
	href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<link type="text/css" rel="stylesheet"
	href="../../eIP/html/IPAdvBedMgmtStyle.css" />

</head>
<%
BedLegendRequest bedLegendRequest = new BedLegendRequest();
ApplicationContext context = new ClassPathXmlApplicationContext(GBMConstants.SPRING_BEANS_XML_NAME);
BedLegendBC bcInst = (BedLegendBC)context.getBean(BedLegendConstants.LEGEND_BC_NAME);
BedLegendResponse bedLegendResponse = bcInst.getBedLegend(bedLegendRequest);

String errorMessage = bedLegendResponse.getErrorMessage();
String roomBackgndColor = bedLegendResponse.getRoomBackgroundColor();

/* String dischargeBillPrepMesg = BundleManager.getInstance().getMessageFromResourceBundle(
			BedLegendConstants.DISCHARGE_BILL_PREPARED_MESG_KEY, 
			BedLegendConstants.BEDLEGEND_LABELS_RESOURCE_CLASSNAME); */
%>
<body style="height:100%;background: #<%=roomBackgndColor%>;">
<form name='legendForm' id='legendForm'>
<table id="legendDiv" style="width:100%;height:100%;background: #<%=roomBackgndColor%>;">

<%
//response is successful - render the legend
if(bedLegendResponse.isSuccessful()){
	List<BedLegend> legends = bedLegendResponse.getLegends();
	
	final int ROW_COMP_COUNT = 7;
	int counter = 1;
	
	String innerDivStyle = "";
	
%>

	<!-- <div id="tablediv" style="width:100%;display:table;"> -->
	
	<tr>
		<!-- <div style="display:table-row;"> -->
	
<%	
	String color = "";
	String desc = "";
	String txtColor = "";	//Added By Dharma on 16th Mar 2016
	BedStatusEnum legendIdentifier = null;	//Added By Dharma on 16th Mar 2016
	for(BedLegend bedLegend:legends){
		if(counter > ROW_COMP_COUNT){
			%>
		</tr>
		<tr>	
		<!-- </div>
		<div style="display:table-row;"> -->
			<%
			counter = 1;
		}
		
		color = bedLegend.getLegendColor();
		desc = bedLegend.getLegendDescription();
		txtColor = bedLegend.getTextColor();
		legendIdentifier	= (BedStatusEnum)bedLegend.getLegendIdentifier();
		
		%>
		<td style="background: #<%=color%>;width:3%;"></td>
		<td style="font-size: 8pt;"><%=desc %></td>
		<input type='hidden' id="hid_<%=legendIdentifier%>" value="<%=txtColor%>" />	<!--Added By Dharma on 16th Mar 2016-->
		<%-- <div style="display:table-cell;background: #<%=color%>;width:5%;"></div> --%>
		<%-- <div style="display:table-cell;"><%=desc %></div> --%>
		<%
		counter++;
	}
%>

		</tr>	
		<!-- </div>
    </div> -->


<%
}else{
	// failure response
%>
<tr>
<td style="width:100%;">
<span style="color: #000000;"><%=errorMessage %> </span>

</td>
</tr>

<%	
}
%>



</table>
</form>
</body>
</html>

