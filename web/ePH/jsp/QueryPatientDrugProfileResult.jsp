<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
04/12/2017	  	IN063782	     	Mukesh M 											BSP-SCF-0037 [IN063782] 
04/26/2017	  	IN064104	     	Mukesh M 											BSP-SCF-0042  [IN064104] 
04/13/2018	  	IN067093	     	Chithra M 											BSP-SCF-0042.1  [IN067093]
08/13/2019	  	IN071104	     	Manickavasagam J											MMS-KH-SCF-0037
10/07/2020      IN073378            Haribabu                                             MMS-DM-SCF-0705
21/7/2020					Manickavasagam J												SKR-SCF-1370
12/10/2020      IN073397            Prabha     12/10/2020     Manickavasagam J          MOHE-CRF-0032
07/12/2020      TFS-7914			Prabha	   07/12/2020	  Manickavasagam K			ML-BRU-SCF-2068
20/10/2020      TFS-24320			Manickavasagam J	   								NMC-JD-CRF-0126
21/10/2021		TFS-25185			Prabha	 											ML-MMOH-SCF-1919
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes st art --%>  
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
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
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
		String locale			= (String)session.getAttribute("LOCALE");
		String facility_id					= (String) session.getValue("facility_id");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<style>
 			TD.EXPIRED_ORDER{    /* added for MOHE-CRF-0032 */
			BACKGROUND-COLOR:#FFA500; /* code modified for MOHE-CRF-0032 */
			FONT-SIZE: 8pt ;
			height:10;
			BORDER-STYLE: solid;
			}      
	    </style>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/QueryPatientDrugProfile.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<script type="text/javascript">
			function initScroll() {
				var rightDivSize = document.body.offsetWidth-371;//changed 251 to 361 for AAKH-CRF-0088 [IN:060357]
				var leftDiv = document.getElementById('table_container_left');
				var rightDiv = document.getElementById('table_container_right');
				if(rightDiv!=undefined && leftDiv!=undefined && rightDivSize!=-371){//Added new condition for Bru-HIMS-CRF-081 [IN:029947]
					rightDiv.style.width=rightDivSize+'px';
					rightDiv.onscroll = function() {
						leftDiv.scrollTop = this.scrollTop;
						leftDiv.scrollTop = this.scrollTop;
					};
				}
			}
			/* Added for BSP-SCF-0042.1*/
			function tableresize()
			{	
				if(document.getElementById('table_container_left_1')){//if added to handle script error when there is no record in patient drug profile
				var rows = document.getElementById('table_container_left_1').getElementsByTagName("tr").length;
				var tbl = document.getElementById('table_container_left_1').rows;
				var x=document.getElementById('table_container_right_1').rows;
				var rows1 = document.getElementById('table_container_right_1').getElementsByTagName("tr").length;
			for(var i=0;i<rows;i++){
				if(tbl[i].offsetHeight>x[i].offsetHeight){
				document.getElementById("table_container_right_1").rows[i].style.height =tbl[i].offsetHeight+"px" ;
				}else
				if(tbl[i].offsetHeight<x[i].offsetHeight){
			document.getElementById("table_container_left_1").rows[i].style.height =x[i].offsetHeight+"px" ;
			}
			} 
			}
			}/*End BSP-SCF-0042.1*/
		</script>
	</head>

	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="initScroll();tableresize();" onresize="initScroll();tableresize();"><!--tableresize() function added for BSP-SCF-0042.1-->
