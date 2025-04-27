<!DOCTYPE html>

<%@ page import="java.sql.*, java.util.*,java.lang.Math.*, java.text.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,com.ehis.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>   
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
  <script language='javascript' src='../../eCommon/js/dchk.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
  <script language='javascript' src='../../eAE/js/AESecondaryTriage.js'></script>
  <script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
 <script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
 <script> 
  <%! 
  public String specialCharacter(String single){
				int i=0;
				
				
		if(( single.indexOf('\'', i)!=-1)){
			single=(String)single.replace('\'',' ');
		}
	

		return single ; 
			
			}	

%>
function agecheck(obj,ca_install,patage,max,min,sex)
{	
	if(ca_install=="Y")
	{
		if(obj.name=="circumference")
		{
			if((trimCheck(min) <= patage) && sex =="F")
			{
			}else
			{
			   AEScrollIntoView();
			}
		}else{
		if(patage <= max)
		{
		}else if((trimCheck(min) <= patage) && sex =="F")
		{
		}else
		{
			AEScrollIntoView();
		}
	  }
	}
}

  function tab_click(objName)
	{
		   if(objName=="Triage_tab")
			{
				document.getElementById("tab1").scrollIntoView();
			}
			if(objName=="assess_tab")
			{
				document.getElementById("tabCA").scrollIntoView();
				showCAChart();
			}
	}

	function tab_click1(id) 
		{
			selectTab(id);
			tab_click(id);
		}

		function tab_click2(id,idval){
				selectTab(idval);
				tab_click22(idval);
		} 

		function tab_click22(Object)
		{
			if(Object=='patCond_tab')
			{
				 document.getElementById("tab1").scrollIntoView();
			}
			if(Object=='others_tab')
			{
				   document.getElementById("sub2").scrollIntoView();
			}
		}

</script>
</head>
<%
Connection con				      = null;  
PreparedStatement pstmt		      = null;
PreparedStatement pstmt2		      = null;
ResultSet rs2				      = null ;
ResultSet rset				      = null;
PreparedStatement pstmt1	      = null;
ResultSet rset1				      = null;
PreparedStatement pstmt_date	  = null;
ResultSet rs_date			      = null;
PreparedStatement pstmtEncounter  = null; 
ResultSet rsetEncounter			  = null;
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale			= (String)session.getAttribute("LOCALE");

String bed_no = "";
/** for Other Details Tab Added on 04/02/2005 **/
String ca_install_yn = "";
String ECGProp			="";
String FBCProp		    ="";
String DressProp        ="";
String SpO2Prop 		="";
String capBloodSugProp  ="";
String order_catalog_code1  ="";
String order_catalog_code2  ="";
String order_catalog_code3  ="";
String order_catalog_code4  ="";
String order_catalog_code5  ="";

    /* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
	  String sql              ="";
      String color            ="";	 
	  String green            ="";
	  String red              ="";
      String yellow           ="";
     String unassigned        ="";
 	/* CRF  SKR-CRF-0021 [IN028173] end  */
	  
int countECG =0;
int countDerss=0;
int countSpO2=0;
int countCapBlood=0;
String facilityId			= (String)session.getValue("facility_id");
String loginUser			= checkForNull((String)session.getValue("login_user"));
String patient_id			= request.getParameter("patient_id");
// for Frame reference changes
String called_from_ca = request.getParameter("called_from_ca");
if((called_from_ca==null) || (called_from_ca.equals("null")) || (called_from_ca=="") || (called_from_ca.equals("")))
	called_from_ca= "N";
String query_string = checkForNull(request.getParameter("query_string"));
String params		 = request.getQueryString() ;

StringBuffer sbBuff = null;
sbBuff = new StringBuffer();
String clinic_code			= checkForNull(request.getParameter("clinic_code"));

String priority			    = checkForNull(request.getParameter("priority_zone"));
String brought_dead			=  checkForNull(request.getParameter("brought_dead"));
String rec_date_time		= checkForNull(request.getParameter("rec_date_time"));
String modify_flag			= request.getParameter("modify_flag")==null?"N":request.getParameter("modify_flag"); 
String encounter_id			= checkForNull(request.getParameter("encounter_id"));
String sys_date_time        = checkForNull(request.getParameter("sys_date_time"));
String treat_code			= checkForNull(request.getParameter("treatment_area_code"));
String patient_gender       = checkForNull(request.getParameter("patient_gender"));
String practitioner_id      = checkForNull(request.getParameter("practitioner_id"));

String function_id = checkForNull(request.getParameter("function_id"));



String heightDesc				= "";
String weightDesc				= "";
String circumDesc				= "";
String sex						= "";
String date_of_birth			= "";
String menstrual_status			= "false";
String pediatric_status			= "false";
String disabled					= "disabled";
String visit_date				= "";
String priorityStatus1			= "";
String priorityStatus2			= "";
String priorityStatus3			= "";
String priority_no				= "4";
String a_status				    = "";
String complaint_code           = "";
String complaint                = "";
String disaster_yn				= "";
String medical_yn               = "";
String surgical_yn				= "";
String checkedSur               = "";
String checkedMed               = "";
String mech_injr_code			= "";
String mech_injr_subcat_code	= "";
String checked1					= "";
String checked2					= "";
String checked3					= "";
String checked4					= "";
String checked5					= "";
String checked6					= "";
String checked7					= "";
String checked8					= "";
String checked9					= "";
String optSelected				= "";
String vehicle_invlovedcode		= "";
String vehicle_invlovedcode1	= "";
String protective_device_code	= "";
String pat_position_code		= "";
String oscc_yn					= "";
String mlc_yn					= "";
String police_rep_no			= "";
String police_station_dtls		= "";
String  immunization_status		= "";
String selected					= "";
String selected1				= "";
String selected2				= "";
String att_given				= "";
String dev_mile_stone			= "";
String imm_date					= "";
String circumference			= "";
String height					= "";
String weight					= "";
String  menarche_yn				= "";
String disaster_town_code		= "";
String lmp_date					= "";
String disPriority				= "";
String disTreatArea				= "";
String pregnant_yn				= "";
String disabled11				= "";
String mech_injury_subcatg_code	= "";
String disable3					= "";
String disabled111				= "";
String disabled12				= "";
String disabled13				= "";
String sqlDate					= "";
String disabled99				= "";
String disabled991				= "";
String disabledPre				= "";
String disMenarche				= "";
String disBed					= "";
String disBed1					= "";
String disDisaster				= "";
String pat_priority             = ""; 
String trauma_yn                = ""; 
String dis_area                 = "";
String dis1						= "";
String dis2						= "";
String dis3					    = "";
String dis5					    = "";
String dis6					    = "";
String dis7					    = "";
String dis8					    = "";
String dis9					    = "";
String dis10					= "";
String dis11				    = "";
String dis12				    = "";
String dis13				    = "";
String dis14				    = "";
String dis15				    = "";
String disHeight				= "";
String disWeight				= "";
String disCir				    = "";
String disImm					= "";
String triage_remarks           = "";
String disMed					= "";
String disSur					= "";
String disOscc					= "";
String disMLC					= "";
String optSelectedTreat			= "";
String immobilization			= "";
String disImmobil				= "";
String disaster_type_code       = "";
String sys_date                 = "";
String priority_code            = "";
String episode_id               = "";
String visit_num                = "";
String pat_dtls_unknown_yn      = "";
String referral_id				= "";
String disRefID                 = "";
String speciality_code          = "";
String date_time_of_accident    = "";
String place_of_accident        = "";
String disDateAcci				= "";
String disPlaceAcci				= "";
String enable_rights_yn="";
String sel_triage_yn="";
String sel_cons_yn="";



int  patient_age				= 0;
int min_age_pregnancy			= 0;
int nb_mother_min_age           = 0;
int min_age_pregnancy1			= 0;
int max_age_paediatric			= 0;
int	 tindex                     = 0;


