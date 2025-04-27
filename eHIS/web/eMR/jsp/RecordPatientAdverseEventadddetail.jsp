<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="adverseReaction1" class="webbeans.eCommon.RecordSet" scope="session"/>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); request.setCharacterEncoding("UTF-8"); %>
<title><fmt:message key="Common.EventType.label" bundle="${common_labels}"/>
<fmt:message key="Common.details.label" bundle="${common_labels}"/>
</title>

<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
  <script language="javascript" src="../../eCommon/js/common.js" ></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
  <script language='javascript' src='../../eCommon/js/messages.js' ></script>
  <!-- <script language='javascript' src='../../eMR/js/eMRmessages.js' ></script> -->
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
			String aller_test_results1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AllergyTestResult.label","mr_labels");	
		String aller_test_results2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.StaffObservation.label","mr_labels");

		String PatientId=request.getParameter("patient_id");
		if(PatientId ==null) PatientId="";

		String Encounter_Id=request.getParameter("Encounter_Id")==null?"":request.getParameter("Encounter_Id");
		String Locn_Code=request.getParameter("Locn_Code")==null?"":request.getParameter("Locn_Code");
		String location_type=request.getParameter("location_type")==null?"":request.getParameter("location_type");
		String speciality_code=request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");

		String mode=request.getParameter("mode");
		if(mode ==null) mode="insert";
		String reaction_date1=request.getParameter("reaction_date");
		if(reaction_date1 ==null) reaction_date1="";
		reaction_date1=java.net.URLDecoder.decode(reaction_date1);
		String adv_event_dtl_srl_no="";
		
		String causative_code=request.getParameter("causative_code");
		if(causative_code ==null) causative_code="";

		String react_values1=request.getParameter("react_values1");
		if(react_values1 ==null) react_values1="";
		String source_of_info=request.getParameter("source_of_info");
		if(source_of_info ==null) source_of_info="";
		String row_id=request.getParameter("row_id");
		if(row_id ==null) row_id="";
		String Certainity_db=request.getParameter("Certainity");
		if(Certainity_db ==null) Certainity_db="";
		String flag=request.getParameter("flag");
		if(flag ==null) flag="";
		String adv_event_type_code=request.getParameter("adv_event_type_code");
		if(adv_event_type_code ==null) adv_event_type_code="";

		String causative_substance=request.getParameter("causative_substance");
		if(causative_substance ==null) causative_substance="";
		causative_substance=java.net.URLDecoder.decode(causative_substance);

		String severity_code=request.getParameter("severity_code");
		if(severity_code ==null) severity_code="";
		boolean session_available=false;

		String final_reac_code_val=request.getParameter("final_reac_code_val");
		if(final_reac_code_val ==null) final_reac_code_val="";

		String active_date=request.getParameter("active_date");
		if(active_date ==null) active_date="";
		active_date=java.net.URLDecoder.decode(active_date);

/*10/11/2008  ICN 5810.1*/
		String resolved_date=request.getParameter("resolved_date");
		if(resolved_date ==null) resolved_date="";
		resolved_date=java.net.URLDecoder.decode(resolved_date);

		String inerror_date=request.getParameter("inerror_date");
		if(inerror_date ==null) inerror_date="";
		inerror_date=java.net.URLDecoder.decode(inerror_date);
/*10/11/2008 ICN 5810.1*/

		String adv_event_type_ind_code=request.getParameter("adv_event_type_ind_code");
		String diagnosis_code=request.getParameter("diagnosis_code");
		if(diagnosis_code ==null) diagnosis_code="";
		diagnosis_code=java.net.URLDecoder.decode(diagnosis_code);

		String diag_desc=request.getParameter("diag_desc");
		if(diag_desc ==null) diag_desc="";
		diag_desc=java.net.URLDecoder.decode(diag_desc);

	String adv_event_type=request.getParameter("adv_event_type");
		if(adv_event_type ==null) adv_event_type="";


		String term_code=request.getParameter("term_code");
		if(term_code ==null) term_code="";
		String sys_date_time="",causitive_sub="",exposure="",severity1="",other_reaction1="",reaction_site="",Sour_Of_Reac1="",allergy_test_res1="",treat_advice1="",remarks1="",ckecked_status1="",ckecked_status2="",ckecked_status3="",ckecked_status2_db="",ckecked_status1_db="",ckecked_status3_db="",status1="",Certainity="",override_chk_val_db="",override_chk_val1_db="",source_chk="",source_chk1="",source_chk2="",err_remark="",disable_all="",term_short_desc="",termcode="",since_date1="";
		
		String Pract_id=request.getParameter("Pract_id");
		if(Pract_id ==null) Pract_id="";

		String practitioner_type=request.getParameter("practitioner_type");
		if(practitioner_type==null) practitioner_type="";

		String patient_class=request.getParameter("patient_class")==null?"":request.getParameter("patient_class");

		String diagnosis_code_db=request.getParameter("diagnosis_code_db")==null?"":request.getParameter("diagnosis_code_db");
		

		String active_diag_cnt=request.getParameter("active_diag_cnt")==null?"":request.getParameter("active_diag_cnt");
		String Dob=request.getParameter("Dob")==null?"":request.getParameter("Dob");

