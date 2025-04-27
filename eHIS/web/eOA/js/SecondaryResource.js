/*Script function for Secondaryresources.jsp*/



function enable_chk(Obj,token)
{
	var sys_dt=document.forms[0].sysdt.value;
	var appt_dt=document.forms[0].appt_date.value;
	var sys_tm=document.forms[0].systm.value;
	var appt_tm=token;
	if(sys_dt==appt_dt)
	{
		
		var fromtimeharray=sys_tm.split(":");
		var from_time=appt_tm.split(":");

		var fromhtm=new Date(1,1,1,fromtimeharray[0],fromtimeharray[1],0,0);
		var tohtm=new Date(1,1,1,from_time[0],from_time[1],0,0);
	if( Date.parse(fromhtm) >= Date.parse(tohtm)){
			alert(getMessage("FR_TIME_CAN_NOT_SYS_TIME","OA"));
			Obj.checked=false;
			}

	}

}

/*Script function for SecResBottoms.jsp*/

function calthis(fromWh)
{	
	var sec_resorces_req=top.frames[1].frames[0].frames[0].document.forms[0].sec_resorces_req.value;
	
	var sec_resorces=top.frames[1].frames[0].frames[0].document.forms[0].sec_resorces.value;
	
	var sel_man="";
	var sel="N";
	var xarr=sec_resorces_req.split(",");
	var xarr1=sec_resorces.split(",");
	var msg="";

			for(var ik=0;ik<xarr1.length;ik++)
				{
					var arr2=xarr1[ik].replace("'","");

					arr2=arr2.replace("'","");
					if(arr2=='R' && xarr[ik]=='Y')
						msg=msg+"R,";

					if(arr2=='E' && xarr[ik]=='Y')
						msg=msg+"E,";

					if(arr2=='P' && xarr[ik]=='Y')
						msg=msg+"P,";

					if(arr2=='O' && xarr[ik]=='Y')
						msg=msg+"O,";
				}

		
		var xarr33=msg.split(",");

		var equ_val = top.frames[1].frames[0].frames[0].document.forms[0].first_set_value_equ.value ;
		var room_val = top.frames[1].frames[0].frames[0].document.forms[0].first_set_value_room.value;
		
		var oth_val = top.frames[1].frames[0].frames[0].document.forms[0].first_set_value_other.value;
		var pract_val = top.frames[1].frames[0].frames[0].document.forms[0].first_set_value_pract.value;
		var flgP=false;
		var flgE=false;
		var flgO=false;
		var flgR=false;
		
		
		if(top.frames[1].frames[0].frames[0].document.getElementById("sec_enE")){
			
			var ind=equ_val.indexOf('Y');
			if(equ_val=='' || (ind==-1)){
				flgE=true;
			}
		}

		if(top.frames[1].frames[0].frames[0].document.getElementById("sec_enR")){
			var ind=room_val.indexOf('Y');
			if(room_val=='' || (ind==-1)){
				flgR=true;
			}
		}

		if(top.frames[1].frames[0].frames[0].document.getElementById("sec_enP")){
			var ind=pract_val.indexOf('Y');
			if(pract_val=='' || (ind==-1)){
				flgP=true;
			}
		}
		if(top.frames[1].frames[0].frames[0].document.getElementById("sec_enO")){
			var ind=oth_val.indexOf('Y');
			if(oth_val=='' || (ind==-1)){
				flgO=true;
			}
		}
	if((flgP || flgO || flgE || flgR) && fromWh=='Confirm'){
		alert(getMessage("ALL_MAN_RES_NT_SL","OA"));
		return false;
	}else{
		

		var final_val='';
		if(equ_val=='')
			equ_val='*';

		if(room_val=='')
			room_val='*';

		if(oth_val=='')
			oth_val='*';

		if(pract_val=='')
			pract_val='*';

		final_val='E#'+equ_val+'||'+'R#'+room_val+'||'+'O#'+oth_val+'||'+'P#'+pract_val;
		
		var seleted_values=final_val;
		top.frames[0].document.forms[0].sec_sel.value=seleted_values;
		return true;

	}
		


		
}
function callFuncs(){
	var SinMul=parent.frames[0].document.forms[0].sec_value_count.value;
	var secReses=parent.frames[0].document.forms[0].SecResCheck.value;
	 if (secReses=='Y'){
	if (SinMul=='Y'){
if (parent.frames[1].frames[0].frames[1].document.forms[0]){
if(parent.frames[1].frames[0].frames[1].validate()){
	
 if (calthis('Confirm')){
	 
parent.frames[0].validate_allocation_criteria();
 }
}else{
	
	sec_res=parent.frames[0].document.forms[0].sec_req.value;
	
	index=sec_res.indexOf('Y');
	if (index!=-1){
	alert(getMessage("ALL_MAN_RES_NT_SL","OA"));
	}else{
	parent.frames[0].validate_allocation_criteria();
	}
}
}else{
	alert(getMessage("SEC_RES_NT_SEL","OA"));
}
	}
	else if (SinMul=='N'){
		if (parent.frames[1].frames[1].document.forms[0]){
  if (parent.frames[1].frames[1].validate('Confirm')){
	
	parent.frames[0].validate_allocation_criteria();
	}
		}
	}else{
	parent.frames[0].validate_allocation_criteria();
    }
	 }else if (secReses='N'){
parent.frames[0].validate_allocation_criteria();
	 }
}

