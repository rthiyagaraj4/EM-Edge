<!DOCTYPE html>
<%@page import="eBL.billreceipt.bc.BillReceiptBC"%>
<%@page import="eBL.billreceipt.model.BillReceiptExistOrderExclusion"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>    
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adhoc Discount Details</title>
<%!	
	private String checkForNull(String input)
	{
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
	}

	private String decodeParam(String input){
		String output = "";
		try{
			 if(input!=null){
				input = input.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
				input = input.replaceAll("\\+", "%2B");
				output = URLDecoder.decode(input,"UTF-8");
			 }
		}
		catch(Exception e){
			System.err.println("Exception while Decoding BillReceiptAjax->"+e);
		}
		return output;
	}
%>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String blngServCode = checkForNull(request.getParameter("blngServCode"));
	String blngServDesc = decodeParam(request.getParameter("blngServDesc"));
	String trxDocRef = checkForNull(request.getParameter("trxDocRef"));
	String trxDocRefLineNum = checkForNull(request.getParameter("trxDocRefLineNum"));
	String trxDocRefSeqNum = checkForNull(request.getParameter("trxDocRefSeqNum"));
	String serviceItemCode = checkForNull(request.getParameter("serviceItemCode"));
	String serviceItemDesc = decodeParam(request.getParameter("serviceItemDesc"));
	String gross = checkForNull(request.getParameter("gross"));
	String discount = checkForNull(request.getParameter("discount"));
	String net = checkForNull(request.getParameter("net"));
	String payer = checkForNull(request.getParameter("payer"));
	String moduleId = checkForNull(request.getParameter("moduleId"));
	String episodeType = checkForNull(request.getParameter("episodeType"));
	String patientId = checkForNull(request.getParameter("patientId"));
	String episodeId = checkForNull(request.getParameter("episodeId"));
	String visitId = checkForNull(request.getParameter("visitId"));
	String facilityId = (String) session.getValue("facility_id");
	String locale = (String) session.getValue("LOCALE");
	String serviceDate = checkForNull(request.getParameter("serviceDate"));
	String noOfDecimals = request.getParameter("noOfDecimals");
	String loginUser = (String) session.getValue("login_user");
	BillReceiptBC bc = new BillReceiptBC();
	String userPasword  = bc.getCredentails(loginUser);
	String beanId = "BillReceiptExistOrderExclusion" ;
	String beanName = "eBL.billreceipt.model.BillReceiptExistOrderExclusion";
	BillReceiptExistOrderExclusion exclusionBean = (BillReceiptExistOrderExclusion) getObjectFromBean(beanId, beanName, session);
	String discount_allowed_yn = "Y";
	String loggd_user_valid_for_disc_YN ="N";		
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language='javascript' src='../../eBL/js/BillReceipt.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
	$(document).ready(function(){
		
		if($('#prevDiscCode').val() == ''){
			$('#usePrevious').prop('disabled','disabled');
		}
		else{
			$('#usePrevious').prop('disabled','');
		}
		$('#close').click(function(){
			window.close();
		});
		$('#usePrevious').change(function(){
			if($(this).prop('checked')){
				$('#discountCode').val($('#prevDiscCode').val());
				$('#discountDesc').val($('#prevDiscDesc').val());
			}
			else{
				$('#discountCode').val('');
				$('#discountDesc').val('');
			}
					
		});
	});
