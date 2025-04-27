<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.util.StringTokenizer,java.util.HashMap,java.util.ArrayList,eCommon.XSSRequestWrapper" %>

<% 

	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle						= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String locale						= checkForNull((String)session.getAttribute("LOCALE"));
	String FacilityId					= checkForNull((String) session.getValue( "facility_id" ));
	String patient_id				=	checkForNull(request.getParameter("patient_id"));
	String encounter_id			=	checkForNull(request.getParameter("encounter_id"));
	String locn_code				=	checkForNull(request.getParameter("locn_code"));
	String gender	 					=	checkForNull(request.getParameter("gender"));
	String dob							=	checkForNull(	request.getParameter("dob"));
	String speciality_code		=	checkForNull(request.getParameter("speciality_code"));
	String episode_id				=	checkForNull(request.getParameter("episode_id"));
	String practitioner_id			=	checkForNull(request.getParameter("practitioner_id"));
	String practitioner_type	=	checkForNull(request.getParameter("practitioner_type"));
	String patient_class			=	checkForNull(request.getParameter("patient_class"));
	String call_from					=	checkForNull(request.getParameter("call_from"));
	String episode_type			=	checkForNull(request.getParameter("episode_type"));
	String mode						=	checkForNull(request.getParameter("mode"));
	String finalize_yn				=	checkForNull(request.getParameter("finalize_yn"),"N");
	String totalRecords			=	checkForNull(request.getParameter("totalRecords"),"0");
	String increment_records	=	checkForNull(request.getParameter("increment_records"),"N");

	int totalRecords1				=	Integer.parseInt(totalRecords);
	String max_pri_diag			=	"";
	String max_oth_dis			=	"";
	String hid_illnes_date		="";
	int maxRecords					=0;
	int maxRecords1				=0;
	String currentdateTime		="";
