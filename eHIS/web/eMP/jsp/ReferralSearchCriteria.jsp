
<!--
   		 Developed By  :- M.F.Mohamed Ali Suhail
   		 Function      :-  Referral Search (To search a referral id)
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*, java.io.*,java.util.*, webbeans.eCommon.*,org.json.simple.*" contentType="text/html;charset=UTF-8"%>
<%
        
		String locale =((String)session.getAttribute("LOCALE"));
		request.setCharacterEncoding("UTF-8");
		String p_calling_function    = request.getParameter("p_calling_function");
        p_calling_function           = (p_calling_function==null)?"":p_calling_function;
		String calledFrom         = request.getParameter("calledFrom");
		if(calledFrom==null) calledFrom =""; 
		String Unregpatbkgyn         = request.getParameter("Unregpatbkgyn");
		if(Unregpatbkgyn==null) Unregpatbkgyn ="N"; 
		String ass_func_id=(request.getParameter("ass_func_id") ==null)?"":request.getParameter("ass_func_id");
		 String p_to_locn_type        =  request.getParameter("p_to_locn_type");
        p_to_locn_type               = (p_to_locn_type==null)?"":p_to_locn_type;
	  String callingMode=(request.getParameter("callingMode") == null)?"":request.getParameter("callingMode");
 
%>
<html>
<head>
   
   <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script src='../../eCommon/js/ValidateControl.js'></script>
    <script src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
    <script src='../../eMP/js/RegPatReferral.js' language='javascript'></script>
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
  <script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
    <script src='../../eMP/js/ReferralSearch.js' language='javascript'></script>
    <script language="JavaScript">
         var NamePrefixArray = new Array();
         var PrefixSexArray = new Array();

		 var careArray=new Array();
	     var i=1;
	</script>
</head>
<% 
        Connection con               = null;
        Statement stmt               = null;
        ResultSet rset               = null ;
        ResultSet rs                 = null ;
        PreparedStatement pstmt      = null;
        String sql                   = "";
		//Below Added by Suji Keerthi for NMC-JD-CRF-0130
		String priority_Code="";
		String priority_Desc="";
		JSONObject RefPriorityJson = new JSONObject();
		JSONArray refPriorityjsonArr = new JSONArray();	
