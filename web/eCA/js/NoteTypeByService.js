function create() {
	f_query_add_mod.location.href='../../eCA/jsp/NoteTypeByServiceMain.jsp';
}
function query() {
	f_query_add_mod.location.href='../../eCA/jsp/NoteTypeByServiceMain.jsp?create=N';
}
function apply() {

	if(f_query_add_mod.f_query_add_mod_upper!=null&&f_query_add_mod.f_query_add_mod_lower!=null)
	{
	if(f_query_add_mod.f_query_add_mod_upper.document.NoteTypeByService_form !=null&&f_query_add_mod.f_query_add_mod_lower.document.NoteTypeByServiceSecond_form!=null)
	{
		var fields = new Array ( f_query_add_mod.f_query_add_mod_upper.document.NoteTypeByService_form.note_type);

		var names = new Array (f_query_add_mod.getMessage("eCA.NoteTypes.label",'CA'));

		if(f_query_add_mod.f_query_add_mod_upper.checkFieldsofMst( fields, names, messageFrame)) 
			f_query_add_mod.f_query_add_mod_lower.document.NoteTypeByServiceSecond_form.action="../../servlet/eCA.NoteTypeByServiceServlet";
			f_query_add_mod.f_query_add_mod_lower.document.NoteTypeByServiceSecond_form.submit();
	}
	else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}
	}
	else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}
}


function onSuccess() {
	f_query_add_mod.location.href='../../eCA/jsp/NoteTypeByServiceMain.jsp';			
	//window.setTimeout("delCommitMsg()",1000);	
}	

/*function delCommitMsg() {		
	parent.frames[1].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';	
}*/

function reset() {
	f_query_add_mod.location.href='../../eCA/jsp/NoteTypeByServiceMain.jsp';
}

/*function populateDepartment(obj)
{
	var facility = obj.value;
	parent.parent.frames[2].location.href='../jsp/NoteTypeByServicePopulateDept.jsp?operating_facility_id='+facility;
}*/
function selectAllServices(object)
{
	
	var start=eval(document.forms[0].from.value)-1;
	var end=eval(document.forms[0].end.value)-1;
	for(i=start;i<=end;i++)
	{
		if(eval("document.forms[0].chk"+i)!=null)
		{
			var obj=eval("document.forms[0].chk"+i);
			var flag=eval("document.forms[0].flag"+i);
			if(object.checked)
			{
				obj.checked=true;
			}
			else
			{
				//if(flag.value == "Y")
				{
					obj.checked=false;
				}
			}
		}
	}
}



//Functions for AddModifyNoteTypeByService.jsp-start

function submitPage()
	{
		var fields = new Array (document.forms[0].note_type
								);

		var names = new Array (getLabel("eCA.NoteTypes.label",'CA'));
		var messageFrame	=	parent.parent.frames[2];	
		if(checkFieldsofMst( fields, names, messageFrame)) 
		{
			var note_type	 = document.forms[0].note_type.value;
			parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';	
			var facility_id =  "";//document.forms[0].facility.value;
			var dept_id		=  document.forms[0].department.value;
			
			if ((note_type != null)&&(note_type.length > 0))
			{				
				parent.frames[1].location.href = "../jsp/AddModifyNoteTypeByServiceDetail.jsp?note_type="+note_type+"&facility_id="+facility_id+"&dept_id="+dept_id;
			}
			else
			{
				
				parent.frames[1].location.href = '../../eCommon/html/blank.html';
			}
		}	
	}
	
function clearAll()
{
	document.forms[0].reset();
	parent.frames[1].document.location.href ='../../eCommon/html/blank.html'; 
}
function callOnChange(obj)
{
	if(obj.value=="")
		parent.frames[1].document.location.href ='../../eCommon/html/blank.html'; 
	else
		parent.frames[1].document.location.href ='../../eCommon/html/blank.html'; 
}

//Functions for AddModifyNoteTypeByService.jsp-end

//Functions for AddModifyNoteTypeByServiceDetail.jsp-start

function submitPrevNext(from, to)
{
			document.forms[0].from.value = from;
            document.forms[0].to.value = to; 
			var dept_id		=  document.forms[0].dept_id.value;
            document.forms[0].target = "f_query_add_mod_lower"
            document.forms[0].submit();
}

//Functions for AddModifyNoteTypeByServiceDetail.jsp-end
