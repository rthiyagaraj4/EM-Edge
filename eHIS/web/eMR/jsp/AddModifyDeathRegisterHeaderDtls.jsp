<!DOCTYPE html>
<%
/*
	Modifining the Practitioner and Certified practitioner,designation etc are modified in Header Section.
*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.util.StringTokenizer,java.util.HashMap,java.util.ArrayList,eCommon.XSSRequestWrapper" %>
<% 
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");	


	Properties p			= (java.util.Properties) session.getValue( "jdbc" );
	String sStyle			=  checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String login_user	= p.getProperty( "login_user" ) ;
	String facilityId		= ((String)session.getValue("facility_id"));
	String locale			= ((String)session.getAttribute("LOCALE"));


	String patient_id				=	checkForNull(request.getParameter("patient_id"));
	String encounter_id			=	checkForNull(request.getParameter("encounter_id"));
	String locn_code				=	checkForNull(request.getParameter("Locn_Code"));
	String gender	 					=	checkForNull(request.getParameter("gender"));
	String dob							=	checkForNull(	request.getParameter("Dob"));
	String speciality_code		=	checkForNull(request.getParameter("speciality_code"));
	String episode_id				=	checkForNull(request.getParameter("episode_id"));
	String attnd_pract_id		=	checkForNull(request.getParameter("practitioner_id"));
	String practitioner_type	=	checkForNull(request.getParameter("practitioner_type"));
	String patient_class			=	checkForNull(request.getParameter("patient_class"));
	String call_from					=	checkForNull(request.getParameter("call_from"));
	String episode_type			=	checkForNull(request.getParameter("episode_type"));
	String mode						=	checkForNull(request.getParameter("mode"));
	String brought_dead_YN	=	checkForNull(request.getParameter("brought_dead_YN"));
	String deceased_dt_time	=	checkForNull(request.getParameter("deceased_dt_time"));
	String finalize_yn				=	checkForNull(request.getParameter("finalize_yn"));
	String visit_adm_date		=	checkForNull(request.getParameter("visit_adm_date"));

	String certify_pract_id		="";
	String certify_pract_name	="";
	String certify_citizen_id	="";
	String certify_designation	="";
	String certify_registr_no	="";
	String attend_pract_name	="";
	String hide_LOS				="";
	String disp_LOS				="";
	String LOS_day					="";
	String LOS_day_disable	="";
	String chk_yn					="";
	String length_of_stay		="";
//	String finalize_yn				="";
	HashMap addl_fields_map=new HashMap();
/* 	Added by Ajay Hatwate for AAKH-CRF-0179 on 07/08/2023 */
	Boolean isDeathRegisterFormAppl = false;
	String enable_death_reg_form = "N";
	String death_reg_form_accession_num = "";

try{
	conn=ConnectionManager.getConnection(request);
	boolean isMMCLblchngesAppl  = eCommon.Common.CommonBean.isSiteSpecific(conn, "AM","AM_MMCNO_LBL_APPL_YN");//Added By Dharma on 23rd Dec 2019 against  ML-MMOH-CRF-1488
	isDeathRegisterFormAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "AE","DEATH_REGISTER_FORM_APPL");//Added by Ajay Hatwate for AAKH-CRF-0179 on 08-08-2023
	if(isDeathRegisterFormAppl){
		enable_death_reg_form = eMP.MPCommonBean.getEnableDeathRegisterFormYN(conn);
	}
	/* End of AAKH-CRF-0179 */
	/*FYI:Adding of the Coustamization fields form MR paramerer.*/
	String MR_PARAM_ADDLFLDS_SQL="SELECT 'ADDL_FIELD1' FIELD_NAME,ADDL_FIELD1_PROMPT PROMPT, ADDL_FIELD1_LENGTH LENGTH, ADDL_FIELD1_SECTION SECTION FROM   MR_PARAMETER A UNION SELECT 'ADDL_FIELD2' FIELD_NAME,ADDL_FIELD2_PROMPT, ADDL_FIELD2_LENGTH, ADDL_FIELD2_SECTION FROM   MR_PARAMETER B UNION SELECT 'ADDL_FIELD3' FIELD_NAME,ADDL_FIELD3_PROMPT, ADDL_FIELD3_LENGTH, ADDL_FIELD3_SECTION FROM   MR_PARAMETER C UNION SELECT 'ADDL_FIELD4' FIELD_NAME,ADDL_FIELD4_PROMPT, ADDL_FIELD4_LENGTH, ADDL_FIELD4_SECTION FROM MR_PARAMETER D UNION SELECT 'ADDL_FIELD5' FIELD_NAME,ADDL_FIELD5_PROMPT, ADDL_FIELD5_LENGTH, ADDL_FIELD5_SECTION FROM   MR_PARAMETER E ";

