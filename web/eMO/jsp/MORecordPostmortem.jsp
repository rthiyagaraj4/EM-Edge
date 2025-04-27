<!DOCTYPE html>

<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %> <!--json  by mujafar for ML-MMOH-CRF-0880 -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head> 
	<%
String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");
String facility_id=	(String)	 session.getValue("facility_id");
String locale=(String)session.getAttribute("LOCALE");
Connection con 					= null;
Statement stmt						= null;
PreparedStatement  pstmt         =null;
ResultSet rset					    = null;
String autopsyno="";
String diag_code			= "";
String diag_desc			= "";
String pm_performed_by="";
String pm_performed_by_name="";
String role_for_practitioner="";
String pm_performed_by_desg="";
int tissuecnt=0;
String  body_received_date    ="";
String  pm_requested_by="";
String pm_requested_by_name="";
String  postmortem_type="";
String  postmortem_type_desc="";
String postmortem_status="";
String sys_date="";
String pm_purpose="";
String postmortem_findings="";
String specimen_collected_by="";
String encounter_id="";
String patient_class="";
String patient_id="";



String specimen_collected_by_name="";
String specimen_handed_over_date="";
String specimen_handed_over_to="";
String postmortem_start_date_time="";
String postmortem_end_date_time="";
String body_part_obtained_from_disable="";
String tissue_procured_by_name="";        
String tissue_procured_by="";             
String tissue_procure_performed_date="";  
String team_ind_id="";
String freetextpract[]=new String[4];	
String freetextpractname[]=new String[4];	
String freetextdese[]=new String[4];	
String freetextrole[]=new String[4];

String pract[]=new String[5];	
String dese[]=new String[5];	
String role[]=new String[5];	
String practname[]=new String[5];
String ddesc[]=new String[3];
String dcode[]=new String[3];
String onsetdate[]=new String[3];
String dcause[]=new String[3]; 			//bru-hims-crf-270
String ddesc1[]=new String[3];
String dcode1[]=new String[3];
String onsetdate1[]=new String[3];
String tisprocdis="";
String ddesc2[]=new String[5];
String dcode2[]=new String[5];
String onsetdate2[]=new String[5];
String dcause2[]=new String[5]; 		//bru-hims-crf-270

String findingtype[]=new String[8];	 	//bru-hims-crf-270
String diagdesc[]=new String[8];		//bru-hims-crf-270
String diagcode[]=new String[8];		//bru-hims-crf-270
String onsetdatetime[]=new String[8]; 	//bru-hims-crf-270
String diagcause[]=new String[8];		//bru-hims-crf-270

String specdesc[]=new String[6];	
String spectype[]=new String[6];	
String anatomsite[]=new String[6];	
String anatomsitedesc[]=new String[6];
String colectdate[]=new String[6];


String pm_certified_by="";
String pm_certified_by_desc="";
String actual_death_manner_code="";
String postmortem_finding="";
String witness[]=new String[2];	
String witnessdese[]=new String[2];	
String witnessname[]=new String[2];	
//String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String registration_no=request.getParameter("regn_no")==null?"":request.getParameter("regn_no");
String viewdata=request.getParameter("viewdata")==null?"":request.getParameter("viewdata");

String body_part_obtained_from="";
String age="";
String date_of_birth="";
String deceased_yn="";

String death_manner_code="";
String death_manner_code_yn="";
String examination_type = "";   //Added by Mano against ML-MMOH-CRF-0791


ddesc[0]="";			
dcode[0]="";			
onsetdate[0]="";		
dcause[0]="";			//bru-hims-crf-270
freetextpract[0]="";
freetextpractname[0]="";
freetextdese[0]="";
freetextrole[0]="";

freetextpract[1]="";
freetextpractname[1]="";
freetextdese[1]="";
freetextrole[1]="";

freetextpract[2]="";
freetextpractname[2]="";
freetextdese[2]="";
freetextrole[2]="";


ddesc1[1]="";
dcode1[1]="";
onsetdate1[1]="";

ddesc2[2]="";		
dcode2[2]="";		
onsetdate2[2]="";	
dcause2[2]="";		//bru-hims-crf-270

specdesc[0]="";
specdesc[1]="";
specdesc[2]="";
specdesc[3]="";
specdesc[4]="";
specdesc[5]="";

spectype[0]="";
spectype[1]="";
spectype[2]="";
spectype[3]="";
spectype[4]="";
spectype[5]="";

anatomsitedesc[0]="";
anatomsitedesc[1]="";
anatomsitedesc[2]="";
anatomsitedesc[3]="";
anatomsitedesc[4]="";
anatomsitedesc[5]="";


anatomsite[0]="";
anatomsite[1]="";
anatomsite[2]="";
anatomsite[3]="";
anatomsite[4]="";
anatomsite[5]="";


colectdate[0]="";
colectdate[1]="";
colectdate[2]="";
colectdate[3]="";
colectdate[4]="";
colectdate[5]="";





findingtype[0]="";
findingtype[1]="";
findingtype[2]="";
findingtype[3]="";
findingtype[4]="";
findingtype[5]="";
findingtype[6]=""; 	//bru-hims-crf-270
findingtype[7]="";	//bru-hims-crf-270
diagdesc[0]="";
diagdesc[1]="";
diagdesc[2]="";
diagdesc[3]="";
diagdesc[4]="";
diagdesc[5]="";
diagdesc[6]="";		//bru-hims-crf-270
diagdesc[7]="";		//bru-hims-crf-270
diagcode[0]="";
diagcode[1]="";
diagcode[2]="";
diagcode[3]="";
diagcode[4]="";
diagcode[5]="";
diagcode[6]="";		//bru-hims-crf-270
diagcode[7]="";		//bru-hims-crf-270
onsetdatetime[0]="";
onsetdatetime[1]="";
onsetdatetime[2]="";
onsetdatetime[3]="";
onsetdatetime[4]="";
onsetdatetime[5]="";
onsetdatetime[6]="";    //bru-hims-crf-270
onsetdatetime[7]="";	//bru-hims-crf-270

diagcause[0]="";		//bru-hims-crf-270
diagcause[1]="";		//bru-hims-crf-270
diagcause[2]="";		//bru-hims-crf-270
diagcause[3]="";		//bru-hims-crf-270
diagcause[4]="";		//bru-hims-crf-270
diagcause[5]="";		//bru-hims-crf-270
diagcause[6]="";		//bru-hims-crf-270
diagcause[7]="";		//bru-hims-crf-270

