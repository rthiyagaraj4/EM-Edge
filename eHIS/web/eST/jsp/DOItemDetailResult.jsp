<!DOCTYPE html>
<%@ page import=" eST.*,eST.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%>
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
	String po_no	            ="";
	String supp_code			="";
	String classValue			="";
	String new_do_no			="";
	String st_uom_code			="";
	String st_uom_desc			="";
	String mode					="";
	String img_next_del_date	="hidden";
	String do_no				= "";
	String po_no_ref			="";

	bean_id                     = "goodsReceivedNoteBean" ;
	bean_name                   = "eST.GoodsReceivedNoteBean";

    
	GoodsReceivedNoteBean bean = (GoodsReceivedNoteBean) getBeanObject( bean_id, bean_name,request );


	store_code           =  bean.checkForNull(request.getParameter("store_code"));
	item_code            =  request.getParameter("item_desc").equals("")? "%": request.getParameter("item_code");
	from_doc_date        =  bean.checkForNull(request.getParameter("from_doc_date"));
	to_doc_date          =  bean.checkForNull(request.getParameter("to_doc_date"));	
	po_no		         =  bean.checkForNull(request.getParameter("po_no"),"%");
	supp_code            =  bean.checkForNull(request.getParameter("supp_code"));
	mode				 =  bean.checkForNull(request.getParameter("mode"));
	do_no				 =  bean.checkForNull(request.getParameter("do_no"),"%");

	int no_deci                   =    bean.getNoOfDecimals();

System.out.println("mode==>"+mode);


	String []stParameters = {store_code,facility_id,supp_code,from_doc_date,to_doc_date,do_no,item_code};
	
	
	String sql= "SELECT DISTINCT HDR.DO_NO FROM PO_DELV_ORD_HDR HDR, PO_DELV_ORD_DTL DTL , PO_DELV_ORD_DTL_BAT EXP  WHERE HDR.DO_NO = DTL.DO_NO  AND DTL.DO_NO= EXP.DO_NO AND DTL.ITEM_CODE=EXP.ITEM_CODE  AND DTL.DO_SRL_NO = EXP.DO_SRL_NO AND DTL.PO_NO=EXP.PO_NO   AND DTL.PO_SRL_NO=EXP.PO_SRL_NO AND DTL.SCH_DELV_DATE=EXP.SCH_DELV_DATE  AND (EXP.DIST_STORE_CODE = ? OR EXP.DIST_STORE_CODE = '*A') AND (EXP.DIST_FACILITY_ID = ? OR EXP.DIST_FACILITY_ID = '*A')            AND HDR.SUPP_CODE = ?  AND HDR.DO_STATUS IN ('FN','PR')  AND DO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901')),'DD/MM/YYYY') AND NVL (TO_DATE (?, 'DD/MM/YYYY'), SYSDATE) AND DTL.DO_NO LIKE ?   AND DTL.ITEM_CODE LIKE ?  AND (NVL (EXP.DO_QTY_NORMAL, 0) - NVL (EXP.GRN_QTY, 0)) > 0  ORDER BY 1";
 
	ArrayList alTemp = new ArrayList();
	HashMap hmExpData = new HashMap();
	HashMap hmTemp = null;
	HashMap temp = null;

	alTemp =  bean.fetchRecords(sql,stParameters);

