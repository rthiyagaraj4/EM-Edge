 /* 
  *  Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------------
	  1           V210603            19427        	MMS-ME-SCF-0027-TF	           Mohana Priya K
 */

function reset()
{
	PkgAdhocDiscountFrame.PkgPatIdFrame.document.forms[0].patientId.value = "";
	PkgAdhocDiscountFrame.PkgPatIdFrame.document.forms[0].auth_btn.disabled=false;
	PkgAdhocDiscountFrame.PkgPatientHdr.location.href="../../eCommon/html/blank.html";
	PkgAdhocDiscountFrame.PkgAdhocDiscountPatientHdrDtlsFrame.location.href="../../eCommon/html/blank.html";
	PkgAdhocDiscountFrame.PkgAdhocDiscountPatientHdr.location.href="../../eCommon/html/blank.html";
	PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.location.href="../../eCommon/html/blank.html";

}

function callPackageDetails(obj)
{
	document.forms[0].auth_btn.disabled=false;
	document.forms[0].auth_discount.value="";
	parent.PkgAdhocDiscountPatientHdr.location.href="../../eCommon/html/blank.html";
	parent.PkgAdhocDiscountDtlsFrame.location.href="../../eCommon/html/blank.html";
	parent.PkgPatientHdr.location.href="../../eCommon/html/blank.html";
	parent.PkgAdhocDiscountPatientHdrDtlsFrame.location.href="../../eCommon/html/blank.html";
	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	var patientId=obj.value;	
	if(patientId==null || patientId==""){
		//alert(getMessage("BL0002","BL"));
	}
	else
	{
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "patientId=\"" + patientId + "\" " ;					
		xmlStr +=" /></root>";
		var temp_jsp="PkgAdhocDiscountValidation.jsp?func_mode=CHK_PAT_ID";					
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		var responseText=trimString(xmlHttp.responseText);		
		if(responseText=="N")
		{
			alert(getMessage("INVALID_PATIENT","MP"));
			obj.value="";
			obj.focus();
		}
		else if(responseText=="Y")
		{
			parent.PkgAdhocDiscountPatientHdrDtlsFrame.location.href="../../eBL/jsp/PkgAdhocDiscountDtlsForPatient.jsp?patientId="+patientId;
		}
	}
}
function displayPline(patientId)
{
		parent.PkgPatientHdr.location.href="../../eCommon/jsp/pline.jsp?Patient_ID="+patientId;
}
async function getPatID()
	{	
		var pat_id=await PatientSearch();		
		if( pat_id != null )						
		document.forms[0].patientId.value = pat_id ;					
		document.forms[0].patientId.focus ();					
	}


