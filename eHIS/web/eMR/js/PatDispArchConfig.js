function apply(){
	var splFiledsList = frames[1].frames[1].document.getElementsByTagName('input');
	var selectedSpeciality	= "";
	for (i = 0; i < splFiledsList.length; i++) {
		if (splFiledsList[i].type == 'text') {
			if(splFiledsList[i].value!=""){
				selectedSpeciality	= selectedSpeciality + splFiledsList[i].name+",";
			}
		}
	}
	if(selectedSpeciality==""){
		var msg = getMessage("ATLEAST_ONE_RECORD_ENTERED","Common");
		messageFrame.location='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg ;
	}else{
		selectedSpeciality	= selectedSpeciality.slice(0, -1); 

		frames[1].frames[1].document.forms[0].selectedSpecialityLists.value	= selectedSpeciality;
		frames[1].frames[1].document.forms[0].submit();
	}
}


function checkZero(obj) {
	if(obj.value!='')
	{
	  if (obj.value==0)
	  {
		  alert(getMessage('VALUE_SHOULD_BE_GR_ZERO','Common'));
		  obj.value="";
		  obj.focus();
	  }
    }
}

function fnArchDispChgn(obj){
		parent.frames[0].document.forms[0].submit();
}



function reset() {
	f_query_add_mod.location.reload();
} 

function onSuccess(){	
	frames[1].frames[0].location.href="";
	f_query_add_mod.location.reload();
}
