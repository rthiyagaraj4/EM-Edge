function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/md_addModifyLocnForOperatorStnMain.jsp?" ;
	messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num?err_val=';
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/LocnForOperatorStationQueryPage.jsp?function=LocnForOperatorStation" ;
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
	if(f_query_add_mod.f_query_add_mod_res){ 
	
	 var msg=f_query_add_mod.getMessage('NO_CHANGE_TO_SAVE','Common');	

	// if(parent.frames[1].frames[1].frames[1].document.forms[0].search_by.value == '00')					
	// parent.frames[1].frames[1].frames[1].document.forms[0].search_txt.disabled=true;
	//parent.frames[1].frames[1].frames[1].document.forms[0].search_txt.value=="";	
	//parent.frames[1].frames[1].frames[1].document.forms[0].search_txt.disabled=true;
	if(f_query_add_mod.f_query_add_mod_res.document.forms[0]){
		if(f_query_add_mod.f_query_add_mod_res.document.forms[0].finalSelect.value == '')
		{
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
		}else{
                       
			f_query_add_mod.f_query_add_mod_res.document.forms[0].action="../../servlet/eAM.md_LocnForOperatorStn?mode=apply";
			
			f_query_add_mod.f_query_add_mod_res.document.forms[0].target="messageFrame";
			// parent.frames[1].frames[1].frames[1].document.forms[0].search_txt.disabled=true;
	
			f_query_add_mod.f_query_add_mod_res.document.forms[0].submit();		
			
			
		}
	}else{
		var msg=parent.frames[0].getMessage("AM0100","AM");
	    messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=1'
        return false;	}
	}else{
		
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
	}
			
	
   
}

var facId='';

function onSuccess() {		      
f_query_add_mod.location.href = "../../eAM/jsp/md_addModifyLocnForOperatorStnMain.jsp?facilityID="+facId ;
}

function deleterecord()
{

	if(f_query_add_mod.document.location_form.function_name.value!="insert")
	{
		f_query_add_mod.document.location_form.function_name.value="delete";
		f_query_add_mod.document.location_form.submit();
		f_query_add_mod.location.href="../../eCommon/html/blank.html"
		return true;
	}
	else
	{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("CANNOT_DELETE","SM");
	}
}

function reset()
{
	
/*if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } */
	/*if(f_query_add_mod.document.forms[0].name == "location_form")
		f_query_add_mod.document.location_form.reset() ;
	else f_query_add_mod.document.query_form.reset() ;*/
	//f_query_add_mod.document.location.reload();
		if(f_query_add_mod.document.forms[0] || f_query_add_mod.document.f_query_add_mod_query)
		f_query_add_mod.document.location.reload();
		

}
function chkPractitionerList()
{
	var fields = new Array ( 	parent.frames[0].document.forms[0].facility,
						parent.frames[0].document.forms[0].oprstn,
						parent.frames[0].document.forms[0].loctype
						    );
		var names = new Array (	getLabel('Common.facility.label','Common'),
							getLabel('Common.operatorstation.label','Common'),
							getLabel('Common.locationtype.label','Common'));
		if(parent.frames[0].checkFieldsofMst( fields, names, parent.parent.frames[2])) {
			return true;
		}
		else
		return false
}

var temp='';
var name1="";
function chkServices(Obj,chk)
{	
	var cnt=parent.frames[1].document.forms[0].end.value;	
	var end=parent.frames[1].document.forms[0].end.value;
    var start=parent.frames[1].document.forms[0].start.value;
	
	if(eval("parent.frames[1].document.forms[0].chkGlobe"+chk))
        name1=eval("parent.frames[1].document.forms[0].chkGlobe"+chk).name;
	if(Obj.checked)
	{
		var count='0';
		temp+=Obj.value+"$"+Obj.name+"$E$N$"+name1+"~";		
		if(eval("parent.frames[1].document.forms[0].chkGlobe"+chk))
		    eval("parent.frames[1].document.forms[0].chkGlobe"+chk).disabled=false;	
		
		for(var y=start;parseInt(y)<=parseInt(end);y++)
     	{
			if(eval("parent.frames[1].document.forms[0].chk"+y))
			   if(eval("parent.frames[1].document.forms[0].chk"+y).checked==false)
				  count++;								
		}
		if(count==0)
               parent.frames[1].document.forms[0].mainChk.checked=true;
		else
			  parent.frames[1].document.forms[0].mainChk.checked=false;			

	}				
	else 
	{ 				 
		if(eval("parent.frames[1].document.forms[0].chkGlobe"+chk)){
			eval("parent.frames[1].document.forms[0].chkGlobe"+chk).checked=false;
			eval("parent.frames[1].document.forms[0].chkGlobe"+chk).disabled=true;
		}
		if( parent.frames[1].document.forms[0].mainChk.checked==true){
	         parent.frames[1].document.forms[0].mainChk.checked=false;  			 
			 if( parent.frames[1].document.forms[0].global_Chk){	              			
				  parent.frames[1].document.forms[0].global_Chk.checked=false;			     
			 }
		}		
		temp+=Obj.value+"$"+Obj.name+"$D$N$"+name1+"~";				
	}	
	parent.frames[1].document.forms[0].finalSelect.value=temp;	
	//alert("temp====>"+temp);
	
}




