var assignReassign = new Array();
var effStatus= new Array();
var selected= new Array();
function create() {
f_query_add_mod.location.href = "../../eAM/jsp/md_addmodifyOPPFForFacility.jsp?facility_id="+facId ;
}
function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/queryOppf.jsp" ;
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

function apply() {

if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 

var msg=getMessage("NO_CHANGE_TO_SAVE","Common");
	if(f_query_add_mod.document.f_query_add_mod_res.document.forms[0]){

if(f_query_add_mod.document.f_query_add_mod_res.document.forms[0].finalSelect.value == '')
	{
	messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=1'
	}
	else
	{
	f_query_add_mod.document.f_query_add_mod_res.document.forms[0].action='../../servlet/eAM.OPPFServlet'
	f_query_add_mod.document.f_query_add_mod_res.document.forms[0].method='post';
	f_query_add_mod.document.f_query_add_mod_res.document.forms[0].target='messageFrame';
	f_query_add_mod.document.f_query_add_mod_res.document.forms[0].submit();
	}
	}
	else
	{

		var msg=parent.f_query_add_mod_query.getMessage("AM0100","AM");
	    messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=1'
        return false;
	}
}


var facId='';
function onSuccess() {
facId= f_query_add_mod.document.f_query_add_mod_query.document.forms[0].facility.value;
create();
}

function reset() {
	/*if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } */
	if(f_query_add_mod.document.forms[0] || f_query_add_mod.document.f_query_add_mod_query)
				f_query_add_mod.document.location.reload();

}

function chkPractitionerList()
{
	var fields = new Array ( 	parent.frames[0].document.forms[0].facility,
						parent.frames[0].document.forms[0].primary_specialty
						    );
		var names = new Array (
							getLabel("Common.facility.label","Common")
							,getLabel("Common.primaryspeciality.label","Common")
						      );
		if(parent.frames[0].checkFieldsofMst( fields, names, parent.parent.frames[2])) {
			return true;
		}
		else
		return false
}


function chkassignReAssign(Obj,Obj1)
{
	Obj1.disabled=false;
	var arr=new Array();
	if(Obj.checked)
	{
	arr=Obj.value.split("$");
	Obj.value=arr[0]+"$"+"Y"+"$"+arr[2];
	assignReassign+=Obj.value+"~";
	
	}
	else
	{
	arr=Obj.value.split("$");
	Obj.value=arr[0]+"$"+"N"+"$"+arr[2];
	assignReassign+=Obj.value+"~";
	}
	//Obj.value=assignReassign;
	parent.frames[1].document.forms[0].totAssignreassign.value=assignReassign;
}
function chkEnable(Obj,Obj1)
{
		Obj1.disabled=false;
		var arr=new Array();
		if(Obj.checked)
		{
		arr=Obj.value.split("$");
		Obj.value=arr[0]+"$"+"E"+"$"+arr[2];
		effStatus+=Obj.value+"~";

		}
		else
		{
			arr=Obj.value.split("$");
			var practid = arr[0].substring(2,arr[0].length-1);
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH PractID=\""+practid+"\" /></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","ValidatePract.jsp",false)

			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			eval(responseText);

			if (parent.frames[1].document.forms[0].pract_id_exists.value=='N')
			{
				Obj.value=arr[0]+"$"+"D"+"$"+arr[2];
				effStatus+=Obj.value+"~";
			}
			else
				Obj.checked=true;
		}
		if (parent.frames[1].document.forms[0].pract_id_exists.value=='N')
		{
			parent.frames[1].document.forms[0].effStatus.value=effStatus;
		}
}
var temp='';
function finalSelect(Obj1,Obj2,Obj3)
{
	var sel=new Array();
	
	if(Obj1.checked)
	{
	 
	temp+=Obj2.value+Obj3.value+"`"
	//alert("temp :"+temp);
	
	parent.frames[1].document.forms[0].finalSelect.value=temp;
	

    //alert("obj :"+Obj1.value);

	
	
	sel=Obj1.value.split("$");
	Obj1.value=sel[0]+"$"+"Y"+"$"+sel[2]+"$"+sel[3];
	selected+=Obj1.value+"~";
	
	}
	else
	{
		
	sel=Obj1.value.split("$");
	Obj1.value=sel[0]+"$"+"N"+"$"+sel[2]+"$"+sel[3];
	selected+=Obj1.value+"~";
	}
		
	parent.frames[1].document.forms[0].totselected.value=selected; 
	//alert("totselected :"+parent.frames[1].document.forms[0].totselected.value);

}
