<!DOCTYPE html>
<!-- 
Sr No        Version           TFS/Incident        SCF/CRF            		 	Developer Name
--------------------------------------------------------------------------------------------------------
1            V210129            13523         MOHE-CRF-0060       			Shikha Seth
--------------------------------------------------------------------------------------------------------
-->

<%@ page  import="java.sql.*, webbeans.eCommon.*,java.net.*, java.io.*,com.ehis.util.*,java.util.*,eBL.Common.*, eBL.*, eCommon.Common.*" contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script type="text/javascript">
$(document).ready(function(){

	  $("#multiBillSubmit").click(function(){
		  var episode_type=parent.BillSlmtEntryFrame.document.BillSlmtDetForm.episode_type.value;
		  var slmt_amt=parent.BillSlmtEntryFrame.document.BillSlmtDetForm.billslmtamtdet.value;
		  var outst_amt=parent.BillSlmtEntryFrame.document.BillSlmtDetForm.billpayableamt.value;
		  var deposit_adj_indicator=parent.BillSlmtEntryFrame.document.BillSlmtDetForm.depositAdjustedIndicator.value;
		  var slmt_type_count=$("#BillSlmtTypeForm",window.parent.frames[2].document).find('input[name="total_records"]').val();
		  var strfacilityid=document.forms[0].strfacilityid.value; //V210129
/* 		  if(slmt_amt==0 && deposit_adj_indicator=='false' ){
			  alert(getMessage("BL9621","BL"));	
		  }
		  else 	  
			  if(slmt_type_count==0 && deposit_adj_indicator=='false'){			  
			  alert(getMessage("BL9621","BL"));			  
		  } */
			  
		var v_total_settled_amt=document.forms[0].total_settled_amt.value;
		var v_adjusted_amount = parent.BillSlmtEntryFrame.document.BillSlmtDetForm.depAdjAmt.value;;
		  
		var slmtAmtAfterDepAdj = parseFloat(slmt_amt)+parseFloat(v_adjusted_amount);
		/*Below Columns added for Downtime entry*/
		var detDoc = parent.BillSlmtEntryFrame.document;
		var downType =  $(detDoc).find('#doc_type_number').val();
		var downDoc =  $(detDoc).find('#document_number').val();
		var downDate =  $(detDoc).find('#deposit_date').val();
		var downReason =  $(detDoc).find('#deposit_reason').val();
		var blRecRefInd = $(detDoc).find('#blRecRefInd').val();
		if($(detDoc).find('#downTimeEntry').prop('checked')){
			if(downType == ''){
				alert(getMessage("BL1514","BL"));
				return false;
			}
			if(downDoc == ''){
				alert(getMessage("BL1515","BL"));
				return false;
			}
			if(downDate == ''){
				alert(getMessage("BL1516","BL"));
				return false;
			}
			if(downReason == ''){
				alert(getMessage("BL1517","BL"));
				return false;
			}
		}
		
		if((slmt_amt!=v_total_settled_amt)&&slmt_type_count!=0)
		{
		alert(getMessage("BL9621","BL"));	
		}else if(slmt_type_count==0 && slmt_amt!=0 ){
			alert(getMessage("BL9621","BL"));	  
		}	  
		else{
			var vUrl = "../../servlet/eBL.BLBillSlmtAllServicesSubmitServlet?episode_type="+episode_type+"&slmt_amt="+slmt_amt+"&outst_amt="+outst_amt+"&strfacilityid="+strfacilityid; //V210129
			if($(detDoc).find('#downTimeEntry').prop('checked')){
				vUrl = vUrl+'&downTimeEntry=Y'+
						'&downType='+downType+
						'&downDoc='+downDoc+
						'&downDate='+downDate+
						'&downReason='+downReason+
						'&blRecRefInd='+blRecRefInd;
			}
			else{
				vUrl = vUrl+'&downTimeEntry=N'+'&blRecRefInd='+blRecRefInd;
			}
		    $.ajax({ 
                //url:"../../eBL/jsp/BLBillSlmtAllServicesSubmit.jsp?episode_type="+episode_type+"&slmt_amt="+slmt_amt,
                url:vUrl,
                type:'post',
                data: $("#BillSlmtTypeForm",window.parent.frames[2].document).serialize(),
                success: function(data) {   
                            //var obj = jQuery.parseJSON(data);
                            var obj =data;
                            
                            //Display Warning Message if any
                            if(obj.warningId != ''){
                            	alert(getMessage(obj.warningId,"BL"));	
                            }
							if(obj.flag=="S"){
			        		    $.ajax({
			                        url:"../../eBL/jsp/BLBillSlmtServiceListStorage.jsp",
			                        type:'post',
			                        data: {operation:"CACHE_CLEAR"},
			                        success: function(data) {
			                        	

			                        	if(obj.info.indexOf('BL_FULL_DEPOSIT_ADJ')>=0){
				                        	alert("Full Bill Amount Adjusted Against Deposit Successfully");
			                        	}
			                        	else{
				                        	alert(getMessage("BL9537","BL")+obj.info);
			                        	}

			                        	if(obj.printYN == 'Y'){
			                        			var sessionId = obj.sessionId;
			                        			var pgmDate = obj.pgmDate;
			                        			var reportId = obj.reportId;
			                        			var pgmId = obj.reportId;
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
			                        	
			                        	window.returnValue="SUCCESS";
			                            window.close();                    	  
			                        }
			    		     	});  
							}else{
								var error_level=obj.error_level;
								var error_id=obj.error_id;
								var error_text=obj.error_text;
								
								if(error_id!=''){
									if(error_id == 'BL9624' || error_id == 'BL9625'){
										alert(getMessage(error_id,"BL") +' '+ obj.chequeDays);
									}
									else{
										alert(getMessage(error_id,"BL"));
									}
									 	
								}else if(error_text!=''){
									alert(error_text);
								}else{
									alert("General Exception Occured in Bill Settlement");
								}
							}
                		}
	    	 });      
 		    
		  }
 		    
		});	 
	  
	  $("#cancel_button").click(function(){
	  
		var r=confirm("Are you sure you want to Cancel Bill Settlement ?");
		if (r==true)
		{
		    $.ajax({
                url:"../../eBL/jsp/BLBillSlmtServiceListStorage.jsp",
                type:'post',
                data: {operation:"CACHE_CLEAR"},
                success: function(data) {		
                	window.returnValue="CANCELLED";
                    window.close();   
                	/* const dialogTag = parent.parent.document.getElementById("dialog_tag");    
                    dialogTag.close(); */
                }
	     	}); 
		}
	 });	
	  
});
</script>
<%

	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");
	Connection con = null; 
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	ResultSet rscurr=null;
	String strfacilityid="";	String p_login_user="";
	String query_string=""; 	String strblnggrpid="";
	String strbilldoctypecode="";	String strbilldocnum ="";
	String strbillpayableamt=""; String strpatientid  ="";String strepisodetype="",strmoduleid="";
	String strepisodeid =""; String strvisitid ="";String strencounterid="";String strslmtpayername=""; 
	String struser ="";String strslmtidno = "";	int noofdecimal=2;String strdfltslmttypecode = "",function_id="",called_frm="",alw_co_wit_bl_slmt_yn="N",cal_frm_multi_bil_slmt="N",cash_counter_code="";

	String str_bill_amt = "0";
	String doc_amt="";
	double d_bill_amt = 0;
	String str_bill_print_format_enabled_yn = "N";
	//Added by muthu against 33868 - Receipt Print on 13-7-12
	String str_rec_print_format_enabled_yn = "N";
	request.setCharacterEncoding("UTF-8");
	try
	{
		con	=	ConnectionManager.getConnection(request);
		query_string=request.getQueryString();
		strpatientid  = request.getParameter("patientid");	
		if (strpatientid == null || strpatientid.equalsIgnoreCase("null")) 
		{strpatientid = "";}	
	 	strepisodetype = request.getParameter("episodetype");	
		if (strepisodetype == null || strepisodetype.equalsIgnoreCase("null")) 
		{strepisodetype = "";}	
		strmoduleid= request.getParameter("moduleid");	
		if (strmoduleid == null || strmoduleid.equalsIgnoreCase("null")) 
		{strmoduleid = "";}	
		strepisodeid = request.getParameter("episodeid");
		if (strepisodeid == null || strepisodeid.equalsIgnoreCase("null")) 
		{strepisodeid = "";}	
		strvisitid = request.getParameter("visitid");
		if (strvisitid == null || strvisitid.equalsIgnoreCase("null")) 
		{strvisitid = "";}
		strencounterid = request.getParameter("encounterid");
		if (strencounterid == null || strencounterid.equalsIgnoreCase("null")) 
		{strencounterid = "";}
		
		strslmtpayername = request.getParameter("slmtpayername");	
		if (strslmtpayername == null || strslmtpayername.equalsIgnoreCase("null")) 
		{strslmtpayername = "";}
		struser = request.getParameter("loggeduser");
		if (struser == null || struser.equalsIgnoreCase("null")) 
		{struser = "";}			
		strslmtidno = request.getParameter("slmtidno");
		//strfacilityid = (String)httpSession.getValue("facility_id"); //V210129 Commented
		strfacilityid = request.getParameter("encounterFacilityId"); //V210129 Added
		p_login_user =  p.getProperty("login_user");
		strblnggrpid = request.getParameter("strblnggrpid");	
		if (strblnggrpid == null || strblnggrpid.equalsIgnoreCase("null")) 
		{strblnggrpid = "";}	
		strbilldoctypecode = request.getParameter("billdoctypecode");
		if (strbilldoctypecode == null || strbilldoctypecode.equalsIgnoreCase("null")) 
		{strbilldoctypecode = "";}	
		strbilldocnum = request.getParameter("billdocnum");
		if (strbilldocnum == null || strbilldocnum.equalsIgnoreCase("null")) 
		{strbilldocnum = "";}	
		
		strbillpayableamt = request.getParameter("billpayableamt");
		if (strbillpayableamt == null || strbillpayableamt.equalsIgnoreCase("null")) 
		{strbillpayableamt = "";}	
		
		function_id = request.getParameter("function_id");
		if(function_id==null) function_id="";	

	
		called_frm= request.getParameter("called_frm");
		if(called_frm==null) called_frm="";	

		alw_co_wit_bl_slmt_yn = request.getParameter("alw_co_wit_bl_slmt_yn");
		if(alw_co_wit_bl_slmt_yn == null) alw_co_wit_bl_slmt_yn="N";

		cal_frm_multi_bil_slmt = request.getParameter("cal_frm_multi_bil_slmt");
		if(cal_frm_multi_bil_slmt == null) cal_frm_multi_bil_slmt="N";		

		cash_counter_code = request.getParameter("cashcounter");
		if(cash_counter_code == null) cash_counter_code="";	
	/****Added for Package Billing**********************starts*********/	
	if(function_id.equals("PKG_BILLING")){
		String remove_check = request.getParameter("remove_check");
		if(remove_check == null) remove_check="";	
		
		String bean_id1		= "PkgEnterReceptRefundBean" ;
		String bean_name1	= "eBL.PkgEnterReceptRefundBean";	

		PkgEnterReceptRefundBean bean1			= (PkgEnterReceptRefundBean)getBeanObject( bean_id1, bean_name1, request ) ;
		HashMap  support_data = bean1.getSupportData();		
		if(support_data!=null && support_data.size()>0)
		{				
			if(remove_check.equals(""))
			{
			doc_amt = (String)support_data.get("doc_amt");
			if(doc_amt==null) doc_amt="0";	
			}else{
				doc_amt="";
			}
		}
	}else{
		doc_amt="";
	}
	/****Added for Package Billing**********************ends*********/	

		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);
			}
			rscurr.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("3 btn="+e.toString());
		}

		try
		{		
			//pstmt = con.prepareStatement( " SELECT NVL(BILL_PRINT_FORMAT_ENABLED_YN,'N') FROM BL_PARAMETERS WHERE operating_facility_id =  '"+strfacilityid+"'");
			pstmt = con.prepareStatement( " SELECT NVL(BILL_PRINT_FORMAT_ENABLED_YN,'N'), NVL(REC_PRINT_FORMAT_ENABLED_YN,'N') FROM BL_PARAMETERS WHERE operating_facility_id =  ? "); //lakshmi
			pstmt.setString(1,strfacilityid);
			rs = pstmt.executeQuery();	

			while(rs.next())
			{
				str_bill_print_format_enabled_yn = rs.getString(1);
				str_rec_print_format_enabled_yn = rs.getString(2);//Added by Muthu on 13-7-12 against 33868
			}
			rs.close();
			pstmt.close();
			if(str_bill_print_format_enabled_yn == null) str_bill_print_format_enabled_yn="N";
			if(str_rec_print_format_enabled_yn == null) str_rec_print_format_enabled_yn="N";//Added by Muthu on 13-7-12 against 33868
		}
		catch(Exception e)
		{
			System.out.println("3 btn="+e.toString());
			e.printStackTrace();
		}

		try
		{		
			pstmt = con.prepareStatement( " select nvl(bill_amt,0) from bl_bill_hdr where DOC_TYPE_CODE = ? and DOC_NUM=? ");
			pstmt.setString(1,strbilldoctypecode);
			pstmt.setString(2,strbilldocnum);
			rs = pstmt.executeQuery();	
			while(rs.next())
			{
				str_bill_amt = rs.getString(1);
			}
			rs.close();
			pstmt.close();
			if(str_bill_amt == null) str_bill_amt="0";
			d_bill_amt = Double.parseDouble(str_bill_amt);
		}
		catch(Exception e)
		{
			System.out.println("3 btn="+e.toString());
			e.printStackTrace();
		}	
