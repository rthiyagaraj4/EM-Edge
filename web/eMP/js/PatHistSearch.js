function show() {
	parent.parent.window.document.title = getLabel('Common.PatientHistory.label','common')+" " + getLabel('Common.search.label','common') ;
}
function query() {
	f_query_criteria.location.href ="../../eMP/jsp/PatientHistQuery.jsp";
	f_query_patient.location.href="../../eCommon/html/blank.html";
	f_query_result.location.href="../../eCommon/html/blank.html";
}
function reset() {
	if(f_query_criteria.document.forms[0].name == "PatientHistorySearchForm") 
		f_query_criteria.document.PatientHistorySearchForm.reset() ;
	else 
		f_query_criteria.document.query_form.reset() ;
}

//From PatientHistQuery.jsp
function focusField()
{
	document.PatientHistorySearchForm.Patient_ID.focus();
}
function clear_frame()
{
	document.PatientHistorySearchForm.Patient_ID.value='';
	document.PatientHistorySearchForm.History_Type.value=0
	parent.frames[2].location.href="../../eCommon/html/blank.html";
	parent.frames[3].location.href="../../eCommon/html/blank.html";
}
async function PatSearch()
{
	var patientid=await PatientSearch('','','','','','','','','','VIEW');
	document.PatientHistorySearchForm.Patient_ID.value = unescape(patientid);
	if( document.PatientHistorySearchForm.Patient_ID.value == 'undefined')
	document.PatientHistorySearchForm.Patient_ID.value = '';
	document.PatientHistorySearchForm.Patient_ID.focus();
}
function search()
{
	var patient_id=document.PatientHistorySearchForm.Patient_ID;

	if(trimCheck(patient_id.value)=="")
	{
		var msg = getMessage('CAN_NOT_BE_BLANK','Common');
		msg=msg.replace('$',getLabel('Common.patientId.label','common'));
		patient_id.focus();
		parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_num=' + msg;
		return false;
	}
	else
	{
		var pat_id = document.PatientHistorySearchForm.Patient_ID.value;
		var hist_type = document.PatientHistorySearchForm.History_Type.value;
		parent.frames[3].location.href  ="../../eMP/jsp/PatientHistResult.jsp?pat_id="+ escape(pat_id)+"&hist_type="+hist_type;
		parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_num=';
	}
}
function changeCase(Obj)
{
	Obj.value =Obj.value.toUpperCase();
}
//From PatientHistResult.jsp
function hideToolTip()
{
	document.getElementById("tooltiplayer").style.visibility='hidden'
}

function buildTable(val,val1)
{
	var rowval = val.split (",");
	var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'   class='BOX' width='100%' height='100%' align='center'>"
		tab_dat += "<tr>"
		tab_dat += "<td class='label' > "+val1+" </td>"
		tab_dat += "</tr> "


	for( var i=0; i<rowval.length; i++ )
	{
		var colval = rowval[i]
		tab_dat += "<tr>"
		tab_dat += "<td class = 'ORPANEL' >"+colval+"</td>"
		tab_dat += "</tr> "
	}
	tab_dat += "</table> "
	document.getElementById("t").innerHTML = tab_dat
}			

function displayToolTip(val,val1)
{
	
	buildTable (val,val1)
	bodwidth = parent.frames[3].document.body.offsetWidth
	bodheight =parent.frames[3].document.body.offsetHeight

	var x = event.x
	var y = event.y;

	x = x + (document.getElementById("tooltiplayer").offsetWidth)
	y = y + (document.getElementById("tooltiplayer").offsetHeight)

	if(x<bodwidth)
		x =event.x 
	else
		x = x - (document.getElementById("tooltiplayer").offsetWidth*2)

	if(y<bodheight)
		 y =event.y
	else
		y = y - (document.getElementById("tooltiplayer").offsetHeight*2)

		y+=document.body.scrollTop
		x+=document.body.scrollLeft

		document.getElementById("tooltiplayer").style.posLeft= x
		document.getElementById("tooltiplayer").style.posTop = y
document.getElementById("tooltiplayer").style.visibility='visible' 
}
