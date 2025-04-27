<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.PreparedStatement,java.sql.ResultSet, webbeans.eCommon.ConnectionManager"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 

%>

<html>
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
  <script language="javascript" src="../../eMP/js/PatEncBanner.js"></script>
</head>

<%

 
  request.setCharacterEncoding("UTF-8");
  Connection con = ConnectionManager.getConnection(request);
  ResultSet rs = null;
  Statement stmt = null;
  PreparedStatement pstmt = null;//Added For PE On 6/10/2010
  String chkAttribute="";
  String chkdisable="";
  String all_disabled=" ";
           /*Below line added for this CRF Bru-HIMS-CRF-133*/	
        String isPatientEncMovement=request.getParameter("isPatientEncMovement")==null?"":request.getParameter("isPatientEncMovement");
        String Sydate=request.getParameter("Sydate")==null?"":request.getParameter("Sydate");
        String p_queue_date=request.getParameter("p_queue_date")==null?"":request.getParameter("p_queue_date");
        String p_queue_status=request.getParameter("p_queue_status")==null?"":request.getParameter("p_queue_status");
		
	  //End this CRF Bru-HIMS-CRF-133		
  String locale = (String)session.getAttribute("LOCALE");
  boolean diplay_mandatory=false;
    String status = request.getParameter("status");
	if(status == null) status = "";
status=java.net.URLDecoder.decode(status);
//ArrayList list=new ArrayList();//commented for checkstyle
	String status_r = "";
	String adv_event_rxn_srl_no="";
	//String final_reaction="";
	//String final_date="";
	//String final_severity="";
	//String final_site="";
	//String final_reac="";
	//String final_date1="";
	//String final_severity1="";
	//String final_site1="";
	//int tempcount=0;

	if(status.equals("R") || status.equals("E"))
	{
		status_r = "disabled";
		

	}
	
    String adding_react_yn = request.getParameter("adding_react_yn");
	if(adding_react_yn==null)
		adding_react_yn="N";

  String reac_code_val=request.getParameter("reac_code_val");
  if(reac_code_val ==null) reac_code_val="";
reac_code_val=java.net.URLDecoder.decode(reac_code_val);

//out.println("<script>alert(\""+reac_code_val+"\");</script>");
  String otr_reaction=request.getParameter("otr_reaction");
  if(otr_reaction ==null) otr_reaction="";
otr_reaction=java.net.URLDecoder.decode(otr_reaction);
  String reac_desc_val=request.getParameter("reac_desc_val");
  if(reac_desc_val ==null) reac_desc_val="";
  
  String mode=request.getParameter("mode");
 
 if(mode ==null || mode=="") mode="insert";
 //
if(mode.equals("insert")){
	//chkAttribute="CHECKED";
	//out.println(chkAttribute);
}
/*if(mode.equals("record")){
	if(!status.equals("Active"))
	{
	chkdisable= "DISABLED";
	chkAttribute="";
	}
	//out.println(chkdisable);

}*/


  String PatientId=request.getParameter("PatientId");
  if(PatientId ==null) PatientId="";
PatientId=java.net.URLDecoder.decode(PatientId);

   String Encounter_Id=request.getParameter("Encounter_Id");
  if(Encounter_Id ==null) Encounter_Id="";
Encounter_Id=java.net.URLDecoder.decode(Encounter_Id);

  String reaction_date_modify=request.getParameter("reaction_date");
  if(reaction_date_modify ==null) reaction_date_modify="";
  reaction_date_modify=java.net.URLDecoder.decode(reaction_date_modify);
  String causative_code=request.getParameter("causative_code");
  if(causative_code ==null) causative_code="";
	causative_code=java.net.URLDecoder.decode(causative_code);

  String adv_event_type_code=request.getParameter("adv_event_type_code");
  if(adv_event_type_code ==null) adv_event_type_code="";
  adv_event_type_code=java.net.URLDecoder.decode(adv_event_type_code);

  String adv_event_type_ind_code=request.getParameter("adv_event_type_ind_code");
  if(adv_event_type_ind_code ==null) adv_event_type_ind_code="";
adv_event_type_ind_code=java.net.URLDecoder.decode(adv_event_type_ind_code);
  

  String allergen_blank = request.getParameter("allergen_blank");
  if(allergen_blank==null)
   all_disabled ="disabled";

String onset_date = request.getParameter("onset_date");
if(onset_date == null) onset_date = "";
onset_date=java.net.URLDecoder.decode(onset_date);
//out.println("<script>alert(\""+onset_date+"\");</script>");
 //if(allergen_blank ==null) allergen_blank="";
//if(allergen_blank.equals(null)  || allergen_blank==null)
//if(allergen_blank.equals(null)  || allergen_blank==null||allergen_blank.equals("null"))
			//String all_disabled ="disabled";
   //String reactioncode="";
   String reactDesc=" ";
  String reactiondesc_total="";
  String reaction_desc="";
  String reaction_date="";
  String reaction_date1_disply="";
  String onset_date_disply="";
  String sysdate="";
  String reac_code ="";
  String reaction_date_modify_disply="";
  String oth_reaction="";
  String final_value="";
  String adv_reac_code="";
  String err_status="";

  String disableField="";
onset_date_disply=DateUtils.convertDate(onset_date,"DMYHMS","en",locale);
//out.println("<script>alert(\""+onset_date_disply+"\");</script>");

	
 
  String allengy_dis=checkForNull(request.getParameter("causative_code"));
  String AllergyConfirmYN=checkForNull(request.getParameter("AllergyConfirmYN"));//Added for the crf - RUT-CRF-0064
  String allergy_conf_reqd_yn=checkForNull(request.getParameter("allergy_conf_reqd_yn"));//Added for the crf - RUT-CRF-0064
