function reset()
{	
	
	interim_main_report.location.reload();
}

function trimString(sInString) {
	  return sInString.replace(/^\s+|\s+$/g,"");
}

function run() 
{	
	var clicked = $(interim_main_report.body_frame.document).find('#rowClicked').val();
	if(clicked != undefined && clicked!='undefined'){
		runSingleReceipt(clicked);
	}
	else{
		alert('Select a record to run the report');
	}
	
}

async function runSingleReceipt(indx){

var result = interim_main_report.body_frame.document;
result.getElementById('tooltiplayer1').style.visibility = 'hidden';
	
var dialogHeight= "200px" ;
	var dialogWidth	= "450px" ;
	var dialogTop = "225" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;	
	var retVal = await window.showModalDialog("../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp?mode=s&called_frm=EBL_TRANS_SETL_RECEIPT&print=Y&recept_Refund_ind="+recept_Refund_ind,arguments,features);
	 var doAuth=true;
	 var auth_flag ="";
	 if (retVal[0] == 'Y') {auth_flag = 'Y';}else if( retVal[0] == 'N'){ auth_flag = 'N'; return;}		
	 var login_user = retVal[5];		
	var docTypeCode = $.trim($($(result).find('#doc_typ_code'+indx)).text());
	var docNum = $.trim($($(result).find('#doc_num'+indx)).text());
	var docDate = $.trim($($(result).find('#doc_date'+indx)).text());
	var recpt_nature_code = $.trim($($(result).find('#recpt_nature_code'+indx)).text());
	var episode_type = $.trim($($(result).find('#episode_type'+indx)).text());
	var patientId = $.trim($($(result).find('#patient_id'+indx)).text());
	var episodeId = $.trim($($(result).find('#episode_id'+indx)).text());
	var visitId = $.trim($($(result).find('#visit_id'+indx)).text());
	var locale = $(result).find('#locale').val();
	var facilityId = $(result).find('#p_facility_id').val();
	var recept_Refund_ind =$.trim($('#recept_Refund_ind'+indx).text());
	var print_option =  interim_main_report.search_hdr.document.BLReceiptReprint.print_option.value;
	$.ajax({
		type:"POST",
		url:"../../servlet/eBL.BLCancelReceiptServlet",
		data:"mode=CheckForReprint&facilityId="+facilityId+"&print_option="+print_option+"&login_user="+login_user+"&docTypeCode="+docTypeCode+"&docNum="+docNum+"&episode_type="+episode_type+"&language_id="+locale,
		async:false,
		dataType:"text",
		success :async function(data){			
			var dataArr = trimString(data).split("::");				
			var pgim_id_R = dataArr[0];			
			var sessionId_R = dataArr[1];
			var pgim_date_R = (dataArr[2]);
			var pgim_id_C = (dataArr[3]);
			var sessionId_C = (dataArr[4]);
			var pgim_date_C = (dataArr[5]);
			var pgim_id_A1 = (dataArr[6]);
			var sessionId_A1 = (dataArr[7]);
			var pgim_date_A1 = (dataArr[8]);
			var pgim_id_A2 = (dataArr[9]);
			var sessionId_A2 = (dataArr[10]);
			var pgim_date_A2 = (dataArr[11]);
			if(print_option=='R'){
				if(pgim_id_R != null && pgim_id_R != "") {
					var dummyDoc = dummyFrame.document;
		  			var htmlVal = "<html><body>";
		  			htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
		  			htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+facilityId+"'>";
		  			htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+locale+"'>";
		  			htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+pgim_id_R+"'>";
		  			htmlVal += "<input type='hidden' name='p_detailed_YN' id='p_detailed_YN' value='"+"N"+"'>";
		  			htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+sessionId_R+"'>";
		  			htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+pgim_date_R+"'>";
		  			htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+"BL"+"'>";
		  			htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+pgim_id_R+"'>";				
		  			htmlVal += "</form></body></html>";
		  			dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
		  			dummyDoc.dummy_frm.submit();
				}else if(pgim_id_C != null && pgim_id_C != "") {
				
					var dummyDoc = dummyFrame.document;
		  			var htmlVal = "<html><body>";
		  			htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
		  			htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+facilityId+"'>";
		  			htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+locale+"'>";
		  			htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+pgim_id_C+"'>";
		  			htmlVal += "<input type='hidden' name='p_detailed_YN' id='p_detailed_YN' value='"+"N"+"'>";
		  			htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+sessionId_C+"'>";
		  			htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+pgim_date_C+"'>";
		  			htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+"BL"+"'>";
		  			htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+pgim_id_C+"'>";				
		  			htmlVal += "</form></body></html>";
		  			dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
		  			dummyDoc.dummy_frm.submit();
				}
			}else if (print_option == 'A') {
				
				if(pgim_id_A1 != null && pgim_id_A1 != "") {
					var dummyDoc = dummyFrame.document;
		  			var htmlVal = "<html><body>";
		  			htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
		  			htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+facilityId+"'>";
		  			htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+locale+"'>";
		  			htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+pgim_id_A1+"'>";
		  			htmlVal += "<input type='hidden' name='p_detailed_YN' id='p_detailed_YN' value='"+"N"+"'>";
		  			htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+sessionId_A1+"'>";
		  			htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+pgim_date_A1+"'>";
		  			htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+"BL"+"'>";
		  			htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+pgim_id_A1+"'>";				
		  			htmlVal += "</form></body></html>";
		  			dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
		  			dummyDoc.dummy_frm.submit();
				}else if(pgim_id_A2 != null && pgim_id_A2 != "") {
					var dummyDoc = dummyFrame.document;
		  			var htmlVal = "<html><body>";
		  			htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
		  			htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+facilityId+"'>";
		  			htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+locale+"'>";
		  			htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+pgim_id_A2+"'>";
		  			htmlVal += "<input type='hidden' name='p_detailed_YN' id='p_detailed_YN' value='"+"N"+"'>";
		  			htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+sessionId_A2+"'>";
		  			htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+pgim_date_A2+"'>";
		  			htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+"BL"+"'>";
		  			htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+pgim_id_A2+"'>";				
		  			htmlVal += "</form></body></html>";
		  			dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
		  			dummyDoc.dummy_frm.submit();
				}
			} else if(print_option =='B') {						
			 var dialogHeight    = '8' ;
			 var dialogWidth = '20' ;	
			 var dialogTop = '100' ;	 
			 var center    = '1'  ;	
			 var arguments =   '';
			 var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +'; dialogTop:' + dialogTop +'; status=no;';		
			 var param="data="+$.trim(data);
			 var getUrl1  = "../../eBL/jsp/BLReceiptMultipleReport.jsp?"+param;
			 var retVal = await window.showModalDialog(getUrl1,arguments,features);	
			 window.returnValue = 'Y';
			 window.close();	
			}
		},
		error: function(data){
			alert("Error"+data)	;
	     }
	});		

}
async function billNoLkup(bill_number_desc,bill_number_code,option)
{	var formObj=document.BLReceiptReprint;
	var patientId 	= formObj.patient_id.value;	
	var episodeId = formObj.episode_id.value;
	var episode_type = formObj.episode_type.value;
	var depositeType = formObj.depositeType.value;
	var from_receipt_date=formObj.from_receipt_date.value;	
	var to_receipt_date=formObj.to_receipt_date.value;
	var visit_id = formObj.visit_id.value;
	var title="Bill Number";//getLabel(	"eBL.receiptno.label","Receipt No");
	var locale=formObj.locale.value;
	var query='';
	var facility_id = formObj.facility_id.value;
	var argumentArray = new Array();
	var dataNamesArray = new Array();
	var dataValuesArray = new Array();
	var dataTypesArray = new Array();
			
	var query= "SELECT code, description FROM (SELECT DISTINCT a.bill_doc_type_code code, a.bill_doc_number description FROM bl_receipt_refund_dtl_vw a   WHERE operating_facility_id = '"+facility_id+"'  AND  NVL (cancelled_ind, 'N') = 'N'  AND EXISTS ( SELECT 'y' FROM bl_bill_hdr b   WHERE b.doc_type_code = a.bill_doc_type_code   AND b.doc_num = a.bill_doc_number  AND b.bill_status IS NULL) ";     
             
	 var whereClause = "" ;
	if(patientId !=""){
			
		whereClause = whereClause + " and A.PATIENT_ID = '"+patientId+"'  ";
	}
	if(episodeId != ""){		
			whereClause = whereClause + " AND A.EPISODE_ID = '"+episodeId+"' ";		
	}
	if(episode_type != ""){
			whereClause = whereClause + " AND A.episode_type = '"+episode_type+"' ";		
	}

	if(visit_id !="") {
			whereClause = whereClause + " AND A.VISIT_ID = '"+visit_id+"' ";		
	}
	
	 
	 query = query + whereClause +   ")  where upper(code) like upper(?) and upper(description) like upper(?) order by 1 "; 


	argumentArray[0] = query;
	argumentArray[1] = dataNamesArray;
	argumentArray[2] = dataValuesArray;
	argumentArray[3] = dataTypesArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = bill_number_desc.value;				
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = CODE_DESC;
	retVal = await CommonLookup( title, argumentArray );

		var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	//alert(dataTypesArray);
	if(retVal != null && retVal != ""){
		
		bill_number_code.value= arr[0];
		bill_number_desc.value= arr[1];		
}else{
	
	bill_number_code.value= arr[1];
	bill_number_desc.value= arr[0];			
}
	
}


