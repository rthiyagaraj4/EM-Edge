<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- Outcome.jsp -->
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Nikhil
*	Created On		:	15 Jan 2005

--%>
<%@page import='java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.Common.*' contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCP/js/CareplanParameter.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
  String jv_discr_msr_code = "";
  String jv_discr_msr_desc = "";
  String jv_reassess_code = "";
  String jv_reassess_desc = "";
  String jv_medn_admn_code = "";
  String jv_medn_admn_desc = "";
  String jv_acc_care_plans = "";

  Connection con = null;
  PreparedStatement ps = null;
  ResultSet rs = null;
  try
  {
  con = ConnectionManager.getConnection(request);
//  ps = con.prepareStatement("select a.module_id,a.multiple_lib_for_term_code_yn, a.multiple_lib_for_case_type_yn, a.discr_msr_for_dependency,b.long_desc discr_msr_desc, a.reassess_intervention_code,c.short_desc reassess_intervention_desc, a.medn_admn_intervention_code, d.short_desc medn_admn_intervention_desc, a.goal_defn_level,a.care_plan_scope,a.accuracy_for_care_plans from cp_parameter a, am_discr_msr b, ca_intervention c, ca_intervention d where a.discr_msr_for_dependency = b.discr_msr_id(+) and a.reassess_intervention_code = c.intervention_code(+) and a.medn_admn_intervention_code = d.intervention_code(+)");
  ps = con.prepareStatement("SELECT a.module_id,a.multiple_lib_for_term_code_yn, a.multiple_lib_for_case_type_yn, a.discr_msr_for_dependency,b.long_desc discr_msr_desc, a.reassess_intervention_code,c.short_desc reassess_intervention_desc, a.medn_admn_intervention_code, d.short_desc medn_admn_intervention_desc, a.goal_defn_level,a.care_plan_scope,a.accuracy_for_care_plans FROM cp_parameter a, am_discr_msr_lang_vw b, ca_intervention_lang_vw c, ca_intervention_lang_vw d WHERE a.discr_msr_for_dependency = b.discr_msr_id(+) AND b.language_id(+) = '"+locale+"' AND a.reassess_intervention_code = c.intervention_code(+) AND c.language_id(+) = '"+locale+"' AND a.medn_admn_intervention_code = d.intervention_code(+) AND d.language_id(+) = '"+locale+"'");
  rs = ps.executeQuery();
  while(rs.next())
  {
  jv_discr_msr_code = rs.getString(4)==null ? "":rs.getString(4);
  jv_discr_msr_desc = rs.getString(5)==null ? "":rs.getString(5);
  jv_reassess_code = rs.getString(6)==null ? "":rs.getString(6);
  jv_medn_admn_code = rs.getString(8)==null ? "":rs.getString(8);
  jv_medn_admn_desc = rs.getString(9)==null ? "":rs.getString(9);
  jv_acc_care_plans = rs.getString(12)==null? "":rs.getString(12);
  }
  }catch(Exception e)
  {
	  {out.print(e);}
  }finally
  {
	  if(rs!=null) {rs.close();}
	  if(ps!=null) { ps.close();}
	  ConnectionManager.returnConnection(con,request);  
  }	 