<%
		//Search Criteria's from Query Criteria page
		String patient_id	= request.getParameter("patient_id");
		String dt_from		= request.getParameter("dt_from");
		String dt_to		= request.getParameter("dt_to");
		String generic_id	= request.getParameter("generic_id");
		String drug_code	= request.getParameter("drug_code");
		String pat_class	= request.getParameter("pat_class");
		String status		=	request.getParameter("status");
		String called_frm  = request.getParameter("called_frm")==null?"":request.getParameter("called_frm");
		String disp_locn_code = request.getParameter("disp_locn_code");
		String ReqDb	    =	request.getParameter("ReqDb")==null?"":request.getParameter("ReqDb");//Added for MMS-DM-CRF-115.4
		if(ReqDb.equals("undefined"))
		    ReqDb="";
		String enc_id1	    =	request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");//Added for MMS-DM-CRF-115.4
		String called_from  = request.getParameter("called_from")==null?"":request.getParameter("called_from");//Added for MMS-DM-CRF-115.4
		String ret_uom1		=	"";
		String ret_uom2		=	"";
		String reissue_uom1		=	"";
		String reissue_uom2		=	"";
		String heightpx		=	"";//Added for Bru-HIMS-CRF-081 [IN:029947]
		String scroll		=	"scroll";//Added for Bru-HIMS-CRF-081 [IN:029947]
		String	bean_id			=	"QueryPatientDrugProfileBean" ;
		String	bean_name		=	"ePH.QueryPatientDrugProfileBean";

		QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id,bean_name, request) ;
		bean.setLanguageId(locale);
		String bean_id_2		= "@PrescriptionBean_1"+patient_id;
		String bean_name_2		= "ePH.PrescriptionBean_1";

		PrescriptionBean_1 bean_2= (PrescriptionBean_1)getBeanObject(bean_id_2,bean_name_2,request ) ;	
		bean_2.setLanguageId(locale);
		HashMap disc_cancel         = new HashMap();
		String discontinued_link_yn = "N";
		String cancel_link_yn       = "N";
		String disc_cancel_style	= "";
		String on_click				= "";
		String pres_disp_unit_value		= "";
		String dispnsd_disp_unit_value	= "";
		String disp_stock_uom			= "";
		String dosage_type				= "";
		String admin_dose_chng_reason_cnt  = "";
		String dosage_uom_desc             = "" ;
		//DecimalFormat total_admin_qty_format = new DecimalFormat("###0.##");	
		bean.setNoOfDecimals();
		int noOfDecimals = bean.getNoOfDecimals();
		String alt_drug_remarks_ind = bean.getAltDrugRemarksInd();//bean_1.getAltDrugRemarksInd(); //added for  Bru-HIMS-CRF-082 [IN:029948]
	  //	String convFactor = "1";
		//Added for ML-MMOH-CRF-0510[IN060510] START
		 Connection con				= null;
		 con						= ConnectionManager.getConnection(request);
		boolean site = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TRANSCRIBED_BY");//Added for ML-MMOH-CRF-0510[IN060510] END
		boolean display_transfer_locn= eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PATIENT_TRANSFER_LOCN_UPD");//SKR-SCF-1239
		boolean siteOrder = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","ORDER_LOCATION"); /* Added for ML-MMOH-CRF-0532 [IN061327]  */
     	String ip_patient_order="";/* Added for ML-MMOH-CRF-0532 [IN061327]  */
		String decimalStringFormat = "#.";
		// if Condition added for IN18681 to avoid displaying decimal point after the number  --01/02/2010--   shyampriya
		if(noOfDecimals == 0) 
			decimalStringFormat = "#.#"; // .# added for ML-BRU-SCF-0516 [IN:035889] & ML-BRU-SCF-0623 [IN:036638]
		for (int i=0;i<noOfDecimals;i++){
			decimalStringFormat = decimalStringFormat+"#";
		}
		int len=0, point=0;
		String temp="";
		DecimalFormat dfToInteger = new DecimalFormat(decimalStringFormat);	

		//String ord[]		= request.getParameterValues("orderbycolumns");
		boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;
		
		boolean expired_order = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","EXPIRY_ORDER_APP"); //Added for MOHE-CRF-0032
		boolean generic_name_max_len_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","GENERIC_NAME_MAX_LEN_APP"); //Added for NMC-JD-CRF-0119
		String scrolling = "";  //Added for NMC-JD-CRF-0119 //Modified for ML-MMOH-SCF-1919
		String pre_alloc_yn =bean.getPreAllocationYN(facility_id);//Added for NMC-JD-CRF-0126
		
		try{
			String classvalue			=	"";
			patient_id	 = CommonBean.checkForNull( patient_id );
			dt_from		 = CommonBean.checkForNull( dt_from);
			dt_to		 = CommonBean.checkForNull( dt_to );
			generic_id	 = CommonBean.checkForNull( generic_id );
			drug_code	 = CommonBean.checkForNull( drug_code );
			pat_class	 = CommonBean.checkForNull( pat_class );
			String sql_append	=	"", stMainSql="";
			int index = 2;

			if(pat_class.equals("XT")){
				if(status.equals("A")){
					sql_append	=	" AND SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL ";
				}
				else if(status.equals("F")) {
					sql_append	=	" AND A.START_DATE > SYSDATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL ";
				} 
				else if(status.equals("C")) {
					sql_append	=	" AND SYSDATE >= A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL  AND O.ORDER_LINE_STATUS IN ('DF')";
				} 
				else if(status.equals("DC")) {
					sql_append	=	" AND O.DISC_DATE_TIME IS NOT NULL AND A.CANCEL_YN='N'";				
				} 
				else if(status.equals("HD") || status.equals("HC")) {
					sql_append	=	" AND O.HOLD_DATE_TIME IS NOT NULL AND A.CANCEL_YN='N' AND O.ORDER_LINE_STATUS IN ('HD','HC')";				
				} 
				else if(status.equals("R")) {
					sql_append	=	" AND A.RETURNED_QTY IS NOT NULL ";
				
				} 
				else if(status.equals("CN")) {
					sql_append	=	" AND A.CANCEL_YN='Y' ";
					
				} 
				else if(status.equals("PG")) {          
					sql_append	=	" AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS IN ('PO','PC','PS','PQ') "; //Added ORDER_LINE_STATUS IN ('PO','PC','PS','PQ') 'PQ' for ML-MMOH-CRF-1823-US008
						
				} 
				/*else if(status.equals("PN")) {
					sql_append ="";
				} */
				else if(status.equals("PO")) {
					sql_append	=	" AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS = 'PO' ";
				
				}
				else if(status.equals("PC")) {
					sql_append	=	" AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS = 'PC' ";				
				} 
				else if(status.equals("PS")) {
					sql_append	=	" AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS = 'PS' ";
				
				} 
				else {
					sql_append	=	"AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL /*AND A.DISCONT_DATE_TIME IS NULL*/ "; //Commented for ML-BRU-SCF-2068
				}
			}
			else if((pat_class.equals("IP") || pat_class.equals("DC")) && status.equals("A")) {
				sql_append	=	" AND SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS NOT IN ('PO','PQ','PS','CN','HD','HC','DC')"; //Added ORDER_LINE_STATUS 'PQ' for ML-MMOH-CRF-1823-US008
			} 
			else if((pat_class.equals("OP") || pat_class.equals("EM")) && status.equals("A")) {
				sql_append	=	" AND SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND (NVL(A.TOT_ISSUED_QTY,0)-NVL(A.RETURNED_QTY,0))>=0 AND O.ORDER_LINE_STATUS NOT IN ('PO','PQ','PS','CN','HD','HC','DC')"; //Added ORDER_LINE_STATUS 'PQ' for ML-MMOH-CRF-1823-US008
				// ('PO','PS','OS','RG','VF','HC','HD','CN','DC','AL')";
			} 
			else if(status.equals("A")) {
				sql_append	=	" AND ((A.PATIENT_CLASS = 'IP' AND SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND (NVL(A.TOT_ISSUED_QTY,0)-NVL(A.RETURNED_QTY,0))>=0 AND O.ORDER_LINE_STATUS NOT IN ('PO','PQ','PS','CN','HD','HC','DC')) OR (A.PATIENT_CLASS IN( 'OP' ,'XT') AND SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND (NVL(A.TOT_ISSUED_QTY,0)-NVL(A.RETURNED_QTY,0))>=0 AND O.ORDER_LINE_STATUS NOT IN ('PO','PQ','PS','CN','HD','HC','DC')))";//Added ORDER_LINE_STATUS 'PQ' for ML-MMOH-CRF-1823-US008
				//	('PO','PS','OS','RG','VF','HC','HD','CN','DC','AL')))";
			} 
			else if(status.equals("F")) {
				sql_append	=	" AND A.START_DATE > SYSDATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL ";
			} 
			else if(status.equals("C")) {
				sql_append	=	" AND SYSDATE >= A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL  AND O.ORDER_LINE_STATUS IN ('DF')";
			} 
			else	if(status.equals("DC")) {
				sql_append	=	" AND O.DISC_DATE_TIME IS NOT NULL AND A.CANCEL_YN='N'";
				index = 3;
			} 
			else if(status.equals("HD") || status.equals("HC")) {
				sql_append	=	" AND O.HOLD_DATE_TIME IS NOT NULL AND A.CANCEL_YN='N' AND O.ORDER_LINE_STATUS IN ('HD','HC')";
				index = 3;
			} 
			else if(status.equals("R")) {
				sql_append	=	" AND A.RETURNED_QTY IS NOT NULL ";
				index = 3;
			} 
			else if(status.equals("CN")) {
				sql_append	=	" AND A.CANCEL_YN='Y' ";
				index = 3;
			} 
			else if(status.equals("PG")) {          
				sql_append	=	" AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS IN ('PO','PC','PS','PQ') "; //Added ORDER_LINE_STATUS 'PQ' for ML-MMOH-CRF-1823-US008
				index = 3;
			} 
			else if(status.equals("PN")) {
				index = 3;
			} 
			else if(status.equals("PO")) {
				sql_append	=	" AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS = 'PO' ";
				index = 3;
			}
			else if(status.equals("PC")) {
				sql_append	=	" AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS = 'PC' ";
				index = 3;
			} 
			else if(status.equals("PS")) {
				sql_append	=	" AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS = 'PS' ";
				index = 3;
			} 
			else {
				index = 3;
			}
		
			//Common parameters.
			HashMap sqlMap = new HashMap();
			/*String sqlXT	 = "SELECT A.ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO, A.SRL_NO, A.IV_PREP_YN, Q.IV_PREP_YN LINE_IV_PREP_YN, Q.DISCHARGE_IND, O.ORDER_LINE_STATUS, O.CHILD_ORDER_YN, A.INFUSE_OVER, A.TRN_TYPE_IND, A.DRUG_CODE, C.DRUG_DESC, A.DISPENSED_DRUGS, F.ROUTE_CODE, decode(A.IV_PREP_YN,'6',' ',F.ROUTE_DESC) ROUTE_DESC,    DECODE(a.iv_prep_yn, '6',((RTRIM(rtrim(to_char(o.qty_value, '999999990.999999'),'0'),'.'))||' '||O.QTY_UNIT|| ' , '|| CHR (13)  || DECODE (a.split_yn, 'Y', '(Divided)', h.freq_desc || ' , ')|| CHR (13)|| DURATION|| ' '|| i.durn_desc),(decode(s.SLIDING_SCALE_YN ,'Y','Sliding Scale',( RTRIM(rtrim(to_char(a.dosage, '999999990.999999'),'0'),'.') )|| ' '|| g.short_desc)|| ' , '|| CHR (13)|| DECODE (a.split_yn, 'Y', '(Divided)', h.freq_desc || ' , ')|| CHR (13)|| DURATION|| ' '|| i.durn_desc)) DOSAGE_DETAILS, TO_CHAR (A.START_DATE, 'DD/MM/YYYY HH24:MI') START_DATE, TO_CHAR (A.END_DATE, 'DD/MM/YYYY HH24:MI') END_DATE, A.PATIENT_CLASS, D.PATIENT_NAME, E.PRACTITIONER_NAME, J.FACILITY_NAME, K.SHORT_DESC LOCATION, (CASE WHEN Q.CAN_REASON IS NOT NULL  THEN 'HOLD' WHEN O.CAN_DATE_TIME IS NOT NULL  THEN 'CANCEL' WHEN O.HOLD_DATE_TIME IS NOT NULL  THEN 'HOLD' WHEN O.DISC_DATE_TIME IS NOT NULL  THEN 'DIS-CONTINUED' WHEN SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) != 0  THEN 'ACTIVE' ELSE 'INACTIVE' END ) STATUS, (SELECT COUNT (*)    FROM OR_ORDER_LINE_FIELD_VALUES B   WHERE B.ORDER_ID = A.ORIG_ORDER_ID     AND B.ORDER_LINE_NUM = A.ORIG_ORDER_LINE_NO) REMARKS, S.PRES_QTY_UOM PRES_BASE_UOM , O.LAST_ACTION_REASON_DESC, A.HEIGHT, A.HEIGHT_UOM, A.WEIGHT, A.WEIGHT_UOM, A.BSA, A.BMI, A.PRESCRIBED_QTY, A.TOT_ISSUED_QTY, A.RETURNED_QTY, A.TOT_ADMINISTERED_QTY, A.DOSAGE_UOM_CODE, A.REISSUED_QTY, A.REISSUE_DATE_TIME, A.REISSUE_REASON_CODE, O.ORDER_UOM, TO_CHAR (A.RETURN_DATE_TIME, 'DD/MM/YYYY') RETURN_DATE_TIME, (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) RET_DIFF , c.STRENGTH_PER_VALUE_PRES_UOM, c.CONTENT_IN_PRES_BASE_UOM,R.SHORT_DESC LINE_STATUS_DESC, (select FORMULARY_ITEM_YN from or_order_line_ph where order_id = o.order_id and order_line_num = o.order_line_num) FORMULARY_ITEM_YN ,  s.SLIDING_SCALE_YN, a.SLIDING_SCALE_ADM_UNIT, a.SLIDING_SCALE_ADM_UOM,ph_get_alternates(A.ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO) alternates,(select COMPLETE_ORDER_REASON from or_order_line_ph where order_id = o.order_id and order_line_num = o.order_line_num) COMPLETE_ORDER_REASON,h.freq_nature,S.DOSAGE_TYPE dosage_type,S.MFR_YN mfrYN, (SELECT COUNT(*) FROM PH_MEDN_ADMIN WHERE ORDER_ID=A.ORIG_ORDER_ID AND ORDER_LINE_NUM=A.ORIG_ORDER_LINE_NO AND ADMN_DOSE_CHNG_REMARKS IS NOT NULL) ADMIN_DOSE_CHNG_REASON_CNT,O.QTY_UNIT,nvl(a.split_yn,'N') split_dose_yn FROM PH_PATIENT_DRUG_PROFILE A, PH_GENERIC_NAME_LANG_VW B, PH_DRUG_LANG_VW C, MP_PATIENT D, AM_PRACTITIONER_LANG_VW E, PH_ROUTE_LANG_VW F, AM_UOM_LANG_VW G, AM_FREQUENCY_LANG_VW H, AM_DURATION_TYPE_LANG_VW I, SM_FACILITY_PARAM_LANG_VW J, OP_CLINIC_LANG_VW K, IP_NURSING_UNIT_LANG_VW L, OR_ORDER_LINE O, OR_ORDER Q,OR_ORDER_STATUS_CODE_LANG_VW R,or_order_line_ph s WHERE Q.ORDER_ID = O.ORDER_ID AND A.PATIENT_ID = ? AND A.PATIENT_CLASS =  NVL (?, '!')  AND A.START_DATE BETWEEN TO_DATE ( NVL (?,'01/01/1472'), 'DD/MM/YYYY')  AND TO_DATE ( NVL (?,'31/12/5000'), 'DD/MM/YYYY') + 0.99999 AND A.GENERIC_ID BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.DRUG_CODE BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.GENERIC_ID = B.GENERIC_ID AND D.PATIENT_ID = A.PATIENT_ID AND A.DRUG_CODE = C.DRUG_CODE AND E.PRACTITIONER_ID = A.PRES_PRACTITIONER_ID AND F.ROUTE_CODE = C.ROUTE_CODE AND G.UOM_CODE = A.DOSAGE_UOM_CODE AND H.FREQ_CODE = A.FREQ_CODE AND I.DURN_TYPE = A.DURN_TYPE AND J.FACILITY_ID = A.ORIG_FACILITY_ID AND K.FACILITY_ID(+) = A.ORIG_FACILITY_ID AND K.CLINIC_CODE(+) = A.LOCN_CODE AND L.FACILITY_ID(+) = A.ORIG_FACILITY_ID AND L.NURSING_UNIT_CODE(+) = A.LOCN_CODE AND A.ORIG_ORDER_ID = O.ORDER_ID AND A.ORIG_ORDER_LINE_NO = O.ORDER_LINE_NUM AND O.ORDER_LINE_STATUS = R.ORDER_STATUS_CODE 	and o.order_id=s.order_id and O.ORDER_LINE_NUM=s.ORDER_LINE_NUM	AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = F.LANGUAGE_ID AND B.LANGUAGE_ID = G.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID AND B.LANGUAGE_ID = I.LANGUAGE_ID AND B.LANGUAGE_ID = J.LANGUAGE_ID AND B.LANGUAGE_ID = R.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND B.LANGUAGE_ID = ? AND K.LANGUAGE_ID(+) = ? AND L.LANGUAGE_ID(+) = ?";*/

			/*+ NO_EXPAND 	String sqlNormal = "SELECT  A.ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO, A.SRL_NO, A.IV_PREP_YN, Q.IV_PREP_YN LINE_IV_PREP_YN, Q.DISCHARGE_IND, O.ORDER_LINE_STATUS, O.CHILD_ORDER_YN, A.INFUSE_OVER, A.TRN_TYPE_IND, A.DRUG_CODE, C.DRUG_DESC, A.DISPENSED_DRUGS, A.ROUTE_CODE, decode(A.IV_PREP_YN,'6',' ',F.ROUTE_DESC) ROUTE_DESC, DECODE(a.iv_prep_yn, '6',((RTRIM(rtrim(to_char(o.qty_value, '999999990.999999'),'0'),'.'))||' '||O.QTY_UNIT|| ' , '|| CHR (13)|| DECODE (a.split_yn, 'Y', '(Divided)', h.freq_desc || ' , ')|| CHR (13)   || DURATION|| ' '|| i.durn_desc),(decode(s.SLIDING_SCALE_YN ,'Y','Sliding Scale',( RTRIM(rtrim(to_char(a.dosage, '999999990.999999'),'0'),'.') )|| ' '|| g.short_desc)|| ' , '|| CHR (13)|| DECODE (a.split_yn, 'Y', '(Divided)', h.freq_desc || ' , ')|| CHR (13)|| DURATION|| ' '|| i.durn_desc)) DOSAGE_DETAILS, TO_CHAR (A.START_DATE, 'DD/MM/YYYY HH24:MI') START_DATE, TO_CHAR (A.END_DATE, 'DD/MM/YYYY HH24:MI') END_DATE, decode(p.patient_class,null,'XT',p.patient_class) patient_class, D.PATIENT_NAME, E.PRACTITIONER_NAME, J.FACILITY_NAME, DECODE (P.ASSIGN_CARE_LOCN_TYPE, NULL, M.SHORT_DESC,'N', L.SHORT_DESC, 'C', K.SHORT_DESC ) LOCATION,(CASE WHEN Q.CAN_REASON IS NOT NULL  THEN 'HOLD' WHEN O.CAN_DATE_TIME IS NOT NULL  THEN 'CANCEL' WHEN O.HOLD_DATE_TIME IS NOT NULL THEN 'HOLD' WHEN O.DISC_DATE_TIME IS NOT NULL THEN 'DIS-CONTINUED' WHEN SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) != 0 THEN 'ACTIVE' ELSE 'INACTIVE' END ) STATUS, (SELECT COUNT (*) FROM OR_ORDER_LINE_FIELD_VALUES B  WHERE B.ORDER_ID = A.ORIG_ORDER_ID  AND B.ORDER_LINE_NUM = A.ORIG_ORDER_LINE_NO) REMARKS, S.PRES_QTY_UOM PRES_BASE_UOM, O.LAST_ACTION_REASON_DESC, A.HEIGHT, A.HEIGHT_UOM, A.WEIGHT, A.WEIGHT_UOM, A.BSA, A.BMI, A.PRESCRIBED_QTY, A.TOT_ISSUED_QTY, A.RETURNED_QTY, A.TOT_ADMINISTERED_QTY, A.DOSAGE_UOM_CODE, A.REISSUED_QTY, TO_CHAR (A.REISSUE_DATE_TIME,        'DD/MM/YYYY HH24:MI') REISSUE_DATE_TIME, A.REISSUE_REASON_CODE, O.ORDER_UOM, TO_CHAR (A.RETURN_DATE_TIME, 'DD/MM/YYYY HH24:MI') RETURN_DATE_TIME, (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) RET_DIFF, C.STRENGTH_PER_VALUE_PRES_UOM, C.CONTENT_IN_PRES_BASE_UOM,R.SHORT_DESC LINE_STATUS_DESC, (select FORMULARY_ITEM_YN from or_order_line_ph where order_id = o.order_id and order_line_num = o.order_line_num) FORMULARY_ITEM_YN,  s.SLIDING_SCALE_YN, a.SLIDING_SCALE_ADM_UNIT, a.SLIDING_SCALE_ADM_UOM,ph_get_alternates(A.ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO) alternates,(select COMPLETE_ORDER_REASON from or_order_line_ph where order_id = o.order_id and order_line_num = o.order_line_num) COMPLETE_ORDER_REASON,h.FREQ_NATURE, S.DOSAGE_TYPE dosage_type,S.MFR_YN mfrYN,(SELECT COUNT(*) FROM PH_MEDN_ADMIN WHERE ORDER_ID=A.ORIG_ORDER_ID AND ORDER_LINE_NUM=A.ORIG_ORDER_LINE_NO AND ADMN_DOSE_CHNG_REMARKS IS NOT NULL) ADMIN_DOSE_CHNG_REASON_CNT,O.QTY_UNIT,nvl(a.split_yn,'N') split_dose_yn FROM PH_PATIENT_DRUG_PROFILE A, PH_GENERIC_NAME_LANG_VW B, PH_DRUG_LANG_VW C, MP_PATIENT D, AM_PRACTITIONER_LANG_VW E, PH_ROUTE_LANG_VW F, AM_UOM_LANG_VW G, AM_FREQUENCY_LANG_VW H, AM_DURATION_TYPE_LANG_VW I, SM_FACILITY_PARAM_LANG_VW J, OP_CLINIC_LANG_VW K, IP_NURSING_UNIT_LANG_VW L, AM_REFERRAL_LANG_VW M, OR_ORDER_LINE O, PR_ENCOUNTER P, OR_ORDER Q,OR_ORDER_STATUS_CODE_LANG_VW R ,or_order_line_ph s WHERE Q.ORDER_ID = O.ORDER_ID AND A.PATIENT_ID = ? AND p.PATIENT_CLASS = ? AND A.START_DATE BETWEEN TO_DATE(NVL (?,'01/01/1472'), 'DD/MM/YYYY')   AND TO_DATE(NVL (?,'31/12/5000'), 'DD/MM/YYYY') + 0.99999 AND A.GENERIC_ID BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.DRUG_CODE BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.GENERIC_ID = B.GENERIC_ID AND D.PATIENT_ID = A.PATIENT_ID AND A.DRUG_CODE = C.DRUG_CODE AND E.PRACTITIONER_ID = A.PRES_PRACTITIONER_ID AND F.ROUTE_CODE = A.ROUTE_CODE AND G.UOM_CODE = A.DOSAGE_UOM_CODE AND H.FREQ_CODE = A.FREQ_CODE AND I.DURN_TYPE = A.DURN_TYPE AND J.FACILITY_ID = A.ORIG_FACILITY_ID AND K.FACILITY_ID(+) = A.ORIG_FACILITY_ID AND K.CLINIC_CODE(+) = A.LOCN_CODE AND  M.REFERRAL_CODE(+) = A.LOCN_CODE AND L.FACILITY_ID(+) = A.ORIG_FACILITY_ID AND L.NURSING_UNIT_CODE(+) = A.LOCN_CODE AND A.ORIG_ORDER_ID = O.ORDER_ID AND A.ORIG_ORDER_LINE_NO = O.ORDER_LINE_NUM AND P.ENCOUNTER_ID(+) = A.ENCOUNTER_ID AND P.FACILITY_ID(+) = A.ORIG_FACILITY_ID AND O.ORDER_LINE_STATUS = R.ORDER_STATUS_CODE and o.order_id=s.order_id and O.ORDER_LINE_NUM=s.ORDER_LINE_NUM AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = F.LANGUAGE_ID AND B.LANGUAGE_ID = G.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID AND B.LANGUAGE_ID = I.LANGUAGE_ID AND B.LANGUAGE_ID = J.LANGUAGE_ID AND B.LANGUAGE_ID = R.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND K.LANGUAGE_ID(+) = ? AND L.LANGUAGE_ID(+) = ? AND M.LANGUAGE_ID(+) = ?";*/
			
			/*	+ NO_EXPAND 		String sqlALL = "SELECT   A.ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO, A.SRL_NO, A.IV_PREP_YN, Q.IV_PREP_YN LINE_IV_PREP_YN, Q.DISCHARGE_IND, O.ORDER_LINE_STATUS, O.CHILD_ORDER_YN, A.INFUSE_OVER, A.TRN_TYPE_IND, A.DRUG_CODE, C.DRUG_DESC, A.DISPENSED_DRUGS, A.ROUTE_CODE, decode(A.IV_PREP_YN,'6',' ',F.ROUTE_DESC) ROUTE_DESC, DECODE(a.iv_prep_yn, '6',((RTRIM(rtrim(to_char(o.qty_value, '999999990.999999'),'0'),'.'))||' '||O.QTY_UNIT|| ' , '|| CHR (13)|| DECODE (a.split_yn, 'Y', '(Divided)', h.freq_desc || ' , ')|| CHR (13)   || DURATION|| ' '|| i.durn_desc),(decode(s.SLIDING_SCALE_YN ,'Y','Sliding Scale',( RTRIM(rtrim(to_char(a.dosage, '999999990.999999'),'0'),'.') )|| ' '|| g.short_desc)|| ' , '|| CHR (13)|| DECODE (a.split_yn, 'Y', '(Divided)', h.freq_desc || ' , ')|| CHR (13)|| DURATION|| ' '|| i.durn_desc)) DOSAGE_DETAILS, TO_CHAR (A.START_DATE, 'DD/MM/YYYY HH24:MI') START_DATE, TO_CHAR (A.END_DATE, 'DD/MM/YYYY HH24:MI') END_DATE, decode(p.patient_class,null,'XT',p.patient_class) patient_class, D.PATIENT_NAME, E.PRACTITIONER_NAME, J.FACILITY_NAME, DECODE (P.ASSIGN_CARE_LOCN_TYPE, NULL, M.SHORT_DESC,'N', L.SHORT_DESC, 'C', K.SHORT_DESC ) LOCATION,(CASE WHEN Q.CAN_REASON IS NOT NULL  THEN 'HOLD' WHEN O.CAN_DATE_TIME IS NOT NULL  THEN 'CANCEL' WHEN O.HOLD_DATE_TIME IS NOT NULL THEN 'HOLD' WHEN O.DISC_DATE_TIME IS NOT NULL THEN 'DIS-CONTINUED' WHEN SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) != 0 THEN 'ACTIVE' ELSE 'INACTIVE' END ) STATUS, (SELECT COUNT (*) FROM OR_ORDER_LINE_FIELD_VALUES B  WHERE B.ORDER_ID = A.ORIG_ORDER_ID  AND B.ORDER_LINE_NUM = A.ORIG_ORDER_LINE_NO) REMARKS, S.PRES_QTY_UOM PRES_BASE_UOM, O.LAST_ACTION_REASON_DESC, A.HEIGHT, A.HEIGHT_UOM, A.WEIGHT, A.WEIGHT_UOM, A.BSA, A.BMI, A.PRESCRIBED_QTY, A.TOT_ISSUED_QTY, A.RETURNED_QTY, A.TOT_ADMINISTERED_QTY, A.DOSAGE_UOM_CODE, A.REISSUED_QTY, TO_CHAR (A.REISSUE_DATE_TIME,        'DD/MM/YYYY HH24:MI') REISSUE_DATE_TIME, A.REISSUE_REASON_CODE, O.ORDER_UOM, TO_CHAR (A.RETURN_DATE_TIME, 'DD/MM/YYYY HH24:MI') RETURN_DATE_TIME, (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) RET_DIFF, C.STRENGTH_PER_VALUE_PRES_UOM, C.CONTENT_IN_PRES_BASE_UOM,R.SHORT_DESC LINE_STATUS_DESC, (select FORMULARY_ITEM_YN from or_order_line_ph where order_id = o.order_id and order_line_num = o.order_line_num) FORMULARY_ITEM_YN,  s.SLIDING_SCALE_YN, a.SLIDING_SCALE_ADM_UNIT, a.SLIDING_SCALE_ADM_UOM,ph_get_alternates(A.ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO) alternates,(select COMPLETE_ORDER_REASON from or_order_line_ph where order_id = o.order_id and order_line_num = o.order_line_num) COMPLETE_ORDER_REASON,h.FREQ_NATURE, S.DOSAGE_TYPE dosage_type,S.MFR_YN mfrYN,(SELECT COUNT(*) FROM PH_MEDN_ADMIN WHERE ORDER_ID=A.ORIG_ORDER_ID AND ORDER_LINE_NUM=A.ORIG_ORDER_LINE_NO AND ADMN_DOSE_CHNG_REMARKS IS NOT NULL) ADMIN_DOSE_CHNG_REASON_CNT,O.QTY_UNIT,nvl(a.split_yn,'N') split_dose_yn  FROM PH_PATIENT_DRUG_PROFILE A, PH_GENERIC_NAME_LANG_VW B, PH_DRUG_LANG_VW C, MP_PATIENT D, AM_PRACTITIONER_LANG_VW E, PH_ROUTE_LANG_VW F, AM_UOM_LANG_VW G, AM_FREQUENCY_LANG_VW H, AM_DURATION_TYPE_LANG_VW I, SM_FACILITY_PARAM_LANG_VW J, OP_CLINIC_LANG_VW K, IP_NURSING_UNIT_LANG_VW L, AM_REFERRAL_LANG_VW M, OR_ORDER_LINE O, PR_ENCOUNTER P, OR_ORDER Q,OR_ORDER_STATUS_CODE_LANG_VW R ,or_order_line_ph s WHERE Q.ORDER_ID = O.ORDER_ID AND A.PATIENT_ID = ?  AND A.START_DATE BETWEEN TO_DATE(NVL (?,'01/01/1472'), 'DD/MM/YYYY')   AND TO_DATE(NVL (?,'31/12/5000'), 'DD/MM/YYYY') + 0.99999 AND A.GENERIC_ID BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.DRUG_CODE BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.GENERIC_ID = B.GENERIC_ID AND D.PATIENT_ID = A.PATIENT_ID AND A.DRUG_CODE = C.DRUG_CODE AND E.PRACTITIONER_ID = A.PRES_PRACTITIONER_ID AND F.ROUTE_CODE = A.ROUTE_CODE AND G.UOM_CODE = A.DOSAGE_UOM_CODE AND H.FREQ_CODE = A.FREQ_CODE AND I.DURN_TYPE = A.DURN_TYPE AND J.FACILITY_ID = A.ORIG_FACILITY_ID AND K.FACILITY_ID(+) = A.ORIG_FACILITY_ID AND K.CLINIC_CODE(+) = A.LOCN_CODE AND  M.REFERRAL_CODE(+) = A.LOCN_CODE AND L.FACILITY_ID(+) = A.ORIG_FACILITY_ID AND L.NURSING_UNIT_CODE(+) = A.LOCN_CODE AND A.ORIG_ORDER_ID = O.ORDER_ID AND A.ORIG_ORDER_LINE_NO = O.ORDER_LINE_NUM AND P.ENCOUNTER_ID(+) = A.ENCOUNTER_ID AND P.FACILITY_ID(+) = A.ORIG_FACILITY_ID AND O.ORDER_LINE_STATUS = R.ORDER_STATUS_CODE and o.order_id=s.order_id and O.ORDER_LINE_NUM=s.ORDER_LINE_NUM AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = F.LANGUAGE_ID AND B.LANGUAGE_ID = G.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID AND B.LANGUAGE_ID = I.LANGUAGE_ID AND B.LANGUAGE_ID = J.LANGUAGE_ID AND B.LANGUAGE_ID = R.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND K.LANGUAGE_ID(+) = ? AND L.LANGUAGE_ID(+) = ? AND M.LANGUAGE_ID(+) = ?";
			*/

			//String mfrQuery = "select SL_NO, TOT_STRENGTH, TOT_STRENGTH_UOM, INFUSE_OVER, INFUSE_OVER_UNIT, INFUSION_RATE, INFUSION_VOL_STR_UNIT, INFUSION_PER_UNIT, ADMIN_RATE_DETAIL from OR_ORDER_LINE_PH_MFR where ORDER_ID=? ORDER_LINE_NUM=?";

			if(pat_class.equals("XT")){
				//	sqlMap.put( "sqlData", PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT2B") +  sql_append + " ORDER BY A.START_DATE DESC,A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO");
				stMainSql = "SELECT A.ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO, A.SRL_NO, A.IV_PREP_YN, Q.IV_PREP_YN LINE_IV_PREP_YN, Q.DISCHARGE_IND, O.ORDER_LINE_STATUS, O.CHILD_ORDER_YN, A.INFUSE_OVER, A.TRN_TYPE_IND, A.DRUG_CODE, C.DRUG_DESC, A.DISPENSED_DRUGS, a.ROUTE_CODE, decode(A.IV_PREP_YN,'6',' ',ph_get_desc.ph_route ##REQDB## (a.route_code,b.language_id,'1')) ROUTE_DESC,    decode(drug_yn,'N','',DECODE(a.iv_prep_yn, '6',((RTRIM(rtrim(to_char(o.qty_value, '999999990.999999'),'0'),'.'))||' '||am_get_desc.am_uom ##REQDB## (o.qty_unit,b.language_id,'2')|| CHR (13) || DECODE (a.split_yn, 'Y', '(Divided), ',', ') || h.freq_desc || ', ' || CHR (13)|| DURATION|| ' '|| am_get_desc.am_duration_type ##REQDB## (a.durn_type,b.language_id,'1')),(decode(s.SLIDING_SCALE_YN ,'Y',''/*'Sliding Scale'*/,( RTRIM(rtrim(to_char(a.dosage, '999999990.999999'),'0'),'.') )|| ' '|| am_get_desc.am_uom ##REQDB## (a.dosage_uom_code,b.language_id,'2') )|| CHR (13)|| DECODE (a.split_yn, 'Y', '(Divided), ', ', ') || h.freq_desc || ', '|| CHR (13)|| DURATION|| ' '|| am_get_desc.am_duration_type ##REQDB## (a.durn_type,b.language_id,'1'))) )DOSAGE_DETAILS, decode(drug_yn,'N','',TO_CHAR (A.START_DATE, 'DD/MM/YYYY HH24:MI')) START_DATE, decode(drug_yn,'N','',TO_CHAR (A.END_DATE, 'DD/MM/YYYY HH24:MI')) END_DATE, A.PATIENT_CLASS, am_get_desc.am_practitioner ##REQDB## (a.pres_practitioner_id,b.language_id,'1') PRACTITIONER_NAME, sm_get_desc.sm_facility_param ##REQDB## (a.orig_facility_id,b.language_id,'1') FACILITY_NAME, op_get_desc.OP_CLINIC ##REQDB## (a.orig_facility_id,a.locn_code,b.language_id,'2') LOCATION, (CASE /* SRR20056-SCF-7416 [Incident No. 27457] WHEN Q.CAN_REASON IS NOT NULL  THEN 'HOLD'  */ WHEN O.CAN_DATE_TIME IS NOT NULL  THEN 'CANCEL' WHEN O.HOLD_DATE_TIME IS NOT NULL  THEN 'HOLD' WHEN O.DISC_DATE_TIME IS NOT NULL  THEN 'DIS-CONTINUED' WHEN SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) != 0  THEN 'ACTIVE' ELSE 'INACTIVE' END ) STATUS, (SELECT COUNT (*)  FROM OR_ORDER_LINE_FIELD_VALUES  ##REQDB## B   WHERE B.ORDER_ID = A.ORIG_ORDER_ID AND B.ORDER_LINE_NUM = A.ORIG_ORDER_LINE_NO) REMARKS, S.PRES_QTY_UOM PRESCRIBED_UOM , O.LAST_ACTION_REASON_DESC, A.HEIGHT, A.HEIGHT_UOM, A.WEIGHT, A.WEIGHT_UOM, A.BSA, A.BMI, A.PRESCRIBED_QTY, A.TOT_ISSUED_QTY, A.RETURNED_QTY, A.TOT_ADMINISTERED_QTY, A.DOSAGE_UOM_CODE, A.REISSUED_QTY, A.REISSUE_DATE_TIME, A.REISSUE_REASON_CODE, O.ORDER_UOM, TO_CHAR (A.RETURN_DATE_TIME, 'DD/MM/YYYY') RETURN_DATE_TIME, (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) RET_DIFF , c.STRENGTH_PER_VALUE_PRES_UOM, c.CONTENT_IN_PRES_BASE_UOM, c.PRES_BASE_UOM, R.SHORT_DESC LINE_STATUS_DESC, s.FORMULARY_ITEM_YN ,  s.SLIDING_SCALE_YN, a.SLIDING_SCALE_ADM_UNIT, a.SLIDING_SCALE_ADM_UOM,ph_get_alternates ##REQDB## (A.ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO) alternates,s.COMPLETE_ORDER_REASON,h.freq_nature,S.DOSAGE_TYPE dosage_type,S.MFR_YN mfrYN, (SELECT COUNT(*) FROM PH_MEDN_ADMIN ##REQDB## WHERE ORDER_ID=A.ORIG_ORDER_ID AND ORDER_LINE_NUM=A.ORIG_ORDER_LINE_NO AND ADMN_DOSE_CHNG_REMARKS IS NOT NULL) ADMIN_DOSE_CHNG_REASON_CNT,O.QTY_UNIT,nvl(a.split_yn,'N') split_dose_yn,a.PRN_REMARKS,K.ROUTE_COLOR,s.AMENDED_BY_ID,s.AMEND_REASON_CODE,s.AMEND_REASON,s.AMENDED_DATE,A.STRENGTH, A.ALT_DRUG_REMARKS, s.VERIFY_REMARKS, s.PREGNANCY_OVERRIDE_REASON, S.ALLOCATE_REMARKS_CODE, s.allocate_task_finding,s.FILL_REMARKS_CODE, s.fill_task_finding,s.DELIVERY_REMARKS_CODE, s.delivery_task_finding, (select count(DISP_NO)  from ph_disp_dtl where order_id=o.order_id and order_line_no=o.order_line_num)DISPENSE_COUNT,Q.home_leave_medn_yn,Q.REF_SENT_REMARKS,S.DISC_CANCELLED_ORDERS, S.LAST_DISPENSED_DATE,B.GENERIC_NAME,q.ref_sent_pract_id,O.ORDER_QTY ,s.MFR_REMARKS,C.DRUG_SEARCH_BY,C.STRENGTH_VALUE,C.STRENGTH_UOM,decode(A.IV_PREP_YN,'6',' ',ph_get_desc.ph_form ##REQDB## (a.form_code,b.language_id,'1')) FORM_DESC";//O.ORDER_QTY added for ARYU-SCF-0034 and MFR_REMARKS added for SKR-SCF-1370  AND ,C.DRUG_SEARCH_BY,C.STRENGTH_VALUE,C.STRENGTH_UOM ADDED FOR NMC-JD-CRF-0126
				//Added for ML-MMOH-CRF-0510[IN060510] START
				
				if(site){
			    stMainSql = stMainSql+"  ,am_get_desc.am_practitioner ##REQDB## ((SELECT added_by_id FROM ph_patient_drug_profile ##REQDB## WHERE orig_order_id = o.order_id and ORIG_ORDER_LINE_NO=o.ORDER_LINE_NUM AND drug_code = c.drug_code),b.language_id,'1') ADDED_BY_ID";
				//and ORIG_ORDER_LINE_NO=o.ORDER_LINE_NUM ADDED FOR ml-mmoh-scf-1021
				}
				else{stMainSql=stMainSql+",A.ADDED_BY_ID";
				}
				//Added for ML-MMOH-CRF-0510[IN060510] END
				//Modified for  ML-MMOH-CRF-0510[IN060510]
				stMainSql =stMainSql+" FROM PH_PATIENT_DRUG_PROFILE ##REQDB## A, PH_GENERIC_NAME_LANG_VW ##REQDB## B, PH_DRUG_LANG_VW ##REQDB## C, AM_FREQUENCY_LANG_VW ##REQDB## H, OR_ORDER_LINE ##REQDB## O, OR_ORDER ##REQDB## Q,OR_ORDER_STATUS_CODE_LANG_VW ##REQDB## R,or_order_line_ph ##REQDB## s ,PH_ROUTE ##REQDB## K WHERE Q.ORDER_ID = O.ORDER_ID AND A.PATIENT_ID = ? AND A.PATIENT_CLASS =  NVL (?, '!')  AND A.START_DATE BETWEEN TO_DATE ( NVL (?,'01/01/1472'), 'DD/MM/YYYY')  AND TO_DATE ( NVL (?,'31/12/5000'), 'DD/MM/YYYY') + 0.99999 AND A.GENERIC_ID BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.DRUG_CODE BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.GENERIC_ID = B.GENERIC_ID AND A.DRUG_CODE = C.DRUG_CODE AND H.FREQ_CODE = A.FREQ_CODE AND A.ORIG_ORDER_ID = O.ORDER_ID AND K.ROUTE_CODE=A.ROUTE_CODE AND A.ORIG_ORDER_LINE_NO = O.ORDER_LINE_NUM AND O.ORDER_LINE_STATUS = R.ORDER_STATUS_CODE 	and o.order_id=s.order_id and O.ORDER_LINE_NUM=s.ORDER_LINE_NUM	AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID AND B.LANGUAGE_ID = R.LANGUAGE_ID AND B.LANGUAGE_ID = ? and c.DRUG_YN='Y' ";//Added HOME_LEAVE_MEDN_YN for Bru-HIMS-CRF-093-DD1[IN047223] // A.STRENGTH is added for IN-30262  //s.AMENDED_BY_ID,s.AMEND_REASON_CODE,s.AMEND_REASON,s.AMENDED_DATE feilds are added for ML-BRU-SCF-0098 [IN031837] && code  s.ALLOCATE_TASK_FINDING ,s.FILL_TASK_FINDING,s.DELIVERY_TASK_FINDING added for ML-BRU-SCF-0971[IN042220] && Q.REF_SENT_REMARKS  Added for HSA-CRF-0155 [IN048487] ADDED B.GENERIC_NAME for AAKH-CRF-0088 [IN:060357] q.ref_sent_pract_id,added ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510]
				if(!ReqDb.equals("")){
					stMainSql =stMainSql+" AND A.ENCOUNTER_ID = ?" ;
				}
					stMainSql=stMainSql.replaceAll("##REQDB##",ReqDb);
				//}
				sqlMap.put( "sqlData", stMainSql +  sql_append + " ORDER BY A.START_DATE DESC,A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO");
			}
			else if(pat_class.equals("IP")) { //do not query discharge medication patient orders added for ML-MMOH-SCF-0328 [IN058775]
				/* Added for ML-MMOH-CRF-0532 [IN061327] start */
					if(siteOrder || display_transfer_locn){ //display_transfer_locn added for SKR-SCF-1239
					ip_patient_order="q.orig_source_code";

					}
					else{
					ip_patient_order="a.locn_code";
					}
					
					stMainSql = "SELECT A.ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO, A.SRL_NO, A.IV_PREP_YN, Q.IV_PREP_YN LINE_IV_PREP_YN, Q.DISCHARGE_IND, O.ORDER_LINE_STATUS, O.CHILD_ORDER_YN, A.INFUSE_OVER, A.TRN_TYPE_IND, A.DRUG_CODE, C.DRUG_DESC, A.DISPENSED_DRUGS, A.ROUTE_CODE, decode(A.IV_PREP_YN,'6',' ',ph_get_desc.ph_route ##REQDB## (a.route_code,b.language_id,'1')) ROUTE_DESC,decode(drug_yn,'N','', DECODE(a.iv_prep_yn, '6',((RTRIM(rtrim(to_char(o.qty_value, '999999990.999999'),'0'),'.'))||' '||am_get_desc.am_uom ##REQDB## (o.qty_unit,b.language_id,'2')|| CHR (13)|| DECODE (a.split_yn, 'Y', '(Divided), ', ', ') || h.freq_desc || ', '|| CHR (13)   || DURATION|| ' '|| am_get_desc.am_duration_type ##REQDB## (a.durn_type,b.language_id,'1')),(decode(s.SLIDING_SCALE_YN ,'Y',''/*'Sliding Scale'*/,( RTRIM(rtrim(to_char(a.dosage, '999999990.999999'),'0'),'.') )|| ' '|| am_get_desc.am_uom ##REQDB## (a.dosage_uom_code,b.language_id,'2'))|| CHR (13)|| DECODE (a.split_yn, 'Y', '(Divided), ',', ') || h.freq_desc || ', '|| CHR (13)|| DURATION|| ' '|| am_get_desc.am_duration_type ##REQDB## (a.durn_type,b.language_id,'1'))) )DOSAGE_DETAILS, decode(drug_yn,'N','',TO_CHAR (A.START_DATE, 'DD/MM/YYYY HH24:MI') )START_DATE, decode(drug_yn,'N','',TO_CHAR (A.END_DATE, 'DD/MM/YYYY HH24:MI')) END_DATE, decode(p.patient_class,null,'XT',p.patient_class) patient_class, am_get_desc.am_practitioner ##REQDB## (a.pres_practitioner_id,b.language_id,'1') PRACTITIONER_NAME, sm_get_desc.sm_facility_param ##REQDB## (a.orig_facility_id,b.language_id,'1') FACILITY_NAME, DECODE (a.locn_type, NULL, am_get_desc.am_referral ##REQDB## (a.locn_code,b.language_id,'2'),'N', ip_get_desc.ip_nursing_unit (a.orig_facility_id,NVL("+ip_patient_order+",a.locn_code),b.language_id,'2'), 'C', op_get_desc.OP_CLINIC ##REQDB## (a.orig_facility_id,a.locn_code,b.language_id,'2') ) LOCATION,(CASE /* SRR20056-SCF-7416 [Incident No. 27457] WHEN Q.CAN_REASON IS NOT NULL  THEN 'HOLD' */ WHEN O.CAN_DATE_TIME IS NOT NULL  THEN 'CANCEL' WHEN O.HOLD_DATE_TIME IS NOT NULL THEN 'HOLD' WHEN O.DISC_DATE_TIME IS NOT NULL THEN 'DIS-CONTINUED' WHEN SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) != 0 THEN 'ACTIVE' ELSE 'INACTIVE' END ) STATUS, (SELECT COUNT (*) FROM OR_ORDER_LINE_FIELD_VALUES ##REQDB## B  WHERE B.ORDER_ID = A.ORIG_ORDER_ID  AND B.ORDER_LINE_NUM = A.ORIG_ORDER_LINE_NO) REMARKS, S.PRES_QTY_UOM PRESCRIBED_UOM, O.LAST_ACTION_REASON_DESC, A.HEIGHT, A.HEIGHT_UOM, A.WEIGHT, A.WEIGHT_UOM, A.BSA, A.BMI, A.PRESCRIBED_QTY, A.TOT_ISSUED_QTY, A.RETURNED_QTY, A.TOT_ADMINISTERED_QTY, A.DOSAGE_UOM_CODE, A.REISSUED_QTY, TO_CHAR (A.REISSUE_DATE_TIME, 'DD/MM/YYYY HH24:MI') REISSUE_DATE_TIME, A.REISSUE_REASON_CODE, O.ORDER_UOM, TO_CHAR (A.RETURN_DATE_TIME, 'DD/MM/YYYY HH24:MI') RETURN_DATE_TIME, (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) RET_DIFF, C.STRENGTH_PER_VALUE_PRES_UOM, C.CONTENT_IN_PRES_BASE_UOM, c.PRES_BASE_UOM, R.SHORT_DESC LINE_STATUS_DESC, s.FORMULARY_ITEM_YN,  s.SLIDING_SCALE_YN, a.SLIDING_SCALE_ADM_UNIT, a.SLIDING_SCALE_ADM_UOM,ph_get_alternates ##REQDB## (A.ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO) alternates,s.COMPLETE_ORDER_REASON,h.FREQ_NATURE, S.DOSAGE_TYPE dosage_type,S.MFR_YN mfrYN,(SELECT COUNT(*) FROM PH_MEDN_ADMIN ##REQDB## WHERE ORDER_ID=A.ORIG_ORDER_ID AND ORDER_LINE_NUM=A.ORIG_ORDER_LINE_NO AND ADMN_DOSE_CHNG_REMARKS IS NOT NULL) ADMIN_DOSE_CHNG_REASON_CNT,O.QTY_UNIT,nvl(a.split_yn,'N') split_dose_yn,A.PRN_REMARKS, K.ROUTE_COLOR,s.AMENDED_BY_ID,s.AMEND_REASON_CODE,s.AMEND_REASON,s.AMENDED_DATE,A.STRENGTH, A.ALT_DRUG_REMARKS, s.VERIFY_REMARKS, s.PREGNANCY_OVERRIDE_REASON, S.ALLOCATE_REMARKS_CODE, s.allocate_task_finding,s.FILL_REMARKS_CODE, s.fill_task_finding,s.DELIVERY_REMARKS_CODE, s.delivery_task_finding, (select count(DISP_NO)  from ph_disp_dtl ##REQDB## where order_id=o.order_id and order_line_no=o.order_line_num) DISPENSE_COUNT,Q.home_leave_medn_yn,Q.REF_SENT_REMARKS, S.DISC_CANCELLED_ORDERS, S.LAST_DISPENSED_DATE,B.GENERIC_NAME,q.ref_sent_pract_id,O.ORDER_QTY,s.MFR_REMARKS,C.DRUG_SEARCH_BY,C.STRENGTH_VALUE,C.STRENGTH_UOM,decode(A.IV_PREP_YN,'6',' ',ph_get_desc.ph_form ##REQDB## (a.form_code,b.language_id,'1')) FORM_DESC";//O.ORDER_QTY added for ARYU-SCF-0034 and MFR_REMARKS added for SKR-SCF-1370  AND ,C.DRUG_SEARCH_BY,C.STRENGTH_VALUE,C.STRENGTH_UOM ADDED FOR NMC-JD-CRF-0126
					/* Added for ML-MMOH-CRF-0532 [IN061327] end *///Added for ML-MMOH-CRF-0510[IN060510] START
				if(site){
			    stMainSql = stMainSql+"  ,am_get_desc.am_practitioner ##REQDB## ((SELECT added_by_id FROM ph_patient_drug_profile WHERE orig_order_id = o.order_id and ORIG_ORDER_LINE_NO=o.ORDER_LINE_NUM AND drug_code = c.drug_code and PRES_PRACTITIONER_ID <> a.added_by_id),b.language_id,'1') ADDED_BY_ID";
			  //and ORIG_ORDER_LINE_NO=o.ORDER_LINE_NUM ADDED FOR ml-mmoh-scf-1021
				}
				else{stMainSql=stMainSql+",A.ADDED_BY_ID";
				}
				//Added for ML-MMOH-CRF-0510[IN060510] END
				//Modified for ML-MMOH-CRF-0510[IN060510] 
				stMainSql=stMainSql+" FROM PH_PATIENT_DRUG_PROFILE ##REQDB## A, PH_GENERIC_NAME_LANG_VW ##REQDB## B, PH_DRUG_LANG_VW ##REQDB## C, AM_FREQUENCY_LANG_VW ##REQDB## H, OR_ORDER_LINE ##REQDB## O, OR_ORDER ##REQDB## Q,OR_ORDER_STATUS_CODE_LANG_VW ##REQDB## R ,or_order_line_ph ##REQDB## s,PH_ROUTE ##REQDB## K, PR_ENCOUNTER ##REQDB## P WHERE Q.ORDER_ID = O.ORDER_ID AND A.PATIENT_ID = ? AND p.PATIENT_CLASS = ? AND (q.discharge_ind IS NULL OR  q.discharge_ind ='N') AND A.START_DATE BETWEEN TO_DATE(NVL (?,'01/01/1472'), 'DD/MM/YYYY')   AND TO_DATE(NVL (?,'31/12/5000'), 'DD/MM/YYYY') + 0.99999 AND A.GENERIC_ID BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.DRUG_CODE BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.GENERIC_ID = B.GENERIC_ID AND A.DRUG_CODE = C.DRUG_CODE AND H.FREQ_CODE = A.FREQ_CODE AND A.ORIG_ORDER_ID = O.ORDER_ID AND A.ORIG_ORDER_LINE_NO = O.ORDER_LINE_NUM AND O.ORDER_LINE_STATUS = R.ORDER_STATUS_CODE and K.ROUTE_CODE=A.ROUTE_CODE AND o.order_id=s.order_ID and O.ORDER_LINE_NUM=s.ORDER_LINE_NUM AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID AND B.LANGUAGE_ID = R.LANGUAGE_ID AND B.LANGUAGE_ID = ? and c.DRUG_YN ='Y' AND P.ENCOUNTER_ID(+) = A.ENCOUNTER_ID AND P.FACILITY_ID(+) = A.ORIG_FACILITY_ID ";//Added HOME_LEAVE_MEDN_YN for Bru-HIMS-CRF-093-DD1[IN047223] //s.AMENDED_BY_ID,s.AMEND_REASON_CODE,s.AMEND_REASON,s.AMENDED_DATE feilds are added for ML-BRU-SCF-0098 [IN031837] and  A.STRENGTH is added for IN-30262 && code  s.ALLOCATE_TASK_FINDING ,s.FILL_TASK_FINDING,s.DELIVERY_TASK_FINDING added for ML-BRU-SCF-0971[IN042220] && Q.REF_SENT_REMARKS  Added for HSA-CRF-0155 [IN048487] //added PR_ENCOUNTER P  AND P.ENCOUNTER_ID(+) = A.ENCOUNTER_ID AND P.FACILITY_ID(+) = A.ORIG_FACILITY_ID patient_class changed ad decode(p.patient_class,null,'XT',p.patient_class) - a. to p. for AAKH-SCF-0194 [IN:054902] ADDED B.GENERIC_NAME for AAKH-CRF-0088 [IN:060357]added q.ref_sent_pract_id ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510]//OR  q.discharge_ind ='N' added for ICN-63822

				if(!ReqDb.equals("")){
					stMainSql =stMainSql+" AND A.ENCOUNTER_ID = ?" ;
				}
					stMainSql=stMainSql.replaceAll("##REQDB##",ReqDb);
				
				if (!sql_append.equals(""))
					sqlMap.put( "sqlData", stMainSql +  sql_append + " ORDER BY A.START_DATE DESC,A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO");
				else
					sqlMap.put( "sqlData", stMainSql+" ORDER BY A.START_DATE DESC,A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO");
			}
			else if(pat_class.equals("OP")) {//Query discharge medication patient orders as well  added for ML-MMOH-SCF-0328 [IN058775]
				stMainSql = "SELECT A.ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO, A.SRL_NO, A.IV_PREP_YN, Q.IV_PREP_YN LINE_IV_PREP_YN, Q.DISCHARGE_IND, O.ORDER_LINE_STATUS, O.CHILD_ORDER_YN, A.INFUSE_OVER, A.TRN_TYPE_IND, A.DRUG_CODE, C.DRUG_DESC, A.DISPENSED_DRUGS, A.ROUTE_CODE, decode(A.IV_PREP_YN,'6',' ',ph_get_desc.ph_route ##REQDB## (a.route_code,b.language_id,'1')) ROUTE_DESC,decode(drug_yn,'N','', DECODE(a.iv_prep_yn, '6',((RTRIM(rtrim(to_char(o.qty_value, '999999990.999999'),'0'),'.'))||' '||am_get_desc.am_uom ##REQDB## (o.qty_unit,b.language_id,'2')|| CHR (13)|| DECODE (a.split_yn, 'Y', '(Divided), ', ', ') || h.freq_desc || ', '|| CHR (13)   || DURATION|| ' '|| am_get_desc.am_duration_type ##REQDB## (a.durn_type,b.language_id,'1')),(decode(s.SLIDING_SCALE_YN ,'Y',''/*'Sliding Scale'*/,( RTRIM(rtrim(to_char(a.dosage, '999999990.999999'),'0'),'.') )|| ' '|| am_get_desc.am_uom ##REQDB## (a.dosage_uom_code,b.language_id,'2'))|| CHR (13)|| DECODE (a.split_yn, 'Y', '(Divided), ',', ') || h.freq_desc || ', '|| CHR (13)|| DURATION|| ' '|| am_get_desc.am_duration_type ##REQDB## (a.durn_type,b.language_id,'1'))) )DOSAGE_DETAILS, decode(drug_yn,'N','',TO_CHAR (A.START_DATE, 'DD/MM/YYYY HH24:MI') )START_DATE, decode(drug_yn,'N','',TO_CHAR (A.END_DATE, 'DD/MM/YYYY HH24:MI')) END_DATE, decode(p.patient_class,null,'XT',p.patient_class) patient_class, am_get_desc.am_practitioner ##REQDB## (a.pres_practitioner_id,b.language_id,'1') PRACTITIONER_NAME, sm_get_desc.sm_facility_param ##REQDB## (a.orig_facility_id,b.language_id,'1') FACILITY_NAME, DECODE (a.LOCN_TYPE, NULL, am_get_desc.am_referral ##REQDB## (a.locn_code,b.language_id,'2'),'N', ip_get_desc.ip_nursing_unit ##REQDB## (a.orig_facility_id,a.locn_code,b.language_id,'2'), 'C', op_get_desc.OP_CLINIC ##REQDB## (a.orig_facility_id,a.locn_code,b.language_id,'2') ) LOCATION,(CASE /* SRR20056-SCF-7416 [Incident No. 27457] WHEN Q.CAN_REASON IS NOT NULL  THEN 'HOLD' */ WHEN O.CAN_DATE_TIME IS NOT NULL  THEN 'CANCEL' WHEN O.HOLD_DATE_TIME IS NOT NULL THEN 'HOLD' WHEN O.DISC_DATE_TIME IS NOT NULL THEN 'DIS-CONTINUED' WHEN SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) != 0 THEN 'ACTIVE' ELSE 'INACTIVE' END ) STATUS, (SELECT COUNT (*) FROM OR_ORDER_LINE_FIELD_VALUES ##REQDB## B  WHERE B.ORDER_ID = A.ORIG_ORDER_ID  AND B.ORDER_LINE_NUM = A.ORIG_ORDER_LINE_NO) REMARKS, S.PRES_QTY_UOM PRESCRIBED_UOM, O.LAST_ACTION_REASON_DESC, A.HEIGHT, A.HEIGHT_UOM, A.WEIGHT, A.WEIGHT_UOM, A.BSA, A.BMI, A.PRESCRIBED_QTY, A.TOT_ISSUED_QTY, A.RETURNED_QTY, A.TOT_ADMINISTERED_QTY, A.DOSAGE_UOM_CODE, A.REISSUED_QTY, TO_CHAR (A.REISSUE_DATE_TIME, 'DD/MM/YYYY HH24:MI') REISSUE_DATE_TIME, A.REISSUE_REASON_CODE, O.ORDER_UOM, TO_CHAR (A.RETURN_DATE_TIME, 'DD/MM/YYYY HH24:MI') RETURN_DATE_TIME, (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) RET_DIFF, C.STRENGTH_PER_VALUE_PRES_UOM, C.CONTENT_IN_PRES_BASE_UOM, c.PRES_BASE_UOM, R.SHORT_DESC LINE_STATUS_DESC, s.FORMULARY_ITEM_YN,  s.SLIDING_SCALE_YN, a.SLIDING_SCALE_ADM_UNIT, a.SLIDING_SCALE_ADM_UOM,ph_get_alternates ##REQDB## (A.ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO) alternates,s.COMPLETE_ORDER_REASON,h.FREQ_NATURE, S.DOSAGE_TYPE dosage_type,S.MFR_YN mfrYN,(SELECT COUNT(*) FROM PH_MEDN_ADMIN ##REQDB## WHERE ORDER_ID=A.ORIG_ORDER_ID AND ORDER_LINE_NUM=A.ORIG_ORDER_LINE_NO AND ADMN_DOSE_CHNG_REMARKS IS NOT NULL) ADMIN_DOSE_CHNG_REASON_CNT,O.QTY_UNIT,nvl(a.split_yn,'N') split_dose_yn,A.PRN_REMARKS, K.ROUTE_COLOR,s.AMENDED_BY_ID,s.AMEND_REASON_CODE,s.AMEND_REASON,s.AMENDED_DATE,A.STRENGTH, A.ALT_DRUG_REMARKS, s.VERIFY_REMARKS, s.PREGNANCY_OVERRIDE_REASON, S.ALLOCATE_REMARKS_CODE, s.allocate_task_finding,s.FILL_REMARKS_CODE, s.fill_task_finding,s.DELIVERY_REMARKS_CODE, s.delivery_task_finding, (select count(DISP_NO)  from ph_disp_dtl ##REQDB## where order_id=o.order_id and order_line_no=o.order_line_num) DISPENSE_COUNT,Q.home_leave_medn_yn,Q.REF_SENT_REMARKS, S.DISC_CANCELLED_ORDERS, S.LAST_DISPENSED_DATE,B.GENERIC_NAME,q.ref_sent_pract_id,O.ORDER_QTY,s.MFR_REMARKS,C.DRUG_SEARCH_BY,C.STRENGTH_VALUE,C.STRENGTH_UOM,decode(A.IV_PREP_YN,'6',' ',ph_get_desc.ph_form ##REQDB## (a.form_code,b.language_id,'1')) FORM_DESC";//O.ORDER_QTY added for ARYU-SCF-0034 and MFR_REMARKS added for SKR-SCF-1370  AND ,C.DRUG_SEARCH_BY,C.STRENGTH_VALUE,C.STRENGTH_UOM ADDED FOR NMC-JD-CRF-0126
				//Added for ML-MMOH-CRF-0510[IN060510] START
				if(site){
			    stMainSql = stMainSql+"  ,am_get_desc.am_practitioner ##REQDB## ((SELECT added_by_id FROM ph_patient_drug_profile ##REQDB## WHERE orig_order_id = o.order_id and ORIG_ORDER_LINE_NO=o.ORDER_LINE_NUM AND drug_code = c.drug_code and PRES_PRACTITIONER_ID <> a.added_by_id),b.language_id,'1') ADDED_BY_ID";
			  //and ORIG_ORDER_LINE_NO=o.ORDER_LINE_NUM ADDED FOR ml-mmoh-scf-1021 
				}
				else{stMainSql=stMainSql+",A.ADDED_BY_ID";
				}
				//Added for ML-MMOH-CRF-0510[IN060510] END
				//Modified for ML-MMOH-CRF-0510[IN060510] 
				stMainSql=stMainSql+" FROM PH_PATIENT_DRUG_PROFILE ##REQDB## A, PH_GENERIC_NAME_LANG_VW ##REQDB## B, PH_DRUG_LANG_VW ##REQDB## C, AM_FREQUENCY_LANG_VW ##REQDB## H, OR_ORDER_LINE ##REQDB## O, OR_ORDER ##REQDB## Q,OR_ORDER_STATUS_CODE_LANG_VW ##REQDB## R ,or_order_line_ph ##REQDB## s,PH_ROUTE ##REQDB## K, PR_ENCOUNTER ##REQDB## P WHERE Q.ORDER_ID = O.ORDER_ID AND A.PATIENT_ID = ? AND (p.PATIENT_CLASS = ? OR q.discharge_ind = 'D') AND A.START_DATE BETWEEN TO_DATE(NVL (?,'01/01/1472'), 'DD/MM/YYYY')   AND TO_DATE(NVL (?,'31/12/5000'), 'DD/MM/YYYY') + 0.99999 AND A.GENERIC_ID BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.DRUG_CODE BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.GENERIC_ID = B.GENERIC_ID AND A.DRUG_CODE = C.DRUG_CODE AND H.FREQ_CODE = A.FREQ_CODE AND A.ORIG_ORDER_ID = O.ORDER_ID AND A.ORIG_ORDER_LINE_NO = O.ORDER_LINE_NUM AND O.ORDER_LINE_STATUS = R.ORDER_STATUS_CODE and K.ROUTE_CODE=A.ROUTE_CODE AND o.order_id=s.order_ID and O.ORDER_LINE_NUM=s.ORDER_LINE_NUM AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID AND B.LANGUAGE_ID = R.LANGUAGE_ID AND B.LANGUAGE_ID = ? and c.DRUG_YN ='Y' AND P.ENCOUNTER_ID(+) = A.ENCOUNTER_ID AND P.FACILITY_ID(+) = A.ORIG_FACILITY_ID ";//Added HOME_LEAVE_MEDN_YN for Bru-HIMS-CRF-093-DD1[IN047223] //s.AMENDED_BY_ID,s.AMEND_REASON_CODE,s.AMEND_REASON,s.AMENDED_DATE feilds are added for ML-BRU-SCF-0098 [IN031837] and  A.STRENGTH is added for IN-30262 && code  s.ALLOCATE_TASK_FINDING ,s.FILL_TASK_FINDING,s.DELIVERY_TASK_FINDING added for ML-BRU-SCF-0971[IN042220] && Q.REF_SENT_REMARKS  Added for HSA-CRF-0155 [IN048487] //added PR_ENCOUNTER P  AND P.ENCOUNTER_ID(+) = A.ENCOUNTER_ID AND P.FACILITY_ID(+) = A.ORIG_FACILITY_ID patient_class changed ad decode(p.patient_class,null,'XT',p.patient_class) - a. to p. for AAKH-SCF-0194 [IN:054902] ADDED B.GENERIC_NAME for AAKH-CRF-0088 [IN:060357]  added q.ref_sent_pract_id ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510]

				if(!ReqDb.equals("")){
					stMainSql =stMainSql+" AND A.ENCOUNTER_ID = ?" ;
				}
					stMainSql=stMainSql.replaceAll("##REQDB##",ReqDb);
				//}
				if (!sql_append.equals(""))
					sqlMap.put( "sqlData", stMainSql +  sql_append + " ORDER BY A.START_DATE DESC,A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO");
				else
					sqlMap.put( "sqlData", stMainSql+" ORDER BY A.START_DATE DESC,A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO");
			}
			else if(pat_class.equals("")){ 
				/* Added for ML-MMOH-CRF-0532 [IN061327] start */
			if(siteOrder || display_transfer_locn){ ////display_transfer_locn added for SKR-SCF-1239
				ip_patient_order="q.orig_source_code";

				}
				else{
				ip_patient_order="a.locn_code";
				}
			   stMainSql = "SELECT A.ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO, A.SRL_NO, A.IV_PREP_YN, Q.IV_PREP_YN LINE_IV_PREP_YN, Q.DISCHARGE_IND, O.ORDER_LINE_STATUS, O.CHILD_ORDER_YN, A.INFUSE_OVER, A.TRN_TYPE_IND, A.DRUG_CODE, C.DRUG_DESC, A.DISPENSED_DRUGS, A.ROUTE_CODE, decode(A.IV_PREP_YN,'6',' ',ph_get_desc.ph_route ##REQDB## (a.route_code,b.language_id,'1')) ROUTE_DESC, decode(drug_yn,'N','',DECODE(a.iv_prep_yn, '6',((RTRIM(rtrim(to_char(o.qty_value, '999999990.999999'),'0'),'.'))||' '||am_get_desc.am_uom ##REQDB## (o.qty_unit,b.language_id,'2')|| CHR (13)|| DECODE (a.split_yn, 'Y', '(Divided), ',', ') || h.freq_desc || ', '|| CHR (13)   || DURATION|| ' '|| am_get_desc.am_duration_type ##REQDB## (a.durn_type,b.language_id,'1')),(decode(s.SLIDING_SCALE_YN ,'Y',''/*'Sliding Scale'*/,( RTRIM(rtrim(to_char(a.dosage, '999999990.999999'),'0'),'.') )|| ' '|| am_get_desc.am_uom ##REQDB## (a.dosage_uom_code,b.language_id,'2'))|| CHR (13)|| DECODE (a.split_yn, 'Y', '(Divided), ',', ') || h.freq_desc || ', '|| CHR (13)|| DURATION|| ' '|| am_get_desc.am_duration_type(a.durn_type,b.language_id,'1'))) )DOSAGE_DETAILS, decode(drug_yn,'N','',TO_CHAR (A.START_DATE, 'DD/MM/YYYY HH24:MI')) START_DATE, decode(drug_yn,'N','',TO_CHAR (A.END_DATE, 'DD/MM/YYYY HH24:MI')) END_DATE, decode(p.patient_class,null,'XT',p.patient_class) patient_class, am_get_desc.am_practitioner ##REQDB## (a.pres_practitioner_id,b.language_id,'1') practitioner_name, sm_get_desc.sm_facility_param ##REQDB## (a.orig_facility_id,b.language_id,'1') FACILITY_NAME, DECODE (a.LOCN_TYPE, NULL, am_get_desc.am_referral ##REQDB## (a.locn_code,b.language_id,'2'),'N', ip_get_desc.ip_nursing_unit ##REQDB## (a.orig_facility_id,NVL("+ip_patient_order+",a.locn_code),b.language_id,'2'), 'C', op_get_desc.OP_CLINIC ##REQDB## (a.orig_facility_id,a.locn_code,b.language_id,'2') ) LOCATION,(CASE /* SRR20056-SCF-7416 [Incident No. 27457] WHEN Q.CAN_REASON IS NOT NULL  THEN 'HOLD' */ WHEN O.CAN_DATE_TIME IS NOT NULL  THEN 'CANCEL' WHEN O.HOLD_DATE_TIME IS NOT NULL THEN 'HOLD' WHEN O.DISC_DATE_TIME IS NOT NULL THEN 'DIS-CONTINUED' WHEN SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) != 0 THEN 'ACTIVE' ELSE 'INACTIVE' END ) STATUS, (SELECT COUNT (*) FROM OR_ORDER_LINE_FIELD_VALUES ##REQDB## B  WHERE B.ORDER_ID = A.ORIG_ORDER_ID  AND B.ORDER_LINE_NUM = A.ORIG_ORDER_LINE_NO) REMARKS, S.PRES_QTY_UOM PRESCRIBED_UOM, O.LAST_ACTION_REASON_DESC, A.HEIGHT, A.HEIGHT_UOM, A.WEIGHT, A.WEIGHT_UOM, A.BSA, A.BMI, A.PRESCRIBED_QTY, A.TOT_ISSUED_QTY, A.RETURNED_QTY, A.TOT_ADMINISTERED_QTY, A.DOSAGE_UOM_CODE, A.REISSUED_QTY, TO_CHAR (A.REISSUE_DATE_TIME, 'DD/MM/YYYY HH24:MI') REISSUE_DATE_TIME, A.REISSUE_REASON_CODE, O.ORDER_UOM, TO_CHAR (A.RETURN_DATE_TIME, 'DD/MM/YYYY HH24:MI') RETURN_DATE_TIME, (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) RET_DIFF, C.STRENGTH_PER_VALUE_PRES_UOM, C.CONTENT_IN_PRES_BASE_UOM, c.PRES_BASE_UOM, R.SHORT_DESC LINE_STATUS_DESC, s.FORMULARY_ITEM_YN,  s.SLIDING_SCALE_YN, a.SLIDING_SCALE_ADM_UNIT, a.SLIDING_SCALE_ADM_UOM,ph_get_alternates ##REQDB## (A.ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO) alternates,s.COMPLETE_ORDER_REASON,h.FREQ_NATURE, S.DOSAGE_TYPE dosage_type,S.MFR_YN mfrYN,(SELECT COUNT(*) FROM PH_MEDN_ADMIN WHERE ORDER_ID=A.ORIG_ORDER_ID AND ORDER_LINE_NUM=A.ORIG_ORDER_LINE_NO AND ADMN_DOSE_CHNG_REMARKS IS NOT NULL) ADMIN_DOSE_CHNG_REASON_CNT,O.QTY_UNIT,nvl(a.split_yn,'N') split_dose_yn, A.PRN_REMARKS,K.ROUTE_COLOR,s.AMENDED_BY_ID, s.AMEND_REASON_CODE, s.AMEND_REASON, s.AMENDED_DATE,A.STRENGTH, A.ALT_DRUG_REMARKS, s.VERIFY_REMARKS, s.PREGNANCY_OVERRIDE_REASON, S.ALLOCATE_REMARKS_CODE, s.allocate_task_finding,s.FILL_REMARKS_CODE, s.fill_task_finding,s.DELIVERY_REMARKS_CODE, s.delivery_task_finding, (select count(DISP_NO)  from ph_disp_dtl ##REQDB##  where order_id=o.order_id and order_line_no=o.order_line_num) DISPENSE_COUNT,Q.home_leave_medn_yn,Q.REF_SENT_REMARKS, S.DISC_CANCELLED_ORDERS, S.LAST_DISPENSED_DATE,B.GENERIC_NAME,q.ref_sent_pract_id,O.ORDER_QTY,s.MFR_REMARKS,C.DRUG_SEARCH_BY,C.STRENGTH_VALUE,C.STRENGTH_UOM,decode(A.IV_PREP_YN,'6',' ',ph_get_desc.ph_form ##REQDB## (a.form_code,b.language_id,'1')) FORM_DESC";//O.ORDER_QTY added for ARYU-SCF-0034 and MFR_REMARKS added for SKR-SCF-1370  AND ,C.DRUG_SEARCH_BY,C.STRENGTH_VALUE,C.STRENGTH_UOM ADDED FOR NMC-JD-CRF-0126
			   /* Added for ML-MMOH-CRF-0532 [IN061327] end */
			   //Added for ML-MMOH-CRF-0510[IN060510] START
				if(site){
			    stMainSql = stMainSql+"  ,am_get_desc.am_practitioner ##REQDB## ((SELECT added_by_id FROM ph_patient_drug_profile ##REQDB## WHERE orig_order_id = o.order_id and ORIG_ORDER_LINE_NO=o.ORDER_LINE_NUM AND drug_code = c.drug_code and PRES_PRACTITIONER_ID <> a.added_by_id),b.language_id,'1') ADDED_BY_ID";
			  //and ORIG_ORDER_LINE_NO=o.ORDER_LINE_NUM ADDED FOR ml-mmoh-scf-1021
				}
				else{stMainSql=stMainSql+",A.ADDED_BY_ID";
				}
				//Added for ML-MMOH-CRF-0510[IN060510] END
				//Modified for ML-MMOH-CRF-0510[IN060510] 
				stMainSql=stMainSql+" FROM PH_PATIENT_DRUG_PROFILE ##REQDB## A, PH_GENERIC_NAME_LANG_VW ##REQDB## B, PH_DRUG_LANG_VW ##REQDB## C, AM_FREQUENCY_LANG_VW ##REQDB## H, OR_ORDER_LINE ##REQDB## O, OR_ORDER ##REQDB## Q,OR_ORDER_STATUS_CODE_LANG_VW ##REQDB## R ,or_order_line_ph ##REQDB## s ,PH_ROUTE ##REQDB## K, PR_ENCOUNTER ##REQDB## P  WHERE Q.ORDER_ID = O.ORDER_ID AND A.PATIENT_ID = ?  AND A.START_DATE BETWEEN TO_DATE(NVL (?,'01/01/1472'), 'DD/MM/YYYY')   AND TO_DATE(NVL (?,'31/12/5000'), 'DD/MM/YYYY') + 0.99999 AND A.GENERIC_ID BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.DRUG_CODE BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.GENERIC_ID = B.GENERIC_ID AND K.ROUTE_CODE=A.ROUTE_CODE AND A.DRUG_CODE = C.DRUG_CODE AND H.FREQ_CODE = A.FREQ_CODE AND A.ORIG_ORDER_ID = O.ORDER_ID AND A.ORIG_ORDER_LINE_NO = O.ORDER_LINE_NUM AND O.ORDER_LINE_STATUS = R.ORDER_STATUS_CODE and o.order_id=s.order_id and O.ORDER_LINE_NUM=s.ORDER_LINE_NUM AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID AND B.LANGUAGE_ID = R.LANGUAGE_ID AND B.LANGUAGE_ID = ? and c.DRUG_YN ='Y' AND P.ENCOUNTER_ID(+) = A.ENCOUNTER_ID AND P.FACILITY_ID(+) = A.ORIG_FACILITY_ID ";//Added HOME_LEAVE_MEDN_YN for Bru-HIMS-CRF-093-DD1[IN047223] //s.AMENDED_BY_ID,s.AMEND_REASON_CODE,s.AMEND_REASON,s.AMENDED_DATE feilds are added for ML-BRU-SCF-0098 [IN031837] and  A.STRENGTH is added for IN-30262 && code s.ALLOCATE_TASK_FINDING ,s.FILL_TASK_FINDING,s.DELIVERY_TASK_FINDING added for ML-BRU-SCF-0971[IN042220] && Q.REF_SENT_REMARKS  Added for HSA-CRF-0155 [IN048487] //added PR_ENCOUNTER P  AND P.ENCOUNTER_ID(+) = A.ENCOUNTER_ID AND P.FACILITY_ID(+) = A.ORIG_FACILITY_ID patient_class changed ad decode(p.patient_class,null,'XT',p.patient_class) - a. to p. for AAKH-SCF-0194 [IN:054902] ADDED B.GENERIC_NAME for AAKH-CRF-0088 [IN:060357] added q.ref_sent_pract_id,ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510]  
				if(!ReqDb.equals("")){
					stMainSql =stMainSql+" AND A.ENCOUNTER_ID = ?" ;
				}
					stMainSql=stMainSql.replaceAll("##REQDB##",ReqDb);
				//}
				if (!sql_append.equals(""))
					sqlMap.put( "sqlData", stMainSql +  sql_append + " ORDER BY A.START_DATE DESC,A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO");
				else
					sqlMap.put( "sqlData", stMainSql+" ORDER BY A.START_DATE DESC,A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO");
			}
			else {//normal
	//			stMainSql = "SELECT A.ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO, A.SRL_NO, A.IV_PREP_YN, Q.IV_PREP_YN LINE_IV_PREP_YN, Q.DISCHARGE_IND, O.ORDER_LINE_STATUS, O.CHILD_ORDER_YN, A.INFUSE_OVER, A.TRN_TYPE_IND, A.DRUG_CODE, C.DRUG_DESC, A.DISPENSED_DRUGS, A.ROUTE_CODE, decode(A.IV_PREP_YN,'6',' ',ph_get_desc.ph_route(a.route_code,b.language_id,'1')) ROUTE_DESC,decode(drug_yn,'N','', DECODE(a.iv_prep_yn, '6',((RTRIM(rtrim(to_char(o.qty_value, '999999990.999999'),'0'),'.'))||' '||am_get_desc.am_uom (o.qty_unit,b.language_id,'2')|| CHR (13)|| DECODE (a.split_yn, 'Y', '(Divided), ', ', ') || h.freq_desc || ', '|| CHR (13)   || DURATION|| ' '|| am_get_desc.am_duration_type(a.durn_type,b.language_id,'1')),(decode(s.SLIDING_SCALE_YN ,'Y',''/*'Sliding Scale'*/,( RTRIM(rtrim(to_char(a.dosage, '999999990.999999'),'0'),'.') )|| ' '|| am_get_desc.am_uom(a.dosage_uom_code,b.language_id,'2'))|| CHR (13)|| DECODE (a.split_yn, 'Y', '(Divided), ',', ') || h.freq_desc || ', '|| CHR (13)|| DURATION|| ' '|| am_get_desc.am_duration_type(a.durn_type,b.language_id,'1'))) )DOSAGE_DETAILS, decode(drug_yn,'N','',TO_CHAR (A.START_DATE, 'DD/MM/YYYY HH24:MI') )START_DATE, decode(drug_yn,'N','',TO_CHAR (A.END_DATE, 'DD/MM/YYYY HH24:MI')) END_DATE, decode(p.patient_class,null,'XT',p.patient_class) patient_class, am_get_desc.am_practitioner(a.pres_practitioner_id,b.language_id,'1') PRACTITIONER_NAME, sm_get_desc.sm_facility_param(a.orig_facility_id,b.language_id,'1') FACILITY_NAME, DECODE (a.LOCN_TYPE, NULL, am_get_desc.am_referral(a.locn_code,b.language_id,'2'),'N', ip_get_desc.ip_nursing_unit (a.orig_facility_id,a.locn_code,b.language_id,'2'), 'C', op_get_desc.OP_CLINIC (a.orig_facility_id,a.locn_code,b.language_id,'2') ) LOCATION,(CASE /* SRR20056-SCF-7416 [Incident No. 27457] WHEN Q.CAN_REASON IS NOT NULL  THEN 'HOLD' */ WHEN O.CAN_DATE_TIME IS NOT NULL  THEN 'CANCEL' WHEN O.HOLD_DATE_TIME IS NOT NULL THEN 'HOLD' WHEN O.DISC_DATE_TIME IS NOT NULL THEN 'DIS-CONTINUED' WHEN SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) != 0 THEN 'ACTIVE' ELSE 'INACTIVE' END ) STATUS, (SELECT COUNT (*) FROM OR_ORDER_LINE_FIELD_VALUES B  WHERE B.ORDER_ID = A.ORIG_ORDER_ID  AND B.ORDER_LINE_NUM = A.ORIG_ORDER_LINE_NO) REMARKS, S.PRES_QTY_UOM PRESCRIBED_UOM, O.LAST_ACTION_REASON_DESC, A.HEIGHT, A.HEIGHT_UOM, A.WEIGHT, A.WEIGHT_UOM, A.BSA, A.BMI, A.PRESCRIBED_QTY, A.TOT_ISSUED_QTY, A.RETURNED_QTY, A.TOT_ADMINISTERED_QTY, A.DOSAGE_UOM_CODE, A.REISSUED_QTY, TO_CHAR (A.REISSUE_DATE_TIME, 'DD/MM/YYYY HH24:MI') REISSUE_DATE_TIME, A.REISSUE_REASON_CODE, O.ORDER_UOM, TO_CHAR (A.RETURN_DATE_TIME, 'DD/MM/YYYY HH24:MI') RETURN_DATE_TIME, (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) RET_DIFF, C.STRENGTH_PER_VALUE_PRES_UOM, C.CONTENT_IN_PRES_BASE_UOM, c.PRES_BASE_UOM, R.SHORT_DESC LINE_STATUS_DESC, s.FORMULARY_ITEM_YN,  s.SLIDING_SCALE_YN, a.SLIDING_SCALE_ADM_UNIT, a.SLIDING_SCALE_ADM_UOM,ph_get_alternates(A.ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO) alternates,s.COMPLETE_ORDER_REASON,h.FREQ_NATURE, S.DOSAGE_TYPE dosage_type,S.MFR_YN mfrYN,(SELECT COUNT(*) FROM PH_MEDN_ADMIN WHERE ORDER_ID=A.ORIG_ORDER_ID AND ORDER_LINE_NUM=A.ORIG_ORDER_LINE_NO AND ADMN_DOSE_CHNG_REMARKS IS NOT NULL) ADMIN_DOSE_CHNG_REASON_CNT,O.QTY_UNIT,nvl(a.split_yn,'N') split_dose_yn,A.PRN_REMARKS, K.ROUTE_COLOR,s.AMENDED_BY_ID,s.AMEND_REASON_CODE,s.AMEND_REASON,s.AMENDED_DATE,A.STRENGTH, A.ALT_DRUG_REMARKS, s.VERIFY_REMARKS, s.PREGNANCY_OVERRIDE_REASON, S.ALLOCATE_REMARKS_CODE, s.allocate_task_finding,s.FILL_REMARKS_CODE, s.fill_task_finding,s.DELIVERY_REMARKS_CODE, s.delivery_task_finding, (select count(DISP_NO)  from ph_disp_dtl where order_id=o.order_id and order_line_no=o.order_line_num) DISPENSE_COUNT,Q.home_leave_medn_yn,Q.REF_SENT_REMARKS, S.DISC_CANCELLED_ORDERS, S.LAST_DISPENSED_DATE FROM PH_PATIENT_DRUG_PROFILE A, PH_GENERIC_NAME_LANG_VW B, PH_DRUG_LANG_VW C, AM_FREQUENCY_LANG_VW H, OR_ORDER_LINE O, OR_ORDER Q,OR_ORDER_STATUS_CODE_LANG_VW R ,or_order_line_ph s,PH_ROUTE K, PR_ENCOUNTER P WHERE Q.ORDER_ID = O.ORDER_ID AND A.PATIENT_ID = ? AND p.PATIENT_CLASS = ? AND A.START_DATE BETWEEN TO_DATE(NVL (?,'01/01/1472'), 'DD/MM/YYYY')   AND TO_DATE(NVL (?,'31/12/5000'), 'DD/MM/YYYY') + 0.99999 AND A.GENERIC_ID BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.DRUG_CODE BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.GENERIC_ID = B.GENERIC_ID AND A.DRUG_CODE = C.DRUG_CODE AND H.FREQ_CODE = A.FREQ_CODE AND A.ORIG_ORDER_ID = O.ORDER_ID AND A.ORIG_ORDER_LINE_NO = O.ORDER_LINE_NUM AND O.ORDER_LINE_STATUS = R.ORDER_STATUS_CODE and K.ROUTE_CODE=A.ROUTE_CODE AND o.order_id=s.order_ID and O.ORDER_LINE_NUM=s.ORDER_LINE_NUM AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID AND B.LANGUAGE_ID = R.LANGUAGE_ID AND B.LANGUAGE_ID = ? and c.DRUG_YN ='Y' AND P.ENCOUNTER_ID(+) = A.ENCOUNTER_ID AND P.FACILITY_ID(+) = A.ORIG_FACILITY_ID ";//Added HOME_LEAVE_MEDN_YN for Bru-HIMS-CRF-093-DD1[IN047223] //s.AMENDED_BY_ID,s.AMEND_REASON_CODE,s.AMEND_REASON,s.AMENDED_DATE feilds are added for ML-BRU-SCF-0098 [IN031837] and  A.STRENGTH is added for IN-30262 && code  s.ALLOCATE_TASK_FINDING ,s.FILL_TASK_FINDING,s.DELIVERY_TASK_FINDING added for ML-BRU-SCF-0971[IN042220] && Q.REF_SENT_REMARKS  Added for HSA-CRF-0155 [IN048487] //added PR_ENCOUNTER P  AND P.ENCOUNTER_ID(+) = A.ENCOUNTER_ID AND P.FACILITY_ID(+) = A.ORIG_FACILITY_ID patient_class changed ad decode(p.patient_class,null,'XT',p.patient_class) - a. to p. for AAKH-SCF-0194 [IN:054902]
			stMainSql = "SELECT a.orig_order_id, a.orig_order_line_no, a.srl_no, a.iv_prep_yn, q.iv_prep_yn line_iv_prep_yn, q.discharge_ind, o.order_line_status, o.child_order_yn, a.infuse_over, a.trn_type_ind, a.drug_code, c.drug_desc, a.dispensed_drugs, a.route_code, DECODE (a.iv_prep_yn, '6', ' ', ph_get_desc.ph_route ##REQDB## (a.route_code, b.language_id, '1') ) route_desc, DECODE (drug_yn, 'N', '', DECODE (a.iv_prep_yn, '6', ( (RTRIM (RTRIM (TO_CHAR (o.qty_value, '999999990.999999' ), '0' ), '.' ) ) || ' ' || am_get_desc.am_uom ##REQDB## (o.qty_unit, b.language_id, '2' ) || CHR (13) || DECODE (a.split_yn, 'Y', '(Divided), ', ', ') || h.freq_desc || ', ' || CHR (13) || DURATION || ' ' || am_get_desc.am_duration_type ##REQDB## (a.durn_type, b.language_id, '1' ) ), ( DECODE (s.sliding_scale_yn, 'Y', '' /*'Sliding Scale'*/, (RTRIM (RTRIM (TO_CHAR (a.dosage, '999999990.999999' ), '0' ), '.' ) ) || ' ' || am_get_desc.am_uom ##REQDB##  (a.dosage_uom_code, b.language_id, '2' ) ) || CHR (13) || DECODE (a.split_yn, 'Y', '(Divided), ', ', ') || h.freq_desc || ', ' || CHR (13) || DURATION || ' ' || am_get_desc.am_duration_type ##REQDB## (a.durn_type, b.language_id, '1' ) ) ) ) dosage_details, DECODE (drug_yn, 'N', '', TO_CHAR (a.start_date, 'DD/MM/YYYY HH24:MI') ) start_date, DECODE (drug_yn, 'N', '', TO_CHAR (a.end_date, 'DD/MM/YYYY HH24:MI') ) end_date, DECODE (p.patient_class, NULL, 'XT', p.patient_class) patient_class, am_get_desc.am_practitioner ##REQDB## (a.pres_practitioner_id, b.language_id, '1' ) practitioner_name, sm_get_desc.sm_facility_param ##REQDB## (a.orig_facility_id, b.language_id, '1' ) facility_name, DECODE (a.locn_type, NULL, am_get_desc.am_referral (a.locn_code, b.language_id, '2' ), 'N', ip_get_desc.ip_nursing_unit ##REQDB## (a.orig_facility_id, a.locn_code, b.language_id, '2' ), 'C', op_get_desc.op_clinic ##REQDB## (a.orig_facility_id, a.locn_code, b.language_id, '2' ) ) LOCATION, (CASE /* SRR20056-SCF-7416 [Incident No. 27457] WHEN Q.CAN_REASON IS NOT NULL THEN 'HOLD' */ WHEN o.can_date_time IS NOT NULL THEN 'CANCEL' WHEN o.hold_date_time IS NOT NULL THEN 'HOLD' WHEN o.disc_date_time IS NOT NULL THEN 'DIS-CONTINUED' WHEN SYSDATE BETWEEN a.start_date AND a.end_date AND (NVL (a.tot_issued_qty, 0) - NVL (a.returned_qty, 0)) != 0 THEN 'ACTIVE' ELSE 'INACTIVE' END ) status, (SELECT COUNT (*) FROM or_order_line_field_values ##REQDB## b WHERE b.order_id = a.orig_order_id AND b.order_line_num = a.orig_order_line_no) remarks, s.pres_qty_uom prescribed_uom, o.last_action_reason_desc, a.height, a.height_uom, a.weight, a.weight_uom, a.bsa, a.bmi, a.prescribed_qty, a.tot_issued_qty, a.returned_qty, a.tot_administered_qty, a.dosage_uom_code, a.reissued_qty, TO_CHAR (a.reissue_date_time, 'DD/MM/YYYY HH24:MI') reissue_date_time, a.reissue_reason_code, o.order_uom, TO_CHAR (a.return_date_time, 'DD/MM/YYYY HH24:MI') return_date_time, (NVL (a.tot_issued_qty, 0) - NVL (a.returned_qty, 0)) ret_diff, c.strength_per_value_pres_uom, c.content_in_pres_base_uom, c.pres_base_uom, r.short_desc line_status_desc, s.formulary_item_yn, s.sliding_scale_yn, a.sliding_scale_adm_unit, a.sliding_scale_adm_uom, ph_get_alternates ##REQDB## (a.orig_order_id, a.orig_order_line_no) alternates, s.complete_order_reason, h.freq_nature, s.dosage_type dosage_type, s.mfr_yn mfryn, (SELECT COUNT (*) FROM ph_medn_admin ##REQDB## WHERE order_id = a.orig_order_id AND order_line_num = a.orig_order_line_no AND admn_dose_chng_remarks IS NOT NULL) admin_dose_chng_reason_cnt, o.qty_unit, NVL (a.split_yn, 'N') split_dose_yn, a.prn_remarks, k.route_color, s.amended_by_id, s.amend_reason_code, s.amend_reason, s.amended_date, a.strength, a.alt_drug_remarks, s.verify_remarks, s.pregnancy_override_reason, s.allocate_remarks_code, s.allocate_task_finding, s.fill_remarks_code, s.fill_task_finding, s.delivery_remarks_code, s.delivery_task_finding, (SELECT COUNT (disp_no) FROM ph_disp_dtl ##REQDB## WHERE order_id = o.order_id AND order_line_no = o.order_line_num) dispense_count, q.home_leave_medn_yn, q.ref_sent_remarks, s.disc_cancelled_orders, s.last_dispensed_date, b.generic_name, q.ref_sent_pract_id ,O.ORDER_QTY,s.MFR_REMARKS,C.DRUG_SEARCH_BY,C.STRENGTH_VALUE,C.STRENGTH_UOM,decode(A.IV_PREP_YN,'6',' ',ph_get_desc.ph_form ##REQDB## (a.form_code,b.language_id,'1')) FORM_DESC";//O.ORDER_QTY added for ARYU-SCF-0034 and MFR_REMARKS added for SKR-SCF-1370 AND ,C.DRUG_SEARCH_BY,C.STRENGTH_VALUE,C.STRENGTH_UOM ADDED FOR NMC-JD-CRF-0126
			
			if(site){
			    stMainSql = stMainSql+"  ,am_get_desc.am_practitioner ##REQDB## ((SELECT added_by_id FROM ph_patient_drug_profile ##REQDB## WHERE orig_order_id = o.order_id  and ORIG_ORDER_LINE_NO=o.ORDER_LINE_NUM AND drug_code = c.drug_code and PRES_PRACTITIONER_ID <> a.added_by_id),b.language_id,'1') ADDED_BY_ID";
				//and ORIG_ORDER_LINE_NO=o.ORDER_LINE_NUM ADDED FOR ml-mmoh-scf-1021 
			}
				else{stMainSql=stMainSql+",A.ADDED_BY_ID";
				}
			
			stMainSql=stMainSql+" FROM ph_patient_drug_profile ##REQDB## a, ph_generic_name_lang_vw ##REQDB## b, ph_drug_lang_vw ##REQDB## c, am_frequency_lang_vw ##REQDB## h, or_order_line ##REQDB## o, or_order ##REQDB## q, or_order_status_code_lang_vw ##REQDB## r, or_order_line_ph ##REQDB## s, ph_route ##REQDB## k, pr_encounter ##REQDB## p WHERE q.order_id = o.order_id AND a.patient_id = ? AND p.patient_class = ? AND a.start_date BETWEEN TO_DATE (NVL (?, '01/01/1472'), 'DD/MM/YYYY') AND TO_DATE (NVL (?, '31/12/5000'), 'DD/MM/YYYY') + 0.99999 AND a.generic_id BETWEEN NVL (?, '!') AND NVL (?, '~') AND a.drug_code BETWEEN NVL (?, '!') AND NVL (?, '~') AND a.generic_id = b.generic_id AND a.drug_code = c.drug_code AND h.freq_code = a.freq_code AND a.orig_order_id = o.order_id AND a.orig_order_line_no = o.order_line_num AND o.order_line_status = r.order_status_code AND k.route_code = a.route_code AND o.order_id = s.order_id AND o.order_line_num = s.order_line_num AND b.language_id = c.language_id AND b.language_id = h.language_id AND b.language_id = r.language_id AND b.language_id = ? AND c.drug_yn = 'Y' AND p.encounter_id(+) = a.encounter_id AND p.facility_id(+) = a.orig_facility_id /*AND SYSDATE BETWEEN a.start_date AND a.end_date*/ AND a.cancel_yn = 'N' AND a.stop_yn = 'N' AND a.on_hold_date_time IS NULL AND a.discont_date_time IS NULL AND (NVL (a.tot_issued_qty, 0) - NVL (a.returned_qty, 0)) >= 0  ";
			//AND o.order_line_status NOT IN ('PO', 'PS', 'CN', 'HD', 'HC', 'DC') removed for ML-BRU-SCF-1996  removed for ML-BRU-SCF-1996

/*AND SYSDATE BETWEEN a.start_date AND a.end_date*/ // commented for ML-BRU-SCF-1930
			if(!ReqDb.equals("")){
				    stMainSql =stMainSql+" AND A.ENCOUNTER_ID = ?" ;
			  }
					stMainSql=stMainSql.replaceAll("##REQDB##",ReqDb);
				//}

			if (!sql_append.equals(""))
					sqlMap.put( "sqlData", stMainSql +  sql_append + " ORDER BY A.START_DATE DESC,A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO");
				else
					sqlMap.put( "sqlData", stMainSql+" ORDER BY A.START_DATE DESC,A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO");
			}
	System.out.println("sqlMap====425===QueryPateintDrugProfileResult.jsp===>"+sqlMap);//ML-BRU-SCF-2239
		

			HashMap funcMap = new HashMap();

			//The fields are going to be display
			ArrayList displayFields = new ArrayList();
			displayFields.add("IV_PREP_YN");  //0
			displayFields.add("INFUSE_OVER"); //1
			displayFields.add("TRN_TYPE_IND"); //2
			displayFields.add("STATUS"); //3
			displayFields.add("DRUG_CODE"); //4
			displayFields.add("DRUG_DESC");//5
			displayFields.add("ROUTE_CODE"); //6
			displayFields.add("ROUTE_DESC"); //7
			displayFields.add("DOSAGE_DETAILS"); //8
			displayFields.add("START_DATE"); //9
			displayFields.add("END_DATE");  //10
			displayFields.add("PATIENT_CLASS");
			displayFields.add("PRACTITIONER_NAME");
			displayFields.add("LOCATION");
			displayFields.add("FACILITY_NAME");
			displayFields.add("ORIG_ORDER_ID");//15
			displayFields.add("ORIG_ORDER_LINE_NO");
			displayFields.add("SRL_NO");
			displayFields.add("REMARKS");
			displayFields.add("HEIGHT");
			displayFields.add("HEIGHT_UOM");   //20
			displayFields.add("WEIGHT");
			displayFields.add("WEIGHT_UOM");
			displayFields.add("BSA");
			displayFields.add("LINE_IV_PREP_YN");
			displayFields.add("DISCHARGE_IND");   //25
			displayFields.add("LAST_ACTION_REASON_DESC");
			displayFields.add("PRESCRIBED_QTY");
			displayFields.add("TOT_ISSUED_QTY");
			displayFields.add("RETURNED_QTY");
			displayFields.add("RETURN_DATE_TIME");  //30
			displayFields.add("ORDER_UOM");
			displayFields.add("DISPENSED_DRUGS");
			displayFields.add("TOT_ADMINISTERED_QTY");
			displayFields.add("RET_DIFF");
			displayFields.add("ORDER_LINE_STATUS");  //35
			displayFields.add("CHILD_ORDER_YN");
			displayFields.add("DOSAGE_UOM_CODE");
			displayFields.add("BMI");
			displayFields.add("REISSUED_QTY");
			displayFields.add("PRESCRIBED_UOM");  //40
			displayFields.add("STRENGTH_PER_VALUE_PRES_UOM");
			displayFields.add("CONTENT_IN_PRES_BASE_UOM");
			displayFields.add("REISSUE_DATE_TIME");
			displayFields.add("LINE_STATUS_DESC");
			displayFields.add("FORMULARY_ITEM_YN"); 
			displayFields.add("SLIDING_SCALE_YN"); //46
			displayFields.add("SLIDING_SCALE_ADM_UNIT"); 
			displayFields.add("SLIDING_SCALE_ADM_UOM"); 
			displayFields.add("alternates"); 
			displayFields.add("COMPLETE_ORDER_REASON"); //50
			displayFields.add("FREQ_NATURE");
			displayFields.add("dosage_type");
			displayFields.add("ADMIN_DOSE_CHNG_REASON_CNT"); //53
			displayFields.add("QTY_UNIT"); //54
			displayFields.add("mfrYN"); //55
			displayFields.add("split_dose_yn"); //56
			displayFields.add("PRN_REMARKS"); //57
			displayFields.add("ROUTE_COLOR"); //58 // Code Added For CRF - 0034	
			
			displayFields.add("AMENDED_BY_ID");	//below code Added for ML-BRU-SCF-0098 [IN031837] -- Start
			displayFields.add("AMEND_REASON"); //60 
			displayFields.add("AMEND_REASON_CODE");  
			displayFields.add("AMENDED_DATE");	//Above code Added for ML-BRU-SCF-0098 [IN031837] -- End
			displayFields.add("STRENGTH");
			displayFields.add("ALT_DRUG_REMARKS"); //Added for Bru-HIMS-CRF-082 [IN:029948]
			displayFields.add("PREGNANCY_OVERRIDE_REASON"); //Added for RUT-CRF-0063 [IN:029601] //65
			displayFields.add("ALLOCATE_REMARKS_CODE");//code added for ML-BRU-SCF-0971[IN042220] --Start 
			displayFields.add("ALLOCATE_TASK_FINDING");
			displayFields.add("FILL_REMARKS_CODE"); 
			displayFields.add("FILL_TASK_FINDING"); 
			displayFields.add("DELIVERY_REMARKS_CODE");
			displayFields.add("DELIVERY_TASK_FINDING");//code added for ML-BRU-SCF-0971[IN042220] --End
			displayFields.add("DISPENSE_COUNT");//code added for  ML-BRU-SCF-1116 [IN:044786] //72
			displayFields.add("PRES_BASE_UOM");//code added for  ML-BRU-SCF-1190 [IN:045647] //73
			displayFields.add("home_leave_medn_yn");//Added for Bru-HIMS-CRF-093-DD1[IN047223]
			displayFields.add("REF_SENT_REMARKS");//Added for HSA-CRF-0155 [IN048487]
			displayFields.add("DISC_CANCELLED_ORDERS");//Added for HSA-CRF-0138 [IN:048414] //76
			displayFields.add("LAST_DISPENSED_DATE");//Added for HSA-CRF-0138 [IN:048414] //77
			displayFields.add("VERIFY_REMARKS");//Added for ML-MMOH-SCF-0327 [IN:058772] //78
			displayFields.add("GENERIC_NAME");//ADDED GENERIC_NAME for AAKH-CRF-0088 [IN:060357]
			displayFields.add("REF_SENT_PRACT_ID");//added ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510] //ML-MMOH-SCF-2399
			//displayFields.add("ADDED_BY_ID");//added ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510] // PH-Regression-COMMON-Patient Drug Profile-Dispensing unit
			displayFields.add("ADDED_BY_ID");//added ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510] 
			displayFields.add("ORDER_QTY");//82//Added for ARYU-SCF-0034
			displayFields.add("MFR_REMARKS");//83 added for skr-scf-1370
			displayFields.add("DRUG_SEARCH_BY");//84 added for NMC-JD-CRF-0126
			displayFields.add("STRENGTH_VALUE");//85 added for NMC-JD-CRF-0126
			displayFields.add("STRENGTH_UOM");//86 added for NMC-JD-CRF-0126
			displayFields.add("FORM_DESC");//87 added for NMC-JD-CRF-0126
			 
			ArrayList chkFields = new ArrayList();
			chkFields.add( patient_id.trim() );
		if (!pat_class.equals("")){
			    chkFields.add( pat_class.trim() );
			System.out.println("pat_class====527===QueryPateintDrugProfileResult.jsp===>"+pat_class.trim());//ML-BRU-SCF-2239
		}
			chkFields.add( dt_from.trim() );
		System.out.println("dt_from====527===QueryPateintDrugProfileResult.jsp=====>"+dt_from.trim());//ML-BRU-SCF-2239
			chkFields.add( dt_to.trim() );
		System.out.println("dt_to====527===QueryPateintDrugProfileResult.jsp===>"+dt_to.trim());//ML-BRU-SCF-2239
			chkFields.add( generic_id.trim() );
		System.out.println("generic_id====527===QueryPateintDrugProfileResult.jsp===>"+generic_id.trim());//ML-BRU-SCF-2239
			chkFields.add( generic_id.trim() );
		System.out.println("generic_id====527===QueryPateintDrugProfileResult.jsp===>"+generic_id.trim());//ML-BRU-SCF-2239
			chkFields.add( drug_code.trim() );
		System.out.println("drug_code====527===QueryPateintDrugProfileResult.jsp===>"+drug_code.trim());//ML-BRU-SCF-2239
			chkFields.add( drug_code.trim() );
		System.out.println("drug_code====527===QueryPateintDrugProfileResult.jsp===>"+drug_code.trim());//ML-BRU-SCF-2239
			chkFields.add( locale.trim() );
		System.out.println("locale====527===QueryPateintDrugProfileResult.jsp===>"+locale.trim());//ML-BRU-SCF-2239
			if(!ReqDb.equals("")){
				chkFields.add( enc_id1.trim() );
			System.out.println("enc_id1====527===QueryPateintDrugProfileResult.jsp===>"+enc_id1.trim());//ML-BRU-SCF-2239
			}
			//chkFields.add( locale.trim() );
			//chkFields.add( locale.trim() );
			//chkFields.add( locale.trim() );
			// Adding function related array list into the HashMap
			funcMap.put( "displayFields", displayFields );
			funcMap.put( "chkFields", chkFields );
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);
			if( (result.size()>=index) && ( !( ((String) result.get(0)).equals("0")) )){
				result = bean.getAllDisplayedRecords(result);
				String linkYN="N";
				if (result.size()<index){
%>
					<script>
						alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
					</script>
<%
					return;
				}
%>
				<table id="drugprofileid" cellpadding=0  cellspacing=0  align="center">
					<tr>
						<td width="100%" align="left"class="white">&nbsp;
<%
							// For display the previous/next link
							out.println(result.get(1));
%>
						</td>
					</tr>
				</table>
<%
				//Retriving the records from result arraylist
				StringBuffer title_buffer	= new StringBuffer();
				ArrayList records	=new ArrayList();
				String ht_wt_title	=	"";

				String order_line_no	=	"";
				String line_iv_prep_yn	=	"";
				String dtls				=	"";
				String discharge_med	=	"";
				String pres_qty			=	"";
				String disp_qty			=	"";
				String ret_qty			=	"";
				String disp_uom			=	"";
				String stock_uom        =   "";
				String ret_uom			=	"";
				String ret_date			=	"";
				String disp_drugs		=	"";
				String tot_admin_qty	=	"";
				String admin_uom		=	"";
				String ret_diff			=	"";
				String line_status		=	"";
				String child_order		=	"";
				String reissue_qty		=	"";
				String classVal			=	"";
				String pres_uom			=	"";
				String patient_class	=	"";
				String reissue_uom		=	"";
				String strength_per_pres_uom = "";
				String content_in_pres_base_uom = "";
				String reissue_date_time = "";
				String line_status_text			= "";
				String strIVPrepYN = "";
				String drug_status = "";
				String order_id    = "";	
				String order_line_num	= "";
				String sr_no			= "";
				String future_yn		=	"";
				String expiry_yn		=	"";
				String formulary_item_yn		=	"";
				String sliding_scale_yn		=	"";
				String alternates		= "N";
				String freq_nature		= "";
				String route_color="";   // Coded Added For CRF 0034
				String pres_base_uom = ""; //Added for ML-BRU-SCF-1190 [IN:045647]
				String home_leave_medn_yn = "";//Added for Bru-HIMS-CRF-093-DD1[IN047223]
				String ref_sent_remarks="";//Added for HSA-CRF-0155 [IN048487]
				String amended_by_id ="";   /* code Added for ML-BRU-SCF-0098 [IN031837] -- Start*/	
				String amend_reason ="";  
				String amend_reason_code ="";  
				String amended_date ="";  	/*code Added for ML-BRU-SCF-0098 [IN031837] -- End*/	
				String disc_cancelled_orders = "", disc_cancelled_orders_display="display:none", last_dispensed_date=""; //Added for HSA-CRF-0138 [IN:048414]

				String strength_value =""; // Added for IN-30262
				String alt_drug_remarks ="", stkey; // Added for Bru-HIMS-CRF-082 [IN:029948]
				String pregnancy_override_reason =""; // Added for RUT-CRF-0063 [IN:029601]
				String complete_reason 		= null;//Added for MMS-SCF-0196
				String allocate_remarks_code="", allocate_finding = "", fill_remarks_code="", fill_finding = "", delivery_remarks_code="", delivery_finding= "", verify_remarks="";//Code added for ML-BRU-SCF-0971[IN042220]
				String dispense_count ="";
				String order_qty="";//Added for ARYU-SCF-0034
				String drug_search_by ="";//Added for NMC-JD-CRF-0126
				String drug_strength ="";//Added for NMC-JD-CRF-0126
				String drug_strength_uom ="";//Added for NMC-JD-CRF-0126
				String pre_alloc_drug_desc="";//Added for NMC-JD-CRF-0126
				String form_desc="";//Added for NMC-JD-CRF-0126
				if(disp_locn_code!=null && disp_locn_code.equals("Dispense")){ //Added for Bru-Bru-HIMS-CRF-081 [IN:029947] - Start
				    heightpx="165px";
				   // scroll="auto";
				}
				else{
				    heightpx="315px"; //Modified for ML-MMOH-SCF-1919
				}//Added for Bru-HIMS-CRF-081 [IN:029947] - End
				
				//Added for NMC-JD-CRF-0119
				if(generic_name_max_len_app)
				{
					scrolling="scroll";
				}
				else
				{
					scrolling="hidden"; //Modified for ML-MMOH-SCF-1919
				}
				//Added for NMC-JD-CRF-0119
%>
				<div id='table_container_left' style='overflow:<%=scrolling%>;width:360px;height:<%=heightpx%>;position:relative;float:left;' >   <!-- local:360px and main:225px FOr BSP-SCF-0037 -->
					<table   border="1" cellpadding="0" cellspacing="0" align="left" id='table_container_left_1'>
						<tr style='height:40px;' style='position:relative' style='top:expression(this.offsetParent.scrollTop-2)'>
							<td class='COLUMNHEADER' style="border:none">&nbsp;&nbsp;&nbsp;&nbsp;</td>							
	<%				
				if(!pre_alloc_yn.equals("Y")) //modified for NMC-JD-CRF-0126 - Start// MODIFIED for MMS-QF-SCF-0648
				{
	 %>	
					<td class='COLUMNHEADER' nowrap><fmt:message key="ePH.Prescribed/DispensedDrug.label" bundle="${ph_labels}"/></td>   <!--nowrap Added for IN:063627 --><!--nowrap Added for BSP-SCF-0037 --><!--nowrap Added for BSP-SCF-0042 -->
					<td class='COLUMNHEADER' ><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></td>
	<%	
				}else if(pre_alloc_yn.equals("Y") && generic_name_max_len_app ){
	%>
					<td class='COLUMNHEADER' nowrap width='100%'><fmt:message key="ePH.GenericName/TradeName.label" bundle="${ph_labels}"/></td>
	<%
				}
				else{
				
					 %>	
						<td class='COLUMNHEADER' nowrap><fmt:message key="ePH.Prescribed/DispensedDrug.label" bundle="${ph_labels}"/></td>   <!--nowrap Added for IN:063627 --><!--nowrap Added for BSP-SCF-0037 --><!--nowrap Added for BSP-SCF-0042 -->
						<td class='COLUMNHEADER' ><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></td>
		<%
				}//modified for NMC-JD-CRF-0126 - End
	%>
			
						</tr>
<%
						for(int recCount=2; recCount<result.size(); recCount++) {
							strIVPrepYN		=	"";       
							drug_status		=	"";       
							order_id		=	"";	   
							order_line_num	=	"";  
							sr_no			=	"";  
							future_yn		=	"";
							expiry_yn		=	"";
							//freq_nature		=	"";
							ht_wt_title		=	"";
							if ( recCount % 2 == 0 )
								classvalue = "QRYODD" ;
							else
								classvalue = "QRYEVEN" ;

							records=(ArrayList) result.get( recCount );
							for(int colCount=0; colCount<records.size(); colCount++){
								title_buffer	= new StringBuffer();
								if(records.get(19)!=null) {
									title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.height.label","common_labels"));
									title_buffer.append(":");
									title_buffer.append(CommonBean.checkForNull((String)records.get(19)));
									title_buffer.append("; ");
									title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weight.label","common_labels"));
									title_buffer.append(":");
									title_buffer.append(CommonBean.checkForNull((String)records.get(21)));
									title_buffer.append("; ");
									title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BSA.label","common_labels"));
									title_buffer.append(":");
									title_buffer.append(CommonBean.checkForNull((String)records.get(23)));
									title_buffer.append("; ");
									title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BMI.label","common_labels"));
									title_buffer.append(":");
									title_buffer.append(CommonBean.checkForNull((String)records.get(38)));
								}	
								// Added Newly for the KAUH-SCF-049[Inc:33575] Start
								pres_qty		= CommonBean.checkForNull((String)records.get(27));
								if(pres_qty!=null && !pres_qty.equals(""))
									pres_qty = dfToInteger.format(Double.parseDouble(pres_qty));
								disp_qty		= CommonBean.checkForNull((String)records.get(28));
								if(disp_qty!=null && !disp_qty.equals(""))
									disp_qty = dfToInteger.format(Double.parseDouble(disp_qty));
								ret_qty			= CommonBean.checkForNull((String)records.get(29));
								if(ret_qty!=null && !ret_qty.equals(""))
									ret_qty = dfToInteger.format(Double.parseDouble(ret_qty));

								ret_date		= CommonBean.checkForNull((String)records.get(30));
								line_status				= CommonBean.checkForNull((String)records.get(35));
								disp_drugs				= CommonBean.checkForNull((String)records.get(32));
								/*if(!ret_date.equals("") && ret_qty.equals(pres_qty)){
									line_status_text = "Return-Medication";
								}
								else{*/
								line_status_text = CommonBean.checkForNull((String)records.get(44));
								//}
								//Added Newly for the KAUH-SCF-049[Inc:33575] End
								formulary_item_yn		= CommonBean.checkForNull((String)records.get(45));
								child_order				= CommonBean.checkForNull((String)records.get(36));
								discharge_med			= CommonBean.checkForNull((String)records.get(25));
								route_color				= CommonBean.checkForNull((String)records.get(58));//Code added for CRF 0034
								
								amended_by_id			= CommonBean.checkForNull((String)records.get(59));/*below code Added for ML-BRU-SCF-0098 [IN031837] -- Start*/
								amend_reason			= CommonBean.checkForNull((String)records.get(60));
								amend_reason_code		= CommonBean.checkForNull((String)records.get(61));
								amended_date			= CommonBean.checkForNull((String)records.get(62));/*Above code Added for ML-BRU-SCF-0098 [IN031837] -- End*/
							   							   						   
							   	complete_reason 		= CommonBean.checkForNull((String)records.get(50));//Added for MMS-SCF-0196
							   	home_leave_medn_yn = CommonBean.checkForNull((String)records.get(74));//Added for Bru-HIMS-CRF-093-DD1[IN047223]
							   	disc_cancelled_orders = CommonBean.checkForNull((String)records.get(76));//Added for HSA-CRF-0138 [IN:048414] - start
							   	last_dispensed_date = CommonBean.checkForNull((String)records.get(77));//Added for HSA-CRF-0138 [IN:048414] - start
								drug_search_by      = (String)records.get(84)==null?"T":(String)records.get(84);//Added for NM-JD-CRF-0126
								drug_strength      = (String)records.get(85)==null?"":(String)records.get(85);//Added for NM-JD-CRF-0126
								drug_strength_uom      = (String)records.get(86)==null?"":(String)records.get(86);//Added for NM-JD-CRF-0126
								form_desc      = (String)records.get(87)==null?"":(String)records.get(87);//Added for NM-JD-CRF-0126
								if(!disc_cancelled_orders.equals("") && last_dispensed_date.equals(""))
									disc_cancelled_orders_display="display:inline";
								else
									disc_cancelled_orders_display="display:none";
								if (colCount>18)
									continue;
								if (colCount ==0 || colCount==1){
									strIVPrepYN =(String)records.get( 0 );
									if (colCount==0){						
										continue;
									}
									else{
										if (strIVPrepYN.equals("N")){
											linkYN = "N";
										}
										else if (strIVPrepYN.equals("Y")&&(records.get( 1 ) != null)){
											linkYN = "Y";
										}
									}
								}
								else if (colCount == 3){
									drug_status = "";
									disc_cancel = bean.isCancelDiscontinuedApplicable((String)records.get( 15 ),(String)records.get( 16 ));	
									cancel_link_yn       = (String)disc_cancel.get("CANCEL");
									future_yn	=	bean.compareDate((String)records.get(9));
									expiry_yn	=	bean.compareDate((String)records.get(10));
									patient_class	= CommonBean.checkForNull((String)records.get(11));
									disp_qty		= CommonBean.checkForNull((String)records.get(28));
									if(!ret_qty.equals("") ){
										if (line_status.equals("DC"))
											drug_status = "#C40062";
										//else if(expiry_yn.equals("N"))
										//	drug_status = "#FFB66C";
										else
											drug_status = "#FFB66C";
											//DD AND DE added for mms-kh-crf-0014
										if((status.equals("A") || status.equals("*A")) && (line_status.equals("DP") || line_status.equals("DF") || line_status.equals("DD") || line_status.equals("DE")) && (future_yn.equals("N")) && !expiry_yn.equals("N")){
											classVal	= "ACTIVE";
										}
										else{
											if(future_yn.equals("Y")) 
												classVal	= "FUTURE_Rx";
											
											else if(expiry_yn.equals("N"))
											{
												if(expired_order) //modified for MOHE-CRF-0032
												{
													//drug_status = "#FFA500"; //code modified for MOHE-CRF-0032 //commented for MOHE-CRF-0032
													classVal="EXPIRED_ORDER";
												}
											else
												{
												classVal	= "EXPIRED_MEDICATION";
												}
											}
											else if (line_status.equals("CN"))
												classVal	= "CANCEL";
											else if (line_status.equals("DC"))
												classVal	= "DIS-CONTINUED";
											else if(discharge_med.equals("D"))
												classVal="DISCHARGEMED1";
											else if (line_status.equals("HD") || line_status.equals("HC"))
												classVal	= "HOLD";
											else
												classVal	= "ACTIVE";
												//classVal	= "ReturnedMedication";	
										}
									}
									else if (line_status.equals("CN")){
										drug_status = "#990000";
										if(expiry_yn.equals("N"))
										  {
											if(expired_order) //modified for MOHE-CRF-0032
											{
												drug_status = "#FFA500";  //code modified for MOHE-CRF-0032
												classVal="EXPIRED_ORDER";
											}
										    else
											{
											classVal	= "EXPIRED_MEDICATION";
											}
										  }
										
										else
											classVal	= "CANCEL";
									}
									else if (line_status.equals("DC")){
										drug_status = "#C40062";
										if(expiry_yn.equals("N"))
										 {
											if(expired_order) //modified for MOHE-CRF-0032
											{
												drug_status = "#FFA500";  //code modified for MOHE-CRF-0032
												classVal="EXPIRED_ORDER";
											}
										    else
											{
											classVal	= "EXPIRED_MEDICATION";
											}
										  }
										else
											classVal	= "DIS-CONTINUED";
									}
									//DD AND DE added for mms-kh-crf-0014
									else if( ((((String)records.get( colCount )).trim()).equals("ACTIVE")) || ((patient_class.equals("IP") || patient_class.equals("DC")) && (line_status.equals("OS") || line_status.equals("RG") || line_status.equals("IP") || line_status.equals("VF")) ) || ((patient_class.equals("OP") || patient_class.equals("EM")) && (line_status.equals("OS") || line_status.equals("RG") || line_status.equals("IP") || line_status.equals("VF") || line_status.equals("DP") || line_status.equals("DF")|| line_status.equals("DD") || line_status.equals("DE")) )){
										//(line_status.equals("DP") || line_status.equals("DF") )

										if(future_yn.equals("Y")) { 
											drug_status = "#99FFCC";
											classVal	= "FUTURE_Rx";
										}
										else{
											drug_status = "#FF5E5E";
											if(expiry_yn.equals("N")){
												drug_status = "#D9B86C";
												 
												if(expired_order) //modified for MOHE-CRF-0032
													{
													    drug_status = "#FFA500";   //code modified for MOHE-CRF-0032
														classVal="EXPIRED_ORDER";
													}
												else
													{
													    classVal= "EXPIRED_MEDICATION";
													}
													  
											}
											else {
												if(discharge_med.equals("D")){
													drug_status = "#FF9DFF"; // #D9B86C changed to #FF9DFF for ML-BRU-SCF-0941.1 [IN:045176]
													classVal="DISCHARGEMED1";
												}
												else 
													classVal	= "ACTIVE";
											}
											// for outpatient active orders, who are not yet dispensed.
											if((patient_class.equals("OP") || patient_class.equals("EM")) && disp_qty.equals("") && complete_reason.equals("")){
												drug_status = "#8204FF";
											}
										}
									}
									else if(child_order.equals("Y")){
										drug_status = "#B6BC8B";
										if(future_yn.equals("Y")) 
											classVal	= "FUTURE_Rx";
										else
											classVal	= "Refill_Rx";
									}
									else if(future_yn.equals("Y")) { 
										drug_status = "#99FFCC";
										classVal	= "FUTURE_Rx";						
									}
									else if(cancel_link_yn.equals("Y") || (line_status.equals("IP") || line_status.equals("PO") || line_status.equals("PS") || line_status.equals("AL") || line_status.equals("VF")) || (disp_qty.equals("") && !tot_admin_qty.equals("") && complete_reason.equals("")) )  {
										drug_status = "#8204FF";
										if(expiry_yn.equals("N"))
										 {
											if(expired_order) //modified for MOHE-CRF-0032
											{
												drug_status = "#FFA500";  //code modified for MOHE-CRF-0032
												classVal="EXPIRED_ORDER";
											}
										    else
											{
												classVal	= "EXPIRED_MEDICATION";
											}
										  }
										else
											classVal	= "YET_TO_BE_DISPENSED";
									}
									else if (line_status.equals("HD") || line_status.equals("HC")){
										if(expiry_yn.equals("N")){
											drug_status = "#D9B86C";
											if(expired_order) //modified for MOHE-CRF-0032
											{
												drug_status = "#FFA500";  //modified for MOHE-CRF-0032
												classVal="EXPIRED_ORDER";
											}
										}
										else
											drug_status = "#F0F000";
										classVal	= "HOLD";
									}
									else if ((((String)records.get( colCount )).trim()).equals("INACTIVE")&&line_status.equals("DF")){
										classVal	= "ACTIVE";
										drug_status = "#FF5E5E";
										//Added Code for Checking Expired Drugs  on 5/Oct/2010 For the incident num:24069 ---By Sandhya
										if(expiry_yn.equals("N")){
											drug_status = "#D9B86C";
											 
											if(expired_order) //modified for MOHE-CRF-0032
											{
												drug_status = "#FFA500";  //code modified for MOHE-CRF-0032
												classVal="EXPIRED_ORDER";
											}
										    else
											{
												classVal	= "EXPIRED_MEDICATION";
											}
												  
										} //Ends
									}
									else if(expiry_yn.equals("N")){
										drug_status = "#D9B86C";										
										if(expired_order) //modified for MOHE-CRF-0032
										{ 
											drug_status = "#FFA500";  //code modified for MOHE-CRF-0032
											classVal="EXPIRED_ORDER";
										}
									    else
										{
											classVal	= "EXPIRED_MEDICATION";
										}
									}
									else {
										drug_status = "";
										classVal	= classvalue;
									}

									if(line_status.equals("PO") || line_status.equals("PS")){
										title_buffer.append(" / ");
										title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PndngFrAppr.label","ph_labels"));
									}
									ht_wt_title = title_buffer.toString();
									if(line_iv_prep_yn.equals("1") || line_iv_prep_yn.equals("2") || line_iv_prep_yn.equals("3") || line_iv_prep_yn.equals("4") || line_iv_prep_yn.equals("5")){
										if(order_line_no.equals("1"))
											drug_status="#478F8F";
										else
											drug_status="#92C9C9";
									}

									if((status.equals("C") || status.equals("*A")) && ((patient_class.equals("OP") || patient_class.equals("EM")) && (line_status.equals("DP") || line_status.equals("DF") ||line_status.equals("DD")|| line_status.equals("DE")) ) && expiry_yn.equals("N")){
										if(ret_qty.equals("") )
											drug_status="#D9B86C";
										if(expired_order) //modified for MOHE-CRF-0032
										{
											drug_status = "#FFA500";  //code modified for MOHE-CRF-0032
											classVal="EXPIRED_ORDER";
										}
									    else
										{
											classVal	= "EXPIRED_MEDICATION";
										}
									}

									if(status.equals("C") && ((patient_class.equals("OP") || patient_class.equals("EM")) && line_status.equals("OS") ) && child_order.equals("Y") && ret_qty.equals("")){
										drug_status="#D9B86C";
									}

									if(line_status.equals("PO"))
										drug_status="#0099FF";
									else if(line_status.equals("PC"))
										drug_status="#33CC99";
									else if(line_status.equals("PS"))
										drug_status="#C48400";
									if(home_leave_medn_yn.equalsIgnoreCase("Y"))//Added for Bru-HIMS-CRF-093-DD1[IN047223]
										drug_status = "#959500";
									if(formulary_item_yn.equals("N")){
%>          
										<tr style='height:50px;'>
											<td  style="background-color:#FF9999" title="<%=ht_wt_title%>" >&nbsp;&nbsp;</td>
<%
									}
									else{
%>          
										<tr style='height:50px;'>
											<td  style="background-color:<%=drug_status%>" title="<%=ht_wt_title%>" >&nbsp;&nbsp;</td>
<%
									}
								}
								if(line_status.equals("PO") || line_status.equals("PS")){
									title_buffer.append(" / ");
									title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PndngFrAppr.label","ph_labels"));
								}
								ht_wt_title = title_buffer.toString();
								
								if(!generic_name_max_len_app){ //modified for NMC-JD-CRF-0126 - Start //MODIFIED FOR MMS-QF-SCF-0648
								if (colCount==5){
									if(linkYN.equals("Y")){
										order_id=(String)records.get( 15 );
%>
										<td class="<%=classVal%>" title="<%=ht_wt_title%>" ><font class="hyperlink" style="cursor:pointer;" onClick="showMedicationDetails('<%=order_id%>')"><%=(String)records.get( colCount )%></font>
										<label id='lblDiscCancelledOrders_<%=recCount%>' style='cursor:pointer;<%=disc_cancelled_orders_display%>' title='<fmt:message key="ePH.DiscCancelDrugDtls.label" bundle="${ph_labels}"/>'>&nbsp;&nbsp;<img id='discCancelledOrders_<%=recCount%>' src="../../ePH/images/DiscCancelledIndicator.png" onclick='callDiscCancelledOrders("<%=disc_cancelled_orders%>", "<%=java.net.URLEncoder.encode((String)records.get( colCount ),"UTF-8")%>");'  ></label>
										<br><label style="color:brown"><%=disp_drugs%></label></td>
<% 
									}
									else{
										if (classVal.equals("FUTURE_Rx")|| classVal.equals("EXPIRED_MEDICATION")|| classVal.equals("HOLD") || classVal.equals("DISCHARGEMED1") || drug_status.equals("")||line_status.equals("PC") || drug_status.equals("#959500")){ // drug_status.equals("#959500") Added for ML-BRU-SCF-1877 
%>
											<td class="<%=classVal%>"  title="<%=ht_wt_title%>"><font color='black'><%=(String)records.get( colCount )%></font><label id='lblDiscCancelledOrders_<%=recCount%>' style='cursor:pointer;<%=disc_cancelled_orders_display%>'  title='<fmt:message key="ePH.DiscCancelDrugDtls.label" bundle="${ph_labels}"/>'>&nbsp;&nbsp;<img id='discCancelledOrders_<%=recCount%>' src="../../ePH/images/DiscCancelledIndicator.png" onclick='callDiscCancelledOrders("<%=disc_cancelled_orders%>", "<%=java.net.URLEncoder.encode((String)records.get( colCount ),"UTF-8")%>");'></label>
											<br><label style="color:green"><%=disp_drugs%></label></td>
<%
										}
										else { 
%>
											<td class="<%=classVal%>"  title="<%=ht_wt_title%>"><font color='white'><%=(String)records.get( colCount )%></font><label id='lblDiscCancelledOrders_<%=recCount%>' style='cursor:pointer;<%=disc_cancelled_orders_display%>'  title='<fmt:message key="ePH.DiscCancelDrugDtls.label" bundle="${ph_labels}"/>'>&nbsp;&nbsp;<img id='discCancelledOrders_<%=recCount%>' src="../../ePH/images/DiscCancelledIndicator.png" onclick='callDiscCancelledOrders("<%=disc_cancelled_orders%>", "<%=java.net.URLEncoder.encode((String)records.get( colCount ),"UTF-8")%>");'></label>
											<br><label style="color:Green"><%=disp_drugs%></label> </td>
<% 
										}
									}
								}
							} //modified for NMC-JD-CRF-0126 - End
								title_buffer	= null;
								if (colCount==18){ ////added 18 for AAKH-CRF-0088 [IN:060357]  
								  if(!pre_alloc_yn.equals("Y") && generic_name_max_len_app){//MODIFIED FOR MMS-QF-SCF-0648
									  if(drug_search_by.equals("G")){
									     pre_alloc_drug_desc= (String)records.get(79)+" "+drug_strength+" "+drug_strength_uom+" "+form_desc;
									  }else{
                                          pre_alloc_drug_desc =(String)records.get(5);
									  }
								%>
									
									<td class="<%=classvalue%>" title="<%=ht_wt_title%>"><%=pre_alloc_drug_desc%>&nbsp;</td>
									 <td width="111px" class="<%=classvalue%>" title="<%=ht_wt_title%>"><%=(String)records.get( 79 )%>&nbsp;</td><!-- added for MMS-QF-SCF-0648 -->
<%								}
							 else{
%>
                                <td width="111px" class="<%=classvalue%>" title="<%=ht_wt_title%>"><%=(String)records.get( 79 )%>&nbsp;</td>
                                
<%							 }
							}
						 }
							
%>
							</tr>
<%
						}
%>
					</table>
				</div>
<%
				if(disp_locn_code!=null && disp_locn_code.equals("Dispense")){ //Added for Bru-HIMS-CRF-081 [IN:029947] - Start
				    heightpx="165px";
				    //heightpx="180px";
				    scroll="auto";
				}
				else{
				    heightpx="330px";
				    //heightpx="372px";
				}//Added for Bru-HIMS-CRF-081 [IN:029947]- End
%>
				<div id='table_container_right' style='overflow:auto;height:<%=heightpx%>;position:relative;float:right;width:60%;'><!--  Modified for Bru-HIMS-CRF-081 -->
					<table   border="1" cellpadding="0" cellspacing="0" align="left" id='table_container_right_1' style="display: block; overflow-x: auto; white-space: nowrap; width: 100%;" >
						<tr style='height:40px;' style='position:relative' style='top:expression(this.offsetParent.scrollTop-2)'>
							<td class='COLUMNHEADER' style='width:0px;border-right:0' ></td>
							<td class='COLUMNHEADER' nowrap style='border-left:0'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.status.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td class='COLUMNHEADER' nowrap><fmt:message key="Common.Route.label" bundle="${common_labels}"/></td>
							<td class='COLUMNHEADER' nowrap><fmt:message key="ePH.DosageDetail.label" bundle="${ph_labels}"/></td>
							<td class='COLUMNHEADER' nowrap>&nbsp;&nbsp;<fmt:message key="Common.StartDate.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
							<td class='COLUMNHEADER' nowrap>&nbsp;&nbsp;<fmt:message key="Common.enddate.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
							<td class='COLUMNHEADER' nowrap>&nbsp;&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
							<td class='COLUMNHEADER' nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
							
							<td class='COLUMNHEADER' colspan=2 >
								<table   border="1" cellpadding="0" cellspacing="0"  >
									<tr style='height:14px;'>
										<td class='COLUMNHEADER' colspan=2 nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.PrescribedQuantity.label" bundle="${ph_labels}"/>
										</td>
									</tr>
									<tr style='height:1px;'></tr>
									<tr style='height:14px;'>
										<td class='COLUMNHEADER' nowrap width='50%'>&nbsp;<fmt:message key="ePH.PrescribingUnit.label" bundle="${ph_labels}"/>&nbsp;</td>
										<td class='COLUMNHEADER' nowrap width='50%'>&nbsp;<fmt:message key="ePH.DispensingUnit.label" bundle="${ph_labels}"/>&nbsp;</td>
									</tr>
								</table>
							</td>
							<td class='COLUMNHEADER' colspan=2 >
								<table   border="1" cellpadding="0" cellspacing="0" >
									<tr style='height:14px;'>
										<td class='COLUMNHEADER' colspan=2 nowrap>&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.DispenseQuantity.label" bundle="${ph_labels}"/>
										</td>
									</tr>
									<tr style='height:1px;'></tr>
									<tr style='height:14px;'>
										<td class='COLUMNHEADER' nowrap width='50%'>&nbsp;<fmt:message key="ePH.PrescribingUnit.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
										<td class='COLUMNHEADER' nowrap width='50%'><fmt:message key="ePH.DispensingUnit.label" bundle="${ph_labels}"/>&nbsp;</td>
									</tr>
								</table>
							</td>

							<td class='COLUMNHEADER' nowrap ><fmt:message key="ePH.ReturnQuantity/Date.label" bundle="${ph_labels}"/></td>							
								<!-- PrescribedQuantity added for mms-kh-crf-0014 -->
							<td class='COLUMNHEADER' nowrap><fmt:message key="ePH.AdminQuantity.label" bundle="${ph_labels}"/> / <fmt:message key="ePH.PrescribedQuantity.label" bundle="${ph_labels}"/></td>
							<td class='COLUMNHEADER' nowrap><fmt:message key="ePH.ReissuedQuantity.label" bundle="${ph_labels}"/></td>
							<% //Added for ml-mmoh-crf-0510 start  [IN060510]
							if(site){
								%>
							
<!-- 							<td class='COLUMNHEADER'></td> -->
							
							<%	} else{
								%>					
					       <td class='COLUMNHEADER' nowrap><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/></td>
						<%	} ////Added for ml-mmoh-crf-0510 end  [IN060510] %>
							<td class='COLUMNHEADER' nowrap><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/>/ <fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
							<td class='COLUMNHEADER' nowrap><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<%-- 							<td class='COLUMNHEADER' nowrap><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></td> --%>
							<%// Added for ml-mmoh-crf-0510 start  [IN060510]
							if(site){
								
								 %>
							<td class='COLUMNHEADER' nowrap><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/></td>
							<th class='COLUMNHEADER' nowrap><fmt:message key="Common.Transcribed.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.by.label" bundle="${common_labels}"/></th>
						<%	} // Added for ml-mmoh-crf-0510 end [IN060510] %>
						</tr>
<%
						String backgrndColor=""; 
						String fntColor="";
						String mfr_remarks = "";//SKR-SCF-1370
						StringTokenizer st = null;
						for(int recCount=2; recCount<result.size(); recCount++){
							strIVPrepYN				= "";       
							drug_status				= "";       
							order_id				= "";	   
							order_line_num			= "";  
							sr_no					= "";  
							future_yn				= "";
							expiry_yn				= "";
							pres_disp_unit_value	= "";
							dispnsd_disp_unit_value	= "";
							disp_stock_uom			= "";
							alternates				= "N";
							freq_nature				= "";
							dosage_uom_desc         = "";
							fntColor = "";
							backgrndColor = "";
							mfr_remarks = "";

							if ( recCount % 2 == 0 )
								classvalue = "QRYODD" ;
							else
								classvalue = "QRYEVEN" ;

							records=(ArrayList) result.get( recCount );

							ht_wt_title		= "";
							title_buffer	= new StringBuffer(); 
							if(records.get(19)!=null) {
								title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.height.label","common_labels"));
								title_buffer.append(":");
								title_buffer.append(CommonBean.checkForNull((String)records.get(19)));
								title_buffer.append("; ");
								title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weight.label","common_labels"));
								title_buffer.append(":");
								title_buffer.append(CommonBean.checkForNull((String)records.get(21)));
								title_buffer.append("; ");
								title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BSA.label","common_labels"));
								title_buffer.append(":");
								title_buffer.append(CommonBean.checkForNull((String)records.get(23)));
								title_buffer.append("; ");
								title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BMI.label","common_labels"));
								title_buffer.append(":");
								title_buffer.append(CommonBean.checkForNull((String)records.get(38)));
							}	
		
							line_iv_prep_yn	= CommonBean.checkForNull((String)records.get(24));
							order_line_no	= CommonBean.checkForNull((String)records.get(16));
							discharge_med	= CommonBean.checkForNull((String)records.get(25));
							
							pres_qty		= CommonBean.checkForNull((String)records.get(27));
							disp_qty		= CommonBean.checkForNull((String)records.get(28));
							
							if(disp_qty!=null && !disp_qty.equals(""))
								disp_qty = dfToInteger.format(Double.parseDouble(disp_qty));
								
							ret_qty			= CommonBean.checkForNull((String)records.get(29));
							if(ret_qty!=null && !ret_qty.equals(""))
								ret_qty = dfToInteger.format(Double.parseDouble(ret_qty));

							ret_date		= CommonBean.checkForNull((String)records.get(30));
							stock_uom       = CommonBean.checkForNull((String)records.get(31));
							disp_drugs		= CommonBean.checkForNull((String)records.get(32));
							tot_admin_qty	= CommonBean.checkForNull((String)records.get(33));
							ret_diff		= CommonBean.checkForNull((String)records.get(34));
							line_status		= CommonBean.checkForNull((String)records.get(35));
							child_order		= CommonBean.checkForNull((String)records.get(36));
							admin_uom		= CommonBean.checkForNull((String)records.get(37));//DOSAGE_UOM_CODE
							reissue_qty	    = CommonBean.checkForNull((String)records.get(39));
							pres_uom		= CommonBean.checkForNull((String)records.get(40));//PRESCRIBED_UOM
							patient_class	= CommonBean.checkForNull((String)records.get(11));
							strength_per_pres_uom = CommonBean.checkForNull((String)records.get(41));
							content_in_pres_base_uom = CommonBean.checkForNull((String)records.get(42));
							reissue_date_time = CommonBean.checkForNull((String)records.get(43));
							// Added Newly for the KAUH-SCF-049[Inc:33575] Start
							/*if(!ret_date.equals("") && ret_qty.equals(pres_qty)){
								line_status_text = "Return-Medication";
							}
							else{*/
							line_status_text = CommonBean.checkForNull((String)records.get(44));
							//}
							//Added Newly for the KAUH-SCF-049[Inc:33575] End
							order_id		 = CommonBean.checkForNull((String)records.get( 15 ));
							freq_nature		= CommonBean.checkForNull((String)records.get(51));
							dosage_type		= CommonBean.checkForNull((String)records.get(52));
							admin_dose_chng_reason_cnt = CommonBean.checkForNull((String)records.get(53));
							dosage_uom_desc  = CommonBean.checkForNull((String)records.get(54));
							route_color = CommonBean.checkForNull((String)records.get(58));// Code Added CRF -0034 Start
							if(route_color!= null && !route_color.equals("")){
								if(route_color.length()==12){
									fntColor= route_color.substring(0, 6);
									backgrndColor= route_color.substring(6, 12);
								}
							}
                           //Code Added  CRF -0034 End
						   /*below code Added for ML-BRU-SCF-0098 [IN031837] -- Start*/
							amended_by_id		= CommonBean.checkForNull((String)records.get(59));						  
							amend_reason			= CommonBean.checkForNull((String)records.get(60));
							amend_reason_code	= CommonBean.checkForNull((String)records.get(61));
							amended_date			= CommonBean.checkForNull((String)records.get(62));
							/*Above code Added for ML-BRU-SCF-0098 [IN031837] -- End*/
							strength_value		= CommonBean.checkForNull((String)records.get(63));// Added for IN-30262
							alt_drug_remarks		= CommonBean.checkForNull((String)records.get(64));// Added for IN-30262
							pregnancy_override_reason		= CommonBean.checkForNull((String)records.get(65));// Added for RUT-CRF-0063 [IN:029601]
							allocate_remarks_code 	= CommonBean.checkForNull((String)records.get(66));//code added for ML-BRU-SCF-0971[IN042220]--Start
							allocate_finding 	= CommonBean.checkForNull((String)records.get(67));
							fill_remarks_code 		= CommonBean.checkForNull((String)records.get(68));
							fill_finding 		= CommonBean.checkForNull((String)records.get(69));
							delivery_remarks_code 	= CommonBean.checkForNull((String)records.get(70));
							delivery_finding 	= CommonBean.checkForNull((String)records.get(71));
							pres_base_uom 	= CommonBean.checkForNull((String)records.get(73)); //Added for ML-BRU-SCF-1190 [IN:045647]
							ref_sent_remarks = CommonBean.checkForNull((String)records.get(75));//Added for HSA-CRF-0155 [IN048487] 
							verify_remarks = CommonBean.checkForNull((String)records.get(78));//Added for ML-MMOH-SCF-0327 [IN:058772] 
							order_qty      = CommonBean.checkForNull((String)records.get(82));//Added for ARYU-SCF-0034
							mfr_remarks    = CommonBean.checkForNull((String)records.get(83));//SKR-SCF-1370
							if(!allocate_finding.equals("")){
								allocate_finding=allocate_finding.replaceAll(" ","%20");
								allocate_finding=	java.net.URLEncoder.encode(allocate_finding,"UTF-8");
								allocate_finding=allocate_finding.replaceAll("%2520","%20");
							}
							if(!fill_finding.equals("")){
								fill_finding=fill_finding.replaceAll(" ","%20");
								fill_finding=	java.net.URLEncoder.encode(fill_finding,"UTF-8");
								fill_finding=fill_finding.replaceAll("%2520","%20");
							}				
							if(!delivery_finding.equals("")){
								delivery_finding=delivery_finding.replaceAll(" ","%20");
								delivery_finding=	java.net.URLEncoder.encode(delivery_finding,"UTF-8");
								delivery_finding=delivery_finding.replaceAll("%2520","%20");
							}// code added for ML-BRU-SCF-0971[IN042220]--End	
							if(line_iv_prep_yn.equals("0") || line_iv_prep_yn.equals("9")){
								//content_in_pres_base_uom = bean.getPackSizeFluid(order_id);
							}

							disp_uom		=	pres_uom;
							ret_uom			=	stock_uom+"  - ";
							//admin_uom		=	pres_uom;
							reissue_uom		=	stock_uom+"  - ";
                            sliding_scale_yn        =(String)records.get(46)==null?"N":(String)records.get(46);
							
                            if(((String)records.get(46)).equals("Y")){
								tot_admin_qty = CommonBean.checkForNull((String)records.get(47));//sliding_scale_adm_unit
								admin_uom     = CommonBean.checkForNull((String)records.get(48));//sliding_scale_adm_uom
							}
							alternates		= CommonBean.checkForNull((String)records.get(49));//alternates

							if(alternates.equals("Y")){
								disp_qty		= "";
								dispnsd_disp_unit_value = "";
								disp_uom		=  "";
								disp_stock_uom	=  "";
							}

							if(disp_qty.equals("")) {
								disp_uom		=  "";
								disp_stock_uom	=  "";
							}

							if(line_status.equals("IP") && disp_qty.equals("")) 
								disp_qty	="";

							if((ret_qty.trim()).equals("")){ //trim() added for KAUH-SCF-013 [IN:032157]
								ret_uom	=	"";
							}
							else{		
								st =new StringTokenizer(ret_uom, " ");
								while (st.hasMoreTokens()){
									ret_uom1 = st.nextToken();
									ret_uom2 = st.nextToken();
								}
								ret_uom= bean.getUomDisplay(facility_id,ret_uom1)+"  - ";
							}
							if(line_iv_prep_yn.equals("6"))
								admin_uom= (String)records.get( 54 );
							
							if(tot_admin_qty.equals("")) {
								admin_uom	=	"";
							}
							else{
								if(Float.parseFloat(tot_admin_qty)<1 && Float.parseFloat(tot_admin_qty)>0)
									tot_admin_qty="0"+tot_admin_qty;
							}
							if(!disp_drugs.equals("")) 
								disp_drugs	=	" / "+disp_drugs;

							if((reissue_qty.trim()).equals("")){ //trim() added for KAUH-SCF-013 [IN:032157]
								reissue_uom	=	"";
							}
							else{	//ADDED for 26236-reopen==Else condition	
								st =new StringTokenizer(reissue_uom, " ");
								while (st.hasMoreTokens()){
								reissue_uom1 = st.nextToken();
								reissue_uom2 = st.nextToken();
							}
							reissue_uom= bean.getUomDisplay(facility_id,reissue_uom1)+"  - ";
						}
						if(ret_diff.equals("")) 
							ret_diff	=	"0";
						
						if(line_iv_prep_yn.equals("N") || line_iv_prep_yn.equals("I")){
							if(order_line_no.equals("1"))
								classVal="IVFLUID";
							else
								classVal="IVINGREDIENT";
						}
						else if(discharge_med.equals("D")){
							classVal="DISCHARGEMED1";
						}
%>		
						<tr style='height:50px;'><td style='width:0px;border-right:0;' >&nbsp;</td>
<%
							for(int colCount=0; colCount<records.size(); colCount++){

								/*	 0	--->    IV_PREP_YN
									 1	--->	INFUSE_OVER
									 2	--->	TRN_TYPE_IND (To decide whether it is direct dispensing or via prescription)
									 3	--->	STATUS	(To decide whether the drug is cancelled,hold,discontinued or active)
									 4	--->	Drug Code
									 6	--->	Route Code
									 11	--->	Remarks	*/

								order_id=(String)records.get( 15 );
								order_line_num=(String)records.get( 16 );
								sr_no         =(String)records.get( 17 );

								//if (colCount>18)//changed to 18 for AAKH-CRF-0088 [IN:060357]  
									//continue;
									//added ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510] start
									if(site){
										if (colCount>19)
											continue;
									}
									else{
										if (colCount>17)
											continue;

									}
								//added ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510] end
								if (colCount ==0 || colCount==1){
									strIVPrepYN =(String)records.get( 0 );
									if (colCount==0){						
										continue;
									}
									else{
										if (strIVPrepYN.equals("N")){
											linkYN = "N";
										}
										else if (strIVPrepYN.equals("Y")&&(records.get( 1 ) != null)){
											linkYN = "Y";
										}
									}
								}
								else if (colCount==2 ){
								}
								else if (colCount == 3) {

									drug_status = "";
									disc_cancel = bean.isCancelDiscontinuedApplicable((String)records.get( 15 ),(String)records.get( 16 ));	
									cancel_link_yn       = (String)disc_cancel.get("CANCEL");
									future_yn	=	bean.compareDate((String)records.get(9));
									expiry_yn	=	bean.compareDate((String)records.get(10));

									if(!ret_qty.equals("") ){
										if (line_status.equals("DC"))
											drug_status = "#C40062";
										//else if(expiry_yn.equals("N"))
										//	drug_status = "#FFB66C";
										else
											drug_status = "#FFB66C";
										if((status.equals("A") || status.equals("*A")) && (line_status.equals("DP") || line_status.equals("DF")|| line_status.equals("DD")|| line_status.equals("DE")) && (future_yn.equals("N")) && !expiry_yn.equals("N")){	//DD AND DD added for mms-kh-crf-0014
											classVal	= "ACTIVE";
										}
										else{
											if(future_yn.equals("Y")) 
												classVal	= "FUTURE_Rx";
											else if(expiry_yn.equals("N"))
											{
												if(expired_order) //modified for MOHE-CRF-0032
												{
													//drug_status = "#FFA500";  //code modified for MOHE-CRF-0032
													classVal="EXPIRED_ORDER";
												}
											else
												{
												classVal	= "EXPIRED_MEDICATION";
												}
											}	
											else if (line_status.equals("CN"))
												classVal	= "CANCEL";
											else if (line_status.equals("DC"))
												classVal	= "DIS-CONTINUED";
											else if(discharge_med.equals("D"))
												classVal="DISCHARGEMED1";
											else if (line_status.equals("HD") || line_status.equals("HC"))
												classVal	= "HOLD";
											else
												classVal	= "ACTIVE";
												//classVal	= "ReturnedMedication";	
										}
									}
									else if (line_status.equals("CN")){
										drug_status = "#990000";
										if(expiry_yn.equals("N"))
										{
											if(expired_order)//modified for MOHE-CRF-0032
											{
												drug_status = "#FFA500";  //code modified for MOHE-CRF-0032
												classVal="EXPIRED_ORDER";
											}
										else
											{
											classVal	= "EXPIRED_MEDICATION";
											}
										}
										else
											classVal	= "CANCEL";
									}
									else if (line_status.equals("DC")){
										drug_status = "#C40062";
										if(expiry_yn.equals("N"))
										{
											if(expired_order) //modified for MOHE-CRF-0032
											{
												drug_status = "#FFA500";  //code modified for MOHE-CRF-0032
												classVal="EXPIRED_ORDER";
											}
										else
											{
											classVal	= "EXPIRED_MEDICATION";
											}
										}
										else
											classVal	= "DIS-CONTINUED";
									}
									else if( ((((String)records.get( colCount )).trim()).equals("ACTIVE")) || ((patient_class.equals("IP") || patient_class.equals("DC")) && (line_status.equals("OS") || line_status.equals("RG") || line_status.equals("IP") || line_status.equals("VF")) ) || ((patient_class.equals("OP") || patient_class.equals("EM")) && (line_status.equals("DP") || line_status.equals("DF") ) )){
										if(future_yn.equals("Y")) { 
											drug_status = "#99FFCC";
											classVal	= "FUTURE_Rx";
										}
										else{
											drug_status = "#FF5E5E";
											if(expiry_yn.equals("N")){
												{
													if(expired_order) //modified for MOHE-CRF-0032
													{
														drug_status = "#FFA500";  //code modified for MOHE-CRF-0032
														classVal="EXPIRED_ORDER";
													}
												else
													{
													classVal	= "EXPIRED_MEDICATION";
													}
												}
												drug_status = "#D9B86C";
											}
											else 
												classVal	= "ACTIVE";
										}
									}
									else if(child_order.equals("Y")){
										drug_status = "#B6BC8B";
										if(future_yn.equals("Y")) 
											classVal	= "FUTURE_Rx";
										else
											classVal	= "Refill_Rx";
									}
									else if(future_yn.equals("Y")) { 
										drug_status = "#99FFCC";
										classVal	= "FUTURE_Rx";						
									}
									else if(cancel_link_yn.equals("Y") || (line_status.equals("IP") || line_status.equals("PO") || line_status.equals("PS") || line_status.equals("AL") || line_status.equals("VF")) || (disp_qty.equals("") && !tot_admin_qty.equals("") && complete_reason.equals(""))){
										drug_status = "#8204FF";
										if(expiry_yn.equals("N"))
										{
											if(expired_order) //modified for MOHE-CRF-0032
											{
												drug_status = "#FFA500";  //code modified for MOHE-CRF-0032
												classVal="EXPIRED_ORDER";
											}
										else
											{
											classVal	= "EXPIRED_MEDICATION";
											}
										}
										else
											classVal	= "YET_TO_BE_DISPENSED";
									}
									else if (line_status.equals("HD") || line_status.equals("HC")){
										if(expiry_yn.equals("N"))
										{
											drug_status = "#D9B86C";
											if(expired_order) //modified for MOHE-CRF-0032
											{
												drug_status = "#FFA500";  //modified for MOHE-CRF-0032
												classVal="EXPIRED_ORDER";
											}
										}
										else
											drug_status = "#F0F000";
										classVal	= "HOLD";
									
									} 
									else if(expiry_yn.equals("N")){
										drug_status = "#D9B86C";
										{
											if(expired_order) //modified for MOHE-CRF-0032
											{
												drug_status = "#FFA500";  //code modified for MOHE-CRF-0032
												classVal="EXPIRED_ORDER";
											}
										else
											{
											classVal	= "EXPIRED_MEDICATION";
											}
										}
									}
									else {
										drug_status = "";
										classVal	= classvalue;
									}
									/* if(expiry_yn.equals("N")){
										drug_status = "#D9B86C";
										classVal	= "EXPIRED_MEDICATION";
									}*/
									if(line_status.equals("PO") || line_status.equals("PS")){
										title_buffer.append(" / ");
										title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PndngFrAppr.label","ph_labels"));
									}
									ht_wt_title = title_buffer.toString();
								}
								
								else if (colCount==4 || colCount==6 || colCount==15 || colCount==16 || colCount==17){	
								%>			
									<td class="<%=classvalue%>" style="display:none" title="<%=ht_wt_title%>"><%=(String)records.get( colCount )%>&nbsp;</td>
								
<%								}
						     //Added for ML-MMOH-CRF-0510[IN060510] START
								else if (colCount==18){ //added 18 for AAKH-CRF-0088 [IN:060357] 
									
										if(((String)records.get( 80 )) != null){
%>
									<td class="<%=classvalue%>" ><%=(String)records.get( 80 )%>&nbsp;</td>
<%								}else{
%> 
								<td class="<%=classvalue%>" ><%=(String)records.get( 12 )%>&nbsp;</td> 
 									
<%									}
 									}
                              else if (colCount==19){ //added 18 for AAKH-CRF-0088 [IN:060357] 
									
										if(((String)records.get( 81 )) != null){
										 %>
									<td class="<%=classvalue%>" ><%=(String)records.get( 81 )%>&nbsp;</td>
<% 								}else if(((String)records.get( 80 )) != null && ((String)records.get( 81 )) == null){ 
%> 
									<td class="<%=classvalue%>" ><%=(String)records.get( 12 )%>&nbsp;</td> 
 									
<%								}else{
%>
									<td class="<%=classvalue%>" >&nbsp;</td> 
<%									}
 									}//Added for ML-MMOH-CRF-0510[IN060510] END							}


								else if(colCount==9||colCount==10){

									String date	=	com.ehis.util.DateUtils.convertDate((String)records.get(colCount),"DMYHM","en",locale);
									out.print("<td style='background-color:#FFFFFF'class='"+classvalue+" '>"); 
									out.print(date+"&nbsp;"); 
									out.print("</td>");
								}
								else if (colCount==5){
%>
									<td class="<%=classvalue%>" style='width:0px;border-left:0' title="<%=ht_wt_title%>"><%=line_status_text%>
<%
									if(line_status.equals("IS")){ //if block added for Bru-HIMS-CRF-087 [IN:029953]
%>
										<br><label style='color:blue;cursor:pointer;' onclick="viewOutsourceDtls('<%=order_id%>','<%=order_line_num%>');"><fmt:message key="ePH.DispenseDetail.label" bundle="${ph_labels}"/></label>
<%
									}
%>
									</td>
<%
								}
								else if (colCount==11 ){
%>	
									<td class="<%=classvalue%>"  title="<%=ht_wt_title%>">
<%
									if ( !(((String)records.get(3)).trim()).equals("CANCEL") && !(((String)records.get(3)).trim()).equals("HOLD") && ((String)records.get( 18 )).equals("0") && ((String)records.get( 26 ))==null && ret_date.equals("") && ((String)records.get( 50 ))==null && (((String)records.get(57))==null || ((String)records.get(57)).equals("")) && (ret_qty==null || ret_qty.equals("")) && (mfr_remarks==null || mfr_remarks.equals("")) && (amended_by_id == null || amended_by_id.equals(""))  && (amend_reason==null || amend_reason.equals("")) && (amend_reason_code==null || amend_reason_code.equals("")) && pregnancy_override_reason.equals("")&& allocate_finding.equals("") && fill_finding.equals("")&& delivery_finding.equals("") && ref_sent_remarks.equals("") ) { // added  || (ret_qty==null || ret_qty.equals("") ML-BRU-SCF-0037[030949]  and  amended_by_id, amend_reason added for ML-BRU-SCF-0098 [IN031837]  rtn_qty condition replaced with && code allocate_finding.equals("") && fill_finding.equals("")&& delivery_finding.equals("") added for ML-BRU-SCF-0971[IN042220]
%>
										<font >&nbsp;</font>				
<%	
									}
									else{ArrayList remarks	= bean.getPresRemarks(order_id,order_line_num,ReqDb,enc_id1);//added for skr-scf-1708
									System.out.println("line_iv_prep_yn----->"+line_iv_prep_yn+"---------remarks-------------"+remarks);
										if(!(line_iv_prep_yn.equals("3") || line_iv_prep_yn.equals("4"))){//added for skr-scf-1708
										//Display remarks hyper link for orders with Cancelled/Held/Remarks enterd/LAST_ACTION_REASON_DESC/COMPLETED/PRN_REMARKS 
%>
										<font class="HYPERLINK" style="cursor:pointer" onClick="showRemarks('<%=order_id%>','<%=order_line_num%>','<%=sr_no%>','<%=line_status%>','<%=(String)records.get(56)%>','<%=sliding_scale_yn%>','<%=amended_by_id%>','<%=amended_date%>','<%=amend_reason%>','<%=amend_reason_code%>','<%=allocate_finding%>','<%=fill_finding%>','<%=delivery_finding%>', '<%=allocate_remarks_code%>', '<%=fill_remarks_code%>', '<%=delivery_remarks_code%>','<%=ReqDb%>','<%=enc_id1%>','<%=called_from%>','<%=java.net.URLEncoder.encode(ref_sent_remarks,"UTF-8")%>', '<%=java.net.URLEncoder.encode(verify_remarks,"UTF-8")%>','<%=line_iv_prep_yn%>')"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></font><!-- code '<%=allocate_finding%>','<%=fill_finding%>','<%=delivery_finding%>added for ML-BRU-SCF-0971[IN042220] //Added called_from,enc_id1,ReqDb for MMS-DM-CRF-115.4 and removed decode for amend_reason for ML-MMOH-SCF-1673-->
<%	
									}
										else if(!(line_iv_prep_yn.equals("3") || line_iv_prep_yn.equals("4")) && remarks.size()>0 ) {%>
											<font class="HYPERLINK" style="cursor:pointer" onClick="showRemarks('<%=order_id%>','<%=order_line_num%>','<%=sr_no%>','<%=line_status%>','<%=(String)records.get(56)%>','<%=sliding_scale_yn%>','<%=amended_by_id%>','<%=amended_date%>','<%=amend_reason%>','<%=amend_reason_code%>','<%=allocate_finding%>','<%=fill_finding%>','<%=delivery_finding%>', '<%=allocate_remarks_code%>', '<%=fill_remarks_code%>', '<%=delivery_remarks_code%>','<%=ReqDb%>','<%=enc_id1%>','<%=called_from%>','<%=java.net.URLEncoder.encode(ref_sent_remarks,"UTF-8")%>', '<%=java.net.URLEncoder.encode(verify_remarks,"UTF-8")%>','<%=line_iv_prep_yn%>')"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></font><!-- code '<%=allocate_finding%>','<%=fill_finding%>','<%=delivery_finding%>added for ML-BRU-SCF-0971[IN042220] //Added called_from,enc_id1,ReqDb for MMS-DM-CRF-115.4 and removed decode for amend_reason for ML-MMOH-SCF-1673-->
										<%}}
%>
									</td>	
<% 
									if((discharge_med.equals("D"))){ // if else condition added for ML-MMOH-SCF-0328 [IN058775]
%>	
										<td class="<%=classvalue%>" title="<%=ht_wt_title%>"><%="OP"%></td>	
<%
									}
									else { 
%>
										<td class="<%=classvalue%>" title="<%=ht_wt_title%>"><%=(String)records.get( colCount )%></td>
<% 
									}
								}
								else if(colCount==10){

									dtls = CommonBean.checkForNull((String)records.get( colCount ));
									disc_cancel = bean.isCancelDiscontinuedApplicable((String)records.get( 15 ),(String)records.get( 16 ));	
									
									discontinued_link_yn = (String)disc_cancel.get("DISCONTINUE");
									cancel_link_yn       = (String)disc_cancel.get("CANCEL");

									if(disp_locn_code==null || disp_locn_code.equals("null"))
										disp_locn_code	=	"";

									if(discontinued_link_yn!=null && discontinued_link_yn.equals("Y"))
										disc_cancel_style = "";
									else if(cancel_link_yn!=null && cancel_link_yn.equals("Y"))
										disc_cancel_style = "";
									else
										disc_cancel_style = "";
									
									if(discontinued_link_yn!=null && discontinued_link_yn.equals("Y")){
										//on_click = "discontinueTheDrug('"+(String)records.get( 15 )+"','"+(String)records.get( 16 )+"','"+called_frm+"')";
									}
									else if(cancel_link_yn!=null && cancel_link_yn.equals("Y")){
										//on_click = "cancelTheDrug('"+(String)records.get( 15 )+"','"+(String)records.get( 16 )+"','"+called_frm+"')";
									}
									else{
										on_click = "";
									}
									if(called_frm!=null && called_frm.equals("Dispense")){						
										if( ( ( (bean.isDiscontinuedAllowed(disp_locn_code)).equals("Y") || disp_locn_code.equals(""))  && discontinued_link_yn.equals("Y") && ret_diff.equals("0")) || (  cancel_link_yn.equals("Y")) ) {
%>
											<td class="<%=classvalue%>" title="<%=ht_wt_title%>" style="<%=disc_cancel_style%>" onMouseOver="hideDiscCancelLink(this)" id="disc_cancel_id" onMouseOut="hideDiscCancelLink(this)" onClick="<%=on_click%>" nowrap><%=dtls%></td>
<%
										}
										else{
%>
											<td class="<%=classvalue%>" title="<%=ht_wt_title%>" id="disc_cancel_id" nowrap><%=dtls%></td>
<%
										}
									}
									else if(called_frm!=null && !called_frm.equals("QUERY")){						
										if( (discontinued_link_yn.equals("Y") && ret_diff.equals("0")) || ( cancel_link_yn.equals("Y")) ) {
%>
											<td class="<%=classvalue%>" title="<%=ht_wt_title%>" style="<%=disc_cancel_style%>" onMouseOver="hideDiscCancelLink(this)" id="disc_cancel_id" onMouseOut="hideDiscCancelLink(this)" onClick="<%=on_click%>"><%=dtls%></td>
<%					
										} 
										else {	
%>
											<td class="<%=classvalue%>" title="<%=ht_wt_title%>" id="disc_cancel_id"><%=dtls%></td>
<%
										}
									}
									else{
%>
										<td class="<%=classvalue%>" title="<%=ht_wt_title%>" id="disc_cancel_id"><%=dtls%> 
										</td>
<%
									}
								}
								else{
									// Added for ml-mmoh-crf-0510 start
									//dtls = CommonBean.checkForNull((String)records.get( colCount ));
									if(site){
									if(colCount == 12){
										dtls = "";
									}
									else{
										dtls = CommonBean.checkForNull((String)records.get( colCount ));
									}
									}
									else{
										
										dtls = CommonBean.checkForNull((String)records.get( colCount ));
									
									}
									// Added for ml-mmoh-crf-0510 end
//code added for 24361 on 29Nov2010
									if((line_iv_prep_yn.equals("1") || line_iv_prep_yn.equals("2") || line_iv_prep_yn.equals("3") || line_iv_prep_yn.equals("4")||line_iv_prep_yn.equals("9")||line_iv_prep_yn.equals("0"))&& (colCount==7)){
										if(!order_line_no.equals("1")){
										    dtls ="&nbsp;";
										}
								    }//ends here
									if(line_iv_prep_yn.equals("N") || line_iv_prep_yn.equals("I")){
										if(!order_line_no.equals("1")){
											if(colCount==9 || colCount==12 || colCount==13 || colCount==14 )
												dtls = "&nbsp;";
										}
									}
									if(colCount==12) { 
										/* if(!pres_base_uom.equals(pres_uom)){ //Added for ML-BRU-SCF-1190 [IN:045647] 
											convFactor = bean.getConvFactor(pres_uom,pres_base_uom );
											pres_qty = Float.parseFloat(pres_qty)/Float.parseFloat(convFactor)+"";
										} *///comment for BH-4760(wrong pres qty in pateint drug profile)
										if(pres_qty!=null && !pres_qty.equals(""))
											pres_qty = dfToInteger.format(Double.parseDouble(pres_qty));
										if(!dosage_type.equals("A")){
											if(!freq_nature.equals("P")){
												//pres_disp_unit_value		=  (new Double(Math.ceil(Float.parseFloat(pres_qty)/Float.parseFloat(content_in_pres_base_uom))).intValue())+"";//Commented for ARYU-SCF-0034
												pres_disp_unit_value=order_qty;//Added for ARYU-SCF-0033
											}
											else{
												pres_disp_unit_value=pres_qty;
												pres_uom=stock_uom;
											}
										}
										else{
											if(!line_iv_prep_yn.equals("5") && !line_iv_prep_yn.equals("") && !line_iv_prep_yn.equals("9") && !line_iv_prep_yn.equals("0")){ //added 9 and 0 condition for IN26750 --14/03/2011-- priya
												pres_disp_unit_value=pres_qty;
												//pres_uom=stock_uom;
											}
											else{
												   //pres_disp_unit_value		=  (new Double(Math.ceil(Float.parseFloat(pres_qty)/Float.parseFloat(content_in_pres_base_uom))).intValue())+"";
												if(!dosage_type.equals("A")){
													pres_disp_unit_value		=  (new Double(Math.ceil(Float.parseFloat(pres_qty)/Float.parseFloat(content_in_pres_base_uom))).intValue())+"";
												}
												else{
													//Added IF-Else Condition For getting Prescribed Pres &Dispensing Quantities of PRNAbsolute &Absolute orders regarding incident num:25141,25131 on 25/Nov/2010==By Sandhya
												   /*  if(freq_nature.equals("P")){
														   pres_disp_unit_value		=  pres_qty+"";
													 }
													 else{*/
													pres_disp_unit_value		=  (new Double(Math.ceil(Float.parseFloat(pres_qty)/Float.parseFloat(content_in_pres_base_uom))).intValue())+"";
													// }										
												}
												if(dosage_type.equals("A") || freq_nature.equals("P")){ //added for ARYU-SCF-104
													pres_disp_unit_value = order_qty;
												}
											}
										}
										if(disp_qty != null && disp_qty != ""){
											if(!pres_uom.equals(stock_uom)){
												if(line_iv_prep_yn.equals("2")||line_iv_prep_yn.equals("4")||line_iv_prep_yn.equals("6")||line_iv_prep_yn.equals("0")){
													dispnsd_disp_unit_value	=  Double.parseDouble(disp_qty)/Float.parseFloat(content_in_pres_base_uom)+"";
												}
												else{										
													if(!dosage_type.equals("A")){
													   dispnsd_disp_unit_value		=  (new Double(Math.ceil(Float.parseFloat(disp_qty)/Float.parseFloat(content_in_pres_base_uom))).intValue())+"";
													}
													else{
														//Added IF-Else Condition For getting Dispensed Pres & Dispense Quantities  of PRNAbsolute & Absolute Orders regarding incident num:25141 on 25/Nov/2010==By Sandhya
														if(freq_nature.equals("P")){
														   //dispnsd_disp_unit_value		=disp_qty+"";
														   dispnsd_disp_unit_value		=disp_qty+"";
														   disp_qty		=  (new 		Double(Math.ceil(Float.parseFloat(disp_qty)*Float.parseFloat(content_in_pres_base_uom))).intValue())+"";
														}
														else{ 
															dispnsd_disp_unit_value     =disp_qty+"";
															disp_qty		=  (new 		Double(Math.ceil(Float.parseFloat(disp_qty)*Float.parseFloat(content_in_pres_base_uom))).intValue())+"";
														}
													}
												}
											}
											else{
												dispnsd_disp_unit_value		= disp_qty;
											}
											disp_stock_uom				=  stock_uom;
										}

										if(!pres_qty.equals("")){
											/*if(dosage_type.equals("A")){//Added if for ML-BRU-SCF-1307
												pres_base_uom = stock_uom;
											}*/ //Commented for SKR-SCF-1036.1 [IN:052023]
											//if(!dosage_type.equals("A") && freq_nature.equals("P")){//Added if for BSP-SCF-0017[62586]  --start//!dosage_type.equals("A")added for Aryu-scf-0101
										//	pres_base_uom = stock_uom;
										//	}//end
											if(freq_nature.equals("P") || dosage_type.equals("A")){ //added for ARYU-SCF-0104
												 pres_qty = (new  		Double(Math.ceil(Float.parseFloat(pres_qty)*Float.parseFloat(content_in_pres_base_uom))).intValue())+"";
											}

%>											
											<td class="<%=classvalue%>" width="53%"  align="left" ><%=pres_qty%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,pres_base_uom))%></td>
											<!-- //style="border-bottom-color:white"><%=pres_qty%>&nbsp;<%=pres_uom%></td>pres_uom -->
											<td class="<%=classvalue%>"  align="left" > <%=pres_disp_unit_value%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,stock_uom))%></td><!-- </td> -->
<%
										}
										else{
%>
											<td class="<%=classvalue%>" align="right" >&nbsp;</td>
											<td class="<%=classvalue%>" align="left" >&nbsp;</td>
<%
										}
										if(alternates.equals("N")){
											if(!disp_qty.equals("")){									
												if(disp_qty != null && !disp_qty.equals("")){
													disp_qty = dfToInteger.format(Double.parseDouble(disp_qty));
												}
												/*if(dosage_type.equals("A")){//Added if for ML-BRU-SCF-1307
													disp_uom = disp_stock_uom;
												}*/////Commented for SKR-SCF-1036.1 [IN:052023]
												if(!dosage_type.equals("A") && freq_nature.equals("P")){//Added if for BSP-SCF-0017[62586]  --start//!dosage_type.equals("A")added for Aryu-scf-0101
													disp_uom = stock_uom;
												}//end
												//if else condtion added for IN007846
												if(disp_qty.equals("0")){
													%>
												<td class="<%=classvalue%>" width="52%" >&nbsp;</td><!-- </td> -->
												
<%			}
												else{
													 %>
													<td class="<%=classvalue%>" width="52%" ><%=disp_qty%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,disp_uom))%></td><!-- </td> -->
						<%						}
												if(dispnsd_disp_unit_value != null && !dispnsd_disp_unit_value.equals("")){
													dispnsd_disp_unit_value = dfToInteger.format(Double.parseDouble(dispnsd_disp_unit_value));
												}
												//if else condtion added for IN007846
												if(dispnsd_disp_unit_value.equals("0")){
													%>
													<td class="<%=classvalue%>" width="52%" >&nbsp;</td><!-- </td> -->
													<%													
												}else{
%>
												<td class="<%=classvalue%>" nowrap  ><%=dispnsd_disp_unit_value%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,disp_stock_uom))%></td>
												
