/*
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      	Name     			Description
--------------------------------------------------------------------------------------------------------------
23-OCT-2018      100           	Subha Sundari M          Created
---------------------------------------------------------------------------------------------------------------
*/

function reset() {
	BLAutoBillGenJobStatusReport.location.reload();
	BLAutoBillGenJobStatusBtn.location.reload();
}

function executeQuery() {
	var visitFrom = $('#visitFrom').val();
	var visitTo = $('#visitTo').val();
	var episode_type = $('episode_type').val();
	var cust_group_code = $('#custgroupCode').val();
	var cust_code = $('#custnameCode').val();
	var job_id = $('#job_id').val();
	var facilityId = $('#facility_id').val();
	
	var loginUser = $('#loginUser').val();
	if($.trim(visitFrom) == ''){
		var msg = getMessage("BL0773","BL");
		msg = msg.replace("$", "Job Submitted Date From");
		alert(msg);
		return false;
	}
	if($.trim(visitTo) == ''){
		var msg = getMessage("BL0774","BL");
		msg = msg.replace("$", "Job Submitted Date To");
		alert(msg);
		return false;
	}
	if ((Date.parse(visitTo) < Date.parse(visitFrom))) {
		var msg = getMessage("BL0775","BL");
		msg = msg.replace("$", "Job Submitted Date From");
		alert(msg);
		document.getElementById("visitFrom").value = "";
		return false;
	}
	$("#BLAutoBillGenJobStatusResultDiv").load("../../eBL/jsp/BLAutoBillGenJobStatusResult.jsp",
    	{
			visitFrom		: 		visitFrom,
			visitTo			:		visitTo,
			episode_type	:		episode_type,
			cust_group_code	: 		cust_group_code,
			cust_code		: 		cust_code,
			job_id			: 		job_id,
			facilityId		:		facilityId,
			loginUser		:		loginUser
    	});
}

/* This method is loaded by default */
function resultOnLoad() {
	var radios = jQuery("input[type='radio']");
	var strJobId =  radios.filter(":checked").val();
	document.forms[0].selectedJobId.value = strJobId;
	parent.BLAutoBillGenJobStatusBtn.document.forms[0].export_button.disabled = false;
	$("#ProcessedDataDiv").load("../../eBL/jsp/BLAutoBillGenResultError.jsp",{jobId:strJobId,tabType:"withouterror"});
	$("#tabADiv").html("<a class='tabClicked' id='ProcessedWithoutError'><span class='tabSpanclicked' id='ProcessedWithoutErrorspan'>Processed Without Error</span></a>");
	$("#tabBDiv").html("<a class='tabA' id='ProcessedWithError' ><span class='tabAspan' id='ProcessedWithErrorspan'>Processed With Error</span></a>");
	
}

function clickValue(obj) {
	if(obj == '0') {
		$("#ProcessedDataDiv").load("../../eBL/jsp/BLAutoBillGenResultError.jsp",{jobId:62,type:"withouterror"});
		$("#tabADiv").html("<a class='tabClicked' id='ProcessedWithoutError'><span class='tabSpanclicked' id='ProcessedWithoutErrorspan'>Processed Without Error</span></a>");
		$("#tabBDiv").html("<a class='tabA' id='ProcessedWithError' ><span class='tabAspan' id='ProcessedWithErrorspan'>Processed With Error</span></a>"); 

	}else if(obj == '1') {
		$("#ProcessedDataDiv").load("../../eBL/jsp/BLAutoBillGenResultError.jsp",{jobId:62,type:"witherror"});
		 $("#tabADiv").html("<a class='tabA' id='ProcessedWithoutError'><span class='tabAspan' id='ProcessedWithoutErrorspan'>Processed Without Error</span></a>");
		 $("#tabBDiv").html("<a class='tabClicked' id='ProcessedWithError' ><span class='tabSpanclicked' id='ProcessedWithErrorspan'>Processed With Error</span></a>"); 

	}
}

function jobIdLookup(jobId,episodeType,customerGroup,customer,custGroupCode,custCode) {
    var dialogTop              = "40";
    var dialogHeight           = "10" ;
    var dialogWidth                   = "40" ;
    var features               = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
    var arguments              = "" ;
    var title = "Job Id";
    var column_sizes = escape("15%,10%,25%,10%,25%,15%");
    var targetVal = jobId.value;
    var column_descriptions = 'Job Id' + ',' + 'Customer Group Code' + "," + 'Customer Group' + ',' + 'Customer Code' + "," + 'Customer' + ',' + 'Episode Type';
    var facilityId = document.forms[0].facility_id.value;
    var fromDate = document.forms[0].visitFrom.value;
    var toDate = document.forms[0].visitTo.value;
    var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&col_show_hide=YYYYYY&" +
                         "target="+targetVal+"&facilityId="+facilityId+"&fromDate="+fromDate+"&toDate="+toDate;
    var  retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=JOB_ID_LOOKUP&"+param,arguments,features);
    retVal = unescape(retVal);
    if(retVal != undefined && retVal !="undefined")
    {                                 
		var retArray = retVal.split("^~^");
		jobId.value = retArray[0];
		if(retArray[5] == 'All') {
			episodeType.value = "A";
		} else if(retArray[5] == 'Outpatient') {
			episodeType.value = "O";
		} else if(retArray[5] == 'Emergency') {
			episodeType.value = "E";
		}
		
		customerGroup.value = retArray[2];
		customer.value = retArray[4];
		custGroupCode.value = retArray[1]; 
		custCode.value = retArray[3];
    } else {
        jobId.value = "";
        episodeType.value = "";
        customerGroup.value = "";
        customer.value = "";
        custGroupCode.value = ""; 
 		custCode.value = "";
    }
}

function trimString(sInString) {
	  return sInString.replace(/^\s+|\s+$/g,"");
}

function downloadExcel()
{
	var fromDate = parent.BLAutoBillGenJobStatusReport.document.forms[0].visitFrom.value;
	var toDate = parent.BLAutoBillGenJobStatusReport.document.forms[0].visitTo.value;
	var jobId =  parent.BLAutoBillGenJobStatusReport.document.getElementById("selectedJobId").value;
	var episode_type = parent.BLAutoBillGenJobStatusReport.document.forms[0].episode_type.value;
	var cust_group = parent.BLAutoBillGenJobStatusReport.document.forms[0].cust_group.value;
	var cust_name = parent.BLAutoBillGenJobStatusReport.document.forms[0].cust_name.value;
	
	var urlPath = "../../eBL/jsp/BLAutoBillGenJobExcelDwld.jsp?fromDate="+fromDate+"&toDate="+toDate+"&jobId="+jobId+
				"&episodeType="+episode_type+"&custGroupName="+cust_group+"&custName="+cust_name;

	parent.frames[2].document.forms[0].method	= "POST";
	parent.frames[2].document.forms[0].action	= urlPath;
	
	parent.frames[2].document.forms[0].submit();
}

function clearValues() {
	document.forms[0].episode_type.value = "";
	document.forms[0].cust_group.value = "";
	document.forms[0].custgroupCode.value = "";
	document.forms[0].cust_name.value = "";
	document.forms[0].custnameCode.value = "";
}
