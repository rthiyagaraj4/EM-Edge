
<%@page import="java.net.URLDecoder"%>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*, eBL.AdditionalServiceDetailsBean, java.text.SimpleDateFormat, java.lang.Integer" contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eBL/js/AdditionalServiceDetailsScript.js"></script>

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
		
		</style>
		
<%
	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
	response.setHeader("Pragma","no-cache"); //HTTP 1.0   
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 

	
	String locale				=	"";
	String facilityId			=	"";

	String bean_id				=	"";
	String bean_name			=	"";

	//String facilityId			=	"";
	String serviceCode			=	"";
	String EffectiveTo   		=	"";
	String EffectiveFrom   		=	"";
	

	String reimbursable_YN      = "" ;  //V240722
	String override_YN			= "" ;  //V240722
	String reimbursable_ind     = "" ;
	String reimbursable_type    = "" ;  //V240722
	String reimbursable_amount  = "" ;  //V240722
	String publicPrice          = "" ;
	String custGrpCode          = "" ;
	String custGrpDesc          = "" ;
	String custCode	            = "" ;		
	String custDesc          	= "" ;
	
	String importedItem                  = "";
	String essentialItem	             = "";
	String DrugItemPriceSetupMMSYN       = "";
	String serviceInd                       = "";
	String costInd                       = "";
	String costAmt                       = "";
	String serviceDescription            = "";
	String status                        = "";
	String descExists                   = "";
	List<AdditionalServiceDetailsBean> priceData = null; 
	
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;

