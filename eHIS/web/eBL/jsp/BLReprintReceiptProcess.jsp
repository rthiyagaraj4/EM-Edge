<!DOCTYPE html>
<%@ page  import="eBL.*,eBL.Common.*,java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" 			contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 

<%!
private String checkForNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
}

public String billingFormatConverter(Connection con, String amount) {
	PreparedStatement pstmt_dec = null;
	ResultSet rs_dec = null;
	int noofdecimal = 2;

	try {		
		pstmt_dec = con.prepareStatement(" select nvl(no_of_decimal,2) from  sm_acc_entity_param where acc_entity_id='ZZ'");
		rs_dec = pstmt_dec.executeQuery();
		if (rs_dec.next() && rs_dec != null)
			noofdecimal = rs_dec.getInt(1);
		if (rs_dec != null)
			rs_dec.close();
		if (pstmt_dec != null)
			pstmt_dec.close();			
		if (amount == null || "".equals(amount)) {
			amount = "0.00";
		} else {
			CurrencyFormat cf = new CurrencyFormat();
			amount = cf.formatCurrency(amount, noofdecimal);
		}
	} catch (Exception e) {
		System.out.println("Exception Getting Number of Decimals. " + e.toString());
	}
	return amount;
} 
%>
<%
System.out.println("in jsp");
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null ;
	Statement stmt1				= null;
	ResultSet rs1 = null;	
	ResultSet rs2 =null;
	ResultSet rs3 =null;
	String strRecptNatureCodedesc="";
	String strRecptTypeCodedesc="";
	String locale="";	
	String classval="";
	int total_records=0;	
	String p_facility_id="";
	String ReceiptNaturedesc="";
	String p_doc_type_code="";
	String From_doc_type_no="";
	String To_doc_type_no="";
	String p_from_receipt_doc_type_code="";
	String p_to_receipt_doc_type_code="";
	String p_from_receipt_number="";	
	String p_to_receipt_number=""; 
	String p_from_receipt_date="";
	String p_to_receipt_date="";
	String p_episode_type="";	
	String p_visit_id ="";
	String strRowId="";
	String strDocTypCode="";
	String strDocNum="";	
	String strDocDate="";
	String strPatientId="";
	String strDocAmt="";
	String strRecptTypeCode="";
	String strRecptNatureCode="";
	String strEpisodeType="";
	String strEpisodeId="";
	String strVisitId="";
	String patientId="";
	String episodeId = "";
	String visit_id = "";
	String custCode ="";
	String custGrpCode = "";
	String recpt_type_code = "";
	String receipt_nature_code = "";
	String downtimereceipt_number_code  = "";
	String to_Receipt_date ="";
	String from_Receipt_date = "";
	String downtimereceipt_number = "";
	String HcareApplnnumber_code  = "";
	String depositeType="";
	String bill_doc_type = "";
	String void_number = "";
	 String recept_Refund_ind = "";
	String bill_doc_no = "";
	String nextYn = "N";
	String prevYn = "N";
	String traversal = "N";
	String fromRcrd = "";
	String toRcrd = "";
	int constCount = 50;
	int startIndex = 0;
	int startRcrd = 0;
	int endRcrd = 0;
	int totalRecord=0;
	System.out.println("in jsp 1");
	fromRcrd = checkForNull(request.getParameter("fromRcrd"));
	toRcrd = checkForNull(request.getParameter("toRcrd"));
	if(fromRcrd == null || "".equals(fromRcrd)){
		startRcrd = 1;
	}
	else{
		startRcrd = Integer.parseInt(fromRcrd);
	}
		
	if(toRcrd == null || "".equals(toRcrd)){
		endRcrd = constCount;
	}
	else{
		endRcrd = Integer.parseInt(toRcrd);
	}
	startIndex = startRcrd;
	boolean searched = (request.getParameter("searched") == null) ?false:true;	

	try
	{	
		HttpSession httpSession = request.getSession(false);				
		con	=	ConnectionManager.getConnection(request);		
		locale	= (String)session.getAttribute("LOCALE");
		p_facility_id = (String)httpSession.getValue("facility_id");
		p_from_receipt_doc_type_code=request.getParameter("from_receipt_doc_type_code");
		if(p_from_receipt_doc_type_code==null || p_from_receipt_doc_type_code.equals("")) p_from_receipt_doc_type_code="";		
		p_to_receipt_doc_type_code=request.getParameter("to_receipt_doc_type_code");
		if(p_to_receipt_doc_type_code==null || p_to_receipt_doc_type_code.equals("")) p_to_receipt_doc_type_code="";
		p_from_receipt_number=request.getParameter("from_receipt_number");
		if(p_from_receipt_number==null || p_from_receipt_number.equals("")) p_from_receipt_number="";
		p_to_receipt_number=request.getParameter("to_receipt_number");
		if(p_to_receipt_number==null || p_to_receipt_number.equals("")) p_to_receipt_number="";
		p_from_receipt_date=request.getParameter("from_receipt_date");
		if(p_from_receipt_date==null || p_from_receipt_date.equals("")) p_from_receipt_date="";
		p_to_receipt_date=request.getParameter("to_receipt_date");
		if(p_to_receipt_date==null || p_to_receipt_date.equals("")) p_to_receipt_date="";
		p_episode_type=request.getParameter("episode_type");
		if(p_episode_type==null) p_episode_type="";		
  		patientId = checkForNull(request.getParameter("patientId"));
		episodeId = checkForNull(request.getParameter("episodeId"));	    
		visit_id = checkForNull(request.getParameter("visit_id"));
		custCode = checkForNull(request.getParameter("custCode"));
		custGrpCode = checkForNull(request.getParameter("custGrpCode"));
		recpt_type_code = checkForNull(request.getParameter("recpt_type_code"));
		receipt_nature_code = checkForNull(request.getParameter("receipt_nature_code"));
		downtimereceipt_number_code = checkForNull(request.getParameter("downtimereceipt_number_code"));
		downtimereceipt_number = checkForNull(request.getParameter("downtimereceipt_number"));
		HcareApplnnumber_code = checkForNull(request.getParameter("HcareApplnnumber_code"));
		depositeType = checkForNull(request.getParameter("depositeType"));
		bill_doc_no = checkForNull(request.getParameter("bill_doc_no"));
		bill_doc_type = checkForNull(request.getParameter("bill_doc_type"));
		Statement stmt = con.createStatement();
		if(rs1!=null)   rs1.close();
		if(stmt!=null) stmt.close();
	}		
	catch(Exception eX)
	{	
		System.out.println("Error= "+eX);			
	}