function validate()
{ 
	var sel="N";
	var ret_str="";
	var sel_man="";
	var tmparr="";
	var sec_req=document.forms[0].sec_req.value;
if(document.forms[0].ret_value)
	{
		var nos=document.forms[0].ret_value.length;

		for(var i=0;i<nos;i++){
			if(document.forms[0].chk[i].checked){
				sel="Y";	
				ret_str=ret_str+document.forms[0].ret_value[i].value+",Y"+"@";
				tmparr=document.forms[0].ret_value[i].value.split(",");
				sel_man=sel_man+tmparr[4]+",";
			}else{
				
			}
		}
	}else{
		if(document.forms[0].chk)
		{
		if(document.forms[0].chk.checked){
			sel="Y";			
			ret_str=ret_str+document.forms[0].ret_value.value+",Y"+"@";
			tmparr=document.forms[0].ret_value.value.split(",");
			sel_man=sel_man+tmparr[4]+",";
		}else{
		}
	}
	}
	document.forms[0].selectMandatory.value=sel_man;
	var sec_resorces_req=document.forms[0].sec_resorces_req.value;
	var sec_resorces=document.forms[0].sec_resorces.value;

	if(sel_man.length >1)

		sel_man=sel_man.substring(0,sel_man.length -1);
		sel="Y";
document.forms[0].selectedResources.value=ret_str;

if(sel_man.length>0)
	{
parent.frames[0].document.forms[0].sec_sel.value=ret_str;
  return true;
	}else
	{
	parent.frames[0].document.forms[0].sec_sel.value='';
	return false;
	}
	
}
function validate1(){
	var sel="N";
	var ret_str="";
	var sel_man="";
	var tmparr="";
	var newstr="";
	var srl_no_val="";
	if(document.forms[0].ret_value.length){
		
		var nos=document.forms[0].ret_value.length;
		for(var i=0;i<nos;i++){
			if(document.forms[0].chk[i].checked){
				sel="Y";				
				ret_str=ret_str+document.forms[0].ret_value[i].value+",Y"+"@";
				tmparr=document.forms[0].ret_value[i].value.split(",");
				
				 if(document.forms[0].from_page.value !="" )
			{

					srl_no_val=srl_no_val+document.forms[0].ret_srl_no[i].value+"@";

				if ( document.forms[0].chk[i].disabled==false)
				{
					newstr=newstr+document.forms[0].ret_value[i].value+",Y"+"@";
				sel_man=sel_man+tmparr[4]+",";
				}
		
			}else if(document.forms[0].from_page.value =="")
			{
				sel_man=sel_man+tmparr[4]+",";
			}
				
				
			}else{
				ret_str=ret_str+"W,W,W,W,W,W,W,W,W,N"+"@";
				
			}
		}
	}else{
		if(document.forms[0].chk.checked){
			sel="Y";			
			ret_str=ret_str+document.forms[0].ret_value.value+",Y"+"@";
			tmparr=document.forms[0].ret_value.value.split(",");
			
		 if(document.forms[0].from_page.value !="" )
			{
			 srl_no_val=srl_no_val+document.forms[0].ret_srl_no.value+"@";
			if (document.forms[0].chk[i].disabled==false)
				{
					newstr=newstr+document.forms[0].ret_value.value+",Y"+"@";
				sel_man=sel_man+tmparr[4]+",";
				}
				
			}else if(document.forms[0].from_page.value =="")
			{
				sel_man=sel_man+tmparr[4]+",";
			}
			
		}else{
			ret_str=ret_str+"W,W,W,W,W,W,W,W,W,N"+"@";
		}
	}


	var sec_resorces_req=document.forms[0].sec_resorces_req1.value;
	var sec_resorces=document.forms[0].sec_resorcesT.value;
		if(sel_man.length >1)
		sel_man=sel_man.substring(0,sel_man.length -1);
		sel="Y";
		var xarr=sec_resorces_req.split(",");
		var xarr1=sec_resorces.split(",");
		var msg="";
		for(var ik=0;ik<xarr1.length;ik++){
			if(xarr1[ik]=='R' && xarr[ik]=='Y')
				msg=msg+"R,";

			if(xarr1[ik]=='E' && xarr[ik]=='Y'){
				msg=msg+"E,";
			}

			if(xarr1[ik]=='P' && xarr[ik]=='Y')
				msg=msg+"P,";

			if(xarr1[ik]=='O' && xarr[ik]=='Y')
				msg=msg+"O,";
		}
      
		var xarr22=sel_man.split(",");
		var xarr33=msg.split(",");
		for(var ik=0;ik<xarr33.length;ik++){
			var ip= xarr33[ik];
			if(sel_man.indexOf(ip) <0 )
				
				sel="N";
		}
		
		if(sel=="N"){
			alert(getMessage("ALL_MAN_RES_NT_SL","OA"));
		}else{
			if(document.forms[0].from_page.value=="")
	{
			parent.window.returnValue=ret_str;
			parent.window.close();
	}else
	{
		var secold_val=document.forms[0].secold_val.value;
		var newstr_last=newstr;
		newstr=secold_val+newstr;
		parent.window.returnValue=ret_str+"||"+newstr+"||"+newstr_last+"||"+srl_no_val;
		parent.window.close();
	}
	
		}
}