</script>
<script>
function close(){
	const dialogTag = parent.document.getElementById("dialog_tag");    
    dialogTag.close();
}
</script>
<body>
	<br/>
	<form>
		<table style="width: 95%" align="right">
			<tr style="width:100%">
				<td width="25%" class='LABEL'>
					Service
				</td>
				<td class='LABEL' width="20%">
					<%=blngServCode %>
				</td>
				<td width="5%"></td>
				<td class='LABEL' colspan='2'>
					<%=blngServDesc %>
				</td>
				<td width="5%"></td>
			</tr>
			<tr>
				<td class='LABEL' width="25%">
					Item Code
				</td>
				<td class='LABEL' width="20%">
					<%=serviceItemCode %>
				</td>
				<td width="5%"></td>
				<td class='LABEL' colspan='2'>
					<%=serviceItemDesc %>
				</td>
				<td width="5%"></td>
			</tr>
			<tr>
				<td class='LABEL' width="25%" >
					Gross Amount
				</td>
				<td class='LABEL' width="20%" id='gross' style="text-align:right;">
				<span style="width: 100px;">
					<%=gross %></span>
				</td>
				<td width="5%"></td>
				<td class='LABEL'  width="25%">
					Discount Amount
				</td>
				<td class='LABEL'  width="20%" style="text-align:right;">
					<%=discount %>
				</td>
				<td width="5%"></td>
			</tr>
			<tr>
				<td class='LABEL' width="25%">
					Net Amount
				</td>
				
				<td class='LABEL' width="20%" style="text-align:right;">
					<%=net %>
				</td>
				<td width="5%"></td>
				<td class='LABEL'  width="25%">
					Addl Amount
				</td>
				<td class='LABEL'  width="20%" style="text-align:right;">
					&nbsp;
				</td>
				<td width="5%"></td>
			</tr>
			<tr>
				<td class='LABEL' width="25%">
					Adhoc Discount %
				</td>
				
				<td class='LABEL' width="20%">
					<input type='text' style="text-align: right;" name='discountPer' id='discountPer' onkeypress="return checkAlpha(event)" id='discountPer' size="7" maxlength="5" 
					onblur="if(this.value != ''){ findDiscount(gross,'P',this,netAfterDisc,discountAmt); }else{fnClearCode(discountAmt); $('#netAfterDisc').val($('#actGrossAmt').val());}">
				</td>
				<td width="5%"></td>
				<td class='LABEL'  width="25%">
					Adhoc Discount Amount
				</td>
				<td class='LABEL'  width="20%">
					<input type='text' style="text-align: right;" name='discountAmt' id='discountAmt' id='discountAmt' size="17" maxlength="12" onkeypress="return checkAlpha1(event)"
					onblur="if(this.value != ''){ findDiscount(gross,'A',this,netAfterDisc,discountPer);  }else{fnClearCode(discountPer); $('#netAfterDisc').val($('#actGrossAmt').val());}">
				</td>
				<td width="5%"></td>
			</tr>
			<tr>
				<td class='LABEL' width="25%">
					Net After Disc
				</td>
				
				<td class='LABEL' width="20%">
					<input type='text' style="text-align: right;" name='netAfterDisc' id='netAfterDisc' id='netAfterDisc' value='<%=net %>' readonly size="15" maxlength="3">
				</td>
				<td width="5%"></td>	
				<td class='LABEL' width="25%">
					Actual Gross Amt.
				</td>
				
				<td class='LABEL' width="20%">
					<input type='text' style="text-align: right;" name='actGrossAmt' id='actGrossAmt' id='actGrossAmt' value='<%=gross %>' readonly size="17" maxlength="12">
				</td>	
				<td width="5%"></td>	
			</tr>
			
			<tr>
				<td width='25%' class='LABEL'>
					<fmt:message key="Common.userid.label" bundle="${common_labels}"/>
				</td>
				<td width='20%' class="LABEL">
					<input type='text' name='adhoc_user_id' id='adhoc_user_id' id='adhoc_user_id' size='15'  maxlength='30'  value="<%=loginUser%>"  onkeypress ="changeToUpper()" 
					onBlur ="userValidation(this,'U');" >
				</td>
				<td width="5%"></td>
				<td width='25%' class='LABEL'>
					<fmt:message key="Common.PIN.label" bundle="${common_labels}"/>
				</td>
				<td width='20%' class="LABEL">
					<input type='password' name='user_password' id='user_password'  id='user_password' size='17'  maxlength='30'  value="<%=userPasword%>"  
					onblur="userValidation(this,'P');" autocomplete="off"><!--V230508-41626 -->
				</td>			
				<td width="5%"></td>			
			</tr>
			<tr style="width:100%">
				<td width="25%" class='LABEL'>
					Discount Reason
				</td>
				<td class='LABEL' width="20%">
					<input type='text' name='discountCode' id='discountCode' id='discountCode' size="15" value="<%=checkForNull(exclusionBean.getDefDiscCode()) %>" onblur="if(this.value!=''){ callCommonLookupCode(discountDesc,discountCode,1,1);  } else{ fnClearCode(discountDesc); }">										
				</td>
				<td width="5%"></td>
				<td class='LABEL' colspan='2'>
					<input type='text' name='discountDesc' id='discountDesc' id='discountDesc' size="44" value="<%=checkForNull(exclusionBean.getDefDiscDesc()) %>" onblur="if(this.value!=''){ callCommonLookupCode(discountDesc,discountCode,1,2);} else{ fnClearCode(discountCode); }">&nbsp;
					<input type='button' class='button' name="discountBtn" id="discountBtn" value='?' onClick="callCommonLookupCode(discountDesc,discountCode,1,2); " tabindex='2'>
				</td>
				<td width="5%"></td>
			</tr>
			<tr style="width:100%">
				<td class='LABEL' colspan='2'>
					<input type='checkbox' id='usePrevious' name='usePrevious' id='usePrevious' >&nbsp;Use Prev.Disc.Reason
				</td>		
				<td width="5%"></td>		
				<td class='LABEL' colspan='2'>
					<%if("".equals(checkForNull(exclusionBean.getDefDiscCode()))){ %>
						<input type='checkbox' id='makeDefault' name='makeDefault' id='makeDefault' >&nbsp;Make Default
					<%} else{ %>
						<input type='checkbox' id='makeDefault' name='makeDefault' id='makeDefault' checked>&nbsp;Make Default
					<%} %>
				</td>
				<td width="5%"></td>
			</tr>
			<tr>
				<td colspan = '5' align="right">
				<input type='button' class='button' id='validateDiscount' name='validateDiscount' id='validateDiscount' value='Ok' onclick="validate();">
				&nbsp;&nbsp;
				<input type='button' class='button' value='Close' id='close'>
				</td>
			</tr>
	</table>
	<input type='hidden' name='payer' id='payer' id='payer' value='<%=payer %>'>
	<input type='hidden' name='moduleId' id='moduleId' id='moduleId' value='<%=moduleId %>'>
	<input type='hidden' name='episodeType' id='episodeType' id='episodeType' value='<%=episodeType %>'>
	<input type='hidden' name='patientId' id='patientId' id='patientId' value='<%=patientId %>'>
	<input type='hidden' name='episodeId' id='episodeId' id='episodeId' value='<%=episodeId %>'>
	<input type='hidden' name='visitId' id='visitId' id='visitId' value='<%=visitId %>'>
	<input type='hidden' name='facilityId' id='facilityId' id='facilityId' value='<%=facilityId %>'>
	<input type='hidden' name='locale' id='locale' id='locale' value='<%=locale %>'>

	<input type='hidden' name='blngServCode' id='blngServCode' id='blngServCode' value='<%=blngServCode %>'>
	<input type='hidden' name='trxDocRef' id='trxDocRef' id='trxDocRef' value='<%=trxDocRef %>'>
	<input type='hidden' name='trxDocRefLineNum' id='trxDocRefLineNum' id='trxDocRefLineNum' value='<%=trxDocRefLineNum %>'>
	<input type='hidden' name='trxDocRefSeqNum' id='trxDocRefSeqNum' id='trxDocRefSeqNum' value='<%=trxDocRefSeqNum %>'>
	<input type='hidden' name='serviceItemCode' id='serviceItemCode' id='serviceItemCode' value='<%=serviceItemCode %>'>
	<input type='hidden' name='serviceDate' id='serviceDate' id='serviceDate' value='<%=serviceDate %>'>
	<input type='hidden' name='prevDiscCode' id='prevDiscCode' id='prevDiscCode' value='<%=checkForNull(exclusionBean.getPrevDiscCode()) %>'>		
	<input type='hidden' name='prevDiscDesc' id='prevDiscDesc' id='prevDiscDesc' value='<%=checkForNull(exclusionBean.getPrevDiscDesc()) %>'>
	<input type='hidden' name='noOfDecimals' id='noOfDecimals' id='noOfDecimals' value='<%=noOfDecimals %>'>
	<input type='hidden' name='loginUser' id='loginUser' id='loginUser' value='<%=loginUser %>'>

	<input type='hidden' name='hdnDiscPer' id='hdnDiscPer' id='hdnDiscPer' value=''>
	<input type='hidden' name='hdnDiscAmt' id='hdnDiscAmt' id='hdnDiscAmt' value=''>
	<input type='hidden' name='hdnUserId' id='hdnUserId' id='hdnUserId' value='<%=loginUser%>'>
	</form>
</body>
</html>