//	String currentdate				="";
//	String currentTime				="";
	String disable_btns			="";
	String disable_fields			="";
	String dis_seq_btn			="";

	//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
	Boolean isDeceasedDiagClassDeathRegAppl = false;
	String primary_diag_class = "";
	String secondary_diag_class = "";
	String diag_class_code = "";
	String primary_diag_class_LD = "";
	String secondary_diag_class_LD = "";

	Connection conn =null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language='javascript' src='../../eCommon/js/dchk.js' ></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src="../../eMR/js/DeathRegister.js"></script>
		<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
		<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
		<script src='../../eCommon/js/dchk.js' language='javascript'></script>

		<style>
		.dropdownFix 
			{ 
				behavior:expression(this.style.visibility = this.offsetParent.offsetParent.offsetParent.scrollTop >
				(this.offsetParent.offsetTop - this.parentElement.parentElement.parentElement.firstElementChild.offsetHeight) ? 'hidden' : 'visible'); 
			}
		</style>
	</head>
	<body>
		<form name="DR_DiagnosisDtls_Form" id="DR_DiagnosisDtls_Form">
			<%
					if(finalize_yn.equals("Y")){
						disable_btns="none";
						disable_fields="disabled";
					}else if(call_from.equals("VIEW_DEATH_REG")){
						disable_btns="none";
					}else{
						disable_btns="inline";
						disable_fields="";
					}
						//int seq_no=1;
						int j=0;
						int k=0;
				try{
						conn = ConnectionManager.getConnection(request);

						isDeceasedDiagClassDeathRegAppl = eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DECEASED_DIAG_CLASS_DEATH_REG");//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742

						/*
						Commented For PE5/17/2010
						String getDate = "select to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate from dual" ;
						pstmt=conn.prepareStatement(getDate);
						rs	  = pstmt.executeQuery();
						if (rs.next()){
							currentdateTime	= rs.getString("sdate");
//							currentdate		= currentdateTime.substring(0,10);
							currentdateTime	=DateUtils.convertDate(currentdateTime,"DMYHM","en",locale);
//							currentTime		= currentdateTime.substring(11);
						}
							if(pstmt!=null)pstmt.close();
							if(rs!=null)rs.close();*/

						String MR_PARAM_SETUP_SQL= "SELECT MAX_PRI_DIAG_INDICATE_CO_DEATH, MAX_OTH_DIS_COMP_INDI_CO_DEATH,TO_CHAR(SYSDATE,'DD/MM/RRRR HH24:MI') SDATE, PRIMARY_DIAG_CLASS, SECONDARY_DIAG_CLASS FROM MR_PARAMETER";
						pstmt=conn.prepareStatement(MR_PARAM_SETUP_SQL);
						rs=pstmt.executeQuery();
						while(rs.next()){
							max_pri_diag	=	checkForNull(rs.getString("MAX_PRI_DIAG_INDICATE_CO_DEATH"));
							max_oth_dis		=	checkForNull(rs.getString("MAX_OTH_DIS_COMP_INDI_CO_DEATH"));
							currentdateTime	= rs.getString("SDATE");
//							currentdate		= currentdateTime.substring(0,10);
							currentdateTime	=DateUtils.convertDate(currentdateTime,"DMYHM","en",locale);
//							currentTime		= currentdateTime.substring(11);
							
							//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
							primary_diag_class = checkForNull(rs.getString("PRIMARY_DIAG_CLASS"));
							secondary_diag_class = checkForNull(rs.getString("SECONDARY_DIAG_CLASS"));

						}
							if(pstmt!=null)pstmt.close();
							if(rs!=null)rs.close();
						
						/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
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
						/*End ML-MMOH-CRF-1742*/

						HashMap	diag_dates_map	=	new HashMap();
						HashMap	diag_desc_map		=	new HashMap();
						HashMap combined_map		= new HashMap();
						HashMap db_diagdates_map	= new HashMap();
//						HashMap db_diagdesc_map		= new HashMap();
						//HashMap data_base_map	= new HashMap();
						combined_map						=	(HashMap)session.getAttribute("combined_map");
						diag_dates_map					=	(HashMap)session.getAttribute("diag_dates_map");
						diag_desc_map	 					=	(HashMap)session.getAttribute("diag_desc_map");
						//ArrayList data_base_list	=	new ArrayList();
						//ArrayList data_base_list1	=	new ArrayList();
						ArrayList primaryList		=	new ArrayList();
						ArrayList OthersList			=	new ArrayList();
						ArrayList general_list		=	new ArrayList();
						//String ClassValue="";
						int i=0;
						String code					="";
						String term_set_id			="";
						String occur_srl_no		="";
						String diag_dtl_record	="";
						String code_short_desc	="";
						String code_onset_date ="";
						//int death_reg_cnt			=0;
//						String ACT_CODES_SQL="SELECT TERM_CODE,TERM_SET_ID, OCCUR_SRL_NO FROM PR_DIAGNOSIS_ENC_DTL  WHERE PATIENT_ID='"+patient_id+"' AND ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID='"+FacilityId+"' ";
							String diagnosis_group="";
							mode="MODIFY";
/*
	FYI:
	1.When  MDR  window is opened freshly or clear the values then the maps will be null.
	2.if maps are null then data will be updated into the combined_map if the data is already there for the patient in MR_detail table.
	3. For that ACT_CODES_SQL is used and the status of the diag_dtl_record will be 'E' getting from MR_DTL table.
	4.Same time ACT_CODES_SQL1 will be executed and the  status of the diag_dtl_record will be 'A' data getting from PR_Diagnosis table.
	5.Based upon the 'A' and 'E' the MR_DTL table will Insert or update.
	5.Last item in the String is indicates that wheather the code is added from the Add New Diag Button ('I') added ('X') not added.
	6. The below code works in the same way.

*/
				if(combined_map==null && diag_dates_map==null ){
							String ACT_CODES_SQL="SELECT SRL_NO,TERM_CODE,TERM_CODE_SHORT_DESC,TERM_SET_ID,OCCUR_SRL_NO, DIAGNOSIS_GROUP,TO_CHAR(ONSET_DATE,'DD/MM/YYYY hh24:MI')ONSET_DATE FROM MR_DEATH_REGISTER_DIAG_DTL WHERE PATIENT_ID='"+patient_id+"' AND ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID='"+FacilityId+"' GROUP BY DIAGNOSIS_GROUP,OCCUR_SRL_NO,ONSET_DATE,TERM_CODE,TERM_CODE_SHORT_DESC,TERM_SET_ID,SEQ_NO,SRL_NO ORDER BY SEQ_NO,TERM_CODE";
							pstmt=conn.prepareStatement(ACT_CODES_SQL);
							rs=pstmt.executeQuery();
							int index=1;
							maxRecords=0;
							maxRecords1=0;
							String status="";
							while(rs.next()){
								status="E";
								//boolean disp=false ;
								index						=	rs.getInt("SRL_NO");
								code							=	checkForNull(rs.getString("TERM_CODE"));
								term_set_id				=	checkForNull(rs.getString("TERM_SET_ID"));
								occur_srl_no				=	checkForNull(rs.getString("OCCUR_SRL_NO"));
								code_short_desc		=	checkForNull(rs.getString("TERM_CODE_SHORT_DESC"));
								code_onset_date		=	checkForNull(rs.getString("ONSET_DATE"));
								code_onset_date		= DateUtils.convertDate(code_onset_date,"DMYHM" ,"en",locale);
								diagnosis_group		=	checkForNull(rs.getString("DIAGNOSIS_GROUP"));
								if(diagnosis_group.equals("C")){
									diag_dtl_record		=	index+"#"+status+"#"+code+"#"+term_set_id+"#"+occur_srl_no+"#"+code_short_desc+"#"+"X";
									primaryList.add(diag_dtl_record);
								}
								if(diagnosis_group.equals("O")){
									diag_dtl_record		=	index+"#"+status+"#"+code+"#"+term_set_id+"#"+occur_srl_no+"#"+code_short_desc+"#"+"X";
									OthersList.add(diag_dtl_record);
								}
								if(diagnosis_group.equals("R")){
									diag_dtl_record	=	index+"#"+status+"#"+code+"#"+term_set_id+"#"+occur_srl_no+"#"+code_short_desc+"#"+"X";
									general_list.add(diag_dtl_record);
								}
								db_diagdates_map.put(diag_dtl_record,code_onset_date);
//								db_diagdesc_map.put(diag_dtl_record,code_short_desc);
//								data_base_list.add(diag_dtl_record);
								maxRecords++;
							}
							if(pstmt!=null)pstmt.close();
							if(rs!=null)rs.close();

							String ACT_CODES_SQL1="SELECT  A.TERM_SET_ID, A.TERM_CODE,A.OCCUR_SRL_NO, TO_CHAR(A.ONSET_DATE,'DD/MM/YYYY HH24:MI') ONSET_DATE,A.TERM_CODE_SHORT_DESC, E.DIAG_CLASS_CODE FROM PR_DIAGNOSIS A , MR_TERM_SET B, MR_TERM_CODE C, PR_DIAGNOSIS_ENC_DTL E  WHERE  A.PATIENT_ID = '"+patient_id+"' AND E.ENCOUNTER_ID='"+encounter_id+"' AND E.FACILITY_ID='"+FacilityId+"' AND E.STATUS='A' AND A.CURR_STATUS=E.STATUS AND A.PATIENT_ID=E.PATIENT_ID AND A.TERM_SET_ID=E.TERM_SET_ID AND A.OCCUR_SRL_NO=E.OCCUR_SRL_NO AND  A.TERM_CODE  =E.TERM_CODE AND A.ONSET_FACILITY_ID=E.FACILITY_ID  AND EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_FACILITY WHERE FACILITY_ID='"+FacilityId+"' AND TERM_SET_ID=A.TERM_SET_ID)  AND EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_SPECIALTY WHERE SPECIALTY_CODE IN (SELECT SPECIALTY_CODE FROM PR_ENCOUNTER WHERE FACILITY_ID='"+FacilityId+"' AND ENCOUNTER_ID='"+encounter_id+"') AND TERM_SET_ID=A.TERM_SET_ID) AND NOT EXISTS (SELECT 1 FROM MR_DEATH_REGISTER_DIAG_DTL WHERE FACILITY_ID= A.ONSET_FACILITY_ID AND ENCOUNTER_ID=E.ENCOUNTER_ID AND  TERM_SET_ID = A.TERM_SET_ID AND TERM_CODE = A.TERM_CODE  AND OCCUR_SRL_NO=A.OCCUR_SRL_NO) AND B.TERM_SET_ID(+) = A.TERM_SET_ID  AND C.TERM_SET_ID(+) =A.TERM_SET_ID AND C.TERM_CODE(+)=A.TERM_CODE ORDER BY A.TERM_CODE  ";
							pstmt=conn.prepareStatement(ACT_CODES_SQL1);
							rs=pstmt.executeQuery();
							maxRecords1=0;
							while(rs.next()){
								status="A";
//								index	= maxRecords+1;
								index						=	 maxRecords+1;
								code							=	checkForNull(rs.getString("TERM_CODE"));
								term_set_id				=	checkForNull(rs.getString("TERM_SET_ID"));
								occur_srl_no				=	checkForNull(rs.getString("OCCUR_SRL_NO"));
								code_short_desc		=	checkForNull(rs.getString("TERM_CODE_SHORT_DESC"));
								diag_class_code		=	checkForNull(rs.getString("DIAG_CLASS_CODE"));//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
								code_onset_date		=	checkForNull(rs.getString("ONSET_DATE"));
								code_onset_date		= DateUtils.convertDate(code_onset_date,"DMYHM" ,"en",locale);
								diag_dtl_record		=	index+"#"+status+"#"+code+"#"+term_set_id+"#"+occur_srl_no+"#"+code_short_desc+"#"+"X";
								
								/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
								if(isDeceasedDiagClassDeathRegAppl){
									if(!primary_diag_class.equals("") && secondary_diag_class.equals("")){
										if(diag_class_code.equals(primary_diag_class)){
											primaryList.add(diag_dtl_record);
										}else{
											general_list.add(diag_dtl_record);
										}
									}else if(primary_diag_class.equals("") && !secondary_diag_class.equals("")){
										if(diag_class_code.equals(secondary_diag_class)){
											OthersList.add(diag_dtl_record);
										}else{
											general_list.add(diag_dtl_record);
										}
									}else if(!primary_diag_class.equals("") && !secondary_diag_class.equals("")){
										if(diag_class_code.equals(primary_diag_class)){
											primaryList.add(diag_dtl_record);
										}else if(diag_class_code.equals(secondary_diag_class)){
											OthersList.add(diag_dtl_record);
										}else{
											general_list.add(diag_dtl_record);
										}
									}else{
										general_list.add(diag_dtl_record);
									}
								}else{
									general_list.add(diag_dtl_record);
								}
								/*End ML-MMOH-CRF-1742*/

								db_diagdates_map.put(diag_dtl_record,code_onset_date);
//								db_diagdesc_map.put(diag_dtl_record,code_short_desc);
								maxRecords=index;
//								maxRecords1++;
							}
							if(pstmt!=null)pstmt.close();
							if(rs!=null)rs.close();

							if(combined_map==null){
								combined_map =new HashMap();
	//							data_base_map.put("Y",data_base_list);
								combined_map.put("C",primaryList);
								combined_map.put("O",OthersList);
								combined_map.put("R",general_list);
								session.setAttribute("combined_map",combined_map);
							}
							if(diag_dates_map==null){
								diag_dates_map =new HashMap();
								diag_dates_map =db_diagdates_map;
								session.setAttribute("diag_dates_map",diag_dates_map);

							}
							/*if(diag_desc_map==null){
								diag_desc_map =new HashMap();
								diag_desc_map =db_diagdesc_map;
								session.setAttribute("diag_desc_map",diag_desc_map);
							}*/
							totalRecords1=(maxRecords);
				}
			%>
					<table width='100%' cellpadding='1' cellspacing='0' border='0' >
							<tr>
								<td colspan="6" class='PANELTOOLBAR' id="Diag_icon"><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td>
							</tr>
							<tr></tr>
					</table>
					<div  style="position:relative;height:185px;overflow:auto">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
						<thead id="TabHead">
							<tr style="position:relative;top:expression(this.offsetParent.scrollTop)" >
								<th align='left'>&nbsp;<fmt:message key="eMR.Select.label" bundle="${mr_labels}"/></th>
								<th align='left'>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
								<th align='left'>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
								<th align='left'>&nbsp;<fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></th>
								<th align='left'>&nbsp;<fmt:message key="eMR.durationofillness.label" bundle="${mr_labels}"/></th>
								<th align='left'>&nbsp;<fmt:message key="Common.Order.label" bundle="${common_labels}"/></th>
							</tr>
							<tr></tr>
					</thead>


			<%
//				combined_map=null;
/*
	FYI:
	1.When  MDR  window is reloded.
	2.The maps are getting from the session. The updated then data will be painted as in the groups .
	3.Last item in the String is indicates that wheather the code is added from the Add New Diag Button ('I') added ('X') not added.
	4. The below code works in the same way.
*/

				if(combined_map!=null){
					if(combined_map.containsKey("C")){
						primaryList=(ArrayList)combined_map.get("C");
					}
					if(combined_map.containsKey("O")){
						OthersList=(ArrayList)combined_map.get("O");
					}
					if(combined_map.containsKey("R")){
						general_list=(ArrayList)combined_map.get("R");
					}
					if(increment_records.equals("Y")){
						totalRecords1=(totalRecords1+1);
					}

					 if(primaryList!=null&&primaryList.size()>0){
						 String diag_onset_date="";
				%>
						
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
						<%
							String primary_diag_record="";
							String diag_illnes_date="";
							 while(j<primaryList.size()){
								StringTokenizer st_prime_tkn	 = new StringTokenizer((String)primaryList.get(j),"#");
								Integer.parseInt(st_prime_tkn.nextToken());
								st_prime_tkn.nextToken() ;
								String prime_code				 = st_prime_tkn.nextToken();
								st_prime_tkn.nextToken();
								st_prime_tkn.nextToken();
								primary_diag_record=(String)primaryList.get(j);
								diag_onset_date=(String)diag_dates_map.get(primary_diag_record);
//								out.println("diag_onset_date========1=======>" +diag_onset_date);

								//diag_onset_date		= DateUtils.convertDate(diag_onset_date,"DMYHM" ,"en",locale);
//								out.println("diag_onset_date===============>" +diag_onset_date);

						%>
						<tr id="tr_<%=j%>">
							<td class='griddata'><input type="checkbox" name="primary_chk<%=j%>" id="primary_chk<%=j%>"  value="<%=primary_diag_record%>" <%=disable_fields%>></td>
							<td class='griddata'><%=prime_code%></td>
							<%
								String prime_desc	=  st_prime_tkn.nextToken();

							%>
							<td class='griddata' style='WORD-BREAK:BREAK-ALL;'  width='20%'><%=prime_desc%></td>
							<%
								String diag_dates_records1=diag_onset_date;
								String th_date			= "";
								String DATE_SQL	= "";
								/*
									F.Y.I:
									1.The populating theDuration Of illness value is done by JS function paintValue(); in the same JSP page; 
									2.The above statement was enhanced to dispaly Duration Of illness aganist each diagnosis.
									3.The below Query wil be executed based upon the Finalize_YN value.
									3.For gap CRF ADD-SRR20056-CRF-450.xls Modified On 1/7/2010.
								*/
								if(!diag_dates_records1.equals("")){
									th_date=DateUtils.convertDate(diag_dates_records1,"DMYHM" ,locale,"en");
									diag_illnes_date="to_date('"+th_date+"','dd/mm/yyyy hh24:mi')";
									if(finalize_yn.equals("Y")){
										 DATE_SQL="SELECT MP_CALCULATE_AGE_YMD(LEAST("+diag_illnes_date+"),'YMDH',MODIFIED_DATE) ILLNESS_DATE FROM MR_DEATH_REGISTER_HDR WHERE FACILITY_ID='"+FacilityId+"' AND PATIENT_ID = '"+patient_id+"' AND ENCOUNTER_ID='"+encounter_id+"' ";
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
								}
								String onset_date	=	diag_dates_records1;
							%>
							<td class='griddata'><input type="text" name="onset_date_<%=j%>" id="onset_date_<%=j%>" size='18' maxlength='18' value="<%=onset_date%>" Onblur="validateDatetime(this,getLabel('Common.onsetdate.label','Common'),<%=j%>)" <%=disable_fields%>/><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('onset_date_<%=j%>','dd/mm/yyyy','hh:24mi');" <%=disable_fields%>/></td>
							<!-- 
								F.Y.I:
								1.The populating theDuration Of illness value is done by JS function paintValue(); in the same JSP page; 
								2.The above statement was enhanced to dispaly Duration Of illness aganist each diagnosis.
								3.For  gap CRF ADD-SRR20056-CRF-450.xls Modified On 1/7/2010.
							-->
							<td class='griddata'  id="illnes_decease_date_<%=j%>"><input type="text" name="duration_of_illnes_<%=j%>" id="duration_of_illnes_<%=j%>" size='15' maxlength='15' value="<%=hid_illnes_date%>" <%=disable_fields%> readonly/></td>
							<!-- The populating the seq-no is done by JS function populateSeqNOs() in the same JSP page; -->
							<td class='griddata'>
							<select name='seqdiag<%=j%>' id='seqdiag<%=j%>' class="dropdownFix"  onchange="validate_duplicate_diag(this,<%=j%>)"<%=disable_fields%>>
							</select>
							</td>
						</tr>
					
					<%j++;}
						if(j==0||j==1){
							dis_seq_btn	="disabled";
						}
					%>
				</tbody>
					<%
					}else{
						dis_seq_btn	="disabled";
					}
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
							 while(k<OthersList.size()){
						%>
						<tr>
							<td class='griddata'><input type="checkbox" name="others_chk<%=k%>" id="others_chk<%=k%>"  value="<%=OthersList.get(k)%>" <%=disable_fields%>></td>
							<%
								StringTokenizer st_others_tkn	 = new StringTokenizer((String)OthersList.get(k),"#");
								 Integer.parseInt(st_others_tkn.nextToken());
								 st_others_tkn.nextToken() ;
								String othr_code			= st_others_tkn.nextToken();
								 st_others_tkn.nextToken();
								 st_others_tkn.nextToken();
								String othr_desc	=  st_others_tkn.nextToken();
							%>
							<td class='griddata'><%=othr_code%></td>
							<td class='griddata'   style='WORD-BREAK:BREAK-ALL;'  width='20%'><%=othr_desc%></td>
							<td  colspan='3' class='griddata'>&nbsp;</td>
						</tr>
					
					<%k++;}%>
					</tbody>
					<%}
					if(general_list!=null && general_list.size()>0){%>
						<tbody id="GenaralTab">
							<tr>
								<td colspan="6"><font size="1.5px"><b><fmt:message key="eMR.generaldiaglist.label" bundle="${mr_labels}"/></b></font></td>
							</tr>
							<%
								while(i<general_list.size()){
									boolean disp=false ;
									boolean disp1=false ;
									if(primaryList!=null && OthersList!=null ){
										disp= primaryList.contains(general_list.get(i));
										disp1= OthersList.contains(general_list.get(i));
									}
									if(disp || disp1){
										general_list.remove(general_list.get(i));
										continue;
									}
								%>
								<tr>
									<td width='10%' class='griddata'><input type="checkbox" name="slctd_code<%=i%>" id="slctd_code<%=i%>" value="<%=general_list.get(i)%>"  <%=disable_fields%> >&nbsp;</td>
									<%
										StringTokenizer st_genaral_tkn	 = new StringTokenizer((String)general_list.get(i),"#");
										Integer.parseInt(st_genaral_tkn.nextToken());
										st_genaral_tkn.nextToken() ;
										String gen_code		 = st_genaral_tkn.nextToken();
										 st_genaral_tkn.nextToken();
										 st_genaral_tkn.nextToken();
//										String gen_desc=getDesc(gen_code,gen_tm_set_id,gen_ocur_srlno,FacilityId,patient_id,encounter_id,request);
//										String gen_desc=(String)diag_desc_map.get((String)general_list.get(i));
										String gen_desc	=  st_genaral_tkn.nextToken();

										
									%>
									<td width='10%' class='griddata'><%=gen_code%>&nbsp;</td>
									<td  class='griddata' style='WORD-BREAK:BREAK-ALL;'  width='20%' ><%=gen_desc%>&nbsp;</td>
									<td width='50%' colspan='3' class='griddata'>&nbsp;</td>
								</tr>
							<%i++;}%>
							</tbody>
						<%}
			}%>
				</table>
			</div>
			<div style="display:<%=disable_btns%>">
				<table width='100%' cellpadding='1' cellspacing='0' border='0' scrolling="no">
					<tr>
						<!--Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742-->
						<%if((!isDeceasedDiagClassDeathRegAppl) || (isDeceasedDiagClassDeathRegAppl && primary_diag_class.equals("") && secondary_diag_class.equals(""))){%>
							<td class ='fields' width='13%' ><fmt:message key="eMR.moveto.label" bundle="${mr_labels}"/></td>
							<td class="fields" width='25%'>
								<select name="move_to_grp" id="move_to_grp" onchange="buildGroups(this,'<%=i%>')">
									<option>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
									<option value="C"><fmt:message key="Common.CauseofDeath.label" bundle="${common_labels}"/></option>
									<option value="O"><fmt:message key="eMR.otherdiseasecomplication.label" bundle="${mr_labels}"/></option>
									<option value="R"><fmt:message key="eMR.generaldiaglist.label" bundle="${mr_labels}"/></option>
								</select>
							</td>
						<%}else{%>
							<td class ='fields' width='13%'></td>
							<td class="fields" width='25%'></td>
						<%}%>

						<td colspan='3' width='50%'></td>
						<td class='fields' width='10%'><input type='button' name='newdiag_btn' id='newdiag_btn' Value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.addnewdiagnosis.label","mr_labels")%>' onclick="AddNewDiagnosis('<%=patient_id%>','<%=encounter_id%>','<%=locn_code%>','<%=gender%>','<%=dob%>','<%=speciality_code%>','<%=episode_id%>','<%=practitioner_id%>','<%=practitioner_type%>','<%=patient_class%>')" /></td>
						<td class='fields' width='34%'><input type='button' name='seq_btn' id='seq_btn' Value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Sequence.label","mr_labels")%>' onclick="sort('PrimaryTab');" <%=dis_seq_btn%>/></td>
					</tr>
				</table>
			</div>
		<%}catch(Exception ex){
				ex.printStackTrace();
		}finally{
			ConnectionManager.returnConnection(conn,request);
			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();

		}
		%>
			<input type='hidden' name='dumy_onset' id='dumy_onset' value="">
			<input type='hidden' name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type='hidden' name="encounter_id" id="encounter_id" value="<%=encounter_id%>">			
			<input type='hidden' name="locn_code" id="locn_code" value="<%=locn_code%>">		
			<input type='hidden' name="gender" id="gender" value="<%=gender%>">			
			<input type='hidden' name="dob" id="dob" value="<%=dob%>">	 				
			<input type='hidden' name="speciality_code" id="speciality_code" value="<%=speciality_code%>">						
			<input type='hidden' name="episode_id" id="episode_id" value="<%=episode_id%>">	
			<input type='hidden' name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>">			
			<input type='hidden' name="practitioner_type" id="practitioner_type" value="<%=practitioner_type%>">		
			<input type='hidden' name="patient_class" id="patient_class" value="<%=patient_class%>">
			<input type='hidden' name="call_from" id="call_from" value="<%=call_from%>">		
			<input type='hidden' name="episode_type" id="episode_type" value="<%=episode_type%>">				
			<input type='hidden' name="mode" id="mode" value="<%=mode%>">
			<input type='hidden' name="temp_code" id="temp_code" value="">				
			<input type='hidden' name="seq_no" id="seq_no" value="<%=j%>">
			<input type='hidden' name="other_cause_death" id="other_cause_death" value="<%=k%>">
			<input type='hidden' name="max_pri_diag" id="max_pri_diag" value="<%=max_pri_diag%>">
			<input type='hidden' name="max_oth_dis" id="max_oth_dis" value="<%=max_oth_dis%>">
			<input type='hidden' name="facility_id" id="facility_id" value="<%=FacilityId%>">
			<input type='hidden' name="totalRecords1" id="totalRecords1" value="<%=totalRecords1%>">
			<input type='hidden' name='currentdate' id='currentdate' value='<%=currentdateTime%>'>
			<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
			<!--Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742-->
			<input type='hidden' name='isDeceasedDiagClassDeathRegAppl' id='isDeceasedDiagClassDeathRegAppl' value='<%=isDeceasedDiagClassDeathRegAppl%>'>
			<input type='hidden' name='primary_diag_class' id='primary_diag_class' value='<%=primary_diag_class%>'>
			<input type='hidden' name='secondary_diag_class' id='secondary_diag_class' value='<%=secondary_diag_class%>'>
			<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script LANGUAGE="JavaScript">
				populateSeqNOs();// To populate Sequence nos this function was used.
				/*
					F.Y.I:
					1.The below function was commented for GAP CRF ADD-SRR20056-CRF-450.xls.
					2.Modified On 1/7/2010 9:37 AM.
				*/
		//		paintValue();// To Paint the Value of the duration of illness this function was used
			</SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		</form>
	</body>
</html>
<%!
		public static String getDesc(String Code,String term_set_id,String occur_srlno,String FacilityId,String patient_id,String encounter_id,HttpServletRequest req){
		Code=checkForNull(Code);
		term_set_id=checkForNull(term_set_id);
		occur_srlno=checkForNull(occur_srlno);
		String short_desc="";
		Connection conn =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try{
		conn = ConnectionManager.getConnection(req);
		String DESC_CODES_SQL="SELECT TERM_CODE_SHORT_DESC FROM PR_DIAGNOSIS_ENC_DTL WHERE TERM_CODE='"+Code+"' AND TERM_SET_ID='"+term_set_id+"' AND OCCUR_SRL_NO='"+occur_srlno+"' AND PATIENT_ID='"+patient_id+"' AND ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID='"+FacilityId+"'  ";
		pstmt=conn.prepareStatement(DESC_CODES_SQL);
		rs=pstmt.executeQuery();
		while(rs.next()){
			short_desc =	checkForNull(rs.getString("TERM_CODE_SHORT_DESC"));
		}

		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();

	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		ConnectionManager.returnConnection(conn,req);

	}
return short_desc;
}
%>
<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