try{
        con                  = ConnectionManager.getConnection(request);
        stmt                 = con.createStatement();
	    //Below Added by Suji Keerthi for NMC-JD-CRF-0130
        Boolean isReferralPriorityAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AM","REFERRAL_PRIORITY_DESC");

		RefPriorityJson = eIP.IPCommonBean.getReferralPriority(con); 
		refPriorityjsonArr = (JSONArray)RefPriorityJson.get("refPriorityArray");
		
		//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		Boolean isImproveReferralProcessAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"OP","IMPROVE_REFERRAL_PROCESS"); 

		JSONObject dateDtlJson = new JSONObject();
		dateDtlJson = eMP.MPCommonBean.getCurrentFromAndToDate(con);

		String current_from_date	= checkForNull((String) dateDtlJson.get("current_from_date"));
		String current_to_date		= checkForNull((String) dateDtlJson.get("current_to_date"));

	 	String facilityid=(String)session.getValue("facility_id");
		String user_id				= (String) session.getValue("login_user") ;
		String[] names               = new String[4] ;
        String[] name_prompts        = new String[4] ;
        String first_name_disp       = "";
        String second_name_disp      = "";
        String third_name_disp       = "";
        String family_name_disp      = "";
    
        String sysdate               = "";
        String OsVal               = "";
        String register_visit_referral_yn               = "";
		//Added by Kamatchi S for MOHE-CRF-0154
		String allow_reg_referral_yn = "N";
		allow_reg_referral_yn = eMP.MPCommonBean.getRegisterReferralYN(con,facilityid);
		String loc_sql="";
        String dat="";
		String id="";
		String careind="";
		String p_patient_id          =  request.getParameter("p_patient_id");
        p_patient_id                 = (p_patient_id==null)?"":p_patient_id;
        String p_referral_id         =  request.getParameter("p_referral_id");
        p_referral_id                = (p_referral_id==null)?"":p_referral_id;

        String p_from_date           =  request.getParameter("p_from_date");
        p_from_date                  = (p_from_date==null)?"":p_from_date;
        String p_to_date             =  request.getParameter("p_to_date");
        p_to_date                    = (p_to_date==null)?"":p_to_date;

        String p_from_ref_type       =  request.getParameter("p_from_ref_type");
        p_from_ref_type              = (p_from_ref_type==null)?"":p_from_ref_type;
        String p_from_ref_code       =  request.getParameter("p_from_ref_code");
        p_from_ref_code              = (p_from_ref_code==null)?"":p_from_ref_code;

        String p_from_locn_type      =  request.getParameter("p_from_locn_type");
        p_from_locn_type             = (p_from_locn_type==null)?"":p_from_locn_type;
        String p_from_locn_code      =  request.getParameter("p_from_locn_code");
        p_from_locn_code             = (p_from_locn_code==null)?"":p_from_locn_code;
        String p_from_pract_id       =  request.getParameter("p_from_pract_id");
        p_from_pract_id              = (p_from_pract_id==null)?"":p_from_pract_id;
        String p_to_ref_type         =  request.getParameter("p_to_ref_type");
        p_to_ref_type                = (p_to_ref_type==null)?"":p_to_ref_type;

        String p_to_ref_code         =  request.getParameter("p_to_ref_code");
        p_to_ref_code                = (p_to_ref_code==null)?"":p_to_ref_code;
		
		String p_to_locn_code        =  request.getParameter("p_to_locn_code");
        p_to_locn_code               = (p_to_locn_code==null)?"":p_to_locn_code;
		
        String p_to_pract_id         =  request.getParameter("p_to_pract_id");
        p_to_pract_id                = (p_to_pract_id==null)?"":p_to_pract_id;

        String p_to_pract_name         =  request.getParameter("p_to_pract_name");
        p_to_pract_name                = (p_to_pract_name==null)?"":p_to_pract_name;			
		String p_search_speciality_code     =  request.getParameter("p_speciality_code");
        p_search_speciality_code          = (p_search_speciality_code==null)?"":p_search_speciality_code;
		
        String p_service_code     =  request.getParameter("p_service_code");
        p_service_code          = (p_service_code==null)?"":p_service_code;
		
		//Added by Santhosh for MMS-DM-CRF-0209.4-US005
		String p_service_desc     =  request.getParameter("p_service_desc");
		p_service_desc          = (p_service_desc==null)?"":p_service_desc;

        String p_select              =  request.getParameter("p_select");
        p_select                     = (p_select==null)?"":p_select;
        String p_reg_patient         =  request.getParameter("p_reg_patient");
        p_reg_patient                = (p_reg_patient==null)?"":p_reg_patient;

		String res_class=(request.getParameter("res_class") == null)?"":request.getParameter("res_class");
        String patient_id_length     = "";
		String ca_patient_id=request.getParameter("ca_patient_id")==null?"":request.getParameter("ca_patient_id");
		String name_prefix_accept_yn = "";
		String name_prefix_reqd_yn = "";
		String name_suffix_reqd_yn = "";
		String name_suffix_accept_yn = "";
		String name_prefix_prompt = "";
		String first_name_accept_yn = "";
		String first_name_reqd_yn = "";
		String first_name_prompt = "";
		String name_suffix_prompt = "";
		String second_name_accept_yn = "";
		String second_name_reqd_yn = "";
		String second_name_prompt = "";
		String third_name_accept_yn = "";
		String third_name_reqd_yn = "";
		String third_name_prompt = "";
		String family_name_accept_yn = "";
		String family_name_reqd_yn = "";
		String first_name_order = "";
		String second_name_order = "";
		String pat_name_as_multipart_yn = "";
		String third_name_order = "";
		String names_in_oth_lang_yn = "";
		String family_name_order = "";
		String family_name_prompt = "";
		String name_dervn_logic = "";

/*Added by Rameswar on  19-04-2016 for HSA-CRF-0299*/
		String family_name_length="";
		String fam_name_ind="N";
		String width="100%";
				
        try{
              String sqlQuery = "select patient_id_length, to_char(sysdate,'dd/mm/yyyy') systemdate, name_prefix_accept_yn, name_prefix_reqd_yn,name_suffix_reqd_yn,name_suffix_accept_yn,nvl(name_prefix_prompt,'&nbsp;')name_prefix_prompt, first_name_accept_yn, first_name_reqd_yn, nvl(first_name_prompt,'&nbsp;')first_name_prompt, nvl(name_suffix_prompt,'&nbsp;')name_suffix_prompt,second_name_accept_yn, second_name_reqd_yn, nvl(second_name_prompt,'&nbsp;')second_name_prompt, third_name_accept_yn,  third_name_reqd_yn, nvl(third_name_prompt,'&nbsp;')third_name_prompt, family_name_accept_yn, family_name_reqd_yn,first_name_order, second_name_order, pat_name_as_multipart_yn,third_name_order, names_in_oth_lang_yn, family_name_order, nvl(family_name_prompt,'&nbsp;')family_name_prompt, name_dervn_logic,(AM_OPER_STN_ACCESS_CHECK('"+facilityid+"','"+user_id+"','X','','REGISTER_VISIT_REFERRAL_YN')) OsVal ,NVL(family_name_length,0) family_name_length from mp_param_lang_vw where  language_id='"+locale+"'";
		/*Modified by Rameswar on  19-04-2016 for HSA-CRF-0299*/
		  
              rset = stmt.executeQuery(sqlQuery);
			  if(rset!=null && rset.next())
                {   
                    patient_id_length = rset.getString("patient_id_length");
                    sysdate = rset.getString("systemdate");					
                    name_prefix_accept_yn = rset.getString("name_prefix_accept_yn");
                    name_prefix_reqd_yn = rset.getString("name_prefix_reqd_yn");
                    name_suffix_reqd_yn = rset.getString("name_suffix_reqd_yn");
                    name_suffix_accept_yn = rset.getString("name_suffix_accept_yn");
                    name_prefix_prompt = rset.getString("name_prefix_prompt");
                    first_name_accept_yn = rset.getString("first_name_accept_yn");
                    first_name_reqd_yn = rset.getString("first_name_reqd_yn");
                    first_name_prompt = rset.getString("first_name_prompt");
                    name_suffix_prompt = rset.getString("name_suffix_prompt");
                    second_name_accept_yn = rset.getString("second_name_accept_yn");
                    second_name_reqd_yn = rset.getString("second_name_reqd_yn");
                    second_name_prompt = rset.getString("second_name_prompt");
                    third_name_accept_yn = rset.getString("third_name_accept_yn");
                    third_name_reqd_yn = rset.getString("third_name_reqd_yn");
                    third_name_prompt = rset.getString("third_name_prompt");
                    family_name_accept_yn = rset.getString("family_name_accept_yn");
                    family_name_reqd_yn = rset.getString("family_name_reqd_yn");
                    first_name_order = rset.getString("first_name_order");
                    second_name_order = rset.getString("second_name_order");
                    pat_name_as_multipart_yn = rset.getString("pat_name_as_multipart_yn");
                    third_name_order = rset.getString("third_name_order");
                    names_in_oth_lang_yn = rset.getString("names_in_oth_lang_yn");
                    family_name_order = rset.getString("family_name_order");
                    family_name_prompt = rset.getString("family_name_prompt");
                    name_dervn_logic = rset.getString("name_dervn_logic");
                    OsVal = rset.getString("OsVal")==null?"":rset.getString("OsVal");
					if(pat_name_as_multipart_yn == null) pat_name_as_multipart_yn="N";		
					if(names_in_oth_lang_yn == null) names_in_oth_lang_yn="N";
					family_name_length = rset.getString("family_name_length"); /*Added by Rameswar on  19-04-2016 for HSA-CRF-0299*/
                } 			
					
				 if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5")))		  
					register_visit_referral_yn = "Y";			  
				/*Added by Rameswar on  19-04-2016 for HSA-CRF-0299*/
				if(first_name_accept_yn.equals("N")&&second_name_accept_yn.equals("N")&&third_name_accept_yn.equals("N")&&family_name_accept_yn.equals("Y")){
							fam_name_ind="Y";
							width ="50%";
				}
				
                if(rset!=null) rset.close();
           }catch(Exception e)
           {
               //out.println(e.toString());
			   e.printStackTrace();
           }  

%>
<body OnMouseDown='CodeArrest()' onLoad="disablecol()" onKeyDown = 'lockKey();'>
 <form name="search_form" id="search_form" >

<table  border='0' cellpadding='0' cellspacing='0' width='100%'  align='center'>

<th colspan='4' align='left'><fmt:message key="Common.ReferredFrom.label" bundle="${common_labels}"/></th>
	

	<tr>
    
		<td class='label' width='25%' >&nbsp;<fmt:message key="Common.referraltype.label" bundle="${common_labels}"/></td>
		
		<td class='fields' width='25%' > 
				 <select name="source_type" id="source_type" onChange='populateSource(this);Enabled();'>
				  <option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------
					
				<% if(p_from_ref_type!=null && p_from_ref_type.equalsIgnoreCase("X")) { %>    
				  <option value='L'><fmt:message key="Common.loginfacility.label" bundle="${common_labels}"/>
				  <option value='X' selected><fmt:message key="Common.external.label" bundle="${common_labels}"/> 
				  <option value='E'><fmt:message key="Common.enterprise.label" bundle="${common_labels}"/> 
				<% } else if(p_from_ref_type!=null && p_from_ref_type.equalsIgnoreCase("E")){ %>
				  <option value='L'><fmt:message key="Common.loginfacility.label" bundle="${common_labels}"/>
				  <option value='X'><fmt:message key="Common.external.label" bundle="${common_labels}"/> 
				  <option value='E' selected><fmt:message key="Common.enterprise.label" bundle="${common_labels}"/> 
				<% } else { %>
				  <option value='L'><fmt:message key="Common.loginfacility.label" bundle="${common_labels}"/>
				  <option value='X'><fmt:message key="Common.external.label" bundle="${common_labels}"/> 
				  <option value='E'><fmt:message key="Common.enterprise.label" bundle="${common_labels}"/> 
				<% } %>
			   </select>	
				
				<td class='label' width='25%'   >&nbsp;<fmt:message key="Common.ReferredFrom.label" bundle="${common_labels}"/></td>

				<td class='fields' width='25%'   >
				<input type='text' name='source_display' id='source_display' size='23' maxlength="15" onBlur ='clear_ref1();' ><input type='button' class='button' name='referral_source_lkp_but' id='referral_source_lkp_but' value='?' onClick="referralSourceLookup1(this)"><img src='../../eCommon/images/more.gif' name="lng_name" id="lng_name" align=center style="visibility:hidden"><img id=id2 src='../../eCommon/images/mandatory.gif'  style="visibility : hidden;">
						<input type='hidden' name='referral_source_lkp_bkup_text' id='referral_source_lkp_bkup_text' size='15' maxlength="15" >
						<input type='hidden' name='source' id='source' size='5' maxlength="15" >
		</td>
	</tr>

	<tr>
		<td class='label'  >&nbsp;<fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>

		<td class='fields' >
 				<select name="fm_speciality_code" id="fm_speciality_code" onChange="populateService(this)"> 
				<option value="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
					<%
						sql = " Select Short_Desc,Speciality_Code  from AM_SPECIALITY_LANG_VW where Eff_Status = 'E' and language_id='"+locale+"' order by 1";
						rs = stmt.executeQuery(sql);
						while(rs.next())
						{
			
							out.println("<option value='" + rs.getString("Speciality_Code") + "' >" + rs.getString("Short_Desc")+"</option>");
						}
						if(rs != null) rs.close();
					%>
				  </select>
		</td>
		
		

		<td class='label'  >&nbsp;<fmt:message key="Common.service.label" bundle="${common_labels}"/></td>

		 <td class='fields'   >
			<INPUT TYPE="text" name="fm_service_desc" id="fm_service_desc" onblur="getService1(this,'<%=facilityid%>',fm_service_code)" size=15 maxlength=15 ><input type='button' class='button' id =serv1 name='search_service' id='search_service' value='?' onclick="getService(fm_service_desc,'<%=facilityid%>',fm_service_code)" >
			<input type=hidden name=fm_service_code id=fm_service_code value=''>
			
		</td>
			
	</tr>


	<tr>
        <td class='label'  >&nbsp;<fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td> 

		 <td class='fields'  >
            <select name="referred_from_location_type" id="referred_from_location_type" OnChange='populateLocation(this)'>
            <option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
            </select>
		 </td>
		
		 <td class='label' >&nbsp;<fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>

		 <td class='fields' ><select name="referred_from_location" id="referred_from_location" onChange='populateFmService(this);'>
            <option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------
          </select> 
		</td>
	</tr>

<tr>
	

		<td  class='label'  >&nbsp;<fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		
		<td class='fields'  colspan="1"><input type='text' name='referred_from_practitioner_name' id='referred_from_practitioner_name' size=28 maxlength=30 onchange="disable_criteria_ext_pract(this);" onBlur="getpractval1(search_pract);disable_criteria_ext_pract(this);"><input type='button' class='button' name='search_pract' id='search_pract' value='?' onclick="getpractval(this)" ><input type='hidden' name = 'referred_from_practitioner' id='referred_from_practitioner' value=""> 
		
		<input type='text' name='from_ext_practitioner_id' id='from_ext_practitioner_id'  onchange="disable_criteria_pract(this);" onBlur = "disable_criteria_pract(this);" tabIndex='12' size=30 maxlength=30  style = 'display:none'> </td>

		<td class='label' colspan="2" >&nbsp;</td>
  </tr>

</table>


<table  border='0' cellpadding='0' cellspacing='0' width='100%' align='center' > 
 
  <th colspan='4' align='left' ><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/> </th>
  

	<tr>
      
		<td class='label' width='25%' >&nbsp;<fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td> 	   		
      
		<td class='fields'  width='25%' >
			<select name="to_speciality_code" id="to_speciality_code" onchange="populateService(this)">
			<option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
			<%
					sql = " Select Short_Desc,Speciality_Code  from am_speciality_lang_vw where Eff_Status = 'E' and language_id='"+locale+"' order by 1";
					rs = stmt.executeQuery(sql);
					while(rs.next())
					{
						
						out.println("<option value='" + rs.getString("Speciality_Code") + "' >" + rs.getString("Short_Desc")+"</option>");
					}

					if(rs != null) rs.close();

				 String disval="";
				if ( p_calling_function.equals("OA_MODIFY_APPT")|| p_calling_function.equals("REV_VISIT_DTLS")||p_calling_function.equals("CHG_ADM_DTLS") || ass_func_id.equalsIgnoreCase("REFERAL_REQUIRED")) {
					disval = "disabled";
		         }
					
			%>
				</select>
		 </td>
     		
		 <td class='label' width='25%' >&nbsp;<fmt:message key="Common.service.label" bundle="${common_labels}"/></td>

		 <td class='fields'  width='25%' >
				<INPUT TYPE="text" name="to_service_desc" id="to_service_desc" <%if(ass_func_id.equalsIgnoreCase("REFERAL_REQUIRED")){%>value='<%=p_service_desc%>' disabled<%}%> onblur="getService1(this,'<%=facilityid%>',to_service_code)" size=15 maxlength=15 ><input type='button' class='button'  name='search_service1' id='search_service1' value='?' onclick="getService(to_service_desc,'<%=facilityid%>',to_service_code)"<%if(ass_func_id.equalsIgnoreCase("REFERAL_REQUIRED")){%>disabled<%}%> >
				<input type=hidden name=to_service_code value=''>
		</td>
	</tr>
	<tr>
       
		 <td class='label'   >&nbsp;<fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td> 

        <td class='fields'  >
            <select name="referred_to_location_type" id="referred_to_location_type" onChange='populateRefToLocation(this);' <%=disval%>>
            <option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
           	  <%
			   
				  String selval="selected";
				  if((p_calling_function!=null && p_calling_function.equalsIgnoreCase("OA_BOOK_APPT")||(p_calling_function.equalsIgnoreCase("OP_REG_VISIT")&& (ass_func_id.equalsIgnoreCase("VISIT_REGISTRATION") || ass_func_id.equalsIgnoreCase("REFERAL_REQUIRED") ))||p_calling_function.equalsIgnoreCase("AE_REGISTER_ATTN") || p_calling_function.equalsIgnoreCase("CHG_REG_DTLS") || p_calling_function.equalsIgnoreCase("OA_MODIFY_APPT") || p_calling_function.equalsIgnoreCase("REV_VISIT_DTLS")) ) 
				  {
				      if(p_to_locn_type.equalsIgnoreCase("C"))
				           loc_sql="care_locn_type_ind ='C' and locn_type ='C' ";
					  else if(p_to_locn_type.equalsIgnoreCase("E"))
						   loc_sql="care_locn_type_ind ='E' and locn_type ='E' ";
					  else if(p_to_locn_type.equalsIgnoreCase("D"))
						   loc_sql="care_locn_type_ind ='D' and locn_type ='Y' ";
					  else if(p_calling_function!=null && (p_calling_function.equalsIgnoreCase("OP_REG_VISIT")&& ass_func_id.equalsIgnoreCase("VISIT_REGISTRATION"))) {
				          loc_sql="care_locn_type_ind in ('C','E') and locn_type in ('C','E') ";
				          selval="";
				     }else
						   loc_sql="care_locn_type_ind ='C' and locn_type ='C' ";
					
				    }else if(p_calling_function!=null && (p_calling_function.equalsIgnoreCase("IP_BOOKING") || p_calling_function.equalsIgnoreCase("IP_ADMIT") || p_calling_function.equalsIgnoreCase("CHG_ADM_DTLS"))) {
				        loc_sql="care_locn_type_ind ='N' and locn_type ='N' ";
						if(!p_calling_function.equalsIgnoreCase("CHG_ADM_DTLS"))
   							  selval="";
				   }
				    else if (p_calling_function.equalsIgnoreCase("OA_PENDING_REFERRAL_BOOKING"))
				  {
					loc_sql="care_locn_type_ind in ('C','E','D') and locn_type in ('C','E','Y') ";
		           selval="";
				 }
				 else
		         {
					loc_sql="care_locn_type_ind in ('C','E','D','N','W') and locn_type in ('C','E','Y','N','W') ";
		           selval="";
			   }
			  	if(p_calling_function.equalsIgnoreCase("AE_REGISTER_ATTN") || p_calling_function.equalsIgnoreCase("CHG_REG_DTLS"))
					  selval="";
				try{ 
					  pstmt=con.prepareStatement("select short_desc,locn_type,care_locn_type_ind from am_care_locn_type_lang_vw  where "+loc_sql+" and  SYS_USER_DEF_IND='S' and language_id='"+locale+"' order by short_desc");
					rset=pstmt.executeQuery() ;
					if(rset!=null)
							{
								while(rset.next())
								{
									dat=rset.getString("short_desc");
									id=rset.getString("locn_type");
									careind=rset.getString("care_locn_type_ind");
									%>
										<option value='<%=id%>' <%=selval%> ><%=dat%>
									
									<script>
										careArray[i]="<%=careind%>";
									      i++;
									</script>
									<%
																
								}
							}

							if(pstmt != null) pstmt.close();
							if(rset != null) rset.close();
						}catch(Exception e){/* out.println("Exp in am_care_locn_type list "+ e.toString()); */ e.printStackTrace();}
				%>
				
				</select> 
			</td>


			<td class='label'  >&nbsp;<fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>

			<td class='fields'  ><select name="referred_to_location" id="referred_to_location" onChange='populateToService(this);'>
				<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------
				</select> 
			 </td>
	 </tr> 		

	<tr>
	  
			<td class='label'  >&nbsp;<fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>

			<td class='fields' >
				<input type='text' name='referred_to_practitioner_name' id='referred_to_practitioner_name' size=28 maxlength=30 onBlur="getpractval(search_pract1)"><input type='button' class='button' name='search_pract1' id='search_pract1' value='?' onclick="getpractval(this)" ><input type='hidden' name = 'referred_to_practitioner' value="">
			</td>
			<td class='label' width='25%'  >&nbsp;</td>
			<td class='label' width='25%'  >&nbsp;</td>
	</tr>
	<tr>
		<td colspan='4' class='WHITE'></td>
    </tr>


</table>

<table id=tab1e1 border='0' cellpadding='1' cellspacing='0' width='100%' height='auto' align='center'>
	<tr>
			<td class='label' width='25%' >&nbsp;<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
			</td>

			<td class='fields' width='25%' >
			
			<%if(ca_patient_id.equals("")) {%>
            <input type='text'  name='patient_id'  id='patient_id' value='<%=p_patient_id%>' maxLength='<%=patient_id_length%>' onBlur='javascript:ChangeUpperCase(this);' size='20' onKeypress="return CheckForSpecChars(event);"><input type="button" name="patient_search" id="patient_search" class=BUTTON value="?" onClick="RefCallPatientSearch()" >
			<%}else {%>
			 <input type='text'  name='patient_id' id='patient_id'  value='<%=p_patient_id%>' readonly maxLength='<%=patient_id_length%>' onBlur='javascript:ChangeUpperCase(this);' size='20' onKeypress="return CheckForSpecChars(event);"><input type="button" name="patient_search" id="patient_search" class=BUTTON value="?" disabled onClick="RefCallPatientSearch()" >
			<%}%>
			</td>
			
			<td class='label' width='25%' >&nbsp;<fmt:message key="Common.referralid.label" bundle="${common_labels}"/></td>
			
			<td width='25%' class='fields' ><input type="text" name="referral_id" id="referral_id" size=14 maxLength=14  onBlur='javascript:ChangeUpperCase(this);' value='<%=p_referral_id%>' onKeypress="return CheckForSpecChars(event);">
			</td>
	</tr>

	<tr>
		<td class='label'  >&nbsp;<fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
        
		<td class='fields'  ><select name="priority" id="priority"><option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
		<!--Added by Suji Keerthi for NMC-JD-CRF-0130-->
                               <% if(isReferralPriorityAppl){ 	

								   refPriorityjsonArr = (JSONArray)RefPriorityJson.get("refPriorityArray");
					
								   for(int i = 0 ; i < refPriorityjsonArr.size() ; i++) 
								    {
											 
										JSONObject jsonObj = (JSONObject) refPriorityjsonArr.get(i);
										priority_Code		= checkForNull((String) jsonObj.get("priority_Code"));
										priority_Desc		= checkForNull((String) jsonObj.get("priority_Desc"));
										out.println("<option value='"+priority_Code+"'>"+priority_Desc+"</option>");						
											
										 } }else{%>

						<!--Ended by Suji Keerthi for NMC-JD-CRF-0130-->
             <option value="L"><fmt:message key="Common.elective.label" bundle="${common_labels}"/></option>
		     <option value="E"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
			 <option value="U"><fmt:message key="Common.semiemergency.label" bundle="${common_labels}"/></option>
			 <%} %>		<!--Added by Suji Keerthi for NMC-JD-CRF-0130-->
			</select>	
		 </td> 

		<td class='label' >&nbsp;<fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
         
		<td class='fields' ><select name="status" id="status"><option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
			<option value="O"><fmt:message key="Common.open.label" bundle="${common_labels}"/></option>
            <option value="C"><fmt:message key="Common.closed.label" bundle="${common_labels}"/></option>
			<option value="N"><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></option>
			<option value="D"><fmt:message key="Common.discharged.label" bundle="${common_labels}"/></option>
			<option value="X"><fmt:message key="Common.Rejected.label" bundle="${common_labels}"/></option>
			</select>	
		</td> 

   </tr>

</table> 

	<jsp:include page="../../eMP/jsp/natAltIDComponentCriteria.jsp" flush="true" >
		<jsp:param name ="patient_id"   value= "" />
		<jsp:param name ="alert_reqd_yn"   value= ""  /> 
		<jsp:param name ="nat_id_disabled"  value = "" /> 
		<jsp:param name ="hidetbl"  value = "Y" /> 
	</jsp:include>

<%
    try
    {
           String fname_order="";
		   String sname_order="";
		   String tname_order="";
		   String famly_order="";
		   String fname_prompt="";
		   String sname_prompt="";
		   String tname_prompt="";
		   
		   StringBuffer first_reqd =new StringBuffer();
		   first_reqd.setLength(0);

		   StringBuffer sec_reqd =new StringBuffer();
		   sec_reqd.setLength(0);

		   StringBuffer th_reqd =new StringBuffer();
		   th_reqd.setLength(0);
		   
		   StringBuffer fam_reqd =new StringBuffer();
		   fam_reqd.setLength(0);
		   
		   //Below line added for this incident [61325] 
		   StringBuffer family_name_display =new StringBuffer();
		   family_name_display.setLength(0);
family_name_display.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        //Above line Added this incident [61325] 

			
           StringBuffer mpparamsql = new StringBuffer();			
			
			first_name_disp      = "&nbsp;&nbsp;<input type='text' name='first_name' id='first_name' maxlength='15' size='15' value= '' onblur='ChangeInitCase(this);' ><input type='hidden' class='button' name='b_first' id='b_first' value='?' onclick=\"callSearch(first_name,'first_name_oth_lang','firstname')\" >" ; 
			
			second_name_disp     = "&nbsp;&nbsp;<input type='text' name='second_name' id='second_name' maxlength='15' size='15' value= '' onblur='ChangeInitCase(this);'><input type='hidden' class='button' name='b_second' id='b_second' value='?' onclick=\"callSearch(second_name,'second_name_oth_lang','secondname')\" >" ; 
			third_name_disp      = "&nbsp;&nbsp;<input type='text' name='third_name' id='third_name' maxlength='15' size='15' value= '' onblur='ChangeInitCase(this);' ><input type='hidden' class='button' name='b_third' id='b_third' value='?' onclick=\"callSearch(third_name,'third_name_oth_lang','thirdname')\">" ;  
		
		/*Added by Rameswar on  19-04-2016 for HSA-CRF-0299*/
			if(fam_name_ind.equals("Y")){			
            //Below line modified for this incident [61325] 
			
			family_name_disp     = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+family_name_length+"' value= '' onblur='ChangeInitCase(this);'><input type='hidden' class='button' name='b_family' id='b_family' value='?' onclick=\"callSearch(family_name,'family_name_oth_lang','familyname')\" >" ;
				
			}else{
			if(pat_name_as_multipart_yn.equals("N"))
			{
			family_name_disp     = "&nbsp;&nbsp;<input type='text' name='family_name' id='family_name' maxlength='40' size='40' value= '' onblur='ChangeInitCase(this);'><input type='hidden' class='button' name='b_family' id='b_family' value='?' onclick=\"callSearch(family_name,'family_name_oth_lang','familyname')\" >" ; 
			}
			else
			{
			family_name_disp     = "&nbsp;&nbsp;<input type='text' name='family_name' id='family_name' maxlength='15' size='15' value= '' onblur='ChangeInitCase(this);'><input type='hidden' class='button' name='b_family' id='b_family' value='?' onclick=\"callSearch(family_name,'family_name_oth_lang','familyname')\" >";
			}
			}
		
					
		   if ( first_name_accept_yn.equals("Y") )
			{
				
				if(first_name_reqd_yn.equals("Y"))
					 first_reqd.append("&nbsp;<!--<img src='../../eCommon/images/mandatory.gif'></img>--><input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'> ");
	 
				fname_order=first_name_order;
				if(fname_order == null) fname_order="";
				
				fname_prompt=first_name_prompt;
				if(fname_prompt==null) fname_prompt="";

				if( fname_order.equals("1")  )
				{
					names[0]  = first_name_disp  ;
					name_prompts[0] = fname_prompt+first_reqd.toString() ;
				}
				else if(fname_order.equals("2"))
				{
					names[1]  = first_name_disp  ;
					name_prompts[1] = fname_prompt +first_reqd.toString();
				}
				else if(fname_order.equals("3"))
				{
					names[2]  = first_name_disp  ;
					name_prompts[2] = fname_prompt +first_reqd.toString();
				}
				else
				{
					names[3]  = first_name_disp  ;
					name_prompts[3] = fname_prompt +first_reqd.toString();
				}
           }
            if ( second_name_accept_yn.equals("Y") )
                {
                    
                    if(second_name_reqd_yn.equals("Y"))
                        sec_reqd.append("&nbsp;<!--<img src='../../eCommon/images/mandatory.gif'></img>--><input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'>");
                   sname_order=second_name_order;
				    if(sname_order == null) sname_order="";
					
				   sname_prompt=second_name_prompt;
				    if(sname_prompt == null) sname_prompt ="";

					if( sname_order.equals("1") )
                    {
                        names[0]  =second_name_disp ;
                        name_prompts[0] = sname_prompt+ sec_reqd.toString() ;
                    }
                    else if(sname_order.equals("2"))
                    {
                        names[1]  =second_name_disp ;
                        name_prompts[1] = sname_prompt+sec_reqd.toString() ;
                    }
                    else if(sname_order.equals("3"))
                    {
                        names[2]  =second_name_disp ;
                        name_prompts[2] = sname_prompt + sec_reqd.toString();
                    }
                    else
                    {
                        names[3]  =second_name_disp ;
                        name_prompts[3] = sname_prompt+sec_reqd.toString() ;
                    }
                }

                if ( third_name_accept_yn.equals("Y") )
                {

                   
                        if(third_name_reqd_yn.equals("Y"))
                            th_reqd.append("&nbsp;<!--<img src='../../eCommon/images/mandatory.gif'></img>--><input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'>");

                    tname_order =third_name_order;
					if(tname_order == null) tname_order="";

					tname_prompt=third_name_prompt;
					if(tname_prompt == null) tname_prompt ="";

					if(tname_order.equals("1") )
                    {
                        names[0]  =third_name_disp ;
                        name_prompts[0] = tname_prompt +th_reqd.toString();
                    }
                    else if(tname_order.equals("2"))
                    {
                        names[1]  =third_name_disp ;
                        name_prompts[1] = tname_prompt +th_reqd.toString() ;
                    }
                    else if(tname_order.equals("3"))
                    {
                        names[2]  =third_name_disp ;
                        name_prompts[2] = tname_prompt +th_reqd.toString();
                    }
                    else
                    {
                        names[3]  =third_name_disp ;
                        name_prompts[3] =tname_prompt+th_reqd.toString() ;
                    }
                }
                if ( family_name_accept_yn.equals("Y") )
                {
                    
                        if(family_name_reqd_yn.equals("Y"))
                            fam_reqd.append("&nbsp;<!--<img src='../../eCommon/images/mandatory.gif'></img>--><input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'>");
                            
                    famly_order=family_name_order;
					if(famly_order == null ) famly_order ="";

					if( famly_order.equals("1") )
                    {
                        names[0]  =family_name_disp  ;
						//Below line modified for this incident [61325] 
						if(fam_name_ind.equals("Y")){	
                              name_prompts[0] =family_name_display.toString()+family_name_prompt+fam_reqd.toString();  
						}else{
						      name_prompts[0] =family_name_prompt+fam_reqd.toString();  
						}
						//End 
                    }
                    else if(famly_order.equals("2"))
                    {
                        names[1]  =family_name_disp  ;
						//Below line modified for this incident [61325] 
						if(fam_name_ind.equals("Y")){	
                            name_prompts[1] =family_name_display.toString()+family_name_prompt+fam_reqd.toString() ; 
						}else{
						    name_prompts[1] =family_name_prompt+fam_reqd.toString() ; 
						}
						//End
                    }
                    else if(famly_order.equals("3"))
                    {
                        names[2]  =family_name_disp  ;
						//Below line modified for  this incident [61325] 
						if(fam_name_ind.equals("Y")){	
                            name_prompts[2] =family_name_display.toString()+family_name_prompt +fam_reqd.toString();  
						}else{
						    name_prompts[2] =family_name_prompt +fam_reqd.toString(); 
						}
						//End
                    }
                    else
                    {
                        names[3]  =family_name_disp  ;
						//Below line modified for this incident [61325] 
						if(fam_name_ind.equals("Y")){	
                             name_prompts[3] =family_name_display.toString()+family_name_prompt +fam_reqd.toString() ;  
						}else{
						     name_prompts[3] =family_name_prompt +fam_reqd.toString() ;  
						}
						//End 
                    }
                }
            

	mpparamsql.setLength(0);
%>
        <input type='hidden' name='name_prefix_prompt' id='name_prefix_prompt' value='<%=name_prefix_prompt%>'>
        <input type='hidden' name='first_name_prompt' id='first_name_prompt' value='<%=first_name_prompt%>'>
        <input type='hidden' name='second_name_prompt' id='second_name_prompt' value='<%=second_name_prompt%>'>
        <input type='hidden' name='third_name_prompt' id='third_name_prompt' value='<%=third_name_prompt%>'>
        <input type='hidden' name='family_name_prompt' id='family_name_prompt' value='<%=family_name_prompt%>'>
        <input type='hidden' name='name_suffix_prompt' id='name_suffix_prompt' value='<%=name_suffix_prompt%>'>
        <input type='hidden' name='pat_name_as_multipart_yn' id='pat_name_as_multipart_yn' value="<%=pat_name_as_multipart_yn%>">
        <input type='hidden' name='register_visit_referral_yn' id='register_visit_referral_yn' value="<%=register_visit_referral_yn%>">
		
	<table id='moreCrite2' border='0' cellpadding='0' cellspacing='0' width='100%' height='auto' Style="display:none;visibility:hidden">
        <tr>
            <td colspan=6>
                <table cellpadding=0 cellspacing=0 border=0 width='<%=width%>' height='auto'>
                <tr>
                <%

                    if(name_prefix_accept_yn.equals("Y"))// Thursday, December 24, 2009 17559
                        out.println( "<td class ='label' WIDTH='13%'>&nbsp;"+ name_prefix_prompt );
                    if(name_prefix_reqd_yn.equals("Y"))
                        out.println("&nbsp;<!--<img src='../../eCommon/images/mandatory.gif'></img>--><input type='hidden' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='Y'>") ;
                        out.println("</td> ");
                        for(int i=0; i<name_prompts.length; i++)
                            if(name_prompts[i]!=null)
                            {
                                out.println("<td class ='label'  WIDTH='15%'>&nbsp;"); // Thursday, December 24, 2009 17559
                                out.println(name_prompts[i]) ;
                                out.println ("</td>") ;
                            }
                      if(name_suffix_accept_yn.equals("Y"))// Thursday, December 24, 2009 17559
                        out.println( "<td class ='label'  WIDTH='13%'>&nbsp;"+ name_suffix_prompt );
                      if(name_suffix_reqd_yn.equals("Y"))
                        out.println("&nbsp;<!--<img src='../../eCommon/images/mandatory.gif'></img>--><input type='hidden' name='name_suffix_reqd_yn' id='name_suffix_reqd_yn' value='Y'>") ; 
                      out.println("</td> ") ;
                %> 
           </tr>
           <tr>                            
          
                <%
                  if(name_prefix_accept_yn.equals("Y"))
                    { %><td class='fields' >
                    <%try{    
                            mpparamsql.append("Select Name_Prefix,name_prefix_loc_lang,prefix_sex from Mp_Name_Prefix where eff_status='E' and  trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by 1" );
                            pstmt = con.prepareStatement(mpparamsql.toString());
                            rs = pstmt.executeQuery();
                            
							if(pat_name_as_multipart_yn.equals("N"))
							{
							out.println("&nbsp;<select onchange='' name='name_prefix' id='name_prefix' style='width: 200px' >") ; 
							
                            }
							else
							{
							out.println("&nbsp;<select onchange='' name='name_prefix' id='name_prefix' style='width: 90px' >") ; 
							
							}
							//End of the addition for Prefix Controlling
							%><option value='' >&nbsp- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -&nbsp</option>
                           <% if(rs != null)
                            {
                                    int k=0;
                                    while (rs.next())
                                    {          
                                        out.println ( "<option value=\""+rs.getString("Name_Prefix")+"\">"+rs.getString("Name_Prefix")+"</option>" ) ;
                                       
                                        out.println("<script>NamePrefixArray["+k+"]=\""+rs.getString("Name_Prefix")+"\";");
                                        out.println("PrefixSexArray["+k+"]=\""+rs.getString("prefix_sex")+"\";</script>");
                                        k++;
                                    }
                            }   
                            out.println("</select>") ;
						
						if (rs != null) rs.close();
						if (pstmt != null) pstmt.close();
                        
					   }catch(Exception e) { /* out.println(e.toString()); */ e.printStackTrace();}
                        finally
                        {
                            if (pstmt != null) pstmt.close();
                            if (rs != null) rs.close();
                        } %></td>
                        <%}
                        %>
                   
                            
                    <%
				mpparamsql.setLength(0);
                        for(int i=0; i<names.length; i++)
                        {
                            if(names[i] != null)
                            {
                                out.println("<td  class='fields'   WIDTH='19%' >") ;
                                    out.println(names[i] == null? "&nbsp;":names[i]);
                                out.println("</td>") ;
                            }
                        }
                    %>
                            
                    <td class='fields' >
                        <%
						mpparamsql.setLength(0);
                        if(name_suffix_accept_yn.equals("Y"))
                        {
                            try{                
                                mpparamsql.append("Select Name_Suffix,name_suffix_loc_lang from Mp_Name_Suffix where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by 1");
                                pstmt = con.prepareStatement(mpparamsql.toString());
                                rs = pstmt.executeQuery();

                                out.println("&nbsp;<select onchange='' name='name_suffix' id='name_suffix' >&nbsp;") ; %>
                                <% //out.println("&nbsp;<select onchange='' name='name_suffix' id='name_suffix' onblur='putPatientName(this)' >&nbsp;") ; %>
                                <option value=''>&nbsp- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -&nbsp</option>
                                  <%  if(rs != null)
                                    {
                                        while (rs.next())
                                        {          
                                            out.println ( "<option value=\""+rs.getString("Name_Suffix")+"\">"+rs.getString("Name_Suffix")+"</option>" ) ;
                                        }
                                    }
                                    out.println("</select>") ;
								 if (rs != null) rs.close();
								 if (pstmt != null) pstmt.close();

							mpparamsql.setLength(0);

                            }catch(Exception e) { /* out.println(e.toString()); */e.printStackTrace(); }
                            finally
                            {
								if (rs != null) rs.close();
	 						    if (pstmt != null) pstmt.close();
                            }
                        }
                        %>                              
                    </td>
                </tr>
      </table>

    <%
		if(rset != null) rset.close();		
		%>
</table>
  <table  border='0' cellpadding='0' cellspacing='0' width='100%' align='center' id='MoreCriteria'>
	<tr>
		  <td width='25%'  class='label' >&nbsp;<fmt:message key="eMP.OldReferrals.label" bundle="${mp_labels}"/></td>		 
		  <td width='25%'  class='fields' ><input type='checkbox' name='old_referrals' id='old_referrals' value='N' onClick="oldReferrals(this);"></td>
			<% if(names_in_oth_lang_yn.equals("Y")) { %>
			  <td class='label' width='25%'>&nbsp;<fmt:message key="eMP.SearchNameWithLocalLang.label" bundle="${mp_labels}"/></td>
			  <td class='fields' width='25%'><input type='checkbox' name='local_lang' id='local_lang' value='Y' onClick="localLang(this);" checked></td>
			<% } else { %>
				<td class='label' width='50%'>&nbsp;</td>
			<% } %>	  
		  </tr>

	<!--Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187-->
	<%if(isImproveReferralProcessAppl){%>
	<tr>
		<td width="25%">&nbsp;</td>
		<td class="querydata" width="25%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td class="querydata" width="25%">&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td width="25%">&nbsp;</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.createddate.label" bundle="${common_labels}"/></td>
		
		<td class='fields'><input type=text id='createdfrom' name='created_frm_date' id='created_frm_date' value='<%=current_from_date%>' size="10" maxlength="10" align="center" onblur="validDateObj(this,'DMY',localeName);ComparePeriodCreatedFromToDate(this,created_to_date);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('createdfrom');" style="cursor='hand'"></img>
		
		<td class='fields'>&nbsp;&nbsp;&nbsp;<input type=text id='createdto' name='created_to_date' id='created_to_date' value='<%=current_to_date%>' size="10" maxlength="10" align="center" onblur="validDateObj(this,'DMY',localeName);ComparePeriodCreatedFromToDate(created_frm_date,this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('createdto');" style="cursor='hand'"></img>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/></td>
		
		<td class='fields'><input type=text  id='preffrom' name='pref_frm_date' id='pref_frm_date' value='' size="10" maxlength="10" align="center" onblur="validDateObj(this,'DMY',localeName);ComparePeriodPrefFromToDate(this,pref_to_date);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('preffrom');" style="cursor='hand'"></img>
		
		<td class='fields'>&nbsp;&nbsp;&nbsp;<input type=text id='prefto' name='pref_to_date' id='pref_to_date' value='' size="10" maxlength="10" align="center" onblur="validDateObj(this,'DMY',localeName);ComparePeriodPrefFromToDate(pref_frm_date,this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('prefto');" style="cursor='hand'"></img>
	</tr>
	<%}%>
	<!--End MMS-DM-CRF-0187-->

<tr>
	      <td align='right' colspan='4'>				
	      <%
//(p_calling_function.equalsIgnoreCase("IP_ADMIT") && allow_reg_referral_yn.equals("Y") )  condition modified for MOHE-CRF-0154 by Kamatchi S
if(p_calling_function.equalsIgnoreCase("OA_BOOK_APPT")||(p_calling_function.equalsIgnoreCase("OP_REG_VISIT") && register_visit_referral_yn.equalsIgnoreCase("Y"))|| (p_calling_function.equalsIgnoreCase("IP_ADMIT") && allow_reg_referral_yn.equals("Y") ) ||p_calling_function.equalsIgnoreCase("IP_BOOKING")|| p_calling_function.equalsIgnoreCase("OA_MODIFY_APPT") || p_calling_function.equalsIgnoreCase("AE_REGISTER_ATTN") || p_calling_function.equalsIgnoreCase("CHG_REG_DTLS") || p_calling_function.equalsIgnoreCase("CHG_ADM_DTLS") || p_calling_function.equals("REV_VISIT_DTLS") ) { %><input type='button' class='BUTTON' name='reg_ref' id='reg_ref' value='<fmt:message key="eMP.RegisterPatientReferral.label" bundle="${mp_labels}"/>'  title='Register Referral' onclick="reg_referral()"></input>
                <% } %><input type="button" class=button name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' title='Search' onClick="searching()"></input><input type="button" class=button name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' title='Clear' onClick="ClearSearch('<%=p_calling_function%>');"></input><input type="button" class=button name='mcriteria' id='mcriteria' value='<fmt:message key="Common.morecriteria.label" bundle="${common_labels}"/>' onClick="makeVisible(this);"> <%if(!p_calling_function.equalsIgnoreCase("INDEPENDENT")&&(!p_calling_function.equalsIgnoreCase("REPRINT_REF_LETTER"))) { %><input type='button' class='BUTTON' name='Cancel' id='Cancel' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' title='Closing' onclick="closeWind('<%=p_calling_function%>')"></input>
                <%  } 
			  else if (p_calling_function.equalsIgnoreCase("REPRINT_REF_LETTER")){%><input type='button' class='BUTTON' name='Reprint' id='Reprint' value='<fmt:message key="Common.ReprintAll.label" bundle="${common_labels}"/>' title='Closing' onclick="reprint_all_click()"></input>			  
			  <%}%>
        </td>
      </tr>
  </table> 
           <input type='hidden' name='name_drvn_logic' id='name_drvn_logic' value="<%=name_dervn_logic%>">
            <input type='hidden' name='sysdate' id='sysdate' value="<%=sysdate%>">
            <input type='hidden' name='health_care_setting_type_desc' id='health_care_setting_type_desc' value="">
            <input type='hidden' name='health_care_setting_type' id='health_care_setting_type' value="">
            <input type='hidden' name='open_to_all_pract_yn' id='open_to_all_pract_yn' value="">
            <input type='hidden' name='open_to_all_pract_yn1' id='open_to_all_pract_yn1' value="">
			<input type='hidden' name='calledFrom' id='calledFrom' value="<%=calledFrom%>">
            <input type='hidden' name='p_calling_function' id='p_calling_function' value="<%=p_calling_function%>">
 			<input type='hidden' name='ass_func_id' id='ass_func_id' value="<%=ass_func_id%>">
            <input type='hidden' name='p_select' id='p_select' value="<%=p_select%>">
            <input type='hidden' name='p_reg_patient' id='p_reg_patient' value="<%=p_reg_patient%>">
			<input type='hidden' name='p_res_class' id='p_res_class' value="<%=res_class%>">
            <input type='hidden' name='p_from_ref_code' id='p_from_ref_code' value="<%=p_from_ref_code%>">
            <input type='hidden' name='p_from_locn_type' id='p_from_locn_type' value="<%=p_from_locn_type%>">
            <input type='hidden' name='p_from_locn_code' id='p_from_locn_code' value="<%=p_from_locn_code%>">
            <input type='hidden' name='p_from_pract_id' id='p_from_pract_id' value="<%=p_from_pract_id%>">
            <input type='hidden' name='p_search_speciality_code' id='p_search_speciality_code' value="<%=p_search_speciality_code%>">

			<!--Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187--> 
            <input type='hidden' name='isImproveReferralProcessAppl' id='isImproveReferralProcessAppl' value="<%=isImproveReferralProcessAppl%>">
            <input type='hidden' name='current_from_date' id='current_from_date' value="<%=current_from_date%>">
            <input type='hidden' name='current_to_date' id='current_to_date' value="<%=current_to_date%>">
                
            <input type='hidden' name='p_to_locn_type' id='p_to_locn_type' value="<%=p_to_locn_type%>">
            <input type='hidden' name='p_to_locn_code' id='p_to_locn_code' value="<%=p_to_locn_code%>">
            <input type='hidden' name='p_to_pract_id' id='p_to_pract_id' value="<%=p_to_pract_id%>">
            <input type='hidden' name='pract_id1' id='pract_id1' value="<%=p_to_pract_id%>">
            <input type='hidden' name='pract_name1' id='pract_name1' value="<%=p_to_pract_name%>">
            <input type='hidden' name='facilityid' id='facilityid' value="<%=facilityid%>">
            <input type='hidden' name='to_service_code_search' id='to_service_code_search' value="<%=p_service_code%>">
			<input type='hidden' name='ca_patient_id' id='ca_patient_id' value="<%=ca_patient_id%>">
            <input type='hidden' name='patient_name' id='patient_name' >
				<input type="hidden" name="localeth" id="localeth" value="<%=locale%>">
				<input type="hidden" name="callingMode" id="callingMode" value="<%=callingMode%>">
			
			<!--Added by Santhosh for MMS-DM-CRF-0209.4-US005-->	
			<input type="hidden" name="p_service_desc" id="p_service_desc" value="<%=p_service_desc%>">
 </form>
   <script>populateSource(document.forms[0].source_type);</script> 
   <script>

    if(parent.f_query_add_mod.document.forms[0].patient_id.value != "")
		{
		parent.f_query_add_mod.document.forms[0].patient_id.readonly=true;
		}
 	parent.f_query_add_mod.document.forms[0].to_speciality_code.value="<%=p_search_speciality_code%>";
	   if(parent.f_query_add_mod.document.forms[0].to_speciality_code.value != "")
		{
	   parent.f_query_add_mod.document.forms[0].to_speciality_code.disabled=true;
		}
 </script>
	<%
	 if (p_calling_function.equals("OA_BOOK_APPT")||p_calling_function.equals("OP_REG_VISIT") || p_calling_function.equals("OA_MODIFY_APPT") ||p_calling_function.equals("REV_VISIT_DTLS")||p_calling_function.equals("CHG_ADM_DTLS")) {
	 String oper_stn_id ="";	 
	 String cind="";
	 StringBuffer userOperStnSQL = new StringBuffer();
	  userOperStnSQL.append("SELECT a.oper_stn_id oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE  a.facility_id='"+facilityid+"'  AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id  AND b. appl_user_id ='"+user_id+"'  AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))" );
	  rs = stmt.executeQuery(userOperStnSQL.toString());
		while(rs!=null && rs.next())
		{
			oper_stn_id = rs.getString("oper_stn_id");
		}	 
	    if(rs != null) rs.close();

	  userOperStnSQL.setLength(0);

      if(p_calling_function.equals("OA_BOOK_APPT") || p_calling_function.equals("OA_MODIFY_APPT") || ass_func_id.equalsIgnoreCase("REFERAL_REQUIRED"))
		  {
			 if(p_to_locn_type.equalsIgnoreCase("C"))
				   cind="C";
			 else if(p_to_locn_type.equalsIgnoreCase("E"))
				    cind="E";
			 else if(p_to_locn_type.equalsIgnoreCase("D"))
				    cind="D";
		 }else
		  { 
			   if(ass_func_id.equalsIgnoreCase("PROCD_REGISTRATION"))
			           cind="E";
		        else
					 cind="C";
		  }
	    StringBuffer OPsql= new StringBuffer();  
		if(p_calling_function.equals("CHG_ADM_DTLS")) {
      	OPsql.append("select ip_get_desc.ip_nursing_unit('"+facilityid+"', nursing_unit_code, '"+locale+"', 1) short_desc, nursing_unit_code from IP_NURS_UNIT_FOR_SPECIALTY where facility_id='"+facilityid+"' and SPECIALTY_CODE='"+p_search_speciality_code+"' and nursing_unit_code in (select locn_code from am_locn_for_oper_stn where facility_id = '"+facilityid+"' and oper_stn_id = '"+oper_stn_id+"' and eff_status = 'E' and locn_type = 'N') order by short_desc" );
		} else {
			OPsql.append(" select long_desc,clinic_code,open_to_all_pract_yn from op_clinic where facility_id='"+facilityid+"' and eff_status='E' and level_of_care_ind = 'A' and speciality_code = '"+p_search_speciality_code+"' and (clinic_type,clinic_code) in (select locn_type,locn_code from am_locn_for_oper_stn where facility_id = '"+facilityid+"' and oper_stn_id = '"+oper_stn_id+"' and eff_status = 'E' and locn_type in (select locn_type from am_care_locn_type where care_locn_type_ind = '"+cind+"')) order by short_desc" );
		}
			
		
		rs = stmt.executeQuery(OPsql.toString());		
		
		while(rs!=null && rs.next())
			{
			String short_desc1		 = rs.getString(1);
			String clinic_code		 = rs.getString(2);
			//ass_func_id.equalsIgnoreCase("REFERAL_REQUIRED") ADDED BY SANTHOSH
				if ( p_calling_function.equals("OA_MODIFY_APPT") ||p_calling_function.equals("REV_VISIT_DTLS")||p_calling_function.equals("CHG_ADM_DTLS") || ass_func_id.equalsIgnoreCase("REFERAL_REQUIRED")) {				
				  if(clinic_code.equals(p_to_locn_code)){				
					%>
					<script>			
						var opt=parent.f_query_add_mod.document.createElement("OPTION");
						opt.text="<%=short_desc1%>";
						opt.value="<%=clinic_code%>";
						parent.f_query_add_mod.document.forms[0].referred_to_location.add(opt);				
						opt.selected = true;
						parent.f_query_add_mod.document.forms[0].referred_to_location.disabled = true
					</script>
				  <%
				}
			} else {
				%>
			<script>			
				var opt=parent.f_query_add_mod.document.createElement("OPTION");
				opt.text="<%=short_desc1%>";
				opt.value="<%=clinic_code%>";
				parent.f_query_add_mod.document.forms[0].referred_to_location.add(opt);				
			</script>
	      <%
			}
			}
			 if(rs != null) rs.close();

			 OPsql.setLength(0);

            %>
			<script>
			document.forms[0].search_pract1.disabled=false;
			</script>
	 </body>
	<%
		}
	  first_reqd.setLength(0);
	  sec_reqd.setLength(0);
	  th_reqd.setLength(0);
	  fam_reqd.setLength(0);

    }
    catch(Exception e)
    {
        //out.print(e.toString());
		e.printStackTrace();
    }
    finally
    {
 
        if(pstmt!=null) pstmt.close();
        if(rset!=null)  rset.close();
        if(rs!=null)    rs.close();
     
    }
}
    catch(Exception e)
    {
        //out.print(e.toString());
		e.printStackTrace();
    }
    finally
    {
        if(stmt!=null)  stmt.close();
        ConnectionManager.returnConnection(con,request);
    }
%>
<SCRIPT >
	if(document.forms[0].patient_id.value != "")
	{	
		document.forms[0].patient_id.disabled=true;
		document.forms[0].patient_search.disabled=true;
	}
</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</html>
<%!
public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>

