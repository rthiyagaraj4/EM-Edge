var babyDetails = new Array();
var motherName = new Array();
patIdArr = new Array();
episodeIdArr = new Array();
patient_class = new Array();

var scrollValue=0;
function patClick(ind)
{
	document.PatCriteriaFrm.patient_class.value = patient_class[ind];
	document.PatCriteriaFrm.encounter_id.value = episodeIdArr[ind] ;
	document.PatCriteriaFrm.patient_id.value= patIdArr[ind];
	document.PatCriteriaFrm.submit();
}
var reOrder='';
var anchorID='';
function callForOrderBy(obj)
{	
	var active_flg=document.getElementById("active_flg").value;
	var from_date_time=document.getElementById("from_date_time").value;
	var to_date_time=document.getElementById("to_date_time").value;
	var url='&active_flg='+active_flg+'&orderBy='+obj+'&reOrder='+reOrder+'&anchorID='+anchorID+'&from_date_time='+from_date_time+'&to_date_time='+to_date_time;
	parent.frames[1].location.href='PersonalisePatListDetails.jsp?'+url;
}
function changeColor(object)
{
	anchorID=object.id;
	if(object.style.color=='yellow')
	{
		reOrder='1';
		object.style.color='pink';
		return;
	}
	if(object.style.color=='pink')
	{
		reOrder='2';
		object.style.color='yellow';
		return;
	}
	reOrder='1';
	for(i=0;i<document.anchors.length;i++)
	{
		document.anchors(i).style.color='white';

	}
	object.style.color='pink';
}


function checkPeriodFromTo(from,to,format,locale)
{	
	var currDate = getCurrentDate(format,locale);
 	if(from.value !="")
	{
		if(!validDateObj(from,format,locale))
		{
      document.forms[0].from_date_time.value = '';
			document.forms[0].from_date_time.select();
			document.forms[0].from_date_time.focus();
			return false;
		}
		
		if(!isBeforeNow(from.value,"DMYHM",locale))
		{
			alert(getMessage("FROM_DATE_GREATER_SYSDATE","CA"));
			document.forms[0].from_date_time.value = '';
			document.forms[0].from_date_time.select();
			document.forms[0].from_date_time.focus();
			return false;
		}
		
	}

	if(to.value !="")
	{
		if(!validDateObj(to,format,locale))
		{
			document.forms[0].to_date_time.value = '';
			document.forms[0].to_date_time.select();
			document.forms[0].to_date_time.focus();
			return false;
		}
		if(!dateZeroCheck(to))
		{
			return false;
		}
		if(!isBeforeNow(to.value,"DMYHM",locale))
		{
			alert(getMessage("DATE_TIME_GREATER_SYSDATE","CA"));
			document.forms[0].to_date_time.value = '';
			document.forms[0].to_date_time.select();
			document.forms[0].to_date_time.focus();
			return false;
		}
		
	}

	if(from.value !="" && to.value !="" )
	{
		if(!isBetween(from.value,currDate,to.value,"DMYHM",locale))
		{	
			alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
			document.forms[0].to_date_time.value = '';
			document.forms[0].to_date_time.select();
			document.forms[0].to_date_time.focus();
			return false;
		}
	}
	return true;
}

function CheckDateNew(Object2,focusflag) {
	var datefield = Object2;
    if (ChkDateNew(Object2) == false) {
        if(focusflag == null)
        {
        	  datefield.value = '';
            datefield.select();
            datefield.focus();
        }
        return false;
    }
    else {
        return true;
    }
}
function showCalendarValidateForRecTime(str)
{
	var sys_date_time	= parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.sys_date_time;
	var flg = showCalendar(str,null,'hh:mm');
	
	if(!document.getElementById("CACalanderFun")){
		document.getElementById(str).value = '';
		document.getElementById(str).focus() ;
//		document.getElementById(str).focus();
	}

	return flg;
}
function changeactflg(obj)
{
document.forms[0].active_flg.value=obj.value
}

