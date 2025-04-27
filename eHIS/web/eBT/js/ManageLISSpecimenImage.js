function reset()
{
	LISSpecQueryFrame.location.reload();
	LISSpecResultFrame.location.href = '../../eCommon/html/blank.html';
}

function populatecatNum(obj)

{
	parent.LISSpecBlankFrame.document.write("<html><body><form name='LISImageForm' id='LISImageForm' method = 'post' action='../../eBT/jsp/ManageLISSpecimenImageIntermediate.jsp'><input type='hidden' name='dept' id='dept' value=\""+obj.value+"\"></form></body></html>");
	parent.LISSpecBlankFrame.document.LISImageForm.submit();	
}

function populateDetailBlock()
{
	var secCode = parent.LISSpecQueryFrame.document.LISSpecQueryForm.deptLISImg.value;
	var fromSpecNum = parent.LISSpecQueryFrame.document.LISSpecQueryForm.fromSpecNum.value;
	var toSpecNum = parent.LISSpecQueryFrame.document.LISSpecQueryForm.toSpecNum.value;
	var fromSpecRegdDate = parent.LISSpecQueryFrame.document.LISSpecQueryForm.fromSpecRegdDate.value;
	var toSpecRegdDate = parent.LISSpecQueryFrame.document.LISSpecQueryForm.toSpecRegdDate.value;
	var fromCatNum = parent.LISSpecQueryFrame.document.LISSpecQueryForm.fromCatNum.value;
	var frmCatYr = parent.LISSpecQueryFrame.document.LISSpecQueryForm.frmCatYr.value;
	var frmCatNoPart = parent.LISSpecQueryFrame.document.LISSpecQueryForm.frmCatNoPart.value;
	var toCatNum = parent.LISSpecQueryFrame.document.LISSpecQueryForm.toCatNum.value;
	var toCatYr = parent.LISSpecQueryFrame.document.LISSpecQueryForm.toCatYr.value;
	var toCatNoPart = parent.LISSpecQueryFrame.document.LISSpecQueryForm.toCatNoPart.value;
	var priority = parent.LISSpecQueryFrame.document.LISSpecQueryForm.priority.value;
	if(secCode != '')
	{		
		parent.LISSpecResultFrame.location.href = '../../eBT/jsp/ManageLISSpecimenImageResult.jsp?secCode='+secCode+'&fromSpecNum='+fromSpecNum+'&toSpecNum='+toSpecNum+'&fromSpecRegdDate='+fromSpecRegdDate+'&toSpecRegdDate='+toSpecRegdDate+'&fromCatNum='+fromCatNum+'&toCatNum='+toCatNum+'&priority='+priority+'&frmCatYr='+frmCatYr+'&frmCatNoPart='+frmCatNoPart+'&toCatYr='+toCatYr+'&toCatNoPart='+toCatNoPart;
	}
	else if(secCode == '')
	{
		//alert(getCAMessage("DEPT_NOT_BLANK"));//Sanjay
		alert(getMessage("DEPT_NOT_BLANK", "BT"));
		return;
	}
}

function specimenDetails(specNum)
{
	var secCode = parent.LISSpecQueryFrame.document.LISSpecQueryForm.deptLISImg.value;
	var dialogTop		=	"150" ;
	var dialogHeight= "30" ;
	var dialogWidth = "45" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url		=	'../../eBT/jsp/ManageLISSpecimenImageUploadMain.jsp?secCode='+secCode+'&specNum='+specNum;	
	alert(action_url);
	var retVal=window.showModalDialog(action_url,arguments,features);
}

function backtoMenu()
{
	parent.location.href='../../eCommon/jsp/dmenu.jsp';
}

function resetForm()
{
	document.LISSpecQueryForm.reset();
	parent.LISSpecResultFrame.location.href = '../../eCA/jsp/blank.jsp'
}

//Modified by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800)
function showUploadPage(specNum,test,sampleId,secCode,anatomy)
{	
	parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp';//Sanjay	
	parent.fileUploadFrame.location.href = '../../eBT/jsp/ManageLISSpecimenImageFileUpload.jsp?specNum='+specNum+'&test='+test+'&sampleId='+sampleId+'&secCode='+secCode+'&anatomy='+anatomy;
	
	
}

