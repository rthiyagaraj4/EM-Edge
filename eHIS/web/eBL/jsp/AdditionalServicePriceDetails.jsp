<!DOCTYPE html>
<!--
Sr No        Version         TFS              SCF/CRF           			Developer Name
----------------------------------------------------------------------------------------------
1			 V211109		7871			MMS-QH-CRF-0128				   Manivel Natarajan
-->

<%@page import="java.net.URLDecoder"%>
<%@ 
page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*, eBL.AdditionalServiceDetailsBean " contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eBL/js/AdditionalServiceDetailsScript.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

var headTop = -1;
var FloatHead1;
function processScroll()
	{
		if (headTop < 0)
		{
			saveHeadPos();
			
		}
		if (headTop>0)
		{
			if (document.documentElement && document.documentElement.scrollTop)
				theTop = document.documentElement.scrollTop;
			else if (document.body)
				theTop = document.body.scrollTop;

			if (theTop>headTop)
				FloatHead1.style.top = (theTop-headTop) + 'px';
			else
				FloatHead1.style.top = '0px';
		}
	}

	function saveHeadPos()
	{
		parTable = document.getElementById("divHeadSep");
		if (parTable != null)
		{
			headTop = parTable.offsetTop + 3;
			FloatHead1 = document.getElementById("heading");
			FloatHead1.style.position = "relative";
		}
	}
	
	function lockKey()
	  {
		 	 
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	  }

	  function lockbackSpace()
	  {
		// alert(document.order_type_form.mode.value);
		   var mode = document.mode.value;
      // alert(window.event.keyCode);
		 if(mode=='modify' && window.event.keyCode==8)
		  {
           //return false;
		  }
	  }
	 
	
	
</script>
</head>
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
		</style>
<%
//System.out.println("=======================came========================");
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
response.setHeader("Pragma","no-cache"); //HTTP 1.0   
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
//String applyMode																			=	new String();//checklist
String locale																				=	"";
String facilityId																			=	"";
//String loggedInUser																			=	"";//checklist
String mode																					=	"";
mode																						=	"";
String isUserCanAcess																		=	"";
String bean_id																				=	"";
String bean_name																			=	"";
//String modifyStatus     																	=	"";//checklist
String service_ind																			=	"";
String service_code																			=	"";
String price_code																			=	"";
String service_description																	=	"";
String price_ind																			=	"";
String price_description																	=	"";
String billing_class																		=	"";
String Effective_from																			=	"";
String Effective_to																			=	"";
String charge_type																			=	"";
String disc_applicability																	=	"";
String Desc																					=	"";
StringBuffer sql																			=	null;
//ArrayList<String[]>		serviceDataList														=	null;//checklist
LinkedHashMap			recordPriceDetailsDataMap											=	null;
//String disable																				=	"READONLY";//checklist
//Added By Rajesh V
String fromRcrd = "";
int startIndex = 0;
String toRcrd = "";
int startRcrd = 0;
int endRcrd = 0;
int totalRecord=0;
int constCount = 500;
String nextYn = "N";
String prevYn = "N";
//Added By Rajesh V

try  
{
	 
	sStyle 																					=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 																					= 	(String)session.getAttribute("LOCALE");
	facilityId																				=   (String) session.getValue( "facility_id" ) ;
	service_ind																				=	checkForNull(request.getParameter("serviceIndicator"));
	service_code																			=	checkForNull(request.getParameter("serviceCode"));
	price_code																				=	checkForNull(request.getParameter("priceCode"));
	service_description																		=	decodeParam(request.getParameter("serviceDescription"));
	price_ind																				=	checkForNull(request.getParameter("priceInd"));
	price_description																		=	decodeParam(request.getParameter("priceDescription"));
	billing_class																			=	checkForNull(request.getParameter("billingClass"));
	Effective_from																			=	checkForNull(request.getParameter("EffectiveFrom"));
	Effective_to																			=	checkForNull(request.getParameter("EffectiveTo"));
	charge_type																				=	checkForNull(request.getParameter("chargeType"));
	disc_applicability																		=	checkForNull(request.getParameter("discApplicability"));
	Desc																					=	checkForNull(request.getParameter("Description"));
	//Added By Rajesh V
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
	//Added By Rajesh V
	sql																						=	new StringBuffer();
	recordPriceDetailsDataMap																=   new LinkedHashMap();
	System.out.println("<<<<<<serviceIndicator IN AdditionalServicePriceDetails.jsp::::>> "+service_ind);
	//System.out.println("<<<<<price_ind IN AdditionalServicePriceDetails.jsp::::>> "+price_ind);
	bean_id																					= 	"AdditionalServiceDetailsBean" ;
	bean_name																				= 	"eBL.AdditionalServiceDetailsBean";
	AdditionalServiceDetailsBean additionalServiceDetailsBean								= 	(AdditionalServiceDetailsBean)getBeanObject( bean_id, bean_name, request ) ;
	isUserCanAcess																			= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));
	//System.out.println("<<<<<<facilityId IN AdditionalServicePriceDetails.JSP::::>>>>>>> "+facilityId);

	recordPriceDetailsDataMap																=	additionalServiceDetailsBean.getPriceDetailsData(service_ind,service_code,price_ind,price_code,billing_class,Effective_from,Effective_to,charge_type,Desc, disc_applicability,facilityId, locale, startRcrd, endRcrd);		

	if(recordPriceDetailsDataMap.containsKey("totalRecords"))
	totalRecord =  (Integer) recordPriceDetailsDataMap.get("totalRecords");
	
	recordPriceDetailsDataMap.remove("totalRecords");
	
