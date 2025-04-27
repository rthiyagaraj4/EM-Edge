function addImgeRow()
{	
	var mode="";
	var table="";
	var rowCount="";
	var index="";
	var row="";
    	var tableID= 'insImage';

	table = eval("parent.baseDateDtl.document.getElementById('"+tableID+"')");
	var formObj = parent.baseDateDtl.document.forms[0];
	
	var result = true;

	rowCount = table.rows.length; 

	if(result)
	{
	index = rowCount-1;
	row=eval("parent.baseDateDtl.document.getElementById('"+tableID+"')").insertRow(rowCount);
	
	var cell1=row.insertCell(0);
	var cell2=row.insertCell(1);
	var cell3=row.insertCell(2);
	var cell4=row.insertCell(3);
	var cell5=row.insertCell(4);
	var cell6=row.insertCell(5);																						
	var cell7=row.insertCell(6);	
	var cell8=row.insertCell(7);	


	cell1.innerHTML=	"<input type='text' name='payerGroupDesc_"+index+"' id='payerGroupDesc_"+index+"' size='15' maxlength='15'  value=''	onBlur='' ><input type= 'hidden'  name='payerGroupCode_"+index+"' id='payerGroupCode_"+index+"'  value='' REQ_VAL='S' ><input type='button' class='button' name='payerGroupCls_"+index+"' id='payerGroupCls_"+index+"' value='?' onClick='callPlcyLookup(1,payerGroupDesc_"+index+",payerGroupCode_"+index+")'>";
	cell2.innerHTML=	"<input type='text' name='payer_"+index+"' id='payer_"+index+"' size='30' maxlength='30'  value=''  onBlur='' ><input type= 'hidden'  name='payerCode_"+index+"' id='payerCode_"+index+"'  value='' REQ_VAL='S' ><input type='button' class='button' name='payerCls_"+index+"' id='payerCls_"+index+"' value='?' onClick='callPlcyLookup(2,payer_"+index+",payerCode_"+index+",payerGroupCode_"+index+")' >";
	cell3.innerHTML=	"<input type='text' name='plcy_"+index+"' id='plcy_"+index+"' size='30' maxlength='30'  value=''	  onBlur='' ><input type= 'hidden'  name='plcyCode_"+index+"' id='plcyCode_"+index+"'  value='' REQ_VAL='S' ><input type='button' class='button' name='plcyCls_"+index+"' id='plcyCls_"+index+"' value='?' onClick='callPlcyLookup(3,plcy_"+index+",plcyCode_"+index+")' >" ;
	cell4.innerHTML=	"<input type='text' name='plcyNo_"+index+"' id='plcyNo_"+index+"' size='10' maxlength='10'  value=''	  onBlur='' REQ_VAL='S' >";
	cell5.innerHTML=	"<input type='text' name='plcyStartDate_"+index+"' id='plcyStartDate_"+index+"' id='PlcyStartDate_"+index+"' size='10' maxlength='10'  value=''   onBlur='' REQ_VAL='S' ><img id = 'start_img_"+index+"' name='start_img_"+index+"'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('plcyStartDate_"+index+"')\" />";
	cell6.innerHTML=	"<input type='text' name='plcyExpryDate_"+index+"' id='plcyExpryDate_"+index+"' id='PlcyExpryDate_"+index+"' size='10' maxlength='10'  value=''   onBlur='' REQ_VAL='S' ><img id = 'start_img_"+index+"' name='start_img_"+index+"'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('plcyExpryDate_"+index+"')\" />";
	cell7.innerHTML=	"<FORM name='uploadForm_"+index+"' id='uploadForm_"+index+"'><input type='file' name='uploadImageFile_"+index+"' id='uploadImageFile_"+index+"' REQ_VAL='S' ><input type='button' class='button' name='UploadBtn_"+index+"' id='UploadBtn_"+index+"' value='Upload' onClick='uploadFile("+index+" )'> </FORM>";
	cell8.innerHTML=	"<a link=''>&nbsp</a>";
	index++;
	formObj.totRec.value = index;
	}	
}