%>

<html>
	<head>
		<script>
		var totalRecords="";
		var count="";
		var formObj="";
		var classval="";

		async function addBillSlmt()
		{	
			document.forms[0].doc_amt.value="";
			
			var query_string=document.forms[0].query_string.value;
			var formObj = parent.frames[2].document.forms[0];
			total_records=formObj.total_records.value;
			for(var j=0;j<total_records;j++)
			{
				var temp=eval("formObj.selected_row"+j);
				temp.checked=false;
			}
			var isCCTerminalIdEnable = formObj.cc_terminal_id_enable.value; 		<!--Added by Monika for NMC-JD-CRF-0199 on 08/08/2023 -->
			var retVal = new Array();
			var billdoctype=document.forms[0].billdoctype.value;
			var billdocnum=document.forms[0].billdocnum.value;
			var blnggrp=document.forms[0].blnggrp.value;
			var total_amt_payable=document.forms[0].total_amt_payable.value;	
			var total_settled_amt=document.forms[0].total_settled_amt.value;	
			var function_id=document.forms[0].function_id.value;	
			//if(function_id=='rcpt_rfnd') 
			if(function_id=='rcpt_rfnd' || function_id=='PKG_BILLING' )
			{
			var settled_amt_det=parent.frames[1].document.forms[0].stlmt_amount.value;
			}else{
				var settled_amt_det=parent.frames[0].document.forms[0].billslmtamtdet.value;
			}
	
//	var tot_curr_stlmt=parent.frames[1].document.forms[0].tot_curr_stlmt.value;
/*
	if(parseFloat(tot_curr_stlmt)!=parseFloat(settled_amt_det))
	{
		 alert(getMessage("BL9659","BL"));
		//alert("Allocated Amt Must Be Equal To Settled Amt");
		return false;
	}
*/
		var action="add";	
		if(settled_amt_det=="")
		{
			alert(getMessage("BL9523","BL"));
			return;               
		}		
		if(eval(settled_amt_det)==0 && eval(total_settled_amt)==0)
		{
			alert(getMessage("BL9796","BL"));
			return false;
		}
		if(parseFloat(settled_amt_det)==parseFloat(total_settled_amt))
		{		
			alert(getMessage("BL9637","BL"));
			return;
		}
	/*if(total_amt_payable==total_settled_amt)
	{
		//alert("Amount Settled");
		alert(getMessage("BL9614","BL"));
		return;
	}
	total_amt_payable=parseFloat(total_amt_payable)-parseFloat(total_settled_amt);
	if(total_amt_payable<0)
	{
		total_amt_payable='0.00';
	}*/
	
	var center='1';
	var dialogTop = "200";
	var dialogHeight = "65vh" ;
	var dialogWidth = "58vw" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;	
	var title=encodeURIComponent(getLabel("eBL.ADD_BILL_SLMT_DTL.label","BL"));
	//title=encodeURIComponent(title);	
	var arguments = "" ;
	var column_sizes = escape("");               
	var column_descriptions ="";		
//	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"billdoctypecode="+billdoctype+"&"+"billdocnum="+billdocnum+"&"+"blnggrp="+blnggrp+"&"+"total_amt_payable="+total_amt_payable+"&"+"action="+action+"&"+"settled_amt_det="+settled_amt_det+"&"+"total_settled_amt="+total_settled_amt;

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"blnggrp="+blnggrp+"&"+"total_amt_payable="+total_amt_payable+"&"+"action="+action+"&"+"settled_amt_det="+settled_amt_det+"&"+"total_settled_amt="+total_settled_amt+"&"+query_string;
	
	retVal=await window.showModalDialog("../../eBL/jsp/BLBillSlmtMain2.jsp?"+param,arguments,features);
	//alert(retVal);
	if(retVal!=null)
	{	
		formObj = parent.frames[2].document.forms[0];
		totalRecords =eval(formObj.total_records.value);
		count =totalRecords + 1; 
		var record_select=count;
		var arr=new Array();	
		if(retVal == null) retVal='';
		if (retVal != null || retVal!="")
		{
			var retVal=unescape(retVal);			
			if(retVal != null && retVal.length>0)
			{			
				arr=retVal.split("::");	
				var billdoctype=arr[0];
				if(billdoctype==" ")billdoctype="";
				var billdocnum=arr[1];
				if(billdocnum==" ")billdocnum="";
				var billpayableamt=arr[2];
				if(billpayableamt==" ")billpayableamt="";
				var billslmtamt=arr[3];
				if(billslmtamt==" ")billslmtamt="";
				var slmttype=arr[4];
				if(slmttype==" ")slmttype="";	
				var payername=arr[5];
				if(payername==" ")payername="";				
				var recrefidno=arr[6];
				if(recrefidno==" ")recrefidno="";
				var ext_acc_interface_yn=arr[7];
				if(ext_acc_interface_yn==" ")ext_acc_interface_yn="";				
				var ext_acc_fac_id=arr[8];
				if(ext_acc_fac_id==" ")ext_acc_fac_id="";
				var instref=arr[9];
				if(instref==" ")instref="";
				var instdate=arr[10];
				if(instdate==" ")instdate="";
				var instremark=arr[11];
				if(instremark==" ")instremark="";
				var instbranch=arr[12];
				if(instbranch==" ")instbranch="";
				var onlineapproval=arr[13];					
				if(onlineapproval==" ")onlineapproval="";				
				var batchno=arr[14];
				if(batchno==" ")batchno="";
				var apprrefno=arr[15];
				if(apprrefno==" ")apprrefno="";
				var saledraftno=arr[16];
				if(saledraftno==" ")saledraftno="";
				var cashslmtflag=arr[17];
				if(cashslmtflag==" ")cashslmtflag="";				
				var instbankname=arr[18];
				if(instbankname==" ")instbankname="";
				var cash_given=arr[19];
				if(cash_given==" ")cash_given="";
				var cash_return=arr[20];
				if(cash_return==" ")cash_return="";
				var short_desc=arr[21];
				if(short_desc==" ")short_desc="";
				var instremarkcode=arr[22];
				if(instremarkcode==" ")instremarkcode="";

				var credit_card_machine_int_yn = arr[24];
				if(credit_card_machine_int_yn == " ") credit_card_machine_int_yn="";
				
				//Added by Monika for NMC-JD-CRF-0199
				var cc_term_id_num = arr[26];
				if(cc_term_id_num == "") cc_term_id_num ="";
				//alert("cc_term_id_num : "+cc_term_id_num);
			}
		}
		var record_select=count;
		for(var j=totalRecords;j<count;j++ )
		{
			if(j % 2 == 0 )
			{
				classval	=	"QRYEVEN";
			}
			else
			{
				classval	=	"QRYODD";
			}
			//console.log(parent.BillSlmtTypeFrame.document.getElementById("bill_slmt_data"));
			curr_row	=	parent.BillSlmtTypeFrame.document.getElementById("bill_slmt_data").insertRow();
			//console.log(curr_row);
			curr_row.id= "row"+eval(totalRecords+1);		
			cell	=	curr_row.insertCell();
			curr_row.cells[0].className	= classval;
			curr_row.cells[0].WIDTH	= "6%";
			curr_row.cells[0].insertAdjacentHTML("beforeend", "<input type='checkbox'  name='selected_row"+j+"' id='selected_row"+j+"' style='text-align:right'  value='' onClick='selected("+j+");' >");
	
			cell	=	curr_row.insertCell();
			curr_row.cells[1].className	= classval;
			curr_row.cells[1].WIDTH	= "6%";
			curr_row.cells[1].insertAdjacentHTML("beforeend", "<input maxlength='30' size='10' type=text readonly name='billslmtamt"+j+"' id='billslmtamt"+j+"'  value='"+billslmtamt+"' readonly style='text-align:right'  >");
	
			cell	=	curr_row.insertCell();
			curr_row.cells[2].className	=classval;
			curr_row.cells[2].WIDTH	= "6%";
			curr_row.cells[2].insertAdjacentHTML("beforeend", "<input type='text' maxlength='40' size='20' readonly name='shortdesc"+j+"' id='shortdesc"+j+"'   value='"+short_desc+"'  > <input type=hidden name='slmttype"+j+"' id='slmttype"+j+"' value='"+slmttype+"' >");
	
			cell	=	curr_row.insertCell();
			curr_row.cells[3].className	=classval;
			curr_row.cells[3].WIDTH	= "6%";
			curr_row.cells[3].insertAdjacentHTML("beforeend", "<input type='text' maxlength='15' size='10' readonly name='cash_given"+j+"' id='cash_given"+j+"'   value='"+cash_given+"' style='text-align:right'  > ");
			
			cell	=	curr_row.insertCell();
			curr_row.cells[4].className	=classval;
			curr_row.cells[4].WIDTH	= "6%";
			curr_row.cells[4].insertAdjacentHTML("beforeend", "<input type='text' maxlength='15' size='10' readonly name='cash_return"+j+"' id='cash_return"+j+"'   value='"+cash_return+"' style='text-align:right'  > ");
			
			
			cell	=	curr_row.insertCell();
			curr_row.cells[5].className	=classval;
			curr_row.cells[5].WIDTH	= "6%";
			curr_row.cells[5].insertAdjacentHTML("beforeend", "<input type='text' maxlength='15' size='10' readonly name='instref"+j+"' id='instref"+j+"'   value='"+instref+"'  >");
	
			cell	=	curr_row.insertCell();
			curr_row.cells[6].className	=classval;
			curr_row.cells[6].WIDTH	= "6%";
			curr_row.cells[6].insertAdjacentHTML("beforeend", "<input type='text' maxlength='15' size='10' readonly name='instdate"+j+"' id='instdate"+j+"'   value='"+instdate+"'  >");
			
			cell	=	curr_row.insertCell();
			curr_row.cells[7].className	=classval;
			curr_row.cells[7].WIDTH	= "10%";
			curr_row.cells[7].insertAdjacentHTML("beforeend", "<input type='text' maxlength='15' size='10' readonly name='creditcardco"+j+"' id='creditcardco"+j+"'   value='"+instremark+"'  >");
			
			cell	=	curr_row.insertCell();
			curr_row.cells[8].className	=classval;
			curr_row.cells[8].WIDTH	= "10%";
			curr_row.cells[8].insertAdjacentHTML("beforeend", "<input type='text' maxlength='15' size='10' readonly name='instbankname"+j+"' id='instbankname"+j+"'   value='"+instbankname+"'  ><input type=hidden name='instremarkcode"+j+"' id='instremarkcode"+j+"' value='"+instremarkcode+"' >");
	
			cell	=	curr_row.insertCell();
			curr_row.cells[9].className	=classval;
			curr_row.cells[9].WIDTH	= "6%";
			curr_row.cells[9].insertAdjacentHTML("beforeend", "<input type='text' maxlength='15' size='10' readonly name='instbranch"+j+"' id='instbranch"+j+"'   value='"+instbranch+"'  >");
	
			cell	=	curr_row.insertCell();
			curr_row.cells[10].className	=classval;
			curr_row.cells[10].WIDTH	= "4%";
			curr_row.cells[10].insertAdjacentHTML("beforeend", "<input type='text' maxlength='10' size='10' readonly name='batchno"+j+"' id='batchno"+j+"'   value='"+batchno+"'  >");
	
			cell	=	curr_row.insertCell();
			curr_row.cells[11].className	=classval;
			curr_row.cells[11].WIDTH	= "5%";
			curr_row.cells[11].insertAdjacentHTML("beforeend", "<input type='text' maxlength='10' size='10' readonly name='apprrefno"+j+"' id='apprrefno"+j+"'   value='"+apprrefno+"'  >");
			
			cell	=	curr_row.insertCell();
			curr_row.cells[12].className	=classval;
			curr_row.cells[12].WIDTH	= "5%";
			curr_row.cells[12].insertAdjacentHTML("beforeend", "<input type='text' maxlength='10' size='10' readonly name='saledraftno"+j+"' id='saledraftno"+j+"'   value='"+saledraftno+"'  >");
			<!--Added by Monika for NMC-JD-CRF-0199 on 08/08/2023 -->	
			if(isCCTerminalIdEnable == "true"){
				//Added By Monika against NMC - JD-CRF-0199
				cell	=	curr_row.insertCell();
				curr_row.cells[13].className	=classval;
				curr_row.cells[13].WIDTH	= "5%";
				curr_row.cells[13].insertAdjacentHTML("beforeend", "<input type='text' maxlength='10' size='10' readonly name='cc_term_id_num"+j+"' id='cc_term_id_num"+j+"'   value='"+cc_term_id_num+"'  >");
		
				cell	=	curr_row.insertCell();
				curr_row.cells[14].className	=classval;
				curr_row.cells[14].WIDTH	= "6%";
				curr_row.cells[14].insertAdjacentHTML("beforeend", "<input type='text' maxlength='15' size='20' readonly name='payername"+j+"' id='payername"+j+"'   value='"+payername+"'><input type=hidden name='ext_acc_interface_yn"+j+"' id='ext_acc_interface_yn"+j+"' value='"+ext_acc_interface_yn+"'><input type=hidden name='credit_card_machine_int_yn"+j+"' id='credit_card_machine_int_yn"+j+"' value='"+credit_card_machine_int_yn+"' > ");
		
				cell	=	curr_row.insertCell();
				curr_row.cells[15].className	=classval;
				curr_row.cells[15].WIDTH	= "6%";
				curr_row.cells[15].insertAdjacentHTML("beforeend", "<input type='text' maxlength='15' size='20' readonly name='recrefidno"+j+"' id='recrefidno"+j+"'   value='"+recrefidno+"'  ><input type=hidden name='ext_acc_fac_id"+j+"' id='ext_acc_fac_id"+j+"' value='"+ext_acc_fac_id+"' >");
				
				
				cell	=	curr_row.insertCell();
				curr_row.cells[16].className	=classval;
				curr_row.cells[16].WIDTH	= "6%";
				curr_row.cells[16].insertAdjacentHTML("beforeend", "<input type='checkbox' maxlength='30' size='10'   "+onlineapproval+" name='onlineapproval"+j+"' id='onlineapproval"+j+"' value='"+onlineapproval+"' readonly onclick='check_box("+j+")'>");
			}else{
				cell	=	curr_row.insertCell();
				curr_row.cells[13].className	=classval;
				curr_row.cells[13].WIDTH	= "6%";
				curr_row.cells[13].insertAdjacentHTML("beforeend", "<input type='text' maxlength='15' size='20' readonly name='payername"+j+"' id='payername"+j+"'   value='"+payername+"'><input type=hidden name='ext_acc_interface_yn"+j+"' id='ext_acc_interface_yn"+j+"' value='"+ext_acc_interface_yn+"'><input type=hidden name='credit_card_machine_int_yn"+j+"' id='credit_card_machine_int_yn"+j+"' value='"+credit_card_machine_int_yn+"' > <input type=hidden name='cc_term_id_num"+j+"' id='cc_term_id_num"+j+"' value='"+cc_term_id_num+"' >");
	
				cell	=	curr_row.insertCell();
				curr_row.cells[14].className	=classval;
				curr_row.cells[14].WIDTH	= "6%";
				curr_row.cells[14].insertAdjacentHTML("beforeend", "<input type='text' maxlength='15' size='20' readonly name='recrefidno"+j+"' id='recrefidno"+j+"'   value='"+recrefidno+"'  ><input type=hidden name='ext_acc_fac_id"+j+"' id='ext_acc_fac_id"+j+"' value='"+ext_acc_fac_id+"' >");
				
				
				cell	=	curr_row.insertCell();
				curr_row.cells[15].className	=classval;
				curr_row.cells[15].WIDTH	= "6%";
				curr_row.cells[15].insertAdjacentHTML("beforeend", "<input type='checkbox' maxlength='30' size='10'   "+onlineapproval+" name='onlineapproval"+j+"' id='onlineapproval"+j+"' value='"+onlineapproval+"' readonly onclick='check_box("+j+")'>");
			}
			record_select++;
		}
		formObj.total_records.value=count;

		tot_setld_amt();
			
			}
	}

