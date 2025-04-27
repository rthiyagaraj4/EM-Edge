/**
 *	FileName	: FaciltyDept.js
 *	Version	    : 3	
 *	Modified On	: 19-2-2005
**/
 
 function create() 
 {
	f_query_add_mod.location.href = "../../eAM/jsp/addmodifyFacilityDeptMain.jsp?facilityId="+facId ;
 }

function query() 
{
	f_query_add_mod.location.href ="../../eAM/jsp/FacilityDeptQueryCriteria.jsp" ;
}

function searchValues()
{
	parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?';

	var fields=new Array();
		fields[0]= parent.frames[0].document.Facility_dept.facility

	var names = new Array ( getLabel("Common.facility.label","Common")	);

	var search_by=document.forms[0].search_by.value;
	var search_txt=document.forms[0].search_txt.value;
	if(search_txt.indexOf("'")!=-1)
		        {			
			      search_txt = search_txt.replace("'","''");
		        }
		

	if(parent.parent.frames[1].frames[0].checkFieldsofMst( fields, names, parent.parent.frames[2]))
	{
		parent.frames[1].location.href='../../eAM/jsp/addmodifyFacilityDeptResult.jsp?facility='+parent.frames[0].document.Facility_dept.facility.value+'&fromSelect=fromSelect&search_by='+search_by+'&search_txt='+encodeURIComponent(search_txt);
	}
	temp='';
}
function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }
function apply()
{
	// var msg=parent.frames[1].frames[1].frames[1].getMessage('NO_CHANGE_TO_SAVE','Common');
if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	var msg=getMessage('NO_CHANGE_TO_SAVE','Common');
	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 

	if(parent.frames[2].frames[1].frames[1].document.forms[0].totalvalues.value.length ==0)
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=1'
	else
	{
		//f_query_add_mod.document.frames[1].document.forms[0].action='../../servlet/eAM.ServiceinfacilityServlet'
		parent.frames[2].frames[1].frames[1].document.forms[0].action="../../servlet/eAM.FacilityDeptServlet";
		parent.frames[2].frames[1].frames[1].document.forms[0].target="messageFrame";
		parent.frames[2].frames[1].frames[1].document.forms[0].submit();
	}

}
var facId='';

function onSuccess() 
{
facId=parent.frames[2].document.f_query_add_mod.document.queryFrame.document.forms[0].facility.value;
create();
}


function reset() 
{
	if(parent.frames[2].document.f_query_add_mod.document.forms[0])
	parent.frames[2].document.f_query_add_mod.document.location.reload();
	else if(parent.frames[2].document.f_query_add_mod)
		parent.frames[2].document.f_query_add_mod.location.reload();
}

var temp='';
function changeValue(Obj,Obj1,Obj3)
{
var arr = new Array();
arr = Obj.value.split("$");
	if(Obj1.checked)
	{
		arr[1]="E";
	}
	else
		arr[1]="D";
	
	Obj.value=arr[0]+"$"+arr[1]+"$"+arr[2]+"$"+Obj1.name+"~"
	temp+=Obj.value;
	Obj3.value =temp;
}