function validateForm()
{
	headerFrmObj = document.forms[0];
	headerFrmObj.payerGroupDesc.value="";
	headerFrmObj.payer.value="";
	headerFrmObj.plcy.value="";
	if (headerFrmObj.payrGrpCode.value != "" && headerFrmObj.payrCode.value !="" & headerFrmObj.plcyCode.value !="" && headerFrmObj.plcyNo.value!="" && headerFrmObj.plcystartDate.value!="" && headerFrmObj.plcyExpryDate.value !="" )		
		return true;
	else  
		return false;
}

function validateForm_ghl()
{ 
  	var billgrp_name=parent.baseDateDtl.document.forms[0].smt_ind.value;
  	var xmlStr ="<root><SEARCH ";
  	xmlStr +=" /></root>";
  	var xmlDoc = "";
  	var xmlHttp = new XMLHttpRequest();			
  	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
  	var param="billgrp_name="+billgrp_name;
  	var temp_jsp="../../eBL/jsp/BLCommonAjax.jsp?functionMode=validate_settlement1&billgrp_name="+billgrp_name;
  	xmlHttp.open("POST",temp_jsp,false);
  	xmlHttp.send(xmlDoc);
  	responseText = trimString(xmlHttp.responseText);		
  	if(!(responseText=="C"))
  	{
  		headerFrmObj = document.forms[0]; 
  		headerFrmObj.payerGroupDesc.value="";
  		headerFrmObj.payer.value="";
  		headerFrmObj.plcy.value="";
  		if (responseText == "X") {
  			if (headerFrmObj.payrGrpCode.value != "" && headerFrmObj.payrCode.value !="" & headerFrmObj.plcyCode.value !="" && headerFrmObj.plcyNo.value!="" && headerFrmObj.plcystartDate.value!="" && headerFrmObj.plcyExpryDate.value !="" )		
  				return true;
  			else  return false;
  		} else if (responseText == "R") {
  			if (headerFrmObj.payrGrpCode.value != "" && headerFrmObj.payrCode.value !="" )		
  				return true;
  			else  return false;
  		}	
  	}
  else
  	{
  	return true;
  	}
}

