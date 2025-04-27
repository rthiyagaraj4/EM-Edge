<!DOCTYPE html>
<!--Created by P.Anuradha on Jan-04-2005-->

<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.*, webbeans.eCommon.*, java.util.HashMap, com.ehis.eslp.* ,java.net.*,java.util.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff"); %>

<%-- jsp:useBean id="mh" scope="session" class="CommonMultipleHandler" --%>
<%-- To call the Common MultipleHandler where the id will be as mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
  <head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/TermSet.js"></script>
	
	
	<script language="JavaScript" src="../../eOR/js/OrMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  </head>
<%
Connection conn=null;
PreparedStatement cutoff_units_stmt=null;
ResultSet cutoff_units_rset=null;
PreparedStatement stmt1=null;
ResultSet rset1=null;
try
{
	String mode=checkForNull(request.getParameter("mode"));
//out.println("mode:"+mode);
	String function_id = request.getParameter("function_id" );
	//String facility_id = (String)session.getAttribute("facility_id");
	String durn_type="";
	String durn_desc="";
	String enc_stage_appl="N";
	conn=ConnectionManager.getConnection(request);
	
	boolean isEncounterStage = false;
	String isEnc="";
    isEncounterStage =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","TERM_RECODE_DIAG"); //Added by KAMATCHI  S for ML-MMOH-CRF-1581
    String visibility_check= "visibility:visible";//Added by KAMATCHI S for ML-MMOH-CRF-1581
	//Below Added by Suji Keerthi for ML-MMOH-CRF-1395 US001 
	boolean isDiagClassMand = false;
	isDiagClassMand =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DIAG_CLASS_MAND");
	String diag_class_mand_yn = eMR.MRCommonBean.getMRParameterValues(conn); 
	//Ended by Suji Keerthi for ML-MMOH-CRF-1395 US001 
	

	String cutoff_units_sql="select durn_type, durn_desc from am_duration_type order by durn_desc";
	cutoff_units_stmt=conn.prepareStatement(cutoff_units_sql);
	cutoff_units_rset=cutoff_units_stmt.executeQuery();
%>
	<body onMouseDown="CodeArrest()" onload='FocusFirstElement();ModifyMode();<%if(isDiagClassMand){%>diagclassmand();<%}%> ' onKeyDown="lockKey()">
	<form name="TermSetAddModify_Form" id="TermSetAddModify_Form" method="post" action='../../servlet/eMR.TermSetServlet' target="messageFrame">
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<%
	if(mode.equals("1"))
	{
		%>
		<table cellpadding='5' cellspacing=0 width="100%" border="0" align="center">
		<tr>
		<td class="label" width='20%'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
		<td class='fields' width='80%' >
		<input type="text" name="TermSet_ID" id="TermSet_ID" value="" size="20" maxlength="20" onBlur="ChangeUpperCase(this);" onKeyPress="return CheckForSpecChars(event);"><img src="../../eCommon/images/mandatory.gif"></img>
		</td>
		
		</tr>
		<tr>
		
		<td class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<input type="text" name="TermSet_Desc" id="TermSet_Desc" value="" size="60" maxLength="60" onBlur="makeValidString(this);"><img src="../../eCommon/images/mandatory.gif"></img>
		</td>
		
		</tr>
		<tr>
		
		<td class="label"  ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='checkbox' name='eff_status_yn' id='eff_status_yn' checked>
		</td>
		
		</tr>
		</table>
		<table cellpadding='5' cellspacing=0 width="100%" border="0" align="center">
		<tr><!--<td class="COLUMNHEADER" colspan='6'><fmt:message key="Common.Attributes.label" bundle="${common_labels}"/></td>--><td class="COLUMNHEADER" colspan='6'><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.Attributes.label" bundle="${common_labels}"/></td></tr>
		
		<tr>
		<td class="label" width='20%'><fmt:message key="eMR.DiagnosisSpecific.label" bundle="${mr_labels}"/></td>
		<td class='fields' width='15%'><input type="checkbox" name="Diag_Spec_yn" id="Diag_Spec_yn"></td>
		<td class="label" width='20%'><fmt:message key="eMR.ProcedureSpecific.label" bundle="${mr_labels}"/></td>
		<td class='fields' width='10%'><input type="checkbox" name="Proc_Spec_yn" id="Proc_Spec_yn"></td>
		<td class="label" width='20%'><fmt:message key="eMR.BuildStatistics.label" bundle="${mr_labels}"/></td>
		<td class='fields' width='15%'><input type="checkbox" name="Build_Statistics_yn" id="Build_Statistics_yn"></td>
		
		</tr>
		<tr>
		<td class="label" ><fmt:message key="eMR.BuildEpisodeofCare.label" bundle="${mr_labels}"/></td>
		<td class='fields'><input type="checkbox" name="Build_Episode_yn" id="Build_Episode_yn"></td>
		<td class="label" ><fmt:message key="eMR.ClassificationLevels.label" bundle="${mr_labels}"/></td>
		<td class='fields' colspan='3'><select name="Classification_Levels" id="Classification_Levels" onChange="Display_Level(this);">
		<%
		int j=0;
		for(j=1;j<=10;j++)
		{
		%>
		<option value="<%=j%>"><%=j%></option>
		<%
		}
		%>
		</select>
		</td>
		</tr>
		<tr><td class="COLUMNHEADER" colspan='6'><fmt:message key="eMR.TermCodeControl.label" bundle="${mr_labels}"/></td></tr>			
		<tr>
	
		<td class="label" ><fmt:message key="eMR.Notification.label" bundle="${mr_labels}"/></td>
		
		<td class='fields'><input type="checkbox" name="Notification_yn" id="Notification_yn"></td>
		<td class="label"><fmt:message key="eMR.Sensitivity.label" bundle="${mr_labels}"/></td>
		<td class='fields'><input type="checkbox" name="Sensitivity_yn" id="Sensitivity_yn"></td>
		<td class="label" ><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="checkbox" name="Age_Group_yn" id="Age_Group_yn"></td>			
		</tr>
		<tr><td class="COLUMNHEADER" colspan='6'><fmt:message key="Common.general.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.Attributes.label" bundle="${common_labels}"/></td></tr>
		<tr>
		<td class="label" ><fmt:message key="eMR.DiagnosisNature.label" bundle="${mr_labels}"/></td>
		<td class='fields'><input type="checkbox" name="Diag_Nature_yn" id="Diag_Nature_yn"></td>	
		<td class="label" ><fmt:message key="Common.Severity.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="checkbox" name="Severity_yn" id="Severity_yn"></td>
		<td class="label" ><fmt:message key="eMR.DiagnosisFactors.label" bundle="${mr_labels}"/></td>
		<td class='fields'><input type="checkbox" name="Diag_Factor_yn" id="Diag_Factor_yn"></td>
		</tr>
		<tr><!--Condition Added by KAMATCHI S for ML-MMOH-CRF-1581-->
		<% if(!isEncounterStage){%><td class="label" ><fmt:message key="eMR.EncounterStage.label" bundle="${mr_labels}"/></td> 
		<td class='fields'><input type="checkbox" name="enc_stage_appl_yn" id="enc_stage_appl_yn"></td><%}%>
		<td class="label" ><fmt:message key="eMR.OnsetType.label" bundle="${mr_labels}"/></td>
		<td class='fields'><input type="checkbox" name="Onset_Type_yn" id="Onset_Type_yn"></td>
		<td class="label" ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="checkbox" name="Priority_yn" id="Priority_yn"></td>
		</tr>	
		<tr>
		<td class="label" ><fmt:message key="eMP.CutOffPeriod.label" bundle="${mp_labels}"/></td>
		<td class='fields'><input type="text" name="CutOff_Period" id="CutOff_Period" value="" size="3" maxlength="3" onBlur="CheckNum(this);Display_Mandatory(this);CheckZero_CutOff(this)" onKeyPress="return allowValidNumber(this,event,3,0);"></input></td><td class='fields'><select name="CutOff_Unit" id="CutOff_Unit" onChange="CheckCutoff();"><option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
		<%
		try
		{
		if(cutoff_units_rset!=null)
		{
			while(cutoff_units_rset.next())
			{
				durn_type=cutoff_units_rset.getString("durn_type");
				durn_desc=cutoff_units_rset.getString("durn_desc");
		%>
		<option value="<%=durn_type%>"><%=durn_desc%></option>
		<%}}}catch(Exception exp){/* out.println(exp.toString()); */exp.printStackTrace();}
		%>
		</select><img id="Cutoff_Mandatory" src="../../eCommon/images/mandatory.gif" style="visibility:hidden"></img>
		</td>	
		<td class='label' colspan='3'></td>
		</tr>
		
		<% if(isEncounterStage){
			%>	
		<tr>
		<td class="label" ><fmt:message key="eMR.EncounterStage.label" bundle="${mr_labels}"/></td> 
		<td class='fields'><input type="checkbox" name="enc_stage_appl_yn" id="enc_stage_appl_yn"></td>
		<td class="label" id="iplbl" ><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></td> 
		<td class='fields' id='ipchk' ><input type="checkbox"  name="inpatient_appl_yn" id="inpatient_appl_yn"></td>
		<td class="label" id="dclbl"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></td> 
		<td class='fields' id='dchk'><input type="checkbox"  name="daycare_appl_yn" id="daycare_appl_yn" ></td>
		</tr>
		<%
		}
		%> 
			
		</table>
		<table id="Classification_Level" cellpadding="5" cellspacing="0" align="center" border="0" width="100%">
		<tr><td class="COLUMNHEADER" colspan="3"><fmt:message key="eMR.ClassificationLevelDetails.label" bundle="${mr_labels}"/></td></tr>
		<tr><td class="label" width='20%' ></td><td class="label" width='65%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td><td class="label" width='15%'><fmt:message key="eMR.CodeLength.label" bundle="${mr_labels}"/></td></tr>
		<tr><td class="label" >Level 1</td>
		<td class='fields'><input type=text name="Description1" id="Description1" size="60" maxlength="60"><img src="../../eCommon/images/mandatory.gif"></img></td>
		<td class='fields'><input type=text name="CodeLength1" id="CodeLength1" size="2" maxlength="2" onBlur="CheckNum(this);CheckZero_Codelength(this);" onKeyPress="return allowValidNumber(this,event,2,0);"><img src="../../eCommon/images/mandatory.gif"></img></td>
		</tr>
		<%
		for(int k=2;k<=10;k++)
		{
		%>
		<tr style="display:none">
		<td class="label" ><fmt:message key="Common.Level.label" bundle="${common_labels}"/> <%=k%></td>
		<td class='fields'><input type=text name="Description<%=k%>" id="Description<%=k%>" size="60" maxlength="60"><img src="../../eCommon/images/mandatory.gif"></img></td>
		<td class='fields'><input type=text name="CodeLength<%=k%>" id="CodeLength<%=k%>" size="2" maxlength="2" onBlur="CheckNum(this);CheckZero_Codelength(this);" onKeyPress="return allowValidNumber(this,event,2,0);"><img src="../../eCommon/images/mandatory.gif"></img></td>
		</tr>
		<%
		}
		%>
		</table>
		<%
	}
	else if(mode.equals("2"))
	{
		
		String termset_id=request.getParameter("termset_id")==null?"":request.getParameter("termset_id");

		String termset_desc="";
		String diag_spec="";
		String proc_spec="";
		String build_stat="";
		String build_eoc="";
		String defn_level="";
		String priority="";
		String agegroup="";
		String nature="";
		String factors="";
		String notification="";
		String sensitivity="";
		String severity="";
		String onset_type="";
		String cutoff_period="";
		String cutoff_unit="";
		String eff_status="";

		String level1_description="";
		String level1_codelength="";
		String level2_description="";
		String level2_codelength="";
		String level3_description="";
		String level3_codelength="";
		String level4_description="";
		String level4_codelength="";
		String level5_description="";
		String level5_codelength="";
		String level6_description="";
		String level6_codelength="";
		String level7_description="";
		String level7_codelength="";
		String level8_description="";
		String level8_codelength="";
		String level9_description="";
		String level9_codelength="";
		String level10_description="";
		String level10_codelength="";
		String diag_classification = "";
		String appl_for_recoders = "";
		String appl_for_recoders_yn="";
		String free_txt_appl = "";
		String free_txt_appl_yn="";
		String diag_classification_mand = ""; //Added by Suji Keerthi for ML-MMOH-CRF-1395 on Dec-24,2020
		/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */
		String inpatient_appl="";
		String daycare_appl="";
		/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */

		//String diag_classification_appl = "";
		int dtlcnt = 0;
		String chk_appl = "";
		try
		{
			String sql_termset="select * from MR_TERM_SET where term_set_id = ? ";
			stmt1=conn.prepareStatement(sql_termset);
			stmt1.setString(1,termset_id);
			rset1=stmt1.executeQuery();
			if(rset1!=null)
			{
				while(rset1.next())
				{
					appl_for_recoders  = rset1.getString("recoders_appl_yn")==null? "N":rset1.getString("recoders_appl_yn");
					free_txt_appl  = rset1.getString("free_text_applicable_yn")==null? "N":rset1.getString("free_text_applicable_yn");

					termset_desc = rset1.getString("term_set_desc")==null ? "":rset1.getString("term_set_desc");
					diag_spec  = rset1.getString("diag_spec_yn")==null? "N":rset1.getString("diag_spec_yn");
					proc_spec  = rset1.getString("proc_spec_yn")==null? "N":rset1.getString("proc_spec_yn");
					build_stat  = rset1.getString("incl_for_stats_yn")==null? "N":rset1.getString("incl_for_stats_yn");
					build_eoc  = rset1.getString("build_eoc_yn")==null? "N":rset1.getString("build_eoc_yn");
					defn_level  = rset1.getString("defn_levels")==null? "":rset1.getString("defn_levels");
					priority  = rset1.getString("priority_appl_yn")==null? "N":rset1.getString("priority_appl_yn");
					agegroup  = rset1.getString("age_group_appl_yn")==null? "N":rset1.getString("age_group_appl_yn");
					nature  = rset1.getString("nature_appl_yn")==null? "N":rset1.getString("nature_appl_yn");
					factors  = rset1.getString("factors_appl_yn")==null? "N":rset1.getString("factors_appl_yn");
					notification  = rset1.getString("notification_appl_yn")==null? "N":rset1.getString("notification_appl_yn");
					sensitivity  = rset1.getString("sensitivity_appl_yn")==null? "N":rset1.getString("sensitivity_appl_yn");
					severity  = rset1.getString("severity_appl_yn")==null? "N":rset1.getString("severity_appl_yn");
					onset_type  = rset1.getString("onset_type_appl_yn")==null? "N":rset1.getString("onset_type_appl_yn");
					enc_stage_appl  = rset1.getString("enc_stage_appl_yn")==null? "N":rset1.getString("enc_stage_appl_yn");
					cutoff_period  = rset1.getString("onset_type_cutoff_prd")==null? "":rset1.getString("onset_type_cutoff_prd");
					cutoff_unit  = rset1.getString("onset_type_cutoff_unit")==null? "":rset1.getString("onset_type_cutoff_unit");
					eff_status  = rset1.getString("eff_status")==null? "D":rset1.getString("eff_status");
					level1_description=rset1.getString("level_1_desc")==null?"":rset1.getString("level_1_desc");
					level1_codelength=rset1.getString("level_1_code_length")==null?"":rset1.getString("level_1_code_length");
					level2_description=rset1.getString("level_2_desc")==null?"":rset1.getString("level_2_desc");
					level2_codelength=rset1.getString("level_2_code_length")==null?"":rset1.getString("level_2_code_length");
					level3_description=rset1.getString("level_3_desc")==null?"":rset1.getString("level_3_desc");
					level3_codelength=rset1.getString("level_3_code_length")==null?"":rset1.getString("level_3_code_length");
					level4_description=rset1.getString("level_4_desc")==null?"":rset1.getString("level_4_desc");
					level4_codelength=rset1.getString("level_4_code_length")==null?"":rset1.getString("level_4_code_length");
					level5_description=rset1.getString("level_5_desc")==null?"":rset1.getString("level_5_desc");
					level5_codelength=rset1.getString("level_5_code_length")==null?"":rset1.getString("level_5_code_length");
					level6_description=rset1.getString("level_6_desc")==null?"":rset1.getString("level_6_desc");
					level6_codelength=rset1.getString("level_6_code_length")==null?"":rset1.getString("level_6_code_length");
					level7_description=rset1.getString("level_7_desc")==null?"":rset1.getString("level_7_desc");
					level7_codelength=rset1.getString("level_7_code_length")==null?"":rset1.getString("level_7_code_length");
					level8_description=rset1.getString("level_8_desc")==null?"":rset1.getString("level_8_desc");
					level8_codelength=rset1.getString("level_8_code_length")==null?"":rset1.getString("level_8_code_length");
					level9_description=rset1.getString("level_9_desc")==null?"":rset1.getString("level_9_desc");
					level9_codelength=rset1.getString("level_9_code_length")==null?"":rset1.getString("level_9_code_length");
					level10_description=rset1.getString("level_10_desc")==null?"":rset1.getString("level_10_desc");
					level10_codelength=rset1.getString("level_10_code_length")==null?"":rset1.getString("level_10_code_length");
					diag_classification=rset1.getString("diag_class_appl_yn")==null?"N":rset1.getString("diag_class_appl_yn");
					
					/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */
					inpatient_appl=rset1.getString("inpatient_appl_yn")==null? "N":rset1.getString("inpatient_appl_yn");
					daycare_appl=rset1.getString("daycare_appl_yn")==null? "N":rset1.getString("daycare_appl_yn");
					/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */

					diag_classification_mand=rset1.getString("diagnosis_class_mand_yn")==null?"N":rset1.getString("diagnosis_class_mand_yn"); //Added by Suji Keerthi for ML-MMOH-CRF-1395 on Dec-23,2020 
					
				}
			}
		

		}
		catch(Exception exp)
		{
			//out.println("Exception-285-"+exp.toString());
			exp.printStackTrace();
		}
		finally
		{
			if (stmt1 != null) stmt1.close();
			if (rset1 != null) rset1.close();
		}
		try
		{
			String sql_cnt="SELECT Count(*) FROM MR_DIAG_CLASS_DTL WHERE term_set_id=? ";
			stmt1=conn.prepareStatement(sql_cnt);
			stmt1.setString(1,termset_id);
			rset1=stmt1.executeQuery();
			if(rset1!=null)
			{
				while(rset1.next())
				{
					dtlcnt = rset1.getInt(1);
				}

			}
			
		}catch(Exception expdtl)
		{
			//out.println("Exception-310-"+expdtl.toString());
			expdtl.printStackTrace();
		}finally
			{
			if (stmt1 != null) stmt1.close();
			if (rset1 != null) rset1.close();
		}
		String level_descriptions="";
		String level_codelengths="";

		level_descriptions=level1_description+":"+level2_description+":"+level3_description+":"+level4_description+":"+level5_description+":"+level6_description+":"+level7_description+":"+level8_description+":"+level9_description+":"+level10_description;
		level_codelengths=level1_codelength+":"+level2_codelength+":"+level3_codelength+":"+level4_codelength+":"+level5_codelength+":"+level6_codelength+":"+level7_codelength+":"+level8_codelength+":"+level9_codelength+":"+level10_codelength;


		StringTokenizer st_desc=new StringTokenizer(level_descriptions,":");
		StringTokenizer st_code=new StringTokenizer(level_codelengths,":");
		/*Tuesday, February 01, 2011 , 26164*/
		int defnlevel = Integer.parseInt(defn_level);
		if(defnlevel != (st_code.countTokens()))
			defnlevel		= st_code.countTokens();

		defn_level		= new Integer(defnlevel).toString();
		/**/
		String editstatus="";
		String enablestatus="";
		String checkstatus="";

	
		String diag_spec_checkstatus="";
		String proc_spec_checkstatus="";
		String build_stat_checkstatus="";
		String build_eoc_checkstatus="";
		String priority_checkstatus="";
		String agegroup_checkstatus="";
		String nature_checkstatus="";
		String factors_checkstatus="";
		String notification_checkstatus="";
		String sensitivity_checkstatus="";
		String severity_checkstatus="";
		String onset_type_checkstatus="";
		String enc_stage_appl_checkstatus="";
		String diag_classification_appl_checkstatus="";

		/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */
		String inpatient_appl_checkstatus="";
		String daycare_appl_checkstatus="";
		/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */

		String diag_class_mand_chksts=""; //Added by Suji Keerthi for ML-MMOH-CRF-1395 on Dec-22,2020

		if(eff_status.equals("E"))
		{
			editstatus="";
			enablestatus="";
			checkstatus="checked";
		}
		else if(eff_status.equals("D"))
		{
			editstatus="readonly";
			enablestatus="disabled";
			checkstatus="";
		}
		
		if(free_txt_appl.equals("Y"))
			free_txt_appl_yn="checked";
		else if(free_txt_appl.equals("N"))
			free_txt_appl_yn="";

		if(appl_for_recoders.equals("Y"))
			appl_for_recoders_yn="checked";
		else if(appl_for_recoders.equals("N"))
			appl_for_recoders_yn="";


		if(diag_spec.equals("Y"))
			diag_spec_checkstatus="checked";
		else if(diag_spec.equals("N"))
			diag_spec_checkstatus="";

		if(proc_spec.equals("Y"))
			proc_spec_checkstatus="checked";
		else if(proc_spec.equals("N"))
			proc_spec_checkstatus="";

		if(build_stat.equals("Y"))
			build_stat_checkstatus="checked";
		else if(build_stat.equals("N"))
			build_stat_checkstatus="";

		if(build_eoc.equals("Y"))
			build_eoc_checkstatus="checked";
		else if(build_eoc.equals("N"))
			build_eoc_checkstatus="";

		
			
		if(priority.equals("Y"))
			priority_checkstatus="checked";
		else if(priority.equals("N"))
			priority_checkstatus="";

		if(agegroup.equals("Y"))
			agegroup_checkstatus="checked";
		else if(agegroup.equals("N"))
			agegroup_checkstatus="";

		if(nature.equals("Y"))
			nature_checkstatus="checked";
		else if(nature.equals("N"))
			nature_checkstatus="";
		
		

		if(factors.equals("Y"))
			factors_checkstatus="checked";
		else if(factors.equals("N"))
			factors_checkstatus="";

		if(notification.equals("Y"))
			notification_checkstatus="checked";
		else if(notification.equals("N"))
			notification_checkstatus="";

		if(sensitivity.equals("Y"))
			sensitivity_checkstatus="checked";
		else if(sensitivity.equals("N"))
			sensitivity_checkstatus="";

		if(severity.equals("Y"))
			severity_checkstatus="checked";
		else if(severity.equals("N"))
			severity_checkstatus="";

		if(onset_type.equals("Y"))
			onset_type_checkstatus="checked";
		else if(onset_type.equals("N"))
			onset_type_checkstatus="";
		

		if(enc_stage_appl.equals("Y"))
			enc_stage_appl_checkstatus="checked";
		else if(enc_stage_appl.equals("N"))
			enc_stage_appl_checkstatus="";
/*
		if(diag_classification.equals("Y"))
			diag_classification_appl="checked";
		else if(diag_classification.equals("N"))
			diag_classification_appl="";
			*/
			if(diag_classification.equals("Y"))
			diag_classification_appl_checkstatus="checked";
		else if(diag_classification.equals("N"))
			diag_classification_appl_checkstatus="";			
			
			

		if(dtlcnt != 0)
			{
				chk_appl="disabled";
			
			}
			else
			{
				chk_appl="";
			}
			//Added by KAMATCHI S for ML-MMOH-CRF-1581 START
			
			if(isEncounterStage) 
			{
				if(enc_stage_appl.equals("Y"))
				{
				 visibility_check= "inline";
				}
				else
				{
					visibility_check="none";
				}
					
				if(inpatient_appl.equals("Y"))
				inpatient_appl_checkstatus="checked";
				else
				inpatient_appl_checkstatus="";

				if(daycare_appl.equals("Y"))
				daycare_appl_checkstatus="checked";
				else
				daycare_appl_checkstatus="";
			}
			//Added by KAMATCHI S for ML-MMOH-CRF-1581 END
			
			//Below Added by Suji Keerthi for ML-MMOH-CRF-1395 on Dec-23,2020
			if(isDiagClassMand){
			if(diag_classification_mand.equals("Y"))
			diag_class_mand_chksts="checked";
		    else 
			diag_class_mand_chksts="";
			}
			//Ended by Suji Keerthi for ML-MMOH-CRF-1395 on Dec-23,2020 

		%>
		<table cellpadding='5' cellspacing=0 width="100%" border="0" align="center">
		<tr>		
		<td class="label" width='20%'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
		<td class='fields' width='80%'>
		<input type="text" name="TermSet_ID" id="TermSet_ID" value="<%=termset_id%>" size="20" maxlength="20" onBlur="ChangeUpperCase( this );" onKeyPress="return CheckForSpecChars(event);" readonly><img src="../../eCommon/images/mandatory.gif"></img>
		</td>		
		</tr>
		<tr>		
		<td class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<input type="text" name="TermSet_Desc" id="TermSet_Desc" value="<%=termset_desc%>" size="60" maxLength="60" onBlur="makeValidString(this);" <%=editstatus%>><img src="../../eCommon/images/mandatory.gif"></img>
		</td>		
		</tr>
		<tr>		
		<td class="label" ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='checkbox' name='eff_status_yn' id='eff_status_yn' <%=checkstatus%> <%if(termset_id.equals("OTH")){%>disabled<%}%>>
		</td>		
		</tr>
		</table>
		<table cellpadding='5' cellspacing=0 width="100%" border="0" align="center">
		<tr><td class="COLUMNHEADER" colspan="6"><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.Attributes.label" bundle="${common_labels}"/></td></tr>
		<tr>
		<td class="label" width='20%' ><fmt:message key="eMR.DiagnosisSpecific.label" bundle="${mr_labels}"/></td>
		<td class='fields' width='15%'><input type="checkbox" name="Diag_Spec_yn" id="Diag_Spec_yn" disabled <%=diag_spec_checkstatus%>></td>
		<td class="label" width='20%'><fmt:message key="eMR.ProcedureSpecific.label" bundle="${mr_labels}"/></td>
		<td class='fields' width='10%'><input type="checkbox" name="Proc_Spec_yn" id="Proc_Spec_yn" disabled  <%=proc_spec_checkstatus%>></td> 
		<td class="label" width='20%'><fmt:message key="eMR.BuildStatistics.label" bundle="${mr_labels}"/></td>
		<td class='fields' width='15%'><input type="checkbox" name="Build_Statistics_yn" id="Build_Statistics_yn" <%=enablestatus%> <%=build_stat_checkstatus%>></td>
		</tr>
		<tr>
		<td class="label" ><fmt:message key="eMR.BuildEpisodeofCare.label" bundle="${mr_labels}"/></td>
		<td class='fields'><input type="checkbox" name="Build_Episode_yn" id="Build_Episode_yn" <%=enablestatus%> <%=build_eoc_checkstatus%>></td>
		<td class="label" ><fmt:message key="eMR.ClassificationLevels.label" bundle="${mr_labels}"/></td>
		<td class='fields' colspan='3'><select name="Classification_Levels" id="Classification_Levels" onChange="Display_Level_Modify(this);" <%=enablestatus%>>
		<%

			String selectstatus="";
			for(int a=1;a<=10;a++)
			{
			   int defn_levels=Integer.parseInt(defn_level);
			   if(defn_levels==a)
				   selectstatus="selected";
			   else
				   selectstatus="";

		%>
		<option value="<%=a%>" <%=selectstatus%>><%=a%></option>
		<%
		}
		%>
		</select>
		</td>
		</tr>
		<tr><td class="COLUMNHEADER" colspan="6"><fmt:message key="eMR.TermCodeControl.label" bundle="${mr_labels}"/></td></tr>
		<tr>
		<!--<td class="label" ><fmt:message key="eMR.Notification.label" bundle="${mr_labels}"/></td>-->
		<td class="label" ><fmt:message key="Common.Notifiable.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="checkbox" name="Notification_yn" id="Notification_yn" <%=enablestatus%> <%=notification_checkstatus%>></td>

		<td class="label" ><fmt:message key="Common.Sensitive.label" bundle="${common_labels}"/>

	<!--	<td class="label" ><fmt:message key="eMR.Sensitivity.label" bundle="${mr_labels}"/></td>-->
		<td class='fields'><input type="checkbox" name="Sensitivity_yn" id="Sensitivity_yn" <%=enablestatus%> <%=sensitivity_checkstatus%>></td>
		<td class="label" ><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="checkbox" name="Age_Group_yn" id="Age_Group_yn" <%=enablestatus%> <%=agegroup_checkstatus%>></td>		
		</tr>
		<tr><td class="COLUMNHEADER" colspan="6"><fmt:message key="Common.general.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.Attributes.label" bundle="${common_labels}"/></td></tr>
		<tr>
		<td class="label" ><fmt:message key="eMR.DiagnosisNature.label" bundle="${mr_labels}"/></td>
		<td class='fields'><input type="checkbox" name="Diag_Nature_yn" id="Diag_Nature_yn" <%=enablestatus%> <%=nature_checkstatus%>></td>
		<td class="label" ><fmt:message key="Common.Severity.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="checkbox" name="Severity_yn" id="Severity_yn" <%=enablestatus%> <%=severity_checkstatus%>></td>
		<td class="label" ><fmt:message key="eMR.DiagnosisFactors.label" bundle="${mr_labels}"/></td>
		<td class='fields'><input type="checkbox" name="Diag_Factor_yn" id="Diag_Factor_yn" <%=enablestatus%> <%=factors_checkstatus%>></td>
		</tr>
		<tr><!--Condition Added by KAMATCHI S for ML-MMOH-CRF-1581-->

		<% if(!isEncounterStage || proc_spec.equals("Y")){%><td class="label" ><fmt:message key="eMR.EncounterStage.label" bundle="${mr_labels}"/></td>
		<td class='fields'><input type="checkbox" name="enc_stage_appl_yn" id="enc_stage_appl_yn" <%=enablestatus%> <%=enc_stage_appl_checkstatus%>></td><%}%>
		<td class="label" ><fmt:message key="eMR.OnsetType.label" bundle="${mr_labels}"/></td>
		<td class='fields'><input type="checkbox" name="Onset_Type_yn" id="Onset_Type_yn" <%=enablestatus%> <%=onset_type_checkstatus%>></td>
		<td class="label" ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="checkbox" name="Priority_yn" id="Priority_yn" <%=enablestatus%> <%=priority_checkstatus%>></td>
		</tr>
		<tr>
		<td class="label" ><fmt:message key="eMP.CutOffPeriod.label" bundle="${mp_labels}"/></td>
		<td class='fields'><input type="text" name="CutOff_Period" id="CutOff_Period" value="<%=cutoff_period%>" size="3" maxlength="3" onBlur="CheckNum(this);ModifyDisplay_Mandatory(this);CheckZero_CutOff(this)" onKeyPress="return allowValidNumber(this,event,3,0);" <%=editstatus%>></input></td>
		<%
			String disableSel="";
		
			if(cutoff_period.equals(""))
				disableSel="disabled";
			else
				disableSel="";

			%>

		<td class='fields'><select name="CutOff_Unit" id="CutOff_Unit" onChange="CheckCutoff();Cutoff_Change(this);" <%=enablestatus%> ><option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
		<%
		try
		{
		if(cutoff_units_rset!=null)
		{
			while(cutoff_units_rset.next())
			{
				durn_type=cutoff_units_rset.getString("durn_type");
				durn_desc=cutoff_units_rset.getString("durn_desc");

				String cutoff_value="";
				if(durn_type.equals(cutoff_unit))
					  cutoff_value="selected";
				else
					 cutoff_value="";
		%>
		<option value="<%=durn_type%>" <%=cutoff_value%>><%=durn_desc%></option>
		<%}}}catch(Exception exp){
			//out.println("Exception-566-"+exp.toString());
			exp.printStackTrace();
		}
		%>
		</select><img id="Cutoff_Mandatory1" src="../../eCommon/images/mandatory.gif" style="display:none"></img>
		</td>
		<!--Below Added by Suji Keerthi for ML-MMOH-CRF-1395 on Jan-06,2021-->
		<%if(isDiagClassMand){%>
		<TD class="label" >&nbsp</TD>
		<%}%>
		<!--Ended by Suji Keerthi for ML-MMOH-CRF-1395 on Jan-06,2021-->
		<td class='label' <%if(!isDiagClassMand){%>colspan = '2'<%}%> ><fmt:message key="eMR.DiagnosisClassificationApplicable.label" bundle="${mr_labels}"/></td>
		<td class='field'><input type="checkbox" name="diag_class_appl" id="diag_class_appl" <%=enablestatus%> <%=chk_appl%> <%=diag_classification_appl_checkstatus%>></td>
		</tr>

		<tr>
		<td class="label" ><fmt:message key="eMR.AppForRecoders.label" bundle="${mr_labels}"/></td>
		<%
			
			String diag_yn="";
			String proc_yn="";
			String recoder_status="";
			try
		{
			//String sql_termset=" SELECT Count(*)count  FROM MR_TERM_SET WHERE RECODERS_APPL_YN='Y'";
			String sql_termset="SELECT TERM_SET_ID,DIAG_SPEC_YN,PROC_SPEC_YN,RECODERS_APPL_YN FROM mr_term_set WHERE RECODERS_APPL_YN='Y'";

			stmt1=conn.prepareStatement(sql_termset);
			rset1=stmt1.executeQuery();
			if(rset1!=null)
			{
				while(rset1.next())
				{
					//count  = rset1.getString("count")==null? "0":rset1.getString("count");
					diag_yn  = rset1.getString("DIAG_SPEC_YN")==null? "":rset1.getString("DIAG_SPEC_YN");
					proc_yn  = rset1.getString("PROC_SPEC_YN")==null? "":rset1.getString("PROC_SPEC_YN");
					
					if(diag_spec.equals(diag_yn) || proc_spec.equals(proc_yn))
					{
						recoder_status="disabled";

					}
					//if(rset1!=null)
					

					}%>
					<td class='fields'><input type="checkbox" name="appl_for_recoders" id="appl_for_recoders" <%=recoder_status%> <%=appl_for_recoders_yn%>  ></td>
					
				<!-- 	PMG20099-CRF-0089-MR Free Text Enhance ment -->
				
				<%}
				if(diag_spec.equals("Y"))
				{
				%>
					<%if(!isDiagClassMand){%>
					<TD class="label" >&nbsp</TD>
					<%}%>
					
					<!--Ended by Suji Keerthi for ML-MMOH-CRF-1395 on Jan-06,2021-->
					<TD class="label"  <%if(!isDiagClassMand){%>colspan = '2'<%}%> ><fmt:message key="eMR.FreeTextApplicable.label" bundle="${mr_labels}"/></TD>
					<%
							
							if(stmt1!=null)stmt1.close();

							String sql_cnt="SELECT Count(*) FROM mr_term_set WHERE   FREE_TEXT_APPLICABLE_YN='Y' and TERM_SET_ID=?";
							stmt1=conn.prepareStatement(sql_cnt);
							stmt1.setString(1,termset_id);
							rset1=stmt1.executeQuery();
							if(rset1!=null)
							{
								while(rset1.next())
								{
									dtlcnt = rset1.getInt(1);
								}

							}
							
							if(dtlcnt != 0)
							{
								chk_appl="disabled";							
							}
							else
							{
								chk_appl="";
							}
							
						%>


					<td class='field'><input type="checkbox" name="free_txt_appl" id="free_txt_appl"  <%=free_txt_appl_yn%>  <%=chk_appl%>  <%=enablestatus%>></td>
				<%
				}
				else
				{%>
					<%if(isDiagClassMand){%>
					<TD class="label" colspan = '2'>&nbsp</TD>
					<%}%>
					<input type='hidden' name="free_txt_appl" id="free_txt_appl">
				<%}

		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
              if(stmt1!=null)stmt1=null;
              if(rset1!=null)rset1=null;
			}
		%>
		
		<!-- Below Added by Suji Keerthi for ML-MMOH-CRF-1395 on Dec-22,2020 -->
		<%if(isDiagClassMand && diag_spec.equals("Y")) { //Modified by Suji Keerthi for ML-MMOH-CRF-1395 US003 %>
			<td class='label'><fmt:message key="eMR.DiagnosisClassificationMandatory.label" bundle="${mr_labels}"/></td>
			<td class='field'><input type="checkbox" id='diagclass_mand' name="diagnosis_class_mand_yn" id="diagnosis_class_mand_yn" value="Y" <%=diag_class_mand_chksts%> <%=enablestatus%> ></td>
		<%}%>
		<!-- Ended by Suji Keerthi for ML-MMOH-CRF-1395 on Dec-22,2020 -->
		
		</tr>
		<!--Added by KAMATCHI S for ML-MMOH-CRF-1581 START-->
		<% 
		if(isEncounterStage && diag_spec.equals("Y") ){
		%>
		<tr>
		<td class="label" ><fmt:message key="eMR.EncounterStage.label" bundle="${mr_labels}"/></td> 
		<td class='fields'><input type="checkbox" id='enc_stg_app' name="enc_stage_appl_yn" id="enc_stage_appl_yn" <%=enablestatus%> <%=enc_stage_appl_checkstatus%>  onclick="ecounterStage(this);"></td>
		<td class="label" id="iplbl" style="display:<%=visibility_check%>"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></td>
		<td class='fields' id='ipchk' style="display:<%=visibility_check%>"><input type="checkbox"  name="inpatient_appl_yn" id="inpatient_appl_yn" value="Y" <%=enablestatus%> <%=inpatient_appl_checkstatus%> ></td>
		<td class="label" id="dclbl" style="display:<%=visibility_check%>"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></td> 
		<td class='fields' id='dchk' style="display:<%=visibility_check%>"><input type="checkbox" value="Y"  name="daycare_appl_yn" id="daycare_appl_yn" <%=enablestatus%> <%=daycare_appl_checkstatus%> ></td>
		</tr>
		<%}%>
		<!--Added by KAMATCHI S for ML-MMOH-CRF-1581 END-->

		</table>
		<table id="Classification_Level1" cellpadding="5" cellspacing="0" align="center" border="0" width="100%">
		<tr><td class="COLUMNHEADER" colspan="3"><fmt:message key="eMR.ClassificationLevelDetails.label" bundle="${mr_labels}"/></td></tr>
		<tr><td class="label" width='20%'></td><td class="label" width='65%' ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td><td class="label" width='15%'><fmt:message key="eMR.CodeLength.label" bundle="${mr_labels}"/></td></tr>
		<%
		
		int k=0;
		
		int defn_levels=Integer.parseInt(defn_level);
		while(st_desc.hasMoreElements()&& st_code.hasMoreElements())
		{
			for(k=1;k<=defn_levels;k++)
			{
				String desc=(String)st_desc.nextElement();
				String code=(String)st_code.nextElement();
			%>			
				<tr><td class="label" ><fmt:message key="Common.Level.label" bundle="${common_labels}"/> <%=k%></td>
				<td class='fields'><input type=text name="Description<%=k%>" id="Description<%=k%>" value="<%=desc%>" size="60" maxlength="60" <%=editstatus%>><img src="../../eCommon/images/mandatory.gif"></img></td>
				<td class='fields'><input type=text name="CodeLength<%=k%>" id="CodeLength<%=k%>" value="<%=code%>" size="2" maxlength="2" onBlur="CheckNum(this);CheckZero_Codelength(this)" onKeyPress="return allowValidNumber(this,event,2,0);" <%=editstatus%>><img src="../../eCommon/images/mandatory.gif"></img></td></tr>
			<%
			}
		}
		int defn=defn_levels+1;
		for(int a=defn;a<=10;a++)
		{
			%>
			<tr style="display:none"><td class="label" ><fmt:message key="Common.Level.label" bundle="${common_labels}"/> <%=a%></td>
			<td class='fields'><input type=text name="Description<%=a%>" id="Description<%=a%>" value="" size="60" maxlength="60" <%=editstatus%>><img src="../../eCommon/images/mandatory.gif"></img></td>
			<td class='fields'><input type=text name="CodeLength<%=a%>" id="CodeLength<%=a%>" value="" size="2" maxlength="2" onBlur="CheckNum(this);CheckZero_Codelength(this)" onKeyPress="return allowValidNumber(this,event,2,0);" <%=editstatus%>><img src="../../eCommon/images/mandatory.gif"></img></td></tr>
	<%	}	%>
		</table>
		<input type="hidden" name="classification_level" id="classification_level" value="<%=defn_level%>">
		<input type="hidden" name="classification_level1" id="classification_level1" value="<%=defn_level%>">
		<input type="hidden" name="cutoff_unit1" id="cutoff_unit1" value="<%=cutoff_unit%>">
		<input type="hidden" name="diag_spec" id="diag_spec" value="<%=diag_spec%>">
		<input type="hidden" name="proc_spec" id="proc_spec" value="<%=proc_spec%>">
		<input type="hidden" name="build_stat" id="build_stat" value="<%=build_stat%>">
		<input type="hidden" name="build_eoc" id="build_eoc" value="<%=build_eoc%>">
		<input type="hidden" name="priority" id="priority" value="<%=priority%>">
		<input type="hidden" name="agegroup" id="agegroup" value="<%=agegroup%>">
		<input type="hidden" name="nature" id="nature" value="<%=nature%>">
		<input type="hidden" name="factors" id="factors" value="<%=factors%>">
		<input type="hidden" name="notification" id="notification" value="<%=notification%>">
		<input type="hidden" name="sensitivity" id="sensitivity" value="<%=sensitivity%>">
		<input type="hidden" name="severity" id="severity" value="<%=severity%>">
		<input type="hidden" name="onset_type" id="onset_type" value="<%=onset_type%>">
		<input type="hidden" name="enc_stage" id="enc_stage" value="<%=enc_stage_appl%>">
		<input type="hidden" name="eff_status" id="eff_status" value="<%=eff_status%>">

		<input type="hidden" name="inpatient_appl" id="inpatient_appl" value="<%=inpatient_appl%>"><!--Added by KAMATCHI S for ML-MMOH-CRF-1581-->
		<input type="hidden" name="daycare_appl" id="daycare_appl" value="<%=daycare_appl%>"><!--Added by KAMATCHI S for ML-MMOH-CRF-1581-->
		<input type="hidden" name="isEnc" id="isEnc" value="<%=isEncounterStage%>"><!--Added by KAMATCHI S for ML-MMOH-CRF-1581-->
		<!--Below Added by Suji Keerthi for ML-MMOH-CRF-1395 on Dec-30,2020-->
		<input type="hidden" name="diag_class_mand_yn" id="diag_class_mand_yn" value="<%=diag_class_mand_yn%>">
		<input type="hidden" name="isDiag" id="isDiag" value="<%=isDiagClassMand%>">
        <input type="hidden" name="diag_classification_mand" id="diag_classification_mand" value="<%=diag_classification_mand%>">
		<!--Ended by Suji Keerthi for ML-MMOH-CRF-1395 on Dec-30,2020-->
				<%}
	%>
		<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
	<%
}
catch(Exception exp)
{
	//out.println("Exception-674-"+exp.getMessage());
	exp.printStackTrace();
}
finally
{
	if (cutoff_units_rset != null) cutoff_units_rset.close();
	if (rset1 != null) rset1.close();
	if (cutoff_units_stmt != null) cutoff_units_stmt.close();
	if (stmt1 != null) stmt1.close();
	ConnectionManager.returnConnection(conn,request);
}
%>
</form>
</body>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

