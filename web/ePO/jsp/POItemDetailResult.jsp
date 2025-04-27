<!DOCTYPE html>
<%@ page import=" ePO.*,ePO.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%>
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
		<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../ePO/js/PoMessages.js"></script>
		<script language="JavaScript" src="../../ePO/js/DeliveryOrder.js"></script>
    	<script language='javascript' src='../../ePO/js/PoTransaction.js'></script>
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
	String po_mode				= "";
	String tran_currency 		= "";
	String img_next_del_date		=	"hidden";
	

	bean_id                     = "deliveryOrderBean" ;
	bean_name                   = "ePO.DeliveryOrderBean";

    
	DeliveryOrderBean bean = (DeliveryOrderBean) getBeanObject( bean_id, bean_name,request );


	store_code           =  bean.checkForNull(request.getParameter("store_code"),"BANK");
	
	item_code            =  request.getParameter("item_desc").equals("")? "%": request.getParameter("item_code");
	from_doc_date        =  bean.checkForNull(request.getParameter("from_doc_date"),"");
	to_doc_date          =  bean.checkForNull(request.getParameter("to_doc_date"),"");	
	po_number            =  bean.checkForNull(request.getParameter("doc_no"),"%");
	supp_code            =  bean.checkForNull(request.getParameter("supp_code1"));
	pur_unit_code        =  bean.checkForNull(request.getParameter("purchase_unit"),"%");
	po_mode       		 =  bean.checkForNull(request.getParameter("po_mode"));
	mode				 =  bean.checkForNull(request.getParameter("mode"));
	tran_currency		 =	bean.checkForNull(request.getParameter("tran_currency"),"%");
	
	String tran_currency_temp								   =	   bean.checkForNull(request.getParameter("tran_currency_temp"));
	
	int no_deci                   =    bean.getNoOfDecimals();

	
	
	
	 
		
//	HashMap PO_Override			=	bean.fetchRecord(bean.getStRepositoryValue("SQL_PO_PARAMETER_OVERRIDE_ALLOW"));

//	String qty_override_yn		=	bean.checkForNull((String)PO_Override.get("ALLOW_QTY_OVERRIDE_IN_GRN"),"N");

//	String []stParameters = {store_code,facility_id,supp_code,from_doc_date,to_doc_date,po_number,pur_unit_code,item_code};
	String []stParameters = {facility_id,supp_code,from_doc_date,to_doc_date,po_number,pur_unit_code,item_code,po_mode,tran_currency};
	
	
	
//	String sql= "SELECT DISTINCT DTL.PUR_UNIT_CODE,DTL.PO_NO  FROM po_order_hdr HDR ,po_order_fcy_dtl DTL WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A') and HDR.SUPP_CODE = ? AND  HDR.PO_STATUS in ('FA','RA','PD')  AND PO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )  AND  NVL (TO_DATE (?, 'dd/mm/yyyy'), SYSDATE) AND DTL.PO_NO like ? and DTL.PUR_UNIT_CODE like ?  and dtl.item_code  like  ? and (NVL(DTL.PO_QTY,0)-NVL(DTL.GRN_QTY,0)) > 0  ORDER BY 2";

//	String sql= "SELECT DISTINCT DTL.PUR_UNIT_CODE,DTL.PO_NO,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE,to_char(HDR.EXPECTED_DELV_DATE,'dd/mm/yyyy') EXPECTED_DELV_DATE  FROM po_order_hdr HDR ,po_order_fcy_dtl DTL WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO /* AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') */ AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A') and HDR.SUPP_CODE = ? AND  HDR.PO_STATUS in ('FA','RA','PD')  AND EXPECTED_DELV_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )  AND  NVL (TO_DATE (?, '31/01/2999') ) AND DTL.PO_NO like ? and DTL.PUR_UNIT_CODE like ?  and dtl.item_code  like  ? and (NVL(DTL.PO_QTY,0)-NVL(DTL.GRN_QTY,0)) > 0  ORDER BY 2";
	
	String sql = "SELECT DISTINCT DTL.PO_NO , DTL.PUR_UNIT_CODE,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE, HDR.PO_ORDER_MODE,HDR.TRANS_CURRENCY FROM po_order_hdr HDR ,po_order_fcy_dtl DTL, PO_ORDER_DELV_SCH delv WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A') and HDR.SUPP_CODE = ?   AND  HDR.PO_STATUS in ('FA','RA','PD','PR')  AND DELV.DELV_STATUS IN ('PD','ND','CD') AND DELV_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )  AND  TO_DATE (TO_CHAR (NVL (?, '01/01/2999' ) ), 'dd/mm/yyyy' ) AND DTL.PO_NO like ? and DTL.PUR_UNIT_CODE like ?  and dtl.item_code  like  ?  AND HDR.PO_ORDER_MODE = ? AND delv.PO_NO = DTL.PO_NO AND delv.ITEM_CODE = DTL.ITEM_CODE AND delv.PO_SRL_NO = DTL.PO_SRL_NO and (NVL(delv.DELV_QTY,0)-NVL(delv.DELIVERED_QTY,0) ) > 0  and HDR.TRANS_CURRENCY  like ? ORDER BY 2";
 
	ArrayList alTemp = new ArrayList();
	HashMap hmExpData = new HashMap();
	HashMap hmTemp = null;
	HashMap temp = null;

	alTemp =  bean.fetchRecords(sql,stParameters);
	
	int total = alTemp.size();	