<%}
											}
											else{
%>
												<td class="<%=classvalue%>" align="right" >&nbsp;</td>
												<td class="<%=classvalue%>"  align="left" >&nbsp;</td>
<%
											}
										}
										else if(alternates.equals("Y") && ReqDb.equals("")){ //Added  && ReqDb.equals("") for MMS-DM-CRF-115.4s
%>
											<td class="<%=classvalue%>" nowrap align="left" >&nbsp;<font class="HYPERLINK" style="cursor:pointer" onClick="showDetails('<%=order_id%>','<%=order_line_no%>','<%=line_status_text%>','<%=allocate_finding%>','<%=fill_finding%>', '<%=allocate_remarks_code%>', '<%=fill_remarks_code%>', '', '<%=java.net.URLEncoder.encode(verify_remarks,"UTF-8")%>','','')"><!--code ','<%=allocate_finding%>','<%=fill_finding%>', '<%=allocate_remarks_code%>', '<%=fill_remarks_code%>'' added for IN046252  modified parameters fror mms-icn-0115-->
											<img  src='../../ePH/images/altenate.jpg' height='15' width='15' align='top' title='<fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/> <fmt:message key="Common.Dispensed.label" bundle="${common_labels}"/>' align="center"></img>
											</font>
<%
											if(alt_drug_remarks!=null && !alt_drug_remarks.equals("")){
												stkey = order_id+"~"+order_line_num;
												if(!alt_drug_remarks.equals(""))
													bean.setAltDrugRemarks(stkey, alt_drug_remarks);
%>
												<font class="HYPERLINK" style="cursor:pointer" onClick="showAltDrugRemarks('<%=stkey%>','<%=alt_drug_remarks_ind%>')"><fmt:message key="ePH.Remarks.label" bundle="${ph_labels}"/>
												</font>
<%
											}
%>
											</td>
											<td class="<%=classvalue%>" nowrap align="left">&nbsp;<font class="HYPERLINK" style="cursor:pointer" onClick="showDetails('<%=order_id%>','<%=order_line_no%>','<%=line_status_text%>','<%=allocate_finding%>','<%=fill_finding%>', '<%=allocate_remarks_code%>', '<%=fill_remarks_code%>', '', '<%=java.net.URLEncoder.encode(verify_remarks,"UTF-8")%>','','')"><!--code ','<%=allocate_finding%>','<%=fill_finding%>', '<%=allocate_remarks_code%>', '<%=fill_remarks_code%>'' added for IN046252 modified parameters fror mms-icn-0115-->
											<img  src='../../ePH/images/altenate.jpg' height='15' width='15' align='top'  title='<fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/> <fmt:message key="Common.Dispensed.label" bundle="${common_labels}"/>' align="center"></img>
											</font>
<%
										if(alt_drug_remarks!=null && !alt_drug_remarks.equals("")){
											stkey = order_id+"~"+order_line_num;
											stkey = order_id+"~"+order_line_num;
											if(!alt_drug_remarks.equals(""))
												bean.setAltDrugRemarks(stkey, alt_drug_remarks);
%>
											<font class="HYPERLINK" style="cursor:pointer" onClick="showAltDrugRemarks('<%=stkey%>','<%=alt_drug_remarks_ind%>')"><fmt:message key="ePH.Remarks.label" bundle="${ph_labels}"/>
											</font>
<%
										}
%>
										</td>
<%
									}else if (alternates.equals("Y") && !ReqDb.equals("")){//Added if else condition for MMS-DM-CRF-115.4
	%>
	                                   <td> <img  src='../../ePH/images/altenate.jpg' height='15' width='15' align='top' title='<fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/> <fmt:message key="Common.Dispensed.label" bundle="${common_labels}"/>' align="center"></img>
									   </td>
									   <td> <img  src='../../ePH/images/altenate.jpg' height='15' width='15' align='top' title='<fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/> <fmt:message key="Common.Dispensed.label" bundle="${common_labels}"/>' align="center"></img>
									   </td>
<%
									}
									if(tot_admin_qty!=null && !tot_admin_qty.equals("") && !tot_admin_qty.equals("0") && freq_nature.equals("P")){ /* Added !tot_admin_qty.equals("0") for SKR-SCF-0550[Inc:33338] curly bracket added for MMS-KH-SCF-0037 */ 
										tot_admin_qty =Float.toString( Float.parseFloat(tot_admin_qty)*Float.parseFloat(content_in_pres_base_uom));
										len= tot_admin_qty.length();
										//Below condition is added by sureshkumar T for the Incident no : SRR20056-SCF-7039 [inc : 26763]
										if( len > 0 ){
											temp = tot_admin_qty;
											point= temp.indexOf(".")+1;
											if(point!=0 && temp.charAt(point)=='0')
												tot_admin_qty = tot_admin_qty.substring(0,point-1);
										}// {} added for MMS-KH-SCF-0037
									}
									//tot_admin_qty=total_admin_qty_format.format(Float.parseFloat(tot_admin_qty));