practname[0]="";
practname[1]="";
practname[2]="";
practname[3]="";
practname[4]="";
pract[0]="";
pract[1]="";
pract[2]="";
pract[3]="";
pract[4]="";
role[0]="";
role[1]="";
role[2]="";
role[3]="";
role[4]="";
dese[0]="";
dese[1]="";
dese[2]="";
dese[3]="";
dese[4]="";
witness[0]="";
witnessname[0]="";
witnessdese[0]="";
witness[1]="";
witnessname[1]="";
witnessdese[1]="";
try
  {
     	con = ConnectionManager.getConnection(request);
		
		boolean site_specific_exam_type = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","EXAMINATION_TYPE");
		/* added by mujafar for ML-MMOH-CRF-0880 start */
		boolean  isPMFindingDetailsAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MO","PM_FINDING_DETAILS_ALLOW_YN");
		String  record_pm_find_dtls_yn = "";
		
		JSONObject json = new JSONObject();
		
		json = eMO.MOCommonBean.getMOParam(con,facility_id);
		record_pm_find_dtls_yn = (String)json.get("record_pm_find_dtls_yn");
		/* end */
		pstmt  = con.prepareStatement("select to_char(sysdate,'dd/mm/yyyy hh24:mi') from dual");
        rset = pstmt.executeQuery();
        if (rset!=null)
        {
            while (rset.next())
            {
                sys_date = rset.getString(1);
				
            }
        }if (rset!=null) rset.close();
		 if(pstmt!=null) pstmt.close();

	 
	 stmt	= con.createStatement();
	 rset	= stmt.executeQuery("SELECT DECODE(DIAG_CODE_SCHEME,'1','ICD 10','2','ICD 9CM') SCHEME_DESC, DIAG_CODE_SCHEME FROM MR_PARAMETER");
		
	if ((rset != null) && (rset.next()))
	{
		diag_code = rset.getString("DIAG_CODE_SCHEME");
		diag_desc = rset.getString("SCHEME_DESC");

	}
   if(rset!=null)  rset.close();
   if(stmt!=null)  stmt.close();
	

pstmt = con.prepareStatement("select count(*) cnt from mo_organ_donation_regn_vw where registration_no='"+registration_no+"' and facility_id='"+facility_id+"'");
rset=pstmt.executeQuery();
//int chkyn=0;
if(rset.next())
{
tissuecnt=rset.getInt("cnt");

 }if(pstmt!=null)pstmt.close();
 if(rset!=null)rset.close();

     stmt	= con.createStatement();
	 //rset	= stmt.executeQuery("SELECT postmortem_finding,AUTOPSY_NO, tissue_procured_by_name,tissue_procured_by,tissue_procure_performed_date, specimen_collected_by,specimen_collected_by_name,specimen_handed_over_date,specimen_handed_over_to ,BODY_RECEIVED_DATE,POSTMORTEM_TYPE_DESC,PM_REQUESTED_BY,pm_requested_by_name,POSTMORTEM_START_DATE_TIME,POSTMORTEM_END_DATE_TIME,PM_PURPOSE,PM_CERTIFIED_BY,PM_CERTIFIED_BY_NAME,ACTUAL_DEATH_MANNER_CODE,DEATH_MANNER_CODE,POSTMORTEM_FINDING,BODY_PART_OBTAINED_FROM,FACILITY_ID,PM_PERFORMED_BY, PM_PERFORMED_BY_NAME,ROLE_FOR_PRACTITIONER,PM_PERFORMED_BY_DESG FROM mo_mortuary_regn_vw where registration_no='"+registration_no+"' and facility_id='"+facility_id+"' " );
	
	
     /*Below line(s) added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]*/
	 /*Below line(s) added by Mano on 28-sep-2017 against ML-MMOH-crf-0791*/
	String sql="SELECT postmortem_finding,AUTOPSY_NO,  am_get_desc.AM_PRACTITIONER(tissue_procured_by,'"+localeName+"','2')  tissue_procured_by_name,tissue_procured_by,tissue_procure_performed_date, specimen_collected_by, am_get_desc.AM_PRACTITIONER(specimen_collected_by,'"+localeName+"','2')  specimen_collected_by_name,specimen_handed_over_date,specimen_handed_over_to ,BODY_RECEIVED_DATE,postmortem_type,PM_REQUESTED_BY,	 am_get_desc.AM_PRACTITIONER(PM_REQUESTED_BY,'"+localeName+"','2') pm_requested_by_name,POSTMORTEM_START_DATE_TIME,POSTMORTEM_END_DATE_TIME,PM_PURPOSE,PM_CERTIFIED_BY,am_get_desc.AM_PRACTITIONER(PM_CERTIFIED_BY,'"+localeName+"','2') PM_CERTIFIED_BY_NAME,ACTUAL_DEATH_MANNER_CODE,DEATH_MANNER_CODE,POSTMORTEM_FINDING,BODY_PART_OBTAINED_FROM,FACILITY_ID,PM_PERFORMED_BY, am_get_desc.AM_PRACTITIONER(PM_PERFORMED_BY,'"+localeName+"','2') PM_PERFORMED_BY_NAME,ROLE_FOR_PRACTITIONER, am_get_desc.AM_PRACTITIONER(PM_PERFORMED_BY,'"+localeName+"','2') PM_PERFORMED_BY_DESG,encounter_id,patient_class,patient_id,postmortem_status,age,date_of_birth,deceased_yn,EXAMINATION_TYPE FROM mo_mortuary_regn_vw where registration_no='"+registration_no+"' and facility_id='"+facility_id+"' ";
	
     
	rset	= stmt.executeQuery(sql);
	

	
	if (rset.next())
	{   
		autopsyno=rset.getString("AUTOPSY_NO")==null?"":rset.getString("AUTOPSY_NO");
        pm_performed_by=rset.getString("PM_PERFORMED_BY")==null?"":rset.getString("PM_PERFORMED_BY");
        pm_performed_by_name=rset.getString("PM_PERFORMED_BY_NAME")==null?"":rset.getString("PM_PERFORMED_BY_NAME");
        role_for_practitioner=rset.getString("ROLE_FOR_PRACTITIONER")==null?"":rset.getString("ROLE_FOR_PRACTITIONER");
        pm_performed_by_desg=rset.getString("PM_PERFORMED_BY_DESG")==null?"":rset.getString("PM_PERFORMED_BY_DESG");
  		tissue_procured_by_name = rset.getString("tissue_procured_by_name")==null?"":rset.getString("tissue_procured_by_name");
     
	
		tissue_procured_by = rset.getString("tissue_procured_by")==null?"":rset.getString("tissue_procured_by");

		tissue_procure_performed_date = rset.getString("tissue_procure_performed_date")==null?"":rset.getString("tissue_procure_performed_date");

		if(tissue_procure_performed_date!=null && !tissue_procure_performed_date.equals(""))
			tissue_procure_performed_date = DateUtils.convertDate(tissue_procure_performed_date,"DMYHM","en",localeName); 


           
	    pm_requested_by_name= rset.getString("pm_requested_by_name")==null?"":rset.getString("pm_requested_by_name");
         postmortem_findings= rset.getString("postmortem_finding")==null?"":rset.getString("postmortem_finding");
		specimen_collected_by = rset.getString("specimen_collected_by")==null?"":rset.getString("specimen_collected_by");
		patient_id = rset.getString("patient_id")==null?"":rset.getString("patient_id");
		patient_class = rset.getString("patient_class")==null?"":rset.getString("patient_class");
		encounter_id = rset.getString("encounter_id")==null?"":rset.getString("encounter_id");

		


		
		specimen_handed_over_to = rset.getString("specimen_handed_over_to")==null?"":rset.getString("specimen_handed_over_to");
		
		
		specimen_collected_by_name = rset.getString("specimen_collected_by_name")==null?"":rset.getString("specimen_collected_by_name");
		
		specimen_handed_over_date = rset.getString("specimen_handed_over_date")==null?"":rset.getString("specimen_handed_over_date");
		if(specimen_handed_over_date!=null && !specimen_handed_over_date.equals(""))
			specimen_handed_over_date = DateUtils.convertDate(specimen_handed_over_date,"DMYHM","en",localeName); 

		body_received_date = rset.getString("BODY_RECEIVED_DATE")==null?"":rset.getString("BODY_RECEIVED_DATE");
		if(body_received_date!=null && !body_received_date.equals(""))
			body_received_date = DateUtils.convertDate(body_received_date,"DMYHM","en",localeName); 
		postmortem_type = rset.getString("postmortem_type")==null?"":rset.getString("postmortem_type");
		if(postmortem_type!=null && !postmortem_type.equals("") && postmortem_type.equals("M"))
			postmortem_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.MedicoLegal.label","mo_labels");
		else if(postmortem_type!=null && !postmortem_type.equals("") && postmortem_type.equals("C"))
			postmortem_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.Clinical.label","mo_labels");


        pm_requested_by= rset.getString("PM_REQUESTED_BY")==null?"":rset.getString("PM_REQUESTED_BY");
        pm_purpose=rset.getString("PM_PURPOSE")==null?"":rset.getString("PM_PURPOSE");
	    postmortem_start_date_time=rset.getString("postmortem_start_date_time")==null?"":rset.getString("postmortem_start_date_time");
		if(postmortem_start_date_time!=null && !postmortem_start_date_time.equals(""))
			postmortem_start_date_time = DateUtils.convertDate(postmortem_start_date_time,"DMYHM","en",localeName); 

		body_part_obtained_from=rset.getString("body_part_obtained_from")==null?"N":rset.getString("body_part_obtained_from");
		body_part_obtained_from_disable=rset.getString("body_part_obtained_from")==null?"":rset.getString("body_part_obtained_from");
	    postmortem_end_date_time=rset.getString("POSTMORTEM_END_DATE_TIME")==null?"":rset.getString("POSTMORTEM_END_DATE_TIME");
		if(postmortem_end_date_time!=null && !postmortem_end_date_time.equals(""))
			postmortem_end_date_time = DateUtils.convertDate(postmortem_end_date_time,"DMYHM","en",localeName); 

	

		pm_certified_by=rset.getString("PM_CERTIFIED_BY")==null?"":rset.getString("PM_CERTIFIED_BY");
	  pm_certified_by_desc=rset.getString("PM_CERTIFIED_BY_NAME")==null?"":rset.getString("PM_CERTIFIED_BY_NAME");
		actual_death_manner_code=rset.getString("ACTUAL_DEATH_MANNER_CODE")==null?"":rset.getString("ACTUAL_DEATH_MANNER_CODE");
	  if(body_part_obtained_from_disable.equals(""))
		{
		body_part_obtained_from_disable="";
		}else
		{
		body_part_obtained_from_disable="disabled";
		}
	
	 /* Below line(s) added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572] */ 
	 death_manner_code=rset.getString("DEATH_MANNER_CODE")==null?"":rset.getString("DEATH_MANNER_CODE");
	 
	 if(!death_manner_code.equals("")){
	  death_manner_code_yn="disabled";
      } 
	 
     if(actual_death_manner_code.equals(""))
	 {
	 actual_death_manner_code=death_manner_code;
	 } 
      
	postmortem_finding=rset.getString("POSTMORTEM_FINDING")==null?"":rset.getString("POSTMORTEM_FINDING");
	//below line added by Mano Aganist ML-MMOH-CRF-0791
    examination_type=rset.getString("EXAMINATION_TYPE")==null?"N":rset.getString("EXAMINATION_TYPE");  //Mano aganist ML-MMOH-CRF-0791
		
	postmortem_status=rset.getString("postmortem_status")==null?"":rset.getString("postmortem_status");
	age = rset.getString("age")==null?"":rset.getString("age");
	date_of_birth = rset.getString("date_of_birth")==null?"":rset.getString("date_of_birth");
	deceased_yn = rset.getString("deceased_yn")==null?"N":rset.getString("deceased_yn");
	
	}
   if(rset!=null)  rset.close();
   if(stmt!=null)  stmt.close();
	
  int count=0;
   stmt	= con.createStatement(); 
   rset	= stmt.executeQuery("SELECT count(*) cnt from mo_postmortem_team_vw where registration_no='"+registration_no+"' and facility_id='"+facility_id+"'");
   if (rset.next())
  {
  count=rset.getInt("cnt");
  }
   if(rset!=null)  rset.close();
   if(stmt!=null)  stmt.close();

  stmt	= con.createStatement();
  //rset	= stmt.executeQuery("SELECT PRACTITIONER_ID,PRACTITIONER_NAME,POSITION_DESC,ROLE_FOR_PRACTITIONER,TEAM_IND  from mo_postmortem_team_vw where registration_no='"+registration_no+"'and facility_id='"+facility_id+"' order by PRACTITIONER_ID");

   rset	= stmt.executeQuery("SELECT PRACTITIONER_ID,AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+localeName+"','2') PRACTITIONER_NAME,POSITION_DESC,ROLE_FOR_PRACTITIONER,TEAM_IND  from mo_postmortem_team_vw where registration_no='"+registration_no+"'and facility_id='"+facility_id+"' order by PRACTITIONER_ID");

int freetxtcnt=0;
int practcnt=0;
	while (rset.next())
	{ 

	/*for(int i=0;i<count;i++)
	{*/
    team_ind_id=rset.getString("TEAM_IND");  
	if(team_ind_id.equals("1"))
	{
	pract[practcnt]=rset.getString("PRACTITIONER_ID");  
	if(pract[practcnt]==null)pract[practcnt]="";
	
	practname[practcnt]=rset.getString("PRACTITIONER_NAME");  
	if(practname[practcnt]==null)practname[practcnt]="";
	
	dese[practcnt]= rset.getString("POSITION_DESC");  	
	if(dese[practcnt]==null)dese[practcnt]="";

	role[practcnt]=rset.getString("ROLE_FOR_PRACTITIONER");
	if(role[practcnt]==null)role[practcnt]="";
	

	practcnt++;
	}else
	{
	freetextpract[freetxtcnt]=rset.getString("PRACTITIONER_ID");  
	if(freetextpract[freetxtcnt]==null)freetextpract[freetxtcnt]="";
	
	freetextpractname[freetxtcnt]=rset.getString("PRACTITIONER_NAME");  
	if(freetextpractname[freetxtcnt]==null)freetextpractname[freetxtcnt]="";
	
	freetextdese[freetxtcnt]= rset.getString("POSITION_DESC");  	
	if(freetextdese[freetxtcnt]==null)freetextdese[freetxtcnt]="";

	freetextrole[freetxtcnt]=rset.getString("ROLE_FOR_PRACTITIONER");
	if(freetextrole[freetxtcnt]==null)freetextrole[freetxtcnt]="";
	

	 freetxtcnt++;
	
	}
	//rset.next();
	/*}*/

	
	}
 
  if(rset!=null)  rset.close();
   if(stmt!=null)  stmt.close();

     count=0;
   stmt	= con.createStatement(); 
   rset	= stmt.executeQuery("SELECT count(*) cnt from mo_postmortem_finding where registration_no='"+registration_no+"' and facility_id='"+facility_id+"'");
   if (rset.next())
  {
  count=rset.getInt("cnt");
  }
   if(rset!=null)  rset.close();
   if(stmt!=null)  stmt.close();
// mo_postmortem_finding_vw removed and mo_postmortem_finding replaced for IN032171 by Kamakshi N on 09.05.2012
  stmt	= con.createStatement();
  rset	= stmt.executeQuery("SELECT FINDING_TYPE,TERM_CODE_SHORT_DESC TERM_CODE_DESC,TERM_CODE,TO_CHAR (ONSET_RECORDED_DATE,'dd/mm/yyyy hh24:mi') ONSET_RECORDED_DATE,TERM_CODE_CAUSE  from mo_postmortem_finding where registration_no='"+registration_no+"'and facility_id='"+facility_id+"' order by FINDING_TYPE " );
	//TERM_CODE_CAUSE Added for this CRF bru-hims-crf-270
	if (rset.next())
	{ 

	for(int i=0;i<count;i++)
	{

	findingtype[i]=rset.getString("FINDING_TYPE");  
	if(findingtype[i]==null)findingtype[i]="";
	diagdesc[i]=rset.getString("TERM_CODE_DESC");  
	if(diagdesc[i]==null)diagdesc[i]="";
	diagcode[i]= rset.getString("TERM_CODE");
	if(diagcode[i]==null)diagcode[i]="";
	diagcause[i]= rset.getString("TERM_CODE_CAUSE");  	
	if(diagcause[i]==null)diagcause[i]="";
	onsetdatetime[i]=rset.getString("ONSET_RECORDED_DATE");
	if(onsetdatetime[i]==null)onsetdatetime[i]="";

	if(onsetdatetime[i]!=null && !onsetdatetime[i].equals(""))
			onsetdatetime[i] = DateUtils.convertDate(onsetdatetime[i],"DMYHM","en",localeName); 
	
	rset.next();
	}

	}
if(stmt!=null)stmt.close();
 if(rset!=null)rset.close();

   count=0;
   stmt	= con.createStatement(); 
   rset	= stmt.executeQuery("SELECT count(*) cnt from mo_specimen_collection_vw where registration_no='"+registration_no+"' and facility_id='"+facility_id+"'");
   if (rset.next())
  {
  count=rset.getInt("cnt");
  }
   if(rset!=null)  rset.close();
   if(stmt!=null)  stmt.close();

  stmt	= con.createStatement();
  rset	= stmt.executeQuery("SELECT SPECIMENT_DESC,SPECIMEN_TYPE,ANATOMICAL_SITE_CODE,ANATOMICAL_SITE_DESC,COLLECTED_DATE  from mo_specimen_collection_vw where registration_no='"+registration_no+"'and facility_id='"+facility_id+"'");

  
	if (rset.next())
	{ 

	for(int i=0;i<count;i++)
	{

	specdesc[i]=rset.getString("SPECIMENT_DESC");  
	if(specdesc[i]==null)specdesc[i]="";
	spectype[i]=rset.getString("SPECIMEN_TYPE");  
	if(spectype[i]==null)spectype[i]="";
	anatomsite[i]= rset.getString("ANATOMICAL_SITE_CODE");  	
	if(anatomsite[i]==null)anatomsite[i]="";
	anatomsitedesc[i]=rset.getString("ANATOMICAL_SITE_DESC");
	if(anatomsitedesc[i]==null)anatomsitedesc[i]="";
	colectdate[i]=rset.getString("COLLECTED_DATE");
	if(colectdate[i]==null)colectdate[i]="";
	if(colectdate[i]!=null && !colectdate[i].equals(""))
		colectdate[i] = DateUtils.convertDate(colectdate[i],"DMYHM","en",localeName); 
        
    rset.next();
	}

	}
  
  
  
  
  
  if(stmt!=null)stmt.close();
 if(rset!=null)rset.close();
  
  
  count=0;
   stmt	= con.createStatement(); 
   rset	= stmt.executeQuery("SELECT count(*) cnt from mo_postmortem_witness where registration_no='"+registration_no+"' and facility_id='"+facility_id+"'");
   if (rset.next())
  {
  count=rset.getInt("cnt");
  }
   if(rset!=null)  rset.close();
   if(stmt!=null)  stmt.close();
  stmt	= con.createStatement();
  rset	= stmt.executeQuery("select WITNESS_NAME,DESIGNATION from MO_POSTMORTEM_WITNESS where registration_no='"+registration_no+"'and facility_id='"+facility_id+"'");
	
	if (rset.next())
	{ 

	for(int i=0;i<count;i++)
	{

	witness[i]=rset.getString("WITNESS_NAME");  
	if(witness[i]==null)witness[i]="";

	witnessdese[i]=rset.getString("DESIGNATION");  
	if(witnessdese[i]==null)witnessdese[i]="";
	
	rset.next();
	}


	
	
	
	}
	if(rset!=null)  rset.close();
   if(stmt!=null)  stmt.close();
%>
	


    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
	<Script language="JavaScript" src="../../eCommon/js/DateUtils.js" ></Script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eMO/js/MOManageDeceased.js'></script>	
	<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	
 </head>
  
 <body OnMouseDown='CodeArrest()' onLoad="enablePMDtls('<%=body_received_date%>','<%=postmortem_start_date_time%>');enableSpecGif();" onKeyDown="lockKey()" >	 
 <form name="MORecordPostmortem" id="MORecordPostmortem"  action="../../servlet/eMO.MOManageDeceasedAssignAreaServlet"  method="post" target="messageFrame" >

<!-- 
 <a name="tab1"   onFocus='javascript:AEScrollIntoView(1);'></a>
 <table width='100%' cellpadding='0' cellspacing='0' BORDER='0' >
 <tr><td width='1%' class='BODYCOLORFILLED'></td><td  class='BODYCOLORFILLED' >&nbsp;&nbsp;<a align ='left' href="javascript:AEScrollIntoView(1)" style="cursor:pointer;" ><img src='../../eMO/images/Registration.gif' border=0 ></a>
 <a align='left' href="javascript:AEScrollIntoView(2)"><img   src="../../eMO/images/FindingsClick.gif" border=0 id='hidetab2'  style="visibility:hidden"></a>
 <a align='left' href="javascript:AEScrollIntoView(3)" tabindex='-1' ><img src="../../eMO/images/SpecimenClick.gif" id='hidetab3' style="visibility:hidden" border=0></a>
 <a align='left'  href="javascript:AEScrollIntoView(4)" tabindex='-1' ><img src="../../eMO/images/TissueProcurementClick.gif" id='hidetab4' style="visibility:hidden" border=0></a>&nbsp;
 </td>
 </tr> 
 </table>

 -->

<a name="tab1"  tabindex='0' onFocus='javascript:AEScrollIntoView(1);'></a> 	
	<ul id="tablist" class="tablist">
		<li class="tablistitem" title="Registration">
			<a onclick="AEScrollIntoView(1)"  class="tabClicked" id="1" ><span class="tabSpanclicked " id="regs_tabspan"><fmt:message key="Common.Registration.label" bundle="${common_labels}"/></span>
			</a>
		</li>
		<li class="tablistitem" title="Find" id='hidetab2' style="display:none">
			<a onclick="AEScrollIntoView(2)" class="tabA" id="2" ><span class="tabASpan" ><fmt:message key="eMO.Finding.label" bundle="${mo_labels}"/></span>
			</a>
		</li>
		<li class="tablistitem" title="Specimen"  id='hidetab3'  style="visibility:hidden">
			<a onclick="AEScrollIntoView(3)" class="tabA" id="3" ><span class="tabASpan"><fmt:message key="Common.Specimen.label" bundle="${common_labels}"/></span>
			</a>
		</li>
		<li class="tablistitem" title="TissueProcurement" id='hidetab4' style="visibility:hidden">
			<a onclick="AEScrollIntoView(4)" class="tabA" id="4" ><span class="tabASpan" ><fmt:message key="eMO.TissueProcurement.label" bundle="${mo_labels}"/></span>
			</a>
		</li>
	</ul>
 <table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'>
 <tr> 	  
 <td class='label' width='30%'><fmt:message key="eMO.PMRequestedBy.label" bundle="${mo_labels}"/></td>
 <td width='30%' class='fields' ><INPUT TYPE="text" size=30 maxlength=30 onBLur="beforeGetPractitioner(this,'pract_but14',pract14)" name="pract_desc14" id="pract_desc14" value="<%=pm_requested_by_name%>"><input type='button' class='button'  name='pract_but14' id='pract_but14' value='?' onClick="getValues(this,pract_desc14,pract14)";><img src='../../eCommon/images/mandatory.gif'><input type=hidden name='pract14' id='pract14' value="<%=pm_requested_by%>"></td>
 <td class='label' width='30%'><fmt:message key="eMO.TypeOfPostmortem.label" bundle="${mo_labels}"/></td>
 <td  class='label' width='10%'><b><%=postmortem_type_desc%></b></td>
 </tr>
 <!-- <tr><td colspan=5>&nbsp;</Td></tr> -->
 <tr>
 <td class='label'><fmt:message key="eMO.PurposeForPrfmgPostMrtm.label" bundle="${mo_labels}"/></td>
 <td colspan='3' class='fields' ><TEXTAREA NAME="PM_PURPOSE" ROWS="2" COLS="50"><%=pm_purpose%></TEXTAREA><img src='../../eCommon/images/mandatory.gif'><!-- <INPUT TYPE="text" name="PM_PURPOSE" id="PM_PURPOSE" value="<%=pm_purpose%>"  maxlength=250 size=40 > --> </td></tr>
 <tr>
 <Td class='label' colspan='4'><b><fmt:message key="eMO.PostmortemPrfmdBy.label" bundle="${mo_labels}"/></b></Td>
 </tr>
 <tr>
 <th class='columnheader'><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></th>
 <th class='columnheader'><fmt:message key="Common.designation.label" bundle="${common_labels}"/></th> 
 <th class='columnheader' colspan='2'><fmt:message key="Common.Role.label" bundle="${common_labels}"/></Th>
 </tr> 
 <tr>
  <td class='fields'><INPUT TYPE="text" name="post_perf_pract_desc1" id="post_perf_pract_desc1" maxlength=30  onBlur="beforeGetPractitioner(this,'post_perf_pract_but',post_perf_pract1)" size=30 value="<%=pm_performed_by_name%>"><INPUT TYPE="hidden" name="post_perf_pract1" id="post_perf_pract1" value="<%=pm_performed_by%>"><input type='button' class='button' readOnly name='post_perf_pract_but' id='post_perf_pract_but' value='?' onClick="getValues(this,post_perf_pract_desc1,post_perf_pract1)";></td>
  <td class='fields'><INPUT TYPE="text" name="post_perf_desig_desc1" id="post_perf_desig_desc1" value="<%=pm_performed_by_desg%>"
  size=30  disabled></td>
  <td colspan='2' class='fields'><INPUT TYPE="text"  maxlength=15 name="post_perf_role1" id="post_perf_role1" value="<%=role_for_practitioner%>"><img src='../../eCommon/images/mandatory.gif'></img></td>
  </tr> 
 <tr>
 <Td colspan='4' class='label'><b><fmt:message key="eMO.PresentDrngPostmrtm.label" bundle="${mo_labels}"/></b></Td>
 </tr>
 <tr>
 <th class='columnheader'><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></th>
 <th class='columnheader'><fmt:message key="Common.designation.label" bundle="${common_labels}"/></th> 
 <th class='columnheader' colspan='2'><fmt:message key="Common.Role.label" bundle="${common_labels}"/></Th>
 </tr>
 <tr>
  <td class='fields'><INPUT TYPE="text" name="pract_desc1" id="pract_desc1" maxlength=30  onBlur="beforeGetPractitioner(this,'pract_but',pract1)" size=30 value="<%=practname[0]%>"><INPUT TYPE="hidden" name="pract1" id="pract1" value="<%=pract[0]%>"><input type='button' class='button' readOnly name='pract_but' id='pract_but' value='?' onClick="getValues(this,pract_desc1,pract1)";></td>
  <td class='fields'><INPUT TYPE="text" name="desig_desc1" id="desig_desc1" value="<%=dese[0]%>"
  size=30  disabled></td><td colspan='2' class='fields'><INPUT TYPE="text"  maxlength=15 name="role1" id="role1" value="<%=role[0]%>"></td>
  </tr>
  <tr>
  <td class='fields'><INPUT TYPE="text" name="pract_desc2" id="pract_desc2" maxlength=30 onBlur="beforeGetPractitioner(this,'pract_but1',pract2)" size=30 value="<%=practname[1]%>"><INPUT TYPE="hidden" name="pract2" id="pract2" value="<%=pract[1]%>"><input type='button' class='button' readOnly name='pract_but1' id='pract_but1' value='?' onClick="getValues(this,pract_desc2,pract2)";></td>
  <td class='fields'><INPUT TYPE="text" name="desig_desc2" id="desig_desc2" value="<%=dese[1]%>"size=30 disabled></td>
  <td colspan='2' class='fields'><INPUT TYPE="text" name="role2" id="role2" maxlength=15 value="<%=role[1]%>"></td>
  </tr>
  <tr>
  <td class='fields'><INPUT TYPE="text" name="pract_desc3" id="pract_desc3" maxlength=15  onBlur='PractLookupRetVal(this.value,this.name)'  value="<%=freetextpract[0]%>"  size=30></td>
  <input type=hidden name='pract3' id='pract3' value='ignore'>
  <td class='fields'><INPUT TYPE="text" name="desig_desc3" id="desig_desc3" value="<%=freetextdese[0]%>" size=30 ></td>
  <td colspan='2' class='fields'><INPUT TYPE="text" name="role3" id="role3" maxlength=15   value="<%=freetextrole[0]%>">
  </td>

  
 <!--  <td ><INPUT TYPE="text" name="pract_desc3" id="pract_desc3" maxlength=30 onBlur="beforeGetPractitioner(this,'pract_but3',pract3)" value="<%=practname[2]%>" size=30><INPUT TYPE="hidden" name="pract3" id="pract3" value="<%=pract[2]%>"><input type='button' class='button' readOnly name='pract_but3' id='pract_but3' value='?' onClick="getValues(this,pract_desc3,pract3)";></td>
  <td colspan=2 align=center><INPUT TYPE="text" name="desig_desc3" id="desig_desc3"  value="<%=dese[2]%>" size=30 disabled></td>
  <td colspan=2 align=center><INPUT TYPE="text" name="role3" id="role3" maxlength=15  value="<%=role[2]%>" ></td>
  --> </tr>
  <tr>

  <td class='fields'><INPUT TYPE="text" name="pract_desc4" id="pract_desc4" maxlength=15  onBlur='PractLookupRetVal(this.value,this.name)'  value="<%=freetextpract[1]%>"  size=30></td>
  <input type=hidden name='pract4' id='pract4' value='ignore'>
  <td class='fields'><INPUT TYPE="text" name="desig_desc4" id="desig_desc4" value="<%=freetextdese[1]%>" size=30 ></td>
  <td colspan='2' class='fields'><INPUT TYPE="text" name="role4" id="role4" maxlength=15   value="<%=freetextrole[1]%>">
  </td>
  </tr>
  <tr>
  <td class='fields'><INPUT TYPE="text" name="pract_desc5" id="pract_desc5" maxlength=15 value="<%=freetextpract[2]%>"  onBlur='PractLookupRetVal(this.value,this.name)' size=30></td>
  <td class='fields'><INPUT TYPE="text" name="desig_desc5" id="desig_desc5"  value="<%=freetextdese[2]%>" size=30 ></td>
	  <input type=hidden name='pract5' id='pract5' value='ignore'>
  <td colspan='2' class='fields'><INPUT TYPE="text" value="<%=freetextrole[2]%>" NAME="role5" maxlength=15 ></td>
</tr>
<tr>
<td colspan='4' class='label'><b><fmt:message key="eMO.BodyIdentifiedBy.label" bundle="${mo_labels}"/>:</b></td>
</tr>
<tr>
<th class='columnheader'><fmt:message key="Common.name.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
<th class='columnheader' colspan='2'></th>
</tr> 
 <tr>
  <td class='fields'><INPUT TYPE="text" name="pract6" id="pract6" value="<%=witness[0]%>" maxlength=30 size=30></td>
  <td class='fields'><INPUT TYPE="text" name="desi1" id="desi1"  maxlength=30 value="<%=witnessdese[0]%>"size=30 ></td>
  <td colspan='2' ></td>
  </tr>
  <tr>
  <td class='fields'><INPUT TYPE="text" name="pract7" id="pract7" value="<%=witness[1]%>"  maxlength=30 size=30></td>
  <td class='fields'><INPUT TYPE="text" name="desi2" id="desi2" maxlength=30 value="<%=witnessdese[1]%>"size=30 ></td>
  <td colspan='2' ></td> 
  </tr> 
 <tr>
	<th colspan='4' class='querydata'><fmt:message key="eMO.PostmortemStatus.label" bundle="${mo_labels}"/></th>
</tr>
 <tr>
 <td class='label'><fmt:message key="eMO.PatientCheckedInAt.label" bundle="${mo_labels}"/>&nbsp;</td>
 <td class='label'><b><%=body_received_date%></b></td>
 <td class='label'><fmt:message key="eMO.WaitTimeDuration.label" bundle="${mo_labels}"/></td>
 <td class='label'><label id=hrmindiff></label></td>
 </tr>
 <tr>
 <td class='label' ><fmt:message key="eMO.PMStartedAt.label" bundle="${mo_labels}"/></td>
 <td class='fields'><INPUT TYPE="text" name="pm_start_date_time" id="pm_start_date_time"  maxlength=16 value="<%=postmortem_start_date_time%>" onBlur='validateDate(this);'><img src="../../eCommon/images/CommonCalendar.gif" id='pmstart' onClick="document.forms[0]. pm_start_date_time.select();return showCalendar('pm_start_date_time', null, 'hh:mm' );" style="cursor='hand'"><img src='../../eCommon/images/mandatory.gif'></img></td>
 <td class='label' ><fmt:message key="eMO.ProcedureDuration.label" bundle="${mo_labels}"/></td>
 <td class='label'><label id=endhrmindiff></label></td>
 </tr>
 <tr>
 <td class='label' ><fmt:message key="eMO.PMCompletedAt.label" bundle="${mo_labels}"/></td>
 <td  class='fields'><INPUT TYPE="text" name="pm_end_date_time" id="pm_end_date_time" maxlength=16  readOnly onBlur='validateDate1(this);' value=	"<%=postmortem_end_date_time%>"><img src="../../eCommon/images/CommonCalendar.gif" id='pmcmpdis' disabled onClick="document.forms[0].pm_end_date_time.select();return showCalendar('pm_end_date_time', null, 'hh:mm' );" style="cursor='hand'"></td>
 <!--Below field added by Mano Aganist ML-MMOH-CRF-0791 -->
 <%if(site_specific_exam_type){%>
		<td class='label' ><fmt:message key="eMO.ExaminationType.label" bundle="${mo_labels}"/></td>
		<td class='fields'>
		<Select name='examination_type' id='examination_type'>
		<Option value='N' <%if(examination_type.equals("N")){%>selected<%}%>><fmt:message key="Common.none.label" bundle="${common_labels}"/></Option>
		<option value='I' <%if(examination_type.equals("I")){%>selected<%}%>><fmt:message key="eMO.InternalExamination.label" bundle="${mo_labels}"/></option>
	    <option value='E' <%if(examination_type.equals("E")){%>selected<%}%>><fmt:message key="eMO.ExternalExamination.label" bundle="${mo_labels}"/></option></td>
   <%}else{%>
		<input type="hidden" name='examination_type' id='examination_type' value = 'N'/>
 <%}%>
		<!--End of ML-MMOH-CRF-0791-->
 </tr>
<tr><td colspan='4'>&nbsp;<td></tr>
 </table> 
 <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
 

 <a name="tab4"  tabindex='11' onFocus='javascript:AEScrollIntoView(4);'></a> 	
	<ul id="tablist" class="tablist">
		<li class="tablistitem" title="Registration">
			<a onclick="AEScrollIntoView(1)"   class="tabA" id="1" ><span class="tabASpan"><fmt:message key="Common.Registration.label" bundle="${common_labels}"/></span>
			</a>
		</li>
		<li class="tablistitem" title="Find"  id='hidetab9' style="display:none"  > <!-- modified by mujafar for ML-MMOH-CRF-0880 -->
			<a onclick="AEScrollIntoView(2)"  class="tabA" id="2" ><span  class="tabASpan" ><fmt:message key="eMO.Finding.label" bundle="${mo_labels}"/></span>
			</a>
		</li>
		<li class="tablistitem" title="Specimen" >
			<a onclick="AEScrollIntoView(3)" class="tabA" id="3" ><span class="tabASpan"><fmt:message key="Common.Specimen.label" bundle="${common_labels}"/></span>
			</a>
		</li>
		<li class="tablistitem" title="TissueProcurement" id='hidetis7' style="if('<%=tissuecnt%>'>0) visibility:hidden;else visibility:visible">
			<a onclick="AEScrollIntoView(4)" class="tabClicked" id="4" ><span class="tabSpanclicked" ><fmt:message key="eMO.TissueProcurement.label" bundle="${mo_labels}"/></span>
			</a>
		</li>
	</ul>

	 <!-- <a name="tab4" tabindex='11' onfocus='javascript:AEScrollIntoView(2);' ></a>
	<table width='100%' cellpadding='0' cellspacing='0' BORDER='0'><tr><td width='1%' class='BODYCOLORFILLED'>&nbsp;&nbsp;&nbsp;&nbsp;<a align='left'href="javascript:AEScrollIntoView(1);" tabindex='-1'><img src="../../eMO/images/RegistrationClick.gif" border=0></a><a align='left' href="javascript:AEScrollIntoView(2)"><img  src="../../eMO/images/FindingsClick.gif" border=0 ></a><a align='left' href="javascript:AEScrollIntoView(3);" tabindex='-1' ><img src="../../eMO/images/SpecimenClick.gif"   border=0></a><a align='left' href="javascript:AEScrollIntoView(4)" tabindex='-1' ><img src="../../eMO/images/TissueProcurement.gif" id='hidetis7'  style="if('<%=tissuecnt%>'>0) visibility:hidden;else visibility:visible" border=0></a>&nbsp;</td></tr></table>	-->

<table width='100%' cellpadding='0' align=center cellspacing='0' BORDER='0'> 
<tr>
<th class='columnheader'><fmt:message key="eMO.OrgansLstdForProcmnt.label" bundle="${mo_labels}"/></th>
<th class='columnheader'><fmt:message key="eMO.TissueProcured.label" bundle="${mo_labels}"/></th>
<th colspan=2 class='columnheader'><fmt:message key="eMO.ProcurementTime.label" bundle="${mo_labels}"/></th>

</tr>

	 
	  
 <%	int proccnt=0;
 String tissue_procurement_date="";
if(stmt!=null)stmt.close();
 if(rset!=null)rset.close();
//pstmt = con.prepareStatement("select ORGAN_CODE,ORGAN_DESC,TISSUE_PROCURED_YN,TISSUE_PROCUREMENT_DATE from mo_organ_donation_regn_vw where registration_no='"+registration_no+"' and facility_id='"+facility_id+"'");

pstmt = con.prepareStatement("select ORGAN_CODE,MO_GET_DESC.MO_ORGAN_FOR_DONATION(ORGAN_CODE,'"+localeName+"','2')  ORGAN_DESC,TISSUE_PROCURED_YN,TISSUE_PROCUREMENT_DATE from mo_organ_donation_regn_vw where registration_no='"+registration_no+"' and facility_id='"+facility_id+"'");

rset=pstmt.executeQuery();
int chkyn=0;
while(rset.next())
{ chkyn=1;
tissue_procurement_date= rset.getString("TISSUE_PROCUREMENT_DATE")==null?"":rset.getString("TISSUE_PROCUREMENT_DATE");
if(tissue_procurement_date!=null && !tissue_procurement_date.equals(""))
	tissue_procurement_date = DateUtils.convertDate(tissue_procurement_date,"DMYHM","en",localeName); 


%>	
  
<tr>
<td class='label'><B><%=rset.getString("ORGAN_DESC")%></B></td>
<td  class='fields'>
<%
	if(viewdata.equals("viewdata"))tisprocdis="disabled";
	if(rset.getString("TISSUE_PROCURED_YN").equals("Y")){%>	
<INPUT TYPE="checkbox" name="org<%=proccnt%>" id="org<%=proccnt%>" onClick="clearTissueProc(this,tissue<%=proccnt%>,'tis<%=proccnt%>','tissueimg<%=proccnt%>')" checked <%=tisprocdis%> value='<%=rset.getString("ORGAN_CODE")%>'> </td>
<%}else{%>
	<INPUT TYPE="checkbox" name="org<%=proccnt%>" id="org<%=proccnt%>"  <%=tisprocdis%> onClick="clearTissueProc(this,tissue<%=proccnt%>,'tis<%=proccnt%>','tissueimg<%=proccnt%>')" value='<%=rset.getString("ORGAN_CODE")%>'> </td>
<%}%>
<td class='fields' colspan='2' ><INPUT TYPE="text"  maxlength=16  disabled value='<%=tissue_procurement_date%>' NAME="tissue<%=proccnt%>" onBlur="validateDate1(this);">	<img src="../../eCommon/images/CommonCalendar.gif" disabled id='tis<%=proccnt%>' onClick="document.forms[0].tissue<%=proccnt%>.select();return showCalendar('tissue<%=proccnt%>', null, 'hh:mm' );" style="cursor='hand'"><img id='tissueimg<%=proccnt%>'  src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></td>	
</tr>
<%proccnt++;}%>
<tr><td class='label' colspan=4>&nbsp;</td></tr>
<tr><td class='label' colspan=4>&nbsp;</td></tr>
</table>
<table width='100%' align=center cellpadding='0' cellspacing='0' BORDER='0'>
<tr>	<td class='label' colspan=4>&nbsp;</td></tr>
<tr><td class='label' colspan=4>&nbsp;</td></tr>
<%if(chkyn>0){%>
<tr>
<td class='label' ><fmt:message key="eMO.PerformedBy.label" bundle="${mo_labels}"/>&nbsp;</td>
<td class='fields'><INPUT TYPE="text" name="tissue_procured_by" id="tissue_procured_by" size=40 maxlength=30 onBlur="beforeGetPractitioner(this,'pract_but13',pract13)" <%=tisprocdis%> value="<%=tissue_procured_by_name%>"><INPUT TYPE="hidden" name="pract13" id="pract13" value="<%=tissue_procured_by%>"><input type='button' class='button' <%=tisprocdis%> name='pract_but13' value='?' onClick="getValues(this,tissue_procured_by,pract13)";><img src='../../eCommon/images/mandatory.gif' id='imgenable6' style="visibility:hidden" ></td>
<td class='label' ><fmt:message key="Common.PerformedDate.label" bundle="${common_labels}"/></td>
<td class='fields'><INPUT TYPE="text" name="tissue_proc_date" id="tissue_proc_date"   <%=tisprocdis%> maxlength=16 value="<%=tissue_procure_performed_date%>"onBlur="validateDate1(this);"><img <%=tisprocdis%> src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].tissue_proc_date.select();return showCalendar('tissue_proc_date', null, 'hh:mm' );" style="cursor='hand'">&nbsp;<img src='../../eCommon/images/mandatory.gif' id='imgenable7' style="visibility:hidden"></td>

</tr>
<%}%>
<tr><td class='label' colspan=4>&nbsp;</td></tr>
<tr><td class='label' colspan=4>&nbsp;</td></tr>
</table>
 <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

 <a name="tab2"  onFocus='javascript:AEScrollIntoView(3);'></a> 	
	<ul id="tablist" class="tablist">
		<li class="tablistitem" title="Registration">
			<a onclick="AEScrollIntoView(1)"   class="tabA" id="1" ><span class="tabASpan" ><fmt:message key="Common.Registration.label" bundle="${common_labels}"/></span>
			</a>
		</li>
		<li class="tablistitem" title="Find" id='hidetab8' style="display:none"  > <!-- modified by mujafar for ML-MMOH-CRF-0880 -->
			<a onclick="AEScrollIntoView(2)"  class="tabA" id="2" ><span  class="tabASpan" ><fmt:message key="eMO.Finding.label" bundle="${mo_labels}"/></span>
			</a>
		</li>
		<li class="tablistitem" title="Specimen" >
			<a onclick="AEScrollIntoView(3)" class="tabClicked" id="3" ><span class="tabSpanclicked"><fmt:message key="Common.Specimen.label" bundle="${common_labels}"/></span>
			</a>
		</li>
		<li class="tablistitem" title="TissueProcurement" id='hidetis5' style="visibility:hidden">
			<a onclick="AEScrollIntoView(4)" class="tabA" id="4" ><span class="tabASpan" ><fmt:message key="eMO.TissueProcurement.label" bundle="${mo_labels}"/></span>
			</a>
		</li>
	</ul>

<!--<a name="tab2"  onFocus='javascript:AEScrollIntoView(3);'></a> 
<table width='100%' cellpadding='0'   cellspacing='0' BORDER='0'><tr><td width='1%' class='BODYCOLORFILLED'></td><td width='50%' class='BODYCOLORFILLED'>&nbsp;<a align ='left' href="javascript:AEScrollIntoView(1)"><img src="../../eMO/images/RegistrationClick.gif" border=0></a><a align='left' href="javascript:AEScrollIntoView(2)" tabindex='-1'><img src="../../eMO/images/FindingsClick.gif" border=0  ></a><a align='left'  href="javascript:AEScrollIntoView(3)" tabindex='-1' ><img src="../../eMO/images/Specimen.gif" border=0></a><a align='left'  href="javascript:AEScrollIntoView(4)" tabindex='-1' ><img src="../../eMO/images/TissueProcurementClick.gif" id='hidetis5' style="visibility:hidden" border=0></a></td></tr>
</table>-->

<table cellspacing='0' cellpadding='2' width='100%' border=0 align='center'>
 
 
<tr><td colspan=4 class='label' ><b><fmt:message key="eMO.DetlsofSpeciCollected.label" bundle="${mo_labels}"/>:</b></td></tr>	
  <tr>
  <th class='columnheader' width='25%'><fmt:message key="eMO.SpecimenDescription.label" bundle="${mo_labels}"/></th>
  <th class='columnheader' width='25%'><fmt:message key="Common.SpecimenType.label" bundle="${common_labels}"/></th>
  <th class='columnheader' width='25%'><fmt:message key="Common.AnatomicalSite.label" bundle="${common_labels}"/></th>
  <th class='columnheader' width='25%'><fmt:message key="eMO.CollectionTime.label" bundle="${mo_labels}"/></th>
  </tr>
 <tr>
  <td class='fields' width='25%'><INPUT TYPE="text" name="speci_desc1" id="speci_desc1"  onblur="enableSpecGif();" maxlength=40 value="<%=specdesc[0]%>" ><img id='specimagae1'  src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></td></td>
  <td class='fields' width='25%'><INPUT TYPE="text" name="speci_type1" id="speci_type1"   onblur="enableSpecGif();" maxlength=50 value="<%=spectype[0]%>"><img id='specitypeimage1'  src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></td>
  <td class='fields' width='25%'><INPUT TYPE="text" name="anotomical_site_desc1" id="anotomical_site_desc1"   maxlength=30 onblur=" beforeAnotomicalSiteClick(this,'anot1');enableSpecGif();" value="<%=anatomsitedesc[0]%>"  ><input type='button' class='button' readOnly name='anot1' id='anot1' value='?' onClick=" getAnotimicalDetail(this,'anotomical_site_desc1','anotomical_site_code1')";><img id='specanotimagae1'  src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></td>
  <td class='fields' width='25%'><INPUT TYPE="text" name="collection_time1" id="collection_time1"  maxlength=16  onBlur="validateDate1(this);enableSpecGif();" value="<%=colectdate[0]%>"><img src="../../eCommon/images/CommonCalendar.gif" id='col1' onClick="document.forms[0].collection_time1.select();return showCalendar('collection_time1', null, 'hh:mm' );" style="cursor='hand'"><img id='specollimagae1'  src='../../eCommon/images/mandatory.gif' style="visibility:hidden"><input type=hidden name='anotomical_site_code1' id='anotomical_site_code1' value="<%=anatomsite[0]%>"></td>
  </tr>
  <tr> 
  <td class='fields' ><INPUT TYPE="text" name="speci_desc2" id="speci_desc2"  onblur="enableSpecGif();"  maxlength=40 value="<%=specdesc[1]%>"><img id='specimagae2'  src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></td>
  <td class='fields' ><INPUT TYPE="text" name="speci_type2" id="speci_type2"   onblur="enableSpecGif();"maxlength=50 value="<%=spectype[1]%>" ><img id='specitypeimage2'  src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></td>
  <td class='fields' ><INPUT TYPE="text" name="anotomical_site_desc2" id="anotomical_site_desc2" maxlength=30 onblur=" beforeAnotomicalSiteClick(this,'anot2');enableSpecGif();" value="<%=anatomsitedesc[1]%>"><input type='button' class='button' readOnly name='anot2' id='anot2' value='?' onClick=" getAnotimicalDetail(this,'anotomical_site_desc2','anotomical_site_code2')";><img id='specanotimagae2'  src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></td>
  <td class='fields' ><INPUT TYPE="text" name="collection_time2" id="collection_time2" maxlength=16  onBlur="validateDate1(this); enableSpecGif();" value="<%=colectdate[1]%>"><img src="../../eCommon/images/CommonCalendar.gif" id='col2' onClick="document.forms[0].collection_time2.select();return showCalendar('collection_time2', null, 'hh:mm' );" style="cursor='hand'"><img id='specollimagae2'  src='../../eCommon/images/mandatory.gif' style="visibility:hidden"><input type=hidden name='anotomical_site_code2' id='anotomical_site_code2'  value="<%=anatomsite[1]%>"></td>
  </tr>
  <tr> 
  <td class='fields'><INPUT TYPE="text" name="speci_desc3" id="speci_desc3" onblur="enableSpecGif();" maxlength=40 value="<%=specdesc[2]%>"><img id='specimagae3'  src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></td>
  <td class='fields'><INPUT TYPE="text" name="speci_type3" id="speci_type3"  onblur="enableSpecGif();" maxlength=50 value="<%=spectype[2]%>"><img id='specitypeimage3'  src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></td>
  <td class='fields'><INPUT TYPE="text" name="anotomical_site_desc3" id="anotomical_site_desc3"  maxlength=30 onblur=" beforeAnotomicalSiteClick(this,'anot3');enableSpecGif();" value="<%=anatomsitedesc[2]%>"><input type='button' class='button' readOnly name='anot3' id='anot3' value='?'onClick=" getAnotimicalDetail(this,'anotomical_site_desc3','anotomical_site_code3')"><img id='specanotimagae3'  src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></td>
  <td class='fields'><INPUT TYPE="text" name="collection_time3" id="collection_time3" maxlength=16  onBlur="validateDate1(this);enableSpecGif();" value="<%=colectdate[2]%>"><img src="../../eCommon/images/CommonCalendar.gif" id='col3' onClick="document.forms[0].collection_time3.select();return showCalendar('collection_time3', null, 'hh:mm' );" style="cursor='hand'"><img id='specollimagae3'  src='../../eCommon/images/mandatory.gif' style="visibility:hidden"><input type=hidden name='anotomical_site_code3' id='anotomical_site_code3'  value="<%=anatomsite[2]%>"></td>
  </tr>
  <tr> 
  <td class='fields'><INPUT TYPE="text" name="speci_desc4" id="speci_desc4" onblur="enableSpecGif();" maxlength=40 value="<%=specdesc[3]%>"><img id='specimagae4'  src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></td>
  <td class='fields'><INPUT TYPE="text" name="speci_type4" id="speci_type4" onblur="enableSpecGif();" maxlength=50 value="<%=spectype[3]%>"><img id='specitypeimage4'  src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></td>
  <td class='fields'><INPUT TYPE="text" name="anotomical_site_desc4" id="anotomical_site_desc4"  maxlength=30  onblur=" beforeAnotomicalSiteClick(this,'anot4');enableSpecGif();" value="<%=anatomsitedesc[3]%>"><input type='button' class='button' readOnly name='anot4' id='anot4' value='?' onClick=" getAnotimicalDetail(this,'anotomical_site_desc4','anotomical_site_code4')";><img id='specanotimagae4'  src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></td>
  <td class='fields'><INPUT TYPE="text" name="collection_time4" id="collection_time4" maxlength=16  onBlur="validateDate1(this);enableSpecGif();" value="<%=colectdate[3]%>"><img src="../../eCommon/images/CommonCalendar.gif" id='col4' onClick="document.forms[0].collection_time4.select();return showCalendar('collection_time4', null, 'hh:mm' );" style="cursor='hand'"><img id='specollimagae4'    src='../../eCommon/images/mandatory.gif' style="visibility:hidden"><input type=hidden name='anotomical_site_code4' id='anotomical_site_code4'  value="<%=anatomsite[3]%>"></td>
  </tr>
  <tr> 
  <td class='fields'><INPUT TYPE="text" name="speci_desc5" id="speci_desc5" onblur="enableSpecGif();" maxlength=40 value="<%=specdesc[4]%>"><img id='specimagae5'  src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></td>
  <td class='fields'><INPUT TYPE="text" name="speci_type5" id="speci_type5"  onblur="enableSpecGif();" maxlength=50 value="<%=spectype[4]%>"><img id='specitypeimage5'  src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></td>
  <td class='fields'><INPUT TYPE="text" name="anotomical_site_desc5" id="anotomical_site_desc5"  maxlength=30 onblur="beforeAnotomicalSiteClick(this,'anot5');enableSpecGif();" value="<%=anatomsitedesc[4]%>"><input type='button' class='button' readOnly name='anot5' id='anot5' value='?' onClick=" getAnotimicalDetail(this,'anotomical_site_desc5','anotomical_site_code5')";><img id='specanotimagae5'  src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></td>
  <td class='fields'><INPUT TYPE="text" name="collection_time5" id="collection_time5" maxlength=16 onBlur="validateDate1(this);enableSpecGif();" value="<%=colectdate[4]%>" ><img src="../../eCommon/images/CommonCalendar.gif" id='col5' onClick="document.forms[0].collection_time5.select();return showCalendar('collection_time5', null, 'hh:mm' );" style="cursor='hand'"><img id='specollimagae5'  src='../../eCommon/images/mandatory.gif' style="visibility:hidden"><input type=hidden name='anotomical_site_code5' id='anotomical_site_code5'  value="<%=anatomsite[4]%>"></td>
  </tr>
  <tr> 
  <td class='fields'><INPUT TYPE="text" name="speci_desc6" id="speci_desc6"   maxlength=40 onblur="enableSpecGif();" value="<%=specdesc[5]%>"><img id='specimagae6'  src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></td>
  <td class='fields'><INPUT TYPE="text" name="speci_type6" id="speci_type6" onblur="enableSpecGif();" maxlength=50 value="<%=spectype[5]%>"><img id='specitypeimage6'  src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></td>
  <td class='fields'><INPUT TYPE="text" name="anotomical_site_desc6" id="anotomical_site_desc6"  maxlength=30 onblur="beforeAnotomicalSiteClick(this,'anot6');enableSpecGif();" value="<%=anatomsitedesc[5]%>"><input type='button' class='button' readOnly name='anot6' id='anot6' value='?'onClick=" getAnotimicalDetail(this,'anotomical_site_desc6','anotomical_site_code6')";><img id='specanotimagae6'  src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></td>
  <td class='fields'><INPUT TYPE="text" name="collection_time6" id="collection_time6" maxlength=16  onBlur="validateDate1(this);enableSpecGif();" value="<%=colectdate[5]%>"><img src="../../eCommon/images/CommonCalendar.gif" id='col6' onClick="document.forms[0].collection_time6.select();return showCalendar('collection_time6', null, 'hh:mm' );"style="cursor='hand'" ><img id='specollimagae6'  src='../../eCommon/images/mandatory.gif' style="visibility:hidden"><input type=hidden name='anotomical_site_code6' id='anotomical_site_code6'  value="<%=anatomsite[5]%>"></td>
  </tr>
  <tr><td colspan=4>&nbsp;</td></tr>
<tr><td class='label'><fmt:message key="Common.CollectedBy.label" bundle="${common_labels}"/></td>
<td colspan='3' class='fields'><INPUT TYPE="text" size=40 name="pract_desc12" id="pract_desc12" maxlength=30 onBlur="beforeGetPractitioner(this,'pract_but12',pract12)"  value="<%=specimen_collected_by_name%>"><INPUT TYPE="hidden" name="pract12" id="pract12" value="<%=specimen_collected_by%>"><input type='button' class='button' readOnly name='pract_but12' id='pract_but12' value='?' onClick="getValues(this,pract_desc12,pract12)";><img id='imgenable3'  src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></td>
</tr>
<tr>
<td class='label'><fmt:message key="eMO.SpecimenHandedOverTo.label" bundle="${mo_labels}"/></td>
<td class='fields'><INPUT TYPE="text" name="spec_handed_over_to" id="spec_handed_over_to"  maxlength=30 value="<%=specimen_handed_over_to%>"><img src='../../eCommon/images/mandatory.gif' style="visibility:hidden" id='imgenable4' ></td>
<td class='label'><fmt:message key="eMO.SpecimenHandedDateTime.label" bundle="${mo_labels}"/></td>
<td class='fields'><INPUT TYPE="text" name="spec_handed_over_date" id="spec_handed_over_date" maxlength=16  value="<%=specimen_handed_over_date%>" onBlur='validateDate1(this);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].spec_handed_over_date.select();return showCalendar('spec_handed_over_date', null, 'hh:mm' );" id='spechand' style="cursor=hand"><img src='../../eCommon/images/mandatory.gif' id='imgenable5'    style="visibility:hidden"></td>
</tr>
 </table>
	
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>





<a name='kin'></a>
<!--<a name="tab3"  onFocus='javascript:AEScrollIntoView(3);'></a> 
<table width='100%' cellpadding='0'   cellspacing='0' BORDER='0'><tr><td width='1%' class='BODYCOLORFILLED'></td><td width='50%' class='BODYCOLORFILLED'>&nbsp;<a align ='left' href="javascript:AEScrollIntoView(1)"><img src="../../eMO/images/RegistrationClick.gif" border=0></a><a align='left' href="javascript:AEScrollIntoView(2)" tabindex='-1'><img src="../../eMO/images/Findings.gif" border=0 ></a><a align='left' href="javascript:AEScrollIntoView(3)" tabindex='-1' ><img src="../../eMO/images/SpecimenClick.gif" border=0></a><a align='left'  href="javascript:AEScrollIntoView(4)" tabindex='-1' ><img src="../../eMO/images/TissueProcurementClick.gif" id='hidetis6' style="visibility:hidden" border=0></a></td></tr>

</table>-->

<a name="tab3"  onFocus='javascript:AEScrollIntoView(2);'></a> 	
	<ul id="tablist" class="tablist">
		<li class="tablistitem" title="Registration">
			<a onclick="AEScrollIntoView(1)"   class="tabA" id="1" ><span class="tabASpan" ><fmt:message key="Common.Registration.label" bundle="${common_labels}"/></span>
			</a>
		</li>
		<li class="tablistitem" title="Find"  >
			<a onclick="AEScrollIntoView(2)"  class="tabClicked" id="2" ><span  class="tabSpanclicked" ><fmt:message key="eMO.Finding.label" bundle="${mo_labels}"/></span>
			</a>
		</li>
		<li class="tablistitem" title="Specimen" >
			<a onclick="AEScrollIntoView(3)" class="tabA" id="3" ><span class="tabASpan"><fmt:message key="Common.Specimen.label" bundle="${common_labels}"/></span>
			</a>
		</li>
		<li class="tablistitem" title="TissueProcurement" id='hidetis6' style="visibility:hidden">
			<a onclick="AEScrollIntoView(4)" class="tabA" id="4" ><span class="tabASpan" ><fmt:message key="eMO.TissueProcurement.label" bundle="${mo_labels}"/></span>
			</a>
		</li>
	</ul>
	<!-- Below line(s) <div> added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572] -->
