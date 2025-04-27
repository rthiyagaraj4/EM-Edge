<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="eOR.* ,eOR.Common.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../js/OrCommonFunction.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
	<script language="JavaScript" src="../js/SpecimenLblGeneration.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onload='FocusFirstElement()' onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<form name='specimenLblGeneration_add_mod' id='specimenLblGeneration_add_mod' target='messageFrame' >
<%
//	String readOnly = "" ;
//	String checked = "checked" ;
	/* Mandatory checks start */
	
	String mode	   = request.getParameter( "mode" ) ;
//	String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_SpecimenLblGeneration" ;
	String bean_name = "eOR.SpecimenLblGenerationBean";
//	String disabled = "" ;


//	String contr_sys_id				=   "";
	String ordering_facility_id		=	"";

	String source_type				=	"";
	String source_type_desc			=	"";

	String source_code				=	"";
	String source_desc				=	"";

	String specimen_type			=   "";
	String nurse_collect_yn			=	"";
	String urgency_indicator		=	"";
	String label_gen_on_order_yn	=	"";
 //   String look_ahead_min			=	"";
	String facility_name			=	"";

	String valUrgency[]  ={"*","R","S","U"} ;
	String descUrgency[]={com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels")} ;

	String valNurse[]  ={"*","Y","N"} ;
	String descNurse[]={com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")} ;


/* Initialize Function specific start */
SpecimenLblGenerationBean bean1 = (SpecimenLblGenerationBean)getBeanObject( bean_id,  bean_name, request ) ;
bean1.setLanguageId(localeName);
//HttpSession ss = request.getSession(false);
//bean1.setProperties( (Properties) ss.getValue( "jdbc" ) ) ;
bean1.setFunctionId(bean1.checkForNull(request.getParameter("function_id")));


	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ))
		return ;


	bean1.clear() ;
	bean1.setMode( mode ) ;

/* Initialize Function specific end */

	if ( mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ) {
		source_type			=request.getParameter( "source_type" ) ;
		//source_code			=request.getParameter( "source_code" ) ;
		source_code=       request.getParameter( "source_code" );
		facility_name		=request.getParameter( "facility_name" ) ;
		specimen_type		=request.getParameter( "specimen_type" ) ;
		ordering_facility_id=request.getParameter( "ordering_facility_id" ) ;

		source_type_desc    =request.getParameter( "source_type_desc" ) ;
		source_desc			=request.getParameter( "source_desc" ) ;

		bean1.load(ordering_facility_id,source_type,source_code,specimen_type);
		urgency_indicator		=bean1.getUrgency_indicator();
		label_gen_on_order_yn	=bean1.getLabel_gen_on_order_yn();
		//look_ahead_min			=String.valueOf(bean1.getLook_ahead_min());
		nurse_collect_yn		=bean1.getNurse_collect_yn();

	}
if(source_code.trim().equals(""))
	source_code="ALL";

%>
<table align='center' cellpadding=3 cellspacing=0 border=0 width='100%'>
<tr>
	<td class="label" width="40%"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
	<td class='fields'><% if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ))) {%><input type=text name='ordering_facility_id_desc' id='ordering_facility_id_desc' value="<%=facility_name%>" readonly><INPUT TYPE="hidden" name='ordering_facility_id' id='ordering_facility_id' value="<%=ordering_facility_id.trim()%>"><img  align='center' src="../../eCommon/images/mandatory.gif"></img>
	<%}else{%><select name="ordering_facility_id" id="ordering_facility_id" onchange='parent.resetSourceType()'>
		<option value=''> --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
		</option><%=bean1.getComboOptions("facility")%>
		</select<img align='center'  src="../../eCommon/images/mandatory.gif"></img>
		<%}%>
	</td>
</tr>

<tr>
	<td class="label" width="40%"><fmt:message key="eOR.ContraSysModule.label" bundle="${or_labels}"/></td>
	<td class='fields'><input type=text name='contr_sys_id' id='contr_sys_id' value="OR" readonly><img align='center'   src="../../eCommon/images/mandatory.gif"></img>
	</td>
</tr>

<tr>
	<td class="label" width="40%"><fmt:message key="Common.SourceType.label" bundle="${common_labels}"/></td>
	<td class='fields'><% if ( mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY" ))) {%><input type=text name='source_type_desc' id='source_type_desc' value="<%=source_type_desc%>" readonly><INPUT TYPE="hidden" name='source_type' id='source_type' value="<%=source_type.trim()%>"><img align="center" src="../../eCommon/images/mandatory.gif"></img>
	<%}else{%>
		<!-- <select name="source_type" id="source_type" onChange='parent.fillComboOptions(this)'> -->
		<select name="source_type" id="source_type"  onChange='parent.resetSource(this)'>
		<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
		<!--<option value='D'>Department</option>-->
		<option value='C'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
		<option value='N'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
		<option value='R'><fmt:message key="Common.referral.label" bundle="${common_labels}"/></option>
		</select><img align='center'  src="../../eCommon/images/mandatory.gif" align=center></img>
	<%}%>
	</td>