%>
					
									<!--<td class="<%=classvalue%>" title="<%=ht_wt_title%>" nowrap ><%=ret_qty%>&nbsp;<%=ret_uom%> &nbsp;<%=com.ehis.util.DateUtils.convertDate(ret_date,"DMYHM","en",locale)%>&nbsp;</td>--><!--Commented for ML-BRU-SCF-1394[IN0501010] -->
<%
								if(alternates.equals("N") || ret_date.equals("")){//Added for ML-BRU-SCF-1394[IN0501010]-Start
									if(!ret_qty.equals("")) //if added for SKR-SCF-1218
									ret_uom = bean.getReturnMedicationUom(order_id,order_line_no); // Added for ICN-69026 - Start

									if(ret_qty.equals("")){ //if condition added for SKR-SCF-1218
										ret_uom = "";
									}
								
								if(!ret_uom.equals(""))
									ret_uom = bean.getUomDisplay(facility_id,ret_uom); // Added for ICN-69026 - End
%>
									<td class="<%=classvalue%>" title="<%=ht_wt_title%>" nowrap ><%=ret_qty%>&nbsp;<%=ret_uom%> &nbsp;<%=com.ehis.util.DateUtils.convertDate(ret_date,"DMYHM","en",locale)%>&nbsp;</td>
<% 
								}
							    else if(alternates.equals("Y") && !ret_date.equals("")){
%>
									<td class="<%=classvalue%>" nowrap align="left" >&nbsp;<font class="HYPERLINK" style="cursor:pointer" onClick="showDetails('<%=order_id%>','<%=order_line_no%>','<%=line_status_text%>','<%=allocate_finding%>','<%=fill_finding%>', '<%=allocate_remarks_code%>', '<%=fill_remarks_code%>','return', '<%=java.net.URLEncoder.encode(verify_remarks,"UTF-8")%>','<%=ReqDb%>','<%=enc_id1%>')"><img  src='../../ePH/images/altenate.jpg' height='15' width='15' align='top' title='<fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/> <fmt:message key="Common.Dispensed.label" bundle="${common_labels}"/>' align="center"></img><!--modified parameters fror mms-icn-0115 -->
									</font>
<%
									if(alt_drug_remarks!=null && !alt_drug_remarks.equals("")){
										stkey = order_id+"~"+order_line_num;
										stkey = order_id+"~"+order_line_num;
										if(!alt_drug_remarks.equals(""))
											bean.setAltDrugRemarks(stkey, alt_drug_remarks);
%>
										<font class="HYPERLINK" style="cursor:pointer" onClick="showAltDrugRemarks('<%=stkey%>','<%=alt_drug_remarks_ind%>')"><fmt:message key="ePH.Remarks.label" bundle="${ph_labels}"/>
										</font>
<%
									}
%>
									</td>
<%
								}//Added for ML-BRU-SCF-1394[IN0501010]-End
