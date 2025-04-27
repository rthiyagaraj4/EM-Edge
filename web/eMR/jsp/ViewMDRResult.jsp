<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.TreeMap" %>
<% 

	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	request.setCharacterEncoding("UTF-8"); 

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
	String remarks								="";
	String death_by_pregnancy_yn		="";
	String mlc										="";
	String gestational_unit					="";
	String gestational_period				="";
	String pol_rep_no							="";
	String pol_stn_id							="";
	String pol_id									="";
	String delivered_less_than_6_weeks_yn		="";
	String hid_illnes_date					="";

	HashMap addl_fields_map=new HashMap();

	//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
	Boolean isDeceasedDiagClassDeathRegAppl = false;
	String primary_diag_class = "";
	String secondary_diag_class = "";
	String primary_diag_class_LD = "";
	String secondary_diag_class_LD = "";

try{

	conn=ConnectionManager.getConnection(request);

	isDeceasedDiagClassDeathRegAppl = eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DECEASED_DIAG_CLASS_DEATH_REG");

	/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
	if(isDeceasedDiagClassDeathRegAppl){

		String MRSql = "select primary_diag_class, secondary_diag_class from mr_parameter";

		pstmt = conn.prepareStatement(MRSql);
		rs = pstmt.executeQuery();

		if(rs!=null && rs.next()){
			primary_diag_class = checkForNull(rs.getString("primary_diag_class"));
			secondary_diag_class = checkForNull(rs.getString("secondary_diag_class"));
		}

		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();

		String descSql = "SELECT diag_class_code, long_desc FROM mr_diag_class_lang_vw WHERE diag_class_code = ? AND language_id = ? AND eff_status = 'E' ORDER BY 2";

		if(!primary_diag_class.equals("")){

			pstmt = conn.prepareStatement(descSql);
			pstmt.setString(1,primary_diag_class);
			pstmt.setString(2,locale);
			rs = pstmt.executeQuery();

			if(rs!=null){
				while(rs.next()){
					primary_diag_class_LD = checkForNull(rs.getString("long_desc"));
				}
			}

			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();
		}

		if(!secondary_diag_class.equals("")){

			pstmt = conn.prepareStatement(descSql);
			pstmt.setString(1,secondary_diag_class);
			pstmt.setString(2,locale);
			rs = pstmt.executeQuery();

			if(rs!=null){
				while(rs.next()){
					secondary_diag_class_LD = checkForNull(rs.getString("long_desc"));
				}
			}

			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();
		}
	}

/*Below line(s) added by venkateshs against ML-MMOH-CRF-0354 [IN057191] */
	boolean siteSpecific		=eCommon.Common.CommonBean.isSiteSpecific(conn, "MR","MLC_TO_MEDICO_LEGAL_CASE");
	boolean isMMCLblchngesAppl  = eCommon.Common.CommonBean.isSiteSpecific(conn, "AM","AM_MMCNO_LBL_APPL_YN");//Added By Dharma on 23rd Dec 2019 against  ML-MMOH-CRF-1488
	/*end ML-MMOH-CRF-0354 [IN057191] */
	
	String MR_PARAM_ADDLFLDS_SQL="SELECT 'ADDL_FIELD1' FIELD_NAME,ADDL_FIELD1_PROMPT PROMPT, ADDL_FIELD1_LENGTH LENGTH, ADDL_FIELD1_SECTION SECTION FROM   MR_PARAMETER A UNION SELECT 'ADDL_FIELD2' FIELD_NAME,ADDL_FIELD2_PROMPT, ADDL_FIELD2_LENGTH, ADDL_FIELD2_SECTION FROM   MR_PARAMETER B UNION SELECT 'ADDL_FIELD3' FIELD_NAME,ADDL_FIELD3_PROMPT, ADDL_FIELD3_LENGTH, ADDL_FIELD3_SECTION FROM   MR_PARAMETER C UNION SELECT 'ADDL_FIELD4' FIELD_NAME,ADDL_FIELD4_PROMPT, ADDL_FIELD4_LENGTH, ADDL_FIELD4_SECTION FROM MR_PARAMETER D UNION SELECT 'ADDL_FIELD5' FIELD_NAME,ADDL_FIELD5_PROMPT, ADDL_FIELD5_LENGTH, ADDL_FIELD5_SECTION FROM   MR_PARAMETER E ";
	String PAT_DTLS_SQL="SELECT A.ATTEND_PRACTITIONER_ID,A.AUTH_PRACTITIONER_ID,A.BROUGHT_DEAD_YN,A.NATIONAL_ID_NO,A.FINALIZE_YN, A.PRACT_REG_NO,B.POSITION_DESC,TO_CHAR(A.DEATH_DATE_TIME,'DD/MM/YYYY HH24:MI')DEATH_DATE_TIME,AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+locale+"','1') ATTEND_PRACT_NAME,AM_GET_DESC.AM_PRACTITIONER(A.AUTH_PRACTITIONER_ID,'"+locale+"','1') AUTH_PRACT_NAME,ADDL_FIELD1, ADDL_FIELD2, ADDL_FIELD3, ADDL_FIELD4, ADDL_FIELD5,MP_CALCULATE_AGE_YMD(to_date('"+visit_adm_date+"','dd/mm/yyyy hh24:mi'),'YMDH',A.DEATH_DATE_TIME,'Y')LENGTH_OF_STAY,A.REMARKS, A.DEATH_BY_PREGNANCY_YN, A.MEDICAL_LEGAL_CASE_YN, A.GESTATIONAL_UNIT, A.GESTATIONAL_PERIOD, A.POL_REP_NO, A.POL_STN_ID, A.POL_ID, A.DELIVERED_LESS_THAN_6_WEEKS_YN FROM MR_DEATH_REGISTER_HDR A,AM_PRACTITIONER_LANG_VW B,PR_ENCOUNTER C WHERE A.PATIENT_ID = '"+patient_id+"' AND A.ENCOUNTER_ID = '"+encounter_id+"' AND A.FACILITY_ID ='"+facilityId+"' AND A.AUTH_PRACTITIONER_ID = B.PRACTITIONER_ID(+) AND (LANGUAGE_ID='"+locale+"' or A.AUTH_PRACTITIONER_ID IS NULL)  AND A.FACILITY_ID = C.FACILITY_ID AND A.ENCOUNTER_ID=C.ENCOUNTER_ID";
		pstmt=conn.prepareStatement(PAT_DTLS_SQL);
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
			remarks										=	checkForNull(rs.getString("remarks"));
			death_by_pregnancy_yn				=	checkForNull(rs.getString("death_by_pregnancy_yn"));
			mlc												=	checkForNull(rs.getString("MEDICAL_LEGAL_CASE_YN"));
			gestational_unit								=	checkForNull(rs.getString("gestational_unit"));
			gestational_period						=	checkForNull(rs.getString("gestational_period"));
			pol_rep_no									=	checkForNull(rs.getString("pol_rep_no"));
			pol_stn_id									=	checkForNull(rs.getString("pol_stn_id"));
			pol_id											=	checkForNull(rs.getString("pol_id"));
			delivered_less_than_6_weeks_yn				=	checkForNull(rs.getString("delivered_less_than_6_weeks_yn"),"N");
			length_of_stay				=	rs.getString("LENGTH_OF_STAY");
		}
			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();
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
		String hide_YMH	="";
		String hide_Days	="";
		if(brought_dead_YN.equals("Y")){
			hide_YMH="visibility:hidden;display:none";
			hide_Days="visibility:visible;display:inline";
		}else{
			hide_YMH="visibility:visible;display:inline";
			hide_Days="visibility:hidden;display:none";
		}
	%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script language='javascript' src='../../eCommon/js/dchk.js' ></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language='javascript' src="../../eMR/js/DeathRegister.js"></script>
		<script src='../../eMR/js/MRPractitionerComponent.js' language='javascript'></script>  
		<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
		<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	</head>
	<body>
		<form name="VDR_Result_Form" id="VDR_Result_Form">
			<table width='100%' cellpadding='1' cellspacing='0' border='0'>
					<tr>
						<td colspan="4" class='PANELTOOLBAR' id="Diag_icon"><fmt:message key="eMR.headersection.label" bundle="${mr_labels}"/></td>
					</tr>
					<tr></tr>	
					<tr>
						<td class='label' width='20%'><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></td>
						<td class='QUERYDATA' width='25%'><%=attend_pract_name%></td>
						<td class='label' width='20%'><fmt:message key="eMR.ceritifiedpractitioner.label" bundle="${mr_labels}"/></td>
						<td class='QUERYDATA' width='35%'><%=certify_pract_name%></td>
					</tr>
					<tr>
						<td class='label' ><fmt:message key="Common.designation.label" bundle="${common_labels}"/></td>
						<td class='QUERYDATA' ><%=certify_designation%></td>			
						<td class='label' ><fmt:message key="Common.citizen.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.identification.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eMR.Number.label" bundle="${mr_labels}"/></td>
						<td class='fields' ><%=certify_citizen_id%></td>
					</tr>
					<tr>
						<td class='label' >
						<%if(isMMCLblchngesAppl){ %>
							<fmt:message key="eAM.MMCNO.label" bundle="${am_labels}"/>
						<%}else{ %>
							<fmt:message key="Common.registrationno.label" bundle="${common_labels}"/>
						<%} %>
						
						</td>
						<td class='QUERYDATA' ><%=certify_registr_no%></td>			
						<td class='label' ><fmt:message key="Common.broughtindead.label" bundle="${common_labels}"/></td>
						<td class='QUERYDATA' ><%=brought_dead_YN%></td>
					</tr>
					<tr>
						<td class='label' ><fmt:message key="eMR.lengthofstay.label" bundle="${mr_labels}"/></td>
						<td class='QUERYDATA'  style='<%=hide_YMH%>'><%=year%>
							<span id='leng_year'><fmt:message key="eMR.Y.label" bundle="${mr_labels}"/></span>
							<%=month%><span id='leng_mon'><fmt:message key="eMR.M.label" bundle="${mr_labels}" /></span>
							<%=day%><span id='leng_day'><fmt:message key="eMR.D.label" bundle="${mr_labels}"/></span>
							<%=hours%><span id='leng_hrs'><fmt:message key="Common.Hrs.label" bundle="${common_labels}"/></span>
						</td>
						<td class='QUERYDATA'  style='<%=hide_Days%>'>0<span id='leng_day'><fmt:message key="eMR.D.label" bundle="${mr_labels}"/></span></td>			
						<td class='label' ><fmt:message key="Common.deceaseddatetime.label" bundle="${common_labels}"/></td>
						<td class='QUERYDATA'><%=deceased_dt_time%></td>
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
				String addl_fields="";
				while(rs.next()){
				
				String section=checkForNull(rs.getString("SECTION"));

				if(section.equals("H")){
//					addl_fields=addl_fields+rs.getString("FIELD_NAME")+"$";
						String addl_field=checkForNull(rs.getString("FIELD_NAME"));
						String addl_field_val=checkForNull((String)addl_fields_map.get(addl_field));
					if(k==0){%>
					<tr>  <%}
//					 addl_fields=(String)addl_fields_map.get(rs.getString("FIELD_NAME"));
					%>
					<td class='label' colspan='1' nowrap><%=rs.getString("PROMPT")%></td>
					<td  class='QUERYDATA' colspan='1' style='WORD-BREAK:BREAK-ALL;'><%=addl_field_val%></td>
					<%
						k++;
						if(k == 2){
						k = 0; %>
						</tr>
				<%	}
				}
			}
			%>
			</table>
		<!--******************* End OF Painting Header Details************ -->

			<table width='100%' cellpadding='1' cellspacing='0' border='0' >
					<tr>
						<td colspan="6" class='PANELTOOLBAR' id="Diag_icon"><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td>
					</tr>
					<tr></tr>				
			</table>
			<div style="position:relative;height:120px;overflow:auto">
			<table width='100%' cellpadding='4' cellspacing='0' border='0' >
						<thead id="TabHead">
							<tr style="position:relative;top:expression(this.offsetParent.scrollTop)" >
								<th align='left'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
								<th align='left'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
								<th align='left'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></th>
								<th align='left'><fmt:message key="eMR.durationofillness.label" bundle="${mr_labels}"/></th>
								<th align='left'><fmt:message key="Common.Order.label" bundle="${common_labels}"/></th>
							</tr>
							<tr></tr>
						</thead>
			<%	int j=0;
					try{
						String diag_code="";
						String diag_desc="";
						String diagnosis_group="";
						String diag_onset_date="";
						String diagnosis_seq_no="";
						String diag_dtl_record="";
						String diag_illnes_date="";
						ArrayList primaryList		=	new ArrayList();
						ArrayList OthersList			=	new ArrayList();
						ArrayList general_list		=	new ArrayList();
						HashMap combined_map		= new HashMap();
						int m=0;
						int i=0;

						String ACT_CODES_SQL="SELECT TERM_CODE,TERM_CODE_SHORT_DESC,TERM_SET_ID,OCCUR_SRL_NO, DIAGNOSIS_GROUP,TO_CHAR(ONSET_DATE,'DD/MM/YYYY hh24:MI')ONSET_DATE,SEQ_NO FROM MR_DEATH_REGISTER_DIAG_DTL WHERE PATIENT_ID='"+patient_id+"' AND ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID='"+facilityId+"' GROUP BY DIAGNOSIS_GROUP,OCCUR_SRL_NO,ONSET_DATE,TERM_CODE,TERM_CODE_SHORT_DESC,TERM_SET_ID,SEQ_NO,SRL_NO ORDER BY SEQ_NO,TERM_CODE";
						pstmt=conn.prepareStatement(ACT_CODES_SQL);
						rs=pstmt.executeQuery();
						while(rs.next()){
							diagnosis_group=checkForNull(rs.getString("DIAGNOSIS_GROUP"));
							diag_code=checkForNull(rs.getString("TERM_CODE"));
							diag_desc=checkForNull(rs.getString("TERM_CODE_SHORT_DESC"));
							diag_onset_date=checkForNull(rs.getString("ONSET_DATE"));
							diagnosis_seq_no=checkForNull(rs.getString("SEQ_NO"));
							if(diagnosis_group.equals("C")){
								if(diag_onset_date.equals("")){
									diag_onset_date="00";
								}
								diag_dtl_record	=	diag_code+"#"+diag_desc+"#"+diag_onset_date+"#"+diagnosis_seq_no;
								primaryList.add(diag_dtl_record);
							}else if(diagnosis_group.equals("O")){
								diag_dtl_record	=	diag_code+"#"+diag_desc;
								OthersList.add(diag_dtl_record);

							}else if(diagnosis_group.equals("R")){
								diag_dtl_record	=	diag_code+"#"+diag_desc;
								general_list.add(diag_dtl_record);
							}
						}
							combined_map.put("C",primaryList);
							combined_map.put("O",OthersList);
							combined_map.put("R",general_list);
						if(primaryList!=null&&primaryList.size()>0){%>
						 <tbody id="PrimaryTab" >
							<tr>
								<!--Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742-->
								<%if(isDeceasedDiagClassDeathRegAppl){
									if(!primary_diag_class.equals("")){%>
										<td colspan="6"><font  size="1.5px"><b><%=primary_diag_class_LD%></b></font></td>
									<%}else{%>
										<td colspan="6"><font  size="1.5px"><b><fmt:message key="Common.CauseofDeath.label" bundle="${common_labels}"/></b></font></td>
									<%}%>
								<%}else{%>
									<td colspan="6"><font  size="1.5px"><b><fmt:message key="Common.CauseofDeath.label" bundle="${common_labels}"/></b></font></td>
								<%}%>
							</tr>
							<%while(j<primaryList.size()){
									StringTokenizer st_prime_tkn	 = new StringTokenizer((String)primaryList.get(j),"#");
									String prime_code				 = st_prime_tkn.nextToken();
									String prime_desc				 = st_prime_tkn.nextToken();
									String prime_onsetdate		 = st_prime_tkn.nextToken();
									String prime_seqno			 = st_prime_tkn.nextToken();
									String th_date			="";
									String DATE_SQL	="";
									if(!prime_onsetdate.equals("00")){
										prime_onsetdate=DateUtils.convertDate(prime_onsetdate,"DMYHM" ,"en",locale);
										th_date=DateUtils.convertDate(prime_onsetdate,"DMYHM" ,locale,"en");
										diag_illnes_date="to_date('"+th_date+"','dd/mm/yyyy hh24:mi')";
										/*
											F.Y.I:
											1.The below condition was added for to display duration of illness aganist each diagnosis.
											2.This enhancement is for a gap CRF CRF ADD-SRR20056-CRF-450.xls added on 1/8/2010 10:32 AM
										**/
										if(finalize_yn.equals("Y")){
													 DATE_SQL="SELECT MP_CALCULATE_AGE_YMD(LEAST("+diag_illnes_date+"),'YMDH',MODIFIED_DATE) ILLNESS_DATE FROM MR_DEATH_REGISTER_HDR WHERE FACILITY_ID='"+facilityId+"' AND PATIENT_ID='"+patient_id+"' AND ENCOUNTER_ID='"+encounter_id+"' ";
										}else{
													 DATE_SQL="SELECT MP_CALCULATE_AGE_YMD(LEAST("+diag_illnes_date+"),'YMDH',SYSDATE) ILLNESS_DATE FROM DUAL";
										}

											pstmt=conn.prepareStatement(DATE_SQL);
											rs=pstmt.executeQuery();
											while(rs.next()){
												hid_illnes_date=checkForNull(rs.getString("ILLNESS_DATE"));
											}
											if(pstmt!=null)pstmt.close();
											if(rs!=null)rs.close();
									}else{
										prime_onsetdate="";
									}
							%>
						<tr>
							<td class='QUERYDATA'><%=prime_code%></td>
							<td class='QUERYDATA'><%=prime_desc%></td>
							<td class='QUERYDATA'>&nbsp;<%=prime_onsetdate%></td>
							<td class='QUERYDATA' id="illnes_decease_date_<%=j%>">&nbsp;<%=hid_illnes_date%></td>
							<td class='QUERYDATA'><%=prime_seqno%></td>
						</tr>
						<%j++;}//End OF while%>
						</tbody>
					<%
				}//End OF Cause Of Death
				if(OthersList!=null && OthersList.size()>0){
						%>
						 <tbody id="OthersTab">
								<tr>
									<!--Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742-->
									<%if(isDeceasedDiagClassDeathRegAppl){
										if(!secondary_diag_class.equals("")){%>
											<td colspan="6"><font  size="1.5px"><b><%=secondary_diag_class_LD%></b></font></td>
										<%}else{%>
											<td colspan="6"><font  size="1.5px"><b><fmt:message key="eMR.otherdiseasecomplication.label" bundle="${mr_labels}"/></b></font></td>
										<%}%>
									<%}else{%>
										<td colspan="6"><font  size="1.5px"><b><fmt:message key="eMR.otherdiseasecomplication.label" bundle="${mr_labels}"/></b></font></td>
									<%}%>
								</tr>
							<%
								 while(m<OthersList.size()){
							%>
							<tr cellspacing='10' cellpadding='5'>
								<%
									StringTokenizer st_others_tkn	 = new StringTokenizer((String)OthersList.get(m),"#");
									String othr_code	= st_others_tkn.nextToken();
									String othr_desc	=  st_others_tkn.nextToken();
								%>
								<td class='QUERYDATA'><%=othr_code%></td>
								<td class='QUERYDATA'><%=othr_desc%></td>
								<td  colspan='3' class='QUERYDATA'>&nbsp;</td>
							</tr>
					<%m++;}%>
					</tbody>
			<%}//End Of Others
					if(general_list!=null && general_list.size()>0){%>
						<tbody id="GenaralTab">
							<tr>
								<td colspan="6"><font size="1.5px"><b><fmt:message key="eMR.generaldiaglist.label" bundle="${mr_labels}"/></b></font></td>
							</tr>
							<%
								while(i<general_list.size()){%>
								<tr>
									<%
										StringTokenizer st_genaral_tkn	 = new StringTokenizer((String)general_list.get(i),"#");
										String gen_code  =  st_genaral_tkn.nextToken();
										String gen_desc	  =  st_genaral_tkn.nextToken();
									%>
									<td width='10%' class='QUERYDATA'><%=gen_code%>&nbsp;</td>
									<td width='30%' class='QUERYDATA'><%=gen_desc%>&nbsp;</td>
									<td width='50%' colspan='3' class='QUERYDATA'>&nbsp;</td>
								</tr>
							<%i++;}%>
							</tbody>
						<%}// End Of General 
					%>
			</table>
		</div>
		<%}catch(Exception ex){
			ex.printStackTrace();
		}%>
		<!--******************* End OF Painting Diagnosis Details************ -->
			<table width='100%' cellpadding='1' cellspacing='0' border='0' >
					<tr>
						<td colspan="6" class='PANELTOOLBAR' id="Diag_icon"><fmt:message key="Common.remarks.label" bundle="${mr_labels}"/></td>
					</tr>
					<tr></tr>
					<tr>
						<td width='5%' class="label"><fmt:message key="Common.remarks.label" bundle="${mr_labels}"/></td>
						<td  class='QUERYDATA' style='WORD-BREAK:BREAK-ALL;'  width='30%'><%=remarks%></td>
					</tr>
					</table>
					<table width='100%' cellpadding='1' cellspacing='0' border='0' >
						<%
							pstmt=conn.prepareStatement(MR_PARAM_ADDLFLDS_SQL);
							rs=pstmt.executeQuery();
							int n=0;
		//					String addl_fields="";
							while(rs.next()){

							String section=checkForNull(rs.getString("SECTION"));

							if(section.equals("C")){
		//						addl_fields=addl_fields+rs.getString("FIELD_NAME")+"$";
								String addl_field=checkForNull(rs.getString("FIELD_NAME"));
								String addl_field_val=checkForNull((String)addl_fields_map.get(addl_field));

								if(n==0){%>
								<tr>  <%}%>
								<td  class="label" width='20%' nowrap><%=rs.getString("PROMPT")%></td>
								<td class='QUERYDATA' style='WORD-BREAK:BREAK-ALL;' width='20%' ><%=addl_field_val%><td></td>
								<%
									n++;
									if(n==2){
									n = 0; %>
									</tr>
							<%	}
							}
						}
				%>
				</table>
		<% if(gender.equals("F")){%>

			<table width='100%' cellpadding='1' cellspacing='0' border='0'>
					<tr>
						<td colspan="12" class='PANELTOOLBAR' id="Diag_icon"><fmt:message key="eMR.femalepatientstatus.label" bundle="${mr_labels}"/></td>
					</tr>
					<tr></tr>
 					<tr>
					
					<% 
							if(death_by_pregnancy_yn.equals("P")){%>
							<td   class='QUERYDATA' width='8%'><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Pregnant.label","common_labels")%></td>
						<%if(!gestational_period.equals("")){%>
							<td class="label" width='11%'><fmt:message key="eMR.gestationalage.label" bundle="${mr_labels}"/></td>
							<td class='QUERYDATA' width='2%'><%=gestational_period%></td>
						<%}%>
						<%if(gestational_unit.equals("W")){%>
							<td class='QUERYDATA' width='3%'><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weeks.label","common_labels")%></td>
						<%}else if(gestational_unit.equals("D")){%>
							<td class='QUERYDATA' width='3%'  ><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels")%></td>
						<%}%>
							<td class="label" width='20%'><fmt:message key="eMR.deliveredlessthan6weeks.label" bundle="${mr_labels}"/></td>
							<td class='QUERYDATA'><%=delivered_less_than_6_weeks_yn%></td>
				<%}else if(death_by_pregnancy_yn.equals("N")){%>
							<td   class='QUERYDATA' width='13%'><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.notpregnant.label","mr_labels")%></td>
							<td class="label" width='20%'><fmt:message key="eMR.deliveredlessthan6weeks.label" bundle="${mr_labels}"/></td>
							<td class='QUERYDATA'><%=delivered_less_than_6_weeks_yn%></td>
				<%}else if(death_by_pregnancy_yn.equals("U")){%>
							<td   class='QUERYDATA' width='15%'><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.detailsunknown.label","common_labels")%></td>
				<%}%>
					</tr>
					<tr></tr>
					</table>
					<table width='100%' cellpadding='1' cellspacing='0' border='0' >
						<%
							pstmt=conn.prepareStatement(MR_PARAM_ADDLFLDS_SQL);
							rs=pstmt.executeQuery();
							int kk=0;
		//					String addl_fields="";
							while(rs.next()){

							String section=checkForNull(rs.getString("SECTION"));

							if(section.equals("P")){
		//						addl_fields=addl_fields+rs.getString("FIELD_NAME")+"$";
								String addl_field=checkForNull(rs.getString("FIELD_NAME"));
								String addl_field_val=checkForNull((String)addl_fields_map.get(addl_field));

								if(kk==0){%>
								<tr>  <%}%>
								<td  class="label" width='20%' nowrap><%=rs.getString("PROMPT")%></td>
								<td class='QUERYDATA' style='WORD-BREAK:BREAK-ALL;' width='20%'><%=addl_field_val%><td>
								<%
									kk++;
									if(kk==2){
									kk = 0; %>
									</tr>
							<%	}
							}
						}
				%>
				</table>
			<%}%>
			<table width='100%' cellpadding='1' cellspacing='0' border='0' >
					<tr>
					<!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->
					     <%if(siteSpecific){%>
						 <td colspan="15" class='PANELTOOLBAR' id="Diag_icon"><fmt:message key="Common.MedicalLegalCase.label"  bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label"  bundle="${common_labels}"/></td>
						 <%}else{%>
						<td colspan="15" class='PANELTOOLBAR' id="Diag_icon"><fmt:message key="Common.mlc.label"  bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label"  bundle="${common_labels}"/></td>
						<%}%>
						<!--end ML-MMOH-CRF-0354 [IN057191 -->
					</tr>
					<tr></tr>
					<tr><!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->
					      <%if(siteSpecific){%>
						  	<td width='15%' class="label"><fmt:message key="Common.MedicalLegalCase.label"  bundle="${common_labels}"/></td>
						  <%}else{%>
						<td width='15%' class="label"><fmt:message key="Common.mlc.label"  bundle="${common_labels}"/></td>
						<%}%>
						<!--end ML-MMOH-CRF-0354 [IN057191 -->
						<td width='3%' class='QUERYDATA'><%=mlc%></td>
						<td width='15%' class="label"><fmt:message key="Common.PoliceReportNo.label"  bundle="${common_labels}"/></td>
						<td width='20%' class='QUERYDATA'><%=pol_rep_no%></td>
						<td width='20%' class="label"></td>
						<td width='30%' class='QUERYDATA'></td>

					</tr>
					<tr>
						<td class="label" width='15%'><fmt:message key="Common.station.label"  bundle="${common_labels}"/></td>
						<td class='QUERYDATA' width='20%'><%=pol_stn_id%></td>
						<td class="label" width='5%'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
						<td  class='QUERYDATA' width='20%'><%=pol_id%></td>
						<td  class="label"></td>
						<td  class='QUERYDATA'></td>

					</tr>
				<%
					pstmt=conn.prepareStatement(MR_PARAM_ADDLFLDS_SQL);
					rs=pstmt.executeQuery();
					int i=0;
					while(rs.next()){
					String section=checkForNull(rs.getString("SECTION"));

					if(section.equals("M")){
						String addl_field=checkForNull(rs.getString("FIELD_NAME"));
						String addl_field_val=checkForNull((String)addl_fields_map.get(addl_field));
						if(i==0){%>
						<tr>  <%}%>
						<td  class="label" colspan='1' nowrap><%=checkForNull(rs.getString("PROMPT"))%></td>
						<td  class='QUERYDATA' style='WORD-BREAK:BREAK-ALL;' colspan='1'><%=addl_field_val%></td>
						<%
							i++;
							if(i ==2){
							i= 0; %>
							</tr>
					<%	}
					}
				}
		%>

		</table>
			<input type='hidden' name='seq_no' id='seq_no' value='<%=j%>'>
			<input type='hidden' name="hid_illnes_date" id="hid_illnes_date" value="<%=hid_illnes_date%>">
		</form>
	</body>
<%}catch(Exception ex){
	ex.printStackTrace();
}finally{
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

