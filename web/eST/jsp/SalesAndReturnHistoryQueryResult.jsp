<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
03/05/2016		IN0057816			B.Badmavathi					           AAKH-SCF-0220
19/04/2021      TFS id:-16213       Haribabu 							        AMS-SCF-0970
05/07/2021		TFS id:-19018       Prabha	  16/06/2021	   Manicakavasagam	AMS-CRF-0258
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="eST.SalesAndReturnHistoryBean,java.util.*,com.ehis.util.*,java.text.NumberFormat,java.lang.*,java.io.*,java.sql.*,eST.Common.*,eCommon.Common.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>   

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
		<script language="Javascript" src="../../eST/js/SalesAndReturnHistory.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement()" onKeyDown = 'lockKey()'>
<form name="formSalesAndReturnHistoryResult" id="formSalesAndReturnHistoryResult">
<%

	String bean_id				=		"SalesAndReturnHistoryBean";
	String bean_name			=		"eST.SalesAndReturnHistoryBean";
	SalesAndReturnHistoryBean bean		=		(SalesAndReturnHistoryBean) getBeanObject(bean_id, bean_name,request  );  
	bean.clear();
	String store_code			=		request.getParameter( "p_fr_st_code")==null?"":request.getParameter( "p_fr_st_code") ;
	String from_date			=		request.getParameter( "from_date")==null?"":request.getParameter( "from_date") ;
	from_date					=		DateUtils.convertDate(from_date,"DMY",locale,"en");
	String to_date				=		request.getParameter( "to_date")==null?"":request.getParameter( "to_date") ;
	to_date						=		DateUtils.convertDate(to_date,"DMY",locale,"en");
	String item_code			=		request.getParameter( "item_code" )==null?"":request.getParameter( "item_code" ) ;
	String patient_id			=		request.getParameter( "patient_id" )==null?"":request.getParameter( "patient_id" ) ;
	String encounter_id		    =		request.getParameter( "encounter_id" )==null?"":request.getParameter( "encounter_id" ) ;
	String trn_type			    =		request.getParameter( "trn_type" )==null?"":request.getParameter( "trn_type" ) ;
	String sal_trn_type			=		request.getParameter( "sal_trn_type" )==null?"":request.getParameter( "sal_trn_type" ) ;
	//System.out.println("sal_trn_typesal_trn_type" +sal_trn_type);
	String classvalue			=		"";
	String facility_id			=		(String) session.getValue( "facility_id" ) ;
	double  subtotal			=		0.0;
	double  pre_subtotal		=		0.0;
	boolean flag				=		true;
	boolean searched			=		(request.getParameter("searched") == null) ?false:true;
	String grand_total			=		request.getParameter( "grand_total" )==null?"0":request.getParameter( "grand_total" ) ;
	String store_compare		=		request.getParameter( "store_compare" )==null?"0":request.getParameter( "store_compare" ) ;
	double grand_tot			=		Double.parseDouble(grand_total);
	double cost_value_sub_total     =   0.0;
	double pre_cost_value_sub_total =   0.0;
	int headercpls=7;
	
	patient_id = patient_id.toUpperCase();
	System.out.println("patient_id" + patient_id);
	
	int no_of_decimals  = bean.getNoOfDecimals();	
	String language_id  = bean.getLanguageId();	
	
	String view_cost_details_yn = (String)bean.getAccessCostDetails();
	int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());
	 nf.setMaximumFractionDigits(noOfDecimalsForCost);
	 nf.setMinimumFractionDigits(noOfDecimalsForCost);
	 String sal_doc_type	=		request.getParameter( "sal_doc_type" )==null?"":request.getParameter( "sal_doc_type" ) ;
	 String doc_no			=		request.getParameter( "doc_no" )==null?"":request.getParameter( "doc_no" ) ;

	 /*GHL-CRF-0557.1 start*/
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
		/*GHL-CRF-0557.1 end*/
	 
