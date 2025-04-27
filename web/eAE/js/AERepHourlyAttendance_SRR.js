/*function doMonthCheck(from,to,messageFrame) {
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[1],fromarray[0],"01");
			var todt = new Date(toarray[1],toarray[0],"01");	
			if(Date.parse(todt) < Date.parse(fromdt)) {
				var err=getMessage("REMARKS_MUST_GR_EQUAL",'Common');
				err=err.replace("$",getLabel("Common.month.label","Common"));
				err=err.replace("#",getLabel("Common.month.label","Common"));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+err;		
				//messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=APP-SM0012 - To Month should be greater than or equal to From Month";		
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}	
return true;
}*/


function reset() {
	
	if(f_query_add_mod.document.RepHourlyAttendance){
	   //f_query_add_mod.document.RepHourlyAttendance.reset() ;
	     f_query_add_mod.location.reload() ;
	}

}

function checkdate(obj){
	if(obj.value!=''){
	if(validDate(obj.value,"DMY",localeName))
		return true;
	else{
		alert(getMessage("INVALID_DATE_FMT", "SM"));
		obj.focus();
	}
	}
}


function run() 
{
var locale=f_query_add_mod.RepHourlyAttendance.locale.value
var report_type=f_query_add_mod.document.forms[0].p_report_flag.value;

/*Below line modified for this SCF [SRR20056-SCF-9516]*/

var p_fm_queue_date=f_query_add_mod.document.RepHourlyAttendance.p_fm_queue_date1;
var p_to_queue_date=f_query_add_mod.document.RepHourlyAttendance.p_to_queue_date1;
var format;
	if(f_query_add_mod.document.RepHourlyAttendance.p_date_format.value=='dd/mm/yyyy')
		format="DMY";
	else if(f_query_add_mod.document.RepHourlyAttendance.p_date_format.value=='mm/yyyy')
		format="MY";
	else
		format="YY"
var fields = new Array (p_fm_queue_date,p_to_queue_date);
var names; // = new Array ( "Date From","Date To");;
//is to changed
var p_fm_queue_date1=p_fm_queue_date.value;
var p_to_queue_date1=p_to_queue_date.value;
var error=getMessage("REMARKS_MUST_GR_EQUAL",'Common');
error=error.replace("$",getLabel('Common.year.label','common'));
error=error.replace("#",getLabel('Common.year.label','common'));

messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;
if(report_type=='1')
	names = new Array (getLabel("Common.date.label","Common")+" "+getLabel("Common.from.label","Common"),getLabel("Common.date.label","Common")+" "+getLabel("Common.to.label","Common"));
else if(report_type=='2')
	 names = new Array (getLabel("Common.month.label","Common")+" "+getLabel("Common.from.label","Common"),getLabel("Common.month.label","Common")+" "+getLabel("Common.to.label","Common"));
else
    names = new Array (getLabel("Common.year.label","Common")+" "+getLabel("Common.from.label","Common"),getLabel("Common.year.label","Common")+" "+getLabel("Common.to.label","Common"));

if( f_query_add_mod.CheckString1(getLabel("Common.treatmentarea.label","Common"), f_query_add_mod.document.forms[0].p_fr_tmt_area_code,f_query_add_mod.document.forms[0].p_to_tmt_area_code, messageFrame )  )
if(f_query_add_mod.document.RepHourlyAttendance){
if(f_query_add_mod.checkFields( fields, names, messageFrame)){
			if(f_query_add_mod.isBeforeNow(p_fm_queue_date1,format,locale)){
				if(f_query_add_mod.isBeforeNow(p_to_queue_date1,format,locale)){
					if(f_query_add_mod.isBefore(p_fm_queue_date1,p_to_queue_date1,format,locale)){
					f_query_add_mod.document.RepHourlyAttendance.p_fm_queue_date.value=convertDate(f_query_add_mod.document.RepHourlyAttendance.p_fm_queue_date1.value,"DMY",f_query_add_mod.document.RepHourlyAttendance.locale.value,"en");
					f_query_add_mod.document.RepHourlyAttendance.p_to_queue_date.value=convertDate(f_query_add_mod.document.RepHourlyAttendance.p_to_queue_date1.value,"DMY",f_query_add_mod.document.RepHourlyAttendance.locale.value,"en");
							f_query_add_mod.document.RepHourlyAttendance.submit() ;	
					}else{
			var error1=f_query_add_mod.getMessage("REMARKS_MUST_GR_EQUAL","common") ;
			 var visit=f_query_add_mod.getLabel("Common.to.label","Common")+" "+f_query_add_mod.getLabel("eAE.AttendanceDate.label","AE");
			 var visitto=f_query_add_mod.getLabel("eAE.AttendanceDate.label","AE");
						error1=error1.replace("$",visit);
						error1=error1.replace("#",visitto);
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error1 ;
			return false;
		}

				}else{
                 var error=f_query_add_mod.getMessage("ATTEND_DATE_GT_CURR",'AE');
				error=error.replace("$",f_query_add_mod.getLabel("Common.to.label","Common"));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		
				return false;
			}
			}else{
                 var error=f_query_add_mod.getMessage("ATTEND_DATE_GT_CURR",'AE');
				error=error.replace("$",f_query_add_mod.getLabel("Common.from.label","Common"));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		
				return false;
			}


}

}  


}//e.o.run