//GHL-CRF-0550 starts
function uploadFile_ghl(obj)//obj
{
	if (validateForm_ghl()) {		
		var headerFrmObj = parent.baseDateDtl.document.forms[0];
		var dtlFrmObj = parent.basedtl1.document.forms[0];
		var episode_type_ins = headerFrmObj.episode_type_ins.value; //Added by Shikha for GHL-CRF-0550 #9970 on 28-Apr-2020
		var payrGrpCode = headerFrmObj.payrGrpCode.value;
		var payrCode = headerFrmObj.payrCode.value;
		var plcyCode = headerFrmObj.plcyCode.value;
		var plcyNo = headerFrmObj.plcyNo.value;
		var plcystartDate = headerFrmObj.plcystartDate.value;
		var plcyExpryDate = headerFrmObj.plcyExpryDate.value;
		var cancelChk = headerFrmObj.cancel.value;
		var mode = headerFrmObj.mode.value;
		var totRec = dtlFrmObj.totRec.value;
		headerFrmObj.creditAuthNo.disabled = false;
		headerFrmObj.creditAuthDate.disabled = false;
		/*
		 * if (mode == 'I') { headerFrmObj.index.value = totRec; }
		 */
		//alert("headerFrmObj.docType.value===>"+headerFrmObj.docType.value);
		var uploadImageFile = headerFrmObj.InsImage.value;
		// var uploadImageFileName = uploadImageFile.split(".");
		if(headerFrmObj.docType.value=="" && headerFrmObj.addBut.value=='Add' && headerFrmObj.updateBut.value=='Update')
		{
		alert (getLabel("eBL.docTypeManditory.label","eBL"));
		return false;
		}
		if(headerFrmObj.InsImage.value=="" && headerFrmObj.addBut.value=='Add' && headerFrmObj.updateBut.value=='Update')
		{
	    alert (getLabel("eBL.imageOrPdf.label","eBL"));
		return false;
		}

		if (uploadImageFile != '') {
			var uploadImageFileName = uploadImageFile.substr(
					uploadImageFile.length - 3, uploadImageFile.length);

			if (uploadImageFileName.toUpperCase() == 'PEG')
				uploadImageFileName = uploadImageFile.substr(
						uploadImageFile.length - 4, uploadImageFile.length);
			// Modified V191118-Aravindh/GHL-CRF-0550/Added PDF Type
			if (!((uploadImageFileName.toUpperCase() == 'JPG')
					|| (uploadImageFileName.toUpperCase() == 'JPEG') || (uploadImageFileName
					.toUpperCase() == 'PDF')))// ||
												// uploadImageFileName.toUpperCase()
												// == 'GIF' ||
												// uploadImageFileName.toUpperCase()
												// == 'PNG'||
												// uploadImageFileName.toUpperCase()
												// == 'BMP'||
												// uploadImageFileName.toUpperCase()
												// == 'TIF'))
			{
				/* alert(getMessage("UPLOAD_JPG_OR_GIF_FILE", "SM")); */
				alert("Please upload Jpg/Jpeg/PDF file type file only");
				return;
			}
		}
		document.getElementById('clicked_button').value = obj.name;
		
		// headerFrmObj.butclick.value=obj.name;
		parent.frames[0].document.forms[0].target = 'basedtl1';
		// document.getElementById('clicked_button').submit();
		var retvalue = parent.frames[0].document.forms[0].submit();
		// document.getElementById("IMG_UPLOAD").submit();
		if (cancelChk == 'Y')
			alert('Selected item is cancelled....');
		else if (uploadImageFile != '')
			alert('Image is loaded....');
		// Warning("open");
	} else {
		alert("Some fields doesnt have values");
	}
}
//GHL 0550 CRF --END

function uploadFile()
{
  if(validateForm())
  	{
      var headerFrmObj  =  parent.baseDateDtl.document.forms[0];
      var dtlFrmObj  =  parent.basedtl1.document.forms[0];

      var payrGrpCode		= headerFrmObj.payrGrpCode.value;
      var payrCode		= headerFrmObj.payrCode.value;
      var plcyCode		= headerFrmObj.plcyCode.value;
      var plcyNo			= headerFrmObj.plcyNo.value;
      var plcystartDate	= headerFrmObj.plcystartDate.value;
      var plcyExpryDate	= headerFrmObj.plcyExpryDate.value;
      var cancelChk = headerFrmObj.cancel.value;
      var mode =  headerFrmObj.mode.value;
      var totRec =  dtlFrmObj.totRec.value;
      /*if (mode == 'I')
      	{
      	headerFrmObj.index.value = totRec;
      	}
      */

      var uploadImageFile = headerFrmObj.InsImage.value;
      //	var uploadImageFileName = uploadImageFile.split(".");
      if(uploadImageFile != '' )
      {
        var uploadImageFileName = uploadImageFile.substr(uploadImageFile.length-3,uploadImageFile.length);

      if(uploadImageFileName.toUpperCase() == 'PEG')			 
        uploadImageFileName= uploadImageFile.substr(uploadImageFile.length-4,uploadImageFile.length);			 
      if(!((uploadImageFileName.toUpperCase() == 'JPG')||(uploadImageFileName.toUpperCase() == 'JPEG')))// || uploadImageFileName.toUpperCase() == 'GIF' ||  uploadImageFileName.toUpperCase() == 'PNG'||  uploadImageFileName.toUpperCase() == 'BMP'||  uploadImageFileName.toUpperCase() == 'TIF'))
      {
        /*alert(getMessage("UPLOAD_JPG_OR_GIF_FILE", "SM"));*/
        alert("Please upload Jpg/Jpeg file type file only");
        return;
      }
      }
			
    	parent.frames[0].document.forms[0].target='basedtl1';
    	var	retvalue =	parent.frames[0].document.forms[0].submit();
  	if (cancelChk == 'Y')   
      alert('Selected item is  cancelled....');
  	else	
  	  if(uploadImageFile != '' )	 
      alert('Image is loaded....');
  	}
  	else
  		{
  			alert("Some fields doesnt have values");
  		}
}

