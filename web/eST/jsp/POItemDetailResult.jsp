<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		       Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
27/11/2019      IN:071539               B Haribabu         28/11/2019         Manickam                NMC-JD-CRF-0029
05/05/2021  	TFS id:-17345           Haribabu	      05/05/2021	 	 Manickavasagam J         NMC-JD-SCF-0183
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import=" eST.*,eST.Common.*,java.util.*,eCommon.Common.*, java.text.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%><!-- Modified for IN:071539 -->
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html> 
	<head>
		<%
		request.setCharacterEncoding("UTF-8");
		String locale		=	(String)session.getAttribute("LOCALE");

		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../eST/js/StMessages.js"></script>
		<script language="JavaScript" src="../../eST/js/GoodsReceivedNote.js"></script>
    	<script language='javascript' src='../../eST/js/StTransaction.js'></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%    

	String facility_id			=		(String) session.getValue( "facility_id" ) ;

	String bean_id              ="";
    String bean_name            ="";
	String store_code           ="";
	String from_doc_date        ="";
	String to_doc_date          ="";
	String item_code            ="";
	String po_number            ="";
	String supp_code			="";
	String pur_unit_code		="";
	String pur_unit_desc		="";
	String req_qty				="";		
	String req_uom				="";
	String classValue			="";
	String new_po_no			="";
	String st_uom_code			="";
	String st_uom_desc			="";
	String mode					="";
	String img_next_del_date	="hidden";
	String receipt_qty			= "";
	String grn_qty_readonly		= "";
	String do_no				= "";
	String sort_by				= "";// Added for IN:071539
	String Item_Store_Combination="";//added for NMC-JD-CRF-0142
    String bckcolor="";//added for NMC-JD-CRF-0142
	bean_id                     = "goodsReceivedNoteBean" ;
	bean_name                   = "eST.GoodsReceivedNoteBean";

    
	GoodsReceivedNoteBean bean = (GoodsReceivedNoteBean) getBeanObject( bean_id, bean_name,request );


	store_code           =  bean.checkForNull(request.getParameter("store_code"));
	item_code            =  request.getParameter("item_desc").equals("")? "%": request.getParameter("item_code");
	from_doc_date        =  bean.checkForNull(request.getParameter("from_doc_date"));
	to_doc_date          =  bean.checkForNull(request.getParameter("to_doc_date"));	
	po_number            =  bean.checkForNull(request.getParameter("doc_no"),"%");
	supp_code            =  bean.checkForNull(request.getParameter("supp_code"),"%");//Modified for IN:071539
	pur_unit_code        =  bean.checkForNull(request.getParameter("purchase_unit"),"%");
	mode				 =  bean.checkForNull(request.getParameter("mode"));
	do_no				 =  bean.checkForNull(request.getParameter("do_no"));
	sort_by				 =  bean.checkForNull(request.getParameter("sort_by"));// Added for IN:071539

	int no_deci                   =    bean.getNoOfDecimals();

	HashMap PO_Override			=	bean.fetchRecord(bean.getStRepositoryValue("SQL_PO_PARAMETER_OVERRIDE_ALLOW"));

	String qty_override_yn		=	bean.checkForNull((String)PO_Override.get("ALLOW_QTY_OVERRIDE_IN_GRN"),"N");
	//Added for IN:071539 start
    Connection con				= null;
	 
	boolean multi_selct_appl = false;
	
	try 
	{
		con						= ConnectionManager.getConnection(request);
		multi_selct_appl = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_GRN_PO_RESULT_MULTI_SELECT");
		
	} 
	catch (Exception e) 
	{
		e.printStackTrace(System.err);
		System.out.println(" Error in Criteria Page " + e.getMessage());
	} 
	finally 
	{
		if (con != null) ConnectionManager.returnConnection(con, request); 
	}
	String multi_selct_appl_chk="N";
	if(multi_selct_appl)
		multi_selct_appl_chk="Y";
	//Added for IN:071539(US04) START
	ArrayList stParameters = new ArrayList();
	stParameters.add(store_code);
	stParameters.add(facility_id);
	stParameters.add(supp_code);
	stParameters.add(from_doc_date);
	stParameters.add(to_doc_date);
	stParameters.add(po_number);
	stParameters.add(pur_unit_code);
	stParameters.add(item_code);
	ArrayList alParameters = null;
	String doc_type=bean.getDoc_type_code();
	//System.out.println("doc_type> "+doc_type);
	//String []stParameters1={store_code,facility_id,supp_code,from_doc_date,to_doc_date,po_number,pur_unit_code,item_code,doc_type};		
	String sql="";
	if(multi_selct_appl){
		stParameters.add(doc_type);
		if(supp_code.equals("%")){
		 sql= "SELECT DISTINCT dtl.pur_unit_code, dtl.po_no FROM po_order_hdr hdr, po_order_fcy_dtl dtl,XI_TRN_PO_DTLS_IB xi WHERE hdr.pur_unit_code = dtl.pur_unit_code AND hdr.po_no = dtl.po_no AND (dtl.req_store_code = ? OR dtl.req_store_code = '*A') AND (dtl.req_facility_id = ? OR dtl.req_facility_id = '*A') AND hdr.supp_code LIKE ? AND hdr.po_status IN ('FA', 'AM', 'RA', 'PD', 'FD', 'PR') AND po_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901')), 'DD/MM/YYYY' ) AND NVL (TO_DATE (?, 'DD/MM/YYYY'), SYSDATE) AND dtl.po_no LIKE ? AND dtl.pur_unit_code LIKE ? AND dtl.item_code LIKE ? AND DTL.PO_NO=XI.RESP_NUM and XI.DOC_TYPE_CODE=? AND (NVL (dtl.po_qty, 0) - NVL (dtl.grn_qty, 0)) > 0 ORDER BY 2";
		}
		else{
		 sql= "SELECT DISTINCT dtl.pur_unit_code, dtl.po_no FROM po_order_hdr hdr, po_order_fcy_dtl dtl, xi_trn_po_dtls_ib xi WHERE hdr.pur_unit_code = dtl.pur_unit_code AND hdr.po_no = dtl.po_no AND (dtl.req_store_code = ? OR dtl.req_store_code = '*A') AND (dtl.req_facility_id = ? OR dtl.req_facility_id = '*A') AND hdr.supp_code = ? AND hdr.po_status IN ('FA', 'AM', 'RA', 'PD', 'FD', 'PR') AND po_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901')), 'DD/MM/YYYY' ) AND NVL (TO_DATE (?, 'DD/MM/YYYY'), SYSDATE) AND dtl.po_no LIKE ? AND dtl.pur_unit_code LIKE ? AND dtl.item_code LIKE ? AND dtl.po_no = xi.resp_num AND xi.doc_type_code = ? AND (NVL (dtl.po_qty, 0) - NVL (dtl.grn_qty, 0)) > 0 ORDER BY 2";
		}
	}
	else{
		sql= "SELECT DISTINCT DTL.PUR_UNIT_CODE,DTL.PO_NO FROM PO_ORDER_HDR HDR ,PO_ORDER_FCY_DTL DTL WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO AND (DTL.REQ_STORE_CODE = ? OR DTL.REQ_STORE_CODE='*A') AND (DTL.REQ_FACILITY_ID = ? OR DTL.REQ_FACILITY_ID = '*A') AND HDR.SUPP_CODE = ? AND  HDR.PO_STATUS IN ('FA','AM', 'RA', 'PD','FD','PR') AND PO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'DD/MM/YYYY' )  AND  NVL (TO_DATE (?, 'DD/MM/YYYY'), SYSDATE) AND DTL.PO_NO LIKE ? AND DTL.PUR_UNIT_CODE LIKE ?  AND DTL.ITEM_CODE  LIKE  ? AND (NVL(DTL.PO_QTY,0)-NVL(DTL.GRN_QTY,0)) > 0  ORDER BY 2";
	}
	
	String []stParameters1 = new String[stParameters.size()];              
		for(int j =0;j<stParameters.size();j++){
			stParameters1[j] = (String) stParameters.get(j);
		}
    
	ArrayList alTemp = new ArrayList();
	HashMap hmExpData = new HashMap();
	HashMap hmTemp = null;
	HashMap temp = null;

	alTemp =  bean.fetchRecords(sql,stParameters1);
	//Modified for IN:071539(US04) end
	int total = alTemp.size();	
	if(total ==0){
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
			</script>
		<%		
	}	
	
	for(int j=0;j<total;){		

		HashMap hm = (HashMap)alTemp.get(j);
		
		//String []stParameters1 = {locale,store_code,facility_id,from_doc_date,to_doc_date,(String)hm.get("PO_NO"),(String)hm.get("PUR_UNIT_CODE"),item_code,facility_id,store_code,do_no};
		alParameters = new ArrayList();
		alParameters.add(locale);
		alParameters.add(store_code);
		alParameters.add(facility_id);
		alParameters.add(from_doc_date);
		alParameters.add(to_doc_date);
		alParameters.add((String)hm.get("PO_NO"));
		alParameters.add((String)hm.get("PUR_UNIT_CODE"));
		alParameters.add(item_code);
		alParameters.add(facility_id);
		alParameters.add(store_code);
		alParameters.add(do_no);

		String sql1 = "";

		if(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))){			

			//sql1 = "select * from (SELECT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (dtl.po_qty, 0) - (NVL (dtl.grn_qty, 0) + (select nvl(sum(nvl(blocked_qty,0)),0) blocked_qty from po_order_unf_grn where po_no = dtl.po_no and item_code=dtl.item_code  and (req_no=dtl.req_no or req_no = '*A') and (facility_id !='"+facility_id+"' or grn_doc_type_code!='"+bean.getDoc_type_code()+"' or grn_no!='"+bean.getDoc_no()+"')))) item_qty_normal,nvl(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST,	((NVL (dtl.po_qty, 0) - (NVL (dtl.grn_qty, 0)) +  (select nvl(sum(nvl(blocked_qty,0)),0) blocked_qty from po_order_unf_grn where po_no = dtl.po_no and item_code=dtl.item_code and (req_no=dtl.req_no or req_no = '*A') and ( facility_id !='"+facility_id+"' or grn_doc_type_code!= '"+bean.getDoc_type_code()+"' or grn_no!='"+bean.getDoc_no()+"'))) * (NVL (dtl.item_unit_cost, 0) * NVL (hdr.conversion_rate, 0))) item_cost_value, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , nvl(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,hdr.LOCAL_CURRENCY,hdr.CONVERSION_RATE,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE,to_char(HDR.EXPECTED_DELV_DATE,'dd/mm/yyyy') EXPECTED_DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY  FROM po_order_hdr HDR ,po_order_fcy_dtl DTL,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1  WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO and MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A' ) AND PO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )  AND  NVL (TO_DATE (?, 'dd/mm/yyyy'), SYSDATE) AND DTL.PO_NO = ? and DTL.PUR_UNIT_CODE = ?  and dtl.item_code like  ? ) a  where a.item_qty_normal > 0 order by 2";
			//Modified for IN:071539 start
			sql1 = "select * from (SELECT DISTINCT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (dtl.po_qty, 0) - (NVL (dtl.grn_qty, 0) + (select nvl(sum(nvl(blocked_qty,0)),0) blocked_qty from po_order_unf_grn where po_no = dtl.po_no and item_code=dtl.item_code  and (req_no=dtl.req_no or req_no = '*A') and (facility_id !='"+facility_id+"' or grn_doc_type_code!='"+bean.getDoc_type_code()+"' or grn_no!='"+bean.getDoc_no()+"')))) item_qty_normal,nvl(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST,	((NVL (dtl.po_qty, 0) - (NVL (dtl.grn_qty, 0)) +  (select nvl(sum(nvl(blocked_qty,0)),0) blocked_qty from po_order_unf_grn where po_no = dtl.po_no and item_code=dtl.item_code and (req_no=dtl.req_no or req_no = '*A') and ( facility_id !='"+facility_id+"' or grn_doc_type_code!= '"+bean.getDoc_type_code()+"' or grn_no!='"+bean.getDoc_no()+"'))) * (NVL (dtl.item_unit_cost, 0) * NVL (hdr.conversion_rate, 0))) item_cost_value, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , nvl(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,hdr.LOCAL_CURRENCY,hdr.CONVERSION_RATE,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE,to_char(HDR.EXPECTED_DELV_DATE,'dd/mm/yyyy') EXPECTED_DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY , POD.DO_NO,DECODE(POD.DO_NO,'','',NVL(POH.DO_STATUS,'UF'))DO_STATUS,SUM(POD.DO_QTY_NORMAL) OVER(PARTITION BY POD.DO_NO, POD.ITEM_CODE,POD.PO_NO,POD.PO_SRL_NO)  DO_QTY_NORMAL,SUM(NVL(POD.DO_QTY_NORMAL - NVL (POD.GRN_QTY, 0),0)) OVER(PARTITION BY POD.DO_NO, POD.ITEM_CODE,POD.PO_NO,POD.PO_SRL_NO) AVAIL_QTY FROM po_order_hdr HDR ,po_order_fcy_dtl DTL,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1  ,po_delv_ord_dtl_bat pod,PO_DELV_ORD_HDR POH WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO and MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A' ) AND PO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )  AND  NVL (TO_DATE (?, 'dd/mm/yyyy'), SYSDATE) AND DTL.PO_NO = ? and DTL.PUR_UNIT_CODE = ?  and dtl.item_code like  ? AND POH.DO_NO(+) = POD.DO_NO  AND POH.DO_STATUS(+) IN ('FN','PR')  AND pod.po_no(+) = dtl.po_no  AND pod.item_code(+) = dtl.item_code   AND pod.po_srl_no(+) = dtl.po_srl_no   AND (   pod.dist_facility_id = ?   OR NVL (pod.dist_facility_id, '*A') = '*A' ) AND (   pod.dist_store_code = ?  OR NVL (pod.dist_store_code, '*A') = '*A')              AND NVL (pod.do_no, '*A') =  NVL (?, NVL (pod.do_no, '*A')) ) a  where a.item_qty_normal > 0 order by 2";
			System.out.println("sql1>> "+sql1);		
			if(multi_selct_appl){
				if(sort_by.equals("ITEMCODE")){
					sql1=sql1+", item_code";
				}
				else{
					sql1=sql1+", item_desc";
				}
				}
				
					//sql1=sql1+" ITEM_DESC, DO_NO";
				//Modified for IN:071539 end
		}else{
			
			alParameters.add(locale);
			alParameters.add(store_code);
			alParameters.add(facility_id);
			alParameters.add(from_doc_date);
			alParameters.add(to_doc_date);
			alParameters.add((String)hm.get("PO_NO"));
			alParameters.add((String)hm.get("PUR_UNIT_CODE"));
			alParameters.add(item_code);

			//sql1 = "select * from (SELECT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (dtl.po_qty, 0) - (NVL (dtl.grn_qty, 0) + (select nvl(sum(nvl(blocked_qty,0)),0) blocked_qty from po_order_unf_grn where po_no = dtl.po_no and item_code=dtl.item_code ) )) item_qty_normal,nvl(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST,	((NVL (dtl.po_qty, 0) - (NVL (dtl.grn_qty, 0)) +  (select nvl(sum(nvl(blocked_qty,0)),0) blocked_qty from po_order_unf_grn where po_no = dtl.po_no and item_code=dtl.item_code )) * (NVL (dtl.item_unit_cost, 0) * NVL (hdr.conversion_rate, 0))) item_cost_value, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , nvl(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,hdr.LOCAL_CURRENCY,hdr.CONVERSION_RATE,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE,to_char(HDR.EXPECTED_DELV_DATE,'dd/mm/yyyy') EXPECTED_DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY  FROM po_order_hdr HDR ,po_order_fcy_dtl DTL,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1  WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO and MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A' ) AND PO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )  AND  NVL (TO_DATE (?, 'dd/mm/yyyy'), SYSDATE) AND DTL.PO_NO = ? and DTL.PUR_UNIT_CODE = ?  and dtl.item_code like  ? ) a  where a.item_qty_normal > 0 order by 2";
			//sql1 = "SELECT * FROM (SELECT DISTINCT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (DTL.PO_QTY, 0) - (NVL (DTL.GRN_QTY, 0) + (SELECT NVL(SUM(NVL(BLOCKED_QTY,0)),0) BLOCKED_QTY FROM PO_ORDER_UNF_GRN WHERE PO_NO = DTL.PO_NO AND ITEM_CODE=DTL.ITEM_CODE ) )) ITEM_QTY_NORMAL,NVL(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST,	((NVL (DTL.PO_QTY, 0) - (NVL (DTL.GRN_QTY, 0)) +  (SELECT NVL(SUM(NVL(BLOCKED_QTY,0)),0) BLOCKED_QTY FROM PO_ORDER_UNF_GRN WHERE PO_NO = DTL.PO_NO AND ITEM_CODE=DTL.ITEM_CODE )) * (NVL (DTL.ITEM_UNIT_COST, 0) * NVL (HDR.CONVERSION_RATE, 0))) ITEM_COST_VALUE, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , NVL(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,HDR.LOCAL_CURRENCY,HDR.CONVERSION_RATE,TO_CHAR(HDR.PO_DATE,'DD/MM/YYYY') PO_DATE,TO_CHAR(HDR.EXPECTED_DELV_DATE,'DD/MM/YYYY') EXPECTED_DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY,POD.DO_NO,POD.DO_QTY_NORMAL, NVL(POD.DO_QTY_NORMAL - NVL (POD.GRN_QTY, 0),9999999)AVAIL_QTY,BATCH_ID,TO_CHAR(EXPIRY_DATE,'DD/MM/YYYY')EXPIRY_DATE,TRADE_ID   FROM PO_ORDER_HDR HDR ,PO_ORDER_FCY_DTL DTL,PO_ORDER_DELV_SCH POSCH,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1,PO_DELV_ORD_DTL_BAT POD  WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO  AND DTL.PO_NO = POSCH.PO_NO  AND DTL.PO_SRL_NO= POSCH.PO_SRL_NO  AND DTL.ITEM_CODE = POSCH.ITEM_CODE AND MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE AND (DTL.REQ_STORE_CODE = ? OR DTL.REQ_STORE_CODE='*A') AND (DTL.REQ_FACILITY_ID = ? OR DTL.REQ_FACILITY_ID = '*A' ) AND PO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'DD/MM/YYYY' )  AND  NVL (TO_DATE (?, 'DD/MM/YYYY'), SYSDATE) AND DTL.PO_NO = ? AND DTL.PUR_UNIT_CODE = ?  AND DTL.ITEM_CODE LIKE  ?  AND POD.PO_NO(+) = POSCH.PO_NO AND POD.PO_SRL_NO(+) = POSCH.PO_SRL_NO  AND POD.ITEM_CODE(+) = POSCH.ITEM_CODE  AND POD.SCH_DELV_DATE(+) = POSCH.DELV_DATE  AND (POD.DIST_FACILITY_ID = ? OR NVL(POD.DIST_FACILITY_ID,'*A') = '*A') AND (POD.DIST_STORE_CODE= ? OR NVL(POD.DIST_STORE_CODE,'*A') = '*A') AND NVL(POSCH.DO_NO,'*A') = NVL(?,NVL(POSCH.DO_NO,'*A'))) A  WHERE A.ITEM_QTY_NORMAL > 0 AND A.AVAIL_QTY > 0 ORDER BY PO_NO,ITEM_DESC,REQ_NO,DO_NO";
			//sql1 = "SELECT * FROM (SELECT DISTINCT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (DTL.PO_QTY, 0) - (NVL (DTL.GRN_QTY, 0) + (SELECT NVL(SUM(NVL(BLOCKED_QTY,0)),0) BLOCKED_QTY FROM PO_ORDER_UNF_GRN WHERE PO_NO = DTL.PO_NO AND ITEM_CODE=DTL.ITEM_CODE ) )) ITEM_QTY_NORMAL,NVL(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST,	((NVL (DTL.PO_QTY, 0) - (NVL (DTL.GRN_QTY, 0)) +  (SELECT NVL(SUM(NVL(BLOCKED_QTY,0)),0) BLOCKED_QTY FROM PO_ORDER_UNF_GRN WHERE PO_NO = DTL.PO_NO AND ITEM_CODE=DTL.ITEM_CODE )) * (NVL (DTL.ITEM_UNIT_COST, 0) * NVL (HDR.CONVERSION_RATE, 0))) ITEM_COST_VALUE, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , NVL(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,HDR.LOCAL_CURRENCY,HDR.CONVERSION_RATE,TO_CHAR(HDR.PO_DATE,'DD/MM/YYYY') PO_DATE,TO_CHAR(HDR.EXPECTED_DELV_DATE,'DD/MM/YYYY') EXPECTED_DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY , POD.DO_NO,SUM(POD.DO_QTY_NORMAL) OVER(PARTITION BY POD.DO_NO, POD.ITEM_CODE,POD.PO_NO,POD.PO_SRL_NO)  DO_QTY_NORMAL,SUM(NVL(POD.DO_QTY_NORMAL - NVL (POD.GRN_QTY, 0),9999999)) OVER(PARTITION BY POD.DO_NO, POD.ITEM_CODE,POD.PO_NO,POD.PO_SRL_NO)  AVAIL_QTY FROM PO_ORDER_HDR HDR ,PO_ORDER_FCY_DTL DTL,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1, PO_DELV_ORD_DTL_BAT POD WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO AND MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE AND (DTL.REQ_STORE_CODE = ? OR DTL.REQ_STORE_CODE='*A') AND (DTL.REQ_FACILITY_ID = ? OR DTL.REQ_FACILITY_ID = '*A' ) AND PO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'DD/MM/YYYY' )  AND  NVL (TO_DATE (?, 'DD/MM/YYYY'), SYSDATE) AND DTL.PO_NO = ? AND DTL.PUR_UNIT_CODE = ?  AND DTL.ITEM_CODE LIKE  ?  AND POD.PO_NO(+) = DTL.PO_NO  AND POD.ITEM_CODE(+) = DTL.ITEM_CODE  AND POD.PO_SRL_NO(+) = DTL.PO_SRL_NO  AND (POD.DIST_FACILITY_ID = ? OR NVL(POD.DIST_FACILITY_ID,'*A') = '*A') AND (POD.DIST_STORE_CODE = ? OR  NVL(POD.DIST_STORE_CODE,'*A') = '*A') AND NVL(pod.DO_NO,'*A') = NVL(?,NVL(pod.DO_NO,'*A')) ) A  WHERE A.ITEM_QTY_NORMAL > 0 AND A.AVAIL_QTY > 0 ORDER BY PO_NO, ITEM_DESC, DO_NO";
			//sql1 = "SELECT * FROM (SELECT DISTINCT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (DTL.PO_QTY, 0) - (NVL (DTL.GRN_QTY, 0) + (SELECT NVL(SUM(NVL(BLOCKED_QTY,0)),0) BLOCKED_QTY FROM PO_ORDER_UNF_GRN WHERE PO_NO = DTL.PO_NO AND ITEM_CODE=DTL.ITEM_CODE ) )) ITEM_QTY_NORMAL,NVL(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST,	((NVL (DTL.PO_QTY, 0) - (NVL (DTL.GRN_QTY, 0)) +  (SELECT NVL(SUM(NVL(BLOCKED_QTY,0)),0) BLOCKED_QTY FROM PO_ORDER_UNF_GRN WHERE PO_NO = DTL.PO_NO AND ITEM_CODE=DTL.ITEM_CODE )) * (NVL (DTL.ITEM_UNIT_COST, 0) * NVL (HDR.CONVERSION_RATE, 0))) ITEM_COST_VALUE, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , NVL(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,HDR.LOCAL_CURRENCY,HDR.CONVERSION_RATE,TO_CHAR(HDR.PO_DATE,'DD/MM/YYYY') PO_DATE,TO_CHAR(HDR.EXPECTED_DELV_DATE,'DD/MM/YYYY') EXPECTED_DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY , POD.DO_NO,DECODE(POD.DO_NO,'','',NVL(POH.DO_STATUS,'UF'))DO_STATUS,SUM(POD.DO_QTY_NORMAL) OVER(PARTITION BY POD.DO_NO, POD.ITEM_CODE,POD.PO_NO,POD.PO_SRL_NO)  DO_QTY_NORMAL,SUM(NVL(POD.DO_QTY_NORMAL - NVL (POD.GRN_QTY, 0),9999999)) OVER(PARTITION BY POD.DO_NO, POD.ITEM_CODE,POD.PO_NO,POD.PO_SRL_NO)-(SELECT NVL(SUM (NVL (BLOCKED_QTY, 0)),0) BLOCKED_QTY  FROM PO_ORDER_UNF_GRN  WHERE PO_NO = DTL.PO_NO  AND ITEM_CODE = DTL.ITEM_CODE  AND DO_NO=NVL (POD.DO_NO, '*A'))  AVAIL_QTY,POH.INVOICE_NO,POH.INVOICE_RECD_BY,POD.DO_QTY_BONUS, POD.DO_QTY_SAMPLE FROM PO_ORDER_HDR HDR ,PO_ORDER_FCY_DTL DTL,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1, PO_DELV_ORD_DTL_BAT POD ,PO_DELV_ORD_HDR POH WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO AND MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE AND (DTL.REQ_STORE_CODE = ? OR DTL.REQ_STORE_CODE='*A') AND (DTL.REQ_FACILITY_ID = ? OR DTL.REQ_FACILITY_ID = '*A' ) AND PO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'DD/MM/YYYY' )  AND  NVL (TO_DATE (?, 'DD/MM/YYYY'), SYSDATE) AND DTL.PO_NO = ? AND DTL.PUR_UNIT_CODE = ?  AND DTL.ITEM_CODE LIKE  ?  AND POH.DO_NO(+) = POD.DO_NO AND POH.DO_STATUS(+) IN ('FN','PR') AND POD.PO_NO(+) = DTL.PO_NO  AND POD.ITEM_CODE(+) = DTL.ITEM_CODE  AND POD.PO_SRL_NO(+) = DTL.PO_SRL_NO  AND (POD.DIST_FACILITY_ID = ? OR NVL(POD.DIST_FACILITY_ID,'*A') = '*A') AND (POD.DIST_STORE_CODE = ? OR  NVL(POD.DIST_STORE_CODE,'*A') = '*A') AND NVL(POD.DO_NO,'*A') = NVL(?,NVL(POD.DO_NO,'*A')) ) A  WHERE A.ITEM_QTY_NORMAL > 0 AND A.AVAIL_QTY > 0  AND DECODE(A.DO_NO,'','FN',A.DO_STATUS) IN ('FN','PR') ORDER BY PO_NO, ITEM_DESC, DO_NO";
			//sql1 = "SELECT * FROM (SELECT DISTINCT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (DTL.PO_QTY, 0) - (NVL (DTL.GRN_QTY, 0) + (SELECT NVL(SUM(NVL(BLOCKED_QTY,0)),0) BLOCKED_QTY FROM PO_ORDER_UNF_GRN WHERE PO_NO = DTL.PO_NO AND ITEM_CODE=DTL.ITEM_CODE ) )) ITEM_QTY_NORMAL,NVL(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST,	((NVL (DTL.PO_QTY, 0) - (NVL (DTL.GRN_QTY, 0)) +  (SELECT NVL(SUM(NVL(BLOCKED_QTY,0)),0) BLOCKED_QTY FROM PO_ORDER_UNF_GRN WHERE PO_NO = DTL.PO_NO AND ITEM_CODE=DTL.ITEM_CODE )) * (NVL (DTL.ITEM_UNIT_COST, 0) * NVL (HDR.CONVERSION_RATE, 0))) ITEM_COST_VALUE, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , NVL(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,HDR.LOCAL_CURRENCY,HDR.CONVERSION_RATE,TO_CHAR(HDR.PO_DATE,'DD/MM/YYYY') PO_DATE,TO_CHAR(HDR.EXPECTED_DELV_DATE,'DD/MM/YYYY') EXPECTED_DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY , POD.DO_NO,DECODE(POD.DO_NO,'','',NVL(POH.DO_STATUS,'UF'))DO_STATUS,SUM(POD.DO_QTY_NORMAL) OVER(PARTITION BY POD.DO_NO, POD.ITEM_CODE,POD.PO_NO,POD.PO_SRL_NO)  DO_QTY_NORMAL,SUM(NVL(POD.DO_QTY_NORMAL - NVL (POD.GRN_QTY, 0),9999999)) OVER(PARTITION BY POD.DO_NO, POD.ITEM_CODE,POD.PO_NO,POD.PO_SRL_NO)-(SELECT NVL(SUM (NVL (BLOCKED_QTY, 0)),0) BLOCKED_QTY  FROM PO_ORDER_UNF_GRN  WHERE PO_NO = DTL.PO_NO  AND ITEM_CODE = DTL.ITEM_CODE  AND DO_NO=NVL (POD.DO_NO, '*A'))  AVAIL_QTY,POH.INVOICE_NO,POH.INVOICE_RECD_BY ,SUM (NVL (POD.DO_QTY_BONUS,0)) OVER (PARTITION BY POD.DO_NO, POD.ITEM_CODE, POD.PO_NO, POD.PO_SRL_NO) DO_QTY_BONUS, SUM (NVL (POD.DO_QTY_SAMPLE,0)) OVER (PARTITION BY POD.DO_NO, POD.ITEM_CODE, POD.PO_NO, POD.PO_SRL_NO) DO_QTY_SAMPLE FROM PO_ORDER_HDR HDR ,PO_ORDER_FCY_DTL DTL,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1, PO_DELV_ORD_DTL_BAT POD ,PO_DELV_ORD_HDR POH WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO AND MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE AND (DTL.REQ_STORE_CODE = ? OR DTL.REQ_STORE_CODE='*A') AND (DTL.REQ_FACILITY_ID = ? OR DTL.REQ_FACILITY_ID = '*A' ) AND PO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'DD/MM/YYYY' )  AND  NVL (TO_DATE (?, 'DD/MM/YYYY'), SYSDATE) AND DTL.PO_NO = ? AND DTL.PUR_UNIT_CODE = ?  AND DTL.ITEM_CODE LIKE  ?  AND POH.DO_NO(+) = POD.DO_NO AND POH.DO_STATUS(+) IN ('FN','PR') AND POD.PO_NO(+) = DTL.PO_NO  AND POD.ITEM_CODE(+) = DTL.ITEM_CODE  AND POD.PO_SRL_NO(+) = DTL.PO_SRL_NO  AND (POD.DIST_FACILITY_ID = ? OR NVL(POD.DIST_FACILITY_ID,'*A') = '*A') AND (POD.DIST_STORE_CODE = ? OR  NVL(POD.DIST_STORE_CODE,'*A') = '*A') AND NVL(POD.DO_NO,'*A') = NVL(?,NVL(POD.DO_NO,'*A')) ) A  WHERE A.ITEM_QTY_NORMAL > 0 AND A.AVAIL_QTY > 0  AND DECODE(A.DO_NO,'','FN',A.DO_STATUS) IN ('FN','PR') ORDER BY PO_NO, ITEM_DESC, DO_NO";
			//commented for 41090 on 12nd Sep 2013
			//Modified for IN:071539 start
			sql1 = "SELECT * FROM (SELECT DISTINCT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (DTL.PO_QTY, 0) - (NVL (DTL.GRN_QTY, 0) + (SELECT NVL(SUM(NVL(BLOCKED_QTY,0)),0) BLOCKED_QTY FROM PO_ORDER_UNF_GRN WHERE PO_NO = DTL.PO_NO AND ITEM_CODE=DTL.ITEM_CODE ) )) ITEM_QTY_NORMAL,NVL(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST,	((NVL (DTL.PO_QTY, 0) - (NVL (DTL.GRN_QTY, 0)) +  (SELECT NVL(SUM(NVL(BLOCKED_QTY,0)),0) BLOCKED_QTY FROM PO_ORDER_UNF_GRN WHERE PO_NO = DTL.PO_NO AND ITEM_CODE=DTL.ITEM_CODE )) * (NVL (DTL.ITEM_UNIT_COST, 0) * NVL (HDR.CONVERSION_RATE, 0))) ITEM_COST_VALUE, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , NVL(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,HDR.LOCAL_CURRENCY,HDR.CONVERSION_RATE,TO_CHAR(HDR.PO_DATE,'DD/MM/YYYY') PO_DATE,TO_CHAR(HDR.EXPECTED_DELV_DATE,'DD/MM/YYYY') EXPECTED_DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY , POD.DO_NO,DECODE(POD.DO_NO,'','',NVL(POH.DO_STATUS,'UF'))DO_STATUS,SUM(POD.DO_QTY_NORMAL) OVER(PARTITION BY POD.DO_NO, POD.ITEM_CODE,POD.PO_NO,POD.PO_SRL_NO)  DO_QTY_NORMAL,SUM(NVL(POD.DO_QTY_NORMAL - NVL (POD.GRN_QTY, 0),0)) OVER(PARTITION BY POD.DO_NO, POD.ITEM_CODE,POD.PO_NO,POD.PO_SRL_NO)-(SELECT NVL(SUM (NVL (BLOCKED_QTY, 0)),0) BLOCKED_QTY  FROM PO_ORDER_UNF_GRN  WHERE PO_NO = DTL.PO_NO  AND ITEM_CODE = DTL.ITEM_CODE  AND DO_NO=NVL (POD.DO_NO, '*A'))  AVAIL_QTY,POH.INVOICE_NO,POH.INVOICE_RECD_BY ,SUM (NVL (POD.DO_QTY_BONUS,0)) OVER (PARTITION BY POD.DO_NO, POD.ITEM_CODE, POD.PO_NO, POD.PO_SRL_NO) DO_QTY_BONUS, SUM (NVL (POD.DO_QTY_SAMPLE,0)) OVER (PARTITION BY POD.DO_NO, POD.ITEM_CODE, POD.PO_NO, POD.PO_SRL_NO) DO_QTY_SAMPLE FROM PO_ORDER_HDR HDR ,PO_ORDER_FCY_DTL DTL,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1, PO_DELV_ORD_DTL_BAT POD ,PO_DELV_ORD_HDR POH WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO AND MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE AND (DTL.REQ_STORE_CODE = ? OR DTL.REQ_STORE_CODE='*A') AND (DTL.REQ_FACILITY_ID = ? OR DTL.REQ_FACILITY_ID = '*A' ) AND PO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'DD/MM/YYYY' )  AND  NVL (TO_DATE (?, 'DD/MM/YYYY'), SYSDATE) AND DTL.PO_NO = ? AND DTL.PUR_UNIT_CODE = ?  AND DTL.ITEM_CODE LIKE  ?  AND POH.DO_NO(+) = POD.DO_NO AND POH.DO_STATUS(+) IN ('FN','PR') AND POD.PO_NO(+) = DTL.PO_NO  AND POD.ITEM_CODE(+) = DTL.ITEM_CODE  AND POD.PO_SRL_NO(+) = DTL.PO_SRL_NO  AND (POD.DIST_FACILITY_ID = ? OR NVL(POD.DIST_FACILITY_ID,'*A') = '*A') AND (POD.DIST_STORE_CODE = ? OR  NVL(POD.DIST_STORE_CODE,'*A') = '*A') AND NVL(POD.DO_NO,'*A') = NVL(?,NVL(POD.DO_NO,'*A')) UNION SELECT DISTINCT dtl.pur_unit_code, dtl.po_no, dtl.po_srl_no, dtl.item_code, mmitem.short_desc item_desc,(  NVL (dtl.po_qty, 0) - (  NVL (dtl.grn_qty, 0) + (SELECT NVL(SUM (NVL (blocked_qty, 0)),0) blocked_qty  FROM po_order_unf_grn  WHERE po_no = dtl.po_no  AND item_code = dtl.item_code) )) item_qty_normal, NVL (dtl.item_unit_cost, 0) item_unit_cost,((NVL (dtl.po_qty, 0) - (NVL (dtl.grn_qty, 0)) + (SELECT NVL (SUM (NVL (blocked_qty, 0)),0) blocked_qty FROM po_order_unf_grn  WHERE po_no = dtl.po_no  AND item_code = dtl.item_code)) * (  NVL (dtl.item_unit_cost, 0) * NVL (hdr.conversion_rate, 0))) item_cost_value, stock_item_yn, po_uom pur_uom_code, am1.short_desc pur_uom_desc, am.uom_code, am.short_desc gen_uom_desc,dtl.po_gen_uom_conv_factor, dtl.po_gen_uom_qty, stitem.expiry_yn, '0' item_qty_bonus, '0' item_qty_sample,NVL (stitem.allow_decimals_yn,'N') allow_decimals_yn,hdr.trans_currency, hdr.local_currency,hdr.conversion_rate, TO_CHAR (hdr.po_date, 'DD/MM/YYYY') po_date,TO_CHAR (hdr.expected_delv_date,'DD/MM/YYYY') expected_delv_date, dtl.req_srl_no, dtl.req_no, dtl.req_facility_id, dtl.req_store_code, st.def_issue_uom, NVL (dtl.po_qty, 0) po_qty, '' do_no, '' do_status, 0 do_qty_normal,SUM (NVL (sch.DELV_QTY, 0) - (nvl(dtl.grn_qty,0)+nvl(sch.DO_BLOCKED_QTY,0))) OVER (PARTITION BY sch.po_no, sch.item_code,sch.po_srl_no) - (SELECT NVL (SUM (NVL (blocked_qty, 0)),0) blocked_qty FROM po_order_unf_grn  WHERE po_no = dtl.po_no  AND item_code = dtl.item_code) avail_qty, '' invoice_no, '' invoice_recd_by,0 do_qty_bonus,0 do_qty_sample  FROM po_order_hdr hdr,po_order_fcy_dtl dtl,po_order_delv_sch sch,mm_item_lang_vw mmitem,st_item stitem,am_uom_lang_vw am,st_item_store st, am_uom_lang_vw am1  WHERE hdr.pur_unit_code = dtl.pur_unit_code  AND hdr.po_no = dtl.po_no  AND dtl.po_no = sch.po_no  AND dtl.item_code = sch.item_code  AND DTL.PO_SRL_NO = SCH.PO_SRL_NO  AND mmitem.item_code = dtl.item_code  AND stitem.item_code = dtl.item_code  AND mmitem.gen_uom_code = am.uom_code  AND mmitem.language_id = am.language_id   AND mmitem.language_id = ?  AND am.language_id = am1.language_id  AND dtl.po_uom = am1.uom_code  AND st.item_code(+) = dtl.item_code  AND st.store_code(+) = dtl.req_store_code AND (dtl.req_store_code = ? OR dtl.req_store_code = '*A')  AND (   dtl.req_facility_id = ? OR dtl.req_facility_id = '*A') AND po_date BETWEEN TO_DATE (TO_CHAR (NVL (?,'01/01/1901')),'DD/MM/YYYY') AND NVL (TO_DATE (?, 'DD/MM/YYYY'),SYSDATE) AND dtl.po_no = ?  AND dtl.pur_unit_code = ?  AND dtl.item_code LIKE ? ) A  WHERE A.ITEM_QTY_NORMAL > 0 AND A.AVAIL_QTY > 0  AND DECODE(A.DO_NO,'','FN',A.DO_STATUS) IN ('FN','PR') ORDER BY PO_NO,";//Modified for TFS Id:-17345
			if(multi_selct_appl){
			if(sort_by.equals("ITEMCODE")){
				sql1=sql1+" ITEM_CODE, DO_NO";
			}
			else{
				sql1=sql1+" ITEM_DESC, DO_NO";
			}
			}
			else
				sql1=sql1+" ITEM_DESC, DO_NO";
			//Modified for IN:071539 end
		}

		ArrayList alExpData =  (ArrayList)bean.fetchRecords(sql1,alParameters);
		
        int alsize = alExpData.size();
		if ( alsize > 0 ){
		hmExpData.put((String)hm.get("PO_NO"),alExpData);
		j++;
		}
		else{
        alTemp.remove(j);
		total--;
		}
	}
		bean.setPoItemDetails(hmExpData);

	%>
	<base target=_self>
	</head>