//	visit_adm_date	 =DateUtils.convertDate(visit_adm_date,"DMYHM",locale,"en");
//	out.println("visit_adm_date=1==>" +visit_adm_date);


	String PAT_DTLS_SQL="SELECT A.ATTEND_PRACTITIONER_ID,A.AUTH_PRACTITIONER_ID,A.BROUGHT_DEAD_YN,A.NATIONAL_ID_NO,A.FINALIZE_YN, A.PRACT_REG_NO,B.POSITION_DESC,TO_CHAR(A.DEATH_DATE_TIME,'DD/MM/YYYY HH24:MI')DEATH_DATE_TIME,AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,?,'1') ATTEND_PRACT_NAME,AM_GET_DESC.AM_PRACTITIONER(A.AUTH_PRACTITIONER_ID,?,'1') AUTH_PRACT_NAME,ADDL_FIELD1, ADDL_FIELD2, ADDL_FIELD3, ADDL_FIELD4, ADDL_FIELD5,MP_CALCULATE_AGE_YMD(to_date(?,'dd/mm/yyyy hh24:mi'),'YMDH',A.DEATH_DATE_TIME,'Y')LENGTH_OF_STAY, C.DEATH_REG_FORM_ACCESSION_NUM FROM MR_DEATH_REGISTER_HDR A,AM_PRACTITIONER_LANG_VW B,PR_ENCOUNTER C WHERE A.PATIENT_ID =? AND A.ENCOUNTER_ID =? AND A.FACILITY_ID =? AND A.AUTH_PRACTITIONER_ID = B.PRACTITIONER_ID(+) AND (LANGUAGE_ID=? or A.AUTH_PRACTITIONER_ID IS NULL)  AND A.FACILITY_ID = C.FACILITY_ID AND A.ENCOUNTER_ID=C.ENCOUNTER_ID";
		pstmt=conn.prepareStatement(PAT_DTLS_SQL);
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,visit_adm_date);
		pstmt.setString(4,patient_id);
		pstmt.setString(5,encounter_id);
		pstmt.setString(6,facilityId);
		pstmt.setString(7,locale);
		rs=pstmt.executeQuery();
		while(rs.next()){
			certify_pract_id		=	checkForNull(rs.getString("AUTH_PRACTITIONER_ID"));//AUTH_PRACTITIONER_ID is nothing but Certified practiotioner.
			certify_pract_name	=	checkForNull(rs.getString("AUTH_PRACT_NAME"));
			certify_citizen_id		=	checkForNull(rs.getString("NATIONAL_ID_NO"));
			certify_designation	=	checkForNull(rs.getString("POSITION_DESC"));
			certify_registr_no		=	checkForNull(rs.getString("PRACT_REG_NO"));
			attend_pract_name	=	checkForNull(rs.getString("ATTEND_PRACT_NAME"));
			attnd_pract_id			=	checkForNull(rs.getString("ATTEND_PRACTITIONER_ID"));
			brought_dead_YN	=	checkForNull(rs.getString("BROUGHT_DEAD_YN"),"N");
			addl_fields_map.put("ADDL_FIELD1",checkForNull(rs.getString("ADDL_FIELD1")));
			addl_fields_map.put("ADDL_FIELD2",checkForNull(rs.getString("ADDL_FIELD2")));
			addl_fields_map.put("ADDL_FIELD3",checkForNull(rs.getString("ADDL_FIELD3")));
			addl_fields_map.put("ADDL_FIELD4",checkForNull(rs.getString("ADDL_FIELD4")));
			addl_fields_map.put("ADDL_FIELD5",checkForNull(rs.getString("ADDL_FIELD5")));
			deceased_dt_time		=	DateUtils.convertDate(rs.getString("DEATH_DATE_TIME"),"DMYHM" ,"en",locale);
			length_of_stay				=	rs.getString("LENGTH_OF_STAY");
			if(enable_death_reg_form.equals("Y")){
				death_reg_form_accession_num				=	checkForNull(rs.getString("DEATH_REG_FORM_ACCESSION_NUM"));
			}
			
		}
			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();

		if(certify_pract_id.equals("")){
			String func_role_id =""; 
			String FUNC_ROLE_SQL	 =	"SELECT FUNC_ROLE,FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID='"+login_user+"'";
			pstmt  = conn.prepareStatement(FUNC_ROLE_SQL);
			rs		  = pstmt.executeQuery();
			while(rs.next()){
				func_role_id=checkForNull(rs.getString("FUNC_ROLE_ID"));
			}
			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();
			if(!func_role_id.equals("")){
				String CERITIFY_PRACT_SQL="SELECT PRACTITIONER_ID, PRACTITIONER_NAME,NATIONAL_ID_NUM, POSITION_DESC, APC_NO FROM AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID='"+func_role_id+"' AND LANGUAGE_ID='"+locale+"' " ;
				pstmt=conn.prepareStatement(CERITIFY_PRACT_SQL);
				rs=pstmt.executeQuery();
				while(rs.next()){
					certify_pract_id		=	checkForNull(rs.getString("PRACTITIONER_ID"));
					certify_pract_name	=	checkForNull(rs.getString("PRACTITIONER_NAME"));
					certify_citizen_id		=	checkForNull(rs.getString("NATIONAL_ID_NUM"));
					certify_designation	=	checkForNull(rs.getString("POSITION_DESC"));
					certify_registr_no		=	checkForNull(rs.getString("APC_NO"));
	//				attend_pract_name	=	checkForNull(rs.getString("ATTEND_PRACT_NAME"));
				}
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();
			}
		}
		String [] str_ary=length_of_stay.split(" ");
		String year=""; 
		String month=""; 
		String day=""; 
		String hours=""; 
		/*
			FYI:1.To paint Y(year) value,M(month)value,D(day)Value and Hrs value the below code works in the same way.
		*/
		for (String item : str_ary){
				  if(item.endsWith("Y")){
					  year=item.substring(0,item.lastIndexOf('Y'));
				  }else if(item.endsWith("M")){
					  month=item.substring(0,item.lastIndexOf('M'));
				  }else if(item.endsWith("D")){
					  day=item.substring(0,item.lastIndexOf('D'));
				  }else if(item.endsWith("H")){
					  hours=item.substring(0,item.lastIndexOf('H'));
				  }
			  }
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();

	if(brought_dead_YN.equals("Y")){
			chk_yn="checked";
			hide_LOS="hidden";
			disp_LOS="none";
			LOS_day	="0";
			LOS_day_disable="disabled";
	}else{
			chk_yn="";
			hide_LOS="visible";
			disp_LOS="inline";
			LOS_day=day;
	}




