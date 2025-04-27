function replace(str,pos,chr){

	var len= str.length;
	return(str.substr(0,parseInt(pos))+chr+str.substr(parseInt(pos)+1,len));
}

function replaceStr(str,start,end,str1){

	var len =str.length;
	return(str.substr(0,parseInt(start))+str1+str.substr(parseInt(end)+1,len))
}

async function callPatientSearch() {

	var ErrorText = '';
	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
	//var p_patient_id = PatientSearch('','','','','','','','','','','DR_MERGED_PATIENT_ID');
	var p_patient_id = await PatientSearch('','','','','','','','','','','');

	if (p_patient_id != null)
	{
		document.location.href='../../eDR/jsp/MergeDuplicateSearch.jsp?patient_id='+p_patient_id;
	}
	else
	{
		var ErrorText = getMessage('PATIENT_NOT_SELECTED','DR');
		parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;	
	}
}

function callDupGroupDetails(p_patient_id,p_dup_group_id,p_pat_count) {

		var ErrorText = '';
		parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
		parent.frames[1].document.forms[0].p_patcount.value = 1;	
		parent.frames[5].location.href='../../eDR/jsp/MergeDuplicateDetails.jsp?patient_id='+p_patient_id+'&p_pat_count='+p_pat_count;
		
}

async function callDuplicatesDetails() {

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
			var dialogHeight= "20vh" ;
			var dialogWidth	= "28vw" ;
			var dialogTop="30";
			var dialogLeft="30";
			var scroll = "yes";
			var p_dup_group_id=p_dup_group_id;
			var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no; center=yes; scroll="+scroll; ;
			await window.showModalDialog('../../eDR/jsp/MergeDuplicateDisplayFrameset.jsp?p_patient_id1='+p_patient_id1+'&p_patient_id2='+p_patient_id2+'&title='+title,arguments,features);
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
			var dialogHeight= "20vh" ;
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
			await window.showModalDialog('../../eDR/jsp/MergeDuplicateDisplayFrameset.jsp?p_dup_group_id='+p_dup_group_id+'&title='+title,arguments,features);
		}
	}
}