<body>
	<form name= "formPOItemDetailResult">

	<table border='1' cellpadding='0' cellspacing='0' width='100%' align=center>
        <tr><th align='center' ><fmt:message key="eST.PurchaseOrderDetails.label" bundle="${st_labels}"/></th></tr>
	</table>	
	
	<input type="hidden" name="store_code" id="store_code" value="<%=store_code%>">
	<input type="hidden" name="selected_doc_no" id="selected_doc_no" value="">
	<input type="hidden" name="sel_doc_batch_count" id="sel_doc_batch_count" value="">
	<input type="hidden" name="prev_ind" id="prev_ind" value="">
	<input type="hidden" name="total" id="total" value="<%=total%>">
	<input type="hidden" name="phy_inv_id" id="phy_inv_id" value="">
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="qty_override_yn" id="qty_override_yn" value="<%=qty_override_yn%>">
	<input type="hidden" name="sys_date" id="sys_date" value="<%=com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString()%>">
	<input type="hidden" name="multi_selct_appl_chk" id="multi_selct_appl_chk" value='<%=multi_selct_appl_chk%>'><!-- Added for IN:071539 -->

	<div style="overflow:scroll;height:380px;width:100%;overflow:auto">     
	<%
	for(int k=0;k<total;k++ ){  
	hmTemp = (HashMap)alTemp.get(k);

	 pur_unit_code =	bean.checkForNull((String)hmTemp.get("PUR_UNIT_CODE"));
	 pur_unit_desc = 	(String)bean.fetchRecord("SELECT pur_unit_code,long_desc short_desc FROM po_purchase_unit	WHERE pur_unit_code=?",pur_unit_code).get("SHORT_DESC");

	 ArrayList alBatchDetails = (ArrayList)hmExpData.get((String)hmTemp.get("PO_NO"));

	 new_po_no = bean.checkForNull((String)hmTemp.get("PO_NO"));
	 
	 int batchcount =	 alBatchDetails.size();
	
	 classValue	=	"QRYODD";

	%>
	
	<table  border = '0' cellpadding='0' cellspacing='0' width='100%' align=center>
		<tr>
		<td align='left' width='20%'><input type="radio" name="doc_no_radio" id="doc_no_radio" id="doc_no_radio" value="<%=bean.checkForNull((String)hmTemp.get("PO_NO"))%>"  onClick='enable_doc(this, "<%=batchcount%>","<%=k%>","P");'  >
		<label style="font-family:verdana;font-size:10"><b><%=bean.checkForNull((String)hmTemp.get("PO_NO"))%></b></label>&nbsp;</td>

		<td width='10%'><label style="font-family:verdana;font-size:10"><b><fmt:message key="eST.PORaisedBy.label" bundle="${st_labels}" />&nbsp;:</b></label></td>
		<td><label  style="font-family:verdana;font-size:10;"><b><%=pur_unit_desc%></b></label> </td>

		<td width='10%'><label style="font-family:verdana;font-size:10"><b><fmt:message key="eST.DelDateForPendQty.label" bundle="${st_labels}" />&nbsp;:&nbsp;&nbsp;</b></label></td>
		<td class="label"><input type="text" name="next_del_date_<%=new_po_no%>" id="next_del_date_<%=new_po_no%>"  size="10" maxlength="10" onBlur="CheckDelDateWithSysdate(this,sys_date)" >&nbsp;<img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('next_del_date_<%=new_po_no%>');"></img> <span id="img_next_del_date_<%=new_po_no%>"  style="visibility:<%=img_next_del_date%>"  ><%=bean.getImage("M")%></span></td>


	    </tr>
	</table>

	<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center'>
			<tr>
               <!-- Modified for IN:071539 start -->
               <%if(multi_selct_appl){ %>
                <th nowrap> <input type="checkbox" id='doc_no1_<%=new_po_no%>'   name='doc_no1_<%=new_po_no%>' onClick='selectItems(this, "<%=batchcount%>","<%=bean.checkForNull((String)hmTemp.get("PO_NO"))%>","<%=k%>");' disabled > <fmt:message key="Common.Select.label"      bundle="${common_labels}"/></th>     
		        <th><fmt:message key="eST.ItemCode.label"        bundle="${st_labels}"/></th>
		        <%}else{ %>
		        <th><fmt:message key="Common.Select.label"      bundle="${common_labels}"/></th>
		        <%} %>
		        <!-- Modified for IN:071539 end-->
			<th><fmt:message key="Common.item.label"        bundle="${common_labels}"/></th>
		        <th><fmt:message key="eST.DoNo.label"        bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.StockUOM.label"    bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.ReqNo.label" bundle="${st_labels}"/></th>
				<!--<th colspan=2><fmt:message key="eST.RequestedQty.label" bundle="${st_labels}"/></th>-->
				<th colspan=2><fmt:message key="eST.OrderQty.label"     bundle="${st_labels}"/></th>	
				<th nowrap><fmt:message key="eST.DOQty.label"  bundle="${st_labels}"/></th>
				<th nowrap><fmt:message key="eST.BackOrderQty.label"  bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.GRNQuantity.label"   bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.ItemStoreCombination.label"   bundle="${st_labels}"/></th><!-- added for NMC-JD-CRF-0142 -->

			</tr>
			<%
		for(int i=0;i<alBatchDetails.size();i++){

		HashMap hmBatchDetails = (HashMap)alBatchDetails.get(i);
		
		String[] qtyparam = {bean.checkForNull((String)hmBatchDetails.get("REQ_FACILITY_ID")),bean.checkForNull((String)hmBatchDetails.get("REQ_NO")),bean.checkForNull((String)hmBatchDetails.get("REQ_SRL_NO"))};
	 
		temp = bean.fetchRecord("SELECT REQ_QTY,REQ_UOM  FROM PO_REQUEST_DETAIL	WHERE FACILITY_ID=? and REQ_NO = ? and REQ_SRL_NO = ? " ,qtyparam);

		req_qty = bean.checkForNull((String)temp.get("REQ_QTY"));
		req_uom = bean.checkForNull((String)temp.get("REQ_UOM"));

		st_uom_code = bean.checkForNull((String)hmBatchDetails.get("DEF_ISSUE_UOM"));
		String[] qtyparam1 = {(String)hmBatchDetails.get("ITEM_CODE"),store_code};
		if(st_uom_code.equals("")){
			temp=null;

		
			temp = bean.fetchRecord("SELECT DEF_ISSUE_UOM  FROM ST_ITEM_STORE WHERE ITEM_CODE=? and STORE_CODE = ? " ,qtyparam1);
            
			st_uom_code = bean.checkForNull((String)temp.get("DEF_ISSUE_UOM"));
		}
		
			st_uom_desc = bean.checkForNull(bean.getUOMDesc(st_uom_code));

		grn_qty_readonly = "";
		//added for NMC-JD-CRF-0142 start
		temp = bean.fetchRecord("SELECT COUNT(*) COUNT FROM ST_ITEM_STORE WHERE ITEM_CODE=? AND STORE_CODE=? " ,qtyparam1);
		int count = Integer.parseInt((String)temp.get("COUNT"));
		if(count==0){
			Item_Store_Combination="No";
			bckcolor ="background-color:pink;";
		}
		else{
			Item_Store_Combination="Yes";
			bckcolor ="";
		}
		//added for NMC-JD-CRF-0142 end

		if(bean.checkForNull((String)hmBatchDetails.get("DO_NO")).equals("")){
			receipt_qty = bean.checkForNull((String)hmBatchDetails.get("AVAIL_QTY"));
		}else{
			receipt_qty = bean.checkForNull((String)hmBatchDetails.get("AVAIL_QTY"));
			grn_qty_readonly	= "Readonly";
		}
		%>  
		 <tr  >	                                                                         
            <td class="<%=classValue%>" style='<%=bckcolor%>' width='2%'><input type="checkbox"  id='doc_no_<%=new_po_no%>_<%=i%>'   name='doc_no_<%=new_po_no%>_<%=i%>'  value="<%=new_po_no%>" onClick="getItemQty(this,'<%=i%>','P','<%=batchcount%>');MandatoryChkForDelDate('<%=batchcount%>')"  disabled  > </td>
			<!-- Added for IN:071539 start -->
			<%if(multi_selct_appl){ %>
			<td class="<%=classValue%>"  style='<%=bckcolor%>'width='25%' ><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("ITEM_CODE"))%></label>&nbsp;</td>
			<%} %>
			<!-- Added for IN:071539 end -->
			<td class="<%=classValue%>"  style='<%=bckcolor%>'width='25%' ><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("ITEM_DESC"))%></label>&nbsp;</td>
			<td class="<%=classValue%>"  style='<%=bckcolor%>'width='10%' ><label style="font-family:verdana;font-size:10" > <a href="#"  onclick='DOBatchDetails("<%=bean.checkForNull((String)hmBatchDetails.get("DO_NO"))%>","<%=bean.checkForNull((String)hmBatchDetails.get("REQ_NO"))%>","<%=bean.checkForNull((String)hmBatchDetails.get("PO_NO"))%>","<%=bean.checkForNull((String)hmBatchDetails.get("ITEM_DESC"))%>","<%=bean.checkForNull((String)hmBatchDetails.get("ITEM_CODE"))%>","<%=bean.checkForNull((String)hmBatchDetails.get("PO_SRL_NO"))%>");' ><%=bean.checkForNull((String)hmBatchDetails.get("DO_NO"))%></a> </label>&nbsp;</td>
			<td	class="<%=classValue%>"  style='<%=bckcolor%>'width='10%'><label style="font-family:verdana;font-size:10"><%=st_uom_desc%></label>&nbsp;</td>
			<td	class="<%=classValue%>"  style='<%=bckcolor%>'width='10%'><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("REQ_NO"))%></label>&nbsp;
		<!--<td class="<%=classValue%>"  width='10%' style='text-align:right;'><label  style="font-family:verdana;font-size:10;text-align:right;"><%=req_qty%></label> &nbsp;</td>
			<td	class="<%=classValue%>"  width='10%'><label style="font-family:verdana;font-size:10"><%=bean.checkForNull(bean.getUOMDesc(req_uom))%>&nbsp;</label></td>-->
			<td class="<%=classValue%>"  style='<%=bckcolor%>'width='10%' style='text-align:right;'><label  style="font-family:verdana;font-size:10;text-align:right;"><%=bean.checkForNull((String)hmBatchDetails.get("PO_QTY"))%></label> &nbsp;</td>
			<td	class="<%=classValue%>"  style='<%=bckcolor%>'width='10%'><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("PUR_UOM_DESC"))%></label>
			<td class="<%=classValue%>"  style='<%=bckcolor%>'width='10%' style='text-align:right;'><label  style="font-family:verdana;font-size:10;text-align:right;">
			<% 
				if(!bean.checkForNull((String)hmBatchDetails.get("DO_NO")).equals("")){
			%>
				<%=bean.checkForNull((String)hmBatchDetails.get("DO_QTY_NORMAL"))%>
			<%
				}
			%>				
			</label> &nbsp;</td>
