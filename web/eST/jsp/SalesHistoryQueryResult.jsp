<!DOCTYPE html>
<%@ page import ="eST.SalesHistoryBean,java.util.*,com.ehis.util.*,java.text.NumberFormat,java.lang.*,java.io.*,eCommon.Common.*,eST.Common.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>  <!--GHL-CRF-0557.1 -->
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		 NumberFormat nf = NumberFormat.getInstance(new Locale(locale));
		 
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/rowcolor.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eST/js/StCommon.js"></script>
		<script language="Javascript" src="../../eST/js/SalesHistory.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body >
<form name="formStockStatusByStoreResult" id="formStockStatusByStoreResult">
<%

	String bean_id				=		"SalesHistoryBean";
	String bean_name			=		"eST.SalesHistoryBean";
	SalesHistoryBean bean		=		(SalesHistoryBean) getBeanObject(bean_id, bean_name,request  );  
	bean.clear();
	String store_code			=		request.getParameter( "p_fr_st_code")==null?"":request.getParameter( "p_fr_st_code") ;
	String from_date			=		request.getParameter( "from_date")==null?"":request.getParameter( "from_date") ;
	from_date					=		DateUtils.convertDate(from_date,"DMY",locale,"en");
	String to_date				=		request.getParameter( "to_date")==null?"":request.getParameter( "to_date") ;
	to_date						=		DateUtils.convertDate(to_date,"DMY",locale,"en");
	String item_code			=		request.getParameter( "item_code" )==null?"":request.getParameter( "item_code" ) ;
	String patient_id			=		request.getParameter( "patient_id" )==null?"":request.getParameter( "patient_id" ) ;
	String  encounter_id		=		request.getParameter( "encounter_id" )==null?"":request.getParameter( "encounter_id" ) ;

	String sal_trn_type			=		request.getParameter( "sal_trn_type" )==null?"":request.getParameter( "sal_trn_type" ) ;

	String classvalue			=		"";
	String facility_id			=		(String) session.getValue( "facility_id" ) ;
	double subtotal				=		0.0;
	double pre_subtotal			=		0.0;
	boolean flag				=		true;
	boolean searched			=		(request.getParameter("searched") == null) ?false:true;
	String grand_total			=		request.getParameter( "grand_total" )==null?"0":request.getParameter( "grand_total" ) ;
	String store_compare		=		request.getParameter( "store_compare" )==null?"0":request.getParameter( "store_compare" ) ;
	double grand_tot			=		Double.parseDouble(grand_total);
//	boolean no_record			=		false;
//	boolean count				=		false;
	double cost_value_sub_total = 0.0;
	double pre_cost_value_sub_total = 0.0;
	int headercpls=7;
	/**
			* @Name - krishna
			* @Date - 24/12/2009
			* @Inc# - CRF537.1
			* @Desc - No of decimal positions No of decimal positions when u r find fmt
			* @Modified by : Priya (For the Incident 18095)
	 */
	int no_of_decimals=bean.getNoOfDecimals();		
	String view_cost_details_yn = (String)bean.getAccessCostDetails();

	/**
			 * @Name - Priya
			 * @Date - 07/06/2010
			 * @Inc# - 
			 * @Desc -  To get no of decimals for cost 
			 */
				int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());
			  nf.setMaximumFractionDigits(noOfDecimalsForCost);
			  nf.setMinimumFractionDigits(noOfDecimalsForCost);

			  /* @Name - Priya
			 * @Date - 07/07/2010
			 * @Inc# - 21346 (AK-CRF-0018)
			 * @Desc - To get the parameter values from sales history query criteria 
			*/
			  String sal_doc_type			=		request.getParameter( "sal_doc_type" )==null?"":request.getParameter( "sal_doc_type" ) ;
			  String doc_no			=		request.getParameter( "doc_no" )==null?"":request.getParameter( "doc_no" ) ;

			  patient_id = patient_id.toUpperCase();
			  System.out.println("patient_id" + patient_id);

