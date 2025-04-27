<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eMP/jsp/PatientAddressLegends.jsp" %>
<html>


<head><title><fmt:message key="eMO.ReleaseDeceased.label" bundle="${mo_labels}"/></title>
	  <%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");

%>

      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	  <link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	  <Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
	  <script language='javascript' src='../../eMO/js/MOReleaseDeceased.js'></script>
	  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	  <script language='javascript' src='../../eCommon/js/common.js'></script>
	  <script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
	  <script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  
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

try
  { 
     con = ConnectionManager.getConnection(request);
	 //Added by Shagar for ML-MMOH-CRF-0690
	 iSSiteApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MO", "RELEASED_BY_LOGINID_DISABLE");

	 isClaimantChngsApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","CLAIMANT_MNDT_FLD_RENAME"); //Added by Ashwini on 02-Aug-2017 for ML-MMOH-CRF-0743
	 
	 
	 //Added for this CRF ML-MMOH-CRF-0860.2
	String maxsize="30";	
	String maximumLength="30";
	Boolean increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");
	
	Boolean isReceivedDateTimeAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","RECEIVED_DATE_TIME");// Added by Shanmukh on 26th-JUNE-2018 for ML-MMOH-CRF-1036

	/*Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
	String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");
	JSONArray ClaimantTypeJsonArr = new JSONArray();
	ClaimantTypeJsonArr = eMO.MOCommonBean.getClaimantType(con,function_id);
	/*End ML-MMOH-CRF-1095*/
	
	if(increasedaddressLength){	  
	  maximumLength="50";	 
	  maxsize="64";
	}
	//End this ML-MMOH-CRF-0860.2


	 
	 Properties p		= (java.util.Properties) session.getValue("jdbc");
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
	 String unclaimed_body_yn="";

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
     //String pmcb ="";
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
     String patient_id="";
	 String name="";
	 String	facilityId 	   = (String) session.getValue( "facility_id" ) ;
	 String	loginUser 	   = (String) session.getValue( "login_user" ) ;
	 String loginUserName	= "";
	 String locale = (String) session.getValue("LOCALE");
     String patientid      = checkForNull(request.getParameter("param"));
	 String first          = checkForNull(request.getParameter("first"));
	 String release_fac_id=""; // Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
	 String release_fac_desc=""; // Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
	 String release_to_facility=""; // Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
	 String releasefacility = "visibility:hidden"; // Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
	 String reason_deceased_desc=""; //this line added for this CRF Bru-HIMS-CRF-366 [IN-039612]
	 
	 //Added by Santhosh for ML-MMOH-CRF-1948
	 String claim_date_time ="";
	 String datetime_claim_mand ="";
	 Boolean datetimeOfClaimingAppl = false;
	  
	  datetimeOfClaimingAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MO","DATETIME_OF_CLAIMING");
	  pstmt2  = con.prepareStatement("select DATETIME_CLAIM_MAND from MO_PARAMETER where facility_id = '"+facilityId+"' ");		
		vrs = pstmt2.executeQuery();
		if((vrs!=null) && vrs.next()){
			datetime_claim_mand= checkForNull(vrs.getString("DATETIME_CLAIM_MAND"));
		}

		if(pstmt2 != null) {
			pstmt2.close();
		}
		if(vrs != null) {
			vrs.close();
		}
		//END
	if(!(patientid.equals("")))
	  {
		 
		  //pstmt2  = con.prepareStatement("select FACILITY_ID, REGISTRATION_NO, CLAIMANT_TYPE_DESC, CLAIMANT_TYPE_CODE,CLAIMANT_TYPE, RELATIONSHIP, NAME, JOB_TITLE, ADD_LINE1, ADD_LINE2, ADD_LINE3, ADD_LINE4, ZIP_CODE, COUNTRY_CODE, RES_TOWN_CODE, RES_AREA_CODE, REGION_CODE, TELEPHONE_OFF, TELEPHONE_RES, EMAIL_ID, MOB_TEL_NO, NAT_ID_NO,ORGANIZATION_NAME,PATIENT_EMPLOYEE_ID,res_town_desc,res_area_desc,region_desc from mo_claimant_vw where  REGISTRATION_NO = ? and facility_id=?");

		  pstmt2  = con.prepareStatement("select FACILITY_ID, REGISTRATION_NO, CLAIMANT_TYPE_DESC, CLAIMANT_TYPE_CODE,CLAIMANT_TYPE, RELATIONSHIP, NAME, JOB_TITLE, ADD_LINE1, ADD_LINE2, ADD_LINE3, ADD_LINE4, ZIP_CODE, COUNTRY_CODE, RES_TOWN_CODE, RES_AREA_CODE, REGION_CODE, TELEPHONE_OFF, TELEPHONE_RES, EMAIL_ID, MOB_TEL_NO, NAT_ID_NO,ORGANIZATION_NAME,PATIENT_EMPLOYEE_ID,PASSPORT_NO,OTHER_IDENTIFICATION,MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+localeName+"','2') res_town_desc,MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+localeName+"','2') res_area_desc,MP_GET_DESC.MP_REGION(REGION_CODE,'"+localeName+"','2') region_desc,RELEASE_TO_FACILITY,REASON from mo_claimant_vw where  REGISTRATION_NO = ? and facility_id=?");

		
		  pstmt2.setString(1,patientid);
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

	    release_to_facility=vrs.getString("RELEASE_TO_FACILITY")==null?"":vrs.getString("RELEASE_TO_FACILITY");
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
	// qry1 ="select PATIENT_NAME,(DATE_OF_BIRTH) dob,SEX,BROUGHT_BY_POLICE_YN,(BODY_RECEIVED_DATE) byrecddate,ENCOUNTER_ID,PM_YN,decode(BURIAL_PERMIT_NO,NULL,'No','Yes') BURIAL_PERMIT_GEN_YN,EXPORTATION_REQD_YN,age,POSTMORTEM_STATUS,ALT_ID1_DESC, ALT_ID1_NO, ALT_ID2_DESC, ALT_ID2_NO, ALT_ID3_DESC, ALT_ID3_NO, ALT_ID4_DESC, ALT_ID4_NO,patient_id,mlc_yn,unclaimed_body_yn,burial_permit_no from mo_mortuary_regn_vw where REGISTRATION_NO='"+patientid+"' and FACILITY_ID = '"+facilityId+"'";

	qry1 ="select  decode('"+localeName+"', 'en', patient_name,nvl(patient_name_loc_lang, patient_name)) PATIENT_NAME,(DATE_OF_BIRTH) dob,SEX,BROUGHT_BY_POLICE_YN,(BODY_RECEIVED_DATE) byrecddate,ENCOUNTER_ID,PM_YN,decode(BURIAL_PERMIT_NO,NULL,'No','Yes') BURIAL_PERMIT_GEN_YN,EXPORTATION_REQD_YN,age,POSTMORTEM_STATUS,ALT_ID1_DESC, ALT_ID1_NO, ALT_ID2_DESC, ALT_ID2_NO, ALT_ID3_DESC, ALT_ID3_NO, ALT_ID4_DESC, ALT_ID4_NO,patient_id,mlc_yn,unclaimed_body_yn,burial_permit_no,CLAIM_DATE_TIME,sm_get_desc.sm_appl_user('"+loginUser+"','"+locale+"','1') loginUserName from mo_mortuary_regn_vw where REGISTRATION_NO='"+patientid+"' and FACILITY_ID = '"+facilityId+"'";
	
	
	
	   pstmt =con.prepareStatement(qry1);
	   rs	 = pstmt.executeQuery();
	   while(rs!=null  && rs.next())
	   {
	    
		   pname		= checkForNull(rs.getString(1));
		  
		   //dob			= checkForNull(rs.getString(2));
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
		  //dcert		= checkForNull(rs.getString(7));
           pmyn			= checkForNull(rs.getString(7));
		   bpyn			= checkForNull(rs.getString(8));
		   expyn		= checkForNull(rs.getString(9));
    	   age			= checkForNull(rs.getString(10));
    	   pmstatus     = checkForNull(rs.getString(11));
    	   //pmcb			= checkForNull(rs.getString(13));
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
		   loginUserName=checkForNull(rs.getString("loginUserName"));
		   unclaimed_body_yn= checkForNull(rs.getString("unclaimed_body_yn"));	
		   claim_date_time=checkForNull(rs.getString("CLAIM_DATE_TIME"));//Added by Santhosh for ML-MMOH-CRF-1948

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
	//togetpid = "select ethnic_long_desc,race_long_desc,alt_id1_no,alt_id2_no from mp_chg_pat_dtls_vw where patient_id ='"+pid+"'";

	togetpid = "select MP_GET_DESC.MP_ETHNIC_GROUP(ETHNIC_GRP_CODE,'"+localeName+"','1') ethnic_long_desc,MP_GET_DESC.MP_RACE(RACE_CODE,'"+localeName+"','1') race_long_desc,alt_id1_no,alt_id2_no from mp_chg_pat_dtls_vw where patient_id ='"+pid+"'";

	stmt =con.createStatement();
	rs = stmt.executeQuery(togetpid);
	while(rs!=null  && rs.next())
	 {
		ethnic = checkForNull(rs.getString("ethnic_long_desc"));
		race   = checkForNull(rs.getString("race_long_desc"));
		//pport  = checkForNull(rs.getString("alt_id1_no"));
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
	 <body OnMouseDown='CodeArrest()' onload="firstfocus();getClaimant1('<%=claimant_type%>','<%=claimant_type_code%>');ClearClaimantValues()" onKeyDown="lockKey()">
	 <form name="RDeceased_form" id="RDeceased_form" action="../../servlet/eMO.MOReleaseDeceasedServlet" method="post" target="msgFrame">
	 
	 <!--<a name="tab1"   onFocus='javascript:AEScrollIntoView(1);'></a><table width='95%' cellpadding='0' cellspacing='0' BORDER='0' ><tr><td width='1%' class='BODYCOLORFILLED'></td><td  class='BODYCOLORFILLED' ><a align ='left' href="javascript:AEScrollIntoView(1)" style="cursor:pointer;" ><img src='../../eMO/images/ReleaseDetails.gif' border=0 ></a><a align='left' href="javascript:AEScrollIntoView(3)"  ><img src="../../eMO/images/Claimant.gif" border=0>
	 </tr> 
	 </table>-->
	 <a name="tab1"  id="tab1"   onFocus='javascript:AEScrollIntoView(1);'></a> 	
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
		    <td class='querydata' width='25%'><b><%=patientid%></b></td> 			
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
		     <!--  <td class='label' align='right' width='9%'>PMI</td>
		      <td class='label' align='left' width='16%'>&nbsp;&nbsp;<%=pmi%>
			  </td> 	 -->
 			<td class='label'><fmt:message key="Common.race.label" bundle="${common_labels}"/></td>
		      <td class='querydata' ><b><%=race%></b></td> 
		      <td class='label' ><fmt:message key="eMO.BurialPermitNumber.label" bundle="${mo_labels}"/></td>
			  <!--Style Added by Santhosh for ML-MMOH-CRF-1947>-->
		      <td class='querydata' style='word-wrap:break-word;width:400px;'><b><%=burial_permit_no%></b>
			  </td>
			 </tr>
				<tr><td colspan='4' class='label'>&nbsp;</td></tr>
			<tr>		      
		      <td class='label' ><fmt:message key="eMO.BroughtByPolice.label" bundle="${mo_labels}"/></td>
		      <td class='querydata' ><b><%=bbypol%></b></td> 
			  <!--Below label name modified by Shanmukh on 26th-JUNE-2018 for ML-MMOH-CRF-1036-->
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
	<td class='fields' ><input type='text' size="30" maxlength="30" name='police_officer' id='police_officer'  <%=disabledyn%> value=''></td>
	 <td class='label' ><fmt:message key="eMO.PoliceStation.label" bundle="${mo_labels}"/></td>
	<td class='fields'><input type='text' size="30" maxlength="30" <%=disabledyn%> name='police_station'></td> </tr>
	<tr><td colspan='4' class='label'>&nbsp;</td></tr>
	<tr>		
	<td class='label' ><fmt:message key="eMO.PoliceRank.label" bundle="${mo_labels}"/></td>
	<td class='fields' ><input type='text' size="30" maxlength="30" name='rank' id='rank' <%=disabledyn%> value=''></td>
	 <td class='label' colspan='2' ></td>
	</tr>
	<tr><td colspan='4' class='label'>&nbsp;</td></tr>
	<tr>		
	<td class='label' ><fmt:message key="eMO.BurialPermitIssued.label" bundle="${mo_labels}"/></td>
	<td class='fields' ><input type='checkbox' name='burial_issued' id='burial_issued' value='N' onClick='assignval(this);'><input type=hidden name='burial_issued_yn' id='burial_issued_yn' value='N'></td>
	 <td class='label' ><fmt:message key="eMO.BurialPermitIssueDateTime.label" bundle="${mo_labels}"/></td>
	<td class='fields'><input type='text' size="16"  disabled maxlength="16" name='burial_dtime' id='burial_dtime' onblur='dtchk(this);'><img disabled  id=burcal src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].burial_dtime.select();return showCalendar('burial_dtime', null, 'hh:mm' );" style="cursor='hand'"><img src='../../eCommon/images/mandatory.gif' id='burman' style="visibility:hidden" align='center'></img></td>
	</tr>
	<tr><td colspan='4' class='label'>&nbsp;</td></tr>
	
	
     <!--Added by Shagar ML-MMOH-CRF-0690 -->	
     <%if(iSSiteApplicable) 
	{%>
	<tr>
      <td class='label' ><fmt:message key="eMO.ReleasedBy.label" bundle="${mo_labels}"/></td>
	<td class='querydata'style='word-wrap: break-word;width:200px;'> <%=loginUserName%>&nbsp;&nbsp;</td>
	<input type=hidden name='bodrelby' id='bodrelby' value='<%=loginUser%>'>
    	<%}else {%>	
	<tr>		
	<td class='label' ><fmt:message key="eMO.ReleasedBy.label" bundle="${mo_labels}"/></td>
	<td class='fields'><input type='text' size="30" maxlength="30" name='bodrelbydesc' id='bodrelbydesc' value='' onblur="beforeGetPractitioner(this,bodrelbydesc)"><input type="button" name="relby" id="relby" class=BUTTON value="?" onClick="searchCode2(this, bodrelbydesc);" ><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
	<input type=hidden name='bodrelby' id='bodrelby' value=''>
	<%}%>
	
	 <td class='label'><fmt:message key="eMO.ReleaseDateTime.label" bundle="${mo_labels}"/></td>
	<td class='fields'><input type='text' size="16" maxlength="16" name='bodreldate' id='bodreldate' value='<%=sydate%>' onblur='dtchk(this);'><img src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].bodreldate.select();return showCalendar('bodreldate', null, 'hh:mm' );" style="cursor='hand'"><img src='../../eCommon/images/mandatory.gif'align='center'></img> </td> 	
	</tr>
	<tr><td colspan='4' class='label'>&nbsp;</td></tr>
	 <tr>	     
	 <td class='label' ><fmt:message key="eMO.ExportationRequired.label" bundle="${mo_labels}"/> </td>
	 <td class='fields' ><input type='checkbox' name='exp_Req' id='exp_Req' value='' <%=chk%> >
	 </td>	 
	 <td class='label' ><fmt:message key="eMO.UnclaimedBody.label" bundle="${mo_labels}"/></td>
	 <td class='fields' >
	<%if( unclaimed_body_yn.equals("Y")){%>
	 <input type='checkbox' name='unclaimed_body_yn' id='unclaimed_body_yn' onClick='ClearClaimantValues();' value='Y' checked >
	 <%}else{%> 
	 <input type='checkbox' name='unclaimed_body_yn' id='unclaimed_body_yn' onClick='ClearClaimantValues();' value='N'>
	 <%}%>
	 </td>
	 </tr>			  
	  <tr><td colspan='4' class='label'>&nbsp;</td></tr>
	  <tr>
	  <td colspan='3' class='label'></td>
	  <td class='fields'><input type='button' class='button' name='Record' id='Record' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' onClick='recordRelDec();'><input type='button' class='button' onblur="javascript:AEScrollIntoView(1)" name='Close' id='Close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick='CloseRelDec();'>
	  </td></tr>
	 </table>
	<input type=hidden name ="facilityId" value='<%=facilityId%>'>
	<input type=hidden name ="patient_id" value='<%=patientid%>'>
	<input type=hidden name ="expyn" value='<%=expyn%>'>
	<input type=hidden name ="sydate" value='<%=sydate%>'>
	<input type=hidden name ="byrecddate" value='<%=byrecddate%>'>
	<input type=hidden name ="first" value='<%=first%>'>
	</table> 
 <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
 
<!--<a name="tab2"  onFocus='javascript:AEScrollIntoView(3);'></a> 
<table width='100%' cellpadding='0'   cellspacing='0' BORDER='0'><tr><td  class='BODYCOLORFILLED'></td><td  class='BODYCOLORFILLED'>&nbsp;&nbsp;&nbsp;&nbsp;<a align ='left' href="javascript:AEScrollIntoView(1)"><img src="../../eMO/images/ReleaseDetailsClick.gif" border=0></a><a align='left'  href="javascript:AEScrollIntoView(3)"><img src="../../eMO/images/ClaimantClick.gif" border=0 id='clmt'></a></td></tr>
</table>-->

<a name="tab2"  id="tab2"  onFocus='javascript:AEScrollIntoView(3);'></a> 	
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
 <tr><td colspan='5' class='label' ></td></tr>
<tr><!-- // ALIGNMENT Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
	       <td class='LABEL' width="14%" ><fmt:message key="eMO.ClaimantType.label" bundle="${mo_labels}"/></td>
			 <td class='fields' width="30%"><select name='CLAIMANT_TYPE' id='CLAIMANT_TYPE'   onchange="getClaimant(this,'<%=claimant_type_code%>');" onfocus="" >
			 <option value='' >--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
			
			 <!--Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095-->
			 <%
			 for(int i = 0 ; i < ClaimantTypeJsonArr.size() ; i++) 
			 {
				JSONObject ClaimantTypeJson	= (JSONObject)ClaimantTypeJsonArr.get(i);
				String claimant_type_mstr_code = (String) ClaimantTypeJson.get("claimant_type_mstr_code");
				String claimant_short_desc = (String) ClaimantTypeJson.get("short_desc");
				out.println("<option value='"+claimant_type_mstr_code+"'>"+claimant_short_desc+"</option>");	
			 }
			 %>
			
			 <!--<%if(claimant_type.equals("K")){%>
			 <option value='K' selected><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></option>
		     <%}else{%>
			 <option value='K' ><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></option>
			 <%}			
			 if(claimant_type.equals("E")){%>
			 <option value='E' selected><fmt:message key="Common.employer.label" bundle="${common_labels}"/></option>
		     <%}else{%>
			 <option value='E' ><fmt:message key="Common.employer.label" bundle="${common_labels}"/></option>
			 <%}
			if(claimant_type.equals("M")){%>
			 <option value='M' selected><fmt:message key="eMO.EmbassyCountry.label" bundle="${mo_labels}"/></option>
		     <%}else{%>
			 <option value='M' ><fmt:message key="eMO.EmbassyCountry.label" bundle="${mo_labels}"/></option>
			 <%}
			if(claimant_type.equals("W")){%>
			 <option value='W' selected><fmt:message key="eMO.WelfareAssociations.label" bundle="${mo_labels}"/></option>
		     <%}else{%>
			 <option value='W' ><fmt:message key="eMO.WelfareAssociations.label" bundle="${mo_labels}"/></option>
			 <%}
		  	if(claimant_type.equals("R")){%>
		   <option value='R' selected><fmt:message key="eMO.ReligiousOrgn.label" bundle="${mo_labels}"/></option>
		     <%}else{%>
			   <option value='R' ><fmt:message key="eMO.ReligiousOrgn.label" bundle="${mo_labels}"/></option>
			 <%}

			if(claimant_type.equals("U")){%>
		   <option value='U' selected><fmt:message key="eMO.UnderTaker.label" bundle="${mo_labels}"/></option>
		     <%}else{%>
			   <option value='U' ><fmt:message key="eMO.UnderTaker.label" bundle="${mo_labels}"/></option>
			 <%}
				
		
			 if(claimant_type.equals("O")){%>
			 <option value='O' selected><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
		     <%}else{%>
			<option value='O' ><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
			 <%}
			 if(claimant_type.equals("F")){%>
					 <option value='F' selected><fmt:message key="eMO.ReleasedToOtherFacility.label" bundle="${mo_labels}"/></option>
				 <%}else{%>
					<option value='F' ><fmt:message key="eMO.ReleasedToOtherFacility.label" bundle="${mo_labels}"/></option>
				 <%}%>-->
			
     </select>
       
   </td>
	<!-- // ALIGNMENT Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
   <td class='LABEL' width='17%'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eMO.Claimant.label" bundle="${mo_labels}"/></td>
   <td class='fields' width="30%"><select name='CLAIMANT_TYPE_CODE' id='CLAIMANT_TYPE_CODE' onchange="set_values(this,'<%=patient_id%>');" disabled>
  <option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
  </select><img src='../../eCommon/images/mandatory.gif'align='center' id=id3 style="visibility:hidden"></img>
  </td>
 <!-- // ALIGNMENT Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
 <td class='fields' width='6%'><INPUT TYPE="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.CopyDetails.label","mo_labels")%>" name=copydet disabled onClick="copyDet('<%=pid%>')"class=button></td>&nbsp;&nbsp;
  </tr>
   <!-- Added by Santhosh for ML-MMOH-CRF-1948-->
   <%if(datetimeOfClaimingAppl){%>	
   <tr>
	<td class='label'><fmt:message key="eMO.DateTimeOfClaiming.label" bundle="${mo_labels}"/></td>
	<td class='fields'><input type='text' size="16" maxlength="16" name='claimdatetime' id='claimdatetime'value='<%=claim_date_time%>'onblur='dtchk(this);'><img src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].claimdatetime.select();return showCalendar('claimdatetime', null, 'hh:mm' );" style="cursor='hand'"><%if( datetime_claim_mand.equals("R")){%>	<img src='../../eCommon/images/mandatory.gif'align='center'></img> <%}%></td>
	</tr>
	 <%}%>
	<!--End-->
  <tr><td colspan='5' class='label'>&nbsp;</td></tr>
  <table cellspacing='0' cellpadding='0' width='100%' border='0' align='center'>
