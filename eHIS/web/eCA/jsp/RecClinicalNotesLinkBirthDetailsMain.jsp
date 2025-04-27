<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="BornBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<html>
	<head>
		<title></title>
		<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<!-- added by Kishore Kumar N on 10/12/2008  -->
		
		<!-- end here -->
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCA/js/RecClinicalNotesLinkBirthDetail.js">
	    </script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>

</head>

<%
	java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p1.getProperty("LOCALE");

	String gestational_period= "";
	String delivery_type= "";
	String gravida= "";
	String complications= "";
	String delyinddesc= "";
//	String remarks= "";
	String nb_sex= "";
	String relationship= "";
	String outcome= "";
	String parity= "";
	String indicator_mark= "";
	String lengthof= "";
	String weight= "";
	String bornat= "";
	String birthplace_desc= "";
	String bornwhere= "";
	String birthcertificateno= "";
	String nbbirthdate= "";
	String headcircumference= "";
	String chestcircumference= "";
	String apgarscorein1mins= "";
	String apgarscorein5mins= "";
	String apgarscorein10mins= "";
	String umbilicalcordstatus= "";
	String feedingdesc= "";
	String feeding= "";
	String patencyofanusyn= "";
	String stools= "";
	String stools1= "";
	String vaginaldelytypedesc = "";
	String procclassific = "";
	String surgicalclassify = "";
	String noofbirths = "";
	String conganomdesc = "";
	String umbcordcutby = "";
	String bcg_admin_dtls = "";
	String vitak_admin_dtls  = "";
	String hepB_admin_dtls  = "";
	String UNIT_OF_WT_NB="";
	String UNIT_OF_WT_NB_s="";
	String UNIT_OF_WT_NB_m="";
	String UNIT_OF_CIRCUM_NB="";
	String UNIT_OF_CIRCUM_NB_s="";
	String UNIT_OF_CIRCUM_NB_m="";
	String UNIT_OF_CHEST_CIRCUM_NB="";
	String UNIT_OF_CHEST_CIRCUM_NB_s="";
	String UNIT_OF_CHEST_CIRCUM_NB_m="";
	String UNIT_OF_LENGTH_NB="";
	String UNIT_OF_LENGTH_NB_s="";
	String UNIT_OF_LENGTH_NB_m="";
	String UNIT_OF_GEST_NB="";
	String UNIT_OF_GEST_NB_s="";
	String UNIT_OF_GEST_NB_m="";
	String father_patient_name = "", father_nat_desc = "", race_desc = "", father_gove_employee_yn ="", ocpn_class_desc = "";
	String ocpn_desc = "", relgn_desc = "", father_remarks = "";
	String nb_born_id = "", nb_born_name = "";
	String  multiple_birth_yn = "", compln_pregnancy_desc = "";
	String blood_grp = "", compln_nr_pregnancy_desc = "";
	String attend_physician_id = "", attend_midwife_id = "";
	String complns_1st_desc = "", complns_2nd_desc = "", complns_3rd_desc = "";
	String order = "";
	String gestational_period_in_days = "";
	String mother_yn = "";

	ArrayList  fields			=	new ArrayList();
	String categ_sec_qry ="";
	String field_ref ="";
	String col_field ="";
	PreparedStatement pstmt=null;
	ResultSet rset=null;

	StringBuffer strsql1 = new StringBuffer(" ");
	StringBuffer countsql = new StringBuffer(" ");
	StringBuffer montherCountsql = new StringBuffer(" ");
	StringBuffer monthersql = new StringBuffer(" ");
	StringBuffer fathersql = new StringBuffer(" ");
	StringBuffer babysql = new StringBuffer(" ");

	String mother_encounter_id	= request.getParameter("mother_encounter_id")==null?"":request.getParameter("mother_encounter_id");
	String patient_id	= java.net.URLDecoder.decode(request.getParameter("patient_id")==null?"":request.getParameter("patient_id"));
	String return_format=(request.getParameter("return_format")==null)?"":request.getParameter("return_format");
	String result_linked_rec_type		=	request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type");
	String sec_hdg_code		=	request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");
	String facility_id = (String)session.getValue("facility_id");
		
	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	try
	{
		con =  ConnectionManager.getConnection(request);
	  
		//shaiju new diag starts
	  
		categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_SEC_DEF F where f.SEC_HDG_CODE =? and f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY=? order by ORDER_SEQ_NUM";

		pstmt = con.prepareStatement(categ_sec_qry);
		
		pstmt.setString(1,sec_hdg_code);
		pstmt.setString(2,result_linked_rec_type);
		pstmt.setString(3,result_linked_rec_type);

		rset = pstmt.executeQuery();

		if(rset.next())
		{
			do
			{
				field_ref = rset.getString("FIELD_REF")==null?"":rset.getString("FIELD_REF");
				fields.add(field_ref);
				if(order.equals(""))
					order = field_ref;
				else
					order = order + "~"+ field_ref;
			}
			while(rset.next());
		}
		else
		{
			if (rset != null) rset.close();
			if (pstmt != null) pstmt.close();

			categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_DEF  F where f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY=? order by ORDER_SEQ_NUM";

			pstmt = con.prepareStatement(categ_sec_qry);
			pstmt.setString(1,result_linked_rec_type);
			pstmt.setString(2,result_linked_rec_type);

			rset = pstmt.executeQuery();

			if(rset.next())
			{
				do
				{
					field_ref = rset.getString("FIELD_REF")==null?"":rset.getString("FIELD_REF");
					fields.add(field_ref);
					if(order.equals(""))
						order = field_ref;
					else
						order = order + "~"+ field_ref;
				}
				while(rset.next());

				if (rset != null) rset.close();
				if(pstmt != null) pstmt.close();
			}
		}

	  //shaiju new diag ends
	  
		stmt = con.prepareStatement("select UNIT_OF_WT_NB,UNIT_OF_CIRCUM_NB,UNIT_OF_CHEST_CIRCUM_NB,UNIT_OF_LENGTH_NB,UNIT_OF_GEST_NB from mp_param");
		rs = stmt.executeQuery();
		if(rs != null && rs.next())
		{
			//UNIT_OF_WT_NB = rs.getString(1);
			UNIT_OF_GEST_NB = rs.getString(1) == null ? "" : rs.getString(1); //Handled for Null Pointer Exception
			if(UNIT_OF_WT_NB.equalsIgnoreCase("K"))
			{
				UNIT_OF_WT_NB_s = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.kg.label","common_labels");
				UNIT_OF_WT_NB_m = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Kgs.label","common_labels");
			}
			else if(UNIT_OF_WT_NB.equalsIgnoreCase("L"))
			{
				UNIT_OF_WT_NB_s = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.lb.label","common_labels");
				UNIT_OF_WT_NB_m = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Lbs.label","common_labels");
			}
			//UNIT_OF_CIRCUM_NB = rs.getString(2);
			UNIT_OF_GEST_NB = rs.getString(2) == null ? "" : rs.getString(2); //Handled for Null Pointer Exception
			if(UNIT_OF_CIRCUM_NB.equalsIgnoreCase("I"))
			{
				UNIT_OF_CIRCUM_NB_s=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inch.label","common_labels");
				UNIT_OF_CIRCUM_NB_m=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Inchs.label","ca_labels");
			}
			else if(UNIT_OF_CIRCUM_NB.equalsIgnoreCase("C"))
			{
				UNIT_OF_CIRCUM_NB_s=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cm.label","common_labels");
				UNIT_OF_CIRCUM_NB_m=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Cms.label","common_labels");
			}

			//UNIT_OF_CHEST_CIRCUM_NB = rs.getString(3);
			UNIT_OF_GEST_NB = rs.getString(3) == null ? "" : rs.getString(3); //Handled for Null Pointer Exception
			if(UNIT_OF_CHEST_CIRCUM_NB.equalsIgnoreCase("I"))
			{
				UNIT_OF_CHEST_CIRCUM_NB_s=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inch.label","common_labels");
				UNIT_OF_CHEST_CIRCUM_NB_m=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Inchs.label","ca_labels");
			}
			else if(UNIT_OF_CHEST_CIRCUM_NB.equalsIgnoreCase("C"))
			{
				UNIT_OF_CHEST_CIRCUM_NB_s=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cm.label","common_labels");
				UNIT_OF_CHEST_CIRCUM_NB_m=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Cms.label","common_labels");
			}

			//UNIT_OF_LENGTH_NB = rs.getString(4);
			UNIT_OF_GEST_NB = rs.getString(4) == null ? "" : rs.getString(4); //Handled for Null Pointer Exception
			if(UNIT_OF_LENGTH_NB.equalsIgnoreCase("I"))
			{
				UNIT_OF_LENGTH_NB_s=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inch.label","common_labels");
				UNIT_OF_LENGTH_NB_m=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Inchs.label","ca_labels");
			}
			else if(UNIT_OF_LENGTH_NB.equalsIgnoreCase("C"))
			{
				UNIT_OF_LENGTH_NB_s=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cm.label","common_labels");
				UNIT_OF_LENGTH_NB_m=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Cms.label","common_labels");
			}

			//UNIT_OF_GEST_NB = rs.getString(5);
			UNIT_OF_GEST_NB = rs.getString(5) == null ? "" : rs.getString(5); //Handled for Null Pointer Exception
			if(UNIT_OF_GEST_NB.equalsIgnoreCase("W"))
			{
				UNIT_OF_GEST_NB_s=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Week.label","common_labels");
				UNIT_OF_GEST_NB_m=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weeks.label","common_labels");
			}
			else if(UNIT_OF_GEST_NB.equalsIgnoreCase("D"))
			{
				UNIT_OF_GEST_NB_s=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.day.label","common_labels");
				UNIT_OF_GEST_NB_m=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
			}
		}
		if(rs!=null) rs.close();
		if(stmt!=null)stmt.close();	
	}
	catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception cauight in RecClinicalNotesLinkBirthMain.jsp" + e);//common-icn-0181
	}
	
	/* check for baby patient count*/
	countsql.append("SELECT COUNT(*) as total FROM mp_birth_register_vw where patient_id = ? ");
	/* check for Mother patient count*/
	montherCountsql.append("SELECT COUNT(*) as total FROM MP_BIRTH_REGISTER A  WHERE MOTHER_PATIENT_ID = ?  and MOTHER_ENCOUNTER_ID = ? and ENCOUNTER_FACILITY_ID = ?  /*AND TRUNC(TIME_OF_BIRTH)>   (SELECT MAX(TRUNC(TIME_OF_BIRTH))-1 FROM MP_BIRTH_REGISTER  WHERE MOTHER_PATIENT_ID = A.MOTHER_PATIENT_ID AND MONTHS_BETWEEN(SYSDATE,TIME_OF_BIRTH)<=12)*/  ");
	/*
	strsql1.append("select no_of_births noofBirths,gestational_period,parity,delivery_type,gravida,parity,(select long_desc from MP_COMPLN_DELIVERY where COMPLN_DELY_CODE=a.COMPLN_DELY_CODE) complications,DELY_IND_DESC,(select short_desc from mp_proc_classification where proc_class_code = a.PROC_CLASS_CODE) procclassific,VAGINAL_DELY_TYPE_DESC,(select short_desc from mp_dely_surg_classification where dely_surg_class_code = a.DELY_SURG_CLASS_CODE) surgicalclassify,remarks,nb_sex,(SELECT short_desc FROM MP_RELATIONSHIP WHERE RELATIONSHIP_CODE = (SELECT decode(upper(substr(nb_sex,1,1)),'M',NB_MALE_RELNSHIP,'F',NB_FEMALE_RELNSHIP ,NB_UNKNOWN_RELNSHIP) FROM MP_PARAM)) relationship,outcome,indicator_mark,nb_birth_date||' '||NB_BIRTH_TIME nb_birth_date,BIRTH_CERTIFICATE_NO,born_where,birth_place_desc,born_at,weight,length,head_circumference,chest_circumference,APGAR_SCORE_IN_1_MIN,apgar_score_in_5_mins,apgar_score_in_10_mins,umbilical_cord_status,(select short_name from am_practitioner where practitioner_id=UMB_CORD_CUT_BY) UMB_CORD_CUT_BY,decode(feeding,'T','Breast','B','Bottle','Other') feeding_desc,patency_of_anus_yn,CONG_ANOM_DESC,decode(stools,'M','Meconium','Y','Yellow Soft','Other' ) stools ");
	
	strsql1.append(",nvl2(VACCINATION_SITE,'Site:'||VACCINATION_SITE,null)||nvl2(ADMINISTERED_BY,';  Administered By:'||ADMINISTERED_BY||','||ADMINISTERED_DESIGNATION,null)||nvl2(BCG_VACC_ADMN_DATE, '  on'||to_char(BCG_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi'),null) bcg_admin_dtls,nvl2(Vitak_vacc_site,'Site:'||Vitak_vacc_site,null) ||nvl2(Vitak_administered_by,';  Administered By:'||Vitak_administered_by||','||Vitak_administered_desig,null)||nvl2(VITK_VACC_ADMN_DATE, '  on '||to_char(VITK_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi'),null) Vitak_admin_dtls,nvl2(HEPB_VACC_SITE,'Site:'||HEPB_VACC_SITE,null)  ||nvl2(HEPB_ADMINISTERED_BY,';  Administered By:'||HEPB_ADMINISTERED_BY||','||HEPB_ADMINISTERED_DESIG,null) 						 ||nvl2(HEPB_VACC_ADMN_DATE, '  on '||to_char(HEPB_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi'),null) HepB_admin_dtls  ");
	*/

	monthersql.append("select no_of_births noofBirths,gestational_period,GESTATIONAL_PERIOD_IN_DAYS,parity,delivery_type,gravida,parity,MP_GET_DESC.MP_COMPLN_DELIVERY(a.COMPLN_DELY_CODE,?,'2') complications,DELY_IND_DESC,MP_GET_DESC.MP_PROC_CLASSIFICATION(a.PROC_CLASS_CODE,?,'2') procclassific, VAGINAL_DELY_TYPE_DESC,MP_GET_DESC.MP_DELY_SURG_CLFN(a.DELY_SURG_CLASS_CODE,?,'2') surgicalclassify, MULTIPLE_BIRTH_YN, COMPLN_PREGNANCY_DESC, COMPLN_NR_PREGNANCY_DESC, AM_GET_DESC.AM_PRACTITIONER(a.ATTEND_PHYSICIAN_ID,?,'1') ATTEND_PHYSICIAN_ID, AM_GET_DESC.AM_PRACTITIONER(a.ATTEND_MIDWIFE_ID,?,'1') ATTEND_MIDWIFE_ID, (select SHORT_DESC from mp_compln_delivery_lang_vw where  COMPLN_DELY_CODE = a.COMPLNS_1ST_STAGE_LABOUR_CODE and language_id = ?) complns_1st_desc, (select SHORT_DESC from mp_compln_delivery_lang_vw where  COMPLN_DELY_CODE = a.COMPLNS_2ND_STAGE_LABOUR_CODE and language_id = ?) complns_2nd_desc, (select SHORT_DESC from mp_compln_delivery_lang_vw where  COMPLN_DELY_CODE = a.COMPLNS_3RD_STAGE_LABOUR_CODE and language_id = ?) complns_3rd_desc from mp_birth_register_vw a ");

	fathersql.append("select FATHER_PATIENT_NAME, FATHER_NAT_DESC, ETH_GRP_DESC RACE_DESC, FATHER_GOVE_EMPLOYEE_YN, OCPN_CLASS_DESC, nvl(OCPN_DESC,FATHER_OCPN_DESC) OCPN_DESC, RELGN_DESC, FATHER_REMARKS from mp_birth_register_vw a ");

	babysql.append("select nb_sex,(SELECT short_desc FROM MP_RELATIONSHIP_LANG_VW WHERE LANGUAGE_ID = ?  AND RELATIONSHIP_CODE = (SELECT decode(upper(substr(nb_sex,1,1)),'M',NB_MALE_RELNSHIP,'F',NB_FEMALE_RELNSHIP ,NB_UNKNOWN_RELNSHIP) FROM MP_PARAM)) relationship,outcome,indicator_mark,nb_birth_date||' '||NB_BIRTH_TIME nb_birth_date,BIRTH_CERTIFICATE_NO,born_where,birth_place_desc,born_at,weight,length,head_circumference,chest_circumference,APGAR_SCORE_IN_1_MIN,apgar_score_in_5_mins,apgar_score_in_10_mins,umbilical_cord_status,nvl(AM_GET_DESC.AM_PRACTITIONER(UMB_CORD_CUT_BY,?,'1'),UMB_CORD_CUT_BY) UMB_CORD_CUT_BY,feeding feeding_desc,patency_of_anus_yn,CONG_ANOM_DESC, stools, a.patient_id, NB_PATIENT_NAME, nvl2(VACCINATION_SITE,'Site: '||VACCINATION_SITE||';',null)||nvl2(ADMINISTERED_BY,'&nbsp; Administered By: '||ADMINISTERED_BY||';',null)||nvl2(ADMINISTERED_DESIGNATION,'&nbsp; Designation: '||ADMINISTERED_DESIGNATION||';',null)||nvl2(BCG_VACC_ADMN_DATE, '&nbsp; Administered Date: '||to_char(BCG_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi')||';',null) bcg_admin_dtls, nvl2(Vitak_vacc_site,'Site: '||Vitak_vacc_site||';',null) ||nvl2(Vitak_administered_by,'&nbsp; Administered By: '||Vitak_administered_by||';',null)||nvl2(Vitak_administered_desig,'&nbsp; Designation: '||Vitak_administered_desig||';',null)||nvl2(VITK_VACC_ADMN_DATE, '&nbsp; Administered Date: '||to_char(VITK_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi')||';',null)Vitak_admin_dtls, nvl2(HEPB_VACC_SITE,'Site: '||HEPB_VACC_SITE||';',null)  ||nvl2(HEPB_ADMINISTERED_BY,'&nbsp; Administered By: '||HEPB_ADMINISTERED_BY||';',null)||nvl2(HEPB_ADMINISTERED_DESIG,'&nbsp; Designation: '||HEPB_ADMINISTERED_DESIG||';',null)||nvl2(HEPB_VACC_ADMN_DATE, '&nbsp; Administered Date: '||to_char(HEPB_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi')||';',null) HepB_admin_dtls, (select short_desc from mr_blood_grp_lang_vw where blood_grp = b.BLOOD_GRP and language_id = ?) BLOOD_GRP from mp_birth_register_vw a, MP_PAT_OTH_DTLS b ");

	//strsql1.append("select no_of_births noofBirths,gestational_period,parity,delivery_type,gravida,parity,MP_GET_DESC.MP_COMPLN_DELIVERY(a.COMPLN_DELY_CODE,?,'1') complications,DELY_IND_DESC,MP_GET_DESC.MP_PROC_CLASSIFICATION(a.PROC_CLASS_CODE,?,'2') procclassific, VAGINAL_DELY_TYPE_DESC,MP_GET_DESC.MP_DELY_SURG_CLFN(a.DELY_SURG_CLASS_CODE,?,'2') surgicalclassify,remarks,nb_sex,(SELECT short_desc FROM MP_RELATIONSHIP_LANG_VW WHERE LANGUAGE_ID = ?  AND RELATIONSHIP_CODE = (SELECT decode(upper(substr(nb_sex,1,1)),'M',NB_MALE_RELNSHIP,'F',NB_FEMALE_RELNSHIP ,NB_UNKNOWN_RELNSHIP) FROM MP_PARAM)) relationship,outcome,indicator_mark,nb_birth_date||' '||NB_BIRTH_TIME nb_birth_date,BIRTH_CERTIFICATE_NO,born_where,birth_place_desc,born_at,weight,length,head_circumference,chest_circumference,APGAR_SCORE_IN_1_MIN,apgar_score_in_5_mins,apgar_score_in_10_mins,umbilical_cord_status,AM_GET_DESC.AM_PRACTITIONER(UMB_CORD_CUT_BY,?,'2') UMB_CORD_CUT_BY,feeding feeding_desc,patency_of_anus_yn,CONG_ANOM_DESC, stools, a.patient_id, NB_PATIENT_NAME, MULTIPLE_BIRTH_YN, COMPLN_PREGNANCY_DESC, b.BLOOD_GRP, AM_GET_DESC.AM_PRACTITIONER(a.ATTEND_PHYSICIAN_ID,?,'2') ATTEND_PHYSICIAN_ID, AM_GET_DESC.AM_PRACTITIONER(a.ATTEND_MIDWIFE_ID,?,'2') ATTEND_MIDWIFE_ID ");

	//strsql1.append(" ,(select SHORT_DESC from mp_compln_delivery_lang_vw where  COMPLN_DELY_CODE = a.COMPLNS_1ST_STAGE_LABOUR_CODE) complns_1st_desc, (select SHORT_DESC from mp_compln_delivery_lang_vw where  COMPLN_DELY_CODE = a.COMPLNS_2ND_STAGE_LABOUR_CODE) complns_2nd_desc, (select SHORT_DESC from mp_compln_delivery_lang_vw where  COMPLN_DELY_CODE = a.COMPLNS_3RD_STAGE_LABOUR_CODE) complns_3rd_desc,FATHER_PATIENT_NAME, FATHER_NAT_DESC, RACE_DESC, FATHER_GOVE_EMPLOYEE_YN, OCPN_CLASS_DESC, OCPN_DESC, RELGN_DESC, FATHER_REMARKS");

	//strsql1.append(",nvl2(VACCINATION_SITE,'Site:'||VACCINATION_SITE,null)||nvl2(ADMINISTERED_BY,';  Administered By:'||ADMINISTERED_BY||','||ADMINISTERED_DESIGNATION,null)||nvl2(BCG_VACC_ADMN_DATE, '  on'||to_char(BCG_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi'),null) bcg_admin_dtls,nvl2(Vitak_vacc_site,'Site:'||Vitak_vacc_site,null) ||nvl2(Vitak_administered_by,';  Administered By:'||Vitak_administered_by||','||Vitak_administered_desig,null)||nvl2(VITK_VACC_ADMN_DATE, '  on '||to_char(VITK_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi'),null) Vitak_admin_dtls,nvl2(HEPB_VACC_SITE,'Site:'||HEPB_VACC_SITE,null)  ||nvl2(HEPB_ADMINISTERED_BY,';  Administered By:'||HEPB_ADMINISTERED_BY||','||HEPB_ADMINISTERED_DESIG,null) 						 ||nvl2(HEPB_VACC_ADMN_DATE, '  on '||to_char(HEPB_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi'),null) HepB_admin_dtls  ");

    //strsql1.append("from mp_birth_register_vw a "); 
	
	int j=0;
	int m=0;
	int i=1;
	int k=0;
	int lm=0;
