//Karthik added the below Scripts to add link for Partial Deposit - Starts MMS-CRF-0023
async function callPartialDepositScreen(){

		var index=0;
		var patientId= parent.PkgAssociateDtl.document.PkgAssociateDtl.patientId.value;
		var total_records=parent.PkgAssociateDtl.document.PkgAssociateDtl.total_records.value;
		var packageSeqNo = '';
		var packageCode	 = '';
		for(i=0;i<total_records;i++){
			if(eval("parent.PkgAssociateDtl.document.PkgAssociateDtl.associated"+i).checked == true){
				packageSeqNo = packageSeqNo+'^'+eval("parent.PkgAssociateDtl.document.PkgAssociateDtl.pkg_seq_no"+i).value;
				packageCode = packageCode+'^'+eval("parent.PkgAssociateDtl.document.PkgAssociateDtl.pkg_code"+i).value;		
			}
		}
		
		var eid="";
		var episodetype="R";
		var retVal="";
		var center='1';
		var dialogTop	= '70';
		var dialogHeight	= '90vh';
		var dialogWidth		= '70vw';
		var features		= 'dialogTop:' + dialogTop + '; dialogHeight:' + dialogHeight +'; center: ' + center + '; dialogWidth: ' + dialogWidth + '; status=no' ;
		var  arguments 		= "";
		var  column_sizes  		= escape("");
		var  column_descriptions  	= "";
		var msg="";
		
		var URL="../../eBL/jsp/BLPkgAssociateDtlsValidation.jsp?calledFrom=Associate&patientId="+patientId+"&packageCode="+packageCode+"&packageSeqNo="+packageSeqNo;

		var xmlHttp = new XMLHttpRequest() ;
		xmlHttp.open("POST",URL,false);
		xmlHttp.send();	
		var responseText=trimString(xmlHttp.responseText);	
		var responsetextArr = responseText.split("|");
		var checkPartialpkgAmount=responsetextArr[0];
		var checkMinDepAmt = '';
		var param;
		if(checkPartialpkgAmount!='PARTIAL_DEPOSIT_DTLS_NOTFOUND'){
		
		pkgAmount=checkPartialpkgAmount;
		checkMinDepAmt = responsetextArr[1];
		param="column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&patient_id="+patientId+"&packseqno="+packageSeqNo+"&pkgCode="+packageCode+"&pkgAmount="+pkgAmount+"&tot_package_amt="+pkgAmount+"&function_id=PKG_BILLING&episode_type=R&modeOfCall=Associate&minDepAmtReq="+checkMinDepAmt;
		
		retVal=await window.showModalDialog("../../eBL/jsp/BLEnterReceiptRefundFrame.jsp?"+param,arguments,features);		
		while(retVal==null || retVal =="" || retVal==undefined || retVal=='undefined')
		{
					retVal=await window.showModalDialog("../../eBL/jsp/BLEnterReceiptRefundFrame.jsp?"+param,arguments,features);		
		} 
		}
	}
//Karthik added the below Scripts to add link for Partial Deposit - Ends MMS-CRF-0023

async function associatePkgFromVisit(patient_id,encounter_date,encounter_date_time,encounter_date_aft_trunc,calling_module_id,firstVisitDateTime)
{
	
	// Karthik Added code for MMS-RY-SCF-0065
	var allPayerCode ='';
	var allPayerGroupCode='';
	var allowedPayersList='';
	
	if(parent.MainFrame2.InsuranceFrame != undefined){
		if(parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame != undefined){
			var insBodyFrm = parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.add_modify_pat_fin_det_insmain;
			if(insBodyFrm.name == 'add_modify_pat_fin_det_insmain'){
				var totalRecord = insBodyFrm.total_records.value;
				if(totalRecord>0){
					for(var indx=0;indx<totalRecord;indx++){
						insCustGrp = eval('parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.add_modify_pat_fin_det_insmain.ins_cust_group_code'+indx).value;
						insCust = eval('parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.add_modify_pat_fin_det_insmain.cust_3'+indx).value;
						if(allPayerCode.indexOf("'" + insCust +"'")<0){ // Removes Duplicate entry in the payer list
						allPayerCode+= "" + insCust +",";
						}
						if(allPayerGroupCode.indexOf("'" + insCustGrp +"'")<0){  // Removes Duplicate entry in the payer list
						allPayerGroupCode+= "" + insCustGrp +",";
						}
					}
					if(allPayerGroupCode!=''){
						allPayerCode=allPayerCode.substring(0, allPayerCode.length -1 );
						allPayerGroupCode=allPayerGroupCode.substring(0, allPayerGroupCode.length -1 );
						allowedPayersList= "&allPayerCode="+allPayerCode+"&allPayerGroupCode="+allPayerGroupCode;
						}
				}
			}			
		}
	}

	var function_id="";
	if(calling_module_id=="OP")
		function_id="VISIT_REGISTRATION";	
	else if(calling_module_id=="IP")		
		function_id="ADMISSION";		
	var package_enabled_yn=document.forms[0].package_enabled_yn.value;
	var center='1';
	var dialogTop	= '90';
	var dialogHeight	= '90vh';
	var dialogWidth		= '80vw';
	var features		= 'dialogTop:' + dialogTop + '; dialogHeight:' + dialogHeight +'; center: ' + center + '; dialogWidth: ' + dialogWidth + '; status=no' ;

	var title=encodeURIComponent(getLabel("eBL.AssociateSubscribedPackage.label","BL"));
	var  arguments 		= "";
	var  column_sizes  		= escape("");
	var  column_descriptions  	= "";
	var param="title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&patientId="+patient_id+"&function_id="+function_id+"&encounter_date="+encounter_date+"&encounter_date_time="+encounter_date_time+"&encounter_date_aft_trunc="+encounter_date_aft_trunc+"&calling_module_id="+calling_module_id+"&package_enabled_yn="+package_enabled_yn+"&firstVisitDateTime="+firstVisitDateTime;
	param = param + allowedPayersList ;
	//alert("param"+param);

	retVal=await top.window.showModalDialog("../../eBL/jsp/PkgAssociateFrame.jsp?"+param,arguments,features);	
	//alert(retVal);
	

}