async function modifyBillSlmt()
{
	document.forms[0].doc_amt.value="";
	var checked_row=parent.BillSlmtTypeFrame.document.forms[0].checked_row.value;
	var billdoctype=document.forms[0].billdoctype.value;
	var total_amt_payable=document.forms[0].total_amt_payable.value;
	var billdocnum=document.forms[0].billdocnum.value;
	var blnggrp=document.forms[0].blnggrp.value;
	var total_records="";
	var function_id=document.forms[0].function_id.value;
	//if(function_id=='rcpt_rfnd')
	if(function_id=='rcpt_rfnd' || function_id=='PKG_BILLING')
	{
	var total_settled_amt="";//document.forms[0].total_settled_amt.value;
	var settled_amt_det="";//parent.frames[0].document.forms[0].billslmtamtdet.value;
	var tot_curr_stlmt="";//parent.frames[1].document.forms[0].tot_curr_stlmt.value;
	}
	else{
		var total_settled_amt="";//document.forms[0].total_settled_amt.value;
		var settled_amt_det="";//parent.frames[0].document.forms[0].billslmtamtdet.value;	
		var tot_curr_stlmt="";//parent.frames[1].document.forms[0].tot_curr_stlmt.value;
	   }
	total_amt_payable=parseFloat(total_amt_payable)-parseFloat(total_settled_amt);	
	total_records=parent.frames[2].document.forms[0].total_records.value;	

	var query_string=document.forms[0].query_string.value;

	if(total_records==0)
	{
		alert(getMessage("NO_RECORD_FOUND","common"));
		return false;
	}

	if(total_amt_payable<0)
	{
		total_amt_payable='0.00';
	}
	if(checked_row=="")
	{		
		alert(getMessage("ATLEAST_ONE_SELECTED","common"));
	}
		
	else
	{
		var billslmtamt1=eval("parent.frames[2].document.forms[0].billslmtamt"+checked_row);
		var billslmtamt=billslmtamt1.value;		
		total_amt_payable=parseFloat(total_amt_payable)+parseFloat(billslmtamt);	

		var shortdesc1=eval("parent.frames[2].document.forms[0].shortdesc"+checked_row);
		var shortdesc=shortdesc1.value;			

		var slmttype1=eval("parent.frames[2].document.forms[0].slmttype"+checked_row);
		var slmttype=slmttype1.value;	
		
		/*if(slmttype=='CCA')
		{
			alert("credit card transaction can not modify");
			return false;
		}*/
		
		
		var cash_given1=eval("parent.frames[2].document.forms[0].cash_given"+checked_row);
		var cash_given=cash_given1.value;		

		var cash_return1=eval("parent.frames[2].document.forms[0].cash_return"+checked_row);
		var cash_return=cash_return1.value;		

		var instref1=eval("parent.frames[2].document.forms[0].instref"+checked_row);
		var instref=instref1.value;			

		var instdate1=eval("parent.frames[2].document.forms[0].instdate"+checked_row);
		var instdate=instdate1.value;		

		var creditcardco1=eval("parent.frames[2].document.forms[0].creditcardco"+checked_row);
		var creditcardco=creditcardco1.value;		
		
		var instbankname1=eval("parent.frames[2].document.forms[0].instbankname"+checked_row);
		var instbankname=instbankname1.value;	
		
		var instbranch1=eval("parent.frames[2].document.forms[0].instbranch"+checked_row);
		var instbranch=instbranch1.value;	
		instbranch = encodeURIComponent(instbranch);
		
		var instremarkcode1=	eval("parent.frames[2].document.forms[0].instremarkcode"+checked_row);
		var instremarkcode=instremarkcode1.value;			

		var batchno1=eval("parent.frames[2].document.forms[0].batchno"+checked_row);
		var batchno=batchno1.value;			

		var apprrefno1=eval("parent.frames[2].document.forms[0].apprrefno"+checked_row);
		var apprrefno=apprrefno1.value;			

		var saledraftno1=eval("parent.frames[2].document.forms[0].saledraftno"+checked_row);
		var saledraftno=saledraftno1.value;			

		var payername1=eval("parent.frames[2].document.forms[0].payername"+checked_row);
		var payername=payername1.value;				

		var recrefidno1=eval("parent.frames[2].document.forms[0].recrefidno"+checked_row);
		var recrefidno=recrefidno1.value;			

		var onlineapproval1=eval("parent.frames[2].document.forms[0].onlineapproval"+checked_row);
		var onlineapproval="";

		var credit_card_machine_int_yn = eval("parent.frames[2].document.forms[0].credit_card_machine_int_yn"+checked_row);

		if(onlineapproval1.checked)
		{			
			onlineapproval="checked";
			if(credit_card_machine_int_yn.value == "Y")
			{
				alert(getMessage("BL9888","BL"));
				return false;
			}
		}
		else
		{			
			onlineapproval="";
		}
		 
		var ext_acc_interface_yn1=eval("parent.frames[2].document.forms[0].ext_acc_interface_yn"+checked_row);
		var ext_acc_interface_yn=ext_acc_interface_yn1.value;			

		var ext_acc_fac_id1=eval("parent.frames[2].document.forms[0].ext_acc_fac_id"+checked_row);
		var ext_acc_fac_id=ext_acc_fac_id1.value;	
		
		//Added By Monika against NMC - JD-CRF-0199
		var term_id_num1 = eval("parent.frames[2].document.forms[0].cc_term_id_num"+checked_row);
		var term_id_num = term_id_num1.value;		
		
	var action="modify";
	var retVal			= new String();
	var center='1';
	var dialogTop = "0vh";
	var dialogHeight = "65vh" ;
	var dialogWidth = "58vw" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
	var title=encodeURIComponent(getLabel("eBL.MODI_BILL_SLMT_DTL.label","BL"));
	//title=encodeURIComponent(title);	
	var arguments = "" ;
	var column_sizes = escape("");               
	var column_descriptions ="";	
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"billslmtamt="+billslmtamt+"&"+"shortdesc="+shortdesc+"&"+"slmttype="+slmttype+"&"+"cash_given="+cash_given+"&"+"cash_return="+cash_return+"&"+"instref="+instref+"&"+"instdate="+instdate+"&"+"creditcardco="+creditcardco+"&"+"instbankname="+instbankname+"&"+"instbranch="+instbranch+"&"+"batchno="+batchno+"&"+"apprrefno="+apprrefno+"&"+"saledraftno="+saledraftno+"&"+"payername="+encodeURIComponent(payername)+"&"+"recrefidno="+recrefidno+"&"+"onlineapproval="+onlineapproval+"&"+"action="+action+"&"+"blnggrp="+blnggrp+"&"+"instremarkcode="+instremarkcode+"&"+"total_amt_payable="+total_amt_payable+"&"+"settled_amt_det="+settled_amt_det+"&"+"total_settled_amt="+total_settled_amt+"&"+"ext_acc_interface_yn="+ext_acc_interface_yn+"&"+"ext_acc_fac_id="+ext_acc_fac_id+"&"+"cc_term_id_num="+term_id_num+"&"+query_string;
	
	retVal=await window.showModalDialog("../../eBL/jsp/BLBillSlmtMain2.jsp?"+param,arguments,features);
		var formObj = parent.BillSlmtTypeFrame.document.BillSlmtTypeForm;
		total_records=formObj.total_records.value;
		for(var j=0;j<total_records;j++)
		{
			var temp=eval("formObj.selected_row"+j);
			temp.checked=false;
		}
		if(retVal!=null)
		{
		var arr=new Array();
		if(retVal == null) retVal='';
		if (retVal != null || retVal!="")
		{
			var retVal=unescape(retVal);					  
			if(retVal != null && retVal.length>0)
			{
				//var formObj = parent.BillSlmtTypeFrame.document.BillSlmtTypeForm;
				arr=retVal.split("::");	
				var billslmtamt1=eval("parent.frames[2].document.forms[0].billslmtamt"+checked_row);
				if(arr[3]==" ")arr[3]="";
				billslmtamt1.value=arr[3];
				var shortdesc1=eval("parent.frames[2].document.forms[0].shortdesc"+checked_row);
				if(arr[21]==" ")arr[21]="";
				shortdesc1.value=arr[21];
				var slmttype1=eval("parent.frames[2].document.forms[0].slmttype"+checked_row);
				if(arr[4]==" ")arr[4]="";
				slmttype1.value=arr[4];
				var instref1=eval("parent.frames[2].document.forms[0].instref"+checked_row);
				if(arr[9]==" ")arr[9]="";
				instref1.value=arr[9];
				var instdate1=eval("parent.frames[2].document.forms[0].instdate"+checked_row);
				if(arr[10]==" ")arr[10]="";
				instdate1.value=arr[10];	

				var creditcardco1=eval("parent.frames[2].document.forms[0].creditcardco"+checked_row);
				if(arr[11]==" ")arr[11]="";
				creditcardco1.value=arr[11];

				var instbankname1=eval("parent.frames[2].document.forms[0].instbankname"+checked_row);
				if(arr[18]==" ")arr[18]="";
				instbankname1.value=arr[18];

				var batchno1=eval("parent.frames[2].document.forms[0].batchno"+checked_row);
				if(arr[14]==" ")arr[14]="";
				batchno1.value=arr[14];
				
				var apprrefno1=eval("parent.frames[2].document.forms[0].apprrefno"+checked_row);
				if(arr[15]==" ")arr[15]="";
				apprrefno1.value=arr[15];

				var saledraftno1=eval("parent.frames[2].document.forms[0].saledraftno"+checked_row);
				if(arr[16]==" ")arr[16]="";
				saledraftno1.value=arr[16];


				var instremarkcode1=eval("parent.frames[2].document.forms[0].instremarkcode"+checked_row);
				if(arr[22]==" ")arr[22]="";
				instremarkcode1.value=arr[22];
				
				var payername1=eval("parent.frames[2].document.forms[0].payername"+checked_row);
				if(arr[5]==" ")arr[5]="";
				payername1.value=arr[5];

				var recrefidno1=eval("parent.frames[2].document.forms[0].recrefidno"+checked_row);
				if(arr[6]==" ")arr[6]="";
				recrefidno1.value=arr[6];
				
				var cash_given1=eval("parent.frames[2].document.forms[0].cash_given"+checked_row);
				if(arr[19]==" ")arr[19]="";
				cash_given1.value=arr[19];			

				var cash_return1=eval("parent.frames[2].document.forms[0].cash_return"+checked_row);
				if(arr[20]==" ")arr[20]="";
				cash_return1.value=arr[20];	
				
				var onlineapproval1=eval("parent.frames[2].document.forms[0].onlineapproval"+checked_row);
				if(arr[13]==" ")arr[13]="";
				onlineapproval1.value=arr[13];					
				var ckcbflag=arr[13];
				if(ckcbflag=="checked")
				{	
					onlineapproval1.checked=true;
				}
				else{
					onlineapproval1.checked=false;
				}

				var ext_acc_interface_yn1=eval("parent.frames[2].document.forms[0].ext_acc_interface_yn"+checked_row);
				if(arr[7]==" ")arr[7]="";
				ext_acc_interface_yn1.value=arr[7];	

				var ext_acc_fac_id1=eval("parent.frames[2].document.forms[0].ext_acc_fac_id"+checked_row);
				if(arr[8]==" ")arr[8]="";
				ext_acc_fac_id1.value=arr[8];	
				
				var credit_card_machine_int_yn = eval("parent.frames[2].document.forms[0].credit_card_machine_int_yn"+checked_row);
				if(arr[24] == " ") arr[24]="";
				credit_card_machine_int_yn.value = arr[24];
				
				//Added By Monika against NMC-JD-CRF-0199
				var term_id_num = eval("parent.frames[2].document.forms[0].cc_term_id_num"+checked_row);
				if(arr[26] == " ") arr[26]="";
				term_id_num.value = arr[26];
			}
		}
		}
			tot_setld_amt();
	}
	parent.frames[2].document.forms[0].checked_row.value="";
}

