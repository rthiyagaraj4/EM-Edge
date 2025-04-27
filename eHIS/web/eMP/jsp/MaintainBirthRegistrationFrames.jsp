<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
<head></head>
<%
		request.setCharacterEncoding("UTF-8");
		String child_id = request.getParameter("child_id")==null?"": request.getParameter("child_id");
		String function_id = request.getParameter("function_id") ;
		if(function_id == null)function_id = "" ;
        String locale =((String)session.getAttribute("LOCALE"));
		String accessRights = request.getParameter("accessRights");
		if( accessRights == null) accessRights="";
		String inhousebirthyn					= "Y";

		/*
		String nb_use_mother_ser			="";
		String alt_id_type_desc			="";
		String unitofwtnb							= "";
		String unitofcircumnb					= "";
		String unitofchestunit				= "";//added by sen on 9/08/2004
		String unitoflengthnb					= "";
		String unitofgestnb						= "";
		String namesuffixmalenb			= "";
		String namesuffixfemalenb		= "";
		String patientidlength					= "";
		String newbornpatsergrp			= "";
		String patient_id_length			= "";
		String allownbregnwithindays	= "";
		*/

		String encounterid						= "";
		String nursingunitcode				= ""; 		
		
		String Facility_Id = (String) session.getValue("facility_id");
		Connection con = null;
		PreparedStatement pstmt	= null;
		ResultSet rset		= null;
		String ip_install_yn ="";

		try
		{
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement("select install_yn from sm_module where module_id = 'IP'");
			rset = pstmt.executeQuery();
			if (rset!=null && rset.next())
			{
				ip_install_yn = rset.getString(1);
				if (ip_install_yn==null) ip_install_yn = "";
			}
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
		}
		catch(Exception ex)
		{
			out.println(ex.toString());
		}
	try{		
		if (ip_install_yn.equals("Y"))
		{
			StringBuffer sql1 = new StringBuffer("Select a.encounter_id, a.nursing_unit_code, b.long_desc Nursing_Unit_Short_Desc from IP_OPEN_ENCOUNTER a, ip_nursing_unit_lang_vw b where a.facility_id='"+Facility_Id+"' and a.Patient_Id = '"+child_id+"' and a.facility_id = b.facility_id and a.NURSING_UNIT_CODE = b.NURSING_UNIT_CODE and b.language_id='"+locale+"'");
			pstmt	= con.prepareStatement(sql1.toString());
			sql1.setLength(0);
			rset	= pstmt.executeQuery();
			if(rset!=null && rset.next())
			{
				encounterid			= rset.getString("encounter_id")==null?"":rset.getString("encounter_id");
				nursingunitcode	= rset.getString("nursing_unit_code")==null?"":rset.getString("nursing_unit_code");
				inhousebirthyn		= "Y";
			}
		}
		if (rset != null) rset.close();
		if (pstmt != null) pstmt.close();

	} catch(Exception e) { 
		out.println(e.toString());
	} finally {
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

	/*
	try{
		String sql =  " select review_nb_links_bef_reg_yn, unit_of_wt_nb, unit_of_circum_nb,unit_of_chest_circum_nb, unit_of_length_nb, unit_of_gest_nb,  name_suffix_male_nb, name_suffix_female_nb,patient_id_length,newborn_pat_ser_grp,  nb_use_mother_ser, patient_id_length, allow_nb_regn_within_days,(select long_desc from mp_alternate_id_type_lang_vw where ALT_ID_TYPE=alt_id1_type and language_id='"+locale+"') alt_id_type_desc from mp_param_lang_vw where language_id='"+locale+"'";	
		pstmt = con.prepareStatement(sql);
		rset = pstmt.executeQuery();
		if(rset!=null && rset.next())
		{
			alt_id_type_desc							= rset.getString("alt_id_type_desc")==null?"":rset.getString("alt_id_type_desc");
			unitofwtnb							= rset.getString("unit_of_wt_nb")==null?"":rset.getString("unit_of_wt_nb");
			unitofcircumnb					= rset.getString("unit_of_circum_nb")==null?"":rset.getString("unit_of_circum_nb");

			unitoflengthnb					= rset.getString("unit_of_length_nb")==null?"":rset.getString("unit_of_length_nb");
			unitofgestnb						= rset.getString("unit_of_gest_nb")==null?"":rset.getString("unit_of_gest_nb");
			patientidlength					= rset.getString("patient_id_length")==null?"":rset.getString("patient_id_length");
			namesuffixmalenb			= rset.getString("name_suffix_male_nb")==null?"":rset.getString("name_suffix_male_nb");
			namesuffixfemalenb		= rset.getString("name_suffix_female_nb")==null?"":rset.getString("name_suffix_female_nb");
			newbornpatsergrp			= rset.getString("newborn_pat_ser_grp")==null?"":rset.getString("newborn_pat_ser_grp");
			nb_use_mother_ser			=			rset.getString("nb_use_mother_ser")==null?"N":rset.getString("nb_use_mother_ser");
			allownbregnwithindays	= rset.getString("allow_nb_regn_within_days")==null?"":rset.getString("allow_nb_regn_within_days");
			patient_id_length		= rset.getString("patient_id_length");
			unitofchestunit = rset.getString("unit_of_chest_circum_nb")==null?"":rset.getString("unit_of_chest_circum_nb");//aded by sen 0n 9/08/2004			
		}
		if (rset != null) rset.close();
		if (pstmt != null) pstmt.close();
	}catch(Exception e) { out.println(e.toString());}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	*/
%>
		
	<iframe src="../../eCommon/jsp/pline.jsp?Patient_ID=<%=child_id%>" name="motherline_frame" scrolling="no" style="height:10vh;width:99vw;border:0"></iframe>
	<iframe  src="../../eMP/jsp/NewbornRegistrationHeader.jsp?mother_id=<%=child_id%>&function_id=<%=function_id%>&function_id_new=MAINTAIN_BIRTH&chd_id=<%=child_id%>" resize="no"  name="newbornheader_frame" scrolling="no" noresize style='height:7vh;width:99vw;border:0'></iframe>
	<iframe src="../jsp/NewbornRegistrationMain.jsp?mother_id=<%=child_id%>&function_id=<%=function_id%>&function_id_new=MAINTAIN_BIRTH&encounter_id=<%=encounterid%>&nursing_unit=<%=nursingunitcode%>		&inhouse_birth_yn=<%=inhousebirthyn%>&accessRights=<%=accessRights%>" name="newbornmain_frame" scrolling="auto" noresize style="height:73vh;width:99vw;border:0"></iframe>
	
</html>

