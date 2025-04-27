/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var units="";
var units_1="";
var serv_code="";
var serv_code_1="";
var new_bill_acc_num_for_change_bay="";
function  reset(){
	var formObj=document.frames.holding_area_frame.document.HoldingAreaForm;
	if(formObj.function_id_temp.value==""){
		document.frames.holding_area_frame.document.getElementById("charge_details").style.display='none';
		window.parent.frames[2].document.location.reload();
	}else
	if(formObj.function_id_temp.value=="33"){
		document.frames.holding_area_frame.document.getElementById("charge_details_1").style.display='none';
	}
	document.frames.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	formObj.reset();
}

function checkNull(retVal){
	if(retVal == null ||  retVal=="null" || retVal=="undefined"){		
		return '';
	}else{
		return retVal;
	}
}


function compareDatesLocal(fromdate,todate) {	
	var fromarray; var toarray;
    if(fromdate.length > 0 && todate.length > 0 ) {
			var from_date_array = fromdate.split(" ");
			var from_date = from_date_array[0];
			var from_time = from_date_array[1];
			var to_date_array = todate.split(" ");
			var to_date = to_date_array[0];
			var to_time = to_date_array[1];
            var fromdatearray = from_date.split("/");
            var todatearray = to_date.split("/");
            var fromtimearray = from_time.split(":");
            var totimearray = to_time.split(":");
			var fromdt = new Date(fromdatearray[2],fromdatearray[1],fromdatearray[0],fromtimearray[0],fromtimearray[1]);
            var todt = new Date(todatearray[2],todatearray[1],todatearray[0],totimearray[0],totimearray[1]);
			//alert(new Date(2004,11,24,23,11)); is the format used above yyyy,mm,dd,hh24,mi
            if(Date.parse(todt) < Date.parse(fromdt)) {
                return false;
            }
    }
	return true;
}

function apply(){	
	var i=1;
	var formObj=document.frames.holding_area_frame.document.HoldingAreaForm;
	if(formObj!=null){
	var locale = formObj.locale.value;
	var chrg_stg = formObj.inventry_chk_yn_DB.value;
	var hold_chrg_fin_chk_yn = formObj.charge_hold_area_yn_DB.value;
	var inventry_chk_yn_DB   = formObj.inventry_chk_yn_DB.value;
	checkHoldAreaChrgYN();
	getHoldingAreaCheckApply();
	var acc_line_num="";
	if(CheckMandatoryFields()){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		//var cur_date = formObj.cur_date.value
		var change_date =  dateUtils(formObj.check_in_date.value,locale);
		var called_from = formObj.called_from.value;
		var function_id_temp = formObj.function_id_temp.value;
		var oper_num = formObj.oper_num.value;
		var oper_num_with_hb = formObj.accession_num.value;
		var bill_acc_temp = formObj.bill_acc_num_add.value;
		var old_bill_acc_num = formObj.bill_acc_num_DB.value;
		var mode="insert";
		var accession_num="";
		var oper_room_chrg_yn="";
		var change_oper_room_chrg_yn="";
		if(function_id_temp==""){
			var bl_panel_str=formObj.bl_panel_str.value;
			var change_holding_code = formObj.change_holding_code.value;
			var formObj=document.frames.holding_area_frame.document.HoldingAreaForm;
			var cur_date_time = dateUtils(formObj.check_in_date.value,locale)+" "+formObj.check_date_time.value;
			var chk_out_date=formObj.change_out_date.value;
			var chk_out_time=formObj.change_out_date_time.value;
			var check_in_date=formObj.check_in_date.value;
			var check_in_time=formObj.check_date_time.value;
			var chk_in_dt_time=check_in_date+" "+check_in_time;
			var chk_out_dt_time=chk_out_date+" "+chk_out_time;
			var checked_in_dt_time=checkApplyCheckInTime();
			var retVal_chk_In = compareDates(checked_in_dt_time,cur_date_time,"en",'DMYHM');
			
			if(retVal_chk_In==false){
				var msg_1 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
				var msgArr = msg_1.split("#");
				var checkin_time = getLabel("eOT.CheckInTime.Label","OT");
				var chkindatetime =getLabel("eOT.CheckedInDateTime.Label","OT");
				var chkd_in_dt_time=formObj.check_in_date.value+" "+formObj.check_date_time.value;
				var msg=msgArr[0]+ chkindatetime +msgArr[1]+ checkin_time +msgArr[2]+" ("+checked_in_dt_time+")";
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;	
				return;
			}
		/*Added by Suma against incident 18979( Note : extra space is given for chk_out_dt_time as this cannot be trimmed which will cause other problem if trimmed) */
			if(chk_out_dt_time !=" " && chk_in_dt_time !="")
			{
			if(!isAfter(chk_out_dt_time,chk_in_dt_time,"DMYHM",locale)){
				var msg_1 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
				var msgArr = msg_1.split("#");
				var checkin_time = getLabel("eOT.CheckedInDateTime.Label","OT");
				var chk_out_dt_time =getLabel("eOT.CheckedOutDateTime.Label","OT");
				var msg=msgArr[0]+ chk_out_dt_time +msgArr[1]+ checkin_time +msgArr[2];
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;	
			 return false;
			}
			}
		}

		if(function_id_temp=="33"){
			var formObj=document.frames.holding_area_frame.document.HoldingAreaForm;
			var cur_date_time = dateUtils(formObj.change_date.value,locale)+" "+formObj.change_date_time.value;
			var sys_date_time = formObj.cur_date.value+" "+formObj.cur_time.value;
			var checked_in_dt_time=checkApplyCheckOutholdingAreaTime();
			// Modify by DhanasekarV against script error in holding area  IN033267
			//	alert("sys_date_time:::"+sys_date_time);//lakshmi
			 if (checked_in_dt_time == null || checked_in_dt_time=='null' || checked_in_dt_time=='' || checked_in_dt_time == 'undefined')
			   checked_in_dt_time = sys_date_time;
				 
			//alert("checked_in_dt_time:::"+checked_in_dt_time);//lakshmi
			//alert("cur_date_time:::"+cur_date_time);//lakshmi
			var retVal_chk_In = compareDates(checked_in_dt_time,cur_date_time,"en",'DMYHM');

			//alert('retVal_chk_in '+retVal_chk_In);
			var chk_out_date=formObj.change_date_1.value;
			var chk_out_time=formObj.change_date_time_1.value;
			var check_in_date=formObj.change_date.value;
			var check_in_time=formObj.change_date_time.value;
			var chk_in_dt_time=check_in_date+" "+check_in_time;
			var chk_out_dt_time=chk_out_date+" "+chk_out_time;
			if(retVal_chk_In==false){
				var msg_1 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
				var msgArr = msg_1.split("#");
				var checkin_time = getLabel("eOT.CheckInTime.Label","OT");
				var chkindatetime =getLabel("eOT.CheckedOutDateTime.Label","OT");
				var hlding_area_lbl =getLabel("eOT.HoldingArea.Label","OT");
				var chng_hlding_area_lbl =getLabel("eOT.ChangeHoldingBay.Label","OT");
				var chkd_in_dt_time_lbl =getLabel("eOT.CheckedInDateTime.Label","OT");
				var chkd_in_dt_time=formObj.change_date.value+" "+formObj.change_date_time.value;
				var msg=msgArr[0]+" "+chng_hlding_area_lbl+" "+chkd_in_dt_time_lbl+" OR "+chkindatetime +msgArr[1]+ hlding_area_lbl+" "+ chkindatetime+" "+msgArr[2]+"("+checked_in_dt_time+")";
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;	
				return;
			}

			if(chk_out_date != null && chk_out_date != 'undefined' && chk_out_date.length > 0) 
			{
			if( !isAfter(chk_out_dt_time,chk_in_dt_time,"DMYHM",locale)){
				var msg_1 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
				var msgArr = msg_1.split("#");
				var checkin_time = getLabel("eOT.CheckedInDateTime.Label","OT");
				var chk_out_dt_time =getLabel("eOT.CheckedOutDateTime.Label","OT");
				var msg=msgArr[0]+ chk_out_dt_time +msgArr[1]+ checkin_time +msgArr[2];								
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
				return false;
			}
			var retVal_sysdateTime=isBeforeNow(chk_out_dt_time,'DMYHM',locale);
			if(retVal_sysdateTime==false){
				var msg_1 = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
				var msgArr = msg_1.split("#");
				var checkin_time = getLabel("Common.SystemDateTime.label","Common");
				var chk_out_dt_time =getLabel("eOT.CheckedOutDateTime.Label","OT");
				var msg=msgArr[0]+ chk_out_dt_time +msgArr[1]+ checkin_time +msgArr[2];								
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
				return false;
			}
			}
			
		}
		if(oper_num_with_hb.length=="0"){
			accession_num=oper_num+"HB"+change_holding_code+bill_acc_temp;
		}else{
			accession_num=oper_num+"HB"+change_holding_code+bill_acc_temp;
		}
		if(old_bill_acc_num==accession_num){
			mode="update";
		}
		if(chrg_stg=="N"){
			var accession_line_num = "";
			var calc_charge_units="";
			var charge_units="";
	//		var accession_num = "";
			var service_code = "";
		}
		if(function_id_temp=="33" && hold_chrg_fin_chk_yn=="Y" && inventry_chk_yn_DB=="Y"){
			var calc_chrge_units_1 = checkNull(formObj.calc_chrge_units_1.value);
			var charge_units_1 = checkNull(formObj.charge_units_1.value);
			var oper_num_with_hb = formObj.bill_accession_num.value;
			var change_hold_bay_code = formObj.change_holding_code_1.value;
			var bill_acc_num_add = formObj.bill_acc_num_add.value;
			new_bill_acc_num_for_change_bay=oper_num+"HB"+change_hold_bay_code+bill_acc_num_add;
		}
		if(function_id_temp==""){
			var change_holding_code=formObj.change_holding_code.value;
			oper_room_chrg_yn=hideChargeBillDtlChkApply(change_holding_code);
			if(oper_room_chrg_yn=="N")
			{
				var change_out_date=formObj.change_out_date.value;
				var change_out_time=formObj.change_out_date_time.value;
				if(change_out_date!="" && change_out_time==""){
					var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOT.CheckedOutTime.Label","OT"));
					parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg1;	
					return false;
				//	formObj.change_out_date_time.select();
				//	return ;
				}

			}
		}
		if(function_id_temp=="33"){
			var change_holding_code=formObj.change_holding_code_1.value;
			change_oper_room_chrg_yn=hideChargeBillDtlChkApply(change_holding_code);
			if(change_oper_room_chrg_yn=="N")
			{
				var change_out_date=formObj.change_date_1.value;
				var change_out_time=formObj.change_date_time_1.value;
				if(change_out_date!="" && change_out_time==""){
				var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOT.CheckedOutTime.Label","OT"));
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg1;	
				return false;
				//	formObj.change_out_date_time.select();
				//	return ;
				}

			}
		}
		var inc_exe_blng_wdw=formObj.inc_exe_blng_wdw.value;
		var reason_inc_exc=formObj.reason_inc_exc.value;
		var xmlStr ="<root><SEARCH ";
		if(function_id_temp==""){
			xmlStr += "oper_num=\""+ formObj.oper_num.value +  "\" ";
			xmlStr += "bl_panel_str=\""+ escape(bl_panel_str)+  "\" ";
			xmlStr += "change_holding_code=\""+ formObj.change_holding_code.value +  "\" ";
			xmlStr += "change_holding_desc=\""+ formObj.change_holding_desc.value  + "\" ";
			xmlStr += "change_date_time=\""+ change_date+" "+formObj.check_date_time.value  + "\" ";
			//Newly Inserted for billing;
			//commented below line and added convertDate on 12/16/2010 for 25523 by Anitha
			//xmlStr += "chk_out_dt_time=\""+ formObj.change_out_date.value+" "+formObj.change_out_date_time.value + "\" ";
			xmlStr += "chk_out_dt_time=\""+ convertDate(formObj.change_out_date.value,'DMY',locale,"en")+" "+formObj.change_out_date_time.value + "\" ";
			xmlStr += "accession_num=\""+ accession_num + "\" ";
			xmlStr += "bill_acc_temp=\""+ formObj.bill_acc_num_add.value + "\" ";
			xmlStr += "slate_user_id=\""+ formObj.slate_user_id.value + "\" ";
			xmlStr += "patient_id=\""+ formObj.patient_id.value + "\" ";
			xmlStr += "hold_area_chrging_stg=\""+ formObj.hold_area_chrging_stg.value + "\" ";
			xmlStr += "chk_holding_area_chrg_yn_stg=\""+ formObj.chk_holding_area_chrg_yn_stg.value + "\" ";
			xmlStr += "charge_hold_area_yn=\""+ hold_chrg_fin_chk_yn + "\" ";
			xmlStr += "mode=\""+ mode + "\" ";
			//if billing flag is disabled
			if(chrg_stg=="Y" && hold_chrg_fin_chk_yn=="Y" && oper_room_chrg_yn=="Y"){
				xmlStr += "service_code=\""+ formObj.service_code.value + "\" ";
				xmlStr += "calc_charge_units=\""+ formObj.calc_chrge_units.value + "\" ";
				xmlStr += "modified_charge_units=\""+ formObj.charge_units.value + "\" ";
				xmlStr += "accession_line_num=\""+ accession_num + "\" ";	
				xmlStr += "inc_exe_blng_wdw=\""+ inc_exe_blng_wdw + "\" ";	
				xmlStr += "reason_inc_exc=\""+ reason_inc_exc + "\" ";	
			}else{
				xmlStr += "service_code=\""+ service_code + "\" ";
				xmlStr += "calc_charge_units=\""+ calc_charge_units + "\" ";
				xmlStr += "modified_charge_units=\""+ charge_units + "\" ";
				xmlStr += "accession_line_num=\""+ accession_line_num+ "\" ";
			}
			//billing values ends
		}else if(function_id_temp=="33"){
			//if(new_bill_acc_num_for_change_bay=="undefined")new_bill_acc_num_for_change_bay =""; 
			var bill_acc_num=formObj.bill_acc_num_add.value;
			if("undefined"==bill_acc_num)bill_acc_num=""; 
			xmlStr += "oper_num=\""+ formObj.oper_num.value +  "\" ";
			xmlStr += "change_holding_code=\""+ formObj.change_holding_code_1.value +  "\" ";
			xmlStr += "change_holding_desc=\""+ formObj.change_holding_desc_1.value  + "\" ";
			//commented below line and added convertDate on 12/16/2010 for 25523 by Anitha

			//xmlStr += "change_date_time=\""+ formObj.change_date.value+" "+formObj.change_date_time.value + "\" ";
			xmlStr += "change_date_time=\""+ convertDate(formObj.change_date.value,'DMY',locale,"en")+" "+formObj.change_date_time.value + "\" ";
			//Newly Inserted for billing;
			//xmlStr += "chk_out_dt_time=\""+ formObj.change_date_1.value+" "+formObj.change_date_time_1.value + "\" ";
			xmlStr += "chk_out_dt_time=\""+ convertDate(formObj.change_date_1.value,'DMY',locale,"en")+" "+formObj.change_date_time_1.value + "\" ";

			xmlStr += "accession_num=\""+ new_bill_acc_num_for_change_bay + "\" ";
			xmlStr += "bill_acc_temp=\""+ formObj.bill_acc_num_add.value + "\" ";
			xmlStr += "accession_line_num=\""+ new_bill_acc_num_for_change_bay + "\" ";
			xmlStr += "slate_user_id=\""+ formObj.slate_user_id.value + "\" ";
			xmlStr += "patient_id=\""+ formObj.patient_id.value + "\" ";
			xmlStr += "hold_area_chrging_stg=\""+ formObj.hold_area_chrging_stg.value + "\" ";
			xmlStr += "chk_holding_area_chrg_yn_stg=\""+ formObj.chk_holding_area_chrg_yn_stg.value + "\" ";
			xmlStr += "charge_hold_area_yn=\""+ hold_chrg_fin_chk_yn + "\" ";
			xmlStr += "mode=\""+ mode + "\" ";
			if(chrg_stg=="Y" && hold_chrg_fin_chk_yn=="Y" && change_oper_room_chrg_yn=="Y"){
				xmlStr += "calc_charge_units=\""+ calc_chrge_units_1 + "\" ";
				xmlStr += "modified_charge_units=\""+ charge_units_1 + "\" ";
				xmlStr += "service_code=\""+ formObj.service_code_1.value + "\" ";
				xmlStr += "inc_exe_blng_wdw=\""+ formObj.inc_exe_blng_wdw.value + "\" ";
				xmlStr += "reason_inc_exc=\""+ formObj.reason_inc_exc.value + "\" ";
			}else{
				xmlStr += "calc_charge_units=\""+ calc_charge_units + "\" ";
				xmlStr += "modified_charge_units=\""+ charge_units + "\" ";
				xmlStr += "service_code=\""+ service_code + "\" ";
			}
		}
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    	xmlHttp.open("POST","HoldingAreaValidation.jsp?func_mode=updateAndCommitHoldingAreaDtls",false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		var split_msg=retVal.split("&");
		//if(retVal!=null && retVal!=""){
		if(split_msg[0]=="S" || retVal=="RECORD_INSERTED"){
				if(called_from=="OT_SLATE"){
				window.returnValue=getMessage("RECORD_INSERTED","SM");
				alert(window.returnValue);
				window.close();
				}
		} else{
			alert(retVal);
			window.close();
			//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}  
  }else{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}



function checkHoldAreaChrgYN(){
	var formObj=document.frames.holding_area_frame.document.HoldingAreaForm;
	var facility_id = formObj.facility_id.value;
	var function_id_temp = formObj.function_id_temp.value;
	var change_holding_code="";
	if(function_id_temp==""){
	change_holding_code = formObj.change_holding_code.value;
	}else{
	change_holding_code = formObj.change_holding_code_1.value;
	}
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "func_mode=chkOperRoomChrgeYn&facility_id="+facility_id+"&oper_room_code="+change_holding_code;
	xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);	
	formObj.chk_holding_area_chrg_yn_stg.value=retVal;
}

function searchHoldingAreaBay(obj,target){
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	var facility_id = document.forms[0].facility_id.value;
	var size = document.forms[0].size.value;
	var oper_num_accsn_num = document.forms[0].oper_num.value;
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var tit=getLabel("eOT.HoldingBay.Label","OT");
	var locale = document.forms[0].locale.value;
	var charge_hold_area_yn_DB = document.forms[0].charge_hold_area_yn_DB.value;
	var sql="";	
	/*the condition(charge_hold_area_yn_DB =="Y") added by Suma as per incident 18979 */
/*if(charge_hold_area_yn_DB =="Y")
{
	sql="SELECT  HOLDING_AREA_DESC description,HOLDING_AREA_CODE code FROM OT_HOLDING_AREAS_LANG_VW WHERE OPERATING_FACILITY_ID='"+facility_id+ "' AND NVL(STATUS,'E') = 'E'  and CHARGEABLE_YN='Y'  and upper(HOLDING_AREA_DESC) like upper(?) and upper(HOLDING_AREA_CODE) like upper(?) AND LANGUAGE_ID='"+locale+"'  order by 2";
}else
	{
	sql="SELECT  HOLDING_AREA_DESC description,HOLDING_AREA_CODE code FROM OT_HOLDING_AREAS_LANG_VW WHERE OPERATING_FACILITY_ID='"+facility_id+ "' AND NVL(STATUS,'E') = 'E'  and upper(HOLDING_AREA_DESC) like upper(?) and upper(HOLDING_AREA_CODE) like upper(?) AND LANGUAGE_ID='"+locale+"'  order by 2";
	}
	*/

// Modified by DhanasekarV against Holdinga area issue.
	sql="SELECT  HOLDING_AREA_DESC description,HOLDING_AREA_CODE code FROM OT_HOLDING_AREAS_LANG_VW WHERE OPERATING_FACILITY_ID='"+facility_id+ "' AND NVL(STATUS,'E') = 'E'  and upper(HOLDING_AREA_DESC) like upper(?) and upper(HOLDING_AREA_CODE) like upper(?) AND LANGUAGE_ID='"+locale+"'  order by 2";

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		obj.value = arr[0];
			hideChargeBillDtls(arr[0]);
	}else{
		target.value="";
		obj.value="";
	}
}



function hideChargeBillDtls(obj){
	var formObj=document.forms[0]
	var facility_id = document.forms[0].facility_id.value;
	var function_id_temp = document.forms[0].function_id_temp.value;
	var inventry_chk_yn_DB = document.forms[0].inventry_chk_yn_DB.value;
	var charge_hold_area_yn = document.forms[0].charge_hold_area_yn_DB.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "func_mode=chkOperRoomChrgeYn&facility_id="+facility_id+"&oper_room_code="+obj;
	xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);	
	formObj.chk_holding_area_chrg_yn_stg.value=retVal;
	if(retVal=="N"){
		if(function_id_temp=="" && charge_hold_area_yn=="Y" && inventry_chk_yn_DB=="Y"){
			document.getElementById("chrg_unit_show_yn").style.visibility = 'hidden';
			document.getElementById("pyble_unit_show_yn").style.visibility = 'hidden';
			//modified by DhanasekarV  for holding area mandatory checkout
				document.getElementById("hold_area_img").style.visibility = 'hidden';
	
			document.getElementById("charge_details").style.display='none';
			document.forms[0].change_out_date.value="";
			document.forms[0].change_out_date_time.value="";
			document.forms[0].charge_units.value="";

		}else if(function_id_temp=="33" && charge_hold_area_yn=="Y" && inventry_chk_yn_DB=="Y"){
			document.getElementById("chrg_unit_show_yn_1").style.visibility = 'hidden';
			document.getElementById("pyble_unit_show_yn_1").style.visibility = 'hidden';
			//modified by DhanasekarV  for holding area mandatory checkout
			document.getElementById("change_hold_img").style.visibility = 'hidden';

			document.getElementById("charge_details_1").style.display='none';
			document.forms[0].change_date_1.value="";
			document.forms[0].change_date_time_1.value="";
			document.forms[0].charge_units_1.value="";
		}
	}else if(retVal=="Y" && charge_hold_area_yn=="Y" && inventry_chk_yn_DB=="Y"){
		if(function_id_temp==""){
			document.getElementById("chrg_unit_show_yn").style.visibility = 'visible';
			document.getElementById("pyble_unit_show_yn").style.visibility = 'visible';
			//modified by DhanasekarV  for holding area mandatory checkout
				document.getElementById("hold_area_img").style.visibility = 'visible';

			//document.getElementById("charge_details").style.display='block';				
		//	document.forms[0].change_out_date.value="";
		//	document.forms[0].change_out_date_time.value="";
		//	document.forms[0].charge_units.value="";
		}else if(function_id_temp=="33" && charge_hold_area_yn=="Y" && inventry_chk_yn_DB=="Y" ){
			document.getElementById("chrg_unit_show_yn_1").style.visibility = 'visible';
			document.getElementById("pyble_unit_show_yn_1").style.visibility = 'visible';
						//modified by DhanasekarV  for holding area mandatory checkout
			document.getElementById("change_hold_img").style.visibility = 'visible';

			//document.getElementById("charge_details_1").style.display='block';
		//	document.forms[0].change_date_1.value="";
		//	document.forms[0].change_date_time_1.value="";
		//	document.forms[0].charge_units_1.value="";
		}
	
	}
	//document.forms[0].inventry_chk_yn.value=retVal;
}

function localTrimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}

