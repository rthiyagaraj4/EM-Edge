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
		<script language="JavaScript" src="../../ePO/js/PurchaseOrder.js"></script>
    	<script language='javascript' src='../../ePO/js/PoTransaction.js'></script>
		<script language="JavaScript" src="../../ePO/js/PoMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!-- //Added by Padmapriya for INC # 34818 on 03/09/2012 --> 


<%    
	PurchaseOrderDetailBean requestDetail; 
	String bean_id              =			"";
    String bean_name            =			"";
	String req_store_code       =			"";
	String from_doc_date        =			"";
	String to_doc_date          =			"";
	String item_code            =			"";
	String item_desc            =			"";
	String req_no     			=			"";
	String facility_id 			= 			"";
	bean_id                     = 			"purchaseOrderBean" ;
	bean_name                   = 			"ePO.PurchaseOrderBean";
	
	String po_purchase_unit = request.getParameter("po_purchase_unit");
	
	String mode = request.getParameter("mode");
	String po_no = request.getParameter("po_no");
	
	
	PurchaseOrderBean bean 		= 			(PurchaseOrderBean) getBeanObject( bean_id, bean_name,request );
	
	
	
	facility_id         		=   		CommonBean.checkForNull(request.getParameter( "facility_id"),"%");
	req_store_code       		=  			CommonBean.checkForNull(request.getParameter( "req_store_code"   ),"%");
	item_desc            		=  			CommonBean.checkForNull(request.getParameter("item_desc"),"");
	item_code            		=  			request.getParameter("item_desc").equals("")? "%": request.getParameter("item_code");
	from_doc_date        		=  			CommonBean.checkForNull(request.getParameter("from_doc_date"),"");
	to_doc_date          		=  			CommonBean.checkForNull(request.getParameter("to_doc_date"),"");	
	req_no             			=  			CommonBean.checkForNull(request.getParameter("req_no"),"%");
	
	String []stParameters 		= 			{from_doc_date,to_doc_date,req_no,facility_id,req_store_code};

	//String sql = "SELECT  DISTINCT  hdr.facility_id, hdr.req_store_code, hdr.req_no, hdr.req_code  FROM po_request_header hdr, po_request_detail dtl  WHERE hdr.req_no = dtl.req_no AND hdr.facility_id = dtl.facility_id  AND  hdr.req_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901')),   'dd/mm/yyyy' )  AND NVL (TO_DATE (?, 'dd/mm/yyyy'), SYSDATE) and hdr.req_no LIKE  ? and hdr.facility_id LIKE ? and hdr.req_store_code LIKE ?  and (hdr.REQ_STATUS = 'FA' or  hdr.REQ_STATUS = 'OR') and (nvl(dtl.REQ_QTY,0)-nvl(dtl.PO_QTY,0)) > 0 ";
	
	String sql = ePO.Common.PoRepository.getPoKeyValue("SQL_PO_SEARCH_WINDOW_RESULT");
	
	
	
	ArrayList alTemp = new ArrayList();
	alTemp =  bean.fetchRecords(sql,stParameters);
	 
	

	int total = alTemp.size();	
	if(total ==0){
%>
	<script>
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
	</script>
<%		
	}
	
	String global_unit_yn =		bean.checkForNull((String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_PO_GLOBAL_YN"),po_purchase_unit).get("GLOBAL_UNIT_YN"));
	
	
	HashMap hmExpData = new HashMap();
	
	for(int i=0;i<total;){		
		HashMap hm = (HashMap)alTemp.get(i);
		
		String mod_req_no = "";
		for (int i_req=0;	i_req<bean.getItemKeys().size();	i_req++){
		
			requestDetail					=			bean.getItemDetail((String)bean.getItemKeys().get(i_req));
			mod_req_no = bean.checkForNull(requestDetail.getReq_no());
			if(mod_req_no.equals((String)hm.get("REQ_NO")))
				break;
			
		}

		
	//	String []stParameters1 = {locale,(String)hm.get("REQ_NO"),(String)hm.get("FACILITY_ID"),(String)hm.get("REQ_STORE_CODE"),item_code };		
		ArrayList alParameters = new ArrayList();
		ArrayList alModifyParameters = new ArrayList();
		ArrayList alInsertGUYParameters = new ArrayList();
		ArrayList alInsertGUNParameters = new ArrayList();
		ArrayList alModifyGUYParameters = new ArrayList();
		ArrayList alModifyGUNParameters = new ArrayList();
		if(global_unit_yn.equals("Y")){
			alParameters.add(locale);
			alParameters.add((String)hm.get("REQ_NO"));
			alParameters.add((String)hm.get("FACILITY_ID"));
			alParameters.add((String)hm.get("REQ_STORE_CODE"));
			alParameters.add(item_code);
						
			alModifyParameters.add(locale);
			alModifyParameters.add((String)hm.get("REQ_NO"));
			alModifyParameters.add((String)hm.get("FACILITY_ID"));
			alModifyParameters.add((String)hm.get("REQ_STORE_CODE"));
			alModifyParameters.add(item_code);
			alModifyParameters.add(locale);
			alModifyParameters.add((String)hm.get("REQ_NO"));
			alModifyParameters.add((String)hm.get("FACILITY_ID"));
			alModifyParameters.add((String)hm.get("REQ_STORE_CODE"));
			alModifyParameters.add(item_code);
			
			
			alInsertGUYParameters.add(locale);
			alInsertGUYParameters.add((String)hm.get("REQ_NO"));
			alInsertGUYParameters.add((String)hm.get("FACILITY_ID"));
			alInsertGUYParameters.add((String)hm.get("REQ_STORE_CODE"));
			alInsertGUYParameters.add(item_code);
			
			alInsertGUNParameters.add(locale);
			alInsertGUNParameters.add((String)hm.get("REQ_NO"));
			alInsertGUNParameters.add(bean.getLoginFacilityId());
			alInsertGUNParameters.add((String)hm.get("REQ_STORE_CODE"));
			alInsertGUNParameters.add(item_code);
			alInsertGUNParameters.add(po_purchase_unit);
			
			alModifyGUYParameters.add(locale);
			alModifyGUYParameters.add((String)hm.get("REQ_NO"));
			alModifyGUYParameters.add((String)hm.get("FACILITY_ID"));
			alModifyGUYParameters.add((String)hm.get("REQ_STORE_CODE"));
			alModifyGUYParameters.add(item_code);
			alModifyGUYParameters.add(po_no);
			alModifyGUYParameters.add(locale);
			alModifyGUYParameters.add((String)hm.get("REQ_NO"));
			alModifyGUYParameters.add((String)hm.get("FACILITY_ID"));
			alModifyGUYParameters.add((String)hm.get("REQ_STORE_CODE"));
			alModifyGUYParameters.add(item_code);
			alModifyGUYParameters.add(mod_req_no);
			
			alModifyGUNParameters.add(locale);
			alModifyGUNParameters.add((String)hm.get("REQ_NO"));
			alModifyGUNParameters.add(bean.getLoginFacilityId());
			alModifyGUNParameters.add((String)hm.get("REQ_STORE_CODE"));
			alModifyGUNParameters.add(item_code);
			alModifyGUNParameters.add(po_no);
			alModifyGUNParameters.add(po_purchase_unit);
			alModifyGUNParameters.add(locale);
			alModifyGUNParameters.add((String)hm.get("REQ_NO"));
			alModifyGUNParameters.add(bean.getLoginFacilityId());
			alModifyGUNParameters.add((String)hm.get("REQ_STORE_CODE"));
			alModifyGUNParameters.add(item_code);
			alModifyGUNParameters.add(po_purchase_unit);
			alModifyGUNParameters.add(mod_req_no);
			
		}else if(global_unit_yn.equals("N")){
			alParameters.add(locale);
			alParameters.add((String)hm.get("REQ_NO"));
			alParameters.add(bean.getLoginFacilityId());
			alParameters.add((String)hm.get("REQ_STORE_CODE"));
			alParameters.add(item_code);
			
			alModifyParameters.add(locale);
			alModifyParameters.add((String)hm.get("REQ_NO"));
			alModifyParameters.add(bean.getLoginFacilityId());
			alModifyParameters.add((String)hm.get("REQ_STORE_CODE"));
			alModifyParameters.add(item_code);
			alModifyParameters.add(locale);
			alModifyParameters.add((String)hm.get("REQ_NO"));
			alModifyParameters.add(bean.getLoginFacilityId());
			alModifyParameters.add((String)hm.get("REQ_STORE_CODE"));
			alModifyParameters.add(item_code);
			
			alInsertGUYParameters.add(locale);
			alInsertGUYParameters.add((String)hm.get("REQ_NO"));
			alInsertGUYParameters.add((String)hm.get("FACILITY_ID"));
			alInsertGUYParameters.add((String)hm.get("REQ_STORE_CODE"));
			alInsertGUYParameters.add(item_code);
			
			alInsertGUNParameters.add(locale);
			alInsertGUNParameters.add((String)hm.get("REQ_NO"));
			alInsertGUNParameters.add(bean.getLoginFacilityId());
			alInsertGUNParameters.add((String)hm.get("REQ_STORE_CODE"));
			alInsertGUNParameters.add(item_code);
			alInsertGUNParameters.add(po_purchase_unit);
						
			alModifyGUYParameters.add(locale);
			alModifyGUYParameters.add((String)hm.get("REQ_NO"));
			alModifyGUYParameters.add((String)hm.get("FACILITY_ID"));
			alModifyGUYParameters.add((String)hm.get("REQ_STORE_CODE"));
			alModifyGUYParameters.add(item_code);
			alModifyGUYParameters.add(po_no);
			alModifyGUYParameters.add(locale);
			alModifyGUYParameters.add((String)hm.get("REQ_NO"));
			alModifyGUYParameters.add((String)hm.get("FACILITY_ID"));
			alModifyGUYParameters.add((String)hm.get("REQ_STORE_CODE"));
			alModifyGUYParameters.add(item_code);
			alModifyGUYParameters.add(mod_req_no);
			
			alModifyGUNParameters.add(locale);
			alModifyGUNParameters.add((String)hm.get("REQ_NO"));
			alModifyGUNParameters.add(bean.getLoginFacilityId());
			alModifyGUNParameters.add((String)hm.get("REQ_STORE_CODE"));
			alModifyGUNParameters.add(item_code);
			alModifyGUNParameters.add(po_no);
			alModifyGUNParameters.add(po_purchase_unit);
			alModifyGUNParameters.add(locale);
			alModifyGUNParameters.add((String)hm.get("REQ_NO"));
			alModifyGUNParameters.add(bean.getLoginFacilityId());
			alModifyGUNParameters.add((String)hm.get("REQ_STORE_CODE"));
			alModifyGUNParameters.add(item_code);
			alModifyGUNParameters.add(po_purchase_unit);
			alModifyGUNParameters.add(mod_req_no);
		}	
		
				
		String login_facility = bean.getLoginFacilityId();
		
		String sql1 = "";
		
			//ArrayList alExpData =  (ArrayList)bean.fetchRecords("SELECT hdr.facility_id, hdr.req_store_code, hdr.req_no, hdr.req_code,dtl.item_code,mm.short_desc item_name,dtl.req_qty ,dtl.REQ_UOM,AM.SHORT_DESC REQ_UOM_DESC,TO_CHAR (hdr.REQ_DATE,'dd/mm/yyyy') req_date,dtl.REQ_SRL_NO ,ST.DEF_ISSUE_UOM st_uom , AM1.SHORT_DESC ST_UOM_DESC FROM po_request_header hdr, po_request_detail dtl,mm_item_lang_vw mm, ST_ITEM_STORE st,AM_UOM_LANG_VW am ,AM_UOM_LANG_VW am1 WHERE hdr.req_no = dtl.req_no AND hdr.facility_id = dtl.facility_id  AND  dtl.item_code = mm.item_code  and mm.language_id = ?  and DTL.ITEM_CODE = ST.ITEM_CODE and HDR.REQ_STORE_CODE = ST.STORE_CODE AND hdr.req_no = ? AND hdr.facility_id = ? AND hdr.req_store_code = ? AND dtl.item_code like upper(?)  and DTL.REQ_UOM=AM.UOM_CODE and AM.LANGUAGE_ID= mm.language_id and AM.LANGUAGE_ID=AM1.LANGUAGE_ID AND ST.DEF_ISSUE_UOM = AM1.UOM_CODE and (nvl(dtl.REQ_QTY,0)-nvl(dtl.PO_QTY,0)) > 0  ORDER BY hdr.facility_id, hdr.req_code, hdr.req_no, dtl.REQ_SRL_NO",alParameters);
			
			// Commented on 03/09/2012
			//ArrayList alExpData =  (ArrayList)bean.fetchRecords("SELECT hdr.facility_id, hdr.req_store_code, hdr.req_no, hdr.req_code,dtl.item_code,mm.short_desc item_name,dtl.req_qty ,(nvl(dtl.REQ_QTY,0)-nvl(dtl.PO_QTY,0) -nvl(dtl.PO_BLOCKED_QTY,0)) pending_qty , dtl.REQ_UOM,AM.SHORT_DESC REQ_UOM_DESC,TO_CHAR (hdr.REQ_DATE,'dd/mm/yyyy') req_date,dtl.REQ_SRL_NO ,ST.DEF_ISSUE_UOM st_uom , AM1.SHORT_DESC ST_UOM_DESC FROM po_request_header hdr, po_request_detail dtl,mm_item_lang_vw mm, ST_ITEM_STORE st,AM_UOM_LANG_VW am ,AM_UOM_LANG_VW am1 WHERE hdr.req_no = dtl.req_no AND hdr.facility_id = dtl.facility_id  AND  dtl.item_code = mm.item_code  and mm.language_id = ?  and DTL.ITEM_CODE = ST.ITEM_CODE and HDR.REQ_STORE_CODE = ST.STORE_CODE AND hdr.req_no = ? AND hdr.facility_id = ? AND hdr.req_store_code = ? AND dtl.item_code like upper(?)  and DTL.REQ_UOM=AM.UOM_CODE and AM.LANGUAGE_ID= mm.language_id and AM.LANGUAGE_ID=AM1.LANGUAGE_ID AND ST.DEF_ISSUE_UOM = AM1.UOM_CODE and (nvl(dtl.REQ_QTY,0)-nvl(dtl.PO_QTY,0)) > 0  ORDER BY hdr.facility_id, hdr.req_code, hdr.req_no, dtl.REQ_SRL_NO",alParameters);
			
			// Added on 03/09/2012
			
			if((mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) && global_unit_yn.equals("Y")){
			
			//	sql1 = "SELECT hdr.facility_id, hdr.req_store_code, hdr.req_no, hdr.req_code,dtl.item_code,mm.short_desc item_name,dtl.req_qty ,(nvl(dtl.REQ_QTY,0)-nvl(dtl.PO_QTY,0) -nvl(dtl.PO_BLOCKED_QTY,0) + nvl(fdtl.PO_QTY,0)) pending_qty , dtl.REQ_UOM,AM.SHORT_DESC REQ_UOM_DESC,TO_CHAR (hdr.REQ_DATE,'dd/mm/yyyy') req_date,dtl.REQ_SRL_NO ,ST.DEF_ISSUE_UOM st_uom , AM1.SHORT_DESC ST_UOM_DESC FROM PO_ORDER_FCY_DTL fdtl, po_request_header hdr, po_request_detail dtl,mm_item_lang_vw mm, ST_ITEM_STORE st,AM_UOM_LANG_VW am ,AM_UOM_LANG_VW am1 WHERE hdr.req_no = dtl.req_no AND hdr.facility_id = dtl.facility_id  AND  dtl.item_code = mm.item_code  and mm.language_id = ?  and DTL.ITEM_CODE = ST.ITEM_CODE and HDR.REQ_STORE_CODE = ST.STORE_CODE AND hdr.req_no = ? AND hdr.facility_id = ? AND hdr.req_store_code = ? AND dtl.item_code like upper(?)  and DTL.REQ_UOM=AM.UOM_CODE and AM.LANGUAGE_ID= mm.language_id and AM.LANGUAGE_ID=AM1.LANGUAGE_ID AND ST.DEF_ISSUE_UOM = AM1.UOM_CODE and (nvl(dtl.REQ_QTY,0)-nvl(dtl.PO_QTY,0)) > 0 and fdtl.REQ_NO = dtl.REQ_NO and fdtl.REQ_SRL_NO = dtl.REQ_SRL_NO and fdtl.po_no='"+po_no+"' UNION SELECT hdr.facility_id, hdr.req_store_code, hdr.req_no, hdr.req_code,dtl.item_code,mm.short_desc item_name,dtl.req_qty ,(nvl(dtl.REQ_QTY,0)-nvl(dtl.PO_QTY,0) -nvl(dtl.PO_BLOCKED_QTY,0)) pending_qty , dtl.REQ_UOM,AM.SHORT_DESC REQ_UOM_DESC,TO_CHAR (hdr.REQ_DATE,'dd/mm/yyyy') req_date,dtl.REQ_SRL_NO ,ST.DEF_ISSUE_UOM st_uom , AM1.SHORT_DESC ST_UOM_DESC FROM po_request_header hdr, po_request_detail dtl,mm_item_lang_vw mm, ST_ITEM_STORE st,AM_UOM_LANG_VW am ,AM_UOM_LANG_VW am1 WHERE hdr.req_no = dtl.req_no AND hdr.facility_id = dtl.facility_id  AND  dtl.item_code = mm.item_code  and mm.language_id = ?  and DTL.ITEM_CODE = ST.ITEM_CODE and HDR.REQ_STORE_CODE = ST.STORE_CODE AND  hdr.req_no = ?  AND hdr.facility_id = ? AND hdr.req_store_code = ? AND dtl.item_code like upper(?)  and DTL.REQ_UOM=AM.UOM_CODE and AM.LANGUAGE_ID= mm.language_id and AM.LANGUAGE_ID=AM1.LANGUAGE_ID AND ST.DEF_ISSUE_UOM = AM1.UOM_CODE and (nvl(dtl.REQ_QTY,0)-nvl(dtl.PO_QTY,0)) > 0  	 AND hdr.req_no NOT IN '"+mod_req_no+"' ";
			
			sql1 = ePO.Common.PoRepository.getPoKeyValue("SQL_PO_SEARCH_WINDOW_RESULT_MODIFY_GUY");
			
			}else if((mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) && global_unit_yn.equals("N")){
				
				//sql1 = "SELECT hdr.facility_id, hdr.req_store_code, hdr.req_no, hdr.req_code,dtl.item_code,mm.short_desc item_name,dtl.req_qty ,(nvl(dtl.REQ_QTY,0)-nvl(dtl.PO_QTY,0) -nvl(dtl.PO_BLOCKED_QTY,0) + nvl(fdtl.PO_QTY,0)) pending_qty , dtl.REQ_UOM,AM.SHORT_DESC REQ_UOM_DESC,TO_CHAR (hdr.REQ_DATE,'dd/mm/yyyy') req_date,dtl.REQ_SRL_NO ,ST.DEF_ISSUE_UOM st_uom , AM1.SHORT_DESC ST_UOM_DESC FROM PO_ORDER_FCY_DTL fdtl, po_request_header hdr, po_request_detail dtl,mm_item_lang_vw mm, ST_ITEM_STORE st,AM_UOM_LANG_VW am ,AM_UOM_LANG_VW am1 WHERE hdr.req_no = dtl.req_no AND hdr.facility_id = dtl.facility_id  AND  dtl.item_code = mm.item_code  and mm.language_id = ?  and DTL.ITEM_CODE = ST.ITEM_CODE and HDR.REQ_STORE_CODE = ST.STORE_CODE AND hdr.req_no = ? AND hdr.facility_id = ? AND hdr.req_store_code = ? AND dtl.item_code like upper(?)  and DTL.REQ_UOM=AM.UOM_CODE and AM.LANGUAGE_ID= mm.language_id and AM.LANGUAGE_ID=AM1.LANGUAGE_ID AND ST.DEF_ISSUE_UOM = AM1.UOM_CODE and (nvl(dtl.REQ_QTY,0)-nvl(dtl.PO_QTY,0)) > 0 and fdtl.REQ_NO = dtl.REQ_NO and fdtl.REQ_SRL_NO = dtl.REQ_SRL_NO and fdtl.po_no='"+po_no+"' AND hdr.PUR_UNIT_CODE = '"+po_purchase_unit+"'  UNION SELECT hdr.facility_id, hdr.req_store_code, hdr.req_no, hdr.req_code,dtl.item_code,mm.short_desc item_name,dtl.req_qty ,(nvl(dtl.REQ_QTY,0)-nvl(dtl.PO_QTY,0) -nvl(dtl.PO_BLOCKED_QTY,0)) pending_qty , dtl.REQ_UOM,AM.SHORT_DESC REQ_UOM_DESC,TO_CHAR (hdr.REQ_DATE,'dd/mm/yyyy') req_date,dtl.REQ_SRL_NO ,ST.DEF_ISSUE_UOM st_uom , AM1.SHORT_DESC ST_UOM_DESC FROM po_request_header hdr, po_request_detail dtl,mm_item_lang_vw mm, ST_ITEM_STORE st,AM_UOM_LANG_VW am ,AM_UOM_LANG_VW am1 WHERE hdr.req_no = dtl.req_no AND hdr.facility_id = dtl.facility_id  AND  dtl.item_code = mm.item_code  and mm.language_id = ?  and DTL.ITEM_CODE = ST.ITEM_CODE and HDR.REQ_STORE_CODE = ST.STORE_CODE AND  hdr.req_no = ? AND hdr.facility_id = ? AND hdr.req_store_code = ? AND dtl.item_code like upper(?)  and DTL.REQ_UOM=AM.UOM_CODE and AM.LANGUAGE_ID= mm.language_id and AM.LANGUAGE_ID=AM1.LANGUAGE_ID AND ST.DEF_ISSUE_UOM = AM1.UOM_CODE and (nvl(dtl.REQ_QTY,0)-nvl(dtl.PO_QTY,0)) > 0  AND hdr.PUR_UNIT_CODE = '"+po_purchase_unit+"' AND hdr.req_no NOT IN '"+mod_req_no+"' ";
				
				sql1 = ePO.Common.PoRepository.getPoKeyValue("SQL_PO_SEARCH_WINDOW_RESULT_MODIFY_GUN");
			
			}else if((mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) && global_unit_yn.equals("Y")) {
			
				//sql1 = "SELECT hdr.facility_id, hdr.req_store_code, hdr.req_no, hdr.req_code,dtl.item_code,mm.short_desc item_name,dtl.req_qty ,(nvl(dtl.REQ_QTY,0)-nvl(dtl.PO_QTY,0) -nvl(dtl.PO_BLOCKED_QTY,0)) pending_qty , dtl.REQ_UOM,AM.SHORT_DESC REQ_UOM_DESC,TO_CHAR (hdr.REQ_DATE,'dd/mm/yyyy') req_date,dtl.REQ_SRL_NO ,ST.DEF_ISSUE_UOM st_uom , AM1.SHORT_DESC ST_UOM_DESC FROM po_request_header hdr, po_request_detail dtl,mm_item_lang_vw mm, ST_ITEM_STORE st,AM_UOM_LANG_VW am ,AM_UOM_LANG_VW am1 WHERE hdr.req_no = dtl.req_no AND hdr.facility_id = dtl.facility_id  AND  dtl.item_code = mm.item_code  and mm.language_id = ?  and DTL.ITEM_CODE = ST.ITEM_CODE and HDR.REQ_STORE_CODE = ST.STORE_CODE AND hdr.req_no = ? AND hdr.facility_id = ? AND hdr.req_store_code = ? AND dtl.item_code like upper(?)  and DTL.REQ_UOM=AM.UOM_CODE and AM.LANGUAGE_ID= mm.language_id and AM.LANGUAGE_ID=AM1.LANGUAGE_ID AND ST.DEF_ISSUE_UOM = AM1.UOM_CODE and (nvl(dtl.REQ_QTY,0)-nvl(dtl.PO_QTY,0)) > 0  ORDER BY hdr.facility_id, hdr.req_code, hdr.req_no, dtl.REQ_SRL_NO";
				
				sql1 = ePO.Common.PoRepository.getPoKeyValue("SQL_PO_SEARCH_WINDOW_RESULT_INSERT_GUY");
				
			}else if((mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) && global_unit_yn.equals("N")) {
			
				//sql1 = "SELECT hdr.facility_id, hdr.req_store_code, hdr.req_no, hdr.req_code,dtl.item_code,mm.short_desc item_name,dtl.req_qty ,(nvl(dtl.REQ_QTY,0)-nvl(dtl.PO_QTY,0) -nvl(dtl.PO_BLOCKED_QTY,0)) pending_qty , dtl.REQ_UOM,AM.SHORT_DESC REQ_UOM_DESC,TO_CHAR (hdr.REQ_DATE,'dd/mm/yyyy') req_date,dtl.REQ_SRL_NO ,ST.DEF_ISSUE_UOM st_uom , AM1.SHORT_DESC ST_UOM_DESC FROM po_request_header hdr, po_request_detail dtl,mm_item_lang_vw mm, ST_ITEM_STORE st,AM_UOM_LANG_VW am ,AM_UOM_LANG_VW am1 WHERE hdr.req_no = dtl.req_no AND hdr.facility_id = dtl.facility_id  AND  dtl.item_code = mm.item_code  and mm.language_id = ?  and DTL.ITEM_CODE = ST.ITEM_CODE and HDR.REQ_STORE_CODE = ST.STORE_CODE AND hdr.req_no = ? AND hdr.facility_id = ? AND hdr.req_store_code = ? AND dtl.item_code like upper(?)  and DTL.REQ_UOM=AM.UOM_CODE and AM.LANGUAGE_ID= mm.language_id and AM.LANGUAGE_ID=AM1.LANGUAGE_ID AND ST.DEF_ISSUE_UOM = AM1.UOM_CODE and (nvl(dtl.REQ_QTY,0)-nvl(dtl.PO_QTY,0)) > 0 	 AND hdr.PUR_UNIT_CODE = '"+po_purchase_unit+"' and hdr.facility_id = '"+login_facility+"' ORDER BY hdr.facility_id, hdr.req_code, hdr.req_no, dtl.REQ_SRL_NO";
				
				sql1 = ePO.Common.PoRepository.getPoKeyValue("SQL_PO_SEARCH_WINDOW_RESULT_INSERT_GUN");
			}
			
			ArrayList alExpData = new ArrayList();
			
			if((mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) && global_unit_yn.equals("Y")){
				alExpData =  (ArrayList)bean.fetchRecords(sql1,alModifyGUYParameters);
			}else if((mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) && global_unit_yn.equals("N")){
				alExpData =  (ArrayList)bean.fetchRecords(sql1,alModifyGUNParameters);
			}else if((mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) && global_unit_yn.equals("Y")) {
				alExpData =  (ArrayList)bean.fetchRecords(sql1,alInsertGUYParameters);
			}else if((mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) && global_unit_yn.equals("N")) {
				alExpData =  (ArrayList)bean.fetchRecords(sql1,alInsertGUNParameters);
			}		

        int alsize = alExpData.size();
		if ( alsize > 0 ){
		hmExpData.put((String)hm.get("REQ_NO"),alExpData);
		i++;
		}else{
        alTemp.remove(i);
		total--;
		}
	}	

	bean.setPoItemDetails(hmExpData);


 	String classValue			= "";
	
%>
<base target=_self>
</head>
<body>
	<form name= "formPurchaseOrderSearchWindowResult">

		<table border='1' cellpadding='0' cellspacing='0' width='100%' align=center>
			<tr>
				<th align='center' > Purchase Request Details </th>		
			</tr>
		</table>
	
		<input type="hidden" name="finalstring" id="finalstring" value="<%=request.getQueryString()%>">
		<input type="hidden" name="selected_doc_no" id="selected_doc_no" value="">
		<input type="hidden" name="sel_doc_batch_count" id="sel_doc_batch_count" value="">
		<input type="hidden" name="prev_ind" id="prev_ind" value="">
		<input type="hidden" name="total" id="total" value="<%=total%>">
<% 
		String new_doc_no ="";
		for(int i=0;i<total;i++ ){  
	        HashMap hmTemp = new HashMap();
            hmTemp = (HashMap)alTemp.get(i);
			
		
		ArrayList alStoreList = 	new ArrayList();
		ArrayList alFacList = 	new ArrayList();
		ArrayList alReqList = 	new ArrayList();
		String req_store = "";
		String facility_code = "";
		String req_code = "";
		
		req_store =	bean.checkForNull((String)hmTemp.get("REQ_STORE_CODE"));
		alStoreList.add(req_store);
		alStoreList.add(bean.getLanguageId());
		req_store = 	(String)bean.fetchRecord("SELECT STORE_CODE,long_desc short_desc FROM MM_STORE_LANG_VW	WHERE STORE_CODE=? AND LANGUAGE_ID=?",alStoreList).get("SHORT_DESC");
	 
		facility_code =	bean.checkForNull((String)hmTemp.get("FACILITY_ID"));
		alFacList.add(bean.getLanguageId());
		alFacList.add(facility_code);
		facility_code = 	(String)bean.fetchRecord("SELECT FACILITY_ID, FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW  WHERE LANGUAGE_ID=?  AND FACILITY_ID=?",alFacList).get("FACILITY_NAME");
		
		req_code =	bean.checkForNull((String)hmTemp.get("REQ_CODE"));
		alReqList.add(bean.getLanguageId());
		alReqList.add(req_code);
		alReqList.add("POREQN");
		req_code = 	(String)bean.fetchRecord("SELECT MASTER_TYPE,MASTER_CODE,LONG_DESC SHORT_DESC  FROM PO_MASTER_CODE_LANG_VW  WHERE LANGUAGE_ID=?  AND MASTER_CODE=? AND MASTER_TYPE=?",alReqList).get("SHORT_DESC");
	 
	 
	 
			ArrayList alBatchDetails = (ArrayList)hmExpData.get((String)hmTemp.get("REQ_NO"));
			int batchcount = alBatchDetails.size();
			new_doc_no = bean.checkForNull((String)hmTemp.get("REQ_NO"));
%>

        <table  border = '0' cellpadding='0' cellspacing='0' width='100%' align=center>
			<tr>
				<td align='left' class="label">
					<input type="checkbox" name="doc_no_check_<%=i%>" id="doc_no_check_<%=i%>" id="doc_no_check_<%=i%>" value="<%=bean.checkForNull((String)hmTemp.get("REQ_NO"))%>"  onClick="enable_doc(this, <%=batchcount%>);"  >
					<label style="font-family:verdana;font-size:10"><b><%=req_code%> &nbsp;&nbsp;&nbsp;&nbsp;<%=new_doc_no%></b></label> 
				</td>
				<td align='left' class="label">Request By Facility
					<label style="font-family:verdana;font-size:10">&nbsp;&nbsp;&nbsp;<b><%=facility_code%> </b></label>
				</td>
				<td align='left' class="label">Request By Store
					<label style="font-family:verdana;font-size:10">&nbsp;&nbsp;&nbsp;<b><%=req_store%></b></label>
				</td>		    	
			<!--	<td class="label" width='5%'> 
					<input align="right" type=button name="Add" id="Add"   value='  Add  '  onclick="onadd();"  >	        
				</td>	
			-->	
					<input type="hidden" name='batchcount_<%=new_doc_no%>_<%=i%>' id='batchcount_<%=new_doc_no%>_<%=i%>' id='batchcount_<%=new_doc_no%>_<%=i%>' value="<%=batchcount%>">
			</tr>
		</table>
		<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center'>
			<tr>
                <th><fmt:message key="Common.Select.label"      bundle="${common_labels}"/></th>
		        <th><fmt:message key="Common.item.label"        bundle="${common_labels}"/></th>
				<th>Stock UOM</th>
				<th colspan= "2">Req Qty</th>
				<th>Required By Date</th>
				<th>Pending Qty</th>
				<th>Order Qty</th>
				<th>Order UOM</th>
			</tr>
	
<%
	for(int j=0;j<alBatchDetails.size();j++){

			 HashMap hmBatchDetails = (HashMap)alBatchDetails.get(j);
			 classValue	=	"QRYODD";	
%>
		  
			<tr>	      
                                                                                     
				<td class="<%=classValue%>"  style="font-family:verdana;font-size:10;text-align:right;"  width='6%'>&nbsp;&nbsp;
					<input type="checkbox"  id="doc_no_<%=new_doc_no%>_<%=j%>" name="doc_no_<%=new_doc_no%>_<%=j%>"  value="<%=new_doc_no%>" onClick='getItemQty(this,<%=j%>);' disabled> 
				</td>	
				<td class="<%=classValue%>"   width='20%' >
					<label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("ITEM_NAME"))%></label>&nbsp;
				</td>
				<td class="<%=classValue%>"  width='10%'>
					<label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("ST_UOM_DESC"))%> </label> <input type="hidden" name='stock_uom_<%=new_doc_no%>_<%=j%>' id='stock_uom_<%=new_doc_no%>_<%=j%>'  value="<%=bean.checkForNull((String)hmBatchDetails.get("ST_UOM_DESC"))%>">
				</td>	
				<td class="<%=classValue%>"  width='10%'>
					<label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("REQ_QTY"))%></label>
					<input type="hidden"  name='req_qty_<%=new_doc_no%>_<%=j%>' id='req_qty_<%=new_doc_no%>_<%=j%>' value="<%=bean.checkForNull((String)hmBatchDetails.get("REQ_QTY"))%>">
				</td>		
				<td class="<%=classValue%>"  width='10%'>
					<label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("REQ_UOM_DESC"))%> </label> 
					<input type="hidden" name='req_uom_<%=new_doc_no%>_<%=j%>' id='req_uom_<%=new_doc_no%>_<%=j%>' value="<%=bean.checkForNull((String)hmBatchDetails.get("REQ_UOM_DESC"))%>">   
				</td>	
				<td class="<%=classValue%>"  width='15%'>
					<label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("REQ_DATE"))%></label>    
					<input type="hidden" name='order_by_date_<%=new_doc_no%>_<%=j%>' id='order_by_date_<%=new_doc_no%>_<%=j%>'  value="<%=bean.checkForNull((String)hmBatchDetails.get("REQ_DATE"))%>">
				</td>
				
				<td class="<%=classValue%>"  width='10%'>
					<label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("PENDING_QTY"))%></label>
					<input type="hidden"  name='pending_qty_<%=new_doc_no%>_<%=j%>' id='pending_qty_<%=new_doc_no%>_<%=j%>' value="<%=bean.checkForNull((String)hmBatchDetails.get("PENDING_QTY"))%>">
				</td>		
				
				<td class="<%=classValue%>"  width='10%' align='right'>
					<input type="text"  id='order_qty_<%=new_doc_no%>_<%=j%>' name='order_qty_<%=new_doc_no%>_<%=j%>'  value="" disabled>
				</td>
				<td class="<%=classValue%>"  width='15%'>
					<label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("REQ_UOM_DESC"))%> </label>
				</td>
				
				<input type="hidden" name='doc_type_code_<%=new_doc_no%>_<%=j%>' id='doc_type_code_<%=new_doc_no%>_<%=j%>' value="<%=bean.checkForNull((String)hmBatchDetails.get("REQ_CODE"))%>">	
				<input type="hidden" name='item_code_<%=new_doc_no%>_<%=j%>' id='item_code_<%=new_doc_no%>_<%=j%>'     value="<%=bean.checkForNull((String)hmBatchDetails.get("ITEM_CODE"))%>">
				<input type="hidden" name='item_name_<%=new_doc_no%>_<%=j%>' id='item_name_<%=new_doc_no%>_<%=j%>'     value="<%=java.net.URLEncoder.encode(bean.checkForNull((String)hmBatchDetails.get("ITEM_NAME")))%>">						
				<input type="hidden" name='store_code_<%=new_doc_no%>_<%=j%>' id='store_code_<%=new_doc_no%>_<%=j%>'    value="<%=bean.checkForNull((String)hmBatchDetails.get("REQ_STORE_CODE"))%>"> 
				<input type="hidden" name='doc_srl_no_<%=new_doc_no%>_<%=j%>' id='doc_srl_no_<%=new_doc_no%>_<%=j%>'    value="<%=bean.checkForNull((String)hmBatchDetails.get("REQ_SRL_NO"))%>">
				<input type="hidden" name='facility_id_<%=new_doc_no%>_<%=j%>' id='facility_id_<%=new_doc_no%>_<%=j%>'   value="<%=bean.checkForNull((String)hmBatchDetails.get("FACILITY_ID"))%>"> 
				<input type="hidden" name='order_uom_<%=new_doc_no%>_<%=j%>' id='order_uom_<%=new_doc_no%>_<%=j%>'     value="<%=bean.checkForNull((String)hmBatchDetails.get("REQ_UOM"))%>">	
			
			</tr> 
		   
		   
<% }%>

		</table>	
        
<% } %>	
<br>
	<table border='0' cellpadding='0' cellspacing='0' width='100%' align=right>
		<td align="right"><input align="right" type=button name="Add" id="Add"   value='  Add '  onclick="onadd();"  ></td>
	</table> 
	</form>

</body>
</html>

