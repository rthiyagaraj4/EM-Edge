/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function callAnaesthesia1(obj){	
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var obj1=document.forms[0];

	var sql="SELECT ANAESTHESIA_CODE CODE,SHORT_DESC  DESCRIPTION FROM AM_ANAESTHESIA WHERE  NVL(EFF_STATUS,'E') = 'E' AND upper(ANAESTHESIA_CODE) like upper(?) AND upper(SHORT_DESC) like upper(?) order by 2";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	//alert("obj.value"+obj.value);
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	var Anaesthesia = getLabel("Common.Anaesthesia.label","Common");
	var returnedValues = CommonLookup(Anaesthesia, argumentArray );

	if((returnedValues != null) && (returnedValues != "") )  {
		document.forms[0].anaesthesia_code.value = returnedValues[0];
		document.forms[0].anaesthesia_desc.value = returnedValues[1];	
		}
	else
		{
			document.forms[0].anaesthesia_desc.value = '';
			document.forms[0].anaesthesia_code.value = '';
		}
}

function callAccessionNum(sourceOrderId)
{	
	var dialogTop  = "40";
	var dialogHeight = "10";
	var dialogWidth  = "40";
	var arguments = "";
	var column_sizes = escape("100%");
	var accessNum   =getLabel("eOT.AccessionNum.Label","OT");	
	var column_descriptions = encodeURIComponent(accessNum);
	var sql=escape("SELECT OPER_NUM OPER_NUM1 FROM OT_POST_OPER_HDR WHERE ORDER_ID ='"+sourceOrderId+"'");//OTIP00000000612
	var title  = getLabel("Common.SearchPatient.label","Common");
	title=encodeURIComponent(title);
	var features  = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	var formObj = document.forms[0];
	if(retVal!=null){
		var arr = retVal.split('::');
		document.forms[0].accession_num.value=arr[0];
	}else{
		document.forms[0].accession_num.value="";
		}
}

function callPractitioners(obj) {
	var pract_vals=document.forms[0].pract_type.value;
	var locale = document.forms[0].locale.value;
	var paract_array=pract_vals.split("##");
	var pract_type= paract_array[0]; 
	if(paract_array.length==1 ) {
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var  PractitionerType = getLabel("Common.Role.label","Common");
		alert(msgArray[0]+PractitionerType+(msgArray[1]));
		return;
	}
	var sql="";
	var search=getLabel("Common.search.label","Common");
	if(pract_type=='OS'){
		var pract=getLabel("Common.practitioner.label","Common");
		var title=pract+" "+search;
		sql="SELECT PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW A WHERE A.LANGUAGE_ID = '"+locale+"' AND PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE = 'OS') AND upper(PRACTITIONER_ID) like upper(?) AND upper(PRACTITIONER_NAME) like upper(?) order by 2 ";
	}else if(pract_type=='AS') {
		var pract=getLabel("Common.practitioner.label","Common");
		var title=pract+" "+search;
		sql="SELECT PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW A WHERE A.LANGUAGE_ID = '"+locale+"' AND PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE = 'AS') AND upper(PRACTITIONER_ID) like upper(?) AND upper(PRACTITIONER_NAME) like upper(?) order by 2 ";
	}
	else if(pract_type=='MA') {
		var anaes=getLabel("Common.Anaesthetist.label","Common");
		var title=anaes+" "+search;
		sql="SELECT PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW A WHERE A.LANGUAGE_ID = '"+locale+"' AND PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE = 'MA') AND upper(PRACTITIONER_ID) like upper(?) AND upper(PRACTITIONER_NAME) like upper(?) order by 2 ";
	} else if(pract_type=='AA') {
		var anaes=getLabel("Common.Anaesthetist.label","Common");
		var title=anaes+" "+search;
		sql="SELECT PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW A WHERE A.LANGUAGE_ID = '"+locale+"' AND PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE = 'AA') AND upper(PRACTITIONER_ID) like upper(?) AND upper(PRACTITIONER_NAME) like upper(?) order by 2 ";
	}else if(pract_type=='NS') {
		var nurse=getLabel("Common.nurse.label","Common");
		var title=nurse+" "+search;
		sql="SELECT PRACTITIONER_ID CODE,PRACTITIONER_NAME DESCRIPTION  FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN ('NS') AND upper(PRACTITIONER_ID) like upper(?) AND upper(PRACTITIONER_NAME) like upper(?) order by 2 ";
	}

	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;	
	argumentArray[6] =DESC_LINK;
	argumentArray[7] = DESC_CODE;
	var returnedValues = CommonLookup(title, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		document.forms[0].practitioner_id.value = returnedValues[0];
		document.forms[0].practitioner_name.value = returnedValues[1];
	}else{
		document.forms[0].practitioner_id.value = "";
		document.forms[0].practitioner_name.value = "";	
	}
}