function checkCheckInTime(){
		var formObj=document.forms[0];
		var oper_num=formObj.oper_num.value;
		var facility_id=formObj.facility_id.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "func_mode=checkInTime&facility_id="+facility_id+"&oper_num="+oper_num;
		xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		return retVal;

}


function checkApplyCheckInTime(){
		var formObj=document.frames.holding_area_frame.document.HoldingAreaForm;
		var oper_num=formObj.oper_num.value;
		var facility_id=formObj.facility_id.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "func_mode=checkInTime&facility_id="+facility_id+"&oper_num="+oper_num;
		xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		return retVal;

}

function checkApplyCheckOutholdingAreaTime(){
		var formObj=document.frames.holding_area_frame.document.HoldingAreaForm;
		var oper_num=formObj.oper_num.value;
		var facility_id=formObj.facility_id.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "func_mode=checkInHldingAreaTime&facility_id="+facility_id+"&oper_num="+oper_num;
		xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		return retVal;

}



function checkTimeFormat(obj){
	var formObj=document.HoldingAreaForm;
	var locale=formObj.locale.value;
	var change_out_date=formObj.change_out_date.value;
	var function_id_temp=formObj.function_id_temp.value;
	var cur_date_time = "";
	var chk_in_time=obj.value;
	if(function_id_temp==""){
		cur_date_time = dateUtils(formObj.check_in_date.value,locale)+" "+formObj.check_date_time.value;
	}else if(function_id_temp==""){
		cur_date_time = dateUtils(formObj.change_date.value,locale)+" "+formObj.change_date_time.value;
	}
	if(change_out_date!=""){
		if(obj.value!=null && obj.value!=""){
			var retVal = chkTime(obj.value);
			if(retVal==false){
				alert(getMessage("VALID_TIME_SLOTS","OT"));		
				obj.value="";
				obj.focus();
				//obj.select();
			}
			if(chk_in_time.length!=5){
				alert(getMessage("VALID_TIME_SLOTS","OT"));		
				obj.value="";
				obj.focus();
				//obj.select();
			}
		}
			var database_system_date_time = getSysDateTime();
			database_system_date_time = dateUtils(trimString(database_system_date_time),locale);
			var retVal = compareDates(cur_date_time,database_system_date_time,"en",'DMYHM');
			if(retVal==false){
				var msg_1 = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
				var msgArr = msg_1.split("#");
				var checkin_time = getLabel("eOT.CheckInTime.Label","OT");
				var systemdatetime =getLabel("Common.SystemDateTime.label","Common");
				alert(msgArr[0]+ checkin_time  +msgArr[1]+ systemdatetime +msgArr[2]);
				obj.focus();
				obj.select();
				return;
			}
	}else{
		var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOT.CheckedOutDate.Label","OT"));
		alert(msg1);
		formObj.change_out_date_time.value="";
		return;

	}
}

function getSysDateTime(){
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="HoldingAreaValidation.jsp?func_mode=getSysDateTime";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	return responseText;
}

