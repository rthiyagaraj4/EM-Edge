<!DOCTYPE html>
<!-- Page Added by Rajesh V. Price Discount Create Record -->    
<!-- 
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1		 V211115			25887			PMG2021-MMS-CRF-0004.1		   Nandhini M
-->
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
	String mode = checkForNull(request.getParameter("mode"));
	String locale = (String)session.getAttribute("LOCALE");
	//Added NMC-JD-CRF-0014 by shikha on 200902
	String facility_id="";
	if("modify".equals(mode)){
		 facility_id = checkForNull(request.getParameter("facilityId"));
	}else{
		 facility_id = (String)session.getAttribute("facility_id");
	}
	//Ended NMC-JD-CRF-0014 by shikha on 200902
	Connection con = null;
	con = ConnectionManager.getConnection(request);
	ResultSet rst,rs= null;
	PreparedStatement pstmt = null;
	//Added against NMC-JD-CRF-0014 starts
	PreparedStatement pstmt1 = null;
	ResultSet rs1= null;
	int tableIndex = 1; // added against 128.2
	int pkgGrpEnabledCount = 0; // V211109
	boolean isPkgGrpEnabledYN = false; // V211109
	String disabledForPackageGroup = ""; // V211109
	String retValPH = "N";
	
	String siteSpecfacid ="";
	try{
			String globalfacilityYN = "Select global_facility_yn from bl_parameters where OPERATING_FACILITY_ID='"+facility_id+"'";
			pstmt1 = con.prepareStatement(globalfacilityYN);
			rs1=pstmt1.executeQuery();
			if( rs1 != null ) 
			{
				while(rs1.next())
				{
					siteSpecfacid = rs1.getString("global_facility_yn");
				}				
			}
		}catch(Exception e)
			{ 
				e.printStackTrace();
				System.err.println("Main Exception siteSpecfacid Global Fac Id:"+e);
			}
	//Added against NMC-JD-CRF-0014 ends.
	
	//V211109
	try{
		String sql = "SELECT COUNT (*) FROM sm_function_control a, sm_site_param b  WHERE a.site_id = b.customer_id AND module_id = 'BL'  AND functionality_id = 'PACK_GRP_SETUP_AMD_PD'";
		System.out.println("sql for Package Group Function Control:"+sql);
		pstmt1 = con.prepareStatement(sql);
		rs1 = pstmt1.executeQuery();	
		if(rs1.next())
		{
			pkgGrpEnabledCount=rs1.getInt(1);
			System.out.println("BLAmendMultiServicePriceMain.jsp:count for Package Group Function Control:"+pkgGrpEnabledCount);
		}		
		
		if(pkgGrpEnabledCount > 0)
			isPkgGrpEnabledYN = true;
		else
			isPkgGrpEnabledYN = false;
	}catch(Exception e){
		System.out.println("BLAmendMultiServicePriceMain.jsp:Exception in Package Group Function Control Query :"+e);
		e.printStackTrace();
	}finally{
		if(rs1!=null) rs1.close();
		if(pstmt1!=null) pstmt1.close();		
	}
	
	boolean SiteSpecNMC=false;
	String siteSpecNMC_disable="N";
	if(SiteSpecNMC){
		siteSpecNMC_disable="Y";
	}
	
	try{
		SiteSpecNMC = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_ENABLE_CMN_FUN_ME_YN");		
	} catch(Exception e){
		System.err.println("Exception in SiteSpecNMC "+e);
	}
	
	String servInd = request.getParameter("servInd");
	String servCode = request.getParameter("servCode");
	System.err.println("106==>"+servCode);
	String servDesc =request.getParameter("serviceDescription");
	System.err.println("107==>"+servDesc);
	String priceInd = request.getParameter("priceInd");
	String priceCode = request.getParameter("priceCode");
	String policyCode = request.getParameter("policyCode");
	String custGrpCode = request.getParameter("custGrpCode");
	String blngClass = request.getParameter("blngClass");
	if("A".equals(blngClass)){
		blngClass = "**";
	}
	String effFrom = request.getParameter("effFrom");
	String effTo = request.getParameter("effTo");
	//Added V181005-Gayathri/MMS-DM-SCF-0243.1/Starts
	
	String basePrice="", averageCost="", computedValue="",defSelect="",rateBasisInd="",custGrpDesc="",policyDesc="",priceDesc="";

	BlServiceDiscPriceBean blDiscPriceBean = null;
	BlServiceDiscPriceBean callingObj = new BlServiceDiscPriceBean();

	String disabled = "disabled";
	String readonly = "readonly";
	String recDisabled="disabled";
	String cust_code="";
	String cust_des="";
	String toDateDisabled = "", discToDateDisabled = "";//Added V190830-Aravindh/PMG2019-NMC-JD-CRF-0002
	System.err.println("mode:"+mode);
	if("modify".equals(mode)){
		blDiscPriceBean = callingObj.loadDescriptions(facility_id, servInd, servCode, priceInd, priceCode, custGrpCode, policyCode, blngClass, locale, effFrom, mode, effTo);
		System.err.println("blDiscPriceBean.getServInd()--"+blDiscPriceBean.getServInd());
		 servInd = blDiscPriceBean.getServInd();
		 servCode = blDiscPriceBean.getServCode();
		 servDesc= blDiscPriceBean.getServDesc();
		 priceInd = blDiscPriceBean.getPriceInd();
		 blngClass =  blDiscPriceBean.getBlngClassCode();
		 
		 if(priceInd.equals("C")){
			 System.err.println("priceInd.equals C");
			cust_code=blDiscPriceBean.getPriceCode();
			cust_des=  blDiscPriceBean.getPriceDesc();
			disabled="";
			recDisabled="disabled";
			priceCode="";
			priceDesc="";
			policyCode =  blDiscPriceBean.getPolicyCode();
			policyDesc =  blDiscPriceBean.getPolicyDesc();
			custGrpCode =  blDiscPriceBean.getCustGrpCode();
			custGrpDesc =  blDiscPriceBean.getCustGrpDesc();
			 System.err.println("priceInd.equals C--"+policyDesc);
		}
		else{
			disabled = "disabled";
			cust_code="";
			cust_des="";
			policyCode =  "";
			policyDesc =  "";
			custGrpCode = "";
			custGrpDesc = "";
			 priceCode =  blDiscPriceBean.getPriceCode();
			priceDesc =  blDiscPriceBean.getPriceDesc();
		}	
	}
	else if("add".equals(mode)){
		disabled = "";
		readonly = "";
		recDisabled="";
		blDiscPriceBean = callingObj.loadDescriptions(facility_id, servInd, servCode, priceInd, priceCode, custGrpCode, policyCode, blngClass, locale, effFrom, mode, effTo);
	}
	else
	{
		readonly = "";
		recDisabled="";
		disabled = "";
		blDiscPriceBean = callingObj.loadDescriptions(facility_id, servInd, servCode, priceInd, priceCode, custGrpCode, policyCode, blngClass, locale, effFrom, mode, effTo);
			
		if(priceInd.equals("C")){
			System.err.println("priceInd.equals C");
			cust_code=blDiscPriceBean.getPriceCode();
			cust_des=  blDiscPriceBean.getPriceDesc();
			disabled="";
			recDisabled="disabled";
			priceCode="";
			priceDesc="";
			policyCode =  blDiscPriceBean.getPolicyCode();
			policyDesc =  blDiscPriceBean.getPolicyDesc();
			custGrpCode =  blDiscPriceBean.getCustGrpCode();
			custGrpDesc =  blDiscPriceBean.getCustGrpDesc();
			System.err.println("priceInd.equals C--"+policyDesc);

			if("**".equals(custGrpCode))
				custGrpDesc = "All Payer Group";

			if("**".equals(cust_code))
				custGrpDesc = "All Payer";			

			if("**".equals(policyCode))
				policyDesc = "All Policy";			
		}
		else
		{
			disabled = "disabled";
			cust_code="";
			cust_des="";
			policyCode =  "";
			policyDesc =  "";
			custGrpCode = "";
			custGrpDesc = "";
			priceCode =  blDiscPriceBean.getPriceCode();
			priceDesc =  blDiscPriceBean.getPriceDesc();
		}			
	}
	System.err.println("blDiscPriceBean.getServInd()--"+blDiscPriceBean.getServInd());
	System.err.println("mode--"+mode);
		
	// Added disabledForPackageGroup condition for enable/disable Rate option for V211109
	if("PG".equals(blDiscPriceBean.getServInd())){
		disabledForPackageGroup = "disabled";
	} else {
		disabledForPackageGroup = "";
	}
	System.err.println("disabledForPackageGroup--"+disabledForPackageGroup);
	System.err.println("servInd--"+servInd);
	System.err.println("servCode--"+servCode);
	
	//Changes done for MMS-KH-SCF-0187 by Manivel N
	if(!"".equals(servCode))
		retValPH=callingObj.isServMatBased(servCode,servInd);
	
	System.err.println("retValPH--"+retValPH);