/*For enquiry package  */
async function displaypkgDtls(packageCode,packageSeqNo)
{
	var retVal				= new String();
	var dialogTop			= "10";
	var dialogHeight		= "90vh" ;
	var dialogWidth			= "90vw" ;
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:"+dialogHeight+"; dialogWidth:"+dialogWidth+";status=no" ;
	var sql					= "";
//	var title				= "";
	var title=encodeURIComponent(getLabel("eBL.PACKAGE_DTL.label","BL"))
	var param = "title="+title+"&packageCode="+packageCode+"&packageSeqNo="+packageSeqNo;
	if(packageSeqNo == null || packageSeqNo == "")
		alert(getMessage("BL8501",'BL')); 
	else
		retVal=await top.window.showModalDialog("../../eBL/jsp/PkgEnqMain.jsp?"+param,arguments,features);	
}
	
  
/* Added V180523-Aravindh/MMS-DM-SCF-0346/2 new parameters(custGroupCode, custCode) */
function displayAdhocDiscountDtls(patientId,packageCode,packageSeqNo,packagelongDesc,packageAmount,episode_type,episode_id,visit_id, custGroupCode, custCode) //Added V171219-Gayathri/65499
{
	
	/*saveOnChange();
	parent.PkgAdhocDiscountPatientHdr.location.href="../../eCommon/html/blank.html";*/
	/* Added V180523-Aravindh/MMS-DM-SCF-0346/Starts */
	var copayValidYN = "";
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "patientId=\"" + patientId + "\" " ;					
	xmlStr +=" /></root>";
	var temp_jsp="PkgAdhocDiscountValidation.jsp?func_mode=copay_disc_valid_yn" +
		"&packageSeqNo="+packageSeqNo+
		"&packageCode="+packageCode+
		"&episode_type="+episode_type+
		"&episode_id="+episode_id+
		"&visit_id="+visit_id+
		"&custGroupCode="+custGroupCode+
		"&custCode="+custCode;					
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	
	copayValidYN=trimString(xmlHttp.responseText);		
	/* Added V180523-Aravindh/MMS-DM-SCF-0346/Ends */
	
	/* Added V180523-Aravindh/MMS-DM-SCF-0346/if-condition */
	if(copayValidYN == "Y") {
		alert(getMessage("BL0046","BL"));
		return false;
	} else {
		saveOnChange();
		parent.PkgAdhocDiscountPatientHdr.location.href="../../eCommon/html/blank.html";
		parent.PkgAdhocDiscountDtlsFrame.location.href="../../eBL/jsp/PkgAdhocDiscountDetails.jsp?patientId="+patientId+"&packageCode="+packageCode+"&packageSeqNo="+packageSeqNo+"&packagelongDesc="+encodeURIComponent(packagelongDesc)+"&packageAmount="+packageAmount+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id; //Added V171219-Gayathri/65499
	}
}
function displayAdhocDiscountPatientHdr(patientId,packageCode,packageSeqNo,packagelongDesc)
{
	parent.PkgAdhocDiscountPatientHdr.location.href="../../eBL/jsp/PkgAdhocDiscountPatientHdrDtls.jsp?patientId="+patientId+"&packageCode="+packageCode+"&packageSeqNo="+packageSeqNo+"&packagelongDesc="+encodeURIComponent(packagelongDesc);;
}
function saveOnChange()
{  
	var frmObj = "";
	if(parent.PkgAdhocDiscountDtlsFrame == undefined)
	{
		if(PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame !=undefined)
		frmObj = PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0];
	}
	else
		frmObj = parent.PkgAdhocDiscountDtlsFrame.document.forms[0];
	if(frmObj!=null && frmObj!="" && frmObj!=undefined)
	{
		var xmlString=formXMLString(frmObj);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		//xmlDoc.loadXML(xmlString);
		xmlHttp.open("POST","PkgAdhocDiscountValidation.jsp?func_mode=SAVE_VALUES",false);
		xmlHttp.send(xmlDoc);
		var responseText=xmlHttp.responseText ;
		eval(responseText);
		return true;
	}
}



function formXMLString(frmObj)
{
	
    if( frmObj!=null && frmObj != "undefined" && frmObj.length >0)
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
	}

	return xmlStr;
}


async function apply()
{
	//var sitespec_mms=document.forms[0].sitespec_mms.value;//V210603
	var sitespec_mms=PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].sitespec_mms.value;//V210603
