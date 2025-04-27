
<%-- Added by Rajesh V for MMS-CRF-0125
	This page contains the Search criteria--%>
<%@page import="eBL.pkgpricerevision.bc.PkgPriceDisountBC"%>
<%@ page   import="java.sql.*, webbeans.eCommon.* , java.io.*,java.util.*,com.ehis.util.*,java.text.*"  %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bulk Update Search</title>
<%

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE");
	String facilityId = (String)session.getAttribute("facility_id");
	PkgPriceDisountBC priceDiscBC =  new PkgPriceDisountBC();
	String backDate = priceDiscBC.getPkgBackDate(facilityId);	
	int noOfDecimal = priceDiscBC.getNoOfDecimal();	
	String login_user = (String)session.getAttribute("login_user");
	//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 17/6/2020 
	String  PkgByPolicy="";
	String	newPkg="";
	boolean siteAutoApplyPkgDiscYN = false;
	//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 17/6/2020 
%>
<% 
	Connection con = null;	
	//HttpSession httpSession = request.getSession(false);
	try
	{
		con = ConnectionManager.getConnection();	
		siteAutoApplyPkgDiscYN = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_AUTO_APPLY_PKG_DISC_YN");
		//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 17/6/2020 STARTS-->
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;		
		String sqlStr="";
		sqlStr="select  pkg_cust_disc_by_policy, pkg_cust_disc_new_pkg  from bl_parameters where OPERATING_FACILITY_ID='"+facilityId+"'" ;
		pstmt=con.prepareStatement(sqlStr);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			PkgByPolicy=rs.getString("pkg_cust_disc_by_policy");
			newPkg=rs.getString("pkg_cust_disc_new_pkg");	
		}
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	finally
	{
		if(con!=null) con.close();
		//if(con!=null) ConnectionManager.returnConnection(con);
	}
		//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 17/6/2020 ENDS-->
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eBL/js/PkgBulkUpdate.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	$(document).ready(function(){		
		$("input[type='text']").keydown(function(e){
			if (e.which === 8 && !$(e.target).is("input[type='text']:not([readonly])")) {
				e.preventDefault();
		    }
		});
		
		$('#priceType').change(function(){
			var priceType = $(this).val();
			if(priceType == 'C'){
				$('#tdCustgrpLbl').show();			
				$('#tdCustgrpData').show();
				$('#tdCustLbl').show();			
				$('#tdCustData').show();
				$('#tdSearchBtn').attr('colspan','1');
			}
			else if(priceType == 'S'){
				$('#tdCustgrpLbl').hide();			
				$('#tdCustgrpData').hide();
				$('#tdCustLbl').hide();			
				$('#tdCustData').hide();
				$('#tdSearchBtn').attr('colspan','5');
			}			
			//loadFrames();
		});
		
		$('#updateType').change(function(){
			if($(this).val() == 'B'){
				$('#pkgCode').val('**');
				$('#pkgDesc').val('All Package');
				$('#pkgCode').prop('readonly',true);
				$('#pkgDesc').prop('readonly',true);
				$('#pkgBtn').prop('disabled',true);
			}
			else if($(this).val() == 'P'){
				if($('#pkgCode').val() == '**'){
					$('#pkgCode').val('');
					$('#pkgDesc').val('');
				}
				$('#pkgCode').prop('readonly',false);
				$('#pkgDesc').prop('readonly',false);
				$('#pkgBtn').prop('disabled',false);
			}
			else{
				$('#pkgCode').val('');
				$('#pkgDesc').val('');
				$('#pkgCode').prop('readonly',false);
				$('#pkgDesc').prop('readonly',false);
				$('#pkgBtn').prop('disabled',false);
			}
		});
		
		$('#resetBtn').click(function(){
			$('input:text').val('');
			$('select').val('');
			$('#updateType').change();
		});		
		$('#searchBtn').click(function(){
			if($('#priceType').val() == ''){
				alert('Please choose standard price / customer price');
				return false;
			}
			if($('#updateType').val() == ''){
				alert('Please choose Package price / Bulk update');
				return false;
			}
			if($('#pkgCode').val() == ''){
				alert('Package Code is Mandatory');
				return false;
			}
			loadFrames();
		});		
		$('td').each(function(){
			$(this).css('padding-bottom','5px');
		});		
	});
	</script>