async function receiptNoLkup(cust_desc,cust_code,option,indx){
	var formObj=document.BLReceiptReprint;
	var patientId 	= formObj.patient_id.value;	
	var episodeId = formObj.episode_id.value;
	var episode_type = formObj.episode_type.value;
	var depositeType = formObj.depositeType.value;
	var from_receipt_date=formObj.from_receipt_date.value;	
	var to_receipt_date=formObj.to_receipt_date.value;
	var visit_id = formObj.visit_id.value;
	var from_receipt_doc_type_code=formObj.from_receipt_doc_type_code.value;
	var to_receipt_doc_type_code = formObj.to_receipt_doc_type_code.value;
	
	
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel(	"eBL.receiptno.label","Receipt No");
	var locale=formObj.locale.value;
	var query='';
	
	var facility_id = formObj.facility_id.value;
	
	if(indx == 2) {
		 var data =  formObj.from_receipt_number.value;
	}
	if(indx == 1){
		 var data =  formObj.to_receipt_number.value;
	}
		query = "Select code ,description from (SELECT doc_type_code code, doc_number description  FROM bl_receipt_refund_hdr  WHERE operating_facility_id = '"+facility_id+"'   AND NVL (cancelled_ind, 'N') = 'N'";// AND NVL(RECPT_REFUND_IND,'F')<> 'F' ";
		 var whereClause = "" ;
		 var whereCon = "false";

			
		if(patientId !=""){
						whereClause = whereClause + " AND PATIENT_ID = '"+patientId+"' ";
			}
		
		if(episodeId != ""){
		
				whereClause = whereClause + " AND EPISODE_ID = '"+episodeId+"' ";
			}		
		
		
		if(episode_type != ""){
			
				whereClause = whereClause + " AND episode_type = '"+episode_type+"' ";
			
		}

		if(visit_id !="") {
			
				whereClause = whereClause + " AND VISIT_ID = '"+visit_id+"' ";
			}			
		
		
		if(depositeType != "**"){
			
				whereClause = whereClause + " AND IP_ADM_TRF_DEP_IND = '"+depositeType+"' ";
			}
		if( data != ""){
			whereClause = whereClause + " AND DOC_TYPE_CODE = '"+data+"' ";
				}
	
		if (whereCon == "false") {
			whereCon="true";
			whereClause = whereClause + " AND  TRUNC (doc_date) BETWEEN NVL ( TO_DATE ('"+from_receipt_date+"', 'dd/mm/yyyy'), TO_DATE ('01/01/1900', 'dd/mm/yyyy')) AND NVL ( TO_DATE ('"+to_receipt_date+"', 'dd/mm/yyyy'), TO_DATE ('31/12/4000', 'dd/mm/yyyy'))";
		} else {
			whereCon="true";
			whereClause = whereClause + " AND TRUNC (doc_date) BETWEEN NVL ( TO_DATE ('"+from_receipt_date+"', 'dd/mm/yyyy'), TO_DATE ('01/01/1900', 'dd/mm/yyyy')) AND NVL ( TO_DATE ('"+to_receipt_date+"', 'dd/mm/yyyy'), TO_DATE ('31/12/4000', 'dd/mm/yyyy'))";
		}
	
	query = query + whereClause +")  where upper(code) like upper(?) and upper(description) like upper(?) order by 1 "; 

	argumentArray[0]	= query;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = cust_desc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup( title, argumentArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != ""){
		
		cust_code.value= arr[1];
		cust_desc.value= arr[0];		
 	}else{   		
 		cust_code.value=arr[1];
 		cust_desc.value= arr[0];			
 	}	
	
}

async function showAuthoriseWindow() {
	var locale = $('#locale').val();
	var dialogHeight= "14" ;
	var dialogWidth	= "22" ;
	var dialogTop = "225" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;			
	var hdrFrm = parent.search_hdr.document.BLReceiptReprint;
	var facilityId=hdrFrm.facility_id.value;	
	 var retVal = await window.showModalDialog("../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp?mode=s&called_frm=EBL_TRANS_SETL_RECEIPT",arguments,features);
	 return retVal;
}
async function ReceiptNatureLookup(cust_desc,cust_code,option){
	var frm = document.forms[0];
	var patient_id = frm.patient_id.value;
	var formObj=document.BLReceiptReprint;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title="Receipt Nature";
	var locale=formObj.locale.value;
	var query='';
	var facility_id = formObj.facility_id.value;

	query = "select code,description  from (SELECT recpt_nature_code code ,long_desc description " + 
			"FROM bl_receipt_nature_lang_vw WHERE recpt_nature_code IN "+
           "( SELECT 'AD' FROM DUAL UNION SELECT 'MI' FROM DUAL UNION SELECT 'PR' FROM DUAL UNION SELECT 'RD' FROM DUAL UNION SELECT 'BI' FROM DUAL  UNION SELECT 'IN' FROM DUAL UNION SELECT 'CD' FROM DUAL UNION SELECT 'DC' FROM DUAL union SELECT 'CU' FROM DUAL "+
            "UNION SELECT 'AR' FROM bl_parameters WHERE operating_facility_id = '"+facility_id+"' AND NVL (rcpt_ar_tfr_amt_in_bl_yn, 'N') = 'Y' "+
            "UNION SELECT 'HC' FROM bl_parameters WHERE operating_facility_id = '"+facility_id+"' AND NVL (hcard_in_use_yn, 'N') = 'Y' "+
            "UNION  SELECT 'PK' FROM bl_parameters WHERE operating_facility_id = '"+facility_id+"' AND NVL (package_enabled_yn, 'N') = 'Y' "+
            "UNION SELECT 'PD' FROM DUAL where bl_chk_module_status('PK') = 'VALID' " +
            
            "UNION  SELECT 'CU' FROM DUAL where bl_chk_module_status('AR') = 'VALID' and '"+patient_id+"' IS NULL"+
           ")  AND UPPER (language_id) = UPPER ('"+locale+"') ) where upper(code) like upper(?)  and upper(description) like upper(?) ORDER BY 1";

	argumentArray[0]	= query;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = cust_desc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup( title, argumentArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != ""){
		cust_code.value= arr[0];
		cust_desc.value= arr[0];		
	}else{
		
 		cust_code.value= arr[1];
 		cust_desc.value= arr[0];					
 	}	
}

async function downtimeReceiptnoLookup(cust_desc,cust_code,option){
	
	var formObj=document.BLReceiptReprint;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title="Downtime Document";
	var locale=formObj.locale.value;
	var depositeType = formObj.depositeType.value;
	var query='';
	var facility_id = formObj.facility_id.value;
	var patientId = formObj.patient_id.value;
	var episode_type=formObj.episode_type.value;
	var episodeId = formObj.episode_id.value;
	var from_receipt_date=formObj.from_receipt_date.value;	
	var to_receipt_date=formObj.to_receipt_date.value;
	var from_receipt_number=formObj.from_receipt_number.value;	
	var to_receipt_number=formObj.to_receipt_number.value;
	var from_receipt_doc_type_code=formObj.from_receipt_doc_type_code.value;
	var to_receipt_doc_type_code = formObj.to_receipt_doc_type_code.value;
	var visit_id = formObj.visit_id.value;
	var whereCon = "false";
	
	query = "select code ,description from (SELECT downtime_doc_type_code code, downtime_doc_number description FROM bl_receipt_refund_hdr  WHERE operating_facility_id = '"+facility_id+"'   AND NVL (cancelled_ind, 'N') = 'N'  "+
							  "AND doc_type_code BETWEEN NVL ('"+from_receipt_number+"', '!!!!!!' ) AND NVL ('"+to_receipt_number+"', '~~~~~~') "+
							  " AND DOC_NUMBER BETWEEN NVL ('"+from_receipt_doc_type_code+"', 0) AND NVL ('"+to_receipt_doc_type_code+"', 99999999)" ;
	
	var whereClause = "" ;
	if(patientId !=""){
		whereClause = whereClause + " AND PATIENT_ID = '"+patientId+"' ";
		}
	if(episodeId != ""){
			whereClause = whereClause + " AND EPISODE_ID = '"+episodeId+"' ";
		}		
	if(episode_type != ""){
				
			whereClause = whereClause + " AND episode_type = '"+episode_type+"' ";
		}
	if(visit_id !="") {
	
			whereClause = whereClause + " AND VISIT_ID = '"+visit_id+"' ";
		}			
	
	if(depositeType != "**"){
				whereClause = whereClause + " AND IP_ADM_TRF_DEP_IND = '"+depositeType+"' ";
		}
	if (whereCon == "false") {
		whereCon="true";
		whereClause = whereClause + " AND  TRUNC (doc_date) BETWEEN NVL ( TO_DATE ('"+from_receipt_date+"', 'dd/mm/yyyy'), TO_DATE ('01/01/1900', 'dd/mm/yyyy')) AND NVL ( TO_DATE ('"+to_receipt_date+"', 'dd/mm/yyyy'), TO_DATE ('31/12/4000', 'dd/mm/yyyy'))";
	} else {
		whereCon="true";
		whereClause = whereClause + " AND TRUNC (doc_date) BETWEEN NVL ( TO_DATE ('"+from_receipt_date+"', 'dd/mm/yyyy'), TO_DATE ('01/01/1900', 'dd/mm/yyyy')) AND NVL ( TO_DATE ('"+to_receipt_date+"', 'dd/mm/yyyy'), TO_DATE ('31/12/4000', 'dd/mm/yyyy'))";
	}
	

	   	query = query + whereClause +")  where upper(code) like upper(?) and upper(description) like upper(?) order by 1 "; 
	
	argumentArray[0]   = query;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = cust_desc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup( title, argumentArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != ""){   		
		cust_code.value= arr[1];
		cust_desc.value= arr[0];						
 	}else{   		
 		cust_code.value= arr[1];
 		cust_desc.value= arr[0];					
 	}	
}

