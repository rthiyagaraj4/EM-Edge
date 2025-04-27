/*
	Created on : 12/02/2002
	Created by : NANDA KUMAR R.
*/

async function callPatientSearch()
{
	var ErrorText = '';
	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
	var p_patient_id = await PatientSearch();
	
	if(p_patient_id != null)
	{
		document.location.href='../../eDR/jsp/TransactionsOfMergeProcessSearch.jsp?patient_id='+p_patient_id;

	}
	else
	{
			var ErrorText = getMessage('PATIENT_NOT_SELECTED','DR');
			parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;	
	}
}

function callDupGroupDetails(p_patient_id,p_dup_group_id,p_pat_count,group_status)
{
	
	var ErrorText = '';
	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
	parent.frames[1].document.forms[0].p_patcount.value = 1;	
	parent.parent.frames[1].frames[8].location.href='../../eDR/jsp/TransactionsOfMergeProcessDetails.jsp?patient_id='+p_patient_id+'&p_pat_count='+p_pat_count+'&p_group_status='+group_status;

	parent.frames[6].document.getElementById("patient_id").focus();
	
}

function callDuplicatesDetails()
{
	var ErrorText = '';
	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
	p_patcount = parent.frames[1].document.forms[0].p_patcount.value ;

	if(parseInt(p_patcount) == 0)
	{
		var ErrorText = getMessage('PATIENT_NOT_SELECTED','DR');
		parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
	}
	else
	{
		p_dup_group_id	= parent.parent.frames[1].frames[8].document.forms[0].p_dup_group_id.value ;
		p_dup_count		= parent.parent.frames[1].frames[8].document.forms[0].p_dup_count.value ;
		p_patient_id1	= parent.parent.frames[1].frames[8].document.forms[0].patient_id1.value ;
		p_patient_id2	= parent.parent.frames[1].frames[8].document.forms[0].patient_id2.value ;
		patcount		= parent.parent.frames[1].frames[8].document.forms[0].patcount.value ;
	
		if(parseInt(patcount) >= 1 && parseInt(patcount) < 2)
		{
			var ErrorText = getMessage('TWO_PATIENTS','DR');
			parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
		}
		else if(parseInt(patcount) == 2 )
		{
			var title= getLabel("eDR.PossibleDuplicatesDetails.label","DR");
			var dialogHeight= "20" ;
			var dialogWidth	= "28" ;
			var dialogTop="30";
			var dialogLeft="30";
			var scroll = "yes";
			var p_dup_group_id=p_dup_group_id;
			var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no; center=yes; scroll="+scroll; ;
			window.showModalDialog('../../eDR/jsp/TransactionsOfMergeProcessDisplayFrameset.jsp?p_patient_id1='+p_patient_id1+'&p_patient_id2='+p_patient_id2+'&title='+title,arguments,features);
		}
		else if (parseInt(p_dup_count) > 10 )
		{
			var ErrorText = getMessage('TEN_PATIENTS','DR');
			parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
		}
		else
		{
			add_width = 14 ;
			var title= getLabel("eDR.PossibleDuplicatesDetails.label","DR");
			var dialogHeight= "20" ;
			var dialogWidth = (add_width * p_dup_count );
			var dialogLeft  ="";
			if (parseInt(p_dup_count) == 2)
			{
				dialogLeft  = "30"
			}
			else
			{
				dialogLeft  = "10"
			}

			var dialogTop="30";
			var scroll = "yes";
			var p_dup_group_id=p_dup_group_id;
			var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no; center=yes; scroll="+scroll; ;
			window.showModalDialog('../../eDR/jsp/TransactionsOfMergeProcessDisplayFrameset.jsp?p_dup_group_id='+p_dup_group_id+'&title='+title,arguments,features);
		}
	}
}

function callSearchCriteria()
{
	var ErrorText = '';
	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
	var title = getLabel("Common.SearchCriteria.label","Common");
	var dialogHeight= "24" ;
	var dialogWidth	= "50" ;
	var dialogTop="100";
	var dialogLeft="";
	var prev="prev";
	var display="display";
	var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	window.showModalDialog('../../eDR/jsp/SearchCriteriaDisply.jsp?display='+display+'&criteria='+prev,arguments,features);
}

function callDuplicatesGroups()
{
	var ErrorText = '';
	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
	p_patient_id = parent.parent.frames[1].frames[6].document.forms[0].patient_id.value;
	if(p_patient_id.length != 0)
	{
		parent.parent.frames[1].frames[8].location.href='../../eDR/jsp/TransactionsOfMergeProcessDetails.jsp?patient_id='+p_patient_id+'&p_group_status=X';
	}
	else
	{
		parent.parent.frames[1].frames[1].location.href='../../eDR/jsp/TransactionsOfMergeProcessHeader1.jsp';
		parent.parent.frames[1].frames[2].location.href='../../eDR/jsp/TransactionsOfMergeProcessArrow1.jsp';
		parent.parent.frames[1].frames[4].location.href='../../eDR/jsp/TransactionsOfMergeProcessHeader2.jsp';
		parent.parent.frames[1].frames[5].location.href='../../eDR/jsp/TransactionsOfMergeProcessArrow2.jsp';
	}
}

