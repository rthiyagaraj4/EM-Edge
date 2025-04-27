<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,eST.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %> <!-- // charset=UTF-8 Added for TTM-SCF-0170-->
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
<%
    request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>

	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>
	<script language="JavaScript" src="../../ePH/js/RegPrescriptions.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="ePH.MarkPatientArrivalUndeliveredDrugsPerformingLocation.label" bundle="${ph_labels}"/></title>
</HEAD>
<body onload="callSearchPage();">
<form name="MarkPatArrivalQryCriteriaForm" id="MarkPatArrivalQryCriteriaForm">
<%
	String bean_id	         = "RegPrescriptionsBean";
 	String bean_name	     = "ePH.RegPrescriptionsBean";
	RegPrescriptionsBean bean	 =	(RegPrescriptionsBean)getBeanObject( bean_id,bean_name, request ) ;	
	String patient_id            = request.getParameter("patient_id");
    String flag		     = request.getParameter( "flag" );
	String dispense_locn = request.getParameter("disp_locn_code");
//	String classvalue        = "";
//	String style		     = "";
//	String styleord          = "";
	//String styletdmord       ="";
	String patlabel = "";
	String pagetitle = "";
	//int rowCount		     = 0;
	if(flag.equals("1")){
	pagetitle = "Mark Patient Arrival/ Undelivered Drugs";
	}
	if(flag.equals("2")){
	pagetitle = "Mark Patient Arrival";
	}
	if(flag.equals("3")){
	pagetitle = " Undelivered Drugs";
	}
	ArrayList getPatDetails= bean.getPatientDetails(patient_id);
String patient_name=  (String)getPatDetails.get(0);
String age=  (String)getPatDetails.get(1);
String gender=  (String)getPatDetails.get(2);
String nationality=  (String)getPatDetails.get(3);
String nationality_code	=	(String)getPatDetails.get(4);
patlabel=patient_name+" , "+age+" , " +gender+" , " +nationality;
	%>
<table align="center"  border="0" width="100%" cellspacing="0"   cellpadding="0">
<tr>
<!--	<th align="left" colspan="7"><%=pagetitle%></th>-->
</tr>
<tr width="100%">
		<td align="left" class="label" colspan=4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;
		<input type="text" name="patient_id" id="patient_id" maxlength="<%=bean.getPatientIDLength()%>" onKeyPress="changeToUpper()" value="<%=patient_id%>" disabled>
		<input type="button" value="?" class="button" name="btnPatientID" id="btnPatientID"  disabled>
		<img align='center' src ='../../eCommon/images/mandatory.gif'></img>&nbsp;&nbsp;
		<label class='label' id="patient_detail" align="left"><%=patlabel%></label>
		</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	</tr>

	<tr>
		<td align="right" class="label" id='frm_legend' width="15%"><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></td>
		<td align="left" class="label">&nbsp;
		<input type="text" maxlength=10 name="order_date_from" id="order_date_from"  size="10" onBlur="CheckDateN(this); validate_date(this,'TO_DATE_LESS_FROM');" value="<%=bean.getFromDate()%>">&nbsp;
		<INPUT TYPE="image" SRC="../../eCommon/images/CommonCalendar.gif" id=CalendarFrom onclick="showCalendar('order_date_from');return false;" >&nbsp;
		<img align='center' src ='../../eCommon/images/mandatory.gif'></img>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;
		<input type="text" name="order_date_to" id="order_date_to" size="10" onBlur="CheckDateN(this);validate_date(this,'TO_DATE_LESS_FROM');" value="<%=bean.getTodaysDate()%>">&nbsp;
		<INPUT TYPE="image" SRC="../../eCommon/images/CommonCalendar.gif" id=CalendarTo onclick="showCalendar('order_date_to');return false;" >&nbsp;
		<img align='center' src ='../../eCommon/images/mandatory.gif'></img>&nbsp;&nbsp;
		</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;</td>		
		<td>&nbsp;&nbsp;</td>
	</tr>

	<tr >
		<td align="right" class="label" id='frm_legend' width="15%">Token No</td>
		<td align="left" class="label">&nbsp;
		<input type="text" name="token_no" id="token_no" value="" maxlength=8 size=8 onkeyPress='return allowValidNumber(this,event,4,0)' class="NUMBER" >
		</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td align="right">
		<input type="button" name="btnSearch" id="btnSearch" value="Search" class="button" onClick="callSearchPage()">
		</td>
		<td>&nbsp;&nbsp;<input type="button" name="btnClear" id="btnClear" value="Clear" class="button" onClick="callClear()"></td>	
		<td>&nbsp;&nbsp;</td>
	</tr>
		<input type="hidden" name="age" id="age" value="<%=age%>" >
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="patient_name" id="patient_name" value="<%=patient_name%>">
	<input type="hidden" name="gender" id="gender" value="<%=gender%>" >
	<input type="hidden" name="nationality" id="nationality" value="<%=nationality%>" >
	<input type="hidden" name="nationality_code" id="nationality_code" value="<%=nationality_code%>" >
	<input type="hidden" name="dispense_locn" id="dispense_locn" value="<%=dispense_locn%>" >
	<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">



</table>
<br>

</form>
</body>
</html>
<% putObjectInBean(bean_id,bean,request); %>

