<!DOCTYPE html>
<%-- Added by Rajesh V for MMS-CRF-0125
	This page contains the Search criteria--%>
<%@page import="eBL.pkgpricerevision.bc.PkgPriceDisountBC"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE");
	String facilityId = (String)session.getAttribute("facility_id");
	PkgPriceDisountBC priceDiscBC =  new PkgPriceDisountBC();
	String backDate = priceDiscBC.getPkgBackDate(facilityId);	
	int noOfDecimal = priceDiscBC.getNoOfDecimal();	
	String login_user = (String)session.getAttribute("login_user");
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eBL/js/PkgBulkUpdate.js'></script>
	<script language="javascript" src="../../eBL/js/BLPatientEncounters.js"></script>
	<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>	
		
	
	<script type="text/javascript">

	function showCalendar_loc(Val1, Val2)
	{	
		
		if (Val2.disabled == true)		
		{
			return false;
		}
		else
		{
			return showCalendar(Val1,null,null);
		}
	}
	
	function checkDateBL(entered_date)
	{
		
	var locale=document.forms[0].locale.value;
	if(entered_date.value!="")
	{
		if(validDate(entered_date.value,'DMY',locale))
		{
			return true;
		}
		else
		{	
			alert(getMessage("INVALID_DATE_FMT","SM"));
			entered_date.select();
			return false;
		}
	}
	else
	{
		return true;
	}
}
	
	function call_date_less_equal_chk(obj)
	{	
		if(!(obj.value==""))
		{
			var locale=document.forms[0].locale.value;
			var sysdate=getCurrentDate('DMY',locale);
			if(chkDtLessEqualThanSysDateNew(obj,sysdate))
			{		
				return true;
			}
			else
			{		
				return false;
			}
		}
		else
		{	
			return false;
		}
	}	

	function toFromDateChk(obj)
	{
		if(!(obj.value==""))
		{		
			var effFromDt = document.forms[0].encounter_from_date.value;
			var effToDt = document.forms[0].encounter_to_date.value;
			if(checkDateBL(obj))
			{
				var locale=document.forms[0].locale.value;			
				if((!isBefore(effFromDt,effToDt,'DMY',locale)))
				{		
					alert(getMessage("BL4115",'BL'));
					obj.select();
				}
				else
				{			
					return false;
				}
			}
		}
		else
		{
			return false;
		}
	}
	</script>
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
	/*		if($('#pkgCode').val() == ''){
				alert('Package Code is Mandatory');
				return false;
			}
*/
		

		});
		
		$('td').each(function(){
			$(this).css('padding-bottom','5px');
		});
		
		
	});
	
	function funQry()
	{		
		var mainfrmObj="";
		mainfrmObj=parent.frames[0].searchFrm;
		var Package= getLabel("Common.Package.label", "common");
		var BillingGroup = getLabel("eBL.BillingGroup.label", "bl");
		var Customer = getLabel("eBL.Customer.label", "bl");
		var POLICY = getLabel("eBL.POLICY.label", "bl");
		var EffectiveFrom = getLabel("eBL.EffectiveFrom.Label", "bl");
		var fieldsTop = new Array(mainfrmObj.blngGrpCode,mainfrmObj.custCode,mainfrmObj.ppGrpCode,mainfrmObj.pkgCode,mainfrmObj.encounter_from_date);
		var namesTop = new Array(BillingGroup,Customer,POLICY,Package,EffectiveFrom);
		var msgFrame;
		var msgFrame = parent.frames[2];
		var  result=checkFieldsofMst(fieldsTop, namesTop, msgFrame)
          if(result)
        	{ 
		//added against the ICN no:73412 mms-qh-128.1
       		parent.frames[2].location.href='../../eCommon/html/blank.html';
		var custGrpCode=document.getElementById("custGrpCode").value;
		var blng_class_code=document.getElementById("blngGrpCode").value;  //28.8.2020 CHANGED
		var custCode=document.getElementById("custCode").value; //28.8.2020 CHANGED
		//var pkgDesc=document.getElementById("pkgDesc").value;
		var pkgCode=document.getElementById("pkgCode").value; //28.8.2020 CHANGED
		var ppGrpCode=document.getElementById("ppGrpcode").value; //28.8.2020 CHANGED
		var eff_from_date=document.getElementById("encounter_from_date").value; //28.8.2020 CHANGED
		var eff_to_date=document.getElementById("encounter_to_date").value; //28.8.2020 CHANGED
		//added against inc 77403 FOR MMS-QH-CRF-128.1
		
		//20.8.2020 CHANGED one parameter
		
		//28.8.2020 add  one parameter encounter_to_date
		parent.summarydetail1.location.href="../../eBL/jsp/BLAdvPackDiscSrcDtlsFrame.jsp?packageCode="+pkgCode+"&blng_class_code="+blng_class_code+"&custCode="+custCode+"&ppGrpCode="+ppGrpCode+"&eff_from_date="+eff_from_date+"&eff_to_date="+eff_to_date+"&custGrpCode="+custGrpCode;  
		//parent.frames[1].location.href="../../eBL/jsp/BLViewActPakDtl.jsp?sel_patient_id="+patient_id+"&sel_episode_type="+episode_type+"&sel_episode_id="+episode_id+"&sel_visit_id="+visit_id+"&sel_encounter_from_date="+encounter_from_date+"&sel_encounter_to_date="+encounter_to_date+"&sel_ward_clinic_code="+ward_clinic_code+"&"+params;
	}
	}

	
	</script>
	
	
	