function getXHR1(){
	var request = false;
	try {
		request = new XMLHttpRequest();
	}catch (trymicrosoft) {
		try {
			request = new ActiveXObject("Msxml2.XMLHTTP");
		}catch (othermicrosoft) {
			try {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (failed) {
				request = false;
			}
		}
    }
	if (!request){
		alert("System Error initializing XMLHttpRequest!");
		return;
	}else return request;
}


function isBeforeCurrent(currDate, format, locale){
	var xhr =  getXHR1();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=isBeforeNow&currDate="+currDate+"&format="+format+"&locale="+locale;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText = xhr.responseText;

	if (TrimStr(xmlText) == "true"){
		return true;
	}
	return false;
}



function apply()
{	
	var IntraStatusformObj = window.parent.parent.frames[8].document.forms[0];
	var doc_chked = IntraStatusformObj.intraop_done;
	frmObj = parent.parent.Intra_anesthesia_objectcollect_frame;
	var HdrformObj = parent.parent.intra_anesth_header_frame.RecordAnesthesiaHdrForm;
	var isRecordAnes = HdrformObj.isRecordAnes.value;//PMG2017-SS-CRF-0001-US003
	var facility_id = HdrformObj.facility_id.value;
	var anesthesia_srl_no = HdrformObj.anesthesia_srl_no.value;
	var weight = HdrformObj.weight.value;
	var height = HdrformObj.height.value;
	//var bsa = HdrformObj.bsa.value;
	var bsa = HdrformObj.bsaDisp.value;
	var bmi = HdrformObj.bmi.value;
	var intraop_done_yn=IntraStatusformObj.intraop_done_yn.value
	var anaesthesia_code = HdrformObj.anaesthesia_code.value;
	var start_date = HdrformObj.start_date.value;
	var start_time = HdrformObj.start_time.value;	
	var anaesthetist_code1 ="";// HdrformObj.anaesthetist_code1.value;
	var anaesthetist_code2 ="";// HdrformObj.anaesthetist_code2.value;
	var finish_date = HdrformObj.finish_date.value;
	var finish_time = HdrformObj.finish_time.value;
	var locale = HdrformObj.locale.value;
	start_date=convertDate(start_date,'DMY',locale,"en");
	finish_date=convertDate(finish_date,'DMY',locale,"en");
	var start_date_time =start_date+" "+start_time;
	var finish_date_time =finish_date+" "+finish_time;
	var status = HdrformObj.status.value;
	var err_txt="";
	var HdrformObj = parent.parent.intra_anesth_header_frame.RecordAnesthesiaHdrForm;
	var accession_num = HdrformObj.accession_num.value;		
	if(start_date!="" && start_time!=""){
		var checked_in_dt_time=checkCheckInTime();
		var retVal_chk_In = compareDates(checked_in_dt_time,start_date_time,"en",'DMYHM');
		if(retVal_chk_In==false){
			var msg_1 = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
			var msgArr = msg_1.split("#");
			var checkin_time = getLabel("eOT.CheckInTime.Label","OT");
			var chkindatetime =getLabel("eOT.AnaesthesiaStartTime.Label","OT");
			var err_msg=msgArr[0]+ checkin_time+"( "+checked_in_dt_time+")"+msgArr[1]+ chkindatetime+msgArr[2];
			parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+err_msg;
			return;
			}
	}
	
	if(status=='OS' || status=='PR')
	{
		status='IN';
	}

	var flag=0;

	if (weight=='' && height!='')
	{
		flag=1;
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var Weight  = getLabel("Common.weight.label","Common");
		err_txt=msgArray[0]+Weight +msgArray[1];
	}
	if(weight!='' && height=='')
	{
		flag=1;
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var Height  = getLabel("Common.height.label","Common");
		err_txt=msgArray[0]+Height +msgArray[1];
	}
	
	if(start_date==null || trimString(start_date)=="")
	{
		flag=1;
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var  Startd  = getLabel("Common.StartDate.label","Common");
		if(err_txt!='')
	    err_txt+="<br>"+msgArray[0]+Startd +msgArray[1];
		else
		err_txt=msgArray[0]+Startd +msgArray[1];
	}
	if(start_time==null || trimString(start_time)=="")
	{
		flag=1;
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		 var  startt = getLabel("eOT.AnaesthesiaStartTime.Label","OT");
		 if(err_txt!='')
		 err_txt+="<br>"+msgArray[0]+startt +msgArray[1];
		 else
          err_txt=msgArray[0]+startt +msgArray[1];
	}
	else if(!CompareDateTime()){
		var msg = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
		var msgArray = msg.split("#");
		var  startdatetime = getLabel("eOT.AnaesthesiaStartTime.Label","OT");	
		var  systemdatetime =getLabel("Common.SystemDateTime.label","Common");
		if(err_txt!='')
		err_txt+="<br>"+msgArray[0]+startdatetime+(msgArray[1])+systemdatetime+(msgArray[2]);
		else
		err_txt=msgArray[0]+startdatetime+(msgArray[1])+systemdatetime+(msgArray[2]);
		flag=1;
	}
	
	if(!finish_date=="")
	{
		if(finish_time==null || trimString(finish_time)=="")
		{
			flag=1;
			var msg = getMessage("CANNOT_BE_BLANK","OT");
			var msgArray = msg.split("&");
			var finishTime=getLabel("eOT.AnaesthesiaEndTime.Label","OT");
			if(err_txt!='')
            err_txt+="<br>"+msgArray[0]+finishTime +msgArray[1];
			else
            err_txt=msgArray[0]+finishTime +msgArray[1];
		}else if(!CompareDateTime1()){
			var msg = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
			var msgArray = msg.split("#");
			var  systemdatetime =getLabel("Common.SystemDateTime.label","Common");
			var  startdatetime =getLabel("eOT.AnaesthesiaEndTime.Label","OT");
			if(err_txt!='')
			err_txt+="<br>"+msgArray[0]+startdatetime+(msgArray[1])+systemdatetime+(msgArray[2]);
			else
		    err_txt=msgArray[0]+startdatetime+(msgArray[1])+systemdatetime+(msgArray[2]);
			flag=1;
		}else if(!CompareDateTime2()){
			var msg = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
			var msgArray = msg.split("#");		
			var  finishdatetime = getLabel("eOT.AnaesthesiaEndTime.Label","OT");	
			var  startdatetime =getLabel("eOT.AnaesthesiaStartTime.Label","OT");
			if(err_txt!='')
			err_txt+="<br>"+msgArray[0]+startdatetime+(msgArray[1])+finishdatetime+(msgArray[2]);
			else
            err_txt=msgArray[0]+startdatetime+(msgArray[1])+finishdatetime+(msgArray[2]);
			flag=1;
		}
	}
	
	if(accession_num==null || accession_num=="")
	{
		flag=1;
			var msg = getMessage("CANNOT_BE_BLANK","OT");
			var msgArray = msg.split("&");
			var AccessionNumber = getLabel("eOT.AccessionNum.Label","OT");			
			if(err_txt!='')
			err_txt+="<br>"+msgArray[0]+ AccessionNumber+msgArray[1];
			else
            err_txt=msgArray[0]+ AccessionNumber+msgArray[1];
	}
if(!isRecordAnes){//PMG2017-SS-CRF-0001-US003	
	if(anaesthesia_code==null || anaesthesia_code=="")
	{
		flag=1;
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var Anaesthesia = getLabel("Common.Anaesthesia.label","Common");	
		if(err_txt!='')
		err_txt+="<br>"+msgArray[0]+Anaesthesia+msgArray[1];
		else
        err_txt=msgArray[0]+Anaesthesia+msgArray[1];
	}
}//PMG2017-SS-CRF-0001-US003

function createXMLForIntaHdr()
{
	var table_name="AT_ANAESTHESIA_RECORD_HDR";
	var xmlString ="";
	xmlString+="<INTRA_HDR"+" ";
	xmlString+="facility_id=\""+facility_id+"\""+" ";
	xmlString+="anesthesia_srl_no=\""+anesthesia_srl_no+"\""+" ";
	xmlString+="weight=\""+weight+"\""+" ";
	xmlString+="height=\""+height+"\""+" ";
	xmlString+="bsa=\""+bsa+"\""+" ";
	xmlString+="bmi=\""+bmi+"\""+" ";
	xmlString+="anaesthesia_code=\""+anaesthesia_code+"\""+" ";
	xmlString+="anaesthetist_code1=\""+anaesthetist_code1+"\""+" ";
	xmlString+="anaesthetist_code2=\""+anaesthetist_code2+"\""+" ";
	xmlString+="start_date=\""+start_date_time+"\""+" ";
	xmlString+="finish_date=\""+trimString(finish_date_time)+"\""+" ";
	xmlString+="intraop_done_yn=\""+intraop_done_yn+"\""+" ";
	xmlString+="status=\""+status+"\""+" ";
	xmlString+="accession_num=\""+accession_num+"\""+" ";
	xmlString+="db_mode=\"U\""+" ";
	xmlString+="table_name=\""+table_name+"\""+" />";
	return xmlString;
 }


function trimString(inString){
    return inString.replace(/^\s+|\s+$/g,"");
}


	//var param="facility_id="+facility_id+"&anesthesia_srl_no="+anesthesia_srl_no;
	var param="facility_id="+facility_id+"&anesthesia_srl_no="+anesthesia_srl_no+"&accession_num="+accession_num;
	var chk_box = HdrformObj.intraop_done;	
	if(flag==0)
	{		
		if(doc_chked.checked==false){
			//if(window.confirm("Documentation not completed, Do you want to continue?")==false){
			if(window.confirm(getMessage("APP-OT0078","OT"))==false){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
				return;
		    }
		}
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr="<root>";
		var action = '../../servlet/eOT.AT_IntraAnaesServlet?'+param;
		
		xmlStr+=createXMLForIntaHdr();
		xmlStr+=frmObj.createXMLForPersonnelDetails();
		xmlStr+="</root>";		
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",action,false);
		xmlHttp.send(xmlDoc);		
		var retVal = trimString(xmlHttp.responseText);		
			if(retVal!=null && retVal!=""){
			  if(retVal == "RECORD_INSERTED"){
				   //alert(getATMessage(retVal));
				   //alert(getMessage(retVal));
				   alert(getMessage("RECORD_INSERTED","SM"));
				  window.returnValue=true;
				  window.close();
			   }else{
			/* Modified by muthukumar against IN:028133 on 2/8/2011 */
				if(retVal.length > 10)	alert(retVal);
				else  alert(getMessage(retVal,"OT"));
			/* Modified by muthukumar against IN:028133 on 2/8/2011 */
				//alert(retVal); //Commented by Muthukumar on 2/8/2011 
				  window.returnValue=true;
				  window.close();
				}
			}
   }else
	{	   
	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+err_txt;
	}		
}


function intraAnaesCheckedYN()
{	
	if(document.forms[0].intraop_done.checked==true)			
		document.forms[0].intraop_done_yn.value="Y";
	else
		document.forms[0].intraop_done_yn.value="N";
}
function CompareDateTime()
{
	var HdrformObj = parent.parent.intra_anesth_header_frame.RecordAnesthesiaHdrForm;
	var start_date=HdrformObj.start_date.value;
	var locale=HdrformObj.locale.value;
	start_date=convertDate(start_date,"DMY",locale,"en");
	var start_time=HdrformObj.start_time.value;
	var current_date=HdrformObj.current_date.value;
	var current_time=HdrformObj.current_time.value;
	var current_date_time=HdrformObj.current_date_time.value;
//	alert('CompareDateTime'+current_date_time);
	var start_date_time=start_date+" "+start_time;
//Modified by DhanasekarV against incident  IN026087 on 27/01/2011
if(!(isBeforeCurrent(start_date_time,"DMYHM",locale) ))
	
		return 0;
	else
		return 1;

/*	if(compareDatesLocal(current_date_time,start_date_time))
		return 0;
	else
		return 1;
		*/
	
}

function CompareDateTime1()
{
	var HdrformObj = parent.parent.intra_anesth_header_frame.RecordAnesthesiaHdrForm;
	var HdrformObj = parent.parent.intra_anesth_header_frame.RecordAnesthesiaHdrForm;
	var finish_date=HdrformObj.finish_date.value
	var locale=HdrformObj.locale.value
	finish_date=convertDate(finish_date,"DMY",locale,"en");
	var finish_time=HdrformObj.finish_time.value
	var current_date=HdrformObj.current_date.value
	var current_time=HdrformObj.current_time.value
	var finish_date_time=finish_date+" "+finish_time
	var current_date_time=HdrformObj.current_date_time.value;
//		alert('CompareDateTime 1'+current_date_time);

//Modified by DhanasekarV against incident  IN026087 on 27/01/2011
	if(finish_date_time!=null && current_date_time!="")
	if(!(isBeforeCurrent(finish_date_time,"DMYHM",locale) ))	
		return 0;
	else
		return 1;

/*	if(compareDatesLocal(current_date_time,finish_date_time))
		return 0;
	else
		return 1;
		*/
}

function CompareDateTime2()
{
	var HdrformObj = parent.parent.intra_anesth_header_frame.RecordAnesthesiaHdrForm;
	var finish_date=HdrformObj.finish_date.value
	var finish_time=HdrformObj.finish_time.value
	var start_date=HdrformObj.start_date.value
	var start_time=HdrformObj.start_time.value
	var finish_date_time=finish_date+" "+finish_time
	var start_date_time=start_date+" "+start_time
	if(finish_date_time!=null && finish_date_time!="")
	if(compareDates1(finish_date_time,start_date_time))
		return 0;
	else
		return 1;
			
}

function compareDates(fromdate,todate) {
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
            if(Date.parse(todt) <= Date.parse(fromdt)) {
                return false;
            }
    }
	return true;
}