%>

 <body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >

 <form name="CareplanParameterAddModify_form" id="CareplanParameterAddModify_form" action="../../servlet/eCP.CareplanParameterServlet" method="post" target="messageFrame">
  <br><br><br><br>

  <table border="0" cellpadding="0" cellspacing="0" width="95%" align="center">

  <tr>
      <td colspan="5">&nbsp;</td>
  </tr>
  <input type=hidden name="term_code_yn" id="term_code_yn" value="Y">
  <input type=hidden name="case_type_yn" id="case_type_yn" value="Y">
  <input type=hidden name="goal_dfn_lvl" id="goal_dfn_lvl" value="T">
  <input type=hidden name="cp_scope" id="cp_scope" value="S">
  <input type="hidden" name="locale" id="locale" value="<%=locale%>">
  <tr>
	  <td align="right" class="label" width="40%"><fmt:message key="eCP.AccuracyforCarePlan.label" bundle="${cp_labels}"/></td>
	  <td align="left">&nbsp;&nbsp;
		<select name="cp_acc" id="cp_acc">
			<% if(jv_acc_care_plans.equals("C")){ %>
			<option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
			<option value="C" selected><fmt:message key="Common.Certain.label" bundle="${common_labels}"/></option>
			<option value="U"><fmt:message key="Common.Uncertain.label" bundle="${common_labels}"/></option>
			<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
			<% }else if(jv_acc_care_plans.equals("U")){ %>
			<option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
			<option value="C"><fmt:message key="Common.Certain.label" bundle="${common_labels}"/></option>
			<option value="U" selected><fmt:message key="Common.Uncertain.label" bundle="${common_labels}"/></option>
			<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
			<% }else if(jv_acc_care_plans.equals("B")){ %>
			<option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
			<option value="C"><fmt:message key="Common.Certain.label" bundle="${common_labels}"/></option>
			<option value="U"><fmt:message key="Common.Uncertain.label" bundle="${common_labels}"/></option>
			<option value="B" selected><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
			<% }else{ %>
			<option value="" selected>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
			<option value="C"><fmt:message key="Common.Certain.label" bundle="${common_labels}"/></option>
			<option value="U"><fmt:message key="Common.Uncertain.label" bundle="${common_labels}"/></option>
			<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>			
			<% } %>
		</select>&nbsp;
		<img src='../../eCommon/images/mandatory.gif'></img>
  </tr>
  
  <tr>
	  <td colspan="5">&nbsp;</td>
  </tr>

  <tr>
	  <td  align="right" class="label" width="40%"><fmt:message key="eCP.DiscreteMeasureforDependency.label" bundle="${cp_labels}"/></td>
	  <td  align="left" >&nbsp;&nbsp;&nbsp;<input type="text" name="discr_measure_desc" id="discr_measure_desc" 	 value="<%=jv_discr_msr_desc%>" size="30" maxlength="30" readonly >					 <input type='button' class='button' value='?' name='discr_button' id='discr_button'
		   onclick='comm_search(discr_measr_code,discr_measure_desc)'>&nbsp;
	       <img src='../../eCommon/images/mandatory.gif'></img>
		   <input type="hidden" name="discr_measr_code" id="discr_measr_code"  value='<%=jv_discr_msr_code%>'>
	  </td>
  </tr>

  <!-- <tr>
	  <td colspan="5">&nbsp;</td>
  </tr>

  <tr>
      <td  align="right" class="label" width="40%">Task for Reassessment</td>
      <td  align="left" >&nbsp;&nbsp;&nbsp;<input type="text" name="task_reass" id="task_reass" size="40" maxlength="60" value="<%=jv_reassess_desc%>" readonly>							<input type='button' class='button' value='?' name='reass_button' id='reass_button'	Onclick='comm_search(reassess_code,task_reass)'>								<input type="hidden" name="reassess_code" id="reassess_code" value='<%=jv_reassess_code%>'>
      </td>
  </tr> -->

  <tr>
      <td colspan="5">&nbsp;</td>
  </tr>

  <tr>
	  <td  align="right" class="label" width="40%"><fmt:message key="eCP.TaskforMedicationAdministration.label" bundle="${cp_labels}"/></td>
	  <td  align="left" >&nbsp;&nbsp;&nbsp;<input type = "text" name = "med_intv"         size="40" maxlength="60" value="<%=jv_medn_admn_desc%>" readonly>
	  <input type="button" class='button' value='?' name='discr_button' id='discr_button' onclick='comm_search(med_adm_code,med_intv)'>
      <input type="hidden" name="med_adm_code" id="med_adm_code" value='<%=jv_medn_admn_code%>'>
	  </td>
  </tr>
  <tr>
	  <td colspan="5">&nbsp;</td>
  </tr>
   </table>
  </Form>
</body>
</html>

