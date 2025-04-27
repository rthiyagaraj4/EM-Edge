<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"
 import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

 <head>
      	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
      	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eAM/js/ViewOtherStaffQueryRes.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
			
		

      	<script language='javascript'>
		var currentLink = new String();
      	currentLink = "identity_link";

	function tab_click2(id){
			selectTab(id);
			objClick(id);
	}
		      	
   	function objClick(objName)
      	{
      		
			changeLink(objName);
      		if (objName == 'identity_link')
      			moveToLink(1);
      		else if(objName == 'contactno_link')
      			moveToLink(2);

      	}


      	function changeLink(LinkName) {
			if (currentLink=='identity_link')
				document.getElementById('identity_link').src='../../eAM/images/Identity_click.gif';
	      	else if (currentLink=='contactno_link')
		  		document.getElementById('contactno_link').src = '../../eAM/images/Contact_Addr_click.gif';

			if(LinkName=='identity_link')
				document.getElementById('identity_link').src='../../eAM/images/Identity.gif';
			else if(LinkName=='contactno_link')
				document.getElementById('contactno_link').src='../../eAM/images/Contact_Addr.gif';
			currentLink = LinkName;

		}




</script>
      </head>

	 <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

     <%
	 String locale =((String)session.getAttribute("LOCALE")); //Added for this CRF HSA-CRF-160
	 request.setCharacterEncoding("UTF-8");
      		Connection conn = null; 
		conn = ConnectionManager.getConnection(request);	

		String natIdyn="";
		String strt="";
		String practtype="";
		String practtypedesc="";
		
		String practitionerid="";
		String practitionername="";
		String shortname="";
		String effstatus="";
   		String str2="";
		
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
		String aliasname="";
		String citizen="";
		String citizendesc="";
		String citizen1="";
		String citizendesc1="";
		String nationalidno="";
		String credentialid="";
		String jobtitle="";
		String degree="";
		String repfacility="";
		String repfacilityname="";
		String repfacility1="";
		String repfacilityname1="";

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
		String fcall="";		
		String cnc = "";
		
		//Added for this CRF HSA-CRF-160
		String other_alt_type_desc="";
        String other_alt_type_no="";

		//Added by Ashwini for IN:073030
        String all_facilities_yn = "";
		
	try{
      		
		ArrayList postal_code = new ArrayList(); 
   	 	fcall = request.getParameter("fcall"); 
		if (fcall == null) fcall="";
			 	
     	 %>
   	     	     	  
   	<%
   	 	practitionerid=request.getParameter("other_staff_id");
		if(practitionerid==null) practitionerid = "null";
   	 	
   	 	if(practitionerid!=null && practitionerid.equals("null")) {
   	 		practitionerid = "";
			practitionername="";
			shortname="";
   	 	

			birthdate="";
			birthplace="";
			
			
   	 		PreparedStatement pstmtty = null;
			PreparedStatement pstmt = null;
			PreparedStatement pstmt1= null;
			PreparedStatement pstmt2= null;
   	 		PreparedStatement pstmt4=null;
			PreparedStatement pstmt6=null;
			PreparedStatement pstmt8=null;
			PreparedStatement pstmt10=null;
			PreparedStatement pstmtf=null;
			PreparedStatement pstmtc=null;

			ResultSet rst = null;
			ResultSet rs = null;
			ResultSet rs1 = null;
			ResultSet rs2 = null;
			ResultSet rs4= null;
			ResultSet rs6=null;
			ResultSet rs8=null;
			ResultSet rs10=null;
			ResultSet rsf=null;
			ResultSet rsc=null;
			

		try{
			String sqlf="select count(*) as total from sm_facility_param";
			pstmtf=conn.prepareStatement(sqlf);
			rsf=pstmtf.executeQuery();
			
		    }catch(Exception e) {
		     out.println("errors="+e);
		     }
		     finally {
		      if(pstmtf != null) pstmtf.close();
		      if(rsf != null) rsf.close();
		      }




		try {

		  	String sqlt = "select other_staff_type,short_desc  from am_other_staff_type where eff_status = 'E' order by short_desc";
		  	pstmtty=conn.prepareStatement(sqlt);
		  	rst=pstmtty.executeQuery();
		  	strt="<select name='pract_type' id='pract_type'><option value=''> -----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"------";
		  	 while(rst.next()) 
		  	 {
		  		practtype=rst.getString("other_staff_type");
		  		practtypedesc=rst.getString("short_desc");
		  		strt=strt+"<option value='"+ practtype+"' onClick='checkpract()' >"+practtypedesc;

		  	 }
		  	 
		  	strt=strt+"</select>";


			String sql="select mar_status_code,short_desc from mp_marital_status where eff_status = 'E' order by short_desc ";
		  	pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			str2="<select name='marital_status' id='marital_status'><option value=''>---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----";
			 while(rs.next())
			 {
				maritalstatus=rs.getString("mar_status_code");
				maritaldesc=rs.getString("short_desc");
				str2=str2+"<option value='"+maritalstatus+"'>"+maritaldesc+"</option>";
			 }
			
			str2=str2+"</select>";



			String sqlc="select citizen_nationality_code from mp_param";
			pstmtc=conn.prepareStatement(sqlc);
			rsc=pstmtc.executeQuery();
			if(rsc != null)
			{		
				while(rsc.next())
				{
					cnc=rsc.getString("citizen_nationality_code");
				}	
			}


			String sql1="select country_code,long_desc from mp_country where eff_status = 'E' and short_desc is not null order by long_desc ";
			pstmt1=conn.prepareStatement(sql1);
			rs1=pstmt1.executeQuery();
			 while(rs1.next())
			 {
				citizen=rs1.getString("country_code");
				citizendesc=rs1.getString("long_desc");
				if(citizen==null) citizen = "";
				if(citizendesc==null) citizendesc = "";
				if(cnc==null) cnc = "";

			 }
			
			
			String sql2="select facility_id,facility_name from sm_facility_param where facility_type='F' order by facility_name ";
			pstmt2=conn.prepareStatement(sql2);
			rs2=pstmt2.executeQuery();
			
			 while(rs2.next())
			 {
				repfacility=rs2.getString("facility_id");
				repfacilityname=rs2.getString("facility_name");
			 }
			 
			String sql4="select country_code,short_name from mp_country where eff_status = 'E' and  order by short_name";
			pstmt4=conn.prepareStatement(sql4);
			rs4=pstmt4.executeQuery();
			while(rs4.next())
			{
				rescountrycode=rs4.getString("country_code");
				rescountrydesc=rs4.getString("short_name");
			}
			 
			
			
			String sql6="select country_code,short_name from mp_country where eff_status = 'E' and order by short_name";
			pstmt6=conn.prepareStatement(sql6);
			rs6=pstmt6.executeQuery();
			 while(rs6.next())
		  	 {
		  		offcountrycode=rs6.getString("country_code");
		  		offcountrydesc=rs6.getString("short_name");
		  	 } 

		  	String sql8="select country_code,short_name from mp_country where eff_status = 'E' and order by short_name";
			pstmt8=conn.prepareStatement(sql8);
		  	rs8=pstmt8.executeQuery();

			 while (rs8.next())
		  	 {
		  		mailcountrycode=rs8.getString("country_code");
		  		mailcountrydesc=rs8.getString("short_name");
		  	 }
		  	 
		  	  	
		  
		try{
		  	String sql10="select accept_national_id_no_yn from mp_param";
		  	pstmt10=conn.prepareStatement(sql10);
		  	rs10=pstmt10.executeQuery();
		  	
		  	if(rs10 != null)
		  	{		
		  		while(rs10.next())
		  		{
		  			natIdyn=rs10.getString(1);
		  		}	
		  	}	
		  }catch(Exception e ){out.println("National ID "+ e);}	

		}catch(Exception e)
		{
			out.println("ERROR is -->"+e);
		}
		finally
		{
			if (pstmtty != null) pstmtty.close();
			if (rst != null) rst.close();
			if (rs != null) rs.close();
			if (rs1 != null) rs1.close();
			if (rs2 != null) rs2.close();
			if (rs4 != null) rs4.close();
			if (rs6 != null) rs6.close();
			if (rs8 != null) rs8.close();
			if (rs10 != null) rs10.close();
			if (rsc != null) rsc.close();

			if (pstmt != null) pstmt.close();
			if (pstmt1 != null) pstmt1.close();
			if (pstmt2 != null) pstmt2.close();
			if (pstmt4 != null) pstmt4.close();
			if (pstmt6 != null) pstmt6.close();
			if (pstmt8 != null) pstmt8.close();
			if (pstmt10 != null) pstmt10.close();
			if (pstmtc != null) pstmtc.close();


		}

		
		
		effstatus="E";
		bage="0";
				
		}
	else
	{
		//Object pcode[] = postal_code.toArray();
		PreparedStatement pstmt11=null;
		PreparedStatement pstmt14=null;
		PreparedStatement pstmt15=null;
		PreparedStatement pstmt17=null;
		PreparedStatement pstmt19=null;
		PreparedStatement pstmt21=null;
		PreparedStatement pstmt25=null;
		PreparedStatement pstmt26=null;
		PreparedStatement pstmt27=null;
		PreparedStatement pstmtp=null;
		PreparedStatement pstmtm=null;
		PreparedStatement pstmtc=null;
		PreparedStatement pstmtr=null;
		PreparedStatement pstmtrec=null;
		PreparedStatement pstmtofc=null;
		PreparedStatement pstmtmac=null;
		PreparedStatement pstmtf=null;

		ResultSet rset=null;
		ResultSet rs14=null;
		ResultSet rs15=null;
		ResultSet rs19=null;
		ResultSet rs21=null;
		ResultSet rs25=null;
		ResultSet rs26=null;
		ResultSet rs27=null;
		ResultSet rsp=null;
		ResultSet rsm=null;
		ResultSet rsc=null;
		ResultSet rsr=null;
		ResultSet rsrec=null;
		ResultSet rsofc=null;
		ResultSet rsmac=null;
		ResultSet rsf=null;
		

		try{
						
					
					String sqlf="select count(*) as total from sm_facility_param";
					pstmtf=conn.prepareStatement(sqlf);
					rsf=pstmtf.executeQuery();
					

				    }catch(Exception e) {
				     out.println("errors="+e);
				     }
				     finally {
				      if(pstmtf != null) pstmtf.close();
				      if(rsf != null) rsf.close();
		      }


		try {
            //Modified  for this CRF HSA-CRF-160
			sql11 ="select other_staff_id,other_staff_name,short_name,other_staff_type,gender,date_of_birth,place_of_birth,mar_status_code,alias_name,citizenship_code,national_id_num,position_desc,empl_status,employee_id,degree,all_facilities_yn,reporting_facility_id,res_tel_num,pager_num,mobile_num,off_tel_num,off_tel_ext,fax_num,email_id,pref_contact_mode,res_add_ln1,res_add_ln2,res_add_ln3,res_add_ln4,res_add_postal_code,res_add_country_code,off_add_ln1,off_add_ln2,off_add_ln3,off_add_ln4,off_add_postal_code,off_add_country_code,mail_add_ln1,mail_add_ln2,mail_add_ln3,mail_add_ln4,mail_add_postal_code,mail_add_country_code,eff_date_from,eff_date_to,am_other_staff.eff_status eff_status1,mp_get_desc.MP_ALTERNATE_ID_TYPE(OTH_ALT_ID_TYPE,'"+locale+"',1) OTH_ALT_ID_TYPE,OTH_ALT_ID_NO from am_other_staff, am_position where other_staff_id=? and am_other_staff.position_code = am_position.position_code(+)";
           			
			pstmt11 = conn.prepareStatement(sql11);
			pstmt11.setString(1,practitionerid);
			rset=pstmt11.executeQuery();
			rset.next();
			practitionerid=rset.getString("other_staff_id");
			practitionername=rset.getString("other_staff_name");
			shortname=rset.getString("short_name");
			sex=rset.getString("gender");
			
			all_facilities_yn = rset.getString("all_facilities_yn");//Added by Ashwini for IN:073030

			//Added for this CRF HSA-CRF-160
			other_alt_type_desc=rset.getString("OTH_ALT_ID_TYPE")==null?"":rset.getString("OTH_ALT_ID_TYPE");
			other_alt_type_no=rset.getString("OTH_ALT_ID_NO")==null?"":rset.getString("OTH_ALT_ID_NO");
			if(other_alt_type_desc.equals(""))other_alt_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OtherAlternateNo.label","mp_labels");
			
				
			if (sex.equals("M")) 
			{
				sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			}
			else if (sex.equals("F")) 
			{
				sex1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			}
			else if (sex.equals("U")) 
			{
				sex1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
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
					prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mobile.label","common_labels");

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
			formatter1 = null;
			String sqldb="select calculate_age(?,1) from dual";
			pstmt25=conn.prepareStatement(sqldb);
			pstmt25.setString(1,birthdate);
			rs25=pstmt25.executeQuery();
			
			if(rs25 != null)
			{
				while(rs25.next())
				{
					bage=rs25.getString(1);
				}	
			}	
			if(bage==null) bage="0";
			String sqldb1="select calculate_age(?,2) from dual";
			pstmt26=conn.prepareStatement(sqldb1);
			pstmt26.setString(1,birthdate);
			rs26=pstmt26.executeQuery();
			if(rs26 != null )
			{
				while(rs26.next())
				{
					bmonths=rs26.getString(1);
				}	
			}	
			if(bmonths==null) bmonths="0";
			String sqldb2="select calculate_age(?,3) from dual";
			pstmt27=conn.prepareStatement(sqldb2);
			pstmt27.setString(1,birthdate);
			rs27=pstmt27.executeQuery();
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

			credentialid="";
			if(credentialid==null) credentialid="";

			jobtitle=rset.getString("position_desc");
			if(jobtitle==null) jobtitle="";
			
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
			
			effstatus=rset.getString("eff_status1");

			respostalcode=rset.getString("res_add_postal_code");
			if(respostalcode==null || respostalcode.equals("null"))respostalcode="&nbsp;";


			rescountrycode=rset.getString("res_add_country_code");
			if(rescountrycode != null)

			{
				String sqlrec="select short_name from mp_country where country_code=?";
				pstmtrec=conn.prepareStatement(sqlrec);
				pstmtrec.setString(1,rescountrycode);
				rsrec=pstmtrec.executeQuery();
				if(rsrec != null )
				{
					while(rsrec.next())
					{
						rescountrydesc=rsrec.getString("short_name");
					}	
				}	
			}
			else
			{
				rescountrydesc=" ";
			}

			
		
			offpostalcode=rset.getString("off_add_postal_code");
			if(offpostalcode==null || offpostalcode.equals("null")) offpostalcode="&nbsp;";

			offcountrycode=rset.getString("off_add_country_code");
			if(offcountrycode != null)
			{
					String sqlofc="select short_name from mp_country where country_code=? ";
					pstmtofc=conn.prepareStatement(sqlofc);
					pstmtofc.setString(1,offcountrycode);
					rsofc=pstmtofc.executeQuery();
					if(rsofc != null)
					{
						while(rsofc.next())
						{
							offcountrydesc=rsofc.getString("short_name");
						}	
					}	
			}
			else
			{
					offcountrydesc= " ";
			}


			String sql19="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
			pstmt19=conn.prepareStatement(sql19);
			rs19=pstmt19.executeQuery();
			if(rs19 != null )
			{
			 while(rs19.next())
			 {
				offcountrycode1=rs19.getString("country_code");
				offcountrydesc1=rs19.getString("short_name");
				if((offcountrycode1.equals(offcountrycode)) && (offcountrydesc1.equals(offcountrydesc)) && (offcountrycode != null) && (!offcountrydesc.equals(" ")))
				{
				}
				else if((!offcountrycode1.equals(offcountrycode)) && (!offcountrydesc1.equals(offcountrydesc)) && (offcountrycode != null) && (!offcountrydesc.equals(" ")))
				{
				}
				
			 }
			}
		
			

			mailpostalcode=rset.getString("mail_add_postal_code");
			if(mailpostalcode == null) mailpostalcode="";

			mailcountrycode=rset.getString("mail_add_country_code");
			if(mailcountrycode != null)
			{
			String sqlmac="select short_name from mp_country where country_code=? ";
			pstmtmac=conn.prepareStatement(sqlmac);
			pstmtmac.setString(1,mailcountrycode);
			rsmac=pstmtmac.executeQuery();
			
			  if(rsmac != null)
			  {
			   while(rsmac.next())
			  	{
			 		mailcountrydesc =rsmac.getString("short_name");
			 	}	
			  }	
			}
			else
			{
				mailcountrydesc=" ";
			}
			String sql21="select country_code,short_name from mp_country where eff_status = 'E'  order by short_name";
			pstmt21=conn.prepareStatement(sql21);
			rs21=pstmt21.executeQuery();

			if(rs21 != null )
			{
			 while(rs21.next())
			 {
					mailcountrycode1=rs21.getString("country_code");
					mailcountrydesc1=rs21.getString("short_name");
					if((mailcountrycode1.equals(mailcountrycode)) && (mailcountrydesc1.equals(mailcountrydesc)) && (mailcountrycode != null) && (!mailcountrydesc.equals(" ")))
					{
					}
					else if((!mailcountrycode1.equals(mailcountrycode)) && (!mailcountrydesc1.equals(offcountrydesc)) && (offcountrycode != null) && (!offcountrydesc.equals(" ")))
					{
					}
					

			 }
			} 
			
			
		

repfacility=rset.getString("reporting_facility_id");

			if(repfacility != null)
			{
				String sqlr="select facility_name from sm_facility_param where facility_id=? ";
				pstmtr = conn.prepareStatement(sqlr);
				pstmtr.setString(1,repfacility);
				rsr=pstmtr.executeQuery();
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


				String sql15="select facility_id,facility_name from sm_facility_param where facility_type='F' order by facility_name";
				pstmt15=conn.prepareStatement(sql15);

				rs15=pstmt15.executeQuery();
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
					
				 }
				}
				

			practtype=rset.getString("other_staff_type");
			String sqlp="select short_desc from am_other_staff_type where other_staff_type=? ";
			pstmtp=conn.prepareStatement(sqlp);
			pstmtp.setString(1,practtype);
			rsp=pstmtp.executeQuery();
			
			if(rsp != null )
			{
				while(rsp.next())
				{
					practtypedesc=rsp.getString("short_desc");
				}	
			}	

			maritalstatus=rset.getString("mar_status_code");

 			if(maritalstatus != null)
 			{

 				String sqlm="select short_desc from mp_marital_status where mar_status_code=?";
 				pstmtm=conn.prepareStatement(sqlm);
				pstmtm.setString(1,maritalstatus);
 				rsm=pstmtm.executeQuery();
 				
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

 			
			citizen=rset.getString("citizenship_code");if (citizen == null) citizen="";
			if(citizen != null)
 			{
 				String sqlc="select long_desc from mp_country where country_code=? ";
  				pstmtc=conn.prepareStatement(sqlc);
				pstmtc.setString(1,citizen);
				rsc=pstmtc.executeQuery();
 				if(rsc != null )
 				{
 					while(rsc.next())
 					{
 						citizendesc = rsc.getString("long_desc");if(citizendesc==null)citizendesc="";
 					}	
 				}	
 			}
 			else
 			{
 				citizendesc="";
 			}
 			String sql14="select country_code,long_desc from mp_country where eff_status = 'E'  and short_desc is not null order by long_desc";
 			pstmt14=conn.prepareStatement(sql14);
 			rs14=pstmt14.executeQuery();
 			if(rs14 != null)
 			{
				while (rs14.next())
				{
					citizen1=rs14.getString("country_code");
					if(citizen1 == null) citizen1="";
					citizendesc1=rs14.getString("long_desc");
					if (citizendesc1==null)citizendesc1="";
					
					
				 }
			}

///////////////
 			
 		
			
 			

		}catch(Exception e) {
					out.println("Query Error"+e);
				    }
			finally     {
								if(pstmt11 != null)pstmt11.close();
								if(pstmt14 != null) pstmt14.close();
								if(pstmt15 != null) pstmt15.close();
								if(pstmt17 != null) pstmt17.close();
								if(pstmt19 != null) pstmt19.close();
								if(pstmt21 != null) pstmt21.close();
								if(pstmt25 != null) pstmt25.close();
								if(pstmt26 != null) pstmt26.close();
								if(pstmt27 != null) pstmt27.close();
								if(pstmtp != null) pstmtp.close();
								if(pstmtm != null) pstmtm.close();
								if(pstmtc != null) pstmtc.close();
								if(pstmtr != null) pstmtr.close();
								if(pstmtrec != null)pstmtrec.close();
								if(pstmtofc != null) pstmtofc.close();
					 			if(pstmtmac != null) pstmtmac.close();

								if(rset != null) rset.close();
								if(rs14 != null) rs14.close();
								if(rs15 != null) rs15.close();
								if(rs19 != null) rs19.close();
								if(rs21 != null) rs21.close();
								if(rs25 != null) rs25.close();
								if(rs26 != null) rs26.close();
								if(rs27 != null) rs27.close();

								if(rsp != null) rsp.close();
								if(rsm != null) rsm.close();
								if(rsc != null) rsc.close();
								if(rsr != null) rsr.close();
								if(rsrec != null) rsrec.close();
								if(rsofc != null) rsofc.close();
					 			if(rsmac != null) rsmac.close();


			}


			
			
 			

		}		
		%>

<form name='practitioner_form' id='practitioner_form' >
	<a name='identitylink' id='identitylink'></a>
<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
<tr>
	<td nowrap  align='right' nowrap  class='label' width='20%'><fmt:message key="Common.type.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=practtypedesc%></td>
	<td nowrap>&nbsp;</td>
	<td nowrap>&nbsp;</td>
</tr>
	<tr><td colspan='4'>&nbsp;</td></tr>
<tr>
	<td nowrap  align='right'  class='label' width='20%'><fmt:message key="Common.identification.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=practitionerid%></td>
	<td nowrap >&nbsp;</td>
	<td nowrap >&nbsp;</td>
</tr>
	<tr><td colspan='4'>&nbsp;</td></tr>
<tr>
	<td nowrap  align='right'  class='label' width='20%' ><fmt:message key="Common.FullName.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=practitionername%></td>
	<td nowrap  align='right' class='label'  ><fmt:message key="Common.shortname.label" bundle="${common_labels}"/>&nbsp;</td>
	<td nowrap  align='left' colspan='1' class='queryData'>&nbsp;&nbsp;<%=shortname%></td>

</tr>
		<tr><td colspan='4'>&nbsp;</td></tr>
<tr>
	<td nowrap  align='right' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>&nbsp;</td>
	<td nowrap  align='left'>
	<% if(effstatus.equals("E")) { %>
	<img src='../../eCommon/images/enabled.gif'></img>
	<% } else { %>
	<img src='../../eCommon/images/RRnwd.gif'></img>
	<% } %>
	</td>
	<td nowrap  colspan='2'>&nbsp;</td>
</tr>

<tr>
        <td nowrap  colspan='4'>&nbsp;</td>

</tr>
</table>

<table name='insert_tab' id='insert_tab' cellspacing='0' cellpadding='0' border='0' width='100%'>
<tr>
<!--<td nowrap  align='left'  colspan='4'>
<a href="javascript:objClick('identity_link') "  alt='Identity'><img name='identity_link' border='0' src='../../eAM/images/Identity.gif' alt='Identity' ></img></a><a href="javascript:objClick('contactno_link') " alt='ContactNumber'><img name='contactno_link' border='0' src='../../eAM/images/Contact_Addr_click.gif' alt='ContactNumber' ></img></a>
</td>-->
<a name='demo'></a>
<td width= "100%" class="white" colspan='4'>
<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="identity">
				<a onclick="tab_click2('identity_link')" class="tabClicked" id="identity_link" >
					<span class="tabSpanclicked" id="identity_linkspan"><fmt:message key="Common.Identity.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="contactno">
				<a onclick="tab_click2('contactno_link')" class="tabA" id="contactno_link" >
					<span class="tabAspan" id="contactno_linkspan"><fmt:message key="Common.ContactNoAddr.label" bundle="${common_labels}"/></span>
				</a>
			</li> 
</ul>
</td>

</tr>

</table>

<table name='insert_tab' id='insert_tab' cellspacing='0' cellpadding='0' border='0' width='100%'>
<th colspan='4'>&nbsp;</th>
<tr>
	<td nowrap  align='right'  class='label' width='20%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  class='queryData' align='left'>
	<%if(effstatus.equals("E")) {%>
		<%=sex1%>
	<%}else if(effstatus.equals("D")) {%>
		<%=sex1%>
	<%}%>
	&nbsp;&nbsp;<fmt:message key="Common.age.label" bundle="${common_labels}"/>&nbsp;&nbsp;<%=bage%>&nbsp;Y&nbsp;<%=bmonths%>&nbsp;M&nbsp;<%=bdays%>&nbsp;D&nbsp;
	</td>
	<td nowrap  align='right' class='label' ><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left'  class='queryData'><%=birthdate%></td>
</tr>

<tr><td colspan='4'>&nbsp</td></tr>

<tr>
	<td nowrap  align='right' class='label' width='20%'><fmt:message key="Common.birthPlace.label" bundle="${common_labels}"/>&nbsp;&nbsp;	</td>
	<td nowrap  align='left' class='queryData'><%=birthplace%></td>
	<td nowrap  align='right' class='label'><fmt:message key="eMP.maritalstatus.label" bundle="${mp_labels}"/>&nbsp;&nbsp;</td>
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
	<td nowrap  align='right' class='label' width='20%'><fmt:message key="eMP.AliasName.label" bundle="${mp_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=aliasname%></td>
	<td nowrap  align ='right'  class='label' ><fmt:message key="Common.Citizenship.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'>
	<%if(effstatus.equals("E")) {%>
		<%=citizendesc%>&nbsp;
	<%}
	else if(effstatus.equals("D")) {%>
		<%=citizendesc%>&nbsp;
	<%}%>
	</td>
</tr>

<tr><td nowrap  colspan='4'>&nbsp;</td></tr>
<!--End HAS-CRF-160 -->
<tr>
<% 
if(natIdyn.equals("Y")) { %>
    
	<!--Below line added for this CRF HAS-CRF-160 -->
	<td nowrap  align='right'  class='label'><%=other_alt_type_desc%></td>
	<td nowrap  align='left' class='queryData'><%=other_alt_type_no%>&nbsp;</td>
	<td nowrap  align='right'  class='label' width='20%'><fmt:message key="eAM.NationalIDNo.label" bundle="${am_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=nationalidno%></td>

<% }else{%>
	<!--Below line added for this CRF HAS-CRF-160 -->	
		<td nowrap  align='right'  class='label'><%=other_alt_type_desc%>&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=other_alt_type_no%>&nbsp;</td>
	<td nowrap  align='right'  class='label' ><fmt:message key="Common.Position.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=jobtitle%></td>

	<!--HAS-CRF-160  -->
<%
}%>
</tr>

<tr><td nowrap  colspan='4'>&nbsp;</td></tr>

<tr>
	<td nowrap  align='right'  class='label' width='20%'><%if(natIdyn.equals("Y")) {%><fmt:message key="Common.Position.label" bundle="${common_labels}"/><%}else{%><fmt:message key="Common.Degree.label" bundle="${common_labels}"/><%}%>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%if(natIdyn.equals("Y")) {%><%=jobtitle%><%}else{%><%=degree%><%}%></td>
	<td nowrap  align='right'  class='label'><%if(natIdyn.equals("Y")) {%><fmt:message key="Common.Degree.label" bundle="${common_labels}"/><%}else{%><fmt:message key="Common.EmplStatus.label" bundle="${common_labels}"/><%}%>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%if(natIdyn.equals("Y")) {%><%=degree%><%}else{if(effstatus.equals("E")){%><%=emplstatus1%><%}else if(effstatus.equals("D")){%><%=emplstatus1%><%}}%>&nbsp;</td></tr>

<tr><td nowrap  colspan='4'>&nbsp</td></tr>
<tr>
	<td nowrap  align='right'  class='label' width='20%'><%if(natIdyn.equals("Y")) {%><fmt:message key="Common.EmplStatus.label" bundle="${common_labels}"/><%}else{%><fmt:message key="eAM.RepFacility.label" bundle="${am_labels}"/><%}%>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class= 'queryData'><%if(natIdyn.equals("Y")) {%>
		<%if(effstatus.equals("E")) {%>
			<%=emplstatus1%>
		<%}
		else if(effstatus.equals("D")) {%>
			<%=emplstatus1%>
		<%}}else{%><%=repfacilityname%><%}%>		
	</td>
	<td nowrap  align='right' class='label'><%if(natIdyn.equals("Y")) {%><fmt:message key="eAM.RepFacility.label" bundle="${am_labels}"/><%}else{%><fmt:message key="Common.AllFacilities.label" bundle="${common_labels}"/><%}%>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%if(natIdyn.equals("Y")) {%><%=repfacilityname%><%}else{
	if(all_facilities_yn.equals("Y")) {%>
	<img src='../../eCommon/images/enabled.gif'></img>
	<% } else { %>
		<img src='../../eCommon/images/RRnwd.gif'></img>
	<%}}%></td>
</tr>

<tr><td nowrap  colspan='4'>&nbsp;</td></tr>
<tr>
	<td nowrap  align='right'  class='label' width='20%'><%if(natIdyn.equals("Y")) {%><fmt:message key="Common.AllFacilities.label" bundle="${common_labels}"/><%}%>&nbsp;&nbsp;</td>
	<td nowrap  align='left'>
	<%if(natIdyn.equals("Y")) {
	if(all_facilities_yn.equals("Y")) {%>
	<img src='../../eCommon/images/enabled.gif'></img>
	<% } else { %>
		<img src='../../eCommon/images/RRnwd.gif'></img>
	<%}
	}%>
	</td>
	<td nowrap  colspan='2'>&nbsp;</td>
</tr>

</table>
	
	<br><br><br><br><br><br><BR><BR><BR>
<a name='contactnolink' id='contactnolink'></a>

<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
<tr>
	<td nowrap  align='right' nowrap  class='label' width='20%'><fmt:message key="Common.type.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=practtypedesc%></td>
	<td nowrap >&nbsp;</td>
	<td nowrap >&nbsp;</td>
</tr>
	<tr><td colspan='4'>&nbsp;</td></tr>
	<tr>
	<td nowrap  align='right'  class='label' width='20%'><fmt:message key="Common.identification.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=practitionerid%></td>
	<td nowrap >&nbsp;</td>
	<td nowrap >&nbsp;</td>
</tr>

<tr><td colspan='4'>&nbsp;</td></tr>
<tr>
	<td nowrap  align='right'  class='label' width='20%' ><fmt:message key="Common.FullName.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=practitionername%></td>
	<td nowrap  align='right' class='label' width='20%' ><fmt:message key="Common.shortname.label" bundle="${common_labels}"/>&nbsp;</td>
	<td nowrap  align='left' colspan='1' class='queryData'>&nbsp;&nbsp;<%=shortname%></td>

</tr>
	
<tr><td colspan='4'>&nbsp;</td></tr>
<tr>
	<td nowrap  align='right' class='label' width='20%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>&nbsp;</td>
	<td nowrap  align='left'>
	<% if(effstatus.equals("E")) { %>
	<img src='../../eCommon/images/enabled.gif'></img>
	<% } else { %>
	<img src='../../eCommon/images/RRnwd.gif'></img>
	<% } %>
	</td>
	<td nowrap  colspan='2'>&nbsp;</td>
</tr>

<tr>
        <td nowrap  colspan='4'>&nbsp;</td>

</tr>
</table>

<table name='insert_tab' id='insert_tab' cellspacing='0' cellpadding='0' border='0' width='100%'>
<tr>
<!--<td nowrap  align='left'  colspan='4'>
<a href="javascript:objClick('identity_link') "  alt='Identity'><img name='identity_link' border='0' src='../../eAM/images/Identity_click.gif' alt='Identity' ></img></a><a href="javascript:objClick('contactno_link') " alt='ContactNumber'><img name='contactno_link' border='0' src='../../eAM/images/Contact_Addr.gif' alt='ContactNumber' ></img></a>
</td>-->

<a name='addr'  id='addr' ></a>
<td width= "100%" class="white" colspan='4'>
<ul id="tablist" class="tablist" >
		<li class="tablistitem" title="identity">
				<a onclick="tab_click2('identity_link')" class="tabA" id="identity_link" >
					<span class="tabAspan" id="identity_linkspan"><fmt:message key="Common.Identity.label" bundle="${common_labels}"/></span>
				</a>
			</li>  
			<li class="tablistitem" title="contactno">
				<a onclick="tab_click2('contactno_link')" class="tabClicked" id="contactno_link" >
					<span class="tabSpanclicked" id="contactno_linkspan"><fmt:message key="Common.ContactNoAddr.label" bundle="${common_labels}"/></span>
				</a>
			</li>
</ul>


</td>

<script>prevTabObj='identity_link'</script>


</tr>
</table>

<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
	<td nowrap  align='right'  class='label' width='20%'><fmt:message key="Common.ResTelNo.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=restelnum%></td>
	<td nowrap  align='right'  class='label' width='20%'><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left'  class='queryData' >
		<%=offtelnum%>
	</td>
	<td nowrap  align='right'  class='label' width='20%'><fmt:message key="Common.Ext.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left'  class='queryData'><%=offtelext%>
	</td>
</tr>

<tr><td nowrap  colspan='6'>&nbsp;</td></tr>
<tr>
	<td nowrap  align='right'  class='label' width='20%'><fmt:message key="Common.FaxNo.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' class='queryData'>
		<%=faxnum%>
	</td>
	<td nowrap  align='right' class='label' width='20%'><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/>&nbsp;</td>
	<td nowrap  align='left' class='queryData'>
			<%=mobilenum%>
	</td>
	<td nowrap  align='right' class='label' width='20%'><fmt:message key="Common.PagerNo.label" bundle="${common_labels}"/>&nbsp;</td>
	<td nowrap  align='left' class='queryData'>
		<%=pagernum%>
	</td>
</tr>

<tr><td nowrap  colspan='6'>&nbsp;</td></tr>
<tr>
	<td nowrap  align='right' class='label' width='20%'><fmt:message key="eAM.PrefMode.label" bundle="${am_labels}"/>&nbsp;&nbsp;</td>
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
	<td nowrap  align='right' class='label' width='20%'><fmt:message key="Common.email.label" bundle="${common_labels}"/> <fmt:message key="Common.identification.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  align='left' colspan='5' class='queryData' ><%=emailid%></td>
	</tr>
		<tr><td colspan='6'>&nbsp;</td></tr>
</table>
	<!--<br>-->
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
	<td nowrap  align='right' width='20%' class='label'>&nbsp;</td>
	<td nowrap  align='left'  class='queryData'><fmt:message key="Common.residence.label" bundle="${common_labels}"/></td>
	<td nowrap  align='left'  class='queryData'><fmt:message key="Common.office.label" bundle="${common_labels}"/></td>
	<td nowrap  align='left'  class='queryData'><fmt:message key="Common.mail.label" bundle="${common_labels}"/></td>
</tr>
	<tr><td colspan='4'>&nbsp;</td></tr>
	<tr>
	<td nowrap  align='right' width='20%' class='label'><fmt:message key="Common.Address.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
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
	<td nowrap  align='right' width='20%' class='label'><fmt:message key="eMP.postalcode.label" bundle="${mp_labels}"/>&nbsp;</td>
	<td nowrap  align='left'  class='queryData'><%=respostalcode%></td>
	<td nowrap  align='left'  class='queryData'><%=offpostalcode%></td>
	<td nowrap  align='left' class='queryData'><%=mailpostalcode%></td>
</tr>
	
	<tr><td colspan='4'>&nbsp;</td></tr>
<tr>
	<td nowrap  align='right' width='20%' class='label'><fmt:message key="Common.country.label" bundle="${common_labels}"/>&nbsp;</td>
	<td nowrap  align='left' class='queryData'><%=rescountrydesc%></td>
	<td nowrap  align='left'  class='queryData'><%=offcountrydesc%></td>
	<td nowrap  align='left' class='queryData'><%=mailcountrydesc%></td>
</tr>
</table>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>




 	      <% 	postal_code.clear();}catch(Exception e){
		  e.printStackTrace();}
  	       	
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

