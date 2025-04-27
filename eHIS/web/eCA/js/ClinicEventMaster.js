function scrollTitle()
{
	  var scrollXY = document.body.scrollTop;
	  if(scrollXY == 0)
	  {
					document.getElementById("divDataTitle").style.position = 'static';
					document.getElementById("divDataTitle").style.posTop  = 0;
	  }
	  else
	  {
				document.getElementById("divDataTitle").style.position = 'relative';
				document.getElementById("divDataTitle").style.posTop  = scrollXY;
	 }
}

function apply() 
{

if(f_query_add_mod.document.clinic_event_param_form != null)
	{
if(f_query_add_mod.document.clinic_event_param_form.name == "clinic_event_param_form") 
			{
			f_query_add_mod.document.clinic_event_param_form.submit() ;
			}
//			clinicEventMasterFrame.document.clinicEventMasterSearchForm.search_text.value='';
	}
else
	{
	messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
	return false;
	}
}


function reset() {
if(f_query_add_mod.document.clinic_event_param_form != null)
	{

		if(f_query_add_mod.document.clinic_event_param_form.name == "clinic_event_param_form") 
			{
			clinicEventMasterFrame.document.clinicEventMasterSearchForm.reset() ;
			f_query_add_mod.location.href = '../../eCommon/html/blank.html' ;
			}
	}
else
	{
	messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
	return false;
	}
}
function onSuccess()
{

	nextprev=f_query_add_mod.document.forms[0].nextpervin.value
	
	if(nextprev=="prv"||nextprev=="nxt")
	{
		start=f_query_add_mod.document.forms[0].from.value
		end=f_query_add_mod.document.forms[0].to.value

	if(nextprev=="prv")
	{
		start=eval(start)-14;
		end=eval(end)-14;
	}else
	{
	start=eval(start)+14
	end=eval(end)+14
	}

/*if (clinicEventMasterFrame.document.forms[0].search_by(0).checked)
	{
		search_by=clinicEventMasterFrame.document.forms[0].search_by(0).value;
	}
	else
	{
	search_by=clinicEventMasterFrame.document.forms[0].search_by(1).value;
	}*/
search_by=f_query_add_mod.document.forms[0].search_by.value
search_criteria=f_query_add_mod.document.forms[0].search_criteria.value
search_text=f_query_add_mod.document.forms[0].search_text.value
hist_type=f_query_add_mod.document.forms[0].hist_rec_type.value
row_count=f_query_add_mod.document.forms[0].row_count.value
f_query_add_mod.location.href="../../eCA/jsp/ClinicEventMasterUpdate.jsp?from="+(start)+"&to="+(end)+"&search_by="+search_by+"&search_criteria="+search_criteria+"&hist_type="+hist_type+"&row_count="+row_count+"&search_text="+escape(search_text);
	//f_query_add_mod.location.reload();
	}else
	{
	f_query_add_mod.location.reload();
	}
}

function loadFrames()
{
	var hist_type = parent.clinicEventMasterFrame.document.clinicEventMasterSearchForm.hist_rec_type.value;

	if (parent.clinicEventMasterFrame.document.forms[0].search_by[0].checked)
		{
			var	search_by=document.forms[0].search_by[0].value;
			}
		else
			{
			var search_by=document.forms[0].search_by[1].value;
			
			}
	
	var search_text= parent.clinicEventMasterFrame.document.clinicEventMasterSearchForm.search_text.value;
	var search_criteria= parent.clinicEventMasterFrame.document.clinicEventMasterSearchForm.search_criteria.value;
		
	fields = new Array(parent.clinicEventMasterFrame.document.clinicEventMasterSearchForm.hist_rec_type,parent.clinicEventMasterFrame.document.clinicEventMasterSearchForm.search_text);
	names = new Array(getLabel("eCA.HistoryRecordType.label",'CA'),getLabel("Common.searchtext.label",'common'));
	
	if(checkFieldsofMst( fields, names, parent.messageFrame))
	{
		parent.f_query_add_mod.location.href = "../../eCA/jsp/ClinicEventMasterUpdate.jsp?hist_type="+hist_type+"&search_by="+search_by+"&search_text="+escape(search_text)+"&search_criteria="+search_criteria+"&opmode=First";
		parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	}
}
function load()
{
parent.f_query_add_mod.location.href = '../../eCommon/html/blank.html' ;
parent.clinicEventMasterFrame.document.clinicEventMasterSearchForm.search_text.value='';
}

function selectAllPract(obj)
{
	var totCount = document.clinic_event_param_form.count.value;
	var ordPractSel;
	var attPractSel;

	if(obj.name == 'orderingPractSelAll')
	{
		if(obj.checked == true)
		{
			for(var i=0;i<parseInt(totCount,10);i++)
			{
				ordPractSel = eval("document.clinic_event_param_form.Ord_phys_yn"+i);
				ordPractSel.checked = true;
				chkunchk(ordPractSel);
			}
		}
		else if(obj.checked == false)
		{
			for(var i=0;i<parseInt(totCount,10);i++)
			{
				ordPractSel = eval("document.clinic_event_param_form.Ord_phys_yn"+i);
				ordPractSel.checked = false;
				chkunchk(ordPractSel);
			}
		}
	}
	else if(obj.name == 'attendingPractSelAll')
	{
		if(obj.checked == true)
		{
			for(var i=0;i<parseInt(totCount,10);i++)
			{
				attPractSel = eval("document.clinic_event_param_form.Atn_phys_yn"+i);
				attPractSel.checked = true;
				chkunchk(attPractSel);
			}
		}
		else if(obj.checked == false)
		{
			for(var i=0;i<parseInt(totCount,10);i++)
			{
				attPractSel = eval("document.clinic_event_param_form.Atn_phys_yn"+i);
				attPractSel.checked = false;
				chkunchk(attPractSel);
			}
		}
	}
}

function chkUnchkSelAll()
{
	var totCount = document.clinic_event_param_form.count.value;
	var numOfOrdChkdBoxes = document.clinic_event_param_form.numOfOrdChkdBoxes.value;
	var numOfAttChkdBoxes = document.clinic_event_param_form.numOfAttChkdBoxes.value;

	if(numOfOrdChkdBoxes == totCount)
		document.clinic_event_param_form.orderingPractSelAll.checked = true;
	else
		document.clinic_event_param_form.orderingPractSelAll.checked = false;	
	if(numOfAttChkdBoxes == totCount)
		document.clinic_event_param_form.attendingPractSelAll.checked = true;
	else
		document.clinic_event_param_form.attendingPractSelAll.checked = false;
}
