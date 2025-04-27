/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
19/03/2020 	IN070345  		Ramesh Goli											MO-CRF-20147.1
-------------------------------------------------------------------------------------------------------------------------------------
*/
 
function query()
{
	f_query_add_mod.location.href='../../eCA/jsp/CADocMgmtConfig.jsp?mode=insert';
} 
function apply()
{
	if(f_query_add_mod.DetailsFrame!=null || f_query_add_mod.DetailsFrame != undefined){
		if((f_query_add_mod.DetailsFrame.document.CADocMgmtConfigForm!=null || f_query_add_mod.DetailsFrame.document.CADocMgmtConfigForm != undefined)){	
			var totaldocuments = f_query_add_mod.DetailsFrame.document.CADocMgmtConfigForm.totaldocuments.value;
			var iChars = "~`!@#$%^&*+=[]()';,{}|\"<>?/";
			for(var i=0;i<totaldocuments;i++){
				var docStoredType = f_query_add_mod.DetailsFrame.document.getElementById('docStoredType'+i).value;
				f_query_add_mod.DetailsFrame.document.getElementById('docSharedPathValue'+i).value=f_query_add_mod.DetailsFrame.document.getElementById('docSharedPath'+i).value;
				if("F"==docStoredType){
					var docSharedPath=f_query_add_mod.DetailsFrame.document.getElementById('docSharedPath'+i).value;
					if(docSharedPath=="" || docSharedPath==null || docSharedPath == undefined )
					{
						errors = "Shared Path cannot be blank for "+f_query_add_mod.DetailsFrame.document.getElementById('docFuncitonName'+i).value+".";
						messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
						return false ;
					}else if(docSharedPath.indexOf("\\\\")==0 || docSharedPath.split(":\\").length >= 2){
										
						for (var j = 0; j < docSharedPath.length; j++){
							if (iChars.indexOf(docSharedPath.charAt(j)) != -1) {					
								errors = f_query_add_mod.DetailsFrame.document.getElementById('docFuncitonName'+i).value+" Shared Path allowed special characters in path are \\, :, -, . and _. Alphabets and numbers are valid. <br>"+
								"Note:  If Shared Path begins with the System Name, the format is: \\\\SystemName\\Folder1\\Folder2. <br>"+
								"       If Shared Path is Mapped drive, it must begin with drive name. Ex: H:\\Folder1. ";	
								messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
								return false;
							}
						}
		
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest() ;
						var xmlStr ="<root><SEARCH ";	
						xmlStr += " filePath=\""+docSharedPath+"\"";	
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","../../eCommon/jsp/DocumentScanAjaxUtil.jsp",false);	
						xmlHttp.send(xmlDoc);
						
						var xhcheck=xmlHttp.responseText;
		
						if( xhcheck.indexOf("Y") > -1)
						{
							
						}
						else{
							errors = "Shared path is either incorrect or is not Read-Write accessible - "+docSharedPath+"<br>"+
								"Note:    If Shared Path begins with the System Name, the format is: \\\\SystemName\\Folder1\\Folder2. <br>"+
								"         If Shared Path is Mapped drive, it must begin with drive name. Ex: H:\\Folder1. ";
								
							messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
							return false;
						}
					}else
					{
					   errors = "Shared path should start with \\\\ or it should be the mapped drive path. <br>" +
								"Note:    If Shared Path begins with the System Name, the format is: \\\\SystemName\\Folder1\\Folder2. <br>"+
								"         If Shared Path is Mapped drive, it must begin with drive name. Ex: H:\\Folder1. ";
						messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
						return false ;
					}
				}
			}
			f_query_add_mod.DetailsFrame.document.CADocMgmtConfigForm.submit();
		}else{
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
			return false;
		}
	}else{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}
}
function reset(){
	if(f_query_add_mod.HeaderFrame!="" && f_query_add_mod.HeaderFrame!=null && f_query_add_mod.HeaderFrame != undefined )
	{
		f_query_add_mod.location.href='../../eCA/jsp/CADocMgmtConfig.jsp?mode=insert';
	}else{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}
}
function onSuccess()
{
	f_query_add_mod.location.href='../../eCA/jsp/CADocMgmtConfig.jsp?mode=insert';
}
function changeFacility()
{
	document.DocMgmtConfigHeaderForm.facilityId.value = document.DocMgmtConfigHeaderForm.facility_id.value;
}

/*
	Function Name : loadFrames()
	Description : Will load the document management configuration for the selected facility
*/

function getSearchDetails()
{
	var mode = document.DocMgmtConfigHeaderForm.mode.value;
	var facilityId = document.DocMgmtConfigHeaderForm.facilityId.value;

	var facilityId_df = ""; 

	if (facilityId == "")
	{
		var erroMsg=getMessage("CAN_NOT_BE_BLANK",'COMMON');
		erroMsg=erroMsg.replace('$',getLabel("Common.facility.label","Common"));
		if(erroMsg!="")
		{
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+erroMsg+"&err_value=0";
			return false;
		}
	}

	facilityId_df = facilityId;

	if(facilityId == "A*")
	{	
		facilityId_df = "DF";			 
	}
	
	if (facilityId !="")
	{
		parent.DetailsFrame.location.href = '../../eCA/jsp/CADocMgmtConfigDetails.jsp?mode='+mode+'&facilityId='+facilityId+'&facilityId_df='+facilityId_df;
		parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	}	
	
}

function CheckForSpecCharsWithSpaceBlur(ObjText)
{
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ\\:.-_ ';   
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}
function setDocPathEnabled(obj){
	var radio = document.getElementsByName('docFolderOption'+obj);
	for(i = 0; i < radio.length; i++) { 
        if(radio[i].checked) {        	
        	document.getElementById("docStoredType"+obj).value=radio[i].value;
		}
    }	
	if("F"==document.getElementById("docStoredType"+obj).value){
		document.getElementById("docSharedPath"+obj).disabled=false;
		document.getElementById("sharedPathMandatoryImg"+obj).style.display = "inline";
		
	}else{
		document.getElementById("docSharedPath"+obj).disabled=true;
		document.getElementById("sharedPathMandatoryImg"+obj).style.display = "none";
		
	}
	
}
function validateSharedPath(obj){
	
	if(obj.value=="" || obj.value==null || obj.value == undefined){
		alert("Shared Path cannot be blank.");		
	}
}