%>
<HTML>
	<HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>	
		<script language='javascript' src='../js/BLReprintReportReceipt.js'></script>
		<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
		<script language='javascript' src='../js/json2.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



		<script>
		
		$(document).ready(function(event){
			$("input[type='text']").keydown(function(e){
			if (e.which === 8 && !$(e.target).is("input[type='text']:not([readonly])")) {
					e.preventDefault();
			    }
			});
			if($('#traverse').val() == 'Y'){
				$('#trProgress').show();
			}else{
				$('#trProgress').hide();
			}
			if($('#hdnNextSpan').val() == 'Y'){
				$('#nextSpan').show();
			}else{
				$('#nextSpan').hide();
			}			
			if($('#prevSpan').val() == 'Y'){
				$('#previousSpan').show();
			}else{
				$('#previousSpan').hide();
			}
			
			$('[id^=void_number]').each(function(){
				$(this).hide();
			});
			$('[id^=recept_Refund_ind]').each(function(){
				$(this).hide();
			});
			
							
			$('#nextSpan').click(function(){
				var startFrom = parseInt($('#fromRcrd').val())+parseInt($('#constCount').val());
				var endWith = parseInt($('#toRcrd').val())+parseInt($('#constCount').val());
				document.location.href = "BLReprintReceiptProcess.jsp?from_receipt_doc_type_code="+$('#hdnreceiptDocFrom').val()+
										"&to_receipt_doc_type_code="+$('#hdnreceiptDocTo').val()+
										"&from_receipt_number="+$('#hdnreceiptNoFrom').val()+
										"&to_receipt_number="+$('#hdnreceiptNoTo').val()+
										"&from_receipt_date="+$('#hdnreceiptDateFrom').val()+
										"&to_receipt_date="+$('#hdnreceiptDateTo').val()+
										"&episode_type="+$('#hdnEpisodeType').val()+
										"&visit_id="+$('#hdnvisit_id').val()+
										"&patientId="+$('#hdnPatientId').val()+
										"&episodeId="+$('#hdnEpisodeId').val()+										
										"&recpt_type_code="+$('#hdnrecpt_type_code').val()+
										"&receipt_nature_code="+$('#hdnreceipt_nature_code').val()+
										"&custCode="+$('#hdnCustCode').val()+
										"&custGrpCode="+$('#hdnCustGrpCode').val()+
										"&downtimereceipt_number_code="+$('#hdndowntimereceipt_number_code').val()+
										"&downtimereceipt_number="+$('#hdndowntimereceipt_number').val()+
										"&HcareApplnnumber_code="+$('#hdnHcareApplnnumber_code').val()+
										"&depositeType="+$('#hdndepositeType').val()+
										"&bill_doc_type="+$('#hdnbill_doc_type').val()+
										"&bill_doc_no="+$('#hdnbill_doc_no').val()+
										"&fromRcrd="+startFrom+
										"&toRcrd="+endWith;
										});
			$('#previousSpan').click(function(){
				var startFrom = parseInt($('#fromRcrd').val())-parseInt($('#constCount').val());
				var endWith = parseInt($('#toRcrd').val())-parseInt($('#constCount').val());
				document.location.href = "BLReprintReceiptProcess.jsp?from_receipt_doc_type_code="+$('#hdnreceiptDocFrom').val()+
										"&to_receipt_doc_type_code="+$('#hdnreceiptDocTo').val()+
										"&from_receipt_number="+$('#hdnreceiptNoFrom').val()+
										"&to_receipt_number="+$('#hdnreceiptNoTo').val()+									
										"&from_receipt_date="+$('#hdnreceiptDateFrom').val()+
										"&to_receipt_date="+$('#hdnreceiptDateTo').val()+
										"&episode_type="+$('#hdnEpisodeType').val()+
										"&visit_id="+$('#hdnvisit_id').val()+
										"&patientId="+$('#hdnPatientId').val()+
										"&episodeId="+$('#hdnEpisodeId').val()+ 
										"&custCode="+$('#hdnCustCode').val()+
										"&custGrpCode="+$('#hdnCustGrpCode').val()+
										"&recpt_type_code="+$('#hdnrecpt_type_code').val()+
										"&receipt_nature_code="+$('#hdnreceipt_nature_code').val()+
										"&downtimereceipt_number_code="+$('#hdndowntimereceipt_number_code').val()+
										"&downtimereceipt_number="+$('#hdndowntimereceipt_number').val()+
										"&HcareApplnnumber_code="+$('#hdnHcareApplnnumber_code').val()+
										"&depositeType="+$('#hdndepositeType').val()+
										"&bill_doc_type="+$('#hdnbill_doc_type').val()+
										"&bill_doc_no="+$('#hdnbill_doc_no').val()+
										"&fromRcrd="+startFrom+
										"&toRcrd="+endWith;
										});
			$('#selectAll').click(function(){					
				var indx = $('#tbl tr').length;
				var trlast = $(parent.frames[2].document).find('#tblSelectedReport tr:last');
				var lastindx =  $(trlast).attr('indexval');			
				var selectedFrameDoc = parent.selectedFrame.document;
				//var indx2 = $(selectedFrameDoc).find('#indexTrack').val();
				var indx1= $('#tblSelectedReport tr').length;
				var receiptCount = $(selectedFrameDoc).find('#receiptCount').val();
				//alert("receiptCount="+receiptCount+"-lastindx="+lastindx+"-indx="+indx);
				
				if (lastindx == 'undefined' || lastindx == undefined) {lastindx= 0;  receiptCount = 0;}				
				var limitexc =  parseInt(lastindx)-parseInt(receiptCount);
				
				if((parseInt(receiptCount)+ parseInt(indx-3)) > 50 ){
					alert("Limit Exceeded, Can't proceed");
					return;
				}
				//alert(indx+"--"+limitexc+"-"+receiptCount);
				if((50-limitexc)<=50){
					for (all = 1; all < (indx-2); all++) {	
						var receiptCount1 = $(selectedFrameDoc).find('#receiptCount').val();
						if (receiptCount1 <50 && (50-limitexc)<=50 ) {	
							limitexc++;
							moveData(all,true);	
					     }else { alert("Already 50 rows selected, Can't proceed "); return;}
					}			
				}else {
					alert("Already 50 rows selected, Can't proceed");
					
					dataArray.pop(uniqueReceiptId);
					
					return;
				}
			});
		});
		</script>
