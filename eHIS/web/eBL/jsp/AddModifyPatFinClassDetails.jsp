<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src='../js/AddModifyPatFinDetails.js'></script> 
<script language="javascript" src='../js/AddModifyPatFinClassDetails.js'></script> 
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<% 
	Connection con = ConnectionManager.getConnection();	
	try
	{
		PreparedStatement pstmt = null;
		Statement stmt				= null;
		ResultSet rs = null;

		HttpSession httpSession = request.getSession(false);
		String locale			= (String)session.getAttribute("LOCALE");
		String delimiter="::";
		String prevPatId="";
		String classTypChangeAuthYN="";
		String changePatAuthYN="";
		
		String classTypChangeAuthYnPatId			= (String)session.getAttribute("classTypChangeAuthYnPatId");
		changePatAuthYN			= (String)session.getAttribute("changePatAuthYN");
		System.err.println("classTypChangeAuthYnPatId "+classTypChangeAuthYnPatId);
		//System.err.println(" bef loop prevPatId "+prevPatId);
		// System.err.println("bef loop classTypChangeAuthYN :: "+classTypChangeAuthYN);
		String sessionClinicCode = (String)session.getAttribute("str_clinic_code");
		if(sessionClinicCode == null) sessionClinicCode="";
		String reqClinicCode = request.getParameter("clinic_code");	
		if(reqClinicCode == null) reqClinicCode="";
		
		System.err.println(" sessionClinicCode:: "+sessionClinicCode+" reqClinicCode :: "+reqClinicCode);
		 
		if(classTypChangeAuthYnPatId != null){
			
			System.err.println("In loop classTypChangeAuthYnPatId "+classTypChangeAuthYnPatId);
			 String[] classTypChangeTokens=classTypChangeAuthYnPatId.split(delimiter);
			 //System.out.println("classTypChangeTokens "+classTypChangeTokens);
			 prevPatId=classTypChangeTokens[0];
			 System.err.println("prevPatId "+prevPatId);
			 classTypChangeAuthYN=classTypChangeTokens[1];
			 System.err.println("classTypChangeAuthYN :: "+classTypChangeAuthYN);
		}
		
		 System.err.println("prevPatId "+prevPatId+"/ classTypChangeAuthYN :: "+classTypChangeAuthYN);

		System.err.println("AddModifyPatFinClassDtls.jsp classTypChangeAuthYN :: "+classTypChangeAuthYN+"/ prevPatId :: "+prevPatId+" /classTypChangeAuthYN :: "+classTypChangeAuthYN);

		String slmt_ind = "", cash_patient_YN="", class_type = "", class_code = "", class_desc = "", remarks = "", social_pensioner_id = "";
		String inc_asset_ind = "", ind_inc = "", ind_inc_freq = "", spouse_inc = "", spouse_inc_freq = "", dependent_inc = "";
		String dependent_inc_freq = "", tot_inc_asset = "", no_of_dependants = "", blng_grp_id = "", blng_grp_desc = "";
		String valid_from = "", valid_to = "", last_date = "", age = "", childMinAge = "";
		int max_days_for_prov_class = 0;
		String valid_to_for_prov_class="";
		String ipBlGrp = "",ipblng_grp_desc="";
		String incld_dep_inc_yn = "Y";
		String sql = "";
		String sysDate = "";
		String strEpisodeType = "", upd_class_dtls_YN="N", blng_grp_changed_YN="N", fin_class_dtls_updated_YN="N";
		int assessmentMonths = 0, noofdecimal=2;
		String encounter_date_time = "", encounter_date_aft_trunc="", sys_date_wht_sec="";
		String fam_mem_incl_YN="N", class_code_valid_YN="N";
		boolean boolPatientFoundMP = false;
		boolean boolSecurity = false;	
		String classStartDate="",classEndDate="",blGrpIdMPI="";
		String blng_grp_id_temp="";
		
		String strAllParam	= request.getQueryString();

		String strModuleId =  request.getParameter("calling_module_id") ==null ? "" : request.getParameter("calling_module_id");	

		String functionId =  request.getParameter("calling_function_id") == null? "" :request.getParameter("calling_function_id");

		String facilityId =  (String)httpSession.getValue("facility_id");
		if(facilityId == null) facilityId="";

		String billing_mode =  request.getParameter("billing_mode") == null? "" :request.getParameter("billing_mode");
		String operation =  request.getParameter("operation") == null? "" :request.getParameter("operation");

		String sex = request.getParameter("sex") == null? "" :request.getParameter("sex");

//		String clinicCode = request.getParameter("clinic_code") == null? "" :request.getParameter("clinic_code");

		String patientId = request.getParameter("patient_id") == null? "" :request.getParameter("patient_id");

		String fin_dtl_call = request.getParameter("fin_dtl_call") == null? "N" :request.getParameter("fin_dtl_call");

		upd_class_dtls_YN = request.getParameter("upd_class_dtls_YN") == null? "N" :request.getParameter("upd_class_dtls_YN");
/*
		try
		{
			String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI'),to_char(sysdate,'dd/mm/yyyy') from dual";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query_date) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					sys_date_wht_sec = rs.getString(1);
					sysDate = rs.getString(2); 
				}
			}
			if(rs !=null) rs.close();
			stmt.close();
		}
		catch(Exception e)
		{
			out.println("Exception @ sys_date_wht_sec"+e);
		}
		
		
*/
		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2),to_char(sysdate,'dd/mm/yyyy HH24:MI'),to_char(sysdate,'dd/mm/yyyy') from  sm_acc_entity_param where acc_entity_id='ZZ'");
			ResultSet rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);
				sys_date_wht_sec = rscurr.getString(2);
				sysDate = rscurr.getString(3);
			}	
			if(rscurr!=null) rscurr.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in No of Decimal Query="+e.toString());
		}

		if (strModuleId.equals("OP")) 
		{
			strEpisodeType = "O";
		}
		else if (strModuleId.equals("AE")) 
		{
			strEpisodeType = "E";
		}
		else if (strModuleId.equals("IP")) 
		{
			strEpisodeType = "I";
		}
		else if (strModuleId.equals("DC")) 
		{
			strEpisodeType = "D";
		}
		else if(strModuleId.equals("MP"))
		{
			strEpisodeType = "R";
		}

		encounter_date_time = request.getParameter("encounter_date_time");
		if(encounter_date_time == null) encounter_date_time="";

		if(encounter_date_time.equals(""))
			encounter_date_time = sys_date_wht_sec;

		try
		{
			String sql_trunc_time="select to_char( (to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') from dual";

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql_trunc_time) ;

			if( rs!= null ) 
			{
				while( rs.next() )
				{  
					encounter_date_aft_trunc = rs.getString(1);
				}
			}
			if (rs != null)   rs.close();
			stmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception while executing sql_trunc_time :"+e);
		}