function CheckMandatoryFields(){
	var fields="";
	var names="";
	var checkedInDateTime=getLabel("eOT.CheckedInDateTime.Label","OT");
	var holdingBay=getLabel("eOT.HoldingBay.Label","OT");

	var checkedOutDate=getLabel("eOT.CheckedOutDate.Label","OT");
	var checkedOutTime=getLabel("eOT.CheckedOutTime.Label","OT");
	var messageFrame = parent.parent.messageFrame;
	var formObj=document.frames.holding_area_frame.document.HoldingAreaForm;
	var size = formObj.size.value;
	var function_id_temp = formObj.function_id_temp.value;
	/*Added by Suma against incident 18979*/
	var charge_hold_area_yn_DB = formObj.charge_hold_area_yn_DB.value;
	/*ends here*/

	if(function_id_temp==""){		
		var hold_area_code=formObj.change_holding_code.value;
		var ret_val=hideChargeBillDtlChkApply(hold_area_code);
		if(ret_val=="Y"){
	/*Added by Suma against incident 18979 condition (charge_hold_area_yn_DB =="Y") */
			if(charge_hold_area_yn_DB =="Y")
			{
			fields= new Array(formObj.check_in_date, formObj.change_holding_desc,formObj.change_out_date,formObj.change_out_date_time);
			names=new Array(checkedInDateTime,holdingBay,checkedOutDate,checkedOutTime);	
			}else
			{
			fields= new Array(formObj.check_in_date, formObj.change_holding_desc);
			names=new Array(checkedInDateTime,holdingBay);	
			}
				/*ends here*/

		}else{
			fields= new Array(formObj.check_in_date, formObj.change_holding_desc);
			names=new Array(checkedInDateTime,holdingBay);	
		}
	}else{		
		var hold_area_code=formObj.change_holding_code_1.value;
		if(hold_area_code!=0){
		var ret_val=hideChargeBillDtlChkApply(hold_area_code);
		

		if(ret_val=="Y"){			
			fields= new Array(formObj.change_date,formObj.change_holding_desc_1,formObj.change_date_1,formObj.change_date_time_1);
			names=new Array(checkedInDateTime,holdingBay,checkedOutDate,checkedOutTime);	
		}else{			
			//fields=new Array(formObj.change_date_time_1,formObj.change_holding_desc_1);
			fields=new Array(formObj.change_date,formObj.change_holding_desc_1);
			names=new Array(checkedInDateTime,holdingBay);		
		}
		}else{
			var holdingBay=getLabel("eOT.HoldingBay.Label","OT");
			var msg=getMessage("CANNOT_BE_BLANK","OT");
			var msgArray = msg.replace("&",holdingBay);
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msgArray;	
			return false;
		}

	}
	
	if(checkFields(fields,names,messageFrame)==false){
		return false;
	}

	if(checkDuplicateCode()==true){
		//var message="Holding Bay cannot be Duplicated";
		var message=getMessage("DUPLICATE_CODE_EXISTS","common");
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;	
		return false;
	}


	return true;
}
function checkDuplicateCode(){
	//if flag = true code is duplicate otherwise vice-versa
	var flag=false;
	var formObj = document.frames.holding_area_frame.document.HoldingAreaForm;
	var holding_bay_size = formObj.holding_bay_size.value;
	return flag;
}

function isRecordVitalEnable(){
 var formObj =  parent.common_patient_hdr_frame.document.all; 
 var discr_msr_id  = formObj.discr_msr_id.value;
 var speciality_code  = formObj.speciality_code.value;
 if( discr_msr_id=='null' || discr_msr_id==null ||  discr_msr_id =='' ){
	   formObj.record_vitals.style.visibility = 'visible';
 }
 /* Commented by Muthukumar against SRR20056-SCF-7683 on 12-09-2011 
 else{
	 formObj.record_vitals.style.visibility = 'visible';
 }*/
}

async function callRecordVitals_holidingarea(){
	var formObj =  parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var formObjDtl=parent.holding_area_frame.HoldingAreaForm;
	var speciality_code = formObj.speciality_code.value;
	var discr_msr_id  = formObj.discr_msr_id.value;
	var facility_id = formObjDtl.facility_id.value;
	var patient_id = formObj.patient_id.value;
	var episode_id = formObj.episode_id.value;
	var sex = formObj.sex.value;
	var dob = formObj.date_of_birth.value;
	var encounter_id = formObj.encounter_id.value;
	var patient_class = formObj.patient_class.value;
	var episode_type = formObj.episode_type.value;
	var window_name = patient_id+encounter_id;
	var date_time = trimString(getSysDateTime());
	var url='../../eCA/jsp/ChartRecording.jsp?patient_id='+patient_id+'&function_from=CP&p_start_date_time='+date_time+'&Chart_Id='+discr_msr_id+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id;
	var retVal;
	var dialogHeight = window.screen.availHeight ;
	var dialogWidth  = window.screen.availWidth ;
	var dialogTop    = "0";
	var dialogLeft   = "0";
	var features = "dialogHeight:" + dialogHeight + ";dialogWidth:" + dialogWidth+ "; left:"+dialogLeft+";top:"+dialogLeft+";status:no;resizable:no";
	var arguments    = "" ;
	retVal 	   = await window.showModalDialog(url, arguments, features);
	//retVal  = window.open(url, arguments, features);
 }

function assignSpecialityCode(){
	var formObjHdr =  parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var formObj = document.HoldingAreaForm;
	formObj.speciality_code.value = formObjHdr.oper_speciality_code.value;
	var frmobj=document.forms[0];
	var function_id_temp=formObj.function_id_temp.value;
	//alert(formObj.change_holding_code.value)
	if(function_id_temp==""){
		var chnge_bay_code=formObj.change_holding_code.value;
		var chnge_out_date=formObj.change_out_date.value;
		var charge_hold_area_yn_DB=formObj.charge_hold_area_yn_DB.value;
		var hlding_bay_chrg_yn=hideChargeBillDtlChk(chnge_bay_code);
		if(hlding_bay_chrg_yn=="Y" && charge_hold_area_yn_DB=="Y"){
			if(chnge_out_date!=""){
				window.parent.frames[0].document.forms[0].apply.disabled=true;
			}
			if(chnge_bay_code!=""){
				hideChargeBillDtls(chnge_bay_code);
				callOnLoadChargeUnits();
			}
		}
		}else{
			var chnge_bay_code_1=formObj.change_holding_code_1.value;
			var hlding_bay_chrg_yn=hideChargeBillDtls(chnge_bay_code_1);
			if(hlding_bay_chrg_yn=="Y"){
				if(chnge_bay_code_1!=""){
					hideChargeBillDtls(chnge_bay_code_1);
				}
			}
		}
}

function callOnLoadChargeUnits(){
	var formObj=document.forms[0];
	var facility_id=formObj.facility_id.value;
	var checked_in_date_DB=formObj.checked_in_date_DB.value;
	var checked_in_time_DB=formObj.checked_in_time_DB.value;
	var checked_out_date_DB=formObj.checked_out_date_DB.value;
	var checked_out_time_DB=formObj.checked_out_time_DB.value;
	var holding_area_code_DB=formObj.holding_area_code_DB.value;
	var modified_charge_units_DB=formObj.modified_charge_units_DB.value;
	var chrg_stg = formObj.inventry_chk_yn_DB.value;
	var hold_chrg_fin_chk_yn = formObj.charge_hold_area_yn_DB.value;
//	var change_holding_desc=formObj.change_holding_desc_1.value;
	var chk_in_dt_time=checked_in_date_DB+" "+checked_in_time_DB;
	var chk_out_dt_time=checked_out_date_DB+" "+checked_out_time_DB;
//	var change_holding_code=formObj.change_holding_code.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "chk_in_dt_time="+chk_in_dt_time+"&chk_out_dt_time="+chk_out_dt_time+"&change_holding_code="+holding_area_code_DB+"&facility_id="+facility_id;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","HoldingAreaChargeUnits.jsp?func_mode=callChargeUnits&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var arrVal=retVal.split("##")
	if(arrVal[2]==null)arrVal[2]="";
	if(arrVal[3]==null)arrVal[3]="";
	if(arrVal[4]==null)arrVal[4]="";
	if(arrVal[2]!="" || arrVal[3]!="" || arrVal[4]!=""){
		if(arrVal[4]=="")
			{
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "func_mode=getErrmsg&msg_id="+arrVal[3];
			xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			alert(retVal)
			window.close();
			}else
			{
				alert(arrVal[4])
				window.close();
			}
			return;
	}else{
			if(hold_chrg_fin_chk_yn=="Y" && chrg_stg=="Y"){
				if(modified_charge_units_DB==""){
					formObj.charge_units.value=arrVal[0];
					modified_charge_units_DB=arrVal[0];
					formObj.charge_units.disabled=true;
				}
				serv_code_1=arrVal[1];
				billServPanelDtls(modified_charge_units_DB,serv_code_1);
		}
	}
}
	
function assignChkInOutTime(){
	var formObj = document.HoldingAreaForm;
	var holding_area_code_DB=formObj.holding_area_code_DB.value;
	var charge_hold_area_yn_DB=formObj.charge_hold_area_yn_DB.value;
	var inventry_chk_yn_DB=formObj.inventry_chk_yn_DB.value;
	var hlding_area_chrg_yn=hideChargeBillDtlChk(holding_area_code_DB);
	//alert( 'enter here ');
	if(hlding_area_chrg_yn=="N" && charge_hold_area_yn_DB=="N" && inventry_chk_yn_DB=="N"){

		//Commented by DhanasekarV against script error issue
		if(document.getElementById("chrg_unit_show_yn") != null)
		{
		document.getElementById("chrg_unit_show_yn").style.visibility = 'hidden';
		document.getElementById("pyble_unit_show_yn").style.visibility = 'hidden';
		}
	  
		
	}else if(hlding_area_chrg_yn=="Y" && charge_hold_area_yn_DB=="Y"&&inventry_chk_yn_DB=="Y"){
		var modified_charge_units_DB=formObj.modified_charge_units_DB.value;

		if(document.getElementById("chrg_unit_show_yn")  != null)
		{
			document.getElementById("chrg_unit_show_yn").style.visibility = 'visible';
			document.getElementById("pyble_unit_show_yn").style.visibility = 'visible';
		}
	
		formObj.charge_units.value=modified_charge_units_DB;
		callChargableUnitsforCheckedBay();
	}
}


function callChargableUnitsforCheckedBay(){
	var formObj=document.forms[0];
	var facility_id=formObj.facility_id.value;
	var chk_in_date=formObj.check_in_date.value;
	var checked_in_date_DB=formObj.checked_in_date_DB.value;
	var checked_in_time_DB=formObj.checked_in_time_DB.value;
	var checked_out_date_DB=formObj.checked_out_date_DB.value;
	var checked_out_time_DB=formObj.checked_out_time_DB.value;

	var modified_charge_units_DB=formObj.modified_charge_units_DB.value;
	var holding_area_code_DB=formObj.holding_area_code_DB.value;
	var chk_in_dt_time=checked_in_date_DB+" "+checked_in_time_DB;
	var chk_out_dt_time=checked_out_date_DB+" "+checked_out_time_DB;
	var change_holding_code=formObj.holding_bay_code.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "chk_in_dt_time="+chk_in_dt_time+"&chk_out_dt_time="+chk_out_dt_time+"&change_holding_code="+holding_area_code_DB+"&facility_id="+facility_id;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","HoldingAreaChargeUnits.jsp?func_mode=callChargeUnits&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var arrVal=retVal.split("##")
	if(arrVal[2]=="" || arrVal[3]=="" || arrVal[4]==""){
		if(modified_charge_units_DB!=""){
		formObj.charge_units.value=checkNull(modified_charge_units_DB);
		}else{
		formObj.charge_units.value=arrVal[0];
		}
	}
		formObj.service_code.value=arrVal[1];
		if(modified_charge_units_DB!=""){
			units=modified_charge_units_DB;
		}else{
			units=arrVal[0];
		}
		serv_code=arrVal[1];
		callOnloadbillServPanelDtls(units,serv_code);
}


function callGetServPanelDtls(units, serv_code){
		var formObj=document.forms[0];
		var locale = formObj.locale.value;
		var facility_id=formObj.facility_id.value;
		var oper_num=formObj.oper_num.value;
		var module_id=formObj.module_id.value;
		var patient_id=formObj.patient_id.value;
		var booking_num=formObj.booking_num.value;
		var order_id=formObj.order_id.value;
		var speciality_code=formObj.speciality_code.value;
		var oper_code=formObj.oper_code.value;
		var surgeon_code=formObj.surgeon_code.value;
		var function_id_temp=formObj.function_id_temp.value;
		var charge_units=formObj.charge_units.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		if(function_id_temp=""){
		var change_out_date_time=formObj.change_out_date_time.value;
		var charge_units=formObj.charge_units.value;
		if(change_out_date_time!=""){
			if(charge_units==""){
				var msg1 = getMessage("CANNOT_BE_BLANK","OT").replace("&",getLabel("eOT.ChargableUnits.Label","OT"));
				alert(msg1);
					formObj.charge_units.select();
					return;
				}else if(charge_units=="0" || charge_units=="00" || charge_units=="000"){
					var msg1 = getMessage("APP-OT0068","OT").replace("#",getLabel("eOT.ChargableUnits.Label","OT"));
					alert(msg1);
					formObj.charge_units.select();
					return;
				}
			}
		}
		var params = "units="+units+"&serv_code="+serv_code+"&locale="+locale+"&facility_id="+facility_id+"&oper_num="+oper_num+"&module_id="+module_id+"&patient_id="+patient_id+"&booking_num="+booking_num+"&order_id="+order_id+"&speciality_code="+speciality_code+"&oper_code="+oper_code+"&surgeon_code="+surgeon_code;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","HoldingAreaChargeUnits.jsp?func_mode=callServPanel&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		var arrVal=retVal.split("$$");
		var lbl_total=getLabel("Common.total.label","common_labels")+" "+getLabel("eOT.Payable.Label","ot_labels");
		var lbl_payable=getLabel("Common.PatientPayable.label","common_labels");
		var lbl_paid=getLabel("Common.PatientPaid.label","common_labels");
		var included=getLabel("eOT.Included.Label","ot_labels");
		var app_reqd=getLabel("eOT.ApprovalRequired.Label","ot_labels");
		var disabled="<img width=15px   align='texttop' height='15px' src='../../eCommon/images/disabled.gif'></img>";
		var enabled="<img width=15px   align='texttop' height='15px' src='../../eCommon/images/enabled.gif'></img>";
		document.forms[0].panel_str.value=arrVal[0];
		var Total=arrVal[2];
		var Payable=arrVal[3];
		var Paid = arrVal[6];
		var include_exclude="";
		var Appr_reqd_val="";
		if(arrVal[4]=="I"){
			include_exclude=enabled;	
		}else{
			include_exclude=disabled;	
		}
		if(arrVal[5]=="Y"){
			Appr_reqd_val=enabled;	
		}else{
			Appr_reqd_val=disabled;	
		}
		if(Paid==""){
			Paid="0.0";
		}
		document.forms[0].appr_reqd_val.value=arrVal[5];
		callBillingWindow(); //check
		document.getElementById("charge_details").style.display='block';
		//document.getElementById("charge_details").style.display='Inline';
		var str="<B><font color='Indigo'>"+included+":&nbsp;"+include_exclude+"</font>&nbsp;&nbsp;";
		str+="<font color='Indigo'>"+app_reqd+":&nbsp;"+Appr_reqd_val+"</font>&nbsp;&nbsp;";
		str+= "<font color='Indigo' >"+lbl_total+":&nbsp;"+Total+"</font>&nbsp;&nbsp;";
		str+="<font color='crimson' >"+lbl_payable+":&nbsp;"+Payable+"</font>&nbsp;&nbsp;";
		str+="<font color='green'>"+lbl_paid+":&nbsp;"+Paid+"</font>&nbsp;&nbsp;</B>";
		str+="<a class='gridLink' href=\"javascript:callBillingWindow1();\"><img src='../../eOT/images/dollar.png'></img></a>";
		eval("document.getElementById("charge_details")").innerHTML = str;
		
}


