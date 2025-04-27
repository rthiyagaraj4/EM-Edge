<!DOCTYPE html>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="eBL.billreceipt.model.BillReceiptExistOrderExclusion"%>
<%@ 
page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.* " contentType="text/html;charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@page import="eBL.BLReportIdMapper"%>
<%
/*
---------------------------------------------------------------------------------------------------------------
Sr No        Version           TFS/Incident        SCF/CRF            		 Developer Name
--------------------------------------------------------------------------------------------------------
1	         V221122								TH-KW-CRF-0174  		Mohana Priya K
2				V221230							NMC-JD-CRF-0191.1 			Mohanapriya
*/
%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%! private String checkForNull(String input){
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
}
%>

<head>
<meta HTTP-EQUIV="content-type" CONTENT="text/html; charset=UTF-8">
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eBL/js/BillReceipt.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eXH/js/ExternalApplication.js"></script>
<%
String error=request.getParameter( "err_num" );
String calledFrom = request.getParameter("calledFrom");
String billDocType = checkForNull(request.getParameter("billDocType"));
String receiptDocType = checkForNull(request.getParameter("receiptDocType"));
String refundDocType = checkForNull(request.getParameter("refundDocType"));
String blngGrpId = checkForNull(request.getParameter("blngGrpId"));
String patientId = checkForNull(request.getParameter("patientId"));
String episodeType = checkForNull(request.getParameter("episodeType"));
String episodeId = checkForNull(request.getParameter("episodeId"));
String visitId = checkForNull(request.getParameter("visitId"));
String billDocAmt = checkForNull(request.getParameter("billDocAmt"));
String billSlmtAmt = checkForNull(request.getParameter("billSlmtAmt"));
String patDocType = checkForNull(request.getParameter("patDocType"));
String patDocNum = checkForNull(request.getParameter("patDocNum"));
String billGenerated = checkForNull((String) session.getAttribute("billRecBillGenNum"));
String billPrintYn = checkForNull(request.getParameter("billPrintYn"));
String Pgmid = checkForNull(request.getParameter("Pgmid"));
String PgmDate = checkForNull(request.getParameter("PgmDate"));
String Sessionid = checkForNull(request.getParameter("Sessionid"));
String invokeSlmt = checkForNull(request.getParameter("invokeSlmt"));
String billExemptAmt = checkForNull(request.getParameter("billExemptAmt"));
String unProcessedYn = checkForNull(request.getParameter("unProcessedYn"));
String exemptWarning = checkForNull(request.getParameter("exemptWarning"));
String exemptConsWarning = checkForNull(request.getParameter("exemptConsWarning"));
String slmtMsgId = checkForNull(request.getParameter("slmtMsgId"));
String orgBillRefNum = checkForNull(request.getParameter("orgBillRefNum"));//V221230
String facilityId																			=   (String) session.getValue( "facility_id" ) ;