System.out.println("alTemp==>"+alTemp);

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
		
		String []stParameters1 = {store_code,facility_id,supp_code,from_doc_date,to_doc_date,locale,store_code,bean.checkForNull((String)hm.get("DO_NO"),"%"),item_code};
		
		String sql1 = "";

		if(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))){			
			sql1 = "SELECT * FROM (SELECT DTL.DO_NO,DTL.DO_SRL_NO,DTL.PO_NO, DTL.PO_SRL_NO,(SELECT PUR_UNIT_CODE FROM PO_ORDER_HDR WHERE PO_NO=DTL.PO_NO)PUR_UNIT_CODE,DTL.ITEM_CODE, MMITEM.SHORT_DESC ITEM_DESC,EXP.DO_QTY_NORMAL DO_QTY,(EXP.DO_QTY_NORMAL - (NVL (EXP.GRN_QTY, 0) + (SELECT NVL(SUM (NVL (BLOCKED_QTY, 0)),0) BLOCKED_QTY  FROM PO_ORDER_UNF_GRN  WHERE PO_NO = DTL.PO_NO AND ITEM_CODE = DTL.ITEM_CODE AND DO_NO = DTL.DO_NO and  (facility_id !='"+facility_id+"' or grn_doc_type_code!='"+bean.getDoc_type_code()+"' or grn_no!='"+bean.getDoc_no()+"')))) ITEM_QTY_NORMAL,NVL (DTL.UNIT_COST, 0) ITEM_UNIT_COST,((EXP.DO_QTY_NORMAL - (NVL (EXP.GRN_QTY, 0)) + (SELECT NVL(SUM (NVL (BLOCKED_QTY, 0)), 0) BLOCKED_QTY FROM PO_ORDER_UNF_GRN  WHERE PO_NO = DTL.PO_NO AND ITEM_CODE = DTL.ITEM_CODE AND DO_NO = DTL.DO_NO and (facility_id !='"+facility_id+"' or grn_doc_type_code!='"+bean.getDoc_type_code()+"' or grn_no!='"+bean.getDoc_no()+"')))* (NVL (DTL.UNIT_COST, 0)* NVL (HDR.CONVERSION_RATE, 0))) ITEM_COST_VALUE,STOCK_ITEM_YN, EXP.DO_UOM PUR_UOM_CODE, AM1.SHORT_DESC PUR_UOM_DESC, AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.DO_CONV_FACTOR,STITEM.EXPIRY_YN, NVL(DO_QTY_BONUS,0)DO_QTY_BONUS, NVL(DO_QTY_SAMPLE,0)DO_QTY_SAMPLE, NVL (STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY, HDR.LOCAL_CURRENCY, HDR.CONVERSION_RATE, TO_CHAR (HDR.DO_DATE, 'DD/MM/YYYY') DO_DATE,  DTL.REQ_NO,DTL.REQ_FACILITY_ID,(SELECT REQ_SRL_NO FROM PO_REQUEST_DETAIL WHERE FACILITY_ID=DTL.REQ_FACILITY_ID AND REQ_NO=DTL.REQ_NO AND ITEM_CODE=DTL.ITEM_CODE)REQ_SRL_NO, ST.DEF_ISSUE_UOM ,EXP.BATCH_ID, TO_CHAR(EXP.EXPIRY_DATE,'DD/MM/YYYY')EXPIRY_DATE, TO_CHAR(EXP.SCH_DELV_DATE,'DD/MM/YYYY')SCH_DELV_DATE FROM PO_DELV_ORD_HDR HDR,  PO_DELV_ORD_DTL DTL, PO_DELV_ORD_DTL_BAT EXP, MM_ITEM_LANG_VW MMITEM,     ST_ITEM STITEM, AM_UOM_LANG_VW AM, ST_ITEM_STORE ST,AM_UOM_LANG_VW AM1 WHERE HDR.DO_NO = DTL.DO_NO  AND DTL.DO_NO= EXP.DO_NO AND DTL.ITEM_CODE=EXP.ITEM_CODE AND DTL.DO_SRL_NO = EXP.DO_SRL_NO AND DTL.PO_NO=EXP.PO_NO   AND DTL.PO_SRL_NO=EXP.PO_SRL_NO AND DTL.SCH_DELV_DATE=EXP.SCH_DELV_DATE  AND (EXP.DIST_STORE_CODE = ? OR EXP.DIST_STORE_CODE = '*A') AND (EXP.DIST_FACILITY_ID = ? OR EXP.DIST_FACILITY_ID = '*A')  AND HDR.SUPP_CODE = ?  AND HDR.DO_STATUS IN ('FN','PR') AND DO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901')),'DD/MM/YYYY')  AND NVL (TO_DATE (?, 'DD/MM/YYYY'), SYSDATE)  AND (NVL (EXP.DO_QTY_NORMAL, 0) - NVL (EXP.GRN_QTY, 0)) > 0   AND MMITEM.ITEM_CODE = DTL.ITEM_CODE  AND MMITEM.LANGUAGE_ID = ?  AND STITEM.ITEM_CODE = DTL.ITEM_CODE AND MMITEM.GEN_UOM_CODE = AM.UOM_CODE AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND EXP.DO_UOM = AM1.UOM_CODE AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND ST.ITEM_CODE(+) =  DTL.ITEM_CODE  AND ST.STORE_CODE(+) = ? AND DTL.DO_NO = ? AND DTL.ITEM_CODE LIKE ?) A  WHERE ITEM_QTY_NORMAL > 0 ORDER BY DO_NO, ITEM_DESC,PO_NO,REQ_NO";
		}else{
			//sql1 = "SELECT * FROM (SELECT DTL.DO_NO,DTL.DO_SRL_NO,DTL.PO_NO, DTL.PO_SRL_NO,(SELECT PUR_UNIT_CODE FROM PO_ORDER_HDR WHERE PO_NO=DTL.PO_NO)PUR_UNIT_CODE,DTL.ITEM_CODE, MMITEM.SHORT_DESC ITEM_DESC,EXP.DO_QTY_NORMAL DO_QTY,(EXP.DO_QTY_NORMAL - (  NVL (EXP.GRN_QTY, 0) + (SELECT NVL(SUM (NVL (BLOCKED_QTY, 0)),0) BLOCKED_QTY  FROM PO_ORDER_UNF_GRN  WHERE PO_NO = DTL.PO_NO AND ITEM_CODE = DTL.ITEM_CODE AND DO_NO = DTL.DO_NO ))) ITEM_QTY_NORMAL,NVL (DTL.UNIT_COST, 0) ITEM_UNIT_COST,((EXP.DO_QTY_NORMAL - (NVL (EXP.GRN_QTY, 0)) + (SELECT NVL(SUM (NVL (BLOCKED_QTY, 0)), 0) BLOCKED_QTY FROM PO_ORDER_UNF_GRN  WHERE PO_NO = DTL.PO_NO AND ITEM_CODE = DTL.ITEM_CODE AND DO_NO = DTL.DO_NO))* (  NVL (DTL.UNIT_COST, 0)* NVL (HDR.CONVERSION_RATE, 0))) ITEM_COST_VALUE,STOCK_ITEM_YN, DTL.DO_UOM PUR_UOM_CODE, AM1.SHORT_DESC PUR_UOM_DESC, AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.DO_CONV_FACTOR,STITEM.EXPIRY_YN, DO_QTY_BONUS, DO_QTY_SAMPLE, NVL (STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY, HDR.LOCAL_CURRENCY, HDR.CONVERSION_RATE, TO_CHAR (HDR.DO_DATE, 'DD/MM/YYYY') DO_DATE,  DTL.REQ_NO,DTL.REQ_FACILITY_ID,(SELECT REQ_SRL_NO FROM PO_REQUEST_DETAIL WHERE FACILITY_ID=DTL.REQ_FACILITY_ID AND REQ_NO=DTL.REQ_NO AND ITEM_CODE=DTL.ITEM_CODE)REQ_SRL_NO, ST.DEF_ISSUE_UOM ,EXP.BATCH_ID, TO_CHAR(EXP.EXPIRY_DATE,'DD/MM/YYYY')EXPIRY_DATE, TO_CHAR(EXP.SCH_DELV_DATE,'DD/MM/YYYY')SCH_DELV_DATE,HDR.INVOICE_NO,HDR.INVOICE_RECD_BY FROM PO_DELV_ORD_HDR HDR,  PO_DELV_ORD_DTL DTL, PO_DELV_ORD_DTL_BAT EXP, MM_ITEM_LANG_VW MMITEM,     ST_ITEM STITEM, AM_UOM_LANG_VW AM, ST_ITEM_STORE ST,AM_UOM_LANG_VW AM1 WHERE HDR.DO_NO = DTL.DO_NO  AND DTL.DO_NO= EXP.DO_NO AND DTL.ITEM_CODE=EXP.ITEM_CODE AND DTL.DO_SRL_NO = EXP.DO_SRL_NO AND DTL.PO_NO=EXP.PO_NO   AND DTL.PO_SRL_NO=EXP.PO_SRL_NO AND DTL.SCH_DELV_DATE=EXP.SCH_DELV_DATE  AND (EXP.DIST_STORE_CODE = ? OR EXP.DIST_STORE_CODE = '*A') AND (EXP.DIST_FACILITY_ID = ? OR EXP.DIST_FACILITY_ID = '*A')  AND HDR.SUPP_CODE = ?  AND HDR.DO_STATUS IN ('FN','PR') AND DO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901')),'DD/MM/YYYY')  AND NVL (TO_DATE (?, 'DD/MM/YYYY'), SYSDATE)  AND (NVL (EXP.DO_QTY_NORMAL, 0) - NVL (EXP.GRN_QTY, 0)) > 0   AND MMITEM.ITEM_CODE = DTL.ITEM_CODE  AND MMITEM.LANGUAGE_ID = ?  AND STITEM.ITEM_CODE = DTL.ITEM_CODE AND MMITEM.GEN_UOM_CODE = AM.UOM_CODE AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND DTL.DO_UOM = AM1.UOM_CODE AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND ST.ITEM_CODE(+) =  DTL.ITEM_CODE  AND ST.STORE_CODE(+) = ? AND DTL.DO_NO = ? AND DTL.ITEM_CODE LIKE ?) A  WHERE ITEM_QTY_NORMAL > 0  ORDER BY DO_NO, ITEM_DESC,PO_NO,REQ_NO";
			sql1 = "SELECT * FROM (SELECT DTL.DO_NO,DTL.DO_SRL_NO,DTL.PO_NO, DTL.PO_SRL_NO,(SELECT PUR_UNIT_CODE FROM PO_ORDER_HDR WHERE PO_NO=DTL.PO_NO)PUR_UNIT_CODE,DTL.ITEM_CODE, MMITEM.SHORT_DESC ITEM_DESC,EXP.DO_QTY_NORMAL DO_QTY,(EXP.DO_QTY_NORMAL - (  NVL (EXP.GRN_QTY, 0) + NVL (EXP.GRN_BLOCKED_QTY, 0))) ITEM_QTY_NORMAL,NVL (DTL.UNIT_COST, 0) ITEM_UNIT_COST,((EXP.DO_QTY_NORMAL - (NVL (EXP.GRN_QTY, 0)) + NVL (EXP.GRN_BLOCKED_QTY, 0))* (  NVL (DTL.UNIT_COST, 0)* NVL (HDR.CONVERSION_RATE, 0))) ITEM_COST_VALUE,STOCK_ITEM_YN, EXP.DO_UOM PUR_UOM_CODE, AM1.SHORT_DESC PUR_UOM_DESC, AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.DO_CONV_FACTOR,STITEM.EXPIRY_YN, nvl(DO_QTY_BONUS,0)DO_QTY_BONUS, nvl(DO_QTY_SAMPLE,0)DO_QTY_SAMPLE, NVL (STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY, HDR.LOCAL_CURRENCY, HDR.CONVERSION_RATE, TO_CHAR (HDR.DO_DATE, 'DD/MM/YYYY') DO_DATE,  DTL.REQ_NO,DTL.REQ_FACILITY_ID,(SELECT REQ_SRL_NO FROM PO_REQUEST_DETAIL WHERE FACILITY_ID=DTL.REQ_FACILITY_ID AND REQ_NO=DTL.REQ_NO AND ITEM_CODE=DTL.ITEM_CODE)REQ_SRL_NO, ST.DEF_ISSUE_UOM ,EXP.BATCH_ID, TO_CHAR(EXP.EXPIRY_DATE,'DD/MM/YYYY')EXPIRY_DATE, TO_CHAR(EXP.SCH_DELV_DATE,'DD/MM/YYYY')SCH_DELV_DATE,HDR.INVOICE_NO,HDR.INVOICE_RECD_BY FROM PO_DELV_ORD_HDR HDR,  PO_DELV_ORD_DTL DTL, PO_DELV_ORD_DTL_BAT EXP, MM_ITEM_LANG_VW MMITEM,     ST_ITEM STITEM, AM_UOM_LANG_VW AM, ST_ITEM_STORE ST,AM_UOM_LANG_VW AM1 WHERE HDR.DO_NO = DTL.DO_NO  AND DTL.DO_NO= EXP.DO_NO AND DTL.ITEM_CODE=EXP.ITEM_CODE AND DTL.DO_SRL_NO = EXP.DO_SRL_NO AND DTL.PO_NO=EXP.PO_NO   AND DTL.PO_SRL_NO=EXP.PO_SRL_NO AND DTL.SCH_DELV_DATE=EXP.SCH_DELV_DATE  AND (EXP.DIST_STORE_CODE = ? OR EXP.DIST_STORE_CODE = '*A') AND (EXP.DIST_FACILITY_ID = ? OR EXP.DIST_FACILITY_ID = '*A')  AND HDR.SUPP_CODE = ?  AND HDR.DO_STATUS IN ('FN','PR') AND DO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901')),'DD/MM/YYYY')  AND NVL (TO_DATE (?, 'DD/MM/YYYY'), SYSDATE)  AND (NVL (EXP.DO_QTY_NORMAL, 0) - NVL (EXP.GRN_QTY, 0)) > 0   AND MMITEM.ITEM_CODE = DTL.ITEM_CODE  AND MMITEM.LANGUAGE_ID = ?  AND STITEM.ITEM_CODE = DTL.ITEM_CODE AND MMITEM.GEN_UOM_CODE = AM.UOM_CODE AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND EXP.DO_UOM = AM1.UOM_CODE AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND ST.ITEM_CODE(+) =  DTL.ITEM_CODE  AND ST.STORE_CODE(+) = ? AND DTL.DO_NO = ? AND DTL.ITEM_CODE LIKE ?) A  WHERE ITEM_QTY_NORMAL > 0  ORDER BY DO_NO, ITEM_DESC,PO_NO,REQ_NO";
		}
		


		ArrayList alExpData =  (ArrayList)bean.fetchRecords(sql1,stParameters1);
		
        int alsize = alExpData.size();
		if ( alsize > 0 ){
		hmExpData.put((String)hm.get("DO_NO"),alExpData);
		j++;
		}
		else{
        alTemp.remove(j);
		total--;
		}
	}

	System.out.println("hmExpData"+hmExpData);
		bean.setPoItemDetails(hmExpData);

	%>
	<base target=_self>
	</head>
