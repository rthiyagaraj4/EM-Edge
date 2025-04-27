
function create() {
     
	   f_query_add_mod.location.href ='../../eSM/jsp/FacilityForResponsibilityForm.jsp' ;
 }

function edit() {

}

function query() {
    
	f_query_add_mod.location.href ="../../eSM/jsp/queryResponsibilityForFacilityPage.jsp";
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

/*if (! (checkIsValidForProceed()) )
    {
        
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } */
	
	
 if(parent.frames[1].frames[1]!=null)
 {
 
	 if(frames[1].document.query_criteria!=null)
	 {
			if(frames[1].document.query_criteria)
			{ 
				
			if(frames[1].document.result.document.getElementById("insert_vals"))
			{
				if(effected_records())
				{
				
					frames[1].document.result.document.forms[0].action="../../servlet/eSM.FacilityForResponsibilityServlet";
					frames[1].document.result.document.forms[0].target="messageFrame";
					frames[1].document.result.document.forms[0].submit();
				
				}
				else
				{
				
					alert(frames[1].document.query_criteria.getMessage('NO_CHANGE_TO_SAVE','common'));
					frames[2].location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num=';
				}
			}
			else
			{
			
				frames[2].location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num=';
			}
				
				  
			}
	  }
	  else
	  {
	  
			frames[0].location.reload();
			return false;
	  }
  }
  else
  {
  
		frames[0].location.reload();
		return false;
  }

}

function reset() 
{

if(f_query_add_mod.document.forms[0] || f_query_add_mod.document.buttons){
		f_query_add_mod.document.location.reload();
	}
	
}

function deleterecord() {

	if(f_query_add_mod.document.responsibility_form.function1.value="insert") 
	{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="
	}
	else if(f_query_add_mod.document.responsibility_form.function1.value="modify") 
		{
		f_query_add_mod.document.responsibility_form.function1.value="delete";
		f_query_add_mod.document.responsibility_form.submit();
		return true;
	}
	else {
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="
	}
}



function onSuccess() {
	
if(frames[1].document.result != null)
{
	//alert('inside');
	alert(frames[1].document.query_criteria.getMessage('RECORD_INSERTED','SM'));
	frames[1].document.query_criteria.document.location.reload();
	
	}
	else
	{
		alert("else");
		alert(parent.frames[1].getMessage('RECORD_INSERTED','SM'));
	alert("out");
		
	}
}
function effected_records()
{

//var start = parseInt(parent.frames[1].document.frames[1].document.frames[2].document.getElementById("from").value);
var start = parseInt(frames[1].document.result.document.getElementById("from").value);

	//var end = parseInt(parent.frames[1].document.frames[1].document.frames[2].document.getElementById("to").value);
	var end = parseInt(frames[1].document.result.document.getElementById("to").value);

	
var changed_insert="";
var changed_delete="";
var changed_update="";
	for (i=start;i<=end ;i++ )
	{
		var curr_val = "false";
	if(frames[1].document.result.document.getElementById("facilityID"+i))
	{
		if(eval(frames[1].document.result.document.getElementById("facilityID"+i)).checked)
			curr_val = "true";

		var db_val = eval(frames[1].document.result.document.getElementById("db_val"+i)).value

			var comments = eval(frames[1].document.result.document.getElementById("comments"+i)).value

				var db_comments = eval(frames[1].document.result.document.getElementById("db_comments"+i)).value
		//curr_val = 	trimString(curr_val);
		//db_val = 	trimString(db_val);
//alert("curr_val:"+escape(curr_val)+"db_val:"+escape(db_val));
			if(curr_val != db_val)
			{
				if(curr_val == "true")
				{
					if(changed_insert.length == 0)
						changed_insert=changed_insert+i;
					else
						changed_insert=changed_insert+ "~" + i;
				}
				else
				{
					if(changed_delete.length == 0)
						changed_delete=changed_delete+eval(frames[1].document.result.document.getElementById("facilityID"+i)).value;
					else
						changed_delete=changed_delete+ "~" + eval(frames[1].document.result.document.getElementById("facilityID"+i)).value;
				}
			}
			else if(comments != db_comments && curr_val == "true")
			{
				if(changed_update.length == 0)
				{
				changed_update=changed_update+i;
				}
				else
				{
					changed_update=changed_update+ "~" +i ;
				}
			}
	}
	}
	
	frames[1].document.result.document.getElementById("insert_vals").value = changed_insert;
	frames[1].document.result.document.getElementById("update_vals").value =changed_update ;
	frames[1].document.result.document.getElementById("delete_vals").value = changed_delete;
	
	if(changed_update.length== 0 && changed_delete.length == 0 && changed_insert.length == 0)
	{
		return false;
	}
	else
	{
		return true;
	}

		//alert("changed_insert:"+changed_insert+"changed_delete:"+changed_delete+"changed_update:"+changed_update);

}


