<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.io.*,java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,javax.naming.*,javax.ejb.*,java.rmi.*,javax.rmi.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<HTML>
        <head>
            <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
            <Script src="../../eMP/js/PatientSearch.js" language="JavaScript"></Script>
            <Script language='JavaScript'>

	
			</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
//String logged_facility = (String) session.getValue("facility_id");
String resp_name = (String) session.getValue("responsibility_name");
Connection conn = ConnectionManager.getConnection(request);
java.sql.Statement stmt = conn.createStatement();
java.sql.Statement stmt_new = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
PreparedStatement pstmt_new = null;
ResultSet rsnew = null;
java.sql.Statement stmt_7 = conn.createStatement();
java.sql.Statement stmt8=conn.createStatement();
java.sql.Statement stmtx=conn.createStatement();
java.sql.Statement stmtk=conn.createStatement();
ResultSet rs=null;
ResultSet rs1=null;
ResultSet rs2=null;
ResultSet rs3=null;
ResultSet rs4=null;
ResultSet rs5=null;
ResultSet rs6=null;
//ResultSet rs7=null;
ResultSet rsx=null;
ResultSet rsk=null;


String op_install_yn="N";
String ip_install_yn="N";

int TotalNoRecords = 0;

String TotalNoRec=request.getParameter("TotalNoRecords");
if (TotalNoRec==null) TotalNoRec="0";

TotalNoRecords = Integer.parseInt(TotalNoRec);


int totalpercent=100; 
int patient_id_length=0;

double maxDisplay = 0;
double maxDisplay1 = 0;
int searchThreshold = 11;
int start = 0 ;
int end = 0 ;
String from = request.getParameter( "From" );
String to = request.getParameter( "To" );

if ( from == null || from.equals(""))
    start = 1 ;
else
    start = Integer.parseInt( from ) ;

if ( to == null || to.equals(""))
    end = searchThreshold ;
else
    end = Integer.parseInt( to ) ;

double maxRecord = 0;


String allow_nb_review="N";
//String sql;
String photo[]=null;

double Hit=0;
double Hit_for_buttons=0;