function uploadFile()
{	
	var filePath = document.forms[0].filePath.value;
	var pathExist = document.forms[0].pathExist.value;
	var writeAccess = document.forms[0].writeAccess.value;
	var applServerURL = document.forms[0].applServerURL.value;
	var uploadImageFile = document.forms[0].uploadImageFile.value;
	//below line commented by Sanjay against IN050612 to include . in Folder Name while uploading image from user PC
	//var uploadImageFileName = uploadImageFile.split(".");
	//var uploadImageFileType = uploadImageFile.substr(uploadImageFile.length - 3);	

	//below line added by Sanjay against IN050612 to include . in Folder Name while uploading image from user PC
	var uploadImageFileType = uploadImageFile.substr(uploadImageFile.lastIndexOf(".")+1, uploadImageFile.length);
	if(filePath==""){
		alert("Configured file path is empty");
	}
	else if(pathExist=="false"){
		alert("Configured file path - '"+filePath+"' does not exist");
	}
	else if(writeAccess=="false"){
		alert("Configured file path - '"+filePath+"' does not have write access");
	}
	else{
	if(uploadImageFile != '' )
	{
		//below line commented by Sanjay against IN050612 to include . in Folder Name while uploading image from user PC
		//if((uploadImageFileName[1].toUpperCase() == 'JPG' || uploadImageFileName[1].toUpperCase() == 'GIF' ||  uploadImageFileName[1].toUpperCase() == 'PNG' || uploadImageFileName[1].toUpperCase() == 'PDF' || uploadImageFileName[1].toUpperCase() == 'TIF'))

		//below line added by Sanjay against IN050612 to include . in Folder Name while uploading image from user PC
		if((uploadImageFileType.toUpperCase() == 'JPG' || uploadImageFileType.toUpperCase() == 'GIF' ||  uploadImageFileType.toUpperCase() == 'PNG' || uploadImageFileType.toUpperCase() == 'PDF' || uploadImageFileType.toUpperCase() == 'TIF'))
		{			
			parent.fileUploadFrame.document.LISImgFileUploadForm.method = 'POST';			
			//parent.fileUploadFrame.document.LISImgFileUploadForm.action = '../../servlet/eBT.ManageLISSpecimenImageServlet';
			parent.fileUploadFrame.document.LISImgFileUploadForm.action = "../../servlet/eBT.ManageLISSpecimenImageServlet?filePath="+filePath;
			parent.fileUploadFrame.document.LISImgFileUploadForm.target = 'messageFrame';
			parent.fileUploadFrame.document.LISImgFileUploadForm.submit();
		}
		else
		{
			//alert(getCAMessage("FILE_TYPE_NOT_ALLOWED"))//Sanjay
			alert(getMessage("UPLOAD_PROPER_FILE_TYPE", "BT"));
		}
	}
	else
		{
			//alert(getCAMessage("FILE_TYPE_NOT_ALLOWED"))//Sanjay
			alert("Uploaded file path cannot be empty");
		}
	}
}

function showCalendarValidate(str)
{
	var flg = showCalendar(str,null,'hh:mm');
	document.getElementById(str).focus();
	return flg;
}

function checkForCurrentDate(objFromToDate)
{
	var currDate = document.forms[0].sysDate.value;
	var fromDate1 = objFromToDate.value;
	//alert('currDate' + currDate);//sanjay
	//alert('fromDate1' + fromDate1);//sanjay

	if(fromDate1 !="")
	{
		fromDate = fromDate1.split(" ");
		
		var retVal = checkDt(fromDate[0]);
		
		if(retVal)
		{
			
			var splitdate =fromDate[0].split("/")
			var splitdate1 =currDate.split("/")
			var from_date  =new Date(eval(splitdate[2]), eval(splitdate[1])-1, eval(splitdate[0]))
			var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]))
			if(Date.parse(to_date) < Date.parse(from_date))
			{
				//alert(getCAMessage("FROM_DATE_GREATER_SYSDATE"))						
				alert(getMessage("FROMTO_DATE_GRTR_THAN_CURR_DATE", "BT"));
				objFromToDate.select();
				return false		   
			}
			else
			return true;
		}
		else
		{
			return true;
		}
	} 
}

function CheckDateTime(objText)
{
	
	if(objText.value !='')
	{		
		if(!doDateTimeChk(objText))
		{
			// Commented by Sanjay for 10.x migration
			//alert(getCAMessage("INVALID_DATE_FMT"))
			alert(getMessage('INVALID_DATE_FMT','SM'));
			objText.select();
			return false
		}
		else
		{
			var dateArray=objText.value.split(" ");
			var timeArray=dateArray[0].split("/");
			if(parseInt(timeArray[2],10)==0)
			{
				// Commented by Sanjay for 10.x migration
				//alert(getCAMessage("INVALID_DATE_FMT"))
				alert(getMessage('INVALID_DATE_FMT','SM'));
				objText.select();
				return false
			}
		}
	}
}