function compareDates1(fromdate,todate) {
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
			if(Date.parse(todt) < Date.parse(fromdt)) {
                return false;
            }
    }
	return true;
}

function checkDateFormat(obj)
{
	if(obj.value!=null && obj.value!="")
	{
	var retVal= checkDt(obj.value)
		if(retVal== false)
		{
			//alert("Invalid Date Format");
			alert(getMessage("APP-OT0136","OT"));
			obj.select();
		}
	}
}
function chkTimeFormat(obj)
{
	if(obj.value!=null && obj.value!="")
	{
	var retVal= chkTime(obj.value)
		if(retVal== false)
		{
			//alert("Time Format should be hh:mi");
			alert(getMessage("VALID_TIME_SLOTS","OT"));
			obj.select();
		}
	}
}
async function callIntraAnesthesiaNotes(login_user){
	/*var formObjHdr=parent.frames[2].document.forms[0];
	var formObj = document.forms[0];
	var title= getLabel("eOT.IntraAnaesthesiaNotes.Label","OT");
	var facility_id = formObj.facility_id.value;
	var patient_id = formObjHdr.patient_id.value;
	var patient_name =formObjHdr.patient_name.value;
	//alert("patient_id-->"+patient_id);
	var episode_id = formObjHdr.episode_id.value;
	var patient_class = formObjHdr.patient_class.value;
	var encounter_id = formObjHdr.encounter_id.value;
	var called_from = "INTRA_ANES";
	var speciality_code="";
	var anesthesia_accession_num=formObjHdr.accession_num.value;
	var anesthesia_srl_no=formObjHdr.anesthesia_srl_no.value;
	var accession_num="";
	var locn_type = "80";
	var url = "../../eOT/jsp/SelectNoteTypeFrames.jsp?"+ "facility_id="+facility_id+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&encounter_id="+encounter_id+"&called_from="+called_from+"&anesthesia_accession_num="+anesthesia_accession_num+"&speciality_code="+speciality_code+"&locn_type="+locn_type+"&slate_user_id="+login_user+"&anesthesia_srl_no="+anesthesia_srl_no+"&accession_num="+accession_num;
	//alert(url);
	var retVal;
	var dialogHeight = "5";
    var dialogWidth  = "20";
    var dialogTop    = "200";
    var dialogLeft   = "200";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	var arguments    = "" ;
	retVal 	   = window.showModalDialog(url, arguments, features);*/


/*New changes done by Suma on 15 march 2010 to handle null pointer exception when CA page is opened without proxy*/

	var window_close="Y";
	var speciality_code= ""; 
	var hide_header="N";
	var locn_type="80";
	var called_from="INTRA_ANES";
	var formObjHdr=parent.frames[2].document.forms[0];
	var anesthesia_srl_no = formObjHdr.anesthesia_srl_no.value;
	var anesthesia_accession_num =  formObjHdr.accession_num.value;
	var accession_num="";
	var facility_id = formObjHdr.facility_id.value;
	var patient_id = formObjHdr.patient_id.value;
	var episode_id = formObjHdr.episode_id.value;
	var patient_class = formObjHdr.patient_class.value;
	var encounter_id = formObjHdr.encounter_id.value;
	var contr_mod_accession_num="";
	contr_mod_accession_num = facility_id+anesthesia_srl_no+"INTRA";	
	var tab_yn="N";
	var title= getLabel("eOT.IntraAnaesthesiaDetails.Label","OT");
	title=encodeURIComponent(title);
	var function_id="SPCL_NOTE";
	var event_class="$PHY$";

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=Pre_anesthesia_notes&accession_num="+accession_num+"&facility_id="+facility_id+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&encounter_id="+encounter_id+"&called_from="+called_from+"&speciality_code="+speciality_code+"&locn_type="+locn_type+"&contr_mod_accession_num="+contr_mod_accession_num,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);

	var arr_spec=retVal.split(",");
	var arr2_spec="";
	var note_type_value="";
	var note_type="";
	var note_type_desc="";
	note_type =arr_spec[0];
	note_type_desc=arr_spec[1];
	update_mode=arr_spec[3];
	accession_num=arr_spec[4];
		
		
	//Added performed_by_ql on 1/19/2011 by Anitha for 25928

	var action_url	=	"../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=OT_NOTES&title="+title+"&note_type="+note_type+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&function_id="+function_id+"&event_class="+event_class+"&accession_num="+accession_num+"&window_close="+window_close+"&ot_speciality_code="+speciality_code+"&hide_header="+hide_header+"&tab_yn="+tab_yn+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&contr_mod_accession_num="+contr_mod_accession_num+"&performed_by_ql="+formObjHdr.strUser.value;

