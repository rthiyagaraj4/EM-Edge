<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %> 

<html>
<head></head>
<body style="margin: 1px;"> 
<%     
		request.setCharacterEncoding("UTF-8");
		String locale =((String)session.getAttribute("LOCALE"));
		String motherid = request.getParameter("mother_id")==null?"": request.getParameter("mother_id");
		String mother_encounter_id = request.getParameter("mother_encounter_id")==null?"": request.getParameter("mother_encounter_id");//Rameez for SKR-SCF-0668 [IN:035813] on 22-Nov-12
		String function_id = request.getParameter("function_id") ;
		if(function_id == null)function_id = "" ;
		String mother_patient_id = "";		
		String accessRights = request.getParameter("accessRights");
		if( accessRights == null) accessRights="";
		String parent_details = request.getParameter("parent_details");
		if( parent_details == null) parent_details="";
		parent_details = java.net.URLEncoder.encode(parent_details);
		String function_invoked = request.getParameter("function_invoked");
		if( function_invoked == null) function_invoked="";
		String module_invoked = request.getParameter("module_invoked");
		if( module_invoked == null) module_invoked="";
		String called_from_mothercare = request.getParameter("called_from_mothercare")==null?"":request.getParameter("called_from_mothercare");
		String mother_nursing_unit	= request.getParameter("mother_nursing_unit")==null?"":request.getParameter("mother_nursing_unit");
		String calling_module_id	= request.getParameter("calling_module_id")==null?"":request.getParameter("calling_module_id");	
		String disable_button_yn	= request.getParameter("disable_add_yn")==null?"N":request.getParameter("disable_add_yn");
		String invoked_from			= request.getParameter("invoked_from")==null?"":request.getParameter("invoked_from");	
		String new_born_id			= request.getParameter("new_born_id")==null?"":request.getParameter("new_born_id");
		String mother_bed_no		= request.getParameter("mother_bed_no")==null?"":request.getParameter("mother_bed_no");
		if(calling_module_id.equals("IP")){
			mother_patient_id = request.getParameter("mother_id")==null?"": request.getParameter("mother_id");
		}else{
			mother_patient_id = request.getParameter("mother_patient_id")==null?"":request.getParameter("mother_patient_id");
		}		
		String ca_encounter_id		= request.getParameter("ca_encounter_id") == null ? "" : request.getParameter("ca_encounter_id");
		String function_name 		= request.getParameter( "function_name" ) ;
		if ( function_name	== null ) function_name	= "" ;	
		
		String nb_use_mother_ser = request.getParameter("nbUseMotherSer") == null ? "" : request.getParameter("nbUseMotherSer");
		String patientidlength	= request.getParameter("patIidLength") == null ? "" : request.getParameter("patIidLength");
		String newbornpatsergrp	= request.getParameter("nbPatSerGrp") == null ? "" : request.getParameter("nbPatSerGrp");
		String invoke_adm_from_newborn_yn = request.getParameter("invkAdmFrmNBYn")==null?"N":request.getParameter("invkAdmFrmNBYn");
		String ip_install_yn = request.getParameter("ipInstallYn")==null?"N":request.getParameter("ipInstallYn");
		String siteId = request.getParameter("siteId")==null?"":request.getParameter("siteId");	 	
		 

		String inhousebirthyn = "Y";  

		/*
		String unitofwtnb							= "";
		String unitofcircumnb					= "";
		String unitofchestunit				= "";//added by sen on 9/08/2004
		String unitoflengthnb					= "";
		String unitofgestnb						= "";
		String namesuffixmalenb			= "";
		String namesuffixfemalenb		= ""; 		
		String allownbregnwithindays	= "";
		String alt_id_type_desc			= "";
		*/

		String encounterid						= "";
		String nursingunitcode				= "";
		
		
		String patientLine = "";
		String Facility_Id = (String) session.getValue("facility_id");
		Connection con = null;
		PreparedStatement pstmt	= null;
		ResultSet rset		= null;
				
		String patient_id = "";
		String baby_patient_id = "";
		String multiple_birth_yn = "N";
		String exceedMaxBirthYN = "N";
		String newTransactionYN = "Y";
		Boolean isNewBornChngsAppl	= false;
		
		try
		{
			con = ConnectionManager.getConnection(request);
			 isNewBornChngsAppl		 = CommonBean.isSiteSpecific(con,"IP","REG_NEW_BORN_FOR_IP_FLD_CHNGS");//Added by Dharma on 30th May 2018 against ML-MMOH-CRF-0898 [IN:064757]

			int no_of_multi_babies_regd = 0;
			//int no_of_births = 0;

			//pstmt = con.prepareStatement("SELECT PATIENT_ID, MULTIPLE_BIRTH_YN, no_of_births, no_of_multi_babies_regd FROM mp_birth_register WHERE MOTHER_PATIENT_ID = '"+motherid+"' order by birth_order, time_of_birth");
			String checkBirths="SELECT PATIENT_ID, MULTIPLE_BIRTH_YN, no_of_multi_babies_regd FROM mp_birth_register WHERE MOTHER_PATIENT_ID = '"+motherid+"' order by added_date desc";
					
			pstmt = con.prepareStatement(checkBirths); 

			rset = pstmt.executeQuery();

			if (rset!=null) {
				if(rset.next()) {
					baby_patient_id = rset.getString("PATIENT_ID")==null?"":rset.getString("PATIENT_ID");
					multiple_birth_yn = rset.getString("MULTIPLE_BIRTH_YN") ==null?"N":rset.getString("MULTIPLE_BIRTH_YN");
					no_of_multi_babies_regd = rset.getInt("no_of_multi_babies_regd"); 
					//no_of_births = rset.getInt("no_of_births"); 
				}					
			}
			if(pstmt!=null)pstmt.close();
			if(rset!=null)rset.close();
			if(invoked_from.equals("servlet")) {
				patient_id = new_born_id;
				if(multiple_birth_yn.equals("Y") && (no_of_multi_babies_regd == 0)) {				
					exceedMaxBirthYN = "Y";				
				} else if(multiple_birth_yn.equals("N")){
					exceedMaxBirthYN = "Y";	
				} else {
					exceedMaxBirthYN = "N";	
				}
				newTransactionYN = "N";
			} else {
				if(no_of_multi_babies_regd > 0 && multiple_birth_yn.equals("Y")) {
					patient_id = baby_patient_id;
					invoked_from = "servlet";
					newTransactionYN = "N";
				} else {
					patient_id = motherid;
					newTransactionYN = "Y";
				}
			}		  

			/*
			pstmt = con.prepareStatement("select install_yn from sm_module where module_id = 'IP'");
			rset = pstmt.executeQuery();
			if (rset!=null && rset.next())
			{
				ip_install_yn = rset.getString(1);
				if (ip_install_yn==null) ip_install_yn = "";
			}
			if(pstmt!=null)pstmt.close();
			if(rset!=null)rset.close();
			*/
		}
		catch(Exception ex)
		{
			out.println(ex.toString());
		}
		finally
		{
			if(pstmt!=null)pstmt.close();
			if(rset!=null)rset.close();
		}
	try{		
		if (ip_install_yn.equals("Y"))
		{
			/*
			pstmt = con.prepareStatement("select invoke_adm_from_newborn_yn from ip_param where facility_id='"+Facility_Id+"'");

			rset = pstmt.executeQuery();
			if (rset!=null && rset.next())
			{
				invoke_adm_from_newborn_yn = rset.getString("invoke_adm_from_newborn_yn")==null?"N": rset.getString("invoke_adm_from_newborn_yn");				
			}		

			if(rset!=null)
				rset.close();
			if(pstmt!=null)
				pstmt.close();
			*/

			String sql1 = "Select a.encounter_id, a.nursing_unit_code, IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, a.NURSING_UNIT_CODE,'"+locale+"','1') Nursing_Unit_Short_Desc from IP_OPEN_ENCOUNTER a where a.facility_id='"+Facility_Id+"' and a.Patient_Id = '"+motherid+"'" ;
			
			pstmt	= con.prepareStatement(sql1);
			rset	= pstmt.executeQuery();
			if(rset!=null && rset.next())
			{
				encounterid			= rset.getString("encounter_id")==null?"":rset.getString("encounter_id");
				nursingunitcode	= rset.getString("nursing_unit_code")==null?"":rset.getString("nursing_unit_code");
				inhousebirthyn		= "Y";
			}/*else{
				encounterid = mother_encounter_id; //Rameez for SKR-SCF-0668 [IN:035813] on 22-Nov-12 
			}*/
			if(pstmt!=null)pstmt.close();
		}
		//code fix for 36653 - starts
		if(encounterid.equals("") && !mother_encounter_id.equals("") && !mother_encounter_id.equals("TEMP*12*")) {
			encounterid=mother_encounter_id;
		}
		//code fix for 36653 - ends
		
		if (encounterid.equals("") )
		{
			patientLine = "Patient_ID="+motherid;
		}
		else{
			patientLine = "EncounterId="+encounterid;
		}
		
	}

	catch(Exception e) { out.println(e.toString());}
	finally
	{
		if (pstmt != null) pstmt.close();
		if (rset != null) rset.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

	/*

	try{  

		String sql =  "select unit_of_wt_nb, unit_of_circum_nb,unit_of_chest_circum_nb,unit_of_length_nb, unit_of_gest_nb,  name_suffix_male_nb,name_suffix_female_nb,patient_id_length,newborn_pat_ser_grp,  nb_use_mother_ser,allow_nb_regn_within_days, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(alt_id1_type,'"+locale+"','1') alt_id_type_desc from mp_param where module_id='MP'";

		pstmt = con.prepareStatement(sql);
		rset = pstmt.executeQuery();
		if(rset!=null && rset.next())
		{
			alt_id_type_desc			= rset.getString("alt_id_type_desc")==null?"":rset.getString("alt_id_type_desc");
			unitofwtnb					= rset.getString("unit_of_wt_nb")==null?"":rset.getString("unit_of_wt_nb");
			unitofcircumnb				= rset.getString("unit_of_circum_nb")==null?"":rset.getString("unit_of_circum_nb");
			unitoflengthnb				= rset.getString("unit_of_length_nb")==null?"":rset.getString("unit_of_length_nb");
			unitofgestnb				= rset.getString("unit_of_gest_nb")==null?"":rset.getString("unit_of_gest_nb");
			patientidlength				= rset.getString("patient_id_length")==null?"":rset.getString("patient_id_length");
			namesuffixmalenb			= rset.getString("name_suffix_male_nb")==null?"":rset.getString("name_suffix_male_nb");
			namesuffixfemalenb		= rset.getString("name_suffix_female_nb")==null?"":rset.getString("name_suffix_female_nb");
			newbornpatsergrp			= rset.getString("newborn_pat_ser_grp")==null?"":rset.getString("newborn_pat_ser_grp");
			nb_use_mother_ser		= rset.getString("nb_use_mother_ser")==null?"N":rset.getString("nb_use_mother_ser");
			allownbregnwithindays	= rset.getString("allow_nb_regn_within_days")==null?"":rset.getString("allow_nb_regn_within_days");
			patient_id_length			= rset.getString("patient_id_length");

			unitofchestunit = rset.getString("unit_of_chest_circum_nb")==null?"":rset.getString("unit_of_chest_circum_nb");//aded by sen 0n 9/08/2004			
		}
		if(pstmt!=null)pstmt.close();
		if(rset!=null)rset.close();
	}catch(Exception e) { out.println(e.toString());}
	finally
	{
		if (pstmt != null) pstmt.close();
		if (rset != null) rset.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

	*/

	

	String frameSetRows="";
	if(called_from_mothercare.equals("MC")){ %>
	
			<iframe src="../../eCommon/jsp/pline.jsp?<%=patientLine%>" name="motherline_frame" id="motherline_frame"  NORESIZE=NORESIZE   scrolling="no" style='height:10vh;width:97vw'></iframe>
			<iframe  src="../../eMP/jsp/NewbornRegistrationHeader.jsp?mother_id=<%=motherid%>&function_id=<%=function_id%>&function_id_new=REGISTER_NEWBORN&encounter_id=<%=encounterid%>&nursing_unit=<%=nursingunitcode%>&patient_id_length=<%=patientidlength%>&inhouse_birth_yn=<%=inhousebirthyn%>&new_born_pat_ser_grp=<%=newbornpatsergrp%>&nb_use_mother_ser=<%=nb_use_mother_ser%>&accessRights=<%=accessRights%>&calling_module_id=<%=calling_module_id%>&disable_button_yn=<%=disable_button_yn%>&called_from_mothercare=<%=called_from_mothercare%>&mother_patient_id=<%=mother_patient_id%>&ca_encounter_id=<%=ca_encounter_id%>&ip_install_yn=<%=ip_install_yn%>&siteId=<%=siteId%>&isNewBornChngsAppl=<%=isNewBornChngsAppl%>"  name="newbornheader_frame" id="newbornheader_frame" scrolling="no" noresize style='height:4vh;width:97vw'></iframe>

			<%if(calling_module_id.equals("IP") && isNewBornChngsAppl){%>
				<iframe  src="../../eMP/jsp/NewbornRegistrationMainSLY.jsp?mother_id=<%=patient_id%>&function_id=<%=function_id%>&function_id_new=REGISTER_NEWBORN&encounter_id=<%=encounterid%>&nursing_unit=<%=nursingunitcode%>&inhouse_birth_yn=<%=inhousebirthyn%>&accessRights=<%=accessRights%>&parent_details=<%=parent_details%>&function_invoked=<%=function_invoked%>&module_invoked=<%=module_invoked%>&mother_nursing_unit=<%=mother_nursing_unit%>&mother_bed_no=<%=mother_bed_no%>&function_name=<%=function_name%>&invoke_adm_from_newborn_yn=<%=invoke_adm_from_newborn_yn%>&disable_button_yn=<%=disable_button_yn%>&invoked_from=<%=invoked_from%>&calling_module_id=<%=calling_module_id%>&newTransactionYN=<%=newTransactionYN%>&called_from_mothercare=<%=called_from_mothercare%>&mother_patient_id=<%=mother_patient_id%>&ca_encounter_id=<%=ca_encounter_id%>&ip_install_yn=<%=ip_install_yn%>&siteId=<%=siteId%>&mother_pat_id=<%=motherid%>&isNewBornChngsAppl=<%=isNewBornChngsAppl%>"  name="newbornmain_frame"  id="newbornmain_frame" scrolling="auto" noresize style='height:4vh;width:97vw'></iframe>
			<%}else{%>
				<iframe  src="../../eMP/jsp/NewbornRegistrationMain.jsp?mother_id=<%=patient_id%>&function_id=<%=function_id%>&function_id_new=REGISTER_NEWBORN&encounter_id=<%=encounterid%>&nursing_unit=<%=nursingunitcode%>&inhouse_birth_yn=<%=inhousebirthyn%>&accessRights=<%=accessRights%>&parent_details=<%=parent_details%>&function_invoked=<%=function_invoked%>&module_invoked=<%=module_invoked%>&mother_nursing_unit=<%=mother_nursing_unit%>&mother_bed_no=<%=mother_bed_no%>&function_name=<%=function_name%>&invoke_adm_from_newborn_yn=<%=invoke_adm_from_newborn_yn%>&disable_button_yn=<%=disable_button_yn%>&invoked_from=<%=invoked_from%>&calling_module_id=<%=calling_module_id%>&newTransactionYN=<%=newTransactionYN%>&called_from_mothercare=<%=called_from_mothercare%>&mother_patient_id=<%=mother_patient_id%>&ca_encounter_id=<%=ca_encounter_id%>&ip_install_yn=<%=ip_install_yn%>&siteId=<%=siteId%>&mother_pat_id=<%=motherid%>&isNewBornChngsAppl=<%=isNewBornChngsAppl%>"  name="newbornmain_frame" id="newbornmain_frame" scrolling="auto" noresize style='height:87vh;width:97vw'></iframe>
			<%}%>
			<iframe  src="../../eMP/jsp/NewbornRegistrationDetails.jsp?mother_id=<%=motherid%>&function_id=<%=function_id%>&function_id_new=REGISTER_NEWBORN&encounter_id=<%=encounterid%>&nursing_unit=<%=nursingunitcode%>&patient_id_length=<%=patientidlength%>&inhouse_birth_yn=<%=inhousebirthyn%>&new_born_pat_ser_grp=<%=newbornpatsergrp%>&nb_use_mother_ser=<%=nb_use_mother_ser%>&accessRights=<%=accessRights%>&parent_details=<%=parent_details%>&function_invoked=<%=function_invoked%>&module_invoked=<%=module_invoked%>&mother_nursing_unit=<%=mother_nursing_unit%>&mother_bed_no=<%=mother_bed_no%>&function_name=<%=function_name%>&invoke_adm_from_newborn_yn=<%=invoke_adm_from_newborn_yn%>&disable_button_yn=<%=disable_button_yn%>&invoked_from=<%=invoked_from%>&calling_module_id=<%=calling_module_id%>&exceedMaxBirthYN=<%=exceedMaxBirthYN%>&newTransactionYN=<%=newTransactionYN%>&called_from_mothercare=<%=called_from_mothercare%>&mother_patient_id=<%=mother_patient_id%>&ca_encounter_id=<%=ca_encounter_id%>&siteId=<%=siteId%>&isNewBornChngsAppl=<%=isNewBornChngsAppl%>" name="newborndtls_frame" id="newborndtls_frame" scrolling="auto" noresize style='height:9vh;width:97vw'></iframe>
	<%  }%><% else{%>
		
		
			<iframe src="../../eCommon/jsp/pline.jsp?<%=patientLine%>" name="motherline_frame" id="motherline_frame"  NORESIZE=NORESIZE   scrolling="no" style='height:10vh;width:99vw'></iframe>
			<iframe  src="../../eMP/jsp/NewbornRegistrationHeader.jsp?mother_id=<%=motherid%>&function_id=<%=function_id%>&function_id_new=REGISTER_NEWBORN&encounter_id=<%=encounterid%>&nursing_unit=<%=nursingunitcode%>&patient_id_length=<%=patientidlength%>&inhouse_birth_yn=<%=inhousebirthyn%>&new_born_pat_ser_grp=<%=newbornpatsergrp%>&nb_use_mother_ser=<%=nb_use_mother_ser%>&accessRights=<%=accessRights%>&calling_module_id=<%=calling_module_id%>&disable_button_yn=<%=disable_button_yn%>&called_from_mothercare=<%=called_from_mothercare%>&mother_patient_id=<%=mother_patient_id%>&ca_encounter_id=<%=ca_encounter_id%>&ip_install_yn=<%=ip_install_yn%>&siteId=<%=siteId%>&isNewBornChngsAppl=<%=isNewBornChngsAppl%>"  name="newbornheader_frame" id="newbornheader_frame" scrolling="no" noresize style='height:7.5vh;width:99vw'></iframe>

			<%if(calling_module_id.equals("IP") && isNewBornChngsAppl){%>
				<iframe  src="../../eMP/jsp/NewbornRegistrationMainSLY.jsp?mother_id=<%=patient_id%>&function_id=<%=function_id%>&function_id_new=REGISTER_NEWBORN&encounter_id=<%=encounterid%>&nursing_unit=<%=nursingunitcode%>&inhouse_birth_yn=<%=inhousebirthyn%>&accessRights=<%=accessRights%>&parent_details=<%=parent_details%>&function_invoked=<%=function_invoked%>&module_invoked=<%=module_invoked%>&mother_nursing_unit=<%=mother_nursing_unit%>&mother_bed_no=<%=mother_bed_no%>&function_name=<%=function_name%>&invoke_adm_from_newborn_yn=<%=invoke_adm_from_newborn_yn%>&disable_button_yn=<%=disable_button_yn%>&invoked_from=<%=invoked_from%>&calling_module_id=<%=calling_module_id%>&newTransactionYN=<%=newTransactionYN%>&called_from_mothercare=<%=called_from_mothercare%>&mother_patient_id=<%=mother_patient_id%>&ca_encounter_id=<%=ca_encounter_id%>&ip_install_yn=<%=ip_install_yn%>&siteId=<%=siteId%>&mother_pat_id=<%=motherid%>&isNewBornChngsAppl=<%=isNewBornChngsAppl%>"  name="newbornmain_frame" id="newbornmain_frame" scrolling="auto" noresize style='height:4vh;width:99vw'></iframe>
			<%}else{%>
				<iframe  src="../../eMP/jsp/NewbornRegistrationMain.jsp?mother_id=<%=patient_id%>&function_id=<%=function_id%>&function_id_new=REGISTER_NEWBORN&encounter_id=<%=encounterid%>&nursing_unit=<%=nursingunitcode%>&inhouse_birth_yn=<%=inhousebirthyn%>&accessRights=<%=accessRights%>&parent_details=<%=parent_details%>&function_invoked=<%=function_invoked%>&module_invoked=<%=module_invoked%>&mother_nursing_unit=<%=mother_nursing_unit%>&mother_bed_no=<%=mother_bed_no%>&function_name=<%=function_name%>&invoke_adm_from_newborn_yn=<%=invoke_adm_from_newborn_yn%>&disable_button_yn=<%=disable_button_yn%>&invoked_from=<%=invoked_from%>&calling_module_id=<%=calling_module_id%>&newTransactionYN=<%=newTransactionYN%>&called_from_mothercare=<%=called_from_mothercare%>&mother_patient_id=<%=mother_patient_id%>&ca_encounter_id=<%=ca_encounter_id%>&ip_install_yn=<%=ip_install_yn%>&siteId=<%=siteId%>&mother_pat_id=<%=motherid%>&isNewBornChngsAppl=<%=isNewBornChngsAppl%>"  id="newbornmain_frame" name="newbornmain_frame" scrolling="auto" noresize style='height:65vh;width:99vw'></iframe>
			<%}%>
			<iframe  src="../../eMP/jsp/NewbornRegistrationDetails.jsp?mother_id=<%=motherid%>&function_id=<%=function_id%>&function_id_new=REGISTER_NEWBORN&encounter_id=<%=encounterid%>&nursing_unit=<%=nursingunitcode%>&patient_id_length=<%=patientidlength%>&inhouse_birth_yn=<%=inhousebirthyn%>&new_born_pat_ser_grp=<%=newbornpatsergrp%>&nb_use_mother_ser=<%=nb_use_mother_ser%>&accessRights=<%=accessRights%>&parent_details=<%=parent_details%>&function_invoked=<%=function_invoked%>&module_invoked=<%=module_invoked%>&mother_nursing_unit=<%=mother_nursing_unit%>&mother_bed_no=<%=mother_bed_no%>&function_name=<%=function_name%>&invoke_adm_from_newborn_yn=<%=invoke_adm_from_newborn_yn%>&disable_button_yn=<%=disable_button_yn%>&invoked_from=<%=invoked_from%>&calling_module_id=<%=calling_module_id%>&exceedMaxBirthYN=<%=exceedMaxBirthYN%>&newTransactionYN=<%=newTransactionYN%>&called_from_mothercare=<%=called_from_mothercare%>&mother_patient_id=<%=mother_patient_id%>&ca_encounter_id=<%=ca_encounter_id%>&siteId=<%=siteId%>&isNewBornChngsAppl=<%=isNewBornChngsAppl%>" name="newborndtls_frame" id="newborndtls_frame" scrolling="auto" noresize style='height:10vh;width:99vw'></iframe>
	<%}
	//Below line modified for this CRF  HSA-CRF-0182 linked incident [54168]
%>
<script> ////change by vijayan for IE  to Edge testing jul-10-2024
			/*<frameset rows="<%=frameSetRows%>" frameborder='0'>
			<frame src="../../eCommon/jsp/pline.jsp?<%=patientLine%>" name="motherline_frame"  NORESIZE=NORESIZE   scrolling="no">
			<frame  src="../../eMP/jsp/NewbornRegistrationHeader.jsp?mother_id=<%=motherid%>&function_id=<%=function_id%>&function_id_new=REGISTER_NEWBORN&encounter_id=<%=encounterid%>&nursing_unit=<%=nursingunitcode%>&patient_id_length=<%=patientidlength%>&inhouse_birth_yn=<%=inhousebirthyn%>&new_born_pat_ser_grp=<%=newbornpatsergrp%>&nb_use_mother_ser=<%=nb_use_mother_ser%>&accessRights=<%=accessRights%>&calling_module_id=<%=calling_module_id%>&disable_button_yn=<%=disable_button_yn%>&called_from_mothercare=<%=called_from_mothercare%>&mother_patient_id=<%=mother_patient_id%>&ca_encounter_id=<%=ca_encounter_id%>&ip_install_yn=<%=ip_install_yn%>&siteId=<%=siteId%>&isNewBornChngsAppl=<%=isNewBornChngsAppl%>"  name="newbornheader_frame" scrolling="no" noresize >

			<%if(calling_module_id.equals("IP") && isNewBornChngsAppl){%>
				<frame  src="../../eMP/jsp/NewbornRegistrationMainSLY.jsp?mother_id=<%=patient_id%>&function_id=<%=function_id%>&function_id_new=REGISTER_NEWBORN&encounter_id=<%=encounterid%>&nursing_unit=<%=nursingunitcode%>&inhouse_birth_yn=<%=inhousebirthyn%>&accessRights=<%=accessRights%>&parent_details=<%=parent_details%>&function_invoked=<%=function_invoked%>&module_invoked=<%=module_invoked%>&mother_nursing_unit=<%=mother_nursing_unit%>&mother_bed_no=<%=mother_bed_no%>&function_name=<%=function_name%>&invoke_adm_from_newborn_yn=<%=invoke_adm_from_newborn_yn%>&disable_button_yn=<%=disable_button_yn%>&invoked_from=<%=invoked_from%>&calling_module_id=<%=calling_module_id%>&newTransactionYN=<%=newTransactionYN%>&called_from_mothercare=<%=called_from_mothercare%>&mother_patient_id=<%=mother_patient_id%>&ca_encounter_id=<%=ca_encounter_id%>&ip_install_yn=<%=ip_install_yn%>&siteId=<%=siteId%>&mother_pat_id=<%=motherid%>&isNewBornChngsAppl=<%=isNewBornChngsAppl%>"  name="newbornmain_frame" scrolling="auto" noresize >
			<%}else{%>
				<frame  src="../../eMP/jsp/NewbornRegistrationMain.jsp?mother_id=<%=patient_id%>&function_id=<%=function_id%>&function_id_new=REGISTER_NEWBORN&encounter_id=<%=encounterid%>&nursing_unit=<%=nursingunitcode%>&inhouse_birth_yn=<%=inhousebirthyn%>&accessRights=<%=accessRights%>&parent_details=<%=parent_details%>&function_invoked=<%=function_invoked%>&module_invoked=<%=module_invoked%>&mother_nursing_unit=<%=mother_nursing_unit%>&mother_bed_no=<%=mother_bed_no%>&function_name=<%=function_name%>&invoke_adm_from_newborn_yn=<%=invoke_adm_from_newborn_yn%>&disable_button_yn=<%=disable_button_yn%>&invoked_from=<%=invoked_from%>&calling_module_id=<%=calling_module_id%>&newTransactionYN=<%=newTransactionYN%>&called_from_mothercare=<%=called_from_mothercare%>&mother_patient_id=<%=mother_patient_id%>&ca_encounter_id=<%=ca_encounter_id%>&ip_install_yn=<%=ip_install_yn%>&siteId=<%=siteId%>&mother_pat_id=<%=motherid%>&isNewBornChngsAppl=<%=isNewBornChngsAppl%>"  name="newbornmain_frame" scrolling="auto" noresize >
			<%}%>
			<frame  src="../../eMP/jsp/NewbornRegistrationDetails.jsp?mother_id=<%=motherid%>&function_id=<%=function_id%>&function_id_new=REGISTER_NEWBORN&encounter_id=<%=encounterid%>&nursing_unit=<%=nursingunitcode%>&patient_id_length=<%=patientidlength%>&inhouse_birth_yn=<%=inhousebirthyn%>&new_born_pat_ser_grp=<%=newbornpatsergrp%>&nb_use_mother_ser=<%=nb_use_mother_ser%>&accessRights=<%=accessRights%>&parent_details=<%=parent_details%>&function_invoked=<%=function_invoked%>&module_invoked=<%=module_invoked%>&mother_nursing_unit=<%=mother_nursing_unit%>&mother_bed_no=<%=mother_bed_no%>&function_name=<%=function_name%>&invoke_adm_from_newborn_yn=<%=invoke_adm_from_newborn_yn%>&disable_button_yn=<%=disable_button_yn%>&invoked_from=<%=invoked_from%>&calling_module_id=<%=calling_module_id%>&exceedMaxBirthYN=<%=exceedMaxBirthYN%>&newTransactionYN=<%=newTransactionYN%>&called_from_mothercare=<%=called_from_mothercare%>&mother_patient_id=<%=mother_patient_id%>&ca_encounter_id=<%=ca_encounter_id%>&siteId=<%=siteId%>&isNewBornChngsAppl=<%=isNewBornChngsAppl%>" name="newborndtls_frame" scrolling="auto" noresize>

		</frameset>*/</script>
		</body>
	</html>

