<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@ page import ="eSS.*, eSS.Common.* , eCommon.Common.*,java.util.Properties,java.util.ArrayList,java.util.Hashtable,webbeans.eCommon.*,java.util.*"%>
<%@page contentType="text/html;charset=UTF-8" import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" %>

<jsp:useBean id="aaa"  class="eSS.PrepareGroupBean"/>  
<html>
<head>
<%
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="javascript" src="../../eSS/js/SsTransaction.js"></script>
	<script language="javascript" src="../../eSS/js/PrepareGroup.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String mode			=		request.getParameter("mode");
	if ((mode == null) || (mode.equals(""))) 
		return;
	if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;
	mode									=		mode.trim();
	java.util.HashMap defaultParameter		=		null;
	String bean_id							=		"prepareGroupBean";
	String bean_name						=		"eSS.PrepareGroupBean";
	String doc_type_code					=		request.getParameter("doc_type_code");
	
	PrepareGroupBean bean					=		(PrepareGroupBean) getBeanObject( bean_id, bean_name,request  );  
	bean.clear();

	String doc_no							=		bean.checkForNull(request.getParameter("doc_no"),"");
	
	bean.setMode(mode.trim());
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setDoc_date(bean.getSystemDate());
	String disabled							=		"";
	String disabled_mod							=		"disabled";
	String readonly							=		"";
	String acc_entity_id					=		(String) session.getValue("ACC_ENTITY_ID");
	bean.setAcc_entity_id(acc_entity_id);
	boolean editMode						=		false;	

	

	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		bean.setDoc_type_code (doc_type_code.trim());
		bean.setDoc_no (doc_no.trim());
		bean.setDefaultDocType(doc_type_code.trim());
		bean.loadData() ;
		bean.setDefaultStoreCode(bean.getStore_code());

		editMode							=		true;	
		readonly							=		"readonly";
		disabled							=		"disabled";
		disabled_mod = "";
	}
	else {
		defaultParameter					=		bean.getSSParameter();
		String default_doc_type_code		=		(String)defaultParameter.get("DEF_PRE_DOC_TYPE_CODE");
		String default_store_code			=		(String)defaultParameter.get("DEF_STORE_CODE_FOR_PRE");
		bean.setDefaultDocType(default_doc_type_code);
		bean.setDefaultStoreCode(default_store_code);
	}
	bean.setLanguageId(locale);
