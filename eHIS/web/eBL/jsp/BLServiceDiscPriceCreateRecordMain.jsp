<!DOCTYPE html>
<!-- Page Added by Rajesh V. Price Discount Create Record -->    
<!-- 
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210217            14525 	       	MMS-JU-SCF-0164		           Mohana Priya K
2			 V211109			7871			MMS-QH-CRF-0128				   Manivel Natarajan
3			 V211115			25887			PMG2021-MMS-CRF-0004.1		   Nandhini M
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
	
	int pkgGrpEnabledCount = 0; // V211109
	boolean isPkgGrpEnabledYN = false; // V211109
	String disabledForPackageGroup = ""; // V211109
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
			System.out.println("count for Package Group Function Control:"+pkgGrpEnabledCount);
		}		
		
		if(pkgGrpEnabledCount > 0)
			isPkgGrpEnabledYN = true;
		else
			isPkgGrpEnabledYN = false;
	}catch(Exception e){
		System.out.println("Exception in Package Group Function Control Query :"+e);
		e.printStackTrace();
	}finally{
		if(rs1!=null) rs1.close();
		if(pstmt1!=null) pstmt1.close();		
	}
	String servInd = request.getParameter("servInd");
	String servCode = request.getParameter("servCode");
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
	String basePrice="", averageCost="", computedValue="",defSelect="",rateBasisInd="";
	/**/
	//servInd = "B";
	//servCode = "CR";
	//priceInd = "C";
	//priceCode = "000020";
	//policyCode = "";
	//custGrpCode = "";
	//blngClass = "C2";
	//mode = "insert";
	/**/
	BlServiceDiscPriceBean blDiscPriceBean = null;
	BlServiceDiscPriceBean callingObj = new BlServiceDiscPriceBean();
	boolean SiteSpecNMC=false;
	String disabled = "disabled";
	String readonly = "readonly";
	String recDisabled="disabled";
	String toDateDisabled = "", discToDateDisabled = "";//Added V190830-Aravindh/PMG2019-NMC-JD-CRF-0002
	//try{
		if("modify".equals(mode)){
			//disabled = "disabled";
			//readonly = "readonly";
			blDiscPriceBean = callingObj.loadDescriptions(facility_id, servInd, servCode, priceInd, priceCode, custGrpCode, policyCode, blngClass, locale, effFrom, mode, effTo);
		}
		else if("add".equals(mode)){
			disabled = "";
			readonly = "";
			recDisabled="";
			blDiscPriceBean = callingObj.loadDescriptions(facility_id, servInd, servCode, priceInd, priceCode, custGrpCode, policyCode, blngClass, locale, effFrom, mode, effTo);
		}
		else{
			readonly = "";
			recDisabled="";
			disabled = "";
			blDiscPriceBean = callingObj.loadDescriptions(facility_id, servInd, servCode, priceInd, priceCode, custGrpCode, policyCode, blngClass, locale, effFrom, mode, effTo);
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
	//}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onLoad="checkForDiscountEntry()">
	<form  method='post' name = 'frmDiscPriceCreate' id='frmDiscPriceCreate' target='messageFrame' >	
      	<table width='95%' cellpadding='3'  cellspacing=0 align="center">  
      	   <%
						
			try{ %>
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
							} } %>
							<% if(siteSpecfacid.equals("Y")){ %>
								<option value="**">All Facility</option>
							<% } %>
							<!--Added against NMC-JD-CRF-0014 ends-->	
						</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
						<%
							//Added NMC-JD-CRF-0014 by shikha on 200902
						} else {
								if (blDiscPriceBean.getFacilityId().equals("**")) {
								%>
									<input type="text" <%=readonly %> name='facility' id='facility' size='20' maxlength="20" width="100" value="All Facility">
									<input type="hidden" <%=readonly %> name='Facility_id' id='Facility_id' size='20' maxlength="20" width="100" value="<%=blDiscPriceBean.getFacilityId()%>"><!-- V210310 -->
								<%}else {
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
							}
						}
							//Added NMC-JD-CRF-0014 by shikha on 200902
						%>
      				</td>
      			</td>
      		</tr>
      		<tr>
      			<td width='20%' nowrap class='label'>
      				<fmt:message key="eBL.ServiceInd.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='20%' nowrap class='fields'>
      				<Select name='service_ind' id='service_ind' id='service_ind' onchange="clearBGDesc('servInd')" <%=disabled %>>
      					<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels }"></fmt:message></option>
      					<%if("BSG".equals(blDiscPriceBean.getServInd())){ %>
      						<option value='BSG' selected="selected"><fmt:message key="eBL.BillingServiceGroup.label" bundle="${bl_labels}"></fmt:message></option>
	      				<%}
	      				else{%>
	      					<option value='BSG'><fmt:message key="eBL.BillingServiceGroup.label" bundle="${bl_labels}"></fmt:message></option>
	      				<%} %>
	      				
	      				<%if("B".equals(blDiscPriceBean.getServInd())){ %>
      						<option value='B' selected="selected"><fmt:message key="eBL.BillingService.label" bundle="${bl_labels}"></fmt:message></option>
	      				<%}
	      				else{%>
	      					<option value='B'><fmt:message key="eBL.BillingService.label" bundle="${bl_labels}"></fmt:message></option>
	      				<%} %>
	      				
	      				<%if("BSC".equals(blDiscPriceBean.getServInd())){ %>
      						<option value='BSC' selected="selected"><fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}"></fmt:message></option>
	      				<%}
	      				else{%>
	      					<option value='BSC'><fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}"></fmt:message></option>
	      				<%} %>
						<!-- V211109 -->
						<%if(isPkgGrpEnabledYN){
							if("PG".equals(blDiscPriceBean.getServInd())){ %>
      						<option value='PG' selected="selected"><fmt:message key="eBL.PackageGrouping.label" bundle="${bl_labels}"></fmt:message></option>
	      				<%}
	      				else{%>
	      					<option value='PG'><fmt:message key="eBL.PackageGrouping.label" bundle="${bl_labels}"></fmt:message></option>
	      				<%} }%>
																
					</Select>&nbsp;<img src='../../eCommon/images/mandatory.gif'> 
      			</td>
      			<td width='10%' nowrap>
      			
      			</td>
      			<td width='25%'  nowrap class='label'>
      			
      			</td>
      			<td width='25%' nowrap class='fields'>
      			
      			</td>
      		</tr>
			<%
				SiteSpecNMC = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_ENABLE_CMN_FUN_ME_YN");		
			} catch(Exception e){
				System.err.println("Exception "+e);
			}
			%>		
      		<tr>
      			<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.ServiceCode.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='20%' nowrap class='fields'>
      			<%if("disabled".equals(disabled)){ %>
      				<input type="text" <%=readonly %> name='service_code' id='service_code' size='20' maxlength="20" value="<%= blDiscPriceBean.getServCode()%>">
      			<%} else { %>
      				<input type="text" <%=readonly %> name='service_code' id='service_code' size='20' maxlength="20" value="<%= blDiscPriceBean.getServCode()%>" onblur="if(this.value!=''){ callBGDescCode(1,service_ind,service_desc,service_code); } else{ fnClearCode(service_desc); }">
      			<%} %>
      				<input type='button' <%=disabled %> class='button' id='service_code_btn' name="service_code_btn" value='?'  onClick="callBGDesc(1,service_ind,service_desc,service_code);" tabindex='2'>
      				&nbsp;<img src='../../eCommon/images/mandatory.gif'>
      			</td>

      			<td width='10%' nowrap>

      			</td>
      			<td width='25%'  nowrap class='label'>
      				<fmt:message key="eBL.ServiceDescription.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='25%' nowrap class='fields'>
      				<%if("disabled".equals(disabled)){ %>
      					<input type="text" <%=readonly %> name='service_desc' id='service_desc' size='40' maxlength="40" value="<%= blDiscPriceBean.getServDesc()%>" >&nbsp;
      				<%}
      				else{%>
      					<input type="text" <%=readonly %> name='service_desc' id='service_desc' size='40' maxlength="40" value="<%= blDiscPriceBean.getServDesc()%>" onblur="if(this.value!=''){ callBGDesc(1,service_ind,service_desc,service_code); } else{ fnClearCode(service_code); }">&nbsp;
      				<%} %>
      				
      			</td>
      		</tr>
      		<tr>
      			<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.PriceInd.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='20%' nowrap class='fields'>
				<!-- Added disabledForPackageGroup condition for enable/disable Standard and Price class options for V211109 -->
      				<Select name='price_ind' id='price_ind' id='price_ind' onchange="clearBGDesc('priceInd')" <%=disabled %>>      
      				<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels }"></fmt:message></option>
      				<%if("S".equals(blDiscPriceBean.getPriceInd())){ %>
      					<option value="S" selected="selected" <%=disabledForPackageGroup%>><fmt:message key="Common.Standard.label" bundle="${common_labels }"></fmt:message> </option>
      				<%}
      				else{%>
      					<option value="S" <%=disabledForPackageGroup%>><fmt:message key="Common.Standard.label" bundle="${common_labels }"></fmt:message> </option>
      				<%} %>
      				
      				<%if("B".equals(blDiscPriceBean.getPriceInd())){ %>
      					<option value="B" selected="selected"><fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels}"></fmt:message></option>
      				<%}
      				else{%>
      					<option value="B" ><fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels}"></fmt:message></option>
      				<%} %>
      				
      				<%if("C".equals(blDiscPriceBean.getPriceInd())){ %>
      					<option value="C" selected="selected"><fmt:message key="Common.Customer.label" bundle="${common_labels }"></fmt:message></option>
      				<%}
      				else{%>
      					<option value="C" ><fmt:message key="Common.Customer.label" bundle="${common_labels }"></fmt:message></option>
      				<%} %>
      				
      				<%if("P".equals(blDiscPriceBean.getPriceInd())){ %>
      					<option value="P" selected="selected" <%=disabledForPackageGroup%>><fmt:message key="eBL.HCMasterPriceClass.label" bundle="${bl_labels}"></fmt:message></option>
      				<%}
      				else{%>
      					<option value="P" <%=disabledForPackageGroup%>><fmt:message key="eBL.HCMasterPriceClass.label" bundle="${bl_labels}"></fmt:message></option>
      				<%} %>
      				</Select>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
      			</td>
      			<td width='10%' nowrap>
      			
      			</td>
      			<td width='25%'  nowrap class='label'>
      			
      			</td>
      			<td width='25%' nowrap class='fields'>
      			
      			</td>
      		</tr>
      		<tr>
      			<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.PriceCode.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='20%' nowrap class='fields'>
      			<%if("disabled".equals(disabled)){ %>
      				<input type="text" <%=readonly %> name='price_code' id='price_code' size='20' maxlength="20" value="<%= blDiscPriceBean.getPriceCode()%>">
      			<%}
      			else{%>
      				<input type="text" <%=readonly %> name='price_code' id='price_code' size='20' maxlength="20" value="<%= blDiscPriceBean.getPriceCode()%>" onblur="if(this.value!=''){ callBGDescCode(2,price_ind,price_desc,price_code); } else{ fnClearCode(price_desc); }">
      			<%} %>
     				<input type='button' <%=disabled %> class='button' id='price_code_btn' name="price_code_btn" value='?'  onClick="callBGDesc(2,price_ind,price_desc,price_code);" tabindex='2'>
      				&nbsp;<img src='../../eCommon/images/mandatory.gif'>
      			</td>
      			<td width='10%' nowrap>
      			
      			</td>
      			<td width='25%'  nowrap class='label'>
      				<fmt:message key="eBL.PriceDescription.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='25%' nowrap class='fields'>
      				<%if("disabled".equals(disabled)){ %>
      					<input type="text" <%=readonly %> name='price_desc' id='price_desc' size='40' maxlength="40" value="<%= blDiscPriceBean.getPriceDesc()%>" >&nbsp;
      				<%}
      				else{%>
      					<input type="text" <%=readonly %> name='price_desc' id='price_desc' size='40' maxlength="40" value="<%= blDiscPriceBean.getPriceDesc()%>" onblur="if(this.value!=''){ callBGDesc(2,price_ind,price_desc,price_code); } else{ fnClearCode(price_code); }">&nbsp;
      				<%} %>
      				
      			</td>
      		</tr>

			<tr>
      			<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.CustGroupCode.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='20%' nowrap class='fields'>
      			<%if("disabled".equals(disabled)){ %>
      				<input type="text" <%=readonly %> name='cust_grp_code' id='cust_grp_code' size='20' maxlength="20" value="<%= blDiscPriceBean.getCustGrpCode()%>">
      			<%}
      			else{%>
      				<input type="text" <%=readonly %> name='cust_grp_code' id='cust_grp_code' size='20' maxlength="20" value="<%= blDiscPriceBean.getCustGrpCode()%>" onblur="if(this.value!=''){ callCommonValidationCode(1,cust_grp_desc,cust_grp_code); } else{ fnClearCode(cust_grp_desc);fnClearPolicy(this); }">
      			<%} %>
      				
      			    <input type='button' <%=disabled %> class='button' id='cust_grp_code_btn' name="cust_grp_code_btn" value='?'  onClick="callCommonValidation(1,cust_grp_desc,cust_grp_code);" tabindex='2'>
      				&nbsp;<img src='../../eCommon/images/mandatory.gif'>
      			</td>
      			<td width='10%' nowrap>
      			
      			</td>
      			<td width='25%'  nowrap class='label'>
      				<fmt:message key="eBL.CustGroupDesc.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='25%' nowrap class='fields'>
      				<%if("disabled".equals(disabled)){ %>
      					<input type="text" <%=readonly %> name='cust_grp_desc' id='cust_grp_desc' size='40' maxlength="40" value="<%= blDiscPriceBean.getCustGrpDesc()%>" >&nbsp;
      				<%}
      				else{%>
      					<input type="text" <%=readonly %> name='cust_grp_desc' id='cust_grp_desc' size='40' maxlength="40" value="<%= blDiscPriceBean.getCustGrpDesc()%>" onblur="if(this.value!=''){ callCommonValidation(1,cust_grp_desc,cust_grp_code); } else{ fnClearCode(cust_grp_code); }">&nbsp;
      				<%} %>
      				
      			</td>
      		</tr>

      		<tr>
      			<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.PolicyCode.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='20%' nowrap class='fields'>
      			<%if("disabled".equals(disabled)){ %>
      				<input type="text" <%=readonly %> name='policy_code' id='policy_code' size='20' maxlength="20" value="<%= blDiscPriceBean.getPolicyCode()%>">
      			<%}
      			else{%>
      				<input type="text" <%=readonly %> name='policy_code' id='policy_code' size='20' maxlength="20" value="<%= blDiscPriceBean.getPolicyCode()%>" onblur="if(this.value!=''){ callCommonValidationCode(2,policy_desc,policy_code); } else{ fnClearCode(policy_desc); }">
      			<%} %>
      				
      				<input type='button' <%=disabled %> class='button' id='policy_code_btn' name="policy_code_btn" value='?'  onClick="callCommonValidation(2,policy_desc,policy_code);" tabindex='2'>
      				&nbsp;<img src='../../eCommon/images/mandatory.gif'>
      			</td>
      			<td width='10%' nowrap>
      			
      			</td>
      			<td width='25%'  nowrap class='label'>
      				<fmt:message key="eBL.PolicyDesc.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='25%' nowrap class='fields'>
      				<%if("disabled".equals(disabled)){ %>
      					<input type="text" <%=readonly %> name='policy_desc' id='policy_desc' size='40' maxlength="40" value="<%= blDiscPriceBean.getPolicyDesc()%>" >&nbsp;
      				<%}
      				else{%>
      					<input type="text" <%=readonly %> name='policy_desc' id='policy_desc' size='40' maxlength="40" value="<%= blDiscPriceBean.getPolicyDesc()%>" onblur="if(this.value!=''){ callCommonValidation(2,policy_desc,policy_code); } else{ fnClearCode(policy_code); }">&nbsp;
      				<%} %>
      				
      			</td>
      		</tr>
      		
      		<tr>
      			<td class='COLUMNHEADER' nowrap colspan="5">
      				<fmt:message key="eBL.PriceDetails.label" bundle="${bl_labels}"></fmt:message> 
      			</td>
      		</tr>
      		<tr>
      			<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.BillingClass.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='20%' nowrap class='fields'>
      			<%if("disabled".equals(disabled)){ %>
      				<input type="text" <%=readonly %> name='billing_class' id='billing_class' size='20' maxlength="20" value="<%= blDiscPriceBean.getBlngClassCode()%>">
      			<%}
      			else{%>
      				<input type="text" <%=readonly %> name='billing_class' id='billing_class' size='20' maxlength="20" value="<%= blDiscPriceBean.getBlngClassCode()%>" onblur="if(this.value!=''){ callCommonValidationCode(3,billing_desc,billing_class); } else{ fnClearCode(billing_desc); }">
      			<%} %>
      				
      				<input type='button' <%=disabled %> class='button' id='billing_class_btn' name="billing_class_btn" value='?'  onClick="callCommonValidation(3,billing_desc,billing_class);" tabindex='2'>
      				&nbsp;<img src='../../eCommon/images/mandatory.gif'>
      			</td>
      			<td width='10%' nowrap>
      			
      			</td>
      			<td width='25%'  nowrap class='label'>
      				<fmt:message key="eBL.Description.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='25%' nowrap class='fields'>
      				<%if("disabled".equals(disabled)){ %>
      					<input type="text" <%=readonly %> name='billing_desc' id='billing_desc' size='40' maxlength="40" value="<%= blDiscPriceBean.getBlngClassDesc()%>" >&nbsp;
      				<%}
      				else{%>
      					<input type="text" <%=readonly %> name='billing_desc' id='billing_desc' size='40' maxlength="40" value="<%= blDiscPriceBean.getBlngClassDesc()%>" onblur="if(this.value!=''){ callCommonValidation(3,billing_desc,billing_class); } else{ fnClearCode(billing_class); }">&nbsp;
      				<%} %>
      				
      			</td>
      		</tr>
      		<tr>
      			<td width='20%'  nowrap class='label'>
      				Rate Factor
      			</td>
      			<td width='20%' nowrap class='fields'>
      				<!-- Modified V190828-Aravindh/PMG2019-NMC-JD-CRF-0002/Added disabled -->
					<!-- Added disabledForPackageGroup condition for enable/disable Rate option for V211109 -->
      				<select name='price_ind_bot' id='price_ind_bot' id='price_ind_bot' <%=disabled %>>
      					<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels }"></fmt:message></option>
      					<%if("R".equals(blDiscPriceBean.getRatePriceInd())){ %>
      						<option value="R" selected="selected" <%=disabledForPackageGroup%>><fmt:message key="eBL.RATE.label" bundle="${bl_labels }"></fmt:message> </option>
      					<%}
      					else{%>
      						<option value="R" <%=disabledForPackageGroup%>><fmt:message key="eBL.RATE.label" bundle="${bl_labels }"></fmt:message> </option>
      					<%} %>
      					
      					<%if("F".equals(blDiscPriceBean.getRatePriceInd())){ %>
      						<option value="F" selected="selected"><fmt:message key="eBL.FACTOR.label" bundle="${bl_labels }"></fmt:message> </option>
      					<%}
      					else{%>
      						<option value="F" ><fmt:message key="eBL.FACTOR.label" bundle="${bl_labels }"></fmt:message> </option>
      					<%} %>
      				</select> 
      				<%if("disabled".equals(disabled)) { %>
      					<input type='hidden' name='price_ind_bot' id='price_ind_bot' id='price_ind_bot' value='<%=blDiscPriceBean.getRatePriceInd() %>' /><!-- Added V190830-Aravindh/PMG2019-NMC-JD-CRF-0002 -->
      				<% } %>
      			</td>
      			<td width='10%' nowrap>
      			
      			</td>
      			<td width='25%'  nowrap class='label'>
      				<fmt:message key="eBL.ChkCostAvl.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='25%' nowrap class='fields'>
      			<%if("Y".equals(blDiscPriceBean.getChkCostAvl())){ %>
      				<!-- Modified V190828-Aravindh/PMG2019-NMC-JD-CRF-0002/Added disabled -->
      				<input type="checkbox" name='checkCostAvl' id='checkCostAvl' id='checkCostAvl' onclick= 'fnChkChkBox();' checked  <%=disabled %> />  
      				<%} 
      			else{%>
      				<!-- Modified V190828-Aravindh/PMG2019-NMC-JD-CRF-0002/Added disabled --> 
      				<input type="checkbox" name='checkCostAvl' id='checkCostAvl' id='checkCostAvl' onclick= 'fnChkChkBox();' <%=disabled %> />  
      			<%} %>
      			<%if("disabled".equals(disabled)) { %>
   					<input type='hidden' name='checkCostAvl' id='checkCostAvl' id='checkCostAvl' value='<%=blDiscPriceBean.getChkCostAvl() %>' /><!-- Added V190830-Aravindh/PMG2019-NMC-JD-CRF-0002 -->
   				<% } %>
      			</td>
      		</tr>
      		<tr>
      			<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.CostIndicator.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='20%' nowrap class='fields'>
      				<select name='cost_ind' id='cost_ind' id='cost_ind' <%=disabled %>>
      					<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels }"></fmt:message></option>
      					<%if("A".equals(blDiscPriceBean.getCostInd())){ %>
      						<option value="A" selected="selected"><fmt:message key="eBL.Amount.label" bundle="${bl_labels}"></fmt:message> </option>
	      				<%}
	      				else{%>
	      					<option value="A"><fmt:message key="eBL.Amount.label" bundle="${bl_labels}"></fmt:message> </option>
	      				<%} %>
	      				
	      				<%if("P".equals(blDiscPriceBean.getCostInd())){ %>
      						<option value="P" selected="selected"><fmt:message key="eBL.Percentage.label" bundle="${bl_labels}"></fmt:message></option>
	      				<%}
	      				else{%>
	      					<option value="P"><fmt:message key="eBL.Percentage.label" bundle="${bl_labels}"></fmt:message></option>
	      				<%} %>
	      				
      				</select>
      				<%if("disabled".equals(disabled)) { %>
	   					<input type='hidden' name='cost_ind' id='cost_ind' id='cost_ind' value='<%=blDiscPriceBean.getCostInd() %>' /><!-- Added V190830-Aravindh/PMG2019-NMC-JD-CRF-0002 -->
	   				<% } %>
      			</td>
      			<td width='10%' nowrap>
      			
      			</td>
      			<td width='25%'  nowrap class='label'>
      				<fmt:message key="eBL.CostAmt.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='25%' nowrap class='fields'>
      				<input type="text" name='cost_amt' id='cost_amt'  id='cost_amt' size='20' maxlength="20" value='<%=blDiscPriceBean.getCostAmt() %>' readOnly>
      			</td>
      		</tr>
      		<tr>
      			<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.RATE.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='20%' nowrap class='label' align="center">
      				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      				<fmt:message key="eBL.IP.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='10%' nowrap class='label' align="center">
      				<fmt:message key="eBL.OP.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='25%'  nowrap class='label' align="center">
      				<fmt:message key="eBL.EM.label" bundle="${bl_labels}"></fmt:message>
      				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      				<fmt:message key="eBL.EX.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='25%' nowrap class='label' align="left">
      				<fmt:message key="eBL.DC.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      		</tr>
      		<tr>
      			<td width='20%'  nowrap class='label'>
      				
      			</td>
      			<td width='20%' nowrap class='label' align="center">
      				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      				<input type="text" name='ip_rate' id='ip_rate' id='ip_rate' size='15' maxlength="15" onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" <%=readonly %> value='<%=blDiscPriceBean.getIpRate() %>'>
      			</td>
      			<td width='10%' nowrap class='label' align="center">
      				<input type="text" name='op_rate' id='op_rate' id='op_rate' size='15' maxlength="15" onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" <%=readonly %> value='<%=blDiscPriceBean.getOpRate() %>'>
      			</td>
      			<td width='25%'  nowrap class='label' align="center">
      				<input type="text" name='em_rate' id='em_rate' id='em_rate' size='15' maxlength="15" onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" <%=readonly %> value='<%=blDiscPriceBean.getEmRate() %>'>
      				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      				<input type="text" name='ex_rate' id='ex_rate' id='ex_rate' size='15' maxlength="15" onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" <%=readonly %> value='<%=blDiscPriceBean.getExRate() %>'>
      			</td>
      			<td width='25%' nowrap class='label' align="left">
      				<input type="text" name='dc_rate' id='dc_rate' id='dc_rate' size='15' maxlength="15" onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" <%=readonly %> value='<%=blDiscPriceBean.getDcRate() %>'>
      			</td>
      		</tr>
      		<tr>
      			<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.MIN_CHARGE.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='20%' nowrap class='fields'>
      				<input type="text" name='min_charge' id='min_charge' id='min_charge' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" size='20' maxlength="20" value='<%=blDiscPriceBean.getMinCharge() %>' <%=readonly %> />
      				<!-- Modified V190828-Aravindh/PMG2019-NMC-JD-CRF-0002/Added readonly -->
      			</td>
      			<td width='10%' nowrap>
      			
      			</td>
      			<td width='25%'  nowrap class='label'>
      				<fmt:message key="eBL.MAX_CHARGE.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='25%' nowrap class='fields'>
      				<input type="text" name='max_charge' id='max_charge' id='max_charge' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" size='20' maxlength="20" value='<%=blDiscPriceBean.getMaxCharge() %>' <%=readonly %> />
      				<!-- Modified V190828-Aravindh/PMG2019-NMC-JD-CRF-0002/Added readonly -->
      			</td>
      		</tr>
      		<tr>
      			<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.BASE_QTY.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='20%' nowrap class='fields'>
      				<input type="text" name='base_qty' id='base_qty' id='base_qty' onkeypress="return checkForNumChars(event)" onblur="checkForNumber(this)" size='20' maxlength="20" value='<%=blDiscPriceBean.getBaseQty() %>' <%=readonly %> />
      				<!-- Modified V190828-Aravindh/PMG2019-NMC-JD-CRF-0002/Added readonly -->
      			</td>
      			<td width='10%' nowrap>
      			
      			</td>
      			<td width='25%'  nowrap class='label'>
      				<fmt:message key="eBL.Applicability.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='25%' nowrap class='fields'>
      				<!-- Modified V190828-Aravindh/PMG2019-NMC-JD-CRF-0002/Added disabled -->
      				<select name='applicability' id='applicability' id='applicability' <%=disabled %> >
      					<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels }"></fmt:message></option>	      				
	      				<%if("G".equals(blDiscPriceBean.getPriceApplicability())){ %>
      						<option value="G" selected="selected"><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"></fmt:message> </option>
	      				<%}
	      				else{%>
	      					<option value="G"><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"></fmt:message> </option>
	      				<%} %>
	      				
	      				<%if("N".equals(blDiscPriceBean.getPriceApplicability())){ %>
      						<option value="N" selected="selected"><fmt:message key="eBL.Net.label" bundle="${bl_labels}"></fmt:message></option>
	      				<%}
	      				else{%>
	      					<option value="N"><fmt:message key="eBL.Net.label" bundle="${bl_labels}"></fmt:message></option>
	      				<%} %>
      				</select>
      				<%if("disabled".equals(disabled)) { %>
	   					<input type='hidden' name='applicability' id='applicability' id='applicability' value='<%=blDiscPriceBean.getPriceApplicability() %>' /><!-- Added V190830-Aravindh/PMG2019-NMC-JD-CRF-0002 -->
	   				<% } %>
      			</td>
      		</tr>
      		<tr>
      			<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.ApplyDiscount.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='20%' nowrap class='fields'>
      			<%if("Y".equals(blDiscPriceBean.getApplyDiscount())){ %>
      				<!-- Modified V190828-Aravindh/PMG2019-NMC-JD-CRF-0002/Added disabled -->
      				<input type="checkbox" name='apply_discount' id='apply_discount' id='apply_discount' onclick='fnApplyDisc();' checked  <%=disabled %> />
      				<%}
      			else{%>
      				<!-- Modified V190828-Aravindh/PMG2019-NMC-JD-CRF-0002/Added disabled -->
      				<input type="checkbox" name='apply_discount' id='apply_discount' id='apply_discount' onclick='fnApplyDisc();'  <%=disabled %> />
      			<%} %>
      			<%if("disabled".equals(disabled)) { %>
   					<input type='hidden' name='apply_discount_hdn' id='apply_discount_hdn' id='apply_discount_hdn' value='<%=blDiscPriceBean.getApplyDiscount()%>' /><!-- Added V190830-Aravindh/PMG2019-NMC-JD-CRF-0002 -->
   				<% } %>
      			</td>
      			<td width='10%' nowrap>
      			
      			</td>
      			<td width='25%'  nowrap class='label'>
      				
      			</td>
      			<td width='25%' nowrap class='fields'>
      				
      			</td>
      		</tr>
      		<%String dateDisabled = ""; 
      		String dateReadonly = "";
		//Added V181005-Gayathri/MMS-DM-SCF-0243.1 Starts
      		String rateIndDisabled = ""; 
			String setupAmendPrice="Y";
			String publicchk_disabled="";
			String siteSpecNMC_disable="N";
			
      		if(!("".equals(blDiscPriceBean.getPriceEffFrom()))){
      			dateDisabled = "disabled";
      			dateReadonly = "readonly";
      		}
      		
      		if(("modify").equals(mode)){
      			rateIndDisabled="disabled";
      		} else{
      			rateIndDisabled="";
      		} //Added V181005-Gayathri/MMS-DM-SCF-0243.1
	
			if(SiteSpecNMC){
				siteSpecNMC_disable="Y";
				try {
					pstmt=con.prepareStatement("select blcommonproc.bl_mat_linked_ser_yn(?,?,?) from dual");
					pstmt.setString(1,blDiscPriceBean.getServInd());
					pstmt.setString(2,blDiscPriceBean.getServCode());
					pstmt.setString(3,locale);
					
					rs = pstmt.executeQuery();
					while (rs.next()) {
						setupAmendPrice =rs.getString(1);
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("setupAmendPrice" + e);
				} finally {
					ConnectionManager.returnConnection(con);
					pstmt = null;
					rst = null;
					rs = null;
				}	
		
				if("N".equals(setupAmendPrice)){
					publicchk_disabled="disabled";
				}
			}
      		
      		if(!"".equals(blDiscPriceBean.getPriceEffTo())) {//Added V190830-Aravindh/PMG2019-NMC-JD-CRF-0002
      			toDateDisabled = "disabled";
      		}
      		
      		if(!"".equals(blDiscPriceBean.getDiscEffTo())) {//Added V190830-Aravindh/PMG2019-NMC-JD-CRF-0002
      			discToDateDisabled = "disabled";
      		}
      		%>
      		<tr>
      			<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.EffectiveFromTo.label" bundle="${bl_labels}"></fmt:message>
      			</td>
				<!-- //Added V181005-Gayathri/MMS-DM-SCF-0243.1/Starts-->
      			<td colspan='2' nowrap class='fields'>
      				<input type='text' name='effFromDate' id='effFromDate'  <%=dateDisabled %> size='15' maxlength='15' onBlur='isValidDate(this);' value='<%=blDiscPriceBean.getPriceEffFrom() %>' />
      				<%if("disabled".equals(dateDisabled) && "modify".equals(mode)) { %>
      					<input type='hidden' name='effFromDate' id='effFromDate' id='effFromDate' value='<%=blDiscPriceBean.getPriceEffFrom() %>' />
      				<% } %>
					<img src='../../eCommon/images/CommonCalendar.gif'  id='effFromDate_ctrl' onClick="return showCalendar('effFromDate');" <%=dateDisabled %> />
					&nbsp;<img src='../../eCommon/images/mandatory.gif'>&nbsp; -
					<input type='text' name='effToDate' id='effToDate'   size='15' maxlength='15' onBlur='isValidDate(this);dfltDiscToDate(this,document.forms[0].discToDate,document.forms[0].apply_discount);' value='<%=blDiscPriceBean.getPriceEffTo() %>' />
					<img src='../../eCommon/images/CommonCalendar.gif'  id='effToDate_ctrl' onClick="return showCalendar('effToDate');"  />
      			</td>
      			<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.Public.label" 			bundle="${bl_labels}"	/>&nbsp;
      				<%if("Y".equals(blDiscPriceBean.getSt_item_public_price_chk_yn())){ %>
	      				<input type="checkbox" name='public_chk' id='public_chk' id='public_chk'  checked <%=rateIndDisabled %>>
    		  		<%} else {%> 
		      			<input type="checkbox" name='public_chk' id='public_chk' id='public_chk' <%=rateIndDisabled %> <%=publicchk_disabled%>>  
		      		<%} %> 
		      		<%if("disabled".equals(rateIndDisabled)) { %>
	   					<input type='hidden' name='public_chk' id='public_chk' id='public_chk' value='<%=blDiscPriceBean.getSt_item_public_price_chk_yn() %>' /><!-- Added V190830-Aravindh/PMG2019-NMC-JD-CRF-0002 -->
	   				<% } %>
      			</td>      		     			
      			<%
      			rateBasisInd=blDiscPriceBean.getSt_item_rate_basis_ind();
    			System.out.println("rateBasisInd  "+rateBasisInd);
    			basePrice=("B").equals(rateBasisInd) ?"SELECTED" :"";
    			averageCost=("C").equals(rateBasisInd) ?"SELECTED" :"";
    			computedValue=("V").equals(rateBasisInd) ?"SELECTED" :"";
    			defSelect=("").equals(rateBasisInd) ?"SELECTED" :"";
      			%>
      			<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.Basis.label" 			bundle="${bl_labels}"	/>&nbsp;
      			
	      			<select name='rateBasisInd' id='rateBasisInd' onChange=""  <%=rateIndDisabled %> <%=publicchk_disabled%>> 
		      			<option value='' <%=defSelect%>>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<option value='B' <%=basePrice%> ><fmt:message key="eBL.BASE_PRICE.label" bundle="${bl_labels}"/></option>
						<option value='C' <%=averageCost%> ><fmt:message key="eBL.AVERAGE_COST.label" bundle="${bl_labels}"/></option>
						<option value='V' <%=computedValue%>><fmt:message key="eBL.COMPUTED_VALUE.label" bundle="${bl_labels}"/></option>
					</select>
					<!-- //Added V181005-Gayathri/MMS-DM-SCF-0243.1/Ends-->
					<%if("disabled".equals(rateIndDisabled)) { %>
	   					<input type='hidden' name='rateBasisInd' id='rateBasisInd' id='rateBasisInd' value='<%=blDiscPriceBean.getSt_item_rate_basis_ind() %>' /><!-- Added V190830-Aravindh/PMG2019-NMC-JD-CRF-0002 -->
	   				<% } %>		
						<!--Added against 	PMG2021-MMS-CRF-0004.1 V211115-->
						<img id ='commonmandatory' src='../../eCommon/images/mandatory.gif' style='visibility:hidden'>
	   				
					<% 
					String disableDiscAppl = ""; 
					if("".equals(blDiscPriceBean.getDiscInd())){
						disableDiscAppl="disabled";
					}
					%>
				</td>
      		</tr>
      		<tr>
      			<td class='COLUMNHEADER' nowrap colspan="5">
      				<fmt:message key="eBL.DiscountDetails.label" bundle="${bl_labels}"></fmt:message> 
      			</td>
      		</tr>
      		<tr>
      			<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.DiscountIndicator.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='20%' nowrap class='fields'>
      				<Select name='discInd' id='discInd' id='discInd' onchange="fnDiscInd()" <%=disabled %>>
      					<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels }"></fmt:message></option>
	      				<%if("A".equals(blDiscPriceBean.getDiscInd())){ %>
      						<option value="A" selected="selected"><fmt:message key="eBL.Amount.label" bundle="${bl_labels}"></fmt:message> </option>
	      				<%}
	      				else{%>
	      					<option value="A"><fmt:message key="eBL.Amount.label" bundle="${bl_labels}"></fmt:message> </option>
	      				<%} %>
	      				
	      				<%if("P".equals(blDiscPriceBean.getDiscInd())){ %>
      						<option value="P" selected="selected"><fmt:message key="eBL.Percentage.label" bundle="${bl_labels}"></fmt:message></option>
	      				<%}
	      				else{%>
	      					<option value="P"><fmt:message key="eBL.Percentage.label" bundle="${bl_labels}"></fmt:message></option>
	      				<%} %>
	      			</Select>
	      			<%if("disabled".equals(disabled)) { %>
	   					<input type='hidden' name='discInd' id='discInd' id='discInd' value='<%=blDiscPriceBean.getDiscInd() %>' /><!-- Added V190830-Aravindh/PMG2019-NMC-JD-CRF-0002 -->
	   				<% } %>
	      			<img src='../../eCommon/images/mandatory.gif'>
      			</td>
      			<td colspan='3'>
      				
      			</td>
      		</tr>
      		<%
      		dateDisabled = "";
  			dateReadonly = "";
      		if(!("".equals(blDiscPriceBean.getDiscEffFrom())) || !"Y".equals(blDiscPriceBean.getApplyDiscount())){
      			dateDisabled = "disabled";
      			dateReadonly = "readonly";
      		}
      		%>
      		<tr>
      			<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.DiscFromTo.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td colspan='4' nowrap class='fields'>
      				<input type='text' name='discFromDate' id='discFromDate' id='discFromDate' size='15' maxlength='15' onBlur='isValidDate(this);' value='<%=blDiscPriceBean.getDiscEffFrom()  %>' <%=dateDisabled %> />
      				<%if("disabled".equals(dateDisabled) && "modify".equals(mode)) { %>
      					<input type='hidden' name='discFromDate' id='discFromDate' id='discFromDate' value='<%=blDiscPriceBean.getDiscEffFrom() %>' />
      				<% } %>
					<img src='../../eCommon/images/CommonCalendar.gif'  id='discFromDate_ctrl' onClick="return showCalendar('discFromDate');" <%=disabled %> />
					&nbsp;<img src='../../eCommon/images/mandatory.gif'>&nbsp; -
					<input type='text' name='discToDate' id='discToDate' id='discToDate'  size='15' maxlength='15' onBlur='isValidDate(this);' value='<%=blDiscPriceBean.getDiscEffTo()  %>' <%=disableDiscAppl%> />
					<img src='../../eCommon/images/CommonCalendar.gif'  id='discToDate_ctrl' onClick="return showCalendar('discToDate');" <%=disableDiscAppl%> />
      			</td>

      		</tr>

      		<tr>
      			<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.DiscountPercentage.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='20%' nowrap class='label' align="center">
      				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      				<fmt:message key="eBL.IP.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='10%' nowrap class='label' align="center">
      				<fmt:message key="eBL.OP.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='25%'  nowrap class='label' align="center">
      				<fmt:message key="eBL.EM.label" bundle="${bl_labels}"></fmt:message>
      				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      				<fmt:message key="eBL.EX.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='25%' nowrap class='label' align="left">
      				<fmt:message key="eBL.DC.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      		</tr>
      		<tr>
      			<td width='20%'  nowrap class='label'>
      				
      			</td>
      			<td width='20%' nowrap class='label' align="center">
      				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      				<input type="text" name='discPer_ip' id='discPer_ip' id='discPer_ip' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" size='15' maxlength="15" value='<%=blDiscPriceBean.getIpDiscRate()  %>' <%=readonly %> />
      			</td>
      			<td width='10%' nowrap class='label' align="center">
      				<input type="text" name='discPer_op' id='discPer_op' id='discPer_op' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" size='15' maxlength="15" value='<%=blDiscPriceBean.getOpDiscRate()  %>' <%=readonly %> />
      			</td>
      			<td width='25%'  nowrap class='label' align="center">
      				<input type="text" name='discPer_em' id='discPer_em' id='discPer_em' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" size='15' maxlength="15" value='<%=blDiscPriceBean.getEmDiscRate()  %>' <%=readonly %> />
      				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      				<input type="text" name='discPer_ex' id='discPer_ex' id='discPer_ex' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" size='15' maxlength="15" value='<%=blDiscPriceBean.getExDiscRate()  %>'  <%=readonly %> />
      			</td>
      			<td width='25%' nowrap class='label' align="left">
      				<input type="text" name='discPer_dc' id='discPer_dc' id='discPer_dc' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" size='15' maxlength="15" value='<%=blDiscPriceBean.getDcDiscRate()  %>' <%=readonly %> />
      			</td>
      		</tr>
      		<tr>
      			<td width='20%'  nowrap class='label'>
      				<fmt:message key="eBL.DiscApplicability.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='20%' nowrap class='fields'>
      				<select name='discAppl' id='discAppl' id='discAppl' <%=disabled %>>
      				eBL.PAYABLE_AMT.label
      					<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels }"></fmt:message></option>
      					<%if("T".equals(blDiscPriceBean.getDiscApplicability())){ %>
      						<option value="T" selected="selected">Total Amount </option>
	      				<%}
	      				else{%>
	      					<option value="T">Total Amount </option>
	      				<%} %>
	      				
	      				<%if("P".equals(blDiscPriceBean.getDiscApplicability())){ %>
      						<option value="P" selected="selected"><fmt:message key="eBL.PAYABLE_AMT.label" bundle="${bl_labels}"></fmt:message></option>
	      				<%}
	      				else{%>
	      					<option value="P"><fmt:message key="eBL.PAYABLE_AMT.label" bundle="${bl_labels}"></fmt:message></option>
	      				<%} %>
	      				
	      				<%if("X".equals(blDiscPriceBean.getDiscApplicability())){ %>
      						<option value="X" selected="selected"><fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"></fmt:message></option>
	      				<%}
	      				else{%>
	      					<option value="X"><fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"></fmt:message></option>
	      				<%} %>
	      				
	      				<%if("C".equals(blDiscPriceBean.getDiscApplicability())){ %>
      						<option value="C" selected="selected"><fmt:message key="Common.patient.label" bundle="${common_labels}"></fmt:message></option>
	      				<%}
	      				else{%>
	      					<option value="C"><fmt:message key="Common.patient.label" bundle="${common_labels}"></fmt:message></option>
	      				<%} %>
      				</select>
      				<%if("disabled".equals(disabled)) { %>
	   					<input type='hidden' name='discAppl' id='discAppl' id='discAppl' value='<%=blDiscPriceBean.getDiscApplicability() %>' /><!-- Added V190830-Aravindh/PMG2019-NMC-JD-CRF-0002 -->
	   				<% } %>
      				<img src='../../eCommon/images/mandatory.gif'>
      			</td>
      			<td colspan='3'></td>
      		</tr>
      		<tr>
      			<td width='20%'  nowrap class='label'>
      				<fmt:message key="Common.Enable.label" bundle="${common_labels}"></fmt:message>
      			</td>
      			<td width='20%' nowrap class='fields'>
      				<%if("Y".equals(blDiscPriceBean.getEnable())) { %>
      					<input type="checkbox" name='enable' id='enable' id='enable' checked="checked"  <%=disabled %> />
      				<%} else {%>
      					<input type="checkbox" name='enable' id='enable' id='enable'  <%=disabled %> />
      				<%}%>
      				<%if("disabled".equals(disabled)) { %>
	   					<input type='hidden' name='enable' id='enable' id='enable' value='<%=blDiscPriceBean.getEnable() %>' /><!-- Added V190830-Aravindh/PMG2019-NMC-JD-CRF-0002 -->
	   				<% } %>
      			</td>
      			<td colspan='3'></td>
      		</tr>
      		
      		<tr>
      		<td colspan='4'>
      		</td>
      		<td width='25%' nowrap class='fields'>
      			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      			<input type='button' class='button' id='record_btn' name="record_btn" id="record_btn" onclick='fnRecord();' value='<fmt:message key="Common.record.label" bundle="${common_labels}"></fmt:message>' tabindex='2'>      				
      			&nbsp;&nbsp;&nbsp;&nbsp;
      			<input type='button' class='button' id='cancel_btn' name="cancel_btn" id="cancel_btn" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"></fmt:message>'  onClick="fnCancel();" tabindex='2'>
      		</td>
      		</tr>
      	</table>
      	      	<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
      			<input type='hidden' name='facilityId' id='facilityId' value='<%=facility_id %>'>
      			<input type='hidden' name='mode' id='mode' id='mode' value='<%=mode %>'>
      			<input type='hidden' name='hdnFacility' id='hdnFacility' value=''>
      			<input type='hidden' name='hdnServiceInd' id='hdnServiceInd' value=''>
      			<input type='hidden' name='hdnPriceInd' id='hdnPriceInd' value=''>
      			<input type='hidden' name='disCount' id='disCount' value='<%=blDiscPriceBean.getDiscountCnt() %>'>
      			<input type='hidden' name='SiteSpecNMC' id='SiteSpecNMC' value='<%=siteSpecNMC_disable%>'>
      			<input type='hidden' name='service_ind' id='service_ind' id='service_ind' value='<%=servInd%>'> <!-- V210217 -->
				<input type='hidden' name='isPkgGrpEnabledYN' id='isPkgGrpEnabledYN' id='isPkgGrpEnabledYN' value='<%=isPkgGrpEnabledYN%>'>
      			
     </form>
	<%if("Y".equals(blDiscPriceBean.getApplyDiscount())){ %>
		<script>
			fnApplyDisc();
		</script>
	<%}
	if("Y".equals(blDiscPriceBean.getChkCostAvl()) && !"modify".equals(mode)){ %>
	<script>
		fnChkChkBox();
	</script>
	<%}%>      	
</body>
</html>