//		if((!strModuleId.equals("IP") || billing_mode.equals("Add")) && (!functionId.equals("CHG_PAT_DTLS")))
		if(fin_dtl_call.equals("Y"))
		{
			slmt_ind = request.getParameter("slmt_ind") == null? "" :request.getParameter("slmt_ind");

			class_type = request.getParameter("class_type") == null? "" :request.getParameter("class_type");
			
			class_code = request.getParameter("class_code") == null? "" :request.getParameter("class_code");
			
			remarks = request.getParameter("remarks") == null? "" :request.getParameter("remarks");
			
			social_pensioner_id = request.getParameter("social_pensioner_id") == null? "" : request.getParameter("social_pensioner_id");
			
			inc_asset_ind = request.getParameter("inc_asset_ind") == null? "" : request.getParameter("inc_asset_ind");
			
			ind_inc = request.getParameter("ind_inc") == null? "0" :request.getParameter("ind_inc");
			
			ind_inc_freq = request.getParameter("ind_inc_freq") == null? "" :request.getParameter("ind_inc_freq");
			
			spouse_inc = request.getParameter("spouse_inc") == null? "0" :request.getParameter("spouse_inc");
			
			spouse_inc_freq = request.getParameter("spouse_inc_freq") == null? "" :request.getParameter("spouse_inc_freq");
			
			dependent_inc = request.getParameter("dependent_inc") == null? "0" :request.getParameter("dependent_inc");
			
			dependent_inc_freq = request.getParameter("dependent_inc_freq") == null? "" :request.getParameter("dependent_inc_freq");
			
			tot_inc_asset = request.getParameter("tot_inc_asset") == null? "" :request.getParameter("tot_inc_asset");
			
			no_of_dependants = request.getParameter("no_of_dependants") == null? "" :request.getParameter("no_of_dependants");
			
			blng_grp_id = request.getParameter("blng_grp_id") == null? "" :request.getParameter("blng_grp_id");

			valid_from = request.getParameter("valid_from") == null? "" :request.getParameter("valid_from");
			
			valid_to = request.getParameter("valid_to") == null? "" :request.getParameter("valid_to");
			
			last_date = request.getParameter("last_date")== null ? "" : request.getParameter("last_date");
		}
		System.err.println("initial :: class_type / inc_asset_ind / ind_inc / ind_inc_freq / blng_grp_id"+class_type+"/"+inc_asset_ind+"/"+ind_inc+"/"+ind_inc_freq+"/"+blng_grp_id+" fin_dtl_call::: "+fin_dtl_call);
	
		Boolean siteSpec=false;
		Boolean Site_spec=false;
		try
		{
			
			siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DISP_FIN_CLASS_DTLS_BLANK");
	
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception in site specific "+e);
		}
		
		
		String SiteSpecific ="";
			try
			{
				con = ConnectionManager.getConnection();	
				Site_spec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DISABLE_FIN_DETAILS_IN_MP");				
			}catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Exception in site specific "+e);
			}
			if(Site_spec){
				SiteSpecific="Y";
			}
			else{
				SiteSpecific="N";
			}