//alert("1"+patient_id);
	var title1="";

	var dialogHeight= "42";
	var dialogWidth	= "85";
	dialogTop    = "55";
		 dialogLeft   = "30";
	var status = "no";
	var arguments	= "";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal  = await window.showModalDialog(action_url, title1, features);

}
/*Added by Suma ends here*/

/*function callPreAnaesNotes(login_user){
	var formObjHdr=parent.frames[1].document.forms[0];
	var formObj = document.forms[0];
	var title="Pre Anaesthesia Notes";
	var facility_id = formObj.facility_id.value;
	var patient_id = formObj.patient_id.value;
	var episode_id = formObjHdr.episode_id.value;
	var patient_class = formObjHdr.patient_class.value;
	var encounter_id = formObjHdr.encounter_id.value;
	var called_from = "PRE_ANES";
	var anesthesia_accession_num=formObjHdr.accession_num.value;
	var anesthesia_srl_no=formObjHdr.anesthesia_srl_no.value;
	var accession_num="";
	var speciality_code="";
	var locn_type = "70";
	var url = "../../eOT/jsp/SelectNoteTypeFrames.jsp?"+ "facility_id="+facility_id+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&encounter_id="+encounter_id+"&called_from="+called_from+"&anesthesia_accession_num="+anesthesia_accession_num+"&speciality_code="+speciality_code+"&locn_type="+locn_type+"&slate_user_id="+login_user+"&anesthesia_srl_no="+anesthesia_srl_no+"&accession_num="+accession_num;
	//alert(url);
	var retVal;
	var dialogHeight = "5";
    var dialogWidth  = "20";
    var dialogTop    = "200";
    var dialogLeft   = "200";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	var arguments    = "" ;
	retVal 	   = window.showModalDialog(url, arguments, features);
}
*/

