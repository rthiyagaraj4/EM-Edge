function create() { 

	f_query_add_mod.location.href = "../../eMR/jsp/ChecklistForRequestorMainForm.jsp" ;
}

function query() {
	f_query_add_mod.location.href ="../../eMR/jsp/ChecklistForRequestorQueryPage.jsp?function=ChecklistForRequestor";
}

function onSuccess() 
{
		
	alert(document.f_query_add_mod.document.buttons.getMessage('RECORD_INSERTED','SM'));
	
	
	
	f_query_add_mod.document.location.reload();
}


function reset() 
{	
		
		f_query_add_mod.document.location.reload();
		
}


function effected_records1(from,to)
{

var start = parseInt(parent.frames[2].document.getElementById("from").value);

var end = parseInt(parent.frames[2].document.getElementById("to").value);
var localeName = parent.frames[2].localeName;

	
var changed_insert="";
var changed_delete="";

	for (i=start;i<=end ;i++ )
	{
	if(eval(parent.frames[2].document.getElementById("respID"+i)))
	{
		var curr_val = "false";
		if(eval(parent.frames[2].document.getElementById("respID"+i)).checked)
			curr_val = "true";

		var db_respID = eval(parent.frames[2].document.getElementById("db_respID"+i)).value

			

		
			if(curr_val != db_respID)
			{
				if(curr_val == "true")
				{
					if(changed_insert.length == 0)
					{changed_insert=changed_insert+i; }
					else
					{changed_insert=changed_insert+ "~" + i; }
				}
				else
				{
					if(changed_delete.length == 0)
						changed_delete=changed_delete+eval(parent.frames[2].document.getElementById("respID"+i)).value;
					else
						changed_delete=changed_delete+ "~" + eval(parent.frames[2].document.getElementById("respID"+i)).value;
				}
			}
			
	}
	}
	
	parent.frames[2].document.getElementById("insert_vals").value = changed_insert;
	
	parent.frames[2].document.getElementById("delete_vals").value = changed_delete;
	
	var userID = parent.frames[2].document.forms[0].userID.value;
	
	var count = parent.frames[2].document.forms[0].count.value;
	
	var scode = parent.frames[2].document.forms[0].scode.value
	var searchcriteria = parent.frames[2].document.forms[0].searchcriteria.value
	var chk_list_count = parent.frames[2].document.forms[0].chk_list_count.value
	var chk_list_count_dummy = parent.frames[2].document.forms[0].chk_list_count_dummy.value 
	
	
	if(changed_delete.length == 0 && changed_insert.length == 0)
	{
		
		parent.frames[2].document.location.href= '../../eMR/jsp/ChecklistForRequestorDetailForm.jsp?chk_list_count='+chk_list_count+'&count='+count+'&searchchklist='+scode+'&from='+from+'&to='+to+'&searchcriteria='+searchcriteria+'&userID='+userID

	}
	else
	{ 
	if(confirm(parent.frames[0].getMessage('WANT_TO_SAVE','common')))
		{ 
			parent.frames[2].document.forms[0].action="../../servlet/eMR.CheckListForRequestorServlet";
			parent.frames[2].document.forms[0].target="messageFrame";
			parent.frames[2].document.forms[0].submit();
			
			document.location.href= '../../eMR/jsp/ChecklistForRequestorDetailForm.jsp?chk_list_count='+chk_list_count+'&count='+count+'&searchchklist='+scode+'&from='+from+'&to='+to+'&searchcriteria='+searchcriteria+'&userID='+userID
		}
		else
		{
			
			document.location.href= '../../eMR/jsp/ChecklistForRequestorDetailForm.jsp?chk_list_count='+chk_list_count_dummy+'&count='+count+'&searchchklist='+scode+'&from='+from+'&to='+to+'&searchcriteria='+searchcriteria+'&userID='+userID
		}	
		
	}
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

  function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}
function mandatoryChk()
{
 
	 var fields = new Array ( document.forms[0].requestor_desc);
	 var names  = new Array (getLabel('Common.Requestor.label','Common'));
	 if(checkFieldsofMst( fields, names, parent.parent.frames[2])) {
	 parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='
	 return true;
	 }
	 else
	 return false;

}
function displayDetails()
{ 
if(mandatoryChk())
{

var searchcriteria = document.forms[0].search_criteria.value;
var searchchklist = escape(document.forms[0].searchchklist.value);
parent.frames[2].location.href="../../eMR/jsp/ChecklistForRequestorDetailForm.jsp?userID="+document.forms[0].userID.value+"&searchchklist="+searchchklist+"&searchcriteria="+searchcriteria+"&flagSelect=fromSelect";

}
else
	{
		parent.frames[2].location.href="../../eCommon/html/blank.html";
	}
}
function clearValues()
{
parent.frames[2].location.href="../../eCommon/html/blank.html";

}