String finDetClose="";
//		if((functionId.equals("CHG_PAT_DTLS") || functionId.equals("PAT_REG")) && (billing_mode.equals("Modify")))
		if((billing_mode.equals("Modify") || operation.equals("Update")) && fin_dtl_call.equals("N"))
		{
			HashMap bl_data=(HashMap)session.getAttribute("financial_details");

			if(!(bl_data==null || bl_data.isEmpty()))
			{
				finDetClose = ((String)bl_data.get("fin_det_close")).trim();
				if(finDetClose == null) finDetClose="";
				
				System.out.println("finDetClose BEF:::"+finDetClose);
				if(siteSpec)
				{
				if(strModuleId.equals("IP") || strModuleId.equals("DC")) {
					 
					if(finDetClose.equals("Y")){		
							
						 	System.out.println("finDetClose :::"+finDetClose);
							blng_grp_id=((String)bl_data.get("blng_grp")).trim();
							if(blng_grp_id == null) blng_grp_id="";
							slmt_ind=((String)bl_data.get("slmt_ind")).trim();
							if(slmt_ind == null) slmt_ind="";
							class_type=((String)bl_data.get("class_type")).trim();
							if(class_type == null) class_type="";
							class_code=((String)bl_data.get("class_code")).trim();
							if(class_code == null) class_code="";
							remarks=((String)bl_data.get("fin_remarks")).trim();
							if(remarks == null) remarks="";
							inc_asset_ind=((String)bl_data.get("inc_asset_ind")).trim();
							if(inc_asset_ind == null) inc_asset_ind="";
							ind_inc=((String)bl_data.get("ind_inc")).trim();
							if(ind_inc == null) ind_inc="0";
							ind_inc_freq=((String)bl_data.get("ind_inc_freq")).trim();
							if(ind_inc_freq == null) ind_inc_freq="";
							spouse_inc=((String)bl_data.get("spouse_inc")).trim();
							if(spouse_inc == null) spouse_inc="0";
							spouse_inc_freq=((String)bl_data.get("spouse_inc_freq")).trim();
							if(spouse_inc_freq == null) spouse_inc_freq="";
							dependent_inc=((String)bl_data.get("dependent_inc")).trim();
							if(dependent_inc == null) dependent_inc="0";
							dependent_inc_freq=((String)bl_data.get("dependent_inc_freq")).trim();
							if(dependent_inc_freq == null) dependent_inc_freq="";
							no_of_dependants=((String)bl_data.get("no_of_dependants")).trim();
							if(no_of_dependants == null) no_of_dependants="";
							valid_from=((String)bl_data.get("valid_from")).trim();
							if(valid_from == null) valid_from="";							
							valid_to=((String)bl_data.get("valid_to")).trim();
							if(valid_to == null) valid_to="";
							last_date=((String)bl_data.get("last_date")).trim();
							if(last_date == null) last_date="";

							if(inc_asset_ind.equals("I"))
							{
								tot_inc_asset = ((String)bl_data.get("annual_income")).trim();
								if(tot_inc_asset == null) tot_inc_asset=""; 
							}
							else if(inc_asset_ind.equals("A"))
							{
								tot_inc_asset = ((String)bl_data.get("family_asset")).trim();
								if(tot_inc_asset == null) tot_inc_asset=""; 
							}
							social_pensioner_id=((String)bl_data.get("social_pensioner_id")).trim();
							if(social_pensioner_id == null) social_pensioner_id="";
						}else{
							valid_from=((String)bl_data.get("valid_from")).trim();
							if(valid_from == null) valid_from="";	

							valid_to=((String)bl_data.get("valid_to")).trim();
							if(valid_to == null) valid_to="";
							
							last_date=((String)bl_data.get("last_date")).trim();
							if(last_date == null) last_date="";
							
							blng_grp_id_temp=((String)bl_data.get("blng_grp")).trim();
							if(blng_grp_id_temp == null) blng_grp_id_temp="";
							
						
						}
	 }else{


			System.out.println("finDetClose :::"+finDetClose);
			blng_grp_id=((String)bl_data.get("blng_grp")).trim();
				if(blng_grp_id == null) blng_grp_id="";
				slmt_ind=((String)bl_data.get("slmt_ind")).trim();
				if(slmt_ind == null) slmt_ind="";
				class_type=((String)bl_data.get("class_type")).trim();
				if(class_type == null) class_type="";
				class_code=((String)bl_data.get("class_code")).trim();
				if(class_code == null) class_code="";
				remarks=((String)bl_data.get("fin_remarks")).trim();
				if(remarks == null) remarks="";
				inc_asset_ind=((String)bl_data.get("inc_asset_ind")).trim();
				if(inc_asset_ind == null) inc_asset_ind="";
				ind_inc=((String)bl_data.get("ind_inc")).trim();
				if(ind_inc == null) ind_inc="0";
				ind_inc_freq=((String)bl_data.get("ind_inc_freq")).trim();
				if(ind_inc_freq == null) ind_inc_freq="";
				spouse_inc=((String)bl_data.get("spouse_inc")).trim();
				if(spouse_inc == null) spouse_inc="0";
				spouse_inc_freq=((String)bl_data.get("spouse_inc_freq")).trim();
				if(spouse_inc_freq == null) spouse_inc_freq="";
				dependent_inc=((String)bl_data.get("dependent_inc")).trim();
				if(dependent_inc == null) dependent_inc="0";
				dependent_inc_freq=((String)bl_data.get("dependent_inc_freq")).trim();
				if(dependent_inc_freq == null) dependent_inc_freq="";
				no_of_dependants=((String)bl_data.get("no_of_dependants")).trim();
				if(no_of_dependants == null) no_of_dependants="";
				valid_from=((String)bl_data.get("valid_from")).trim();
				if(valid_from == null) valid_from="";	
				/*	if(strModuleId.equals("MP"))
				{
				valid_from=encounter_date_aft_trunc;
					if(valid_from == null) valid_from="";
				}*/


				valid_to=((String)bl_data.get("valid_to")).trim();
				if(valid_to == null) valid_to="";
				last_date=((String)bl_data.get("last_date")).trim();
				if(last_date == null) last_date="";

				if(inc_asset_ind.equals("I"))
				{
					tot_inc_asset = ((String)bl_data.get("annual_income")).trim();
					if(tot_inc_asset == null) tot_inc_asset=""; 
				}
				else if(inc_asset_ind.equals("A"))
				{
					tot_inc_asset = ((String)bl_data.get("family_asset")).trim();
					if(tot_inc_asset == null) tot_inc_asset=""; 
				}
				social_pensioner_id=((String)bl_data.get("social_pensioner_id")).trim();
				if(social_pensioner_id == null) social_pensioner_id="";
					
	 }
				
	}
	else{

		System.out.println("finDetClose :::"+finDetClose);
		blng_grp_id=((String)bl_data.get("blng_grp")).trim();
		if(blng_grp_id == null) blng_grp_id="";
		slmt_ind=((String)bl_data.get("slmt_ind")).trim();
		if(slmt_ind == null) slmt_ind="";
		class_type=((String)bl_data.get("class_type")).trim();
		if(class_type == null) class_type="";
		class_code=((String)bl_data.get("class_code")).trim();
		if(class_code == null) class_code="";
		remarks=((String)bl_data.get("fin_remarks")).trim();
		if(remarks == null) remarks="";
		inc_asset_ind=((String)bl_data.get("inc_asset_ind")).trim();
		if(inc_asset_ind == null) inc_asset_ind="";
		ind_inc=((String)bl_data.get("ind_inc")).trim();
		if(ind_inc == null) ind_inc="0";
		ind_inc_freq=((String)bl_data.get("ind_inc_freq")).trim();
		if(ind_inc_freq == null) ind_inc_freq="";
		spouse_inc=((String)bl_data.get("spouse_inc")).trim();
		if(spouse_inc == null) spouse_inc="0";
		spouse_inc_freq=((String)bl_data.get("spouse_inc_freq")).trim();
		if(spouse_inc_freq == null) spouse_inc_freq="";
		dependent_inc=((String)bl_data.get("dependent_inc")).trim();
		if(dependent_inc == null) dependent_inc="0";
		dependent_inc_freq=((String)bl_data.get("dependent_inc_freq")).trim();
		if(dependent_inc_freq == null) dependent_inc_freq="";
		no_of_dependants=((String)bl_data.get("no_of_dependants")).trim();
		if(no_of_dependants == null) no_of_dependants="";
		valid_from=((String)bl_data.get("valid_from")).trim();
		if(valid_from == null) valid_from="";	
		/*	if(strModuleId.equals("MP"))
		{
		valid_from=encounter_date_aft_trunc;
			if(valid_from == null) valid_from="";
		}*/


		valid_to=((String)bl_data.get("valid_to")).trim();
		if(valid_to == null) valid_to="";
		last_date=((String)bl_data.get("last_date")).trim();
		if(last_date == null) last_date="";

		if(inc_asset_ind.equals("I"))
		{
			tot_inc_asset = ((String)bl_data.get("annual_income")).trim();
			if(tot_inc_asset == null) tot_inc_asset=""; 
		}
		else if(inc_asset_ind.equals("A"))
		{
			tot_inc_asset = ((String)bl_data.get("family_asset")).trim();
			if(tot_inc_asset == null) tot_inc_asset=""; 
		}
		social_pensioner_id=((String)bl_data.get("social_pensioner_id")).trim();
		if(social_pensioner_id == null) social_pensioner_id="";
		
				}
			}
		}
		System.out.println("next :: class_type / inc_asset_ind / ind_inc / ind_inc_freq / blng_grp_id"+class_type+"/"+inc_asset_ind+"/"+ind_inc+"/"+ind_inc_freq+"/"+blng_grp_id);

		if(billing_mode.equals("Modify") || operation.equals("Update"))
		{
			HashMap bl_data=(HashMap)session.getAttribute("financial_details");
			if(!(bl_data==null || bl_data.isEmpty()))
			{
				fin_class_dtls_updated_YN=((String)bl_data.get("fin_class_dtls_updated_YN"));
				if(fin_class_dtls_updated_YN == null) fin_class_dtls_updated_YN="N";
				fin_class_dtls_updated_YN = fin_class_dtls_updated_YN.trim();
			}
		}
		
		if(billing_mode.equals("Modify") || operation.equals("Update"))
		{
			sql = "SELECT SHORT_DESC CLASSIFICATION_DESC,NVL(INCL_FAMILY_YN,'N') INCL_FAMILY_YN FROM BL_CLASSFCTN_CODE_LANG_VW WHERE CLASSIFICATION_CODE = ? AND LANGUAGE_ID = ?";
			try
			{
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,class_code);
				pstmt.setString(2,locale);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					class_desc = rs.getString("CLASSIFICATION_DESC");
					fam_mem_incl_YN = rs.getString("INCL_FAMILY_YN");
				}
			}
			catch(Exception e)
			{
				System.err.println("Exception from CLASSIFICATION_DESC:"+e );
			}
			finally
			{
				if (pstmt!=null) pstmt.close();
				if (rs!=null)	 rs.close();
			}
			if(class_desc == null) class_desc="";
			if(fam_mem_incl_YN == null) fam_mem_incl_YN="N";


			sql = "SELECT SHORT_DESC BILLING_DESC FROM BL_BLNG_GRP_LANG_VW WHERE BLNG_GRP_ID=? AND LANGUAGE_ID = ?";
			try
			{
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,blng_grp_id);
				pstmt.setString(2,locale);
				rs = pstmt.executeQuery();
				if(rs.next())
					blng_grp_desc = rs.getString("BILLING_DESC");
			}
			catch(Exception e)
			{
				System.err.println("Exception from BILLING_DESC:"+e );
			}
			finally
			{
				if (pstmt!=null) pstmt.close();
				if (rs!=null)	 rs.close();
			}
			if(blng_grp_desc == null) blng_grp_desc="";

		}

		
		if(siteSpec){
		sql = "SELECT to_char(CLASSIFICATION_START_DATE,'dd/mm/yyyy') CLASSIFICATION_START_DATE,to_char(CLASSIFICATION_END_DATE,'dd/mm/yyyy') CLASSIFICATION_END_DATE,BLNG_GRP_ID FROM BL_PATIENT_FIN_DTLS WHERE PATIENT_ID=?";
		try
		{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,patientId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				classStartDate = rs.getString(1);		
		    	classEndDate = rs.getString(2);
		    	blGrpIdMPI=rs.getString(3);
		    	System.out.println("classStartDate::classEndDate::blGrpIdMPI "+classStartDate+"::"+classEndDate+"::"+blGrpIdMPI);
		    	
			}
		}
		catch(Exception e)
		{
			System.err.println("Exception from ASSESSMENT_MONTHS:"+e );
		}
		finally
		{
			if (pstmt!=null) pstmt.close();
			if (rs!=null) rs.close();
		}
		
		if(classStartDate==null) classStartDate="";
		if(classEndDate==null) classEndDate="";
		valid_from=classStartDate;
		valid_to=classEndDate;
		}
		
		/*Getting ASSESSMENT_MONTHS, valid from & to dates, last date */ 
		if((valid_from.equals("") && valid_to.equals(""))||(fin_class_dtls_updated_YN.equals("N")&& strModuleId.equals("MP")))
		{
			sql = "SELECT ASSESSMENT_MONTHS FROM BL_PARAMETERS WHERE OPERATING_FACILITY_ID =?";
			try
			{
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,facilityId);
				rs = pstmt.executeQuery();
				if(rs.next())
					assessmentMonths = rs.getInt("ASSESSMENT_MONTHS");
			}
			catch(Exception e)
			{
				System.err.println("Exception from ASSESSMENT_MONTHS:"+e );
			}
			finally
			{
				if (pstmt!=null) pstmt.close();
				if (rs!=null)	 rs.close();
			}
