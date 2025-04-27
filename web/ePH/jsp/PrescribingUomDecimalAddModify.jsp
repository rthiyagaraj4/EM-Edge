<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
	String locale = (String)session.getAttribute("LOCALE");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	String classValue="";
	String bean_id 			= "PrescribingUomDecimalBean" ;
	String bean_name 		= "ePH.PrescribingUomDecimalBean";
	String log_bean_id		= "SetupAuditLogBean" ;
	String log_bean_name		= "ePH.SetupAuditLogBean";
	String audit_log_visible	= "visibility:hidden";
	String table_id			= "PH_PRES_UOM_DECIMAL";
	String pkey_value		= "";
	PrescribingUomDecimalBean bean = (PrescribingUomDecimalBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.clear() ;
	bean.setLanguageId(locale);
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
	log_bean.setLanguageId(locale);
	int	totalRecords = Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE") );
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<Script language='JavaScript' src='../../eCommon/js/CommonLookup.js'></Script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../js/PrescribingUomDecimal.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown ='lockKey()' OnMouseDown='CodeArrest()'>
<form name="frmPrescribingUomDecimalAddModify" id="frmPrescribingUomDecimalAddModify">
<%
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))	{
%>
		<br><br><br><br><br><br>
		<table cellpadding=0 cellspacing=0 width="90%" align="center" border="1">
			<tr>
				<th width='20%'><fmt:message key="ePH.PrescribeUomCode.label" bundle="${ph_labels}"/></th>
				<th width='20%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
				<th width='10%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
				<th width='10%'><fmt:message key="ePH.DecimalValue.label" bundle="${ph_labels}"/></th>
				<th width='5%'><fmt:message key="ePH.FractionalValue.label" bundle="${ph_labels}"/></th>
				<th width='10%'><fmt:message key="ePH.FractionalDescription.label" bundle="${ph_labels}"/></th>
				<th width='10%'><fmt:message key="ePH.FractionalDescLocal.label" bundle="${ph_labels}"/></th>
				<th width='10%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
			</tr>
<%
			for(int index=0; index<totalRecords; index++){
				if ( index % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;
%>
				<tr>
					<td CLASS="<%=classValue%>" style='text-align:center;'><input type='Text' name='PrescribeUomCode_<%=index%>' id='PrescribeUomCode_<%=index%>' size='15' maxlength='4' onchange="searchUomCode('<%=index%>');">&nbsp;<input type="button" name="btnUomCodeSearch<%=index%>" id="btnUomCodeSearch<%=index%>" value="?" class="button"  onClick="searchUomCode('<%=index%>');"></td>
					<td CLASS="<%=classValue%>" style='text-align:center;'><input type='Text' name='LongDesc_<%=index%>' id='LongDesc_<%=index%>' size='25' maxlength='0'></td>
					<td CLASS="<%=classValue%>" style='text-align:center;'><input type='Text' name='ShortDesc_<%=index%>' id='ShortDesc_<%=index%>' size='15' maxlength='0'></td>
					<td CLASS="<%=classValue%>" style='text-align:center;'><input type='Text' name='DecimalValue_<%=index%>' id='DecimalValue_<%=index%>' size='15' maxlength='10' onPaste="return false;"  onKeyPress="return allowValidNumber(this,event,6,2);" onchange="isZero(this,'<%=index%>')" style='text-align:right;'></td>
					<td CLASS="<%=classValue%>" style='text-align:center;'><input type='Text' name='FractionalValue_<%=index%>' id='FractionalValue_<%=index%>' size='15' maxlength='10' onBlur="makeValidString(this)" style='text-align:right;'></td>
					<td CLASS="<%=classValue%>" style='text-align:center;'><input type='Text' name='FractionalDesc_<%=index%>' id='FractionalDesc_<%=index%>' size='25' maxlength='25' onBlur="makeValidString(this)"></td>
					<td CLASS="<%=classValue%>" style='text-align:center;'><input type='Text' name='FractionalDescLocal_<%=index%>' id='FractionalDescLocal_<%=index%>' size='25' maxlength='30' onBlur="makeValidString(this)"></td>
					<td CLASS="<%=classValue%>" style='text-align:center;'><input type='Checkbox' name='EffStatus<%=index%>' id='EffStatus<%=index%>' value='E' checked onclick='selectRec(this)'></td>
				</tr>
<%
			}
%>
		</table>
<%
	}
	else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
		String PrescribeUomCode = request.getParameter("PrescribeUomCode").trim();
		String DecimalValue = request.getParameter("DecimalValue").trim();
		String UomDesc="",FractionalValue="",FractionalDesc="",FractionalDescLocal="",EffStatus="";
		ArrayList record= bean.getDetailsForUpdate(PrescribeUomCode,DecimalValue,locale);
		if(record!=null && record.size()>0){
			PrescribeUomCode = (String)record.get(0);
			UomDesc = (String)record.get(1);		
			DecimalValue = 	(String)record.get(2);
			FractionalValue = (String)record.get(3);
			FractionalDesc = (String)record.get(4);
			FractionalDescLocal = (String)record.get(5);
			EffStatus=(String)record.get(6);
		}
		String checked="unchecked";
		String disabled="";
		if(EffStatus.equals("E")){
			checked ="checked";
		}
		else{
			disabled="disabled";
		}
		/*-------------------------code added for showing audit log---------------------------*/
		//code for adding primary_key_values
		ArrayList Pk_values    =new ArrayList();
		Pk_values.add(PrescribeUomCode);      
		Pk_values.add(DecimalValue);  
		String display_audit_log_button_yn = log_bean.ShowAuditLogYN(table_id,Pk_values);
		pkey_value   ="";
		if(display_audit_log_button_yn.equals("Y")){
			audit_log_visible= "visibility:visible";
			pkey_value       = (String)log_bean.getpk_value();
		}else{
			audit_log_visible= "visibility:hidden";
			log_bean.clear();
		}
  		/*--------------------------------------ends here---------------------------------------*/
		
%>
		<BR><BR><BR><BR><BR><BR><BR><BR>
		<table cellpadding=0 cellspacing=0 width="60%" align="center" border="0">
			<tr>
				<td width='40%' class='label'><fmt:message key="ePH.PrescribeUomCode.label" bundle="${ph_labels}"/></td>
				<td><input type='text' name='PrescribeUomCode' id='PrescribeUomCode' size='15' <%=disabled%> disabled value="<%=PrescribeUomCode%>"></td>
			</tr>
			<tr>
				<td width='40%' class='label'><fmt:message key="Common.uom.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${ph_labels}"/></td>
				<td><input type='text' name='ShortDesc' id='ShortDesc' size='25' <%=disabled%> disabled value='<%=UomDesc%>'></td>
			</tr>
			<tr>
				<td class='label'><fmt:message key="ePH.DecimalValue.label" bundle="${ph_labels}"/></td>
				<td><input type='text' size='15'name='DecimalValue' <%=disabled%> disabled style='text-align:right;' value="<%=DecimalValue%>"></td>
			</tr>
			<tr>
				<td class='label'><fmt:message key="ePH.FractionalValue.label" bundle="${ph_labels}"/></td>
				<td><input type='text' size='15'name='FractionalValue' <%=disabled%>  style='text-align:right;' maxlength='10' value="<%=FractionalValue%>" onBlur="makeValidString(this)"></td>
			</tr>
			<tr>
				<td class='label'><fmt:message key="ePH.FractionalDescription.label" bundle="${ph_labels}"/></td>
				<td><input type='text' size='30'name='FractionalDesc' <%=disabled%>  maxlength='25' value="<%=FractionalDesc%>" onBlur="makeValidString(this)"></td>
			</tr>
			<tr>
				<td class='label'><fmt:message key="ePH.FractionalDescLocal.label" bundle="${ph_labels}"/></td>
				<td><input type='text' size='30'name='FractionalDescLocal' <%=disabled%>  maxlength='30' value="<%=FractionalDescLocal%>" onBlur="makeValidString(this)"></td>
			</tr>
			<tr>
				<td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				<td><input type='CheckBox' name='EffStatus' id='EffStatus' onclick='selectRec(this)' <%=checked%> value='<%=EffStatus%>'></td>
			</tr>
		</table>
<%
	}
%>
<table cellpadding=0 cellspacing=0 width="20%" align="center" border="0" style="<%=audit_log_visible%>">
<td><INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'  onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')"/>&nbsp;</td></tr>
</table>
<input type="hidden" name="Language_id" id="Language_id" value="<%=locale%>">
<input type="hidden" name="mode" id="mode" value="<%= mode %>">
<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="totalRecords" id="totalRecords" value="<%= totalRecords %>">
</form>
<% 
putObjectInBean(bean_id,bean,request); 
%>
</body>
</html>