%>
									<td class="<%=classvalue%>" nowrap title="<%=ht_wt_title%>">&nbsp;
								<!---Added Newly in if condition  && (dosage_type.equals("A") || dosage_type.equals("Q"))   for the SKR-SCF-0489 on 18/05/2012 --->
<%
										if(!tot_admin_qty.equals("")  && !tot_admin_qty.equals("0") && (dosage_type.equals("A") || dosage_type.equals("Q"))){  //Added !tot_admin_qty.equals("0") for SKR-SCF-0550[Inc:33338]
											len= tot_admin_qty.length();
											if( len > 0 && Float.parseFloat(tot_admin_qty)>1 ){ //&& Float.parseFloat(tot_admin_qty)>1 added for MMS-KH-SCF-0037
												temp = tot_admin_qty;
												point= temp.indexOf(".")+1;
												if(point!=0 && temp.charAt(point)=='0')
													tot_admin_qty = tot_admin_qty.substring(0,point-1);
											}						
%> 													<!-- pres_qty and uom added for MMS-KH-CRF-0014-->						
											<%=tot_admin_qty%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,admin_uom))%> /<%=pres_qty%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,pres_base_uom))%>
<%
										}
										//Added Newly if condition  for the SKR-SCF-0489 on 18/05/2012 
										else if(!tot_admin_qty.equals("")  && !tot_admin_qty.equals("0") && dosage_type.equals("S")){  //Added !tot_admin_qty.equals("0") for SKR-SCF-0550[Inc:33338]
										        //Added if condition for 73378 start
											if(!(line_iv_prep_yn.equals("0") || line_iv_prep_yn.equals("2") || line_iv_prep_yn.equals("4") || line_iv_prep_yn.equals("6")||line_iv_prep_yn.equals("8") || line_iv_prep_yn.equals("5"))){
												if(line_iv_prep_yn.equals("") || line_iv_prep_yn.equals("1") || (line_iv_prep_yn.equals("3") && !order_line_no.equals("1")) || (line_iv_prep_yn.equals("9") && !order_line_no.equals("1"))){
												tot_admin_qty = Float.toString( Float.parseFloat(tot_admin_qty) * Float.parseFloat(strength_value) );	// Added for IN-30262 & 31883 
												}
											}
											 //Added if condition for 73378 end
											len= tot_admin_qty.length();
											if( len > 0 && Float.parseFloat(tot_admin_qty)>1 ){//Float.parseFloat(tot_admin_qty) added for MMS-SCF-037
												temp = tot_admin_qty;
												point= temp.indexOf(".")+1;
												if(point!=0 && temp.charAt(point)=='0')
													tot_admin_qty = tot_admin_qty.substring(0,point-1);
											}						
											if(alternates.equals("Y")) // MMS-KH-SCF-0052
												admin_uom = pres_base_uom;

%> 													<!-- pres_qty and uom added for MMS-KH-CRF-0014-->								
											<%=tot_admin_qty%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,admin_uom))%> / <%=pres_qty%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,pres_base_uom))%>