%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script language='javascript' src='../../eCommon/js/dchk.js' ></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
		<script src='../../eCommon/js/dchk.js' language='javascript'></script>
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language='javascript' src="../../eMR/js/DeathRegister.js"></script>
		<script src='../../eMR/js/MRPractitionerComponent.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


  


	</head>
	<body onload="diableFilelds()">
		<form name="DR_HeaderDtls_Form" id="DR_HeaderDtls_Form">
			<table width='100%' cellpadding='1' cellspacing='0' border='0'>
					<tr>
						<td colspan="4" class='PANELTOOLBAR' id="Diag_icon"><fmt:message key="eMR.headersection.label" bundle="${mr_labels}"/></td>
					</tr>
					<tr></tr>	
					<tr>
						<td class='label' width='20%' nowrap><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></td>
						<td class="fields" width='25%'><input type="text" size="18" maxlength="18" name="attend_pract_name" id="attend_pract_name" value="<%=attend_pract_name%>" onblur="if(this.value!=''){getPractitionerId(document.forms[0].attend_pract,this)}"/><input type="hidden" name="attend_pract_hidden" id="attend_pract_hidden" value="<%=attend_pract_name%>"/><input type="hidden" name="attend_pract" id="attend_pract" value="<%=attnd_pract_id%>"/><input type="button" name="attn_pract_lokp" id="attn_pract_lokp" onclick="getPractitionerId(document.forms[0].attend_pract,document.forms[0].attend_pract_name)" value="?" /><img  src='../../eCommon/images/mandatory.gif'></td>
						<td class='label' width='20%' nowrap><fmt:message key="eMR.ceritifiedpractitioner.label" bundle="${mr_labels}"/></td>
						<td class="fields" width='35%'><input type="text" size="18" maxlength="18" name="certify_pract_name" id="certify_pract_name" value="<%=certify_pract_name%>" onblur="if(this.value!=''){getPractitionerId(document.forms[0].certify_pract,this)}else{clearValues();}"/><input type="hidden" name="certify_pract_hidden" id="certify_pract_hidden" value="<%=certify_pract_name%>"/><input type="hidden"  name="certify_pract" id="certify_pract" value="<%=certify_pract_id%>"/><input type="button" name="certify_pract_lokp" id="certify_pract_lokp" onclick="getPractitionerId(document.forms[0].certify_pract,document.forms[0].certify_pract_name)"  value="?" /><img  src='../../eCommon/images/mandatory.gif'></td>
					</tr>
					<tr>
						<td class='label' nowrap><fmt:message key="Common.designation.label" bundle="${common_labels}"/></td>
						<td class="fields" ><input type="text" size="25" maxlength="25" name="designation" id="designation" value="<%=certify_designation%>" readonly/></td>			
						<td class='label' nowrap><fmt:message key="Common.citizen.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.identification.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eMR.Number.label" bundle="${mr_labels}"/></td>
						<td class='fields' ><input type='text' size='20' maxlength='20' name='citizen_id_num' id='citizen_id_num' value="<%=certify_citizen_id%>" readonly/></td>
					</tr>
					<tr>
						<td class='label' nowrap >
						<%if(isMMCLblchngesAppl){ %>
							<fmt:message key="eAM.MMCNO.label" bundle="${am_labels}"/>
						<%}else{ %>
							<fmt:message key="Common.registrationno.label" bundle="${common_labels}"/>
						<%} %>
						
						</td>
						<td class="fields" ><input type="text" size="18" maxlength="18" name="registration_no" id="registration_no" value="<%=certify_registr_no%>" readonly/></td>			
						<td class='label' nowrap><fmt:message key="Common.broughtindead.label" bundle="${common_labels}"/></td>
						<td class="fields" ><input type="checkbox"  name="brought_in_dead" id="brought_in_dead" <%=chk_yn%> value="<%=brought_dead_YN%>" onclick="validateLOS(this)" disabled/></td>
					</tr>
					<tr>
						<td class='label' nowrap><fmt:message key="eMR.lengthofstay.label" bundle="${mr_labels}"/></td>
						<td class="fields" >
							<input type="text" id="id_year" size="2" maxlength="2" name="year" id="year" value="<%=year%>" style="display:<%=disp_LOS%>"readonly/><span id='leng_year' style="display:<%=disp_LOS%>"><fmt:message key="eMR.Y.label" bundle="${mr_labels}"/></span>
							<input type="text" id="id_month" size="2" maxlength="2" name="month" id="month" value="<%=month%>"   style="display:<%=disp_LOS%>" readonly/><span id='leng_mon' style="display:<%=disp_LOS%>"><fmt:message key="eMR.M.label" bundle="${mr_labels}" /></span>
							<input type="text" id="id_day" size="2" maxlength="2" name="day" id="day" value="<%=LOS_day%>" <%=LOS_day_disable%> readonly /><span id='leng_day' ><fmt:message key="eMR.D.label" bundle="${mr_labels}" /></span>
							<input type="text" id="id_hrs" size="2" maxlength="2" name="hours" id="hours" value="<%=hours%>"  style="display:<%=disp_LOS%>" readonly /><span id='leng_hrs'  style="display:<%=disp_LOS%>"><fmt:message key="Common.Hrs.label" bundle="${common_labels}"/></span>
						</td>			
						<td class='label' nowrap><fmt:message key="Common.deceaseddatetime.label" bundle="${common_labels}"/></td>
						<td class="fields"><input type="text" size="18" maxlength="18" name="deceased_date_time" id="deceased_date_time" value="<%=deceased_dt_time%>" readonly/>
						<% if(isDeathRegisterFormAppl && enable_death_reg_form.equals("Y") && !death_reg_form_accession_num.equals("")){ %>
							<a href="javascript:getDeathRegFormAccessionNum('<%=patient_id %>', '<%=encounter_id %>','','<%=visit_adm_date %>','<%=patient_class %>','<%=speciality_code %>','','<%=death_reg_form_accession_num %>','');" id='deathRegFormLink'><fmt:message key="Common.DeathRegForm.label" bundle="${common_labels}"/></a>					
						<%} %>
						</td>
					</tr>
				<%
			/*FYI: 
				1.Quering for addl fields which are assigned to Header section For MR_HDR Table.
				2.Putting the addl fields in map to get values assigned for Header Section.For MR_HDR Table.
				3.Because in HDR table all 5 addlfields can have Header Section Values,MLC,Remarks and Female Status section.
				4.The same logic will be applied to in AddModifyDeathRegisterOthersDtls.jsp for(MLC,Remarks and Female Status section.)
			 */
				pstmt=conn.prepareStatement(MR_PARAM_ADDLFLDS_SQL);
				rs=pstmt.executeQuery();
				int k=0;
