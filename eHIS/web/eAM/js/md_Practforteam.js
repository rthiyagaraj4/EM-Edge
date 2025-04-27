 function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/md_addModifyPractForTeamMain.jsp" ;
}

function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/PractForTeamQueryCriteria.jsp" ;
}
var isLoadPage=true;
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
	var msg=f_query_add_mod.getMessage('NO_CHANGE_TO_SAVE','Common');
	if(f_query_add_mod.document.f_query_add_mod_res.document.pract_for_team_result.finalSelect.value == '' && !flag)
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=1'
	else if(f_query_add_mod.document.f_query_add_mod_res.document.pract_for_team_result.finalSelect.value == '' && flag){
		
		msg = f_query_add_mod.getMessage("ONE_CHIEF_PER_TEAM","AM");
		alert(msg);
		isLoadPage=false;
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=1";
	}else
	{
		f_query_add_mod.document.f_query_add_mod_res.document.pract_for_team_result.action='../../servlet/eAM.md_PractitionersForTeamServlet'
		f_query_add_mod.document.f_query_add_mod_res.document.pract_for_team_result.method='post';
		f_query_add_mod.document.f_query_add_mod_res.document.pract_for_team_result.target='messageFrame';
		f_query_add_mod.document.f_query_add_mod_res.document.pract_for_team_result.submit();
	}	
}


var facId='';
function onSuccess() {    
	if(isLoadPage)
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
	if(f_query_add_mod.document.pract_for_team_result || f_query_add_mod.document.f_query_add_mod_query)
		f_query_add_mod.location.reload();

}	
			

function deleterecord()
{
	if(f_query_add_mod.document.practforteam_form.function_name.value!="insert")
	{   	   	 
		f_query_add_mod.document.practforteam_form.function_name.value="delete";		
		f_query_add_mod.document.practforteam_form.submit();	

	}
	else
	{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=APP-SM0052 Record cannot be deleted in Create Mode"
	}
	
}

function chkPractitionerList()
{
	var fields = new Array ( parent.f_query_add_mod_query.document.facility_form_query.facility_id, 				
							 parent.f_query_add_mod_query.document.facility_form_query.team);
		var names = new Array (getLabel("Common.facility.label","Common")
								,getLabel("eAM.Team.label","AM")

							   );

		if(parent.f_query_add_mod_query.checkFieldsofMst( fields, names, parent.parent.frames[2])) {
			return true;
		}
		else
		return false
}


var rowId=new Array();
function populateRoleDtls(Obj)
{
		rowId+=Obj.name+"$"+Obj.value+"~"
	//	alert("rowId 1 :"+rowId);
}
var temp='';
function finalSelect(Obj,role,practitioner_id)
{

	if(Obj.checked)
	{
		
		if(role.value == 'S')
		{
			alert(parent.getMessage('ROLE_SELECT','AM'));
			Obj.checked=false;
			role.focus();
			
		}
		else
		{
			temp+=practitioner_id+"$"+role.value+"$I"+"$"+role.name+"$"+Obj.name+"~"
			parent.f_query_add_mod_res.document.pract_for_team_result.finalSelect.value=temp;
			flag=true;
			
		}
		//alert(parent.frames[1].document.forms[0].finalSelect.value);
	}
	else
	{
		role.value='S';
		
		temp+=practitioner_id+"$"+role.value+"$D"+"$"+role.name+"$"+Obj.name+"~"		
		//role.value='S';
		//alert("temp :"+temp);
		parent.f_query_add_mod_res.document.pract_for_team_result.finalSelect.value=temp;
		//alert(parent.frames[1].document.forms[0].finalSelect.value);
	}
}

var flag=false;	


function populateRole(Obj,Obj2,practitioner_id)
{

	var count=0;
	Obj2.checked=false;
	var maxRecord =parent.f_query_add_mod_res.document.pract_for_team_result.maxRecord.value;
	var arr =new Array();
	for(var u=0;u<maxRecord;u++)
	{
		if(eval("parent.f_query_add_mod_res.document.forms[0].role"+u))
		{
			if(eval("parent.f_query_add_mod_res.document.forms[0].role"+u).value == 'C')
			{
			arr[count]=eval("parent.f_query_add_mod_res.document.forms[0].role"+u).value;
			count++;
			}
		}
	}

	if(Obj2.checked)
	{
		if(Obj.value == 'S')
		{
			Obj2.checked=false;
			Obj.focus();
		}
		else
		{
			temp+=practitioner_id+"$"+Obj.value+"$I"+"$"+Obj.name+"$"+Obj2.name+"~"
			parent.f_query_add_mod_res.document.pract_for_team_result.finalSelect.value=temp;
		}
	}
	else
	{
		temp+=practitioner_id+"$"+Obj.value+"$D"+"$"+Obj.name+"$"+Obj2.name+"~"		
		parent.f_query_add_mod_res.document.pract_for_team_result.finalSelect.value=temp;

		//alert("finalselect :"+parent.frames[1].document.forms[0].finalSelect.value);
	}
	populateRoleDtls(Obj);
}