<tr><td valign=top width='45%'>
<table cellspacing='0' cellpadding='0' width='100%' border='0' align='center'>
 <!-- // ALIGNMENT Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
 <tr><td class='label' width='20%'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
 <td class='fields' width='30%'><input type="text" name="NAME" id="NAME"  maxlength='30' size='20'  value="<%=name%>" ></td></tr>
 <tr>  
  <td  class='label'width='20%'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
	<td class='fields'width='30%'><select name='RELATIONSHIP' id='RELATIONSHIP' ><option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----</option>
  <% //pstmt2  = con.prepareStatement("select RELATIONSHIP_CODE,SHORT_DESC from MP_RELATIONSHIP where eff_status='E' order by 2");
	 pstmt2  = con.prepareStatement("select RELATIONSHIP_CODE,SHORT_DESC from MP_RELATIONSHIP_LANG_VW where eff_status='E' and language_id='"+localeName+"' order by 2");
	 vrs = pstmt2.executeQuery();
	 while(vrs.next())
	  {
		 if(vrs.getString("RELATIONSHIP_CODE").equals(relationship))
		  {%>
			 <option value='<%=vrs.getString("RELATIONSHIP_CODE")%>' selected ><%=vrs.getString("SHORT_DESC")%> </option>
			  <%}else
			  {%>
			<option value='<%=vrs.getString("RELATIONSHIP_CODE")%>' ><%=vrs.getString("SHORT_DESC")%> </option>
			 <%}
			  
				  
	  }
	  if(vrs!=null)vrs.close();
	  if(pstmt!=null)pstmt.close();
	  
	  %>
	  
	
  
  
  </td>
  </tr>	
	<%	if(accept_national_id_no_yn.equals("Y")){%>
	<!-- // ALIGNMENT Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
	<tr>
	<!--Added by Ashwini on 02-Aug-2017 for ML-MMOH-CRF-0743-->
	<%if(!isClaimantChngsApplicable){%>
	<td class='label' width='20%'><%=nat_id_prompt%></td>
	<%}else{%>
	<td class='label'width='20%'><fmt:message key="eMO.MyKad.label" bundle="${mo_labels}"/></td>
	<%}%>
	<td class='fields'width='30%'>
	<input type="text" name="NAT_ID_NO" id="NAT_ID_NO"  maxlength='<%=nat_id_length%>' size='20'  value='<%=nat_id_no%>' >
	</td>
	</tr>	
  <%}else{%>
<input type=hidden name='NAT_ID_NO' id='NAT_ID_NO' value="">
	
<%	}%>	<!-- // ALIGNMENT Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
<tr><td class='label'width='20%' ><fmt:message key="Common.EmployeeID.label" bundle="${common_labels}"/></td>
<td class='fields'width='30%'>   <input type="text" name="PATIENT_EMPLOYEE_ID" id="PATIENT_EMPLOYEE_ID"  maxlength='20' size='20'  value='<%=patient_employee_id%>' >
</td>
  </tr>	

  <!--Added by Ashwini on 02-Aug-2017 for ML-MMOH-CRF-0743-->
  <%if(isClaimantChngsApplicable){%>
	<tr><td  class='LABEL' width='20%'><fmt:message key="eMP.PassportNo.label" bundle="${mp_labels}"/></td>
	<td class='fields' width='30%'>   <input type="text" name="PASSPORT_NO" id="PASSPORT_NO" onBlur='validSplchars(this);' onKeyPress="return SpCharChkForPassportNo(event);" maxlength='15' size='15'  value='<%=passport_no%>' >
	</td></tr>
	<tr><td  class='LABEL' width='20%'><fmt:message key="eMO.OtherId.label" bundle="${mo_labels}"/></td>
	<td class='fields' width='30%'>   <input type="text" name="OTHER_IDENTIFICATION" id="OTHER_IDENTIFICATION"  maxlength='60' size='30'  value='<%=other_identification%>' >
	</td></tr>
  <%}%>