function validate2(){
	var sel="N";
	var ret_str="";
	var sel_man="";
	var tmparr="";
	var newstr="";
	var srl_no_val="";
	if(document.forms[0].ret_value.length){
		
		var nos=document.forms[0].ret_value.length;
		for(var i=0;i<nos;i++){
			if(document.forms[0].chk[i].checked){
				sel="Y";				
				ret_str=ret_str+document.forms[0].ret_value[i].value+",Y"+"@";
				tmparr=document.forms[0].ret_value[i].value.split(",");
				 if(document.forms[0].from_page.value !="")
			{
					 
					 srl_no_val=srl_no_val+document.forms[0].ret_srl_no[i].value+"@";
				if (document.forms[0].chk[i].disabled==false)
				{
					newstr=newstr+document.forms[0].ret_value[i].value+",Y"+"@";
					sel_man=sel_man+tmparr[4]+",";
				}
				
			}
				
				
			}else{
				ret_str=ret_str+"W,W,W,W,W,W,W,W,W,N"+"@";
				
			}
		}
	}else{
		if(document.forms[0].chk.checked){
			sel="Y";			
			ret_str=ret_str+document.forms[0].ret_value.value+",Y"+"@";
			tmparr=document.forms[0].ret_value.value.split(",");
		 if(document.forms[0].from_page.value !="" )
			{
			 srl_no_val=srl_no_val+document.forms[0].ret_srl_no.value+"@";
			if (document.forms[0].chk.disabled==false)
			{
				newstr=newstr+document.forms[0].ret_value.value+",Y"+"@";
				sel_man=sel_man+tmparr[4]+",";

			}
				
			}
			
		}else{
			ret_str=ret_str+"W,W,W,W,W,W,W,W,W,N"+"@";
		}
	}


	var sec_resorces_req=document.forms[0].sec_resorces_req1.value;
	var sec_resorces=document.forms[0].sec_resorcesT.value;
		if(sel_man.length >1)
		sel_man=sel_man.substring(0,sel_man.length -1);
		sel="Y";
		var xarr=sec_resorces_req.split(",");
		var xarr1=sec_resorces.split(",");
		var msg="";
		for(var ik=0;ik<xarr1.length;ik++){
			if(xarr1[ik]=='R' && xarr[ik]=='Y')
				msg=msg+"R,";

			if(xarr1[ik]=='E' && xarr[ik]=='Y'){
				msg=msg+"E,";
			}

			if(xarr1[ik]=='P' && xarr[ik]=='Y')
				msg=msg+"P,";

			if(xarr1[ik]=='O' && xarr[ik]=='Y')
				msg=msg+"O,";
		}
      
		var xarr22=sel_man.split(",");
		var xarr33=msg.split(",");
		
		
		for(var ik=0;ik<xarr33.length;ik++){
			var ip= xarr33[ik];
			if(sel_man.indexOf(ip) <0 )
				
				sel="N";
		}
		
		if(sel=="N"){
			alert(getMessage("ALL_MAN_RES_NT_SL","OA"));
		}else{
			if(document.forms[0].from_page.value=="")
	{
			parent.window.returnValue=ret_str;
	parent.window.close();
	}else
	{
		var secold_val=document.forms[0].secold_val.value;
		var newstr_last="";
		newstr_last=newstr;
		newstr=secold_val+newstr;
		parent.window.returnValue=ret_str+"||"+newstr+"||"+newstr_last+"||"+srl_no_val;
		parent.window.close();
	}
	
		}
}

function ret_none()
{
	parent.parent.frames[1].location.href='../../eCommon/html/blank.html?';
	
}





function validate()
{ 
	var sel="N";
	var ret_str="";
	var sel_man="";
	var tmparr="";
	var sec_req=document.forms[0].sec_req.value;
if(document.forms[0].ret_value)
	{
		var nos=document.forms[0].ret_value.length;

		for(var i=0;i<nos;i++){
			if(document.forms[0].chk[i].checked){
				sel="Y";	
				ret_str=ret_str+document.forms[0].ret_value[i].value+",Y"+"@";
				tmparr=document.forms[0].ret_value[i].value.split(",");
				sel_man=sel_man+tmparr[4]+",";
			}else{
				
			}
		}
	}else{
		if(document.forms[0].chk)
		{
		if(document.forms[0].chk.checked){
			sel="Y";			
			ret_str=ret_str+document.forms[0].ret_value.value+",Y"+"@";
			tmparr=document.forms[0].ret_value.value.split(",");
			sel_man=sel_man+tmparr[4]+",";
		}else{
		}
	}
	}
	document.forms[0].selectMandatory.value=sel_man;
	var sec_resorces_req=document.forms[0].sec_resorces_req.value;
	var sec_resorces=document.forms[0].sec_resorces.value;

	if(sel_man.length >1)

		sel_man=sel_man.substring(0,sel_man.length -1);
		sel="Y";
document.forms[0].selectedResources.value=ret_str;

if(sel_man.length>0)
	{
parent.frames[0].document.forms[0].sec_sel.value=ret_str;
  return true;
	}else
	{
	parent.frames[0].document.forms[0].sec_sel.value='';
	return false;
	}
	
}
function validate_cancel(){
	var sel="N";
	var ret_str="";
	var sel_man="";
	var tmparr="";
	var newstr="";
	var srl_no_val="";
	if(document.forms[0].ret_value.length){
		
		var nos=document.forms[0].ret_value.length;
		for(var i=0;i<nos;i++){
			if(document.forms[0].chk[i].checked){
				
			 if(document.forms[0].chk[i].disabled==true)
			{
				 sel="Y";				
				ret_str=ret_str+document.forms[0].ret_value[i].value+",Y"+"@";
				tmparr=document.forms[0].ret_value[i].value.split(",");
				newstr=newstr+document.forms[0].ret_value[i].value+",Y"+"@";
				sel_man=sel_man+tmparr[4]+",";
			}
				
			}else{
				ret_str=ret_str+"W,W,W,W,W,W,W,W,W,N"+"@";
				
			}
		}
	}else{
		if(document.forms[0].chk.checked){
			 sel="Y";			
			ret_str=ret_str+document.forms[0].ret_value.value+",Y"+"@";
			tmparr=document.forms[0].ret_value.value.split(",");
		 if( document.forms[0].chk[i].disabled==true)
			{
			 sel="Y";			
			ret_str=ret_str+document.forms[0].ret_value.value+",Y"+"@";
			tmparr=document.forms[0].ret_value.value.split(",");
			newstr=newstr+document.forms[0].ret_value[i].value+",Y"+"@";
			sel_man=sel_man+tmparr[4]+",";
			}			
			
		}else{
			ret_str=ret_str+"W,W,W,W,W,W,W,W,W,N"+"@";
		}
	}


	var sec_resorces_req=document.forms[0].sec_resorces_req1.value;
	var sec_resorces=document.forms[0].sec_resorcesT.value;
		if(sel_man.length >1)
		sel_man=sel_man.substring(0,sel_man.length -1);
		sel="Y";
		var xarr=sec_resorces_req.split(",");
		var xarr1=sec_resorces.split(",");
		var msg="";
		for(var ik=0;ik<xarr1.length;ik++){
			if(xarr1[ik]=='R' && xarr[ik]=='Y')
				msg=msg+"R,";

			if(xarr1[ik]=='E' && xarr[ik]=='Y'){
				msg=msg+"E,";
			}

			if(xarr1[ik]=='P' && xarr[ik]=='Y')
				msg=msg+"P,";

			if(xarr1[ik]=='O' && xarr[ik]=='Y')
				msg=msg+"O,";
		}
      var flag1=false;
		var xarr22=sel_man.split(",");
		var xarr33=msg.split(",");
	
		for(var ik=0;ik<xarr33.length;ik++){
			var ip= xarr33[ik];

			if(sel_man.indexOf(ip) <0 )
			{
				sel="N";
			}
		}
		if(sel=="N"){
			
		var secold_val=document.forms[0].secold_val.value;
		newstr=secold_val+newstr;
		parent.window.returnValue=ret_str+"||"+newstr+"||"+sel+"||"+srl_no_val;
		parent.window.close();
		}else{

		sel="N";
		var secold_val=document.forms[0].secold_val.value;
		newstr=secold_val+newstr;
		parent.window.returnValue=ret_str+"||"+newstr+"||"+sel+"||"+srl_no_val;
		parent.window.close();
	
		}
}
function ret_none1(){

	if(document.forms[0].from_page.value=="")
	{
	parent.window.returnValue="N";
	parent.window.close();
	}else
	{
		validate_cancel();
	}
}

