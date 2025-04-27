<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager" %>	
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
    <head>	 
        <link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
        <Script language="JavaScript" src="../../eCommon/js/common.js"></Script>
		<Script language="JavaScript" src="../../eMP/js/SmartCard.js"></Script>
		<Script language="JavaScript"src="../../eCommon/js/DateUtils.js" ></Script>
		<!--Added by Ashwini on 14-May-2019 for TBMC-CRF-0010.1-->
		<Script language="JavaScript" src="../../eMP/js/EmployeePrivilege.js"></Script>
		<Script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></Script>
		<%
	
		if(session.getValue("smart_path")!= null) {
			if(!session.getValue("smart_path").equals(" ")){
				out.println(session.getValue("smart_path"));
			}
		}
		%>			
		<Script src="../../eMP/js/json02.js"></Script>
		<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>	
		<%
	
	if(session.getValue("sekure_ws_yn")!= null) {
		if(session.getValue("sekure_ws_yn").equals("Y")){
			out.println("<script src='http://localhost:9996/api/files/Sekure.js'></script>");
		}
	}
	%>
		<Script language="JavaScript"src="../../eCommon/js/dchk.js" ></Script>
        <Script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
        <Script language='javascript' src='../../eMP/js/PatientRegistration.js'></Script>
        <Script language='javascript' src='../../eMP/js/PatientRegistration1.js'></Script>
        <Script language='javascript' src='../../eMP/js/PatientRegistration2.js'></Script>
        <Script language='javascript' src='../../eMP/js/PatientRegistration3.js'></Script>
         <script language='javascript' src='../../eMP/js/EmergRegn.js'></script> 
		<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></Script>
		<Script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
		<Script language="JavaScript" src="../../eAE/js/AERegisterAttn.js"></Script>




        
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");		
		Connection con				= null;
		PreparedStatement pstmt		= null;
        PreparedStatement pstmt1	= null;
		ResultSet rset				= null;		
		
		String name_dervn_logic_oth_lang = "" ;	
		String name_drvn_logic_oth_lang_long = "" ;	
		String name_dervn_logic = "" ;	
		String name_drvn_logic_long = "" ;	
		String patient_id_length = "" ;	
		String accept_national_id_no_yn			= "N";
		String nat_id_accept_alphanumeric_yn	= "N";
		String alt_id1_accept_oth_pat_ser_yn	= "N"; 
		String alt_id1_accept_alphanumeric_yn	= "N";
		String max_pat_age						= "";
		String dflt_nationality					= "";
		String default_race_code				= "";
		String gen_slno_unknown_pat_yn			= "";
		String maintain_doc_or_file			= "";
		String emer_blng_grp_id				= "";
		String transaction_continue			= "Y";
		String setlmt_ind					= "";
		String create_file_at_pat_regn_yn	= "";
		String ext_system_interface_yn		= "";
		String nat_data_source_id		= "";
		String dfltPSG						= "";
		String org_member_relationship_desc	= "";
		String family_org_id_accept_yn="";
		String org_member_relationship_code="";
		String entitlement_by_pat_cat_yn="";
		String pat_category_reqd_yn=""; //Added by Suji keerthi on 04-Dec-2019 for KDAH-CRF-0522
		String alt_id1_unique_yn="";
		String alt_id2_unique_yn="";
		String emeg_pat_ser_grp				= "";
		String gen_pat_ser_grp				= "";
		String dflt_grp				= "";
		String alt_id1_desc = "";
		String alt_id2_desc = "";
		String alt_id3_desc = "";
		String alt_id4_desc = "";
		String Site	 	= "";
		/* added by mujafar for ML-MMOH-CRF-524.1 START	*/
		String alt_id1_alphanum_validate_yn = "N" ; 
		String alt_id2_alphanum_validate_yn = "N" ;
		String alt_id3_alphanum_validate_yn = "N" ;
		String alt_id4_alphanum_validate_yn = "N" ; 
		/* added by mujafar for ML-MMOH-CRF-524.1 END	*/

		/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] Start */
		String alt_id2_accept_oth_pat_ser_yn		= "";
		String alt_id2_accept_alphanumeric_yn		= "";

		/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] End */

		String function_name =""; //Added by Ashwin K for AAKH-CRF-0150
		String pat_series =""; //Added by Ashwin K for AAKH-CRF-0150

		alt_id1_desc=request.getParameter("alt_id1_desc");		
		alt_id2_desc=request.getParameter("alt_id2_desc");		
		alt_id3_desc=request.getParameter("alt_id3_desc");		
		alt_id4_desc=request.getParameter("alt_id4_desc");		
		name_dervn_logic_oth_lang=request.getParameter("name_dervn_logic_oth_lang");		
		name_drvn_logic_oth_lang_long=request.getParameter("name_dervn_logic_oth_lang_long");		
		name_dervn_logic=request.getParameter("name_dervn_logic");
		name_drvn_logic_long=request.getParameter("name_drvn_logic_long");
		patient_id_length=request.getParameter("patient_id_length");
		accept_national_id_no_yn=request.getParameter("accept_national_id_no_yn");
		nat_id_accept_alphanumeric_yn=request.getParameter("nat_id_accept_alphanumeric_yn");
		alt_id1_accept_oth_pat_ser_yn=request.getParameter("alt_id1_accept_oth_pat_ser_yn");
		alt_id1_accept_alphanumeric_yn=request.getParameter("alt_id1_accept_alphanumeric_yn");
		/* added by mujafar for ML-MMOH-CRF-524.1 START */	
		alt_id1_alphanum_validate_yn = request.getParameter("alt_id1_alphanum_validate_yn");
		alt_id2_alphanum_validate_yn = request.getParameter("alt_id2_alphanum_validate_yn");
		alt_id3_alphanum_validate_yn = request.getParameter("alt_id3_alphanum_validate_yn");
		alt_id4_alphanum_validate_yn = request.getParameter("alt_id4_alphanum_validate_yn");
		 /* added by mujafar for ML-MMOH-CRF-524.1 END */	
		max_pat_age=checkForNull(request.getParameter("max_pat_age"));
		dflt_nationality=request.getParameter("dflt_nationality");
		default_race_code=request.getParameter("default_race_code");
		gen_slno_unknown_pat_yn=request.getParameter("gen_slno_unknown_pat_yn");
		maintain_doc_or_file=request.getParameter("maintain_doc_or_file");
		create_file_at_pat_regn_yn=request.getParameter("create_file_at_pat_regn_yn");
		ext_system_interface_yn=request.getParameter("ext_system_interface_yn");
		nat_data_source_id=request.getParameter("nat_data_source_id");
		family_org_id_accept_yn=request.getParameter("family_org_id_accept_yn");
		org_member_relationship_code=request.getParameter("org_member_relationship_code");
		entitlement_by_pat_cat_yn=request.getParameter("entitlement_by_pat_cat_yn");
		pat_category_reqd_yn=request.getParameter("pat_category_reqd_yn"); //Added by Suji keerthi on 04-Dec-2019 for KDAH-CRF-0522
		alt_id1_unique_yn=request.getParameter("alt_id1_unique_yn");
		alt_id2_unique_yn=request.getParameter("alt_id2_unique_yn");
		emeg_pat_ser_grp=request.getParameter("emeg_pat_ser_grp");
		gen_pat_ser_grp=request.getParameter("gen_pat_ser_grp");
		dflt_grp=request.getParameter("dflt_grp");
		org_member_relationship_desc=checkForNull(request.getParameter("org_member_relationship_desc"));
		Site=request.getParameter("Site");	
		
		/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] Start */
		alt_id2_accept_oth_pat_ser_yn			= checkForNull(request.getParameter("alt_id2_accept_oth_pat_ser_yn"),"N");
		alt_id2_accept_alphanumeric_yn			= checkForNull(request.getParameter("alt_id2_accept_alphanumeric_yn"),"N");

		/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] End */

		con = ConnectionManager.getConnection(request);		
		String called_from = request.getParameter("called_from");		 
		if(called_from == null || called_from.equals("null")) called_from = "N";
			
		String flag = request.getParameter("emerg_reg");
		if(flag == null || flag.equals("null")) flag = "N";
		String operation = "";
		String func_act = request.getParameter("func_act");
		if(func_act == null || func_act.equals("")) operation = "Generate_File";
		else operation = "insert";
			
		String bl_install_yn = (String)session.getValue("mp_bl_oper_yn");
		
		String dflt_pat_regn_blng_class		= "";
       
		
			
		String a_national_id_no = request.getParameter("National_Id_No");
		if(a_national_id_no == null || a_national_id_no.equals("null")) a_national_id_no = "";
		String a_alt_id1_no = request.getParameter("a_alt_id1_no");
		if(a_alt_id1_no == null || a_alt_id1_no.equals("null")) a_alt_id1_no = "";

		String a_first_name  = request.getParameter("First_Name");
		if(a_first_name == null) a_first_name = "";
            
		String a_second_name = request.getParameter("Second_Name");
		if(a_second_name== null)a_second_name = "";
            
		String a_third_name  = request.getParameter("Third_Name");
		if(a_third_name == null)a_third_name = "";
		/*Added By Dharma on 20th Aug 2020 against ML-MMOH-SCF-1384*/
		String a_gender  = request.getParameter("Sex");
		if(a_gender == null)a_gender = "";
		if(a_gender.equals("A")){
			a_gender	= "";
		}
		//Added By Dharma on 20th Aug 2020 against ML-MMOH-SCF-1384
		String a_race_code  = request.getParameter("race_code");
		if(a_race_code == null)a_race_code = "";
		String a_date_of_birth	= ""; //Added by Ashwin K for AAKH-CRF-0150
		String a_family_name = request.getParameter("Family_Name");
		if(a_family_name == null || a_family_name.equals("null")) a_family_name = "";
		if(a_family_name.length() >= 1)
		{
			int ch = a_family_name.charAt(0);
			if((ch >= 65 && ch <= 90) || (ch >= 97) && ch <= 122)
			{
				a_family_name = (a_family_name.substring(0,1)).toUpperCase() + a_family_name.substring(1);
			}
			
		}
					
		if(bl_install_yn.equals("Y"))
		{
			pstmt = con.prepareStatement("SELECT a.emer_blng_grp_id,a.dflt_pat_regn_blng_class, b.settlement_ind FROM bl_mp_param a, bl_blng_grp b WHERE b.blng_grp_id = a.emer_blng_grp_id");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				emer_blng_grp_id			= rset.getString(1);
				dflt_pat_regn_blng_class = rset.getString(2) == null ? "" : rset.getString(2);
				setlmt_ind					= rset.getString(3);				
				if(setlmt_ind == null) setlmt_ind = "";
				if(emer_blng_grp_id == null) emer_blng_grp_id = "";
				if(!emer_blng_grp_id.equals("")) transaction_continue = "Y";
				else transaction_continue = "N";
			} else {
				transaction_continue = "N";
			}
			if(rset != null) rset.close();
			if(pstmt != null) pstmt.close();
		}
			/*
				This query is merged with the Above Query
				if(bl_install_yn.equals("Y"))
				{
					sql_bl	= "SELECT dflt_pat_regn_blng_class FROM bl_mp_param";
					stmt_bl	= con.prepareStatement(sql_bl);
					rs_bl	= stmt_bl.executeQuery();
					if(rs_bl != null)
					{
						while(rs_bl.next())
						{
							dflt_pat_regn_blng_class = rs_bl.getString(1) == null ? "" : rs_bl.getString(1);
						}
					}
					if(rs_bl != null) rs_bl.close();
					if(stmt_bl != null) stmt_bl.close();
				}
			*/	
		
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat ("dd/MM/yyyy");
        
        String gen_pat_id_yn = "N";	
		ResultSet rs				= null;
        String sysdate = formatter.format(dt);		
		

		// This array building is now handled in PatNamesComp.jsp
       /* ArrayList arrayList2 = new ArrayList();
		arrayList2 = eMP.ChangePatientDetails.getResultRows(con,"mp_name_prefix",p);
		int a = 0;
		out.println("<script>");
		for(int i=0;i<arrayList2.size();i+=3) 
		{
			out.print("NamePrefixArray["+a+"]=escape(\""+(String)arrayList2.get(i)+"\");");
			out.print("NamePrefixLocArray["+a+"]=escape(\""+(String)arrayList2.get(i+1)+"\");");
			out.print("PrefixSexArray["+a+"]=escape(\""+(String)arrayList2.get(i+2)+"\");");				
			a++;
		} 
		out.println("</script>");
		arrayList2.clear();
		arrayList2 = eMP.ChangePatientDetails.getResultRows(con,"mp_name_suffix2",p);
		
		out.println("<script>");
		a = 0;
		for(int i=0;i<arrayList2.size();i+=3) 
		{
			out.print("NameSuffixArray["+a+"]=escape(\""+(String)arrayList2.get(i)+"\");");
			out.print("NameSuffixLocArray["+a+"]=escape(\""+(String)arrayList2.get(i+1)+"\");");
			out.print("SuffixSexArray["+a+"]=escape(\""+(String)arrayList2.get(i+2)+"\");");				
			a++;
		} 
		out.println("</script>");*/
		try
		{	
				
			pstmt1 = con.prepareStatement("SELECT nvl(pat_ser_grp_code, '') pat_ser_grp_code, nvl(gen_pat_id_yn,'N') gen_pat_id_yn FROM mp_pat_ser_grp WHERE id_type NOT IN ('X', 'R') ");
			rs = pstmt1.executeQuery();
            if(rs != null)
            {
                int k = 0;
                out.println("<script>");
				while(rs.next())
                {
					if(dflt_grp.equals(rs.getString(1)))
					{
						gen_pat_id_yn = rs.getString(2);
					}					
					out.println("PSGCodeArray["+k+"]=\""+rs.getString(1)+"\";");
					out.println("PSGYNArray["+k+"]=\""+rs.getString(2)+"\";");
					k++;
				}
				out.println("</script>");
            }
	 if(rs != null) rs.close();
          if(pstmt1 != null) pstmt1.close();
		//Added by Ashwin K for AAKH-CRF-0150	
		//for smart card
		pstmt1 = con.prepareStatement("select VALUE_1,nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID");
		rs = pstmt1.executeQuery();	
		if(rs!=null && rs.next())
			{
			function_name=rs.getString("VALUE_2");   // alkhaleej smart card
			}	
			 if(rs != null) rs.close();
          	  if(pstmt1 != null) pstmt1.close();

		pstmt1 = con.prepareStatement("select PAT_SER_GRP_CODE from MP_PAT_SER_GRP where DEFAULT_YN = 'Y'");
		rs = pstmt1.executeQuery();	
		if(rs!=null && rs.next())
			{
			pat_series=rs.getString(1);   // alkhaleej smart card
			}	


			 if(rs != null) rs.close();
          	  if(pstmt1 != null) pstmt1.close();
		//Ended by Ashwin K for AAKH-CRF-0150           
			%>
	        <script>
				if (parent.frames[0].document.getElementById("patient_id"))
				    parent.frames[0].document.getElementById("patient_id").maxLength =" <%=patient_id_length%>";					
			</script>
		</head>
				

		<body onSelect="codeArrestThruSelect()" OnMouseDown="CodeArrest()" onKeyDown='lockKey()'  onload='change_status_emer();chkDetailsUnknown();'>
			<form name="Emergency_Regn" id="Emergency_Regn" action="../../servlet/eMP.PatientRegistrationServlet" method="post" target="messageFrame">
				<input type='hidden' name='flag' id='flag' value='<%=flag%>'>
				<table width='100%' cellpadding='0' cellspacing='0' border='0'>
					<tr>
						<input type='hidden' name='called_from' id='called_from' value='<%=called_from%>'>
	                    <td class='label' nowrap width='10%'><fmt:message key="Common.detailsunknown.label" bundle="${common_labels}"/></td>
		                <td colspan='8'>
						<%if(flag.equals("Y")){%>
						<input type='checkbox' name='details_unknown' id='details_unknown' value='N' disabled>
						<%}else if(called_from.equals("AE") || called_from.equals("MO_BID_REGN") || called_from.equals("MO_EBP_REGN")){%> <!--Modified by Thamizh selvi on 24th July 2017 for ML-MMOH-CRF-0689-->
						<input type='checkbox' name='details_unknown' id='details_unknown' value='Y' checked disabled>
						<%}else{%>
						<input type='checkbox'  checked name='details_unknown' id='details_unknown' value='Y' onclick='chkDetailsUnknown()' tabindex='-1'>
						<%}%>
				    </tr>
					<tr><td colspan='8' class='white'>&nbsp;</td></tr>
				</table>
				<input type='hidden' name='accept_national_id_no' id='accept_national_id_no' value="<%=accept_national_id_no_yn%>">
				<input type='hidden' name='alt_id1_accept_oth_pat_ser_yn' id='alt_id1_accept_oth_pat_ser_yn' value="<%=alt_id1_accept_oth_pat_ser_yn%>">
				<input type='hidden' name='alt_id1_accept_alphanumeric_yn' id='alt_id1_accept_alphanumeric_yn' value="<%=alt_id1_accept_alphanumeric_yn%>">
			<!--  added by mujafar for ML-MMOH-CRF-524.1 start -->	
			<input type='hidden' name='alt_id1_alphanum_validate_yn' id='alt_id1_alphanum_validate_yn' value="<%=alt_id1_alphanum_validate_yn%>" >
			<input type='hidden' name='alt_id2_alphanum_validate_yn' id='alt_id2_alphanum_validate_yn' value="<%=alt_id2_alphanum_validate_yn%>">
			<input type='hidden' name='alt_id3_alphanum_validate_yn' id='alt_id3_alphanum_validate_yn' value="<%=alt_id3_alphanum_validate_yn%>">
			<input type='hidden' name='alt_id4_alphanum_validate_yn' id='alt_id4_alphanum_validate_yn' value="<%=alt_id4_alphanum_validate_yn%>">
				<!-- added by mujafar for ML-MMOH-CRF-524.1 end -->
				<input type='hidden' name='max_patient_age' id='max_patient_age' value="<%=max_pat_age%>">
				<input type ='hidden' name='family_org_id_accept_yn' id='family_org_id_accept_yn' value="<%=family_org_id_accept_yn%>"></input>
				<input type ='hidden' name='entitlement_by_pat_cat_yn' id='entitlement_by_pat_cat_yn' value="<%=entitlement_by_pat_cat_yn%>"></input>
				<!-- Below Added by Suji keerthi on 04-Dec-2019 for KDAH-CRF-0522 -->
				<input type ='hidden' name='pat_cat_reqd_yn' id='pat_cat_reqd_yn' value="<%=pat_category_reqd_yn%>"></input>
				<input type ='hidden' name='org_member_relationship_code' id='org_member_relationship_code' value="<%=org_member_relationship_code%>"></input>
				<input type ='hidden' name='org_member_relationship_desc' id='org_member_relationship_desc' value="<%=org_member_relationship_desc%>"></input>

				<!--Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] Start -->
				<input type="hidden" name="alt_id2_accept_oth_pat_ser_yn" id="alt_id2_accept_oth_pat_ser_yn" value="<%=alt_id2_accept_oth_pat_ser_yn%>" />
				<input type="hidden" name="alt_id2_accept_alphanumeric_yn" id="alt_id2_accept_alphanumeric_yn" value="<%=alt_id2_accept_alphanumeric_yn%>" /> 
				<!--Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] End -->
			
				<%				
				dfltPSG =gen_pat_ser_grp;
				if(dfltPSG == null) dfltPSG = "";
				%>
				
			<!-- Added by Ashwin K for AAKH-CRF-0150-->
			<% if(function_name.equals("01"))
			{
				try
				{
					if(session.getAttribute("smart_data") != null)
					{
						String smartdata = (String)session.getAttribute("smart_data");
						String smartdata_arr[] = smartdata.split("!~");
						a_national_id_no = smartdata_arr[0];
						//a_oth_contact_no = smartdata_arr[1];
						a_first_name = smartdata_arr[2];
						a_second_name =  smartdata_arr[3];
						a_third_name = smartdata_arr[4];
						//a_name_prefix = smartdata_arr[5];
						a_family_name = smartdata_arr[6];
						a_gender = smartdata_arr[7];
						a_date_of_birth = smartdata_arr[8];
						//alt_addr_line1 = smartdata_arr[9];
						alt_id1_unique_yn =  smartdata_arr[10]; //passport numer
						//a_first_name =  smartdata_arr[11]; //passport exp date
						//dflt_nationality = smartdata_arr[12];
						//a_res_country_desc = smartdata_arr[13];
						//a_first_name = smartdata_arr[14]; //emirates
						dfltPSG = pat_series;

						//to get the nationality code --start

						System.err.println("query ---> select country_code as VALUE_2 from mp_country where long_name = '"+smartdata_arr[12]+"'");
						pstmt1 = con.prepareStatement("select country_code as VALUE_2 from mp_country where long_name = '"+smartdata_arr[12]+"'");
						rs = pstmt1.executeQuery();	
						if(rs!=null && rs.next())
						{
							dflt_nationality=rs.getString("VALUE_2");   // alkhaleej smart card
						}		
						if(rs!=null) rs.close();
						if(pstmt1!=null) pstmt1.close();
						//to get the nationality code --end

					


						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
			
			}  %>
			<!-- Ended by Ashwin K for AAKH-CRF-0150-->
				<table>
					<jsp:include page="../../eMP/jsp/ChangePatientSubNames.jsp" ><jsp:param name="flush" value="true" />
						<jsp:param name="patient_id" value="" />
						<jsp:param name="group" value="G" />
						<jsp:param name="CalledFromFunction" value="EmergencyReg" />
						<jsp:param name="a_family_name" value="<%=a_family_name%>" />
						<jsp:param name="a_gender" value="<%=a_gender%>" />
						<jsp:param name="a_race_code" value="<%=a_race_code%>" />
						<jsp:param name="a_first_name" value="<%=a_first_name%>" />
						<jsp:param name="a_second_name" value="<%=a_second_name%>" />
						<jsp:param name="a_third_name" value="<%=a_third_name%>" />
						<jsp:param name="a_national_id_no" value="<%=a_national_id_no%>" />
						<jsp:param name="flag" value="<%=flag%>" />
						<jsp:param name="dfltPSG" value="<%=dfltPSG%>" />
						<jsp:param name="Site" value="<%=Site%>" />
						<jsp:param name="emeg_pat_ser_grp" value="<%=emeg_pat_ser_grp%>" />
						<jsp:param name="a_nationality_code" value="<%=dflt_nationality%>" />
						<jsp:param name="default_race_code" value="<%=default_race_code%>" />
						<jsp:param name="nat_id_accept_alphanumeric_yn" value="<%=nat_id_accept_alphanumeric_yn%>" />
						<jsp:param name="ApplicableFor" value="<%=called_from%>" />
						<jsp:param name="a_date_of_birth" value="<%=a_date_of_birth%>" />
					</jsp:include>
					</tr><tr></tr><tr></tr>
				</table>	         
				<input type='hidden' name='maintain_doc_or_file' id='maintain_doc_or_file' value="<%=maintain_doc_or_file%>"></input>
				<input type='hidden' name='sStyle' id='sStyle' value="<%=sStyle%>"></input>
				<input type='hidden' name='create_file_at_pat_regn_yn' id='create_file_at_pat_regn_yn' value="<%=create_file_at_pat_regn_yn%>"></input>
				
			<!-- 	<input type="hidden" name="place_of_birth_code" id="place_of_birth_code" > --> 
				<input type="hidden" name="citizen" id="citizen">
				
				<input type='hidden' name='patient_name' id='patient_name' value=""></input>
				<input type='hidden' name='patient_name_loc_lang' id='patient_name_loc_lang' value=""></input>
				<input type='hidden' name='name_drvn_logic' id='name_drvn_logic' value="<%=name_dervn_logic%>">
				<input type='hidden' name='name_drvn_logic_long' id='name_drvn_logic_long' value="<%=name_drvn_logic_long%>">
				<input type='hidden' name='name_drvn_logic_oth_lang' id='name_drvn_logic_oth_lang' value="<%=name_dervn_logic_oth_lang%>">
				<input type='hidden' name='name_drvn_logic_oth_lang_long' id='name_drvn_logic_oth_lang_long' value="<%=name_drvn_logic_oth_lang_long%>">
				<input type='hidden' name='dflt_grp' id='dflt_grp' value="<%=dflt_grp%>"></input>
				<input type='hidden' name='pat_no_gen_yn' id='pat_no_gen_yn' value="<%=gen_pat_id_yn%>"></input>
				<input type='hidden' name='patient_group' id='patient_group' value='G'>
				<input type='hidden' name='patient_name_long' id='patient_name_long' value=""></input>
				<input type='hidden' name='patient_name_loc_lang_long' id='patient_name_loc_lang_long' value=""></input>
				<!-- Comment : The above hidden fields should always be before the code wiche is the below script -->

				<script>
					if("<%=a_national_id_no%>" != '')
					{
						document.forms[0].national_id_no.focus();
					}
					else
					{
						FocusFirstElement();
					}
					putPatientName(document.forms[0].first_name);
				</script>

				<input type='hidden' name='dflt_nationality_code' id='dflt_nationality_code' value="<%=dflt_nationality%>">
				<input type='hidden' name='dflt_pat_regn_blng_class' id='dflt_pat_regn_blng_class' value=<%=dflt_pat_regn_blng_class%>>
				<input type='hidden' name='patient_id' id='patient_id' value=""></input>
				<input type='hidden' name='ServerDate' id='ServerDate' value="<%=sysdate%>"></input>
				<input type='hidden' name='nat_id_val' id='nat_id_val' value='S'>
				<input type='hidden' name='error_alt_no1' id='error_alt_no1' value=''>
				<input type='hidden' name='error_alt_no2' id='error_alt_no2' value="">
				<input type='hidden' name='operation' id='operation' value="<%=operation%>"></input>
				<input type='hidden' name='pat_ser_grpcode' id='pat_ser_grpcode' value=""> 
				<input type='hidden' name='Alt_Id1_Unique_Yn1' id='Alt_Id1_Unique_Yn1' value="<%=alt_id1_unique_yn%>">
				<input type='hidden' name='Alt_Id1_Unique_Yn2' id='Alt_Id1_Unique_Yn2' value="<%=alt_id2_unique_yn%>">
				<input type='hidden' name='function_id' id='function_id' value='EMERG_REG'>
				<input type='hidden' name='func_act' id='func_act' value="<%=func_act%>">
				<input type='hidden' name='alt_exp_date_fromHCS' id='alt_exp_date_fromHCS' value="N"></input>
				<input type='hidden' name='transaction_continue' id='transaction_continue' value="<%=transaction_continue%>">
				<input type='hidden' name='billing_group' id='billing_group' value="<%=emer_blng_grp_id%>">
				<input type='hidden' name='bl_install_yn' id='bl_install_yn' value="<%=bl_install_yn%>">
				<input type='hidden' name='setlmt_ind' id='setlmt_ind' value="<%=setlmt_ind%>">							
				<input type='hidden' name='default_race_code' id='default_race_code' value="<%=default_race_code%>">
				<input type='hidden' name='sflag' id='sflag' value=<%=gen_slno_unknown_pat_yn%>>
				<input type='hidden' name='locale' id='locale' value="<%=locale%>">
				<input type='hidden' name='datasource_id' id='datasource_id' value=""></input>
				<input type='hidden' name='dflt_pat_ser_grp_code' id='dflt_pat_ser_grp_code' value="<%=dflt_grp%>"></input>

				<input type ='hidden' name='altId1Desc' id='altId1Desc' value="<%=alt_id1_desc == null ? "&nbsp;" :alt_id1_desc %>">
				<input type ='hidden' name='altId2Desc' id='altId2Desc' value="<%=alt_id2_desc == null ? "&nbsp;" : alt_id2_desc %>">
				<input type ='hidden' name='altId3Desc' id='altId3Desc' value="<%=alt_id3_desc == null ? "&nbsp;" : alt_id3_desc %>">
				<input type ='hidden' name='altId4Desc' id='altId4Desc' value="<%=alt_id4_desc == null ? "&nbsp;" : alt_id4_desc%>">


				<br><br>
				<%
				if(rs != null) rs.close();
				if(rset != null) rset.close();					
				if(pstmt != null) pstmt.close();				
			}catch(Exception e) {
				e.printStackTrace();		
			} finally {
				ConnectionManager.returnConnection(con,request);
			}
			
			if(flag.equals("Y") || called_from.equals("AE")) {
				%>
				<script>
					document.forms[0].pat_ser_grp_code.disabled = false;
					if('<%=flag%>' == 'Y')
						document.forms[0].pat_ser_grp_code.value = "<%=dfltPSG%>";
					if('<%=called_from%>' == 'AE'){
						document.forms[0].pat_ser_grp_code.value = "<%=emeg_pat_ser_grp%>";
					}
				</script>
				<%
			}

			if(ext_system_interface_yn.equals("Y") && nat_data_source_id.equals("NRIC"))	{ 

				
				%>
				<!-- FOR MYKAD READING -->
				<OBJECT id=Cad style=\"WIDTH: 149px; HEIGHT: 25px\" data=data:application/x-oleobject;base64,6bldI31CwEeRWh+s54i2NAADAABmDwAAlQIAAA== classid=clsid:235DB9E9-427D-47C0-915A-1FACE788B634></OBJECT>
				<OBJECT id=jpndf1 style=\"WIDTH: 192px; HEIGHT: 24px\" data=data:application/x-oleobject;base64,arMlNbqDrEKC9D9p0v5gBQADAADYEwAAewIAAA== classid=clsid:3525B36A-83BA-42AC-82F4-3F69D2FE6005></OBJECT>
				<OBJECT id=jpndf4 style=\"LEFT: 0px; WIDTH: 192px; TOP: 0px; HEIGHT: 24px\" data=data:application/x-oleobject;base64,zUFYb5tV40iaOd6s6vQBygADAADYEwAAewIAAA== classid=clsid:6F5841CD-559B-48E3-9A39-DEACEAF401CA></OBJECT>
				<OBJECT id=gmpcpic style=\"WIDTH: 345px; HEIGHT: 303px\" data=data:application/x-oleobject;base64,2lmqMIeVKU6C6+Ww4x0h3QADAACoIwAAUR8AAA== classid=clsid:30AA59DA-9587-4E29-82EB-E5B0E31D21DD></OBJECT> 
				<!-- FOR MYKAD READING -->
			<% } %>
			</form>
	 <script>
		 document.forms[0].ethnic_group.disabled=false;
		 populateethnicity();
		 document.forms[0].ethnic_group.disabled=true;
	</script>
	</body>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" : inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

