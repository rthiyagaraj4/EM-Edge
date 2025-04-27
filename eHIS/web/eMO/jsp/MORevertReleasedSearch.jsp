<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eMP/jsp/PatientAddressLegends.jsp" %>
<html>

<head>

	  <%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");
	 
%>

      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	  <link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	  <Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
	  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	  <script language='javascript' src='../../eCommon/js/common.js'></script>
	  <script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
	  <script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  <script>
   function AEScrollIntoView(tabidx){
		if(tabidx == 1){
			document.getElementById('tab1').scrollIntoView();	
		}else if(tabidx == 3){           
		   document.getElementById('tab2').scrollIntoView();	
		}			
	}
	function CloseRelDec(){
		parent.window.returnValue = "";
		parent.window.close();
	}
	function revertRelese(){			
		if(document.forms[0].revert_release_reason.value == ""){
			var error = getMessage('CAN_NOT_BE_BLANK',"Common");
			error = error.replace('$',getLabel("eAE.Reasons.label","AE"));
			alert(error);	
	     }else{
			document.forms[0].submit();
		 }		
	}
	function chkRemarksMaxlen(obj){
	if (obj.value.length > 200){	 
		var msg = getMessage('REMARKS_CANNOT_EXCEED',"Common");
		msg		= msg.replace("$",getLabel("Common.reason.label","Common"));
		msg		= msg.replace("#",200);
		alert(msg);
		obj.select();
		obj.focus();
	}
}
  </script>


  
</head>
 <%	
     Connection con 					       = null;
	 java.sql.Statement stmt				   = null;
	 ResultSet rs					           = null;
	 ResultSet vrs					           = null;
	 PreparedStatement pstmt                   = null; 
     PreparedStatement pstmt2                   = null; 
	 Boolean iSSiteApplicable = false; // Added by Shagar M ML-MMOH-CRF-0690

	 //Added by Ashwini on 02-Aug-2017 for ML-MMOH-CRF-0743
	 Boolean isClaimantChngsApplicable = false;
	 
	 //Added for this CRF ML-MMOH-CRF-0860.2
	 Boolean increasedaddressLength = false;
     