function validate_close(){
	var sel="N";
	var ret_str="";
	var sel_man="";
	var tmparr="";
	var newstr="";
	if(document.forms[0].ret_value.length){
		
		var nos=document.forms[0].ret_value.length;
		for(var i=0;i<nos;i++){
			if(document.forms[0].chk[i].checked){
				
			 if(document.forms[0].chk[i].disabled==false)
			{
				sel="Y";				
				ret_str=ret_str+document.forms[0].ret_value[i].value+",Y"+"@";
				newstr=newstr+document.forms[0].ret_value[i].value+",Y"+"@";
			}
				sel_man=sel_man+tmparr[4]+",";
			}else{
				ret_str=ret_str+"W,W,W,W,W,W,W,W,W,N"+"@";
				
			}
		}
	}else{
		if(document.forms[0].chk.checked){
			
		 if(document.forms[0].chk[i].disabled==false)
			{
			 sel="Y";			
			ret_str=ret_str+document.forms[0].ret_value.value+",Y"+"@";
			tmparr=document.forms[0].ret_value.value.split(",");
				newstr=newstr+document.forms[0].ret_value[i].value+",Y"+"@";
			}
			
			sel_man=sel_man+tmparr[4]+",";
		}else{
			ret_str=ret_str+"W,W,W,W,W,W,W,W,W,N"+"@";
		}
	}


	var sec_resorces_req=document.forms[0].sec_resorces_req1.value;
	var sec_resorces=document.forms[0].sec_resorcesT.value;
		if(sel_man.length >1)
		sel_man=sel_man.substring(0,sel_man.length -1);
		sel="Y";
		var xarr=sec_resorces_req.split(",");
		var xarr1=sec_resorces.split(",");
		var msg="";
		for(var ik=0;ik<xarr1.length;ik++){
			if(xarr1[ik]=='R' && xarr[ik]=='Y')
				msg=msg+"R,";

			if(xarr1[ik]=='E' && xarr[ik]=='Y'){
				msg=msg+"E,";
			}

			if(xarr1[ik]=='P' && xarr[ik]=='Y')
				msg=msg+"P,";

			if(xarr1[ik]=='O' && xarr[ik]=='Y')
				msg=msg+"O,";
		}
      var flag1=false;
		var xarr22=sel_man.split(",");
		var xarr33=msg.split(",");
	
		for(var ik=0;ik<xarr33.length;ik++){
			var ip= xarr33[ik];

			if(sel_man.indexOf(ip) <0 )
			{
				sel="N";
			}
		}
if(sel=="N"){
			
		var secold_val=document.forms[0].secold_val.value;
		newstr=secold_val;
		parent.window.returnValue=ret_str+"||"+newstr+"||"+sel;
		parent.window.close();
		}else{

		sel="N";
		var secold_val=document.forms[0].secold_val.value;
		newstr=secold_val;
		parent.window.returnValue=ret_str+"||"+newstr+"||"+sel;
		parent.window.close();
	
		}
		
}

function ret_none2(){
	if(document.forms[0].from_page.value=="")
	{
	parent.window.returnValue="N";
	parent.window.close();
	}else
	{
		validate_close();
	}
}