//			System.err.println("assessmentMonths:"+assessmentMonths);

			valid_from = encounter_date_aft_trunc;

			sql = "SELECT to_char(add_months(to_date('"+valid_from+"','DD/MM/YYYY'),"+assessmentMonths+"),'dd/mm/yyyy') LAST_DATE FROM DUAL";

			try
			{
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					last_date = rs.getString("LAST_DATE");
				}
			}
			catch(Exception e)
			{
				System.err.println("Error getting sysdate and last_date :"+e);
			}
			finally
			{
				if (pstmt!=null) pstmt.close();
				if (rs!=null)	 rs.close();
			}

		} 

		//Getting the billing details if its already entered

		if(!strModuleId.equals("MP"))
		{	
			sql="select floor((to_date('"+valid_from+"','DD/MM/YYYY')-date_of_birth)/365) age, SEX  from mp_patient where patient_id =?";

			try
			{
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,patientId);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					age = rs.getString(1);
					sex = rs.getString(2);
				}


			}
			catch(Exception e)
			{
				System.err.println("Exception from getting age:"+e);
			}
			finally
			{
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			}	

			sql="SELECT nvl(CHILD_AGE_UPTO_IN_YEARS,0) CHILD_MIN_AGE from bl_parameters where operating_facility_id  = ?";
			//System.err.println("sql:"+sql);
			try
			{
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,facilityId);
				rs = pstmt.executeQuery();
				if(rs.next())
				childMinAge = rs.getString("CHILD_MIN_AGE");
//				System.err.println("childMinAge :"+childMinAge);
			}
			catch(Exception e)
			{
				System.err.println("Exception from getting CHILD_MIN_AGE:"+e);
			}
			finally
			{
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			}	
	