function onBlurHoldingAreaChrgUnitspayale( serv_code){
		var lbl_total=getLabel("Common.total.label","common_labels")+" "+getLabel("eOT.Payable.Label","ot_labels");
		var lbl_payable=getLabel("Common.PatientPayable.label","common_labels");
		var lbl_paid=getLabel("Common.PatientPaid.label","common_labels");
		var included=getLabel("eOT.Included.Label","ot_labels");
		var app_reqd=getLabel("eOT.ApprovalRequired.Label","ot_labels");
		var disabled="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/disabled.gif'></img>";
		var enabled="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/enabled.gif'></img>";
		var formObj=document.forms[0];
		var locale = formObj.locale.value;
		var facility_id=formObj.facility_id.value;
		var oper_num=formObj.oper_num.value;
		var module_id=formObj.module_id.value;
		var patient_id=formObj.patient_id.value;
		var booking_num=formObj.booking_num.value;
		var order_id=formObj.order_id.value;
		var speciality_code=formObj.speciality_code.value;
		var oper_code=formObj.oper_code.value;
		var surgeon_code=formObj.surgeon_code.value;
		var change_out_date_time=formObj.change_out_date_time.value;
		var charge_units=formObj.charge_units.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var change_out_date_time=formObj.change_out_date_time.value;
		var charge_units=formObj.charge_units.value;
		if(change_out_date_time!=""){
			if(charge_units==""){
				var msg1 = getMessage("CANNOT_BE_BLANK","OT").replace("&",getLabel("eOT.ChargableUnits.Label","OT"));
				alert(msg1);
					formObj.charge_units.select();
					return;
				}else if(charge_units=="0" || charge_units=="00" || charge_units=="000"){
					var msg1 = getMessage("APP-OT0068","OT").replace("#",getLabel("eOT.ChargableUnits.Label","OT"));
					alert(msg1);
					formObj.charge_units.select();
					return;
				}
			}
		var params = "units="+charge_units+"&serv_code="+serv_code+"&locale="+locale+"&facility_id="+facility_id+"&oper_num="+oper_num+"&module_id="+module_id+"&patient_id="+patient_id+"&booking_num="+booking_num+"&order_id="+order_id+"&speciality_code="+speciality_code+"&oper_code="+oper_code+"&surgeon_code="+surgeon_code;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","HoldingAreaChargeUnits.jsp?func_mode=callServPanel&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		var arrVal=retVal.split("$$");
		document.forms[0].bl_panel_str.value=arrVal[0];
		var Total=arrVal[2];
		var Payable=arrVal[3];
		var Paid = arrVal[6];
		var include_exclude="";
		var Appr_reqd_val="";
		if(arrVal[4]=="I"){
			include_exclude=enabled;	
		}else{
			include_exclude=disabled;	
		}
		if(arrVal[5]=="Y"){
			Appr_reqd_val=enabled;	
		}else{
			Appr_reqd_val=disabled;	
		}
		callBillingWindow();
		formObj.include_exclude.value=include_exclude;
		formObj.appr_reqd_val.value=Appr_reqd_val
//		document.getElementById("charge_details").style.display='Inline';
		document.getElementById("charge_details").style.display='block';
		paintBillDetails(Total,Payable,Paid,include_exclude,Appr_reqd_val);

}

function pushAllValuestoOR(key,key_line,oper_num,bay_code,service_code,charge_units){
	var formObj=document.forms[0];
	var param = "key="+key+"&key_line="+key_line+"&oper_num="+oper_num+"&bay_code="+bay_code+"&service_code="+service_code+"&charge_units="+charge_units+"&called_from=PassBillDetails&room_id=HB";
	var xmlStr ="<root></root>";
	var temp_jsp="OTInterRoomCharges.jsp?"+param;
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText);

}


function callBillingWindow(){
	var formObj=document.forms[0];
	var function_id=formObj.function_id_temp.value;
	var oper_num=formObj.oper_num.value;
	var bay_code="";
	var service_code="";
	var charge_units="";
	var key="";
	var key_line="";
	if(function_id==""){
		bay_code=formObj.change_holding_code.value;
		service_code=formObj.service_code.value;
		charge_units=formObj.charge_units.value;
		key=formObj.accession_num.value;
		key_line = document.forms[0].bill_acc_num_add.value;
	}else{
		bay_code=formObj.change_holding_code_1.value;
		service_code=formObj.service_code_1.value;
		charge_units=formObj.charge_units_1.value;
		key=formObj.accession_num_1.value;
		key_line = document.forms[0].bill_acc_num_add.value;
	}
	pushAllValuestoOR(key,key_line,oper_num,bay_code,service_code,charge_units);
	var param = "order_id="+key+"&order_line_num="+key_line+"&called_from=SURG_ACC";
	var xmlStr ="<root></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	//showBillingWindow(responseText,"1");
}

function callBillingWindow1(){
	var formObj=document.forms[0];
	var function_id=formObj.function_id_temp.value;
	var oper_num=formObj.oper_num.value;
	var bay_code="";
	var service_code="";
	var charge_units="";
	var key="";
	var key_line="";
	if(function_id==""){
		bay_code=formObj.change_holding_code.value;
		service_code=formObj.service_code.value;
		charge_units=formObj.charge_units.value;
		key=formObj.accession_num.value;
		key_line = document.forms[0].bill_acc_num_add.value;
	}else{
		bay_code=formObj.change_holding_code_1.value;
		service_code=formObj.service_code_1.value;
		charge_units=formObj.charge_units_1.value;
		key=formObj.accession_num_1.value;
		key_line = document.forms[0].bill_acc_num_add.value;
	}
//	pushAllValuestoOR(key,key_line,oper_num,bay_code,service_code,charge_units);
	var param = "order_id="+key+"&order_line_num="+key_line+"&called_from=SURG_ACC";
	var xmlStr ="<root></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	showBillingWindow(responseText,"1");
}


function paintBillDetails(Total,Payable,Paid,include_exclude,Appr_reqd_val){
	var formObj=document.forms[0];
	var func_id=formObj.function_id_temp.value;
	var inc_exc=formObj.include_exclude.value;
	var appr_reqd_val=formObj.appr_reqd_val.value;
	if(Appr_reqd_val==""){
		Appr_reqd_val=appr_reqd_val;
	}
	if(include_exclude==""){
		include_exclude=inc_exc;
	}
	if(Paid==""){
	Paid="0.0";
	}
	var lbl_total=getLabel("Common.total.label","common_labels")+" "+getLabel("eOT.Payable.Label","ot_labels");
	var lbl_payable=getLabel("Common.PatientPayable.label","common_labels");
	var lbl_paid=getLabel("Common.PatientPaid.label","common_labels");
	var included=getLabel("eOT.Included.Label","ot_labels");
	var app_reqd=getLabel("eOT.ApprovalRequired.Label","ot_labels");
	var disabled="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/disabled.gif'></img>";
	var enabled="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/enabled.gif'></img>";

	var str="<B><font color='Indigo'>"+included+":&nbsp;"+include_exclude+"</font>&nbsp;&nbsp;";
	str+="<font color='Indigo'>"+app_reqd+":&nbsp;"+Appr_reqd_val+"</font>&nbsp;&nbsp;";
	str+= "<font color='Indigo' >"+lbl_total+":&nbsp;"+Total+"</font>&nbsp;&nbsp;";
	str+="<font color='crimson' >"+lbl_payable+":&nbsp;"+Payable+"</font>&nbsp;&nbsp;";
	str+="<font color='green'>"+lbl_paid+":&nbsp;"+Paid+"</font>&nbsp;&nbsp;</B>";
	str+="<a class='gridLink' href=\"javascript:callBillingWindow1();\"><img src='../../eOT/images/dollar.png'></img></a>";
	if(func_id==""){
		eval("document.getElementById("charge_details")").innerHTML = str;
	}else{
		eval("document.getElementById("charge_details_1")").innerHTML = str;
	}

}

async function showBillingWindow(str,key){
	var formObj=document.forms[0];
	var title=encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"));
	var arr = str.split("::");
	var column_sizes = "";
	var column_descriptions ="";       
	var episode_type = arr[4];
	var patient_id=arr[3];
	var visit_id=arr[6];
	var episode_id=arr[5];         
	var service_panel_code=arr[12];     //---service code returining from billing proc
	var service_panel_ind=arr[11];;						  //---to be check
	var service_date=arr[8];							  //---to be chedk
	var order_catalog_code=arr[2];      
	var module_id = "OT";
	var encounter_id=arr[7]; 
	var key=arr[0]; 
	var key_line_no=arr[1];//--- to be check
//	var order_id=formObj.order_id.value; 
	var order_id=arr[0]; //changed by sathish instruction
//	var order_line_no=formObj.bill_acc_num_add.value;//--- to be check
	var order_line_no=arr[1]//--- to be check
	var bean_id=""; 
	var total_qty =formObj.charge_units.value;				//---to be check
	var revised_qty = formObj.charge_units.value;
	var original_qty = formObj.calc_chrge_units.value;      //calc_chrge_units,charge_units 
	var bl_panel_str = arr[13];				//Panel Str returing from units
//	var bl_panel_str = formObj.bl_panel_str.value;				//Panel Str returing from units
	var index_val="";
	var dialogTop = "100";
	var dialogHeight = "30" ;
	var dialogWidth = "70" ;
	var inc_exe=""; 
	var apprvl_reqd_yn="";  // dummy var created for painting the bill details in front end
	var inc_exclude=formObj.include_exclude.value;
	var appr_reqd_value=formObj.appr_reqd_val.value;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments = "" ;
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"episode_type="+episode_type+"&"+"patient_id="+patient_id+"&"+"visit_id="+visit_id+"&"+"episode_id="+episode_id+"&"+"service_panel_code="+service_panel_code+"&"+"service_panel_ind="+service_panel_ind+"&"+"service_date="+service_date+"&"+"order_catalog_code="+order_catalog_code+"&"+"module_id="+module_id+"&encounter_id="+encounter_id+"&key="+key+"&key_line_no="+key_line_no+"&order_id="+order_id+"&order_line_no="+order_line_no+"&bean_id="+bean_id+"&total_qty="+total_qty+"&revise_qty="+revised_qty+"&original_qty="+original_qty+"&quantity="+revised_qty+"&qty="+revised_qty+"&p_serv_qty="+revised_qty+"&revised_qty="+revised_qty+"&serv_panel_qty="+revised_qty+"&modify_qty_yn=Y&p_str="+bl_panel_str+"&called_from=OT";//AMRI-SCF-0427
	var retVal = await window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?"+param,arguments,features);
		if(retVal!=null){
			var retArray  = retVal;
			if(retArray[8]=="I"){
				inc_exe="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/enabled.gif'></img>";
			}else if(retArray[8]=="E"){
				inc_exe="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/disabled.gif'></img>";
			}/*else if(retArray[]=="")
			{
				if(inc_exclude=="I"){
					inc_exe="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/enabled.gif'></img>";
				}else if(inc_exclude=="E"){
					inc_exe="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/disabled.gif'></img>";
				}
				if(appr_reqd_value=="Y"){
					apprvl_reqd_yn="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/enabled.gif'></img>";
				}else if(appr_reqd_value=="N"){
					apprvl_reqd_yn="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/disabled.gif'></img>";
				}
			}*/

		if(retArray[6]!="" && retArray[7]!=""){
			formObj.inc_exe_blng_wdw.value=retArray[6];
			formObj.reason_inc_exc.value=retArray[7];
		}else{
			formObj.inc_exe_blng_wdw.value="";
			formObj.reason_inc_exc.value="";
		}
		if(apprvl_reqd_yn==""){
			apprvl_reqd_yn=appr_reqd_value;
		}
		if(appr_reqd_value=="Y"){
			apprvl_reqd_yn="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/enabled.gif'></img>";
		}else if(appr_reqd_value=="N"){
			apprvl_reqd_yn="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/disabled.gif'></img>";
		}

			paintBillDetails(retArray[1],retArray[2],retArray[3],inc_exe,apprvl_reqd_yn);
			PaintPanelStringval();
		}
}

function PaintPanelStringval()
{
	var formObj=document.forms[0];
	var function_id=formObj.function_id_temp.value;
	var oper_num=formObj.oper_num.value;
	var bay_code="";
	var service_code="";
	var charge_units="";
	var key="";
	var key_line="";
	if(function_id==""){
		bay_code=formObj.change_holding_code.value;
		service_code=formObj.service_code.value;
		charge_units=formObj.charge_units.value;
		key=formObj.accession_num.value;
		key_line = document.forms[0].bill_acc_num_add.value;
	}else{
		bay_code=formObj.change_holding_code_1.value;
		service_code=formObj.service_code_1.value;
		charge_units=formObj.charge_units_1.value;
		key=formObj.accession_num_1.value;
		key_line = document.forms[0].bill_acc_num_add.value;
	}
//	pushAllValuestoOR(key,key_line,oper_num,bay_code,service_code,charge_units);
	var param = "order_id="+key+"&order_line_num="+key_line+"&called_from=SURG_ACC";
	var xmlStr ="<root></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	var arr = responseText.split("::");
	var bl_panel_str = arr[13];	
	document.forms[0].bl_panel_str.value=bl_panel_str;

}