<%
										}
										if(Integer.parseInt(admin_dose_chng_reason_cnt) > 0){
%>
											<img src="../images/changeddosageindicator.gif" title='<fmt:message key="ePH.ChangeDoseDetailExist.label" bundle="${ph_labels}"/>' align="center" id="chng_dose_ind"></img>
<%
										}
%>
<!--=================Date convesion done for ret_med and Reissuemedication time regnd incident num:26236==By Sandhya==01/FEB/2011================-->
										</td>
										<!-- <td class="<%=classvalue%>" title="<%=ht_wt_title%>" nowrap ><%=reissue_qty%>&nbsp;<%=reissue_uom%>&nbsp;<%=reissue_date_time%>&nbsp;</td> -->										
										<!--<td class="<%=classvalue%>" title="<%=ht_wt_title%>"nowrap><%=reissue_qty%>&nbsp;
										<%=reissue_uom%>
										&nbsp;<%=com.ehis.util.DateUtils.convertDate(reissue_date_time,"DMYHM","en",locale)%>&nbsp;</td>--><!--Commented for ML-BRU-SCF-1394[IN0501010]-->
<%										
										if(alternates.equals("N") || reissue_date_time.equals("")){//Added for ML-BRU-SCF-1394[IN0501010]-Start
%>
											<td class="<%=classvalue%>" title="<%=ht_wt_title%>"nowrap><%=reissue_qty%>&nbsp;<%=reissue_uom%>						&nbsp;<%=com.ehis.util.DateUtils.convertDate(reissue_date_time,"DMYHM","en",locale)%>&nbsp;</td>
<%	
										}
										else if(alternates.equals("Y") && !reissue_date_time.equals("")){
%>
											<td class="<%=classvalue%>" nowrap align="left" >&nbsp;<font class="HYPERLINK" style="cursor:pointer" onClick="showDetails('<%=order_id%>','<%=order_line_no%>','<%=line_status_text%>','<%=allocate_finding%>','<%=fill_finding%>', '<%=allocate_remarks_code%>', '<%=fill_remarks_code%>','reissue', '<%=java.net.URLEncoder.encode(verify_remarks,"UTF-8")%>','<%=ReqDb%>','<%=enc_id1%>')"><img  src='../../ePH/images/altenate.jpg' height='15' width='15' align='top' title='<fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/> <fmt:message key="Common.Dispensed.label" bundle="${common_labels}"/>' align="center"></img><!---modified parameters fror mms-icn-0115-->
											</font>
<%
											if(alt_drug_remarks!=null && !alt_drug_remarks.equals("")){
												stkey = order_id+"~"+order_line_num;
												stkey = order_id+"~"+order_line_num;
												if(!alt_drug_remarks.equals(""))
													bean.setAltDrugRemarks(stkey, alt_drug_remarks);
%>
												<font class="HYPERLINK" style="cursor:pointer" onClick="showAltDrugRemarks('<%=stkey%>','<%=alt_drug_remarks_ind%>')"><fmt:message key="ePH.Remarks.label" bundle="${ph_labels}"/></font>
<%
											}
%>
											</td>
<%
									   }//Added for ML-BRU-SCF-1394[IN0501010]-End
									}
									if(colCount==7){ //Code Added CRF - 0034  Start
%>
										<td class="<%=classvalue%>" style='color:<%=fntColor%>;background-color:<%=backgrndColor%>' title="<%=ht_wt_title%>"><%=dtls%></td>
<% 
									}
									else if(colCount==8  && records.get(55) != null && ((String)records.get(55)).equals("Y")){ //Code Added CRF - 0034 End

%>										<td class="<%=classvalue%>" title="<%=ht_wt_title%>" nowrap>
											<a HREF="#" onMouseOver="changeCursor(this);" onClick="showMultipleFlowRate('<%=patient_id %>','<%=order_id%>');" id='mfrLink'><fmt:message key="ePH.MultipleFlowRate.label" bundle="${common_labels}"/></a></td>
<%								
									}
									else{ // Else block Added for 10.X-CRF-SRR20056-CRF-0675-PH-SL-2 -- start
										if(site){
											if( colCount!=12){
%>
										<td class="<%=classvalue%>" nowrap>
<%
											}
										}else{%>
											<td class="<%=classvalue%>" nowrap>
									<%	}
										if(colCount==8){
											if(sliding_scale_yn!=null && sliding_scale_yn.equals("Y") && ReqDb.equals("") ){// && ReqDb.equals("") added for MMS-DM-CRF-115.4
%>
												<div name="divSlidingdetail<%=recCount%>" id="divSlidingdetail<%=recCount%>" style="position:absolute; width:100%;display:none;border:1px solid black;">
												<table id="tblSlidingdetail" border="1"  width="100%" height="100%" align="center" cellpadding="1" cellspacing="0" >
<%
												ArrayList sliding_scale_details =   bean.getSlidingScaleTemplateDetails(order_id,order_line_num,ReqDb,enc_id1);
												String sRemarks="&nbsp;";
												boolean blTempFound = false;

												if(sliding_scale_details.size()>1){
													blTempFound = true;
%>
														<tr>
															<th style="font-size:13; border-bottom:1px solid white;" colspan=6 > <%=(String)sliding_scale_details.get(9)%></th>		
														</tr>
														<tr>
															<th align="left" style="font-size:9" nowrap><fmt:message key="ePH.FROMRANGE.label" bundle="${ph_labels}"/></th>
															<th align="left" style="font-size:9" nowrap><fmt:message key="ePH.TORANGE.label" bundle="${ph_labels}"/></th>
															<th align="left" style="font-size:9" nowrap><fmt:message key="ePH.RangeUOM.label" bundle="${ph_labels}"/></th>
															<th align="left" style="font-size:9" nowrap><fmt:message key="ePH.AdminUnits.label" bundle="${ph_labels}"/></th>
															<th align="left" style="font-size:9" nowrap><fmt:message key="ePH.AdminUnitsUOM.label" bundle="${ph_labels}"/></th>
															<th align="left" style="font-size:9" nowrap width='150px' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
														</tr>
<%
														String toRan="";
														String admUnit="";
														for(int sl=1;sl<sliding_scale_details.size();sl+=9){
															toRan=((String)sliding_scale_details.get(sl+3)).equals("0")?(">"+(String)sliding_scale_details.get(sl+2)):(String)sliding_scale_details.get(sl+3);
															admUnit=(String)sliding_scale_details.get(sl+4);
															if(admUnit!=null && !admUnit.equals("")){
																float admUnitValue=Float.parseFloat(admUnit);
																if(admUnitValue>0.0 && admUnitValue<1.0)
																	admUnit=Float.parseFloat(admUnit)+"";
															}
															if(((String)sliding_scale_details.get(sl+7)).equalsIgnoreCase("null") || ((String)sliding_scale_details.get(sl+7)).equals(" ") || sliding_scale_details.get(sl+7) ==null)
																sRemarks = "&nbsp;&nbsp;";
															else
																sRemarks = java.net.URLDecoder.decode((String)sliding_scale_details.get(sl+7),"UTF-8");
%>
															<tr>
																<td nowrap><%=(String)sliding_scale_details.get(sl+2)%></td>
																<td nowrap><%=toRan%></td>	
																<td nowrap><%=(String)sliding_scale_details.get(sl+5)%></td>	
																<td nowrap><%=admUnit%></td>	
																<td nowrap><%=(String)sliding_scale_details.get(sl+6)%></td>
																<td width='150px'><%=sRemarks%></td>	
															</tr>
<%
														}
													}
													else{
														blTempFound = false;
%>
														<tr>
															<th style="font-size:13; border-bottom:1px solid white;" colspan=6 >No Templates Found</th>	
														</tr>
<%
													}
%>
														</table>
													</div>
													<label id='lblslidingscale' style="color:red;cursor:pointer" onmouseover='dispSlidingDtl("<%=recCount%>");' onmouseout='hideSlidingDtl("<%=recCount%>");' onClick="showSlidingDetails('<%=order_id%>','<%=order_line_no%>','<%=sliding_scale_yn%>','<%=blTempFound%>','<%=recCount%>')"><fmt:message key="Common.SlidingScale.label" bundle="${common_labels}"/></label> 
<%
												}
                                               else if (sliding_scale_yn!=null && sliding_scale_yn.equals("Y") && !ReqDb.equals("")){//Added if else condition for MMS-DM-CRF-115.4
%>
                                                 <label style="color:red;cursor:pointer"> <fmt:message key="Common.SlidingScale.label" bundle="${common_labels}"/></label>
<%
												}
										}
if(dtls!=""){
%>
										<label id='lblDosagedtl' title="<%=ht_wt_title%>"> <%=dtls%>&nbsp;</label>
<%
}
									} //Added/Modified for 10.X-CRF-SRR20056-CRF-0675-PH-SL-2 -- End
									if(colCount==13){
										
%>
										  /<%=order_id%>
<% 
										//if(!disp_qty.equals("") || alternates.equals("Y") || line_status.equals("IP") || line_status.equals("AL") || line_status.equals("DP")|| line_status.equals("DC")){ //if condition added for ML-BRU-SCF-0430 IN[035169]  //line_status added for ML-BRU-SCF-1116 [IN:044786]
							   			dispense_count 		= CommonBean.checkForNull((String)records.get(69));//Added for MMS-SCF-0196
										if(!disp_qty.equals("") || alternates.equals("Y") || line_status.equals("IP") || line_status.equals("AL") || line_status.equals("DP")|| line_status.equals("DF") || (!dispense_count.equals("") && !dispense_count.equals("0"))){ //if condition added for ML-BRU-SCF-0430 IN[035169]  //line_status added for ML-BRU-SCF-1116 [IN:044786]
										if(!called_from.equals("CDR")){//Added if condition for MMS-DM-CRF-115.4
%> 
											<br><font class="HYPERLINK" style="cursor:pointer" onClick="showDetails('<%=order_id%>','<%=order_line_no%>','<%=line_status_text%>','<%=allocate_finding%>','<%=fill_finding%>', '<%=allocate_remarks_code%>', '<%=fill_remarks_code%>', '','<%=java.net.URLEncoder.encode(verify_remarks,"UTF-8")%>','<%=ReqDb%>','<%=enc_id1%>')"><!--modified parameters fror mms-icn-0115-->
											<fmt:message key="ePH.DispensedLocns.label" bundle="${ph_labels}"/> 
											</font>
<%
										 }
										}
									}