function tot_setld_amt()
{
	var total_settled=0.0;	
	var tot_setl="";
	var a1=new Array();
	var	totalRecords =parent.frames[2].document.forms[0].total_records.value;
	var decimal=document.forms[0].noofdecimal.value;

	for(var i=0;i<totalRecords;i++)
	{
	  tot_setl=eval("parent.frames[2].document.forms[0].billslmtamt"+i);
	  a1[i]=tot_setl.value;
	  if(a1[i]==""){a1[i]="0.0";}
	  total_settled=parseFloat(total_settled) + parseFloat(a1[i]);	  
	}	

/*
	total_settled = Math.round(total_settled*Math.pow(10,decimal))/Math.pow(10,decimal);
	document.forms[0].total_settled_amt.value=total_settled;
*/

//	total_settled = roundNumber(total_settled,decimal);
	total_settled = total_settled.toFixed(decimal);
	if(document.forms[0].doc_amt.value!="")
	{		
		document.forms[0].total_settled_amt.value=document.forms[0].doc_amt.value;	
	}else{
	document.forms[0].total_settled_amt.value=total_settled;
	}

	var temp_total_settled=eval("document.forms[0].total_settled_amt");
	putdeci(temp_total_settled);
	/*var v_set_amt=parent.frames[0].document.forms[0].billslmtamtdet.value;
	if(parseFloat(temp_total_settled.value)==parseFloat(v_set_amt))
	{
		parent.frames[0].document.forms[0].billslmtamtdet.readOnly=true;
	}*/
}

