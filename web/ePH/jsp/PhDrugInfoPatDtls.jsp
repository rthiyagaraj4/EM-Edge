<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	 <link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	 <script language="JavaScript" src="../../ePH/js/PhDrugInfo.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	
</head>
<%
	String bean_id			= "PhDrugInfoEnqBean" ;
	String bean_name		= "ePH.PhDrugInfoEnqBean";

	PhDrugInfoEnqBean bean = (PhDrugInfoEnqBean)getBeanObject( bean_id,  bean_name ,request) ;
	bean.setLanguageId(locale);
	ArrayList EthnicGrp=bean.getEthnicGrp();
	
	ArrayList Enq_Dtl=null;
String Enq_num	= request.getParameter("Enq_num") ;
if(Enq_num==null) Enq_num="";
if(!Enq_num.equals("")){
		
		Enq_Dtl =bean.getEnquirerDetails();
		
	}
	
	
	String replied_by="";
	String sel1="", sel2="", sel3="",sel7="", sel5="", sel6="";
	String dis="";
	String PATIENT_ID="", PATIENT_NAME="", PATIENT_AGE="", PATIENT_AGE_UNIT="", PATIENT_GENDER="", PATIENT_ETHNIC_GRP="", ALLERGY_DRUG="", ALLERGY_FOOD="", ALLERGY_OTH="";

		if(Enq_Dtl!=null){
		
		if(Enq_Dtl.size() > 0){

			replied_by=(String)Enq_Dtl.get(39);
			if(replied_by==null) replied_by="";

			if(!replied_by.equals("")) dis="disabled";
			
			PATIENT_ID=(String)Enq_Dtl.get(27);
			PATIENT_NAME=(String)Enq_Dtl.get(28);
			PATIENT_AGE=(String)Enq_Dtl.get(29);
			PATIENT_AGE_UNIT=(String)Enq_Dtl.get(30);
			PATIENT_GENDER=(String)Enq_Dtl.get(31);
			PATIENT_ETHNIC_GRP=(String)Enq_Dtl.get(32);
			ALLERGY_DRUG=(String)Enq_Dtl.get(33);
			ALLERGY_FOOD=(String)Enq_Dtl.get(34);
			ALLERGY_OTH=(String)Enq_Dtl.get(35);
			if(PATIENT_ID ==null) PATIENT_ID="";
			if(PATIENT_NAME ==null) PATIENT_NAME="";
			if(PATIENT_AGE ==null) PATIENT_AGE="";
			if(PATIENT_AGE_UNIT ==null) PATIENT_AGE_UNIT="";
			if(PATIENT_GENDER ==null) PATIENT_GENDER="";
			if(PATIENT_ETHNIC_GRP ==null) PATIENT_ETHNIC_GRP="";
			if(ALLERGY_DRUG ==null) ALLERGY_DRUG="";
			if(ALLERGY_FOOD ==null) ALLERGY_FOOD="";
			if(ALLERGY_OTH ==null) ALLERGY_OTH="";
			if(PATIENT_AGE_UNIT.equals("D")) sel1="Selected";
			if(PATIENT_AGE_UNIT.equals("M")) sel2="Selected";
			if(PATIENT_AGE_UNIT.equals("Y")) sel3="Selected";

			if(PATIENT_GENDER.equals("M")) sel7="Selected";
			if(PATIENT_GENDER.equals("F")) sel5="Selected";
			if(PATIENT_GENDER.equals("U")) sel6="Selected";
		}
		}
%>
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name='PhDrugInfoPatForm' id='PhDrugInfoPatForm'>

