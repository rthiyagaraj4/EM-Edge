<!DOCTYPE html>
 <%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
03/07/2019		IN070451			B Haribabu						ML-MMOH-CRF-1408
28/04/2022                          Chandrashekar raju a            ML-MMOH-SCF-1974

---------------------------------------------------------------------------------------------------------
*/ 
%> 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086

		String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> 
 -->	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../ePH/js/PhCommon.js"></script>
<!-- 	<script language="javascript" src="../js/PhMessages.js"></script>
 -->	<script language="javascript" src="../../ePH/js/DrugDosageLimit.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	<SCRIPT>
		function_id = "<%= request.getParameter( "function_id" ) %>"  
	</SCRIPT>
</HEAD>
<style>
textarea {
  resize: none;
}
</style>
<!-- <body onMouseDown="CodeArrest()" onKeyDown="lockKey()" > -->
<body onMouseDown="" onKeyDown="lockKey()">


<%
	String	mode			=	request.getParameter( "mode" ) ;
	String	bean_id			=	"DrugDosageLimit" ;
	String	bean_name		=	"ePH.DrugDosageLimitBean";
	//String	disabled		=	"" ;

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	DrugDosageLimitBean bean = (DrugDosageLimitBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	String facility_id				= (String)session.getValue( "facility_id" );

	ArrayList arrListAgeGroupRelated=new ArrayList();
	//ArrayList arrListDrugCodeRelated=new ArrayList();
	String strEnabledDisabled="";
	String DrugCode				="";		String DrugDesc			="";
	String GenericName			="";		String StrengthValue	="";
	String FormDesc				="";		String PresBaseUOM		="";
	String AgeGroupCode			="";		String AgeGroupDesc		="";
	String Gender				="";		String checkStrength	="";
	String AgeUnit				="";		String checkBaseUnit	="";		
	String AgeUnitDisply		="";		String std_dosage		="";
	String MinAge				="";		String set_by			="";
	String MaxAge				="";		String LowOfUnitDosage	="";
	String HighOfUnitDosage		="";		String LowOfDailyDosage	="";
	String HighOfDailyDosage	="";		String Monograph		="";
	String calc_by_ind			="";
	String LimitInd1			="disabled";
	String LimitInd2			="checked disabled";
	String calculate_dosage_by	="";
	String LowCellingOfUnitDosage	=""; //Added for IN:070451
	String HighCellingOfUnitDosage	=""; //Added for IN:070451
	String LowCellingOfDailyDosage	=""; //Added for IN:070451
	String HighCellingOfDailyDosage	=""; //Added for IN:070451
	//String std_unit			="";
	
	
	if (mode.equals(CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )){
		arrListAgeGroupRelated=bean.getAgeGroupRelatedInfo();	
	}else if (mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )){
		calc_by_ind = request.getParameter( "calc_by_ind" );
		bean.setDrugCode(request.getParameter( "drug_code" ).trim());
		bean.setAgeGroupCode(request.getParameter( "age_group_code" ).trim());
		strEnabledDisabled="disabled";
		ArrayList arrList=bean.getDataForLink(calc_by_ind);
		//out.println("arrList=="+arrList);
		//drug code
			DrugCode		=(String)arrList.get(0);
		//drug name
		if (arrList.get(1)!=null)
			DrugDesc		=(String)arrList.get(1);
		else
			DrugDesc		= "";
		//generic name
		if (arrList.get(2)!=null)
			GenericName		=(String)arrList.get(2);
		else
			GenericName		= "";
		//Strength
		if (arrList.get(3)!=null){
			StrengthValue	=(String)arrList.get(3);
			if (StrengthValue.equals("0")){
				StrengthValue = "";
			}
		}
		else
			StrengthValue	="";

		if (!StrengthValue.equals("")){
			LimitInd1="checked";
			LimitInd2="";
		}
		//FormDesc
		if (arrList.get(4)!=null)
			FormDesc		=(String)arrList.get(4);
		else
			FormDesc		="";
		//Base Unit
		if (arrList.get(5)!=null)
			PresBaseUOM		=(String)arrList.get(5);
		else
			PresBaseUOM		="";

		//Age Group Code
			AgeGroupCode	=bean.getAgeGroupCode();
		
		//Age Group Desc
		if (arrList.get(6)!=null)
			AgeGroupDesc	=(String)arrList.get(6);
		else
			AgeGroupDesc	="";
		//Gender
		if (arrList.get(7)!=null)
			Gender			=(String)arrList.get(7);
		else
			Gender			="";

		AgeUnit			=(String)arrList.get(8);
		
		if (AgeUnit.equals("D")){
			AgeUnitDisply = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
			AgeUnit = "Days";
		}
		else if (AgeUnit.equals("W")){
			AgeUnitDisply = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weeks.label","common_labels");
			AgeUnit = "Weeks";
		}
		else if (AgeUnit.equals("M")){
			AgeUnitDisply = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.months.label","common_labels");
			AgeUnit = "Months";
		}
		else if (AgeUnit.equals("Y")){
			AgeUnitDisply = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Years.label","common_labels");
			AgeUnit = "Years";
		}else if (AgeUnit.equals("H")){//Adding start for ML-MMOH-SCF-1974
			AgeUnitDisply = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.hours.label","common_labels");
			AgeUnit = "Hours";
		}else if (AgeUnit.equals("N")){
			AgeUnitDisply = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minutes.label","common_labels");
			AgeUnit = "Minutes";
		}//Adding end for ML-MMOH-SCF-1974
		else{
			AgeUnit = "";
			AgeUnit = "Days";
		}
		MinAge			=(String)arrList.get(9);
		MaxAge			=(String)arrList.get(10);
		LowOfUnitDosage	=(String)arrList.get(11);
		HighOfUnitDosage=(String)arrList.get(12);
		LowOfDailyDosage=(String)arrList.get(13);
		HighOfDailyDosage=(String)arrList.get(14);
		if (arrList.get(15)!=null)
			Monograph		=(String)arrList.get(15);
		else
			Monograph		="";

		set_by	= ((String)arrList.get(16));

		if (((String)arrList.get(16)).equals("S")){
			checkStrength="checked";
			checkBaseUnit="";
		}else{
			checkStrength="";
			checkBaseUnit="checked";
		}

	calculate_dosage_by	=	(String)arrList.get(17);
	std_dosage			=	(String)arrList.get(18);
	LowCellingOfUnitDosage =(String)arrList.get(20); //Added for IN:070451
	HighCellingOfUnitDosage =(String)arrList.get(21); //Added for IN:070451
	LowCellingOfDailyDosage =(String)arrList.get(22); //Added for IN:070451
	HighCellingOfDailyDosage =(String)arrList.get(23); //Added for IN:070451
	//std_unit			=	(String)arrList.get(19);	
	


	}
	/* Initialize Function specific end */
