<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*"  contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<jsp:useBean id="alReturnInstrumentsList" scope="session" class="java.util.ArrayList"/>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle					=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		String locale= (String)session.getAttribute("LOCALE");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/ReturnInstruments.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body onMouseDown="CodeArrest()">
<%
	ReturnInstrumentsListBean bean	=		(ReturnInstrumentsListBean)getBeanObject( "returnInstrumentsListBean", "eSS.ReturnInstrumentsListBean", request );	
	bean.clear();
	bean.setLanguageId(locale);
	String codeDisabled				=		"";
	String disabled					=		"";
	String disabled_mod             = "disabled";
	String index					=		bean.checkForNull(request.getParameter("index"),"-1");
	String strButtonLegend			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	String doc_type_code			=		request.getParameter("doc_type_code");
	String doc_no					=		request.getParameter("doc_no");
	String patient_id				=		request.getParameter("patient_id");
	String ret_store_code			=		request.getParameter("ret_store_code");
	String rec_store_code			=		request.getParameter("rec_store_code");
	String mode						=		index.equals("-1")? bean.getCommonRepositoryValue("MODE_INSERT"):bean.getCommonRepositoryValue("MODE_MODIFY");
	
	if(mode.equals(bean.getCommonRepositoryValue("MODE_MODIFY"))){
		bean.initialize((HashMap)alReturnInstrumentsList.get(Integer.parseInt(index)));
		strButtonLegend				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		codeDisabled				=		"disabled";	
		disabled_mod ="";
	}

	if(!((doc_no==null)||(doc_type_code==null))){
		disabled					=		bean.isEntryCompleted(doc_type_code,doc_no)?"disabled":disabled;
		patient_id					=		bean.checkForNull(bean.getPatient_id(doc_type_code,doc_no));
		ret_store_code				=		bean.checkForNull(bean.getRet_store_code(doc_type_code,doc_no));
        rec_store_code				=		bean.checkForNull(bean.getRec_store_code(doc_type_code,doc_no));
	}

	

%>
	<body>
		<form name="formReturnInstrumentsDetail" id="formReturnInstrumentsDetail" >
			<table border="0" cellpadding="2" cellspacing="0" width='100%' align='center' height='100%'>
				<tr>
					<td align="left" class="label"><fmt:message key="eSS.GroupTrayNoItem.label" bundle="${ss_labels}"/></td>
					<td colspan='3'>&nbsp;
						<%if(mode.equals(bean.getCommonRepositoryValue("MODE_INSERT"))){%>
							<select name="item_code" id="item_code" <%=codeDisabled%> <%=disabled%> onchange="assignValues(item_code);">
					<%
						  if(ret_store_code!=null&&(!ret_store_code.equals("")))
							out.println(bean.getItem_code_List(ret_store_code,rec_store_code,patient_id));
						  else
							out.println(bean.getSsRepositoryValue("DEFAULT_LIST_OPTION"));
						
						%>
						</select>
						<%}
						else {%>
					<input type='text' name="item_desc_1" id="item_desc_1" value="<%=bean.getItem_desc()%>" maxLength="40" style="visibility:visible" size="40" <%=codeDisabled%> <%=disabled%>>
					<input type='hidden' name="item_code_1" id="item_code_1" value="<%=bean.getItem_code()%>"
						<%}
						%><%=bean.getMandatoryImageTag()%>&nbsp<a a style = "CURSOR:DEFAULT" href='javascript:details();' <%=disabled_mod%>  id='details'><fmt:message key="Common.details.label" bundle="${common_labels}"/>&nbsp&nbsp</a></td>
					<td  class="label"><fmt:message key="eSS.Damaged.label" bundle="${ss_labels}"/></td>
					<td >&nbsp;<input type='checkbox' name="damaged_yn" id="damaged_yn" value="Y" <%=bean.getChecked(bean.getDamaged_yn())%> <%=disabled%>></td>
				</tr>
				<tr>
					<td  class="label" ><fmt:message key="eSS.ReturnQty.label" bundle="${ss_labels}"/></td>
					<td>&nbsp;&nbsp;<input type='text' name="ret_item_qty" id="ret_item_qty" class="NUMBER" maxLength="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" size="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);"  value="<%=bean.getRet_item_qty()%>" <%=disabled%>><%=bean.getMandatoryImageTag()%>
					</td>
					<td  class="label" ><fmt:message key="eSS.Cost.label" bundle="${ss_labels}"/></td>
					<td>&nbsp;&nbsp;<input type='text' name="ret_item_cost" id="ret_item_cost" class="NUMBER" maxLength="<%=bean.getCurrencySize()%>" size="<%=bean.getCurrencySize()%>" onKeyPress="return isValidNumber(this,event,<%=bean.getCurrencyFormat()%>);" value="<%=bean.getRet_item_cost()%>" <%=disabled%> disabled>
					</td>
					<td  class="label"><fmt:message key="eSS.Contaminated.label" bundle="${ss_labels}"/></td>
					<td >&nbsp;<input type='checkbox' name="contaminated_yn" id="contaminated_yn" value="Y" <%=bean.getChecked(bean.getContaminated_yn())%> <%=disabled%>></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td colspan='5'>&nbsp;&nbsp;<textarea style="resize:none" name="remarks" rows="3" cols="87" <%=disabled%> onKeyPress="return setTextAreaMaxLength(this,200);" onBlur="checkSetTextAreaMaxLength(this,200);"><%=bean.getRemarks()%></textarea></td>
				</tr>
				<tr>
					<td  class="label" colspan='6'>
						<input type='button' class='BUTTON' name="apply" id="apply" onClick="addToList();" value="<%=strButtonLegend%>" <%=disabled%>>
						<input type='button' class='BUTTON' name="cancel" id="cancel" onClick="resetReturnInstrumentsDetail();" value="Cancel" <%=disabled%>>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;					
					</td>
				</tr>
			</table>
			<input type='hidden' name="index" id="index" value="<%=index%>">
			<input type='hidden' name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">
			<input type='hidden' name="function_id" id="function_id" value="<%=request.getParameter("function_id")%>">
			<input type="hidden" name="SQL_SS_ITEM_LOOKUP" id="SQL_SS_ITEM_LOOKUP" value="<%=bean.getSsRepositoryValue("SQL_SS_ITEM_LOOKUP_FOR_RTI")%>">
		</form>
	</body>
<%
	putObjectInBean("returnInstrumentsListBean",bean,request);
%>

</html>