</tr>

<tr>
	<td class="label" width="40%"><fmt:message key="Common.source.label" bundle="${common_labels}"/></td>
	<td id='source_td' class='fields'>
	<INPUT TYPE="hidden" name='source_code' id='source_code' value="<%=source_code.trim()%>">
	<% if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) {%><input type=text name='source_desc' id='source_desc' value="<%=source_desc%>" readonly><img src='../../eCommon/images/mandatory.gif'>
	<%}else{%>
	<input type='text' name='source_desc' id='source_desc' value='' onBlur='before_showSourceWindow(this,source_code);'><input type='button' class='button' name='sourceSearch' id='sourceSearch' value='?' onClick='showSourceWindow(source_desc,source_code);'><img src='../../eCommon/images/mandatory.gif' align=center><input type='hidden' name='source_desc_temp' id='source_desc_temp' value=''>
	<input type='hidden' name='clinicSql' id='clinicSql' value="<%=OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_COLLECTION_SOURCE_CODE_CLINIC_LOOKUP")%>">
	<input type='hidden' name='nursingUnitSql' id='nursingUnitSql' value="<%=OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_COLLECTION_SOURCE_CODE_NURSING_LOOKUP")%>">
	<input type='hidden' name='referralSql' id='referralSql' value="<%=OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_COLLECTION_SOURCE_CODE_REFERRAL")%>">
	<%}%>
	</td>
</tr>




<TR>
	<TD class="label" width="40%"><fmt:message key="Common.SpecimenType.label" bundle="${common_labels}"/></TD>
	<TD class='fields'> 
		<Select name="specimen_type" id="specimen_type" <%if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) {out.println("disabled");}%>>
			<Option value='ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/></Option>
			<%=bean1.getComboOptions("specimen",specimen_type)%>
		</Select>
	</TD>
</TR>


<tr>
	<td class="label" width="40%"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
	<td class='fields'><% if ( mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) {%><input type=text name='urgency_indicator_desc' id='urgency_indicator_desc' value="<%=eHISFormatter.chkReturn(valUrgency,urgency_indicator,descUrgency,"")%>" readonly><INPUT TYPE="hidden" name='urgency_indicator' id='urgency_indicator' value="<%=urgency_indicator.trim()%>">
	<%}else{%><select name="urgency_indicator" id="urgency_indicator" >
	<option value='*'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	<option value='R'><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
	<option value='S'><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></option>
	<option value='U'><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
	</select>
	<%}%>
	</td>
</tr>

<tr>
	<td class="label" width="40%"><fmt:message key="eOR.NurseCollect.label" bundle="${or_labels}"/></td>
	<td class='fields'><% if ( mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) {%><input type=text name='nurse_collect_yn_desc' id='nurse_collect_yn_desc' value="<%=eHISFormatter.chkReturn(valNurse,nurse_collect_yn,descNurse,"")%>" readonly><INPUT TYPE="hidden" name='nurse_collect_yn' id='nurse_collect_yn' value="<%=nurse_collect_yn.trim()%>">
	<%}else{%><select name="nurse_collect_yn" id="nurse_collect_yn" >
	<option value='*'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
	<option value='N'><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
	</select>
	<%}%>
	</td>
</tr>

<tr>
	<td class="label" width="40%"><fmt:message key="eOR.GenerateLabel.label" bundle="${or_labels}"/></td>
	<td class='fields'>
	<input type='checkbox' name='label_gen_on_order_yn' id='label_gen_on_order_yn' value='Y' onclick="parent.enableGeneration()" <%=eHISFormatter.ChkBoxChecked("y",label_gen_on_order_yn)%>>
	</td>
</tr>

<tr>
	<td class="label" width="40%"><fmt:message key="eOR.GenerationLookAhead.label" bundle="${or_labels}"/></td>
<td class='fields'><input type='textbox' name='look_ahead_min' id='look_ahead_min' onKeyPress='return allowValidNumber(this,event,4,0);' onblur='' value='<%=eHISFormatter.chkReturn(String.valueOf(bean1.getLook_ahead_min()),"0","",
String.valueOf(bean1.getLook_ahead_min()))%>' maxlength='5' <%=eHISFormatter.chkReturn("Y",label_gen_on_order_yn,"","readOnly")%>>(<fmt:message key="Common.Minutes.label" bundle="${common_labels}"/>)
	</td>
</tr>

</table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean1.getFunctionId()%>">
	<input type="hidden" name="language" id="language" value="<%=localeName%>">
</form>
</body>
</html>
<%
		putObjectInBean(bean_id,bean1,request);
 
%>

