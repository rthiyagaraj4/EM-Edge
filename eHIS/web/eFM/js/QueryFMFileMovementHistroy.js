var currFileStatus1	=	new Array();
function doDateCheckFrom(from,today) 
{ //args objects 1st is this object & second is the date object
	if(from.value != "")
	{
		var fromarray;
		var toarray;
		var fromdate =from.value ;
		var todate =today.value ;
		
		if(fromdate.length > 0 && todate.length > 0 ) 
		{
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);
			//if (isBefore(fromdate,todate,"DMY",localeName))
			if( isAfter(fromdate,todate,"DMY",localeName) == false )
			{
				var msg = getMessage('FROM_DATE_GREATER_TO_DATE','FM');
				parent.frames[3].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
				parent.frames[2].location.href='../../eCommon/html/blank.html';
				today.focus();
				today.select();
				return false;
			}
			/*if(Date.parse(todt) > Date.parse(fromdt)) 
			{
				var msg = getMessage('FROM_DATE_GREATER_TO_DATE','FM');
				parent.frames[3].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
				today.focus();
				today.select();
				return false;
			}*/
			else if(Date.parse(todt) <= Date.parse(fromdt))
			{
				parent.frames[3].location.href='../../eCommon/jsp/error.jsp?' ;
				return true;
			}
		}
		return true;
	}
	return true;
}
function doDateCheckto(from,today) 
{ //args objects 1st is this object & second is the date object
	if(today.value != "")
	{
		var fromarray;
		var toarray;
		var fromdate =from.value ;
		var todate =today.value ;
	
		if(fromdate.length > 0 && todate.length > 0 ) 
		{
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);
			if(Date.parse(todt) > Date.parse(fromdt)) 
			{
				var msg = getMessage('TO_DATE_LESSER_FROM_DATE','FM');
				parent.frames[3].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
				from.focus();
				from.select();
				return false;
			}
			else if(Date.parse(todt) <= Date.parse(fromdt))
			{
				parent.frames[3].location.href='../../eCommon/jsp/error.jsp?' ;
				return true;
			}
		}
		return true;
	}
	return true;
}
function searchResult()
{
	var maintain_doc_or_file = document.forms[0].maintain_doc_or_file.value;

	if(maintain_doc_or_file == 'F')
	{
		var from				= document.forms[0].from.value ;
		var to					= document.forms[0].to.value;
		
		if(from != "")
		{
			from=convertDate(from,"DMY",localeName,"en");
		}

		if(to != "")
		{
			to=convertDate(to,"DMY",localeName,"en");
		}

		var file_type_appl_yn	= document.forms[0].file_type_appl_yn.value;	
		var criteria			= document.forms[0].file_no.value;
		if(file_type_appl_yn == 'Y')
			var filetypeCriteria	= document.forms[0].patient_file_type.value;
		var volumeno		    = document.forms[0].volume_no.value;
		var patientid		    = document.forms[0].patient_id.value;
		var facility			= document.forms[0].facility.value;
		var currStatDesc		= document.forms[0].currStatDesc.value;
		var currIdDesc			= document.forms[0].currIdDesc.value;
		var Curr_locn_desc		= document.forms[0].Curr_locn_desc.value;
		var CURR_FACILITY_NAME	= document.forms[0].CURR_FACILITY_NAME.value;
		var	nextRecord			= 0;
		var	previousRecord		= 0;
		var	validFile			= document.forms[0].validFile.value;
		var currentFileStatus	= currFileStatus1[document.forms[0].file_no.selectedIndex];
		var	fields				= "";
		var	names				= "";

		if(currentFileStatus=='A' || currentFileStatus=='a')
			currentFileStatus = " - Archeived" ;
		if(currentFileStatus=='L' || currentFileStatus=='l')
			currentFileStatus = " - Lost" ;
		else
			currentFileStatus = "" ;
		
		if(file_type_appl_yn == 'N')
		{
			fields				= new Array(document.forms[0].patient_id,document.forms[0].file_no,document.forms[0].volume_no);
			names				= new Array(getLabel("Common.patientId.label","common") , getLabel("Common.fileno.label","common"), getLabel("eFM.VolumeNo.label","FM"));
		}
		else if(file_type_appl_yn == 'Y')
		{
			fields				= new Array(document.forms[0].patient_id,document.forms[0].file_type_code,document.forms[0].volume_no);
			names				= new Array(getLabel("Common.patientId.label","common"), getLabel("Common.filetype.label","common"), getLabel("eFM.VolumeNo.label","FM"));
		}
		if((checkFields(fields, names, parent.messageFrame)))
		{
			if(doDateCheckFrom(document.forms[0].to,document.forms[0].from) && CheckSystemDateLesser(document.forms[0].from,document.forms[0].today.value)
			&& CheckSystemDateLesser(document.forms[0].to,document.forms[0].today.value))
			{				
				if(file_type_appl_yn == 'N')
				{
					parent.frames[2].document.location.href='../../eFM/jsp/QueryFMFileMovementHistorySearchResult.jsp?from=' + from + '&to=' + to +
					'&criteria=' + criteria  + '&volume_no=' + volumeno + '&facility=' + facility + '&patientid=' +  patientid +'&flag=next' +
					'&nextRecord=' + nextRecord + '&maintain_doc_or_file=' + maintain_doc_or_file + '&file_type_appl_yn=' + file_type_appl_yn + '&previousRecord=' + previousRecord + '&facility=' +  facility +
					'&currStatDesc=' + currStatDesc +'&currIdDesc=' + currIdDesc+'&Curr_locn_desc=' + Curr_locn_desc + '&CURR_FACILITY_NAME=' + CURR_FACILITY_NAME +
					'&currentFileStatus=' + currentFileStatus;        
				}
				if(file_type_appl_yn == 'Y')
				{
					parent.frames[2].document.location.href='../../eFM/jsp/QueryFMFileMovementHistorySearchResult.jsp?from=' + from + '&to=' + to +
					'&criteria=' + criteria  + '&filetypeCriteria=' + filetypeCriteria  + '&volume_no=' + volumeno + '&facility=' + facility + '&patientid=' +  patientid +'&flag=next' +
					'&nextRecord=' + nextRecord + '&maintain_doc_or_file=' + maintain_doc_or_file + '&file_type_appl_yn=' + file_type_appl_yn + '&previousRecord=' + previousRecord + '&facility=' +  facility +
					'&currStatDesc=' + currStatDesc +'&currIdDesc=' + currIdDesc+'&Curr_locn_desc=' + Curr_locn_desc + '&CURR_FACILITY_NAME=' + CURR_FACILITY_NAME +
					'&currentFileStatus=' + currentFileStatus;        
				}
			}
		}
		else
		{
			 parent.frames[2].document.location.href='../../eCommon/html/blank.html';
		}
	}
	else if(maintain_doc_or_file == 'D')
	{
		var from				= document.forms[0].from.value ;
		var to					= document. to.value;
		if(from != "")
		{
			from=convertDate(from,"DMY",localeName,"en");
		}

		if(to != "")
		{
			to=convertDate(to,"DMY",localeName,"en");
		}

		var criteria			= document.forms[0].file_no.value;
		var doc_type_code       = document.forms[0].doc_type_code.value; 
		var doc_folder_id       = document.forms[0].doc_folder_id.value; 		
		var patientid		    = document.forms[0].patient_id.value;
		var facility			= document.forms[0].facility.value;
		var currStatDesc		= document.forms[0].currStatDesc.value;
		var currIdDesc			= document.forms[0].currIdDesc.value;
		var Curr_locn_desc		= document.forms[0].Curr_locn_desc.value;
		var CURR_FACILITY_NAME	= document.forms[0].CURR_FACILITY_NAME.value;
		var	nextRecord			= 0;
		var	previousRecord		= 0;
		var	validFile			= document.forms[0].validFile.value;
		var currentFileStatus	= currFileStatus1[document.forms[0].file_no.selectedIndex];
		var	fields				= "";
		var	names				= "";

		if(currentFileStatus=='A' || currentFileStatus=='a')
			currentFileStatus = " - Archeived" ;
		if(currentFileStatus=='L' || currentFileStatus=='l')
			currentFileStatus = " - Lost" ;
		else
			currentFileStatus = "" ;
		
		fields				= new Array(document.forms[0].doc_folder_id,document.forms[0].doc_type_code);
		names				= new Array(getLabel("eFM.DocumentFolder.label","FM"), getLabel("Common.DisplayType.label","common"));
		
		if((checkFields(fields, names, parent.messageFrame)))
		{
			if(doDateCheckFrom(document.forms[0].to,document.forms[0].from) && CheckSystemDateLesser(document.forms[0].from,document.forms[0].today.value)
			&& CheckSystemDateLesser(document.forms[0].to,document.forms[0].today.value))
			{
				parent.frames[2].document.location.href='../../eFM/jsp/QueryFMFileMovementHistorySearchResult.jsp?from=' + from + '&to=' + to +
				'&criteria=' + criteria + '&doc_type_code=' + doc_type_code  + '&doc_folder_id=' + doc_folder_id + '&facility=' + facility + '&patientid=' +  patientid +'&flag=next' +
				'&nextRecord=' + nextRecord + '&patientid=' + patientid + '&maintain_doc_or_file=' + maintain_doc_or_file + '&previousRecord=' + previousRecord + '&facility=' +  facility +
				'&currStatDesc=' + currStatDesc +'&currIdDesc=' + currIdDesc+'&Curr_locn_desc=' + Curr_locn_desc + '&CURR_FACILITY_NAME=' + CURR_FACILITY_NAME +
				'&currentFileStatus=' + currentFileStatus;        
			}
		}
		else
		{
			 parent.frames[2].document.location.href='../../eCommon/html/blank.html';
		}
	}
}
function focusing()
{
	document.forms[0].patientid.focus();		
}
function getNext(flagSelect)
	{
	   var maintain_doc_or_file = document.getElementById("maintain_doc_or_file").value;
	   var patientid			= document.getElementById("patientid").value;
	   var from					= parent.frames[1].document.forms[0].from.value;
	   var to					= parent.frames[1].document.forms[0].to.value;
	   if(from != "")
		{
			from=convertDate(from,"DMY",localeName,"en");
		}

		if(to != "")
		{
			to=convertDate(to,"DMY",localeName,"en");
		}
	   var flag					= flagSelect;
	   var previousRecord		= document.getElementById("previousRecord").value;
	   var nextRecord			= document.getElementById("nextRecord").value;
       var facility				= document.getElementById("facility").value;
	   var currStatDesc			= document.getElementById("currStatDesc").value;
	   var currIdDesc			= document.getElementById("currIdDesc").value;
	   var Curr_locn_desc		= document.getElementById("Curr_locn_desc").value;
	   var curr_facility_name	= document.getElementById("curr_facility_name").value;
	   var currentFileStatus	= document.getElementById("currentFileStatus").value;
	   if(maintain_doc_or_file == 'F')
	   {
		   var volume_no			= document.getElementById("volume_no").value ;
		   var file_type_appl_yn    = document.getElementById("file_type_appl_yn").value;
		   if(file_type_appl_yn == 'N')
		   {	
				var criteria	= document.getElementById("criteria").value;
				document.location.href='../../eFM/jsp/QueryFMFileMovementHistorySearchResult.jsp?from=' + from + '&to=' + to + '&criteria=' + criteria  + '&volume_no=' + volume_no + '&facility=' + facility + '&patientid=' +  patientid +'&flag=' + flag + '&nextRecord=' + nextRecord+'&previousRecord=' + previousRecord +
				'&facility=' +  facility + '&currStatDesc=' + currStatDesc +'&currIdDesc=' + 			currIdDesc  +'&file_type_appl_yn=' + file_type_appl_yn +'&Curr_locn_desc=' + Curr_locn_desc + '&curr_facility_name=' + curr_facility_name +
				'&currentFileStatus=' + currentFileStatus + '&maintain_doc_or_file=' + maintain_doc_or_file;
		   }
		   else if(file_type_appl_yn == 'Y')
		   {	
			   var criteria	= document.getElementById("criteria").value;
			   var filetypeCriteria		= document.getElementById("filetypeCriteria").value;
			   document.location.href='../../eFM/jsp/QueryFMFileMovementHistorySearchResult.jsp?from=' + from + '&to=' + to + '&criteria=' + criteria  +'&filetypeCriteria=' + filetypeCriteria  + '&volume_no=' + volume_no + '&facility=' + facility + '&patientid=' +  patientid +'&flag=' + flag + '&nextRecord=' + nextRecord+'&previousRecord=' + previousRecord +
			   '&facility=' +  facility + '&currStatDesc=' + currStatDesc +'&currIdDesc=' + 			currIdDesc +'&file_type_appl_yn=' + file_type_appl_yn  +'&Curr_locn_desc=' + Curr_locn_desc + '&curr_facility_name=' + curr_facility_name +
		       '&currentFileStatus=' + currentFileStatus +'&maintain_doc_or_file=' + maintain_doc_or_file ;
		   }
		}
		else if(maintain_doc_or_file == 'D')
		{
		   var doc_folder_id =  document.getElementById("doc_folder_id").value;
		   var doc_type_code =  document.getElementById("doc_type_code").value;
		   var criteria 	 = document.getElementById("criteria").value;
			   
		   document.location.href='../../eFM/jsp/QueryFMFileMovementHistorySearchResult.jsp?from=' + from + '&to=' + to + '&criteria=' + criteria + '&doc_type_code=' + doc_type_code  + '&doc_folder_id=' + doc_folder_id + '&facility=' + facility + '&patientid=' +  patientid +'&flag=' + flag + '&nextRecord=' + nextRecord+'&previousRecord=' + previousRecord + '&facility=' +  facility + '&currStatDesc=' + currStatDesc +'&currIdDesc=' + 			currIdDesc  +'&file_type_appl_yn=' + file_type_appl_yn +'&Curr_locn_desc=' + Curr_locn_desc + '&curr_facility_name=' + curr_facility_name + '&currentFileStatus=' + currentFileStatus;
		}
	}
	function GetRemarks(recnum) 
	{
		var dialogHeight	= "9";
		var dialogWidth		= "16";
		var dialogTop		= "230";
		var dialogLeft		= "280";
		var center			= "0";
		var status			= "no";
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + ";dialogLeft:" + dialogLeft;
		var arguments		= "";
		var tempobj			= eval('parent.frames[2].document.forms[0].rem_recnum_'+recnum);
		var curr_remarks	= tempobj.value;
		var retVal			= window.showModalDialog('../../eFM/jsp/FMShowRemarks.jsp?rows=5&cols=30&title='+getLabel('eFM.FileMovement.label','FM')+'&editable=READONLY&curr_remarks='+escape(curr_remarks),arguments,features);

		if (!(retVal == null)) 
		{
			tempobj.value	= unescape(retVal);
		}
	}
	function GetReturnRemarks(name,remarksvalue,remarkstype) 
	{
		
		var comments;
		
		var inputArr = document.getElementsByTagName("input");
		for (u=0;u<inputArr.length;u++)
		{
			if (inputArr[u].name == name)
			{
				comments = inputArr[u].value;
			}
		}
		var retVal;
		var ua = window.navigator.userAgent
		var msie = ua.indexOf ( "MSIE " )
		if ( msie > 0 )     
			brow_ver_no=parseInt (ua.substring (msie+5, ua.indexOf (".", msie )));
		  
		var dialogHeight	= "9.3" ;
		var dialogWidth		= "30" ;
		if(brow_ver_no > '6'){
				dialogHeight	= "7.4" ;
				dialogWidth		= "28.5" ;
		  }
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
		var arguments;

	   if(comments=='' || comments == "null")
		  comments ='';
		arguments = comments;
		retVal = window.showModalDialog('../../eFM/jsp/GetShowRemarks.jsp?title=Return Remarks&RemarksValue='+encodeURIComponent(remarksvalue)+'&editable=READONLY&RemarksType='+remarkstype,arguments,features);

		for (u=0;u<inputArr.length;u++)
		{
			if(inputArr[u].name == name)
			{
				inputArr[u].value = ''+retVal+'';
			}
		}
	}