String billDocDate = "";
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rst = null;
System.err.println("billGenerated"+billGenerated);
System.err.println("Pgmid"+Pgmid);
System.err.println("PgmDate"+PgmDate);
System.err.println("Sessionid"+Sessionid);
String error_value = "";
//V221230
String ZatcaYN="N";
Boolean Zatca=false;	
String mpiId="";
String zatca_error_code="";//V221230
String Zatca_msg="";//V221230
ResultSet rs=null;
CallableStatement cstmt=null;
CallableStatement cstmt1=null;
try{
	con = ConnectionManager.getConnection();
	Zatca= eCommon.Common.CommonBean.isSiteSpecific(con, "BL","ZATCA");
		if (Zatca) {
			ZatcaYN = "Y";
		}else {
			ZatcaYN = "N";
		}
		System.err.println("ZatcaYN billgen "+ZatcaYN);
	} catch(Exception ex) {
		System.err.println("Error in billgen.jsp for getting ZatcaYN Connection: "+ex);
		ex.printStackTrace();
	}
	
	if(ZatcaYN.equals("Y")){
		try{
			if(!patDocType.equals("") && !patDocNum.equals("")){
				String qry_mpi_id="select MPI_ID from bl_bill_hdr where OPERATING_FACILITY_ID=? and DOC_TYPE_CODE=? and DOC_NUM=?";
				
				pstmt = con.prepareStatement(qry_mpi_id);
				pstmt.setString(1,facilityId);
				pstmt.setString(2,patDocType);
				pstmt.setString(3,patDocNum);
				rs = pstmt.executeQuery();
				if( rs != null ) 
				{
					while( rs.next() )
					{  
						mpiId  =  rs.getString(1);	
					
					}
				}
				pstmt.close();
				if(rs!=null) rs.close();
							
				cstmt= con.prepareCall("{ call bl_zatca_qr_request_check(?,?,?)}");
				cstmt.setString( 1,	mpiId );
				System.err.println("BillReceiptMessage.jsp,bl_zatca_qr_request_check mpiId===>"+mpiId);
				System.err.println("BillReceiptMessage.jsp,patDocType patDocNum ===>"+patDocType+"/"+patDocNum);
				System.err.println("BillReceiptMessage.jsp,billDocType ===>"+billDocType);
				System.err.println("BillReceiptMessage.jsp,billGenerated ===>"+billGenerated);
				cstmt.registerOutParameter(2,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
				cstmt.execute();
				zatca_error_code=cstmt.getString(2);
				Zatca_msg=cstmt.getString(3);
				if(zatca_error_code==null) zatca_error_code="";
				if(Zatca_msg==null) Zatca_msg="";
				System.err.println("bl_zatca_qr_request_check zatca_error_code===>"+zatca_error_code);
				System.err.println("bl_zatca_qr_request_check process_msg===>"+Zatca_msg);
				System.err.println("orgBillRefNum ===>"+orgBillRefNum);
				
				cstmt1 = con.prepareCall("call BL_ZATCA_UPDATE_ORG_BILL_NUM(?,?)");//V220517
				cstmt1.setString( 1,	mpiId );
				cstmt1.setString( 2,	orgBillRefNum );
				cstmt1.execute();
				con.commit();
			}
		}catch(Exception ex){
			ex.printStackTrace();
			con.rollback();
		}finally{
			if(cstmt!=null) cstmt.close();
			if(cstmt1!=null) cstmt1.close();
			if(con!=null) {
				ConnectionManager.returnConnection(con, request);
			}
		}
	}
//V221230 ends

//V221122
// Changes for E-Signature CRF 
String eSignatureFlag = BLReportIdMapper.eSignatureFlag(facilityId);
if(eSignatureFlag == null) eSignatureFlag = "N";
System.err.println("eSignatureFlag billgen->"+eSignatureFlag);		

%>
<script language="JavaScript">
$(document).ready(function(){
	if($('#error_value').val() == '1'){
		pDoc = parent.parent.frames[3].frames[2].document.forms[0];
		$(pDoc).find('#tdBtnGenerate').show();
		$(pDoc).find('#trProgress').hide();
		$(pDoc).find('#tdProgress').text('');
		$(pDoc).find('#compute').attr('disabled','disabled');		
		loadSettlement();
	}
	else{
		pDoc = parent.parent.frames[3].frames[2].document.forms[0];
		$(pDoc).find('#tdBtnGenerate').show();
		$(pDoc).find('#trProgress').hide();
		$(pDoc).find('#tdProgress').text('');
	}
	
});

function loadSettlement()
{	var confirmBox='';
	var exemptWarning='<%=exemptWarning%>';
	var exemptConsWarning='<%=exemptConsWarning%>';
	var billSlmtAmt='<%=billSlmtAmt%>';
	var billExemptAmt='<%=billExemptAmt%>';
	
	var Pgmid='<%=Pgmid%>';
	var PgmDate='<%=PgmDate%>';
	var Sessionid='<%=Sessionid%>';
	
	
	var slmtAmt='';
	var noOfDecimals= $(parent.parent.parent.frames[3].document.forms[0]).find('#noOfDecimal').val();
	if($('#billPrintYn').val() == 'Y'){
		
	
	  	
			var sessionId = Sessionid;
			var pgmDate = PgmDate;
			var reportId = Pgmid;
			var pgmId = Pgmid;
			var mpiId = '1';			                        			

			var sessionIdArr = sessionId.split(",");
			var pgmDateArr = pgmDate.split(",");
			var reportIdArr = reportId.split(",");
			var pgmIdArr = pgmId.split(",");
			
			var printArr = [];
			var params = 'calledFrom=ASYNCPRINT&';
			var sno = 1;
			var total = 0;
			for(var i=0; i<sessionIdArr.length;i++){
				var temp = pgmIdArr[i]+"/"+sessionIdArr[i]+"/"+pgmDateArr[i]+"/"+mpiId;
				params = params+'billPrintVal'+sno+'='+encodeURIComponent(temp)+'&';
				params = params+'report'+sno+'='+encodeURIComponent(reportIdArr[i])+'&';
				sno++;
				total++;
			}
			params = params+'totalReport='+total;
			$.ajax({
				type:"GET",
				url:"../jsp/BillReceiptAjax.jsp",
				data:params,
				dataType:"text",
				async:false,
				success: function(data){
                	$.ajax({
                		url:"../../eBL/jsp/BLAdhocDiscOnlineReport.jsp",
                		async:true,
                		type:'post',
                		datatype:'text',
                		success: function(data) {
                			
                		}
                	});
				},
				 error: function(data){
					 alert(data.flag)
			      }
			});
			
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	if(exemptWarning!=''&&exemptConsWarning=='')
		{
		 confirmBox =window.confirm(getMessage('BL7184','BL'));;
		 if(confirmBox){
		 $(parent.BillReceiptExisOrderSummary.document).find('#exemptReq').val("0.00");
		 putDecimal_field($(parent.BillReceiptExisOrderSummary.document).find('#exemptReq').get(0),17,noOfDecimals);	
		 slmtAmt=parseFloat(billSlmtAmt)+parseFloat(billExemptAmt);
			 $('#billSlmtAmt').val(slmtAmt);
			 $(parent.BillReceiptExisOrderSummary.document).find('#slmtAmt').val(slmtAmt);
			 putDecimal_field($(parent.BillReceiptExisOrderSummary.document).find('#slmtAmt').get(0),17,noOfDecimals);	
			
		 }
		
	}
	if(exemptConsWarning!=''&&exemptWarning=='' )
	{
	 confirmBox =window.confirm(getMessage('BL6470','BL'));
	
	 if(confirmBox){
		 
 $(parent.BillReceiptExisOrderSummary.document).find('#exemptReq').val("0.00");
	
 putDecimal_field($(parent.BillReceiptExisOrderSummary.document).find('#exemptReq').get(0),17,noOfDecimals);
	
		 slmtAmt=parseFloat(billSlmtAmt)+parseFloat(billExemptAmt);
		
		 $('#billSlmtAmt').val(slmtAmt);
		 $(parent.BillReceiptExisOrderSummary.document).find('#slmtAmt').val(slmtAmt);
		 putDecimal_field($(parent.BillReceiptExisOrderSummary.document).find('#slmtAmt').get(0),17,noOfDecimals);	
			
	 }
	
}
	
	if(exemptConsWarning!=''&&exemptWarning!='' )
	{
	 confirmBox =window.confirm(getMessage('BL7184','BL'));
	
	 if(confirmBox){
		 
	 
	 $(parent.BillReceiptExisOrderSummary.document).find('#exemptReq').val("0.00");
	 putDecimal_field($(parent.BillReceiptExisOrderSummary.document).find('#exemptReq').get(0),17,noOfDecimals);
	
		 slmtAmt=parseFloat(billSlmtAmt)+parseFloat(billExemptAmt);
		
		 $('#billSlmtAmt').val(slmtAmt);
		 $(parent.BillReceiptExisOrderSummary.document).find('#slmtAmt').val(slmtAmt);
		 putDecimal_field($(parent.BillReceiptExisOrderSummary.document).find('#slmtAmt').get(0),17,noOfDecimals);	
			
	 }
	 else{
		 
		 confirmBox =window.confirm(getMessage('BL6470','BL'));
		 if(confirmBox){
		 $(parent.BillReceiptExisOrderSummary.document).find('#exemptReq').val("0.00");
		 putDecimal_field($(parent.BillReceiptExisOrderSummary.document).find('#exemptReq').get(0),17,noOfDecimals);
		
			 slmtAmt=parseFloat(billSlmtAmt)+parseFloat(billExemptAmt);
			
			 $('#billSlmtAmt').val(slmtAmt);
			 $(parent.BillReceiptExisOrderSummary.document).find('#slmtAmt').val(slmtAmt);
			 putDecimal_field($(parent.BillReceiptExisOrderSummary.document).find('#slmtAmt').get(0),17,noOfDecimals);	
			 
				
		 }
		
	 }
	

}
	



		
	
	
	//if(parseInt($('#billAmt').val()) > 0 || parseInt($('#billAmt').val()) < 0 ){
	if($('#invokeSlmt').val() == 'Y'){

		/*var BillSlmtRoundingAmt = 'calledFrom=BillSlmtRoundingAmt'+	
		'&facilityId='+$('#facilityId').val()+
		'&billDocType='+$('#billDocType').val()+
		'&patDocNum='+$('#patDocNum').val()+
		'&billSlmtAmt='+ $(parent.BillReceiptExisOrderSummary.document).find('#docAmt1').val();// $('#billSlmtAmt').val();

		$.ajax({
			type:"GET",
			url:"../jsp/BillReceiptAjax.jsp",
			data:BillSlmtRoundingAmt,
			dataType:"text",
			async:false,
			success: function(data){	
				 $('#billSlmtAmt').val($.trim(data));			 
			},
			 error: function(data){
				
			  }
		});*/

		var totalRows = 1;
		var params = 'totalRows=1'+ 
					'&patient_id1='+$('#patientId').val()+
					'&episode_type1='+$('#episodeType').val()+
					'&episode_id1='+$('#episodeId').val()+
					'&visit_id1='+$('#visitId').val()+
					'&billdocType1='+$('#patDocType').val()+
					'&billdocNum1='+$('#patDocNum').val()+
					'&billdocDate1='+$('#billDocDate').val()+
					'&billTotalAmt1='+$('#billDocAmt').val()+
					'&billtotOutStdAmt1='+$('#billDocAmt').val()+
					'&excempted_amt1='+$('#billExemptAmt').val()+
					'&rem_slmt_amt1='+$('#billSlmtAmt').val()+
					'&bill_print_yn1=Y';
		
		$.ajax({	
			type:"POST",
			url:"../jsp/BLBillDetailsPersistance.jsp",
			data: params,	
			success: function(data){	
				if('<%=unProcessedYn%>' == 'Y'){
					alert(getMessage('BL9793','BL'));
				}
				//V221122
				var eSignatureFlag = document.forms[0].eSignatureFlag.value;
				if(eSignatureFlag=="Y"){
					var esign=OpenEsign();
					
				}
				var ZatcaYN=document.forms[0].ZatcaYN.value;
				if(ZatcaYN=="Y"){
					var Zatca_msg=document.forms[0].Zatca_msg.value;
					alert('<%=billGenerated%>\n'+Zatca_msg);
				}else{
					alert('<%=billGenerated%>');
				}//V221230				
				/* parent.window.returnValue = 'Y:::'+$('#patDocType').val()+':::'+$('#patDocNum').val()+':::'+$('#billSlmtAmt').val();
				parent.window.close(); */
				parent.parent.document.querySelectorAll("#dialog-body")[parent.parent.document.querySelectorAll("#dialog-body").length -1 ].contentWindow.returnValue = 'Y:::'+$('#patDocType').val()+':::'+$('#patDocNum').val()+':::'+$('#billSlmtAmt').val();
				parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close();
				
			},
			 error: function(data){
				 if('<%=unProcessedYn%>' == 'Y'){
						alert(getMessage('BL9793','BL'));
					}
					alert('<%=billGenerated%>');
		     }
		});
	}
	else{
		if('<%=unProcessedYn%>' == 'Y'){
			alert(getMessage('BL9793','BL'));
		}
		
		//V221122
		var eSignatureFlag = document.forms[0].eSignatureFlag.value;
		if(eSignatureFlag=="Y"){
			var esign=OpenEsign();
		
		}
		var ZatcaYN=document.forms[0].ZatcaYN.value;
		if(ZatcaYN=="Y"){
			var Zatca_msg=document.forms[0].Zatca_msg.value;
			alert('<%=billGenerated%>\n'+Zatca_msg);
		}else{
			alert('<%=billGenerated%>');
		}
		if('<%=slmtMsgId%>' != ''){
			alert(getMessage('<%=slmtMsgId%>','BL'));
		}
/* 		parent.window.returnValue = 'N';
		parent.window.close(); */
		
		parent.parent.document.querySelectorAll("#dialog-body")[parent.parent.document.querySelectorAll("#dialog-body").length -1 ].contentWindow.returnValue = 'N';
		parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close();
	}
	
}

//V221122

function OpenEsign(){
	var patDocType=document.forms[0].patDocType.value;
	var patDocNum=document.forms[0].patDocNum.value;
	var patientId=document.forms[0].patientId.value;
	var episodeType=document.forms[0].episodeType.value;
	var episodeId=document.forms[0].episodeId.value;
	var visitId=document.forms[0].visitId.value;
	var mpi_id="";
	var insBillCount="";
	
	$.ajax({
		type:"POST",
		url:"../../eBL/jsp/BLCommonAjax.jsp",
		data:"functionMode=mpiInsData&billdoctypecode="+patDocType+
				"&"+"billdocnum="+patDocNum,
		dataType:"text",
		async:false,
		success: function(data){
			var retVal = trimString(data).split(":::");
			mpi_id=retVal[0];
			insBillCount=retVal[1];
		},
		error: function(data){
			//alert("error in mpiInsData :"+data);
	  }
	});

	
	if(insBillCount>0){

		var returnVal=validate_eSignature();

		if(returnVal!='' && returnVal!='undefined' && returnVal!=undefined ){
			var params="docTypeCode="+patDocType+"&docNum="+patDocNum+"&visitId="+visitId+"&episodeType="+episodeType+"&episodeId="+episodeId+"&episodeId="+patientId+"&mpi_id="+mpi_id+"&image="+encodeURIComponent(returnVal); 
			$.ajax({
				type:"POST",
				url:"../../eBL/jsp/BLCommonAjax.jsp",
				data:"functionMode=PatientSign&"+params,
				dataType:"text",
				async:false,
				success: function(data){
					
				},
				error: function(data){
				//	alert("error in esign :"+data);
			  }
			});
		}
	}
	return 1;	
}
</script>
</head>

<BODY CLASS="MESSAGE" onKeyDown = 'lockKey()'>
<form id='messageFrm'>
<p align="left">
<%
	request.setCharacterEncoding("UTF-8");	
	//System.out.println("error->"+error);
	if ( error != null ) {
	%>
		<%=error %>
	<%	
	error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;
		if ( error_value.equals( "1" ) ){
			System.err.println("error_value ->"+error_value);
			System.err.println("calledFrom ->"+calledFrom);
			String beanId = "BillReceiptExistOrderExclusion" ;
			String beanName = "eBL.billreceipt.model.BillReceiptExistOrderExclusion";
			BillReceiptExistOrderExclusion exclusionBean = (BillReceiptExistOrderExclusion) getObjectFromBean(beanId, beanName, session);
			exclusionBean.clearAll();

			if("billGeneration".equals(calledFrom)){ 
				session.setAttribute("billRecBillGenNum", null);
				try{
					con = ConnectionManager.getConnection();
					pstmt = con.prepareStatement("Select to_char(sysdate,'dd/mm/yyyy HH24:MI') bill_doc_date from dual");
					rst = pstmt.executeQuery();
					if(rst != null && rst.next()){
						billDocDate = rst.getString("bill_doc_date");
					}
					
				}
				catch(Exception e){
					System.err.println("Exception in getting Bill Doc Date ->"+e);
				}
				finally{
					ConnectionManager.returnConnection(con);
					pstmt = null;
					rst = null;
				}
			}
					
		}
			
	}

%>
</p>
<p id='ehiserror'></p>
<input type='hidden' name='billDocType'  id='billDocType' value='<%=billDocType %>'>
<input type='hidden' name='receiptDocType'  id='receiptDocType' value='<%=receiptDocType %>'>
<input type='hidden' name='refundDocType'  id='refundDocType' value='<%=refundDocType %>'>
<input type='hidden' name='blngGrpId'  id='blngGrpId' value='<%=blngGrpId %>'>
<input type='hidden' name='patientId'  id='patientId' value='<%=patientId %>'>
<input type='hidden' name='episodeType'  id='episodeType' value='<%=episodeType %>'>
<input type='hidden' name='episodeId'  id='episodeId' value='<%=episodeId %>'>
<input type='hidden' name='visitId'  id='visitId' value='<%=visitId %>'>
<input type='hidden' name='billDocAmt' id='billDocAmt'  value='<%=billDocAmt %>'>
<input type='hidden' name='billSlmtAmt' id='billSlmtAmt'  value='<%=billSlmtAmt %>'>
<input type='hidden' name='billExemptAmt' id='billExemptAmt'  value='<%=billExemptAmt %>'>
<input type='hidden' name='patDocType' id='patDocType' value='<%=patDocType %>'>
<input type='hidden' name='patDocNum' id='patDocNum'  value='<%=patDocNum %>'>
<input type='hidden' name='billDocDate' id='billDocDate'  value='<%=billDocDate %>'>
<input type='hidden' name='billPrintYn' id='billPrintYn' value='<%=billPrintYn %>'>
<input type='hidden' name='invokeSlmt' id='invokeSlmt'  value='<%=invokeSlmt%>'>
<input type='hidden' name='unProcessedYn' id='unProcessedYn'  value='<%=unProcessedYn%>'>
<input type='hidden' name='error_value' id='error_value'  value='<%=error_value%>'>
<input type="hidden"	name="eSignatureFlag" id="eSignatureFlag"	value="<%=eSignatureFlag%>"><!-- V221122 -->
<input type="hidden"	name="Zatca_msg" id="Zatca_msg"		value="<%=Zatca_msg%>"><!-- V221230 -->
<input type="hidden"	name="zatca_error_code" 	id="zatca_error_code"	value="<%=zatca_error_code%>"><!-- V221230 -->
<input type="hidden"	name="ZatcaYN" id="ZatcaYN"		value="<%=ZatcaYN%>"><!-- V221230 -->
</form>
</BODY>

