<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="eOR.* ,eOR.Common.*,eCommon.XSSRequestWrapper"%>
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
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/SpecimenCollection.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

</head>
<body onload='FocusFirstElement()' onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<form name='specimenCollection_add_mod' id='specimenCollection_add_mod' target='messageFrame' >
<%

try{

//	String readOnly = "" ;
//	String checked = "checked" ;
	/* Mandatory checks start */
	

	
	String mode	   = request.getParameter( "mode" ) ;
//	String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_specimenCollectionBean" ;
	String bean_name = "eOR.SpecimenCollectionBean";
//	String disabled = "" ;

	String ordering_facility_id				=	"";
	String facility_name					=	"";
	String source_type						=	"";
	String source_code						=	"";
	String urgency_indicator				=	"";
	String nurse_collect_yn_dflt			=	"";
	String source_desc						=	"";

	String valSource[]  ={"C","N","R"} ;//{"C","D","N"} ;
	String descsource[]={"Clinic","Nursing Unit","Referral"} ;//{"Clinic","Department","Nursing Unit"} ;

	String valUrgency[]  ={"*","R","S","U"} ;
	String descUrgency[]={"All","Routine","Stat","Urgent"} ;
		/* Initialize Function specific start */
	SpecimenCollectionBean bean = (SpecimenCollectionBean)getBeanObject(bean_id, bean_name, request) ;  

	
	HttpSession ss = request.getSession(false);
	bean.setProperties( (Properties) ss.getValue( "jdbc" ) ) ;


	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) || mode.equals(CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) )
		return ;

  /* Mandatory checks end */	

	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setLanguageId(localeName);
/* Initialize Function specific end */

	if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) {
		source_type			=request.getParameter( "source_type" ) ;
		source_code			=request.getParameter( "source_code" ) ;
		ordering_facility_id=request.getParameter( "ordering_facility_id" );
		source_desc			=request.getParameter( "source_desc" ) ;
		urgency_indicator	=request.getParameter( "urgency" ) ;


		ordering_facility_id = ordering_facility_id.trim();
		bean.load(ordering_facility_id.trim(),source_type.trim(),source_code.trim(),urgency_indicator.trim());

//		out.println("************* "+bean.tempChk);
//		out.println("************* "+bean.getFacility_name());
		facility_name = bean.getFacility_name();
		//urgency_indicator = bean.getUrgency_indicator();
		nurse_collect_yn_dflt = bean.getNurse_collect_yn_dflt();
		//out.println("=====source_type=>"+source_type+"<=====<br>source_code==>"+source_code+"<======ordering_facility_id=>"+ordering_facility_id+"<=====source_desc==>"+source_desc+"<=======facility_name=>"+facility_name+"<==============<BR>======urgency_indicator=>"+urgency_indicator+"<=====");
	  }
if(source_code.trim().equals(""))
	source_code="A";

  %>	
  <table align='center' cellpadding=3 cellspacing=0 border=0 width='100%'>
<tr>
	<td class="label" width="40%"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
	<td class='fields'><% if ( mode.equals(  CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) {%><input type=text name='facility_name' id='facility_name' value="<%=facility_name%>" readonly><img	   align='center' src="../../eCommon/images/mandatory.gif"></img><INPUT TYPE="hidden" name='ordering_facility_id' id='ordering_facility_id' value="<%=ordering_facility_id.trim()%>">
	<%}else{%><select name="ordering_facility_id" id="ordering_facility_id" onchange='parent.resetSourceType(this)'><option value=''> --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option><option value='*'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option><%=bean.getComboOptions()%></select><img align='center' src="../../eCommon/images/mandatory.gif"></img>
		<%}%>
	</td>
</tr>
<tr>
	<td colspan="2"></td>
</tr>
   <tr>
	<td class="label"><fmt:message key="Common.SourceType.label" bundle="${common_labels}"/></td>
		<td class='fields'><% if ( mode.equals(  CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) {%><input type=text name='source_type_desc' id='source_type_desc' value="<%=eHISFormatter.chkReturn(valSource,source_type,descsource,"&nbsp;")%>" readonly><img	   align='center' src="../../eCommon/images/mandatory.gif"></img><INPUT TYPE="hidden" name='source_type' id='source_type' value="<%=source_type.trim()%>"></img>
	<%}else{%><select name="source_type" id="source_type" onChange='parent.resetSource(this);'>
	<option value=''> --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
	<option value='C'> <fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
		<option value='N'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
			<option value='R'><fmt:message key="Common.referral.label" bundle="${common_labels}"/></option>
	</select><img src="../../eCommon/images/mandatory.gif" align=center></img>
	<%}%>
	</td>
</tr>

<tr>
	<td class="label" ><fmt:message key="Common.source.label" bundle="${common_labels}"/></td>
		<td id='source_td' class='fields'><INPUT TYPE="hidden" name='source_code' id='source_code' value="<%=source_code.trim()%>">
	<%if ( mode.equals(  CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) {%>
		<input type=text name='source_desc' id='source_desc' value="<%=source_desc%>" readonly><%}else{%><input type=text name='source_desc' id='source_desc' value='ALL' onBlur="before_showSourceWindow(this,source_code);"><input type='hidden' name='source_desc_temp' id='source_desc_temp' value='ALL'><input type="button" name="sourceSearch" id="sourceSearch" class="button" value='?' onClick="showSourceWindow(source_desc,source_code);" ><input type='hidden' name='clinicSql' id='clinicSql' value="<%=OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_COLLECTION_SOURCE_CODE_CLINIC_LOOKUP")%>">
		<input type='hidden' name='nursingUnitSql' id='nursingUnitSql' value="<%=OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_COLLECTION_SOURCE_CODE_NURSING_LOOKUP")%>">
		<input type='hidden' name='referralSql' id='referralSql' value="<%=OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_COLLECTION_SOURCE_CODE_REFERRAL")%>"><%}%><img  src="../../eCommon/images/mandatory.gif" align=center></img>
	</td>
</tr>

 <tr>
	<td class="label" width="40%"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
	<td class=fields><% if ( mode.equals(  CommonRepository.getCommonKeyValue( "MODE_MODIFY" ))) {%><input type=text name='urgency_indicator_desc' id='urgency_indicator_desc' value="<%=eHISFormatter.chkReturn(valUrgency,urgency_indicator,descUrgency,"")%>" readonly><img	   align='center' src="../../eCommon/images/mandatory.gif"></img><INPUT TYPE="hidden" name='urgency_indicator' id='urgency_indicator' value="<%=urgency_indicator.trim()%>">
	<%}else{%><select name="urgency_indicator" id="urgency_indicator" >
	<option value='*'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	<option value='R'><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
	<option value='S'><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></option>
	<option value='U'><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
	</select><img  src="../../eCommon/images/mandatory.gif" align=center></img>
	<%}%>
	</td>
</tr>
<tr>
	<td class="label" width="40%"><fmt:message key="eOR.NurseCollect.label" bundle="${or_labels}"/></td>
	<td class='fields'><input type='checkbox' name='nurse_collect_yn_dflt' id='nurse_collect_yn_dflt' value='Y' <%=eHISFormatter.ChkBoxChecked("y",nurse_collect_yn_dflt)%>>
	</td>
</tr>
	</table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
<%
		putObjectInBean(bean_id, bean, request) ; 

	}catch(Exception e){
		//out.println(e.getMessage());//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
		}%>
</form>	  
</body>
</html>


