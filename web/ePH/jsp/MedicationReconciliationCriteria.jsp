<!DOCTYPE html>
 <% /* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
10/10/2019  IN070786                PRATHYUSHA                       MMS-KH-CRF-0016.1
---------------------------------------------------------------------------------------------------------------
*/ %>
 <!--This file is saved on 22/05/2019-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
	<%
 		request.setCharacterEncoding("UTF-8"); 
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
	<script language="JavaScript" src="../js/MedicationReconciliation.js"></script>
	<script language="JavaScript" src="../js/Prescription_1.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%

 	String patient_id		    =	request.getParameter("patient_id");
 	String encounter_id		    =	request.getParameter("encounter_id");
 	//String patient_class	    =	request.getParameter("patient_class");
 	String pract_id		        =	request.getParameter("pract_id");
 	String iv_prep_yn		    =	request.getParameter("iv_prep_yn");
 	String pract_type		    =	request.getParameter("pract_type");
 	String discharge_ind	    =	request.getParameter("discharge_ind");
 	String patient_age          =	request.getParameter("patient_age");
 	String gender               =	request.getParameter("gender");
 	String patient_name         =	request.getParameter("patient_name");
 	String log_pract_id         = request.getParameter("log_pract_id");
 	String called_from		    =	request.getParameter("called_from");//added for IN070786
	String presBean_id			= "@PrescriptionBean"+patient_id+encounter_id;
	String presBean_name		= "ePH.PrescriptionBean";
	PrescriptionBean presBean	= (PrescriptionBean)getBeanObject( presBean_id,presBean_name,request);
//added for IN070786  start
	String bean_id1		= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name1	= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean1		= (PrescriptionBean_1)getBeanObject( bean_id1,bean_name1,request );
	String no_ext_drug=(String)bean1.extDrugApplicableYN(patient_id,encounter_id);//added for IN070786
	String reconciliation_done_yn=CommonBean.checkForNull((String)bean1.reconciliationDoneyn(patient_id,encounter_id));
	//added for IN070786 end
	ArrayList fm_to_dates	=	presBean.getFromToDates();
	String from_date = (String) fm_to_dates.get(0)==null?"": (String) fm_to_dates.get(0);
	String to_date = (String) fm_to_dates.get(1)==null?"": (String) fm_to_dates.get(1);
	if(!locale.equals("en")){
		from_date = DateUtils.convertDate(from_date, "DMY","en",locale);
		to_date = DateUtils.convertDate(to_date, "DMY","en",locale);
	}

%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onunload="ExternalDrugInsert()" ><!-- added for IN070786 -->
<form name="frmMedicationReconciliationCriteria" id="frmMedicationReconciliationCriteria">
	<table cellpadding=0 cellspacing=0 width="100%" align="center"  border="0">
            <th colspan="5"  ><fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}"/></th>
			<tr>&nbsp;&nbsp;</tr>
			<tr>
				<td   class="label" width="10%"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
				<td   width="20%">&nbsp;&nbsp;<select name="patient_class" id="patient_class">
						<option value="B" selected><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option> 
						<option value="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;</option> 
						<option value="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;</option> 						
					</select>
				</td> 
				
				<td   class="label" colspan="2"><fmt:message key="Common.OrderDateFrom.label" bundle="${common_labels}"/>&nbsp;&nbsp;
					<input type="text" name="order_date_from" id="order_date_from" value="<%=from_date%>" maxlength="12" size="8" onBlur="validDateFormat(this,'<%=locale%>'); "><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('order_date_from'); " >&nbsp;&nbsp;<img src="../../eCommon/images/mandatory.gif"  ></img>
					&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;
					<input type="text" name="order_date_to" id="order_date_to"   value="<%=to_date%>" maxlength="12" size="8" onBlur="validDateFormat(this,'<%=locale%>');"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('order_date_to'); " >&nbsp;&nbsp;<img src="../../eCommon/images/mandatory.gif"  ></img>
				</td>
				<td  >
					<input type="button" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="validateDate1('<%=locale%>');" name="btnCriteriaSearch">
					<input type="button" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' class="button" onClick="reset()" name="btnReset">
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
				<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><%=patient_id%></b><input type="hidden" name="pat_id" id="pat_id" value="<%=patient_id%>"></td>	<!-- <b> added for INC#70594 -->										
			</tr>					
	</table>
	               <input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
			       <input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
			       <input type="hidden" name="pract_id" id="pract_id" value="<%=pract_id%>">
			       <input type="hidden" name="iv_prep_yn" id="iv_prep_yn" value="<%=iv_prep_yn%>">
			       <input type="hidden" name="pract_type" id="pract_type" value="<%=pract_type%>">
			       <input type="hidden" name="discharge_ind" id="discharge_ind" value="<%=discharge_ind%>">
			       <input type="hidden" name="patient_name" id="patient_name" value="<%=patient_name%>">
			       <input type="hidden" name="gender" id="gender" value="<%=gender%>">
			       <input type="hidden" name="patient_age" id="patient_age" value="<%=patient_age%>">			      
			       <input type="hidden" name="log_pract_id" id="log_pract_id" value="<%=log_pract_id%>">		
			       <INPUT TYPE="hidden" name="no_ext_drug" id="no_ext_drug" VALUE="<%=no_ext_drug%>"><!-- ADDED FOR IN070786 -->
			        <INPUT TYPE="hidden" name="no_ext_drug1" id="no_ext_drug1" VALUE=""> <!-- ADDED FOR IN070786 -->  
			         <input type="hidden" name="reconciliation_done_yn" id="reconciliation_done_yn" value="<%=reconciliation_done_yn%>"><!-- added for IN070786 -->    
			         <input type="hidden" name="called_from" id="called_from" value="<%=called_from%>"><!-- added for IN070786 -->
		
</form>
</body>

<script>document.frmMedicationReconciliationCriteria.btnCriteriaSearch.click();</script>

</html>