%>
									</td>
<%
								}
							}
%>
							</tr>
<%
						}
						int index1=-1;
						if (result.size()<index1){
%>
							<script>
								alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
							</script>
<%
							return;
						}
%>
					</table> 
				</div>
<%
				out.flush();
%>
				<script language="javascript">
					parent.parent.f_query_status.location.href="../../ePH/jsp/QueryPatientDrugProfileStatus.jsp";
				</script>
<%
				if(called_frm.equals("Dispense") || called_from.equals("CDR")){	//if block Added for Bru-HIMS-CRF-081 [IN:029947]//called_from.equals("CDR") added for MMS-DM-CRF-115.4
%>
					<script language="javascript">
						adjustTableHeight();
					</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%
				}
			}
			else{
%>
				<script>
					parent.parent.f_query_status.location.href="../../eCommon/html/blank.html";
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				</script>
<%
			}
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/QueryPatientDrugProfileResult.jsp", searched) );
		} 
		catch(Exception e) {
			out.print("Exception @ Result JSP :"+e.toString());
			e.printStackTrace();
		}//Added  for ml-mmoh-crf-0510 start
		finally{
			

			if(con != null)
				ConnectionManager.returnConnection(con,request);
		
		}
		//Added  for ml-mmoh-crf-0510 end
%>
	</body>
<% 
	putObjectInBean(bean_id,bean,request); 
	putObjectInBean(bean_id_2,bean_2,request);
%>
</html>

