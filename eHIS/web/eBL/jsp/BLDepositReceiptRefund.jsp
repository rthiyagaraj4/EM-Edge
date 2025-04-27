<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*,org.apache.commons.codec.binary.Base64" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<!-- 
Sr No        Version          TFS/Incident        SCF/CRF            		    	Developer Name
--------------------------------------------------------------------------------------------------------
1			 V220801			34745		BL-Deposit Receipt/Refund-Encounter	    Mohanapriya
--------------------------------------------------------------------------------------------------------
-->

<script language="javascript" src="../../eBL/js/BLDepositReceipt.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	
<%!private String replaceNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
} %>		


 <%
 	request.setCharacterEncoding("UTF-8");
	Connection con = null;	
	//String locale	= (String)session.getAttribute("LOCALE");
	//HttpSession httpSession = request.getSession(false);
//	Properties p = (Properties)httpSession.getValue("jdbc");			
//	String strclientip ="";

	try{
		
		con	=	ConnectionManager.getConnection(request);
		CallableStatement cstmt=null;

		String str_facility_id	=  (String) session.getValue("facility_id");

		//String patient_id = request.getParameter("patient_id");	 //V220801
		String patient_id ;
		String strencounter_id;
		
		//String strencounter_id = replaceNull(request.getParameter("encounter_id"));	//V220801
		
		if("Y".equals(request.getParameter("encoded")==null?"":request.getParameter("encoded"))){
			patient_id	= new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
			strencounter_id	= new String(Base64.decodeBase64(((String)request.getParameter("encounter_id")).getBytes()));
		}else{
			patient_id	= replaceNull(request.getParameter("patient_id"));
			strencounter_id	= replaceNull(request.getParameter("encounter_id"));
		}//V220801
		System.err.println("strencounter_id "+strencounter_id);
		System.err.println("patient_id "+patient_id);
		String strepisode_id = replaceNull(request.getParameter("episode_id"));	
		int episode_id=0;
		if("".equals(strepisode_id)){
			episode_id=0;
		}		
		else
		{
			try
			{
				episode_id=Integer.parseInt(strepisode_id);	
			}catch(Exception e)
			{
				episode_id=0;
			}
		}
		
		//if(episode_id==null) episode_id="";	
		System.out.println("episodeid deposit rec refund"+episode_id);

		String strVisit_id = replaceNull(request.getParameter("visit_id"));	
		int visit_id=0;
		if("".equals(strVisit_id)){
			visit_id=0;
		}		
		else
		{
			try
			{
				visit_id=Integer.parseInt(strVisit_id);	
			}catch(Exception e)
			{
				visit_id=0;
			}
		}
	
		System.out.println("visit_id"+visit_id);
		
		int encounter_id=0;
		if("".equals(strencounter_id)){
			encounter_id=0;
		}		
		else
		{
			try
			{
				encounter_id=Integer.parseInt(strencounter_id);	
			}catch(Exception e)
			{
				encounter_id=0;
			}
		}
		System.out.println("encounter_id="+encounter_id);

		String currdate="",str_slmt_mode_wise_rcpt_yn="",hand_without_counter_chk_out="";
	/************ADDED FOR PACKAGE BILLING **********************/
	
	
	String function_id = request.getParameter("function_id");	
		if(function_id==null) function_id="";	
		String packseqno = request.getParameter("packseqno");	
		if(packseqno==null) packseqno="";	
	/******************ends package billing*********************/
	String ignoreMandValidation = "N";
	//Added for MMS-DM-SCF-0013
	double totMinDeposit = 0.0;
	 try{
		
		String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from dual";
		PreparedStatement pst2=con.prepareStatement(query_date);
		ResultSet rst2 = pst2.executeQuery();
		if (rst2!=null)
		{
		   if (rst2.next())
		   {
				 currdate = rst2.getString(1);
				
		   		
		   }
		}

		if (rst2 != null)   rst2.close();
		if (pst2 != null)   pst2.close();
	

	}catch(Exception e)
	{
		System.out.println("error in date"+e);
		e.printStackTrace();
	}
	 
	 
	 
	 
//	System.out.println("currdate :" +currdate); 
 try{
//fetchiing HAND_WITHOUT_COUNTER_CHK_OUT for CRF-13
		String sqlst2="select SLMT_MODE_WISE_RCPT_YN,HAND_WITHOUT_COUNTER_CHK_OUT from BL_PARAMETERS where OPERATING_FACILITY_ID = '"+str_facility_id+"'";
		PreparedStatement pst=con.prepareStatement(sqlst2);
		ResultSet rst3 = pst.executeQuery();
		if (rst3!=null)
		{
		   if (rst3.next())
		   {
				 str_slmt_mode_wise_rcpt_yn = rst3.getString(1);
				 hand_without_counter_chk_out = rst3.getString(2);
		   }
		}

		if (rst3 != null)   rst3.close();
		if (pst != null)   pst.close();

//	System.out.println("str_slmt_mode_wise_rcpt_yn dep :"+str_slmt_mode_wise_rcpt_yn);



	}catch(Exception e)
	{
		System.out.println("error in date");
		e.printStackTrace();
	}


 %>
 <script>

function trimString(sInString)
{
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

function cancel()
	{		
		var function_id=parent.frames[1].document.forms[0].function_id.value;
		var deposit_man_yn=parent.frames[1].document.forms[0].deposit_man_yn.value;
		var packseqno=parent.frames[1].document.forms[0].packseqno.value;		
		var pkgCode=parent.frames[1].document.forms[0].pkgCode.value;			
		var min_dep_amt_man   = parent.frames[1].document.forms[0].min_dep_amt_man.value;	
		 var stlmt_amount   = parent.frames[1].document.forms[0].stlmt_amount.value;		 
		 var tot_package_amt   = parent.frames[1].document.forms[0].d_tot_package_amt.value;	
		 var called_from_mode    = parent.frames[1].document.forms[0].funct_mode.value;
		 var total_settled_amt    = parent.frames[3].document.forms[0].total_settled_amt.value;		 	
		 var total_records    = parent.frames[2].document.forms[0].total_records.value;				
		var confirm_check = false;		
		if(function_id=="PKG_BILLING" )//&& deposit_man_yn=="Y")
		{	
			if(total_records>0)
			{
				return false;
			}
			//confirm_check = confirm("Deposit is mandatory, Do you want to Cancel the Subscription");
			//Added Logic for MMS-DM-SCF-0013

			var ignoreMandValidationDtl = parent.frames[1].document.forms[0].ignoreMandValidationDtl.value;
			//This variable is from this page
			var ignoreMandValidation = document.forms[0].ignoreMandValidation.value;
			var minMandAmtFinal = document.forms[0].totMinDeposit.value;
			var minMandAmtDtl = parent.frames[1].document.forms[0].totMinDepositDtl.value;
			var derivedFromDtl = parent.frames[1].document.forms[0].derivedFromDtl.value;
			//In Details page if value is Y then override this page value
			if(derivedFromDtl == 'Y'){
				minMandAmtFinal = minMandAmtDtl;
			}
			
			min_dep_amt_man = parseFloat(min_dep_amt_man) - parseFloat(minMandAmtFinal);
			//Added Logic for MMS-DM-SCF-0013

		if(parseFloat(total_settled_amt)  < parseFloat(min_dep_amt_man)){						
			confirm_check = confirm(getMessage("BL8659","BL"));
			//confirm_check = confirm("Minimum Deposit Collection is mandatory, Do you want to Cancel the Subscription");
			if(confirm_check){				
					var xmlStr ="<root><SEARCH ";
					xmlStr+= "packseqno=\"" + packseqno + "\" " ;					
					xmlStr+= "pkgCode=\"" + pkgCode + "\" " ;					
					xmlStr+= "called_from_mode=\"" + called_from_mode + "\" " ;					
					xmlStr +=" /></root>";
					var temp_jsp="PkgSubscriptionValidation.jsp?func_mode=REM_PKG_SUBS&function_id="+function_id;					
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST",temp_jsp,false);
					xmlHttp.send(xmlDoc);
					var responseText=trimString(xmlHttp.responseText) ;
					//eval(responseText);
					//Added Logic for MMS-DM-SCF-0013
					if(responseText == ""){
						let dialogBody = parent.parent.document.getElementById('dialog-body');
					    dialogBody.contentWindow.returnValue = "C";
					    
					    
						//window.parent.returnValue="C";
					}
					else{
						//window.parent.returnValue="N";
						let dialogBody = parent.parent.document.getElementById('dialog-body');
					    dialogBody.contentWindow.returnValue = "N";
					}
					//Added Logic for MMS-DM-SCF-0013
					
					//parent.window.close();
					const dialogTag = parent.parent.document.getElementById("dialog_tag");    
				    dialogTag.close();
			}else{		
				return false;
			}
		}else{				
			//window.parent.returnValue="Y";
			//parent.window.close();
			let dialogBody = parent.parent.document.getElementById('dialog-body');
		    dialogBody.contentWindow.returnValue = "Y";
		    
		    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		    dialogTag.close();
		}
		}else{	
			if(function_id=="PKG_BILLING" )//&& deposit_man_yn=="N")
			{					
				//window.parent.returnValue="Y";
				let dialogBody = parent.parent.document.getElementById('dialog-body');
			    dialogBody.contentWindow.returnValue = "Y";
			}
			//parent.window.close();
			const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		    dialogTag.close();
		}
		
	}
	function funSubmit()
	
	{
		
			var ref=parent.frames[1].document.forms[0].recpt_refund_ind.value;
		//alert(ref);
		var v_ext_acc_interface_yn=parent.frames[1].document.forms[0].ext_acc_int_YN.value;
		//alert(v_ext_acc_interface_yn);		
	/*	var rec_typ=parent.frames[1].document.forms[0].receipt_type_code.value;
		alert('receipt type:'+rec_typ);
		var ccode=parent.frames[1].document.forms[0].customer_code.value;
		alert('ccode:'+ccode);
		var recnat=parent.frames[1].document.forms[0].receipt_nature_code.value;
		alert('nature:'+recnat);
		var epitype=parent.frames[1].document.forms[0].episode_typ.value;
		alert('episode:'+epitype);
		var remarks=parent.frames[1].document.forms[0].remarks.value;
		alert('remarks:'+remarks);
		var docno=parent.frames[1].document.forms[0].doc_number.value;
		alert('docno:'+docno);
		var amt=parent.frames[1].document.forms[0].stlmt_amount.value;
		alert('amt:'+amt);
		var ref=parent.frames[1].document.forms[0].reference.value;
		alert('ref:'+ref);
		var actcode=parent.frames[1].document.forms[0].ext_acc_code.value;
		alert('actcode:'+actcode);
		var dept=parent.frames[1].document.forms[0].dept_desc.value;
		alert('dept:'+dept);
		var deptype=parent.frames[1].document.forms[0].dep_type.value;
		alert('deptype:'+deptype);
		*/	
			if (parent.frames[1].document.getElementById('DownTimeEntry').checked)
			{
				
				parent.frames[1].document.getElementById('tdentry').value='Y';		
			
						if(parent.frames[1].document.forms[0].doc_type_number.value=="") 
						{
							
							alert(getMessage("BL1514","BL"));
							return;
						}
						if(parent.frames[1].document.forms[0].document_number.value=="")
						{
							alert(getMessage("BL1515","BL"));
							return;
						}
						
						if(parent.frames[1].document.forms[0].deposit_date.value=="")
						{
							alert(getMessage("BL1516","BL"));
							return;
						}
					
						if(parent.frames[1].document.forms[0].deposit_reason.value=="")
						{
							alert(getMessage("BL1517","BL"));
							return;
						}		
		 }
			else
				{
				
				parent.frames[1].document.getElementById('tdentry').value='N';
				
				}
						
		if(parent.frames[1].document.forms[0].receipt_type_code.value=="") 
		{
			
			alert(getMessage("BL9524","BL"));
			return;
		}
		
		
		if(parent.frames[1].document.forms[0].remarks.value=="")
		{
			alert(getMessage("BL1357","BL"));
			return;
		}
	
	
			
		
		
		
		var dep=parent.frames[1].document.forms[0].dep_type.value;
		

		var dep=parent.frames[1].document.forms[0].dep_type.value;
		
			if(parent.frames[1].document.forms[0].dep_type.value=="S"  && parent.frames[1].document.forms[0].reference.value=="")
		{
			alert(getMessage("BL00300","BL"));
			
			return;
		}

		if(parent.frames[1].document.forms[0].dep_type.value=="")
		{
			alert(getMessage("BL7290","BL"));
			return;
		}
		
		
		if (parent.frames[1].document.getElementById("receipt_nature_code").value=="CU")
		{


			if(parent.frames[1].document.forms[0].customer_code.value=="")
			{
				alert(getMessage("BL9102","BL"));
				return;
			}
			
		
		}
	//	alert("397");
		if (parent.frames[1].document.getElementById("cusid").value=="SHALM" || parent.frames[1].document.getElementById("cusid").value=="MOHBR")
		{
//			alert("400");
		var	v_external_acc=parent.frames[1].document.forms[0].ext_acc_code.value;
		var	v_dept_code=parent.frames[1].document.forms[0].dept_desc.value;	
			
			if ( v_external_acc == "")
			{
				alert(getMessage("BL9525","BL"));
				return false;
			}

			if ( v_dept_code == "")
			{
				alert(getMessage("BL9526","BL"));
				return false;
			}
		}
		
		
		if(parent.frames[1].document.forms[0].stlmt_amount.value=="")
		{
			alert(getMessage("BL9523","BL"));
			return;
		}
		
		if(parent.frames[2].document.forms[0].total_records.value==0)
		{
			alert(getMessage("BL6288","BL"));
			return;
		}
		var stlmt_amount = parent.frames[1].document.forms[0].stlmt_amount.value;
		var total_settled_amt = parent.frames[3].document.forms[0].total_settled_amt.value;

		if(parseFloat(stlmt_amount)!= parseFloat(total_settled_amt))
		{
			alert(getMessage("BL9782","BL"));
			return;
		}
		
	
		if(parent.frames[1].document.forms[0].reqcheck.value =="Y" && parent.frames[1].document.forms[0].reqid.value=="") 			
		{		
			alert(getMessage("BL1535","BL"));
			return;
		}
		
		
		
	
/*********************END********************************/
		var splAgnDepChkYN=parent.frames[1].document.forms[0].splAgnDepChkYN.value;
		//alert("splAgnDepChkYN "+splAgnDepChkYN);

		if(splAgnDepChkYN == 'Y'){
			var splAgnEffFromObj=parent.frames[1].document.forms[0].splAgnEffFrom;
			var splAgnEffToObj=parent.frames[1].document.forms[0].splAgnEffTo;
			
			if(splAgnEffFromObj==undefined || splAgnEffToObj==undefined ){
				alert("spl agency details must be entered");
				return;
			}
			else{
				if((splAgnEffFromObj.value =='' || splAgnEffFromObj.value == 'undefined') && (splAgnEffToObj.value =='' || splAgnEffToObj.value == 'undefined')){
					alert("spl agency details must be entered");
					return;
				}
				else{
					parent.frames[2].document.forms[0].splAgnDpstYN.value=parent.frames[1].document.forms[0].splAgnDepChkYN.value;		
					parent.frames[2].document.forms[0].splAgnDepEffFrom.value=splAgnEffFromObj.value;
					parent.frames[2].document.forms[0].splAgnDepEffTo.value=splAgnEffToObj.value;
					//alert("splAgnDepEffFrom "+parent.frames[2].document.forms[0].splAgnDepEffFrom.value);
					//alert("splAgnDepEffTo "+parent.frames[2].document.forms[0].splAgnDepEffTo.value);
					}
			}
			
			
		}
		
		parent.frames[2].document.forms[0].rcpt_rfnd_ind.value=parent.frames[1].document.forms[0].recpt_refund_ind.value;
		//alert('recref:'+parent.frames[2].document.forms[0].rcpt_rfnd_ind.value);
		parent.frames[2].document.forms[0].rcpt_nature_code.value=parent.frames[1].document.forms[0].receipt_nature_code.value;
		//alert('nature:'+parent.frames[2].document.forms[0].rcpt_nature_code.value);
		//	alert(parent.frames[1].document.forms[0].receipt_code.value);	
		parent.frames[2].document.forms[0].rcpt_type_code.value=parent.frames[1].document.forms[0].receipt_type_code.value;	
		//alert('rectype:'+parent.frames[2].document.forms[0].rcpt_type_code.value);
		parent.frames[2].document.forms[0].shift_id.value=parent.frames[1].document.forms[0].shift_id.value;		
		//alert('shift:'+parent.frames[2].document.forms[0].shift_id.value);
		parent.frames[2].document.forms[0].cash_counter_code.value=parent.frames[1].document.forms[0].cash_counter_code.value;
		//alert('cahscounter:'+parent.frames[2].document.forms[0].cash_counter_code.value);
		parent.frames[2].document.forms[0].doc_amt.value =parent.frames[1].document.forms[0].stlmt_amount.value;	
		parent.frames[2].document.forms[0].refnumber.value =parent.frames[1].document.forms[0].reference.value;	
		//alert('refnumber:'+parent.frames[2].document.forms[0].refnumber.value )
		//alert('amt:'+parent.frames[2].document.forms[0].doc_amt.value);
		parent.frames[2].document.forms[0].episode_type.value =parent.frames[1].document.forms[0].episode_type.value;
		//alert('epi:'+parent.frames[2].document.forms[0].episode_type.value);
		parent.frames[2].document.forms[0].episode_id.value=parent.frames[1].document.forms[0].episode_id.value;
	//	alert('episode_id:'+parent.frames[2].document.forms[0].episode_id.value);	
		parent.frames[2].document.forms[0].visit_id.value=parent.frames[1].document.forms[0].visit_id.value;
		//alert('visit:'+parent.frames[2].document.forms[0].visit_id.value);	
		parent.frames[2].document.forms[0].encounter_id.value=parent.frames[1].document.forms[0].encounter_id.value;
		//alert('encounter_id:'+parent.frames[2].document.forms[0].encounter_id.value);	
		parent.frames[2].document.forms[0].customercode.value =parent.frames[1].document.forms[0].customer_code.value;
		//alert('ccode:'+parent.frames[2].document.forms[0].customercode.value);
		parent.frames[2].document.forms[0].narration.value =parent.frames[1].document.forms[0].remarks.value;
		//alert('remarks:'+parent.frames[2].document.forms[0].remark.value);
		parent.frames[2].document.forms[0].origdocnumber.value =parent.frames[1].document.forms[0].doc_number.value;
		//alert('docno:'+parent.frames[2].document.forms[0].origdocnumber.value);
		parent.frames[2].document.forms[0].ref.value =parent.frames[1].document.forms[0].reference.value;
		//alert('ref:'+parent.frames[2].document.forms[0].ref.value);
		parent.frames[2].document.forms[0].totalbill.value =parent.frames[1].document.forms[0].totalbillamt.value;
		//alert('totalamt:'+parent.frames[2].document.forms[0].totalbill.value);
		parent.frames[2].document.forms[0].billpaid.value =parent.frames[1].document.forms[0].billpaidamt.value;
		//alert('billpaid:'+parent.frames[2].document.forms[0].billpaid.value);
		parent.frames[2].document.forms[0].ext_acc_code.value =parent.frames[1].document.forms[0].ext_acc_code.value;
		//alert('actcode:'+parent.frames[2].document.forms[0].ext_acc_code.value);
		parent.frames[2].document.forms[0].ext_acc_dept_code.value =parent.frames[1].document.forms[0].dept_desc.value;
		//alert('dept:'+parent.frames[2].document.forms[0].ext_acc_dept_code.value);
		parent.frames[2].document.forms[0].ip_adm_trf_dep_ind.value=parent.frames[1].document.forms[0].dep_type.value;	
		//alert('deptype:'+parent.frames[2].document.forms[0].ip_adm_trf_dep_ind.value);
		parent.frames[2].document.forms[0].downtime_doc_type_code.value=parent.frames[1].document.forms[0].doc_type_number.value;
		//alert('downtime doc code::'+parent.frames[2].document.forms[0].downtime_doc_type_code.value);
		parent.frames[2].document.forms[0].downtime_doc_num.value=parent.frames[1].document.forms[0].document_number.value;	
		//alert('doc num::'+parent.frames[2].document.forms[0].downtime_doc_num.value);
		parent.frames[2].document.forms[0].downtime_doc_date.value=parent.frames[1].document.forms[0].deposit_date.value;	
		//alert('doc date::'+parent.frames[2].document.forms[0].downtime_doc_date.value);
		parent.frames[2].document.forms[0].downtime_reason_code.value=parent.frames[1].document.forms[0].deposit_reason.value;
		//alert('reason::'+parent.frames[2].document.forms[0].downtime_reason_code.value);
		parent.frames[2].document.forms[0].request_id.value=parent.frames[1].document.forms[0].reqid.value;	
		//alert('request_id::'+parent.frames[2].document.forms[0].request_id.value);
		parent.frames[2].document.forms[0].total_settled_amt.value=parent.frames[3].document.forms[0].total_settled_amt.value;
		//alert('total='+parent.frames[2].document.forms[0].total_settled_amt.value);
		parent.frames[2].document.forms[0].downtime_entry_yn.value=parent.frames[1].document.forms[0].tdentry.value;
		//alert('downtime:'+parent.frames[2].document.forms[0].downtime_entry_yn.value);
		parent.frames[2].document.forms[0].orgdoctype.value=parent.frames[1].document.forms[0].doc_number.value;
		parent.frames[2].document.forms[0].orgdocnumber.value=parent.frames[1].document.forms[0].doc_num.value;
		parent.frames[2].document.forms[0].orgdocsrno.value=parent.frames[1].document.forms[0].documnumber.value;
		
		parent.frames[2].document.forms[0].rec_ref_format_ind.value ="";	
		parent.frames[2].document.forms[0].rfnd_dep_in_use_yn.value	="";

		var t_mail=eval("parent.frames[1].document.forms[0].thru_mail");
		if(t_mail.checked)
		{
			parent.frames[2].document.forms[0].pmnt_thru_mail.value	="Y";
		}
		else{
			parent.frames[2].document.forms[0].pmnt_thru_mail.value	="N";					
		}
		
		
		parent.frames[2].document.forms[0].mult_slmt_yn.value="" ;
		//parent.frames[2].document.forms[0].downtime_entry_yn.value="";
		//parent.frames[2].document.forms[0].downtime_doc_type_code.value="";
		//parent.frames[2].document.forms[0].downtime_doc_num.value="";
		//parent.frames[2].document.forms[0].downtime_doc_date.value="";
		parent.frames[2].document.forms[0].cc_machine_id.value="";
		parent.frames[2].document.forms[0].payers_add1.value="";
		parent.frames[2].document.forms[0].payers_add2.value=""	;
		parent.frames[2].document.forms[0].payers_add3.value="";
		parent.frames[2].document.forms[0].currdate.value="<%=currdate%>";
		parent.frames[2].document.forms[0].str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd.value="<%=str_slmt_mode_wise_rcpt_yn%>";
		parent.frames[2].document.forms[0].hand_without_counter_chk_out.value="<%=hand_without_counter_chk_out%>";
	/*************ADDED FOR PAKAGE BILLING**************************/
		/*if(function_id=="PKG_BILLING"){
		var pkgSeqNo=parent.frames[1].document.forms[0].pkgSeqNo.value			
		parent.frames[2].document.forms[0].pkgSeqNo.value=parent.frames[1].document.forms[0].pkgSeqNo.value;
	}*/
	/*************ENDS**************************/

		parent.frames[2].document.forms[0].payers_tel_num.value	="";
		parent.frames[2].document.forms[0].consolidated_receipt_yn.value="";
		parent.frames[2].document.forms[0].patient_id.value='<%=patient_id%>';	
		/*   $.ajax({ 
               //url:"../../eBL/jsp/BLBillSlmtAllServicesSubmit.jsp?episode_type="+episode_type+"&slmt_amt="+slmt_amt,
               url:"../../servlet/eBL.BLDepositRecRefundServlet,
               type:'post',
               data: $("#BillSlmtTypeForm",window.parent.frames[2].document).serialize(),
               success: function(data) {   
                           //var obj = jQuery.parseJSON(data);
                           var obj =data;
               }
		   });*/
		//document.forms[0].record_button.disabled = true;
		   var episode_type=parent.frames[2].document.forms[0].episode_type.value;
		   var rec_ref=parent.frames[2].document.forms[0].rcpt_rfnd_ind.value;
		   
		   if(rec_ref=="F")
			   {
			   
			   rec_ref="REFUND";
			   }
		   else
			   {
			   rec_ref="RECEIPT";
			   }
		   
		  // alert("episode_type/rec_ref"+episode_type+","+rec_ref);
		    $.ajax({
		        url:"../../eBL/jsp/BLCashCounterReceiptRefundValidation.jsp",
		        type:'post',
		        data: {
		              episodeType:episode_type, // "I","O","D","E"..
		              receiptRefundIndicator:rec_ref  // "REFUND" , "RECEIPT"
		          },
		        success: function(data) {
		           var obj = jQuery.parseJSON(data);
		            
		            if((obj.flag)!='N')
		            	{
								            	
		        		parent.frames[2].document.forms[0].target='submit_frame';
		        		parent.frames[2].document.forms[0].action="../../servlet/eBL.BLDepositRecRefundServlet";
		        		parent.frames[2].document.forms[0].submit();

		            	}
		            //Y - Success  , N ? Failure
		            else{       
		            	
		            	var messageid=obj.messageid;
		            	alert(getMessage(messageid,'BL')); 
		            }
		            
		            
		            
		            }
		            
		        
		});

		   
		   
	
	
/*		parent.frames[2].document.forms[0].target='submit_frame';
		parent.frames[2].document.forms[0].action="../../eBL/jsp/BLEnterReceiptrefundSubmit_temp.jsp";
		parent.frames[2].document.forms[0].submit();*/


	}

 </script>

<HTML>
<HEAD>

		<TITLE> <fmt:message key="eBL.BILL_SLMT_DTL.label" bundle="${bl_labels}"/> </TITLE>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		//Added Logic for MMS-DM-SCF-0013
		try{
			PreparedStatement pstmt = null;
			ResultSet rst = null;
			String packageCode = request.getParameter("pkgCode");
			if(packageCode == null){
				packageCode = "";
			}
			
			if(!"".equals(packseqno)){
				StringTokenizer stPackSeqNo = new StringTokenizer(packseqno,"^");
				
				String stPkg = "";
				String stSeq = "";
				String rsCustGroup = "";
				String rsCustCode = "";
				String rsBlngClass = "";
				String depositReqYn = "";
				String custSpecificYn = "";

				
				StringTokenizer stPackCode = new StringTokenizer(packageCode,"^");
				while(stPackSeqNo.hasMoreTokens()){					
					pstmt = null;
					rst = null;
					stSeq = stPackSeqNo.nextToken();
					stPkg = stPackCode.nextToken();
					pstmt = con.prepareStatement("Select nvl(cust_group_code,'N') cust_group_code, nvl(cust_code,'N') cust_code, blng_class_code,nvl(cust_specific_yn,'N')  cust_specific_yn, nvl(deposit_req_yn,'N') deposit_req_yn from bl_package_sub_hdr where operating_facility_id = ? and patient_id = ? and package_code = ? and package_seq_no = ?");
					pstmt.setString(1, str_facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,stPkg);
					pstmt.setString(4,stSeq);
					rst = pstmt.executeQuery();
					if(rst != null && rst.next()){
						rsCustGroup = rst.getString("cust_group_code");
						rsCustCode = rst.getString("cust_code");
						rsBlngClass = rst.getString("blng_class_code");
						custSpecificYn = rst.getString("cust_specific_yn"); 
						depositReqYn = rst.getString("deposit_req_yn"); 
						if(!"N".equals(rsCustGroup) && !"N".equals(rsCustCode)){
							
							
							if("Y".equals(custSpecificYn)){
								/*
								Code Flow comes here when the given customer definition is
								available in the Package
								*/
								if(!"Y".equals(depositReqYn)){
									ignoreMandValidation = "Y";
								}
							}
							else{
								/*
								Code Flow comes here when the given customer definition is
								unavailable and derived from cash
								*/
								CallableStatement call12 = con.prepareCall("{ call  getpackageMinDeposit(?,?,?,?,?,sysdate,?,?,?,?,?)}");		
								call12.setString(1,str_facility_id);				
								call12.setString(2,stPkg);				
								call12.setString(3,rsBlngClass);				
								call12.setString(4,rsCustGroup);	
								call12.setString(5,rsCustCode);	
								call12.registerOutParameter(6,java.sql.Types.VARCHAR);      		
								call12.registerOutParameter(7,java.sql.Types.VARCHAR); 		
								call12.registerOutParameter(8,java.sql.Types.VARCHAR); 		
								call12.registerOutParameter(9,java.sql.Types.VARCHAR); 		
								call12.registerOutParameter(10,java.sql.Types.VARCHAR); 
							
								call12.execute();				

								String str_min_dep_amt	 = call12.getString(7);	
								
								if ( str_min_dep_amt == null ){
									str_min_dep_amt = "";
								}
								
								if("".equals(str_min_dep_amt)){
									str_min_dep_amt = "0.0";
								}
								
								
								totMinDeposit = totMinDeposit + Double.parseDouble(str_min_dep_amt);
			
								call12.close();	
								ignoreMandValidation = "Y";
							}
						}
					}
				}
			}

			
			if(pstmt != null){
				pstmt.close();
			}
			if(rst != null){
				rst.close();
			}
		}
		catch(Exception e){
			System.err.println("Exception in getting ignoreMandValidation ->"+e);
			ignoreMandValidation = "N";
		}
		//Added Logic for MMS-DM-SCF-0013
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



		<BODY onLoad="" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 					      					  	onSelect="codeArrestThruSelect();">
		<FORM name='' id='' action="" method=''>	

		
	
		<table border='0' cellpadding='2' cellspacing='0'  id='tbl' width='100%'>	
	 <tr>
	 	<td class="label" width="12.5%"><b><fmt:message key="eBL.CASH_COUNTER.label" bundle="${bl_labels}"/>/<fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/></b></td>
	  <td width='25%' class="fields"><input type='text' name='cash_ctr' id='cash_ctr' size='10' maxlength='30	'  value=''  onBlur="">
	   <label><fmt:message key="eBL.DocNoslash.label" bundle="${bl_labels}"/></label>
	  <input type='text' name='shift' id='shift' size='10' maxlength='30	'  value=''  onBlur="">
	  </td>
	  <td class='label' width='30%'></td>
		<td class="label" width="9%"><b><fmt:message key="eBL.PostMthYr.label" bundle="${bl_labels}"/></td>
		 <td width='25%' class="fields"><input type='text' name='postmthyr' id='postmthyr' size='10' maxlength='30	'  value=''  onBlur="">
		  <label><fmt:message key="eBL.DocNoslash.label" bundle="${bl_labels}"/></label>	
		 <input type='text' name='postmonthyr' id='postmonthyr' size='10' maxlength='30'  value=''  onBlur=""></td>
	</tr>
	  	
<tr>		  	
		 <td class="label" width="12.5%"><b><fmt:message key="Common.date.label" bundle="${common_labels}"/></b></td>
		<td width='25%' class="fields"><input type='text' name='doc_date' id='doc_date' size='18' maxlength='30'  value=''  onBlur=""></td>
		<td class='label' width='30%'></td>
		<td width="5%"  class='labels'><INPUT TYPE="button" name='record_button' id='record_button'  class="BUTTON" VALUE="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>" onClick='funSubmit()' ><input type='button'  name="cancel_button" id="cancel_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" class='button' onClick='cancel()'></td>

</tr>
	
	</table>	
	<input type="hidden" name='ignoreMandValidation' id='ignoreMandValidation' id='ignoreMandValidation' value="<%=ignoreMandValidation%>" >
	<input type='hidden' name='totMinDeposit' id='totMinDeposit' id='totMinDeposit' value="<%=totMinDeposit%>" >
	<input type='hidden' name='name' id='name' id='id' value="">
		<input type='hidden' name='checkreq' id='checkreq' id='checkreq' value="">
	
</FORM>	

</BODY>
</HTML>
<%
		}
	catch(Exception e )
	{ 
		System.out.println("BLEnterServiceSerachResult:"+e);
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) {
					ConnectionManager.returnConnection(con, request);
								  }
	}
%>