<TABLE cellpadding=0 cellspacing=0 width="100%"  align="center" border="0" >
	<TH align='left' colspan='6' height='15'><b><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></b></TH>

			<TR >
					<TD class="label" width="15%" colspan='1'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;&nbsp;</TD>
					<TD align="left" colspan="1" width="35%"> <INPUT type="text" name="patient_id" id="patient_id"  value="<%=PATIENT_ID%>" size="20" <%=dis%> maxlength="<%=bean.getPatientIDLength()%>" readonly ><input type="button" value="?" class="button" name="patient_search" id="patient_search" <%=dis%> onclick="callPatientSearch()"></TD>
					<TD class="label" width="15%" colspan='1' nowrap>&nbsp;&nbsp;<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>&nbsp;&nbsp;</TD>
					<TD align="left" colspan="3" width="35%"> <INPUT type="text" name="patient_name" id="patient_name"  value="<%=PATIENT_NAME%>" <%=dis%> onKeyPress="changeToUpper()" size="55" maxlength="60" ></TD>
			</TR>
			<TR >
					<TD class="label" width="15%" colspan='1'>&nbsp;&nbsp;<fmt:message key="Common.age.label" bundle="${common_labels}"/>&nbsp;&nbsp;</TD>
					<TD align="left" class="label" width="20%" colspan='1'><INPUT type="text" name="age" id="age"  value="<%=PATIENT_AGE%>" size="8" maxlength="3" onKeyPress="return ChkNumberInput(this,event,0)" onblur="CheckZero(this)" <%=dis%>><select name='age_unit' id='age_unit' <%=dis%>><option value='D' <%=sel1%>>&nbsp;<fmt:message key="Common.Day(s).label" bundle="${common_labels}"/> &nbsp;</option><!-- <option value='W'>&nbsp;Week(s)&nbsp;</option> --><option value='M' <%=sel2%>>&nbsp;<fmt:message key="Common.month.label" bundle="${common_labels}"/>&nbsp;</option><option value='Y' <%=sel3%>>&nbsp;<fmt:message key="Common.year.label" bundle="${common_labels}"/>&nbsp;</option></select></TD>
					<TD class="label" width="15%" colspan='1'>&nbsp;&nbsp;<fmt:message key="Common.gender.label" bundle="${common_labels}"/> &nbsp;&nbsp;</TD>
					<TD align="left" colspan="1" width="20%"><select name='gender' id='gender' <%=dis%>><option value='M' <%=sel7%>><fmt:message key="Common.male.label" bundle="${common_labels}"/>&nbsp;</option><option value='F' <%=sel5%> ><fmt:message key="Common.female.label" bundle="${common_labels}"/>&nbsp;</option><option value='U' <%=sel6%>><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>&nbsp;</option></select></TD>
				
					<TD class="label" width="15%" colspan='1' nowrap>&nbsp;&nbsp;<fmt:message key="Common.EthnicGroup.label" bundle="${common_labels}"/>&nbsp;&nbsp;</TD>
					<TD align="left" colspan="1" width="20%"><select name='ethnic_grp' id='ethnic_grp' <%=dis%>><option value="">&nbsp;&nbsp;---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----&nbsp;&nbsp;</option>
					<%
				String sel4="";
				for (int i=0; i<EthnicGrp.size(); i += 2) {
				String EthnicCode = (String)EthnicGrp.get(i);
				if(EthnicCode.equals(PATIENT_ETHNIC_GRP))
					sel4="Selected";
				else
					sel4="";
				%>
				<OPTION  VALUE="<%= EthnicCode %>" <%=sel4%>><%= EthnicGrp.get(i+1) %></OPTION>
				<%	}
					%>
					</select></TD>
			</TR>
			<TR>
					<TD class='label' colspan='6'>&nbsp;&nbsp;&nbsp;</TD>
			</TR>
			<TR id='clinical_cond' style='display:none'>
					<TH align='left' colspan='6' height='15'><b><fmt:message key="ePH.ClinicalConditions.label" bundle="${ph_labels}"/></b></TH>
		 </TR>
			
			<TR id='diagnosis' style="display:none">
			<td class=label colspan='3'>&nbsp;&nbsp;&nbsp;</td>
					<TD class='label' colspan='2' align='right'><label style="cursor:pointer;color:blue;font-size:11" onClick="showDrugProfile(document.forms[0].patient_id.value,'','')">&nbsp;<fmt:message key="Common.DrugProfile.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;</label><label style="cursor:pointer;color:blue;font-size:11" onClick='callActive(document.forms[0].patient_id.value)'> &nbsp;<fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;</label><label style="cursor:pointer;color:blue;font-size:11" onclick='callAllergies(document.forms[0].patient_id.value)'> &nbsp;<fmt:message key="Common.Allergy.label" bundle="${common_labels}"/>&nbsp;&nbsp;</label></TD><td class=label>&nbsp;&nbsp;&nbsp;</td>
			</TR>
			<TR>
					<TH align='left' colspan='6' height='15'><b><fmt:message key="ePH.DrugAllergy.label" bundle="${ph_labels}"/></b></TH>
			</TR>
			
			<TR>
					<TD align="left" class="label" width="100%" colspan='6'>&nbsp;
					<textArea name="Drug" <%=dis%> rows='4' cols='108' onkeypress= "ChkMaxLen('Drug description',this,1000,'mode');"><%=ALLERGY_DRUG%></textarea></TD>
			</TR>
			<TR>
					<TD class='label' colspan='6'>&nbsp;&nbsp;&nbsp;</TD>
			</TR>
			
			</TR>
					<TH align='left' colspan='6' height='15'><b><fmt:message key="ePH.FoodAllergy.label" bundle="${ph_labels}"/></b></TH>
			</TR>
			
			<TR>
					<TD align="left" class="label" width="100%" colspan='6'>&nbsp;
					<textArea name="food"  <%=dis%> rows='4' cols='108' onkeypress= "ChkMaxLen('Food description',this,1000,'mode');"><%=ALLERGY_FOOD%></textarea></TD>
			</TR>
			<TR>
					<TD class='label' colspan='6'>&nbsp;&nbsp;&nbsp;</TD>
			</TR>
		
			</TR>
					<TH align='left' colspan='6' height='15'><b><fmt:message key="Common.others.label" bundle="${common_labels}"/> </b></TH>
			</TR>
			
			<TR >
					<TD align="left" class="label" width="100%" colspan='6'>&nbsp;
					<textArea name="other_desc"  <%=dis%> rows='4' cols='108' onkeypress= "ChkMaxLen('Other description',this,1000,'mode');"><%=ALLERGY_OTH%></textarea></TD>
			</TR>
			<TR>
					<TD class='label' colspan='6'>&nbsp;&nbsp;&nbsp;</TD>
			</TR>
			<TR id='last_row'>
					<TD class='label' colspan='6'>&nbsp;&nbsp;&nbsp;</TD>
			</TR>
</TABLE>

<INPUT TYPE="hidden" name="display3" id="display3" VALUE="Y">
</form></body>
<% putObjectInBean(bean_id,bean,request); %>
</html>

