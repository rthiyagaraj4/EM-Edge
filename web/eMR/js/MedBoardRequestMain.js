function assign_user(obj)
{
	
	parent.MedBoardRequestFormationMain.document.forms[0].role.options[0].selected=true;
	parent.MedBoardRequestFormationMain.document.forms[0].practid.value="";
	parent.MedBoardRequestFormationMain.document.forms[0].practid_desc.value="";

	if(obj.value =='E')
	{
		parent.MedBoardRequestFormationMain.document.forms[0].user.value='P';
		parent.MedBoardRequestFormationMain.document.forms[0].user.disabled=true;
	}				
	else if(obj.value =='I')
	{
		parent.MedBoardRequestFormationMain.document.forms[0].user.disabled=false;
	}
}


function clear_values()
{
	parent.MedBoardRequestFormationMain.document.forms[0].role.options[0].selected=true;
	parent.MedBoardRequestFormationMain.document.forms[0].practid.value="";
	parent.MedBoardRequestFormationMain.document.forms[0].practid_desc.value="";
}


function addRequest()
{
	var pract_id		= parent.MedBoardRequestFormationMain.document.forms[0].practid.value;
	var practid_desc	= parent.MedBoardRequestFormationMain.document.forms[0].practid_desc.value;
	var medical_board	= parent.MedBoardRequestFormationMain.document.forms[0].medical_board.value;
	var appt_date		= parent.MedBoardRequestFormationMain.document.forms[0].appt_date.value;
	if(appt_date == "") 
		appt_date = " ";
	else
		appt_date = convertDate(appt_date,'DMY',localeName,'en');
	var user_type		= parent.MedBoardRequestFormationMain.document.forms[0].user_type.value;
	var user			= parent.MedBoardRequestFormationMain.document.forms[0].user.value;
	var role			= parent.MedBoardRequestFormationMain.document.forms[0].role.value;
	var request_id		= parent.MedBoardRequestFormationMain.document.forms[0].request_id.value;
	var RecordTime		= parent.MedBoardRequestFormationMain.document.forms[0].RecordTime.value;
	var formation_status= parent.MedBoardRequestFormationMain.document.forms[0].formation_status.value;

	if(parent.MedBoardRequestFormationMain.document.getElementById("apptImg").style.visibility == "visible")
	{
		var fields = new Array(parent.MedBoardRequestFormationMain.document.forms[0].medical_board,
		parent.MedBoardRequestFormationMain.document.forms[0].appt_date,
		parent.MedBoardRequestFormationMain.document.forms[0].user_type,
		parent.MedBoardRequestFormationMain.document.forms[0].user,
		parent.MedBoardRequestFormationMain.document.forms[0].practid,
		parent.MedBoardRequestFormationMain.document.forms[0].role);
	
		var names = new Array(getLabel("eMR.MedicalBoard.label","MR"),getLabel("Common.apptdate.label","Common"),getLabel("eMR.MemberType.label","MR"),getLabel("eMR.MemberTypeUser.label","MR"),getLabel("Common.practitioner.label","Common"),getLabel("Common.Role.label","Common"));
	}
	else
	{
		var fields = new Array(parent.MedBoardRequestFormationMain.document.forms[0].medical_board,
		parent.MedBoardRequestFormationMain.document.forms[0].user_type,
		parent.MedBoardRequestFormationMain.document.forms[0].user,
		parent.MedBoardRequestFormationMain.document.forms[0].practid,
		parent.MedBoardRequestFormationMain.document.forms[0].role);
	
		var names = new Array(getLabel("eMR.MedicalBoard.label","MR"),getLabel("eMR.MemberType.label","MR"),getLabel("eMR.MemberTypeUser.label","MR"),getLabel("Common.practitioner.label","Common")+"/"+getLabel("Common.user.label","Common")+" "+getLabel("Common.name.label","Common"),getLabel("Common.Role.label","Common"));
	}
	if(parent.MedBoardRequestFormationMain.checkFieldsofMst( fields, names, parent.frames[4])) 
	{		
		parent.MedBoardRequestFormationMain.document.forms[0].reset();		
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';	parent.frames[2].location.href="../../eMR/jsp/MedBoardRequestFormationResult.jsp?medical_board="+medical_board+"&formation_status="+formation_status+"&appt_date="+appt_date+"&practid_desc="+practid_desc+"&pract_id="+pract_id+"&user_type="+user_type+"&role="+role+"&user="+user+"&appt_date="+appt_date+"&request_id="+request_id+"&RecordTime="+RecordTime+"&mode=insert&queryFire_yn=Y ";
	}
}

