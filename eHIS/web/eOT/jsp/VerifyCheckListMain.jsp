<!DOCTYPE html>
<!--
Developed by    : Bhavani Shankar.
Module/Function : Verify CheckList (called from Check-in, Check-Out From Ward function)
start date		: 02/04/2005
-->
<%@  page  import="eOT.VerifyCheckListBean" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%
	String booking_num	= request.getParameter("booking_num");
	String oper_num		= request.getParameter("oper_num");
	String order_id		= request.getParameter("order_id");
	String appt_yn		= checkForNull(request.getParameter("appt_yn"));
	String invoked_from	= checkForNull(request.getParameter("invoked_from"));
	String bean_id		= "@VerifyCheckListBean";
	String bean_name	= "eOT.VerifyCheckListBean";

	VerifyCheckListBean bean = (VerifyCheckListBean)mh.getBeanObject(bean_id,request,bean_name);
	bean.clear();
	bean.loadUserInfo(invoked_from,appt_yn,booking_num,oper_num,order_id);
%>
<html>
<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${sessionScope.LOCALE}" />
<c:url var="ToolBar" value="/eCommon/jsp/commonToolbar.jsp" />
<c:url var="OTPatientLine" value="/eOT/jsp/OTPatLineFrame.jsp" />
<c:url var="CheckListHeader" value="/eOT/jsp/VerifyCheckListHeader.jsp" />
<c:url var="CheckListBody" value="/eOT/jsp/VerifyCheckList.jsp" />
<c:url var="CheckListConfirm" value="/eOT/jsp/VerifyCheckListConfirm.jsp" />
<c:url var="Message" value="/eCommon/jsp/error.jsp" />
<c:set var="prefix" value="${'/eCommon/html/'}" /> 
<c:set var="sep" value="${'?'}" /> 
<c:set var="style" value="${prefix}${sessionScope.PREFERRED_STYLE}" /> 
<c:set var="qrystring" value="${pageContext.request.queryString}" />
<c:set var="checklist_stage" value="${param['checklist_stage']}"  scope="request" />
<c:set var="check"  scope="request" value="${param['no_of_verifications']}"/>
<c:set var="check1"  scope="request" value="${'close the screen'}" />
<c:if test="${check eq 'null'}">
<c:set var="no_of_verifications" value="-1"/>
<script>
	alert("APP-OT0170 Speciality does not have checklist defined");
	window.close();
</script>
</c:if>
<c:if test="${check == '1'}">
</c:if>
<c:if test="${check ne 'null'}">
<c:set var="no_of_verifications" value="${check}"/>
</c:if>
<c:set var="query_flag_yn" value="${param['query_flag_yn']}"  scope="request"  />
<c:set var="function_name" value="${param['function_name']}"  scope="request"  />
<c:set var="called_from" value="${param['called_from']}"  scope="request"  />
<head>
<title><fmt:message key="eOT.VerifyCheckList.Label" bundle="${ot_labels}"/></title> 
<link rel='StyleSheet' type='text/css'  href='<c:url value="${style}" />' />
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eOT/js/VerifyCheckList.js"></script>
</head>
<c:choose>
 	 <c:when test="${(checklist_stage eq 'C20' || checklist_stage eq 'C60' || checklist_stage eq 'C70') and no_of_verifications lt 2  }" >   
	 <c:set var="query_flag_yn" value="Y"  scope="request" />
	 </c:when>	
	 <c:when test="${(checklist_stage eq 'C30' || checklist_stage eq 'C70' || checklist_stage eq 'C20' || checklist_stage eq 'C60' ) and no_of_verifications lt 3  }" >  
	 <c:set var="query_flag_yn" value="Y"  scope="request" />
	 </c:when>	 		  
	 <c:when test="${(checklist_stage eq 'C40' || checklist_stage eq 'C80') and no_of_verifications lt 4}" > 
	 <c:set var="query_flag_yn" value="Y"  scope="request" />
	 </c:when>   
	 <c:when test="${(checklist_stage eq 'C50' ) and no_of_verifications lt 1}" > 
	 <c:set var="query_flag_yn" value="Y"  scope="request" />
	 </c:when>
</c:choose>

<c:choose>  
<%--called from surgery History Function --%>
<c:when test="${empty called_from  and query_flag_yn eq 'Y'}" >
	 <frameset rows="0,0,32,*,60,10,0">
		 <frame name="commontoolbarFrame" frameborder="0" scrolling="no" noresize src='<c:out value="${ToolBar}${sep}${qrystring}" />' >
		<frame name="patient_title" frameborder="0" scrolling="no" noresize src='<c:out value="${OTPatientLine}${sep}${qrystring}" />' >
 </c:when>

<%--called from View CheckList(EDIT) --%>
 <c:when test="${empty query_flag_yn or query_flag_yn eq 'N'}" >		
		 <frameset rows="42,100,32,*,90,10,0"> 
			<frame name="commontoolbarFrame" frameborder="0" scrolling="no" noresize src='<c:out value="${ToolBar}${sep}${qrystring}" />' >
			<frame name="patient_title" frameborder="0" scrolling="no" noresize src='<c:out value="${OTPatientLine}${sep}${qrystring}" />' >
</c:when>
  
<%--called from View CheckList(View) --%>
<c:otherwise>
  
<frameset rows="45,62,32,*,90,0,0">
		 <frame name="commontoolbarFrame" frameborder="0" scrolling="no" noresize src='<c:out value="${ToolBar}${sep}${qrystring}" />' > 
		 <frame name="patient_title" frameborder="0" scrolling="no" noresize src='<c:out value="${OTPatientLine}${sep}${qrystring}" />' >
</c:otherwise> 
</c:choose>
	<frame name="f_header" frameborder="0" scrolling="no" noresize src='<c:out value="${CheckListHeader}${sep}${qrystring}"/>'>
	<frame name="f_add_modify" id="f_add_modify" frameborder="0" scrolling="auto" noresize src='<c:out value="${CheckListBody}${sep}${qrystring}"/>'>
	<frame name="f_confirm" frameborder="0" scrolling="yes" noresize src='<c:out value="${CheckListConfirm}${sep}${qrystring}"/>'>
	<frame name="messageFrame" frameborder="0" noresize scrolling="auto" src='<c:out value="${Message}${sep}${qrystring}"/>'>
	<frame name="chklistSessionFrame" frameborder="0" noresize src='../../eOT/jsp/ChkListRemarksSession.jsp'>
</frameset> 
<form name="VerifyCheckListForm">
	<input type='hidden' name='params' value='<c:out value="${qrystring}"/>'>   
</form>
</body>
</html>