async function ReceiptTypeLookup(cust_desc,cust_code,option){

var formObj=document.BLReceiptReprint;
var receipt_nature= formObj.receipt_nature.value;
var argumentArray  = new Array() ;
var dataNameArray  = new Array() ;
var dataValueArray = new Array() ;
var dataTypeArray  = new Array() ;
var title=getLabel("eBL.ReceiptType.Label","Receipt Type");
var locale=formObj.locale.value;
var query='';
var facility_id = formObj.facility_id.value;

query = "Select code ,description from ( SELECT   distinct receipt_type_code code, long_desc description FROM bl_receipt_type_lang_vw WHERE receipt_type_code = NVL (NULL, receipt_type_code)";
if(receipt_nature !=""){
	query = query + " AND RECPT_NATURE_CODE = '"+receipt_nature+"' ";
}

query = query+" ) where upper(code) like upper(?)  and upper(description) like upper(?) order by 2";
//alert(query);
argumentArray[0]	= query;
argumentArray[1]   = dataNameArray ;
argumentArray[2]   = dataValueArray ;
argumentArray[3]   = dataTypeArray ;
argumentArray[4]   = "1,2";
argumentArray[5]   = cust_desc.value ;
argumentArray[6]   = DESC_LINK ;
argumentArray[7]   = CODE_DESC ;
retVal = await CommonLookup( title, argumentArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != ""){   	
		cust_code.value= arr[0];
		cust_desc.value= arr[0];						
	}else{   		
		cust_code.value= arr[1];
		cust_desc.value= arr[0];			
	}
}
function resetSrchCriteria(){
	parent.search_hdr.location.href="../../eBL/jsp/BLReprintReportReceiptHdr.jsp";	
	
}

function search()
{		
//alert("4");
var frm  = document.BLReceiptReprint;	
var from_receipt_doc_type_code=frm.from_receipt_doc_type_code.value;
var from_receipt_number=frm.from_receipt_number.value;	
var to_receipt_number=frm.to_receipt_number.value;	
var from_receipt_date=frm.from_receipt_date.value;	
var to_receipt_date=frm.to_receipt_date.value;	
var to_receipt_doc_type_code = frm.to_receipt_doc_type_code.value;
var episode_type=frm.episode_type.value;	
var patientId = frm.patient_id.value;
var episodeId = frm.episode_id.value;
var visit_id = frm.visit_id.value;
var custGrpCode = frm.custGrpCode.value;	
var custCode = frm.custCode.value;
var depositeType = frm.depositeType.value;
var downtimereceipt_number =  frm.downtimereceipt_number.value;
var bill_doc_no = frm.bill_doc_no.value;
var bill_doc_type = frm.bill_doc_type.value;
var recpt_type =  frm.recpt_type.value;
var receipt_nature=  frm.receipt_nature.value;
var downtimereceipt_number_code =  frm.downtimereceipt_number_code.value;
if (from_receipt_doc_type_code != '' && to_receipt_doc_type_code != '' ){
	if(from_receipt_doc_type_code > to_receipt_doc_type_code){
	alert("To Document  Number  Should Be Greater Than From Document Number");
	return false
}
}
	
	if (patientId == "") {
		if(from_receipt_date =='' || to_receipt_date ==''){
			alert("Date cannot be blank");
			return false;
		}
	}
	if(patientId == ""){
		if(from_receipt_date != '' && to_receipt_date != ''){
			var starr = from_receipt_date.split("/");
			var enarr = to_receipt_date.split("/");
			var startdt = new Date();
			var enddt = new Date();		
			startdt.setFullYear(starr[2], starr[1]-1, starr[0]);
			enddt.setFullYear(enarr[2], enarr[1]-1, enarr[0]);
			var timeDiff;
			var daysDiff;
			timeDiff = enddt.getTime() - startdt.getTime();
			daysDiff =  Math.floor(timeDiff / (1000 * 60 * 60 * 24));		
				if(daysDiff > 29){
					alert("Receipt To Date Cannot be greater than 30 Days from Receipt from Date");
					return false;
				}			
		}
	}
	parent.body_frame.location.href="../../eBL/jsp/BLReprintReceiptProcess.jsp?from_receipt_doc_type_code="+from_receipt_doc_type_code+"&to_receipt_doc_type_code="+to_receipt_doc_type_code+"&from_receipt_number="+from_receipt_number+"&to_receipt_number="+to_receipt_number+
									"&from_receipt_date="+from_receipt_date+"&to_receipt_date="+to_receipt_date+
									"&episode_type="+episode_type+"&patientId="+patientId+"&visit_id="+visit_id+
									"&episodeId="+episodeId+"&custGrpCode="+custGrpCode+"&custCode="+custCode+								
									"&downtimereceipt_number_code="+downtimereceipt_number_code+
									"&downtimereceipt_number="+downtimereceipt_number+
									"&recpt_type_code="+recpt_type+
									"&bill_doc_no="+bill_doc_no+
									"&bill_doc_type="+bill_doc_type+
									"&receipt_nature_code="+receipt_nature+
									"&depositeType="+depositeType;
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	
	
}
function trimString(sInString) {
	  return sInString.replace(/^\s+|\s+$/g,"");
}

function tooltip(obj,indx){
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	var table;
	table = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'> ";	
		table += 
			"<tr>"+
					"<td class = 'contextMenuItem' onmouseOver='highlightDynamicTd(this)' onmouseOut='removeHighlight(this)' style='cursor:pointer' nowrap onclick='showReceiptDetail("+indx+")'>" +
			"Settlement Details"+"</tr>"+
			"<tr> "+
					"<td class = 'contextMenuItem' onmouseOver='highlightDynamicTd(this)' onmouseOut='removeHighlight(this)' style='cursor:pointer' nowrap onclick='ReprintSingleReceipt("+indx+")'>" +
						"Receipt/Refund Reprint"+
					"</td> "+"</tr> "+
			"<tr>"+
					"<td class = 'contextMenuItem' onmouseOver='highlightDynamicTd(this)' onmouseOut='removeHighlight(this)' style='cursor:pointer' nowrap onclick='cancelSingleReceipt("+indx+")'>" +
				"Receipt/Refund Cancel"+"</tr>"+				
			"</table>";		
				
		document.getElementById("t").innerHTML = table;
		resizeWindow(obj);	
}

async function showReceiptDetail(indx){
	hideToolTip();
	 var dialogHeight    = '44vh' ;
	 var dialogWidth = '60vw' ;//50	
	 var dialogTop = '' ;//100	 
	 var center    = '1'  ;	
	 var arguments =   '';
	 var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +'; dialogTop:' + dialogTop +'; status=no:'+';scrolling=auto';	 
	 var doc_type_code  = $.trim($('#doc_typ_code'+indx).text());
	 var doc_number  = $.trim($('#doc_num'+indx).text());
	 var param="doc_type_code="+doc_type_code+"&"+"doc_number="+doc_number;
	 var getUrl1  = "../../eBL/jsp/BLReceiptDetailPopupPage.jsp?"+param;
	 var retVal =await window.showModalDialog(getUrl1,arguments,features);	
	 window.returnValue = 'Y';
	 window.close();
	}

function resizeWindow(orderctlHDR)
{
    var orderctlHDR1 = orderctlHDR.id;	
	var wdth = eval(document.getElementById('orderctlHDR1')).offsetWidth;
	var hght1 = eval(document.getElementById('orderctlHDR1')).offsetHeight;
	var wdth1 = getPos(orderctlHDR).x +wdth;
	var hght = getPos(orderctlHDR).y ;	
	bodwidth  = document.body.offsetWidth;
	bodheight = document.body.offsetHeight;	
	var z 	= bodwidth- (event.x + wdth);		
	var x 	= event.x;
	var y 	= event.y;		
	x 	  = x + (document.getElementById('tooltiplayer1').offsetWidth);
	y 	  = hght + (document.getElementById('tooltiplayer1').offsetHeight);		
	if(x<bodwidth){
		x= wdth1;		
	}else{			
		x = getPos(orderctlHDR).x;		
	}
	if(y<bodheight){			
		y = hght;		
	}else
	{
		y = y - (document.getElementById('tooltiplayer1').offsetHeight*2) + hght1 ;	
	}
	/*document.getElementById("tooltiplayer1").style.posLeft= x;
	document.getElementById("tooltiplayer1").style.posTop = hght;
	document.getElementById("tooltiplayer1").style.visibility='visible';*/
	document.getElementById("tooltiplayer1").style.left= x+"px";
	document.getElementById("tooltiplayer1").style.top = hght+"px";
	document.getElementById("tooltiplayer1").style.visibility='visible';
	
}

function getPos(inputElement) {
    var coords =  new Object();
    coords.x = 0;
    coords.y = 0;
    try {
        targetElement = inputElement;		
        if(targetElement.x && targetElement.y){
            coords.x = targetElement.x;
            coords.y = targetElement.y;
        } else {
            if(targetElement.offsetParent) {
                coords.x += targetElement.offsetLeft;
                coords.y += targetElement.offsetTop;
                while(targetElement = targetElement.offsetParent) {
                    coords.x += targetElement.offsetLeft;
                    coords.y += targetElement.offsetTop;
                }
            } else {
                //alert("Could not find any reference for coordinate positioning.");
            }
        }
        return coords;
    } catch(error) {
        //alert(error.msg);
        return coords;
    }
}

function hideToolTip()	{
	document.getElementById('tooltiplayer1').style.visibility='hidden';
}

function cancelTooltip(obj,indx){
	var table;

	table = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'> "+
					"<tr> "+
						"<td class = 'contextMenuItem' style='cursor:pointer' onmouseOver='highlightDynamicTd(this)' onmouseOut='removeHighlight(this)' nowrap onclick='cancelRecord("+indx+")'>" +
							"Remove"+
						"</td> "+
					"</tr> "+					
				"</table>";		
		document.getElementById('t').innerHTML = table;
		resizeWindow(obj);
}

function RemoveAllTooltip(obj){
	var table;

	table = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'> "+
					"<tr> "+
						"<td class = 'contextMenuItem' style='cursor:pointer' onmouseOver='highlightDynamicTd(this)' onmouseOut='removeHighlight(this)' nowrap onclick='removeAllRecord()'>" +
							"Remove All"+
						"</td> "+
					"</tr> "+					
				"</table>";		
		document.getElementById('t').innerHTML = table;
		resizeWindow(obj);
}