async function callPreAnaesNotes(login_user){
	var formObjHdr=parent.frames[2].document.forms[0];
	var formObj = document.forms[0];

	var title= getLabel("eOT.PreAnaesthesiaNotes.Label","OT");
	var facility_id = formObj.facility_id.value;
	var anesthesia_srl_no=formObjHdr.anesthesia_srl_no.value;
	var url = "../../eOT/jsp/AT_PreAnaesDtlsView.jsp?"+ "facility_id="+facility_id+"&anesthesia_srl_no="+anesthesia_srl_no;
	//alert(url);
	retVal=await window.showModalDialog(url,window,"dialogHeight: 700px; dialogWidth:800px; center: yes; help: no; resizable: yes; status: no;");	
}

function callPatientHistory(objVal)
{
	var patient_id=objVal;
	var HTML = "<html>"
	HTML += "<form name='historyForm' id='historyForm' action='../../eCA/jsp/OpenChartWrapper.jsp'>"
	HTML += "<input type='text' name='insert_op' id='insert_op' value= 'N'>";
	HTML += "<input type='text' name='patient_id' id='patient_id' value= '" +patient_id+ "'>"; 
	HTML += "</form>"
	HTML += "</html>"
	//alert(parent.parent.messageFrame.name);
	parent.parent.messageFrame.document.body.insertAdjacentHTML("BeforeEnd", HTML);
	parent.parent.messageFrame.document.historyForm.submit();

}

