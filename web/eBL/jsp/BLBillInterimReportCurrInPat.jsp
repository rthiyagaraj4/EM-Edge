<!DOCTYPE html>
<%@ page  import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" 			contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null ;
	Statement stmt1				= null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	ResultSet rs3 = null;
	ResultSet rs4 = null;
	String locale="";
	String p_facility_id="";
	//int totalRecords=0; 
	String classval="";
	int total_records=0;
	String p_from_nursing_unit_code="",p_to_nursing_unit_code="",p_from_adm_no="",p_to_adm_no="";
	String strFacilityId="",strCurWardCode="",strTotUnadjDepAmt="",strCurBedClassCode="";//strInhBillgenDate="",strCurBedClassCode="";
	String p_payer_code="";
	String p_patient_id="";
	String p_payer_type="";
	String p_pay_amt_exce="";
	String strPatientId=""; String strPatientName=""; String strPatientNameLocLang="";
	String strEpisodeType=""; String strOpenEpisodeId=""; String strAdmDateTime="";
	String strCurrRoomNum=""; String strCurrBedNum=""; String strCustCode="";
	String strUnBldAmt=""; String strOutstdAmt="";String strTotAmt="";String str_no_of_deci="",strPolicyTypeCode="",strCustDesc="",strPolicyDesc="",strLastBedChargeDate="",strBlngGrpId="",blng_grp_desc="";
	String int_bill_gen_freq="";//int count=0;
	int  no_of_decimals=0;
	String sys_date="";
	boolean searched = (request.getParameter("searched") == null) ?false:true;	
	
	try
	{	
		HttpSession httpSession = request.getSession(false);
		//Properties p = (Properties)httpSession.getValue("jdbc");	
		con	=	ConnectionManager.getConnection(request);		
		locale	= (String)session.getAttribute("LOCALE");
		p_facility_id = (String)httpSession.getValue("facility_id");
		p_from_nursing_unit_code=request.getParameter("from_nursing_unit_code");
		if(p_from_nursing_unit_code==null || p_from_nursing_unit_code.equals("")) p_from_nursing_unit_code="";		
		p_to_nursing_unit_code=request.getParameter("to_nursing_unit_code");
		if(p_to_nursing_unit_code==null || p_to_nursing_unit_code.equals("")) p_to_nursing_unit_code="";
		p_from_adm_no=request.getParameter("from_adm_no");
		if(p_from_adm_no==null || p_from_adm_no.equals("")) p_from_adm_no="";
		p_to_adm_no=request.getParameter("to_adm_no");
		if(p_to_adm_no==null || p_to_adm_no.equals("")) p_to_adm_no="";
//		System.out.println("p_from_nursing_unit_code"+p_from_nursing_unit_code);
//		System.out.println("p_to_nursing_unit_code"+p_to_nursing_unit_code);
//		System.out.println("p_from_adm_no"+p_from_adm_no);
//		System.out.println("p_to_adm_no"+p_to_adm_no);
		p_payer_code=request.getParameter("payer_code");
		if(p_payer_code==null || p_payer_code.equals("")) p_payer_code="";
		p_patient_id=request.getParameter("patient_id");
		if(p_patient_id==null || p_patient_id.equals("")) p_patient_id="";
		p_payer_type=request.getParameter("payer_type");
		if(p_payer_type==null || p_payer_type.equals("")) p_payer_type="";
		p_pay_amt_exce=request.getParameter("pay_amt_exce");
		if(p_pay_amt_exce==null || p_pay_amt_exce.equals("")) p_pay_amt_exce="";
		str_no_of_deci=request.getParameter("no_of_deci");
		if(str_no_of_deci==null || str_no_of_deci.equals("")) str_no_of_deci="";
		no_of_decimals=Integer.parseInt(str_no_of_deci);		
		int_bill_gen_freq=request.getParameter("int_bill_gen_freq");
		if(int_bill_gen_freq==null) int_bill_gen_freq="";
	}
	catch(Exception eX)
	{	
		out.println("Error= "+eX);			
	}

%>
<HTML>
	<HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>	
		<!-- Added By Rajesh V -->
		<script language='javascript' src='../js/BLInterimBillReport.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



		<!-- Added By Rajesh V -->
		<style>
		thead td, thead td.locked	{
		background-color: navy;
		color: white;
		position:relative;}	
		thead td {
		top: expression(document.getElementById("tbl-container").scrollTop-4); 
		z-index: 20;}
		thead td.locked {z-index: 30;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative;
		z-index: 10;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative;
		z-index: 10;}

		TD.YELLOW 
		{
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			border-style: dashed;
			border-left-color: #D5E2E5;
			border-right-color: #D5E2E5;
			border-top-color: #D5E2E5;
			border-bottom-color: #D5E2E5; 
		}
		</style>
	</HEAD> 

	<script>
		function selected(i)
		{				
			var selected_row=eval("document.forms[0].selected_row"+i);		
			if(selected_row.checked==false)
			{	
			selected_row.checked=false;
			document.resultForm.checked_row.value="";				
			}
			else
			{					
				var total_records=document.forms[0].total_records.value;					
				for(var j=0;j<total_records;j++)
				{ 
					var temp=eval("document.resultForm.selected_row"+j);					
					temp.checked=false;
		        }
			selected_row.checked=true;				
			document.forms[0].checked_row.value=i;
			}
			if(selected_row.checked)
			{
			  selected_row.value="1";	
			}
			else
			{
				selected_row.value="1";	
			}
		}	

		function no_record_check()
		{
			var total_records=document.forms[0].total_records.value;
			if(total_records==0)
			{
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
//				history.go(-1);
				document.location.href="../../eCommon/html/blank.html";
				//parent.frames[1].document.forms[0].compute_bed_charge_flag.value='';
				parent.frames[1].document.forms[0].submit_but.disabled=true;

			}
			parent.frames[0].document.forms[0].total_records.value=total_records;
			
		}

		function assign_value()
		{
			parent.frames[0].document.forms[0].group_by.value = document.forms[0].group_by.value;
		}

	</script>
	
	
	<body onLoad="no_record_check();" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 					      					  onSelect="codeArrestThruSelect();">
	<form name='resultForm' id='resultForm' method='post' action='../../servlet/eBL.BLInterimBillBedChargeComputeServlet' scrolling=no target='dummy_frame'>	
	
