function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/ChiefComplaintDiag.jsp?';
}

function apply()
{
	

	if(f_query_add_mod.frames[0] != null)
	{
	if((f_query_add_mod.frames[0].document.forms[0] != null)) //(f_query_add_mod.frames[1].document.forms[0] != null))
	{
		var fields = new Array (f_query_add_mod.frames[0].document.forms[0].complaint_id);
	var names = new Array(getLabel("Common.ChiefComplaint.label",'COMMON'));
	
	if(f_query_add_mod.frames[0].checkFieldsofMst( fields, names, messageFrame ))
	{
		
		var index = f_query_add_mod.frames[0].document.forms[0].complaint_id.selectedIndex;
		//var complaintid = f_query_add_mod.frames[0].document.forms[0].complaint_id.options(index).value;
		var complaintid = f_query_add_mod.frames[0].document.getElementById("complaint_id").options[index].value;
		if((f_query_add_mod.frames[1].document.forms[0] != null))
		{
		f_query_add_mod.frames[1].document.forms[0].complaint_id.value=complaintid;

		//populate();

		f_query_add_mod.frames[1].document.ChiefComplaintDiagResultfrm.submit();
		//	parent.frames[1].document.ChiefComplaintDiagAlphafrm.submit();
		}
		else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}

	}
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

function onSuccess()
{
	f_query_add_mod.location.reload();
	//f_query_add_mod.frames[1].document.forms[0].srl_nos.value="";

}

function reset()
{
	f_query_add_mod.location.reload();
}


//Functions for the file ChiefComplaintDiagCriteria.jsp-start

function blankScreen(){
	parent.frames[1].location.href = "../../eCommon/html/blank.html";
	parent.frames[2].location.href = "../../eCommon/html/blank.html";
	parent.frames[3].location.href = "../../eCommon/html/blank.html";
}
function populate()
{
	var fields = new Array (document.forms[0].complaint_id);
	var names = new Array(getLabel("Common.ChiefComplaint.label",'COMMON'));
	
	if(parent.frames[0].checkFieldsofMst( fields, names, parent.parent.frames[2]))
	{
	parent.frames[1].location.href="../../eCA/jsp/ChiefComplaintDiagResult.jsp?openmode=true&mode=insert&complaint_id="+document.forms[0].complaint_id.value+"";	

	parent.frames[2].location.href="../../eCA/jsp/ChiefComplaintDiagSearch.jsp?complaint_id="+document.forms[0].complaint_id.value;
		
	parent.parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?";
	}

}

//Functions for the file ChiefComplaintDiagCriteria.jsp-end 


//Functions for the file ChiefComplaintDiagResult.jsp-start 

function Reassaign(obj,row)
{
	if(!obj.checked)
	{
		
		var chkval = obj.value;
		var flag="false";
		clearremval=document.getElementById("dataTable").rows[row].cells[1].innerText;
		//alert("row"+row);
		//alert("clearremval"+clearremval);

	if(document.forms[0].openmode.value)
	{
		parent.frames[1].location.href="../../eCA/jsp/ChiefComplaintDiagResult.jsp?openmode=true&icd_code="+chkval+"&code="+chkval+"&flag="+flag+"";
		//parent.frames[1].location.href="../../eCA/jsp/ChiefComplaintDiagResult.jsp?code="+splitval[0]+"&flag="+flag+"&descFription="+splitval[1]+"&icd_code="+splitval[2]+"";
		
	}
	else
		{
		

		var from = parent.frames[3].document.forms[0].from.value;
		var to   = parent.frames[3].document.forms[0].to.value;
		var add  = parent.frames[3].document.forms[0].start_end.value;
		var alpha= parent.frames[3].document.forms[0].alpha.value;
		parent.frames[1].location.href="../../eCA/jsp/ChiefComplaintDiagResult.jsp?code="+encodeURIComponent(clearremval)+"&icd_code="+encodeURIComponent(clearremval)+"&flag="+flag+"";
		//parent.frames[2].document.forms[0].term_set.value=clearremval;
		//parent.frames[3].location.href="../../eCA/jsp/ChiefComplaintDiagDetails.jsp?mode=modify&from="+from+"&to="+to+"&add="+add+"&alpha="+alpha+"";
		makeresultcheck(clearremval)
		}

		

	}	
}

function scrollTitle(){
	  var y = parent.ChiefComplaintDiagResult.document.body.scrollTop;

	  if(y == 0){
		parent.ChiefComplaintDiagResult.document.getElementById("divDataTitle").style.position = 'static';
		parent.ChiefComplaintDiagResult.document.getElementById("divDataTitle").style.posTop  = 0;
	  }else{
		parent.ChiefComplaintDiagResult.document.getElementById("divDataTitle").style.position = 'relative';
		parent.ChiefComplaintDiagResult.document.getElementById("divDataTitle").style.posTop  = y-2;
	  }

}
	function alignWidth(){
		
		var totalRows =  parent.ChiefComplaintDiagResult.document.getElementById("dataTable").rows.length;
		var counter = totalRows-1;
		var temp = parent.ChiefComplaintDiagResult.document.getElementById("dataTitleTable").rows[1].cells.length;
		for(var i=0;i<temp;i++) {
			parent.ChiefComplaintDiagResult.document.getElementById("dataTitleTable").rows[1].cells[i].width=parent.ChiefComplaintDiagResult.document.getElementById("dataTable").rows[counter].cells[i].offsetWidth;
			
		}
}
//Functions for the file ChiefComplaintDiagResult.jsp-end 


//Functions for the file ChiefComplaintDiagDetails.jsp-start

function CheckVal(obj)
{
	//alert("obj"+obj.value);
	var chkval = obj.value;
	var splitval = chkval.split("~");
	var flag = obj.checked;
	//alert("flag"+flag);

	parent.frames[1].location.href="../../eCA/jsp/ChiefComplaintDiagResult.jsp?code="+splitval[0]+"&flag="+flag+"&description="+splitval[1]+"&icd_code="+encodeURIComponent(splitval[2])+"&itermsetdesc="+splitval[3]+"";

}

function PrevNextFunc(from, to,complaint_id,alpha,id,addno ){
	
	var start;
	var end;
	if(id == 'P'){
		end = parseInt(to)+14;
		start = parseInt(to)+1;
	}else{
		end = parseInt(to)-14;
		start = parseInt(from)-14;
	}

	
	//parent.frames[1].document.forms[0].srl_nos.value=tempSrlNos;
	document.forms[0].id.value = id; 
	document.forms[0].start_end.value = addno;
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].complaint_id.value = complaint_id;
	//document.forms[0].term_set_id.value = term_set_id;
	document.forms[0].alpha.value = alpha; 
	document.forms[0].submit();
}

//Functions for the file ChiefComplaintDiagDetails.jsp-end


//Functions for the file ChiefComplaintDiagSearch.jsp-start
//function SearchDetails(obj)
///{
	
	//var searchtxt = obj.value;
	//parent.frames[1].document.forms[0].openmode.value=false;
    //parent.frames[3].location.href="../../eCA/jsp/ChiefComplaintDiagDetails.jsp?complaint_id="+parent.frames[0].document.forms[0].complaint_id.value+"&alpha="+parent.frames[2].document.forms[0].searchtext.value;+"";	

//}

function SearchDetails()
{
	parent.frames[3].location.href="../../eCommon/html/blank.html";

	var fields = new Array (parent.frames[0].document.forms[0].complaint_id,parent.frames[2].document.forms[0].term_set); //,parent.frames[2].document.forms[0].event_class_id)
	
    var names = new Array ( getLabel("Common.ChiefComplaint.label",'COMMON'),getLabel("Common.TermSet.label",'COMMON'));  //,"Event Class" )

    var searchWith = parent.frames[2].document.forms[0].search_criteria.value;
    //var term_desc = parent.frames[2].document.forms[0].document.forms[0].term_desc.value;
	parent.frames[1].document.forms[0].openmode.value=false;

	
	if((checkFieldsofMst( fields, names, parent.parent.messageFrame)) )
	{

      parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";

      //parent.frames[3].location.href="../../eCA/jsp/FlowSheetCompDetailList.jsp?mode=insert&history_type_id="+parent.frames[2].document.forms[0].history_type.value+"&flow_sheet_id="+parent.frames[0].document.forms[0].flow_sheet.value+"&searchby="+searchby+"&criteria="+criteria+"&text="+text+"";

      parent.frames[3].location.href="../../eCA/jsp/ChiefComplaintDiagDetails.jsp?term_set_id="+parent.frames[2].document.forms[0].term_set.value+"&complaint_id="+parent.frames[0].document.forms[0].complaint_id.value+"&alpha="+parent.frames[2].document.forms[0].term_desc.value+"&searchWith="+searchWith+"";	
	
	}
}

function makeresultcheck(remval)
{
	if(parent.frames[3].document.forms[0] != null)
	{
		for(cnt=0; cnt<parent.frames[3].document.forms[0].count.value; cnt++)
	{
			val = eval("parent.frames[3].document.forms[0].diag_exists"+cnt);
			strval=eval("parent.frames[3].document.forms[0].chk_value"+cnt+".value");
			if(strval==remval)
			{
				val.checked = false
   			}

	}
	
	}
  
}

//for next previous displaying fourteen records.
function submitPrevNext(from,to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
	
}


//Functions for the file ChiefComplaintDiagSearch.jsp-end