//			String err = "";
			try
			{
/*
				String Query_BL_GET_RECLASS_DETAILS = "{ call BL_GET_RECLASS_DETAILS('"+facilityId+"','"+patientId+"','"+strEpisodeType+"','"+clinicCode+"',to_date('"+sysDate+"','DD/MM/YYYY'),?,?,?,?,?,?,?,?,?,?,?) }";

				CallableStatement call = con.prepareCall(Query_BL_GET_RECLASS_DETAILS);		
				
				call.registerOutParameter(1,java.sql.Types.VARCHAR);
				call.registerOutParameter(2,java.sql.Types.VARCHAR);
				call.registerOutParameter(3,java.sql.Types.INTEGER);
				call.registerOutParameter(4,java.sql.Types.VARCHAR);
				call.registerOutParameter(5,java.sql.Types.VARCHAR);
				call.registerOutParameter(6,java.sql.Types.VARCHAR);
				call.registerOutParameter(7,java.sql.Types.VARCHAR);	
				call.registerOutParameter(8,java.sql.Types.VARCHAR);	
				call.registerOutParameter(9,java.sql.Types.VARCHAR);	
				call.registerOutParameter(10,java.sql.Types.VARCHAR);	
				call.registerOutParameter(11,java.sql.Types.VARCHAR);	
				call.execute();
			 
				ipBlGrp = call.getString(1) == null ? "" : call.getString(1);
//				ipblng_grp_desc = call.getString(10) == null ? "" : call.getString(10);
				err = call.getString(11)== null ? "" : call.getString(11);

				System.err.println("ipBlGrp:"+ipBlGrp);
				System.err.println("ipblng_grp_desc:"+ipblng_grp_desc);
				System.err.println("err:"+err);
				call.close();
*/
			}
			catch(Exception e)
			{
				System.err.println("Exception from procedure BL_GET_RECLASS_DETAILS :"+e);
			}

			sql="select 'Y' from BL_CLASSFCTN_CODE where CLASSIFICATION_CODE='"+class_code+"' AND CLASSIFICATION_TYPE='"+class_type+"' AND OPERATING_FACILITY_ID='"+facilityId+"' AND decode('"+strEpisodeType+"','R',VALID_FOR_BASIC_CLSFCTN,'O',VALID_FOR_BASIC_OP,'E',VALID_FOR_BASIC_EM,'I',VALID_FOR_BASIC_IP,'D',VALID_FOR_BASIC_DY)='Y' AND appl_patient_sex in('"+sex+"','B') AND ((APPL_TO_CHILD='Y') OR (APPL_TO_CHILD='N' AND '"+age+"' >= "+childMinAge+"))";
//			System.err.println("Valid Class for Encoutner YN query:"+sql);
			try
			{
				pstmt = con.prepareStatement(sql);

				rs = pstmt.executeQuery();
				if(rs.next())
				{
					class_code_valid_YN = rs.getString(1);
				}
				else
				{
					class_code_valid_YN = "N";
				}
				System.err.println("class_code_valid_YN:"+class_code_valid_YN);
			}
			catch(Exception e)
			{
				System.err.println("Exception from getting age:"+e);
			}
			finally
			{
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			}	
		}
		if(!patientId.equals(""))
		{
			try
			{
				String sqlCiti = "select a.citizen_yn,to_char(a.alt_id1_exp_date, 'dd/mm/yyyy') alt_id1_exp_date, b.gl_holder_name gl_holder_name, b.pat_reln_with_gl_holder pat_reln_with_gl_holder from mp_patient a, bl_patient_fin_dtls b where a.patient_id ='"+patientId+"' and a.patient_id=b.patient_id";
				pstmt = con.prepareStatement(sqlCiti);
				rs = pstmt.executeQuery() ;
				if( rs != null ) 
				{	
					while( rs.next() )
					{  
						boolPatientFoundMP = true;
					}
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception in sqlCiti:"+e);
			}
			finally
			{
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			}	
		}
		
		if (((strModuleId.equals("MP")) && (boolPatientFoundMP == true)) || ((strModuleId.equals("IP") || strModuleId.equals("DC") ||           strModuleId.equals("OP")||strModuleId.equals("AE")) && (boolPatientFoundMP == true)))
		{
			boolSecurity = true;
		}
		if(valid_to.equals(""))
			valid_to = 	last_date;

		try
		{
			sql = "SELECT MAX_DAYS_ALLWD_PROV_CLSFCTN,to_char(to_date('"+encounter_date_aft_trunc+"','DD/MM/YYYY')+(MAX_DAYS_ALLWD_PROV_CLSFCTN-1),'DD/MM/YYYY'),NVL(INCLUDE_DEP_INC_TOTAL_YN,'N')  FROM BL_PARAMETERS WHERE OPERATING_FACILITY_ID =?";

//			System.err.println("sql:"+sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facilityId);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				max_days_for_prov_class = rs.getInt(1);
				valid_to_for_prov_class = rs.getString(2);
				incld_dep_inc_yn	=rs.getString(3);
			}
			
			if (pstmt!=null) pstmt.close();
			if (rs!=null)	 rs.close();
//			System.err.println("max_days_for_prov_class:"+max_days_for_prov_class);
//			System.err.println("valid_to_for_prov_class:"+valid_to_for_prov_class);
		}
		catch(Exception e)
		{
			System.err.println("Exception while fetching max_days_for_prov_class:"+e);
		}

		if(!locale.equals("en"))
		{
			if(!valid_from.equals(""))
			{
				valid_from = com.ehis.util.DateUtils.convertDate(valid_from,"DMY","en",locale);
			}

			if(!valid_to.equals(""))
			{
				valid_to = com.ehis.util.DateUtils.convertDate(valid_to,"DMY","en",locale);
			}

			if(!last_date.equals(""))
			{
				last_date = com.ehis.util.DateUtils.convertDate(last_date,"DMY","en",locale);
			}
			
		}

		CurrencyFormat cf = new CurrencyFormat();

		ind_inc = cf.formatCurrency(ind_inc, noofdecimal);
		spouse_inc = cf.formatCurrency(spouse_inc, noofdecimal);
		dependent_inc = cf.formatCurrency(dependent_inc, noofdecimal);
