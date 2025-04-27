<!DOCTYPE html>


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
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eBL/js/AdditionalServiceDetailsScript.js"></script>
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
	//String applyMode									=	new String();
	String locale				=	"";
	String facilityId			=	"";

	String bean_id				=	"";
	String bean_name			=	"";

	//String facilityId			=	"";
	String serviceInd			=	"";
	String serviceCode			=	"";
	String serviceDescription	=	"";
	String priceInd				=	"";
	String priceCode			=	"";
	String priceDescription		=	"";
	String policyCode			=	"";
	String policyDesc			=	"";
	String custCode				=	"";
	String custDesc   			=	"";
	String billingClass   		=	"";
	String EffectiveTo   		=	"";
	String desc   				=	"";
	String EffectiveFrom   		=	"";
	String discApplicability   	=	"";
	String chargeType   		=	"";

	LinkedHashMap additionalServiceDetailsDataMap=	null;
	List<AdditionalServiceDetailsBean> policyList = null; 
	HashMap<String,List<AdditionalServiceDetailsBean>> policyMap = null;
	String prevTab = null;
	//Added V181005-Gayathri/MMS-DM-SCF-0243.1/Startss 

	String basePrice="", averageCost="", computedValue="",defSelect="";
	String rateBasisInd="";

	//Added V181005-Gayathri/MMS-DM-SCF-0243.1/Ends
	//AdditionalServiceDetailsBean additionalServiceDetailsBean		= 	(AdditionalServiceDetailsBean)getBeanObject( bean_id, bean_name, request ) ;

	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;