function apply() 
{
  
	if (! (checkIsValidForProceed()) )
    {
        
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	
	if(document.f_query_add_mod.document.result)
	{
		
	
	if(document.f_query_add_mod.document.result.document.getElementById("insert_vals"))
	{
			
		if(effected_records())
		{
			
			document.f_query_add_mod.document.result.document.forms[0].action="../../servlet/eMR.CheckListForRequestorServlet";
			
			//frames[1].document.frames[2].document.forms[0].target="messageFrame";
			document.f_query_add_mod.document.result.document.forms[0].target="messageFrame";
			
			document.f_query_add_mod.document.result.document.forms[0].submit();
			
			
			
			var chk_list_count = document.f_query_add_mod.document.result.document.forms[0].chk_list_count.value;
			
			var count = document.f_query_add_mod.document.result.document.forms[0].count.value;
			var scode = document.f_query_add_mod.document.result.document.forms[0].scode.value;
			var from = document.f_query_add_mod.document.result.document.forms[0].from.value;
			var to = document.f_query_add_mod.document.result.document.forms[0].to.value;
			var searchcriteria = document.f_query_add_mod.document.result.document.forms[0].searchcriteria.value;
			
			var searchchklist = document.f_query_add_mod.document.result.document.forms[0].searchchklist.value;
			
			var userID = document.f_query_add_mod.document.result.document.forms[0].userID.value;
			
			document.f_query_add_mod.document.result.location.href= '../../eMR/jsp/ChecklistForRequestorDetailForm.jsp?chk_list_count='+chk_list_count+'&count='+count+'&searchchklist='+scode+'&from='+from+'&to='+to+'&searchcriteria='+searchcriteria+'&userID='+userID
			
		}
		else
		{
			
			alert(document.f_query_add_mod.document.buttons.getMessage('NO_CHANGE_TO_SAVE','common'));
			messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num=';
		}
	}
	else
	{
		messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num=';
	}
	}
	
}

function change_count(obj)
	{
		
var start = parseInt(parent.frames[2].document.getElementById("from").value);
var end = parseInt(parent.frames[2].document.getElementById("to").value);
var localeName = parent.frames[2].localeName;
var chk_list_count = parseInt(parent.frames[2].document.getElementById("chk_list_count").value);
var name1=obj.name;
var name2="db_"+name1;

var temp_var=1;	

if (parent.frames[2].document.getElementById(name1))
	{
		var curr_val = "false";
		if       
			curr_val = "true";

		var db_respID = parent.frames[2].document.getElementById(name2).value;

			
			
		if(curr_val=="true") chk_list_count=chk_list_count+1;
		else chk_list_count=chk_list_count-1;
	}

 
parent.frames[2].document.getElementById("chk_list_count").value=chk_list_count;	
		
		//below condition is modified for ML-MMOH-CRF-1464
	if(parent.frames[2].document.getElementById("chk_list_count").value > 25 )
	{      
			alert(parent.frames[0].getMessage('CHK_LIST_MAX_REACH_REQUEST','MR'));
			parent.frames[2].document.getElementById(name1).checked = false;
			chk_list_count=chk_list_count-1;
			parent.frames[1].document.location.reload();
	}
	parent.frames[2].document.getElementById("chk_list_count").value=chk_list_count;
	
	}
	


function effected_records()
{


var start = parseInt(document.f_query_add_mod.document.result.document.getElementById("from").value);


var end = parseInt(document.f_query_add_mod.document.result.document.getElementById("to").value);




var localeName = document.f_query_add_mod.document.result.localeName;


	
var changed_insert="";
var changed_delete="";

var i=0;


for (i=start;i<=end;i++)
	{
		var curr_val = "false";
		
	if(eval(document.f_query_add_mod.document.result.document.getElementById("respID"+i)))
	{
		if(eval(document.f_query_add_mod.document.result.document.getElementById("respID"+i)).checked)
			curr_val = "true";

		var db_respID = eval(document.f_query_add_mod.document.result.document.getElementById("db_respID"+i)).value;

			



			if(curr_val != db_respID)
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
						
						{changed_delete=changed_delete+eval(document.f_query_add_mod.document.result.document.getElementById("respID"+i)).value;}
					else
						
						{changed_delete=changed_delete+ "~" + eval(document.f_query_add_mod.document.result.document.getElementById("respID"+i)).value;}
				}
			}
			
	}
	}
	
document.f_query_add_mod.document.result.document.getElementById("insert_vals").value = changed_insert;
	
document.f_query_add_mod.document.result.document.getElementById("delete_vals").value = changed_delete;
	
	
	
	if(changed_delete.length == 0 && changed_insert.length == 0)
	{
		return false;
	}
	else
	{
		return true;
	}

		

}
