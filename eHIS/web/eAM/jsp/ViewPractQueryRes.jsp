<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String locale =((String)session.getAttribute("LOCALE"));
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
 <head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>      	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eAM/js/ViewPractQueryRes.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
			
		
        <link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
      	<script language='javascript'>
		var currentLink = new String();
      	currentLink = "identity_link";
      	
      	function objClick(id,objName)
      	{  
			
			selectTab(objName);
      		
			//changeLink(objName);
      		
			
			 if (id == '1')
      			moveToLink(1);
      		else if(id == '2')
      			moveToLink(2);
			else if(id == '3')
      			moveToLink(3); 

      	}


    

	function al() {	
		if (practitioner1_form.function_name.value == "modify") {
		}
	}


	</script>
      </head>

	 <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

     <%
	 request.setCharacterEncoding("UTF-8");	
	 //MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
      		Connection conn = null; 
		conn = ConnectionManager.getConnection(request);	

		String natIdyn="";
		String practtype="";
		String practtypedesc="";
		String practtype1="";
		String practtypedesc1="";
		String practitionerid="";
		String practitionername="";
		String shortname="";
		String effstatus="";
		String sex="";
		String sex1="";
		String emplstatus="";
		String emplstatus1="";
		String prefmode="";
		String prefmode1="";
		String birthdate="";
		String birthplace="";
		String maritalstatus="";
		String maritaldesc="";
		String maritalstatus1="";
		String maritaldesc1="";
		String aliasname="";
		String citizen="";
		String citizendesc="";
		String nationalidno="";
		String credentialid="";
		String credential_id1="";
		String credential_id2="";
		String credential_id3="";
		String jobtitle="";
		String degree="";
		String repfacility="";
		String repfacilityname="";
		String repfacility1="";
		String repfacilityname1="";
		String prspcode="";
		String prspdesc="";
		String allfacilities="";
		String restelnum="";
		String offtelnum="";
		String offtelext="";
		String pagernum="";
		String faxnum="";
		String mobilenum="";
		String emailid="";
		String resaddln1="";
		String resaddln2="";
		String resaddln3="";
		String resaddln4="";
		String offaddln1="";
		String offaddln2="";
		String offaddln3="";
		String offaddln4="";
		String mailaddln1="";
		String mailaddln2="";
		String mailaddln3="";
		String mailaddln4="";
		String respostalcode="";
		String offpostalcode="";
		String mailpostalcode="";
		String rescountrycode="";
		String rescountrydesc="";
		String offcountrycode="";
		String offcountrydesc="";
		String offcountrycode1="";
		String offcountrydesc1="";
		String mailcountrycode="";
		String mailcountrydesc="";
		String mailcountrycode1="";
		String mailcountrydesc1="";
		String sql11="";
		String bage="";
		String bmonths="";
		String bdays="";
		String cnc = "";
		String degree1 = "";
		String degree2 = "";
		String degree3 = "";
		String degree4 = "";
		String year1 = "";
		String year2 = "";
		String year3 = "";
		String year4 = "";
		String univ1 = "";
		String univ2= "";
		String univ3 = "";
		String univ4 = "";
		String con1 = "";
		String con2 = "";
		String con3 = "";
		String con4 = "";
		String det1 = "";
		String det2 = "";
		String det3 = "";
		String det4 = "";
		String birthdate_disply="";
		//Below line added for this CRF HSA-CRF-160
		String other_alt_type_no="",other_alt_type_desc="";
		
		//Below line added for this CRF ML-MMOH-CRF-0862
	    boolean isCernerpractitioner = false; 
		String cerner_practitioner_id="";
		String pract_wordwrap="";
		//End ML-MMOH-CRF-0862
		
		
	try{
      		
	 	practitionerid=request.getParameter("practitioner_id");
		if(practitionerid==null) practitionerid = "null";
   	 	
   	 	if(practitionerid!=null && practitionerid.equals("null")) {
   	 		practitionerid = "";
			practitionername="";
			shortname="";
   	 		birthdate="";
			birthplace="";
			Statement stmtty = null;
			Statement stmt = null;
			Statement stmt1= null;
			Statement stmt2= null;
			Statement stmt3=null;
   	 		Statement stmt4=null;
			Statement stmt5=null;
			Statement stmt6=null;
			Statement stmt7=null;
			Statement stmt8=null;
			Statement stmt9=null;
			Statement stmt10=null;
			Statement stmtpr=null;
			//Statement stmtf=null;
			Statement stmtc=null;
			ResultSet rst = null;
			ResultSet rs = null;
			ResultSet rs1 = null;
			ResultSet rs2 = null;
			ResultSet rs3 = null;
			ResultSet rs4= null;
			ResultSet rs5=null;
			ResultSet rs6=null;
			ResultSet rs7=null;
			ResultSet rs8=null;
			ResultSet rs9=null;
			ResultSet rs10=null;
			ResultSet rspr=null;
			//ResultSet rsf=null;
			ResultSet rsc=null;
			


		try {



			stmtc=conn.createStatement();
			String sqlc="select citizen_nationality_code from mp_param";
			rsc=stmtc.executeQuery(sqlc);
			if(rsc != null)
			{		
				while(rsc.next())
				{
					cnc=rsc.getString("citizen_nationality_code");
				}	
			}
			if(rsc !=null) rsc.close();
             if(stmtc != null) stmtc.close();

			
			
			stmt2=conn.createStatement();
			String sql2="select facility_id,facility_name from sm_facility_param_lang_vw where facility_type='F' and language_id='"+locale+"' order by facility_name ";
			rs2=stmt2.executeQuery(sql2);
			
			 while(rs2.next())
			 {
				repfacility=rs2.getString("facility_id");
				repfacilityname=rs2.getString("facility_name");
			 }
			
			 
			
			
			stmt6=conn.createStatement();
			String sql6="select country_code,long_desc from mp_country where eff_status = 'E' and language_id='"+locale+"' and(trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by long_desc";
			rs6=stmt6.executeQuery(sql6);
			 while(rs6.next())
		  	 {
		  		offcountrycode=rs6.getString("country_code");
		  		offcountrydesc=rs6.getString("long_desc");
		  	 } 

			stmt8=conn.createStatement();
		  	String sql8="select country_code,long_desc from mp_country_lang_vw where eff_status = 'E' and language_id='"+locale+"' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by long_desc";
		  	rs8=stmt8.executeQuery(sql8);

			 while (rs8.next())
		  	 {
		  		mailcountrycode=rs8.getString("country_code");
		  		mailcountrydesc=rs8.getString("long_desc");
		  	 }
		  	 
		  	stmt9=conn.createStatement();
		  	String sql9="select to_char(sysdate,'dd/mm/yyyy') from dual";
		  	rs9=stmt9.executeQuery(sql9);
		  	
		  	
		  	stmt10=conn.createStatement();
		  	String sql10="select accept_national_id_no_yn from mp_param";
		  	rs10=stmt10.executeQuery(sql10);
		  	
		  	if(rs10 != null)
		  	{		
		  		while(rs10.next())
		  		{
		  			natIdyn=rs10.getString(1);
		  		}	
		  	}	
		  
		  	stmtpr=conn.createStatement();
		  	String sqlpr="select speciality_code,short_desc from am_speciality_lang_vw where language_id='"+locale+"' and eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_desc ";
		  	rspr=stmtpr.executeQuery(sqlpr);
		  	 while (rspr.next())
		  	 {
		  		prspcode=rspr.getString("speciality_code");
		  		prspdesc=rspr.getString("short_desc");
		  	 }

		}catch(Exception e)
		{
			out.println("ERROR is -->"+e);
		}
		finally
		{
			if (stmtty != null) stmtty.close();
			if (rst != null) rst.close();
			if (rs != null) rs.close();
			if (rs1 != null) rs1.close();
			if (rs2 != null) rs2.close();
			if (rs3 != null) rs3.close();
			if (rs4 != null) rs4.close();
			if (rs5 != null) rs5.close();
			if (rs6 != null) rs6.close();
			if (rs7 != null) rs7.close();
			if (rs8 != null) rs8.close();
			if (rs9 != null) rs9.close();
			if (rs10 != null) rs10.close();
			if (rspr != null) rspr.close();

			if (stmt != null) stmt.close();
			if (stmt1 != null) stmt1.close();
			if (stmt2 != null) stmt2.close();
			if (stmt3 != null) stmt3.close();
			if (stmt4 != null) stmt4.close();
			if (stmt5 != null) stmt5.close();
			if (stmt6 != null) stmt6.close();
			if (stmt7 != null) stmt7.close();
			if (stmt8 != null) stmt8.close();
			if (stmt9 != null) stmt9.close();
			if (stmt10 != null) stmt10.close();
			if (stmtpr != null) stmtpr.close();

		}

	
		bage="0";
		//age="N";
		aliasname="";
		nationalidno="";
		credentialid="";
		credential_id1="";
		credential_id2="";
		credential_id3="";
		jobtitle="";
		degree="";
		allfacilities="N";
		restelnum="";
		offtelnum="";
		offtelext="";
		pagernum="";
		faxnum="";
		mobilenum="";
		emailid="";
		resaddln1="";
		resaddln2="";
		resaddln3="";
		resaddln4="";
		offaddln1="";
		offaddln2="";
		offaddln3="";
		offaddln4="";
		mailaddln1="";
		mailaddln2="";
		mailaddln3="";
		mailaddln4="";
			
		}
	else
	{
		
		Statement stmt10=null;
		Statement stmt11=null;
		Statement stmt12=null;
		Statement stmt13=null;
		Statement stmt14=null;
		Statement stmt15=null;
		Statement stmt16=null;
		Statement stmt17=null;
		Statement stmt18=null;
		Statement stmt19=null;
		Statement stmt20=null;
		Statement stmt21=null;
		Statement stmt22=null;
		Statement stmt23=null;
		Statement stmt24=null;
		Statement stmt25=null;
		Statement stmt26=null;
		Statement stmt27=null;
		Statement stmtp=null;
		Statement stmtm=null;
		Statement stmtc=null;
		Statement stmtr=null;
		Statement stmtrep=null;
		Statement stmtrec=null;
		Statement stmtofp=null;
		Statement stmtofc=null;
		Statement stmtmap=null;
		Statement stmtmac=null;
		Statement stmtpr=null;
		Statement stmtpr1=null;
		//Statement stmtf=null;

		ResultSet rset=null;
		ResultSet rs10=null;
		ResultSet rs12=null;
		ResultSet rs13=null;
		ResultSet rs14=null;
		ResultSet rs15=null;
		ResultSet rs16=null;
		ResultSet rs17=null;
		ResultSet rs18=null;
		ResultSet rs19=null;
		ResultSet rs20=null;
		ResultSet rs21=null;
		ResultSet rs22=null;
		ResultSet rs23=null;
		ResultSet rs24=null;
		ResultSet rs25=null;
		ResultSet rs26=null;
		ResultSet rs27=null;
		ResultSet rsp=null;
		ResultSet rsm=null;
		ResultSet rsc=null;
		ResultSet rsr=null;
		ResultSet rsrep=null;
		ResultSet rsrec=null;
		ResultSet rsofp=null;
		ResultSet rsofc=null;
		ResultSet rsmap=null;
		ResultSet rsmac=null;
		ResultSet rspr=null;
		ResultSet rspr1=null;
	


		try {

			stmt11 = conn.createStatement();
			//Below query modified for this CRF HSA-CRF-160
			sql11 ="select DEGREE_1, DEGREE_1_UNIV, DEGREE_1_YEAR, DEGREE_2, DEGREE_2_UNIV, DEGREE_2_YEAR, DEGREE_3, DEGREE_3_UNIV, DEGREE_3_YEAR, DEGREE_4, DEGREE_4_UNIV, DEGREE_4_YEAR,TRAINING_COND_BY_1, TRAINING_COND_BY_2, TRAINING_COND_BY_3, TRAINING_COND_BY_4, TRAINING_DTLS_1, TRAINING_DTLS_2, TRAINING_DTLS_3, TRAINING_DTLS_4, practitioner_id,practitioner_name,short_name,pract_type,gender,date_of_birth,place_of_birth,mar_status_code,alias_name,citizenship_code,national_id_num,credential_id,credential_id1,Credential_id2,credential_id3,(select POSITION_desc from am_position_lang_vw where a.position_code=position_code and language_id='"+locale+"')POSITION_DESC ,empl_status,employee_id,degree,primary_speciality_code,all_facilities_yn,reporting_facility_id,res_tel_num,pager_num,mobile_num,off_tel_num,off_tel_ext,fax_num,email_id,pref_contact_mode,res_add_ln1,res_add_ln2,res_add_ln3,res_add_ln4,res_add_postal_code,res_add_country_code,off_add_ln1,off_add_ln2,off_add_ln3,off_add_ln4,off_add_postal_code,off_add_country_code,mail_add_ln1,mail_add_ln2,mail_add_ln3,mail_add_ln4,mail_add_postal_code,mail_add_country_code,eff_date_from,eff_date_to,eff_status,mp_get_desc.MP_ALTERNATE_ID_TYPE(OTH_ALT_ID_TYPE,'"+locale+"',1) OTH_ALT_ID_TYPE,OTH_ALT_ID_NO, practitioner_long_id  from am_practitioner_lang_vw a where practitioner_id='"+practitionerid+"' and language_id='"+locale+"'";
			//Above line modified for this CRF ML-MMOH-CRF-0862

			rset=stmt11.executeQuery(sql11);
			if(rset !=null && rset.next())
			{
				practitionerid=rset.getString("practitioner_id");
				degree1=rset.getString("DEGREE_1");
				if(degree1==null) degree1 ="";
				degree2=rset.getString("DEGREE_2");
				if(degree2==null) degree2 ="";
				degree3=rset.getString("DEGREE_3");
				if(degree3==null) degree3 ="";
				degree4=rset.getString("DEGREE_4");
				if(degree4==null) degree4 ="";
				year1=rset.getString("DEGREE_1_YEAR");
				if(year1==null) year1 ="";
				year2=rset.getString("DEGREE_2_YEAR");
				if(year2==null) year2 ="";
				year3=rset.getString("DEGREE_3_YEAR");
				if(year3==null) year3 ="";
				year4=rset.getString("DEGREE_4_YEAR");
				if(year4==null) year4 ="";
				univ1=rset.getString("DEGREE_1_UNIV");
				if(univ1==null) univ1 ="";
				univ2=rset.getString("DEGREE_2_UNIV");
				if(univ2==null) univ2 ="";
				univ3=rset.getString("DEGREE_3_UNIV");
				if(univ3==null) univ3 ="";
				univ4=rset.getString("DEGREE_4_UNIV");
				if(univ4==null) univ4 ="";
				con1=rset.getString("TRAINING_COND_BY_1");
				if(con1==null) con1 ="";
				con2=rset.getString("TRAINING_COND_BY_2");
				if(con2==null) con2 ="";
				con3=rset.getString("TRAINING_COND_BY_3");
				if(con3==null) con3 ="";
				con4=rset.getString("TRAINING_COND_BY_4");
				if(con4==null) con4 ="";
				det1=rset.getString("TRAINING_DTLS_1");
				if(det1==null) det1 ="";
				det2=rset.getString("TRAINING_DTLS_2");
				if(det2==null) det2 ="";
				det3=rset.getString("TRAINING_DTLS_3");
				if(det3==null) det3 ="";
				det4=rset.getString("TRAINING_DTLS_4");
				if(det4==null) det4 ="";
				practitionername=rset.getString("practitioner_name");
				shortname=rset.getString("short_name");
				sex=rset.getString("gender");
				//employeeid=rset.getString("employee_id");
				allfacilities=rset.getString("all_facilities_yn");
				
				//Added for this CRF HSA-CRF-160
				other_alt_type_desc=rset.getString("OTH_ALT_ID_TYPE")==null?"":rset.getString("OTH_ALT_ID_TYPE");
				other_alt_type_no=rset.getString("OTH_ALT_ID_NO")==null?"":rset.getString("OTH_ALT_ID_NO");
				if(other_alt_type_desc.equals(""))other_alt_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OtherAlternateNo.label","mp_labels");
				
				//Added for this CRF ML-MMOH-CRF-0862
				cerner_practitioner_id=rset.getString("practitioner_long_id")==null?"":rset.getString("practitioner_long_id");
				
			if (sex.equals("M")) 
			{
				sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			}
			else if (sex.equals("F")) 
			{
				sex1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			}
			else if (sex.equals("U")) 
			{
				sex1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			}
				emplstatus=rset.getString("empl_status");
				

				if(emplstatus.equals("F")) 
				{
					emplstatus1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FullTime.label","common_labels");
				}
				else if (emplstatus.equals("P")) 
				{
					emplstatus1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PartTime.label","common_labels");
				}
				else if (emplstatus.equals("V")) 
				{
					emplstatus1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Visitor.label","common_labels");
				
				}
				else if(emplstatus.equals("S")) 
				{
					emplstatus1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Associate.label","common_labels");
				}
			
			prefmode=rset.getString("pref_contact_mode");

				if(prefmode != null) 
				{
				 if (prefmode.equals("R")) 
				 {	
					 prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels");
				}
				else if (prefmode.equals("O")) 
				{
					prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels");

				}
				else if(prefmode.equals("F")) 
				{
					prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels");
				}
				else if(prefmode.equals("M")) 
				{
					prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels");

				}
				else if(prefmode.equals("P")) 
				{
					prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels");
				}
				else if(prefmode.equals("E")) 
				{
					prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels");
				}
				else if(prefmode.equals(" ") || prefmode.equals("null")) 
				{
					prefmode1=" ";

				}
			     }
			 else
			     {
					prefmode=" ";
					prefmode1=" ";

			      }

			

			java.util.Date date2 = rset.getDate("date_of_birth");


			SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
			birthdate=formatter1.format(date2);

			birthdate_disply=DateUtils.convertDate(birthdate,"DMY","en",locale);

			formatter1 = null;
			stmt25=conn.createStatement();
			String sqldb="select calculate_age('"+birthdate+"',1) from dual";
			rs25=stmt25.executeQuery(sqldb);
			
			if(rs25 != null)
			{
				while(rs25.next())
				{
					bage=rs25.getString(1);
				}	
			}	
			if(bage==null) bage="0";
			stmt26=conn.createStatement();
			String sqldb1="select calculate_age('"+birthdate+"',2) from dual";
			rs26=stmt26.executeQuery(sqldb1);
			if(rs26 != null )
			{
				while(rs26.next())
				{
					bmonths=rs26.getString(1);
				}	
			}	
			if(bmonths==null) bmonths="0";
			stmt27=conn.createStatement();
			String sqldb2="select calculate_age('"+birthdate+"',3) from dual";
			rs27=stmt27.executeQuery(sqldb2);
			if(rs27 != null )
			{
				while(rs27.next())	
				{
					bdays=rs27.getString(1);
				}	
			}	
			if(bdays==null) bdays="0";
			birthplace=rset.getString("place_of_birth");
			if(birthplace == null) birthplace=" ";

			aliasname=rset.getString("alias_name");

			if(aliasname == null) aliasname=" ";

			nationalidno=rset.getString("national_id_num");


			if(nationalidno == null || nationalidno.equals("") || nationalidno.equals(" ")) nationalidno="";

			credentialid=rset.getString("credential_id");
			credential_id1=rset.getString("credential_id1");
			credential_id2=rset.getString("credential_id2");
			credential_id3=rset.getString("credential_id3");
			if(credentialid==null) credentialid="";
			if(credential_id1==null) credential_id1="";
			if(credential_id2==null) credential_id2="";
			if(credential_id3==null) credential_id3="";

			jobtitle=rset.getString("POSITION_DESC");
			if(jobtitle==null) jobtitle="";
			else
			if(jobtitle.equals("CC")) jobtitle="Chief Consultant";
			else if(jobtitle.equals("SC")) jobtitle="Sr. Consultant";
			else if(jobtitle.equals("CO")) jobtitle="Consultant";
			else if(jobtitle.equals("SS")) jobtitle="Sr. Specialist";
			else if(jobtitle.equals("SP")) jobtitle="Specialist";
			else if(jobtitle.equals("SR")) jobtitle="Sr. Resident";
			else if(jobtitle.equals("RS")) jobtitle="Resident";
			else if(jobtitle.equals("RG")) jobtitle="Registrar";
			else if(jobtitle.equals("IN")) jobtitle="Intern";
			else if(jobtitle.equals("TR")) jobtitle="Trainee";
			
			
			degree=rset.getString("degree");
			if(degree == null) degree="";
			
			restelnum=rset.getString("res_tel_num");
			if(restelnum==null) restelnum="";
			
			pagernum=rset.getString("pager_num");
			if(pagernum==null) pagernum="";
			
			mobilenum=rset.getString("mobile_num");
			if(mobilenum==null) mobilenum="&nbsp;";
			
			offtelnum=rset.getString("off_tel_num");
			if(offtelnum==null) offtelnum="&nbsp;";
			
			offtelext=rset.getString("off_tel_ext");
			if(offtelext==null) offtelext="&nbsp;";
			
			faxnum=rset.getString("fax_num");
			if(faxnum==null) faxnum="&nbsp;";
			
			emailid=rset.getString("email_id");
			if(emailid==null) emailid="&nbsp;";
 
 /* below lines moidified by Venkatesh.S agasint 57984 on 07-01-2015 */
			resaddln1=checkForNull(rset.getString("res_add_ln1"));
		 	

			resaddln2=checkForNull(rset.getString("res_add_ln2"));
			

			resaddln3=checkForNull(rset.getString("res_add_ln3"));
		

			resaddln4=checkForNull(rset.getString("res_add_ln4"));

			offaddln1=checkForNull(rset.getString("off_add_ln1"));
		

			offaddln2=checkForNull(rset.getString("off_add_ln2"));
			

			offaddln3=checkForNull(rset.getString("off_add_ln3"));
			
			
			offaddln4=checkForNull(rset.getString("off_add_ln4"));
			

			mailaddln1=checkForNull(rset.getString("mail_add_ln1"));
			
			
			mailaddln2=checkForNull(rset.getString("mail_add_ln2"));
			

			mailaddln3=checkForNull(rset.getString("mail_add_ln3"));
		
			
			mailaddln4=checkForNull(rset.getString("mail_add_ln4"));
			
            /*End 57984 */
			

			effstatus=rset.getString("eff_status");
			


		

			respostalcode=rset.getString("res_add_postal_code");
			if(respostalcode==null || respostalcode.equals("null"))respostalcode="&nbsp;";


			rescountrycode=rset.getString("res_add_country_code");
			if(rescountrycode != null)

			{
				stmtrec=conn.createStatement();
				String sqlrec="select long_desc from mp_country_lang_vw where country_code='"+rescountrycode+"' and language_id='"+locale+"'";
				rsrec=stmtrec.executeQuery(sqlrec);
				if(rsrec != null )
				{
					while(rsrec.next())
					{
						rescountrydesc=rsrec.getString("long_desc");
					}	
				}	
			}
			else
			{
				rescountrydesc=" ";
			}

		
			if(rescountrycode == null) 
			{
			}
			else if(rescountrycode != null) 
			{
				if(effstatus.equals("E")) 
				{
				}
				else if(effstatus.equals("D")) 
				{
				}
			}

			offpostalcode=rset.getString("off_add_postal_code");
			if(offpostalcode==null || offpostalcode.equals("null")) offpostalcode="&nbsp;";

			offcountrycode=rset.getString("off_add_country_code");
			if(offcountrycode != null)
			{
					stmtofc=conn.createStatement();
					String sqlofc="select long_desc from mp_country_lang_vw where country_code='"+offcountrycode+"' and language_id='"+locale+"'";
					rsofc=stmtofc.executeQuery(sqlofc);
					if(rsofc != null)
					{
						while(rsofc.next())
						{
							offcountrydesc=rsofc.getString("long_desc");
						}	
					}	
			}
			else
			{
					offcountrydesc= " ";
			}


			stmt19=conn.createStatement();
			String sql19="select country_code,long_desc from mp_country_lang_vw where language_id='"+locale+"' and  eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by long_desc";
			rs19=stmt19.executeQuery(sql19);
			if(rs19 != null )
			{
			 while(rs19.next())
			 {
				offcountrycode1=rs19.getString("country_code");
				offcountrydesc1=rs19.getString("long_desc");
				if((offcountrycode1.equals(offcountrycode)) && (offcountrydesc1.equals(offcountrydesc)) && (offcountrycode != null) && (!offcountrydesc.equals(" ")))
				{
				}
				else if((!offcountrycode1.equals(offcountrycode)) && (!offcountrydesc1.equals(offcountrydesc)) && (offcountrycode != null) && (!offcountrydesc.equals(" ")))
				{
				}
				else if((offcountrycode == null) && (offcountrydesc.equals(" ")))
				{
				}

			 }
			}
			if(offcountrycode == null)
			{
			}
			else if(offcountrycode != null)
			{
			if(effstatus.equals("E"))
			{
			}
			else if(effstatus.equals("D"))
			{
			}
			}

			mailpostalcode=rset.getString("mail_add_postal_code");
			if(mailpostalcode == null) mailpostalcode="";

			mailcountrycode=rset.getString("mail_add_country_code");
			if(mailcountrycode != null)
			{
			stmtmac=conn.createStatement();
			String sqlmac="select long_desc from mp_country_lang_vw where country_code='"+mailcountrycode+"' and language_id='"+locale+"'";
			rsmac=stmtmac.executeQuery(sqlmac);
			
			  if(rsmac != null)
			  {
			   while(rsmac.next())
			  	{
			 		mailcountrydesc =rsmac.getString("long_desc");
			 	}	
			  }	
			}
			else
			{
				mailcountrydesc=" ";
			}
			stmt21=conn.createStatement();
			String sql21="select country_code,long_desc from mp_country_lang_vw where eff_status = 'E' and language_id='"+locale+"' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')))order by long_desc";
			rs21=stmt21.executeQuery(sql21);

			if(rs21 != null )
			{
			 while(rs21.next())
			 {
					mailcountrycode1=rs21.getString("country_code");
					mailcountrydesc1=rs21.getString("long_desc");
					if((mailcountrycode1.equals(mailcountrycode)) && (mailcountrydesc1.equals(mailcountrydesc)) && (mailcountrycode != null) && (!mailcountrydesc.equals(" ")))
					{
					}
					else if((!mailcountrycode1.equals(mailcountrycode)) && (!mailcountrydesc1.equals(offcountrydesc)) && (offcountrycode != null) && (!offcountrydesc.equals(" ")))
					{
					}
					else if((mailcountrycode == null) && (mailcountrydesc.equals(" ")))
					{
					}

			 }
			} 
			
			if(mailcountrycode == null)
			{
			}
			else if(mailcountrycode != null)
			{
			if(effstatus.equals("E"))
			{
			}
			else if(effstatus.equals("D"))
			{
			}
}

repfacility=rset.getString("reporting_facility_id");

			if(repfacility != null)
			{
				stmtr = conn.createStatement();
				String sqlr="select facility_name from sm_facility_param_lang_vw where facility_id='"+repfacility+"' and language_id='"+locale+"'";
				rsr=stmtr.executeQuery(sqlr);
				if(rsr != null )
				{
					while(rsr.next())
					{
						repfacilityname=rsr.getString("facility_name");
					}	
				}	
			}
			else
				{
					repfacilityname=" ";
				}

				stmt15=conn.createStatement();

				String sql15="select facility_id,facility_name from sm_facility_param_lang_vw where facility_type='F' and language_id='"+locale+"' order by facility_name";

				rs15=stmt15.executeQuery(sql15);
				if(rs15 != null)
				{
				 while (rs15.next())
				 {
					repfacility1=rs15.getString("facility_id");
					repfacilityname1=rs15.getString("facility_name");
					if((repfacility1.equals(repfacility)) && (repfacilityname1.equals(repfacilityname)) && (repfacility != null) && (!repfacilityname.equals(" ")))
					{
					}
					else if((!repfacility1.equals(repfacility)) && (!repfacilityname1.equals(repfacilityname)) && (repfacility != null) && (!repfacilityname.equals(" ")))
					{
					}
					else if((repfacility == null) && (repfacilityname.equals(" ")))
					{
					}
				 }
				}
				if(repfacility == null)
				{
				}
				else if(repfacility != null)
				{
				if(effstatus.equals("E"))
				{
				}
				else if(effstatus.equals("D"))
				{
				}
 			}


			practtype=rset.getString("pract_type");
			stmtp=conn.createStatement();
			String sqlp="select desc_sysdef from am_pract_type_lang_vw where pract_type='"+practtype+"' and language_id='"+locale+"' ";
			rsp=stmtp.executeQuery(sqlp);
			
			if(rsp != null )
			{
				while(rsp.next())
				{
					practtypedesc=rsp.getString("desc_sysdef");
				}	
			}	

			stmt12=conn.createStatement();
			String sql12 = "select pract_type,desc_sysdef from am_pract_type_lang_vw where eff_status='E' and language_id='"+locale+"'and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')))";
			rs12=stmt12.executeQuery(sql12);
			if(rs12 != null)
			{
			while (rs12.next())
			{
				practtype1=rs12.getString("pract_type");
				practtypedesc1=rs12.getString("desc_sysdef");
				if((practtype1.equals(practtype)) && (practtypedesc1.equals(practtypedesc)))
				{
					if(effstatus.equals("E"))
								{
								}
				}
				else if((!practtype1.equals(practtype)) && (!practtypedesc1.equals(practtypedesc)))
				{
					if(effstatus.equals("E"))
					{

					}
				}

			 }
		        }

 			if(effstatus.equals("D"))
 			{
 			}

 				maritalstatus=rset.getString("mar_status_code");

 			if(maritalstatus != null)
 			{

 				stmtm=conn.createStatement();
 				String sqlm="select short_desc from mp_marital_status_lang_vw where mar_status_code='"+maritalstatus+"' and language_id='"+locale+"'";
 				rsm=stmtm.executeQuery(sqlm);
 				
 				if(rsm != null)
 				{
 					while(rsm.next())
 					{
 						maritaldesc=rsm.getString("short_desc");
 					}	
 				}	
 			}
 			else
 			{
 				maritaldesc=" ";
 			}

 			stmt13=conn.createStatement();
 			String sql13="select mar_status_code,short_desc from mp_marital_status_lang_vw where eff_status = 'E' and language_id='"+locale+"' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_desc";
 			rs13=stmt13.executeQuery(sql13);
 			if(rs13 != null)
 			{
 			 while (rs13.next())
 			 {
 				maritalstatus1=rs13.getString("mar_status_code");
 				maritaldesc1=rs13.getString("short_desc");
 				if((maritalstatus1.equals(maritalstatus)) && (maritaldesc1.equals(maritaldesc)) && (maritalstatus != null) && (!maritaldesc.equals(" ")))
 				{
 				}
 				else if((!maritalstatus1.equals(maritalstatus)) && (!maritaldesc1.equals(maritaldesc)) && (maritalstatus != null) && (!maritaldesc.equals(" ")))
 				{
 				}
 				else if ((maritalstatus == null) && (maritaldesc.equals(" ")))
 				{
 				}
 			 }
 		        } 	

 			if(maritalstatus == null)
 			{
 			}
 			else if(maritalstatus != null)
 			{
 			if(effstatus.equals("E"))
 			{
 			}
 			if(effstatus.equals("D"))
 			{
 			}
 			}
	
			citizen=rset.getString("citizenship_code");if (citizen == null) citizen="";

			if(citizen != null)
 			{
 				stmtc=conn.createStatement();

 				String sqlc="select long_desc from mp_country_lang_vw where country_code='"+citizen+"' and language_id='"+locale+"'";
 				rsc=stmtc.executeQuery(sqlc);
 				if(rsc != null)
 				{
 					while(rsc.next())
 					{
 						citizendesc = rsc.getString("long_desc");if(citizendesc==null)citizendesc="";

 					}	
 				}	
				if(rsc !=null) rsc.close();
 			}
 			else
 			{
 				citizendesc="";
 			}
 		
		
 			if(citizen==null)
 			{
 			}
 			else if(citizen != null)
 			{

 			if(effstatus.equals("E"))
 			{
 			}
 			else if(effstatus.equals("D"))
 			{
 			}

 			}

 			prspcode=rset.getString("primary_speciality_code");
 			
 		 	
		}

 			stmtpr1=conn.createStatement();
			String sqlpr1="select speciality_code,short_desc from am_speciality_lang_vw where speciality_code='"+prspcode+"' and language_id='"+locale+"'";
			rspr1=stmtpr1.executeQuery(sqlpr1);
			if(rspr1 != null)
			{
			 while(rspr1.next())
			 {
 				prspdesc = rspr1.getString("short_desc");
			 }
			} 

		 //Below line added for this CRF ML-MMOH-CRF-0862	    
		  isCernerpractitioner=CommonBean.isSiteSpecific(conn, "AM","CERNER_PRACTITIONER_ID");
		  if(isCernerpractitioner) { 
		  pract_wordwrap="style=word-wrap: break-word;width:200px";
		  //pract_wordwrap="style=word-break: break-all";
		  }
		  
		  //End ML-MOH-CRF-0862
		  
           
		}catch(Exception e) {
					out.println("Query Error"+e);
					e.printStackTrace();
				    }
			finally     {
								if(stmt10 != null) stmt10.close();
								if(stmt11 != null) stmt11.close();
								if(stmt12 != null) stmt12.close();
								if(stmt13 != null) stmt13.close();
								if(stmt14 != null) stmt14.close();
								if(stmt15 != null) stmt15.close();
								if(stmt16 != null) stmt16.close();
								if(stmt17 != null) stmt17.close();
								if(stmt18 != null) stmt18.close();
								if(stmt19 != null) stmt19.close();
								if(stmt20 != null) stmt20.close();
								if(stmt21 != null) stmt21.close();
								if(stmt22 != null) stmt22.close();
								if(stmt23 != null) stmt23.close();
								if(stmt24 != null) stmt24.close();
								if(stmt25 != null) stmt25.close();
								if(stmt26 != null) stmt26.close();
								if(stmt27 != null) stmt27.close();
								if(stmtp != null) stmtp.close();
								if(stmtm != null) stmtm.close();
								if(stmtc != null) stmtc.close();
								if(stmtr != null) stmtr.close();
								if(stmtrep != null) stmtrep.close();
								if(stmtrec != null) stmtrec.close();
								if(stmtofp != null) stmtofp.close();
								if(stmtofc != null) stmtofc.close();
								if(stmtmap != null) stmtmap.close();
					 			if(stmtmac != null) stmtmac.close();
					 			if(stmtpr != null) stmtpr.close();
					 			if(stmtpr1 != null) stmtpr1.close();

								if(rset != null) rset.close();
								if(rs10 != null) rs10.close();
								if(rs12 != null) rs12.close();
								if(rs13 != null) rs13.close();
								if(rs14 != null) rs14.close();
								if(rs15 != null) rs15.close();
								if(rs16 != null) rs16.close();
								if(rs17 != null) rs17.close();
								if(rs18 != null) rs18.close();
								if(rs19 != null) rs19.close();
								if(rs20 != null) rs20.close();
								if(rs21 != null) rs21.close();
								if(rs22 != null) rs22.close();
								if(rs23 != null) rs23.close();
								if(rs24 != null) rs24.close();
								if(rs25 != null) rs25.close();
								if(rs26 != null) rs26.close();
								if(rs27 != null) rs27.close();

								if(rsp != null) rsp.close();
								if(rsm != null) rsm.close();
								if(rsc != null) rsc.close();
								if(rsr != null) rsr.close();
								if(rsrep != null) rsrep.close();
								if(rsrec != null) rsrec.close();
								if(rsofp != null) rsofp.close();
								if(rsofc != null) rsofc.close();
								if(rsmap != null) rsmap.close();
					 			if(rsmac != null) rsmac.close();
					 			if(rspr != null) rspr.close();
					 			if(rspr1 != null) rspr1.close();


			}


			
		}		
		%>

<form name='practitioner_form' id='practitioner_form' >
	<a name='identitylink' id='identitylink'></a>
<table border='0' cellpadding='0' cellspacing='0' width=100%>
<tr>
	<td nowrap  align='left' nowrap  class='label' width='20vh'><fmt:message key="Common.type.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=practtypedesc%></td>
	<td nowrap>&nbsp;</td>
	<td nowrap>&nbsp;</td>
</tr>
	<tr><td colspan='4'>&nbsp;</td></tr>
 <!--Below line modified for this CRF ML-MMOH-CRF-0862-->
<tr>
	<td nowrap  align='left'  class='label' width='20%'><%if(isCernerpractitioner){%><fmt:message key="Common.EmId.label" bundle="${common_labels}"/><%}else{%><fmt:message key="Common.identification.label" bundle="${common_labels}"/><%}%>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=practitionerid%></td>
	<td nowrap align='right'  class='label' width='20%'>&nbsp;</td>
	<td align='left' class='queryData' <%=pract_wordwrap%> >&nbsp;</td>
</tr>
 <!--End this CRF ML-MMOH-CRF-0862-->

	<tr><td colspan='4'>&nbsp;</td></tr>
	<!--Below line modified for this CRF ML-MMOH-CRF-0862-->
<tr>
	<td nowrap  align='left'  class='label' width='20%' ><fmt:message key="Common.FullName.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td align='left' class='queryData' <%=pract_wordwrap%> ><%=practitionername%></td>
	<td nowrap  align='left' class='label'><fmt:message key="Common.shortname.label" bundle="${common_labels}"/>&nbsp;</td>
	<td align='left' colspan='1' class='queryData' <%=pract_wordwrap%> ><%=shortname%>&nbsp;</td>
</tr>
   <!--End this CRF ML-MMOH-CRF-0862-->
		<tr><td colspan='4'>&nbsp;</td></tr>
<tr>
	<td nowrap  align='left'  class='label' width='20%' ><fmt:message key="Common.primaryspeciality.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData' ><%=prspdesc%></td>
	<td nowrap  align='left' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>&nbsp;</td>
	<td nowrap  align='left'>
	<% if(effstatus.equals("E")) { %>
	<img src='../../eCommon/images/enabled.gif'></img>
	<% } else { %>
	<img src='../../eCommon/images/RRnwd.gif'></img>
	<% } %>
	</td>
</tr>

<tr>
        <td nowrap  colspan='4'>&nbsp;</td>

</tr>
</table>

<!-- <table name='insert_tab' id='insert_tab' cellspacing='0' cellpadding='0' border='0' width='26%'> -->

				




<ul id="tablist" class="tablist" style="padding-left:0px">
      <li class="tablistitem" title="Identity">
         <a onclick="objClick('1','identity_link_a')" class="tabClicked" id="identity_link_a" >
         <span class="tabSpanclicked" id="identity_link_aspan"><fmt:message  key="Common.Identity.label" bundle="${common_labels}"/></span>
       </a>
       </li>
	  <li class="tablistitem" title="Contact details">
	        <a onclick="objClick('2','contactno_link_a')" class="tabA" id="contactno_link_a" >
	         <span class="tabAspan" id="contactno_link_aspan"><fmt:message key="Common.ContactNoAddr.label" bundle="${common_labels}"/></span>
			 </a>
	   </li>
		 <li class="tablistitem" title="Qualification and Training">
	        <a onclick="objClick('3','deg_link_a')" class="tabA" id="deg_link_a" >
	         <span class="tabAspan" id="deg_link_aspan"><fmt:message key="Common.QualificationDetails.label" bundle="${common_labels}"/></span>
			 </a>
	   </li> 		
		 </ul>



<table name='insert_tab' id='insert_tab' cellspacing='0' cellpadding='0' border='0' width='100%'> 
<th colspan='4'>&nbsp;</th>
<tr>
	<td nowrap  align='left'  class='label' width='20%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  class='queryData' align='left'>
	<% if(sex1.toUpperCase().equals("MALE"))
	 {%>
	<fmt:message key="Common.male.label" bundle="${common_labels}"/>
	<%}else if(sex1.toUpperCase().equals("FEMALE"))
	{%>
	<fmt:message key="Common.female.label" bundle="${common_labels}"/>
	<%}else if(sex1.toUpperCase().equals("UNKNOWN"))
	 {%>
	<fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
	  <%}%>
	&nbsp;&nbsp;&nbsp;<fmt:message key="Common.age.label" bundle="${common_labels}"/>&nbsp;&nbsp;<%=bage%>&nbsp;Y&nbsp;<%=bmonths%>&nbsp;M&nbsp;<%=bdays%>&nbsp;D&nbsp;
	</td>
	<td nowrap  align='left' class='label' ><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left'  class='queryData'><%=birthdate_disply%></td>
</tr>

<tr><td colspan='4'>&nbsp</td></tr>

<tr>
	<td nowrap  align='left' class='label' width='20%'><fmt:message key="Common.birthPlace.label" bundle="${common_labels}"/>&nbsp;&nbsp;	</td>
	<td nowrap  align='left' class='queryData'><%=birthplace%></td>
	<td nowrap  align='left' class='label'><fmt:message key="eMP.maritalstatus.label" bundle="${mp_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'>
	<%if(effstatus.equals("E")) {%>
		<%=maritaldesc%>
	<%}
	else if(effstatus.equals("D")) {%>
		<%=maritaldesc%>
	<%}%>
	</td>
</tr>
<tr><td nowrap  colspan='4'>&nbsp</td></tr>
<tr><th colspan='4'>&nbsp</th></tr>


<tr>
	<td nowrap  align='left' class='label' width='20%'><fmt:message key="eMP.AliasName.label" bundle="${mp_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=aliasname%></td>
	<td nowrap  align ='left'  class='label' ><fmt:message key="Common.Citizenship.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'>
	<%if(effstatus.equals("E")) {%>
		<%=citizendesc%>&nbsp;
	<%}
	else if(effstatus.equals("D")) {%>
		<%=citizendesc%>&nbsp;
	<%}%>
	</td>
</tr>

<tr><td nowrap  colspan='4'>&nbsp</td></tr>

<%if(natIdyn.equals("Y")) { /*Added below line for this CRF HAS-CRF-160*/%>
<tr>
    <td nowrap  align='left'  class='label'><%=other_alt_type_desc%></td>
	<td nowrap  align='left' class='queryData'><%=other_alt_type_no%>&nbsp;</td>
	<td nowrap  align='right'  class='label' width='20%'><fmt:message key="Common.nationality.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.identification.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=nationalidno%></td>

	
</tr>
<tr><td nowrap  colspan='4'>&nbsp;</td></tr>
<tr>
<td nowrap  align='left'  class='label'><fmt:message key="Common.Credential.label" bundle="${common_labels}"/> 1&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=credential_id1%></td>
	<td nowrap  align='left'  class='label'><fmt:message key="Common.Credential.label" bundle="${common_labels}"/> 2&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=credential_id2%></td>
</tr>
<tr><td nowrap  colspan='4'>&nbsp;</td></tr>
<tr>
	
	<td nowrap  align='left'  class='label'><fmt:message key="Common.Credential.label" bundle="${common_labels}"/> 3&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=credential_id3%></td>
	<td colspan="2">&nbsp;</td>
</tr>
<% } else { //Added below line for this CRF HAS-CRF-160%>
<tr>
   	<td nowrap  align='left'  class='label'><%=other_alt_type_desc%></td>
	<td nowrap  align='left' class='queryData'><%=other_alt_type_no%>&nbsp;</td>    
	<td nowrap  align='left'  class='label'><fmt:message key="Common.Credential.label" bundle="${common_labels}"/> 1&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=credential_id1%></td>
</tr>
<tr><td nowrap  colspan='4'>&nbsp;</td></tr>
<tr> 
   <td nowrap  align='left'  class='label'><fmt:message key="Common.Credential.label" bundle="${common_labels}"/> 2&nbsp;&nbsp;</td>
   <td nowrap  align='left' class='queryData'><%=credential_id2%></td>
	<td nowrap  align='left'  class='label'><fmt:message key="Common.Credential.label" bundle="${common_labels}"/> 3&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=credential_id3%></td>
	
</tr>
<% }%>
<tr><td nowrap  colspan='4'>&nbsp</td></tr>
<tr>
	<td nowrap  align='left'  class='label' width='20%'><fmt:message key="Common.Position.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=jobtitle%></td>
	<td nowrap  align='left'  class='label'><fmt:message key="Common.Degree.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=degree%></td>
</tr>

<tr><td nowrap  colspan='4'>&nbsp</td></tr>
<tr>
	<td nowrap  align='left'  class='label' width='20%'><fmt:message key="Common.EmplStatus.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class= 'queryData'>
		<%if(effstatus.equals("E")) {%>
			<%=emplstatus1%>
		<%}
		else if(effstatus.equals("D")) {%>
			<%=emplstatus1%>
		<%}%>		
	</td>
	<td nowrap  align='left' class='label'><fmt:message key="Common.RepFacility.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'>
		<%=repfacilityname%>
	</td>
</tr>

<tr><td nowrap  colspan='4'>&nbsp;</td></tr>
<tr>
	<td nowrap  align='left'  class='label' width='20%'><fmt:message key="Common.AllFacilities.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left'>
	<%if(allfacilities.equals("Y")) {%>
	<img src='../../eCommon/images/enabled.gif'></img>
	<% } else { %>
		<img src='../../eCommon/images/RRnwd.gif'></img>
	<%}%>
	</td>
	<td nowrap  colspan='2'>&nbsp;</td>
</tr>

</table>
	
	<br><br><br><br><br><br><BR><BR><BR>
<a name='contactnolink' id='contactnolink'></a>

<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
<tr>
	<td nowrap  align='left' nowrap  class='label' width='20%'><fmt:message key="Common.type.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=practtypedesc%></td>
	<td nowrap >&nbsp;</td>
	<td nowrap >&nbsp;</td>
</tr>
	<tr><td colspan='4'>&nbsp;</td></tr>
	<!--<tr>
	<td nowrap  align='right'  class='label' width='20%'><fmt:message key="Common.identification.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'></td>
	<td nowrap >&nbsp;</td>
	<td nowrap >&nbsp;</td>
</tr>-->
 <!--Below line modified for this CRF ML-MMOH-CRF-0862-->
<tr>
	<td nowrap  align='left'  class='label' width='20%'><%if(isCernerpractitioner){%><fmt:message key="Common.EmId.label" bundle="${common_labels}"/><%}else{%><fmt:message key="Common.identification.label" bundle="${common_labels}"/><%}%>&nbsp;&nbsp;</td>
	<td align='left' class='queryData' <%=pract_wordwrap%>><%=practitionerid%></td>
	<td nowrap align='right'  class='label' width='20%'>&nbsp;</td>
	<td align='left' class='queryData' <%=pract_wordwrap%> >&nbsp;</td>
</tr>
 <!--End this CRF ML-MMOH-CRF-0862-->

<tr><td colspan='4'>&nbsp;</td></tr>
<!--Below line added for this CRF ML-MMOH-CRF-0862-->
<tr>
	<td nowrap  align='left'  class='label' width='20%' ><fmt:message key="Common.FullName.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td align='left' class='queryData' <%=pract_wordwrap%> ><%=practitionername%></td>
	<td nowrap  align='left' class='label' width='20%' ><fmt:message key="Common.shortname.label" bundle="${common_labels}"/>&nbsp;</td>
	<td align='left' colspan='1' class='queryData' <%=pract_wordwrap%>><%=shortname%> &nbsp;&nbsp;</td>
</tr>
<!--End this CRF ML-MMOH-CRF-0862-->
	
<tr><td colspan='4'>&nbsp;</td></tr>
<tr>
	<td nowrap  align='left'  class='label' width='20%'><fmt:message key="Common.primaryspeciality.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData' ><%=prspdesc%></td>
	<td nowrap  align='left' class='label' width='20%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>&nbsp;</td>
	<td nowrap  align='left'>
	<% if(effstatus.equals("E")) { %>
	<img src='../../eCommon/images/enabled.gif'></img>
	<% } else { %>
	<img src='../../eCommon/images/RRnwd.gif'></img>
	<% } %>
	</td>
</tr>

<tr>
        <td nowrap  colspan='4'>&nbsp;</td>

</tr>
</table>
<ul id="tablist" class="tablist"  style="padding-left:0px">
 <li class="tablistitem" title="Identity">
  <a onclick="objClick('1','identity_link_b')" class="tabA" id="identity_link_b" >
   <span class="tabAspan" id="identity_link_bspan"><fmt:message  key="Common.Identity.label" bundle="${common_labels}"/></span>
   </a>
     </li>
	  <li class="tablistitem" title="Contact details">
	        <a onclick="objClick('2','contactno_link_b')" class="tabClicked" id="contactno_link_b" >
	         <span class="tabSpanclicked" id="contactno_link_bspan"><fmt:message key="Common.ContactNoAddr.label" bundle="${common_labels}"/></span>
			 </a>
	   </li>
		 <li class="tablistitem" title="Qualification and Training">
	        <a onclick="objClick('3','deg_link_b')" class="tabA" id="deg_link_b" >
	         <span class="tabAspan" id="deg_link_bspan"><fmt:message key="Common.QualificationDetails.label" bundle="${common_labels}"/></span>
			 </a>
	   </li> 		
		 </ul>



<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
	<td nowrap  align='left'  class='label' width='20%'><fmt:message key="Common.ResTelNo.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=restelnum%></td>
	<td nowrap  align='left'  class='label' width='20%'><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left'  class='queryData' >
		<%=offtelnum%>
	</td>
	<td nowrap  align='left'  class='label' width='20%'><fmt:message key="Common.Ext.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left'  class='queryData'><%=offtelext%>
	</td>
</tr>

<tr><td nowrap  colspan='6'>&nbsp;</td></tr>
<tr>
	<td nowrap  align='left'  class='label' width='20%'><fmt:message key="Common.fax.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.no.label" bundle="${common_labels}"/></td>
	<td nowrap  align='left' class='queryData'>
		<%=faxnum%>
	</td>
	<td nowrap  align='left' class='label' width='20%'><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/>&nbsp;</td>
	<td nowrap  align='left' class='queryData'>
			<%=mobilenum%>
	</td>
	<td nowrap  align='left' class='label' width='20%'><fmt:message key="Common.PagerNo.label" bundle="${common_labels}"/>&nbsp;</td>
	<td nowrap  align='left' class='queryData'>
		<%=pagernum%>
	</td>
</tr>

<tr><td nowrap  colspan='6'>&nbsp;</td></tr>
<tr>
	<td nowrap  align='left' class='label' width='20%'><fmt:message key="Common.PrefMode.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' colspan='5' class='queryData'>
	<%if (effstatus.equals("E")) {%>
		<%=prefmode1%>
	<%}
	else if(effstatus.equals("D")) {%>
		<%=prefmode1%>
	<%}%>

	</td>
</tr>
<tr><td nowrap  colspan='6'>&nbsp;</td></tr>
<tr>
	<td nowrap  align='left' class='label' width='20%'><fmt:message key="Common.email.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' colspan='5' class='queryData' ><%=emailid%></td>
	</tr>
		<tr><td colspan='6'>&nbsp;</td></tr>
</table>
	<br>
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
	<td nowrap  align='right' width='20%' class='label'>&nbsp;</td>
	<td nowrap  align='left'  class='queryData'><fmt:message key="Common.residence.label" bundle="${common_labels}"/></td>
	<td nowrap  align='left'  class='queryData'><fmt:message key="Common.office.label" bundle="${common_labels}"/></td>
	<td nowrap  align='left'  class='queryData'><fmt:message key="Common.mail.label" bundle="${common_labels}"/></td>
</tr>
	<tr><td colspan='4'>&nbsp;</td></tr>
	<tr>
	<td nowrap  align='left' width='20%' class='label'><fmt:message key="Common.Address.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left'  class='queryData' >	<%=resaddln1%></td>
	<td nowrap  align='left'  class='queryData'><%=offaddln1%></td>
	<td nowrap  align='left'  class='queryData'><%=mailaddln1%></td>
</tr>

<tr>
	<td nowrap  align='right' width='20%'> </td>
	<td nowrap  align='left'  class='queryData' ><%=resaddln2%></td>
	<td nowrap  align='left'  class='queryData'><%=offaddln2%></td>
	<td nowrap  align='left'  class='queryData'><%=mailaddln2%></td>
</tr>
<tr>
	<td nowrap  align='right' width='20%'> </td>
	<td nowrap  align='left'  class='queryData' ><%=resaddln3%> </td>
	<td nowrap  align='left'  class='queryData'><%=offaddln3%> </td>
	<td nowrap  align='left'  class='queryData'><%=mailaddln3%></td>
</tr>
<tr>
	<td nowrap  align='right' width='20%'> </td>
	<td nowrap  align='left'  class='queryData'><%=resaddln4%></td>
	<td nowrap  align='left'  class='queryData'><%=offaddln4%></td>
	<td nowrap  align='left'  class='queryData' ><%=mailaddln4%></td>
</tr>
	<tr><td colspan='4'>&nbsp;</td></tr>
<tr>
	<td nowrap  align='left' width='20%' class='label'><fmt:message key="eMP.postalcode.label" bundle="${mp_labels}"/>&nbsp;</td>
	<td nowrap  align='left'  class='queryData'><%=respostalcode%></td>
	<td nowrap  align='left'  class='queryData'><%=offpostalcode%></td>
	<td nowrap  align='left' class='queryData'><%=mailpostalcode%></td>
</tr>
	
	<tr><td colspan='4'>&nbsp;</td></tr>
<tr>
	<td nowrap  align='left' width='20%' class='label'><fmt:message key="Common.country.label" bundle="${common_labels}"/>&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=rescountrydesc%></td>
	<td nowrap  align='left'  class='queryData'><%=offcountrydesc%></td>
	<td nowrap  align='left' class='queryData'><%=mailcountrydesc%></td>
</tr>
</table>
		<br><br><br><br><br><br><BR><BR><BR>
		<a name='deglink' id='deglink'></a>

<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
<tr>
	<td nowrap  align='left' nowrap  class='label' width='20%'><fmt:message key="Common.type.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=practtypedesc%></td>
	<td nowrap >&nbsp;</td>
	<td nowrap >&nbsp;</td>
</tr>
	<tr><td colspan='4'>&nbsp;</td></tr>
<!--
<tr>
	<td nowrap  align='right'  class='label' width='20%'><fmt:message key="Common.identification.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'></td>
	<td nowrap >&nbsp;</td>
	<td nowrap >&nbsp;</td>
</tr>
-->
 <!--Below line modified for this CRF ML-MMOH-CRF-0862-->
<tr>
	<td nowrap  align='left'  class='label' width='20%'><%if(isCernerpractitioner){%><fmt:message key="Common.EmId.label" bundle="${common_labels}"/><%}else{%><fmt:message key="Common.identification.label" bundle="${common_labels}"/><%}%>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=practitionerid%></td>
	<td nowrap align='right'  class='label' width='20%'>&nbsp;</td>
	<td align='left' class='queryData' <%=pract_wordwrap%> >&nbsp;</td>
</tr>
 <!--End this CRF ML-MMOH-CRF-0862-->

<tr><td colspan='4'>&nbsp;</td></tr>
<!--Below line added for this CRF ML-MMOH-CRF-0862-->
<tr>
	<td nowrap  align='left'  class='label' width='20%' ><fmt:message key="Common.FullName.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td align='left' class='queryData' <%=pract_wordwrap%>><%=practitionername%></td>
	<td nowrap  align='left' class='label' width='20%' ><fmt:message key="Common.shortname.label" bundle="${common_labels}"/>&nbsp;</td>
	<td align='left' colspan='1' class='queryData' <%=pract_wordwrap%>><%=shortname%>&nbsp;&nbsp;</td>
</tr>
<!--End this CRF ML-MMOH-CRF-0862-->
	
<tr><td colspan='4'>&nbsp;</td></tr>
<tr>
	<td nowrap  align='left'  class='label' width='20%'><fmt:message key="Common.primaryspeciality.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData' ><%=prspdesc%></td>
	<td nowrap  align='left' class='label' width='20%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>&nbsp;</td>
	<td nowrap  align='left'>
	<% if(effstatus.equals("E")) { %>
	<img src='../../eCommon/images/enabled.gif'></img>
	<% } else { %>
	<img src='../../eCommon/images/RRnwd.gif'></img>
	<% } %>
	</td>
</tr>

<tr>
        <td nowrap  colspan='4'>&nbsp;</td>

</tr>
</table>
<ul id="tablist" class="tablist"  style="padding-left:0px">
 <li class="tablistitem" title="Identity">
  <a onclick="objClick('1','identity_link_c')" class="tabA" id="identity_link_c" >
   <span class="tabAspan" id="identity_link_cspan"><fmt:message  key="Common.Identity.label" bundle="${common_labels}"/></span>
   </a>
     </li>
	  <li class="tablistitem" title="Contact details">
	        <a onclick="objClick('2','contactno_link_c')" class="tabA" id="contactno_link_c" >
	         <span class="tabAspan" id="contactno_link_cspan"><fmt:message key="Common.ContactNoAddr.label" bundle="${common_labels}"/></span>
			 </a>
	   </li>
		 <li class="tablistitem" title="Qualification and Training">
	        <a onclick="objClick('3','deg_link_c')" class="tabClicked" id="deg_link_c" >
	         <span class="tabSpanclicked" id="deg_link_cspan"><fmt:message key="Common.QualificationDetails.label" bundle="${common_labels}"/></span>
			 </a>
	   </li> 		
		 </ul>



<table border='0' cellpadding='0' cellspacing='0' width='100%'>
	<tr><th colspan="5" align="left"><fmt:message key="Common.QualificationDetails.label" bundle="${common_labels}"/></th></tr>
<!-- <tr><td colspan="5">&nbsp;</td></tr> -->
 <tr><td class='blankwhiterow' colspan='6'>&nbsp;</td></tr>
<tr><th><fmt:message key="Common.Degree.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.Yearofpassing.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.University.label" bundle="${common_labels}"/></th></tr>
<tr>
	<td nowrap    class='label' width='20%' align="center" ><%=degree1%>&nbsp;&nbsp;</td>
	<td nowrap   class='queryData'align="center"><%=year1%></td>
	<td nowrap   class='label' width='20%' align="center"><%=univ1%>&nbsp;&nbsp;</td>
</tr>
		<tr><td colspan="3">&nbsp;</td></tr>
<tr>
	<td nowrap    class='label' width='20%'align="center"><%=degree2%>&nbsp;&nbsp;</td>
	<td nowrap   class='queryData'align="center"><%=year2%></td>
	<td nowrap    class='label' width='20%'align="center"><%=univ2%>&nbsp;&nbsp;</td>
</tr><tr><td colspan="3">&nbsp;</td></tr>
<tr>
	<td nowrap   class='label' width='20%'align="center"><%=degree3%>&nbsp;&nbsp;</td>
	<td nowrap  class='queryData' align="center"><%=year3%></td>
	<td nowrap   class='label' width='20%'align="center"><%=univ3%>&nbsp;&nbsp;</td>
</tr><tr><td colspan="3">&nbsp;</td></tr>
<tr>
	<td nowrap    class='label' width='20%'align="center"><%=degree4%>&nbsp;&nbsp;</td>
	<td nowrap   class='queryData'align="center"><%=year4%></td>
	<td nowrap   class='label' width='20%'align="center"><%=univ4%>&nbsp;&nbsp;</td>
</tr><tr><td colspan="3">&nbsp;</td></tr>
<tr><th colspan="5" align="left"><fmt:message key="Common.TrainingDetails.label" bundle="${common_labels}"/></th></tr>
	 <tr><td class='blankwhiterow' colspan='6'>&nbsp;</td></tr>
<tr><th><fmt:message key="Common.DetailsofTraining.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.ConductedBy.label" bundle="${common_labels}"/></th><th>&nbsp;</th></tr>
<tr>
	<td nowrap   class='label' width='20%'align="center"><%=det1%>&nbsp;&nbsp;</td>
	<td nowrap  class='queryData'align="center"><%=con1%></td>
	<td nowrap    class='label' width='20%'>&nbsp;&nbsp;</td>
</tr><tr><td colspan="3">&nbsp;</td></tr>
<tr>
	<td nowrap   class='label' width='20%'align="center"><%=det2%>&nbsp;&nbsp;</td>
	<td nowrap  class='queryData'align="center"><%=con2%></td>
	<td nowrap    class='label' width='20%'>&nbsp;&nbsp;</td>
</tr><tr><td colspan="3">&nbsp;</td></tr>
<tr>
	<td nowrap    class='label' width='20%'align="center"><%=det3%>&nbsp;&nbsp;</td>
	<td nowrap   class='queryData'align="center"><%=con3%></td>
	<td nowrap  class='label' width='20%'>&nbsp;&nbsp;</td>
</tr><tr><td colspan="3">&nbsp;</td></tr>
<tr>
	<td nowrap    class='label' width='20%'align="center"><%=det4%>&nbsp;&nbsp;</td>
	<td nowrap  class='queryData' align="center"><%=con4%></td>
	<td nowrap   class='label' width='20%'>&nbsp;&nbsp;</td>
</tr>
<tr>

	<td nowrap   class='label' width='20%'>&nbsp;&nbsp;</td>
	<td nowrap   class='label' width='20%'>&nbsp;&nbsp;</td>
	<td nowrap   class='label' width='20%'>&nbsp;&nbsp;</td>
</tr>
<tr>

	<td nowrap   class='label' width='20%'>&nbsp;&nbsp;</td>
	<td nowrap   class='label' width='20%'>&nbsp;&nbsp;</td>
	<td nowrap   class='label' width='20%'>&nbsp;&nbsp;</td>
</tr>
</table>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>

      <% 	}catch(Exception e){}
  	       	
		finally{
			ConnectionManager.returnConnection(conn,request);
		}%>

</form>
</body>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString; 
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>
</html>

