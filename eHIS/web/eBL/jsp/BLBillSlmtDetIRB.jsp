<!DOCTYPE html>
<%@page import="eBL.BLReportIdMapper"%>
<%@page import="eBL.BLBillDetailsBean,eBL.BLMultiBillSettlementBean,eBL.Common.*" %>
<%@ page import="java.sql.*, webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>	
<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language='javascript' src='../../eCommon/js/dchk.js'></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script type="text/javascript">
function checkAlpha(event){
	var strCheck = '1234567890';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) return false;  
	return true ;
}

function checkForNumber(obj){
	if(isNaN(obj.value)){
		alert(getMessage('BL8532','BL'));
		obj.select();
	}
	else if(obj.value<0){
		alert(getMessage('BL1209','BL'));
		obj.select();
	}
}

function putDecimal_Text(Obj,maxvalue,deci)
{
	var temp1=$.trim(Obj.text());
	var temp4=temp1.length;
	var count=parseInt(maxvalue) -parseInt(deci);
	if (parseInt(deci) > 0)
	{
		if(temp1.indexOf('.') <0)
		{
			if (temp4 <= parseInt(maxvalue))
			{
				if(temp1.length > (parseInt(maxvalue) -parseInt(deci)) && temp1.length <= maxvalue)
				{
					var temp2=temp1.substring(0,count);
					var temp3=temp2+"."+temp1.substring(count,temp1.length)
					if(temp3.length-1 < parseInt(maxvalue))
					{
						for(var t=0;t <=(parseInt(maxvalue)+1-temp3.length);t++)
						{
							temp3+="0";
						}
					}
					Obj.text(temp3);
				}
				else if(temp1.length <= (parseInt(maxvalue) -parseInt(deci)) && temp1.length <= maxvalue)
				{
					var temp3=temp1+'.';
					for(var m=0;m<deci;m++)
					temp3+="0";
					Obj.text(temp3);
				
				}
				if (temp1.length == 0 )
				{
			 		temp3="0.";
					for(var m=0;m<deci;m++)
					temp3+="0";
					Obj.text(temp3);
	 
				}
   
 
			}

		}else{
			var temp5=temp1.indexOf('.');
			var temp7=temp1.substring(0,temp5);
			var temp6=temp1.substring(temp7.length+1,(temp7.length+parseInt(deci)+1));
			var localTemp='';
			var len=parseInt(deci)-parseInt(temp6.length);
			for(var m=0;m<len;m++){
				localTemp+='0';
			}
			Obj.text(temp7+"."+temp6+localTemp);
	
		}
	}
}

function isValidDateTime(obj){
	if(obj.value!=""){
		var flag=true;
		var RE_NUM =  /^\/?\d+$/;
		var dateTimeObj = obj.value;
		var dateTimeArr = dateTimeObj.split(" ");
		if(dateTimeArr.length != 2)  flag=false;
		var str_date = dateTimeArr[0];
		var str_time = dateTimeArr[1];
		
		if(!(checkDt(str_date))){
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		}
		
		if(!(isValidTime(str_time))){
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		}
	}

	return true;
}

function isValidTime(time1)
{
	if (time1.value != undefined)
	{
		time1 = time1.value;
	}
	else
	{
		time1=time1;
	}
   time1=trimString(time1); 
   var retval=true;
   var strCheck = ':0123456789';
    for(var i=0;i<=time1.length;i++) {
        if (strCheck.indexOf(time1.charAt(i)) == -1){
            retval = false;
            break;
        }
    }			
    if (retval)
    {		
       var time1arr=new Array()
       time1arr=time1.split(":")
            if(time1arr.length==2)
            {
                var time1hr=time1arr[0];
                var time1min=time1arr[1];
                var time1sec = time1arr[2];
				if (time1hr.length != 2 || time1min.length != 2)
				{
					 retval=false;
				}

                time1hr=eval(time1hr)
                time1min=eval(time1min)

                if(time1hr<=23)
                {
                    if(time1min>59)
                    {
                            retval=false;                      
                    }                   
                }
                else
                        retval=false;
            }
            else{						
                retval=false;
			}
        
    }			
    return retval;
}

