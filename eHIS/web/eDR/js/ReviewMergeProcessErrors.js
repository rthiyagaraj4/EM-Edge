/*
	Created on : 22/02/2002
	Created by : sudhakaran.P

*/
var p_update_string = '';
function replace(str,pos,chr){

	var len= str.length;
	return(str.substr(0,parseInt(pos))+chr+str.substr(parseInt(pos)+1,len));
}

async function callPatientSearch()
{
	var ErrorText = '';
	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;

	var p_patient_id = await PatientSearch();

	if (p_patient_id != null)
	{
		document.location.href='../../eDR/jsp/ReviewMergeProcessErrorsSearch.jsp?patient_id='+p_patient_id;

	}
	else
	{
			var ErrorText = getMessage('PATIENT_NOT_SELECTED','DR');
			parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;	}
}

function callDupGroupDetails(p_patient_id,p_dup_group_id,p_pat_count,status_upd_date)
{	
		var ErrorText = '';
		parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;

		parent.frames[1].document.forms[0].p_patcount.value = 1;	
		parent.frames[5].location.href='../../eDR/jsp/ReviewMergeProcessErrorsDetails.jsp?patient_id='+p_patient_id+'&p_pat_count='+p_pat_count+'&p_status_upd_date='+status_upd_date;

		//parent.frames[4].document.forms[0].duplicatesdetails.disabled = false;
		parent.frames[3].location.href='../../eDR/jsp/ReviewMergeProcessErrorsSearch.jsp?patient_id=';
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
			window.showModalDialog('../../eDR/jsp/ReviewMergeProcessErrorsDisplayFrameset.jsp?p_patient_id1='+p_patient_id1+'&p_patient_id2='+p_patient_id2+'&title='+title,arguments,features);
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
			window.showModalDialog('../../eDR/jsp/ReviewMergeProcessErrorsDisplayFrameset.jsp?p_dup_group_id='+p_dup_group_id+'&title='+title,arguments,features);
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

	p_patient_id = parent.frames[3].document.forms[0].patient_id.value;
	
	if (p_patient_id.length != 0)
		{
			parent.frames[5].location.href='../../eDR/jsp/ReviewMergeProcessErrorsDetails.jsp?patient_id='+p_patient_id;
			//parent.frames[4].document.forms[0].duplicatesdetails.disabled = true;
		}
	else
		{
			parent.frames[1].location.href='../../eDR/jsp/ReviewMergeProcessErrorsHeader.jsp';
			parent.frames[2].location.href='../../eDR/jsp/ReviewMergeProcessErrorsArrow.jsp';
			parent.frames[5].location.href='../../eCommon/html/blank.html';
			//parent.frames[4].document.forms[0].duplicatesdetails.disabled = true;
		}
}


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

function viewPatientDetails(p_patient_id)
{
	var title = getLabel("eMP.ViewPatientDetails.label","MP");
	var dialogHeight= "90" ;
	var dialogWidth	= "90" ;
	var dialogTop="0";
	var dialogLeft="0";	
	var prev="prev";
	var display="display";
	var features= "dialogHeight:" + dialogHeight + "%; dialogWidth:" + dialogWidth+ "%; dialogLeft:" +dialogLeft+ "px; dialogTop:" +dialogTop+ "px; status=no" ;
	window.showModalDialog('../../eMP/jsp/ViewPatDetailsMain.jsp?display='+display+'&Patient_ID='+p_patient_id,arguments,features);
}