String view_pat_photo_yn = "N";
StringBuffer selectCaluse	=	new StringBuffer();
StringBuffer whereClause	=	new StringBuffer();
StringBuffer pagewhereClause	=	new StringBuffer();
StringBuffer fromClause	=	new StringBuffer();
StringBuffer finalQuery		=	new StringBuffer();
//outer try to close connections
try{
try
{

try
    {
        rsk=stmtk.executeQuery("select review_nb_links_bef_reg_yn, patient_id_length  from mp_param");
        if(rsk.next())
		{
            allow_nb_review=rsk.getString(1);
			patient_id_length=rsk.getInt(2);
		}
    }
catch(Exception e)
    {
        allow_nb_review="N";
        out.println("Exception : "+e);
    }
    finally
    {
        if(rsk!=null)rsk.close();
		if (stmtk!=null) stmtk.close();
    }
// naren - check and remove the below SQL
rsx=stmtx.executeQuery("select nvl(install_yn,'N') from sm_module where module_id='OP'");
if(rsx.next())
    {
        op_install_yn=rsx.getString(1);
        if(op_install_yn==null)op_install_yn="N";
    }

// naren - check and remove the below SQL
rsx=stmtx.executeQuery("select nvl(install_yn,'N') from sm_module where module_id='IP'");
if(rsx.next())
    {
        ip_install_yn=rsx.getString(1);
        if(ip_install_yn==null)ip_install_yn="N";
    }

//mode = request.getParameter("mode");
//if(mode==null || mode.equals("null")) mode = "";
}catch (Exception e)
{
    out.println("exception "+e);
} 

String countsql = request.getParameter("countSQL");
if (countsql==null) countsql = "";


if (countsql.indexOf("^") >=0)
    countsql = countsql.replace('^','%');
String pageWhere=checkForNull(request.getParameter("whereClause"));
if(pageWhere.indexOf("^")>=0){
pageWhere=pageWhere.replace('^','%');
}
String flag=	checkForNull(request.getParameter("flag"));
    
	
//Added for including pref facility id in the select if pref facility is not selected as part of result
String cntPrefFac = request.getParameter("cntPrefFac");
if (cntPrefFac==null || cntPrefFac.equals("null")) cntPrefFac = "0";

String usePatIDIndex =request.getParameter("usePatIDIndex");
if (usePatIDIndex==null || usePatIDIndex.equals("null")) usePatIDIndex = "N";




String maxDisp = request.getParameter("maxdisplay");
String maxDisp1 = request.getParameter("maxdisplay1");

if (maxDisp==null ||maxDisp.equals("0.0")) maxDisp = "0";
if (maxDisp1==null ||maxDisp1.equals("0.0")) maxDisp1 = "0";

maxDisplay = Integer.parseInt(maxDisp);
maxDisplay1 = Integer.parseInt(maxDisp1);
String j_select     =request.getParameter("j_select");
String j_new_select =  request.getParameter( "j_new_select" );
String j_from       =request.getParameter("j_from");
if (j_select==null || j_select.equals("null")) j_select = "";
if (j_new_select==null || j_new_select.equals("null")) j_new_select = "";
if (j_from==null || j_from.equals("null")) j_from = "";



/*Vairable Declaration Of  Criteria Page */
String pat_id					=	checkForNull(request.getParameter("p_no"));
String Alt_Id1_No			=  checkForNull(request.getParameter("Alt_Id1_No"));
String National_Id_No	=  checkForNull(request.getParameter("National_Id_No"));
String  Family_No			=  checkForNull(request.getParameter("Family_No"));
String MRN					=  checkForNull(request.getParameter("MRN"));
String First_Name		    =  checkForNull(request.getParameter("First_Name"));
String Second_Name		=  checkForNull(request.getParameter("Second_Name"));
String  Third_Name			=  checkForNull(request.getParameter("Third_Name"));
String  Family_Name		=  checkForNull(request.getParameter("Family_Name"));
String  Sex						=  checkForNull(request.getParameter("Sex"));
String  By						=  checkForNull(request.getParameter("By"));
//String  Dob						=  checkForNull(request.getParameter("Dob"));
/* 1.DATE,FromDate&ToDate values  are the based upon the By Value. Either By Value is Date nOr Year
2.If By value is D(Date), DATE Value is Considered for WhereClause. 
3.Else By value is Y(Year) FromDate and ToDates are Considered for WhereClause */
String DATE								=	checkForNull(request.getParameter("DATE"));
String FromDate						=	checkForNull(request.getParameter("FromDate"));
String ToDate							=	checkForNull(request.getParameter("ToDate"));
String  Mode					=  checkForNull(request.getParameter("Mode"));
String  Contact_No			=  checkForNull(request.getParameter("Contact_No"));
String  Area					=  checkForNull(request.getParameter("Area"));
String  Soundex				=  checkForNull(request.getParameter("Soundex"));
String OldFileNo				=  checkForNull(request.getParameter("OldFileNo"));
String  Alt_Id2_No			=  checkForNull(request.getParameter("Alt_Id2_No"));
String  Alt_Id3_No			=  checkForNull(request.getParameter("Alt_Id3_No"));
String  Alt_Id4_No			=  checkForNull(request.getParameter("Alt_Id4_No"));
String  Nationality			= checkForNull( request.getParameter("Nationality"));
String  addl_field1			=  checkForNull(request.getParameter("addl_field1"));
String  addl_field2			=  checkForNull(request.getParameter("addl_field2"));
String  addl_field3			=  checkForNull(request.getParameter("addl_field3"));
String  addl_field4			= checkForNull( request.getParameter("addl_field4"));
String  addl_field5			=  checkForNull(request.getParameter("addl_field5"));
String  ethnic_group		=  checkForNull(request.getParameter("ethnic_group"));
String other_alt_id			=  checkForNull(request.getParameter("other_alt_id"));
String other_alt_Id_no	= checkForNull( request.getParameter("other_alt_Id_no"));
String sltDocType			= checkForNull( request.getParameter("sltDocType"));
String txtDocType			=  checkForNull(request.getParameter("txtDocType"));
String family_org_membership =  checkForNull(request.getParameter("family_org_membership"));
String organization						=  checkForNull(request.getParameter("organization"));
String sub_organization				=  checkForNull(request.getParameter("sub_organization"));
String Orgnization_id					=	checkForNull(request.getParameter("Orgnization_id"));
String sub_Organisation				=	checkForNull(request.getParameter("sub_Organisation"));
String mother_maiden_name		= checkForNull(request.getParameter("mother_maiden_name"));
String first_name_loc_lang			= checkForNull( request.getParameter("first_name_loc_lang"));
String second_name_loc_lang		=  checkForNull(request.getParameter("second_name_loc_lang"));
String third_name_loc_lang			=  checkForNull(request.getParameter("third_name_loc_lang"));
String family_name_loc_lang		= checkForNull( request.getParameter("family_name_loc_lang"));
String deceased_yn						= checkForNull( request.getParameter("deceased_yn"));
String suspend_yn						= checkForNull( request.getParameter("suspend_yn"));
String  active_yn							=	checkForNull(request.getParameter("active_yn"));
String reg_mode							=  checkForNull(request.getParameter("reg_mode"));
String  IP_yn								= checkForNull( request.getParameter("IP_yn"));
String DC_yn								= checkForNull( request.getParameter("DC_yn"));
String OP_yn								= checkForNull( request.getParameter("OP_yn"));
String EM_yn								= checkForNull( request.getParameter("EM_yn"));
String patient_series					=  checkForNull(request.getParameter("patient_series"));
String win_height						=	checkForNull(	request.getParameter("win_height"));
String win_width						=	checkForNull(request.getParameter("win_width"));
String win_top							=	checkForNull(	request.getParameter("win_top"));
String srr									=	checkForNull( request.getParameter("srr"));
String func_act							= checkForNull(request.getParameter("func_act"));
String act_yn							= checkForNull(request.getParameter("act_yn"));
String old_file_no_where			=	checkForNull( request.getParameter("old_file_no_where"));
String file_no_where					=	checkForNull( request.getParameter("file_no_where"));
String apply_oth_name				= checkForNull(request.getParameter("apply_oth_name"));
String search_in							=	checkForNull(request.getParameter("search_in"));
String order_by							=  checkForNull(request.getParameter( "order_by" ));
String newBorn_sufx					=  checkForNull(request.getParameter( "newBorn_sufx" ));
String function_id						=	checkForNull(request.getParameter("function_id"));
//String jsp_name						=  checkForNull(request.getParameter( "jsp_name" ));
String enablegenderyn				= checkForNull(request.getParameter( "enablegenderyn" ));
if (enablegenderyn=="") enablegenderyn = "Y";
String alignment =  (apply_oth_name == null ||  apply_oth_name.equals("null")) ?"left" : "left" ;
String othlang = (apply_oth_name == null ||  apply_oth_name.equals("null")) ?"N" : "Y" ;
if (order_by.equals("X")||order_by.equals(""))
	{order_by="patient_id";}



//System.out.println("search_in ==>"+search_in);

if (function_id==null || function_id.equals("null") || function_id.equals("")) function_id = "";

String dr_merge_valid = request.getParameter("dr_merge_valid");
if (dr_merge_valid==null || dr_merge_valid.equals("null") || dr_merge_valid.equals("")) dr_merge_valid = "";


//int drpos1 = 0;
//String MRN="";
//String OldFileNo="";
//String continue_yn = "Y";

//MRN=request.getParameter("MRN");
//if (MRN==null || MRN.equals("null")) MRN="";
//OldFileNo=request.getParameter("OldFileNo");
//if (OldFileNo==null || OldFileNo.equals("null")) OldFileNo="";
//System.out.println("MRN=@=>" +MRN);
//System.out.println("OldFileNo=@=>" +OldFileNo);


/**************Vairable Declaration Ends********************/


/**************Construction Of Where Clause***************/

StringBuffer orderByCaluse		=	new StringBuffer(" order by "  +order_by);
String strAND="";
String strOR="";


selectCaluse.append("select 	a.patient_id,a.patient_name,a.sex,to_char(a.date_of_birth, 'dd/mm/yyyy')date_of_birth,a.national_id_no,a.second_name,a.third_name,(case when a.nationality_code is not null then (select long_desc from mp_country_lang_vw where country_code = a.nationality_code and language_id = '"+locale+"') end) nationality_desc,a.contact1_no,(case when a.res_area_code is not null then (select long_desc from mp_res_area_lang_vw where res_area_code = a.res_area_code and language_id = '"+locale+"') end) res_area_desc,a.emeg_regn_yn,b.addl_field2,a.patient_name mother_patient_name,a.alt_id1_no,a.contact2_no,b.addl_field3,b.addl_field4,a.oth_alt_id_no,a.oth_alt_id_type, (case when a.pref_facility_id is not null then (select facility_name from sm_facility_param_lang_vw where facility_id = a.pref_facility_id and language_id = '"+locale+"') end) Pref_Fac_Name, b.addl_field1,a.pat_ser_grp_code,a.patient_name_loc_lang,a.name_prefix,b.addl_field5,a.family_org_sub_id,a.pat_cat_code,a.relationship_to_head,a.family_org_id,a.first_name,a.family_name,a.name_suffix,a.pref_facility_id, 	 a.enc_facility_id,a.curr_encounter_id,   (case when a.family_org_id is not null then (select family_org_name from mp_family_org_lang_vw where family_org_id = a.family_org_id and language_id = '"+locale+"') end) family_org_name,  (case when a.family_org_sub_id is not null then (select family_org_sub_name from mp_family_org_sub_lang_vw where family_org_id = a.family_org_id and family_org_sub_id = a.family_org_sub_id and language_id = '"+locale+"') end) family_org_sub_name,	(case when a.pat_cat_code is not null then (select long_desc from mp_pat_category_lang_vw where pat_cat_code = a.pat_cat_code and language_id = '"+locale+"') end) pat_cat_desc, (case when a.pat_ser_grp_code is not null then (select long_desc from mp_pat_ser_grp_lang_vw where pat_ser_grp_code = a.pat_ser_grp_code and language_id = '"+locale+"') end) pat_ser_grp_desc,	a.deceased_yn,a.suspend_yn,a.active_yn,a.curr_patient_class");
fromClause.append(" from mp_patient a, mp_pat_oth_dtls b ");
whereClause.append("  where  a.patient_id = b.patient_id  and ");

/*Where Clause Constructed Based Upon Patient ID, National_ID_No,Familiy_No,MRN,OldFileNo,New Born Suffix & Nationality **/

if (!pat_id.equals("")){
whereClause.append("   A.Patient_id like trim('" + pat_id + "')||'%' ");
strAND="AND";
}																														

 if (!National_Id_No.equals("")){
whereClause.append(" "+strAND+" A.National_Id_No like trim('" + National_Id_No+ "') ||'%' ");
strAND="AND";
}																														

 if (!Family_No.equals("")){
whereClause.append(""+strAND+" Family_Link_No like trim('" + Family_No + "') ||'%' ");
strAND="AND";
} 																														 

// naren - check and remove the below SQL
if (!MRN.equals("")){
whereClause.append(" "+strAND+" A.patient_id = (select patient_id from mr_pat_file_index where file_no = '"+MRN+"')  ");
strAND="AND";
}																														
// naren - check and remove the below SQL
if (!OldFileNo.equals("")){
whereClause.append(""+strAND+" A.patient_id in (select patient_id from mr_pat_file_index where old_file_no = '"+OldFileNo+"')  ");
strAND="AND";
}																														

 if (!newBorn_sufx.equals("")&&!Alt_Id1_No.equals("")){
whereClause.append(" "+strAND+"  newborn_id_no_suffix=trim('" + newBorn_sufx + "')");
strAND="AND";
}																														 

if (!Nationality.equals("")){
whereClause.append(" "+strAND+" Nationality_code='"+Nationality+"' ");
strAND="AND";
}	
/***Ends******/

/*Where Clause Counstructed Based Upon Alt ID No1, 2,3,4*/
if (!Alt_Id1_No.equals("")){
whereClause.append(" "+strAND+" Alt_Id1_No like trim('" + Alt_Id1_No + "') ||'%'");
strAND="AND";
}	
if (!Alt_Id2_No.equals("")){
whereClause.append(" "+strAND+" Alt_Id2_No like trim('" +Alt_Id2_No + "') ||'%' ");
strAND="AND";
}																														

if (!Alt_Id3_No.equals("")){
whereClause.append(" "+strAND+" Alt_Id3_No like trim('" +Alt_Id3_No + "') ||'%' ");
strAND="AND";
}																														

if (!Alt_Id4_No.equals("")){
whereClause.append(" "+strAND+" Alt_Id4_No like trim('" +Alt_Id4_No + "') ||'%' ");
strAND="AND";
}																														
/**Ends***/

/*if (!Family_No.equals("")){
whereClause.append("  "+strAND+" Family_Link_No like trim('" +Family_No+"') ||'%' ");
strAND="AND";
}	*/																													

/*Where Clause Counstructed Based Upon First Name,Second Name,Third Name,Familiy Name*/
if (!First_Name.equals("")){
whereClause.append(" "+strAND+" UPPER(First_Name) like UPPER('" + First_Name + "%') ");
strAND="AND";
}																														 ;

if (!Second_Name.equals("")){
whereClause.append(" "+strAND+" upper(second_name_loc_lang) like upper('" +Second_Name+ "%'");
strAND="AND";
}																														

if (!Third_Name.equals("")){
whereClause.append(" "+strAND+" UPPER(Third_Name) like UPPER('" +Third_Name+ "%')  ");
strAND="AND";
}																														

if (!Family_Name.equals("")){
whereClause.append("  "+strAND+" UPPER(Family_Name) like UPPER('%" +Family_Name+ "')");
strAND="AND";
}	
/***Ends**/
/*Where Clause Constructed Based Upon Sex,DOB,Contact,Mode,Area,Soundex*/
if (!Sex.equals("")){
		if (Sex.equals("M")){
			whereClause.append(" "+strAND+" Sex='M' ");
		}
			if (Sex.equals("F")){
			whereClause.append(" "+strAND+"  Sex='F' ");
		}
		if (Sex.equals("U")){
			whereClause.append(" "+strAND+"  Sex='U' ");
		}
		if (Sex.equals("A")){
			whereClause.append(" "+strAND+"  Sex like '%' ");
		}
		strAND="AND";
}																														

if (!By.equals("")){
	if (By.equals("D") && !DATE.equals("")){
	whereClause.append(" "+strAND+"  trunc(Date_Of_Birth) = to_date('" + DATE + "','dd/mm/yyyy') ");
	strAND="AND";
	}
	else if (By.equals("Y")){
			if (FromDate.equals("") && !ToDate.equals("")){
					whereClause.append(" "+strAND+" Date_Of_Birth between to_date('" + FromDate + "','dd/mm/yyyy') and to_date('" + ToDate + "','dd/mm/yyyy')");
					strAND="AND";
			}
	}
//	strAND="AND";
}		
			
if (!Mode.equals("")&&!Contact_No.equals("")){
whereClause.append(" "+strAND+" (Contact1_Mode=trim('" + Mode + "') and Contact1_No=trim('" + Contact_No + "')) or  (Contact2_Mode=trim('" + Mode+ "') and Contact2_No=trim('" + Contact_No  + "'))or(Contact3_Mode=trim('" + Mode+ "') and Contact3_No=trim('" + Contact_No  + "')) or (Contact4_Mode=trim('" + Mode+ "') and Contact4_No=trim('" + Contact_No  + "')) or (Contact5_Mode=trim('" + Mode+ "') and Contact5_No=trim('" + Contact_No  + "'))");
strAND="AND";
}

if (!Area.equals("")){
whereClause.append( " "+strAND+"  Res_Area_Code=trim('" +Area+ "') " );
strAND="AND";
}	

 if (!First_Name.equals("") && !Second_Name.equals("")){
	String cmpltName=First_Name+Second_Name;
	      if (Soundex.equals("E")){
				whereClause.append("ethnic_sndx_first_second=ethnic_soundex('" +cmpltName+ "')");
		  }
		  else if (Soundex.equals("G")){
			  whereClause.append("generic_sndx_first_second=soundex('"+cmpltName+"')");
		  }																														 //Criteria Through SOUNDEX-->7;
strAND="AND";
}
/******Ends*********/

/*Where Clause Constructed Based Upon  Addtional Fields 1,2 3,4.5 */
if (!addl_field1.equals("")){
whereClause.append(" "+strAND+"  UPPER(addl_field1) like UPPER('"+addl_field1+"') || '%'");
strAND="AND";
}												 
if (!addl_field2.equals("")){
whereClause.append(" "+strAND+"  UPPER(addl_field2) like UPPER('"+addl_field2+"') || '%'");
strAND="AND";							
}	
if (!addl_field3.equals("")){
whereClause.append(" "+strAND+"  UPPER(addl_field3) like UPPER('"+addl_field3+"') || '%'");
strAND="AND";
}	
if (!addl_field4.equals("")){
whereClause.append(" "+strAND+"  UPPER(addl_field4) like UPPER('"+addl_field4+"') || '%'");
strAND="AND";
}	
if (!addl_field5.equals("")){
whereClause.append(" "+strAND+"  UPPER(addl_field5) like UPPER('"+addl_field5+"') || '%'");
strAND="AND";
}	
/******Ends**********/

/*Where Clause Constructed Based Upon Ethinic Group,Other Alt ID,Other Alt ID_No */

if (!ethnic_group.equals("")){
whereClause.append(" "+strAND+" race_code='" +ethnic_group+ "' ");
}																														


if (!other_alt_id.equals("")){
whereClause.append(" "+strAND+" oth_alt_id_type='" + other_alt_id + "' ");
strAND="AND";
}																														 

if (!other_alt_Id_no.equals("")){
whereClause.append( " "+strAND+" oth_alt_Id_no='" +other_alt_Id_no+ "'  ");
strAND="AND";
}																														
/*******Ends*******/

/*Where Clause Constructed Based Upon sltDocType, txtDocType */

// naren - check and remove the below SQL
if (!sltDocType.equals("")&&!txtDocType.equals("")){
whereClause.append(" patient_id IN (SELECT patient_id FROM MP_PAT_DOCUMENTS WHERE (doc1_type='" + sltDocType+ "' AND doc1_num ='"+txtDocType+"' ) OR (doc2_type= '"+sltDocType+"' AND doc2_num= '"+txtDocType+"' ) OR (doc3_type='"+sltDocType+"' AND doc3_num= '"+txtDocType+"' ) OR (doc4_type='"+sltDocType+"' AND doc4_num= '"+txtDocType+"' ))" );
strAND="AND";
}
/***Ends******/

/*Where Clause Constructed Based upon Organization,Familiy Organization Sub Organization*/
if (!family_org_membership.equals("")){
whereClause.append("  "+strAND+" family_org_membership='"+family_org_membership+ "'  ");
strAND="AND";
}														

if (!organization.equals("")){
whereClause.append("  "+strAND+" family_org_id='"+Orgnization_id+"' ");
}														
if (!sub_organization.equals("")){
whereClause.append( "  "+strAND+"  family_org_sub_id='"+sub_Organisation+"' and  family_org_id = '"+sub_organization+"'");
}	
/*******Ends********/
// naren - check and remove the below SQL
if (!mother_maiden_name.equals("")){
whereClause.append(  " "+strAND+" a.mother_patient_id is not null and  exists ( select 1 from mp_patient where patient_id = a.mother_patient_id and upper(patient_name) like upper('%"+mother_maiden_name+"%'))");
strAND="AND";
}													
/*Where Clause Constructed Based Upon FirstName Loc Lang,Second Name Loc Lang,Third Name Loc Lag,Familiy Name Loc Lang*/
if (!first_name_loc_lang.equals("")){
whereClause.append(  " "+strAND+" upper(first_name_loc_lang) like upper('"+first_name_loc_lang+"%' )");
strAND="AND";
}													 

if (!second_name_loc_lang.equals("")){
whereClause.append(  " "+strAND+" upper(second_name_loc_lang) like upper('"+second_name_loc_lang+"%'))");
strAND="AND";
}													

if (!third_name_loc_lang.equals("")){
whereClause.append(  " "+strAND+" upper(third_name_loc_lang) like upper('" + third_name_loc_lang+ "%')");
strAND="AND";
}													

if (!family_name_loc_lang.equals("")){
whereClause.append(  " "+strAND+" upper(family_name_loc_lang) like upper('%" + family_name_loc_lang+ "')");
strAND="AND";
}		
/******Ends******/


if (!patient_series.equals("")){
whereClause.append(" "+strAND+"  PAT_SER_GRP_CODE='"+patient_series+"' ");
strAND="AND";
}													
/*Where Clause Constructed Based Upon Paient Series Group Code, Deceased_Yn,Suspend_Yn,Active_Yn,*/
if (deceased_yn.equals("Y")){
whereClause.append(" "+strAND+"  DECEASED_YN='"+deceased_yn+"' ");
strAND="AND";
}											      

if (suspend_yn.equals("Y")){
whereClause.append(" "+strAND+"  SUSPEND_YN='"+suspend_yn+"' ");
strAND="AND";
}												

if (active_yn.equals("Y")){
whereClause.append(" "+strAND+"  ACTIVE_YN='"+active_yn+"' ");
strAND="AND";
}												
/****Ends*****/
/*Where Clause Constructed Based Upon Reg_Mode,IP_Yn,DC_Yn,OP_Yn,EM_Yn*/
if (!reg_mode.equals("")){
whereClause.append(" "+strAND+"  EMEG_REGN_YN like ('"+reg_mode+"') ");
strAND="AND";
}												

if (IP_yn.equals("IP")){
whereClause.append(" "+strAND+"  CURR_PATIENT_CLASS in('"+IP_yn+"') ");
strAND="";
strOR="OR";
}											

if (DC_yn.equals("DC")){
whereClause.append(" "+strAND+"  "+strOR+"  CURR_PATIENT_CLASS in('"+DC_yn+"') ");
strAND="";
strOR="OR";

}												

if (OP_yn.equals("OP")){
whereClause.append(" "+strAND+" "+strOR+"  CURR_PATIENT_CLASS in('"+OP_yn+"') ");
strAND="";
strOR="OR";
}												

if (EM_yn.equals("EM")){
whereClause.append(" "+strAND+" "+strOR+"  CURR_PATIENT_CLASS in('"+EM_yn+"') ");
strAND="";
strOR="OR";
}												
/**Ends***/
/*************************Total Construction Of Where Clause Ends Here**************************************/


finalQuery=selectCaluse.append(fromClause);
if (flag.equals("Y")){

pagewhereClause=new StringBuffer(pageWhere);
whereClause=pagewhereClause;

finalQuery=finalQuery.append(pagewhereClause).append(orderByCaluse);
}
else{
finalQuery=finalQuery.append(whereClause).append(orderByCaluse);
}
//String contn_yn="Y";

try 
		{                   
				String dr_cnt_sql = "";
                dr_cnt_sql = "select count(1) total from ("+finalQuery.toString()+")";  

                rs = stmt.executeQuery(dr_cnt_sql);             
                if (rs.next())
                {
                    maxRecord = rs.getInt("total");
                }		
                Hit=Integer.parseInt(request.getParameter("Hit_Limit"));
                if(Hit==0) Hit = maxRecord ;
                if (maxRecord < Hit)
				{
					Hit_for_buttons = maxRecord;
				}else
				{
					Hit_for_buttons = Hit;
				}
			
           }

            catch( Exception e ) { Hit = maxRecord ; }

//			final_sql1 = "select "+main_select_sql + " from ( "+ final_sql +" )  where rownum < "+  (Hit +1) + " "+final_order_by+", v_patient_id, dup_indicator desc";
//			final_sql = final_sql1;

/**************Construction Of Where Condition Ends*********/
	%>
	<script>
	/* function SearchLimit(val) 
                {               
                    var hit=<%=Hit%>;
                    parent.frames[1].document.forms[0].ORDERBY.value="<%=order_by%>";
                }*/

/*                function modelPhoto(pat) 
                {   
                    var view_pat_photo_yn = "<%=view_pat_photo_yn%>";
                    var resp_name = "<%=resp_name%>";
                    if (view_pat_photo_yn=="Y")
                    {
                        var url     = "../../eCommon/jsp/PatientSearchPhoto.jsp?Patient_id=" + escape(pat);
                        var dialogHeight    = "17" ;
                        var dialogWidth = "20" ;
                        var arguments   = "" ;
                        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no";
                        var closeWin    = window.showModalDialog( url, arguments, features ) ;
                    }
                    else
                    {
                        var msg = getMessage("VIEW_PAT_PHOTO_RESTRICT",'MP'); msg = msg.replace('~',resp_name); alert(msg);
                    }
                }
*/
                function checkExpiry(pat_id,jsp_name,flag,func_id, sflag)
                {
					//alert("inside basicpatient 4");
					var sStyle = "<%=sStyle%>";
					 var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'>";
                     HTMLVal = HTMLVal +"<form name='form1' id='form1' method='post' action='../../eMP/jsp/PatSearchCheckAltIDExpiryDate.jsp'>";
                     HTMLVal = HTMLVal +"<input name='pat_id' id='pat_id' type='hidden' value= \""+escape(pat_id) + "\">";
                     HTMLVal = HTMLVal +"<input name='jsp_name' id='jsp_name' type='hidden' value= '"+jsp_name+"'>";
                     HTMLVal = HTMLVal +"<input name='flag' id='flag' type='hidden' value= '"+flag+"'>";
                     HTMLVal = HTMLVal +"<input name='func_id' id='func_id' type='hidden' value= '"+func_id+"'>";
                     HTMLVal = HTMLVal +"<input name='sflag' id='sflag' type='hidden' value= '"+sflag+"'>";
                     HTMLVal = HTMLVal +"<input name='win_width' id='win_width' type='hidden' value= '<%=win_width%>'>";
                     HTMLVal = HTMLVal +"<input name='win_top' id='win_top' type='hidden' value= '<%=win_top%>'>";
                     HTMLVal = HTMLVal +"<input name='win_height' id='win_height' type='hidden' value= '<%=win_height%>'>";
                     HTMLVal = HTMLVal +"</form></BODY></HTML>";
					 
                     parent.frames[5].document.write(HTMLVal);
                     parent.frames[5].document.form1.submit(); 
                }
            

              /*  function ViewPatDtl(Pat_id)
                {
					Pat_id=unescape(Pat_id)
                    var url         = "../jsp/ViewPatDetailsMain.jsp?Patient_ID="+escape(Pat_id);
                    var dialogTop       = "65";
                    var dialogHeight    = "40"; //33.4
                    var dialogWidth     = "65";
                    var arguments   = "" ;
                    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; status=no;";
                    var returnval = window.showModalDialog( url, arguments, features ) ;
                }
				/*
                function ViewPatDtlDup(Pat_id)
                {
                    var url         = "../jsp/ViewPatDetailsMain.jsp?disp_dup_pat_dtls=Duplicate&Patient_ID="+Pat_id;
                    var dialogTop       = "65";
                    var dialogHeight    = "33.4";
                    var dialogWidth     = "50";
                    var arguments   = "" ;
                    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; status=no;";
                    var returnval = window.showModalDialog( url, arguments, features ) ;
                }     
				*/
               /* function ordercols(field) 
                {   
                   
					var fsql = "<%=finalQuery.toString()%>";
					alert("fsql==>" +fsql);
					alert("field==>" +field);
					parent.frames[1].document.forms[0].FULLSQL.value = fsql;
                    var fullsqlstr=parent.frames[1].document.forms[0].FULLSQL.value;
                    parent.frames[1].document.forms[0].ORDERBY.value=field;                    
                    if ((parent.frames[1].document.forms[0].apply_oth_name) && (parent.frames[1].document.forms[0].search_in.value != "B"))
                    {
                        if (parent.frames[1].document.forms[0].apply_oth_name.checked)
                        {
                            field = field.toUpperCase();
                            if (field == "FIRST_NAME" || field ==  "SECOND_NAME" || field == "THIRD_NAME" || field ==  "FAMILY_NAME" || field == "PATIENT_NAME")
                                field = field+"_LOC_LANG";
                        }
                    }
                    document.forms[0].maxdisplay.value = parseInt(document.forms[0].maxdisplay.value); 
                    document.forms[0].maxdisplay1.value = parseInt(document.forms[0].maxdisplay1.value);
                    document.result_form.orderby.value=field;
                    document.forms[0].submit();
                }*/

              /*  function showMRNS(patientID)
                {
                    var url         = "../../eMP/jsp/MultipleMRN.jsp?Patient_Id="+escape(patientID);
                    var dialogTop       = "76";
                    var dialogHeight    = "15";
                    var dialogWidth     = "50";
                    var arguments   = "" ;
                    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; status=no;";
                    var returnval = window.showModalDialog( url, arguments, features ) ;
                    //RETURN VALUE COMES BACK ONLY IF THE SEARCH IS TRIGGERED FROM MP ONLINE REPORTS
                    if (returnval){
                        parent.frames[1].document.forms[0].reset();
                        
                        parent.frames[3].location.href = '../../eCommon/html/blank.html';
                        parent.frames[4].location.href = '../../eCommon/html/blank.html';
                        var retValArray = returnval.split(":");
                        PrintOnlineReports(retValArray[0],retValArray[1]);                      
                    }
                }

                function PrintOnlineReports(PatID,GenFN)
                {
                    var retVal =    new String();
                    var dialogHeight    = "30" ;
                    var dialogWidth = "70" ;
                    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;" ;
                    var arguments   = "" ;
                    retVal = window.showModalDialog("../../eCommon/jsp/InternalReportsReprint.jsp?module_id=MP&step=0&patient_id="+escape(PatID)+"&Gen_File_No="+escape(GenFN)+"&target=step2",arguments,features);                 
                }*/
	</script>

	<%

try
	{

if (maxRecord >= 1) {

			if (enablegenderyn.equals("N"))	
			out.println("<script>parent.Pat_Search_Criteria_Frame.document.forms[0].Sex.disabled=true;</script>");

			if (function_id.equals("DR_VALID_DUPLICATE_PATIENT") || function_id.equals("DR_ENTER_DUPLICATES") || 	function_id.equals("DR_MERGED_PATIENT_ID") || function_id.equals("DR_EXCLUDE_POSSIBLE_PATIENTS") 	|| function_id.equals("DR_EXCLUDED_PATIENT_ID"))
			out.println("<script>parent.Pat_Search_Criteria_Frame.document.forms[0].search_in.disabled=true;</script>");
			out.println("<script>parent.commontoolbar.location.href='../jsp/DupPatientSearchToolBar.jsp'</script>");

if (patient_id_length<=10){
%>
		<frameset cols='*'>
<%}
else{	%>
		<frameset cols='100%' BORDER=0 >
<%}%>			
			<frame name='PatIdResult' id='PatIdResult' src="../../eCommon/html/blank.html" frameborder=0  framespacing=0 noresize scrolling='no'>
			<!-- <frame name='PatDtlsResult' id='PatDtlsResult' src="../../eCommon/html/blank.html" frameborder=15 framespacing=0 noresize scrolling='auto'> -->
		</frameset>
		<script>
		var htmlVal="<html><body onKeyDown='lockKey()'><form name='f1' id='f1' action='../../eMP/jsp/DupPatientIDDisplay.jsp' method='post'>"+
						"<input type='hidden' name='From' id='From' value='<%=start%>'>"+
						"<input type='hidden' name='To' id='To' value='<%=end%>'>"+
						"<input type='hidden' name='mode' id='mode' value=''>"+
						"<input type='hidden' name='maxdisplay' id='maxdisplay' value='<%=maxDisplay%>'>"+
						"<input type='hidden' name='maxdisplay1' id='maxdisplay1' value='<%=maxDisplay1%>'>"+
						"<input type='hidden' name='searchthreshold' id='searchthreshold' value='<%=searchThreshold%>'>"+
						"<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>"+
						"<input type='hidden' name='search_in' id='search_in' value=\"<%=search_in%>\">"+
						"<input type='hidden' name='ip_install_yn' id='ip_install_yn' value='<%=ip_install_yn%>'>"+
						"<input type='hidden' name='op_install_yn' id='op_install_yn' value='<%=op_install_yn%>'>"+
						"<input type='hidden' name='sex' id='sex' value=''>"+
						"<input type='hidden' name='age' id='age' value=''>"+
						"<input type='hidden' name='min_age' id='min_age' value=''>"+
						"<input type='hidden' name='func_act' id='func_act' value=\"<%=func_act%>\">"+
						"<input type='hidden' name='allow_nb_review' id='allow_nb_review' value=\"<%=allow_nb_review%>\">"+
						"<input type='hidden' name='j_select' id='j_select' value=\"<%=j_select%>\">"+
						"<input type='hidden' name='j_new_select' id='j_new_select' value=\"<%=j_new_select%>\">"+
						"<input type='hidden' name='j_from' id='j_from' value='<%=j_from%>'>"+
						"<input type='hidden' name='orderby' id='orderby' value=\"<%=order_by%>\">"+
						"<input type='hidden' name='Hit_Limit' id='Hit_Limit' value=\"<%=Hit%>\">"+
						"<input type='hidden' name='p_no' id='p_no' value=\"<%=pat_id%>\">"+
						"<input type='hidden' name='na_no' id='na_no' value=\"<%=National_Id_No%>\">"+
						"<input type='hidden' name='win_top' id='win_top' value=\"<%=win_top%>\">"+
						"<input type='hidden' name='win_width' id='win_width' value=\"<%=win_width%>\">"+
						"<input type='hidden' name='win_height' id='win_height' value=\"<%=win_height%>\">"+
						"<input type='hidden' name='act_yn' id='act_yn' value=\"<%=act_yn%>\">"+
						"<input type='hidden' name='srr' id='srr' value=\"<%=srr%>\">"+
						"<input type='hidden' name='old_file_no_where' id='old_file_no_where' value=\"<%=old_file_no_where%>\">"+
						"<input type='hidden' name='file_no_where' id='file_no_where' value=\"<%=file_no_where%>\">"+
						"<input type='hidden' name='MRN' id='MRN' value=\"<%=MRN%>\">"+
						"<input type='hidden' name='OldFileNo' id='OldFileNo' value=\"<%=OldFileNo%>\">"+
						"<input type='hidden' name='apply_oth_name' id='apply_oth_name' value=\"<%=apply_oth_name%>\">"+
						"<input type='hidden' name='cntPrefFac' id='cntPrefFac' value=\"<%=cntPrefFac%>\">"+
						"<input type='hidden' name='usePatIDIndex' id='usePatIDIndex' value=\"<%=usePatIDIndex%>\">"+
						"<input type='hidden' name='view_pat_photo_yn' id='view_pat_photo_yn' value=\"<%=view_pat_photo_yn%>\">	"+
						"<input type='hidden' name='TotalNoRecords' id='TotalNoRecords' value=\"<%=TotalNoRecords%>\">"+
						"<input type='hidden' name='enablegenderyn' id='enablegenderyn' value=\"<%=enablegenderyn%>\">"+
						"<input type='hidden' name='maxRecord' id='maxRecord' value=\"<%=maxRecord%>\">"+"<input type='hidden' name='final_sql' id='final_sql' value=\"<%=finalQuery.toString()%>\">"+ // Added on 08/11/2004
						"<input type='hidden' name='totalpercent' id='totalpercent' value=\"<%=totalpercent%>\">"+
						"<input type='hidden' name='photo' id='photo' value=\"<%=photo%>\">"+
						"<input type='hidden' name='alignment' id='alignment' value=\"<%=alignment%>\">"+
						"<input type='hidden' name='othlang' id='othlang' value=\"<%=othlang%>\">"+		// End addition on 08/11/2004
						"<input type='hidden' name='whereClause' id='whereClause' value=\"<%=whereClause.toString()%>\">"+		// End addition on 08/11/2004
						"</form></body></html>";
			
			// Added on 08/11/2004
			
			//var htmlPatFrame = "<html><body><form name='f1' id='f1' action='../../eMP/jsp/PatientIDDisplay.jsp' method='post'>"+htmlVal
			PatIdResult.document.write(htmlVal);
			PatIdResult.document.f1.submit(); 
			
		/*	var htmlPatDtlFrame ="<html><body><form name='f2' id='f2' action='../../eMP/jsp/PatientDetailsDisplay.jsp' method='post'>"+htmlVal
			PatDtlsResult.document.write(htmlPatDtlFrame);
			PatDtlsResult.document.f2.submit();
			*/
			//End of addition on 08/11/2004*/
			
		</script>
  <%          }// End of else (final_sql)
			  else
			  {%>
				<script>
					alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
			  		var PatientSearchCrt_Form=parent.frames[1].document.forms[0];
				 
				 for (var i=0;i<PatientSearchCrt_Form.elements.length;i++) {				
						 PatientSearchCrt_Form.elements[i].disabled=false;
						}
						parent.Pat_Search_Toolbar_Frame.document.forms[0].Search.disabled= false;
						if(PatientSearchCrt_Form.maintain_doc_or_file.value == 'D') { ;
							PatientSearchCrt_Form.MRN.disabled = true;
							PatientSearchCrt_Form.OldFileNo.disabled = true; 
				}
					if (PatientSearchCrt_Form.register !=null) 
							PatientSearchCrt_Form.register.disabled=false;
					parent.document.frames[1].enableRegister();
				</script>
				<script>
					var PatientSearchCrt_Form=parent.frames[1].document.forms[0];
					if (PatientSearchCrt_Form.searchby !=null && PatientSearchCrt_Form.searchby.value =='' )																					PatientSearchCrt_Form.searchby.disabled=false;
				</script>
			<%
				if (enablegenderyn.equals("N"))	
						out.println("<script>parent.frames[1].document.forms[0].Sex.disabled=true;</script>");
				 if (function_id.equals("DR_VALID_DUPLICATE_PATIENT") || function_id.equals("DR_ENTER_DUPLICATES") || 	function_id.equals("DR_MERGED_PATIENT_ID") || function_id.equals("DR_EXCLUDE_POSSIBLE_PATIENTS") 	|| function_id.equals("DR_EXCLUDED_PATIENT_ID"))
				out.println("<script>parent.Pat_Search_Criteria_Frame.document.forms[0].search_in.disabled=true;</script>");	
				out.println("<script>parent.commontoolbar.location.href='../jsp/PatientSearchToolBar.jsp'</script>");			
			  }
}
catch(Exception e) {
    e.printStackTrace();
    out.println("Error : " + e);
	out.println("<script>");
	out.println("for (var i=0;i<parent.frames[1].document.forms[0].elements.length;i++) {				parent.frames[1].document.forms[0].elements[i].disabled=false;}");
	out.println("parent.Pat_Search_Toolbar_Frame.document.forms[0].Search.disabled = false;");
	out.println("if(parent.frames[1].document.forms[0].maintain_doc_or_file.value == 'D') {");
	out.println("parent.frames[1].document.forms[0].MRN.disabled = true;");
	out.println("parent.frames[1].document.forms[0].OldFileNo.disabled = true; }");
	out.println("parent.document.frames[1].enableRegister()");
	out.println("</script>");
	//Added by kumar on 16/03/2003 for disabling the searchby when soundex is selected.
	out.println("<script>if (parent.frames[1].document.forms[0].searchby !=null) if (parent.frames[1].document.forms[0].searchby.value =='') parent.frames[1].document.forms[0].searchby.disabled=true;</script>");
	/*if (enablegenderyn.equals("N"))	
		out.println("<script>parent.frames[1].document.forms[0].Sex.disabled=true;</script>");
	if (function_id.equals("DR_VALID_DUPLICATE_PATIENT") || function_id.equals("DR_ENTER_DUPLICATES") || 	function_id.equals("DR_MERGED_PATIENT_ID") || function_id.equals("DR_EXCLUDE_POSSIBLE_PATIENTS") 	|| function_id.equals("DR_EXCLUDED_PATIENT_ID"))
		out.println("<script>parent.frames[1].document.forms[0].search_in.disabled=true;</script>");*/
	out.println("<script>parent.frames[0].location.href='../jsp/PatientSearchToolBar.jsp'</script>");			
}
finally {    
    if(rs != null) rs.close();
	if(rsx != null) rsx.close();
    if(rs1 != null) rs1.close();
    if(rs2 != null) rs2.close();
    if(rs3 != null) rs3.close();
    if(rs4 != null) rs4.close();
    if(rs5 != null) rs5.close();
    if(rs6 != null) rs6.close();
	if(rsnew != null) rsnew.close();
	if(stmt != null) stmt.close();
	if (stmtx!=null) stmtx.close();
	if (stmt_7!=null) stmt_7.close();
	if (stmt8!=null) stmt8.close();
	if (stmt_new!=null) stmt_new.close();
	if (pstmt_new!=null) pstmt_new.close();	
    }

}

catch(Exception e){out.println("Exception ::"+e);}
finally{
if(conn!=null)ConnectionManager.returnConnection(conn,request);
}
%>
<input type="hidden" name="whereClause" id="whereClause" value="<%=whereClause.toString()%>">
</CENTER></HTML>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

