<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Total Outstanding Unbilled</title>

<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css"; 
			

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="JavaScript" src="../../eBL/js/BillReceipt.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

   <style>
	.Unprocessed{
		width: 50px;
		height: 12.5px;
		background: #52BD15;
	}
	.Unconfirmed{
		width: 50px;
		height: 12.5px;
		background: red;
	}

</style>
<script>
	$(document).ready(function(){

	
		$('#close').click(function(){
		///	window.close();
		const diagElement = parent.parent.document.getElementsByTagName('dialog');
for (var i = 0; i < diagElement.length; i++) {
    for (var j = 0; j < diagElement[i].children.length; j++) {
        var element = diagElement[i].children[j];
        let dialogSrc = element.src;
        if (typeof dialogSrc !== 'undefined') {
            if (dialogSrc.includes('BillReceiptUnbillServReqMain.jsp')) {
               diagElement[i].close(); 
            }
        }
    }
} 
		});
	
});
	</script>
	</head>


		<table style="width: 20%;" align="left">
		<tr>
			<td style="width: 5%;">
				<span class='Unprocessed'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<td style="width: 5%;" class='LABEL'>
				Unprocessed
			</td>		
			<td style="width: 5%;">
				<span class='Unconfirmed'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<td style="width: 5%;" class='LABEL'>
			Unconfirmed
			</td>
			<td>
			<span style='padding-left: 20px;'>
			<input type='button' class='button' value='close' id='close'>
	</span>
	</td>
		</tr>		
	</table>
	</html>