function cal_error (str_message,obj) {
	alert (str_message);
	obj.focus();
	obj.select();
	return false;
}
function callCommonLookupCode(obj, code, sqlSelect, codeDesc, commonCode) {

	/*parent.frames[1].document.forms[0].stlmt_amount.value='';

	var formObj = document.EnterReceiptRefundForm;*/
	var locale = document.forms[0].locale.value;
	/*var facility_id = formObj.facility_id.value
	var rcptNatcode = formObj.receipt_nature_code.value;
	var recTypCode= formObj.receipt_type_code.value;
	var patient_id = formObj.patient_id.value;
	var acc_entity_code = 'ZZ';
	var recpt_refund_ind = formObj.recpt_refund_ind.value;

	var rcpt_ip_allowed_yn = formObj.rcpt_ip_allowed_yn.value;

	var rcpt_op_allowed_yn = formObj.rcpt_op_allowed_yn.value;

	var rcpt_ref_allowed_yn = formObj.rcpt_ref_allowed_yn.value;

	var rfnd_ip_allowed_yn = formObj.rfnd_ip_allowed_yn.value;

	var rfnd_op_allowed_yn = formObj.rfnd_op_allowed_yn.value;

	var rfnd_ref_allowed_yn = formObj.rfnd_ref_allowed_yn.value;

	var rfnd_allowed_yn = formObj.rfnd_allowed_yn.value;

	var rcpt_allowed_yn = formObj.rcpt_allowed_yn.value;*/


	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql = '';
	var title = '';
	var codeval = '';
	switch (sqlSelect) {

	
	case 2: {
		sql = "Select code,description from (SELECT A.DOC_TYPE_CODE code ,B.SHORT_DESC description FROM BL_TRN_DOC_TYPE A, SY_DOC_TYPE_MASTER_LANG_VW B WHERE A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND   UPPER(LANGUAGE_ID) = UPPER('"
				+ locale
				+ "') AND A.ACC_ENTITY_CODE = 'ZZ' and a.operating_facility_id = '"
				+ facility_id
				+ "'  and ((a.ENTITY_OR_FACILITY_BASED= 'F' and substr(a.doc_type_code,1,2)= '"
				+ facility_id
				+ "' ) or (a.ENTITY_OR_FACILITY_BASED= 'E' and  A.ACC_ENTITY_CODE =  'ZZ')) AND ((A.TRX_TYPE_CODE = '5' AND '"
				+ recpt_refund_ind
				+ "' = 'R' AND ('"
				+ rcpt_op_allowed_yn
				+ "' = 'Y' OR '"
				+ rcpt_ip_allowed_yn
				+ "' = 'Y' OR '"
				+ rcpt_ref_allowed_yn
				+ "'  = 'Y') AND	'"
				+ rcpt_allowed_yn
				+ "' = 'Y') OR (A.TRX_TYPE_CODE = '6' AND '"
				+ recpt_refund_ind
				+ "' = 'F' AND ('"
				+ rfnd_op_allowed_yn
				+ "' = 'Y'  OR '"
				+ rfnd_ip_allowed_yn
				+ "' = 'Y'  OR '"
				+ rfnd_ref_allowed_yn
				+ "' = 'Y') AND '"
				+ rfnd_allowed_yn
				+ "' = 'Y'))) where upper(code) like upper(?)  and upper(description) like upper(?) order by 1";
		title = 'Document No';
		break;

	}
	case 3: {
		sql = "Select code,description from (SELECT DISTINCT a.action_reason_code  Code  , a.action_reason_desc description FROM bl_action_reason_lang_vw a, bl_action_reason_by_type b WHERE a.action_reason_code = b.action_reason_code AND UPPER (language_id) = UPPER ('"
				+ locale
				+ "') AND b.action_type = 'DT'AND NVL (b.active_yn, 'N') = 'Y' )  where upper(code) like upper(?)  and upper(description) like upper(?) order by 2";
		title = 'Reason';
		break;
	}

	
	}

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	if (codeDesc == '1') {
		argumentArray[4] = "1,2";
		argumentArray[5] = code.value;
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = CODE_DESC;
	} else if (codeDesc == '2') {
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = CODE_DESC;
	}
	returnedValues = CommonLookup(title, argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[1];
		code.value = returnedValues[0];
		codeval = code.value;
	} else {
		obj.value = '';
		code.value = '';
	}

	if (sqlSelect == 1) {
		rectypecheck();
		//actcode_dep();
		reqidshow(codeval);
		remark();

	}
	if (sqlSelect == 2) {
		obj.value = '';

	}
	if (sqlSelect == 5) {
		recref();

	}

	if (sqlSelect == 7) {
		
		var check=obj.value;
		check=check.slice(0,-9);
		
		parent.frames[1].document.forms[0].stlmt_amount.value=check;
		parent.frames[1].document.forms[0].reqamount.value=check;
		obj.value='';
	}

		//alert("rcptNatcode / sqlSelect :: "+rcptNatcode +"/"+  sqlSelect);
	 if($('#cusid').val()=="KDAH" || ($('#cusid').val()=="AMS"))
	{
		
	
	
	if(rcptNatcode=='MI'){
	//	alert("check for spl agency");
		
		if(sqlSelect==1)
		{
			//alert("recTypCode="+recTypCode);
			recTypCode=returnedValues[0];
			//alert("recTypCode="+recTypCode);
			$.ajax({
				type:"POST",
				url:"../jsp/SpecialAgenDepCheck.jsp?recTypCode="+recTypCode+"&rcptNatcode="+rcptNatcode,						
				dataType:"text",
				async:false,
				success: function(data){
						//alert("data"+data);
						var dataArr = $.trim(data).split("::"); 
						var splAgnDepChk=dataArr[2];
					//alert("splcheck "+splAgnDepChk);
					if(splAgnDepChk=='Y'){
						
						
						$("#splAgnDep").show();
						document.forms[0].splAgnDepChkYN.value='Y';
						
					}
					else{
						$("#splAgnDep").hide();
						document.forms[0].splAgnDepChkYN.value='N';
					}
					//alert("splAgnDepChkYN  :::::::"+document.forms[0].splAgnDepChkYN.value);
					
				},
				 error: function(data){
					 alert("error:: "+data);
			     }
			});
		
		}
		
	}
			
	if(sqlSelect==5)
	{
		rcptNatcode=code.value;
		if(rcptNatcode != 'MI'){
			
			$("#splAgnDep").hide();
		}
		else if(rcptNatcode=='MI'){
						
				//alert("recTypCode="+recTypCode);
				//alert("rcptNatcode="+rcptNatcode);
				
				$.ajax({
					type:"POST",
					url:"../jsp/SpecialAgenDepCheck.jsp?recTypCode="+recTypCode+"&rcptNatcode="+rcptNatcode,						
					dataType:"text",
					async:false,
					success: function(data){
						//	alert("data"+data);
							var dataArr = $.trim(data).split("::"); 
							var splAgnDepChk=dataArr[2];
					//	alert("splcheck "+splAgnDepChk);
						if(splAgnDepChk=='Y'){
							
							$("#splAgnDep").show();
							document.forms[0].splAgnDepChkYN.value='Y';
							
						}
						else{
							$("#splAgnDep").hide();
							document.forms[0].splAgnDepChkYN.value='N';
						}
					//	alert("splAgnDepChkYN  :::::::"+document.forms[0].splAgnDepChkYN.value);
						
					},
					 error: function(data){
						 alert("error:: "+data);
				     }
				});
			
			}
			
		
	}
		
}
	 
}
function fnClearCode(obj) {
	obj.value = '';
}
</script>
<script type="text/javascript"> 
$(document).ready(function(){

	$('#trDownTypeEntry').hide();
	
	$("#downTimeEntry").change(function(){
		if ($(this).is(":checked"))
		{		
			if(parseFloat($("#billslmtamtdet").val()) < 0){
				$('#doc_type_number').val($('#blRefundType').val());
			}
			else{
				$('#doc_type_number').val($('#blReceiptType').val());
			}
			
			$("#trDownTypeEntry").show();			
		}	
				 
		else
		{
			$("#trDownTypeEntry").hide();
		}
	});	
	
	if(parseFloat($("#billslmtamtdet").val()) < 0){
		$('#blRecRefInd').val('F');
	}
	else{
		$('#blRecRefInd').val('R');
	}
	
	 $("#adjDeposit").click(async function(){ 
		 	/*Commented below lines for #59527 Rajesh V*/
		    /*var adjustmentCheck = window.parent.frames[2].document.forms[0].total_records.value;		   
		    if(adjustmentCheck==0){		*/    	
		    
			var submitBtn = 'Y';
		    var totalAmountSettled = parent.frames[3].document.forms[0].total_settled_amt.value;
		      		
			var billslmtamtdet = $("#billslmtamtdet").val();  

			if(billslmtamtdet<0){
				return false;
			}
			else{
			if(billslmtamtdet == ''){
				alert(getMessage('BL00932','BL'));
		    	return false;
			}
			if((parseFloat(totalAmountSettled) - parseFloat(billslmtamtdet))>0){
				submitBtn = 'N';
				alert(getMessage('BL00933','BL'));
		    	return false;
		    }
		    else if((parseFloat(totalAmountSettled) - parseFloat(billslmtamtdet)) == 0){
		    	submitBtn = 'N';
		    	var opnChk = confirm(getMessage('BL00934','BL'));
		    	if(!opnChk){
		    		return false;
		    	}
		    }			
			billslmtamtdet = parseFloat(billslmtamtdet) - parseFloat(totalAmountSettled);
			var billpayableamt =  $("#billpayableamt").val(); 
			var noofdecimal = document.forms[0].noofdecimal.value;
			var strpatientid =   $("#strpatientid").val(); 
			var dialogUrl       = "../../eBL/jsp/BLBillSlmtServiceDeposit.jsp?submitBtn="+submitBtn+"&billslmtamtdet="+billslmtamtdet+"&patientid="+strpatientid+"&noofdecimal="+noofdecimal;
			var dialogFeatures  ="dialogHeight:" + "49vh" + "; dialogWidth:" + "50vw" +" ; scroll=false; "+"status=no";
			var returnValue = await window.showModalDialog(dialogUrl,null,dialogFeatures);
			
			if(returnValue != undefined){
				var retValArr = returnValue.split(":::");
				var returnVal = parseFloat(totalAmountSettled)+parseFloat(retValArr[0]);
				$('#depAdjAmt').val(retValArr[1]);
				$('#spAdjFrmDep').text(retValArr[1]);
				putDecimal_Text($('#spAdjFrmDep'),17,document.forms[0].noofdecimal.value);
			if(parseFloat(billpayableamt)==parseFloat(returnVal)){
				
				$("#depositAdjustedIndicator").val(false);
				
				if($("#settleByService").val()==true){
				$("#selectServiceList").show();		
				$("#serviceCriteriaDiv").show();
				}
			}else{
				
				$("#depositAdjustedIndicator").val(true);
				
				if($("#settleByService").val()==true){
				$("#selectServiceList").hide();
				$("#serviceCriteriaDiv").hide();
				}
			}

			if(returnValue!='N'){
				$('#slmtAmtAfterDep').val(returnVal);
				$("#billslmtamtdet").val(returnVal);
			putdeci(document.forms[0].billslmtamtdet);
			$("#billslmtamtdet").prop('disabled',true);
			}
			}
			
			}
			
		   /* }else{
		    	alert("Payment Already Processed So Cannot Adjust Deposit")
		    }*/

			
	  });
	 
	 $('#clearDeposit').click(function(){
		 var params = "calledFrom=clearDepositAdjustments";
		 $.ajax({
				type:"GET",
				url:"../jsp/BillReceiptAjax.jsp",
				data:params,
				dataType:"text",
				async:false,
				success: function(data){
					if($('#slmtAlreadyDisabled').val() == 'N'){
						$("#billslmtamtdet").prop('disabled',false);
					}				

					$("#billslmtamtdet").val($("#billpayableamt").val());
					$('#spAdjFrmDep').text(0);
					putDecimal_Text($('#spAdjFrmDep'),17,document.forms[0].noofdecimal.value);
					
				},
				 error: function(data){
					 alert(data)
			     }
		});
	 });
	 
	 $("#billList").click(function(){ 
			var dialogUrl       = "../../eBL/jsp/BLBillSlmtReceiptTypeList.jsp";
			var dialogFeatures  =  "dialogTop:" +"-246px"+";dialogHeight:" + "38vh" + "; dialogWidth:" + "45vw" +" ; scroll=false; "+"status=no";
			var returnVal =window.showModalDialog(dialogUrl,null,dialogFeatures);	
			
	  });
	 
	 
	 $("#svcList").click(async function(){
			var query_string=document.forms[0].query_string.value;
			var slmt_amt_disabled_YN = document.forms[0].slmt_amt_disabled_YN.value;
			var billslmtamtdet = document.forms[0].billslmtamtdet.value;
			var total_settled_amt = parent.frames[3].document.forms[0].total_settled_amt.value;
			var billLevelTax = document.BillSlmtDetForm.billLevelTax.value;	
			var addlChargeAmtForBill = document.BillSlmtDetForm.addlChargeAmtForBill.value;
			var bill_doc_no_selected=$("#bill_doc_no_list  option:selected").text();
			var bill_doc_type_selected=$("#bill_doc_no_list  option:selected").val();
			var dialogUrl       = "../../eBL/jsp/BLBillSlmtServiceListFrame.jsp?"+query_string+"&slmt_amt_disabled_YN="+slmt_amt_disabled_YN+"&billslmtamtdet="+billslmtamtdet+"&total_settled_amt="+total_settled_amt+"&billLevelTax="+billLevelTax+"&addlChargeAmtForBill="+addlChargeAmtForBill+
					"&bill_doc_no_selected="+bill_doc_no_selected+"&bill_doc_type_selected="+bill_doc_type_selected;
			var dialogFeatures  = "dialogHeight:" + "30" + "; dialogWidth:" + "80" +" ; scroll=false; ";
			var returnVal = await window.showModalDialog(dialogUrl,null,dialogFeatures);
			if(returnVal=='SUCCESS'){
				parent.frames[1].location.href ="../../eBL/jsp/BLBillSlmtServiceSelectedList.jsp";
			}
	  });
	 
	  $("#all_service_criteria").change(function(){
			 $.ajax({
				     url:"../../eBL/jsp/BLBillSlmtServiceListStorage.jsp",
				     type:'post',
				     data: {
				   		operation: "ALL_INCLUDE_EXCLUDE", 
				 		all_service_criteria: $("#all_service_criteria").val()
				     },
				     success: function(data) {
				         var obj = jQuery.parseJSON(data);
						 parent.frames[1].location.href ="../../eBL/jsp/BLBillSlmtServiceSelectedList.jsp";
				     }
				 });  
		  }); 
	  
	  $( window ).load(function() {
		  parent.frames[1].location.href ="../../eBL/jsp/BLBillSlmtServiceSelectedList.jsp";
		});
	   
});	

