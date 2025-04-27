//Created by Sethuraman for document Management Config Requirement
var rowIDArray = new Array();

/*
 * Functions called from DocumentManagementConfig.jsp
 */

/*
Function Name : create()
Description :  Used for Loading the Function
*/
function create()
{
	f_query_add_mod.location.href='../../eMP/jsp/DocMgmtConfigMain.jsp?mode=insert';
}

//changed by prithivi -- mode=insert for AAKH-058574 on 08/12/2015
function query()
{
	f_query_add_mod.location.href='../../eMP/jsp/DocMgmtConfigMain.jsp?mode=insert';
}

function changeFacility()
{
	document.DocMgmtConfigHeaderForm.facilityId.value = document.DocMgmtConfigHeaderForm.facility_id.value;
}

/*
	Function Name : loadFrames()
	Description : Will load the document management configuration for the selected facility
*/

function loadFrames()
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
		parent.DetailsFrame.location.href = '../../eMP/jsp/DocMgmtConfig.jsp?mode='+mode+'&facilityId='+facilityId+'&facilityId_df='+facilityId_df;
		parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	}	
	
}


function setScanEnabled(obj){

	var doc_save_as = eval("document.DocMgmtConfigForm.doc_save_as");
	var scanUIEnabled = eval("document.DocMgmtConfigForm.doc_scan_ui_enabled");
			
	var docSaveAsRadios = doc_save_as;
	for(var i = 0; i < docSaveAsRadios.length; i++){
		docSaveAsRadios[i].disabled = true;
	}
	
    scanUIEnabled.disabled = true;

	if (obj.checked == true)
	{
		for(var i = 0; i < docSaveAsRadios.length; i++){
			docSaveAsRadios[i].disabled = false;
		}
		 scanUIEnabled.disabled = false;
	}
	else
	{
		scanUIEnabled.checked = false;
	}
}

function setDocPathEnabled(obj)
{
 
   //var doc_sharedPath = eval("DocMgmtConfigForm.doc_shared_path"); // Added by prithvi on 26/08/2015
   var doc_sharedPath = "";
   var sharedPathMandatoryImg="";
	
   // Added by Bhuvana on 23/05/2019.

   //var theForm = document.getElementById("DocMgmtConfigForm");

   if(obj.name == "doc_photo_option") {
		doc_sharedPath = eval("document.DocMgmtConfigForm.photo_shared_path"); // Added by prithvi on 26/08/2015
		sharedPathMandatoryImg=eval("document.DocMgmtConfigForm.photoPathMandatoryImg");
   } 
   else if(obj.name == "inventory_folder_option"){//Added by kamatchi S for MO-CRF-20171.1
		doc_sharedPath = eval("document.DocMgmtConfigForm.inventory_shared_path");
		sharedPathMandatoryImg=eval("document.DocMgmtConfigForm.sharePathMandImg");    
}
else {
		doc_sharedPath = eval("document.DocMgmtConfigForm.doc_shared_path"); // Added by prithvi on 26/08/2015
		sharedPathMandatoryImg=eval("document.DocMgmtConfigForm.sharedPathMandatoryImg");
   }
	// Ended by Bhuvana on 23/05/2019.
	var doc_sharedPathArray=doc_sharedPath;
	var doc_sharedPathImgArray=sharedPathMandatoryImg;
	
	if(doc_sharedPathArray.length != undefined && doc_sharedPathArray.length != 0)
	{
		for(var i = 0; i < doc_sharedPathArray.length; i++)
		{        
			//doc_sharedPathArray[i].disabled = true;
			doc_sharedPathArray[i].readOnly = true;
			doc_sharedPathImgArray[i].style.visibility="hidden";
		}
	}
	else
	{
		//doc_sharedPath.disabled = true;
		doc_sharedPath.readOnly = true;
		sharedPathMandatoryImg.style.visibility="hidden";
	}
	//document.DocMgmtConfigForm.doc_shared_path.disabled = true;
	//document.DocMgmtConfigForm.web_service_url.disabled = true;
	if (obj.checked == true)
	{
		if (obj.value == 1)
		{
			if(doc_sharedPathArray.length != undefined && doc_sharedPathArray.length != 0)
			{
				for(var i = 0; i < doc_sharedPathArray.length; i++)
				{

					//doc_sharedPathArray[i].disabled = false;
					doc_sharedPathArray[i].readOnly = false;
					doc_sharedPathImgArray[i].style.visibility="visible";
				}
			}
			else
			{
				//doc_sharedPath.disabled = false;
				doc_sharedPath.readOnly = false;
				sharedPathMandatoryImg.style.visibility="visible";
			}
				
		}			
	}
}


