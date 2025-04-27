var prevObjID;
var prevImgObj;
var window_id = "";

function getMessageFrame(){
	if(top.content!=null){
		return top.content.messageFrame;
	}else{
		return top.messageframe;
	}
}
var messageFrameReference = getMessageFrame();

function checkFilevalue(obj){ 
	return false;
}

function clearFileName(tagId, called_from){
	if(called_from == undefined || called_from == ''){
		parent.ImageVideosFileUploadDisplayFrame.document.location.href = '../../eCommon/html/blank.html';
		top.ImageVideosFileUploadFrame.document.getElementById("uploadFile_div").innerHTML=top.ImageVideosFileUploadFrame.document.getElementById("uploadFile_div").innerHTML;
		//top.ImageVideosFileUploadFrame.document.ImageVideosFileUploadForm.filetype.value="";
		top.ImageVideosFileUploadFrame.document.ImageVideosFileUploadForm.filetype[0].checked=true;
		top.ImageVideosFileUploadFrame.document.ImageVideosFileUploadForm.uploadremarks.value="";
		top.ImageVideosFileUploadFrame.document.ImageVideosFileUploadForm.fileuploadname.value="";
		//IN70150 start
		top.ImageVideosFileUploadFrame.document.getElementById("fileRefVideo").style.visibility = "hidden";		
		top.ImageVideosFileUploadFrame.document.getElementById("uploadFile_div").style.visibility = "visible";	
		//IN70150 end
		top.ImageVideosFileUploadToolbarFrame.document.ImageVideosFileUploadToolbarForm.record_sec.disabled = false;
	}
}

function checkMaxLimitnew(obj,maxSize){
	if ( obj.value.length >= maxSize ){
		var error = getMessage("OBJ_CANNOT_EXCEED","Common");
		error = error.replace("$",maxSize);
		alert(error);
		obj.focus();
		return false;
	}
}

function hideToolTip(obj,imgObj){
	if(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.getElementById("tooltiplayer") != null){
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.getElementById("tooltiplayer").style.visibility = 'hidden';
		obj.className = 'gridDataBlue';
		document.getElementById(imgObj).src = "../../eCommon/images/inactiveArrow.gif";
	}
}

function callMouseOver(obj)	{
	currClass = obj.className ;
	obj.className = 'selectedcontextMenuItem';
}

function callOnMouseOut(obj){
	obj.className = 'contextMenuItem';
}
function dummy1(facility_id){}

function dummy(){}
  
function recordFileUpload(){
	fileupload = top.ImageVideosFileUploadFrame.document.ImageVideosFileUploadForm.fileupload;
	top.ImageVideosFileUploadFrame.document.ImageVideosFileUploadForm.previewMode.value='';	
	top.ImageVideosFileUploadFrame.document.ImageVideosFileUploadForm.target = top.messageframe.name;
	top.ImageVideosFileUploadFrame.document.ImageVideosFileUploadForm.operation_mode.value = "Record";
	top.ImageVideosFileUploadFrame.document.ImageVideosFileUploadForm.action = '../../servlet/eOR.ImageVideosMultiUploadRecordServlet';
	top.ImageVideosFileUploadToolbarFrame.document.getElementById("noterecord_sec").disabled = true;
	top.ImageVideosFileUploadToolbarFrame.document.getElementById("btnUploadFile").disabled = true;
	top.ImageVideosFileUploadFrame.document.ImageVideosFileUploadForm.submit();	
}