function localSearchPatient(){
	var formObj = document.forms[0];
	var nursing_unit = formObj.nursing_unit.value;
	var locale = formObj.locale.value;
	if(nursing_unit!=""){
		var dialogTop  = "40";
		var dialogHeight = "10";
		var dialogWidth  = "40";
		var arguments = "";
		var column_sizes = escape("20%,60%,20%");
		

		var column_descriptions = getLabel('Common.patientId.label','common')+','+getLabel('Common.PatientName.label','Common')+','+getLabel('Common.encounterid.label','Common');
	
		column_descriptions = encodeURIComponent(column_descriptions);

		var sql=escape("SELECT I.PATIENT_ID PATIENT_ID1, DECODE('"+locale+"','en',M.PATIENT_NAME, NVL(M.PATIENT_NAME_LOC_LANG,M.SHORT_NAME)) SHORT_NAME1,O.OPEN_EPISODE_ID OPEN_EPISODE_ID FROM MP_PATIENT M, IP_OPEN_EPISODE O, IP_EPISODE I WHERE M.PATIENT_ID = O.PATIENT_ID AND O.OPEN_EPISODE_ID=I.EPISODE_ID AND O.PATIENT_ID=I.PATIENT_ID ");
		var title  = getLabel("Common.SearchPatient.label","Common");
		title=encodeURIComponent(title);	
		var features  = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
		retVal=window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);

		if(retVal!=null){
		var arr = retVal.split('::');
			formObj.patient_id.value=arr[0];
			formObj.patient_name.value=arr[1];
		}else{
			formObj.patient_id.value='';
			formObj.patient_name.value='';
		}
	}else{
		//alert("Select the Nursing Unit");
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var NursingUnit  = getLabel("Common.nursingUnit.label","Common");
		
		
		
		alert(msgArray[0]+NursingUnit+(msgArray[1]));
		formObj.patient_id.value='';
		formObj.patient_name.value='';
	}
}
function searchname(obj)
{
var locale = document.forms[0].locale.value;
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
var flg="";
	//alert("obj"+obj);
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var frmObj=document.forms[0];
	var pract_vals=document.forms[0].pract_type.value;
	//alert("pract_vals"+pract_vals);
	var paract_array=pract_vals.split("##");
	var pract_type= paract_array[0];
	//alert("pract_type"+pract_type);
	if(pract_type!="" && pract_type!='null')
	{
		var column_sizes = escape("60%,40%");               
		var column_descriptions = getLabel('Common.name.label','Common')+','+getLabel('Common.code.label','Common');
		column_descriptions = encodeURIComponent(column_descriptions);			
		var sql="";
		if(pract_type=='OS' || pract_type=='AS')
		{
			sql="SELECT PRACTITIONER_NAME DESCRIPTION, PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN ('MD','SG','PS','DN') AND upper(short_name) like upper(?) AND upper(PHYSICIAN_ID) like upper(?) order by 2";
		}
		else if(pract_type=='MA' || pract_type=='AA')
		{
			sql="SELECT PRACTITIONER_NAME DESCRIPTION, PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN ('AN') AND upper(short_name) like upper(?) AND upper(PHYSICIAN_ID) like upper(?) order by 2";
		}
		else if(pract_type=='NS')
		{
			sql="SELECT PRACTITIONER_NAME DESCRIPTION, PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN ('NS')AND upper(short_name) like upper(?) AND upper(PHYSICIAN_ID) like upper(?) order by 2";
		}
	//}
//	var sql="select short_name DESCRIPTION,PHYSICIAN_ID CODE from SY_PHYSICIAN_MAST where FACILITY_ID = '"+frmObj.facility_id.value+"' and  PRACT_TYPE IN ('AN') and  NVL(STATUS,'X') <> 'S' AND upper(short_name) like upper(?) AND upper(PHYSICIAN_ID) like upper(?) order by 2";

//var sql="SELECT  to_char(ORDER_DATE_TIME,'dd/mm/yyyy hh24:mi') DESCRIPTION, ORDER_ID CODE FROM OT_PENDING_ORDER WHERE PERFORMING_FACILITY_ID ='"+frmObj.facility_id.value+"' AND upper(ORDER_ID) like upper(?) AND upper(ORDER_DATE_TIME) like upper(?) order by 1";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	//alert(argumentArray[1]);
	
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
//	alert(argumentArray[2]);
//	alert(argumentArray[3]);
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	//alert("obj.value"+obj.value);
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	//var surgeon = getLabel("Common.Surgeon.label","Common");
	
	var practioner =getLabel("Common.practitioner.label","Common");
	var 
	returnedValues = CommonLookupnamesearch(practioner, argumentArray );
	
	if((returnedValues != null) && (returnedValues != "") )  {
	//frmObj.Anaesthetiest2_code.value=returnedValues[1];
	//obj.value=returnedValues[0];
		//frmObj.Anaesthetiest1_code.value=returnedValues[0];
	}
	}
	else 
	{
		//alert(getMessage("PRACT_TYPE_BLANK"));
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		
		var practitionerType =getLabel("Common.practitionertype.label","Common");
		alert(msgArray[0]+practitionerType+(msgArray[1]));
	}
}

