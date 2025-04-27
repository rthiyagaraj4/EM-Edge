/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
20/10/2016	Created 		Raja S											MO-CRF-20108[IN058912]
------------------------------------------------------------------------------------------------------------------------------
*/

function showPreviousNotesSearchResults()
{
	
	var query_string		=	document.forms[0].query_string.value;
	var from_date_time	=	document.forms[0].from_date_time.value;
	var to_date_time		=	document.forms[0].to_date_time.value;	
	var ref_no=document.forms[0].ref_no.value;
	parent.ViewMotherLinkedNotesSelsectedResultDtlFrame.location.href="../../eCommon/html/blank.html";
	query_string		+=	"&from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&ref_no="+ref_no;
	parent.ViewMotherLinkedNotesSrchResultsFrame.location.href = "../../eCA/jsp/ViewMotherLinkedNotesSrchResults.jsp?"+query_string;
	parent.ViewMotherLinkedNotesToolbarFrame.ViewMotherLinkedNotesToolbarForm.ok.disabled=true; //IN062560
}

function showPreviousNotesView(accession_num,facility_id,row_id){
    var totalRows = document.getElementById("tablePreRec").getElementsByTagName('tr');
	parent.ViewMotherLinkedNotesToolbarFrame.ViewMotherLinkedNotesToolbarForm.ok.disabled=false; 
    for(var i=1; i<totalRows.length;i++){
    	if(row_id==i){
			var totalCells=totalRows[i].cells;
			for(var j=0;j<totalCells.length;j++){
				totalCells[j].className="gridDataSelect";
			}
		}else{
			var totalCells=totalRows[i].cells;
			for(var j=0;j<totalCells.length;j++){
				totalCells[j].className="gridData";
			}
		}
    }
	 
	parent.ViewMotherLinkedNotesSelsectedResultDtlFrame.location.href = "../../eCA/jsp/ViewMotherLinkedNotesSearchDetails.jsp?accession_num="+accession_num+"&facility_id="+facility_id;
	parent.ViewMotherLinkedNotesToolbarFrame.ViewMotherLinkedNotesToolbarForm.accession_num.value=accession_num;
}
function movePreviousNotes(){
	parent.window.returnValue = document.ViewMotherLinkedNotesToolbarForm.accession_num.value;
	parent.window.close();
}

function showCalendarValidate(str){
	var flg = showCalendar(str,null,'hh:mm');
	document.getElementById(str).focus();
	return flg;
}

function checkPeriodFromTo(from,to,format,locale)
{	
	var currDate = getCurrentDate(format,locale);
 	if(from.value !="")
	{
		if(!validDateObj(from,format,locale))
		{
			document.forms[0].from_date_time.select();
			document.forms[0].from_date_time.focus();
			return false;
		}
		
		if(!isBeforeNow(from.value,"DMYHM",locale))
		{
			alert(getMessage("FROM_DATE_GREATER_SYSDATE","CA"));
			document.forms[0].from_date_time.select();
			document.forms[0].from_date_time.focus();
			return false;
		}
		
	}

	if(to.value !="")
	{
		if(!validDateObj(to,format,locale))
		{
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
			alert(getMessage("TO_DATE_GREATER_SYSDATE","CA")); //IN062560
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
            datefield.select();
            datefield.focus();
        }
        return false;
    }
    else {
        return true;
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