try  
{
	 
	sStyle 	    =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 		= 	(String)session.getAttribute("LOCALE");
	facilityId	=   checkForNull(request.getParameter("facility_id")); //(String) session.getValue( "facility_id" ) ;//Added NMC-JD-CRF-0014 by shikha on 200902
	serviceCode	=	checkForNull(request.getParameter("serviceCode"));
	EffectiveTo		=	checkForNull(request.getParameter("EffectiveTo"));
	EffectiveFrom	=	checkForNull(request.getParameter("EffectiveFrom"));
	
	System.out.print("effective from :"+EffectiveFrom);
	System.out.print("effective to   :"+EffectiveTo);
	
	custCode	=	checkForNull(request.getParameter("custCode"));
	custDesc	=	checkForNull(request.getParameter("custDesc"));
	System.out.println("the values is cust_code"+custCode+" cust_desc "+custDesc);

	custGrpCode		        = checkForNull(request.getParameter("custGrpCode"));  //V240722
	custGrpDesc             = checkForNull(request.getParameter("custGrpDesc"));  //V240722
	System.out.println("the values is cust_group_code"+custGrpCode+" cust_group_desc "+custGrpDesc);
	importedItem	        = checkForNull(request.getParameter("importedItem"));  //V240722
	essentialItem	        = checkForNull(request.getParameter("essentialItem"));  //V240722
	DrugItemPriceSetupMMSYN = checkForNull(request.getParameter("DrugItemPriceSetupMMSYN"));  //V240722
	System.out.println("DrugItemPriceSetupMMSYN is in discount is" +DrugItemPriceSetupMMSYN);
	serviceInd              = checkForNull(request.getParameter("serviceInd"));  //V240722
	serviceDescription      = checkForNull(request.getParameter("serviceDescription"));  //V240722
	System.out.println("serviceDescription ->"+serviceDescription);
	status                  = checkForNull(request.getParameter("status"));
	descExists              = checkForNull(request.getParameter("desc"));
	System.out.println("the status is :"+status);
	System.out.println("the discount is founded : "+descExists);
    System.out.println("Effective From: " + EffectiveFrom);
    System.out.println("Effective To: " + EffectiveTo);
    System.out.println("Cust Code: " + custCode);
    System.out.println("Cust Desc: " + custDesc);
    System.out.println("Cust Group Code: " + custGrpCode);
    System.out.println("Cust Group Desc: " + custGrpDesc);
    System.out.println("Imported Item: " + importedItem);
    System.out.println("Essential Item: " + essentialItem);
    System.out.println("Drug Item Price Setup MMSYN: " + DrugItemPriceSetupMMSYN);
    System.out.println("Service Indicator: " + serviceInd);
    System.out.println("Service Description: " + serviceDescription);
    
	bean_id			= 	"AdditionalServiceDetailsBean" ;
	bean_name		= 	"eBL.AdditionalServiceDetailsBean";
	AdditionalServiceDetailsBean additionalServiceDetailsBean		= 	(AdditionalServiceDetailsBean)getBeanObject( bean_id, bean_name, request ) ;
			
	con = ConnectionManager.getConnection(request); 

	priceData                                = new ArrayList<AdditionalServiceDetailsBean>();
	AdditionalServiceDetailsBean fmtDtlsBean = null;
		
			String query = "SELECT TR.SERV_COST_IND, TR.SERV_COST_AMT, TR.PUBLIC_PRICE, TR.BASE_PRICE_IP, TR.BASE_PRICE_OP, " +
		               "TR.BASE_PRICE_RF, TR.BASE_PRICE_EM, TR.BASE_PRICE_DC, TR.INP_REIMBURSABLE_YN ,INP_OVERRIDE_REIMBURSABLE_YN , TR.INP_REIMBURSABLE_IND, " +
		               "TR.INP_REIMBURSABLE_AMT,  TO_CHAR(TR.EFFECTIVE_FROM_DATE, 'dd/mm/yyyy') AS EFFECTIVE_FROM_DATE, TO_CHAR(TR.EFFECTIVE_TO_DATE, 'dd/mm/yyyy') AS EFFECTIVE_TO_DATE  , APPLY_DISC_YN " +
		               "FROM BL_ST_ITEM_BY_PERIOD TR " +
		               "WHERE TR.ITEM_CODE = ? " +
		               "AND TR.OPERATING_FACILITY_ID = ? " +
		               "AND TR.CUST_CODE = ? " +
		               "AND TR.CUST_GROUP_CODE = ? ";
	
		if (!("".equals(EffectiveFrom)))		 {
			
		    query += " AND TR.EFFECTIVE_FROM_DATE >=  TO_DATE(?, 'dd/MM/yyyy') ";

		}
	
		if (!("".equals(EffectiveTo))) {
		    query += " AND TR.EFFECTIVE_TO_DATE<=  TO_DATE(?, 'dd/MM/yyyy') ";
		} 
		
		if("Y".equals(descExists)){
			query += " And TR.APPLY_DISC_YN = ? ";
		}
		if("E".equals(status)){
			query += " And ( EFFECTIVE_TO_DATE >= sysdate OR  EFFECTIVE_TO_DATE IS NULL) ";
		}
		if("D".equals(status)){
			query += " And EFFECTIVE_TO_DATE < sysdate ";
		}
		System.err.println("ererror->"+query);
		int param = 1;
		
		System.out.println(serviceCode +" , "+facilityId+" , "+custCode+" , "+custGrpCode+" , "+EffectiveFrom+" , "+EffectiveTo+" , "+param);
		pstmt = con.prepareStatement(query);
		pstmt.setString(param, serviceCode);
		pstmt.setString(++param, facilityId);
		pstmt.setString(++param, custCode);
		pstmt.setString(++param, custGrpCode);
		
		if (!("".equals(EffectiveFrom))) {
		    pstmt.setString(++param, EffectiveFrom);
		}

		if (!("".equals(EffectiveTo))) {
		    pstmt.setString(++param, EffectiveTo);
		}
		if(("Y".equals(descExists))){
			pstmt.setString(++param, descExists);
		}
		
		rst = pstmt.executeQuery();
		if(rst!=null){
			  while (rst.next()) {
				  
			  
				fmtDtlsBean = new AdditionalServiceDetailsBean();
				fmtDtlsBean.setCostInd(rst.getString("SERV_COST_IND"));
				fmtDtlsBean.setCostAmt(rst.getString("SERV_COST_AMT"));
				fmtDtlsBean.setPublicPrice(rst.getString("PUBLIC_PRICE"));
				fmtDtlsBean.setIpRate(rst.getString("BASE_PRICE_IP"));
				fmtDtlsBean.setOpRate(rst.getString("BASE_PRICE_OP"));
				fmtDtlsBean.setEmerRate(rst.getString("BASE_PRICE_EM"));
				fmtDtlsBean.setRefRate(rst.getString("BASE_PRICE_RF"));
				fmtDtlsBean.setDaycareRate(rst.getString("BASE_PRICE_DC"));
				fmtDtlsBean.setReimbursable_YN(rst.getString("INP_REIMBURSABLE_YN"));
				fmtDtlsBean.setOverride_YN(rst.getString("INP_OVERRIDE_REIMBURSABLE_YN"));
				fmtDtlsBean.setReimbursable_ind(rst.getString("INP_REIMBURSABLE_IND"));
				fmtDtlsBean.setReimbursable_amount(rst.getString("INP_REIMBURSABLE_AMT"));
				fmtDtlsBean.setDescApplicability(rst.getString("APPLY_DISC_YN"));
				fmtDtlsBean.setEffectiveFrom(rst.getString("EFFECTIVE_FROM_DATE"));
				fmtDtlsBean.setEffectiveTo(rst.getString("EFFECTIVE_TO_DATE"));
				priceData.add(fmtDtlsBean);
			  }
		}

%>
<body onScroll="processScroll()" onKeyDown= "lockKey();" onMouseDown="CodeArrest();"    ; onSelect="codeArrestThruSelect();">
	<form id="AdditionalServicePreApprovalRequestDetailsForm" name="AdditionalServicePreApprovalRequestDetailsForm" id="AdditionalServicePreApprovalRequestDetailsForm">	

	<table align='center' cellpadding=3 cellspacing=0  width='100%' id="panel_categories_table" name="panel_categories_table" id="panel_categories_table" border="1">
	<div id="tableContainer">
	<thead>
	<tr>
		<td class='columnheader'		width='4%'	align="left"><fmt:message key="Common.SrlNo.label" 		        bundle="${common_labels}"/></th>
		<th class='CAFLOWSHEETLEVEL1'	width='7%'	align="left"><fmt:message key="eBL.Public.label" 			    bundle="${bl_labels}"	/></th>
		<th class='CAFLOWSHEETLEVEL1'	width='5%'	align="left"><fmt:message key="eBL.IP_RATE.label" 				bundle="${bl_labels}"	/></th>
		<th class='CAFLOWSHEETLEVEL1'	width='5%' 	align="left"><fmt:message key="eBL.OP_RATE.label" 				bundle="${bl_labels}"	/></th>
		<th class='CAFLOWSHEETLEVEL1'	width='5%' 	align="left"><fmt:message key="eBL.EMG_RATE.label" 				bundle="${bl_labels}"	/></th>
		<th class='CAFLOWSHEETLEVEL1'	width='5%'	align="left"><fmt:message key="eBL.EXT_RATE.label" 				bundle="${bl_labels}"	/></th>
		<th class='CAFLOWSHEETLEVEL1'	width='5%' 	align="left"><fmt:message key="eBL.DC_RATE.label" 				bundle="${bl_labels}"	/></th>
		
		<th class='CAFLOWSHEETLEVEL1'	width='5%' 	align="left"><fmt:message key="eBL.Reimbursable.label" bundle="${bl_labels }"/></th>
		<th class='CAFLOWSHEETLEVEL1'	width='5%' 	align="left"><fmt:message key="Common.override.label" bundle="${common_labels }"></fmt:message></th>
		<th class='CAFLOWSHEETLEVEL1'	width='5%' 	align="left"><fmt:message key="eBL.ReimbursableType.label" bundle="${bl_labels }"></fmt:message></th>
		<th class='CAFLOWSHEETLEVEL1'	width='5%' 	align="left"><fmt:message key="eBL.ReimbursableAmt.label" bundle="${bl_labels }"></fmt:message></th>
		
		<th class='CAFLOWSHEETLEVEL1'	width='5%' 	align="left"><fmt:message key="eBL.CostIndicator.label" bundle="${bl_labels }"></fmt:message></th>
		<th class='CAFLOWSHEETLEVEL1'	width='5%' 	align="left"><fmt:message key="eBL.CostAmt.label" bundle="${bl_labels }"></fmt:message></th>
		
				
		<th class='CAFLOWSHEETLEVEL1'	width='7%' 	align="left"><fmt:message key="eBL.DISC_APPLY.label" 			bundle="${bl_labels}"	/></th>
		<th class='CAFLOWSHEETLEVEL1'	width='8%' 	align="left"><fmt:message key="eBL.ValidFrom.label" 			bundle="${bl_labels}"	/></th>
		<th class='CAFLOWSHEETLEVEL1'	width='8%' 	align="left"><fmt:message key="eBL.ValidTo.label" 				bundle="${bl_labels}"	/></th>
	</tr>
	</thead>
	
	<TBODY>
	<%
	

	int index = 0;
	int size = priceData.size();
	for(int i=0; i < size; i++)
	{
		AdditionalServiceDetailsBean priceDetailsBean = priceData.get(i);
		//int index =    (Integer)iterator.next();
		int sNo	  =		index+1;			
%>

	<tr onclick="fnViewModify_DrugItem('<%=index%>');" >
	<td class="fields"	width='4%'   id="srl_no<%=index%>" name="srl_no<%=index%>">	<%=sNo%></td>
	<td class="fields"	width='5%'   id="publicPrice<%=index%>"					name="publicPrice<%=index%>">						<%=priceDetailsBean.getPublicPrice()	 			!=null 	? 	priceDetailsBean.getPublicPrice()		: 	"&nbsp;" %> </td>
	<td class="fields"	width='5%'   id="ip_rate<%=index%>"						name="ip_rate<%=index%>">							<%=priceDetailsBean.getIpRate()	 					!=null 	? 	priceDetailsBean.getIpRate()			: 	"&nbsp;" %> </td>
	<td class="fields"	width='5%'   id="op_rate<%=index%>"						name="op_rate<%=index%>">							<%=priceDetailsBean.getOpRate() 					!=null 	? 	priceDetailsBean.getOpRate()			: 	"&nbsp;" %> </td> 
	<td class="fields"	width='5%'   id="emer_rate<%=index%>"					name="emer_rate<%=index%>">	 						<%=priceDetailsBean.getEmerRate()					!=null 	? 	priceDetailsBean.getEmerRate()			: 	"&nbsp;" %> </td> 
	<td class="fields"	width='5%'   id="ext_rate<%=index%>"					name="ext_rate<%=index%>">	 						<%=priceDetailsBean.getRefRate()					!=null 	? 	priceDetailsBean.getRefRate()			: 	"&nbsp;" %> </td>
	<td class="fields"	width='5%'   id="dc_rate<%=index%>"		 				name="dc_rate<%=index%>">	 						<%=priceDetailsBean.getDaycareRate()				!=null 	? 	priceDetailsBean.getDaycareRate()		: 	"&nbsp;" %> </td>

	<td class="fields"	width='5%'   id="reimbursable<%=index%>"		 		name="reimbursable<%=index%>">	 					<%=priceDetailsBean.getReimbursable_YN()	        !=null 	? 	priceDetailsBean.getReimbursable_YN()	: 	"&nbsp;" %> </td>
	<td class="fields"	width='5%'   id="override<%=index%>"		 			name="override<%=index%>">	 						<%=priceDetailsBean.getOverride_YN()				!=null 	? 	priceDetailsBean.getOverride_YN()		: 	"&nbsp;" %> </td>
	<td class="fields"  width="5%"    id="reimbursableType<%=index%>"            name="reimbursableType<%=index%>">
    <%
        String selected_reimbursableInd = priceDetailsBean.getReimbursable_ind();
        String displayText = "&nbsp;"; 

        if (selected_reimbursableInd != null) {
            if ("P".equals(selected_reimbursableInd)) {
                displayText = "Part";
            } else if ("F".equals(selected_reimbursableInd)) {
                displayText = "Full";
            } else if ("N".equals(selected_reimbursableInd)) {
                displayText = "N/A";
            } else {
                displayText = selected_reimbursableInd; // Display original value if it's not P, F, or N
            }
        }
    %>
    <%= displayText %>
</td>
 <td class="fields"	width='5%'   id="reimbursableAmt<%=index%>"		 		name="reimbursableAmt<%=index%>">	 				<%=priceDetailsBean.getReimbursable_amount()	    !=null 	? 	priceDetailsBean.getReimbursable_amount()		: 	"&nbsp;" %> </td>

<td class="fields" width="5%" id="costInd<%=index%>" name="costInd<%=index%>">
    <%
        String select_costInd = priceDetailsBean.getCostInd();
         displayText = "&nbsp;"; 

        if (select_costInd != null) {
            if ("A".equals(select_costInd)) {
                displayText = "Amount";
            } else if ("P".equals(select_costInd)) {
                displayText = "Percentage";
            } else if("N".equals(select_costInd)) {
                displayText = "N/A";
            }
        }
    %>
    <%= displayText %>
	</td>	
	<td class="fields"	width='5%'   id="costAmt<%=index%>"		 		        name="costAmt<%=index%>">	 				        <%=priceDetailsBean.getCostAmt()	                !=null 	? 	priceDetailsBean.getCostAmt()		    : 	"&nbsp;" %> </td>
	<td class="fields"	width='5%'   id="discount_YN<%=index%>"		 		    name="discount_YN<%=index%>">	 				    <%=priceDetailsBean.getDescApplicability()	        !=null 	? 	priceDetailsBean.getDescApplicability()	: 	"&nbsp;" %> </td>
	<td class="fields"	width='8%'   id="valid_from<%=index%>"		 			name="valid_from<%=index%>">	    				<%=priceDetailsBean.getEffectiveFrom()				!=null 	? 	priceDetailsBean.getEffectiveFrom()		: 	"&nbsp;" %></td>
	<td class="fields"	width='8%'   id="valid_to<%=index%>"		 			name="valid_to<%=index%>">	    					<%=priceDetailsBean.getEffectiveTo()				!=null 	? 	priceDetailsBean.getEffectiveTo()		: 	"&nbsp;" %></td>
	<input type="hidden" id="service_ind<%=index%>" 		                    name="service_ind<%=index%>" 	 					value="<%=serviceInd%>"	  />
	<input type="hidden" id="Indicator<%=index%>" 		                        name="Indicator<%=index%>" 	 					    value=""	  />
	<input type="hidden" id="billing_class<%=index%>" 		                    name="billing_class<%=index%>" 	 					value=""	  />		
</tr>

<%
index++;
}		
%>
	</table>
	<input type='hidden'    id='locale'             name='locale' id='locale'				 	value="<%=locale%>" >
	<input type='hidden'    id='facilityId'         name='facilityId' id='facilityId'			 	value="<%=facilityId%>" >	
	<input type="hidden" 	id="service_code" 		name="service_code" id="service_code" 	 		value="<%=serviceCode						!=null 	? 	serviceCode				: 	"" %>" />
	<input type="hidden" 	id="eff_to" 			name="eff_to" id="eff_to" 					value="<%=EffectiveTo 						!=null 	? 	EffectiveTo				: 	"" %>" />
	<input type="hidden" 	id="eff_from" 			name="eff_from" id="eff_from" 				value="<%=EffectiveFrom 					!=null 	? 	EffectiveFrom			: 	"" %>" />
	<input type="hidden"    id="service_ind"        name="service_ind" id="service_ind"	            value="<%=serviceInd                        !=null 	? 	serviceInd			    : 	"" %>" />
	<input type="hidden"    id="service_code"       name="service_code" id="service_code"	            value="<%=serviceCode                       !=null 	? 	serviceCode			    : 	"" %>" />
	<input type="hidden"    id="service_desc"       name="service_desc" id="service_desc"	            value="<%=serviceDescription                !=null 	? 	serviceDescription	    : 	"" %>" />
	<input type="hidden"    id="price_code"	        name ="price_code"              value=""/>
	<input type="hidden"    id="price_desc"         name ="price_desc"              value=""/>
	<input type="hidden"    id="policy_code"        name="policy_code" id="policy_code"              value=""/>
	<input type="hidden"    id="policy_desc"        name="policy_desc" id="policy_desc"              value=""/>
	<input type="hidden"    id="cust_code"          name="cust_code" id="cust_code"                value="<%=custCode                         !=null  ? custCode : ""%>"/>
	<input type="hidden"    id="cust_desc"			name="cust_desc" id="cust_desc"				value="<%=custDesc                         !=null ?  custDesc : ""%>"/>
	<input type="hidden"    id="billing_class"      name="billing_class" id="billing_class" 			value=""/>
	<input type="hidden"    id="Indicator"          name="Indicator" id="Indicator"				value=""/>
	<input type="hidden"    id="blng_class"         name="blng_class" id="blng_class"               value=""/>
	<input type="hidden"    id="eff_from"           name="eff_from" id="eff_from"                 value=""/>
	<input type="hidden"    id="valid_to"           			name="valid_to" id="valid_to"                 value=""/>
	<input type="hidden"    id="description"        			name="description" id="description"              value=""/>
	<input type="hidden"    id="charge_type"                    name="blng_class" id="blng_class"               value=""/>
	<input type="hidden"    id="desc_app"                       name="desc_app" id="desc_app"               value=""/>
	<input type="hidden"    id="DrugItemPriceSetupMMSYN"        name="DrugItemPriceSetupMMSYN" id="DrugItemPriceSetupMMSYN"               value="<%=DrugItemPriceSetupMMSYN%>"/>
	<input type="hidden"    id="custGrpCode"                    name="custGrpCode" id="custGrpCode" value="<%=custGrpCode%>"/>
	<input type="hidden"    id="custGrpDesc"                    name="custGrpDesc" id="custGrpDesc" value="<%=custGrpDesc%>"
	
	</form>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'></div>
	
</body>
</TBODY>	
	
	</div>
<%
}
catch(Exception e)
{
	System.err.println("Exception in AdditionalServicePreApprovalRequestDetails.jsp::"+e);
}
finally{
	ConnectionManager.returnConnection(con);
	//pstmt = null;
	//rst = null;
}
%>
<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
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

