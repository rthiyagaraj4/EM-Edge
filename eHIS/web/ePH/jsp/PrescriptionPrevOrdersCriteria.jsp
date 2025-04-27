<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale = (String) session.getAttribute("LOCALE");
		
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/common.js" ></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
	<!-- <script language="JavaScript" src="../js/PhMessages.js"></script> -->
	<script language="JavaScript" src="../../ePH/js/Prescription_1.js"></script>
	<script language="JavaScript" src="../../ePH/js/PrescriptionTest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
//	String ip_selected		=	"";
//	String op_selected		=	"";

	//String patient_class	=	request.getParameter("patient_class");
	String pract_id			=	request.getParameter("pract_id");
	String patient_id		=	request.getParameter("patient_id");
	String encounter_id		=	request.getParameter("encounter_id");
	String rx_type	    	=	request.getParameter("rx_type");
	String pract_type	   	=	request.getParameter("pract_type")==null?"":request.getParameter("pract_type"); //Added for ML-BRU-SCF-0958 [EMR IN:1835]
	String discharge_ind   =    request.getParameter("discharge_ind")==null?"":request.getParameter("discharge_ind"); //Added for Bru-HIMS-CRF-403
	String disable="";
	String checked="";
	String defaultAll   = ""; //Added for MO-CRF-20103 [IN:055441]
	String defaultSelf   = ""; //Added for MO-CRF-20103 [IN:055441]
	if(rx_type.equals("")){
		disable="";
		checked="checked";
	}
	else{
		disable="disabled";
		checked="checked";
	}

	String bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name		= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean		= (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	String presBean_id			= "@PrescriptionBean"+patient_id+encounter_id;
	String presBean_name		= "ePH.PrescriptionBean";
	PrescriptionBean presBean		= (PrescriptionBean)getBeanObject( presBean_id,presBean_name,request);

	ArrayList fm_to_dates	=	presBean.getFromToDates();
	String from_date = (String) fm_to_dates.get(0)==null?"": (String) fm_to_dates.get(0);
	String to_date = (String) fm_to_dates.get(1)==null?"": (String) fm_to_dates.get(1);
	if(!locale.equals("en")){
		from_date = DateUtils.convertDate(from_date, "DMY","en",locale);
		to_date = DateUtils.convertDate(to_date, "DMY","en",locale);
	}
	
	if(presBean.isSiteSpecific("PH","DEFAULT_ALL_PRACT")){ // MO-CRF-20103 [IN:055441] - Start 
		defaultAll   = "checked";
		defaultSelf   = "";
	}
	else{
		defaultSelf   = "checked";
		defaultAll   = "";
	} // MO-CRF-20103 [IN:055441] - End
		
	//out.println("dates"+fm_to_dates);
//	if(patient_class.equals("IP"))
//		ip_selected		=	"selected";
//	else
//		op_selected		=	"selected";


%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name="frmPrescriptionPrevOrdersCriteria" id="frmPrescriptionPrevOrdersCriteria">
	<table cellpadding=0 cellspacing=0 width="100%" align="center"  border="0">
            <th colspan="5"  ><fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}"/></th>
			<tr>
				<td   class="label" width="10%"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
				<td   width="20%">&nbsp;&nbsp;<select name="patient_class" id="patient_class">
						<option value="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;</option> 
						<option value="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;</option> 
						<option value="B" selected><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option> 
					</select>
				</td>
				<td   class="label" width="25%"><fmt:message key="Common.Orders.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td   class="label" width="18%">
					<input type="radio" name="orders" id="orders" value="SRO" <%=defaultSelf%>><fmt:message key="Common.SelfRelated.label" bundle="${common_labels}"/> <!-- checked changed to defaultSelf for MO-CRF-20103 [IN:055441] -->
				</td>
				<td   class="label" width="27%">
					<input type="radio" name="orders" id="orders" value="ALLO" <%=defaultAll%>><fmt:message key="ePH.AllPractitioners.label" bundle="${ph_labels}"/> <!-- defaultAll Added for MO-CRF-20103 [IN:055441]  -->
				</td>	
			</tr>
			<tr>
				<td   class="label" ><fmt:message key="Common.OrderStatus.label" bundle="${common_labels}"/></td>
				<td  >&nbsp;&nbsp;<select name="ord_status" id="ord_status">
						<option value="A"> <fmt:message key="Common.all.label" bundle="${common_labels}"/> </option>
						<option value="DC"><fmt:message key="Common.Discontinued.label" bundle="${common_labels}"/> </option>
						<option value="CN"><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/> </option>
						<option value="DF"><fmt:message key="Common.completed.label" bundle="${common_labels}"/> </option>
						<option value="DP"><fmt:message key="ePH.PartialyDispensed.label" bundle="${ph_labels}"/> </option>
						<option value="OS"><fmt:message key="ePH.Out-Standing.label" bundle="${ph_labels}"/> </option>
						<option value="AL"><fmt:message key="ePH.Filled/allocated.label" bundle="${ph_labels}"/> </option>						
				</select>
				</td>
				<td   class="label"><fmt:message key="Common.groupby.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td class="label"><input type="radio" name="group_by" id="group_by" value="PR" <%=checked%> <%=disable%>><fmt:message key="ePH.MedicationOrders.label" bundle="${ph_labels}"/>
				</td>
				<td class="label">
					<input type="radio" name="group_by" id="group_by" value="DR" <%=disable%>> <fmt:message key="Common.Drug.label" bundle="${common_labels}"/>
				</td>
			</tr>
			 <tr>
				<td   class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td   class="data">&nbsp;&nbsp;<%=patient_id%><input type="hidden" name="pat_id" id="pat_id" value="<%=patient_id%>"></td>
				<td   class="label" colspan="2"><fmt:message key="Common.OrderDateFrom.label" bundle="${common_labels}"/>&nbsp;&nbsp;
					<input type="text" name="order_date_from" id="order_date_from" value="<%=from_date%>" maxlength="12" size="8" onBlur="validDateFormat(this,'<%=locale%>'); "><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('order_date_from'); " >&nbsp;&nbsp;<img src="../../eCommon/images/mandatory.gif"  ></img>
					&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;
					<input type="text" name="order_date_to" id="order_date_to"   value="<%=to_date%>" maxlength="12" size="8" onBlur="validDateFormat(this,'<%=locale%>');"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('order_date_to'); " >&nbsp;&nbsp;<img src="../../eCommon/images/mandatory.gif"  ></img>
				</td>

				<td  >
					<input type="button" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="validateDate('<%=locale%>');" name="btnCriteriaSearch" id="btnCriteriaSearch">
					<input type="button" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' class="button" onClick="resetCriteria()" name="btnReset" id="btnReset">
				</td>
			</tr>
           
		</table>
		<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
		<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
		<input type="hidden" name="pract_id" id="pract_id" value="<%=pract_id%>">
		<input type="hidden" name="rx_type" id="rx_type" value="<%=rx_type%>">
		<input type="hidden" name="pract_type" id="pract_type" value="<%=pract_type%>"> <!--Added for ML-BRU-SCF-0958 [EMR IN:1835]-->
		<input type="hidden" name="discharge_ind" id="discharge_ind" value="<%=discharge_ind%>"><!--Added for Bru-HIMS-CRF-403-->
</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
<script>document.getElementById('btnCriteriaSearch').click();</script>
</html>