function expandColapseframe(id)
{
	if(id=="E")
	{
		parent.MedBoardReqFrm.rows="18%,27%,*,7%,5%";
		parent.frames[1].document.forms[0].collapse.disabled = false;
		parent.frames[1].document.forms[0].expand.disabled = true;

	}
	else
	{
		parent.MedBoardReqFrm.rows="80%,6%,0%,0%,3%";
		parent.frames[1].document.forms[0].expand.disabled = false;
		parent.frames[1].document.forms[0].collapse.disabled = true;

	}

}

function uncheckval(obj)
{
	if(!obj.checked)
	{
		var check_value = obj.value;
		parent.frames[2].location.href="../../eMR/jsp/MedBoardRequestFormationResult.jsp?check_value="+check_value+"&mode=modify&queryFire_yn=N";
	}
}


function onSuccess()
{
	parent.frames[1].location.reload();
	parent.frames[2].location.reload();
}


function ClearValues()
{
	parent.frames[1].document.forms[0].reset();
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
}

function DateCheck(from,to) 
{
   	/*var fromarray;
	var toarray;*/
	//var fromdate = from.value ;
	//var todate = to.value ;
	//if(fromdate.length > 0 && todate.length > 0 ) 
	//alert(fromdate.length);
	//if(fromdate.length > 0) 
	if(validDateObj(from,'DMY',localeName))
	{
		/*fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt   = new Date(toarray[2],toarray[1],toarray[0]);*/
		var greg_appointmentDate = convertDate(from.value,'DMY',localeName,'en');
		//if(Date.parse(todt) > Date.parse(fromdt)) 
		//if(isBeforeNow(greg_appointmentDate,'DMY','en'))
		//if(isBefore(greg_appointmentDate,getCurrentDate('DMY', 'en'),'DMY','en'))
		if(!isAfterNow(greg_appointmentDate,'DMY','en'))
		{
			var invaldt=getMessage('MRDATE1_LT_DATE2','MR');
			invaldt=invaldt.replace('$',getLabel("Common.apptdate.label","Common"));
			invaldt=invaldt.replace('#',getLabel("Common.SystemDate.label","Common"));
			alert(invaldt);
			document.forms[0].appt_date.value='';
			document.forms[0].appt_date.focus();
		}
	}
	else
	{
		from.value ="";
	//	from.focus();
	}
}

function scrollTitle(){
   var y = parent.MedBoardRequestFormationResult.document.body.scrollTop;
   if(y == 0){
		parent.MedBoardRequestFormationResult.document.getElementById("divDataTitle").style.position = 'static';
   }else{
		parent.MedBoardRequestFormationResult.document.getElementById("divDataTitle").style.position = 'relative';
		parent.MedBoardRequestFormationResult.document.getElementById("divDataTitle").style.posTop  = y-2;
   }

}
function alignWidth(){

	var totalRows =  parent.MedBoardRequestFormationResult.document.getElementById("dataTable").rows.length;

	var counter = totalRows-1;
	var temp = parent.MedBoardRequestFormationResult.document.getElementById("dataTitleTable").rows[0].cells.length;
	for(var i=0;i<temp;i++) {
		parent.MedBoardRequestFormationResult.document.getElementById("dataTitleTable").rows[0].cells[i].width = parent.MedBoardRequestFormationResult.document.getElementById("dataTable").rows[counter].cells[i].offsetWidth;

	}
}