function callPatientSearch()
{
	var pat_id =  PatientSearch('','','','','','','Y','','','OTHER');
	if(pat_id != null)
		ManualEntry_form.patientid.value = pat_id;
}
function clearResultFrame()
{
   document.getElementById("PatientLine").innerHTML=""; 											 
   document.getElementById("PatientDetail").innerHTML=""; 											 
   parent.searchResultFrame.document.location.href="../../eCommon/html/blank.html" ;
  
}

function showPatientLine()
{
	//var  Pat_line = ManualEntry_form.Pat_line.value ;
	//document.getElementById("PatientLine").innerHTML=""; 								 
	//document.getElementById("PatientDetail").innerHTML= Pat_line ; 											 
}

 function reset()
 {
    searchFrame.document.location.reload();
	searchResultFrame.document.location.href="../../eCommon/html/blank.html"

	/*
	searchFrame.document.forms[0].search.disabled=false;
	searchResultFrame.document.location.href="../../eCommon/html/blank.html"
	searchFrame.document.forms[0].reset(); 
	searchFrame.document.forms[0].patient_id.focus(); 
	*/
	
 }

function GetShowRemarks(name,remarksvalue,remarkstype)
{
		var comments;
		var inputArr = document.getElementsByTagName("input");
		for (u=0;u<inputArr.length;u++)
		{
			if (inputArr[u].name == name)
			{
				comments = inputArr[u].value;
			}
		}
		var retVal;
		var ua = window.navigator.userAgent
		var msie = ua.indexOf ( "MSIE " )
		if ( msie > 0 )     
			brow_ver_no=parseInt (ua.substring (msie+5, ua.indexOf (".", msie )));
		  
		var dialogHeight	= "9.3" ;
		var dialogWidth		= "30" ;
		if(brow_ver_no > '6'){
				dialogHeight	= "7.4" ;
				dialogWidth		= "28.5" ;
		  }
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
		var arguments;

	    if(comments=='' || comments == "null")
			comments ='';
		arguments = comments;
		retVal = window.showModalDialog('../../eFM/jsp/GetShowRemarks.jsp?title='+ getLabel('eFM.ReturnRemarks.label','FM')+'&RemarksValue='+encodeURIComponent(remarksvalue)+'&RemarksType='+remarkstype,arguments,features);
		for (u=0;u<inputArr.length;u++)
		{
			if(inputArr[u].name == name)
			{
				inputArr[u].value = ''+retVal+'';
			}
		}
}