function highlightDynamicTd(obj){
	$(obj).removeClass('contextMenuItem');
	$(obj).addClass('selectedcontextMenuItem');
}

function removeHighlight(obj){
	$(obj).removeClass('selectedcontextMenuItem');
	$(obj).addClass('contextMenuItem');
}
function removeAllRecord(){
	hideToolTip();	
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	parent.selectedFrame.location.href='../../eBL/jsp/BLReprintReceiptSelected.jsp';
	parent.buttonFrame.location.href= '../../eBL/jsp/BLReprintReceiptBtn.jsp';	
}

function cancelRecord(obj){
	hideToolTip();
	
	var selectedFrameDoc = parent.selectedFrame.document;
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	var docTypeCode =  $.trim($('#doc_typ_code'+obj).val());
	var docNum = $.trim($('#doc_num'+obj).val());
	var uniqueReceiptId = docTypeCode+"_"+docNum;
	var dataArray = selectedReceipt.split('####');
	dataArray.splice($.inArray(uniqueReceiptId, dataArray),1);
	selectedReceipt = dataArray.join('####');	
	$('#row'+obj).remove();
	dataArray.pop(uniqueReceiptId);
	
	var trlast = $(parent.selectedFrame.document).find('#tblSelectedReport tr:last');
	var lastindx =  $(trlast).attr('indexval');
	

	lastindx = parseInt(lastindx) - 1;	
	$(selectedFrameDoc).find('#indexTrack').val(lastindx);
	var receiptCount =  $(selectedFrameDoc).find('#receiptCount').val();

	receiptCount = parseInt(receiptCount)-1;
	$(selectedFrameDoc).find('#receiptCount').val(receiptCount);
}


function moveData(indx,isForALL){	
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	$('#doc_typ_chk'+indx).attr('checked',false);		
	var docTypeCode = $.trim($('#doc_typ_code'+indx).text());
	var docNum = $.trim($('#doc_num'+indx).text());
	var docDate = $.trim($('#doc_date'+indx).text());
	var ReceiptNatureCode = $.trim($('#recpt_nature_code'+indx).text());
	var ReceiptTypeCode = $.trim($('#recpt_type_code'+indx).text());
	var docAmt = $.trim($('#doc_amt'+indx).text());	
	var patientId = $.trim($('#patient_id'+indx).text());
	var episodeType = $.trim($('#episode_type'+indx).text());
	var episodeId = $.trim($('#episode_id'+indx).text());
	var visit_id = $.trim($('#visit_id'+indx).text());
	var uniqueReceiptId = docTypeCode+"_"+docNum;
	var selectedReceipt = window.parent.selectedFrame.selectedReceipt;
	var dataArray = selectedReceipt.split('####');
	var arrCnt = $.inArray(uniqueReceiptId,dataArray);
	var selectedFrameDoc = parent.selectedFrame.document;
	var locale = document.forms[0].locale.value; //added against MOHE-CRF-0038.4
	
	
	var void_number = $.trim($('#void_number'+indx).text());
	var recept_Refund_ind= $.trim($('#recept_Refund_ind'+indx).text());
	var receiptCount = $(selectedFrameDoc).find('#receiptCount').val();

	var trlast = $(parent.selectedFrame.document).find('#tblSelectedReport tr:last');
	var indx =  $(trlast).attr('indexval');
	
	if(indx == undefined || indx == 'undefined'){		
		indx = 0;	receiptCount=0;
	}

	if(arrCnt == -1){
		dataArray.push(uniqueReceiptId);
		window.parent.selectedFrame.selectedReceipt = dataArray.join('####');
	}else{
		if(isForALL==false){
		alert('Receipt Already Added');
		}
		return false;
	}
	if ( indx > 50-1  ) {				
		alert("Already 50 rows selected, Can't proceed");
		return;
	} 
	if ( parseInt(receiptCount) > 50-1  ) {				
		alert("Already 50 rows selected, Can't proceed");
		return;
	} else 	{	
		indx = parseInt(indx) + 1;
		receiptCount = parseInt(receiptCount)+1;
		$(selectedFrameDoc).find('#receiptCount').val(receiptCount);	
			
	
		if(void_number=='A' && recept_Refund_ind =='R'){
		
			var tableRow = "<tr id=row"+indx+" indexval="+indx+"> "+
			"<td id='row"+indx+"_col1' class='LABEL' width='10%' nowrap > "+docTypeCode+"<input type='hidden' id='doc_typ_code"+indx+"' name='doc_typ_code"+indx+"' value='"+docTypeCode+"' ></td> "+
			"<td id='row"+indx+"_col2' class='LABEL' width='12%'  nowrap class='fields'  style='cursor:pointer' onclick='cancelTooltip(this,"+indx+");'	onmouseover='hideToolTip();'> "+docNum+"<input type='hidden' name='doc_num"+indx+"' id='doc_num"+indx+"' value='"+docNum+"' > &nbsp; "+"<img align='right' src='../../eCommon/images/inactiveArrow.gif' id='imgArrow"+indx+"'> "+"</td> "+
			"<td id='row"+indx+"_col3' class='LABEL' width='10%' nowrap class='fields'> "+docDate+"<input type='hidden' id='docDate"+indx+"' name='doc_date"+indx+"' value='"+docDate+"' ></td> "+
			"<td id='row"+indx+"_col4' width='11%' nowrap  class='LABEL'> "+ReceiptNatureCode+"<input type='hidden' id='Recpt_Nature_Code"+indx+"' name='Recpt_Nature_Code"+indx+"'  value='"+ReceiptNatureCode+"'  ></td> "+
			"<td id='row"+indx+"_col5' width='10%' nowrap class='LABEL'> "+ReceiptTypeCode+"<input type='hidden' id='Recpt_Type_Code"+indx+"' name='Recpt_Type_Code"+indx+"' value='"+ReceiptTypeCode+"'> </td> "+
			"<td id='row"+indx+"_col6' class='LABEL' width='12%' nowrap class='fields'> "+docAmt+"<input type='hidden' id='doc_Amt"+indx+"' name='doc_Amt"+indx+"' value='"+docAmt+"'  onBlur='putdeci(this);setAmt(this)' ></td> "+
			"<td id='row"+indx+"_col7' width='10%' nowrap class='LABEL'> "+patientId+"<input type='hidden' id='patient_id"+indx+"' name='patient_id"+indx+"' value='"+patientId+"'> </td> "+
			"<td id='row"+indx+"_col8' width='10%'  nowrap class='LABEL'> "+episodeType+"<input type='hidden' id='episode_type"+indx+"'  name='episode_type"+indx+"'  value='"+episodeType+"'  ></td> "+
			"<td id='row"+indx+"_col9' width='10%' nowrap  class='LABEL' > "+episodeId+"<input type='hidden'id='episode_id"+indx+"' name='episode_id"+indx+"' value='"+episodeId+"' ></td> "+ 
			"<td id='row"+indx+"_col10' width='7%' nowrap  class='LABEL' > "+visit_id+"<input type='hidden'id='visit_Id"+indx+"' name='visit_Id"+indx+"' value='"+visit_id+"' > </td> "+	
			"<td  id='row"+indx+"_col11' width='7%'  nowrap maxlength='30'  class='LABEL' > <input  maxlength='30' type='text'  id='void_number"+indx+"' name='void_number"+indx+"' > </td> "+
			
			"</tr> ";
		}else{
		
			var tableRow = "<tr id=row"+indx+" indexval="+indx+"> "+
			"<td id='row"+indx+"_col1' class='LABEL' width='10%' nowrap > "+docTypeCode+"<input type='hidden' id='doc_typ_code"+indx+"' name='doc_typ_code"+indx+"' value='"+docTypeCode+"' ></td> "+
			"<td id='row"+indx+"_col2' class='LABEL' width='12%' nowrap  class='fields'  style='cursor:pointer' onclick='cancelTooltip(this,"+indx+");'	onmouseover='hideToolTip();'> "+docNum+"<input type='hidden' name='doc_num"+indx+"' id='doc_num"+indx+"' value='"+docNum+"' > &nbsp; "+"<img align='right' src='../../eCommon/images/inactiveArrow.gif' id='imgArrow"+indx+"'> "+"</td> "+
			"<td id='row"+indx+"_col3' class='LABEL' width='10%' nowrap class='fields'> "+docDate+"<input type='hidden' id='docDate"+indx+"' name='doc_date"+indx+"' value='"+docDate+"' ></td> "+
			"<td id='row"+indx+"_col4' width='11%'  nowrap class='LABEL'> "+ReceiptNatureCode+"<input type='hidden' id='Recpt_Nature_Code"+indx+"' name='Recpt_Nature_Code"+indx+"'  value='"+ReceiptNatureCode+"'  ></td> "+
			"<td id='row"+indx+"_col5' width='10%' nowrap class='LABEL'> "+ReceiptTypeCode+"<input type='hidden' id='Recpt_Type_Code"+indx+"' name='Recpt_Type_Code"+indx+"' value='"+ReceiptTypeCode+"'> </td> "+
			"<td id='row"+indx+"_col6' class='LABEL' width='12%' nowrap  class='fields'> "+docAmt+"<input type='hidden' id='doc_Amt"+indx+"' name='doc_Amt"+indx+"' value='"+docAmt+"'  onBlur='putdeci(this);setAmt(this)' ></td> "+
			"<td id='row"+indx+"_col7' width='10%' nowrap class='LABEL'> "+patientId+"<input type='hidden' id='patient_id"+indx+"' name='patient_id"+indx+"' value='"+patientId+"'> </td> "+
			"<td id='row"+indx+"_col8' width='10%' nowrap  class='LABEL'> "+episodeType+"<input type='hidden' id='episode_type"+indx+"'  name='episode_type"+indx+"'  value='"+episodeType+"'  ></td> "+
			"<td id='row"+indx+"_col9' width='10%' nowrap class='LABEL' > "+episodeId+"<input type='hidden'id='episode_id"+indx+"' name='episode_id"+indx+"' value='"+episodeId+"' ></td> "+ 
			"<td id='row"+indx+"_col10' width='7%'  nowrap class='LABEL' > "+visit_id+"<input type='hidden'id='visit_Id"+indx+"' name='visit_Id"+indx+"' value='"+visit_id+"' > </td> "+	
			"<td  id='row"+indx+"_col11' width='7%' nowrap  maxlength='30'  class='LABEL' > <input type='hidden'  maxlength='30'  id='void_number"+indx+"' name='void_number"+indx+"' > </td> "+
			
			"</tr> ";
		}
			
		
			$(selectedFrameDoc).find('#tblSelectedReport').show();
			$(parent.buttonFrame.document).find('#btnDiv').show();	
			$(selectedFrameDoc).find('#selectedReportBody').append(tableRow);
	}	
	
	
}

