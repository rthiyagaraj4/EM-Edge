<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eBL/js/CommonPolicyAddTable.js"></script>
<script language="javascript" src="../../eBL/js/CommonPolicyDefinition.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function addRowNew(){
	var frm = parent.PolicyDetailsPage.document.forms[0];
	var pageInfo = frm.pageInfo.value;
	if(pageInfo == 'PreApprovalPopup'){
		addRow('PreApprovalPopup')
	}
	//alert(pageInfo);
}
function save(){
	var table_id = parent.PolicyDetailsPage.document.getElementById('PolicyPreApprovalPopup');
	var totRows = table_id.rows.length;
	totRows = totRows-1;
	for(prevIndex=1;prevIndex<=totRows;prevIndex++){

		var incExcCriteria = parent.PolicyDetailsPage.document.getElementById("pop_incExCriteria_"+prevIndex).value;
		var effFromDate = parent.PolicyDetailsPage.document.getElementById("pop_effFrom_"+prevIndex).value;
		var prevBillCode  = parent.PolicyDetailsPage.document.getElementById("pop_bg_code_"+prevIndex).value;
		var delFlag = parent.PolicyDetailsPage.document.getElementById("pop_delFlag"+prevIndex);
		
		if(!delFlag.checked){
			if(prevBillCode.length<1) {
				
			}
			else if(incExcCriteria.length<1 || prevBillCode.length<1 || effFromDate.length<1) {
				alert("Please enter all mandatory fields for Row Number "+prevIndex);
				return false;
			}
		}
		
	}
	
	var frmObj = parent.PolicyDetailsPage.document.forms[0];
	var priorityKey = frmObj.priorityKey.value;
	xmlString=formXMLStringMain(frmObj);
	//alert(xmlString);
	updation=formValidation(xmlString,"popup",priorityKey);
	window.close();	
}
</script>
</head>
<body>
<form>
<table width='95%'>
<tr>
<td width='75%'>
	
</td>
<td align='right' width='9%'>
<input type='button' class="BUTTON" value='Lookup' onClick='fnShowPolicyDetailReport();'>
</td>
<td align='right' width='5%'>
<input type='button' class='BUTTON' value='Add' onclick='addRowNew()'>
<!-- <input type='button' class='BUTTON' value='Remove' onclick='removeRowNewAddClose()'> --></td>
<td align='left' width='11%'> <input type='button' class='BUTTON' value='Close' onclick='save()'></td>
</tr>
</table>
</form>
</body>
</html>