async function CommonLookupnamesearch(title, pArgumentArray)
{
	//alert("enteringherer");
    var retVal = new String();
    var dialogHeight= "28" ;
    var dialogWidth = "43" ;
    var status = "no";

    var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;

    xmlStr ="<root><SEARCH " ;
    xmlStr +=" /></root>" ;

    //alert(pArgumentArray)

    firstCodeVal = "" ;
    firstDescVal = "" ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

    //alert(formQueryString(pArgumentArray,0))
    xmlHttp.open( "POST", "../../eOT/jsp/AT_NameSearchLookupResult.jsp?callFrom=0&" + formQueryStringorderid(pArgumentArray,0) , false ) ;
    xmlHttp.send( xmlDoc ) ;
    responseText=xmlHttp.responseText ;

    eval(responseText) ;

    if(firstCodeVal == "")
    {
        var dialogUrl       = "../../eOT/jsp/AT_NameLookup.jsp.jsp?title="+title ;
        var dialogArguments = pArgumentArray ;
        var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
        var returnVal = await window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);

        if( returnVal == null || returnVal == "" )
            return "";
        else
            return returnVal.split("\"") ;
     }
     else
     {
         if(pArgumentArray[7] == CODE_DESC )
         {
            var temp = firstCodeVal
            firstCodeVal = firstDescVal
            firstDescVal = temp
         }
          returnVal = firstCodeVal + "\"" + firstDescVal

         return returnVal.split("\"") ;
     }
}

function formQueryStringorderid( pArgumentArray, callFrom ) {

//alert("formQueryStrin");
    var argArray
    if(callFrom != 0)
        argArray = window.dialogArguments ;
    else
        argArray = pArgumentArray

    var sqlData         = argArray[0] ;
    var dataNameArray   = argArray[1] ;
    var dataValueArray  = argArray[2] ;
    var dataTypeArray   = argArray[3] ;
    var positionVal     = argArray[4] ;

    var linkFields      = argArray[6] ;
    var displayOrder    = argArray[7] ;
	//enhancement code - added to provide query result ordered by code or description based the radio button selection, only if supplied query does not have a ORDER BY clause

	if(sqlData.toUpperCase().indexOf("ORDER BY")==-1){
		//add order by clause based on value of radio button
		if(radioval=="D"){
				sqlData = sqlData.concat(" ORDER BY description ");
		}else{
				sqlData = sqlData.concat(" ORDER BY code ");
		}
	}

	//enhancement ends
    var url = "sqlData="+escape(sqlData) ;
	
    for(i = 0 ; i<dataNameArray.length ; i++) {
        if(positionVal.indexOf( toString(i) ) == -1)
        {
            url += "&f"+(i+1)+"="  +dataValueArray[i] ;
            url += "&f"+(i+1)+"T=" +dataTypeArray[i] ;
        }
    }
    var positionValArr = positionVal.split( "," ) ;

    var codePosition = parseInt( positionValArr[1] ) ;
    var descPosition = parseInt( positionValArr[0] ) ;

    //alert( "callFrom:" + callFrom );
    if(callFrom != 0)
    {
        if( radioval =="C" ) {
            url += "&f" + codePosition + "=" + escape( document.getElementById("search_text").value ) ;
            url += "&f" + descPosition + "=";
        } else {
            url += "&f" + codePosition + "=" ;
            url += "&f" + descPosition + "=" + escape( document.getElementById("search_text").value ) ;
        }
    }
    else
    {
        if(displayOrder == DESC_CODE)
        {
            url += "&f" + codePosition + "=" ;
            url += "&f" + descPosition + "=" + escape( argArray[5] ) ;
            //alert("descPosition:"+descPosition+argArray[5])
        }
        else
        {
            url += "&f" + codePosition + "=" + escape( argArray[5] ) ;
            url += "&f" + descPosition + "=" ;
        }
    }

    url += "&f" + codePosition + "T=String" ;
    url += "&f" + descPosition + "T=String" ;

    if(callFrom != 0)
        url += "&sc=" + escape(document.getElementById("search_criteria").options.value) ;
    else
        url += "&sc=S" ;

    url += "&displayOrder=" + displayOrder ;
    if( displayOrder == DESC_CODE ) {
        if( linkFields == CODE_LINK )
            linkFields = DESC_LINK ;
        else if ( linkFields == DESC_LINK )
            linkFields = CODE_LINK ;
    }

    url += "&linkFields=" + linkFields ;
    //alert( "urlFinal:"+url );
    return url ;
}