function callDupFunction(start,end,whereclause)
{	
	
	var p_update_string1="";
   var count=0;
	var flag=
	obJ1=parent.frames[0].document.forms[0];
	obJ2=parent.frames[1].document.forms[0];
  	chr=(obJ1.CheckBoxes.value).substr(parseInt(obJ2.endd.value),1)
	obJ2.chkedVls.value="";
	obJ1.dup_group_id.value="";
		
	for(i=1;i<10;i++) 
	{
		if(eval("parent.frames[1].document.forms[0].selectpatient"+i))
		{
			if (eval("parent.frames[1].document.forms[0].selectpatient"+i).checked==true)
			{
				obJ2.chkedVls.value+=i;
				//obJ1.dup_group_id.value+=eval("parent.frames[1].document.forms[0].dup_group_id"+i).value+"|";						
			}
		    else 
				obJ2.chkedVls.value+="0";
		}
		else 
			obJ2.chkedVls.value+="0";
	}	
obJ1.CheckBoxes.value=(replaceStr(obJ1.CheckBoxes.value,parseInt(obJ2.start.value)-1,parseInt(obJ2.endd.value)-1,obJ2.chkedVls.value));
	
	var str=obJ1.CheckBoxes.value;
	//var str= obJ2.chkedVls.value
	if(str==null || str=='') str='';
    obj=parent.frames[0].document.forms[0];
	obj1=parent.frames[1].document.forms[0];
    var quotient=(parseInt(obj1.endd.value)/9)-1;
	if(obj1.sel_all.checked==false  && (obj.selAll.value).substr(quotient,1) == '')
	{
		//obj.selAll.value=replace(obj.selAll.value,quotient,'1');	
	
	} 
  var total=parent.frames[1].document.forms[0].p_update_string1.value
  var count1=parent.frames[1].document.forms[0].count.value;
	 if(parent.frames[1].document.forms[0].sel_all.checked==true)
	{
			for(loops=1;loops<=count1;loops++)
			{
				p_update_string1= p_update_string1 + eval("parent.frames[1].document.forms[0].dup_group_id"+loops).value + '`' ;				
			}
	}
	else
	{		
		for(loops=1;loops<=count1;loops++)
		{
			var var_chk = eval("parent.frames[1].document.forms[0].selectpatient"+loops).checked;			
			if (var_chk == true)
			{					  
				p_update_string1 = p_update_string1 + eval("parent.frames[1].document.forms[0].dup_group_id"+loops).value + '`' ;			
				 if(total.indexOf(p_update_string1)!=-1 ){p_update_string1="";}
							
			}	
		}
	}	
  if(total.indexOf(p_update_string1)==-1 ){	
	p_update_string1=p_update_string1+total;
  } else {  
	p_update_string1 = total;
  }
	
	for(loops=1;loops<=count1;loops++){
		if(eval("parent.frames[1].document.forms[0].selectpatient"+loops).checked == false)
			{
			
				var check_id=eval("parent.frames[1].document.forms[0].dup_group_id"+loops).value;				
				if(p_update_string1.indexOf(check_id)!=-1)
					{				
						var pos1 = p_update_string1.indexOf(check_id);									
						var pos2 = p_update_string1.indexOf('`',pos1);					 
						var newStr1 =  p_update_string1.slice(0,pos1);							
						var newStr2 =  p_update_string1.slice(pos2+1);						
						p_update_string1 =  newStr1+newStr2;						
					}
			}
	}
	
	
parent.frames[1].location.href='../../eDR/jsp/ReviewMergeProcessErrorsHeader.jsp?from='+(start)+'&to='+(end)+'&whereclause='+whereclause+'&chkVls='+str+'&groupIdIndex='+quotient+'&p_update_string1='+p_update_string1;
}



//parent.frames[1].location.href='../../eDR/jsp/ReviewMergeProcessErrorsHeader.jsp?from='+(start)+'&to='+(end)+'&whereclause='+whereclause;




/*
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
	else{
		final_chk_value += '|' + var_pline+'~'+var_chk;
		}
}


if(count_v ==0)
{
	var ErrorText = getMessage('ATLEAST_ONE_VALID');
	parent.frames[1].frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
		
}
else if(count_v>1){
	var ErrorText = getMessage('ATLEAST_ONE_VALID');
	parent.frames[1].frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
	
}
else if(count_v ==1){
	frames[1].frames[5].document.forms[0].final_chk_values.value=final_chk_value;
	frames[1].frames[5].document.forms[0].submit();    
}

}
*/