function flagChange(Obj)
{
if(Obj== "1") 
				{ //Modified for this incident 47780
				document.getElementById("labelid").innerHTML=getLabel("Common.date.label","Common")+"  &nbsp";					document.getElementById("fromid").innerHTML="<input type='text' id='p_fm_queue1' value='' name='p_fm_queue_date1' id='p_fm_queue_date1' maxlength='10' size ='10' onBlur='if(CheckDate(this)){setDate_D(this)}'><img  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_queue_date1.select();return showCalendar('p_fm_queue1','dd/mm/y',null)\"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>";	
				document.getElementById("toid").innerHTML="<input type='text' id='p_to_queue1' value='' name='p_to_queue_date1' id='p_to_queue_date1' maxlength='10' size ='10' onBlur='if(CheckDate(this)){setDate_D(this)}'><img  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_queue_date1.select();return showCalendar('p_to_queue1','dd/mm/y',null)\"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>";	

				document.forms[0].p_dflt_fm_date.value='01/01/1472';
				document.forms[0].p_dflt_to_date.value='31/12/5000';
				document.forms[0].p_date_format.value='dd/mm/yyyy';
				}
else if (Obj== "2") 
				{ //Modified for this incident 47780
				document.getElementById("labelid").innerHTML=getLabel("Common.month.label","Common")+"  &nbsp";					document.getElementById("fromid").innerHTML="<input type='text' id='p_fm_queue1' value='' name='p_fm_queue_date1' id='p_fm_queue_date1' maxlength='7' size ='7' onBlur='if(CheckMonth(this)){setDate_M(this)}'><img  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_queue_date1.select();return showCalendar('p_fm_queue1','mm/y',null)\"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>";
				document.getElementById("toid").innerHTML="<input type='text' id='p_to_queue1' value='' name='p_to_queue_date1' id='p_to_queue_date1' maxlength='7' size ='7' onBlur='if(CheckMonth(this)){setDate_M(this)}'><img  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_queue_date1.select();return showCalendar('p_to_queue1','mm/y',null)\"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>";	

				document.forms[0].p_dflt_fm_date.value='01/1472';
				document.forms[0].p_dflt_to_date.value='12/5000';
				document.forms[0].p_date_format.value='mm/yyyy';

				}	
else
	{          //Modified for this incident 47780
				document.getElementById("labelid").innerHTML=getLabel('Common.year.label','common')+"  &nbsp";					document.getElementById("fromid").innerHTML="<input type='text' id='p_fm_queue1' value='' name='p_fm_queue_date1' id='p_fm_queue_date1' maxlength='4' size ='4' onBlur='if(CheckYear(this)){setDate_Y(this)}'><img  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_queue_date1.select();return showCalendar('p_fm_queue1','y',null)\"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>";	
				document.getElementById("toid").innerHTML="<input type='text' id='p_to_queue1' value='' name='p_to_queue_date1' id='p_to_queue_date1' maxlength='4' size ='4' onBlur='if(CheckYear(this)){setDate_Y(this)}'><img  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_queue_date1.select();return showCalendar('p_to_queue1','y',null)\"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>";	
				document.forms[0].p_dflt_fm_date.value='1472';
				document.forms[0].p_dflt_to_date.value='5000';
				document.forms[0].p_date_format.value='yyyy';

				}
     	
}

function CheckMonthValid(obj){
				if (obj.value!=null){ 
					if (parseInt(obj.value)>13 || parseInt(obj.value)<0) {
						//alert("Invalid Month");
                        var month=getMessage("INVALID_VALUE",'Common')
							month.replace("#",getLabel("Common.month.label","Common"))
							alert(month)
						return false;
					}
				}
}

function Checkcurrdate(from,to,str,messageFrame) {
	//alert('in check curr date');
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);	
			if(Date.parse(todt) < Date.parse(fromdt)) {
				var error=f_query_add_mod.getMessage("VISIT_DATE_GT_CURR",'AE');
				error=error.replace("$",str);
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}	
	
return true;
}

function searchCode1(obj,target)
{
	var retVal         = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
	var sql="";	
	var p_faclid = document.forms[0].p_facility_id.value;
    var p_usr = document.forms[0].p_user_name.value;
    var locale = document.forms[0].locale.value;

		tit=getLabel("Common.Location.label","Common");

	sql="select clinic_code code, short_desc description from OP_clinic where Facility_id = '"+p_faclid+"' and  LEVEL_OF_CARE_IND ='E' and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_DESC_LINK  ;
		argumentArray[7] = CODE_DESC ;
	

	var retVal=CommonLookup(tit,argumentArray);
	if(retVal==null || retVal=="")
	target.value="";
	else
	target.value=retVal[0];
}

