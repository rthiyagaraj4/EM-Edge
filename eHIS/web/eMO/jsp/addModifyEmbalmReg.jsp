<!DOCTYPE html>
<!--
   
   Developed By : Venkatesh.S
   Date         : 28-Nov-2013    
   Against      : Bru-HIMS-CRF-348 [IN038247] 
 
 -->
 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet, java.util.ArrayList, java.util.HashMap, java.util.StringTokenizer, webbeans.eCommon.ConnectionManager,java.util.*,eBL.Common.*,  eCommon.Common.*, eBL.*" %>


<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
	<%@ include file="../../eMP/jsp/PatientAddressLegends.jsp"%>


 <HTML>
<HTML>
<HEAD>
<% 
		String sStyle	=
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		request.setCharacterEncoding("UTF-8");
		
	
	    Statement	st						=   null;
	    PreparedStatement pstmt				= 	null;
	    ResultSet	rs						=	null;
	    StringBuffer contactAddress 		=  new StringBuffer();
	    StringBuffer displaycontactdet	    =  new StringBuffer();
		ArrayList array_List1	            = new ArrayList();
	    Properties p						= (java.util.Properties) session.getValue("jdbc");
		Connection con						=  ConnectionManager.getConnection(request);
		array_List1							= eMP.ChangePatientDetails.getResultRows(con,"mp_alternate_id_type",p);
		String	facility_id		   		    = (String) session.getValue( "facility_id" ) ;
		String  locale					    = (String)session.getAttribute("LOCALE");
		String patient_length		=   "";
	    String CalledFromFunction	= 	"PatientRegistration";
		String CalledFromFunction1	=  "ChangePatDtls";
		String  or_installyn		=   "";
		String  Patient_ID			=   "";
		String nat_id_prompt        =   "";
		String curr_encounter_id    = "";
		String nat_id_length		="";
      	String srl_no            = "";
		String name_prefix 			="";
		String name_prefix_loc 		="";
		String firs_name            = "";
		String firs_name_loc        = "";
		String name_suffix          = "";
		String name_suffix_loc      ="";
		String family_name          ="";
		String family_name_loc      ="";
		String second_name          ="";
		String second_name_loc      ="";
		String third_name           ="";
		String third_name_loc       ="";
		String sex       			="";
		String dob       			="";
		String applicant_id         ="";
		String mode       		    ="";
		String patient_name_long    ="";
		String patient_name_local    ="";
		String national_id			="";
	    String other_alt_id_type    ="";
	    String other_alt_id         ="";
		String name_dervn_logic_name="";
		String name_dervn_logic_oth_lang=""; 
		String embalm_at_home_yn  	="";
		String embalm_at_hosp_yn  	="";
		String home_embalm_checked_yn 			="";
		
		String home_embalm_enable				="";
		String hosp_embalm_checked_yn 			="";
		
		String hosp_embalm_enable				="";
		String hiv_yn="";
		String hep_yn="";
		String date_of_appliction ="";
		String embalm_pro_date="";
		String from_time="";
		String to_time="";
		String embalm_fluid_qty="";
		String req_addr_line1="";
		String req_addr_line2="";
		String req_addr_line3="";
		String req_addr_line4="";
		String req_town_code="";
		String req_town_desc="";
		String req_area_code="";
		String req_area_desc="";
		String req_region_code="";
		String req_region_desc="";
		String req_postal_code="";
		String req_postal_desc="";
		String country_code="";
		String country_desc="";
		String contact1_no="";
		String contact2_no="";
		String email="";
		String emb_addr_line1="";
		String emb_addr_line2="";
		String emb_addr_line3="";
		String emb_addr_line4="";
		String emb_res_town_code="";
		String emb_res_town_desc="";
		String emb_res_area_code="";
		String emb_res_area_desc="";
		String emb_region_code="";
		String emb_region_desc="";
		String emb_postal_code ="";
		String emb_postal_desc ="";
		String emb_country_code="";
		String emb_country_desc="";
		String embalm_status="";
		String checked_yn="";
		String value ="N";
		String DisplaceOrder = "";
	
		
		//Added for this CRF ML-MMOH-CRF-0860.2	
		Boolean increasedaddressLength = false;
		
 
		try{
		
		  //Added for this CRF ML-MMOH-CRF-0860.2	
	      increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");
		
		
		
		Patient_ID					=   checkForNull(request.getParameter("Patient_ID"));
		 srl_no          		    =   checkForNull(request.getParameter("srl_no"));
		 applicant_id				=   checkForNull(request.getParameter("app_id"));
		 mode						=   checkForNull(request.getParameter("mode"));
         
		
      
		     st	 					=	con.createStatement();
			 rs						=st.executeQuery("select patient_id_length,NAT_ID_PROMPT,NAT_ID_LENGTH,NAME_DERVN_LOGIC,NAME_DERVN_LOGIC_OTH_LANG,(select OPERATIONAL_YN from SM_MODULES_FACILITY where module_id='OR' and FACILITY_ID='"+facility_id+"') OPERATIONAL_YN,(select CURR_ENCOUNTER_ID from mp_patient where DECEASED_YN ='Y'  and patient_id='"+Patient_ID+"') CURR_ENCOUNTER_ID from mp_param");
			
			 if(rs.next()){
		 	  patient_length = checkForNull(rs.getString("patient_id_length"));
			  nat_id_prompt  = checkForNull(rs.getString("NAT_ID_PROMPT"));
              nat_id_length  = checkForNull(rs.getString("NAT_ID_LENGTH"));
              name_dervn_logic_name  = checkForNull(rs.getString("NAME_DERVN_LOGIC"));
              name_dervn_logic_oth_lang = checkForNull(rs.getString("NAME_DERVN_LOGIC_OTH_LANG"));
			  or_installyn		=checkForNull(rs.getString("OPERATIONAL_YN"),"N");
			  curr_encounter_id		=checkForNull(rs.getString("CURR_ENCOUNTER_ID"));
			 }
			
         	 
			 if(mode.equals("modifiy")){

				
			  rs						=st.executeQuery("select REQ_NAME_PREFIX,REQ_NAME_PREFIX_LOC,REQ_NAME_SUFFIX,REQ_NAME_SUFFIX_LOC,REQ_FAMILY_NAME,REQ_FAMILY_NAME_LOC,REQ_FIRST_NAME,REQ_FIRST_NAME_LOC,REQ_SECOND_NAME,REQ_SECOND_NAME_LOC,REQ_THIRD_NAME,REQ_THIRD_NAME_LOC,REQUESTOR_SEX,to_char(REQUESTOR_DOB,'dd/mm/yyyy') DOB,REQ_PATIENT_NAME,REQ_PATIENT_NAME_LOC,REQUESTOR_NAT_ID_NO,REQUESTOR_ALT_ID_TYPE ,REQUESTOR_ALT_ID,EMBALM_AT_HOME_YN,EMBALM_AT_HOSPITAL_YN,HIV_YN,HEP_YN, to_char(EMBALM_REQ_DATE,'dd/mm/yyyy')EMBALM_REQ_DATE,to_char(EMBALM_PROC_DATE,'dd/mm/yyyy')EMBALM_PROC_DATE,to_char(EMBALM_FROM_TIME,'hh24:mi')EMBALM_FROM_TIME, to_char(EMBALM_TO_TIME,'hh24:mi')EMBALM_TO_TIME,EMBALM_FLUID_QTY,REQ_ADDR_LINE1,REQ_ADDR_LINE2,REQ_ADDR_LINE3,REQ_ADDR_LINE4,REQ_TOWN_CODE, mp_get_desc.mp_res_town (REQ_TOWN_CODE, '"+locale+"', '2') REQ_TOWN_DESC,REQ_AREA_CODE,  mp_get_desc.mp_res_area (REQ_AREA_CODE, '"+locale+"', '2') REQ_AREA_DESC,REQ_REGION_CODE, mp_get_desc.mp_region (REQ_REGION_CODE, '"+locale+"', '2') REQ_REGION_DESC,REQ_POSTAL_CODE, mp_get_desc.mp_postal_code (REQ_POSTAL_CODE, '"+locale+"', '2') REQ_POSTAL_DESC,COUNTRY_CODE,mp_get_desc.mp_country (COUNTRY_CODE, '"+locale+"', '2') COUNTRY_DESC,CONTACT1_NO,CONTACT2_NO,EMAIL,EMB_ADDR_LINE1,EMB_ADDR_LINE2,EMB_ADDR_LINE3,EMB_ADDR_LINE4,EMB_RES_TOWN_CODE, mp_get_desc.mp_res_town (EMB_RES_TOWN_CODE, '"+locale+"', '2') EMB_RES_TOWN_DESC,EMB_RES_AREA_CODE,  mp_get_desc.mp_res_area (EMB_RES_AREA_CODE, '"+locale+"', '2') EMB_RES_AREA_DESC,EMB_REGION_CODE,mp_get_desc.mp_region(EMB_REGION_CODE, '"+locale+"', '2') EMB_REGION_DESC, EMB_POSTAL_CODE, mp_get_desc.mp_postal_code(EMB_POSTAL_CODE, '"+locale+"', '2') EMB_POSTAL_DESC, EMB_COUNTRY_CODE, mp_get_desc.mp_country(EMB_COUNTRY_CODE, '"+locale+"', '2') EMB_COUNTRY_DESC ,EMBALM_STATUS from mo_embalm_service where SRL_NO='"+srl_no+"' and facility_id = '"+facility_id+"' ");
			 if(rs.next()){
	          name_prefix		=checkForNull(rs.getString("REQ_NAME_PREFIX"));
			  name_prefix_loc         =checkForNull(rs.getString("REQ_NAME_PREFIX_LOC"));
			  name_suffix          =checkForNull(rs.getString("REQ_NAME_SUFFIX"));
			  name_suffix_loc          =checkForNull(rs.getString("REQ_NAME_SUFFIX_LOC"));
			  family_name            =checkForNull(rs.getString("REQ_FAMILY_NAME"));
			  family_name_loc            =checkForNull(rs.getString("REQ_FAMILY_NAME_LOC"));
			  firs_name         =checkForNull(rs.getString("REQ_FIRST_NAME"));
			  firs_name_loc         =checkForNull(rs.getString("REQ_FIRST_NAME_LOC"));
			  second_name         =checkForNull(rs.getString("REQ_SECOND_NAME"));
			  second_name_loc         =checkForNull(rs.getString("REQ_SECOND_NAME_LOC"));
			  third_name            =checkForNull(rs.getString("REQ_THIRD_NAME"));
			  third_name_loc            =checkForNull(rs.getString("REQ_THIRD_NAME_LOC"));
			   sex            =checkForNull(rs.getString("REQUESTOR_SEX"));
			   dob              =checkForNull(rs.getString("DOB"));
			   patient_name_long              =checkForNull(rs.getString("REQ_PATIENT_NAME"));
			   patient_name_local              =checkForNull(rs.getString("REQ_PATIENT_NAME_LOC"));
			    national_id                   =checkForNull(rs.getString("REQUESTOR_NAT_ID_NO"));
			   other_alt_id_type                  =checkForNull(rs.getString("REQUESTOR_ALT_ID_TYPE"));
			   other_alt_id                 =checkForNull(rs.getString("REQUESTOR_ALT_ID"));
			   embalm_at_home_yn =checkForNull(rs.getString("EMBALM_AT_HOME_YN"));
			   embalm_at_hosp_yn=checkForNull(rs.getString("EMBALM_AT_HOSPITAL_YN"));
			         hiv_yn=checkForNull(rs.getString("HIV_YN"));
			         hep_yn=checkForNull(rs.getString("HEP_YN"));
					 date_of_appliction=checkForNull(rs.getString("EMBALM_REQ_DATE"));
					 embalm_pro_date=checkForNull(rs.getString("EMBALM_PROC_DATE"));
					 from_time=checkForNull(rs.getString("EMBALM_FROM_TIME"));
					 to_time=checkForNull(rs.getString("EMBALM_TO_TIME"));
					 embalm_fluid_qty=checkForNull(rs.getString("EMBALM_FLUID_QTY"));
					 req_addr_line1=checkForNull(rs.getString("REQ_ADDR_LINE1"));
					 req_addr_line2=checkForNull(rs.getString("REQ_ADDR_LINE2"));
					 req_addr_line3=checkForNull(rs.getString("REQ_ADDR_LINE3"));
					 req_addr_line4=checkForNull(rs.getString("REQ_ADDR_LINE4"));
					 req_town_code=checkForNull(rs.getString("REQ_TOWN_CODE"));
					 req_town_desc=checkForNull(rs.getString("REQ_TOWN_DESC"));
					 req_area_code=checkForNull(rs.getString("REQ_AREA_CODE"));
					 req_area_desc=checkForNull(rs.getString("REQ_AREA_DESC"));
					 req_region_code=checkForNull(rs.getString("REQ_REGION_CODE"));
					 req_region_desc=checkForNull(rs.getString("REQ_REGION_DESC"));
					 req_postal_code=checkForNull(rs.getString("REQ_POSTAL_CODE"));
					 req_postal_desc=checkForNull(rs.getString("REQ_POSTAL_DESC"));
					 country_code=checkForNull(rs.getString("COUNTRY_CODE"));
					  country_desc=checkForNull(rs.getString("COUNTRY_DESC"));
					  contact1_no=checkForNull(rs.getString("CONTACT1_NO"));
					  contact2_no=checkForNull(rs.getString("CONTACT2_NO"));
					   email=checkForNull(rs.getString("EMAIL"));
					   emb_addr_line1=checkForNull(rs.getString("EMB_ADDR_LINE1"));
					   emb_addr_line2=checkForNull(rs.getString("EMB_ADDR_LINE2"));
					   emb_addr_line3=checkForNull(rs.getString("EMB_ADDR_LINE3"));
					   emb_addr_line4=checkForNull(rs.getString("EMB_ADDR_LINE4"));
					   emb_res_town_code=checkForNull(rs.getString("EMB_RES_TOWN_CODE"));
					   emb_res_town_desc=checkForNull(rs.getString("EMB_RES_TOWN_DESC"));
					   emb_res_area_code=checkForNull(rs.getString("EMB_RES_AREA_CODE"));
					   emb_res_area_desc=checkForNull(rs.getString("EMB_RES_AREA_DESC"));
					   emb_region_code=checkForNull(rs.getString("EMB_REGION_CODE"));
					   emb_region_desc=checkForNull(rs.getString("EMB_REGION_DESC"));
					   emb_postal_code=checkForNull(rs.getString("EMB_POSTAL_CODE"));
					   emb_postal_desc=checkForNull(rs.getString("EMB_POSTAL_DESC"));
					   emb_country_code=checkForNull(rs.getString("EMB_COUNTRY_CODE"));
					   emb_country_desc=checkForNull(rs.getString("EMB_COUNTRY_DESC"));
					   embalm_status=checkForNull(rs.getString("EMBALM_STATUS"));
				 }
			 
			 }else{
				  DisplaceOrder = "disabled";
			 }
			 
			if (embalm_at_home_yn.equals("Y") && !embalm_at_home_yn.equals("")){
			      home_embalm_checked_yn	="checked";
				  
				  
				  }
			 if(embalm_at_hosp_yn.equals("Y") && !embalm_at_hosp_yn.equals("")){
			       hosp_embalm_checked_yn="checked";
				  
			 }
             if(embalm_status.equals("04"))
              {
			  checked_yn="checked";value="Y";
			  } 			 
                   			 
			 
%> 
        <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	   <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	  <script language='javascript' src='../../eCommon/js/common.js'></script>
	  <script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></script>
	  <script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script> 
	  <script language="javascript" src="../../eCommon/js/DateUtils.js"> </script>
	  <script language='javascript' src='../../eCommon/js/dchk.js'></script>
	  <script language='javascript' src='../../eMO/js/MOEmbalmRegistration.js'></script>
	  <script language='javascript' src='../../eMO/js/PatientRegistration1.js'></script>
	   <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	   <!-- <script language='javascript' src='../../eOA/js/Validate.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
	  
	<style type="text/css">
		table.tblclass td {padding: 3px;}
		table.innertblclass td{padding: 3px; width:10%}
	</style>
	 
</HEAD>
<BODY OnMouseDown="CodeArrest()"  onKeyDown = 'lockKey()'> 
 
  <form name="embalm_details_form" id="embalm_details_form"  method="post" action="../../servlet/eMO.MOEmbalmRegnServlet" target="messageFrame" >

   <table border="0" cellpadding="0" cellspacing="0" align='center' width='100%' class='tblclass'>
        <tr>
		 	<td colspan='4' class='COLUMNHEADER'><fmt:message key="eMO.EmbalmRequestDetails.label" bundle="${mo_labels}"/> </td>
		 </tr>
		   
		<tr> 
		      <td class='label' width='25%' ><fmt:message key="eMO.PatientisHIV.label" bundle="${mo_labels}"/></td>
		        <td class='fields'  width='15%'><INPUT TYPE="checkbox" name="hiv_yn" id="hiv_yn" onClick='validateCheckbox(this)' value="N">
			  </td> 
			  <td class='label'  ><fmt:message key="eMO.EmbalmRequeiredatHospital.label" bundle="${mo_labels}"/></td>
		        <td class='fields'  ><INPUT TYPE="checkbox" name="hospital_embal" id="hospital_embal" onClick='validateCheckbox(this)' value='<%=embalm_at_hosp_yn%>' <%=hosp_embalm_checked_yn%> >
			    </td> 
             
	    </tr>	
		<tr> 
		        <td class='label'  ><fmt:message key="eMO.PatientisHEP.label" bundle="${mo_labels}"/></td>
		        <td class='fields'  ><INPUT TYPE="checkbox" name="hep_yn" id="hep_yn" onClick='validateCheckbox(this)' value="N">
			    </td> 	
				 <td class='label' width='35%'><fmt:message key="eMO.EmbalmRequeiredatHome.label" bundle="${mo_labels}"/></td>		  
		      <td class='fields'  width='25%' ><INPUT TYPE="checkbox" name="home_embal" id="home_embal" onClick='validateCheckbox(this)' value="<%=embalm_at_home_yn%>" <%=home_embalm_checked_yn%>  >
			  </td> 
			  <%if(or_installyn.equals("Y")){%>
	   <tr> 
		        <td class='label'  ></td>
			    <td class='fields'  ></td>
                <td class='label'  ></td>					
		        <td class='fields'  ><input type="button" name="order_button" id="order_button"  class='BUTTON'  <%=DisplaceOrder%> onClick="placeOrder('<%=or_installyn%>','<%=Patient_ID%>','<%=curr_encounter_id%>','<%=facility_id%>');"   value='<fmt:message  key="eOR.PlaceOrders.label" bundle="${or_labels}"/>' >
			    </td> 
	    </tr>	
		<%}%>
		       
		<tr>
		 	   <td colspan='4' class='COLUMNHEADER'><fmt:message key="eMO.EmbalmFromDetails.label" bundle="${mo_labels}"/></td>
		</tr>
		       
		<tr> 
		        <td class='label'  ><fmt:message key="eMO.ApplicantID.label" bundle="${mo_labels}"/></td>
		        <td class='fields'  ><!--<input type=text name='mother_patient_id1' id='mother_patient_id1' value="<%=Patient_ID%>" maxlength="" size='20'> --> 
			   <input type= 'text' id="patient_id" name='requestor_id' id='requestor_id' size='<%=patient_length%>'  maxlength='<%=patient_length%>'  onchange='ChangeUpperCase(this)' onblur='ChangeUpperCase(this); checkPatient(this);' onKeyPress='return CheckForSpecChars(event)' value="" tabIndex='1'><input type='button' name='reqid_buttion' id='reqid_buttion' value='?'  class= "BUTTON" onClick="callpatientsearchapptID(this,'<%= facility_id%>',patient_id);" >
				</td> 	 
                <td class='label'  ><fmt:message key="eMO.DateofApplication.label" bundle="${mo_labels}"/></td>		
		        <td class='fields'  ><input id="" type='text' name='embalm_req_date' id='embalm_req_date' size='10' maxlength='10'  value='<%=date_of_appliction%>' onkeypress="" onblur='validDateObj(this,"DMY",localeName);' onclick=""  ><img src='../../eCommon/images/CommonCalendar.gif' name='nb_calander'  onClick="return showCalendar('embalm_req_date',null,null);" >
			    </td> 
	    </tr>	
		<tr>
				<td colspan='5'><table border='0' class='innertblclass' ><jsp:include page="../../eMP/jsp/PatNamesComp.jsp" >
				<jsp:param name = "flush"        value  = "true" />
				<jsp:param name="CalledFromFunction"  value="IP"/>
				<jsp:param name="populatenewBornDtls"  value="N"/>
				<jsp:param name = "patient_id"    value = "<%=Patient_ID%>"/>				
				</jsp:include>
				</table></td>
		</tr> 
        <tr> 
		        <td class='label'  ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		        <td class='fields'  > <select name="sex" id="sex" onchange='checkPrefix()' tabIndex='27'>
			<option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
			<option value='M' ><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
			<option value='F' ><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
			<option value='U' ><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
			</select>
			    </td> 	 
                <td class='label'  ><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td>		
		        <td class='fields'  ><input type='text' name='requestor_dob' id='requestor_dob' size='10' maxlength='10'  value='' onkeypress="" onblur='validDateObj(this,"DMY",localeName);' ><img src='../../eCommon/images/CommonCalendar.gif' name='nb_calander'  onClick="return showCalendar('requestor_dob',null,null);" >
			    </td> 
	    </tr>
		<tr>    
		        <td class='label'  ><%=nat_id_prompt%></td>
		         <td class='fields'  width='20%'><input type="text" name="national_id_no" id="national_id_no" maxlength='<%=nat_id_length%>' size='<%=nat_id_length%>' tabIndex='32' onblur="" value = ''>
			    </td> 	
                <td class='label'  ><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;<select onchange='enableAltID();' name='other_alt_id' id='other_alt_id' >
				<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</Option>
				<%
				for(int i=0;i<array_List1.size();i+=2) {%>
				 <Option value="<%=(String)array_List1.get(i)%>" ><%=(String)array_List1.get(i+1)%></Option>
				 <%}%>
				</select></td>
		        <td class='fields'  ><input type='text' name='other_alt_Id_text' id='other_alt_Id_text' value='' disabled  maxlength='20' size='20'  >
			    </td>
		</tr> 
		<tr>     <td class='label'  ></td>
		          <td class='label'  ></td>
				   <td class='label'  ></td>
                  <td class='fields'  > <input type="button" name="death_cause" id="death_cause"  class='BUTTON' value='<fmt:message  key="Common.ContactDetails.label" bundle="${common_labels}"/>' onclick="Modal_Contact_Details(this);" ></td>
		</tr>		    
			
		        
		<tr>
		       <td colspan='4' class='COLUMNHEADER'><fmt:message key="eMO.DetailstobeFilledbyMortuaryStaff.label" bundle="${mo_labels}"/></td>
		</tr> 
		         
		<tr> 
		       <td  class='label'><fmt:message key="eMO.DateofEmbalmingProcedure.label" bundle="${mo_labels}"/></td>
			   <td  class='field'><input type='text' name='embalm_proc_date' id='embalm_proc_date' size='10' maxlength='10'  value='<%=embalm_pro_date%>' onkeypress="" onblur='validDateObj(this,"DMY",localeName);' ><img src='../../eCommon/images/CommonCalendar.gif' name='dateof_embalm'  onClick="return showCalendar('embalm_proc_date','','','');" ></td>
			    <td  class='label'nowrap ><fmt:message key="eMO.AmountofEmbalmingluidused.label" bundle="${mo_labels}"/></td>
				<td  class='field'><input id="embalm_fluid" type='text' name='embalm_fluid_qty' id='embalm_fluid_qty' size='4' maxlength='4'  value='<%=embalm_fluid_qty%>' onkeypress='return(ChkNumberInput(this,event,1))' onblur='DeciValidate(this)'>&nbsp;&nbsp;<span class='LABEL'><fmt:message key="eMO.liter.label" bundle="${mo_labels}"/></span></td>
		</tr>
	     <tr> 
		        <td  class='label'><fmt:message key="eMO.TimeofEmbalmingProcedure.label" bundle="${mo_labels}"/></td>
				 <td  class='label'><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input id="from_embalm" type='text' name='embalm_from_time' id='embalm_from_time' size='4' maxlength='5'  value='<%=from_time%>' onkeypress="" onblur="timeValidation(this);Zerocheck(this);" >&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>
				 <input id="to_embalm" type='text' name='embalm_to_time' id='embalm_to_time' size='4' maxlength='5'  value='<%=to_time%>' onkeypress="" onblur="timeValidation(this); Zerocheck(this);" >
				 </td>
		 </tr>
		           <td>&nbsp;</td>
				   <% if(mode.equals("modifiy")){%>
		<tr>
		           <td colspan='4' class='COLUMNHEADER'><fmt:message key="eMO.CancelEmbalm/ReleaseEmbalm.label" bundle="${mo_labels}"/></td>
		</tr> 
				   <td>&nbsp;</td>
				   
	    <tr>
		         <td  class='label'><fmt:message key="eMO.EmbalmCompleted.label" bundle="${mo_labels}"/></td>
				 <td class='fields'  ><INPUT TYPE="checkbox" name="embalmcomplete" id="embalmcomplete" onClick='validateCheckbox(this)' value="<%=value%>" <%=checked_yn%>>
			    </td> 
				 <td  class='label'><fmt:message key="eMO.CancelEmbalm.label" bundle="${mo_labels}"/></td>
				 <td class='fields'  ><INPUT TYPE="checkbox" name="cancelembalm" id="cancelembalm" onClick='validateCheckbox(this)' value="N" >
			    </td> 
	    </tr>
		<tr>
		         <td  class='label'></td>
		         <td class='fields'  >
		         <td  class='label'><fmt:message key="eMO.ReasonforCancellation.label" bundle="${mo_labels}"/></td>
		          <td class='fields'  ><select name="cancelReson" id="cancelReson" onChange=""  disabled>
					<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
					<%   rs						=st.executeQuery("select CONTACT_REASON_CODE,CONTACT_REASON from am_contact_reason  where CANCEL_EMBALM_YN='Y' order by CONTACT_REASON");
					while(rs.next()){%>
	                <option value='<%=rs.getString("CONTACT_REASON_CODE")%>'><%=rs.getString("CONTACT_REASON")%></option>
		            <% }%>
	 				</select></td>
		</tr>
		   <%}%>
   </table>
<input type='hidden' name='patient_name_loc_lang_long' id='patient_name_loc_lang_long' value=''>
<input type='hidden' name='name_drvn_logic_oth_lang' id='name_drvn_logic_oth_lang' value='<%=name_dervn_logic_oth_lang%>'>
<input type='hidden' name='pat_name_as_multipart_yn' id='pat_name_as_multipart_yn' value=''>
<input type='hidden' name='name_drvn_logic' id='name_drvn_logic' value='<%=name_dervn_logic_name%>' > 
<input type='hidden' name='patient_name_loca_long' id='patient_name_loca_long' value=''>
<input type='hidden' name='patient_name' id='patient_name' value=''>
<input type='hidden' name='Patient_ID' id='Patient_ID' value='<%=Patient_ID%>'>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='encounter_id' id='encounter_id' value='<%=curr_encounter_id%>'>
<input type='hidden' name='srl_no' id='srl_no' value='<%=srl_no%>'>

<input type='hidden' name='change_address' id='change_address' value=''>
<input type='hidden' name='concat_address_hidden' id='concat_address_hidden' value=''>		
<input type='hidden' name='concat_NatIdDetails_hidden' id='concat_NatIdDetails_hidden' value=''>		
<input type='hidden' name='addr1_type' id='addr1_type' value=''>
<input type='hidden' name='addr_line1' id='addr_line1' value='' >
<input type='hidden' name='addr_line2' id='addr_line2' value='' >
<input type='hidden' name='addr_line3' id='addr_line3' value='' >
<input type='hidden' name='addr_line4' id='addr_line4' value='' >
<input type='hidden' name='res_town_code' id='res_town_code' value='' >
<input type='hidden' name='res_town_desc' id='res_town_desc' value='' >
<input type='hidden' name='res_area_code' id='res_area_code' value=''>
<input type='hidden' name='res_area_desc' id='res_area_desc' value=''>
<input type='hidden' name='postal_code' id='postal_code' value=''>	
<input type='hidden' name='postals_code' id='postals_code' value=''>	
<input type='hidden' name='region_code' id='region_code' value='' >	
<input type='hidden' name='res_region_code' id='res_region_code' value='' >	
<input type='hidden' name='region_desc' id='region_desc' value='' >	
<input type='hidden' name='country_code' id='country_code' value='' >
<input type='hidden' name='contact1_name' id='contact1_name' value=''>
<input type='hidden' name='invalid1_yn' id='invalid1_yn' value=''>
<input type='hidden' name='addr2_type' id='addr2_type' value=''>
<input type='hidden' name='mail_addr_line1' id='mail_addr_line1' maxlength='30' value=''>
<input type='hidden' name='mail_addr_line2' id='mail_addr_line2' maxlength='30' value=''>
<input type='hidden' name='mail_addr_line3' id='mail_addr_line3' value=''  maxlength='30'>
<input type='hidden' name='mail_addr_line4' id='mail_addr_line4' value='' maxlength='30'>
<input type='hidden' name='mail_res_town_code' id='mail_res_town_code' value='' maxlength='6'>
<input type='hidden' name='mail_res_town_desc' id='mail_res_town_desc' value='' maxlength='6'>
<input type='hidden' name='mail_res_area_code' id='mail_res_area_code' value='' maxlength='6'>
<input type='hidden' name='mail_res_area_desc' id='mail_res_area_desc' value='' maxlength='6'>
<input type='hidden' name='mail_postal_code' id='mail_postal_code' value='' maxlength='8'>
<input type='hidden' name='mail_region_code' id='mail_region_code' value='' maxlength='8'>
<input type='hidden' name='mail_region_desc' id='mail_region_desc' value='' maxlength='8'>
<input type='hidden' name='mail_country_code' id='mail_country_code' value='' maxlength='4'>
<input type='hidden' name='contact2_name' id='contact2_name' value=''>
<input type='hidden' name='invalid2_yn' id='invalid2_yn' value=''>
<input type='hidden' name='country_desc' id='country_desc' value='' maxlength='6'>
<input type='hidden' name='mail_country_desc' id='mail_country_desc' value='' maxlength='6'>
<input type='hidden' name='r_postal_code1' id='r_postal_code1' value='' maxlength='45'>
<input type='hidden' name='m_postal_code12' id='m_postal_code12' value='' maxlength='45'>
<input type='hidden' name='contact1_no' id='contact1_no' value=''>
<input type='hidden' name='contact2_no' id='contact2_no' value=''>
<input type='hidden' name='email' id='email' value=''>
<input type='hidden' name='patient_valuables_rcdby' id='patient_valuables_rcdby' value=''>
<input type='hidden' name='patient_valuables_chkin_dtm' id='patient_valuables_chkin_dtm' value=''>
<input type='hidden' name='patient_valuables_remarks' id='patient_valuables_remarks' value=''> 
<input type='hidden' name='oth_alt_id_type' id='oth_alt_id_type' value=''> 
<input type='hidden' name='oth_alt_id_no' id='oth_alt_id_no' value=''> 



	        <input type='hidden' name='m_town' id='m_town' value=''>
			<input type='hidden' name='r_town' id='r_town' value='' >
			<input type='hidden' name='n_town' id='n_town' value='' >
			<input type='hidden' name='f_town' id='f_town' value='' >
			<input type='hidden' name='e_town' id='e_town' value='' >
			<input type='hidden' name='r_area' id='r_area' value=''>
			<input type='hidden' name='m_area' id='m_area' value=''>
			<input type='hidden' name='n_area' id='n_area' value=''>
			<input type='hidden' name='f_area' id='f_area' value=''>
			<input type='hidden' name='e_area' id='e_area' value=''>
			<input type='hidden' name='r_region' id='r_region' value=''>
			<input type='hidden' name='m_region' id='m_region' value=''>
			<input type='hidden' name='n_region' id='n_region' value=''>
			<input type='hidden' name='f_region' id='f_region' value=''>
			<input type='hidden' name='e_region' id='e_region' value=''>
			

			<!-- added new -->
            <input type='hidden' name='employ_postal_code' id='employ_postal_code' value=''> 
			<input type='hidden' name='m_postal_code' id='m_postal_code' value=''>
			<input type='hidden' name='next_postal_code' id='next_postal_code' value=''>
			<input type='hidden' name='first_postal_code' id='first_postal_code' value=''>
			
			<!--Added for ML-MMOH-CRF-0860.2 -->
           <input type='hidden' name='increasedaddressLength' id='increasedaddressLength' value='<%=increasedaddressLength%>'> 
	
	 
	  <%}catch(Exception e ){
	      
	      e.printStackTrace();
	  }finally{
	   	    if (rs!=null) rs.close();
			if (st!=null) st.close();
	  ConnectionManager.returnConnection(con,request);
	  }%>
	  
	  <SCRIPT>
	   
	  if('<%=mode%>'=='modifiy'){
	   
	   document.forms[0].requestor_id.value='<%=applicant_id%>'
	    
	 if( document.forms[0].name_prefix) { 
	  document.forms[0].name_prefix.value='<%=name_prefix%>'
	  document.forms[0].name_prefix.disabled=true}
	  
	  
	  if( document.forms[0].name_prefix_oth_lang) { 
	  document.forms[0].name_prefix_oth_lang.value='<%=name_prefix_loc%>'
	  document.forms[0].name_prefix_oth_lang.disabled=true
	  }
	  if( document.forms[0].name_suffix) { 
	  document.forms[0].name_suffix.value='<%=name_suffix%>'
	  document.forms[0].name_suffix.disabled=true
	  }
	  
	   if( document.forms[0].name_suffix_oth_lang) { 
	  document.forms[0].name_suffix_oth_lang.value='<%=name_suffix_loc%>'
	  document.forms[0].name_suffix_oth_lang.disabled=true
	  }
	  
	  if( document.forms[0].family_name) { 
	  document.forms[0].family_name.value='<%=family_name%>'
	   document.forms[0].family_name.disabled=true
	  document.forms[0].bfam.disabled=true
	  }

	  if( document.forms[0].family_name_oth_lang) { 
	  document.forms[0].family_name_oth_lang.value='<%=family_name_loc%>'
	  document.forms[0].family_name_oth_lang.disabled=true
	  document.forms[0].bf.disabled=true
	  }

	 if( document.forms[0].first_name){
	   document.forms[0].first_name.value='<%=firs_name%>'
	   document.forms[0].first_name.disabled=true
	   document.forms[0].bf.disabled=true}
	   
	 if( document.forms[0].first_name_oth_lang){
	   document.forms[0].first_name_oth_lang.value='<%=firs_name_loc%>'
	   document.forms[0].first_name_oth_lang.disabled=true
	   document.forms[0].bfo.disabled=true}
	   
	   if( document.forms[0].second_name){
	   document.forms[0].second_name.value='<%=second_name%>'
	   document.forms[0].second_name.disabled=true
	   document.forms[0].bs.disabled=true}
	   
	   if( document.forms[0].second_name_oth_lang){
	   document.forms[0].second_name_oth_lang.value='<%=second_name_loc%>'
	   document.forms[0].second_name_oth_lang.disabled=true
	   document.forms[0].bso.disabled=true}
	   
	    if( document.forms[0].third_name){
	   document.forms[0].third_name.value='<%=third_name%>'
	   document.forms[0].third_name.disabled=true
	   document.forms[0].bt.disabled=true}
	   
	     if( document.forms[0].third_name_oth_lang){
	   document.forms[0].third_name_oth_lang.value='<%=third_name%>'
	   document.forms[0].third_name_oth_lang.disabled=true
	   document.forms[0].bto.disabled=true}
	   
	      if( document.forms[0].sex){
	   document.forms[0].sex.value='<%=sex%>'
	   document.forms[0].sex.disabled=true
	   }
	   
	   if( document.forms[0].requestor_dob){ 
	   document.forms[0].requestor_dob.value='<%=dob%>'
	   document.forms[0].requestor_dob.disabled=true
	   document.forms[0].nb_calander.disabled=true
	   } 
	
	  /*if(document.forms[0].patient_name_long){
	  document.forms[0].patient_name_long.value='<%=patient_name_long%>'
	   } */
	 if(document.forms[0].patient_name_loc_lang_long){
	 document.forms[0].patient_name_loc_lang_long.value='<%=patient_name_local%>'
	 }
	
	if(document.forms[0].national_id_no){
	 document.forms[0].national_id_no.value='<%=national_id%>' 
	 document.forms[0].national_id_no.disabled=true
	 }
	  
	  if(document.forms[0].other_alt_id){
	   var obj1=document.forms[0].other_alt_id.options
		for(var k=0;k<obj1.options.length;k++)
		{        
				if(obj1.options[k].value == '<%=other_alt_id_type%>')
					obj1.options[k].selected = true;
		}
	     document.forms[0].other_alt_id.disabled=true
		}
		
		
	   if(document.forms[0].other_alt_Id_text){
	   document.forms[0].other_alt_Id_text.value='<%=other_alt_id%>'
	   document.forms[0].other_alt_Id_text.disable=true
	   }
	     document.forms[0].patient_name.value='<%=patient_name_long%>'
	     document.forms[0].patient_name_loca_long.value='<%=patient_name_local%>'
		  
		  if(document.forms[0].addr_line1)
		  {
		  document.forms[0].addr_line1.value='<%=req_addr_line1%>'
		  }
		  if(document.forms[0].addr_line2)
		  {
		  document.forms[0].addr_line2.value='<%=req_addr_line2%>'
		  }
		  if(document.forms[0].addr_line3)
		  {
		  document.forms[0].addr_line3.value='<%=req_addr_line3%>'
		  }
		  if(document.forms[0].addr_line4)
		  { 
		  document.forms[0].addr_line4.value='<%=req_addr_line4%>'
		  }
		 
		  
		  document.forms[0].res_town_code.value='<%=req_town_code%>'
		  document.forms[0].res_town_desc.value='<%=req_town_desc%>'
		  
		  document.forms[0].res_area_code.value='<%=req_area_code%>'
		  document.forms[0].res_area_desc.value='<%=req_area_desc%>'
		  
		  document.forms[0].res_region_code.value='<%=req_region_code%>'
		  document.forms[0].region_desc.value='<%=req_region_desc%>'
		  
		  document.forms[0].postal_code.value='<%=req_postal_code%>'
		  document.forms[0].postals_code.value='<%=req_postal_desc%>'
		  document.forms[0].r_postal_code1.value='<%=req_postal_desc%>'
		  
		  document.forms[0].country_code.value='<%=country_code%>'
		  document.forms[0].country_desc.value='<%=country_desc%>'
		  
		  document.forms[0].contact1_no.value='<%=contact1_no%>'
		  document.forms[0].contact2_no.value='<%=contact2_no%>'
		  
		  document.forms[0].email.value='<%=email%>'
		  
		  document.forms[0].mail_addr_line1.value='<%=emb_addr_line1%>'
		  document.forms[0].mail_addr_line2.value='<%=emb_addr_line2%>'
		  document.forms[0].mail_addr_line3.value='<%=emb_addr_line3%>'
		  document.forms[0].mail_addr_line4.value='<%=emb_addr_line4%>'
		  
		  document.forms[0].mail_res_town_code.value='<%=emb_res_town_code%>'
		  document.forms[0].mail_res_town_desc.value='<%=emb_res_town_desc%>'
		  
		  document.forms[0].mail_res_area_code.value='<%=emb_res_area_code%>'
		  document.forms[0].mail_res_area_desc.value='<%=emb_res_area_desc%>'
		  
		  document.forms[0].mail_region_code.value='<%=emb_region_code%>'
		  document.forms[0].mail_region_desc.value='<%=emb_region_desc%>'
		  
		  document.forms[0].mail_postal_code.value='<%=emb_postal_code%>'
		  document.forms[0].m_postal_code12.value='<%=emb_postal_desc%>'
		  
		  document.forms[0].mail_country_code.value='<%=emb_country_code%>'
		  document.forms[0].mail_country_desc.value='<%=emb_country_desc%>'


		  if('<%=hiv_yn%>'=='Y'){ 
		  document.forms[0].hiv_yn.value='<%=hiv_yn%>'
		   document.forms[0].hiv_yn.checked=true
		  } else{ 
		   document.forms[0].hiv_yn.value='N'
		   document.forms[0].hiv_yn.checked=false
		  }
		   if('<%=hep_yn%>'=='Y'){
		  document.forms[0].hep_yn.value='<%=hiv_yn%>'
		  document.forms[0].hep_yn.checked=true
		  }else{ 
		   document.forms[0].hep_yn.value='N'
		   document.forms[0].hep_yn.checked=false
		  }
	    

	}
	   </SCRIPT>
</form>
 </BODY>
</HTML>

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

