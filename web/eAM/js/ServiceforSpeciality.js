/*Created by Ashwini on 06-May-2024 for ML-MMOH-CRF-2125*/
var serviceList = new Array();

function create() { 
	f_query_add_mod.location.href = "../../eAM/jsp/ServiceforSpecialityCreate.jsp?facilityId="+facId ;
}

function query() {
	frames[1].location.href ="../../eAM/jsp/ServiceforSpecialityQuery.jsp" ;
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

	if(f_query_add_mod.document.frames[1].document.forms[0])
	{

		if(f_query_add_mod.document.frames[1].document.forms[0].finalserviceList.value == '')
		{
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=1'
		}else
		{
			parent.frames[2].document.frames[1].document.frames[1].document.forms[0].action="../../servlet/eAM.ServiceforSpecialityServlet";
			parent.frames[2].document.frames[1].document.frames[1].document.forms[0].target="messageFrame";
			parent.frames[2].document.frames[1].document.frames[1].document.forms[0].submit();
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
	facId=parent.frames[2].document.frames[1].document.frames[0].document.forms[0].facility_id.value;
	create();
}

function reset()
{
	if(f_query_add_mod.document.forms[0])
	{
		f_query_add_mod.document.location.reload();
		f_query_add_mod.FocusFirstElement();
	}
	else
	{
		f_query_add_mod.frames[0].document.location.reload();
		f_query_add_mod.frames[1].location.href = "../../eCommon/html/blank.html";
	}
}

var totElements;
var totservices=new Array();
var totChk=new Array();
var u=0;
	
function chkserviceList()
{
	var fields = new Array ( parent.frames[0].document.forms[0].facility_id,
							 parent.frames[0].document.forms[0].splty_code
						   );
	var names = new Array (
							getLabel("Common.facility.label","Common"),
							getLabel("Common.speciality.label","Common")
					      );

	if(parent.frames[0].checkFieldsofMst(fields, names, parent.parent.frames[2])) {
		return true;
	}else{
		return false;
	}
}

function populateValues()
{
	if(parent.frames[2].document.forms[0])
	{
		totElements=parent.frames[2].document.forms[0].totCount.value;
		
		for(v=0;v<totElements;v++)
		{
			if(eval('parent.frames[2].document.forms[0].chk'+v).value == totChk[v]){
				eval('parent.frames[2].document.forms[0].chk'+v).checked
			}

		}
	}
}

function changeEnable(Obj,Obj1,str3) {

	var arr = new Array();
	arr = Obj1.value.split("$");

	if(Obj.checked) {
		arr[1]="Y";
	} else {
		arr[1]="N";
	}
		
	Obj1.value=arr[0]+"$"+arr[1]+"$"+arr[2]+"$"+Obj.name;
	serviceList+=Obj1.value+"~";

	parent.frames[1].document.forms[0].finalserviceList.value=serviceList;

	var ServiceCode = Obj.value;
	var servList = parent.frames[1].document.forms[0].checkedserviceList.value;
	var checkedserviceList = new Array();
	checkedserviceList = servList.split(',');
	var removedServiceCode = new Array();
	var unLinkserviceList = parent.frames[1].document.forms[0].unLinkserviceList.value;
	
	if(unLinkserviceList!=null && unLinkserviceList!="null" && unLinkserviceList!=""){
		removedServiceCode.push(unLinkserviceList);	
	}
	
	for(var i=0;i<checkedserviceList.length;i++){
		if(Obj.checked){
			var index = -1;
			for(var j=0;j<removedServiceCode.length;j++){
				if(removedServiceCode[i]==ServiceCode){
					index=j;
				}
			}
			if (index !== -1) {
				removedServiceCode.splice(index, 1);
			}
			break;
		}else{
			if(checkedserviceList[i]==ServiceCode){
				removedServiceCode.push(ServiceCode);
				break;
			}
		}
	}

	parent.frames[1].document.forms[0].unLinkserviceList.value=removedServiceCode;
}
	
function refreshFinalValues()
{
	serviceList='';
}