//				String addl_fields="";
				while(rs.next()){
					String section=checkForNull(rs.getString("SECTION"));
				if(section.equals("H")){
//					addl_fields=addl_fields+rs.getString("FIELD_NAME")+"$";
//						String addl_field=checkForNull(rs.getString("FIELD_NAME"));
//						String addl_field_val=checkForNull((String)addl_fields_map.get(addl_field))
						String addl_prompt	= checkForNull(rs.getString("PROMPT"));
//						String addl_length=checkForNull(rs.getString("LENGTH"),"0");
						int maxlength=Integer.parseInt(checkForNull(rs.getString("LENGTH")));
						int size=(maxlength+15);
						String addl_field=checkForNull(rs.getString("FIELD_NAME"));
						String addl_field_val=checkForNull((String)addl_fields_map.get(addl_field));


					if(k==0){%>
					<tr>  <%}
//					 addl_fields=(String)addl_fields_map.get(rs.getString("FIELD_NAME"));
					%>
					<td class='label' ><%=addl_prompt%></td>
					<td  class="fields"><input type="text"  size="<%=size%>" maxlength="<%=maxlength%>" name="<%=addl_field%>" value="<%=addl_field_val%>" onkeypress="return doCheck(event)" /></td>
					<%
						k++;
						if(k ==1){
						k = 0; %>
						</tr>
				<%	}
				}
			}
			%>
			
				

			</table>

					<input type='hidden' name="patient_id" id="patient_id" value="<%=patient_id%>">
					<input type='hidden' name="encounter_id" id="encounter_id" value="<%=encounter_id%>">			
					<input type='hidden' name="locn_code" id="locn_code" value="<%=locn_code%>">		
					<input type='hidden' name="gender" id="gender" value="<%=gender%>">			
					<input type='hidden' name="dob" id="dob" value="<%=dob%>">	 				
					<input type='hidden' name="speciality_code" id="speciality_code" value="<%=speciality_code%>">						
					<input type='hidden' name="episode_id" id="episode_id" value="<%=episode_id%>">	
					<input type='hidden' name="practitioner_id" id="practitioner_id" value="<%=attnd_pract_id%>">			
					<input type='hidden' name="practitioner_type" id="practitioner_type" value="<%=practitioner_type%>">		
					<input type='hidden' name="patient_class" id="patient_class" value="<%=patient_class%>">
					<input type='hidden' name="call_from" id="call_from" value="<%=call_from%>">		
					<input type='hidden' name="episode_type" id="episode_type" value="<%=episode_type%>">				
					<input type='hidden' name="mode" id="mode" value="<%=mode%>">
					<input type='hidden' name="facilityId" id="facilityId" value="<%=facilityId%>">
					<input type='hidden' name="finalize_yn" id="finalize_yn" value="<%=finalize_yn%>">
					<input type='hidden' name="visit_adm_date" id="visit_adm_date" value="<%=visit_adm_date%>">
					<input type='hidden' name="diag_totalRecords" id="diag_totalRecords" value="">
					<input type='hidden' name="death_reg_form_accession_num" id="death_reg_form_accession_num" value="<%=death_reg_form_accession_num %>">
					<input type ='hidden' name= 'callback_mode' value="View">

		</form>
	</body>
	<%
	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(conn,request);
	}%>
</html>
<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

