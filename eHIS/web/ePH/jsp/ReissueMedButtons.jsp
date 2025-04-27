<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
   <!--  <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
   <%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../js/ReissueMed.js"></script>
	 <script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
	 <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	 <SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>

<!-- <body topmargin=0 leftmargin=0 bottommargin=0 > -->
<body topmargin=0 leftmargin=0 bottommargin=0 onMouseDown="" onKeyDown="lockKey()">
<form name="FormReissueMedicationButtons" id="FormReissueMedicationButtons" >
<%
String called_from	=	request.getParameter("called_from");
String bl_interface_yn	=	request.getParameter("bl_interface_yn");
String Disp_facility_id =  request.getParameter("Disp_facility_id"); // added by rawther

if(called_from==null)
	called_from	=	"";

	if(called_from.equals("")) {
%>
<table width="100%">
		<tr >
			<td align="right" width="100%" class="white">
				<input type="button" class="button" name="Allocate" id="Allocate" value='<fmt:message key="Common.Allocate.label" bundle="${common_labels}"/>' onclick="ReissueAllocate('<%=request.getParameter("rec_no")%>','<%=request.getParameter("qty")%>','<%=request.getParameter("qty_uom")%>','<%=request.getParameter("end_date")%>','<%=Disp_facility_id%>')"></td>
				<!--Disp_facility_id added for FD-BRU-CRF-09-->
		</tr>
</table>
<%	}	else	{	%>
<table width="100%">
<tr >
	<td align="center" width="100%" class="white">
		<label style="color:red;font-size:14"><fmt:message key="ePH.Disp_Qty_Reissued_Full.label" bundle="${bl_labels}"/></label>
	</td>
</tr>
</table>

<%	}

if(bl_interface_yn.equals("Y")){
%>
   <table cellpadding="0" cellspacing="0" height='10' width="100%" align="center" border="1">
	   <tr>
		   <td class="data" width='40%'>&nbsp;</td> 
		   <td  class="data"  align='center' style="font-size:9pt" id='total_payable' ><fmt:message key="ePH.TotalChargeAmount.label" bundle="${ph_labels}"/>  : <%=request.getParameter("tot_groos_pat_payable_str")%> </td>
		   <td  class="data"  align='center' style="font-size:9pt" id='patient_payable' ><fmt:message key="ePH.TotalPayableAmount.label" bundle="${ph_labels}"/>  : <%=request.getParameter("tot_gross_charge_amount_str")%></td>
	   </tr>
   </table>


<%}%>
</form>
</body>

</html>



