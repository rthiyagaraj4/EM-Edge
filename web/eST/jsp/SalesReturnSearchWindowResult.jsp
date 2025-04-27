<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
24/09/2020  	IN074078        B Haribabu          24/09/2020                          SKR-SCF-1441
27/07/2022		34089			Ramesh G 									PMG2022-COMN-CRF-0044
---------------------------------------------------------------------------------------------------------------
*/ 
%> 
<%@ page import=" eST.*,eST.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<%
		request.setCharacterEncoding("UTF-8");
		String locale		=	(String)session.getAttribute("LOCALE");
		String login_user = (String)session.getValue("login_user") == null ? "" : (String)session.getValue("login_user"); //34089
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/SalesReturn.js"></script>
    	<script language='javascript' src='../../eST/js/StTransaction.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




<%    
	String patient_id           ="";
	String encounter_id         ="";
	String patient_name         ="";
	String bean_id              ="";
    String bean_name            ="";
    String sal_trn_type         ="";
	String chargeable_yn        ="";
	String store_code           ="";
	String from_doc_date        ="";
	String to_doc_date          ="";
	String item_code            ="";
	String item_desc            ="";
	String doc_no               ="";
	String sal_patient_name     ="";
	String batch_id = "";
	String trade_id = "";
	String expiry_date = "";
	String bin_location="";
	
	java.util.Properties prop   = (java.util.Properties) session.getValue( "jdbc" ) ;
	String login_at_ws_no		= prop.getProperty( "client_ip_address" );
	bean_id						= "salesReturnBean"+login_at_ws_no;
	bean_name					= "eST.SalesReturnBean";

   
	SalesReturnBean bean = (SalesReturnBean) getBeanObject( bean_id, bean_name,request );

	patient_id           =  request.getParameter( "patient_id"   );
	encounter_id         =  request.getParameter( "encounter_id" );
    patient_name         =  CommonBean.checkForNull(request.getParameter("patient_name"),"%")+'%';
	sal_trn_type         =  request.getParameter( "sal_trn_type" );
	chargeable_yn        =  request.getParameter( "chargeable_yn");
	store_code           =  request.getParameter( "store_code"   );
	item_desc            =  CommonBean.checkForNull(request.getParameter("item_desc"),"");
	item_code            =  request.getParameter("item_desc").equals("")? "%": request.getParameter("item_code");
	from_doc_date        =  CommonBean.checkForNull(request.getParameter("from_doc_date"),"");
	to_doc_date          =  CommonBean.checkForNull(request.getParameter("to_doc_date"),"");

	if(!(from_doc_date.equals("")))
	  from_doc_date		 =	DateUtils.convertDate(from_doc_date,"DMY",locale,"en");
	
	if(!(to_doc_date.equals("")))
	  to_doc_date			 =	DateUtils.convertDate(to_doc_date,"DMY",locale,"en");

	doc_no               =  CommonBean.checkForNull(request.getParameter("doc_no"),"%");

	
	batch_id        =  CommonBean.checkForNull(request.getParameter("batch_id"),"");
	expiry_date     =  CommonBean.checkForNull(request.getParameter("expiry_date"),"");	
	trade_id        =  CommonBean.checkForNull(request.getParameter("trade_id"),"");
	bin_location    =  CommonBean.checkForNull(request.getParameter("binlocation"),"");
	
	String barcode_yn     =	bean.checkForNull(bean.getBarcodeApplicable(),"N");
	System.out.println("barcode_yn==>"+barcode_yn);

	int no_deci                   =    bean.getNoOfDecimals();


    //String []stParameters = {patient_id,encounter_id,store_code,doc_no,from_doc_date,to_doc_date,patient_name}; 
	//String sql = "SELECT DISTINCT a.doc_no, a.doc_type_code, a.facility_id, A.PATIENT_NAME  FROM st_sal_hdr a,  st_sal_dtl b, st_sal_dtl_exp c, mm_item d, mm_bin_location e,  am_trade_name f  WHERE a.finalized_yn = 'Y'  /*AND a.billable_trn_yn = 'Y'*/  AND a.patient_id = ?  AND a.module_id = 'ST'  AND NVL (a.encounter_id, 1) = NVL (?, 1)  AND a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code  AND a.doc_no = b.doc_no  AND b.item_code = d.item_code  AND b.facility_id = c.facility_id  AND b.doc_type_code = c.doc_type_code  AND b.doc_no = c.doc_no  AND b.doc_srl_no = c.doc_srl_no  AND c.bin_location_code = e.bin_location_code  AND c.store_code = e.store_code  AND c.trade_id = f.trade_id(+) AND (NVL (c.sal_item_qty, 0) - NVL (c.ret_item_qty, 0)) > 0  AND a.store_code = ? AND a.doc_no like ?  AND a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )  AND NVL (TO_DATE (?, 'dd/mm/yyyy'), SYSDATE)  AND (A.PATIENT_NAME IS NULL OR UPPER(A.PATIENT_NAME) like UPPER (?))";

	String []stParameters = {patient_id,encounter_id,store_code,from_doc_date,to_doc_date,patient_name};
	String sql = "SELECT DISTINCT a.doc_no, a.doc_type_code, a.facility_id, A.PATIENT_NAME  FROM st_sal_hdr a,  st_sal_dtl b, st_sal_dtl_exp c, mm_item d, mm_bin_location e,  am_trade_name f  WHERE a.finalized_yn = 'Y'  /*AND a.billable_trn_yn = 'Y'*/  AND a.patient_id = ?  AND a.module_id = 'ST'  AND NVL (a.encounter_id, 1) = NVL (?, 1)  AND a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code  AND a.doc_no = b.doc_no  AND b.item_code = d.item_code  AND b.facility_id = c.facility_id  AND b.doc_type_code = c.doc_type_code  AND b.doc_no = c.doc_no  AND b.doc_srl_no = c.doc_srl_no  AND c.bin_location_code = e.bin_location_code  AND c.store_code = e.store_code  AND c.trade_id = f.trade_id(+) AND (NVL (c.sal_item_qty, 0) - NVL (c.ret_item_qty, 0)) > 0  AND a.store_code = ? AND a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )  AND NVL (TO_DATE (?, 'dd/mm/yyyy'), SYSDATE)  AND (A.PATIENT_NAME IS NULL OR UPPER(A.PATIENT_NAME) like UPPER (?))  ";

	
	if(doc_no != "%")
	{	
		sql = sql + " and a.doc_no = " + "'"+doc_no+"'" ;
	}
	if(item_code != "%")
	{	
		sql = sql + " and b.item_code = " + "'"+item_code+"'" ;
	}
	
	if(barcode_yn.equals("Y") && item_code != "%"){ 
		if(batch_id != "")
		{	
		sql = sql + " and c.batch_id = " + "'"+batch_id+"'" ;
		}
		if(expiry_date != "")
		{	
		sql = sql + " and to_char(c.expiry_date_or_receipt_date,'dd/mm/yyyy') = "+"'"+expiry_date+"'";
		}
		if(trade_id != "")
		{	
		sql = sql + " and c.trade_id = " + "'"+trade_id+"'" ;
		}
		if(bin_location != "")
		{	
		sql = sql + " and c.bin_location_code = " + "'"+bin_location+"'" ;
		}
	}

	System.out.println("sql==>"+sql);

	ArrayList alTemp = new ArrayList();
	alTemp =  bean.fetchRecords(sql,stParameters);
	System.out.println("alTemp==>"+alTemp);

	int total = alTemp.size();	
	if(total ==0){
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				//document.parentWindow.close();
			</script>
		<%		
	}
	HashMap hmExpData = new HashMap();
	
	for(int i=0;i<total;){		
		HashMap hm = (HashMap)alTemp.get(i);
		//String []stParameters1 = {patient_id,encounter_id,(String)hm.get("DOC_NO"),(String)hm.get("DOC_TYPE_CODE"),(String)hm.get("FACILITY_ID"),item_code};
		//34089 Start.
		//String []stParameters1 = {patient_id,encounter_id,(String)hm.get("DOC_NO"),(String)hm.get("DOC_TYPE_CODE"),(String)hm.get("FACILITY_ID")};
		String []stParameters1 = {login_user,patient_id,encounter_id,(String)hm.get("DOC_NO"),(String)hm.get("DOC_TYPE_CODE"),(String)hm.get("FACILITY_ID")};

		//34089 End.
		
		//ArrayList alExpData =  (ArrayList)bean.fetchRecords("SELECT   a.facility_id, a.doc_type_code, a.doc_no, a.store_code, a.patient_id, a.encounter_id, a.sal_trn_type, b.doc_srl_no, b.item_code, d.short_desc item_name, c.batch_id, TO_CHAR (c.expiry_date_or_receipt_date,'dd/mm/yyyy') expiry_date_or_receipt_date, c.trade_id, nvl(f.short_name,c.trade_id) trade_name, c.bin_location_code, e.short_desc bin_location,(NVL(c.sal_item_qty,0) - NVL (c.ret_item_qty, 0)) sal_item_qty, b.item_cost_value item_cost, d.gen_uom_code uom_code, g.expiry_yn expiry_yn, d.ps_item_yn stock_item_yn, g.REFUND_ALLOW_YN REFUND_ALLOW_YN, h.short_desc uom_desc  FROM st_sal_hdr a, st_sal_dtl b, st_sal_dtl_exp c, mm_item d, mm_bin_location e, am_trade_name f, st_item g, am_uom h WHERE a.finalized_yn = 'Y' /*AND a.billable_trn_yn = 'Y'*/  AND a.patient_id = ?  AND NVL (a.encounter_id, 1) = NVL (?, 1) AND a.doc_no = ? AND a.doc_type_code = ?  AND a.facility_id = ?  AND a.module_id = 'ST' AND a.facility_id = b.facility_id AND a.doc_type_code = b.doc_type_code  AND a.doc_no = b.doc_no  AND b.item_code = d.item_code  AND d.item_code = g.item_code AND b.facility_id = c.facility_id AND b.doc_type_code = c.doc_type_code  AND b.doc_no = c.doc_no AND b.doc_srl_no = c.doc_srl_no AND c.bin_location_code = e.bin_location_code  AND c.store_code = e.store_code AND c.trade_id = f.trade_id(+) AND h.uom_code = d.gen_uom_code  AND (NVL(c.sal_item_qty,0) - NVL (c.ret_item_qty, 0)) > 0  AND b.item_code like upper(?)  ORDER BY a.facility_id, a.doc_type_code, a.doc_no, b.doc_srl_no",stParameters1);
		//34089 Start.
		//ArrayList alExpData =  (ArrayList)bean.fetchRecords("SELECT   a.facility_id, a.doc_type_code, a.doc_no, a.store_code, a.patient_id, a.encounter_id, a.sal_trn_type, b.doc_srl_no, b.item_code, d.short_desc item_name, c.batch_id, TO_CHAR (c.expiry_date_or_receipt_date,'dd/mm/yyyy') expiry_date_or_receipt_date, c.trade_id, nvl(f.short_name,c.trade_id) trade_name, c.bin_location_code, e.short_desc bin_location,(NVL(c.sal_item_qty,0) - NVL (c.ret_item_qty, 0)) sal_item_qty, b.item_cost_value item_cost, d.gen_uom_code uom_code, g.expiry_yn expiry_yn, d.ps_item_yn stock_item_yn, g.REFUND_ALLOW_YN REFUND_ALLOW_YN, h.short_desc uom_desc,nvl(g.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN  FROM st_sal_hdr a, st_sal_dtl b, st_sal_dtl_exp c, mm_item d, mm_bin_location e, am_trade_name f, st_item g, am_uom h WHERE a.finalized_yn = 'Y' /*AND a.billable_trn_yn = 'Y'*/  AND a.patient_id = ?  AND NVL (a.encounter_id, 1) = NVL (?, 1) AND a.doc_no = ? AND a.doc_type_code = ?  AND a.facility_id = ?  AND a.module_id = 'ST' AND a.facility_id = b.facility_id AND a.doc_type_code = b.doc_type_code  AND a.doc_no = b.doc_no  AND b.item_code = d.item_code  AND d.item_code = g.item_code AND b.facility_id = c.facility_id AND b.doc_type_code = c.doc_type_code  AND b.doc_no = c.doc_no AND b.doc_srl_no = c.doc_srl_no AND c.bin_location_code = e.bin_location_code  AND c.store_code = e.store_code AND c.trade_id = f.trade_id(+) AND h.uom_code = d.gen_uom_code  AND (NVL(c.sal_item_qty,0) - NVL (c.ret_item_qty, 0)) > 0  ORDER BY a.facility_id, a.doc_type_code, a.doc_no, b.doc_srl_no",stParameters1);
		ArrayList alExpData =  (ArrayList)bean.fetchRecords("SELECT   a.facility_id, a.doc_type_code, a.doc_no, a.store_code, a.patient_id, a.encounter_id, a.sal_trn_type, b.doc_srl_no, b.item_code, d.short_desc item_name, c.batch_id, TO_CHAR (c.expiry_date_or_receipt_date,'dd/mm/yyyy') expiry_date_or_receipt_date, c.trade_id, nvl(f.short_name,c.trade_id) trade_name, c.bin_location_code, e.short_desc bin_location,(NVL(c.sal_item_qty,0) - NVL (c.ret_item_qty, 0)) sal_item_qty, b.item_cost_value item_cost, d.gen_uom_code uom_code, g.expiry_yn expiry_yn, d.ps_item_yn stock_item_yn, g.REFUND_ALLOW_YN REFUND_ALLOW_YN, h.short_desc uom_desc,nvl(g.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,NVL((select 'Y' from MM_USER_MATERIAL_GROUP where material_group_code=d.material_group_code and user_id=? and EFF_STATUS='E'),'N') MATERIAL_GROUP_ACESS_YN  FROM st_sal_hdr a, st_sal_dtl b, st_sal_dtl_exp c, mm_item d, mm_bin_location e, am_trade_name f, st_item g, am_uom h WHERE a.finalized_yn = 'Y' /*AND a.billable_trn_yn = 'Y'*/  AND a.patient_id = ?  AND NVL (a.encounter_id, 1) = NVL (?, 1) AND a.doc_no = ? AND a.doc_type_code = ?  AND a.facility_id = ?  AND a.module_id = 'ST' AND a.facility_id = b.facility_id AND a.doc_type_code = b.doc_type_code  AND a.doc_no = b.doc_no  AND b.item_code = d.item_code  AND d.item_code = g.item_code AND b.facility_id = c.facility_id AND b.doc_type_code = c.doc_type_code  AND b.doc_no = c.doc_no AND b.doc_srl_no = c.doc_srl_no AND c.bin_location_code = e.bin_location_code  AND c.store_code = e.store_code AND c.trade_id = f.trade_id(+) AND h.uom_code = d.gen_uom_code  AND (NVL(c.sal_item_qty,0) - NVL (c.ret_item_qty, 0)) > 0  ORDER BY a.facility_id, a.doc_type_code, a.doc_no, b.doc_srl_no",stParameters1);
		
		//34089 End.
			System.out.println("alExpData==>"+alExpData);

        int alsize = alExpData.size();
		if ( alsize > 0 ){
		hmExpData.put((((String)hm.get("DOC_NO"))+((String)hm.get("DOC_TYPE_CODE"))),alExpData); //Modified for IN074078
		i++;
		}
		else{
        alTemp.remove(i);
		total--;
		}
	}	
