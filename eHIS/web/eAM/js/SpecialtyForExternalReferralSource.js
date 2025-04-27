function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/SpecialtyForExternalReferralSourceMain.jsp?facilityId="+facId ;
}
function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/SpecialtyForExternalReferralSourceQueryCriteria.jsp" ;
}
function searchValues()
{
	//document.forms[0].facility.disabled=FALSE;
	parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?';

	var fields=new Array();
		fields[0]= parent.frames[0].document.Facility_dept.facility

	var names = new Array ( getLabel("eAM.ExternalReferralSource.label","am")

				);
	if(parent.parent.frames[1].frames[0].checkFieldsofMst( fields, names, parent.parent.frames[2]))
	{
		
	var facility = parent.frames[0].document.Facility_dept.facility.value;

	var search_by=document.forms[0].search_by.value;
	var search_txt=document.forms[0].search_txt.value;
    if(search_txt.indexOf("'")!=-1)
		        {			
			      search_txt = search_txt.replace("'","''");
		        }

	parent.frames[1].location.href = "../../eAM/jsp/SpecialtyForExternalReferralSourceDetail.jsp?facility="+facility+"&fromSelect=fromSelect&search_by="+search_by+"&search_txt="+encodeURIComponent(search_txt);
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
	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	if(parent.frames[2].frames[1].frames[1].document.forms[0])
	{
		parent.frames[2].frames[1].frames[1].document.forms[0].action="../../servlet/eAM.SpecialtyForExternalReferralSourceServlet";
		parent.frames[2].frames[1].frames[1].document.forms[0].target="messageFrame";
		parent.frames[2].frames[1].frames[1].document.forms[0].submit();
	}
	else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
	}
}
var facId='';
function onSuccess() 
{
	//facId=parent.frames[1].document.frames[1].document.frames[0].document.forms[0].facility.value;
	facId=parent.frames[2].document.frames[1].document.frames[0].document.forms[0].facility.value;
	create();
}


	
function reset() 
{
if(parent.frames[1].frames[1])
{
	if(f_query_add_mod.document.forms[0])
	{
	if(f_query_add_mod.document.forms[0].name=="query_form")
	{
			f_query_add_mod.document.location.reload();

	}else
	{

	}
	}else 
	{
	f_query_add_mod.document.location.reload();
	}
}

}

function assignVal5(val)
	{
		parent.frames[1].location.href ='../../eCommon/html/blank.html'		
	}



	
var temp;
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
