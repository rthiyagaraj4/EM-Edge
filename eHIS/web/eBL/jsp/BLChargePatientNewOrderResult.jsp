<!DOCTYPE html>
<!-- 
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210324             15760          MOHE-SCF-0091                  Shikha Seth
2	      	V220404			     27973			MMS-ME-SCF-0046-TF					Mohana Priya K
 -->
<%@page import="java.math.BigDecimal"%>
<%@page import="eBL.placeorder.model.BLChargePatientNewOrderBean"%>
<%@page import="eBL.placeorder.response.PlaceNewOrderResponse"%>
<%@page import="eBL.placeorder.request.PlaceNewOrderRequest"%>
<%@page import="eBL.placeorder.bc.PlaceOrderBC"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.sql.Connection"%>
<%@page import="webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Results</title>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<link rel="stylesheet" type="text/css"	href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../../eBL/js/BLChargeEncounterNewOrder.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	$(document).ready(function(){
		
		if($('#traverse').val() == 'Y'){
			$('#trProgress').show();
		}else{
			$('#trProgress').hide();
		}
		
		if($('#hdnNextSpan').val() == 'Y'){
			$('#nextSpan').show();
		}else{
			$('#nextSpan').hide();
		}
		
		if($('#prevSpan').val() == 'Y'){
			$('#previousSpan').show();
		}else{
			$('#previousSpan').hide();
		}
		
		var noOfDecimals = $(parent.BLChargePatientEncounterTab.document).find('#noOfDecimals').val();	
		
				
				$('[id^=minimumAmt_]').each(function(){					
					if($.trim($(this).text() != '')){					
						putDecimal_Text($(this),17,noOfDecimals);			
					}
					else{						
						$(this).text('0');
						putDecimal_Text($(this),17,noOfDecimals);
					}				
			});	
				$('[id^=basePrice_]').each(function(){					
					if($.trim($(this).text() != '')){						
						putDecimal_Text($(this),17,noOfDecimals);			
					}
					else{						
						$(this).text('0');
						putDecimal_Text($(this),17,noOfDecimals);
					}				
			});				
		
		$('#nextSpan').click(function(){
			var startFrom = parseInt($('#fromRcrd').val())+parseInt($('#constCount').val());
			var endWith = parseInt($('#toRcrd').val())+parseInt($('#constCount').val());
			document.location.href = 'BLChargePatientNewOrderResult.jsp?servGroup='+$('#servGroup').val()+
			'&classification='+$('#classification').val()+
			'&servOrPanel='+$('#servOrPanel').val()+
			'&servPanelCode='+$('#servPanelCode').val()+
			'&servPanelDesc='+$('#servPanelDesc').val()+
			'&fromRcrd='+startFrom+
			'&toRcrd='+endWith;
		});
		$('#previousSpan').click(function(){
			var startFrom = parseInt($('#fromRcrd').val())-parseInt($('#constCount').val());
			var endWith = parseInt($('#toRcrd').val())-parseInt($('#constCount').val());
			document.location.href = 'BLChargePatientNewOrderResult.jsp?servGroup='+$('#servGroup').val()+
			'&classification='+$('#classification').val()+
			'&servOrPanel='+$('#servOrPanel').val()+
			'&servPanelCode='+$('#servPanelCode').val()+
			'&servPanelDesc='+$('#servPanelDesc').val()+
			'&fromRcrd='+startFrom+
			'&toRcrd='+endWith;
		});
	});
</script>
<%!
	private String checkForNull(String input){
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
	}
	private BigDecimal checkForNull(BigDecimal input){
		if(input == null || "null".equals(input)){
			input = new BigDecimal(0);
		}
		return input;
	}
	private String decodeParam(String input){
		String output = "";
		if(input!=null){
			output = URLDecoder.decode(input);
		}
		return output;
	}
%>
<%
	request= new XSSRequestWrapper(request);
	 response.addHeader("X-XSS-Protection", "1; mode=block");
	 response.addHeader("X-Content-Type-Options", "nosniff");
	 //V220404 ends