<%
		try
		{
			System.out.println("163");//lakshmi
/*
			String query_refresh="SELECT a.facility_id FACILITY_ID, a.patient_id PATIENT_ID, patient_name PATIENT_NAME, patient_name_loc_lang PATIENT_NAME_LOC_LANG, b.episode_type EPISODE_TYPE, open_episode_id OPEN_EPISODE_ID,to_char(a.admission_date_time,'DD/MM/YYYY HH24:MI:SS') admission_date_time, cur_ward_code CUR_WARD_CODE, cur_room_num CUR_ROOM_NUM,cur_bed_num CUR_BED_NUM, cur_bed_class_code CUR_BED_CLASS_CODE, a.cust_code CUST_CODE, a.policy_type_code POLICY_TYPE_CODE, NVL (unbld_amt, 0) UNBLD_AMT,NVL (outst_amt, 0) OUTST_AMT,NVL (unbld_amt, 0) + NVL (outst_amt, 0) TOTAL,DECODE (a.policy_type_code, NULL, (NVL (b.tot_unadj_dep_amt, 0)+nvl(b.TOT_UNADJ_PREP_AMT,0)), 0) TOT_UNADJ_DEP_AMT, to_char(b.LAST_BED_BILL_DATE_TIME ,'DD/MM/YYYY HH24:MI:SS') LAST_BED_CHARGE_COMPUTATION,a.BLNG_GRP_ID BILLING_GRP_ID FROM bl_unbld_outst_vw a, bl_episode_fin_dtls b WHERE a.facility_id = b.operating_facility_id  AND a.open_episode_id = b.episode_id AND NOT EXISTS (SELECT 'x' FROM ip_discharge_advice_his_vw b  WHERE a.facility_id = b.facility_id AND a.open_episode_id = b.episode_id AND NVL (dis_adv_status, ' ') != '9') and a.facility_id = '"+p_facility_id+"' AND cur_ward_code BETWEEN NVL ('"+p_from_nursing_unit_code+"', '!!!!') AND NVL ('"+p_to_nursing_unit_code+"', '~~~~')  AND open_episode_id BETWEEN NVL ('"+p_from_adm_no+"', 0) AND NVL ('"+p_to_adm_no+"', 999999999999) AND ((NVL ('"+p_payer_type+"', 'I') = 'P' AND a.cust_code IS NULL) OR  (NVL ('"+p_payer_type+"', 'I') = 'I'  AND a.cust_code IS NOT NULL AND a.cust_code = NVL ('"+p_payer_code+"', a.cust_code)) OR  (NVL ('"+p_payer_type+"', 'I') = 'B') ) AND NVL(UNBLD_AMT,0)+ NVL(OUTST_AMT,0)-DECODE(a.POLICY_TYPE_CODE,NULL,(NVL(b.TOT_UNADJ_DEP_AMT,0)+NVL(b.TOT_UNADJ_PREP_AMT,0)),0)>NVL('"+p_pay_amt_exce+"',0) ORDER BY patient_id";
*/
			/* The below query is commented and replaced with a new query by karthik on 8/July/2013 for AMS-CRF-0047 */
			/*
			String query_refresh="SELECT a.facility_id FACILITY_ID, a.patient_id PATIENT_ID, patient_name PATIENT_NAME, patient_name_loc_lang PATIENT_NAME_LOC_LANG, b.episode_type EPISODE_TYPE, open_episode_id OPEN_EPISODE_ID,to_char(a.admission_date_time,'DD/MM/YYYY HH24:MI:SS') admission_date_time, cur_ward_code CUR_WARD_CODE, cur_room_num CUR_ROOM_NUM,cur_bed_num CUR_BED_NUM, cur_bed_class_code CUR_BED_CLASS_CODE, a.cust_code CUST_CODE, a.policy_type_code POLICY_TYPE_CODE, NVL (unbld_amt, 0) UNBLD_AMT,NVL (outst_amt, 0) OUTST_AMT,NVL (unbld_amt, 0) + NVL (outst_amt, 0) TOTAL,DECODE (a.policy_type_code, NULL, (NVL (b.tot_unadj_dep_amt, 0)+nvl(b.TOT_UNADJ_PREP_AMT,0)), 0) TOT_UNADJ_DEP_AMT, to_char(b.LAST_BED_BILL_DATE_TIME ,'DD/MM/YYYY HH24:MI:SS') LAST_BED_CHARGE_COMPUTATION,a.BLNG_GRP_ID BILLING_GRP_ID FROM bl_unbld_outst_vw a, bl_episode_fin_dtls b WHERE a.facility_id = b.operating_facility_id  AND a.open_episode_id = b.episode_id AND NOT EXISTS (SELECT 'x' FROM ip_discharge_advice_his_vw b  WHERE a.facility_id = b.facility_id AND a.open_episode_id = b.episode_id AND NVL (dis_adv_status, ' ') != '9') and a.facility_id = '"+p_facility_id+"' AND cur_ward_code BETWEEN NVL ('"+p_from_nursing_unit_code+"', '!!!!') AND NVL ('"+p_to_nursing_unit_code+"', '~~~~')  AND open_episode_id BETWEEN NVL ('"+p_from_adm_no+"', 0) AND NVL ('"+p_to_adm_no+"', 999999999999) AND ((NVL ('"+p_payer_type+"', 'I') = 'P' AND a.cust_code IS NULL) OR  (NVL ('"+p_payer_type+"', 'I') = 'I'  AND a.cust_code IS NOT NULL AND a.cust_code = NVL ('"+p_payer_code+"', a.cust_code)) OR  (NVL ('"+p_payer_type+"', 'I') = 'B') ) ORDER BY patient_id";
			*/
			
			String query_refresh=
				" SELECT a.facility_id facility_id, a.patient_id patient_id, patient_name patient_name, "+
		                  " patient_name_loc_lang patient_name_loc_lang, b.episode_type episode_type, open_episode_id open_episode_id, "+
		                  " TO_CHAR (a.admission_date_time,'DD/MM/YYYY HH24:MI:SS') admission_date_time, cur_ward_code cur_ward_code, "+
		                  " cur_room_num cur_room_num, cur_bed_num cur_bed_num, cur_bed_class_code cur_bed_class_code, a.cust_code cust_code, "+
		                  " a.policy_type_code policy_type_code,  "+
		                  " NVL (unbld_amt, 0) unbld_amt, NVL (outst_amt, 0) outst_amt, "+
		                  " NVL (unbld_amt, 0) + NVL (outst_amt, 0) total, "+
		                  " DECODE (a.policy_type_code, "+
		                          " NULL, NVL (b.tot_unadj_dep_amt, 0), "+
		                          " 0 "+
		                         " ) tot_unadj_dep_amt, "+
		                  " TO_CHAR (b.last_bed_bill_date_time, "+
		                  " 'DD/MM/YYYY HH24:MI:SS' "+
		                 " ) last_bed_charge_computation, a.blng_grp_id billing_grp_id "+
		             " FROM bl_unbld_outst_vw a, "+
		                  " bl_episode_fin_dtls b, "+
		                  " bl_encounter_payer_priority c "+
		            " WHERE a.facility_id = b.operating_facility_id "+
		              " AND a.open_episode_id = b.episode_id "+
		              " AND b.operating_facility_id = c.operating_facility_id "+
		              " AND b.episode_id = c.episode_id "+
		              " AND b.cur_acct_seq_no = c.acct_seq_no "+
		              " AND c.blng_grp_id = a.blng_grp_id "+
		              " AND NVL (a.cust_code, '!!!') = NVL (c.cust_code, '!!!') "+
		              " AND NVL (a.policy_type_code, '!!!') = "+
		                   " NVL (c.policy_type_code, '!!!') "+
		              " AND facility_id = '"+p_facility_id+"' "+
		              " AND cur_ward_code BETWEEN NVL ('"+p_from_nursing_unit_code+"', '!!!!') AND NVL ('"+p_to_nursing_unit_code+"', "+
		                                                                    " '~~~~' "+
		                                                                   " ) "+
		              " AND open_episode_id BETWEEN NVL ('"+p_from_adm_no+"', 0) AND NVL ('"+p_to_adm_no+"', "+
		                                                               " 999999999999 "+
		                                                              " ) "+
		              " AND (   (NVL ('"+p_payer_type+"', 'I') = 'P' AND a.cust_code IS NULL) "+
		                   " OR (    NVL ('"+p_payer_type+"', 'I') = 'I' "+
		                       " AND a.cust_code IS NOT NULL "+
		                       " AND a.cust_code = NVL ('"+p_payer_code+"', a.cust_code) "+
		                      " ) "+
		                   " OR (NVL ('"+p_payer_type+"', 'I') = 'B') "+
		                  " ) "+
		              " AND NVL (unbld_amt, 0) + NVL (outst_amt, 0) >= "+
		                              " NVL ('', NVL (unbld_amt, 0) + NVL (outst_amt, 0)) "+
		              " AND (   (    'N' = NVL ('N', 'N') "+
		                       " AND NOT EXISTS ( "+
		                              " SELECT 'x' "+
		                                " FROM ip_discharge_advice_his_vw b "+
		                               " WHERE facility_id = b.facility_id "+
		                                 " AND open_episode_id = b.episode_id "+
		                                 " AND NVL (dis_adv_status, ' ') != '9') "+
		                      " ) "+
		                   " OR (    'Y' = NVL ('N', 'N') "+
		                       " AND EXISTS ( "+
		                              " SELECT 'x' "+
		                                " FROM ip_discharge_advice_his_vw b "+
		                               " WHERE facility_id = b.facility_id "+
		                                 " AND open_episode_id = b.episode_id "+
		                                 " AND NVL (dis_adv_status, ' ') != '9') "+
		                      " ) "+
		                  " ) "+
		          " UNION ALL "+
		          " (SELECT a.facility_id facility_id, a.patient_id patient_id, patient_name patient_name, "+
		                  " patient_name_loc_lang patient_name_loc_lang, b.episode_type episode_type, open_episode_id open_episode_id, "+
		                  " TO_CHAR (a.admission_date_time,'DD/MM/YYYY HH24:MI:SS') admission_date_time, cur_ward_code cur_ward_code, "+
		                  " cur_room_num cur_room_num, cur_bed_num cur_bed_num, cur_bed_class_code cur_bed_class_code, c.cust_code cust_code, "+
		                  " c.policy_type_code policy_type_code, "+
		                    " 0 unbld_amt, "+
		                  " 0 outst_amt, 0 total, "+
		                  " DECODE (c.policy_type_code, "+
		                          " NULL, NVL (b.tot_unadj_dep_amt, 0), "+
		                          " 0 "+
		                         " ) tot_unadj_dep_amt, "+
						" TO_CHAR (b.last_bed_bill_date_time, "+
							" 'DD/MM/YYYY HH24:MI:SS' "+
							" ) last_bed_charge_computation, c.blng_grp_id billing_grp_id "+
		             " FROM ip_open_episode a, "+
		                  " bl_episode_fin_dtls b, "+
		                  " bl_encounter_payer_priority c, "+
		                  " mp_patient d "+
		            " WHERE a.facility_id = b.operating_facility_id "+
		              " AND a.open_episode_id = b.episode_id "+
		              " AND b.operating_facility_id = c.operating_facility_id "+
		              " AND b.episode_id = c.episode_id "+
		              " AND b.cur_acct_seq_no = c.acct_seq_no "+
		              " AND NOT EXISTS (SELECT 1 "+
		                                " FROM bl_unbld_outst_vw e "+
		                               " WHERE e.open_episode_id = a.open_episode_id) "+
		              " AND a.patient_id = d.patient_id "+
		              " AND facility_id = '"+p_facility_id+"' "+
		              " AND cur_ward_code BETWEEN NVL ('"+p_from_nursing_unit_code+"', '!!!!') AND NVL ('"+p_to_nursing_unit_code+"', "+
		                                                                    " '~~~~' "+
		                                                                   " ) "+
		              " AND open_episode_id BETWEEN NVL ('"+p_from_adm_no+"', 0) AND NVL ('"+p_to_adm_no+"', "+
		                                                               " 999999999999 "+
		                                                              " ) "+
		              " AND (   (NVL ('"+p_payer_type+"', 'I') = 'P' AND c.cust_code IS NULL) "+
		                   " OR (    NVL ('"+p_payer_type+"', 'I') = 'I' "+
		                       " AND c.cust_code IS NOT NULL "+
		                       " AND c.cust_code = NVL ('"+p_payer_code+"', c.cust_code) "+
		                      " ) "+
		                   " OR (NVL ('"+p_payer_type+"', 'I') = 'B') "+
		                  " ) "+
		              " AND (   (    'N' = NVL ('N', 'N') "+
		                       " AND NOT EXISTS ( "+
		                              " SELECT 'x' "+
		                                " FROM ip_discharge_advice_his_vw b "+
		                               " WHERE facility_id = b.facility_id "+
		                                 " AND open_episode_id = b.episode_id "+
		                                 " AND NVL (dis_adv_status, ' ') != '9') "+
		                      " ) "+
		                   " OR (    'Y' = NVL ('N', 'N') "+
		                       " AND EXISTS ( "+
		                              " SELECT 'x' "+
		                                " FROM ip_discharge_advice_his_vw b "+
		                               " WHERE facility_id = b.facility_id "+
		                                 " AND open_episode_id = b.episode_id "+
		                                 " AND NVL (dis_adv_status, ' ') != '9') "+
		                      " ) "+
		                  " ))	";						  
			
			System.err.println("query_refresh :" +query_refresh);
		
			HashMap sqlMap = new HashMap();

			sqlMap.put("sqlData",query_refresh);
			HashMap funcMap = new HashMap();
			ArrayList displayFields = new ArrayList();
			ArrayList chkFields = new ArrayList();
			displayFields.add("FACILITY_ID");			
			displayFields.add("PATIENT_ID");
			displayFields.add("PATIENT_NAME");
			displayFields.add("PATIENT_NAME_LOC_LANG");
			displayFields.add("EPISODE_TYPE");						
			displayFields.add("OPEN_EPISODE_ID");						
			displayFields.add("admission_date_time");						
			displayFields.add("CUR_WARD_CODE");						
			displayFields.add("CUR_ROOM_NUM");						
			displayFields.add("CUR_BED_NUM");						
			displayFields.add("CUR_BED_CLASS_CODE");						
			displayFields.add("CUST_CODE");						
			displayFields.add("POLICY_TYPE_CODE");						
			//displayFields.add("inh_bill_gen_date");						
			displayFields.add("UNBLD_AMT");						
			displayFields.add("OUTST_AMT");						
			displayFields.add("TOTAL");						
			displayFields.add("TOT_UNADJ_DEP_AMT");
			displayFields.add("LAST_BED_CHARGE_COMPUTATION");
			displayFields.add("BILLING_GRP_ID");
						
			// Adding function related array list into the HashMap
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			System.out.println("resutl==>"+result);
			//out.println("resutl==>"+result.size());
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))) 
			{
%>
		<div>
			<table  cellpadding='3' cellspacing='0' align = 'center' id='bill_interim_det' width='100%'>			
			<tr>
				<td class="label" colspan="7"><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
				<td class="fields" colspan="7">
					<select name='group_by' id='group_by' value="" onChange='assign_value();'>
						<option value='B'><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></option>
						<option value='C'><fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}"/></option>
					</select>
				</td>
			</tr>
			<tr>			 