//	int lb=0;
	int b=0;
	int f=0;
	int lf=0;
	int bd=0,  lbd=0;
	int bc=0,  lbc=0;
	int v=0,  lv=0;
	int ba=0,  lba=0;
	int maxRecord =0;
//	boolean flag = true;
	
   	try
	{
		stmt = con.prepareStatement(countsql.toString());
	   
		int st = 0;
		stmt.setString(++st,patient_id); 
		rs = stmt.executeQuery();

		if(rs!=null && rs.next())
		{
			maxRecord = rs.getInt("total");
		}
     
		if(rs!=null) rs.close();
		if(stmt!=null)stmt.close();
		
 		if (maxRecord > 0)
		  strsql1.append(" where a.patient_id = ? and MOTHER_ENCOUNTER_ID = ? and ENCOUNTER_FACILITY_ID = ? ");
		else if (maxRecord == 0)
		{
			stmt = con.prepareStatement(montherCountsql.toString());
			stmt.setString(1,patient_id); 
			stmt.setString(2,mother_encounter_id);
			stmt.setString(3,facility_id);
			rs = stmt.executeQuery();

			if(rs!=null && rs.next())
			{
				maxRecord = rs.getInt("total");
				mother_yn = "Y";
			}
		 
			if(rs!=null) rs.close();
			if(stmt!=null)stmt.close();
			if (maxRecord == 0)
			{
				strsql1.append(" where a.patient_id = ? and MOTHER_ENCOUNTER_ID = ? and ENCOUNTER_FACILITY_ID = ? ");
	%>
			<script>
				//alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
			</script>
	<%
			}	
		    else
			{
				strsql1.append(" WHERE MOTHER_PATIENT_ID=?  and MOTHER_ENCOUNTER_ID = ? and ENCOUNTER_FACILITY_ID = ? /*AND to_date(NB_BIRTH_DATE,'dd/mm/yyyy')>   (SELECT MAX(TRUNC(TIME_OF_BIRTH))-1 FROM MP_BIRTH_REGISTER  WHERE MOTHER_PATIENT_ID=a.MOTHER_PATIENT_ID AND MONTHS_BETWEEN(SYSDATE,TIME_OF_BIRTH)<=12)*/  ");
			}
		}
		
		/*st = 0;
		stmt = con.prepareStatement(strsql1.toString());
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,patient_id);
        
		rs = stmt.executeQuery();*/
	%>

<body onScroll="scrollTitle()" onKeyDown="lockKey()">
<script language=javascript>
	document.body.style.scrollbarBaseColor='#E2E3F0';
	document.body.style.scrollbarArrowColor='#000080';
	document.body.style.scrollbarDarkShadowColor='#E2E3F0';
	document.body.style.scrollbarFaceColor='#E2E3F0';
	document.body.style.scrollbarHighlightColor='white';
	document.body.style.scrollbarShadowColor='#E2E3F0';
	document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<form name="RecClinicalNotesLinkBornResultForm" id="RecClinicalNotesLinkBornResultForm">	
	<!-- <div id='divDataTitle' style='postion:relative'>
	<table border="1" id="finalDiv" cellpadding="3" cellspacing="0" width="100%" align="center">
		<tr >
			<td width='100%' class='CAGROUP' align=center><b><font size='2'><fmt:message key="Common.searchresult.label" bundle="${common_labels}"/></b></td>
		</tr>
		<tr><td class='columnheader' width="8%" style="font-size:10" ><fmt:message key="Common.all.label" bundle="${common_labels}"/><input type='checkbox' name='ctrlChkBox' id='ctrlChkBox' onClick="javascript:perform(this);" ></td>
		</tr>
	</table>
	</div> -->
<%
	if(maxRecord == 0)
	{
%>
		<script>
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
		</script>
<%
	}
	else
	{
%>

	<table class="grid" width="100%" align="center" name="resultTable" id="resultTable" id="resultTable">
 
<% 
	String classValue = "gridData";

	/*while(rs!=null && rs.next() )
	{
		gestational_period=rs.getString("gestational_period") == null ? " " : rs.getString("gestational_period");
		delivery_type=rs.getString("delivery_type") == null ? " " : rs.getString("delivery_type");
		noofbirths=rs.getString("noofBirths") == null ? " " : rs.getString("noofBirths");
		procclassific=rs.getString("procclassific")==null?" ":rs.getString("procclassific");
		vaginaldelytypedesc=rs.getString("vaginal_dely_type_desc")==null?" ":rs.getString("vaginal_dely_type_desc");
		surgicalclassify=rs.getString("surgicalclassify")==null?" ":rs.getString("surgicalclassify");
		gravida=rs.getString("gravida")==null?" ":rs.getString("gravida");
		complications=rs.getString("complications")==null?" ":rs.getString("complications");
		delyinddesc=rs.getString("DELY_IND_DESC")==null?" ":rs.getString("DELY_IND_DESC");
		parity=rs.getString("parity")==null?" ":rs.getString("parity");
		remarks=rs.getString("remarks")==null?" ":rs.getString("remarks");
		
		nb_sex=rs.getString("nb_sex")==null?" ":rs.getString("nb_sex");
		relationship=rs.getString("relationship")==null?" ":rs.getString("relationship");
		outcome=rs.getString("outcome")==null?" ":rs.getString("outcome");
		indicator_mark=rs.getString("indicator_mark")==null?" ":rs.getString("indicator_mark");
		lengthof=rs.getString("length")==null?" ":rs.getString("length");
		weight=rs.getString("weight")==null?" ":rs.getString("weight");
		bornat=rs.getString("born_at")==null?" ":rs.getString("born_at");
		birthplace_desc=rs.getString("birth_place_desc")==null?" ":rs.getString("birth_place_desc");
		bornwhere=rs.getString("born_where")==null?" ":rs.getString("born_where");
		birthcertificateno=rs.getString("BIRTH_CERTIFICATE_NO")==null?" ":rs.getString("BIRTH_CERTIFICATE_NO");
		nbbirthdate=rs.getString("nb_birth_date")==null?" ":rs.getString("nb_birth_date");
		headcircumference=rs.getString("head_circumference")==null?" ":rs.getString("head_circumference");
		chestcircumference=rs.getString("chest_circumference")==null?" ":rs.getString("chest_circumference");
		apgarscorein1mins=rs.getString("apgar_score_in_1_min")==null?" ":rs.getString("apgar_score_in_1_min");
		apgarscorein5mins=rs.getString("apgar_score_in_5_mins")==null?" ":rs.getString("apgar_score_in_5_mins");
		apgarscorein10mins=rs.getString("apgar_score_in_10_mins")==null?" ":rs.getString("apgar_score_in_10_mins");
		umbilicalcordstatus=rs.getString("umbilical_cord_status")==null?" ":rs.getString("umbilical_cord_status");
		umbcordcutby=rs.getString("UMB_CORD_CUT_BY")==null?" ":rs.getString("UMB_CORD_CUT_BY");
		conganomdesc=rs.getString("CONG_ANOM_DESC")==null?" ":rs.getString("CONG_ANOM_DESC");
		feeding = rs.getString("feeding_desc")==null?" ":rs.getString("feeding_desc");
		patencyofanusyn=rs.getString("patency_of_anus_yn")==null?" ":rs.getString("patency_of_anus_yn");
		stools1 = rs.getString("stools")==null?" ":rs.getString("stools");
		bcg_admin_dtls=rs.getString("bcg_admin_dtls")==null?"":rs.getString("bcg_admin_dtls");
		vitak_admin_dtls=rs.getString("Vitak_admin_dtls")==null?"":rs.getString("Vitak_admin_dtls");
		hepB_admin_dtls=rs.getString("HepB_admin_dtls")==null?"":rs.getString("HepB_admin_dtls");

		nb_born_id = rs.getString("patient_id")==null?"":rs.getString("patient_id");
		nb_born_name = rs.getString("NB_PATIENT_NAME")==null?"":rs.getString("NB_PATIENT_NAME");
		multiple_birth_yn = rs.getString("MULTIPLE_BIRTH_YN")==null?"":rs.getString("MULTIPLE_BIRTH_YN");
		compln_pregnancy_desc = rs.getString("COMPLN_PREGNANCY_DESC")==null?"":rs.getString("COMPLN_PREGNANCY_DESC");
		blood_grp = rs.getString("BLOOD_GRP")==null?"":rs.getString("BLOOD_GRP");
		attend_physician_id = rs.getString("ATTEND_PHYSICIAN_ID")==null?"":rs.getString("ATTEND_PHYSICIAN_ID");
		attend_midwife_id = rs.getString("ATTEND_MIDWIFE_ID")==null?"":rs.getString("ATTEND_MIDWIFE_ID");
		complns_1st_desc = rs.getString("complns_1st_desc")==null?"":rs.getString("complns_1st_desc");
		complns_2nd_desc = rs.getString("complns_2nd_desc")==null?"":rs.getString("complns_2nd_desc");
		complns_3rd_desc = rs.getString("complns_3rd_desc")==null?"":rs.getString("complns_3rd_desc");

		if(feeding.equals("T"))
			feedingdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Breast.label","mp_labels");
		else if(feeding.equals("B"))
			feedingdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Bottle.label","mp_labels");
		else 
			feedingdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");	 

		if(stools1.equals("M"))
			stools = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Meconium.label","mp_labels");
		else if(stools1.equals("Y"))
			stools = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.YellowSoft.label","mp_labels");
		else 
			stools = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");	 
		
		father_patient_name = rs.getString("FATHER_PATIENT_NAME") == null ? "" : rs.getString("FATHER_PATIENT_NAME");
		father_nat_desc = rs.getString("FATHER_NAT_DESC") == null ? "" : rs.getString("FATHER_NAT_DESC");
		race_desc = rs.getString("RACE_DESC") == null ? "" : rs.getString("RACE_DESC");
		father_gove_employee_yn = rs.getString("FATHER_GOVE_EMPLOYEE_YN") == null ? "" : rs.getString("FATHER_GOVE_EMPLOYEE_YN");
		ocpn_class_desc = rs.getString("OCPN_CLASS_DESC") == null ? "" : rs.getString("OCPN_CLASS_DESC");
		ocpn_desc = rs.getString("OCPN_DESC") == null ? "" : rs.getString("OCPN_DESC");
		relgn_desc = rs.getString("RELGN_DESC") == null ? "" : rs.getString("RELGN_DESC");
		father_remarks = rs.getString("FATHER_REMARKS") == null ? "" : rs.getString("FATHER_REMARKS");*/
		 
	if(fields.size()>0)
	{
		for(int l=0;l<fields.size();++l)
		{
			col_field = (String)fields.get(l);
			if(col_field.equals("MOTHERDETAIL"))
			{
				monthersql.append(strsql1.toString());
				st = 0;
				stmt = con.prepareStatement(monthersql.toString());
				stmt.setString(++st,locale);
				stmt.setString(++st,locale);
				stmt.setString(++st,locale);
				stmt.setString(++st,locale);
				stmt.setString(++st,locale);
				stmt.setString(++st,locale);
				stmt.setString(++st,locale);
				stmt.setString(++st,locale);
				stmt.setString(++st,patient_id);
				stmt.setString(++st,mother_encounter_id);
				stmt.setString(++st,facility_id);
					
				rs = stmt.executeQuery();
				if(rs.next())
				{
					gestational_period=rs.getString("gestational_period") == null ? " " : rs.getString("gestational_period");
					gestational_period_in_days=rs.getString("GESTATIONAL_PERIOD_IN_DAYS") == null ? "" : rs.getString("GESTATIONAL_PERIOD_IN_DAYS");
					delivery_type=rs.getString("delivery_type") == null ? " " : rs.getString("delivery_type");
					noofbirths=rs.getString("noofBirths") == null ? " " : rs.getString("noofBirths");
					procclassific=rs.getString("procclassific")==null?" ":rs.getString("procclassific");
					vaginaldelytypedesc=rs.getString("vaginal_dely_type_desc")==null?" ":rs.getString("vaginal_dely_type_desc");
					surgicalclassify=rs.getString("surgicalclassify")==null?" ":rs.getString("surgicalclassify");
					gravida=rs.getString("gravida")==null?" ":rs.getString("gravida");
					complications=rs.getString("complications")==null?" ":rs.getString("complications");
					delyinddesc=rs.getString("DELY_IND_DESC")==null?" ":rs.getString("DELY_IND_DESC");
					parity=rs.getString("parity")==null?" ":rs.getString("parity");
					multiple_birth_yn = rs.getString("MULTIPLE_BIRTH_YN")==null?"":rs.getString("MULTIPLE_BIRTH_YN");
					compln_pregnancy_desc = rs.getString("COMPLN_PREGNANCY_DESC")==null?"":rs.getString("COMPLN_PREGNANCY_DESC");
					compln_nr_pregnancy_desc = rs.getString("COMPLN_NR_PREGNANCY_DESC")==null?"":rs.getString("COMPLN_NR_PREGNANCY_DESC");
					attend_physician_id = rs.getString("ATTEND_PHYSICIAN_ID")==null?"":rs.getString("ATTEND_PHYSICIAN_ID");
					attend_midwife_id = rs.getString("ATTEND_MIDWIFE_ID")==null?"":rs.getString("ATTEND_MIDWIFE_ID");
					complns_1st_desc = rs.getString("complns_1st_desc")==null?"":rs.getString("complns_1st_desc");
					complns_2nd_desc = rs.getString("complns_2nd_desc")==null?"":rs.getString("complns_2nd_desc");
					complns_3rd_desc = rs.getString("complns_3rd_desc")==null?"":rs.getString("complns_3rd_desc");

					if(!gestational_period_in_days.equals(""))
						gestational_period_in_days = gestational_period_in_days + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
					
					if(!gestational_period.equals(""))
						gestational_period_in_days = " " + gestational_period_in_days;
	%>
					<tr><td class="CAHIGHERLEVELCOLOR" width='30%' colspan=2><input type='checkbox' name='motherChkBox' id='motherChkBox' onClick="javascript:perform(this);" >&nbsp; <fmt:message key="eMP.motherdetails.label" bundle="${mp_labels}"/></td></tr>
         
					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=gravida%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.Gravida.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=gravida%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Gravida.label","mp_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=parity%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.Parity.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=parity%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Parity.label","mp_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=gestational_period%><%=gestational_period.equals("1")?UNIT_OF_GEST_NB_s:(!gestational_period.equals(" "))?UNIT_OF_GEST_NB_m:""%><%=gestational_period_in_days%>" onclick="Add(this);remove(this)"><fmt:message key="eCA.GestationalPeriod.label" bundle="${ca_labels}"/></td><td class="<%=classValue%>"><B><%=gestational_period%><%=gestational_period.equals("1")?UNIT_OF_GEST_NB_s:(!gestational_period.equals(" "))?UNIT_OF_GEST_NB_m:""%><%=gestational_period_in_days%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.GestationalPeriod.label","ca_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=complications%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.CompofDelivery.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=complications%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.CompofDelivery.label","mp_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=delivery_type%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.DeliveryType.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=delivery_type%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.DeliveryType.label","mp_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=vaginaldelytypedesc%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.VaginalDeliveryType.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=vaginaldelytypedesc%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.VaginalDeliveryType.label","mp_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=procclassific%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.ProcedureClassification.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=procclassific%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ProcedureClassification.label","mp_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=surgicalclassify%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.DeliverySurgicalClassification.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=surgicalclassify%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.DeliverySurgicalClassification.label","mp_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=multiple_birth_yn%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.MultipleBirth.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=multiple_birth_yn%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.MultipleBirth.label","mp_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=noofbirths%>" onclick="Add(this);remove(this)"><fmt:message key="Common.NoofBirths.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=noofbirths%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NoofBirths.label","common_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=attend_physician_id%>" onclick="Add(this);remove(this)"><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=attend_physician_id%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AttendingPractitioner.label","common_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=attend_midwife_id%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.AttendingNurse.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=attend_midwife_id%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AttendingNurse.label","mp_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=compln_pregnancy_desc%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.ComplicationsofPregnancy.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=compln_pregnancy_desc%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ComplicationsofPregnancy.label","mp_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=compln_nr_pregnancy_desc%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.ComplicationsnotrelatedtoPregnancy.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=compln_nr_pregnancy_desc%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ComplicationsnotrelatedtoPregnancy.label","mp_labels")%>'></td></tr>
		 
					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=complns_1st_desc%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.Complicationsin1stStage.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=complns_1st_desc%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Complicationsin1stStage.label","mp_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=complns_2nd_desc%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.Complicationsin2ndStage.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=complns_2nd_desc%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Complicationsin2ndStage.label","mp_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=complns_3rd_desc%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.Complicationsin3rdStage.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=complns_3rd_desc%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Complicationsin3rdStage.label","mp_labels")%>'></td></tr>
	<%
				}
				if(rs != null ) rs.close();
				if(stmt != null ) stmt.close();
			}
			else if(col_field.equals("FATHERDETAIL"))
			{
				fathersql.append(strsql1.toString());
				st = 0;
				stmt = con.prepareStatement(fathersql.toString());
				stmt.setString(++st,patient_id);
				stmt.setString(++st,mother_encounter_id);
				stmt.setString(++st,facility_id);
				
				rs = stmt.executeQuery();
				if(rs.next())
				{
					father_patient_name = rs.getString("FATHER_PATIENT_NAME") == null ? "" : rs.getString("FATHER_PATIENT_NAME");
					father_nat_desc = rs.getString("FATHER_NAT_DESC") == null ? "" : rs.getString("FATHER_NAT_DESC");
					race_desc = rs.getString("RACE_DESC") == null ? "" : rs.getString("RACE_DESC");
					father_gove_employee_yn = rs.getString("FATHER_GOVE_EMPLOYEE_YN") == null ? "" : rs.getString("FATHER_GOVE_EMPLOYEE_YN");
					ocpn_class_desc = rs.getString("OCPN_CLASS_DESC") == null ? "" : rs.getString("OCPN_CLASS_DESC");
					ocpn_desc = rs.getString("OCPN_DESC") == null ? "" : rs.getString("OCPN_DESC");
					relgn_desc = rs.getString("RELGN_DESC") == null ? "" : rs.getString("RELGN_DESC");
					father_remarks = rs.getString("FATHER_REMARKS") == null ? "" : rs.getString("FATHER_REMARKS");
	%>
					<tr><td class="CAHIGHERLEVELCOLOR"  colspan=2><input type='checkbox' name='fatherChkBox' id='fatherChkBox' onClick="javascript:perform(this);" >&nbsp; <fmt:message key="eMP.fatherdetails.label" bundle="${mp_labels}"/></td></tr>
         
					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="F<%=f++%>" id="F<%=f++%>" value="<%=father_patient_name%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.fathername.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=father_patient_name%></B><input type=hidden name='LF<%=lf++%>' id='LF<%=lf++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.fathername.label","mp_labels")%>'></td></tr>
			 
					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="F<%=f++%>" id="F<%=f++%>" value="<%=father_nat_desc%>" onclick="Add(this);remove(this)"><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=father_nat_desc%></B><input type=hidden name='LF<%=lf++%>' id='LF<%=lf++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nationality.label","common_labels")%>'></td></tr>
		 
					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="F<%=f++%>" id="F<%=f++%>" value="<%=race_desc%>" onclick="Add(this);remove(this)"><fmt:message key="Common.race.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=race_desc%></B><input type=hidden name='LF<%=lf++%>' id='LF<%=lf++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.race.label","common_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="F<%=f++%>" id="F<%=f++%>" value="<%=father_gove_employee_yn%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.GovtEmployee.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=father_gove_employee_yn%></B><input type=hidden name='LF<%=lf++%>' id='LF<%=lf++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.GovtEmployee.label","mp_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="F<%=f++%>" id="F<%=f++%>" value="<%=ocpn_class_desc%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.OccupationClass.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=ocpn_class_desc%></B><input type=hidden name='LF<%=lf++%>' id='LF<%=lf++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OccupationClass.label","mp_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="F<%=f++%>" id="F<%=f++%>" value="<%=ocpn_desc%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=ocpn_desc%></B><input type=hidden name='LF<%=lf++%>' id='LF<%=lf++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.occupation.label","mp_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="F<%=f++%>" id="F<%=f++%>" value="<%=relgn_desc%>" onclick="Add(this);remove(this)"><fmt:message key="Common.religion.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=relgn_desc%></B><input type=hidden name='LF<%=lf++%>' id='LF<%=lf++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.religion.label","common_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="F<%=f++%>" id="F<%=f++%>" value="<%=father_remarks%>" onclick="Add(this);remove(this)"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=father_remarks%></B><input type=hidden name='LF<%=lf++%>' id='LF<%=lf++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")%>'></td></tr>
	<%
				}
				if(rs != null ) rs.close();
				if(stmt != null ) stmt.close();
			}
			else if(col_field.equals("BABYDETAIL"))
			{
				babysql.append(strsql1.toString()+" and b.patient_id = a.patient_id order by DELIVERY_DATE");
				
				st = 0;
				stmt = con.prepareStatement(babysql.toString());
				stmt.setString(++st,locale);
				stmt.setString(++st,locale);
				stmt.setString(++st,locale);
				stmt.setString(++st,patient_id);
				stmt.setString(++st,mother_encounter_id);
				stmt.setString(++st,facility_id);
				
				
				rs = stmt.executeQuery();
				while(rs.next())
				{					
					nb_sex=rs.getString("nb_sex")==null?" ":rs.getString("nb_sex");
					relationship=rs.getString("relationship")==null?" ":rs.getString("relationship");
					outcome=rs.getString("outcome")==null?" ":rs.getString("outcome");
					indicator_mark=rs.getString("indicator_mark")==null?" ":rs.getString("indicator_mark");
					lengthof=rs.getString("length")==null?" ":rs.getString("length");
					weight=rs.getString("weight")==null?" ":rs.getString("weight");
					bornat=rs.getString("born_at")==null?" ":rs.getString("born_at");
					birthplace_desc=rs.getString("birth_place_desc")==null?" ":rs.getString("birth_place_desc");
					bornwhere=rs.getString("born_where")==null?" ":rs.getString("born_where");
					birthcertificateno=rs.getString("BIRTH_CERTIFICATE_NO")==null?" ":rs.getString("BIRTH_CERTIFICATE_NO");
					nbbirthdate=rs.getString("nb_birth_date")==null?" ":rs.getString("nb_birth_date");
					
					headcircumference=rs.getString("head_circumference")==null?" ":rs.getString("head_circumference");
					chestcircumference=rs.getString("chest_circumference")==null?" ":rs.getString("chest_circumference");
					apgarscorein1mins=rs.getString("apgar_score_in_1_min")==null?" ":rs.getString("apgar_score_in_1_min");
					apgarscorein5mins=rs.getString("apgar_score_in_5_mins")==null?" ":rs.getString("apgar_score_in_5_mins");
					apgarscorein10mins=rs.getString("apgar_score_in_10_mins")==null?" ":rs.getString("apgar_score_in_10_mins");
					umbilicalcordstatus=rs.getString("umbilical_cord_status")==null?" ":rs.getString("umbilical_cord_status");
					umbcordcutby=rs.getString("UMB_CORD_CUT_BY")==null?" ":rs.getString("UMB_CORD_CUT_BY");
					conganomdesc=rs.getString("CONG_ANOM_DESC")==null?" ":rs.getString("CONG_ANOM_DESC");
					feeding = rs.getString("feeding_desc")==null?"":rs.getString("feeding_desc");
					patencyofanusyn=rs.getString("patency_of_anus_yn")==null?" ":rs.getString("patency_of_anus_yn");
					stools1 = rs.getString("stools")==null?"":rs.getString("stools");
					bcg_admin_dtls=rs.getString("bcg_admin_dtls")==null?"":rs.getString("bcg_admin_dtls");
					vitak_admin_dtls=rs.getString("Vitak_admin_dtls")==null?"":rs.getString("Vitak_admin_dtls");
					hepB_admin_dtls=rs.getString("HepB_admin_dtls")==null?"":rs.getString("HepB_admin_dtls");

					nb_born_id = rs.getString("patient_id")==null?"":rs.getString("patient_id");
					nb_born_name = rs.getString("NB_PATIENT_NAME")==null?"":rs.getString("NB_PATIENT_NAME");
					blood_grp = rs.getString("BLOOD_GRP")==null?"":rs.getString("BLOOD_GRP");

					if(!feeding.equals(""))
					{
						if(feeding.equals("T"))
							feedingdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Breast.label","mp_labels");
						else if(feeding.equals("B"))
							feedingdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Bottle.label","mp_labels");
						else 
							feedingdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");	
					}
					else
						feedingdesc = "";

					if(!stools1.equals(""))
					{
						if(stools1.equals("M"))
							stools = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Meconium.label","mp_labels");
						else if(stools1.equals("Y"))
							stools = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.YellowSoft.label","mp_labels");
						else 
							stools = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
					}
					else
						stools = "";
					
					j++;
					if (maxRecord>1)
					{
						bd=0; lbd=0;
						bc=0; lbc=0;
						v=0; lv=0;
						ba=0; lba=0;
	%>
						<tr><td class="CAHIGHERLEVELCOLOR" colspan=2><input type="hidden" name="B<%=j%>" id="B<%=j%>" value=""><input type='checkbox' name='babyChkBox<%=j%>' id='babyChkBox<%=j%>' onClick="javascript:perform(this,'<%=j%>');" >&nbsp;<fmt:message key="eMP.Baby.label" bundle="${mp_labels}"/><%=j%>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/> (<%=nb_born_name.replace(" ","&nbsp;")%> / <%=nb_born_id%>)</td><input type=hidden name='LB<%=j%>' id='LB<%=j%>'  value='<%=nb_born_name.replace("'","~")%> / <%=nb_born_id%>'></td></tr>
	<%
					} 
					else 
					{
	%>
						<tr><td class="CAHIGHERLEVELCOLOR" colspan=2><input type="hidden" name="B<%=j%>" id="B<%=j%>" value=""><input type='checkbox' name='babyChkBox<%=j%>' id='babyChkBox<%=j%>' onClick="javascript:perform(this,'<%=j%>');" >&nbsp;<fmt:message key="eIP.BabyDetails.label" bundle="${ip_labels}"/> (<%=nb_born_name.replace(" ","&nbsp;")%> / <%=nb_born_id%>)</td><input type=hidden name='LB<%=j%>' id='LB<%=j%>'  value='<%=nb_born_name.replace("'","~")%> / <%=nb_born_id%>'></td></tr>
	<%
					}
	%>	 
					<tr><td class="<%=classValue%>" nowrap colspan='2'><input type="checkbox" name="demoChkBox<%=j%>" id="demoChkBox<%=j%>"  onclick="javascript:perform(this,'<%=j%>');"><b><fmt:message key="eMP.demographicdetails.label" bundle="${mp_labels}"/></b></td></tr>

					<tr><td colspan='2'><table class='grid' align='center' width='100%'>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="D<%=j%><%=bd++%>" id="D<%=j%><%=bd++%>" value="<%=nb_sex%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=nb_sex%></B><input type=hidden name='LD<%=j%><%=lbd++%>' id='LD<%=j%><%=lbd++%>'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")%>'></td></tr>
		 
					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="D<%=j%><%=bd++%>" id="D<%=j%><%=bd++%>" value="<%=relationship%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=relationship%></B><input type=hidden name='LD<%=j%><%=lbd++%>' id='LD<%=j%><%=lbd++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.relationship.label","common_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="D<%=j%><%=bd++%>" id="D<%=j%><%=bd++%>" value="<%=nbbirthdate%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eCA.BirthDateTime.label" bundle="${ca_labels}"/></td><td class="<%=classValue%>"><B><%=nbbirthdate%></B><input type=hidden name='LD<%=j%><%=lbd++%>' id='LD<%=j%><%=lbd++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.BirthDateTime.label","ca_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="D<%=j%><%=bd++%>" id="D<%=j%><%=bd++%>" value="<%=bornwhere%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.BornWhere.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=bornwhere%></B><input type=hidden name='LD<%=j%><%=lbd++%>' id='LD<%=j%><%=lbd++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.BornWhere.label","mp_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="D<%=j%><%=bd++%>" id="D<%=j%><%=bd++%>" value="<%=birthcertificateno%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.BirthCertificateNo.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=birthcertificateno%></B><input type=hidden name='LD<%=j%><%=lbd++%>' id='LD<%=j%><%=lbd++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.BirthCertificateNo.label","mp_labels")%>'></td></tr>
		 
					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="D<%=j%><%=bd++%>" id="D<%=j%><%=bd++%>" value="<%=birthplace_desc%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="Common.birthPlace.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=birthplace_desc%></B><input type=hidden name='LD<%=j%><%=lbd++%>' id='LD<%=j%><%=lbd++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.birthPlace.label","common_labels")%>'></td></tr>
					
					<input type="hidden" name="bdcount<%=j%>" id="bdcount<%=j%>" value="<%=bd%>">
					</table></td></tr>

					<tr><td class="<%=classValue%>" nowrap colspan='2'><input type="checkbox" name="clinicalChkBox<%=j%>" id="clinicalChkBox<%=j%>"  onclick="javascript:perform(this,'<%=j%>');"><b><fmt:message key="eMP.clinicaldetails.label" bundle="${mp_labels}"/></b></td></tr>

					<tr><td colspan='2'><table class='grid' align='center' width='100%'>
		 
					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=indicator_mark%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.IndicatorMark.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=indicator_mark%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.IndicatorMark.label","mp_labels")%>'></td></tr>
		 
					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=outcome%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="Common.outcome.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=outcome%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.outcome.label","common_labels")%>'></td></tr>
         
					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=lengthof%><%=lengthof.equals("1")?UNIT_OF_LENGTH_NB_s:(!lengthof.equals(" "))?UNIT_OF_LENGTH_NB_m:""%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.LengthofBaby.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=lengthof%><%=lengthof.equals("1")?UNIT_OF_LENGTH_NB_s:(!lengthof.equals(" "))?UNIT_OF_LENGTH_NB_m:""%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.LengthofBaby.label","mp_labels")%>'></td></tr>
		 
					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=weight%><%=weight.equals("1")?UNIT_OF_WT_NB_s:(!weight.equals(" "))?UNIT_OF_WT_NB_m:""%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.BirthWeight.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=weight%><%=weight.equals("1")?UNIT_OF_WT_NB_s:(!weight.equals(" "))?UNIT_OF_WT_NB_m:""%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.BirthWeight.label","mp_labels")%>'></td></tr>
		 
					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=headcircumference%><%=headcircumference.equals("1")?UNIT_OF_CIRCUM_NB_s:(!headcircumference.equals(" "))?UNIT_OF_CIRCUM_NB_m:""%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="Common.HeadCircumference.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=headcircumference%><%=headcircumference.equals("1")?UNIT_OF_CIRCUM_NB_s:(!headcircumference.equals(" "))?UNIT_OF_CIRCUM_NB_m:""%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.HeadCircumference.label","common_labels")%>'></td></tr>
		 
					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=chestcircumference%><%=chestcircumference.equals("1")?UNIT_OF_CHEST_CIRCUM_NB_s:(!chestcircumference.equals(" "))?UNIT_OF_CHEST_CIRCUM_NB_m:""%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.ChestCircum.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=chestcircumference%><%=chestcircumference.equals("1")?UNIT_OF_CHEST_CIRCUM_NB_s:(!chestcircumference.equals(" "))?UNIT_OF_CHEST_CIRCUM_NB_m:""%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ChestCircum.label","mp_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=umbilicalcordstatus%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.UmbilicalCord.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.status.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=umbilicalcordstatus%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.UmbilicalCord.label","mp_labels")%> <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=umbcordcutby%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.UmbCordCutBy.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=umbcordcutby%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.UmbCordCutBy.label","mp_labels")%>'></td></tr> 
		 
					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=feedingdesc%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.Feeding.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=feedingdesc%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Feeding.label","mp_labels")%>'></td></tr>
		 
					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=patencyofanusyn%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.PatencyofAnus.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=patencyofanusyn%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatencyofAnus.label","mp_labels")%>'></td></tr>
         
					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=conganomdesc%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.CongenitalAnomalies.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=conganomdesc%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.CongenitalAnomalies.label","mp_labels")%>'></td></tr>
		 
					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=stools%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.Stools.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=stools%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Stools.label","mp_labels")%>'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=blood_grp%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="Common.bloodgroup.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=blood_grp%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bloodgroup.label","common_labels")%>'></td></tr>

					<input type="hidden" name="bccount<%=j%>" id="bccount<%=j%>" value="<%=bc%>">
					</table></td></tr>

					<tr><td class="<%=classValue%>" nowrap colspan='2'><input type="checkbox" name="vaccineChkBox<%=j%>" id="vaccineChkBox<%=j%>" onclick="javascript:perform(this,'<%=j%>');"><b><fmt:message key="eMP.vaccinationdetails.label" bundle="${mp_labels}"/></b></td></tr>
					<tr><td colspan='2'><table class='grid' align='center' width='100%'>
		<%
					//if (!bcg_admin_dtls.equals(""))
					//{
		%>
					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="V<%=j%><%=v++%>" id="V<%=j%><%=v++%>"  value="<%=bcg_admin_dtls%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.BCG.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=bcg_admin_dtls%></B><input type=hidden name='LV<%=j%><%=lv++%>' id='LV<%=j%><%=lv++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.BCG.label","mp_labels")%>'></td></tr>
		<%
					//}
					//if (!vitak_admin_dtls.equals(""))
					//{
		%>
					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="V<%=j%><%=v++%>" id="V<%=j%><%=v++%>"  value="<%=vitak_admin_dtls%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.VitaminK.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=vitak_admin_dtls%></B><input type=hidden name='LV<%=j%><%=lv++%>' id='LV<%=j%><%=lv++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.VitaminK.label","mp_labels")%>'></td></tr>
		 <%
				//	}
					//if (!hepB_admin_dtls.equals(""))
				//	{
		%>
					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="V<%=j%><%=v++%>" id="V<%=j%><%=v++%>"  value="<%=hepB_admin_dtls%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')" ><fmt:message key="eMP.HepatitisB.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=hepB_admin_dtls%></B><input type=hidden name='LV<%=j%><%=lv++%>' id='LV<%=j%><%=lv++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.HepatitisB.label","mp_labels")%>'></td></tr>
		<%
					//}
		%>
					<input type="hidden" name="vcount<%=j%>" id="vcount<%=j%>" value="<%=v%>">
					</table></td></tr>
					
					<!-- <tr><td class="<%=classValue%>" >Vaccine</td><td class="<%=classValue%>" >Administered Date</td><td class="<%=classValue%>" >Administered By</td><td class="<%=classValue%>" >Designation</td><td class="<%=classValue%>" >Site</td></tr>

					<tr><td class="<%=classValue%>" nowrap><input type="checkbox" name="V<%=j%><%=v++%>" id="V<%=j%><%=v++%>"  value="<%=bcg_admin_dtls%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.BCG.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>">&nbsp;<B><%=bcg_admin_dtls%></B><input type=hidden name='LV<%=j%><%=lv++%>' id='LV<%=j%><%=lv++%>' value='Vaccin BCG'><input type=hidden name='LBI<%=m++%>' id='LBI<%=m++%>'  value='<%=i%>'></td><td class="<%=classValue%>" >&nbsp;</td><td class="<%=classValue%>" >&nbsp;</td><td class="<%=classValue%>" >&nbsp;</td></tr>

					<tr><td class="<%=classValue%>" nowrap><input type="checkbox" name="V<%=j%><%=v++%>" id="V<%=j%><%=v++%>"  value="<%=vitak_admin_dtls%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')">Vitamin</td><td class="<%=classValue%>">&nbsp;<B><%=vitak_admin_dtls%></B><input type=hidden name='LV<%=j%><%=lv++%>' id='LV<%=j%><%=lv++%>' value='Vaccin Vitamin'><input type=hidden name='LBI<%=m++%>' id='LBI<%=m++%>'  value='<%=i%>'></td><td class="<%=classValue%>" >&nbsp;</td><td class="<%=classValue%>" >&nbsp;</td><td class="<%=classValue%>" >&nbsp;</td></tr>

					<tr><td class="<%=classValue%>" nowrap><input type="checkbox" name="V<%=j%><%=v++%>" id="V<%=j%><%=v++%>"  value="<%=hepB_admin_dtls%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')" >Hepatitis</td><td class="<%=classValue%>">&nbsp;<B><%=hepB_admin_dtls%></B><input type=hidden name='LV<%=j%><%=lv++%>' id='LV<%=j%><%=lv++%>' value='Vaccin Hepatitis'><input type=hidden name='LBI<%=m++%>' id='LBI<%=m++%>'  value='<%=i%>'></td><td class="<%=classValue%>" >&nbsp;</td><td class="<%=classValue%>" >&nbsp;</td><td class="<%=classValue%>" >&nbsp;</td></tr> -->

					<tr><td class="<%=classValue%>" nowrap colspan='2'><input type="checkbox" name="apgarChkBox<%=j%>" id="apgarChkBox<%=j%>"  onclick="javascript:perform(this,'<%=j%>');"><b><fmt:message key="Common.ApgarScore.label" bundle="${common_labels}"/></b></td></tr>

					<tr><td colspan='2'><table class='grid' align='center' width='100%'>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="A<%=j%><%=ba++%>" id="A<%=j%><%=ba++%>" value="<%=apgarscorein1mins%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')">Apgarscore in 1 mins</td><td class="<%=classValue%>"><B><%=apgarscorein1mins%></B><input type=hidden name='LA<%=j%><%=lba++%>' id='LA<%=j%><%=lba++%>' value='Apgarscore in 1 mins'></td></tr>

					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="A<%=j%><%=ba++%>" id="A<%=j%><%=ba++%>" value="<%=apgarscorein5mins%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')">Apgarscore in 5 mins</td><td class="<%=classValue%>"><B><%=apgarscorein5mins%></B><input type=hidden name='LA<%=j%><%=lba++%>' id='LA<%=j%><%=lba++%>' value='Apgarscore in 5 mins'></td></tr>
		 
					<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="A<%=j%><%=ba++%>" id="A<%=j%><%=ba++%>" value="<%=apgarscorein10mins%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')">Apgarscore in 10 mins</td><td class="<%=classValue%>"><B><%=apgarscorein10mins%></B><input type=hidden name='LA<%=j%><%=lba++%>' id='LA<%=j%><%=lba++%>' value='Apgarscore in 10 mins'></td></tr>
		 
					<input type="hidden" name="bacount<%=j%>" id="bacount<%=j%>" value="<%=ba%>">
					</table></td></tr>
	<%
				}
				if(rs != null ) rs.close();
				if(stmt != null ) stmt.close();
			}
		}
	}
	else
	{
		monthersql.append(strsql1.toString());
		st = 0;
		stmt = con.prepareStatement(monthersql.toString());
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,patient_id);
		stmt.setString(++st,mother_encounter_id);
		stmt.setString(++st,facility_id);
			
		rs = stmt.executeQuery();
		if(rs.next())
		{
			gestational_period=rs.getString("gestational_period") == null ? " " : rs.getString("gestational_period");
			gestational_period_in_days=rs.getString("GESTATIONAL_PERIOD_IN_DAYS") == null ? "" : rs.getString("GESTATIONAL_PERIOD_IN_DAYS");
			delivery_type=rs.getString("delivery_type") == null ? " " : rs.getString("delivery_type");
			noofbirths=rs.getString("noofBirths") == null ? " " : rs.getString("noofBirths");
			procclassific=rs.getString("procclassific")==null?" ":rs.getString("procclassific");
			vaginaldelytypedesc=rs.getString("vaginal_dely_type_desc")==null?" ":rs.getString("vaginal_dely_type_desc");
			surgicalclassify=rs.getString("surgicalclassify")==null?" ":rs.getString("surgicalclassify");
			gravida=rs.getString("gravida")==null?" ":rs.getString("gravida");
			complications=rs.getString("complications")==null?" ":rs.getString("complications");
			delyinddesc=rs.getString("DELY_IND_DESC")==null?" ":rs.getString("DELY_IND_DESC");
			parity=rs.getString("parity")==null?" ":rs.getString("parity");
			multiple_birth_yn = rs.getString("MULTIPLE_BIRTH_YN")==null?"":rs.getString("MULTIPLE_BIRTH_YN");
			compln_pregnancy_desc = rs.getString("COMPLN_PREGNANCY_DESC")==null?"":rs.getString("COMPLN_PREGNANCY_DESC");
			compln_nr_pregnancy_desc = rs.getString("COMPLN_NR_PREGNANCY_DESC")==null?"":rs.getString("COMPLN_NR_PREGNANCY_DESC");
			attend_physician_id = rs.getString("ATTEND_PHYSICIAN_ID")==null?"":rs.getString("ATTEND_PHYSICIAN_ID");
			attend_midwife_id = rs.getString("ATTEND_MIDWIFE_ID")==null?"":rs.getString("ATTEND_MIDWIFE_ID");
			complns_1st_desc = rs.getString("complns_1st_desc")==null?"":rs.getString("complns_1st_desc");
			complns_2nd_desc = rs.getString("complns_2nd_desc")==null?"":rs.getString("complns_2nd_desc");
			complns_3rd_desc = rs.getString("complns_3rd_desc")==null?"":rs.getString("complns_3rd_desc");

			if(!gestational_period_in_days.equals(""))
				gestational_period_in_days = gestational_period_in_days + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");

			if(!gestational_period.equals(""))
				gestational_period_in_days = " " + gestational_period_in_days;
	%>
			<tr><td class="CAHIGHERLEVELCOLOR" width='30%' colspan=2><input type='checkbox' name='motherChkBox' id='motherChkBox' onClick="javascript:perform(this);" >&nbsp; <fmt:message key="eMP.motherdetails.label" bundle="${mp_labels}"/></td></tr>
 
			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=gravida%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.Gravida.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=gravida%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Gravida.label","mp_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=parity%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.Parity.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=parity%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Parity.label","mp_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=gestational_period%><%=gestational_period.equals("1")?UNIT_OF_GEST_NB_s:(!gestational_period.equals(" "))?UNIT_OF_GEST_NB_m:""%><%=gestational_period_in_days%>" onclick="Add(this);remove(this)"><fmt:message key="eCA.GestationalPeriod.label" bundle="${ca_labels}"/></td><td class="<%=classValue%>"><B><%=gestational_period%><%=gestational_period.equals("1")?UNIT_OF_GEST_NB_s:(!gestational_period.equals(" "))?UNIT_OF_GEST_NB_m:""%><%=gestational_period_in_days%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.GestationalPeriod.label","ca_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=complications%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.CompofDelivery.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=complications%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.CompofDelivery.label","mp_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=delivery_type%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.DeliveryType.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=delivery_type%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.DeliveryType.label","mp_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=vaginaldelytypedesc%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.VaginalDeliveryType.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=vaginaldelytypedesc%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.VaginalDeliveryType.label","mp_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=procclassific%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.ProcedureClassification.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=procclassific%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ProcedureClassification.label","mp_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=surgicalclassify%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.DeliverySurgicalClassification.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=surgicalclassify%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.DeliverySurgicalClassification.label","mp_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=multiple_birth_yn%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.MultipleBirth.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=multiple_birth_yn%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.MultipleBirth.label","mp_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=noofbirths%>" onclick="Add(this);remove(this)"><fmt:message key="Common.NoofBirths.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=noofbirths%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NoofBirths.label","common_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=attend_physician_id%>" onclick="Add(this);remove(this)"><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=attend_physician_id%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AttendingPractitioner.label","common_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=attend_midwife_id%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.AttendingNurse.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=attend_midwife_id%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AttendingNurse.label","mp_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=compln_pregnancy_desc%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.ComplicationsofPregnancy.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=compln_pregnancy_desc%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ComplicationsofPregnancy.label","mp_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=compln_nr_pregnancy_desc%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.ComplicationsnotrelatedtoPregnancy.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=compln_nr_pregnancy_desc%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ComplicationsnotrelatedtoPregnancy.label","mp_labels")%>'></td></tr>
 
			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=complns_1st_desc%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.Complicationsin1stStage.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=complns_1st_desc%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Complicationsin1stStage.label","mp_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=complns_2nd_desc%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.Complicationsin2ndStage.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=complns_2nd_desc%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Complicationsin2ndStage.label","mp_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="M<%=k++%>" id="M<%=k++%>" value="<%=complns_3rd_desc%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.Complicationsin3rdStage.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=complns_3rd_desc%></B><input type=hidden name='LM<%=lm++%>' id='LM<%=lm++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Complicationsin3rdStage.label","mp_labels")%>'></td></tr>
	<%
		}
		if(rs != null ) rs.close();
		if(stmt != null ) stmt.close();

		fathersql.append(strsql1.toString());
		st = 0;
		stmt = con.prepareStatement(fathersql.toString());
		stmt.setString(++st,patient_id);
		stmt.setString(++st,mother_encounter_id);
		stmt.setString(++st,facility_id);
		
		rs = stmt.executeQuery();
		if(rs.next())
		{
			father_patient_name = rs.getString("FATHER_PATIENT_NAME") == null ? "" : rs.getString("FATHER_PATIENT_NAME");
			father_nat_desc = rs.getString("FATHER_NAT_DESC") == null ? "" : rs.getString("FATHER_NAT_DESC");
			race_desc = rs.getString("RACE_DESC") == null ? "" : rs.getString("RACE_DESC");
			father_gove_employee_yn = rs.getString("FATHER_GOVE_EMPLOYEE_YN") == null ? "" : rs.getString("FATHER_GOVE_EMPLOYEE_YN");
			ocpn_class_desc = rs.getString("OCPN_CLASS_DESC") == null ? "" : rs.getString("OCPN_CLASS_DESC");
			ocpn_desc = rs.getString("OCPN_DESC") == null ? "" : rs.getString("OCPN_DESC");
			relgn_desc = rs.getString("RELGN_DESC") == null ? "" : rs.getString("RELGN_DESC");
			father_remarks = rs.getString("FATHER_REMARKS") == null ? "" : rs.getString("FATHER_REMARKS");
	%>
			<tr><td class="CAHIGHERLEVELCOLOR"  colspan=2><input type='checkbox' name='fatherChkBox' id='fatherChkBox' onClick="javascript:perform(this);" >&nbsp; <fmt:message key="eMP.fatherdetails.label" bundle="${mp_labels}"/></td></tr>
 
			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="F<%=f++%>" id="F<%=f++%>" value="<%=father_patient_name%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.fathername.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=father_patient_name%></B><input type=hidden name='LF<%=lf++%>' id='LF<%=lf++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.fathername.label","mp_labels")%>'></td></tr>
	 
			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="F<%=f++%>" id="F<%=f++%>" value="<%=father_nat_desc%>" onclick="Add(this);remove(this)"><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=father_nat_desc%></B><input type=hidden name='LF<%=lf++%>' id='LF<%=lf++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nationality.label","common_labels")%>'></td></tr>
 
			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="F<%=f++%>" id="F<%=f++%>" value="<%=race_desc%>" onclick="Add(this);remove(this)"><fmt:message key="Common.race.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=race_desc%></B><input type=hidden name='LF<%=lf++%>' id='LF<%=lf++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.race.label","common_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="F<%=f++%>" id="F<%=f++%>" value="<%=father_gove_employee_yn%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.GovtEmployee.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=father_gove_employee_yn%></B><input type=hidden name='LF<%=lf++%>' id='LF<%=lf++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.GovtEmployee.label","mp_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="F<%=f++%>" id="F<%=f++%>" value="<%=ocpn_class_desc%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.OccupationClass.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=ocpn_class_desc%></B><input type=hidden name='LF<%=lf++%>' id='LF<%=lf++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OccupationClass.label","mp_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="F<%=f++%>" id="F<%=f++%>" value="<%=ocpn_desc%>" onclick="Add(this);remove(this)"><fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=ocpn_desc%></B><input type=hidden name='LF<%=lf++%>' id='LF<%=lf++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.occupation.label","mp_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="F<%=f++%>" id="F<%=f++%>" value="<%=relgn_desc%>" onclick="Add(this);remove(this)"><fmt:message key="Common.religion.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=relgn_desc%></B><input type=hidden name='LF<%=lf++%>' id='LF<%=lf++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.religion.label","common_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="F<%=f++%>" id="F<%=f++%>" value="<%=father_remarks%>" onclick="Add(this);remove(this)"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=father_remarks%></B><input type=hidden name='LF<%=lf++%>' id='LF<%=lf++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")%>'></td></tr>
	<%
		}
		if(rs != null ) rs.close();
		if(stmt != null ) stmt.close();

		babysql.append(strsql1.toString()+" and b.patient_id = a.patient_id order by DELIVERY_DATE");
		
		st = 0;
		stmt = con.prepareStatement(babysql.toString());
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,patient_id);
		stmt.setString(++st,mother_encounter_id);
		stmt.setString(++st,facility_id);
		
		
		rs = stmt.executeQuery();
		while(rs.next())
		{
			nb_sex=rs.getString("nb_sex")==null?" ":rs.getString("nb_sex");
			relationship=rs.getString("relationship")==null?" ":rs.getString("relationship");
			outcome=rs.getString("outcome")==null?" ":rs.getString("outcome");
			indicator_mark=rs.getString("indicator_mark")==null?" ":rs.getString("indicator_mark");
			lengthof=rs.getString("length")==null?" ":rs.getString("length");
			weight=rs.getString("weight")==null?" ":rs.getString("weight");
			bornat=rs.getString("born_at")==null?" ":rs.getString("born_at");
			birthplace_desc=rs.getString("birth_place_desc")==null?" ":rs.getString("birth_place_desc");
			bornwhere=rs.getString("born_where")==null?" ":rs.getString("born_where");
			birthcertificateno=rs.getString("BIRTH_CERTIFICATE_NO")==null?" ":rs.getString("BIRTH_CERTIFICATE_NO");
			nbbirthdate=rs.getString("nb_birth_date")==null?" ":rs.getString("nb_birth_date");			
			headcircumference=rs.getString("head_circumference")==null?" ":rs.getString("head_circumference");
			chestcircumference=rs.getString("chest_circumference")==null?" ":rs.getString("chest_circumference");
			apgarscorein1mins=rs.getString("apgar_score_in_1_min")==null?" ":rs.getString("apgar_score_in_1_min");
			apgarscorein5mins=rs.getString("apgar_score_in_5_mins")==null?" ":rs.getString("apgar_score_in_5_mins");
			apgarscorein10mins=rs.getString("apgar_score_in_10_mins")==null?" ":rs.getString("apgar_score_in_10_mins");
			umbilicalcordstatus=rs.getString("umbilical_cord_status")==null?" ":rs.getString("umbilical_cord_status");
			umbcordcutby=rs.getString("UMB_CORD_CUT_BY")==null?" ":rs.getString("UMB_CORD_CUT_BY");
			conganomdesc=rs.getString("CONG_ANOM_DESC")==null?" ":rs.getString("CONG_ANOM_DESC");
			feeding = rs.getString("feeding_desc")==null?"":rs.getString("feeding_desc");
			patencyofanusyn=rs.getString("patency_of_anus_yn")==null?" ":rs.getString("patency_of_anus_yn");
			stools1 = rs.getString("stools")==null?"":rs.getString("stools");
			bcg_admin_dtls=rs.getString("bcg_admin_dtls")==null?"":rs.getString("bcg_admin_dtls");
			vitak_admin_dtls=rs.getString("Vitak_admin_dtls")==null?"":rs.getString("Vitak_admin_dtls");
			hepB_admin_dtls=rs.getString("HepB_admin_dtls")==null?"":rs.getString("HepB_admin_dtls");

			nb_born_id = rs.getString("patient_id")==null?"":rs.getString("patient_id");
			nb_born_name = rs.getString("NB_PATIENT_NAME")==null?"":rs.getString("NB_PATIENT_NAME");
			blood_grp = rs.getString("BLOOD_GRP")==null?"":rs.getString("BLOOD_GRP");

			if(!feeding.equals(""))
			{
				if(feeding.equals("T"))
					feedingdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Breast.label","mp_labels");
				else if(feeding.equals("B"))
					feedingdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Bottle.label","mp_labels");
				else 
					feedingdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}
			else
				feedingdesc = "";

			if(!stools1.equals(""))
			{
				if(stools1.equals("M"))
					stools = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Meconium.label","mp_labels");
				else if(stools1.equals("Y"))
					stools = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.YellowSoft.label","mp_labels");
				else 
					stools = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}
			else
				stools = "";

			j++;
			if (maxRecord>1)
			{
				bd=0; lbd=0;
				bc=0; lbc=0;
				v=0; lv=0;
				ba=0; lba=0;
	%>
				<tr><td class="CAHIGHERLEVELCOLOR" colspan=2><input type="hidden" name="B<%=j%>" id="B<%=j%>" value=""><input type='checkbox' name='babyChkBox<%=j%>' id='babyChkBox<%=j%>' onClick="javascript:perform(this,'<%=j%>');" >&nbsp;<fmt:message key="eMP.Baby.label" bundle="${mp_labels}"/><%=j%>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/> (<%=nb_born_name.replace(" ","&nbsp;")%> / <%=nb_born_id%>)</td><input type=hidden name='LB<%=j%>' id='LB<%=j%>'  value='<%=nb_born_name.replace("'","~")%> / <%=nb_born_id%>'></td></tr>
	<%
			} 
			else 
			{
	%>
				<tr><td class="CAHIGHERLEVELCOLOR" colspan=2><input type="hidden" name="B<%=j%>" id="B<%=j%>" value=""><input type='checkbox' name='babyChkBox<%=j%>' id='babyChkBox<%=j%>' onClick="javascript:perform(this,'<%=j%>');" >&nbsp;<fmt:message key="eIP.BabyDetails.label" bundle="${ip_labels}"/> (<%=nb_born_name.replace(" ","&nbsp;")%> / <%=nb_born_id%>)</td><input type=hidden name='LB<%=j%>' id='LB<%=j%>'  value='<%=nb_born_name.replace("'","~")%> / <%=nb_born_id%>'></td></tr>
	<%
			}
	%>	 
			<tr><td class="<%=classValue%>" nowrap colspan='2'><input type="checkbox" name="demoChkBox<%=j%>" id="demoChkBox<%=j%>"  onclick="javascript:perform(this,'<%=j%>');"><b><fmt:message key="eMP.demographicdetails.label" bundle="${mp_labels}"/></b></td></tr>

			<tr><td colspan='2'><table class='grid' align='center' width='100%'>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="D<%=j%><%=bd++%>" id="D<%=j%><%=bd++%>" value="<%=nb_sex%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=nb_sex%></B><input type=hidden name='LD<%=j%><%=lbd++%>' id='LD<%=j%><%=lbd++%>'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")%>'></td></tr>
 
			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="D<%=j%><%=bd++%>" id="D<%=j%><%=bd++%>" value="<%=relationship%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=relationship%></B><input type=hidden name='LD<%=j%><%=lbd++%>' id='LD<%=j%><%=lbd++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.relationship.label","common_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="D<%=j%><%=bd++%>" id="D<%=j%><%=bd++%>" value="<%=nbbirthdate%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eCA.BirthDateTime.label" bundle="${ca_labels}"/></td><td class="<%=classValue%>"><B><%=nbbirthdate%></B><input type=hidden name='LD<%=j%><%=lbd++%>' id='LD<%=j%><%=lbd++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.BirthDateTime.label","ca_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="D<%=j%><%=bd++%>" id="D<%=j%><%=bd++%>" value="<%=bornwhere%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.BornWhere.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=bornwhere%></B><input type=hidden name='LD<%=j%><%=lbd++%>' id='LD<%=j%><%=lbd++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.BornWhere.label","mp_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="D<%=j%><%=bd++%>" id="D<%=j%><%=bd++%>" value="<%=birthcertificateno%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.BirthCertificateNo.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=birthcertificateno%></B><input type=hidden name='LD<%=j%><%=lbd++%>' id='LD<%=j%><%=lbd++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.BirthCertificateNo.label","mp_labels")%>'></td></tr>
 
			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="D<%=j%><%=bd++%>" id="D<%=j%><%=bd++%>" value="<%=birthplace_desc%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="Common.birthPlace.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=birthplace_desc%></B><input type=hidden name='LD<%=j%><%=lbd++%>' id='LD<%=j%><%=lbd++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.birthPlace.label","common_labels")%>'></td></tr>
			
			<input type="hidden" name="bdcount<%=j%>" id="bdcount<%=j%>" value="<%=bd%>">
			</table></td></tr>

			<tr><td class="<%=classValue%>" nowrap colspan='2'><input type="checkbox" name="clinicalChkBox<%=j%>" id="clinicalChkBox<%=j%>"  onclick="javascript:perform(this,'<%=j%>');"><b><fmt:message key="eMP.clinicaldetails.label" bundle="${mp_labels}"/></b></td></tr>

			<tr><td colspan='2'><table class='grid' align='center' width='100%'>
 
			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=indicator_mark%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.IndicatorMark.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=indicator_mark%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.IndicatorMark.label","mp_labels")%>'></td></tr>
 
			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=outcome%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="Common.outcome.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=outcome%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.outcome.label","common_labels")%>'></td></tr>
 
			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=lengthof%><%=lengthof.equals("1")?UNIT_OF_LENGTH_NB_s:(!lengthof.equals(" "))?UNIT_OF_LENGTH_NB_m:""%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.LengthofBaby.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=lengthof%><%=lengthof.equals("1")?UNIT_OF_LENGTH_NB_s:(!lengthof.equals(" "))?UNIT_OF_LENGTH_NB_m:""%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.LengthofBaby.label","mp_labels")%>'></td></tr>
 
			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=weight%><%=weight.equals("1")?UNIT_OF_WT_NB_s:(!weight.equals(" "))?UNIT_OF_WT_NB_m:""%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.BirthWeight.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=weight%><%=weight.equals("1")?UNIT_OF_WT_NB_s:(!weight.equals(" "))?UNIT_OF_WT_NB_m:""%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.BirthWeight.label","mp_labels")%>'></td></tr>
 
			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=headcircumference%><%=headcircumference.equals("1")?UNIT_OF_CIRCUM_NB_s:(!headcircumference.equals(" "))?UNIT_OF_CIRCUM_NB_m:""%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="Common.HeadCircumference.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=headcircumference%><%=headcircumference.equals("1")?UNIT_OF_CIRCUM_NB_s:(!headcircumference.equals(" "))?UNIT_OF_CIRCUM_NB_m:""%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.HeadCircumference.label","common_labels")%>'></td></tr>
 
			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=chestcircumference%><%=chestcircumference.equals("1")?UNIT_OF_CHEST_CIRCUM_NB_s:(!chestcircumference.equals(" "))?UNIT_OF_CHEST_CIRCUM_NB_m:""%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.ChestCircum.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=chestcircumference%><%=chestcircumference.equals("1")?UNIT_OF_CHEST_CIRCUM_NB_s:(!chestcircumference.equals(" "))?UNIT_OF_CHEST_CIRCUM_NB_m:""%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ChestCircum.label","mp_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=umbilicalcordstatus%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.UmbilicalCord.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.status.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=umbilicalcordstatus%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.UmbilicalCord.label","mp_labels")%> <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=umbcordcutby%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.UmbCordCutBy.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=umbcordcutby%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.UmbCordCutBy.label","mp_labels")%>'></td></tr> 
 
			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=feedingdesc%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.Feeding.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=feedingdesc%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Feeding.label","mp_labels")%>'></td></tr>
 
			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=patencyofanusyn%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.PatencyofAnus.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=patencyofanusyn%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatencyofAnus.label","mp_labels")%>'></td></tr>
 
			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=conganomdesc%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.CongenitalAnomalies.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=conganomdesc%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.CongenitalAnomalies.label","mp_labels")%>'></td></tr>
 
			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=stools%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.Stools.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=stools%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Stools.label","mp_labels")%>'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="C<%=j%><%=bc++%>" id="C<%=j%><%=bc++%>" value="<%=blood_grp%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="Common.bloodgroup.label" bundle="${common_labels}"/></td><td class="<%=classValue%>"><B><%=blood_grp%></B><input type=hidden name='LC<%=j%><%=lbc++%>' id='LC<%=j%><%=lbc++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bloodgroup.label","common_labels")%>'></td></tr>

			<input type="hidden" name="bccount<%=j%>" id="bccount<%=j%>" value="<%=bc%>">
			</table></td></tr>

			<tr><td class="<%=classValue%>" nowrap colspan='2'><input type="checkbox" name="vaccineChkBox<%=j%>" id="vaccineChkBox<%=j%>" onclick="javascript:perform(this,'<%=j%>');"><b><fmt:message key="eMP.vaccinationdetails.label" bundle="${mp_labels}"/></b></td></tr>
			<tr><td colspan='2'><table class='grid' align='center' width='100%'>
		
			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="V<%=j%><%=v++%>" id="V<%=j%><%=v++%>"  value="<%=bcg_admin_dtls%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.BCG.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=bcg_admin_dtls%></B><input type=hidden name='LV<%=j%><%=lv++%>' id='LV<%=j%><%=lv++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.BCG.label","mp_labels")%>'></td></tr>
		
			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="V<%=j%><%=v++%>" id="V<%=j%><%=v++%>"  value="<%=vitak_admin_dtls%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')"><fmt:message key="eMP.VitaminK.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=vitak_admin_dtls%></B><input type=hidden name='LV<%=j%><%=lv++%>' id='LV<%=j%><%=lv++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.VitaminK.label","mp_labels")%>'></td></tr>
		 
			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="V<%=j%><%=v++%>" id="V<%=j%><%=v++%>"  value="<%=hepB_admin_dtls%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')" ><fmt:message key="eMP.HepatitisB.label" bundle="${mp_labels}"/></td><td class="<%=classValue%>"><B><%=hepB_admin_dtls%></B><input type=hidden name='LV<%=j%><%=lv++%>' id='LV<%=j%><%=lv++%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.HepatitisB.label","mp_labels")%>'></td></tr>
		
			<input type="hidden" name="vcount<%=j%>" id="vcount<%=j%>" value="<%=v%>">
			</table></td></tr>

			<tr><td class="<%=classValue%>" nowrap colspan='2'><input type="checkbox" name="apgarChkBox<%=j%>" id="apgarChkBox<%=j%>"  onclick="javascript:perform(this,'<%=j%>');"><b><fmt:message key="Common.ApgarScore.label" bundle="${common_labels}"/></b></td></tr>

			<tr><td colspan='2'><table class='grid' align='center' width='100%'>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="A<%=j%><%=ba++%>" id="A<%=j%><%=ba++%>" value="<%=apgarscorein1mins%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')">Apgarscore in 1 mins</td><td class="<%=classValue%>"><B><%=apgarscorein1mins%></B><input type=hidden name='LA<%=j%><%=lba++%>' id='LA<%=j%><%=lba++%>' value='Apgarscore in 1 mins'></td></tr>

			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="A<%=j%><%=ba++%>" id="A<%=j%><%=ba++%>" value="<%=apgarscorein5mins%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')">Apgarscore in 5 mins</td><td class="<%=classValue%>"><B><%=apgarscorein5mins%></B><input type=hidden name='LA<%=j%><%=lba++%>' id='LA<%=j%><%=lba++%>' value='Apgarscore in 5 mins'></td></tr>
 
			<tr><td class="<%=classValue%>" width='30%' nowrap><input type="checkbox" name="A<%=j%><%=ba++%>" id="A<%=j%><%=ba++%>" value="<%=apgarscorein10mins%>" onclick="Add(this,'<%=j%>');remove(this,'<%=j%>')">Apgarscore in 10 mins</td><td class="<%=classValue%>"><B><%=apgarscorein10mins%></B><input type=hidden name='LA<%=j%><%=lba++%>' id='LA<%=j%><%=lba++%>' value='Apgarscore in 10 mins'></td></tr>
 
			<input type="hidden" name="bacount<%=j%>" id="bacount<%=j%>" value="<%=ba%>">
			</table></td></tr>
	<%
		}
		if(rs != null ) rs.close();
		if(stmt != null ) stmt.close();
	}
	i++;
	if(rs!=null) rs.close();
	if(stmt!=null)stmt.close();	
	}
}

catch(Exception e)
{
	e.printStackTrace();
	out.println("Exception cauight in RecClinicalNotesLinkBirthMain.jsp" + e);
}
finally 
{
	ConnectionManager.returnConnection(con,request);
}

%>
	</table>		
	<input type="hidden" name="mcount" id="mcount" value="<%=k%>">
	<input type="hidden" name="bcount" id="bcount" value="<%=b%>">
	<input type="hidden" name="kcount" id="kcount" value="<%=m%>">
	<input type="hidden" name="fcount" id="fcount" value="<%=f%>">
	<input type="hidden" name="babycount" id="babycount" value="<%=j%>">
	<input type="hidden" name="noofbirths" id="noofbirths" value="<%=noofbirths%>">
	<input type="hidden" name="seltext" id="seltext" value="">
	<input type="hidden" name="return_format" id="return_format" value="<%=return_format%>">
	<input type="hidden" name="check" id="check" value="">
	<input type="hidden" name="order" id="order" value="<%=order%>">
	<input type="hidden" name="mother_encounter_id" id="mother_encounter_id" value="<%=mother_encounter_id%>">
	<input type="hidden" name="mother_yn" id="mother_yn" value="<%=mother_yn%>">

</form>
</body>
</script>
</html>

