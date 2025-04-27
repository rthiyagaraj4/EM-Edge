
function reset()
{

		if(PkgRefundFrame.length>0){
		PkgRefundFrame.document.location.reload();
		}
}

function chkPatientId()
{
	var patient_id=parent.PkgRefundHdrFrame.document.PkgRefundHdrForm.patient_id.value;	
	var xmlStr ="";
	if(patient_id==""){
		alert(getMessage("BL0002","BL"));
	}else{
	 xmlStr ="<root><SEARCH ";
		xmlStr+= "patient_id=\"" + patient_id + "\" " ;		
		xmlStr +=" /></root>";	
		//alert("xmlStr="+xmlStr);
		 var update=formValidation(xmlStr,"getPatDtls");
		 parent.PkgRefundHdrFrame.document.PkgRefundHdrForm.pkg_code.value="";
		 parent.PkgRefundHdrFrame.document.PkgRefundHdrForm.pkg_desc.value="";
		parent.PkgRefundHdrFrame.document.PkgRefundHdrForm.pkg_code_temp.value= "";
		parent.PkgRefundHdrFrame.document.PkgRefundHdrForm.pkg_desc_temp.value="";		
		parent.PkgRefundHdrFrame.document.PkgRefundHdrForm.pkg_seq_no.value="";					
		parent.PkgRefundHdrFrame.document.PkgRefundHdrForm.pkg_dtls_td.innerHTML="&nbsp;";		
		parent.PkgRefundSrvDtls.location.href="../../eCommon/html/blank.html";
		parent.PkgRefundExclDtls.location.href="../../eCommon/html/blank.html";
		 
	}
			
}


async function getPatID()
	{	
		var pat_id=await PatientSearch();		
		if( pat_id != null )						
		document.forms[0].patient_id.value = pat_id ;					
		document.forms[0].patient_id.focus ();					
	}


async function pkgCodeLookup(pkg_desc,pkg_code){	

	var formObj=document.PkgRefundHdrForm;
	if(formObj!=null){
		if(formObj.pkg_code_temp.value!= formObj.pkg_code.value)
		{
			if(formObj.pkg_code.value != ""){	
	
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title=getLabel("Common.Package.label","common");
				var locale=formObj.locale.value;				
				var facility_id=formObj.facility_id.value;				
				var patient_id=formObj.patient_id.value;				
				var sql=" select   a.PACKAGE_CODE code,b.short_desc description   from  bl_package_sub_hdr a, bl_package_lang_vw b  where a.status='C' and a.operating_facility_id='"+facility_id+"' and a.patient_id='"+patient_id+"' and a.operating_facility_id=b.operating_Facility_id and a.package_code=b.package_code and b.language_id='"+locale+"' and upper(a.PACKAGE_CODE) like upper(?) and upper(b.SHORT_DESC) like upper(?)"; 

				argumentArray[0]   = sql ;
				argumentArray[1]   = dataNameArray ;
				argumentArray[2]   = dataValueArray ;
				argumentArray[3]   = dataTypeArray ;
				argumentArray[4]   = "1,2";
				argumentArray[5]   = pkg_code.value ;
				argumentArray[6]   = DESC_LINK ;
				argumentArray[7]   = CODE_DESC ;
				retVal = await CommonLookup( title, argumentArray );			
				if(retVal != null && retVal != ""){
					pkg_desc.value = retVal[1];
					pkg_code.value =retVal[0] ;
					formObj.pkg_code_temp.value= retVal[0];
					formObj.pkg_desc_temp.value= retVal[1];	
			
					formObj.pkg_dtls_td.innerHTML="<a href='#' name='pkg_dtls' onClick='getPkgDtls();'>"+getLabel("eBL.PACKAGE_DTL.label","BL");+"</a>";
			
					setPkgDtls(retVal[0]);
				}else{
					pkg_desc.value = "";
					pkg_code.value ="";
					formObj.pkg_code_temp.value= "";
					formObj.pkg_desc_temp.value="";		
					formObj.pkg_seq_no.value="";		
					formObj.pkg_dtls_td.innerHTML="";
					parent.PkgRefundSrvDtls.location.href="../../eCommon/html/blank.html";
				}
			}
		}
	}	
}

