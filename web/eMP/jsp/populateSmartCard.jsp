<!-- Latest Modified Date : 10/1/2005 4:36 PM -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*,java.util.*,java.io.*,webbeans.eCommon.ConnectionManager" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eMP/js/checkNationality.js'></script>
   
  
<%
		String inst = checkForNull(request.getParameter("inst"));
		String Calledfrom = checkForNull(request.getParameter("Calledfrom"));
		String function_name = checkForNull(request.getParameter("function_name"));
		String modal_yn= checkForNull(request.getParameter("modal_yn"),"N");
		String from_OA= checkForNull(request.getParameter("from_OA"),"N");
		String caller_form="00";
		caller_form=checkForNull(request.getParameter("caller_form"),"00");
		request.setCharacterEncoding("UTF-8");
		Connection conn			= null;
		java.sql.PreparedStatement prpstmt = null;
     	String locale			= (String)session.getAttribute("LOCALE");

		ResultSet rs			= null;
		try
		{
			conn	= ConnectionManager.getConnection(request);
			
			String sql ;
			String nationality_code="";
			String race_desc = checkForNull(request.getParameter("race_desc"));
			String country_desc = checkForNull(request.getParameter("country_desc"));
			String nationality_desc = checkForNull(request.getParameter("nationality_desc"));
			nationality_code = checkForNull(request.getParameter("nationality_code"));
			String blood_group_code = checkForNull(request.getParameter("blood_group_code"));
		//	System.err.println("nationality_code : "+nationality_code);
		//	System.err.println("blood_group_code : "+blood_group_code);
			String city_desc = checkForNull(request.getParameter("city_desc"));
			String state_desc = checkForNull(request.getParameter("state_desc"));
			String post_code_desc = checkForNull(request.getParameter("post_code"));
			String birth_place_desc = checkForNull(request.getParameter("b_place"));
			String religion_desc = checkForNull(request.getParameter("religion_desc"));
			String mother_yn = checkForNull(request.getParameter("mother_yn"),"N");
			String father_yn = checkForNull(request.getParameter("father_yn"),"N");
			String birth_cert_no = checkForNull(request.getParameter("birth_cert_no"),"N");
			//Maheshwaran added for ML-MMOH-CRF-1908
			String alt_id_type_desc = checkForNull(request.getParameter("alt_id_type_desc"));
			String father_doc_type_desc = checkForNull(request.getParameter("father_doc_type_desc"));
			String alt_id_type_code="";
			String alt_id_type_desc1="";
			String father_doc_type_code="";
			String father_doc_type_desc1="";
		//	System.err.println("alt_id_type_desc in JSP : "+alt_id_type_desc);
			
			String race_code="";
		
			String country_code="";
			String city_code="";
			String state_code="";
			String post_code="";
			String birth_place_code="";
			String religion_code="";
			String area_code = "";
			String area_desc ="";
			String mother_relation_desc ="";
			String father_relation_desc ="";
			String blood_grp_code="";
			String blood_grp_desc="";



		
			if(caller_form.equals("00")){

				prpstmt = conn.prepareStatement("select nvl(race_code,'') race_code ,nvl(long_desc,'') long_desc  from MP_RACE_lang_vw where upper(long_desc)=upper(?) and  EFF_STATUS='E' and language_id='"+locale+"'");

				prpstmt.setString(1,race_desc);
				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					race_code=checkForNull(rs.getString("race_code"));
					race_desc=checkForNull(rs.getString("long_desc"));
				}else{
					race_code="";
					race_desc="";
				}

				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(country_code,'') country_code  , nvl(long_desc,'') long_desc from mp_country_lang_vw where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"'");
				prpstmt.setString(1,nationality_desc);

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					nationality_code=checkForNull(rs.getString("country_code"));
					nationality_desc=checkForNull(rs.getString("long_desc"));
				}else{
					nationality_code="";
					nationality_desc="";
				}
			}else if(caller_form.equals("01")){

				prpstmt = conn.prepareStatement("select nvl(country_code,'') country_code,nvl(long_desc,'') long_desc from mp_country_lang_vw where EFF_STATUS='E'  and language_id='"+locale+"' and country_code in (?,?)");
				prpstmt.setString(1,country_desc);
				prpstmt.setString(2,nationality_desc);

				rs = prpstmt.executeQuery();

				HashMap country_map=new HashMap();

				while (rs.next()){
					country_map.put(checkForNull(rs.getString("country_code")),checkForNull(rs.getString("long_desc")));
				}
				
				nationality_code=nationality_desc;
				nationality_desc=checkForNull((String)country_map.get(nationality_code));
				country_code=country_desc;
				country_desc=checkForNull((String)country_map.get(country_code));

				
			}else if(caller_form.equals("02")){

				prpstmt = conn.prepareStatement("select nvl(race_code,'') race_code ,nvl(long_desc,'') long_desc  from MP_RACE_lang_vw where upper(long_desc)=upper(?) and  EFF_STATUS='E' and language_id='"+locale+"' order by 1");



				prpstmt.setString(1,race_desc);
				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					race_code=checkForNull(rs.getString("race_code"));
					race_desc=checkForNull(rs.getString("long_desc"));
				}else{
					race_code="";
					race_desc="";
				}
				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(RES_TOWN_CODE,'') RES_TOWN_CODE  , nvl(long_desc,'') long_desc,RES_AREA_CODE from mp_res_town_lang_vw  where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,city_desc);

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					city_code=checkForNull(rs.getString("RES_TOWN_CODE"));
					city_desc=checkForNull(rs.getString("long_desc"));
					area_code=checkForNull(rs.getString("RES_AREA_CODE"));
				}else{
					city_code="";
					city_desc="";
					area_code="";
				}
				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(RES_AREA_CODE,'') RES_AREA_CODE  , nvl(long_desc,'') long_desc from mp_res_area_lang_vw  where upper(RES_AREA_CODE)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,area_code);

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					area_code=checkForNull(rs.getString("RES_AREA_CODE"));
					area_desc=checkForNull(rs.getString("long_desc"));
				}else{
					area_code="";
					area_desc="";
				}

				

				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();


				prpstmt = conn.prepareStatement("select nvl(REGION_CODE,'') REGION_CODE  , nvl(long_desc,'') long_desc from mp_region_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,state_desc);


				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					state_code=checkForNull(rs.getString("REGION_CODE"));
					state_desc=checkForNull(rs.getString("long_desc"));
				}else{
					state_code="";
					state_desc="";
				}

				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(POSTAL_CODE,'') POSTAL_CODE  , nvl(long_desc,'') long_desc from mp_postal_code_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,post_code_desc);



				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					post_code=checkForNull(rs.getString("POSTAL_CODE"));
					post_code_desc=checkForNull(rs.getString("long_desc"));
				}else{
					post_code="";
					post_code_desc="";
				}


				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(BIRTH_PLACE_CODE,'') BIRTH_PLACE_CODE  , nvl(long_desc,'') long_desc from mp_birth_place_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,birth_place_desc);


				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					birth_place_code=checkForNull(rs.getString("BIRTH_PLACE_CODE"));
					birth_place_desc=checkForNull(rs.getString("long_desc"));
				}else{
					birth_place_code="";
					birth_place_desc="";
				}

				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(RELGN_CODE,'') RELGN_CODE  , nvl(long_desc,'') long_desc from mp_religion_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,religion_desc);


				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					religion_code=checkForNull(rs.getString("RELGN_CODE"));
					religion_desc=checkForNull(rs.getString("long_desc"));
				}else{
					religion_code="";
					religion_desc="";
				}

				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();


				if(mother_yn.equals("Y")){

					prpstmt = conn.prepareStatement("select nvl(RELATIONSHIP_CODE,'') RELATIONSHIP_CODE  , nvl(long_desc,'') long_desc from mp_relationship_lang_vw   where RELATIONSHIP_CODE = '03' and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");

					rs = prpstmt.executeQuery();
					
					if(rs != null && rs.next()){
											
						if(checkForNull(rs.getString("RELATIONSHIP_CODE")).equals("03") ){
							mother_relation_desc=checkForNull(rs.getString("long_desc"));
							mother_yn="03";
						}

						/*if(checkForNull(rs.getString("RELATIONSHIP_CODE")).equals("04") ){
							father_relation_desc=checkForNull(rs.getString("long_desc"));
							father_yn="04";
						}					
						*/					
						
					}
				

					if(rs!=null) rs.close();
					if(prpstmt!=null) prpstmt.close();		

				}


			}else if(caller_form.equals("03")){

				prpstmt = conn.prepareStatement("select nvl(race_code,'') race_code ,nvl(long_desc,'') long_desc  from MP_RACE_lang_vw where upper(long_desc)=upper(?) and  EFF_STATUS='E' and language_id='"+locale+"' order by 1");



				prpstmt.setString(1,race_desc);
				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					race_code=checkForNull(rs.getString("race_code"));
					race_desc=checkForNull(rs.getString("long_desc"));
				}else{
					race_code="";
					race_desc="";
				}
				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(RES_TOWN_CODE,'') RES_TOWN_CODE  , nvl(long_desc,'') long_desc,RES_AREA_CODE from mp_res_town_lang_vw  where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,city_desc);

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					city_code=checkForNull(rs.getString("RES_TOWN_CODE"));
					city_desc=checkForNull(rs.getString("long_desc"));
					area_code=checkForNull(rs.getString("RES_AREA_CODE"));
				}else{
					city_code="";
					city_desc="";
					area_code="";
				}
				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(RES_AREA_CODE,'') RES_AREA_CODE  , nvl(long_desc,'') long_desc from mp_res_area_lang_vw  where upper(RES_AREA_CODE)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,area_code);

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					area_code=checkForNull(rs.getString("RES_AREA_CODE"));
					area_desc=checkForNull(rs.getString("long_desc"));
				}else{
					area_code="";
					area_desc="";
				}

				

				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();


				prpstmt = conn.prepareStatement("select nvl(REGION_CODE,'') REGION_CODE  , nvl(long_desc,'') long_desc from mp_region_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,state_desc);


				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					state_code=checkForNull(rs.getString("REGION_CODE"));
					state_desc=checkForNull(rs.getString("long_desc"));
				}else{
					state_code="";
					state_desc="";
				}

				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(POSTAL_CODE,'') POSTAL_CODE  , nvl(long_desc,'') long_desc from mp_postal_code_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,post_code_desc);



				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					post_code=checkForNull(rs.getString("POSTAL_CODE"));
					post_code_desc=checkForNull(rs.getString("long_desc"));
				}else{
					post_code="";
					post_code_desc="";
				}


				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(BIRTH_PLACE_CODE,'') BIRTH_PLACE_CODE  , nvl(long_desc,'') long_desc from mp_birth_place_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,birth_place_desc);


				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					birth_place_code=checkForNull(rs.getString("BIRTH_PLACE_CODE"));
					birth_place_desc=checkForNull(rs.getString("long_desc"));
				}else{
					birth_place_code="";
					birth_place_desc="";
				}

				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(RELGN_CODE,'') RELGN_CODE  , nvl(long_desc,'') long_desc from mp_religion_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,religion_desc);


				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					religion_code=checkForNull(rs.getString("RELGN_CODE"));
					religion_desc=checkForNull(rs.getString("long_desc"));
				}else{
					religion_code="";
					religion_desc="";
				}

				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				
				if(father_yn.equals("Y") || mother_yn.equals("Y")){

					prpstmt = conn.prepareStatement("select nvl(RELATIONSHIP_CODE,'') RELATIONSHIP_CODE  , nvl(long_desc,'') long_desc from mp_relationship_lang_vw   where RELATIONSHIP_CODE in ('03','04') and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");

					rs = prpstmt.executeQuery();
					
					if(rs != null){
						while (rs.next()){ 
					
						if(checkForNull(rs.getString("RELATIONSHIP_CODE")).equals("03") ){
							mother_relation_desc=checkForNull(rs.getString("long_desc"));
							mother_yn="03";
						}

						if(checkForNull(rs.getString("RELATIONSHIP_CODE")).equals("04") ){
							father_relation_desc=checkForNull(rs.getString("long_desc"));
							father_yn="04";
						}					
											
						}
					}
				}

				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();		

			}else if(caller_form.equals("04")){

				prpstmt = conn.prepareStatement("select nvl(race_code,'') race_code ,nvl(long_desc,'') long_desc  from MP_RACE_lang_vw where upper(short_desc)=upper(?) and  EFF_STATUS='E' and language_id='"+locale+"' order by 1");

				System.out.println("race_desc-->"+race_desc);

				prpstmt.setString(1,race_desc);
				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					race_code=checkForNull(rs.getString("race_code"));
					race_desc=checkForNull(rs.getString("long_desc"));
				}else{
					race_code="";
					race_desc="";
				}
				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				/*prpstmt = conn.prepareStatement("select nvl(RES_TOWN_CODE,'') RES_TOWN_CODE  , nvl(long_desc,'') long_desc,RES_AREA_CODE from mp_res_town_lang_vw  where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");

				System.out.println("city_desc-->"+city_desc);
				prpstmt.setString(1,city_desc);

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					city_code=checkForNull(rs.getString("RES_TOWN_CODE"));
					city_desc=checkForNull(rs.getString("long_desc"));
					area_code=checkForNull(rs.getString("RES_AREA_CODE"));
				}else{
					city_code="";
					city_desc="";
					area_code="";
				}
				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();
				*/

				prpstmt = conn.prepareStatement("select nvl(RES_AREA_CODE,'') RES_AREA_CODE  , nvl(long_desc,'') long_desc from mp_res_area_lang_vw  where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");

				
				prpstmt.setString(1,city_desc);

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					area_code=checkForNull(rs.getString("RES_AREA_CODE"));
					area_desc=checkForNull(rs.getString("long_desc"));
				}else{
					area_code="";
					area_desc="";
				}

				

				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();


				prpstmt = conn.prepareStatement("select nvl(REGION_CODE,'') REGION_CODE  , nvl(long_desc,'') long_desc from mp_region_lang_vw   where upper(short_desc)=substr(upper(?),0,15) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");

				System.out.println("state_desc-->"+state_desc);
				prpstmt.setString(1,state_desc);


				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					state_code=checkForNull(rs.getString("REGION_CODE"));
					state_desc=checkForNull(rs.getString("long_desc"));
				}else{
					state_code="";
					state_desc="";
				}

				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(POSTAL_CODE,'') POSTAL_CODE  , nvl(long_desc,'') long_desc from mp_postal_code_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,post_code_desc);

																

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					post_code=checkForNull(rs.getString("POSTAL_CODE"));
					post_code_desc=checkForNull(rs.getString("long_desc"));
				}else{
					post_code="";
					post_code_desc="";
				}


				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(BIRTH_PLACE_CODE,'') BIRTH_PLACE_CODE  , nvl(long_desc,'') long_desc from mp_birth_place_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,birth_place_desc);
																System.out.println("birth_place_desc-->"+birth_place_desc);

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					birth_place_code=checkForNull(rs.getString("BIRTH_PLACE_CODE"));
					birth_place_desc=checkForNull(rs.getString("long_desc"));
				}else{
					birth_place_code="";
					birth_place_desc="";
				}

				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(RELGN_CODE,'') RELGN_CODE  , nvl(long_desc,'') long_desc from mp_religion_lang_vw   where upper(short_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,religion_desc);
																System.out.println("religion_desc-->"+religion_desc);

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					religion_code=checkForNull(rs.getString("RELGN_CODE"));
					religion_desc=checkForNull(rs.getString("long_desc"));
				}else{
					religion_code="";
					religion_desc="";
				}

				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				
				if(father_yn.equals("Y") || mother_yn.equals("Y")){

					prpstmt = conn.prepareStatement("select nvl(RELATIONSHIP_CODE,'') RELATIONSHIP_CODE  , nvl(long_desc,'') long_desc from mp_relationship_lang_vw   where RELATIONSHIP_CODE in ('95','94') and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");

					rs = prpstmt.executeQuery();
					
					if(rs != null){
						while (rs.next()){ 
					
						if(checkForNull(rs.getString("RELATIONSHIP_CODE")).equals("95") ){
							mother_relation_desc=checkForNull(rs.getString("long_desc"));
							mother_yn="95";
						}

						if(checkForNull(rs.getString("RELATIONSHIP_CODE")).equals("94") ){
							father_relation_desc=checkForNull(rs.getString("long_desc"));
							father_yn="94";
						}					
											
						}
					}
				}

				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();		

				System.out.println("594 area_code-->"+area_code);
				System.out.println("595 area_desc-->"+area_desc);
				System.out.println("596 city_desc-->"+city_desc);
			}
			else if(caller_form.equals("05")){ // Related to Taiba

				prpstmt = conn.prepareStatement("select nvl(country_code,'') country_code,nvl(long_desc,'') long_desc from mp_country_lang_vw where EFF_STATUS='E'  and language_id='"+locale+"' and upper(country_code)=upper(?)");
				prpstmt.setString(1,nationality_code);
				rs = prpstmt.executeQuery();
				if(rs!= null && rs.next()){
					nationality_code=checkForNull(rs.getString("country_code"));
					nationality_desc=checkForNull(rs.getString("long_desc"));
				}else{
					nationality_code="";
					nationality_desc="";
				}
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();		
				
				prpstmt = conn.prepareStatement(" select nvl(blood_grp,'') blood_grp , nvl(long_desc,'') long_desc   from mr_blood_grp_lang_vw where EFF_STATUS='E'  and language_id='"+locale+"' and upper(blood_grp)=upper(?) ");
				prpstmt.setString(1,blood_group_code);
				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					blood_grp_code=checkForNull(rs.getString("blood_grp"));
					blood_grp_desc=checkForNull(rs.getString("long_desc"));
				}else{
					blood_grp_code="";
					blood_grp_desc="";
				}

				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();	
			}
			else if(caller_form.equals("06")){ // Related to Serdang
				String pat_photo = checkForNull(request.getParameter("pat_photo"));

				session.setAttribute("pat_photo",pat_photo);
				prpstmt = conn.prepareStatement("select nvl(country_code,'') country_code  , nvl(long_name,'') long_desc from mp_country_lang_vw where upper(long_name)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"'");
				prpstmt.setString(1,nationality_desc);

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					nationality_code=checkForNull(rs.getString("country_code"));
					nationality_desc=checkForNull(rs.getString("long_desc"));
				}else{
					nationality_code="";
					nationality_desc="";
				}
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();		
			
			prpstmt = conn.prepareStatement("select nvl(BIRTH_PLACE_CODE,'') BIRTH_PLACE_CODE  , nvl(long_desc,'') long_desc from mp_birth_place_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,birth_place_desc);
			//System.out.println("birth_place_desc-->"+birth_place_desc);

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					birth_place_code=checkForNull(rs.getString("BIRTH_PLACE_CODE"));
					birth_place_desc=checkForNull(rs.getString("long_desc"));
				}else{
					birth_place_code="";
					birth_place_desc="";
				}
	prpstmt = conn.prepareStatement("select nvl(REGION_CODE,'') REGION_CODE  , nvl(long_desc,'') long_desc from mp_region_lang_vw   where upper(short_desc)=substr(upper(?),0,15) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,state_desc);
				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					state_code=checkForNull(rs.getString("REGION_CODE"));
					state_desc=checkForNull(rs.getString("long_desc"));
				}else{
					state_code="";
					state_desc="";
				}
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();
			/*	prpstmt = conn.prepareStatement("select nvl(RES_TOWN_CODE,'') RES_TOWN_CODE  , nvl(long_desc,'') long_desc,RES_AREA_CODE from mp_res_town_lang_vw  where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,city_desc);
				rs = prpstmt.executeQuery();
				if(rs!= null && rs.next()){
					city_code=checkForNull(rs.getString("RES_TOWN_CODE"));
					city_desc=checkForNull(rs.getString("long_desc"));
					area_code=checkForNull(rs.getString("RES_AREA_CODE"));
				}else{
					city_code="";
					city_desc="";
					area_code="";
				}				
				*/
				
				prpstmt = conn.prepareStatement("select nvl(RES_AREA_CODE,'') RES_AREA_CODE  , nvl(long_desc,'') long_desc from mp_res_area_lang_vw  where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,city_desc);

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					city_code=checkForNull(rs.getString("RES_AREA_CODE"));
					city_desc=checkForNull(rs.getString("long_desc"));
				}else{
					city_code="";
					city_desc="";
				}
				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();	
				prpstmt = conn.prepareStatement("select nvl(POSTAL_CODE,'') POSTAL_CODE  , nvl(long_desc,'') long_desc from mp_postal_code_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,post_code_desc);												
				rs = prpstmt.executeQuery();
				if(rs!= null && rs.next()){
					post_code=checkForNull(rs.getString("POSTAL_CODE"));
					post_code_desc=checkForNull(rs.getString("long_desc"));
				}else{
					post_code="";
					post_code_desc="";
				}
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();
				prpstmt = conn.prepareStatement("select nvl(race_code,'') race_code ,nvl(long_desc,'') long_desc  from MP_RACE_lang_vw where upper(short_desc)=upper(?) and  EFF_STATUS='E' and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,race_desc);
				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					race_code=checkForNull(rs.getString("race_code"));
					race_desc=checkForNull(rs.getString("long_desc"));
				}else{
					race_code="";
					race_desc="";
				}				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();
				prpstmt = conn.prepareStatement("select nvl(RELGN_CODE,'') RELGN_CODE  , nvl(long_desc,'') long_desc from mp_religion_lang_vw   where upper(short_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,religion_desc);
				rs = prpstmt.executeQuery();
				if(rs!= null && rs.next()){
					religion_code=checkForNull(rs.getString("RELGN_CODE"));
					religion_desc=checkForNull(rs.getString("long_desc"));
				}else{
					religion_code="";
					religion_desc="";
				}
	
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();		
				
				prpstmt = conn.prepareStatement("select nvl(alt_id_type,'') alt_id_type  , nvl(long_desc,'') long_desc from mp_alternate_id_type_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,alt_id_type_desc);
				rs = prpstmt.executeQuery();
				if(rs!= null && rs.next()){
					alt_id_type_code=checkForNull(rs.getString("alt_id_type"));
					alt_id_type_desc1=checkForNull(rs.getString("long_desc"));
				}else{
					alt_id_type_code="";
					alt_id_type_desc1="";
				}	
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();		
				}	
				if(father_doc_type_desc!=null){
				prpstmt = conn.prepareStatement("select nvl(alt_id_type,'') alt_id_type  , nvl(long_desc,'') long_desc from mp_alternate_id_type_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,father_doc_type_desc);
				rs = prpstmt.executeQuery();
				if(rs!= null && rs.next()){
					father_doc_type_code=checkForNull(rs.getString("alt_id_type"));
					father_doc_type_desc1=checkForNull(rs.getString("long_desc"));
				}else{
					father_doc_type_code="";
					father_doc_type_desc1="";
				}	
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();		
				}
				
				if(mother_yn.equals("Y")){

					prpstmt = conn.prepareStatement("select nvl(RELATIONSHIP_CODE,'') RELATIONSHIP_CODE  , nvl(short_desc,'') short_desc from mp_relationship_lang_vw   where RELATIONSHIP_CODE = 'RE01' and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");

					rs = prpstmt.executeQuery();
					
					if(rs != null && rs.next()){
											
						if(checkForNull(rs.getString("RELATIONSHIP_CODE")).equals("RE01") ){
							mother_relation_desc=checkForNull(rs.getString("short_desc"));
							mother_yn="RE01";
						
						}
						
					}
				

					if(rs!=null) rs.close();
					if(prpstmt!=null) prpstmt.close();		

				}
				if(father_yn.equals("Y")){

					prpstmt = conn.prepareStatement("select nvl(RELATIONSHIP_CODE,'') RELATIONSHIP_CODE  , nvl(short_desc,'') short_desc from mp_relationship_lang_vw   where RELATIONSHIP_CODE = 'RE07' and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");

					rs = prpstmt.executeQuery();
					
					if(rs != null && rs.next()){
				 

						if(checkForNull(rs.getString("RELATIONSHIP_CODE")).equals("RE07") ){
							father_relation_desc=checkForNull(rs.getString("short_desc"));
							father_yn="RE07";
						}					
									
						
					}
				

					if(rs!=null) rs.close();
					if(prpstmt!=null) prpstmt.close();		

				}

			%>
				<script>
				var Calledfrom='<%=Calledfrom%>';
				var inst='<%=inst%>';
				var function_name='<%=function_name%>';
				var modal_yn='<%=modal_yn%>';
				var caller_form='<%=caller_form%>';
				var from_OA='<%=from_OA%>';
				var father_yn='<%=father_yn%>';
				var mother_yn='<%=mother_yn%>';
				var father_relation_desc='<%=father_relation_desc%>';
				var mother_relation_desc='<%=mother_relation_desc%>';
				var birth_cert_no='<%=birth_cert_no%>';

				if(caller_form=='00'){

					if(inst=='NC'){
						parent.frames[1].frames[1].document.forms[0].nationality_desc.value="<%=nationality_desc%>";
						parent.frames[1].frames[1].document.forms[0].nationality_code.value="<%=nationality_code%>";					
						parent.frames[1].frames[1].document.forms[0].race_desc.value="<%=race_desc%>";
						parent.frames[1].frames[1].document.forms[0].race_code.value="<%=race_code%>";	
						
						if(Calledfrom =='P' || Calledfrom=='R'){
							parent.frames[1].frames[1].document.forms[0].r_country_desc.value="<%=nationality_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_country_code.value="<%=nationality_code%>";
						}
					}
					if(inst=='IC'){
						if(function_name=='REFERRAL' ){
							parent.frames[1].frames[0].document.forms[0].nationality_desc.value="<%=nationality_desc%>";
							parent.frames[1].frames[0].document.forms[0].nationality_desc1.value="<%=nationality_desc%>";
							parent.frames[1].frames[0].document.forms[0].nationality_code1.value="<%=nationality_code%>";					
							parent.frames[1].frames[0].document.forms[0].race_desc.value="<%=race_desc%>";
							parent.frames[1].frames[0].document.forms[0].race_code.value="<%=race_code%>";
						}
						if(function_name=='BOOK_APPT'){

							parent.parent.frames[0].document.forms[0].nationality_desc.value="<%=nationality_desc%>";
							parent.parent.frames[0].document.forms[0].nationality_desc1.value="<%=nationality_desc%>";
							parent.parent.frames[0].document.forms[0].nationality_code1.value="<%=nationality_code%>";					
							parent.parent.frames[0].document.forms[0].race_desc.value="<%=race_desc%>";
							parent.parent.frames[0].document.forms[0].race_code.value="<%=race_code%>";
						}

						if( function_name=='WAIT_LIST'){
							parent.frames[1].document.forms[0].nationality_desc.value="<%=nationality_desc%>";
							parent.frames[1].document.forms[0].nationality_desc1.value="<%=nationality_desc%>";
							parent.frames[1].document.forms[0].nationality_code1.value="<%=nationality_code%>";					
							parent.frames[1].document.forms[0].race_desc.value="<%=race_desc%>";
							parent.frames[1].document.forms[0].race_code.value="<%=race_code%>";
						}
						
					}

					if(inst=='SR'){
						if(function_name=='INV' ){
							parent.frames[1].frames[1].document.forms[0].nationality_desc.value="<%=nationality_desc%>";
							parent.frames[1].frames[1].document.forms[0].nationality_id.value="<%=nationality_code%>";					
							
						}
						if(function_name=='APP' ){
							parent.frames[1].frames[1].document.forms[0].nationality_iddesc.value="<%=nationality_desc%>";
							parent.frames[1].frames[1].document.forms[0].nationality_id.value="<%=nationality_code%>";					
							
						}

						if(function_name=='MGWLST' ){
							parent.frames[1].document.forms[0].nationality_desc.value="<%=nationality_desc%>";
							//parent.frames[1].document.forms[0].nationality_id.value="<%=nationality_code%>";					
							
						}		
						
						
					}

					if(inst=='PS'){
						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].nationality_desc.value="<%=nationality_desc%>";
						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].nationality_desc_hid.value="<%=nationality_desc%>";
						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].Nationality_hid.value="<%=nationality_code%>";					
						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group_desc.value="<%=race_desc%>";
						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group_desc_hid.value="<%=race_desc%>";
						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group_hid.value="<%=race_code%>";	
					}

					
					if(function_name=='BOOK_APPT'){
						parent.parent.frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}else if(function_name=='MGWLST'){
						
						parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
					}else if(function_name=='PS'){
						parent.frames[6].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}else{	
						if(function_name=="WAIT_LIST" && modal_yn=="Y"){
							
							parent.frames[2].location.href="../../eCommon/jsp/Dummy.jsp";
						}else{						
							parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
						}
					}
				}else if (caller_form=='01'){
					if(inst=='NC'){
						parent.frames[1].frames[1].document.forms[0].nationality_desc.value="<%=nationality_desc%>";
						parent.frames[1].frames[1].document.forms[0].nationality_code.value="<%=nationality_code%>";					
						
						
						if(Calledfrom =='P' || Calledfrom=='R'){
							parent.frames[1].frames[1].document.forms[0].r_country_desc.value="<%=country_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_country_code.value="<%=country_code%>";
						}
						parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}else if(inst=='PS'){
						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].nationality_desc.value="<%=nationality_desc%>";
						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].nationality_desc_hid.value="<%=nationality_desc%>";
						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].Nationality_hid.value="<%=nationality_code%>";
						parent.parent.frames[5].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}	
					if(function_name=='BOOK_APPT'){
							parent.frames[1].frames[1].document.forms[0].nationality_desc.value="<%=nationality_desc%>";
						parent.frames[1].frames[1].document.forms[0].nationality_code.value="<%=nationality_code%>";					
						
						
						if(Calledfrom =='P' || Calledfrom=='R'){
							parent.frames[1].frames[1].document.forms[0].r_country_desc.value="<%=country_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_country_code.value="<%=country_code%>";
						}
						parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}
					

				}else if (caller_form=='02'){

					if(function_name=='PAT_REGN'){
						parent.frames[1].frames[1].document.forms[0].race_desc.value="<%=race_desc%>";
						parent.frames[1].frames[1].document.forms[0].race_code.value="<%=race_code%>";
						
						parent.frames[1].frames[1].document.forms[0].relgn_desc.value="<%=religion_desc%>";
						parent.frames[1].frames[1].document.forms[0].relgn_code.value="<%=religion_code%>";

						if(parent.frames[1].frames[1].document.forms[0].r_town_code){
							parent.frames[1].frames[1].document.forms[0].r_town_code.value="<%=city_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_town.value="<%=city_code%>";
						}

						if(parent.frames[1].frames[1].document.forms[0].r_area_code){
							parent.frames[1].frames[1].document.forms[0].r_area_code.value="<%=area_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_area.value="<%=area_code%>";
						}

						if(parent.frames[1].frames[1].document.forms[0].r_region_code){
							parent.frames[1].frames[1].document.forms[0].r_region_code.value="<%=state_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_region.value="<%=state_code%>";
						}

						if(parent.frames[1].frames[1].document.forms[0].r_postal_code1){
							parent.frames[1].frames[1].document.forms[0].r_postal_code1.value="<%=post_code_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_postal_code.value="<%=post_code%>";
						}
						
						if(parent.frames[1].frames[1].document.forms[0].place_of_birth_desc){
							parent.frames[1].frames[1].document.forms[0].place_of_birth_desc.value="<%=birth_place_desc%>";
							parent.frames[1].frames[1].document.forms[0].place_of_birth_code.value="<%=birth_place_code%>";
						}

						if(mother_yn=='03'){
							if(parent.frames[1].frames[1].document.forms[0].next_contact_relation_desc){
								parent.frames[1].frames[1].document.forms[0].next_contact_relation_desc.value="<%=mother_relation_desc%>";
								parent.frames[1].frames[1].document.forms[0].next_contact_relation.value="<%=mother_yn%>";
							}
						}else{   // Added 11-Apr-2019- for HSA
							if(parent.frames[1].frames[1].document.forms[0].Photo_upload_yn){
								parent.frames[1].frames[1].document.forms[0].Photo_upload_yn.value="Y";
							}
						}

						parent.parent.frames[2].frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}

					if(function_name=='CHANGEPAT'){
						parent.frames[1].frames[1].document.forms[0].race_desc.value="<%=race_desc%>";
						parent.frames[1].frames[1].document.forms[0].race_code.value="<%=race_code%>";
						
						parent.frames[1].frames[1].document.forms[0].relgn_desc.value="<%=religion_desc%>";
						parent.frames[1].frames[1].document.forms[0].relgn_code.value="<%=religion_code%>";

						if(parent.frames[1].frames[1].document.forms[0].r_town_code){
							parent.frames[1].frames[1].document.forms[0].r_town_code.value="<%=city_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_town.value="<%=city_code%>";
						}

						if(parent.frames[1].frames[1].document.forms[0].r_area_code){
							parent.frames[1].frames[1].document.forms[0].r_area_code.value="<%=area_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_area.value="<%=area_code%>";
						}

						if(parent.frames[1].frames[1].document.forms[0].r_region_code){
							parent.frames[1].frames[1].document.forms[0].r_region_code.value="<%=state_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_region.value="<%=state_code%>";
						}

						if(parent.frames[1].frames[1].document.forms[0].r_postal_code1){
							parent.frames[1].frames[1].document.forms[0].r_postal_code1.value="<%=post_code_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_postal_code.value="<%=post_code%>";
						}
						
						if(parent.frames[1].frames[1].document.forms[0].place_of_birth_desc){
							parent.frames[1].frames[1].document.forms[0].place_of_birth_desc.value="<%=birth_place_desc%>";
							parent.frames[1].frames[1].document.forms[0].place_of_birth_code.value="<%=birth_place_code%>";
						}

						if(mother_yn=='03'){
							if(parent.frames[1].frames[1].document.forms[0].next_contact_relation_desc){
								parent.frames[1].frames[1].document.forms[0].next_contact_relation_desc.value="<%=mother_relation_desc%>";
								parent.frames[1].frames[1].document.forms[0].next_contact_relation.value="<%=mother_yn%>";
							}
						}

						parent.parent.frames[2].frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}

					


					if(function_name=='BOOK_APPT'){
										

						parent.parent.frames[0].document.forms[0].race_desc.value="<%=race_desc%>";
						parent.parent.frames[0].document.forms[0].race_code.value="<%=race_code%>";			
						

						parent.parent.frames[0].document.forms[0].birth_place.value="<%=birth_place_desc%>";
						parent.parent.frames[0].document.forms[0].place_of_birth.value="<%=birth_place_code%>";

						parent.parent.frames[0].document.forms[0].res_town_desc.value="<%=city_desc%>";
						parent.parent.frames[0].document.forms[0].res_town_code.value="<%=city_code%>";

						parent.parent.frames[0].document.forms[0].res_area_desc.value="<%=area_desc%>";
						parent.parent.frames[0].document.forms[0].res_area_code.value="<%=area_code%>";

						parent.parent.frames[0].document.forms[0].region_desc.value="<%=state_desc%>";
						parent.parent.frames[0].document.forms[0].region_code.value="<%=state_code%>";

						parent.parent.frames[0].document.forms[0].postal_code.value="<%=post_code%>";
						parent.parent.frames[0].document.forms[0].r_postal_code_desc.value="<%=post_code%>";


						parent.parent.frames[4].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}

					if(function_name=='PAT_SEARCH'){
										

						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group_desc.value="<%=race_desc%>";
						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group.value="<%=race_code%>";	
						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group_desc_hid.value="<%=race_desc%>";
						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group_hid.value="<%=race_code%>";	

											
						
						parent.parent.parent.frames[6].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}
					

					if(function_name=='VSTREG'){
										
						if(parent.frames[1].frames[1].document.forms[0].r_town_code){
							parent.frames[1].frames[1].document.forms[0].r_town_code.value="<%=city_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_town.value="<%=city_code%>";

							parent.frames[1].frames[1].document.forms[0].r_area_code.value="<%=area_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_area.value="<%=area_code%>";
	 
							parent.frames[1].frames[1].document.forms[0].r_region_code.value="<%=state_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_region.value="<%=state_code%>";
						}
						
						parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}

					if(function_name=='REGREF'){
											
						if(from_OA=='N'){		
							parent.parent.frames[2].frames[1].frames[0].document.forms[0].race_desc.value="<%=race_desc%>";
							parent.parent.frames[2].frames[1].frames[0].document.forms[0].race_code.value="<%=race_code%>";			
							

							parent.parent.frames[2].frames[1].frames[0].document.forms[0].birth_place.value="<%=birth_place_desc%>";
							parent.parent.frames[2].frames[1].frames[0].document.forms[0].Birth_place_code.value="<%=birth_place_code%>";

							parent.parent.frames[2].frames[1].frames[0].document.forms[0].res_town_desc.value="<%=city_desc%>";
							parent.parent.frames[2].frames[1].frames[0].document.forms[0].res_town_code.value="<%=city_code%>";

							parent.parent.frames[2].frames[1].frames[0].document.forms[0].res_area_desc.value="<%=area_desc%>";
							parent.parent.frames[2].frames[1].frames[0].document.forms[0].res_area_code.value="<%=area_code%>";

							parent.parent.frames[2].frames[1].frames[0].document.forms[0].region_desc.value="<%=state_desc%>";
							parent.parent.frames[2].frames[1].frames[0].document.forms[0].region_code.value="<%=state_code%>";

							parent.parent.frames[2].frames[1].frames[0].document.forms[0].postal_code.value="<%=post_code%>";
							parent.parent.frames[2].frames[1].frames[0].document.forms[0].r_postal_code_desc.value="<%=post_code%>";


							parent.parent.frames[2].frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=";

						}else{

							parent.frames[1].frames[0].document.forms[0].race_desc.value="<%=race_desc%>";
							parent.frames[1].frames[0].document.forms[0].race_code.value="<%=race_code%>";			
							

							parent.frames[1].frames[0].document.forms[0].birth_place.value="<%=birth_place_desc%>";
							parent.frames[1].frames[0].document.forms[0].Birth_place_code.value="<%=birth_place_code%>";

							parent.frames[1].frames[0].document.forms[0].res_town_desc.value="<%=city_desc%>";
							parent.frames[1].frames[0].document.forms[0].res_town_code.value="<%=city_code%>";

							parent.frames[1].frames[0].document.forms[0].res_area_desc.value="<%=area_desc%>";
							parent.frames[1].frames[0].document.forms[0].res_area_code.value="<%=area_code%>";

							parent.frames[1].frames[0].document.forms[0].region_desc.value="<%=state_desc%>";
							parent.frames[1].frames[0].document.forms[0].region_code.value="<%=state_code%>";

							parent.frames[1].frames[0].document.forms[0].postal_code.value="<%=post_code%>";
							parent.frames[1].frames[0].document.forms[0].r_postal_code_desc.value="<%=post_code%>";


							parent.frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=";
						}
					}
					if(function_name=='WTLST'){
											
						parent.frames[1].document.forms[0].race_desc.value="<%=race_desc%>";
						parent.frames[1].document.forms[0].race_code.value="<%=race_code%>";			
						

						parent.frames[1].document.forms[0].birth_place.value="<%=birth_place_desc%>";
						parent.frames[1].document.forms[0].Birth_place_code.value="<%=birth_place_code%>";

						parent.frames[1].document.forms[0].res_town_desc.value="<%=city_desc%>";
						parent.frames[1].document.forms[0].res_town_code.value="<%=city_code%>";

						parent.frames[1].document.forms[0].res_area_desc.value="<%=area_desc%>";
						parent.frames[1].document.forms[0].res_area_code.value="<%=area_code%>";

						parent.frames[1].document.forms[0].region_desc.value="<%=state_desc%>";
						parent.frames[1].document.forms[0].region_code.value="<%=state_code%>";

						parent.frames[1].document.forms[0].postal_code.value="<%=post_code%>";
						parent.frames[1].document.forms[0].r_postal_code_desc.value="<%=post_code%>";


						parent.frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}

					if(function_name=='WTMGMT'){
						if(parent.frames[1].document.forms[0].r_town_code){
							parent.frames[1].document.forms[0].r_town_code.value="<%=city_desc%>";
							parent.frames[1].document.forms[0].r_town.value="<%=city_code%>";
						}

						if(parent.frames[1].document.forms[0].r_area_code){
							parent.frames[1].document.forms[0].r_area_code.value="<%=area_desc%>";
							parent.frames[1].document.forms[0].r_area.value="<%=area_code%>";
						}

						if(parent.frames[1].document.forms[0].r_region_code){
							parent.frames[1].document.forms[0].r_region_code.value="<%=state_desc%>";
							parent.frames[1].document.forms[0].r_region.value="<%=state_code%>";
						}

						parent.frames[5].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}


					if(function_name=='IPBOOKING'){
											
						parent.frames[1].document.forms[0].race_desc.value="<%=race_desc%>";
						parent.frames[1].document.forms[0].race_code.value="<%=race_code%>";			
						

						parent.frames[1].document.forms[0].birth_place.value="<%=birth_place_desc%>";
						parent.frames[1].document.forms[0].Birth_place_code.value="<%=birth_place_code%>";

						parent.frames[1].document.forms[0].res_town_desc.value="<%=city_desc%>";
						parent.frames[1].document.forms[0].res_town_code.value="<%=city_code%>";

						parent.frames[1].document.forms[0].res_area_desc.value="<%=area_desc%>";
						parent.frames[1].document.forms[0].res_area_code.value="<%=area_code%>";

						parent.frames[1].document.forms[0].region_desc.value="<%=state_desc%>";
						parent.frames[1].document.forms[0].region_code.value="<%=state_code%>";

						parent.frames[1].document.forms[0].postal_code.value="<%=post_code%>";
						parent.frames[1].document.forms[0].r_postal_code_desc.value="<%=post_code%>";


						parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}
				}else if (caller_form=='03'){

					if(function_name=='PAT_REGN'){
						parent.frames[1].frames[1].document.forms[0].race_desc.value="<%=race_desc%>";
						parent.frames[1].frames[1].document.forms[0].race_code.value="<%=race_code%>";
						
						parent.frames[1].frames[1].document.forms[0].relgn_desc.value="<%=religion_desc%>";
						parent.frames[1].frames[1].document.forms[0].relgn_code.value="<%=religion_code%>";

						if(parent.frames[1].frames[1].document.forms[0].r_town_code){
							parent.frames[1].frames[1].document.forms[0].r_town_code.value="<%=city_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_town.value="<%=city_code%>";
						}

						/*if(parent.frames[1].frames[1].document.forms[0].r_area_code){
							parent.frames[1].frames[1].document.forms[0].r_area_code.value="<%=area_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_area.value="<%=area_code%>";
						}*/

						if(parent.frames[1].frames[1].document.forms[0].r_region_code){
							parent.frames[1].frames[1].document.forms[0].r_region_code.value="<%=state_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_region.value="<%=state_code%>";
						}

						if(parent.frames[1].frames[1].document.forms[0].r_postal_code1){
							parent.frames[1].frames[1].document.forms[0].r_postal_code1.value="<%=post_code_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_postal_code.value="<%=post_code%>";
						}

						if(Calledfrom =='P' || Calledfrom=='R'){
							parent.frames[1].frames[1].document.forms[0].r_country_desc.value=parent.frames[1].frames[1].document.forms[0].nationality_desc.value;
							parent.frames[1].frames[1].document.forms[0].r_country_code.value=parent.frames[1].frames[1].document.forms[0].nationality_code.value;
						}
						
						/*if(father_yn=='N' &&  mother_yn=='N'){
							if(parent.frames[1].frames[1].document.forms[0].place_of_birth_desc){
								parent.frames[1].frames[1].document.forms[0].place_of_birth_desc.value="<%=birth_place_desc%>";
								parent.frames[1].frames[1].document.forms[0].place_of_birth_code.value="<%=birth_place_code%>";
							}
						}*/
						
						if(mother_yn=='03'){
							if(parent.frames[1].frames[1].document.forms[0].next_contact_relation_desc){
								parent.frames[1].frames[1].document.forms[0].next_contact_relation_desc.value="<%=mother_relation_desc%>";
								parent.frames[1].frames[1].document.forms[0].next_contact_relation.value="<%=mother_yn%>";
							}
						}else{
							parent.frames[1].frames[1].document.forms[0].Photo_upload_yn.value="Y";
						}
						
						if(father_yn=='04'){
							if(parent.frames[1].frames[1].document.forms[0].first_contact_relation_desc){
								parent.frames[1].frames[1].document.forms[0].first_contact_relation_desc.value="<%=father_relation_desc%>";
								parent.frames[1].frames[1].document.forms[0].first_contact_relation.value="<%=father_yn%>";
							}
						}else{
							parent.frames[1].frames[1].document.forms[0].Photo_upload_yn.value="Y";
						}
						

						parent.parent.frames[2].frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}

					if(function_name=='CHANGEPAT'){
						parent.frames[1].frames[1].document.forms[0].race_desc.value="<%=race_desc%>";
						parent.frames[1].frames[1].document.forms[0].race_code.value="<%=race_code%>";
						
						parent.frames[1].frames[1].document.forms[0].relgn_desc.value="<%=religion_desc%>";
						parent.frames[1].frames[1].document.forms[0].relgn_code.value="<%=religion_code%>";

						if(parent.frames[1].frames[1].document.forms[0].r_town_code){
							parent.frames[1].frames[1].document.forms[0].r_town_code.value="<%=city_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_town.value="<%=city_code%>";
						}

						/*if(parent.frames[1].frames[1].document.forms[0].r_area_code){
							parent.frames[1].frames[1].document.forms[0].r_area_code.value="<%=area_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_area.value="<%=area_code%>";
						}*/

						if(parent.frames[1].frames[1].document.forms[0].r_region_code){
							parent.frames[1].frames[1].document.forms[0].r_region_code.value="<%=state_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_region.value="<%=state_code%>";
						}

						if(parent.frames[1].frames[1].document.forms[0].r_postal_code1){
							parent.frames[1].frames[1].document.forms[0].r_postal_code1.value="<%=post_code_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_postal_code.value="<%=post_code%>";
						}
 
						parent.frames[1].frames[1].document.forms[0].r_country_desc.value=parent.frames[1].frames[1].document.forms[0].nationality_desc.value;
						parent.frames[1].frames[1].document.forms[0].r_country_code.value=parent.frames[1].frames[1].document.forms[0].nationality_code.value;
						
						/*if(parent.frames[1].frames[1].document.forms[0].place_of_birth_desc){
							parent.frames[1].frames[1].document.forms[0].place_of_birth_desc.value="<%=birth_place_desc%>";
							parent.frames[1].frames[1].document.forms[0].place_of_birth_code.value="<%=birth_place_code%>";
						}*/

						if(mother_yn=='03'){
							if(parent.frames[1].frames[1].document.forms[0].next_contact_relation_desc){
								parent.frames[1].frames[1].document.forms[0].next_contact_relation_desc.value="<%=mother_relation_desc%>";
								parent.frames[1].frames[1].document.forms[0].next_contact_relation.value="<%=mother_yn%>";
							}
						}
						
						if(father_yn=='04'){
							if(parent.frames[1].frames[1].document.forms[0].first_contact_relation_desc){
								parent.frames[1].frames[1].document.forms[0].first_contact_relation_desc.value="<%=father_relation_desc%>";
								parent.frames[1].frames[1].document.forms[0].first_contact_relation.value="<%=father_yn%>";
							}
						}

						parent.parent.frames[2].frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}

					


					if(function_name=='BOOK_APPT'){
										

						parent.parent.frames[0].document.forms[0].race_desc.value="<%=race_desc%>";
						parent.parent.frames[0].document.forms[0].race_code.value="<%=race_code%>";			
						

						parent.parent.frames[0].document.forms[0].birth_place.value="<%=birth_place_desc%>";
						parent.parent.frames[0].document.forms[0].place_of_birth.value="<%=birth_place_code%>";

						parent.parent.frames[0].document.forms[0].res_town_desc.value="<%=city_desc%>";
						parent.parent.frames[0].document.forms[0].res_town_code.value="<%=city_code%>";

						/*parent.parent.frames[0].document.forms[0].res_area_desc.value="<%=area_desc%>";
						parent.parent.frames[0].document.forms[0].res_area_code.value="<%=area_code%>";
						*/

						parent.parent.frames[0].document.forms[0].region_desc.value="<%=state_desc%>";
						parent.parent.frames[0].document.forms[0].region_code.value="<%=state_code%>";

						parent.parent.frames[0].document.forms[0].postal_code.value="<%=post_code%>";
						parent.parent.frames[0].document.forms[0].r_postal_code_desc.value="<%=post_code%>";


						parent.parent.frames[4].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}

					if(function_name=='PAT_SEARCH'){
										

						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group_desc.value="<%=race_desc%>";
						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group.value="<%=race_code%>";	
						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group_desc_hid.value="<%=race_desc%>";
						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group_hid.value="<%=race_code%>";	

											
						
						parent.parent.parent.frames[6].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}
					

					if(function_name=='VSTREG'){
										
						if(parent.frames[1].frames[1].document.forms[0].r_town_code){
							parent.frames[1].frames[1].document.forms[0].r_town_code.value="<%=city_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_town.value="<%=city_code%>";

							/*parent.frames[1].frames[1].document.forms[0].r_area_code.value="<%=area_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_area.value="<%=area_code%>";
							*/
	 
							parent.frames[1].frames[1].document.forms[0].r_region_code.value="<%=state_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_region.value="<%=state_code%>";
						}
						
						parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}

					if(function_name=='REGREF'){

						if(from_OA=='N'){	
							if(parent.parent.frames[1].name=="f_query_add_mod"){
								parent.parent.frames[1].frames[0].document.forms[0].race_desc.value="<%=race_desc%>";
								parent.parent.frames[1].frames[0].document.forms[0].race_code.value="<%=race_code%>";			
								

								parent.parent.frames[1].frames[0].document.forms[0].birth_place.value="<%=birth_place_desc%>";
								parent.parent.frames[1].frames[0].document.forms[0].Birth_place_code.value="<%=birth_place_code%>";

								parent.parent.frames[1].frames[0].document.forms[0].res_town_desc.value="<%=city_desc%>";
								parent.parent.frames[1].frames[0].document.forms[0].res_town_code.value="<%=city_code%>";

								/*parent.parent.frames[1].frames[0].document.forms[0].res_area_desc.value="<%=area_desc%>";
								parent.parent.frames[1].frames[0].document.forms[0].res_area_code.value="<%=area_code%>";
								*/
								parent.parent.frames[1].frames[0].document.forms[0].region_desc.value="<%=state_desc%>";
								parent.parent.frames[1].frames[0].document.forms[0].region_code.value="<%=state_code%>";

								parent.parent.frames[1].frames[0].document.forms[0].postal_code.value="<%=post_code%>";
								parent.parent.frames[1].frames[0].document.forms[0].r_postal_code_desc.value="<%=post_code%>";


								parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";

								
							}else{

								parent.parent.frames[2].frames[1].frames[0].document.forms[0].race_desc.value="<%=race_desc%>";
								parent.parent.frames[2].frames[1].frames[0].document.forms[0].race_code.value="<%=race_code%>";			
								

								parent.parent.frames[2].frames[1].frames[0].document.forms[0].birth_place.value="<%=birth_place_desc%>";
								parent.parent.frames[2].frames[1].frames[0].document.forms[0].Birth_place_code.value="<%=birth_place_code%>";

								parent.parent.frames[2].frames[1].frames[0].document.forms[0].res_town_desc.value="<%=city_desc%>";
								parent.parent.frames[2].frames[1].frames[0].document.forms[0].res_town_code.value="<%=city_code%>";

								/*parent.parent.frames[2].frames[1].frames[0].document.forms[0].res_area_desc.value="<%=area_desc%>";
								parent.parent.frames[2].frames[1].frames[0].document.forms[0].res_area_code.value="<%=area_code%>";
								*/
								parent.parent.frames[2].frames[1].frames[0].document.forms[0].region_desc.value="<%=state_desc%>";
								parent.parent.frames[2].frames[1].frames[0].document.forms[0].region_code.value="<%=state_code%>";

								parent.parent.frames[2].frames[1].frames[0].document.forms[0].postal_code.value="<%=post_code%>";
								parent.parent.frames[2].frames[1].frames[0].document.forms[0].r_postal_code_desc.value="<%=post_code%>";


								parent.parent.frames[2].frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=";
							}

							
						}else{

							parent.frames[1].frames[0].document.forms[0].race_desc.value="<%=race_desc%>";
							parent.frames[1].frames[0].document.forms[0].race_code.value="<%=race_code%>";			
							

							parent.frames[1].frames[0].document.forms[0].birth_place.value="<%=birth_place_desc%>";
							parent.frames[1].frames[0].document.forms[0].Birth_place_code.value="<%=birth_place_code%>";

							parent.frames[1].frames[0].document.forms[0].res_town_desc.value="<%=city_desc%>";
							parent.frames[1].frames[0].document.forms[0].res_town_code.value="<%=city_code%>";

							/*parent.frames[1].frames[0].document.forms[0].res_area_desc.value="<%=area_desc%>";
							parent.frames[1].frames[0].document.forms[0].res_area_code.value="<%=area_code%>";
							*/
							parent.frames[1].frames[0].document.forms[0].region_desc.value="<%=state_desc%>";
							parent.frames[1].frames[0].document.forms[0].region_code.value="<%=state_code%>";

							parent.frames[1].frames[0].document.forms[0].postal_code.value="<%=post_code%>";
							parent.frames[1].frames[0].document.forms[0].r_postal_code_desc.value="<%=post_code%>";


							parent.frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=";
						}
					}
					if(function_name=='WTLST'){
											
						parent.frames[1].document.forms[0].race_desc.value="<%=race_desc%>";
						parent.frames[1].document.forms[0].race_code.value="<%=race_code%>";			
						

						parent.frames[1].document.forms[0].birth_place.value="<%=birth_place_desc%>";
						parent.frames[1].document.forms[0].Birth_place_code.value="<%=birth_place_code%>";

						parent.frames[1].document.forms[0].res_town_desc.value="<%=city_desc%>";
						parent.frames[1].document.forms[0].res_town_code.value="<%=city_code%>";

						/*parent.frames[1].document.forms[0].res_area_desc.value="<%=area_desc%>";
						parent.frames[1].document.forms[0].res_area_code.value="<%=area_code%>";
						*/
						parent.frames[1].document.forms[0].region_desc.value="<%=state_desc%>";
						parent.frames[1].document.forms[0].region_code.value="<%=state_code%>";

						parent.frames[1].document.forms[0].postal_code.value="<%=post_code%>";
						parent.frames[1].document.forms[0].r_postal_code_desc.value="<%=post_code%>";


						parent.frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}

					if(function_name=='WTMGMT'){
						if(parent.frames[1].document.forms[0].r_town_code){
							parent.frames[1].document.forms[0].r_town_code.value="<%=city_desc%>";
							parent.frames[1].document.forms[0].r_town.value="<%=city_code%>";
						}

						/*if(parent.frames[1].document.forms[0].r_area_code){
							parent.frames[1].document.forms[0].r_area_code.value="<%=area_desc%>";
							parent.frames[1].document.forms[0].r_area.value="<%=area_code%>";
						}*/

						if(parent.frames[1].document.forms[0].r_region_code){
							parent.frames[1].document.forms[0].r_region_code.value="<%=state_desc%>";
							parent.frames[1].document.forms[0].r_region.value="<%=state_code%>";
						}

						parent.frames[5].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}


					if(function_name=='IPBOOKING'){
											
						parent.frames[1].document.forms[0].race_desc.value="<%=race_desc%>";
						parent.frames[1].document.forms[0].race_code.value="<%=race_code%>";			
						

						parent.frames[1].document.forms[0].birth_place.value="<%=birth_place_desc%>";
						parent.frames[1].document.forms[0].Birth_place_code.value="<%=birth_place_code%>";

						parent.frames[1].document.forms[0].res_town_desc.value="<%=city_desc%>";
						parent.frames[1].document.forms[0].res_town_code.value="<%=city_code%>";

						/*parent.frames[1].document.forms[0].res_area_desc.value="<%=area_desc%>";
						parent.frames[1].document.forms[0].res_area_code.value="<%=area_code%>";
						*/
						parent.frames[1].document.forms[0].region_desc.value="<%=state_desc%>";
						parent.frames[1].document.forms[0].region_code.value="<%=state_code%>";

						parent.frames[1].document.forms[0].postal_code.value="<%=post_code%>";
						parent.frames[1].document.forms[0].r_postal_code_desc.value="<%=post_code%>";


						parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}
				
				}else if (caller_form=='04'){

					if(function_name=='PAT_REGN'){
						parent.frames[1].frames[1].document.forms[0].race_desc.value="<%=race_desc%>";
						parent.frames[1].frames[1].document.forms[0].race_code.value="<%=race_code%>";
						
						parent.frames[1].frames[1].document.forms[0].relgn_desc.value="<%=religion_desc%>";
						parent.frames[1].frames[1].document.forms[0].relgn_code.value="<%=religion_code%>";

						/*if(parent.frames[1].frames[1].document.forms[0].r_town_code){
							parent.frames[1].frames[1].document.forms[0].r_town_code.value="<%=city_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_town.value="<%=city_code%>";
						}*/
						
						//alert('-->'+birth_cert_no+'<--')
						if(birth_cert_no!='' ){				
							if( parent.frames[1].frames[1].document.forms[0].other_alt_id){
								parent.frames[1].frames[1].document.forms[0].other_alt_id.value='07';
							}

							if( parent.frames[1].frames[1].document.forms[0].other_alt_Id_text){
								parent.frames[1].frames[1].document.forms[0].other_alt_Id_text.value=birth_cert_no;
							}
						}
						
						if(parent.frames[1].frames[1].document.forms[0].r_area_code){
							parent.frames[1].frames[1].document.forms[0].r_area_code.value="<%=area_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_area.value="<%=area_code%>";

						
							if(parent.frames[1].frames[1].document.forms[0].r_area_code.value==''){
								if(parent.frames[1].frames[1].document.forms[0].r_addr_line4){
									parent.frames[1].frames[1].document.forms[0].r_addr_line4.value="<%=city_desc%>";	
								}
							}
						}
						
						
						if(parent.frames[1].frames[1].document.forms[0].r_region_code){
							parent.frames[1].frames[1].document.forms[0].r_region_code.value="<%=state_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_region.value="<%=state_code%>";
						}

						if(parent.frames[1].frames[1].document.forms[0].r_postal_code1){
							parent.frames[1].frames[1].document.forms[0].r_postal_code1.value="<%=post_code_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_postal_code.value="<%=post_code%>";
						}

						if(Calledfrom =='P' || Calledfrom=='R'){
							parent.frames[1].frames[1].document.forms[0].r_country_desc.value=parent.frames[1].frames[1].document.forms[0].nationality_desc.value;
							parent.frames[1].frames[1].document.forms[0].r_country_code.value=parent.frames[1].frames[1].document.forms[0].nationality_code.value;
						}
						
						if(father_yn=='N' &&  mother_yn=='N'){
							if(parent.frames[1].frames[1].document.forms[0].place_of_birth_desc){
								parent.frames[1].frames[1].document.forms[0].place_of_birth_desc.value="<%=birth_place_desc%>";
								parent.frames[1].frames[1].document.forms[0].place_of_birth_code.value="<%=birth_place_code%>";
							}
						}
						parent.parent.frames[0].document.forms[0].place_of_birth.value="<%=birth_place_code%>";
						if(mother_yn=='95'){
							if(parent.frames[1].frames[1].document.forms[0].next_contact_relation_desc){
								parent.frames[1].frames[1].document.forms[0].next_contact_relation_desc.value="<%=mother_relation_desc%>";
								parent.frames[1].frames[1].document.forms[0].next_contact_relation.value="<%=mother_yn%>";
							}
						}else{
							if(parent.frames[1].frames[1].document.forms[0].Photo_upload_yn){
								parent.frames[1].frames[1].document.forms[0].Photo_upload_yn.value="Y";
							}
						}
						
						if(father_yn=='94'){
							if(parent.frames[1].frames[1].document.forms[0].first_contact_relation_desc){
								parent.frames[1].frames[1].document.forms[0].first_contact_relation_desc.value="<%=father_relation_desc%>";
								parent.frames[1].frames[1].document.forms[0].first_contact_relation.value="<%=father_yn%>";
							}
						}else{
							if(parent.frames[1].frames[1].document.forms[0].Photo_upload_yn){
								parent.frames[1].frames[1].document.forms[0].Photo_upload_yn.value="Y";
							}
						}
						

						parent.parent.frames[2].frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}

					if(function_name=='CHANGEPAT'){
						parent.frames[1].frames[1].document.forms[0].race_desc.value="<%=race_desc%>";
						parent.frames[1].frames[1].document.forms[0].race_code.value="<%=race_code%>";
						
						parent.frames[1].frames[1].document.forms[0].relgn_desc.value="<%=religion_desc%>";
						parent.frames[1].frames[1].document.forms[0].relgn_code.value="<%=religion_code%>";

						if(birth_cert_no!='' ){				
							if( parent.frames[1].frames[1].document.forms[0].other_alt_id){
								parent.frames[1].frames[1].document.forms[0].other_alt_id.value='07';
							}

							if( parent.frames[1].frames[1].document.forms[0].other_alt_Id_text){
								parent.frames[1].frames[1].document.forms[0].other_alt_Id_text.value=birth_cert_no;
							}
						}

						/*if(parent.frames[1].frames[1].document.forms[0].r_town_code){
							parent.frames[1].frames[1].document.forms[0].r_town_code.value="<%=city_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_town.value="<%=city_code%>";
						}*/

						if(parent.frames[1].frames[1].document.forms[0].r_area_code){
							parent.frames[1].frames[1].document.forms[0].r_area_code.value="<%=area_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_area.value="<%=area_code%>";

							if(parent.frames[1].frames[1].document.forms[0].r_area_code.value==''){
								if(parent.frames[1].frames[1].document.forms[0].r_addr_line4){
									parent.frames[1].frames[1].document.forms[0].r_addr_line4.value="<%=city_desc%>";	
								}
							}
						}					

						if(parent.frames[1].frames[1].document.forms[0].r_region_code){
							parent.frames[1].frames[1].document.forms[0].r_region_code.value="<%=state_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_region.value="<%=state_code%>";
						}

						if(parent.frames[1].frames[1].document.forms[0].r_postal_code1){
							parent.frames[1].frames[1].document.forms[0].r_postal_code1.value="<%=post_code_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_postal_code.value="<%=post_code%>";
						}
 
						parent.frames[1].frames[1].document.forms[0].r_country_desc.value=parent.frames[1].frames[1].document.forms[0].nationality_desc.value;
						parent.frames[1].frames[1].document.forms[0].r_country_code.value=parent.frames[1].frames[1].document.forms[0].nationality_code.value;
						
						if(parent.frames[1].frames[1].document.forms[0].place_of_birth_desc){
							parent.frames[1].frames[1].document.forms[0].place_of_birth_desc.value="<%=birth_place_desc%>";
							parent.frames[1].frames[1].document.forms[0].place_of_birth_code.value="<%=birth_place_code%>";
						}

						if(mother_yn=='95'){
							if(parent.frames[1].frames[1].document.forms[0].next_contact_relation_desc){
								parent.frames[1].frames[1].document.forms[0].next_contact_relation_desc.value="<%=mother_relation_desc%>";
								parent.frames[1].frames[1].document.forms[0].next_contact_relation.value="<%=mother_yn%>";
							}
						}
						
						if(father_yn=='94'){
							if(parent.frames[1].frames[1].document.forms[0].first_contact_relation_desc){
								parent.frames[1].frames[1].document.forms[0].first_contact_relation_desc.value="<%=father_relation_desc%>";
								parent.frames[1].frames[1].document.forms[0].first_contact_relation.value="<%=father_yn%>";
							}
						}

						parent.parent.frames[2].frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}

					


					if(function_name=='BOOK_APPT'){
										

						parent.parent.frames[0].document.forms[0].race_desc.value="<%=race_desc%>";
						parent.parent.frames[0].document.forms[0].race_code.value="<%=race_code%>";			
						

						parent.parent.frames[0].document.forms[0].birth_place.value="<%=birth_place_desc%>";
						parent.parent.frames[0].document.forms[0].birth_place.blur();
						parent.parent.frames[0].document.forms[0].place_of_birth.value="<%=birth_place_code%>";

						/*
						parent.parent.frames[0].document.forms[0].res_town_desc.value="<%=city_desc%>";
						parent.parent.frames[0].document.forms[0].res_town_code.value="<%=city_code%>";
						*/

						parent.parent.frames[0].document.forms[0].res_area_desc.value="<%=area_desc%>";
						parent.parent.frames[0].document.forms[0].res_area_code.value="<%=area_code%>";
						

						parent.parent.frames[0].document.forms[0].region_desc.value="<%=state_desc%>";
						parent.parent.frames[0].document.forms[0].region_code.value="<%=state_code%>";

						parent.parent.frames[0].document.forms[0].postal_code.value="<%=post_code%>";
						parent.parent.frames[0].document.forms[0].r_postal_code_desc.value="<%=post_code%>";


						parent.parent.frames[4].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}

					if(function_name=='PAT_SEARCH'){
										

						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group_desc.value="<%=race_desc%>";
						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group.value="<%=race_code%>";	
						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group_desc_hid.value="<%=race_desc%>";
						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group_hid.value="<%=race_code%>";	

											
						
						parent.parent.parent.frames[6].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}
					

					if(function_name=='VSTREG'){
										
						if(parent.frames[1].frames[1].document.forms[0].r_area_code){
							/*parent.frames[1].frames[1].document.forms[0].r_town_code.value="<%=city_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_town.value="<%=city_code%>";
							*/

							parent.frames[1].frames[1].document.forms[0].r_area_code.value="<%=area_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_area.value="<%=area_code%>";
							
	 
							parent.frames[1].frames[1].document.forms[0].r_region_code.value="<%=state_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_region.value="<%=state_code%>";
						}
						
						parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}

					if(function_name=='REGREF'){

						if(from_OA=='N'){	
							if(parent.parent.frames[1].name=="f_query_add_mod"){
								parent.parent.frames[1].frames[0].document.forms[0].race_desc.value="<%=race_desc%>";
								parent.parent.frames[1].frames[0].document.forms[0].race_code.value="<%=race_code%>";			
								

								parent.parent.frames[1].frames[0].document.forms[0].birth_place.value="<%=birth_place_desc%>";
								parent.parent.frames[1].frames[0].document.forms[0].Birth_place_code.value="<%=birth_place_code%>";

								/*parent.parent.frames[1].frames[0].document.forms[0].res_town_desc.value="<%=city_desc%>";
								parent.parent.frames[1].frames[0].document.forms[0].res_town_code.value="<%=city_code%>";
								*/
								
								parent.parent.frames[1].frames[0].document.forms[0].res_area_desc.value="<%=area_desc%>";
								parent.parent.frames[1].frames[0].document.forms[0].res_area_code.value="<%=area_code%>";
								
								parent.parent.frames[1].frames[0].document.forms[0].region_desc.value="<%=state_desc%>";
								parent.parent.frames[1].frames[0].document.forms[0].region_code.value="<%=state_code%>";

								parent.parent.frames[1].frames[0].document.forms[0].postal_code.value="<%=post_code%>";
								parent.parent.frames[1].frames[0].document.forms[0].r_postal_code_desc.value="<%=post_code%>";


								parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";

								
							}else{

								parent.parent.frames[2].frames[1].frames[0].document.forms[0].race_desc.value="<%=race_desc%>";
								parent.parent.frames[2].frames[1].frames[0].document.forms[0].race_code.value="<%=race_code%>";			
								

								parent.parent.frames[2].frames[1].frames[0].document.forms[0].birth_place.value="<%=birth_place_desc%>";
								parent.parent.frames[2].frames[1].frames[0].document.forms[0].Birth_place_code.value="<%=birth_place_code%>";

								/*parent.parent.frames[2].frames[1].frames[0].document.forms[0].res_town_desc.value="<%=city_desc%>";
								parent.parent.frames[2].frames[1].frames[0].document.forms[0].res_town_code.value="<%=city_code%>";
								*/
								parent.parent.frames[2].frames[1].frames[0].document.forms[0].res_area_desc.value="<%=area_desc%>";
								parent.parent.frames[2].frames[1].frames[0].document.forms[0].res_area_code.value="<%=area_code%>";
								
								parent.parent.frames[2].frames[1].frames[0].document.forms[0].region_desc.value="<%=state_desc%>";
								parent.parent.frames[2].frames[1].frames[0].document.forms[0].region_code.value="<%=state_code%>";

								parent.parent.frames[2].frames[1].frames[0].document.forms[0].postal_code.value="<%=post_code%>";
								parent.parent.frames[2].frames[1].frames[0].document.forms[0].r_postal_code_desc.value="<%=post_code%>";


								parent.parent.frames[2].frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=";
							}

							
						}else{

							parent.frames[1].frames[0].document.forms[0].race_desc.value="<%=race_desc%>";
							parent.frames[1].frames[0].document.forms[0].race_code.value="<%=race_code%>";			
							

							parent.frames[1].frames[0].document.forms[0].birth_place.value="<%=birth_place_desc%>";
							parent.frames[1].frames[0].document.forms[0].Birth_place_code.value="<%=birth_place_code%>";

							/*parent.frames[1].frames[0].document.forms[0].res_town_desc.value="<%=city_desc%>";
							parent.frames[1].frames[0].document.forms[0].res_town_code.value="<%=city_code%>";
							*/
							parent.frames[1].frames[0].document.forms[0].res_area_desc.value="<%=area_desc%>";
							parent.frames[1].frames[0].document.forms[0].res_area_code.value="<%=area_code%>";
							
							parent.frames[1].frames[0].document.forms[0].region_desc.value="<%=state_desc%>";
							parent.frames[1].frames[0].document.forms[0].region_code.value="<%=state_code%>";

							parent.frames[1].frames[0].document.forms[0].postal_code.value="<%=post_code%>";
							parent.frames[1].frames[0].document.forms[0].r_postal_code_desc.value="<%=post_code%>";


							parent.frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=";
						}
					}
					if(function_name=='WTLST'){
											
						parent.frames[1].document.forms[0].race_desc.value="<%=race_desc%>";
						parent.frames[1].document.forms[0].race_code.value="<%=race_code%>";			
						

						parent.frames[1].document.forms[0].birth_place.value="<%=birth_place_desc%>";
						parent.frames[1].document.forms[0].Birth_place_code.value="<%=birth_place_code%>";

						/*parent.frames[1].document.forms[0].res_town_desc.value="<%=city_desc%>";
						parent.frames[1].document.forms[0].res_town_code.value="<%=city_code%>";
						*/
						parent.frames[1].document.forms[0].res_area_desc.value="<%=area_desc%>";
						parent.frames[1].document.forms[0].res_area_code.value="<%=area_code%>";
						
						parent.frames[1].document.forms[0].region_desc.value="<%=state_desc%>";
						parent.frames[1].document.forms[0].region_code.value="<%=state_code%>";

						parent.frames[1].document.forms[0].postal_code.value="<%=post_code%>";
						parent.frames[1].document.forms[0].r_postal_code_desc.value="<%=post_code%>";


						parent.frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}

					if(function_name=='WTMGMT'){
						/*if(parent.frames[1].document.forms[0].r_town_code){
							parent.frames[1].document.forms[0].r_town_code.value="<%=city_desc%>";
							parent.frames[1].document.forms[0].r_town.value="<%=city_code%>";
						}
						*/
						if(parent.frames[1].document.forms[0].r_area_code){
							parent.frames[1].document.forms[0].r_area_code.value="<%=area_desc%>";
							parent.frames[1].document.forms[0].r_area.value="<%=area_code%>";
						}

						if(parent.frames[1].document.forms[0].r_region_code){
							parent.frames[1].document.forms[0].r_region_code.value="<%=state_desc%>";
							parent.frames[1].document.forms[0].r_region.value="<%=state_code%>";
						}

						parent.frames[5].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}


					if(function_name=='IPBOOKING'){
											
						parent.frames[1].document.forms[0].race_desc.value="<%=race_desc%>";
						parent.frames[1].document.forms[0].race_code.value="<%=race_code%>";			
						

						parent.frames[1].document.forms[0].birth_place.value="<%=birth_place_desc%>";
						parent.frames[1].document.forms[0].Birth_place_code.value="<%=birth_place_code%>";

						/*parent.frames[1].document.forms[0].res_town_desc.value="<%=city_desc%>";
						parent.frames[1].document.forms[0].res_town_code.value="<%=city_code%>";
						*/
						parent.frames[1].document.forms[0].res_area_desc.value="<%=area_desc%>";
						parent.frames[1].document.forms[0].res_area_code.value="<%=area_code%>";
						
						parent.frames[1].document.forms[0].region_desc.value="<%=state_desc%>";
						parent.frames[1].document.forms[0].region_code.value="<%=state_code%>";

						parent.frames[1].document.forms[0].postal_code.value="<%=post_code%>";
						parent.frames[1].document.forms[0].r_postal_code_desc.value="<%=post_code%>";


						parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}
				
				}
				else if (caller_form=='05'){ //Related to Taiba
					if(function_name=='PAT_REGN' ||function_name=='CHANGEPAT'){
					if(inst=='NC' || inst=='CP'){
						parent.frames[1].frames[1].document.forms[0].nationality_desc.value="<%=nationality_desc%>";
						parent.frames[1].frames[1].document.forms[0].nationality_code.value="<%=nationality_code%>";	
						parent.frames[1].frames[1].document.forms[0].blood_group.value="<%=blood_grp_code%>";
						parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}
					}
					/*else if(inst=='PS'){
						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].nationality_desc.value="<%=nationality_desc%>";
						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].nationality_desc_hid.value="<%=nationality_desc%>";
						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].Nationality_hid.value="<%=nationality_code%>";
						parent.parent.frames[5].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}	*/
					

				}
				else if (caller_form=='06'){ // Maheshwaran k added for ML-MMOH-CRF-1908 - related to Serdang
					if(function_name=='PAT_REGN'){
					if(parent.frames[1].frames[1].document.forms[0].other_alt_id)
							{
							parent.frames[1].frames[1].document.forms[0].other_alt_id.value="<%=alt_id_type_code%>";
							}
						if(parent.frames[1].frames[1].document.forms[0].notify_oth_alt_id_type)
							{
							parent.frames[1].frames[1].document.forms[0].notify_oth_alt_id_type.value="<%=father_doc_type_code%>";
							}		
						parent.frames[1].frames[1].document.forms[0].race_desc.value="<%=race_desc%>";
						parent.frames[1].frames[1].document.forms[0].race_code.value="<%=race_code%>";
						
						parent.frames[1].frames[1].document.forms[0].relgn_desc.value="<%=religion_desc%>";
						parent.frames[1].frames[1].document.forms[0].relgn_code.value="<%=religion_code%>";

					/*	if(parent.frames[1].frames[1].document.forms[0].r_town_code){
							parent.frames[1].frames[1].document.forms[0].r_town_code.value="<%=city_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_town.value="<%=city_code%>";
						}*/

						if(parent.frames[1].frames[1].document.forms[0].r_area_code){
							parent.frames[1].frames[1].document.forms[0].r_area_code.value="<%=city_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_area.value="<%=city_code%>";
						}

						if(parent.frames[1].frames[1].document.forms[0].r_region_code){
							parent.frames[1].frames[1].document.forms[0].r_region_code.value="<%=state_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_region.value="<%=state_code%>";
						}
						

						if(parent.frames[1].frames[1].document.forms[0].r_postal_code1){
							parent.frames[1].frames[1].document.forms[0].r_postal_code1.value="<%=post_code_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_postal_code.value="<%=post_code%>";
						}

						if(Calledfrom =='P' || Calledfrom=='R'){
							parent.frames[1].frames[1].document.forms[0].r_country_desc.value="<%=nationality_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_country_code.value="<%=nationality_code%>";
						}
	
						if(father_yn=='RE07' ||  mother_yn=='RE01'){
							if(parent.frames[1].frames[1].document.forms[0].place_of_birth_desc){
								parent.frames[1].frames[1].document.forms[0].place_of_birth_desc.value="<%=birth_place_desc%>";
								parent.frames[1].frames[1].document.forms[0].place_of_birth_code.value="<%=birth_place_code%>";
							}
						}
					//	parent.frames[1].frames[1].document.forms[0].other_alt_id.value="<%=alt_id_type_desc1%>";
					
						//document.forms[0].other_alt_id
						if(mother_yn=='RE01'){
							if(parent.frames[1].frames[1].document.forms[0].next_contact_relation_desc){
								parent.frames[1].frames[1].document.forms[0].next_contact_relation_desc.value="<%=mother_relation_desc%>";
								parent.frames[1].frames[1].document.forms[0].next_contact_relation.value="<%=mother_yn%>";
							}
							if(parent.frames[1].frames[1].document.forms[0].next_contact_relation){
								parent.frames[1].frames[1].document.forms[0].next_contact_relation.value="<%=mother_yn%>";
							}
						}else{
						//	parent.frames[1].frames[1].document.forms[0].Photo_upload_yn.value="Y";
						}
						if(father_yn=='RE07'){
							if(parent.frames[1].frames[1].document.forms[0].first_contact_relation_desc){
								parent.frames[1].frames[1].document.forms[0].first_contact_relation_desc.value="<%=father_relation_desc%>";
								parent.frames[1].frames[1].document.forms[0].first_contact_relation.value="<%=father_yn%>";
							}
						}else{
						//	parent.frames[1].frames[1].document.forms[0].Photo_upload_yn.value="Y";
						}
						

						parent.parent.frames[2].frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}

					if(function_name=='CHANGEPAT'){
						//alert(function_name)
						if(parent.frames[1].frames[1].document.forms[0].other_alt_id)
							{
							parent.frames[1].frames[1].document.forms[0].other_alt_id.value="<%=alt_id_type_code%>";
							}
						if(parent.frames[1].frames[1].document.forms[0].notify_oth_alt_id_type)
							{
							parent.frames[1].frames[1].document.forms[0].notify_oth_alt_id_type.value="<%=father_doc_type_code%>";
							}		
						parent.frames[1].frames[1].document.forms[0].race_desc.value="<%=race_desc%>";
						parent.frames[1].frames[1].document.forms[0].race_code.value="<%=race_code%>";
						
						parent.frames[1].frames[1].document.forms[0].relgn_desc.value="<%=religion_desc%>";
						parent.frames[1].frames[1].document.forms[0].relgn_code.value="<%=religion_code%>";

						/*if(parent.frames[1].frames[1].document.forms[0].r_town_code){
							parent.frames[1].frames[1].document.forms[0].r_town_code.value="<%=city_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_town.value="<%=city_code%>";
						}*/

						if(parent.frames[1].frames[1].document.forms[0].r_area_code){
							parent.frames[1].frames[1].document.forms[0].r_area_code.value="<%=city_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_area.value="<%=city_code%>";
						}

						if(parent.frames[1].frames[1].document.forms[0].r_region_code){
							parent.frames[1].frames[1].document.forms[0].r_region_code.value="<%=state_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_region.value="<%=state_code%>";
						}

						if(parent.frames[1].frames[1].document.forms[0].r_postal_code1){
							parent.frames[1].frames[1].document.forms[0].r_postal_code1.value="<%=post_code_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_postal_code.value="<%=post_code%>";
						}
 
						parent.frames[1].frames[1].document.forms[0].r_country_desc.value="<%=nationality_desc%>";
						parent.frames[1].frames[1].document.forms[0].r_country_code.value="<%=nationality_code%>";
						
						if(parent.frames[1].frames[1].document.forms[0].place_of_birth_desc){
							parent.frames[1].frames[1].document.forms[0].place_of_birth_desc.value="<%=birth_place_desc%>";
							parent.frames[1].frames[1].document.forms[0].place_of_birth_code.value="<%=birth_place_code%>";
						}

						if(mother_yn=='RE01'){
							if(parent.frames[1].frames[1].document.forms[0].next_contact_relation_desc){
								parent.frames[1].frames[1].document.forms[0].next_contact_relation_desc.value="<%=mother_relation_desc%>";
								parent.frames[1].frames[1].document.forms[0].next_contact_relation.value="<%=mother_yn%>";
							}
							if(parent.frames[1].frames[1].document.forms[0].next_contact_relation){
								parent.frames[1].frames[1].document.forms[0].next_contact_relation.value="<%=mother_yn%>";
							}
						}
						
						if(father_yn=='RE07'){
							if(parent.frames[1].frames[1].document.forms[0].first_contact_relation_desc){
								parent.frames[1].frames[1].document.forms[0].first_contact_relation_desc.value="<%=father_relation_desc%>";
								parent.frames[1].frames[1].document.forms[0].first_contact_relation.value="<%=father_yn%>";
							}
						}
						if(father_yn=='RE07' ||  mother_yn=='RE01'){
							if(parent.frames[1].frames[1].document.forms[0].place_of_birth_desc){
								parent.frames[1].frames[1].document.forms[0].place_of_birth_desc.value="<%=birth_place_desc%>";
								parent.frames[1].frames[1].document.forms[0].place_of_birth_code.value="<%=birth_place_code%>";
							}
						}

						parent.parent.frames[2].frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}

					


					if(function_name=='BOOK_APPT'){
										
						parent.parent.frames[0].document.forms[0].race_desc.value="<%=race_desc%>";
						parent.parent.frames[0].document.forms[0].race_code.value="<%=race_code%>";			
						
	
					/*	parent.frames[0].document.forms[0].res_town_desc.value="<%=city_code%>";
						parent.frames[0].document.forms[0].res_town_code.value="<%=city_code%>";*/
				
						parent.parent.frames[0].document.forms[0].birth_place.value="<%=birth_place_desc%>";
	
						parent.parent.frames[0].document.forms[0].place_of_birth.value="<%=birth_place_code%>";
					//	parent.parent.frames[0].document.forms[0].place_of_birth.value="<%=birth_place_desc%>"; //Added newly
		
						
						parent.parent.frames[0].document.forms[0].res_area_desc.value="<%=city_desc%>";
						parent.parent.frames[0].document.forms[0].res_area_code.value="<%=city_code%>";
						

						parent.parent.frames[0].document.forms[0].region_desc.value="<%=state_desc%>";
						parent.parent.frames[0].document.forms[0].region_code.value="<%=state_code%>";

						parent.parent.frames[0].document.forms[0].postal_code.value="<%=post_code%>";
						parent.parent.frames[0].document.forms[0].r_postal_code_desc.value="<%=post_code%>";

						parent.parent.frames[0].document.forms[0].r_country_desc.value="<%=nationality_desc%>";
						parent.parent.frames[0].document.forms[0].r_country_code.value="<%=nationality_code%>";
						
						parent.parent.frames[4].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}

					if(function_name=='PAT_SEARCH'){
					/*	parent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group_desc.value="<%=race_desc%>";
						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group.value="<%=race_code%>";	
						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group_desc_hid.value="<%=race_desc%>";
						parent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group_hid.value="<%=race_code%>";	
*/
											
						
						parent.parent.parent.frames[6].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}
					

					if(function_name=='VSTREG'){
										
						if(parent.frames[1].frames[1].document.forms[0].r_area_code){
						//	parent.frames[1].frames[1].document.forms[0].r_town_code.value="<%=city_desc%>";
						//	parent.frames[1].frames[1].document.forms[0].r_town.value="<%=city_code%>";

							parent.frames[1].frames[1].document.forms[0].r_area_code.value="<%=city_code%>";
							parent.frames[1].frames[1].document.forms[0].r_area.value="<%=city_desc%>";
							
	 
							parent.frames[1].frames[1].document.forms[0].r_region_code.value="<%=state_desc%>";
							parent.frames[1].frames[1].document.forms[0].r_region.value="<%=state_code%>";
						}
							parent.frames[1].frames[1].document.forms[0].country1_code.value="<%=nationality_code%>";
							parent.frames[1].frames[1].document.forms[0].country1_desc.value="<%=nationality_desc%>";
							
							parent.frames[1].frames[1].document.forms[0].r_postal_code.value="<%=post_code%>";
							parent.frames[1].frames[1].document.forms[0].r_postal_desc.value="<%=post_code%>";
						parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}

					if(function_name=='REGREF'){

						if(from_OA=='N'){	
							if(parent.parent.frames[1].name=="f_query_add_mod"){
								parent.parent.frames[1].frames[0].document.forms[0].race_desc.value="<%=race_desc%>";
								parent.parent.frames[1].frames[0].document.forms[0].race_code.value="<%=race_code%>";			
								

								parent.parent.frames[1].frames[0].document.forms[0].birth_place.value="<%=birth_place_desc%>";
								parent.parent.frames[1].frames[0].document.forms[0].Birth_place_code.value="<%=birth_place_code%>";

							//	parent.parent.frames[1].frames[0].document.forms[0].res_town_desc.value="<%=city_desc%>";
							//	parent.parent.frames[1].frames[0].document.forms[0].res_town_code.value="<%=city_code%>";

								parent.parent.frames[1].frames[0].document.forms[0].res_area_desc.value="<%=city_desc%>";
								parent.parent.frames[1].frames[0].document.forms[0].res_area_code.value="<%=city_code%>";
								
								parent.parent.frames[1].frames[0].document.forms[0].region_desc.value="<%=state_desc%>";
								parent.parent.frames[1].frames[0].document.forms[0].region_code.value="<%=state_code%>";

								parent.parent.frames[1].frames[0].document.forms[0].postal_code.value="<%=post_code%>";
								parent.parent.frames[1].frames[0].document.forms[0].r_postal_code_desc.value="<%=post_code%>";
								
								parent.parent.frames[1].frames[0].document.forms[0].country1_code.value="<%=nationality_code%>";
								parent.parent.frames[1].frames[0].document.forms[0].country1_desc.value="<%=nationality_desc%>";

								parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";

								
							}else{

								parent.parent.frames[2].frames[1].frames[0].document.forms[0].race_desc.value="<%=race_desc%>";
								parent.parent.frames[2].frames[1].frames[0].document.forms[0].race_code.value="<%=race_code%>";			
								

								parent.parent.frames[2].frames[1].frames[0].document.forms[0].birth_place.value="<%=birth_place_desc%>";
								parent.parent.frames[2].frames[1].frames[0].document.forms[0].Birth_place_code.value="<%=birth_place_code%>";

							//	parent.parent.frames[2].frames[1].frames[0].document.forms[0].res_town_desc.value="<%=city_desc%>";
							//	parent.parent.frames[2].frames[1].frames[0].document.forms[0].res_town_code.value="<%=city_code%>";

								parent.parent.frames[2].frames[1].frames[0].document.forms[0].res_area_desc.value="<%=city_desc%>";
								parent.parent.frames[2].frames[1].frames[0].document.forms[0].res_area_code.value="<%=city_code%>";
								
								parent.parent.frames[2].frames[1].frames[0].document.forms[0].region_desc.value="<%=state_desc%>";
								parent.parent.frames[2].frames[1].frames[0].document.forms[0].region_code.value="<%=state_code%>";

								parent.parent.frames[2].frames[1].frames[0].document.forms[0].postal_code.value="<%=post_code%>";
								parent.parent.frames[2].frames[1].frames[0].document.forms[0].r_postal_code_desc.value="<%=post_code%>";
								
								parent.parent.frames[2].frames[1].frames[0].document.forms[0].country1_code.value="<%=nationality_code%>";
								parent.parent.frames[2].frames[1].frames[0].document.forms[0].country1_desc.value="<%=nationality_desc%>";


								parent.parent.frames[2].frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=";
							}

							
						}else{

							parent.frames[1].frames[0].document.forms[0].race_desc.value="<%=race_desc%>";
							parent.frames[1].frames[0].document.forms[0].race_code.value="<%=race_code%>";			
							

							parent.frames[1].frames[0].document.forms[0].birth_place.value="<%=birth_place_desc%>";
							parent.frames[1].frames[0].document.forms[0].Birth_place_code.value="<%=birth_place_code%>";

						//	parent.frames[1].frames[0].document.forms[0].res_town_desc.value="<%=city_desc%>";
						//	parent.frames[1].frames[0].document.forms[0].res_town_code.value="<%=city_code%>";

							parent.frames[1].frames[0].document.forms[0].res_area_desc.value="<%=city_desc%>";
							parent.frames[1].frames[0].document.forms[0].res_area_code.value="<%=city_code%>";
							
							parent.frames[1].frames[0].document.forms[0].region_desc.value="<%=state_desc%>";
							parent.frames[1].frames[0].document.forms[0].region_code.value="<%=state_code%>";

							parent.frames[1].frames[0].document.forms[0].postal_code.value="<%=post_code%>";
							parent.frames[1].frames[0].document.forms[0].r_postal_code_desc.value="<%=post_code%>";
							
							parent.frames[1].frames[0].document.forms[0].r_country_code.value="<%=nationality_code%>";
							parent.frames[1].frames[0].document.forms[0].r_country_desc.value="<%=nationality_desc%>";


							parent.frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=";
						}
					}
					if(function_name=='WTLST'){
											
						parent.frames[1].document.forms[0].race_desc.value="<%=race_desc%>";
						parent.frames[1].document.forms[0].race_code.value="<%=race_code%>";			
						

						parent.frames[1].document.forms[0].birth_place.value="<%=birth_place_desc%>";
						parent.frames[1].document.forms[0].Birth_place_code.value="<%=birth_place_code%>";

					//	parent.frames[1].document.forms[0].res_town_desc.value="<%=city_desc%>";
					//	parent.frames[1].document.forms[0].res_town_code.value="<%=city_code%>";

						parent.frames[1].document.forms[0].res_area_desc.value="<%=city_desc%>";
						parent.frames[1].document.forms[0].res_area_code.value="<%=city_code%>";
						
						parent.frames[1].document.forms[0].region_desc.value="<%=state_desc%>";
						parent.frames[1].document.forms[0].region_code.value="<%=state_code%>";

						parent.frames[1].document.forms[0].postal_code.value="<%=post_code%>";
						parent.frames[1].document.forms[0].r_postal_code_desc.value="<%=post_code%>";
						
						parent.frames[1].document.forms[0].r_country_code.value="<%=nationality_code%>";
						parent.frames[1].document.forms[0].r_country_desc.value="<%=nationality_desc%>";


						parent.frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}

					if(function_name=='WTMGMT'){
						if(parent.frames[1].document.forms[0].r_town_code){
							parent.frames[1].document.forms[0].r_town_code.value="<%=city_desc%>";
							parent.frames[1].document.forms[0].r_town.value="<%=city_code%>";
						}

						if(parent.frames[1].document.forms[0].r_area_code){
							parent.frames[1].document.forms[0].r_area_code.value="<%=city_desc%>";
							parent.frames[1].document.forms[0].r_area.value="<%=city_code%>";
						}

						if(parent.frames[1].document.forms[0].r_region_code){
							parent.frames[1].document.forms[0].r_region_code.value="<%=state_desc%>";
							parent.frames[1].document.forms[0].r_region.value="<%=state_code%>";
						}
						
						parent.frames[1].document.forms[0].postal_code.value="<%=post_code%>";
						parent.frames[1].document.forms[0].r_postal_code_desc.value="<%=post_code%>";
						
						parent.frames[1].document.forms[0].r_country_code.value="<%=nationality_code%>";
						parent.frames[1].document.forms[0].r_country_desc.value="<%=nationality_desc%>";

						parent.frames[5].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}


					if(function_name=='IPBOOKING'){
											
						parent.frames[1].document.forms[0].race_desc.value="<%=race_desc%>";
						parent.frames[1].document.forms[0].race_code.value="<%=race_code%>";			
						

						parent.frames[1].document.forms[0].birth_place.value="<%=birth_place_desc%>";
						parent.frames[1].document.forms[0].Birth_place_code.value="<%=birth_place_code%>";

				//		parent.frames[1].document.forms[0].res_town_desc.value="<%=city_desc%>";
				//		parent.frames[1].document.forms[0].res_town_code.value="<%=city_code%>";

						parent.frames[1].document.forms[0].res_area_desc.value="<%=city_desc%>";
						parent.frames[1].document.forms[0].res_area_code.value="<%=city_code%>";
						
						parent.frames[1].document.forms[0].region_desc.value="<%=state_desc%>";
						parent.frames[1].document.forms[0].region_code.value="<%=state_code%>";

						parent.frames[1].document.forms[0].postal_code.value="<%=post_code%>";
						parent.frames[1].document.forms[0].r_postal_code_desc.value="<%=post_code%>";
						parent.frames[1].document.forms[0].r_country_code.value="<%=nationality_code%>";
						parent.frames[1].document.forms[0].r_country_desc.value="<%=nationality_desc%>";


						parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}
				
				}
				try{
					if(parent.frames[1].frames[1].document.forms[0].txtSmartcard_succ){
						parent.frames[1].frames[1].document.forms[0].txtSmartcard_succ.value='Y';
					}
				}catch(exception){

				}
				</script>
			<%
			
		}catch(Exception e)	{ 
				System.out.println("Exception-->"+e.toString());
				e.printStackTrace();
		}finally{
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();
				 ConnectionManager.returnConnection(conn,request);
		}
		%>
		
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