%>
<FORM name="formDrugDosageLimit" id="formDrugDosageLimit" id="Drug Dosage Limit" >
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
		<tr >
			<th align="left" colspan="4"><fmt:message key="ePH.DrugDetail.label" bundle="${ph_labels}"/></th>
		</tr>
		<tr>
			<td  class="label" align="right" ><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
			<td	 align="left" colspan="3">&nbsp;
			<input type="text" maxlength="60" size="60" name="drug_desc" id="drug_desc"  onBlur="clearDrugRelatedFields('onBlur');" value="<%=DrugDesc%>" <%=strEnabledDisabled%>><input type="hidden" maxlength="10" size="10" name="drug_code" id="drug_code" value="<%=DrugCode%>"><%
				if (mode.equals(CommonRepository.getCommonKeyValue( "MODE_INSERT" ))){
			%><input type="button" class="button" value="?" onClick="DrugSearchForDosageLimit(drug_desc)"><img src="../../eCommon/images/mandatory.gif" align="center"></img>	
			<%
				}
			%>
			</td>
		</tr>
		<tr>
			<td  class="label" align="right"><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></td>
			<td  align="left">&nbsp;&nbsp;<input type="text" name="generic_name" id="generic_name" value="<%=GenericName%>" size="40" maxlength="40" disabled></td>
			<td  class="label" align="right"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></td>
			<td  align="left">&nbsp;&nbsp;<input type="text" name="strength_value" id="strength_value" value="<%=StrengthValue%>" size="13" maxlength="13" disabled></td>
		</tr>
		
		<tr colspan="4">
			<td  class="label" align="right"><fmt:message key="ePH.FormofDrug.label" bundle="${ph_labels}"/></td>
			<td  align="left">&nbsp;&nbsp;<input type="text" name="form_desc" id="form_desc" size="20" maxlength="20" value="<%=FormDesc%>"  disabled></td>
			<td  class="label" align="right"><fmt:message key="ePH.BaseUnit.label" bundle="${ph_labels}"/></td>
			<td  align="left">&nbsp;&nbsp;<input type="text" name="pres_base_uom" id="pres_base_uom" value="<%=PresBaseUOM%>"  size="15" maxlength="15" disabled></td>
		</tr>
		<tr>
			<td class="label" align="right"><fmt:message key="ePH.CalculateDosageBy.label" bundle="${ph_labels}"/></td>
			<td>&nbsp;&nbsp;<select name="calc_dosage_by" id="calc_dosage_by" disabled onChange="defaultUnit();checkforvalid(formDrugDosageLimit.age_group_code)">
				<%	if(calculate_dosage_by.equals("")) {	%>
				<option value="A" selected><fmt:message key="Common.Absolute.label" bundle="${common_labels}"/></option>
				<option value="B"><fmt:message key="Common.BSA.label" bundle="${common_labels}"/></option>
				<option value="W"><fmt:message key="Common.weight.label" bundle="${common_labels}"/></option>
				<%	}	else if(calculate_dosage_by.equals("A"))	{	%>
				<option value="A" selected><fmt:message key="Common.Absolute.label" bundle="${common_labels}"/></option>
				<option value="B"><fmt:message key="Common.BSA.label" bundle="${common_labels}"/></option>
				<option value="W"><fmt:message key="Common.weight.label" bundle="${common_labels}"/></option>
				<%	}	else if(calculate_dosage_by.equals("B"))	{	%>
				<option value="A"><fmt:message key="Common.Absolute.label" bundle="${common_labels}"/></option>
				<option value="B" selected><fmt:message key="Common.BSA.label" bundle="${common_labels}"/></option>
				<option value="W"><fmt:message key="Common.weight.label" bundle="${common_labels}"/></option>
				<%	}	else if(calculate_dosage_by.equals("W"))	{	%>
				<option value="A"><fmt:message key="Common.Absolute.label" bundle="${common_labels}"/></option>
				<option value="B"><fmt:message key="Common.BSA.label" bundle="${common_labels}"/></option>
				<option value="W" selected><fmt:message key="Common.weight.label" bundle="${common_labels}"/></option>
				<%	}	%>
				</select><% if(mode.equals(CommonRepository.getCommonKeyValue( "MODE_INSERT" ))){%>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></img><%}%>
			</td>

			<td class="label" align="right"><fmt:message key="ePH.SetLimitBy.label" bundle="${ph_labels}"/></td>
			<td >&nbsp;<input type="radio" name="limit_ind" id="limit_ind" value="S" <%=LimitInd1%> <%=checkStrength%> onClick="setUOM('S')"><label class="label"> <fmt:message key="Common.Strength.label" bundle="${common_labels}"/></label>
				<input type="radio" name="limit_ind" id="limit_ind" value="B" <%=LimitInd2%> <%=checkBaseUnit%> onClick="setUOM('B')"><label class="label" ><fmt:message key="ePH.BaseUnit.label" bundle="${ph_labels}"/></label>
			</td>
		</tr>
		<tr>
			<th align="left" colspan="4"><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></th>
		</tr>
		<tr>
			<td class="label" align="right" ><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></td>
			<%
				if (mode.equals(CommonRepository.getCommonKeyValue( "MODE_INSERT" ))){
			%>
			<td align="left">&nbsp;
				<select onchange="getRelatedValuesForAgeGroup(this);checkforvalid(this)" name="age_group_code" id="age_group_code" <%=strEnabledDisabled%>>
						<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<%
					for (int i=0;i<arrListAgeGroupRelated.size();i++){
						String[] strAgeGroupRelated=(String[])arrListAgeGroupRelated.get(i);
				%>
						<option value="<%=strAgeGroupRelated[0]%>"><%=strAgeGroupRelated[1]%></option>	
				<%
					}
				%>
				</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></img>

				<%
					}else{
				%>
					<td	 align="left" >&nbsp;&nbsp;<input type="text" name="age_group_desc" id="age_group_desc" size="20" value="<%=AgeGroupDesc%>" maxlength="20" disabled>
					<input type="hidden" name="age_group_code" id="age_group_code"  value="<%=AgeGroupCode%>" >
				<%
					}
				%>
				<script>
				<%
					for (int i=0;i<arrListAgeGroupRelated.size();i++){
						String[] strAgeGroupRelated=(String[])arrListAgeGroupRelated.get(i);
				%>
						globalGender['<%=i%>'] = "<%=strAgeGroupRelated[2]%>";
						globalAgeUnit['<%=i%>'] = "<%=strAgeGroupRelated[3]%>";
						globalMinAge['<%=i%>'] = "<%=strAgeGroupRelated[4]%>";
						globalMaxAge['<%=i%>'] = "<%=strAgeGroupRelated[5]%>";
				<%
					}
				%>
				</script>
			</td>
			<td class="label" align="right"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;<input type="text" maxlength="6" size="6" disabled name="gender" id="gender" value="<%=Gender%>" ></td>
		</tr>
		<tr >
			<td class="label" align="right"><fmt:message key="Common.AgeUnit.label" bundle="${common_labels}"/></td>
			<td colspan="3">&nbsp;&nbsp;<input type="text" maxlength="6" size="6" disabled name='lbl_age_unit' id='lbl_age_unit' value=<%=AgeUnitDisply%>><input type="hidden" name="age_unit" id="age_unit" value="<%=AgeUnit%>" ></td>			
		</tr> 
	<tr>
	</table>
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
		<th colspan="6" align="left"><fmt:message key="ePH.AssociateAgeGroup.label" bundle="${ph_labels}"/></th><!-- Modified for IN:070451 -->
	</tr>
	<tr> 
		<td >&nbsp;</td>
		<td align="left" class="label" style="font-weight:bold">&nbsp;&nbsp;<fmt:message key="Common.Minimum.label" bundle="${common_labels}"/></td>
		<!-- Modified for IN:070451 start -->
		<td align="left" class="label" id="CellingDose" style="font-weight:bold">&nbsp;&nbsp;<fmt:message key="ePH.CeilingDose.label" bundle="${ph_labels}"/></td>
		<td align="left" class="label" style="font-weight:bold">&nbsp;&nbsp;<fmt:message key="Common.maximum.label" bundle="${common_labels}"/></td>
		<td align="left" class="label" id="CellingDose1" style="font-weight:bold">&nbsp;&nbsp;<fmt:message key="ePH.CeilingDose.label" bundle="${ph_labels}"/></td>
		<td align="left" class="label" style="font-weight:bold">&nbsp;&nbsp;<fmt:message key="Common.Standard.label" bundle="${common_labels}"/></td>
		<!-- Modified for IN:070451 end-->
	</tr>
	
	<tr>
		<td class="label" align="left" ><fmt:message key="Common.AgeRange.label" bundle="${common_labels}"/> </td>
		<td class="label" colspan="2" >&nbsp;&nbsp;<input type="text" name="min_age" id="min_age" size="3" maxlength="3" disabled value="<%=MinAge%>" class="NUMBER"></td><!-- Modified for IN:070451 -->
		<td class="label" colspan="3">&nbsp;&nbsp;<input type="text" name="max_age" id="max_age" size="3" maxlength="3" disabled value="<%=MaxAge%>" class="NUMBER"></td><!-- Modified for IN:070451 -->		
	</tr>
	<tr>
		
		<td class="label" align="left" ><fmt:message key="Common.UnitDose.label" bundle="${common_labels}"/> </td>
		<td class="label" >&nbsp;&nbsp;<input type="text" name="low_of_unit_dosage" id="low_of_unit_dosage"  size="13" maxlength="13" onBlur="validNumber(this);" value="<%=LowOfUnitDosage.trim()%>" class="NUMBER">&nbsp;<label id="dose_unit_1"></label>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
		<!-- Modified for IN:070451 Start -->
		<td class="label" >&nbsp;&nbsp;<input type="text" name="low_celling_of_unit_dosage" id="low_celling_of_unit_dosage"  size="13" maxlength="13" onBlur="validNumber(this);" value="<%=LowCellingOfUnitDosage.trim() %>" class="NUMBER">&nbsp;<label id="dose_unit_23"></label>&nbsp;</td>
		<td class="label">&nbsp;&nbsp;<input type="text" name="high_of_unit_dosage" id="high_of_unit_dosage"  size="13" maxlength="13" onBlur="validNumber(this);" value="<%=HighOfUnitDosage.trim()%>" class="NUMBER">&nbsp;<label id="dose_unit_2"></label>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
		<td class="label">&nbsp;&nbsp;<input type="text" name="high_celling_of_unit_dosage" id="high_celling_of_unit_dosage"  size="13" maxlength="13" onBlur="validNumber(this);" value="<%=HighCellingOfUnitDosage.trim()%>" class="NUMBER">&nbsp;<label id="dose_unit_24"></label>&nbsp;</td>
		<td class="label">&nbsp;&nbsp;<input type="text" name="std_unit_dosage" id="std_unit_dosage"  size="13" maxlength="13" onBlur="validNumber(this);" value="<%=std_dosage.trim()%>" class="NUMBER">&nbsp;<label id="dose_unit_3"></label><img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
		<!-- Modified for IN:070451 end-->
	</tr>
	<tr>
		<td class="label" align="left"><fmt:message key="ePH.DailyDose.label" bundle="${ph_labels}"/> </td>
		<td class="label" >&nbsp;&nbsp;<input type="text" name="low_of_daily_dosage" id="low_of_daily_dosage"  size="13" maxlength="13" onBlur="validNumber(this);" value="<%=LowOfDailyDosage.trim()%>" class="NUMBER">&nbsp;<label id="dose_unit_4"></label>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
		<td class="label" >&nbsp;&nbsp;<input type="text" name="low_celling_of_daily_dosage" id="low_celling_of_daily_dosage"  size="13" maxlength="13" onBlur="validNumber(this);" value="<%=LowCellingOfDailyDosage.trim()%>" class="NUMBER">&nbsp;<label id="dose_unit_20"></label></td><!-- Modified for IN:070451 -->
		<td class="label" >&nbsp;&nbsp;<input type="text" name="high_of_daily_dosage" id="high_of_daily_dosage" size="13" maxlength="13" onBlur="validNumber(this);" value="<%=HighOfDailyDosage.trim()%>" class="NUMBER">&nbsp;<label id="dose_unit_5"></label>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
		<td class="label" colspan="2">&nbsp;&nbsp;<input type="text" name="high_celling_of_daily_dosage" id="high_celling_of_daily_dosage"  size="13" maxlength="13" onBlur="validNumber(this);" value="<%=HighCellingOfDailyDosage.trim()%>" class="NUMBER">&nbsp;<label id="dose_unit_21"></label></td><!-- Modified for IN:070451 -->
	</tr>
	<tr>
		<td class="label" align="left" ><fmt:message key="ePH.Monograph.label" bundle="${ph_labels}"/></td>
		<td colspan="4" align="left">&nbsp;&nbsp;<textarea cols="95" rows="9" name="monograph" onKeyPress="return(checkMaxLimit(this,4000));" onBlur="callCheckMaxLen(this,'4000','Monograph')"  ><%=Monograph%></textarea></td>
	</tr>
	</table>

	<input type="hidden" name="mode" id="mode" value="<%= mode %>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
	<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%=bean.getFunctionId()%>">
	<input type="hidden" name="std_unit" id="std_unit" value="">
</FORM>
</BODY>
<script>
getDrugRelatedInfo(document.formDrugDosageLimit.drug_code);

setUOM('<%=set_by%>');
defaultUnit();
</script>
</HTML>

<%
putObjectInBean(bean_id,bean,request);
%>

