<!DOCTYPE html>
<!--This file is saved on 28/10/2005-->
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,eCommon.Common.*, java.sql.*,eCommon.Common.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></LINK> -->
<%
        request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
	    String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String  callFrom			=	request.getParameter("callFrom")==null?"":request.getParameter("callFrom");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../ePH/js/QueryMednAdminChart.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<%	
		if(callFrom.equals("SCH")){
%>
			<script language="Javascript" src="../../ePH/js/MedicationAdministration.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
		}
%>
	</head>

	<!-- <body style="margin-top:10px"> -->
	<body style="margin-top:10px" onMouseDown="" onKeyDown="lockKey()">
<%
		String bean_id				= "QueryMednAdminChartBean";
		String bean_name			= "ePH.QueryMednAdminChartBean";
		QueryMednAdminChartBean bean= (QueryMednAdminChartBean)getBeanObject( bean_id,bean_name ,request);
			bean.setLanguageId(locale); //added for ml-mmoh-scf-1463
		String  encounterid			=	request.getParameter("encounter_id");
		String  schdate				=	request.getParameter("schdatetime");
		String  ord_drug_code		=	request.getParameter("ord_drug_code");
		String  order_id			=	request.getParameter("order_id");
		String  facility_id			=	request.getParameter("facility_id");
		String  adminyn				=	request.getParameter("adminyn");
		String patient_class		=	request.getParameter("patient_class");
		String order_line_num		=  request.getParameter("order_line_num")==null?"1":request.getParameter("order_line_num"); //newly added for inc 30030
		String sch_dosage_uom_code	=	request.getParameter("sch_dosage_uom_code")==null?"":request.getParameter("sch_dosage_uom_code");
		String  drug_desc			=	request.getParameter("drug_desc")==null?"":request.getParameter("drug_desc");
		String  admintime			=	request.getParameter("admintime");
		String te_qty				=	request.getParameter("te_qty");
		String iv_prep_yn			=	request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
		String dosage_seq_no		=  request.getParameter("dosage_seq_no")==null?"1":request.getParameter("dosage_seq_no"); // Added for PMG2014-CRF-0026 [IN:052701]
		String admin_by_type="", self_admin_by="";
		String admin_recorded_date_time="";// Added for MMOH-CRF-0911
		String admin_drug_code   = "";//BRU-CRF-399.1
		String split_dose_yn = "";
		String position = "";//inc 44744
		String witness_by=""; // Added for AAKH-CRF-0023[IN:038259] 
		String admin_reason=""; // Added for SKR-CRF-0037 [IN:037656]
		boolean searched			=	request.getParameter( "searched" ) == null ? false : true  ;
		String expiry_date ="";//code added for SKR-SCF-1002[IN048681]
		try{
			encounterid		 = CommonBean.checkForNull( encounterid);
			schdate			 = CommonBean.checkForNull( schdate );
			//schdate			 = com.ehis.util.DateUtils.convertDate(schdate,"DMY","en",locale);//added for inc 44498 //Commented for  RUT-SCF-0376 [IN:046818]
			ord_drug_code	 = CommonBean.checkForNull( ord_drug_code );
			order_id		 = CommonBean.checkForNull( order_id );
			facility_id		 = CommonBean.checkForNull( facility_id );
			HashMap sqlMap		= new HashMap();
			ArrayList chkFields = new ArrayList();
		//include all the common parameters.
			StringBuffer sql = new StringBuffer();
	
			if (adminyn.equals("Y")){
				if(patient_class.equals("IP")||patient_class.equals("DC")){
				  //sql=PhRepository.getPhKeyValue("SQL_QUERY_MED_ADMIN_SELECT3");
				  //sql="SELECT  F.SHORT_DESC, b.ADMIN_DRUG_CODE,   TO_CHAR(A.ADMIN_DATE_TIME ,   'DD/MM/YYYY HH24:MI') ADMIN_TIME, (select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_BY and LANGUAGE_ID=? ) ADMIN_BY, A.Admin_by_type, a.self_admin_by, (select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_RECORDED_BY and LANGUAGE_ID=? ) ADMIN_RECORDED_BY, D.PRACTITIONER_NAME, d.PRACT_TYPE_DESC POSITION , nvl((SELECT drug_desc FROM ph_drug_lang_vw ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = A.order_id AND ph_disp_dtl.order_line_no = A.order_line_num AND ph_drug.language_id = ? AND ROWNUM < 2),e.drug_desc) drug_desc ,   b.ADMIN_DOSAGE_QTY,   B.admin_dosage_uom_code,    A.ADMIN_REMARKS,  'Batch Id: '||NVL(B.BATCH_ID,'-- ')||' Expiry Date: '||    NVL(TO_CHAR(B.EXPIRY_DATE,'dd/mm/yyyy'),'-- ')||' Trade Name: '||NVL((SELECT SHORT_NAME FROM  AM_TRADE_NAME_lang_vw WHERE    language_id=? and TRADE_ID=B.TRADE_ID ),'-- ')  BATCH_DETAILS, G.REASON_DESC, A.ADR_REMARKS,TO_CHAR(A.ADR_RECORDED_DATE_TIME ,   'DD/MM/YYYY HH24:MI') ADR_RECORDED_DATE_TIME, A.ADR_RECORDED_BY,A.ADMN_DOSE_CHNG_REMARKS ,nvl((SELECT am_get_desc.am_uom(pres_base_uom,?,2) FROM  ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = A.order_id AND ph_disp_dtl.order_line_no = A.order_line_num  AND ROWNUM < 2),'') ALT_PRES_BASE_UOM ,(SELECT DOSAGE_TYPE  FROM  or_order_line_ph where or_order_line_ph.order_id =   A.order_id AND or_order_line_ph.order_line_num = A.order_line_num  ) dosage_type FROM ph_medn_admin_dtl b, or_order c,am_practitioner_lang_vw d, ph_medn_admin a, ph_drug_lang_vw e, ip_nursing_unit_lang_vw f, ph_medn_trn_reason_lang_vw g WHERE    F.FACILITY_ID=A.FACILITY_ID AND F.NURSING_UNIT_CODE=A.ADMIN_NURSING_UNIT_CODE AND F.FACILITY_ID=B.FACILITY_ID AND A.FACILITY_ID= b.FACILITY_ID AND   A.ENCOUNTER_ID= b.ENCOUNTER_ID AND  a.order_id = b.order_id AND      A.order_id=c.order_id AND  c.ord_pract_id=D.practitioner_id  AND A.SCH_DATE_TIME=b.SCH_DATE_TIME AND  A.ORD_DRUG_CODE=  b.ORD_DRUG_CODE  AND    E.DRUG_CODE(+)=B.ADMIN_DRUG_CODE AND   A.FACILITY_ID=? AND   A.ENCOUNTER_ID=? AND   TO_CHAR(A.SCH_DATE_TIME,'dd/mm/yyyy')=TO_CHAR(TO_DATE(?,'dd/mm/yyyy'),'dd/mm/yyyy') AND TO_CHAR(A.SCH_DATE_TIME,'HH24:MI')=TO_CHAR(TO_DATE(?,'HH24:MI'),'HH24:MI') AND   A.ORD_DRUG_CODE=nvl(?,A.ORD_DRUG_CODE) AND G.REASON_CODE(+) = A.ADR_REASON_CODE AND A.ORDER_ID=? AND g.appl_trn_type(+)='M' AND d.language_id = ? AND e.language_id(+) = ? AND f.language_id = d.language_id AND g.language_id (+)= ?";//changed for position value inc 44113
				  // Added for MMOH-CRF-0911 start TO_CHAR (a.admin_recorded_date_time, 'DD/MM/YYYY HH24:MI' ) admin_recorded_date_time end
				  sql.append("SELECT  DECODE (f.short_desc, NULL, (SELECT clinic_code FROM op_clinic_lang_vw WHERE facility_id = a.facility_id AND language_id(+) = e.language_id AND clinic_code = a.admin_nursing_unit_code), f.short_desc) short_desc, b.ADMIN_DRUG_CODE, TO_CHAR(A.ADMIN_DATE_TIME , 'DD/MM/YYYY HH24:MI') ADMIN_TIME, (select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_BY and LANGUAGE_ID=? ) ADMIN_BY, A.Admin_by_type, a.self_admin_by, (select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_RECORDED_BY and LANGUAGE_ID=? ) ADMIN_RECORDED_BY, D.PRACTITIONER_NAME, d.POSITION_DESC POSITION , nvl((SELECT drug_desc FROM ph_drug_lang_vw ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = A.order_id AND ph_disp_dtl.order_line_no = A.order_line_num AND ph_drug.language_id = ? AND ROWNUM < 1),e.drug_desc) drug_desc ,   b.ADMIN_DOSAGE_QTY,   B.admin_dosage_uom_code, A.ADMIN_REMARKS, 'Batch Id: '||NVL(B.BATCH_ID,'-- ')||' Trade Name: '||NVL((SELECT SHORT_NAME FROM AM_TRADE_NAME_lang_vw WHERE language_id=? and TRADE_ID=B.TRADE_ID ),'-- ') || ' Expiry Date: ' BATCH_DETAILS, G.REASON_DESC, A.ADR_REMARKS,TO_CHAR(A.ADR_RECORDED_DATE_TIME , 'DD/MM/YYYY HH24:MI') ADR_RECORDED_DATE_TIME, A.ADR_RECORDED_BY,A.ADMN_DOSE_CHNG_REMARKS ,nvl((SELECT am_get_desc.am_uom(pres_base_uom,?,2) FROM ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = A.order_id AND ph_disp_dtl.order_line_no = A.order_line_num  AND ROWNUM < 1),'') ALT_PRES_BASE_UOM ,(SELECT DOSAGE_TYPE  FROM  or_order_line_ph where or_order_line_ph.order_id = A.order_id AND or_order_line_ph.order_line_num = A.order_line_num ) dosage_type,(SELECT appl_user_name FROM sm_appl_user_lang_vw WHERE appl_user_id = ordln.verbal_order_witness_by_id AND language_id = ?) witness_by, (select REASON_DESC from ph_medn_trn_reason_lang_vw where reason_code=b.ADMIN_REASON_CODE and language_id(+)=e.language_id AND appl_trn_type in ('MR','M') )ADMIN_REASON, NVL(TO_CHAR(B.EXPIRY_DATE,'dd/mm/yyyy'),'-- ') EXPIRY_DATE,TO_CHAR (a.admin_recorded_date_time, 'DD/MM/YYYY HH24:MI' ) admin_recorded_date_time,(SELECT SPLIT_DOSE_YN  FROM  or_order_line_ph where or_order_line_ph.order_id =   A.order_id AND or_order_line_ph.order_line_num = A.order_line_num) SPLIT_DOSE_YN FROM ph_medn_admin_dtl b, or_order c,am_practitioner_lang_vw d, ph_medn_admin a, ph_drug_lang_vw e, ip_nursing_unit_lang_vw f, ph_medn_trn_reason_lang_vw g, or_order_line ordln WHERE F.FACILITY_ID(+) = A.FACILITY_ID AND F.NURSING_UNIT_CODE (+) = A.ADMIN_NURSING_UNIT_CODE  AND A.FACILITY_ID= b.FACILITY_ID AND A.ENCOUNTER_ID= b.ENCOUNTER_ID AND a.order_id = b.order_id and a.dosage_seq_no = b.dosage_seq_no AND A.order_id=c.order_id AND a.order_id = ordln.order_id and A.ORDER_LINE_NUM = ORDLN.ORDER_LINE_NUM AND c.ord_pract_id=D.practitioner_id  AND A.SCH_DATE_TIME=b.SCH_DATE_TIME AND A.ORD_DRUG_CODE=  b.ORD_DRUG_CODE  AND E.DRUG_CODE(+)=B.ADMIN_DRUG_CODE AND A.FACILITY_ID=? AND A.ENCOUNTER_ID=? AND TO_CHAR(A.SCH_DATE_TIME,'dd/mm/yyyy')=TO_CHAR(TO_DATE(?,'dd/mm/yyyy'),'dd/mm/yyyy') AND TO_CHAR(A.SCH_DATE_TIME,'HH24:MI')=TO_CHAR(TO_DATE(?,'HH24:MI'),'HH24:MI') AND A.ORD_DRUG_CODE=nvl(?,A.ORD_DRUG_CODE) AND G.REASON_CODE(+) = A.ADR_REASON_CODE AND A.ORDER_ID=? AND g.appl_trn_type(+)='M' AND d.language_id = ? AND e.language_id(+) = ? AND f.language_id(+) = ? AND g.language_id (+)= ? ");  //AND F.FACILITY_ID=B.FACILITY_ID  && code ' NVL(TO_CHAR(B.EXPIRY_DATE,'dd/mm/yyyy'),'-- ') ' remove from batch details and taken separate field for SKR-SCF-1002[IN048681] // AND ROWNUM < 2 changed to AND ROWNUM < 1 for ML-BRU-SCF-1726 [IN:064702]  //AND appl_trn_type in ('MR','M') added for IN74075
			   } 
			   else{
					//sql=PhRepository.getPhKeyValue("SQL_QUERY_MED_ADMIN_SELECT3A");
					//sql="SELECT  F.SHORT_DESC, b.ADMIN_DRUG_CODE,   TO_CHAR(A.ADMIN_DATE_TIME , 'DD/MM/YYYY HH24:MI') ADMIN_TIME,(select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_BY and LANGUAGE_ID=? ) ADMIN_BY,A.Admin_by_type, a.self_admin_by,  (select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_RECORDED_BY and LANGUAGE_ID=? ) ADMIN_RECORDED_BY,D.PRACTITIONER_NAME, d.PRACT_TYPE_DESC POSITION,  nvl((SELECT drug_desc FROM ph_drug_lang_vw ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = A.order_id AND ph_disp_dtl.order_line_no = A.order_line_num AND ph_drug.language_id = ? AND ROWNUM < 2),e.drug_desc) drug_desc,   b.ADMIN_DOSAGE_QTY,   B.admin_dosage_uom_code,    A.ADMIN_REMARKS,  'Batch Id: '||NVL(B.BATCH_ID,'--')||' Expiry Date: '||    NVL(TO_CHAR(B.EXPIRY_DATE,'dd/mm/yyyy'),'-- ')||' Trade Name: '||NVL((SELECT SHORT_NAME FROM  AM_TRADE_NAME_lang_vw WHERE    language_id=? and  TRADE_ID=B.TRADE_ID ),'-- ')  BATCH_DETAILS, G.REASON_DESC, A.ADR_REMARKS, TO_CHAR(A.ADR_RECORDED_DATE_TIME ,   'DD/MM/YYYY HH24:MI') ADR_RECORDED_DATE_TIME , A.ADR_RECORDED_BY,A.ADMN_DOSE_CHNG_REMARKS,nvl((SELECT am_get_desc.am_uom(pres_base_uom,?,2) FROM  ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = A.order_id AND ph_disp_dtl.order_line_no = A.order_line_num  AND ROWNUM < 2),'') ALT_PRES_BASE_UOM,(SELECT DOSAGE_TYPE  FROM  or_order_line_ph    where or_order_line_ph.order_id =   A.order_id AND or_order_line_ph.order_line_num = A.order_line_num  ) dosage_type FROM ph_medn_admin_dtl b, or_order c,am_practitioner_lang_vw d, ph_medn_admin a, ph_drug_lang_vw e, op_clinic_lang_vw f, ph_medn_trn_reason_lang_vw g WHERE    F.FACILITY_ID=A.FACILITY_ID AND F.clinic_code=A.ADMIN_NURSING_UNIT_CODE AND F.FACILITY_ID=B.FACILITY_ID AND A.FACILITY_ID= b.FACILITY_ID AND   A.ENCOUNTER_ID= b.ENCOUNTER_ID AND  a.order_id = b.order_id AND      A.order_id=c.order_id AND  c.ord_pract_id=D.practitioner_id AND a.dosage_seq_no = b.dosage_seq_no AND A.SCH_DATE_TIME=b.SCH_DATE_TIME AND  A.ORD_DRUG_CODE=  b.ORD_DRUG_CODE  AND    E.DRUG_CODE(+)=B.ADMIN_DRUG_CODE AND   A.FACILITY_ID=? AND   A.ENCOUNTER_ID=? AND   TO_CHAR(A.SCH_DATE_TIME,'dd/mm/yyyy')=TO_CHAR(TO_DATE(?,'dd/mm/yyyy'),'dd/mm/yyyy') AND TO_CHAR(A.SCH_DATE_TIME,'HH24:MI')=TO_CHAR(TO_DATE(?,'HH24:MI'),'HH24:MI') AND   A.ORD_DRUG_CODE=nvl(?,A.ORD_DRUG_CODE) AND G.REASON_CODE(+) = A.ADR_REASON_CODE AND A.ORDER_ID=? AND g.appl_trn_type(+)='M' AND d.language_id = ? AND e.language_id (+)= ? AND f.language_id = d.language_id AND g.language_id (+)= ? AND a.ORDER_LINE_NUM=?";  //AND a.dosage_seq_no = b.dosage_seq_no and ORDER_LINE_NUM newly added for incident 30030
				  // Added for MMOH-CRF-0911 start TO_CHAR (a.admin_recorded_date_time, 'DD/MM/YYYY HH24:MI' ) admin_recorded_date_time end
					sql.append("SELECT  F.SHORT_DESC, b.ADMIN_DRUG_CODE,   TO_CHAR(A.ADMIN_DATE_TIME , 'DD/MM/YYYY HH24:MI') ADMIN_TIME,(select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_BY and LANGUAGE_ID=? ) ADMIN_BY,A.Admin_by_type, a.self_admin_by,  (select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_RECORDED_BY and LANGUAGE_ID=? ) ADMIN_RECORDED_BY,D.PRACTITIONER_NAME, d.POSITION_DESC POSITION,  nvl((SELECT drug_desc FROM ph_drug_lang_vw ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = A.order_id AND ph_disp_dtl.order_line_no = A.order_line_num AND ph_drug.language_id = ? AND ROWNUM < 1),e.drug_desc) drug_desc,   b.ADMIN_DOSAGE_QTY,   B.admin_dosage_uom_code, A.ADMIN_REMARKS, 'Batch Id: '||NVL(B.BATCH_ID,'--')||' Trade Name: '||NVL((SELECT SHORT_NAME FROM  AM_TRADE_NAME_lang_vw WHERE language_id=? and  TRADE_ID=B.TRADE_ID ),'-- ') || ' Expiry Date: '  BATCH_DETAILS, G.REASON_DESC, A.ADR_REMARKS, TO_CHAR(A.ADR_RECORDED_DATE_TIME , 'DD/MM/YYYY HH24:MI') ADR_RECORDED_DATE_TIME , A.ADR_RECORDED_BY,A.ADMN_DOSE_CHNG_REMARKS,nvl((SELECT am_get_desc.am_uom(pres_base_uom,?,2) FROM  ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = A.order_id AND ph_disp_dtl.order_line_no = A.order_line_num  AND ROWNUM < 2),'') ALT_PRES_BASE_UOM,(SELECT DOSAGE_TYPE  FROM  or_order_line_ph where or_order_line_ph.order_id =   A.order_id AND or_order_line_ph.order_line_num = A.order_line_num) dosage_type, (SELECT appl_user_name FROM sm_appl_user_lang_vw WHERE appl_user_id = ordln.verbal_order_witness_by_id AND language_id = ?) witness_by, (select REASON_DESC from ph_medn_trn_reason_lang_vw where reason_code=b.ADMIN_REASON_CODE and language_id(+)=e.language_id AND appl_trn_type in ('MR','M'))ADMIN_REASON , NVL(TO_CHAR(B.EXPIRY_DATE,'dd/mm/yyyy'),'-- ') EXPIRY_DATE,TO_CHAR (a.admin_recorded_date_time, 'DD/MM/YYYY HH24:MI' ) admin_recorded_date_time,(SELECT SPLIT_DOSE_YN  FROM  or_order_line_ph where or_order_line_ph.order_id =   A.order_id AND or_order_line_ph.order_line_num = A.order_line_num) SPLIT_DOSE_YN FROM ph_medn_admin_dtl b, or_order c,am_practitioner_lang_vw d, ph_medn_admin a, ph_drug_lang_vw e, op_clinic_lang_vw f, ph_medn_trn_reason_lang_vw g, or_order_line ordln WHERE F.FACILITY_ID=A.FACILITY_ID AND F.clinic_code=A.ADMIN_NURSING_UNIT_CODE AND F.FACILITY_ID=B.FACILITY_ID AND A.FACILITY_ID= b.FACILITY_ID AND A.ENCOUNTER_ID= b.ENCOUNTER_ID AND  a.order_id = b.order_id and a.dosage_seq_no = b.dosage_seq_no AND A.order_id=c.order_id AND a.order_id = ordln.order_id and A.ORDER_LINE_NUM = ORDLN.ORDER_LINE_NUM AND  c.ord_pract_id=D.practitioner_id AND a.dosage_seq_no = b.dosage_seq_no AND A.SCH_DATE_TIME=b.SCH_DATE_TIME AND  A.ORD_DRUG_CODE=  b.ORD_DRUG_CODE AND E.DRUG_CODE(+)=B.ADMIN_DRUG_CODE AND A.FACILITY_ID=? AND A.ENCOUNTER_ID=? AND   TO_CHAR(A.SCH_DATE_TIME,'dd/mm/yyyy')=TO_CHAR(TO_DATE(?,'dd/mm/yyyy'),'dd/mm/yyyy') AND TO_CHAR(A.SCH_DATE_TIME,'HH24:MI')=TO_CHAR(TO_DATE(?,'HH24:MI'),'HH24:MI') AND A.ORD_DRUG_CODE=nvl(?,A.ORD_DRUG_CODE) AND G.REASON_CODE(+) = A.ADR_REASON_CODE AND A.ORDER_ID=? AND g.appl_trn_type(+)='M' AND d.language_id = ? AND e.language_id (+)= ? AND f.language_id(+) = ? AND g.language_id (+)= ? AND a.ORDER_LINE_NUM=? ");  //changed for position value inc 44113 && code ' NVL(TO_CHAR(B.EXPIRY_DATE,'dd/mm/yyyy'),'-- ') ' remove from batch details and taken separate field for SKR-SCF-1002[IN048681] // AND ROWNUM < 2 changed to AND ROWNUM < 1 for ML-BRU-SCF-1726 [IN:064702]  
					//AND appl_trn_type in ('MR','M') added for IN74075
				}
			}
			else if(patient_class.equals("IP")||patient_class.equals("DC")){
				//sql=PhRepository.getPhKeyValue("SQL_QUERY_MED_ADMIN_SELECT4");
				//sql="SELECT  F.SHORT_DESC,(select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_BY and LANGUAGE_ID=? ) ADMIN_BY,A.Admin_by_type, a.self_admin_by, (select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_RECORDED_BY and LANGUAGE_ID=? )  ADMIN_RECORDED_BY,A.non_ADMIN_REMARKS,  D.PRACTITIONER_NAME, d.PRACT_TYPE_DESC POSITION,g.reason_desc,A.ADMN_DOSE_CHNG_REMARKS FROM   OR_ORDER c,  am_practitioner_lang_vw d,  PH_MEDN_ADMIN A,IP_NURSING_UNIT_lang_vw F, PH_MEDN_TRN_REASON_LANG_VW g WHERE   F.FACILITY_ID=A.FACILITY_ID AND F.NURSING_UNIT_CODE=A.ADMIN_NURSING_UNIT_CODE AND C.ORDERING_FACILITY_ID=F.FACILITY_ID AND A.order_id=c.order_id AND  c.ord_pract_id=D.practitioner_id and g.REASON_CODE(+) = a.NON_ADMIN_CODE   AND g.appl_trn_type(+)='M'  AND   A.FACILITY_ID=?  AND   A.ENCOUNTER_ID=?  AND   TO_CHAR(A.SCH_DATE_TIME,'dd/mm/yyyy')=TO_CHAR(TO_DATE(?,'dd/mm/yyyy'),'dd/mm/yyyy')  AND TO_CHAR(A.SCH_DATE_TIME,'HH24:MI')=TO_CHAR(TO_DATE(?,'HH24:MI'),'HH24:MI') AND   A.ORD_DRUG_CODE=nvl(?,A.ORD_DRUG_CODE) AND A.ORDER_ID=?  and d.language_id =f.language_id and f.language_id =? AND g.LANGUAGE_ID(+) = ?";//changed for position value inc 44113
				sql.append("SELECT  F.SHORT_DESC,(select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_BY and LANGUAGE_ID=? ) ADMIN_BY,A.Admin_by_type, a.self_admin_by, (select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_RECORDED_BY and LANGUAGE_ID=? )  ADMIN_RECORDED_BY,A.non_ADMIN_REMARKS, D.PRACTITIONER_NAME, d.POSITION_DESC POSITION ,g.reason_desc,A.ADMN_DOSE_CHNG_REMARKS, (SELECT appl_user_name FROM sm_appl_user_lang_vw WHERE appl_user_id = ordln.verbal_order_witness_by_id AND language_id = ?) witness_by,(SELECT SPLIT_DOSE_YN  FROM  or_order_line_ph where or_order_line_ph.order_id =   A.order_id AND or_order_line_ph.order_line_num = A.order_line_num) SPLIT_DOSE_YN FROM OR_ORDER c,  am_practitioner_lang_vw d,  PH_MEDN_ADMIN A,IP_NURSING_UNIT_lang_vw F, PH_MEDN_TRN_REASON_LANG_VW g, or_order_line ordln WHERE F.FACILITY_ID=A.FACILITY_ID AND F.NURSING_UNIT_CODE=A.ADMIN_NURSING_UNIT_CODE AND C.ORDERING_FACILITY_ID=F.FACILITY_ID AND A.order_id=c.order_id AND  c.ord_pract_id=D.practitioner_id and g.REASON_CODE(+) = a.NON_ADMIN_CODE AND g.appl_trn_type(+)='M'  AND A.FACILITY_ID=? AND A.ENCOUNTER_ID=? AND  a.order_id = ordln.order_id and A.ORDER_LINE_NUM = ORDLN.ORDER_LINE_NUM AND TO_CHAR(A.SCH_DATE_TIME,'dd/mm/yyyy')=TO_CHAR(TO_DATE(?,'dd/mm/yyyy'),'dd/mm/yyyy') AND TO_CHAR(A.SCH_DATE_TIME,'HH24:MI')=TO_CHAR(TO_DATE(?,'HH24:MI'),'HH24:MI') AND A.ORD_DRUG_CODE=nvl(?,A.ORD_DRUG_CODE) AND A.ORDER_ID=?  and d.language_id =f.language_id and f.language_id =? AND g.LANGUAGE_ID(+) = ? ");//and a.dosage_seq_no=? removed for MMS-KH-SCF-0023
			}
			else {
				//sql=PhRepository.getPhKeyValue("SQL_QUERY_MED_ADMIN_SELECT4A");
				//sql="SELECT F.SHORT_DESC, (select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_BY and LANGUAGE_ID=? ) ADMIN_BY, A.Admin_by_type, a.self_admin_by, (select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_RECORDED_BY and LANGUAGE_ID=? )  ADMIN_RECORDED_BY ,A.non_ADMIN_REMARKS,  D.PRACTITIONER_NAME, d.PRACT_TYPE_DESC POSITION,g.reason_desc,A.ADMN_DOSE_CHNG_REMARKS FROM   OR_ORDER c,  am_practitioner_lang_vw d,  PH_MEDN_ADMIN A,op_clinic_lang_vw F, PH_MEDN_TRN_REASON_LANG_VW g WHERE   F.FACILITY_ID=A.FACILITY_ID AND F.clinic_CODE=A.ADMIN_NURSING_UNIT_CODE AND C.ORDERING_FACILITY_ID=F.FACILITY_ID AND A.order_id=c.order_id AND  c.ord_pract_id=D.practitioner_id  and g.REASON_CODE(+) = a.NON_ADMIN_CODE   AND g.appl_trn_type(+)='M' AND   A.FACILITY_ID=?  AND   A.ENCOUNTER_ID=?  AND   TO_CHAR(A.SCH_DATE_TIME,'dd/mm/yyyy')=TO_CHAR(TO_DATE(?,'dd/mm/yyyy'),'dd/mm/yyyy') AND TO_CHAR(A.SCH_DATE_TIME,'HH24:MI')=TO_CHAR(TO_DATE(?,'HH24:MI'),'HH24:MI')  AND   A.ORD_DRUG_CODE=nvl(?,A.ORD_DRUG_CODE) AND A.ORDER_ID=?  and d.language_id =f.language_id and f.language_id =? AND g.LANGUAGE_ID(+) = ?";//changed for position value inc 44113
				sql.append("SELECT F.SHORT_DESC, (select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_BY and LANGUAGE_ID=? ) ADMIN_BY, A.Admin_by_type, a.self_admin_by, (select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_RECORDED_BY and LANGUAGE_ID=? ) ADMIN_RECORDED_BY ,A.non_ADMIN_REMARKS,  D.PRACTITIONER_NAME, d.POSITION_DESC POSITION,g.reason_desc, A.ADMN_DOSE_CHNG_REMARKS, (SELECT appl_user_name FROM sm_appl_user_lang_vw WHERE appl_user_id = ordln.verbal_order_witness_by_id AND language_id = ?) witness_by,(SELECT SPLIT_DOSE_YN  FROM  or_order_line_ph where or_order_line_ph.order_id =   A.order_id AND or_order_line_ph.order_line_num = A.order_line_num) SPLIT_DOSE_YN FROM   OR_ORDER c, am_practitioner_lang_vw d,  PH_MEDN_ADMIN A,op_clinic_lang_vw F, PH_MEDN_TRN_REASON_LANG_VW g, or_order_line ordln WHERE F.FACILITY_ID=A.FACILITY_ID AND F.clinic_CODE=A.ADMIN_NURSING_UNIT_CODE AND C.ORDERING_FACILITY_ID=F.FACILITY_ID AND A.order_id=c.order_id AND  c.ord_pract_id=D.practitioner_id  and g.REASON_CODE(+) = a.NON_ADMIN_CODE AND g.appl_trn_type(+)='M' AND A.FACILITY_ID=?  AND A.ENCOUNTER_ID=? AND  a.order_id = ordln.order_id and A.ORDER_LINE_NUM = ORDLN.ORDER_LINE_NUM AND TO_CHAR(A.SCH_DATE_TIME,'dd/mm/yyyy')=TO_CHAR(TO_DATE(?,'dd/mm/yyyy'),'dd/mm/yyyy') AND TO_CHAR(A.SCH_DATE_TIME,'HH24:MI')=TO_CHAR(TO_DATE(?,'HH24:MI'),'HH24:MI') AND A.ORD_DRUG_CODE=nvl(?,A.ORD_DRUG_CODE) AND A.ORDER_ID=? and d.language_id =f.language_id and f.language_id =? AND g.LANGUAGE_ID(+) = ? ");//and a.dosage_seq_no=? removed for MMS-KH-SCF-0023
			}
		//	if(!dosage_seq_no.equals(""))
			//	sql.append(" and a.dosage_seq_no=? "); //commented for SKR-SCF-1259
			chkFields.add(locale); 
			chkFields.add(locale);
			if (adminyn.equals("Y")){
				chkFields.add(locale); 
				chkFields.add(locale);    
				chkFields.add(locale);    
			}  
			chkFields.add(locale);   // Added for AAKH-CRF-0023[IN:038259] - start
			chkFields.add(bean.getFacilityId());
			chkFields.add(encounterid);
			chkFields.add(schdate);
			chkFields.add(admintime);
			chkFields.add(ord_drug_code);
			chkFields.add(order_id);
			chkFields.add(locale); 
			chkFields.add(locale);
			if (adminyn.equals("Y")){				 
				chkFields.add(locale); 
				chkFields.add(locale); 
			}  
			//the below condtion is newly added for inc 30030
			if (adminyn.equals("Y")){
				if( !patient_class.equals("IP") && !patient_class.equals("DC") ){ // && !patient_class.equals("DC") added for Alpha-PH- MAR Chart for Daycare Patients[IN036701]
					chkFields.add(order_line_num);	
				}
			}
			//if(!dosage_seq_no.equals(""))
			//	chkFields.add(dosage_seq_no);	 // Added for PMG2014-CRF-0026 [IN:052701] as per discussion with PMG we are commented against SKR-SCF-1259
			System.err.println("QueryMednAdminChartAdminDetails.jsp======sql====131===>"+sql);
			//End of concatenating search conditions
			sqlMap.put( "sqlData",  sql.toString());
			//Function Parameters
			HashMap funcMap = new HashMap();

			//The fields are going to be display
			ArrayList displayFields = new ArrayList();
			int namedisplayed=0;
			if (adminyn.equals("Y") ) {
				displayFields.add("DRUG_DESC");	//0
				displayFields.add("ADMIN_DOSAGE_QTY");
				displayFields.add("ADMIN_TIME");
				displayFields.add("BATCH_DETAILS");
				displayFields.add("ADMIN_REMARKS");
				displayFields.add("ADMIN_DOSAGE_UOM_CODE");
				displayFields.add("PRACTITIONER_NAME");
				displayFields.add("ADMIN_BY"); //7
				displayFields.add("SHORT_DESC");
				displayFields.add("REASON_DESC");
				displayFields.add("ADR_REMARKS");	//10
				displayFields.add("ADR_RECORDED_DATE_TIME");
				displayFields.add("ADR_RECORDED_BY");
				displayFields.add("ADMIN_RECORDED_BY");
				displayFields.add("ADMN_DOSE_CHNG_REMARKS");
				displayFields.add("ALT_PRES_BASE_UOM");
				displayFields.add("DOSAGE_TYPE");
				displayFields.add("POSITION");	//17
				displayFields.add("ADMIN_BY_TYPE");	//18
				displayFields.add("SELF_ADMIN_BY");	//19
				displayFields.add("WITNESS_BY");	//20 // Added for AAKH-CRF-0023[IN:038259] - start
				displayFields.add("ADMIN_REASON");	//21 // Added for Bru-HIMS-CRF-403[IN044541]
				displayFields.add("EXPIRY_DATE");	//22 //code  added for SKR-SCF-1002[IN048681] 				 
				displayFields.add("ADMIN_RECORDED_DATE_TIME");//Added for MMOH-CRF-0911 
				displayFields.add("ADMIN_DRUG_CODE");//Added for MMOH-CRF-399.1 
				displayFields.add("SPLIT_DOSE_YN"); //added for ML-MMOH-SCF-1767


			}
			else{
				displayFields.add("NON_ADMIN_REMARKS");//0
				displayFields.add("PRACTITIONER_NAME");
				displayFields.add("ADMIN_BY");
				displayFields.add("SHORT_DESC");
				displayFields.add("reason_desc");//4
				displayFields.add("ADMIN_RECORDED_BY");//5
				displayFields.add("WITNESS_BY");//6 // Added for AAKH-CRF-0023[IN:038259] - start
			}
			
			funcMap.put("displayFields", displayFields );
			funcMap.put("chkFields", chkFields );
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap,funcMap,request);
			if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