function onSuccess(){
	
}

function callPatValidation(obj)
{
	var frm = document.forms[0];
	var patient_id=obj.value;	
	if(patient_id!=""){
		var xmlStr ="<root><SEARCH ";				
		xmlStr +=" /></root>";
		var temp_jsp="../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=CHK_PAT_ID&patient_id="+patient_id;					
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		var responseText=trimString(xmlHttp.responseText);		
		if(responseText=="N"){
			alert(getMessage("INVALID_PATIENT","MP"));
			obj.select();
		}	
	}
}

function defaultEncounter(obj){

	var patId = document.forms[0].patient_id.value;
	var patClass = document.forms[0].episode_type.value;
	var facilityId = document.forms[0].facility_id.value;
	
	if(obj == 'patId'){
	
		if(patId.length>0 && patClass.length>0){
		
				var xmlStr ="<root><SEARCH ";				
				xmlStr +=" /></root>";
				var temp_jsp="../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=defaultEncounter&pat_id="+patId+"&epsdType="+patClass+"&facility_id="+facilityId;					
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST",temp_jsp,false);
				xmlHttp.send(xmlDoc);
				var responseText=trimString(xmlHttp.responseText);
			
				if(responseText != 'N' && responseText.length>0){
					var retArr = responseText.split(":::");
					document.forms[0].episode_id.value = retArr[0]=='0'?'':retArr[0];
					document.forms[0].hdnEpisode_id.value = retArr[0]=='0'?'':retArr[0];
					document.forms[0].visit_id.value = retArr[2]=='0'?'':retArr[2];
					
				}
				else{
					document.forms[0].episode_id.value = '';
					document.forms[0].hdnEpisode_id.value = '';
					document.forms[0].visit_id.value ='';
					
				}
		}
	}
	else if(obj == 'epsdType'){
	
		if(patId.length>0 && patClass.length>0){
			var xmlStr ="<root><SEARCH ";				
			xmlStr +=" /></root>";
			var temp_jsp="../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=defaultEncounter&pat_id="+patId+"&epsdType="+patClass+"&facility_id="+facilityId;						
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			var responseText=trimString(xmlHttp.responseText);
			
			if(responseText != 'N' && responseText.length>0){
				var retArr = responseText.split(":::");
				document.forms[0].episode_id.value = retArr[0];
				document.forms[0].hdnEpisode_id.value = retArr[0];
				document.forms[0].visit_id.value = retArr[2]=='0'?'':retArr[2];
				document.forms[0].Effective_from.value = retArr[1];
			}
			else{
				document.forms[0].episode_id.value = '';
				document.forms[0].hdnEpisode_id.value = '';
				document.forms[0].visit_id.value ='';
				document.forms[0].Effective_from.value = '';
			}
		}
	}
	
}

async function PatientIdLookup()
{	
	var pat_id=await PatientSearch();		
	var frm = document.forms[0];
	if( pat_id != null ){
		document.getElementById("patient_id").value = pat_id ;
	}					
	else{
		frm.patient_id.value = '';				
	}			
}	

async function callEpisodeDialog(){
	
	var frm = document.forms[0];
	var patient_id = frm.patient_id.value;
	var episode_type = document.forms[0].episode_type.value;
	var episode_id = document.forms[0].episode_id.value;
	var facility_id = document.forms[0].facility_id.value;
	
	var qryParam='&patient_id='+patient_id+'&episode_type='+episode_type+'&episode_id='+episode_id+'&facility_id='+facility_id;
	var retVal				= new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var message				="";	
	var title = "Select Episode";		
	var column_sizes = escape("10%,10%,10%,10%,25%,10%,25%");
	var column_descriptions = 'PATIENT ID'+','+'EPISODE TYPE'+','+'EPISODE ID'+','+'VISIT ID'+','+'CLINIC DATE'+','+'CLINIC CODE'+','+'CLINIC DESC';
	var sql="";			
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&col_show_hide=YYYYYYY"+qryParam;	
	var  retVal= await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=REPRINT_HDR_EPISODE_LOOKUP&"+param,arguments,features);	
	if (retVal != null && retVal!="" && retVal!="undefined" )
	 {
		  retVal=unescape(retVal);
		  var arr=retVal.split("^~^");
		  frm.patient_id.value = arr[0];
		  frm.episode_id.value = arr[2];
		  frm.visit_id.value = arr[3];		
	 }
	return retVal;
	}

async function episodeLookup(obj,code){
	//alert("2");
	var frm = document.forms[0];
	var patient_id = frm.patient_id.value;
	var episode_type = frm.episode_type.value;	
	if(episode_type.length<1){
		alert(getMessage('BL9142','BL'));
		return false;
	}	

	
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	if((episode_type == 'I') || (episode_type == 'D')){
		if(patient_id == ''){
			sql = "Select patient_id code,episode_id description from bl_episode_fin_dtls where episode_type= '"+episode_type+"' and upper(episode_id) like upper(?) and upper(episode_type) like upper(?) order by 2";
		}
		else{
			sql = "Select patient_id code,episode_id description from bl_episode_fin_dtls where patient_id = '"+patient_id+"' and episode_type= '"+episode_type+"' and upper(episode_id) like upper(?) and upper(episode_type) like upper(?) order by 2";
		}
		
	}else if((episode_type == 'O') || (episode_type == 'R') || (episode_type == 'E')){
		if(patient_id == ''){
			sql = "Select patient_id code,episode_id description from bl_visit_fin_dtls where episode_type = '"+episode_type+"' and upper(episode_id) like upper(?) and upper(episode_type) like upper(?) order by 2";
		}
		else{
			sql = "Select patient_id code,episode_id description from bl_visit_fin_dtls where patient_id = '"+patient_id+"' and episode_type = '"+episode_type+"' and upper(episode_id) like upper(?) and upper(episode_type) like upper(?) order by 2";
		}		
	}else{
		if(patient_id == ''){
			sql = "Select patient_id code,episode_id description from bl_visit_fin_dtls where  upper(episode_id) like upper(?) and upper(patient_id) like upper(?) order by 2";
		}
		else{
			sql = "Select patient_id code,episode_id description from bl_visit_fin_dtls where patient_id = '"+patient_id+"'  and upper(episode_id) like upper(?) and upper(patient_id) like upper(?) order by 2";
		}
	}
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	
	retVal = await callOperation(patient_id,episode_type,obj.value,facility_id);	
	
	if((retVal != null)  )  {
		var returnedValues = retVal.split("::");		
		if(returnedValues.length == 5){
			obj.value = returnedValues[0];
			code.value = returnedValues[0];	
			frm.patient_id.value = returnedValues[1];
			frm.visit_id.value = returnedValues[3];
		}
		else if(returnedValues.length == 3){
			obj.value = returnedValues[0];
			code.value = returnedValues[0];			
		}	
		else if(returnedValues.length == 4){
			obj.value = returnedValues[0];
			code.value = returnedValues[0];	
			frm.visit_id.value = returnedValues[2];
		}	
	}
}

async function callDialog(param){
	var dialogTop			= "10px";//40
	var dialogHeight		= "500px";//10
	var dialogWidth			= "900px";//40
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
	retVal=await window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	
	return retVal;
}

async function callOperation(patient_id,episode_type,episode_id,facility_id){	
	var column_sizes = escape("40%,30%,30%");                       	  
	var tit =  getLabel('Common.patientId.label','Common') + ',' +
				getLabel('eBL.episodeid.label','Common') + ',' 
			+ 'Encounter Date' ;
	
	var column_descriptions=encodeURIComponent(tit);

	var sqlTemp = '';
	if(patient_id.length>1){

		var column_sizes = escape("40%,40%,20%");                       	  
		var tit = getLabel('eBL.episodeid.label','Common') + ',' 
					+ 'Encounter Date' + ',' 
					+ 'Visit ID';

		var column_descriptions=encodeURIComponent(tit);

		var sqlTemp = '';
		
		sqlTemp = "Select  Episode_Id1 Episode_Id2, Enc_Regn_Date_Time1 Enc_Regn_Date_Time2,visit_id1 visit_id2 from (Select distinct(to_char(Episode_Id)) Episode_Id1,to_char(Enc_Regn_Date_Time,'dd/mm/yyyy') Enc_Regn_Date_Time1,operating_facility_id,patient_id,episode_type,visit_id visit_id1 From Bl_Encounter_Payer_Priority ) Where operating_facility_id = '"+facility_id+"' and Patient_Id = '"+patient_id+"' ";
		if(episode_type != '**'){
			
			sqlTemp = sqlTemp + "and episode_type='"+episode_type+"'  ";
		}
		
		var sql=escape(sqlTemp);
		
		var title=getLabel("eBL.episodeid.label","common");
		
		title=encodeURIComponent(title);
		
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="
		+sql+"&search_criteria="+episode_id;
	}
	else{
		var column_sizes = escape("30%,30%,30%,10%");                       	  
		var tit =	'Episode ID' +','+//getLabel('Common.episodeid.label','Common') + ',' +
					 getLabel('Common.patientId.label','Common') + ',' 
					+ 'Encounter Date' + ',' 
					+ 'Visit ID';

		var column_descriptions=encodeURIComponent(tit);

		var sqlTemp = '';
		sqlTemp = "Select  Episode_Id1 Episode_Id2, patient_id1 patient_id2, Enc_Regn_Date_Time1 Enc_Regn_Date_Time2, visit_id1 visit_id2 from (Select distinct(to_char(Episode_Id)) Episode_Id1,patient_id patient_id1,to_char(Enc_Regn_Date_Time,'dd/mm/yyyy') Enc_Regn_Date_Time1,operating_facility_id,patient_id,episode_type,visit_id visit_id1  From Bl_Encounter_Payer_Priority ) Where operating_facility_id = '"+facility_id+"' ";
		if(episode_type != '**'){
			
			sqlTemp = sqlTemp + "and episode_type='"+episode_type+"'  ";
		}
		var sql=escape(sqlTemp);
		
		var title=getLabel("eBL.episodeid.label","common");
		
		title=encodeURIComponent(title);
		
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="
		+sql+"&search_criteria="+episode_id;
	}

	
	retVal=await callDialog(param);	
	
	return retVal;
}