//	alert(sitespec_mms);
	var err_msg="";
	if(PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0]!=null && PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0]!=undefined)
	{
		var tot_records = PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].totalRec.value;
		//Added by Rajesh V for ICN-008. Changed the if-else blocks
		var allowToSave = false;
		for(var i=0;i<tot_records;i++)
		{			
			if(eval("PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].disableForEmpty"+i).value!="Y"){
				if(eval("PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].adhocDiscount_"+i).value!="" && eval("PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].reason_desc"+i).value=="")
				{
					//err_msg= "Please Select the Reason";		
					if(err_msg == ""){
						err_msg= getMessage("BL9608","BL");
					}
					else{
						err_msg += "<br/>"+getMessage("BL9608","BL");
					}
								
				}
				//V210603 starts
				else if(eval("PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].adhocDiscount_"+i).value=="" && eval("PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].reason_desc"+i).value!=""  && (sitespec_mms!="true" || sitespec_mms!=true))
				{
					//err_msg= "Please Select the Reason";		
					if(err_msg == ""){
						err_msg= getMessage("BL6322","BL")+"/"+"0.00";
					}
					else{
						err_msg += "<br/>"+getMessage("BL6322","BL")+"/"+"0.00";
					}
								
				}
				else if(eval("PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].adhocDiscount_"+i).value=="" && eval("PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].reason_desc"+i).value!=""  && (sitespec_mms=="true" || sitespec_mms==true))
				{
					//err_msg= "Please Select the Reason";		
					if(err_msg == ""){
						err_msg= getMessage("BL6322","BL");
					}
					else{
						err_msg += "<br/>"+getMessage("BL6322","BL");
					}
								
				}
				else if( (!(sitespec_mms==true || sitespec_mms=="true")) && (parseInt(eval("PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].adhocDiscount_"+i).value) == 0)){
					if(err_msg == ""){
						err_msg= getMessage("BL6322","BL")+"/"+"0.00";
					}
					else{
						err_msg += "<br/>"+getMessage("BL6322","BL")+"/"+"0.00";
					}
				}
				//V210603 ends
				if(eval("PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].adhocDiscount_"+i).value!="" && eval("PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].reason_desc"+i).value!=""){
					allowToSave = true;
				}
				else
				{
					allowToSave = false;
					break;
				}
			}
			
		}
		
		if(!allowToSave){
			err_msg= getMessage("BL9608","BL");	
		}
		if(err_msg==""){
			await saveOnChange();
		PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].target='messageFrame';
		PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].method='post';
		PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].action="../../servlet/eBL.PkgAdhocDiscountServlet";
		PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].submit();	
		}
		else messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+err_msg;
	}
	else messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';

	/*

	var err_msg="";
	if(PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0]!=null && PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0]!=undefined)
	{
		var tot_records = PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].totalRec.value;
		//Added by Rajesh V for ICN-008. Changed the if-else blocks
		var allowToSave = false;
		for(var i=0;i<tot_records;i++)
		{			
			if(eval("PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].disableForEmpty"+i).value!="Y"){
				if(eval("PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].adhocDiscount_"+i).value!="" && eval("PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].reason_desc"+i).value=="")
				{
					//err_msg= "Please Select the Reason";		
					if(err_msg == ""){
						err_msg= getMessage("BL9608","BL");	
					}
					else{
						err_msg += "<br/>"+getMessage("BL9608","BL");
					}
								
				}
				else if(eval("PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].adhocDiscount_"+i).value=="" && eval("PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].reason_desc"+i).value!="")
				{
					//err_msg= "Please Select the Reason";		
					if(err_msg == ""){
						err_msg= getMessage("BL6322","BL")+"/"+"0.00";
					}
					else{
						err_msg += "<br/>"+getMessage("BL6322","BL")+"/"+"0.00";
					}
								
				}
				else if(parseInt(eval("PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].adhocDiscount_"+i).value) == 0){
					if(err_msg == ""){
						err_msg= getMessage("BL6322","BL")+"/"+"0.00";
					}
					else{
						err_msg += "<br/>"+getMessage("BL6322","BL")+"/"+"0.00";
					}
				}
				
				if(eval("PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].adhocDiscount_"+i).value!="" && eval("PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].reason_desc"+i).value!=""){
					allowToSave = true;
				}
				else
				{
					allowToSave = false;
					break;
				}
			}
			
		}
		
		if(!allowToSave){
			err_msg= getMessage("BL9608","BL");	
		}
		if(err_msg==""){
		saveOnChange();
		PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].target='messageFrame';
		PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].method='post';
		PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].action="../../servlet/eBL.PkgAdhocDiscountServlet";
		PkgAdhocDiscountFrame.PkgAdhocDiscountDtlsFrame.document.forms[0].submit();	
		}
		else messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+err_msg;
	}
	else messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
	*/
}

function onSuccess()
{
	reset()
//	parent.document.location.reload();
}

function validateInd(obj,index)
{
	eval("document.forms[0].adhocDiscount_"+index).value="";
}

function chkAmtPer(obj,index,noofdecimal)
{
	if(eval("document.forms[0].type_"+index).value == "R")
	{
		if(obj.value>100 || obj.value<0)
		{			
			alert(getMessage("BL8539","BL"));
			obj.value="";
		}
	}
	else
	{
		if(obj.value<0)
		{
			alert(getMessage("BL8640","BL"));
			obj.value  = "";
			obj.focus();
		}
		else
		{
			putDecimal(obj,13,noofdecimal);
		}
	}
}

