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
	<title id="lookup_title"><%=request.getParameter( "title" )%></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	


	    String locale			= (String)session.getAttribute("LOCALE");

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

         String both = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		 String yes = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
		 String no = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
		 
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
    <script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%!
	public String buildCommonCombo(String objValue,String both,String yes,String no){
		 
		String comboValues="";
		if (objValue.equals("B") || objValue.equals(""))
			comboValues= "<option value='B'>"+both+"</option><option value='Y'>"+yes+"</option><option value='N'>"+no+"</option>";
		else if (objValue.equals("Y"))
			comboValues= "<option value='B'>"+both+"</option><option value='Y' selected>"+yes+"</option><option value='N'>"+no+"</option>";
		else if (objValue.equals("N"))
			comboValues= "<option value='B'>"+both+"</option><option value='Y' >"+yes+"</option><option value='N' selected>"+no+"</option>";
		return comboValues;
	}
%>
<%
	String	bean_id				=	"DrugSearchBean" ;
	String	bean_name			=	"ePH.DrugSearchBean";
	DrugSearchBean bean			=	(DrugSearchBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	ArrayList arrListAll		=	(ArrayList)bean.getAllDefaultValues();
	ArrayList arrListSchedule	=	(ArrayList)arrListAll.get(3);
	//ArrayList arrListLocation	=	(ArrayList)arrListAll.get(4);

	//For Drug Type
	String drug_type = bean.getDrugType();
	String drug_type_trail = "",drug_type_infection_control="",drug_type_vaccine="";
	if (drug_type.equals("T"))
		drug_type_trail = "selected";
	else if (drug_type.equals("I"))
		drug_type_infection_control = "selected";
	else if (drug_type.equals("V"))
		drug_type_vaccine = "selected";
	//For Drug Class
	String drug_class = bean.getDrugClass();
	String drug_class_general = "",drug_class_narcotic="",drug_class_controlled="";
	if (drug_class.equals("General"))
		drug_class_general = "selected";
	else if (drug_class.equals("Narcotic"))
		drug_class_narcotic = "selected";
	else if (drug_class.equals("Controlled"))
		drug_class_controlled = "selected";
	//For Scope
	String scope = bean.getScope();
	String scope_enterprise = "",scope_dispense_location="";
	if (scope.equals("E"))
		scope_enterprise = "selected";
	else if (scope.equals("F"))
	{ //scope_facility = "selected"; 

	}
	else if (scope.equals("D"))
		scope_dispense_location = "selected";
	//For Check Stock Avaliability

%>
<!-- <body > -->
<body  class="relativePosition" onMouseDown="" onKeyDown="lockKey()"> 
<form name="frmDrugNameCommonLookupOtherCriteria" id="frmDrugNameCommonLookupOtherCriteria">
<table cellpadding=0 cellspacing=0 width="100%"  align="center" border="0" id="tabTable">
<th colspan="4" align="center"><fmt:message key="Common.others.label" bundle="${common_labels}"/></th>
			<tr>
				<td  class="label" nowrap><fmt:message key="ePH.Non-Essential/Restricted.label" bundle="${ph_labels}"/>&nbsp;</td>
				<td align="left">&nbsp;
					<select name="non_essential_restricted" id="non_essential_restricted">
						<% out.println(buildCommonCombo(bean.getNonEssentialRestricted(),both,yes,no)); %>
					</select>
				</td>
				<td  class="label"><fmt:message key="ePH.DrugType.label" bundle="${ph_labels}"/>&nbsp;</td>
				<td align="left">&nbsp;
					<select name="drug_type" id="drug_type">
							<option value="A">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
							<option value="T" <%=drug_type_trail%>><fmt:message key="ePH.TrialDrug.label" bundle="${ph_labels}"/></option>
							<option value="I" <%=drug_type_infection_control%>><fmt:message key="ePH.InfectionControlDrug.label" bundle="${ph_labels}"/></option>
							<option value="V" <%=drug_type_vaccine%>><fmt:message key="Common.Vaccine.label" bundle="${common_labels}"/></option>
					</select>
				</td>
			</tr>
			<tr>
				<td  class="label" nowrap><fmt:message key="ePH.IVIngredients.label" bundle="${ph_labels}"/>&nbsp;</td>
				<td align="left">&nbsp;
					<select name="ingredient" id="ingredient">
					<% out.println(buildCommonCombo(bean.getIngredient(),both,yes,no)); %>
					</select>
				</td>
				<td  class="label"><fmt:message key="ePH.IVFluid.label" bundle="${ph_labels}"/>&nbsp;</td>
				<td align="left">&nbsp;
					<select name="fluid" id="fluid">
						<% out.println(buildCommonCombo(bean.getFluid(),both,yes,no)); %>
					</select>&nbsp;
				</td>
			</tr>
			<tr>
				<td  class="label" nowrap><fmt:message key="ePH.Compound.label" bundle="${ph_labels}"/>&nbsp;</td>
				<td align="left">&nbsp;
					<select name="compound" id="compound">
						<% out.println(buildCommonCombo(bean.getCompound(),both,yes,no)); %>
					</select>
				</td>
				<td class="label" nowrap><fmt:message key="ePH.AffectsPregnancy.label" bundle="${ph_labels}"/>&nbsp;</td>
				<td align="left">&nbsp;
					<select name="affects_pregnancy" id="affects_pregnancy">
						<% out.println(buildCommonCombo(bean.getAffectsPregnancy(),both,yes,no)); %>
					</select>
				</td>
			</tr>
			<tr>
				<td  class="label" nowrap><fmt:message key="ePH.AffectsLabResults.label" bundle="${ph_labels}"/>&nbsp;</td>
				<td align="left">&nbsp;
					<select name="affects_lab_results" id="affects_lab_results">
						<% out.println(buildCommonCombo(bean.getAffectsLabResults(),both,yes,no)); %>
					</select>&nbsp;
				</td>
				<td  class="label" nowrap><fmt:message key="ePH.AffectsBreastFeeding.label" bundle="${ph_labels}"/>&nbsp;</td>
				<td align="left">&nbsp;
					<select name="affects_breast_feed" id="affects_breast_feed">
							<% out.println(buildCommonCombo(bean.getAffectsBreastFeed(),both,yes,no)); %>
					</select>
				</td>
			</tr>
			<tr>
				<td class="label"><fmt:message key="ePH.Formulary.label" bundle="${ph_labels}"/>&nbsp;</td>
				<td align="left">&nbsp;
					<select name="formulary" id="formulary">
						<% out.println(buildCommonCombo(bean.getFormulary(),both,yes,no)); %>
					</select>
				</td>
				<td class="label"><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/>&nbsp;</td>
				<td align="left">&nbsp;
					<select name="drug_class" id="drug_class">
							<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
							<option value="G" <%=drug_class_general%>><fmt:message key="Common.general.label" bundle="${common_labels}"/></option>
							<option value="N" <%=drug_class_narcotic%>><fmt:message key="ePH.Narcotics.label" bundle="${ph_labels}"/></option>
							<option value="C" <%=drug_class_controlled%>><fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/></option>
					</select>
				</td>
			</tr>
			<tr>

				<td  class="label"><fmt:message key="Common.Scope.label" bundle="${common_labels}"/>&nbsp;</td>
				<td align="left">&nbsp;
					<select name="scope" id="scope">
							<option value="E" <%=scope_enterprise%>><fmt:message key="Common.enterprise.label" bundle="${common_labels}"/></option>
							<option value="D" <%=scope_dispense_location%>><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></option>
					</select>&nbsp;
				</td>
				<td  class="label"><fmt:message key="Common.Schedule.label" bundle="${common_labels}"/>&nbsp;</td>
				<td align="left">&nbsp;
					<select name="schedule_id" id="schedule_id">
							<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
							<%
							String scheduleSelect = "";
							for (int i=0;i<arrListSchedule.size()-1;i++){
								if (arrListSchedule.get(i).equals(bean.getScheduleID())){
									scheduleSelect = "selected";
								}else{
									scheduleSelect = "";
								}

							%>
							<option <%=scheduleSelect%> value="<%=arrListSchedule.get(i)%>"><%=arrListSchedule.get(++i)%></option>
							<%
								}
							%>
					</select>
				</td>
			</tr>
			<tr>
				<td  class="label" ><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/>&nbsp;</td>
				<td align="left">&nbsp;
					<input type="text" name="manufacturer_short_name" id="manufacturer_short_name" value="<%=bean.getManufacturerShortName()%>"><input type="button" value="?" class="button" onClick="searchCode(manufacturer_short_name,'Manufacturer')">
					<input type="hidden" name="manufacturer_code" id="manufacturer_code" value="<%=bean.getManufacturerCode()%>">
				</td>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp;</td>
				<td >
					<input type="button" name="" id="" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button" onClick="searchBasedOnCriteria('OK')">
					<input type="button" name="" id="" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  class="button" onClick="var dialogTag = parent.document.getElementById('dialog_tag').close()">
				</td>
			</tr>
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
	</table>
	<input type="hidden" name="OtherCriteria" id="OtherCriteria" value="OtherCriteria">
	<input type="hidden" name="SQL_PH_DRUG_SEARCH_SELECT12" id="SQL_PH_DRUG_SEARCH_SELECT12" value="<%=PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT12")%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="language_id" id="language_id" value="<%= locale %>">
	</form>
	</body>
	</html>

	<%
putObjectInBean(bean_id,bean,request);
%>

