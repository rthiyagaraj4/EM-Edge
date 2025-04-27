/*
	Created on : 12/02/2002
	Created by : NANDA KUMAR R.

*/

async function callPatientSearch()
{
	var ErrorText = '';
	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;

	//Modified by Ashwini on 24-Sep-2024 for ML-MMOH-CRF-1815
	var p_patient_id = "";

	var isMergeDeceasedPatIdAppl = parent.frames[3].document.forms[0].isMergeDeceasedPatIdAppl.value;

	if(isMergeDeceasedPatIdAppl == 'true'){
		p_patient_id = await PatientSearch('','','','','','','Y','','','VIEW');
	}else{
		p_patient_id = await PatientSearch();
	}

	if (p_patient_id != null)
	{
		document.location.href='../../eDR/jsp/MergedPatientIDSearch.jsp?patient_id='+p_patient_id;

	}
	else
	{
			var ErrorText = getMessage('PATIENT_NOT_SELECTED','DR');
			parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;	}
}

function callDupGroupDetails(p_patient_id,p_dup_group_id,p_pat_count)
{
		var ErrorText = '';
		parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;

		parent.frames[1].document.forms[0].p_patcount.value = 1;	

		parent.frames[5].location.href='../../eDR/jsp/MergedPatientIDDetails.jsp?patient_id='+p_patient_id+'&p_pat_count='+p_pat_count+'&p_dup_group_id='+p_dup_group_id;

}

function callDuplicatesDetails()
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
		p_dup_count		= parent.frames[5].document.forms[0].p_dup_count.value ;
		p_patient_id1	= parent.frames[5].document.forms[0].patient_id1.value ;
		p_patient_id2	= parent.frames[5].document.forms[0].patient_id2.value ;
		patcount		= parent.frames[5].document.forms[0].patcount.value ;
		

		if (parseInt(patcount) >= 1 && parseInt(patcount) < 2)
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
			window.showModalDialog('../../eDR/jsp/MergedPatientIDDisplayFrameset.jsp?p_patient_id1='+p_patient_id1+'&p_patient_id2='+p_patient_id2+'&title='+title,arguments,features);
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
			window.showModalDialog('../../eDR/jsp/MergedPatientIDDisplayFrameset.jsp?p_dup_group_id='+p_dup_group_id+'&title='+title,arguments,features);
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

function chkGrtr(obj1,obj2)
{
	if(obj1.value != "" && obj2.value != "")
	{
		if(isBefore(obj1.value,obj2.value,"DMY",localeName)==false)
		{
			var error=getMessage("ED_TIME_LESS_EQL_ST_TIME","DR");
			alert(error);	
			obj2.select();
            return false;
		}
		else 
			return true;
	}
}

function callDuplicatesGroups()
{
	var ErrorText = '';
	var p_fm_replace_date='';
	var p_to_replace_date='';
	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;

	p_patient_id = parent.frames[3].document.forms[0].patient_id.value;
	p_fm_replace_date1=parent.frames[3].document.forms[0].p_fm_replace_date.value;
	p_to_replace_date1=parent.frames[3].document.forms[0].p_to_replace_date.value;

	if(p_fm_replace_date1 != '' && p_to_replace_date1 != '')
	{
			if(chkGrtr(parent.frames[3].document.forms[0].p_fm_replace_date,parent.frames[3].document.forms[0].p_to_replace_date) == true)
			{		
				p_fm_replace_date1 = convertDate(p_fm_replace_date1,"DMY",localeName,"en");
				p_to_replace_date1 = convertDate(p_to_replace_date1,"DMY",localeName,"en");
			}
			else 
				return false;
	}


			parent.frames[0].location.href="../../eDR/jsp/MergedPatientIDHeaderTitle.jsp?p_to_replace_date="+p_to_replace_date1+"&p_fm_replace_date="+p_fm_replace_date1+"&patient_id="+p_patient_id;
			parent.frames[1].location.href="../../eDR/jsp/MergedPatientIDHeader.jsp?p_to_replace_date="+p_to_replace_date1+"&p_fm_replace_date="+p_fm_replace_date1+"&patient_id="+p_patient_id;
			parent.frames[2].location.href="../../eDR/jsp/MergedPatientIDArrow.jsp?p_to_replace_date="+p_to_replace_date1+"&p_fm_replace_date="+p_fm_replace_date1+"&patient_id="+p_patient_id;
			parent.frames[5].location.href='../../eCommon/html/blank.html';
			
		}