function scrollTitle(){

  var x = document.body.scrollTop;
  if(x == 0){
   document.getElementById("divTitleTable").style.position = 'static';
   document.getElementById("divTitleTable").style.posTop  = 0;
   
    document.getElementById("div1").style.position = 'static';
   document.getElementById("div1").style.posTop  = 0;
  }else{
	document.getElementById("divTitleTable").style.position = 'relative';
	document.getElementById("divTitleTable").style.posTop  = x-2;
	
	document.getElementById("div1").style.position = 'relative';
	document.getElementById("div1").style.posTop  = x-2;
  
  }


}

function retain(){
	var sel_secondary=document.forms[0].sel_secondary.value;
	var secold_val=document.forms[0].secold_val.value;
	var sel_arr=sel_secondary.split('@');
var chk_val=document.forms[0].chk_val.value;

for (i=0;i<sel_arr.length-1;i++){
		
	  sel_arr1=sel_arr[i].split(',');
	  
  if(document.forms[0].from_page.value =="")
	{
	  if (sel_arr1[9]=='Y')
		{
		 document.forms[0].chk[i].checked=true;
		}
	}else{
		if (sel_arr1[10]=='Y')
		{
			document.forms[0].chk[i].checked=true;
			document.forms[0].chk[i].disabled=true;
		}
		 var srl_no=chk_val.split("|");
		for (var s=0;s<srl_no.length-1 ;s++ )
		{
			
		if(sel_arr1[8]==srl_no[s])
		  {

			document.forms[0].chk[i].checked=false;
			document.forms[0].chk[i].disabled=false;
		  }
		}
		
			}

		}
}


/*Script function for Secondaryresults2.jsp*/

function Show_window(obj1,obj2)
{
if (document.forms[0].fromPage.value!='Reschedule'){

if (parent.frames[1].document.forms[0]){

	parent.frames[1].validate()
}
}
var sec_res_name=obj1;
var sec_res_id=obj2;
var clinic_name =document.getElementById("clinic_name").value;
var care_locn_desc=document.getElementById("care_locn_id").value;
var pract_pri_name=document.getElementById("pract_name").value;
var pri_class_desc=document.getElementById("res_pri_class_desc").value;
var To_time_param=document.getElementById("To_time_param").value;
var From_time_param=document.getElementById("From_time_param").value;
var Appt_date=document.getElementById("Appt_date").value;
var sec_resorces=document.forms[0].sec_resorces.value;
var clinic_code=document.forms[0].clinic_code_val.value;
var sec_resorces_req=document.forms[0].sec_resorces_req.value;
var sec_req=document.forms[0].sec_req.value;
var equ_val=document.forms[0].first_set_value_equ.value;
var room_val=document.forms[0].first_set_value_room.value;
var oth_val=document.forms[0].first_set_value_other.value;
var pract_val=document.forms[0].first_set_value_pract.value;
var time_table_type=document.forms[0].time_table_type.value;

if (document.forms[0].fromPage.value=='Reschedule'){
parent.parent.frames[2].document.forms[0].val.disabled=false;
}
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
		if(sec_res_id=='R')		
	{
	xmlStr ="<root><SEARCH selec_sec_val = \""+room_val+"\"  steps='ADD_SECNEXT_TO_SESSION'/></root>"
	}else if(sec_res_id=='E')
	{
	xmlStr ="<root><SEARCH selec_sec_val = \""+equ_val+"\"  steps='ADD_SECNEXT_TO_SESSION'/></root>"

	}else if(sec_res_id=='O')
	{
	xmlStr ="<root><SEARCH selec_sec_val = \""+oth_val+"\"  steps='ADD_SECNEXT_TO_SESSION'/></root>"

	}else if(sec_res_id=='P')
	{
	xmlStr ="<root><SEARCH selec_sec_val = \""+pract_val+"\"  steps='ADD_SECNEXT_TO_SESSION'/></root>"
	}
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)




	var u1= "../../eOA/jsp/SecondaryResultsDetails2.jsp?sec_res_name="+sec_res_name+"&clinic_name="+clinic_name+"&care_locn_desc="+care_locn_desc+"&pract_pri_name="+pract_pri_name+"&pri_class_desc="+pri_class_desc+"&To_time_param="+To_time_param+"&From_time_param="+From_time_param+"&Appt_date="+Appt_date+"&sec_resorces="+escape(sec_resorces)+"&clinic_code="+escape(clinic_code)+"&sec_res_id="+escape(sec_res_id)+"&sec_resorces_req="+escape(sec_resorces_req)+"&time_table_type="+time_table_type+"&sec_req="+sec_req;
if(document.forms[0].fromPage.value!='Reschedule')
	{
	top.frames[1].frames[0].frames[1].location.href=u1;
	}else
	{
	parent.parent.parent.parent.frames[1].frames[1].location.href=u1;

	}


}
function retain1(){
	var sec_req =document.forms[0].sec_req.value;
	var arr1=sec_req.split("-");
	for(var s=0;s<arr1.length;s++)
	{
		var val1=arr1[0];
	}
	var sel_secondary=document.getElementById("sel_secondary").value;
	
	var secArr=sel_secondary.split("||");
	
	for(i=0;i<secArr.length;i++){

		var tmp=secArr[i];
		var tmp1=tmp.split("#");
		var tmp2=tmp1[0];
		var tmp3=tmp1[1];

		
		if(tmp3=='*'){
			tmp3='';
		}

		if(tmp2=='E'){
			document.forms[0].first_set_value_equ.value=tmp3;
		}else if(tmp2=='R'){
			document.forms[0].first_set_value_room.value=tmp3;
		}else if(tmp2=='O')
		{
			document.forms[0].first_set_value_other.value=tmp3;
		}else if(tmp2=='P')
		{
			document.forms[0].first_set_value_pract.value=tmp3;
		}
		
	}
}
function scrollTitle1(){

  var x = document.body.scrollTop;
  if(x == 0){
   document.getElementById("divTitleTable").style.position = 'static';
   document.getElementById("divTitleTable").style.posTop  = 0;
  }else{
	document.getElementById("divTitleTable").style.position = 'relative';
	document.getElementById("divTitleTable").style.posTop  = x-2;
  
  }

}