function effected_records1(from,to)
{

var start = parseInt(parent.frames[2].document.getElementById("from").value);

	var end = parseInt(parent.frames[2].document.getElementById("to").value);

	
var changed_insert="";
var changed_delete="";
var changed_update="";
	for (i=start;i<=end ;i++ )
	{
	if(eval(parent.frames[2].document.getElementById("facilityID"+i)))
	{
		var curr_val = "false";
		if(eval(parent.frames[2].document.getElementById("facilityID"+i)).checked)
			curr_val = "true";

		var db_val = eval(parent.frames[2].document.getElementById("db_val"+i)).value

			var comments = eval(parent.frames[2].document.getElementById("comments")+i).value

				var db_comments = eval(parent.frames[2].document.getElementById("db_comments"+i)).value
		//curr_val = 	trimString(curr_val);
		//db_val = 	trimString(db_val);
//alert("curr_val:"+escape(curr_val)+"db_val:"+escape(db_val));
			if(curr_val != db_val)
			{
				if(curr_val == "true")
				{
					if(changed_insert.length == 0)
						changed_insert=changed_insert+i;
					else
						changed_insert=changed_insert+ "~" + i;
				}
				else
				{
					if(changed_delete.length == 0)
						changed_delete=changed_delete+eval(parent.frames[2].document.getElementById("facilityID"+i)).value;
					else
						changed_delete=changed_delete+ "~" + eval(parent.frames[2].document.getElementById("facilityID"+i)).value;
				}
			}
			else if(comments != db_comments && curr_val == "true")
			{
				if(changed_update.length == 0)
				{
				changed_update=changed_update+i;
				}
				else
				{
					changed_update=changed_update+ "~" +i ;
				}
			}
	}
	}
	
	parent.frames[2].document.getElementById("insert_vals").value = changed_insert;
	parent.frames[2].document.getElementById("update_vals").value =changed_update ;
	parent.frames[2].document.getElementById("delete_vals").value = changed_delete;
	//alert("changed_insert:"+changed_insert+"changed_delete:"+changed_delete+"changed_update:"+changed_update);
	var respID = parent.frames[2].document.forms[0].respID.value;
	var faci = parent.frames[2].document.forms[0].faci.value;
	var param1 = parent.frames[2].document.forms[0].param1.value;
	var order = parent.frames[2].document.forms[0].order.value

	if(changed_update.length== 0 && changed_delete.length == 0 && changed_insert.length == 0)
	{
		//alert('no changes to save');
	//	alert(parent.frames[1].getMessage('NO_CHANGE_TO_SAVE','common'));
		parent.frames[2].document.location.href= '../../eSM/jsp/FacilityforResponsibilityDetail.jsp?respID='+respID+'&order='+order+'&faci='+faci+'&param='+param1+'&from='+from+'&to='+to;

	}
	else
	{
	if(confirm(parent.frames[1].getMessage('WANT_TO_SAVE','common')))
		{
			parent.frames[2].document.forms[0].action="../../servlet/eSM.FacilityForResponsibilityServlet";
			parent.frames[2].document.forms[0].target="messageFrame";
			parent.frames[2].document.forms[0].submit();
			parent.frames[2].document.location.href= '../../eSM/jsp/FacilityforResponsibilityDetail.jsp?respID='+respID+'&order='+order+'&faci='+faci+'&param='+param1+'&from='+from+'&to='+to;
		}
		else
		{
			document.location.href= '../../eSM/jsp/FacilityforResponsibilityDetail.jsp?respID='+respID+'&order='+order+'&faci='+faci+'&param='+param1+'&from='+from+'&to='+to;
		}	
		
	}
}