try
 {
         con = ConnectionManager.getConnection(request);
         /**  CA Install Checking Added on 03/02/2005 **/
		 pstmt								= con.prepareStatement("select install_yn from sm_module where module_id='CA' ");
		 rset								= pstmt.executeQuery();
		 if(rset!=null  && rset.next())
		  {
						ca_install_yn		= rset.getString(1);
		  }
		  if(rset!=null) rset.close();
		  if(pstmt!=null) pstmt.close();
			String pract_type="";
			String en_acc_sql="select enable_accs_rights_in_queue  from ae_param where operating_facility_id = ?";
			pstmt=con.prepareStatement(en_acc_sql);
			pstmt.setString(1,facilityId);
			rset								= pstmt.executeQuery();
			if(rset!=null  && rset.next()){
			enable_rights_yn		= rset.getString("enable_accs_rights_in_queue")==null?"":rset.getString("enable_accs_rights_in_queue");
			}
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
			if(enable_rights_yn.equals("Y")){
			String pract_sql="select  b.pract_type pract_type from sm_appl_user a,am_practitioner b where a.appl_user_id = ? and a.func_role_id = b.practitioner_id"; 
			pstmt=con.prepareStatement(pract_sql);
			pstmt.setString(1,loginUser);
			rset								= pstmt.executeQuery();
			if(rset!=null  && rset.next()){
			pract_type =rset.getString("pract_type")==null?"":rset.getString("pract_type");
			}
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();

			if(!(pract_type.equals(""))){
			String access_rights_sql="select SEC_TRIAG_YN,CONS_YN from AE_ACCS_RIGHTS_BY_PRAC_TYPE where pract_type =?";
			pstmt=con.prepareStatement(access_rights_sql);
			pstmt.setString	(1,pract_type);
			rset = pstmt.executeQuery();
			if(rset!= null &&  rset.next() ){
				sel_triage_yn=rset.getString("SEC_TRIAG_YN")==null?"":rset.getString("SEC_TRIAG_YN");
				sel_cons_yn=rset.getString("CONS_YN")==null?"":rset.getString("CONS_YN");
			}
			if(rset!=null) rset.close();
			if(pstmt!=null)pstmt.close();
			}
			}

		  	StringBuffer  qryPatTriageDetails1 = new StringBuffer();
			qryPatTriageDetails1.append("SELECT SPECIALITY_CODE,ae_bed_no bed_no from ae_current_patient where facility_id = ? AND encounter_id=? " );

            pstmt2		=	con.prepareStatement(qryPatTriageDetails1.toString());

            pstmt2.setString	(	1,	facilityId		);
			pstmt2.setString	(	2,	encounter_id	);
			rs2			=	pstmt2.executeQuery();
			if(rs2.next())
				{
				speciality_code 		=	(rs2.getString("SPECIALITY_CODE")==null)		?	""	: rs2.getString("SPECIALITY_CODE");
					if(called_from_ca .equals("Y"))
					{
						bed_no 		=	(rs2.getString("bed_no")==null)		?	""	: rs2.getString("bed_no");
					}
				}
				if(rs2 != null) rs2.close();
				if(pstmt2 != null)pstmt2.close();
				if((qryPatTriageDetails1 != null) && (qryPatTriageDetails1.length() > 0))
			    {
					qryPatTriageDetails1.delete(0,qryPatTriageDetails1.length());
			    }

 try
     { 
		StringBuffer PREncount = new StringBuffer();
		PREncount.append("select to_char(trunc(visit_adm_date_time),'dd/mm/yyyy'),to_char(sysdate,'dd/mm/yyyy hh24:mi') sys,to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') sys1,");
		PREncount.append("EPISODE_ID,OP_EPISODE_VISIT_NUM , ");
		PREncount.append(" to_char(sysdate,'dd/mm/yyyy')  sqlDate,REFERRAL_ID,MLC_YN, ");
		PREncount.append(" to_char(DATE_TIME_OF_ACCIDENT,'dd/mm/yyyy hh24:mi') date_time_of_accident,");
		PREncount.append(" PLACE_OF_ACCIDENT ");
		PREncount.append(" from  PR_ENCOUNTER where ENCOUNTER_ID=? and FACILITY_ID=? ");
		pstmt_date = con.prepareStatement(PREncount.toString());
		pstmt_date.setString	(1,	encounter_id);
		pstmt_date.setString	(2,	facilityId);

		rs_date = pstmt_date.executeQuery();

		if (rs_date!=null)
		{
			while(rs_date.next())
			{
				visit_date               = rs_date.getString(1);	
				sys_date                 = rs_date.getString("sys");
				sys_date_time            = rs_date.getString("sys1");
				episode_id               = rs_date.getString("EPISODE_ID");
                visit_num                = rs_date.getString("OP_EPISODE_VISIT_NUM");
				sqlDate                  = rs_date.getString("sqlDate");
				referral_id              = checkForNull(rs_date.getString("REFERRAL_ID"));
				mlc_yn			         = checkForNull(rs_date.getString("MLC_YN"));
				date_time_of_accident    = checkForNull(rs_date.getString("date_time_of_accident"));
                place_of_accident        = checkForNull(rs_date.getString("place_of_accident"));
			}
		}
	    if(!a_status.equals("")) dis1 = disabled;	
		if (rs_date != null)   rs_date.close();
		if (pstmt_date != null) pstmt_date.close();
		if((PREncount != null) && (PREncount.length() > 0))
		{
			PREncount.delete(0,PREncount.length());
		}
		if (referral_id.equals(""))
				 disRefID ="";
		else
				 disRefID="disabled";

     }
     catch(Exception e) { e.printStackTrace() ;}
  try{
        StringBuffer  emerdetails = new StringBuffer();
		emerdetails.append("select COMPLAINT_CODE, ");
		emerdetails.append("MECH_INJURY_CATG_CODE,MECH_INJURY_SUBCATG_CODE,");
		emerdetails.append(" VEHICLE_INVOLVED1_CODE,VEHICLE_INVOLVED2_CODE, ");
		emerdetails.append(" PROTECTIVE_DEVICE_CODE,PAT_POSITION_CODE, ");
		emerdetails.append(" OSCC_YN,");
		emerdetails.append(" IMMUNIZATION_STATUS,ATT_GIVEN_YN,DEVP_MILESTONE_AGE_YN,");
		emerdetails.append(" IM_UPTO_DATE_YN,MENARCHE_YN,HEIGHT,WEIGHT,");
		emerdetails.append(" CIRCUMFERENCE, ");
		emerdetails.append(" to_char(LMP_DATE,'dd/mm/yyyy') LMP_DATE,PREGNANT_YN,");
		emerdetails.append(" MECH_INJURY_SUBCATG_CODE,PAT_PRIORITY,TRAUMA_YN,");
		emerdetails.append(" REMARKS,MEDICAL_YN,SURGICAL_YN,IMMOBILIZATION_CODE,"); emerdetails.append(" POL_STN_ID,POL_REP_NO,DISASTER_YN,DISASTER_TOWN_CODE,");
		emerdetails.append(" to_char(DATE_TIME_OF_ACCIDENT,'dd/mm/yyyy hh24:mi') DATE_TIME_OF_ACCIDENT,");
		emerdetails.append(" PLACE_OF_ACCIDENT, ");
		emerdetails.append(" DISASTER_TYPE_CODE,AMBULATORY_STATUS from ");
		emerdetails.append(" AE_PAT_EMERGENCY_DETAIL where ENCOUNTER_ID= ? AND ");
		emerdetails.append(" FACILITY_ID=? and ");
		emerdetails.append(" to_char(RECORDED_DATE,'dd/mm/yyyy hh24:mi:ss')=? " );  
   
        StringBuffer  sqltreatment1 = new StringBuffer();
		sqltreatment1.append("select TREATMENT_AREA_CODE ,PRIORITY_ZONE,BED_NO, PAT_PRIORITY from ");
		sqltreatment1.append(" ae_pat_emergency_detail where ENCOUNTER_ID =? and  ");
		sqltreatment1.append(" FACILITY_ID=? and recorded_date=to_date(?,'dd/mm/yyyy hh24:mi:ss')");

		StringBuffer  sqltreatment2 = new StringBuffer();
		sqltreatment2.append("select TREATMENT_AREA_CODE ,PRIORITY_ZONE,AE_BED_NO, PAT_PRIORITY from ");
		sqltreatment2.append(" op_patient_queue where ENCOUNTER_ID =? and  ");
		sqltreatment2.append(" FACILITY_ID=? ");
        
		StringBuffer  sqlaeage = new StringBuffer();
		sqlaeage.append("select MIN_AGE_FOR_PREG_DTL, MAX_AGE_FOR_PAED_DTL,ORDER_CATALOG_CODE3 ");
		sqlaeage.append(" from ae_param where OPERATING_FACILITY_ID= ? ");

		StringBuffer sqlUnit = new StringBuffer();
		sqlUnit.append(" select UNIT_OF_LENGTH_NB,UNIT_OF_WT_NB,");
		sqlUnit.append(" UNIT_OF_CIRCUM_NB,NB_MOTHER_CUTOFF_AGE from MP_PARAM ");
     
	    StringBuffer  sqlAge = new StringBuffer();
		sqlAge.append("select Calculate_Age(TO_CHAR(date_of_birth, ");
		sqlAge.append(" 'dd/mm/yyyy'),1), sex,to_char(DATE_OF_BIRTH,'dd/mm/yyyy') ");
		sqlAge.append("date_of_birth,pat_dtls_unknown_yn from mp_patient where patient_id = ?  ");
 
        StringBuffer sqlAmbulatory = new StringBuffer();
		sqlAmbulatory.append(" select AMBULATORY_STATUS,SHORT_DESC from ");
		sqlAmbulatory.append(" AM_AMBULATORY_STATUS_LANG_VW  where ");      
		sqlAmbulatory.append(" language_id='"+locale+"'  and EFF_STATUS='E' and ");
		sqlAmbulatory.append(" nvl(eff_date_from,sysdate) >= sysdate ");
		sqlAmbulatory.append(" and nvl(eff_date_to,sysdate) <= sysdate ");
		sqlAmbulatory.append(" order by SHORT_DESC ");


	    StringBuffer sqlComplaint = new StringBuffer();
		sqlComplaint.append("select COMPLAINT_CODE,COMPLAINT_DESC from AM_COMPLAINT_LANG_VW  where language_id='"+locale+"' and EFF_STATUS='E' order by COMPLAINT_DESC ");

		StringBuffer  sqlPosition = new StringBuffer();
		sqlPosition.append("select PAT_POSITION_CODE,SHORT_DESC from AE_PAT_POSITION_LANG_VW  where language_id='"+locale+"' and EFF_STATUS='E' order by SHORT_DESC");

		

                       pstmt = con.prepareStatement(sqlUnit.toString());
				       rset = pstmt.executeQuery();
					   while(rset!=null && rset.next())
					   {
                             heightDesc = rset.getString("UNIT_OF_LENGTH_NB");
							 weightDesc = rset.getString("UNIT_OF_WT_NB");
							 circumDesc = rset.getString("UNIT_OF_CIRCUM_NB");
							 nb_mother_min_age = rset.getInt("NB_MOTHER_CUTOFF_AGE");
					   } 
					  
					   pstmt1 = con.prepareStatement(sqlAge.toString());
					   pstmt1.setString	(1,	patient_id);

					   rset1 = pstmt1.executeQuery();
					   while(rset1!=null && rset1.next())
					   {
                             patient_age = rset1.getInt(1);
							 sex	=  rset1.getString(2)==null?"":rset1.getString(2);
							 date_of_birth = rset1.getString("date_of_birth");
							 pat_dtls_unknown_yn = rset1.getString("pat_dtls_unknown_yn");

					   } 
					   if(rset1!=null) rset1.close();
					   if(pstmt1!=null) pstmt1.close();
                        if((sqlAge != null) && (sqlAge.length() > 0))
					    {
							sqlAge.delete(0,sqlAge.length());
					    }
   					   if(rset!=null) rset.close();
					   if(pstmt!=null) pstmt.close();
                       if((sqlUnit != null) && (sqlUnit.length() > 0))
					   {
							sqlUnit.delete(0,sqlUnit.length());
					   }
					   if(heightDesc!=null && heightDesc.equalsIgnoreCase("C"))
							heightDesc = "CM";
					   else if(heightDesc!=null && heightDesc.equalsIgnoreCase("I"))
							heightDesc = "Inch";
					   if(weightDesc!=null && weightDesc.equalsIgnoreCase("K"))
							weightDesc = "KG";
					   else if(weightDesc!=null && weightDesc.equalsIgnoreCase("L"))
							weightDesc = "LB";
					   if(circumDesc!=null && circumDesc.equalsIgnoreCase("C"))
							circumDesc = "CM";
					   else if(circumDesc!=null && circumDesc.equalsIgnoreCase("I"))
							circumDesc = "Inch";	
						
                       pstmt = con.prepareStatement(sqlaeage.toString());
					   pstmt.setString(1,facilityId);

				       rset = pstmt.executeQuery();
					   while(rset!=null && rset.next())
					   {
                             min_age_pregnancy1 = rset.getInt(1);
							 max_age_paediatric = rset.getInt(2);
                             order_catalog_code3  = checkForNull(rset.getString("order_catalog_code3"));

					   } 

                        if(nb_mother_min_age>0) 
							 min_age_pregnancy=nb_mother_min_age;
                              
						else
                             min_age_pregnancy=min_age_pregnancy1;
					  
					  if(rset!=null) rset.close();
					  if(pstmt!=null) pstmt.close();
					  if((sqlaeage != null) && (sqlaeage.length() > 0))
					  {
							sqlaeage.delete(0,sqlaeage.length());
					  }
					  if(modify_flag.equals("Y"))
					  {
					  try
					  {
						   
					   pstmt1 = con.prepareStatement(emerdetails.toString());
					   pstmt1.setString	(1,	encounter_id);
					   pstmt1.setString	(2,	facilityId);
					   pstmt1.setString	(3,	rec_date_time);
					   

					   rset1 = pstmt1.executeQuery();
					   while(rset1!=null && rset1.next())
					    {
						 complaint_code=checkForNull(rset1.getString("COMPLAINT_CODE"));

						 mech_injr_code=checkForNull(rset1.getString("MECH_INJURY_CATG_CODE"));
						 mech_injr_subcat_code=checkForNull(rset1.getString("MECH_INJURY_SUBCATG_CODE"));
						 vehicle_invlovedcode=checkForNull(rset1.getString("VEHICLE_INVOLVED1_CODE"));
						 vehicle_invlovedcode1=checkForNull(rset1.getString("VEHICLE_INVOLVED2_CODE"));
						 protective_device_code=checkForNull(rset1.getString("PROTECTIVE_DEVICE_CODE"));
						 pat_position_code=checkForNull(rset1.getString("PAT_POSITION_CODE"));
						 oscc_yn=checkForNull(rset1.getString("OSCC_YN"));
                         immunization_status=checkForNull(rset1.getString("IMMUNIZATION_STATUS"));
						 att_given=checkForNull(rset1.getString("ATT_GIVEN_YN"));
						 dev_mile_stone=checkForNull(rset1.getString("DEVP_MILESTONE_AGE_YN"));
						 emerdetails.append(" IM_UPTO_DATE_YN,MENARCHE_YN,HEIGHT,WEIGHT,");
						 imm_date=checkForNull(rset1.getString("IM_UPTO_DATE_YN"));
						 menarche_yn=checkForNull(rset1.getString("MENARCHE_YN"));
						 height=checkForNull(rset1.getString("HEIGHT"));
						 weight=checkForNull(rset1.getString("WEIGHT"));
						 circumference=checkForNull(rset1.getString("CIRCUMFERENCE"));
        				 lmp_date=checkForNull(rset1.getString("LMP_DATE"));
						 pregnant_yn=checkForNull(rset1.getString("PREGNANT_YN"));
		    			 mech_injury_subcatg_code=checkForNull(rset1.getString("MECH_INJURY_SUBCATG_CODE"));
			             pat_priority       =checkForNull(rset1.getString("PAT_PRIORITY"));
						 trauma_yn          =checkForNull(rset1.getString("TRAUMA_YN"));
						 triage_remarks     =checkForNull(rset1.getString("REMARKS"));

						 surgical_yn        =checkForNull(rset1.getString("SURGICAL_YN"));
                         medical_yn         =checkForNull(rset1.getString("MEDICAL_YN"));
						 immobilization     =checkForNull(rset1.getString("IMMOBILIZATION_CODE"));
						 
						 police_rep_no      =checkForNull(rset1.getString("POL_REP_NO"));
						 police_station_dtls=checkForNull(rset1.getString("POL_STN_ID"));
						 disaster_yn        =checkForNull(rset1.getString("DISASTER_YN"));
					     disaster_town_code =checkForNull(rset1.getString("DISASTER_TOWN_CODE"));
						 disaster_type_code =checkForNull(rset1.getString("DISASTER_TYPE_CODE"));
						 a_status		    =checkForNull(rset1.getString("AMBULATORY_STATUS"));
						 date_time_of_accident    = checkForNull(rset1.getString("DATE_TIME_OF_ACCIDENT"));
                         place_of_accident        = checkForNull(rset1.getString("PLACE_OF_ACCIDENT"));


					 }
					 if(rset1!=null) rset1.close();
		             if(pstmt1!=null) pstmt1.close();
					 if((emerdetails != null) && (emerdetails.length() > 0))
					 {
						emerdetails.delete(0,emerdetails.length());
					 }
					 }catch(Exception e)
                     {
						e.printStackTrace() ;
                     }
                     dis1    = disabled;
					 dis3    = disabled;
                     disMed  = disabled;
                     disSur  = disabled;
					 dis2    = "readonly";
					 dis5    = disabled;
                     disOscc = disabled;
					 dis6    = disabled; 
					 dis7    = disabled;
					 dis8    = disabled;
					 dis9    = disabled;
					 dis10    = disabled;
					 dis11   = disabled;
                     disMLC  = disabled;
					 dis12   = disabled;
					 dis13   = disabled;
					 dis14   = disabled;
					 dis15   = disabled;
					 disabled991   = disabled;
					 disabled99    = disabled;
					 disImm = disabled;
					 disMenarche = disabled;
					 disHeight= disabled;
					 disWeight = disabled;
					 disCir = disabled;
					 disabledPre = disabled;
					 disabled111=disabled;
					 disabled13=disabled;
					 disabled12=disabled;
					 disPriority=disabled;
					 disTreatArea=disabled;
					 disBed=disabled;
					 disBed1=disabled;
					 disDisaster=disabled;
					 disabled11=disabled;
					 disImmobil=disabled;
					 disRefID =disabled;
					 FBCProp  ="disabled";
					 disDateAcci = disabled;
					 disPlaceAcci = disabled;

				   }else if(modify_flag.equals("N"))
	                {
					  StringBuffer sqlTiage1 = new StringBuffer();
                      sqlTiage1.append("select disaster_yn,disaster_town_code  from pr_encounter where encounter_id =?  and facility_id = ? ");
					  pstmt1 = con.prepareStatement(sqlTiage1.toString());
					  pstmt1.setString(1,encounter_id);
					  pstmt1.setString(2,facilityId);

					  rset1 = pstmt1.executeQuery();
					   while(rset1!=null && rset1.next())
					    {
						 disaster_yn=checkForNull(rset1.getString("disaster_yn"));
					     disaster_town_code=checkForNull(rset1.getString("disaster_town_code"));
                        }
						if(rset1!=null) rset1.close();
		                if(pstmt1!=null) pstmt1.close();
						if((sqlTiage1 != null) && (sqlTiage1.length() > 0))
						 {
							sqlTiage1.delete(0,sqlTiage1.length());
						 }
				    }
              if(medical_yn.equals("Y"))
			   {
		                  checkedMed="checked";
			   } 
              else
			   {
                     checkedMed="";
               }
			 if(surgical_yn.equals("Y"))
			   {
		                  checkedSur="checked";
			   } 
              else
			   {
                     checkedSur="";
               } 
			 if(disaster_yn.equals("Y"))
    		   {
		            checked1="checked";
			   }
               else
				   {
                          checked1="";
						  disabled11="disabled";
                   }
				 if(oscc_yn.equals("Y"))
	             {        
				 checked2="checked";
	  			  disable3="disabled";
	              }                       
			     else
	             {
					 checked2="";
	             }        
                if(mlc_yn.equals("Y"))
				  {		
		                 checked3="checked";
						// disable2="disabled";
                  }
				else
				  {
                          checked3="";
                  }

                if(immunization_status.equals("F"))
	             {
				          selected="selected" ;
						  dis14 = disabled;
	             }
                else if(immunization_status.equals("P"))
	            {
                          selected1="selected" ;
						  dis14 = disabled;
                }
                else if(immunization_status.equals("U"))
	            {
                         selected2="selected" ;
						 dis14 = disabled;
                } 

                if(att_given.equals("Y"))
	            {
				         checked4="checked" ;
						 dis15 = disabled;
                }
			    else
	            { 
                         checked4="" ;
                }
				if(dev_mile_stone.equals("Y"))
	             {
				          checked5="checked" ;
						  disabled99="disabled";
						  disabled991="disabled";

                 }
				else
	            {
                          checked5="" ;	
                }
				if(imm_date.equals("Y")){
				          checked6="checked" ;
						  disImm = disabled;
				}

				else{
                          checked6="" ;	
				}
				if(menarche_yn.equals("Y"))
				{	
				          checked7="checked" ;
						  checked8="checked";
						  disMenarche=disabled;
		        }
						  
			    else
				{
                          checked7="" ;	
						  checked8="" ;
				}
                if(sex.equalsIgnoreCase("M"))
	            {
					disMenarche=disabled;
				} 
			    if(pregnant_yn.equals("Y"))
	             {
				
				          checked8="checked" ;
						  disabledPre=disabled;
				
                 }
				  
			    else
	             {
                       checked8="" ;
                 }
              if(trauma_yn.equals("Y")){
				
				
				          checked9="checked" ;
						  dis5 = disabled;
			  }
			    else
	           {
                          checked9="" ;
               } 
		 if (!rec_date_time.equals(""))
	     {
             pstmt1 = con.prepareStatement(sqltreatment1.toString());
			 pstmt1.setString	(1,	encounter_id);
			 pstmt1.setString	(2,	facilityId);
			 pstmt1.setString	(3,	rec_date_time);

			 rset1 = pstmt1.executeQuery();
			 while(rset1!=null && rset1.next())
			 {
			  
			 treat_code = rset1.getString("TREATMENT_AREA_CODE")==null?"":rset1.getString("TREATMENT_AREA_CODE"); 
			 priority = rset1.getString("PRIORITY_ZONE")==null?"":rset1.getString("PRIORITY_ZONE"); 
			 bed_no= rset1.getString("BED_NO")==null?"":rset1.getString("BED_NO");
			 priority_code= rset1.getString("PAT_PRIORITY")==null?"":rset1.getString("PAT_PRIORITY");
			 }
			 if(rset1!=null) rset1.close();
			 if(pstmt1!=null) pstmt1.close();


		 }else{

				pstmt1 = con.prepareStatement(sqltreatment2.toString());
				pstmt1.setString	(1,	encounter_id);
				pstmt1.setString	(2,	facilityId);

				rset1 = pstmt1.executeQuery();
			    while(rset1!=null && rset1.next())
			    {
			  
				 treat_code = rset1.getString("TREATMENT_AREA_CODE")==null?"":rset1.getString("TREATMENT_AREA_CODE"); 
				 priority = rset1.getString("PRIORITY_ZONE")==null?"":rset1.getString("PRIORITY_ZONE"); 
				 bed_no= rset1.getString("AE_BED_NO")==null?"":rset1.getString("AE_BED_NO");
				 priority_code= rset1.getString("PAT_PRIORITY")==null?"":rset1.getString("PAT_PRIORITY");
				}
						 if(rset1!=null) rset1.close();
						 if(pstmt1!=null) pstmt1.close();
			   }
						 if (priority.equals("R")) priorityStatus1="checked";
		                 else if (priority.equals("Y")) priorityStatus2="checked";
		                 else if (priority.equals("G")) priorityStatus3="checked";
		                 if (priority.equals("R")) priority_no="1";
		                 else if (priority.equals("Y")) priority_no="3";
		                 else if (priority.equals("G")) priority_no="2";
						 else if (priority.equals("U")) priority_no="4";

                          if (priority.equals("R"))
						  {  
							  priorityStatus1="checked";
						      disabled12="disabled";
						      disabled13="disabled";
								   
						  }
		                  else if (priority.equals("Y"))
						  {

							  priorityStatus2="checked";
						      disabled111="disabled";
						      disabled13="disabled";
						  }
		                  else if (priority.equals("G"))
						  {

							  priorityStatus3="checked";
						      disabled111="disabled";
						      disabled12="disabled";
						  }
	  StringBuffer sqlarea = new StringBuffer();
	  sqlarea.append("select LONG_DESC from mp_res_town_lang_vw where  language_id='"+locale+"'  and res_town_code=?");

	  pstmt1 = con.prepareStatement(sqlarea.toString());
      pstmt1.setString(1,disaster_town_code);
	   
	  rset1 = pstmt1.executeQuery();
		 while(rset1!=null && rset1.next())
		 {
		 dis_area = rset1.getString("LONG_DESC");
		 }
		 if(rset1!=null) rset1.close();
		 if(pstmt1!=null) pstmt1.close();
		 if((sqlarea != null) && (sqlarea.length() > 0))
		 {
			sqlarea.delete(0,sqlarea.length());
		 }
     /**  If CA Installed New Tab Other Details Added on 03/02/2005 **/ 
	 
	           /* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
	 
	          
	           sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E'";
				
			    pstmt   = con.prepareStatement(sql.toString());
				pstmt.setString(1,locale) ;
			    rs2    = pstmt.executeQuery();
				while(rs2!=null && rs2.next())
				{
				  color      =rs2.getString("PRIORITY_ZONE");
				 if (color.equals("G")) {green=rs2.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("R")) {red=rs2.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("Y")) {yellow=rs2.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("U")) {unassigned=rs2.getString("PRIORITY_ZONE_DESC");}
				  
				}
		    
			
			
			if(rs2!=null) rs2.close();
		   if(pstmt!=null) pstmt.close();
	
	/* CRF  SKR-CRF-0021 [IN028173] end  */
	 
%>

 <body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad='clearBed();'> 
 <form name='AESecondaryTriage_form' id='AESecondaryTriage_form' action='../../servlet/eAE.AESecondaryTriageServlet' method='post' target='messageFrame' >

 <%
if(!function_id.equals("query"))
{
%>
  <a name="tab1" ></a> 
	 <table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
            <tr><td class='white'>

		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Triage Details">
				<a onclick="tab_click1('Triage_tab')" class="tabClicked" id='Triage_tab' >
					<span class="tabSpanclicked" id="Triage_tabspan"><fmt:message key="Common.TriageDetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<%if(ca_install_yn.equals("Y")){%>
			<li class="tablistitem" title="Assessment">
				<a onclick="tab_click1('assess_tab')" class="tabA" id="assess_tab" >
					<span class="tabAspan" id="assess_tabspan"><fmt:message key="Common.Assessment.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<%}%> 
		</ul>
    </td></tr>
    </table>
	<table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
      <tr><td class='white'>
			<ul id="tablist" class="tablist">
				<li class="tablistitem" title="Condition / Case">
					<a onclick="tab_click2('sub1','patCond_tab')" class="tabClicked" id="patCond_tab" >
						<span class="tabSpanclicked" id="patCond_tabspan"><fmt:message key="eAE.ConditionCase.label" bundle="${ae_labels}"/></span>
					</a>
				</li>
				<li class="tablistitem" title="Others">
					<a onclick="tab_click2('sub2','others_tab')" class="tabA" id="others_tab" >
						<span class="tabAspan" id="others_tabspan"><fmt:message key="Common.others.label" bundle="${common_labels}"/></span>
					</a>
				</li>
			</ul>
       </td></tr>
</table>

<table border="0" cellpadding="2" cellspacing="0" align='center' width='100%'>
      <input type='hidden' name='sysdate' id='sysdate' value='<%=sqlDate%>'>
	  <tr>
		<td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.PatientCondition.label" bundle="${common_labels}"/></td>
	  </tr>
     <tr><input type="hidden" name='hddpriority' id='hddpriority'value=<%=priority%>>
              <td class='label' width='25%' ><fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/></td>
			  
               <!-- below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] -->
	          <td class='label'   width='25%' tabindex='<%=++tindex%>'><%=red%>
					<input type="checkbox" name='priorityR' id='priorityR'   onClick='setPriority(this);setTreatment(this);' <%=priorityStatus1%> <%=disabled111%> ><%=yellow%>
			 		<input type="checkbox" name='priorityY' id='priorityY'    onClick='setPriority(this);setTreatment(this);' <%=priorityStatus2%> <%=disabled12%>><%=green%>
			 		<input type="checkbox" name='priorityG' id='priorityG' <%=priorityStatus3%> onClick='setPriority(this);setTreatment(this);'<%=disabled13%>>
	          </td>
			  <!--CRF  SKR-CRF-0021 [IN028173] end-->
			  <td class='label' width='25%' ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			  <td class='fields' width='25%' ><select name='priority11' id='priority11' tabindex='65' <%=disPriority%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
                  <%
					   
                       StringBuffer sqlpriority = new StringBuffer();
					   sqlpriority.append("select PRIORITY_CODE,SHORT_DESC from ");
					   sqlpriority.append("ae_pat_priority_lang_vw where language_id='"+locale+"'  and PRIORITY_NO=? and EFF_STATUS='E'");
	                     				
						 pstmt = con.prepareStatement(sqlpriority.toString());
						 pstmt.setString(1,priority_no);
					     rset = pstmt.executeQuery();
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(priority_code))
							   {
                                    optSelected="selected";
							   }
							   else
								   optSelected="";

							   out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
							  
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
						 if((sqlpriority != null) && (sqlpriority.length() > 0))
						 {
							sqlpriority.delete(0,sqlpriority.length());
						 }
					   %>  
					</select>
		  </td>
		</tr> 
		<tr> 
			  <td class='LABEL'  width='25%' ><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
			  <td class='fields' width='25%' tabindex='<%=++tindex%>'>
			   <%
				 StringBuffer sqlTreatA = new StringBuffer();
				 sqlTreatA.append("SELECT treatment_area_code, short_desc FROM ae_tmt_area_for_clinic_lang_vw WHERE language_id='"+locale+"'  and facility_id = ? AND clinic_code = ?  AND priority_zone = ?  AND  (gender = ? OR gender IS NULL) ");
				 pstmt = con.prepareStatement(sqlTreatA.toString());
				 pstmt.setString(1,facilityId);
				 pstmt.setString(2,clinic_code);
				 pstmt.setString(3,priority);
				 pstmt.setString(4,patient_gender);

				 rset = pstmt.executeQuery();
				 while(rset!=null && rset.next())
				   {
					 String code =rset.getString(1);
					 String desc =specialCharacter(rset.getString(2));
					 if (code.equals("null") || code==null) 
						 code="";
					  if (desc.equals("null") || desc==null) 
						 desc="";
					  if(code.equals(treat_code))
					   {
							optSelectedTreat="selected";
					   }
					   else
						   optSelectedTreat="";
			   
					   sbBuff.append("<option value=\""+code+"\" "+optSelectedTreat+">"+desc+"</option>");
				  }
				 if(pstmt!=null) pstmt.close();
				 if(rset!=null) rset.close();
				 if((sqlTreatA != null) && (sqlTreatA.length() > 0))
				 {
					sqlTreatA.delete(0,sqlTreatA.length());
				 }
			   %> 
			   <select name='treat_area' id='treat_area'  <%=disTreatArea%> onChange='clearBed();'>
				<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
				<%=sbBuff.toString()%>
			    </select>
			 </td>
				   <!-- onblur="ChangeUpperCase(this);checkForValidBed(this.value);" -->
			 <td class='label' width='25%'><fmt:message key="eAE.BedBayNo.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='text' name='bed_bay_no' id='bed_bay_no' size='8' maxlength='8' onblur="ChangeUpperCase(this);" onKeyPress="return(CheckForSpecChars(event))"  value ='<%=bed_no%>' <%=disBed%>><input type=button class=button value='?' name='bed_button' id='bed_button'  onClick="callBedAvailChart();" <%=disBed1%>>
             </td>
		  </tr>
          <tr> 
             <td class='label' ><fmt:message key="Common.Disaster.label" bundle="${common_labels}"/></td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type="checkbox" name='Disaster_YN' id='Disaster_YN'  onClick='setDisaster(this)'<%=checked1%> <%=disDisaster%>></td>
             <td class='label' colspan='2'>&nbsp;</td>
		  </tr> 
		  <tr>
			 <td class='label' width='25%'><fmt:message key="eAE.DisasterArea.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='text'  name="disaster_area1" id="disaster_area1" value="<%=dis_area%>" maxLength='10' onblur='if(this.value !="")searchDisasterArea(this,disaster_area1);'  <%=disabled11%>><input type='button' name='disaster' id='disaster' value='?' class='button'  tabindex='<%=++tindex%>' onclick='searchDisasterArea(this,disaster_area1);' <%=disabled11%> >
             </td>
		      <td class='LABEL' width='25%'><fmt:message key="eAE.DisasterType.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'>
				 <select name='disaster_type' id='disaster_type' tabindex='63' <%=disabled11%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
			<%  
                  try
				  {	
				   PreparedStatement pstmtTrans = null;
				   ResultSet rsetTrans = null;
				   optSelected="";
                   pstmtTrans = con.prepareStatement("select disaster_type_code, short_desc from ae_disaster_type_lang_vw  where language_id='"+locale+"'  and  eff_status='E' order by short_desc");
				
				   rsetTrans = pstmtTrans.executeQuery();
				   while(rsetTrans!=null && rsetTrans.next())
					{
					  if(rsetTrans.getString(1).equals(disaster_type_code))
							   {
                                    optSelected="selected";
							
							   }
							   else
							   {
								   optSelected="";
							      
							   }
					  out.println("<option value='"+rsetTrans.getString("disaster_type_code")+"' "+optSelected+" >"+rsetTrans.getString("short_desc")+""); 
					}
                  if(rsetTrans!=null) rsetTrans.close();
				  if(pstmtTrans!=null) pstmtTrans.close();
				  }catch(Exception e) {e.printStackTrace() ;}
	            %>
                 </select>
              </td>
           </tr>
	      <tr>
			 <input type='hidden' id='regndatetime' name="visit_date_time" id="visit_date_time"  value='<%=visit_date%>'>
			 <%if(modify_flag.equals("Y")) { %>
		      <td class='LABEL'  width='25%' ><fmt:message key="Common.ambulatorystatus.label" bundle="${common_labels}"/></td>
  		      <td class='fields' width='25%' tabindex='<%=++tindex%>'>
				 <select name='ambulatory_status' id='ambulatory_status' tabindex='63' <%=dis1%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
					   <%
						   pstmt = con.prepareStatement(sqlAmbulatory.toString());
					       rset = pstmt.executeQuery();
						   optSelected="";
						   while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(a_status))
							   {
                                    optSelected="selected";
							
							   }
							   else
							   {
								   optSelected="";
							      
							   }
							  
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
						   if((sqlAmbulatory != null) && (sqlAmbulatory.length() > 0))
							 {
								sqlAmbulatory.delete(0,sqlAmbulatory.length());
							 }

					   %>
                 </select>
              </td>
             <%
		     } if(modify_flag.equals("N")) {
		     %>
              <td class='LABEL'  width='25%' ><fmt:message key="Common.ambulatorystatus.label" bundle="${common_labels}"/></td>
  		      <td  class='fields' width='25%' tabindex='<%=++tindex%>'>
				 <select name='ambulatory_status' id='ambulatory_status' tabindex='63' >
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
					   <%
						   pstmt = con.prepareStatement(sqlAmbulatory.toString());
					       rset = pstmt.executeQuery();
						   optSelected="";
						   while(rset!=null && rset.next())
						   {
							  
                              out.println("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
						   if((sqlAmbulatory != null) && (sqlAmbulatory.length() > 0))
							 {
								sqlAmbulatory.delete(0,sqlAmbulatory.length());
							 }
					   %>
                 </select>
              </td>
			  <%}%>
              </td>
			  <td class='LABEL' width='25%' colspan='2'></td>

          </tr>
		  <tr> 
			  <td class='label'   width='25%'><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></td> 
			 <%if(pat_dtls_unknown_yn.equals("N")){%>
				  <td class='fields' width='25%' 
				  tabindex='<%=++tindex%>'><input type='text' name='referral_id' id='referral_id' value="<%=referral_id%>" maxlength='14' size='14'  onBlur='searchPatient(document.forms[0].referral_id);' <%=disRefID%>><input type='button' class='button' value='?' name='ref_id_search' id='ref_id_search'   onClick='getReferralID()' <%=disRefID%>></td>
			<%}else if(pat_dtls_unknown_yn.equals("Y")) {%>
				<td  class='fields' width='25%'><input type='text' name='referral_id' id='referral_id' value='' maxlength='14' size='14'  onBlur=''  align='left' disabled><input type='button' class='button' value='?' name='ref_id_search' id='ref_id_search' onClick='getReferralID()' disabled></td>
		   <%}%>
	     <input type='hidden' name='injury_3' id='injury_3' value=''>
		 <%
				if(!complaint_code.equals("")){
				  StringBuffer sqlComplaint1 = new StringBuffer();
	              sqlComplaint1.append("select COMPLAINT_DESC from AM_COMPLAINT_LANG_VW where  language_id='"+locale+"'  and COMPLAINT_CODE=?");

				  pstmt1 = con.prepareStatement(sqlComplaint1.toString());
				  pstmt1.setString(1,complaint_code);
				   
				  rset1 = pstmt1.executeQuery();
					 while(rset1!=null && rset1.next())
					 {
					 complaint = rset1.getString("COMPLAINT_DESC")==null?"":rset1.getString("COMPLAINT_DESC");
					 }
					 if(rset1!=null) rset1.close();
					 if(pstmt1!=null) pstmt1.close();
					 if((sqlComplaint1 != null) && (sqlComplaint1.length() > 0))
					 {
						sqlComplaint1.delete(0,sqlComplaint1.length());
					 }
				 }

			  %>
			  <td class='LABEL' width='25%' ><fmt:message key="Common.Complaint.label" bundle="${common_labels}"/></td>
			  <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='text'  name="complaint_desc" id="complaint_desc" value="<%=complaint%>" onblur='if(this.value !="")searchComplaintType(this,complaint_desc);' tabindex='65' <%=dis3%>><input type='button' name='Complainttype' id='Complainttype' value='?' class='button' onclick='searchComplaintType(this,complaint_desc);' <%=dis3%>><input type='hidden' name='complaint_code' id='complaint_code' value="<%=complaint_code%>">
          </td>	
		 </tr>
		 <tr> 
					<td class='LABEL' width='25%' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%' colspan='3' tabindex='<%=++tindex%>'><textarea name='triage_remarks' cols='50'   align='left'  onblur='makeValidString(this);checkMaxLen(this);' onkeypress='checkMaxLimit(this,250);' <%=dis2%>><%=triage_remarks%></textarea>
		  </td>
		  </tr>  

		 <tr>
					<td class='COLUMNHEADER' colspan='4' ><fmt:message key="eAE.CaseDetails.label" bundle="${ae_labels}"/></td>
		 </tr>
		 <tr>  
			        <td class='label' width='25%'><fmt:message key="Common.CaseofTrauma.label" bundle="${common_labels}"/></td>
			        <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='checkbox'   name="CaseofTrauma" id="CaseofTrauma"  onClick='checktrauma(this);setMechInj1(this);' <%=checked9%> <%=dis5%>>
					</td>	
					<td class='label' width='25%'><fmt:message key="Common.oscc.label" bundle="${common_labels}"/></td>
                    <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='checkbox'  name="oscc_yn" id="oscc_yn"   value='N' onClick='chkOsccValue(this);remVal(document.forms[0].mechan_injury);setMechInj();' <%=disOscc%> tabindex='' <%=checked2%>>
					<!-- <%=checked2%> <%=disable3%> --> </td>
         </tr>
		 <tr> 
					<td class='label'  width='25%'><fmt:message key="Common.medical.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='checkbox'  name="medical_yn" id="medical_yn"  onClick='chkMedicalValue(this);' <%=checkedMed%> <%=disMed%>></td>
					<td class='label'  width='25%' ><fmt:message key="Common.Surgical.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%' tabindex='<%=++tindex%>'> <input type='checkbox'  name="surgical_yn" id="surgical_yn"   value='' onClick='chkSurgValue(this);' <%=checkedSur%> <%=disSur%>> 
					</td>
		 </tr>
				<input type='hidden' name='patient_id' id='patient_id' value=<%=patient_id%>>
				<input type='hidden' name='called_from_ca' id='called_from_ca' value=<%=called_from_ca%>>
		 <tr>
	          <td class='label' width='25%'><fmt:message key="eAE.DateTimeOfAccident.label" bundle="${ae_labels}"/></td>
  		      <td class='fields' width='25%' tabindex='<%=++tindex%>'>
			  <input type='text'  id='accidentdatetime' name='date_time_accident' id='date_time_accident'   maxLength='16' size='16' tabindex=''
			  value="<%=DateUtils.convertDate(date_time_of_accident,"DMYHM","en",localeName)%>"  onBlur='doDate(this);' <%=disDateAcci%>><img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('accidentdatetime', null, 'hh:mm' );" style='cursor:pointer' <%=disDateAcci%> ></img></td>
			  <td class='label' width='25%'><fmt:message key="eAE.PlaceOfAccident.label" bundle="${ae_labels}"/></td>
			  <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='text' name="place_of_accident" id="place_of_accident"  maxLength='30' size='25'  tabindex='' value="<%=place_of_accident%>" <%=disPlaceAcci%>></td>
	     </tr>
	     <tr>	
		           <td class='LABEL' width='25%' ><fmt:message key="Common.MechanismofInjury.label" bundle="${common_labels}"/></td>
  		           <td class='fields' width='25%' colspan='2' tabindex='<%=++tindex%>'>
				   <select name='mechan_injury' id='mechan_injury' onChange='setInjury(this)' <%=dis6%>> 
				    <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
					   <%
					  if(modify_flag.equals("Y")) {
						 StringBuffer sqlMechaInjury = new StringBuffer();
						 sqlMechaInjury.append("SELECT INJ_CATEGORY_CODE,SHORT_DESC FROM AE_INJURY_CATEGORY_LANG_VW  WHERE language_id='"+locale+"'  and EFF_STATUS='E'   ORDER BY 2 ");  
						 pstmt = con.prepareStatement(sqlMechaInjury.toString());
					     rset = pstmt.executeQuery();
						 	 optSelected="";
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString("INJ_CATEGORY_CODE").equals(mech_injr_code))
							   {
                                    optSelected="selected";
															
							   }
							   else
								   optSelected="";

                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
						 if((sqlMechaInjury != null) && (sqlMechaInjury.length() > 0))
						 {
							sqlMechaInjury.delete(0,sqlMechaInjury.length());
						 }
					   }  %>  
                 </select><img src='../../eCommon/images/mandatory.gif' id='mand4' style="visibility:hidden" align='center'></img><b><font  class='label'><b></font>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.and.label" bundle="${common_labels}"/>
              </td>
  		      <input type='hidden' name='mech_sub_code' id='mech_sub_code' value=<%=mech_injury_subcatg_code%> >
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'>
				<select name='injury' id='injury' tabindex='68' <%=dis7%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
				</select><img src='../../eCommon/images/mandatory.gif' id='mand5' style="visibility:hidden" align='center'></img>
              </td> 
	  </tr>
	  <tr>	
		      <td class='LABEL' width='25%' ><fmt:message key="Common.VehiclesInvolved.label" bundle="${common_labels}"/></td>
  		      <td class='fields' width='25%' colspan='2' tabindex='<%=++tindex%>'>
				 <select name='vehicle_invol' id='vehicle_invol' <%=dis8%>>
				  <option value='' >--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
					   <%
						 StringBuffer sqlVehicleInv = new StringBuffer();
						 sqlVehicleInv.append("select ARRIVAL_CODE, SHORT_DESC ARRIVAL_SHORT_DESC from am_arrival_lang_vw where language_id='"+locale+"'  and EFF_STATUS='E' and facility_id='"+facilityId+"'  order by 2");
						 pstmt = con.prepareStatement(sqlVehicleInv.toString());
					     rset = pstmt.executeQuery();
						 optSelected="";
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(vehicle_invlovedcode))
							   {
                                    optSelected="selected";
															
							   }
							   else
								   optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
					   %>
                 </select><b><font  class='label'><b></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.and.label" bundle="${common_labels}"/>
              </b></td>
			  <td class='fields' width='25%' tabindex='<%=++tindex%>'>
				<select name='vehicle_invol1' id='vehicle_invol1' tabindex='68' <%=dis9%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
				<%
						 pstmt = con.prepareStatement(sqlVehicleInv.toString());
					     rset = pstmt.executeQuery();
						 optSelected="";
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(vehicle_invlovedcode1))
							   {
                                    optSelected="selected";
															
							   }
							   else
								   optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
						 if((sqlVehicleInv != null) && (sqlVehicleInv.length() > 0))
						 {
							sqlVehicleInv.delete(0,sqlVehicleInv.length());
						 }
					   %>
				</select>
              </td> 			   
	   </tr>
	   <tr>	
		      <td class='LABEL' width='25%' ><fmt:message key="Common.ProtectiveDeviceUsed.label" bundle="${common_labels}"/></td>
  		      <td class='fields' width='25%' tabindex='<%=++tindex%>'>
				 <select name='protective_device' id='protective_device' <%=dis10%>>
				   <option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
			   <%
			   StringBuffer sqlProtect = new StringBuffer();
			  // sqlProtect.append("SELECT PROTECTIVE_DEVICE_CODE, SHORT_DESC FROM  AE_PROTECTIVE_DEVICE_LANG_VW WHERE language_id='"+locale+"'  and EFF_STATUS ='E' ORDER BY 2"); //common-icn-0180
			   sqlProtect.append("SELECT PROTECTIVE_DEVICE_CODE, SHORT_DESC FROM  AE_PROTECTIVE_DEVICE_LANG_VW WHERE language_id=?  and EFF_STATUS ='E' ORDER BY 2");//common-icn-0180
				  
			   pstmt = con.prepareStatement(sqlProtect.toString());
			   pstmt.setString(1, locale);//common-icn-0180
			   rset = pstmt.executeQuery();
			   optSelected="";
			   while(rset!=null && rset.next())
			   {
					if(rset.getString(1).equals(protective_device_code))
				   {
						optSelected="selected";
												
				   }
				   else
					   optSelected="";

				   
				  out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
			   }
			   if(pstmt!=null) pstmt.close();
			   if(rset!=null) rset.close();
			   if((sqlProtect != null) && (sqlProtect.length() > 0))
				 {
					sqlProtect.delete(0,sqlProtect.length());
				 }
			   %>
                 </select>
               </td>
			   <td class='LABEL' width='25%' ><fmt:message key="Common.PositionDuringIncident.label" bundle="${common_labels}"/>
               </td>
			   <td class='fields' width='25%' tabindex='<%=++tindex%>'>
				   <select name='affected_site' id='affected_site' tabindex='' <%=dis11%>>
				   <option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
					   <%
						   pstmt = con.prepareStatement(sqlPosition.toString());
					       rset = pstmt.executeQuery();
						   optSelected="";
						   while(rset!=null && rset.next())
						   {
							  if(rset.getString(1).equals(pat_position_code))
							   {
                                    optSelected="selected";
															
							   }
							   else
								   optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
						   if((sqlPosition != null) && (sqlPosition.length() > 0))
							{
								sqlPosition.delete(0,sqlPosition.length());
							}
					   %>
                 </select>
              </td>
	  </tr> 
	 <tr>
		    <td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.mlcdetails.label" bundle="${common_labels}"/></td>
	 </tr>
	 <tr>	
		      <td class='label' width='25%'><fmt:message key="Common.mlc.label" bundle="${common_labels}"/></td>
		     <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='checkbox'  name="mlc_case_yn" id="mlc_case_yn" <%=checked3%> onclick='chkMlcValue(this)'   <%=disMLC%>></td>
             <td class='LABEL' width='25%' colspan='2'>&nbsp;</td>
      </tr> 
	  <tr>
	          <td class='label' width='25%'><fmt:message key="Common.PoliceReportNo.label" bundle="${common_labels}"/></td>
  		      <td class='fields' width='25%' tabindex='<%=++tindex%>'>
			  <input type='text'  name='police_rep_no1' id='police_rep_no1'   maxLength='20' size='15' tabindex=''value="<%=police_rep_no%>"  <%=dis12%>></td>
			  <td class='label' width='25%'><fmt:message key="Common.PoliceStationDetails.label" bundle="${common_labels}"/></td>
			  <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='text' name="police_stat_detail" id="police_stat_detail"  maxLength='30' size='25' onblur='tab_click22("others_tab")' tabindex='' value='<%=police_station_dtls%>'  <%=dis13%>></td>
	  </tr>
     <tr><td colspan=4 class=label height=5></td></tr>
  </table>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> 
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> 
	<a name="sub2" tabindex='-1'></a> 
	 <table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
            <tr><td class='white'>

		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Triage Details">
				<a onclick="tab_click1('Triage_tab')" class="tabClicked" id='Triage_tab' >
					<span class="tabSpanclicked" id="Triage_tabspan"><fmt:message key="Common.TriageDetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<%if(ca_install_yn.equals("Y")){%>
			<li class="tablistitem" title="Assessment">
				<a onclick="tab_click1('assess_tab')" class="tabA" id="assess_tab" >
					<span class="tabAspan" id="assess_tabspan"><fmt:message key="Common.Assessment.label" bundle="${common_labels}"/></span>
				</a>
			</li>	
			<%}%> 
		</ul>
	   </td></tr>
    </table>
	<table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
      <tr><td class='white'>
			<ul id="tablist" class="tablist">
				<li class="tablistitem" title="Condition / Case">
					<a onclick="tab_click2('sub1','patCond_tab')" class="tabA" id="patCond_tab" >
						<span class="tabAspan" id="patCond_tabspan"><fmt:message key="eAE.ConditionCase.label" bundle="${ae_labels}"/></span>
					</a>
				</li>
				<li class="tablistitem" title="Others">
					<a onclick="tab_click2('sub2','others_tab')" class="tabClicked" id="others_tab" >
						<span class="tabSpanclicked" id="others_tabspan"><fmt:message key="Common.others.label" bundle="${common_labels}"/></span>
					</a>
				</li>
			</ul>
          </td></tr>