<%			// commented by DhanasekarV against 43674	out.println(result.get(1));
//				System.out.println("resutl==>"+result.get(1));
%>
				</td> 
			</tr>
			</table> 
		</div>	
		<div>
			<table  cellpadding='3' cellspacing='0' align = 'center' id='bill_interim_det' width='100%'>			
			<tr>
				<td class="COLUMNHEADER" colspan="14"><fmt:message key="eBL.CURR_IPS.label"  bundle="${bl_labels}"/></td>
			</tr>
			<tr>			 
<%				out.println(result.get(1));
//				System.out.println("resutl==>"+result.get(1));
%>
				</td> 
			</tr>
			</table> 
		</div>
		
		<div id="tbl-container" STYLE="overflow: auto; width: 100%; height: 390px;   padding:3px; margin: 0px">
			<table border='' cellpadding='3' cellspacing='0'  id='tbl' width='100%'>	
			<thead>
			<tr>
				<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
				<td width="5%" class='COLUMNHEADER'><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>	
				<td width="10%" class='COLUMNHEADER'><fmt:message key="Common.AdmissionNo.label" bundle="${common_labels}"/></td>		
				<td width="5%" class='COLUMNHEADER'><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></td>	
				<td width="10%" class='COLUMNHEADER'><fmt:message key="eBL.LAST_BED_CHARGE_DATE.label" bundle="${bl_labels}"/></td>		
				<td width="5%" class='COLUMNHEADER'><fmt:message key="Common.Ward.label" bundle="${common_labels}"/></td>				
				<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/> </td>
				<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='5%'><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='5%'><fmt:message key="eBL.UNBILLED_AMT.label" bundle="${bl_labels}"/></td>	
				<td width="5%" class='COLUMNHEADER'><fmt:message key="eBL.UNADJUST_AMT.label" bundle="${bl_labels}"/></td>		
				<td class='COLUMNHEADER' width='5%'><fmt:message key="eBL.OUTSTANDING_BILLED_AMT.label" bundle="${bl_labels}"/></td> <!--22-09-2020-->	
				<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.total.label" bundle="${common_labels}"/></td>
			</tr>
			</thead>