function confirmPasswdchk1(obj)
			{		
					var usr_id=document.forms[0].user_id.value;
					var pass_wd=document.forms[0].passwd.value;
					var rmks=document.forms[0].remarks.value;
					var called_frm = document.forms[0].called_frm.value;	
				
					if(usr_id=="")
						{
//							alert(getMessage("BL9112"));
							alert(getMessage("BL9112","BL"));
							document.forms[0].user_id.focus();
							return false;
						}
						if(pass_wd=="")
						{
//							alert(getMessage("BL9113"));
							alert(getMessage("BL9113","BL"));
							document.forms[0].passwd.focus();
							return false;
						}
					var xmlStr ="<root><SEARCH ";
					xmlStr+= "usr_id=\"" + usr_id + "\" " ;		
					xmlStr+= "pass_wd=\"" + pass_wd + "\" " ;
					xmlStr+= "rmks=\"" + rmks + "\" " ;					
					xmlStr +=" /></root>";
					var temp_jsp="PkgConfirmPassWdValidation.jsp?func_mode=PASSWD_CHECK";					
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST",temp_jsp,false);
					xmlHttp.send(xmlDoc);
					var responseText=trimString(xmlHttp.responseText);	
					//Added V190828-Gomathi/GHL-SCF-1436 Starts
					responseText = responseText.split(":::");	
					if(responseText[1]=="D")		
						{
							alert(getMessage('BL1025','BL'));
							return false;
						} 
					//Added V190828-Gomathi/GHL-SCF-1436 Ends
					if(responseText[0]=="Y")		//Added array[] for split the values
					{	
								window.parent.returnValue="Y";
								window.close();
					}
					else if(responseText[0]=="U"){		//Added array[] for split the values
						alert(getMessage('BL9539','BL'));
					}else{
						alert(getMessage('BL1232','BL'));
					}
				
				}
				
async function searchReason(clng_evnt,index)
			{		//V210603 starts
				var sitespec_mms=document.forms[0].sitespec_mms.value;
				if(sitespec_mms!="true" || sitespec_mms!=true){
					if(eval("document.forms[0].adhocDiscount_"+index).value=="" )
					{						
						//alert(getMessage("BL6322" "BL"));
						var msg = getMessage("BL6322","BL");
						alert(msg);
						eval("document.forms[0].reason_desc"+index).value="";
						return false;
					}
				}else{
					if(eval("document.forms[0].adhocDiscount_"+index).value=="" ||eval("document.forms[0].adhocDiscount_"+index).value==0)
					{						
						//alert(getMessage("BL6322" "BL"));
						var msg = getMessage("BL6322","BL");
						alert(msg+"/"+"0.00");
						eval("document.forms[0].reason_desc"+index).value="";
						return false;
					}
				}	//V210603 ends
			/*	if(eval("document.forms[0].adhocDiscount_"+index).value=="" ||eval("document.forms[0].adhocDiscount_"+index).value==0)
				{						
					//alert(getMessage("BL6322" "BL"));
					var msg = getMessage("BL6322","BL");
					alert(msg+"/"+"0.00");
					eval("document.forms[0].reason_desc"+index).value="";
					return false;
				} */
				var obj=eval("document.forms[0].reason_desc"+index);
				if(clng_evnt == 'B')
				{
					if(obj.value == "")
					{					
						eval("document.forms[0].reason_desc"+index).value="";
						eval("document.forms[0].reason_code"+index).value="";
						//document.forms[0].reason_code.value="";	
						return;
					}
				}
				var target			= eval("document.forms[0].reason_desc"+index);
				var retVal			=  new String();
				var dialogTop	 = "10";
				var dialogHeight = "50vh" ;
				var dialogWidth	 = "50vw" ;
				var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
				var arguments			= "" ;
				var search_desc			= "";
				var title =getLabel("eBL.ADHOC_DISC_REASON.label","BL");		
		//		var title = encodeURIComponent(title);		
				var locale  = document.forms[0].locale.value;		
				
				var sql2="select  a.action_reason_code code,a.action_reason_desc description from bl_action_reason_lang_vw a,bl_action_reason_by_type b where a.action_reason_code  = b.action_reason_code and nvl(a.status,'X') <> 'S' and NVL(b.active_yn, 'N') = 'Y' and upper(language_id) = upper('"+locale+"') AND ACTION_TYPE='PD' and upper(a.action_reason_code) like upper(?) and upper(a.action_reason_desc) like upper(?) order by 1";

				var argArray = new Array();
				var namesArray = new Array();
				var valuesArray = new Array();
				var datatypesArray = new Array();

				argArray[0] = sql2;
				argArray[1] = namesArray;
				argArray[2] = valuesArray;
				argArray[3] = datatypesArray;
				argArray[4] = "1,2";
				argArray[5] = target.value;
				argArray[6] = DESC_LINK;
				argArray[7] = DESC_CODE;		
				retArray = await CommonLookup( title, argArray );		
				
				if(retArray != null && retArray !="")
				{				
					var str =unescape(retArray);
					var arr = str.split(",");
					eval("document.forms[0].reason_code"+index).value=arr[0];
					eval("document.forms[0].reason_desc"+index).value=arr[1];
//					document.forms[0].reason_desc.value=retArray[1];	
					

								
				}
				else
				{			
					eval("document.forms[0].reason_code"+index).value="";
					eval("document.forms[0].reason_desc"+index).value="";
					//	document.forms[0].reason_code.value="";		
				}
			}