%>
<body onScroll="processScroll();" onKeyDown= "lockKey();" onMouseDown="CodeArrest();"  onSelect="codeArrestThruSelect();" >
	<form id="additionalServicePriceDetails" name="additionalServicePriceDetails" id="additionalServicePriceDetails">	


	
		

				<% if(!(startRcrd<=1)){
					prevYn = "Y";
				}
		
				if ( !( (startRcrd+constCount) > totalRecord ) ){
					nextYn = "Y";
				}
				
				%>

<script>
	loadTraverseFrame("<%=service_ind %>","<%=service_code %>","<%=service_description %>","<%=price_ind %>","<%=price_code %>","<%=price_description %>",
			"<%=billing_class %>","<%=Effective_from %>","<%=Effective_to %>","<%=charge_type %>","<%=disc_applicability %>",
			"<%=Desc %>","<%=startRcrd %>","<%=endRcrd %>","<%=constCount %>","<%=prevYn %>","<%=nextYn %>");
</script>
	<table cellpadding=3 cellspacing=0  width="100%" id="panel_categories_header_table" name="panel_categories_header_table" id="panel_categories_header_table" border="1"  >	 
	<div id="tableContainer">
		<thead>
		<TR style="position: sticky; top: 0; background-color: white; z-index: 1;">	
			<td class='COLUMNHEADER'	width='4%'	align="left"	><fmt:message key="Common.SrlNo.label" 					bundle="${common_labels}"	/></td>
			<td class='COLUMNHEADER'	width='4%'	align="left"	><fmt:message key="Common.facility.label" 				bundle="${common_labels}"	/></td>
			<td class='COLUMNHEADER' 	width='10%'	align="left"	><fmt:message key="eBL.ServiceInd.label" 					bundle="${bl_labels}"	/></td>
			<td class='COLUMNHEADER' 	width='6%'	align="left"	><fmt:message key="eBL.ServiceCode.label" 				bundle="${bl_labels}"	/></td>
			<td class='COLUMNHEADER' 	width='12%'	align="left"	><fmt:message key="eBL.ServiceDescription.label" 			bundle="${bl_labels}"	/></td>
			<td class='COLUMNHEADER' 	width='8%'	align="left"	><fmt:message key="eBL.PriceInd.label" 					bundle="${bl_labels}"	/></td>
			<td class='COLUMNHEADER' 	width='8%'	align="left"	><fmt:message key="eBL.PriceIndCode.label" 				bundle="${bl_labels}"	/></td>
			<td class='COLUMNHEADER' 	width='12%'	align="left"	><fmt:message key="eBL.PriceIndDescription.label" 		bundle="${bl_labels}"	/></td>
			<td class='COLUMNHEADER' 	width='6%'	align="left"	><fmt:message key="eBL.PolicyCode.label" 					bundle="${bl_labels}"		/></td>
			<td class='COLUMNHEADER' 	width='12%'	align="left"	><fmt:message key="eBL.PolicyDesc.label" 					bundle="${bl_labels}"	/></td>
			<td class='COLUMNHEADER' 	width='6%'	align="left"	><fmt:message key="eBL.CustGroupCode.label" 				bundle="${bl_labels}"		/></td>
			<td class='COLUMNHEADER' 	width='12%'	align="left"	><fmt:message key="eBL.CustGroupDesc.label"				bundle="${bl_labels}"		/></td>
		</TR>