</script>
<%
 	request.setCharacterEncoding("UTF-8");
	String locale	= (String)session.getAttribute("LOCALE");
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");			
	String strclientip ="";
	strclientip=p.getProperty("client_ip_address");	
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; ResultSet rs21 = null; ResultSet rscurr=null;
	String		ext_acc_interface_yn=""; 	String		str_receipt_type_code = "";	String		str_ext_acc_facility_id = "";
	String		str_ext_account_code	= ""; 	String		str_ext_dept_ind = "";	String		str_ext_dept_code     = "";
	String		str_single_service_grp_yn = ""; 	String		str_service_grp		= ""; 	String		str_acc_episode_type= "";
	String		str_acc_category_code	= ""; 	String		str_acc_serv_grp_used_yn	= ""; 	String		str_reln_code		= "";
	String		str_episode_type		= "";	
	String		str_error_text		= ""; 	String      strslmttype		=""; String		strfacilityid	=""; 	
	int noofdecimal=2;  	String strbilldoctypecode=""; 	String strbilldocnum=""; 
	String strbillpayableamt=""; double v_billpayableamt=0; 	  
	String strrectypedesc="";	 	//String stracccode ="";  	
	String stracccodedesc ="";
	String strdeptdesc =""; 	
	int total_records=0;String query_string="";	 
	String slmt_amt_disabled_YN="";	String strdfltcashbillslmtamt = "";String strslmtamt = "";String strchangereceiptamtind = "";
	String strrcptallowedyn = "",strroundingamt="";

	String called_frm="",alw_co_wit_bl_slmt_yn="N";
	String custId = BLReportIdMapper.getCustomerId();
	//KDAH-CRF-0318
	String addlChargeAmtForBill = "";
	String billLevelTax = "N";
	boolean settleByService=false;
	boolean depositAdjustedIndicator=false;

// <!-- Karthik added the Code for Bulk Bill Settlement Details - Starts -->

	String beanId = "BillDetailsBean";
	String beanName = "eBL.BLBillDetailsBean";
	BLBillDetailsBean bean=(BLBillDetailsBean) getBeanObject(beanId, beanName, request);
	HashMap<String, ArrayList<BLBillDetailsBean>> billDtlMap=bean.getBillDtlMap();
	ArrayList<BLBillDetailsBean> billDetailList=billDtlMap.get("REPRINT");
	ArrayList<String> docNumListArray=new ArrayList<String>();
	ArrayList<String> docTypeCodeArray=new ArrayList<String>();
	
	for(BLBillDetailsBean beanObj:billDetailList){
		docNumListArray.add(beanObj.getDocNum());
		docTypeCodeArray.add(beanObj.getDocTypeCode());
	}
	
	String allIncluded="";
	String allExcluded="";
	
	String all_services_included_excluded_slmt = (String) session.getAttribute("all_services_included_excluded_slmt");
	if(all_services_included_excluded_slmt==null){	 
		all_services_included_excluded_slmt ="I";
		session.setAttribute("all_services_included_excluded_slmt",all_services_included_excluded_slmt);
	}
	
	System.out.println("all_services_included_excluded_slmt::::::"+ all_services_included_excluded_slmt);
	if(all_services_included_excluded_slmt.equals("I"))	{
		allIncluded="selected";	
	}else{
		allExcluded="selected";
	}
	
	String partSettled = request.getParameter("partSettled");
	String blReceiptType = "";
	String blRefundType = "";
	String fromBillGen = request.getParameter("fromBillGen");
	if(fromBillGen == null){
		fromBillGen = "";
	}
%>

<HTML>
<HEAD>
<!--	<TITLE> Bill Settlement Details  11 </TITLE> -->
		<TITLE> <fmt:message key="eBL.BILL_SLMT_DTL.label" bundle="${bl_labels}"/> </TITLE>
