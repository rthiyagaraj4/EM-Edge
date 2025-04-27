/*
	Created on : 22/02/2002
	Created by : sudhakaran.P

*/
//**** FUNCTION # 1 : This function is used for selecting the patient_id from common search *****///
function deleterecord()
{
	
	if(frames[1].frames[5].document.forms[0])
	{
			var p_line=frames[1].frames[5].document.forms[0].p_line.value;
			var count=frames[1].frames[5].document.forms[0].count.value;
			var loops;
			var final_chk_value='';
			var count_del=0;
			for(loops=1;loops<=count;loops++){
			var var_pline = eval("frames[1].frames[5].document.forms[0].p_value"+loops).value;
			var del_pat   = eval("frames[1].frames[5].document.forms[0].selectpatient"+loops);
			if (del_pat.checked==true)
			{
				count_del++;

			if(count_del==1) final_chk_value = var_pline+'~'+'L';
			else
				final_chk_value += '|' + var_pline+'~'+'L';
			}

			}
			if(count_del==0)
			{
				var ErrorText = getMessage('ATLEAST_ONE_CHECK_BEF_DEL','DR');
				parent.frames[2].frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
			}		
			else if(count_del==1&&count==2)
			{
					if(confirm(getMessage('DELETE_RECORD','Common')))
					{
					//if(confirm(getMessage('CONFIRM_FOR_DELETION_GRP'))){
					frames[1].frames[5].document.forms[0].final_chk_values.value=final_chk_value;
					frames[1].frames[5].document.forms[0].del_header.value='Y';
					frames[1].frames[5].document.forms[0].function_name.value='D';
					frames[1].frames[5].document.forms[0].submit();    
				/*	}
					else
						parent.frames[1].frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num=";*/
					}
					else
						parent.frames[2].frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num=";
			}		
			else
			{
			frames[1].frames[5].document.forms[0].final_chk_values.value=final_chk_value;
			if (count_del==count)
			frames[1].frames[5].document.forms[0].del_header.value='Y';
			frames[1].frames[5].document.forms[0].function_name.value='D';
			if(confirm(getMessage('DELETE_RECORD','Common')))
				frames[1].frames[5].document.forms[0].submit();    
			else
				parent.frames[2].frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num=";
			}
	}
	else
	{
		    messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
				return false;
	}
}
async function callPatientSearch()
{
	var ErrorText = '';
	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;

//	var p_patient_id = PatientSearch('','','','','','','','','','','DR_VALID_DUPLICATE_PATIENT');
	var p_patient_id = await PatientSearch('','','','','','','','','','','');

	if (p_patient_id != null)
	{
	document.location.href='../../eDR/jsp/IdentifyValidDuplicateSearch.jsp?patient_id='+p_patient_id;
	}
	else
	{
		var ErrorText = getMessage('PATIENT_NOT_SELECTED','DR');
		parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;	
	}
}
//FUNCTION # 2: This function is for display the Group Details frame
function callDupGroupDetails(p_patient_id,p_dup_group_id,p_pat_count)
{
		var ErrorText = '';	
		parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;

		parent.frames[1].document.forms[0].p_patcount.value = 1;
		var modal=parent.frames[1].document.forms[0].modal.value;
		parent.frames[5].location.href='../../eDR/jsp/IdentifyValidDuplicateDetails.jsp?patient_id='+p_patient_id+'&modal='+modal+'&p_pat_count='+p_pat_count;

		parent.frames[4].document.forms[0].duplicatesdetails.disabled = false;		
		parent.frames[3].location.href='../../eDR/jsp/IdentifyValidDuplicateSearch.jsp?patient_id=';
}
//FUNCTION # 3: This function is for display the Duplicate Details modal window
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
			var dialogHeight= "70vh" ;
			var dialogWidth	= "80vw" ;
			var dialogTop	="68";
			var dialogLeft	="30";
			var scroll = "yes";
			var p_dup_group_id=p_dup_group_id;
			var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no; center=yes; scroll="+scroll; ;
			await window.showModalDialog('../../eDR/jsp/PossibleDuplicateDisplayFrameset.jsp?p_patient_id1='+p_patient_id1+'&p_dup_group_id='+p_dup_group_id+'&title='+title,arguments,features);
		}
		
		
	}
}


