<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String facilityId = (String) session.getAttribute("facility_id");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>	
<script language='javascript' src='../js/BLReprintReportReceipt.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 	onSelect="codeArrestThruSelect();">
	<form name='reprintBtn' id='reprintBtn'>
		<div id='btnDiv' style="display: none;">
			<table width='100%' align="center">
				<tr>								
					<!--    <td width='15%' align='right'><fmt:message key="eBL.REASONFORCANCEL.label" bundle="${bl_labels}"/>&nbsp;&nbsp;&nbsp;<input class='fields' type="text" name='resonForCancel' id='resonForCancel' id='resonForCancel' value='' readonly></td>					
					<td width='15%' align='right'> <fmt:message key="eBL.VOIDNUMBER.label" bundle="${bl_labels}"/>&nbsp;&nbsp;&nbsp;<input class='fields' type="text" name='voidNumber' id='voidNumber' id='voidNumber' value='' readonly ></td> -->
					<td width='15%' align='right'><input class='button' type="button" name='btnReprint' id='btnReprint' id='btnReprint' value='Reprint All Receipt/Refund' onclick='printBulk();'  >&nbsp;&nbsp;&nbsp;<input class='button' type="button" name='btncancel' id='btncancel' value='Cancel All Receipt/Refund' onclick='bl_cancel1();' style='display:"Cancel All Receipt/Refund";margin-right: 10px;'></td>
				</tr>
			</table>
			<input type='hidden' name='facilityId' id='facilityId' id='facilityId' value='<%=facilityId %>'>
		</div>
	</form>
</body>
</html>