function callSearchCriteria() {

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

function callDuplicatesGroups() {

	var facility1=parent.frames[3].document.forms[0].facility.value;
	parent.frames[5].location.href='../../eCommon/html/blank.html';
	
	var ErrorText = '';
	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
	p_patient_id = parent.frames[3].document.forms[0].patient_id.value;
	if (p_patient_id.length != 0)
	{
		parent.frames[0].location.href='../../eDR/jsp/MergeDuplicateHeaderTitle.jsp?facility1='+facility1+'&patient_id='+p_patient_id+'&fromPage=2';
		parent.frames[1].location.href='../../eDR/jsp/MergeDuplicateHeader.jsp?facility1='+facility1+'&patient_id='+p_patient_id+'&fromPage=2';
		parent.frames[5].location.href='../../eDR/jsp/MergeDuplicateDetails.jsp?patient_id='+p_patient_id+'&facility1='+facility1+'&fromPage=2';
	}
	else
	{
		parent.frames[0].location.href='../../eDR/jsp/MergeDuplicateHeaderTitle.jsp?facility1='+facility1+'&fromPage=2';
		parent.frames[1].location.href='../../eDR/jsp/MergeDuplicateHeader.jsp?facility1='+facility1+'&fromPage=2';
		parent.frames[2].location.href='../../eDR/jsp/MergeDuplicateArrow.jsp';
	}
}

function checkDuplicatesDetails(p_patient_id,count) {

	var ErrorText = '';
	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
	var obj = eval("parent.frames[5].document.forms[0].selectpatient"+count) ;
	if(obj.checked == true)
	{
		parent.frames[5].document.forms[0].patcount.value		= parseInt(parent.frames[5].document.forms[0].patcount.value) + 1;
		if(parseInt(parent.frames[5].document.forms[0].patcount.value) > 2)
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

function changeRowColor1(obj,n) {

	for(i=0;i<n;i++)
		parent.frames[1].document.getElementById("tb1").rows(prev).cells(i).style.backgroundColor=obj.bgColor;
	for(i=0;i<n;i++)
		obj.cells(i).style.backgroundColor="#B2B6D7";
	prev	=obj.rowIndex;
}

function viewPatientDetails(p_patient_id) {
	var title = getLabel("eMP.ViewPatientDetails.label","MP");
	var dialogHeight= "1700px" ;
	var dialogWidth	= "1200px" ;
	var dialogTop="65";
	var dialogLeft="1";	
	var prev="prev";
	var display="display";
	var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	window.showModalDialog('../../eMP/jsp/ViewPatDetailsMain.jsp?display='+display+'&Patient_ID='+p_patient_id,arguments,features);
}

function callDupFunction(start,end,whereclause) { 
		
	
	if(parent.frames[1].document.forms[0].sel_all.checked==true)
	{
	parent.parent.frames[1].frames[4].document.forms[0].start_now.disabled=false;
	}
	obJ1=parent.frames[0].document.forms[0];
	obJ2=parent.frames[1].document.forms[0];
   
	
	chr=(obJ1.CheckBoxes.value).substr(parseInt(obJ2.endd.value),1)
	obJ2.chkedVls.value="";
	
	//obJ1.dup_group_id.value = parent.frames[1].document.forms[0].dupGroupId.value + obJ1.dup_group_id.value;
	for(i=1;i<10;i++) 
	{
		if(eval("parent.frames[1].document.forms[0].selectpatient"+i))
		{
			if (eval("parent.frames[1].document.forms[0].selectpatient"+i).checked==true)
			{
				obJ2.chkedVls.value+=i;
				//obJ1.dup_group_id.value+=eval("parent.frames[1].document.forms[0].dup_group_id"+i).value+"|";
			}
		    else obJ2.chkedVls.value+="0";
		}
		else obJ2.chkedVls.value+="0";
	}
	obJ1.CheckBoxes.value=(replaceStr(obJ1.CheckBoxes.value,parseInt(obJ2.start.value)-1,parseInt(obJ2.endd.value)-1,obJ2.chkedVls.value));
	var str=obJ1.CheckBoxes.value;
       if(str==null || str=='') str='';
	obj=parent.frames[0].document.forms[0];
	obj1=parent.frames[1].document.forms[0];
    var quotient=(parseInt(obj1.endd.value)/9)-1;
	if(obj1.sel_all.checked==false  && (obj.selAll.value).substr(quotient,1) == '')
	{
		//obj.selAll.value=replace(obj.selAll.value,quotient,'0');
	} 
   	//alert('Final Str'+obJ1.dup_group_id.value);
	parent.frames[1].location.href='../../eDR/jsp/MergeDuplicateHeader.jsp?from='+(start)+'&to='+(end)+'&whereclause='+whereclause+'&chkVls='+str+'&dupGroupId='+obJ1.dup_group_id.value+'&groupIdIndex='+quotient;

}

function oldcallDuplicatesGroups() {

	p_patient_id = parent.frames[2].document.forms[0].patient_id.value;
}

function apply()
{
	var p_line=frames[1].frames[5].document.forms[0].p_line.value;
	var count=frames[1].frames[5].document.forms[0].count.value;
	var loops;
	var final_chk_value='';
	var count_v=0;
	for(loops=1;loops<=count;loops++)
	{
		var var_chk = eval("frames[1].frames[5].document.forms[0].chk_value"+loops).value;
		var var_pline = eval("frames[1].frames[5].document.forms[0].p_value"+loops).value;
		if(var_chk=='V')
		{
			count_v++;
		}
		if(loops==1) final_chk_value = var_pline+'~'+var_chk;
		else
		{
			final_chk_value += '|' + var_pline+'~'+var_chk;
		}
	}
	if(count_v ==0)
	{
		var ErrorText = getMessage('ATLEAST_ONE_VALID','DR');
		parent.frames[1].frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
	}
	else if(count_v>1)
	{
		var ErrorText = getMessage('ONLY_ONE_MAIN','DR');
		parent.frames[1].frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
	}
	else if(count_v ==1)
	{
		frames[1].frames[5].document.forms[0].final_chk_values.value=final_chk_value;
		frames[1].frames[5].document.forms[0].submit();    
	}
}

function start_process_merge(obj) {
	
	var process=obj.name; 
	var final_chk_value='';
	var final_chk_value1='';
	var final_chk='';
	var currPage=parent.frames[1].document.forms[0].index.value;	
	var dupGroupId=parent.frames[1].document.forms[0].dupGroupId.value;		
	var count=parseInt(parent.frames[1].document.forms[0].count.value);
	
	for(loops=1;loops<=count;loops++)
	{
		var var_chk_tf = eval("parent.frames[1].document.forms[0].selectpatient"+loops).checked;
		if(var_chk_tf)
		{
			if(loops==1)
			{
				final_chk_value1 = eval("parent.frames[1].document.forms[0].dup_group_id"+loops).value;
			}
			else
			{
				final_chk_value1 += '|' + eval("parent.frames[1].document.forms[0].dup_group_id"+loops).value;
			}
		}
	}
	
	final_chk_value1=dupGroupId+final_chk_value1;
	/*		
	final_chk_value=parent.frames[1].document.forms[0].groupTotal.value; 	
	interStringArr=final_chk_value.split('~');
	interStringArr[currPage-1]=final_chk_value1+'|';
	for(i=0;i<interStringArr.length;i++)
	{
		final_chk+=interStringArr[i];
	} 
	final_chk=final_chk.replace('||','|');
	*/
	final_chk = final_chk_value1;
	var len=final_chk.length;
	if (final_chk.substr(len-1,1)=='|')
	{
		final_chk=final_chk.substr(0,len-1);
	}
	if (final_chk.substr(0,1)=='|')
	{
		final_chk=final_chk.substr(1,final_chk.length);
	}
	
	
	final_chk_value=final_chk;

	
	if(final_chk_value=='')
	{
		var ErrorText = getMessage('PATIENT_NOT_SELECTED','DR');
		parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
	}
	else
	{
		parent.frames[5].document.forms[0].p_final_dup_group_id.value=final_chk_value;
		if(process=="start_now")
		{
			parent.frames[5].document.forms[0].process_start.value="process_now";
			//return;
			parent.frames[5].document.forms[0].submit();
			}
		else if(process=="start_later")
		{
			if(parent.frames[4].document.forms[0].start_later_time.value=="")
			{
				errors = getMessage("DATE_TIME_NOT_BLANK","DR") ;
				parent.parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
				parent.frames[4].document.forms[0].start_later_time.focus();
			}
			else
			{
					
					if(validDateObj(parent.frames[4].document.forms[0].start_later_time,"DMYHM",localeName) == true)
				    {
					parent.frames[5].document.forms[0].process_start.value="process_later";	
					var start_later_time=parent.frames[4].document.forms[0].start_later_time.value;			
					parent.frames[5].document.forms[0].start_later_time.value=start_later_time;			
					//return;
					parent.frames[5].document.forms[0].submit();				
					}
					else
						return false;
			}
			/*else
			{
				var comp=parent.frames[4].document.forms[0].start_later_time;
				var senddate=parent.frames[4].document.forms[0].start_later_time.value;
				obj=senddate;
				var dttime = obj.split(" ");
				var dt
				var time
				var retval=true;
				if(dttime.length>1)
				{
					dt=dttime[0]
					time=dttime[1]
					if(!checkDt(dt) )
					{
						retval= false
						comp.focus()
					}
					else
					{
						if(time==null || time=="")
						{
							errors = getMessage("INVALID_DATETIME","DR") ;
							parent.parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
							parent.frames[4].document.forms[0].start_later_time.focus();
							retval= false;
							comp.focus()
						}
						else
						{
							if(!chkTime(time))
							{
								retval= false;
								errors = getMessage("INVALID_DATETIME","DR") ;
								parent.parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
								parent.frames[4].document.forms[0].start_later_time.focus();
								comp.focus()
							}
						}
					}
				}
				else
				{
					retval= false;
					errors = getMessage("INVALID_DATETIME","DR") ;
					parent.parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
					comp.focus();
					parent.frames[4].document.forms[0].start_later_time.focus();
				}
				if(retval)
				{
					parent.frames[5].document.forms[0].process_start.value="process_later";
					parent.frames[5].document.forms[0].start_later_time.value=parent.frames[4].document.forms[0].start_later_time.value;
					parent.frames[5].document.forms[0].submit();
				}
				else
				{
					errors = getMessage("INVALID_DATETIME","DR") ;
					parent.parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
					comp.focus();
					parent.frames[4].document.forms[0].start_later_time.focus();
				}
			}*/
	    }//else if	
	}
}

function onSuccess() {

	parent.frames[1].frames[1].location.href='../../eDR/jsp/MergeDuplicatesFrameset.jsp';
}

function sel_all_chk() {
	
	var count=parent.frames[1].document.forms[0].count.value;
	var s=0;

	if(parent.frames[1].document.forms[0].sel_all.checked==true)
	{
		enable_button();
		for(loops=1;loops<=count;loops++)
		{
			var var_chk = eval("parent.frames[1].document.forms[0].selectpatient"+loops).checked=true;			parent.frames[0].document.forms[0].dup_group_id.value+=eval("parent.frames[1].document.forms[0].dup_group_id"+loops).value+"|";
			
		}
	}
	else
	{
		disable_button();
		for(loops=1;loops<=count;loops++)
		{
			var var_chk = eval("parent.frames[1].document.forms[0].selectpatient"+loops).checked=false;
				checkedStr = parent.frames[0].document.forms[0].dup_group_id.value;
				curChk = eval("parent.frames[1].document.forms[0].dup_group_id"+loops).value;				
				var pos1 = checkedStr.indexOf(curChk);
				var pos2 = checkedStr.indexOf('|',pos1);
				var newStr1 =  checkedStr.slice(0,pos1);
				var newStr2 =  checkedStr.slice(pos2+1);				
				checkedStr =  newStr1+newStr2;	
				parent.frames[0].document.forms[0].dup_group_id.value = checkedStr;
		}
	}
	if(parent.frames[1].document.forms[0].sel_all.checked==false)
	{
		obj1=parent.frames[1].document.forms[0];
		obj=parent.frames[0].document.forms[0];
		var quotient = (parseInt(obj1.endd.value)/9)-1;
		var valAtPos=(obj.selAll.value).substr(quotient,1);
		if (valAtPos=='1') 
		obj.selAll.value=replace(obj.selAll.value,quotient,'0');
		else if (valAtPos=='0') obj.selAll.value=replace(obj.selAll.value,quotient,'1');
	}
	if(parent.frames[1].document.forms[0].sel_all.checked==true)
	{
		obj=parent.frames[0].document.forms[0];
		obj1=parent.frames[1].document.forms[0];
		var quotient=(parseInt(obj1.endd.value)/9)-1;
		
		if (obj1.sel_all.checked==true  && ((obj.selAll.value).substr(quotient,1)=='' || (obj.selAll.value).substr(quotient,1)=='0')  )
		{
	//	obj.selAll.value=replace(obj.selAll.value,quotient,'1');
				} 
	} 
}

var chkArr	= new Array();
var chkStr	= "";


function chk_slt_all(obj,k)
{
	
	if ( parent.frames[1].document.forms[0].chkedVls.value=='')
	{
		if (parent.frames[1].document.forms[0].sel_all.checked==false ) chkStr="000000000";
		else cksStr="123456789";
	}
	if (obj.checked==true)
	{
		chkStr=replace(chkStr,parseInt(k)-1,k);
		parent.frames[1].document.forms[0].chkedVls.value=chkStr;
		parent.frames[0].document.forms[0].dup_group_id.value+=eval("parent.frames[1].document.forms[0].dup_group_id"+k).value+"|";
	}
	if(obj.checked==false)
	{
		var idx=	chkStr.indexOf(k);
	   chkStr=chkStr.replace(k,'0');
		parent.frames[1].document.forms[0].chkedVls.value=chkStr;
		parent.frames[1].document.forms[0].sel_all.checked=false;
		var count=parent.frames[1].document.forms[0].count.value;
		var check_flag ="";
		for(loops=1;loops<=count;loops++)
		{
			if (eval("parent.frames[1].document.forms[0].selectpatient"+loops).checked==true)
			check_flag ="Y";
		}
				
				checkedStr = parent.frames[0].document.forms[0].dup_group_id.value;
				curChk = eval("parent.frames[1].document.forms[0].dup_group_id"+k).value;				
				var pos1 = checkedStr.indexOf(curChk);
				var pos2 = checkedStr.indexOf('|',pos1);
				var newStr1 =  checkedStr.slice(0,pos1);
				var newStr2 =  checkedStr.slice(pos2+1);				
				checkedStr =  newStr1+newStr2;	
				parent.frames[0].document.forms[0].dup_group_id.value = checkedStr;
				
		if (check_flag !="Y")
		disable_button();
	}
	else enable_button();
	
	if(parent.frames[1].document.forms[0].sel_all.checked==false)
	{
		obj1=parent.frames[1].document.forms[0];
		obj=parent.frames[0].document.forms[0];
		var quotient = (parseInt(obj1.endd.value)/9)-1;
		var valAtPos=(obj.selAll.value).substr(quotient,1);
		if (valAtPos=='1') 
		obj.selAll.value=replace(obj.selAll.value,quotient,'0');
		 else if (valAtPos=='0') 
			 obj.selAll.value=replace(obj.selAll.value,quotient,'1');
	}
}

function enable_button() {

	parent.parent.frames[1].frames[4].document.forms[0].start_now.disabled=false;
	parent.parent.frames[1].frames[4].document.forms[0].start_later.disabled=false;
	parent.parent.frames[1].frames[4].document.forms[0].start_later_time.disabled=false;
	parent.parent.frames[1].frames[4].document.getElementById("datepicker").disabled=false;
}

function disable_button() {
	
	parent.parent.frames[1].frames[4].document.forms[0].start_now.disabled=true;
	parent.parent.frames[1].frames[4].document.forms[0].start_later.disabled=true;
	parent.parent.frames[1].frames[4].document.forms[0].start_later_time.value='';
	parent.parent.frames[1].frames[4].focus();
	parent.parent.frames[1].frames[4].document.forms[0].start_later_time.disabled=true;

	parent.parent.frames[1].frames[4].document.getElementById("datepicker").disabled=true;
}

function reset() {
	
	frames[1].frames[1].document.forms[0].reset();
	for( k=0;k<3;k++)
	{
		frames[1].frames[1].document.getElementById("tb1").rows[frames[1].frames[1].prev].cells[k].style.backgroundColor="";
	}
	
	frames[1].frames[3].document.forms[0].reset();
	frames[1].frames[4].document.forms[0].start_now.disabled=true;
	frames[1].frames[4].document.forms[0].start_later.disabled=true;
	frames[1].frames[4].document.forms[0].start_later_time.disabled=true;
	frames[1].frames[5].document.location.href = '../../eDR/jsp/MergeDuplicateDetails.jsp'
}

function touppercase(obj) {

	obj.value = obj.value.toUpperCase();
}

function callChk() {
	
	var chkValue="0";
	obj=parent.frames[1].document.forms[0];
	obj1=parent.frames[0].document.forms[0];
	if (obj.start && obj1!=null){
		quotient= (parseInt(obj.endd.value)/9)-1;
		chkValue=(obj1.selAll.value).substr(quotient,1);
		if (chkValue=='1')
		{
			parent.frames[1].document.forms[0].sel_all.checked=true;
			for (i=1;i<=9 ;i++ )
			{
				if (eval("parent.frames[1].document.forms[0].selectpatient"+i))
				eval("parent.frames[1].document.forms[0].selectpatient"+i).checked=true;
			}
		}
	}
}

function start_nowClick() 
{ 
	srcObj=event.target;
	start_process_merge(srcObj);

}

function later_Click()
{
	var Obj=document.forms[0].start_later_time;
	var givenDate=Obj.value ;
	if(givenDate=='')
		alert(getMessage("DATE_TIME_NOT_BLANK","DR"));
	else
	{
		srcObj=event.target;
		start_process_merge(srcObj);
	}

	
}