</thead>

	
	<TBODY>

	<%
	
		//System.out.println("<<<<<<<<<IN AdditionalServicePriceDetails.jsp recordPriceDetailsDataMap::::::::>>>>>>"+recordPriceDetailsDataMap);
		System.out.println("<<<<<<<<<IN AdditionalServicePriceDetails.jsp recordPriceDetailsDataMap:size:::::::>>>>>>"+recordPriceDetailsDataMap.size()); 

		Iterator iterator= recordPriceDetailsDataMap.keySet().iterator();
		/*int tempCnt = 0;
		if(startRcrd != 1){
			for(int i=1;i<startRcrd;i++,counter++){
				if(iterator.hasNext())	tempCnt = (Integer)iterator.next();
			}
		}*/
		String serviceIndKey = "";
		//String serviceIndValue = "";//checklist
		String priceIndKey = "";
		//String priceIndValue = "";//checklist
		while(iterator.hasNext())
		{
			
			int index =    (Integer)iterator.next();
			int sNo	  =		index+1;

			//System.out.println("<<<<<<<<<<<<IN getScreenServiceCriteria index>>>>>>>"+index);
			additionalServiceDetailsBean = (AdditionalServiceDetailsBean) recordPriceDetailsDataMap.get(index);  
				
	
	%>
	
			<tr onclick="changeFieldColor('<%=sNo%>'); showPriceDetailsData('<%=index%>');" >
				<td class="fields"	width='4%'   id="srl_no<%=index%>"						name="srl_no<%=index%>"	> 							<%=startIndex%></td>
				<td class="fields"	width='4%'   id="facility_id<%=index%>"					name="facility_id<%=index%>"	> 					<%=additionalServiceDetailsBean.getFacilityId()					!=null ? 	additionalServiceDetailsBean.getFacilityId()		: 	"" %> </td>
				<td class="fields"	width='10%'   id="service_ind_val<%=index%>"					name="service_ind_val<%=index%>">
<%
					serviceIndKey = additionalServiceDetailsBean.getServiceInd() !=null ? additionalServiceDetailsBean.getServiceInd() : "";
					System.out.println("Message serviceIndKey:"+serviceIndKey);
					if(serviceIndKey !=null && serviceIndKey.equalsIgnoreCase("BSG"))
					{
%>
						<fmt:message key="eBL.BillingServiceGroup.label" bundle="${bl_labels}"></fmt:message>
<%
					}
					else if(serviceIndKey !=null && serviceIndKey.equalsIgnoreCase("BSC"))
					{
%>
						<fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}"></fmt:message>
<%
					}
					else if(serviceIndKey !=null && serviceIndKey.equalsIgnoreCase("B"))
					{
%>
						<fmt:message key="eBL.BillingService.label" bundle="${bl_labels}"></fmt:message>
<%
					}
					else if(serviceIndKey !=null && serviceIndKey.equalsIgnoreCase("PG"))
					{
%>
						<fmt:message key="eBL.PackageGrouping.label" bundle="${bl_labels}"></fmt:message>
<%
					}
%>
					&nbsp;
				</td>
				<td class="fields"  width='6%'   id="service_code<%=index%>"				name="service_code<%=index%>">						<%=additionalServiceDetailsBean.getserviceCode()				!=null ? 	additionalServiceDetailsBean.getserviceCode()		: 	"" %>&nbsp;</td> 
				<td class="fields"	width='12%'   id="service_description<%=index%>"			name="service_description<%=index%>">				<%=additionalServiceDetailsBean.getServiceDesc()	 			!=null 	? 	additionalServiceDetailsBean.getServiceDesc()		: 	"" %>&nbsp; </td>
				<td class="fields"	width='8%'   id="price_ind_val<%=index%>"					name="price_ind_val<%=index%>">	
									<%-- 	<%=additionalServiceDetailsBean.getPriceInd() 					!=null 	? 	additionalServiceDetailsBean.getPriceInd()			: 	"" %>&nbsp; </td> --%> 
				<%
				priceIndKey = additionalServiceDetailsBean.getPriceInd() !=null ? additionalServiceDetailsBean.getPriceInd() : "";
					if(priceIndKey !=null && priceIndKey.equalsIgnoreCase("S"))
					{
%>
						<fmt:message key="Common.Standard.label" bundle="${common_labels }"></fmt:message>
<%
					}
					else if(priceIndKey !=null && priceIndKey.equalsIgnoreCase("C"))
					{
%>
						<fmt:message key="Common.Customer.label" bundle="${common_labels }"></fmt:message>
<%
					}
					else if(priceIndKey !=null && priceIndKey.equalsIgnoreCase("B"))
					{
%>
						<fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels}"></fmt:message>
<%
					}
					else if(priceIndKey !=null && priceIndKey.equalsIgnoreCase("P"))
					{
%>
						<fmt:message key="eBL.HCMasterPriceClass.label" bundle="${bl_labels}"></fmt:message>
<%
					}