function start_process_merge(obj){

var process=obj.name; 
var final_chk_value='';
var count=parent.frames[1].document.forms[0].count.value;
for(loops=1;loops<=count;loops++)
{
	var var_chk_tf = eval("parent.frames[1].document.forms[0].selectpatient"+loops).checked;
		if(var_chk_tf)
			{
				
				if(loops==1){
				final_chk_value = eval("parent.frames[1].document.forms[0].dup_group_id"+loops).value;
				}else{
				final_chk_value += '|' + eval("parent.frames[1].document.forms[0].dup_group_id"+loops).value;
				}
			}
		

}

if(final_chk_value=='')
{

var ErrorText = getMessage('PATIENT_NOT_SELECTED','DR');
parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
			
}
else{

parent.frames[5].document.forms[0].p_final_dup_group_id.value=final_chk_value;

		if(process=="start_now")
		{
		
		parent.frames[5].document.forms[0].process_start.value="process_now";
		parent.frames[5].document.forms[0].submit();
		}
		else if(process=="start_later")
		{
					if(parent.frames[5].document.forms[0].start_later_time.value=="")
					{					
					alert(getMessage("START_LATER_DATE_BLANK","DR"));
					parent.frames[5].document.forms[0].start_later_time.focus();
					}
					else{
						parent.frames[5].document.forms[0].process_start.value="process_later";
						parent.frames[5].document.forms[0].submit();}
	    }//else if	

}




}


function onSuccess(){
document.frames[1].location.reload();
}


function sel_chk()
{
var count=parent.frames[1].document.forms[0].count.value;
}

 function sel_chk(obj)
{
if(obj.checked==false){
		parent.frames[1].document.forms[0].sel_all.checked=false;
		var count=parent.frames[1].document.forms[0].count.value;
		var check_flag ="";
		for(loops=1;loops<=count;loops++)
			{
			if (eval("parent.frames[1].document.forms[0].selectpatient"+loops).checked==true)
			check_flag ="Y";
			}
			if (check_flag !="Y")
			parent.parent.frames[1].frames[4].document.forms[0].reset_group_status.disabled=true;
}else
		{
		parent.parent.frames[1].frames[4].document.forms[0].reset_group_status.disabled=false;
		}
}


function sel_all_chk(){ 
var count=parent.frames[1].document.forms[0].count.value;
if(parent.frames[1].document.forms[0].sel_all.checked==true){
parent.parent.frames[1].frames[4].document.forms[0].reset_group_status.disabled=false;
for(loops=1;loops<=count;loops++)
{
var var_chk = eval("parent.frames[1].document.forms[0].selectpatient"+loops).checked=true;
}

}
else{
parent.parent.frames[1].frames[4].document.forms[0].reset_group_status.disabled=true;

for(loops=1;loops<=count;loops++)
{
var var_chk = eval("parent.frames[1].document.forms[0].selectpatient"+loops).checked=false;
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
		 obj.selAll.value=replace(obj.selAll.value,quotient,'1');
		}
	} 
}


function checkDt(date1)
		{
			retval=true
			var date1arr=new Array()

			date1arr=date1.split("/")

			if(date1arr.length==3)
			{
				var date1d=date1arr[0]
				var date1m=date1arr[1]
				var date1y=date1arr[2]

				date1d=parseInt(date1d)
				date1m=parseInt(date1m)
				date1yy=parseInt(date1y);

				if(date1m<=12)
				{

					if((date1m==1 || date1m==3 || date1m==5 || date1m==7 || date1m==8 || date1m==10 || date1m==12) && (date1d>31))
					{
					retval= false}

				    if((date1m==4 || date1m==6 || date1m==8 || date1m==11 ) && (date1d>30))
					{
					retval= false}

                    if ((date1y.length <4) || (date1y.length >4))
                        {
                        retval= false}
						}
				else
					{
					retval= false;}
			}
			else
				{retval= false;}
				return retval;
			}

		/*function chkTime(time1)
		{
			var retval=true;

			if( (time1.charAt(time1.length-1) )!=":")
			{
				var time1arr=new Array()
				time1arr=time1.split(":")

				if(time1arr.length==2)
				{
					var time1hr=time1arr[0]
					var time1min=time1arr[1]

					time1hr=parseInt(time1hr)
					time1min=parseInt(time1min)
					if(time1hr<=23)
					{
						if(time1min>60)
						{
								retval=false;
								
						}
					}
					else
							retval=false;
							
				}
				else
					retval=false;
					
			}
			else
					retval=false;
					

			return retval
		}*/


		/*function doDateTimeChk(obj)
		{
			var comp=obj
			obj=obj.value
			var dttime = obj.split(" ");
			var dt
			var time
			var retval=true
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
						alert(getMessage("INVALID_DATETIME","DR"))						
						document.forms[0].start_later_time.focus();
				
						comp.focus()
					}

					else
					{
						if(!chkTime(time))
						{
								retval= false
								alert(getMessage("INVALID_DATETIME","DR"));							
								document.forms[0].start_later_time.focus();
				
								comp.focus()
						}
					}
				}
			}
			else
			{
				retval= false
				alert(getMessage("INVALID_DATETIME","DR"));
				comp.focus();
				document.forms[0].start_later_time.focus();
				
			}

			if(retval)
			{
				//callDateFunction(comp)
			}
		return retval
		}*/