/*
Function Name : apply()
	Description : HTML Object  Values of the file EncSummConfigGroupAddedList.jsp values are Posted to EncSummConfigServlet.java file
*/


function apply()
{	
	var scanEnabledValue = 0;
	var scanUIEnabledValue = 0;
	var docSaveAsValue = 0;
	var docPathOptionValue = 0;
	var invPathOptionValue = 0;//Added by Kamatchi S for MO-CRF-20171.1
	var docCheckStatusValue = 0;	
	var photoPathOptionValue =0;
	var facilityId = "";

	var mode = f_query_add_mod.HeaderFrame.document.forms[0].mode.value;
	var isScanOption = f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.isScanningOption.value;
	var isDocOption = f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.isDocumentOption.value;
	var isPhotoOption = f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.isPhotoOption.value;
	var isInvOption = f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.isInventoryOption.value;//Added by Kamatchi S for MO-CRF-20171.1
	facilityId = f_query_add_mod.HeaderFrame.document.forms[0].facilityId.value;

	var facilityId_df = ""; 
	facilityId_df = f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.facilityId_df.value;

	var errors = "";
	
	if(facilityId == "A*")
	{
		var strConfirm  = confirm("Selecting for all facilities will override the data configured for any individual facilities. Do you want to proceed?");
	}
	else
	{
		strConfirm = true;
	}

	if(strConfirm)
	{
		if(f_query_add_mod.DetailsFrame!=null)
		{		
			if (mode == "insert")
			{	
				if(mode != null)
				{	
					f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.facilityId.value = f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.facilityId.value;

					if(isScanOption == "true")
					{					
						f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.isScanningOption.value = f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.isScanningOption.value;

						/*****************************************************************************/
						var scanEnabledfield = eval("f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.doc_scan_enabled");			
						if (scanEnabledfield.checked == true)
						{
							scanEnabledValue = 1;
						}

						var scanUIEnabledfield = eval("f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.doc_scan_ui_enabled");			
						if (scanUIEnabledfield.checked == true)
						{
							scanUIEnabledValue = 1;
						}
						var doc_save_as = eval("f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.doc_save_as");
					
						var docSaveAsRadios = doc_save_as;
						for(var i = 0; i < docSaveAsRadios.length; i++){
							if(docSaveAsRadios[i].checked){
								docSaveAsValue = docSaveAsRadios[i].value;
							}
						}	
						f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.DocSaveAs.value = docSaveAsValue;	
						f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.ScanningEnabled.value = scanEnabledValue;
						f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.ScanningUIEnabled.value = scanUIEnabledValue;
					}
					else
					{
						f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.ScanningEnabled.value = 0;
						f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.ScanningUIEnabled.value = 0;
						f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.DocSaveAs.value = 0;
					}
					
					if(isDocOption == "true")
					{	
						f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.isDocumentOption.value = f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.isDocumentOption.value;
						var doc_path_option = eval("f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.doc_folder_option");
				
						var docPathAsRadios = doc_path_option;
						for(var i = 0; i < docPathAsRadios.length; i++){
							if(docPathAsRadios[i].checked){
								docPathOptionValue = docPathAsRadios[i].value;
							}
						}	

						f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.DocFolderOption.value = docPathOptionValue;
			
						var docSharedPath = eval("f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.doc_shared_path"); //prithvi			
						var docSharedPathArray = docSharedPath; //prithvi

						//var iChars = "~`!@#$%^&*+=[]().';,/{}|\":<>?";  
						var iChars = "~`!@#$%^&*+=[]()';,{}|\"<>?/";    // removed colon from this. it is acceptable (25-04-2016)
						
						if (docPathOptionValue == 1)
						{					
							if(docSharedPathArray.length != undefined && docSharedPathArray.length != 0)
							{					
								for(var a=0; a<docSharedPathArray.length;a++)
								{
									if(docSharedPathArray[a].value=="" || docSharedPathArray[a].value==null || docSharedPathArray[a].value == undefined )
									{
										errors = "Shared Path cannot be blank.";
										messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
										return false ;
									}
									else if(docSharedPathArray[a].value.indexOf("\\\\")==0 || docSharedPathArray[a].value.split(":\\").length >= 2){
								
									   for (var i = 0; i < docSharedPathArray[a].value.length; i++) 
										{
											if (iChars.indexOf(docSharedPathArray[a].value.charAt(i)) != -1) {
											
											errors = "Allowed special characters in path are \\, :, -, . and _. Alphabets and numbers are valid. <br>"+
												"Note:  If Shared Path begins with the System Name, the format is: \\\\SystemName\\Folder1\\Folder2. <br>"+
												"       If Shared Path is Mapped drive, it must begin with drive name. Ex: H:\\Folder1. ";	
											messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
											return false;
											}
										}

										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest() ;
										var xmlStr ="<root><SEARCH ";	
										xmlStr += " filePath=\""+docSharedPathArray[a].value+"\"";	
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open("POST","../../eCommon/jsp/DocumentScanAjaxUtil.jsp",false);	
										xmlHttp.send(xmlDoc);
										
										var xhcheck=xmlHttp.responseText;

										if( xhcheck.indexOf("Y") > -1)
										{
											
										}
										else{
											errors = "Shared path is either incorrect or is not Read-Write accessible - "+docSharedPathArray[a].value+"<br>"+
												"Note:    If Shared Path begins with the System Name, the format is: \\\\SystemName\\Folder1\\Folder2. <br>"+
												"         If Shared Path is Mapped drive, it must begin with drive name. Ex: H:\\Folder1. ";
												
											messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
											return false;
										}
									}
									else
									{
									   errors = "Shared path should start with \\\\ or it should be the mapped drive path. <br>" +
												"Note:    If Shared Path begins with the System Name, the format is: \\\\SystemName\\Folder1\\Folder2. <br>"+
												"         If Shared Path is Mapped drive, it must begin with drive name. Ex: H:\\Folder1. ";
										messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
										return false ;
									} 
								}
							}
							else if(docSharedPathArray.length == undefined)
							{
								if(f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.doc_shared_path.value=="" || f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.doc_shared_path.value==null || f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.doc_shared_path.value == undefined )
								{
									errors = "Shared Path cannot be blank.";
									messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
									return false ;
								}
								else if(f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.doc_shared_path.value.indexOf("\\\\")==0 || f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.doc_shared_path.value.split(":\\").length >= 2){

									for (var i = 0; i < f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.doc_shared_path.value.length; i++) 
									{
										if (iChars.indexOf(f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.doc_shared_path.value.charAt(i)) != -1) {
										//errors = "Path must begin with \"\\\\\". Allowed special characters in path are \\, -,/ and _. Alphabets and numbers are valid";
										errors = "Allowed special characters in path are \\, :, -, . and _. Alphabets and numbers are valid. <br>"+
											"Note:  If Shared Path begins with the System Name, the format is: \\\\SystemName\\Folder1\\Folder2. <br>"+
											"       If Shared Path is Mapped drive, it must begin with drive name. Ex: H:\\Folder1. ";	
										messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
										return false;
										}
									}
									var xmlDoc = "" ;
									var xmlHttp = new XMLHttpRequest() ;
									var xmlStr ="<root><SEARCH ";	
									xmlStr += " filePath=\""+f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.doc_shared_path.value+"\"";	
									xmlStr +=" /></root>";
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									xmlHttp.open("POST","../../eCommon/jsp/DocumentScanAjaxUtil.jsp",false);	
									xmlHttp.send(xmlDoc);
									
									var xhcheck=xmlHttp.responseText;
									
									if( xhcheck.indexOf("Y") > -1)
									{
									
									}
									else{
										//errors ="Shared path is incorrect or is not Read-Write accessible"+f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.doc_shared_path.value;
										errors = "Shared path is either incorrect or is not Read-Write accessible - "+f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.doc_shared_path.value+"<br>"+
											"Note:    If Shared Path begins with the System Name, the format is: \\\\SystemName\\Folder1\\Folder2. <br>"+
											"         If Shared Path is Mapped drive, it must begin with drive name. Ex: H:\\Folder1. ";
										messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
										return false;
									}
								}
								else
								{
								   errors = "Shared path should start with \\\\ or it should be the mapped drive path. <br>" +
											"Note:    If Shared Path begins with the System Name, the format is: \\\\SystemName\\Folder1\\Folder2. <br>"+
											"         If Shared Path is Mapped drive, it must begin with drive name. Ex: H:\\Folder1. ";
									messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
									return false ;
								} 
							}
							else{
								errors = "Shared Path cannot be blank.";
								messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
								return false ;
							}					
						}
					}
					
					if(isPhotoOption == "true")
					{	
						f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.isPhotoOption.value = f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.isPhotoOption.value;
						var photo_path_option = eval("f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.doc_photo_option");
				
						var photoPathAsRadios = photo_path_option;
						for(var i = 0; i < photoPathAsRadios.length; i++){
							if(photoPathAsRadios[i].checked){
								photoPathOptionValue = photoPathAsRadios[i].value;
							}
						}	
						f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.PhotoDocOption.value = photoPathOptionValue;
			
						var photoSharedPath = eval("f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.photo_shared_path"); //prithvi			
						var photoSharedPathArray = photoSharedPath; //prithvi
						var errors = "";
						//var iChars = "~`!@#$%^&*+=[]().';,/{}|\":<>?";  
						var iChars = "~`!@#$%^&*+=[]()';,{}|\"<>?/";    // removed colon from this. it is acceptable (25-04-2016)

						if (photoPathOptionValue == 1)
						{					

							if(photoSharedPathArray.length != undefined && photoSharedPathArray.length != 0)
							{		
								for(var a=0; a<photoSharedPathArray.length;a++)
								{
									if(photoSharedPathArray[a].value=="" || photoSharedPathArray[a].value==null || photoSharedPathArray[a].value == undefined )
									{
										errors = "Shared Path cannot be blank.";
										messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
										return false ;
									}
									else if(photoSharedPathArray[a].value.indexOf("\\\\")==0 || photoSharedPathArray[a].value.split(":\\").length >= 2)
									{							
									   for (var i = 0; i < photoSharedPathArray[a].value.length; i++) 
										{
											if (iChars.indexOf(photoSharedPathArray[a].value.charAt(i)) != -1) {
											
											errors = "Allowed special characters in path are \\, :, -, . and _. Alphabets and numbers are valid. <br>"+
												"Note:  If Shared Path begins with the System Name, the format is: \\\\SystemName\\Folder1\\Folder2. <br>"+
												"       If Shared Path is Mapped drive, it must begin with drive name. Ex: H:\\Folder1. ";	
											messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
											return false;
											}
										}
										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest() ;
										var xmlStr ="<root><SEARCH ";	
										xmlStr += " filePath=\""+photoSharedPathArray[a].value+"\"";	
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open("POST","../../eCommon/jsp/DocumentScanAjaxUtil.jsp",false);	
										xmlHttp.send(xmlDoc);
										
										var xhcheck=xmlHttp.responseText;

										if( xhcheck.indexOf("Y") > -1)
										{
										
										}
										else
										{
											errors = "Shared path is either incorrect or is not Read-Write accessible - "+photoSharedPathArray[a].value+"<br>"+
												"Note:    If Shared Path begins with the System Name, the format is: \\\\SystemName\\Folder1\\Folder2. <br>"+
												"         If Shared Path is Mapped drive, it must begin with drive name. Ex: H:\\Folder1. ";
												
											messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
											return false;
										}
									}
									else
									{
									   errors = "Shared path should start with \\\\ or it should be the mapped drive path. <br>" +
												"Note:    If Shared Path begins with the System Name, the format is: \\\\SystemName\\Folder1\\Folder2. <br>"+
												"         If Shared Path is Mapped drive, it must begin with drive name. Ex: H:\\Folder1. ";
										messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
										return false ;
									} 
								}
							}
							else if(photoSharedPathArray.length == undefined)
							{

								if(f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.photo_shared_path.value=="" || f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.photo_shared_path.value==null || f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.photo_shared_path.value == undefined )
									{
										errors = "Shared Path cannot be blank.";
										messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
										return false ;
									}
									else if(f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.photo_shared_path.value.indexOf("\\\\")==0 || f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.photo_shared_path.value.split(":\\").length >= 2){

										for (var i = 0; i < f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.photo_shared_path.value.length; i++) 
										{
											if (iChars.indexOf(f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.photo_shared_path.value.charAt(i)) != -1) {
											//errors = "Path must begin with \"\\\\\". Allowed special characters in path are \\, -,/ and _. Alphabets and numbers are valid";
											errors = "Allowed special characters in path are \\, :, -, . and _. Alphabets and numbers are valid. <br>"+
												"Note:  If Shared Path begins with the System Name, the format is: \\\\SystemName\\Folder1\\Folder2. <br>"+
												"       If Shared Path is Mapped drive, it must begin with drive name. Ex: H:\\Folder1. ";	
											messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
											return false;
											}
										}
										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest() ;
										var xmlStr ="<root><SEARCH ";	
										xmlStr += " filePath=\""+f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.photo_shared_path.value+"\"";	
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open("POST","../../eCommon/jsp/DocumentScanAjaxUtil.jsp",false);	
										xmlHttp.send(xmlDoc);
										
										var xhcheck=xmlHttp.responseText;
										
										if( xhcheck.indexOf("Y") > -1)
											{
											
											}
										else{
											//errors ="Shared path is incorrect or is not Read-Write accessible"+f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.doc_shared_path.value;
											errors = "Shared path is either incorrect or is not Read-Write accessible - "+f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.photo_shared_path.value+"<br>"+
												"Note:    If Shared Path begins with the System Name, the format is: \\\\SystemName\\Folder1\\Folder2. <br>"+
												"         If Shared Path is Mapped drive, it must begin with drive name. Ex: H:\\Folder1. ";
											messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
											return false;
										}
									}
									else
									{
									   errors = "Shared path should start with \\\\ or it should be the mapped drive path. <br>" +
												"Note:    If Shared Path begins with the System Name, the format is: \\\\SystemName\\Folder1\\Folder2. <br>"+
												"         If Shared Path is Mapped drive, it must begin with drive name. Ex: H:\\Folder1. ";
										messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
										return false ;
									} 
							}
							else{
								errors = "Shared Path cannot be blank.";
								messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
								return false ;
							}					
						}
					}

		//Added by kamatchi S for MO-CRF-20171.1
				if(isInvOption == "true")
					{	
						f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.isInventoryOption.value = f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.isInventoryOption.value;
						var inv_path_option = eval("f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.inventory_folder_option");
				
						var invPathAsRadios = inv_path_option;
						for(var i = 0; i < invPathAsRadios.length; i++){
							if(invPathAsRadios[i].checked){
								invPathOptionValue = invPathAsRadios[i].value;
							}
						}	
						f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.InvFolderOption.value = invPathOptionValue;
						var invSharedPath = eval("f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.inventory_shared_path"); 
						var invSharedPathArray = invSharedPath; 
						var iChars = "~`!@#$%^&*+=[]()';,{}|\"<>?/"; 
						
						if (invPathOptionValue == 1)
						{		
							if(invSharedPathArray.length != undefined && invSharedPathArray.length != 0)
							{					
								for(var a=0; a<invSharedPathArray.length;a++)
								{
									if(invSharedPathArray[a].value=="" || invSharedPathArray[a].value==null || invSharedPathArray[a].value == undefined )
									{
										errors = getMessage("SHARE_PATH_CANNOT_BLANK",'MP');
										messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
										return false ;
									}
									else if(invSharedPathArray[a].value.indexOf("\\\\")==0 || invSharedPathArray[a].value.split(":\\").length >= 2){
								
									   for (var i = 0; i < invSharedPathArray[a].value.length; i++) 
										{
											if (iChars.indexOf(invSharedPathArray[a].value.charAt(i)) != -1) {
											
											errors = getMessage("ALLOW_SPL_CHARACTERS",'MP');
											messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
											return false;
											}
										}

										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest() ;
										var xmlStr ="<root><SEARCH ";	
										xmlStr += " filePath=\""+invSharedPathArray[a].value+"\"";	
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open("POST","../../eCommon/jsp/DocumentScanAjaxUtil.jsp",false);	
										xmlHttp.send(xmlDoc);
										
										var xhcheck=xmlHttp.responseText;

										if( xhcheck.indexOf("Y") > -1)
										{
											
										}
										else{
											errors = getMessage("READ_WRITE_ACCESSIBLE",'MP');
											errors = errors.replace('$',invSharedPathArray[a].value);	
											messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
											return false;
										}
									}
									else
									{
									   errors = getMessage("SHARE_PATH_MAP_DRIVE",'MP');
										messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
										return false ;
									} 
								}
							}
							else if(invSharedPathArray.length == undefined)
							{
								if(f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.inventory_shared_path.value=="" || f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.inventory_shared_path.value==null || f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.inventory_shared_path.value == undefined )
								{
									errors = getMessage("SHARE_PATH_CANNOT_BLANK",'MP');
									messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
									return false ;
								}
								else if(f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.inventory_shared_path.value.indexOf("\\\\")==0 || f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.inventory_shared_path.value.split(":\\").length >= 2){

									for (var i = 0; i < f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.inventory_shared_path.value.length; i++) 
									{
										if (iChars.indexOf(f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.inventory_shared_path.value.charAt(i)) != -1) {
										
										errors = getMessage("ALLOW_SPL_CHARACTERS",'MP');	
										messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
										return false;
										}
									}
									var xmlDoc = "" ;
									var xmlHttp = new XMLHttpRequest() ;
									var xmlStr ="<root><SEARCH ";	
									xmlStr += " filePath=\""+f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.inventory_shared_path.value+"\"";	
									xmlStr +=" /></root>";
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									xmlHttp.open("POST","../../eCommon/jsp/DocumentScanAjaxUtil.jsp",false);	
									xmlHttp.send(xmlDoc);
									
									var xhcheck=xmlHttp.responseText;
									
									if( xhcheck.indexOf("Y") > -1)
									{
									
									}
									else{
										errors = getMessage("READ_WRITE_ACCESSIBLE",'MP');
										errors = errors.replace('$', f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.inventory_shared_path.value);
										messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
										return false;
									}
								}
								else
								{
								   errors = getMessage("SHARE_PATH_MAP_DRIVE",'MP');
									messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
									return false ;
								}
							}
							else{
								errors = getMessage("SHARE_PATH_CANNOT_BLANK",'MP');
								messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
								return false ;
							}				
						}
					}
					

				

					
				}
				f_query_add_mod.DetailsFrame.document.DocMgmtConfigForm.submit();	
				//f_query_add_mod.DetailsFrame.location.href = '../../eMP/jsp/DocMgmtConfig.jsp?mode='+mode+'&facilityId='+facilityId+'&facilityId_df='+facilityId_df;
			}
		}
	}
	else
	{
		errors ="";
		f_query_add_mod.DetailsFrame.location.href = '../../eMP/jsp/DocMgmtConfig.jsp?mode='+mode+'&facilityId='+facilityId+'&facilityId_df='+facilityId_df;
		messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
		//parent.commontoolbarFrame.location.href ="../../eCommon/jsp/commonToolbar.jsp?home_required_yn=Y&menu_id=SM&module_id=SM&function_id=SM_DOCU_CONF&function_name=Document%20Configuration&function_type=F&access=NYYNN&desktopFlag=N";
		return false;
	}
}