//	int flag=0;
	String classValue			= "";

	%>
	<base target=_self>
	</head>
<body>
	<form name= "formSalesReturnSearchWindowResult">

	<table border='1' cellpadding='0' cellspacing='0' width='100%' align=center>
        <tr><th align='center' ><fmt:message key="eST.TransactionDetails.label" bundle="${st_labels}"/></th>	</tr>
	</table>
	<!--added above, if more records for one patient id gives script error-->
	
	<input type="hidden" name="finalstring" id="finalstring" value="<%=request.getQueryString()%>">
	<input type="hidden" name="chargeable_yn" id="chargeable_yn" value="<%=chargeable_yn%>">
	<input type="hidden" name="sal_trn_type" id="sal_trn_type" value="<%=sal_trn_type%>">
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
	<input type="hidden" name="store_code" id="store_code" value="<%=store_code%>">
	<input type="hidden" name="patient_name" id="patient_name" value="<%=patient_name%>" >
	<input type="hidden" name="selected_doc_no" id="selected_doc_no" value="">
	<input type="hidden" name="prevdoc_type" id="prevdoc_type" value=""> <!-- added for IN074078-->
	<input type="hidden" name="sel_doc_batch_count" id="sel_doc_batch_count" value="">
	<input type="hidden" name="prev_ind" id="prev_ind" value="">
	<input type="hidden" name="total" id="total" value="<%=total%>">
        
