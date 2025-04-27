<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="eSS.*,java.util.*,java.sql.*, eSS.Common.* , eCommon.Common.*,java.util.Properties,java.util.ArrayList,java.util.Hashtable,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
<head>
<%		
		request.setCharacterEncoding("UTF-8");
		String locale						 =		(String)session.getAttribute("LOCALE");
		String sStyle						 =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eSS/js/ROFDetails.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	
//	java.util.HashMap defaultParameter		=		null;
	String bean_id							=		"ROFDetailsBean";
	String bean_name						=		"eSS.ROFDetailsBean";
	String disabled							=		"";
//	String facility_id						=		(String) session.getValue("facility_id");

	ROFDetailsBean bean						=		(ROFDetailsBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	HashMap alstartdate           = bean.getDurationforStartDate();
    String to_date			  =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
	String from_date		  =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);
	
%>
<body onload='FocusFirstElement();showTrayDtl();' onMouseDown="CodeArrest()">
	
	<form name="ROFDetailsQuery" id="ROFDetailsQuery" action="../../eSS/jsp/ROFDetailsQueryResult.jsp" method="post" target="qryResultROFDetails">
			<table border="0" cellpadding="0" cellspacing="0" width='100%'>
				<tr>
					<td colspan='6'>&nbsp;</td>
				</tr>
				<tr>
					<td class=label ><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td class=label><input type="text" maxLength=10 size=10 name="from_date" id="from_date" value= "<%=from_date%>" onBlur="CheckDate(this);">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_date');"></img><%=bean.getImage("M")%></td>
					<td class=label ><fmt:message key="Common.todate.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td class=label ><input type="text" maxLength=10 size=10 name="to_date" id="to_date" value= "<%=to_date%>" onBlur="CheckDate(this);">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_date');"></img></td>
					<td class=label ><fmt:message key="Common.Store.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td class=label><select name="req_by_store" id="req_by_store" > <%=bean.getCurrentROFStores()%></select>&nbsp;</td>
					</select></td>
				</tr>
				  <tr>
					<td colspan='8'>&nbsp;</td>
				  </tr>
				<tr>
					<td class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td class="label"><select name="doc_type_code" id="doc_type_code"  <%=disabled%>><%=bean.getDocTypes()%></select></td>
					<td class=label  ><fmt:message key="eSS.DocRef.label" bundle="${ss_labels}"/>&nbsp;&nbsp;</td>
					<td class=label><input type="text" maxLength=15 size=15 name="doc_ref" id="doc_ref" value= "" >&nbsp;</td>
					<td class="label" ><fmt:message key="eSS.SterReqStatus.label" bundle="${ss_labels}"/>&nbsp;&nbsp;</td>
					<td><select name="rof_status" id="rof_status" >	<%=bean.getSterProcessStage()%>	</select></td>
									
				</tr>
				<tr>
				<td colspan='6'>&nbsp;
				</td>
				</tr>
				<tr>
				<td colspan='5'>&nbsp;
				</td>
				
					<td colspan='3' ><input type="button" value="Search" class="BUTTON" onClick="showTrayDtl();"></td>
				</tr>
				
				
			</table>
				<input type="hidden" name="orderbycolumns" id="orderbycolumns" value="c.short_desc,a.doc_no">
				<input type="hidden" name="p_language_id" id="p_language_id"			value="<%=locale%>">
				<input type="hidden" name="p_system_date" id="p_system_date"			value="<%=to_date%>">
		</form>
		
	</body>
	<%	putObjectInBean(bean_id,bean,request);%>
</html>