%>
				<TABLE width="100%" cellspacing="0" cellpadding="0" border='0' align='center'>
					<tr id='verbalorderWinessDtl' style='display:none'>
						<td colspan='6' class = 'label' STYLE="COLOR:Red;FONT-SIZE:9PT;FONT-FAMILY:'VERDANA';">&nbsp;*&nbsp;<fmt:message key="ePH.VerbalOrderWitnessedBy.label" bundle="${ph_labels}"/>:&nbsp;<label id='verbalWitness'></label>
						</td>
					</tr>
					<TR>
						<Td ALIGN="LEFT" width='25%' STYLE="BACKGROUND-COLOR:#FFD7D7;COLOR:black;FONT-SIZE:8PT;FONT-FAMILY:'VERDANA';" id="admin_dtls">
							<fmt:message key="ePH.AdministrationDetails.label" bundle="${ph_labels}"/>
						</Td>
						<Td ALIGN="LEFT"  width='15%' STYLE="BACKGROUND-COLOR:#FFD7D7;COLOR:black;FONT-SIZE:8PT;FONT-FAMILY:'VERDANA';" id="admin_pract_position">
							<fmt:message key="ePH.AdministrationDetails.label" bundle="${ph_labels}"/>
						</Td>
						<Td ALIGN="LEFT"  width='15%' STYLE="BACKGROUND-COLOR:#FFD7D7;COLOR:Red;FONT-SIZE:8PT;FONT-FAMILY:'VERDANA';" id="admin_self" >
							<label id="lbladmin_self" style='display:none;'><fmt:message key="ePH.selfadmin.label" bundle="${ph_labels}"/></label>
						</Td>
						<Td ALIGN="LEFT"  width='22%' STYLE="BACKGROUND-COLOR:#FFD7D7;COLOR:black;FONT-SIZE:8PT;FONT-FAMILY:'VERDANA';" id="admin_at">
							<fmt:message key="ePH.AdministrationDetails.label" bundle="${ph_labels}"/>
						</Td>
						<Td ALIGN="right"  width='25%' id="practname" Style="background-color:#FFD7D7;FONT-SIZE:8PT;FONT-FAMILY:'VERDANA';"></td>