function chkAssociate(obj,index){
	var formObj=document.PkgAssociateDtl;
	var total_records=document.getElementById("total_records").value;

	if(obj.checked){
		obj.value="Y";		
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "pkg_code=\"" +eval("formObj.pkg_code"+index).value + "\" " ;
		xmlStr+= "pkg_seq_no=\"" + eval("formObj.pkg_seq_no"+index).value + "\" " ;
		xmlStr+= "calling_module_id=\"" +formObj.calling_module_id.value + "\" " ;
		xmlStr+= "index=\"" +index+ "\" " ;
		// Karthik Added code for MMS-RY-SCF-0065
		xmlStr+= "allPayerGroupCode=\"" +formObj.allPayerGroupCode.value+ "\" " ;
		xmlStr+= "allPayerCode=\"" +formObj.allPayerCode.value+ "\" " ;
		xmlStr +=" /></root>";
		var updation=formValidation(xmlStr,"chkPkgvalidepisode");
		
	}else{
		obj.value="N";
		
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "pkg_seq_no=\"" + eval("formObj.pkg_seq_no"+index).value + "\" " ;
		xmlStr+= "pkg_code=\"" +eval("formObj.pkg_code"+index).value + "\" " ;
		xmlStr+= "pkg_desc=\"" +eval("formObj.pkg_desc"+index).value + "\" " ;				
		xmlStr+= "index=\"" +index+ "\" " ;
		xmlStr +=" /></root>";
		var updation=formValidation(xmlStr,"chkPkgApprovals");

	}
}


/* Karthik added validation here to perform extra check for Multi encounter cases while subscription - Ends */
function isAcrossEncounterSupported(packageCodeList){
	
	var URL="../../eBL/jsp/PkgSubscriptionAssociationDtlsValidation.jsp?action=across_encounter_check&packageCodeList="+packageCodeList;
	var xmlHttp = new XMLHttpRequest() ;
	xmlHttp.open("POST",URL,false);
	xmlHttp.send();
	var responseText=trimString(xmlHttp.responseText); 				

	var acrossEncounterParameter="N";
	if(responseText.indexOf("SUCCESS_ACROSS_ENCOUNTER")!=-1){ // If across encounter is true as SUCCESS_ACROSS_ENCOUNTER is  found
	acrossEncounterParameter="Y";
	}else{//across encounter is false as SUCCESS_ACROSS_ENCOUNTER is  found
	acrossEncounterParameter="N";	
	}
	
	return acrossEncounterParameter;
}
/* Karthik added validation here to perform extra check for Multi encounter cases while subscription - Ends */