function resetFrames()
{
	parent.DetailsFrame.location.href = '../../eCommon/html/blank.html';
	parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
}

/*
Function name :   reset()
Description : The Function is Used For Refreshing the Function
*/
function reset()
{
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset();

	f_query_add_mod.location.reload();

}

/*
Function name :   onSuccess
Description : Function  is Invoked automatically when Records are Submitted to the DataBase 
*/
function onSuccess() 
{
	alert("1");
	if(f_query_add_mod.DetailsFrame.document.forms[0].mode.value=="insert")
	{
		f_query_add_mod.location.href='../../eMP/jsp/DocMgmtConfigMain.jsp?mode=insert&facilityId='+f_query_add_mod.DetailsFrame.document.forms[0].facilityId.value;
	}
	else if(f_query_add_mod.DetailsFrame.document.forms[0].mode.value=="update")
	{	
		//changed by prithivi -- mode=insert for AAKH-058574 on 08/12/2015
		f_query_add_mod.location.href='../../eMP/jsp/DocMgmtConfigMain.jsp?mode=insert&facilityId='+f_query_add_mod.DetailsFrame.document.forms[0].facilityId.value;
	}
	else     
	      f_query_add_mod.location.href='../../eCommon/html/blank.html';
}



function CheckForSpecialCharacter(ObjText)
{
	//var key = window.event.keyCode;
	 var whichCode = (window.Event) ? event.which : event.keyCode;
     var key = String.fromCharCode(whichCode);  // Get key value from key code
		if(((key >=33)&&(key <=47))||((key >=58)&&(key <=64))||(key == 32)||((key >=91)&&(key <=96))||((key >=123)&&(key <=126))||((key >=145)&&(key <=146)))
	{
			return false;
	}
		return true;
}

function CheckForSpecCharsWithSpaceBlur(ObjText)
{
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ\\:.-_ ';  // Edited by prithvi on 25/08/2015 (\\ symbol)  Edited by prithvi on 20/10/2015 -removed all special characters // Edited on 18/04/2016 added two special chars / and . 
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}





