

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.Connection, java.sql.Statement, java.sql.ResultSet, webbeans.eCommon.*, java.util.*, java.text.*, java.net.*" %>
<jsp:useBean id="obj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	String ifCondition = "";
	String locale =((String)session.getAttribute("LOCALE"));
	Hashtable hash	= (Hashtable) obj.parseXMLString( request);
	hash			= (Hashtable) hash.get("SEARCH");
	
	
	ifCondition = (String) hash.get("ifCondition"); 
	String nat_id_no = (String) hash.get("nat_id_no"); 
	if(ifCondition == null || ifCondition.equals("null")) ifCondition = "";
	try{	
		con = ConnectionManager.getConnection(request);
	ResultSet rset				= null; 
	java.sql.Statement stmt		= null; 

	if(ifCondition.equals("forSmartCard"))
	{
		String region			= "";
		String regionval		= "";
		String area_desc		= "";
		String area_code		= "";
		String town_desc		= "";
		String town				= "";
		String concatValues		= "";
		String raceVal		= "";
		String relgnVal		= "";
		String raceCode		= "";
		String rlgnCode		= "";
		String postal_code		= "";
		String postal_desc		= "";

		try
		{
			java.sql.Statement stmt1	= null; 
			ResultSet rset1				= null; 
						
			regionval	= (String) hash.get("regionval");
			town_desc	= (String) hash.get("areaval");
			raceVal	= (String) hash.get("raceVal");
			relgnVal	= (String) hash.get("relgnVal");
			postal_code	= (String) hash.get("postal_code");
						
			if(regionval == null || regionval.equals("null")) regionval = "";
			if(town_desc == null || town_desc.equals("null")) town_desc = "";
			if(raceVal == null || raceVal.equals("null")) raceVal = "";
			if(relgnVal == null || relgnVal.equals("null")) relgnVal = "";
			if(postal_code == null || postal_code.equals("null")) postal_code = "";
						
			stmt = con.createStatement();

			if(!raceVal.equals("") || !relgnVal.equals("")) {

				if(!raceVal.equals("")) {

					raceVal = raceVal.toUpperCase();
					String s = "SELECT race_code FROM mp_race WHERE UPPER(long_desc) = '"+raceVal+"'";
					rset = stmt.executeQuery(s);					
					if(rset != null && rset.next())
					{
						raceCode = rset.getString(1); 
					}

				} 
				
				if(!relgnVal.equals("")) {

					relgnVal = relgnVal.toUpperCase();
					String s = "SELECT relgn_code FROM mp_religion WHERE UPPER(long_desc) = '"+relgnVal+"'";
					rset = stmt.executeQuery(s);
					if(rset != null && rset.next())
					{
						rlgnCode = rset.getString(1); 
					}

				}
				
				concatValues = raceCode+"~"+rlgnCode;
				out.println(concatValues);				

			} else {

				if(!regionval.equals(""))
				{
					regionval = regionval.toUpperCase();
					String s = "SELECT region_code FROM mp_region WHERE UPPER(long_desc) = '"+regionval+"'";
					rset = stmt.executeQuery(s);
					if(rset != null && rset.next())
					{
						region = rset.getString(1); 
					}
				}
				if(rset != null) rset.close();

				if(!town_desc.equals(""))
				{
					town_desc = town_desc.toUpperCase();
					String s1 = "SELECT res_town_code FROM mp_res_town WHERE UPPER(long_desc) = '"+town_desc+"'";
					rset = stmt.executeQuery(s1);
					if(rset != null && rset.next())
					{
						town = rset.getString(1); 
						if(town != null && !town.equals(""))
						{
							stmt1 = con.createStatement();
							String s2 = "SELECT b.long_desc, a.res_area_code FROM mp_res_town a, mp_res_area b WHERE a.res_town_code = '"+town+"' AND a.res_area_code = b.res_area_code";
							rset1 = stmt1.executeQuery(s2);
							if(rset1 != null && rset1.next())
							{
								area_desc = rset1.getString(1); 
								area_code = rset1.getString(2); 
							}
						}
					}
				}
				if(rset != null) rset.close();
				if(!postal_code.equals(""))
				{
					regionval = regionval.toUpperCase();
					String s = "SELECT POSTAL_CODE,SHORT_DESC FROM mp_postal_code WHERE postal_code='"+postal_code+"'";
					rset = stmt.executeQuery(s);
					if(rset != null && rset.next())
					{
						postal_desc = rset.getString("SHORT_DESC"); 
					}
				}
				concatValues = region+"~"+town+"~"+area_desc+"~"+area_code+"~"+postal_desc;
				out.println(concatValues);
				

			}
						
			if(rset != null) rset.close();
			if(rset1 != null) rset1.close();
			if(stmt != null) stmt.close();
			if(stmt1 != null) stmt1.close();
										
			
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		finally
		{
			hash.clear();
			//ConnectionManager.returnConnection(con, request);
		}
	} 
	else 
	{
		java.sql.Statement stmtn	= null;
		ResultSet rset3				= null;

		String step=(String) hash.get("step");
		String id=(String) hash.get("id");
		String oth_id_type=(String) hash.get("oth_id_type");
		String alert_reqd_yn = (String) hash.get("alert_reqd_yn");
		if(step == null) step = "";		
		if(id == null) id="";
		if(oth_id_type == null) oth_id_type="";
		if(alert_reqd_yn == null) alert_reqd_yn="N";
		String objttt="";
		if(step.equals("N")){
			objttt ="national_id_no";
		}else if(step.equals("A1")){
			objttt ="alt_id1_no";
		}else if(step.equals("A2")) {
			objttt ="alt_id2_no";
		}else if(step.equals("A3")) {
			objttt ="alt_id3_no";
		}else if(step.equals("A4")) {
			objttt ="alt_id4_no";
		}else if(step.equals("A5")) {
			objttt ="other_alt_Id";
		}

		String patient_id = "";
		String error_message = "";
		String date_of_birth = "";
		String alt_id1_type = "";
		String alt_id2_type = "";
		String alt_id3_type = "";
		String alt_id4_type = "";
		String disp_prompt="";
		String field_name="";
		String patient_id_detail="";
		String nat_invoke_routine="";
		String nat_data_source_id="";
		String age_in_years  = "";
		String age_in_months = "";
		String age_in_days   = "";
		String sex = "";	
		String patient_id_addresses= "";	
		String place_of_birth_code = "";
		String place_of_birth_desc = "";
		String nat_id_len="";
		String nat_id_check_digit_id="";
		String sql = "";
		String result = "";
		String nat_id_prompt = "";
		String ext_system_interface_yn = "";
		stmtn=con.createStatement();		
		webbeans.op.PatientData patdata = new webbeans.op.PatientData();			
		try{
			if (step.equals("N")) /* To Validate only for National ID */
			{
			//con = ConnectionManager.getConnection(request);
			String sql1 = "select decode('"+step+"','N',nat_id_prompt,'A1',alt_id1_type,'A2',alt_id2_type,'A3',alt_id3_type,'A4',alt_id4_type),alt_id1_type,alt_id2_type,alt_id3_type,alt_id4_type,invoke_routine,nat_data_source_id ,nat_id_length,nat_id_check_digit_id,nat_id_prompt,ext_system_interface_yn from mp_param_lang_vw where module_id='MP' and language_id='"+locale+"'";
			
			rset3=stmtn.executeQuery(sql1);
				 
			if(rset3!= null && rset3.next())
			{
				disp_prompt= rset3.getString(1);
				alt_id1_type= rset3.getString(2);
				alt_id2_type= rset3.getString(3);
				alt_id3_type= rset3.getString(4);
				alt_id4_type= rset3.getString(5);
				nat_invoke_routine= rset3.getString(6);
				nat_data_source_id= rset3.getString(7);
				nat_id_len=rset3.getString("NAT_ID_LENGTH");
				nat_id_prompt=rset3.getString("nat_id_prompt");
				nat_id_check_digit_id=rset3.getString("nat_id_check_digit_id");
				ext_system_interface_yn=rset3.getString("ext_system_interface_yn");
			}
			if(rset3 != null) rset3.close();
				if(disp_prompt==null) disp_prompt="";
				if(alt_id1_type==null) alt_id1_type="";
				if(alt_id2_type==null) alt_id2_type="";
				if(alt_id3_type==null) alt_id3_type="";
				if(alt_id4_type==null) alt_id4_type="";
				if(nat_invoke_routine==null) nat_invoke_routine="";
				if(nat_data_source_id==null) nat_data_source_id="";
				if(nat_id_prompt==null) nat_id_prompt="";
				if(nat_id_check_digit_id==null) nat_id_check_digit_id="";
				if(ext_system_interface_yn==null) ext_system_interface_yn="";

					//if(nat_id_check_digit_id != null && !nat_id_check_digit_id.equals("") && nat_data_source_id.equals("") && ext_system_interface_yn.equals("N"))
					if(nat_id_check_digit_id != null && !nat_id_check_digit_id.equals("") && nat_data_source_id.equals(""))
					{
						sql = "SELECT program_name FROM mp_check_digit_scheme WHERE scheme_id = '"+nat_id_check_digit_id+"' ";
				        rset = stmt.executeQuery(sql);
				        if(rset.next())
				        {
				            nat_id_check_digit_id = rset.getString(1);
				            if(rset != null)  rset.close();

							sql	= "select "+nat_id_check_digit_id+"('"+nat_id_no+"') from dual";
					        rset = stmt.executeQuery(sql);
				            if(rset.next())
								result = rset.getString(1);
				            if(rset != null)  rset.close();
						}
					}
				    if(rset != null)  rset.close();
					if (result.equals("N"))
					{
						%>
						 var msg = getMessage("INVALID_NAT_ID","MP");
						 msg = msg.replace('#','<%=nat_id_prompt%>');
						alert(msg);
						//Maheshwaran K added for the IN:035434 as on 01/10/2012
						//Start
						document.getElementById("national_id_no").value="";
						document.getElementById("national_id_no").focus();
						//End
						<%
					}
		}
		  //Below line modified Query tuning for full table scan [IN:051268]
			 sql="select a.patient_id,a.patient_id||'||'||decode('"+locale+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) ||'||'||a.national_id_no||'||'||a.alt_id1_no||'||'||a.alt_id2_no||'||'||a.alt_id3_no||'||'||a.alt_id4_no||'||'||a.name_prefix||'||'||a.first_name||'||'||a.second_name||'||'||a.third_name||'||'||a.family_name||'||'||a.name_suffix||'||'||a.sex||'||'||to_char(a.date_of_birth,'dd/mm/yyyy')||'||'||a.contact1_no||'||'||a.contact2_no||'||'||a.email_id||'||'||a.nationality_code||'||'||to_char(a.alt_id1_exp_date,'dd/mm/yyyy')||'||'||to_char(a.alt_id2_exp_date,'dd/mm/yyyy') ||'||'||to_char(a.alt_id3_exp_date,'dd/mm/yyyy') ||'||'||to_char(a.alt_id4_exp_date,'dd/mm/yyyy')||'||'|| calculate_age(to_char(a.date_of_birth,'dd/mm/yyyy'),1) ||'||'|| calculate_age(to_char(a.date_of_birth,'dd/mm/yyyy'),2) ||'||'|| calculate_age(to_char(a.date_of_birth,'dd/mm/yyyy'),3)||'||'||a.oth_alt_id_type ||'||'|| a.oth_alt_id_no,b.ADDR1_TYPE    ||'||'||B.ADDR1_LINE1   ||'||'||B.ADDR1_LINE2   ||'||'||B.ADDR1_LINE3   ||'||'||B.ADDR1_LINE4   ||'||'||a.RES_TOWN_CODE ||'||'||a.RES_AREA_CODE ||'||'||B.POSTAL1_CODE||'||'||a.REGION_CODE ||'||'||B.COUNTRY1_CODE||'||'||B.CONTACT1_NAME ||'||'||B.INVALID1_YN ||'||'||B.ADDR2_TYPE    ||'||'||B.ADDR2_LINE1   ||'||'||B.ADDR2_LINE2   ||'||'||B.ADDR2_LINE3   ||'||'||B.ADDR2_LINE4   ||'||'||B.RES_TOWN2_CODE||'||'||B.RES_AREA2_CODE||'||'||B.REGION2_CODE||'||'||B.POSTAL2_CODE  ||'||'||B.COUNTRY2_CODE ||'||'||B.CONTACT2_NAME ||'||'||B.INVALID2_YN    ||'||'||B.ADDR3_TYPE    ||'||'||B.ADDR3_LINE1   ||'||'||B.ADDR3_LINE2   ||'||'||B.ADDR3_LINE3   ||'||'||B.ADDR3_LINE4   ||'||'||B.POSTAL3_CODE  ||'||'||B.COUNTRY3_CODE ||'||'||B.CONTACT3_NAME ||'||'||B.INVALID3_YN   ||'||'||B.ADDR4_TYPE    ||'||'||B.ADDR4_LINE1   ||'||'||B.ADDR4_LINE2   ||'||'||B.ADDR4_LINE3   ||'||'||B.ADDR4_LINE4   ||'||'||B.POSTAL4_CODE  ||'||'||B.COUNTRY4_CODE ||'||'||B.CONTACT4_NAME ||'||'||B.INVALID4_YN   ||'||'||B.ADDR5_TYPE    ||'||'||B.ADDR5_LINE1   ||'||'||B.ADDR5_LINE2   ||'||'||B.ADDR5_LINE3   ||'||'||B.ADDR5_LINE4   ||'||'||B.POSTAL5_CODE  ||'||'||B.COUNTRY5_CODE ||'||'||B.CONTACT5_NAME    from mp_patient a ,mp_pat_addresses b where a.patient_id = b.patient_id(+) AND a.patient_id BETWEEN NVL ('%%','%%')  AND NVL ('',a.patient_id) AND a.patient_id LIKE '%%'";
			
			if(step.equals("N")){
				sql=sql+" and  a.national_id_no='"+id+"' ";
				field_name = "national_id_no";
			}
			else if(step.equals("A1")){
				sql=sql+" and  a.alt_id1_no='"+id+"' ";
				field_name = "alt_id1_no";
			}
			else if(step.equals("A2")){
				sql=sql+" and  a.alt_id2_no='"+id+"' ";
				field_name = "alt_id2_no";
			}
			else if(step.equals("A3")){
				sql=sql+" and  a.alt_id3_no='"+id+"' ";
				field_name = "alt_id3_no";
			}
			else if(step.equals("A4")){
				sql=sql+" and  a.alt_id4_no='"+id+"' ";
				field_name = "alt_id4_no";
			}
			else if(step.equals("A5")){
				sql=sql+" and  a.oth_alt_id_no='"+id+"' and  a.oth_alt_id_type = '"+oth_id_type+"' ";
				field_name = "other_alt_Id";
			}
			
			
			rset3=stmtn.executeQuery(sql);
			int natIdDataCount=0;
			int extNatIdDataCount=0;
			if(rset3!= null){
				while(rset3.next()){
					patient_id = rset3.getString(1);
					patient_id_detail = rset3.getString(2);
					patient_id_addresses = rset3.getString(3);
					natIdDataCount++;
				}
			}
			if(rset3 != null) rset3.close();
			if(natIdDataCount==0 && step.equals("N")){
				//sql="select ehis_pat_id patient_id,ehis_pat_id||'||'||''/*patient Name*/ ||'||'||national_id_no||'||'||alt_id1_no||'||'||''/*alt_id2_no*/||'||'||''/*a.alt_id3_no*/||'||'||''/*a.alt_id4_no*/||'||'||name_prefix||'||'||first_name||'||'||second_name||'||'||third_name||'||'||family_name||'||'||name_suffix||'||'||gender/*a.sex*/||'||'||to_char(date_of_birth,'dd/mm/yyyy')||'||'||''/*a.contact1_no*/||'||'||''/*a.contact2_no*/||'||'||''/*a.email_id*/||'||'||nationality_code||'||'||to_char(alt_id1_exp_date,'dd/mm/yyyy')||'||'||''/*to_char(a.alt_id2_exp_date,'dd/mm/yyyy')*/ ||'||'||''/*to_char(a.alt_id3_exp_date,'dd/mm/yyyy')*/ ||'||'||''/*to_char(a.alt_id4_exp_date,'dd/mm/yyyy')*/||'||'|| calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),1) ||'||'|| calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),2) ||'||'|| calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),3)||'||'||''/*a.oth_alt_id_type*/ ||'||'|| ''/*a.oth_alt_id_no*/,''/*b.ADDR1_TYPE**/   ||'||'||RES_ADDR_LINE_1   ||'||'||RES_ADDR_LINE_2   ||'||'||RES_ADDR_LINE_3   ||'||'||RES_ADDR_LINE_4   ||'||'||RES_TOWN_CODE ||'||'||RES_AREA_CODE ||'||'||RES_POSTAL_CODE||'||'||RES_REGION_CODE ||'||'||RES_COUNTRY_CODE||'||'||''/*B.CONTACT1_NAME*/ ||'||'||''/*B.INVALID1_YN*/ ||'||'||''/*B.ADDR2_TYPE */   ||'||'||''/*B.ADDR2_LINE1*/   ||'||'||''/*B.ADDR2_LINE2*/   ||'||'||''/*B.ADDR2_LINE3*/   ||'||'||''/*B.ADDR2_LINE4 */  ||'||'||''/*B.RES_TOWN2_CODE*/||'||'||''/*B.RES_AREA2_CODE*/||'||'||''/*B.REGION2_CODE*/||'||'||''/*B.POSTAL2_CODE*/  ||'||'||''/*B.COUNTRY2_CODE*/ ||'||'||''/*B.CONTACT2_NAME*/ ||'||'||''/*B.INVALID2_YN*/    ||'||'||''/*B.ADDR3_TYPE*/    ||'||'||''/*B.ADDR3_LINE1*/   ||'||'||''/*B.ADDR3_LINE2*/   ||'||'||''/*B.ADDR3_LINE3*/   ||'||'||''/*B.ADDR3_LINE4*/   ||'||'||''/*B.POSTAL3_CODE*/  ||'||'||''/*B.COUNTRY3_CODE*/ ||'||'||''/*B.CONTACT3_NAME*/ ||'||'||''/*B.INVALID3_YN*/   ||'||'||''/*B.ADDR4_TYPE*/    ||'||'||''/*B.ADDR4_LINE1*/   ||'||'||''/*B.ADDR4_LINE2/   ||'||'||''/*B.ADDR4_LINE3*/   ||'||'||''/*B.ADDR4_LINE4*/   ||'||'||''/*B.POSTAL4_CODE*/  ||'||'||''/*B.COUNTRY4_CODE*/ ||'||'||''/*B.CONTACT4_NAME*/ ||'||'||''/*B.INVALID4_YN*/   ||'||'||''/*B.ADDR5_TYPE*/    ||'||'||''/*B.ADDR5_LINE1*/   ||'||'||''/*B.ADDR5_LINE2*/   ||'||'||''/*B.ADDR5_LINE3*/   ||'||'||''/*B.ADDR5_LINE4*/   ||'||'||''/*B.POSTAL5_CODE*/  ||'||'||''/*B.COUNTRY5_CODE*/ ||'||'||''/*B.CONTACT5_NAME*/    from xf_person where national_id_no='"+id+"'";
				String xf_personSQL="select NATIONAL_ID_NO,EXT_PAT_ID,EHIS_PAT_ID,ALT_ID1_TYPE,ALT_ID1_NO,TO_CHAR (ALT_ID1_EXP_DATE, 'dd/mm/yyyy')ALT_ID1_EXP_DATE,NAME_PREFIX,FIRST_NAME,SECOND_NAME,THIRD_NAME,FAMILY_NAME,FAMILY_NAME_PREFIX,NAME_SUFFIX,SEX GENDER,to_char(DATE_OF_BIRTH, 'dd/mm/yyyy') DATE_OF_BIRTH,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),1)years,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),2)months,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),3)days,NATIONALITY_CODE,(CASE WHEN NATIONALITY_CODE IS NOT NULL THEN (mp_get_desc.mp_country(NATIONALITY_CODE,'"+locale+"',3)) END ) nationality_desc,RACE_CODE,(CASE WHEN RACE_CODE IS NOT NULL THEN (mp_get_desc.mp_race(RACE_CODE,'"+locale+"',2)) END ) RACE_DESC,RELIGION_CODE, (CASE WHEN RELIGION_CODE IS NOT NULL THEN (mp_get_desc.mp_religion(RELIGION_CODE,'"+locale+"',2)) END ) RELIGION_DESC,RES_ADDR_LINE_1,RES_ADDR_LINE_2,RES_ADDR_LINE_3,RES_ADDR_LINE_4,RES_TOWN_CODE,(CASE WHEN RES_TOWN_CODE IS NOT NULL  THEN (mp_get_desc.mp_res_town(RES_TOWN_CODE,'"+locale+"',2)) END ) RES_TOWN_DESC,RES_AREA_CODE,(CASE WHEN RES_AREA_CODE IS NOT NULL THEN (mp_get_desc.mp_res_area(RES_AREA_CODE,'"+locale+"',2)) END ) RES_AREA_DESC,RES_REGION_CODE,(CASE WHEN RES_REGION_CODE IS NOT NULL THEN (mp_get_desc.mp_region(RES_REGION_CODE,'"+locale+"',2)) END ) RES_REGION_DESC,RES_POSTAL_CODE,mp_get_desc.mp_postal_code(RES_POSTAL_CODE,'"+locale+"',2) RES_POSTAL_DESC,RES_COUNTRY_CODE, (CASE WHEN RES_COUNTRY_CODE IS NOT NULL THEN (mp_get_desc.mp_country(RES_COUNTRY_CODE,'"+locale+"',1)) END ) RES_COUNTRY_DESC,DECEASED_YN,DOC1_TYPE,(CASE WHEN DOC1_TYPE IS NOT NULL THEN(mp_get_desc.mp_document_type(DOC1_TYPE, '"+locale+"', 2)) END) DOC1_TYPE_DESC,DOC1_NUM,TO_CHAR(DOC1_EXP_DATE, 'DD/MM/YYYY')DOC1_EXP_DATE,DOC1_PLACE_OF_ISSUE,TO_CHAR(DOC1_ISS_DATE, 'DD/MM/YYYY') DOC1_ISS_DATE,STATUS from xf_person where national_id_no='"+id+"'";
				
				if(rset3!=null)rset3.close();
				rset3=stmtn.executeQuery(xf_personSQL);
				if(rset3!= null){
					while(rset3.next()){
						alt_id1_type=rset3.getString("ALT_ID1_TYPE")==null?"":rset3.getString("ALT_ID1_TYPE");
						String alt_id1_no=rset3.getString("ALT_ID1_NO")==null?"":rset3.getString("ALT_ID1_NO");
						String alt_id1_exp_date=rset3.getString("ALT_ID1_EXP_DATE")==null?"":rset3.getString("ALT_ID1_EXP_DATE");
						String name_prefix=rset3.getString("NAME_PREFIX")==null?"":rset3.getString("NAME_PREFIX");
						String first_name=rset3.getString("FIRST_NAME")==null?"":rset3.getString("FIRST_NAME");
						String second_name=rset3.getString("SECOND_NAME")==null?"":rset3.getString("SECOND_NAME");
						String third_name=rset3.getString("THIRD_NAME")==null?"":rset3.getString("THIRD_NAME");
						String family_name=rset3.getString("FAMILY_NAME")==null?"":rset3.getString("FAMILY_NAME");
						String family_name_prefix=rset3.getString("FAMILY_NAME_PREFIX")==null?"":rset3.getString("FAMILY_NAME_PREFIX");
						String name_suffix=rset3.getString("NAME_SUFFIX")==null?"":rset3.getString("NAME_SUFFIX");
						String gender=rset3.getString("GENDER")==null?"":rset3.getString("GENDER");
						date_of_birth=rset3.getString("date_of_birth")==null?"":rset3.getString("date_of_birth");
						String years=rset3.getString("years")==null?"":rset3.getString("years");
						String months=rset3.getString("months")==null?"":rset3.getString("months");
						String days=rset3.getString("days")==null?"":rset3.getString("days");
						String nationality_code=rset3.getString("NATIONALITY_CODE")==null?"":rset3.getString("NATIONALITY_CODE");
						String nationality_desc=rset3.getString("NATIONALITY_DESC")==null?"":rset3.getString("NATIONALITY_DESC");
						String race_code=rset3.getString("RACE_CODE")==null?"":rset3.getString("RACE_CODE");
						String race_desc=rset3.getString("RACE_DESC")==null?"":rset3.getString("RACE_DESC");
//						String religion_code=rset3.getString("RELIGION_CODE")==null?"":rset3.getString("RELIGION_CODE");//checkstyle changes - 35886
	//					String religion_desc=rset3.getString("RELIGION_DESC")==null?"":rset3.getString("RELIGION_DESC");
						String res_addr_line_1=rset3.getString("res_addr_line_1")==null?"":rset3.getString("res_addr_line_1");
						String res_addr_line_2=rset3.getString("res_addr_line_2")==null?"":rset3.getString("res_addr_line_2");
						String res_addr_line_3=rset3.getString("res_addr_line_3")==null?"":rset3.getString("res_addr_line_3");
						String res_addr_line_4=rset3.getString("res_addr_line_4")==null?"":rset3.getString("res_addr_line_4");
						String res_town_code=rset3.getString("RES_TOWN_CODE")==null?"":rset3.getString("RES_TOWN_CODE");
						String res_town_desc=rset3.getString("RES_TOWN_DESC")==null?"":rset3.getString("RES_TOWN_DESC");
						String res_area_code=rset3.getString("RES_AREA_CODE")==null?"":rset3.getString("RES_AREA_CODE");
						String res_area_desc=rset3.getString("RES_AREA_DESC")==null?"":rset3.getString("RES_AREA_DESC");
						String res_region_code=rset3.getString("RES_REGION_CODE")==null?"":rset3.getString("RES_REGION_CODE");
						String res_region_desc=rset3.getString("RES_REGION_DESC")==null?"":rset3.getString("RES_REGION_DESC");
						String res_postal_code=rset3.getString("RES_POSTAL_CODE")==null?"":rset3.getString("RES_POSTAL_CODE");
						String res_postal_desc=rset3.getString("RES_POSTAL_DESC")==null?"":rset3.getString("RES_POSTAL_DESC");
						String res_country_code=rset3.getString("RES_COUNTRY_CODE")==null?"":rset3.getString("RES_COUNTRY_CODE");
						String res_country_desc=rset3.getString("RES_COUNTRY_DESC")==null?"":rset3.getString("RES_COUNTRY_DESC");
		//				String doc1_type=rset3.getString("DOC1_TYPE")==null?"":rset3.getString("DOC1_TYPE");
			//			String doc1_type_desc=rset3.getString("DOC1_TYPE_DESC")==null?"":rset3.getString("DOC1_TYPE_DESC");
				//		String doc1_num=rset3.getString("DOC1_NUM")==null?"":rset3.getString("DOC1_NUM");
					//	String doc1_exp_date=rset3.getString("DOC1_EXP_DATE")==null?"":rset3.getString("DOC1_EXP_DATE");
						//String doc1_place_of_issue=rset3.getString("DOC1_PLACE_OF_ISSUE")==null?"":rset3.getString("DOC1_PLACE_OF_ISSUE");
						//String doc1_iss_date=rset3.getString("DOC1_ISS_DATE")==null?"":rset3.getString("DOC1_ISS_DATE");
						String deceased_yn=rset3.getString("DECEASED_YN")==null?"N":rset3.getString("DECEASED_YN");
						//patient_id = rset3.getString(1)==null?"":rset3.getString(1);
						//patient_id_detail = rset3.getString(2)==null?"":rset3.getString(2);
						//patient_id_addresses = rset3.getString(3)==null?"":rset3.getString(3);
						extNatIdDataCount++;
						%>
						if('<%=deceased_yn%>'=='N'){
							if(document.getElementById("alt_id1_no"))
								document.getElementById("alt_id1_no").value='<%=alt_id1_no%>';
							if(document.getElementById("alt_id1_exp_date"))
								document.getElementById("alt_id1_exp_date").value='<%=alt_id1_exp_date%>';
							if(document.getElementById("name_prefix"))
								document.getElementById("name_prefix").value='<%=name_prefix%>';
							if(document.getElementById("first_name"))
								document.getElementById("first_name").value='<%=first_name%>';
							if(document.getElementById("second_name"))
								document.getElementById("second_name").value='<%=second_name%>';
							if(document.getElementById("third_name"))
								document.getElementById("third_name").value='<%=third_name%>';
							if(document.getElementById("family_name"))
								document.getElementById("family_name").value='<%=family_name%>';
							if(document.getElementById("name_suffix"))
								document.getElementById("name_suffix").value='<%=name_suffix%>';
							if(document.getElementById("sex"))
								document.getElementById("sex").value='<%=gender%>';
							if(document.getElementById("b_age"))
								document.getElementById("b_age").value='<%=years%>';
							if(document.getElementById("b_months"))
								document.getElementById("b_months").value='<%=months%>';
							if(document.getElementById("b_days"))
								document.getElementById("b_days").value='<%=days%>';
							if(document.getElementById("date_of_birth"))
								document.getElementById("date_of_birth").value='<%=date_of_birth%>';
							if(document.getElementById("nationality_desc"))
								document.getElementById("nationality_desc").value='<%=nationality_desc%>';
							if(document.getElementById("nationality_code1"))
								document.getElementById("nationality_code1").value='<%=nationality_code%>';
							if(document.getElementById("race_code"))
								document.getElementById("race_code").value='<%=race_code%>';
							if(document.getElementById("race_desc"))
								document.getElementById("race_desc").value='<%=race_desc%>';
							if(document.forms[0].addr_line1)
								document.forms[0].addr_line1.value='<%=res_addr_line_1%>';
							if(document.forms[0].addr_line2)
								document.forms[0].addr_line2.value='<%=res_addr_line_2%>';
							if(document.forms[0].addr_line3)
								document.forms[0].addr_line3.value='<%=res_addr_line_3%>';
							if(document.forms[0].addr_line4)
								document.forms[0].addr_line4.value='<%=res_addr_line_4%>';
								
							if(document.forms[0].res_town_code)
								document.forms[0].res_town_code.value='<%=res_town_code%>';
							if(document.forms[0].res_town_desc)
								document.forms[0].res_town_desc.value='<%=res_town_desc%>';
							if(document.forms[0].res_area_code)
								document.forms[0].res_area_code.value='<%=res_area_code%>';
							if(document.forms[0].res_area_desc)
								document.forms[0].res_area_desc.value='<%=res_area_desc%>';
							if(document.forms[0].postal_code)
								document.forms[0].postal_code.value='<%=res_postal_code%>';
							if(document.forms[0].r_postal_code_desc)
								document.forms[0].r_postal_code_desc.value='<%=res_postal_desc%>';
							if(document.forms[0].region_code)
								document.forms[0].region_code.value='<%=res_region_code%>';
							if(document.forms[0].region_desc)
								document.forms[0].region_desc.value='<%=res_region_desc%>';
							if(document.forms[0].country_code)
								document.forms[0].country_code.value='<%=res_country_code%>';
							if(document.forms[0].country_desc)
								document.forms[0].country_desc.value='<%=res_country_desc%>';
								putPatientName('');
						}else{
							alert(getMessage('PAT_DECEASED_NOT_ALLOWED','MP'));
							document.getElementById("national_id_no").value=''; 
							if(document.getElementById("alt_id1_no"))
								document.getElementById("alt_id1_no").value='';
							if(document.getElementById("alt_id1_exp_date"))
								document.getElementById("alt_id1_exp_date").value='';
							if(document.getElementById("name_prefix"))
								document.getElementById("name_prefix").value='';
							if(document.getElementById("first_name"))
								document.getElementById("first_name").value='';
							if(document.getElementById("second_name"))
								document.getElementById("second_name").value='';
							if(document.getElementById("third_name"))
								document.getElementById("third_name").value='';
							if(document.getElementById("family_name"))
								document.getElementById("family_name").value='';
							if(document.getElementById("name_suffix"))
								document.getElementById("name_suffix").value='';
							if(document.getElementById("sex"))
								document.getElementById("sex").value='';
							if(document.getElementById("b_age"))
								document.getElementById("b_age").value='';
							if(document.getElementById("b_months"))
								document.getElementById("b_months").value='';
							if(document.getElementById("b_days"))
								document.getElementById("b_days").value='';
							if(document.getElementById("date_of_birth"))
								document.getElementById("date_of_birth").value='';
							if(document.getElementById("nationality_desc"))
								document.getElementById("nationality_desc").value='';
							if(document.getElementById("nationality_code1"))
								document.getElementById("nationality_code1").value='';
							if(document.getElementById("race_code"))
								document.getElementById("race_code").value='';
							if(document.getElementById("race_desc"))
								document.getElementById("race_desc").value='';
							if(document.forms[0].addr_line1)
								document.forms[0].addr_line1.value='';
							if(document.forms[0].addr_line2)
								document.forms[0].addr_line2.value='';
							if(document.forms[0].addr_line3)
								document.forms[0].addr_line3.value='';
							if(document.forms[0].addr_line4)
								document.forms[0].addr_line4.value='';
								
							if(document.forms[0].res_town_code)
								document.forms[0].res_town_code.value='';
							if(document.forms[0].res_town_desc)
								document.forms[0].res_town_desc.value='';
							if(document.forms[0].res_area_code)
								document.forms[0].res_area_code.value='';
							if(document.forms[0].res_area_desc)
								document.forms[0].res_area_desc.value='';
							if(document.forms[0].postal_code)
								document.forms[0].postal_code.value='';
							if(document.forms[0].r_postal_code_desc)
								document.forms[0].r_postal_code_desc.value='';
							if(document.forms[0].region_code)
								document.forms[0].region_code.value='';
							if(document.forms[0].region_desc)
								document.forms[0].region_desc.value='';
							if(document.forms[0].country_code)
								document.forms[0].country_code.value='';
							if(document.forms[0].country_desc)
								document.forms[0].country_desc.value='';
								putPatientName('');
						}
					<%}
				}
			}
			
			
			
		if(!patient_id.equals(""))
		{
			String chkst = patdata.CheckStatus(con,patient_id);
			if(chkst.equals("DECEASED"))
			{
				patient_id_detail=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.deceased.label","common_labels");
			%>	
				 var err_age1 = getMessage("PAT_DECEASED_NOT_ALLOWED","MP");	
				alert(err_age1);
				document.forms[0].txtSmartcard_dup.value="D";
				//document.forms[0].national_id_no.focus();
			<%
		}
		else if(chkst.equals("SUSPENDED"))
		{
			patient_id_detail=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Suspended.label","common_labels");
			%>
			 var err_age2 = getMessage("PAT_SUSPENDED_NOT_ALLOWED","MP");
			alert(err_age2);
			document.forms[0].txtSmartcard_dup.value="D";
			//document.forms[0].national_id_no.focus();
			<%
		}
		else if(chkst.equals("INACTIVE"))
		{
			patient_id_detail=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inactive.label","common_labels");
			%>
			var err_age3 = getMessage("PAT_INACTIVE_NOT_ALLOWED","MP");
			alert(err_age3);
			document.forms[0].txtSmartcard_dup.value="D";
			//document.forms[0].national_id_no.focus();
			<%
		} else{	 // smart card
		
			%>
			 populateDetail("<%=field_name%>","<%=patient_id_detail%>","<%=patient_id_addresses%>","<%=objttt%>");
			<%}
		}
		else{
		   if(step.equals("N") && nat_invoke_routine.equals("Y") && nat_data_source_id.equals("NRIC") && nat_id_check_digit_id.equals("")){
				sql = "select VERIFY_NATIONAL_ID('"+id+"') from dual";
				rset3=stmtn.executeQuery(sql);
				if(rset3!= null && rset3.next())
				result = rset3.getString(1);
							
				StringTokenizer strTok = new StringTokenizer(result,"$");				
						
				if(strTok.hasMoreTokens())
					result = strTok.nextToken();
					if(result.equals("TRUE")){
						if(strTok.hasMoreTokens())
							date_of_birth = strTok.nextToken();	
						if(strTok.hasMoreTokens())
							age_in_years = strTok.nextToken();	
						if(strTok.hasMoreTokens())
							age_in_months = strTok.nextToken();	
						if(strTok.hasMoreTokens())
							age_in_days = strTok.nextToken();	
						if(strTok.hasMoreTokens())
							sex = strTok.nextToken();
						if (strTok.hasMoreTokens())
							place_of_birth_code = strTok.nextToken();
						if (strTok.hasMoreTokens())
							place_of_birth_desc = strTok.nextToken();  

						result = "NAT_ID_VALUES"+"||"+date_of_birth+"||"+age_in_years+"||"+age_in_months+"||"+age_in_days+"||"+sex+"||"+place_of_birth_code+"||"+place_of_birth_desc;
						%>
						 populateDetail("<%=field_name%>","<%=result%>","<%=patient_id_addresses%>","<%=objttt%>");
						<%
					}
					else if(result.equals("FALSE")){
						if(strTok.hasMoreTokens()){
							error_message = strTok.nextToken();
							%>
							var msg = getMessage('<%=error_message%>','MP');
							var val = msg.replace("#",'<%=disp_prompt%>')
						
							val = val.replace("@",'<%=nat_id_len%>')
							alert(val);	
							document.forms[0].national_id_no.value='';
							document.forms[0].national_id_no.focus();
							
							<%
						}
					}
					else
					{
						if(strTok.hasMoreTokens()){
							error_message = strTok.nextToken();
							%>
							 var msg = getMessage('<%=error_message%>','MP');
							alert(msg);	
							document.forms[0].national_id_no.value='';
							document.forms[0].national_id_no.focus();

							<%							
						}
					}
				}
			}
		}
		catch(Exception e2)
		{	 
			e2.printStackTrace();
		}
		finally
		{
			hash.clear();
			if(stmtn!= null) stmtn.close();
			if(rset3 != null) rset3.close();
			if(stmt != null) stmt.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	}
	}
	catch(Exception e)
	{
        e.printStackTrace();
	}
	finally
		{
			hash.clear();
			ConnectionManager.returnConnection(con, request);
		}
	%>