<!-- // ALIGNMENT Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
<tr><td class='label' width='20%'><fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/></td>
<td class='fields'width='30%'><input type="text" name="JOB_TITLE" id="JOB_TITLE"  maxlength='<%=maximumLength%>' size='<%=maxsize%>'  value='<%=job_title%>' ></td>
  </tr>	
<!-- // ALIGNMENT Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
<tr><td class='label'width='20%' ><fmt:message key="Common.orgName.label" bundle="${common_labels}"/></td>
<td class='fields'width='30%'><input type="text" name="ORGANIZATION_NAME" id="ORGANIZATION_NAME"  maxlength='<%=maximumLength%>' size='<%=maxsize%>'  value='<%=organization_name%>' ></td>
</tr>
<%if(!ocpn_class_desc.equals("")){%>
<!-- // ALIGNMENT Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->	
<tr><td class='label' id='hed1' width='20%' ><fmt:message key="eMP.OccupationClass.label" bundle="${mp_labels}"/></td>
<td class='querydata'width='30%'><label id=ocpnlab class='label'><b><%=ocpn_class_desc%></b></td>
</tr>
<%}else{%>
<!-- // ALIGNMENT Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
<tr><td  class='label' id='hed1'  width='20%'></td>
<td class='querydata'><label id='ocpnlab'width='30%'></td>
</tr>
<%} if(claimant_type.equals("F")){ releasefacility = "visibility:visible";} %>
<!-- // Filed Newly Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->
<tr>
<td class="label" width='20%' id='releasefacid'style="<%=releasefacility%>"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<td class="fields" id='releasefacdesc'style="<%=releasefacility%>"width='30%'><select name='RELEASE_TO_FACILITY' id='RELEASE_TO_FACILITY' >
<% 
 	 if(pstmt2!=null) pstmt2.close();
 	 if(vrs!=null)vrs.close();
 	 pstmt2  = con.prepareStatement("select b.FACILITY_ID facility_id ,a.FACILITY_NAME facility_name from SM_FACILITY_PARAM a,sm_modules_facility b where a.facility_id = b.facility_id and b.module_id = 'MO' and a.facility_id!='"+facilityId+"'order by 2");
				 vrs = pstmt2.executeQuery();
				 while(vrs.next())
				  {
					 release_fac_id= vrs.getString("facility_id")==null?"":vrs.getString("facility_id");
					 
					 release_fac_desc= vrs.getString("facility_name")==null?"":vrs.getString("facility_name");
					 if(release_fac_id.equals(release_to_facility))
					  {%>
						 <option value='<%=release_fac_id%>' selected ><%=release_fac_desc%> </option>
					<%}else{%>
						<option value='<%=release_fac_id%>' ><%=release_fac_desc%> </option>
					<%}
						  
				  }%> 		 </select></td>
	 <%if(pstmt2!=null) pstmt2.close();
 	 if(vrs!=null)vrs.close();%>
