function CheckPositiveNumberMy(obj) {
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
    }
    else {
        if ( obj.value.length > 0 ) {
			alert(getMessage("ONLY_POSITIVE_NUM","SM")); 
            obj.select();
            obj.focus();
			return false;
        }
        else if ( obj.value.length == 0 )
		{
            obj.value ="";
			return true;
		}
    }
	return true;
}

function CheckDateGreater(from,today) { //args objects 1st is this object & second is the date object
 if(from.value != "")
	 {
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today ;
				
				if(fromdate.length > 0 && todate.length > 0 ) {
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						if(Date.parse(todt) > Date.parse(fromdt)) {
							/*alert("APP-FM076 - from date should be greater than to date");
							from.select();
							from.focus();
							return false; */
							var msg = getMessage('FROM_DATE_GREATER_TO_DATE','FM');
							parent.frames[3].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
							from.focus();
							from.select();
							return false;
						}
						else if(Date.parse(todt) <= Date.parse(fromdt))
						{
							parent.frames[3].location.href='../../eCommon/jsp/error.jsp?' ;
							return true;
						}
						}
			return true;
	 }
}


function strcmp(str1,str2)
{
	if(str1==str2)
		return 0;
	else if(str1<str2)
		return -1;
	else return 1;
} 

function date_cri_link(obj,val){	
	var value=val;	
	var val=obj.value;
	var flag=val;	
	if(val=="I"){
		document.getElementById("test").innerHTML=getLabel("Common.Issue.label","Common") +" "+ getLabel("Common.date.label","Common");
		if(flag==""){
			document.getElementById("test1").innerHTML="&nbsp;&nbsp;&nbsp;"+""+getLabel("Common.from.label","Common") +"&nbsp;&nbsp;&nbsp;"+"<input type='text' name='p_fm_iss_date' id='p_fm_iss_date' size='10' onBlur = 'if(validDateObj(this,\"DMY\",\""+localeName+"\")){setDate(this);DateCompare(this,p_fm_iss_date, \"messageFrame\",\"to\");}' maxlength='10' value='' id='date_from'><img onClick=\"return showCalendar('date_from');\"   src='../../eCommon/images/CommonCalendar.gif'/>";
		}else{ 
			if(value=="identity"){		
				document.getElementById("test1").innerHTML=getLabel("Common.from.label","Common") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"<input type='text' name='p_fm_iss_date' id='p_fm_iss_date' size='10' onBlur='if(validDateObj(this,\"DMY\",\""+localeName+"\")){setDate(this);DateCompare(this,p_fm_iss_date, \"messageFrame\",\"to\");}' maxlength='10' value='' id='date_from'><img onClick=\"return showCalendar('date_from');\"  src='../../eCommon/images/CommonCalendar.gif'  id='from_calend'/>";		 
				document.getElementById("test2").innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+""+getLabel('Common.to.label','Common') +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"<input type='text' name='p_to_iss_date' id='p_to_iss_date' size='10'  maxlength='10' onBlur ='if(validDateObj(this,\"DMY\",\""+localeName+"\")){setDate(this);DateCompare(this,p_to_iss_date, \"messageFrame\",\"to\");}' value='' id='date_to' ><img onClick=\"return showCalendar('date_to');\" src='../../eCommon/images/CommonCalendar.gif'  id='to_calend'/>";
			}else{
				document.getElementById("test1").innerHTML=getLabel("Common.from.label","Common") +"&nbsp;&nbsp;&nbsp;&nbsp;"+"<input type='text' name='p_fm_iss_date' id='p_fm_iss_date' size='10' onBlur='if(validDateObj(this,\"DMY\",\""+localeName+"\")){setDate(this);DateCompare(this,p_fm_iss_date, \"messageFrame\",\"to\");}' maxlength='10' value='' id='date_from'><img onClick=\"return showCalendar('date_from');\"  src='../../eCommon/images/CommonCalendar.gif'  id='from_calend'/>";
				document.getElementById("test2").innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+""+getLabel('Common.to.label','Common') +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"<input type='text' name='p_to_iss_date' id='p_to_iss_date' size='10'  maxlength='10' onBlur ='if(validDateObj(this,\"DMY\",\""+localeName+"\")){setDate(this);DateCompare(this,p_to_iss_date, \"messageFrame\",\"to\");}' value='' id='date_to' ><img onClick=\"return showCalendar('date_to');\" src='../../eCommon/images/CommonCalendar.gif'  id='to_calend'/>";
			}
		}
	}else if(val=="P"){
  		if(document.forms[0].maintain_doc_or_file.value=="F")
		{ 
	 document.getElementById("test").innerHTML=getLabel("eFM.Filespendingformorethan.label","FM") ;
		}
	 if(document.forms[0].maintain_doc_or_file.value=="D")
		{ 
	document.getElementById("test").innerHTML=getLabel("eFM.Documentspendingformorethan.label","FM");
		}
	 if(flag=="")
		{
	  document.getElementById("test1").innerHTML="&nbsp;"+"<input type='text' name='p_no_of_days' id='p_no_of_days' value=''  size='2'	maxlength='3' onBlur='CheckPositiveNumberMy(this);'>&nbsp;Days&nbsp";
		}
	  else{ 
		  if(value=="identity"){	    		  document.getElementById("test1").innerHTML="<input type='text' name='p_no_of_days' id='p_no_of_days' value=''  size='2'	maxlength='3' onBlur='CheckPositiveNumberMy(this);'>&nbsp;Days";
		 }
		 else {
	     document.getElementById("test1").innerHTML="<input type='text' name='p_no_of_days' id='p_no_of_days' value=''  size='2'	maxlength='3' onBlur='CheckPositiveNumberMy(this);'>&nbsp;Days&nbsp";
		 }
	  }
	  document.getElementById("test2").innerHTML="";
   
	}else{ 
      document.getElementById("test").innerHTML="";
	  document.getElementById("test1").innerHTML="";
	 document.getElementById("test2").innerHTML="";
	  }
	
}

 function DateCompare(from,to,messageFrame,getVal) 
{
	
	var getValue = getVal;
	var fromarray; var toarray;
	var fromdate = from.value ;	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) 
	{
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
	///	if(Date.parse(todt) < Date.parse(fromdt)) 
		
		if(!isBefore(fromdate,todate,"DMY",localeName))
		{
			if(getValue=="from")
			{
              alert(getMessage("FROM_DATE_GREATER_TO_DATE","FM"));
			//from.select();
			//from.focus();
			return false;
			}else{
			alert(getMessage("TO_DATE_LESSER_FROM_DATE","FM"));
			//to.focus();
			return false;
			}
		}
		else if(Date.parse(todt) >= Date.parse(fromdt)) 
		{
			return true;
		}
			
	}
	return true;
}



function setDate(Object)    { // function to set either Date of Birth or Day Month Age

var currentDate = new Date();
       if(Object.value!="")
	{
	   if (isBeforeNow(Object.value,"DMY",localeName))
        {
          return true;
        }
        else
        {
               alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
				Object.value="";
                Object.focus();
            
        }
    }
	}