function ValidateDateTimeOfPeriod(Objfrom,objTo)
{
	if(objTo.value !="" && Objfrom.value != "")
	{
		if(!ValidateDateTime(Objfrom,objTo))
		{
			//alert(getCAMessage("TO_DT_GR_EQ_FM_DT"))
			alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
			objTo.select();
			return false
		}
	}
}

// Sanjay added on 08-May-13 STARTS
function chkDelete(interfaceFileId, chkavilable)
{
	var frmObj= document.forms[0];
	var interfaceFileIdTemp = "";
	var temp = "";
	if (chkavilable.checked)
	{
		if (frmObj.hdInterfaceFileId.value.indexOf(interfaceFileId) > 0)
		{
			//alert("Checked If interfaceFileId:" + frmObj.hdInterfaceFileId.value);
		}
		else {
			interfaceFileIdTemp = frmObj.hdInterfaceFileId.value;
			if (interfaceFileIdTemp.length > 0)
			{
				frmObj.hdInterfaceFileId.value = interfaceFileIdTemp + "," + interfaceFileId;
			}
			else 
			{
				frmObj.hdInterfaceFileId.value = interfaceFileId;
			}						
		}
		//alert("Checked else interfaceFileId:" + frmObj.hdInterfaceFileId.value);		
	}
	else
	{		
		interfaceFileIdTemp = "";
		interfaceFileIdTemp = frmObj.hdInterfaceFileId.value;								
		frmObj.hdInterfaceFileId.value = interfaceFileIdTemp.replace(','+interfaceFileId, '');			
		frmObj.hdInterfaceFileId.value = interfaceFileIdTemp.replace(interfaceFileId+',', '');			
		frmObj.hdInterfaceFileId.value = interfaceFileIdTemp.replace(interfaceFileId, '');
	}
	if (frmObj.hdInterfaceFileId.value.indexOf(',,') > 0)
	{
		interfaceFileIdTemp = "";
		interfaceFileIdTemp = frmObj.hdInterfaceFileId.value;
		frmObj.hdInterfaceFileId.value = interfaceFileIdTemp.replace(',,', ',');
	}
	//checking if , is the first character
	if (frmObj.hdInterfaceFileId.value.indexOf(',') < 1 && frmObj.hdInterfaceFileId.value.indexOf(',') > -1)
	{
		interfaceFileIdTemp = "";
		interfaceFileIdTemp = frmObj.hdInterfaceFileId.value;
		interfaceFileIdTemp = interfaceFileIdTemp.substring(1, interfaceFileIdTemp.length);
		frmObj.hdInterfaceFileId.value = interfaceFileIdTemp;
	}
	interfaceFileIdTemp = "";
	interfaceFileIdTemp = frmObj.hdInterfaceFileId.value;
	//checking if , is the last character
	if (interfaceFileIdTemp.charAt(interfaceFileIdTemp.length-1) == ',')
	{
		interfaceFileIdTemp = "";
		interfaceFileIdTemp = frmObj.hdInterfaceFileId.value;
		interfaceFileIdTemp = interfaceFileIdTemp.substring(0, interfaceFileIdTemp.length-1);
		frmObj.hdInterfaceFileId.value = interfaceFileIdTemp;
	}

	
	interfaceFileIdTemp = "";
	interfaceFileIdTemp = frmObj.hdInterfaceFileId.value;
	//Variable to delete the File in Physical location
}
/*
function applyAll()
{
	var frmObj= document.forms[0];
	var cnt = frmObj.cnt.value;
	cnt = parseInt(cnt)-1;
	alert("applyAll cnt-->" + cnt);
	//var chk
	var obj = frmObj.chkavilable2;
	alert("chkDelete:" + obj.checked);
}
*/
function applyAll()
{	
	var frmObj= document.forms[0];	
	var filePath = frmObj.filePath.value;	
	var interfaceFileIdTemp = frmObj.hdInterfaceFileId.value;
	var hdInterfaceFileId = "";
	// added by sanjay against Bru-HIMS-CRF-052.1 for Linked incident to delete more than 3 uploaded Images 
	hdInterfaceFileId = interfaceFileIdTemp.split(",").join("','")	

	var params = frmObj.params.value;	
	if(hdInterfaceFileId != '' )
	{
		document.showImageLinksForm.method = 'POST';
		document.showImageLinksForm.action = "../../servlet/eBT.ManageLISSpecimenImageServlet?hdInterfaceFileId="+hdInterfaceFileId+"&hdInterfaceFileId1="+interfaceFileIdTemp+"&Path="+filePath+"&filePath=";
		document.showImageLinksForm.target = 'messageFrame';
		document.showImageLinksForm.submit();
		alert("APP-SM0001 Operation Completed Successfully ...");//Added by Nandhini.
		window.close();
		//Sanjay		
	}
	else
	{	
		alert(getMessage("NO_IMAGE_TO_DELETE", "BT"));
	}
}