if(allengy_dis==""||allengy_dis.equals(" ")){
  disableField="disabled";
}
else{
		disableField="";
}
  int i=0;
  int other_reaction_counter = 0;

  int max_record = 0;


	try 
	{
//		Commented On 6/10/2010 for PE
//	stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		stmt=con.createStatement();
		String sql="SELECT to_char(SYSDATE,'dd/mm/yyyy hh24:mi') FROM dual";
		rs=stmt.executeQuery(sql);
		if(rs !=null && rs.next()){
			reaction_date=rs.getString(1);
		}
		sysdate = reaction_date;
		if(stmt!=null){stmt.close();}
		if(rs!=null){rs.close();}

/*Wednesday, December 23, 2009 modified for SRR20056-CRF-0303.1 [IN015407] ,to display reaction date as active since date*/
	String reaction_date_disply=request.getParameter("reaction_date_disply");
	if(reaction_date_disply ==null) reaction_date_disply="";
	//reaction_date_disply=java.net.URLDecoder.decode(reaction_date_disply);
	//reaction_date1_disply=DateUtils.convertDate(reaction_date_disply,"DMYHM","en",locale);
	/*Tuesday, September 28, 2010 , SRR20056-SCF-5367 [IN:024015]*/
	reaction_date1_disply=java.net.URLDecoder.decode(reaction_date_disply);
	String localeSysDate =DateUtils.convertDate(sysdate,"DMYHM","en",locale); //INC:47616

 if (rs != null) rs.close();

%><body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'  onload='setTimeout("load_reaction_table()",500);'> 
 
  <form name = 'reaction_part' action='../../servlet/eMR.RecordAdverseEventServlet' method='post' target='messageFrame'>
   <input type='hidden' name='react_code_final' id='react_code_final' value='<%=reac_code_val%>'>
   <input type='hidden' name='reac_desc_val' id='reac_desc_val' value='<%=reac_desc_val%>'>
   <input type='hidden' name='reac_desc1_val' id='reac_desc1_val' value=''>
   <input type='hidden' name='otr_reaction' id='otr_reaction' value='<%=otr_reaction%>'>
  
<input type='hidden' name='reaction_value' id='reaction_value' value=''>
 <input type='hidden' name='mode' id='mode' value='<%=mode%>'>
 <input type='hidden' name='sysdate' id='sysdate' value='<%=sysdate%>'>
  <input type='hidden' name='adv_event_type' id='adv_event_type' value=''>
  <input type='hidden' name='onset_date' id='onset_date' value=''>
 <input type='hidden' name='allergen_id' id='allergen_id' value=''>
 <!--Added by Thamizh selvi on 22nd Dec 2017 against ML-MMOH-CRF-0751 Start-->
  <input type='hidden' name='allergen_free_text' id='allergen_free_text' value=''>
  <input type='hidden' name='advEventSrlNo' id='advEventSrlNo' value=''>
  <!--End-->
  <input type='hidden' name='allergyAlertby' id='allergyAlertby' value=''>
 <input type='hidden' name='cause_sub' id='cause_sub' value=''>
 <input type='hidden' name='adv_event_ind' id='adv_event_ind' value=''>
 <input type='hidden' name='certainity' id='certainity' value=''>
 <input type='hidden' name='sou_of_info' id='sou_of_info' value=''>
 <input type='hidden' name='status_val' id='status_val' value=''>
 <input type='hidden' name='since_date' id='since_date' value=''>
 <input type='hidden' name='diagnosis_code' id='diagnosis_code' value=''>
 <input type='hidden' name='route_of_expo' id='route_of_expo' value=''>
 <input type='hidden' name='allergy_test_res' id='allergy_test_res' value=''>
 <input type='hidden' name='treat_advice' id='treat_advice' value=''>
 <input type='hidden' name='remarks' id='remarks' value=''>
 <input type='hidden' name='drug_code' id='drug_code' value=''>
 <input type='hidden' name='PatientId' id='PatientId' value='<%=PatientId%>'>
 <input type='hidden' name='Encounter_Id' id='Encounter_Id' value='<%=Encounter_Id%>'>
 <input type='hidden' name='date_time' id='date_time' value=''>
 <input type='hidden' name='allergen' id='allergen' value='<%=causative_code%>'>
 <input type='hidden' name='causative_code' id='causative_code' value=''>
<input type='hidden' name='status1' id='status1' value=''>
<input type='hidden' name='err_remark' id='err_remark' value=''>
<input type='hidden' name='term_code' id='term_code' value=''>
<input type='hidden' name='no_known_allergy' id='no_known_allergy' value=''>
<input type='hidden' name='estimated_duration_yn' id='estimated_duration_yn' value=''>
<input type='hidden' name='add_reation_yn' id='add_reation_yn' value=''>
<input type='hidden' name='check_stat' id='check_stat' value=''>
<input type='hidden' name='AllergyConfirmYN' id='AllergyConfirmYN' value='<%=AllergyConfirmYN%>'><!--  ADDED FOR THE CRF - RUT-CRF-0064 -->
<input type='hidden' name='allergy_conf_reqd_yn' id='allergy_conf_reqd_yn' value='<%=allergy_conf_reqd_yn%>'><!--  ADDED FOR THE CRF - RUT-CRF-0064 -->
<!-- Below lines added by venkatesh.S against ML-MMOH-CRF-0366 -->
<input type='hidden' name='onset_type' id='onset_type' value=''> 
<input type='hidden' name='comments' id='comments' value=''> 
<!-- end ML-MMOH-CRF-0366 -->

   <!-- Below line added for this CRF Bru-HIMS-CRF-133 -->
	<input type="hidden" name="isPatientEncMovement" id="isPatientEncMovement" value="<%=isPatientEncMovement%>">
	<input type="hidden" name="Sydate" id="Sydate" value="<%=Sydate%>">
	<input type="hidden" name="p_queue_date" id="p_queue_date" value="<%=p_queue_date%>">
	<input type="hidden" name="p_queue_status" id="p_queue_status" value="<%=p_queue_status%>">
	<!-- End Bru-HIMS-CRF-133 -->


<table cellpadding='0' id='reaction_table' name='reaction_table' border='1' cellspacing='0' width='100%' align='center' style='display:none' >	
	<%if(mode.equals("record")){%>
	<th width='20%'><div  id='head0' class='myClass' nowrap width='25%' ></div></th>
	<%}%>
	<th width='20%'><div  id='head1' class='myClass' nowrap width='25%'><fmt:message key="eMR.reactiondesc.label" bundle="${mr_labels}"/></div></th>
	<th width='30%'><div  id='head2' class='myClass' nowrap width='25%'><fmt:message key="Common.ReactionDate.label" bundle="${common_labels}"/></div></th>
	<th width='25%'><div  id='head3' class='myClass' nowrap width='25%'><fmt:message key="Common.Severity.label" bundle="${common_labels}"/></div></th>
	<th width='25%'><div  id='head4' class='myClass' nowrap width='25%'><fmt:message key="eMR.SiteOfReaction.label" bundle="${mr_labels}"/></div></th>
 <% 
	String sql_default_values="";

/*The Below Query was modified for PE changed to PreparedStatement from Statement.*/
	sql_default_values= " SELECT  f.ADV_REAC_CODE   ,g.LONG_DESC LONG_DESC,to_char(f.reaction_date,'dd/mm/yyyy hh24:mi') reaction_date ,f.OTHERS_REACTION,f.SEVERITY,f.REACTION_SITE REACTION_SITE,f.status error_status,f.adv_event_rxn_srl_no FROM pr_allergy_sensitivity a,pr_adverse_event e, pr_adverse_event_reaction f,am_reaction_lang_vw g  WHERE a.patient_id =? AND a.status = ?  AND f.reaction_date=nvl(To_Date(?, 'dd/mm/yyyy hh24:mi'),reaction_date )AND   a.allergen_code=?  AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind  AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code  AND a. ADV_EVENT_TYPE=?  AND a.ADV_EVENT_TYPE=e.ADV_EVENT_TYPE AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND f.adv_reac_code = g.reaction_code(+) and g.language_id(+)=? and f.status = 'A' and a.onset_date=nvl(To_Date(?, 'dd/mm/yyyy hh24:mi:ss'),onset_date ) and a.adv_event_type_ind = ?ORDER BY a.allergen_code, a.onset_date, f.reaction_date";
if(mode.equals("modify")){
			/* Commented ON 6/10/2010 for PE
			rs=stmt.executeQuery(sql_default_values);
			rs.last();
			max_record = rs.getRow();
			rs.beforeFirst();*/
			pstmt =con.prepareStatement(sql_default_values);
			pstmt.setString(1,PatientId);
			pstmt.setString(2,status);
			pstmt.setString(3,reaction_date_modify);
			pstmt.setString(4,causative_code);
			pstmt.setString(5,adv_event_type_code);
			pstmt.setString(6,locale);
			pstmt.setString(7,onset_date);
			pstmt.setString(8,adv_event_type_ind_code);
			rs=pstmt.executeQuery();
			if(rs !=null){
				while(rs.next()){
				adv_reac_code=rs.getString("ADV_REAC_CODE");
				if(adv_reac_code == null){ adv_reac_code="";}
				String others_reaction=rs.getString("OTHERS_REACTION");
				if(others_reaction == null){ 
					others_reaction="";
				}else{
					others_reaction= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.OtherReactions.label","mr_labels") + ":"+ others_reaction;
				}
				String site_of_reac=rs.getString("REACTION_SITE");
				if(site_of_reac ==null){site_of_reac="";}
				String reaction_desc_modify=rs.getString("LONG_DESC");
				if(reaction_desc_modify ==null){reaction_desc_modify="";}
				String severity_code=rs.getString("SEVERITY");
				if(severity_code ==null){severity_code="";}
				String severity_desc="";
				err_status = rs.getString("error_status");
				if(mode.equals("record")){
					reaction_date_modify=rs.getString("reaction_date");
					adv_event_rxn_srl_no=rs.getString("adv_event_rxn_srl_no");
					if(reaction_date_modify ==null){reaction_date_modify="";}
					reaction_date_modify_disply=DateUtils.convertDate(reaction_date_modify,"DMYHM","en",locale);
				}
				if(severity_code.equals("M")){
					severity_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mild.label","common_labels");
				}else if(severity_code.equals("O")){
					severity_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Moderate.label","common_labelsels");
				}else if(severity_code.equals("S"))	{
					severity_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severe.label","common_labels");
				}else if(severity_code.equals("U")){
					severity_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
				}
				%>
				<tr>
					<% if(adv_reac_code.equals("Oth"))	{%>
						<td class='label' width='20%' style = 'text-align:justify;word-break:break-all;' ><%=others_reaction%></td>
					<%}else {%>
						<td class='label' width='20%'><%=reaction_desc_modify%></td>
					<%}%>
					<td class='label' width='30%'><input type='text' name='reaction_date' id='reaction_date' disabled value='<%=reaction_date_modify_disply%>'  maxlength="16" size="14" ><img id='cal1' src="../../eCommon/images/CommonCalendar.gif" disabled /></td>
					<td class='label' width='25%'><input type='text' name='severity' id='severity' disabled value='<%=severity_desc%>'  maxlength="16" size="14" ></td>
					<td class='label' width='25%'><textarea name='Site_Of_Reac' disabled onkeypress="return CheckForSpecChars_spec(event);return imposeMaxLength(this, 100);" rows='1' cols='25'><%=site_of_reac%></textarea></td>
				</tr>
				<%
					max_record++;
				}
				if(pstmt!=null){pstmt.close();}
				if(rs!=null){rs.close();}
			}
		}else{
			if(mode.equals("record")){
				max_record=0;
				/*Commented ON 6/10/2010 for PE
				rs=stmt.executeQuery(sql_default_values);
				rs.last();
				max_record = rs.getRow();
				rs.beforeFirst();*/
				pstmt =con.prepareStatement(sql_default_values);
				pstmt.setString(1,PatientId);
				pstmt.setString(2,status);
				pstmt.setString(3,reaction_date_modify);
				pstmt.setString(4,causative_code);
				pstmt.setString(5,adv_event_type_code);
				pstmt.setString(6,locale);
				pstmt.setString(7,onset_date);
				pstmt.setString(8,adv_event_type_ind_code);
				rs=pstmt.executeQuery();
				if(rs !=null){
					while(rs.next()){
					
					
						adv_reac_code=rs.getString("ADV_REAC_CODE");
						if(adv_reac_code == null) adv_reac_code="";
						String others_reaction=rs.getString("OTHERS_REACTION");
						if(others_reaction == null) {
							others_reaction="";
						}else{
							others_reaction= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.OtherReactions.label","mr_labels")+ ":"+ others_reaction;
						}
						String site_of_reac=rs.getString("REACTION_SITE");
						adv_event_rxn_srl_no=rs.getString("adv_event_rxn_srl_no");
						if(site_of_reac ==null){site_of_reac="";}
						String reaction_desc_modify=rs.getString("LONG_DESC");
						if(reaction_desc_modify ==null){reaction_desc_modify="";}
						String severity_code=rs.getString("SEVERITY");
						if(severity_code ==null){severity_code="";}
						String severity_desc="";
						reaction_date_modify=rs.getString("reaction_date");
						if(reaction_date_modify ==null){reaction_date_modify="";}
						/**10/2/2008*/
						String error_status = "";
						err_status = rs.getString("error_status");
						if(error_status==null){err_status = "A";}
						if(adv_reac_code.equals("Oth")){
							//error_status=others_reaction;
							error_status=others_reaction;
						}else{
							error_status=adv_reac_code;
						}
						/*Created by Senthil Reaction code Added into ArrayList on 01-08-2011*/						
                        //list.add(adv_reac_code);	
						
						/**10/2/2008*/
						reaction_date_modify_disply=DateUtils.convertDate(reaction_date_modify,"DMYHM","en",locale);
						if(severity_code.equals("M")){
							severity_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mild.label","common_labels");
						}else if(severity_code.equals("O")){
							severity_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Moderate.label","common_labelsels");
						}else if(severity_code.equals("S")){
							severity_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severe.label","common_labels");
						}else if(severity_code.equals("U")){
							severity_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						}
						
						if(adding_react_yn.equals("N")){%>
						<tr>
							<%if(!(mode.equals("insert") || err_status.equals("E"))){ %>
								<td  class='label' width='20%'>
								<input type='checkbox' name ="chkreact<%=i%>" value ='' <%=chkdisable%> onclick='getchkvalues(this)' id='react' <%if(!status.equals("A")){%>disabled<%}%>></td>
							<%}%>
							<% if(adv_reac_code.equals("Oth"))	{%>
								<td class='label' width='20%' style = 'text-align:justify;word-break:break-all;' ><%=others_reaction%><% /*hidden field added by senthil 09-08-2011*/%><input type="hidden" name="adv_reac_event_code<%=i%>" id="adv_reac_event_code<%=i%>" id="adv_reac_event_code<%=i%>" value="<%=adv_reac_code%>"></td>
							<%}else {%>
								<td class='label' width='20%'><%=reaction_desc_modify%><% /*hidden field added by senthil 09-08-2011*/%><input type="hidden" name="adv_reac_event_code<%=i%>" id="adv_reac_event_code<%=i%>" id="adv_reac_event_code<%=i%>" value="<%=adv_reac_code%>"></td>
							<%}%>
							<input type= 'hidden' name = 'error_status<%=i%>' value='<%=error_status%>'>
							<td class='label' width='30%'><input type='text' name='reaction_date<%=i%>' id='reaction_date<%=i%>' disabled value='<%=reaction_date_modify_disply%>'  maxlength="16" size="14" ><img id='cal1' src="../../eCommon/images/CommonCalendar.gif" disabled />
							<input type = 'hidden' name = 'react_description<%=i%>' value = '<%=reaction_date_modify_disply%>'></td>
							<td class='label' width='25%'><input type='text' name='severity' id='severity' disabled value='<%=severity_desc%>'  maxlength="16" size="14" ></td><input type = 'hidden' name = 'severity_desc<%=i%>' value = '<%=severity_desc%>'>
							<td class='label' width='25%'><textarea name='Site_Of_Reac' disabled onkeypress="return CheckForSpecChars_spec(event);return imposeMaxLength(this, 100);" rows='1' cols='25'><%=site_of_reac%></textarea></td>
							<input type = 'hidden' name = 'site_desc<%=i%>' value = '<%=site_of_reac%>'>
							<input type = 'hidden' name = 'adv_event_rxn_srl_no<%=i%>' value = '<%=adv_event_rxn_srl_no%>'>
						</tr>
						<%
						}else{%>
						<tr>
							<%if(!(mode.equals("insert") || err_status.equals("E"))){%>
								<td  class='label' width='20%'>
								<input type='checkbox' name ="achkreact<%=i%>" value ='' <%=chkdisable%> onclick='getchkvalues(this)' id='react<%=i%>' <%--if(!status.equals("A")){--%>disabled<%--}--%>></td>
							<%}%>
							<% if(adv_reac_code.equals("Oth")){%>
								<td class='label' width='20%' style = 'text-align:justify;word-break:break-all;'><%=others_reaction%></td><% /*hidden field added by senthil 09-08-2011*/%><input type="hidden" name="adv_reac_event_code<%=i%>" id="adv_reac_event_code<%=i%>" id="adv_reac_event_code<%=i%>" value="<%=adv_reac_code%>">
							<%}else {%>
								<td class='label' width='20%'><%=reaction_desc_modify%></td><%/* hidden field added by senthil 09-08-2011*/%><input type="hidden" name="adv_reac_event_code<%=i%>" id="adv_reac_event_code<%=i%>" id="adv_reac_event_code<%=i%>" value="<%=adv_reac_code%>">
							<%}%>
							<input type= 'hidden' name = 'a_error_status<%=i%>' value='<%=error_status%>'>
							<td class='label' width='30%'><input type='text' name='a_reaction_date<%=i%>' id='a_reaction_date<%=i%>' disabled value='<%=reaction_date_modify_disply%>' maxlength="16" size="14" ><img id='acal1' src="../../eCommon/images/CommonCalendar.gif" disabled />
							<input type = 'hidden' name = 'a_react_description<%=i%>' value = '<%=reaction_date_modify_disply%>'></td>
							<td class='label' width='25%'><input type='text' name='a_severity' id='a_severity' disabled value='<%=severity_desc%>'  maxlength="16" size="14" ></td><input type = 'hidden' name = 'a_severity_desc<%=i%>' value = '<%=severity_desc%>'>
							<td class='label' width='25%'><textarea name='a_Site_Of_Reac' disabled onkeypress="return CheckForSpecChars_spec(event);return imposeMaxLength(this, 100);" rows='1' cols='25'><%=site_of_reac%></textarea></td>
							<input type = 'hidden' name = 'a_site_desc<%=i%>' value = '<%=site_of_reac%>'>
						</tr>
						<%}
						i++;
						max_record++;
					}
					 /*hidden field added by senthil 09-08-2011*/
					%>
					<input type = 'hidden' name = 'oldreactionvalue_count' value = '<%=i%>'>
					<%
					if(pstmt!=null){pstmt.close();}
					if(rs!=null){rs.close();}
				}
				//Wednesday, March 25, 2009	this is added here for modified mode
				i=0;
	}
		String reactionCode="";
		String reactionDesc="";
		String reactionDate="";
		String reactionSeviarity="";
		String siteofReaction="";
		ArrayList addReaction=new ArrayList();		
		String final_total = checkForNull(request.getParameter("final_total"));	
        	
		int no_of_rws=0;
		if(!final_total.equals("")){
			StringTokenizer _token = new StringTokenizer(final_total,"!");
			while(_token.hasMoreTokens()){
				no_of_rws++;
				String listReaction=_token.nextToken();
				StringTokenizer finalListRec = new StringTokenizer(listReaction,"^");
				while(finalListRec.hasMoreTokens()){

					reactionCode = finalListRec.nextToken();		
					reactionDesc = finalListRec.nextToken();		
					reactionDate = finalListRec.nextToken();		
					reactionSeviarity = finalListRec.nextToken();
					if(reactionSeviarity.equals("~")) reactionSeviarity = "";
					siteofReaction = finalListRec.nextToken();
					if(siteofReaction.equals("~")) siteofReaction = "";
					addReaction.add(reactionCode);
					addReaction.add(reactionDesc);
					addReaction.add(reactionDate);
					addReaction.add(reactionSeviarity);
					addReaction.add(siteofReaction);

				
			  }
			}
		}
		//out.println(addReaction);
		
		
	
	String prev_oth_reaction="$";
 
	if(!reac_desc_val.equals("") )
			{
	StringTokenizer reaction_val= new StringTokenizer(reac_desc_val,"`");

	if(adding_react_yn.equals("Y"))
		i=0;
	//int reactionvalCnt = reaction_val.countTokens();//Commented for checkstyle
	//for(int rvc = 0 ;rvc < reactionvalCnt ;rvc++ )
	//{
	while(reaction_val.hasMoreTokens())
	{
		reactiondesc_total=reaction_val.nextToken();	    
		oth_reaction=reaction_val.nextToken();
			
		oth_reaction=oth_reaction.substring(0,oth_reaction.length()-1);
		diplay_mandatory=true;

	int temp_var=0;

	if(!reactiondesc_total.equals("$"))
		{
StringTokenizer reaction_val_new= new StringTokenizer(reactiondesc_total,";");

String tmp_code="";
String tmp_desc="";
String tmp_dt="";
String tmp_sev="";
String tmp_sit="";
String reacDescCode="";



	while(reaction_val_new.hasMoreTokens() )
	{
		reacDescCode=reaction_val_new.nextToken();		 
		reaction_desc=reaction_val_new.nextToken();	
		%>

		<tr >
		<%//if(!mode.equals("insert")){%>
		
		     <!--<td class='label' width='20%'>&nbsp;<!--<input type="checkbox" name="x<%=i%>" id="x<%=i%>" value='' > -->
			<!--</td>-->
			
		<%//}	 
		boolean populateValues = false;		
		if(addReaction.size()>0  && addReaction.size() >temp_var){							
			for(int a=0;a<addReaction.size();a++){				
				if((addReaction.get(a)).equals(reacDescCode)){	 
					populateValues = true;			
					temp_var = a;
				}			
			}						
		 
			
		if(populateValues ){		 
				tmp_code=(String) addReaction.get(temp_var);
				tmp_desc=(String) addReaction.get(temp_var+1);
				tmp_dt=(String) addReaction.get(temp_var+2);
				tmp_sev=(String) addReaction.get(temp_var+3);
				tmp_sit=(String) addReaction.get(temp_var+4);	
	 
			/*Avoid the Add Duplicate Reaction Created by Senthil on 01-08-2011*/	
			if(!mode.equals("insert")){%>
		
		     <td class='label' width='20%'>&nbsp;<!--<input type="checkbox" name="x<%=i%>" id="x<%=i%>" value='' > -->
			</td> 
			<%}//End %>
				<td class='label' width='20%' ><%=reaction_desc%></td><input type='hidden' name='reac_desc<%=i%>' id='reac_desc<%=i%>' value='<%=reaction_desc%>' id='reac_desc<%=i%>' >
				<td class='label' width='30%'><input type='text' name='reaction_date<%=i%>' id='reaction_date<%=i%>' value='<%=tmp_dt%>'  maxlength="16" size="14" onblur="CompareRegnDate2(this,document.forms[0].sysdate);Check_Duplicate(this,<%=i%>);"><img id='cal1' src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('reaction_date<%=i%>',null,'hh:mm');"/><img id='cal_man' src="../../eCommon/images/mandatory.gif" align='center'></img></td>
				<td class='label' width='25%'><select name='severity<%=i%>' id='severity<%=i%>'>
				<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<option value='M'><fmt:message key="Common.Mild.label" bundle="${common_labels}"/></option>
				<option value='O'><fmt:message key="Common.Moderate.label" bundle="${common_labels}"/></option>
				<option value='S'><fmt:message key="Common.Severe.label" bundle="${common_labels}"/></option>
				<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option></select></td>
				<td class='label' width='25%'><textarea name='Site_Of_Reac<%=i%>'  onblur = 'checkMaxLimit(this);' onkeypress="return CheckForSpecChars_spec(event);return imposeMaxLength(this, 100);" rows='1' cols='25' value=''><%=tmp_sit%></textarea></td>
				<script>
					document.forms[0].severity<%=i%>.value='<%=tmp_sev%>';
				</script>
			   </tr>
			<%}
				else{	  
					temp_var=temp_var-5;
          /*Avoid the Duplicate Reaction Created by Senthil on 01-08-2011*/						
			if(!mode.equals("insert")){%>
		
		     <td class='label' width='20%'>&nbsp;<!--<input type="checkbox" name="x<%=i%>" id="x<%=i%>" value='' > -->
			</td> 
			
		<%} //End%>					
			<td class='label' width='20%' ><%=reaction_desc%></td><input type='hidden' name='reac_desc<%=i%>' id='reac_desc<%=i%>' value='<%=reaction_desc%>' id='reac_desc<%=i%>' >
			<td class='label' width='30%'><input type='text' name='reaction_date<%=i%>' id='reaction_date<%=i%>' value='<%=reaction_date1_disply%>'   maxlength="16" size="14" onblur="CompareRegnDate2(this,document.forms[0].sysdate);Check_Duplicate(this,<%=i%>);"><img id='cal1' src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('reaction_date<%=i%>',null,'hh:mm');"/><img id='cal_man' src="../../eCommon/images/mandatory.gif" align='center'></img></td>
			<td class='label' width='25%'><select name='severity<%=i%>' id='severity<%=i%>' >
			<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<option value='M'><fmt:message key="Common.Mild.label" bundle="${common_labels}"/></option>
			<option value='O'><fmt:message key="Common.Moderate.label" bundle="${common_labels}"/></option>
			<option value='S'><fmt:message key="Common.Severe.label" bundle="${common_labels}"/></option>
			<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option></select></td>
			<td class='label' width='25%'><textarea name='Site_Of_Reac<%=i%>'  onblur = 'checkMaxLimit(this);' onkeypress="return CheckForSpecChars_spec(event);return imposeMaxLength(this, 100);" rows='1' cols='25' value=''></textarea></td>
	  <%} 	
		}else{ 		  
		if(!mode.equals("insert")){%>
		  
		     <td class='label' width='20%'>&nbsp;<!--<input type="checkbox" name="x<%=i%>" id="x<%=i%>" value='' > -->
			</td> 
			
		<%} //End%>
					
			<td class='label' width='20%' ><%=reaction_desc%></td><input type='hidden' name='reac_desc<%=i%>' id='reac_desc<%=i%>' value='<%=reaction_desc%>' id='reac_desc<%=i%>' >
			<td class='label' width='30%'><input type='text' name='reaction_date<%=i%>' id='reaction_date<%=i%>' value='<%=localeSysDate%>'  maxlength="16" 
			size="14" onblur="CompareRegnDate2(this,document.forms[0].sysdate);Check_Duplicate(this,<%=i%>);">
			<!--<td class='label' width='30%'><input type='text' name='reaction_date<%=i%>' id='reaction_date<%=i%>' value='<%=sysdate%>'  maxlength="16"  size="14" onblur="CompareRegnDate2(this,document.forms[0].sysdate);Check_Duplicate(this,<%=i%>);">-->
			<img id='cal1' src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('reaction_date<%=i%>',null,'hh:mm');"/><img id='cal_man' src="../../eCommon/images/mandatory.gif" align='center'></img></td>
			<td class='label' width='25%'><select name='severity<%=i%>' id='severity<%=i%>' >
			<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<option value='M'><fmt:message key="Common.Mild.label" bundle="${common_labels}"/></option>
			<option value='O'><fmt:message key="Common.Moderate.label" bundle="${common_labels}"/></option>
			<option value='S'><fmt:message key="Common.Severe.label" bundle="${common_labels}"/></option>
			<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option></select></td>
			<td class='label' width='25%'><textarea name='Site_Of_Reac<%=i%>'  onblur = 'checkMaxLimit(this);' onkeypress="return CheckForSpecChars_spec(event);return imposeMaxLength(this, 100);" rows='1' cols='25' value=''></textarea></td>

	<%		
	}
		temp_var=temp_var+5;	
	
	i++; 
		disableField=" ";	
	}

	int j=0;
	int k=0;
	
	StringTokenizer reaction_code= new StringTokenizer(reac_code_val,"`");     
	int counter1=reaction_code.countTokens(); 
	String reaction_code1[]=new String[counter1];
	while(reaction_code.hasMoreTokens())
	{
		reaction_code1[j]=reaction_code.nextToken();
		 
		if(j!=0)
		{
		out.println("<input type='hidden' name='reaction_code"+(k-1)+"' id='reaction_code"+(k-1)+"' value='"+reaction_code1[j]+"'>");
		if(j==1)
		{
		reac_code=reaction_code1[j];		 
		}else
		{
		//reac_code+="*"+reaction_code1[j];
		reac_code=reac_code+"`"+reaction_code1[j];
		}
		}
		j++;
		k++;
		
	}
	out.println("<input type='hidden' name='reac_code' id='reac_code' value='"+reac_code+"'>");
	}else
	{
		
	}
	%>
		<%
		String final_total_oth = checkForNull(request.getParameter("final_total_oth"));
	


	    String reactionCodeOth="";
		String reactionDateOth="";
		String reactionSeviarityOth="";
		String siteofReactionOth="";
		int temp_varOTH=0;

		ArrayList addReactionOTH=new ArrayList();

		int no_of_rwsOth=1;
			if(!final_total_oth.equals("")){
			StringTokenizer _token_oth = new StringTokenizer(final_total_oth,"!");
			while(_token_oth.hasMoreTokens()){
				no_of_rwsOth++;
				String listReactionOTH=_token_oth.nextToken();
				StringTokenizer finalListRecOth = new StringTokenizer(listReactionOTH,"^");
				while(finalListRecOth.hasMoreTokens()){

					reactionCodeOth = finalListRecOth.nextToken();		
					reactionDateOth = finalListRecOth.nextToken();		
					reactionSeviarityOth = finalListRecOth.nextToken();
					if(reactionSeviarityOth.equals("~")) reactionSeviarityOth = "";
					siteofReactionOth = finalListRecOth.nextToken();
					if(siteofReactionOth.equals("~")) siteofReactionOth = "";

					addReactionOTH.add(reactionCodeOth);
					addReactionOTH.add(reactionDateOth);
					addReactionOTH.add(reactionSeviarityOth);
					addReactionOTH.add(siteofReactionOth);

				
			  }
			}
		}

		
		
	if(!prev_oth_reaction.equals(oth_reaction)) {

		StringTokenizer multi_other_reaction= new StringTokenizer(oth_reaction,"||");

		
		while(multi_other_reaction.hasMoreTokens())
		{
			String other_reaction_token = multi_other_reaction.nextToken();
	
%>
		<tr>

	    <!--<td class='label' width='20%'><fmt:message key="eMR.OtherReactions.label" bundle="${mr_labels}"/>: <%=oth_reaction%></td>-->
		<%if(!mode.equals("insert")){%>
		     <td class='label' width='20%'><input type="checkbox" name="chkreact_2" id="chkreact_2" value='<%=chkAttribute%>' style='display:none' >  </td>
		<%}
			String tmp_dtOth="";
			String tmp_sevOth="";
			String tmp_sitOth="";

		if(addReactionOTH.size()>0  && addReactionOTH.size() >temp_varOTH){

			

			tmp_dtOth=(String) addReactionOTH.get(temp_varOTH+1);
			tmp_sevOth=(String) addReactionOTH.get(temp_varOTH+2);
			tmp_sitOth=(String) addReactionOTH.get(temp_varOTH+3);
		
		%>
			<td class='label' width='20%' style = 'text-align:justify;word-break:break-all;' ><fmt:message key="eMR.OtherReactions.label" bundle="${mr_labels}"/>: <%=other_reaction_token%></td>
			<input type='hidden' name='oth_reac_desc<%=other_reaction_counter%>' id='oth_reac_desc<%=other_reaction_counter%>' value='<%=other_reaction_token%>' id='oth_reac_desc<%=other_reaction_counter%>' >

			<td class='label' width='30%'><input type='text' name='other_reaction_date<%=other_reaction_counter%>' id='other_reaction_date<%=other_reaction_counter%>' value='<%=tmp_dtOth%>' id='other_reaction<%=other_reaction_counter%>' maxlength="16" size="14" onblur="CompareRegnDate2(this,document.forms[0].sysdate);Check_Duplicate1(this);">
			<img id='cal1' src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('other_reaction<%=other_reaction_counter%>',null,'hh:mm');"/><img id='cal_man' src="../../eCommon/images/mandatory.gif" align='center'></img></td>
			<td class='label' width='25%'><select name='severity_oth<%=other_reaction_counter%>' id='severity_oth<%=other_reaction_counter%>'>
			<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<option value='M'><fmt:message key="Common.Mild.label" bundle="${common_labels}"/></option>
			<option value='O'><fmt:message key="Common.Moderate.label" bundle="${common_labels}"/></option>
			<option value='S'><fmt:message key="Common.Severe.label" bundle="${common_labels}"/></option>
			<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option></select></td>
			<td class='label' width='25%'><textarea name='Site_Of_Reac_oth<%=other_reaction_counter%>'  onblur = 'checkMaxLimit(this);' onkeypress="return CheckForSpecChars_spec(event);return imposeMaxLength(this, 100);" rows='1' cols='25' value=""><%=tmp_sitOth%></textarea></td>
			<script>
				document.forms[0].severity_oth<%=other_reaction_counter%>.value='<%=tmp_sevOth%>';
			</script>
			
		</tr>
		<%}
			else{
				%>
				<td class='label' width='20%' style = 'text-align:justify;word-break:break-all;' ><fmt:message key="eMR.OtherReactions.label" bundle="${mr_labels}"/>: <%=other_reaction_token%></td>
			<input type='hidden' name='oth_reac_desc<%=other_reaction_counter%>' id='oth_reac_desc<%=other_reaction_counter%>' value='<%=other_reaction_token%>' id='oth_reac_desc<%=other_reaction_counter%>' >

			<td class='label' width='30%'><input type='text' name='other_reaction_date<%=other_reaction_counter%>' id='other_reaction_date<%=other_reaction_counter%>' value='<%=reaction_date1_disply%>' id='other_reaction<%=other_reaction_counter%>' maxlength="16" size="14" onblur="CompareRegnDate2(this,document.forms[0].sysdate);Check_Duplicate1(this);">
			<img id='cal1' src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('other_reaction<%=other_reaction_counter%>',null,'hh:mm');"/><img id='cal_man' src="../../eCommon/images/mandatory.gif" align='center'></img></td>
			<td class='label' width='25%'><select name='severity_oth<%=other_reaction_counter%>' id='severity_oth<%=other_reaction_counter%>'>
			<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<option value='M'><fmt:message key="Common.Mild.label" bundle="${common_labels}"/></option>
			<option value='O'><fmt:message key="Common.Moderate.label" bundle="${common_labels}"/></option>
			<option value='S'><fmt:message key="Common.Severe.label" bundle="${common_labels}"/></option>
			<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option></select></td>
			<td class='label' width='25%'><textarea name='Site_Of_Reac_oth<%=other_reaction_counter%>'  onblur = 'checkMaxLimit(this);' onkeypress="return CheckForSpecChars_spec(event);return imposeMaxLength(this, 100);" rows='1' cols='25' value=''></textarea></td>	
			
		</tr>
		

				<%
			}
				%>
				<input type='hidden' name='reaction_oth<%=other_reaction_counter%>' id='reaction_oth<%=other_reaction_counter%>' value='<%=other_reaction_token%>'>
				<%
				temp_varOTH=temp_varOTH+4;	
				other_reaction_counter++;
		}%>
		<input type='hidden' name='reaction_oth' id='reaction_oth' value='<%=oth_reaction%>'>
		<%
		}
			prev_oth_reaction=oth_reaction;
			

	}//close for while
	//} //close for for loop
			}//close for reac_desc_val if
	
	%>
</table>
		<table cellpadding='0' id='add_reaction_table' border='0' cellspacing='0' width='100%' align='center' >

<tr>
			<%if(mode.equals("") ) {
		/*if(allergen_blank.equals(""))
			String all_disabled ="disabled";*/
%>
				 <td class='label' width='20%' ><fmt:message key="eMR.addreaction.label" bundle="${mr_labels}"/> </td>
				 <td class='fields' width='30%' ><input type='text'  disabled  name='add_reaction' id='add_reaction'  value='' size='30' maxlength='30' onblur='if(this.value !="") onblur_reaction(this) else disable()' ><input disabled  type='button' class='BUTTON' name='add_reaction_search' id='add_reaction_search' value='?' onClick='callreactionSearch();'  id='reaction_search'><%if(!diplay_mandatory){%> <img src='../../eCommon/images/mandatory.gif' align='center' id='add_resc' ></img><%}%></td>
				 <td class='label' colspan='2'>&nbsp;</td>
			 <%}else{
					if(mode.equals("insert"))
					{
			
						
			%>
				 
				 <td class='label' width='20%' ><fmt:message key="eMR.addreaction.label" bundle="${mr_labels}"/> </td>
				 <td class='fields' width='30%' ><input type='text'  name='add_reaction' id='add_reaction'  value='' size='30' maxlength='30' onblur='if(this.value !="") onblur_reaction(this)' disabled><input type='button' class='BUTTON' name='add_reaction_search' id='add_reaction_search' value='?'<%=disableField%> onClick='callreactionSearch();' ><%if(!diplay_mandatory){%><img src='../../eCommon/images/mandatory.gif' align='center' id='add_resc'></img><%}%></td>
				 <td class='label' colspan='2'>&nbsp;<%/*hidden field added by senthil on 16-08-2011*/%><input type = 'hidden' name = 'oldreactionvalue_count' value = '<%=max_record%>'></td>
				 <%}else{%>
				  <td class='label' width='20%' ><fmt:message key="eMR.addreaction.label" bundle="${mr_labels}"/> </td>
				 	 <td class='fields' width='30%' ><input type='text'  name='add_reaction' id='add_reaction'  value='' size='30' maxlength='30' onblur='if(this.value !="") onblur_reaction(this)' <%=status_r%>><input type='button' class='BUTTON' name='add_reaction_search' id='add_reaction_search' value='?' onClick='callreactionSearch();' <%=status_r%> ><img src='../../eCommon/images/mandatory.gif' align='center' id='add_resc' <%--if((status.equals("R") || status.equals("E")) || (status.equals("A")&&(diplay_mandatory))){--%>style="visibility:hidden"<%--}--%>></img></td>
				 <td class='label' colspan='2'>&nbsp;</td>
					
			 <%}}%>
 </tr> 
 </table>
<%}
%>

 
 <input type='hidden' name='count_val' id='count_val' value='<%=i%>'>

 <input type='hidden' name='react_code_final1' id='react_code_final1' value='<%=reac_code%>'>
 <input type='hidden' name='oth_reaction' id='oth_reaction' value='<%=oth_reaction%>'>
 <input type='hidden' name='oth_reaction_counter' id='oth_reaction_counter' value='<%=other_reaction_counter%>'>
 <input type='hidden' name='status' id='status' value='<%=status%>'>
 <input type='hidden' name='tot_cnt' id='tot_cnt' value='<%=max_record%>'>
  <input type='hidden' name='final_react_description' id='final_react_description' value='<%=reactDesc%>'>
  <input type='hidden' name='final_value' id='final_value' value='<%=final_value%>'>
  <input type='hidden' name='adv_reac_code' id='adv_reac_code' value='<%=adv_reac_code%>'>
  <input type='hidden' name='adding_react_yn' id='adding_react_yn' value='<%=adding_react_yn%>'>
  <input type='hidden' name='final_total' id='final_total' value=''>
  <input type='hidden' name='chk_react' id='chk_react' value=''>
  <input type='hidden' name='onset_date1' id='onset_date1' value='<%=onset_date%>'>
  <input type='hidden' name='adv_event_type_ind_code1' id='adv_event_type_ind_code1' value='<%=adv_event_type_ind_code%>'>

<!--27/11/2008 6257 reopen--->


</form>

</body>
<script>

</script>

 <%
     } catch(Exception e) {
	 e.printStackTrace();
          if (stmt != null) stmt.close();
     }
     finally {
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
		  ConnectionManager.returnConnection(con,request);
     }
%>
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