/*Script functions for Recurringcriteria.jsp*/

function enable_disable(){
	parent.ResultsFrame.location.href="../../eCommon/html/blank.html";
	document.forms[0].AcceptDates.disabled=true;

	if(document.forms[0].cbo_rec_type.value=='2'){
		document.forms[0].Sun.disabled=false;
		document.forms[0].Mon.disabled=false;
		document.forms[0].Tue.disabled=false;
		document.forms[0].Wed.disabled=false;
		document.forms[0].Thu.disabled=false;
		document.forms[0].Fri.disabled=false;
		document.forms[0].Sat.disabled=false;
	}else{
		document.forms[0].Sun.checked=false;
		document.forms[0].Mon.checked=false;
		document.forms[0].Tue.checked=false;
		document.forms[0].Wed.checked=false;
		document.forms[0].Thu.checked=false;
		document.forms[0].Fri.checked=false;
		document.forms[0].Sat.checked=false;

		document.forms[0].Sun.disabled=true;
		document.forms[0].Mon.disabled=true;
		document.forms[0].Tue.disabled=true;
		document.forms[0].Wed.disabled=true;
		document.forms[0].Thu.disabled=true;
		document.forms[0].Fri.disabled=true;
		document.forms[0].Sat.disabled=true;
	}
}

function validate_date_from(from_date,obj1,obj2)
{
	if(from_date.value!="")
	{
	if(!validDateObj(from_date,"DMY",localeName))
		{
			from_date.value="";
			enable_disable();
			return ;

		}

		var obj1_greg=convertDate(obj1.value,"DMY","en",localeName);	

		if(isBefore(obj1_greg,from_date.value,'DMY',localeName)==false)
				{
				 var err1 = getMessage("FROM_DATE_GRT","OA");
				err1 = err1.replace('$',obj1.value);
				alert(err1);
				 document.forms[0].from_date.value=''
			 document.forms[0].from_date.focus();
			enable_disable();
			}
	}	
		if(from_date.value!="" && obj2.value!="" )
		{
	
			if(isBefore(from_date.value,obj2.value,'DMY',localeName)==false)
				{
				var msg = getMessage('TO_DT_GR_EQ_FM_DT','SM');
				alert(msg);
				from_date.value="";
				from_date.select();	
				enable_disable();
				return false;
			}
			else
				return true;
		}

}
function validate_date_to(obj,obj1,obj2)
{
	
	if(obj.value!="")
	{
	if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			enable_disable();
			return ;
		}
			var obj1_greg=convertDate(obj2.value,"DMY","en",localeName);

		if(isBefore(obj1_greg,obj.value,'DMY',localeName)==false)
				{
				var err1 = getMessage("TO_DATE_GRT","OA");
				err1 = err1.replace('$',obj2.value);
				alert(err1);
				 obj.value=''
				 obj.focus();
			enable_disable();
			}
	}

	if(obj.value!="" && obj1.value!="" )
		{
		
			if(isBefore(obj1.value,obj.value,'DMY',localeName)==false)
				{
				var msg = getMessage('TO_DT_GR_EQ_FM_DT','SM');
				alert(msg);
				obj.value="";
				obj.select();	
				enable_disable();
				return false;
			}else
			{
				 var day_limit= document.forms[0].day_limit.value;
				var no_days=daysBetween(obj1.value,obj.value,'DMY',localeName);
			  if ( parseInt(no_days) > parseInt(day_limit)){
			  var msg=getMessage("RECUR_PER_VALID","OA");
			  msg = msg.replace('$',day_limit);
			  alert(msg);
              document.forms[0].to_date.value='';
			  document.forms[0].to_date.focus();
			  enable_disable();
		  }
			}

		
		}

}

function dateCheck2(from_date,to_Date){
	var fm_date=from_date.value;
	var to_Dt=to_Date.value;
	var fm_array;
	var to_array;
	var noOfDays;
	if (validateDate(to_Date)){
	if (!compare_date(from_date,to_Date)){ 
		 alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
		 document.forms[0].date_to.value='';
		 document.forms[0].date_to.focus();
		 enable_disable();
	}
	
	else
	{  	 
	   if (from_date.value!=''){
          fm_array=fm_date.split("/");
		  to_array=to_Dt.split("/");
		  var fmDate = new Date(fm_array[2],fm_array[1],fm_array[0]);
		  var toDate = new Date(to_array[2],to_array[1],to_array[0]);
		  noOfDays= (Date.parse(toDate)-Date.parse(fmDate))/86400000;
		  var day_limit= document.forms[0].day_limit.value;
		  if ( parseInt(noOfDays) > parseInt(day_limit)){
			  var msg=getMessage("RECUR_PER_VALID","OA");
			  alert(msg + ' ' + day_limit+ ' Days');
              document.forms[0].to_date.value='';
			  document.forms[0].to_date.focus();
			  enable_disable();
		  }
	   }  
	}
	}
	else{
		alert(getMessage("INVALID_DATE_FMT","SM"));
	   	document.forms[0].to_date.value='';
		document.forms[0].to_date.focus();
		enable_disable();
	}


}