function clearCode(obj){
	obj.value = '';
}
	
	
function showCalendar_loc(Val1, Val2)
{	
	if (Val2.disabled == true){	return false;
	}else{	return showCalendar(Val1,null,null);}
}

async function cancelSingleReceipt(indx){	

	hideToolTip();	
	var docTypeCode = $.trim($('#doc_typ_code'+indx).text());
	var docNum = $.trim($('#doc_num'+indx).text());
	var episodeType = $.trim($('#episode_type'+indx).text());
	var recpt_nature_code =$.trim($('#recpt_nature_code'+indx).text());
	var episode_type = $('#episode_type'+indx).text();
	var doc_Amt = $('#doc_Amt'+indx).text();
	var episode_id = $('#episode_id'+indx).text();
	var patient_id = $('#patient_id'+indx).text();
	var auth_flag = $('#auth_flag'+indx).text();
	var void_number = $('#void_number'+indx).text();
var recept_Refund_ind =$.trim($('#recept_Refund_ind'+indx).text());

	var hdrFrm = parent.search_hdr.document.BLReceiptReprint;
	var facilityId=hdrFrm.facility_id.value;
	var locale = $('#locale').val();
	var language_id = locale;
	var cancel_reasoncode  ="";
	var p_alert_flag = "N";	
	var dialogHeight= "40vh" ;
	var dialogWidth	= "31vw" ;
	var dialogTop = "225" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;	

	var retVal = await window.showModalDialog("../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp?mode=s&called_frm=EBL_TRANS_SETL_RECEIPT&void_number="+void_number+"&recept_Refund_ind="+recept_Refund_ind,arguments,features);

	if (retVal[0] == 'Y') { 
		auth_flag='Y';
		cancel_reasoncode  =retVal[2];	 
		var cancel_reason = retVal[3];
		var voidNumber=retVal[4];		
	}else {
		auth_flag='N';
		return;
	}	
	var login_user = retVal[5];
	if(cancel_reasoncode==undefined || cancel_reasoncode =='undefined'){
		cancel_reasoncode='';
	}
		var temp_jsp="../../eBL/jsp/BLReceiptCancelPackageValidation.jsp?action=checkForFirstAlert&facilityId="+facilityId+"&docTypeCode="+docTypeCode+"&docNum="+docNum+"&login_user="+login_user+"&episode_type="+episode_type+"&episode_id="+episode_id+"&patient_id="+patient_id+"&recpt_nature_code="+recpt_nature_code+"&auth_flag="+auth_flag+"&cancel_reasoncode="+cancel_reasoncode+"&cancel_reason="+cancel_reason+"&language_id="+language_id;
	
		var xmlDoc = "" ;
		
		var xmlHttp = new XMLHttpRequest() ;	
		var xmlStr ="<root><SEARCH ";				
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);	
		var responseText=trimString(xmlHttp.responseText);		
		var responseArr = responseText.split("::");
		if(responseArr[0] == '1'){
			if(responseArr[1] == 'Y'){
				var confirmBox = confirm('Cancelling a Receipt which is adjusted from Deposit, Do you want to Continue?');
				p_alert_flag = "Y";
				if(confirmBox){	
					
					$.ajax({
						
						type:"POST",
						url:"../../eBL/jsp/BLReceiptCancelPackageValidation.jsp",
						data:"action=checkForSecondAlert&facilityId="+facilityId+"&docTypeCode="+docTypeCode+"&docNum="+docNum+"&login_user="+login_user+"&episode_type="+episode_type+"&episode_id="+episode_id+"&patient_id="+patient_id+"&recpt_nature_code="+recpt_nature_code+"&auth_flag="+auth_flag+"&cancel_reasoncode="+cancel_reasoncode+"&cancel_reason="+cancel_reason+"&language_id="+language_id,
						async:false,
						dataType:"text",
						success: function(data){
							var dataArr = data.split("::");
							if(dataArr[1] == 'N'){
								callSubmit(indx,cancel_reasoncode,cancel_reason,auth_flag,voidNumber,login_user,p_alert_flag);
								
							}
							else{
							
								var confirmBox = confirm('This Receipt is under process for Credit Card Payment Cycle, Want to cancel(Y/N)?');
								p_alert_flag = "Y";
								
								if(confirmBox){	
								
									
									callSubmit(indx,cancel_reasoncode,cancel_reason,auth_flag,voidNumber,login_user,p_alert_flag);
								}
								else{
									
									parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+'This Receipt is under process for Credit Card Payment Cycle'+'&err_value=Error';
									
									
								}
							}
						},
						error: function(data){
							alert("Error-"+data)	;
					     }
					});
				}
				else{
					parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+'This Receipt '+ $.trim($(data))+' is under process for Credit Card Payment Cycle'+'&err_value=Error';
					
				}
			}
		}else if(responseArr[0] == '2'){			
			if(responseArr[1] == 'N'){			
				callSubmit(indx,cancel_reasoncode,cancel_reason,auth_flag,voidNumber,login_user,p_alert_flag);
			}else {
				var confirmBox = confirm('This Receipt is under process for Credit Card Payment Cycle, Want to cancel(Y/N)?');
				p_alert_flag = "Y";
				if(confirmBox){
					callSubmit(indx,cancel_reasoncode,cancel_reason,auth_flag,voidNumber,login_user,p_alert_flag);
				}
				else{
					parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+'This Receipt is under process for Credit Card Payment Cycle'+'&err_value=Error';
				}				
			}
		}	
}