function callRecordNotes(){	
/*New changes done by Suma on 16 march 2010 to handle null pointer exception when CA notes page is opened without proxy*/

	var formObj =  parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var formObjDtl=parent.holding_area_frame.HoldingAreaForm;
	var facility_id = formObj.facility_id.value;
	var patient_id = formObj.patient_id.value;
	var episode_id = formObj.episode_id.value;
	var patient_class = formObj.patient_class.value;
	var encounter_id = formObj.encounter_id.value;
	var slate_user_id = formObj.slate_user_id.value;
	var window_close="Y";
	var speciality_code=formObj.oper_speciality_code.value;
	var hide_header="N";
	var locn_type="10";
	var tab_yn="N";
	var function_id="SPCL_NOTE";
	var event_class="$PHY$";
	var oper_num = formObj.oper_num.value;
	var update_mode="N";
	var title= getLabel("eOT.HoldingAreaNotes.Label","OT");	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=Surgeon_notes_dispaly&accession_num="+oper_num+"&facility_id="+facility_id+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&encounter_id="+encounter_id+"&called_from=HOLD_NOTES&speciality_code="+speciality_code+"&locn_type="+locn_type+"&slate_user_id="+slate_user_id,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var arr_spec=retVal.split("~");
	var arr2_spec="";
	var note_type_value="";
	var accession_num="";
	for (var m=0;m<arr_spec.length-1;m++ )
	{
		note_type_value=arr_spec[m];
		arr2_spec=note_type_value.split(",");
		opt = parent.frames[0].document.createElement('OPTION');
		opt.text =arr2_spec[1];
		opt.value=arr2_spec[0];
		parent.frames[2].document.forms[0].contr_mod_accession_num.value=arr2_spec[2];
		parent.frames[2].document.forms[0].note_type_val.add(opt);
		parent.frames[2].document.forms[0].update_mode.value=arr2_spec[3];
		parent.frames[2].document.forms[0].accession_num.value=arr2_spec[4];
	}

	/*if(retVal !="")
	   {
			var obj1=document.forms[0].note_type_val;
	  var len =obj1.options.length;
	  while (len-- >= 0) obj1.remove(obj1.options[0]);
	  opt=document.createElement('OPTION');
	  opt.value='';
	  opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	  obj1.add(opt);
	   }*/

/*Added by Suma ends here*/


/*	var url = "../../eOT/jsp/SelectNoteTypeFrames.jsp?patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&accession_num="+oper_num+"&speciality_code="+speciality_code+"&hide_header="+hide_header+"&tab_yn="+tab_yn+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&locn_type=10&called_from=HOLD_NOTES&slate_user_id="+slate_user_id;
alert(url);
	var retVal;
	var arguments    = "" ;
	retVal 	   = window.open(url, arguments, 'height=35,width=300,top=250,left=250,resizable=no');*/

}



async function onselectnotetypeholding(obj)
	{		
	var formObj =  parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;	
	var formObjDtl=parent.holding_area_frame.HoldingAreaForm;	
	var facility_id = formObj.facility_id.value;
	var patient_id = formObj.patient_id.value;
	var episode_id = formObj.episode_id.value;
	var patient_class = formObj.patient_class.value;
	var encounter_id = formObj.encounter_id.value;
	var slate_user_id = formObj.slate_user_id.value;
	var window_close="Y";
	var speciality_code=formObj.oper_speciality_code.value;
	var accession_num= parent.frames[2].document.forms[0].accession_num.value;
	var hide_header="N";
	var locn_type="10";
	var tab_yn="N";
	var function_id="SPCL_NOTE";
	var event_class="$PHY$";
	var oper_num = formObj.oper_num.value;
	var update_mode=parent.frames[2].document.forms[0].update_mode.value;
	var title= getLabel("eOT.HoldingAreaNotes.Label","OT");
	var performed_by_ql=formObj.strUser.value;	
	if(obj.value !="")
		{
			
				var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=chk_note_exists&accession_num="+oper_num+"&facility_id="+facility_id+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&encounter_id="+encounter_id+"&called_from=HOLD_NOTES&speciality_code="+speciality_code+"&locn_type="+locn_type+"&slate_user_id="+slate_user_id,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);

	//alert(retVal);
	if(retVal =="")
	{
		//Added performed_by_ql on 1/19/2011 by Anitha for 25928

		var action_url	=	"../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=OT_NOTES&title="+encodeURIComponent(title)+"&note_type="+obj.value+"&patient_id="+patient_id+"&patient_class="+patient_class+"&function_id="+function_id+"&event_class="+event_class+"&accession_num="+accession_num+"&window_close="+window_close+"&ot_speciality_code="+speciality_code+"&hide_header="+hide_header+"&tab_yn="+tab_yn+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&contr_mod_accession_num="+parent.frames[2].document.forms[0].contr_mod_accession_num.value+"&performed_by_ql="+performed_by_ql;
		var title1="";
		var dialogHeight= "100";
		var dialogWidth	= "100";
		var status = "no";
		var arguments	= "";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		secondwindow  = await window.showModalDialog(action_url, title1, features);
		parent.frames[2].document.forms[0].note_type_val.selectedIndex=0;
			}else
			{
			var arr_spec=retVal.split("*");
			var arr2_spec="";
			var note_type_value="";
			var accession_num="";
			for (var m=0;m<arr_spec.length-1;m++ )
			{
				note_type_value=arr_spec[m];
				arr2_spec=note_type_value.split(",");
				opt = parent.frames[0].document.createElement('OPTION');
				opt.text =arr2_spec[1];
				opt.value=arr2_spec[0];				
				parent.frames[2].document.forms[0].contr_mod_accession_num.value=arr2_spec[2];
			//	parent.frames[2].document.forms[0].note_type_val.add(opt);
				parent.frames[2].document.forms[0].update_mode.value=arr2_spec[3];
				parent.frames[2].document.forms[0].accession_num.value=arr2_spec[4];
			}
			if(arr2_spec[0]==obj.value)
				{
						//Added performed_by_ql on 1/19/2011 by Anitha for 25928

			 var action_url	=	"../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=OT_NOTES&title="+encodeURIComponent(title)+"&note_type="+obj.value+"&patient_id="+patient_id+"&patient_class="+patient_class+"&function_id="+function_id+"&event_class="+event_class+"&accession_num="+parent.frames[2].document.forms[0].accession_num.value+"&window_close="+window_close+"&ot_speciality_code="+speciality_code+"&hide_header="+hide_header+"&tab_yn="+tab_yn+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&contr_mod_accession_num="+parent.frames[2].document.forms[0].contr_mod_accession_num.value+"&performed_by_ql="+performed_by_ql;
			var title1="";
			var dialogHeight= "100";
			var dialogWidth	= "100";
			var status = "no";
			var arguments	= "";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			secondwindow  = window.showModalDialog(action_url, title1, features);
			parent.frames[2].document.forms[0].note_type_val.selectedIndex=0;
				}else
				{
					alert(getMessage("APP-OT0190","OT"));
				}
			}
		}
	}