String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String loginUser = (String) session.getValue("login_user"); //V210324
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	String servGroup = checkForNull(request.getParameter("servGroup"));
	String classification = checkForNull(request.getParameter("classification"));
	if("**".equals(classification)){
		classification = "";
	}

	String servOrPanel = checkForNull(request.getParameter("servOrPanel"));
	String servPanelCode = decodeParam(request.getParameter("servPanelCode"));
	String servPanelDesc = request.getParameter("servPanelDesc");
	//For Traversal
	int constCount = 50;
	String nextYn = "N";
	String prevYn = "N";
	String traversal = "N";
	String fromRcrd = "";
	String toRcrd = "";
	int startIndex = 0;
	int startRcrd = 0;
	int endRcrd = 0;
	int totalRecord=0;

	fromRcrd = checkForNull(request.getParameter("fromRcrd"));
	toRcrd = checkForNull(request.getParameter("toRcrd"));

	if(fromRcrd == null || "".equals(fromRcrd)){
		startRcrd = 1;
	}
	else{
		startRcrd = Integer.parseInt(fromRcrd);
	}
		
	if(toRcrd == null || "".equals(toRcrd)){
		endRcrd = constCount;
	}
	else{
		endRcrd = Integer.parseInt(toRcrd);
	}
	startIndex = startRcrd;

	//For Traversal
	PlaceNewOrderRequest requestBean = new PlaceNewOrderRequest();
	LinkedHashMap servDtlsMap = null;
	BLChargePatientNewOrderBean bean = null;
	PlaceNewOrderResponse responseBean = null;
	PlaceOrderBC placeOrderBC = new PlaceOrderBC(); 
	try{
		requestBean.setFacilityId(facility_id);
		requestBean.setServGroupCode(servGroup);
		requestBean.setServClass(classification);
		requestBean.setServOrPanel(servOrPanel);
		requestBean.setServPanelCode(servPanelCode);
		requestBean.setServPanelDesc(servPanelDesc);
		requestBean.setStartFrom(startRcrd);
		requestBean.setEndWith(endRcrd);
		requestBean.setLocale(locale);//V210324
		requestBean.setLoginUser(loginUser);//V210324
		responseBean = placeOrderBC.getServicePkgDtls(requestBean);
		servDtlsMap = responseBean.getNewServiceDetails();
		totalRecord = responseBean.getTotalRecordCount();
		System.err.println("servDtlsMap="+servDtlsMap);
		System.err.println("totalRecord="+totalRecord);
		if(startRcrd>1){
			prevYn = "Y";
			traversal = "Y";
		}		
		if((startRcrd+constCount) < totalRecord){
			nextYn = "Y";
			traversal = "Y";
		}
	}
	catch(Exception e){
		System.err.println("Exception in getting Result ->"+e);
		e.printStackTrace();
	}
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<style>
	div.tableContainer {
		width: 100%;		/* table width will be 99% of this*/
		height: 160px; 	/* must be greater than tbody*/
		overflow: auto;
		margin: 0 auto;
	}

	table {
		width: 100%;		/*100% of container produces horiz. scroll in Mozilla*/
		border: none;
		background-color: #f7f7f7;
		}
		
	table>tbody	{  /* child selector syntax which IE6 and older do not support*/
		overflow: auto; 
		height: 120x;
		overflow-x: hidden;
		}
		
	thead tr	{
		position:relative; 
		top: expression(offsetParent.scrollTop); /*IE5+ only*/
		}
			
			div.tableContainer {
			width: 100%;		/* table width will be 99% of this*/
			height: 140px; 	/* must be greater than tbody*/
			overflow: scroll;
			margin: 0 auto;
		}	
		TD.YELLOW 
		{			
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			border-style: dashed;
			border-left-color: #D5E2E5;
			border-right-color: #D5E2E5;
			border-top-color: #D5E2E5;
			border-bottom-color: #D5E2E5; 
		}
		
		.LocalYellow
		{
			COLOR:#444444;
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			border: 1x;
			border-style: dashed;
			border-left-color: #D5E2E5;
			border-right-color: #D5E2E5;
			border-top-color: #D5E2E5;
			border-bottom-color: #D5E2E5; 
			/* PADDING-LEFT:7px;
  			PADDING-RIGHT:7px */
		}
	SPAN.LABEL
	{
	  COLOR:#444444;
	  /*background-color:#FFFFFF;*/
	  background-color:#FFFFFF;
	  FONT-SIZE: 8pt;
	  TEXT-ALIGN: LEFT;
	  /*TEXT-ALIGN: RIGHT;*/
	  /* PADDING-LEFT:7px;
	  PADDING-RIGHT:7px */
	}

	SPAN.LABEL1
	{
	  COLOR:#444444;
	  /*background-color:#FFFFFF;*/
	  background-color:#FFFFFF;
	  FONT-SIZE: 8pt;
	  /*TEXT-ALIGN: LEFT;*/
	  TEXT-ALIGN: RIGHT;
	  /* PADDING-LEFT:7px;
	  PADDING-RIGHT:7px */
	}

	SPAN.SpanYellow
	{
		COLOR:#444444;
		BACKGROUND-COLOR: yellow ;
		FONT-SIZE: 8pt ;
		/* PADDING-LEFT:7px;
		PADDING-RIGHT:7px */
	}