async function pkgDescLookUp(pkg_desc,pkg_code){
	var formObj=document.PkgRefundHdrForm;
	if(formObj!=null){
		if(formObj.pkg_desc_temp.value != formObj.pkg_desc.value)
		{
			if(formObj.pkg_desc.value != "")
					await show_pkgLookUp(pkg_desc,pkg_code);
		}
	}
}
async function pkgLookUp(pkg_desc,pkg_code){
	var formObj=document.PkgRefundHdrForm;
		if(formObj!=null){
			if(formObj.pkg_desc.value == ""){
					await show_pkgLookUp(pkg_desc,pkg_code);
			}
		}
}
async function show_pkgLookUp(pkg_desc,pkg_code){	
	var formObj=document.PkgRefundHdrForm;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("Common.Package.label","common");
	var locale=formObj.locale.value;
	var facility_id=formObj.facility_id.value;
	var patient_id=formObj.patient_id.value;

	var sql=" select   a.PACKAGE_CODE code,b.short_desc description   from  bl_package_sub_hdr a, bl_package_lang_vw b  where a.status='C' and a.operating_facility_id='"+facility_id+"' and a.patient_id='"+patient_id+"' and a.operating_facility_id=b.operating_Facility_id and a.package_code=b.package_code and b.language_id='"+locale+"' and upper(a.PACKAGE_CODE) like upper(?) and upper(b.SHORT_DESC) like upper(?)"; 
	argumentArray[0]   = sql ;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = pkg_desc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup( title, argumentArray );
	if(retVal != null && retVal != ""){
		pkg_desc.value = retVal[1];
		pkg_code.value =retVal[0] ;		
		formObj.pkg_code_temp.value= retVal[0];
		formObj.pkg_desc_temp.value= retVal[1];		
		formObj.pkg_dtls_td.innerHTML="<a href='#' name='pkg_dtls' onClick='getPkgDtls();'>"+getLabel("eBL.PACKAGE_DTL.label","BL");+"</a>";
		setPkgDtls(retVal[0]);
	}else{
		pkg_desc.value = "";
		pkg_code.value = "" ;		
		formObj.pkg_code_temp.value=  "" ;		
		formObj.pkg_desc_temp.value= "" ;		
		formObj.pkg_seq_no.value= "" ;		
		formObj.pkg_dtls_td.innerHTML="";		
			parent.PkgRefundSrvDtls.location.href="../../eCommon/html/blank.html";
	}
}
function formValidation(xmlStr,func_mode)
{	   	
	
	var temp_jsp="PkgRefundValidation.jsp?func_mode="+func_mode;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText ;
	//alert("responseText :"+responseText);
	eval(responseText);
	return true;
}
async function getPkgDtls(){
	var formObj=document.PkgRefundHdrForm;
	var retVal = 	new String();
	var dialogHeight= "28" ;
	var dialogWidth	= "25" ;
	var status = "no";
	var arguments	= "" ;
	var title=getLabel("eBL.PACKAGE_DTL.label","BL");	
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=yes;  status:" + status;
	var locale=formObj.locale.value;				
	var facility_id=formObj.facility_id.value;				
	var patient_id=formObj.patient_id.value;		
	var pkg_code=formObj.pkg_code.value;		
	
	retVal=await window.showModalDialog("../../eBL/jsp/PkgRefundPkgDtls.jsp?title="+title+"&locale="+locale+"&facility_id="+facility_id+"&patient_id="+patient_id+"&pkg_code="+pkg_code,arguments,features);
}
//PkgRefundPkgDtls.jsp
function setPkgDtls(pkg_code){
	var formObj=document.PkgRefundHdrForm;
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "facility_id=\"" + formObj.facility_id.value + "\" " ;		
	xmlStr+= "patient_id=\"" + formObj.patient_id.value + "\" " ;		
	xmlStr+= "pkg_code=\"" + pkg_code + "\" " ;		
	xmlStr +=" /></root>";	
	//alert("xmlStr="+xmlStr);
	var update=formValidation(xmlStr,"getPkgDtls");

}
function displaySrvDtls(){
	var formObj=document.PkgRefundHdrForm;	
	if(formObj.patient_id.value==""){
		alert(getMessage("BL6103","BL"));
		return false;

	}
	if(formObj.pkg_code.value==""){
		alert(getMessage("BL8501","BL"));
		return false;

	}
	parent.PkgRefundSrvDtls.location.href="../../eBL/jsp/PkgRefundSrvDtls.jsp?pkg_code="+formObj.pkg_code.value+"&pkg_seq_no="+formObj.pkg_seq_no.value +"&facility_id="+formObj.facility_id.value+"&patient_id="+formObj.patient_id.value ;
	parent.PkgRefundExclDtls.location.href="../../eCommon/html/blank.html";
}
function chkRefundAmt(obj,index){
	if(parent.PkgRefundExclDtls.PkgRefundExclDtlsForm!=null){		
			saveExclToBean(parent.PkgRefundExclDtls.PkgRefundExclDtlsForm,index);
			parent.PkgRefundExclDtls.location.href="../../eCommon/html/blank.html";
	}
	var no_of_decimal=parent.PkgRefundSrvDtls.PkgRefundSrvDtlsForm.no_of_decimal.value
		putDecimal(obj,17,no_of_decimal);
	
}
function refundService(obj,index){
	if(parent.PkgRefundExclDtls.PkgRefundExclDtlsForm!=null){		
			saveExclToBean(parent.PkgRefundExclDtls.PkgRefundExclDtlsForm,index);
	}
	parent.PkgRefundExclDtls.location.href="../../eCommon/html/blank.html";
	if(obj.checked){
		obj.value="Y";
		
	}else{
		obj.value="N";
	}
}
function displayExcl(index){

		var formObj=document.PkgRefundSrvDtlsForm;
		if(parent.PkgRefundExclDtls.PkgRefundExclDtlsForm!=null){
		
			saveExclToBean(parent.PkgRefundExclDtls.PkgRefundExclDtlsForm,index);
		}
	
		var pkg_serv_code=eval("formObj.pkg_serv_code"+index).value
	
		var pkg_serv_desc=encodeURIComponent(eval("formObj.pkg_serv_desc"+index).value);
		var no_of_decimal=formObj.no_of_decimal.value
		parent.PkgRefundExclDtls.location.href="../../eBL/jsp/PkgRefundExclDtls.jsp?pkg_code="+formObj.pkg_code.value+"&pkg_seq_no="+formObj.pkg_seq_no.value +"&facility_id="+formObj.facility_id.value+"&patient_id="+formObj.patient_id.value+"&pkg_serv_code="+pkg_serv_code+"&parent_index="+index+"&pkg_serv_desc="+pkg_serv_desc+"&no_of_decimal="+no_of_decimal ;
		
}
function ChkExclRefundAmt(obj,index){
var no_of_decimal=parent.PkgRefundSrvDtls.PkgRefundSrvDtlsForm.no_of_decimal.value
		putDecimal(obj,17,no_of_decimal);
}
function refundExclService(obj,index){
	
	if(obj.checked){
		obj.value="Y";
	}else{
		obj.value="N";
	}
}
function saveExclToBean(formObj,index){
	if(formObj){	
		var parent_index=formObj.parent_index.value;			
		if(parent_index!=index){
			var updation=formValidation(formXMLString(formObj),"saveExclToBean");
		
		}
	}
}