function checkForSpecCharsforIDTime(event)
{
    var strCheck = '0123456789:';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

function checkSpecCharsforID(event)
{
    var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

function checkForSpecCharsforID(event)
{
    var strCheck = '0123456789/:';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

function showCalendar_loc(Val1)
{
	var formObj=document.forms[0];
	var change_holding_desc=formObj.change_holding_desc.value;
		if(change_holding_desc==""){
			var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOT.HoldingBay.Label","OT"));
			alert(msg1);
			return false;	
		}else{
			return showCalendar(Val1);
	}
}

function checkHoldingBay(){
		var formObj=document.forms[0];
		var change_holding_desc=formObj.change_holding_desc.value;
		if(change_holding_desc==""){
			var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOT.HoldingBay.Label","OT"));
			alert(msg1);
			return false;	
		}else{
			return true;
	}
}

function showCalendar_loc_chk(Val1)
{
	var formObj=document.forms[0];
	var function_id=formObj.function_id_temp.value;
	if(function_id==""){
		formObj.check_date_time.value="";
	}else{
		formObj.change_date_time.value="";
	}
	return showCalendar(Val1);
}


function validateDate(){
	var formObj=document.forms[0];
	var locale=formObj.locale.value;
	var change_holding_code=formObj.change_holding_code.value;
	var chk_out_date=formObj.change_out_date.value;
	var chk_out_time=formObj.change_out_date_time.value;
	var check_in_date=formObj.check_in_date.value;
	var check_in_time=formObj.check_date_time.value;
	var chk_in_dt_time=check_in_date+" "+check_in_time;
	var chk_out_dt_time=chk_out_date+" "+chk_out_time;
	var ret_val_hlding_chrg_yn=hideChargeBillDtlChk(change_holding_code);
	if(ret_val_hlding_chrg_yn=="Y" || ret_val_hlding_chrg_yn=="N"){ //Added Agaisnt OTMS-OT-TH-KW-CRF-0135-US001/01
		if(chk_out_date!=""){
			var dt = chk_out_date.split("/");
			if((dt[0].length!="2") || (dt[1].length!="2") || (dt[2].length!="4")){
				alert(getMessage("APP-OT0136","OT"));
				formObj.change_out_date.value="";
				return false;
			}
			if(!isAfter(chk_out_date,check_in_date,"DMY",locale)){
				 var msg_1 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
					var msgArr = msg_1.split("#");
					var checkin_time = getLabel("eOT.CheckedInDateTime.Label","OT");
					var chk_out_dt_time =getLabel("eOT.CheckedOutDateTime.Label","OT");
					alert(msgArr[0]+ chk_out_dt_time +msgArr[1]+ checkin_time +msgArr[2]);
				 formObj.change_out_date.value="";
				 formObj.change_out_date.focus();
				 return false;
			}
			//Added Against OTMS-OT-TH-KW-CRF-0135-US001/01 Starts
			else if(chk_out_date==check_in_date)
			{
				return true;
			}
			else
			{
				var msg_1 = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
					var msgArr = msg_1.split("#");
					var checkin_time = getLabel("eOT.CheckedInDateTime.Label","OT");
					var chk_out_dt_time =getLabel("eOT.CheckedOutDateTime.Label","OT");
					alert(msgArr[0]+ chk_out_dt_time +msgArr[1]+ checkin_time +msgArr[2]);
				 formObj.change_out_date.value="";
				 formObj.change_out_date.focus();
				 return false;
			}
			//Added Against OTMS-OT-TH-KW-CRF-0135-US001/01 Ends
			/*  else if(isAfter(chk_out_date,check_in_date,"DMY",locale)){
				 var msg_1 = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
					var msgArr = msg_1.split("#");
					var checkin_time = getLabel("eOT.CheckedInDateTime.Label","OT");
					var chk_out_dt_time =getLabel("eOT.CheckedOutDateTime.Label","OT");
					alert(msgArr[0]+ chk_out_dt_time +msgArr[1]+ checkin_time +msgArr[2]);
				 formObj.change_out_date.value="";
				 formObj.change_out_date.focus();
				 return false;
			} */ 
			/* else {
				return true;
			} */	
			//Commented Against OTMS-OT-TH-KW-CRF-0135-US001/01
		}else{
		var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOT.CheckedOutDate.Label","OT"));
		alert(msg1);
		}
	}
}

function hideChargeBillDtlChkApply(obj){	
	var formObj=document.frames.holding_area_frame.document.HoldingAreaForm;
	var facility_id = formObj.facility_id.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "func_mode=chkOperRoomChrgeYn&facility_id="+facility_id+"&oper_room_code="+obj;
	xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);	
	return retVal;
}

function hideChargeBillDtlChk(obj){
	var formObj=document.forms[0];
	var facility_id = formObj.facility_id.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "func_mode=chkOperRoomChrgeYn&facility_id="+facility_id+"&oper_room_code="+obj;
	xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);	
	return retVal;
}


function validateDuration(obj){
	var retVal="";
	var formObj = document.forms[0];
	var from_time=obj.value
	var inventry_chk_yn_DB=formObj.inventry_chk_yn_DB.value;
	var charge_hold_area_yn_DB=formObj.charge_hold_area_yn_DB.value;
	var splt_from_dur=from_time.split(":");
	if(from_time!=''){
		if(from_time.length!="5"){
		//alert(getMessage("APP-OT0040","OT"));
		alert(getMessage("VALID_TIME_SLOTS","OT"));
		formObj.change_out_date_time.value="";
		formObj.change_out_date_time.select();
		if(inventry_chk_yn_DB=="Y" && charge_hold_area_yn_DB=="Y"){
			formObj.charge_units.value="";
			document.getElementById("charge_details").style.display='none';
		}
//		formObj.start_time.focus()
		return;
	}
	if(splt_from_dur[0].length!=2 ||splt_from_dur[1].length!=2 ){
		alert(getMessage("VALID_TIME_SLOTS","OT"));
		formObj.change_out_date_time.value="";
		formObj.change_out_date_time.select();
		if(inventry_chk_yn_DB=="Y"&& charge_hold_area_yn_DB=="Y"){
			formObj.charge_units.value="";
			document.getElementById("charge_details").style.display='none';
		}
//		formObj.start_time.focus()
		return;
	}
}
	var RE_EXP =/^(0[0-9]|1[0-9]|2[0-3]):(0[0-9]|[12345][0-9])$/;
	if(obj.value!="" && !RE_EXP.test(obj.value) ){
		var err_text="";
	    var time = obj.value;
	    var arr_time =  time.split(":")
        if(arr_time.length!=2 || arr_time[1]=='' || arr_time[0]==''){
			cal_error(getMessage("VALID_TIME_SLOTS","OT"),obj);
		}
		if(arr_time[0]<0 || arr_time[0]>23 || arr_time[1]<0 || arr_time[1]>59 ){
			err_text+=getMessage("APP-OT0040","OT");
		}
		if(err_text.length>0){	
			retVal="Error";
			cal_error(err_text,obj);
		}
	}
	return retVal
}


function cal_error (str_message,obj) {
	var formObj=document.forms[0];
	alert (str_message);
	obj.value="";
	obj.select();
	formObj.charge_units.value="";
	//document.getElementById("cashcounter_desc").innerText="";
	//document.getElementById("charge_details").style.visibility='hidden';
	document.getElementById("charge_details").style.display='none';
	return null;
}

function validateDurationChangeHoldBay(obj){
	var retVal="";
	var formObj = document.forms[0];
	var inventry_chk_yn_DB=formObj.inventry_chk_yn_DB.value;
	var charge_hold_area_yn_DB=formObj.charge_hold_area_yn_DB.value;
	var from_time=obj.value
	var splt_from_dur=from_time.split(":");
	if(from_time!=''){
		if(from_time.length!="5"){
		alert(getMessage("VALID_TIME_SLOTS","OT"));
		formObj.change_date_time_1.value="";
		formObj.change_date_time_1.select();
		if(inventry_chk_yn_DB=="Y" && charge_hold_area_yn_DB=="Y"){
			formObj.charge_units_1.value="";
			document.getElementById("charge_details_1").style.display='none';
		}
//		document.getElementById("charge_details_1").style.visibility='hidden';
//		formObj.start_time.focus()
		return;
	}
	if(splt_from_dur[0].length!=2 ||splt_from_dur[1].length!=2 ){
		alert(getMessage("VALID_TIME_SLOTS","OT"));
		formObj.change_date_time_1.value="";
		formObj.change_date_time_1.select();
		if(inventry_chk_yn_DB=="Y" && charge_hold_area_yn_DB=="Y"){
			formObj.charge_units_1.value="";
			document.getElementById("charge_details_1").style.display='none';
		}
//		document.getElementById("charge_details_1").style.visibility='hidden';
		
		return;
	}
}
	var RE_EXP =/^(0[0-9]|1[0-9]|2[0-3]):(0[0-9]|[12345][0-9])$/;
	if(obj.value!="" && !RE_EXP.test(obj.value) ){
		var err_text="";
	    var time = obj.value;
	    var arr_time =  time.split(":")
        if(arr_time.length!=2 || arr_time[1]=='' || arr_time[0]==''){
			cal_error(getMessage("VALID_TIME_SLOTS","OT"),obj);
		}
		if(arr_time[0]<0 || arr_time[0]>23 || arr_time[1]<0 || arr_time[1]>59 ){
			err_text+=getMessage("APP-OT0040","OT");
		}

		if(err_text.length>0){	
			var retVal="Error";
			cal_errorChage(err_text,obj);
		}
	}
	return retVal;
}

function cal_errorChage (str_message,obj) {
	var formObj=document.forms[0];
	alert (str_message);
	obj.value="";
	obj.select();
	formObj.charge_units_1.value="";
//	document.getElementById("charge_details_1").style.visibility='hidden';
	document.getElementById("charge_details_1").style.display='none';
	return null;
}


function validateDateTime(){
	var formObj=document.forms[0];
	var locale=formObj.locale.value;
	var function_id_temp=formObj.function_id_temp.value;
	var chrg_stg=formObj.inventry_chk_yn_DB.value;
	var hold_chrg_fin_chk_yn = formObj.charge_hold_area_yn_DB.value;
	var change_holding_code = formObj.change_holding_code.value;
	var retrn_val=hideChargeBillDtlChk(change_holding_code);
		if(function_id_temp==""){
		var chk_out_date=formObj.change_out_date.value;
		var chk_out_time=formObj.change_out_date_time.value;
		var check_in_date=formObj.check_in_date.value;
		var check_in_time=formObj.check_date_time.value;
		var chk_in_dt_time=check_in_date+" "+check_in_time;
		var chk_out_dt_time=chk_out_date+" "+chk_out_time;
		if(chk_out_time!=""){
			var retVal_from_valid_dur=validateDuration(formObj.change_out_date_time);
			if(retVal_from_valid_dur==""){
				if(!isAfter(chk_out_dt_time,chk_in_dt_time,"DMYHM",locale)){
					var msg_1 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
					var msgArr = msg_1.split("#");
					var checkin_time = getLabel("eOT.CheckedInDateTime.Label","OT");
					var chk_out_dt_time =getLabel("eOT.CheckedOutDateTime.Label","OT");
					alert(msgArr[0]+ chk_out_dt_time +msgArr[1]+ checkin_time +msgArr[2]);										
					formObj.change_out_date_time.value="";
					if(chrg_stg=="Y" && hold_chrg_fin_chk_yn=="Y"){
						formObj.charge_units.value="";
						document.getElementById("charge_details").style.display='none';

					}
					return false;
				}else if(isBeforeNow(chk_out_dt_time,'DMYHM',locale)){
						if(chrg_stg=="Y" && hold_chrg_fin_chk_yn=="Y" && retrn_val=="Y"){
						callChargableUnits();
						document.getElementById("charge_details").style.display='block';
						return true;
					}
				}else{
					var msg_1 = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
					var msgArr = msg_1.split("#");
					var checkin_time = getLabel("eOT.CheckedOutDateTime.Label","OT");
					var systemdatetime =getLabel("Common.SystemDateTime.label","Common");
					alert(msgArr[0]+ checkin_time  +msgArr[1]+ systemdatetime +msgArr[2]);
					formObj.change_out_date_time.value="";

					if(chrg_stg=="Y" && hold_chrg_fin_chk_yn=="Y"){
			
						formObj.charge_units.value="";
						//document.getElementById("cashcounter_desc").innerText="";
						//document.getElementById("charge_details").style.visibility='hidden';
						document.getElementById("charge_details").style.display='none';

					}

				}
			//  }
			}
		}else{
		if(chrg_stg=="Y" && hold_chrg_fin_chk_yn=="Y" && retrn_val=="Y"){
			formObj.charge_units.value="";	
			//document.getElementById("cashcounter_desc").innerText="";
//			document.getElementById("charge_details").style.visibility='hidden';
			document.getElementById("charge_details").style.display='none';
		}
	//		return false;
		}
	}else if(function_id_temp=="33"){
		var chk_out_date=formObj.change_date_1.value;
		var chk_out_time=formObj.change_date_time_1.value;
		var check_in_date=formObj.change_date.value;
		var check_in_time=formObj.change_date_time.value;
		var chk_in_dt_time=check_in_date+" "+check_in_time;
		var chk_out_dt_time=chk_out_date+" "+chk_out_time;
		if(chk_out_time!=""){
			var retVal_from_change_hold_bay=validateDurationChangeHoldBay(formObj.change_date_time_1);
			if(retVal_from_change_hold_bay==""){
				if(!isAfter(chk_out_dt_time,chk_in_dt_time,"DMYHM",locale)){
					var msg_1 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
					var msgArr = msg_1.split("#");
					var checkin_time = getLabel("eOT.CheckedInDateTime.Label","OT");
					var chk_out_dt_time =getLabel("eOT.CheckedOutDateTime.Label","OT");
					alert(msgArr[0]+ chk_out_dt_time +msgArr[1]+ checkin_time +msgArr[2]);								
						 formObj.change_date_time_1.select();
						 return false;
				}else {
				callChargableUnits();
				return true;
				}
		  }
		}else{
		var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOT.CheckedOutTime.Label","OT"));
		alert(msg1);
		//alert(getMessage("APP-OT0135","OT"));
		formObj.change_out_date_time.focus();
		if(chrg_stg=="Y" && hold_chrg_fin_chk_yn=="Y"){
			formObj.charge_units_1.value="";	
			//document.getElementById("charge_details_1").style.visibility='hidden';
			document.getElementById("charge_details_1").style.display='none';
		}
		return false;
		}
	}
}

function callChargableUnits(){
	var formObj=document.forms[0];
	var function_id_temp=formObj.function_id_temp.value;
	var facility_id=formObj.facility_id.value;
	var chk_in_date=formObj.check_in_date.value;
	var chk_in_time=formObj.check_date_time.value;
	var change_out_date=formObj.change_out_date.value;
	var change_out_date_time=formObj.change_out_date_time.value;
	var change_holding_desc=formObj.change_holding_desc.value;
	if(change_out_date_time!=""){
			var chk_in_dt_time=chk_in_date+" "+chk_in_time;
			var chk_out_dt_time=change_out_date+" "+change_out_date_time;
			var change_holding_code=formObj.change_holding_code.value;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "chk_in_dt_time="+chk_in_dt_time+"&chk_out_dt_time="+chk_out_dt_time+"&change_holding_code="+change_holding_code+"&facility_id="+facility_id;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","HoldingAreaChargeUnits.jsp?func_mode=callChargeUnits&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			var arrVal=retVal.split("##")
		    if(arrVal[2]==null)arrVal[2]="";
	        if(arrVal[3]==null)arrVal[3]="";
		    if(arrVal[4]==null)arrVal[4]="";
			if(arrVal[2]!="" || arrVal[3]!="" || arrVal[4]!=""){
			if(arrVal[4]=="")
				{
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "func_mode=getErrmsg&msg_id="+arrVal[3];
				xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				alert(retVal)
				formObj.change_out_date_time.value="";
				formObj.change_out_date.value="";
				formObj.change_holding_desc.value="";
				formObj.change_holding_code.value="";
				//document.getElementById("charge_details").style.visibility='hidden';
				document.getElementById("charge_details").style.display='none';
				formObj.change_holding_desc.focus();

				//window.close();
			}else
				{
				alert(arrVal[4])
				formObj.change_out_date_time.value="";
				formObj.change_out_date.value="";
				formObj.change_holding_desc.value="";
				formObj.change_holding_code.value="";
				//document.getElementById("charge_details").style.visibility='hidden';
				document.getElementById("charge_details").style.display='none';
				formObj.change_holding_desc.focus();
				//	window.close();
				}
			return;

				
			}else{
				formObj.charge_units.value=arrVal[0];
				formObj.service_code.value=arrVal[1];
				formObj.calc_chrge_units.value=arrVal[0];
				units=arrVal[0];
				serv_code=arrVal[1];
				var change_holding_code=formObj.change_holding_code.value;
				var oper_num_accsn_num = document.forms[0].oper_num.value;
				getHoldingAreaCheck();
				document.forms[0].accession_num.value=oper_num_accsn_num+"HB"+change_holding_code;
				callGetServPanelDtls(units,serv_code);
			}
		}else{
				var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOT.CheckedOutTime.Label","OT"));
				alert(msg1);
				//alert(getMessage("APP-OT0135","OT"));
				return;
		}
}


function callOnBlurGetServPanelDtls(units, serv_code){
		var formObj=document.forms[0];
		var locale = formObj.locale.value;
		var facility_id=formObj.facility_id.value;
		var oper_num=formObj.oper_num.value;
		var module_id=formObj.module_id.value;
		var patient_id=formObj.patient_id.value;
		var booking_num=formObj.booking_num.value;
		var order_id=formObj.order_id.value;
		var speciality_code=formObj.speciality_code.value;
		var oper_code=formObj.oper_code.value;
		var surgeon_code=formObj.surgeon_code.value;
		var change_out_date_time=formObj.change_out_date_time.value;
		var charge_units=formObj.charge_units.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		if(change_out_date_time!=""){
			if(charge_units==""){
				var msg1 = getMessage("CANNOT_BE_BLANK","OT").replace("&",getLabel("eOT.ChargableUnits.Label","OT"));
				alert(msg1);
				formObj.charge_units.select();
				return;
			}else if(charge_units=="0" || charge_units=="00" || charge_units=="000"){
				//APP-OT0068
				var msg1 = getMessage("APP-OT0068","OT").replace("#",getLabel("eOT.ChargableUnits.Label","OT"));
				alert(msg1);
				formObj.charge_units.select();
				return;
			}
		}
		var params = "units="+charge_units+"&serv_code="+serv_code+"&locale="+locale+"&facility_id="+facility_id+"&oper_num="+oper_num+"&module_id="+module_id+"&patient_id="+patient_id+"&booking_num="+booking_num+"&order_id="+order_id+"&speciality_code="+speciality_code+"&oper_code="+oper_code+"&surgeon_code="+surgeon_code;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","HoldingAreaChargeUnits.jsp?func_mode=callServPanel&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		var arrVal=retVal.split("$$");
		document.getElementById("cashcounter_desc").innerText=arrVal[2];

}

function getServPanelDtls(serv_code){
		var disabled="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/disabled.gif'></img>";
		var enabled="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/enabled.gif'></img>";
		var formObj=document.forms[0];
		var locale = formObj.locale.value;
		var units_modified=formObj.charge_units.value;
		var function_id_temp=formObj.function_id_temp.value;
		var units_modified_1=formObj.charge_units_1.value;
		var change_date_time_1=formObj.change_date_time_1.value;
		var facility_id=formObj.facility_id.value;
		var oper_num=formObj.oper_num.value;
		var module_id=formObj.module_id.value;
		var patient_id=formObj.patient_id.value;
		var booking_num=formObj.booking_num.value;
		var order_id=formObj.order_id.value;
		var speciality_code=formObj.speciality_code.value;
		var oper_code=formObj.oper_code.value;
		var surgeon_code=formObj.surgeon_code.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "";
		if(function_id_temp==""){
			if (units_modified=="")
			{
					var msg1 = getMessage("APP-OT0068","OT").replace("&",getLabel("eOT.ChargableUnits.Label","OT"));
					formObj.charge_units.select();
					return;
			}else if(units_modified=="0" || units_modified=="00" || units_modified=="000"){
						var msg1 = getMessage("APP-OT0068","OT").replace("#",getLabel("eOT.ChargableUnits.Label","OT"));
					alert(msg1);
					formObj.charge_units.select();
					return;
			
			}
			params="units="+units_modified+"&serv_code="+serv_code+"&locale="+locale+"&facility_id="+facility_id+"&oper_num="+oper_num+"&module_id="+module_id+"&patient_id="+patient_id+"&booking_num="+booking_num+"&order_id="+order_id+"&speciality_code="+speciality_code+"&oper_code="+oper_code+"&surgeon_code="+surgeon_code;
		}else if(function_id_temp=="33"){
			if(change_date_time_1!=""){
				if(units_modified_1==""){
				var msg1 = getMessage("CANNOT_BE_BLANK","OT").replace("&",getLabel("eOT.ChargableUnits.Label","OT"));
				alert(msg1);
					formObj.charge_units_1.select();
					return;
				}else if(units_modified_1=="0" || units_modified_1=="00" || units_modified_1=="000"){
					var msg1 = getMessage("APP-OT0068","OT").replace("#",getLabel("eOT.ChargableUnits.Label","OT"));
					alert(msg1);
					formObj.charge_units_1.select();
					return;
				}
			}
			params="units="+units_modified_1+"&serv_code="+serv_code_1+"&locale="+locale+"&facility_id="+facility_id+"&oper_num="+oper_num+"&module_id="+module_id+"&patient_id="+patient_id+"&booking_num="+booking_num+"&order_id="+order_id+"&speciality_code="+speciality_code+"&oper_code="+oper_code+"&surgeon_code="+surgeon_code;
		}
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","HoldingAreaChargeUnits.jsp?func_mode=callServPanel&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		var arrVal=retVal.split("$$");
		var Total=arrVal[2];
		var Payable=arrVal[3];
		var Paid = arrVal[6];
		var include_exclude="";
		var Appr_reqd_val="";
//		formObj.include_exclude.value=arrVal[4];
//		formObj.appr_reqd_val.value=arrVal[5];
		if(arrVal[4]=="I"){
			include_exclude=enabled;	
		}else{
			include_exclude=disabled;	
		}
		if(arrVal[5]=="Y"){
			Appr_reqd_val=enabled;	
		}else{
			Appr_reqd_val=disabled;	
		}
		callBillingWindow();
		if(function_id_temp==""){
			document.getElementById("cashcounter_desc").innerText=arrVal[2];
		}else{
			//document.getElementById("cashcounter_desc_1").innerText=arrVal[2];
			paintBillDetails(Total,Payable,Paid,include_exclude,Appr_reqd_val);
		}

}

function getHoldingAreaCheckApply(){
		var formObj=document.frames.holding_area_frame.document.HoldingAreaForm;
		var facility_id=formObj.facility_id.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "func_mode=getHoldingAreaCheck&facility_id="+facility_id;
		xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		formObj.hold_area_chrging_stg.value=retVal;
}

function getHoldingAreaCheck(){
		var formObj=document.forms[0];
		var facility_id=formObj.facility_id.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "func_mode=getHoldingAreaCheck&facility_id="+facility_id;
		xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		formObj.hold_area_chrging_stg.value=retVal;
}


function chkTimeFormat(obj){
	var formObj=document.HoldingAreaForm;
	var change_out_date=formObj.change_date_1.value;
	var locale=formObj.locale.value;
	var cur_date_time = dateUtils(formObj.change_date.value,locale)+" "+formObj.change_date_time.value;
	if(change_out_date!=""){
		if(obj.value!=null && obj.value!=""){
			var retVal = chkTime(obj.value);
			if(retVal==false){
				alert(getMessage("VALID_TIME_SLOTS","OT"));		
				obj.focus();
				obj.select();
			}
		}
			var database_system_date_time = getSysDateTime();
			database_system_date_time = dateUtils(trimString(database_system_date_time),locale);
			var retVal = compareDates(cur_date_time,database_system_date_time,"en",'DMYHM');
			if(retVal==false){
				var msg_1 = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
				var msgArr = msg_1.split("#");
				var checkin_time = getLabel("eOT.CheckInTime.Label","OT");
				var systemdatetime =getLabel("Common.SystemDateTime.label","Common");
				alert(msgArr[0]+ checkin_time  +msgArr[1]+ systemdatetime +msgArr[2]);
				obj.focus();
				obj.select();
				return;
			}
	}else{
		var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOT.CheckedOutTime.Label","OT"));
		alert(msg1);
		//alert(getMessage("APP-OT0135","OT"));		
		return;

	}
}


function validateDtTime(){
	var formObj=document.forms[0];
	var locale=formObj.locale.value;
	var chk_out_date=formObj.change_date_1.value;
	var chrg_stg=formObj.inventry_chk_yn_DB.value;
	var hold_chrg_fin_chk_yn = formObj.charge_hold_area_yn_DB.value;
	var chk_out_time=formObj.change_date_time_1.value;
	var change_holding_code_1=formObj.change_holding_code_1.value;
	var check_in_date=formObj.change_date.value;
	var check_in_time=formObj.change_date_time.value;
	var chk_in_dt_time=check_in_date+" "+check_in_time;
	var chk_out_dt_time=chk_out_date+" "+chk_out_time;
	var retrn_val=hideChargeBillDtlChk(change_holding_code_1);
	if(chk_out_time!="" ){
		var ret_val_from_change_hold_bay=validateDurationChangeHoldBay(formObj.change_date_time_1);
		if(ret_val_from_change_hold_bay==""){
			if(!isAfter(chk_out_dt_time,chk_in_dt_time,"DMYHM",locale)){
					var msg_1 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
					var msgArr = msg_1.split("#");
					var checkin_time = getLabel("eOT.CheckedInDateTime.Label","OT");
					var chk_out_dt_time =getLabel("eOT.CheckedOutDateTime.Label","OT");
					alert(msgArr[0]+ chk_out_dt_time +msgArr[1]+ checkin_time +msgArr[2]);								
					 formObj.change_date_time_1.value="";
					 if(chrg_stg=="Y" && hold_chrg_fin_chk_yn=="Y"){
						formObj.charge_units_1.value="";
						document.getElementById("charge_details_1").style.display='none';
					}
					 return false;
			}else if(isBeforeNow(chk_out_dt_time,'DMYHM',locale)){
					if(chrg_stg=="Y" && hold_chrg_fin_chk_yn=="Y" && retrn_val=="Y"){
						callChargeUnits();
						return true;
					}
					
				}else{
					var msg_1 = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
					var msgArr = msg_1.split("#");
					var checkin_time = getLabel("eOT.CheckedOutDateTime.Label","OT");
					var systemdatetime =getLabel("Common.SystemDateTime.label","Common");
					alert(msgArr[0]+ checkin_time  +msgArr[1]+ systemdatetime +msgArr[2]);
					formObj.change_date_time_1.value="";;
					if(chrg_stg=="Y" && hold_chrg_fin_chk_yn=="Y"){
						formObj.charge_units_1.value="";
						//document.getElementById("charge_details_1").style.visibility='hidden';
						document.getElementById("charge_details_1").style.display='none';
					}
			}	
		}
	}else{
	var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOT.CheckedOutTime.Label","OT"));
	alert(msg1);
	//alert(getMessage("APP-OT0135","OT"));		
	formObj.change_out_date_time_1.focus();
	
	if(chrg_stg=="Y" && hold_chrg_fin_chk_yn=="Y"){
		formObj.charge_units.value="";	
		//document.getElementById("cashcounter_desc").innerText="";
		//document.getElementById("charge_details").style.visibility='hidden';
		document.getElementById("charge_details").style.display='none';
		return false;
		}
	}
}

function shwCalendar_loc(Val1)
{
	var formObj=document.forms[0];
	var change_holding_desc=formObj.change_holding_desc_1.value;
		if(change_holding_desc==""){
			var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOT.HoldingBay.Label","OT"));
			alert(msg1);
			return false;	
		}else{
			return showCalendar(Val1);
	}
}

function callChargeUnits(){
	var formObj=document.forms[0];
	var facility_id=formObj.facility_id.value;
	var chk_in_date=formObj.change_date.value;
	var chk_in_time=formObj.change_date_time.value;
	var change_out_date=formObj.change_date_1.value;
	var change_out_date_time=formObj.change_date_time_1.value;
	var change_holding_desc=formObj.change_holding_desc_1.value;
	if(change_out_date_time!=""){
		var chk_in_dt_time=chk_in_date+" "+chk_in_time;
		var chk_out_dt_time=change_out_date+" "+change_out_date_time;
		var change_holding_code=formObj.change_holding_code_1.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "chk_in_dt_time="+chk_in_dt_time+"&chk_out_dt_time="+chk_out_dt_time+"&change_holding_code="+change_holding_code+"&facility_id="+facility_id;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","HoldingAreaChargeUnits.jsp?func_mode=callChargeUnits&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		var arrVal=retVal.split("##")
        if(arrVal[2]==null)arrVal[2]="";
        if(arrVal[3]==null)arrVal[3]="";
        if(arrVal[4]==null)arrVal[4]="";
		if(arrVal[2]!="" || arrVal[3]!="" || arrVal[4]!=""){
			if(arrVal[4]=="")
				{
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "func_mode=getErrmsg&msg_id="+arrVal[3];
				xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				alert(retVal)
				formObj.change_date_time_1.value="";
				formObj.change_date_1.value="";
				formObj.change_holding_desc_1.value="";
				formObj.change_holding_code_1.value="";
				formObj.change_holding_desc_1.focus();
				
				//window.close();
			}else
				{
				alert(arrVal[4])
				formObj.change_date_time_1.value="";
				formObj.change_date_1.value="";
				formObj.change_holding_desc_1.value="";
				formObj.change_holding_code_1.value="";
				formObj.change_holding_desc_1.focus();
					//window.close();
				}
			return;
		}else{
			formObj.charge_units_1.value=arrVal[0];
			formObj.service_code_1.value=arrVal[1];
			formObj.calc_chrge_units_1.value=arrVal[0];
			units_1=arrVal[0];
			serv_code_1=arrVal[1];
			var change_holding_code=formObj.change_holding_code_1.value;
			var oper_num_accsn_num = document.forms[0].oper_num.value;
			getHoldingAreaCheck();
			document.forms[0].accession_num_1.value=oper_num_accsn_num+"HB"+change_holding_code;
			billServPanelDtls(units_1,serv_code_1);

		}
	}else{
			var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOT.CheckedOutTime.Label","OT"));
			alert(msg1);
			//alert(getMessage("APP-OT0135","OT"));		
			return;
	}
}

function checkOnloadIncludeExeclude(){
		var formObj=document.forms[0];
		var key=formObj.bill_acc_num_DB.value;
		var facility_id=formObj.facility_id.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "key="+key+"&facility_id="+facility_id;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","HoldingAreaChargeUnits.jsp?func_mode=checkOnloadIncludeExeclude&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		return retVal;
}

function callOnloadbillServPanelDtls(units, serv_code){
	var formObj=document.forms[0];
		var locale = formObj.locale.value;
		var facility_id=formObj.facility_id.value;
		var oper_num=formObj.oper_num.value;
		var module_id=formObj.module_id.value;
		var patient_id=formObj.patient_id.value;
		var booking_num=formObj.booking_num.value;
		var order_id=formObj.order_id.value;
		var speciality_code=formObj.speciality_code.value;
		var oper_code=formObj.oper_code.value;
		var surgeon_code=formObj.surgeon_code.value;
		var function_id_temp=formObj.function_id_temp.value;
		var charge_units=formObj.charge_units.value;
		var key=formObj.bill_acc_num_DB.value;
		var key_line = document.forms[0].holding_seq_num_DB.value;
		var change_holding_code=formObj.holding_bay_code.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		if(function_id_temp=""){
		var change_out_date_time=formObj.change_out_date_time.value;
		var charge_units=formObj.charge_units.value;
		if(change_out_date_time!=""){
			if(charge_units==""){
				var msg1 = getMessage("CANNOT_BE_BLANK","OT").replace("&",getLabel("eOT.ChargableUnits.Label","OT"));
				alert(msg1);
					formObj.charge_units.select();
					return;
				}else if(charge_units=="0" || charge_units=="00" || charge_units=="000"){
					var msg1 = getMessage("APP-OT0068","OT").replace("#",getLabel("eOT.ChargableUnits.Label","OT"));
					alert(msg1);
					formObj.charge_units.select();
					return;
				}
			}
		}
		var params = "units="+units+"&serv_code="+serv_code+"&locale="+locale+"&facility_id="+facility_id+"&oper_num="+oper_num+"&module_id="+module_id+"&patient_id="+patient_id+"&booking_num="+booking_num+"&order_id="+order_id+"&speciality_code="+speciality_code+"&oper_code="+oper_code+"&surgeon_code="+surgeon_code+"&key="+key+"&key_line="+key_line;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","HoldingAreaChargeUnits.jsp?func_mode=callOnLoadServPanel&"+params,false);
		xmlHttp.send(xmlDoc);
		pushAllValuestoOR(key,key_line,oper_num,change_holding_code,serv_code,units);
		var retVal = trimString(xmlHttp.responseText);
		var arrVal=retVal.split("$$");
		var lbl_total=getLabel("Common.total.label","common_labels")+" "+getLabel("eOT.Payable.Label","ot_labels");
		var lbl_payable=getLabel("Common.PatientPayable.label","common_labels");
		var lbl_paid=getLabel("Common.PatientPaid.label","common_labels");
		var included=getLabel("eOT.Included.Label","ot_labels");
		var app_reqd=getLabel("eOT.ApprovalRequired.Label","ot_labels");
		var disabled="<img width=15px   align='texttop' height='15px' src='../../eCommon/images/disabled.gif'></img>";
		var enabled="<img width=15px   align='texttop' height='15px' src='../../eCommon/images/enabled.gif'></img>";
		document.forms[0].panel_str.value=arrVal[0];
		var Total=arrVal[2];
		var Payable=arrVal[3];
		var Paid = arrVal[6];
		var include_exclude="";
		var Appr_reqd_val="";
		if(arrVal[4]=="I"){
			include_exclude=enabled;	
		}else{
			include_exclude=disabled;	
		}
		if(arrVal[5]=="Y"){
			Appr_reqd_val=enabled;	
		}else{
			Appr_reqd_val=disabled;	
		}
		if(Paid==""){
			Paid="0.0";
		}
		document.getElementById("charge_details").style.display='block';
		var str="<B><font color='Indigo'>"+included+":&nbsp;"+include_exclude+"</font>&nbsp;&nbsp;";
		str+="<font color='Indigo'>"+app_reqd+":&nbsp;"+Appr_reqd_val+"</font>&nbsp;&nbsp;";
		str+= "<font color='Indigo' >"+lbl_total+":&nbsp;"+Total+"</font>&nbsp;&nbsp;";
		str+="<font color='crimson' >"+lbl_payable+":&nbsp;"+Payable+"</font>&nbsp;&nbsp;";
		str+="<font color='green'>"+lbl_paid+":&nbsp;"+Paid+"</font>&nbsp;&nbsp;</B>";
		eval("document.getElementById("charge_details")").innerHTML = str;

}


function billServPanelDtls(units, serv_code){
	var lbl_total=getLabel("Common.total.label","common_labels")+" "+getLabel("eOT.Payable.Label","ot_labels");
	var lbl_payable=getLabel("Common.PatientPayable.label","common_labels");
	var lbl_paid=getLabel("Common.PatientPaid.label","common_labels");
	var included=getLabel("eOT.Included.Label","ot_labels");
	var app_reqd=getLabel("eOT.ApprovalRequired.Label","ot_labels");
	var disabled="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/disabled.gif'></img>";
	var enabled="<img width=15px   align='bottom' height='15px' src='../../eCommon/images/enabled.gif'></img>";
		var formObj=document.forms[0];
		var locale = formObj.locale.value;
		var facility_id=formObj.facility_id.value;
		var function_id_temp=formObj.function_id_temp.value;
		var oper_num=formObj.oper_num.value;
		var module_id=formObj.module_id.value;
		var patient_id=formObj.patient_id.value;
		var booking_num=formObj.booking_num.value;
		var order_id=formObj.order_id.value;
		var speciality_code=formObj.speciality_code.value;
		var oper_code=formObj.oper_code.value;
		var surgeon_code=formObj.surgeon_code.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		if(units==""){
				var msg1 = getMessage("CANNOT_BE_BLANK","OT").replace("&",getLabel("eOT.ChargableUnits.Label","OT"));
				alert(msg1);
				formObj.charge_units_1.select();
				return;
			}else if(units=="0" || units=="00" || units=="000"){
				var msg1 = getMessage("APP-OT0068","OT").replace("#",getLabel("eOT.ChargableUnits.Label","OT"));
				alert(msg1);
				formObj.charge_units_1.select();
				return;
			}
		var params = "units="+units+"&serv_code="+serv_code+"&locale="+locale+"&facility_id="+facility_id+"&oper_num="+oper_num+"&module_id="+module_id+"&patient_id="+patient_id+"&booking_num="+booking_num+"&order_id="+order_id+"&speciality_code="+speciality_code+"&oper_code="+oper_code+"&surgeon_code="+surgeon_code;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","HoldingAreaChargeUnits.jsp?func_mode=callServPanel&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		var arrVal=retVal.split("$$");
		if(function_id_temp==""){
			document.getElementById("cashcounter_desc").innerText=arrVal[2];
		}else if(function_id_temp=="33"){
		var Total=arrVal[2];
		var Payable=arrVal[3];
		var Paid = arrVal[6];
		var include_exclude="";
		var Appr_reqd_val="";
		formObj.include_exclude.value=arrVal[4];
		formObj.appr_reqd_val.value=arrVal[5];
		if(arrVal[4]=="I"){
			include_exclude=enabled;	
		}else{
			include_exclude=disabled;	
		}
		if(arrVal[5]=="Y"){
			Appr_reqd_val=enabled;	
		}else{
			Appr_reqd_val=disabled;	
		}
		if(Paid==""){
			Paid="0.0";
		}
		callBillingWindow();
		//document.getElementById("charge_details_1").style.visibility='visible';
		document.getElementById("charge_details_1").style.display='block';
		var str="<B><font color='Indigo'>"+included+":&nbsp;"+include_exclude+"</font>&nbsp;&nbsp;";
		str+="<font color='Indigo'>"+app_reqd+":&nbsp;"+Appr_reqd_val+"</font>&nbsp;&nbsp;";
		str+= "<font color='Indigo' >"+lbl_total+":&nbsp;"+Total+"</font>&nbsp;&nbsp;";
		str+="<font color='crimson' >"+lbl_payable+":&nbsp;"+Payable+"</font>&nbsp;&nbsp;";
		str+="<font color='green'>"+lbl_paid+":&nbsp;"+Paid+"</font>&nbsp;&nbsp;</B>";
		str+="<a class='gridLink' href=\"javascript:callBillingWindow1();\"><img src='../../eOT/images/dollar.png'></img></a>";
		eval("document.getElementById("charge_details_1")").innerHTML = str;
		}

}

function hideChargeBillDtl(obj){
	var facility_id = document.forms[0].facility_id.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "func_mode=chkOperRoomChrgeYn&facility_id="+facility_id+"&oper_room_code="+obj;
	xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);	
	if(retVal=="N"){
		document.getElementById("chrg_unit_show_yn_1").style.visibility = 'hidden';
		document.getElementById("pyble_unit_show_yn_1").style.visibility = 'hidden';
	
	}else if(retVal=="Y"){
		document.getElementById("chrg_unit_show_yn_1").style.visibility = 'visible';
		document.getElementById("pyble_unit_show_yn_1").style.visibility = 'visible'
	
	}
	//document.forms[0].inventry_chk_yn.value=retVal;
}


