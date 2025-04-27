<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="alTrayDiscrepancyList" scope="session" class="java.util.ArrayList"/>
<jsp:useBean id="a1" scope="page" class="eSS.TrayDiscrepancyBean"/> 
<jsp:useBean id="a2" scope="page" class="eSS.TrayDiscrepancyListBean"/>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
<%
		request.setCharacterEncoding("UTF-8");
		String locale=(String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/TrayDiscrepancy.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<%
	TrayDiscrepancyListBean bean	= (TrayDiscrepancyListBean)getBeanObject( "trayDiscrepancyListBean", "eSS.TrayDiscrepancyListBean", request  );  
	bean.clear();
	bean.setLanguageId(locale);
	bean.setLoginFacilityId((String)session.getAttribute("facility_id"));

	String disabled					=	"";
	String codeDisabled				=	"";
	String finalizedDisabled		=	"";
	String group_code				=	request.getParameter("group_code");
	String index					=	bean.checkForNull(request.getParameter("index"),"-1");
	String strButtonLegend			=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	String mode						=	index.equals("-1")? bean.getCommonRepositoryValue("MODE_INSERT"):bean.getCommonRepositoryValue("MODE_MODIFY");

	if(mode.equals(bean.getCommonRepositoryValue("MODE_MODIFY"))){
		bean.initialize((HashMap)alTrayDiscrepancyList.get(Integer.parseInt(index)));
		strButtonLegend				=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		codeDisabled				="disabled";

		if( (bean.getFinalized_yn().equals("Y")) && (bean.getMode().equals(bean.getCommonRepositoryValue("MODE_MODIFY"))))
			finalizedDisabled		="disabled";

		if( bean.getUsage_ind().equals("U") || bean.getUsage_ind().equals("R"))
			finalizedDisabled		=	"disabled";
	}

%>
	<body onMouseDown="CodeArrest();" >
		<form name="formTrayDiscrepancyDetail" id="formTrayDiscrepancyDetail" >
			<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' height='100%' align='center' valign='top'>
			<table border="0" cellpadding="3" cellspacing="0" width='100%' align='center'>
				<tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				</tr>
				<tr>
					<td  class="label" ><fmt:message key="eSS.Instrument.label" bundle="${ss_labels}"/></td>
					<td>&nbsp;<select name="item_code" id="item_code" <%=codeDisabled%>>
					<%if(group_code==null){%>
						<option value="">------------------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------------------------</option>
					<%}else{%>
						<%=bean.getItem_code_List(group_code)%>
					<%}%>
					</select><%=bean.getMandatoryImageTag()%></td>
				</tr>
				<tr>
					<td  class="label" nowrap><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
					<td>&nbsp;<select name="write_off_reason_code" id="write_off_reason_code" <%=codeDisabled%>>
					<%=bean.getWrite_off_reason_code_List()%>
					</select><%=bean.getMandatoryImageTag()%></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
					<td>&nbsp;<input type='text' name="discrepancy_qty" id="discrepancy_qty" value="<%=bean.getDiscrepancy_qty()%>" maxLength="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" size="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);populateCost(item_code.value,this.value)" class="NUMBER" <%=finalizedDisabled%>><select name="discrepancy_type" id="discrepancy_type" <%=finalizedDisabled%>>
					<%=bean.getDiscrepancy_type_List()%>
					</select><%=bean.getMandatoryImageTag()%></td>
				</tr>
				<tr>
					<td  class="label">Cost</td>
					<td>&nbsp;<input type='text' name="charge_amt" id="charge_amt" value="<%=bean.getCharge_amt()%>" maxLength="<%=bean.getCurrencySize()%>" size="<%=bean.getCurrencySize()%>" onKeyPress="return isValidNumber(this,<%=bean.getCurrencyFormat()%>);"  class="NUMBER" disabled></td>
				</tr>

				<tr>
					<td  class="label"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td>&nbsp;<textarea rows='3' cols='23' name="remarks" onKeyPress="return setTextAreaMaxLength(this,200);" onBlur=" checkSetTextAreaMaxLength(remarks,200);" <%=finalizedDisabled.equals("disabled")?"readOnly":""%>><%=bean.getRemarks()%></textarea></td>
				</tr>
				<tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				</tr>
				<tr>
					<td  class="label" colspan='2'>
						<input type='button' class='BUTTON' name="apply" id="apply" onClick="addToList();" value="<%=strButtonLegend%>" <%=disabled%> <%=finalizedDisabled%>>
						<input type='button' class='BUTTON' name="cancel" id="cancel" onClick="resetTrayDiscrepancyDetail();" value="Cancel" <%=disabled%>>					
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				</tr>
			</table>
			</td>
			</tr>
			</table>
			<input type='hidden' name="index" id="index" value="<%=index%>">
			<input type='hidden' name="facility_id" id="facility_id" value="<%=(String)session.getAttribute("facility_id")%>">
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE" id="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE" value="<%= bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE")%>">
		</form>
	<%	putObjectInBean("trayDiscrepancyListBean",bean,request);

%>
	</body>
</html>