<style>
div.tableContainer {
	width: 100%;		/* table width will be 99% of this*/
	height: 160px; 	/* must be greater than tbody*/
	overflow: auto;
	margin: 0 auto;
}

table {
	width: 100%;		/*100% of container produces horiz. scroll in Mozilla*/
	border: none;
	background-color: #f7f7f7;
	}
	
table>tbody	{  /* child selector syntax which IE6 and older do not support*/
	overflow: auto; 
	height: 120x;
	overflow-x: hidden;
	}
	
thead tr	{
	position:relative; 
	top: expression(offsetParent.scrollTop); /*IE5+ only*/
	}
		
		div.tableContainer {
		width: 100%;		/* table width will be 99% of this*/
		height: 140px; 	/* must be greater than tbody*/
		overflow: scroll;
		margin: 0 auto;
	}	
		TD.YELLOW 
		{			
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			border-style: dashed;
			border-left-color: #D5E2E5;
			border-right-color: #D5E2E5;
			border-top-color: #D5E2E5;
			border-bottom-color: #D5E2E5; 
		}
		
		.LocalYellow
		{
			COLOR:#444444;
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			border: 1x;
			border-style: dashed;
			border-left-color: #D5E2E5;
			border-right-color: #D5E2E5;
			border-top-color: #D5E2E5;
			border-bottom-color: #D5E2E5; 
			/*PADDING-LEFT:7px;
  			PADDING-RIGHT:7px*/
		}