function uploadFile_test()
{
if(validateForm())
	{
var headerFrmObj  =  parent.baseDateDtl.document.forms[0];
var dtlFrmObj  =  parent.basedtl1.document.forms[0];

var payrGrpCode		= headerFrmObj.payrGrpCode.value;
var payrCode		= headerFrmObj.payrCode.value;
var plcyCode		= headerFrmObj.plcyCode.value;
var plcyNo			= headerFrmObj.plcyNo.value;
var plcystartDate	= headerFrmObj.plcystartDate.value;
var plcyExpryDate	= headerFrmObj.plcyExpryDate.value;
var cancelChk = headerFrmObj.cancel.value;
var mode =  headerFrmObj.mode.value;
var totRec =  dtlFrmObj.totRec.value;
/*if (mode == 'I')
	{
	headerFrmObj.index.value = totRec;
	}
*/

var uploadImageFile = headerFrmObj.InsImage.value;
//	var uploadImageFileName = uploadImageFile.split(".");

if(headerFrmObj.docType.value=="" && headerFrmObj.addBut.value=='Add' && headerFrmObj.updateBut.value=='Update')
{
  alert (getLabel("eBL.docTypeManditory.label","eBL"));
  return false;
}

if(headerFrmObj.InsImage.value=="" && headerFrmObj.addBut.value=='Add' && headerFrmObj.updateBut.value=='Update')
{
  alert (getLabel("eBL.imageOrPdf.label","eBL"));
  return false;
}

	if(uploadImageFile != '' )
		{
		 var uploadImageFileName = uploadImageFile.substr(uploadImageFile.length-3,uploadImageFile.length);

		 if(uploadImageFileName.toUpperCase() == 'PEG')			 
			 uploadImageFileName= uploadImageFile.substr(uploadImageFile.length-4,uploadImageFile.length);			 
		if(!((uploadImageFileName.toUpperCase() == 'JPG')||(uploadImageFileName.toUpperCase() == 'JPEG')))// || uploadImageFileName.toUpperCase() == 'GIF' ||  uploadImageFileName.toUpperCase() == 'PNG'||  uploadImageFileName.toUpperCase() == 'BMP'||  uploadImageFileName.toUpperCase() == 'TIF'))
		{
				/*alert(getMessage("UPLOAD_JPG_OR_GIF_FILE", "SM"));*/
				alert("Please upload Jpg/Jpeg file type file only");
				return;
		}
		}
			
	parent.frames[0].document.forms[0].target='basedtl1';
	var	retvalue =	parent.frames[0].document.forms[0].submit();
	if (cancelChk == 'Y')   alert('Selected item is cancelled....');
	else	
	if(uploadImageFile != '' )	 alert('Image is loaded....');
	}
	else
		{
			alert("Some fields doesnt have values");
		}
}

function  showImage()
{	
	parent.frames[1].document.location.href="../../eBL/jsp/AddModifyInsUpldImgDtl.jsp";	
	/* var headerFrmObj  =  parent.baseDateDtl.document.forms[0];
	if(headerFrmObj.InsImage.value!="" && headerFrmObj.docType.value!="" )
 */	resetHdr();	
}