System.out.println("strModuleId / functionId / siteSpec :: "+strModuleId+"/"+functionId+"/"+siteSpec);
		if(!functionId.equals("PAT_REG"))
		{
		  if(siteSpec){
			  
			if(((strModuleId.equals("IP") || strModuleId.equals("DC")) && functionId.equals("ADMISSION"))){
				System.out.println("1111111111111 test"); 
			 %>
				<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" onload='initItems("<%=slmt_ind%>","<%=class_type%>", "<%=inc_asset_ind%>", "<%=ind_inc_freq%>", "<%=spouse_inc_freq%>", "<%=dependent_inc_freq%>");defBillGroup();encDateCheck("<%=encounter_date_aft_trunc%>");'>
			 <%
			}
			else if(strModuleId.equals("OP") || strModuleId.equals("AE")){
				System.out.println("2222222222 test"); 
				 %>
					<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" onload='initItems("<%=slmt_ind%>","<%=class_type%>", "<%=inc_asset_ind%>", "<%=ind_inc_freq%>", "<%=spouse_inc_freq%>", "<%=dependent_inc_freq%>");defBillGroup();enableAllItems("<%=class_type%>");refreshAuthValue();'>
				 <%

			 }
			else{
				System.out.println("3333333333 test"); 
				 %>
					<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" onload='initItems("<%=slmt_ind%>","<%=class_type%>", "<%=inc_asset_ind%>", "<%=ind_inc_freq%>", "<%=spouse_inc_freq%>", "<%=dependent_inc_freq%>");defBillGroup();disableItems();'>
				 <%

			 }
			
		  }
		 else{
			 System.out.println("4444444444444 test"); 
			 %>
				<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" onload='initItems("<%=slmt_ind%>","<%=class_type%>", "<%=inc_asset_ind%>", "<%=ind_inc_freq%>", "<%=spouse_inc_freq%>", "<%=dependent_inc_freq%>");defBillGroup();disableItems();'>
			 <%

		 }
		}
		else
		{
			 System.out.println("5555555555 test"); 
			if( operation.equals("Update") && (boolSecurity == true) && (strModuleId.equals("MP")) && (SiteSpecific.equals("Y"))){
%>
	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" onload='initItems("<%=slmt_ind%>","<%=class_type%>", "<%=inc_asset_ind%>", "<%=ind_inc_freq%>", "<%=spouse_inc_freq%>", "<%=dependent_inc_freq%>");defBillGroup();disableItems();'>
<%
		}
			else{
				%>
	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" onload='initItems("<%=slmt_ind%>","<%=class_type%>", "<%=inc_asset_ind%>", "<%=ind_inc_freq%>", "<%=spouse_inc_freq%>", "<%=dependent_inc_freq%>");defBillGroup();'>
<%
				}
		}
%>
	<form name='frmFinClsDetails' id='frmFinClsDetails'>
		<table border='0' cellpadding='3' cellspacing='3' align='center' width='100%'>
<%
		if(!functionId.equals("PAT_REG"))
		{
		  if(siteSpec){
			 if( !(strModuleId.equals("IP") || strModuleId.equals("DC")|| strModuleId.equals("OP") || strModuleId.equals("AE")))
			 {
%>
			<tr>
				<td class='fields' width='25%' colspan='4'>
					<input type='button' class='button' name='modify_button' id='modify_button' value='Modify'  onClick='authUser("<%=class_type%>");'>	&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
<%
			 }

		  }
		  else{
			  %>
				<tr>
					<td class='fields' width='25%' colspan='4'>
						<input type='button' class='button' name='modify_button' id='modify_button' value='Modify'  onClick='authUser("<%=class_type%>");'>	&nbsp;&nbsp;&nbsp;
					</td>
				</tr>
			<%

		  }
		}
		
		if(slmt_ind.equals("C"))
		{
			cash_patient_YN = "CHECKED";
		}
		else
		{
			cash_patient_YN = "";
		}
%>
			<tr>
<!--					
				<td class='label' width='25%'><fmt:message key="eBL.CASH_PAY_PAT.label" bundle="${bl_labels}"/></td>
				<td class='fields' width='25%'>

					<INPUT TYPE="checkbox" name="cash_pay_pat_YN" id="cash_pay_pat_YN" <%=cash_patient_YN%> onClick="filter_class_type();assignValues('cash_pay_pat_YN')">
-->
					<INPUT TYPE="HIDDEN" name="cash_pay_pat_YN" id="cash_pay_pat_YN">
<!--
					<img src='../../eCommon/images/mandatory.gif'></img>

				</td>
-->
				<td class='label' width='25%'><fmt:message key="eBL.CLASS_TYPE.label" bundle="${bl_labels}"/></td>
				<td class='fields' width='25%'>
					<select name='class_type' id='class_type' onChange="class_type_change(this);assignValues('class_type');defBillGroup();">
						<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<option value='SG'><fmt:message key="eBL.SOCIAL_GRANT.label" bundle="${bl_labels}"/></option>	
						<option value='PV'><fmt:message key="Common.Provisional.label" bundle="${common_labels}"/></option>		
						<option value='IA'><fmt:message key="eBL.INCOME_ASSET_BASED.label" bundle="${bl_labels}"/></option>
						<option value='VS'><fmt:message key="Common.Visitor.label" bundle="${common_labels}"/></option>		
						<option value='CR'><fmt:message key="eBL.CREDIT.label" bundle="${bl_labels}"/></option>			
						<option value='SP'><fmt:message key="eBL.SPONSORED.label" bundle="${bl_labels}"/></option>		
						<option value='IN'><fmt:message key="Common.Insurance.label" bundle="${common_labels}"/></option>		
<% 
		if(!strEpisodeType.equals("R"))
		{
%>
						<option value='EX'><fmt:message key="eBL.EXEMPTED.label" bundle="${bl_labels}"/></option>	
						<option value='SC'><fmt:message key="eBL.SPECIAL_CASE.label" bundle="${bl_labels}"/></option>		
<%
		}