function formValidation(xmlStr,func_mode)
{	   	
	var temp_jsp="PkgRefundValidation.jsp?func_mode="+func_mode;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText ;	
	eval(responseText);
	return true;
}


function apply()
{

	if(PkgRefundFrame.length>0){

		if(PkgRefundFrame.PkgRefundExclDtls.PkgRefundExclDtlsForm!=null){		
			saveExclToBean(PkgRefundFrame.PkgRefundExclDtls.PkgRefundExclDtlsForm,'');
		}
		if(PkgRefundFrame.PkgRefundSrvDtls.PkgRefundSrvDtlsForm!=null){		
				var updation=formValidation(formXMLString(PkgRefundFrame.PkgRefundSrvDtls.PkgRefundSrvDtlsForm),"saveSrvToBean");
				PkgRefundFrame.PkgRefundHdrFrame.PkgRefundHdrForm.submit();
		}else{
			parent.frames[2].frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='
		}
		
	}else{
		//msg=getMessage("BL8661","BL");
		//parent.frames[2].frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+msg
		parent.frames[2].frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='
	}
}

async function onSuccess1(p_from_bill_doc_type,p_from_bill_doc_num,p_to_bill_doc_type,p_to_bill_doc_num)
{		
	var msg =getMessage("BL7335","BL");
	var frmdoctype = "";
	var frmdocnum = "";

	var todoctype = "";
	var todocnum = "";

	if(p_from_bill_doc_num!=p_to_bill_doc_num){		
		alert(msg+':'+p_from_bill_doc_type+"/"+p_from_bill_doc_num+" To "+p_to_bill_doc_type+"/"+p_to_bill_doc_num); 
		frmdoctype = p_from_bill_doc_type;
		frmdocnum = p_from_bill_doc_num;
		todoctype = p_to_bill_doc_type;
		todocnum = p_to_bill_doc_num;

	}else{		
		alert(msg+':'+p_from_bill_doc_type+"/"+p_from_bill_doc_num);
		frmdoctype = p_from_bill_doc_type;
		frmdocnum = p_from_bill_doc_num;
		todoctype = p_from_bill_doc_type;
		todocnum = p_from_bill_doc_num;
	}
	//Calling settlement page for Refund
	var pkg_seq_no=parent.PkgRefundHdrFrame.document.forms[0].pkg_seq_no.value;
	var patient_id=parent.PkgRefundHdrFrame.document.forms[0].patient_id.value;
	var pkg_code=parent.PkgRefundHdrFrame.document.forms[0].pkg_code.value;	
	 var doctype = p_from_bill_doc_type;
	 var docnum = p_from_bill_doc_num;
	 var call_frm = "PKG_RFND";
	 var blnggrp="";
	 var genlater="";
	 var dialogHeight    = '40' ;
	 var dialogWidth = '70' ;	
	 var dialogTop = '100' ;	 
	 var center    = '1'  ;	
	 var arguments =   '';
	 var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +'; dialogTop:' + dialogTop +'; status=no;';	
	//var param="frmdoctype="+frmdoctype+"&"+"frmdocnum="+frmdocnum+"&"+"todoctype="+todoctype+"&"+"todocnum="+todocnum+"&"+"blnggrp="+blnggrp+"&"+"billgenlater="+genlater+"&"+"pkg_seq_no="+pkg_seq_no+"&"+"patient_id="+patient_id+"&"+"pkg_code="+pkg_code+"&"+"call_frm="+call_frm;
	var param="blnggrp="+blnggrp+"&"+"billgenlater="+genlater+"&"+"pkg_seq_no="+pkg_seq_no+"&"+"patient_id="+patient_id+"&"+"pkg_code="+pkg_code+"&"+"call_frm="+call_frm+"&"+"frmdoctype="+frmdoctype+"&"+"frmdocnum="+frmdocnum+"&"+"todoctype="+todoctype+"&"+"todocnum="+todocnum;	
	var getUrl1  = "../../eBL/jsp/BLBillSlmtMain.jsp?"+param	;				
	var retVal = await window.showModalDialog(getUrl1,arguments,features)
	
	parent.parent.document.location.reload();	

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
	//alert("xmlStr from common :"+xmlStr)
	}

	return xmlStr;
}

function CheckForSpecChars_loc(event,obj){
	
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
	if(obj.value.length==0)
	{

		if('_'.indexOf(key)!=-1)
			return false;
	}

    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}




