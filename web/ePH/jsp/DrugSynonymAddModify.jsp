<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.* ,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu 
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String mode= request.getParameter("mode");
		String classValue="";
		String bean_id = "DrugSynonymBean" ;
		String bean_name = "ePH.DrugSynonymBean";
		DrugSynonymBean bean = (DrugSynonymBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.clear() ;
		bean.setLanguageId(locale);
		bean.setMode( mode ) ;
		int	    totalRecords	=	0;	
		totalRecords	=	Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE") );	
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../js/DrugSynonym.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<BODY onKeyDown = 'lockKey()' > 
		<form name='frmDrugSynonymAddModify' id='frmDrugSynonymAddModify'>
<%
			if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))	{
					//flag = "I";

%>
				<BR><BR><BR><BR><BR><BR>
				<table cellpadding=0 cellspacing=0 width="60%" align="center" border="1">
					<tr>
						<th width='40%'><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
						<th width='40%'><fmt:message key="ePH.CommonName.label" bundle="${ph_labels}"/></th>
						<th width='20%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
					</tr>
<%
					for(int index=0; index<totalRecords; index++){
						if ( index % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;
%>
						<tr>
							<td CLASS="<%=classValue%>" style='text-align:center;'><input type='Text' name='DrugName_<%=index%>' id='DrugName_<%=index%>' value='' size='40'>&nbsp;<input type="button" name="btnDrugSearch<%=index%>" id="btnDrugSearch<%=index%>" value="?" class="button"  onClick="searchDrugName('<%=index%>');"></td>
							<td CLASS="<%=classValue%>" style='text-align:center;'><input type='Text' name='DrugSynonymDesc_<%=index%>' id='DrugSynonymDesc_<%=index%>' value='' size='50' maxlength='100' onchange='minLengthValidate(this);'></td>
							<td CLASS="<%=classValue%>" style='text-align:center;'><input type='Checkbox' name='EffStatus<%=index%>' id='EffStatus<%=index%>' value='' onclick='selectRec(this)'></td>
							<input type='hidden' name='DrugCode_<%=index%>' id='DrugCode_<%=index%>' value=''>
							<input type='hidden' name='DrugSynonymType_<%=index%>' id='DrugSynonymType_<%=index%>' value='OT'>
							<input type='hidden' name='SynonymTypeCode_<%=index%>' id='SynonymTypeCode_<%=index%>' value='' >
						</tr>
<%
					}
%>
				</table>
<%
			}
			else{
				String DrugName = request.getParameter("DrugName");
				String DrugCode = request.getParameter("DrugCode");
				String DrugSynonymDesc = request.getParameter("DrugSynonymDesc");
				String DrugSynonymType = request.getParameter("DrugSynonymType");
				String EffStatus = request.getParameter("EffStatus")==null?"":request.getParameter("EffStatus");
				String SrlNo = request.getParameter("SrlNo")==null?"":request.getParameter("SrlNo");
				String readonly="readonly", checked="";
				if(EffStatus.equals("E")){
					readonly="";
					checked ="Checked";
				}

%>
				<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
				<table cellpadding=0 cellspacing=0 width="60%" align="center" border="0">
					<tr>
						<td width='40%' class='label'><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
						<td><input type='text' name='DrugName' id='DrugName' size='60' readonly value='<%=DrugName%>'></td>
					</tr>
					<tr>
						<td class='label'><fmt:message key="ePH.CommonName.label" bundle="${ph_labels}"/></td>
						<td><input type='text' size='60'name='DrugSynonymDesc' value='<%=DrugSynonymDesc%>' <%=readonly%>> </td>
					</tr>
					<tr>
						<td width='20%' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
						<td>
							<input type='CheckBox' name='EffStatus' id='EffStatus' value='<%=EffStatus%>'  onclick='selectRec(this)' <%=checked%>>
						</td>
					</tr>
					<input type='hidden'name='DrugCode'  value='<%=DrugCode%>'>
					<input type='hidden'name='DrugSynonymType'  value='<%=DrugSynonymType%>'>
					<input type='hidden'name='SrlNo'  value='<%=SrlNo%>'>
				</table>
<%
			}
%>
			<input type="hidden" name="mode" id="mode" value="<%= mode %>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
			<input type="hidden" name="totalRecords" id="totalRecords" value="<%= totalRecords %>">
			<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
		</form>
	</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