/*
	if (p_patient_id.length != 0)
		{
			parent.frames[5].location.href='../../eDR/jsp/MergedPatientIDDetails.jsp?patient_id='+p_patient_id;
			
		}
	else
		{
			parent.frames[0].location.href="../../eDR/jsp/MergedPatientIDHeaderTitle.jsp?p_to_replace_date="+p_to_replace_date1+"&p_fm_replace_date="+p_fm_replace_date1;
			parent.frames[1].location.href="../../eDR/jsp/MergedPatientIDHeader.jsp?p_to_replace_date="+p_to_replace_date1+"&p_fm_replace_date="+p_fm_replace_date1;
			parent.frames[2].location.href="../../eDR/jsp/MergedPatientIDArrow.jsp?p_to_replace_date="+p_to_replace_date1+"&p_fm_replace_date="+p_fm_replace_date1;
			
		}
		*/
//}


function checkDuplicatesDetails(p_patient_id,count)
{

	var ErrorText = '';
	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;

	var obj = eval("parent.frames[5].document.forms[0].selectpatient"+count) ;

	if (obj.checked == true)
	{
		parent.frames[5].document.forms[0].patcount.value		= parseInt(parent.frames[5].document.forms[0].patcount.value) + 1;

		if (parseInt(parent.frames[5].document.forms[0].patcount.value) > 2)
		{
			var ErrorText = getMessage('ONLY_TWO','DR');
			parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
			obj.checked = false;
			parent.frames[5].document.forms[0].patcount.value		= parseInt(parent.frames[5].document.forms[0].patcount.value) - 1;
		}		
		else 
		{
			if (parent.frames[5].document.forms[0].patient_id1.value.length == 0)
			{
				parent.frames[5].document.forms[0].patient_id1.value = p_patient_id;
			}
			else if (parent.frames[5].document.forms[0].patient_id2.value.length == 0)
			{
				parent.frames[5].document.forms[0].patient_id2.value = p_patient_id;
			}
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
function changeRowColor1(obj,n)
{
	for(i=0;i<n;i++)
		parent.frames[1].document.getElementById("tb1").rows(prev).cells(i).style.backgroundColor=obj.bgColor;
	for(i=0;i<n;i++)
		obj.cells(i).style.backgroundColor="#B2B6D7";
	prev	=obj.rowIndex;

}

async function viewPatientDetails(p_patient_id,valid_duplicate)
{
	var title = getLabel("eMP.ViewPatientDetails.label","MP");
	var dialogHeight= "90vh" ;
	var dialogWidth	= "85vw" ;
	var dialogTop="";
	var dialogLeft="";	
	var prev="prev";
	var display="display";
	var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	
	if(valid_duplicate == 'D')
	{
		//window.showModalDialog('../../eDR/jsp/ViewDupPatDetailsMain.jsp?Patient_ID='+p_patient_id,arguments,features);
		await window.showModalDialog('../../eMP/jsp/ViewPatDetailsMain.jsp?disp_dup_pat_dtls=Duplicate&Patient_ID='+p_patient_id,arguments,features);
	}
	else 
	{
		await window.showModalDialog('../../eMP/jsp/ViewPatDetailsMain.jsp?Patient_ID='+p_patient_id,arguments,features);
	}
}


function callDupFunction(start,end,whereclause)
{
	parent.frames[1].location.href='../../eDR/jsp/MergedPatientIDHeader.jsp?from='+(start)+'&to='+(end)+'&whereclause='+whereclause;

}

function oldcallDuplicatesGroups()
{
	p_patient_id = parent.frames[2].document.forms[0].patient_id.value;

		parent.frames[4].location.href='/eHIS/eDR/jsp/MergedPatientIDDetails.jsp?patient_id='+p_patient_id;
		
}

function reset()
{
	f_query_add_mod.location.href="../../eDR/jsp/MergedPatientIDFrameset.jsp";
frames(1).frames(1).document.forms[0].reset();
for( k=0;k<3;k++)
frames(1).frames(1).document.getElementById("tb1").rows(frames(1).frames(1).prev).cells(k).style.backgroundColor="";
frames(1).frames[3].document.forms[0].reset();
frames(1).frames[5].document.location.href = '../../eCommon/html/blank.html'

}

function onSuccess()
{

}

function touppercase(obj)
{
	obj.value = obj.value.toUpperCase();
}
