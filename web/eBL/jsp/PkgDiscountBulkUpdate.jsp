<!DOCTYPE html>
<%-- Added by Rajesh V for MMS-CRF-0125
	Bulk Upadate page for Price Revision--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bulk Update</title>
</head>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonCalendar.js'></Script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eBL/js/PkgBulkUpdate.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	$(document).ready(function(){
		$('#priceBulkAdd').click(function(){
			addDiscountBulkUpdate();
		});
		$('#priceBulkRemove').click(function(){
			fnBulkRemove();
		});
		/*$('#discountRate').click(function(){
			var price = $(parent.bulkUpdate.document).find('#packageRate');
			$(price).prop('checked',false);
		});*/
	});
	</script>
<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 	onSelect="codeArrestThruSelect();">
<form name='bulkUpdateFrm' id='bulkUpdateFrm' >
	<table id='bulkUpdateTbl' name='bulkUpdateTbl'  width="100%" align="center">
		<tr  style="padding-bottom: 10px;" >
			<td colspan="9" class='COLUMNHEADER' nowrap>Package Discount Bulk Update</td>
		</tr>		
		<tr>
			<td class='label'  width="20%" style="padding-bottom: 5px;padding-left: 10px;">
				<!-- <input type="checkbox" name="discountRate" id="discountRate" id='discountRate'>  -->&nbsp;
				<fmt:message key="eBL.Discount.label" bundle="${bl_labels }"></fmt:message>
			</td>
			<td width="10%" nowrap class='label' style="padding-bottom: 5px;">
				<fmt:message key="eBL.discountType.label" bundle="${bl_labels }"></fmt:message>
				<img src='../../eCommon/images/mandatory.gif'>	
			</td>
			<td width="10%" nowrap class='label' style="padding-bottom: 5px;">
				<fmt:message key="eBL.Percentage.label" bundle="${bl_labels }"></fmt:message>
				<img src='../../eCommon/images/mandatory.gif'>	
			</td>
			<td width="10%" nowrap class='label' style="padding-bottom: 5px;">
				<fmt:message key="eBL.MarkUpOrDown.label" bundle="${bl_labels }"></fmt:message>
				
			</td>
			<td width="10%" nowrap class='label' style="padding-bottom: 5px;">
				<fmt:message key="eBL.RoundOff.label" bundle="${bl_labels }"></fmt:message>
			</td>
			<td width="10%" nowrap class='label' style="padding-bottom: 5px;padding-top: 5px;">
				<fmt:message key="eBL.RoundUpOrDown.label" bundle="${bl_labels }"></fmt:message>
			</td>
			<td width="10%" nowrap class='label' style="padding-bottom: 5px;">
				<fmt:message key="eBL.EffectiveFrom.Label" bundle="${bl_labels }"></fmt:message>
				<img src='../../eCommon/images/mandatory.gif'>	
			</td>
			<td width="10%" nowrap class='label' style="padding-bottom: 5px;">
				<fmt:message key="eBL.EffectiveTo.Label" bundle="${bl_labels }"></fmt:message>
			</td>
			<td width="10%" nowrap class='label' style="padding-bottom: 5px;padding-top: 5px;">
				<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels }"></fmt:message></option>
			</td>
		</tr>
		<tr rowValue='1' id='tr1'>
			<td width="20%" nowrap class='label'  style="padding-left: 30px;">

			</td>
			<td width="10%" >
				<select name='pkgDiscType1' id='pkgDiscType1' onchange="checkForPerc(this,discPriceOrAmt1)">
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels }"></fmt:message></option>
					<option value="P"><fmt:message key="eBL.Percentage.label" bundle="${bl_labels }"></fmt:message></option>
					<!-- <option value="A"><fmt:message key="eBL.Amount.label" bundle="${bl_labels }"></fmt:message></option>  -->
				</select>
			</td>
			<td width="10%" >				
				<input type='text' name='discPriceOrAmt1' id='discPriceOrAmt1' size="15"  maxlength="13"  onkeypress='return checkForSpecChars(event)' onblur='checkForNumberDecimal(this);checkForPerc(pkgDiscType1,this)'>&nbsp;
			</td>
			<td width="10%" >
				<select name='discMarkUpDown1' id='discMarkUpDown1'>
					<option value="N"><fmt:message key="Common.none.label" bundle="${common_labels }"></fmt:message></option>
					<option value="U"><fmt:message key="Common.Up.label" bundle="${common_labels }"></fmt:message></option>
					<option value="D"><fmt:message key="eBL.DOWN.label" bundle="${bl_labels }"></fmt:message></option>		
								
				</select>
			</td>
			<td width="10%" >
				<input type='text' name='discRoundOff1' id='discRoundOff1' size="15"  maxlength="5"  onkeypress='return checkAlpha(event)' onblur='checkForNumber(this)'>&nbsp;
			</td>
			<td width="10%" >
				<select name='discRndMarkUpDown1' id='discRndMarkUpDown1'>
					<option value="N"><fmt:message key="Common.none.label" bundle="${common_labels }"></fmt:message></option>
					<option value="U"><fmt:message key="Common.Up.label" bundle="${common_labels }"></fmt:message></option>
					<option value="D"><fmt:message key="eBL.DOWN.label" bundle="${bl_labels }"></fmt:message></option>
										
				</select>
			</td>
			<td width="10%" >
				<input type='text' name='effFrom1' id='effFrom1'  size='10' maxlength='10' onBlur='validDateLocal(this,2,1);' value='' />
				<img src='../../eCommon/images/CommonCalendar.gif'  id='dStartDate_ctrl1' onClick="return showCalendarLocal(1,1);" />
			</td>
			<td width="10%" >
				<input type='text' name='effTo1' id='effTo1' size='10' maxlength='10' onBlur='validDateLocal(this,2,1);' value='' />
				<img src='../../eCommon/images/CommonCalendar.gif' id='dEndDate_ctrl1' onClick="return showCalendarLocal(2,1);" />
			</td>
			<td width="10%" >
				<input type='checkbox' name='bulkRemove1' id='bulkRemove1'  />				
			</td>
		</tr>
	</table>
	<br/>
	<table width='100%'>
		<tr>
			<td width='80%'>
			</td>
			<td width='10%'>
				<input type='button' name='priceBulkAdd' id='priceBulkAdd'  value='Add'>
			</td>
			<td width='10%'>
				<input type='button' name='priceBulkRemove' id='priceBulkRemove' value='Remove'>
			</td>
		</tr>
	</table>
	<input type='hidden' name='pageId' id='pageId' value='Bulk'>
	<input type='hidden' name='lastRowIndex' id='lastRowIndex' value=''>
</form>
</body>
</html>