function putdeci(object)
	{	
		if(object.value!='')
		{
		var decimal=document.forms[0].noofdecimal.value;
		putDecimal(object,17,decimal);
		}
	}

function removeBillSlmt()
{
	

	var checked_row=parent.BillSlmtTypeFrame.document.forms[0].checked_row.value;	
	
	<!-- 	GHL-CRF-0366.1 Karthik added the below code for Credit Card Integration -->	
	var credit_card_payment_suceeded = eval("parent.frames[2].document.forms[0].credit_card_machine_int_yn"+checked_row);
	if(credit_card_payment_suceeded!=null && credit_card_payment_suceeded.value == "Y")
		{
			alert(" Credit Card Transcation Suceeded. Record Cannot be Deleted");
			return false;
		}
	<!-- 	GHL-CRF-0366.1 Karthik added the below code for Credit Card Integration -->
	
	
	var billdoctype=document.forms[0].billdoctype.value;
	var billdocnum=document.forms[0].billdocnum.value;
	var blnggrp=document.forms[0].blnggrp.value;
	var query_string=document.forms[0].query_string.value;
	var formObj = parent.BillSlmtTypeFrame.document.BillSlmtTypeForm;
	var total_records="";
	//total_records=parent.frames[2].document.forms[0].total_records.value;	
	total_records=formObj.total_records.value;	
	if(total_records==0)
	{
		alert(getMessage("NO_RECORD_FOUND","common"));
		return false;
	}
	if(checked_row=="")
	{		
		alert(getMessage("ATLEAST_ONE_SELECTED","common"));
	}
	else
	{
		if(confirm(getMessage("DELETE_RECORD","common"))) //BL9760
		{
			totalRecords =eval(formObj.total_records.value);			
			parent.frames[2].document.forms[0].action="../../eBL/jsp/BLBillSlmtTypeIRB.jsp?remove_check=remove&"+"&checked_row="+checked_row+"&total_records="+totalRecords+"&"+query_string;
			parent.frames[2].document.forms[0].submit();
			
		}
		else
		{
			return false;			
		}
	}
	for(var j=0;j<total_records;j++)
	{
		var temp=eval("formObj.selected_row"+j);
		temp.checked=false;
	}
	parent.frames[2].document.forms[0].checked_row.value="";
}