</table>
 <table border="0" cellpadding="3" cellspacing="0" align='center' colspan=8 width="100%">
	 <tr>
		    <td class='COLUMNHEADER' colspan='4' ><fmt:message key="eAE.InitialManagement.label" bundle="${ae_labels}"/></td>
	 </tr>

	<%if(ca_install_yn.equals("Y")){
	if (order_catalog_code3.equals("")){ FBCProp		  ="disabled";}
    try
	 {	
				   StringBuffer sqlECG1 = new StringBuffer();
				   StringBuffer sqlECG3 = new StringBuffer();
				   StringBuffer sqlECG4 = new StringBuffer();
				   StringBuffer sqlECG5 = new StringBuffer();
				  // sqlECG1.append("select count(*)  from or_order a, or_order_line b, ae_param c where a.ORDERING_FACILITY_ID='"+facilityId+"' and a.patient_id='"+patient_id+"' and  a.ENCOUNTER_ID='"+encounter_id+"' and a.order_id=b.order_id and a.ORDERING_FACILITY_ID=c.OPERATING_FACILITY_ID "); //common-icn-0180
				   sqlECG1.append("select count(*)  from or_order a, or_order_line b, ae_param c where a.ORDERING_FACILITY_ID=? and a.patient_id=? and  a.ENCOUNTER_ID=? and a.order_id=b.order_id and a.ORDERING_FACILITY_ID=c.OPERATING_FACILITY_ID "); //common-icn-0180
					  
				   
				   sqlECG3.append(sqlECG1);
				   sqlECG4.append(sqlECG1);
				   sqlECG5.append(sqlECG1);
				   StringBuffer s1 = new StringBuffer();
				   StringBuffer s3 = new StringBuffer();
				   StringBuffer s4 = new StringBuffer();
				   StringBuffer s5 = new StringBuffer();
				   s1.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE2");
				   s3.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE4");
				   s4.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE1");
				   s5.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE5");
	              
				   pstmtEncounter = con.prepareStatement(sqlECG1.append(s1).toString());
				   pstmtEncounter.setString(1, facilityId);//common-icn-0180
				   pstmtEncounter.setString(2, patient_id);//common-icn-0180
				   pstmtEncounter.setString(3, encounter_id);//common-icn-0180
				 
				   rsetEncounter = pstmtEncounter.executeQuery();
				   while(rsetEncounter!=null && rsetEncounter.next())
					 {
						      countECG=rsetEncounter.getInt(1);
					 }
				  if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				  if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }

					  if (countECG>0)
					  {
						  ECGProp = "checked";
					  }else
					  {
						  ECGProp ="";
					  }
				   pstmtEncounter = con.prepareStatement(sqlECG3.append(s3).toString());
				   rsetEncounter = pstmtEncounter.executeQuery();
				   while(rsetEncounter!=null && rsetEncounter.next())
					 {
						      countDerss=rsetEncounter.getInt(1);
					 }
				  if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				  if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }
					  if (countDerss>0)
					  {
						  DressProp = "checked";
					  }else
					  {
						  DressProp ="";
					  }
				   pstmtEncounter = con.prepareStatement(sqlECG4.append(s4).toString());
				   rsetEncounter = pstmtEncounter.executeQuery();
				   while(rsetEncounter!=null && rsetEncounter.next())
					 {
						      countSpO2=rsetEncounter.getInt(1);
					 }
				  if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				  if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }
					  if (countSpO2>0)
					  {
						  SpO2Prop = "checked";
					  }else
					  {
						  SpO2Prop ="";
					  }
				   pstmtEncounter = con.prepareStatement(sqlECG5.append(s5).toString());
				   rsetEncounter = pstmtEncounter.executeQuery();
				   while(rsetEncounter!=null && rsetEncounter.next())
					 {
						      countCapBlood=rsetEncounter.getInt(1);
					 }
				  if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				  if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }
					  if (countCapBlood>0)
					  {
						  capBloodSugProp = "checked";
					  }else
					  {
						  capBloodSugProp ="";
					  }
				  }catch(Exception e) {e.printStackTrace() ;}

  %>
	 <tr><td colspan=4 class=label height=5></td></tr>
    <tr >	
         <td class='LABEL'   width='25%' ><fmt:message key="eAE.CapBloodSugar.label" bundle="${ae_labels}"/></td>
  		 <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type="checkbox" name='cap_bloodSugar' id='cap_bloodSugar'  <%=capBloodSugProp%>  disabled>
		 <td class='LABEL'   width='25%' ><fmt:message key="eAE.SpO2.label" bundle="${ae_labels}"/></td>
  		 <td class='fields' width='25%' tabindex='<%=++tindex%>'> 
		  <input type="checkbox" name='spo2' id='spo2'   <%=SpO2Prop%> disabled >
		 </td>
	</tr>
	 <tr>
	     <td class='LABEL'   width='25%' >		 
		 <fmt:message key="eAE.FBC.label" bundle="${ae_labels}"/></td>
		 <td class='fields' width='25%' tabindex='<%=++tindex%>'> 
		 <input type="checkbox" name='fbc' id='fbc' onClick='chkOrderCat3(this);' <%=FBCProp%>>
		 </td>
		 <td class='LABEL'   width='25%' ><fmt:message key="Common.ecg.label" bundle="${common_labels}"/></td>
		 <td class='fields' width='25%' tabindex='<%=++tindex%>'> 
		 <input type="checkbox" name='ecg' id='ecg' <%=ECGProp%> disabled> 
         </td>
	 </tr>
	 <tr>
		 <td class='label' width='25%'><fmt:message key="Common.Dressing.label" bundle="${common_labels}"/>
		 <td class='fields' width='25%' tabindex='<%=++tindex%>'> 
	      <input type="checkbox" name='dressing' id='dressing'   <%=DressProp%> disabled>
         </td>
		 <td class='LABEL' colspan=2>&nbsp;</td>
	 </tr>
    <%}%>
	 <tr>
  		 <td class='LABEL' width='25%'><fmt:message key="eAE.Immobilization.label" bundle="${ae_labels}"/></td>
         <td class='fields' colspan='2' tabindex='<%=++tindex%>'>
				 <select name='immobilization' id='immobilization' onChange='' <%=disImmobil%> >
					<Option value=''>&nbsp;------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;</Option>
					 <%
			          try{
			               StringBuffer sqlImmob = new StringBuffer();
                          // sqlImmob.append("select immobilization_code,short_desc from ae_immobilization_lang_vw where language_id='"+locale+"' and eff_status='E'");//common-icn-0180 
                           sqlImmob.append("select immobilization_code,short_desc from ae_immobilization_lang_vw where language_id=? and eff_status='E'"); //common-icn-0180
 			              
                           pstmt=con.prepareStatement(sqlImmob.toString());
                           pstmt.setString(1, locale);//common-icn-0180
						   rset = pstmt.executeQuery();
						   while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(immobilization))
							   {
                                    optSelected="selected";
							   }
							   else
								   optSelected="";

							    out.println( "<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+""); 
						   }
						   if(rset!=null) rset.close();
						   if(pstmt!=null) pstmt.close();
						   if((sqlImmob != null) && (sqlImmob.length() > 0))
							 {
								sqlImmob.delete(0,sqlImmob.length());
							 }
						  }catch(Exception e){ e.printStackTrace() ; }
                 %>
                 </select> 
         </td>
		 <td colspan=2 class='LABEL' >&nbsp;</td>  

  </tr>
 <tr><td colspan=4 class=label height=5></td></tr>
  <tr>
		<td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.ATTImmunizationDetails.label" bundle="${common_labels}"/></td>
  </tr>
 <tr><td colspan=4 class=label height=5></td></tr>
  <tr>				 
		      <td class='LABEL' ><fmt:message key="Common.ImmunizationStatus.label" bundle="${common_labels}"/></td>
  		      <td class='fields' width='25%' tabindex='<%=++tindex%>'>
				 <select name='immunization_stat' id='immunization_stat' onChange='' <%=dis14%>>
					       <Option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</Option>
                           <Option value='F'<%=selected%> ><fmt:message key="Common.FullyImmunized.label" bundle="${common_labels}"/></option>
                           <Option value='P'<%=selected1%>  ><fmt:message key="Common.PartiallyImmunized.label" bundle="${common_labels}"/></option>
                           <Option value='U'<%=selected2%>  ><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
				 </select>
              </td>
  		      <td class='LABEL'  width='25%'><fmt:message key="Common.ATTGiven.label" bundle="${common_labels}"/></td>
		      <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='checkbox'  name="att_given" id="att_given"   value='' <%=checked4%> <%=dis15%> onblur="agecheck(this,'<%=ca_install_yn%>','<%=patient_age%>','<%=max_age_paediatric%>','<%=min_age_pregnancy%>','<%=sex%>');">
			  </td>
	 </tr>
	 <tr><td colspan=4 class=label height=5></td></tr>
	 </table>
		<% if (patient_age <= max_age_paediatric){
				   pediatric_status = "true";	%>

		<table  border="0" cellpadding="3" cellspacing="0" align='center' colspan=12 width="100%">
	    <tr>
		    <td class='COLUMNHEADER' colspan='8' ><fmt:message key="Common.PediatricDetail.label" bundle="${common_labels}"/></td>
	   </tr>
	 <tr><td colspan=4 class=label height=5></td></tr>
	   <tr>	
         <td class='LABEL'  width="25%" ><fmt:message key="Common.Growth/DevelMilestoneAge.label" bundle="${common_labels}"/></td>
  		 <td class='fields'  width="25%" tabindex='<%=++tindex%>'><input type='checkbox'  name="growth_age" id="growth_age"  <%=checked5%> onclick='chkhwc(event);' <%=disabled991%> <%=disabled99%>></td>
		 <td class='LABEL' width="25%"><fmt:message key="Common.Immunizationuptodate.label" bundle="${common_labels}"/></td>
		 <td class='fields'  width="25%" tabindex='<%=++tindex%>'>
		 <input type='checkbox' align='left' name="immun_date" id="immun_date"    <%=checked6%> <%=disImm%> >
         </td>
     </tr>
     <tr>
 		 <td class='LABEL' width="25%"><fmt:message key="Common.Menarche.label" bundle="${common_labels}"/></td>
		 <td  class='fields'  width="25%" tabindex='<%=++tindex%>'><input type='checkbox'  name="menarche" id="menarche"    onclick='checkmenstrual(this);' <%=checked7%> <%=disMenarche%>></td>
		 <td class='LABEL' ><fmt:message key="Common.height.label" bundle="${common_labels}"/></td>
  		 <td class='fields' tabindex='<%=++tindex%>'><input type='text'  name="height" id="height" <%=disHeight%> id='height'size="5" maxlength='6' value="<%=height%>"onKeyPress='return( allowValidNumber(this,event,3,2)); return(ChkNumberInput(this,event,0)); '
		 onBlur='SPCheckPositiveNumber(this);'>&nbsp;<fmt:message key="Common.cm.label" bundle="${common_labels}"/></td>
         
	   </tr>
       <tr>	
		 <td class='LABEL' ><fmt:message key="Common.weight.label" bundle="${common_labels}"/></td>
  		 <td class='fields' tabindex='<%=++tindex%>'><input type='text'  name="weight" id="weight" size="5" maxlength='7' value="<%=weight%>" onKeyPress='return( allowValidNumber(this,event,2,3));return(ChkNumberInput(this,event,0))'
		 onBlur='SPCheckPositiveNumber(this);'<%=disWeight%>>&nbsp;<fmt:message key="Common.kg.label" bundle="${common_labels}"/></td>
 		 <td class='LABEL' ><fmt:message key="Common.Circumference.label" bundle="${common_labels}"/></td>
  		 <td class='fields' tabindex='<%=++tindex%>'><input type='text'  name="circumference" id="circumference" size="5" maxlength='6'value="<%=circumference%>"onKeyPress='return( allowValidNumber(this,event,3,2));return(ChkNumberInput(this,event,0))'onBlur="SPCheckPositiveNumber(this);if(this.readOnly==false)agecheck(this,'<%=ca_install_yn%>','<%=patient_age%>','<%=max_age_paediatric%>','<%=min_age_pregnancy%>','<%=sex%>');"<%=disCir%>>&nbsp;&nbsp;<fmt:message key="Common.cm.label" bundle="${common_labels}"/></td>
	  </tr> 
	 <tr><td colspan=4 class=label height=5></td></tr>
 </table>
 <% } else{
			
			  disabled="";
		 }%>
    <%if (sex.equalsIgnoreCase("F") && (patient_age >= min_age_pregnancy)) {
				 menstrual_status = "true"; %>
				
     <table border="0" cellpadding="3" cellspacing="0" align='center' width='100%'>
	 <tr>
		    <td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.MenstrualHistory.label" bundle="${common_labels}"/></td>
	 </tr>
	 <tr><td colspan=4 class=label height=5></td></tr>
     <tr>				 
		    <td class='LABEL' width="25%" ><fmt:message key="Common.PregnantatPresent.label" bundle="${common_labels}"/></td>
            <td class='fields' width='25%' tabindex='<%=++tindex%>'>
	         <input type='checkbox'  name="pregnant_at_present_yn_val" id="pregnant_at_present_yn_val" <%=checked8%> onClick='checkmenstrual(this); checkPregnant(this);' onBlur='if(this.checked ==false)AEScrollIntoView();' <%=disabledPre%>></td>
			
			<td class='LABEL' width='25%' size='20' ><fmt:message key="eAE.LMPDate.label" bundle="${ae_labels}"/></td>
            <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type="text" name="lmp_date" id="lmp_date" disabled id="lmpdate" maxlength="10" size="8"  onblur='makeValidString(this);doDate1(this); checkPregnantDate(this);calculateEDD();calculateNoOfDays();if(this.readOnly==false) tab_click22("others_tab");' value = "<%=DateUtils.convertDate(lmp_date,"DMY","en",localeName)%>" ><img src='../../eCommon/images/CommonCalendar.gif' name="lmp_calendar" onClick="return showCalendar('lmpdate');" disabled    style='cursor:pointer'><img src='../../eCommon/images/mandatory.gif' id='mand2' style="visibility:hidden" align='center'></img></td> 
       </tr>
	   <tr>		
          	<td class='LABEL' width='25%' ><fmt:message key="Common.POA.label" bundle="${common_labels}"/>
   		       &nbsp;
		       <b><font name="weekVal" id='nmdesig' class='label'><b></font>&nbsp;<fmt:message key="Common.weeks.label" bundle="${common_labels}"/>&nbsp;
		       <font id='nmdesig1' class='label'><b></font>&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
		       <td class='LABEL' align='left' ><fmt:message key="Common.EDD.label" bundle="${common_labels}"/>
   		       &nbsp;
		       <b><font name="eddVal" id='eddesig' class='label'><b></font> 
		    </td>
			<td colspan=2 class='LABEL' >&nbsp;</td>  
	</tr> 
   	 <tr><td colspan=4 class=label height=5></td></tr>
 </table>
<script>
/* code for calculating POA -- Weeks and Days as well as EDD values onload */
calculateNoOfDays();
calculateEDD();
</script>
<% } %> 
<!-- New Tab Other Details Added on 04/02/2005  -->
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<%if(ca_install_yn.equals("Y")){%>
  <a name="tabCA" ></a> 
		<table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
            <tr><td class='white'>

		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Triage Details">
				<a onclick="tab_click1('Triage_tab')" class="tabA" id='Triage_tab' >
					<span class="tabAspan" id="Triage_tabspan"><fmt:message key="Common.TriageDetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<%if(ca_install_yn.equals("Y")){%>
			<li class="tablistitem" title="Assessment">
				<a onclick="tab_click1('assess_tab')" class="tabClicked" id="assess_tab" >
					<span class="tabSpanclicked" id="assess_tabspan"><fmt:message key="Common.Assessment.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<%}%>
		</ul>
	</td></tr></table>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> 
<%}else {%>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> 
<%}
}
else
 {%>

<a name="tab1" tabindex='-1'></a> 
	 <table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
            <tr><td class='white'>

		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Triage Details">
				<a onclick="tab_click1('Triage_tab')" class="tabClicked" id='Triage_tab' >
					<span class="tabSpanclicked" id="Triage_tabspan"><fmt:message key="Common.TriageDetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<%if(ca_install_yn.equals("Y")){%>
			<li class="tablistitem" title="Assessment">
				<a onclick="tab_click1('assess_tab')" class="tabA" id="assess_tab" >
					<span class="tabAspan" id="assess_tabspan"><fmt:message key="Common.Assessment.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<%}%> 
		</ul>
    </td></tr>
    </table>
	<table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
      <tr><td class='white'>
			<ul id="tablist" class="tablist">
				<li class="tablistitem" title="Condition / Case">
					<a onclick="tab_click2('sub1','patCond_tab')" class="tabClicked" id="patCond_tab" >
						<span class="tabSpanclicked" id="patCond_tabspan"><fmt:message key="eAE.ConditionCase.label" bundle="${ae_labels}"/></span>
					</a>
				</li>
				<li class="tablistitem" title="Others">
					<a onclick="tab_click2('sub2','others_tab')" class="tabA" id="others_tab" >
						<span class="tabAspan" id="others_tabspan"><fmt:message key="Common.others.label" bundle="${common_labels}"/></span>
					</a>
				</li>
			</ul>
       </td></tr>
</table>

<table border="0" cellpadding="2" cellspacing="0" align='center' width='100%'>
      <input type='hidden' name='sysdate' id='sysdate' value='<%=sqlDate%>'>
	  <tr>
		<td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.PatientCondition.label" bundle="${common_labels}"/></td>
	  </tr>
      <tr><input type="hidden" name='hddpriority' id='hddpriority'value=<%=priority%>>
              <td class='label' width='25%' ><fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/></td>
	          <!-- below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] -->
			  <td class='label'   width='25%' ><%=red%>
					<input type="checkbox" name='priorityR' id='priorityR'   onClick='setPriority(this);setTreatment(this);' <%=priorityStatus1%> <%=disabled111%>><%=yellow%>
			 		<input type="checkbox" name='priorityY' id='priorityY'    onClick='setPriority(this);setTreatment(this);' <%=priorityStatus2%> <%=disabled12%>><%=green%>
			 		<input type="checkbox" name='priorityG' id='priorityG' <%=priorityStatus3%> onClick='setPriority(this);setTreatment(this);'<%=disabled13%>>
	          </td>
			 <!--CRF  SKR-CRF-0021 [IN028173] end-->
			 <td class='label' width='25%' ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			  <td class='fields' width='25%' ><select name='priority11' id='priority11' <%=disPriority%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
                  <%
					   
                       StringBuffer sqlpriority = new StringBuffer();
					   sqlpriority.append("select PRIORITY_CODE,SHORT_DESC from ");
					   sqlpriority.append("ae_pat_priority_lang_vw where language_id='"+locale+"'  and PRIORITY_NO=? and EFF_STATUS='E'");
	                     				
						 pstmt = con.prepareStatement(sqlpriority.toString());
						 pstmt.setString(1,priority_no);
					     rset = pstmt.executeQuery();
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(priority_code))
							   {
                                    optSelected="selected";
							   }
							   else
								   optSelected="";

							   out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
							  
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
						 if((sqlpriority != null) && (sqlpriority.length() > 0))
						 {
							sqlpriority.delete(0,sqlpriority.length());
						 }
					   %>  
					</select>
		  </td>
		</tr> 
		<tr> 
			  <td class='LABEL'  width='25%' ><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
			  <td class='fields' width='25%' >
			   <%
				 StringBuffer sqlTreatA = new StringBuffer();
				 sqlTreatA.append("SELECT treatment_area_code, short_desc FROM ae_tmt_area_for_clinic_lang_vw WHERE language_id='"+locale+"'  and facility_id = ? AND clinic_code = ?  AND priority_zone = ?  AND  (gender = ? OR gender IS NULL) ");
				 pstmt = con.prepareStatement(sqlTreatA.toString());
				 pstmt.setString(1,facilityId);
				 pstmt.setString(2,clinic_code);
				 pstmt.setString(3,priority);
				 pstmt.setString(4,patient_gender);

				 rset = pstmt.executeQuery();
				 while(rset!=null && rset.next())
				   {
					 String code =rset.getString(1);
					 String desc =specialCharacter(rset.getString(2));
					 if (code.equals("null") || code==null) 
						 code="";
					  if (desc.equals("null") || desc==null) 
						 desc="";
					  if(code.equals(treat_code))
					   {
							optSelectedTreat="selected";
					   }
					   else
						   optSelectedTreat="";
			   
					   sbBuff.append("<option value=\""+code+"\" "+optSelectedTreat+">"+desc+"</option>");
				  }
				 if(pstmt!=null) pstmt.close();
				 if(rset!=null) rset.close();
				 if((sqlTreatA != null) && (sqlTreatA.length() > 0))
				 {
					sqlTreatA.delete(0,sqlTreatA.length());
				 }
			   %> 
			   <select name='treat_area' id='treat_area'  <%=disTreatArea%> onChange='clearBed();'>
				<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
				<%=sbBuff.toString()%>
			    </select>
			 </td>
				   <!-- onblur="ChangeUpperCase(this);checkForValidBed(this.value);" -->
			 <td class='label' width='25%'><fmt:message key="eAE.BedBayNo.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%' ><input type='text' name='bed_bay_no' id='bed_bay_no' size='8' maxlength='8' onblur="ChangeUpperCase(this);" onKeyPress="return(CheckForSpecChars(event))"  value ='<%=bed_no%>' <%=disBed%>><input type=button class=button value='?' name='bed_button' id='bed_button'  onClick="callBedAvailChart();" <%=disBed1%>>
             </td>
		  </tr>
          <tr> 
             <td class='label' ><fmt:message key="Common.Disaster.label" bundle="${common_labels}"/></td>
			 <td class='fields' width='25%' ><input type="checkbox" name='Disaster_YN' id='Disaster_YN'  onClick='setDisaster(this)'<%=checked1%> <%=disDisaster%>></td>
             <td class='label' colspan='2'>&nbsp;</td>
		  </tr> 
		  <tr>
			 <td class='label' width='25%'><fmt:message key="eAE.DisasterArea.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%'  ><input type='text'  name="disaster_area1" id="disaster_area1" value="<%=dis_area%>" maxLength='10' onblur='if(this.value !="")searchDisasterArea(this,disaster_area1);'  <%=disabled11%>><input type='button' name='disaster' id='disaster' value='?' class='button'   onclick='searchDisasterArea(this,disaster_area1);' <%=disabled11%> >
             </td>
		      <td class='LABEL' width='25%'><fmt:message key="eAE.DisasterType.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%' >
				 <select name='disaster_type' id='disaster_type' <%=disabled11%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
			<%  
                  try
				  {	
				   PreparedStatement pstmtTrans = null;
				   ResultSet rsetTrans = null;
				   optSelected="";
                   pstmtTrans = con.prepareStatement("select disaster_type_code, short_desc from ae_disaster_type_lang_vw  where language_id='"+locale+"'  and  eff_status='E' order by short_desc");
				
				   rsetTrans = pstmtTrans.executeQuery();
				   while(rsetTrans!=null && rsetTrans.next())
					{
					  if(rsetTrans.getString(1).equals(disaster_type_code))
							   {
                                    optSelected="selected";
							
							   }
							   else
							   {
								   optSelected="";
							      
							   }
					  out.println("<option value='"+rsetTrans.getString("disaster_type_code")+"' "+optSelected+" >"+rsetTrans.getString("short_desc")+""); 
					}
                  if(rsetTrans!=null) rsetTrans.close();
				  if(pstmtTrans!=null) pstmtTrans.close();
				  }catch(Exception e) {e.printStackTrace() ;}
	            %>
                 </select>
              </td>
           </tr>
	      <tr>
			 <input type='hidden' id='regndatetime' name="visit_date_time" id="visit_date_time"  value='<%=visit_date%>'>
			 <%if(modify_flag.equals("Y")) { %>
		      <td class='LABEL'  width='25%' ><fmt:message key="Common.ambulatorystatus.label" bundle="${common_labels}"/></td>
  		      <td class='fields' width='25%' >
				 <select name='ambulatory_status' id='ambulatory_status' <%=dis1%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
					   <%
						   pstmt = con.prepareStatement(sqlAmbulatory.toString());
					       rset = pstmt.executeQuery();
						   optSelected="";
						   while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(a_status))
							   {
                                    optSelected="selected";
							
							   }
							   else
							   {
								   optSelected="";
							      
							   }
							  
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
						   if((sqlAmbulatory != null) && (sqlAmbulatory.length() > 0))
							 {
								sqlAmbulatory.delete(0,sqlAmbulatory.length());
							 }

					   %>
                 </select>
              </td>
             <%
		     } if(modify_flag.equals("N")) {
		     %>
              <td class='LABEL'  width='25%' ><fmt:message key="Common.ambulatorystatus.label" bundle="${common_labels}"/></td>
  		      <td  class='fields' width='25%' >
				 <select name='ambulatory_status' id='ambulatory_status' >
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
					   <%
						   pstmt = con.prepareStatement(sqlAmbulatory.toString());
					       rset = pstmt.executeQuery();
						   optSelected="";
						   while(rset!=null && rset.next())
						   {
							  
                              out.println("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
						   if((sqlAmbulatory != null) && (sqlAmbulatory.length() > 0))
							 {
								sqlAmbulatory.delete(0,sqlAmbulatory.length());
							 }
					   %>
                 </select>
              </td>
			  <%}%>
              </td>
			  <td class='LABEL' width='25%' colspan='2'></td>

          </tr>
		  <tr> 
			  <td class='label'   width='25%'><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></td> 
			 <%if(pat_dtls_unknown_yn.equals("N")){%>
				  <td class='fields' width='25%' ><input type='text' name='referral_id' id='referral_id' value="<%=referral_id%>" maxlength='14' size='14'  onBlur='searchPatient(document.forms[0].referral_id);' <%=disRefID%>><input type='button' class='button' value='?' name='ref_id_search' id='ref_id_search'   onClick='getReferralID()' <%=disRefID%>></td>
			<%}else if(pat_dtls_unknown_yn.equals("Y")) {%>
				<td  class='fields' width='25%'><input type='text' name='referral_id' id='referral_id' value='' maxlength='14' size='14'  onBlur=''  align='left' disabled><input type='button' class='button' value='?' name='ref_id_search' id='ref_id_search' onClick='getReferralID()' disabled></td>
		   <%}%>
	     <input type='hidden' name='injury_3' id='injury_3' value=''>
		 <%
				if(!complaint_code.equals("")){
				  StringBuffer sqlComplaint1 = new StringBuffer();
	              sqlComplaint1.append("select COMPLAINT_DESC from AM_COMPLAINT_LANG_VW where  language_id='"+locale+"'  and COMPLAINT_CODE=?");

				  pstmt1 = con.prepareStatement(sqlComplaint1.toString());
				  pstmt1.setString(1,complaint_code);
				   
				  rset1 = pstmt1.executeQuery();
					 while(rset1!=null && rset1.next())
					 {
					 complaint = rset1.getString("COMPLAINT_DESC")==null?"":rset1.getString("COMPLAINT_DESC");
					 }
					 if(rset1!=null) rset1.close();
					 if(pstmt1!=null) pstmt1.close();
					 if((sqlComplaint1 != null) && (sqlComplaint1.length() > 0))
					 {
						sqlComplaint1.delete(0,sqlComplaint1.length());
					 }
				 }

			  %>
			  <td class='LABEL' width='25%' ><fmt:message key="Common.Complaint.label" bundle="${common_labels}"/></td>
			  <td class='fields' width='25%' ><input type='text'  name="complaint_desc" id="complaint_desc" value="<%=complaint%>" onblur='if(this.value !="")searchComplaintType(this,complaint_desc);' <%=dis3%>><input type='button' name='Complainttype' id='Complainttype' value='?' class='button' onclick='searchComplaintType(this,complaint_desc);' <%=dis3%>><input type='hidden' name='complaint_code' id='complaint_code' value="<%=complaint_code%>">
          </td>	
		 </tr>
		 <tr> 
					<td class='LABEL' width='25%' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%' colspan='3' ><textarea name='triage_remarks' cols='50'   align='left'  onblur='makeValidString(this);checkMaxLen(this);' onkeypress='checkMaxLimit(this,250);' <%=dis2%>><%=triage_remarks%></textarea>
		  </td>
		  </tr>  

		 <tr>
					<td class='COLUMNHEADER' colspan='4' ><fmt:message key="eAE.CaseDetails.label" bundle="${ae_labels}"/></td>
		 </tr>
		 <tr>  
			        <td class='label' width='25%'><fmt:message key="Common.CaseofTrauma.label" bundle="${common_labels}"/></td>
			        <td class='fields' width='25%' ><input type='checkbox'   name="CaseofTrauma" id="CaseofTrauma"  onClick='checktrauma(this);setMechInj1(this);' <%=checked9%> <%=dis5%>>
					</td>	
					<td class='label' width='25%'><fmt:message key="Common.oscc.label" bundle="${common_labels}"/></td>
                    <td class='fields' width='25%' ><input type='checkbox'  name="oscc_yn" id="oscc_yn"   value='N' onClick='chkOsccValue(this);remVal(document.forms[0].mechan_injury);setMechInj();' <%=disOscc%> <%=checked2%>>
					<!-- <%=checked2%> <%=disable3%> --> </td>
         </tr>
		 <tr> 
					<td class='label'  width='25%'><fmt:message key="Common.medical.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%' ><input type='checkbox'  name="medical_yn" id="medical_yn"  onClick='chkMedicalValue(this);' <%=checkedMed%> <%=disMed%>></td>
					<td class='label'  width='25%' ><fmt:message key="Common.Surgical.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%' > <input type='checkbox'  name="surgical_yn" id="surgical_yn"   value='' onClick='chkSurgValue(this);' <%=checkedSur%> <%=disSur%>> 
					</td>
		 </tr>
				<input type='hidden' name='patient_id' id='patient_id' value=<%=patient_id%>>
				<input type='hidden' name='called_from_ca' id='called_from_ca' value=<%=called_from_ca%>>
		 <tr>
	          <td class='label' width='25%'><fmt:message key="eAE.DateTimeOfAccident.label" bundle="${ae_labels}"/></td>
  		      <td class='fields' width='25%' >
			  <input type='text'  id='accidentdatetime' name='date_time_accident' id='date_time_accident'   maxLength='16' size='16' 
			  value="<%=DateUtils.convertDate(date_time_of_accident,"DMYHM","en",localeName)%>"  onBlur='doDate(this);' <%=disDateAcci%>><img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('accidentdatetime', null, 'hh:mm' );" style='cursor:pointer' <%=disDateAcci%> ></img></td>
			  <td class='label' width='25%'><fmt:message key="eAE.PlaceOfAccident.label" bundle="${ae_labels}"/></td>
			  <td class='fields' width='25%' ><input type='text' name="place_of_accident" id="place_of_accident"  maxLength='30' size='25'   value="<%=place_of_accident%>" <%=disPlaceAcci%>></td>
	     </tr>
	     <tr>	
		           <td class='LABEL' width='25%' ><fmt:message key="Common.MechanismofInjury.label" bundle="${common_labels}"/></td>
  		           <td class='fields' width='25%' colspan='2' >
				   <select name='mechan_injury' id='mechan_injury' onChange='setInjury(this)' <%=dis6%>> 
				    <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
					   <%
					  if(modify_flag.equals("Y")) {
						 StringBuffer sqlMechaInjury = new StringBuffer();
						 sqlMechaInjury.append("SELECT INJ_CATEGORY_CODE,SHORT_DESC FROM AE_INJURY_CATEGORY_LANG_VW  WHERE language_id='"+locale+"'  and EFF_STATUS='E'   ORDER BY 2 ");  
						 pstmt = con.prepareStatement(sqlMechaInjury.toString());
					     rset = pstmt.executeQuery();
						 	 optSelected="";
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString("INJ_CATEGORY_CODE").equals(mech_injr_code))
							   {
                                    optSelected="selected";
															
							   }
							   else
								   optSelected="";

                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
						 if((sqlMechaInjury != null) && (sqlMechaInjury.length() > 0))
						 {
							sqlMechaInjury.delete(0,sqlMechaInjury.length());
						 }
					   }  %>  
                 </select><img src='../../eCommon/images/mandatory.gif' id='mand4' style="visibility:hidden" align='center'></img><b><font  class='label'><b></font>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.and.label" bundle="${common_labels}"/>
              </td>
  		      <input type='hidden' name='mech_sub_code' id='mech_sub_code' value=<%=mech_injury_subcatg_code%> >
			 <td class='fields' width='25%' >
				<select name='injury' id='injury'  <%=dis7%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
				</select><img src='../../eCommon/images/mandatory.gif' id='mand5' style="visibility:hidden" align='center'></img>
              </td> 
	  </tr>
	  <tr>	
		      <td class='LABEL' width='25%' ><fmt:message key="Common.VehiclesInvolved.label" bundle="${common_labels}"/></td>
  		      <td class='fields' width='25%' colspan='2' >
				 <select name='vehicle_invol' id='vehicle_invol' <%=dis8%>>
				  <option value='' >--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
					   <%
						 StringBuffer sqlVehicleInv = new StringBuffer();
						 sqlVehicleInv.append("select ARRIVAL_CODE, SHORT_DESC ARRIVAL_SHORT_DESC from am_arrival_lang_vw where language_id='"+locale+"'  and EFF_STATUS='E' and facility_id='"+facilityId+"'  order by 2");
						 pstmt = con.prepareStatement(sqlVehicleInv.toString());
					     rset = pstmt.executeQuery();
						 optSelected="";
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(vehicle_invlovedcode))
							   {
                                    optSelected="selected";
															
							   }
							   else
								   optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
					   %>
                 </select><b><font  class='label'><b></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.and.label" bundle="${common_labels}"/>
              </b></td>
			  <td class='fields' width='25%' >
				<select name='vehicle_invol1' id='vehicle_invol1' <%=dis9%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
				<%
						 pstmt = con.prepareStatement(sqlVehicleInv.toString());
					     rset = pstmt.executeQuery();
						 optSelected="";
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(vehicle_invlovedcode1))
							   {
                                    optSelected="selected";
															
							   }
							   else
								   optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
						 if((sqlVehicleInv != null) && (sqlVehicleInv.length() > 0))
						 {
							sqlVehicleInv.delete(0,sqlVehicleInv.length());
						 }
					   %>
				</select>
              </td> 			   
	   </tr>
	   <tr>	
		      <td class='LABEL' width='25%' ><fmt:message key="Common.ProtectiveDeviceUsed.label" bundle="${common_labels}"/></td>
  		      <td class='fields' width='25%' >
				 <select name='protective_device' id='protective_device' <%=dis10%>>
				   <option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
			   <%
			   StringBuffer sqlProtect = new StringBuffer();
			   //sqlProtect.append("SELECT PROTECTIVE_DEVICE_CODE, SHORT_DESC FROM  AE_PROTECTIVE_DEVICE_LANG_VW WHERE language_id='"+locale+"'  and EFF_STATUS ='E' ORDER BY 2");//common-icn-0180
			   sqlProtect.append("SELECT PROTECTIVE_DEVICE_CODE, SHORT_DESC FROM  AE_PROTECTIVE_DEVICE_LANG_VW WHERE language_id=?  and EFF_STATUS ='E' ORDER BY 2");//common-icn-0180
				  
			   pstmt = con.prepareStatement(sqlProtect.toString());
			   pstmt.setString(1, locale);//common-icn-0180
			   rset = pstmt.executeQuery();
			   optSelected="";
			   while(rset!=null && rset.next())
			   {
					if(rset.getString(1).equals(protective_device_code))
				   {
						optSelected="selected";
												
				   }
				   else
					   optSelected="";

				   
				  out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
			   }
			   if(pstmt!=null) pstmt.close();
			   if(rset!=null) rset.close();
			   if((sqlProtect != null) && (sqlProtect.length() > 0))
				 {
					sqlProtect.delete(0,sqlProtect.length());
				 }
			   %>
                 </select>
               </td>
			   <td class='LABEL' width='25%' ><fmt:message key="Common.PositionDuringIncident.label" bundle="${common_labels}"/>
               </td>
			   <td class='fields' width='25%' >
				   <select name='affected_site' id='affected_site' <%=dis11%>>
				   <option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
					   <%
						   pstmt = con.prepareStatement(sqlPosition.toString());
					       rset = pstmt.executeQuery();
						   optSelected="";
						   while(rset!=null && rset.next())
						   {
							  if(rset.getString(1).equals(pat_position_code))
							   {
                                    optSelected="selected";
															
							   }
							   else
								   optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
						   if((sqlPosition != null) && (sqlPosition.length() > 0))
							{
								sqlPosition.delete(0,sqlPosition.length());
							}
					   %>
                 </select>
              </td>
	  </tr> 
	 <tr>
		    <td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.mlcdetails.label" bundle="${common_labels}"/></td>
	 </tr>
	 <tr>	
		      <td class='label' width='25%'><fmt:message key="Common.mlc.label" bundle="${common_labels}"/></td>
		     <td class='fields' width='25%' ><input type='checkbox'  name="mlc_case_yn" id="mlc_case_yn" <%=checked3%> onclick='chkMlcValue(this)'   <%=disMLC%>></td>
             <td class='LABEL' width='25%' colspan='2'>&nbsp;</td>
      </tr> 
	  <tr>
	          <td class='label' width='25%'><fmt:message key="Common.PoliceReportNo.label" bundle="${common_labels}"/></td>
  		      <td class='fields' width='25%' >
			  <input type='text'  name='police_rep_no1' id='police_rep_no1'   maxLength='20' size='15' value="<%=police_rep_no%>"  <%=dis12%>></td>
			  <td class='label' width='25%'><fmt:message key="Common.PoliceStationDetails.label" bundle="${common_labels}"/></td>
			  <td class='fields' width='25%' ><input type='text' name="police_stat_detail" id="police_stat_detail"  maxLength='30' size='25' onblur='tab_click22("others_tab")'  value='<%=police_station_dtls%>'  <%=dis13%>></td>
	  </tr>
     <tr><td colspan=4 class=label height=5></td></tr>
  </table>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> 
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> 
	<a name="sub2" tabindex='-1'></a> 
	 <table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
            <tr><td class='white'>

		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Triage Details">
				<a onclick="tab_click1('Triage_tab')" class="tabClicked" id='Triage_tab' >
					<span class="tabSpanclicked" id="Triage_tabspan"><fmt:message key="Common.TriageDetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<%if(ca_install_yn.equals("Y")){%>
			<li class="tablistitem" title="Assessment">
				<a onclick="tab_click1('assess_tab')" class="tabA" id="assess_tab" >
					<span class="tabAspan" id="assess_tabspan"><fmt:message key="Common.Assessment.label" bundle="${common_labels}"/></span>
				</a>
			</li>	
			<%}%> 
		</ul>
	   </td></tr>
    </table>
	<table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
      <tr><td class='white'>
			<ul id="tablist" class="tablist">
				<li class="tablistitem" title="Condition / Case">
					<a onclick="tab_click2('sub1','patCond_tab')" class="tabA" id="patCond_tab" >
						<span class="tabAspan" id="patCond_tabspan"><fmt:message key="eAE.ConditionCase.label" bundle="${ae_labels}"/></span>
					</a>
				</li>
				<li class="tablistitem" title="Others">
					<a onclick="tab_click2('sub2','others_tab')" class="tabClicked" id="others_tab" >
						<span class="tabSpanclicked" id="others_tabspan"><fmt:message key="Common.others.label" bundle="${common_labels}"/></span>
					</a>
				</li>
			</ul>
          </td></tr>