//FUNCTION # 2: This function is for display the Group Details frame
async function callSearchCriteria()
{
	var ErrorText = '';
	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;

	var title = getLabel("Common.SearchCriteria.label","Common");
	var dialogHeight= "76vh" ;
	var dialogWidth	= "80vw" ;
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

	
	if (p_patient_id.length != 0) {	  		
		parent.frames[5].location.href='../../eDR/jsp/IdentifyValidDuplicateDetails.jsp?patient_id='+p_patient_id;
		parent.frames[4].document.forms[0].duplicatesdetails.disabled = true;
	} else { 		
		//parent.frames[1].location.href='../../eDR/jsp/IdentifyValidDuplicateHeader.jsp';
		//parent.frames[2].location.href='../../eDR/jsp/IdentifyValidDuplicateArrow.jsp';
		parent.frames[5].location.href='../../eCommon/html/blank.html';
		//parent.frames[5].location.href='../../eDR/jsp/IdentifyValidDuplicateDetails.jsp';
		parent.frames[4].document.forms[0].duplicatesdetails.disabled = true;
	}
}


function checkDuplicatesDetails(p_patient_id,count)
{
	var obj = eval("parent.frames[5].document.forms[0].selectpatient"+count) ;
	if (obj.checked == true)
	{
		var obj1= eval("parent.frames[5].document.forms[0].dupindicator"+count+"[0].disabled=true");
		var obj1= eval("parent.frames[5].document.forms[0].dupindicator"+count+"[1].disabled=true");
		var obj1= eval("parent.frames[5].document.forms[0].dupindicator"+count+"[2].disabled=true");
		var obj1= eval("parent.frames[5].document.forms[0].dupindicator"+count+"[3].disabled=true");
		/*
		var obj1= eval("parent.frames[5].document.forms[0].dupindicator"+count+"(0).checked=false");
		var obj1= eval("parent.frames[5].document.forms[0].dupindicator"+count+"(1).checked=false");
		var obj1= eval("parent.frames[5].document.forms[0].dupindicator"+count+"(2).checked=false");
		var obj1= eval("parent.frames[5].document.forms[0].dupindicator"+count+"(3).checked=false");
		*/
	}
	else
	{
		var obj1= eval("parent.frames[5].document.forms[0].dupindicator"+count+"[0].disabled=false");
		var obj1= eval("parent.frames[5].document.forms[0].dupindicator"+count+"[1].disabled=false");
		var obj1= eval("parent.frames[5].document.forms[0].dupindicator"+count+"[2].disabled=false");
		var obj1= eval("parent.frames[5].document.forms[0].dupindicator"+count+"[3].disabled=false");		
	}
	if(obj.checked == true)
	{
		parent.frames[5].document.forms[0].patcount.value		= parseInt(parent.frames[5].document.forms[0].patcount.value) + 1;
		/*if (parseInt(parent.frames[5].document.forms[0].patcount.value) > 2)
		{
			var ErrorText = getMessage('ONLY_TWO');
			parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
			obj.checked = false;
			parent.frames[5].document.forms[0].patcount.value		= parseInt(parent.frames[5].document.forms[0].patcount.value) - 1;
		}		
		else 
		{*/
		if(parent.frames[5].document.forms[0].patient_id1.value.length == 0)
		{
			parent.frames[5].document.forms[0].patient_id1.value = p_patient_id;
		}
		else if(parent.frames[5].document.forms[0].patient_id2.value.length == 0)
		{
			parent.frames[5].document.forms[0].patient_id2.value = p_patient_id;
		}
		//}
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
		parent.frames[1].document.getElementById("tb1").rows[prev].cells[i].style.backgroundColor=obj.bgColor;
	for(i=0;i<n;i++)
		obj.cells[i].style.backgroundColor="#B2B6D7";
	prev	=obj.rowIndex;

}

async function viewPatientDetails(p_patient_id)
{
	var title = getLabel("eMP.ViewPatientDetails.label","MP");
	var dialogHeight= "70" ;
	var dialogWidth	= "80" ;
	var dialogTop="0";
	var dialogLeft="0";
	var prev="prev";
	var display="display";
	var features= "dialogHeight:" + dialogHeight + "%; dialogWidth:" + dialogWidth+ "%; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	await window.showModalDialog('../../eMP/jsp/ViewPatDetailsMain.jsp?display='+display+'&Patient_ID='+p_patient_id,arguments,features);
}
function callDupFunction(start,end,maxRecord)
{
	parent.frames[1].location.href='../../eDR/jsp/IdentifyValidDuplicateHeader.jsp?from='+(start)+'&to='+(end)+'&grp_no='+maxRecord;
}
function oldcallDuplicatesGroups()
{
	p_patient_id = parent.frames[2].document.forms[0].patient_id.value;

		parent.frames[4].location.href='../../eDR/jsp/IdentifyValidDuplicateDetails.jsp?patient_id='+p_patient_id;
		parent.frames[3].document.forms[0].duplicatesdetails.disabled = true;

}


function modal_apply()
{
	if(parent.parent.frames[1].frames[5].document.forms[0])
	{
		var p_line=parent.parent.frames[1].frames[5].document.forms[0].p_line.value;
		var count=parent.parent.frames[1].frames[5].document.forms[0].count.value;
	}

var loops;
var final_chk_value='';
var count_v=0;
var count_d=0;
for(loops=1;loops<=count;loops++)
{
var var_chk = eval("parent.parent.frames[1].frames[5].document.forms[0].chk_value"+loops).value;
var var_pline = eval("parent.parent.frames[1].frames[5].document.forms[0].p_value"+loops).value;
		if(var_chk=='V')
		{
		count_v++;
		}
		else if(var_chk=='D')
		{
		count_d++;
		}
		if(var_chk=='U')
			var_chk='X';
	if(loops==1) final_chk_value = var_pline+'~'+var_chk;
	else{
		final_chk_value += '|' + var_pline+'~'+var_chk;
		}
}


if(count_v ==0)
{
	var ErrorText = getMessage('ONE_MAIN_AND_ATLEAST_ONE_DUPLICATE','DR');
	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
		
}
else if(count_v>1){

	var ErrorText = getMessage('ONLY_ONE_MAIN','DR');
	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
	
}
else if(count_v ==1){
	if(count_d<1){
		var ErrorText = getMessage('ONE_MAIN_AND_ATLEAST_ONE_DUPLICATE','DR');
	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
	}
	else{
	parent.parent.frames[1].frames[5].document.forms[0].final_chk_values.value=final_chk_value;	
	parent.parent.frames[1].frames[5].document.forms[0].submit(); 
	}
}

}

function apply() {
    if (frames[1].frames[5].document.forms[0]) {
        var p_line = frames[1].frames[5].document.forms[0].p_line.value;
        var count = frames[1].frames[5].document.forms[0].count.value;
        var loops;
        var final_chk_value = '';
        var count_v = 0;
        var count_d = 0;
        var count_e = 0;
        var count_del = 0;
        var isMessageShown = false; // Flag to prevent multiple message triggers

        for (loops = 1; loops <= count; loops++) {
            var var_chk = eval("frames[1].frames[5].document.forms[0].chk_value" + loops).value;
            var var_pline = eval("frames[1].frames[5].document.forms[0].p_value" + loops).value;
            var del_pat = eval("frames[1].frames[5].document.forms[0].selectpatient" + loops);

            if (var_chk == 'E' && del_pat.checked == false) {
                count_e++;
            }
            if (var_chk == 'V' && del_pat.checked == false) {
                count_v++;
            } else if (var_chk == 'D' && del_pat.checked == false) {
                count_d++;
            }
            if (var_chk == 'U') {
                var_chk = 'X';
                count_del++;
            }
            if (del_pat.checked == true) {
                var_chk = 'L';
            }
            if (loops == 1)
                final_chk_value = var_pline + '~' + var_chk;
            else
                final_chk_value += '|' + var_pline + '~' + var_chk;
        }

        if (count_e > 0 && count_v == 0 && count_d == 0) {
            frames[1].frames[5].document.forms[0].final_chk_values.value = final_chk_value;
            frames[1].frames[5].document.forms[0].exclude_mode.value = "Y";
            frames[1].frames[5].document.forms[0].submit();
        } else {
            if (count_v == 0) {
                if (!isMessageShown) {
                    var ErrorText = getMessage('ONE_MAIN_AND_ATLEAST_ONE_DUPLICATE', 'DR');
                    parent.frames[2].frames[2].location.href = "../../eCommon/jsp/error.jsp?err_val=&err_num=" + ErrorText;
                    isMessageShown = true; // Set flag after message is shown
                }
            } else if (count_v > 1) {
                if (!isMessageShown) {
                    var ErrorText = getMessage('ONLY_ONE_MAIN', 'DR');
                    parent.frames[2].frames[2].location.href = "../../eCommon/jsp/error.jsp?err_val=&err_num=" + ErrorText;
                    isMessageShown = true; // Set flag after message is shown
                }
            } else if (count_v == 1) {
                if (count_d < 1) {
                    if (!isMessageShown) {
                        var ErrorText = getMessage('ONE_MAIN_AND_ATLEAST_ONE_DUPLICATE', 'DR');
                        parent.frames[2].frames[2].location.href = "../../eCommon/jsp/error.jsp?err_val=&err_num=" + ErrorText;
                        isMessageShown = true; // Set flag after message is shown
                    }
                } else {
                    frames[1].frames[5].document.forms[0].final_chk_values.value = final_chk_value;
                    frames[1].frames[5].document.forms[0].submit();
                    parent.frames[2].frames[1].frames[0].location.reload();
                    parent.frames[2].frames[1].frames[1].location.reload();
                    parent.frames[2].frames[1].frames[3].location.reload();
                    parent.frames[2].frames[1].frames[4].location.reload();
                }
            }
        }
    } else {
        messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }
}



function assign_value(obj,i)
{
	var va= parent.frames[5].document.forms[0].name;
	var va = eval("parent.frames[5].document.forms[0].chk_value"+i);
	if(obj.value =='V')
		va.value='V';
	if(obj.value =='D')
		va.value='D';
	if(obj.value =='X')
		va.value='X';
	if(obj.value =='E')
		va.value='E';
}


function onSuccess()
{
	if(top.document.getElementById('dialog-body') != null)
	{
		if(top.document.getElementById('dialog-body').contentWindow.frames[1].frames[1].document.forms[0]!=null)
		{
			top.document.getElementById('dialog-body').contentWindow.frames[1].location.href='../../eDR/jsp/IdentifyValidDuplicatesFrameset.jsp';
			top.document.getElementById('dialog-body').contentWindow.frames[1].frames[5].location.href='../../eCommon/html/blank.html';			
			top.window.document.getElementById('dialog-body').contentWindow.returnValue = "Y";
			top.window.document.getElementById('dialog_tag').close();
		}
	}

	else
	{
		parent.parent.frames[2].frames[1].frames[0].location.reload();
		parent.parent.frames[2].frames[1].frames[1].location.reload();
		parent.parent.frames[2].frames[1].frames[2].location.reload();
		parent.parent.frames[2].frames[1].frames[3].location.reload();
		parent.parent.frames[2].frames[1].frames[4].location.reload();
		parent.parent.frames[2].frames[1].frames[5].location.href='../../eCommon/html/blank.html';
		var ErrorText = getMessage('RECORD_INSERTED','SM');
		alert(ErrorText);
	}
}

function reset()
{ 
	
	if(frames[1].frames[3].document.forms[0].name=="search_form")
	{   
		 frames[1].frames[3].document.forms[0].reset();
		// parent.frames[2].frames[1].frames[0].document.getElementById("pat_name1").innerHTML='';
		 frames[1].frames[3].document.forms[0].patient_id.value='';
		// frames[1].frames[3].document.location.href='../../eCommon/html/blank.html';
	frames[1].frames[4].document.forms[0].duplicatesdetails.disabled =true;
	frames[1].frames[5].location.href= '../../eCommon/html/blank.html';
	}
  /*<--f_query_add_mod.location.href="../../eDR/jsp/MergedPatientIDFrameset.jsp";
	//parent.parent.document.frames[1].location.reload();  */
else{	frames[1].frames[1].document.forms[0].reset();
	for( k=0;k<3;k++)
	frames[1].frames[1].document.getElementById("tb1").rows(frames[1].frames[1].prev).cells(k).style.backgroundColor="";
	frames[1].frames[3].document.forms[0].reset();
	frames[1].frames[5].document.location.href = '../../eCommon/html/blank.html' 
}
}

function touppercase(obj)
{
	obj.value = obj.value.toUpperCase();
}


async function encounterdetails(p_patient_id1)
{
	var title	= getLabel("Common.encounterdetails.label","Common");
	var facilityid='HS';
	var patient_id="patient_id";
	var fid="DR";
	
			var dialogHeight= "80" ;
			var dialogWidth	= "80" ;
			var dialogTop	="0";
			var dialogLeft	="0";
			var scroll = "yes";
			var p_dup_group_id=p_dup_group_id;
			var features= "dialogHeight:" + dialogHeight + "vh; dialogWidth:" + dialogWidth+ "vw; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no; center=yes; scroll="+scroll; ;
	    	await window.showModalDialog('../../eMR/jsp/vwEncounterDetailFrame.jsp?patientid='+p_patient_id1+'&fid='+fid+'&order_by='+patient_id+'&facility='+facilityid+'&title='+title,arguments,features);
		//	Commented the below code for Incident IN022685 by Suresh M	on 15 July 2010
			//window.close();
}