if(trn_type.equals("SAL")) {
	try{
	
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			//store_code			=		CommonBean.checkForNull(store_code)+"%";
			store_code			=		CommonBean.checkForNull(store_code,"");
			//item_code			=		CommonBean.checkForNull(item_code)+"%";
			item_code			=		CommonBean.checkForNull(item_code,"");
			from_date			=		CommonBean.checkForNull(from_date,"");
			to_date				=		CommonBean.checkForNull(to_date,"");
			patient_id			=		CommonBean.checkForNull(patient_id);
			//encounter_id		=		CommonBean.checkForNull(encounter_id)+"%";
			encounter_id		=		CommonBean.checkForNull(encounter_id,"");
			sal_trn_type		=		CommonBean.checkForNull(sal_trn_type,"%");
			//sal_doc_type		=		CommonBean.checkForNull(sal_doc_type,"%");  
			//doc_no				=		CommonBean.checkForNull(doc_no,"%");  
			sal_doc_type		=		CommonBean.checkForNull(sal_doc_type,"");  
			doc_no				=		CommonBean.checkForNull(doc_no,"");  

			String store_code2	=		CommonBean.checkForNull(store_code,"");
			String item_code2	=		CommonBean.checkForNull(item_code,"");
			String from_date2	=		CommonBean.checkForNull(from_date,"");
			String to_date2		=		CommonBean.checkForNull(to_date,"");
			String patient_id2	=		CommonBean.checkForNull(patient_id);
			String encounter_id2=		CommonBean.checkForNull(encounter_id,"");
			String sal_trn_type2=		CommonBean.checkForNull(sal_trn_type,"%");  
			 
			String  sal_doc_type2 = CommonBean.checkForNull(sal_doc_type,"");  
			String doc_no2 = CommonBean.checkForNull(doc_no,"");  

			String strGrandTotFlag ="";

			System.out.println("patient_id" + patient_id + "" + patient_id2);
			
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

							
				//sqlMap.put("sqlData","SELECT DISTINCT a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,d.short_desc store_desc, b.item_code, e.short_desc item_desc, a.patient_id, f.patient_name,a.locn_code,i.short_desc,a.added_by_id,(CASE WHEN a.sal_trn_type = 'X' THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END) patient_name1 , b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT sum(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND g.primary_key_main = b.doc_type_code || '-' || b.doc_no) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty FROM st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f,IP_NURSING_UNIT_LANG_VW i WHERE a.facility_id = b.facility_id AND a.added_by_id = b.added_by_id AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND a.store_code LIKE UPPER (?) AND b.item_code LIKE UPPER (?) AND a.sal_trn_type LIKE ?  AND a.patient_id LIKE UPPER (?) AND a.locn_code = i.nursing_unit_code AND i.language_id='en' AND (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND TO_CHAR (NVL (a.encounter_id, '0')) LIKE ? AND a.finalized_yn = 'Y' AND a.doc_type_code LIKE ? AND a.doc_no LIKE ? ORDER BY a.store_code,a.doc_no,to_date(doc_date,'dd/mm/yyyy') ");
                  
				  //commented by Rabbani #Inc no:36887 on  20/12/2012
				 // sqlMap.put("sqlData","SELECT DISTINCT a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,d.short_desc store_desc, b.item_code, e.short_desc item_desc, a.patient_id, f.patient_name,a.locn_code,decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw  where  nursing_unit_code =  a.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ? and language_id= ?),'' )short_desc,a.added_by_id,(CASE WHEN a.sal_trn_type = 'X' THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END) patient_name1 , b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT sum(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND g.primary_key_main = b.doc_type_code || '-' || b.doc_no) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty FROM st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND a.store_code LIKE UPPER (?) AND b.item_code LIKE UPPER (?) AND a.sal_trn_type LIKE ?  AND a.patient_id = ? AND (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND TO_CHAR (NVL (a.encounter_id, '0')) LIKE ? AND a.finalized_yn = 'Y' AND a.doc_type_code LIKE ? AND a.doc_no LIKE ? ORDER BY a.store_code,a.doc_no,to_date(doc_date,'dd/mm/yyyy') ");
				 
				 //Added by Rabbani #Inc no:36887 on  20/12/2012
				//String sql =  "SELECT DISTINCT a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,d.short_desc store_desc, b.item_code, e.short_desc item_desc, a.patient_id, f.patient_name,a.locn_code,decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw  where  nursing_unit_code =  a.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ? and language_id= ?),'' )short_desc,a.added_by_id,(CASE WHEN a.sal_trn_type = 'X' THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END) patient_name1 , b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT sum(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND g.primary_key_main = b.doc_type_code || '-' || b.doc_no and h.patient_id = g.patient_id and h.patient_id=a.patient_id  and g.serv_item_code=b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty FROM st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) )   AND a.finalized_yn = 'Y' ";

				//Modified by Sakti against MMS-SCF-0337 inc#48949 Cost Value increase
				//String sql =  "SELECT DISTINCT a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,d.short_desc store_desc, b.item_code, e.short_desc item_desc, a.patient_id, f.patient_name,a.locn_code,decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw  where  nursing_unit_code =  a.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ? and language_id= ?),'' )short_desc,a.added_by_id,(CASE WHEN a.sal_trn_type = 'X' THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END) patient_name1 , b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT sum(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND g.primary_key_main = b.doc_type_code || '-' || b.doc_no and h.patient_id = g.patient_id and h.patient_id=a.patient_id  and g.serv_item_code=b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND(((  b.item_qty * (SELECT ROUND (AVG (curr_unit_cost), 3)  FROM st_item_unit_cost_history  WHERE trn_type IN ('OBS', 'GRN')  AND item_code = b.item_code and changed_Date <= a.doc_Date)) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty FROM st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) )   AND a.finalized_yn = 'Y' ";
				//Modified by Suresh.r against TTM-SCF-0108 inc#50303 Unit_cost,sale_value logic changed.
				//String sql =  "SELECT DISTINCT a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,d.short_desc store_desc, b.item_code, e.short_desc item_desc, a.patient_id, f.patient_name,a.locn_code,decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw  where  nursing_unit_code =  a.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ? and language_id= ?),'' )short_desc,a.added_by_id,(CASE WHEN a.sal_trn_type = 'X' THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END) patient_name1 , b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN st_display_sale_value(a.facility_id,b.doc_type_code,b.doc_no,a.patient_id,b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND(((  b.item_qty * (st_display_unit_cost(b.item_code,trunc(a.doc_date)))) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty FROM st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) )   AND a.finalized_yn = 'Y' ";
				//Modified by suresh.r on 03-11-2014 against Inc 52256(unitcost fun passed modified_date)
				
				/*GHL-CRF-0557.1 start*/
				String sql = "";
				if(site){
					 sql =  "SELECT DISTINCT a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,b.doc_srl_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,d.short_desc store_desc, b.item_code, e.short_desc item_desc, a.patient_id, f.patient_name,a.locn_code,decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw  where  nursing_unit_code =  a.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ? and language_id= ?),'' )short_desc,a.added_by_id,(CASE WHEN a.sal_trn_type = 'X' THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END) patient_name1 , b.item_qty sale_qty, ST_DISPLAY_SALE_ITEM_VALUE(a.facility_id,b.doc_type_code,b.doc_no,b.doc_srl_no,a.patient_id,b.item_code)  gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND(((  b.item_qty * (st_display_unit_cost(b.item_code,a.modified_date))) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty FROM st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) )   AND a.finalized_yn = 'Y' "; //Modified for AMS-SCF-0970
				}
				else{
					 sql =  "SELECT DISTINCT a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,b.doc_srl_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,d.short_desc store_desc, b.item_code, e.short_desc item_desc, a.patient_id, f.patient_name,a.locn_code,decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw  where  nursing_unit_code =  a.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ? and language_id= ?),'' )short_desc,a.added_by_id,(CASE WHEN a.sal_trn_type = 'X' THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END) patient_name1 , b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN ST_DISPLAY_SALE_ITEM_VALUE(a.facility_id,b.doc_type_code,b.doc_no,b.doc_srl_no,a.patient_id,b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND(((  b.item_qty * (st_display_unit_cost(b.item_code,a.modified_date))) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty FROM st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) )   AND a.finalized_yn = 'Y' "; //Modified for AMS-SCF-0970
				}
				/*GHL-CRF-0557.1 end*/ 

				displayFields.add("store_desc"); 
				displayFields.add("item_code");	
				displayFields.add("item_desc");	
				displayFields.add("doc_type_desc");
				displayFields.add("doc_no");
				displayFields.add("doc_date");
				displayFields.add("sale_qty");
				displayFields.add("item_cost_value");
				displayFields.add("gross_charge_amt");
				displayFields.add("patient_id");
				displayFields.add("patient_name");
				displayFields.add("store_code");
				displayFields.add("sal_trn_type");
				displayFields.add("take_home_yn");
				displayFields.add("short_desc");
				displayFields.add("added_by_id");
				displayFields.add("patient_name1");
				displayFields.add("item_cost_value_new");//Added by Sakti against MMS-SCF-0337 inc#48949 Cost Value increase

				chkFields.add(facility_id);
				chkFields.add(language_id);
				chkFields.add(facility_id);
				chkFields.add(language_id);
				chkFields.add(facility_id);
				chkFields.add(language_id);
				chkFields.add(facility_id);
				chkFields.add(language_id);

				chkFields.add(facility_id);
				chkFields.add(from_date);
				chkFields.add(to_date);
				
				//chkFields.add(store_code);
				//chkFields.add(item_code);
				//chkFields.add(sal_trn_type);
				//chkFields.add(patient_id);
				
				//chkFields.add(encounter_id);
				//chkFields.add(sal_doc_type);
				//chkFields.add(doc_no);
			//Added by Rabbani #Inc no:36887 on  20/12/2012 Starts
			if(!(store_code.equals(""))	){
			sql = sql + " and a.store_code = ? " ;
			chkFields.add(store_code);
			}	
			if(!(item_code.equals(""))	){
			sql = sql + " and b.item_code = ?  "  ;
			chkFields.add(item_code);
			}
			if(!(sal_trn_type.equals("%"))	){
			sql = sql + " and a.sal_trn_type = ? " ;
			chkFields.add(sal_trn_type);
			}
			if(!(patient_id.equals(""))	){
			sql = sql + " and a.patient_id = ? " ;
			chkFields.add(patient_id);
			}
			if(!(encounter_id.equals(""))	){
			sql = sql + " and a.encounter_id = ? "  ;
			chkFields.add(encounter_id);
			}
			if(!(sal_doc_type.equals(""))){
			sql = sql + " and a.doc_type_code = ? " ;
			chkFields.add(sal_doc_type);
			}
			if(!(doc_no.equals(""))	){
			sql = sql + " and a.doc_no = ? " ;
			chkFields.add(doc_no);
			}
			//Added for AMS-CRF-0258
			if(!(sal_trn_type_query.equals(""))	){
			sql = sql + sal_trn_type_query ;
			}
			//Added for AMS-CRF-0258			
			sql = sql + " ORDER BY a.store_code,a.doc_no,to_date(doc_date,'dd/mm/yyyy')" ;

                //System.out.println("sql==>"+sql);
				//System.out.println("chkFieldschkFields=sales=>"+chkFields);
				sqlMap.put("sqlData",sql);
		//ends
				funcMap.put("displayFields", displayFields);
				funcMap.put("chkFields", chkFields);
				
				ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
				//System.out.println("result==>"+result);
				int cnt=2;
				String no_records="";
						int grandpreviouscnt=0;
						int grandnextcnt=0;
						int int_grandpreviouscnt=0;
						int int_grandnextcnt=0;
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0"))))
			{	
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
						//System.out.println("int_grandpreviouscnt==>"+int_grandpreviouscnt);
						grandpreviouscnt		=		int_grandpreviouscnt;
						int_grandnextcnt		=		no_records.indexOf('N');
						//System.out.println("int_grandnextcnt==>"+int_grandnextcnt);
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
					<th><fmt:message key="Common.SaleQuantity.label" bundle="${common_labels}"/></th>
					
			<%if(view_cost_details_yn.equals("Y")){%>
					<th><fmt:message key="eST.CostValue.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="eST.SaleValue.label" bundle="${st_labels}"/></th>
			<%}%>	
					<th nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.name.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eST.nursingunit/clinic.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="Common.Createdby.label" bundle="${common_labels}"/></th>
				</tr>
						<%
							ArrayList records=new ArrayList();
							
							for(int recCount=2,k = 0; recCount<result.size(); recCount++,k++)
							{  
								cnt ++;
								classvalue = (recCount % 2 == 0)?"QRYEVEN":"QRYODD";
								records=(ArrayList) result.get(recCount);
						%>
							<tr>
						<%
							curr_item_store=(String)records.get(0);
							//System.out.println("curr_item_store==>"+curr_item_store);
							if(!curr_item_store.equals(prev_item_store))
							{
								flag=true;
								if(cost_value_sub_total>=0 && subtotal >= 0 && !curr_item_store.equals(prev_item_store) && cnt > 3)
								{
								if(view_cost_details_yn.equals("Y")){
						%>
								<tr>
								<td colspan=7 align='left' class='ITEMSELECT' width="60%"><font size=1><b><fmt:message key="eST.StoreSubTotal.label" bundle="${st_labels}"/> : </b> 
								</td>
								<td  colspan=1 style="TEXT-ALIGN:right"  class='ITEMSELECT'	><font size=1><B><%=nf.format(Double.parseDouble(bean.setNumber(""+cost_value_sub_total,noOfDecimalsForCost)))%></B></font>&nbsp;</td>
								
								<td  colspan=1 style="TEXT-ALIGN:right"  class='ITEMSELECT'	><font size=1><B><%=nf.format(Double.parseDouble(bean.setNumber(""+subtotal,noOfDecimalsForCost)))%></B></font>&nbsp;</td>
									<td colspan=2 align='left'  class='ITEMSELECT'> </td>
									<td colspan=2 align='left'  class='ITEMSELECT'> </td>
								</tr>
								<%}
									subtotal=0.0f;
									cost_value_sub_total=0.0f;									
								%>	

								<%}
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
							
								<%}
								}%>
									<%
										store_code=CommonBean.checkForNull((String)records.get(0),"");
									%>

									<tr>
									<td colspan=13 align='left' class='ITEMSELECT'><font size=1><b><fmt:message key="Common.Store.label" bundle="${st_labels}"/>:</b> 
									<%=CommonBean.checkForNull((String)records.get(0),"")%>&nbsp;</td>
				
								</tr>
						<%}

				String str_sales_type = CommonBean.checkForNull((String)records.get(12));
				if(str_sales_type.equals("I") && (CommonBean.checkForNull((String)records.get(13)).equals("Y"))){
					 str_sales_type = "H";
				}%>

				<tr id="tr_<%=k%>">
	
	<td class="<%=classvalue%>" align="left" ><font size=1><%=(String)records.get(1)%></font></td>
	<td class="<%=classvalue%>" align="left" style='WORD-BREAK:BREAK-ALL;'><font size=1><%=CommonBean.checkForNull((String)records.get(2),"&nbsp;")%></font></td>
	<td class="<%=classvalue%>" align="left" style='WORD-BREAK:BREAK-ALL;'><font size=1><%=CommonBean.checkForNull((String)records.get(3),"0")%></font></td>
	<td class="<%=classvalue%>" align="left" ><font size=1><%=hshSalesType.get(str_sales_type)%></font></td>
	<td class="<%=classvalue%>" align="right" ><font size=1><%=CommonBean.checkForNull((String)records.get(4),"0")%></font></td>
	<td class="<%=classvalue%>" align="center" ><font size=1><%=DateUtils.convertDate(CommonBean.checkForNull((String)records.get(5),"0"),"DMY","en",locale)%></font></td>
	<td class="<%=classvalue%>"  style="TEXT-ALIGN:right"><font 
	size=1><%=bean.setNumberFormat(bean.checkForNull((String)records.get(6),"0"),no_of_decimals)%></font>&nbsp;</td>
	<%
		String cost_value_1=CommonBean.checkForNull((String)records.get(8),"0");
		subtotal = subtotal + Double.parseDouble(cost_value_1);
		//cost_value_sub_total =cost_value_sub_total+	Double.parseDouble(CommonBean.checkForNull((String)records.get(7),"0"));
		cost_value_sub_total =cost_value_sub_total+	Double.parseDouble(CommonBean.checkForNull((String)records.get(17),"0"));
	%>

<%if(view_cost_details_yn.equals("Y"))  {%>

	<!-- <td class="<%=classvalue%>"  style="TEXT-ALIGN:right"><font size=1><%=bean.setNumberFormat(CommonBean.checkForNull((String)records.get(7),"0"),noOfDecimalsForCost)%></font>&nbsp;</td> -->
	<td class="<%=classvalue%>"  style="TEXT-ALIGN:right"><font size=1><%=bean.setNumberFormat(CommonBean.checkForNull((String)records.get(17),"0"),noOfDecimalsForCost)%></font>&nbsp;</td>

	<td class="<%=classvalue%>"  style="TEXT-ALIGN:right"><font size=1><%=bean.setNumberFormat(CommonBean.checkForNull((String)records.get(8),"0"),noOfDecimalsForCost)%></font>&nbsp;</td> 
<%}%>	
	<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)records.get(9),"0")%></font></td>
	<% if(str_sales_type.equals("X")) {%>
	<td class="<%=classvalue%>" style='WORD-BREAK:BREAK-ALL;'><font size=1><%=CommonBean.checkForNull((String)records.get(16),"0")%></font></td>
	<%}
	else
	{%>
	<td class="<%=classvalue%>" style='WORD-BREAK:BREAK-ALL;'><font size=1><%=CommonBean.checkForNull((String)records.get(10),"0")%></font></td>
	<%}%>	
	<td class="<%=classvalue%>"  style='WORD-BREAK:BREAK-ALL;'><font size=1><%=CommonBean.checkForNull((String)records.get(14),"")%></font>&nbsp;</td>
	<td class="<%=classvalue%>"  style='WORD-BREAK:BREAK-ALL;'><font size=1><%=CommonBean.checkForNull((String)records.get(15),"")%></font>&nbsp;</td>
	<td class='NODISPLAY'><%=records.get(11)%></td>		
	<%
		prev_item_store=curr_item_store;
	//System.out.println("prev_item_store==>"+prev_item_store);
			}	
			grand_tot = grand_tot + subtotal;
		}		
		else{	%>
		
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/html/blank.html";
			</script>
			<%}
				if(view_cost_details_yn.equals("Y")){

						if(cnt == result.size() && subtotal >= 0 && cost_value_sub_total>=0)
						{%>
							<tr>
								
								<td colspan=7   class='ITEMSELECT'><font size=1 width="60%"><b><fmt:message key="eST.StoreSubTotal.label" bundle="${st_labels}"/> : </b> </td>								
								<td  colspan=1 style="TEXT-ALIGN:right" class='ITEMSELECT'	><font size=1><B><%=nf.format(Double.parseDouble(bean.setNumber(""+cost_value_sub_total,noOfDecimalsForCost)))%></B></font>&nbsp;</td>
								<td  colspan=1 style="TEXT-ALIGN:right" class='ITEMSELECT'	><font size=1><B><%=nf.format(Double.parseDouble(bean.setNumber(""+subtotal,noOfDecimalsForCost)))%></B></font>&nbsp;</td>
								<td colspan=2 align='left'  class='ITEMSELECT'> </td>
								<td colspan=2 align='left'  class='ITEMSELECT'> </td>
								</tr>
							


							<%}
				}
		if(view_cost_details_yn.equals("Y")){
		if((grandnextcnt == -1  && grandpreviouscnt > 0 && (result.size() == cnt )) || (strGrandTotFlag.equals("Y")) )
		{%>
		<%  ArrayList  result2=new ArrayList(); 
			result2=bean.queryResultDetails(facility_id,store_code2,item_code2,sal_trn_type2,patient_id2, from_date2 , to_date2,encounter_id2,sal_doc_type2,doc_no2);
		//System.out.println("result2==>"+result2);		
		if((result2.size()>0) )
			{	
						HashMap records2=new HashMap();
						for(int recCount=0; recCount<result2.size(); recCount++)
						{			

							records2=(HashMap)result2.get(recCount);
				%>
			<tr> </tr>
			<tr>
				
				<td  colspan=7  align='left' class='ITEMSELECT'><font size=1><b><fmt:message key="Common.GrandTotal.label" bundle="${mm_labels}"/> : </b></td> 
				
				<%			
				String grandt=CommonBean.checkForNull((String)records2.get("grand_tot"),"0");
				String cost_grand_tot = CommonBean.checkForNull((String)records2.get("cost_grand_tot"),"0");
				%>
				<td colspan=1 style="TEXT-ALIGN:right" class='ITEMSELECT'><font size=1><B><%=bean.setNumberFormat(cost_grand_tot,noOfDecimalsForCost)%></B></font>&nbsp;</td>
				<td colspan=1 style="TEXT-ALIGN:right" class='ITEMSELECT'><font size=1><B><%=bean.setNumberFormat(grandt,noOfDecimalsForCost)%></B></font>&nbsp;</td>
				<td colspan=2 align='left' class='ITEMSELECT'>&nbsp;&nbsp;</td>
				<td colspan=2 align='left'  class='ITEMSELECT'> </td>
			</tr>
					<%}	
			}		
		
		}		
	}
		out.println(" </table>");
		out.println("	</form>");
		out.flush();
		
		out.println(CommonBean.setForm (request ,"../../eST/jsp/SalesAndReturnHistoryQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
}

else if(trn_type.equals("SRT")) {

	try{

			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			store_code			=		CommonBean.checkForNull(store_code,"");
			item_code			=		CommonBean.checkForNull(item_code,"");
			from_date			=		CommonBean.checkForNull(from_date,"");
			to_date				=		CommonBean.checkForNull(to_date,"");
			patient_id			=		CommonBean.checkForNull(patient_id);
			encounter_id		=		CommonBean.checkForNull(encounter_id,"");
		 
			sal_trn_type		=		CommonBean.checkForNull(sal_trn_type,"%");
			sal_doc_type		=		CommonBean.checkForNull(sal_doc_type,"");  
			doc_no				=		CommonBean.checkForNull(doc_no,"");
		
			String store_code3	=		CommonBean.checkForNull(store_code,"");
			String item_code3	=		CommonBean.checkForNull(item_code,"");
			String from_date3	=		CommonBean.checkForNull(from_date,"");
			String to_date3		=		CommonBean.checkForNull(to_date,"");
			String patient_id3	=		CommonBean.checkForNull(patient_id);
			String encounter_id3=		CommonBean.checkForNull(encounter_id,"");
			String sal_trn_type3=		CommonBean.checkForNull(sal_trn_type,"%");  
			 
			String  sal_doc_type3 = CommonBean.checkForNull(sal_doc_type,"");  
			String doc_no3 = CommonBean.checkForNull(doc_no,"");  
			String strGrandTotFlag1 ="";
			
				HashMap sqlMap			=		new HashMap();
				HashMap funcMap			=		new HashMap();
				ArrayList displayFields =		new ArrayList();
				ArrayList chkFields		=		new ArrayList();
				String curr_item_store1	=		"";
				String prev_item_store1	=		"";
				
				//Added for AMS-CRF-0258
				String sal_trn_type_query="";
				if(sal_trn_type.equals("I")){
					  sal_trn_type_query = "and p.take_home_yn ='N'";
				 }else if(sal_trn_type.equals("H")){
					  sal_trn_type_query = "and p.take_home_yn ='Y'";
					  sal_trn_type = "I";
				 }
				//Added for AMS-CRF-0258
				
				//sqlMap.put ("sqlData","SELECT  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,  b.item_qty ret_qty,a.added_by_id, n.locn_code, p.short_desc  , a.sales_doc_no, (CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT SUM(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND  g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND  g.primary_key_main = b.doc_type_code || '-' || b.doc_no) END ) gross_charge_amt, ROUND (NVL (b.item_cost_value, 0), 2)  item_cost_value, a.sal_trn_type,NVL (b.item_qty, 0) sale_req_qty ,0  pen_sal_req_qty  FROM   st_sal_ret_hdr a, st_sal_ret_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, ST_SAL_HDR n , IP_NURSING_UNIT_LANG_VW p WHERE a.facility_id = b.facility_id AND a.added_by_id = b.added_by_id AND a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no AND a.sales_doc_no = n.doc_no  AND a.patient_id = n.patient_id AND a.sal_trn_type = n.sal_trn_type AND a.store_code = n.store_code AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND a.store_code LIKE UPPER (?) AND b.item_code LIKE UPPER (?) AND a.sal_trn_type LIKE ?   AND a.patient_id LIKE   UPPER (?) AND n.locn_code=p.NURSING_UNIT_CODE	 AND p.language_id = 'en' AND   (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?,'31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y' and a.encounter_id like ? AND a.doc_type_code LIKE ? and a.doc_no like ? ORDER BY a.store_code,a.doc_no,to_date(doc_date,'dd/mm/yyyy')");			
               
			   //commented by Rabbani #Inc no:36887 on  20/12/2012
				//sqlMap.put ("sqlData","SELECT  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,  b.item_qty ret_qty,a.added_by_id, n.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw  where  nursing_unit_code =  n.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ? and language_id= ?),'' )short_desc ,a.sales_doc_no, (CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT SUM(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND  g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND  g.primary_key_main = b.doc_type_code || '-' || b.doc_no) END ) gross_charge_amt, ROUND (NVL (b.item_cost_value, 0), 2)  item_cost_value, a.sal_trn_type,NVL (b.item_qty, 0) sale_req_qty ,0  pen_sal_req_qty  FROM   st_sal_ret_hdr a, st_sal_ret_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, ST_SAL_HDR n WHERE a.facility_id = b.facility_id AND  a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no AND a.sales_doc_no = n.doc_no  AND a.patient_id = n.patient_id AND a.sal_trn_type = n.sal_trn_type AND a.store_code = n.store_code AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND a.store_code LIKE UPPER (?) AND b.item_code LIKE UPPER (?) AND a.sal_trn_type LIKE ?   AND a.patient_id = ? AND   (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?,'31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y' and a.encounter_id like ? AND a.doc_type_code LIKE ? and a.doc_no like ? ORDER BY a.store_code,a.doc_no,to_date(doc_date,'dd/mm/yyyy')");			
				
				//Added by Rabbani #Inc no:36887 on  20/12/2012
				//String sql = "SELECT  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,  b.item_qty ret_qty,a.added_by_id, n.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw  where  nursing_unit_code =  n.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ? and language_id= ?),'' )short_desc ,a.sales_doc_no, (CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT SUM(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND  g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND  g.primary_key_main = b.doc_type_code || '-' || b.doc_no and h.patient_id = g.patient_id and h.patient_id=a.patient_id  and g.serv_item_code=b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_cost_value, 0), 2)  item_cost_value, a.sal_trn_type,NVL (b.item_qty, 0) sale_req_qty ,0  pen_sal_req_qty  FROM   st_sal_ret_hdr a, st_sal_ret_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, ST_SAL_HDR n WHERE a.facility_id = b.facility_id AND  a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no AND a.sales_doc_no = n.doc_no  AND a.patient_id = n.patient_id AND a.sal_trn_type = n.sal_trn_type AND a.store_code = n.store_code AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND     (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?,'31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y'";

				//Modified by Sakti against MMS-SCF-0337 inc#48949 Cost Value increase
				//String sql = "SELECT  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,  b.item_qty ret_qty,a.added_by_id, n.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw  where  nursing_unit_code =  n.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ? and language_id= ?),'' )short_desc ,a.sales_doc_no, (CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT SUM(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND  g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND  g.primary_key_main = b.doc_type_code || '-' || b.doc_no and h.patient_id = g.patient_id and h.patient_id=a.patient_id  and g.serv_item_code=b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_cost_value, 0), 2)  item_cost_value, ROUND(((  b.item_qty * (SELECT ROUND (AVG (curr_unit_cost), 3)  FROM st_item_unit_cost_history  WHERE trn_type IN ('OBS', 'GRN')  AND item_code = b.item_code and changed_Date <= a.doc_Date)) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type,NVL (b.item_qty, 0) sale_req_qty ,0  pen_sal_req_qty  FROM   st_sal_ret_hdr a, st_sal_ret_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, ST_SAL_HDR n WHERE a.facility_id = b.facility_id AND  a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no AND a.sales_doc_no = n.doc_no  AND a.patient_id = n.patient_id AND a.sal_trn_type = n.sal_trn_type AND a.store_code = n.store_code AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND     (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?,'31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y'";
				//Modified by Suresh.r against TTM-SCF-0108 inc#50303 Unit_cost,sale_value logic changed.
				//String sql = "SELECT  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,  b.item_qty ret_qty,a.added_by_id, n.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw  where  nursing_unit_code =  n.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ? and language_id= ?),'' )short_desc ,a.sales_doc_no, (CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN st_display_sale_value(a.facility_id,b.doc_type_code,b.doc_no,a.patient_id,b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_cost_value, 0), 2)  item_cost_value, ROUND(((  b.item_qty * (st_display_unit_cost(b.item_code,a.modified_date))) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type,NVL (b.item_qty, 0) sale_req_qty ,0  pen_sal_req_qty  FROM   st_sal_ret_hdr a, st_sal_ret_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, ST_SAL_HDR n WHERE a.facility_id = b.facility_id AND  a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no AND a.sales_doc_no = n.doc_no  AND a.patient_id = n.patient_id AND a.sal_trn_type = n.sal_trn_type AND a.store_code = n.store_code AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND     (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?,'31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y'";
				//Modified by B.Badmavathi against AAKH-SCF-0220 inc#57816 
				
				//String sql = "SELECT  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,  b.item_qty ret_qty,a.added_by_id, n.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw  where  nursing_unit_code =  n.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ? and language_id= ?),'' )short_desc ,a.sales_doc_no, (CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN st_display_sale_value(a.facility_id,b.doc_type_code,b.doc_no,a.patient_id,b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_cost_value, 0), 2)  item_cost_value, ROUND(((  b.item_qty * (st_display_unit_cost(b.item_code,a.modified_date))) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type,NVL (b.item_qty, 0) sale_req_qty ,0  pen_sal_req_qty  FROM   st_sal_ret_hdr a, st_sal_ret_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, ST_SAL_HDR n WHERE a.facility_id = b.facility_id AND  a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no AND a.sales_doc_no = n.doc_no  AND a.patient_id = n.patient_id AND /*a.sal_trn_type = n.sal_trn_type AND*/ a.store_code = n.store_code AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND     (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?,'31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y'"; //Commented for AMS-CRF-0258
				
				String sql = "SELECT a.doc_type_code, c.short_desc doc_type_desc, a.doc_no, TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc, a.patient_id, f.patient_name, b.item_qty ret_qty, a.added_by_id, n.locn_code, DECODE (a.sal_trn_type, 'I', (SELECT short_desc FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code =n.locn_code AND facility_id = ? AND language_id = ?), 'O', (SELECT short_desc FROM op_clinic_lang_vw WHERE clinic_code =n.locn_code AND facility_id = ? AND language_id = ?), 'D', (SELECT short_desc FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code =n.locn_code AND facility_id = ? AND language_id = ?), 'E', (SELECT short_desc FROM op_clinic_lang_vw WHERE clinic_code = n.locn_code AND facility_id = ? AND language_id = ?), '' ) short_desc, a.sales_doc_no, (CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN st_display_sale_value (a.facility_id, b.doc_type_code, b.doc_no, a.patient_id, b.item_code ) END ) gross_charge_amt, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND ((  (  b.item_qty * (st_display_unit_cost (b.item_code, a.modified_date)) ) * st_get_uom_conv_fac_sing_str (b.item_code, a.store_code) ), 3 ) item_cost_value_new, a.sal_trn_type, NVL (b.item_qty, 0) sale_req_qty, 0 pen_sal_req_qty, p.take_home_yn FROM st_sal_ret_hdr a, st_sal_ret_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, st_sal_hdr n, st_sal_dtl p WHERE a.facility_id = b.facility_id AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.sales_doc_no = n.doc_no AND a.patient_id = n.patient_id AND /*a.sal_trn_type = n.sal_trn_type AND*/ a.store_code = n.store_code AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901')), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND a.finalized_yn = 'Y' AND p.facility_id = a.facility_id AND p.doc_no = n.doc_no AND p.doc_type_code = n.doc_type_code AND b.item_code = p.item_code"; //Modified for AMS-CRF-0258
				
				displayFields.add("store_desc"); //0	
				displayFields.add("item_code");	
				displayFields.add("item_desc");	
				displayFields.add("doc_type_desc");
				displayFields.add("doc_no");
				displayFields.add("doc_date");
				displayFields.add("ret_qty");
				displayFields.add("item_cost_value");
				displayFields.add("gross_charge_amt");
				displayFields.add("patient_id");
				displayFields.add("patient_name");
				displayFields.add("store_code");
				displayFields.add("sal_trn_type");
				displayFields.add("short_desc");
				displayFields.add("added_by_id");
				displayFields.add("sales_doc_no");
				displayFields.add("item_cost_value_new"); //Modified by Sakti against MMS-SCF-0337 inc#48949 Cost Value increase
				displayFields.add("take_home_yn"); //Added for AMS-CRF-0258
				
				chkFields.add(facility_id);
				chkFields.add(language_id);
				chkFields.add(facility_id);
				chkFields.add(language_id);
				chkFields.add(facility_id);
				chkFields.add(language_id);
				chkFields.add(facility_id);
				chkFields.add(language_id);

				chkFields.add(facility_id);
				//chkFields.add(store_code);
				//chkFields.add(item_code);
				//chkFields.add(sal_trn_type);
				//chkFields.add(patient_id);
				chkFields.add(from_date);
				chkFields.add(to_date);
				//chkFields.add(encounter_id);
				//chkFields.add(sal_doc_type);
				//chkFields.add(doc_no);
				
		   //Added by Rabbani #Inc no:36887 on  20/12/2012
			if(!(store_code.equals(""))	){
			sql = sql + " and a.store_code = ? " ;
			chkFields.add(store_code);
			}	
			if(!(item_code.equals(""))	){
			sql = sql + " and b.item_code = ?  "  ;
			chkFields.add(item_code);
			}
			if(!(sal_trn_type.equals("%"))	){
			sql = sql + " and a.sal_trn_type = ? " ;
			chkFields.add(sal_trn_type);
			}
			if(!(patient_id.equals(""))	){
			sql = sql + " and a.patient_id = ? " ;
			chkFields.add(patient_id);
			}
			if(!(encounter_id.equals(""))){
			sql = sql + " and a.encounter_id = ? "  ;
			chkFields.add(encounter_id);
			}
			if(!(sal_doc_type.equals(""))){
			sql = sql + " and a.doc_type_code = ? " ;
			chkFields.add(sal_doc_type);
			}
			if(!(doc_no.equals(""))	){
			sql = sql + " and a.doc_no = ? " ;
			chkFields.add(doc_no);
			}
			//Added for AMS-CRF-0258
			if(!(sal_trn_type_query.equals(""))	){
			sql = sql + sal_trn_type_query ;
			}
			//Added for AMS-CRF-0258	 
 			
			sql = sql + " ORDER BY a.store_code,a.doc_no,to_date(doc_date,'dd/mm/yyyy')" ;
			sqlMap.put("sqlData",sql);
				//System.out.println("sql SRT" +sql);
				//System.out.println("chkFields SRT" +chkFields);
				//ends
				funcMap.put("displayFields", displayFields);
				funcMap.put("chkFields", chkFields);
				ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
				//System.out.println("result498==>"+result);
				int cnt=2;
				String no_records="";
						int grandpreviouscnt1=0;
						int grandnextcnt1=0;
						int int_grandpreviouscnt1=0;
						int int_grandnextcnt1=0;
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0"))))
			{
			
					HashMap hshSalesType = new HashMap();
					hshSalesType.put("I",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inpatients.label","common_labels"));
					hshSalesType.put("O",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatients.label","common_labels"));
					hshSalesType.put("R",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Referrals.label","st_labels"));
					hshSalesType.put("H",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.discharged.label","common_labels"));
					hshSalesType.put("X",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.DirectSales.label","st_labels"));
					hshSalesType.put("E",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels"));
					hshSalesType.put("D",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels"));
					hshSalesType.put("C",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Consumption.label","st_labels"));

	
					if(((String)result.get(1)).indexOf("(")>0) {
						
						strGrandTotFlag1 = "N";
					}else{
						strGrandTotFlag1 = "Y";
					}%>
					<table cellpadding=0 cellspacing=0 width="100%" align="center">
					<tr id="heading">
							<td width="80%" class="label">&nbsp;</td>
						<td width="20%" class="label" bgcolor="white">&nbsp;
						<%=result.get(1)%> </td>
						<%
							
						no_records				=		(result.get(1).toString());
						int_grandpreviouscnt1	=		no_records.indexOf('P');
						grandpreviouscnt1		=		int_grandpreviouscnt1;
						int_grandnextcnt1		=		no_records.indexOf('N');
						grandnextcnt1			=		int_grandnextcnt1;
						
						try{
							if(int_grandpreviouscnt1 > 0)
							{
							if((no_records.substring(int_grandpreviouscnt1,(int_grandpreviouscnt1 +8))).equals("Previous"))
							grandpreviouscnt1	=		int_grandpreviouscnt1;
							else 
							grandpreviouscnt1	=		int_grandpreviouscnt1;
							}
						}catch(Exception e1) { }
							
							try{
							if(int_grandnextcnt1 > 0)
							{
							if((no_records.substring(int_grandnextcnt1,(int_grandnextcnt1 +4))).equals("Next")) 
								grandnextcnt1	=		int_grandnextcnt1;
							}
							else
								grandnextcnt1	=		int_grandnextcnt1;
							}
							catch(Exception e2) { }
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
					<th><fmt:message key="eST.SaleRefNo.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eST.ReturnQuantity.label" bundle="${st_labels}"/></th>
					
			<%if(view_cost_details_yn.equals("Y")){%>
					<th><fmt:message key="eST.CostValue.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="eST.ReturnValue.label" bundle="${st_labels}"/></th>
			<%}%>	
					<th nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.name.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eST.nursingunit/clinic.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="Common.Createdby.label" bundle="${common_labels}"/></th>
				
					</tr>
					<%
						ArrayList records=new ArrayList();
							
							for(int recCount=2,k = 0; recCount<result.size(); recCount++,k++)
							{  
								cnt ++;
								classvalue = (recCount % 2 == 0)?"QRYEVEN":"QRYODD";
								records=(ArrayList) result.get(recCount);
						%>
							<tr>
						<%
							curr_item_store1=(String)records.get(0);
							if(!curr_item_store1.equals(prev_item_store1))
							{
								flag=true;
				
								if(cost_value_sub_total>=0 && subtotal >= 0 && !curr_item_store1.equals(prev_item_store1) && cnt > 3)
								{	
								if(view_cost_details_yn.equals("Y")){
					
								%>
								<tr>
								<td colspan=8 align='left' class='ITEMSELECT' width="60%"><font size=1><b><fmt:message key="eST.StoreSubTotal.label" bundle="${st_labels}"/> : </b> </td>
								<td  colspan=1 style="TEXT-ALIGN:right"  class='ITEMSELECT'	><font size=1><B><%=nf.format(Double.parseDouble(bean.setNumber(""+cost_value_sub_total,noOfDecimalsForCost)))%></B></font>&nbsp;</td>
								<td  colspan=1 style="TEXT-ALIGN:right"  class='ITEMSELECT'	><font size=1><B><%=nf.format(Double.parseDouble(bean.setNumber(""+subtotal,noOfDecimalsForCost)))%></B></font>&nbsp;</td>
								<td colspan=2 align='left'  class='ITEMSELECT'> </td>
								<td colspan=2 align='left'  class='ITEMSELECT'> </td>
								</tr>
								<%}
									subtotal=0.0f;
									cost_value_sub_total=0.0f;
								%>	
			
								<%}
								else if(cost_value_sub_total>=0 && subtotal >= 0 && flag==false && store_compare.equals(store_code)) 
									{
									pre_subtotal +=subtotal;
									//System.out.println("pre_subtotal==>"+pre_subtotal);
									pre_cost_value_sub_total+=cost_value_sub_total;
									//System.out.println("pre_cost_value_sub_total==>"+pre_cost_value_sub_total);
									if(view_cost_details_yn.equals("Y")){
									%>
									<tr>
									<td	colspan=9 class='ITEMSELECT' width="60%"><font size=1><b><fmt:message key="eST.StoreSubTotal.label" bundle="${st_labels}"/> : </b> 	</td>
									<td  colspan=1 style="TEXT-ALIGN:right" class='ITEMSELECT'	><font size=1><B><%=nf.format(Double.parseDouble(bean.setNumber(""+pre_cost_value_sub_total,noOfDecimalsForCost)))%></B></font>&nbsp;</td>
									<td  colspan=1 style="TEXT-ALIGN:right" class='ITEMSELECT'	><font size=1><B><%=nf.format(Double.parseDouble(bean.setNumber(""+pre_subtotal,noOfDecimalsForCost)))%></B></font>&nbsp;</td>
									<td colspan=2 align='left'  class='ITEMSELECT'> </td>
								</tr>
								<%}
								}%>
								<%
									store_code=CommonBean.checkForNull((String)records.get(0),"");								
								%>

									<tr>
									<td colspan=15 align='left' class='ITEMSELECT'><font size=1><b><fmt:message key="Common.Store.label" bundle="${st_labels}"/>:</b> 
									<%=CommonBean.checkForNull((String)records.get(0),"")%>&nbsp;</td>
									</tr>
							<%}

									String str_sales_type = CommonBean.checkForNull((String)records.get(12));
									//Added for AMS-CRF-0258
									if(str_sales_type.equals("I") && (CommonBean.checkForNull((String)records.get(17)).equals("Y"))){
										 str_sales_type = "H";
									}
									//Added for AMS-CRF-0258
				%>					

				<tr id="tr_<%=k%>">
	
	<td class="<%=classvalue%>" align="left" ><font size=1><%=(String)records.get(1)%></font></td>
	<td class="<%=classvalue%>" align="left" style='WORD-BREAK:BREAK-ALL;'><font size=1><%=CommonBean.checkForNull((String)records.get(2),"&nbsp;")%></font></td>
	<td class="<%=classvalue%>" align="left" style='WORD-BREAK:BREAK-ALL;'><font size=1><%=CommonBean.checkForNull((String)records.get(3),"0")%></font></td>
	<td class="<%=classvalue%>" align="left" ><font size=1><%=hshSalesType.get(str_sales_type)%></font></td>
	<td class="<%=classvalue%>"  style="TEXT-ALIGN:right"><font size=1><%=CommonBean.checkForNull((String)records.get(4),"0")%></font></td>
	<td class="<%=classvalue%>"  style="TEXT-ALIGN:right"><font size=1><%=DateUtils.convertDate(CommonBean.checkForNull((String)records.get(5),"0"),"DMY","en",locale)%></font></td>
	<td class="<%=classvalue%>"  style="TEXT-ALIGN:right"><font size=1><%=CommonBean.checkForNull((String)records.get(15),"0")%></font></td>
	<td class="<%=classvalue%>"  style="TEXT-ALIGN:right"><font size=1><%=bean.setNumberFormat(bean.checkForNull((String)records.get(6),"0"),no_of_decimals)%></font>&nbsp;</td>
		
	
	<%
		String cost_value_1=CommonBean.checkForNull((String)records.get(8),"0");
		subtotal = subtotal + Double.parseDouble(cost_value_1);
		//cost_value_sub_total =cost_value_sub_total+	Double.parseDouble(CommonBean.checkForNull((String)records.get(7),"0"));
		cost_value_sub_total =cost_value_sub_total+	Double.parseDouble(CommonBean.checkForNull((String)records.get(16),"0"));
	%>

<%if(view_cost_details_yn.equals("Y")){%>

	<!-- <td class="<%=classvalue%>"  style="TEXT-ALIGN:right"><font size=1><%=bean.setNumberFormat(CommonBean.checkForNull((String)records.get(7),"0"),noOfDecimalsForCost)%></font>&nbsp;</td> -->

	<td class="<%=classvalue%>"  style="TEXT-ALIGN:right"><font size=1><%=bean.setNumberFormat(CommonBean.checkForNull((String)records.get(16),"0"),noOfDecimalsForCost)%></font>&nbsp;</td>

	<td class="<%=classvalue%>"  style="TEXT-ALIGN:right"><font size=1><%=bean.setNumberFormat(CommonBean.checkForNull((String)records.get(8),"0"),noOfDecimalsForCost)%></font>&nbsp;</td> 
<%}%>	
	<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)records.get(9),"0")%></font></td>
	<td class="<%=classvalue%>" style='WORD-BREAK:BREAK-ALL;'><font size=1><%=CommonBean.checkForNull((String)records.get(10),"0")%></font></td>
	<td class="<%=classvalue%>" align="left" ><font size=1><%=CommonBean.checkForNull((String)records.get(13),"")%></font>&nbsp;</td>
	<td class="<%=classvalue%>" align="left" ><font size=1><%=CommonBean.checkForNull((String)records.get(14),"")%></font>&nbsp;</td>


	<td class='NODISPLAY'><%=records.get(11)%></td>		
	<%
		prev_item_store1=curr_item_store1;
	}	
		grand_tot = grand_tot + subtotal;
		}	
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/html/blank.html";
			</script>
		<%}
				if(view_cost_details_yn.equals("Y")){

//						if(cnt == result.size() && subtotal >= 0 && cost_value_sub_total>=0)
						if(cnt == result.size())
						{%>
								<tr>								
								<td colspan=8   class='ITEMSELECT'><font size=1 width="60%"><b><fmt:message key="eST.StoreSubTotal.label" bundle="${st_labels}"/> : </b> </td>								
								<td  colspan=1 style="TEXT-ALIGN:right" class='ITEMSELECT'	><font size=1><B><%=nf.format(Double.parseDouble(bean.setNumber(""+cost_value_sub_total,noOfDecimalsForCost)))%></B></font>&nbsp;</td>
								<td  colspan=1 style="TEXT-ALIGN:right" class='ITEMSELECT'	><font size=1><B><%=nf.format(Double.parseDouble(bean.setNumber(""+subtotal,noOfDecimalsForCost)))%></B></font>&nbsp;</td>
								<td colspan=2 align='left'  class='ITEMSELECT'> </td>
								<td colspan=2 align='left'  class='ITEMSELECT'> </td>
								</tr>
							<%}
				}
		/*if(view_cost_details_yn.equals("Y")){

		if((grandnextcnt1 == -1  && grandpreviouscnt1 > 0 && (result.size() == cnt )) || (strGrandTotFlag1.equals("Y")) )

		{ *///Below it is commented for display, query is firing unnecessary - AMS-SCF-1073
			%>
		<%
		/*ArrayList  result3=new ArrayList(); 
	
		result3=bean.QueryResultDetails(facility_id,store_code3,item_code3,sal_trn_type3,patient_id3, from_date3 , to_date3,encounter_id3,sal_doc_type3,doc_no3);
		//System.out.println("result3===>"+ result3);
			
		if((result3.size()>0) )
			{			
				HashMap records3=new HashMap();
				for(int recCount=0; recCount<result3.size(); recCount++)
					{			
							records3=(HashMap)result3.get(recCount);
		*///Below it is commented for display, query is firing unnecessary - AMS-SCF-1073
				%>
			<tr> </tr>

					<!--
			<tr>
				
				<td  colspan=8  align='left' class='ITEMSELECT'><font size=1><b><fmt:message key="Common.GrandTotal.label" bundle="${mm_labels}"/> : </b></td> 
				
					<%
			/*
						String grandt1=CommonBean.checkForNull((String)records3.get("grand_tot"),"0");
						String cost_grand_tot1 = CommonBean.checkForNull((String)records3.get("cost_grand_tot"),"0");
			*///Below it is commented for display, query is firing unnecessary - AMS-SCF-1073
						%>
				<td colspan=1 style="TEXT-ALIGN:right" class='ITEMSELECT'><font size=1><B><% /*bean.setNumberFormat(cost_grand_tot1,noOfDecimalsForCost)*/ %></B></font>&nbsp;</td>
				<td colspan=1 style="TEXT-ALIGN:right" class='ITEMSELECT'><font size=1><B><% /*bean.setNumberFormat(grandt1,noOfDecimalsForCost)*/ %></B></font>&nbsp;</td>
								
				<td colspan=2 align='left' class='ITEMSELECT'>&nbsp;&nbsp;</td>
				<td colspan=2 align='left'  class='ITEMSELECT'> </td>
				
		
			</tr> -->
					<% //}	//Below it is commented for display, query is firing unnecessary - AMS-SCF-1073
			//}//Below it is commented for display, query is firing unnecessary - AMS-SCF-1073		
		
		//} //Below it is commented for display, query is firing unnecessary - AMS-SCF-1073		
	//} //Below it is commented for display, query is firing unnecessary - AMS-SCF-1073
		out.println(" </table>");
		out.println("	</form>");
		out.flush();
		
		out.println(CommonBean.setForm (request ,"../../eST/jsp/SalesAndReturnHistoryQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ result3 JSP :"+e.toString());
	}
}


else if(trn_type.equals("BOT")) 
{

	try{
			
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			store_code			=		CommonBean.checkForNull(store_code,"");
			item_code			=		CommonBean.checkForNull(item_code,"");
			from_date			=		CommonBean.checkForNull(from_date,"");
			to_date				=		CommonBean.checkForNull(to_date,"");
			patient_id			=		CommonBean.checkForNull(patient_id);
			encounter_id		=		CommonBean.checkForNull(encounter_id,"");
			sal_trn_type		=		CommonBean.checkForNull(sal_trn_type,"%");
			sal_doc_type		=		CommonBean.checkForNull(sal_doc_type,"");  
			doc_no				=		CommonBean.checkForNull(doc_no,"");
	

			String store_code3	=		CommonBean.checkForNull(store_code,"");
			String item_code3	=		CommonBean.checkForNull(item_code,"");
			String from_date3	=		CommonBean.checkForNull(from_date,"");
			String to_date3		=		CommonBean.checkForNull(to_date,"");
			String patient_id3	=		CommonBean.checkForNull(patient_id);
			String encounter_id3=		CommonBean.checkForNull(encounter_id,"");
			String sal_trn_type3=		CommonBean.checkForNull(sal_trn_type,"%");  
			String  sal_doc_type3 =		CommonBean.checkForNull(sal_doc_type,"");  
			String doc_no3		=		CommonBean.checkForNull(doc_no,"");  
		

			String strGrandTotFlag1 ="";
			
				HashMap sqlMap			=		new HashMap();
				HashMap funcMap			=		new HashMap();
				ArrayList displayFields =		new ArrayList();
				ArrayList chkFields		=		new ArrayList();
				String curr_item_store1	=		"";
				String prev_item_store1	=		"";
				
				//Added for AMS-CRF-0258
				String sal_trn_type_query = "";
				String sal_trn_type_query_1 = "";
				String sal_trn="";
				if(sal_trn_type.equals("I")){
					  sal_trn_type_query = "and b.take_home_yn ='N'";
					   sal_trn="N";
				 }else if(sal_trn_type.equals("H")){
					  sal_trn_type_query = "and b.take_home_yn ='Y'";
					  sal_trn_type = "I";
					   sal_trn="Y";
				 }
				//Added for AMS-CRF-0258
				
				//sqlMap.put ("sqlData","SELECT  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no, TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,a.trn_type,a.locn_code,p.short_desc,a.added_by_id, b.item_qty Quantity, 0 sales_doc_no,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT SUM(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND  g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND  g.primary_key_main = b.doc_type_code || '-' || b.doc_no) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2)  item_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, a.sal_trn_type, NVL (b.sale_req_qty, 0) sale_req_qty,  (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty  FROM     st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, IP_NURSING_UNIT_LANG_VW p WHERE a.facility_id = b.facility_id AND a.added_by_id = b.added_by_id AND a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND a.store_code LIKE UPPER (?) AND b.item_code LIKE UPPER (?) AND a.sal_trn_type LIKE ? AND a.patient_id LIKE   UPPER (?) AND   (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y' AND a.encounter_id LIKE ? AND a.doc_type_code LIKE ? AND a.doc_no LIKE ? AND  a.locn_code = p.nursing_unit_code  AND p.language_id='en'  				UNION ALL  select  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no, TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name, a.trn_type, n.locn_code, p.short_desc, a.added_by_id, b.item_qty Quantity, a.sales_doc_no, (CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT SUM(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND  g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND  g.primary_key_main = b.doc_type_code || '-' || b.doc_no) END ) gross_charge_amt, ROUND (NVL (b.item_cost_value, 0), 2)  item_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, a.sal_trn_type,NVL (b.item_qty, 0) sale_req_qty ,0  pen_sal_req_qty  FROM   st_sal_ret_hdr a, st_sal_ret_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, ST_SAL_HDR n , IP_NURSING_UNIT_LANG_VW p WHERE a.facility_id = b.facility_id AND a.added_by_id = b.added_by_id AND a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no  AND a.sales_doc_no = n.doc_no  AND a.patient_id = n.patient_id AND a.sal_trn_type = n.sal_trn_type AND a.store_code = n.store_code AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND a.store_code LIKE UPPER (?) AND b.item_code LIKE UPPER (?) AND a.sal_trn_type LIKE ? AND a.patient_id LIKE   UPPER (?) AND   (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y' AND a.encounter_id LIKE ? AND a.doc_type_code LIKE ? AND a.doc_no LIKE ? AND n.locn_code = p.nursing_unit_code AND p.language_id='en' ORDER BY store_code,doc_date,doc_no");			
				
				//commented by Rabbani #Inc no:36887 on  20/12/2012
				//sqlMap.put ("sqlData","SELECT  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no, TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,a.trn_type,a.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'' )short_desc,a.added_by_id, b.item_qty Quantity, 0 sales_doc_no,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT SUM(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND  g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND  g.primary_key_main = b.doc_type_code || '-' || b.doc_no) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2)  item_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, a.sal_trn_type, NVL (b.sale_req_qty, 0) sale_req_qty,  (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty  FROM     st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND a.store_code LIKE UPPER (?) AND b.item_code LIKE UPPER (?) AND a.sal_trn_type LIKE ? AND a.patient_id = ? AND   (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y' AND a.encounter_id LIKE ? AND a.doc_type_code LIKE ? AND a.doc_no LIKE ? UNION ALL select  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no, TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name, a.trn_type, n.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ? and language_id= ?),'' )short_desc, a.added_by_id,-  b.item_qty Quantity, a.sales_doc_no, -(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT SUM(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND  g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND  g.primary_key_main = b.doc_type_code || '-' || b.doc_no) END ) gross_charge_amt, ROUND (NVL (b.item_cost_value, 0), 2)  item_value, - ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, a.sal_trn_type,NVL (b.item_qty, 0) sale_req_qty ,0  pen_sal_req_qty  FROM   st_sal_ret_hdr a, st_sal_ret_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, ST_SAL_HDR n WHERE a.facility_id = b.facility_id AND  a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no  AND a.sales_doc_no = n.doc_no  AND a.patient_id = n.patient_id AND a.sal_trn_type = n.sal_trn_type AND a.store_code = n.store_code AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND a.store_code LIKE UPPER (?) AND b.item_code LIKE UPPER (?) AND a.sal_trn_type LIKE ? AND a.patient_id = ? AND   (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y' AND a.encounter_id LIKE ? AND a.doc_type_code LIKE ? AND a.doc_no LIKE ?  ORDER BY store_code,doc_date,doc_no");	
                
				//Added by Rabbani #Inc no:36887 on  20/12/2012
				//String sql = "SELECT  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no, TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,a.trn_type,a.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'' )short_desc,a.added_by_id, b.item_qty Quantity, 0 sales_doc_no,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT SUM(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND  g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND  g.primary_key_main = b.doc_type_code || '-' || b.doc_no and h.patient_id = g.patient_id and h.patient_id=a.patient_id  and g.serv_item_code=b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2)  item_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND(((  b.item_qty * (SELECT ROUND (AVG (curr_unit_cost), 3)  FROM st_item_unit_cost_history  WHERE trn_type IN ('OBS', 'GRN')  AND item_code = b.item_code and changed_Date <= a.doc_Date)) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type, NVL (b.sale_req_qty, 0) sale_req_qty,  (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty  FROM     st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ?  AND   (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y'";	
				//Modified by Suresh.r against TTM-SCF-0108 inc#50303 Unit_cost,sale_value logic changed.
				/*GHL-CRF-0557.1 start*/
				String sql = "";
				if(site){
					System.out.println("site - true"); 
					sql = "SELECT  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,b.doc_srl_no, TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,a.trn_type,a.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'' )short_desc,a.added_by_id, b.item_qty Quantity, 0 sales_doc_no, ST_DISPLAY_SALE_ITEM_VALUE(a.facility_id,b.doc_type_code,b.doc_no,b.doc_srl_no,a.patient_id,b.item_code) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2)  item_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND(((  b.item_qty * (st_display_unit_cost(b.item_code,a.modified_date))) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type, NVL (b.sale_req_qty, 0) sale_req_qty,  (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty,b.take_home_yn  FROM     st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ?  AND   (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y'"; //Modified for AMS-SCF-0970 //Modified for AMS-CRF-0258
				}
				else{
					sql = "SELECT  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,b.doc_srl_no, TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,a.trn_type,a.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'' )short_desc,a.added_by_id, b.item_qty Quantity, 0 sales_doc_no,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN ST_DISPLAY_SALE_ITEM_VALUE(a.facility_id,b.doc_type_code,b.doc_no,b.doc_srl_no,a.patient_id,b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2)  item_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND(((  b.item_qty * (st_display_unit_cost(b.item_code,a.modified_date))) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type, NVL (b.sale_req_qty, 0) sale_req_qty,  (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty,b.take_home_yn  FROM     st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ?  AND   (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y'"; //Modified for AMS-SCF-0970 //Added for AMS-CRF-0258
				}
				/*GHL-CRF-0557.1 start*/
			   
				
    			displayFields.add("store_desc"); //0	
				displayFields.add("item_code");	
				displayFields.add("item_desc");	
				displayFields.add("doc_type_desc");
				displayFields.add("doc_no");
				displayFields.add("doc_date");
				displayFields.add("Quantity");
				displayFields.add("item_cost_value");
				displayFields.add("gross_charge_amt");
				displayFields.add("patient_id");
				displayFields.add("patient_name");
				displayFields.add("store_code");
				displayFields.add("sal_trn_type");
				displayFields.add("added_by_id");
				displayFields.add("trn_type");
				displayFields.add("short_desc");
				displayFields.add("sales_doc_no");
				displayFields.add("item_cost_value_new");//Added by Sakti against MMS-SCF-0337 inc#48949 Cost Value increase
				displayFields.add("take_home_yn"); //Added for AMS-CRF-0258


				chkFields.add(facility_id);
				chkFields.add(language_id);
				chkFields.add(facility_id);
				chkFields.add(language_id);
				chkFields.add(facility_id);
				chkFields.add(language_id);
				chkFields.add(facility_id);
				chkFields.add(language_id);

				chkFields.add(facility_id);
				chkFields.add(from_date);
				chkFields.add(to_date);
			//Added by Rabbani #Inc no:36887 on  20/12/2012
			if(!(store_code.equals(""))){
			sql = sql + " and a.store_code = ? " ;
			chkFields.add(store_code);
			}	
			if(!(item_code.equals(""))){
			sql = sql + " and b.item_code = ?  "  ;
			chkFields.add(item_code);
			}
			if(!(sal_trn_type.equals("%"))){
			sql = sql + " and a.sal_trn_type = ? " ;
			chkFields.add(sal_trn_type);
			}
			if(!(patient_id.equals(""))){
			sql = sql + " and a.patient_id = ? " ;
			chkFields.add(patient_id);
			}
			if(!(encounter_id.equals(""))){
			sql = sql + " and a.encounter_id = ? "  ;
			chkFields.add(encounter_id);
			}
			if(!(sal_doc_type.equals(""))){
			sql = sql + " and a.doc_type_code = ? " ;
			chkFields.add(sal_doc_type);
			}
			if(!(doc_no.equals(""))	){
			sql = sql + " and a.doc_no = ? " ;
			chkFields.add(doc_no);
			}
			//Added for AMS-CRF-0258
			if(!(sal_trn_type_query.equals(""))	){
			sql = sql + sal_trn_type_query ;
			}
 			//Added for AMS-CRF-0258
			//sql = sql+" UNION ALL select  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no, TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name, a.trn_type, n.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ? and language_id= ?),'' )short_desc, a.added_by_id,-  b.item_qty Quantity, a.sales_doc_no, -(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT SUM(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND  g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND  g.primary_key_main = b.doc_type_code || '-' || b.doc_no and h.patient_id = g.patient_id and h.patient_id=a.patient_id  and g.serv_item_code=b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_cost_value, 0), 2)  item_value, - ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND(((  b.item_qty * (SELECT ROUND (AVG (curr_unit_cost), 3)  FROM st_item_unit_cost_history  WHERE trn_type IN ('OBS', 'GRN')  AND item_code = b.item_code and changed_Date <= a.doc_Date)) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type,NVL (b.item_qty, 0) sale_req_qty ,0  pen_sal_req_qty  FROM   st_sal_ret_hdr a, st_sal_ret_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, ST_SAL_HDR n WHERE a.facility_id = b.facility_id AND  a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no  AND a.sales_doc_no = n.doc_no  AND a.patient_id = n.patient_id AND a.sal_trn_type = n.sal_trn_type AND a.store_code = n.store_code AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND   (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y'";
			//Modified by Suresh.r against TTM-SCF-0108 inc#50303 Unit_cost,sale_value logic changed. 
			//sql = sql+" UNION ALL select  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no, TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name, a.trn_type, n.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ? and language_id= ?),'' )short_desc, a.added_by_id,-  b.item_qty Quantity, a.sales_doc_no, -(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN st_display_sale_value(a.facility_id,b.doc_type_code,b.doc_no,a.patient_id,b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_cost_value, 0), 2)  item_value, - ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND(((  b.item_qty * (st_display_unit_cost(b.item_code,a.modified_date))) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type,NVL (b.item_qty, 0) sale_req_qty ,0  pen_sal_req_qty  FROM   st_sal_ret_hdr a, st_sal_ret_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, ST_SAL_HDR n WHERE a.facility_id = b.facility_id AND  a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no  AND a.sales_doc_no = n.doc_no  AND a.patient_id = n.patient_id AND a.sal_trn_type = n.sal_trn_type AND a.store_code = n.store_code AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND   (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y'";
			//Modified by B.Badmavathi against AAKH-SCF-0220 IN57816
			sql = sql+" UNION ALL select  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,b.doc_srl_no, TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name, a.trn_type, n.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ? and language_id= ?),'' )short_desc, a.added_by_id,-  b.item_qty Quantity, a.sales_doc_no, -(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN st_display_sale_value(a.facility_id,b.doc_type_code,b.doc_no,a.patient_id,b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_cost_value, 0), 2)  item_value, - ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND(((  b.item_qty * (st_display_unit_cost(b.item_code,a.modified_date))) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type,NVL (b.item_qty, 0) sale_req_qty ,0  pen_sal_req_qty, p.take_home_yn  FROM   st_sal_ret_hdr a, st_sal_ret_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, ST_SAL_HDR n,ST_SAL_DTL p WHERE a.facility_id = b.facility_id AND  a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no  AND a.sales_doc_no = n.doc_no  AND a.patient_id = n.patient_id /*AND a.sal_trn_type = n.sal_trn_type*/ AND a.store_code = n.store_code AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND   (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y' AND p.facility_id=a.facility_id AND p.doc_no = n.doc_no AND p.doc_type_code = n.doc_type_code AND b.item_code = p.item_code"; //Modified for AMS-SCF-0970 //Added for AMS-CRF-0258
				//chkFields.add(store_code);
				//chkFields.add(item_code);
				//chkFields.add(sal_trn_type);
				//chkFields.add(patient_id);
				//chkFields.add(encounter_id);
				//chkFields.add(sal_doc_type);
				//chkFields.add(doc_no);
				
			//Added for AMS-CRF-0258
			if(sal_trn.equals("N")){
				  sal_trn_type_query_1 = "and p.take_home_yn ='N'";
			 }else if(sal_trn.equals("Y")){
				  sal_trn_type_query_1 = "and p.take_home_yn ='Y'";
				  sal_trn_type = "I";
			 }
			 //Added for AMS-CRF-0258
			 
				chkFields.add(facility_id);
				chkFields.add(language_id);
				chkFields.add(facility_id);
				chkFields.add(language_id);
				chkFields.add(facility_id);
				chkFields.add(language_id);
				chkFields.add(facility_id);
				chkFields.add(language_id);

				chkFields.add(facility_id);
				chkFields.add(from_date);
				chkFields.add(to_date);
				 
				
			if(!(store_code.equals(""))	){
			sql = sql + " and a.store_code = ? " ;
			chkFields.add(store_code);
			}	
			if(!(item_code.equals(""))	){
			sql = sql + " and b.item_code = ?  "  ;
			chkFields.add(item_code);
			}
			if(!(sal_trn_type.equals("%"))	){
			sql = sql + " and a.sal_trn_type = ? " ;
			chkFields.add(sal_trn_type);
			}
			if(!(patient_id.equals(""))	){
			sql = sql + " and a.patient_id = ? " ;
			chkFields.add(patient_id);
			}
			if(!(encounter_id.equals(""))	){
			sql = sql + " and a.encounter_id = ? "  ;
			chkFields.add(encounter_id);
			}
			if(!(sal_doc_type.equals(""))){
			sql = sql + " and a.doc_type_code = ? " ;
			chkFields.add(sal_doc_type);
			}
			if(!(doc_no.equals(""))	){
			sql = sql + " and a.doc_no = ? " ;
			chkFields.add(doc_no);
			}
			//Added for AMS-CRF-0258
			if(!(sal_trn_type_query_1.equals(""))	){
			sql = sql + sal_trn_type_query_1 ;
			}
 			//Added for AMS-CRF-0258		
			sql = sql + " ORDER BY store_code,doc_date,doc_no" ;

                 System.out.println("sql BOTH==>"+sql);
				 System.out.println("chkFields 1007==>"+chkFields);
				 sqlMap.put("sqlData",sql);
				 //Added by Rabbani #Inc no:36887 on  20/12/2012 ends
				funcMap.put("displayFields", displayFields);
				funcMap.put("chkFields", chkFields);
				
				ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
				int cnt=2;
				String no_records="";
						int grandpreviouscnt1=0;
						int grandnextcnt1=0;
						int int_grandpreviouscnt1=0;
						int int_grandnextcnt1=0;
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0"))))
			{		

					HashMap hshSalesType = new HashMap();
					hshSalesType.put("I",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inpatients.label","common_labels"));
					hshSalesType.put("O",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatients.label","common_labels"));
					hshSalesType.put("R",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Referrals.label","st_labels"));
					hshSalesType.put("H",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.discharged.label","common_labels"));
					hshSalesType.put("X",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.DirectSales.label","st_labels"));
					hshSalesType.put("E",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels"));
					hshSalesType.put("D",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels"));
					hshSalesType.put("C",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Consumption.label","st_labels"));

					if(((String)result.get(1)).indexOf("(")>0) {
						
						strGrandTotFlag1 = "N";
					}else{
						strGrandTotFlag1 = "Y";
					}%>
					<table cellpadding=0 cellspacing=0 width="100%" align="center">
					<tr id="heading">
							<td width="80%" class="label">&nbsp;</td>
						<td width="20%" class="label" bgcolor="white">&nbsp;
						<%=result.get(1)%> </td>

						<%
						no_records				=		(result.get(1).toString());
						int_grandpreviouscnt1	=		no_records.indexOf('P');
						grandpreviouscnt1		=		int_grandpreviouscnt1;
						int_grandnextcnt1		=		no_records.indexOf('N');
						grandnextcnt1			=		int_grandnextcnt1;
						
						try{
							if(int_grandpreviouscnt1 > 0)
							{
							if((no_records.substring(int_grandpreviouscnt1,(int_grandpreviouscnt1 +8))).equals("Previous"))
							grandpreviouscnt1	=		int_grandpreviouscnt1;
							else 
							grandpreviouscnt1	=		int_grandpreviouscnt1;
							}
						}catch(Exception e1) { }
							
							try{
							if(int_grandnextcnt1 > 0)
							{
							if((no_records.substring(int_grandnextcnt1,(int_grandnextcnt1 +4))).equals("Next")) 
								grandnextcnt1	=		int_grandnextcnt1;
							}
							else
								grandnextcnt1	=		int_grandnextcnt1;
							}
							catch(Exception e2) { }
						%>
											
					</tr>
					</table>
				<div  style="position:relative;height:460px;overflow:auto">

				<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" id='tb1'>
				<tr style='position:relative'style='top:expression(this.offsetParent.scrollTop-2)'>
					<th><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eST.TRNtype.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eST.SalesType.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eST.SaleRefNo.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="eST.Quantity.label" bundle="${st_labels}"/></th>
					
			<%if(view_cost_details_yn.equals("Y")){%>
					<th><fmt:message key="eST.CostValue.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="eST.Sales/Return Value.label" bundle="${st_labels}"/></th>
			<%}%>	
					<th nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.name.label" bundle="${common_labels}"/></th>
						
					<th><fmt:message key="eST.nursingunit/clinic.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="Common.Createdby.label" bundle="${common_labels}"/></th>
					
				</tr>
					<%
						ArrayList records=new ArrayList();
						for(int recCount=2,k = 0; recCount<result.size(); recCount++,k++)
							{  
								cnt ++;
								classvalue = (recCount % 2 == 0)?"QRYEVEN":"QRYODD";
								records=(ArrayList) result.get(recCount);
					%>
						<tr>
				
					<%
							curr_item_store1=(String)records.get(0);
							if(!curr_item_store1.equals(prev_item_store1))
							{
								flag=true;
								//if(cost_value_sub_total>=0 && subtotal >= 0 && !curr_item_store1.equals(prev_item_store1) && cnt > 3)
									if( !curr_item_store1.equals(prev_item_store1) && cnt > 3)
								{	
								if(view_cost_details_yn.equals("Y")){
					
					%>			<tr>
								<td colspan=9 align='left' class='ITEMSELECT' width="60%"><font size=1><b><fmt:message key="eST.StoreSubTotal.label" bundle="${st_labels}"/> : </b> 
								</td>
								<td  colspan=1 style="TEXT-ALIGN:right"  class='ITEMSELECT'	><font size=1><B><%=nf.format(Double.parseDouble(bean.setNumber(""+cost_value_sub_total,noOfDecimalsForCost)))%></B></font>&nbsp;</td>
								
								<td  colspan=1 style="TEXT-ALIGN:right"  class='ITEMSELECT'	><font size=1><B><%=nf.format(Double.parseDouble(bean.setNumber(""+subtotal,noOfDecimalsForCost)))%></B></font>&nbsp;</td>
									<td colspan=2 align='left'  class='ITEMSELECT'> </td>
									<td colspan=2 align='left'  class='ITEMSELECT'> </td>
								</tr>
								<%}
									subtotal=0.0f;
									cost_value_sub_total=0.0f;
								%>	
								
								<%}	
								//else if(cost_value_sub_total>=0 && subtotal >= 0 && flag==false && store_compare.equals(store_code)) 
								else if(flag==false && store_compare.equals(store_code)) 
									{
									pre_subtotal +=subtotal;
									pre_cost_value_sub_total+=cost_value_sub_total;
									if(view_cost_details_yn.equals("Y")){
									%>
									<tr>
									<td colspan=9  class='ITEMSELECT' width="60%"><font size=1><b><fmt:message key="eST.StoreSubTotal.label" bundle="${st_labels}"/> : </b> </td>
									<td  colspan=1 style="TEXT-ALIGN:right" class='ITEMSELECT'	><font size=1><B><%=nf.format(Double.parseDouble(bean.setNumber(""+pre_cost_value_sub_total,noOfDecimalsForCost)))%></B></font>&nbsp;</td>
									<td  colspan=1 style="TEXT-ALIGN:right" class='ITEMSELECT'	><font size=1><B><%=nf.format(Double.parseDouble(bean.setNumber(""+pre_subtotal,noOfDecimalsForCost)))%></B></font>&nbsp;</td>
									<td colspan=2 align='left'  class='ITEMSELECT'> </td>
								</tr>
							<%}
								}%>
								<%
										store_code=CommonBean.checkForNull((String)records.get(0),"");
								%>
									<tr>
									<td colspan=15 align='left' class='ITEMSELECT'><font size=1><b><fmt:message key="Common.Store.label" bundle="${st_labels}"/>:</b> 
									<%=CommonBean.checkForNull((String)records.get(0),"")%>&nbsp;</td>
									</tr>
						<%}

				String str_sales_type = CommonBean.checkForNull((String)records.get(12));
				
				//Added for AMS-CRF-0258
				if(str_sales_type.equals("I") && (CommonBean.checkForNull((String)records.get(18)).equals("Y"))){
					 str_sales_type = "H";
				}
				//Added for AMS-CRF-0258
				
				//System.out.println("str_sales_type==>"+str_sales_type);
				%>

				<tr id="tr_<%=k%>">
	
	<td class="<%=classvalue%>" align="left" ><font size=1><%=(String)records.get(1)%></font></td>
	<td class="<%=classvalue%>" align="left" style='WORD-BREAK:BREAK-ALL;'><font size=1><%=CommonBean.checkForNull((String)records.get(2),"&nbsp;")%></font></td>
	<td class="<%=classvalue%>" align="left" style='WORD-BREAK:BREAK-ALL;'><font size=1><%=CommonBean.checkForNull((String)records.get(14),"0")%></font></td>
	<td class="<%=classvalue%>" align="left" style='WORD-BREAK:BREAK-ALL;'><font size=1><%=CommonBean.checkForNull((String)records.get(3),"0")%></font></td>
	<td class="<%=classvalue%>" align="left" ><font size=1><%=hshSalesType.get(str_sales_type)%></font></td>
	<td class="<%=classvalue%>"  style="TEXT-ALIGN:right"><font size=1><%=CommonBean.checkForNull((String)records.get(4),"0")%></font></td>
	<td class="<%=classvalue%>"  style="TEXT-ALIGN:right"><font size=1><%=DateUtils.convertDate(CommonBean.checkForNull((String)records.get(5),"0"),"DMY","en",locale)%></font></td>
	<td class="<%=classvalue%>"  style="TEXT-ALIGN:right"><font size=1><%=((String)records.get(16)).equals("0")? "&nbsp;" :(String)records.get(16)%></font></td>
	<td class="<%=classvalue%>"  style="TEXT-ALIGN:right"><font size=1><%=bean.setNumberFormat(bean.checkForNull((String)records.get(6),"0"),no_of_decimals)%></font>&nbsp;</td>
		<%
		String cost_value_1=CommonBean.checkForNull((String)records.get(8),"0");
		subtotal = subtotal + Double.parseDouble(cost_value_1);
		//cost_value_sub_total =cost_value_sub_total+	Double.parseDouble(CommonBean.checkForNull((String)records.get(7),"0"));
		cost_value_sub_total =cost_value_sub_total+	Double.parseDouble(CommonBean.checkForNull((String)records.get(17),"0"));
		%>

<%if(view_cost_details_yn.equals("Y")){%>

	<!-- <td class="<%=classvalue%>"  style="TEXT-ALIGN:right"><font size=1><%=bean.setNumberFormat(CommonBean.checkForNull((String)records.get(7),"0"),noOfDecimalsForCost)%></font>&nbsp;</td> -->
	<td class="<%=classvalue%>"  style="TEXT-ALIGN:right"><font size=1><%=bean.setNumberFormat(CommonBean.checkForNull((String)records.get(17),"0"),noOfDecimalsForCost)%></font>&nbsp;</td>

	<td class="<%=classvalue%>"  style="TEXT-ALIGN:right"><font size=1><%=bean.setNumberFormat(CommonBean.checkForNull((String)records.get(8),"0"),noOfDecimalsForCost)%></font>&nbsp;</td> 
<%}%>	
	<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)records.get(9),"0")%></font></td>
	<td class="<%=classvalue%>" style='WORD-BREAK:BREAK-ALL;'><font size=1><%=CommonBean.checkForNull((String)records.get(10),"0")%></font></td>
	<td class="<%=classvalue%>"  style="TEXT-ALIGN:left"><font size=1><%=CommonBean.checkForNull((String)records.get(15),"")%></font>&nbsp;</td>
	<td class="<%=classvalue%>"  style="TEXT-ALIGN:left"><font size=1><%=CommonBean.checkForNull((String)records.get(13),"")%></font>&nbsp;</td>
	<td class='NODISPLAY'><%=records.get(11)%></td>		
			
		<%
			prev_item_store1=curr_item_store1;
			}
			grand_tot = grand_tot + subtotal;
		}
		else{%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/html/blank.html";
			</script>
		<%}
				if(view_cost_details_yn.equals("Y")){

						//if(cnt == result.size() && subtotal >= 0 && cost_value_sub_total>=0)
						if(cnt == result.size())
						{%>
								<tr>
								
								<td colspan=9   class='ITEMSELECT'><font size=1 width="60%"><b><fmt:message key="eST.StoreSubTotal.label" bundle="${st_labels}"/> : </b> 
								</td>
								
								<td  colspan=1 style="TEXT-ALIGN:right" class='ITEMSELECT'	><font size=1><B><%=nf.format(Double.parseDouble(bean.setNumber(""+cost_value_sub_total,noOfDecimalsForCost)))%></B></font>&nbsp;</td>
								<td  colspan=1 style="TEXT-ALIGN:right" class='ITEMSELECT'	><font size=1><B><%=nf.format(Double.parseDouble(bean.setNumber(""+subtotal,noOfDecimalsForCost)))%></B></font>&nbsp;</td>
								
								<td colspan=2 align='left'  class='ITEMSELECT'> </td>
								<td colspan=2 align='left'  class='ITEMSELECT'> </td>
								</tr>
						<%}
				}
	/*	if(view_cost_details_yn.equals("Y")){
		//	if((grandnextcnt1 == -1  && grandpreviouscnt1 > 0 && (result.size() == cnt )) || (strGrandTotFlag1.equals("Y")) )
			if((grandnextcnt1 == -1  && (result.size() == cnt )) || (strGrandTotFlag1.equals("Y")) )
		{ *///Below it is commented for display, query is firing unnecessary - AMS-SCF-1073
		%>
		<%
		
		//ArrayList  result4=new ArrayList(); //Below it is commented for display, query is firing unnecessary - AMS-SCF-1073
		//result4=bean.QueryResultDetails(facility_id,store_code3,item_code3,sal_trn_type3,patient_id3, from_date3 , to_date3,encounter_id3,sal_doc_type3,doc_no3);  //Below it is commented for display, query is firing unnecessary - AMS-SCF-1073
		//System.out.println("result4==>"+result4);
		/* if((result4.size()>0) )
			{			
				HashMap records4=new HashMap();
				for(int recCount=0; recCount<result4.size(); recCount++)
				{			
					records4=(HashMap)result4.get(recCount);
		 */
		  //Below it is commented for display, query is firing unnecessary - AMS-SCF-1073
				%>
			
			<tr> </tr>

				<!--
			<tr>
				
				<td  colspan=9  align='left' class='ITEMSELECT'><font size=1><b><fmt:message key="Common.GrandTotal.label" bundle="${mm_labels}"/> : </b></td> 
				
			<%
			
				/*String grandt1=CommonBean.checkForNull((String)records4.get("grand_tot"),"0");
				String cost_grand_tot1 = CommonBean.checkForNull((String)records4.get("cost_grand_tot"),"0");
				*/  //Below it is commented for display, query is firing unnecessary - AMS-SCF-1073
			%>
				<td colspan=1 style="TEXT-ALIGN:right" class='ITEMSELECT'><font size=1><B><
				<%/*bean.setNumberFormat(cost_grand_tot1,noOfDecimalsForCost)*/ %></B></font>&nbsp;</td>
				<td colspan=1 style="TEXT-ALIGN:right" class='ITEMSELECT'><font size=1><B><%/*bean.setNumberFormat(grandt1,noOfDecimalsForCost))*/ %></B></font>&nbsp;</td>
				<td colspan=2 align='left' class='ITEMSELECT'>&nbsp;&nbsp;</td>
				<td colspan=2 align='left'  class='ITEMSELECT'> </td>
					
			</tr>
			-->
					<% // }	
		//	}		//Below it is commented for display, query is firing unnecessary - AMS-SCF-1073
		
		//} //Below it is commented for display, query is firing unnecessary - AMS-SCF-1073		
	//} //Below it is commented for display, query is firing unnecessary - AMS-SCF-1073
		out.println(" </table>");
		out.println("	</form>");
		out.flush();
		
		out.println(CommonBean.setForm (request ,"../../eST/jsp/SalesAndReturnHistoryQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ result4 JSP :"+e.toString());
	}
}%>

</form>		
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>


 