<div  style="position:relative;height:500px;vertical-align:top;overflow:auto"> 
<table cellspacing='0' cellpadding='2' width='100%' border=0 align='center' scrolling='yes' >
<tr>
<td class='label' width='23%'><fmt:message key="eMO.PostmortemCertifiedBy.label" bundle="${mo_labels}"/> </td>
<td colspan='3' class='fields'><INPUT TYPE="text" size=50 maxlength=30 value="<%=pm_certified_by_desc%>"onBlur="beforeGetPractitioner(this,'pract_but9',pract9)" NAME="pract_desc9"><input type='button' class='button' readOnly name='pract_but9' id='pract_but9' value='?' onClick="getValues(this,pract_desc9,pract9)";><img id='imgenable1' style="visibility:hidden" src='../../eCommon/images/mandatory.gif'><input type=hidden name='pract9' id='pract9' value="<%=pm_certified_by%>"></td>
</tr>
<tr>
<tH colspan='4' class='columnheader'><fmt:message key="Common.CauseofDeath.label" bundle="${common_labels}"/></th>
</tr>
<tr>
<td colspan='4' class='label'><b>1. <fmt:message key="eMO.Diseasedeath.label" bundle="${mo_labels}"/></b></td>
 </tr>
<%
	int p1=0;
	int p2=0;
	int p3=0;
	// Loop Statement Changed For this CRF BRU_HIMS_CRF-270
	