async function record(){
	/** Added by Vijay for PMG CRF 0005 * */
	var siteSpec = parent.PkgAssociateDtl.document.getElementById("siteSpec").value;
	var total_records=parent.PkgAssociateDtl.document.getElementById("total_records").value;

	
	if (siteSpec == 'true') {
		var errorId = parent.PkgAssociateDtl.document
				.getElementById("strMessageId").value;
		var errorText = parent.PkgAssociateDtl.document
				.getElementById("strErrorText").value;

		if (errorId != '' || errorText != '') {
			if (errorId != '') {
				alert(errorId);
				return false;
			}

			else {
				alert(errorText);
				return false;
			}
		}
		else {
			var formObj = parent.PkgAssociateDtl.document.PkgAssociateDtl;
			var updation = formValidation(formXMLStringMain(formObj),
					"saveToBean");
			// Checking across encounter for Associated Package list
			// var
			// packageCodeList=parent.PkgAssociateDtl.document.PkgAssociateDtl.packageCodeList.value;
			// if(isAcrossEncounterSupported(packageCodeList)=='Y'){
			await  callPartialDepositScreen();// Karthik added the below Scripts to
										// add link for Partial Deposit -
										// MMS-CRF-0023
			// }
			window.close();
		}
	}
	/** ends * */
	else {
		var formObj = parent.PkgAssociateDtl.document.PkgAssociateDtl;
		var updation = formValidation(formXMLStringMain(formObj), "saveToBean");
		// Checking across encounter for Associated Package list
		// var
		// packageCodeList=parent.PkgAssociateDtl.document.PkgAssociateDtl.packageCodeList.value;
		// if(isAcrossEncounterSupported(packageCodeList)=='Y'){
		await callPartialDepositScreen();// Karthik added the below Scripts to add
									// link for Partial Deposit - MMS-CRF-0023
		// }
		window.close();

	}

}

