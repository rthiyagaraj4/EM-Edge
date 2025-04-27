<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.Common.*,java.util.HashMap,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="apptRecordSet" class="webbeans.eCommon.RecordSet" scope="session"/>
<html>
<head>
	<%request.setCharacterEncoding("UTF-8");
	
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
    <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
    <Script src="../../eOP/js/VisitRegistration1.js" language="JavaScript"></Script>
	<Script src="../../eOP/js/VisitRegistration.js" language="JavaScript"></Script>
	
    <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<% 
        Connection con = null;
		HashMap htRecord  = null ;
		ResultSet rs=null;
		ResultSet rs1=null;
        PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		String endOfRes="1";
		

		
		StringBuffer where_clause_build = new StringBuffer();
		StringBuffer sql1=new StringBuffer();
		StringBuffer name_list    =new StringBuffer();
		name_list.setLength(0);
		String gender="";
		StringBuffer temp=new StringBuffer();
		String alternateIDNo[]=new String[4];
		String from = request.getParameter( "from" ) ;
		String to = request.getParameter( "to" ) ;
		int start = 0 ;
		int end = 0 ;
		int incr=0;
		//int recCount=0; 
		if ( from == null )
		start = 1 ;
		else
		start = Integer.parseInt( from ) ;
		if ( to == null )
		end = 10 ;
		else
		end = Integer.parseInt( to ) ;
		String locale=(String)session.getAttribute("LOCALE");
		String Facility_Id  = (String) session.getValue("facility_id");
		String srchbyloc=request.getParameter("srchbyascii")==null?"":request.getParameter("srchbyascii");
		/*below line upt_contact_dtls_oa_yn field added by venkatesh.S on 26-11-2014 against HSA-CRF-0226 [IN:050599] */
		String upt_contact_dtls_oa_yn=request.getParameter("upt_contact_dtls_oa_yn")==null?"":request.getParameter("upt_contact_dtls_oa_yn");
		String r_area_code=request.getParameter("r_area")==null?"":request.getParameter("r_area");
		String m_area_code=request.getParameter("m_area")==null?"":request.getParameter("m_area");
		String r_region_code=request.getParameter("r_region")==null?"":request.getParameter("r_region");
		String build_episode_rule =request.getParameter("build_episode_rule")==null?"":request.getParameter("build_episode_rule");
		String m_region_code=request.getParameter("m_region")==null?"":request.getParameter("m_region");
		String r_town_code=request.getParameter("r_town")==null?"":request.getParameter("r_town");
		String emer_regn_allow_yn=request.getParameter("emer_regn_allow_yn")==null?"":request.getParameter("emer_regn_allow_yn");
		String m_town_code=request.getParameter("m_town")==null?"":request.getParameter("m_town");
		String specCode=request.getParameter("specCode")==null?"":request.getParameter("specCode");
		String wait_list_priority=request.getParameter("wait_list_priority")==null?"":request.getParameter("wait_list_priority");
		String wait_list_inv=request.getParameter("wait_list_inv")==null?"":request.getParameter("wait_list_inv");
		String category=request.getParameter("category")==null?"":request.getParameter("category");
		String WaitListNo=request.getParameter("WaitListNo")==null?"":request.getParameter("WaitListNo");
		String waitlist_fromdate=request.getParameter("waitlist_fromdate")==null?"":request.getParameter("waitlist_fromdate");
		String waitlist_todate=request.getParameter("waitlist_todate")==null?"":request.getParameter("waitlist_todate");
		String patient_id   = (request.getParameter("Patient")== null)?"":request.getParameter("Patient");
        String where_clause     = request.getParameter("where_clause")==null?"":request.getParameter("where_clause");
		
		String oper_stn_id  = request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
		String first_name   = request.getParameter("first_name")==null?"":request.getParameter("first_name");
        String second_name  = request.getParameter("second_name")==null?"":request.getParameter("second_name");
        String third_name   = request.getParameter("third_name")==null?"":request.getParameter("third_name");
        String family_name  = request.getParameter("family_name")==null?"":request.getParameter("family_name");
		String name_prefix  = request.getParameter("name_prefix")==null?"":request.getParameter("name_prefix");
		String sndx_type    = request.getParameter("sndx_type")==null?"":request.getParameter("sndx_type");
		String oa_install_yn= request.getParameter("oa_install_yn")==null?"":request.getParameter("oa_install_yn");
        String nat_id_prompt    = request.getParameter("nat_id_prompt");
		String nationality_id    = request.getParameter("nationality_id")==null?"":request.getParameter("nationality_id");       
		
		String NRICNo = request.getParameter("NRICNo")==null?"":request.getParameter("NRICNo");
		String otherAlternateIDType = request.getParameter("otherAlternateIDType")==null?"":request.getParameter("otherAlternateIDType");
		String otherAlternateIDNo = request.getParameter("otherAlternateIDNo")==null?"":request.getParameter("otherAlternateIDNo");
		
		String register_visit_walkin=(request.getParameter("register_visit_walkin") == null)?"":request.getParameter("register_visit_walkin");
		String register_visit_referral=(request.getParameter("register_visit_referral") == null)?"":request.getParameter("register_visit_referral");
		String functionId=(request.getParameter("function_id") == null)?"":request.getParameter("function_id");	
		
		String bl_interface_yn=(request.getParameter("bl_interface_yn") == null)?"":request.getParameter("bl_interface_yn");	
		String or_install_yn=(request.getParameter("or_install_yn") == null)?"":request.getParameter("or_install_yn");  
		String clinic_type=(request.getParameter("clinic_type") == null)?"":request.getParameter("clinic_type");
		String clinic_code=(request.getParameter("clinic_code") == null)?"":request.getParameter("clinic_code");
		String accept_dis_inv_no=(request.getParameter("accept_dis_inv_no") == null)?"":request.getParameter("accept_dis_inv_no");
		/*Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] Start*/
		String extApptOnly=(request.getParameter("extApptOnly") == null)?"N":request.getParameter("extApptOnly");
		String isPractoApptApplYN = (request.getParameter("isPractoApptApplYN") == null)?"false":request.getParameter("isPractoApptApplYN");
		String isPractoApptYn	= "N";
		/*Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] End*/
		/* added by lakshmanan for  ML-MMOH-CRF-1930 US007 start */
		String isVirtualConsultationVisit = (request.getParameter("isVirtualConsultationVisit") == null)?"false":request.getParameter("isVirtualConsultationVisit"); 
		String virtualConsultVisit=(request.getParameter("virtualConsultVisit") == null)?"N":request.getParameter("virtualConsultVisit"); 
		String visitTypeShortDesc="";
		String virtualConsultEnable="";
		/* added by lakshmanan for  ML-MMOH-CRF-1930 US007 end*/
		String multi_speciality_yn="";//Added for the CRF Bru-HIMS-198
		String speciality_code="";//Added for the CRF Bru-HIMS-198
		String multi_pract_sql="";//Added for the CRF Bru-HIMS-198
		PreparedStatement multiPrepdStmt=null;
		ResultSet multirset=null;

		String ext_appt_ref_no = "";
		
		/*Below lines modified by Venkatesh.S on 15/Feb/2013 against CHL-SCF-0013 [IN035559] */
		first_name=first_name.trim();
		second_name=second_name.trim();
		third_name=third_name.trim();
		family_name=family_name.trim();
		name_prefix=name_prefix.trim();
		/* end  CHL-SCF-0013 [IN035559]*/
		
		String classValue   = "";
        int row_even_or_odd = 1;
        String q_patient_id     = "";
        String q_appt_time  = "";		
		String locn_type_desc="";        
        int    lower_limit     =   0;      
     

        
		
		if(!patient_id.equals(""))
		{	where_clause_build.append(" and patient_id='"+patient_id+"'");
		}
		
		for(int i=0;i<4;i++)
		{   alternateIDNo[i]=request.getParameter("alternateIDNo"+(i+1))==null?"":request.getParameter("alternateIDNo"+(i+1));
			if(!alternateIDNo[i].equals(""))
			where_clause_build.append(" and a.alt_id"+(i+1)+"_no = '"+alternateIDNo[i]+"' "); 
		}
		if(!NRICNo.equals(""))
		where_clause_build.append(" and a.national_id_no = '"+NRICNo+"' ");			
		if(!otherAlternateIDType.equals("") && !otherAlternateIDNo.equals(""))
		where_clause_build.append(" and a.oth_alt_id_type = '"+otherAlternateIDType+"' and a.oth_alt_id_no = '"+otherAlternateIDNo+"' ");
		
		
		if(wait_list_inv.equals("Y"))
        {
		    if(!nationality_id.equals(""))  
				where_clause_build.append("and a.NATIONALITY_CODE = '"+nationality_id+"' " ) ;
			if (!clinic_type.equals("")) 
				where_clause_build.append(" and a.care_locn_type_ind='"+clinic_type+"'");	
			else 
				where_clause_build.append(" and a.care_locn_type_ind in ('C','E') ");	
			if (!clinic_code.equals("")) 
				where_clause_build.append(" and a.locn_code='"+clinic_code+"'");
			if (!specCode.equals("")) 
				where_clause_build.append(" and a.SPECIALTY_CODE='"+specCode+"'");	  
			if (!WaitListNo.equals("")) 
			    where_clause_build.append(" and a.wait_list_no='"+WaitListNo.trim()+"'");
			if	(!r_area_code.equals(""))
				where_clause_build.append(" and a.RES_AREA_CODE ='"+r_area_code+"'");
			if (!m_area_code.equals(""))
				where_clause_build.append(" and a.MAIL_AREA_CODE ='"+m_area_code+"'");
			if	(!r_town_code.equals(""))
				where_clause_build.append(" and a.RES_TOWN_CODE ='"+r_town_code+"'");
			if	(!m_town_code.equals(""))
				where_clause_build.append(" and a.MAIL_TOWN_CODE ='"+m_town_code+"'");
			if	(!r_region_code.equals(""))
				where_clause_build.append(" and a.RES_REGION_CODE ='"+r_region_code+"'");
			if	(!m_region_code.equals(""))
				where_clause_build.append(" and a.MAIL_REGION_CODE ='"+m_region_code+"'");
			if (!wait_list_priority.equals(""))
				where_clause_build.append(" and a.WAIT_LIST_PRIORITY ='"+wait_list_priority+"'");
	   		if (!category.equals(""))
				where_clause_build.append(" and a.WAITLIST_CATEGORY_CODE ='"+category+"'");
			if (!waitlist_fromdate.equals("")) 
				where_clause_build.append("  and trunc(a.invited_date_time)>=to_date('"+waitlist_fromdate+"','dd/mm/yyyy')");
			if (!waitlist_todate.equals(""))  
				where_clause_build.append(" and trunc(a.invited_date_time)<=to_date('"+waitlist_todate+"','dd/mm/yyyy')");	
		}else{
		
		if(!nationality_id.equals(""))  
        where_clause_build.append(" and a.COUNTRY_CODE = '"+nationality_id+"' " ) ;
		/*Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] Start*/
		if(extApptOnly.equals("Y"))
			where_clause_build.append(" and ext_appt_ref_no is not null " ) ;
		/*Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] End*/
		
		if (sndx_type.equals("E"))
        {
           if(srchbyloc.equals("N"))
			{
			if (!first_name.equals(""))
            name_list.append(" and ethnic_soundex(upper(a.first_name)) like ethnic_soundex(upper('"+first_name+"'))||'%' ");
            if (!second_name.equals(""))
            name_list.append(" and ethnic_soundex(upper(a.second_name)) like ethnic_soundex(upper('"+second_name+"'))||'%' ");
            if (!third_name.equals(""))
            name_list.append(" and ethnic_soundex(upper(a.third_name)) like ethnic_soundex(upper('"+third_name+"'))||'%' ");
         	if (!family_name.equals(""))
             name_list.append(" and ethnic_soundex(upper(a.family_name)) like ethnic_soundex(upper('"+family_name+"'))||'%' ");
							
			
			}else{
			if (!first_name.equals(""))
            name_list.append(" and ethnic_soundex(upper(a.first_name_loc_lang)) like ethnic_soundex(upper('"+first_name+"'))||'%' ");
            if (!second_name.equals(""))
            name_list.append(" and ethnic_soundex(upper(a.second_name_loc_lang)) like ethnic_soundex(upper('"+second_name+"'))||'%' ");
            if (!third_name.equals(""))
            name_list.append(" and ethnic_soundex(upper(a.third_name_loc_lang)) like ethnic_soundex(upper('"+third_name+"'))||'%' ");
         	if (!family_name.equals(""))
             name_list.append(" and ethnic_soundex(upper(a.family_name_loc_lang)) like ethnic_soundex(upper('"+family_name+"'))||'%' ");



			}
		}
        else if (sndx_type.equals("G"))
        {
             if(srchbyloc.equals("N"))
			{
			if (!first_name.equals(""))
            name_list.append(" and soundex(upper(a.first_name)) like soundex(upper('"+first_name+"'))||'%' ");
            if (!second_name.equals(""))
            name_list.append(" and soundex(upper(a.second_name)) like soundex(upper('"+second_name+"'))||'%' ");
            if (!third_name.equals(""))
            name_list.append(" and soundex(upper(a.third_name)) like soundex(upper('"+third_name+"'))||'%' ");
            if (!family_name.equals(""))
            name_list.append(" and soundex(upper(a.family_name)) like soundex(upper('"+family_name+"'))||'%' ");
			
			}else
			{
			if (!first_name.equals(""))
            name_list.append(" and soundex(upper(a.first_name_loc_lang)) like soundex(upper('"+first_name+"'))||'%' ");
            if (!second_name.equals(""))
            name_list.append(" and soundex(upper(a.second_name_loc_lang)) like soundex(upper('"+second_name+"'))||'%' ");
            if (!third_name.equals(""))
            name_list.append(" and soundex(upper(a.third_name_loc_lang)) like soundex(upper('"+third_name+"'))||'%' ");
            if (!family_name.equals(""))
            name_list.append(" and soundex(upper(a.family_name_loc_lang)) like soundex(upper('"+family_name+"'))||'%' ");
			
			}
		}
        else
        {  
			 if(srchbyloc.equals("N"))
			{
			
			if (!first_name.equals(""))
            name_list.append(" and upper(a.first_name) like upper('"+first_name+"')||'%' ");
            if (!second_name.equals(""))
            name_list.append(" and upper(a.second_name) like upper('"+second_name+"')||'%' ");
            if (!third_name.equals(""))
            name_list.append(" and upper(a.third_name) like upper('"+third_name+"')||'%' ");
            if (!family_name.equals(""))
            name_list.append(" and upper(a.family_name) like upper('"+family_name+"')||'%' ");
			
			
			}else{
		    
			if (!first_name.equals(""))
           	name_list.append(" and upper(a.first_name_loc_lang) like upper('"+first_name+"%') ");
            if (!second_name.equals(""))
            name_list.append(" and upper(a.second_name_loc_lang) like upper('"+second_name+"')||'%' ");
            if (!third_name.equals(""))
            name_list.append(" and upper(a.third_name_loc_lang) like upper('"+third_name+"')||'%' ");
            if (!family_name.equals(""))
            name_list.append(" and upper(a.family_name_loc_lang) like upper('"+family_name+"')||'%' ");
			
			}
		}
        name_prefix		     = (name_prefix == null)?"":name_prefix;
		
   		int cnt=0;
		while(name_prefix.indexOf("'",cnt)!=-1)
		{	
			int a=name_prefix.indexOf("'",cnt);
			temp.setLength(0);
			temp.append(name_prefix);
			temp.replace(a,a+1,"''");
			name_prefix=temp.toString();
			cnt=(a+2);
		}
		
		temp.setLength(0);
		if (!name_prefix.equals(""))
			name_list.append(" and upper(a.name_prefix) like upper('"+name_prefix+"')||'%' ");
		

		if (oper_stn_id!=null||(!oper_stn_id.equals("")))
        {            
          where_clause_build.append( "and a.clinic_code in(SELECT LOCN_CODE FROM am_locn_for_oper_stn b1 WHERE B1.facility_id = '"+Facility_Id+"' AND b1.oper_stn_id = '"+oper_stn_id+"'  AND b1.eff_status = 'E')");
		 			
		 					
        }
        }
	 %>