function searchChangeHoldingAreaBay(obj,target){
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	var facility_id = document.forms[0].facility_id.value;
	var oper_num_accsn_num = document.forms[0].oper_num.value;
	//obj.value='';
	//target.value='';
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var tit=getLabel("eOT.HoldingBay.Label","OT");
	var locale = document.forms[0].locale.value;
	var sql="SELECT  HOLDING_AREA_DESC description,HOLDING_AREA_CODE code FROM OT_HOLDING_AREAS_LANG_VW WHERE OPERATING_FACILITY_ID='"+facility_id+ "' AND NVL(STATUS,'E') = 'E'  and upper(HOLDING_AREA_DESC) like upper(?) and upper(HOLDING_AREA_CODE) like upper(?) AND LANGUAGE_ID='"+locale+"'  order by 2";
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		hideChargeBillDtls(arr[0]);
		target.value=arr[1];
		obj.value = arr[0];
		document.forms[0].hide_hold_bay_1.value=arr[0];
		
	}else{
		target.value="";
		obj.value="";
	}
}

function checkTime(obj){
	var formObj=document.HoldingAreaForm;
		var locale=formObj.locale.value;
		var cur_date_time = dateUtils(formObj.check_in_date.value,locale)+" "+formObj.check_date_time.value;
		var checked_in_dt_time=checkCheckInTime();
		var chk_in_time_len=obj.value;
		if(obj.value!=null && obj.value!=""){
			var retVal = chkTime(obj.value);
			if(retVal==false ){
				alert(getMessage("VALID_TIME_SLOTS","OT"));		
				obj.value="";
				obj.focus();
				//obj.select();
				return;
			}
		if(chk_in_time_len.length!=5){
				alert(getMessage("VALID_TIME_SLOTS","OT"));		
				obj.value="";
				obj.focus();
				//obj.select();
				return;
		}
			
		}
			var database_system_date_time = getSysDateTime();
			database_system_date_time = dateUtils(trimString(database_system_date_time),locale);
			var retVal = compareDates(cur_date_time,database_system_date_time,"en",'DMYHM');
			var retVal_chk_In = compareDates(checked_in_dt_time,cur_date_time,"en",'DMYHM');
			if(retVal==false){
				var msg_1 = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
				var msgArr = msg_1.split("#");
				var checkin_time = getLabel("eOT.CheckInTime.Label","OT");
				var systemdatetime =getLabel("Common.SystemDateTime.label","Common");
				alert(msgArr[0]+ checkin_time  +msgArr[1]+ systemdatetime +msgArr[2]);
				obj.focus();
				obj.select();
				return;
		}
			if(retVal_chk_In==false){
				var msg_1 = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
				var msgArr = msg_1.split("#");
				var checkin_time = getLabel("eOT.CheckInTime.Label","OT");
				var chkindatetime =getLabel("eOT.CheckedInDateTime.Label","OT");
				alert(msgArr[0]+ checkin_time  +msgArr[1]+ chkindatetime +msgArr[2]);
				obj.focus();
				obj.select();
				return;
		}

}


