<!DOCTYPE html>
 <%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<html>
<head>
  <%@ page import ="java.sql.*,java.util.*" %>
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
   <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
  <script language='javascript' src='../../eCommon/js/messages.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
  <script language='javascript' src='../../eQA/js/QAIndicator.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  <script>
 
   function checkMaxLimit(obj,maxSize) {
        if ( obj.value.length > maxSize )
        {
		  	alert("APP-OT0016 The value should be of 500 characters" );
			event.returnValue = false;
   	  		obj.focus();
        }
    }

  function hideothers(){
		if(document.forms[0].clind_type.value=='R'){
				x_readonly ="";
			    document.forms[0].numerator.disabled=false;
			    document.forms[0].denomenator.disabled=false;

		}
		else if(document.forms[0].clind_type.value!='R'){
			   document.forms[0].numerator.value="";
			   document.forms[0].denomenator.value="";
			   document.forms[0].numerator.disabled=true;
			   document.forms[0].denomenator.disabled=true;
		}
  }
 

  </script>
<%
Connection con=null;
try
{
con=ConnectionManager.getConnection(request);
PreparedStatement pstmt=null;
ResultSet rs=null;

PreparedStatement pstmt1=null;
ResultSet rs1=null;

String mode="I";
String qind_clind_id=""; 
String qind_clind_desc="";
String qind_group_id="";
String qind_group_desc="";
String area_of_concern="";
String clind_type="";
String clind_type_desc="";
String standard_desc=""; 
String standard_value=""; 
String clind_class="";
String clind_class_desc="";

String dflt_rep_periodicity="";
String dflt_bd_by_gender_yn=""; 
String dflt_bd_age_range_id="";
String eff_status=""; 
String patient_class_em="";
String patient_class_op="";
String patient_class_dc=""; 
String patient_class_ip=""; 
String patient_class_xt=""; 
String gender=""; 
String age_operator=""; 
String age_range1=""; 
String age_range2="";
String age_in_dmy="";
String gcs_event_type=""; 
String gcs_event_code="";
String gcs_operator="";
String gcs_score="";
String waterloo_event_code="";
String waterloo_score="";

String post_of_los=""; 
String re_admit_days=""; 
String re_admit_hours="";
String post_of_los_operator="";
String re_admit_days_operator="";
String re_admit_hours_operator="";
String waterloo_event_type="";
String waterloo_operator="";
String gest_period_operator="";
String gest_period_in_dwmy="";
String gest_period="";
String post_delv_los_operator="";
String post_delv_los="";
String tat_days_operator="";
String tat_days="";
String nod_type="";
String term_preg_adm_type="";
String std_operator="";
String std_value="";
String readonly ="";
String surg_type="";
String lmt_rpt_trn_time="";
String x_numerator="";
String x_denomenator="";
String x_readonly="";
String xd_readonly="";
String num_event_type="";
String num_event_code="";
String num_operator="";
String num_score="";

String qind_clind_id1=request.getParameter("qind_clind_id")==null ?"":request.getParameter("qind_clind_id");	

 pstmt=con.prepareStatement("Select * from qa_qind_clind_vw where   qind_clind_id=?");
 pstmt.setString(1,qind_clind_id1);
 rs=pstmt.executeQuery();
while(rs.next())
{
	mode="U";
	qind_clind_id=rs.getString("qind_clind_id"); 
	if(qind_clind_id==null||qind_clind_id.equals("null"))qind_clind_id="";

	qind_clind_desc=rs.getString("qind_clind_desc");
	if(qind_clind_desc==null||qind_clind_desc.equals("null"))qind_clind_desc="";

	qind_group_id=rs.getString("qind_group_id");
	if(qind_group_id==null||qind_group_id.equals("null"))qind_group_id="";

	qind_group_desc=rs.getString("qind_group_desc");
	if(qind_group_desc==null||qind_group_desc.equals("null"))qind_group_desc="";

	area_of_concern=rs.getString("area_of_concern");
	if(area_of_concern==null||area_of_concern.equals("null"))area_of_concern="";
	
	clind_type=rs.getString("clind_type");
	if(clind_type==null||clind_type.equals("null"))clind_type="";

	clind_type_desc=rs.getString("clind_type_desc");
	if(clind_type_desc==null|| clind_type_desc.equals("null")) clind_type_desc="";
	
	standard_desc= rs.getString("standard_desc");
	if(standard_desc==null||standard_desc.equals("null"))standard_desc="";
	
	standard_value= rs.getString("standard_value");
	if(standard_value==null||standard_value.equals("null"))standard_value="";
	 
	clind_class=rs.getString("clind_class");
	if(clind_class==null)clind_class="";
	
	clind_class_desc=rs.getString("clind_class_desc");
	if(clind_class_desc==null||clind_class_desc.equals("null"))clind_class_desc="";
	 
	dflt_rep_periodicity=rs.getString("dflt_rep_periodicity");
	if(dflt_rep_periodicity==null||dflt_rep_periodicity.equals("null"))dflt_rep_periodicity="";
 
	dflt_bd_by_gender_yn= rs.getString("dflt_bd_by_gender_yn");
 	if(dflt_bd_by_gender_yn==null||dflt_bd_by_gender_yn.equals("null"))dflt_bd_by_gender_yn="";
 
	gest_period_operator=rs.getString("gest_period_operator");
 	if(gest_period_operator==null||gest_period_operator.equals("null"))gest_period_operator="";

	gest_period_in_dwmy
	=rs.getString("gest_period_in_dwmy");
	if(gest_period_in_dwmy==null||gest_period_in_dwmy.equals("null"))gest_period_in_dwmy="";


	gest_period=rs.getString("gest_period");
	if(gest_period==null||gest_period.equals("null"))gest_period="";

	dflt_bd_age_range_id=rs.getString("dflt_bd_age_range_id");
	if(dflt_bd_age_range_id==null||dflt_bd_age_range_id.equals("null"))dflt_bd_age_range_id="";

	eff_status= rs.getString("eff_status");
	if(eff_status==null||eff_status.equals("null"))eff_status="";
	if(eff_status.equals("E"))
	{
	 readonly="";
	}
    else
	{
	  readonly="disabled";
	}

	nod_type= rs.getString("nod_type");
	if(nod_type==null||nod_type.equals("null"))nod_type="";


	term_preg_adm_type= rs.getString("term_preg_adm_type");
	if(term_preg_adm_type==null||term_preg_adm_type.equals("null"))term_preg_adm_type="";
 

	patient_class_em=rs.getString("patient_class_em");
	if(patient_class_em==null||patient_class_em.equals("null"))patient_class_em="";
 
	 if(patient_class_em.equals("Y"))
	 patient_class_em="checked";
 
	patient_class_op=rs.getString("patient_class_op");
	 if(patient_class_op==null||patient_class_op.equals("null"))patient_class_op="";
	 if(patient_class_op.equals("Y"))
	 patient_class_op="checked";
	 patient_class_dc= rs.getString("patient_class_dc");
	 if(patient_class_dc==null||patient_class_dc.equals("null"))patient_class_dc="";
	 if(patient_class_dc.equals("Y"))
	 patient_class_dc="checked";
	 
	 patient_class_ip= rs.getString("patient_class_ip");
	 if(patient_class_ip==null||patient_class_ip.equals("null"))patient_class_ip="";
	 if(patient_class_ip.equals("Y"))
	 patient_class_ip="checked";
 
	 patient_class_xt= rs.getString("patient_class_xt");
	 if(patient_class_xt==null||patient_class_xt.equals("null"))patient_class_xt="";
	 if(patient_class_xt.equals("Y"))
	 patient_class_xt="checked";

	 gender= rs.getString("gender");
	 if(gender==null||gender.equals("null"))gender="";
	 
	 age_operator=rs.getString("age_operator"); 
	 if(age_operator==null||age_operator.equals("null"))age_operator="";
	 age_range1= rs.getString("age_range1");
	 if(age_range1==null||age_range1.equals("null"))age_range1="";
	 age_range2=rs.getString("age_range2");
	  if(age_range2==null||age_range2.equals("null"))age_range2="";
	 age_in_dmy=rs.getString("age_in_dmy");
	 if(age_in_dmy==null||age_in_dmy.equals("null"))age_in_dmy="";

	 gcs_event_type= rs.getString("gcs_event_type");
	 if(gcs_event_type==null||gcs_event_type.equals("null"))gcs_event_type="";
	 gcs_event_code=rs.getString("gcs_event_code");
	  if(gcs_event_code==null||gcs_event_code.equals("null"))gcs_event_code="";
	 
	 gcs_operator=rs.getString("gcs_operator");
	 if(gcs_operator==null||gcs_operator.equals("null"))gcs_operator="";
	  gcs_score=rs.getString("gcs_score");
	 if(gcs_score==null||gcs_score.equals("null"))gcs_score="";

	 waterloo_event_type=rs.getString("waterloo_event_type");
	 if(waterloo_event_type==null||waterloo_event_type.equals("null"))waterloo_event_type="";

	 waterloo_event_code=rs.getString("waterloo_event_code");
	 if(waterloo_event_code==null||waterloo_event_code.equals("null"))waterloo_event_code="";
	 
	 waterloo_operator=rs.getString("waterloo_operator");
	 if(waterloo_operator==null||waterloo_operator.equals("null"))waterloo_operator="";
	 
	 waterloo_score=rs.getString("waterloo_score");
	 if(waterloo_score==null||waterloo_score.equals("null"))waterloo_score="";
	 
	 
	 post_delv_los_operator= rs.getString("post_delv_los_operator");
	 if(post_delv_los_operator==null||post_delv_los_operator.equals("null"))post_delv_los_operator="";
	 
	 post_delv_los= rs.getString("post_delv_los");
	 if(post_delv_los
	==null||post_delv_los.equals("null"))post_delv_los="";

	 std_operator=rs.getString("std_operator");
	 if(std_operator==null||std_operator.equals("null"))std_operator="";

	 std_value = rs.getString("STD_VALUE");
	 if(std_value==null||std_value.equals("null"))std_value="";
	post_of_los_operator= rs.getString("post_op_los_operator");
	 if(post_of_los_operator==null||post_of_los_operator.equals("null"))post_of_los_operator="";
	 
	 post_of_los= rs.getString("post_op_los");
	 if(post_of_los==null||post_of_los.equals("null"))post_of_los="";
	 
	 tat_days_operator= rs.getString("tat_days_operator");
	 if(tat_days_operator==null||tat_days_operator.equals("null"))tat_days_operator="";
	 
	 tat_days= rs.getString("tat_days");
	 if(tat_days==null||tat_days.equals("null"))tat_days="";


	re_admit_days_operator= rs.getString("re_admit_days_operator");
	 if(re_admit_days_operator==null||re_admit_days_operator.equals("null"))re_admit_days_operator="";
	 
	 re_admit_days= rs.getString("re_admit_days");
	 if(re_admit_days==null||re_admit_days.equals("null"))re_admit_days="";
	 
	 re_admit_hours_operator=rs.getString("re_admit_hours_operator");
	 if(re_admit_hours_operator==null||re_admit_hours_operator.equals("null"))re_admit_hours_operator="";
	 re_admit_hours=rs.getString("re_admit_hours");
	 if(re_admit_hours==null||re_admit_hours.equals("null"))re_admit_hours="";

	 surg_type=rs.getString("surg_type");
	 if(surg_type==null||surg_type.equals("null"))surg_type="";

		lmt_rpt_trn_time=rs.getString("lmt_rpt_trn_time");
		
	 if(lmt_rpt_trn_time==null||lmt_rpt_trn_time.equals("null"))lmt_rpt_trn_time="";


	 num_event_type= rs.getString("num_event_type");
	 if(num_event_type==null||num_event_type.equals("null"))num_event_type="";

	 num_event_code= rs.getString("num_event_code");
	 if(num_event_code==null||num_event_code.equals("null"))num_event_code="";

	 num_operator= rs.getString("num_operator");
	 if(num_operator==null||num_operator.equals("null"))num_operator="";

	 num_score= rs.getString("num_score");
	 if(num_score==null||num_score.equals("null"))num_score="";
	// out.println("surg_type"+surg_type);
}

 pstmt1=con.prepareStatement("Select ltrim(rtrim(ref_note_text)) ref_note_text1, section_id from QA_QIND_CLIND_REF_NOTE where   qind_clind_id=?");
 pstmt1.setString(1,qind_clind_id1);
 rs1=pstmt1.executeQuery();

 if(rs!=null){ x_readonly = ""; xd_readonly = "";}
 while(rs1.next()){
	 if (rs1.getInt("section_id")==80){ 
		//x_numerator = rs1.getString("ref_note_text");
		//x_numerator = rs1.getString("ref_note_text1");
		x_numerator =(rs1.getString("ref_note_text1")==null)? "":(rs1.getString("ref_note_text1"));
	    x_readonly = "readonly";
     }else if (rs1.getInt("section_id")==90){
//		x_denomenator = rs1.getString("ref_note_text");
		//x_denomenator = rs1.getString("ref_note_text1");
		x_denomenator =(rs1.getString("ref_note_text1")==null)? "":(rs1.getString("ref_note_text1"));
	    xd_readonly = "readonly";
     }
 }

if (x_readonly==""){
	if ((eff_status.equals("S")) || (clind_type.equalsIgnoreCase("S"))) {
	    x_readonly = "readonly";
	}
	else if (eff_status.equals("E"))  {
	    x_readonly = "";
	}
	else if ((clind_type=="") ||(clind_type==null))
	    x_readonly = "";
 }


if (xd_readonly==""){
	if ((eff_status.equals("S")) || (clind_type.equalsIgnoreCase("S"))){
	    xd_readonly = "readonly";
	}
	else if (eff_status.equals("E")){
	    xd_readonly = "";
	}
 }

 if(pstmt!=null) pstmt.close();
 if(rs!=null) rs.close();

 if(pstmt1!=null) pstmt1.close();
 if(rs1!=null) rs1.close();

%>

</head>
	 <body OnMouseDown='CodeArrest()' onLoad='callFocus(1);disabletext();disablegestation("ges"); ' onKeyDown = 'lockKey()' onSelect="codeArrestThruSelect()">
	 <form name="qaindform" id="qaindform"  action='../../servlet/eQA.QAIndicatorServlet'   method="post" target="messageFrame"> 
	
	<a id="tab1" name="tab1" tabindex='0' onFocus='javascript:callFocus(1);'></a> 
	<table width='90%' cellpadding='0' cellspacing='0'  BORDER='0'>
	<tr></td>
	 <table width='100%' cellpadding='0' cellspacing='0' BORDER='0'><tr><td width='1%' class='BODYCOLORFILLED'>&nbsp;</td><td width='32%' class='BODYCOLORFILLED'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a align ='left' href="javascript:callFocus(1);" tabindex='-1'><img  src="../../eQA/images/indicatordark.gif"" border=0></a><a align='left' href="javascript:callFocus(2);"  tabindex='-1'><img  src="../../eQA/images/criterialight.gif"" border=0></a><% if(clind_type.equalsIgnoreCase("R")|| (clind_type.equalsIgnoreCase(""))) {%><a align='left' href="javascript:callFocus(3);"  tabindex='-1'><img  src="../../eCommon/images/LOthers.gif"" border=0></a> <%}%> </td><td width='56%' class='BODYCOLORFILLED'>&nbsp;</td></tr></table>
	 <table cellspacing='0' cellpadding='0' width='90%' border=0 align='center'>
	 <tr><td valign=top width='50%'><table cellspacing='0' cellpadding='0' width='90%' border=0 align='center'>
	 <tr><td colspan=2 class=label height=5></td></tr>
	<tr><td colspan=2>&nbsp;</td></tr>

		<tr><td colspan=2>&nbsp;</td></tr>
	
	<tr><td align='right' class='label'>Indicator ID&nbsp;&nbsp;</td><td>
	<% if(mode.equals("U")){%>
	<input type="text" name="qind_clind_id" id="qind_clind_id"   readonly value="<%=qind_clind_id%>" maxlength='4' size='4'  onfocus='' value='' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='CheckNum(this)'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<%}else if (mode.equals("I")){ %>
		<input type="text" name="qind_clind_id" id="qind_clind_id"  maxlength='4' size='4' tabIndex= '' onfocus='' value='' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='CheckNum(this)'>&nbsp;<img src='../../eCommon/images/mandatory.gif' ></img>
	</td>
	<%}%>
	</tr>

	<tr><td align='right' class='label' nowrap>Indicator Description&nbsp;&nbsp;</td><td><input type="text" name="qind_clind_desc" id="qind_clind_desc"   value="<%=qind_clind_desc%>"maxlength='60' size='60' tabIndex= '' onfocus='' value='' <%=readonly%> >&nbsp;<img src='../../eCommon/images/mandatory.gif'>
	</td></tr>
	
    <tr><td align='right' class='label'>Indicator Group&nbsp;&nbsp;</td><td><select name="qind_group_id" id="qind_group_id" <%=readonly%>>
    	 <option value=''>---Select--- </option>
	 <%
	 pstmt=con.prepareStatement("select  QIND_GROUP_ID, QIND_GROUP_DESC FROM QA_QIND_GROUP order by 2");
         rs=pstmt.executeQuery();
	  while(rs.next())
	  {
	 if(rs.getString(1).equals(qind_group_id))
		  {%>
	<option value='<%=rs.getString(1)%>' selected><%=rs.getString(2)%> </option>	  
	     
		  <%}else{%>
	 <option value='<%=rs.getString(1)%>'><%=rs.getString(2)%> </option>
	
	<%}}
	 if(pstmt!=null) pstmt.close();
	if(rs!=null) rs.close();
	%>
	</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
	</td></tr>
	

					
	<tr><td align='right' class='label' >Area Of Concern&nbsp;&nbsp;</td><td>
	<TEXTAREA  NAME="area_of_concern"   ROWS="3" COLS="30"  <%=readonly%> ><%=area_of_concern%></TEXTAREA>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
	</td></tr>

   	<tr><td align='right' class='label'>Indicator Type&nbsp;&nbsp;</td><td>
	<%if(mode.equals("U"))	{%>	
	<select name='clind_type' id='clind_type'  <%=readonly%> disabled>
<%} else {%>
		<select name='clind_type' id='clind_type' onchange='hideothers();' <%=readonly%>>
		<%}%>
					<option value=''>---Select--- </option>
				<%	if(clind_type.equals("R"))
					{%>
					<option value='R' selected>Rational Based </option>
				<%}else
					{%>
					<option value='R'>Rational Based </option>
					<%}%>

                   <%	if(clind_type.equals("S"))
					{%>
				
					<option value='S' selected>Sentinal Event </option>
							<%}else
					{%>
			<option value='S'>Sentinal Event </option>
							<%}%>
	</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td></tr>
	
 	<tr><td align='right' class='label' nowrap>Standard Description&nbsp;&nbsp;</td><td><input type="text" name="standard_desc" id="standard_desc"   value="<%=standard_desc%>" maxlength='100' size='60' tabIndex= '' onfocus='' value='' <%=readonly%> >
	</td></tr>

   <tr><td align='right' class='label'>Standard Value&nbsp;&nbsp;</td><td >
   <SELECT name="standard_oper" id="standard_oper" <%=readonly%> >
    				
			<option value="">-------------&nbsp;Select&nbsp;-------------</option>
	<%if(std_operator.equals("GT"))
		{%>
		<option value='GT' selected>Greater Than</option>
		<%}else{%>
					<option value='GT'>Greater Than</option>
		<%}%>
	<%if(std_operator.equals("GE"))
		{%>
		<option value='GE' selected>Greater Than Or Equal To</option>
		<%}else{%>
					<option value='GE'>Greater Than Or Equal To</option>
		<%}%>
		
		<%if(std_operator.equals("LT"))
		{%>
		<option value='LT' selected>Less Than</option>
		<%}else{%>
	<option value='LT'>Less Than</option>
		<%}%>
       	<%if(std_operator.equals("LE"))
		{%>
		<option value='LE' selected>Less Than Or Equal To</option>
		<%}else{%>
	<option value='LE'>Less Than Or Equal To</option>
		<%}%>

		<%if(std_operator.equals("EQ"))
		{%>

		<option value='EQ' selected>Equal To</option>
		<%}else{%>
		<option value='EQ'>Equal To</option>
		<%}%>
		</SELECT>&nbsp;&nbsp;
	    <input type="text" name="standard_value" id="standard_value"  onBlur='CheckNum(this)' maxlength='7' size='7' tabIndex= ''  value="<%=std_value%>" <%=readonly%>>
	</td></tr>

<tr><td align='right' class='label'>Classification Criteria&nbsp;&nbsp;</td><td>
<%if(mode.equals("U"))	{%>
<select name='clind_class' id='clind_class'  <%=readonly%> onChange='disablegestation("surg")' disabled>
<%} else {%>
	<select name='clind_class' id='clind_class'  onChange='disablegestation("surg")' >
<%}%>
			<option value=''>---------------&nbsp;Select&nbsp;---------------- </option>
		 <%	if(clind_class.equals("D")){%>
  		<option value='D' selected>Diagnosis-based </option>
        <%}else{%>
			<option value='D'>Diagnosis-based </option>
		 <%}%>
		 <% 	if(clind_class.equals("P")){%>
  		<option value='P' selected>Procedure-based </option>
        <%}else{%>
			<option value='P'>Procedure-based </option>
		 <%}%>
		  <% if(clind_class.equals("Z")){%>
  		<option value='Z' selected>Diagnosis/Procedure-based </option>
        <%}else{%>
			<option value='Z'>Diagnosis/Procedure-based </option>
		 <%}%>

        <%	if(clind_class.equals("O")){%>
  		<option value='O' selected>Orderable-based </option>
        <%}else{%>
		<option value='O'>Orderable-based </option>
		 <%}%>
		 <%	if(clind_class.equals("I")){%>
  		<option value='I'>Incident-based </option>
        <%}else{%>
			<option value='I'>Incident-based </option>
		 <%}%>
		 <%	if(clind_class.equals("R")){%>
  		<option value='R' selected>Direct Reporting </option>
        <%}else{%>
			<option value='R'>Direct Reporting </option>
		 <%}%>

			<%	if(clind_class.equals("S")){%>
  		<option value='S' selected>Source Based - RIS</option>
        <%}else{%>
			<option value='S'>Source Based - RIS</option>
		 <%}%>
				<%	if(clind_class.equals("M")){%>
  		<option value='M' selected>Source Based - OTMS</option>
        <%}else{%>
			<option value='M'>Source Based - OTMS</option>
		 <%}%>
			
			<%	if(clind_class.equals("A")){%>
  		<option value='A' selected>Source Based - A&E</option>
        <%}else{%>
			<option value='A'>Source Based - A&E</option>
		 <%}%>
				<%	if(clind_class.equals("N")){%>
  		<option value='N' selected>Source Based - IP</option>
        <%}else{%>
			<option value='N'>Source Based - IP</option>
		 <%}%>

	</select>&nbsp;</td></tr>
	<tr><td colspan=2>&nbsp;</td></tr>
		<tr><td colspan=2 class=label><B>Default reporting Criteria</B>&nbsp;</td></tr>
		<tr><td colspan=2>&nbsp;</td></tr>
<tr><td align='right' class='label'>Default Periodicity&nbsp;&nbsp;</td>
	<td>	<select name='dflt_rep_periodicity' id='dflt_rep_periodicity' <%=readonly%>>
 				<option value=''>---Select--- </option>
		<%if(dflt_rep_periodicity.equals("M"))
		{%>
		<option value='M' selected>Monthly </option>
		<%}else{%>
				<option value='M'>Monthly </option>
		<%}%>
		<%if(dflt_rep_periodicity.equals("Q"))
		{%>
		<option value='Q' selected>Quarterly </option>
		<%}else{%>
<option value='Q'>Quarterly </option>
		<%}%>

		<%if(dflt_rep_periodicity.equals("B"))
		{%>

		<option value='B' selected>Bi-Annually </option>
		<%}else{%>
	<option value='B'>Bi-Annually </option>
		<%}%>
			<%if(dflt_rep_periodicity.equals("A"))
		{%>

<option value='A' selected>Annually </option>
		<%}else{%>
		<option value='A'>Annually </option>
		<%}%>
		
				
			
				</select>
	</td>
	</tr>
	<!-- 
	<tr><td align='right' class='label'>Default Age Range&nbsp;&nbsp;</td><td><input type="text" name="dflt_bd_age_range_id" id="dflt_bd_age_range_id" onKeyPress='return(ChkNumberInput(this,event,0))' maxlength='3' size='4' tabIndex= '' onfocus='' onBlur='CheckNum(this)'value="<%=dflt_bd_age_range_id%>" <%=readonly%>>
	</td></tr>
	<tr><td align='right' class='label' nowrap>Default Gender For Reports&nbsp;&nbsp;</td><td>
	<%if(dflt_bd_by_gender_yn.equals("Y"))
	{%>
	<input type='checkbox' checked  value='Y' name='dflt_bd_by_gender_yn' id='dflt_bd_by_gender_yn' <%=readonly%>></td></tr>
	<%}else{%>
	<input type='checkbox'  value='N' name='dflt_bd_by_gender_yn' id='dflt_bd_by_gender_yn' <%=readonly%>></td></tr>
	<%}%> -->
	
	<tr><td align='right' class='label'>Enabled&nbsp;</td>
	<td><%if(eff_status.equals("E"))
	{%>
	<input type='checkbox'  checked name='eff_status' id='eff_status' value='E'   >
	<%}else{%>
	<input type='checkbox'  name='eff_status' id='eff_status' value='D'   >
	<%}%>
	</td></tr>
<tr><td colspan=2>&nbsp;</td></tr>
	<tr><td colspan=2>&nbsp;</td></tr>
	


	</table></table>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

<a id="tab2" name="tab2" tabindex='0' onFocus='javascript:callFocus(2);'></a> 

	<table width='90%' cellpadding='0' cellspacing='0'  BORDER='0'>
	<tr></td>
	 <table width='100%' cellpadding='0' cellspacing='0' BORDER='0'><tr><td width='1%' class='BODYCOLORFILLED'>&nbsp;</td><td width='32%' class='BODYCOLORFILLED'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a align ='left' href="javascript:callFocus(1);" tabindex='-1'><img  src="../../eQA/images/indicatorlight.gif" border=0></a><a align='left' href="javascript:callFocus(2);"  tabindex='-1'><img  src="../../eQA/images/criteriadark.gif" border=0></a><%if((clind_type.equalsIgnoreCase("R")) || (clind_type.equalsIgnoreCase("")) ){%><a align='left' href="javascript:callFocus(3);"  tabindex='-1'><img  src="../../eCommon/images/LOthers.gif"" border=0></a><%}%></td><td width='56%' class='BODYCOLORFILLED'>&nbsp;</td></tr></table>
	 <table cellspacing='0' cellpadding='0' width='90%' border=0 align='center' >
	 <tr><td valign=top width='50%'><table cellspacing='0' cellpadding='0' width='90%' border=0 align='center'>
	 <tr><td colspan=3 class=label height=5></td></tr>
	<tr><td colspan=3 class=Label>&nbsp;</td></tr>
	
	<tr><td align='right' class='label'>Gender&nbsp;&nbsp;</td>
		<td><select name='gender' id='gender' <%=readonly%> onChange='disablegestation("ges")'>
 				<option value=''>---Select--- </option>
				<%if(gender.equals("M"))
				{%>
				<option value='M' selected>Male </option>
				<%}else{%>
				<option value='M'>Male </option>
	            <%}%>
				<%if(gender.equals("F"))
				{%>
				<option value='F' selected>Female </option>
				<%}else{%>
	<option value='F'>Female </option>
	              <%}%>

               <%if(gender.equals("U"))
				{%>
				
				<option value='U' selected>Unknown</option>
				<%}else{%>
<option value='U'>Unknown</option>
				<%}%>

				</select>
	</td>
	<td>&nbsp;</td>
	</tr>
	
	<tr><td align='right' class='label'>Age Range&nbsp;&nbsp;</td>
	<td><select type='list' name='age_range' id='age_range'  OnChange='disabletext()' <%=readonly%>>
	<option value="0">---Select--</option>

		<%

		if(age_operator.equals("GT"))
		{%>
		<option  value='1' selected> Greater Than </option>
		<%}else{%>
					<option  value='1'> Greater Than </option>
		<%}%>
		
		<%if(age_operator.trim().equals("GE"))
		{%>

		<option value='2' selected> Greater Than Or Equal To </option>
		<%}else{%>
		<option value='2'>  Greater Than Or Equal To </option>
		<%}%>

		<%if(age_operator.equals("LT"))
		{%>
		<option value='3' selected> Less Than </option>
		<%}else{%>
		<option value='3'> Less Than </option>
		<%}%>

		
	<%if(age_operator.trim().equals("LE"))
		{%>

		<option value='4' selected>Less Than Or Equal To</option>
		<%}else{%>
		<option value='4'>  Less Than Or Equal To</option>
		<%}%>


		<%if(age_operator.trim().equals("BT"))
		{%>

		<option value='5' selected> Between </option>
		<%}else{%>
		<option value='5'> Between </option>
		<%}%>
				<%%>
			
				</select>
				</td>
	            <td align=left >
				<input type ='text'   value="<%=age_range1%>" name='day' size='3'  maxlength='3' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='CheckNum(this)' <%=readonly%>>
            	<input type ='text'  name = 'month'  value="<%=age_range2%>" size='3' maxlength='3' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='CheckNum(this)' <%=readonly%>>
				<select type='List' name='year' id='year' <%=readonly%>>
			<option value="">---Select--</option>
					<%if(age_in_dmy.equals("Y"))
		{%>
		<option  value='Y' selected>Years </option>
		<%}else{%>
					<option  value='Y'>Years </option>
		<%}%>
		<%if(age_in_dmy.equals("M"))
		{%>
		<option  value='M' selected>Months </option>
		<%}else{%>
		<option  value='M'>Months </option>
		<%}%>

		<%if(age_in_dmy.equals("D"))
		{%>

			<option  value='D' selected>Days </option>
		<%}else{%>
			<option  value='D'>Days </option>
		<%}%>


				

				
				
			
		
			</select>&nbsp;<img src='../../eCommon/images/mandatory.gif' id='gif'></img>
	</td>
	</tr>
	
	<tr><td align='right' class='label'  width='' >Patient Class&nbsp;&nbsp;</td><td class=label colspan='2'>
	IP<input type='checkbox' name='IP' id='IP'  <%=patient_class_ip%>    value='IP'  <%=readonly%> >&nbsp; &nbsp;
	OP<input type='checkbox' name='OP' id='OP' <%=patient_class_op%>   value='OP' <%=readonly%>>&nbsp;&nbsp;
	DC<input type='checkbox' name='DC' id='DC'  <%=patient_class_dc%>  value='DC' <%=readonly%> >EM&nbsp;&nbsp;<input type='checkbox' name='EM' id='EM'   <%=patient_class_em%> value='EM' <%=readonly%>>&nbsp;&nbsp;XT<input type='checkbox' name='XT' id='XT' <%=patient_class_xt%>    value='XT'  <%=readonly%>>&nbsp; 
	</td>
	</tr>
	<!-- ADDED ON 1ST OCT 2006.....By Yadav -->
	<!-- modified by shashi on 23/10/06 -->
<%	String legend="GCS Event Type/Code";
		String rec_fit_ev="Recurrent Fits event Type /code";
		String fib_ev="Fibroid event Type /code";
		String cst_ev="Cyst event Type /code";
		String gcs_scor="GCS Score";
		String hb_leg ="Hb event Type /code";
    	//String s=request.getParameter("qind_clind_id");
		String s = request.getParameter("qind_clind_id")==null?"":request.getParameter("qind_clind_id");
		if(s.equals("14"))
		{
		     legend=rec_fit_ev;
			 gcs_scor="value";
		}
		else if(s.equals("20"))
		{
			 legend=fib_ev;
			 gcs_scor="value";
		}
		else if(s.equals("21"))
		{
			 legend=cst_ev;
			 gcs_scor="value";
		} 
		else if(s.equals("15"))
		{
			 legend=hb_leg;
			 gcs_scor="Result";
		} 
		// added by shashi on 09/02/2007 
		else if(s.equals("46"))
		{
			 legend="Denominator Event Type/Code";
			 gcs_scor="Value";
		} 
		else if(s.equals("25"))
		{
			 legend="Thrombolysis Event Type/Code";
			 gcs_scor="Value";
		} 
		else if ((s.equals("34")) || (s.equals("35")))
		{
			 legend="Denominator Event Type/Code";
			 gcs_scor="Value";
		} 
		else if(s.equals("45"))
		{
			 legend="Event Type/Code";
			 gcs_scor="Value";
		} 
		 
	%>
	<!----------------------------------------------->

 	<tr><td align='right' class='label'><%=legend%>&nbsp;&nbsp;</td><td width='1%'>
	<input type='text' name='gcs_event_code1' id='gcs_event_code1'  value= "<%=gcs_event_type%>" size=10 maxlength=6 <%=readonly%>></td>
	<td align=left><input type='text' name='gcs_event_code2' id='gcs_event_code2'   value= "<%=gcs_event_code%>" size=10 maxlength=20 <%=readonly%>>
	</td></tr>
	
	<tr><td align='right' class='label'><%=gcs_scor%>&nbsp;&nbsp;</td><td> 
	<SELECT name="gcsScore1" id="gcsScore1" <%=readonly%>>
 				<option value=''>---Select--- </option>
	<%if(gcs_operator.equals("GT"))
		{%>
		<option value='GT' selected>Greater Than</option>
		<%}else{%>
					<option value='GT'>Greater Than</option>
		<%}%>

      <%if(gcs_operator.equals("GE"))
		{%>
		<option value='GE' selected>Greater Than Or Equal To</option>
		<%}else{%>
					<option value='GE'>Greater Than Or Equal To</option>
		<%}%>


		<%if(gcs_operator.equals("LT"))
		{%>
		<option value='LT' selected>Less Than</option>
		<%}else{%>
	<option value='LT'>Less Than </option>
		<%}%>
    <%if(gcs_operator.equals("LE"))
		{%>
		<option value='LE' selected>Less Than  Or Equal To</option>
		<%}else{%>
	<option value='LE'>Less Than  Or Equal To</option>
		<%}%>
		<%if(gcs_operator.equals("EQ"))
		{%>

		<option value='EQ' selected>Equal To</option>
		<%}else{%>
		<option value='EQ'>Equal To</option>
		<%}%>

			</SELECT>&nbsp; 
			</td><td>
            <input type='text' name='gcsScore2' id='gcsScore2'   value='<%=gcs_score%>'size=10   maxlength=5  <%=readonly%>>&nbsp; <br>
	</td></tr>
	
   <tr><td align='right' class='label'>Post Operative Length of Stay&nbsp;&nbsp;</td><td>
   <SELECT name="post_op_los1" id="post_op_los1" <%=readonly%>>
    				
			<option value="">---Select--</option>
	<%if(post_of_los_operator.equals("GT"))
		{%>
		<option value='GT' selected>Greater Than</option>
		<%}else{%>
					<option value='GT'>Greater Than</option>
		<%}%>
	<%if(post_of_los_operator.equals("GE"))
		{%>
		<option value='GE' selected>Greater Than Or Equal To</option>
		<%}else{%>
					<option value='GE'>Greater Than Or Equal To</option>
		<%}%>
		
		<%if(post_of_los_operator.equals("LT"))
		{%>
		<option value='LT' selected>Less Than</option>
		<%}else{%>
	<option value='LT'>Less Than</option>
		<%}%>
       	<%if(post_of_los_operator.equals("LE"))
		{%>
		<option value='LE' selected>Less Than Or Equal To</option>
		<%}else{%>
	<option value='LE'>Less Than Or Equal To</option>
		<%}%>

		<%if(post_of_los_operator.equals("EQ"))
		{%>

		<option value='EQ' selected>Equal To</option>
		<%}else{%>
		<option value='EQ'>Equal To</option>
		<%}%>
			
			</SELECT>&nbsp
			</td><td>
   <input type='text' name='post_op_los' id='post_op_los' onKeyPress='return(ChkNumberInput(this,event,0))' value="<%=post_of_los%>" size=10 maxlength=5 onBlur='CheckNum(this)' <%=readonly%>>&nbsp;
	</td></tr>
	
<tr><td align='right' class='label'>Re-Admit-Days&nbsp;&nbsp;</td><td>
<SELECT name="re_admit_days1" id="re_admit_days1" <%=readonly%> >
			<option value="">---Select--</option>
			
	<%if(re_admit_days_operator.equals("GT"))
		{%>
		<option value='GT' selected>Greater Than</option>
		<%}else{%>
					<option value='GT'>Greater Than</option>
		<%}%>
	<%if(re_admit_days_operator.equals("GE"))
		{%>
		<option value='GE' selected>Greater Than Or Equal To</option>
		<%}else{%>
					<option value='GE'>Greater Than Or Equal To</option>
		<%}%>
		
		<%if(re_admit_days_operator.equals("LT"))
		{%>
		<option value='LT' selected>Less Than</option>
		<%}else{%>
	<option value='LT'>Less Than</option>
		<%}%>
   <%if(re_admit_days_operator.equals("LE"))
		{%>
		<option value='LE' selected>Less Than Or Equal To</option>
		<%}else{%>
	<option value='LE'>Less Than Or Equal To</option>
		<%}%>

		<%if(re_admit_days_operator.equals("EQ"))
		{%>

		<option value='EQ' selected>Equal To</option>
		<%}else{%>
		<option value='EQ'>Equal To</option>
		<%}%>
			
			</SELECT>&nbsp
			</td><td>
<input type='text' name='re_admit_days' id='re_admit_days'  size=10  maxlength=5 value="<%=re_admit_days%>" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='CheckNum(this)' <%=readonly%>>&nbsp; 
	</td></tr>
	<tr><td align='right' class='label' >Re-Admit-Hours&nbsp;&nbsp;</td><td>
	<SELECT name="re_admit_hours1" id="re_admit_hours1" <%=readonly%>>
	 				<option value=''>---Select--- </option>
	<%if(re_admit_hours_operator.equals("GT"))
		{%>
		<option value='GT' selected>Greater Than</option>
		<%}else{%>
					<option value='GT'>Greater Than</option>
		<%}%>
	
		<%if(re_admit_hours_operator.equals("GE"))
		{%>
		<option value='GE' selected>Greater Than Or Equal To</option>
		<%}else{%>
					<option value='GE'>Greater Than Or Equal To</option>
		<%}%>
	
		<%if(re_admit_hours_operator.equals("LT"))
		{%>
		<option value='LT' selected>Less Than</option>
		<%}else{%>
	<option value='LT'>Less Than</option>
		<%}%>
        <%if(re_admit_hours_operator.equals("LE"))
		{%>
		<option value='LE' selected>Less Than Or Equal To</option>
		<%}else{%>
	<option value='LE'>Less Than Or Equal To</option>
		<%}%>

		<%if(re_admit_hours_operator.equals("EQ"))
		{%>

		<option value='EQ' selected>Equal To</option>
		<%}else{%>
		<option value='EQ'>Equal To</option>
		<%}%>
			
			</SELECT>&nbsp
			</td><td>
	<input type='text' name='re_admit_hours' id='re_admit_hours'  size=10  maxlength=5 onKeyPress='return(ChkNumberInput(this,event,0))' value="<%=re_admit_hours%>" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='CheckNum(this)' <%=readonly%>>&nbsp;
	</td></tr>
<tr><td align='right' class='label'>Waterloo  Event Type/Code&nbsp;&nbsp;</td><td>
<input type='text' name='waterloo_event_type' id='waterloo_event_type'  value="<%=waterloo_event_type%>" size=10 maxlength=4 <%=readonly%>>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input type='text' name='waterloo_event_code' id='waterloo_event_code'   value= "<%=waterloo_event_code%>" size=10 maxlength=20 <%=readonly%>>
	</td></tr>


<tr><td align='right' class='label'>Waterloo Score&nbsp;&nbsp;</td><td>
<SELECT name="waterloo_score1" id="waterloo_score1" <%=readonly%>>
	 				<option value=''>---Select--- </option>
	<%if(waterloo_operator.equals("GT"))
		{%>
		<option value='GT' selected>Greater Than</option>
		<%}else{%>
					<option value='GT'>Greater Than</option>
		<%}%>
		<%if(waterloo_operator.equals("GE"))
		{%>
		<option value='GE' selected>Greater Than Or Equal To</option>
		<%}else{%>
					<option value='GE'>Greater Than Or Equal To</option>
		<%}%>
	
		<%if(waterloo_operator.equals("LT"))
		{%>
		<option value='LT' selected>Less Than</option>
		<%}else{%>
	<option value='LT'>Less Than</option>
		<%}%>

    	<%if(waterloo_operator.equals("LE"))
		{%>
		<option value='LE' selected>Less Than Or Equal To</option>
		<%}else{%>
	<option value='LE'>Less Than Or Equal To</option>
		<%}%>

		<%if(waterloo_operator.equals("EQ"))
		{%>

		<option value='EQ' selected>Equal To</option>
		<%}else{%>
		<option value='EQ'>Equal To</option>
		<%}%>
			
			</SELECT>&nbsp
			</td><td>
<input type='text' name='waterloo_score' id='waterloo_score' onKeyPress='return(ChkNumberInput(this,event,0))' value="<%=waterloo_score%>" maxlength=5 size=10 onBlur='CheckNum(this)' <%=readonly%>>&nbsp; 
	</td></tr>
	<tr><td align='right' class='label'>Gestation Period&nbsp;&nbsp;</td><td>
<SELECT name="gest_period_operator" id="gest_period_operator" <%=readonly%>>
	 				<option value=''>---Select--- </option>
	<%if(gest_period_operator.equals("GT"))
		{%>
		<option value='GT' selected>Greater Than</option>
		<%}else{%>
					<option value='GT'>Greater Than</option>
		<%}%>
	
		<%if(gest_period_operator.equals("GE"))
		{%>
		<option value='GE' selected>Greater Than Or Equal To</option>
		<%}else{%>
					<option value='GE'>Greater Than Or Equal To</option>
		<%}%>
	
		<%if(gest_period_operator.equals("LT"))
		{%>
		<option value='LT' selected>Less Than </option>
		<%}else{%>
	<option value='LT'>Less Than</option>
		<%}%>
         <%if(gest_period_operator.equals("LE"))
		{%>
		<option value='LE' selected>Less Than Or Equal To </option>
		<%}else{%>
	<option value='LE'>Less Than Or Equal To</option>
		<%}%>

 		<%if(gest_period_operator.equals("EQ"))
		{%>

		<option value='EQ' selected>Equal To</option>
		<%}else{%>
		<option value='EQ'>Equal To</option>
		<%}%>
			
		</SELECT>&nbsp
		</td>
		<td><input type='text' name='gest_period' id='gest_period' onKeyPress='return(ChkNumberInput(this,event,0))' value="<%=gest_period%>" size=10 onBlur='CheckNum(this)' maxlength=5 <%=readonly%>>&nbsp; 
<SELECT name="gest_period_in_dwmy" id="gest_period_in_dwmy" <%=readonly%>>
	 	<option value=''>---Select--- </option>			
	<%if(gest_period_in_dwmy.equals("D"))
		{%>
		<option value='D' selected>Days</option>
		<%}else{%>
					<option value='D'>Days</option>
		<%}%>
		<%if(gest_period_in_dwmy.equals("W"))
		{%>
		<option value='W' selected>Weeks</option>
		<%}else{%>
	<option value='W'>Weeks</option>
		<%}%>

		<%if(gest_period_in_dwmy.equals("M"))
		{%>

		<option value='M' selected>Months</option>
		<%}else{%>
		<option value='M'>Months</option>
		<%}%>
		
		<%if(gest_period_in_dwmy.equals("Y"))
		{%>

		<option value='Y' selected>Years</option>
		<%}else{%>
		<option value='Y'>Years</option>
		<%}%>
			
			</SELECT>
	</td></tr>
	<tr><td align='right' class='label' nowrap>Post Delivery Length of Stay&nbsp;&nbsp;</td><td>
<SELECT name="post_delv_los_operator" id="post_delv_los_operator" <%=readonly%>>
	 				<option value=''>---Select--- </option>
	<%if(post_delv_los_operator.equals("GT"))
		{%>
		<option value='GT' selected>Greater Than</option>
		<%}else{%>
					<option value='GT'>Greater Than</option>
		<%}%>
	<%if(post_delv_los_operator.equals("GE"))
		{%>
		<option value='GE' selected>Greater Than Or Equal To</option>
		<%}else{%>
					<option value='GE'>Greater Than Or Equal To</option>
		<%}%>
	
		<%if(post_delv_los_operator.equals("LT"))
		{%>
		<option value='LT' selected>Less Than</option>
		<%}else{%>
	<option value='LT'>Less Than</option>
		<%}%>

		<%if(post_delv_los_operator.equals("LE"))
		{%>
		<option value='LE' selected>Less Than Or Equal To</option>
		<%}else{%>
	<option value='LE'>Less Than Or Equal To</option>
		<%}%>

		<%if(post_delv_los_operator.equals("EQ"))
		{%>

		<option value='EQ' selected>Equal To</option>
		<%}else{%>
		<option value='EQ'>Equal To</option>
		<%}%>
			
			</SELECT>&nbsp
			</td><td>
<input type='text' name='post_delv_los' id='post_delv_los' onKeyPress='return(ChkNumberInput(this,event,0))' value="<%=post_delv_los%>" size=10 maxlength=5 onBlur='CheckNum(this)' <%=readonly%>>&nbsp; 
	</td></tr>
	<tr><td align='right' class='label'>Turn-around Time&nbsp;&nbsp;</td><td>
<SELECT name="tat_days_operator" id="tat_days_operator" <%=readonly%>>
	 				<option value=''>---Select--- </option>
	<%if(tat_days_operator.equals("GT"))
		{%>
		<option value='GT' selected>Greater Than</option>
		<%}else{%>
					<option value='GT'>Greater Than</option>
		<%}%>
		<%if(tat_days_operator.equals("GE"))
		{%>
		<option value='GE' selected>Greater Than Or Equal To</option>
		<%}else{%>
					<option value='GE'>Greater Than Or Equal To</option>
		<%}%>

		<%if(tat_days_operator.equals("LT"))

		{%>
		<option value='LT' selected>Less Than</option>
		<%}else{%>
	<option value='LT'>Less Than</option>
		<%}%>
   <%if(tat_days_operator.equals("LE"))

		{%>
		<option value='LE' selected>Less Than Or Equal To</option>
		<%}else{%>
	<option value='LE'>Less Than Or Equal To</option>
		<%}%>

		<%if(tat_days_operator.equals("EQ"))
		{%>

		<option value='EQ' selected>Equal To</option>
		<%}else{%>
		<option value='EQ'>Equal To</option>
		<%}%>
			
			</SELECT>&nbsp
			</td><td>
<input type='text' name='tat_days' id='tat_days' onKeyPress='return(ChkNumberInput(this,event,0))' value="<%=tat_days%>" size=10 onBlur='CheckNum(this)' maxlength=5 <%=readonly%>>&nbsp; 
	</td></tr>

<tr><td align='right' class='label'>Pregnancy Admission Type&nbsp;&nbsp;</td><td>
<input type='text' name='term_preg_adm_type' id='term_preg_adm_type'  value="<%=term_preg_adm_type%>" size=10 maxlength=5 <%=readonly%>> 
</td><td>&nbsp;</td></tr>

<tr><td class='label' align='right' nowrap>NOD Type for Normal Delivery&nbsp;&nbsp;</td>
<td align='left' >

<input type='text' name='nod_type' id='nod_type'  value="<%=nod_type%>" size=3 maxlength=2 <%=readonly%>>
</td>
<td>&nbsp;</td></tr>

	<tr><td class='label' align='right' nowrap>Surgery Type&nbsp;&nbsp;</td>
<td align='left' >
<SELECT name="surg_type" id="surg_type" <%=readonly%>>
		<option value=''>---Select--- </option>
		<%if(surg_type.equals("EL"))
		{%>
		<option value='EL' selected>Elective</option>
		<%}else{%>
		<option value='EL'>Elective</option>
		<%}%>
		<%if(surg_type.equals("EM"))
		{%>
		<option value='EM' selected>Emergency</option>
		<%}else{%>
		<option value='EM'>Emergency</option>
		<%}%>
</select>
</td>
<td>&nbsp;</td></tr>

<!-- <tr><td class='label' align='right' nowrap>Limit for Report Turn-Around Time&nbsp;&nbsp;</td>
<td align='left' >
<input type='hidden' name='lmt_rpt_trn_time' id='lmt_rpt_trn_time' onKeyPress='return(ChkNumberInput(this,event,0))' value="<%=lmt_rpt_trn_time%>" size=2 maxlength=1 <%=readonly%> onBlur='callFocus(1);'>
 </td>
<td>&nbsp;</td></tr> -->
 
 	<tr><td align='right' class='label'>Numerator Event Type/Code&nbsp;&nbsp;</td><td width='1%'>
	<input type='text' name='num_event_type' id='num_event_type'  value= "<%=num_event_type%>" size=10 maxlength=6 <%=readonly%>></td>
		<td align=left><input type='text' name='num_event_code' id='num_event_code'   value= "<%=num_event_code%>" size=10 maxlength=20 <%=readonly%>>
	</td></tr>
	
	<tr><td align='right' class='label'>Value&nbsp;&nbsp;</td><td> 
	<SELECT name='num_operator1' id='num_operator1' <%=readonly%>>
 				<option value=''>---Select--- </option>
	<%if(num_operator.equals("GT"))
		{%>
		<option value='GT' selected>Greater Than</option>
		<%}else{%>
					<option value='GT'>Greater Than</option>
		<%}%>
      <%if(num_operator.equals("GE"))
		{%>
		<option value='GE' selected>Greater Than Or Equal To</option>
		<%}else{%>
					<option value='GE'>Greater Than Or Equal To</option>
		<%}%>


		<%if(num_operator.equals("LT"))
		{%>
		<option value='LT' selected>Less Than</option>
		<%}else{%>
	<option value='LT'>Less Than </option>
		<%}%>
    <%if(num_operator.equals("LE"))
		{%>
		<option value='LE' selected>Less Than  Or Equal To</option>
		<%}else{%>
	<option value='LE'>Less Than  Or Equal To</option>
		<%}%>
		<%if(num_operator.equals("EQ"))
		{%>

		<option value='EQ' selected>Equal To</option>
		<%}else{%>
		<option value='EQ'>Equal To</option>
		<%}%>		
			</SELECT>&nbsp; 
			</td><td>
            <input type='text' name='num_score' id='num_score'   value='<%=num_score%>'size=10   maxlength=5  <%=readonly%>>&nbsp; <br>
	</td></tr>

	<tr><td colspan=3>&nbsp;</td></tr>
	<tr><td colspan=3>&nbsp;</td></tr>
	</table></table>
	<Input type=hidden name=indgrp id=indgrp value="">
	<Input type=hidden name=concatValues id=concatValues value="">
	<Input type=hidden name=mode id=mode value="<%=mode%>">
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

	<a  id ="tab3" name="tab3" tabindex='0' onFocus='javascript:callFocus(3);'></a> 

	<table width='90%' cellpadding='0' cellspacing='0'  BORDER='0'>
	<tr></td>
	 <table width='100%' cellpadding='0' cellspacing='0' BORDER='0'><tr><td width='1%' class='BODYCOLORFILLED'>&nbsp;</td><td width='32%' class='BODYCOLORFILLED'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a align ='left' href="javascript:callFocus(1);" tabindex='-1'><img  src="../../eQA/images/indicatorlight.gif"" border=0></a><a align='left' href="javascript:callFocus(2);"  tabindex='-1'><img  src="../../eQA/images/criterialight.gif"" border=0></a><a align='left' href="javascript:callFocus(3);"  tabindex='-1'><img  src="../../eCommon/images/Others.gif"" border=0></a></td><td width='56%' class='BODYCOLORFILLED'>&nbsp;</td></tr></table>
	 <table cellspacing='0' cellpadding='0' width='90%' border=0 align='center'>
	 <tr><td valign=top width='50%'><table cellspacing='0' cellpadding='0' width='90%' border=0 align='center'>
	 <tr><td colspan=2 class=label height=5></td></tr>
	<tr><td colspan=2>&nbsp;</td></tr>

	<tr><td align='right' class='label' >Numerator &nbsp;&nbsp;</td><td>
	<TEXTAREA  NAME="numerator"   ROWS="3" COLS="50" onBlur="checkMaxLimit(this,500);makeValidString(this)" <%=x_readonly%> ><%=x_numerator%></TEXTAREA>&nbsp;
	</td></tr>

	<tr><td align='right' class='label' >Denominator &nbsp;&nbsp;</td><td>
	<TEXTAREA  NAME="denomenator"   ROWS="3" COLS="50"  onBlur="checkMaxLimit(this,500);makeValidString(this); " <%=xd_readonly%>  > <%=x_denomenator%></TEXTAREA>&nbsp;
	</td></tr>


    <tr><td colspan=2>&nbsp;</td></tr>
	<tr><td colspan=2>&nbsp;</td></tr>
	<tr><td colspan=2>&nbsp;</td></tr>

	</table></table>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

	<input type="hidden" name="dflt_bd_age_range_id" id="dflt_bd_age_range_id"  value="">
	<input type="hidden" name="dflt_bd_by_gender_yn" id="dflt_bd_by_gender_yn"  value="">
	<input type="hidden" name="lmt_rpt_trn_time" id="lmt_rpt_trn_time"      value="">
	</form>

</body>
</html>		
	 
	<%
	}catch(Exception e)
	{
		out.println("Exception in addModifyQAIndicator.jsp : "+e.toString());
		e.printStackTrace(System.out);
	 
	}   
	finally   
	{
		ConnectionManager.returnConnection(con,request);  
	}
	%> 