</style>
</head>
<body>	
	<form name='chargePatientNewOrderResult' id='chargePatientNewOrderResult'>				
	<div id="tableContainer">
		<table border='' cellpadding='3' cellspacing='0'  id='tbl' width='100%'>	
		<thead style="position: sticky;z-index: 1;top: 0;">
		<tr style="background-color: white; border: none;" id='trProgress'>
		
				<td colspan='12'  align='right' bordor=0 >
					<span class="LABEL" style="font-weight: normal; color: blue; cursor: pointer; cursor:pointer ">
						<span id='previousSpan'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></span>
					</span>
					
					<span class="LABEL" style="font-weight: normal; color: blue; cursor: pointer; cursor:pointer ">
						<span id='nextSpan' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></span>
					</span>
				</td>					
		</tr>				
		<tr>
			<td class='COLUMNHEADER' width='30%' nowrap="nowrap">
				<fmt:message key="eBL.ServiceCode.label" bundle="${bl_labels}"/> &nbsp;
				<a id="resizeLink" href='javascript:resultResizeFrames()' style="visibility: visible;"><img id="resizeBtn" alt="" src="../../eOT/images/ShowLess.gif" style="visibility: visible;"> </a>
				<a id="resetLink" href='javascript:resultResetFrames()' style="visibility: hidden;"><img id="resetBtn" alt="" src="../../eOT/images/ShowMore.gif" style="visibility: hidden;"></a>				
			</td>
			<td class='COLUMNHEADER' width='40%' nowrap="nowrap">
				<fmt:message key="eBL.ServiceDescription.label" bundle="${bl_labels}"/>
			</td>
			<td class='COLUMNHEADER' width='15%' nowrap="nowrap">
				<fmt:message key="eBL.BILLING_SERVICE_PANEL.label" bundle="${bl_labels}"/>
			</td>
			<td class='COLUMNHEADER' width='15%' nowrap="nowrap">
				<fmt:message key="eBL.BL_RATE_CHARGE_TYPE.label" bundle="${bl_labels}"/>
			</td>
			
		<%if("S".equals (servOrPanel)){%>
			<td class='COLUMNHEADER' width='15%' nowrap="nowrap">
				<fmt:message key="eBL.BASE_PRICE.label" bundle="${bl_labels}"/>
			</td>
			<td class='COLUMNHEADER' width='15%' nowrap="nowrap">
				<fmt:message key="eBL.PRINT_GROUP.label" bundle="${bl_labels}"/>
			</td>
			<td class='COLUMNHEADER' width='15%' nowrap="nowrap">
				<fmt:message key="eBL.PRINT_LINE.label" bundle="${bl_labels}"/>
			</td>
			<td class='COLUMNHEADER' width='15%' nowrap="nowrap">
				<fmt:message key="eBL.DIR_ENTRY.label" bundle="${bl_labels}"/>
			</td>
			
			<td class='COLUMNHEADER' width='15%' nowrap="nowrap">
				<fmt:message key="eBL.DR_FEE.label" bundle="${bl_labels}"/>
			</td>
			<td class='COLUMNHEADER' width='15%' nowrap="nowrap">
				<fmt:message key="eBL.MISC_SERV.label" bundle="${bl_labels}"/>
			</td>
				<td class='COLUMNHEADER' width='15%' nowrap="nowrap">
				<fmt:message key="eBL.MINIMUM_AMOUNT.label" bundle="${bl_labels}"/>
			</td>
	<%} %>				
		</tr>
		</thead>
		<tbody>
		<%
		if(servDtlsMap!=null){
			Iterator iterator= servDtlsMap.keySet().iterator();
			int index = 0;
			int sNo = 0;
			while(iterator.hasNext())
			{
				index =    (Integer)iterator.next();
				sNo	  =		index+1;
				bean =  (BLChargePatientNewOrderBean) servDtlsMap.get(index);
		%>
		<tr id='resultTr_<%=sNo%>'>
			<td class='LABEL' nowrap="nowrap" width='30%'>
				<span id='servCode_<%=sNo %>' style="color: blue; cursor: pointer;" onclick='loadServiceDetails("<%=sNo%>")'><%=checkForNull(bean.getBlngServCode()) %></span>
			</td>
			<td id='servDesc_<%=sNo %>' class='LABEL' nowrap="nowrap" width='40%'>
				<%=checkForNull(bean.getBlngServDesc()) %>
			</td>
			<td class='LABEL' nowrap="nowrap" width='15%'>
				<%if("S".equals(checkForNull(bean.getServOrPanel()))){ %>
					<span id='servOrPanel_<%=sNo %>'>Service</span>
				<%} else{ %>
					<span id='servOrPanel_<%=sNo %>'>Panel</span>
				<%} %>
			</td>
			<td class='LABEL' nowrap="nowrap" width='15%'>
				<%if("R".equals(checkForNull(bean.getRateIndicator()))){ %>
					<span id='rateInd_<%=sNo %>'>Rate</span>
				<%} else{ %>
					<span id='rateInd_<%=sNo %>'>Charge</span>
				<%} %>
			</td>
			<%
			if("S".equals (servOrPanel)){
			%>
			<td id='basePrice_<%=sNo %>' class='LABEL'  nowrap="nowrap" width='40%' style='text-align:right'>
				<%= checkForNull(bean.getBasePrice()) %>
			</td>
			<td id='printGrp_<%=sNo %>' class='LABEL' nowrap="nowrap" width='40%'>
				<%=checkForNull(bean.getPrintGroup()) %>
			</td>
			<td id='printLine_<%=sNo %>' class='LABEL' nowrap="nowrap" width='40%'>
				<%=checkForNull(bean.getPrintLine()) %>
			</td>
			<td id='dirEntry_<%=sNo %>' class='LABEL' nowrap="nowrap" width='40%'>
				<%=checkForNull(bean.getDirEntry()) %>
			</td>
			
			<td id='drFee_<%=sNo %>' class='LABEL' nowrap="nowrap" width='40%'>
				<%=checkForNull(bean.getDrFee()) %>
			</td>
			<td id='miscServ_<%=sNo %>' class='LABEL' nowrap="nowrap" width='40%'>
				<%=checkForNull(bean.getMiscServ()) %>
			</td>
			<td id='minimumAmt_<%=sNo %>'  class='LABEL' nowrap="nowrap" width='40%' style='text-align:right' >
				<%=checkForNull(bean.getMinimumAmt()) %>
			</td>
			<%} %>
		</tr>
		<%		
			}
			
		if(sNo==0){%>
			<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
			</script>
		<%}
		}
	%>
	</table>
	<input type='hidden' name='prevClicked'  id='prevClicked' value=''>
	<input type='hidden' name='hdnNextSpan'  id='hdnNextSpan' value='<%=nextYn %>'>
	<input type='hidden' name='prevSpan' id='prevSpan' value='<%=prevYn %>'>
	<input type='hidden' name='traverse'  id='traverse' value='<%=traversal%>'>
	
	<input type='hidden' name='servGroup'  id='servGroup' value='<%=servGroup %>'>
	<input type='hidden' name='classification'  id='classification' value='<%=classification %>'>
	<input type='hidden' name='servOrPanel'  id='servOrPanel' value='<%=servOrPanel %>'>
	<input type='hidden' name='servPanelCode' id='servPanelCode' value='<%=servPanelCode%>'>		
	<input type='hidden' name='servPanelDesc' id='servPanelDesc' value='<%=servPanelDesc%>'>
	<input type='hidden' name='fromRcrd'  id='fromRcrd' value='<%=startRcrd %>'>
	<input type='hidden' name='toRcrd'  id='toRcrd' value='<%=endRcrd %>'>
	<input type='hidden' name='constCount' id='constCount' value='<%=constCount %>'>		
	</form>
<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'></div>
</body>
</TBODY>	
</div>
</html>