<body onMouseDown="CodeArrest();" onKeyDown ='lockKey();' >
  <form name='checkinresult' id='checkinresult'>
 
	<%
		String practname="";  
        String locn_type = "";			
		String locn_code = "";
		 boolean isVIPimgpatfrontappl = false;//Added by Mujafar against ML-MMOH-CRF-1070
		 boolean isUHID_valid_appl = false; //Added by Mujafar against ML-MMOH-CRF-1070

		 //Added by Ashwini on 01-Dec-2021 for ML-BRU-CRF-0628.6
		 Boolean isSlotStartMidEndAppl = false;

		try
        {
		con = ConnectionManager.getConnection(request);
		isVIPimgpatfrontappl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA","VIP_IMG_PAT_NAME_FRONT_APPL");//Added by Mujafar against ML-MMOH-CRF-1070
		
		isUHID_valid_appl = CommonBean.isSiteSpecific(con, "MP","UHID_VALID_DAYS_APPL"); // Added by mujafar for AMRI-CRF-0357

		isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "BRU_HEALTH_INTG");//Added by Ashwini on 01-Dec-2021 for ML-BRU-CRF-0628.6
		
		sql1.setLength(0);
		if(wait_list_inv.equals("Y"))
        {
			/*
			String sql_inv = "select ACCEPT_DISPLAY_INV_NO from op_param where operating_facility_id='"+Facility_Id+"'";

			pstmt   = con.prepareStatement(sql_inv);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				accept_dis_inv_no = rs.getString("ACCEPT_DISPLAY_INV_NO") == null ? "":rs.getString("ACCEPT_DISPLAY_INV_NO");
			}

			if (pstmt != null) pstmt.close();
            if (rs != null) rs.close();
			*/
				
			//order_catalog_code added in the query by S.Sathish for PMG20089-CRF-0850 on Friday, July 02, 2010	
			sql1.append("SELECT wait_list_status, NVL(a.INVITATION_NUMBER,  '') invitation_no, a.WAIT_LIST_NO wait_list_no, a.WAIT_LIST_PRIORITY priority , NVL(a.PATIENT_ID,'') patient_id, decode('"+locale+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, TO_CHAR(a.PREFERRED_DATE_TIME,  'dd/mm/yyyy') pref_date_time , a.care_locn_type_ind locn_type, a.RESOURCE_CLASS  resc_class,  am_get_desc.AM_PRACTITIONER(resource_id,'"+locale+"',2) pract_name,  op_get_desc.OP_CLINIC('"+Facility_Id+"',a.locn_code,'"+locale+"',1) CLINIC_SHORT_DESC, a.SPECIALTY_CODE,  a.locn_code clinic_code, a.resource_id PRACTITIONER_ID, a.resource_class,  am_get_desc.am_speciality(SPECIALTY_CODE,'"+locale+"',2) SPECIALITY_DESC, a.GENDER GENDER, get_age(a.DATE_OF_BIRTH) age, TO_CHAR(a.INVITED_DATE_TIME,'dd/mm/yyyy') INVITED_DATE_TIME , oa_get_desc.OA_WAITLIST_CATEGORY(waitlist_category_code,'"+locale+"',2) category_desc,  waitlist_category_code,a.order_catalog_code order_catlog_code,multi_speciality_yn,specialty_code,a.oth_contact_no FROM pr_wait_list a WHERE a.facility_id = '"+Facility_Id+"' AND a.rd_waitlist_yn='N' and a.wait_list_status = 'I' AND   a.patient_id IS NOT NULL  ");
			sql1.append(where_clause_build.toString());
			sql1.append("  ORDER BY a.WAIT_LIST_PRIORITY DESC, to_number(a.WAIT_LIST_NO), a.PREFERRED_DATE_TIME");
		
		} else {
		
	
			//sql1.append("SELECT   TO_CHAR(a.appt_time,'hh24:mi') appt_time,a.appt_status,decode('"+locale+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, NVL(a.patient_id,'') patient_id, OP_GET_DESC.OP_CLINIC(a.FACILITY_ID, a.CLINIC_CODE,'"+locale+"','1') clinic_desc,  DECODE(a.resource_class,  'P', am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1),  'R',  a.practitioner_id,  AM_GET_DESC.AM_RESOURCE(a.FACILITY_ID, a.practitioner_id,'"+locale+"','2')) practitioner_name,  a.clinic_code clinic_code,  a.practitioner_id pract_id,  a.appt_ref_no,  a.appt_type_code,  NVL(a.referral_id,  '')referral_id,  TO_CHAR(a.appt_date,  'dd/mm/yyyy') appt_date,  TO_CHAR(a.appt_slab_from_time,  'hh24:mi') from_time,  TO_CHAR(a.appt_slab_to_time,  'hh24:mi') to_time,  mp_get_desc.mp_country(COUNTRY_CODE,'"+locale+"',3) nationality,  national_id_no,  a.care_locn_type_ind clinic_type,  a.resource_class resource_class,  a.resource_class  resource_desc, a.service_code service_code, a.recur_wo_sec_res recur_wo_sec_res,am_get_desc.am_contact_reason(CONTACT_REASON_CODE,'"+locale+"',1)  reason,CONTACT_REASON_CODE");  
			/*Above Query Commented and Below Query modified for this CRF [RUT-CRF-0011]*/
			/* this line query was modified by venkatesh.s on 15/Nov/2012 agaings CRF SS-CRF-0010 [IN034516] FD 3.0 version */
			sql1.append("SELECT   TO_CHAR(a.appt_time,'hh24:mi') appt_time,a.appt_status,decode('"+locale+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, NVL(a.patient_id,'') patient_id, OP_GET_DESC.OP_CLINIC(a.FACILITY_ID, a.CLINIC_CODE,'"+locale+"','1') clinic_desc,  DECODE(a.resource_class,  'P', am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1),  'R',  a.practitioner_id,  AM_GET_DESC.AM_RESOURCE(a.FACILITY_ID, a.practitioner_id,'"+locale+"','2')) practitioner_name,am_get_desc.am_facility_room (a.facility_id,a.practitioner_id,'"+locale+"', 2) room_shor_desc,a.clinic_code clinic_code,  a.practitioner_id pract_id,  a.appt_ref_no,  a.appt_type_code,  NVL(a.referral_id,  '')referral_id,  TO_CHAR(a.appt_date,  'dd/mm/yyyy') appt_date,  TO_CHAR(a.appt_slab_from_time,  'hh24:mi') from_time,  TO_CHAR(a.appt_slab_to_time,  'hh24:mi') to_time,  mp_get_desc.mp_country(COUNTRY_CODE,'"+locale+"',3) nationality,  national_id_no,  a.care_locn_type_ind clinic_type,  a.resource_class resource_class,  a.resource_class  resource_desc, a.service_code service_code, a.recur_wo_sec_res recur_wo_sec_res, a.patient_cat_code patient_cat_code, am_get_desc.am_contact_reason(CONTACT_REASON_CODE,'"+locale+"',1)  reason,CONTACT_REASON_CODE,MULTI_SPECIALITY_YN,a.SPECIALITY_CODE,a.ext_appt_ref_no,a.oth_contact_no ");  
			
			if(or_install_yn.equals("Y"))
			{
				sql1.append(",a.ordering_facility_id ordering_facility_id,  a.order_id order_id,  a.order_line_num order_line_num,  a.order_type_code order_type_code,  a.order_catalog_code order_catlog_code,  e.short_desc order_catalog_desc"); 
			}
			if(isVirtualConsultationVisit.equals("true")) {  // ML-MMOH-CRF-1930 US007
				sql1.append(", f.virtual_consultation , f.short_desc");
			}	
			sql1.append(" FROM  oa_appt a ");
			if(isVirtualConsultationVisit.equals("true")) { // ML-MMOH-CRF-1930 US007
				sql1.append(", op_visit_type f");
			}
			if(or_install_yn.equals("Y"))
			{
				sql1.append(" ,or_order_catalog e"); 
			}
			sql1.append(" WHERE   a.facility_id='"+Facility_Id+"' AND  a.appt_date = TRUNC(SYSDATE) AND rd_appt_yn = 'N' and  a.appt_status = '1'");
			if(isVirtualConsultationVisit.equals("true")) { // ML-MMOH-CRF-1930 US007
				sql1.append(" and a.appt_type_code=f.visit_type_code and a.facility_id=f.facility_id ");
				if (virtualConsultVisit.equals("Y")) {
					sql1.append("and f.virtual_consultation='E' ");
				}
			}
			if(or_install_yn.equals("Y"))
			{
				sql1.append(" and a.order_catalog_code=e.order_catalog_code(+)");
			}
			sql1.append(where_clause+where_clause_build.toString()+name_list.toString());

			if(clinic_type.equals("C"))			
				sql1.append(" and a.care_locn_type_ind = 'C' ");			
			else if(clinic_type.equals("E"))
				sql1.append(" and a.care_locn_type_ind = 'E' ");
			else 
				sql1.append(" and a.care_locn_type_ind in ('C','E') ");	  	

			sql1.append("  order by 1 ");			

		}
		    
		name_list.setLength(0);
		where_clause_build.setLength(0);      
		
		pstmt   = con.prepareStatement(sql1.toString());				
        rs = pstmt.executeQuery();
      	apptRecordSet.clearAll();
        if( rs != null )
          {                    
		for( int j=1; j<start; incr++,j++ ){
	     rs.next() ;
	     }
		while( incr<end && rs.next() )
          {      htRecord = new HashMap();                  
		if (row_even_or_odd == 1)
           {
		   row_even_or_odd = 2;
           classValue = "QRYODD";
		   }
           else
           {
			classValue = "QRYEVEN";
			row_even_or_odd = 1;
		   }  

            if(wait_list_inv.equals("Y")) 		
			{       
				 htRecord.put("invitation_no", rs.getString("invitation_no")==null?"":rs.getString("invitation_no"));
				 htRecord.put("wait_list_status",  rs.getString("wait_list_status")==null?"":rs.getString("wait_list_status"));
				
				 String priority=rs.getString("priority")==null?"":rs.getString("priority");
				 if(priority.equals("U"))
				 {				  priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels"); 
				 } else if(priority.equals("S")) {
					priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.semiurgent.label","common_labels"); 
				 } else if(priority.equals("N")) {
					   priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels"); 
				 }
				 htRecord.put("priority", priority );
               	 htRecord.put("patient_id",  rs.getString("patient_id")==null?"":rs.getString("patient_id"));
				 htRecord.put("patient_name", rs.getString("patient_name")==null?"":rs.getString("patient_name"));
				 htRecord.put("oth_contact_no", rs.getString("oth_contact_no")==null?"":rs.getString("oth_contact_no"));
				 htRecord.put("pref_date_time",  rs.getString("pref_date_time")==null?"":rs.getString("pref_date_time"));
				 htRecord.put("age",rs.getString("age")==null?"":rs.getString("age"));				 
				 locn_type = rs.getString("locn_type")==null?"":rs.getString("locn_type");				 
  			     htRecord.put("locn_type", locn_type  );		
					 
					  htRecord.put("pract_name",  (rs.getString("pract_name")==null?"":rs.getString("pract_name")) );
					  
					  gender=rs.getString("GENDER")==null?"":rs.getString("GENDER");
					  if(gender.equals("M"))
				        {
				       gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels"); 
						}
					  else if(gender.equals("F"))
				        {
					   gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels"); 
                			   }
                      else if(gender.equals("U"))
			               {
			                   gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						   }
					  
					  htRecord.put("GENDER",gender);
					  htRecord.put("CLINIC_SHORT_DESC", rs.getString("CLINIC_SHORT_DESC")==null?"":rs.getString("CLINIC_SHORT_DESC"));
					  htRecord.put("SPECIALTY_CODE", rs.getString("SPECIALTY_CODE")==null?"":rs.getString("SPECIALTY_CODE"));
					 
					  htRecord.put("clinic_code", rs.getString("clinic_code")==null?"":rs.getString("clinic_code"));	
					  htRecord.put("PRACTITIONER_ID", rs.getString("PRACTITIONER_ID")==null?"":rs.getString("PRACTITIONER_ID"));	
					  htRecord.put("resource_class", rs.getString("resource_class")==null?"":rs.getString("resource_class"));	
					  htRecord.put("SPECIALITY_DESC", rs.getString("SPECIALITY_DESC")==null?"":rs.getString("SPECIALITY_DESC"));	
					  htRecord.put("category_desc", rs.getString("category_desc")==null?"":rs.getString("category_desc"));	
					  htRecord.put("wait_list_no", 
					    rs.getString("wait_list_no")==null?"":rs.getString("wait_list_no"));	
					  //Added by S.Sathish for PMG20089-CRF-0850 on Friday, July 02, 2010
					  htRecord.put("order_catalog_code",(rs.getString("order_catlog_code") == null)?"":rs.getString("order_catlog_code"));
					 
					  String invited_date_timeconv=(rs.getString("invited_date_time")==null?"":rs.getString("invited_date_time"));
					  if(invited_date_timeconv!="")invited_date_timeconv=DateUtils.convertDate(invited_date_timeconv,"DMY","en",locale);
					  htRecord.put("invited_date_time",invited_date_timeconv );	
					//Added for the CRF - Bru-HIMS-CRF-0198 - Start
					    multi_speciality_yn=rs.getString("multi_speciality_yn")==null?"N":rs.getString("multi_speciality_yn");
					    htRecord.put("multi_speciality_yn",multi_speciality_yn);
					    if(multi_speciality_yn.equals("Y")){
					    	speciality_code=rs.getString("specialty_code")==null?"":rs.getString("specialty_code");
					    	multi_pract_sql="select practitioner_id, practitioner_name from am_practitioner_lang_vw where PRIMARY_SPECIALITY_CODE='"+speciality_code+"' and language_id='"+locale+"'";
					    	multiPrepdStmt   = con.prepareStatement(multi_pract_sql);				
					    	multirset = multiPrepdStmt.executeQuery();
					    	if(multirset!=null && multirset.next()){
					    		htRecord.put("PRACTITIONER_ID",multirset.getString("practitioner_id"));
					    		htRecord.put("practitioner_name",multirset.getString("practitioner_name"));
					    	}
					    }
					  //Added for the CRF - Bru-HIMS-CRF-0198 - End
							  
			    			  
			  }else{
							   
			if (rs.getString("patient_id") == null)
			q_patient_id =  "&nbsp;";
			else
			q_patient_id =  rs.getString("patient_id");

			if (rs.getString("appt_time") == null)
			q_appt_time =   "&nbsp;";
			else
			q_appt_time =   rs.getString("appt_time");	

			locn_type = rs.getString("clinic_type")==null?"":rs.getString("clinic_type");
			locn_code = rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
	   

			
			/*Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] Start*/
			ext_appt_ref_no = rs.getString("ext_appt_ref_no")==null?"":rs.getString("ext_appt_ref_no");
			isPractoApptYn = "N";
			if(!ext_appt_ref_no.equals(""))
				isPractoApptYn = "Y";

	   		htRecord.put("ext_appt_ref_no", ext_appt_ref_no);
	   		htRecord.put("isPractoApptYn", isPractoApptYn);
			/*Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] End*/
			
			/*Added by lakshmanan for ML-MMOH-CRF-1930 */
			if(isVirtualConsultationVisit.equals("true")) {
			visitTypeShortDesc=rs.getString("SHORT_DESC")==null?"":rs.getString("SHORT_DESC");
			virtualConsultEnable=rs.getString("virtual_consultation")==null?"":rs.getString("virtual_consultation");
			htRecord.put("visitTypeShortDesc", visitTypeShortDesc);
			htRecord.put("virtualConsultEnable", virtualConsultEnable);
			}
			/*Added by lakshmanan for ML-MMOH-CRF-1930 */
			
			htRecord.put("locn_code", locn_code);
			htRecord.put("locn_type", locn_type);
            htRecord.put("q_patient_id", q_patient_id);
            htRecord.put("q_appt_time",  q_appt_time);
         	htRecord.put("patient_name",  
			rs.getString("patient_name")==null?"":rs.getString("patient_name"));  
            htRecord.put("nationality",rs.getString("nationality")==null?"":rs.getString("nationality")); 
            htRecord.put("oth_contact_no",rs.getString("oth_contact_no")==null?"":rs.getString("oth_contact_no")); 
			htRecord.put("national_id_no",  rs.getString("national_id_no")==null?"&nbsp;":rs.getString("national_id_no")); 
         	htRecord.put("clinic_desc",  rs.getString("clinic_desc")==null?"":rs.getString("clinic_desc")); 
			
			htRecord.put("resource_class", (rs.getString("resource_class")==null?"":rs.getString("resource_class"))); 
		    multi_speciality_yn=rs.getString("multi_speciality_yn")==null?"N":rs.getString("multi_speciality_yn");
		    htRecord.put("multi_speciality_yn",multi_speciality_yn);

			if(((String)htRecord.get("resource_class")).equals("P"))
			{
			htRecord.put("Pract_id",rs.getString("pract_id")==null?"":rs.getString("pract_id"));  
			htRecord.put("practitioner_name", rs.getString("practitioner_name")==null?"":rs.getString("practitioner_name"));
            practname= (String)htRecord.get("practitioner_name");
			htRecord.put("Rpractitioner_name",practname);

			}
			else if(((String)htRecord.get("resource_class")).equals("E")||((String)htRecord.get("resource_class")).equals("O"))
			{
			htRecord.put("Pract_id",rs.getString("pract_id")==null?"":rs.getString("pract_id"));
			htRecord.put("practitioner_name","");
			htRecord.put("Rpractitioner_name",rs.getString("practitioner_name")==null?"":rs.getString("practitioner_name"));
			practname= rs.getString("practitioner_name")==null?"":rs.getString("practitioner_name");
			}else
			{
            htRecord.put("Pract_id","");
		    htRecord.put("practitioner_name","");
		    htRecord.put("Rpractitioner_name",rs.getString("practitioner_name")==null?"":rs.getString("practitioner_name"));
			/* this line was added by venkatesh.s on 15/Nov/2012 agaings CRF SS-CRF-0010 [IN034516] FD 3.0 version */
			htRecord.put("room_desc",rs.getString("room_shor_desc")==null?"":rs.getString("room_shor_desc"));
		    practname= rs.getString("practitioner_name")==null?"":rs.getString("practitioner_name");
		    //Added for the CRF - Bru-HIMS-CRF-0198 - Start
		    if(multi_speciality_yn.equals("Y")){
		    	speciality_code=rs.getString("SPECIALITY_CODE")==null?"":rs.getString("SPECIALITY_CODE");
		    	multi_pract_sql="select practitioner_id, practitioner_name from am_practitioner_lang_vw where PRIMARY_SPECIALITY_CODE='"+speciality_code+"' and language_id='"+locale+"'";
		    	multiPrepdStmt   = con.prepareStatement(multi_pract_sql);				
		    	multirset = multiPrepdStmt.executeQuery();
		    	if(multirset!=null && multirset.next()){
		    		htRecord.put("Pract_id",multirset.getString("practitioner_id"));
		    		htRecord.put("practitioner_name",multirset.getString("practitioner_name"));
		    	}
		    }
		  //Added for the CRF - Bru-HIMS-CRF-0198 - End
			}	
			
		    if(or_install_yn.equals("Y"))
			{
			htRecord.put("ordering_facility_id",(rs.getString("ordering_facility_id") == null)?"":rs.getString("ordering_facility_id"));
			htRecord.put("order_id",(rs.getString("order_id") == null)?"":rs.getString("order_id"));
			htRecord.put("order_line_num",(rs.getString("order_line_num") == null)?"":rs.getString("order_line_num"));
			htRecord.put("order_type_code",(rs.getString("order_type_code") == null)?"":rs.getString("order_type_code"));
			htRecord.put("order_catalog_code",(rs.getString("order_catlog_code") == null)?"":rs.getString("order_catlog_code"));
			htRecord.put("order_catalog_desc",(rs.getString("order_catalog_desc") == null)?"":rs.getString("order_catalog_desc"));
			}
			else
			{
			htRecord.put("ordering_facility_id","");
			htRecord.put("order_id","");
			htRecord.put("order_line_num","");
			htRecord.put("order_type_code","");
			htRecord.put("order_catalog_code","");
			htRecord.put("order_catalog_desc","");
			}
			htRecord.put("referral_id",  rs.getString("referral_id")==null?"":rs.getString("referral_id"));
            htRecord.put("patient_id", rs.getString("patient_id")==null?"":rs.getString("patient_id"));  
            htRecord.put("clinic_code", rs.getString("clinic_code")==null?"":rs.getString("clinic_code"));
            htRecord.put("appt_ref_no", rs.getString("appt_ref_no")==null?"":rs.getString("appt_ref_no"));  
            htRecord.put("service_code", rs.getString("service_code")==null?"":rs.getString("service_code"));  
            htRecord.put("appt_type_code", rs.getString("appt_type_code")==null?"":rs.getString("appt_type_code"));  
            htRecord.put("appt_date",rs.getString("appt_date")==null?"":rs.getString("appt_date"));  
            htRecord.put("from_time", rs.getString("from_time")==null?"":rs.getString("from_time"));  
            htRecord.put("to_time", rs.getString("to_time")==null?"":rs.getString("to_time"));  
			htRecord.put("recur_wo_sec_res", rs.getString("recur_wo_sec_res")==null?"":rs.getString("recur_wo_sec_res")); 
			/*Added below Line for this CRF [RUT-CRF-0011]*/
			htRecord.put("patient_cat_code", rs.getString("patient_cat_code")==null?"":rs.getString("patient_cat_code")); 
            /*End*/
			
			   String resource_desc=(rs.getString("resource_desc")==null?"":rs.getString("resource_desc"));
               if(resource_desc.equals("P")) {
				   resource_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); 
			   } else if(resource_desc.equals("E")) {
				   resource_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels"); 
               } else if(resource_desc.equals("O")) {
				   resource_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
 		       } else if(resource_desc.equals("R")) {
				   resource_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
	 		   }


			
			htRecord.put("resource_desc", resource_desc); 
    		if(((String)htRecord.get("resource_class")).equals("R"))
			 {	 htRecord.put("Room_num",rs.getString("pract_id")==null?"":rs.getString("pract_id"));
			 }
			 else
				{	htRecord.put("Room_num","");
				}
                   htRecord.put("contact_reason_code",rs.getString("CONTACT_REASON_CODE")==null?"":rs.getString("CONTACT_REASON_CODE"));
				    htRecord.put("reason",rs.getString("reason")==null?"":rs.getString("reason"));
			  
			  }
				 apptRecordSet.putObject(htRecord);
				 incr++;
					}
               
	 //rs.previous();
     if (!rs.next())
      {
       endOfRes = "0"; 
	  }
				
				
				}

				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
              //}
           
			int totalRecords = apptRecordSet.getSize();
			
			if(totalRecords == 0 )	
			{		
				%>
				<script>
					if(parent.frames[0].document.forms[0].search != null)
					{
						parent.frames[0].document.forms[0].search.disabled=false;
					}
					var error=getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON')
					alert(error);
					 </script>
					<%
			}
			else
			{
				%>  <%
				if(totalRecords != 0)
				{
				
				%>
					
					<p>
<table align='right'>
<tr>
<td>
<%
	if ( !(start <= 1) ){
	out.println("<A HREF='../jsp/VisitRegistrationQueryResult.jsp?from="+(start-10)+"&to="+(end-10)+"&where_clause="+java.net.URLEncoder.encode(where_clause)+"&Patient="+patient_id+"&oper_stn_id="+oper_stn_id+"&first_name="+first_name+"&second_name="+second_name+"&third_name="+third_name+"&family_name="+family_name+"&name_prefix="+name_prefix+"&sndx_type="+sndx_type+"&nat_id_prompt="+nat_id_prompt+"&nationality_id="+nationality_id+"&NRICNo="+NRICNo+"&otherAlternateIDNo="+otherAlternateIDNo+"&register_visit_walkin"+register_visit_walkin+"&register_visit_referral"+register_visit_referral+"&function_id="+functionId+"&bl_interface_yn="+bl_interface_yn+"&or_install_yn="+or_install_yn+"&alternateIDNo1="+alternateIDNo[0]+"&alternateIDNo2="+alternateIDNo[1]+"&alternateIDNo3="+alternateIDNo[2]+"&alternateIDNo4="+alternateIDNo[3]+"&WaitListNo="+WaitListNo+"&specCode="+specCode+"&oper_stn_id="+oper_stn_id+"&function_id="+functionId+"&r_area="+r_area_code+"&m_area="+m_area_code+"&r_region="+r_region_code+"&m_region="+m_region_code+"&r_town="+r_town_code+"&m_town="+m_town_code+"&category="+category+"&wait_list_priority="+wait_list_priority+"&oa_install_yn="+oa_install_yn+"&waitlist_fromdate="+waitlist_fromdate+"&waitlist_todate="+waitlist_todate+"&bl_interface_yn="+bl_interface_yn+"&oper_stn_id="+oper_stn_id+"&register_visit_walkin="+register_visit_walkin+"&register_visit_referral="+register_visit_referral+"&or_install_yn="+or_install_yn+"&oa_install_yn="+oa_install_yn+"&build_episode_rule="+build_episode_rule+"&register_visit_referral="+register_visit_referral+"&clinic_type="+clinic_type+"&register_visit_walkin="+register_visit_walkin+"&accept_dis_inv_no="+accept_dis_inv_no+"&wait_list_inv="+wait_list_inv+"&isPractoApptApplYN="+isPractoApptApplYN+"&virtualConsultVisit="+virtualConsultVisit+"&isVirtualConsultationVisit="+isVirtualConsultationVisit+"&extApptOnly="+extApptOnly+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

					}

if (endOfRes.equals("1"))
			{ 
out.println("<A HREF='../jsp/VisitRegistrationQueryResult.jsp?from="+(start+10)+"&to="+(end+10)+"&where_clause="+java.net.URLEncoder.encode(where_clause)+"&Patient="+patient_id+"&oper_stn_id="+oper_stn_id+"&first_name="+first_name+"&second_name="+second_name+"&third_name="+third_name+"&family_name="+family_name+"&name_prefix="+name_prefix+"&sndx_type="+sndx_type+"&nat_id_prompt="+nat_id_prompt+"&nationality_id="+nationality_id+"&NRICNo="+NRICNo+"&otherAlternateIDNo="+otherAlternateIDNo+"&register_visit_walkin"+register_visit_walkin+"&register_visit_referral"+register_visit_referral+"&function_id="+functionId+"&bl_interface_yn="+bl_interface_yn+"&or_install_yn="+or_install_yn+"&alternateIDNo1="+alternateIDNo[0]+"&alternateIDNo2="+alternateIDNo[1]+"&alternateIDNo3="+alternateIDNo[2]+"&alternateIDNo4="+alternateIDNo[3]+"&WaitListNo="+WaitListNo+"&specCode="+specCode+"&oper_stn_id="+oper_stn_id+"&function_id="+functionId+"&r_area="+r_area_code+"&m_area="+m_area_code+"&r_region="+r_region_code+"&m_region="+m_region_code+"&r_town="+r_town_code+"&m_town="+m_town_code+"&category="+category+"&wait_list_priority="+wait_list_priority+"&oa_install_yn="+oa_install_yn+"&wait_list_inv="+wait_list_inv+"&waitlist_fromdate="+waitlist_fromdate+"&waitlist_todate="+waitlist_todate+"&bl_interface_yn="+bl_interface_yn+"&oper_stn_id="+oper_stn_id+"&register_visit_walkin="+register_visit_walkin+"&register_visit_referral="+register_visit_referral+"&clinic_type="+clinic_type+"&or_install_yn="+or_install_yn+"&oa_install_yn="+oa_install_yn+"&accept_dis_inv_no="+accept_dis_inv_no+"&build_episode_rule="+build_episode_rule+"&isPractoApptApplYN="+isPractoApptApplYN+"&virtualConsultVisit="+virtualConsultVisit+"&isVirtualConsultationVisit="+isVirtualConsultationVisit+"&extApptOnly="+extApptOnly+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			}
%>
</td>
</tr>
</table>
</p>
	<BR><BR>
				
			<table border="1" cellspacing='0' cellpadding='0' width='100%' id='th_table'>
			 <%if(wait_list_inv.equals("Y")){%>
			<th class='columnheader' nowrap width='5%'><div  id='head1' class='myClass'><fmt:message key="Common.waitlistno.label" bundle="${common_labels}"/></div></th>
				<% 
					if( accept_dis_inv_no.equals("D") )
					{
				%>
						<th class='columnheader' nowrap width='5%'><div  id='head3' class='myClass'><fmt:message key="Common.invitationno.label" bundle="${common_labels}"/></div></th>
				<%	
					}
				%>
				<th class='columnheader' nowrap width='5%'><div  id='head2' class='myClass'><fmt:message key="eOA.InvitationDate.label" bundle="${oa_labels}"/></div></th>				
				<th class='columnheader' nowrap width='10%'><div  id='head3' class='myClass'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></div></th>
				<th class='columnheader' nowrap width='7%'><div  id='head4' class='myClass'><fmt:message key="eOA.WaitlistCategory.label" bundle="${oa_labels}"/></div></th>
				<th class='columnheader' nowrap width='10%'><div  id='head5' class='myClass'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></div></th>
				<th class='columnheader' width='15%'><div  id='head6' class='myClass'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></div></th>
				<th class='columnheader' nowrap width='5%'><div  id='head7' class='myClass'><fmt:message key="Common.age.label" bundle="${common_labels}"/></div></th>
				<th class='columnheader' nowrap width='5%'><div  id='head8' class='myClass'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></div></th>
				<th class='columnheader' nowrap width='5%'><div  id='head11' class='myClass'><fmt:message key="Common.ContactDetails.label" bundle="${common_labels}"/></div></th>
				<th class='columnheader' nowrap width='15%'><div  id='head9' class='myClass'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></div></th>
				<th class='columnheader' nowrap width='10%'><div  id='head10' class='myClass'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></div></th>
			   <%}else{%>
					<th class='columnheader'width='1%' nowrap><div  id='head1' class='myClass'>&nbsp;</div></th>
					<th class='columnheader' width='5%' nowrap><div  id='head2' class='myClass'><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></div></th>
					<th class='columnheader' width='5%' nowrap><div  id='head3' class='myClass'><fmt:message key="Common.time.label" bundle="${common_labels}"/></div></th>
					<th class='columnheader' width='13%' nowrap><div  id='head4' class='myClass'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></div></th>
					<th class='columnheader' width='10%' nowrap><div  id='head5' class='myClass'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></div></th>
					<th class='columnheader' width='12%' nowrap><div  id='head6' class='myClass'><%=nat_id_prompt%></div></TD>
					<th class='columnheader' width='10%' nowrap><div  id='head7' class='myClass'><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></div></th>        
					<th class='columnheader' width='10%' nowrap><div  id='head11' class='myClass'><fmt:message key="Common.ContactDetails.label" bundle="${common_labels}"/></div></th>        
					<th class='columnheader' width='13%' nowrap><div  id='head8' class='myClass'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></div></th>
					
					<th class='columnheader' width='17%' nowrap><div  id='head9' class='myClass'><fmt:message key="Common.resource.label" bundle="${common_labels}"/></div></th>
				   	<th class='columnheader' width='14%' nowrap><div  id='head10' class='myClass'><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></div></th>
					<!--Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] Start-->
					<%if(isPractoApptApplYN.equals("true")){%>
				   		<th class='columnheader' width='14%' nowrap><div  id='head10' class='myClass'><fmt:message key="eOA.AppointmentSource.label" bundle="${oa_labels}"/></div></th>
					<%}%>
					<!--Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] End-->
					<%if(isVirtualConsultationVisit.equals("true")) { // ML-MMOH-CRF-1930 Lakshmanan %>
					<th class='columnheader' width='14%' nowrap><div  id='head12' class='myClass'><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></div></th>
				<%} 
					}
				}
				for(int i=lower_limit; i <totalRecords; i++){
				
				%>
				<%
                 
				 htRecord                =       (java.util.HashMap)   apptRecordSet.getObject(i);
				 
                  if(classValue.equals("QRYEVEN")) classValue = "QRYODD" ;
                  else    classValue = "QRYEVEN" ;
                   
			 if(wait_list_inv.equals("Y")) 		
			  {	 
                  if(htRecord.get("locn_type").equals("C"))  { 
			         locn_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); 
        				 } else if(htRecord.get("locn_type").equals("E")) { 
				    locn_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
					} 
					
				%>
			  <!-- order_catalog_code added by S.Sathish for PMG20089-CRF-0850 on Friday, July 02, 2010 -->
			   <tr>
					<td class= '<%=classValue%>' align='left' width='5%' nowrap><a href="javascript:image_click('wait','<%=oa_install_yn%>','<%=htRecord.get("patient_id")%>','<%=htRecord.get("invitation_no")%>','<%=htRecord.get("clinic_code")%>','<%=wait_list_inv%>','<%=htRecord.get("clinic_code")%>','<%=htRecord.get("locn_type")%>','<%=htRecord.get("wait_list_status")%>','<%=htRecord.get("SPECIALTY_CODE")%>','<%=accept_dis_inv_no%>','<%=htRecord.get("PRACTITIONER_ID")%>','<%=htRecord.get("practitioner_name")%>','<%=htRecord.get("order_catalog_code")%>','<%=htRecord.get("multi_speciality_yn")%>');"> <%=htRecord.get("wait_list_no")%></a></td>
					<% 
				   	if( accept_dis_inv_no.equals("D") )
					{
						%>
						<td  align='left' class= '<%=classValue%>' width='5%' nowrap><font size=1><%=htRecord.get("invitation_no")%></td>
					<%	
					}
					%>
					
					<%	
					if(!htRecord.get("invited_date_time").equals("")){
						%>
					<td  align='left' class= '<%=classValue%>' width='5%' nowrap><font size=1><%=htRecord.get("invited_date_time")%></td>
					<% } else{ %>
					
					<td  align='left' class= '<%=classValue%>' width='5%' nowrap><font size=1>&nbsp;</td><%}%>
					<%	
					if(!htRecord.get("SPECIALITY_DESC").equals("")){
					%>
					<td  align='left' class= '<%=classValue%>' width='10%' nowrap><font size=1><%=htRecord.get("SPECIALITY_DESC")%></td>
					<%} else{%>
					<td  align='left' class= '<%=classValue%>' width='10%' nowrap><font size=1>&nbsp;</td><%}%>
					<%	
					if(!htRecord.get("category_desc").equals("")){
					%>
					<td  align='left' class= '<%=classValue%>' width='7%' nowrap><font size=1><%=htRecord.get("category_desc")%></td>
					<%} else{%>
					<td  align='left' class= '<%=classValue%>' width='10%' nowrap><font size=1>&nbsp;</td><%}%>
					<%	
					if(!htRecord.get("patient_id").equals("")){
					%>
					<td  align='left' class= '<%=classValue%>' width='10%' nowrap><font size=1><%=htRecord.get("patient_id")%></td>
					<%} else{%>
					<td  align='left' class= '<%=classValue%>' width='10%' nowrap><font size=1>&nbsp;</td><%}%>
					<%	
					if(!htRecord.get("patient_name").equals("")){
					%>
					<td  align='left' class= '<%=classValue%>' width='15%'><font size=1>
					<%
					if(isVIPimgpatfrontappl) // added by mujafar for ML-MMOH-CRF-1070
					{	String pat_id = (String)htRecord.get("patient_id");
						String vip_pat_yn = eOA.OACommonBean.getVIPPatient(con,pat_id,Facility_Id);
						if(vip_pat_yn.equals("TRUE"))
						{
					%>
					<img border=0 src='../../eCommon/images/PI_VIP.gif'></img>
					<%}}%>
					<%=htRecord.get("patient_name")%></td>
					<%} else{%>
					<td  align='left' class= '<%=classValue%>' width='15%' nowrap><font size=1>&nbsp;</td><%}%>
					<%	
					if(!htRecord.get("age").equals("")){
					%>
					<td  align='left' class= '<%=classValue%>' width='5%' nowrap><font size=1><%=htRecord.get("age")%></td>
				   <%} else{%>
					<td  align='left' class= '<%=classValue%>' width='15%' nowrap><font size=1>&nbsp;</td><%}%>
					<%	
					if(!htRecord.get("GENDER").equals("")){
					%>
					<td  align='left' class= '<%=classValue%>' width='5%' nowrap><font size=1><%=(String)htRecord.get("GENDER")%></td>
				   <%} else{%>
					<td  align='left' class= '<%=classValue%>' width='5%' nowrap><font size=1>&nbsp;</td><%}%>
					<%	
					if(!htRecord.get("locn_type").equals("")){
					%>
					<td  align='left' class= '<%=classValue%>' width='15%' nowrap><font size=1><%=locn_type_desc%>&nbsp;/&nbsp;<%=htRecord.get("CLINIC_SHORT_DESC")%></td> 
				   <%} else{%>
					<td  align='left' class= '<%=classValue%>' width='15%' nowrap><font size=1>&nbsp;</td><%}%>
					<%	
					if(!htRecord.get("priority").equals("")){
					
					%>
					<td  align='left' class= '<%=classValue%>' width='10%' nowrap><font size=1><%=htRecord.get("priority")%></a></td> 	
			         
					<%} 
					else{%>
					<td  align='left' class= '<%=classValue%>' width='10%' nowrap><font size=1>&nbsp;</td><%}%>
			  
			  
			 <%}else{

				     if(htRecord.get("locn_type").equals("C"))  { 
			            locn_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); 
        			 } else if(htRecord.get("locn_type").equals("E")) {                                                				                     locn_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
					} 
			
				   %>
				  
				   
				   
				   <tr>
					<td class= '<%=classValue%>' align='left' width='1%' nowrap><a href="javascript:view_appt_dtl('<%=(String)htRecord.get("appt_ref_no")%>','<%=(String)htRecord.get("appt_date")%>','<%=(String)htRecord.get("clinic_code")%>','<%=(String)htRecord.get("Pract_id")%>','<%=(String)htRecord.get("from_time")%>','<%=(String)htRecord.get("to_time")%>', '<%=(String)htRecord.get("resource_class")%>','<%=(String)htRecord.get("locn_type")%>')">+</a>
					</td>
				<%      
					String referral_id=(String)htRecord.get("referral_id")==null?"":(String)htRecord.get("referral_id") ;
					String appt_ref_no=(String)htRecord.get("appt_ref_no");					
					%>

						<input  type='hidden'  name=reason_<%=i%> id=reason_<%=i%> value="<%=htRecord.get("reason")%>">
						<input  type='hidden'  name=pract_<%=i%> id=pract_<%=i%> value="<%=htRecord.get("Rpractitioner_name")%>">
						
						<td align='left' class= '<%=classValue%>' width='5%' nowrap><a href='javascript:tab_click_add_visit("<%=(String)htRecord.get("patient_id")%>","<%=(String)htRecord.get("clinic_code")%>","<%=(String)htRecord.get("Pract_id")%>","<%=appt_ref_no%>","<%=(String)htRecord.get("q_appt_time")%>","<%=(String)htRecord.get("appt_type_code")%>","<%=referral_id%>","","<%=(String)htRecord.get("resource_class")%>","<%=(String)htRecord.get("ordering_facility_id")%>","<%=(String)htRecord.get("order_id")%>","<%=(String)htRecord.get("order_line_num")%>","<%=(String)htRecord.get("order_type_code")%>","<%=(String)htRecord.get("order_catalog_code")%>","<%=(String)htRecord.get("order_catalog_desc")%>","<%=(String)htRecord.get("Room_num")%>","","<%=(String)htRecord.get("recur_wo_sec_res")%>","<%=appt_ref_no%>","<%=htRecord.get("contact_reason_code")%>","<%=i%>","<%=htRecord.get("locn_type")%>","<%=functionId%>","<%=htRecord.get("service_code")%>","","<%=accept_dis_inv_no%>","<%=htRecord.get("multi_speciality_yn")%>","<%=htRecord.get("isPractoApptYn")%>","<%=htRecord.get("virtualConsultEnable")%>")'>    
							<%

					String anch = "<a href = \"javascript:showRefDtls('"+referral_id+"')\">" ;
					
					if(practname.equals("")) practname = "&nbsp;";

					if(referral_id.equals(""))
						anch = "&nbsp;" ;
					else
						anch = anch+referral_id;

					%>
				   
					<font size='1'><%=htRecord.get("appt_ref_no")%></a></td>
					<td  align='left' class= '<%=classValue%>' width='5%' nowrap><font size=1><%=htRecord.get("q_appt_time")%></td>					
					
					<%	
					
				  /*Below Line Added for this CRF [RUT-CRF-0011]*/
					
					String patcategory="";
					String patientcatcode=checkForNull((String)htRecord.get("patient_cat_code"));				
					if(!patientcatcode.equals("")){
					String patcatquery="select govt_or_pvt_ind from MP_PAT_CATEGORY where PAT_CAT_CODE='"+patientcatcode+"'";
					pstmt1   = con.prepareStatement(patcatquery);				
                    rs1 = pstmt1.executeQuery();
					if(rs1.next())
					patcategory=rs1.getString(1);
					}
				   if (rs1 != null)   rs1.close();
				   if (pstmt1 != null) pstmt1.close();
				  // if(con1!=null)con1.close();
                  //End  CRF [RUT-CRF-0011] 					
					
					if(!htRecord.get("patient_name").equals("")){
					%>
					<td  align='left' class= '<%=classValue%>' width='13%' nowrap><font size=1><%if(isVIPimgpatfrontappl){if(checkForNull(patcategory).equals("V")){%><img border=0 src='../../eCommon/images/PI_VIP.gif'></img><%}}%><%=htRecord.get("patient_name")%>
					<%if(!isVIPimgpatfrontappl){if(checkForNull(patcategory).equals("V")){%><img border=0 src='../../eCommon/images/PI_VIP.gif'></img><%}}%></td>
					<%} else{%>
					<td  align='left' class= '<%=classValue%>' width='13%' nowrap><font size=1>&nbsp;</td><%}%>
					<%	
					if(!htRecord.get("q_patient_id").equals("")){
					%>
					<td  align='left' class= '<%=classValue%>' width='10%' nowrap><font size=1><%=htRecord.get("q_patient_id")%></td>
					<%} else{%>
					<td  align='left' class= '<%=classValue%>' width='10%' nowrap><font size=1>&nbsp;</td><%}%>
					<%	
					if(!htRecord.get("national_id_no").equals("")){
					%>
					<td  align='left' class= '<%=classValue%>' width='12%' nowrap><font size=1><%=htRecord.get("national_id_no")%></td>
					<%} else{%>
					<td  align='left' class= '<%=classValue%>' width='12%' nowrap><font size=1>&nbsp;</td><%}%>
					<%	
					if(!htRecord.get("nationality").equals("")){
					%>
					<td  align='left' class= '<%=classValue%>' width='10%' nowrap><font size=1><%=htRecord.get("nationality")==""?"&nbsp;":htRecord.get("nationality")%></td>
					<%} else{%>
					<td  align='left' class= '<%=classValue%>' width='10%' nowrap><font size=1>&nbsp;</td><%}%>
					<%	
					if(!htRecord.get("oth_contact_no").equals("")){
					%>
					<td  align='left' class= '<%=classValue%>' width='10%' nowrap><font size=1><%=htRecord.get("oth_contact_no")==""?"&nbsp;":htRecord.get("oth_contact_no")%></td>
					<%} else{%>
					<td  align='left' class= '<%=classValue%>' width='10%' nowrap><font size=1>&nbsp;</td><%}%>
					<%	
					if(!htRecord.get("locn_type").equals("")){
					%>
										
					<td  align='left' class= '<%=classValue%>' width='15%' nowrap><font size=1><%=locn_type_desc%>&nbsp;/&nbsp;<%=htRecord.get("clinic_desc")%></td>
				 <%} else{%>
					<td  align='left' class= '<%=classValue%>' width='15%' nowrap><font size=1>&nbsp;</td><%}%>
				
				
				
				 			 
				 <%	
					if(!htRecord.get("resource_desc").equals("")){ 
					%>
					<!-- this condition was added by venkatesh.s on 15/Nov/2012 agaings CRF SS-CRF-0010 [IN034516] FD 3.0 version -->
					<%if(htRecord.get("resource_desc").equals("Room")){%>
					  <td  align='left' class= '<%=classValue%>' width='17%' nowrap><font size=1><%=htRecord.get("resource_desc")%>&nbsp;/&nbsp;<%=(String)htRecord.get("Rpractitioner_name")%>&nbsp;<%=(String)htRecord.get("room_desc")%></td>
					<%}else{%>
				 <td  align='left' class= '<%=classValue%>' width='17%' nowrap><font size=1><%=htRecord.get("resource_desc")%>&nbsp;/&nbsp;<%=(String)htRecord.get("Rpractitioner_name")%></td>
				    <%}%>
				   <%} else{%>
					<td  align='left' class= '<%=classValue%>' width='17%' nowrap><font size=1>&nbsp;</td><%}
					
					if(!anch.equals("")){%>				
							
					<td  align='left' class= '<%=classValue%>' width='14%' nowrap><font size=1><%=anch%></a></td> 
					<%}else{%>
					<td  align='left' class= '<%=classValue%>' width='14%' nowrap><font size=1>&nbsp;</td>							
							
					<%}%>


					<!--Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] Start-->
					<!--Modified by Ashwini on 01-Dec-2021 for ML-BRU-CRF-0628.6-->
					<%if(isPractoApptApplYN.equals("true") && isSlotStartMidEndAppl){%>
						<td  align='left' class= '<%=classValue%>' width='14%' nowrap><font size=1><%if(htRecord.get("isPractoApptYn").equals("Y")){%><fmt:message key="eOA.BruHealth.label" bundle="${oa_labels}"/><%}else{%><fmt:message key="Common.EM.label" bundle="${common_labels}"/><%}%>&nbsp;</td>
				  	<%}else if(isPractoApptApplYN.equals("true") && !isSlotStartMidEndAppl){%>
						<td  align='left' class= '<%=classValue%>' width='14%' nowrap><font size=1><%if(htRecord.get("isPractoApptYn").equals("Y")){%><fmt:message key="eOA.Practo.label" bundle="${oa_labels}"/><%}else{%><fmt:message key="Common.EM.label" bundle="${common_labels}"/><%}%>&nbsp;</td>
				  	<%}
					/*Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] End*/
					 if (isVirtualConsultationVisit.equals("true")) {  // added for ML-MMOH-CRF-1930
					%><td  align='left' class= '<%=classValue%>' width='14%' nowrap> <%=htRecord.get("visitTypeShortDesc") %> </td><%
					}
					}
				} %>
					 	
				</tr>
			</table>
			       
          <% htRecord.clear();}
			   
			}
		
            catch(Exception e) { out.println("Exception in res="+e.toString());e.printStackTrace();}
            finally 
            {
                try{
				if (rs != null)   rs.close();
				if (pstmt != null) pstmt.close();
                if (rs1 != null)   rs1.close();
				if (pstmt1 != null) pstmt1.close();
				sql1.setLength(0);
				}catch(Exception e){}

                if( con != null) ConnectionManager.returnConnection(con,request);            
			
			}