try
  { 

     con = ConnectionManager.getConnection(request);
	 
	 iSSiteApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MO", "RELEASED_BY_LOGINID_DISABLE");	 //Added by Shagar M ML-MMOH-CRF-0690

	 isClaimantChngsApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","CLAIMANT_MNDT_FLD_RENAME"); //Added by Ashwini on 02-Aug-2017 for ML-MMOH-CRF-0743
	 
    Boolean isReceivedDateTimeAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","RECEIVED_DATE_TIME");// Added by Shanmukh on 26th-JUNE-2018 for ML-MMOH-CRF-1036	 
	 
	 //Added for this CRF ML-MMOH-CRF-0860.2
	 increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");
	 	 
     String td_width="";	
     String td_word_wrap="";
	 String org_width="";
	 String org_width_word_wrap="";
	 String addr_data_width="24%";
	 String addr_legnd_width="24%";
	 
	 String claimant_legend_width="50%";
	 String claimant_legend_datawidth="50%";
	if(increasedaddressLength){		  
		td_width="24%";
		org_width="20%";
		td_word_wrap="word-wrap: break-word;width:280px";
		org_width_word_wrap="word-wrap: break-word;width:200px";
		addr_legnd_width="10%";
		addr_data_width="38%";
		claimant_legend_datawidth="65%";
		claimant_legend_width="35%";
	}
	 
	 
	 Properties p		= (java.util.Properties) session.getValue("jdbc");
	 	String locale					= (String)session.getAttribute("LOCALE");
     String pname ="";
     String patient_employee_id="";

	 //Added by Ashwini on 02-Aug-2017 for ML-MMOH-CRF-0743
	 String passport_no="";
	 String other_identification="";

	 String organization_name="";
	 String relationship="";
	 String nat_id_prompt="";
	 String nat_id_length="";
	 String accept_national_id_no_yn="";
	 String kcou="";
	 String res_town_desc="";
     String res_area_desc="";
     String region_desc="";
	 String ocpn_class_desc="";
   		
     String zip_code="";
	 String mlc_yn;
	 String disabledyn="";
	 String res_town_code="";
     String res_area_code="";
     String region_code="";
	 String burial_permit_no="";

	 String release_body_date="";
	 String  released_by="";
	 String  release_pol_id="";
	 String  release_pol_stn_id="";
	 String  release_pol_officer_rank="";
	 String   burial_permit_issued_yn="";
	 String  burial_permit_issue_date="";
	 String  area_code ="";
	 String  bed_no="";
	 String  rfid_tag_no="";
	
	 String unclaimed_body_yn="";
	 String exportation_reqd_yn="";

	 String job_title="";
	 String nat_id_no="";
	 String addrl1="";
	 String addrl2="";
	 String addrl3="";
	 String addrl4="";
	 String country_code="";
      String telephone_off="";
     String telephone_res="";
     String mob_tel_no="";
     String email_id="";
	 String postal_code="";
     String sex ="";
     String bbypol ="";
	 String BPIssuYN  = "";
	 String unClaimBodyYN  = "";
	 String exportReqdYN  = "";
     String byrecddate ="";
     String eid ="";
     String pid ="";
     String dcert ="";
     String pmyn ="";
     String bpyn ="";
     String ethnic ="";
     String pmi ="";
     String race ="";
     String expyn ="";
     String chk ="";
     String qry1 ="";
     String age ="";
     String pmstatus ="";
     String sydate ="";
     String dlno ="";
     String dldata ="";
     String ppno ="";
     String ppdata ="";
     String rcno ="";
     String rcdata ="";
     String plno ="";
     String pldata ="";
	 String claimant_type_code="";
	 String claimant_type="";
	 String claimant_desc="";
   //  String patient_id="";
	 String name="";
	 String Addr_val = "";
	 String	facilityId 	   = (String) session.getValue( "facility_id" ) ;

	 String relasedByUserName	= "";
     String reg_no      = checkForNull(request.getParameter("param"));
	 String first          = checkForNull(request.getParameter("first"));
	 String release_fac_id= "";
	 String release_fac_desc= "";
	 String releasefacility = "visibility:hidden";
	 String RELEASE_TO_FACILITY= "";
	 String reason_deceased_desc=""; //this line added for this CRF Bru-HIMS-CRF-366 [IN-039612]
	 if(!(reg_no.equals("")))
	  {
		 

		  pstmt2  = con.prepareStatement("select FACILITY_ID, REGISTRATION_NO, CLAIMANT_TYPE_DESC, CLAIMANT_TYPE_CODE,(SELECT short_desc FROM mo_claimant_type_mstr WHERE claimant_type_mstr_code = mo_claimant_vw.claimant_type) CLAIMANT_TYPE, CLAIMANT_DESC, RELATIONSHIP, NAME, JOB_TITLE, ADD_LINE1, ADD_LINE2, ADD_LINE3, ADD_LINE4, ZIP_CODE, COUNTRY_CODE, RES_TOWN_CODE, RES_AREA_CODE, REGION_CODE, TELEPHONE_OFF, TELEPHONE_RES, EMAIL_ID, MOB_TEL_NO, NAT_ID_NO,ORGANIZATION_NAME,PATIENT_EMPLOYEE_ID,PASSPORT_NO,OTHER_IDENTIFICATION,MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+localeName+"','2') res_town_desc,MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+localeName+"','2') res_area_desc,MP_GET_DESC.MP_REGION(REGION_CODE,'"+localeName+"','2') region_desc,RELEASE_TO_FACILITY,REASON from mo_claimant_vw where  REGISTRATION_NO = ? and facility_id=?");

		
		  pstmt2.setString(1,reg_no);
		  pstmt2.setString(2,facilityId);
		  vrs = pstmt2.executeQuery();
		  while(vrs.next())
		 {
		
		claimant_type=vrs.getString("CLAIMANT_TYPE")==null?"":vrs.getString("CLAIMANT_TYPE"); 
	    claimant_type_code=vrs.getString("claimant_type_code")==null?"":vrs.getString("claimant_type_code");
		relationship=vrs.getString("relationship")==null?"":vrs.getString("relationship");
		name=vrs.getString("name")==null?"":vrs.getString("name");
		job_title=vrs.getString("job_title")==null?"":vrs.getString("job_title"); 
		addrl1=vrs.getString("add_line1")==null?"":vrs.getString("add_line1");
		addrl2=vrs.getString("add_line2")==null?"":vrs.getString("add_line2"); 
		addrl3=vrs.getString("add_line3")==null?"":vrs.getString("add_line3");
		addrl4=vrs.getString("add_line4")==null?"":vrs.getString("add_line4");
		claimant_desc=vrs.getString("CLAIMANT_DESC")==null?"":vrs.getString("CLAIMANT_DESC");
		postal_code=vrs.getString("zip_code")==null?"":vrs.getString("zip_code");
		country_code=vrs.getString("country_code")==null?"":vrs.getString("country_code");
		zip_code=postal_code;
		res_town_code=vrs.getString("res_town_code")==null?"":vrs.getString("res_town_code"); 
		res_area_code=vrs.getString("RES_AREA_CODE")==null?"":vrs.getString("RES_AREA_CODE");
		region_code=vrs.getString("region_code")==null?"":vrs.getString("region_code");
		res_town_desc=vrs.getString("res_town_desc")==null?"":vrs.getString("res_town_desc"); 
		res_area_desc=vrs.getString("res_area_desc")==null?"":vrs.getString("res_area_desc");
		region_desc=vrs.getString("region_desc")==null?"":vrs.getString("region_desc");
		telephone_off=vrs.getString("telephone_off")==null?"":vrs.getString("telephone_off"); 
		telephone_res=vrs.getString("telephone_res")==null?"":vrs.getString("telephone_res");
		email_id=vrs.getString("email_id")==null?"":vrs.getString("email_id");
		mob_tel_no=vrs.getString("mob_tel_no")==null?"":vrs.getString("mob_tel_no"); 
		nat_id_no=vrs.getString("nat_id_no")==null?"":vrs.getString("nat_id_no");
	    organization_name=vrs.getString("organization_name")==null?"":vrs.getString("organization_name");
	    patient_employee_id=vrs.getString("patient_employee_id")==null?"":vrs.getString("patient_employee_id"); 

		//Added by Ashwini on 02-Aug-2017 for ML-MMOH-CRF-0743
		passport_no=vrs.getString("passport_no")==null?"":vrs.getString("passport_no"); 
		other_identification=vrs.getString("other_identification")==null?"":vrs.getString("other_identification"); 

	    RELEASE_TO_FACILITY=vrs.getString("RELEASE_TO_FACILITY")==null?"":vrs.getString("RELEASE_TO_FACILITY"); 
		reason_deceased_desc= vrs.getString("REASON")==null?"":vrs.getString("REASON"); //this line Added for this CRF -Bru-HIMS-CRF-366
 	 }
     if (vrs!=null) vrs.close();
	 if(pstmt2!=null) pstmt2.close();
	

	pstmt2  = con.prepareStatement("select ALT_ID1_TYPE,NAT_ID_PROMPT,ACCEPT_OTH_ALT_ID_YN ,ACCEPT_NATIONAL_ID_NO_YN,NAT_ID_LENGTH from MP_PARAM");
	vrs = pstmt2.executeQuery();
    if(vrs.next())
	{
	nat_id_prompt           =vrs.getString("nat_id_prompt")==null?"":vrs.getString("nat_id_prompt");
	nat_id_length    =vrs.getString("NAT_ID_LENGTH")==null?"":vrs.getString("NAT_ID_LENGTH");
	accept_national_id_no_yn =vrs.getString("ACCEPT_OTH_ALT_ID_YN")==null?"":vrs.getString("ACCEPT_OTH_ALT_ID_YN");
	}
     if (vrs!=null) vrs.close();
	 if(pstmt2!=null) pstmt2.close();
	
		 
		 stmt = con.createStatement();//dd/mm/yyyy hh24:mi:ss
		 rs = stmt.executeQuery("select to_char(sysdate,'dd/mm/yyyy hh24:mi') ot_date_time from dual");
		if(rs!=null)
	  {
 		 while(rs.next())
		 {
		   sydate = rs.getString("ot_date_time");
		   if(sydate!=null && !sydate.equals(""))
			   sydate = DateUtils.convertDate(sydate,"DMYHM","en",localeName);	

		 }
	  }if(rs!=null) rs.close();

	qry1 ="select  decode('"+localeName+"', 'en', patient_name,nvl(patient_name_loc_lang, patient_name)) PATIENT_NAME,(DATE_OF_BIRTH) dob,SEX,BROUGHT_BY_POLICE_YN,(BODY_RECEIVED_DATE) byrecddate,ENCOUNTER_ID,PM_YN,decode(BURIAL_PERMIT_NO,NULL,'No','Yes') BURIAL_PERMIT_GEN_YN,EXPORTATION_REQD_YN,age,POSTMORTEM_STATUS,ALT_ID1_DESC, ALT_ID1_NO, ALT_ID2_DESC, ALT_ID2_NO, ALT_ID3_DESC, ALT_ID3_NO, ALT_ID4_DESC, ALT_ID4_NO,patient_id,mlc_yn,unclaimed_body_yn,burial_permit_no, release_body_date,released_by,release_pol_id,release_pol_stn_id, release_pol_officer_rank, burial_permit_issued_yn, burial_permit_issue_date,area_code, bed_no,rfid_tag_num,sm_get_desc.sm_appl_user(released_by,'"+locale+"','1') relasedByUserName from mo_mortuary_regn_vw where REGISTRATION_NO='"+reg_no+"' and FACILITY_ID = '"+facilityId+"'";
	 

	   pstmt =con.prepareStatement(qry1);
	   rs	 = pstmt.executeQuery();
	   while(rs!=null  && rs.next())
	   {
	    
		   pname		= checkForNull(rs.getString(1));
		  
    	   sex			= checkForNull(rs.getString(3));
			
		   if(sex!=null && !sex.equals("") && sex.equals("Male"))
				sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			else if(sex!=null && !sex.equals("") && sex.equals("Female"))
				sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			else if(sex!=null && !sex.equals("") && sex.equals("Unknown"))
				sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

    	   bbypol		= checkForNull(rs.getString(4));
		   byrecddate	= checkForNull(rs.getString(5));

			if(byrecddate!=null && !byrecddate.equals(""))
				byrecddate	= DateUtils.convertDate(byrecddate,"DMYHM","en",localeName);	
		   eid			= checkForNull(rs.getString(6));
           pmyn			= checkForNull(rs.getString(7));
		   bpyn			= checkForNull(rs.getString(8));
		   expyn		= checkForNull(rs.getString(9));
    	   age			= checkForNull(rs.getString(10));
    	   pmstatus     = checkForNull(rs.getString(11));
		   dlno			= checkForNull(rs.getString(12));
		   dldata		= checkForNull(rs.getString(13));
		   ppno			= checkForNull(rs.getString(14));
    	   ppdata		= checkForNull(rs.getString(15));
		   rcno			= checkForNull(rs.getString(16));
		   rcdata	    = checkForNull(rs.getString(17));
		   plno         = checkForNull(rs.getString(18));
		   pldata		= checkForNull(rs.getString(19));
 		   pid			= checkForNull(rs.getString(20)); 
           mlc_yn=      checkForNull(rs.getString("mlc_yn"));
		   burial_permit_no=checkForNull(rs.getString("burial_permit_no"));
		   release_body_date=checkForNull(rs.getString("release_body_date"));
		   released_by=checkForNull(rs.getString("released_by"));
		   release_pol_id=checkForNull(rs.getString("release_pol_id"));
		   release_pol_stn_id=checkForNull(rs.getString("release_pol_stn_id"));
		   release_pol_officer_rank=checkForNull(rs.getString("release_pol_officer_rank"));
		   burial_permit_issued_yn=checkForNull(rs.getString("burial_permit_issued_yn"));
		   burial_permit_issue_date=checkForNull(rs.getString("burial_permit_issue_date"));
		   area_code=checkForNull(rs.getString("area_code"));
		   bed_no=checkForNull(rs.getString("bed_no"));
		   rfid_tag_no=checkForNull(rs.getString("rfid_tag_num"));
		   relasedByUserName=checkForNull(rs.getString("relasedByUserName"));
		   unclaimed_body_yn= checkForNull(rs.getString("unclaimed_body_yn"));	
		   exportation_reqd_yn= checkForNull(rs.getString("exportation_reqd_yn"));	

		if(pmstatus!=null && !pmstatus.equals("") && pmstatus.equals("N"))
			pmstatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
		else if(pmstatus!=null && !pmstatus.equals("") && pmstatus.equals("A"))
			pmstatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.NotRequested.label","mo_labels");
		else if(pmstatus!=null && !pmstatus.equals("") && pmstatus.equals("R"))
			pmstatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Requested.label","common_labels");
		else if(pmstatus!=null && !pmstatus.equals("") && pmstatus.equals("S"))
			pmstatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels");
		else if(pmstatus!=null && !pmstatus.equals("") && pmstatus.equals("E"))
			pmstatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.completed.label","common_labels");
		else if(pmstatus!=null && !pmstatus.equals("") && pmstatus.equals("C"))
			pmstatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");



			if(mlc_yn.equals("Y"))
		   {
		   disabledyn="";
		   }else
		   {
		   disabledyn="disabled";
		   }
			if(pmyn.equals("Y"))  pmyn ="Yes";
		    if(pmyn.equals("N"))  pmyn ="No";
		    if(dcert.equals("Y")) dcert ="Yes";
		    if(dcert.equals("N")) dcert ="No";
		    if(bpyn.equals("Y"))  bpyn ="Yes";
		    if(bpyn.equals("N"))  bpyn ="No";
		    if(expyn.equals("Y")) expyn ="Yes";
		    if(expyn.equals("N")) expyn ="No";
		    if(bbypol.equals("Y"))bbypol ="Yes";
		    if(bbypol.equals("N"))bbypol ="No";
				
		   if(burial_permit_issued_yn.equals("Y"))BPIssuYN = "Yes" ;
		   if(burial_permit_issued_yn.equals("N"))BPIssuYN = "No" ;
		   if(unclaimed_body_yn.equals("Y"))unClaimBodyYN = "Yes" ;
		   if(unclaimed_body_yn.equals("N"))unClaimBodyYN = "No" ;
		   if(exportation_reqd_yn.equals("Y"))exportReqdYN = "Yes" ;
		   if(exportation_reqd_yn.equals("N"))exportReqdYN = "No" ;
				
			if(bpyn!=null && !bpyn.equals("") && bpyn.equals("Yes"))
				bpyn = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
			else if(bpyn!=null && !bpyn.equals("") && bpyn.equals("No"))
				bpyn = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");

			if(pmyn!=null && !pmyn.equals("") && pmyn.equals("Yes"))
				pmyn = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
			else if(pmyn!=null && !pmyn.equals("") && pmyn.equals("No"))
				pmyn = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");

			if(dcert!=null && !dcert.equals("") && dcert.equals("Yes"))
				dcert = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
			else if(dcert!=null && !dcert.equals("") && dcert.equals("No"))
				dcert = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");

			if(bbypol!=null && !bbypol.equals("") && bbypol.equals("Yes"))
				bbypol = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
			else if(bbypol!=null && !bbypol.equals("") && bbypol.equals("No"))
				bbypol = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");


			
			
	 }
	 
	  }	  
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	String togetpid ="";

	togetpid = "select MP_GET_DESC.MP_ETHNIC_GROUP(ETHNIC_GRP_CODE,'"+localeName+"','1') ethnic_long_desc,MP_GET_DESC.MP_RACE(RACE_CODE,'"+localeName+"','1') race_long_desc,alt_id1_no,alt_id2_no from mp_chg_pat_dtls_vw where patient_id ='"+pid+"'";

	stmt =con.createStatement();
	rs = stmt.executeQuery(togetpid);
	while(rs!=null  && rs.next())
	 {
		ethnic = checkForNull(rs.getString("ethnic_long_desc"));
		race   = checkForNull(rs.getString("race_long_desc"));

		pmi    = checkForNull(rs.getString("alt_id2_no"));
	 }
	 if(rs!=null) rs.close();
	

if(expyn.equals("YES")||expyn.equals("Yes"))
	  {
	    chk="checked";
	  }
	  else
	  {
	   chk="";
	  }
				
%>
	 <body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
	 <form name="RDeceased_form" id="RDeceased_form" action="../../servlet/eMO.MORevertReleasedServlet" method="post" target="msgFrame">
	 
	
	 <a name="tab1"   onFocus='javascript:AEScrollIntoView(1);'></a> 	
	<ul id="tablist" class="tablist">
		<li class="tablistitem" title="ReleaseDetails">
			<a onclick="AEScrollIntoView(1)"  class="tabClicked" id="1" ><span class="tabSpanclicked "><fmt:message key="Common.Release.label" bundle="${common_labels}"/><fmt:message key="Common.details.label" bundle="${common_labels}"/></span>
			</a>
		</li>
		<li class="tablistitem" title="Claimant" >
			<a onclick="AEScrollIntoView(3)" class="tabA" id="2" ><span class="tabASpan" ><fmt:message key="eMO.Claimant.label" bundle="${mo_labels}"/></span>
			</a>
		</li>
	</ul>
	<table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'>
    
			<tr>			   
			<td class='label' width='25%'><fmt:message key="Common.registrationno.label" bundle="${common_labels}"/></td>
		    <td class='querydata' width='25%'><b><%=reg_no%></b></td> 			
			<td class='label' width='25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class='querydata' width='25%'><b><%=pid%></b></td> 	
			</tr>	
		    <tr>
			<td colspan='4' class='label'>&nbsp;</td></tr>  
			<td class='label' ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
		    <td class='querydata' colspan='3'><b><%=pname%></b></td>
			</tr>	
			<tr><td colspan='4' class='label'>&nbsp;</td></tr>
            <tr>	     
		    <td class='label' ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
			<td class='querydata'><b><%=sex%></b>
		   </td>			  
		   <td class='label' ><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
		   <td class='querydata'><b><%=age%></b></td> 
			</tr>
			<tr><td colspan='4' class='label'>&nbsp;</td></tr>
			<tr>		      
		      <td class='label' ><fmt:message key="eMP.ethnicity.label" bundle="${mp_labels}"/></td>
		      <td class='querydata'><b><%=ethnic%></b>
			  </td> 	
		      <td class='label' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		      <td class='querydata' ><b><%=eid%></b></td>
			 </tr>
			<tr><td colspan='4' class='label'>&nbsp;</td></tr>
			<%

			 if(!(dlno.equals(""))||(!ppno.equals("")))
		  {
			%>
		<tr>
		 <td class='label'><%=dlno%></td>
		 <td class='querydata' ><b><%=dldata%></b></td>	      
		 <td class='label' ><%=ppno%></td>
		 <td class='querydata'><b><%=ppdata%></b></td> 		
		</tr>
		<tr><td colspan='4' class='label'>&nbsp;</td></tr>
						<%}%>
					<%
					 if(!(rcno.equals(""))||(!plno.equals("")))
			
	  {
			%>
		<tr>
		 <td class='label' ><%=rcno%></td>
		 <td class='querydata' ><b><%=rcdata%></b></td> 	
		 <td class='label'><%=plno%></td>
		 <td class='querydata'><b><%=pldata%></b></td> 		
		</tr>
		<tr><td colspan='4' class='label'>&nbsp;</td></tr>	
	<%}%>
			<tr>		      
		     
 			<td class='label'><fmt:message key="Common.race.label" bundle="${common_labels}"/></td>
		      <td class='querydata' ><b><%=race%></b></td> 
		      <td class='label' ><fmt:message key="eMO.BurialPermitNumber.label" bundle="${mo_labels}"/></td>
			  <!--Style Added by Santhosh for ML-MMOH-CRF-1947>-->
		      <td class='querydata' style='word-wrap:break-word;width:300px;'><b><%=burial_permit_no%></b>
			  </td>
			 </tr>
				<tr><td colspan='4' class='label'>&nbsp;</td></tr>
			<tr>		      
		      <td class='label' ><fmt:message key="eMO.BroughtByPolice.label" bundle="${mo_labels}"/></td>
		      <td class='querydata' ><b><%=bbypol%></b></td> 		
              <!--Added by Shanmukh on 26th-JUNE-2018 for ML-ML-MMOH-CRF-1036-->			  
		      <%if(isReceivedDateTimeAppl){%>
			  <td class='label' ><fmt:message key="Common.received.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></td><%}else{%>
		      <td class='label' ><fmt:message key="eMO.ReceiptDateTime.label" bundle="${mo_labels}"/></td><%}%>
		      <td class='querydata' ><b><%=byrecddate%></b>
			  </td>
			 </tr>
		<tr><td colspan='4' class='label'>&nbsp;</td></tr>
		<tr>		      
		 <td class='label' ><fmt:message key="Common.PMRequired.label" bundle="${common_labels}"/></td>
		 <td class='querydata'><b><%=pmyn%></b></td>     
		<td class='label' ><fmt:message key="eMO.PostmortemStatus.label" bundle="${mo_labels}"/></td>
		<td class='querydata' ><b><%=pmstatus%></b></td>	     
	    </tr>
	<tr><td colspan='4' class='label'>&nbsp;</td></tr>
	<tr>		
	<td class='label'><fmt:message key="eMO.PoliceOfficer.label" bundle="${mo_labels}"/></td>
	<td class='fields' ><%=release_pol_id%></td>
	 <td class='label' ><fmt:message key="eMO.PoliceStation.label" bundle="${mo_labels}"/></td>
	<td class='fields'> <%=release_pol_stn_id%></td> </tr>
	<tr><td colspan='4' class='label'>&nbsp;</td></tr>
	<tr>		   
	<td class='label' ><fmt:message key="eMO.PoliceRank.label" bundle="${mo_labels}"/></td>
	<td class='fields' ><%= release_pol_officer_rank%></td>
	 <td class='label' colspan='2' ></td>
	</tr>
	<tr><td colspan='4' class='label'>&nbsp;</td></tr>
	<tr>		
	<td class='label' ><fmt:message key="eMO.BurialPermitIssued.label" bundle="${mo_labels}"/></td>
	<td class='fields' ><%=BPIssuYN%></td>
	 <td class='label' ><fmt:message key="eMO.BurialPermitIssueDateTime.label" bundle="${mo_labels}"/></td>
	<td class='fields'><%=burial_permit_issue_date%></td>
	</tr>
	<tr><td colspan='4' class='label'>&nbsp;</td></tr>
	<tr>		
	<td class='label' ><fmt:message key="eMO.ReleasedBy.label" bundle="${mo_labels}"/></td>
	
	<%
	if(iSSiteApplicable){ 
	%> <td class='querydata'style='word-wrap: break-word;width:200px;'> <%=relasedByUserName%>&nbsp;&nbsp;</td>
	
	<%}else {%>	
	<td class='fields'><%=released_by%></td>
	<%}%>
	<input type=hidden name='bodrelby' id='bodrelby' value=''>
	
	 <td class='label'><fmt:message key="eMO.ReleaseDateTime.label" bundle="${mo_labels}"/></td>
	<td class='fields'><%=release_body_date%></td> 	
	</tr>
	<tr><td colspan='4' class='label'>&nbsp;</td></tr>
	 <tr>	     
	 <td class='label' ><fmt:message key="eMO.ExportationRequired.label" bundle="${mo_labels}"/> </td>
	 <td class='fields' ><%=exportReqdYN%></td>	 
	 <td class='label' ><fmt:message key="eMO.UnclaimedBody.label" bundle="${mo_labels}"/></td>
	 <td class='fields' ><%=unClaimBodyYN%></td>
	 </tr>			  
	 <tr><td colspan='4' class='label'>&nbsp;</td></tr>
	 <table cellpadding='4' cellspacing=0 width="100%" border=0>
	 <tr><td class="label" width="25%"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
						<td>						
						<select name='revert_release_reason' id='revert_release_reason'>
						<option value=''> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>
						<%
						if(rs!=null) rs.close();
						if(stmt!=null) stmt.close();
						stmt = con.createStatement();
						rs = stmt.executeQuery("select am_get_desc.am_contact_reason(contact_reason_code,'"+locale+"',1) Contact_Reason, Contact_Reason_Code from AM_CONTACT_REASON where REVERT_MO_RELEASE_YN = 'Y' and Eff_Status = 'E' order by 1");
						if(rs!=null)
						{
							while(rs.next())
							{
								String contact_code = rs.getString("Contact_Reason_Code");
								String contact_desc = rs.getString("Contact_Reason");
								out.println("<option value='"+contact_code+"'>"+contact_desc+"</option>"); 
							}
						}						
						%></select><img align=center src='../../eCommon/images/mandatory.gif'></img>						
						</td>
						</tr>
						</table>
						<tr><td colspan='4' class='label'>&nbsp;</td></tr>
						<table cellpadding='4' cellspacing=0 width="100%" border=0>
						<tr> 
						<td class="label" width="25%"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>						
						<td class='fileds'><textarea name="revert_remarks" ROWS="4" COLS="50" maxlength=200 onBlur="chkRemarksMaxlen(this);"></textarea></td>
		    			<td class='fields' style="vertical-align:bottom;"><input type='button' class='button' name='RevertReleased' id='RevertReleased' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.RervertReleased.label","mo_labels")%>' onClick='revertRelese();'><input type='button' class='button' onblur="javascript:AEScrollIntoView(1)" name='Close' id='Close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick='CloseRelDec();'></td>
					<td></td>
				</tr>
			</table>
	  <tr><td colspan='4' class='label'>&nbsp;</td></tr>
	  <!--Commented by Thamizh selvi on 25th Sep 2017 against incident [65326] - below td for buttons moved to above table-->
	   <!--<tr>
	   <table cellpadding='4' cellspacing=0 width="100%" border=0>
	  <td class='label' width="25%"></td>
	  <td class='label' width="25%"></td>	  
	  <td class='label' width="25%"></td>		  
	  <td class='fields'><input type='button' class='button' name='RevertReleased' id='RevertReleased' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.RervertReleased.label","mo_labels")%>' onClick='revertRelese();'><input type='button' class='button' onblur="javascript:AEScrollIntoView(1)" name='Close' id='Close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick='CloseRelDec();'>
	  </td></tr>
	  </table>-->
	 </table>
	<input type=hidden name ="facilityId" value='<%=facilityId%>'>
	<input type=hidden name ="reg_no" value='<%=reg_no%>'>
	<input type=hidden name ="expyn" value='<%=expyn%>'>
	<input type=hidden name ="sydate" value='<%=sydate%>'>
	<input type=hidden name ="byrecddate" value='<%=byrecddate%>'>
	<input type=hidden name ="first" value='<%=first%>'>
	</table> 
 <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
 


<a name="tab2"   onFocus='javascript:AEScrollIntoView(3);'></a> 	
	<ul id="tablist" class="tablist">
		<li class="tablistitem" title="ReleaseDetails">
			<a onclick="AEScrollIntoView(1)"  class="tabA" id="1" ><span class="tabASpan "><fmt:message key="Common.Release.label" bundle="${common_labels}"/><fmt:message key="Common.details.label" bundle="${common_labels}"/></span>
			</a>
		</li>
		<li class="tablistitem" title="Claimant" >
			<a onclick="AEScrollIntoView(3)" class="tabClicked" id="2" ><span class="tabSpanclicked" ><fmt:message key="eMO.Claimant.label" bundle="${mo_labels}"/></span>
			</a>
		</li>
	</ul>
<table cellspacing='0' cellpadding='2' width='100%' border='0' align='center'>
 
 	<tr><td colspan='4' class='label'>&nbsp;</td></tr>
	  
   
 
  </tr>
 
  <tr><td colspan='5' class='label'>&nbsp;</td></tr>
  <table cellspacing='0' cellpadding='0' width='100%' border='0' align='center'> 
<tr><td valign=top width='45%'> 
<table cellspacing='0' cellpadding='0' width='100%' border='0' align='center'> 

 <tr>
	       <td class='LABEL' width="20%" ><fmt:message key="eMO.ClaimantType.label" bundle="${mo_labels}"/></td>
			 <td class='querydata' width="30%"><b><%=claimant_type%></b></td> <!--Modified by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095-->
			 
			 <!--<%if(claimant_type.equals("K")){%>
			 <fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/>
			 <%}			
			 else if(claimant_type.equals("E")){%>
			 <fmt:message key="Common.employer.label" bundle="${common_labels}"/>
		     <%}
			else if(claimant_type.equals("M")){%>
			 <fmt:message key="eMO.EmbassyCountry.label" bundle="${mo_labels}"/>
		     <%}
			else if(claimant_type.equals("W")){%>
			 <fmt:message key="eMO.WelfareAssociations.label" bundle="${mo_labels}"/>
		     <%}
		  	else if(claimant_type.equals("R")){%>
		   <fmt:message key="eMO.ReligiousOrgn.label" bundle="${mo_labels}"/>
		     <%}
			else if(claimant_type.equals("U")){%>
		   <fmt:message key="eMO.UnderTaker.label" bundle="${mo_labels}"/>
		     <%}
			 else if(claimant_type.equals("O")){%>
			<fmt:message key="Common.others.label" bundle="${common_labels}"/>
		     <%}
			 else if(claimant_type.equals("F")){%>
		   <fmt:message key="eMO.ReleasedToOtherFacility.label" bundle="${mo_labels}"/>
		     <%}%>-->

       
   </td></tr>
   <!--Below line modified for this ML-MMOH-CRF-0860.2 -->
   <tr><td colspan='4' class='label'>&nbsp;</td></tr>
 <tr><td class='label' width='<%=claimant_legend_width%>'  ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
 <td class='querydata' width='<%=claimant_legend_datawidth%>' style="<%=org_width_word_wrap%>"><b><%=name%></b></td></tr>
 <tr><td colspan='4' class='label'>&nbsp;</td></tr>
 <tr>  
  <td  class='label'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
	<td class='querydata'><b>
  <% 
	 pstmt2  = con.prepareStatement("select RELATIONSHIP_CODE,SHORT_DESC from MP_RELATIONSHIP_LANG_VW where eff_status='E' and language_id='"+localeName+"' order by 2");
	 vrs = pstmt2.executeQuery();
	 while(vrs.next())
	  {
		 if(vrs.getString("RELATIONSHIP_CODE").equals(relationship))
		  {%>
			 <%=vrs.getString("SHORT_DESC")%> 
			  <%}
	  
	  }
	  if(vrs!=null)vrs.close();
	  if(pstmt!=null)pstmt.close();
	  
	  %></b>
	  
  </td>
  </tr>	
<tr><td colspan='4' class='label'>&nbsp;</td></tr>

	<%	if(accept_national_id_no_yn.equals("Y")){%>

	<tr>
	
	<!--Added by Ashwini on 02-Aug-2017 for ML-MMOH-CRF-0743-->
	<%if(!isClaimantChngsApplicable){%>
	<td class='label' width="<%=claimant_legend_width%>" ><%=nat_id_prompt%></td>
	<%}else{%>
	<td class='label' width="<%=claimant_legend_width%>" ><fmt:message key="eMO.MyKad.label" bundle="${mo_labels}"/></td>
	<%}%>
	
	<td class='querydata' width="<%=claimant_legend_datawidth%>" ><b><%=nat_id_no%></b>
	</td>
	</tr>	
  <%}else{%>
<input type=hidden name='NAT_ID_NO' id='NAT_ID_NO' value="">
	
<%	}%>	

			  <tr><td colspan='4' class='label'>&nbsp;</td></tr>
<tr><td class='label' width="<%=claimant_legend_width%>" ><fmt:message key="Common.EmployeeID.label" bundle="${common_labels}"/></td>
<td class='querydata'  width="<%=claimant_legend_datawidth%>" ><b><%=patient_employee_id%></b>
</td>
  </tr>	

<!--Added by Ashwini on 02-Aug-2017 for ML-MMOH-CRF-0743-->
<%if(isClaimantChngsApplicable){%>
<tr><td colspan='4' class='label'>&nbsp;</td></tr>
<tr><td class='label' width="<%=claimant_legend_width%>" ><fmt:message key="eMP.PassportNo.label" bundle="${mp_labels}"/></td>
<td class='querydata' width="<%=claimant_legend_datawidth%>">   <b><%=passport_no%></b>
</td>
</tr>	
<tr><td colspan='4' class='label'>&nbsp;</td></tr>
<tr><td class='label' width="<%=claimant_legend_width%>" ><fmt:message key="eMO.OtherId.label" bundle="${mo_labels}"/></td>
<td class='querydata' width="<%=claimant_legend_datawidth%>" style='word-wrap:break-word;width:175px;' >   <b><%=other_identification%></b>
</td>
</tr>	
<%}%>
 <!--Below line modified for ML-MMOH-CRF-0860.2-->
<tr><td colspan='4' class='label'>&nbsp;</td></tr>
<tr><td class='label'  width="<%=claimant_legend_width%>" ><fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/></td>
<td class='querydata' width="<%=claimant_legend_datawidth%>" style="<%=org_width_word_wrap%>" ><b><%=job_title%></b></td>
  </tr>	
<tr><td colspan='4' class='label'>&nbsp;</td></tr>
<tr><td class='label' width="<%=claimant_legend_width%>" ><fmt:message key="Common.orgName.label" bundle="${common_labels}"/></td>
<!--Below line modified for ML-MMOH-CRF-0860.2-->
<td class='querydata' width="<%=claimant_legend_datawidth%>" style="<%=org_width_word_wrap%>"  ><b><%=organization_name%></b></td>
</tr>
<tr><td colspan='4' class='label'>&nbsp;</td></tr>
<%if(!ocpn_class_desc.equals("")){%>
	
<tr><td class='label' id='hed1' width="<%=claimant_legend_width%>" ><fmt:message key="eMP.OccupationClass.label" bundle="${mp_labels}"/></td>
<td class='querydata' width="<%=claimant_legend_datawidth%>"><label id=ocpnlab class='label'><b><%=ocpn_class_desc%></b></td>
</tr>
<%}else{%>
<tr><td  class='label' id='hed1'  ></td>
<td class='querydata'><label id=ocpnlab></td>
</tr>
<%}if(claimant_type.equals("F")){ releasefacility = "visibility:visible";}%>
<!-- // Filed Newly Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
<tr>
<td class="label" width="22%" id='releasefacid'style="<%=releasefacility%>"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<td class="fields" id='releasefacdesc'style="<%=releasefacility%>">
<% 	
 	 if(pstmt2!=null) pstmt2.close();
 	 if(vrs!=null)vrs.close();
 	 pstmt2  = con.prepareStatement("select a.FACILITY_ID facility_id ,a.FACILITY_NAME facility_name from SM_FACILITY_PARAM a,MO_CLAIMANT b where a.facility_id = b.RELEASE_TO_FACILITY and a.facility_id!='"+facilityId+"'and b.REGISTRATION_NO='"+reg_no+"'");
 	 vrs = pstmt2.executeQuery();
				 while(vrs.next())
				  {
					 release_fac_id= vrs.getString("facility_id")==null?"":vrs.getString("facility_id");
					 
					 release_fac_desc= vrs.getString("facility_name")==null?"":vrs.getString("facility_name");
							
					 if(release_fac_id.equals(RELEASE_TO_FACILITY))
					  {%>
					  <b><%=release_fac_desc%></b> 
					<%}else{%>
					  <b><%=release_fac_desc%></b> 
					<%}
				 }%> </td>
   <%if(pstmt2!=null) pstmt2.close();
 	 if(vrs!=null)vrs.close();%>
</tr> 

<!--  Saanthaakumar  Bru-HIMS-CRF-366 [IN:039612] End--> <!--Below line Added for this CRF Bru-HIMS-CRF-366 [IN:039612] -->
	 <tr>
<td class="label" width='20%' id='remarksid' style="<%=releasefacility%>"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>&nbsp;
<td class="fields" width='30%' id='remarksdesc' style="<%=releasefacility%>"><!--textarea name='reason_desc' rows='5' cols='40'  disabled></textarea-->
<% if(!(reason_deceased_desc.equals("")))
{

String str1="";

int len = reason_deceased_desc.length();
 int i1=0;
int n_incre = 0;
int max = 0;

if (len > 30) 
{ 
    for ( i1=0; i1 <= (len/30);i1++) 
	{   
		if((i1+1)*30 < len)
			max = (i1+1)*30;
		 else
		  max = len;
		
        str1=str1+" "+reason_deceased_desc.substring((i1*30),max);
		
        n_incre = 1;
    }}
else  {
 str1=reason_deceased_desc;
 }
// Code Fixed Against Incident 42632 
request.setAttribute("specialCharString",str1); 
%>
<br><b><c:out value="${specialCharString}" escapeXml="true"/></b>
<%}%>							
</td></tr>
  </table>
		   </td>  
			  <td width='55%'><table cellspacing='0' cellpadding='0' border='0' width='100%'  >
			  <tr>
			  <td class='LABEL' width='25%'><fmt:message key="eMO.Claimant.label" bundle="${mo_labels}"/></td>
   <td class='querydata' width="25%"><b><%=claimant_desc%></b></td></tr>
   <tr><td colspan='4' class='label'>&nbsp;</td></tr>

				<%
      
ArrayList contact_addr= fetchContactAddresses(con,out,"parent.parent.messageFrame",p) ;
String[]	contact_col_names		        = (String[])contact_addr.get(1) ;
String[]	 contact_prompts			    = (String[])contact_addr.get(2) ;
//String[]  contact_fields					= (String[])contact_addr.get(3) ;
 contact_addr				    = null;
 

/* code for displaying address fields and postal code*/
 int tabIndex		            = 1;

		tabIndex++;
		out.println("<tr>") ; 
//		StringBuffer sb2 = new StringBuffer() ;
//		StringBuffer sb12 = new StringBuffer() ;
//		StringBuffer sba2 = new StringBuffer() ;
//		StringBuffer sbar2 = new StringBuffer();
 //       StringBuffer fieldVal2 = new StringBuffer("");
        for(int i=0;i<contact_col_names.length; i++)
	  {
			out.println("<tr>") ;
            out.println("<td class='label' width='"+addr_legnd_width+"' >"+contact_prompts[i]+"&nbsp;</td>") ;
            if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
                Addr_val = addrl1;
            else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
                Addr_val = addrl2;
            else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
                Addr_val = addrl3;
            else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
                Addr_val = addrl4;
            else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
                Addr_val = res_area_desc;
            else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
                Addr_val = res_town_desc;
			else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
                Addr_val = region_desc;
            else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
                Addr_val = postal_code;
            out.println("<td   class='querydata' width='"+addr_data_width+"' style='"+td_word_wrap+"' ><b>"+Addr_val+"</b></td>") ;
        out.println("</tr>") ;
		out.println("<tr><td colspan='4' class='label'>&nbsp;</td></tr>");
	  }
                   %> 
		  
	 <%	 
		String sq3 = "select short_name from MP_COUNTRY_LANG_VW  where LANGUAGE_ID='"+localeName+"' and country_code = '"+country_code+"'";

		pstmt2  = con.prepareStatement(sq3);
        vrs = pstmt2.executeQuery();
        
		
		while( vrs.next())
		{
			kcou=checkForNull(vrs.getString("short_name"));
		
	//	}     


}

   %>	
  
			  <tr><td colspan='4' class='label'>&nbsp;</td></tr>
      	    <tr>
		  <td  class='label'><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
         <td class='querydata' ><b><%=kcou%></td>
          </tr>
		  <tr><td colspan='4' class='label'>&nbsp;</td></tr>
          <tr>
              <td  class='label'><fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/></td>
              <td class='querydata'><b><%=telephone_res%></b></td>
		  </tr>
		  <tr><td colspan='4' class='label'>&nbsp;</td></tr>
          <tr>
              <td  class='label' ><fmt:message key="eMO.MobilePhoneNo.label" bundle="${mo_labels}"/></td>
              <td class='querydata'><b><%=mob_tel_no%></b></td></tr>
			  <tr><td colspan='4' class='label'>&nbsp;</td></tr>
		  <tr>
			  <td  class='label'><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td>
              <td class='querydata'><b><%=telephone_off%></b></td>
          </tr>
		  <tr><td colspan='4' class='label'>&nbsp;</td></tr>
		  <tr>
		      <td class='label'><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>
              <td class='querydata'><b><%=email_id%></b></td>
          </tr></td></tr>
		 </table>



  
  
  </table>
	
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

	<input type='hidden' name='ZIP_CODE' id='ZIP_CODE' value="<%=zip_code%>">
    <input type='hidden' name='COUNTRY_CODE' id='COUNTRY_CODE' value="<%=country_code%>">
  <input type='hidden' name='area1' id='area1' value='<%=res_area_code%>'>
  <input type='hidden' name='town1' id='town1' value='<%=res_town_code%>'>
   <input type='hidden' name='region1' id='region1' value='<%=region_code%>'>
<input type='hidden' name='m_town' id='m_town' value='<%=res_town_code%>'>
<input type='hidden' name='m_area' id='m_area' value='<%=res_area_code%>'>
<input type='hidden' name='m_region' id='m_region' value='<%=region_code%>'>
<input type='hidden' name='m_postal_code' id='m_postal_code' value='<%=zip_code%>'>

<input type='hidden' name='bed_no' id='bed_no' value='<%=bed_no%>'>
<input type='hidden' name='rfid_tag_no' id='rfid_tag_no' value='<%=rfid_tag_no%>'>
<input type='hidden' name='pateint_id' id='pateint_id' value='<%=pid%>'>
<input type='hidden' name='mo_area_code' id='mo_area_code' value='<%=area_code%>'>



<script>
	 
	if(document.forms[0].addr_line_1)
		document.forms[0].addr_line_1.disabled = true;
	if(document.forms[0].addr_line_2)
		document.forms[0].addr_line_2.disabled = true;
	if(document.forms[0].addr_line_3)
		document.forms[0].addr_line_3.disabled = true;
	if(document.forms[0].addr_line_4)
		document.forms[0].addr_line_4.disabled = true;

	if(document.forms[0].m_town_code){
		document.forms[0].m_town_code.disabled = true;
		document.forms[0].town_code.disabled = true;
	}
	if(document.forms[0].m_area_code){
		document.forms[0].m_area_code.disabled = true;
		document.forms[0].area_code.disabled = true;
	}
	if(document.forms[0].m_region_code){
		document.forms[0].m_region_code.disabled = true;
		document.forms[0].region_code.disabled = true;
	}
	if(document.forms[0].m_postal_code1){
		document.forms[0].m_postal_code1.disabled = true;
		document.forms[0].postal_code.disabled = true;
	}
 
	</script>          
</form>
</body>
</html>
<%    if(rs!=null) rs.close();
	  if(stmt!=null) stmt.close();
	  if(pstmt!=null) pstmt.close();
   } 
   catch(Exception e)
   { 
	   out.println("Exception in MOReleaseDeceasedSearch"+e.toString());
	   e.printStackTrace();
   }
   finally
    {
	   ConnectionManager.returnConnection(con,request);
    }
%>
<%!
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}
%>