function  showImage_ghl()
{	
    //GHL-CRF-0550.1
    var policy_no=parent.basedtl1.document.forms[0].policy_no.value;
    var smt_ind=parent.basedtl1.document.forms[0].smt_ind.value;
    var patient_id=parent.basedtl1.document.forms[0].patient_id.value;
    parent.frames[1].document.location.href="../../eBL/jsp/AddModifyInsUpldImgDtl.jsp?&policy_no="+policy_no+"&settlement_ind="+smt_ind+"&patient_id="+patient_id;
    //GHL-CRF-0550.1
    var headerFrmObj  =  parent.baseDateDtl.document.forms[0];
    if(headerFrmObj.InsImage.value!="" && headerFrmObj.docType.value!="" )
    resetHdr_ghl();
}

function insertData()
{ 
	parent.frames[0].document.forms[0].dbload.value ='Y';
	parent.frames[0].document.forms[0].target='basedtl1';
	parent.frames[0].document.forms[0].submit();
	parent.frames[1].document.location.href="../../eBL/jsp/AddModifyInsUpldImgDtl.jsp";
}
function resetHdr()
{
	var headerFrmObj  =  parent.baseDateDtl.document.forms[0];

headerFrmObj.reset();
headerFrmObj.payerGroupDesc.value="";
headerFrmObj.payer.value="";
headerFrmObj.plcy.value="";

headerFrmObj.payrGrpCode.value="";
headerFrmObj.payrCode.value="";
headerFrmObj.plcyCode.value="";
headerFrmObj.plcyNo.value="";
headerFrmObj.plcystartDate.value="";
headerFrmObj.plcyExpryDate.value="";
//headerFrmObj.index.value ='0';
headerFrmObj.mode.value ='I';
headerFrmObj.InsImage.value ="";
headerFrmObj.CancelChk.checked = false;
headerFrmObj.CancelChk.disabled = true;
}

//GHL-CRF-0550 starts
function resetHdr_ghl()
{
	var headerFrmObj  =  parent.baseDateDtl.document.forms[0];
	headerFrmObj.reset();
	headerFrmObj.blngGroupDesc.value="";
	headerFrmObj.payerGroupDesc.value="";
	headerFrmObj.payer.value="";
	headerFrmObj.plcy.value="";
	headerFrmObj.payrGrpCode.value="";
	headerFrmObj.payrCode.value="";
	headerFrmObj.plcyCode.value="";
	headerFrmObj.plcyNo.value="";
	headerFrmObj.plcystartDate.value="";
	headerFrmObj.plcyExpryDate.value="";
	headerFrmObj.plcyExpryDate.value="";
	headerFrmObj.mode.value ='I';
	headerFrmObj.InsImage.value ="";
	headerFrmObj.CancelChk.checked = false;
	headerFrmObj.CancelChk.disabled = true;
	headerFrmObj.creditAuthNo.value="";
	headerFrmObj.creditAuthDate.value="";
  headerFrmObj.docType.value = "";
  headerFrmObj.docRemarks.value="";
}
//GHL-CRF-0550 ENDSS
function formInsValidation(xmlStr)
{	
	var temp_jsp="InsImgValidation.jsp";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText ;
	eval(responseText);
	return true;
}

function formXMLInsStringMain(frmObj)
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
			
		if(arrObj[i].REQ_VAL == 'S' )
		{
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
	}
	xmlStr +=" /></root>";	
	}
	return xmlStr;
}

function persistInsBean()
{
  var headerFrmObj  =  parent.baseDateDtl.document.forms[0];
	if( headerFrmObj!=null && headerFrmObj != undefined )
			{					
				var xmlString=formXMLInsStringMain(headerFrmObj);				
				var updation=formInsValidation(xmlString);				
				 parent.close();
			}
}

