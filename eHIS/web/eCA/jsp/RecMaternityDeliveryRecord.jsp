<!DOCTYPE html>
<%@page import="java.sql.*, java.io.*, java.util.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
  String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String facility_id       = (String) session.getValue("facility_id");
  Connection con = null; 
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="JavaScript" src ="../../eCA/js/RecMaternityDeliveryRecord.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>		
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>	
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script language='javascript' src='../../eCommon/js/dchk.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>
	<%
			try{
				//String ca_delivery_type="";
				Properties p		= (java.util.Properties) session.getValue("jdbc");
				String  locale = (String) p.getProperty("LOCALE");
				PreparedStatement pstmt		= null;
				ResultSet rs	 =null;
				
				con = ConnectionManager.getConnection();
				ArrayList array_list = new ArrayList();
				
				String mother_patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
				String encounter_id = request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");
				String module_id = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
				String cycle_no = request.getParameter("cycle_no") == null ? "" : request.getParameter("cycle_no");
				String modeValue = request.getParameter("modevalue") == null ? "" : request.getParameter("modevalue");
				
				String splty_event_code = request.getParameter("splty_event_code") == null ? "" : request.getParameter("splty_event_code");
				String splty_task_code = request.getParameter("splty_task_code") == null ? "" : request.getParameter("splty_task_code");
				String patient_class = request.getParameter("patient_class") == null ? "" : request.getParameter("patient_class");
				

				

				String delivery_type = "";
				String attend_pract_id = "";
				String attend_nurse_id = "";
				String proc_classification = "";
				String del_surg_classification = "";
				String vaginal_delivery_type = "";
				String no_of_birth = "";
				String comp_in_del_stage1 = "";
				String comp_in_del_stage2 = "";
				String comp_in_del_stage3 = "";
				String comp_of_delivery = "";
				String foetus_comp_of_delivery = "";
				String finalize_yn = "N";			
				String attend_pract_name = "";
				String attend_nurse_name = "";
				String proc_classification_desc = "";
				String del_surg_classification_desc = "";
				String vaginal_delivery_type_desc = "";							
				String comp_of_delivery_desc = "";
				String foetus_comp_of_delivery_desc = "";			
				String delivery_indicator = "";			
				String disable_delivery_type = "";
				String disable_fields1 = "";
				String disable_fields2 = "";
				String delivery_type1 = "";
				String lmp = "";
				String disableLmp = "";
				String min_gestation = "";
				String max_gestation = "";
				String unit_of_gest_nb = "";
				
				String currentDate = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
				
				try {

				String lmp_Qry = "SELECT DISCR_MSR_VALUE FROM CA_PAT_SPLTY_KEY_MSR WHERE PATIENT_ID = ? AND MODULE_ID = ? AND CYCLE_NO= ? AND EVENT_CODE=? AND DISCR_MSR_ID=? "; 
				//AND ACCESSION_NUM = ?"

				pstmt		=	con.prepareStatement(lmp_Qry);	
				pstmt.setString(1,mother_patient_id);
				pstmt.setString(2,module_id);
				pstmt.setString(3,cycle_no);
				pstmt.setString(4,"MCE004");
				pstmt.setString(5,"MC01LMP");
				rs	 =	pstmt.executeQuery();		

				if(rs.next()){
					lmp =  rs.getString("DISCR_MSR_VALUE") == null?"":rs.getString("DISCR_MSR_VALUE");
					disableLmp = "disabled";
				}

				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();

				String ges_Qry = "SELECT nvl(min_gestation,0) min_gestation, nvl(max_gestation,0) max_gestation,unit_of_gest_nb FROM mp_param_lang_vw WHERE language_id=? and module_id ='MP'"; 				
				

				pstmt		=	con.prepareStatement(ges_Qry);	
				pstmt.setString(1,locale);
				
				rs	 =	pstmt.executeQuery();		

				if(rs.next()){
					min_gestation = rs.getString("min_gestation")==null?"0":rs.getString("min_gestation");
					max_gestation = rs.getString("max_gestation")==null?"0":rs.getString("max_gestation");
					unit_of_gest_nb = rs.getString("unit_of_gest_nb")==null?"0":rs.getString("unit_of_gest_nb");
				}

				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();

			//	String query_section_details="SELECT FACILITY_ID, ENCOUNTER_ID, MOTHER_PATIENT_ID, DELIVERY_TYPE || '$' || (SELECT DELIVERY_INDICATOR FROM MP_NOD_TYPE WHERE NOD_TYPE = DELIVERY_TYPE) DELIVERY_TYPE, ATTEND_PRACT_ID, ATTEND_NURSE_ID, PROC_CLASSIFICATION, DEL_SURG_CLASSIFICATION, VAGINAL_DELIVERY_TYPE, NO_OF_BIRTH, COMP_IN_DEL_STAGE1, COMP_IN_DEL_STAGE2, COMP_IN_DEL_STAGE3, COMP_OF_DELIVERY, FOETUS_COMP_OF_DELIVERY, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, CYCLE_NO, FINALIZE_YN,am_get_desc.AM_PRACTITIONER(ATTEND_PRACT_ID,?,1) ATTEND_PRACT_NAME,am_get_desc.AM_PRACTITIONER(ATTEND_NURSE_ID,?,1) ATTEND_NURSE_NAME,mp_get_desc.MP_PROC_CLASSIFICATION(PROC_CLASSIFICATION,?,2)  PROC_CLASSIFICATION_DESC, mp_get_desc.MP_DELY_SURG_CLFN(DEL_SURG_CLASSIFICATION,?,2) DEL_SURG_CLASSIFICATION_DESC, mp_get_desc.MP_VAGINAL_DELY_TYPE(VAGINAL_DELIVERY_TYPE,?,2) VAGINAL_DELIVERY_TYPE_DESC,mp_get_desc.MP_COMPLN_DELIVERY(COMP_OF_DELIVERY,?,2) COMP_OF_DELIVERY_DESC, mp_get_desc.MP_COMPLN_DELIVERY(FOETUS_COMP_OF_DELIVERY,?,2) FOETUS_COMP_OF_DELIVERY_DESC,(SELECT DELIVERY_INDICATOR FROM MP_NOD_TYPE WHERE NOD_TYPE = DELIVERY_TYPE) DELIVERY_INDICATOR,to_char(LMP,'dd/mm/yyyy') LMP FROM CA_SPL_DELIVERY_RECORD A WHERE A.FACILITY_ID = ?  AND A.MOTHER_PATIENT_ID = ? AND CYCLE_NO = ?";	
				String query_section_details="SELECT FACILITY_ID, ENCOUNTER_ID, MOTHER_PATIENT_ID, DELIVERY_TYPE || '$' || (SELECT DELIVERY_INDICATOR FROM MP_NOD_TYPE WHERE NOD_TYPE = DELIVERY_TYPE) DELIVERY_TYPE, ATTEND_PRACT_ID, ATTEND_NURSE_ID, PROC_CLASSIFICATION, DEL_SURG_CLASSIFICATION, VAGINAL_DELIVERY_TYPE, NO_OF_BIRTH, COMP_IN_DEL_STAGE1, COMP_IN_DEL_STAGE2, COMP_IN_DEL_STAGE3, COMP_OF_DELIVERY, FOETUS_COMP_OF_DELIVERY, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, CYCLE_NO, FINALIZE_YN,am_get_desc.AM_PRACTITIONER(ATTEND_PRACT_ID,?,1) ATTEND_PRACT_NAME,am_get_desc.AM_PRACTITIONER(ATTEND_NURSE_ID,?,1) ATTEND_NURSE_NAME,mp_get_desc.MP_PROC_CLASSIFICATION(PROC_CLASSIFICATION,?,2)  PROC_CLASSIFICATION_DESC, mp_get_desc.MP_DELY_SURG_CLFN(DEL_SURG_CLASSIFICATION,?,2) DEL_SURG_CLASSIFICATION_DESC, mp_get_desc.MP_VAGINAL_DELY_TYPE(VAGINAL_DELIVERY_TYPE,?,2) VAGINAL_DELIVERY_TYPE_DESC,mp_get_desc.MP_COMPLN_DELIVERY(COMP_OF_DELIVERY,?,2) COMP_OF_DELIVERY_DESC, mp_get_desc.MP_COMPLN_DELIVERY(FOETUS_COMP_OF_DELIVERY,?,2) FOETUS_COMP_OF_DELIVERY_DESC,(SELECT DELIVERY_INDICATOR FROM MP_NOD_TYPE WHERE NOD_TYPE = DELIVERY_TYPE) DELIVERY_INDICATOR,to_char(LMP,'dd/mm/yyyy') LMP FROM CA_SPL_DELIVERY_RECORD A WHERE A.MOTHER_PATIENT_ID = ? AND CYCLE_NO = ?";	
				
				pstmt		=	con.prepareStatement(query_section_details);										
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,locale);
				pstmt.setString(4,locale);
				pstmt.setString(5,locale);
				pstmt.setString(6,locale);
				pstmt.setString(7,locale);
			//	pstmt.setString(8,facility_id);
				//pstmt.setString(9,encounter_id);
				pstmt.setString(8,mother_patient_id);
				pstmt.setString(9,cycle_no);
				
				rs	 =	pstmt.executeQuery();		

				if(rs.next())
				{
					delivery_type = rs.getString("DELIVERY_TYPE") == null?"":rs.getString("DELIVERY_TYPE");
					attend_pract_id = rs.getString("ATTEND_PRACT_ID") == null?"":rs.getString("ATTEND_PRACT_ID");
					attend_nurse_id = rs.getString("ATTEND_NURSE_ID") == null?"":rs.getString("ATTEND_NURSE_ID");
					proc_classification = rs.getString("proc_classification") == null?"":rs.getString("proc_classification");
					del_surg_classification = rs.getString("del_surg_classification") == null?"":rs.getString("del_surg_classification");
					vaginal_delivery_type = rs.getString("vaginal_delivery_type") == null?"":rs.getString("vaginal_delivery_type");
					no_of_birth = rs.getString("no_of_birth") == null?"":rs.getString("no_of_birth");
					comp_in_del_stage1 = rs.getString("comp_in_del_stage1") == null?"":rs.getString("comp_in_del_stage1");
					comp_in_del_stage2 = rs.getString("comp_in_del_stage2") == null?"":rs.getString("comp_in_del_stage2");
					comp_in_del_stage3 = rs.getString("comp_in_del_stage3") == null?"":rs.getString("comp_in_del_stage3");
					comp_of_delivery = rs.getString("comp_of_delivery") == null?"":rs.getString("comp_of_delivery");
					foetus_comp_of_delivery = rs.getString("foetus_comp_of_delivery") == null?"":rs.getString("foetus_comp_of_delivery");
					finalize_yn = rs.getString("finalize_yn") == null?"N":rs.getString("finalize_yn");				
					attend_pract_name = rs.getString("attend_pract_name") == null?"":rs.getString("attend_pract_name");
					attend_nurse_name = rs.getString("attend_nurse_name") == null?"":rs.getString("attend_nurse_name");
					proc_classification_desc = rs.getString("proc_classification_desc") == null?"":rs.getString("proc_classification_desc");
					del_surg_classification_desc = rs.getString("del_surg_classification_desc") == null?"":rs.getString("del_surg_classification_desc");
					vaginal_delivery_type_desc = rs.getString("vaginal_delivery_type_desc") == null?"":rs.getString("vaginal_delivery_type_desc");							
					comp_of_delivery_desc = rs.getString("comp_of_delivery_desc") == null?"":rs.getString("comp_of_delivery_desc");
					foetus_comp_of_delivery_desc = rs.getString("foetus_comp_of_delivery_desc") == null?"":rs.getString("foetus_comp_of_delivery_desc");				
					delivery_indicator = rs.getString("delivery_indicator") == null?"":rs.getString("delivery_indicator");				
					lmp = rs.getString("LMP") == null?"":rs.getString("LMP");			
					
				
				}
				if(!lmp.equals(""))
					lmp = com.ehis.util.DateUtils.convertDate(lmp,"DMY","en",locale);

				
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();

				}catch(Exception ee){
					ee.printStackTrace();
				}

				if(!delivery_type.equals(""))
						disable_delivery_type = "disabled";

				if(delivery_indicator.equals("N"))
				{
					disable_fields1 = "disabled";
					disable_fields2 = "";
				}else if(delivery_indicator.equals("C")){
					disable_fields2 = "disabled";
					disable_fields1 = "";				
				}
	%>
		<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
		
		<form name="recMatDeliveryRecordForm" id="recMatDeliveryRecordForm"  method ='post' target='messageFrame' action='../../servlet/eCA.RecMaternityConsServlet'>
		<table border='0' cellspacing='0' cellpadding='3' width='100%' align="grid">
		<tr>
			<td class ='label' width='25%'><fmt:message key="eCA.DeliveryType.label" bundle="${ca_labels}"/></td>
			<td class ='fields' width='25%'>
			<select name ="delivery_type" onChange='enDisCompls(this.value,"Y")' <%=disable_delivery_type%>>
			<option  value="">------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</option>
			<%
				array_list.clear();
				array_list = eMP.NewbornDetails.getNodeTypeShortDesc(con,p);				
				for(int i=0;i<array_list.size();i+=3) {		
					delivery_type1 = (String)array_list.get(i)+"$"+(String)array_list.get(i+2);
					%>			
					<option value='<%=delivery_type1%>' <%if(delivery_type.equals(delivery_type1)){%>selected<%}%>>
						<%=(String) array_list.get(i+1)%>
					</option>
	<%			} %>
			</select><img src="../../eCommon/images/mandatory.gif"></img>
			</td>
		</tr>
		<tr>
			<td class ='label' width='25%'>
					<fmt:message key="eCA.LMP.label" bundle="${ca_labels}"/>&nbsp;&nbsp;&nbsp;
			</td>
			<td class='fields'>
					<input type="text" name="lmp_date" id="lmp_date" value="<%=lmp%>" size="16" maxlength="16" onblur='return checkingDate(this,"DMY","<%=locale%>")' <%=disableLmp%>><img id="common_calander" src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendar('lmp_date');" <%=disableLmp%>><img src="../../eCommon/images/mandatory.gif"></img>
			
			</td>
		</tr>
		<tr>
			<td class ='label' width='25%'><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></td>			
			<td  class='fields'>
				<input type='text' size="25"  name="attend_practid_desc" id="attend_practid_desc"  onBlur='getattndpract();' value="<%=attend_pract_name%>"><input type='button'  name='pract_id_search1' id='pract_id_search1' value='?' class='button'  onClick='callPractSearch(document.recMatDeliveryRecordForm.pract_id_search1,document.recMatDeliveryRecordForm.attend_practid_desc);' >
				<input type='hidden' name="attend_pract_id" id="attend_pract_id" value="<%=attend_pract_id%>">
			</td>
		</tr>
		<tr>
			<td class ='label' width='25%'><fmt:message key="eCA.AttendingNurse.label" bundle="${ca_labels}"/></td>
			<td class ='fields' width='25%'>
				<input type="text" name="att_nurse_newborn" id="att_nurse_newborn" size="25" onblur="attendingNurse(this);" value="<%=attend_nurse_name%>"><input type='button'  name='att_nurse_search' id='att_nurse_search' onClick="attendingNurse(document.recMatDeliveryRecordForm.att_nurse_newborn);" value='?' class='button'>
				<input type=hidden name="attend_nurse_id" id="attend_nurse_id" value ="<%=attend_nurse_id%>">
			</td>
		</tr>
		<tr>
			<td class ='label' width='25%'><fmt:message key="eCA.ProcedureClassification.label" bundle="${ca_labels}"/></td>
			<td class ='fields' width='25%'>
				<input type="text" name="proc_class_desc" id="proc_class_desc" onblur='chkprocclass();' value="<%=proc_classification_desc%>"><input type='button'  name='proc_id' id='proc_id' value='?' class='button' onClick='procClass(proc_id,proc_class_desc);'>
				<input type="hidden" name="proc_classification" id="proc_classification" value="<%=proc_classification%>">
			</td>
		</tr>
		<tr>
			<td class ='label' width='25%'><fmt:message key="eCA.DeliverySurgicalClassification.label" bundle="${ca_labels}"/></td>
			<td class ='fields' width='25%'>
				<input type="text" name="del_serv_desc" id="del_serv_desc" onblur='chkdelsurgclass();' value="<%=del_surg_classification_desc%>"><input type='button'  name='del_serv_id' id='del_serv_id' value='?' class='button' onClick='delSurgClass(del_serv_id,del_serv_desc);' onKeyPress='delSurgClass(del_serv_id,del_serv_desc);' >
				<input type="hidden" name="del_surg_classification" id="del_surg_classification" value ="<%=del_surg_classification%>">
			</td>
		</tr>
		<tr>
			<td class ='label' width='25%'><fmt:message key="eCA.VaginalDeliveryType.label" bundle="${ca_labels}"/></td>
			<td class ='fields' width='25%'>
				<input type="text" name="vaginal_del_type_desc" id="vaginal_del_type_desc" onblur='chkvagclass();' value="<%=vaginal_delivery_type_desc%>" <%=disable_fields1%>><input type='button' name='vaginal_del_type_search' id='vaginal_del_type_search' value='?' class='button' <%=disable_fields1%> onClick='vagClass(vaginal_del_type_search, vaginal_del_type_desc);' onkeypress='vagClass(vaginal_del_type_search, vaginal_del_type_desc);' >
				<input type='hidden' name="vaginal_delivery_type" id="vaginal_delivery_type" value ="<%=vaginal_delivery_type%>">
			</td>
		</tr>
		<tr>
			<td class ='label' width='25%'><fmt:message key="eCA.NoofBirth.label" bundle="${ca_labels}"/></td>
			<td class ='fields' width='25%'>
			<input type='text'  name='no_of_birth' id='no_of_birth' size='1' maxlength='1' onKeyPress="return allowValidNumberLocal(this, event,1,0) " value='<%=no_of_birth%>' ><img src="../../eCommon/images/mandatory.gif" align="center" id='final_mand' style='display:none' >
			</td>
		</tr>

		<tr>
			<td class ='label' width='25%'><fmt:message key="eCA.ComplicationinStage1ofDelivery.label" bundle="${ca_labels}"/></td>
			<td class ='fields' width='25%'>
			<select name ="comp_in_del_stage1"  <%=disable_fields2%>>
			<option  value="">------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</option>
			<%
						array_list.clear();
						array_list = eMP.NewbornDetails.getComplnsLabourCodeDesc(con,p,"First");
						
						for(int i=0;i<array_list.size();i+=2) 
					{%>
							<option value="<%=(String)array_list.get(i)%>" <%if(comp_in_del_stage1.equals(((String)array_list.get(i)))){%>selected<%}%>><%=(String) array_list.get(i+1)%></option>
		<%			}
					%>
			</select>
			</td>
		</tr>

		<tr>
			<td class ='label' width='25%'><fmt:message key="eCA.ComplicationinStage2ofDelivery.label" bundle="${ca_labels}"/></td>
			<td class ='fields' width='25%'>
			<select name ="comp_in_del_stage2"  <%=disable_fields2%>>
			<option  value="">------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</option>
			<%
						array_list.clear();
						array_list = eMP.NewbornDetails.getComplnsLabourCodeDesc(con,p,"Second");
						
						for(int i=0;i<array_list.size();i+=2) { %>
							<option value="<%=(String)array_list.get(i)%>" <%if(comp_in_del_stage2.equals(((String)array_list.get(i)))){%>selected<%}%>><%=(String) array_list.get(i+1)%></option>
	<%					}
					%>
			</select>
			</td>
		</tr>
		<tr>
			<td class ='label' width='25%'><fmt:message key="eCA.ComplicationinStage3ofDelivery.label" bundle="${ca_labels}"/></td>
			<td class ='fields' width='25%'>
			<select name ="comp_in_del_stage3"  <%=disable_fields2%>>
			<option  value="">------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</option>
			<%
						array_list.clear();
						array_list = eMP.NewbornDetails.getComplnsLabourCodeDesc(con,p,"Third");
						
						for(int i=0;i<array_list.size();i+=2) { %>
							<option value="<%=(String)array_list.get(i)%>"  <%if(comp_in_del_stage3.equals(((String)array_list.get(i)))){%>selected<%}%>><%=(String) array_list.get(i+1)%></option>
	<%					}
					%>
			</select>
			</td>
		</tr>
		<tr>
			<td class ='label' width='25%'><fmt:message key="eCA.ComplicationofDelivery.label" bundle="${ca_labels}"/></td>
			<td class ='fields' width='25%'>
				<input type="text" name="comple_ofdel_newborn" id="comple_ofdel_newborn" <%=disable_fields1%>  onblur="compDelievary1(this,'comple_of_button');" value="<%=comp_of_delivery_desc%>"><input type='button'  name='comple_of_button' id='comple_of_button' <%=disable_fields1%> onClick="compDelievary(document.recMatDeliveryRecordForm.comple_ofdel_newborn,'comple_of_button');" value='?'  class='button'  onClick='' >
				<input type=hidden name="comp_of_delivery" id="comp_of_delivery" value ="<%=comp_of_delivery%>">	
			</td>
		</tr>
		<tr>
			<td class ='label' width='25%'><fmt:message key="eCA.FoetusComplicationofDelivery.label" bundle="${ca_labels}"/></td>
			<td class ='fields' width='25%'>
				<input type="text" name="foetus_comple_ofdel_newborn" id="foetus_comple_ofdel_newborn" value ="<%=foetus_comp_of_delivery_desc%>"  onblur="compDelievary1(this,'foetus_comple_of_button');"><input type='button'  name='foetus_comple_of_button' id='foetus_comple_of_button' onClick="compDelievary(document.recMatDeliveryRecordForm.foetus_comple_ofdel_newborn,'foetus_comple_of_button');" value='?'  class='button'  onClick='' >
				<input type=hidden name="foetus_comp_of_delivery" id="foetus_comp_of_delivery" value ="<%=foetus_comp_of_delivery%>">	
			</td>
		</tr>
		<tr>
			<td class ='label' width='25%'><fmt:message key="Common.Finalize.label" bundle="${common_labels}"/></td>
			<td class ='fields' width='25%'>
				<input type="checkbox" name="finalize_yn" id="finalize_yn" value="<%=finalize_yn%>" onClick="setFinalizeValue(this)" <%if(finalize_yn.equals("Y")){%>checked<%}%>>
			</td>
		</tr>
		</table>		
		<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
		<input type='hidden' name='mother_patient_id' id='mother_patient_id' value="<%=mother_patient_id%>">
		<input type='hidden' name='encounter_id' id='encounter_id' value="<%=encounter_id%>">
		<input type='hidden' name='module_id' id='module_id' value="<%=module_id%>">
		<input type='hidden' name='cycle_no' id='cycle_no' value="<%=cycle_no%>">
		<input type='hidden' name='delivery_record' id='delivery_record' value="DeliverRecord">
		<input type='hidden' name='modeValue' id='modeValue' value="<%=modeValue%>">
		<input type='hidden' name='min_gestation' id='min_gestation' value="<%=min_gestation%>">
		<input type='hidden' name='max_gestation' id='max_gestation' value="<%=max_gestation%>">
		<input type='hidden' name='unit_of_gest_nb' id='unit_of_gest_nb' value="<%=unit_of_gest_nb%>">
		<input type='hidden' name='currentDate' id='currentDate' value="<%=currentDate%>">
		<input type='hidden' name='locale' id='locale' value="<%=locale%>">
		<input type='hidden' name='splty_event_code' id='splty_event_code' value="<%=splty_event_code%>">
		<input type='hidden' name='splty_task_code' id='splty_task_code' value="<%=splty_task_code%>">
		<input type='hidden' name='patient_class' id='patient_class' value="<%=patient_class%>">
		</form>
		</body>
	<%}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(con!=null) ConnectionManager.returnConnection(con);
			
		}%>
		</html>

