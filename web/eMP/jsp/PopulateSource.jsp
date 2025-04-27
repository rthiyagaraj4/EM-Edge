<!DOCTYPE html>
/*<!--
   		 Developed By  :- M.F.Mohamed Ali Suhail
   		 Function      :-  Referral Search (To search a referral id)
-->*/

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
	<%
    String locale =((String)session.getAttribute("LOCALE"));
    request.setCharacterEncoding("UTF-8");
	%>
	<html>
	
    


	<%
	  Connection con 				= null;
	try
	 {
		con 						=  ConnectionManager.getConnection(request);
		Statement stmt 				= con.createStatement();
		ResultSet rs 				= null;
		String user_id				= (String) session.getValue("login_user") ;
		String facilityid			= (String)session.getValue("facility_id");
		String source_type			= request.getParameter("source_type");
		source_type 				= (source_type == null)?"":source_type;
		String source				= request.getParameter("source");
		source 						= (source == null)?"":source;
	  
		String referred_from_location_type	= request.getParameter("referred_from_location_type");
		referred_from_location_type 		= (referred_from_location_type == null)?"":referred_from_location_type;
		String referred_to_location_type	= request.getParameter("referred_to_location_type");
		referred_to_location_type 		= (referred_to_location_type == null)?"":referred_to_location_type;

        String reffrom_locn_type="";
		String refto_locn_type="";
		  if(referred_from_location_type.equals("D"))
			    reffrom_locn_type="Y";
		    else
				reffrom_locn_type=referred_from_location_type;

        if(referred_to_location_type.equals("D"))
			    refto_locn_type="Y";
		    else
				refto_locn_type=referred_to_location_type;

		String list					= request.getParameter("List");
		list 						= (list == null)?"":list;
	
		String ref_from_location	= request.getParameter("referred_from_location");
		ref_from_location 			= (ref_from_location == null)?"":ref_from_location;
		String ref_to_location_type = request.getParameter("referred_to_location_type");
		ref_to_location_type 		= (ref_to_location_type == null)?"":ref_to_location_type;
		String ref_to_location		= request.getParameter("ref_to_location");
		ref_to_location 			= (ref_to_location == null)?"":ref_to_location;
		
		String fm_speciality_code	= request.getParameter("fm_speciality_code");
		String to_speciality_code	= request.getParameter("to_speciality_code");
		fm_speciality_code 			= (ref_to_location == null)?"":fm_speciality_code;      
		String tolocncode = request.getParameter("tolocncode");
		String preferDate = request.getParameter("preferDate");
		String callingMode = request.getParameter("callingMode");
		String speciality = request.getParameter("speciality");
		String careLocnTypeInd = request.getParameter("careLocnTypeInd");
		String patient_id = request.getParameter("patient_id");
		String resourceId = request.getParameter("resourceId")==null?"":request.getParameter("resourceId");		
		String to_locn_desc = request.getParameter("to_locn_desc")==null?"":request.getParameter("to_locn_desc");		
		String resourcedesc = request.getParameter("resourcedesc")==null?"":request.getParameter("resourcedesc");		
		

		String p_calling_function = request.getParameter("p_calling_function");
		String referralId = request.getParameter("referralId");
		String loc_type = request.getParameter("loc_type");
		referralId 			= (referralId == null)?"":referralId;
		tolocncode 			= (tolocncode == null)?"":tolocncode;
		loc_type 			= (loc_type == null)?"":loc_type;
	
		p_calling_function 			= (p_calling_function == null)?"":p_calling_function;
		String pCallingFunction		= request.getParameter("p_calling_function");
		pCallingFunction 			= (pCallingFunction == null)?"":pCallingFunction;		
		
        String lcare="";
		if(pCallingFunction.equals("OP_REG_VISIT"))
			lcare=" and level_of_care_ind='A' ";
		else if(pCallingFunction.equals("AE_REGISTER_ATTN"))
			lcare=" and level_of_care_ind='E' ";
		else if(pCallingFunction.equals("IP_BOOKING")||pCallingFunction.equals("IP_ADMIT")||pCallingFunction.equals("OA_BOOK_APPT"))
			lcare=" and level_of_care_ind in ('A','E') ";

        String svalue=request.getParameter("svalue");
		  svalue=(svalue==null)?"":svalue;
		
        String open_to_all_pract_yn = request.getParameter("open_to_all_pract_yn");
		open_to_all_pract_yn 		= (open_to_all_pract_yn == null)?"":open_to_all_pract_yn;

		String p_from_ref_code	    = request.getParameter("p_from_ref_code");
	    p_from_ref_code 		    = (p_from_ref_code == null)?"":p_from_ref_code;
		String p_from_locn_code	    = request.getParameter("p_from_locn_code");
	    p_from_locn_code 		    = (p_from_locn_code == null)?"":p_from_locn_code;
		String p_from_pract_id	    = request.getParameter("p_from_pract_id");
	    p_from_pract_id 		    = (p_from_pract_id == null)?"":p_from_pract_id;

		String p_to_locn_code	    = request.getParameter("p_to_locn_code");
	    p_to_locn_code 			    = (p_to_locn_code == null)?"":p_to_locn_code;
		String p_to_pract_id	    = request.getParameter("p_to_pract_id");
	    p_to_pract_id 			    = (p_to_pract_id == null)?"":p_to_pract_id;

		String care_ind = request.getParameter("care_ind");
		if(care_ind == null) care_ind="";	
		
	
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<BODY class='Message' onKeyDown = 'lockKey();'>
	<%
	try{
	       String source_desc 		= "";
	       String referral_code		= "";
	       String health_care_type	= "";
	     
		   String short_desc		= "";
		   String location_code		= "";
		
		   String ser_code="";
		   String ser_desc="";
           String sql2="";
		   String locntype_desc="";
		   String locntype_code="";
		   StringBuffer sql = new StringBuffer();
       	  

	  if(list!=null && list.equalsIgnoreCase("SOURCE"))
		     {
	         if(source_type!=null && source_type.equalsIgnoreCase("X"))
		        {
				  sql.append(" select a.healthcare_setting_type, a.referral_code, b.short_desc health_care_type_desc,a.long_desc source_desc from AM_REFERRAL_LANG_VW a, AM_HCARE_SETTING_TYPE_LANG_VW  b ");
				  sql.append(" where a.healthcare_setting_type = b.hcare_setting_type_code and a.eff_status='E' and a.language_id='"+locale+"' and b.language_id='"+locale+"' order by a.short_desc");
			    }	
			   else if (source_type.equalsIgnoreCase("E"))
			   {  
					sql.append(" select  a.facility_id,substr(a.facility_name,1,25) FACILITY_NAME, 'X', b.short_desc hcare_setting_type_desc from sm_facility_param_lang_vw a, am_hcare_setting_type_lang_vw b where a.hcare_setting_type_code = b.hcare_setting_type_code and a.language_id='"+locale+"' and b.language_id='"+locale+"' order by a.facility_name");
			    }  
			   else if (source_type.equalsIgnoreCase("L"))
			   {  
			    	sql.append(" select substr(a.facility_name,1,25) FACILITY_NAME, a.facility_id, 'X', b.short_desc hcare_setting_type_desc from sm_facility_param_lang_vw a,  am_hcare_setting_type_lang_vw b where a.hcare_setting_type_code = b.hcare_setting_type_code and a.facility_id = '"+facilityid+"' and a.language_id='"+locale+"' and b.language_id='"+locale+"' order by a.facility_name" );
				

				} 
			 
			  rs = stmt.executeQuery(sql.toString());	
	%>	
	<%	while(rs!=null && rs.next()){		
		
			source_desc    = rs.getString(1);
			referral_code  = rs.getString(2);
			health_care_type    = rs.getString(3);		
	%>
	<script>	
		//var opt=parent.f_query_add_mod.document.createElement("OPTION");
		//opt.text="<%=source_desc%>";
		//opt.value="<%=referral_code%>";
	   // if("<%=p_from_ref_code%>"=="<%=referral_code%>")
		//  opt.selected = true;
		 if ("<%=source_type%>"=="L"){
		 //opt.selected = true;
		 //parent.f_query_add_mod.document.forms[0].source.add(opt);
		//parent.f_query_add_mod.document.forms[0].health_care_setting_type.value = "<%=health_care_type%>";
parent.f_query_add_mod.document.forms[0].source_display.value = "<%=source_desc%>";
parent.f_query_add_mod.document.forms[0].source_display.disabled=true;
parent.f_query_add_mod.document.forms[0].source.value = "<%=referral_code%>";
parent.f_query_add_mod.document.forms[0].referral_source_lkp_but.disabled=true;
		 }


	</script>	
	<%	   } //End of while	

	if(rs != null) rs.close();

	sql.setLength(0);
	%>
	 </script>
	  <%
	   // }
		  if(rs != null) rs.close();
		    
	       try{
           
		    String locnsql="";
           if(source_type.equals("L")){  
		
			locnsql="select short_desc,locn_type,care_locn_type_ind from am_care_locn_type_lang_vw  where care_locn_type_ind in ('C','E','D','N') and locn_type in ('C','E','Y','N') and  SYS_USER_DEF_IND='S' and language_id='"+locale+"' order by short_desc";
		
		 rs=stmt.executeQuery(locnsql);
		 if(rs != null)
			{
			   while(rs.next())
				{
				   locntype_desc=rs.getString(1);
				   locntype_code=rs.getString(2);
                   
				  %>
			  <script>
				var opt=parent.f_query_add_mod.document.createElement("OPTION");
		        opt.text="<%=locntype_desc%>";
		        opt.value="<%=locntype_code%>";
				parent.f_query_add_mod.document.forms[0].referred_from_location_type.add(opt);
	          </script>
				  <%

				}
			}
		
		if(rs != null) rs.close();
           }

		}catch(Exception e){e.printStackTrace();}
		 
	  }  // end of list source
		else if(list!=null && list.equalsIgnoreCase("FROM_LOCATION"))
		{
		        if(referred_from_location_type!=null && !(referred_from_location_type.equalsIgnoreCase("N")))
		        {
				   
				  if(to_speciality_code.equals("")){ 
				   sql.append(" select long_desc short_desc,clinic_code from op_clinic_lang_vw  where facility_id='"+source+"' and eff_status='E' "+lcare+" and clinic_type='"+reffrom_locn_type+"' and language_id='"+locale+"' order by short_desc" );
				  }else{
				sql.append(" select long_desc short_desc,clinic_code from op_clinic_lang_vw where facility_id='"+source+"' and eff_status='E' "+lcare+" and Speciality_Code='"+to_speciality_code+"' and clinic_type='"+reffrom_locn_type+"' and language_id='"+locale+"' order by short_desc" );
				  }
				
				}	
			   else if (referred_from_location_type.equalsIgnoreCase("N"))
			   {  
			       if(to_speciality_code.equals("")){ 
				   sql .append(" SELECT long_desc short_desc, NURSING_UNIT_CODE FROM ip_nursing_unit_lang_vw WHERE FACILITY_ID ='"+source+"' and language_id='"+locale+"' order by short_desc" );
				   }else{
					   sql.append("SELECT ip_get_desc.ip_nursing_unit('"+source+"', nursing_unit_code, '"+locale+"', 1) short_desc, NURSING_UNIT_CODE FROM ip_nurs_unit_for_specialty WHERE FACILITY_ID ='"+source+"' and SPECIALTY_CODE='"+to_speciality_code+"' order by short_desc"); 
				   }
			    }  
	      rs = stmt.executeQuery(sql.toString());		
	%>	
	<%	while(rs!=null && rs.next()){		
			short_desc    = rs.getString(1);
			location_code  = rs.getString(2);
	%>
	<script>			
		var opt=parent.f_query_add_mod.document.createElement("OPTION");
		opt.text="<%=short_desc%>";
		opt.value="<%=location_code%>";
    	if("<%=p_from_locn_code%>"=="<%=location_code%>")
			opt.selected = true;
			parent.f_query_add_mod.document.forms[0].referred_from_location.add(opt);
			</script>	
	<%	   } //End of while	
			if(rs != null) rs.close();

			sql.setLength(0);
	    }  // end of list location
		else if(list!=null && list.equalsIgnoreCase("TO_LOCATION"))
		     {
		        if(referred_to_location_type!=null && !(referred_to_location_type.equalsIgnoreCase("N")))
		        {
				   sql.append(" select long_desc short_desc,clinic_code from op_clinic_lang_vw where facility_id='"+source+"' and eff_status='E' "+lcare+"  and clinic_type='"+referred_to_location_type+"' and language_id='"+locale+"' order by short_desc" );
			    }	
			   else if (referred_to_location_type.equalsIgnoreCase("N"))
			   {  
			       sql.append(" select long_desc short_desc,nursing_unit_code from ip_nursing_unit_lang_vw  where facility_id='"+source+"' and eff_status='E' and language_id='"+locale+"' order by short_desc" );
			    }  
//		      out.println(sql);	   
		      rs = stmt.executeQuery(sql.toString());		
				%>	
				<%	while(rs!=null && rs.next()){		
						short_desc    = rs.getString(1);
						location_code  = rs.getString(2);
						//out.println("short_desc 273============"+short_desc);
						//out.println("location_code 274============"+location_code);
				%>
				<script>			
					var opt=parent.f_query_add_mod.document.createElement("OPTION");
					opt.text="<%=short_desc%>";
					opt.value="<%=location_code%>";
					if("<%=p_to_locn_code%>"=="<%=location_code%>")
					  opt.selected = true;
					parent.f_query_add_mod.document.forms[0].referred_to_location.add(opt);
				</script>	
				<%	   } //End of while		
				if(rs != null) rs.close();

				sql.setLength(0);
				}  // end of list location
	else if(list!=null && list.equalsIgnoreCase("FM_SPECILITY_CODE"))
		{
			 sql.append(" Select service_Code service_code, Short_Desc  short_desc from  Am_Service_lang_vw where eff_status = 'E' and language_id='"+locale+"' order by 2" );
 
		     rs = stmt.executeQuery(sql.toString());		
		     while(rs!=null && rs.next()){		
			 location_code   = rs.getString(1);
			 short_desc      = rs.getString(2);
	%>
- 	<script>			
/*		var opt=parent.f_query_add_mod.document.createElement("OPTION");
		opt.text="<%=short_desc%>";
		opt.value="<%=location_code%>";
    	if("<%=p_from_locn_code%>"=="<%=location_code%>")
		  opt.selected = true;
		parent.f_query_add_mod.document.forms[0].fm_service_code.add(opt);*/
	</script>	
 	<%	   
		} //End of while		
	if(rs != null) rs.close();
	
    sql.setLength(0);
	    }  // end of list location

	else if(list!=null && list.equalsIgnoreCase("TO_SPECILITY_CODE"))
		{
			 sql.append(" Select Service_Code service_code, Short_Desc  short_desc from Am_Service_lang_vw where eff_status = 'E' and language_id='"+locale+"' order by 2" );

		     rs = stmt.executeQuery(sql.toString());		
		     while(rs!=null && rs.next()){		
			 location_code   = rs.getString(1);
			 short_desc      = rs.getString(2);
	%>
	<script>			
	/*	var opt=parent.f_query_add_mod.document.createElement("OPTION");
		opt.text="<%=short_desc%>";
		opt.value="<%=location_code%>";
    	if("<%=p_from_locn_code%>"=="<%=location_code%>")
		  opt.selected = true;
		parent.f_query_add_mod.document.forms[0].to_service_code.add(opt);*/
	</script>	
	<%	   } //End of while	
	if(rs != null) rs.close();

	sql.setLength(0);

	    }  // end of list location
	
		else if(list!=null && list.equalsIgnoreCase("PRACTITIONER"))
		     {
				
				 if(source_type.equals("L")||source_type.equals("E")||svalue.equals("toService"))
				 {
                   if(referred_from_location_type.equals("C"))
					 {
					 sql.append("select service_code,short_desc from am_service_lang_vw where language_id='"+locale+"' and service_code in(select a.service_code from op_clinic a where a.clinic_code ='"+ref_from_location+"' and a.facility_id='"+facilityid+"' and a.care_locn_type_ind = 'C' and a.clinic_type='C' union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+facilityid+"' and a.clinic_code = '"+ref_from_location+"' ) order by short_desc");
					 }
					else if(referred_from_location_type.equals("E"))
					 {
					   sql.append("select service_code,short_desc from am_service_lang_vw where language_id='"+locale+"' and service_code in(select a.service_code from op_clinic a where  a.clinic_code ='"+ref_from_location+"' and a.facility_id='"+facilityid+"' and a.care_locn_type_ind = 'E' union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+facilityid+"'  and a.clinic_code = '"+ref_from_location+"' ) order by short_desc" );
				     }
					 else if(referred_from_location_type.equals("Y"))
					 {
						 sql.append("select service_code,short_desc from am_service_lang_vw where language_id='"+locale+"' and service_code in(select a.service_code from op_clinic a where  a.clinic_code ='"+ref_from_location+"' and a.facility_id='"+facilityid+"' and a.care_locn_type_ind = 'D' and a.clinic_type='Y' union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+facilityid+"'  and a.clinic_code = '"+ref_from_location+"' ) order by short_desc");
					 }
					 else if(referred_from_location_type.equals("N"))
						 {

						 sql.append("select service_code,short_desc from am_service_lang_vw where language_id='"+locale+"' and service_code in(select a.service_code from ip_nursing_unit a where a.nursing_unit_code ='"+ref_from_location+"' and a.facility_id='"+facilityid+"' and a.appl_patient_class = 'IP' union select a.service_code from ip_nurs_unit_for_service a,ip_nursing_unit b where a.nursing_unit_code = b.nursing_unit_code and a.facility_id=b.facility_id and a.facility_id='"+facilityid+"'and b.appl_patient_class = 'IP' and a.nursing_unit_code = '"+ref_from_location+"') order by short_desc");
					    }
					  else if(referred_from_location_type.equals("W"))
					 {
						  sql.append("SELECT distinct C.SERVICE_CODE service_code,D.SHORT_DESC short_desc FROM RD_SECTION_CTL A,RD_WINGS B,RD_SECTION C,AM_SERVICE_lang_vw D WHERE   A.OPERATING_FACILITY_ID='"+facilityid+"' AND A.WING_CODE = NVL('"+ref_from_location+"',A.WING_CODE) AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.WING_CODE = B.WING_CODE AND A.SECTION_CODE = C.SECTION_CODE AND C.SERVICE_CODE = D.SERVICE_CODE AND language_id='"+locale+"' and B.INT_OR_EXT = 'I'");
					 }
					 
					 if(ref_from_location.equals("")){
						 sql.setLength(0);
						 if(referred_from_location_type.equals("W"))
						{
						  sql.append("SELECT  WING_CODE,SHORT_DESC FROM RD_WINGS WHERE  OPERATING_FACILITY_ID  ='"+facilityid+"' AND INT_OR_EXT= 'I' AND STATUS IS NULL");
						}
						else
							{
						 sql.append("select a.service_code, b.short_desc from am_facility_service a, am_service_lang_vw b where a.operating_facility_id='"+facilityid+"' and a.service_code=b.service_code and b.language_id='"+locale+"' order by short_desc");
							}

					}
					 
				    if(!ref_from_location.equals("")){
					if(!referred_from_location_type.equals("N")){
					   sql2="select OPEN_TO_ALL_PRACT_YN  from op_clinic where clinic_code='"+ref_from_location+"' and facility_id='"+facilityid+"'";
						}
					}
				 
				 }
				 
				   rs = stmt.executeQuery(sql.toString());
				while(rs!=null && rs.next())
				 {
					ser_code=rs.getString(1);
					ser_desc=rs.getString(2);
					if(svalue.equals("toService"))
					 {
					%>
					<script>
					/* var opt=parent.f_query_add_mod.document.createElement("OPTION");
					opt.text='<%=ser_desc%>';  
					opt.value='<%=ser_code%>';
					parent.f_query_add_mod.document.forms[0].to_service_code.add(opt);*/
					</script>
					<%
					}else if(svalue.equals("")){%>
					 	<script>
					/* var opt=parent.f_query_add_mod.document.createElement("OPTION");
					opt.text='<%=ser_desc%>';  
					opt.value='<%=ser_code%>';
					parent.f_query_add_mod.document.forms[0].fm_service_code.add(opt);*/
					</script> 
					<%
					}
				}

				if(rs != null) rs.close();

				sql.setLength(0);
				 if(!ref_from_location.equals("")){
					if(!referred_from_location_type.equals("N")){
				rs = stmt.executeQuery(sql2);
				if(rs.next())
				 {
					open_to_all_pract_yn=rs.getString(1);
					%><script>
					parent.f_query_add_mod.document.forms[0].open_to_all_pract_yn1.value="<%=open_to_all_pract_yn%>";
					</script>
				 <%}
					if(rs != null) rs.close();
					}}
	    }  // end of list practitioner

        
		 else if(list!=null && list.equalsIgnoreCase("REF_TO_LOCATION"))  // for referred to 
		     {
				 if(ref_to_location_type!=null && !(ref_to_location_type.equalsIgnoreCase("N")))
				 {
				    if(pCallingFunction.equals("INDEPENDENT"))
				    {
				      if(to_speciality_code.equals("")){ 
				       
					   sql.append(" select long_desc short_desc,clinic_code,open_to_all_pract_yn from op_clinic_lang_vw  where facility_id='"+facilityid+"' and eff_status='E' "+lcare+" and clinic_type='"+refto_locn_type+"' and language_id='"+locale+"' order by short_desc" );
				  }else{
				       sql.append(" select long_desc short_desc,clinic_code,open_to_all_pract_yn from op_clinic_lang_vw where facility_id='"+facilityid+"' and eff_status='E' "+lcare+" and Speciality_Code='"+to_speciality_code+"' and clinic_type='"+refto_locn_type+"' and language_id='"+locale+"' order by short_desc" );
				  }
			    
			       }
				    else
				    {
						 if(to_speciality_code.equals("")){  
						sql.append(" select long_desc short_desc,clinic_code,open_to_all_pract_yn from op_clinic_lang_vw  where facility_id='"+facilityid+"' and eff_status='E' "+lcare+" and language_id='"+locale+"' order by short_desc" );
                       }else{
										
							sql.append(" select long_desc short_desc,clinic_code,open_to_all_pract_yn from op_clinic_lang_vw  where facility_id='"+facilityid+"' and eff_status='E' "+lcare+" and Speciality_Code='"+to_speciality_code+"' and language_id='"+locale+"' order by short_desc" );
						
							}
					   }

	                   
					}
				else if(ref_to_location_type!=null && ref_to_location_type.equalsIgnoreCase("N"))
				 {
				    if(pCallingFunction.equals("INDEPENDENT"))
				    {
					// no operator station check
		              		 if(to_speciality_code.equals("")){ 
				   sql.append(" SELECT long_desc short_desc, NURSING_UNIT_CODE FROM ip_nursing_unit_lang_vw WHERE FACILITY_ID ='"+facilityid+"' and language_id='"+locale+"' order by short_desc" );
				   }else{
					   sql.append("SELECT ip_get_desc.ip_nursing_unit('"+facilityid+"', nursing_unit_code, '"+locale+"', 1) short_desc, NURSING_UNIT_CODE FROM IP_NURS_UNIT_FOR_SPECIALTY WHERE FACILITY_ID ='"+facilityid+"' and SPECIALTY_CODE='"+to_speciality_code+"' order by short_desc"); 
				    }
				    }
				    else
				    {
						if(to_speciality_code.equals("")){  
							sql.append("select long_desc short_desc, nursing_unit_code from ip_nursing_unit_lang_vw where facility_id='"+facilityid+"' and eff_status = 'E' and language_id='"+locale+"' order by short_desc" );							
							}else{
							sql.append("select ip_get_desc.ip_nursing_unit('"+facilityid+"', nursing_unit_code, '"+locale+"', 1) short_desc, nursing_unit_code from IP_NURS_UNIT_FOR_SPECIALTY where facility_id='"+facilityid+"' and SPECIALTY_CODE='"+to_speciality_code+"' order by short_desc");
						}
					     
					}
				
				 }

				 if(ref_to_location_type.equals("W"))
				 {
					 sql.setLength(0);
	
					 sql.append("SELECT  SHORT_DESC dat,WING_CODE id, 'N' open_to_all_pract_yn FROM RD_WINGS WHERE  OPERATING_FACILITY_ID  ='"+facilityid+"' AND INT_OR_EXT= 'I' AND STATUS IS NULL");
				 }
			 
		      rs = stmt.executeQuery(sql.toString());		
	%>	
	<%	while(rs!=null && rs.next()){		
		 if(ref_to_location_type!=null && !(ref_to_location_type.equalsIgnoreCase("N")))
		  {
			short_desc			 = rs.getString(1);
			location_code		 = rs.getString(2);
			open_to_all_pract_yn = rs.getString(3);
          }
		  else if(ref_to_location_type!=null && ref_to_location_type.equalsIgnoreCase("N"))
		  {
  		    short_desc			 = rs.getString(1);
			location_code		 = rs.getString(2);
          }
	%>
	<script>
		var opt=parent.f_query_add_mod.document.createElement("OPTION");
		opt.text="<%=short_desc%>";
		opt.value="<%=location_code%>";
		parent.f_query_add_mod.document.forms[0].referred_to_location.add(opt);
	 parent.f_query_add_mod.document.forms[0].open_to_all_pract_yn.value="<%=open_to_all_pract_yn%>";

	</script>	
	<%	   } //End of while	
	if(rs != null) rs.close();

	sql.setLength(0);
	    }  // end of list ref_to_location
   else if(list!=null && list.equalsIgnoreCase("Location_Populate"))
		{
            
    	 String locnsql="";
       
		locnsql="select short_desc, locn_type from am_care_locn_type_lang_vw where care_locn_type_ind in ('C','E','D','N') and locn_type in ('C','E','Y','N') and  SYS_USER_DEF_IND='S' and and language_id='"+locale+"' order by short_desc";
		rs=stmt.executeQuery(locnsql);
		if(rs != null)
			{
			   while(rs.next())
				{
				   locntype_desc=rs.getString(1);
				   locntype_code=rs.getString(2);
                        
				  %>
			  <script>
				var opt=parent.f_query_add_mod.document.createElement("OPTION");
		        opt.text="<%=locntype_desc%>";
		        opt.value="<%=locntype_code%>";
				parent.f_query_add_mod.document.forms[0].referred_from_location_type.add(opt);
	             
			  </script>
				  <%

				}
			}
		
		if(rs != null) rs.close();
		} else if(list!=null && list.equalsIgnoreCase("OPER_STN_ACCESS_CHECK")) {
			// This block is added by Suresh M for PE to check for Operator Station Access in Referal Search Result.
			//String sqlQuery = "";
			StringBuffer sqlQuery = new StringBuffer();
			String OsVal = "";
			String OsVal1 = "";
			String functionAccess = "";
			String primary_resource_class="";
			String locntype = "";

			boolean prim_res_check=true;
			
			if(p_calling_function.equals("OP_REG_VISIT"))
				functionAccess = "REGISTER_VISIT_YN";
			else if(p_calling_function.equals("REV_VISIT_DTLS"))
					functionAccess = "REVISE_VISIT_YN";
			else if(p_calling_function.equals("OA_BOOK_APPT") || p_calling_function.equals("OA_MODIFY_APPT"))
				functionAccess = "BOOK_APPT_YN";
			else if(p_calling_function.equals("OA_PENDING_REFERRAL_BOOKING"))
				functionAccess = "BOOK_APPT_YN";
			else if(p_calling_function.equals("IP_BOOKING"))
				functionAccess = "CREATE_BOOKING_YN";
			else if(p_calling_function.equals("IP_ADMIT"))
				functionAccess = "ADMIT_PAT_YN";
			else if(p_calling_function.equals("CHG_ADM_DTLS"))
				functionAccess = "REVISE_ADMISSION_YN";
			else if(p_calling_function.equals("IP_PENDING_REFERRAL_BOOKING"))
				functionAccess = "CREATE_BOOKING_YN";			
			else if(p_calling_function.equals("AE_REGISTER_ATTN"))
				functionAccess = "REGISTER_VISIT_YN";
			else if(p_calling_function.equals("CHG_REG_DTLS"))
				functionAccess = "REVISE_VISIT_YN";			

			 
			if(!functionAccess.equals("")){				
				if(functionAccess.equals("CREATE_BOOKING_YN") || functionAccess.equals("ADMIT_PAT_YN") || functionAccess.equals("REVISE_ADMISSION_YN") ) {
					locntype = "N";
				} else {
					locntype = "X";
				}

				sqlQuery.append("Select AM_OPER_STN_ACCESS_CHECK('"+facilityid+"','"+user_id+"','"+locntype+"','"+tolocncode+"','"+functionAccess+"') OsVal,(select primary_resource_class from op_clinic WHERE facility_id='"+facilityid+"' and clinic_code='"+tolocncode+"') primary_resource_class");
				if(p_calling_function.equals("IP_BOOKING")){					sqlQuery.append(",AM_OPER_STN_ACCESS_CHECK('"+facilityid+"','"+user_id+"','"+locntype+"','"+tolocncode+"','CREATE_BOOKING_WITH_CONF_YN') OsVal1");
				}				
				sqlQuery.append("  FROM DUAL");
			
				rs=stmt.executeQuery(sqlQuery.toString());
				if(rs != null && rs.next())
				{
					OsVal = rs.getString("OsVal");
					if(p_calling_function.equals("IP_BOOKING")){	
						OsVal1 = rs.getString("OsVal1");
						if((OsVal.equals("1")) || (OsVal.equals("2")) || (OsVal.equals("3")) || (OsVal.equals("4")) || (OsVal.equals("5"))){
							OsVal = OsVal1;
						}
					}					
					primary_resource_class=rs.getString("primary_resource_class")==null?"":rs.getString("primary_resource_class");					
				}				
			}		
		
			if(OsVal.equals("1"))
			 {
			 out.print(" <script>alert(parent.frames[1].getMessage('VISIT_REGN_NOT_ALL_OPERSTN','OP'));</script>");
			}else if(OsVal.equals("2"))
			{
			out.print(" <script>alert(parent.frames[1].getMessage('NO_CLINICS_FOR_USER','Common'));</script>");
			}else  if(OsVal.equals("3"))
			{
			 out.print(" <script>alert(parent.frames[1].getMessage('OPER_STN_RESTRN','OP'));</script>");			
			}else  if(OsVal.equals("4"))
			{
			out.print(" <script>alert(parent.frames[1].getMessage('INVALD_USER_FCY','OP'));</script>");
			}else  if(OsVal.equals("5"))
			{
			out.print(" <script>alert(parent.frames[1].getMessage('INVALID_OPER_STN_ACCESS','Common'));</script>");
			}
            else if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5")))
	        {	
			  if(p_calling_function.equals("IP_PENDING_REFERRAL_BOOKING") || p_calling_function.equals("OA_PENDING_REFERRAL_BOOKING")) {
					if(loc_type.equals("N"))
						{ %><script>
						
							referral_id = '<%=referralId%>';
							var arguments = "";
							var retVal = 	new String();
							var dialogHeight= "41";
							var dialogWidth = "65";
							var dialogTop	= "72";
							var status = "no";
							var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ; dialogTop:" + dialogTop + " ; scroll=no; status:" + status ;
							var retVal = window.showModalDialog("../../eIP/jsp/Booking.jsp?home_required_yn=N&referral_id="+referral_id+"&function_type=F&access=NYNNN&call_func=OP_Pending_Referral_Booking",arguments,features);		
							</script>
						<%
						} else if(!loc_type.equals("N")){
								//Added some additional parameters by S.Sathish for IN021901 on Friday, June 11, 2010 
								if(!primary_resource_class.equals("P") && !resourceId.equals("")){
									prim_res_check=false;
								}							
								if(prim_res_check){
								%><script>									
										var resourceId  = '<%=resourceId%>';
										var referral_id = '<%=referralId%>';
										var patient_id = '<%=patient_id%>';
										var careLocnTypeInd = '<%=careLocnTypeInd%>';
										var speciality = '<%=speciality%>';
										var callingMode = '<%=callingMode%>';
										var preferDate = '<%=preferDate%>';
										var clinicCode = '<%=tolocncode%>';
										var clinicDesc = '<%=to_locn_desc%>';
										var resourceDesc = '<%=resourcedesc%>';										
										var qryStr = "../../eOA/jsp/CAOAAppointment.jsp?referral_id="+referral_id+"&i_practitioner_id="+resourceId+"&patient_id="+patient_id+"&i_clinic_code="+clinicCode+"&recall_date=&locn_type="+careLocnTypeInd+"&specialty_code="+speciality+"&callingMode="+callingMode+"&from_page=Pending_referral&waitListNo=&resource_class=&clinic_code="+clinicCode+"&from_OR=N&from_AE=N&care_locn_ind="+careLocnTypeInd+"&recall_date="+preferDate+"&resourceDesc="+resourceDesc+"&clinicDesc="+clinicDesc;
										parent.parent.location.href =qryStr;
									
							
								</script>
							<%} else {%>
								<script>alert(parent.frames[1].getMessage('MISMATCH_PRIM_RES','OA'));</script>
							<%}
				}} else {
			%><script>					
				//parent.window.returnValue='<%=referralId%>';
				//parent.window.close();				
				let dialogBody = parent.parent.document.getElementById('dialog-body');
				dialogBody.contentWindow.returnValue = '<%=referralId%>';   
				const dialogTag = parent.parent.document.getElementById("dialog_tag");    
				dialogTag.close(); 	
				
			</script>
		<%}
		} 	
		}
 	out.println("</form></body></html>");	
	   }   catch(Exception e)
	 	    { e.toString();e.printStackTrace();   }
	       finally {
	 	         try{
		               if(rs!=null)  rs.close(); 
					   if(stmt!=null) stmt.close(); 
		            }
		         catch(Exception e)
		           { e.toString(); e.printStackTrace();  } 
		       }
			out.println("</form></body></html>");	
			} catch(Exception e){e.printStackTrace();}
			finally
			{
				ConnectionManager.returnConnection(con,request);
			}
			%>

