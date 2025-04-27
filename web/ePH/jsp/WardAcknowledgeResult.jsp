<!DOCTYPE html>
<%@page import="java.sql.Connection,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"%>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
11/10/2017	  	IN064272	        prathyusha 											GHL-CRF-0466 [IN064272] 
25/03/2019	  	IN067953	        Devindra  											MMS-KH-CRF-0014 [IN:067953] 
28/01/2021	  	12662	        	Manickavasagam J  										MMS-KH-CRF-0039
24/02/2021      TFS-13907     	   Prabha 		12/02/2021     Manickam           	   PH-eCommon label issue in various transactions		
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"
	import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper"%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<title></title>
<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
	try{
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	    Connection con = null; // Added for MMS-KH-CRF-0014 [IN:067953] - Start
	    boolean barcode_flag = false;
		try{ 
		   con				= ConnectionManager.getConnection(request);
		   barcode_flag = CommonBean.isSiteSpecific(con, "PH", "WARD_ACK_BARCODE_APPL");		   
	    }
	    catch(Exception e){
		   e.printStackTrace(); 
	    }
	    finally
	    {
	    	if(con != null){
	 		   ConnectionManager.returnConnection(con,request);
	 		}
	    } // MMS-KH-CRF-0014 [IN:067953] - End
%>
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css'></link>

<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script language="Javascript" src="../../ePH/js/WardAcknowledge.js"></script>
<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/dchk.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="setfldFocus('<%=barcode_flag%>')")>
	<%
			String mode	= CommonRepository.getCommonKeyValue("MODE_MODIFY"); 
			java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
			String bean_id		= "WardAcknowledgeBean";
			String bean_name	= "ePH.WardAcknowledgeBean";
			String facility_id					= (String) session.getValue("facility_id");
                        String check_disable = ""; // Added for GHL-CRF-0399.2
			WardAcknowledgeBean bean = (WardAcknowledgeBean)getBeanObject( bean_id,bean_name,request) ;
			 HashMap		bill_data   = new HashMap();
			bill_data=bean.getCommonStoreMap();
			System.out.println(bean.getCommonStoreMap());
			String clearForm = request.getParameter("ClearForm")==null?"N":(String)request.getParameter("ClearForm");
			if(clearForm.equals("N")){
				bean.clear() ;
			}
			//bean.clear() ;
			bean.setLanguageId(locale);
			bean.setMode(mode);
			//Search Criteria's from Query Criteria page
			String	wardDateTo 			= 	CommonBean.checkForNull(request.getParameter("wardDateTo"));
			String 	wardDateFrom 		= 	CommonBean.checkForNull(request.getParameter("wardDateFrom"));
			String	patientId			=	CommonBean.checkForNull(request.getParameter("patientId"));
			String	dispNo 				= 	CommonBean.checkForNull(request.getParameter("dispno"));
			String	dispLocn 			= 	CommonBean.checkForNull(request.getParameter("dispLocn"));
			String	orderId 			= 	CommonBean.checkForNull(request.getParameter("orderid"));
			String	nursingUnitCode		=	CommonBean.checkForNull(request.getParameter("nursingUnitCode"));
			String	bedNoCode			=	CommonBean.checkForNull(request.getParameter("bedNoCode"));
			String	status				=	CommonBean.checkForNull(request.getParameter("status"));
			String	onch				=	CommonBean.checkForNull(request.getParameter("onch"));//Added for GHL-CRF-0399  [IN062299]
			String order_type			= CommonBean.checkForNull(request.getParameter("order_type"));//MMS-KH-CRF-0039
			String worksheet_id			= CommonBean.checkForNull(request.getParameter("worksheet_id")); //MMS-KH-CRF-0039
			String sql =null;
			
			String status_sql="";
			int rowCount=0;
			int actualRowCount = 0; // Added for MMS-KH-CRF-0014 [IN:067953]
			int checkCount=0;
			//String sql = "SELECT d.drug_desc, c.bed_no, b.added_date,C.LOCN_CODE, DECODE (j.use_after_expiry_yn, 'Y', 'Y', 'N', DECODE (GREATEST (SYSDATE, expiry_date), SYSDATE, 'N', 'Y' ) ) valid, c.doc_type, c.doc_no, a.store_code, a.item_code, a.bin_location_code, a.batch_id, TO_CHAR (a.expiry_date, 'DD/MM/YYYY') expiry_date, a.trade_id trade_id, a.disp_no, a.srl_no, b.doc_srl_no, a.srl_no_batch, TO_CHAR (b.added_date, 'dd/mm/yyyy') added_date, a.disp_qty issuedqty, b.disp_uom_code qtyuom, c.encounter_id, b.order_id, b.order_line_no, b.issue_qty, b.issue_uom_code, c.patient_class patient_class, B.DISP_LOCN_CODE locn FROM ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c, ph_drug d, st_item j, st_sal_hdr k, or_order l WHERE a.facility_id = b.facility_id AND k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type AND k.facility_id = c.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND c.facility_id = b.facility_id AND c.disp_no = b.disp_no AND b.disp_drug_code = d.drug_code AND a.disp_qty <> NVL (a.returned_qty, 0) AND a.item_code = j.item_code AND c.order_id = l.order_id AND b.order_id = c.order_id AND NVL (l.iv_prep_yn, 'X') NOT IN ('2', '4', '6', '8', '0') AND ( (j.use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR (j.use_after_expiry_yn = 'Y') ) AND l.patient_id = ? AND b.added_date BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND TO_DATE (?, 'dd/mm/yyyy hh24:mi') + 1 AND b.facility_id = ? AND b.disp_no = NVL (?, a.disp_no) AND l.patient_class = NVL (?, l.patient_class) AND c.bed_no = NVL (?, c.bed_no) AND l.source_code = NVL (?, l.source_code) ORDER BY b.added_date DESC";
			//Function Parameters
			if(order_type.equals("A")){ //MMS-KH-CRF-0039
				if(status.equals("A")){
					status_sql="and e.WARD_ACKNOWLEDGE = 'A'";
				}
				else{
					status_sql ="and NVL(e.WARD_ACKNOWLEDGE,'$') <> 'A'";
				}

			}else{
				if(status.equals("A")){ //MMS-KH-CRF-0039-end
					status_sql="and a.WARD_ACKNOWLEDGE = 'A'";
				}
				else{
				status_sql ="and NVL(a.WARD_ACKNOWLEDGE,'$') <> 'A'";
				}
			}
			//String sql = "SELECT d.drug_desc, c.bed_no, TO_CHAR (b.added_date, 'DD/MM/YYYY hh24:mi')added_date,(SELECT short_desc FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = c.locn_code and locn_type = c.locn_type)LOCN_CODE, DECODE (j.use_after_expiry_yn, 'Y', 'Y', 'N', DECODE (GREATEST (SYSDATE, expiry_date), SYSDATE, 'N', 'Y' ) ) valid, c.doc_type, c.doc_no, a.store_code, a.item_code, a.bin_location_code, a.batch_id, TO_CHAR (a.expiry_date, 'DD/MM/YYYY') expiry_date, a.trade_id trade_id, a.disp_no, a.srl_no, b.doc_srl_no, a.srl_no_batch, TO_CHAR (b.added_date, 'dd/mm/yyyy') added_date, a.disp_qty issuedqty, b.disp_uom_code qtyuom, c.encounter_id, b.order_id, b.order_line_no, b.issue_qty, b.issue_uom_code, c.patient_class patient_class, (SELECT short_desc FROM ph_disp_locn_lang_vw WHERE disp_locn_code = l.performing_deptloc_code AND language_id = ? AND facility_id = c.facility_id) locn,am_get_desc.am_practitioner (B.MODIFIED_BY_ID,?,'1')MODIFIED_BY_ID,TO_CHAR (b.modified_date, 'DD/MM/YYYY hh24:mi')modified_date,am_get_desc.am_practitioner (a.ADDED_BY_ID,?,'1')ADDED_BY_ID FROM ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c, ph_drug d, st_item j, st_sal_hdr k, or_order l WHERE a.facility_id = b.facility_id AND k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type AND k.facility_id = c.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND c.facility_id = b.facility_id AND c.disp_no = b.disp_no AND b.disp_drug_code = d.drug_code AND a.disp_qty <> NVL (a.returned_qty, 0) AND a.item_code = j.item_code AND c.order_id = l.order_id AND b.order_id = c.order_id AND NVL (l.iv_prep_yn, 'X') NOT IN ('2', '4', '6', '8', '0') AND ( (j.use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR (j.use_after_expiry_yn = 'Y') ) AND l.patient_id = ? AND b.added_date BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND TO_DATE (?, 'dd/mm/yyyy hh24:mi') + 1 AND b.facility_id = ? AND b.disp_no = NVL (?, a.disp_no) AND l.patient_class = NVL (?, l.patient_class) AND c.bed_no = NVL (?, c.bed_no) AND l.source_code = NVL (?, l.source_code) "+status_sql+" ORDER BY b.added_date DESC";
			//String sql = "SELECT distinct d.drug_desc, c.bed_no, TO_CHAR (b.added_date, 'DD/MM/YYYY hh24:mi')added_date,(SELECT short_desc FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = c.locn_code and locn_type = c.locn_type)LOCN_CODE, DECODE (j.use_after_expiry_yn, 'Y', 'Y', 'N', DECODE (GREATEST (SYSDATE, expiry_date), SYSDATE, 'N', 'Y' ) ) valid, c.doc_type, c.doc_no, a.store_code, a.item_code, a.bin_location_code, a.disp_no, a.srl_no, b.doc_srl_no,  TO_CHAR (b.added_date, 'dd/mm/yyyy') added_date1, b.disp_uom_code qtyuom, c.encounter_id, b.order_id, b.order_line_no, b.issue_qty, b.issue_uom_code, c.patient_class patient_class, (SELECT short_desc FROM ph_disp_locn_lang_vw WHERE disp_locn_code = l.performing_deptloc_code AND language_id = ? AND facility_id = c.facility_id) locn,am_get_desc.am_practitioner (B.MODIFIED_BY_ID,?,'1')MODIFIED_BY_ID,TO_CHAR (b.modified_date, 'DD/MM/YYYY hh24:mi')modified_date,am_get_desc.am_practitioner (a.ADDED_BY_ID,?,'1')ADDED_BY_ID FROM ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c, ph_drug d, st_item j, st_sal_hdr k, or_order l WHERE a.facility_id = b.facility_id AND k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type AND k.facility_id = c.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND c.facility_id = b.facility_id AND c.disp_no = b.disp_no AND b.disp_drug_code = d.drug_code AND a.disp_qty <> NVL (a.returned_qty, 0) AND a.item_code = j.item_code AND c.order_id = l.order_id AND b.order_id = c.order_id AND NVL (l.iv_prep_yn, 'X') NOT IN ('2', '4', '6', '8', '0') AND ( (j.use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR (j.use_after_expiry_yn = 'Y') ) AND l.patient_id = ? AND b.added_date BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND TO_DATE (?, 'dd/mm/yyyy hh24:mi') + 1 AND b.facility_id = ? AND b.disp_no = NVL (?, a.disp_no) AND l.patient_class = NVL (?, l.patient_class) AND c.bed_no = NVL (?, c.bed_no) AND l.source_code = NVL (?, l.source_code) and a.store_code = NVL (?, a.store_code) AND c.order_id = NVL (?, c.order_id)"+status_sql+" ORDER BY disp_no DESC";
			/* below sql commented for GHL-CRF-0399.2 */
			//String sql="SELECT distinct d.drug_desc, c.bed_no, TO_CHAR (b.added_date, 'DD/MM/YYYY hh24:mi')added_date,(SELECT short_desc from ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = c.locn_code and locn_type = c.locn_type)LOCN_CODE, DECODE (j.use_after_expiry_yn, 'Y', 'Y', 'N', DECODE (GREATEST (SYSDATE, expiry_date), SYSDATE, 'N', 'Y' ) ) valid, c.doc_type, c.doc_no, a.store_code, a.item_code, a.bin_location_code, a.disp_no, a.srl_no, b.doc_srl_no, b.disp_uom_code qtyuom, c.encounter_id, b.order_id, b.order_line_no, b.issue_qty, b.issue_uom_code, c.patient_class patient_class, (SELECT short_desc FROM ph_disp_locn_lang_vw WHERE disp_locn_code = l.performing_deptloc_code AND language_id = ? AND facility_id = c.facility_id) locn,TO_CHAR (a.ack_modified_date, 'DD/MM/YYYY hh24:mi')ack_date,(SELECT appl_user_name description FROM sm_appl_user WHERE appl_user_id =a.acknowledge_by_id) ack_by_id,(SELECT appl_user_name description FROM sm_appl_user WHERE appl_user_id =b.modified_by_id) disp_by_id,am_get_desc.am_practitioner (c.PRES_PHYSICIAN_ID,'en','1') order_by_id FROM ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c, ph_drug d, st_item j, st_sal_hdr k, or_order l WHERE a.facility_id = b.facility_id AND k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type AND k.facility_id = c.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND c.facility_id = b.facility_id AND c.disp_no = b.disp_no AND b.disp_drug_code = d.drug_code AND a.disp_qty <> NVL (a.returned_qty, 0) AND a.item_code = j.item_code AND c.order_id = l.order_id AND b.order_id = c.order_id AND NVL (l.iv_prep_yn, 'X') NOT IN ('2', '4', '6', '8', '0') AND ( (j.use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR (j.use_after_expiry_yn = 'Y') ) AND l.patient_id = ? and b.added_date BETWEEN TO_DATE (? ||':00', 'dd/mm/yyyy hh24:mi:ss') AND TO_DATE (? ||':59','dd/mm/yyyy hh24:mi:ss') AND b.facility_id = ? AND b.disp_no = NVL (?, a.disp_no) AND l.patient_class = NVL (?, l.patient_class) AND c.bed_no = NVL (?, c.bed_no) AND l.source_code = NVL (?, l.source_code) and a.store_code = NVL (?, a.store_code) AND c.order_id = NVL (?, c.order_id)"+status_sql+" ORDER BY disp_no DESC";
			/* below sql  Added for GHL-CRF-0399.2 */
			//String sql ="SELECT DISTINCT d.drug_desc, c.bed_no, TO_CHAR (b.added_date, 'DD/MM/YYYY hh24:mi') added_date, (SELECT short_desc FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = c.locn_code AND locn_type = c.locn_type) locn_code, DECODE (j.use_after_expiry_yn, 'Y', 'Y', 'N', DECODE (GREATEST (SYSDATE, expiry_date), SYSDATE, 'N', 'Y' ) ) valid, c.doc_type, c.doc_no, a.store_code, a.item_code, a.bin_location_code, a.disp_no, a.srl_no, b.doc_srl_no, b.disp_uom_code qtyuom, c.encounter_id, b.order_id, b.order_line_no, b.issue_qty, b.issue_uom_code, c.patient_class patient_class, (SELECT short_desc FROM ph_disp_locn_lang_vw WHERE disp_locn_code = l.performing_deptloc_code AND language_id = ? AND facility_id = c.facility_id) locn, TO_CHAR (a.ack_modified_date, 'DD/MM/YYYY hh24:mi') ack_date, (SELECT appl_user_name description FROM sm_appl_user WHERE appl_user_id = a.acknowledge_by_id) ack_by_id, (SELECT appl_user_name description FROM sm_appl_user WHERE appl_user_id = b.modified_by_id) disp_by_id, am_get_desc.am_practitioner (c.pres_physician_id, 'en', '1' ) order_by_id, d.drug_class,(select GENRAL_DRUG_YN from ph_ward_ack_rights where (SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = c.locn_code AND locn_type = c.locn_type) = nursing_unit_code AND USER_ID=? ) GENRAL_DRUG_YN, (select NARCOTIC_DRUG_YN from ph_ward_ack_rights where (SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = c.locn_code AND locn_type = c.locn_type) = nursing_unit_code AND USER_ID=? ) NARCOTIC_DRUG_YN, (select CONTROLLED_DRUG_YN from ph_ward_ack_rights where (SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = c.locn_code AND locn_type = c.locn_type) = nursing_unit_code AND USER_ID=? ) CONTROLLED_DRUG_YN FROM ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c, ph_drug d, st_item j, st_sal_hdr k, or_order l WHERE a.facility_id = b.facility_id AND k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type AND k.facility_id = c.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND c.facility_id = b.facility_id AND c.disp_no = b.disp_no AND b.disp_drug_code = d.drug_code AND a.disp_qty <> NVL (a.returned_qty, 0) AND a.item_code = j.item_code AND c.order_id = l.order_id AND b.order_id = c.order_id AND NVL (l.iv_prep_yn, 'X') NOT IN ('2', '4', '6', '8', '0') AND ( (j.use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR (j.use_after_expiry_yn = 'Y') ) AND l.patient_id = ? AND b.added_date BETWEEN TO_DATE (? || ':00', 'dd/mm/yyyy hh24:mi:ss' ) AND TO_DATE (? || ':59', 'dd/mm/yyyy hh24:mi:ss' ) AND b.facility_id = ? AND b.disp_no = NVL (?, a.disp_no) AND l.patient_class = NVL (?, l.patient_class) AND c.bed_no = NVL (?, c.bed_no) AND l.source_code = NVL (?, l.source_code) AND a.store_code = NVL (?, a.store_code) AND c.order_id = NVL (?, c.order_id) "+status_sql+" ORDER BY disp_no DESC";
			String rights_status=bean.getAckRightsDetails((String)session.getValue( "login_user"));//added for GHL-CRF-0466
			//added for mms-kh-crf-0014 start 
			String patient_required="";
		     if(!patientId.equals(""))
		    	 patient_required="AND l.patient_id = ?";
		    		
		     String soure_code_required="";
		     if(!nursingUnitCode.equals("")){
		     soure_code_required=" AND l.source_code= ?";

		     }
		     else{
		     soure_code_required="AND l.source_code = NVL (?, l.source_code)";
		     }
		   //added for mms-kh-crf-0014 end
			//a.disp_qty changed to b.disp_qty changed for IN068342
			if(order_type.equals("A")){ //if condition added for MMS-KH-CRF-0039
				sql ="SELECT DISTINCT e.MFG_UNIT drug_desc, c.bed_no, TO_CHAR (c.added_date, 'DD/MM/YYYY hh24:mi') added_date,(SELECT short_desc  FROM ip_nursing_unit WHERE facility_id = c.facility_id  AND nursing_unit_code = c.locn_code AND locn_type = c.locn_type) locn_code,  e.worksheet_id disp_no, '1' srl_no,   b.order_id,   '1' order_line_no,(SELECT short_desc  FROM ph_disp_locn_lang_vw WHERE disp_locn_code = l.performing_deptloc_code  AND language_id = ? AND facility_id = c.facility_id) locn, TO_CHAR (e.ack_modified_date, 'DD/MM/YYYY hh24:mi') ack_date, (SELECT appl_user_name description  FROM sm_appl_user  WHERE appl_user_id = e.acknowledge_by_id) ack_by_id, (SELECT appl_user_name description  FROM sm_appl_user  WHERE appl_user_id = b.modified_by_id) disp_by_id, am_get_desc.am_practitioner (l.ord_pract_id,  ?,'1') order_by_id, '' drug_class, 'Y' genral_drug_yn, 'Y' narcotic_drug_yn, 'Y' controlled_drug_yn, DECODE (l.priority, 'R', 'Routine', 'U', 'Urgent') priority,'' order_qty,  QTY_VOLUME dispensedqty, '' issue_uom_desc,e.QTY_UOM desped_uom_desc, l.patient_id,'' order_line_status,c.DISP_LOCN_CODE  FROM  ph_disp_dtl b, ph_disp_hdr c, ph_worksheet_hdr e, st_sal_hdr k, or_order l WHERE b.facility_id = c.facility_id  AND c.facility_id = e.facility_id AND k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type  AND k.facility_id = c.facility_id  AND b.disp_no = c.disp_no AND c.order_id = l.order_id  AND b.order_id = c.order_id  AND b.order_id = e.order_id  AND c.order_id = e.order_id AND l.order_id = e.order_id AND l.iv_prep_yn IN ('0','2','4','6')"+patient_required+ " AND b.added_date BETWEEN TO_DATE (?|| ':00','dd/mm/yyyy hh24:mi:ss') AND TO_DATE (?|| ':59','dd/mm/yyyy hh24:mi:ss' )  AND b.facility_id = ? AND e.worksheet_id = NVL (?, e.worksheet_id)  AND l.patient_class = 'IP'" +soure_code_required+" AND b.store_code = NVL (?, b.store_code) AND c.order_id = NVL (?, c.order_id) "+status_sql+"  ORDER BY e.worksheet_id DESC";
			}else{
			if(rights_status.equals("Y")){//if  else condtion is added for //added for GHL-CRF-0466
				 sql ="SELECT DISTINCT d.drug_desc, c.bed_no, TO_CHAR (b.added_date, 'DD/MM/YYYY hh24:mi') added_date, (SELECT short_desc FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = c.locn_code AND locn_type = c.locn_type) locn_code, DECODE (j.use_after_expiry_yn, 'Y', 'Y', 'N', DECODE (GREATEST (SYSDATE, expiry_date), SYSDATE, 'N', 'Y' ) ) valid, c.doc_type, c.doc_no, a.store_code, a.item_code, a.bin_location_code, a.disp_no, a.srl_no, b.doc_srl_no, b.disp_uom_code qtyuom, c.encounter_id, b.order_id, b.order_line_no, b.issue_qty, b.issue_uom_code, c.patient_class patient_class, (SELECT short_desc FROM ph_disp_locn_lang_vw WHERE disp_locn_code = l.performing_deptloc_code AND language_id = ? AND facility_id = c.facility_id) locn, TO_CHAR (a.ack_modified_date, 'DD/MM/YYYY hh24:mi') ack_date, (SELECT appl_user_name description FROM sm_appl_user WHERE appl_user_id = a.acknowledge_by_id) ack_by_id, (SELECT appl_user_name description FROM sm_appl_user WHERE appl_user_id = b.modified_by_id) disp_by_id, am_get_desc.am_practitioner (c.pres_physician_id, ?, '1' ) order_by_id, d.drug_class,'Y' GENRAL_DRUG_YN, 'Y' NARCOTIC_DRUG_YN, 'Y' CONTROLLED_DRUG_YN,DECODE (l.priority, 'R', 'Routine', 'U', 'Urgent') priority,ol.order_qty, b.disp_qty dispensedqty, (SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = ol.order_uom AND language_id = ?) issue_uom_desc,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = b.disp_uom_code AND language_id = ?) desped_uom_desc,l.patient_id,ol.order_line_status,c.DISP_LOCN_CODE FROM ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c, ph_drug d, st_item j, st_sal_hdr k, or_order l,or_order_line ol WHERE a.facility_id = b.facility_id AND ol.order_id = l.order_id AND ol.order_id = b.order_id AND ol.order_line_num = b.order_line_no AND k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type AND k.facility_id = c.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND c.facility_id = b.facility_id AND c.disp_no = b.disp_no AND b.disp_drug_code = d.drug_code AND a.disp_qty <> NVL (a.returned_qty, 0) AND a.item_code = j.item_code AND c.order_id = l.order_id AND b.order_id = c.order_id AND NVL (l.iv_prep_yn, 'X') NOT IN ('8') AND ( (j.use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR (j.use_after_expiry_yn = 'Y') ) "+patient_required+" AND b.added_date BETWEEN TO_DATE (? || ':00', 'dd/mm/yyyy hh24:mi:ss' ) AND TO_DATE (? || ':59', 'dd/mm/yyyy hh24:mi:ss' ) AND b.facility_id = ? AND b.disp_no = NVL (?, a.disp_no) AND l.patient_class = NVL (?, l.patient_class) AND c.bed_no = NVL (?, c.bed_no) "+soure_code_required+" AND a.store_code = NVL (?, a.store_code) AND c.order_id = NVL (?, c.order_id) "+status_sql+" ORDER BY disp_no DESC"; //modified for  GHL-CRF-0466 // in select 'l.patient_id','ol.order_line_status' & in where condition 'OR l.source_code = ?' & 'AND ol.order_line_num = b.order_line_no' Added for MMS-KH-CRF-0014 [IN:067953]
			}
			else{
			 sql ="SELECT DISTINCT d.drug_desc, c.bed_no, TO_CHAR (b.added_date, 'DD/MM/YYYY hh24:mi') added_date, (SELECT short_desc FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = c.locn_code AND locn_type = c.locn_type) locn_code, DECODE (j.use_after_expiry_yn, 'Y', 'Y', 'N', DECODE (GREATEST (SYSDATE, expiry_date), SYSDATE, 'N', 'Y' ) ) valid, c.doc_type, c.doc_no, a.store_code, a.item_code, a.bin_location_code, a.disp_no, a.srl_no, b.doc_srl_no, b.disp_uom_code qtyuom, c.encounter_id, b.order_id, b.order_line_no, b.issue_qty, b.issue_uom_code, c.patient_class patient_class, (SELECT short_desc FROM ph_disp_locn_lang_vw WHERE disp_locn_code = l.performing_deptloc_code AND language_id = ? AND facility_id = c.facility_id) locn, TO_CHAR (a.ack_modified_date, 'DD/MM/YYYY hh24:mi') ack_date, (SELECT appl_user_name description FROM sm_appl_user WHERE appl_user_id = a.acknowledge_by_id) ack_by_id, (SELECT appl_user_name description FROM sm_appl_user WHERE appl_user_id = b.modified_by_id) disp_by_id, am_get_desc.am_practitioner (c.pres_physician_id, ?, '1' ) order_by_id, d.drug_class,(select GENRAL_DRUG_YN from ph_ward_ack_rights where (SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = c.locn_code AND locn_type = c.locn_type) = nursing_unit_code AND USER_ID=? ) GENRAL_DRUG_YN, (select NARCOTIC_DRUG_YN from ph_ward_ack_rights where (SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = c.locn_code AND locn_type = c.locn_type) = nursing_unit_code AND USER_ID=? ) NARCOTIC_DRUG_YN, (select CONTROLLED_DRUG_YN from ph_ward_ack_rights where (SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = c.locn_code AND locn_type = c.locn_type) = nursing_unit_code AND USER_ID=? ) CONTROLLED_DRUG_YN,DECODE (l.priority, 'R', 'Routine', 'U', 'Urgent') priority,ol.order_qty, b.disp_qty dispensedqty, (SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = ol.order_uom AND language_id = ?) issue_uom_desc,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = b.disp_uom_code AND language_id = ?) desped_uom_desc,l.patient_id,ol.order_line_status,c.DISP_LOCN_CODE FROM ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c, ph_drug d, st_item j, st_sal_hdr k, or_order l,or_order_line ol WHERE a.facility_id = b.facility_id AND ol.order_id = l.order_id AND ol.order_id = b.order_id AND ol.order_line_num = b.order_line_no  AND k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type AND k.facility_id = c.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND c.facility_id = b.facility_id AND c.disp_no = b.disp_no AND b.disp_drug_code = d.drug_code AND a.disp_qty <> NVL (a.returned_qty, 0) AND a.item_code = j.item_code AND c.order_id = l.order_id AND b.order_id = c.order_id AND NVL (l.iv_prep_yn, 'X') NOT IN ('8') AND ( (j.use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR (j.use_after_expiry_yn = 'Y') )  "+patient_required+" AND b.added_date BETWEEN TO_DATE (? || ':00', 'dd/mm/yyyy hh24:mi:ss' ) AND TO_DATE (? || ':59', 'dd/mm/yyyy hh24:mi:ss' ) AND b.facility_id = ? AND b.disp_no = NVL (?, a.disp_no) AND l.patient_class = NVL (?, l.patient_class) AND c.bed_no = NVL (?, c.bed_no) "+soure_code_required+" AND a.store_code = NVL (?, a.store_code) AND c.order_id = NVL (?, c.order_id) "+status_sql+" ORDER BY disp_no DESC"; //modified for  GHL-CRF-0451 // in select 'l.patient_id','ol.order_line_status' & & in where condition 'OR l.source_code = ?' & 'AND ol.order_line_num = b.order_line_no' Added for MMS-KH-CRF-0014 [IN:067953]
			}
			}
			System.out.println("sql==========="+sql);
			HashMap funcMap = new HashMap();
			ArrayList displayFields = new ArrayList();
			ArrayList chkFields = new ArrayList();
			HashMap sqlMap = new HashMap();
			sqlMap.put( "sqlData",  sql);
			chkFields.add(locale);
			chkFields.add(locale);//Added for GHL-CRF-0451
			if(!order_type.equals("A")){ //MMS-KH-CRF-0039
			
			if(!rights_status.equals("Y")){//if   condtion is added for //added for GHL-CRF-0466
			chkFields.add((String)session.getValue( "login_user" ) ); //  Added for GHL-CRF-0399.2
			chkFields.add((String) session.getValue( "login_user" )	); //  Added for GHL-CRF-0399.2
			chkFields.add((String) session.getValue( "login_user" )	); //  Added for GHL-CRF-0399.2
			}
		    chkFields.add(locale);//ADDED FOR GHL-CRF-0451
			chkFields.add(locale);//ADDED FOR GHL-CRF-0451
			}
			if(!patientId.equals(""))
					chkFields.add(patientId);
			chkFields.add(wardDateFrom);
			chkFields.add(wardDateTo);
			chkFields.add(facility_id);

			if(order_type.equals("A"))  //MMS-KH-CRF-0039
			chkFields.add(worksheet_id);
			else
			chkFields.add(dispNo);

		if(!order_type.equals("A")) //MMS-KH-CRF-0039
			chkFields.add("IP");

		if(!order_type.equals("A")) //MMS-KH-CRF-0039
			chkFields.add(bedNoCode);
			chkFields.add(nursingUnitCode);
			chkFields.add(dispLocn);
			chkFields.add(orderId);
			displayFields.add("DISP_NO");//0
			displayFields.add("ADDED_DATE");//1
			displayFields.add("LOCN");//2
			displayFields.add("BED_NO");//3
			displayFields.add("LOCN_CODE");//4
			displayFields.add("ORDER_ID");//5
			displayFields.add("ACK_DATE");//6
			displayFields.add("ACK_BY_ID");//7
			displayFields.add("DISP_BY_ID");//8
			displayFields.add("ORDER_BY_ID");//9
			displayFields.add("SRL_NO");//10
			displayFields.add("DRUG_CLASS");//11       Added for GHL-CRF-0399.2
			displayFields.add("GENRAL_DRUG_YN");//12   Added for GHL-CRF-0399.2
			displayFields.add("NARCOTIC_DRUG_YN");//13  Added for GHL-CRF-0399.2
			displayFields.add("CONTROLLED_DRUG_YN");//14 Added for GHL-CRF-0399.2
			displayFields.add("DRUG_DESC");//15 //added for GHL-CRF-0451
			displayFields.add("ORDER_QTY");	//16//added for GHL-CRF-0451
			displayFields.add("DISPENSEDQTY");	//17//added for GHL-CRF-0451
			displayFields.add("PRIORITY");//18//added for GHL-CRF-0451
			displayFields.add("ISSUE_UOM_DESC");//19//added for GHL-CRF-0451
			displayFields.add("DESPED_UOM_DESC");//20//added for GHL-CRF-0451
			displayFields.add("PATIENT_ID");//21//added for MMS-KH-CRF-0014 [IN:067953] - Start
			displayFields.add("ORDER_LINE_STATUS");//22
			displayFields.add("ORDER_LINE_NO");//23//added for MMS-KH-CRF-0014 [IN:067953] - End		
			displayFields.add("DISP_LOCN_CODE");//added for MMS-KH-CRF-0039
			// Adding function related array list into the HashMap
			funcMap.put( "displayFields", displayFields );
			funcMap.put( "chkFields", chkFields );
			
			//ArrayList batchDetails=bean.getWardAcknowledgeDetails(wardDateTo,wardDateFrom,patientId,dispNo,dispLocn,orderId,nursingUnitCode,bedNoCode,status);
			ArrayList batchDetails=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);
			//int totalRows=batchDetails.size()/6;
			boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;
			if (batchDetails.size()<3){
				%>
				
				<!--Added for GHL-CRF-0399  [IN062299] start -->
				<script>	
				
				if(document.formwardaAcknowledge == undefined){
					parent.wardacknowledgequeryframe.document.FormWardAcknowlegmentQueryCriteria.onch.value="";
					
					<%	if(onch.equals("Y")){%>
					
				<%	}%>
				}</script>
				<script>	if(document.formwardaAcknowledge == undefined){<%if(!onch.equals("Y")){%>
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));parent.parent.reset();
				<%	}%>
				}
				</script>
				
	
			<%			}//Added for GHL-CRF-0399  [IN062299] end
			else{
			/*ArrayList patientDetails=new ArrayList();
			patientDetails=bean.getPatientDetails(patientId);
			String patient_name = (String)patientDetails.get(0);
			String sex	= (String)patientDetails.get(1);
			String age	= (String)patientDetails.get(2);
			
			if(sex.equalsIgnoreCase("female"))
				sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			else if(sex.equalsIgnoreCase("male"))
				sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			else if(sex.equalsIgnoreCase("unknown"))
				sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");*/ // commented for  MMS-KH-CRF-0014 [IN:067953]  
%>
			
<form name="formwardaAcknowledge" id="formwardaAcknowledge">
	<!-- <TABLE width="100%" cellspacing="0" cellpadding="0" commented for MMS-KH-CRF-0014 [IN:067953] - Start
		border="1"><tr>
		<th class="commontoolbarfunction" align="left" >&nbsp;<%//patient_name%>&nbsp;,&nbsp;<%//sex%>&nbsp;,&nbsp;<%//age%>,&nbsp;<%//patientId%></th>	
	</tr>
	<tr></tr>
	<tr></tr></table>
	<table cellpadding=0 cellspacing=0 width="100%" align="center"
		topmargin='0'>
		<tr>
			<td width="80%" class="white">&nbsp;</td>
			<td width="20%" class="white">&nbsp; --><%
					// For display the previous/next link
					//out.println(batchDetails.get(1));
				%>
		<!-- 	</td>
		</tr>
	</table> commented for MMS-KH-CRF-0014 [IN:067953] - End -->	
	<%if(barcode_flag && !status.equals("A")){ // Added for MMS-KH-CRF-0014 [IN:067953] - Start%>
	<div  style="font-family:verdana;font-size:8pt;COLOR:navy;" width="34%" class="QRYODD" align="right"><fmt:message key="eST.BarCodeId.label" bundle="${st_labels}"/>				
		 <input type="text" style="text-align:right;background-color:#fde6d0;padding-left:20px" name="barCodeId" id="barCodeId" onkeydown="if (event.keyCode==13) {barcodeScan(this)}" maxlength="50">
		 <span style="padding-left:68px;"></span>
	</div>
	<%} // Added for MMS-KH-CRF-0014 [IN:067953] - End %>
	<div style="float:left;overflow-y:auto; height:428px; width:100%"> <!-- Added for MMS-KH-CRF-0014 [IN:067953] -->
	<TABLE width="100%" align="left" cellspacing="0" cellpadding="0" border="1" id="tablePreRec"> <!-- id="tablePreRec Added for MMS-KH-CRF-0014 [IN:067953] -->					
		<TR style='position:relative;' style='top:expression(this.offsetParent.scrollTop-1)'>
			<td class='COLUMNHEADER' width=5%><fmt:message
					key="ePH.DispenseNo.label" bundle="${ph_labels}" /></td>
			<td class='COLUMNHEADER' width=6%><fmt:message
					key="Common.Dispensed.label" bundle="${common_labels}" /> <fmt:message
					key="Common.datetime.label" bundle="${common_labels}" /></td>
			<td class='COLUMNHEADER' width=5%><fmt:message
					key="ePH.DispenseLocation.label" bundle="${ph_labels}" /></td>
			<td class='COLUMNHEADER' width=5%><fmt:message
					key="Common.bedno.label" bundle="${common_labels}" /></td>
			<td class='COLUMNHEADER' width=5%><fmt:message
					key="Common.nursingUnit.label" bundle="${common_labels}" /></td>
			<%-- <td class='COLUMNHEADER' width=10%><fmt:message
					key="Common.OrderID.label" bundle="${common_labels}" /></td> --%>
					<!-- added for GHL-CRF-0451 START -->
					<% //MMS-KH-CRF-0039
					if(order_type.equals("A")){%>
					<td class='COLUMNHEADER' width=10%><fmt:message
					key="Common.ProductName.label" bundle="${common_labels}" /></td>

					<td class='COLUMNHEADER' width=5%><fmt:message key="ePH.PreparedQuantity.label" bundle="${ph_labels}"/></td>
					<%}else{%>
					
					<td class='COLUMNHEADER' width=10%><fmt:message
					key="ePH.DrugDescription.label" bundle="${ph_labels}" /></td> <!-- Modified for TFS-13907 -->
					
					<td class='COLUMNHEADER' width=5%><fmt:message key="ePH.OrderQuantity.label" bundle="${ph_labels}"/></td>
					<td class='COLUMNHEADER' width=5%><fmt:message key="ePH.DispenseQuantity.label" bundle="${ph_labels}"/></td>
					<%}
					%>
						<td class='COLUMNHEADER' width=5%><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td> <!-- Modified for TFS-13907 -->
						<!-- added for GHL-CRF-0451 END -->
			<td class='COLUMNHEADER' width=5%><fmt:message
					key="Common.OrderedBy.label" bundle="${common_labels}" /></td>
			<td class='COLUMNHEADER' width=5%><fmt:message
					key="Common.Dispensed.label" bundle="${common_labels}" /> <fmt:message
					key="Common.by.label" bundle="${common_labels}" /></td> 
			<% if(status.equals("A")){%>
				<td class='COLUMNHEADER' width=10%><fmt:message
					key="ePH.Acknowledgedby.label" bundle="${ph_labels}" /></td> <!-- Modified for TFS-13907 -->
						<td class='COLUMNHEADER' width=10%><fmt:message
					key="ePH.Acknowledge.label" bundle="${ph_labels}" /> <fmt:message 
					key="Common.datetime.label" bundle="${common_labels}" /></td> <!-- Modified for TFS-13907 -->
		<%	}else{%><td class='COLUMNHEADER' width=5%>
				<input type=checkbox name="selectall" id="selectall" id="selectall"  onClick="selectAll(this)">
			Acknowledge</td><% }%>
		</tr>
		<%
					ArrayList records=new ArrayList();
 		            String sex = ""; // Added for MMS-KH-CRF-0014 [IN:067953] - Start
 		            String age = ""; 
 		            String patient_name = "";
 		            String tmp_patientId = "";
 		            String order_id = "";
 		            String order_line_no = "";
 		            String order_status = "";
 		            boolean flag = true;
 		            ArrayList patientDetails; // Added for MMS-KH-CRF-0014 [IN:067953] - End
					String classvalue="";
					if(batchDetails!=null){	
						for (int i=2;i<batchDetails.size();i++){
							records =(ArrayList) batchDetails.get(i);
%>
		
<%
							for(int j=0;j<records.size();j+=records.size()){
								check_disable = "";
								sex = "";    // Added for MMS-KH-CRF-0014 [IN:067953] - Start								
			 		                        age = ""; 
			 		                        patient_name = "";
			 		                        patientDetails=new ArrayList();
			 		                        if(flag){			 		        	   			 		        	  			 		        	   
			 		        	            tmp_patientId = CommonBean.checkForNull((String)records.get(j+21));
			 		                        }
			 		                        else{
			 		                           tmp_patientId = patientId;
			 		                        }
			 		                        patientId = CommonBean.checkForNull((String)records.get(j+21));
					                        patientDetails=bean.getPatientDetails(patientId);
					                        patient_name = (String)patientDetails.get(0);
					                        sex	= (String)patientDetails.get(1);
					                        age	= (String)patientDetails.get(2); 
					                        if(sex.equalsIgnoreCase("female"))
						                   sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					                        else if(sex.equalsIgnoreCase("male"))
						                   sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					                        else if(sex.equalsIgnoreCase("unknown"))
						                   sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels"); // Added for MMS-KH-CRF-0014 [IN:067953] - End

								if(!order_type.equals("A")){
								if(records.get(j+11).equals("G") && (records.get(j+12)==null || records.equals("") || records.get(j+12).equals("N"))){
									check_disable = "disabled";
								}
								else if(records.get(j+11).equals("N") && (records.get(j+12)==null || records.equals("")  || records.get(j+12).equals("N"))){ // records.get(j+11) changed to records.get(j+12) for AMS-CRF-203 
									check_disable = "disabled";
								}
								else if(records.get(j+11).equals("C") && (records.get(j+12)==null || records.equals("")  || records.get(j+12).equals("N"))){ // records.get(j+11) changed to records.get(j+12) for AMS-CRF-203
									check_disable = "disabled";
								}
								}
																System.err.println("364===============>");
                             if(flag || !tmp_patientId.equals(patientId)){ // Added for MMS-KH-CRF-0014 [IN:067953] - Start
                              flag=false;
                              actualRowCount++; // Added for MMS-KH-CRF-0014 [IN:067953] - End
%>
                              <tr> <!-- if else Added for MMS-KH-CRF-0014 [IN:067953] - Start -->
		                         <%if(status.equals("A")){ // %>
		                         <th class="commontoolbarfunction" align="left" colspan=13 >&nbsp;<%=patient_name%>&nbsp;,&nbsp;<%=sex%>&nbsp;,&nbsp;<%=age%>,&nbsp;<%=patientId%></th>
		                         <%}else{ %>
		                         <th class="commontoolbarfunction" align="left" colspan=12 >&nbsp;<%=patient_name%>&nbsp;,&nbsp;<%=sex%>&nbsp;,&nbsp;<%=age%>,&nbsp;<%=patientId%></th>
		                         <%} %>	
                              </tr>
                             <%} // Added for MMS-KH-CRF-0014 [IN:067953] - End%>
<TR>
								<TD class="<%=classvalue%>"
									style="font-family: verdana; font-size: 8pt;" align="left"><a href="#" onclick="viewDrugDetails('<%=patientId %>','<%=records.get(j)%>','<%=records.get(j+10)%>','<%=order_type%>','<%=records.get(j+24)%>')" id='mfrLink'> <%=records.get(j)%></a>
								</TD>
								<TD class="<%=classvalue%>"
									style="font-family: verdana; font-size: 8pt;" align="left">
									<%=com.ehis.util.DateUtils.convertDate((((String)(records.get(j+1))).trim()),"DMYHM","en",locale)%>
								
								</TD>
								
								<TD class="<%=classvalue%>"
									style="font-family: verdana; font-size: 8pt;" align="left"><%=records.get(j+2)%>
								</TD>
								<TD class="<%=classvalue%>"
									style="font-family: verdana; font-size: 8pt;" align="left"><%=records.get(j+3)==null?"":records.get(j+3)%>&nbsp;
								</TD>
								<TD class="<%=classvalue%>"
									style="font-family: verdana; font-size: 8pt;" align="left"><%=records.get(j+4)%>
								</TD>
								<%-- <TD class="<%=classvalue%>"
									style="font-family: verdana; font-size: 8pt;" align="left"><%=records.get(j+5)%>
								</TD> --%>
								<!-- added for GHL-CRF-0451 START -->
								<TD class="<%=classvalue%>"
									style="font-family: verdana; font-size: 8pt;" align="left"><%=records.get(j+15)%>
								</TD>
								<%
								if(!order_type.equals("A")){%>
									
								<TD class="<%=classvalue%>"
									style="font-family: verdana; font-size: 8pt;" align="left"><%=records.get(j+16)%>&nbsp;<%=records.get(j+19)%>
								</TD>
								<%}
								%>
								<TD class="<%=classvalue%>"
									style="font-family: verdana; font-size: 8pt;" align="left"><%=records.get(j+17)==null?"":records.get(j+17) %>&nbsp;<%=records.get(j+20)==null?"":records.get(j+20)%>
								</TD>
								<TD class="<%=classvalue%>"
									style="font-family: verdana; font-size: 8pt;" align="left"><%=records.get(j+18)%>
								</TD>
								<!-- added for GHL-CRF-0451 end-->
								<TD class="<%=classvalue%>"
									style="font-family: verdana; font-size: 8pt;" align="left"><%=records.get(j+9)==null?"":records.get(j+9)%>&nbsp;
								</TD>
								<TD class="<%=classvalue%>"
									style="font-family: verdana; font-size: 8pt;" align="left"><%=records.get(j+8)%>
								</TD>
								<% if(status.equals("A")){%>
								<TD class="<%=classvalue%>"
										style="font-family: verdana; font-size: 8pt;" align="left"><%=records.get(j+7)%>
									</TD>
									<TD class="<%=classvalue%>"
									style="font-family: verdana; font-size: 8pt;" align="left">
									<%=com.ehis.util.DateUtils.convertDate((((String)(records.get(j+6))).trim()),"DMYHM","en",locale)%>
									
								</TD>
			<%}else{if(bill_data.containsKey((String)records.get(j)+"_"+(String)records.get(j+10))){ checkCount++;%>	<td class="<%=classvalue%>">
									<input type="checkbox" name="chk_<%=rowCount %>" id="chk_<%=rowCount %>" id="check_id<%=rowCount%>" value="Y" checked  onclick='assignValue(this,<%=rowCount%>)'>
								</td>
								<%} else{%>
									<td class="<%=classvalue%>">
										<input type="checkbox" name="chk_<%=rowCount %>" id="chk_<%=rowCount %>" id="check_id<%=rowCount%>" value="" onclick='assignValue(this,<%=rowCount%>)' <%=check_disable%>>
									</td>
							
<%}}%><input type="hidden" name="dispno<%=rowCount%>" id="dispno<%=rowCount%>" id="dispNoc<%=rowCount%>" value="<%=records.get(j)%>">
							<input type="hidden" name="orderId<%=rowCount%>" id="orderId<%=rowCount%>"value="<%=records.get(j+5)%>">
							<input type="hidden" name="orderStatus<%=rowCount%>" id="orderStatus<%=rowCount%>"value="<%=records.get(j+22)%>"> <!-- Added for MMS-KH-CRF-0014 [IN:067953] -Start -->
							<input type="hidden" name="orderlineNo<%=rowCount%>" id="orderlineNo<%=rowCount%>"value="<%=records.get(j+23)%>">
							<input type="hidden" name="actualRowCount<%=rowCount%>" id="actualRowCount<%=rowCount%>"value="<%=actualRowCount+1%>"> <!-- Added for MMS-KH-CRF-0014 [IN:067953] - End -->
							<input type="hidden" name="srlNo<%=rowCount%>" id="srlNo<%=rowCount%>" id="srlNoc<%=rowCount%>"  value="<%=records.get(j+10)%>">
							<%
							}
%>
		</TR>
<%         rowCount++; actualRowCount++; // actualRowCount++; Added for MMS-KH-CRF-0014 [IN:067953]
					}
				}
			}
			
			if(rowCount==checkCount){
				%>
					<script>
						//alert('all Selected');
						//Added for GHL-CRF-0399  [IN062299] start
						if(document.formwardaAcknowledge == undefined){
							
						}
						else{
							document.formwardaAcknowledge.selectall.checked =true;
						}
						//Added for GHL-CRF-0399  [IN062299] end 
					</script>
				<%
			}
		
%>




</TABLE>
</div> <!-- div ended for MMS-KH-CRF-0014 [IN:067953] -->
<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%= mode %>">
<input type="hidden" name="total_count" id="total_count" value="<%=rowCount%>">
<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
<INPUT TYPE="hidden" name="order_type" id="order_type" VALUE="<%= order_type %>"><!-- added for MMS-KH-CRF-0039-->

</form>
		<%
		out.println(CommonBean.setForm ( request ,"../../ePH/jsp/WardAcknowledgeResult.jsp?ClearForm=Y", searched) );
		putObjectInBean(bean_id,bean,request); 
}catch(Exception e) {
			out.print("Exception @ Result JSP :"+e.toString());
			e.printStackTrace();
}

%>
</body>
</html>