%>
<html>
<head>
<script>
function fnApplyDiscPrice(val)
	{	
		if(val.checked==true || val.checked=='true')
			parent.BLMultiDiscPrice.location.href ='../../eBL/jsp/BLMultiDiscPriceCreate.jsp';
		else
			parent.BLMultiDiscPrice.location.href ='../../eCommon/html/blank.html';
	}

function chkMMItemServYN()
{		
	var servCode = parent.BLServiceDiscPrice.frmDiscPriceCreate.service_code.value;
	var servInd = parent.BLServiceDiscPrice.frmDiscPriceCreate.service_ind.value;
	var frm2 = parent.BLMultiPricedtls.Pricedtlsbulkadd;
	
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();			
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	var temp_jsp="../../eBL/jsp/BLServiceDiscPriceValidation.jsp?servCode="+servCode+"&functionMode=chkMMItemServYN&servInd="+servInd;
	xmlHttp.open("GET",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var retValPH = trimString(xmlHttp.responseText);
	//alert("242,retValPH==>"+retValPH);
	document.getElementById("retValPH").value=retValPH;
	//alert("244===>"+document.getElementById("retValPH").value);
	var rowCount = parent.BLMultiPricedtls.Pricedtlsbulkadd.querySelector("#inclRowCnt").value;

	for(var i=1;i<=rowCount;i++){
		var isPublicMandEnableYN = frm2.querySelector("#isPublicMandEnableYN_"+i);		
		var isBasisEnableYN = frm2.querySelector("#isBasisEnableYN_"+i);	
		if(retValPH == "Y"){
			isPublicMandEnableYN.style.visibility = "visible";
			isBasisEnableYN.style.visibility = "visible";
		} else{
			isPublicMandEnableYN.style.visibility = "hidden";
			isBasisEnableYN.style.visibility = "hidden";			
		}
	}
}
</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/BLServiceDiscountPrice.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	
</head>
<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" >
	<form  method='post' name = 'frmDiscPriceCreate' id='frmDiscPriceCreate' target='messageFrame' >	
      	<table width='100%' cellpadding='3'  cellspacing=0 align="center" >  
      	  <tr>
      			<td align="left" width='20%'  nowrap>
      				<fmt:message key="eBL.CUSTOMER_DTL.label" bundle="${bl_labels}"></fmt:message> 
      			</td>
      		</tr>
      		<tr>
      			<td width='20%'  nowrap class='label'>
      				<fmt:message key="Common.facility.label" bundle="${common_labels}"></fmt:message>
      			</td>
      			<td colspan='2' nowrap class='fields'>
			<!-- 	//Added NMC-JD-CRF-0014 by shikha on 200902 -->
				<% 
				if(("insert".equals(mode) || "add".equals(mode)) ) {
				%>
      				<select name='facility' id='facility' id='facility' >
						<!--Added against NMC-JD-CRF-0014 starts-->	
							<% 
							try{
								//Added NMC-JD-CRF-0014 by shikha on 200902
							String sqlFacility = "";
							/*
							if(siteSpecfacid.equals("Y")){
								sqlFacility="select facility_id , facility_name  from Sm_Facility_Param where status = 'E' and facility_id = '"+facility_id+"' union select '**' ,'All Facility'  from dual";
							}else{*/
								//Ended NMC-JD-CRF-0014 by shikha on 200902
								sqlFacility = "select facility_id, facility_name from Sm_Facility_Param where status = 'E' and facility_id = '"+facility_id+"'";
							//}	//Commented NMC-JD-CRF-0014 by shikha on 200902
							pstmt = con.prepareStatement(sqlFacility);
							rst = pstmt.executeQuery();							
							if(rst != null){
								while(rst.next()){									
							%>	
									<option value="<%=rst.getString(1)%>"><%=rst.getString(2) %></option>	
							<%								
							} } 
							%>
							<% if(siteSpecfacid.equals("Y")){ %>
								<option value="**">All Facility</option>
							<% } %>
							<!--Added against NMC-JD-CRF-0014 ends-->	
						</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
						<%
							//Added NMC-JD-CRF-0014 by shikha on 200902
							} catch(Exception e){
								System.err.println("Exception "+e);
							}
						} else {
								if (blDiscPriceBean.getFacilityId().equals("**")) {
								%>
									<input type="text" <%=readonly %> name='facility' id='facility' size='20' maxlength="20" width="100" value="All Facility">
									<input type="hidden" <%=readonly %> name='Facility_id' id='Facility_id' size='20' maxlength="20" width="100" value="<%=blDiscPriceBean.getFacilityId()%>"><!-- V210310 -->
								<%}else {
								try{
							String sqlFacility = "";							
							sqlFacility = "select  facility_name from Sm_Facility_Param where status = 'E' and facility_id = '"+blDiscPriceBean.getFacilityId()+"'";							
							pstmt = con.prepareStatement(sqlFacility);
							rst = pstmt.executeQuery();
							if(rst != null){
								while(rst.next()){%>	
									<input type="text" <%=readonly %> name='facility' id='facility' size='20' maxlength="20" width="100" value="<%=rst.getString(1)%>">
									<input type="hidden" <%=readonly %> name='Facility_id' id='Facility_id' size='20' maxlength="20" width="100" value="<%=blDiscPriceBean.getFacilityId()%>"><!-- V210217 -->
								<%}
								}
								} catch(Exception e){
										System.err.println("Exception "+e);
									}
							}
						}
							//Added NMC-JD-CRF-0014 by shikha on 200902
						%>
      				</td>
      		</tr>
      		<tr>
      			<td width='20%' nowrap class='label'>
      				<fmt:message key="eBL.ServiceInd.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='20%' nowrap class='fields'>
      				<Select name='service_ind' id='service_ind' id='service_ind' <%=recDisabled%> onchange="servOnChange(this);clearBGDesc('servInd')">
							<option value='A' <%=servInd.equals("A")?"selected":""%>><fmt:message key="Common.Select.label" bundle="${common_labels }"></fmt:message></option>
	      					<option value='BSG'  <%=servInd.equals("BSG")?"selected":""%>><fmt:message key="eBL.BillingServiceGroup.label" bundle="${bl_labels}"></fmt:message></option>	      				
	      					<option value='B'  <%=servInd.equals("B")?"selected":""%>><fmt:message key="eBL.BillingService.label" bundle="${bl_labels}"></fmt:message></option>
      						<option value='BSC'  <%=servInd.equals("BSC")?"selected":""%>><fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}"></fmt:message></option>
							<!-- V211109 -->
						<%if(isPkgGrpEnabledYN){
							if("PG".equals(servInd)){ %>
      						<option value='PG' selected="selected"><fmt:message key="eBL.PackageGrouping.label" bundle="${bl_labels}"></fmt:message></option>
	      				<%}
	      				else{%>
	      					<option value='PG'><fmt:message key="eBL.PackageGrouping.label" bundle="${bl_labels}"></fmt:message></option>
	      				<%} }%>
					</Select>&nbsp;<img src='../../eCommon/images/mandatory.gif'> 
      			</td>
				<%
				
			%>	
				<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.ServiceCode.label" bundle="${bl_labels}"></fmt:message>
      			</td>
				<td width='20%' nowrap class='fields'>
      				<input type="text" name='service_code' id='service_code' id='service_code' size='20' maxlength="20" <%=recDisabled%> value="<%=servCode%>" onblur="if(this.value!=''){ callBGDescCode(1,service_ind,service_desc,service_code); chkMMItemServYN();} else{ fnClearCode(service_desc); }">    			
      				<input type='button' class='button' id='service_code_btn' name="service_code_btn" id="service_code_btn" <%=recDisabled%> value='?'  onClick="callBGDescCode(1,service_ind,service_desc,service_code); chkMMItemServYN();" tabindex='2'>
      				&nbsp;<img src='../../eCommon/images/mandatory.gif'>
      			</td>
      			
				<td width='25%'  nowrap class='label'>
      				<fmt:message key="eBL.ServiceDescription.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='25%' nowrap class='fields'>      					
      					<input type="text" name='service_desc' id='service_desc' id='service_desc' size='20' maxlength="20" <%=recDisabled%> value="<%=servDesc%>" onblur="if(this.value!=''){ callBGDesc(1,service_ind,service_desc,service_code); chkMMItemServYN();} else{ fnClearCode(service_code); }">&nbsp;
      			</td>
      		</tr>      		
      		<tr>
      			<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.PriceInd.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='20%' nowrap class='fields'>
				
				<!-- Added disabledForPackageGroup condition for enable/disable Standard and Price class options for V211109 -->
      				<Select name='price_ind' id='price_ind' id='price_ind' <%=recDisabled%> onchange="clearBGDesc('priceInd')" >      
      				<option value='' <%=priceInd.equals("")?"selected":""%>><fmt:message key="Common.Select.label" bundle="${common_labels }"></fmt:message></option>
      					<option value="S" <%=priceInd.equals("S")?"selected":""%> <%=disabledForPackageGroup%>><fmt:message key="Common.Standard.label" bundle="${common_labels }"></fmt:message> </option>
      					<option value="B" <%=priceInd.equals("B")?"selected":""%>><fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels}"></fmt:message></option>
      					<option value="C" <%=priceInd.equals("C")?"selected":""%>><fmt:message key="Common.Customer.label" bundle="${common_labels }"></fmt:message></option>
      					<option value="P" <%=priceInd.equals("P")?"selected":""%> <%=disabledForPackageGroup%>><fmt:message key="eBL.HCMasterPriceClass.label" bundle="${bl_labels}"></fmt:message></option>
      				</Select>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
				</td>
					<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.PriceCode.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='20%' nowrap class='fields'>
      				<input type="text" name='price_code' id='price_code' id='price_code' size='20' maxlength="20" <%=recDisabled%> value="<%=priceCode%>" onblur="if(this.value!=''){ callBGDescCode(2,price_ind,price_desc,price_code); } else{ fnClearCode(price_desc); }">
					
     				<input type='button' class='button' id='price_code_btn' name="price_code_btn" id="price_code_btn" <%=recDisabled%> value='?'  onClick="callBGDescCode(2,price_ind,price_desc,price_code);" tabindex='2'>
      				&nbsp;<img src='../../eCommon/images/mandatory.gif'>
      			</td>
				<td width='25%'  nowrap class='label'>
      				<fmt:message key="eBL.PriceDescription.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='25%' nowrap class='fields'>
      					<input type="text" name='price_desc' id='price_desc' id='price_desc' size='40' <%=recDisabled%> maxlength="40" value="<%=priceDesc%>" onblur="if(this.value!=''){ callBGDesc(2,price_ind,price_desc,price_code); } else{ fnClearCode(price_code); }">&nbsp;

      			</td>
      		</tr>
			<tr>
      			<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.CustGroupCode.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='20%' nowrap class='fields'>
      				<input type="text"  name='cust_grp_code' id='cust_grp_code' id='cust_grp_code' disabled tabindex='2' size='20' maxlength="20" value="<%=custGrpCode%>" onblur="if(this.value!=''){ callCommonValidation(1,cust_grp_desc,cust_grp_code); } else{ fnClearCode(cust_grp_desc);}">
      			    <input type='button'  class='button' id='cust_grp_code_btn' disabled name="cust_grp_code_btn" id="cust_grp_code_btn" value='?'  onClick="callCommonValidation(1,cust_grp_desc,cust_grp_code);" tabindex='2'>
      				&nbsp;<img src='../../eCommon/images/mandatory.gif'>
      			</td>
				<td width='25%'  nowrap class='label'>
      				<fmt:message key="eBL.CustGroupDesc.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='25%' nowrap class='fields'>
      					<input type="text" name='cust_grp_desc' id='cust_grp_desc' id='cust_grp_desc'  disabled size='20' maxlength="20" value="<%=custGrpDesc%>" onblur="if(this.value!=''){ callCommonValidation(1,cust_grp_desc,cust_grp_code); } else{ fnClearCode(cust_grp_code); }">&nbsp;
      			</td>
				<tr>
				<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.cust_code.label" bundle="${bl_labels}"></fmt:message>
      			</td>
				<td width="10%" nowrap class='fields' >
					<input type='text' name='cust_code' id='cust_code' id='cust_code' size="10" tabindex='2' disabled value="<%=cust_code%>" onblur="if(this.value!=''){ callCommonValidationCode(4,cust_desc,cust_code); } else{ fnClearCode(cust_desc); }">&nbsp;
					<input type='button' class='button' name="custBtn" id="custBtn"  disabled id='custBtn' value='?' onClick="callCommonValidationCode(4,cust_desc,cust_code)" tabindex='2'>					
				<img src='../../eCommon/images/mandatory.gif'>	
				</td>      			
				<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.cust_description.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='20%' nowrap class='fields'>
      					<input type="text"  name='cust_desc' id='cust_desc' id='cust_desc'  disabled size='40' maxlength="40" value="<%=cust_des%>" onblur="if(this.value!=''){ callCommonValidationCode(4,cust_desc,cust_code); } else{ fnClearCode(cust_code); }">&nbsp;
      			</td>
			</tr>
				
				<tr>
      			<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.policy_code.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='20%' nowrap class='fields'>
      				<input type="text" name='policy_code' id='policy_code' id='policy_code' tabindex='2' disabled size='20' maxlength="20" value="<%=policyCode%>" onblur="if(this.value!=''){ callCommonValidationCode(2,policy_desc,policy_code); } else{ fnClearCode(policy_desc); }">
				<input type='button' class='button' id='policy_code_btn'  disabled name="policy_code_btn" id="policy_code_btn" value='?'  onClick="callCommonValidation(2,policy_desc,policy_code);" tabindex='2'>
      				&nbsp;<img src='../../eCommon/images/mandatory.gif'>
      			</td>
      			<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.PolicyDesc.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='20%' nowrap class='fields'>
      					<input type="text" name='policy_desc' id='policy_desc' id='policy_desc' size='40'  disabled maxlength="40" value="<%=policyDesc%>" onblur="if(this.value!=''){ callCommonValidation(2,policy_desc,policy_code); } else{ fnClearCode(policy_code); }">&nbsp;
      			</td>
      		</tr>
			</table>
				<input type='hidden' name='disabled' id='disabled' id='disabled' value='<%=disabled%>'>
      			<input type='hidden' name='pageId' id='pageId' id='pageId' value='Bulk'>
				<input type='hidden' name='lastRowIndex' id='lastRowIndex' id='lastRowIndex' value=''>
				<input type='hidden' name='inclRowCount' id='inclRowCount' value='<%=tableIndex -1 %>'>
				<input type='hidden' name='discDtls<%=tableIndex%>' id='discDtls<%=tableIndex%>' value=''>
      	      	<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
      			<input type='hidden' name='facilityid' id='facilityid' value='<%=facility_id %>'>
      			<input type='hidden' name='mode' id='mode' id='mode' value='<%=mode %>'>
      			<input type='hidden' name='hdnFacility' id='hdnFacility' value=''>
      			<input type='hidden' name='hdnServiceInd' id='hdnServiceInd' value=''>
      			<input type='hidden' name='hdnPriceInd' id='hdnPriceInd' value=''>
      			<input type='hidden' name='disCount' id='disCount' value='<%=blDiscPriceBean.getDiscountCnt() %>'>
      			<input type='hidden' name='serviceind' id='serviceind' id='serviceind' value='<%=servInd%>'> <!-- V210217 -->
				<input type='hidden' name='isPkgGrpEnabledYN' id='isPkgGrpEnabledYN' id='isPkgGrpEnabledYN' value='<%=isPkgGrpEnabledYN%>'>
				
				<input type='hidden' name='retValPH' id='retValPH' id='retValPH' value='<%=retValPH%>'>
				<input type='hidden' name='called' id='called' id='called' value='Maindtls'>
     </form>
	  	
</body>
</html>

