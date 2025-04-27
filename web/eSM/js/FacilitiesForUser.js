function create() {
	f_query_add_mod.location.href = "../../eSM/jsp/FacilityforUserMainForm.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eSM/jsp/queryFacilityforUserPage.jsp";
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
	if(f_query_add_mod.document.query_criteria)
	//if(document.frames[1].document.frames[1])
	{
		//if(parent.frames[1].document.frames[1].document.frames[2].document.getElementById("insert_vals"))
		if(f_query_add_mod.document.result.document.getElementById("insert_vals"))
		{
			if(effected_records())
			{
				//parent.frames(1).document.frames(1).document.frames(2).document.forms(0).action="../../servlet/eSM.FacilitiesForUserServlet";
				//frames(1).document.frames(2).document.forms(0).action="../../servlet/eSM.FacilitiesForUserServlet";
				f_query_add_mod.document.result.document.forms[0].action="../../servlet/eSM.FacilitiesForUserServlet";				
				//parent.frames(1).document.frames(1).document.frames(2).document.forms(0).target="messageFrame";
				//frames(1).document.frames(2).document.forms(0).target="messageFrame";
				f_query_add_mod.document.result.document.forms[0].target="messageFrame";
				//parent.frames(1).document.frames(1).document.frames(2).document.forms(0).submit();
				//frames(1).document.frames(2).document.forms(0).submit();
				f_query_add_mod.document.result.document.forms[0].submit();
				
			}
			else
			{
				//alert(parent.frames(1).document.frames(1).document.frames(1).getMessage('NO_CHANGE_TO_SAVE','common'));
				alert(f_query_add_mod.document.result.getMessage('NO_CHANGE_TO_SAVE','common'));
				//document.frames[2].location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num=';
				messageFrame.document.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num=';
			}
		}
		else
		{
			messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num=';
		}
	}

}

function reset() {
	if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		f_query_add_mod.location.reload();

        return false;
    } 
	if(f_query_add_mod.document.forms[0] || f_query_add_mod.document.frames[0])
		f_query_add_mod.document.location.reload();
}

function onSuccess() 
{
	//f_query_add_mod.document.location.reload();
	//alert(parent.frames[1].document.frames[1].document.frames[1].getMessage('RECORD_INSERTED','SM'));
	//alert(frames[1].document.frames[1].getMessage('RECORD_INSERTED','SM'));
	alert(f_query_add_mod.document.result.getMessage('RECORD_INSERTED','SM'));
	
	//parent.frames[1].document.frames[1].document.frames[2].document.location.reload();
	f_query_add_mod.document.result.location.reload();
}


function deleterecord()
{

	if(f_query_add_mod.document.facility_form.function1.value!="insert")
	{
		f_query_add_mod.document.facility_form.function1.value="delete";
		f_query_add_mod.document.facility_form.function_name.value="delete";
		f_query_add_mod.document.facility_form.submit();
		f_query_add_mod.location.href="../common/html/blank.html"
		return true;
	}
	else
	{
		messageFrame.location.href="../common/jsp/error.jsp?err_num="
	}
}

