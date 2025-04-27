<!DOCTYPE html>
 <!-- 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
	
08/10/2020		IN073826           Shazana		MMS-DM-CRF-0174.4
--------------------------------------------------------------------------------------------------------------
-->
 
 
 <%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
        request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<script language="Javascript" src="../../ePH/js/ReturnMedication.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="focusBarcode()" topmargin="0"> <!--  onload Added for GHL-CRF-0413.8 -->
<%
	String bean_id			= "DispMedicationBean" ;
	String bean_name		= "ePH.DispMedicationBean";
	DispMedicationBean bean = (DispMedicationBean)getBeanObject(bean_id,bean_name,request) ;
	String patient_id = request.getParameter("patient_id");
	String patient_name = request.getParameter("patient_name");
	String sex	= request.getParameter("sex");
	String age	= request.getParameter("age");
	String patient_class	= bean.getDispLocnCatg();
	String disp_no = request.getParameter("dispno");
	String totalRows1 = request.getParameter("totalRows1");
	String eff_status = CommonBean.checkForNull(request.getParameter("eff_status"));

	java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
	String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
    String bean_id1 = "ReturnMedicationBean"+login_at_ws_no ; ;
    String bean_name1 = "ePH.ReturnMedicationBean";
    ReturnMedicationBean ret_bean = (ReturnMedicationBean)getBeanObject( bean_id1,bean_name1,request) ;
   if(patient_class.equals("O")){
		patient_class = "OP";
	}
	else {
		patient_class = "IP";
	}
	String disp_locn_code   = bean.getDispLocnCode();
	boolean displayFacility = false;

   if(sex.equalsIgnoreCase("female"))
		sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
	else if(sex.equalsIgnoreCase("male"))
		sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
	else if(sex.equalsIgnoreCase("unknown"))
		sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

%>
<form name="frmPatientDetails" id="frmPatientDetails" >

<table cellpadding="0" cellspacing="0" width="100%" align="left" border="0" id="patient_details" > 
	<tr>
		<th class="commontoolbarfunction" align="left" width="100%">&nbsp;<%=patient_name%>&nbsp;,&nbsp;<%=sex%>&nbsp;,&nbsp;<%=age%>,&nbsp;<%=patient_id%></th>
	</tr>
	<!--<tr><a href="../../ePH/jsp/QueryPatientDrugProfileFrames.jsp?patient_id="+patient_id+"&disp_locn_code="+disp_locn_code+"&pat_class="+patient_class"><td class='label'>drug profile</a></tr>-->
	<tr><td>
	<font style="font-size:9;cursor:pointer" class="HYPERLINK" onClick="showDrugProfile('<%=patient_id%>','<%=disp_locn_code%>','<%=patient_class%>')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.DrugProfile.label" bundle="${common_labels}"/></td></font>
	
	</tr>
	<%if(eff_status.equals("E")){%>
	<tr>
	<td class="label" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.change.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.status.label" bundle="${common_labels}"/>&nbsp;&nbsp;
			 <SELECT name="ChangeStatus" id="ChangeStatus" id="ChangeStatus" onChange="ChangeResult('<%=totalRows1%>',this);">
			     <OPTION value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</OPTION>
				<OPTION value="A" selected><fmt:message key="Common.Accept.label" bundle="${common_labels}"/></OPTION>
				<OPTION value="R"><fmt:message key="Common.Reject.label" bundle="${common_labels}"/></OPTION>  
				<OPTION value="P"><fmt:message key="ePH.PartialAcceptReject.label" bundle="${ph_labels}"/></OPTION>   </SELECT>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<!--  Added for GHL-CRF-0413.8[IN063028] - Start -->
   <%if(ret_bean.getBarCodeflag((String)session.getValue("facility_id"), ret_bean.getLoginDispLocnCode()).equals("Y")){ %>
			   <fmt:message key="ePH.BarCode.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;
	           <input type="text" class='fields' name="barcode_id" id="barcode_id" style="text-align:right;background-color:#fde6d0"  onkeydown="if (event.keyCode==13) {callBarcodeflg(this);}" maxlength="100"  size=80><!--  Modified for [IN063761] backgroundcolor added, increased maxlength for IN073826  -->
   <%}%>
	           <!--  Added for GHL-CRF-0413.8[IN063028] - End -->
	</td >
	</tr>
	<%}%>
</table>
 
</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