for(int j=0;j<=7;j++){
	if(findingtype[j].equals("1"))
	{ 
	ddesc[p1]=diagdesc[j];
	dcode[p1]=diagcode[j];
	onsetdate[p1]=onsetdatetime[j];
	dcause[p1]=diagcause[j];
	p1++; 
	}else if(findingtype[j].equals("2"))
	{
	ddesc1[p2]=diagdesc[j];
	dcode1[p2]=diagcode[j];
	onsetdate1[p2]=onsetdatetime[j];
	
	p2++;
	}else if(findingtype[j].equals("3"))
	{
	ddesc2[p3]=diagdesc[j];
	dcode2[p3]=diagcode[j];
	onsetdate2[p3]=onsetdatetime[j];
	dcause2[p3]=diagcause[j];
	p3++;
	}




}
if(ddesc[0]==null)ddesc[0]="";
if(onsetdate[0]==null)onsetdate[0]="";
if(dcode[0]==null)dcode[0]="";
if(dcause[0]==null)dcause[0]="";

if(ddesc[1]==null)ddesc[1]="";
if(onsetdate[1]==null)onsetdate[1]="";
if(dcode[1]==null)dcode[1]="";
if(dcause[1]==null)dcause[1]="";

if(ddesc1[0]==null)ddesc1[0]="";
if(onsetdate1[0]==null)onsetdate1[0]="";
if(dcode1[0]==null)dcode1[0]="";