</head>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 	onSelect="codeArrestThruSelect();">
	<form name='searchFrm' id='searchFrm' id='searchFrm' >
	<table  width="100%" align="center" cellpadding=3 cellspacing=0>
			<tr  >
				<td  class='COLUMNHEADER' nowrap ><CENTER><fmt:message key="eBL.Query_Criteria.label" bundle="${bl_labels }"></fmt:message></CENTER></td>
			</tr>
	</table>
		<table id='searchTbl' name='searchTbl' id='searchTbl' width="90%" align="center" cellpadding=3 cellspacing=0>
				<tr>
				
				<td style="padding-top: 10px;" width="10%" nowrap>
				</td>
				<td width="10%" nowrap class='label' style="text-align: left;" id='tdCustgrpLbl'>
					<fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels }"></fmt:message>
				</td>
				<!-- Changed for the ICN:73403 14/7/2020 -->
				<td width="10%" nowrap class='fields' style="text-align: left;" id='tdCustgrpData'>
					<input type='text' name='custGrpCode' id='custGrpCode' id='custGrpCode' size="10" value="" onblur="if(this.value!=''){ callCommonLookupCode(custGrpDesc,custGrpCode,9,1); } else{ fnClearCode(custGrpDesc); }">&nbsp;
					<input type='text' name='custGrpDesc' id='custGrpDesc' id='custGrpDesc' size="30" value="" onblur="if(this.value!=''){ callCommonLookupCode(custGrpDesc,custGrpCode,9,2); } else{ fnClearCode(custGrpCode); }">&nbsp;
					<input type='button' class='button' name="custGrpBtn" id="custGrpBtn" id='custGrpBtn' value='?' onClick="callCommonLookupCode(custGrpDesc,custGrpCode,9,2);" tabindex='2'>
				</td>
				<td style="padding-top: 10px;" width="10%" nowrap>
				</td>
				<td width="10%" nowrap class='label' style="text-align: left;">
					<fmt:message key="eBL.BillingClass.Label" bundle="${bl_labels }"></fmt:message>
				</td>
				<td width="10%" nowrap class='fields'>
					<input type='text' name='blngGrpCode' id='blngGrpCode' id='blngGrpCode' size="10" value=""  onblur="if(this.value!=''){ callCommonLookupCode(blngGrpDesc,blngGrpCode,6,1); } else{ fnClearCode(blngGrpDesc); }">&nbsp;
					<input type='text' name='blngGrpDesc' id='blngGrpDesc' id='blngGrpDesc' size="30" value=""  onblur="if(this.value!=''){ callCommonLookupCode(blngGrpDesc,blngGrpCode,6,2); } else{ fnClearCode(blngGrpCode); }">&nbsp;
					<input type='button' class='button' name="blngGrpBtn" id="blngGrpBtn" value='?' onClick="callCommonLookupCode(blngGrpDesc,blngGrpCode,6,2);" tabindex='2'>					
				<img src='../../eCommon/images/mandatory.gif'>	
				</td>
				</tr >
			<tr>
				
				<td style="padding-top: 10px;" width="10%" nowrap>
				</td>
				<td width="10%" nowrap class='label' style="text-align: left;" id='tdCustLbl'> 
					<fmt:message key="eBL.Customer.label" bundle="${bl_labels }"></fmt:message>
				</td>
				<td width="10%" nowrap class='fields' >
					<input type='text' name='custCode' id='custCode' id='custCode' size="10" value="" onblur="if(this.value!=''){ callCommonLookupCode(custDesc,custCode,3,1,custGrpCode); } else{ fnClearCode(custDesc); }">&nbsp;
					<input type='text' name='custDesc' id='custDesc' id='custDesc' size="30" value="" onblur="if(this.value!=''){ callCommonLookupCode(custDesc,custCode,3,2,custGrpCode); } else{ fnClearCode(custCode); }">&nbsp;
					<input type='button' class='button' name="custBtn" id="custBtn" id='custBtn' value='?' onClick="callCommonLookupCode(custDesc,custCode,3,2,custGrpCode)" tabindex='2'>					
				<img src='../../eCommon/images/mandatory.gif'>	
				</td>
				<td style="padding-top: 10px;" width="10%" nowrap>
				</td>
				<td width="10%" nowrap class='label' style="text-align: left;">
					<fmt:message key="Common.Package.label" bundle="${common_labels }"></fmt:message>
				</td>
				<td width="10%" nowrap class='fields' >
					<input type='text' name='pkgCode' id='pkgCode' id='pkgCode' size="10" onblur="if(this.value!=''){ callCommonLookupCode(pkgDesc,pkgCode,4,1); } else{ fnClearCode(pkgDesc); }">&nbsp;
					<input type='text' name='pkgDesc' id='pkgDesc' id='pkgDesc' size="30" onblur="if(this.value!=''){ callCommonLookupCode(pkgDesc,pkgCode,4,2); } else{ fnClearCode(pkgCode); }">&nbsp;
					<input type='button' class='button' name="pkgBtn" id="pkgBtn" id='pkgBtn' value='?' onClick="callCommonLookupCode(pkgDesc,pkgCode,4,2)" tabindex='2'>
					<img src='../../eCommon/images/mandatory.gif'>					
				</td>
				
				
			</tr>
			<tr>
				
				
				<td style="padding-top: 10px;" width="10%" nowrap>
				</td>
					
				<td width="10%" nowrap class='label' style="text-align: left;" id='tdCustLbl'> 
					<fmt:message key="eBL.POLICY.label" bundle="${bl_labels }"></fmt:message>
				</td>
					<td width="10%" nowrap class='fields'>
					<input type='text' name='ppGrpCode' id='ppGrpCode' id='ppGrpCode' size="10" value=""  onblur="if(this.value!=''){ callCommonLookupCode(ppGrpDesc,ppGrpCode,8,1); } else{ fnClearCode(ppGrpDesc); }">&nbsp;
					<input type='text' name='ppGrpDesc' id='ppGrpDesc' id='ppGrpDesc' size="30" value=""  onblur="if(this.value!=''){ callCommonLookupCode(ppGrpDesc,ppGrpCode,8,2); } else{ fnClearCode(ppGrpCode); }">&nbsp;
					<input type='button' class='button' name="ppGrpBtn" id="ppGrpBtn" value='?' onClick="callCommonLookupCode(ppGrpDesc,ppGrpCode,8,2);" tabindex='2'>					
				<img src='../../eCommon/images/mandatory.gif'>	
				</td>
				
					<td style="padding-top: 10px;" width="10%" nowrap>
				</td>	
			
				<td width='25%' class='label'> <fmt:message key="eBL.EffectiveFrom.Label" bundle="${bl_labels}"/> &nbsp;&nbsp;
				<input type='text' name='encounter_from_date' id='encounter_from_date' id='encounter_from_date' size='10' maxlength='30' value='' onBlur='return checkDateBL(document.forms[0].encounter_from_date)' ><img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar_loc('encounter_from_date',document.forms[0].encounter_from_date);" onBlur='return checkDateBL(document.forms[0].encounter_from_date)'>
				 <img src='../../eCommon/images/mandatory.gif'>	
				 </td>
				<td width="25%"  class='label'><fmt:message key="eBL.EffectiveTo.Label" bundle="${bl_labels}"/>&nbsp;&nbsp;
				<input type='text' name='encounter_to_date' id='encounter_to_date' id='encounter_to_date' size='10' maxlength='30'  value='' onBlur='return toFromDateChk(document.forms[0].encounter_to_date)'><img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar_loc('encounter_to_date',document.forms[0].encounter_to_date);" onBlur='return toFromDateChk(document.forms[0].encounter_to_date)'>
				</td>
			
	
				</tr>
				<tr>
				</tr>
				<tr>
				</tr>
				
			<tr>
			<td style="padding-top: 10px;" width="10%" nowrap>
				</td>
				<td style="padding-top: 10px;" width="10%" nowrap>
				</td>
			<td>
			</td>
			
				<td  style="text-align: right width="40%" nowrap>
				</td>
			<td  style="text-align: right; width: 40%" id='tdSearchBtn' colspan='2'>
					<input type='button' calss='button' name="searchBtn" id="searchBtn" id="searchBtn" value='Search' onclick="funQry();">
					<input type='button' calss='button' name="clear" id="clear" id="resetBtn" value='<fmt:message key="Common.clear.label" bundle="${common_labels}" />''>
				</td>
			
			</tr>
			
		</table>
		<input type='hidden' name='locale' id='locale' id='locale' value='<%=locale %>' />
		<input type='hidden' name='facilityId' id='facilityId' id='facilityId' value='<%=facilityId %>' />
	
	</form>
</body>
</html>

