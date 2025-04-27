<!DOCTYPE html>

 <jsp:useBean id="alTrayDiscrepancyList" scope="session" class="java.util.ArrayList"/>
 <%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="eSS.InstrUsageDiscrepancyUnitsDetailBean" %>

<html>
	<head>
 <%
			request.setCharacterEncoding("UTF-8");
			String locale				=		(String)session.getAttribute("LOCALE");
			String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	    <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/InstrUsageDiscrepancyUnits.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id								=		"instrUsageDiscrepancyUnitsDetailBean";
		String bean_name							=		"eSS.InstrUsageDiscrepancyUnitsDetailBean";

		InstrUsageDiscrepancyUnitsDetailBean bean   =		(InstrUsageDiscrepancyUnitsDetailBean) getBeanObject( bean_id,   bean_name,request); 
		bean.setLoginFacilityId((String)session.getAttribute("facility_id"));

		bean.setLanguageId(locale);
		String disabled								=		"";
		String codeDisabled							=		"";
		String group_code							=		request.getParameter("group_code");
		String index								=		bean.checkForNull(request.getParameter("index"),"-1");
		String strButtonLegend						=		 com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
		String patient_name							=		request.getParameter("patient_name");
		String function_id							=		request.getParameter("function_id");
		String encounter_id							=		bean.checkForNull(request.getParameter("encounter_id"),"");
		String mode									=		index.equals("-1")?	bean.getCommonRepositoryValue("MODE_INSERT"):bean.getCommonRepositoryValue("MODE_MODIFY");

		
		if(mode.equals(bean.getCommonRepositoryValue("MODE_INSERT"))){
		patient_name								=		bean.getPatient_name();
		if(patient_name==null || patient_name.equals("null")){patient_name="";}

		}
		if(mode.equals(bean.getCommonRepositoryValue("MODE_MODIFY"))){
		bean.initialize((HashMap)alTrayDiscrepancyList.get(Integer.parseInt(index)));
		strButtonLegend								=		 com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		codeDisabled								=		"disabled";
		patient_name								=		request.getParameter("patient_name");
		if(patient_name==null || patient_name.equals("null")){patient_name="";}
		
				
		
		}
		
	
		%>
	

	<body onMouseDown="CodeArrest();" >
	
		<form name="formInstrUsageDiscrepancyUnitsDetail" id="formInstrUsageDiscrepancyUnitsDetail" >
			<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' height='100%' align='center' valign='top'>
				<table border="0" cellpadding="0" cellspacing="2" width='100%' align='center'>
					<tr>
						<td>&nbsp</td><td>&nbsp;</td>
					</tr>
					<tr>
						<td  class="label"><fmt:message key="eSS.Instrument.label" bundle="${ss_labels}"/></td>
						<td class="label">&nbsp;&nbsp;<select name="item_code" id="item_code"  <%=disabled%>><%=codeDisabled%><!--modified for KDAH-SCF-0329-->
						<%if(group_code==null){%>
						<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<%}else{%>
						<%=bean.getItem_code_List(group_code)%>
						<%}%>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td>
					</tr>
					<tr>
						<td  class="label"><fmt:message key="eSS.DiscrepancyReason.label" bundle="${ss_labels}"/></td><td class="label">&nbsp;&nbsp;
						<select name="write_off_reason_code" id="write_off_reason_code"<%=codeDisabled%> >
						<%=bean.getWrite_off_reason_code_List()%>
						</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td><td class="label" >&nbsp;&nbsp;<textarea style="overflow-y: scroll; resize: none;" name="remarks" rows="3" cols="20" onKeyPress="return setTextAreaMaxLength(this,200);" onBlur="checkSetTextAreaMaxLength(this,200);" ><%=bean.checkForNull(bean.getRemarks(),"")%></textarea></td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="eSS.DiscrepancyQuantity.label" bundle="${ss_labels}"/></td><td class="label" >&nbsp;&nbsp;<input type="text" name="discrepancy_qty" id="discrepancy_qty" size="15" maxlength = "15" value ="<%=bean.getDiscrepancy_qty()%>" class="NUMBER" onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);"<%=codeDisabled%>><!--modified for KDAH-SCF-0329-->
						<select name="discrepancy_type" id="discrepancy_type" <%=codeDisabled%>><!--modified for KDAH-SCF-0329-->
					
						
					<%=bean.getDiscrepancy_type_List()%>
			
					</select><img src="../../eCommon/images/mandatory.gif" align=center></td>
					</tr>
					
					<tr>
					<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="patient_id" id="patient_id" value="<%=bean.checkForNull(bean.getPatient_id(),"")%>" maxLength='20' size='20' <%=codeDisabled%>><input type='button' class='BUTTON' value='?' onClick="searchPatient();" name="patient_search" id="patient_search"></td>
					
				</tr>
					<tr>
						<td  class="label"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td><td class="label">&nbsp;&nbsp;<input type="text" value="<%=bean.checkForNull(bean.getPatient_name(),"")%>" name="patient_name" maxLength="20" size="20" <%=codeDisabled%> disabled readonly></td>
						
					</tr>
					<tr>
					  
						<td class="label"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td><td class="label">&nbsp;&nbsp;<select name="encounter_id" id="encounter_id"  >
						<%if(group_code==null){%>
						<option><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
						<%}else{%>
						<%=bean.getEncounter_id_List(encounter_id)%>
						<%}%>
						</select>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td><td>&nbsp;</td>
					</tr>
					<tr>
						<td class="label" colspan='2'>
							<input type="button" value="<%=strButtonLegend%>" name="apply" class="BUTTON" onClick="return addToList();" <%=codeDisabled%>><!--modified for KDAH-SCF-0329-->
							<input type="button" value="Cancel" name="cancel" id="cancel" class="BUTTON" onClick=" resetInstrUsageDiscrepancyDetail();">
						</td>
					</tr>
				</table>
			</td>
			</tr>
			</table>
			<input type='hidden' name="index" id="index"								value="<%=index%>">
			<input type='hidden' name="mode" id="mode"								value="<%=mode%>">
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE" id="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE"   value="<%= bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE")%>">
			<input type="hidden" name="bean_id" id="bean_id"								value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"							value="<%=bean_name %>">
			<input type="hidden" name="function_id" id="function_id"							value="<%=function_id%>">

		</form>
	</body>
</html>
<%
	putObjectInBean( bean_id,bean,request);
%>