function storeValorderid(currad) {
//	alert("currad"+currad);
    radioval=currad.value;
//	alert("radioval"+radioval);
}

function valtextorderid(comp) {
   	var txt=comp.value ;
    CallDescFrameorderid(this);
}
function resetFormorderid( formObj )
{
    formObj.reset();
 //   parent.lookup_detail.location.href = "../../eCommon/html/blank.html";

}

function initializeTextorderid() {
//	alert("enter INTIAL");
    var argArray = window.dialogArguments ;
    document.getElementById("search_text").value = argArray[5] ;
	//alert(document.getElementById("search_text").value);
    //makeValidString( document.getElementById("search_text") ) ;
    if(argArray[5] !='' )
    {
		//alert("HELLO");
        fromCalledPage = true
        CallDescFrameorderid() ;
    }
}


function CallDescFrameorderid() {
	//alert("SDFDSF");
//    alert(formQueryStringorderid());
    parent.lookup_detail.location.href = "../../eOT/jsp/AT_NameSearchLookupResult.jsp?" + formQueryStringorderid();
}

function Modifyorder(obj){
    var argArray = window.dialogArguments ;
    var displayOrder    = argArray[7] ;
	var code1=obj.cells[0].innerText;
    var code2=obj.cells[1].innerText;

    if( displayOrder == DESC_CODE ) {
        var temp = code1;
        code1 = code2;
        code2 = temp ;
    }
	//alert("code1"+code1+"code2"+code2);
    var retVal = code1 + "\"" + code2 ;
	//alert(retVal);
    top.window.returnValue = retVal ;
    top.close()
}

function getPositionDesc(practitioner_id,locale){
	//alert("Enters");
	var xmlStr ="<root><SEARCH";
	xmlStr +=" /></root>";
	var formObj = document.forms[0];
	var sql = "SELECT B.POSITION_DESC FROM AM_PRACTITIONER_LANG_VW A,AM_POSITION B WHERE A.LANGUAGE_ID='"+locale+"' AND PRACTITIONER_ID = '"+practitioner_id+"' AND  A.POSITION_CODE  = B.POSITION_CODE (PLUS) ";
	var params = "sql="+sql+"&flag=PERS_RECORD";
	var temp_jsp="../../servlet/eOT.CommonQueryServlet?"+params;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=localTrimString(xmlHttp.responseText);
	return responseText;
}

 function localTrimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}

async function callRecordChart(){
	var formObj=parent.frames[2].document.forms[0];
	var chart_id  = formObj.chart_id.value;
	/*Modified By Muthukumar against Issue Number- SRR20056-SCF 7625 on 14/06/2011*/	
	 if(chart_id==null || chart_id.length == 0 ||  chart_id ==""){	 
		chart_id = "null";
		}
	/*Modified By Muthukumar against Issue Number- SRR20056-SCF 7625 on 14/06/2011*/
	 var patient_id = formObj.patient_id.value;
	 var episode_id = formObj.episode_id.value;
	 var date_time = trimString(getSysDateTime());
	 var encounter_id = formObj.encounter_id.value;
	 var facility_id = formObj.facility_id.value;
	 //var patient_class = formObj.patient_class.value;
	 //var episode_type = formObj.episode_type.value;
	 //var window_name = patient_id+encounter_id;
	 //var url = "../../eCA/jsp/DisDataCharting.jsp?option_id=VITAL_SIGNS1&patient_id="+patient_id+"&visit_id=&episode_id="+episode_id+"&encounter_id="+encounter_id+"&location_code=&location_type=&bed_num=&room_num=&episode_type="+episode_type+"&discharge_date=&visit_adm_date=&episode_Status=&Sex="+sex+"&Age=&Dob="+dob+"&security_level=&protection_ind=&reln_req_yn=N&patient_class="+patient_class+"&PQ=Y&CA=N&relationship_id=&window_name="+window_name+"&child_window=Y&mode=R&module_id=AT&discr_msr_id="+discr_msr_id;
	 var url='../../eCA/jsp/ChartRecording.jsp?patient_id='+patient_id+'&function_from=CP&p_start_date_time='+date_time+'&Chart_Id='+chart_id+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id;
	var retVal;
	var dialogHeight = "60" ;
	var dialogWidth  = "70" ;
	var dialogTop    = "200";
	var dialogLeft   = "100";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	var arguments    = "" ;
	retVal  = await window.showModalDialog(url, arguments, features);
	//retVal  = window.open(url, arguments, features);
		
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


function checkCheckInTime(){
		var HdrformObj = parent.parent.intra_anesth_header_frame.RecordAnesthesiaHdrForm;
		var accession_num = HdrformObj.accession_num.value;
		var facility_id=HdrformObj.facility_id.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "func_mode=checkInTime&facility_id="+facility_id+"&oper_num="+accession_num;
		xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		return retVal;

}