function checkFileExtn(obj,called_from){		
	try{
		var filetype = "";
		var filename = "";
	
		var extn = "";
		obj.disabled = true;
		var fileuploadname = "";
		var fileTypes = "JPG,JPEG,PDF,MP4,GIF";
		filetypeObj = top.ImageVideosFileUploadFrame.document.ImageVideosFileUploadForm.filetype;
		
		for (var i = 0; i < filetypeObj.length; i++){
		    if (filetypeObj[i].checked) {
		    	filetype = filetypeObj[i].value;
		    }
		}

		if (called_from == undefined || called_from == ""){
			filename = top.ImageVideosFileUploadFrame.document.ImageVideosFileUploadForm.fileupload.value;			
			fileuploadname = top.ImageVideosFileUploadFrame.document.ImageVideosFileUploadForm.fileuploadname.value;
			//if(filetype=="MP4"){
			if(filetype=="V"){
				filename=fileuploadname;	
			}
	
			extn = filename.substring(filename.lastIndexOf(".")+1, filename.length);
		}else{
			filename = top.content.workAreaFrame.ImageVideosFrame.ImageVideosSectionFrame.ImageVideosFileUploadFrame.document.getElementById("fileupload").value;
			extn = filename.substring(filename.lastIndexOf(".")+1, filename.length);
		}
		
		parent.ImageVideosFileUploadDisplayFrame.document.location.href = '../../eCommon/html/blank.html';
		if(obj.name == "btnUploadFile"){
			if (filename != ''){
				//if(filetype != undefined && filetype!= null && filetype != '' && filetypeObj.indexOf(extn.toUpperCase()) != -1){
				//if(filetype != undefined && filetype!= null && filetype != ''){
				if(fileTypes.indexOf(extn.toUpperCase()) != -1){				
					doFileUpload(called_from);
				}else{			
					alert(getMessage("INVALID_FILE_EXTN", "CA"));
					obj.disabled = false;					
				}
			}else{		
				var msg = getMessage("CAN_NOT_BE_BLANK", "COMMON");
				if(filetype==''){
					msg = msg.replace("$" , getLabel("Common.filetype.label","COMMON"));	
				}else if(filename==''){					
					msg = msg.replace("$" , getLabel("eCA.FileReference.label", "ca"));						
				}				
				alert(msg);
				obj.disabled = false;
			}
		}
		else if(obj.name == "record_sec"){
			checkAndRecord();					
		}
	}catch(e){
		alert("Error Type = "+e.name+",Error Message = "+e.message);		
	}
}

function doFileUpload(called_from){
	if (called_from == undefined || called_from == ""){
		top.ImageVideosFileUploadFrame.document.ImageVideosFileUploadForm.target = top.messageframe.name;
		top.ImageVideosFileUploadFrame.document.ImageVideosFileUploadForm.method = 'post';
		top.ImageVideosFileUploadFrame.document.ImageVideosFileUploadForm.action = '../../servlet/eOR.ImageVideosMultiUploadServlet';
		top.ImageVideosFileUploadToolbarFrame.document.getElementById("btnUploadFile").disabled = true;
		top.ImageVideosFileUploadFrame.document.ImageVideosFileUploadForm.submit();
		var fileNameObj = top.ImageVideosFileUploadFrame.document.ImageVideosFileUploadForm.fileuploadname.value;
		
		var fileName = fileNameObj.substr(fileNameObj.lastIndexOf("\\")+1);	
		
		var callFrom = "REMOVE_SELECTED_VIDEO_LIST";
		xmlStr ="<root><SEARCH ";
		xmlStr += "CallFrom=\""+ callFrom +"\" " ;
		xmlStr += "fileName=\""+ fileName +"\" " ;
		xmlStr +=" /></root>" ;		
		var xmlHttp = new XMLHttpRequest() ;
		var xmlDoc = "" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ImageVideosMultiFileUploadvalidate.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);		
	}
}	

function reLoadFrames(result,called_from){
	var msg = "";
	if (result == 'DUPLICATEFILE'){
		msg = getMessage("DUPLICATE_FILE",'CA');  
	}
	
	if (msg != ""){
		alert(msg);
	}	
	
	if (called_from == undefined || called_from == ""){	
		top.ImageVideosFileUploadFrame.document.location.reload();
		top.ImageVideosFileUploadListFrame.document.location.reload();
		top.ImageVideosFileUploadToolbarFrame.document.location.reload();
		top.messageframe.document.location.href= '../../eCommon/jsp/MstCodeError.jsp';			
	}		
}

function displayFile(fileName){	
	//window.open("../../eOR/jsp/ImageVideosDispDocMian.jsp?fileName="+fileName,'BeanDocument',"height=590,width="+win_width+",top=80,left=0,resizable=yes,directories=no,location=no,menubar=no,status=no,scrollbars=yes");
	parent.ImageVideosFileUploadDisplayFrame.document.location.href = "../../eOR/jsp/ImageVideosDispDocMian.jsp?fileName="+fileName;
} 