function effected_records()
{
	//var start = parseInt(parent.frames[1].document.frames[1].document.frames[2].document.getElementById("from").value);
	var start = parseInt(f_query_add_mod.document.result.document.getElementById("from").value);
	
	//var end = parseInt(parent.frames[1].document.frames[1].document.frames[2].document.getElementById("to").value);
	var end = parseInt(f_query_add_mod.document.result.document.getElementById("to").value);
	
	//var localeName = parent.frames[1].document.frames[1].document.frames[2].localeName;
	var localeName = f_query_add_mod.document.result.localeName;
	
	var changed_insert="";
	var changed_delete="";
	var changed_update="";
	var i=0;


	for (i=start;i<=end;i++)
	{
		var curr_val = "false";
		if(eval(f_query_add_mod.document.result.document.getElementById("facilityID"+i)))
		{
			if(eval(f_query_add_mod.document.result.document.getElementById("facilityID"+i).checked))
				curr_val = "true";
	
			//var db_facilityID = eval("parent.frames(1).document.frames(1).document.frames(2).document.all.db_facilityID"+i).value
			var db_facilityID = f_query_add_mod.document.result.document.getElementById("db_facilityID"+i).value;
			
			var eff_dt_from ="";
			var eff_dt_to ="";
			var db_eff_dt_from ="";
			var db_eff_dt_to ="";
			var comments = "";
			var db_comments = "";
			
			//comments = eval("parent.frames(1).document.frames(1).document.frames(2).document.all.comments"+i).value;
			//comments = eval("frames(1).document.frames(2).document.all.comments"+i).value;
			comments = f_query_add_mod.document.result.document.getElementById("comments"+i).value;
			
			//db_comments = eval("parent.frames(1).document.frames(1).document.frames(2).document.all.db_comments"+i).value;
			//db_comments = eval("frames(1).document.frames(2).document.all.db_comments"+i).value;
			db_comments = f_query_add_mod.document.result.document.getElementById("db_comments"+i).value;
			
			//eff_dt_from = eval("parent.frames(1).document.frames(1).document.frames(2).document.all.eff_date_from"+i).value
			//eff_dt_from = eval("document.frames(1).document.frames(2).document.all.eff_date_from"+i).value
			eff_dt_from = f_query_add_mod.document.result.document.getElementById("eff_date_from"+i).value;
	

			if(eff_dt_from != "")			
				//	eff_dt_from = parent.frames(1).document.frames(1).document.frames(2).convertDate(eff_dt_from,"DMY",localeName,"en");
				//eff_dt_from = document.frames(1).document.frames(2).convertDate(eff_dt_from,"DMY",localeName,"en");
				eff_dt_from = f_query_add_mod.document.result.convertDate(eff_dt_from,"DMY",localeName,"en");

				//eff_dt_to = eval("parent.frames(1).document.frames(1).document.frames(2).document.all.eff_date_to"+i).value
				//eff_dt_to = eval("document.frames(1).document.frames(2).document.all.eff_date_to"+i).value;
				eff_dt_to = f_query_add_mod.document.result.document.getElementById("eff_date_to"+i).value;
			
			if(eff_dt_to != "")
				//eff_dt_to = parent.frames(1).document.frames(1).document.frames(2).convertDate(eff_dt_to,"DMY",localeName,"en");
				//eff_dt_to = document.frames(1).document.frames(2).convertDate(eff_dt_to,"DMY",localeName,"en");
				eff_dt_to = f_query_add_mod.document.result.convertDate(eff_dt_to,"DMY",localeName,"en");
			
			
			//db_eff_dt_from = eval("parent.frames(1).document.frames(1).document.frames(2).document.all.old_eff_from"+i).value 
			//db_eff_dt_from = eval("document.frames(1).document.frames(2).document.all.old_eff_from"+i).value 
			db_eff_dt_from = f_query_add_mod.document.result.document.getElementById("old_eff_from"+i).value;
			
			//db_eff_dt_to = eval("parent.frames(1).document.frames(1).document.frames(2).document.all.db_eff_date_to"+i).value 
			//db_eff_dt_to = eval("document.frames(1).document.frames(2).document.all.db_eff_date_to"+i).value 
			db_eff_dt_to = f_query_add_mod.document.result.document.getElementById("db_eff_date_to"+i).value;
			
			if(curr_val != db_facilityID)
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
						//changed_delete=changed_delete+eval("parent.frames(1).document.frames(1).document.frames(2).document.all.facilityID"+i).value;
						//changed_delete=changed_delete+eval("document.frames(1).document.frames(2).document.all.facilityID"+i).value;
						changed_delete=changed_delete+f_query_add_mod.document.result.document.getElementById("facilityID"+i).value;
					else
						//changed_delete=changed_delete+ "~" + eval("parent.frames(1).document.frames(1).document.frames(2).document.all.facilityID"+i).value;
						//changed_delete=changed_delete+ "~" + eval("document.frames(1).document.frames(2).document.all.facilityID"+i).value;
						changed_delete=changed_delete+ "~" + f_query_add_mod.document.result.document.getElementById("facilityID"+i).value;
				}
			}
			else if(curr_val == "true")
			{
				if(eff_dt_from != db_eff_dt_from)
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
				else if(eff_dt_to != db_eff_dt_to)
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
				else if(comments != db_comments)
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
	}
	
	//parent.frames(1).document.frames(1).document.frames(2).document.all.insert_vals.value = changed_insert;
	//frames(1).document.frames(2).document.all.insert_vals.value = changed_insert;
	f_query_add_mod.document.result.document.getElementById("insert_vals").value = changed_insert;
	//parent.frames(1).document.frames(1).document.frames(2).document.all.update_vals.value =changed_update ;
	//frames(1).document.frames(2).document.all.update_vals.value =changed_update ;
	f_query_add_mod.document.result.document.getElementById("update_vals").value = changed_update;
	//parent.frames(1).document.frames(1).document.frames(2).document.all.delete_vals.value = changed_delete;
	//frames(1).document.frames(2).document.all.delete_vals.value = changed_delete;
	f_query_add_mod.document.result.document.getElementById("delete_vals").value = changed_delete;
	
	//alert("changed_insert:"+changed_insert+"changed_delete:"+changed_delete+"changed_update:"+changed_update);

	if(changed_update.length== 0 && changed_delete.length == 0 && changed_insert.length == 0)
	{
		return false;
	}
	else
	{
		return true;
	}

		

}


