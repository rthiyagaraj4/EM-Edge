/*
	Created For :AK-CRF-0006 on 11/4/2009;
*/
async function callPatientSearch(){
	var pat_id =  await PatientSearch('','','','','','','Y','','','OTHER');

	if(pat_id != null)
	document.Files_For_FSLocn_Form.p_patient_id.value = pat_id;
}

 function reset()  {
	Add_Modify_Frame.document.forms[0].reset(); 
 }

function checkPatientID(obj,run){
	if(obj.value!=""){
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST","../../eFM/jsp/FMServersidevalidation.jsp?patient_id="+obj.value+" ",false);
		xmlHttp.send(null);		
		responseText=trimString(xmlHttp.responseText);
			if(responseText==0){
				var err_msg = getMessage('PATIENT_FILE_NOT_EXIST','FM');
				if(run=='Y'){
					parent.frames[2].messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+err_msg ;
				}else{
					parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+err_msg ;
				}
				return false;
		}else{
				if(run=='Y'){
					parent.frames[2].messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
				}else{
					parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
				}
				return true;
		}
	}else{
		return true;
	}
}
function run() {	
	var formObj					= Add_Modify_Frame.document.Files_For_FSLocn_Form;//Form Onject;
	var p_fs_locn				= formObj.p_fs_locn_code;//Form Onject;
	var p_from_date			= formObj.p_from_date;//File Created Date From 
	var p_to_date				= formObj.p_to_date;//File Created Date To 

	var fs_locn_lbl				= Add_Modify_Frame.getLabel('eFM.FSLocation.label','FM');//Fs Location Label
	var file_created_lbl		= Add_Modify_Frame.getLabel('eFM.FileCreatedDate.label','FM');//File Created Date Label
	var from						= Add_Modify_Frame.getLabel('Common.from.label','Common');//File Created Date Label
	var to							= Add_Modify_Frame.getLabel('Common.to.label','Common');//File Created Date Label
	var p_patient_id			= Add_Modify_Frame.document.Files_For_FSLocn_Form.p_patient_id;

	var from_file_created_lbl	= file_created_lbl+" "+from;
	var to_file_created_lbl	= file_created_lbl+" "+to;

	var fields = new Array(p_fs_locn,p_from_date,p_to_date );
    var names = new Array(fs_locn_lbl,from_file_created_lbl, to_file_created_lbl);
    if(Add_Modify_Frame.checkFields( fields, names, messageFrame)){
		if(chkGrtrDate(file_created_lbl,p_from_date, p_to_date, messageFrame) ){
			if(CompareMonths(p_from_date,p_to_date, messageFrame) ){
				if(checkPatientID(p_patient_id,'Y') ){
					
					formObj.action="../../eCommon/jsp/report_options.jsp";
					formObj.target="messageFrame";
						formObj.submit() ;
				}
			}
		}
	}
}
function chkGrtrDate(str,fromDate,toDate,messageFrame){
	var formObj					= Add_Modify_Frame.document.Files_For_FSLocn_Form;//Form Onject;
	var from						= Add_Modify_Frame.getLabel('Common.from.label','Common');//File Created Date Label
	var to							= Add_Modify_Frame.getLabel('Common.to.label','Common');//File Created Date Label

	if(fromDate.value != "" && toDate.value != ""){
		if(isBefore(fromDate.value,toDate.value,"DMY",localeName) == false){
			var err_msg=getMessage("REMARKS_MUST_GR_EQUAL","common");
//			alert(error)
			err_msg=err_msg.replace("$",to+" "+str);
			err_msg=err_msg.replace("#",str);
            messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+err_msg  ;
            return false;
		}
		else 
			return true;
	}
	else 
		return true;
}


function CompareMonths(p_from_date,p_to_date,messageFrame){
	var file_created_lbl		= Add_Modify_Frame.getLabel('eFM.FileCreatedDate.label','FM');//File Created Date Label

		var day1, day2;
		var month1, month2;
		var year1, year2;

		value1 = p_from_date.value;
		value2 =p_to_date.value;

		day1 = value1.substring (0, value1.indexOf ("/"));
		month1 = value1.substring (value1.indexOf ("/")+1, value1.lastIndexOf ("/"));
		year1 = value1.substring (value1.lastIndexOf ("/")+1, value1.length);

		day2 = value2.substring (0, value2.indexOf ("/"));
		month2 = value2.substring (value2.indexOf ("/")+1, value2.lastIndexOf ("/"));
		year2 = value2.substring (value2.lastIndexOf ("/")+1, value2.length); 

		date1 = year1+"/"+month1+"/"+day1;
		date2 = year2+"/"+month2+"/"+day2;
		firstDate = Date.parse(date1)
		secondDate= Date.parse(date2)
		msPerDay = 24 * 60 * 60 * 1000;
		dbd = Math.round((secondDate.valueOf()-firstDate.valueOf())/ msPerDay) + 1;
//		alert(dbd)
		if(dbd>93){
//			var error="The difference between the From $ and To # should not exceed 3 months";
			var err_msg=getMessage("FM_DIFF_IN_MONTHS","FM");
			err_msg=err_msg.replace("$",file_created_lbl);
			err_msg=err_msg.replace("#",file_created_lbl);

            messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+err_msg  ;
			return false;
		}else{
			return true;
		}
}