</table>
 <table border="0" cellpadding="3" cellspacing="0" align='center' colspan=8 width="100%">
	 <tr>
		    <td class='COLUMNHEADER' colspan='4' ><fmt:message key="eAE.InitialManagement.label" bundle="${ae_labels}"/></td>
	 </tr>

	<%if(ca_install_yn.equals("Y")){
	if (order_catalog_code3.equals("")){ FBCProp		  ="disabled";}
    try
	 {	
				   StringBuffer sqlECG1 = new StringBuffer();
				   StringBuffer sqlECG3 = new StringBuffer();
				   StringBuffer sqlECG4 = new StringBuffer();
				   StringBuffer sqlECG5 = new StringBuffer();
				   //sqlECG1.append("select count(*)  from or_order a, or_order_line b, ae_param c where a.ORDERING_FACILITY_ID='"+facilityId+"' and a.patient_id='"+patient_id+"' and  a.ENCOUNTER_ID='"+encounter_id+"' and a.order_id=b.order_id and a.ORDERING_FACILITY_ID=c.OPERATING_FACILITY_ID ");//common-icn-0180 
				   sqlECG1.append("select count(*)  from or_order a, or_order_line b, ae_param c where a.ORDERING_FACILITY_ID=? and a.patient_id=? and  a.ENCOUNTER_ID=? and a.order_id=b.order_id and a.ORDERING_FACILITY_ID=c.OPERATING_FACILITY_ID "); //common-icn-0180
				   
				   
				   sqlECG3.append(sqlECG1);
				   sqlECG4.append(sqlECG1);
				   sqlECG5.append(sqlECG1);
				   StringBuffer s1 = new StringBuffer();
				   StringBuffer s3 = new StringBuffer();
				   StringBuffer s4 = new StringBuffer();
				   StringBuffer s5 = new StringBuffer();
				   s1.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE2");
				   s3.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE4");
				   s4.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE1");
				   s5.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE5");
	              
				   pstmtEncounter = con.prepareStatement(sqlECG1.append(s1).toString());
				   pstmtEncounter.setString(1, facilityId);//common-icn-0180
				   pstmtEncounter.setString(2, patient_id);//common-icn-0180
				   pstmtEncounter.setString(3, encounter_id);//common-icn-0180
				   rsetEncounter = pstmtEncounter.executeQuery();
				   while(rsetEncounter!=null && rsetEncounter.next())
					 {
						      countECG=rsetEncounter.getInt(1);
					 }
				  if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				  if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }

					  if (countECG>0)
					  {
						  ECGProp = "checked";
					  }else
					  {
						  ECGProp ="";
					  }
				   pstmtEncounter = con.prepareStatement(sqlECG3.append(s3).toString());
				   rsetEncounter = pstmtEncounter.executeQuery();
				   while(rsetEncounter!=null && rsetEncounter.next())
					 {
						      countDerss=rsetEncounter.getInt(1);
					 }
				  if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				  if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }
					  if (countDerss>0)
					  {
						  DressProp = "checked";
					  }else
					  {
						  DressProp ="";
					  }
				   pstmtEncounter = con.prepareStatement(sqlECG4.append(s4).toString());
				   rsetEncounter = pstmtEncounter.executeQuery();
				   while(rsetEncounter!=null && rsetEncounter.next())
					 {
						      countSpO2=rsetEncounter.getInt(1);
					 }
				  if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				  if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }
					  if (countSpO2>0)
					  {
						  SpO2Prop = "checked";
					  }else
					  {
						  SpO2Prop ="";
					  }
				   pstmtEncounter = con.prepareStatement(sqlECG5.append(s5).toString());
				   rsetEncounter = pstmtEncounter.executeQuery();
				   while(rsetEncounter!=null && rsetEncounter.next())
					 {
						      countCapBlood=rsetEncounter.getInt(1);
					 }
				  if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				  if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }
					  if (countCapBlood>0)
					  {
						  capBloodSugProp = "checked";
					  }else
					  {
						  capBloodSugProp ="";
					  }
				  }catch(Exception e) {e.printStackTrace() ;}

  %>
	 <tr><td colspan=4 class=label height=5></td></tr>
    <tr >	
         <td class='LABEL'   width='25%' ><fmt:message key="eAE.CapBloodSugar.label" bundle="${ae_labels}"/></td>
  		 <td class='fields' width='25%' ><input type="checkbox" name='cap_bloodSugar' id='cap_bloodSugar'  <%=capBloodSugProp%>  disabled>
		 <td class='LABEL'   width='25%' ><fmt:message key="eAE.SpO2.label" bundle="${ae_labels}"/></td>
  		 <td class='fields' width='25%' > 
		  <input type="checkbox" name='spo2' id='spo2'   <%=SpO2Prop%> disabled >
		 </td>
	</tr>
	 <tr>
	     <td class='LABEL'   width='25%' >		 
		 <fmt:message key="eAE.FBC.label" bundle="${ae_labels}"/></td>
		 <td class='fields' width='25%' > 
		 <input type="checkbox" name='fbc' id='fbc' onClick='chkOrderCat3(this);' <%=FBCProp%>>
		 </td>
		 <td class='LABEL'   width='25%' ><fmt:message key="Common.ecg.label" bundle="${common_labels}"/></td>
		 <td class='fields' width='25%' > 
		 <input type="checkbox" name='ecg' id='ecg' <%=ECGProp%> disabled> 
         </td>
	 </tr>
	 <tr>
		 <td class='label' width='25%'><fmt:message key="Common.Dressing.label" bundle="${common_labels}"/>
		 <td class='fields' width='25%' > 
	      <input type="checkbox" name='dressing' id='dressing'   <%=DressProp%> disabled>
         </td>
		 <td class='LABEL' colspan=2>&nbsp;</td>
	 </tr>
    <%}%>
	 <tr>
  		 <td class='LABEL' width='25%'><fmt:message key="eAE.Immobilization.label" bundle="${ae_labels}"/></td>
         <td class='fields' colspan='2' >
				 <select name='immobilization' id='immobilization' onChange='' <%=disImmobil%> >
					<Option value=''>&nbsp;------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;</Option>
					 <%
			          try{
			               StringBuffer sqlImmob = new StringBuffer();
                           //sqlImmob.append("select immobilization_code,short_desc from ae_immobilization_lang_vw where language_id='"+locale+"' and eff_status='E'"); //common-icn-0180
                           sqlImmob.append("select immobilization_code,short_desc from ae_immobilization_lang_vw where language_id=? and eff_status='E'"); //common-icn-0180
			               
                           pstmt=con.prepareStatement(sqlImmob.toString());
                           pstmt.setString(1, locale);//common-icn-0180
						   rset = pstmt.executeQuery();
						   while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(immobilization))
							   {
                                    optSelected="selected";
							   }
							   else
								   optSelected="";

							    out.println( "<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+""); 
						   }
						   if(rset!=null) rset.close();
						   if(pstmt!=null) pstmt.close();
						   if((sqlImmob != null) && (sqlImmob.length() > 0))
							 {
								sqlImmob.delete(0,sqlImmob.length());
							 }
						  }catch(Exception e){ e.printStackTrace() ;}
                 %>
                 </select> 
         </td>
		 <td colspan=2 class='LABEL' >&nbsp;</td>  

  </tr>
 <tr><td colspan=4 class=label height=5></td></tr>
  <tr>
		<td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.ATTImmunizationDetails.label" bundle="${common_labels}"/></td>
  </tr>
 <tr><td colspan=4 class=label height=5></td></tr>
  <tr>				 
		      <td class='LABEL' ><fmt:message key="Common.ImmunizationStatus.label" bundle="${common_labels}"/></td>
  		      <td class='fields' width='25%' >
				 <select name='immunization_stat' id='immunization_stat' onChange='' <%=dis14%>>
					       <Option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</Option>
                           <Option value='F'<%=selected%> ><fmt:message key="Common.FullyImmunized.label" bundle="${common_labels}"/></option>
                           <Option value='P'<%=selected1%>  ><fmt:message key="Common.PartiallyImmunized.label" bundle="${common_labels}"/></option>
                           <Option value='U'<%=selected2%>  ><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
				 </select>
              </td>
  		      <td class='LABEL'  width='25%'><fmt:message key="Common.ATTGiven.label" bundle="${common_labels}"/></td>
		      <td class='fields' width='25%' ><input type='checkbox'  name="att_given" id="att_given"   value='' <%=checked4%> <%=dis15%> onblur="agecheck(this,'<%=ca_install_yn%>','<%=patient_age%>','<%=max_age_paediatric%>','<%=min_age_pregnancy%>','<%=sex%>');">
			  </td>
	 </tr>
	 <tr><td colspan=4 class=label height=5></td></tr>
	 </table>
		<% if (patient_age <= max_age_paediatric){
				   pediatric_status = "true";	%>

		<table  border="0" cellpadding="3" cellspacing="0" align='center' colspan=12 width="100%">
	    <tr>
		    <td class='COLUMNHEADER' colspan='8' ><fmt:message key="Common.PediatricDetail.label" bundle="${common_labels}"/></td>
	   </tr>
	 <tr><td colspan=4 class=label height=5></td></tr>
	   <tr>	
         <td class='LABEL'  width="25%" ><fmt:message key="Common.Growth/DevelMilestoneAge.label" bundle="${common_labels}"/></td>
  		 <td class='fields'  width="25%" ><input type='checkbox'  name="growth_age" id="growth_age"  <%=checked5%> onclick='chkhwc(event);' <%=disabled991%> <%=disabled99%>></td>
		 <td class='LABEL' width="25%"><fmt:message key="Common.Immunizationuptodate.label" bundle="${common_labels}"/></td>
		 <td class='fields'  width="25%" >
		 <input type='checkbox' align='left' name="immun_date" id="immun_date"    <%=checked6%> <%=disImm%> >
         </td>
     </tr>
     <tr>
 		 <td class='LABEL' width="25%"><fmt:message key="Common.Menarche.label" bundle="${common_labels}"/></td>
		 <td  class='fields'  width="25%" ><input type='checkbox'  name="menarche" id="menarche"    onclick='checkmenstrual(this);' <%=checked7%> <%=disMenarche%>></td>
		 <td class='LABEL' ><fmt:message key="Common.height.label" bundle="${common_labels}"/></td>
  		 <td class='fields' ><input type='text'  name="height" id="height" <%=disHeight%> id='height'size="5" maxlength='6' value="<%=height%>"onKeyPress='return( allowValidNumber(this,event,3,2)); return(ChkNumberInput(this,event,0)); '
		 onBlur='SPCheckPositiveNumber(this);'>&nbsp;<fmt:message key="Common.cm.label" bundle="${common_labels}"/></td>
         
	   </tr>
       <tr>	
		 <td class='LABEL' ><fmt:message key="Common.weight.label" bundle="${common_labels}"/></td>
  		 <td class='fields' ><input type='text'  name="weight" id="weight" size="5" maxlength='7' value="<%=weight%>" onKeyPress='return( allowValidNumber(this,event,2,3));return(ChkNumberInput(this,event,0))'
		 onBlur='SPCheckPositiveNumber(this);'<%=disWeight%>>&nbsp;<fmt:message key="Common.kg.label" bundle="${common_labels}"/></td>
 		 <td class='LABEL' ><fmt:message key="Common.Circumference.label" bundle="${common_labels}"/></td>
  		 <td class='fields' ><input type='text'  name="circumference" id="circumference" size="5" maxlength='6'value="<%=circumference%>"onKeyPress='return( allowValidNumber(this,event,3,2));return(ChkNumberInput(this,event,0))'onBlur="SPCheckPositiveNumber(this);if(this.readOnly==false)agecheck(this,'<%=ca_install_yn%>','<%=patient_age%>','<%=max_age_paediatric%>','<%=min_age_pregnancy%>','<%=sex%>');"<%=disCir%>>&nbsp;&nbsp;<fmt:message key="Common.cm.label" bundle="${common_labels}"/></td>
	  </tr> 
	 <tr><td colspan=4 class=label height=5></td></tr>
 </table>
 <% } else{
			
			  disabled="";
		 }%>
    <%if (sex.equalsIgnoreCase("F") && (patient_age >= min_age_pregnancy)) {
				 menstrual_status = "true"; %>
				
     <table border="0" cellpadding="3" cellspacing="0" align='center' width='100%'>
	 <tr>
		    <td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.MenstrualHistory.label" bundle="${common_labels}"/></td>
	 </tr>
	 <tr><td colspan=4 class=label height=5></td></tr>
     <tr>				 
		    <td class='LABEL' width="25%" ><fmt:message key="Common.PregnantatPresent.label" bundle="${common_labels}"/></td>
            <td class='fields' width='25%' >
	         <input type='checkbox'  name="pregnant_at_present_yn_val" id="pregnant_at_present_yn_val" <%=checked8%> onClick='checkmenstrual(this); checkPregnant(this);' onBlur='if(this.checked ==false)AEScrollIntoView(1);' <%=disabledPre%>></td>
			
			<td class='LABEL' width='25%' size='20' ><fmt:message key="eAE.LMPDate.label" bundle="${ae_labels}"/></td>
            <td class='fields' width='25%' ><input type="text" name="lmp_date" id="lmp_date" disabled id="lmpdate" maxlength="10" size="8"  onblur='makeValidString(this);doDate1(this); checkPregnantDate(this);calculateEDD();calculateNoOfDays();if(this.readOnly==false) tab_click22("others_tab");' value = "<%=DateUtils.convertDate(lmp_date,"DMY","en",localeName)%>" ><img src='../../eCommon/images/CommonCalendar.gif' name="lmp_calendar" onClick="return showCalendar('lmpdate');" disabled    style='cursor:pointer'><img src='../../eCommon/images/mandatory.gif' id='mand2' style="visibility:hidden" align='center'></img></td> 
       </tr>
	   <tr>		
          	<td class='LABEL' width='25%' ><fmt:message key="Common.POA.label" bundle="${common_labels}"/>
   		       &nbsp;
		       <b><font name="weekVal" id='nmdesig' class='label'><b></font>&nbsp;<fmt:message key="Common.weeks.label" bundle="${common_labels}"/>&nbsp;
		       <font id='nmdesig1' class='label'><b></font>&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
		       <td class='LABEL' align='left' ><fmt:message key="Common.EDD.label" bundle="${common_labels}"/>
   		       &nbsp;
		       <b><font name="eddVal" id='eddesig' class='label'><b></font> 
		    </td>
			<td colspan=2 class='LABEL' >&nbsp;</td>  
	</tr> 
   	 <tr><td colspan=4 class=label height=5></td></tr>
 </table>
<script>
/* code for calculating POA -- Weeks and Days as well as EDD values onload */
calculateNoOfDays();
calculateEDD();
</script>
<% } %> 
<!-- New Tab Other Details Added on 04/02/2005  -->
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<%if(ca_install_yn.equals("Y")){%>
  <a name="tabCA" ></a> 
		<table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
            <tr><td class='white'>

		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Triage Details">
				<a onclick="tab_click1('Triage_tab')" class="tabA" id='Triage_tab' >
					<span class="tabAspan" id="Triage_tabspan"><fmt:message key="Common.TriageDetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<%if(ca_install_yn.equals("Y")){%>
			<li class="tablistitem" title="Assessment">
				<a onclick="tab_click1('assess_tab')" class="tabClicked" id="assess_tab" >
					<span class="tabSpanclicked" id="assess_tabspan"><fmt:message key="Common.Assessment.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<%}%>
		</ul>
	</td></tr></table>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> 
<%}else {%>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> 
<%}


 
 }
 %>
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
<input type='hidden' name='speciality_code' id='speciality_code' value='<%=speciality_code%>'>
<input type='hidden' name='episode_id' id='episode_id' value='<%=episode_id%>'>
<input type='hidden' name='visit_num' id='visit_num' value='<%=visit_num%>'>
<input type='hidden' name='hdddob' id='hdddob' value=<%=date_of_birth%>>
<input type='hidden' name='bed_no' id='bed_no' value='<%=bed_no%>'>
<input type='hidden' name='encounter_id' id='encounter_id' value=<%=encounter_id%>>
<input type='hidden' name='treat_code' id='treat_code' value='<%=treat_code%>'> 
<input type='hidden' name='menstrual_status' id='menstrual_status' value=<%=menstrual_status%>>
<input type='hidden' name='pediatric_status' id='pediatric_status' value=<%=pediatric_status%>>
<input type='hidden' name="mech_injr_subcat_code" id="mech_injr_subcat_code" value="<%=mech_injr_subcat_code%>">
<input type='hidden' name='facility_id' id='facility_id' value=<%=facilityId%>>
<input type='hidden' name='clinic_code' id='clinic_code' value=<%=clinic_code%>>
<input type='hidden' name='priority_zone' id='priority_zone' value=<%=priority%>>
<input type='hidden' name='brought_dead' id='brought_dead' value=<%=brought_dead%>>
<input type='hidden' name='pat_priority' id='pat_priority' value=<%=pat_priority%>>
<input type='hidden' name='CaseofTrauma_val' id='CaseofTrauma_val' value=''>
<input type='hidden' name='disaster_area' id='disaster_area' value='<%=disaster_town_code%>'>
<input type='hidden' name='rec_date_time' id='rec_date_time' value='<%=rec_date_time%>'>
<input type='hidden' name='sys_date_time' id='sys_date_time' value='<%=sys_date_time%>'>
<input type='hidden' name='sys_date_time1' id='sys_date_time1' value='<%=sys_date%>'>
<input type='hidden' name='modify_flag' id='modify_flag' value='<%=modify_flag%>'>
<input type='hidden' name='gender' id='gender' value='<%=patient_gender%>'>
<input type='hidden' name='patient_age' id='patient_age' value='<%=patient_age%>'>
<input type='hidden' name='query_string' id='query_string' value='<%=query_string%>'>
<input type='hidden' name='params' id='params' value='<%=params%>'>
<input type='hidden' name='sys_date' id='sys_date' value='<%=sys_date%>'>
<input type='hidden' name='enable_rights_yn' id='enable_rights_yn' value='<%=enable_rights_yn%>'>
<input type='hidden' name='sel_triage_yn' id='sel_triage_yn' value='<%=sel_triage_yn%>'>
<input type='hidden' name='sel_cons_yn' id='sel_cons_yn' value='<%=sel_cons_yn%>'>
<input type='hidden' name='practitioner_id' id='practitioner_id' value='<%=practitioner_id%>'>
<input type='hidden' name='order_catalog_code1' id='order_catalog_code1' value='<%=order_catalog_code1%>'>
<input type='hidden' name='order_catalog_code2' id='order_catalog_code2' value='<%=order_catalog_code2%>'>
<input type='hidden' name='order_catalog_code3' id='order_catalog_code3' value='<%=order_catalog_code3%>'>
<input type='hidden' name='order_catalog_code4' id='order_catalog_code4' value='<%=order_catalog_code4%>'>
<input type='hidden' name='order_catalog_code5' id='order_catalog_code5' value='<%=order_catalog_code5%>'>
<input type='hidden' name='order_id' id='order_id' value=''>
<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>

</form> 
<%}catch(Exception e){ e.toString(); }
}catch(Exception e){ e.toString(); }
	finally {
		           ConnectionManager.returnConnection(con,request);  
		    }
%>
<script>
/* code for populating values onload in treatmentarea and mechanical injury sub category list boxes Added on 02/12/2004*/
setInjury(document.forms[0].mechan_injury);
 //window.setTimeout('setTreatment(document.forms[0].priority_zone)',200);
</script>
</body>
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}
%>
</html>

