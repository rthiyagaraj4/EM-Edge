<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8 "%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script> -->
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<script language="JavaScript" src="../../ePH/js/RegPrescriptions.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
		<form name="RegPrescriptionsStatus" id="RegPrescriptionsStatus" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" bordercolor="black" id="regprescriptionsstatustable" name="regprescriptionsstatustable" style="visibility:hidden">
				<tr>
					<td class="white"  style="border-top:none;border-bottom:none;" width="18%"><label class="label" style='color:#B22222;font-size:9px;' ><b>&nbsp;<fmt:message key="ePH.UrgentOrders.label" bundle="${ph_labels}"/></b></label></td>
					<td class="white" style="border:none;" >&nbsp;<label class="label" style="font-size:9px;color:white"><b><fmt:message key="Common.Orders.label" bundle="${common_labels}"/> :</b></label></td>
					<td class="white" width="15%" color='white'  style='background-color:#FF0000;'><label class="label"style="font-size:9px;color:white"><b>&nbsp;<fmt:message key="Common.NewOrders.label" bundle="${common_labels}"/></b></label></td> 
					<td class="white" width="13%" color='white'   style='background-color:#CC9933;'><label class="label"  style="font-size:9px;color:white"><b>&nbsp;<fmt:message key="ePH.Refill.label" bundle="${ph_labels}"/> </b></label></td>
					<td class="white" width="13%" color='white'  style='background-color:#990000;' ><label class="label" style="font-size:9px;color:white"><b>&nbsp;<fmt:message key="ePH.BMS.label" bundle="${ph_labels}"/> </b></label></td>
					<td class="white" width="18%" color='white'  style='background-color:ADD8E6;' ><label class="label" style="font-size:9px;"><b>&nbsp;<fmt:message key="ePH.TakeHomeRx.label" bundle="${ph_labels}"/>&nbsp;</b></label></td>
					<td class="white" width="13%"   style='background-color:#33CC00;' ><label class="label" color='white' style="font-size:9px;" ><b>&nbsp;<fmt:message key="ePH.RegdPres.label" bundle="${ph_labels}"/> </b></label></td>	 
				</tr>
			</table>
		</form>
	</body>
	<SCRIPT LANGUAGE="JavaScript">
	loadPatientRelatedInfo();
	</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</html>