%>
					</select>
					<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
				<td class='label' width='25%'><fmt:message key="eBL.CLASS_CODE.label" bundle="${bl_labels}"/></td>
				<td class='fields' width='25%'>
					<input type='hidden' name='class_code' id='class_code' value='<%=class_code%>'>
					<input type='text' name='class_desc' id='class_desc' size='30' maxlength="30"  value="<%=class_desc%>" onBlur="class_code_lkup('B')">
					<input type='button' class='button' name='class_code_btn' id='class_code_btn' value='?' onClick="class_code_lkup('C')" >
					<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>

			<tr>
				<td class='label' width='25%'><fmt:message key="eBL.SOCIAL_PENSIONER_ID.label" bundle="${bl_labels}"/></td>
				<td class='fields' width='25%'>
					<input type='text' name='social_pensioner_id' id='social_pensioner_id' size='20' maxlength="20"  value="<%=social_pensioner_id%>" onBlur="assignValues('social_pensioner_id')" READONLY>
					<img src='../../eCommon/images/mandatory.gif' name='soc_pensr_id_mand_yn' style='visibility:hidden'></img>
				</td>

				<td class='label' width='25%'><fmt:message key="eBL.INCOME_ASSET_BASED.label" bundle="${bl_labels}"/></td>
				<td class='fields' width='25%'>
					<select name='inc_asset_ind' id='inc_asset_ind' onChange = "disableFields();defBillGroup();assignValues('inc_asset_ind')" >
						<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<option value='I'><fmt:message key="eBL.INCOME.label" bundle="${bl_labels}"/></option>
						<option value='A'><fmt:message key="eBL.ASSET.label" bundle="${bl_labels}"/></option>
					</select>
					<img src='../../eCommon/images/mandatory.gif' name='inc_asset_mand_yn' style='visibility:hidden'></img>
				</td>
			</tr>

			<tr>
				<td class='label' width='25%'><fmt:message key="eBL.INDVL_INC_FREQ.label" bundle="${bl_labels}"/></td>
				<td class='fields' width='25%'>
					<input type='text' name='ind_inc' id='ind_inc' size='10' maxlength="10" onKeyPress="return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))" onBlur="IncomeEntry(document.forms[0].ind_inc,'ind_inc');" value='<%=ind_inc%>'>
					<select name='ind_inc_freq' id='ind_inc_freq' onChange="calcTotalInc();assignValues('ind_inc_freq');defBillGroup()">
						<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<option value="Y"><fmt:message key="Common.Yearly.label" bundle="${common_labels}"/></option> 
						<option value='M'><fmt:message key="Common.monthly.label" bundle="${common_labels}"/></option>
						<option value='W'><fmt:message key="Common.weekly.label" bundle="${common_labels}"/></option>
					</select>
				</td>

				<td class='label' width='25%'><fmt:message key="eBL.SPOUSE_INC_FREQ.label" bundle="${bl_labels}"/></td>
				<td class='fields' width='25%'>
					<input type='text' name='spouse_inc' id='spouse_inc' size='10' maxlength="10" onKeyPress="return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))" onBlur="IncomeEntry(document.forms[0].spouse_inc,'spouse_inc');"  value='<%=spouse_inc%>'>
					<select name='spouse_inc_freq' id='spouse_inc_freq' onChange="calcTotalInc();assignValues('spouse_inc_freq');defBillGroup()">
						<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<option value="Y"><fmt:message key="Common.Yearly.label" bundle="${common_labels}"/></option> 
						<option value='M'><fmt:message key="Common.monthly.label" bundle="${common_labels}"/></option>
						<option value='W'><fmt:message key="Common.weekly.label" bundle="${common_labels}"/></option>
					</select>
				</td>
			</tr>

			<tr>
				<td class='label' width='25%'><fmt:message key="eBL.DEP_INC_FREQ.label" bundle="${bl_labels}"/></td>
				<td class='fields' width='25%'>
					<input type='text' name='dependent_inc' id='dependent_inc' size='10' maxlength="10" onKeyPress="return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))" onBlur="IncomeEntry(document.forms[0].dependent_inc,'dependent_inc');"  value='<%=dependent_inc%>' />
					<select name='dependent_inc_freq' id='dependent_inc_freq' onChange="calcTotalInc();assignValues('dependent_inc_freq');defBillGroup()">
						<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<option value="Y"><fmt:message key="Common.Yearly.label" bundle="${common_labels}"/></option> 
						<option value='M'><fmt:message key="Common.monthly.label" bundle="${common_labels}"/></option>
						<option value='W'><fmt:message key="Common.weekly.label" bundle="${common_labels}"/></option>
					</select>
				</td>

				<td class='label' width='25%'><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eBL.INCOME_ASSET.label" bundle="${bl_labels}"/></td>
				<td class='fields' width='25%'>
					<input type='text' name='tot_inc_asset' id='tot_inc_asset' size='15' maxlength="15" value='<%=tot_inc_asset%>' onKeyPress="return ChkNumberInput(this,event,0);" onBlur = "assignValues('tot_inc_asset');defBillGroup();" \>
				</td>
			</tr>

			<tr>
				<td class='label' width='25%'><fmt:message key="eBL.NO_OF_DEPENDANTS.label" bundle="${bl_labels}"/></td>
				<td class='fields' width='25%'>
					<input type='text' name='no_of_dependants' id='no_of_dependants' onBlur="assignValues('no_of_dependants');chk_for_fam_incl();defBillGroup();" size='2' maxlength="2" value='<%=no_of_dependants%>' onKeyPress="return ChkNumberInput(this,event,0);">
					<img src='../../eCommon/images/mandatory.gif' name='no_of_dep_mand_yn' style='visibility:hidden'></img>
				</td>
				<td class='label' width='25%'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'>
					<input type='hidden' name='blng_grp_id' id='blng_grp_id' value= '<%=blng_grp_id%>'>
					<input type='text' name='blng_grp_desc' id='blng_grp_desc' maxlength='40' size='30' value= "<%=blng_grp_desc%>" onBlur="blng_grp_lkup('B');">
					<input type='button' class='button' name='blng_grp_btn' id='blng_grp_btn' value='?' onClick="blng_grp_lkup('C');">
					<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>


				<input type='hidden' name='class_type_prev' id='class_type_prev' id='class_type_prev' value='<%=class_type%>' \>	
				<input type='hidden' name='class_code_prev' id='class_code_prev' value='<%=class_code%>' \>	
				<input type='hidden' name='class_desc_prev' id='class_desc_prev' value='<%=class_desc%>' \>
				<input type='hidden' name='social_pensioner_id_prev' id='social_pensioner_id_prev' value='<%=social_pensioner_id%>' \>	
				<input type='hidden' name='inc_asset_ind_prev' id='inc_asset_ind_prev' value='<%=inc_asset_ind%>' \>	
				<input type='hidden' name='ind_inc_prev' id='ind_inc_prev' value='<%=ind_inc%>' \>	
				<input type='hidden' name='ind_inc_freq_prev' id='ind_inc_freq_prev' value='<%=ind_inc_freq%>' \>	
				<input type='hidden' name='spouse_inc_prev' id='spouse_inc_prev' value='<%=spouse_inc%>' \>	
				<input type='hidden' name='spouse_inc_freq_prev' id='spouse_inc_freq_prev' value='<%=spouse_inc_freq%>' \>	
				<input type='hidden' name='dependent_inc_prev' id='dependent_inc_prev' value='<%=dependent_inc%>' \>		
				<input type='hidden' name='dependent_inc_freq_prev' id='dependent_inc_freq_prev' value='<%=dependent_inc_freq%>' \>				
				<input type='hidden' name='tot_inc_asset_prev' id='tot_inc_asset_prev' value='<%=tot_inc_asset%>' \>	
				<input type='hidden' name='no_of_dependants_prev' id='no_of_dependants_prev' value='<%=no_of_dependants%>' \>	
				<input type='hidden' name='blng_grp_desc_prev' id='blng_grp_desc_prev' value='<%=blng_grp_desc%>' \>
				<input type='hidden' name='blng_grp_id_prev' id='blng_grp_id_prev' value='<%=blng_grp_id%>' \>


			<tr>
				<td class='label' width='25%'><fmt:message key="eBL.VALID_FROM.label" bundle="${bl_labels}"/></td>
				<td class='fields' width='25%'>
					<input type='text' name='valid_from' id='valid_from' size='10' maxlength="10"  value='<%=valid_from%>' readOnly>
				</td>
				<td class='label' width='25%'><fmt:message key="eBL.VALID_TO.label" bundle="${bl_labels}"/></td>
				<td class='fields' width='25%'>
					<input type='text' name='valid_to' id='valid_to' size='10' maxlength="10" value='<%=valid_to%>' onBlur="chkDate(document.forms[0].valid_from,this,document.forms[0].last_date);assignValues('tot_inc_asset');" readOnly>
					<input type='image' id='valid_to_cal' src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar_loc('valid_to',document.forms[0].valid_to);assignValues('tot_inc_asset')" style='visibility:hidden'>
					<img src='../../eCommon/images/mandatory.gif' name='valid_to_mand_yn' style='visibility:hidden'></img>
				</td>
			</tr>
