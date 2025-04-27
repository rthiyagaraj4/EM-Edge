<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="adverseReaction1" class="webbeans.eCommon.RecordSet" scope="session"/>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
  <script language="javascript" src="../../eCommon/js/common.js" ></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
  <script language='javascript' src='../../eCommon/js/messages.js' ></script>
<!--   <script language='javascript' src='../../eMR/js/eMRmessages.js' ></script> -->
  <script language='javascript' src='../../eCommon/js/common.js' ></script>
  <script language='javascript' src='../../eCommon/js/dchk.js' ></script>
  <script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
 <script language='javascript' src="../../eMR/js/RecordPatientAdverseEvent.js"></script>
    <script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>

</head>
<%
  Connection con = ConnectionManager.getConnection(request);
  ResultSet rs = null;
  Statement stmt = null;
  ResultSet rs1 = null;
  Statement stmt1 = null;
  ResultSet rs2 = null;
  Statement stmt2 = null;

	try 
	{
		String locale = (String)session.getAttribute("LOCALE");
		stmt=con.createStatement();
		stmt1=con.createStatement();
		stmt2=con.createStatement();
		String aller_test_results=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PatientObservation.label","mr_labels");
		
		String PatientId=request.getParameter("PatientId");
		if(PatientId ==null) PatientId="";
		String Encounter_Id=request.getParameter("Encounter_Id")==null?"":request.getParameter("Encounter_Id");
		String mode=request.getParameter("mode");
		if(mode ==null) mode="insert";
		String reaction_date1=request.getParameter("reaction_date");
		if(reaction_date1 ==null) reaction_date1="";
		String adv_event_dtl_srl_no="";
		
		String causative_code=request.getParameter("causative_code");
		if(causative_code ==null) causative_code="";
		String react_values1=request.getParameter("react_values1");
		if(react_values1 ==null) react_values1="";
		String source_of_info=request.getParameter("source_of_info");
		if(source_of_info ==null) source_of_info="";
		String row_id=request.getParameter("row_id");
		if(row_id ==null) row_id="";
		String Certainity=request.getParameter("Certainity");
		if(Certainity ==null) Certainity="";
		String flag=request.getParameter("flag");
		if(flag ==null) flag="";
		String adv_event_type_code=request.getParameter("adv_event_type_code");
		if(adv_event_type_code ==null) adv_event_type_code="";
		String causative_substance=request.getParameter("causative_substance");
		if(causative_substance ==null) causative_substance="";
		String severity_code=request.getParameter("severity_code");
		if(severity_code ==null) severity_code="";
		String final_reac_code_val=request.getParameter("final_reac_code_val");
		if(final_reac_code_val ==null) final_reac_code_val="";
		String active_date=request.getParameter("active_date");
		if(active_date ==null) active_date="";
		String adv_event_type_ind_code=request.getParameter("adv_event_type_ind_code");
		String diagnosis_code=request.getParameter("diagnosis_code");
		if(diagnosis_code ==null) diagnosis_code="";
		String term_code=request.getParameter("term_code");
		if(term_code ==null) term_code="";
		String sys_date_time="",causitive_sub="",exposure="",severity1="",other_reaction1="",reaction_site="",Sour_Of_Reac1="",allergy_test_res1="",treat_advice1="",remarks1="",react_code_val="", react_code_prev="",final_reac_val="";
		String diag_desc="",causitive_desc="";
		String sql="select to_char(sysdate,'dd/mm/yyyy') SystemDate from dual";
		rs=stmt.executeQuery(sql);
		if(rs.next())
		{
			sys_date_time=rs.getString("SystemDate");
			
		}
		if(rs !=null) rs.close();



if(!mode.equals("insert") )
		{
			if(!adv_event_type_code.equals("DA"))
			{
			String sql3="select ALLERGEN_CODE ,LONG_DESC longdesc from MR_ALLERGEN_LANG_VW where allergen_code='"+causative_code+"' and language_id='"+locale+"'";
			rs = stmt.executeQuery(sql3) ;	
			if(rs !=null && rs.next())
				{
					//causitive_code1=rs.getString("ALLERGEN_CODE");
					causitive_desc=rs.getString("longdesc");
				}
			}else
			{
				String sql3=" select GENERIC_ID ,GENERIC_NAME longdesc from PH_GENERIC_NAME_LANG_VW where GENERIC_ID='"+causative_code+"' and language_id='"+locale+"'";
			if(rs!=null)rs.close();
			rs = stmt.executeQuery(sql3) ;	
			if(rs !=null && rs.next())
				{
					//causitive_code1=rs.getString("GENERIC_ID");
					causitive_desc=rs.getString("longdesc");
				}

			}
		if(rs!=null)rs.close();
		
				String sql_dia_code="select long_desc from MR_ICD_CODE where DIAG_CODE='"+diagnosis_code+"'";
				rs = stmt.executeQuery(sql_dia_code) ;
				if(rs !=null && rs.next())
				{
					diag_desc=rs.getString("long_desc");
					if(diag_desc ==null) diag_desc="";
				}
			if(!term_code.equals("") )
			{
			String sql_dia_desc="select long_desc from mr_term_code where term_set_id='"+term_code+"' and term_code='"+diagnosis_code+"' ";
					rs=stmt.executeQuery(sql_dia_desc);
					if(rs !=null && rs.next())
					{
					diag_desc=rs.getString("long_desc");
					if(diag_desc ==null) diag_desc="";
					}

			}
			
		}
		//out.println("<script>alert(\""+mode+"\");</script>");
		//if(mode.equals("modify")).
		if(mode.equals("modify") || mode.equals("record"))
		{
			//String get_data="select a.CAUSATIVE_SUBSTANCE,a.ROUTE_OF_EXPOSURE,b.SEVERITY,b.OTHERS_REACTION,b.REACTION_SITE,a.INFORMATION_SOURCE,a.ALLERGY_TEST_RESULT,a.TREATMENT_ADVICE,a.REMARKS from PR_ADVERSE_EVENT a, PR_ADVERSE_EVENT_REACTION b where patient_id='"+PatientId+"' and b.REACTION_DATE=to_date('"+reaction_date1+"','dd/mm/yyyy hh24:mi') and ALLERGEN_CODE='"+causative_code+"' and a.patient_id=b.patient_id and a.ALLERGEN_CODE=b.ALLERGEN_CODE";

			String get_data="select a.CAUSATIVE_SUBSTANCE,a.ROUTE_OF_EXPOSURE,b.SEVERITY,b.OTHERS_REACTION,b.REACTION_SITE,a.INFORMATION_SOURCE,a.ALLERGY_TEST_RESULT,a.TREATMENT_ADVICE,a.REMARKS from PR_ADVERSE_EVENT a, PR_ADVERSE_EVENT_REACTION b where a.patient_id='"+PatientId+"' and b.REACTION_DATE=to_date('"+reaction_date1+"','dd/mm/yyyy hh24:mi') and a.ALLERGEN_CODE='"+causative_code+"' and a.patient_id=b.patient_id and a.ALLERGEN_CODE=b.ALLERGEN_CODE";

			//out.println("<script>alert(\""+get_data+"\");</script>");
			rs1=stmt1.executeQuery(get_data);
			if(rs1 !=null )
			{
				while(rs1.next())
				{
				 causitive_sub=rs1.getString("CAUSATIVE_SUBSTANCE");
				 if(causitive_sub ==null) causitive_sub="";
				 exposure=rs1.getString("ROUTE_OF_EXPOSURE");
				 if(exposure ==null) exposure="";
				 severity1=rs1.getString("SEVERITY");
				 if(severity1 ==null)severity1="";
				 other_reaction1=rs1.getString("OTHERS_REACTION");
				 if(other_reaction1 ==null) other_reaction1="";
				 reaction_site=rs1.getString("REACTION_SITE");
				 if(reaction_site ==null) reaction_site="";
				 Sour_Of_Reac1=rs1.getString("INFORMATION_SOURCE");
				 if(Sour_Of_Reac1 ==null) Sour_Of_Reac1="";
				 allergy_test_res1=rs1.getString("ALLERGY_TEST_RESULT");
				 if(allergy_test_res1 ==null)allergy_test_res1="";
				 treat_advice1=rs1.getString("TREATMENT_ADVICE");
				 if(treat_advice1 ==null) treat_advice1="";
				 remarks1=rs1.getString("REMARKS");
				 if(remarks1 ==null) remarks1="";
				
				}
			}
			if(adv_event_type_code.equals("DA"))
				{
					causitive_sub=causative_substance;
				}
				int s=0;
				if(rs !=null) rs.close();
			//String srl_num="select ADV_EVENT_DTL_SRL_NO from pr_adverse_event  where reaction_date = TO_DATE ('"+reaction_date1+"', 'dd/mm/yyyy hh24:mi') and ALLERGEN_CODE='"+causative_code+"'";	
			String srl_num="select ADV_EVENT_DTL_SRL_NO from pr_adverse_event_reaction  where reaction_date = TO_DATE ('"+reaction_date1+"', 'dd/mm/yyyy hh24:mi') and ALLERGEN_CODE='"+causative_code+"'";	
			rs=stmt.executeQuery(srl_num);
		if( rs !=null && rs.next())
		{
			adv_event_dtl_srl_no=rs.getString("ADV_EVENT_DTL_SRL_NO");
			if(adv_event_dtl_srl_no ==null) adv_event_dtl_srl_no="";
		}

			//String reac_val=" select a.ADV_REAC_CODE ,c.long_desc reac_desc FROM pr_adverse_event_reaction a, pr_adverse_event b, AM_REACTION_LANG_VW c where  a.PATIENT_ID='"+PatientId+"' and a.ALLERGEN_CODE='"+causative_code+"'  and b.reaction_date = TO_DATE ('"+reaction_date1+"', 'dd/mm/yyyy hh24:mi') and a.ALLERGEN_CODE=b.ALLERGEN_CODE and c.language_id='"+locale+"' and b.ADV_EVENT_DTL_SRL_NO='"+adv_event_dtl_srl_no+"'  and a.ADV_EVENT_DTL_SRL_NO=b.ADV_EVENT_DTL_SRL_NO  and a.ADV_REAC_CODE=c.REACTION_CODE ";

			//out.println("<script>alert(\""+reac_val+"\");</script>");

			String reac_val=" select a.ADV_REAC_CODE ,c.long_desc reac_desc FROM pr_adverse_event_reaction a, AM_REACTION_LANG_VW c where  a.PATIENT_ID='"+PatientId+"' and a.ALLERGEN_CODE='"+causative_code+"'  and a.reaction_date = TO_DATE ('"+reaction_date1+"', 'dd/mm/yyyy hh24:mi') and c.language_id='"+locale+"' and a.ADV_EVENT_DTL_SRL_NO='"+adv_event_dtl_srl_no+"'  and a.ADV_REAC_CODE=c.REACTION_CODE ";		

			rs2=stmt2.executeQuery(reac_val);
			if(rs2 !=null)
			{
				while(rs2.next())
				{
					react_code_val=rs2.getString("ADV_REAC_CODE");
					if(!react_code_val.equals(react_code_prev))
					{
						final_reac_val=react_code_val+"@";
					}
					adverseReaction1.putObject(final_reac_val);
					react_code_prev	=rs2.getString("ADV_REAC_CODE");
					
				s++;
				}
			}

		}else if(mode.equals("insert")){
				 causitive_sub="";
				 exposure="";
				 severity1="";
				 other_reaction1="";
				 reaction_site="";
				 Sour_Of_Reac1="";
				 allergy_test_res1="";
				 treat_advice1="";
				 remarks1="";

			}


				
%>

<body  <%if(mode.equals("record")){%>onload='setTimeout("disable()",500);default_value();'<%}else{%>onload='default_value();'<%}%> OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>

 <form name = 'detail_form' >
	
  <table cellpadding='0'  border='0' cellspacing='0' width='100%' align='center' >
	<th align='left' colspan='4' nowrap><fmt:message key="Common.additionaldetails.label" bundle="${common_labels}"/></th>
		
		<tr>	
				<% if(mode.equals("insert")){ %>
				
				<td class='label' width='20%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
				<td class='fields'  width='30%'>
					<input type=radio name='active' id='active' checked value='A' onclick='change_val_status(this)'><fmt:message key="Common.active.label" bundle="${common_labels}"/></input>
				</td>
				<%}else{%>
					<td class='label' width='20%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
					<td class='fields'  width='30%'>
					<input type=radio name='active' id='active' checked value='A' onclick='change_val_status(this)'><fmt:message key="Common.active.label" bundle="${common_labels}"/></input>
					<input type=radio name='resolve' id='resolve'   value='R' onclick='change_val_status(this)'><fmt:message key="Common.Resolved.label" bundle="${common_labels}"/></input>
					<input type=radio name='inerror' id='inerror'  value='E' onclick='change_val_status(this)'><fmt:message key="Common.InError.label" bundle="${common_labels}"/></input>
				</td>
				<%}%>
				
				<td class='label'  id='status_date'  width='25%'><fmt:message key="Common.since.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'  >
				<%
					String sys_date_time_disply=DateUtils.convertDate(sys_date_time,"DMY","en",locale);
				
					
					%>
					<%if(mode.equals("insert")){%>
					<input type='text'  name='date_time' id='date_time' value='<%=sys_date_time_disply%>'   id='modify_date' onblur="CompareRegnDate1(this,document.forms[0].sys_date_time);" maxlength="16" size="14"><img id='date_time_cal' src="../../eCommon/images/CommonCalendar.gif"  onClick="document.getElementById("date_time").select();return showCalendar('modify_date',null);"/><img src="../../eCommon/images/mandatory.gif"  align='center'></img>
					<%}else {
						String active_date_display=DateUtils.convertDate(active_date,"DMY","en",locale);%>
						<input type='text'  name='date_time' id='date_time' value='<%=active_date_display%>'  disabled id='modify_date' onblur="CompareRegnDate1(this,document.forms[0].sys_date_time);" maxlength="16" size="14"><img disabled id='date_time_cal' src="../../eCommon/images/CommonCalendar.gif"  onClick="document.getElementById("date_time").select();return showCalendar('modify_date',null);"/>
					<%}%>
					</td>
		</tr>

		<tr id='error_reason' Style="display:none;visibility:hidden">
				<td class='label' id='status_val' width='20%' ><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
				<td class='fields' colspan='3'  id='status_val2'>
				<textarea name='err_remark' onkeypress="return imposeMaxLength(this, 30);"  rows='1' cols='30' ></textarea></td>
		</tr>

		<tr>
				<td  class="label" width='20%'><fmt:message key="eMR.Certanity.label" bundle="${mr_labels}"/></td>
				<td  class="oaBorder" width='30%'><input type=radio name='definit' id='definit' checked value='D' onclick='change_val(this)'><fmt:message key="Common.Definitive.label" bundle="${common_labels}"/><input type=radio name='probable' id='probable' Value='P' onclick='change_val(this)'><fmt:message key="Common.Probable.label" bundle="${common_labels}"/></td>

				<td class='label' width='25%'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'><input type='text' name='diagnosis' id='diagnosis' maxlength='30' size='30' value='<%=diag_desc%>' ><input type='button' class='button' name='cause_diag_search' id='cause_diag_search'  value='?' onclick='openDiagnosis()'><input type='hidden' name='diagnosis_code' id='diagnosis_code' value='<%=diagnosis_code%>'><input type='hidden' name='term_code' id='term_code' value='<%=term_code%>'></td>
		 </tr>

			<td  class='label' width='20%'><fmt:message key="Common.RouteofExposure.label" bundle="${common_labels}"/></td>
			<td class='fields' width='30%'><select name='route_exp' id='route_exp'>
			<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<option value='1'><fmt:message key="eMR.Ingestion.label" bundle="${mr_labels}"/></option>
			<option value='2'><fmt:message key="eMR.Inhalation.label" bundle="${mr_labels}"/></option>
			<option value='3'><fmt:message key="eMR.Injection.label" bundle="${mr_labels}"/></option>
			<option value='4'><fmt:message key="eMR.Tropical.label" bundle="${mr_labels}"/></option>
			<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
			</select></td>
			
			<td  class='label' colspan='2'>&nbsp;</td>

		</tr>

	   <tr>
			<td class='label' width='20%' ><fmt:message key="eMR.SourceOfInfo.label" bundle="${mr_labels}"/></td>
			<td  class="fields" colspan='3'>
			<input type=radio name='pat_obser' id='pat_obser'  <%--if(!mode.equals("record")){--%>checked<%--} --%> value='P' onclick='change_val_two(this)'><fmt:message key="eMR.PatientObservation.label" bundle="${mr_labels}"/>
			<input type=radio name='aller_test' id='aller_test' value='A' onclick='change_val_two(this)'><fmt:message key="eMR.AllergyTestResult.label" bundle="${mr_labels}"/>
			<input type=radio name='Staff_obser' id='Staff_obser' value='S' onclick='change_val_two(this)'><fmt:message key="eMR.StaffObservation.label" bundle="${mr_labels}"/></td>
			
	 </tr>
     <tr>
			<td class='label' id='aller_test_results' width='20%'><%=aller_test_results%></td>
			<td class='fields' colspan='3'><textarea name='allergy_test_res'  maxlength="25" rows='1' cols='85'  value='' onblur = 'checkMaxLimit(this);' onkeypress="return imposeMaxLength(this, 100);"><%=allergy_test_res1%></textarea></td>
	</tr>
	<tr>
			<td class='label' width='20%'><fmt:message key="eMR.TreatAdviceActionTaken.label" bundle="${mr_labels}"/></td>
			<td class='fields' colspan='3'><textarea name='treat_advice'  maxlength="25" rows='1' cols='85' value='' onblur = 'checkMaxLimit(this);' onkeypress="return imposeMaxLength(this, 100);" ><%=treat_advice1%></textarea></td>
	</tr>
	<tr>
			<td class='label' width='20%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td class='fields' colspan='3'><textarea name='remarks' maxlength="25" rows='1' cols='85' value='' onblur = 'checkMaxLimit(this);' onkeypress="return imposeMaxLength(this, 100);" ><%=remarks1%></textarea></td>
	</tr>
		
		
</table>
	
			<input type='hidden' name='adv_evnt_ind' id='adv_evnt_ind' value=''> 
		    <input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='react_values1' id='react_values1' value='<%=react_values1%>'>
			<input type='hidden' name='row_id' id='row_id' value='<%=row_id%>'>
			<input type='hidden' name='sysdate' id='sysdate' value='<%=sys_date_time%>'>
			<input type='hidden' name='PatientId' id='PatientId' value='<%=PatientId%>'>
			<input type='hidden' name='causative_code' id='causative_code' value='<%=causative_code%>'>
			<input type='hidden' name='reaction_date1' id='reaction_date1' value='<%=reaction_date1%>'>
			<input type='hidden' name='adv_event_dtl_srl_no' id='adv_event_dtl_srl_no' value='<%=adv_event_dtl_srl_no%>'>
			<input type='hidden' name='severity1' id='severity1' value='<%=severity1%>'>
			<input type='hidden' name='source_of_info' id='source_of_info' value='<%=Sour_Of_Reac1%>'>
			<input type='hidden' name='Encounter_Id' id='Encounter_Id' value='<%=Encounter_Id%>'>
			<input type='hidden' name='react_values3' id='react_values3' value=''>
			<input type='hidden' name='causitive_sub' id='causitive_sub' value='<%=causitive_sub%>'>
			<input type='hidden' name='treat_advice1' id='treat_advice1' value='<%=treat_advice1%>'>
			<input type='hidden' name='remarks1' id='remarks1' value='<%=remarks1%>'>
			<input type='hidden' name='allergy_test_res1' id='allergy_test_res1' value='<%=allergy_test_res1%>'>
			<input type='hidden' name='reaction_site' id='reaction_site' value='<%=reaction_site%>'>
			<input type='hidden' name='other_reaction1' id='other_reaction1' value='<%=other_reaction1%>'>
			<input type='hidden' name='exposure1' id='exposure1' value='<%=exposure%>'>
			<input type='hidden' name='duplicate' id='duplicate' value=''>
			<input type='hidden' name='sou_of_info' id='sou_of_info' value=''>
			<input type='hidden' name='react_values_main' id='react_values_main' value=''> 
			<input type="hidden" name="certainity" id="certainity" value="<%=Certainity%>" >
			<input type="hidden" name="severity_head" id="severity_head" value="" > 
			<input type="hidden" name="adv_event_ind" id="adv_event_ind" value="" >
			<input type="hidden" name="adv_event_type" id="adv_event_type" value="" >
			<input type="hidden" name="allergen" id="allergen" value="" >
			<input type="hidden" name="onset_date" id="onset_date" value="" >
			<input type='hidden' name='status1' id='status1' value=''>
			<input type='hidden' name='err_remarks' id='err_remarks' value=''>
			<input type='hidden' name='flag' id='flag' value='<%=flag%>'>
			<input type='hidden' name='allergen_id' id='allergen_id' value=''>
			<input type='hidden' name='cause_sub' id='cause_sub' value=''>
			
			<input type='hidden' name='drug_code' id='drug_code' value=''>
			<input type='hidden' name='severity_code' id='severity_code' value='<%=severity_code%>'>
			<input type='hidden' name='final_reac_code_val' id='final_reac_code_val' value='<%=final_reac_code_val%>'>
		<input type='hidden' name='adv_event_type_code' id='adv_event_type_code' value='<%=adv_event_type_code%>'>
		<input type='hidden' name='adv_event_type_ind_code' id='adv_event_type_ind_code' value='<%=adv_event_type_ind_code%>'>



	 <%
     } catch(Exception e) {
		 e.printStackTrace();
         // out.println(e.toString());
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
		   if (rs1 != null) rs1.close();
          if (stmt1 != null) stmt1.close();
		   if (rs2 != null) rs2.close();
          if (stmt2 != null) stmt2.close();
     }
     finally {
         if (rs != null) rs.close();
          if (stmt != null) stmt.close();
		   if (rs1 != null) rs1.close();
          if (stmt1 != null) stmt1.close();
		   if (rs2 != null) rs2.close();
          if (stmt2 != null) stmt2.close();
		  ConnectionManager.returnConnection(con,request);
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