function nursCode(obj,target)
{
	var retVal         = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
	var sql="";	
	var p_faclid = document.forms[0].p_facility_id.value;
    var p_usr = document.forms[0].p_user_name.value;
    var locale = document.forms[0].locale.value;
    var p_fr_locn_code = document.forms[0].p_fr_locn_code.value;

    //title="Nursing Unit";
	tit=getLabel("Common.treatmentarea.label","Common");

		if(p_fr_locn_code!="")
	{
		sql="select TREATMENT_AREA_CODE code, SHORT_DESC description  from ae_tmt_area_for_clinic_lang_vw where language_id='"+locale+"' and clinic_code= '"+p_fr_locn_code+"'  and facility_id='"+p_faclid+"' and upper(TREATMENT_AREA_CODE) like upper(nvl(?,TREATMENT_AREA_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC))  order by 2";
	}
	else
		sql="select distinct TREATMENT_AREA_CODE code, SHORT_DESC description  from ae_tmt_area_for_clinic_lang_vw where language_id='"+locale+"' and  facility_id='"+p_faclid+"' and upper(TREATMENT_AREA_CODE) like upper(nvl(?,TREATMENT_AREA_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC))  order by 2";

		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_DESC_LINK  ;
		argumentArray[7] = CODE_DESC ;
	

	var retVal=CommonLookup(tit,argumentArray);
	if(retVal==null || retVal=="")
	target.value="";
	else
	target.value=retVal[0];
}


function CheckString1(str ,fromobj,toobj,messageFrame) {

 var arr = new Array(toobj.value,fromobj.value);
    if( trimCheck(fromobj.value) && trimCheck(toobj.value) ) {
        if(fromobj.value <= toobj.value) {
            return true;
        }
        else {
			var error=getMessage("REMARKS_MUST_GR_EQUAL","common",arr);
		
			error=error.replace("$",getLabel('Common.to.label','common_labels')+ ' ' +str);
			error=error.replace("#",str);
            messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
            return false;
        }
    }
    else {
        return true;
    }
}

function clearDetail1(obj){
if(obj.value==null||obj.value==""){
        document.forms[0].p_fr_tmt_area_code.value='';
		document.forms[0].p_to_tmt_area_code.value='';

		}
	else{
	    document.forms[0].p_fr_tmt_area_code.value='';
        document.forms[0].p_to_tmt_area_code.value='';
     
	}
}

function doDate(obj)
{
	if(obj.value!='')
	{
		if(!validDateObj(obj,'DMY',localeName))
		{
			obj.select();
		}
		else
		{
		if(isBeforeNow(obj.value,"DMY",localeName))
		return true;
	else {
		alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
					obj.select();
					return false ;
	 }
	}
	}
}

function setDate_D(Object){ 
    if(Object.value!="")
	{
	   if(isBeforeNow(Object.value,"DMY",localeName)){
            return true;
        }
        else{
			alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
			Object.value="";
            Object.focus();            
        }
    }
}

function setDate_M(Object){ 
    if(Object.value!="")
	{
	   if(isBeforeNow(Object.value,"MY",localeName)){
            return true;
        }
        else{
			alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
			Object.value="";
            Object.focus();            
        }
    }
}

function setDate_Y(Object){ 
    if(Object.value!="")
	{
	   if(isBeforeNow(Object.value,"YY",localeName)){
            return true;
        }
        else{
			alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
			Object.value="";
            Object.focus();            
        }
    }
}

function CheckMonth(obj)
{
    if(monthcheck(obj)==false)
    {
        alert(getMessage("MONTH_YEAR_INVALID", "SM"));
        obj.select();
        obj.focus();
    }
	else
		return true;
}

function monthcheck(obj)
{
   if ( obj.value != undefined)
	{
		obj = obj.value ;
	}
	else
		obj = obj;

	var dt=obj;
    var strMonth ;
    var strYear;
    if( dt.length > 0 )
    {
        var arr = new Array();
        arr = dt.split("/");
        if(arr.length != 2) return false;
        else
        {
            strMonth = arr[0];
            strYear = arr[1];

            if (strMonth.substring(1,2) == ".") return false;
            if (strYear.length < 4 || strYear.length > 4) return false;

            if (isNaN(strMonth)==true) return false;
            if (isNaN(strYear)==true) return false;

            if (strYear < 1900) return false;
            if (strMonth>12 || strMonth<1) return false;
        }
    } else return true;
    return true;
}


function CheckYear(Obj) {
    var val = Obj.value;
    var Year = Obj.value;
    if ((trimCheck(val)==false && isNaN(val) && val >=0 )
    ||( Year.length < 4 && Year.length > 0)
    ||(Year.length == 4 && isNaN(val) == true) )
    {
        alert(getMessage("INVALID_YR_FORMAT", "SM"));
        Obj.select();
        Obj.focus();
    }
	else
		return true;
}