function showPersonalisePatSearchResults()
{
	
	var query_string		=	document.forms[0].query_string.value;
	var from_date_time	=	document.forms[0].from_date_time.value;
	var to_date_time		=	document.forms[0].to_date_time.value;
	var active_flg			=	document.forms[0].active_flg.value;	
	parent.PatCriteriaFr.location.href="../../eCommon/html/blank.html";
	query_string		+=	"&from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&active_flg="+active_flg;
	parent.PatCriteriaFr.location.href = "../../eCA/jsp/PersonalisePatListDetails.jsp?"+query_string;
}
function selectallpat()
{
var row_count=document.forms[0].rec_count.value;

if(parent.PatCriteriaFr.document.PatCriteriaFrm.select_all.checked==
	true){
		for(cnt=0;cnt<row_count; cnt++){
			val = eval("parent.PatCriteriaFr.document.PatCriteriaFrm.rta"+cnt);
			val.checked = true;
		}
	}else{
		for(cnt=0; cnt<row_count; cnt++){
			val = eval("parent.PatCriteriaFr.document.PatCriteriaFrm.rta"+cnt);
			val.checked = false;
		}
	}
}
function ChkDateNew(Object3) {
    var strDate;
    var strDay;
    var strMonth;
    var strYear;
    var datefield = Object3;
    var strDateArray = new Array();
	var strYearArray = new Array();

    strDate = datefield.value;
    if (strDate.length == 0) return true;

if(Object3.value.indexOf('.') > 0) return false;

    strDateArray = strDate.split("/");
    if (strDateArray.length != 3) {
        return false;
    }
    else {
        strDay = strDateArray[0];
        strMonth = strDateArray[1];
        strYearArray = strDateArray[2].split(" ");
		strYear = strYearArray[0];
    }

    if (strYear.length < 4 || strYear.length > 4) return false;

    if (isNaN(strDay)==true) return false;
    if (isNaN(strMonth)==true) return false;
    if (isNaN(strYear)==true) return false;

    if (strYear < 1800) return false;

        if (strMonth>12 || strMonth<1)  return false;

    if ((strMonth == 1 || strMonth == 3 || strMonth == 5 || strMonth == 7 || strMonth == 8 || strMonth == 10 || strMonth == 12) && (strDay > 31 || strDay < 1)) return false;

    if ((strMonth == 4 || strMonth == 6 || strMonth == 9 || strMonth == 11) && (strDay > 30 || strDay < 1)) return false;

    if (strMonth == 2) {
        if (strDay < 1) return false;

        if (LeapYear(strYear) == true) {
            if (strDay > 29) return false;
        }
        else {
            if (strDay > 28) return false;
        }
    }
    return true;
}

function dateZeroCheck(DateObj)
{

	var dateTime = DateObj.value;
	var dateArray =dateTime.split(" ");
	var date =dateArray[0].split("/");
	
	if(date[0]==0||date[1]==0||date[2]==0)
	{
		alert(getMessage("DAY_MON_YEAR_ZERO","CA"));
		DateObj.select();
		DateObj.focus();
		return false;
	}
	return true;


}
function removePatList()
{
	var test1=false;
	var patient_list="";
	var row_count=parent.PatCriteriaFr.document.PatCriteriaFrm.rec_count.value;
	for(cnt=0; cnt<row_count; cnt++){
		val = eval("parent.PatCriteriaFr.document.PatCriteriaFrm.rta"+cnt);
			if(val.checked==true){
				 test1= true;
				 tempval=eval("parent.PatCriteriaFr.document.PatCriteriaFrm.rtp"+cnt+".value");
				 tempval="'"+tempval+"'";
				 if(patient_list=="")
				 patient_list=tempval;
				 else
				 patient_list=tempval+","+patient_list;
				 
			}
	}
	if(test1==false)
		alert(getMessage("SELECT_ATLEAST_ONE","CA"));
	
	if(test1==true){

				parent.PatCriteriaFr.document.PatCriteriaFrm.delPatList.value=patient_list;
				parent.PatCriteriaFr.document.PatCriteriaFrm.mode.value='delete'
				parent.PatCriteriaFr.document.PatCriteriaFrm.action='../../servlet/eCA.PersonalisePatListServlet';
				parent.PatCriteriaFr.document.PatCriteriaFrm.target='messageFrame';
				parent.PatCriteriaFr.document.PatCriteriaFrm.method='post';
				parent.PatCriteriaFr.document.PatCriteriaFrm.submit();
	}
}
function resetPatList()
{
	parent.PatSearchCriteriaFr.location.reload();
}
function showCalendarValidate(str){
	var flg = showCalendar(str,null,'hh:mm');
	document.getElementById(str).value = '';
	document.getElementById(str).focus() ;
	// document.getElementById(str).focus();
	return flg;
}