</tr> 
 <tr>
<td class="label" width='20%' id='remarksid' style="<%=releasefacility%>"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>&nbsp;
<td class="fields" width='30%' id='remarksdesc' style="<%=releasefacility%>"><textarea name='reason_desc' rows='5' cols='40'  onKeyPress='checkMaxLimit(this,100);' onpaste='return maxLengthPaste(this,"100");' onBlur='return maxLength(this,"100");'>
<%=reason_deceased_desc%></textarea>
							
</td></tr>
<!--  Saanthaakumar  Bru-HIMS-CRF-366 [IN:039612] End-->
  </table>
		   </td>  
			  <td width='55%'><table cellspacing='0' cellpadding='0' border='0' width='100%'  >
				<!--<tr><td colspan=8 class=label height=5></td></tr>-->
              <!--<table cellspacing='0' cellpadding='0' border="1">
               <tr><td colspan=8 class=label height=5></td></tr>-->

				<%
// String[] address1_fld_names={"addr_line_1","addr_line_2","addr_line_3","addr_line_4","region","area","town","postal_code"};
//String[] address_col_names=	{"ADDR_LINE1_PROMPT","ADDR_LINE2_PROMPT","ADDR_LINE3_PROMPT","ADDR_LINE4_PROMPT","REGION_PROMPT","RES_AREA_PROMPT","RES_TOWN_PROMPT","POSTAL_CODE_PROMPT"};