function resetAll()
{
	//var frmObj= document.forms[0];
	//var obj = frmObj.chkavilable;
	//alert("resetAll");
	window.close();
}
// Sanjay added on 08-May-13 ENDS

//Modified by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800)
function viewUploadedImg(specNum, test, sampleId, secCode, anatomy, recCount, facility_id)
{	
	var p_resp_id = document.uploadLinkForm.p_resp_id.value;
	var calledFromForms = document.uploadLinkForm.calledFromForms.value;	

	//added calledFromForms by Sanjay for removing Delete Option when viewed from Review
	parent.fileUploadBlankFrame.document.write("<html><head><title>Specimen Image</title></head><body><form name='LISImageForm' id='LISImageForm' method = 'post' action='../../eBT/jsp/ManageLISSpecimenImageIntermediate.jsp'><input type='hidden' name='specNum' id='specNum' value=\""+specNum+"\"><input type='hidden' name='test' id='test' value=\""+test+"\"><input type='hidden' name='sampleId' id='sampleId' value=\""+sampleId+"\"><input type='hidden' name='secCode' id='secCode' value=\""+secCode+"\"><input type='hidden' name='anatomy' id='anatomy' value=\""+anatomy+"\"><input type='hidden' name='recCount' id='recCount' value=\""+recCount+"\"><input type='hidden' name='calledFromForms' id='calledFromForms' value=\""+calledFromForms+"\"><input type='hidden' name='calledFrom' id='calledFrom' value='viewImage'><input type='hidden' name='facility_id' id='facility_id' value='"+facility_id+"'><input type='hidden' name='p_resp_id' id='p_resp_id' value='"+p_resp_id+"'></form></body></html>");
	parent.fileUploadBlankFrame.document.LISImageForm.submit();
}

async function imageView(specNum,testCode,sampleId,secCode,anatomyCode,facilityId,interfaceFileId)
{
	var applServerURL = document.showImageLinksForm.applServerURL.value;	
	var temp1 = interfaceFileId.split(".");
	var dialogHeight	= "570";
	var dialogWidth		= "790";
	var dialogTop		= "0";
	var dialogLeft		= "0";
	var center			= "1";
	var status			= "no";
	var scrollbars      = "yes";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; scrollbars: " + scrollbars + "; dialogTop: " + dialogTop;
	var arguments		= "";
	
	// added by Sanjay against MO-GN-5462 [IN:050800] on 02-Sep-14
	var win = await window.showModalDialog("../../eBT/jsp/ManageLISShowImageFrame.jsp?specNum="+specNum+"&interfaceFileId="+encodeURIComponent(interfaceFileId)+"&test="+testCode+"&sampleId="+sampleId+"&secCode="+secCode+"&anatomy="+anatomyCode+"&facility_id="+facilityId,'Document','dialogWidth:80;center:yes;dialogTop:100;location:no;menubar:no;status:no;');
}

function staticTr()
{
	var x = document.body.scrollTop;
	if(x == 0)
	{
		document.getElementById("imageResTr").style.position = 'relative';
		document.getElementById("imageResTr").style.posTop  = 0;
	}
	else
	{
		document.getElementById("imageResTr").style.position = 'relative';
		document.getElementById("imageResTr").style.posTop  = x-2;
	}	
}

function populateCatYear(obj, sysYear)
{
	if(obj.value != '')
	{
		if(obj.name == 'fromCatNum')
		document.LISSpecQueryForm.frmCatYr.value = sysYear;
		else if(obj.name == 'toCatNum')
		document.LISSpecQueryForm.toCatYr.value = sysYear;
	}
	else
	{
		if(obj.name == 'fromCatNum')
		document.LISSpecQueryForm.frmCatYr.value = '';
		else if(obj.name == 'toCatNum')
		document.LISSpecQueryForm.toCatYr.value = '';
	}
}