SPAN.LABEL
{
  COLOR:#444444;
  /*background-color:#FFFFFF;*/
  background-color:#FFFFFF;
  FONT-SIZE: 8pt;
  TEXT-ALIGN: LEFT;
  /*TEXT-ALIGN: RIGHT;*/
  PADDING-LEFT:7px;
  PADDING-RIGHT:7px
}

SPAN.LABEL1
{
  COLOR:#444444;
  /*background-color:#FFFFFF;*/
  background-color:#FFFFFF;
  FONT-SIZE: 8pt;
  /*TEXT-ALIGN: LEFT;*/
  TEXT-ALIGN: RIGHT;
  PADDING-LEFT:7px;
  PADDING-RIGHT:7px
}

SPAN.SpanYellow
		{
			COLOR:#444444;
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			PADDING-LEFT:7px;
  			PADDING-RIGHT:7px
		}
	</style>
	</HEAD> 
	<script>
		function selected(i)
		{				
			var selected_row=eval("document.forms[0].selected_row"+i);		
			if(selected_row.checked==false)
			{	
			selected_row.checked=false;
			document.resultForm.checked_row.value="";				
			}
			else
			{					
				var total_records=document.forms[0].total_records.value;					
				for(var j=0;j<total_records;j++)
				{ 
					var temp=eval("document.resultForm.selected_row"+j);					
					temp.checked=false;
		        }
			selected_row.checked=true;				
			document.forms[0].checked_row.value=i;
			}
			if(selected_row.checked)
			{
			  selected_row.value="1";	
			}
			else
			{
				selected_row.value="1";	
			}
		}	
		
		function no_record_check()
		{			
			//alert("no records check");
		//	parent.dummy_frame.location.href='../../eCommon/html/blank.html';
 			var total_records=document.forms[0].total_records.value;
			if(total_records==0)
			{
				setTimeout(function(){ alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common")); }, 100);
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=&err_value=";
				$("#tableContainer").html("");
				
			}
			parent.search_hdr.document.forms[0].total_records.value=total_records;
		
		}
		function assign_value()
		{
			parent.search_hdr.document.forms[0].group_by.value = document.forms[0].group_by.value;
		}

	</script>
	<body onLoad="no_record_check();" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 	onSelect="codeArrestThruSelect();">
	<form name='resultForm' id='resultForm' > 
	<% 
		try
		{
								
			String query_refresh=
					"SELECT rownum rnum,doc_type_code, doc_number, TO_CHAR(doc_date,'DD-MM-YYYY') doc_date, doc_amt, patient_id, recpt_nature_code, recpt_type_code, episode_type, episode_id,visit_id, print_flag,BL_VOID_NUMBER_YN(doc_number,doc_type_code,operating_facility_id) void_number,RECPT_REFUND_IND "+
				  	"FROM bl_receipt_refund_hdr "+
				 	"WHERE "+
				  	"doc_type_code BETWEEN NVL ('"+p_from_receipt_number+"', '!!!!!!' ) AND NVL ('"+p_to_receipt_number+"', '~~~~~~') "+
				  	"AND DOC_NUMBER BETWEEN NVL ('"+p_from_receipt_doc_type_code+"', 0) AND NVL ('"+p_to_receipt_doc_type_code+"', 99999999)"+ 
				   	"AND TRUNC (doc_date) BETWEEN NVL ( TO_DATE ('"+p_from_receipt_date+"', 'dd/mm/yyyy'), TO_DATE ('01/01/1900', 'dd/mm/yyyy')) "+
				   	"AND NVL ( TO_DATE ('"+p_to_receipt_date+"', 'dd/mm/yyyy'), TO_DATE ('31/12/4000', 'dd/mm/yyyy'))"+ 
				   "AND NVL (cancelled_ind, 'N') <> 'Y'  ";
			String queryCount = 
					"SELECT count(*) total "+
							"FROM bl_receipt_refund_hdr "+
							 "WHERE "+
							  "doc_type_code BETWEEN NVL ('"+p_from_receipt_number+"', '!!!!!!' ) AND NVL ('"+p_to_receipt_number+"', '~~~~~~') "+
							  " AND DOC_NUMBER BETWEEN NVL ('"+p_from_receipt_doc_type_code+"', 0) AND NVL ('"+p_to_receipt_doc_type_code+"', 99999999)"+ 
							   "AND TRUNC (doc_date) BETWEEN NVL ( TO_DATE ('"+p_from_receipt_date+"', 'dd/mm/yyyy'), TO_DATE ('01/01/1900', 'dd/mm/yyyy')) "+
							   "AND NVL ( TO_DATE ('"+p_to_receipt_date+"', 'dd/mm/yyyy'), TO_DATE ('31/12/4000', 'dd/mm/yyyy'))"+ 
							   "AND NVL (cancelled_ind, 'N') <> 'Y'  ";
					
			String whereClause = "";
			
					if(!"".equals(patientId)){
						whereClause = whereClause + " AND PATIENT_ID = '"+patientId+"' ";
					}					
					if(!"".equals(episodeId)){
						whereClause = whereClause + " AND EPISODE_ID = '"+episodeId+"' ";
					}
					if(!"".equals(p_episode_type)){
						whereClause = whereClause + " AND episode_type = '"+p_episode_type+"' ";
					}										
					if(!"".equals(custCode) ){
						whereClause = whereClause +  "AND CUSTOMER_CODE = (DECODE('"+custCode+"','**',CUSTOMER_CODE,'"+custCode+"')) ";													
					}			
					if(!"".equals(custGrpCode) ) {
						whereClause = whereClause + " AND CUSTOMER_GROUP_CODE = (DECODE('"+custGrpCode+"','**',CUSTOMER_GROUP_CODE,'"+custGrpCode+"'))";
					}										
					if(!"".equals(recpt_type_code))  {
						whereClause = whereClause + " AND RECPT_TYPE_CODE  = '"+recpt_type_code+"' ";
					}
					if(!"".equals(receipt_nature_code)) {
						
						whereClause = whereClause + " AND  RECPT_NATURE_CODE  = '"+receipt_nature_code+"' ";
					}
					if(!"".equals(downtimereceipt_number)){
						whereClause = whereClause + "AND DOWNTIME_DOC_NUMBER = '"+downtimereceipt_number+"'";
					}
					if(!"".equals(downtimereceipt_number_code)) {
						whereClause = whereClause + " AND DOWNTIME_DOC_TYPE_CODE = '"+downtimereceipt_number_code+"'";
					}				
					if(!"".equals(visit_id)) {
						whereClause = whereClause + " AND VISIT_ID = '"+visit_id+"' ";
					}
					if(!"**".equals(depositeType)) {
						whereClause = whereClause +" AND IP_ADM_TRF_DEP_IND = '"+depositeType+"' ";
					}
				if(!"".equals(bill_doc_no)) {
					whereClause = whereClause +" AND (doc_number  IN (select DOC_NUMBER  from bl_bills_for_cons_receipt where bill_doc_num ='"+bill_doc_no+"'  and bill_doc_type_code ='"+bill_doc_type+"')  OR bill_doc_number ='"+bill_doc_no+"')";
				}
				if(!"".equals(bill_doc_type)) {
					whereClause = whereClause + " AND  (doc_type_code in ( select doc_type_code  from bl_bills_for_cons_receipt  where bill_doc_num ='"+bill_doc_no+"' and bill_doc_type_code ='"+bill_doc_type+"') OR bill_doc_type_code ='"+bill_doc_type+"')";
				}
					
			 String orderBy=" order by doc_type_code,doc_number ";
			 query_refresh  = "Select * from ("+query_refresh + whereClause +") where rnum between "+startRcrd +" and "+endRcrd + orderBy ; 
			
			 queryCount  = queryCount + whereClause;
			 System.out.println("query_refresh :" +query_refresh);
			 System.out.println("queryCount :" +queryCount);
			pstmt = con.prepareStatement(queryCount);
			
			rs1 = pstmt.executeQuery();

			if(rs1 != null && rs1.next()){ 
				totalRecord = rs1.getInt("total");
			}
			if(startRcrd>1){
				prevYn = "Y";
				traversal = "Y";
			}
			System.out.println("total = "+totalRecord);
			if((startRcrd+constCount) < totalRecord){
				nextYn = "Y";
				traversal = "Y";
			}	
		
			pstmt = null;
			rs1 = null;
			
			System.out.println("Inside Reprint Process Sql Query : "+query_refresh);
			
			pstmt = con.prepareStatement(query_refresh);
			rs1= pstmt.executeQuery();
			%>
		<div id="tableContainer">
			<table border='' cellpadding='3' cellspacing='0'  id='tbl' width='100%'>	
			<thead>
			<tr style="background-color: white; border: none;" id='trProgress'>
			
					<td colspan='12'  align='right' bordor=0 >
						<span class="LABEL" style="font-weight: normal; color: blue; cursor: pointer; cursor:pointer ">
							<span id='previousSpan'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></span>
						</span>
						<span class="LABEL" style="font-weight: normal; color: blue; cursor: pointer; cursor:pointer ">
							<span id='nextSpan' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></span>
						</span>
					</td>					
			</tr>
			<tr style="position: sticky;z-index: 1;top: 0;">
<!-- 					ENM-2558 - MMS-QH-CRF-0163 Karthik Added isForALL attribute to skip alert in Select All Case 	-->
				<td class='COLUMNHEADER' width='5%' ><div id='selectAll'><span style="color: blue; font-size: 12px; cursor:pointer " >(+)</span><fmt:message key="Common.selectall.label" bundle="${common_labels}"/></div></td>				
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='11%'><fmt:message key="Common.DocumentNumber.label" bundle="${common_labels}"/></td>					
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.DocumentDate.label" bundle="${common_labels}"/></td>	
				<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.ReceiptNatureCode.label" bundle="${bl_labels}"/></td>					
				<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.ReceiptTypeCode.label" bundle="${bl_labels}"/></td>	
				<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.DocAmt.label" bundle="${bl_labels}"/></td>		
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>	
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.episodeId.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.VisitID.label" bundle="${common_labels}"/></td>
							
				</tr>
				<tr>
				</tr>
	            </thead>
			    <tbody>
		
<%				int i=1;

				if(rs1 != null){
					
					while(rs1.next()){
						classval = "label";
						strDocTypCode=  checkForNull(rs1.getString("doc_type_code"));
						strDocNum=checkForNull(rs1.getString("doc_number"));
						strDocDate=checkForNull(rs1.getString("doc_date"));
						strDocAmt=checkForNull(rs1.getString("doc_amt"));
						strPatientId=checkForNull(rs1.getString("patient_id"));
						strRecptNatureCode=checkForNull(rs1.getString("recpt_nature_code"));
						
						 String query = "select  distinct long_desc from bl_receipt_nature_lang_vw where recpt_nature_code = '"+strRecptNatureCode+"' AND upper(LANGUAGE_ID) = upper('"+locale+"')";
						
						 pstmt = con.prepareStatement(query);
						rs2  = pstmt.executeQuery();
						if(rs2 != null){							
							while(rs2.next()){
						 strRecptNatureCodedesc = rs2.getString(1);
							}
						}
						strRecptTypeCode=checkForNull(rs1.getString("recpt_type_code"));

						 String query1 = "select  distinct long_desc from bl_receipt_type_lang_vw where RECEIPT_TYPE_CODE = '"+strRecptTypeCode+"' AND  upper(LANGUAGE_ID) = upper('"+locale+"')";
						 pstmt = con.prepareStatement(query1);
						 rs3= pstmt.executeQuery();
						 if(rs3 != null){							
								while(rs3.next()){
							 strRecptTypeCodedesc = rs3.getString(1);
								}
							}
						strEpisodeType=checkForNull(rs1.getString("episode_type"));
						if(strEpisodeType.equals("R")) {
							strEpisodeId = "";
						}else {							
							strEpisodeId=checkForNull(rs1.getString("episode_id"));
						}
						if(strEpisodeType.equals("I") || strEpisodeType.equals("D") || strEpisodeType.equals("R")) {
							strVisitId = "";
						}else{
						strVisitId=checkForNull(rs1.getString("visit_id"));
						}
						void_number=checkForNull(rs1.getString("void_number"));
						recept_Refund_ind=checkForNull(rs1.getString("RECPT_REFUND_IND"));
					
%>
	
	<tr id=row<%=i%> onclick='highlightRow(<%=i%>,"<%=classval%>")'>
		
	<td id='row<%=i %>_col0' class=<%=classval%> width="5%" nowrap style='cursor:pointer' >
	<div  id='doc_typ_chk<%=i%>' name='doc_typ_chk<%=i%>' index='<%=i%>' onclick="moveData(<%=i%>,false)"> <div style="color: blue; font-size: 12px;">+</div> </div>
	</td>
	<td id='row<%=i %>_col1' class=<%=classval%> width="7%" nowrap>  
	<span class="LABEL" id='doc_typ_code<%=i%>' name='doc_typ_code<%=i%>'><%=strDocTypCode%></span>
	</td>
	<td id='row<%=i %>_col2' class=<%=classval%> width="11%" class="fields" style='cursor:pointer' onclick="tooltip(this,<%=i %>);"	onmouseover="hideToolTip();">
	<span class="LABEL" name='doc_num<%=i%>' id='doc_num<%=i%>'><%=strDocNum%></span>&nbsp;
	<img align='right' src='../../eCommon/images/inactiveArrow.gif' id='imgArrow<%=i%>'>
	</td>
	<td id='row<%=i %>_col3' class=<%=classval%> width="10%" nowrap class="fields">
	<span class="LABEL" name='doc_date<%=i%>' id='doc_date<%=i%>'><%=strDocDate%></span> 
	</td>
	<td id='row<%=i %>_col4' width="10%" nowrap class=<%=classval%> >
	<span class='LABEL' name='recpt_nature_code<%=i%>' id='recpt_nature_code<%=i%>'><%=strRecptNatureCodedesc%></span>
	</td>	
	<td id='row<%=i %>_col5' width="10%" nowrap class=<%=classval%> >
	<span class='LABEL' name='recpt_type_code<%=i%>' id='recpt_type_code<%=i%>'><%=strRecptTypeCodedesc%></span>
	</td>	
	<td id='row<%=i %>_col6' width="7%" nowrap class=<%=classval %> >
	<span  class='LABEL1' name='doc_amt<%=i%>' id='doc_amt<%=i%>'><%=billingFormatConverter(con,strDocAmt)%></span>
	</td>	
	<td id='row<%=i %>_col7' width="7%" nowrap class=<%=classval%>>
	<span class="LABEL" name='patient_id<%=i%>' id='patient_id<%=i%>'><%=strPatientId%></span>
	<td id='row<%=i %>_col8' width="7%" nowrap class=<%=classval%>>
	<span class='LABEL' readonly name='episode_type<%=i%>' id='episode_type<%=i%>' ><%=strEpisodeType%></span> 
	</td>
	<td id='row<%=i %>_col9' width="10%" nowrap class=<%=classval%> >
	<span class='LABEL' name='episode_id<%=i%>' id='episode_id<%=i%>'><%=strEpisodeId%></span>
	</td>
	<td id='row<%=i %>_col9' width="10%"  nowrap class=<%=classval%> >
	<span class='LABEL' name='visit_id<%=i%>' id='visit_id<%=i%>'><%=strVisitId%></span>
	<span name='void_number<%=i%>'  type ='hidden' id='void_number<%=i%>'><%=void_number%></span>
	<span name='recept_Refund_ind<%=i%>'  type ='hidden' id='recept_Refund_ind<%=i%>'><%=recept_Refund_ind%></span>
		
	</td>
	</tr> 
	
 <%
					i++;
					total_records++; 
			}//while
			}//If
%>
	</tbody>
	</table>
	</div>
	 
<%				
		}
		catch(Exception eX)
		{		
			System.out.println("Error1= "+eX);			
		}
		finally
		{
			if (rs1 != null)   rs1.close();
			if (pstmt != null) pstmt.close();
			if(con!=null) 
			{
				ConnectionManager.returnConnection(con, request);
			}
		}
%>
		<input type='hidden' name='total_records' id='total_records' value='<%=total_records%>'>	
		<input type='hidden' name='checked_row' id='checked_row' value='' >		
		<input type='hidden' name='rowClicked' id='rowClicked' id='rowClicked' value = ''>		
		<input type='hidden' name='docType' id='docType' value = ''>
		<input type='hidden' name='documentNumber' id='documentNumber' value = ''>
		<input type='hidden' name='documentDate' id='documentDate' value = ''>
		<input type='hidden' name='amt_doc' id='amt_doc' value = ''>
		<input type='hidden' name='patientId' id='patientId' value = ''>
		<input type='hidden' name='Rcptnatcode' id='Rcptnatcode' value = ''>
		<input type='hidden' name='Rcpttypecode' id='Rcpttypecode' value = ''>
		<input type='hidden' name='episodeType' id='episodeType' value = ''>
		<input type='hidden' name='episodeId' id='episodeId' value = ''>
		<input type='hidden' name='visit_id' id='visit_id' value = ''>
		
			
		<%			
				if(total_records>0){
					System.out.println("total_records/classval"+total_records+"/"+classval);
					out.println("<script>");
				out.println("highlightRow(1,'"+classval+"')");
				out.println("</script>");
				}
			
		 %>
	<!-- 	<script>parent.dummy_frame.location.href='../../eCommon/html/blank.html';</script>	  -->
	<input type='hidden' name='fromRcrd' id='fromRcrd' id='fromRcrd' value='<%=startRcrd %>'>
	<input type='hidden' name='toRcrd' id='toRcrd' id='toRcrd' value='<%=endRcrd %>'>
	<input type='hidden' name='constCount' id='constCount' id='constCount' value='<%=constCount %>'>
	<input type='hidden' name='prevClicked' id='prevClicked' id='prevClicked' value=''>
	<input type='hidden' name='hdnNextSpan' id='hdnNextSpan' id='hdnNextSpan' value='<%=nextYn %>'>
	<input type='hidden' name='prevSpan' id='prevSpan' id='prevSpan' value='<%=prevYn %>'>
	<input type='hidden' name='traverse' id='traverse' id='traverse' value='<%=traversal%>'>
		<!-- Hidden Vars for Next / Prev Refresh -->
	<input type='hidden' name='hdnEpisodeType' id='hdnEpisodeType' id='hdnEpisodeType' value='<%=p_episode_type %>'>
	<input type='hidden' name='hdnPatientId' id='hdnPatientId' id='hdnPatientId' value='<%=patientId %>'>
	<input type='hidden' name='hdnEpisodeId' id='hdnEpisodeId' id='hdnEpisodeId' value='<%=episodeId %>'>
	<input type='hidden' name='hdnreceiptDocFrom' id='hdnreceiptDocFrom' id='hdnreceiptDocFrom' value='<%=p_from_receipt_doc_type_code%>'>
	<input type='hidden' name='hdnreceiptDocTo' id='hdnreceiptDocTo' id='hdnreceiptDocTo' value='<%=p_to_receipt_doc_type_code %>'>
	<input type='hidden' name='hdnreceiptNoFrom' id='hdnreceiptNoFrom' id='hdnreceiptNoFrom' value='<%=p_from_receipt_number%>'>
	<input type='hidden' name='hdnreceiptNoTo' id='hdnreceiptNoTo' id='hdnreceiptNoTo' value='<%=p_to_receipt_number %>'>
	<input type='hidden' name='hdnreceiptDateFrom' id='hdnreceiptDateFrom' id='hdnreceiptDateFrom' value='<%=p_from_receipt_date %>'>
	<input type='hidden' name='hdnreceiptDateTo' id='hdnreceiptDateTo' id='hdnreceiptDateTo' value='<%=p_to_receipt_date%>'>
	<input type='hidden' name='hdnvisit_id' id='hdnvisit_id' id='hdnvisit_id' value='<%=p_visit_id %>'>
	<input type='hidden' name='login_user' id='login_user' id='login_user' value='<%=(String)session.getAttribute("login_user")%>'>
	<input type="hidden" name="locale" id="locale" id="locale" value="<%=locale%>">
	<input type="hidden" name='hdnCustCode' id='hdnCustCode' id='hdnCustCode' value="<%=custCode%>">
	<input type="hidden" name='hdnCustGrpCode' id='hdnCustGrpCode' id='hdnCustGrpCode' value="<%=custGrpCode%>">
	<input type="hidden" name='hdnrecpt_type_code' id='hdnrecpt_type_code' id='hdnrecpt_type_code' value="<%=recpt_type_code%>">
	<input type="hidden" name='hdnreceipt_nature_code' id='hdnreceipt_nature_code' id='hdnreceipt_nature_code' value="<%=receipt_nature_code%>">
	<input type="hidden" name='hdndowntimereceipt_number_code' id='hdndowntimereceipt_number_code' id='hdndowntimereceipt_number_code' value="<%=downtimereceipt_number_code%>">
	<input type="hidden" name='hdndowntimereceipt_number' id='hdndowntimereceipt_number' id='hdndowntimereceipt_number' value="<%=downtimereceipt_number_code%>">
	<input type="hidden" name='hdnHcareApplnnumber_code' id='hdnHcareApplnnumber_code' id='hdnHcareApplnnumber_code' value="<%=HcareApplnnumber_code%>">
	<input type="hidden" name='hdndepositeType' id='hdndepositeType' id='hdndepositeType' value="<%=depositeType%>">
	<input type="hidden" name='hdnbill_doc_no' id='hdnbill_doc_no' id='hdnbill_doc_no' value="<%=bill_doc_no%>">
	<input type="hidden" name='hdnbill_doc_type' id='hdnbill_doc_type' id='hdnbill_doc_type' value="<%=bill_doc_type%>">
	
	 <tr>
	 </tr>
	</form >
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'></div>
	<div name='tooltiplayer1' id='tooltiplayer1' style='position:absolute; width:12%; visibility:hidden;' bgcolor='blue'>
	<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
	<tr>
	<td width='100%' id='t'></td>
	</tr>
	</table>
    </div>
<%System.out.println("************************************set form is about to be called **********************************"+searched);%>
<%out.println(CommonBean.setForm (request ,"../../eBL/jsp/BLReprintReceiptProcess.jsp",searched));%>
<%System.out.println("************************************set form is about to be called **********************************"+searched);%>
	</body>
	</TBODY>	
	</div>
</HTML>