<%
		if(strEpisodeType.equals("R"))
		{
%>
			<tr>
				<td class='label' width='25%'><fmt:message key="eBL.FINANCIAL_REMARKS.label" bundle="${bl_labels}"/></td>
				<td class='fields' width='25%' colspan='3'>
					<input type='text' name='remarks' id='remarks' size='50' maxlength="40" value="<%=remarks%>" onBlur = "assignValues('remarks')">
					<img src='../../eCommon/images/mandatory.gif' name='remarks_mand_yn' style='visibility:hidden'></img>
				</td>
			</tr>
<%
		}
%>
		</table>
		
		<input type='hidden' name='query_string' id='query_string' value='<%=strAllParam%>' \>	
		<input type='hidden' name='noofdecimal' id='noofdecimal' value='<%=noofdecimal%>' \>	
		
		<input type='hidden' name='calling_module_id' id='calling_module_id' id='calling_module_id' value='<%=strModuleId%>' \>	
		<input type='hidden' name='facility_id' id='facility_id' value='<%=facilityId%>' \>	
		<input type='hidden' name='calling_function_id' id='calling_function_id' value='<%=functionId%>' \>
		<input type='hidden' name='episode_type' id='episode_type' value='<%=strEpisodeType%>' \>
		<input type='hidden' name='billing_mode' id='billing_mode' value='<%=billing_mode%>' \>
		<input type='hidden' name='class_type_selectd' id='class_type_selectd' value='<%=class_type%>' \>		
		<input type='hidden' name='sex' id='sex' value='<%=sex%>' \>
		<input type='hidden' name='last_date' id='last_date' value='<%=last_date%>'  />
		<!--For IP -->
		<input type='hidden' name='ipBlGrp' id='ipBlGrp' value='<%=ipBlGrp%>'  />
		<input type='hidden' name='ipblng_grp_desc' id='ipblng_grp_desc' value='<%=ipblng_grp_desc%>'  />

		<input type='hidden' name='age' id='age' value='<%=age%>'  />
		<input type='hidden' name='childMinAge' id='childMinAge' value='<%=childMinAge%>'  />
		<input type='hidden' name='max_days_for_prov_class' id='max_days_for_prov_class' value='<%=max_days_for_prov_class%>'  />
		
		<input type='hidden' name='patientId' id='patientId' id='patientId' value='<%=patientId%>'  />
		<input type='hidden' name='locale' id='locale' value='<%=locale%>'  />
		<input type='hidden' name='upd_class_dtls_YN' id='upd_class_dtls_YN' value='<%=upd_class_dtls_YN%>'  />		
		<input type='hidden' name='blng_grp_changed_YN' id='blng_grp_changed_YN' value='<%=blng_grp_changed_YN%>'  />		
		<input type='hidden' name='valid_to_for_prov_class' id='valid_to_for_prov_class' value='<%=valid_to_for_prov_class%>'  />				
		<input type='hidden' name='fam_mem_incl_YN' id='fam_mem_incl_YN' value='<%=fam_mem_incl_YN%>'  />						

		<input type='hidden' name='fin_class_dtls_updated_YN' id='fin_class_dtls_updated_YN' value='<%=fin_class_dtls_updated_YN%>'  />	
		<input type='hidden' name='class_code_valid_YN' id='class_code_valid_YN' value='<%=class_code_valid_YN%>'  />	
		
		<input type='hidden' name='encounter_date_aft_trunc' id='encounter_date_aft_trunc' value='<%=encounter_date_aft_trunc%>'  />	
		<input type='hidden' name='isUsedAuthorized' id='isUsedAuthorized' value='N'>
		<input type='hidden' name ='incld_dep_inc_yn' value='<%=incld_dep_inc_yn%>'>
		
		<input type='hidden' name ='siteSpec' id ='siteSpec' value='<%=siteSpec%>'>
		<input type='hidden' name ='blng_grp_id_temp' value='<%=blng_grp_id_temp%>'>
		<input type='hidden' name='blGrpIdMPI' id='blGrpIdMPI' value='<%=blGrpIdMPI%>'>
		
		<input type='hidden' name='classTypChangeAuthYnPatId' id='classTypChangeAuthYnPatId' id='classTypChangeAuthYnPatId' value='<%=classTypChangeAuthYnPatId%>'>
		<input type='hidden' name='tabsSwapped' id='tabsSwapped' value='N'>
		
		
		<input type='hidden' name='classTypChangeAuthYN' id='classTypChangeAuthYN'  id='classTypChangeAuthYN' value='<%=classTypChangeAuthYN%>'>
		<input type='hidden' name='changePatAuthYN' id='changePatAuthYN' id='changePatAuthYN' value='<%=changePatAuthYN%>'>
		
		<input type='hidden' name='prevPatId' id='prevPatId'  id='prevPatId' value='<%=prevPatId%>'>
		<input type='hidden' name='sessionClinicCode' id='sessionClinicCode'  id='sessionClinicCode' value='<%=sessionClinicCode%>'>
		<input type='hidden' name='reqClinicCode' id='reqClinicCode'  id='reqClinicCode' value='<%=reqClinicCode%>'>
		<input type='hidden' name='boolSecurity' id='boolSecurity'  id='boolSecurity' value='<%=boolSecurity%>'> <!-- Added by Subha/GDOH-SCF-0289/V19072018  -->
		
		
		
		
	</form>
</body>

<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("Main Exception:"+e);
		out.println(e);
	}
	finally
	{
		ConnectionManager.returnConnection(con, request);
	}
%>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