/*function removeBillSlmt()
{
	var 
	checked_row=parent.BillSlmtTypeFrame.document.forms[0].checked_row.value;
	var billdoctype=document.forms[0].billdoctype.value;
	var billdocnum=document.forms[0].billdocnum.value;
	var blnggrp=document.forms[0].blnggrp.value;
	var query_string=document.forms[0].query_string.value;
	var total_records="";
	total_records=parent.frames[2].document.forms[0].total_records.value;	
	if(total_records==0)
	{
		alert(getMessage("NO_RECORD_FOUND","common"));
		return false;
	}
	if(checked_row=="")
	{		
		alert(getMessage("ATLEAST_ONE_SELECTED","common"));
	}		
	else
	{
		var billslmtamt1=eval("parent.frames[2].document.forms[0].billslmtamt"+checked_row);
		var billslmtamt=billslmtamt1.value;		
		
		var shortdesc1=eval("parent.frames[2].document.forms[0].shortdesc"+checked_row);
		var shortdesc=shortdesc1.value;			

		var slmttype1=eval("parent.frames[2].document.forms[0].slmttype"+checked_row);
		var slmttype=slmttype1.value;			
		
		var cash_given1=eval("parent.frames[2].document.forms[0].cash_given"+checked_row);
		var cash_given=cash_given1.value;		

		var cash_return1=eval("parent.frames[2].document.forms[0].cash_return"+checked_row);
		var cash_return=cash_return1.value;		

		var instref1=eval("parent.frames[2].document.forms[0].instref"+checked_row);
		var instref=instref1.value;			

		var instdate1=eval("parent.frames[2].document.forms[0].instdate"+checked_row);
		var instdate=instdate1.value;		

		var creditcardco1=eval("parent.frames[2].document.forms[0].creditcardco"+checked_row);
		var creditcardco=creditcardco1.value;		
		
		var instbankname1=eval("parent.frames[2].document.forms[0].instbankname"+checked_row);
		var instbankname=instbankname1.value;	
		
		var instbranch1=eval("parent.frames[2].document.forms[0].instbranch"+checked_row);
		var instbranch=instbranch1.value;	
		
		var instremarkcode1=	eval("parent.frames[2].document.forms[0].instremarkcode"+checked_row);
		var instremarkcode=instremarkcode1.value;			

		var batchno1=eval("parent.frames[2].document.forms[0].batchno"+checked_row);
		var batchno=batchno1.value;				

		var apprrefno1=eval("parent.frames[2].document.forms[0].apprrefno"+checked_row);
		var apprrefno=apprrefno1.value;			

		var saledraftno1=eval("parent.frames[2].document.forms[0].saledraftno"+checked_row);
		var saledraftno=saledraftno1.value;			

		var payername1=eval("parent.frames[2].document.forms[0].payername"+checked_row);
		var payername=payername1.value;				

		var recrefidno1=eval("parent.frames[2].document.forms[0].recrefidno"+checked_row);
		var recrefidno=recrefidno1.value;			

		var onlineapproval1=eval("parent.frames[2].document.forms[0].onlineapproval"+checked_row);
		var onlineapproval="";
		if(onlineapproval1.checked)
		{
		onlineapproval="checked";
		}else{
			onlineapproval="";
		 }

		  var ext_acc_interface_yn1=eval("parent.frames[2].document.forms[0].ext_acc_interface_yn"+checked_row);
		var ext_acc_interface_yn=ext_acc_interface_yn1.value;			

		var ext_acc_fac_id1=eval("parent.frames[2].document.forms[0].ext_acc_fac_id"+checked_row);
		var ext_acc_fac_id=ext_acc_fac_id1.value;	
		
	var action="remove";
	var retVal			= new String();
	var center='1';
	var dialogTop = "200";
	var dialogHeight = "18" ;
	var dialogWidth = "50" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
	var title=encodeURIComponent(getLabel("eBL.REMOVE_BILL_SLMT_DTL.label","BL"));
	//title=encodeURIComponent(title);	
	var arguments = "" ;
	var column_sizes = escape("");               
	var column_descriptions ="";	

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"billslmtamt="+billslmtamt+"&"+"shortdesc="+shortdesc+"&"+"slmttype="+slmttype+"&"+"cash_given="+cash_given+"&"+"cash_return="+cash_return+"&"+"instref="+instref+"&"+"instdate="+instdate+"&"+"creditcardco="+creditcardco+"&"+"instbankname="+instbankname+"&"+"instbranch="+instbranch+"&"+"batchno="+batchno+"&"+"apprrefno="+apprrefno+"&"+"saledraftno="+saledraftno+"&"+"payername="+encodeURIComponent(payername)+"&"+"recrefidno="+recrefidno+"&"+"onlineapproval="+onlineapproval+"&"+"blnggrp="+blnggrp+"&"+"instremarkcode="+instremarkcode+"&"+"action="+action+"&"+"ext_acc_interface_yn="+ext_acc_interface_yn+"&"+"ext_acc_interface_yn="+ext_acc_interface_yn+"&"+query_string;
	retVal=window.showModalDialog("../../eBL/jsp/BLBillSlmtMain2.jsp?"+param,arguments,features);
	var formObj = parent.BillSlmtTypeFrame.document.BillSlmtTypeForm;
		total_records=formObj.total_records.value;
		for(var j=0;j<total_records;j++)
		{
			var temp=eval("formObj.selected_row"+j);
			temp.checked=false;
		}
	
		if(	retVal!=null)
		{
			var ret_val=retVal;
			if(ret_val=="remove")
			{	
					totalRecords =eval(formObj.total_records.value);					parent.frames[2].document.forms[0].action="../../eBL/jsp/BLBillSlmtType.jsp?remove_check=remove&"+"&checked_row="+checked_row+"&total_records="+totalRecords+"&"+query_string;
					parent.frames[2].document.forms[0].submit();
			}
		}
		else
		{
			//alert("closed");
		}
	}
	parent.frames[2].document.forms[0].checked_row.value="";
}*/

function billslmtprocess1()
{
	var v_services_tot_records=parent.frames[1].document.forms[0].total_records.value;
	var rtnArray1="";
	var rtnArray2="";
	var rtnArrayDt="";
	var rtnArrayDocref="";
	var rtnArrayDocrefLine="";
	var rtnArrayDocrefSeq="";
	var rtnBlngServCode="";
	var roundingamt="";
	var rtnUpdNetChrgAmt="";
	var rtnUpdGrossChrgAmt="";
	var rtnPrtGrpLineCode="";
	var rtnPrtGrpHdrCode="";
	var rtnTrxDate="";

	var a1=new Array();
	var a2=new Array();
	var a3=new Array();
	var a4=new Array();
	var a5=new Array();
	var a6=new Array();
	var a7=new Array();
	var a8=new Array();
	var a9=new Array();
	var a10=new Array();
	var a11=new Array();
	var a12=new Array();
	var tot_rec_for_serv_insert=0;
	for(var i=0;i<v_services_tot_records;i++)
	 {				
		
		var v_curr_slmt=eval("parent.frames[1].document.forms[0].curr_set"+i);
		if(v_curr_slmt.value!=0 )
		 {
			tot_rec_for_serv_insert=eval(tot_rec_for_serv_insert)+1;
			a1[i]=v_curr_slmt.value;
			if(a1[i]=="")a1[i]=" ";
			rtnArray1=rtnArray1+a1[i]+"|";
			var v_pend_amt=eval("parent.frames[1].document.forms[0].pend_set"+i);									
			a2[i]=v_pend_amt.value;
			if(a2[i]=="")a2[i]=" ";					
			rtnArray2=rtnArray2+a2[i]+"|";
			var v_service_date=eval("parent.frames[1].document.forms[0].service_date"+i);
			a3[i]=v_service_date.value;
			if(a3[i]=="")a3[i]=" ";					
			rtnArrayDt=rtnArrayDt+a3[i]+"|";
			var v_trx_doc_ref=eval("parent.frames[1].document.forms[0].trx_doc_ref"+i);
			a4[i]=v_trx_doc_ref.value;
			if(a4[i]=="")a4[i]=" ";					
			rtnArrayDocref=rtnArrayDocref+a4[i]+"|";
			var v_trx_doc_ref_line_num=eval("parent.frames[1].document.forms[0].trx_doc_ref_line_num"+i);
			a5[i]=v_trx_doc_ref_line_num.value;
			if(a5[i]=="")a5[i]=" ";					
			rtnArrayDocrefLine=rtnArrayDocrefLine+a5[i]+"|";
			var v_trx_doc_ref_seq_num=eval("parent.frames[1].document.forms[0].trx_doc_ref_seq_num"+i);
			a6[i]=v_trx_doc_ref_seq_num.value;
			if(a6[i]=="")a6[i]=" ";					
			rtnArrayDocrefSeq=rtnArrayDocrefSeq+a6[i]+"|";
			var v_billing_service_code=eval("parent.frames[1].document.forms[0].billing_service"+i);
			a7[i]=v_billing_service_code.value;
			if(a7[i]=="")a7[i]=" ";					
			rtnBlngServCode=rtnBlngServCode+a7[i]+"|";
			var v_trx_date=eval("parent.frames[1].document.forms[0].trx_date"+i);
			a8[i]=v_trx_date.value;
			if(a8[i]=="")a8[i]=" ";					
			rtnTrxDate=rtnTrxDate+a8[i]+"|";
			var v_prt_grp_hdr_code=eval("parent.frames[1].document.forms[0].prt_grp_hdr_code"+i);
			a9[i]=v_prt_grp_hdr_code.value;
			if(a9[i]=="")a9[i]=" ";					
			rtnPrtGrpHdrCode=rtnPrtGrpHdrCode+a9[i]+"|";
			var v_prt_grp_line_code=eval("parent.frames[1].document.forms[0].prt_grp_line_code"+i);
			a10[i]=v_prt_grp_line_code.value;
			if(a10[i]=="")a10[i]=" ";					
			rtnPrtGrpLineCode=rtnPrtGrpLineCode+a10[i]+"|";
			var v_upd_net_charge_amt=eval("parent.frames[1].document.forms[0].upd_net_charge_amt"+i);
			a12[i]=v_upd_net_charge_amt.value;
			if(a12[i]=="")a12[i]=" ";					
			rtnUpdNetChrgAmt=rtnUpdNetChrgAmt+a12[i]+"|";
			var v_upd_gross_charge_amt=eval("parent.frames[1].document.forms[0].upd_gross_charge_amt"+i);
			a11[i]=v_upd_gross_charge_amt.value;
			if(a11[i]=="")a11[i]=" ";					
			rtnUpdGrossChrgAmt=rtnUpdGrossChrgAmt+a11[i]+"|";
		}
	}
		var v_roundingamt = eval("parent.frames[1].document.forms[0].round_off");
		roundingamt = v_roundingamt.value;

	parent.frames[2].document.forms[0].rtnCurrSlmt.value=rtnArray1;

	parent.frames[2].document.forms[0].rtnCurrSlmtBAL.value=rtnArray1;

	parent.frames[2].document.forms[0].rtnPendSlmt.value=rtnArray2;
	parent.frames[2].document.forms[0].rtnArrayDt.value=rtnArrayDt;
	parent.frames[2].document.forms[0].rtnArrayDocref.value=rtnArrayDocref;
	parent.frames[2].document.forms[0].rtnArrayDocrefLine.value=rtnArrayDocrefLine;
	parent.frames[2].document.forms[0].rtnArrayDocrefSeq.value=rtnArrayDocrefSeq;
	parent.frames[2].document.forms[0].services_tot_records.value=v_services_tot_records;		
	parent.frames[2].document.forms[0].rtnBlngServCode.value=rtnBlngServCode;		
	parent.frames[2].document.forms[0].rtnTrxDate.value=rtnTrxDate;		
	parent.frames[2].document.forms[0].rtnPrtGrpHdrCode.value=rtnPrtGrpHdrCode;		
	parent.frames[2].document.forms[0].rtnPrtGrpLineCode.value=rtnPrtGrpLineCode;		
	parent.frames[2].document.forms[0].rtnUpdGrossChrgAmt.value=rtnUpdGrossChrgAmt;		
	parent.frames[2].document.forms[0].rtnUpdNetChrgAmt.value=rtnUpdNetChrgAmt;		

	parent.frames[2].document.forms[0].tot_rec_for_serv_insert.value=tot_rec_for_serv_insert;		


	parent.frames[2].document.forms[0].roundingamt.value=roundingamt;		
	billslmtprocess();
}