<!--		<td class="<%=classValue%>"  width='10%' style='text-align:right;'><label  style="font-family:verdana;font-size:10;text-align:right;"><%=bean.checkForNull((String)hmBatchDetails.get("ITEM_QTY_NORMAL"))%></label> &nbsp;</td>-->
			<td class="<%=classValue%>"  style='<%=bckcolor%>' width='10%' style='text-align:right;'><label  style="font-family:verdana;font-size:10;text-align:right;"><%=receipt_qty%></label> &nbsp;</td>
			<td class="<%=classValue%>" style='<%=bckcolor%>' ><input style='text-align:right;' type="text" id='grn_item_qty_<%=i%>' name='grn_item_qty_<%=new_po_no%>_<%=i%>'  size="10" maxlength="10" onKeyPress="return isValidNumberforMultiLine(this,event,8,<%=no_deci%>,allow_deci_<%=new_po_no%>_<%=i%>);" onBlur="checkDoubleFormat(this);MandatoryChkForDelDate('<%=batchcount%>')"  disabled  <%=grn_qty_readonly%> >  </td>
            <td class="<%=classValue%>" style='<%=bckcolor%>' ><%=Item_Store_Combination%></td>
            
			<input type="hidden" name='item_code_<%=new_po_no%>_<%=i%>' id='item_code_<%=new_po_no%>_<%=i%>'       value="<%=bean.checkForNull((String)hmBatchDetails.get("ITEM_CODE"))%>">
			<input type="hidden" name='req_no_<%=new_po_no%>_<%=i%>' id='req_no_<%=new_po_no%>_<%=i%>'          value="<%=bean.checkForNull((String)hmBatchDetails.get("REQ_NO"))%>">
			<input type="hidden" name='req_qty_<%=new_po_no%>_<%=i%>' id='req_qty_<%=new_po_no%>_<%=i%>' 		  value="<%=req_qty%>">
		<!--<input type="hidden" name='po_qty_<%=new_po_no%>_<%=i%>' id='po_qty_<%=new_po_no%>_<%=i%>' 		  value="<%=bean.checkForNull((String)hmBatchDetails.get("ITEM_QTY_NORMAL"))%>">-->
			<input type="hidden" name='po_qty_<%=new_po_no%>_<%=i%>' id='po_qty_<%=new_po_no%>_<%=i%>' 		  value="<%=receipt_qty%>">
			<input type="hidden" name='pur_unit_code_<%=new_po_no%>_<%=i%>' id='pur_unit_code_<%=new_po_no%>_<%=i%>'   value="<%=pur_unit_code%>">	
			<input type="hidden" name='local_currency_<%=new_po_no%>_<%=i%>' id='local_currency_<%=new_po_no%>_<%=i%>'  value="<%=bean.checkForNull((String)hmBatchDetails.get("LOCAL_CURRENCY"))%>">	
			<input type="hidden" name='trans_currency_<%=new_po_no%>_<%=i%>' id='trans_currency_<%=new_po_no%>_<%=i%>'  value="<%=bean.checkForNull((String)hmBatchDetails.get("TRANS_CURRENCY"))%>">	
			<input type="hidden" name='conversion_rate_<%=new_po_no%>_<%=i%>' id='conversion_rate_<%=new_po_no%>_<%=i%>' value="<%=bean.checkForNull((String)hmBatchDetails.get("CONVERSION_RATE"))%>">	
			<input type="hidden" name='allow_deci_<%=new_po_no%>_<%=i%>' id='allow_deci_<%=new_po_no%>_<%=i%>' 	  value="<%=bean.checkForNull((String)hmBatchDetails.get("ALLOW_DECIMALS_YN"),"N")%>">				
			<input type="hidden" name='do_no_<%=new_po_no%>_<%=i%>' id='do_no_<%=new_po_no%>_<%=i%>' 		  value="<%=bean.checkForNull((String)hmBatchDetails.get("DO_NO"))%>">				
			<input type="hidden" name='invoice_no_<%=new_po_no%>_<%=i%>' id='invoice_no_<%=new_po_no%>_<%=i%>' 		  value="<%=bean.checkForNull((String)hmBatchDetails.get("INVOICE_NO"))%>">				
			<input type="hidden" name='invoice_received_by_<%=new_po_no%>_<%=i%>' id='invoice_received_by_<%=new_po_no%>_<%=i%>' 		  value="<%=bean.checkForNull((String)hmBatchDetails.get("INVOICE_RECD_BY"))%>">				
			
		</tr>
	<%}%>
		<tr> 	    
		<td class="<%=classValue%>"  colspan="12" style="text-align:right"> <input align="right" type=button name='apply_<%=new_po_no%>' id='apply_<%=new_po_no%>'   value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>'    align='right' class=button onclick="onadd('<%=batchcount%>');"  disabled >	 </td><!-- Modified for IN:071539 end-->
		</tr>
	</table>
 
	<%
	}
	%>
	</div>
	</form>

	</body>
</html>