if(ddesc1[1]==null)ddesc1[1]="";
if(onsetdate1[1]==null)onsetdate1[1]="";
if(dcode1[1]==null)dcode1[1]="";

if(ddesc2[0]==null)ddesc2[0]="";
if(onsetdate2[0]==null)onsetdate2[0]="";
if(dcode2[0]==null)dcode2[0]="";
if(dcause2[0]==null)dcause2[0]="";

if(ddesc2[1]==null)ddesc2[1]="";
if(onsetdate2[1]==null)onsetdate2[1]="";
if(dcode2[1]==null)dcode2[1]="";
if(dcause2[1]==null)dcause2[1]="";

if(ddesc2[2]==null)ddesc2[2]="";
if(onsetdate2[2]==null)onsetdate2[2]="";
if(dcode2[2]==null)dcode2[2]="";
if(dcause2[2]==null)dcause2[2]="";
if(ddesc2[3]==null)ddesc2[3]="";
if(onsetdate2[3]==null)onsetdate2[3]="";
if(dcode2[3]==null)dcode2[3]="";
if(dcause2[3]==null)dcause2[3]="";
String remark_disable="";
// If Statement newly added For this CRF BRU_HIMS_CRF-270
if(ddesc[0]=="")
	{
	remark_disable="disabled";
	}

