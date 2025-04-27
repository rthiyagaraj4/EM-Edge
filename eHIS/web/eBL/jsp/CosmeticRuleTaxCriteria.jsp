<!DOCTYPE html>
<%-- Added by Rajesh V for KAUH-CRF-0318
	This page contains the Tax Criteria--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tax Criteria</title>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE");
	String facilityId = (String)session.getAttribute("facility_id");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language='javascript' src='../../eBL/js/CosmeticRule.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	$(document).ready(function(){
	
		$("input[type='text']").keydown(function(e){
			if (e.which === 8 && !$(e.target).is("input[type='text']:not([readonly])")) {
				e.preventDefault();
		    }
	});
</script>
</head>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 	onSelect="codeArrestThruSelect();">
	<table  width="100%" align="center" cellpadding=3 cellspacing=0>
		<tr >
			<td  class='COLUMNHEADER' nowrap >Cosmetic Rule Header</td>
		</tr>
	</table>
	<br/>
	<form name='taxCriteriaFrm' id='taxCriteriaFrm' id='taxCriteriaFrm' >	
		<table style="width:90% ">
			<tr style="width: 100%">
				<td style="width: 40%">
					<fmt:message key="eBL.Type.label" bundle="${bl_labels }"></fmt:message>
				</td>
				<td style="width: 10%">
				</td>
				<td style="width: 50%">
					<fmt:message key="eBL.ItemCode.label" bundle="${bl_labels }"></fmt:message>
				</td>
			</tr> 
			<tr  rowValue='1' id='tr1' style="width: 100%>
				<td style="width: 40%">
					<select name='servType1' id='servType1' id='servType1'>
					<option value=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels }"></fmt:message></option>
					</table>
				</td>
				<td style="width: 10%">
				
				</td>
				<td style="width: 50%">
					<input type='text' name='servCode1' id='servCode1' id='servCode1' size="10" value="" onblur="if(this.value!=''){ callCommonLookupCode(servDesc1,servCode1,6,1); } else{ fnClearCode(servDesc1); }">&nbsp;
					<input type='text' name='servDesc1' id='servDesc1' id='servDesc1' size="30" value="" onblur="if(this.value!=''){ callCommonLookupCode(servDesc1,servCode1,6,2); } else{ fnClearCode(servCode1); }">&nbsp;
					<input type='button' class='button' name="servBtn1" id="servBtn1" value='?' onClick="callCommonLookupCode(servDesc1,servCode1,6,2)" tabindex='2'>									
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