function effected_records1(from,to)
{
	var start = parseInt(parent.frames[2].document.getElementById("from").value);

	var end = parseInt(parent.frames[2].document.getElementById("to").value);

	var localeName = parent.frames[2].localeName;

	var changed_insert="";
	var changed_delete="";
	var changed_update="";
	for (i=start;i<=end ;i++ )
	{
		if(eval(parent.frames[2].document.getElementById("facilityID"+i)))
		{
			var curr_val = "false";
			if(eval(parent.frames[2].document.getElementById("facilityID"+i).checked))
				curr_val = "true";

			var db_facilityID = eval(parent.frames[2].document.getElementById("db_facilityID"+i).value);

			var eff_dt_from ="";
			var eff_dt_to ="";
			var db_eff_dt_from ="";
			var db_eff_dt_to ="";
			var comments = "";
			var db_comments = "";

			comments = eval(parent.frames[2].document.getElementById("comments"+i).value);
			db_comments = eval(parent.frames[2].document.getElementById("db_comments"+i).value);

			eff_dt_from = eval(parent.frames[2].document.getElementById("eff_date_from"+i).value);

			if(eff_dt_from != "")
				eff_dt_from = convertDate(eff_dt_from,"DMY",localeName,"en");

			eff_dt_to = eval(parent.frames[2].document.getElementById("eff_date_to"+i).value);

			if(eff_dt_to != "")
			eff_dt_to = convertDate(eff_dt_to,"DMY",localeName,"en");

			db_eff_dt_from = eval(parent.frames[2].document.getElementById("old_eff_from"+i).value);

			db_eff_dt_to = eval(parent.frames[2].document.getElementById("db_eff_date_to"+i).value); 

		
			if(curr_val != db_facilityID)
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
						changed_delete=changed_delete+eval(parent.frames[2].document.getElementById("facilityID"+i).value);
					else
						changed_delete=changed_delete+ "~" + eval(parent.frames[2].document.getElementById("facilityID"+i).value);
				}
			}
			else if(curr_val == "true")
			{
				if(eff_dt_from != db_eff_dt_from)
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
				else if(eff_dt_to != db_eff_dt_to)
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
				else if(comments != db_comments)
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
	}
	
	parent.frames[2].document.getElementById("insert_vals").value = changed_insert;
	parent.frames[2].document.getElementById("update_vals").value = changed_update;
	parent.frames[2].document.getElementById("delete_vals").value = changed_delete;
	//alert("changed_insert:"+changed_insert+"changed_delete:"+changed_delete+"changed_update:"+changed_update);
	var userID = parent.frames[2].document.getElementById("userID").value;
	var searchText = parent.frames[2].document.getElementById("searchText").value;
	var filter = parent.frames[2].document.getElementById("filter").value;
	var label = parent.frames[2].document.getElementById("label").value;
//alert(searchText);



	if(changed_update.length== 0 && changed_delete.length == 0 && changed_insert.length == 0)
	{
		parent.frames[2].document.location.href= '../../eSM/jsp/FacilityforUserDetailForm.jsp?searchText='+searchText+'&filter='+filter+'&userID='+userID+'&label='+label+'&from='+from+'&to='+to;

	}
	else
	{
		if(confirm(parent.frames[1].getMessage('WANT_TO_SAVE','common')))
		{
			parent.frames[2].document.forms[0].action="../../servlet/eSM.FacilitiesForUserServlet";
			parent.frames[2].document.forms[0].target="messageFrame";
			parent.frames[2].document.forms[0].submit();
			parent.frames[2].document.location.href= '../../eSM/jsp/FacilityforUserDetailForm.jsp?searchText='+searchText+'&filter='+filter+'&userID='+userID+'&label='+label+'&from='+from+'&to='+to;
		}
		else
		{
			document.location.href= '../../eSM/jsp/FacilityforUserDetailForm.jsp?searchText='+searchText+'&filter='+filter+'&userID='+userID+'&label='+label+'&from='+from+'&to='+to;
		}	
		
	}
}