if(ddesc[1]=="")
	{
	remark_disable="disabled";
	}
if(ddesc2[0]=="")
	{
	remark_disable="disabled";
	}
if(ddesc2[1]=="")
	{
	remark_disable="disabled";
	}
if(ddesc2[2]=="")
	{
	remark_disable="disabled";
	}
if(ddesc2[3]=="")
	{
	remark_disable="disabled";
	}	
%>
<!-- BRU-HIMS-CRF-270-->
<tr> <td class='label'> a.<fmt:message key="Common.ICDCode.label" bundle="${common_labels}"/></td>
<td class='fields' width='40%'><INPUT TYPE="text" name="mr_diagnosis_desc" id="mr_diagnosis_desc" value="<%=ddesc[0]%>"  maxlength=70 onblur="callDiagnosis1(this,mr_diagnosis_code,'mr_diagnosis_desc');"  maxlength=70 size=40><input type='button' class='button' name='mr_diagnosis_select' id='mr_diagnosis_select' onclick="callDiagnosis(this,mr_diagnosis_code,'mr_diagnosis_desc');" value='?'></td>
 <td class='label' width='12%'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td>
 <td class='fields' width='25%'><INPUT TYPE="text" name="onset_date1" id="onset_date1" maxlength=16  value="<%=onsetdate[0]%>" onblur='validateDate1(this)'><img src="../../eCommon/images/CommonCalendar.gif" id='onsetdt1' onClick="document.forms[0].onset_date1.select();return showCalendar('onset_date1', null, 'hh:mm' );" style="cursor='hand'"></td>
 </tr>
 <tr>
 <td class='label'><fmt:message key="Common.Cause.label" bundle="${common_labels}"/></td>
 <!-- BRU-HIMS-CRF-270 END HERE-->
 <td colspan='3' class='fields'><textarea name='cause_remarks1' rows='1' cols='30'    onKeyPress='checkMaxLimit(this,200)' onblur='makeValidStringRemark(this);checkLength(this,200);'<%=remark_disable%> ><%=dcause[0]%></textarea></td>
 </tr>
 <!-- BRU-HIMS-CRF-270-->