/*	if(total ==0){
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
			</script>
		<%		
	}
*/	
	
	for(int j=0;j<total;){		

		HashMap hm = (HashMap)alTemp.get(j);
		
	
		
	//	String []stParameters1 = {locale,store_code,facility_id,from_doc_date,to_doc_date,(String)hm.get("PO_NO"),(String)hm.get("PUR_UNIT_CODE"),item_code};
		String []stParameters1 = {locale,locale,facility_id,from_doc_date,to_doc_date,(String)hm.get("PO_NO"),(String)hm.get("PUR_UNIT_CODE"),item_code,(String)hm.get("TRANS_CURRENCY")};

		String sql1 = "";

		if(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))){

		//	sql1 = "select * from (SELECT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (dtl.po_qty, 0) - (NVL (dtl.grn_qty, 0) + (select nvl(sum(nvl(blocked_qty,0)),0) blocked_qty from po_order_unf_grn where po_no = dtl.po_no and item_code=dtl.item_code  and (req_no=dtl.req_no or req_no = '*A') and (facility_id !='"+facility_id+"' or grn_doc_type_code!='"+bean.getDoc_type_code()+"' or grn_no!='"+bean.getDoc_no()+"')))) item_qty_normal,nvl(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST,	((NVL (dtl.po_qty, 0) - (NVL (dtl.grn_qty, 0)) +  (select nvl(sum(nvl(blocked_qty,0)),0) blocked_qty from po_order_unf_grn where po_no = dtl.po_no and item_code=dtl.item_code and (req_no=dtl.req_no or req_no = '*A') and ( facility_id !='"+facility_id+"' or grn_doc_type_code!= '"+bean.getDoc_type_code()+"' or grn_no!='"+bean.getDoc_no()+"'))) * (NVL (dtl.item_unit_cost, 0) * NVL (hdr.conversion_rate, 0))) item_cost_value, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , nvl(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,hdr.LOCAL_CURRENCY,hdr.CONVERSION_RATE,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE,to_char(HDR.EXPECTED_DELV_DATE,'dd/mm/yyyy') EXPECTED_DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY  FROM po_order_hdr HDR ,po_order_fcy_dtl DTL,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1  WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO and MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A' ) AND PO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )  AND  NVL (TO_DATE (?, 'dd/mm/yyyy'), SYSDATE) AND DTL.PO_NO = ? and DTL.PUR_UNIT_CODE = ?  and dtl.item_code like  ? ) a  where a.item_qty_normal > 0 order by 2";
		
		//sql1 = "select * from (SELECT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (delv.DELV_QTY, 0) - (NVL (delv.DELIVERED_QTY, 0) + NVL (delv.DO_BLOCKED_QTY, 0) )) item_qty_normal,nvl(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST, nvl(DTL.ITEM_NET_VALUE,0) ITEM_NET_VALUE, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , nvl(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,hdr.LOCAL_CURRENCY,hdr.CONVERSION_RATE,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE,to_char(delv.DELV_DATE,'dd/mm/yyyy') DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY, ((NVL(delv.DELV_QTY,0)-NVL(delv.DELIVERED_QTY,0)- NVL(delv.DO_BLOCKED_QTY,0)) ) delv_qty,delv.DELV_SRL_NO, DTL.PO_LINE_REMARKS  FROM po_order_hdr HDR ,po_order_fcy_dtl DTL,PO_ORDER_DELV_SCH delv,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1  WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO and MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE /*AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') */AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A' )  AND DELV_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )   AND TO_DATE (TO_CHAR (NVL (?, '01/01/2999' ) ), 'dd/mm/yyyy' ) and (NVL(delv.DELV_QTY,0)-NVL(delv.DELIVERED_QTY,0) ) > 0 AND DTL.PO_NO = ? and DTL.PUR_UNIT_CODE = ? AND delv.PO_NO = DTL.PO_NO AND delv.ITEM_CODE = DTL.ITEM_CODE AND delv.PO_SRL_NO = DTL.PO_SRL_NO  and dtl.item_code like  ? and HDR.TRANS_CURRENCY like  ? ) a  where a.item_qty_normal > 0 order by 2";

		//sql1 = "select * from (SELECT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (delv.DELV_QTY, 0) - (NVL (delv.DELIVERED_QTY, 0) + NVL (delv.DO_BLOCKED_QTY, 0) )) item_qty_normal,nvl(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST, nvl(DTL.ITEM_NET_VALUE,0) ITEM_NET_VALUE, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , nvl(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,hdr.LOCAL_CURRENCY,hdr.CONVERSION_RATE,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE,to_char(delv.DELV_DATE,'dd/mm/yyyy') DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY, (NVL(delv.DELV_QTY,0)-( NVL (delv.delivered_qty, 0) - nvl(DELVBAT.GRN_QTY,0)) - NVL(delv.DO_BLOCKED_QTY,0) - NVL (dtl.grn_qty, 0) )  delv_qty,delv.DELV_SRL_NO, DTL.PO_LINE_REMARKS,(select SHORT_DESC from po_purchase_unit_lang_vw where PUR_UNIT_CODE=DTL.PUR_UNIT_CODE and language_id=?) PUR_UNIT_DESC  FROM po_order_hdr HDR ,po_order_fcy_dtl DTL,PO_ORDER_DELV_SCH delv,PO_DELV_ORD_DTL_BAT DELVBAT,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1  WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO and MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE /*AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') */AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A' )  AND DELV_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )   AND TO_DATE (TO_CHAR (NVL (?, '01/01/2999' ) ), 'dd/mm/yyyy' ) and (NVL(delv.DELV_QTY,0)-NVL(delv.DELIVERED_QTY,0) ) > 0 AND DTL.PO_NO = ? and DTL.PUR_UNIT_CODE = ? AND delv.PO_NO = DTL.PO_NO AND delv.ITEM_CODE = DTL.ITEM_CODE AND delv.PO_SRL_NO = DTL.PO_SRL_NO AND DELVBAT.item_code (+)= DTL.item_code  AND DELVBAT.po_no(+) = DTL.po_no  and dtl.item_code like  ? and HDR.TRANS_CURRENCY like  ? ) a  where a.item_qty_normal > 0 AND a.delv_qty>0 order by 2";
		// Added condition SUM(NVL (DELVBAT.GRN_QTY, 0)) OVER(PARTITION BY DELVBAT.PO_NO,DELVBAT.ITEM_CODE) against INC#41091
		sql1 = "select * from (SELECT distinct DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (delv.DELV_QTY, 0) - (NVL (delv.DELIVERED_QTY, 0) + NVL (delv.DO_BLOCKED_QTY, 0) )) item_qty_normal,nvl(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST, nvl(DTL.ITEM_NET_VALUE,0) ITEM_NET_VALUE, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , nvl(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,hdr.LOCAL_CURRENCY,hdr.CONVERSION_RATE,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE,to_char(delv.DELV_DATE,'dd/mm/yyyy') DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY, (NVL(delv.DELV_QTY,0)-( NVL (delv.delivered_qty, 0) - SUM(NVL (DELVBAT.GRN_QTY, 0)) OVER(PARTITION BY DELVBAT.PO_NO,DELVBAT.ITEM_CODE) ) - NVL(delv.DO_BLOCKED_QTY,0) - NVL (dtl.grn_qty, 0) )  delv_qty,delv.DELV_SRL_NO, DTL.PO_LINE_REMARKS,(select SHORT_DESC from po_purchase_unit_lang_vw where PUR_UNIT_CODE=DTL.PUR_UNIT_CODE and language_id=?) PUR_UNIT_DESC  FROM po_order_hdr HDR ,po_order_fcy_dtl DTL,PO_ORDER_DELV_SCH delv,PO_DELV_ORD_DTL_BAT DELVBAT,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1  WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO and MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE /*AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') */AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A' )  AND DELV_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )   AND TO_DATE (TO_CHAR (NVL (?, '01/01/2999' ) ), 'dd/mm/yyyy' ) and (NVL(delv.DELV_QTY,0)-NVL(delv.DELIVERED_QTY,0) ) > 0 AND DTL.PO_NO = ? and DTL.PUR_UNIT_CODE = ? AND delv.PO_NO = DTL.PO_NO AND delv.ITEM_CODE = DTL.ITEM_CODE AND delv.PO_SRL_NO = DTL.PO_SRL_NO AND DELVBAT.item_code (+)= DTL.item_code  AND DELVBAT.po_no(+) = DTL.po_no  and dtl.item_code like  ? and HDR.TRANS_CURRENCY like  ? ) a  where a.item_qty_normal > 0 AND a.delv_qty>0 order by 2";
		
		}else{
				
		//	sql1 = "select * from (SELECT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (dtl.po_qty, 0) - (NVL (dtl.grn_qty, 0) + (select nvl(sum(nvl(blocked_qty,0)),0) blocked_qty from po_order_unf_grn where po_no = dtl.po_no and item_code=dtl.item_code ) )) item_qty_normal,nvl(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST,	((NVL (dtl.po_qty, 0) - (NVL (dtl.grn_qty, 0)) +  (select nvl(sum(nvl(blocked_qty,0)),0) blocked_qty from po_order_unf_grn where po_no = dtl.po_no and item_code=dtl.item_code )) * (NVL (dtl.item_unit_cost, 0) * NVL (hdr.conversion_rate, 0))) item_cost_value, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , nvl(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,hdr.LOCAL_CURRENCY,hdr.CONVERSION_RATE,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE,to_char(HDR.EXPECTED_DELV_DATE,'dd/mm/yyyy') EXPECTED_DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY  FROM po_order_hdr HDR ,po_order_fcy_dtl DTL,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1  WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO and MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE  AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A' ) AND EXPECTED_DELV_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )  AND  NVL (TO_DATE (?, 'dd/mm/yyyy'), SYSDATE) AND DTL.PO_NO = ? and DTL.PUR_UNIT_CODE = ?  and dtl.item_code like  ? ) a  where a.item_qty_normal > 0 order by 2"; 
			
		
			
			//sql1 = "select * from (SELECT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (delv.DELV_QTY, 0) - (NVL (delv.DELIVERED_QTY, 0) + NVL (delv.DO_BLOCKED_QTY, 0) )) item_qty_normal,nvl(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST, nvl(DTL.ITEM_NET_VALUE,0) ITEM_NET_VALUE, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , nvl(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,hdr.LOCAL_CURRENCY,hdr.CONVERSION_RATE,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE,to_char(delv.DELV_DATE,'dd/mm/yyyy') DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY, (NVL(delv.DELV_QTY,0)-NVL(delv.DELIVERED_QTY,0) - NVL(delv.DO_BLOCKED_QTY,0) )  delv_qty,delv.DELV_SRL_NO, DTL.PO_LINE_REMARKS  FROM po_order_hdr HDR ,po_order_fcy_dtl DTL,PO_ORDER_DELV_SCH delv,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1  WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO and MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE /*AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') */AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A' )  AND DELV_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )   AND  TO_DATE (TO_CHAR (NVL (?, '01/01/2999' ) ), 'dd/mm/yyyy' ) and (NVL(delv.DELV_QTY,0)-NVL(delv.DELIVERED_QTY,0) ) > 0 AND DTL.PO_NO = ? and DTL.PUR_UNIT_CODE = ? AND delv.PO_NO = DTL.PO_NO AND delv.ITEM_CODE = DTL.ITEM_CODE AND delv.PO_SRL_NO = DTL.PO_SRL_NO  and dtl.item_code like  ? and HDR.TRANS_CURRENCY like  ? ) a  where a.item_qty_normal > 0 order by 2";

			//sql1 = "select * from (SELECT distinct DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (delv.DELV_QTY, 0) - (NVL (delv.DELIVERED_QTY, 0) + NVL (delv.DO_BLOCKED_QTY, 0) )) item_qty_normal,nvl(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST, nvl(DTL.ITEM_NET_VALUE,0) ITEM_NET_VALUE, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , nvl(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,hdr.LOCAL_CURRENCY,hdr.CONVERSION_RATE,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE,to_char(delv.DELV_DATE,'dd/mm/yyyy') DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY, (NVL(delv.DELV_QTY,0)-( NVL (delv.delivered_qty, 0) - nvl(DELVBAT.GRN_QTY,0)) - NVL(delv.DO_BLOCKED_QTY,0) - NVL (dtl.grn_qty, 0) )  delv_qty, delv.DELV_SRL_NO, DTL.PO_LINE_REMARKS,(select SHORT_DESC from po_purchase_unit_lang_vw where PUR_UNIT_CODE=DTL.PUR_UNIT_CODE and language_id=?) PUR_UNIT_DESC  FROM po_order_hdr HDR ,po_order_fcy_dtl DTL,PO_ORDER_DELV_SCH delv,PO_DELV_ORD_DTL_BAT DELVBAT,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1  WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO and MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE /*AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') */AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A' )  AND DELV_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )   AND  TO_DATE (TO_CHAR (NVL (?, '01/01/2999' ) ), 'dd/mm/yyyy' ) and (NVL(delv.DELV_QTY,0)-NVL(delv.DELIVERED_QTY,0) ) > 0 AND DTL.PO_NO = ? and DTL.PUR_UNIT_CODE = ? AND delv.PO_NO = DTL.PO_NO AND delv.ITEM_CODE = DTL.ITEM_CODE AND delv.PO_SRL_NO = DTL.PO_SRL_NO  AND DELVBAT.item_code (+)= DTL.item_code  AND DELVBAT.po_no(+) = DTL.po_no  and dtl.item_code like  ? and HDR.TRANS_CURRENCY like  ? ) a  where a.item_qty_normal > 0 AND A.delv_qty>0 order by 2";

			// Added condition SUM(NVL (DELVBAT.GRN_QTY, 0)) OVER(PARTITION BY DELVBAT.PO_NO,DELVBAT.ITEM_CODE) against INC#41091
			sql1 = "select * from (SELECT distinct DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (delv.DELV_QTY, 0) - (NVL (delv.DELIVERED_QTY, 0) + NVL (delv.DO_BLOCKED_QTY, 0) )) item_qty_normal,nvl(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST, nvl(DTL.ITEM_NET_VALUE,0) ITEM_NET_VALUE, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , nvl(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,hdr.LOCAL_CURRENCY,hdr.CONVERSION_RATE,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE,to_char(delv.DELV_DATE,'dd/mm/yyyy') DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY, (NVL(delv.DELV_QTY,0)-( NVL (delv.delivered_qty, 0) - SUM(NVL (DELVBAT.GRN_QTY, 0)) OVER(PARTITION BY DELVBAT.PO_NO,DELVBAT.ITEM_CODE) ) - NVL(delv.DO_BLOCKED_QTY,0) - NVL (dtl.grn_qty, 0) )  delv_qty, delv.DELV_SRL_NO, DTL.PO_LINE_REMARKS,(select SHORT_DESC from po_purchase_unit_lang_vw where PUR_UNIT_CODE=DTL.PUR_UNIT_CODE and language_id=?) PUR_UNIT_DESC  FROM po_order_hdr HDR ,po_order_fcy_dtl DTL,PO_ORDER_DELV_SCH delv,PO_DELV_ORD_DTL_BAT DELVBAT,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1  WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO and MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE /*AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') */AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A' )  AND DELV_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )   AND  TO_DATE (TO_CHAR (NVL (?, '01/01/2999' ) ), 'dd/mm/yyyy' ) and (NVL(delv.DELV_QTY,0)-NVL(delv.DELIVERED_QTY,0) ) > 0 AND DTL.PO_NO = ? and DTL.PUR_UNIT_CODE = ? AND delv.PO_NO = DTL.PO_NO AND delv.ITEM_CODE = DTL.ITEM_CODE AND delv.PO_SRL_NO = DTL.PO_SRL_NO  AND DELVBAT.item_code (+)= DTL.item_code  AND DELVBAT.po_no(+) = DTL.po_no  and dtl.item_code like  ? and HDR.TRANS_CURRENCY like  ? ) a  where a.item_qty_normal > 0 AND A.delv_qty>0 order by 2";
		}
		


		ArrayList alExpData =  (ArrayList)bean.fetchRecords(sql1,stParameters1);
		
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
	
	int total_hm = hmExpData.size();	
	if(total_hm == 0 || total == 0){
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
			</script>
		<%		
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
	<input type="hidden" name="qty_override_yn" id="qty_override_yn" value="">
	<input type="hidden" name="sys_date" id="sys_date" value="<%=com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString()%>">
        
	<%
	for(int k=0;k<total;k++ ){  
	hmTemp = (HashMap)alTemp.get(k);
	
	 pur_unit_code =	bean.checkForNull((String)hmTemp.get("PUR_UNIT_CODE"));
	 pur_unit_desc = 	(String)bean.fetchRecord("SELECT pur_unit_code,long_desc short_desc FROM po_purchase_unit	WHERE pur_unit_code=?",pur_unit_code).get("SHORT_DESC");

	 ArrayList alBatchDetails = (ArrayList)hmExpData.get((String)hmTemp.get("PO_NO"));

	 new_po_no = bean.checkForNull((String)hmTemp.get("PO_NO"));
	 
	 int batchcount =	 alBatchDetails.size();
	
	 classValue	=	"QRYODD";
	 
	po_mode =  bean.checkForNull((String)hmTemp.get("PO_ORDER_MODE"));
	if(po_mode.equals("D"))
		po_mode = "Direct Order";
	else{
		po_mode = "Order Based On Request";
	}	
	
	String dflt_currency =	 bean.checkForNull((String)hmTemp.get("TRANS_CURRENCY"));
	String dflt_currency_desc = bean.checkForNull((String)bean.fetchRecord("SELECT currency_code, short_desc FROM sy_foreign_currency_lang_vw WHERE language_id = ? and currency_code = ? ORDER BY 2",new String[]{locale,dflt_currency}).get("SHORT_DESC"),"");

	%>
	
	<table  border = '0' cellpadding='0' cellspacing='0' width='100%' align=center>
		
	
		<tr>
		<td align='left' width='20%'><input type="checkbox" name="doc_no_check_<%=k%>" id="doc_no_check_<%=k%>" id="doc_no_check_<%=k%>" value="<%=bean.checkForNull((String)hmTemp.get("PO_NO"))%>"  onClick='enable_doc(this, "<%=batchcount%>","<%=k%>");'  >
		<label style="font-family:verdana;font-size:10"><b><%=bean.checkForNull((String)hmTemp.get("PO_NO"))%></b></label>&nbsp;</td>

		<td width='10%'><label style="font-family:verdana;font-size:10"><b><fmt:message key="ePO.PODate.label" bundle="${po_labels}" />&nbsp;:</b></label></td>
		<td><label style="font-family:verdana;font-size:10"><b><%=bean.checkForNull((String)hmTemp.get("PO_DATE"))%></b></label></td>
		
		<td width='10%'><label style="font-family:verdana;font-size:10"><b><fmt:message key="ePO.PORaisedBy.label" bundle="${po_labels}" />&nbsp;:</b></label></td>
		<td><label style="font-family:verdana;font-size:10"><b><%=pur_unit_desc%></b></label></td>
		
		<td width='10%'><label style="font-family:verdana;font-size:10"><b><fmt:message key="ePO.Currency.label" bundle="${po_labels}" />&nbsp;:</b></label></td>
		<td><label style="font-family:verdana;font-size:10"><b><%=dflt_currency_desc%></b></label></td>
				
		<td class="label" width='5%'> 
				<!--	<input align="right" type=button name="Add" id="Add"   value='  Add  '  onclick="onadd();"  >	        -->
				</td>	
					<input type="hidden" name='batchcount_<%=new_po_no%>_<%=k%>' id='batchcount_<%=new_po_no%>_<%=k%>' id='batchcount_<%=new_po_no%>_<%=k%>' value="<%=batchcount%>">

	    </tr>
	</table>
	
	<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center'>
			<tr>
                <th><fmt:message key="Common.Select.label"      bundle="${common_labels}"/> <input type="checkbox" name="doc_no_select_<%=k%>" id="doc_no_select_<%=k%>" id="doc_no_select_<%=k%>" value="<%=bean.checkForNull((String)hmTemp.get("PO_NO"))%>"  onClick='enable_all_doc(this, "<%=batchcount%>");'  disabled ></th>
				<th><fmt:message key="ePO.ScheduledDate.label" bundle="${po_labels}" /></th>
		        <th><fmt:message key="ePO.itemDesc.label"        bundle="${po_labels}"/></th>
				<th><fmt:message key="ePO.RequestNo.label"        bundle="${po_labels}"/></th>
				<th><fmt:message key="ePO.pendingPoQty.label"     bundle="${po_labels}"/></th>				
				<th><fmt:message key="ePO.POUOM.label"     bundle="${po_labels}"/></th>				
				<th><fmt:message key="ePO.Store.label"     bundle="${po_labels}"/></th>				
				<th><fmt:message key="ePO.Facility.label"     bundle="${po_labels}"/></th>				
			</tr>
			<%
		for(int i=0;i<alBatchDetails.size();i++){

		HashMap hmBatchDetails = (HashMap)alBatchDetails.get(i);
		
		
		
	/*	int delv_qty = 0 ;
		for(int j=i+1;j<alBatchDetails.size();j++){
			HashMap hmBatchDetails1 = (HashMap)alBatchDetails.get(j);
			
			if( (hmBatchDetails.get("ITEM_CODE").equals(hmBatchDetails1.get("ITEM_CODE"))) && (hmBatchDetails.get("DELV_DATE").equals(hmBatchDetails1.get("DELV_DATE")))){
			
			 delv_qty = Integer.parseInt((String)hmBatchDetails.get("DELV_QTY")) + Integer.parseInt((String)hmBatchDetails1.get("DELV_QTY"));
			
			 String s = new Integer(delv_qty).toString();
			 hmBatchDetails.put("DELV_QTY",s);
			 alBatchDetails.remove(j);
			}
		}
	*/	

		/*String[] qtyparam = {bean.checkForNull((String)hmBatchDetails.get("REQ_FACILITY_ID")),bean.checkForNull((String)hmBatchDetails.get("REQ_NO")),bean.checkForNull((String)hmBatchDetails.get("REQ_SRL_NO"))};
	 
		temp = bean.fetchRecord("SELECT REQ_QTY,REQ_UOM  FROM PO_REQUEST_DETAIL	WHERE FACILITY_ID=? and REQ_NO = ? and REQ_SRL_NO = ? " ,qtyparam);

		req_qty = bean.checkForNull((String)temp.get("REQ_QTY"));
		req_uom = bean.checkForNull((String)temp.get("REQ_UOM"));

		st_uom_code = bean.checkForNull((String)hmBatchDetails.get("DEF_ISSUE_UOM"));

			if(st_uom_code.equals("")){
			temp=null;

			String[] qtyparam1 = {(String)hmBatchDetails.get("ITEM_CODE"),store_code};
			temp = bean.fetchRecord("SELECT DEF_ISSUE_UOM  FROM ST_ITEM_STORE WHERE ITEM_CODE=? and STORE_CODE = ? " ,qtyparam1);

			st_uom_code = bean.checkForNull((String)temp.get("DEF_ISSUE_UOM"));
			}
		
			st_uom_desc = bean.checkForNull(bean.getUOMDesc(st_uom_code));
		*/	
			
			ArrayList alStoreList = new ArrayList();
			String st_code = bean.checkForNull((String)hmBatchDetails.get("REQ_STORE_CODE"));
			
			if(st_code.equals("*A"))
				st_code = "ALL";
			else {
			
				st_code =	bean.checkForNull((String)hmBatchDetails.get("REQ_STORE_CODE"));
				alStoreList.add(st_code);
				alStoreList.add(bean.getLanguageId());
				st_code = 	(String)bean.fetchRecord("SELECT STORE_CODE,long_desc short_desc FROM MM_STORE_LANG_VW	WHERE STORE_CODE=? AND LANGUAGE_ID=?",alStoreList).get("SHORT_DESC");
			}
			
			ArrayList alFacilityList = new ArrayList();
			String facility_code = bean.checkForNull((String)hmBatchDetails.get("REQ_FACILITY_ID"));
			
			if(facility_code.equals("*A"))
				facility_code = "ALL";
			else {
			
				facility_code =	bean.checkForNull((String)hmBatchDetails.get("REQ_FACILITY_ID"));
				alFacilityList.add(facility_code);
				alFacilityList.add(bean.getLanguageId());
				facility_code = 	(String)bean.fetchRecord("SELECT FACILITY_ID, FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW  WHERE FACILITY_ID = ? and LANGUAGE_ID=?",alFacilityList).get("FACILITY_NAME");
			}
			
				
				
		%>
		 <tr>	                                                                         
            <td class="<%=classValue%>"  style="font-family:verdana;font-size:10;text-align:right;" width='5%'><input type="checkbox"  id='doc_no_<%=new_po_no%>_<%=i%>'   name='doc_no_<%=new_po_no%>_<%=i%>'  value="<%=new_po_no%>" onClick="" disabled > </td>
			<td	class="<%=classValue%>"  width='10%'><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("DELV_DATE"))%></label></td>
			<td class="<%=classValue%>"  width='30%' ><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("ITEM_DESC"))%></label>&nbsp;</td>
			
			<td class="<%=classValue%>"  width='10%' style='text-align:right;'><label  style="font-family:verdana;font-size:10;text-align:right;"><%=bean.checkForNull((String)hmBatchDetails.get("REQ_NO"))%></label> &nbsp;</td>
			<td class="<%=classValue%>"  width='10%' style='text-align:right;'><label  style="font-family:verdana;font-size:10;text-align:right;"><%=bean.checkForNull((String)hmBatchDetails.get("DELV_QTY"))%></label> &nbsp;</td>
		
			<td	class="<%=classValue%>"  width='10%'><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("PUR_UOM_DESC"))%></label></td>
			
			<td	class="<%=classValue%>"  width='10%'><label style="font-family:verdana;font-size:10"><%=st_code%></label></td>
			
			<td	class="<%=classValue%>"  width='10%'><label style="font-family:verdana;font-size:10"><%=facility_code%></label></td>
			
			
			<input type="hidden" name='item_code_<%=new_po_no%>_<%=i%>' id='item_code_<%=new_po_no%>_<%=i%>'       value="<%=bean.checkForNull((String)hmBatchDetails.get("ITEM_CODE"))%>">
			<input type="hidden" name='req_no_<%=new_po_no%>_<%=i%>' id='req_no_<%=new_po_no%>_<%=i%>'          value="<%=bean.checkForNull((String)hmBatchDetails.get("REQ_NO"))%>">
			<input type="hidden" name='delv_date_<%=new_po_no%>_<%=i%>' id='delv_date_<%=new_po_no%>_<%=i%>'       value="<%=bean.checkForNull((String)hmBatchDetails.get("DELV_DATE"))%>">
			<input type="hidden" name='req_qty_<%=new_po_no%>_<%=i%>' id='req_qty_<%=new_po_no%>_<%=i%>' 		  value="<%=req_qty%>">
			<input type="hidden" name='po_qty_<%=new_po_no%>_<%=i%>' id='po_qty_<%=new_po_no%>_<%=i%>' 		  value="<%=bean.checkForNull((String)hmBatchDetails.get("ITEM_QTY_NORMAL"))%>">
			<input type="hidden" name='po_price_<%=new_po_no%>_<%=i%>' id='po_price_<%=new_po_no%>_<%=i%>' 		  value="<%=bean.checkForNull((String)hmBatchDetails.get("ITEM_UNIT_COST"))%>">
			<input type="hidden" name='pur_unit_code_<%=new_po_no%>_<%=i%>' id='pur_unit_code_<%=new_po_no%>_<%=i%>'   value="<%=pur_unit_code%>">	
			<input type="hidden" name='local_currency_<%=new_po_no%>_<%=i%>' id='local_currency_<%=new_po_no%>_<%=i%>'  value="<%=bean.checkForNull((String)hmBatchDetails.get("LOCAL_CURRENCY"))%>">	
			<input type="hidden" name='trans_currency_<%=new_po_no%>_<%=i%>' id='trans_currency_<%=new_po_no%>_<%=i%>'  value="<%=bean.checkForNull((String)hmBatchDetails.get("TRANS_CURRENCY"))%>">	
			<input type="hidden" name='conversion_rate_<%=new_po_no%>_<%=i%>' id='conversion_rate_<%=new_po_no%>_<%=i%>' value="<%=bean.checkForNull((String)hmBatchDetails.get("CONVERSION_RATE"))%>">	
			<input type="hidden" name='allow_deci_<%=new_po_no%>_<%=i%>' id='allow_deci_<%=new_po_no%>_<%=i%>' 	  value="<%=bean.checkForNull((String)hmBatchDetails.get("ALLOW_DECIMALS_YN"),"N")%>">				
			<input type="hidden" name='item_remarks_<%=new_po_no%>_<%=i%>' id='item_remarks_<%=new_po_no%>_<%=i%>' 	  value="<%=bean.checkForNull((String)hmBatchDetails.get("PO_LINE_REMARKS"),"N")%>">				
			<input type="hidden" name='po_net_value_<%=new_po_no%>_<%=i%>' id='po_net_value_<%=new_po_no%>_<%=i%>' 		  value="<%=bean.checkForNull((String)hmBatchDetails.get("ITEM_NET_VALUE"))%>">
			
		</tr>
	<%}%>
		
	</table>

	<%
	}
	%>
	<br>
	<table border='0' cellpadding='0' cellspacing='0' width='100%' align=right>
		<td align="right"><input align="right" type=button name="Add" id="Add"   value='  Add to Delivery '  onclick="onadd();"  ></td>
	</table>  
	<input type="hidden" name="tran_currency_temp" id="tran_currency_temp" value="<%=tran_currency_temp%>">
	</form>

	</body>
</html>