String status_db=request.getParameter("status_db");
		if(status_db ==null) status_db="";

		if(!status_db.equals("Active"))
			disable_all = "disabled";
		else
			disable_all = "";

		String details_code=(String) session.getValue("DETAILS_CODE");

		if(details_code==null){
			details_code="";
			session_available=true;
		}






	String since_date=request.getParameter("since_date");
	if(since_date ==null) since_date="";
	since_date1=request.getParameter("since_date");
	if(since_date1 ==null) since_date1="";
	String route_of_expo=request.getParameter("route_of_expo");
	if(route_of_expo ==null) route_of_expo="";
	String allergy_test_res=request.getParameter("allergy_test_res");
	if(allergy_test_res ==null) allergy_test_res="";
	String treat_advice=request.getParameter("treat_advice");
	if(treat_advice ==null) treat_advice="";
	String remarks=request.getParameter("remarks");
	if(remarks ==null) remarks="";
	String err_remark_db = request.getParameter("err_remark_db");
	if(err_remark_db == null) err_remark_db = "";
	//String  flag1="";
	String onset_date=request.getParameter("onset_date_time");
	if(onset_date ==null) onset_date="";
	onset_date=java.net.URLDecoder.decode(onset_date);
	
	String onset_date1=request.getParameter("onset_date");
	if(onset_date1 ==null) onset_date1="";
	onset_date1=java.net.URLDecoder.decode(onset_date1);

	String changeonsetflag = request.getParameter("changeonsetflag");
	if(changeonsetflag ==null) changeonsetflag="N";