function billslmtprocess()
			{
				var v_slmttype		= "";
				var v_cashslmtflag	= "";
				var v_instref		= "";
				var v_instdate		= "";
				var v_instremark	= "";
				var v_slmtidno		= "";
				var v_slmtpayername = "";
				var v_billslmtamt = "";	
				var v_slmtapprrefno = "";

				var v_rectype ="";
				var v_ext_acc_facility_id = "";
				var v_ext_acc_code = "";
				var v_ext_acc_dept = "";
				var v_online_approval = "";
				var v_batch_no = "";
				var v_sale_draft_no = "";
				var v_ext_acc_interface_yn = "";
				var v_ext_acc_fac_id="";
				var v_ext_acc_dept="";
				var v_ext_acc_code="";
				var v_bill_slmt_amtdet="";
				var v_bill_payable_amt="";
				v_total_settled_amt="";
				var strroundingamt="";
				v_bill_slmt_amtdet=parent.frames[0].document.forms[0].billslmtamtdet.value;//new
				v_bill_payable_amt=parent.frames[0].document.forms[0].billpayableamt.value;//new

				//Added by muthu against 33900 on 8/18/2012 
				if(v_bill_payable_amt!=="" && (v_bill_slmt_amtdet=="" || v_bill_slmt_amtdet==0))
				{
					if(v_bill_slmt_amtdet=="" && v_bill_payable_amt!=="")
					{
						alert(getMessage("BL9523","BL"));
						parent.frames[0].document.forms[0].billslmtamtdet.select();
						return false;
					}
					//if(eval(v_bill_slmt_amtdet)==0 && eval(v_bill_payable_amt)==0)//Commented for 33900
					if(eval(parseInt(v_bill_slmt_amtdet))==0 && eval(parseInt(v_bill_payable_amt))==0)
					{	
						alert(getMessage("BL9796","BL"));
						return false;
					}
				}
				//Added by muthu against 33900 on 8/18/2012 

				//if(v_bill_slmt_amtdet > 0 || v_bill_slmt_amtdet == 00.00){//newly added
				if(v_bill_slmt_amtdet != 0){	//Added by muthu against 33900 on 8/18/2012
				v_ext_acc_fac_id=parent.frames[0].document.forms[0].str_ext_acc_facility_id.value;				
				//v_bill_slmt_amtdet=parent.frames[0].document.forms[0].billslmtamtdet.value;
				//v_bill_payable_amt=parent.frames[0].document.forms[0].billpayableamt.value;	
				v_total_settled_amt=document.forms[0].total_settled_amt.value;	
				strroundingamt=parent.frames[0].document.forms[0].strroundingamt.value;	
				parent.frames[0].document.forms[0].pagecloseind.value = "0";
				var v_tot_curr_stlmt=parent.frames[1].document.forms[0].tot_curr_stlmt.value;
				var v_tot_curr_stlmt_no_roundoff=parent.frames[1].document.forms[0].tot_curr_stlmt_no_roundoff.value;//karthik SCF 272	
				var v_net_total=parent.frames[1].document.forms[0].net_total.value;
				var bill_amt = document.forms[0].bill_amt.value;
				//Added by lakshmi
				var rec_print_format_enabled_yn = document.forms[0].rec_print_format_enabled_yn.value;//muthu
				/* Commented by muthu for testing
				if(v_bill_payable_amt!=="" && (v_bill_slmt_amtdet=="" || v_bill_slmt_amtdet==0))
				{
					if(v_bill_slmt_amtdet=="" && v_bill_payable_amt!=="")
					{
						alert(getMessage("BL9523","BL"));
						parent.frames[0].document.forms[0].billslmtamtdet.select();
						return false;
					}
					if(eval(v_bill_slmt_amtdet)==0 && eval(v_bill_payable_amt)==0)
					{	
						alert(getMessage("BL9796","BL"));
						return false;
					}
				}*/
				/*if (parent.frames[2].document.forms[0].onlineapproval.checked)
					v_online_approval = 'Y';				
				
						else
							v_online_approval = 'N';*/
					v_net_total = parseFloat(v_net_total) + parseFloat(strroundingamt);
					if(parseFloat(v_net_total) == parseFloat(v_bill_slmt_amtdet))
					{
						if(parseFloat(v_tot_curr_stlmt) != parseFloat(v_bill_slmt_amtdet))
						{
							v_tot_curr_stlmt = parseFloat(v_tot_curr_stlmt) + parseFloat(strroundingamt);
							
						}
					}
					else{
						v_tot_curr_stlmt=v_tot_curr_stlmt;
					}
				if((v_total_settled_amt!=v_bill_slmt_amtdet) || (v_tot_curr_stlmt!=v_bill_slmt_amtdet))
				{
					if(!(v_bill_slmt_amtdet < 0 &&  v_tot_curr_stlmt == 0 && eval(bill_amt) >= 0))
					{
						/* if(v_tot_curr_stlmt!=v_bill_slmt_amtdet)			Karthik Commented for SCF 272							
						{
							alert(getMessage("BL9621","BL"));
							return false;
						} */
						/* Karthik added below logic for SCF 272 */
						/* The Summed up Settlement value without Round off and the Bill Settlement Value is checked for Negligible difference of 2
						   If difference exceeds 2, then we throw Error*/
						var negligible_difference= parseFloat(v_bill_slmt_amtdet)-parseFloat(v_tot_curr_stlmt_no_roundoff);
						if(Math.abs(negligible_difference)>2){
							alert(getMessage("BL9621","BL"));
							return false;
						}
					}

					if(v_total_settled_amt!=v_bill_slmt_amtdet)
					{
						alert(getMessage("BL9782","BL"));
						return false;
					}
				}
				//if(v_bill_slmt_amtdet!=v_total_settled_amt)
				//{
				//	alert(getMessage("BL7085","BL"));
				//	return false;
				//}

				/*if(v_tot_curr_stlmt!=v_total_settled_amt)
				{
					alert("Total  Amount Should be equal to Settled Amount");
					return false;

				}*/
				var v_ext_acc_interface_yn=parent.frames[0].document.forms[0].ext_acc_interface_yn.value;
				
				if(v_ext_acc_interface_yn== "Y")
				{
					v_rectype = parent.frames[0].document.forms[0].rectype.value;
					v_ext_acc_dept=parent.frames[0].document.forms[0].dept.value;
					v_ext_acc_code=parent.frames[0].document.forms[0].acccode.value;			

				if ( v_rectype == "")
					{					
//						alert("Receipt Type cannot be blank");
						alert(getMessage("BL9524","BL"));
						parent.frames[0].document.forms[0].rectype.focus();
						return false;
					}
				if ( v_ext_acc_code == "")
					{
//						alert("Account code cannot be blank");
						alert(getMessage("BL9525","BL"));
						parent.frames[0].document.forms[0].acccode.focus();
						return false;
					}

					if ( v_ext_acc_dept == "")
					{
					
						//alert("Accounting department cannot be blank");
						alert(getMessage("BL9526","BL"));
						parent.frames[0].document.forms[0].dept.focus();
						return false;
					}

				}

					var genmesg = getMessage("BL9537","BL");

											
//					parent.frames[3].location.href =  '../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>&billpayableamt=<%=strbillpayableamt%>&facilityid=<%=strfacilityid%>&user=<%=struser%>&patientid=<%=strpatientid%>&episodetype=<%=strepisodetype%>&episodeid=<%=strepisodeid%>&visitid=<%=strvisitid%>&slmtamt=<%=strbillpayableamt%>&rectype='+v_rectype+'&ext_acc_code='+v_ext_acc_code+'&ext_acc_dept='+v_ext_acc_dept+'&ext_acc_fac_id='+v_ext_acc_fac_id+'&genmesg='+genmesg;
document.forms[0].ok_button.disabled=true;
parent.frames[2].document.forms[0].target='BillSlmtSubmitFrame';
/*parent.frames[2].document.forms[0].action='../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>&billpayableamt=<%=strbillpayableamt%>&facilityid=<%=strfacilityid%>&loggeduser=<%=struser%>&patientid=<%=strpatientid%>&episodetype=<%=strepisodetype%>&episodeid=<%=strepisodeid%>&visitid=<%=strvisitid%>&encounterid=<%=strencounterid%>&moduleid=<%=strmoduleid%>&slmtamt=<%=strbillpayableamt%>&slmtidno=<%=strslmtidno%>&rectype='+v_rectype+'&ext_acc_code='+v_ext_acc_code+'&ext_acc_dept='+v_ext_acc_dept+'&ext_acc_fac_id='+v_ext_acc_fac_id+'&genmesg='+genmesg+'&bill_slmt_amtdet='+v_bill_slmt_amtdet+"&called_frm="+document.forms[0].called_frm.value+"&alw_co_wit_bl_slmt_yn="+document.forms[0].alw_co_wit_bl_slmt_yn.value+"&cal_frm_multi_bil_slmt="+document.forms[0].cal_frm_multi_bil_slmt.value+"&cash_counter_code="+document.forms[0].cash_counter_code.value;*/
//Added by lakshmi
parent.frames[2].document.forms[0].action='../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>&billpayableamt=<%=strbillpayableamt%>&facilityid=<%=strfacilityid%>&loggeduser=<%=struser%>&patientid=<%=strpatientid%>&episodetype=<%=strepisodetype%>&episodeid=<%=strepisodeid%>&visitid=<%=strvisitid%>&encounterid=<%=strencounterid%>&moduleid=<%=strmoduleid%>&slmtamt=<%=strbillpayableamt%>&slmtidno=<%=strslmtidno%>&rectype='+v_rectype+'&ext_acc_code='+v_ext_acc_code+'&ext_acc_dept='+v_ext_acc_dept+'&rec_print_format_enabled_yn='+rec_print_format_enabled_yn+'&ext_acc_fac_id='+v_ext_acc_fac_id+'&genmesg='+genmesg+'&bill_slmt_amtdet='+v_bill_slmt_amtdet+"&called_frm="+document.forms[0].called_frm.value+"&alw_co_wit_bl_slmt_yn="+document.forms[0].alw_co_wit_bl_slmt_yn.value+"&cal_frm_multi_bil_slmt="+document.forms[0].cal_frm_multi_bil_slmt.value+"&cash_counter_code="+document.forms[0].cash_counter_code.value; 

//"&str_rec_print_format_enabled_yn="+rec_print_format_enabled_yn;

parent.frames[2].document.forms[0].submit();
/*Added by muthu 8/16/2012 against 33900
				if(v_bill_slmt_amtdet == 0.0)
				{
					alert("Testing v_bill_slmt_amtdet by muthu "+v_bill_slmt_amtdet);
					cancel();
				}
Added by muthu 8/16/2012 against 33900*/
				}	//Added by muthu against 33900 on 8/18/2012 Starts here
				else
				{
					cancel();
				}
		//Added by muthu against 33900 on 8/18/2012 Ends here 
}
function cancel()
{
	/*IN038081 Added by Karthik on May-10-2013 to bring in Confirmation window before cancel*/
	var r=confirm("Are you sure you want to Cancel Bill Settlement ?");
	if (r==true)
	{
	var called_frm = document.forms[0].called_frm.value;
	var alw_co_wit_bl_slmt_yn = document.forms[0].alw_co_wit_bl_slmt_yn.value;
	var episode_type = document.forms[0].episode_type.value;
	var cal_frm_multi_bil_slmt = document.forms[0].cal_frm_multi_bil_slmt.value;
	var bill_print_format_enabled_yn = document.forms[0].bill_print_format_enabled_yn.value;
	//var rec_print_format_enabled_yn = document.forms[0].rec_print_format_enabled_yn.value;//muthu

	if(called_frm == "CHECKOUT_VISIT" && alw_co_wit_bl_slmt_yn == "Y" && episode_type == "E" && cal_frm_multi_bil_slmt != "Y")
	{
		alert(getMessage("BL7284","BL"));
		return false;
	}

	if(bill_print_format_enabled_yn == 'Y')
	{
		parent.frames[2].document.forms[0].target='BillSlmtSubmitFrame';
	    parent.frames[2].document.forms[0].action="../../eBL/jsp/BLBillSlmtValidation.jsp?bill_print_format_enabled_yn="+bill_print_format_enabled_yn+"&billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>&called_frm_cancel=Y";
		parent.frames[2].document.forms[0].submit();			
	}
	else
	{
		parent.window.returnValue = "N";
		parent.window.close();
	}
	}
}
/*
function chkForDfltSlmtType()
{
	document.forms[0].add_bill_stlmt_button.click();
}
*/
</script>
			<title>			
			</title>