<body>
	<form name= "formDOItemDetailResult">

	<table border='1' cellpadding='0' cellspacing='0' width='100%' align=center>
        <tr><th align='center' ><fmt:message key="eST.DelieveryOrderDetails.label" bundle="${st_labels}"/></th></tr>
	</table>	
	
	<input type="hidden" name="store_code" id="store_code" value="<%=store_code%>">
	<input type="hidden" name="selected_doc_no" id="selected_doc_no" value="">
	<input type="hidden" name="sel_doc_batch_count" id="sel_doc_batch_count" value="">
	<input type="hidden" name="prev_ind" id="prev_ind" value="">
	<input type="hidden" name="total" id="total" value="<%=total%>">
	<input type="hidden" name="phy_inv_id" id="phy_inv_id" value="">
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="sys_date" id="sys_date" value="<%=com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString()%>">

	<div style="overflow:scroll;height:380px;width:100%;overflow:auto">     
	<%
	for(int k=0;k<total;k++ ){  
	hmTemp = (HashMap)alTemp.get(k);

	 ArrayList alBatchDetails = (ArrayList)hmExpData.get((String)hmTemp.get("DO_NO"));

	 new_do_no = bean.checkForNull((String)hmTemp.get("DO_NO"));
	 
	 int batchcount =	 alBatchDetails.size();
	
	 classValue	=	"QRYODD";

	%>
	
	<table  border = '0' cellpadding='0' cellspacing='0' width='100%' align=center>
		<tr>
		<td align='left' width='20%'><input type="radio" name="doc_no_radio" id="doc_no_radio" id="doc_no_radio" value="<%=bean.checkForNull((String)hmTemp.get("DO_NO"))%>"  onClick='enable_doc(this, "<%=batchcount%>","<%=k%>","D");'  >
		<label style="font-family:verdana;font-size:10"><b><%=bean.checkForNull((String)hmTemp.get("DO_NO"))%></b></label>&nbsp;</td>
	    </tr>
	</table>

	<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center'>
			<tr>
                <th><fmt:message key="Common.Select.label"      bundle="${common_labels}"/></th>
		        <th><fmt:message key="Common.item.label"        bundle="${common_labels}"/></th>
		        <th><fmt:message key="eST.PONo.label"        bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.StockUOM.label"    bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.ReqNo.label" bundle="${st_labels}"/></th>
				<th colspan=2><fmt:message key="eST.DOQty.label"     bundle="${st_labels}"/></th>	
				<th><fmt:message key="Common.BatchID.label"     bundle="${common_labels}"/></th>	
				<th><fmt:message key="Common.expiryDate.label"     bundle="${common_labels}"/></th>	
				<th nowrap>Pending Qty</th>
				<th><fmt:message key="eST.GRNQuantity.label"   bundle="${st_labels}"/></th>

			</tr>
			<%
		for(int i=0;i<alBatchDetails.size();i++){

		HashMap hmBatchDetails = (HashMap)alBatchDetails.get(i);
		
		System.out.println("hmBatchDetails"+hmBatchDetails);

		st_uom_code = bean.checkForNull((String)hmBatchDetails.get("DEF_ISSUE_UOM"));

			if(st_uom_code.equals("")){
			temp=null;

			String[] qtyparam1 = {(String)hmBatchDetails.get("ITEM_CODE"),store_code};
			temp = bean.fetchRecord("SELECT DEF_ISSUE_UOM  FROM ST_ITEM_STORE WHERE ITEM_CODE=? and STORE_CODE = ? " ,qtyparam1);

			st_uom_code = bean.checkForNull((String)temp.get("DEF_ISSUE_UOM"));
			}
		
			st_uom_desc = bean.checkForNull(bean.getUOMDesc(st_uom_code));
			
			if(!bean.checkForNull((String)hmBatchDetails.get("PO_NO")).equals("*A"))
				po_no_ref = bean.checkForNull((String)hmBatchDetails.get("PO_NO"));
			else
				po_no_ref="";

		%>
		 <tr>	                                                                         
            <td class="<%=classValue%>"  width='2%'><input type="checkbox"  id='doc_no_<%=new_do_no%>_<%=i%>'   name='doc_no_<%=new_do_no%>_<%=i%>'  value="<%=new_do_no%>" onClick="getItemQty(this,'<%=i%>','D','<%=batchcount%>');"  disabled  > </td>
			<td class="<%=classValue%>"  width='25%' ><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("ITEM_DESC"))%></label>&nbsp;</td>
			<td class="<%=classValue%>"  width='10%' ><label style="font-family:verdana;font-size:10"><%=po_no_ref%></label>&nbsp;</td>
			<td	class="<%=classValue%>"  width='10%'><label style="font-family:verdana;font-size:10"><%=st_uom_desc%></label>&nbsp;</td>
			<td	class="<%=classValue%>"  width='10%'><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("REQ_NO"))%></label>&nbsp;
			<td class="<%=classValue%>"  width='10%' style='text-align:right;'><label  style="font-family:verdana;font-size:10;text-align:right;"><%=bean.checkForNull((String)hmBatchDetails.get("DO_QTY"))%></label> &nbsp;</td>
			<td	class="<%=classValue%>"  width='10%'><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("PUR_UOM_DESC"))%></label>
			<td	class="<%=classValue%>"  width='10%'><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("BATCH_ID"))%></label>
			<td	class="<%=classValue%>"  width='10%'><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("EXPIRY_DATE"))%></label>
			<!--<td	class="<%=classValue%>"  width='10%'><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("TRADE_ID"))%></label>-->
			<td class="<%=classValue%>"  width='10%' style='text-align:right;'><label  style="font-family:verdana;font-size:10;text-align:right;"><%=bean.checkForNull((String)hmBatchDetails.get("ITEM_QTY_NORMAL"))%></label> &nbsp;</td>
			<td class="<%=classValue%>" ><input style='text-align:right;' type="text" id='grn_item_qty_<%=i%>' name='grn_item_qty_<%=new_do_no%>_<%=i%>'  size="10" maxlength="10" onKeyPress="return isValidNumberforMultiLine(this,event,8,<%=no_deci%>,allow_deci_<%=new_do_no%>_<%=i%>);" onBlur="checkDoubleFormat(this);MandatoryChkForDelDate('<%=batchcount%>')"  disabled   >  </td>

			<input type="hidden" name='item_code_<%=new_do_no%>_<%=i%>' id='item_code_<%=new_do_no%>_<%=i%>'       value="<%=bean.checkForNull((String)hmBatchDetails.get("ITEM_CODE"))%>">
			<input type="hidden" name='req_no_<%=new_do_no%>_<%=i%>' id='req_no_<%=new_do_no%>_<%=i%>'          value="<%=bean.checkForNull((String)hmBatchDetails.get("REQ_NO"))%>">
			<input type="hidden" name='do_qty_<%=new_do_no%>_<%=i%>' id='do_qty_<%=new_do_no%>_<%=i%>' 		  value="<%=bean.checkForNull((String)hmBatchDetails.get("ITEM_QTY_NORMAL"))%>">			
			<input type="hidden" name='do_srl_no_<%=new_do_no%>_<%=i%>' id='do_srl_no_<%=new_do_no%>_<%=i%>' 		  value="<%=bean.checkForNull((String)hmBatchDetails.get("DO_SRL_NO"))%>">					
			<input type="hidden" name='sch_date_<%=new_do_no%>_<%=i%>' id='sch_date_<%=new_do_no%>_<%=i%>' 		  value="<%=bean.checkForNull((String)hmBatchDetails.get("SCH_DELV_DATE"))%>">					
			<input type="hidden" name='batch_id_<%=new_do_no%>_<%=i%>' id='batch_id_<%=new_do_no%>_<%=i%>' 		  value="<%=bean.checkForNull((String)hmBatchDetails.get("BATCH_ID"))%>">					
			<input type="hidden" name='expiry_date_<%=new_do_no%>_<%=i%>' id='expiry_date_<%=new_do_no%>_<%=i%>' 		  value="<%=bean.checkForNull((String)hmBatchDetails.get("EXPIRY_DATE"))%>">				
			<input type="hidden" name='local_currency_<%=new_do_no%>_<%=i%>' id='local_currency_<%=new_do_no%>_<%=i%>'  value="<%=bean.checkForNull((String)hmBatchDetails.get("LOCAL_CURRENCY"))%>">	
			<input type="hidden" name='trans_currency_<%=new_do_no%>_<%=i%>' id='trans_currency_<%=new_do_no%>_<%=i%>'  value="<%=bean.checkForNull((String)hmBatchDetails.get("TRANS_CURRENCY"))%>">	
			<input type="hidden" name='conversion_rate_<%=new_do_no%>_<%=i%>' id='conversion_rate_<%=new_do_no%>_<%=i%>' value="<%=bean.checkForNull((String)hmBatchDetails.get("CONVERSION_RATE"))%>">	
			<input type="hidden" name='allow_deci_<%=new_do_no%>_<%=i%>' id='allow_deci_<%=new_do_no%>_<%=i%>' 	  value="<%=bean.checkForNull((String)hmBatchDetails.get("ALLOW_DECIMALS_YN"),"N")%>">				
			<input type="hidden" name='po_no_<%=new_do_no%>_<%=i%>' id='po_no_<%=new_do_no%>_<%=i%>' 		  value="<%=bean.checkForNull((String)hmBatchDetails.get("PO_NO"))%>">				
			<input type="hidden" name='po_srl_no_<%=new_do_no%>_<%=i%>' id='po_srl_no_<%=new_do_no%>_<%=i%>' 		  value="<%=bean.checkForNull((String)hmBatchDetails.get("PO_SRL_NO"))%>">			
			<input type="hidden" name='invoice_no_<%=new_do_no%>_<%=i%>' id='invoice_no_<%=new_do_no%>_<%=i%>' 		  value="<%=bean.checkForNull((String)hmBatchDetails.get("INVOICE_NO"))%>">				
			<input type="hidden" name='invoice_received_by_<%=new_do_no%>_<%=i%>' id='invoice_received_by_<%=new_do_no%>_<%=i%>' 		  value="<%=bean.checkForNull((String)hmBatchDetails.get("INVOICE_RECD_BY"))%>">	
		</tr>
	<%}%>
		<tr> 	    
		<td class="<%=classValue%>" colspan="12" style="text-align:right"> <input align="right" type=button name='apply_<%=new_do_no%>_<%=k%>' id='apply_<%=new_do_no%>_<%=k%>'   value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>'    align='right' class=button onclick="onadddo('<%=batchcount%>');"  disabled >	 </td>
		</tr>
	</table>

	<%
	}
	%>
	</div>
	</form>

	</body>
</html>