function resetGroupStatus()
{

var count=parent.frames[1].document.forms[0].count.value;
 var total=parent.frames[1].document.forms[0].p_update_string1.value;

if(parent.frames[1].document.forms[0].sel_all.checked==true)
{
	for(loops=1;loops<=count;loops++)
	{
		p_update_string = p_update_string + eval("parent.frames[1].document.forms[0].dup_group_id"+loops).value + '`' ;
		
	}
}
else
{
	for(loops=1;loops<=count;loops++)
	{
		var var_chk = eval("parent.frames[1].document.forms[0].selectpatient"+loops).checked;
		
		if (var_chk == true)
		{
			p_update_string = p_update_string + eval("parent.frames[1].document.forms[0].dup_group_id"+loops).value + '`' ;
			 if(total.indexOf(p_update_string)!=-1 ){
				 p_update_string="";}
		}

	}
}

p_update_string=p_update_string+parent.parent.frames[1].frames[1].document.forms[0].p_update_string1.value ;

for(loops=1;loops<=count;loops++){  
		if(eval("parent.frames[1].document.forms[0].selectpatient"+loops).checked == false)
			{		
				var check_id=eval("parent.frames[1].document.forms[0].dup_group_id"+loops).value;				
				if(p_update_string.indexOf(check_id)!=-1)
					{
						var pos1 = p_update_string.indexOf(check_id);		
						
						var pos2 = p_update_string.indexOf('`',pos1);
						
						var newStr1 =  p_update_string.slice(0,pos1);		
						
						var newStr2 =  p_update_string.slice(pos2+1);	
						
						p_update_string =  newStr1+newStr2;
						
						
					}
			}
	}
if (p_update_string.length != 0)
{	
	parent.parent.frames[1].frames[1].document.forms[0].update_string.value = p_update_string;		
	parent.parent.frames[1].frames[1].document.forms[0].submit();
}
else
	{
		parent.parent.frames[1].frames[1].document.forms[0].p_update_string1.value="";
		
	}


}
function reset()
{

//alert(parent.parent.frames[1].frames[4].document.href.location)
//parent.parent.frames[1].frames[4].document.forms[0].reset_group_status.disabled=false;
frames(1).frames[4].document.forms[0].reset_group_status.disabled=true;
frames(1).frames(1).document.forms[0].reset();
//frames[1].frames[3].document.forms[0].reset();
for( k=0;k<3;k++)
frames(1).frames(1).document.getElementById("tb1").rows(frames(1).frames(1).prev).cells(k).style.backgroundColor="";

frames(1).frames[3].document.forms[0].reset();
frames(1).frames[5].document.location.href = '../../eCommon/html/blank.html';

}
function touppercase(obj)
{
	obj.value = obj.value.toUpperCase();
}

function replaceStr(str,start,end,str1){

	var len =str.length;
	return(str.substr(0,parseInt(start))+str1+str.substr(parseInt(end)+1,len))
}
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
				
	}
		
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