<!--
<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>
-->
	<%	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>	
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eBL/js/AddModifyPatFinDetails.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	
		</head>

		<body onLoad='tot_setld_amt();' onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<form>
<table cellpadding=3 cellspacing=0  width="100%">	
<tr>
	<td width='25%' class='label'><b><fmt:message key="Common.total.label" bundle="${common_labels}"/></b>
	
	<input type='text' name='total_settled_amt' id='total_settled_amt' size='10' maxlength='25' style='text-align:right' readonly value=''></td>	

	<td class="label" width="25%"></td>
	<td width="25%"  class='labels'>	<input type='button' class='button' onclick='addBillSlmt()' name='add_bill_stlmt_button' id='add_bill_stlmt_button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>" >
	

	<input type='button' class='button' onclick='modifyBillSlmt()' name='modify_serv_button' id='modify_serv_button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")%>" >
	<input type='button' class='button' onclick='removeBillSlmt()' name="remove_button" id="remove_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Remove.label","common_labels")%>" ></td>
	
<%
	//if(!function_id.equals("rcpt_rfnd"))
	/**********added  function_id.equals("PKG_BILLING") for packag billing**************/
	if(!function_id.equals("rcpt_rfnd") && !function_id.equals("PKG_BILLING"))
		{
%>	
	<td width="25%"  class='labels'>
	<input class='button' type="button" name='multiBillSubmit' id='multiBillSubmit' id='multiBillSubmit' value='Submit'>
<%-- 	<INPUT TYPE="button"  class="BUTTON" name='ok_button' id='ok_button' VALUE="    <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>    " onClick='billslmtprocess1()' > --%>
	<input type='button'  name="cancel_button" id="cancel_button" id="cancel_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" class='button'></td>
<%
		}
%>	
		
	</td>
</tr>

</table>
<%
	}catch(Exception e) {System.out.println("btn="+e.toString());}
finally
		{			
			ConnectionManager.returnConnection(con, request);
		}		

%>
<input type= hidden name="query_string" id="query_string"  value="<%=query_string%>">
<INPUT TYPE="HIDDEN" name="blnggrp" id="blnggrp"   SIZE="50" MAXLENGTH="100" 	VALUE='<%=strblnggrpid%>'>		
<INPUT TYPE="HIDDEN" name="billdoctype" id="billdoctype" SIZE="50" MAXLENGTH="100" 	VALUE='<%=strbilldoctypecode%>' >	 	
<INPUT TYPE="HIDDEN" name="billdocnum" id="billdocnum"	   SIZE="20" MAXLENGTH="20" 	VALUE='<%=strbilldocnum%>'> 
<INPUT TYPE="HIDDEN" name="total_amt_payable" id="total_amt_payable"   SIZE="50" MAXLENGTH="100" 	VALUE="<%=strbillpayableamt%>">
<input type='hidden' name='noofdecimal' id='noofdecimal' value='<%=noofdecimal%>' >
<input type='hidden' name='strdfltslmttypecode' id='strdfltslmttypecode' value='<%=strdfltslmttypecode%>' >
<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>' >
<input type='hidden' name='called_frm' id='called_frm' value='<%=called_frm%>' >
<input type='hidden' name='alw_co_wit_bl_slmt_yn' id='alw_co_wit_bl_slmt_yn' value='<%=alw_co_wit_bl_slmt_yn%>' >
<input type='hidden' name='cal_frm_multi_bil_slmt' id='cal_frm_multi_bil_slmt' value='<%=cal_frm_multi_bil_slmt%>' >
<input type='hidden' name='episode_type' id='episode_type' value='<%=strepisodetype%>' >
<input type='hidden' name='cash_counter_code' id='cash_counter_code' value='<%=cash_counter_code%>' >
<input type='hidden' name='bill_amt' id='bill_amt' value='<%=str_bill_amt%>' >
<input type='hidden' name='doc_amt' id='doc_amt' value='<%=doc_amt%>' >
<input type='hidden' name='bill_print_format_enabled_yn' id='bill_print_format_enabled_yn' value='<%=str_bill_print_format_enabled_yn%>' >
<input type='hidden' name='rec_print_format_enabled_yn' id='rec_print_format_enabled_yn' value='<%=str_rec_print_format_enabled_yn%>' >
<input type='hidden' name='strfacilityid' id='strfacilityid' value='<%=strfacilityid%>' >

</form>
</body>
</html>