%>
					&nbsp;
				</td>
				<td class="fields"	width='8%'   id="price_code<%=index%>"					name="price_code<%=index%>">	 					<%=additionalServiceDetailsBean.getPriceCode()					!=null 	? 	additionalServiceDetailsBean.getPriceCode()			: 	"" %>&nbsp; </td> 
				<td class="fields"	width='12%'   id="price_description<%=index%>"		 	name="price_description<%=index%>">	 				<%=additionalServiceDetailsBean.getPriceDesc()					!=null 	? 	additionalServiceDetailsBean.getPriceDesc()			: 	"" %>&nbsp;</td>
				<td class="fields"	width='6%'   id="policy_code<%=index%>"					name="policy_code<%=index%>">						<%=additionalServiceDetailsBean.getPolicyCode()					!=null 	? 	additionalServiceDetailsBean.getPolicyCode()		: 	"" %>&nbsp;</td> 
				<td class="fields"	width='12%'   id="policy_desc<%=index%>"		 			name="policy_desc<%=index%>">						<%=additionalServiceDetailsBean.getPolicyDesc()  				!=null 	? 	additionalServiceDetailsBean.getPolicyDesc()		: 	"" %>&nbsp;</td> 
				<td class="fields"	width='6%'   id="cust_code<%=index%>"		 			name="cust_code<%=index%>"	>	    				<%=additionalServiceDetailsBean.getCustCode()					!=null 	? 	additionalServiceDetailsBean.getCustCode()			: 	"" %>&nbsp;</td>
				<td class="fields"	width='12%'   id="cust_desc<%=index%>"		 			name="cust_desc<%=index%>">	    					<%=additionalServiceDetailsBean.getCustDesc()					!=null 	? 	additionalServiceDetailsBean.getCustDesc()			: 	"" %>&nbsp;</td>
				<input type="hidden"	id="facility<%=index%>"			name="facility<%=index%>"				value="<%=additionalServiceDetailsBean.getFacilityId()					!=null ? 	additionalServiceDetailsBean.getFacilityId()		: 	"" %>" /> <!--//Added NMC-JD-CRF-0014 by shikha on 200902 -->
				<input type="hidden"	id="price_ind<%=index%>"			name="price_ind<%=index%>"				value="<%=additionalServiceDetailsBean.getPriceInd()					!=null ? 	additionalServiceDetailsBean.getPriceInd()			: 	"" %>" />
				<input type="hidden"	id="service_ind<%=index%>"			name="service_ind<%=index%>"			value="<%=additionalServiceDetailsBean.getServiceInd()					!=null ? 	additionalServiceDetailsBean.getServiceInd()		: 	"" %>" />
				<input type="hidden" 	id="billing_class<%=index%>" 		name="billing_class<%=index%>" 	 	 	value="<%=billing_class !=null ? billing_class : "" %>" />
				<input type="hidden" 	id="Effective_to<%=index%>" 		name="Effective_to<%=index%>" 	 		value="<%=Effective_to%>" />
				<input type="hidden" 	id="charge_type<%=index%>" 			name="charge_type<%=index%>" 	 	 	value="<%=charge_type						!=null 	? 	charge_type				: 	"" %>" />
				<input type="hidden" 	id="Desc<%=index%>" 				name="Desc<%=index%>" 	 				value="<%=Desc 							!=null 	? 	Desc						: 	"" %>" />
				<input type="hidden" 	id="Effective_from<%=index%>" 		name="Effective_from<%=index%> "  		value="<%=Effective_from					!=null 	? 	Effective_from				: 	"" %>" />
				<input type="hidden" 	id="disc_applicability<%=index%>" 	name="disc_applicability<%=index%>" 	value="<%=disc_applicability 				!=null 	? 	disc_applicability			: 	"" %>" />
				
			</tr>
			
			<%
			startIndex++;
		}		
			%>
			
	</table>
	
	
	
		<input type='hidden' name='prevClicked' id='prevClicked' value="" />
		<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
		<input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>" >
	
	<!-- Added by Rajesh V - To Hide Progress Bar -->
	<script>
	fnHideProgress();
	</script>
	<!-- Added by Rajesh V - To Hide Progress Bar -->
	
</form>	
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'></div>
</body>
</TBODY>	
	
	</div>
<%
}
catch(Exception e)
{
	//System.out.println("<<<<<<<<<<<<<<Exception in AdditionalServicePriceDetails>>>>>>>>>>.jsp::"+e);
}
%>
<%!	
private String checkForNull(String inputString)
{
	if (inputString == null) return "";
	if(inputString.equals("null")) return "";
	
	return  inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}

private String decodeParam(String input){
	String output = "";
	if(input == null || "null".equals(input)){
		output = "";
	}
	else{
		output = URLDecoder.decode(input);
	}
	return output;
}
%>
</html>