function checkInTimeChargeUnits(obj){
	var formObj=document.forms[0];
	var function_id=formObj.function_id_temp.value;
	var change_out_date="";
	var change_out_date_time="";
	if(function_id==""){
		change_out_date=formObj.change_out_date.value;
		change_out_date_time=formObj.change_out_date_time.value;
		if(change_out_date!="" && change_out_date_time!=""){
			validateChkDateTime();
		}
	}else if(function_id=="33"){
		change_out_date=formObj.change_date_1.value;
		change_out_date_time=formObj.change_date_time_1.value;
		if(change_out_date!="" && change_out_date_time!=""){
			validateDtTime();
		}
	}
}

function validateChkDateTime(){
	var formObj=document.forms[0];
	var locale=formObj.locale.value;
	var function_id_temp=formObj.function_id_temp.value;
	var chrg_stg=formObj.inventry_chk_yn_DB.value;
	var hold_chrg_fin_chk_yn = formObj.charge_hold_area_yn_DB.value;
	var change_holding_code = formObj.change_holding_code.value;
	var retrn_val=hideChargeBillDtlChk(change_holding_code);
		if(function_id_temp==""){
		var chk_out_date=formObj.change_out_date.value;
		var chk_out_time=formObj.change_out_date_time.value;
		var check_in_date=formObj.check_in_date.value;
		var check_in_time=formObj.check_date_time.value;
		var chk_in_dt_time=check_in_date+" "+check_in_time;
		var chk_out_dt_time=chk_out_date+" "+chk_out_time;
		if(check_in_time!="" && chk_out_time!=""){
			var retVal_from_valid_dur=validateDuration(formObj.check_date_time);
			if(retVal_from_valid_dur==""){
				if(!isAfter(chk_out_dt_time,chk_in_dt_time,"DMYHM",locale)){
					var msg_1 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
					var msgArr = msg_1.split("#");
					var checkin_time = getLabel("eOT.CheckedInDateTime.Label","OT");
					var chk_out_dt_time =getLabel("eOT.CheckedOutDateTime.Label","OT");
					alert(msgArr[0]+ chk_out_dt_time +msgArr[1]+ checkin_time +msgArr[2]);										
					formObj.change_out_date_time.value="";
					return false;
				}else if(isBeforeNow(chk_in_dt_time,'DMYHM',locale)){
						if(chrg_stg=="Y" && hold_chrg_fin_chk_yn=="Y" && retrn_val=="Y"){
						callChargableUnits();
						return true;
					}
				}else{
					var msg_1 = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
					var msgArr = msg_1.split("#");
					var checkin_time = getLabel("eOT.CheckedInDateTime.Label","OT");
					var systemdatetime =getLabel("Common.SystemDateTime.label","Common");
					alert(msgArr[0]+ checkin_time  +msgArr[1]+ systemdatetime +msgArr[2]);
					formObj.change_out_date_time.value="";
					if(chrg_stg=="Y" && hold_chrg_fin_chk_yn=="Y"){
						formObj.charge_units.value="";
						//document.getElementById("charge_details").style.visibility='hidden';
						document.getElementById("charge_details").style.display='none';
					}

				}
			}
		}else{
		if(chrg_stg=="Y" && hold_chrg_fin_chk_yn=="Y" && retrn_val=="Y"){
			formObj.charge_units.value="";	
			//document.getElementById("charge_details").style.visibility='hidden';
			document.getElementById("charge_details").style.display='none';
			}
		}
	}else if(function_id_temp=="33"){
		var chk_out_date=formObj.change_date_1.value;
		var chk_out_time=formObj.change_date_time_1.value;
		var check_in_date=formObj.change_date.value;
		var check_in_time=formObj.change_date_time.value;
		var chk_in_dt_time=check_in_date+" "+check_in_time;
		var chk_out_dt_time=chk_out_date+" "+chk_out_time;
		if(chk_out_time!=""){
			var retVal_from_change_hold_bay=validateDurationChangeHoldBay(formObj.change_date_time_1);
			if(retVal_from_change_hold_bay==""){
				if(!isAfter(chk_out_dt_time,chk_in_dt_time,"DMYHM",locale)){
					var msg_1 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
					var msgArr = msg_1.split("#");
					var checkin_time = getLabel("eOT.CheckedInDateTime.Label","OT");
					var chk_out_dt_time =getLabel("eOT.CheckedOutDateTime.Label","OT");
					alert(msgArr[0]+ chk_out_dt_time +msgArr[1]+ checkin_time +msgArr[2]);								
						 formObj.change_date_time_1.select();
						 return false;
				}else {
				callChargableUnits();
				document.getElementById("charge_details_1").style.display='block';
				return true;
				}
		  }
		}else{
		var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOT.CheckedOutTime.Label","OT"));
		alert(msg1);
		formObj.change_out_date_time.focus();
		if(chrg_stg=="Y" && hold_chrg_fin_chk_yn=="Y"){
			formObj.charge_units_1.value="";	
			//document.getElementById("charge_details_1").style.visibility='hidden';
			document.getElementById("charge_details_1").style.display='none';
		}
		return false;
		}
	}
}