function callPlcyLookup(sqlSelect,obj,code,pyg){	
	var locale = document.forms[0].locale.value;

	var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';

	switch(sqlSelect){			
		
		case 1:
		{
			sql="select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and language_id = '"+locale+"' and upper(long_desc) like upper(?) and upper(cust_group_code) like upper(?) order by 2";
			break;
		}
 	case 2:
		{
			var cust_code = pyg.value;
			sql="Select long_name description,cust_code code from ar_customer_lang_vw Where cust_group_code ='"+cust_code+"' and language_id = '"+locale+"' and upper(long_name) like upper(?) and upper(cust_code) like upper(?) order by 2";
			break;
		}

		case 3:
		{
			sql="select long_desc description,policy_type_code code from bl_ins_policy_types_lang_vw where nvl(status,'A') !='S' and operating_facility_id = '"+facility_id+"' and language_id= '"+locale+"' and upper(long_desc) like upper(?) and upper(policy_type_code) like upper(?) order by 2";
			break;
		}			
	}


	//var sql="SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues = CommonLookup("Legend", argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[1];
		code.value = returnedValues[0];	
	}
else
	{
	obj.value = '';
	code.value = '';		
		//obj.value = returnedValues[1];
	}
}

function uploadFile1()
{	
	var filePath =""; 
	var uploadImageFile = document.forms[0].uploadImageFile.value;
	//	var uploadImageFileName = uploadImageFile.split(".");

	if(uploadImageFile != '' )
	{
		var uploadImageFileName = uploadImageFile.substr(uploadImageFile.length-3,uploadImageFile.length);
		 if(uploadImageFileName.toUpperCase() == 'PEG')			 
			 uploadImageFileName= uploadImageFile.substr(uploadImageFile.length-4,uploadImageFile.length);	

//		if(uploadImageFileName.toUpperCase() == 'JPG' || uploadImageFileName.toUpperCase() == 'GIF' ||  uploadImageFileName.toUpperCase() == 'PNG'||  uploadImageFileName.toUpperCase() == 'BMP'||  uploadImageFileName.toUpperCase() == 'TIF')
		if((uploadImageFileName.toUpperCase() == 'JPG') || (uploadImageFileName.toUpperCase() == 'JPEG'))
		{
			//parent.fileUploadFrame.document.LISImgFileUploadForm.action= applServerURL+'servlet/LISImage.ManageLISSpecimenImageServlet';
			//alert('Before Invoking servlet ' + applServerURL);//Sanjay
			/*
			parent.fileUploadFrame.document.LISImgFileUploadForm.action= applServerURL+'servlet/eBT.ManageLISSpecimenImageServlet';			
			parent.fileUploadFrame.document.LISImgFileUploadForm.target = 'messageFrame';
			parent.fileUploadFrame.document.LISImgFileUploadForm.method = 'post';
			parent.fileUploadFrame.document.LISImgFileUploadForm.submit();
			*/
			//alert('Start');//Sanjay
			parent.fileUploadFrame.document.LISImgFileUploadForm.method = 'POST';
			//alert('method');//Sanjay
			//parent.fileUploadFrame.document.LISImgFileUploadForm.action = '../../servlet/eBT.ManageLISSpecimenImageServlet';
			parent.fileUploadFrame.document.LISImgFileUploadForm.action = "../../servlet/eBT.ManageLISSpecimenImageServlet?filePath="+filePath;
			//alert('action');//Sanjay
			parent.fileUploadFrame.document.LISImgFileUploadForm.target = 'messageFrame';
			//alert('target');//Sanjay
			parent.fileUploadFrame.document.LISImgFileUploadForm.submit();
			//alert('submit');//Sanjay
			/*
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root></root>";
			//param="flag=MED_SER&sql="+sql;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			alert('After load ');//Sanjay
			xmlHttp.open("POST", "../../servlet/eBT.ManageLISSpecimenImageServlet");
			alert('After open ');//Sanjay
			xmlHttp.send(xmlDoc);
			alert('After send ');//Sanjay
			//var retVal = localTrimString(xmlHttp.responseText);
			//alert('After retVal ' + retVal);//Sanjay
			//return retVal;	
			*/		
		}
		else
		{
			//alert(getCAMessage("FILE_TYPE_NOT_ALLOWED"))//Sanjay
			//alert(getMessage("UPLOAD_JPG_OR_GIF_FILE", "SM"));
			alert("Please upload Jpg/Jpeg file type file only");
		}
	}		
}