</head>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 	onSelect="codeArrestThruSelect();">
	<form name='searchFrm' id='searchFrm' id='searchFrm' >
	<table  width="100%" align="center" cellpadding=3 cellspacing=0>
	<tr>
		<td  class='COLUMNHEADER' nowrap >Package Price Bulk Update / Price Revision</td>
	</tr>
	</table>
	<table id='searchTbl' name='searchTbl'  width="90%" align="center" cellpadding=3 cellspacing=0>
			
		<tr rowValue='1' style="padding-bottom: 10px;">
			<td width="20%" nowrap class='label'  style="text-align: left; padding-top: 10px;" >
				<fmt:message key="eBL.StdCustPrice.label" bundle="${bl_labels }"></fmt:message>
			</td>
			<td width="20%" nowrap class='fields' style="padding-top: 10px;">
				<select name='priceType' id='priceType' >
				<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels }"></fmt:message></option>
				<option value="C"><fmt:message key="eBL.CustomerPrice.label" bundle="${bl_labels }"></fmt:message></option>
				<option value="S"><fmt:message key="eBL.StandardPrice.label" bundle="${bl_labels }"></fmt:message></option>
			</select>
			<img src='../../eCommon/images/mandatory.gif'>	
			</td>
			<td style="padding-top: 10px;" width="10%" nowrap>
			</td>
			<td width="20%" nowrap class='label' style="text-align: left;padding-top: 10px;">
				<fmt:message key="eBL.BulkUpdPkgPrice.label" bundle="${bl_labels }"></fmt:message>
			</td>
			<td width="20%" nowrap class='fields' style="padding-top: 10px;">
				<select name='updateType' id='updateType' >
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels }"></fmt:message></option>
					<option value="P"><fmt:message key="eBL.IndPkg.label" bundle="${bl_labels }"></fmt:message></option>
					<option value="B"><fmt:message key="eBL.BulkUpdate.label" bundle="${bl_labels }"></fmt:message></option>
				</select>
				<img src='../../eCommon/images/mandatory.gif'>	
			</td>
		</tr>
		<tr>
			<td width="20%" nowrap class='label' style="text-align: left;">
				<fmt:message key="eBL.PackageCode.Label" bundle="${bl_labels }"></fmt:message>
			</td>
			<td width="20%" nowrap class='fields' style="text-align: right;">
				<input type='text' name='pkgCode' id='pkgCode'  size="10" onblur="if(this.value!=''){ callCommonLookupCode(pkgDesc,pkgCode,4,1); } else{ fnClearCode(pkgDesc); }">&nbsp;
				<input type='text' name='pkgDesc' id='pkgDesc'  size="30" onblur="if(this.value!=''){ callCommonLookupCode(pkgDesc,pkgCode,4,2); } else{ fnClearCode(pkgCode); }">&nbsp;
				<input type='button' class='button' name="pkgBtn" id="pkgBtn"  value='?' onClick="callCommonLookupCode(pkgDesc,pkgCode,4,2)" tabindex='2'>
				<img src='../../eCommon/images/mandatory.gif'>					
			</td>
			<td style="padding-top: 10px;" width="10%" nowrap>
			</td>
			<td width="20%" nowrap class='label' style="text-align: left;">
				<fmt:message key="eBL.BillingClass.label" bundle="${bl_labels }"></fmt:message>
			</td>
			<td width="20%" nowrap class='fields' style="text-align: right;">
				<input type='text' name='blngClassCode' id='blngClassCode'  size="10" value="ALL" onblur="if(this.value!=''){ callCommonLookupCode(blngClassDesc,blngClassCode,6,1); } else{ fnClearCode(blngClassDesc); }">&nbsp;
				<input type='text' name='blngClassDesc' id='blngClassDesc'  size="30" value="All Billing Class - ALL" onblur="if(this.value!=''){ callCommonLookupCode(blngClassDesc,blngClassCode,6,2); } else{ fnClearCode(blngClassCode); }">&nbsp;
				<input type='button' class='button' name="blngClassBtn" id="blngClassBtn" value='?' onClick="callCommonLookupCode(blngClassDesc,blngClassCode,6,2)" tabindex='2'>				
			</td>				
		</tr >
		<tr>
			<td width="20%" nowrap class='label' style="text-align: left;" id='tdCustgrpLbl'>
				<fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels }"></fmt:message>
			</td>
			<td width="20%" nowrap class='fields' style="text-align: left;" id='tdCustgrpData'>
				<input type='text' name='custGrpCode' id='custGrpCode'  size="10" value="**" onblur="if(this.value!=''){ callCommonLookupCode(custGrpDesc,custGrpCode,2,1); } else{ fnClearCode(custGrpDesc); }">&nbsp;
				<input type='text' name='custGrpDesc' id='custGrpDesc'  size="30" value="All Payer Group" onblur="if(this.value!=''){ callCommonLookupCode(custGrpDesc,custGrpCode,2,2); } else{ fnClearCode(custGrpCode); }">&nbsp;
				<input type='button' class='button' name="custGrpBtn" id="custGrpBtn"  value='?' onClick="callCommonLookupCode(custGrpDesc,custGrpCode,2,2);" tabindex='2'>
			</td>
			<td style="padding-top: 10px;" width="10%" nowrap >
			</td>
			<td width="20%" nowrap class='label' style="text-align: left;" id='tdCustLbl'> 
				<fmt:message key="eBL.Customer.label" bundle="${bl_labels }"></fmt:message>
			</td>
			<td width="20%" nowrap class='fields' style="text-align: right;" id='tdCustData'>
				<input type='text' name='custCode' id='custCode'  size="10" value="**" onblur="if(this.value!=''){ callCommonLookupCode(custDesc,custCode,3,1,custGrpCode); } else{ fnClearCode(custDesc); }">&nbsp;
				<input type='text' name='custDesc' id='custDesc'  size="30" value="All Payer" onblur="if(this.value!=''){ callCommonLookupCode(custDesc,custCode,3,2,custGrpCode); } else{ fnClearCode(custCode); }">&nbsp;
				<input type='button' class='button' name="custBtn" id="custBtn" value='?' onClick="callCommonLookupCode(custDesc,custCode,3,2,custGrpCode)" tabindex='2'>					
			</td>				
		</tr>
		<tr>
			<td width="20%" nowrap class='label' style="text-align: left;">
				<fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels }"></fmt:message>
			</td>
			<td width="20%" nowrap class='fields' colspan='3'>
				<input type='text' name='blngGrpCode' id='blngGrpCode'  size="10" value="ALL"  onblur="if(this.value!=''){ callCommonLookupCode(blngGrpDesc,blngGrpCode,7,1); } else{ fnClearCode(blngGrpDesc); }">&nbsp;
				<input type='text' name='blngGrpDesc' id='blngGrpDesc'  size="30" value="All Billing Group - ALL"  onblur="if(this.value!=''){ callCommonLookupCode(blngGrpDesc,blngGrpCode,7,2); } else{ fnClearCode(blngGrpCode); }">&nbsp;
				<input type='button' class='button' name="blngGrpBtn" id="blngGrpBtn" value='?' onClick="callCommonLookupCode(blngGrpDesc,blngGrpCode,7,2);" tabindex='2'>					
			</td>
			<td style="padding-top: 10px;" width="10%" nowrap>
			</td>
			<!-- MMS-QH-CRF- 128.1 STARTS -->
		<% if(siteAutoApplyPkgDiscYN){				
			if("Y".equals(PkgByPolicy)){%>
			<td width="20%" nowrap class='label' style="text-align: left;" id='tdPlyLbl'> 
				<fmt:message key="eBL.POLICY_TYPE.label" bundle="${bl_labels }"></fmt:message>
			</td>
	
			<td width="20%" nowrap class='fields'>										
				<input type='text' name='policyCode' id='policyCode'  size='10'  value='**'  onblur="if(this.value!=''){ callCommonLookupCode(policyDesc,policyCode,8,1); } else{ fnClearCode(policyDesc); }"/>&nbsp;
						<input type='text' name='policyDesc' id='policyDesc'  size='30' value='All Policies' onblur="if(this.value!=''){ callCommonLookupCode(policyDesc,policyCode,8,2); } else{ fnClearCode(policyCode); }">&nbsp;
				<input type='button' class='button' name="policyType_btn" id="policyType_btn" value='?' onClick="callCommonLookupCode(policyDesc,policyCode,8,2)" tabindex='2'>
			</td>
			<%} 
			else if("N".equals(PkgByPolicy)){%>
				<td width="20%" nowrap class='label' style="text-align: left;" id='tdPlyLbl'> 
				<fmt:message key="eBL.POLICY_TYPE.label" bundle="${bl_labels }"></fmt:message>
			</td>
	
			<td width="20%" nowrap class='fields'>										
				<input type='text' name='policyCode' id='policyCode'  size='10'  value='**'  disabled='disabled' onblur="if(this.value!=''){ callCommonLookupCode(policyDesc,policyCode,8,1); } else{ fnClearCode(policyDesc); }"/>&nbsp;
						<input type='text' name='policyDesc' id='policyDesc'  size='30' value='All Policies' disabled='disabled' onblur="if(this.value!=''){ callCommonLookupCode(policyDesc,policyCode,8,2); } else{ fnClearCode(policyCode); }">&nbsp;
				<input type='button' class='button' name="policyType_btn" id="policyType_btn" value='?' onClick="callCommonLookupCode(policyDesc,policyCode,8,2)" tabindex='2'>
			</td>
			<%} }%>
			
			
		<!-- MMS-QH-CRF- 128.1 ENDS -->
		</tr>
		<tr>
			<td width="20%" nowrap class='label' style="text-align: left;">
			</td>
			<td width="20%" nowrap class='label' style="text-align: left;">
			</td>
			<td style="padding-top: 10px;" width="10%" nowrap>
			</td>
			<td  style="text-align: left; width: 20%" id='tdSearchBtn' colspan='2'>
				<input type='button' calss='button' name="searchBtn" id="searchBtn"  value='search'>
				&nbsp;&nbsp;&nbsp;
				<input type='button' calss='button' name="resetBtn" id="resetBtn"  value='Reset'>
			</td>
		</tr>			
	</table>
	<input type='hidden' name='locale' id='locale'  value='<%=locale %>' />
	<input type='hidden' name='facilityId' id='facilityId'  value='<%=facilityId %>' />
	<input type='hidden' name='login_user' id='login_user'  value='<%=login_user %>' />
	<input type='hidden' name='backDays' id='backDays'  value='<%=backDate %>' />
	<input type='hidden' name='srchPkgCode' id='srchPkgCode'  value=''>
	<input type='hidden' name='srchPkgDesc' id='srchPkgDesc'  value=''>
	<input type='hidden' name='srchType' id='srchType'  value=''>
	<input type='hidden' name='pkgEffFrom' id='pkgEffFrom'  value=''>
	<input type='hidden' name='pkgEffTo' id='pkgEffTo'  value=''>
	<input type='hidden' name='pkgOpYn' id='pkgOpYn'  value=''>
	<input type='hidden' name='pkgEmYn' id='pkgEmYn'  value=''>
	<input type='hidden' name='pkgIpYn' id='pkgIpYn' value=''>
	<input type='hidden' name='pkgDcYn' id='pkgDcYn'  value=''>
	<input type='hidden' name='noOfDecimal' id='noOfDecimal'  value='<%=noOfDecimal %>' >
	</form>
</body>
</html>