<%				int i=1;	//Modified by Rajesh V from 0 to 1
				ArrayList records=new ArrayList();
				for(int j=2; j<result.size(); j++)
				{			
					if(i % 2 == 0 )
					{
						classval	=	"QRYEVEN";
					}
					else
					{
						classval	=	"QRYODD";
					}
					records=(ArrayList) result.get(j);
						//System.out.println("@@==>"+records);						
					strFacilityId=(String)records.get(0);
					if ( strFacilityId== null || strFacilityId.equalsIgnoreCase("null")){
							strFacilityId="";}

					strPatientId=(String)records.get(1);
					if ( strPatientId== null || strPatientId.equalsIgnoreCase("null")){
							strPatientId="";}
//					System.out.println("strPatientId=@@==>"+strPatientId);

					strPatientName=(String)records.get(2);
					if ( strPatientName== null || strPatientName.equalsIgnoreCase("null")){
							strPatientName="";}
//					System.out.println("strPatientName=@@==>"+strPatientName);					
					
					strPatientNameLocLang=(String)records.get(3);
					if ( strPatientNameLocLang== null || strPatientNameLocLang.equalsIgnoreCase("null")){
						strPatientNameLocLang="";}
//					System.out.println("strPatientNameLocLang=@@==>"+strPatientNameLocLang);
					strEpisodeType=(String)records.get(4);
					if ( strEpisodeType== null || strEpisodeType.equalsIgnoreCase("null")){
						strEpisodeType="";}
//					System.out.println("strEpisodeType=@@==>"+strEpisodeType);
					strOpenEpisodeId=(String)records.get(5);
					if ( strOpenEpisodeId== null || strOpenEpisodeId.equalsIgnoreCase("null")){
						strOpenEpisodeId="";}
//						System.out.println("strOpenEpisodeId=@@==>"+strOpenEpisodeId);
					strAdmDateTime=(String)records.get(6);
					if ( strAdmDateTime== null || strAdmDateTime.equalsIgnoreCase("null")){
						strAdmDateTime="";}
//					System.out.println("strAdmDateTime=@@==>"+strAdmDateTime);

					strCurWardCode=(String)records.get(7);
					if ( strCurWardCode== null || strCurWardCode.equalsIgnoreCase("null")){
						strCurWardCode="";}
//					System.out.println("strCurWardCodee=@@==>"+strCurWardCode);

					strCurrRoomNum=(String)records.get(8);
					if ( strCurrRoomNum== null || strCurrRoomNum.equalsIgnoreCase("null")){
						strCurrRoomNum="";}
//					System.out.println("strCurrRoomNum=@@==>"+strCurrRoomNum);
					strCurrBedNum=(String)records.get(9);
					if ( strCurrBedNum== null || strCurrBedNum.equalsIgnoreCase("null")){
						strCurrBedNum="";}
//					System.out.println("strCurrBedNum=@@==>"+strCurrBedNum);

					strCurBedClassCode=(String)records.get(10);
					if ( strCurBedClassCode== null || strCurBedClassCode.equalsIgnoreCase("null")){
						strCurBedClassCode="";}
//					System.out.println("strCurBedClassCode=@@==>"+strCurBedClassCode);

					strCustCode=(String)records.get(11);
					if ( strCustCode== null || strCustCode.equalsIgnoreCase("null")){
						strCustCode="";}
//					System.out.println("strCustCode=@@==>"+strCustCode);

					strPolicyTypeCode=(String)records.get(12);
					if ( strPolicyTypeCode== null || strPolicyTypeCode.equalsIgnoreCase("null")){
						strPolicyTypeCode="";}
//					System.out.println("strPolicyTypeCode=@@==>"+strPolicyTypeCode);
					
					/*strInhBillgenDate=(String)records.get(13);
					if ( strInhBillgenDate== null || strInhBillgenDate.equalsIgnoreCase("null")){
						strInhBillgenDate="";}
					System.out.println("strInhBillgenDate=@@==>"+strInhBillgenDate);*/
					
					strUnBldAmt=(String)records.get(13);
					if ( strUnBldAmt== null || strUnBldAmt.equalsIgnoreCase("null")){
					strUnBldAmt="";}
					System.out.println("strUnBldAmt=@@==>"+strUnBldAmt);//lakshmi
					strOutstdAmt=(String)records.get(14);
					if ( strOutstdAmt== null || strOutstdAmt.equalsIgnoreCase("null")){
						strOutstdAmt="";}
//					System.out.println("strOutstdAmt=@@==>"+strOutstdAmt);
					strTotAmt=(String)records.get(15);
					if ( strTotAmt== null || strTotAmt.equalsIgnoreCase("null")){
						strTotAmt="";}
					System.out.println("strTotAmt=@@==>"+strTotAmt);//lakshmi

					strTotUnadjDepAmt=(String)records.get(16);
					if ( strTotUnadjDepAmt== null || strTotUnadjDepAmt.equalsIgnoreCase("null")){
						strTotUnadjDepAmt="";}
//					System.out.println("strTotUnadjDepAmt=@@==>"+strTotUnadjDepAmt);

					strLastBedChargeDate=(String)records.get(17);
					if ( strLastBedChargeDate== null || strLastBedChargeDate.equalsIgnoreCase("null")){
						strLastBedChargeDate="";}
//					System.out.println("strLastBedChargeDate=@@==>"+strLastBedChargeDate);

					strBlngGrpId=(String)records.get(18);
					if ( strBlngGrpId== null || strBlngGrpId.equalsIgnoreCase("null")){
						strBlngGrpId="";}
//					System.out.println("strBlngGrpId=@@==>"+strBlngGrpId);

					strCustDesc="";
					String sqlcc="select SHORT_NAME from ar_customer_lang_vw where CUST_CODE='"+strCustCode+"' and language_id='"+locale+"'";
					pstmt=con.prepareStatement(sqlcc);
				//	System.out.println("sqlcc :" +sqlcc); 
					rs2=pstmt.executeQuery();
					while(rs2.next())
					{
						strCustDesc =rs2.getString(1);
						if ( strCustDesc == null || strCustDesc.equalsIgnoreCase("null")) 
						 strCustDesc = "";	
					}
					rs2.close();
					pstmt.close();
//					System.out.println("strCustDesc"+strCustDesc);
					strPolicyDesc="";
					String sqlpc="select SHORT_DESC from  bl_ins_policy_types_lang_vw where POLICY_TYPE_CODE='"+strPolicyTypeCode+"' and language_id='"+locale+"'";
					pstmt=con.prepareStatement(sqlpc);
					//System.out.println("sqlpc :" +sqlpc); 
					rs3=pstmt.executeQuery();
					while(rs3.next())
					{
						strPolicyDesc =rs3.getString(1);
						if ( strPolicyDesc == null || strPolicyDesc.equalsIgnoreCase("null")) 
						strPolicyDesc = "";	
					}
					rs3.close();
					pstmt.close();
//					System.out.println("strPolicyDesc"+strPolicyDesc);

					blng_grp_desc="";
					String sqlBG="select SHORT_DESC from  BL_BLNG_GRP_LANG_VW where BLNG_GRP_ID='"+strBlngGrpId+"' and language_id='"+locale+"'";
					pstmt=con.prepareStatement(sqlBG);
					//System.out.println("sqlBG :" +sqlBG); 
					rs4=pstmt.executeQuery();
					while(rs4.next())
					{
						blng_grp_desc =rs4.getString(1);
						if ( blng_grp_desc == null || blng_grp_desc.equalsIgnoreCase("null")) 
						blng_grp_desc = "";	
					}
					rs4.close();
					pstmt.close();
//					System.out.println("blng_grp_desc"+blng_grp_desc);

					CurrencyFormat cf1 = new CurrencyFormat();
					strUnBldAmt = cf1.formatCurrency(strUnBldAmt,no_of_decimals);
					cf1 = new CurrencyFormat();
					strOutstdAmt = cf1.formatCurrency(strOutstdAmt,no_of_decimals);
					cf1 = new CurrencyFormat();
					strTotAmt = cf1.formatCurrency(strTotAmt,no_of_decimals);

					cf1 = new CurrencyFormat();
					strTotUnadjDepAmt = cf1.formatCurrency(strTotUnadjDepAmt,no_of_decimals);

					if(strEpisodeType.equals("I"))
					{
						strEpisodeType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
					}
					else if(strEpisodeType.equals("O"))	
					{
						strEpisodeType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
					}
					else if(strEpisodeType.equals("E"))
					{
						strEpisodeType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
					}
					else if(strEpisodeType.equals("D"))	
					{
						strEpisodeType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
					}
					else if(strEpisodeType.equals("R"))	
					{
						strEpisodeType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels");
					}
%>
			<tbody>
			<!-- Added By Rajesh V -->
				<tr id=row<%=i%> onclick='highlightRow(<%=i%>,"<%=classval%>")'>
			<!-- Added By Rajesh V -->		
					<td id='row<%=i %>_col1' class=<%=classval%> width="5%"><INPUT TYPE="TEXT" name='patient_id<%=i%>' id='patient_id<%=i%>' SIZE="10" MAXLENGTH="20" 	VALUE="<%=strPatientId%>" readonly> </td>		

					<td id='row<%=i %>_col2' class=<%=classval%> width="5%" ><input type='text' name='patient_name<%=i%>' id='patient_name<%=i%>' size='10' maxlength='20' value="<%=strPatientName%>" readonly></td>

					<td id='row<%=i %>_col3' class=<%=classval%> width="5%" class="fields"><input type='text' name='episode_type<%=i%>' id='episode_type<%=i%>' size='10' maxlength='30' value="<%=strEpisodeType%>" readonly> </td>

					<td id='row<%=i %>_col4' class=<%=classval%> width="5%" class="fields"><input type='text' name='adm_no<%=i%>' id='adm_no<%=i%>' size='10' maxlength='30' value="<%=strOpenEpisodeId%>" readonly> </td>

					<td id='row<%=i %>_col5' class=<%=classval%> width="5%" class="fields"><input type='text' name='adm_date<%=i%>' id='adm_date<%=i%>' size='10' maxlength='30' value="<%=com.ehis.util.DateUtils.convertDate(strAdmDateTime,"DMYHMS","en",locale)%>" readonly> </td>

					<td id='row<%=i %>_col6' class=<%=classval%> width="5%" class="fields"><input type='text' name='last_bed_chr_date<%=i%>' id='last_bed_chr_date<%=i%>' size='10' maxlength='30' value="<%=com.ehis.util.DateUtils.convertDate(strLastBedChargeDate,"DMYHMS","en",locale)%>" readonly> </td>

					<td id='row<%=i %>_col7' class=<%=classval%> width="5%" class="fields"><input type='text' name='ward<%=i%>' id='ward<%=i%>' size='10' maxlength='30' value="<%=strCurWardCode%>" readonly> </td>
		
					<td id='row<%=i %>_col8' width="5%" class=<%=classval%>><input type='text' name='bed_no<%=i%>' id='bed_no<%=i%>' size='8' maxlength='10' readonly value="<%=strCurrBedNum%>"></td>			

					<td id='row<%=i %>_col9' class=<%=classval%> width="5%" ><input type='text' name='blng_grp_id<%=i%>' id='blng_grp_id<%=i%>' size='8' maxlength='20' readonly value="<%=blng_grp_desc%>">

					<td id='row<%=i %>_col10' class=<%=classval%> width="5%" ><input type='text' name='cust_desc<%=i%>' id='cust_desc<%=i%>' size='10' maxlength='20' value="<%=strCustDesc%>" readonly></td>

					<td id='row<%=i %>_col11' class=<%=classval%> width="5%" class="fields"><input type='text' name='policy<%=i%>' id='policy<%=i%>' size='10' maxlength='30' value="<%=strPolicyDesc%>" readonly> </td>
		
					<td id='row<%=i %>_col12' width="5%" class=<%=classval%>><input type='text' readonly name='unbill_amt<%=i%>' id='unbill_amt<%=i%>' maxlength='30' size='10'   value='<%=strUnBldAmt%>' readonly style='text-align:right'></td>
		
					<td id='row<%=i %>_col13' width="5%" class=<%=classval%> ><input type='text' name='unadjust_dep<%=i%>' id='unadjust_dep<%=i%>' value='<%=strTotUnadjDepAmt%>' readonly></td>		
		
					<td id='row<%=i %>_col14' class=<%=classval%> width="5%"><input type='text' readonly name='outstand_amt<%=i%>' id='outstand_amt<%=i%>' maxlength='60' size='10' value='<%=strOutstdAmt%>' readonly style='text-align:right'></td>  
		
					<td id='row<%=i %>_col15' class=<%=classval%> width="5%"><input type='text' readonly name='total_amt<%=i%>' id='total_amt<%=i%>' maxlength='60' size='10' value='<%=strTotAmt%>' style='text-align:right'></td>  

					<input type='hidden' name='cust_code<%=i%>' id='cust_code<%=i%>' value='<%=strCustCode%>'>
					<input type='hidden' name='episode_id<%=i%>' id='episode_id<%=i%>' value='<%=strOpenEpisodeId%>'>
				</tr> 
 <%
					i++;
					total_records++; 
 				}//while