async function bl_cancel1()
{	
	var selFrm = $(parent.selectedFrame.document).find('#selectedReceiptForm');
	var selDoc = parent.selectedFrame.document;
	var trlast = $(selDoc).find('#tblSelectedReport tr:last');
	var lastindx =  $(trlast).attr('indexval');
	if(lastindx == 'undefined' || lastindx == undefined){
		alert('Please Select atleast one Receipt for Cancel');
		return false;
	}
var cancel_reasoncode="";
var selectedDoc = parent.selectedFrame.document;
var receiptFlag = 'N';
var refundFlag = 'N';

$(selectedDoc).find('[id^=doc_Amt]').each(function(){
	if($(this).val()>0){
		receiptFlag = 'Y';
	}
});

$(selectedDoc).find('[id^=doc_Amt]').each(function(){
	if($(this).val()<0){
		refundFlag = 'Y';
	}
});

var rec_ref_flag="";
if(receiptFlag == "Y" && refundFlag =="Y"){
	rec_ref_flag ="B";
}
if(receiptFlag == "Y" && refundFlag =="N"){
	rec_ref_flag ="R";
}
if(receiptFlag == "N" && refundFlag =="Y"){
	rec_ref_flag ="F";
}
if(receiptFlag == "N" && refundFlag =="N"){
	rec_ref_flag ="N";
}

	var locale = $('#locale').val();
	var language_id = locale;
	var dialogHeight= "38vh" ;
	var dialogWidth	= "31vw" ;
	var dialogTop = "10px" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;		
	var hdrFrm = parent.search_hdr.document.BLReceiptReprint;
	var facilityId=hdrFrm.facility_id.value;
	
	var retVal = await window.showModalDialog("../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp?mode=s&called_frm=EBL_TRANS_SETL_RECEIPT&void_number=+void_number&rec_ref_flag="+rec_ref_flag,arguments,features);
	
	 var doAuth=true;
	 var auth_flag ="";
	 if (retVal[0] == 'Y') {
		  auth_flag = 'Y';
	 }else {
		  auth_flag = 'N';
		  return;
	 }		
	 cancel_reasoncode = retVal[2];
	 var cancel_reason = retVal[3];
	 var void_number = retVal[4];
	 var login_user = retVal[5];		
	 var btnFrm = parent.buttonFrame.document.reprintBtn;
	// btnFrm.resonForCancel.value=cancel_reason;
	// btnFrm.voidNumber.value=void_number;
	 var p_alert_flag = "N";
	 var dynamicParams = '';
	 if(cancel_reasoncode==undefined || cancel_reasoncode =='undefined'){
			cancel_reasoncode='';
		}
	 for(var i=0;i<=lastindx;i++){
		 if($(selDoc).find('#doc_typ_code'+i).val() != 'undefined' && $(selDoc).find('#doc_typ_code'+i).val() != undefined){
			 dynamicParams += "&doc_typ_code"+i+"="+$(selDoc).find('#doc_typ_code'+i).val()+
			 "&doc_num"+i+"="+$(selDoc).find('#doc_num'+i).val()+
			 "&episode_type"+i+"="+$(selDoc).find('#episode_type'+i).val()+
			 "&episode_id"+i+"="+$(selDoc).find('#episode_id'+i).val()+
			 "&patient_id"+i+"="+$(selDoc).find('#patient_id'+i).val()+
			 "&Recpt_Nature_Code"+i+"="+$(selDoc).find('#Recpt_Nature_Code'+i).val()+
			 "&auth_flag"+i+"="+auth_flag+
			 "&void_number"+i+"="+void_number+
			 "&cancel_reasoncode"+i+"="+cancel_reasoncode+
			 "&cancel_reason"+i+"="+cancel_reason ;
			
		 }
	 }
	 $.ajax({
			type:"POST",
			url:"../../eBL/jsp/BLReceiptCancelPackageValidation.jsp?action=checkForFirstdAlertBulk&login_user="+login_user+"&language_id="+language_id+"&lastindx="+lastindx+"&facilityId="+facilityId,
			data:dynamicParams,
			async:false,
			dataType:"text",
			success: function(data){
				var dataArr = data.split("::");			
				
				if(trimString(dataArr[0]) == 'N' ){		
				
					$.ajax({
						type:"POST",
						url:"../../eBL/jsp/BLReceiptCancelPackageValidation.jsp?action=checkForSecondAlertBulk&login_user="+login_user+"&language_id="+language_id+"&lastindx="+lastindx+"&facilityId="+facilityId,
						data:dynamicParams,
						async:false,
						dataType:"text",
						success: function(data){	
							var dataArr = data.split("::");		
						
						
							if(trimString(dataArr[0]) == 'N'){
							
								callSubmitBulk(cancel_reasoncode,cancel_reason,void_number,login_user,p_alert_flag);
							}
							else{
						
								var confirmBox = confirm('This Receipt '+ dataArr[1]+' is under process for Credit Card Payment Cycle, Want to cancel(Y/N)?');		
								p_alert_flag = "Y";
								if(confirmBox){								
									callSubmitBulk(cancel_reasoncode,cancel_reason,void_number,login_user,p_alert_flag);
								}
								else{
									parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+'This Receipt '+dataArr[1]+' is under process for Credit Card Payment Cycle'+'&err_value=Error';									
								}
							}
						},
						error: function(data){
							alert("Error"+data)	;
					     }
					});
				}else{		
					
						var confirmBox = confirm('Cancelling a Receipt '+ dataArr[1]+' which is adjusted from Deposit, Do you want to Continue?');
						p_alert_flag = "Y";
						if(confirmBox){
							$.ajax({
								type:"POST",
								url:"../../eBL/jsp/BLReceiptCancelPackageValidation.jsp?action=checkForSecondAlertBulk&login_user="+login_user+"&language_id="+language_id+"&lastindx="+lastindx+"&facilityId="+facilityId,
								data:dynamicParams,
								async:false,
								dataType:"text",
								success: function(data){
									var dataArr = data.split("::");							
									if(dataArr[0] == 'N') {
										callSubmitBulk(cancel_reasoncode,cancel_reason,void_number,login_user,p_alert_flag);
									}
									else{
										var confirmBox = confirm('This Receipt '+dataArr[1]+' is under process for Credit Card Payment Cycle, Want to    cancel(Y/N)?');
										p_alert_flag = "Y";
										if(confirmBox){											 
											callSubmitBulk(cancel_reasoncode,cancel_reason,void_number,login_user,p_alert_flag);
										}
										else{
											parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+'This Receipt '+ dataArr[1]+' is under process for Credit Card Payment Cycle<BR>Cancellation cancelled by user'+'&err_value=Error';																					
										}
									}
								},
								error: function(data){
									parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?&err_value=Cancelling a Receipt '+ dataArr[1]+' which is adjusted from Deposit<br>Cancellation cancelled by user';
									alert("Error")	;
							     }
							});						
						}
						else{
							parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+'Cancelling a Receipt '+dataArr[1]+' which is adjusted from Deposit<BR>Cancellation cancelled by user'+'&err_value=Error';							
						}
				}
			},
			error: function(data){
				alert("Error")	;
		     }
		});	 
}	

function callSubmitBulk(cancel_reasoncode,cancel_reason,void_number,login_user,p_alert_flag){ 
	
	var hdrFrm = parent.search_hdr.document.BLReceiptReprint;
	var frm = $(parent.selectedFrame.document).find('#selectedReceiptForm');	
	var trlast = $(parent.selectedFrame.document).find('#tblSelectedReport tr:last');
	var lastindx =  $(trlast).attr('indexval');
	var facilityId = $('#facilityId').val();	
	if(lastindx == undefined || lastindx == 'undefined'){
		alert('Please Select atleast one receipt for cancel');
		return false;
	}
	parent.selectedFrame.document.forms[0].mode.value = 'checkForSubmitBulk';
	parent.selectedFrame.document.forms[0].lastindx.value = lastindx;
	parent.selectedFrame.document.forms[0].facilityId.value = facilityId;
	parent.selectedFrame.document.forms[0].login_user.value = login_user;	
	parent.selectedFrame.document.forms[0].cancel_reasoncode.value = cancel_reasoncode;
	parent.selectedFrame.document.forms[0].cancel_reason.value = cancel_reason;

	parent.selectedFrame.document.forms[0].p_alert_flag.value = p_alert_flag;
	parent.selectedFrame.document.forms[0].method = 'POST';
	parent.selectedFrame.document.forms[0].action="../../servlet/eBL.BLCancelReceiptServlet";
	parent.selectedFrame.document.forms[0].submit();	
}


function callSubmit(indx,cancel_reasoncode,cancel_reason,auth_flag,voidNumber,login_user,p_alert_flag){ 

	var hdrFrm = parent.search_hdr.document.BLReceiptReprint;
	var facilityId=hdrFrm.facility_id.value;
	var docTypeCode = $.trim($('#doc_typ_code'+indx).text());
	var docAmt = $.trim($('#doc_Amt'+indx).text());
	var docNum = $.trim($('#doc_num'+indx).text());	
	var recpt_nature_code =$.trim($('#recpt_nature_code'+indx).text());
	var episode_type = $('#episode_type'+indx).text();
	var episode_id = $('#episode_id'+indx).text();
	var patient_id = $('#patient_id'+indx).text();	
	var language_id = $('#locale').val();

	$.ajax({
		type:"POST",
		url:"../../servlet/eBL.BLCancelReceiptServlet?mode=checkForSubmit&facilityId="+facilityId+"&docTypeCode="+docTypeCode+"&docNum="+docNum+"&login_user="+login_user+"&episode_type="+episode_type+"&episode_id="+episode_id+"&patient_id="+patient_id+"&recpt_nature_code="+recpt_nature_code+"&auth_flag="+auth_flag+"&cancel_reasoncode="+cancel_reasoncode+"&cancel_reason="+cancel_reason+"&language_id="+language_id+"&voidNumber="+voidNumber+"&p_alert_flag="+p_alert_flag,		
		async:false,
		dataType:"text",
		success: function(data){				
			parent.search_hdr.document.BLReceiptReprint.search_but.click();
			
			parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+data+'&err_value=Error';
		},
		error: function(data){
			alert("Error"+data)	;
	     }
	});
}