async function callAuth()
{	
   if(document.forms[0].patientId.value == "")
	{
	   return;
	}
	var retVal=new Array();
	var dialogHeight= "44vh" ;
	var dialogWidth	= "42vw" ;
	var dialogTop = "225" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;	
	retVal = await window.showModalDialog("../../eBL/jsp/PkgAdhocDiscAuthoriseMain.jsp?mode=s",arguments,features);

	document.forms[0].auth_discount.value=retVal;

	if(retVal=="Y"){
	document.forms[0].auth_btn.disabled=true;
	}
	if(parent.PkgAdhocDiscountDtlsFrame.document.forms[0]!=undefined)
	{
		parent.PkgAdhocDiscountDtlsFrame.document.forms[0].auth_discount.value=retVal;
	}
	
}

async function adhocDiscountAuthFromMPP()
{	
   if(document.forms[0].patientId.value == "")
	{
	   return;
	}
	var retVal=new Array();
	var dialogHeight= "14" ;
	var dialogWidth	= "22" ;
	var dialogTop = "225" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;	
	retVal =await window.showModalDialog("../../eBL/jsp/PkgAdhocDiscAuthoriseMain.jsp?mode=s",arguments,features);

	document.forms[0].auth_discount.value=retVal;

	if(retVal=="Y"){
		document.forms[0].apply_button.disabled=false;
		document.forms[0].auth_btn.disabled=true;
	}	
}