function formXMLStringMain(frmObj)
{
    if( frmObj!=null && frmObj != "undefined" )
	{	
		var xmlStr ="<root><SEARCH ";
		if(true)
		{
		var arrObj = frmObj.elements;
		
		for(var i=0;i<arrObj.length;i++)
		{
			var val = "" ;
			if(arrObj[i].type == "checkbox")
			{
				val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
	        }
		    else if(arrObj[i].type == "radio")
			{
				if(arrObj[i].checked)
				{
					val = arrObj[i].value;
			        if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
	            }
		    }
			else if(arrObj[i].type == "select-multiple" )
			{
				for(var j=0; j<arrObj[i].options.length; j++)
			    {
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
	            }
		        val= val.substring(0,val.lastIndexOf('~'))
			    if(arrObj[i].name != null && arrObj[i].name != "")
				    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
		    else
			{
				val = arrObj[i].value;
		        if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
	        }
		}
	}
	xmlStr +=" /></root>";
	//alert("xmlStr from common :"+xmlStr)
	}

	return xmlStr;
}

function formValidation(xmlStr,func_mode)
{	   	
	var temp_jsp="PkgAssociateValidation.jsp?func_mode="+func_mode;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	//alert("formValidation xmlStr:"+xmlStr)
		//alert("last_link:"+last_link)
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText ;
	//alert("responseText :"+responseText);
	eval(responseText);
	//alert("responseText :"+eval(responseText));
	return true;
}

/*For enquiry package  */
async function displaypkgDtls(index)
{
	var retVal				= new String();
	var dialogTop			= "10";
	var dialogHeight		= "90vh" ;
	var dialogWidth			= "80vw" ;
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:"+dialogHeight+"; dialogWidth:"+dialogWidth+";status=no" ;
	var sql					= "";
//	var title				= "";
	var title=encodeURIComponent(getLabel("eBL.PACKAGE_DTL.label","BL"))
	var packageSeqNo			= eval("document.forms[0].pkg_seq_no"+index).value;
	var packageCode			= eval("document.forms[0].pkg_code"+index).value;
	var param = "title="+title+"&packageCode="+packageCode+"&packageSeqNo="+packageSeqNo;
	if(packageSeqNo == null || packageSeqNo == "")
		alert("packageSeqNo is null.");
	else
		retVal=await top.window.showModalDialog("../../eBL/jsp/PkgEnqMain.jsp?"+param,arguments,features);	
}
function dateCheck(index)
{
	//alert('1');
var fromDate=$('#from_date'+index).val();
var toDate=$('#to_date'+index).text();
var fromDateHdn=$('#fromdatehdn'+index).val();
var function_id=$('#function_id').val();
var locale=$('#locale').val();
var firstVisitDateTime=$('#firstVisitDateTime').val();
var toDateHdn=$('#toDateHdn'+index).val();
var msg='';
var status=false;
var flag='';
var errorcodes=new Array();
if(fromDate!='')
	{
	
	if(fromDate.length==16)
		{
		flag='DMYHM';
	
		}
	else if(fromDate.length==19)
		{
		flag='DMYHMS';
	
		}
	else
		{
		alert(getMessage("INVALID_DATE_FMT", "SM"));
		$('#from_date'+index).val($('#fromdatehdn'+index).val());
		return false;
		}

	if(flag=='DMYHM')
		{
	if(validDate(fromDate,'DMYHM',locale))
		
	{
	status=true;
	}
	}
	else if(flag=='DMYHMS')
		{
		if(validDate(fromDate,'DMYHMS',locale))
		{
		status=true;
		//alert('status '+status);
		}
		}
		
	
	if(status==true)
		{
		//alert('in condn true');
		
		$.ajax({
			url:"../../eBL/jsp/BLPkgAscteValidation.jsp?function_id="+function_id,
			type:'POST',
			data:
				{
				packageCode:$('#pkg_code'+index).val(),
				calledFrom:"AssociateSubscribedPackage",
				fromDate:fromDate
				},
			async:false,
			success:function(data){
				var obj=jQuery.parseJSON(data);
				//alert(obj.success);
				if(obj.success=="Y")

						{
						//alert($('#to_date'+index).text());
						//alert(obj.toDate);
						$('#to_date'+index).text(obj.toDate);
						$('#strMessageId').val('');
						$('#strErrorText').val('');
						}
					else
					{
						if(obj.messageId!='')
						{
								if(obj.messageId.indexOf('|')!=-1)
								{
									errorcodes=obj.messageId.split('|');
									for(var i=0;i<errorcodes.length;i++)
										{
										msg=msg+"\n"+getMessage(errorcodes[i],'BL');
										}
									$('#strMessageId').val(msg);
								}
								else
								{
									msg=getMessage(messageId,'BL');
								}
									
						}
						else if(obj.messageText!='')
						{
							msg=messageText;
							$('#strErrorText').val(msg);
						}
					
					if(msg!='')
						{
						alert(msg);
						$('#to_date'+index).text(obj.toDate);
						/*$('#from_date'+index).val(firstVisitDateTime);
						$('#to_date'+index).text(toDateHdn);*/
						return false;
						}
					}		
				}
			});
			
			}
	else
		{
		alert(getMessage("INVALID_DATE_FMT", "SM"));
		$('#from_date'+index).val($('#fromdatehdn'+index).val());
		return false;
		}

}
else
	{
	alert(getMessage('BL00683','BL'));
	$('#from_date'+index).val($('#fromdatehdn'+index).val());
	return false;
	
	}
$('#fromdatehdn'+index).val($('#from_date'+index).val());
}



function toDateDisp(obj,index)  
{
	var firstVisitDateTime=$('#firstVisitDateTime').val();
	var eff_from_date_hdn=$('#eff_from_date_hdn'+index).val();
	var fromDateHdn=$('#fromdatehdn'+index).val();
	var function_id=$('#function_id').val();
	var toDateHdn=$('#toDateHdn'+index).val();
	var msg='';  
	var errorcodes=new Array();
	if(obj.checked)
	{

		$('#from_date'+index).removeAttr('disabled','disabled');
		$('#fromDateimg_'+index).removeAttr('disabled','disabled');
		$('#from_date'+index).val(firstVisitDateTime);
	
	
		$.ajax({
			url:"../../eBL/jsp/BLPkgAscteValidation.jsp?function_id="+function_id,
			type:"POST",
			data:
				{
				packageCode:$('#pkg_code'+index).val(),
				calledFrom:"AssociateSubscribedPackage",
				fromDate:firstVisitDateTime
				},
			async:false,
			success:function(data){
				var obj=jQuery.parseJSON(data);
				if(obj.success=="Y")
					{
					$('#to_date'+index).text(obj.toDate)
					}
			else
			{
			
				if(obj.messageId!='')
				{
						if(obj.messageId.indexOf('|')!=-1)
						{
							errorcodes=obj.messageId.split('|');
							for(var i=0;i<errorcodes.length;i++)
								{
								msg=msg+"\n"+getMessage(errorcodes[i],'BL');
								}
						$('#strMessageId').val(msg);
						}
						else
						{
							msg=getMessage(obj.messageId,'BL');
							$('#strMessageId').val(msg);
						}
							
				}
				else if(obj.messageText!='')
				{
					msg=obj.messageText;
					$('#strErrorText').val(msg);
				}
			
			if(msg!='')
				{
				alert(msg);
				
				//$('#from_date'+index).val(fromDateHdn);
				//$('#to_date'+index).text(toDateHdn);
				return false;
				}
			}
			}
			
		});
	}

	else
		{
		
		$('#from_date'+index).val(eff_from_date_hdn);
		$('#to_date'+index).text(toDateHdn);
		$('#from_date'+index).attr('disabled','disabled');
		$('#fromDateimg_'+index).attr('disabled','disabled');
		$('#strErrorText').val('');
		$('#strMessageId').val('');
		}
	$('#fromdatehdn'+index).val($('#from_date'+index).val());
}