%>
    <input type='hidden' name='current_patient_id' id='current_patient_id' value=''>
    <input type='hidden' name='function_id' id='function_id' value='<%=functionId%>'>
	<input type='hidden' name='bl_interface_yn' id='bl_interface_yn' value='<%=bl_interface_yn%>'>
	
	<input type='hidden' name='facility_id' id='facility_id' value='<%=Facility_Id%>'>
	<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'>
	<input type='hidden' name='register_visit_walkin' id='register_visit_walkin' value='<%=register_visit_walkin%>'>
	<input type='hidden' name='register_visit_referral' id='register_visit_referral' value='<%=register_visit_referral%>'>
	<input type='hidden' name='or_install_yn' id='or_install_yn' value='<%=or_install_yn%>'>
	<input type='hidden' name='patientFlag' id='patientFlag' value='N'>
	<input type='hidden' name='build_episode_rule' id='build_episode_rule' value='<%=build_episode_rule%>'>
	<input type='hidden' name='oa_install_yn' id='oa_install_yn' value='<%=oa_install_yn%>'>
	<input type='hidden' name='emer_regn_allow_yn' id='emer_regn_allow_yn' value='<%=emer_regn_allow_yn%>'>
	<!--below line upt_contact_dtls_oa_yn field added by venkatesh.S on 26-11-2014 against HSA-CRF-0226 [IN:050599] -->
	<input type='hidden' name='upt_contact_dtls_oa_yn' id='upt_contact_dtls_oa_yn' value='<%=upt_contact_dtls_oa_yn%>'>
	<input type='hidden' name='isUHID_valid_appl' id='isUHID_valid_appl' value='<%=isUHID_valid_appl%>'> <!-- added by mujafar for AMRI-CRF-0357 -->
	

    </form>
<script>
	
		if(parent.frames[1].document.forms[0].search != null)
		{
			parent.frames[1].document.forms[0].search.disabled=false;
		}
	
</script>
<%/*Below Line Added for this CRF [RUT-CRF-0011]*/%>
<%!

public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}%>
</body>
</html>

