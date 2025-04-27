<!DOCTYPE html>
<!-- 
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V201030            74099         NMC-JD-CRF-0011.1       MuthukumarN
2			 V210503			17598			Common-ICN-0034		  MuthukumarN
3			 V220419						  NMC-JD-CRF-0150.1		  Nandhini M
-----------------------------------------------------------------------------------
-->

<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,eCommon.Common.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src='../../eBL/js/PkgParameter.js'></script> 
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script type="text/javascript">
//if(dailyLimitSiteSpec==true){
	$(document).ready(function()
	{
		var formObj = document.forms[0];
		if(formObj.dailyPkgLimitChk.checked) {
			$("#dailyPkgLimitSlct option[value='*']").remove();
			$("#pkgServiceLimitBy option[value='*']").remove();
		}
	});//Added V190617-Aravindh/MMS-DM-CRF-0129.1
//}

function pkgLimitChange(){
	document.getElementById("currPkgLimitIndSlct").value=document.getElementById("PkgLimitIndSlct").value;
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<% 
	Connection con = ConnectionManager.getConnection();	
	PreparedStatement pstmt = null; 
	ResultSet rs = null;
	try
	{		
		String locale		= (String)session.getAttribute("LOCALE");
		String facilityId	= (String) session.getValue( "facility_id" ) ;
		String pkgStatus	= "N";
		String pkgBkDateD       = "";
		String glSmryYN		= "N";
		String glSmryDesc	= "";
		String valdDForOrd	= "";
		String unAvaldSrvCode	= "";
		String unAvaldSrvDesc	= "";
		String autoRefundYN 	= "";
		String valdRefundD   	= "";
		String disableAll	= "";
		String facility_name="";
		String pat_dep_for_pkg_code="";
		String pat_dep_for_pkg_desc="";
		String pkgDepositYN 	= "";//Added for NMC-JD-CRF-0084 Starts palani narayanan V210128
		String pkgAcrossEnctrYN = "N"; //Added by Nandhini for NMC-JD-CRF-0150.1 V220419
		
		String pkgServiceLimitBy = "", dailyPkgLimitYN = "", dailyPkgLimitBy = "";//Added V190617-Aravindh/MMS-DM-CRF-0129.1
		String pkgCustDiscNewPkgYN ="N", pkgCustDiscByPlcyYN ="N";//Added against V200612-MuthuN/MMS-QH-CRF-0128.1-US001 & US004
		String PkgLimitIndBy="",PkgLimitIndYN = ""; //MMS-QH-CRF-0170-US-5  PALANINARAYANAN 1/7/2020
		
		//V201030
		String autoDistPkgVarServiceOPYN ="";
		String autoDistPkgVarPharMedItemsOPYN ="";
		String autoDistPkgVarServiceIPYN ="";
		String autoDistPkgVarPharMedItemsIPYN ="";
		//V201030


		boolean dailyLimitSiteSpec = false;//Added V190617-Aravindh/MMS-DM-CRF-0129.1
		boolean packageLimitSiteSpec = false; //MMS-QH-CRF-0170-US-5  PALANINARAYANAN 1/7/2020 
		/* Added V190617-Aravindh/MMS-DM-CRF-0129.1/Starts */
		 //MMS-QH-CRF-0170-US-5  PALANINARAYANAN 1/7/2020
		boolean enableCmnFunMESiteSpec = false;//V201030
		try {
			dailyLimitSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_ENABLE_DAILY_PKG_SERV_LIMIT");
			packageLimitSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_ENABLE_PKG_SERV_IND_LIMIT");//MMS-QH-CRF-0170-US-5  PALANINARAYANAN 1/7/2020
			enableCmnFunMESiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_ENABLE_CMN_FUN_ME_YN");//V201030
		} catch(Exception ex) {
			System.err.println("Error in PkgParametersDtls.jsp: "+ex);
			ex.printStackTrace();
		}
		/* Added V190617-Aravindh/MMS-DM-CRF-0129.1/Ends */

		//Added against V200613-MuthuN/MMS-QH-CRF-0128.1-US001 & US004
		boolean blAutoPkgDiscSiteSpec = false;
		try{
			blAutoPkgDiscSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_AUTO_APPLY_PKG_DISC_YN");
		}catch(Exception ex) {
			System.err.println("Error in PkgParametersDtls.jsp: "+ex);
			ex.printStackTrace();
		}
		
		//Added for NMC-JD-CRF-0084 Starts palani narayanan V210128
		boolean blPkgDepositSubscription = false;
		try{
			blPkgDepositSubscription = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_PKG_DEPOSIT_SUBSCRIPTION_YN");
			}catch(Exception ex) {
				System.err.println("Error in PkgParametersDtls.jsp: "+ex);
				ex.printStackTrace();
			}
		//Added for NMC-JD-CRF-0084 Ends palani narayanan V210128
		
		//Added against V200613-MuthuN/MMS-QH-CRF-0128.1-US001 & US004
		String sql = "select a.PACKAGE_ENABLED_YN PACKAGE_ENABLED_YN, a.PKG_EFF_FRM_BACKDATE_DAYS PKG_EFF_FRM_BACKDATE_DAYS, a.gl_post_for_pkg_by_summary_yn gl_post_for_pkg_by_summary_yn, a.valid_days_for_pkg_orders valid_days_for_pkg_orders,a.auto_refund_for_pkg_yn auto_refund_for_pkg_yn, a.valid_days_for_pkg_refund valid_days_for_pkg_refund,a.UNAVAIL_PKG_BLNG_SERV_CODE UNAVAIL_PKG_BLNG_SERV_CODE,a.pat_dep_for_pkg  pat_dep_for_pkg_code,(select SHORT_DESC from BL_RECEIPT_TYPE_lang_vw where RECEIPT_TYPE_CODE=a.pat_dep_for_pkg and language_id=? ) pat_dep_for_pkg_desc, pkg_serv_lmt_by pkg_serv_lmt_by, daily_pkg_lmt_yn daily_pkg_lmt_yn, daily_pkg_lmt_by daily_pkg_lmt_by, pkg_cust_disc_new_pkg, pkg_cust_disc_by_policy,a.PKG_LIMIT_IND_YN,a.PKG_LIMIT_IND_BY,op_auto_pkg_var_dist_serv,    op_auto_pkg_var_dist_ph, ip_auto_pkg_var_dist_serv, ip_auto_pkg_var_dist_ph,a.pkg_deposit_sub_reqd_yn from bl_parameters a where a.OPERATING_FACILITY_ID =? ";
		//Modified V190617-Aravindh/MMS-DM-CRF-0129.1/Added 3 more columns in the above qry -> pkg_serv_lmt_by, daily_pkg_lmt_yn, daily_pkg_lmt_by //V201030
		pstmt=con.prepareStatement(sql);	
		pstmt.setString(1,locale);
		pstmt.setString(2,facilityId);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			pkgStatus	  = checkForNull(rs.getString("PACKAGE_ENABLED_YN"),"N");
			if(pkgStatus.equals("N"))
			{
				  disableAll	= "disabled ";
				  pkgBkDateD	= "" ;
				  glSmryYN	= "N";
				  valdDForOrd	= "";
				  unAvaldSrvCode= "";
				  autoRefundYN	= "N";
				  unAvaldSrvCode= "";
			}
			else
			{
				pkgBkDateD = checkForNull(rs.getString("PKG_EFF_FRM_BACKDATE_DAYS"));	
				glSmryYN     = checkForNull(rs.getString("gl_post_for_pkg_by_summary_yn"),"N");
				valdDForOrd	= checkForNull(rs.getString("valid_days_for_pkg_orders"));	
				autoRefundYN = checkForNull(rs.getString("auto_refund_for_pkg_yn"),"N");	
				valdRefundD  = checkForNull(rs.getString("valid_days_for_pkg_refund"));	
				unAvaldSrvCode = checkForNull(rs.getString("UNAVAIL_PKG_BLNG_SERV_CODE"));	
				disableAll = "";
			}
				pat_dep_for_pkg_code=checkForNull(rs.getString("pat_dep_for_pkg_code"),"");
				pat_dep_for_pkg_desc=checkForNull(rs.getString("pat_dep_for_pkg_desc"),"");
				pkgServiceLimitBy = checkForNull(rs.getString("pkg_serv_lmt_by"),"*");//Added V190617-Aravindh/MMS-DM-CRF-0129.1
				dailyPkgLimitYN = checkForNull(rs.getString("daily_pkg_lmt_yn"),"N");//Added V190617-Aravindh/MMS-DM-CRF-0129.1
				dailyPkgLimitBy = checkForNull(rs.getString("daily_pkg_lmt_by"),"*");//Added V190617-Aravindh/MMS-DM-CRF-0129.1
				//Added against V200612-MuthuN/MMS-QH-CRF-0128.1-US001 & US004
				if(blAutoPkgDiscSiteSpec){
					pkgCustDiscNewPkgYN = checkForNull(rs.getString("pkg_cust_disc_new_pkg"),"N");
					pkgCustDiscByPlcyYN = checkForNull(rs.getString("pkg_cust_disc_by_policy"),"N");				
				}
				//Added against V200612-MuthuN/MMS-QH-CRF-0128.1-US001 & US004
				//MMS-QH-CRF-0170-US-5  PALANINARAYANAN 1/7/2020 
				PkgLimitIndYN = checkForNull(rs.getString("PKG_LIMIT_IND_YN"),"N");
				PkgLimitIndBy = checkForNull(rs.getString("PKG_LIMIT_IND_BY"),"*");
				//MMS-QH-CRF-0170-US-5  PALANINARAYANAN 1/7/2020

				//V201030 Starts
				if(enableCmnFunMESiteSpec){
					autoDistPkgVarServiceOPYN = checkForNull(rs.getString("op_auto_pkg_var_dist_serv"),"N");
					autoDistPkgVarPharMedItemsOPYN = checkForNull(rs.getString("op_auto_pkg_var_dist_ph"),"N");
					autoDistPkgVarServiceIPYN = checkForNull(rs.getString("ip_auto_pkg_var_dist_serv"),"N");
					autoDistPkgVarPharMedItemsIPYN = checkForNull(rs.getString("ip_auto_pkg_var_dist_ph"),"N");
				}
				//V201030 Ends
				//Added for NMC-JD-CRF-0084 Starts palani narayanan V210128
				if(blPkgDepositSubscription)
				{
					pkgDepositYN	  = checkForNull(rs.getString("PKG_DEPOSIT_SUB_REQD_YN"),"Y");
				}
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		
		sql = "select facility_name from sm_facility_param where facility_id=?";
		pstmt=con.prepareStatement(sql);	
		pstmt.setString(1,facilityId);
		rs = pstmt.executeQuery();
		if(rs!=null && rs.next()){
			facility_name=rs.getString("facility_name");
		}
		//Added by Nandhini against NMC-JD-CRF-0150.1 V220419
		sql = "select NVL(ENABLE_ACROSS_ENC_FLAG_PKG,'N') ENABLE_ACROSS_ENC_FLAG_PKG from bl_parameters";
		pstmt=con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if(rs!=null && rs.next()){
			pkgAcrossEnctrYN= rs.getString("ENABLE_ACROSS_ENC_FLAG_PKG");
			System.err.println("191,pkgAcrossEnctrYN==>"+pkgAcrossEnctrYN);
		} 
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

	%>
	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" >
	
	<form name='frmPkgParametersDtls' id='frmPkgParametersDtls' >
		<BR><BR><BR><BR><BR>
	<table border='0' cellpadding='1' cellspacing='1' align='center' width='100%'>
	<tr>
	
	<td  class="label" width="40%">
	<fmt:message key="Common.facility.label" bundle="${common_labels}"/> 
	</td>			
	<td  class='fields'  width="60%"><input type="text" name='dispFacilityId' id='dispFacilityId' size='2'  value="<%=facilityId%>" readOnly><input type="text" name='dispFacilityName' id='dispFacilityName' value="<%=facility_name%>" size='30' readOnly></td>	
	</tr>

	<tr>
	
	<td  class="label" width="40%">
	<fmt:message key="eBL.PackageApplicable.label" bundle="${bl_labels}"/> 
	</td>	
		
	<td  class='fields' width="60%"><input type="checkbox" name="pkgStatus" id="pkgStatus"  <%=pkgStatus.equals("Y")?"checked ":""%> value="<%=pkgStatus%>" readonly onClick="changeAllStatus(this);"></td>
	</tr>
	<tr>		   
	<td class="label" width="40%"> 
	<fmt:message key="eBL.PackageEffBackDated.label" bundle="${bl_labels}"/> 
	</td>	
	   
	<td class="fields" width="60%" ><input type='text' name='pkgBkDateD' id='pkgBkDateD' size='3' maxlength="3" <%=disableAll%>  value="<%=pkgBkDateD%>" onKeyPress="return allowValidNumber(this,event,3,0)">	<fmt:message key="Common.days.label" bundle="${common_labels}"/> 
	</td>
	</tr>
	
	<tr>
	<td class='label' width="40%">
	<fmt:message key="eBL.GLPostingBySmmry.label" bundle="${bl_labels}"/> 
	</td>	
	
	<td  class='fields' width="60%"><input type="checkbox" name="glSmryYN" id="glSmryYN"  <%=glSmryYN.equals("Y")?"checked ":""%> value="<%=glSmryYN%>" <%=disableAll%>  onClick="changeAccontingCode(this);">
	 </td>
	</tr>
		
	<tr>
	<td class='label'  width="40%">
	<fmt:message key="eBL.ValidDysPkgSerOrds.label" bundle="${bl_labels}"/> 
	</td>	

	<td class="fields" width="60%" >
	<input type='text' name='valdDForOrd' id='valdDForOrd' size='2' maxlength="2" <%=disableAll%>  value="<%=valdDForOrd%>" onKeyPress="return allowValidNumber(this,event,3,0)">	<fmt:message key="Common.days.label" bundle="${common_labels}"/> 
	</td>
	</tr>
		
	<tr>
	<td class='label'  width="40%"> 
	<fmt:message key="eBL.VarianceSrvCode.label" bundle="${bl_labels}"/> 
	</td>	

	<td class='fields' width="60%">
	<input type='text' name='unAvaldSrvCode' id='unAvaldSrvCode' size='10' maxlength="10" <%=disableAll%>  value="<%=unAvaldSrvCode%>" onBlur=""/><!-- <input type='text' name='unAvaldSrvDesc' id='unAvaldSrvDesc' size='15' maxlength="15" <%=disableAll%>  value="<%=unAvaldSrvDesc%>" onBlur=""/><input type='button' class='button' name='unAvaldSrvLookUp' id='unAvaldSrvLookUp' value='?' onClick="unAvaldSrv()" tabindex='0'/> -->
	</td>
	</tr>

	<tr>
	<td  class="label" width="40%">
	<fmt:message key="eBL.AutoRefundApplicable.label" bundle="${bl_labels}"/> 
	</td>	
		
	<td  class='fields' width="60%"><input type="checkbox" name="autoRefundYN" id="autoRefundYN"  <%=autoRefundYN.equals("Y")?"checked ":""%> value="<%=autoRefundYN%>"  <%=disableAll%>   onClick="chaneckAutoRefund(this);"></td>
	</tr>
		
	<tr>		   
	<td class="label" width="40%"> 
	<fmt:message key="eBL.ValidDysForPkgRefund.label" bundle="${bl_labels}"/> 
	</td>	
	   
	<td class="fields" width="60%" >
	<input type='text' name='valdRefundD' id='valdRefundD' size='2' maxlength="2"  <%=disableAll%>  value="<%=valdRefundD%>" onKeyPress="return allowValidNumber(this,event,3,0)">	<fmt:message key="Common.days.label" bundle="${common_labels}"/> 
	</td>
	</tr>

	<tr>
	<td class="label" width="40%">&nbsp; </td>
	<td class="label" width="60%"> 
	<fmt:message key="eBL.fromDateOfBlGen.label" bundle="${bl_labels}"/> 
	</td>
	</tr>
	
	<tr>		   
	<td class="label" width="40%"> 
	<fmt:message key="eBL.PatientDepositForPackage.label" bundle="${bl_labels}"/> 
	</td>	
	   
	<td class="fields" width="60%" >
	<input type='text' name='pat_dep_for_pkg_code' id='pat_dep_for_pkg_code' value='<%=pat_dep_for_pkg_code%>' size='2' MAXLENGTH ='2' onBlur="patDepForPkgCodeLookUp(pat_dep_for_pkg_desc,this)"><input type='text' name = 'pat_dep_for_pkg_desc' size='10' onBlur="patDepForPkgDescLookUp(this,pat_dep_for_pkg_code)" value="<%=pat_dep_for_pkg_desc%>"><input type='button' name='pat_dep_for_pkg_button' id='pat_dep_for_pkg_button' class='button' value='?' onclick="patDepForPkgLookUp(pat_dep_for_pkg_desc,pat_dep_for_pkg_code)">
	<INPUT type='hidden' name='pat_dep_for_pkg_code_temp' id='pat_dep_for_pkg_code_temp' value=''><INPUT type='hidden' name='pat_dep_for_pkg_desc_temp' id='pat_dep_for_pkg_desc_temp' value=''>
	</td>
	</tr>	
	
	<!--Added by Nandhini for NMC-JD-CRF-0150.1 V220419-->
	<tr>
	<td  class="label" width="40%">
	Enable Across Encounter Flag only for Order Associated Packages
	</td>
	<td  class='fields' width="60%">
	<input type="checkbox" name="pkgAcrossEnctrYN" id="pkgAcrossEnctrYN" <%=pkgAcrossEnctrYN.equals("Y")?"checked ":""%> value="<%=pkgAcrossEnctrYN%>" disabled /> </td>
	</tr>
	<!--Added for NMC-JD-CRF-0084 STRATS palani narayanan V210128-->
	<% if(blPkgDepositSubscription) { %>
		<tr>
			<td  class="label" width="40%">
			<fmt:message key="eBL.PkgDepositSubscription.Label" bundle="${bl_labels}"/> 
			</td>		
			<td  class='fields' width="60%"><input type="checkbox" name="pkgDepositYN" id="pkgDepositYN"  <%=pkgDepositYN.equals("Y")?"checked ":""%> value="<%=pkgDepositYN%>"  <%=disableAll%>   onClick="chkPkgDepositYN(this);"></td>
		</tr>
	<% } %>
	<!--Added for NMC-JD-CRF-0084 ends palani narayanan -->
	<!-- Added V190617-Aravindh/MMS-DM-CRF-0129.1/Starts -->
	<% if(dailyLimitSiteSpec) { %>
		<tr>
			<td class="label" width="40%"><fmt:message key="eBL.PkgServiceLimitBy.label" bundle="${bl_labels}"/></td>
			<td class="fields" width="60%">
			<select name="pkgServiceLimitBy" id="pkgServiceLimitBy" id="pkgServiceLimitBy" <%="Y".equals(dailyPkgLimitYN)?"":" disabled " %>>
				<option value="*" <%="*".equals(pkgServiceLimitBy)?" selected ":"" %>>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
				<option value="A" <%="A".equals(pkgServiceLimitBy)?" selected ":"" %>><fmt:message key="eBL.Amount.label" bundle="${bl_labels}"/></option>
				<option value="Q" <%="Q".equals(pkgServiceLimitBy)?" selected ":"" %>><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></option>				
				<option value="B" <%="B".equals(pkgServiceLimitBy)?" selected ":"" %>><fmt:message key="eBL.BOTH.label" bundle="${bl_labels}"/></option>				
			</select>
			<input type="hidden" name="prevPkgServiceLimitBy" id="prevPkgServiceLimitBy" id="prevPkgServiceLimitBy" value="<%=pkgServiceLimitBy%>" />
			</td>
		</tr>
		
		<tr>
			<td class="label" width="40%"><fmt:message key="eBL.DailyPkgLimit.label" bundle="${bl_labels}"/></td>
			<td class="fields" width="60%">
			<input type="checkbox" name="dailyPkgLimitChk" id="dailyPkgLimitChk" id="dailyPkgLimitChk" onclick="enableDailPkgLimitFn(this)" <%="Y".equals(dailyPkgLimitYN)?" checked ":"" %> />
			<select name="dailyPkgLimitSlct" id="dailyPkgLimitSlct" id="dailyPkgLimitSlct"  <%="Y".equals(dailyPkgLimitYN)?"":" disabled " %>>
				<option value="*">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
				<option value="G" <%="G".equals(dailyPkgLimitBy)?" selected ":"" %>><fmt:message key="Common.Group.label" bundle="${common_labels}"/></option>
				<option value="I" <%="I".equals(dailyPkgLimitBy)?" selected ":"" %>><fmt:message key="eBL.PIPDLimit.label" bundle="${bl_labels}"/></option>				
				<option value="B" <%="B".equals(dailyPkgLimitBy)?" selected ":"" %>><fmt:message key="eBL.BOTH.label" bundle="${bl_labels}"/></option>				
			</select>
			<input type="hidden" name="prevDailyPkgLimitChk" id="prevDailyPkgLimitChk" id="prevDailyPkgLimitChk" value="<%=dailyPkgLimitYN%>" />
			<input type="hidden" name="prevDailyPkgLimitSlct" id="prevDailyPkgLimitSlct" id="prevDailyPkgLimitSlct" value="<%=dailyPkgLimitBy%>" />
			</td>
		</tr>
	<% } %>
	<!-- Added V190617-Aravindh/MMS-DM-CRF-0129.1/Ends -->

	<!-- Added against V200613-MuthuN/MMS-QH-CRF-0128.1-US001 & US004 Starts -->
	<% if(blAutoPkgDiscSiteSpec){ %>
		<tr>
			<td  class="label" width="40%">
			<fmt:message key="eBL.ApplyCustPkgDiscNew.label" bundle="${bl_labels}"/> 
			</td>		
			<td  class='fields' width="60%">
			<input type="checkbox" name="pkgCustDiscNewPkgYN" id="pkgCustDiscNewPkgYN"  <%=pkgCustDiscNewPkgYN.equals("Y")?"checked ":""%> value="<%=pkgCustDiscNewPkgYN%>" readonly onClick="changeAllStatus_New(this);"></td>
		</tr>

		<tr>
			<td  class="label" width="40%">
			<fmt:message key="eBL.ApplyCustDistPolicy.label" bundle="${bl_labels}"/> 
			</td>		
			<td  class='fields' width="60%"><input type="checkbox" name="pkgCustDiscByPlcyYN" id="pkgCustDiscByPlcyYN"  <%=pkgCustDiscByPlcyYN.equals("Y")?"checked ":""%> value="<%=pkgCustDiscByPlcyYN%>" readonly onClick="changeAllStatus_New1(this);"></td>
		</tr>
	<% } %>
	<!-- Added against V200613-MuthuN/MMS-QH-CRF-0128.1-US001 & US004 Ends -->
	
	<!--28.08.2020 change  start-->
	
	<!-- MMS-QH-CRF-0170-US-5  PALANINARAYANAN 1/7/2020 STARTS--> 
	<% if(packageLimitSiteSpec) {		
		if("*".equals(PkgLimitIndBy))
		{
	%>
	
		<tr>
		<td class="label" width="40%"><fmt:message key="eBL.PkgLmtInd.label" bundle="${bl_labels}"/></td>
		<td class="fields" width="60%" >
				<select name="PkgLimitIndSlct" id="PkgLimitIndSlct" id="PkgLimitIndSlct"  width="10" onchange="pkgLimitChange()" readonly>
				<option value="*" <%="*".equals(PkgLimitIndBy)?" selected ":"" %> ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
				<option value="G" <%="G".equals(PkgLimitIndBy)?" selected ":"" %>><fmt:message key="Common.Group.label" bundle="${common_labels}"/></option>
				<option value="S" <%="S".equals(PkgLimitIndBy)?" selected ":"" %>><fmt:message key="Common.service.label" bundle="${common_labels}"/></option>				
				<option value="B" <%="B".equals(PkgLimitIndBy)?" selected ":"" %>><fmt:message key="eBL.BOTH.label" bundle="${bl_labels}"/></option>				
			
			</select>			
			<input type="hidden" name="prevPkgLimitIndSlct" id="prevPkgLimitIndSlct" id="prevPkgLimitIndSlct" value="<%=PkgLimitIndBy%>" />
		</td>
		</tr>
		<% }else {%>
		<tr>
		<td class="label" width="40%"><fmt:message key="eBL.PkgLmtInd.label" bundle="${bl_labels}"/></td>
		<td class="fields" width="60%" >
				<select name="PkgLimitIndSlct" id="PkgLimitIndSlct" id="PkgLimitIndSlct"  width="10" onchange="pkgLimitChange()" disabled >
				<option value="*" <%="*".equals(PkgLimitIndBy)?" selected ":"" %> ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
				<option value="G" <%="G".equals(PkgLimitIndBy)?" selected ":"" %>><fmt:message key="Common.Group.label" bundle="${common_labels}"/></option>
				<option value="S" <%="S".equals(PkgLimitIndBy)?" selected ":"" %>><fmt:message key="Common.service.label" bundle="${common_labels}"/></option>				
				<option value="B" <%="B".equals(PkgLimitIndBy)?" selected ":"" %>><fmt:message key="eBL.BOTH.label" bundle="${bl_labels}"/></option>				
			</select>			
			<input type="hidden" name="prevPkgLimitIndSlct" id="prevPkgLimitIndSlct" id="prevPkgLimitIndSlct" value="<%=PkgLimitIndBy%>" />
		</td>
		</tr>
	<% }%>
	
	<input type="hidden" name="currPkgLimitIndSlct" id="currPkgLimitIndSlct" id="currPkgLimitIndSlct" value="<%=PkgLimitIndBy%>" />
	<%}%>
	<!-- MMS-QH-CRF-0170-US-5  PALANINARAYANAN 1/7/2020 ENDS--> 
	<!--28.08.2020 change  end-->

	<!-- Added against V201030 Starts -->
	<% if(enableCmnFunMESiteSpec){ %>
	<tr>
		<td  class="label" width="40%">
		<fmt:message key="eBL.AutoDistPkgVarServOP.label" bundle="${bl_labels}"/> 
		</td>		
		<td  class='fields' width="60%">
			<input type="checkbox" name="autoDistPkgVarServiceOPYN" id="autoDistPkgVarServiceOPYN"  <%=autoDistPkgVarServiceOPYN.equals("Y")?"checked ":""%> value="<%=autoDistPkgVarServiceOPYN%>" onClick="AutoDistPkgServOP(this);">
			&nbsp;&nbsp;<fmt:message key="eBL.Service.label" bundle="${bl_labels}"/>

			&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="autoDistPkgVarPharMedItemsOPYN" id="autoDistPkgVarPharMedItemsOPYN"  <%=autoDistPkgVarPharMedItemsOPYN.equals("Y")?"checked ":""%> value="<%=autoDistPkgVarPharMedItemsOPYN%>" onClick="AutoDistPkgServOP(this);">
			&nbsp;&nbsp;<fmt:message key="eBL.PharmacyMedical.label" bundle="${bl_labels}"/>
		</td>
	</tr>

	<tr>
		<td  class="label" width="40%">
		<fmt:message key="eBL.AutoDistPkgVarServIP.label" bundle="${bl_labels}"/> 
		</td>		
		<td  class='fields' width="60%">
			<input type="checkbox" name="autoDistPkgVarServiceIPYN" id="autoDistPkgVarServiceIPYN"  <%=autoDistPkgVarServiceIPYN.equals("Y")?"checked ":""%> value="<%=autoDistPkgVarServiceIPYN%>" onClick="AutoDistPkgServIP(this);">
			&nbsp;&nbsp;<fmt:message key="eBL.Service.label" bundle="${bl_labels}"/>

			&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="autoDistPkgVarPharMedItemsIPYN" id="autoDistPkgVarPharMedItemsIPYN"  <%=autoDistPkgVarPharMedItemsIPYN.equals("Y")?"checked ":""%> value="<%=autoDistPkgVarPharMedItemsIPYN%>" onClick="AutoDistPkgServIP(this);">
			&nbsp;&nbsp;<fmt:message key="eBL.PharmacyMedical.label" bundle="${bl_labels}"/>
		</td>
	</tr>
	<% } %>
	<!-- Added against V201030 Ends -->

</table>
	<input type='hidden' name='prevPkgBkDateD' id='prevPkgBkDateD' value="<%=pkgBkDateD%>" >
	<input type='hidden' name='prevGlSmryYN' id='prevGlSmryYN' value="<%=glSmryYN%>" >
	<input type='hidden' name='prevGlSmryDesc' id='prevGlSmryDesc' value="<%=glSmryDesc%>" >
	<input type='hidden' name='prevValdDForOrd' id='prevValdDForOrd' value="<%=valdDForOrd%>" >
	<input type='hidden' name='prevUnAvaldSrvCode' id='prevUnAvaldSrvCode' value="<%=unAvaldSrvCode%>" >
	<input type='hidden' name='prevUnAvaldSrvDesc' id='prevUnAvaldSrvDesc' value="" >
	<input type='hidden' name='prevAutoRefundYN' id='prevAutoRefundYN' value="<%=autoRefundYN%>" >
	<input type='hidden' name='prevValdRefundD' id='prevValdRefundD' value="<%=valdRefundD%>" >
	<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
	<input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>" >
	<input type="hidden" name="pkgStatusFromTab" id="pkgStatusFromTab"  value="<%=pkgStatus%>" />
	<input type="hidden" name="prevUnAvaldSrvCode" id="prevUnAvaldSrvCode"  value="<%=unAvaldSrvCode%>" />
	<input type="hidden" name="prevPat_dep_for_pkg_code" id="prevPat_dep_for_pkg_code"  value="<%=pat_dep_for_pkg_code%>" />
	<input type="hidden" name="prevPat_dep_for_pkg_desc" id="prevPat_dep_for_pkg_desc"  value="<%=pat_dep_for_pkg_desc%>" />
	<!-- <input type="hidden" name="dailyLimitSiteSpec" id="dailyLimitSiteSpec" value="<%=dailyLimitSiteSpec%>" />-->

	<!-- Added against V200612-MuthuN/MMS-QH-CRF-0128.1-US001 & US004 Start -->
	<input type='hidden' name='prevpkgCustDiscNewPkgYN' id='prevpkgCustDiscNewPkgYN' value="<%=pkgCustDiscNewPkgYN%>" >
	<input type='hidden' name='prevpkgCustDiscByPlcyYN' id='prevpkgCustDiscByPlcyYN' value="<%=pkgCustDiscByPlcyYN%>" >
	<!-- Added against V200612-MuthuN/MMS-QH-CRF-0128.1-US001 & US004 End -->

	<!-- V201030 Start -->
	<input type='hidden' name='prevautoDistPkgVarServiceOPYN' id='prevautoDistPkgVarServiceOPYN' value="<%=autoDistPkgVarServiceOPYN%>" >
	<input type='hidden' name='prevautoDistPkgVarPharMedItemsOPYN' id='prevautoDistPkgVarPharMedItemsOPYN' value="<%=autoDistPkgVarPharMedItemsOPYN%>" >
	<input type='hidden' name='prevautoDistPkgVarServiceIPYN' id='prevautoDistPkgVarServiceIPYN' value="<%=autoDistPkgVarServiceIPYN%>" >
	<input type='hidden' name='prevautoDistPkgVarPharMedItemsIPYN' id='prevautoDistPkgVarPharMedItemsIPYN' value="<%=autoDistPkgVarPharMedItemsIPYN%>" >
	<!-- V201030 End -->
	<!-- Added for NMC-JD-CRF-0084 Starts palani narayanan V210128      -->
    <input type='hidden' name='prevpkgDepositYN' id='prevpkgDepositYN' value="<%=pkgDepositYN%>" >
	<!-- Added by Nandhini against NMC-JD-CRF-0150.1 V220419-->
	<input type='hidden' name='AcrossEnctrYN' id='AcrossEnctrYN' value="<%=pkgAcrossEnctrYN%>" >	
</form>
</body>
</html>
<%
	}
	catch(Exception e)
	{
		System.out.println("Exception from Package Parameter Dtls :"+e);
		e.printStackTrace();
	}
	finally
	{
		if(rs !=null) rs.close();
		if(pstmt !=null) pstmt.close();
		if(con!=null) ConnectionManager.returnConnection(con);
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
%>

