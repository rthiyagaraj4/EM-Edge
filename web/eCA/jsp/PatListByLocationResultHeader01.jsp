<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.Common.*,java.util.*,eCA.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<tr>
	<th>&nbsp;</th>
	<th>&nbsp;</th>
	<th nowrap><a id='a01'   href="javascript:callForOrderByLoc('PN');" onclick='changeColor(this);' style='color:white'>
				<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></th>
	<th nowrap><a id='a02'   href="javascript:callForOrderByLoc('RID');" onclick='changeColor(this);' style='color:white'>
				<fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></th>
	<th nowrap><a id='a03'   href="javascript:callForOrderByLoc('AGE');" onclick='changeColor(this);' style='color:white'>
				<fmt:message key="Common.age.label" bundle="${common_labels}"/></a></th>
	<th nowrap><a id='a04'   href="javascript:callForOrderByLoc('SEX');" onclick='changeColor(this);' style='color:white'>
				<fmt:message key="Common.Sex.label" bundle="${common_labels}"/></a></th>
	<th nowrap><a id='a05'   href="javascript:callForOrderByLoc('PID');" onclick='changeColor(this);' style='color:white'>
				<fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></th>
	<th nowrap><a id='a06'  href="javascript:callForOrderByLoc('RS');" onclick='changeColor(this);' style='color:white'> 				
				<fmt:message key="eCA.ReferralStatus.label" bundle="${ca_labels}"/></a></th>
	<th nowrap><a id='a07'   href="javascript:callForOrderByLoc('AD');" onclick='changeColor(this);' style='color:pink'>
				<fmt:message key="Common.VisitAdmDate.label" bundle="${common_labels}"/></a></th>
	<th nowrap><a id='a08' href="javascript:callForOrderByLoc('DD');" onclick='changeColor(this);' style='color:white'> 				
				<fmt:message key="eCA.VisitAdmEndDate.label" bundle="${ca_labels}"/></a></th>
	<th nowrap><a id='a09'   href="javascript:callForOrderByLoc('RN');" onclick='changeColor(this);' style='color:white'> 				
				<fmt:message key="Common.roomno.label" bundle="${common_labels}"/></a></th>
	<th nowrap><a id='a10'   href="javascript:callForOrderByLoc('BN');" onclick='changeColor(this);' style='color:white'> 				
				<fmt:message key="Common.bedno.label" bundle="${common_labels}"/></a></th>
	<th nowrap><fmt:message key="eCA.PatientClassification.label" bundle="${ca_labels}"/></th> 
	<th nowrap><a id='a11'   href="javascript:callForOrderByLoc('AP');" onclick='changeColor(this);' style='color:white'> 				
				<fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></a></th>
	<th nowrap><fmt:message key="Common.action.label" bundle="${common_labels}"/></th>
</tr> 
