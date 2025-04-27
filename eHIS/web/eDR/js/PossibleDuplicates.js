/*
	Created on : 12/02/2002
	Created by : NANDA KUMAR R.

*/

async function callPatientSearch()
{
	var ErrorText = '';
	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;

	var p_patient_id = await PatientSearch();

	if (p_patient_id != null)
	{
		document.location.href='../../eDR/jsp/PossibleDuplicateSearch.jsp?patient_id='+p_patient_id;

	}
	else
	{
		
		var ErrorText = getMessage('PATIENT_NOT_SELECTED','DR');
		parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;	
	}
}

function callDupGroupDetails(p_patient_id,p_dup_group_id,p_pat_count)
{
		var ErrorText = '';
		parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;

		parent.frames[1].document.forms[0].p_patcount.value = 1;	

		parent.frames[5].location.href='../../eDR/jsp/PossibleDuplicateDetails.jsp?patient_id='+p_patient_id+'&p_pat_count='+p_pat_count;

		parent.frames[4].document.forms[0].duplicatesdetails.disabled = false;
}

async function callDuplicatesDetails()
{
	var ErrorText = '';
	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;

	p_patcount = parent.frames[1].document.forms[0].p_patcount.value ;

	if (parseInt(p_patcount) == 0)
	{
		var ErrorText = getMessage('PATIENT_NOT_SELECTED','DR');
		parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
	}
	else
	{
		p_dup_group_id	= parent.frames[5].document.forms[0].p_dup_group_id.value ;
		p_dup_count	= parent.frames[5].document.forms[0].p_dup_count.value ;
		p_patient_id1	= parent.frames[5].document.forms[0].patient_id1.value ;
		p_patient_id2	= parent.frames[5].document.forms[0].patient_id2.value ;
		patcount	= parent.frames[5].document.forms[0].patcount.value ;
		
			
		if(parseInt(patcount) == 0)
		{
			var ErrorText = getMessage('TWO_PATIENTS','DR');
			parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
		}
		else if(parseInt(patcount) == 1)
		{
			var ErrorText = getMessage('TWO_PATIENTS','DR');
			parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
		}
		else if(patcount)
		{
			var p_patient_ids = "";
			var chk_value = "";
			for(var i=1;i<=p_dup_count;i++)
			{				
				
				chk_value = eval("parent.frames[5].document.forms[0].selectpatient"+i+".checked");
				if(chk_value == true)
				{
					if(p_patient_ids.length == 0)
					{
						p_patient_ids="'";
						p_patient_ids += eval("parent.frames[5].document.forms[0].selectpatientid"+i+".value");
						p_patient_ids+="'";
					}
					else
					{
						p_patient_ids +=",'";
						p_patient_ids += eval("parent.frames[5].document.forms[0].selectpatientid"+i+".value");
						p_patient_ids +="'";
					}
				}
			}
			
			p_patient_id1=p_patient_ids;
			
			
		
			var title	= encodeURIComponent(getLabel("eDR.PossibleDuplicatesDetails.label","DR"));
			var dialogHeight= "80vh" ;
			var dialogWidth	= "65vw" ;
			var dialogTop	="0";
			var dialogLeft	="0";
			var scroll = "yes";
			var p_dup_group_id=p_dup_group_id;
			var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no; center=yes; scroll="+scroll; ;
		    await window.showModalDialog('../../eDR/jsp/PossibleDuplicateDisplayFrameset.jsp?p_patient_id1='+p_patient_id1+'&p_dup_group_id='+p_dup_group_id+'&title='+title,arguments,features);
		}
		
		
	}
}


 async function callSearchCriteria()
{
	var ErrorText = '';
	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;

	var title = getLabel("Common.SearchCriteria.label","Common");
	var dialogHeight= "79vh" ;
	var dialogWidth	= "60vw" ;
	var dialogTop="0";
	var dialogLeft="";
	var prev="prev";
	var display="display";
	var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	await top.window.showModalDialog('../../eDR/jsp/SearchCriteriaDisply.jsp?display='+display+'&criteria='+prev,arguments,features);
}

function callDuplicatesGroups()
{
	var ErrorText = '';
	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;

	p_patient_id = parent.frames[3].document.forms[0].patient_id.value;

	if (p_patient_id.length != 0)
		{
			parent.frames[5].location.href='../../eDR/jsp/PossibleDuplicateDetails.jsp?patient_id='+p_patient_id;
			parent.frames[4].document.forms[0].duplicatesdetails.disabled = true;
		}
	else
		{
			parent.frames[1].location.href='../../eDR/jsp/PossibleDuplicateHeader.jsp';
			parent.frames[2].location.href='../../eDR/jsp/PossibleDuplicateArrow.jsp';
			//parent.frames[5].location.href='../../eDR/jsp/PossibleDuplicateDetails.jsp';
			parent.frames[4].document.forms[0].duplicatesdetails.disabled = true;
		}
}


function checkDuplicatesDetails(p_patient_id,count)
{

	var ErrorText = '';
	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;

	var obj = eval("parent.frames[5].document.forms[0].selectpatient"+count) ;

	if(obj.checked == true)
	{
		parent.frames[5].document.forms[0].patcount.value		= parseInt(parent.frames[5].document.forms[0].patcount.value) + 1;
		
		if(parent.frames[5].document.forms[0].patient_id1.value.length == 0)
		{
			parent.frames[5].document.forms[0].patient_id1.value = p_patient_id;
		}
		else if(parent.frames[5].document.forms[0].patient_id2.value.length == 0)
		{
			parent.frames[5].document.forms[0].patient_id2.value = p_patient_id;
		}
		
	}
	else if(obj.checked == false)
	{
		parent.frames[5].document.forms[0].patcount.value		= parseInt(parent.frames[5].document.forms[0].patcount.value) - 1;

		if (parent.frames[5].document.forms[0].patient_id1.value == p_patient_id )
		{
			parent.frames[5].document.forms[0].patient_id1.value = '';
		}
		else if (parent.frames[5].document.forms[0].patient_id2.value == p_patient_id )
		{
			parent.frames[5].document.forms[0].patient_id2.value = '';
			
		}
	}

}


var prev=0;
var i=0;

async function viewPatientDetails(p_patient_id)
{
	var title = getLabel("eMP.ViewPatientDetails.label","MP");
	var dialogHeight= "800vh" ;
	var dialogWidth	= "700vw";
	var dialogTop="65";
	var dialogLeft="1";	
	var prev="prev";
	var display="display";
	var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	await top.window.showModalDialog('../../eMP/jsp/ViewPatDetailsMain.jsp?display='+display+'&Patient_ID='+p_patient_id,arguments,features);

}


function callDupFunction(start,end,whereclause)
{
	parent.frames[1].location.href='../../eDR/jsp/PossibleDuplicateHeader.jsp?from='+(start)+'&to='+(end)+'&whereclause='+whereclause;

}

 function reset()
{
// f_query_add_mod.location.href="../../eDR/jsp/MergedPatientIDFrameset.jsp";
frames[1].frames[1].document.forms[0].reset();
for( k=0;k<3;k++)
frames[1].frames[1].document.getElementById("tb1").rows[frames[1].frames[1].prev].cells[k].style.backgroundColor = "";
frames[1].frames[3].document.forms[0].reset();
frames[1].frames[5].document.location.href = '../../eCommon/html/blank.html'
}

function onSuccess()
{
}

function touppercase(obj)
{
	obj.value = obj.value.toUpperCase();
}