try{

			if((bean.getCustomerID()).equals("MC")){
				headercpls=9;
			}
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			store_code			=		CommonBean.checkForNull(store_code);
			item_code			=		CommonBean.checkForNull(item_code);
			from_date			=		CommonBean.checkForNull(from_date);
			to_date				=		CommonBean.checkForNull(to_date);
			patient_id			=		CommonBean.checkForNull(patient_id);
			encounter_id		=		CommonBean.checkForNull(encounter_id);
			sal_trn_type		=		CommonBean.checkForNull(sal_trn_type,"%");
			sal_doc_type		=		CommonBean.checkForNull(sal_doc_type);  
			doc_no				=		CommonBean.checkForNull(doc_no);

			String store_code2	=		CommonBean.checkForNull(store_code);
			String item_code2	=		CommonBean.checkForNull(item_code);
			String from_date2	=		CommonBean.checkForNull(from_date);
			String to_date2		=		CommonBean.checkForNull(to_date);
			String patient_id2	=		CommonBean.checkForNull(patient_id);
			String encounter_id2=		CommonBean.checkForNull(encounter_id);
			String sal_trn_type2=		CommonBean.checkForNull(sal_trn_type,"%");  
			String sal_doc_type2 =		CommonBean.checkForNull(sal_doc_type);  
			String doc_no2		 =		CommonBean.checkForNull(doc_no);  

			String strGrandTotFlag ="";
			
				HashMap sqlMap			=		new HashMap();
				HashMap funcMap			=		new HashMap();
				ArrayList displayFields =		new ArrayList();
				ArrayList chkFields		=		new ArrayList();
				String curr_item_store	=		"";
				String prev_item_store	=		"";

				
				String sal_trn_type_query = "";

				 if(sal_trn_type.equals("I")){
					  sal_trn_type_query = "and b.take_home_yn ='N'";
				 }else if(sal_trn_type.equals("H")){
					  sal_trn_type_query = "and b.take_home_yn ='Y'";
					  sal_trn_type = "I";
				 }

				//sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_SALES_HISTORY"));
				//sqlMap.put("sqlData","select a.doc_type_code, c.short_desc doc_type_desc,a.doc_no, to_char(a.DOC_DATE,'dd/mm/yyyy') doc_date,a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc, a.patient_id, f.patient_name, b.item_qty sale_qty,round(nvl(b.GROSS_CHARGE_AMT,0),2) GROSS_CHARGE_AMT, ROUND(NVL(b.item_sal_value,0),2) item_sal_value ,ROUND(NVL(b.item_cost_value,0),2)  item_cost_value , a.sal_trn_type,b.take_home_yn  from  st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f where a.facility_id=b.facility_id and a.doc_type_code=b.doc_type_code and a.doc_no=b.doc_no and a.doc_type_code=c.doc_type_code and  a.store_code=d.store_code and b.item_code=e.item_code and a.patient_id=f.patient_id and a.facility_id = (?) and a.store_code LIKE UPPER(?) and b.item_code LIKE UPPER(?) and a.sal_trn_type like ? "+sal_trn_type_query+"and a.patient_id LIKE UPPER(?) and (a.doc_date BETWEEN to_date(TO_CHAR(nvl(?,'01/01/1901')),'dd/mm/yyyy') and to_date(TO_CHAR(nvl(?,'31/12/3012')),'dd/mm/yyyy')) and to_char(NVL(encounter_id,'0')) LIKE ? and a.FINALIZED_YN = 'Y'");	
				//sqlMap.put("sqlData","SELECT DISTINCT a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,(CASE WHEN a.sal_trn_type = 'X' THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END) patient_name1, b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT sum(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND g.primary_key_main = b.doc_type_code || '-' || b.doc_no) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty,a.added_by_id,TO_CHAR (a.ADDED_DATE, 'DD/MM/YYYY HH24:MI:SS') ADDED_DATE FROM st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id AND a.added_by_id = b.added_by_id AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = (?) AND a.store_code LIKE UPPER (?) AND b.item_code LIKE UPPER (?) AND a.sal_trn_type LIKE ? "+sal_trn_type_query+" AND a.patient_id LIKE UPPER (?) AND (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND TO_CHAR (NVL (a.encounter_id, '0')) LIKE ? AND a.finalized_yn = 'Y' AND a.doc_type_code LIKE ? AND a.doc_no LIKE ? ORDER BY a.store_code,a.doc_no,to_date(doc_date,'dd/mm/yyyy')");
				//String sql = "SELECT DISTINCT a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,(CASE WHEN a.sal_trn_type = 'X'  THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END)  patient_name1, b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT'  THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT sum(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND  g.operating_facility_id = h.operating_facility_id AND g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num  AND g.serv_item_code = h.serv_item_code AND g.primary_key_main = b.doc_type_code || '-' || b.doc_no and h.patient_id = g.patient_id and h.patient_id=a.patient_id  and g.serv_item_code=b.item_code ) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty,a.added_by_id,TO_CHAR (a.ADDED_DATE, 'DD/MM/YYYY HH24:MI:SS') ADDED_DATE FROM st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND a.finalized_yn = 'Y' AND a.doc_type_code LIKE ? AND a.doc_no LIKE ? AND a.doc_date BETWEEN to_date(?,'dd/mm/yyyy') AND to_date (?,'dd/mm/yyyy') and a.sal_trn_type LIKE ? ";
				// Commented by ganga Wednesday, November 21, 2012 for IN034623
				
				//String sql = "SELECT DISTINCT a.doc_type_code, (select short_desc from sy_doc_type_master_lang_vw where doc_type_code = a.doc_type_code and language_id= ?) doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,(select short_desc from mm_store_lang_vw where store_code=a.store_code and language_id= ?) store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,(CASE WHEN a.sal_trn_type = 'X'  THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END)  patient_name1, b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT'  THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT sum(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND  g.operating_facility_id = h.operating_facility_id AND g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num  AND g.serv_item_code = h.serv_item_code AND g.primary_key_main = b.doc_type_code || '-' || b.doc_no and h.patient_id = g.patient_id and h.patient_id=a.patient_id  and g.serv_item_code=b.item_code ) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty,a.added_by_id,TO_CHAR (a.ADDED_DATE, 'DD/MM/YYYY HH24:MI:SS') ADDED_DATE FROM st_sal_hdr a, st_sal_dtl b, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND a.finalized_yn = 'Y' AND  a.doc_date BETWEEN to_date(?,'dd/mm/yyyy') AND to_date (?,'dd/mm/yyyy')  ";

				//Modified by Sakti against MMS-SCF-0337 inc#48949 Cost Value increase
				//String sql = "SELECT DISTINCT a.doc_type_code, (select short_desc from sy_doc_type_master_lang_vw where doc_type_code = a.doc_type_code and language_id= ?) doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,(select short_desc from mm_store_lang_vw where store_code=a.store_code and language_id= ?) store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,(CASE WHEN a.sal_trn_type = 'X'  THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END)  patient_name1, b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT'  THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT sum(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND  g.operating_facility_id = h.operating_facility_id AND g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num  AND g.serv_item_code = h.serv_item_code AND g.primary_key_main = b.doc_type_code || '-' || b.doc_no and h.patient_id = g.patient_id and h.patient_id=a.patient_id  and g.serv_item_code=b.item_code ) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND(((  b.item_qty * (SELECT ROUND (AVG (curr_unit_cost), 3)  FROM st_item_unit_cost_history  WHERE trn_type IN ('OBS', 'GRN')  AND item_code = b.item_code and changed_Date <= a.doc_Date)) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty,a.added_by_id,TO_CHAR (a.ADDED_DATE, 'DD/MM/YYYY HH24:MI:SS') ADDED_DATE FROM st_sal_hdr a, st_sal_dtl b, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND a.finalized_yn = 'Y' AND  a.doc_date BETWEEN to_date(?,'dd/mm/yyyy') AND to_date (?,'dd/mm/yyyy')  ";

				//Modified by Sakti against MMS-SCF-0381 inc#50206 Unit_cost logic changed. 
				//String sql = "SELECT DISTINCT a.doc_type_code, (select short_desc from sy_doc_type_master_lang_vw where doc_type_code = a.doc_type_code and language_id= ?) doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,(select short_desc from mm_store_lang_vw where store_code=a.store_code and language_id= ?) store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,(CASE WHEN a.sal_trn_type = 'X'  THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END)  patient_name1, b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT'  THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT sum(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND  g.operating_facility_id = h.operating_facility_id AND g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num  AND g.serv_item_code = h.serv_item_code AND g.primary_key_main = b.doc_type_code || '-' || b.doc_no and h.patient_id = g.patient_id and h.patient_id=a.patient_id  and g.serv_item_code=b.item_code ) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND(((  b.item_qty * (SELECT curr_unit_cost FROM st_item_unit_cost_history aa  WHERE aa.changed_date = (SELECT MAX (changed_date)  FROM st_item_unit_cost_history  WHERE trn_type IN ('OBS', 'GRN') AND item_code = b.item_code AND TRUNC (changed_date) <= a.doc_date) AND aa.item_code = b.item_code AND trn_type IN ('OBS', 'GRN') AND ROWNUM = 1)) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty,a.added_by_id,TO_CHAR (a.ADDED_DATE, 'DD/MM/YYYY HH24:MI:SS') ADDED_DATE FROM st_sal_hdr a, st_sal_dtl b, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND a.finalized_yn = 'Y' AND  a.doc_date BETWEEN to_date(?,'dd/mm/yyyy') AND to_date (?,'dd/mm/yyyy')  ";
				//Modified by Sakti against MMS-SCF-0381 inc#50206 Unit_cost,sale_value(MMS-SCF-0380,MMS-SCF-0344) logic changed. 
				//String sql = "SELECT DISTINCT a.doc_type_code, (select short_desc from sy_doc_type_master_lang_vw where doc_type_code = a.doc_type_code and language_id= ?) doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,(select short_desc from mm_store_lang_vw where store_code=a.store_code and language_id= ?) store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,(CASE WHEN a.sal_trn_type = 'X'  THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END)  patient_name1, b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT'  THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN st_display_sale_value(a.facility_id,b.doc_type_code,b.doc_no,a.patient_id,b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND ((  (  b.item_qty * (st_display_unit_cost(b.item_code,trunc(a.doc_date)))) * st_get_uom_conv_fac_sing_str (b.item_code, a.store_code)),3) item_cost_value_new, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty,a.added_by_id,TO_CHAR (a.ADDED_DATE, 'DD/MM/YYYY HH24:MI:SS') ADDED_DATE FROM st_sal_hdr a, st_sal_dtl b, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND a.finalized_yn = 'Y' AND  a.doc_date BETWEEN to_date(?,'dd/mm/yyyy') AND to_date (?,'dd/mm/yyyy')  ";
				//Modified by suresh.r on 03-11-2014 against Inc 52256 (unitcost fun passed modified_date)
				//String sql = "SELECT DISTINCT a.doc_type_code, (select short_desc from sy_doc_type_master_lang_vw where doc_type_code = a.doc_type_code and language_id= ?) doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,(select short_desc from mm_store_lang_vw where store_code=a.store_code and language_id= ?) store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,(CASE WHEN a.sal_trn_type = 'X'  THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END)  patient_name1, b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT'  THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN st_display_sale_value(a.facility_id,b.doc_type_code,b.doc_no,a.patient_id,b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND ((  (  b.item_qty * (st_display_unit_cost(b.item_code,a.modified_date))) * st_get_uom_conv_fac_sing_str (b.item_code, a.store_code)),3) item_cost_value_new, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty,a.added_by_id,TO_CHAR (a.ADDED_DATE, 'DD/MM/YYYY HH24:MI:SS') ADDED_DATE FROM st_sal_hdr a, st_sal_dtl b, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND a.finalized_yn = 'Y' AND  a.doc_date BETWEEN to_date(?,'dd/mm/yyyy') AND to_date (?,'dd/mm/yyyy')  ";
				//Query moved to StRepoistory by suresh.r on 04-05-2015 against Inc 53228
				
				/*GHL-CRF-0557.1*/
				Connection	con1=null;
				boolean site=false;
				try
				{
					con1	= ConnectionManager.getConnection(request);
					 site = eCommon.Common.CommonBean.isSiteSpecific(con1, "ST","ST_SAL_PRICE_CHANGE");
				}
				finally
				{
					con1.close();
				}
				
				String sql="";
				if(site)
					sql =eST.Common.StRepository.getStKeyValue("SQL_ST_SALES_HISTORY_QUERY1");
				else
					sql =eST.Common.StRepository.getStKeyValue("SQL_ST_SALES_HISTORY_QUERY");
				/*GHL-CRF-0557.1*/

				displayFields.add("store_desc"); 	
				displayFields.add("item_code");	
				displayFields.add("item_desc");	
				displayFields.add("doc_type_desc");
				displayFields.add("doc_no");
				displayFields.add("doc_date");
				displayFields.add("sale_qty");
				displayFields.add("item_cost_value");
				//displayFields.add("item_sal_value");
				//displayFields.add("item_cost_value");
				displayFields.add("gross_charge_amt");
				displayFields.add("patient_id");
				displayFields.add("patient_name");
				displayFields.add("store_code");
				displayFields.add("sal_trn_type");
				displayFields.add("take_home_yn");
				displayFields.add("sale_req_qty");
				displayFields.add("pen_sal_req_qty");
				displayFields.add("added_by_id");
				displayFields.add("ADDED_DATE");
				displayFields.add("patient_name1");
				displayFields.add("item_cost_value_new");//Added by Sakti against MMS-SCF-0337 inc#48949 Cost Value increase
				
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(facility_id);
				chkFields.add(from_date);
				chkFields.add(to_date);
			
				
			if(!(sal_doc_type.equals(""))){
			sql = sql + " and a.doc_type_code = ? " ;
			chkFields.add(sal_doc_type);
			}
			if(!(doc_no.equals(""))	){
			sql = sql + " and a.doc_no = ? " ;
			chkFields.add(doc_no);
			}
			if(!(sal_trn_type.equals("%"))	){
			sql = sql + " and a.sal_trn_type = ? " ;
			chkFields.add(sal_trn_type);
			}
			if(!(store_code.equals(""))	){
			sql = sql + " and a.store_code = ? " ;
			chkFields.add(store_code);
			}
			if(!(item_code.equals(""))	){
			sql = sql + " and b.item_code = ?  "  ;
			chkFields.add(item_code);
			}
			if(!(patient_id.equals(""))	){
			sql = sql + " and a.patient_id = ? " ;
			chkFields.add(patient_id);
			}
			if(!(encounter_id.equals(""))	){
			sql = sql + " and a.encounter_id = ? "  ;
			chkFields.add(encounter_id);
			}
			if(!(sal_trn_type_query.equals(""))	){
			sql = sql + sal_trn_type_query ;
			}			

			sql = sql + " ORDER BY a.store_code,a.doc_no,to_date(doc_date,'dd/mm/yyyy')" ;


				sqlMap.put("sqlData",sql);
				funcMap.put("displayFields", displayFields);
				funcMap.put("chkFields", chkFields);
				ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		
			int cnt=2;
			String no_records="";
						int grandpreviouscnt=0;
						int grandnextcnt=0;
						int int_grandpreviouscnt=0;
						int int_grandnextcnt=0;
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0"))))
			{
			//		count=true;
					HashMap hshSalesType = new HashMap();
					hshSalesType.put("I",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inpatients.label","common_labels"));
					hshSalesType.put("O",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatients.label","common_labels"));
					hshSalesType.put("R",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Referrals.label","st_labels"));
					hshSalesType.put("H",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.discharged.label","common_labels"));
					hshSalesType.put("X",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.DirectSales.label","st_labels"));
					hshSalesType.put("E",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels"));
					hshSalesType.put("D",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels"));
					hshSalesType.put("C",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Consumption.label","st_labels"));

					
					
					if(((String)result.get(1)).indexOf("(")>0){
						strGrandTotFlag = "N";
					}else{
						strGrandTotFlag = "Y";
					}
					%>
					<table cellpadding=0 cellspacing=0 width="100%" align="center">
					<tr id="heading">
							<td width="80%" class="label">&nbsp;</td>
						<td width="20%" class="label" bgcolor="white">&nbsp;
						<%=result.get(1)%></td>

						<%
						no_records				=		(result.get(1).toString());
					
						int_grandpreviouscnt	=		no_records.indexOf('P');
						grandpreviouscnt		=		int_grandpreviouscnt;
						int_grandnextcnt		=		no_records.indexOf('N');
						grandnextcnt			=		int_grandnextcnt;
						
						try{
							if(int_grandpreviouscnt > 0)
							{
							if((no_records.substring(int_grandpreviouscnt,(int_grandpreviouscnt+8))).equals("Previous"))
							grandpreviouscnt	=		int_grandpreviouscnt;
							else 
							grandpreviouscnt	=		int_grandpreviouscnt;
							}
						}catch(Exception e1) { }
							
							try{
							if(int_grandnextcnt > 0)
							{
							if((no_records.substring(int_grandnextcnt,(int_grandnextcnt+4))).equals("Next")) 
								grandnextcnt	=		int_grandnextcnt;
							}
							else
								grandnextcnt	=		int_grandnextcnt;
							}
							catch(Exception e2) { }
						%>
						
							<%
						%>
					</tr>
					</table>
				<div  style="position:relative;height:460px;overflow:auto">

				<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" id='tb1'>
				<tr style='position:relative'style='top:expression(this.offsetParent.scrollTop-2)'>
					<th><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eST.SalesType.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></th>
					<%if((bean.getCustomerID()).equals("MC")){%>
						<th width='60'><fmt:message key="eST.Req.SaleQuantity.label" bundle="${st_labels}"/></th>
					<%}%>
					<th width='50'><fmt:message key="Common.SaleQuantity.label" bundle="${common_labels}"/></th>
					<%if((bean.getCustomerID()).equals("MC")){%>
						<th width='60'><fmt:message key="eST.PendingSaleQuantity.label" bundle="${st_labels}"/></th>
					<%}%>
			<%if(view_cost_details_yn.equals("Y")){%>
					<th><fmt:message key="eST.CostValue.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="eST.SaleValue.label" bundle="${st_labels}"/></th>
			<%}%>	
					<th nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.name.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.Createdby.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.createddate.label" bundle="${common_labels}"/></th>
					</tr>
					<%
							
							ArrayList records=new ArrayList();
							
							for(int recCount=2,k = 0; recCount<result.size(); recCount++,k++)
							{  // for for records
								cnt ++;
								classvalue = (recCount % 2 == 0)?"QRYEVEN":"QRYODD";
								//String link_columns = "1";
								records=(ArrayList) result.get(recCount);
								

				%>
							<tr>
				
				
			
				<%
							curr_item_store=(String)records.get(0);
							if(!curr_item_store.equals(prev_item_store))
							{
								flag=true;
								if(cost_value_sub_total>=0 && subtotal >= 0 && !curr_item_store.equals(prev_item_store) && cnt > 3)
								{	// if loop sub total
								if(view_cost_details_yn.equals("Y")){
					
								%>
								<tr>
								<td colspan=<%=headercpls%> align='left' class='ITEMSELECT' width="60%"><font size=1><b><fmt:message key="eST.StoreSubTotal.label" bundle="${st_labels}"/> : </b> 
								</td>
								<td  colspan=1 style="TEXT-ALIGN:right"  class='ITEMSELECT'	><font size=1><B><%=nf.format(Double.parseDouble(bean.setNumber(""+cost_value_sub_total,noOfDecimalsForCost)))%></B></font>&nbsp;</td>
								
								<td  colspan=1 style="TEXT-ALIGN:right"  class='ITEMSELECT'	><font size=1><B><%=nf.format(Double.parseDouble(bean.setNumber(""+subtotal,noOfDecimalsForCost)))%></B></font>&nbsp;</td>
									<td colspan=2 align='left'  class='ITEMSELECT'> </td>
									<td colspan=2 align='left'  class='ITEMSELECT'> </td>
								</tr>
								<% 
								}
									subtotal=0.0f;
									cost_value_sub_total=0.0f;
									 // if loop sub total
								%>	

				
								
								<%
								
								}	// if loop 
								else if(cost_value_sub_total>=0 && subtotal >= 0 && flag==false && store_compare.equals(store_code)) 
									{
									pre_subtotal +=subtotal;
									pre_cost_value_sub_total+=cost_value_sub_total;
									if(view_cost_details_yn.equals("Y")){
									%>
									<tr>
									<td colspan=9  class='ITEMSELECT' width="60%"><font size=1><b><fmt:message key="eST.StoreSubTotal.label" bundle="${st_labels}"/> : </b> 
									</td>
									<td  colspan=1 style="TEXT-ALIGN:right" class='ITEMSELECT'	><font size=1><B><%=nf.format(Double.parseDouble(bean.setNumber(""+pre_cost_value_sub_total,noOfDecimalsForCost)))%></B></font>&nbsp;</td>
									<td  colspan=1 style="TEXT-ALIGN:right" class='ITEMSELECT'	><font size=1><B><%=nf.format(Double.parseDouble(bean.setNumber(""+pre_subtotal,noOfDecimalsForCost)))%></B></font>&nbsp;</td>
									
									<td colspan=2 align='left'  class='ITEMSELECT'> </td>
								</tr>
							

								<%
									}
								} 
								%>
								
					
									<%
										store_code=CommonBean.checkForNull((String)records.get(0),"");
								//}
								%>

									<tr>
									<td colspan=13 align='left' class='ITEMSELECT'><font size=1><b><fmt:message key="Common.Store.label" bundle="${common_labels}"/>:</b> 
									<%=CommonBean.checkForNull((String)records.get(0),"")%>&nbsp;</td>
									<td colspan=2 align='left'  class='ITEMSELECT'> </td>
								</tr>
						<%
							}

				String str_sales_type = CommonBean.checkForNull((String)records.get(12));
				if(str_sales_type.equals("I") && (CommonBean.checkForNull((String)records.get(13)).equals("Y"))){
					 str_sales_type = "H";
				}
								%>

				<tr id="tr_<%=k%>">
	
	<td class="<%=classvalue%>" align="left" ><font size=1><%=(String)records.get(1)%></font></td>
	<td class="<%=classvalue%>" align="left" style='WORD-BREAK:BREAK-ALL;'><font size=1><%=CommonBean.checkForNull((String)records.get(2),"&nbsp;")%></font></td>
	<td class="<%=classvalue%>" align="left" style='WORD-BREAK:BREAK-ALL;'><font size=1><%=CommonBean.checkForNull((String)records.get(3),"0")%></font></td>
	<td class="<%=classvalue%>" align="left" ><font size=1><%=hshSalesType.get(str_sales_type)%></font></td>
	<td class="<%=classvalue%>" align="right" ><font size=1><%=CommonBean.checkForNull((String)records.get(4),"0")%></font></td>
	
	<td class="<%=classvalue%>" align="center" ><font size=1><%=DateUtils.convertDate(CommonBean.checkForNull((String)records.get(5),"0"),"DMY","en",locale)%></font></td>
	 <!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Sale Quantity,CostValue,SaleValue,Sub Total, Grand Total.				
					-->
		<%if((bean.getCustomerID()).equals("MC")){%>
	<td class="<%=classvalue%>"  style="TEXT-ALIGN:right"><font 
	size=1><%=bean.setNumberFormat(bean.checkForNull((String)records.get(14),"0"),no_of_decimals)%></font>&nbsp;</td>
	<%}%>
	<td class="<%=classvalue%>"  style="TEXT-ALIGN:right"><font 
	size=1><%=bean.setNumberFormat(bean.checkForNull((String)records.get(6),"0"),no_of_decimals)%></font>&nbsp;</td>
		<%if((bean.getCustomerID()).equals("MC")){%>
	<td class="<%=classvalue%>"  style="TEXT-ALIGN:right"><font 
	size=1><%=bean.setNumberFormat(bean.checkForNull((String)records.get(15),"0"),no_of_decimals)%></font>&nbsp;</td>
	<%}%>
	
	<%
		String cost_value_1=CommonBean.checkForNull((String)records.get(8),"0");
		subtotal = subtotal + Double.parseDouble(cost_value_1);

		//cost_value_sub_total =cost_value_sub_total+	Double.parseDouble(CommonBean.checkForNull((String)records.get(7),"0"));
		cost_value_sub_total =cost_value_sub_total+	Double.parseDouble(CommonBean.checkForNull((String)records.get(19),"0"));
		%>

<%if(view_cost_details_yn.equals("Y")){%>

	<!-- <td class="<%=classvalue%>"  style="TEXT-ALIGN:right"><font size=1><%=bean.setNumberFormat(CommonBean.checkForNull((String)records.get(7),"0"),noOfDecimalsForCost)%></font>&nbsp;</td> -->
	<td class="<%=classvalue%>"  style="TEXT-ALIGN:right"><font size=1><%=bean.setNumberFormat(CommonBean.checkForNull((String)records.get(19),"0"),noOfDecimalsForCost)%></font>&nbsp;</td>
	
	
	<td class="<%=classvalue%>"  style="TEXT-ALIGN:right"><font size=1><%=bean.setNumberFormat(CommonBean.checkForNull((String)records.get(8),"0"),noOfDecimalsForCost)%></font>&nbsp;</td> 
<%}%>	
	<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)records.get(9),"0")%></font></td>

	<% if(str_sales_type.equals("X")) {%>
	<td class="<%=classvalue%>" style='WORD-BREAK:BREAK-ALL;'><font size=1><%=CommonBean.checkForNull((String)records.get(18),"0")%></font></td>
	<%
		}
	else
	{%>
	<td class="<%=classvalue%>" style='WORD-BREAK:BREAK-ALL;'><font size=1><%=CommonBean.checkForNull((String)records.get(10),"0")%></font></td>
	<%}%>

	<td class="<%=classvalue%>"><font size=1><%=(String)records.get(16)%></font></td>
	<td class="<%=classvalue%>"><font size=1><%=com.ehis.util.DateUtils.convertDate((String)records.get(17),"DMYHMS","en",locale)%></font></td>

	<td class='NODISPLAY'><%=records.get(11)%></td>	
	
			
		<%
			
			prev_item_store=curr_item_store;
			}	// for loop for records
grand_tot = grand_tot + subtotal;
		}		// main if loop
		else{
			
		//	 no_record=true;
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/html/blank.html";
			</script>
		<%
		
		}
				if(view_cost_details_yn.equals("Y")){

						if(cnt == result.size() && subtotal >= 0 && cost_value_sub_total>=0)
						
						{
							%>

								<tr>
								
								<td colspan=<%=headercpls%>   class='ITEMSELECT'><font size=1 width="60%"><b><fmt:message key="eST.StoreSubTotal.label" bundle="${st_labels}"/> : </b> 
								</td>
								
								<td  colspan=1 style="TEXT-ALIGN:right" class='ITEMSELECT'	><font size=1><B><%=nf.format(Double.parseDouble(bean.setNumber(""+cost_value_sub_total,noOfDecimalsForCost)))%></B></font>&nbsp;</td>
								<td  colspan=1 style="TEXT-ALIGN:right" class='ITEMSELECT'	><font size=1><B><%=nf.format(Double.parseDouble(bean.setNumber(""+subtotal,noOfDecimalsForCost)))%></B></font>&nbsp;</td>
								
								<td colspan=2 align='left'  class='ITEMSELECT'> </td>
								<td colspan=2 align='left'  class='ITEMSELECT'> </td>
								</tr>
							


							<%
							}
				}
//		if(no_record==false && (count==false) )
		if(view_cost_details_yn.equals("Y")){
		if((grandnextcnt == -1  && grandpreviouscnt > 0 && (result.size() == cnt )) || (strGrandTotFlag.equals("Y")) )
		//if((result.size() == cnt ) )
		{
		%>
		<%



		ArrayList  result2=new ArrayList(); 
				
			//result2=bean.queryResultDetails(facility_id,store_code2,item_code2,sal_trn_type2,patient_id2, from_date2 , to_date2,encounter_id2);
			  /* @Name - Priya
			 * @Date - 07/07/2010
			 * @Inc# - 21346 (AK-CRF-0018)
			 * @Desc - Two parameters have been added to the function 'queryResultDetails' in SalesHistoryBean 
			*/
			result2=bean.queryResultDetails(facility_id,store_code2,item_code2,sal_trn_type2,patient_id2, from_date2 , to_date2,encounter_id2,sal_doc_type2,doc_no2);
		//CommonBean.clear( );
		
	
		if((result2.size()>0) )
			{			// record if loop

				
						HashMap records2=new HashMap();
						for(int recCount=0; recCount<result2.size(); recCount++)
						{			// record for loop

							records2=(HashMap)result2.get(recCount);
				%>

			
			<tr> </tr>
			<tr>
				
				<td  colspan=<%=headercpls%>  align='left' class='ITEMSELECT'><font size=1><b><fmt:message key="Common.GrandTotal.label" bundle="${common_labels}"/> : </b></td> 
				
					<%
			
						String grandt=CommonBean.checkForNull((String)records2.get("grand_tot"),"0");
						String cost_grand_tot = CommonBean.checkForNull((String)records2.get("cost_grand_tot"),"0");
						%>
				<td colspan=1 style="TEXT-ALIGN:right" class='ITEMSELECT'><font size=1><B><%=bean.setNumberFormat(cost_grand_tot,noOfDecimalsForCost)%></B></font>&nbsp;</td>
				<td colspan=1 style="TEXT-ALIGN:right" class='ITEMSELECT'><font size=1><B><%=bean.setNumberFormat(grandt,noOfDecimalsForCost)%></B></font>&nbsp;</td>
								
				<td colspan=2 align='left' class='ITEMSELECT'>&nbsp;&nbsp;</td>
				<td colspan=2 align='left'  class='ITEMSELECT'> </td>
				
		
			</tr>
					<%
						}	// record for loop
			}		// result for loop
		
		}		// if loop for grand total ends
		}
		out.println(" </table>");
		out.println("	</form>");
		out.flush();
		
		out.println(CommonBean.setForm (request ,"../../eST/jsp/SalesHistoryQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>

</form>		
<%
putObjectInBean(bean_id,bean,request);
%>
</body>

<!-- <script>activeLink();</script> -->
</html>