<tr>
 <td class='label'>b.<fmt:message key="Common.ICDCode.label" bundle="${common_labels}"/></td>
<td class='fields'><INPUT TYPE="text" name="mr_diagnosis_desc1" id="mr_diagnosis_desc1"  maxlength=70 onblur="callDiagnosis1(this,mr_diagnosis_code1,'mr_diagnosis_desc1');" value="<%=ddesc[1]%>" size=40><input type='button' class='button' name='mr_diagnosis_select1' id='mr_diagnosis_select1' onclick="callDiagnosis(this,mr_diagnosis_code1,'mr_diagnosis_desc1');" value='?'></td>
 <td  class='label'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td>
 <td class='fields'><INPUT TYPE="text" name="onset_date2" id="onset_date2"  maxlength=16  value="<%=onsetdate[1]%>"onblur='validateDate1(this)' ><img src="../../eCommon/images/CommonCalendar.gif" id='onsetdt2' onClick="document.forms[0].onset_date2.select();return showCalendar('onset_date2', null, 'hh:mm' );" style="cursor='hand'"></td>

 </tr>

 <tr>
 <td class='label'><fmt:message key="Common.Cause.label" bundle="${common_labels}"/></td>
 <td colspan='3' class='fields'><textarea name='cause_remarks2' rows='1' cols='30'  onKeyPress='checkMaxLimit(this,200)' onblur='makeValidStringRemark(this);checkLength(this,200);'<%=remark_disable%>><%=dcause[1]%></textarea></td>
 <!-- BRU-HIMS-CRF-270 END HERE-->
 </tr> 
<tr>
<td colspan='4' class='label' ><b><fmt:message key="eMO.AntecedentCause.label" bundle="${mo_labels}"/></b></td>
 </tr>
 <tr>
 <td class='label'>c.<fmt:message key="Common.Cause.label" bundle="${common_labels}"/></td>
 <td class='fields'><INPUT TYPE="text" name="mr_diagnosis_desc2" id="mr_diagnosis_desc2"  maxlength=70 value="<%=ddesc1[0]%>"size=40><!--input type='button' class='button' style="visibility:hidden" name='mr_diagnosis_select2' onclick="callDiagnosis(this,mr_diagnosis_code2,'mr_diagnosis_desc2');" disabled value='?'--></td> 
 <td class='label'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td>
 <td class='fields'><INPUT TYPE="text" name="onset_date3" id="onset_date3" maxlength=16  value="<%=onsetdate1[0]%>"  onblur='validateDate1(this)'><img src="../../eCommon/images/CommonCalendar.gif" id='onsetdt3' onClick="document.forms[0].onset_date3.select();return showCalendar('onset_date3', null, 'hh:mm' );" style="cursor='hand'"></td>
 </tr>
 <tr>
 <td class='label' >d.<fmt:message key="Common.Cause.label" bundle="${common_labels}"/></td>
 <td class='fields'><INPUT TYPE="text" name="mr_diagnosis_desc3" id="mr_diagnosis_desc3"  maxlength=70 value="<%=ddesc1[1]%>"size=40><!--input type='button' class='button' style="visibility:hidden" disabled name='mr_diagnosis_select3' onclick="callDiagnosis(this,mr_diagnosis_code3,'mr_diagnosis_desc3');" value='?'--></td>
 <td class='label' ><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td> 
 <td class='fields'><INPUT TYPE="text" name="onset_date4" id="onset_date4" maxlength=16  value="<%=onsetdate1[1]%>" onblur='validateDate1(this)'><img src="../../eCommon/images/CommonCalendar.gif" id='onsetdt4' onClick="document.forms[0].onset_date4.select();return showCalendar('onset_date4', null, 'hh:mm' );" style="cursor='hand'"></td>
 </tr>
<tr>
<td colspan='4'  class='label'><b>2.<fmt:message key="eMO.OtherSignificantCond.label" bundle="${mo_labels}"/></b></td>
 </tr>
 <!-- BRU-HIMS-CRF-270-->
<tr>
 <td class='label'>a.<fmt:message key="Common.ICDCode.label" bundle="${common_labels}"/></td>
  <td class='fields'><INPUT TYPE="text" name="mr_diagnosis_desc4" id="mr_diagnosis_desc4"  maxlength=70 onblur="callDiagnosis1(this,mr_diagnosis_code4,'mr_diagnosis_desc4');" value="<%=ddesc2[0]%>" size=40><input type='button' class='button' name='mr_diagnosis_select4' id='mr_diagnosis_select4' onclick="callDiagnosis(this,mr_diagnosis_code4,'mr_diagnosis_desc4');" value='?'></td> 
 <td class='label'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td>
 <td class='fields'><INPUT TYPE="text" name="onset_date5" id="onset_date5"  maxlength=16  value="<%=onsetdate2[0]%>" onblur='validateDate1(this)'><img src="../../eCommon/images/CommonCalendar.gif" id='onsetdt5' onClick="document.forms[0].onset_date5.select();return showCalendar('onset_date5', null, 'hh:mm' );" style="cursor='hand'"></td>
 </tr>
 <tr>
 <td class='label'><fmt:message key="Common.Condition.label" bundle="${common_labels}"/></td>
 <!-- BRU-HIMS-CRF-270 END HERE-->
 <td colspan='3' class='fields'><textarea name='cause_remarks3' rows='1' cols='30'   onKeyPress='checkMaxLimit(this,200)' onblur='makeValidStringRemark(this);checkLength(this,200);'<%=remark_disable%>><%=dcause2[0]%></textarea></td>
 </tr>
 <!-- BRU-HIMS-CRF-270-->
  <tr>
 <td class='label' >b.<fmt:message key="Common.ICDCode.label" bundle="${common_labels}"/></td>
  <td class='fields'><INPUT TYPE="text" name="mr_diagnosis_desc5" id="mr_diagnosis_desc5"   maxlength=70 onblur="callDiagnosis1(this,mr_diagnosis_code5,'mr_diagnosis_desc5');" value="<%=ddesc2[1]%>" size=40><input type='button' class='button' name='mr_diagnosis_select5' id='mr_diagnosis_select5' onclick="callDiagnosis(this,mr_diagnosis_code5,'mr_diagnosis_desc5');" value='?'></td>
 <td class='label'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td>
 <td class='fields'><INPUT TYPE="text" name="onset_date6" id="onset_date6"  maxlength=16  value="<%=onsetdate2[1]%>" onblur='validateDate1(this)'><img src="../../eCommon/images/CommonCalendar.gif" id='onsetdt6' onClick="document.forms[0].onset_date6.select();return showCalendar('onset_date6', null, 'hh:mm' );" style="cursor='hand'"></td>
 </tr>
 <tr>
 <td class='label'><fmt:message key="Common.Condition.label" bundle="${common_labels}"/></td>
 <!-- BRU-HIMS-CRF-270 END HERE-->

 <td colspan='3' class='fields'><textarea name='cause_remarks4' rows='1' cols='30'  onKeyPress='checkMaxLimit(this,200)' onblur='makeValidStringRemark(this);checkLength(this,200);'<%=remark_disable%>><%=dcause2[1]%></textarea></td>
 </tr>
 <!-- BRU-HIMS-CRF-270-->