<%
						//if(callFrom.equals("SCH")){ // commented for PMG2014-CRF-0026 [IN:052701]
%>
						<td width='1%' class = 'label' style='text-align:right;' ><button id="Closebutton" onclick="closeAdminDtl('<%=callFrom%>');" title='Close Admin Detail' ><img src="../../eCommon/images/disabled.gif"  height='17'  width='17' style="cursor:pointer;"></button></td>
<%
						//}
						//else{
%>
							<!-- <td width='1%' class = 'label' style='display:none;'></td> -->
<%
						//}
%>
					</TR>
				</TABLE>
<%
				if (result.get(1)!=""){
%>
					<table cellpadding=0 cellspacing=0 align="center" topmargin='0' WIDTH="99%">
						<tr>
							<td width="80%" class="white">&nbsp;</td>
							<td width="20%" class="white">&nbsp;<%=result.get(1)%></td>
						</tr>
					</table>
<%
				}
%>
				<table id="adminTable" name="PatientTable" id="PatientTable" border="1"  WIDTH="100%" cellpadding="0" cellspacing="0"  align="center" topmargin='0'>
<%		
					if (adminyn.equals("Y") ){
%>
						<tr id="header" name="header">
							<td  class='COLUMNHEADER' width="30%"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
							<td class='COLUMNHEADER' width="5%" ><fmt:message key="ePH.Prescribed.label" bundle="${ph_labels}"/><fmt:message key="ePH.Dose.label" bundle="${ph_labels}"/></td>
							<td class='COLUMNHEADER' width="5%" ><fmt:message key="ePH.Administered.label" bundle="${ph_labels}"/><fmt:message key="ePH.Dose.label" bundle="${ph_labels}"/></td>
							<td class='COLUMNHEADER' width="18%"><fmt:message key="ePH.Administration.label" bundle="${ph_labels}"/><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></td>
							<!-- Added for MMOH-CRF-0911 start-->
							<td class='COLUMNHEADER' width="18%"><fmt:message key="ePH.Administration.label" bundle="${ph_labels}"/><fmt:message key="ePH.Date/TimeRecorded.label" bundle="${ph_labels}"/></td>
							<!-- Added for MMOH-CRF-0911 end-->
							<td class='COLUMNHEADER' width="24%"><fmt:message key="Common.BatchDetails.label" bundle="${common_labels}"/></td>
							<td class='COLUMNHEADER' width="24%"><fmt:message key="ePH.AdministrationRemarks.label" bundle="${ph_labels}"/></td>
						</tr>
<%
					}
					else{
%>
						<tr id="header" name="header">
							<td class='COLUMNHEADER' width="25%"><fmt:message key="ePH.NonAdministrationRemarks.label" bundle="${ph_labels}"/></td>
						</tr>
<%
					}
					//Retriving the records from result arraylist
					ArrayList records=new ArrayList();
					String classvalue="";					
					for(int recCount=2; recCount<result.size(); recCount++){

						if ( recCount % 2 == 0 )
							classvalue = "QRYEVENSMALL" ;
						else
							classvalue = "QRYODDSMALL" ;
						records=(ArrayList) result.get( recCount );
%>
						<tr id=<%=recCount%> name=<%=recCount%>>
<%
						for(int colCount=0; colCount<records.size(); colCount++){
							if  (namedisplayed==0){
								namedisplayed=1;
								if (adminyn.equals("Y")) {
									admin_by_type=(String)records.get(18)==null?"":(String)records.get(18);
									self_admin_by=(String)records.get(19)==null?"":(String)records.get(19);
									position =(String)records.get(17)==null?"":(String)records.get(17);//inc 44744
									admin_reason=(String)records.get(21)==null?"":(String)records.get(21); // Added for Bru-HIMS-CRF-403[IN044541]
									witness_by=(String)records.get(20)==null?"":(String)records.get(20); // Added for AAKH-CRF-0023[IN:038259] - start
									admin_recorded_date_time=(String)records.get(23)==null?"":(String)records.get(23); //Added for MMOH-CRF-0911
									admin_drug_code = (String)records.get(24)==null?"":(String)records.get(24);//BRU-CRF-399
									split_dose_yn = (String)records.get(25)==null?"":(String)records.get(25); //added for ML-MMOH-SCF-1767
							
%>
									<script>
<%
										if(!witness_by.equals("")){ // Added for AAKH-CRF-0023[IN:038259] - End
%>
											document.getElementById("verbalorderWinessDtl").style.display="inline";
											document.getElementById("verbalWitness").innerHTML="<%=witness_by%>";
<%
										}
%>
										document.getElementById("practname").innerHTML="Ordering Practitioner:<B><%=(String)records.get(6)%></B>&nbsp;";
										//document.getElementById("admin_pract_position").innerHTML="Position:<B><%=(String)records.get(17)%></B>";
										document.getElementById("admin_pract_position").innerHTML="Position:<B><%=position%></B>"; //inc 44744
<%
										if(!admin_by_type.equals("") && !admin_by_type.equals("U")&&!self_admin_by.equals("")){
%>
											document.getElementById("admin_self").innerHTML="Self Admin:<B><%=(String)records.get(19)%></B>";
<%
										}
%>
										document.getElementById("admin_at").innerHTML="Administered At:<b><%=(String)records.get(8)%></B>";
										//document.getElementById("admin_dtls").innerHTML="Administered By:<b><%=(String)records.get(6)%></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Administered At:<b><%=(String)records.get(8)%></b>"; //Added for SRR20056-SCF-9733[Inc:38353] //Commented for ML-BRU-SCF-1040 [IN:043831]
										//Changed index from 6 to 13 to retrieve admin recorded by data instead of practioner name for  IN043190
										document.getElementById("admin_dtls").innerHTML="Administered By:<b><%=(String)records.get(13)%></b>"; //Added for ML-BRU-SCF-1040 [IN:043831]
									</script>
<%
								}
								else {
									witness_by=(String)records.get(6)==null?"":(String)records.get(6); // Added for AAKH-CRF-0023[IN:038259] - start
%>
									<script>
<%
										if(!witness_by.equals("")){ // Added for AAKH-CRF-0023[IN:038259] 
%>
											document.getElementById("verbalorderWinessDtl").style.display="inline";
											document.getElementById("verbalWitness").innerHTML="<%=witness_by%>";
<%
										}
%>
										document.getElementById("admin_dtls").innerHTML='Recorded  By:<b><%=(String)records.get(5)%></b>&nbsp;&nbsp;';
										document.getElementById("admin_pract_position").innerHTML='&nbsp;';
										document.getElementById("admin_self").innerHTML='&nbsp;';
										document.getElementById("admin_at").innerHTML='Recorded At:<b><%=(String)records.get(3)%></b>';
										document.getElementById("practname").innerHTML='Ordering Practitioner:<B><%=(String)records.get(1)%></B>';
									</script>
<%
								}
							}
							if (adminyn.equals("Y")){
								if((colCount > 4 && colCount <9) || colCount>=13)
									continue;
							}
							else{
								if (colCount>0)
									continue;
							}
							String dkVal = (String)records.get( colCount )==null?"":(String)records.get( colCount );
							if(colCount==0){	
								if (adminyn.equals("Y")){
									if(iv_prep_yn.equals("6") || iv_prep_yn.equals("0") || iv_prep_yn.equals("2") || iv_prep_yn.equals("4")|| iv_prep_yn.equals("8")){
										dkVal = drug_desc+"&nbsp;" ;
									}	
								}
							}							
							if(dkVal == null || (dkVal.trim().equals(""))){	
								if(colCount==0){
									dkVal = drug_desc+"&nbsp;" ;
								}
								else if(colCount==1)
									dkVal = "" ;
								else
									dkVal = "&nbsp;" ;
							}

							if (colCount==1){
								out.println("<td class="+classvalue+" nowrap>");
								if(!admin_drug_code.equals(ord_drug_code)){//BRU-CRF-399.1
								/*String dosage_dtl = bean.getAltDosageDetails(ord_drug_code,admin_drug_code,order_id,order_line_num);
								if(!split_dose_yn.equals("Y"))  //added for ML-MMOh-SCF-1767
								te_qty = dosage_dtl.split("~")[0];
								*/
								if(split_dose_yn.equals("Y")){ //ML-MMOH-SCF-1799.1
									te_qty = bean.getSplitDosage(order_id,order_line_num,admintime);
								}
										
								if(te_qty==null || te_qty.equals("") || te_qty.equals("00")) //added for MMS-KH-SCF-0008
									te_qty = "1";
								
								if(!te_qty.equals("") && Float.parseFloat(te_qty) < 1.0){
										te_qty = Float.parseFloat(te_qty)+"";
								}

								out.println(te_qty+"");
								/*if(!split_dose_yn.equals("Y")) //added for ML-MMOh-SCF-1767 and reverted against ML-MMOH-SCF-1841.1
									out.println(dosage_dtl.split("~")[2]+"");								
								else */
									out.println(bean.getUomDisplay(facility_id,sch_dosage_uom_code)); //added for ML-MMOh-SCF-1767
								}else{
									if(split_dose_yn.equals("Y")){ //ML-MMOH-SCF-1799
										te_qty = bean.getSplitDosage(order_id,order_line_num,admintime);
									}
									if(!te_qty.equals("") && Float.parseFloat(te_qty) < 1.0){
										te_qty = Float.parseFloat(te_qty)+"";
									}
									out.println(te_qty+"");
									out.println(bean.getUomDisplay(facility_id,sch_dosage_uom_code));								
								}
								//out.println(bean.getUomDisplay(facility_id,records.get(5).toString()));
							//	out.println(bean.getUomDisplay(facility_id,sch_dosage_uom_code));															
								out.println("</td>");						
								out.println("<td class='"+classvalue+"' nowrap>");
								if (adminyn.equals("Y")){
									if(!dkVal.equals("") && Float.parseFloat(dkVal) < 1.0){
										dkVal = Float.parseFloat(dkVal)+"";
									}
									
									if(((String)records.get(colCount+14)!=null && !(((String)records.get( colCount +14)).equals(""))) && ((String)records.get(colCount+15)).equals("Q")){
										out.println(dkVal+" "+(String)records.get( colCount +14));
									}
									else{
										// Commented for SKR-SCF-0304
									    out.println(dkVal+" "+bean.getUomDisplay(facility_id,(String)records.get(colCount+4)));//changed sch_dosage_uom_code to (String)records.get(colCount+4)  for CRF-399.1
										//out.println(te_qty+" "+bean.getUomDisplay(facility_id,sch_dosage_uom_code)); //added for SKR-SCF-0304
									}
								}
								else{
									out.println(dkVal+"&snbp;");
								}
							//	if((Float.parseFloat(te_qty))!=(Float.parseFloat(dkVal)))
								//{
									if(((String)records.get( colCount +13))!=null && ((String)records.get( colCount +13))!=""){
										String reason_code = (String)records.get( colCount +13);
										String admn_chng_dose_reason_desc = (String) bean. getAdmn_chng_dose_reason_desc(reason_code);
%>
										<img src="../images/changeddosageindicator.gif" align="center" id="chng_dose_ind" title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ChangedAdminDosageReason.label", "ph_labels") +"\n"%>-------------------------------------------<%="\n"+admn_chng_dose_reason_desc%>"></img>
<%				
										//	out.println("<img src='../images/changeddosageindicator.gif' align='center' id='chng_dose_ind' title='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ChangedAdminDosageReason.label", "ph_labels")+"\n-------------------------------------------\n"+admn_chng_dose_reason_desc+"'></img>");
								}
								out.println("</td>");
							}
							else if (colCount==2){	
								out.println("<td class='"+classvalue+"'>");								
								out.println(com.ehis.util.DateUtils.convertDate(dkVal,"DMYHM","en",locale));
								out.println("</td>");
							}
							else if (colCount==3){
							// Added for MMOH-CRF-0911 start- added for ML-MMOH-SCF-0913
								out.println("<td class='"+classvalue+"'>");								
								out.println(com.ehis.util.DateUtils.convertDate(admin_recorded_date_time,"DMYHM","en",locale));
								out.println("</td>");

								// Added for MMOH-CRF-0911 end -added for ML-MMOH-SCF-0913 and ARYU-SCF-0061 

							if (dkVal.indexOf("--")>0){	
									out.println("<td class='"+classvalue+"'>");
									out.println("&nbsp;");
									out.println("</td>");
								}
								else{
									out.println("<td class='"+classvalue+"'><textarea readonly style='height:30px;width:2in'>");
									expiry_date = (String)records.get(22)==null?"":(String)records.get(22);//code  added for SKR-SCF-1002[IN048681] --Start										
									if(!expiry_date.equals("--"))
										expiry_date = com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale);//code  added for SKR-SCF-1002[IN048681]--End									
									out.println(dkVal+expiry_date );//code '+expiry_date' added for SKR-SCF-1002[IN048681]								
									out.println("</textarea></td>");
								}
							}

							else if (colCount==4){
							
								if (dkVal.equals("&nbsp;")){	
									out.println("<td class='"+classvalue+"'>");
									out.println(dkVal);
									out.println("</td>");
								}
								else{
									out.println("<td class='"+classvalue+"'>");
									if(!admin_reason.equals("")){
%>
										<b><fmt:message key="Common.reason.label" bundle="${common_labels}"/>:</B>&nbsp;&nbsp;<%=admin_reason%>
<%
									}
									out.println("<br><textarea readonly style='height:30px;width:2in'>");
									out.println(dkVal);
									out.println("</textarea></td>");
								}
							}
							else if(colCount == 9 ){
								if( !dkVal.equals("&nbsp;")){
%>
									<tr>
									<td colspan='6' class='COLUMNHEADER'><fmt:message key="ePH.PostAdministrationDetails.label" bundle="${ph_labels}"/>
									</td>
									<tr>
									<td class=<%=classvalue%>><b><fmt:message key="Common.reason.label" bundle="${common_labels}"/>:</B>&nbsp;&nbsp;<%=dkVal%></td>
<%
								}
							}
							else if(colCount == 10){
								if( !dkVal.equals("&nbsp;")){
%>
									<td class=<%=classvalue%> colspan='2'><b><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>:</b>&nbsp;&nbsp;<%=dkVal%></td>
<%
								}
							}
							else if(colCount == 11){
								if( !dkVal.equals("&nbsp;")){
									if(!(dkVal.equals("")) && !(locale.equals("en"))){ //added for IN25266 --04/01/2011-- priya
										dkVal =  com.ehis.util.DateUtils.convertDate(dkVal,"DMYHM","en",locale);
									}
%>
									 <td class=<%=classvalue%>><b><fmt:message key="ePH.RecordedDateTime.label" 
									bundle="${ph_labels}"/>&nbsp;:</b>&nbsp;&nbsp;<%=dkVal%></td> 
<%
								}
							}
							else if(colCount == 12 ){
								if( !dkVal.equals("&nbsp;")){
%>
									<td class=<%=classvalue%> colspan='2'><b><fmt:message key="Common.RecordedBy.label" bundle="${common_labels}"/>: </b>&nbsp;&nbsp;<%=dkVal%></td>
									</tr>
<%
								}
							}
							else {
								if(colCount == 0 && adminyn.equals("N") ){
									out.println("<td class='"+classvalue+"'>");
									out.println(dkVal+" &nbsp <br>Reason:"+(String)records.get(4));
									out.println("</td>");
								}
								else{
									out.println("<td class='"+classvalue+"'>");
									out.println(dkVal);
									out.println("</td>");
								}
							}
						}
					}			//end of record count
%>
					</tr>
				</table>
<%
			}
			else{  
%>
				<script>
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
					closeAdminDtl('<%=callFrom%>');
				</script>
<%
			}
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/QueryMednAdminChartAdminDetails.jsp", searched) );
		}//end of try
		catch (Exception e){
			e.printStackTrace();
		}
%>
	</body>
	
<% putObjectInBean(bean_id,bean,request); %>
</html>