<% 
		String new_doc_no ="";
		String	new_doc_type_code =""; //added for  IN074078
		for(int i=0;i<total;i++ ){  
	        HashMap hmTemp = new HashMap();
            hmTemp = (HashMap)alTemp.get(i);
			sal_patient_name = bean.checkForNull((String)hmTemp.get("PATIENT_NAME"));
			ArrayList alBatchDetails = (ArrayList)hmExpData.get(((String)hmTemp.get("DOC_NO")+(String)hmTemp.get("DOC_TYPE_CODE"))); //modified for  IN074078
			int batchcount = alBatchDetails.size();
			new_doc_no = bean.checkForNull((String)hmTemp.get("DOC_NO"));
			new_doc_type_code = bean.checkForNull((String)hmTemp.get("DOC_TYPE_CODE")); //added for  IN074078
%>

        <table  border = '0' cellpadding='0' cellspacing='0' width='100%' align=center>
		<tr>
		<td align='left' width='20%'><input type="radio" name="doc_no_radio" id="doc_no_radio" id="doc_no_radio" value="<%=bean.checkForNull((String)hmTemp.get("DOC_NO"))%>"  onClick='enable_doc(this, "<%=batchcount%>","<%=i%>","<%=bean.checkForNull((String)hmTemp.get("DOC_TYPE_CODE"))%>");'  > <!--modified for  IN074078-->
		<label style="font-family:verdana;font-size:10"><b><%=bean.checkForNull((String)hmTemp.get("DOC_TYPE_CODE"))%></b></label>&nbsp;
        <label style="font-family:verdana;font-size:10"><b><%=new_doc_no%></b></label></td>

		<% if(sal_trn_type.equals("X")){%>
		<td width='10%'><label style="font-family:verdana;font-size:10"><b><fmt:message key="Common.PatientName.label" bundle="${common_labels}" />&nbsp;:</b></label></td>
		<td><label  style="font-family:verdana;font-size:10;"><b><%=sal_patient_name%></b></label> 
		<input type="hidden" name='sal_patient_name_<%=new_doc_no%>' id='sal_patient_name_<%=new_doc_no%>' value="<%=sal_patient_name%>"></td>
		
	    <%}%>
		</td>
	    </tr>
		</table>
		<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center'>
			<tr>
                <th>
                
                <!-- Added by Sharanraj for GHL-CRF-0483 starts -->
                <fmt:message key="Common.selectall.label"      bundle="${common_labels}"  />
               
                <input type="checkbox" name='chkAll_<%=new_doc_no%>_<%=new_doc_type_code%>' id='chkAll_<%=new_doc_no%>_<%=new_doc_type_code%>'  id="chkAll<%=new_doc_no%>_<%=new_doc_type_code%>"    value="<%=bean.checkForNull((String)hmTemp.get("DOC_NO"))%>"  onclick='chkALl(this, "<%=batchcount%>","<%=i%>","<%=new_doc_type_code%>");'  disabled >  <!--modified for  IN074078-->
                
				<!-- Added by Sharanraj for GHL-CRF-0483 ends -->                
                
                </th>
		       <th ><fmt:message key="Common.item.label"        bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.TradeName.label"   bundle="${common_labels}"/></th> 
				<th><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.BatchID.label"     bundle="${common_labels}"/></th>
                <th><fmt:message key="Common.expiryDate.label"  bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.AvailableQty.label"   bundle="${st_labels}"/></th>
			    <th><fmt:message key="eST.SaleUOM.label"        bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.ReturnQty.label"   bundle="${common_labels}"/></th>
       </tr>
		<%
		     for(int j=0;j<alBatchDetails.size();j++){
			 HashMap hmBatchDetails = (HashMap)alBatchDetails.get(j);
			// System.out.println("hmBatchDetails==>"+hmBatchDetails);	

             //classValue	=	((flag%2)==0)?"QRYODD":"QRYEVEN";

			 if(barcode_yn.equals("Y")){ 
			 if(item_code.equals((String)hmBatchDetails.get("ITEM_CODE")) && batch_id.equals((String)hmBatchDetails.get("BATCH_ID")) && expiry_date.equals((String)hmBatchDetails.get("EXPIRY_DATE_OR_RECEIPT_DATE")) && trade_id.equals((String)hmBatchDetails.get("TRADE_ID")))
			 classValue	=	"STLIGHTPINK";
			 else if(item_code.equals((String)hmBatchDetails.get("ITEM_CODE")) && batch_id.equals("") && expiry_date.equals("") && trade_id.equals(""))	
			 classValue	=	"STLIGHTPINK";
			 else 
			 classValue	=	"QRYODD";
			}else{
			 if(item_code.equals((String)hmBatchDetails.get("ITEM_CODE")))
			 classValue	=	"STLIGHTPINK";
			 else
			 classValue	=	"QRYODD";			
			}


             String refund_allow_yn = bean.checkForNull((String)hmBatchDetails.get("REFUND_ALLOW_YN"));
	
	     if (refund_allow_yn.equals("Y")){
         %>

			<TR>	                                                                         
            <td class="<%=classValue%>"   width='6%'>
	    <!-- Modified for  IN074078-->
            <input type="checkbox"  id='doc_no_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>'   name='doc_no_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>'  value="<%=new_doc_no%>" onClick='getItemQty(this,<%=j%>,"<%=new_doc_type_code%>");chkSel(this,"<%=batchcount%>",<%=j%>,"<%=new_doc_type_code%>");'  disabled  >  <!--  Added chkSel function by sharanraj against GHL-CRF-0483--> 
			<input type="hidden" name='doc_type_code_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' id='doc_type_code_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' value="<%=bean.checkForNull((String)hmBatchDetails.get("DOC_TYPE_CODE"))%>">
			<input type="hidden" name='material_group_access_yn_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' id='material_group_access_yn_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' value="<%=bean.checkForNull((String)hmBatchDetails.get("MATERIAL_GROUP_ACESS_YN"))%>"> <!-- 34089 -->
			</td>
			<td class="<%=classValue%>"   width='30%' ><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("ITEM_NAME"))%></label>&nbsp;
			<input type="hidden" name='item_code_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' id='item_code_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>'       value="<%=bean.checkForNull((String)hmBatchDetails.get("ITEM_CODE"))%>">
			<input type="hidden" name='item_name_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' id='item_name_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>'       value="<%=java.net.URLEncoder.encode(bean.checkForNull((String)hmBatchDetails.get("ITEM_NAME")))%>">			
			<input type="hidden" name='item_cost_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' id='item_cost_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>'       value="<%=bean.checkForNull((String)hmBatchDetails.get("ITEM_COST"))%>">			
			<input type="hidden" name='expiry_yn_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' id='expiry_yn_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>'       value="<%=bean.checkForNull((String)hmBatchDetails.get("EXPIRY_YN"))%>">
			<input type="hidden" name='refund_allow_yn_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' id='refund_allow_yn_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' value="<%=bean.checkForNull((String)hmBatchDetails.get("REFUND_ALLOW_YN"))%>">
			<input type="hidden" name='stock_item_yn_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' id='stock_item_yn_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>'   value="<%=bean.checkForNull((String)hmBatchDetails.get("STOCK_ITEM_YN"))%>">
			<input type="hidden" name='doc_srl_no_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' id='doc_srl_no_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>'      value="<%=bean.checkForNull((String)hmBatchDetails.get("DOC_SRL_NO"))%>">
			<input type="hidden" name='srl_no_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' id='srl_no_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>'          value="<%=j%>"></td>
			<td class="<%=classValue%>"  width='10%'><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("TRADE_NAME"))%> </label> <input type="hidden" name='trade_id_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' id='trade_id_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' value="<%=bean.checkForNull((String)hmBatchDetails.get("TRADE_ID"))%>"><input type="hidden" name='trade_name_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' id='trade_name_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>'  value="<%=bean.checkForNull((String)hmBatchDetails.get("TRADE_NAME"))%>"></td>	
			
			<td class="<%=classValue%>"  width='10%'><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("BIN_LOCATION"))%></label><input type="hidden"  name='batch_id_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' id='batch_id_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>'   value="<%=bean.checkForNull((String)hmBatchDetails.get("BATCH_ID"))%>"></td>


			<td class="<%=classValue%>"  width='15%'><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("BATCH_ID"))%></label>    <input type="hidden" name='expiry_date_or_receipt_date_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' id='expiry_date_or_receipt_date_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>'  value="<%=bean.checkForNull((String)hmBatchDetails.get("EXPIRY_DATE_OR_RECEIPT_DATE"))%>"></td>
    		<td class="<%=classValue%>"  width='10%'><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("EXPIRY_DATE_OR_RECEIPT_DATE"))%></label><input type="hidden" name='bin_location_code_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' id='bin_location_code_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>'    value="<%=bean.checkForNull((String)hmBatchDetails.get("BIN_LOCATION_CODE"))%>"><input type="hidden" name='bin_location_desc_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' id='bin_location_desc_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' 		   value="<%=bean.checkForNull((String)hmBatchDetails.get("BIN_LOCATION"))%>"> </td>
		    <td class="<%=classValue%>"  width='10%' style='text-align:right;'><label  style="font-family:verdana;font-size:10;text-align:right;"><%=bean.checkForNull((String)hmBatchDetails.get("SAL_ITEM_QTY"))%></label> &nbsp;	</td>
			<input type="hidden" id='sal_item_qty_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>'  name='sal_item_qty_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' 		   value="<%=bean.checkForNull((String)hmBatchDetails.get("SAL_ITEM_QTY"))%>">
			<input type="hidden" id='allow_deci_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>'  name='allow_deci_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' 		   value="<%=bean.checkForNull((String)hmBatchDetails.get("ALLOW_DECIMALS_YN"),"N")%>">
			<td	class="<%=classValue%>"   width='10%'><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("UOM_DESC"))%></label><input type="hidden" name='uom_desc_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' id='uom_desc_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' value="<%=bean.checkForNull((String)hmBatchDetails.get("UOM_DESC"))%>"><input type="hidden" name='uom_code_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' id='uom_code_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' value="<%=bean.checkForNull((String)hmBatchDetails.get("UOM_CODE"))%>"> </td>
		    <td class="<%=classValue%>" ><input style='text-align:right;' type="text" id='item_qty_<%=new_doc_no%>-<%=new_doc_type_code%>_<%=j%>' name='item_qty_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>'  size="10" maxlength="10" onKeyPress="return isValidNumberforMultiLine(this,event,8,<%=no_deci%>,allow_deci_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>);" disabled >  </td>
		     <!-- Modified for  IN074078-->