if(!details_code.equals("") || !details_code.equals(null))
		{
	StringTokenizer details_val= new StringTokenizer(details_code,"^");
	while(details_val.hasMoreTokens())
	{
	     status1=details_val.nextToken();
		if(!status1.equals("E"))
		{
	     since_date1=details_val.nextToken();
		 if(since_date1!=null && since_date1.equals("dd")){
			 since_date1="";
		 }
		 Certainity=details_val.nextToken();
		 diagnosis_code=details_val.nextToken();
		 
		 route_of_expo=details_val.nextToken();
		 source_of_info=details_val.nextToken();
		 allergy_test_res=details_val.nextToken();
	     treat_advice=details_val.nextToken();
		 remarks=details_val.nextToken();
		}
		else
		{
			err_remark=details_val.nextToken();
			since_date1=details_val.nextToken();
			if(since_date1!=null && since_date1.equals("dd")){
				since_date1="";
			}
			Certainity=details_val.nextToken();
			 diagnosis_code=details_val.nextToken();
			 
			 route_of_expo=details_val.nextToken();
			 source_of_info=details_val.nextToken();
			 allergy_test_res=details_val.nextToken();
			 treat_advice=details_val.nextToken();
			 remarks=details_val.nextToken();
		}
	} 
	}
	
				
	String sql="select to_char(sysdate,'dd/mm/yyyy') SystemDate from dual";
		rs=stmt.executeQuery(sql);
		if(rs.next())
		{
			sys_date_time=rs.getString("SystemDate");
			
		}
		if(rs !=null) rs.close();



		if(mode.equals("modify") || mode.equals("record"))
		{

			//String get_data="select a.CAUSATIVE_SUBSTANCE,a.ROUTE_OF_EXPOSURE,b.SEVERITY,b.OTHERS_REACTION,b.REACTION_SITE,a.INFORMATION_SOURCE,a.ALLERGY_TEST_RESULT,a.TREATMENT_ADVICE,a.REMARKS from PR_ADVERSE_EVENT a, PR_ADVERSE_EVENT_REACTION b where a.patient_id='"+PatientId+"' and b.REACTION_DATE=to_date('"+reaction_date1+"','dd/mm/yyyy hh24:mi') and a.ALLERGEN_CODE='"+causative_code+"' and a.patient_id=b.patient_id and a.ALLERGEN_CODE=b.ALLERGEN_CODE";
			String get_data="select a.CAUSATIVE_SUBSTANCE,a.ROUTE_OF_EXPOSURE,b.SEVERITY,b.OTHERS_REACTION,b.REACTION_SITE,a.INFORMATION_SOURCE,a.ALLERGY_TEST_RESULT,a.TREATMENT_ADVICE,a.REMARKS from PR_ADVERSE_EVENT a, PR_ADVERSE_EVENT_REACTION b where a.patient_id='"+PatientId+"' and a.ADV_EVENT_TYPE='"+adv_event_type+"' /*b.REACTION_DATE=to_date('"+reaction_date1+"','dd/mm/yyyy hh24:mi')*/ and a.ALLERGEN_CODE='"+causative_code+"' and a.patient_id=b.patient_id and a.ALLERGEN_CODE=b.ALLERGEN_CODE and a.ADV_EVENT_TYPE=b.ADV_EVENT_TYPE ";

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

			


	String override_chk_val = "";
	String override_chk_val1= "";
	String source_chk_val= "";
	String source_chk_val1= "";
	String source_chk_val2= "";
	String active_date_display = "";
	


if(mode.equals("insert"))
{
	if(status1.equals("A"))
	{
		ckecked_status1="Checked";
		ckecked_status2="";
		ckecked_status3="";
	}
	else if(status1.equals("R"))
	{
		ckecked_status2="Checked";
		ckecked_status1="";
		ckecked_status3="";
	}
	else if(status1.equals("E")) 
	{
		ckecked_status3="Checked";
		ckecked_status1="";
		ckecked_status2="";
	}
	else if(status1.equals("")) 
	{
		ckecked_status3="";
		ckecked_status1="Checked";
		ckecked_status2="";
	}
}
else
{
	if(status1.equals("A"))
	{
		ckecked_status1="Checked";
		ckecked_status2="";
		ckecked_status3="";
	}
	else if(status1.equals("R")){
		ckecked_status2="Checked";
		ckecked_status1="";
		ckecked_status3="";
	}
	else if(status1.equals("E")) 
	{
		ckecked_status3="Checked";
		ckecked_status1="";
		ckecked_status2="";
	}
}

if(mode.equals("insert")){
if(status_db.equals("A")  ){
		ckecked_status1_db="Checked";
		ckecked_status2_db="";
		ckecked_status3_db="";
		}
	else if(status_db.equals("R")){
		ckecked_status2_db="Checked";
		ckecked_status1_db="";
		ckecked_status3_db="";
	}
	else if(status_db.equals("E"))
		{
		ckecked_status3_db="Checked";
		ckecked_status1_db="";
		ckecked_status2_db="";
		}
		}
		else
		{
			if(status_db.equals("A")  ){
		ckecked_status1_db="Checked";
		ckecked_status2_db="";
		ckecked_status3_db="";
		ckecked_status1="";
		ckecked_status2="";
		ckecked_status3="";
		}
	else if(status_db.equals("R")){
		ckecked_status2_db="Checked";
		ckecked_status1_db="";
		ckecked_status3_db="";
		ckecked_status1="";
		ckecked_status2="";
		ckecked_status3="";
	}
	else if(status_db.equals("E"))
		{
		ckecked_status3_db="Checked";
		ckecked_status1_db="";
		ckecked_status2_db="";
		ckecked_status1="";
		ckecked_status2="";
		ckecked_status3="";
		}
		else if(status_db.equals(""))
			{
			ckecked_status1_db="Checked";
		ckecked_status2_db="";
		ckecked_status3_db="";
		ckecked_status1="";
		ckecked_status2="";
		ckecked_status3="";
		}
		}

if(mode.equals("insert"))
{
	if(Certainity.equals("D"))
	{
		override_chk_val = "Checked";
		override_chk_val1= "";
	}
	else if(Certainity.equals("P"))
	{
		 override_chk_val1= "Checked";
		 override_chk_val= "";
	}
	else if(Certainity.equals(""))
	{
		override_chk_val = "Checked";
		override_chk_val1= "";
	}
}
else
{
	if(Certainity.equals("D"))
	{
		override_chk_val = "Checked";
		override_chk_val1= "";
	}
	else if(Certainity.equals("P"))
		{
  override_chk_val1= "Checked";
  override_chk_val= "";

}

}

if(mode.equals("insert")){
if(source_of_info.equals("P"))
		{
	source_chk= "Checked";
	source_chk1="";
	source_chk2="";
}
else if(source_of_info.equals("A"))
{
	source_chk1= "Checked";
	source_chk2="";
	source_chk="";
}
else if(source_of_info.equals("S"))
		{
	source_chk2= "Checked";
	source_chk1="";
	source_chk="";
}
else if (source_of_info.equals(""))
		{
	source_chk= "Checked";
	source_chk1="";
	source_chk2="";
}
}else
		{
if(source_of_info.equals("P"))
		{
	source_chk= "Checked";
	source_chk1="";
	source_chk2="";
}
else if(source_of_info.equals("A"))
{
	source_chk1= "Checked";
	source_chk2="";
	source_chk="";
}
else if(source_of_info.equals("S"))
		{
	source_chk2= "Checked";
	source_chk1="";
	source_chk="";
}

}

if(mode.equals("insert")){
if(Sour_Of_Reac1.equals("P"))
		{
	source_chk_val= "Checked";
	source_chk_val1="";
	source_chk_val2="";
}
else if(Sour_Of_Reac1.equals("A"))
{
	source_chk_val1= "Checked";
	source_chk_val2="";
	source_chk_val="";
}
else if(Sour_Of_Reac1.equals("S"))
		{
	source_chk_val2= "Checked";
	source_chk_val1="";
	source_chk_val="";
}

}else
		{
		if(Sour_Of_Reac1.equals("P"))
		{
	source_chk_val= "Checked";
	source_chk_val1="";
	source_chk_val2="";
}
else if(Sour_Of_Reac1.equals("A"))
{
	source_chk_val1= "Checked";
	source_chk_val2="";
	source_chk_val="";
}
else if(Sour_Of_Reac1.equals("S"))
		{
	source_chk_val2= "Checked";
	source_chk_val1="";
	source_chk_val="";
}
else if (Sour_Of_Reac1.equals(""))
		{
	source_chk_val= "Checked";
	source_chk_val1="";
	source_chk_val2="";
}
	}

if(mode.equals("insert"))
		{
 if(Certainity_db.equals("D"))
		{
			override_chk_val_db="checked";
			override_chk_val1_db="";
		}
else if(Certainity_db.equals("P"))
		{
			override_chk_val_db="";
			override_chk_val1_db="checked";
		}
		}else
		{
			if(Certainity_db.equals(""))
		{
			override_chk_val_db="checked";
			override_chk_val1_db="";
		}
else if(Certainity_db.equals("D"))
		{
			override_chk_val_db="checked";
			override_chk_val1_db="";
			override_chk_val="";
			override_chk_val1="";
		}
else if(Certainity_db.equals("P"))
		{
			override_chk_val_db="";
			override_chk_val1_db="checked";
			override_chk_val="";
			override_chk_val1="";
		}
		}

if(mode.equals("record") && !details_code.equals(""))			
	{
		StringTokenizer details_val= new StringTokenizer(details_code,"^");
		while(details_val.hasMoreTokens())
		{
	     status1=details_val.nextToken();
			if(!status1.equals("E"))
			{
			 since_date1=details_val.nextToken();
			 Certainity=details_val.nextToken();
			  diagnosis_code=details_val.nextToken();
			 
			 route_of_expo=details_val.nextToken();
			 source_of_info=details_val.nextToken();
			 allergy_test_res=details_val.nextToken();
			 treat_advice=details_val.nextToken();
			remarks=details_val.nextToken();
		}
			else
			{
			err_remark=details_val.nextToken();
			since_date1=details_val.nextToken();
			Certainity=details_val.nextToken();
			  diagnosis_code=details_val.nextToken();
			 
			 route_of_expo=details_val.nextToken();
			 source_of_info=details_val.nextToken();
			 allergy_test_res=details_val.nextToken();
			 treat_advice=details_val.nextToken();
			 remarks=details_val.nextToken();
			}
		}
			 allergy_test_res1="";
			 treat_advice1="";
			 remarks1="";
			 exposure="";
			 ckecked_status1_db="";
			ckecked_status2_db="";
			ckecked_status3_db="";
			override_chk_val_db="";
			override_chk_val1_db="";
			source_chk_val= "";
			source_chk_val1="";
			source_chk_val2="";
			Sour_Of_Reac1="";
			term_short_desc="";
			termcode="";
			 if(status1.equals("A"))
			{
				ckecked_status1="Checked";
				ckecked_status2="";
				ckecked_status3="";
			}
			else if(status1.equals("R")){
				ckecked_status2="Checked";
				ckecked_status1="";
				ckecked_status3="";
			}
			else if(status1.equals("E")) 
			{
				ckecked_status3="Checked";
				ckecked_status1="";
				ckecked_status2="";
			}
			if(Certainity.equals("D"))
			{
				override_chk_val = "Checked";
				override_chk_val1= "";
			}
			else if(Certainity.equals("P"))
			{
				 override_chk_val1= "Checked";
				 override_chk_val= "";
			}
			else if(Certainity.equals(""))
			{
				override_chk_val = "Checked";
				override_chk_val1= "";
			}
			if(source_of_info.equals("P"))
				{
			source_chk= "Checked";
			source_chk1="";
			source_chk2="";
			}
			else if(source_of_info.equals("A"))
			{
				source_chk1= "Checked";
				source_chk2="";
				source_chk="";
			}
			else if(source_of_info.equals("S"))
				{
			source_chk2= "Checked";
			source_chk1="";
			source_chk="";
			}
			else if (source_of_info.equals(""))
				{
			source_chk= "Checked";
			source_chk1="";
			source_chk2="";
			}
	}


	if (mode.equals("insert")){
				

				String get_diag_desc = "select term_code,short_desc from mr_term_code where term_code = '"+diagnosis_code.trim()+"'";

			rs1=stmt1.executeQuery(get_diag_desc);
			if(rs1 != null && rs1.next())
			{
				diagnosis_code = rs1.getString("term_code");
				diag_desc = rs1.getString("short_desc");
			}

			


	}

	else

		{
			String get_diag_desc = "select term_code,short_desc from mr_term_code where term_code = '"+diagnosis_code_db.trim()+"'";

			rs1=stmt1.executeQuery(get_diag_desc);
			if(rs1 != null && rs1.next())
			{
				termcode = rs1.getString("term_code");
				term_short_desc = rs1.getString("short_desc");
			}

		}
		 


%>

<body  <%if(mode.equals("record")){%>onload='setTimeout("disable()",500);default_value();'<%}else{%>onload='default_value();'<%}%> OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
 <form name = 'detail_form'     >
	 <table cellpadding='0'  border='0' cellspacing='0' width='100%' align='center' >
		<th align='left' colspan='4' nowrap><fmt:message key="Common.additionaldetails.label" bundle="${common_labels}"/></th>
		
		<tr>	
				<% if(mode.equals("insert")){ %>
				
				<td class='label' width='20%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
				<td class='fields'  width='30%'>
					<input type=radio name='active' id='active' checked value='A' onclick='change_val_status1(this)'  ><fmt:message key="Common.active.label" bundle="${common_labels}"/></input>
            </td>
				<%}else {%>
					<td class='label' width='20%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
					<td class='fields'  width='30%'>
					<input type=radio name='active' id='active'   value='A'  <%=ckecked_status1%> <%=ckecked_status1_db%>   onclick='change_val_status1(this)'><fmt:message key="Common.active.label" bundle="${common_labels}"/></input>
					<input type=radio name='resolve' id='resolve'   value='R'   <%=ckecked_status2%> <%=ckecked_status2_db%>  onclick='change_val_status1(this)'  ><fmt:message key="Common.Resolved.label" bundle="${common_labels}"/></input>
					<input type=radio name='inerror' id='inerror'  value='E'  <%=ckecked_status3%> <%=ckecked_status3_db%> onclick='change_val_status1(this)' ><fmt:message key="Common.InError.label" bundle="${common_labels}"/></input>
				</td>
				<%}%>

				
				<td class='label'  id='status_date'  width='25%'><fmt:message key="Common.since.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'  >
				<%
//out.println("<script>alert(\""+onset_date+"\");</script>");
//out.println("<script>alert(\""+onset_date1+"\");</script>");
//out.println("<script>alert(\""+since_date1+"\");</script>");				
//out.println("<script>alert(\""+since_date+"\");</script>");				
//out.println("<script>alert(\""+changeonsetflag+"\");</script>");				
				
					
					%>
					<%if(mode.equals("insert") ){%>
<%-- 					<input type='text'  name='date_time' id='date_time'    id='modify_date' onblur="CompareRegnDate1(this,document.forms[0].sys_date_time);" maxlength="16" size="14" <%if(!since_date.equals(since_date1) && (changeonsetflag.equals("N"))){%>value='<%=since_date1%>'<%}else{%>value='<%=since_date%>' <%}%>><img id='date_time_cal' src="../../eCommon/images/CommonCalendar.gif"  onClick="document.getElementById('date_time').select();return showCalendar('modify_date',null);"/><img src="../../eCommon/images/mandatory.gif"  align='center'></img>
 --%>					
 						<input type="text" name="date_time" id="date_time" onblur="CompareRegnDate1(this, document.forms[0].sys_date_time);" maxlength="16" size="14" <% if (!since_date.equals(since_date1) && changeonsetflag.equals("N")) { %>value="<%= since_date1 %>"<% } else { %>value="<%= since_date %>"<% } %>><img id="date_time_cal" src="../../eCommon/images/CommonCalendar.gif" onClick="document.getElementById('date_time').select(); return showCalendar('date_time', null);" /><img src="../../eCommon/images/mandatory.gif" align="center" />
 						
 	<%}else {
						if(status1.equals("R") || status1.equals("E"))
						{
							
						  active_date_display=DateUtils.convertDate(since_date1,"DMY","en",locale);
						}
						else
						{
						  active_date_display=DateUtils.convertDate(reaction_date1,"DMY","en",locale);
						}
						
						%>
						<input type='text'  name='date_time' id='date_time' value='<%=active_date_display%>' disabled id='modify_date' onblur="CompareRegnDate1(this,document.forms[0].sys_date_time);" maxlength="16" size="14" ><img  disabled id='date_time_cal' src="../../eCommon/images/CommonCalendar.gif"  onClick="document.getElementById("date_time").select();return showCalendar('modify_date',null);"/>
						<img src="../../eCommon/images/mandatory.gif"  align='center'></img>
					<%}%>  
		
		</tr>

		<tr id='error_reason' Style="display:none;visibility:hidden">
				<td class='label' id='status_val' width='20%' ><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
				<td class='fields' colspan='3'  id='status_val2'>
				<textarea name='err_remark1' id='err_remark1'  onkeypress="return CheckForSpecChars_event(event)" ; onBlur="checkForMax(this,30)" rows='1' cols='30'  ><%=err_remark%></textarea></td>
		</tr>

		<tr>
				<td  class="label" width='20%'><fmt:message key="eMR.Certanity.label" bundle="${mr_labels}"/></td>
				<td  class="oaBorder" width='30%'>
					
				<input type=radio name='definit' id='definit'   value='D' <%=override_chk_val%> <%=override_chk_val_db%> onclick='change_val(this)'><fmt:message key="Common.Definitive.label" bundle="${common_labels}"/><input type=radio name='probable' id='probable'  value='P' <%=override_chk_val1%> <%=override_chk_val1_db%> onclick='change_val(this)'><fmt:message key="Common.Probable.label" bundle="${common_labels}"/></td>
                    

				<td class='label' width='25%'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'><input type='text' name='diagnosis' id='diagnosis' maxlength='30' size='30' value='<%=diag_desc%> <%=term_short_desc%>' ><input type='button' class='button' name='cause_diag_search' id='cause_diag_search'  value='?' onclick='openDiagnosis1()'><input type='hidden' name='diagnosis_code' id='diagnosis_code' value='<%=diagnosis_code%> <%=termcode%>'><input type='hidden' name='term_code' id='term_code' value='<%=term_code%>'></td>
		 </tr>

			<td  class='label' width='20%'><fmt:message key="Common.RouteofExposure.label" bundle="${common_labels}"/></td>
			<td class='fields' width='30%'><select name='route_exp' id='route_exp' >
			 	<%
			if(route_of_expo.equals("") ||route_of_expo.equals(" ") )
									{%>
				<option value='' selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
									<option value='1'  ><fmt:message key="eMR.Ingestion.label" bundle="${mr_labels}"/></option>
			<option value='2' ><fmt:message key="eMR.Inhalation.label" bundle="${mr_labels}"/></option>
			<option value='3' ><fmt:message key="eMR.Injection.label" bundle="${mr_labels}"/></option>
			<option value='4'><fmt:message key="eMR.Tropical.label" bundle="${mr_labels}"/></option>
			<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
								
									<%}%>
			<%
				 if(route_of_expo.equals("1"))
									{%>
		
			<option value='' >---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<option value='1'  selected><fmt:message key="eMR.Ingestion.label" bundle="${mr_labels}"/></option>
			<option value='2' ><fmt:message key="eMR.Inhalation.label" bundle="${mr_labels}"/></option>
			<option value='3' ><fmt:message key="eMR.Injection.label" bundle="${mr_labels}"/></option>
			<option value='4'><fmt:message key="eMR.Tropical.label" bundle="${mr_labels}"/></option>
			<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
									
									<%}%>
			
				<%
				 if(route_of_expo.equals("2"))
									{%>
										

										<option value='' >---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<option value='1'  ><fmt:message key="eMR.Ingestion.label" bundle="${mr_labels}"/></option>
			<option value='2' selected><fmt:message key="eMR.Inhalation.label" bundle="${mr_labels}"/></option>
			<option value='3' ><fmt:message key="eMR.Injection.label" bundle="${mr_labels}"/></option>
			<option value='4'><fmt:message key="eMR.Tropical.label" bundle="${mr_labels}"/></option>
			<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
									<%}%>
				<%
				 if(route_of_expo.equals("3"))
									{%>
										
								<option value='' >---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<option value='1'  ><fmt:message key="eMR.Ingestion.label" bundle="${mr_labels}"/></option>
			<option value='2' ><fmt:message key="eMR.Inhalation.label" bundle="${mr_labels}"/></option>
			<option value='3' selected><fmt:message key="eMR.Injection.label" bundle="${mr_labels}"/></option>
			<option value='4'><fmt:message key="eMR.Tropical.label" bundle="${mr_labels}"/></option>
			<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
									
									<%}%>
				<%
				 if(route_of_expo.equals("4"))
									{%>
										
								<option value='' >---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<option value='1'  ><fmt:message key="eMR.Ingestion.label" bundle="${mr_labels}"/></option>
			<option value='2' ><fmt:message key="eMR.Inhalation.label" bundle="${mr_labels}"/></option>
			<option value='3' ><fmt:message key="eMR.Injection.label" bundle="${mr_labels}"/></option>
			<option value='4' selected><fmt:message key="eMR.Tropical.label" bundle="${mr_labels}"/></option>
			<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
									
									<%}%>
			
					<%
				 if(route_of_expo.equals("U"))
	               	{%>
								

								<option value='' >---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<option value='1'  ><fmt:message key="eMR.Ingestion.label" bundle="${mr_labels}"/></option>
			<option value='2' ><fmt:message key="eMR.Inhalation.label" bundle="${mr_labels}"/></option>
			<option value='3' ><fmt:message key="eMR.Injection.label" bundle="${mr_labels}"/></option>
			<option value='4'><fmt:message key="eMR.Tropical.label" bundle="${mr_labels}"/></option>
			<option value='U' selected><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
				<%	}%>
			 					
			</select></td>

			<td  class='label' colspan='2'>&nbsp;</td>
		</tr>

	   <tr>
			<td class='label' width='20%' ><fmt:message key="eMR.SourceOfInfo.label" bundle="${mr_labels}"/></td>
			<td  class="fields" colspan='3'>
			<input type=radio name='pat_obser' id='pat_obser'    value='P'  <%=source_chk_val%> <%=source_chk%> onclick='change_val_two(this)'><fmt:message key="eMR.PatientObservation.label" bundle="${mr_labels}"/>
			<input type=radio name='aller_test' id='aller_test' value='A' <%=source_chk_val1%> <%=source_chk1%> onclick='change_val_two(this)'><fmt:message key="eMR.AllergyTestResult.label" bundle="${mr_labels}"/>
			<input type=radio name='Staff_obser' id='Staff_obser' value='S'  <%=source_chk_val2%> <%=source_chk2%> onclick='change_val_two(this)'><fmt:message key="eMR.StaffObservation.label" bundle="${mr_labels}"/></td>
			 
	 </tr>
     <tr>
	 	<% if(source_of_info.equals("")) { %>
		 
			<td class='label' id='aller_test_results' width='20%'><%=aller_test_results%></td>
<%}%>
			<% if(source_of_info.equals("P")) { %>
		 
			<td class='label' id='aller_test_results' width='20%'><%=aller_test_results%></td>
<%}%>
					
						<% if(source_of_info.equals("A")){ %> 
		
			<td class='label' id='aller_test_results' width='20%'><%=aller_test_results1%></td>
<%}%>
			<% if(source_of_info.equals("S")) { %>
		
			<td class='label' id='aller_test_results' width='20%'><%=aller_test_results2%></td>
<%}%>
<%
				
%>
			<td class='fields' colspan='3'><textarea name='allergy_test_res'  maxlength="25" rows='1' cols='85'  value='<%=allergy_test_res1.trim()%>' onblur = 'checkMaxLimit(this);' onkeypress="return CheckForSpecChars_event(event);return imposeMaxLength(this, 100);"><%=allergy_test_res1.trim()%></textarea></td>
	</tr>
	<tr>
			<td class='label' width='20%'><fmt:message key="eMR.TreatAdviceActionTaken.label" bundle="${mr_labels}"/></td>
			<td class='fields' colspan='3'><textarea name='treat_advice'  maxlength="25" rows='1' cols='85' value='<%=treat_advice.trim()%>' onblur = 'checkMaxLimit(this);'onkeypress="return CheckForSpecChars_event(event);return imposeMaxLength(this, 100);" ><%=treat_advice1.trim()%></textarea></td>
	</tr>
	<tr>
			<td class='label' width='20%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td class='fields' colspan='3'><textarea name='remarks' maxlength="25" rows='1' cols='85' value='<%=remarks1.trim()%>' onblur = 'checkMaxLimit(this);' onkeypress="return CheckForSpecChars_event(event);return imposeMaxLength(this, 100);" ><%=remarks1.trim()%></textarea></td>
	</tr>
	<tr>
		<td  align=left class='fields'  width='88%'colspan='3' >
		</td>
 	    <td class='fields' width='12%' align=right colspan='3'><input class=button type='button' name=okButton value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onclick="ClickOK();"><input class=button type='button' name=Button value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onclick="ClickCancel();"></td>
	</tr>
</table>


<SCRIPT LANGUAGE="JavaScript">
	

	function ClickCancel()
{
	    
	 //  parent.window.close();
		parent.document.getElementById('dialog_tag').close();

}
	function ClickOK()
{
		if(document.detail_form.date_time.value ==  false)
		{
		var error3;
		error3=getMessage("CAN_NOT_BE_BLANK","common");
		error3=error3.replace("$",getLabel("Common.since.label","Common"));
		alert(error3);
		
		window.focus=document.forms[0].since_date1.value;
		}else{

	
	var mode  =  document.forms[0].mode.value
			
	var status1 ;
	var reason ;
	if(document.forms[0].active.checked == true)
		status1=document.forms[0].active.value;
	else if(document.forms[0].resolve.checked == true)
	{
		status1=document.forms[0].resolve.value;
		
	}
	else if(document.forms[0].inerror.checked == true)
		status1=document.forms[0].inerror.value;



		

  var since_date =document.forms[0].date_time.value;

     var diagnosis_code =document.forms[0].diagnosis_code.value;
  
   var route_of_expo =document.forms[0].route_exp.value;
   var allergy_test_res =document.forms[0].allergy_test_res.value;

   var treat_advice =document.forms[0].treat_advice.value;
   var remarks =document.forms[0].remarks.value;
   var certainity =document.forms[0].certainity.value;
   
   var  source_of_info =document.forms[0].sou_of_info.value;
   
   reason = document.forms[0].err_remark1.value
		  
	
	
		
	if(document.forms[0].pat_obser.checked==true)
	{
		source_of_info="P";

	}else if(document.forms[0].aller_test.checked==true){

		source_of_info="A";

	}else if(document.forms[0].Staff_obser.checked==true)
	{
		source_of_info="S";

	}

if(document.forms[0].definit.checked==true)
	{
		certainity="D";
}
else if(document.forms[0].probable.checked==true)
	{
		certainity="P";
}
		
		

		if(status1=="" || status1==" " )
		status1=" ";
		if(reason=="" || reason==" " )
		reason=" ";
    	if(since_date=="" || since_date==" " )
		since_date="dd";
		if(certainity=="" || certainity==" " )
		certainity=" ";
		if(diagnosis_code=="" || diagnosis_code==" " )
		diagnosis_code=" ";
		
    	if(route_of_expo=="" || route_of_expo==" " )
		route_of_expo=" "; 
		if(source_of_info=="" || source_of_info==" " )
		source_of_info=" ";
		if(allergy_test_res=="" || allergy_test_res==" " )
		allergy_test_res=" ";
		if(treat_advice=="" || treat_advice==" " )
		treat_advice=" ";
		if(remarks=="" || remarks==" " )
		remarks=" ";
	 if(status1 == 'E')
	{
	 var details     = status1						+"^"
						+ reason						+"^"
						+ since_date						+"^"
						+ certainity				            +"^"
						+ diagnosis_code						+"^"
						+route_of_expo				+"^"
						+source_of_info				+"^"
						+allergy_test_res				+"^"
						+ treat_advice				    +"^"
						+ remarks	;
	}
	else
	{
		var details     = status1						+"^"
						+ since_date						+"^"
						+ certainity				            +"^"
						+ diagnosis_code						+"^"
						+route_of_expo				+"^"
						+source_of_info				+"^"
						+allergy_test_res				+"^"
						+ treat_advice				    +"^"
						+ remarks	;
	}

//alert('details'+details) ;
 var xmlDoc = ""
 var xmlHttp = new XMLHttpRequest()
 xmlStr ="<root><SEARCH details = \""+encodeURIComponent(details)+"\" steps='9'/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","AdverseEventType.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText) 

if(document.forms[0].details_code.value != "")
		{
	
	 retain();
	 } 
 //console.log(parent)
	//	console.log(parent.document.getElementById('dialog-body').contentWindow);
 
	   window.returnValue =details;
		parent.document.getElementById('dialog-body').contentWindow.returnValue = details;
		if(since_date!="" && since_date!="dd")
		//window.close();		
			parent.document.getElementById('dialog_tag').close();
		}

	}

	function retain(){
	var details_code=document.forms[0].details_code.value;
	
	var sel_arr=details_code.split('^');


for (i=0;i<sel_arr.length-1;i++){
		
	  sel_arr1=sel_arr[0];
	  sel_arr2=sel_arr[1];
	  sel_arr3=sel_arr[2];
	  sel_arr4=sel_arr[3];
	  sel_arr5=sel_arr[4];
	  sel_arr6=sel_arr[5];
	  sel_arr7=sel_arr[6];
	  sel_arr8=sel_arr[7];
	    sel_arr9=sel_arr[8];
	    //sel_arr10=sel_arr[9];

	 // document.forms[0].active.value=sel_arr1
	 if(sel_arr1='A')
		document.forms[0].active.value=sel_arr1;	 
	 else if(sel_arr1='R')
		 document.forms[0].resolve.value=sel_arr1;
	 else if(sel_arr1='E')
		  document.forms[0].inerror.value=sel_arr1;
	 document.forms[0].date_time.value=sel_arr2
	 document.forms[0].certainity.value=sel_arr3
	 document.forms[0].diagnosis.value=sel_arr4
	 document.forms[0].route_exp.value=sel_arr5
     document.forms[0].sou_of_info.value=sel_arr6
	document.forms[0].allergy_test_res.value=sel_arr7
	 document.forms[0].treat_advice.value=sel_arr8
	 document.forms[0].remarks.value=sel_arr9 
	}
	//parent.frames[3].document.forms[0].event_exposure.value=document.forms[0].route_exp.value;
	
	} 

function default_value()
{
		/*Thursday, January 21, 2010 , 18223 */
		var event_details=window.dialogArguments;
			if(event_details == null || event_details == 'null')
			{
				event_details='';
			}
			
			var arr_event_details=event_details.split("^^");
			if(arr_event_details[0])
				document.forms[0].allergy_test_res.value	= unescape(arr_event_details[0]);      
			if(arr_event_details[1])
				document.forms[0].treat_advice.value		= unescape(arr_event_details[1]); 
			if(arr_event_details[2])
				document.forms[0].remarks.value				= unescape(arr_event_details[2]); 
			if(arr_event_details[3])
				document.forms[0].err_remark1.value				= unescape(arr_event_details[3]); 
		/**/

		
		if(document.forms[0].mode.value=='modify')
		{
			
			parent.frames[3].document.forms[0].cause_sub.value=document.forms[0].causitive_sub.value;
			document.forms[0].treat_advice.value=document.forms[0].treat_advice1.value;
			document.forms[0].remarks.value=document.forms[0].remarks1.value;
			document.forms[0].allergy_test_res.value=document.forms[0].allergy_test_res1.value;
			document.forms[0].route_exp.value=document.forms[0].exposure1.value;
			
		
			parent.frames[3].document.forms[0].cause_sub.disabled=true;
			document.forms[0].treat_advice.disabled=true;
			document.forms[0].remarks.disabled=true;
			document.forms[0].allergy_test_res.disabled=true;
			document.forms[0].route_exp.disabled=true;
		
		var certainity=document.forms[0].certainity.value="D";

		if(certainity =="D")
		{
		document.forms[0].definit.checked=true;
		document.forms[0].probable.checked=false;
		}else
		{
			document.forms[0].probable.checked=true;
			document.forms[0].definit.checked=false;
		}
	
			

		var source_of_info= document.forms[0].source_of_info.value;
		if(source_of_info=="P")
		{
			document.forms[0].pat_obser.checked=true;
			document.forms[0].aller_test.checked=false;
			document.forms[0].Staff_obser.checked=false;
			document.getElementById("aller_test_results").innerText=getLabel("eMR.PatientObservation.label","MR");

		}else if(source_of_info=="A")
		{
			document.forms[0].aller_test.checked=true;
			document.forms[0].Staff_obser.checked=false;
			document.forms[0].pat_obser.checked=false;
			document.getElementById("aller_test_results").innerText=getLabel("eMR.AllergyTestResult.label","MR");
		}else if(source_of_info=="S")
		{
			document.forms[0].Staff_obser.checked=true;
			document.forms[0].aller_test.checked=false;
			document.forms[0].pat_obser.checked=false;
			document.getElementById("aller_test_results").innerText=getLabel("eMR.StaffObservation.label","MR");
		}
		

			document.forms[0].pat_obser.disabled=true;
			document.forms[0].aller_test.disabled=true;
			document.forms[0].Staff_obser.disabled=true;	parent.frames[2].document.forms[0].react_values.value=document.forms[0].react_values1.value;

		var PatientId=document.forms[0].PatientId.value;
		var adv_event_dtl_srl_no=document.forms[0].adv_event_dtl_srl_no.value;
		var	reaction_date1=document.forms[0].reaction_date1.value;
		var	causative_code=document.forms[0].causative_code.value;

		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH adv_event_dtl_srl_no=\""+adv_event_dtl_srl_no+"\"  reaction_date1=\""+encodeURIComponent(reaction_date1)+"\"  PatientId=\""+PatientId+"\"  causative_code=\""+causative_code+"\"   steps='7'/></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")

		xmlHttp.open("POST","AdverseEventType.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText) 
		document.forms[0].record.disabled=true;

	}else if(document.forms[0].mode.value=='record')
	{
	
		document.forms[0].resolve.disabled=false;
		document.forms[0].inerror.disabled=false;
		document.forms[0].diagnosis.disabled=true;
		document.forms[0].cause_diag_search.disabled=true;
		if(document.forms[0].inerror.checked == true)
		{
			/*document.forms[0].all.error_reason.style.visibility="visible";
			document.forms[0].all.err_remark1.style.visibility="visible";*/
			document.getElementById("error_reason").style.display='Inline';
			document.getElementById("error_reason").style.visibility='visible';
			document.forms[0].err_remark.value='<%=err_remark%>';
			
		}

		var source_of_info= document.forms[0].source_of_info.value;
		if(source_of_info=="P")
		{
			document.forms[0].pat_obser.checked=true;
			document.forms[0].aller_test.checked=false;
			document.forms[0].Staff_obser.checked=false;
			document.getElementById("aller_test_results").innerText=getLabel("eMR.PatientObservation.label","MR");

		}else if(source_of_info=="A")
		{
			document.forms[0].aller_test.checked=true;
			document.forms[0].Staff_obser.checked=false;
			document.forms[0].pat_obser.checked=false;
			document.getElementById("aller_test_results").innerText=getLabel("eMR.AllergyTestResult.label","MR");
		}else if(source_of_info=="S")
		{
			document.forms[0].Staff_obser.checked=true;
			document.forms[0].aller_test.checked=false;
			document.forms[0].pat_obser.checked=false;
			document.getElementById("aller_test_results").innerText=getLabel("eMR.StaffObservation.label","MR");
		}
		/*if(parent.frames[2].document.forms[0].allergen.value !="")	
		{
		parent.frames[3].document.forms[0].add_reaction.disabled=false;
		parent.frames[3].document.forms[0].add_reaction_search.disabled=false;
		}*/
		//parent.frames[6].document.forms[0].record.disabled=false;
	}
	

}

</SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


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
			<input type="hidden" name="onset_date" id="onset_date" value="<%=onset_date%>" >
			<input type='hidden' name='status1' id='status1' value='<%=status1%>'>
			<input type='hidden' name='err_remarks' id='err_remarks' value=''>
			<input type='hidden' name='flag' id='flag' value='<%=flag%>'>
			<input type='hidden' name='allergen_id' id='allergen_id' value=''>
			<input type='hidden' name='cause_sub' id='cause_sub' value=''>
			<input type='hidden' name='Pract_id' id='Pract_id' value='<%=Pract_id%>'>
			<input type='hidden' name='drug_code' id='drug_code' value=''>
			<input type='hidden' name='severity_code' id='severity_code' value='<%=severity_code%>'>
			<input type='hidden' name='final_reac_code_val' id='final_reac_code_val' value='<%=final_reac_code_val%>'>
			<input type='hidden' name='adv_event_type_code' id='adv_event_type_code' value='<%=adv_event_type_code%>'>
			<input type='hidden' name='adv_event_type_ind_code' id='adv_event_type_ind_code' value='<%=adv_event_type_ind_code%>'>
			<input type='hidden' name='practitioner_type' id='practitioner_type' value='<%=practitioner_type%>'>
			<input type='hidden' name='patient_class' id='patient_class' value='<%=patient_class%>'>
			<input type='hidden' name='reaction_value' id='reaction_value' value=''>
		    <input type='hidden' name='status_val' id='status_val' value=''>
		    <input type='hidden' name='since_date' id='since_date' value='<%=since_date%>'>
		    <input type='hidden' name='route_of_expo' id='route_of_expo' value='<%=route_of_expo%>'>
		    <input type='hidden' name='err_remark' id='err_remark' value='<%=err_remark%>'>
		    <input type='hidden' name='term_code' id='term_code' value=''>
		    <input type='hidden' name='active_diag_cnt' id='active_diag_cnt'	 value='<%=active_diag_cnt%>'>
		    <input type='hidden' name='details_code' id='details_code' value='<%=details_code%>'>
		   	<input type="hidden" name="Locn_Code" id="Locn_Code" value ='<%=Locn_Code%>'>
			<input type="hidden" name="location_type" id="location_type" value ='<%=location_type%>'>
			<input type="hidden" name="speciality_code" id="speciality_code" value ='<%=speciality_code%>'>
			<input type="hidden" name="active_date_display" id="active_date_display" value ='<%=active_date_display%>'>
			<input type="hidden" name="Dob" id="Dob" value ='<%=Dob%>'>
			<input type="hidden" name="since_date1" id="since_date1" value ='<%=since_date1%>'>

	 <%
     } catch(Exception e) {
		 e.printStackTrace();
         // out.println(e.toString());
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
		  
		   if (rs2 != null) rs2.close();
          if (stmt2 != null) stmt2.close();
     }
     finally {
		 if (rs1 != null) rs1.close();
          if (stmt1 != null) stmt1.close();
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