<!--
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%	
	try
	{
		con	=	ConnectionManager.getConnection(request);
		strfacilityid = request.getParameter("facilityid");	
		if(strfacilityid==null || strfacilityid.equals("")) strfacilityid="";
		String recRefQuery = "select DOWNTIME_RECEIPT_DOC_TYPE, DOWNTIME_REFUND_DOC_TYPE "+
							 "from   BL_PARAMETERS "+
  	    					 "where  OPERATING_FACILITY_ID = ? ";
		pstmt = con.prepareStatement(recRefQuery);
		pstmt.setString(1, strfacilityid);
		rs = pstmt.executeQuery();
		if(rs != null && rs.next()){
			blReceiptType = rs.getString("DOWNTIME_RECEIPT_DOC_TYPE");
			blRefundType = rs.getString("DOWNTIME_REFUND_DOC_TYPE");
		}
		pstmt=null;
		rs=null;
		query_string=request.getQueryString();
		if(query_string==null || query_string.equals("")) query_string="";
//		System.out.println("query_string from det:" + query_string);
		strbilldoctypecode = request.getParameter("billdoctypecode");	
		if(strbilldoctypecode==null || strbilldoctypecode.equals("")) strbilldoctypecode="";
//		System.out.println("strbilldoctypecode req:"+strbilldoctypecode);	
		strbilldocnum = request.getParameter("billdocnum");	
		if(strbilldocnum==null || strbilldocnum.equals("")) strbilldocnum="";
		strbillpayableamt = request.getParameter("billpayableamt");	
		if(strbillpayableamt==null || strbillpayableamt.equals("")) strbillpayableamt="";
		if(!strbillpayableamt.equals(""))
		{
			v_billpayableamt=Double.parseDouble(strbillpayableamt);
		}
		

		String strpatientid  = request.getParameter("patientid");	
		String strepisodetype = request.getParameter("episodetype");
		String strepisodeid = request.getParameter("episodeid");	
		String strvisitid = request.getParameter("visitid");	
		String strslmtpayername = request.getParameter("slmtpayername");
		String struser = request.getParameter("loggeduser");	
		String strslmtidno = request.getParameter("slmtidno");
		String strcashcounter = request.getParameter("cashcounter");
		String strrcptallowedynuser = "";
		String strchangereceiptalloweduser = "";
		//String strchangeyn	= "N";	
		strroundingamt = request.getParameter("strroundingamt");
		if ( strroundingamt == null || strroundingamt.equalsIgnoreCase("null")) 
		{strroundingamt ="";}
//		System.out.println("strroundingamt in DET" + strroundingamt);

		if ( strbilldoctypecode == null || strbilldoctypecode.equalsIgnoreCase("null")) 
		{strbilldoctypecode ="";}
		if ( strbilldocnum == null || strbilldocnum.equalsIgnoreCase("null")) 
		{strbilldocnum = "";}
		if ( strbillpayableamt == null || strbillpayableamt.equalsIgnoreCase("null")) 
		{strbillpayableamt = "";}
		if ( strfacilityid == null || strfacilityid.equalsIgnoreCase("null")) 
		{strfacilityid = "";}
		if ( strpatientid == null || strpatientid.equalsIgnoreCase("null")) 
		{strpatientid = "";}
		if ( strepisodetype == null || strepisodetype.equalsIgnoreCase("null")) 
		{strepisodetype = "";}
		if ( strepisodeid == null || strepisodeid.equalsIgnoreCase("null")) 
		{strepisodeid = "";}
		if ( strvisitid == null || strvisitid.equalsIgnoreCase("null")) strvisitid = "";
		if ( strslmtpayername == null || strslmtpayername.equalsIgnoreCase("null"))  
		{strslmtpayername = "";}
		if ( strslmtidno == null || strslmtidno.equalsIgnoreCase("null")) strslmtidno = "";
		if ( struser == null || struser.equalsIgnoreCase("null")) struser = "";
		if ( strcashcounter == null || strcashcounter.equalsIgnoreCase("null")) 
		strcashcounter ="";

		called_frm = request.getParameter("called_frm");
		if(called_frm == null) called_frm="";

		alw_co_wit_bl_slmt_yn = request.getParameter("alw_co_wit_bl_slmt_yn");
		if(alw_co_wit_bl_slmt_yn == null) alw_co_wit_bl_slmt_yn="N";

		strdfltcashbillslmtamt = request.getParameter("dfltcashbillslmtamt");
		if ( strdfltcashbillslmtamt == null || strdfltcashbillslmtamt.equalsIgnoreCase("null")) 
			strdfltcashbillslmtamt = "N";
		ext_acc_interface_yn = request.getParameter("ext_acc_interface_yn");
		if(ext_acc_interface_yn == null || ext_acc_interface_yn.equalsIgnoreCase("null")) ext_acc_interface_yn="N";
		
		addlChargeAmtForBill = request.getParameter("addl_charge_amt");
		if(addlChargeAmtForBill == null || "null".equals(addlChargeAmtForBill)){
			addlChargeAmtForBill = "";
		}
		
		
 	  try{
			pstmt = con.prepareStatement("select DONT_SETTLE_BY_SERV_YN from bl_parameters where  OPERATING_FACILITY_ID = ? "); //OPERATING_FACILITY_ID Added for MMS-ME-SCF-0015 on 19-Aug-20 by Shikha
			pstmt.setString(1,strfacilityid);
			rs = pstmt.executeQuery();					
			if(rs != null && rs.next()){
				String dontSettleByService = rs.getString(1);
				if(dontSettleByService==null || dontSettleByService.equals("N")){
				settleByService=true;
				}
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		try
		{		
		
			pstmt = con.prepareStatement("select decode(sign(?),'1', decode('E','O',nvl(op_applicable_ind,'N'),'E',nvl(op_applicable_ind,'N'),'R', nvl(REF_APPLICABLE_IND,'N')) ,'-1',decode('E','O',nvl(OP_REFUND_IND,'N'),'E',nvl(OP_REFUND_IND,'N'),'R', nvl(REF_REFUND_IND,'N')) ) op_ref_applicable,decode(sign(?),'1',nvl(change_receipt_amt_ind,'N'),'-1',nvl(CHANGE_REFUND_AMT_IND,'N')) op_ref_changea_amt_ind from  bl_cash_counter where cash_counter_code = ?  and operating_facility_id = ? ");
			
			pstmt.setString(1,strbillpayableamt);
			pstmt.setString(2,strbillpayableamt);
			pstmt.setString(3,strcashcounter);
			pstmt.setString(4,strfacilityid);			

			rs = pstmt.executeQuery();	
			if ( rs.next() && rs != null ) 
			{
				strrcptallowedyn =  rs.getString(1);			
				strchangereceiptamtind =  rs.getString(2);			
			}
			else
			{
				strrcptallowedyn = "N";
				strchangereceiptamtind = "N";
			}		
			
			pstmt = null;
			rs = null;
			pstmt = con.prepareStatement("Select NVL(Bill_level_tax_yn,'N') Bill_level_tax_yn from bl_parameters");
			rs = pstmt.executeQuery();	
			if(rs != null && rs.next()){
				billLevelTax = rs.getString("Bill_level_tax_yn");
			}
			
			rs.close();
		pstmt.close();
		strrcptallowedyn="Y";
		strchangereceiptamtind="Y";
		}
		
		catch(Exception e) 
		{    e.printStackTrace();
			System.out.println("Exception in bl_cash_counter query:"+e);
		}
		
		if ( strrcptallowedyn == null || strrcptallowedyn.equalsIgnoreCase("null")) 
			strrcptallowedyn = "N";
		if (strchangereceiptamtind == null || strchangereceiptamtind.equalsIgnoreCase("null")) 
		    strchangereceiptamtind = "N";

		try	
		{		
			//pstmt = con.prepareStatement("select nvl(receipt_auth_yn,'N'), nvl(change_receipt_allowed_yn,'N') from bl_users_for_credit_auth where operating_facility_id = '" + strfacilityid + "' and credit_auth_user_id = '" + struser + "'");
			pstmt = con.prepareStatement("select decode(sign(?),'1',nvl(receipt_auth_yn,'N'),'-1',nvl(REFUND_AUTH_YN,'N')) receipt_refund_auth_yn, decode(sign(?),'1',nvl(change_receipt_allowed_yn,'N'),'-1',nvl(CHANGE_REFUND_ALLOWED_YN,'N')) rec_ref_change_allowed_yn from bl_users_for_credit_auth where operating_facility_id = ? and credit_auth_user_id = ? ");
			
			pstmt.setString(1,strbillpayableamt);
			pstmt.setString(2,strbillpayableamt);
			pstmt.setString(3,strfacilityid);
			pstmt.setString(4,struser);			
			rs = pstmt.executeQuery();	
			if ( rs.next() && rs != null ) 
			{
				strrcptallowedynuser =  rs.getString(1);				
				strchangereceiptalloweduser =  rs.getString(2);						
			}
			else
			{
				strrcptallowedynuser = "N";
				strchangereceiptalloweduser = "N";
			}
			rs.close();
			pstmt.close();
		}		
		catch(Exception e) 
		{    e.printStackTrace();
			System.out.println("Exception in bl_users_for_credit_auth query:"+e);
		}

		if (strrcptallowedynuser == null || strrcptallowedynuser.equalsIgnoreCase("null")) 
			strrcptallowedynuser = "N";
		if (strchangereceiptalloweduser == null || strchangereceiptalloweduser.equalsIgnoreCase("null")) 
		    strchangereceiptalloweduser = "N";	

		if(strrcptallowedyn.equals("Y") && strrcptallowedynuser.equals("Y"))
		{
			if(strdfltcashbillslmtamt.equals("Y"))
			{
				strslmtamt = strbillpayableamt;
			}

			if(strchangereceiptalloweduser.equals("Y") && strchangereceiptamtind.equals("Y"))
			{
				slmt_amt_disabled_YN="N";
			}
			else
			{
				//slmt_amt_disabled_YN="Y";
				//This Field makes the Settlement Amount Disabled. By Removing this Validation, it will be enabled always
				slmt_amt_disabled_YN="N"; // Quick Fix to make Similar to 2 Tier Application
			}
		}

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
			{    e.printStackTrace();
				System.out.println("3="+e.toString());
			}

%>

	
	<script>		
			function ChkNumberInput1(fld, e, deci,sn)
			{
				var strCheck ="";
				if(document.forms[0].billpayableamt.value < 0)
				{
					if (parseInt(deci)>0)
						strCheck = '-.0123456789';
					else
						strCheck = '-0123456789';	
				}
				else
				{
					if (parseInt(deci)>0)
						strCheck = '.0123456789';
					else
						strCheck = '0123456789';	
				}
				var whichCode = (window.Event) ? e.which : e.keyCode;
				if (whichCode == 13) return true;  // Enter
				
				key = String.fromCharCode(whichCode);  // Get key value from key code

				if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
				if(key == "." && fld.value.indexOf(key) != -1) return false; // Not more than one '.' char
				if(key == "-" && fld.value.indexOf(key) != -1) return false; // Not more than one '-' char
			}

	function putdeci(object)
	{		
		
		if(object.value!='')
		{
		var decimal=document.forms[0].noofdecimal.value;
		putDecimal(object,17,decimal);
		}
		
		
	}

function funServiceDet()
{
	
	var query_string=document.forms[0].query_string.value;
	var amt_sett=document.forms[0].billslmtamtdet.value;
	var pay_amt=document.forms[0].billpayableamt.value;
	var remOutStndAmt = parseFloat(pay_amt)-parseFloat(amt_sett);
	var custId = document.forms[0].custId.value;
	var sett_amt=parent.frames[3].document.forms[0].total_settled_amt.value;		
//	var slmt_amt_disabled_YN = parent.frames[3].document.forms[0].slmt_amt_disabled_YN.value;
		var slmt_amt_disabled_YN = document.forms[0].slmt_amt_disabled_YN.value;
	if(pay_amt < 0)
	{
		var temp=amt_sett.indexOf('-');
		if(temp != -1 ) 
		{
			if(temp != 0 ) 
			{				
				alert(getMessage("INVALID_NUMBER_FORMAT","common"));
				document.forms[0].billslmtamtdet.select();
				return false;
			}
		}
	}
	
	if(pay_amt>0 && amt_sett<0)
	{
		alert(getMessage("BL9863","BL"));
		document.forms[0].billslmtamtdet.select();	
		return false;
	}
	if(pay_amt<0 && amt_sett>0)
	{
		alert(getMessage("BL9863","BL"));
		document.forms[0].billslmtamtdet.select();	
		return false;
	}
		
		if(amt_sett!="")
		{
			if(sett_amt!=0)
			{
				if(parseFloat(amt_sett)<parseFloat(sett_amt) || parseFloat(amt_sett)>parseFloat(sett_amt))
				{
					 alert(getMessage("BL9782","BL"));
//					 document.forms[0].billslmtamtdet.select();
//					 return false;
				}
			}
		
			var out_standing_amt=document.forms[0].billpayableamt.value;
			if(amt_sett<0)
			{				
			
			//if(parseFloat(amt_sett)>parseFloat(out_standing_amt))
			if(parseFloat(out_standing_amt)>parseFloat(amt_sett))

			{			
				alert(getMessage("BL7085","BL"));
				document.forms[0].billslmtamtdet.select();
				return false;
			}
			var slmtAmtAfterDep = $('#slmtAmtAfterDep').val();

			if(slmtAmtAfterDep != '' && parseFloat(amt_sett)>parseFloat(slmtAmtAfterDep))

			{			
				alert(getMessage('BL00935','BL'));
				//document.forms[0].billslmtamtdet.select();
				//return false;
			}
			
			}
			else
			if(amt_sett>0)
			{
			
			if(parseFloat(amt_sett)>parseFloat(out_standing_amt))

			{			
				alert(getMessage("BL7085","BL"));
				document.forms[0].billslmtamtdet.select();
				return false;
			}
			var slmtAmtAfterDep = $('#slmtAmtAfterDep').val();

			if(slmtAmtAfterDep != '' && parseFloat(amt_sett)>parseFloat(slmtAmtAfterDep))

			{			
				alert(getMessage('BL00935','BL'));
				//document.forms[0].billslmtamtdet.select();
				//return false;
			}
			}
		}
				if(custId == 'MOHBR'){	
					if(amt_sett!=''){
							var remamt = document.forms[0].remOutStndAmt.value;
							var ttamt="0.0";
							 if(remamt!='' )
								  {
								 var blamtt = document.forms[0].billslmtamtdet.value;
								 var ttamt = parseFloat(blamtt) + parseFloat(remamt);						 
								  }
						if(parseFloat(pay_amt)>0){
							if(parseFloat(ttamt) !=  parseFloat(pay_amt) && parseFloat(amt_sett)<parseFloat(pay_amt)){
								var resp = confirm("Partial settlement being processed \n  Do you want to continue? ");
								if(resp == true){
									document.forms[0].remOutStndAmt.value = remOutStndAmt;
									putdeci(document.forms[0].remOutStndAmt);
								}
								else{
									document.forms[0].billslmtamtdet.value = pay_amt;
									putdeci(document.forms[0].billslmtamtdet);
									document.forms[0].remOutStndAmt.value = '0.0';
									document.forms[0].billslmtamtdet.select();
									return false;
								}															
							}
							else{
								document.forms[0].remOutStndAmt.value = remOutStndAmt;
								putdeci(document.forms[0].remOutStndAmt)
							}	
						}
						else{
							if(parseFloat(ttamt) !=  parseFloat(pay_amt) && parseFloat(pay_amt)<parseFloat(amt_sett)){							
								document.forms[0].billslmtamtdet.value = pay_amt;
								putdeci(document.forms[0].billslmtamtdet);
								document.forms[0].remOutStndAmt.value = '0.0';
								document.forms[0].billslmtamtdet.select();
								return false;																
							}
							else{
								document.forms[0].remOutStndAmt.value = remOutStndAmt;
								putdeci(document.forms[0].remOutStndAmt)
							}	
						}
						
					}
					else{
						document.forms[0].remOutStndAmt.value = '';
					}
									
				}
		document.forms[0].service_check.value='Y';
}

function funServiceDet_onLoad()
{
	var query_string=document.forms[0].query_string.value;
	var slmt_amt_disabled_YN = document.forms[0].slmt_amt_disabled_YN.value;
	var amt_sett=document.forms[0].billslmtamtdet.value;
//		var sett_amt=parent.frames[3].document.forms[0].total_settled_amt.value;	
		
		if(amt_sett!="")
		{
		var out_standing_amt=document.forms[0].billpayableamt.value;
		if(parseFloat(amt_sett)>parseFloat(out_standing_amt))
		{			
			alert(getMessage("BL7085","BL"));
			 document.forms[0].billslmtamtdet.select();
			 return false;

		}
		}
	document.forms[0].service_check.value='Y';

}






function rectypelkup()
		{
		var msg="";
		var target				= document.forms[0].rectype;
		var retVal				= new String();
		var dialogTop			= "40";
		var dialogHeight		= "40" ;
		var dialogWidth			= "40" ;
		var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var sql					= "";
		var search_desc			= "";
		var tit					= "";
		//Below line (v_facility_id) is added by muthu against IN:032615 on 10-5-12
		var v_facility_id =document.forms[0].strfacilityid.value;// '<%=strfacilityid%>';
		
		var v_ext_acc_interface_yn = document.forms[0].ext_acc_interface_yn.value;//'<%=ext_acc_interface_yn%>';
		var	v_single_serv_grp = document.forms[0].str_single_service_grp_yn.value;//'<%=str_single_service_grp_yn%>';		
		var v_acc_episode_type = document.forms[0].str_acc_episode_type.value;//'<%=str_acc_episode_type%>';	
		var v_acc_catg_code = document.forms[0].str_acc_category_code.value;//'<%=str_acc_category_code%>';		
		var v_acc_serv_grp_used_yn = document.forms[0].str_acc_serv_grp_used_yn.value;//'<%=str_acc_serv_grp_used_yn%>';		
		var v_serv_grp = document.forms[0].str_service_grp.value;//'<%=str_service_grp%>';		
		var v_episode_type =document.forms[0].str_episode_type.value;// '<%=str_episode_type%>';		
		var v_reln_code =document.forms[0].str_reln_code.value;//'<%=str_reln_code%>';
		

		var locale = document.forms[0].locale.value;
		

// PE Changes			

		sql = "select receipt_type_code, long_desc from bl_receipt_type_lang_vw where language_id=`"+locale+"` and ACC_ENTITY_CODE in (Select acc_entity_id from SM_ACC_ENTITY_PARAM_FACL where facility_id=`"+v_facility_id+"`) and recpt_nature_code = `BI` and status is null and (( `"+v_ext_acc_interface_yn+"` = `Y` and  receipt_type_code in ( select receipt_type_code from bl_rev_acct_by_receipt_type where rcpt_nature_code = `BI` and status is null and ((`"+v_single_serv_grp+"`=`Y` and episode_type in (`"+v_acc_episode_type+"`,`U`) and category in (`UNRESTRICTED`,`"+v_acc_catg_code+"`) and ((`"+v_acc_serv_grp_used_yn+"` = `Y` and blng_serv_grp = `"+v_serv_grp+"`) or (`"+v_acc_serv_grp_used_yn+"` = `N` and  blng_serv_grp is null ))) or (`"+v_single_serv_grp+"`=`N` and episode_type in (`U`,`"+v_episode_type+"`) and category IN ( `"+v_reln_code+"`,`UNRESTRICTED`) and blng_serv_grp is null )))) or `"+v_ext_acc_interface_yn+"` = `N`)";			

		search_code="receipt_type_code";
		search_desc="long_desc";
		tit=encodeURIComponent(getLabel("eBL.RECEIPT_TYPE.label","BL"));
		retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
	
		var arr=new Array();
		if (!(retVal == null))
		{
  		    var retVal=unescape(retVal);
			arr=retVal.split("::");
		
			document.forms[0].rectypedesc.value=arr[0];
		    document.forms[0].rectype.value=arr[1];
			
			document.forms[0].acccode.value='';
			document.forms[0].acccodedesc.value='';

			document.forms[0].dept.value='';
			document.forms[0].deptdesc.value='';

		}
		else
		{		
		
			document.forms[0].rectypedesc.value='';
			document.forms[0].rectype.value = '';						

			document.forms[0].acccode.value='';
			document.forms[0].acccodedesc.value='';

			document.forms[0].dept.value='';
			document.forms[0].deptdesc.value='';

			target.focus();
		}
	

	}

function acccodelkup()
		{
		var msg="";
		var target				= document.forms[0].acccode;
		var retVal				= new String();
		var dialogTop			= "40";
		var dialogHeight		= "40" ;
		var dialogWidth			= "40" ;
		var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var sql					= "";
		var search_desc			= "";
		var tit					= "";
		
		var v_ext_acc_interface_yn = document.forms[0].ext_acc_interface_yn.value;//'<%=ext_acc_interface_yn%>';
		var	v_single_serv_grp = document.forms[0].str_single_service_grp_yn.value;//'<%=str_single_service_grp_yn%>';		
		var v_acc_episode_type = document.forms[0].str_acc_episode_type.value;//'<%=str_acc_episode_type%>';
		var v_acc_catg_code = document.forms[0].str_acc_category_code.value;//'<%=str_acc_category_code%>';		
		var v_acc_serv_grp_used_yn = document.forms[0].str_acc_serv_grp_used_yn.value;//'<%=str_acc_serv_grp_used_yn%>';		
		var v_serv_grp = document.forms[0].str_service_grp.value;//'<%=str_service_grp%>';		
		var v_episode_type =document.forms[0].str_episode_type.value;// '<%=str_episode_type%>';		
		var v_reln_code =document.forms[0].str_reln_code.value;//'<%=str_reln_code%>';		
		var v_rec_type = document.forms[0].rectype.value;		
		var locale = document.forms[0].locale.value;

	sql = "select account_code,long_desc from (select a.account_code, b.long_desc , decode(a.episode_type, `"+v_acc_episode_type+"`,`1`,`999`) order1, decode(a.category,`"+v_acc_catg_code+"`	,1,999) order2 from bl_rev_acct_by_receipt_type a,bl_receipt_type_lang_vw b where b.language_id=`"+locale+"` and  a.rcpt_nature_code = b.recpt_nature_code and a.receipt_type_code = b.receipt_type_code and a.acc_entity_code = b.acc_entity_code and b.recpt_nature_code = `BI` and  a.rcpt_nature_code = `BI` and a.receipt_type_code = `"+v_rec_type+"` and a.status is null and a.episode_type in (`U`, `"+v_acc_episode_type+"`) and a.category in(`UNRESTRICTED`,`"+v_acc_catg_code+"`) order by 3,4 ) where rownum=1";

			search_code="account_code"; 
			search_desc="long_desc";
			
		tit=encodeURIComponent(getLabel("eBL.ACCOUNT_CODE.label","BL"));
		retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
	
		var arr=new Array();

		if (!(retVal == null))
		{
  		    var retVal=unescape(retVal);
			arr=retVal.split("::");
		
			document.forms[0].acccodedesc.value=arr[0];
		    document.forms[0].acccode.value=arr[1];
			document.forms[0].acccode.focus();				
			
		}
		else
		{		
		
			document.forms[0].acccodedesc.value='';
			document.forms[0].acccode.value = '';									

			target.focus();
		}
	}
	function deptlkup()
	{
		var msg="";
		var target				= document.forms[0].dept;
		var retVal				= new String();
		var dialogTop			= "40";
		var dialogHeight		= "40" ;
		var dialogWidth			= "40" ;
		var features	= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "" ;
		var sql					= "";
		var search_desc			= "";
		var tit					= "";		
		var v_dept_code =document.forms[0].str_ext_dept_code.value;//'<%=str_ext_dept_code%>';
		var v_facility_id =document.forms[0].strfacilityid.value;// '<%=strfacilityid%>';
		var locale = document.forms[0].locale.value;		
		sql = "	select dept_code, long_desc from am_dept_lang_vw where language_id=`"+locale+"` and dept_code like nvl(`"+v_dept_code+"`,dept_code )";
		search_code="dept_code";
		search_desc="long_desc";
		tit=encodeURIComponent(getLabel("eBL.ACCOUNTING_DEPT.label","BL"));
		retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
	
		var arr=new Array();
		if (!(retVal == null))
		{
  		    var retVal=unescape(retVal);
			arr=retVal.split("::");		
			document.forms[0].deptdesc.value=arr[0];
		    document.forms[0].dept.value=arr[1];
			document.forms[0].dept.focus();		
		}
		else
		{				
			document.forms[0].deptdesc.value='';
			document.forms[0].dept.value = '';						
			target.focus();
		}
	

	}	
function funCurStlmt()
{ 
	var total_records=document.forms[0].total_records.value;
	var v_tot_curr_stlmt=document.forms[0].tot_curr_stlmt.value;

		for(var j=0;j<total_records;j++)
	{
		var pend_amt=eval("document.forms[0].pend_set"+j);
		var curr_set=eval("document.forms[0].curr_set"+j);
		if(curr_set.value=="")
		{
			curr_set.value=0.00;
			putdeci(curr_set);
			//curr_set.focus();
			curr_set.select();
			return false;
		}


		if ( parseFloat(curr_set.value) > parseFloat(pend_amt.value))
		{
			 alert(getMessage("BL9658","BL"));
   			curr_set.select();
		}
		totCurrSlmt();
		
		
	
	if(parseFloat(curr_set.value) >parseFloat(v_tot_curr_stlmt))
		{
			alert(getMessage("BL9621","BL"));
			curr_set.value=0.00;
			putdeci(curr_set);
			//curr_set.focus();
			curr_set.select();
			return false;
		}
	}
}

function funCurrMultSlmt()
		{
	      var s_amt=document.forms[0].billslmtamtdet.value;		  
		  var total_records=document.forms[0].total_records.value;	
		  if(total_records>0)
			{
		  for(var j=0;j<total_records;j++)
			{
			  var pend_amt=eval("document.forms[0].pend_set"+j);			  
			  var v_pend_amt=pend_amt.value;
			  var curr_set=eval("document.forms[0].curr_set"+j);
			  if(parseFloat(s_amt)> parseFloat(pend_amt.value))
				{				  		 
				  curr_set.value=v_pend_amt;				  
				  putdeci(curr_set);
				}
				else{					
					if(parseFloat(s_amt)>0)
					{					 
					 curr_set.value=s_amt;
					 putdeci(curr_set);
					}
					else{curr_set.value=0;
					putdeci(curr_set);
						}

				 }
				s_amt=parseFloat(s_amt)-parseFloat(v_pend_amt);					

			totCurrSlmt();
			}
			}
		}

	function totCurrSlmt()
		{
			var tot_curr_set=0.0;
			var v_curr_set="";
			var a1=new Array();
			var s_amt=document.forms[0].billslmtamtdet.value;
			var total_records=document.forms[0].total_records.value;		  
			for(var j=0;j<total_records;j++)
			{
				v_curr_set=eval("document.forms[0].curr_set"+j);
				a1[j]=v_curr_set.value;
				 if(a1[j]==""){a1[j]="0.0";}
				tot_curr_set=parseFloat(tot_curr_set) + parseFloat(a1[j]);
				
			}
			document.forms[0].tot_curr_stlmt.value=tot_curr_set;
			var total_curr_stlmt=eval("document.forms[0].tot_curr_stlmt");
			putdeci(total_curr_stlmt);
			
		}

	function slmt_amt_disabled_YN()
	{
		/*var alw_co_wit_bl_slmt_yn=document.forms[0].alw_co_wit_bl_slmt_yn.value;
		var called_frm=document.forms[0].called_frm.value;
		var str_episode_type=document.forms[0].episode_type.value;
		var slmt_amt_disabled_YN=document.forms[0].slmt_amt_disabled_YN.value;

		if(alw_co_wit_bl_slmt_yn == "Y" && called_frm=="CHECKOUT_VISIT" && str_episode_type == "E")
		{
			document.forms[0].billslmtamtdet.disabled=true;
		}
		else
		{
			if(slmt_amt_disabled_YN=="Y")
			{
				document.forms[0].billslmtamtdet.disabled=true;
			}
			else
			{
				document.forms[0].billslmtamtdet.disabled=false;
			}
			
			//The below If Condition makes the Settlement Column disabled, when user is settling partially
			if($('#partSettled').val()=='Y'){
				document.forms[0].billslmtamtdet.disabled=true;
			}
		}*/
		if($('#fromBillGen').val() == 'Y'){
			document.forms[0].billslmtamtdet.disabled=false;
		}
		else{
			document.forms[0].billslmtamtdet.disabled=true;
		}
		
		
		if($('#billslmtamtdet').prop('disabled') == true){
			$('#slmtAlreadyDisabled').val('Y');
		}
		else{
			$('#slmtAlreadyDisabled').val('N');
		}
	}
	
	//Added for KDAH-CRF-0318
	function fnDispBillTaxDesc(){
		var billLevelTax = document.BillSlmtDetForm.billLevelTax.value;
		var addlChargeAmt = document.BillSlmtDetForm.addlChargeAmtForBill.value;
		if(addlChargeAmt == ''){
			addlChargeAmt = 0;
		}
		if(billLevelTax == 'Y' && addlChargeAmt > 0){
			document.getElementById('billLevelTaxDesc').innerText = '(Including Bill level Tax)';
			document.getElementById('billLevelTaxDesc').style.display = 'inline';			
		}
	}
	</script>	  
	<%
//String cash_slmt_flag = "";		
if( strslmttype == null) strslmttype="";
	try{
			
			for(BLBillDetailsBean billBean:billDetailList){
				if( billBean.getReceiptTypeCode()!=null && billBean.getReceiptTypeCode().equals("")){
					HashMap<String,String> extAccDetails=bean.extAccDetailsFetch(con, strfacilityid, billBean.getDocTypeCode(), billBean.getDocNum());
					billBean.setReceiptNature(extAccDetails.get("receipt_nature"));
					billBean.setReceiptTypeCode(BLHelper.getDescriptionViaSQL(con,BlRepository.getBlKeyValue("MULTI_BILL_SLMT_DFLT_RCPT_TYPE")));//extAccDetails.get("receipt_type_code")
					billBean.setExtAccCode(extAccDetails.get("ext_account_code"));
					billBean.setExtAccDept(extAccDetails.get("ext_dept_code"));
				}
			}
			System.out.println(billDetailList);
			
	
			%> <script> 
				var v_error_text = '<%=str_error_text%>';					
				if ( v_error_text != '')
			    {
						alert(v_error_text);

						//return false;
						//window.close();	
				}
				</script>  
			<%

		}
		catch(Exception e )
			{
			 e.printStackTrace();
			out.println(e);
			} 


%>

</HEAD>

	<BODY onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect = "codeArrestThruSelect();" onload='slmt_amt_disabled_YN();funServiceDet_onLoad();fnDispBillTaxDesc();' >
	<FORM name='BillSlmtDetForm' id='BillSlmtDetForm' method='post'  action=''  scrolling='NO' >
<!--Added by Muthu on 9/5/12 against against JD-0008 Starts here -->
<!--Added by Muthu on 9/5/12 against against JD-0008 Ends here -->
<table border='0' cellpadding='3' cellspacing='0'  id='tbl' >	
		<tr style="width: 100%;">
		 <td class="label" colspan = '5'><fmt:message key="eBL.DownTimeEntry.label" bundle="${bl_labels}"/>
		<input type="checkbox" id='downTimeEntry' name="downTimeEntry" id="downTimeEntry" value=''  >	</td>
		</tr>
		<tr id="trDownTypeEntry" style="width: 100%;">
		<td class="label"  style="width: 12%" ><fmt:message key="eBL.DocumentNo.label" bundle="${bl_labels}"/>
		</td>
		<td  style="width: 28%"> 
		<input type='text' name='doc_type_number' id='doc_type_number' id='doc_type_number' size='10' maxlength='30'  value=''    >		 
		 <label><fmt:message key="eBL.DocNoslash.label" bundle="${bl_labels}"/></label>
		<input type='text' name='document_number' id='document_number' id='document_number' size='10' maxlength='8'  value=''  onkeypress='return checkAlpha(event);' onBlur='checkForNumber(this)' ><input type='button' class='button' name="docnumber" id="docnumber"   value='?'  tabindex='0' ><img src='../../eCommon/images/mandatory.gif'>					 
		</td>
		<td class="label" style="width: 10%"><fmt:message key="eBL.DepositDate.label" bundle="${bl_labels}"/>
		 </td>
		 <td width="17%" >
		 <input type='text' name='deposit_date' id='deposit_date' id='deposit_date' size='15' maxlength='19'  value='' onBlur='isValidDateTime(deposit_date);'  >
		 &nbsp;<img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('deposit_date','dd/mm/yyyy','hh:mm');" >
		 &nbsp;<img src='../../eCommon/images/mandatory.gif'>		 		
		</td>
		 <td class="label" style="width: 12%"><fmt:message key="eBL.DepositReason.label" bundle="${bl_labels}"/>
		</td>
		 <td style="width: 21%" >
		 <input type='text' name='deposit_reason' id='deposit_reason' id='deposit_reason' size='10' maxlength='30'  value=''  onBlur="if(this.value!=''){ callCommonLookupCode(dep_reason,deposit_reason,3,1); } else{ fnClearCode(dep_reason); }">			 		
		<input type='text' name='dep_reason' id='dep_reason' id='dep_reason' size='10' maxlength='30'  value=''  onBlur="if(this.value!=''){ callCommonLookupCode(dep_reason,deposit_reason,3,2); } else{ fnClearCode(dep_reason); }">
		&nbsp;<input type='button' class='button' name="reason" id="reason"   value='?'  tabindex='0' onClick="callCommonLookupCode(dep_reason,deposit_reason,3,2);"><img src='../../eCommon/images/mandatory.gif'>					 
		</td>			 				
		</tr>
		</table>
		<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>		 
		<tr><td class='columnHeader' colspan='16'><fmt:message key="Common.BillDetails.label" bundle="${common_labels}"/></td></tr>
		<tr>
<!--	<td class="label" width="25%">Bill No</td>	 -->
		<td class="label" width="25%"><fmt:message key="eBL.BILL_NO.label" bundle="${bl_labels}"/></td>	 
		<td class="fields" width="25%"><INPUT TYPE="TEXT"  name="billdoctype" id="billdoctype" SIZE="7" MAXLENGTH="10" 				VALUE='<%=strbilldoctypecode%>'  style='text-align:left' READONLY> / <INPUT TYPE="TEXT" 
		 name="billdocnum" id="billdocnum" SIZE="8" MAXLENGTH="10"  VALUE='<%=strbilldocnum%>' style='text-align:right' READONLY>
	
<!--	<td class="label" width="25%">Payable Amount</td>	-->
		<td class="label" width="25%"><fmt:message key="eBL.PAYABLE_AMT.label" bundle="${bl_labels}"/> &nbsp;<span style='display: none;font-size: 9px;' id='billLevelTaxDesc' name='billLevelTaxDesc'></span></td>	
<!--
		<td>&nbsp;<INPUT TYPE="TEXT" READONLY name="billpayableamt" id="billpayableamt" SIZE="8" MAXLENGTH="20" 	VALUE='<%=strbillpayableamt%>'  style='text-align:right'>&nbsp;<INPUT TYPE="button"  class="BUTTON" VALUE="  OK  " onClick='billslmtprocess()'><td> 	-->	
		<td class="fields" width="25%"><INPUT TYPE="TEXT" READONLY id="billpayableamt" name="billpayableamt" id="billpayableamt" SIZE="15" MAXLENGTH="20" 	VALUE='<%=strbillpayableamt%>'  style='text-align:right'>&nbsp;</td> 
<!--Added by Muthu on 9/5/12 against against JD-0008 Starts here -->
<%
	String drug_penalty_yn ="";
	double strdrugpenaltyamt =0.00;	
	
	
	
	String multiSlmtBeanId = "BLMultiBillSettlementBean";
	String multiSlmtBeanName = "eBL.BLMultiBillSettlementBean";
	BLMultiBillSettlementBean multiSlmtBean=(BLMultiBillSettlementBean) getBeanObject(multiSlmtBeanId, multiSlmtBeanName, request);

	HashMap<String,String> penaltyCharge=multiSlmtBean.getDrugPenaltyCharges(con,strfacilityid,docTypeCodeArray,docNumListArray);
	drug_penalty_yn=penaltyCharge.get("status");
	
    if(drug_penalty_yn.equals("Y"))
	{
    	strdrugpenaltyamt=Double.parseDouble(penaltyCharge.get("amount"));
		DecimalFormat df = new DecimalFormat("0.00");      
 	%>	
	<td class="label" width="25%"><fmt:message key="eBL.DrugPenalty.label" bundle="${bl_labels}"/></td>
	<td width="25%" class="fields"><INPUT TYPE="TEXT" name="drugpenality" id="drugpenality" SIZE="15" MAXLENGTH="20" VALUE='<%=df.format(strdrugpenaltyamt)%>'  style='text-align:right' readOnly/> </td>
	<%
	}	
%>	
<!--Added by Muthu on 9/5/12 against against JD-0008 Ends here -->
		</tr>
		<tr>
<!--added here by ram-->
<%	
		double remOutStnndAmt = 0.00;
		try{
			remOutStnndAmt = Double.parseDouble(strbillpayableamt) - Double.parseDouble(strslmtamt);			
		}
		catch(Exception e){
			remOutStnndAmt = 0.00;
		}
%>	
		<td class="label"  width="25%"><fmt:message key="eBL.RECEIPT_TYPE.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields">
		<a name='billList' id='billList' href="#" >Modify Receipt Details</a><img src='../../eCommon/images/mandatory.gif'>  </td>
		<input type= hidden name="rectypedesc" id="rectypedesc"  value='<%=strrectypedesc%>'>	
		</tr>
		<tr>
		<td class="label" width="25%"><fmt:message key="eBL.SLMT_AMT.label" bundle="${bl_labels}"/>
		<% if(session.getAttribute("deposit_adjusted_payable_amount")!=null){
			strslmtamt=(String)session.getAttribute("deposit_adjusted_payable_amount") ;
			depositAdjustedIndicator=true;
		}
		%>
	
		<td width="25%" class="fields"><INPUT TYPE="TEXT"  id="billslmtamtdet"  name="billslmtamtdet" id="billslmtamtdet" SIZE="15" MAXLENGTH="20" 	VALUE='<%=strslmtamt%>'  style='text-align:right' onKeyPress='return(ChkNumberInput1(this,event,2,1))' onBlur='putdeci(this);funServiceDet()'></td>
<%
			if("MOHBR".equals(custId)){ %>
				</tr>
				<tr>
					<td class="label" width="25%"><fmt:message key="eBL.OutstandingAmount.label" bundle="${bl_labels}"/>	
					<td width="25%" class="fields"><INPUT TYPE="TEXT" readonly name="remOutStndAmt" id="remOutStndAmt" SIZE="14" MAXLENGTH="10" 	VALUE='<%=remOutStnndAmt%>'  style='text-align:right' onKeyPress='return(ChkNumberInput1(this,event,2))' onBlur='putdeci(this);funServiceDet()'> </td>
					<td width="25%"  class="fields">&nbsp;</td>	
					<td width="25%">&nbsp;</td>
			<%}
		
%>	

</tr>	
<!--here end-->
<%if(settleByService==true){ %>
	<tr>
	<td class="label"  width="25%">Service Criteria</td>
	
	<td  width="25%" class="fields">
		<div id='serviceCriteriaDiv'><select name="all_service_criteria" id="all_service_criteria" id="all_service_criteria">
		  <option <%=allIncluded %> value="I">All Services Included</option>
		  <option <%=allExcluded %> value="E">All Services Excluded</option>
		</select>
		</div>
	</td>	
	
	<td class="label" width="25%">
	<div id='selectServiceList'><a name='svcList' id='svcList' href="#" >Service List</a> </div>
	</td>
	<td class="label">&nbsp;</td>
	<td></td>
	</tr>
<%} else{%>
	<tr>
	<td class="label"  width="25%">Service Criteria</td>
	<td  width="25%" class="fields">
		<div id='serviceCriteriaDiv'><select name="all_service_criteria" id="all_service_criteria" id="all_service_criteria">
		  <option <%=allIncluded %> selected value="I">All Services Included</option>
		</select>
		</div>
	</td>
	<td class="label">&nbsp;</td>
	<td></td>
	</tr>	
<%} %>	
	<tr>
	<td class="label" width="25%"><fmt:message key="eBL.RECD_THRU_MAIL.label" bundle="${bl_labels}"/></td>
	<td class="fields" width="25%" ><input type='checkbox' name='recievedthrumail' id='recievedthrumail' ></td>
	<td class="label" width="25%">
	<a name='adjDeposit' id='adjDeposit' href="#" >Adjust from Deposit</a>
	&nbsp;<span id='spAdjFrmDep' name='spAdjFrmDep'>0.00</span>
	</td>
	<td class="label" width="25%">
	<a name='clearDeposit' id='clearDeposit' href="#" >Clear Deposit</a>
	</td>
	</tr>
	
		<!-- <td class="label"> </td> -->
			<tr>		
				<td colspan="15" ></td>
			</tr>
			<tr>		
				<td colspan="15" ></td>
			</tr>
			<tr>		
				<td colspan="15" ></td>
			</tr>
			<tr>		
				<td colspan="15" ></td>
			</tr>
			<tr>		
				<td colspan="15" ></td>
			</tr>
		</table> 
<div id="RecordsIncludedExcluded"></div>
<!-- Karthik added the Code for Bulk Bill Settlement Details - Ends -->

<input TYPE="hidden"  id="settleByService"  name="settleByService" id="settleByService" value='<%=settleByService%>'>
<input TYPE="hidden"  id="strpatientid"  name="strpatientid" id="strpatientid" value='<%=strpatientid%>'>
<INPUT TYPE="HIDDEN" name="pagecloseind" id="pagecloseind"   SIZE="50" MAXLENGTH="100" 	VALUE="0">		
<INPUT TYPE="HIDDEN" name="dfltslmttypecode" id="dfltslmttypecode" SIZE="50" MAXLENGTH="100" 	VALUE='' >	 	
<INPUT TYPE="HIDDEN" name="slmtdate" id="slmtdate"	   SIZE="20" MAXLENGTH="20" 	VALUE=""> 
<INPUT TYPE="HIDDEN" name="slmtdocrefdesc" id="slmtdocrefdesc" SIZE="50" MAXLENGTH="100"	VALUE="">	
<INPUT TYPE="HIDDEN" name="slmtdocref" id="slmtdocref"	   SIZE="50" MAXLENGTH="100" 	VALUE="">
<INPUT TYPE="HIDDEN" name="ext_acc_interface_yn" id="ext_acc_interface_yn" SIZE="50" MAXLENGTH="100" 	VALUE='<%=ext_acc_interface_yn%>'>
<INPUT TYPE="HIDDEN" name="str_ext_acc_facility_id" id="str_ext_acc_facility_id" SIZE="50" MAXLENGTH="100" 	VALUE='<%=str_ext_acc_facility_id%>'>
<INPUT TYPE="HIDDEN" name="str_ext_account_code" id="str_ext_account_code" SIZE="50" MAXLENGTH="100" 	VALUE='<%=str_ext_account_code%>'>
<INPUT TYPE="HIDDEN" name="str_ext_dept_ind" id="str_ext_dept_ind"	   SIZE="50" MAXLENGTH="100" 	VALUE='<%=str_ext_dept_ind%>'>
<INPUT TYPE="HIDDEN" name="str_ext_dept_code" id="str_ext_dept_code"	   SIZE="50" MAXLENGTH="100" 	VALUE='<%=str_ext_dept_code%>'>
<INPUT TYPE="HIDDEN" name="str_single_service_grp_yn" id="str_single_service_grp_yn" SIZE="50" MAXLENGTH="100" 	VALUE='<%=str_single_service_grp_yn%>'>
<INPUT TYPE="HIDDEN" name="str_service_grp" id="str_service_grp"	   SIZE="50" MAXLENGTH="100" 	VALUE='<%=str_service_grp%>'>
<INPUT TYPE="HIDDEN" name="str_acc_episode_type" id="str_acc_episode_type" SIZE="50" MAXLENGTH="100" 	VALUE='<%=str_acc_episode_type%>'>

<INPUT TYPE="HIDDEN" name="str_acc_serv_grp_used_yn" id="str_acc_serv_grp_used_yn" SIZE="50" MAXLENGTH="100" 	VALUE='<%=str_acc_serv_grp_used_yn%>'>	
<INPUT TYPE="HIDDEN" name="str_acc_category_code" id="str_acc_category_code"  SIZE="50" MAXLENGTH="100" 	VALUE='<%=str_acc_category_code%>'>	
<INPUT TYPE="HIDDEN" name="str_reln_code" id="str_reln_code"      SIZE="50" MAXLENGTH="100" 	VALUE='<%=str_reln_code%>'>	

<INPUT TYPE="HIDDEN" name="str_episode_type" id="str_episode_type"	   SIZE="50" MAXLENGTH="100" 	VALUE='<%=str_episode_type%>'>
<INPUT TYPE="HIDDEN" name="strfacilityid" id="strfacilityid"	   SIZE="50" MAXLENGTH="100" 	VALUE='<%=strfacilityid%>'>
<input type="hidden" name="locale" id="locale"  value='<%=locale%>'>
<input type="hidden" name="noofdecimal" id="noofdecimal"  value='<%=noofdecimal%>'>
<input type="hidden" name="service_check" id="service_check"  value=''>
<input type='hidden' name='total_records' id='total_records' value='<%=total_records%>'>
<input type='hidden' name="query_string" id="query_string"  value="<%=query_string%>">
<input type='hidden' name="strroundingamt" id="strroundingamt"  value='<%=strroundingamt%>'>

<input type='hidden' name="slmt_amt_disabled_YN" id="slmt_amt_disabled_YN"  value='<%=slmt_amt_disabled_YN%>'>

<input type='hidden' name="called_frm" id="called_frm"  value='<%=called_frm%>'>
<input type='hidden' name="alw_co_wit_bl_slmt_yn" id="alw_co_wit_bl_slmt_yn"  value='<%=alw_co_wit_bl_slmt_yn%>'>
<input type='hidden' name="episode_type" id="episode_type"  value='<%=strepisodetype%>'>
<input type='hidden' name='custId' id='custId' value='<%=custId %>'>
<input type='hidden' name='addlChargeAmtForBill' id='addlChargeAmtForBill' id='addlChargeAmtForBill' value='<%=addlChargeAmtForBill %>'>
<input type='hidden' name='billLevelTax' id='billLevelTax' id='billLevelTax' value='<%=billLevelTax %>'>
<input type='hidden' name='depositAdjustedIndicator' id='depositAdjustedIndicator'  id='depositAdjustedIndicator' value='<%=depositAdjustedIndicator%>'>
<!-- Added by Rajesh V for 59527 -->
<input type='hidden' name='slmtAmtAfterDep' id='slmtAmtAfterDep' id='slmtAmtAfterDep' value=''>
<input type='hidden' name='depAdjAmt' id='depAdjAmt' id='depAdjAmt' value=''>
<input type='hidden' name='partSettled' id='partSettled' id='partSettled' value='<%=partSettled%>'>
<input type='hidden' name='slmtAlreadyDisabled' id='slmtAlreadyDisabled' id='slmtAlreadyDisabled' value=''>
<input type='hidden' name='blReceiptType' id='blReceiptType' id='blReceiptType' value='<%=blReceiptType %>'>
<input type='hidden' name='blRefundType' id='blRefundType' id='blRefundType' value='<%=blRefundType %>'>
<input type='hidden' name='blRecRefInd' id='blRecRefInd' id='blRecRefInd' value=''>
<input type='hidden' name='fromBillGen' id='fromBillGen' id='fromBillGen' value='<%=fromBillGen%>'>
</FORM>	

</BODY>
<%
}catch(Exception e)
	{
	 e.printStackTrace();
	System.out.println("Exception in main detl="+e);}
	finally{					
					if(con!=null) {
					ConnectionManager.returnConnection(con, request);
								  }
			}
%>
</HTML>