async function ReprintSingleReceipt(indx){
	hideToolTip();
	
	var dialogHeight= "37vh" ;
	var dialogWidth	= "34vw" ;
	var dialogTop = "225" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;		
	var hdrFrm = parent.search_hdr.document.BLReceiptReprint;
	var facilityId=hdrFrm.facility_id.value;
	var recept_Refund_ind =$.trim($('#recept_Refund_ind'+indx).text());
	var retVal =await  window.showModalDialog("../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp?mode=s&called_frm=EBL_TRANS_SETL_RECEIPT&print=Y&recept_Refund_ind="+recept_Refund_ind,arguments,features);
	var doAuth=true;
	 var auth_flag ="";
	 if (retVal[0] == 'Y') {auth_flag = 'Y';}else if( retVal[0] == 'N'){ auth_flag = 'N'; return;}		
	 var login_user = retVal[5];	
	 
	var hdrFrm = parent.search_hdr.document.BLReceiptReprint;
	var docTypeCode = $.trim($('#doc_typ_code'+indx).text());
	var docNum = $.trim($('#doc_num'+indx).text());
	var docDate = $.trim($('#doc_date'+indx).text());
	var facilityId=hdrFrm.facility_id.value;
	var recpt_nature_code =$.trim($('#recpt_nature_code'+indx).text());
	var patient_id = $.trim($('#patient_id'+indx).text());
	var episode_type = $.trim($('#episode_type'+indx).text());
	var print_option = $(hdrFrm).find('#print_option').val();
	var visit_id = $.trim($('#visit_id'+indx).text());
	var locale = $('#locale').val();
	var auth_flag = $('#auth_flag'+indx).text();
	var cancel_reasoncode = $('#cancel_reasoncode').text();
	var cancel_reason = $('#cancel_reason').text();
	var language_id = $('#locale').val();
	var reportId = parent.search_hdr.document.BLReceiptReprint.p_report_id.value;

	$.ajax({

		type:"POST",
		url:"../../servlet/eBL.BLCancelReceiptServlet",
		data:"mode=CheckForReprint&facilityId="+facilityId+"&print_option="+print_option+"&login_user="+login_user+"&docTypeCode="+docTypeCode+"&docNum="+docNum+"&episode_type="+episode_type+"&language_id="+language_id,
		async:false,
		dataType:"text",
		success : async function(data){
						
			var dataArr = trimString(data).split("::");	
			var pgim_id_R = dataArr[0];
			var sessionId_R = dataArr[1];
			var pgim_date_R = (dataArr[2]);
			var pgim_id_C = (dataArr[3]);
			var sessionId_C = (dataArr[4]);
			var pgim_date_C = (dataArr[5]);
			var pgim_id_A1 = (dataArr[6]);
			var sessionId_A1 = (dataArr[7]);
			var pgim_date_A1 = (dataArr[8]);
			var pgim_id_A2 = (dataArr[9]);
			var sessionId_A2 = (dataArr[10]);
			var pgim_date_A2 = (dataArr[11]);
			if(print_option=='R'){
				if(pgim_id_R != null && pgim_id_R != "") {
					var dummyDoc = parent.messageFrame.document;
		  			var htmlVal = "<html><body>";
		  			htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
		  			htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+facilityId+"'>";
		  			htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+language_id+"'>";
		  			htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+pgim_id_R+"'>";
		  			htmlVal += "<input type='hidden' name='p_detailed_YN' id='p_detailed_YN' value='"+"N"+"'>";
		  			htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+sessionId_R+"'>";
		  			htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+pgim_date_R+"'>";
		  			htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+"BL"+"'>";
		  			htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+pgim_id_R+"'>";				
		  			htmlVal += "</form></body></html>";
		  			dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
		  			dummyDoc.dummy_frm.submit();
				}else if(pgim_id_C != null && pgim_id_C != "") {
					var dummyDoc = parent.messageFrame.document;
		  			var htmlVal = "<html><body>";
		  			htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
		  			htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+facilityId+"'>";
		  			htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+language_id+"'>";
		  			htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+pgim_id_C+"'>";
		  			htmlVal += "<input type='hidden' name='p_detailed_YN' id='p_detailed_YN' value='"+"N"+"'>";
		  			htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+sessionId_C+"'>";
		  			htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+pgim_date_C+"'>";
		  			htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+"BL"+"'>";
		  			htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+pgim_id_C+"'>";				
		  			htmlVal += "</form></body></html>";
		  			dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
		  			dummyDoc.dummy_frm.submit();
				}
			}else if (print_option == 'A') {
				if(pgim_id_A1 != null && pgim_id_A1 != "") {
					var dummyDoc = parent.messageFrame.document;
		  			var htmlVal = "<html><body>";
		  			htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
		  			htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+facilityId+"'>";
		  			htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+language_id+"'>";
		  			htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+pgim_id_A1+"'>";
		  			htmlVal += "<input type='hidden' name='p_detailed_YN' id='p_detailed_YN' value='"+"N"+"'>";
		  			htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+sessionId_A1+"'>";
		  			htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+pgim_date_A1+"'>";
		  			htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+"BL"+"'>";
		  			htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+pgim_id_A1+"'>";				
		  			htmlVal += "</form></body></html>";
		  			dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
		  			dummyDoc.dummy_frm.submit();
				}else if(pgim_id_A2 != null && pgim_id_A2 != "") {
					var dummyDoc = parent.messageFrame.document;
		  			var htmlVal = "<html><body>";
		  			htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
		  			htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+facilityId+"'>";
		  			htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+language_id+"'>";
		  			htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+pgim_id_A2+"'>";
		  			htmlVal += "<input type='hidden' name='p_detailed_YN' id='p_detailed_YN' value='"+"N"+"'>";
		  			htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+sessionId_A2+"'>";
		  			htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+pgim_date_A2+"'>";
		  			htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+"BL"+"'>";
		  			htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+pgim_id_A2+"'>";				
		  			htmlVal += "</form></body></html>";
		  			dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
		  			dummyDoc.dummy_frm.submit();
				}
			} else if(print_option =='B') {						
			 var dialogHeight    = '8' ;
			 var dialogWidth = '20' ;	
			 var dialogTop = '100' ;	 
			 var center    = '1'  ;	
			 var arguments =   '';
			 var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +'; dialogTop:' + dialogTop +'; status=no;';		
			 var param="data="+$.trim(data);
			 var getUrl1  = "../../eBL/jsp/BLReceiptMultipleReport.jsp?"+param;
			 var retVal =await window.showModalDialog(getUrl1,arguments,features);	
			 window.returnValue = 'Y';
			 window.close();	
			}
		},
		error: function(data){
			alert("Error"+data)	;
	     }
	});		
}

async function printBulk(){	
	var hdrFrm = parent.search_hdr.document.BLReceiptReprint;
	var print_option = $(hdrFrm).find('#print_option').val();
	var facilityId = $('#facilityId').val();
	var trlast = $(parent.selectedFrame.document).find('#tblSelectedReport tr:last');
	var lastindx =  $(trlast).attr('indexval');
	if(lastindx == undefined || lastindx == 'undefined'){
		alert('Please Select atleast one Receipt for Print');
		return false;
	}	
	var selectedDoc = parent.selectedFrame.document;
	var receiptFlag = 'N';
	var refundFlag = 'N';

	$(selectedDoc).find('[id^=doc_Amt]').each(function(){
		if($(this).val()>0){
			receiptFlag = 'Y';
		}
	});

	$(selectedDoc).find('[id^=doc_Amt]').each(function(){
		if($(this).val()<0){
			refundFlag = 'Y';
		}
	});

	var rec_ref_flag="";
	if(receiptFlag == "Y" && refundFlag =="Y"){
		rec_ref_flag ="B";
	}
	if(receiptFlag == "Y" && refundFlag =="N"){
		rec_ref_flag ="R";
	}
	if(receiptFlag == "N" && refundFlag =="Y"){
		rec_ref_flag ="F";
	}
	if(receiptFlag == "N" && refundFlag =="N"){
		rec_ref_flag ="N";
	}
		
	var dialogHeight= "39vh" ;//10
	var dialogWidth	= "34vw" ;//20
	var dialogTop = "20px" ;//225
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;		
	var hdrFrm = parent.search_hdr.document.BLReceiptReprint;
	var facilityId=hdrFrm.facility_id.value;
	var retVal = await window.showModalDialog("../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp?mode=s&called_frm=EBL_TRANS_SETL_RECEIPT&print=Y&rec_ref_flag="+rec_ref_flag,arguments,features);

	var doAuth=true;
	 var auth_flag ="";
	 if (retVal[0] == 'Y') {
		  auth_flag = 'Y';		  
	 }else if( retVal[0] == 'N'){
		  auth_flag = 'N';		  
		  return;
	 }			

	var login_user = retVal[5];						
	parent.selectedFrame.document.forms[0].mode.value = 'CheckForReprintBulk';
	parent.selectedFrame.document.forms[0].lastindx.value = lastindx;
	parent.selectedFrame.document.forms[0].facilityId.value = facilityId;
	parent.selectedFrame.document.forms[0].login_user.value = login_user;
	parent.selectedFrame.document.forms[0].print_option.value = print_option;
	parent.selectedFrame.document.forms[0].method = 'POST';
	parent.selectedFrame.document.forms[0].action="../../servlet/eBL.BLCancelReceiptServlet";
	parent.selectedFrame.document.forms[0].submit();
}


async function callCommonLookupCode(obj,code,sqlSelect,codeDesc,commonCode){

	var locale = $('#locale').val();
	var facility_id = $('#facility_id').val();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	
	switch(sqlSelect){					
		case 1:
		{
			sql="select description,code from (select short_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and "+
			"cust_group_code in (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw "+
			"where acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') "+
			"and nvl(patient_flag,'N')  ='Y' And Nvl(Insurance_Yn, 'N') = 'Y' )) "+
			"And Acc_Entity_Code In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') union Select 'All Payer Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) "+
			" order by 2";
			title = 'Customer Group';
			break;
		}

		case 2:
		{
			var cust_code = commonCode.value;
			sql = "Select description,code from (Select short_name description,cust_code code from ar_customer_lang_vw "
			+"Where Cust_Code In ( SELECT cust_code "
            +"FROM bl_cust_by_cust_group "
            +"WHERE cust_group_code =  DECODE ('"+cust_code+"',  '**', cust_group_code, '"+ cust_code+ "')) "
           	+"AND acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') "
			+"AND nvl(patient_flag,'N')  ='Y' "
			+"AND nvl(pat_com_flag,'N')='N' "
			+"AND Nvl(Insurance_Yn, 'N') = 'Y' AND Status Is Null "
			+"AND language_id = ('"+locale+"') UNION  Select 'All Payer','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) ";
			title = 'Customer';			
			break;
		}						
	}

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	if(codeDesc == '1'){
		argumentArray[4] = "1,2";
		argumentArray[5] = code.value;
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = DESC_CODE;
	}else if(codeDesc == '2'){
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;
	}
	returnedValues = await CommonLookup(title, argumentArray );
	var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") ){
		obj.value = arr[1];
		code.value = arr[0];			
	}else{
	obj.value = arr[1];
	code.value = arr[0];		
	}
}
function highlightRow(obj,qryClass){
	var frm =  document.resultForm;
	var rowClicked = frm.rowClicked.value;
	if(rowClicked != obj){
		
		if(rowClicked.length>0){
			$('#row'+rowClicked+' td' ).each(function(){
				$(this).attr('class','label');
			});	
			
			$('#row'+rowClicked+' td span' ).each(function(){
				$(this).attr('class','LABEL');
			});	
		}	
		
		$('#row'+obj+' td' ).each(function(){
			$(this).attr('class','LocalYellow');			
		});
		
		$('#row'+obj+' td span' ).each(function(){
			$(this).attr('class','SpanYellow');
		});	
		
		frm.docType.value = document.getElementById("doc_typ_code"+obj).value;	
		frm.documentNumber.value = document.getElementById("doc_num"+obj).value;		
		frm.documentDate.value = document.getElementById("doc_date"+obj).value;		
		frm.patientId.value = document.getElementById("patient_id"+obj).value;
		frm.episodeType.value = document.getElementById("episode_type"+obj).value;
		frm.episodeId.value = document.getElementById("episode_id"+obj).value;
		frm.visit_id.value = document.getElementById("visit_id"+obj).value;
	}
	
	frm.rowClicked.value = obj;
}