function checkEmpty1(){
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH steps='CLEAR_REC_FROM_SESSION'/></root>"
					
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","ServerSide.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText)
		checkEmpty();
}
function checkEmpty(){
	 var dispStr="";
	 var arr= new Array(0,0,0);
	 if (document.forms[0].from_date.value == ""){
	     //dispStr="APP-002000 From Date Cannot be Blank";
		 dispStr=getMessage("FROM_DATE_CANNOT_BE_BLANK","SM");
		 arr[0]=1;
	 }
	 if (document.forms[0].to_date.value==""){
		 //dispStr=dispStr + "\nAPP-002000 To Date Cannot be Blank";
		 dispStr=dispStr + "\n"+ getMessage("TO_DT_NOT_BLANK","SM");
		 arr[1]=2;
		 }
  
         
	 if (document.forms[0].cbo_rec_type.value==0){
		 //dispStr =dispStr+ "\nAPP-002000 Recurring Type Cannot be Blank";
		  dispStr =dispStr+ "\n" + getMessage('CAN_NOT_BE_BLANK','Common');
		  dispStr = dispStr.replace('$',getLabel("eOA.RecurringType.label","OA"));
		 arr[2]=3;
	 }
	 
	       if (dispStr!="" ){

		     alert(dispStr);
		    if (arr[0]==1) 
			    document.forms[0].from_date.focus();
		     else
			   { 
				 if (arr[1]==2) 
			     document.forms[0].to_date.focus();
		          else
			     document.forms[0].cbo_rec_type.focus();
				}
		parent.ResultsFrame.location.href="../../eCommon/html/blank.html";

	  }else{ 

		  disp_results();
		}
}
function clearFields(){
	document.forms[0].from_date.value='';
	document.forms[0].to_date.value='';
	document.forms[0].cbo_rec_type.value=0;
	document.forms[0].AcceptDates.disabled=true;
	enable_disable();
	parent.ResultsFrame.location.href="../../eCommon/html/blank.html";
}

function focusprefenddate1()
{
document.forms[0].to_date.focus();
}

function focusprefdate1(){
	var ret_val=document.forms[0].recurring_cur_select.value;
	if(ret_val!=''){
		var ret_arr= ret_val.split('*');

		document.forms[0].from_date.value=ret_arr[0];
		document.forms[0].to_date.value=ret_arr[1];
		document.forms[0].cbo_rec_type.value=ret_arr[2];

		if(ret_arr[2]=='2'){
			if(ret_arr[3]=='true')
				document.forms[0].Sun.checked=true;

			if(ret_arr[4]=='true')
				document.forms[0].Mon.checked=true;

			if(ret_arr[5]=='true')
				document.forms[0].Tue.checked=true;

			if(ret_arr[6]=='true')
				document.forms[0].Wed.checked=true;

			if(ret_arr[7]=='true')
				document.forms[0].Thu.checked=true;

			if(ret_arr[8]=='true')
				document.forms[0].Fri.checked=true;

			if(ret_arr[9]=='true')
				document.forms[0].Sat.checked=true;

			document.forms[0].Sun.disabled=false;
			document.forms[0].Mon.disabled=false;
			document.forms[0].Tue.disabled=false;
			document.forms[0].Wed.disabled=false;
			document.forms[0].Thu.disabled=false;
			document.forms[0].Fri.disabled=false;
			document.forms[0].Sat.disabled=false;

		}

		checkEmpty();

	}
}

