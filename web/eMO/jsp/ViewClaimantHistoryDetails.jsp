<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eMP/jsp/PatientAddressLegends.jsp" %>
<html>
<head>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;	
	String flag=""; 
    	 
	 Connection con 					       = null;
	 java.sql.Statement stmt				   = null;
	 ResultSet rs					           = null;
	 ResultSet vrs					           = null;
	 PreparedStatement pstmt                   = null; 
     PreparedStatement pstmt2                   = null; 
	 
try
  { 
     con = ConnectionManager.getConnection(request);
	 Properties p		= (java.util.Properties) session.getValue("jdbc");
	 String locale					= (String)session.getAttribute("LOCALE");
	 String facilityId				        = checkForNull((String)session.getValue("facility_id"));
     String pname ="";
     String patient_employee_id="";
	 String organization_name="";
	 String relationship="";
	 String nat_id_prompt="";
	 String nat_id_length="";
	 String accept_national_id_no_yn="";
	 String kcou="";
	 String res_town_desc="";
     String res_area_desc="";
     String region_desc="";
	 String ocpn_class_desc="";
   		
     String zip_code="";
	 String mlc_yn;
	 String disabledyn="";
	 String res_town_code="";
     String res_area_code="";
     String region_code="";
	 String burial_permit_no="";

	 String release_body_date="";
	 String  released_by="";
	 String  release_pol_id="";
	 String  release_pol_stn_id="";
	 String  release_pol_officer_rank="";
	 String   burial_permit_issued_yn="";
	 String  burial_permit_issue_date="";
	 String  area_code ="";
	 String  bed_no="";
	 String  rfid_tag_no="";
	
	 String unclaimed_body_yn="";
	 String exportation_reqd_yn="";

	 String job_title="";
	 String nat_id_no="";
	 String addrl1="";
	 String addrl2="";
	 String addrl3="";
	 String addrl4="";
	 String country_code="";
      String telephone_off="";
     String telephone_res="";
     String mob_tel_no="";
     String email_id="";
	 String postal_code="";
     
	 String claimant_type_code="";
	 String claimant_type="";
	 String claimant_desc="";
	 String RELEASE_TO_FACILITY	= "";
	 String reason_deceased_desc	= "";
   //  String patient_id="";
	 String name="";
	 String Addr_val = "";
     String reg_no      = checkForNull(request.getParameter("regn_no"));
        	   
        		 if(!(reg_no.equals("")))
        		  {
        			 

        			  pstmt2  = con.prepareStatement("select FACILITY_ID, REGISTRATION_NO, CLAIMANT_TYPE_DESC, CLAIMANT_TYPE_CODE,CLAIMANT_TYPE, CLAIMANT_DESC, RELATIONSHIP, NAME, JOB_TITLE, ADD_LINE1, ADD_LINE2, ADD_LINE3, ADD_LINE4, ZIP_CODE, COUNTRY_CODE, RES_TOWN_CODE, RES_AREA_CODE, REGION_CODE, TELEPHONE_OFF, TELEPHONE_RES, EMAIL_ID, MOB_TEL_NO, NAT_ID_NO,ORGANIZATION_NAME,PATIENT_EMPLOYEE_ID,MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+localeName+"','2') res_town_desc,MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+localeName+"','2') res_area_desc,MP_GET_DESC.MP_REGION(REGION_CODE,'"+localeName+"','2') region_desc, RELEASE_TO_FACILITY,REASON from mo_claimant_vw where  REGISTRATION_NO = ? ");

        			
        			  pstmt2.setString(1,reg_no);
        			  vrs = pstmt2.executeQuery();
        			  while(vrs.next())
        			 {
        			
        			claimant_type=vrs.getString("CLAIMANT_TYPE")==null?"":vrs.getString("CLAIMANT_TYPE"); 
        		    claimant_type_code=vrs.getString("claimant_type_code")==null?"":vrs.getString("claimant_type_code");
        			relationship=vrs.getString("relationship")==null?"":vrs.getString("relationship");
        			name=vrs.getString("name")==null?"":vrs.getString("name");
        			job_title=vrs.getString("job_title")==null?"":vrs.getString("job_title"); 
        			addrl1=vrs.getString("add_line1")==null?"":vrs.getString("add_line1");
        			addrl2=vrs.getString("add_line2")==null?"":vrs.getString("add_line2"); 
        			addrl3=vrs.getString("add_line3")==null?"":vrs.getString("add_line3");
        			addrl4=vrs.getString("add_line4")==null?"":vrs.getString("add_line4");
        			claimant_desc=vrs.getString("CLAIMANT_DESC")==null?"":vrs.getString("CLAIMANT_DESC");
        			postal_code=vrs.getString("zip_code")==null?"":vrs.getString("zip_code");
        			country_code=vrs.getString("country_code")==null?"":vrs.getString("country_code");
        			zip_code=postal_code;
        			res_town_code=vrs.getString("res_town_code")==null?"":vrs.getString("res_town_code"); 
        			res_area_code=vrs.getString("RES_AREA_CODE")==null?"":vrs.getString("RES_AREA_CODE");
        			region_code=vrs.getString("region_code")==null?"":vrs.getString("region_code");
        			res_town_desc=vrs.getString("res_town_desc")==null?"":vrs.getString("res_town_desc"); 
        			res_area_desc=vrs.getString("res_area_desc")==null?"":vrs.getString("res_area_desc");
        			region_desc=vrs.getString("region_desc")==null?"":vrs.getString("region_desc");
        			telephone_off=vrs.getString("telephone_off")==null?"":vrs.getString("telephone_off"); 
        			telephone_res=vrs.getString("telephone_res")==null?"":vrs.getString("telephone_res");
        			email_id=vrs.getString("email_id")==null?"":vrs.getString("email_id");
        			mob_tel_no=vrs.getString("mob_tel_no")==null?"":vrs.getString("mob_tel_no"); 
        			nat_id_no=vrs.getString("nat_id_no")==null?"":vrs.getString("nat_id_no");
        		    organization_name=vrs.getString("organization_name")==null?"":vrs.getString("organization_name");
        		    patient_employee_id=vrs.getString("patient_employee_id")==null?"":vrs.getString("patient_employee_id");
       
     			   RELEASE_TO_FACILITY = vrs.getString("RELEASE_TO_FACILITY")==null?"":vrs.getString("RELEASE_TO_FACILITY");
     			   reason_deceased_desc= vrs.getString("REASON")==null?"":vrs.getString("REASON");
     			 
        	 	 
        		}
        	     if (vrs!=null) vrs.close();
        		 if(pstmt2!=null) pstmt2.close();
        		

        		pstmt2  = con.prepareStatement("select ALT_ID1_TYPE,NAT_ID_PROMPT,ACCEPT_OTH_ALT_ID_YN ,ACCEPT_NATIONAL_ID_NO_YN,NAT_ID_LENGTH from MP_PARAM");
        		vrs = pstmt2.executeQuery();
        	    if(vrs.next())
        		{
        		nat_id_prompt           =vrs.getString("nat_id_prompt")==null?"":vrs.getString("nat_id_prompt");
        		nat_id_length    =vrs.getString("NAT_ID_LENGTH")==null?"":vrs.getString("NAT_ID_LENGTH");
        		accept_national_id_no_yn =vrs.getString("ACCEPT_OTH_ALT_ID_YN")==null?"":vrs.getString("ACCEPT_OTH_ALT_ID_YN");
        		}
        	     if (vrs!=null) vrs.close();
        		 if(pstmt2!=null) pstmt2.close();
        		
        			


        		 
        		  }	 

%>
<body OnMouseDown='CodeArrest()'  onKeyDown="lockKey()" onSelect='codeArrestThruSelect();' >
<form name="viewdetails" id="viewdetails" method="post">
<table cellspacing='0' cellpadding='0' width='100%' border='0' align='center'> 
<tr><td valign=top width='45%'> 
<table cellspacing='0' cellpadding='0' width='100%' border='0' align='center'> 

 <tr>
	       <td class='LABEL' width="20%" ><fmt:message key="eMO.ClaimantType.label" bundle="${mo_labels}"/></td>
			 <td class='querydata' width="30%"><b>
			 <%if(claimant_type.equals("K")){%>
			 <fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/>
			 <%}			
			 else if(claimant_type.equals("E")){%>
			 <fmt:message key="Common.employer.label" bundle="${common_labels}"/>
		     <%}
			else if(claimant_type.equals("M")){%>
			 <fmt:message key="eMO.EmbassyCountry.label" bundle="${mo_labels}"/>
		     <%}
			else if(claimant_type.equals("W")){%>
			 <fmt:message key="eMO.WelfareAssociations.label" bundle="${mo_labels}"/>
		     <%}
		  	else if(claimant_type.equals("R")){%>
		   <fmt:message key="eMO.ReligiousOrgn.label" bundle="${mo_labels}"/>
		     <%}
			else if(claimant_type.equals("U")){%>
		   <fmt:message key="eMO.UnderTaker.label" bundle="${mo_labels}"/>
		     <%}
			 else if(claimant_type.equals("O")){%>
			<fmt:message key="Common.others.label" bundle="${common_labels}"/>
		     <%}
			 else if(claimant_type.equals("F")){%>
		   <fmt:message key="eMO.ReleasedToOtherFacility.label" bundle="${mo_labels}"/>
		     <%}%>

       
   </td></tr>
   <tr><td colspan='4' class='label'>&nbsp;</td></tr>
 <tr><td class='label' width='50%'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
 <td class='querydata' width='50%'><b><%=name%></b></td></tr>
 <tr><td colspan='4' class='label'>&nbsp;</td></tr>
 <tr>  
  <td  class='label'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
	<td class='querydata'><b>
  <% 
	 pstmt2  = con.prepareStatement("select RELATIONSHIP_CODE,SHORT_DESC from MP_RELATIONSHIP_LANG_VW where eff_status='E' and language_id='"+localeName+"' order by 2");
	 vrs = pstmt2.executeQuery();
	 while(vrs.next())
	  {
		 if(vrs.getString("RELATIONSHIP_CODE").equals(relationship))
		  {%>
			 <%=vrs.getString("SHORT_DESC")%> 
			  <%}
	  
	  }
	  if(vrs!=null)vrs.close();
	  if(pstmt!=null)pstmt.close();
	  
	  %></b>
	  
  </td>
  </tr>	
<tr><td colspan='4' class='label'>&nbsp;</td></tr>

	<%	if(accept_national_id_no_yn.equals("Y")){%>

	<tr><td class='label' ><%=nat_id_prompt%></td>
	<td class='querydata'><b><%=nat_id_no%></b>
	</td>
	</tr>	
  <%}else{%>
<input type=hidden name=NAT_ID_NO value="">
	
<%	}%>	

			  <tr><td colspan='4' class='label'>&nbsp;</td></tr>
<tr><td class='label' ><fmt:message key="Common.EmployeeID.label" bundle="${common_labels}"/></td>
<td class='querydata'>   <b><%=patient_employee_id%></b>
</td>
  </tr>	
<tr><td colspan='4' class='label'>&nbsp;</td></tr>
<tr><td class='label' ><fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/></td>
<td class='querydata'><b><%=job_title%></b></td>
  </tr>	
<tr><td colspan='4' class='label'>&nbsp;</td></tr>
<tr><td class='label' ><fmt:message key="Common.orgName.label" bundle="${common_labels}"/></td>
<td class='querydata'><b><%=organization_name%></b></td>
</tr>
<tr><td colspan='4' class='label'>&nbsp;</td></tr>
<%if(!ocpn_class_desc.equals("")){%>
	
<tr><td class='label' id='hed1'  ><fmt:message key="eMP.OccupationClass.label" bundle="${mp_labels}"/></td>
<td class='querydata'><label id=ocpnlab class='label'><b><%=ocpn_class_desc%></b></td>
</tr>
<%}else{%>
<tr><td  class='label' id='hed1'  ></td>
<td class='querydata'><label id=ocpnlab></td>
</tr>
<%}%>
<%
String fac_name	= "";
if(claimant_type.equals("F")){
pstmt2  = con.prepareStatement("select b.FACILITY_ID facility_id ,a.FACILITY_NAME facility_name from SM_FACILITY_PARAM a,sm_modules_facility b where a.facility_id = b.facility_id and b.module_id = 'MO' and b.FACILITY_ID='"+RELEASE_TO_FACILITY+"' order by 2");
	
	
	vrs = pstmt2.executeQuery();
	 if(vrs.next()){
		 fac_name	=  vrs.getString("facility_name");
	 }
	%>
	<tr><td colspan='4' class='label'>&nbsp;</td></tr>
	<tr>
		<td class='label' ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>&nbsp;
		<td  class='querydata'><%=fac_name%></td>
	</tr>
	<tr><td colspan='4' class='label'>&nbsp;</td></tr>
	<tr>
		<td class="label"  ><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>&nbsp;
		<td  class='querydata' ><%=reason_deceased_desc%></td>
	</tr>
<%} %>
  </table>
		   </td>  
			  <td width='55%'><table cellspacing='0' cellpadding='0' border='0' width='100%'  >
			  <tr>
			  <td class='LABEL' width='25%'><fmt:message key="eMO.Claimant.label" bundle="${mo_labels}"/></td>
   <td class='querydata' width="25%"><b><%=claimant_desc%></b></td></tr>
   <tr><td colspan='4' class='label'>&nbsp;</td></tr>

				<%
      
ArrayList contact_addr= fetchContactAddresses(con,out,"parent.parent.messageFrame",p) ;
String[]	contact_col_names		        = (String[])contact_addr.get(1) ;
String[]	 contact_prompts			    = (String[])contact_addr.get(2) ;
//String[]  contact_fields					= (String[])contact_addr.get(3) ;
 contact_addr				    = null;
 

/* code for displaying address fields and postal code*/
 int tabIndex		            = 1;

		tabIndex++;
		out.println("<tr>") ; 
//		StringBuffer sb2 = new StringBuffer() ;
//		StringBuffer sb12 = new StringBuffer() ;
//		StringBuffer sba2 = new StringBuffer() ;
//		StringBuffer sbar2 = new StringBuffer();
 //       StringBuffer fieldVal2 = new StringBuffer("");
        for(int i=0;i<contact_col_names.length; i++)
	  {
			out.println("<tr>") ;
            out.println("<td class='label' width='24%' >"+contact_prompts[i]+"&nbsp;</td>") ;
            if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
                Addr_val = addrl1;
            else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
                Addr_val = addrl2;
            else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
                Addr_val = addrl3;
            else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
                Addr_val = addrl4;
            else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
                Addr_val = res_area_desc;
            else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
                Addr_val = res_town_desc;
			else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
                Addr_val = region_desc;
            else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
                Addr_val = postal_code;
            out.println("<td   class='querydata' width='24%'><b>"+Addr_val+"</b></td>") ;
        out.println("</tr>") ;
		out.println("<tr><td colspan='4' class='label'>&nbsp;</td></tr>");
	  }
                   %>
		  
	 <%	 
		String sq3 = "select short_name from MP_COUNTRY_LANG_VW  where LANGUAGE_ID='"+localeName+"' and country_code = '"+country_code+"'";

		pstmt2  = con.prepareStatement(sq3);
        vrs = pstmt2.executeQuery();
        
		
		while( vrs.next())
		{
			kcou=checkForNull(vrs.getString("short_name"));
		
	//	}     


}

   %>	
  
			  <tr><td colspan='4' class='label'>&nbsp;</td></tr>
      	    <tr>
		  <td  class='label'><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
         <td class='querydata' ><b><%=kcou%></td>
          </tr>
		  <tr><td colspan='4' class='label'>&nbsp;</td></tr>
          <tr>
              <td  class='label'><fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/></td>
              <td class='querydata'><b><%=telephone_res%></b></td>
		  </tr>
		  <tr><td colspan='4' class='label'>&nbsp;</td></tr>
          <tr>
              <td  class='label' ><fmt:message key="eMO.MobilePhoneNo.label" bundle="${mo_labels}"/></td>
              <td class='querydata'><b><%=mob_tel_no%></b></td></tr>
			  <tr><td colspan='4' class='label'>&nbsp;</td></tr>
		  <tr>
			  <td  class='label'><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td>
              <td class='querydata'><b><%=telephone_off%></b></td>
          </tr>
		  <tr><td colspan='4' class='label'>&nbsp;</td></tr>
		  <tr>
		      <td class='label'><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>
              <td class='querydata'><b><%=email_id%></b></td>
          </tr></td></tr>
		 </table>
  </table>
<input type='hidden' name='mode' id='mode' value='viewdata'>

</form>
<%		
 }	

    catch(Exception e)
    {
       e.printStackTrace();

    }
    finally
    {
       
	 ConnectionManager.returnConnection(con,request);
    }
%>



</body>
</html>
<%!
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}
%>

