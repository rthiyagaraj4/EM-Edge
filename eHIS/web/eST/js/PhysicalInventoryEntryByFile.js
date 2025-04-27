var searchby = "D";
var function_id = ""; 
var bean_id = "";
var bean_name = "";
var xmlDom;  
var xmlHttp;
var xmlString;
function reset() {
	location.reload(); 
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/PhysicalInventoryEntryFrameByFile.jsp?function_id=" + function_id;
}

function apply() {
	
	var formObj = f_query_add_mod.framePhysicalInventoryEntryByFileUpdateHeader.document.formPhysicalInventoryEntryByFileUpdateHeader;
	var formObj2 = f_query_add_mod.framePhysicalInventoryFileDetail.document.formPhysicalInventoryEntryFileDetail;

	if (formObj.phy_inv_id.value == "") {
		var msg = getLabel("eST.PhyInventoryID.label", "ST") + " " + getLabel("Common.Cannotbeblank.label", "Common");
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + msg;
		return;
	}
	if (formObj.entry_completed_yn.checked) {
		formObj.entry_completed_yn.value = "Y";
	} else {
		formObj.entry_completed_yn.value = "N";
	}
	var errorPage = "../../eCommon/jsp/error.jsp";
	if (formObj.entry_completed_yn.value == "Y") {
//		if (!confirm(getMessage("NULL_BATCHES_WILL_UPDADATE_TO_ZERO","ST"))) {
//			messageFrame.location.href = errorPage + "?err_num=";
//			return;
//		}
		alert(getMessage("NULL_BATCHES_WILL_UPDADATE_TO_ZERO","ST"));
	}

	if(formObj2.remark_count.value==0)
		{
		var responseText = formApply(formObj, ST_CONTROLLER);
		eval(responseText);
		messageFrame.location.href = errorPage + "?err_num=" + message;
		if (result) {
			Success();
					// reset();
		}
	}
	else
		{
		 var msg = getMessage("REMARKS_ARE_PRESENT_SO_CAN'T_APPLY","ST");
		 messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + msg;
			return;
		}
}
function Success() {
	query();
}
function assignBean(formObject) {
	bean_id = formObject.bean_id.value;
	bean_name = formObject.bean_name.value;
	/*xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");*/
	var xmlDom = "";
		var xmlHttp = new XMLHttpRequest();
}

function getStore() {
	formObj = document.formPhysicalInventoryEntryByFileUpdateHeader;
	/*xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");*/
	var xmlDom = "";
		var xmlHttp = new XMLHttpRequest();
	xmlString = "<root><SEARCH/></root>";
	xmlDom.loadXML(xmlString);
	xmlHttp.open("POST", "../../eST/jsp/PhysicalInventoryEntryApplyAddValidate.jsp?validate=LOADSTORE&phy_inv_id=" + formObj.phy_inv_id.value, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}

function fun_browse_file(obj) {
	document.getElementById('viewButton').disabled =false;
	var frmObj = formPhysicalInventoryEntryByFileUpdateHeader;
	var fields	=	new Array	(frmObj.store_code,frmObj.phy_inv_id)
	var names	=	new Array	(getLabel("Common.Store.label", "ST"),getLabel("eST.PhyInventoryID.label", "ST") );
	var errorPage	= "../../eCommon/jsp/error.jsp" ;	
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="
	blankObject  = checkSTFields(fields, names, parent.parent.messageFrame, errorPage);
	if (obj != null && blankObject==true) {
		parent.framePhysicalInventoryEntryByFileUpdateHeader.document.formPhysicalInventoryEntryByFileUpdateHeader.file_name.value = obj.value;
	}
	if (frmObj.fileName.value == "") {
		parent.frames[1].location.href = "../../eCommon/html/blank.html";
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	validate();
}

function callFileDetail(pid,ec,file_name){
	parent.frames[0].location.href="../eST/jsp/PhysicalInventoryEntryByFileUpdateHeader.jsp?phy_inv_id="+ pid;
	parent.frames[1].location.href = "../eST/jsp/PhysicalInventoryEntryFileDetail.jsp";
	
}
/*
function validate(){
	var inputFile = document.getElementById("file");
	if(''!=inputFile.value){	
		var objFSO = new ActiveXObject("Scripting.FileSystemObject");
		var objFile = objFSO.getFile(inputFile.value);
		var last_dot = (objFile.name).lastIndexOf('.');
		var ext = (objFile.name).slice(last_dot + 1);
		if(ext!='csv' ){
			alert('Invalid File Format. ');	
			try {
				document.getElementById("file").value = null;
			} catch(ex) { }
			//alert("can't set value null");
			}					
		}else{			
			var fileSize = objFile.size; //size in b	
			fileSize = fileSize / 1048576; //size in mb 
			if(fileSize>2){
				alert('File Size Exceeds 2 MB limit.');
				try {
					document.getElementById(imageid).value = null;
				} catch(ex) { }
				//alert("can't set value null");
			}
		}
	}
*/
function validate() {
    var inputFile = document.getElementById("file");
    if (inputFile.files && inputFile.files[0]) {  // Check if there are files selected
        var file = inputFile.files[0];  // Get the first file
        var ext = file.name.split('.').pop().toLowerCase();  // Get file extension in lowercase

        // Check for valid file extension
        if (ext !== 'csv') {
            alert('Invalid File Format.');
            inputFile.value = '';  // Clear the file input
        } else {
            // Check file size (in MB)
            var fileSize = file.size / 1048576;  // Size in MB
            if (fileSize > 2) {
                alert('File Size Exceeds 2 MB limit.');
                inputFile.value = '';  // Clear the file input
            }
        }
    }
    return true;
}

function setValue(){
    var formObj = parent.framePhysicalInventoryEntryByFileUpdateHeader.document.formPhysicalInventoryEntryByFileUpdateHeader;
    if (formObj.entry_completed_yn.checked) {
		document.getElementById('entry_comp').value = "Y";
	} else {
		formObj.entry_completed_yn.value = "N";}
	}

function setEntryComplete(entry_comp)
{
	document.getElementById('ec').checked="true";
}

function view()
{
	//alert("In")
	if(document.getElementById('file').value==null||document.getElementById('file').value=="" )
	{
	 var msg = getMessage("SELECT_FILE","ST");
	 parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ msg;
		return;
	}
else{
	document.getElementById('formId');
	document.getElementById('viewButton').disabled = true;
	Submit();
}
	
}

function Submit(){
        var form = document.getElementById('formId');
        try {
        	form.submit();
        } catch (e) {
            setTimeout(function () { Submit(); }, 50);
        }
    }


 