function deleteFile(obj, called_from,index){
	var fileName = eval("document.getElementById("selectedFile")"+index).value;

	if (fileName != undefined && fileName != ""){
		var flag = confirm(getMessage("CONFIRM_FILE_DELETE",'CA'));
		if(flag){
			var CallFrom = "REMOVEDOC";
			xmlStr ="<root><SEARCH ";
			xmlStr += "CallFrom=\""+ CallFrom +"\" " ;
			xmlStr += "fileName=\""+ fileName +"\" " ;
			xmlStr += "CALLED_FROM=\""+ called_from +"\" " ;
			xmlStr +=" /></root>" ;		
			var xmlHttp = new XMLHttpRequest() ;
			var xmlDoc = "" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "ImageVideosMultiFileUploadvalidate.jsp", false ) ;
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			eval(responseText);
		}else{
			obj.checked = true;
		}
	}
}

function checkAndRecord(called_from,operation_mode){
	if (called_from==undefined){
		called_from = "";
	}
	
	if (operation_mode==undefined){
		operation_mode = "";
	}
	
	var CallFrom = "CHECKANDRECORD";
	xmlStr ="<root><SEARCH ";
	xmlStr += "CallFrom=\""+ CallFrom +"\" " ;	
	xmlStr += "operation_mode=\""+ operation_mode +"\" " ;
	xmlStr +=" /></root>" ;		
	var xmlHttp = new XMLHttpRequest() ;
	var xmlDoc = "" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ImageVideosMultiFileUploadvalidate.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
}

function clearBean(){ 
	var CallFrom = "CLEARBEAN";
	xmlStr ="<root><SEARCH ";
	xmlStr += "CallFrom=\""+ CallFrom +"\" " ;
	xmlStr +=" /></root>" ;		
	var xmlHttp = new XMLHttpRequest() ;
	var xmlDoc = "" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ImageVideosMultiFileUploadvalidate.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
}

function disableBtns(obj,called_from){
	if (called_from == undefined || called_from == ""){
		top.ImageVideosFileUploadToolbarFrame.document.ImageVideosFileUploadToolbarForm.record_sec.disabled = true;
	}else{
		top.content.workAreaFrame.ImageVideosFrame.ImageVideosToolbarFrame.document.ImageVideosFileUploadToolbarForm.record.disabled = true;			
	}		 
}

async function diagTypeSelect(obj) {
	retArr = await window.showModalDialog('../../eOR/jsp/ImageVideosDisplayMain.jsp');
	
	if (retArr == "" || retArr == undefined || retArr == null)
		retArr = "";
	
	top.ImageVideosFileUploadFrame.document.ImageVideosFileUploadForm.fileuploadname.value = retArr;
}
	
function setFilePath(sharedPath,index) {
	var selectedFile = eval("document.getElementById("selectedFile")"+index).value;
	window.returnValue = sharedPath + selectedFile;
	window.close();
} 

function dispHide(obj){ 
	  //if(obj.value=="MP4"){
	if(obj.value=="V"){
		document.getElementById("fileRefVideo").style.visibility = "visible";		
		document.getElementById("uploadFile_div").style.visibility = "hidden";		
		document.getElementById("uploadTd").style.visibility = "visible";	
		document.ImageVideosFileUploadForm.fileupload.value="";	//IN70150
		top.ImageVideosFileUploadFrame.document.getElementById("uploadFile_div").innerHTML=top.ImageVideosFileUploadFrame.document.getElementById("uploadFile_div").innerHTML;	//IN70150	
	//}else{
	}else if(obj.value=="D"){
		document.getElementById("fileRefVideo").style.visibility = "hidden";		
		document.getElementById("uploadFile_div").style.visibility = "visible";	
		document.getElementById("uploadTd").style.visibility = "hidden";
		document.ImageVideosFileUploadForm.fileuploadname.value="";	//IN70150
	}
}

function refreshViewPage(){	
	parent.ImageVideosFileUploadDisplayFrame.document.location.href = '../../eCommon/html/blank.html';
}

function onsuccess(){	
	top.window.close();
}

function enable_buttons(called_from,order_id,order_line_num){
	top.ImageVideosFileUploadToolbarFrame.document.ImageVideosFileUploadToolbarForm.record_sec.disabled = false;
	top.ImageVideosFileUploadToolbarFrame.document.ImageVideosFileUploadToolbarForm.btnUploadFile.disabled = false;
	top.messageframe.document.location.href= '../../eCommon/jsp/MstCodeError.jsp';
}
