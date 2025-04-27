var function_id;
var var_Month;
var end_date;
var c;

/********************************************************/
function reset(){
	if(f_query_view.document.forms[0]){
		f_query_view.document.forms[0].reset();
	}
}

/***********************************************************/

function workplaceLookup(target)
{
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var frmObj=document.form_StaffOnCall;
	frmObj.workplace_desc.value="";
	frmObj.workplace_code.value="";
	var workplace = frmObj.workplace_desc.value;
	var login_facility_id = frmObj.login_facility_id.value;
	
	if(workplace !=''){
		frmObj.workplace_desc.value='';
		
	}
	argumentArray[0] ="select workplace_code code,workplace_desc description from rs_workplace where('"+login_facility_id+"' is null or facility_id='"+login_facility_id+"' ) and eff_status='E' and upper(workplace_code) like(upper(?))  and upper(workplace_desc) like(upper(?)) order by workplace_desc";
	argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2"; 
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_DESC_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal = CommonLookup(getLabel("eRS.FindWorkplace.label","RS"),argumentArray);
	if(retVal != null && retVal != "" )
	{
	target.value = retVal[1];
	frmObj.workplace_code.value = retVal[0];
	}else
			target.value ="";
	
}

/********************************************************/
function showCal(obj, obj_id){
	showCalendar(obj_id);
	obj.focus();
}
/***************************************************************/

function Searchstaff()
{ 
	var frmobj = document.form_StaffOnCall;
	var mode = frmobj.p_mode.value;


	if(mode == 'CA')
		var messageFrame = parent.parent.frames[3]; 
	else
		var messageFrame = parent.frames[3]; 

	var workplace_code = frmobj.workplace_code.value;
	var locale=frmobj.locale.value;
	var date = convertDate(frmobj.date.value,'DMY',locale,"en");
	var login_facility_id = frmobj.login_facility_id.value;
	var error_jsp = "../../eCommon/jsp/MstCodeError.jsp";
	var field = new Array (frmobj.workplace_code,frmobj.date);
	var name = new Array (getLabel("eRS.Workplace.label","RS"),getLabel("Common.date.label","Common"));
	
	if(checkFields( field, name, messageFrame))
	{
		
		parent.frames[2].location.href="../../eRS/jsp/StaffOnCallResult.jsp?workplace_code="+workplace_code+"&date="+date+"&login_facility_id="+login_facility_id;
	}
}

/*************************************************************************/

/*function Callfunction()
{
	var frmobj= document.form_StaffOnCall;
	var mode = frmobj.p_mode.value;
	if(mode=='CA')
    {
      parent.fs.rows='0,50,*,48';
    }
}*/