%>			</tbody>
			</table>
		</div>
<%
				out.flush();
				try
				{
					String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from dual";
					stmt1 = con.createStatement();
					rs4 = stmt1.executeQuery(query_date) ;
					if( rs4 != null ) 
					{
						while( rs4.next() )
						{  
							sys_date = rs4.getString(1);
						}
					}
					if(rs4 !=null) rs4.close();
					stmt1.close();

					if(!locale.equals("en"))
					{
						sys_date = com.ehis.util.DateUtils.convertDate(sys_date,"DMYHMS","en",locale) ;
					}
				}
				catch(Exception e)
				{
					out.println("Exception @ sysdate"+e);
				}
			}
			else 
			{
%>
		<script></script>
<%
			}

//to insert the total records into the table
			try
			{
				System.out.println("520");//lakshmi
				String query_refresh1="SELECT DISTINCT a.facility_id , a.patient_id,b.episode_type,open_episode_id	FROM bl_unbld_outst_vw a, bl_episode_fin_dtls b WHERE a.facility_id = b.operating_facility_id  AND a.open_episode_id = b.episode_id AND NOT EXISTS (SELECT 'x' FROM ip_discharge_advice_his_vw b WHERE a.facility_id = b.facility_id AND a.open_episode_id = b.episode_id AND NVL (dis_adv_status, ' ') != '9') and a.facility_id = '"+p_facility_id+"' AND cur_ward_code BETWEEN NVL ('"+p_from_nursing_unit_code+"', '!!!!') AND NVL ('"+p_to_nursing_unit_code+"', '~~~~') AND a.patient_id = NVL ('"+p_payer_code+"', a.patient_id) AND open_episode_id BETWEEN NVL ('"+p_from_adm_no+"', 0) AND NVL ('"+p_to_adm_no+"', 999999999999) AND ((NVL ('"+p_payer_type+"', 'I') = 'P' AND a.cust_code IS NULL) OR  (NVL ('"+p_payer_type+"', 'I') = 'I'  AND a.cust_code IS NOT NULL AND a.cust_code = NVL ('"+p_payer_code+"', a.cust_code)) OR  (NVL ('"+p_payer_type+"', 'I') = 'B') ) AND NVL (unbld_amt, 0) + NVL (outst_amt, 0) - nvl(tot_unadj_dep_amt,0) > NVL ('"+p_pay_amt_exce+"', 0) ORDER BY patient_id";
//				System.out.println("query_refresh1 :"+query_refresh1);
			//	String strtemp ="";String strtemp2="";
				//int count1=0;
				ArrayList total_records_array=new ArrayList();
				
				String[] output1=new String[4];
				pstmt = con.prepareStatement(query_refresh1);
				rs1 = pstmt.executeQuery();	
				while(rs1.next())
				{
					String[] records=new String[4];

					records[0] =  rs1.getString(1);	
					if ( records[0]== null || records[0].equalsIgnoreCase("null")){
						records[0]="";}
						//System.out.println("records[0] :" +records[0]);

					records[1] =  rs1.getString(2);
					if ( records[1]== null || records[1].equalsIgnoreCase("null")){
						records[1]="";}
						//System.out.println("records[1] :" +records[1]);

					records[2] =  rs1.getString(3);		
					if ( records[2]== null || records[2].equalsIgnoreCase("null")){
						records[2]="";}
						//System.out.println("records[2] :" +records[2]);

					records[3] =  rs1.getString(4);
					if ( records[3]== null || records[3].equalsIgnoreCase("null")){
						records[3]="";}
						//System.out.println("records[3] :" +records[3]);
						
					
					total_records_array.add(records);	
				}
				session.setAttribute("total_records_array",total_records_array);	
						
				for(int j=0; j<total_records_array.size(); j++)
				{			
					output1=(String[])total_records_array.get(j);
					for(int k=0; k<output1.length; k++)
					{
						System.out.println("strtemp2 testing:" +output1[k]);
					}
				}
						
				rs1.close();
				pstmt.close();
			}
			catch(Exception e) 
			{
				System.out.println("insert qry="+e.toString());
			}
			//out.println(CommonBean.setForm (request ,"../../eBL/jsp/BLBillInterimCurrInPat.jsp",searched));
		}
		catch(Exception eX)
		{		
			out.println("Error= "+eX);			
		}
		finally
		{
			if (rs1 != null)   rs1.close();
			if (pstmt != null) pstmt.close();
			if(con!=null) 
			{
				ConnectionManager.returnConnection(con, request);
			}
		}