function disp_results(){

	var clinic_code=document.forms[0].cliniccode.value;
	var pract_id=document.forms[0].practitionerid.value;
	var from_date=document.forms[0].from_date.value;
	var to_date=document.forms[0].to_date.value;
	var visit_type=document.forms[0].visittype.value;
	var strVisitArray = visit_type.split("~");
	var u1=strVisitArray[0];
	var u2=strVisitArray[1];
	var timetable_type=document.forms[0].time_table_type.value;
	var from_time=document.forms[0].From_time.value;
	var to_time=document.forms[0].To_time.value;
	var week_day='';
	var rec_type=document.forms[0].cbo_rec_type.value;
	
	var chk_flg=false;
	if(rec_type=='2'){		

		if(document.forms[0].Sun.checked){
			chk_flg=true;
			week_day=week_day+"'1',";
		}
			
		if(document.forms[0].Mon.checked){
			chk_flg=true;
			week_day=week_day+"'2',";
		}

		if(document.forms[0].Tue.checked){
			chk_flg=true;
			week_day=week_day+"'3',";
		}

		if(document.forms[0].Wed.checked){
			chk_flg=true;
			week_day=week_day+"'4',";
		}

		if(document.forms[0].Thu.checked){
			chk_flg=true;
			week_day=week_day+"'5',";
		}

		if(document.forms[0].Fri.checked){
			chk_flg=true;
			week_day=week_day+"'6',";
		}

		if(document.forms[0].Sat.checked){
			chk_flg=true;
			week_day=week_day+"'7',";
		}
		
		if(!chk_flg){
			alert(getMessage("ONE_DAY_SEL","OA"));
			parent.ResultsFrame.location.href="../../eCommon/html/blank.html";
			return false;
			

		}else{
			week_day=week_day.substring(0,(week_day.length) -1)
		}
	}
	
	    var care_locn_ind=document.forms[0].care_locn_ind.value;
    var res_class=document.forms[0].res_class.value;


    var pat_id=document.forms[0].patient_id.value;
	var no_of_slots=document.forms[0].no_of_slots.value;	
	parent.frames[1].location.href="../../eOA/jsp/RecurringDaysResult.jsp?clinic_code="+clinic_code+"&pract_id="+pract_id+"&from_date="+from_date+"&to_date="+to_date+"&visit_type="+u2+"&timetable_type="+timetable_type+"&from_time="+from_time+"&to_time="+to_time+"&week_day="+week_day+"&rec_type="+rec_type+"&patient_id="+pat_id+"&no_of_slots="+no_of_slots+"&res_class="+res_class+"&care_locn_ind="+care_locn_ind;

}
//Recurring result
function validate_rec(){
	var sel="N";
	var ret_str="";
	if(document.forms[0].hddTime.length){
		var nos=document.forms[0].hddTime.length;
		for(var i=0;i<nos;i++){
			if(document.forms[0].chk[i].checked){
				sel="Y";				ret_str=ret_str+document.forms[0].hddDT[i].value+"@"+document.forms[0].hddTime[i].value+"*";
			}else{
				if(document.forms[0].chk[i].disabled)
					ret_str=ret_str+'N@C - N - N*';
				else
					ret_str=ret_str+'N@N - N - N*';	

			}
		}

	}else{
		if(document.forms[0].chk.checked){
			sel="Y";			ret_str=ret_str+document.forms[0].hddDT.value+"@"+document.forms[0].hddTime.value+"*";
		}else{
				if(document.forms[0].chk.disabled)
					ret_str=ret_str+'N@C - N - N*';
				else
					ret_str=ret_str+'N@N - N - N*';	
		}
	}

	if(sel=="N"){
		alert(getMessage("ATLEAST_ONE_SELECTED","Common"));
	}else{
		var f_d=parent.frames[0].document.forms[0].from_date.value;
		var t_d=parent.frames[0].document.forms[0].to_date.value;
		var r_typ=parent.frames[0].document.forms[0].cbo_rec_type.value;
		var Sun=parent.frames[0].document.forms[0].Sun.checked;
		var Mon=parent.frames[0].document.forms[0].Mon.checked;
		var Tue=parent.frames[0].document.forms[0].Tue.checked;
		var Wed=parent.frames[0].document.forms[0].Wed.checked;
		var Thu=parent.frames[0].document.forms[0].Thu.checked;
		var Fri=parent.frames[0].document.forms[0].Fri.checked;
		var Sat=parent.frames[0].document.forms[0].Sat.checked;

		var retain_val=f_d+'*'+t_d+'*'+r_typ+'*'+Sun+'*'+Mon+'*'+Tue+'*'+Wed+'*'+Thu+'*'+Fri+'*'+Sat+'*';
		ret_str=ret_str+'||'+retain_val;

		parent.window.returnValue=ret_str;
		parent.window.close();
	}
}
async function open_details(inDate,indx)
{
	var retVal = 	new String();
	var dialogHeight= "28" ;
	var dialogTop = "165" ;
	var dialogWidth	= "50" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	var dt=inDate;
	var pract_id=document.forms[0].Practitioner_id.value;
	var clinic_code=document.forms[0].Clinic_Code.value;
	var pat_id=document.forms[0].patient_id.value;

    var care_locn_ind=document.forms[0].care_locn_ind.value;
   var res_class=document.forms[0].res_class.value;

	callurl="../../eOA/jsp/RecurringDaysSchFrame.jsp?clinic_code="+clinic_code+"&practitioner_id="+pract_id+"&Date="+inDate+"&patient_id="+pat_id+"&care_locn_ind="+care_locn_ind+"&res_class="+res_class;

	var retVal = 	new String();
	retVal = await window.showModalDialog(callurl,arguments,features);

	if(retVal){
	}else{
		retVal='';
	}
	if(retVal==''){
	}else{
		var tmArray = retVal.split("*");
		var u1=tmArray[0];
		var u2=tmArray[1];
		if(document.forms[0].hddTime){
		if(document.forms[0].hddTime.length){
			if(document.getElementById("inhrtml")[indx])
			   document.getElementById("inhrtml")[indx].innerHTML=u1+" - "+u2;
            if(document.forms[0].hddTime[indx])
			     document.forms[0].hddTime[indx].value=u1+" - "+u2+" - 1";
			document.forms[0].chk[indx].disabled=false;
			document.forms[0].chk[indx].checked=true;
		}else{
            if(document.getElementById("inhrtml"))  
			document.getElementById("inhrtml").innerHTML=u1+" - "+u2;
			if(document.forms[0].hddTime)
			document.forms[0].hddTime.value=u1+" - "+u2+" - 1";
			document.forms[0].chk.disabled=false;
			document.forms[0].chk.checked=true;
		}
		}


	}


}

//Recurringdays time...

function cols(obj,obj1,obj2)
	{
		var HTMLVal= new String();
		var fromTime=obj;
		var clinic_date=obj2;
		var toTime=obj1;
		var finalval = "";
		var patient_id=document.forms[0].patient_id.value;

		if(document.forms[0].patient_id.value != "")
		{
			
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH steps='dateTime' patient_id=\""+patient_id+"\"  fromTime=\""+fromTime+"\" clinic_date=\""+clinic_date+"\" toTime=\""+toTime+"\"  /></root>"
	
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","RecurringValidation.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		
		var res = responseText;
			
			if(res=="APPT_OVERLAP_NOT_PROCEED")
			{
				alert(getMessage("APPT_OVERLAP_NOT_PROCEED","OA"));
			}
			else
			{
				finalvalue = fromTime + "*" + toTime;
					parent.window.returnValue = finalvalue;
					parent.window.close();
			}
	
		}
		else
		{
		
			finalval = fromTime+ "*"+ toTime;
			window.returnValue = finalval;
			parent.window.close();
		
			
		}
	}
function col()
{
}
function exit()
{
	
	parent.window.close();
}




function validateDate(from)
{
	if(from.value!="")
		{
		if(!validDateObj(from,"DMY",localeName))
		{
			from.value="";
			return ;
		}
}
}

function compare_date(from,to)
{
	
if(from.value!="" && to.value!="" )
		{
	
			if(isBefore(from.value,to.value,'DMY',localeName)==false)
				{
				return false;
			}
			else
				return true;
		}
}