%>
<body onMouseDown="CodeArrest();"  onload='validateStoreCode(document.formPrepareGroup.store_code,"<%=bean.getBin_location_code()%>");' >
	<form name="formPrepareGroup" id="formPrepareGroup" onReset="FocusFirstElement();">
			<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellspacing=0 cellpadding=1 width="75%" align=center border=0>
				  <tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td></tr>
				  <tr>
					<td class=label ><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class=label>&nbsp;<select name="doc_type_code" id="doc_type_code" onBlur="validateDocNo(this);" <%=editMode?disabled:""%>><%=bean.getDocTypes()%></select>&nbsp;<IMG src="../../eCommon/images/mandatory.gif" align=center></td>
					  <!-- On Selection of Doc Type, Check needs to be made  for Document No Enable/Disable -->
					<td class=label ><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;<input CLASS="NUMBER" maxLength=8 size=8 name="doc_no" id="doc_no" onKeyPress="return isValidInteger();"  disabled value="<%=bean.getDoc_no()%>" onBlur="return checkIntegerFormat(this);">&nbsp;<IMG src="../../eCommon/images/mandatory.gif" align=center ></td>
					</tr>
				  <tr>
					<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
				  </tr>
				  <tr>
					<td class=label ><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
					
					<td class=label>&nbsp;<input type="text" maxLength=10 size=10 name="doc_date" id="doc_date" value="<%=com.ehis.util.DateUtils.convertDate(bean.getDoc_date(),"DMY","en",locale)%>"  onBlur="CheckDate(this,'<%=locale%>');" >&nbsp;<input type='image' src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');"><IMG src="../../eCommon/images/mandatory.gif" align=center></td>
					<td class=label ><fmt:message key="eSS.DocRef.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;<input maxLength=15 size=15 name="doc_ref" id="doc_ref" value="<%=bean.checkForNull(bean.getDoc_ref())%>"> </td></TR>
				  <tr>
					<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
				 </tr>
				  <tr>
					<td class=label ><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<td class=label>&nbsp;<select name="store_code" id="store_code" onChange="validateStoreCode(this);" <%=editMode?disabled:""%>> <%=bean.getStores()%> </select>&nbsp;<IMG src="../../eCommon/images/mandatory.gif" align=center></td>
					<td class=label ><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
					<td class=label>&nbsp;<input maxLength=15 size=15 name="group_desc" id="group_desc" value="<%=bean.getGroup_desc()%>" <%=readonly%>><input class="button" onClick="return searchCode(group_code,group_desc);" type="button" value="?">&nbsp;<IMG src="../../eCommon/images/mandatory.gif" align=center><a style = "CURSOR:DEFAULT" href='javascript:details();'  <%=disabled_mod%> id='details'><fmt:message key="Common.details.label" bundle="${common_labels}"/>&nbsp&nbsp</a></td>
					
				  </tr>
				  <tr>
					<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
				  </tr>
				  <tr>
					<td class=label ><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
					<td class=label>&nbsp;<input name="prepare_qty" id="prepare_qty" onkeypress="return isValidNumber(this,event,<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>,0);" class="NUMBER" maxLength="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" size="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" value="<%=bean.getPrepare_qty()%>" onFocus = "return validateGroupCode();" onBlur="calculateTotalCost();">&nbsp;<IMG src="../../eCommon/images/mandatory.gif" align=center></td>
					<td class=label ><fmt:message key="eSS.TotalValue.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;<input class="NUMBER" maxLength=15 size=15 name="total_cost" id="total_cost" readOnly value="<%=bean.getTotal_cost()%>"></td>
					</tr>
				  <tr>
					<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
				  <tr>
					<td class=label ><fmt:message key="eSS.BinLocation.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;<select name="bin_location_code" id="bin_location_code"><%=bean.getSsRepositoryValue("DEFAULT_LIST_OPTION")%>
					</select></td>
					<td class=label ></td>                     
					<td class=label>&nbsp;&nbsp;</td></tr>
				  <tr>
					<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
					</tR>
				</table>
			</td>
			</tr>
			</table>	
			<input type='hidden' name="facility_id" id="facility_id"						value="<%=bean.getLoginFacilityId() %>">
			<input type='hidden' name="finalize_yn" id="finalize_yn"						value="No">
			<input type='hidden' name="autono_yn" id="autono_yn"						value="No">
			<input type='hidden' name="trn_type" id="trn_type"						value="PRE">
			<input type='hidden' name="store_desc" id="store_desc"						value="">
			<input type='hidden' name="group_code" id="group_code"						value="<%=bean.getGroup_code()%>">
			<input type='hidden' name="mode" id="mode"							value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"							value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"						value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id"						value="<%=bean.getFunctionId()%>">
			<input type="hidden" name="locale" id="locale"							value="<%=locale%>">
			<input type="hidden" name="SQL_SS_PREPARE_GROUP_LOOKUP" id="SQL_SS_PREPARE_GROUP_LOOKUP"		value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_PREPARE_GROUP_LOOKUP")%>">
<%
	try{
			ArrayList alParameters = new ArrayList();
			alParameters.add(request.getParameter("module_id"));
			alParameters.add(request.getParameter("function_id"));
			alParameters.add(session.getAttribute("responsibility_id"));
			ArrayList alRequestGroupRecords=bean.fetchRecords(bean.getSsRepositoryValue("SQL_SM_MENU_TRANS_SUB_FUNCTION_SELECT"),alParameters);
			for (int i=0;i<alRequestGroupRecords.size();i++){
				HashMap hmRequestGroupSubFunc=(HashMap)alRequestGroupRecords.get(i);
	
%>
			<input type="hidden" name='<%=(String)hmRequestGroupSubFunc.get("SUBFUNCTION_ID")%>' id='<%=(String)hmRequestGroupSubFunc.get("SUBFUNCTION_ID")%>' value="<%=(String)hmRequestGroupSubFunc.get("INCL_YN")%>">	
<%
			}
		}
		catch (Exception exception) {
			// out.println(exception);
			exception.printStackTrace();
		}
%>
		<script>
		   
		   document.forms[0].doc_date.focus();
				
		</script>

		</form>
<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