async function episodeLookup(obj,code){
	//alert("5");
	var frm = document.forms[0];
	var patient_id = frm.patient_id.value;
	var episode_type = frm.episode_type.value;
	var episode_id = obj.value;	

	/*if(patient_id.length<1){
		alert("Enter Patient Id");
		return false;
	}*/
	if(episode_type.length<1){
		alert("Select Episode Type");
		return false;
	}
	
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	var dialogHeight= "20" ;
	var dialogWidth	= "40" ;
	var dialogTop = "225" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;	
	//var modPatientId = document.getElementById("hiddenPatientId").value;
	var url = "../../eBL/jsp/AddModifyInsUpldImgPayerData.jsp?patient_id="+patient_id+'&episode_type='+episode_type+'&episode_id='+episode_id+'&facility_id='+facility_id;
	retVal = await window.showModalDialog(url,arguments,features); 
	if(retVal != undefined){
		frm.episode_id.value = retVal.episodeId;
		frm.hdnEpisode_id.value = retVal.episodeId;
		frm.payerGroupDesc.value = retVal.payerGroupDesc;
		frm.payrGrpCode.value = retVal.payerGroupCode;
		frm.payer.value = retVal.payerDesc;
		frm.payrCode.value = retVal.payerCode;
		frm.plcy.value = retVal.policyDesc;
		frm.plcyCode.value = retVal.policyCode;
		frm.plcyNo.value = retVal.policyNo;
		frm.plcystartDate.value = retVal.startDate;
		frm.plcyExpryDate.value = retVal.endDate;
		frm.blngGroupDesc.value = retVal.short_desc;
		frm.episode_id.focus();		
		document.getElementById("Add").disabled=true;//// Added for GHL0550
	}
	else{
		frm.episode_id.value = '';
		frm.hdnEpisode_id.value = '';
		frm.payerGroupDesc.value = '';
		frm.payrGrpCode.value = '';
		frm.payer.value = '';
		frm.payrCode.value = '';
		frm.plcy.value = '';
		frm.plcyCode.value = '';
		frm.plcyNo.value = '';
		frm.plcystartDate.value = '';
		frm.plcyExpryDate.value = '';
		frm.blngGroupDesc.value	= '';	
	}
}

function retuenPayerData(episodeId,payerGroupCode,payerGroupDesc,payerCode,payerDesc,policyCode,policyDesc,policyNo,startDate,endDate,short_desc){
	var obje = new Object();
	obje.episodeId = episodeId;
	obje.payerGroupCode = payerGroupCode;
	obje.payerGroupDesc = payerGroupDesc;
	obje.payerCode = payerCode;
	obje.payerDesc = payerDesc;
	obje.policyCode = policyCode;
	obje.policyDesc = policyDesc;
	obje.policyNo = policyNo;
	obje.startDate = startDate;
	obje.endDate = endDate;
	obje.short_desc=short_desc;

	window.returnValue = obje;
	window.close();
}

function trimString(sInString) {
	  return sInString.replace(/^\s+|\s+$/g,"");
}

function clearPayerFields(){
	var frm = document.forms[0];
	frm.episode_id.value = '';
	frm.hdnEpisode_id.value = '';
	frm.payerGroupDesc.value = '';
	frm.payrGrpCode.value = '';
	frm.payer.value = '';
	frm.payrCode.value = '';
	frm.plcy.value = '';
	frm.plcyCode.value = '';
	frm.plcyNo.value = '';
	frm.plcystartDate.value = '';
	frm.plcyExpryDate.value = '';
	document.getElementById("Add").disabled=false;// Added for GHL0550
}