<tr>
 <td class='label' >c.<fmt:message key="Common.ICDCode.label" bundle="${common_labels}"/></td>
  <td class='fields'><INPUT TYPE="text" name="mr_diagnosis_desc6" id="mr_diagnosis_desc6"   maxlength=70 onblur="callDiagnosis1(this,mr_diagnosis_code6,'mr_diagnosis_desc6');" value="<%=ddesc2[2]%>" size=40><input type='button' class='button' name='mr_diagnosis_select6' id='mr_diagnosis_select6' onclick="callDiagnosis(this,mr_diagnosis_code6,'mr_diagnosis_desc6');" value='?'></td>
 
 <td class='label'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td>
 <td class='fields'><INPUT TYPE="text" name="onset_date7" id="onset_date7"  maxlength=16  value="<%=onsetdate2[2]%>" onblur='validateDate1(this)'><img src="../../eCommon/images/CommonCalendar.gif" id='onsetdt7' onClick="document.forms[0].onset_date7.select();return showCalendar('onset_date7', null, 'hh:mm' );" style="cursor='hand'"></td>
 </tr>
 <tr>
 <td class='label'><fmt:message key="Common.Condition.label" bundle="${common_labels}"/></td>
 <td colspan='3' class='fields'><textarea name='cause_remarks5' rows='1' cols='30' onKeyPress='checkMaxLimit(this,200)' onblur='makeValidStringRemark(this);checkLength(this,200);'<%=remark_disable%>><%=dcause2[2]%></textarea></td>
 </tr>
 <tr>
 <td class='label' >d.<fmt:message key="Common.ICDCode.label" bundle="${common_labels}"/></td>
  <td class='fields'><INPUT TYPE="text" name="mr_diagnosis_desc7" id="mr_diagnosis_desc7"   maxlength=70 onblur="callDiagnosis1(this,mr_diagnosis_code7,'mr_diagnosis_desc7');" value="<%=ddesc2[3]%>" size=40><input type='button' class='button' name='mr_diagnosis_select7' id='mr_diagnosis_select7' onclick="callDiagnosis(this,mr_diagnosis_code7,'mr_diagnosis_desc7');" value='?'></td>
 <td class='label'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td>
 <td class='fields'><INPUT TYPE="text" name="onset_date8" id="onset_date8"  maxlength=16  value="<%=onsetdate2[3]%>" onblur='validateDate1(this)'><img src="../../eCommon/images/CommonCalendar.gif" id='onsetdt8' onClick="document.forms[0].onset_date8.select();return showCalendar('onset_date8', null, 'hh:mm' );" style="cursor='hand'"></td>
</tr>
 <tr>
 <td class='label'><fmt:message key="Common.Condition.label" bundle="${common_labels}"/></td>
  <td colspan='3' class='fields'><textarea name='cause_remarks6' rows='1' cols='30'  onKeyPress='checkMaxLimit(this,200)' onblur='makeValidStringRemark(this);checkLength(this,200);'<%=remark_disable%>><%=dcause2[3]%></textarea></td>
 </tr>
  <!-- BRU-HIMS-CRF-270 END HERE-->
   <!-- In below line dropdown list field modified by venkatesh.s against 45192 on 22-Nov-2013 -->
<tr>
 <td class='label' ><fmt:message key="eMO.MannerofDeathuponReceipt.label" bundle="${mo_labels}"/></td>
<td class='fields' colspan='3'>
<select name='manner_of_death1' id='manner_of_death1' <%=death_manner_code_yn%> tabindex='15'>
<option value=''>&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;</option>
	<%
if(pstmt!=null)pstmt.close();
 if(rset!=null)rset.close();			 
 //pstmt = con.prepareStatement("select death_manner_code,short_desc from mo_manner_of_death where eff_status='E' order by 2");
 pstmt = con.prepareStatement("select death_manner_code,short_desc from MO_MANNER_OF_DEATH_LANG_VW where eff_status='E' and LANGUAGE_ID='"+localeName+"'order by 2");
				 rset = pstmt.executeQuery();
				 while(rset.next())
				 {
			if(death_manner_code.equals(rset.getString("death_manner_code"))){  %>
		
		<option value='<%=rset.getString("death_manner_code")%>' selected><%=rset.getString("short_desc")%></option>
				
		<%	}else{%>
			
			<option value='<%=rset.getString("death_manner_code")%>'><%=rset.getString("short_desc")%></option>
				
				<%}}
			
				 //if(rset!=null) rset.close();
				 // if(pstmt!=null) pstmt.close();
				
				%>
	</select>&nbsp;<img id='imgenable8' src='../../eCommon/images/mandatory.gif' style="visibility:hidden">
</td>

<!--Below line(s) added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]-->
</tr>
<td class='label'><fmt:message key="eMO.MannerofDeathafterPostmortem.label" bundle="${mo_labels}"/></td>
<td class='fields' colspan='3'><select name='manner_of_death_after_potmrtm' id='manner_of_death_after_potmrtm' tabindex='15'>
<option value=''>&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;</option>
<%
             rset = pstmt.executeQuery();
			  while(rset.next()){

                 if(actual_death_manner_code.equals(rset.getString("death_manner_code"))){%>
				 <option value='<%=rset.getString("death_manner_code")%>' selected><%=rset.getString("short_desc")%></option>
				 <%	}else{%>
			   <option value='<%=rset.getString("death_manner_code")%>'><%=rset.getString("short_desc")%></option>
			  <% }}
			  
			  if(rset!=null) rset.close();
			  if(pstmt!=null) pstmt.close();
			  
			  %>
</select>
<tr>
<!--end Bru-HIMS-CRF-365 [IN:039572]-->
</tr>
<tr>
<td class='label'><fmt:message key="eMO.SmryOfFdgs.label" bundle="${mo_labels}"/></td>
<td colspan='3' class='fields'><TEXTAREA NAME="postmortem_findings" ROWS="3" COLS="70" onBlur='document.forms[0].pract_desc9.focus();'><%=postmortem_findings%></TEXTAREA><img id='imgenable2' src='../../eCommon/images/mandatory.gif' style="visibility:hidden"><td>
</tr>
</table>
</div>
	
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br>
<input type=hidden name='facility_id' id='facility_id'	 value=<%=facility_id%>>
<!-- <input type=hidden name='diag_code' id='diag_code' value='<%=diag_code%>'> -->
<input type=hidden name='diag_code' id='diag_code' value='ICD10'>
<input type=hidden name='diag_desc' id='diag_desc' value='<%=diag_desc%>'>
<input type=hidden name='body_rec_date_time' id='body_rec_date_time' value='<%=body_received_date%>'>

<input type=hidden name='mr_diagnosis_code' id='mr_diagnosis_code'	 value="<%=dcode[0]%>">
<input type=hidden name='mr_diagnosis_code1' id='mr_diagnosis_code1' value='<%=dcode[1]%>'>
<input type=hidden name='mr_diagnosis_code2' id='mr_diagnosis_code2' value='<%=dcode1[0]%>'>
<input type=hidden name='mr_diagnosis_code3' id='mr_diagnosis_code3' value='<%=dcode1[1]%>'>
<input type=hidden name='mr_diagnosis_code4' id='mr_diagnosis_code4' value='<%=dcode2[0]%>'>
<input type=hidden name='mr_diagnosis_code5' id='mr_diagnosis_code5' value='<%=dcode2[1]%>'>
<input type=hidden name='mr_diagnosis_code6' id='mr_diagnosis_code6' value='<%=dcode2[2]%>'>  <!-- BRU-HIMS-CRF-270-->
<input type=hidden name='mr_diagnosis_code7' id='mr_diagnosis_code7' value='<%=dcode2[3]%>'>	<!-- BRU-HIMS-CRF-270-->
<input type='hidden' name='system_date' id='system_date' value="<%=sys_date%>">
<input type='hidden' name='end_date' id='end_date' value="<%=postmortem_end_date_time%>">
<input type='hidden' name='registration_no' id='registration_no' value="<%=registration_no%>">
<input type='hidden' name='pmstatus' id='pmstatus' value="S">
<input type='hidden' name='viewdata' id='viewdata' value="<%=viewdata%>">
<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>">
<input type='hidden' name='patient_class' id='patient_class' value="<%=patient_class%>">
<input type='hidden' name='encounter_id' id='encounter_id' value="<%=encounter_id%>">
<input type='hidden' name='postmortem_type' id='postmortem_type' value="<%=postmortem_type%>">
<input type='hidden' name='postmortem_status' id='postmortem_status' value="<%=postmortem_status%>">
<!--Below line(s) added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]-->
<input type='hidden' name='manner_of_death' id='manner_of_death' value="<%=death_manner_code%>">




<input type='hidden' name='isPMFindingDetailsAppl' id='isPMFindingDetailsAppl' value="<%=isPMFindingDetailsAppl%>"> <!--added by mujafar for ML-MMOH-CRF-0880 -->
<input type='hidden' name='record_pm_find_dtls_yn' id='record_pm_find_dtls_yn' value="<%=record_pm_find_dtls_yn%>"> <!--added by mujafar for ML-MMOH-CRF-0880 -->
 <input type='hidden' name='tissuecnt' id='tissuecnt' value='<%=tissuecnt%>'>
 <input type='hidden' name='body_part_obtained_from_disable' id='body_part_obtained_from_disable' value='<%=body_part_obtained_from_disable%>'>
 <input type='hidden' name='body_part_obtained_from' id='body_part_obtained_from' value='<%=body_part_obtained_from%>'>
 <input type='hidden' name='age' id='age' value='<%=age%>'>
 <input type='hidden' name='date_of_birth' id='date_of_birth' value='<%=date_of_birth%>'>
 <input type='hidden' name='deceased_yn' id='deceased_yn' value='<%=deceased_yn%>'>
 <input type='hidden' name='locale' id='locale' value='<%=locale%>'>

 <input type='hidden' name='donatedorgan' id='donatedorgan' value="">
 <input type='hidden' name='cnt' id='cnt' value="<%=proccnt%>">
</form>
</body>
</html>

<%	}
  catch(Exception e)
  {
  out.println(e);
  }finally{
  ConnectionManager.returnConnection(con,request);
  }

%>
<script>
// BRU-HIMS-CRF-270
if(document.MORecordPostmortem.mr_diagnosis_desc.value!='')
{
document.MORecordPostmortem.cause_remarks1.disabled=false;
}
if(document.MORecordPostmortem.mr_diagnosis_desc1.value!='')
{
document.MORecordPostmortem.cause_remarks2.disabled=false;
}
if(document.MORecordPostmortem.mr_diagnosis_desc4.value!='')
{
document.MORecordPostmortem.cause_remarks3.disabled=false;
}
if(document.MORecordPostmortem.mr_diagnosis_desc5.value!='')
{
document.MORecordPostmortem.cause_remarks4.disabled=false;
}
if(document.MORecordPostmortem.mr_diagnosis_desc6.value!='')
{
document.MORecordPostmortem.cause_remarks5.disabled=false;
}
if(document.MORecordPostmortem.mr_diagnosis_desc7.value!='')
{
document.MORecordPostmortem.cause_remarks6.disabled=false;
}
</script>