try  
{
	 
	sStyle 			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 		= 	(String)session.getAttribute("LOCALE");
	facilityId	=   checkForNull(request.getParameter("facility_id")); //(String) session.getValue( "facility_id" ) ;//Added NMC-JD-CRF-0014 by shikha on 200902
	serviceInd	=	checkForNull(request.getParameter("serviceInd"));
	serviceCode	=	checkForNull(request.getParameter("serviceCode"));
	serviceDescription =	decodeParam(request.getParameter("serviceDescription"));
	priceInd		=	checkForNull(request.getParameter("priceInd"));
	priceCode		=	checkForNull(request.getParameter("priceCode"));
	priceDescription =	decodeParam(request.getParameter("priceDescription"));
	policyCode		=	checkForNull(request.getParameter("policyCode"));
	policyDesc		=	checkForNull(request.getParameter("policyDesc"));
	//decodeParam(request.getParameter("policyDesc"));
	custCode	=	checkForNull(request.getParameter("custCode"));
	custDesc		=	decodeParam(request.getParameter("custDesc"));
	billingClass	=	checkForNull(request.getParameter("billingClass"));
	EffectiveTo		=	checkForNull(request.getParameter("EffectiveTo"));
	desc			=	checkForNull(request.getParameter("desc"));
	EffectiveFrom	=	checkForNull(request.getParameter("EffectiveFrom"));

	//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	discApplicability=	checkForNull(request.getParameter("discApplicability"));
	chargeType		=	checkForNull(request.getParameter("chargeType"));
	additionalServiceDetailsDataMap			=	new LinkedHashMap();
	System.err.println("<<<<<<<<<<Request Param ::::::>>>>>>>>"+request.getQueryString());
	
	bean_id			= 	"AdditionalServiceDetailsBean" ;
	bean_name		= 	"eBL.AdditionalServiceDetailsBean";
	AdditionalServiceDetailsBean additionalServiceDetailsBean		= 	(AdditionalServiceDetailsBean)getBeanObject( bean_id, bean_name, request ) ;
	//isUserCanAcess	= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));
	//additionalServiceDetailsDataMap									=	additionalServiceDetailsBean.getPreApprovalRequestDetailsData(serviceInd, serviceCode, serviceDescription, priceInd, priceCode,priceDescription,policyCode, facilityId, locale,custCode,policyDesc,custDesc,billingClass,EffectiveTo,desc,EffectiveFrom,discApplicability,chargeType);		
	con = ConnectionManager.getConnection(request); 
	//String sqlBillingService = "SELECT NVL(B.LIST_ELMT_LABEL,A.LIST_ELMT_LABEL) description FROM SM_LIST_ITEM A, SM_LIST_ITEM_DESC B WHERE A.MODULE_ID = 'BL' AND A.MODULE_ID = B.MODULE_ID (+) AND A.LIST_REF = B.LIST_REF (+) AND A.LIST_SRL_NO = B.LIST_SRL_NO (+) AND A.LIST_REF = 'L_SERV_INC_EXC_CR' AND B.LANGUAGE_ID (+) = ? and A.LIST_ELMT_VALUE = ? ";
	//String blngServDesc = "";

	
	//HashMap<String,List<AdditionalServiceDetailsBean>> fmtDetailsMap = new HashMap<String,List<AdditionalServiceDetailsBean>>();  //checklist
	AdditionalServiceDetailsBean fmtDtlsBean = null;
	if(policyList == null || policyList.isEmpty())
	{
		String sqlCoverage = BlRepository.getBlKeyValue("DISCOUNT_DETAILS_FETCH");
			
		System.out.println("<<<<<rst IN sqlCoverage::::>>"+sqlCoverage);
		System.out.println("<<facilityId<<<rst IN sqlCoverage::::>>"+facilityId);
		System.out.println("<priceInd<serviceInd<<<rst IN sqlCoverage::::>>"+priceInd);
		System.out.println("<<priceCode<<<rst IN sqlCoverage::::>>"+priceCode);
		System.out.println("<serviceInd<<<<rst IN sqlCoverage::::>>"+serviceInd);
		System.out.println("<serviceCode<<<<rst IN sqlCoverage::::>>"+serviceCode);
		System.out.println("<EffectiveFrom<<<<rst IN sqlCoverage::::>>"+EffectiveFrom);
		System.out.println("<billingClass<<<<rst IN sqlCoverage::::>>"+custCode);
		System.out.println("<billingClass<<<<rst IN sqlCoverage::::>>"+policyCode);
		System.out.println("<billingClass<<<<rst IN sqlCoverage::::>>"+billingClass);
		pstmt = con.prepareStatement(sqlCoverage);
		pstmt.setString(1, facilityId);
		pstmt.setString(2, serviceInd);
		pstmt.setString(3, priceInd);
		pstmt.setString(4, priceCode);
		pstmt.setString(5, serviceCode);
		//pstmt.setString(6,new Date(sdf.parse("06/04/2004").getTime());
		pstmt.setString(6, billingClass);
		pstmt.setString(7, billingClass);
		//pstmt.setString(7, EffectiveFrom);
		pstmt.setString(8, custCode);
		pstmt.setString(9, policyCode);
		if(EffectiveFrom == null || ("".equals(EffectiveFrom))){
			pstmt.setString(10, null);
		}
		else{
			pstmt.setString(10, EffectiveFrom);
		}
		//pstmt.setString(9, EffectiveFrom);
		//pstmt.setString(9, EffectiveFrom);
		rst = pstmt.executeQuery();
		System.out.println("<<<<<sql                Coverage>>"+sqlCoverage);
		//System.out.println("<<<<<rst.next() IN AdditionalServicePreApprovalRequestDetails.jsp::::>>"+rst.next());
		if(rst!=null){
			//System.out.println("<<<<<inside if nulll::::>>");
			policyList = new ArrayList<AdditionalServiceDetailsBean>();
			int rsCnt = 0;
			//System.out.println("<<<<<inside if nulll::::>>==========="+rsCnt);
			//System.out.println("<<<<<inside if nulll::::>>"+rst.getString("blng_class_code"));
			  while (rst.next()) {
				System.out.println("<<<<<rst IN AdditionalServicePreApprovalRequestDetails.jsp>>====inside===if===");
				fmtDtlsBean = new AdditionalServiceDetailsBean();
				//fmtDtlsBean.setBillingClass(rst.getString("blng_class_code"));
			//	fmtDtlsBean.setServiceInd(rst.getString("blng_serv_ind"));
			//	fmtDtlsBean.setPriceInd(rst.getString("cust_pc_ind"));
				fmtDtlsBean.setIpRate(rst.getString("ip_rate"));
				fmtDtlsBean.setOpRate(rst.getString("op_rate"));
				fmtDtlsBean.setEmerRate(rst.getString("emer_rate"));
				fmtDtlsBean.setRefRate(rst.getString("ref_rate"));
				fmtDtlsBean.setDaycareRate(rst.getString("daycare_rate"));
				fmtDtlsBean.setMinCharge(rst.getString("min_charge_amt"));
				fmtDtlsBean.setMaxCharge(rst.getString("max_charge_amt"));
				fmtDtlsBean.setBaseQty(rst.getString("base_qty"));
				fmtDtlsBean.setDescApplicability(rst.getString("gross_net_appl_ind"));
				fmtDtlsBean.setDesc(rst.getString("apply_disc_yn"));
				fmtDtlsBean.setEffectiveFrom(rst.getString("valid_from"));
				fmtDtlsBean.setEffectiveTo(rst.getString("valid_to"));
				fmtDtlsBean.setServiceInd(rst.getString("BLNG_SERV_IND"));
				fmtDtlsBean.setPriceInd(rst.getString("CUST_PC_IND"));
				fmtDtlsBean.setBillingClass(rst.getString("BLNG_CLASS_CODE"));
				//Added V181005-Gayathri/MMS-DM-SCF-0243.1/Starts
				fmtDtlsBean.setSt_item_public_price_chk(rst.getString("st_item_public_price_chk_yn"));
				fmtDtlsBean.setSt_item_rate_basis_ind(rst.getString("st_item_rate_basis_ind"));
				//Added V181005-Gayathri/MMS-DM-SCF-0243.1/Ends
				policyList.add(fmtDtlsBean);
				System.out.println("<<<<<rst IN AdditionalServicePreApprovalRequestDetails.jsp>>====inside==eennndddd=if===");
				 } 

				rsCnt++;
				if(rsCnt<1){
					policyMap = new HashMap<String,List<AdditionalServiceDetailsBean>>();
					AdditionalServiceDetailsBean titleBean = new AdditionalServiceDetailsBean();
					policyList = new ArrayList<AdditionalServiceDetailsBean>();
					policyList.add(titleBean);
					policyMap.put(prevTab, policyList);
				}
		}
		else{
			policyMap = new HashMap<String,List<AdditionalServiceDetailsBean>>();
			AdditionalServiceDetailsBean titleBean = new AdditionalServiceDetailsBean();
			policyList = new ArrayList<AdditionalServiceDetailsBean>();
			policyList.add(titleBean);
			policyMap.put(prevTab, policyList);
		}	
			}

	/*				
			if(rsCnt<1){
				priceDetailsMap = new HashMap<String,List<AdditionalServiceDetailsBean>>();
				AdditionalServiceDetailsBean titleBean = new AdditionalServiceDetailsBean();
				policyList = new ArrayList<AdditionalServiceDetailsBean>();
				policyList.add(titleBean);
				priceDetailsMap.put(prevTab, policyList);
			}
		}
		else{
			priceDetailsMap = new HashMap<String,List<AdditionalServiceDetailsBean>>();
			AdditionalServiceDetailsBean titleBean = new AdditionalServiceDetailsBean();
			policyList = new ArrayList<AdditionalServiceDetailsBean>();
			policyList.add(titleBean);
			priceDetailsMap.put(prevTab, policyList);
		}		
		*/
%>
<body onScroll="processScroll()" onKeyDown= "lockKey();" onMouseDown="CodeArrest();"    ; onSelect="codeArrestThruSelect();">
	<form id="AdditionalServicePreApprovalRequestDetailsForm" name="AdditionalServicePreApprovalRequestDetailsForm" id="AdditionalServicePreApprovalRequestDetailsForm">	

	<table align='center' cellpadding=3 cellspacing=0  width='100%' id="panel_categories_table" name="panel_categories_table" id="panel_categories_table" border="1">
	<div id="tableContainer">
	<thead>
	<tr style="position: sticky; top: 0; background-color: white; z-index: 1;">
		<td class='COLUMNHEADER'		width='4%'	align="left"><fmt:message key="Common.SrlNo.label" 		bundle="${common_labels}"/></td>
		<th class='CAFLOWSHEETLEVEL1'	width='7%'	align="left"><fmt:message key="eBL.BillingClass.label" 			bundle="${bl_labels}"	/></th>
		<th class='CAFLOWSHEETLEVEL1'	width='7%'	align="left"><fmt:message key="eBL.Public.label" 			bundle="${bl_labels}"	/></th>
		<th class='CAFLOWSHEETLEVEL1'	width='7%'	align="left"><fmt:message key="eBL.Basis.label" 			bundle="${bl_labels}"	/></th>
		<th class='CAFLOWSHEETLEVEL1'	width='8%' 	align="left"><fmt:message key="eBL.ServiceIndDesc.label" 			bundle="${bl_labels}"	/></th>
		<th class='CAFLOWSHEETLEVEL1'	width='6%'	align="left"><fmt:message key="eBL.INDICATOR.label" 			bundle="${bl_labels}"	/></th>
		<th class='CAFLOWSHEETLEVEL1'	width='5%'	align="left"><fmt:message key="eBL.IP_RATE.label" 				bundle="${bl_labels}"	/></th>
		<th class='CAFLOWSHEETLEVEL1'	width='5%' 	align="left"><fmt:message key="eBL.OP_RATE.label" 				bundle="${bl_labels}"	/></th>
		<th class='CAFLOWSHEETLEVEL1'	width='5%' 	align="left"><fmt:message key="eBL.EMG_RATE.label" 				bundle="${bl_labels}"	/></th>
		<th class='CAFLOWSHEETLEVEL1'	width='5%'	align="left"><fmt:message key="eBL.EXT_RATE.label" 				bundle="${bl_labels}"	/></th>
		<th class='CAFLOWSHEETLEVEL1'	width='5%' 	align="left"><fmt:message key="eBL.DC_RATE.label" 				bundle="${bl_labels}"	/></th>
		<th class='CAFLOWSHEETLEVEL1'	width='7%' 	align="left"><fmt:message key="eBL.MIN_CHARGE.label" 			bundle="${bl_labels}"	/></th>
		<th class='CAFLOWSHEETLEVEL1'	width='7%' 	align="left"><fmt:message key="eBL.MAX_CHARGE.label" 			bundle="${bl_labels}"	/></th>
		<th class='CAFLOWSHEETLEVEL1'	width='5%'	align="left"><fmt:message key="eBL.BASE_QTY.label" 				bundle="${bl_labels}"	/></th>
		<th class='CAFLOWSHEETLEVEL1'	width='8%' 	align="left"><fmt:message key="eBL.DISC_APPLICABILITY.label" 	bundle="${bl_labels}"	/></th>
		<th class='CAFLOWSHEETLEVEL1'	width='7%' 	align="left"><fmt:message key="eBL.DISC_APPLY.label" 			bundle="${bl_labels}"	/></th>
		<th class='CAFLOWSHEETLEVEL1'	width='8%' 	align="left"><fmt:message key="eBL.ValidFrom.label" 			bundle="${bl_labels}"	/></th>
		<th class='CAFLOWSHEETLEVEL1'	width='8%' 	align="left"><fmt:message key="eBL.ValidTo.label" 				bundle="${bl_labels}"	/></th>
	</tr>
	</thead>
	
	<TBODY>
	<%
	
	System.err.println("<<<<<<<<<IN AdditionalServicePreRecordApprovalDetails.jsp policyList:size22:::::::>>>>>>"+policyList.size()); 

	int index = 0;
	int size = policyList.size();
	for(int i=0; i < size; i++)
	{
		//int index =    (Integer)iterator.next();
		int sNo	  =		index+1;			
			
		additionalServiceDetailsBean = (AdditionalServiceDetailsBean) policyList.get(index);  
	//Added V181005-Gayathri/MMS-DM-SCF-0243.1/Starts
		rateBasisInd=additionalServiceDetailsBean.getSt_item_rate_basis_ind();
			
		basePrice=("B").equals(rateBasisInd) ?"SELECTED" :"";
		averageCost=("C").equals(rateBasisInd) ?"SELECTED" :"";
		computedValue=("V").equals(rateBasisInd) ?"SELECTED" :"";
		defSelect=("").equals(rateBasisInd) ?"SELECTED" :"";
		//Added V181005-Gayathri/MMS-DM-SCF-0243.1/Ends	
	
%>

	<tr onclick="fnViewModify('<%=index%>');" >
	<% if(i==0) {%>
		<td class="fields"	width='4%'   id="srl_no<%=index%>" name="srl_no<%=index%>">	<%=sNo%></td>
	<%} else { %>
	<td class="fields"	width='4%'   id="srl_no<%=index%>" name="srl_no<%=index%>">&nbsp;</td>
	<%} %>
		<td class="fields"	width='7%'   id="billing_class<%=index%>"				name="billing_class<%=index%>"	> 					<%=additionalServiceDetailsBean.getBillingClass()	 					!=null 	? 	additionalServiceDetailsBean.getBillingClass()			: 	"&nbsp;" %>  </td>
	<td>
	 <input type='checkbox' name='public<%=index%>' id='public<%=index%>' id='public<%=index%>' 	value="<%=additionalServiceDetailsBean.getSt_item_public_price_chk()	 					!=null 	? 	additionalServiceDetailsBean.getSt_item_public_price_chk()			: 	"&nbsp;" %> "  <%=("Y").equals(additionalServiceDetailsBean.getSt_item_public_price_chk())?"checked":""%> readonly></td>
	</td>
	<td>
	<select name='rateBasisInd<%=index%>' id='rateBasisInd<%=index%>' onChange=""   readonly > 
	<option value='' <%=defSelect%>>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
	<option value='B' <%=basePrice%> ><fmt:message key="eBL.BASE_PRICE.label" bundle="${bl_labels}"/></option>
	<option value='C' <%=averageCost%> ><fmt:message key="eBL.AVERAGE_COST.label" bundle="${bl_labels}"/></option>
	<option value='V' <%=computedValue%>><fmt:message key="eBL.COMPUTED_VALUE.label" bundle="${bl_labels}"/></option>
	</select>
	</td>
	<td class="fields"	width='8%'   id="description<%=index%>"					name="description<%=index%>"	> 					<%=serviceDescription%></td> 
	<td class="fields"  width='6%'   id="Indicator<%=index%>"					name="Indicator<%=index%>">							<%=additionalServiceDetailsBean.getPriceInd()	 					!=null 	? 	additionalServiceDetailsBean.getPriceInd()			: 	"&nbsp;" %></td> 
	<td class="fields"	width='5%'   id="ip_rate<%=index%>"						name="ip_rate<%=index%>">							<%=additionalServiceDetailsBean.getIpRate()	 					!=null 	? 	additionalServiceDetailsBean.getIpRate()			: 	"&nbsp;" %> </td>
	<td class="fields"	width='5%'   id="op_rate<%=index%>"						name="op_rate<%=index%>">							<%=additionalServiceDetailsBean.getOpRate() 					!=null 	? 	additionalServiceDetailsBean.getOpRate()			: 	"&nbsp;" %> </td> 
	<td class="fields"	width='5%'   id="emer_rate<%=index%>"					name="emer_rate<%=index%>">	 						<%=additionalServiceDetailsBean.getEmerRate()					!=null 	? 	additionalServiceDetailsBean.getEmerRate()			: 	"&nbsp;" %> </td> 
	<td class="fields"	width='5%'   id="ext_rate<%=index%>"					name="ext_rate<%=index%>">	 						<%=additionalServiceDetailsBean.getRefRate()					!=null 	? 	additionalServiceDetailsBean.getRefRate()			: 	"&nbsp;" %> </td>
	<td class="fields"	width='5%'   id="dc_rate<%=index%>"		 				name="dc_rate<%=index%>">	 						<%=additionalServiceDetailsBean.getDaycareRate()				!=null 	? 	additionalServiceDetailsBean.getDaycareRate()		: 	"&nbsp;" %> </td>
	<td class="fields"	width='7%'   id="min_charge<%=index%>"		 			name="min_charge<%=index%>">						<%=additionalServiceDetailsBean.getMinCharge()  				!=null 	? 	additionalServiceDetailsBean.getMinCharge()			: 	"&nbsp;" %></td> 
	<td class="fields"	width='7%'   id="max_charge"<%=index%>"					name="max_charge<%=index%>">						<%=additionalServiceDetailsBean.getMaxCharge()					!=null 	? 	additionalServiceDetailsBean.getMaxCharge()			: 	"&nbsp;" %> </td> 
	<td class="fields"	width='5%'   id="base_qty<%=index%>"		 			name="base_qty<%=index%>"	>	    				<%=additionalServiceDetailsBean.getBaseQty()					!=null 	? 	additionalServiceDetailsBean.getBaseQty()			: 	"&nbsp;" %></td>
	<td class="fields"	width='8%'   id="applicability<%=index%>"		 		name="applicability<%=index%>">	    				<%=additionalServiceDetailsBean.getDescApplicability()			!=null 	? 	additionalServiceDetailsBean.getDescApplicability()	: 	"&nbsp;" %></td>
	<td class="fields"	width='7%'   id="apply_desc<%=index%>"		 			name="apply_desc<%=index%>">	    				<%=additionalServiceDetailsBean.getDesc()						!=null 	? 	additionalServiceDetailsBean.getDesc()				: 	"&nbsp;" %></td>
	<td class="fields"	width='8%'   id="valid_from<%=index%>"		 			name="valid_from<%=index%>">	    				<%=additionalServiceDetailsBean.getEffectiveFrom()				!=null 	? 	additionalServiceDetailsBean.getEffectiveFrom()		: 	"&nbsp;" %></td>
	<td class="fields"	width='8%'   id="valid_to<%=index%>"		 			name="valid_to<%=index%>">	    					<%=additionalServiceDetailsBean.getEffectiveTo()				!=null 	? 	additionalServiceDetailsBean.getEffectiveTo()		: 	"&nbsp;" %></td>
	<input type="hidden" id="service_ind<%=index%>" 		name="service_ind<%=index%>" 	 							 value="<%=additionalServiceDetailsBean.getServiceInd()	 				!=null 	? 	additionalServiceDetailsBean.getServiceInd()			: 	"" %>" />
</tr>

			<%
index++;
}		
%>
	</table>
	<input type='hidden' name='locale' id='locale'				id='locale' 	 			value="<%=locale%>" >
	<input type='hidden' name='facilityId' id='facilityId'			id='facilityId' 			value="<%=facilityId%>" >
	<input type="hidden" 	id="blng_class" 		name="blng_class" id="blng_class" 	 	 		value="<%=billingClass						!=null 	? 	billingClass			: 	"" %>" /> 
	<input type="hidden" 	id="service_ind" 		name="service_ind" id="service_ind" 	 			value="<%=serviceInd						!=null 	? 	serviceInd				: 	"" %>" />
	<input type="hidden" 	id="service_code" 		name="service_code" id="service_code" 	 		value="<%=serviceCode						!=null 	? 	serviceCode				: 	"" %>" />
	<input type="hidden" 	id="service_desc" 		name="service_desc" id="service_desc" 			value="<%=serviceDescription 				!=null 	? 	serviceDescription		: 	"" %>" />
	<input type="hidden" 	id="price_ind" 			name="price_ind" id="price_ind" 	 			value="<%=priceInd							!=null 	? 	priceInd				: 	"" %>" />
	<input type="hidden" 	id="price_code" 		name="price_code" id="price_code"  				value="<%=priceCode							!=null 	? 	priceCode				: 	"" %>" />
	<input type="hidden" 	id="price_desc" 		name="price_desc" id="price_desc" 				value="<%=priceDescription 					!=null 	? 	priceDescription		: 	"" %>" />
	<input type="hidden" 	id="policy_code" 		name="policy_code" id="policy_code" 				value="<%=policyCode 						!=null 	? 	policyCode				: 	"" %>" />
	<input type="hidden" 	id="policy_desc" 		name="policy_desc" id="policy_desc" 				value="<%=policyDesc 						!=null 	? 	policyDesc				: 	"" %>" />
	<input type="hidden" 	id="cust_code" 			name="cust_code" id="cust_code" 				value="<%=custCode 							!=null 	? 	custCode				: 	"" %>" />
	<input type="hidden" 	id="cust_desc" 			name="cust_desc" id="cust_desc" 				value="<%=custDesc 							!=null 	? 	custDesc				: 	"" %>" />
	<input type="hidden" 	id="desc_app" 			name="desc_app" id="desc_app" 				value="<%=discApplicability 				!=null 	? 	discApplicability		: 	"" %>" />
	<input type="hidden" 	id="charge_type" 		name="charge_type" id="charge_type" 				value="<%=chargeType 						!=null 	? 	chargeType				: 	"" %>" />
	<input type="hidden" 	id="eff_to" 			name="eff_to" id="eff_to" 					value="<%=EffectiveTo 						!=null 	? 	EffectiveTo				: 	"" %>" />
	<input type="hidden" 	id="eff_from" 			name="eff_from" id="eff_from" 				value="<%=EffectiveFrom 					!=null 	? 	EffectiveFrom			: 	"" %>" />
	<input type="hidden" 	id="description" 		name="description" id="description" 				value="<%=desc 								!=null 	? 	desc					: 	"" %>" />

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