//GHL 0550 -PALANI NARAYANAN
function episodetypevalidation()
{ 
	var frm = document.forms[0];
	var patient_id = frm.patient_id.value;
	var episode_type = frm.episode_type.value;
	var episode_id = frm.episode_id.value;  //Added by Shikha for GHL-CRF-0550 #9970 on 28-Apr-2020
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();			
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var temp_jsp="../../eBL/jsp/BLCommonAjax.jsp?functionMode=validateEpisodeTypeData&patient_id="+patient_id+"&episode_type=" + episode_type+"&episode_id="+episode_id;	//Added by Shikha for GHL-CRF-0550 #9970 on 28-Apr-2020
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText = trimString(xmlHttp.responseText);	
	if(responseText=="true")
	{
		parent.frames[1].document.location.href="../../eBL/jsp/AddModifyInsUpldImgDtlNew.jsp";	//GHL-CRF-0550.1	
	}
}
//GHL 0550 -PALANI NARAYANAN ENDS-->

//function episodetypevalidationTwotier(patientid,episodetype,callingfrom2T,policynumber,billinggroup)//GHL 0550 -PALANI NARAYANAN  FRO 2 TIER CHANGES - STARTS
async function episodetypevalidationTwotier(patientid,episodetype,callingfrom2T,policynumber,encounterid)//GHL 0550 -PALANI NARAYANAN  FRO 2 TIER CHANGES - STARTS
{ 
	
	var patient_id = patientid;
	var episode_type = episodetype;
	var calling_from_2T=callingfrom2T;
	var policy_number=policynumber;
	//var billing_group=billinggroup;
	var encounter_id=encounterid;
	
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();			
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	///var param="billgrp_name="+billgrp_name;
	var temp_jsp="../../eBL/jsp/BLCommonAjax.jsp?functionMode=validateEpisodeTypeDataTwoTier&patient_id="+patient_id+"&episode_type=" + episode_type+"&policy_number=" + policy_number+"&encounter_id=" + encounter_id; 
																								
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText = trimString(xmlHttp.responseText);	
	//alert("662-->return-->"+responseText);
	if(responseText=="true")
	{
	//parent.frames[1].document.location.href="../../eBL/jsp/AddModifyInsUpldImgDtl.jsp";	
	//var dialogUrl       = "../../eBL/jsp/AddModifyInsUpldImgDtl.jsp" ;
	//window.open(dialogUrl);
	var dialogUrl       = "../../eBL/jsp/AddModifyInsUpldImgDtlNew.jsp?patient_id=" +patient_id+"&calling_from_2T="+calling_from_2T;
	var dialogFeatures  = "dialogHeight:" + "20" + "; dialogWidth:" + "70" +" ; scroll=auto; ";
	var returnVal =await window.showModalDialog(dialogUrl,null,dialogFeatures);	
	}
	}
//GHL 0550 -PALANI NARAYANAN ENDS-->


//GHL 0550  PALANI NARAYANAN ----starts
function disableButton(obj)
{
	var creditAuthNum =getLabel("eBL.AuthorizationLetter.label","eBL");
	var  current_creditAuthNum=document.getElementById("docRemarks").value;
	if(obj.value=="Add")
	{
		document.getElementById("updateBut").disabled=true;
		if(creditAuthNum==current_creditAuthNum)
		{
		document.getElementById("creditAuthNo").disabled=true;
		document.getElementById("creditAuthDate").disabled=true;
		}
	}
else if(obj.value=="Update")	
	{
		document.getElementById("addBut").disabled=true;
	}
else if(obj.value=='Remove')
	{
		document.getElementById("updateBut").disabled=true;	
	}
else
	{
		document.getElementById("addBut").disabled=false;
		document.getElementById("updateBut").disabled=false;
	}
	//GHL 0550  PALANI NARAYANAN ----ENDS
}