function saveAdhocDiscInMPP()
{
	//var sitespec_mms=document.forms[0].sitespec_mms.value;//V210603
	var sitespec_mms=document.forms[0].sitespec_mms.value;//V210603
//	alert(sitespec_mms);
	var err_msg="";
	var pkg_amt = document.forms[0].pkg_amt.value;
	var totAdhocDiscAmt = 0;	
	
	if(document.forms[0]!=null && document.forms[0]!=undefined)
	{ 
		var tot_records = document.forms[0].totalRec.value;
		//Added by Rajesh V for ICN-008. Changed the if-else blocks
		var allowToSave = false;
		
		for(var i=0;i<tot_records;i++)
		{			
			if(eval("document.forms[0].disableForEmpty"+i).value!="Y"){
				if(eval("document.forms[0].adhocDiscount_"+i).value!="" && eval("document.forms[0].reason_desc"+i).value=="")
				{
					//err_msg= "Please Select the Reason";		
					if(err_msg == ""){
						err_msg= getMessage("BL9608","BL");	
					}
					else{
						err_msg += "<br/>"+getMessage("BL9608","BL");
					}
								
				}
				//V210603 starts
				else if(eval("document.forms[0].adhocDiscount_"+i).value=="" && eval("document.forms[0].reason_desc"+i).value!=""  && (sitespec_mms!="true" || sitespec_mms!=true))
				{
					//err_msg= "Please Select the Reason";		
					if(err_msg == ""){
						err_msg= getMessage("BL6322","BL")+"/"+"0.00";
					}
					else{
						err_msg += "<br/>"+getMessage("BL6322","BL")+"/"+"0.00";
					}
								
				}
				else if(eval("document.forms[0].adhocDiscount_"+i).value=="" && eval("document.forms[0].reason_desc"+i).value!=""  && (sitespec_mms=="true" || sitespec_mms==true))
				{
					//err_msg= "Please Select the Reason";		
					if(err_msg == ""){
						err_msg= getMessage("BL6322","BL");
					}
					else{
						err_msg += "<br/>"+getMessage("BL6322","BL");
					}
								
				}
				else if( (!(sitespec_mms==true || sitespec_mms=="true")) && (parseInt(eval("document.forms[0].adhocDiscount_"+i).value) == 0)){
					if(err_msg == ""){
						err_msg= getMessage("BL6322","BL")+"/"+"0.00";
					}
					else{
						err_msg += "<br/>"+getMessage("BL6322","BL")+"/"+"0.00";
					}
				}
				//V210603 ends
				if(eval("document.forms[0].adhocDiscount_"+i).value!="" && eval("document.forms[0].reason_desc"+i).value!=""){
					allowToSave = true;
				}
				else
				{
					allowToSave = false;
					break;
				}
			}
			var discType = eval("document.forms[0].type_"+i).value;
			var adhocDiscount = parseInt(eval("document.forms[0].adhocDiscount_"+i).value);
			var del_rec = eval("document.forms[0].del_rec"+i).checked;
			
			if(!del_rec) {
				if(discType == 'A') {
					totAdhocDiscAmt = parseInt(totAdhocDiscAmt) + parseInt(adhocDiscount);
				} else {
					totAdhocDiscAmt = parseInt(totAdhocDiscAmt) + parseInt((pkg_amt * (adhocDiscount / 100)));
				}	
			}			
		}
	
		if(totAdhocDiscAmt > pkg_amt) {
			alert("Total Discount Amount cannot be greater than the Package Amount");
			allowToSave = false;
			return false;
		} else {
			document.forms[0].totAdhocDiscAmt.value = totAdhocDiscAmt;
			putDecimal(document.forms[0].totAdhocDiscAmt,13,document.forms[0].noofdecimal.value);
			totAdhocDiscAmt = document.forms[0].totAdhocDiscAmt.value;
		}
		
		if(!allowToSave){
			err_msg= getMessage("BL9608","BL");	
		}
		
		if(err_msg==""){
			parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
			var auth_discount = document.forms[0].auth_discount.value;
			var delimAdhocDiscStr = fnFordelimAdhocDiscStr();
			//alert("delimAdhocDiscStr:"+delimAdhocDiscStr);
			window.returnValue = "Y" + "^" + auth_discount + "^" + totAdhocDiscAmt + "^" + delimAdhocDiscStr; // discUpdatedYN/authYN/totDiscAmt/discDtlsString
			window.close();
		}
		else parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+err_msg;
	}
	else parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
}

function fnFordelimAdhocDiscStr(){
	
	var delimAdhocDiscStr = '';
	
	var tot_records = document.forms[0].totalRec.value;
	var packageCode = document.forms[0].packageCode.value;
	var packageSeqNo = document.forms[0].packageSeqNo.value;
	//alert("tot_records:"+tot_records);
		//Added by Rajesh V for ICN-008. Changed the if-else blocks
				
	for(var i=0;i<tot_records;i++)
	{
			var custGrpCode = eval("document.forms[0].cust_group_code"+i).value;
			var custCode = eval("document.forms[0].cust_code"+i).value;
			var discType = eval("document.forms[0].type_"+i).value;
			var adhocDiscount = eval("document.forms[0].adhocDiscount_"+i).value;
			var reason_desc = eval("document.forms[0].reason_desc"+i).value;
			var reason_code = eval("document.forms[0].reason_code"+i).value;
			var del_rec = eval("document.forms[0].del_rec"+i).checked;
			var to_update = eval("document.forms[0].to_update"+i).value;
			var discountAsPerSetup = eval("document.forms[0].discountAsPerSetup_"+i).value;
			var lclDelimAdhocDiscStr = '';
			
			if(del_rec)
				del_rec = "Y";
			else
				del_rec = "N";
			
			lclDelimAdhocDiscStr = packageCode +"~~"+ packageSeqNo +"~~"+ custGrpCode +"~~"+ custCode +"~~"+ discountAsPerSetup +"~~"+  discType+"~~"+adhocDiscount+"~~"+reason_desc+"~~"+reason_code+"~~"+del_rec+"~~"+to_update;
			
			delimAdhocDiscStr = delimAdhocDiscStr + lclDelimAdhocDiscStr + "::";			
	}		
	
	return delimAdhocDiscStr;
}

function closeAdhocDiscount() {
	window.returnValue = "N" +"|"+ "";
	window.close();
}