function chkServices_global(obj,chk)
{
	var cnt=parent.frames[1].document.forms[0].end.value;
	var end=parent.frames[1].document.forms[0].end.value;
    var start=parent.frames[1].document.forms[0].start.value;	
	var gcount='0';
	var value1=eval("parent.frames[1].document.forms[0].chk"+chk).value;
	var name1=eval("parent.frames[1].document.forms[0].chk"+chk).name;
	if(obj.checked)
	{
		temp=parent.frames[1].document.forms[0].finalSelect.value;	   
		temp+=value1+"$"+name1+"$E$Y$"+obj.name+"~";	
		for(var y=start;parseInt(y)<=parseInt(end);y++)
     		{
				if(eval("parent.frames[1].document.forms[0].chkGlobe"+y))
					 if(eval("parent.frames[1].document.forms[0].chkGlobe"+y).checked==false)
						 gcount++;								
			}		
		if(gcount==0){
               parent.frames[1].document.forms[0].global_Chk.checked=true;
               parent.frames[1].document.forms[0].global_Chk.disabled=false;
		}
		else
			  parent.frames[1].document.forms[0].global_Chk.checked=false;		
	}				
	else if(obj.checked==false)
		{	
			temp+=value1+"$"+name1+"$E$N$"+obj.name+"~";		
			parent.frames[1].document.forms[0].global_Chk.checked=false;	
		}
	parent.frames[1].document.forms[0].finalSelect.value=temp;
}


function chkAll_Global(Obj){
	var end=parent.frames[1].document.forms[0].end.value;
	var start=parent.frames[1].document.forms[0].start.value;
	var y;
	var name1='';
	var value1='';
	var name='';
	if(Obj.checked){
		for(y=start;parseInt(y)<=parseInt(end);y++){
			if(eval("parent.frames[1].document.forms[0].chk"+y)){
					value1=eval("parent.frames[1].document.forms[0].chk"+y).value;
					name=eval("parent.frames[1].document.forms[0].chk"+y).name;
					if(eval("parent.frames[1].document.forms[0].chk"+y+".checked")){
						eval("parent.frames[1].document.forms[0].chkGlobe"+y+".checked=true");
						name1=eval("parent.frames[1].document.forms[0].chkGlobe"+y).name;
					}
					temp+=value1+"$"+name+"$E$Y$"+name1+"~";
				}
			}
	 	
	}else{
		for(y=start;parseInt(y)<=parseInt(end);y++){
			if(eval("parent.frames[1].document.forms[0].chk"+y)){
					value1=eval("parent.frames[1].document.forms[0].chk"+y).value;
					name=eval("parent.frames[1].document.forms[0].chk"+y).name;
					eval("parent.frames[1].document.forms[0].chkGlobe"+y+".checked=false");
					name1=eval("parent.frames[1].document.forms[0].chkGlobe"+y).name;
					temp+=value1+"$"+name+"$E$N$"+name1+"~";
				   }
			}
	}
	parent.frames[1].document.forms[0].finalSelect.value=temp;
}


function chkAll(Obj){

	var end=parent.frames[1].document.forms[0].end.value;
	var start=parent.frames[1].document.forms[0].start.value;
	var y=start;
	var global_available=parent.frames[1].document.forms[0].global_available.value;
	var name1='';
	var value1='';
	var name='';
	
	if(Obj.checked){
		for(y=start;parseInt(y)<=parseInt(end);y++){
			if(eval("parent.frames[1].document.forms[0].chk"+y)){
				eval("parent.frames[1].document.forms[0].chk"+y+".checked=true");
				value1=eval("parent.frames[1].document.forms[0].chk"+y).value;
				name=eval("parent.frames[1].document.forms[0].chk"+y).name;
				if(global_available=="Y"){
					eval("parent.frames[1].document.forms[0].chkGlobe"+y).disabled=false;
					parent.frames[1].document.forms[0].global_Chk.disabled=false;
					name1=eval("parent.frames[1].document.forms[0].chkGlobe"+y).name;
				}

			temp+=value1+"$"+name+"$E$N$"+name1+"~";

			}
		}
	}else{
		for(y=start;parseInt(y)<=parseInt(end);y++){
			if(eval("parent.frames[1].document.forms[0].chk"+y)){
			eval("parent.frames[1].document.forms[0].chk"+y+".checked=false");
			value1=eval("parent.frames[1].document.forms[0].chk"+y).value;
			name=eval("parent.frames[1].document.forms[0].chk"+y).name;
			if(global_available=="Y"){
				eval("parent.frames[1].document.forms[0].chkGlobe"+y+".checked=false");
				eval("parent.frames[1].document.forms[0].chkGlobe"+y).disabled=true;
				parent.frames[1].document.forms[0].global_Chk.checked=false;
				parent.frames[1].document.forms[0].global_Chk.disabled=true;
				name1=eval("parent.frames[1].document.forms[0].chkGlobe"+y).name;
			}
			temp+=value1+"$"+name+"$D$N$"+name1+"~";
			}
		}
	}
	parent.frames[1].document.forms[0].finalSelect.value=temp;		
}

