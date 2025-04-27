 var practList= new Array();
 function create() { 
f_query_add_mod.location.href = "../../eAM/jsp/md_addModifyOPSPractitionerQueryMain.jsp?facilityId="+facId ;
}

function query() {
	frames[1].location.href ="../../eAM/jsp/queryOPSPractitionerPage.jsp" ;
}

function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
	if ( (url.indexOf("blank.html")==-1) )
        return true;
    else
        return false;
  }
function apply()
{
	if (! (checkIsValidForProceed()) )
    {
	messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
    return false;
    } 


var msg=getMessage('NO_CHANGE_TO_SAVE','Common');	
if(f_query_add_mod.document.f_query_add_mod_res.document.forms[0])
{

if(f_query_add_mod.document.f_query_add_mod_res.document.forms[0].finalPractList.value == '')
	messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=1'
	else
	{
	parent.frames[2].document.f_query_add_mod.document.f_query_add_mod_res.document.forms[0].action="../../servlet/eAM.OPSPServlet";
	parent.frames[2].document.f_query_add_mod.document.f_query_add_mod_res.document.forms[0].target="messageFrame";
	parent.frames[2].document.f_query_add_mod.document.f_query_add_mod_res.document.forms[0].submit();
	}
	}
	else
	{
		var msg=parent.frames[0].getMessage("AM0100","AM");
	    messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=1'
        return false;
	}
}

var facId='';
function onSuccess()
{

	//facId=parent.frames[1].document.frames[1].document.frames[0].document.forms[0].facility_id.value;
	facId=parent.frames[2].document.f_query_add_mod.document.f_query_add_mod_query.document.forms[0].facility_id.value;
	create();

}

function reset()
{
/*	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } */

	if(f_query_add_mod.document.forms[0])
	{
		//f_query_add_mod.document.forms[0].reset();
		f_query_add_mod.document.location.reload();
		f_query_add_mod.FocusFirstElement();
	}
	else
	{
		//f_query_add_mod.frames[0].document.forms[0].reset();
		f_query_add_mod.frames[0].document.location.reload();
		f_query_add_mod.frames[1].location.href = "../../eCommon/html/blank.html";
	}
}

var totElements;
var totPracts=new Array();
var totChk=new Array();
var u=0;
	
function chkPractitionerList()
{
	
	var fields = new Array ( 	parent.frames[0].document.forms[0].facility_id,
						parent.frames[0].document.forms[0].splty_code
						    );
		var names = new Array (
							getLabel("Common.facility.label","Common")
,getLabel("Common.speciality.label","Common")

					      );
		if(parent.frames[0].checkFieldsofMst( fields, names, parent.parent.frames[2])) {
			return true;
		}
		else
		return false
}

function populateValues()
{
	if(parent.frames[2].document.forms[0])
	{
		totElements=parent.frames[2].document.forms[0].totCount.value;
		for(v=0;v<totElements;v++)
		{
			if(eval('parent.frames[2].document.forms[0].chk'+v).value == totChk[v])
				eval('parent.frames[2].document.forms[0].chk'+v).checked

		}
	}
}


	function changeEnable(Obj,Obj1,totApptCount,str3)
	{
			if(totApptCount > 0 && str3 =='Y')
			{
			alert(parent.frames[1].getMessage('FUTURE_APPT_EXISTS','AM'));
			Obj.checked=true;
			}
		else
		{
		var arr = new Array();
		arr = Obj1.value.split("$");
			if(Obj.checked)
			{
				arr[1]="Y";
			}
			else
				arr[1]="N";
			
			Obj1.value=arr[0]+"$"+arr[1]+"$"+arr[2]+"$"+Obj.name;
			practList+=Obj1.value+"~";
			parent.frames[1].document.forms[0].finalPractList.value=practList;
		}
			
	}
	function refreshFinalValues()
	{
	practList='';
	}