</TR>
<%}else { %>
		<TR>	
            <td class="label"  width='6%' >&nbsp;</td>
			<input type="hidden" name='material_group_access_yn_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' id='material_group_access_yn_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=j%>' value="N">   <!-- 34089 -->
			<td class="<%=classValue%>"   width='30%'><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("ITEM_NAME"))%></label>&nbsp;	</td>
			<td class="<%=classValue%>"   width='10%'><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("TRADE_NAME"))%>	</td>	
			<td class="<%=classValue%>"   width='10%'><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("BIN_LOCATION"))%></label>&nbsp;	</td>
			<td class="<%=classValue%>"   width='15%'><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("BATCH_ID"))%></label>&nbsp;</td>
	        <td class="<%=classValue%>"   width='10%'><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("EXPIRY_DATE_OR_RECEIPT_DATE"))%></label> </td>
		    <td class="<%=classValue%>"   width='10%'  style='text-align:right;'><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("SAL_ITEM_QTY"))%></label>&nbsp; </td>
			<td class="<%=classValue%>"   width='10%'><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmBatchDetails.get("UOM_DESC"))%></label>&nbsp;   </td>
		    <td class="<%=classValue%>"   >&nbsp;</td>
       </TR>
		   
  <% }
}%>
        <tr> 
	      <td class="<%=classValue%>" colspan="8" id="material_group_access_message_<%=i%>">&nbsp;</td>	    <!-- 34089 -->  
		  <td> 
	        <input align="right" type=button name='apply_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=i%>' id='apply_<%=new_doc_no%>_<%=new_doc_type_code%>_<%=i%>'   value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>'    align='right' class=button onclick="onapply('<%=batchcount%>','<%=new_doc_type_code%>');"  disabled >	<!-- Modified for  IN074078-->
		  </td>
		</tr>

	</table>	
        
<% } %>	


<input type='hidden'	name="sal_doc_chkd" id="sal_doc_chkd"		value="<%=(String)bean.getSal_Doc_Chkd()%>">    <!-- Added by sharanraj for GHL-CRF-0483 -->

	</form>

	</body>
</html>