function checkDuplicatesDetails(p_patient_id,count)
{
	var ErrorText = '';
	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
	var obj = eval("parent.parent.frames[1].frames[8].document.forms[0].selectpatient"+count) ;
	if(obj.checked == true)
	{
		parent.parent.frames[1].frames[8].document.forms[0].patcount.value	= parseInt(parent.parent.frames[1].frames[8].document.forms[0].patcount.value) + 1;
		if(parseInt(parent.parent.frames[1].frames[8].document.forms[0].patcount.value) > 2)
		{
			var ErrorText = getMessage('ONLY_TWO','DR');
			parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
			obj.checked = false;
			parent.parent.frames[1].frames[8].document.forms[0].patcount.value		= parseInt(parent.parent.frames[1].frames[8].document.forms[0].patcount.value) - 1;
		}		
		else 
		{
			if(parent.parent.frames[1].frames[8].document.forms[0].patient_id1.value.length == 0)
			{
				parent.parent.frames[1].frames[8].document.forms[0].patient_id1.value = p_patient_id;
			}
			else if(parent.parent.frames[1].frames[8].document.forms[0].patient_id2.value.length == 0)
			{
				parent.parent.frames[1].frames[8].document.forms[0].patient_id2.value = p_patient_id;
			}
		}
	}
	else if(obj.checked == false)
	{
		parent.parent.frames[1].frames[8].document.forms[0].patcount.value		= parseInt(parent.parent.frames[1].frames[8].document.forms[0].patcount.value) - 1;

		if(parent.parent.frames[1].frames[8].document.forms[0].patient_id1.value == p_patient_id )
		{
			parent.parent.frames[1].frames[8].document.forms[0].patient_id1.value = '';
		}
		else if(parent.parent.frames[1].frames[8].document.forms[0].patient_id2.value == p_patient_id )
		{
			parent.parent.frames[1].frames[8].document.forms[0].patient_id2.value = '';
		}
	}
}

var prev	= 0;
var i		= 0;


function changeRowColor1(obj,n)
{
	
	for(i=0;i<n;i++)
		parent.frames[1].document.getElementById("tb1").rows(prev).cells(i).style.backgroundColor=obj.bgColor;
	for(i=0;i<n;i++)
		obj.cells(i).style.backgroundColor="#B2B6D7";

	prev	= obj.rowIndex;
}


function viewPatientDetails(p_patient_id,dup_ind,group_status )
{
	var title = getLabel("eMP.ViewPatientDetails.label","MP");
	var dialogHeight= "90" ;
	var dialogWidth	= "90" ;
	var dialogTop="0";
	var dialogLeft="";	
	var prev="prev";
	var display="display";
	var features= "dialogHeight:" + dialogHeight + "%; dialogWidth:" + dialogWidth+ "%; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;

	if(dup_ind == 'V')
	{
		window.showModalDialog('../../eMP/jsp/ViewPatDetailsMain.jsp?Patient_ID='+p_patient_id,arguments,features);
	}
	else if(dup_ind == 'D')
	{
		//window.showModalDialog('../../eDR/jsp/ViewDupPatDetailsMain.jsp?&Patient_ID='+p_patient_id,arguments,features);
		window.showModalDialog('../../eMP/jsp/ViewPatDetailsMain.jsp?disp_dup_pat_dtls=Duplicate&Patient_ID='+p_patient_id+'&group_status='+group_status,arguments,features);
	}
}

function callDupFunction1(start,end,whereclause)
{
	parent.parent.frames[1].frames[1].location.href='../../eDR/jsp/TransactionsOfMergeProcessHeader1.jsp?from='+(start)+'&to='+(end)+'&whereclause='+whereclause;
}

function callDupFunction2(start,end,whereclause)
{
	parent.parent.frames[1].frames[4].location.href='../../eDR/jsp/TransactionsOfMergeProcessHeader2.jsp?from='+(start)+'&to='+(end)+'&whereclause='+whereclause;
}

function reset()
{
	frames[1].frames[1].document.forms[0].reset();

	if(frames[1].frames[1].document.tb1!=null)
	{
		for( k=0;k<3;k++)
		{
			frames[1].frames[1].document.getElementById("tb1").rows(frames[1].frames[4].prev).cells(k).style.backgroundColor="";
		}
	}

	frames[1].frames[4].document.forms[0].reset();
	
	if(frames[1].frames[4].document.tb1!=null)
	{
		for( k=0;k<3;k++)
		{
			frames[1].frames[4].document.getElementById("tb1").rows(frames[1].frames[4].prev).cells(k).style.backgroundColor = "";
		}
	}
	frames[1].frames[6].document.forms[0].reset();
	frames[1].frames[8].document.location.href = '../../eCommon/html/blank.html'
}

function onSuccess() { }

function touppercase(obj)
{
	obj.value = obj.value.toUpperCase();
}