//ADDR_LINE1_PROMPT


	

//String[] address_fld_values=	{addrl1,addrl2,addrl3,addrl4,region_desc,res_area_desc,res_town_desc,postal_code};	      
ArrayList contact_addr= fetchContactAddresses(con,out,"parent.parent.messageFrame",p) ;
String[]	contact_col_names		        = (String[])contact_addr.get(1) ;
String[]	 contact_prompts			    = (String[])contact_addr.get(2) ;
String[]  contact_fields					= (String[])contact_addr.get(3) ;
 contact_addr				    = null;
 


//new code



/* code for displaying address fields and postal code*/
 int tabIndex		            = 1;

		tabIndex++;
		out.println("<tr>") ; 
		StringBuffer sb2 = new StringBuffer() ;
		StringBuffer sb12 = new StringBuffer() ;
		StringBuffer sba2 = new StringBuffer() ;
		StringBuffer sbar2 = new StringBuffer();
        StringBuffer fieldVal2 = new StringBuffer("");
                    for(int i=0;i<contact_col_names.length; i++)
                            {
                                  String  val = contact_fields[i] ;
								  sb2.append(val);
                                   int j=0 ;
								   int j1 = 0;
                                   String old_val = "" ;
                                   String new_val = "" ;
                                     
                                     if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
                                     {
                                        old_val = "r_addr_line1" ;
                                        new_val = "addr_line_1" ;
										     
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
                                     {
                                        old_val = "r_addr_line2" ;
                                        new_val = "addr_line_2" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
                                     {
                                        old_val = "r_addr_line3" ;
                                        new_val = "addr_line_3" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
                                     {
                                        old_val = "r_addr_line4" ;
                                        new_val = "addr_line_4" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
                                     {
                                        old_val = "r_town_code" ;
                                        //new_val = "town" ;
										new_val = "m_town_code" ;
									 }//Added by kumar on 13/03/2003 for region 
									 else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
                                     {
                                        old_val = "r_region_code" ;
                                        //new_val = "region" ;
										new_val = "m_region_code" ;
                                     }
									 else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
                                     {
                                        old_val = "r_area_code" ;
                                        //new_val = "area" ;
										new_val = "m_area_code" ;
                                     }                                     
                                     else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
                                     {
                                        old_val = "r_postal_code" ;
										//new_val = "postal_code" ;
                                        new_val = "m_postal_code" ;
                                     }
									out.println("<td class='label'  >"+contact_prompts[i]+"</td>") ;	
                                    while(val.indexOf(old_val) != -1)
                                    {
                                        j = val.indexOf(old_val,j) ;
                                        sb2 = sb2.replace(j,(j+old_val.length()),new_val);
                                        val = sb2.toString();
                                    }
             // Newly added
			if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
				sba2.append(val);
				while(val.indexOf("r_postal_code") != -1) {
					j1 = val.indexOf("r_postal_code",j1) ;
					sba2 = sba2.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
					val = sba2.toString();
				}
			}
			if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
				j1 = 0;
				sbar2.append(val);
				while(val.indexOf("r_postal_code") != -1) {
					j1 = val.indexOf("r_postal_code",j1) ;
					sbar2 = sbar2.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
					val = sbar2.toString();
				}
			}
								   sb12.append(val);
									for(int z=0;z<val.length();z++)
									{
										String tempVal=sb12.substring(z,z+1);
										if(tempVal.equals("@"))
										{
											//fieldVal2.append(++tabIndex);
											fieldVal2.append("");
										}
										else
										{
											fieldVal2.append(tempVal);
										}
									}
                                    val = fieldVal2.toString();
								
                                    out.println("<td class='fields'>"+val) ;
									
						   out.println("</td>");
						 //  out.println("<td class='label'  colspan='2'>&nbsp;</td>");
						   out.println("</tr>") ;
						   sb12.delete(0,sb12.length());
						   fieldVal2.delete(0,fieldVal2.length());
						   sb2.delete(0,sb2.length());
						   sba2.delete(0,sba2.length());
						   sbar2.delete(0,sbar2.length());
                            } 
								




//end code




//int k=0;
/*int l=1;

for(int i=0;i<contact_col_names.length;i++) 
 {
// if( !( contact_col_names[i].equalsIgnoreCase("REGION_PROMPT") ||contact_col_names[i].equalsIgnoreCase("RES_AREA_PROMPT") || contact_col_names[i].equalsIgnoreCase("RES_TOWN_PROMPT")) )
  //{
   out.println("<tr><td class='LABEL' width='35%'>"+contact_prompts[i]+"</td>") ;
    for(int j=0; j<address_col_names.length; j++)
     {
	 if(address_col_names[j].equalsIgnoreCase(contact_col_names[i]))
	 {*/%>
		  
	 <%	  /*if(address_col_names[j].equalsIgnoreCase("REGION_PROMPT"))
		   {
			 out.println("<td class='fields' width='65%' ><input type='text' name='"+address1_fld_names[j]+"' id='"+address1_fld_names[j]+"' value=\""+ecis.utils.HTMLUtilities.getDisplayString(address_fld_values[j])+"\"	maxLength='30' size='30'  onBlur='searchCountry1(this,region)'  onKeyPress='return CheckForSpecChars(event)'><input type='button' name='reg_search' id='reg_search' class='BUTTON'  id='rgnsrh' value='?'   onClick=searchCountry(this,region) ></td>") ;  			
		   }else if(address_col_names[j].equalsIgnoreCase("RES_AREA_PROMPT"))
		   {
			 out.println("<td class='fields' width='65%' ><input type='text' name='"+address1_fld_names[j]+"' id='"+address1_fld_names[j]+"' value=\""+ecis.utils.HTMLUtilities.getDisplayString(address_fld_values[j])+"\"	maxLength='30' size='30' onBlur='searchCountry1(this,area)'  onKeyPress='return CheckForSpecChars(event)'><input type='button' name='areasrch' id='areasrch' class='BUTTON'  id='areasrch' value='?'   onClick=searchCountry(this,area) ></td>") ;  			
		   }else if(address_col_names[j].equalsIgnoreCase("RES_TOWN_PROMPT"))
		   {
			 out.println("<td class='fields' width='65%' ><input type='text' name='"+address1_fld_names[j]+"' id='"+address1_fld_names[j]+"'value=\""+ecis.utils.HTMLUtilities.getDisplayString(address_fld_values[j])+"\" maxLength='30' size='30'  onBlur='searchCountry1(this,town)' onKeyPress='return CheckForSpecChars(event)'><input type='button' name='twnsearch' id='twnsearch' class='BUTTON'  id='twnsrch' value='?'   onClick=searchCountry(this,town) ></td>") ;  			
		   }else 	
	       if(address_col_names[j].equalsIgnoreCase("POSTAL_CODE_PROMPT"))
		   {
			 out.println("<td class='fields' width='65%' ><input type='text' name='"+address1_fld_names[j]+"' id='"+address1_fld_names[j]+"' value='"+ecis.utils.HTMLUtilities.getDisplayString(address_fld_values[j])+"'	maxLength='8' size='8'   onKeyPress='return CheckForSpecChars(event)'><input type='button' name='postal_search' id='postal_search' class='BUTTON'  id='pstsrh' value='?'   onClick='callPostalSearch("+address1_fld_names[j]+");' ></td>") ;  			
		   }
		   else
		   {
		         out.println("<td class='fields' width='65%' ><input type='text' name='"+address1_fld_names[j]+"' id='"+address1_fld_names[j]+"' value=\""+ecis.utils.HTMLUtilities.getDisplayString(address_fld_values[j])+"\"		maxLength='30' size='32'  onBlur='makeValidString(this)' > </td>") ; 
		   }
						
	}
				
   }   
			
   
   out.println("</tr>");
    l++;
   }*/

        //String sq3 = "select short_name from mp_country  where country_code = '"+country_code+"'";
		String sq3 = "select short_name from MP_COUNTRY_LANG_VW  where LANGUAGE_ID='"+localeName+"' and country_code = '"+country_code+"'";

		pstmt2  = con.prepareStatement(sq3);
        vrs = pstmt2.executeQuery();
        
		
		while( vrs.next())
		{
			kcou=checkForNull(vrs.getString("short_name"));
		
	//	}     


}%>			       
      	    <tr>
		  <td  class='label'><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
         <td class='fields' ><input type='text' onBlur="searchCountry1(this,COUNTRY_DESC)" name='COUNTRY_DESC' id='COUNTRY_DESC' size='15' value="<%=kcou%>"  maxlength='15'  ><input type='button' name='cntrysrh'  value='?' id='cntrysrh' class='button' onclick="searchCountry(this,COUNTRY_DESC)" >	   </td>
          </tr>
          <tr>
              <td  class='label'><fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/></td>
              <td class='fields'><input type='text' name='TELEPHONE_RES' id='TELEPHONE_RES' maxlength='20' size='20'  onblur=''    value ="<%=telephone_res%>"></td>
		  </tr>
          <tr>
              <td  class='label' ><fmt:message key="eMO.MobilePhoneNo.label" bundle="${mo_labels}"/></td>
              <td class='fields'><input type='text' name='MOB_TEL_NO' id='MOB_TEL_NO' maxlength='20' size='20'  onblur='' value ="<%=mob_tel_no%>"></td>
		  <tr>
			  <td  class='label'><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td>
              <td class='fields'><input type='text' name='TELEPHONE_OFF' id='TELEPHONE_OFF' maxlength='20' size='20'  onblur=''  value ="<%=telephone_off%>"></td>
          </tr>
		  <tr>
		      <td class='label'><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>
              <td class='fields'><input type='text' name='EMAIL_ID' id='EMAIL_ID'  onBlur='document.getElementById('tab2').scrollIntoView();document.getElementById("CLAIMANT_TYPE").focus()'maxlength='50' size='30'     value = "<%=email_id%>"></td>
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
<input type='hidden' name='pid' id='pid' value='<%=pid%>'>
<input type='hidden' name='SiteApplicaple' id='SiteApplicaple' value='<%=iSSiteApplicable%>'>

<!--Added by Ashwini on 02-Aug-2017 for ML-MMOH-CRF-0743-->
<input type='hidden' name='isClaimantChngsApplicable' id='isClaimantChngsApplicable' value ='<%=isClaimantChngsApplicable%>'>

<INPUT TYPE="hidden" name="town_code" id="town_code">
<INPUT TYPE="hidden" name="area_code" id="area_code">
<INPUT TYPE="hidden" name="region_code" id="region_code">
<INPUT TYPE="hidden" name="postal_code" id="postal_code"> 

<!--Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095-->
<input type='hidden' name='function_id' id='function_id' value ='<%=function_id%>'> 
<input type='hidden' name='claimant_type_mstr' id='claimant_type_mstr' value='<%=claimant_type%>'>

<!--Added by Santhosh for ML-MMOH-CRF-1948-->
<input type='hidden' name='datetime_claim_mand' id='datetime_claim_mand' value='<%=datetime_claim_mand%>'>
<!--END-->
          
</form>
<script>
	
	if (document.forms[0].addr_line_1 != null){
		document.forms[0].addr_line_1.value = '<%=addrl1%>';
	}
	if (document.forms[0].addr_line_2 != null){
		document.forms[0].addr_line_2.value = '<%=addrl2%>';
	}
	if (document.forms[0].addr_line_3 != null){
		document.forms[0].addr_line_3.value = '<%=addrl3%>';
	}
	if (document.forms[0].addr_line_4 != null){
		document.forms[0].addr_line_4.value = '<%=addrl4%>';
	}
	if (document.forms[0].m_area_code != null){
		document.forms[0].m_area_code.value =  '<%=res_area_desc%>';
	}
	if (document.forms[0].m_town_code !=  null){
		document.forms[0].m_town_code.value =  '<%=res_town_desc%>';
	}

	if (document.forms[0].m_region_code != null){
		document.forms[0].m_region_code.value =  '<%=region_desc%>';
	}

	if (document.forms[0].m_postal_code1 != null){
		document.forms[0].m_postal_code1.value =  '<%=postal_code%>';
	}
</script>
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
<script>
	
/* Below line was added this CRF Bru-HIMS-CRF-366 [IN:039612]  */

 function maxLength(field,maxChars)
 {
       //if(field.value.length >= maxChars) {
	   if(field.value.length > maxChars) {
	      alert(getMessage("EXCEED_MAX_LENGTH", "Sm",null));
           // event.returnValue=false;	
              field.select();
              field.focus();		  
          return false;
       }
	   else{
	     return true;
	   }
 }  

 function maxLengthPaste(field,maxChars)
 {
       event.returnValue=false;
       if((field.value.length +  window.clipboardData.getData("Text").length) > maxChars) {	 
	     var errors1 = getMessage('REASON_EXCEED_MAX_LEN','MO');
		   alert(errors1);         	  
         return false;
       }
       event.returnValue=true;
 }
	/*Bru-HIMS-CRF-366 [IN:039612] */
	</script>