%>

		<input type='hidden' name='total_records' id='total_records' value='<%=total_records%>'>	
		<input type='hidden' name='checked_row' id='checked_row' value='' >
		<input type='hidden' name='bed_chr_date' id='bed_chr_date' value='' >
		<input type='hidden' name='sys_date' id='sys_date' value='<%=sys_date%>' >
		<!-- Hidden Fields Added by Rajesh V -->
		<input type='hidden' name='rowClicked' id='rowClicked' value = ''>
		<input type='hidden' name='patientId' id='patientId' value = ''>
		<input type='hidden' name='patientName' id='patientName' value = ''>
		<input type='hidden' name='episodeType' id='episodeType' value = ''>
		<input type='hidden' name='admissionNo' id='admissionNo' value = ''>
		<input type='hidden' name='admissionDate' id='admissionDate' value = ''>
		<input type='hidden' name='lastBedChrgDt' id='lastBedChrgDt' value = ''>
		<input type='hidden' name='wardNo' id='wardNo' value = ''>
		<input type='hidden' name='bedNo' id='bedNo' value = ''>
		<input type='hidden' name='billingGroup' id='billingGroup' value = ''>
		<input type='hidden' name='payer' id='payer' value = ''>
		<input type='hidden' name='policy' id='policy' value = ''>
		<input type='hidden' name='unbilledAmt' id='unbilledAmt' value = ''>
		<input type='hidden' name='unAdjustAmt' id='unAdjustAmt' value = ''>
		<input type='hidden' name='outStandBillAmt' id='outStandBillAmt' value = ''>
		<input type='hidden' name='totalAmt' id='totalAmt' value = ''>
		
		<input type='hidden' name='inpatientText' id='inpatientText' value = '<%= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels")%>'>
		<input type='hidden' name='outpatientText' id='outpatientText' value = '<%= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels")%>'>
		<input type='hidden' name='externalText' id='externalText' value = '<%= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels")%>'>
		<input type='hidden' name='emergencyText' id='emergencyText' value = '<%= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels")%>'>
		<input type='hidden' name='daycareText' id='daycareText' value = '<%= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels")%>'>
		<!-- Hidden Fields Added by Rajesh V -->
		<%
			//Added By Rajesh - V
				if(total_records>0){
					out.println("<script>");
					out.println("highlightRow(1,'"+classval+"')");
					out.println("</script>");
				}
				//Added By Rajesh - V
		 %>
		<script>parent.frames[3].location.href='../../eCommon/html/blank.html';</script>	
		<script>
			if(document.forms[0].sys_date.value!='')
			{
				parent.frames[0].document.forms[0].search_but.value=getLabel("Common.Ason.label","common_labels")+" "+document.forms[0].sys_date.value;
			}
		</script>
	</form>
		<%out.println(CommonBean.setForm (request ,"../../eBL/jsp/BLBillInterimReportCurrInPat.jsp",searched));%>
	</body>
</HTML>

