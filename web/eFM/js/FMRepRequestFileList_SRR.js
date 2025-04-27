function doDateCheckFrom(from,today) { //args objects 1st is this object & second is the date object
 if(from.value != "")
	 {
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today.value ;
				
				if(fromdate.length > 0 && todate.length > 0 ) { 
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						if(Date.parse(todt) < Date.parse(fromdt)) { 
					//	if(isBefore(fromdate,todate,"DMY",localeName)) 
					//	{
							var msg = getMessage('FROM_DATE_GREATER_TO_DATE','FM');
							messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
							from.focus();
							from.select();
							return false;
						}
						else if(Date.parse(todt) <= Date.parse(fromdt))
						{
							
							messageFrame.location.href='../../eCommon/jsp/error.jsp?' ;
							return true;
						}
						}
			return true;
	 }
	return true;
}

 function doDateCheckto(from,today) { //args objects 1st is this object & second is the date object
 if(today.value != "")
	 {
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today.value ;
				
				if(fromdate.length > 0 && todate.length > 0 ) {
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
					//	if(Date.parse(todt) > Date.parse(fromdt)) 
						if(isBefore(fromdate,todate,"DMY",localeName))
						{
							var msg = getMessage('TO_DATE_LESSER_FROM_DATE','FM');
							messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
							from.focus();
							from.select();
							return false;
						}
						else if(Date.parse(todt) <= Date.parse(fromdt))
						{
							messageFrame.location.href='../../eCommon/jsp/error.jsp?' ;
							return true;
						}
						}
			return true;
	 }
	return true;
}
   
function CheckSystemDateLesser(from,today) { //args objects 1st is this object & second is the date in dd/mm/yyyy
 if(today != "" && from.value !="" )
	 {

				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today ;
				
				if(fromdate.length > 0 && todate.length > 0 )
				{
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						//if(Date.parse(todt) < Date.parse(fromdt))
						if(!isBefore(fromdate,todate,"DMY",localeName))
						{
							var msg =getMessage("DATE_LESS_SYS_DATE","FM");
							messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
							from.focus();
							from.select();
							return false;
						}
						else if(Date.parse(todt) >= Date.parse(fromdt))
						{
							messageFrame.location.href='../../eCommon/jsp/error.jsp?' ;
							return true;
						}
				}
			return true;
	 }
	 return true;
}




 function reset()
 {
//	searchFrame.document.forms[0].reset(); 
	searchResultFrame.document.location.href="../../eFM/jsp/FMRequestFileListDetail_SRR.jsp"; 
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp'; 
 }

 function run() 
 {

	             var fields = new Array();
				var names = new Array ();
				fields[fields.length] = searchResultFrame.document.forms[0].p_iss_fs_locn;
				names[names.length] = getLabel('eFM.IssuingFSLocation.label','FM');
				fields[fields.length] = searchResultFrame.document.forms[0].P_DATE_CRITERIA;
				names[names.length] = getLabel('Common.date.label','common')+" "+getLabel('Common.criteria.label','common');
			  	if(searchResultFrame.document.forms[0].P_DATE_CRITERIA.value=='1')
				{
              	fields[fields.length] = searchResultFrame.document.forms[0].P_FROM_DATE;
				names[names.length] = getLabel('Common.fromdate.label','common');
                 fields[fields.length] = searchResultFrame.document.forms[0].P_TO_DATE;
				 names[names.length] = getLabel('Common.todate.label','common');
				}if(searchResultFrame.document.forms[0].P_DATE_CRITERIA.value=='2')
				{
               	fields[fields.length] = searchResultFrame.document.forms[0].P_FROM_DATE;
				names[names.length] = getLabel('Common.fromdate.label','common');
                 fields[fields.length] = searchResultFrame.document.forms[0].P_TO_DATE;
				names[names.length] = getLabel('Common.todate.label','common');
        		} 
						
				if(checkFields(fields,names,messageFrame))
				searchResultFrame.document.forms[0].submit(); 
			  
			  if(searchResultFrame.document.forms[0].P_DATE_CRITERIA.value=='1')	{	
										
					/*CheckSystemDateLesser(searchResultFrame.document.forms[0].p_from_date,	
							  searchResultFrame.document.forms[0].today.value)&&
					CheckSystemDateLesser(searchResultFrame.document.forms[0].p_to_date,
								searchResultFrame.document.forms[0].today.value)*/

					if(doDateCheckFrom(searchResultFrame.document.forms[0].P_FROM_DATE,	
							  searchResultFrame.document.forms[0].P_TO_DATE)){ 
								if(checkFields( fields, names, messageFrame))
									 searchResultFrame.document.forms[0].submit();
								} 
					}

			if(searchResultFrame.document.forms[0].P_DATE_CRITERIA.value=='2')	{		
				
					/*CheckSystemDateLesser(searchResultFrame.document.forms[0].P_FL_REQR_FM_DATE,	
							  searchResultFrame.document.forms[0].today.value)&&
					CheckSystemDateLesser(searchResultFrame.document.forms[0].P_FL_REQR_TO_DATE,
								searchResultFrame.document.forms[0].today.value)	*/	

						if(doDateCheckFrom(searchResultFrame.document.forms[0].P_FROM_DATE,	
							  searchResultFrame.document.forms[0].P_TO_DATE)){
								if(checkFields( fields, names, messageFrame))
									 searchResultFrame.document.forms[0].submit();
								 }
						}

				/*var fields = new Array (searchResultFrame.document.forms[0].p_iss_fs_locn);
				var names = new Array ( getLabel('eFM.IssuingFSLocation.label','FM'))*/				
		 
 }

 function DateCompare(from,to,messageFrame,getVal) 
{
	var getValue = getVal;
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) 
	{
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
	///	if(Date.parse(todt) < Date.parse(fromdt)) 
		if(!isBefore(fromdate,todate,"DMY",localeName))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			to.select();
			return false;
		}
		else if(Date.parse(todt) >= Date.parse(fromdt)) 
		{
			return true;
		}
	}
	return true;
}

function callreport(obj)
{
	if (obj.value=='1')
	{
		document.forms[0].p_report_id.value='FMBREQLS';
	}else
	{
		document.forms[0].p_report_id.value='FMBREQPT';
	}

}
function date_cri_link(obj,val)
{
	var val=obj.value;
		var flag=val;
	document.getElementById("from").innerHTML=getLabel("Common.from.label","Common");
	document.getElementById("to").innerHTML=getLabel("Common.to.label","Common");

	if(val=="1")
	{
      document.getElementById("test").innerHTML=getLabel("Common.Request.label","Common") +"  "+ getLabel("Common.date.label","Common");
	  document.getElementById("test1").innerHTML="<input type='text' name='P_FROM_DATE' id='P_FROM_DATE' size='10' onBlur = 'if(validDateObj(this,\"DMY\",\""+localeName+"\")){setDate(this);}' maxlength='10' value='' id='P_FROM_DATE'><img onClick=\"return showCalendar('P_FROM_DATE');\"  src='../../eCommon/images/CommonCalendar.gif'/><img align=center src='../../eCommon/images/mandatory.gif'></img>";
	 document.getElementById("test2").innerHTML="&nbsp;"+"<input type='text' name='P_TO_DATE' id='P_TO_DATE' size='10'  maxlength='10' onBlur ='if(validDateObj(this,\"DMY\",\""+localeName+"\")){setDate(this);}' value=''  id='P_TO_DATE' ><img  onClick=\"return showCalendar('P_TO_DATE');\"  src='../../eCommon/images/CommonCalendar.gif'/><img align=center src='../../eCommon/images/mandatory.gif'></img>";

	} else if(val=="2")
	{
	document.getElementById("test").innerHTML=getLabel("eFM.RequireonDate.label","eFM");
    document.getElementById("test1").innerHTML="<input type='text' name='P_FROM_DATE' id='P_FROM_DATE' size='10' onBlur = 'if(validDateObj(this,\"DMY\",\""+localeName+"\")){setDate(this);}' maxlength='10' value='' id='P_FROM_DATE'><img onClick=\"return showCalendar('P_FROM_DATE');\"  src='../../eCommon/images/CommonCalendar.gif'/><img align=center src='../../eCommon/images/mandatory.gif'></img>";
    document.getElementById("test2").innerHTML="&nbsp;"+"<input type='text' name='P_TO_DATE' id='P_TO_DATE' size='10'  maxlength='10' onBlur ='if(validDateObj(this,\"DMY\",\""+localeName+"\")){setDate(this);}' value='' id='P_TO_DATE' ><img onClick=\"return showCalendar('P_TO_DATE');\" src='../../eCommon/images/CommonCalendar.gif'/><img align=center src='../../eCommon/images/mandatory.gif'></img>";
    }else{
     document.getElementById("from").innerHTML="";
	document.getElementById("to").innerHTML="";
	  document.getElementById("test").innerHTML="";
	  document.getElementById("test1").innerHTML="";
	 document.getElementById("test2").innerHTML="";
	  }
	     }

	function setDate(Object)    { // function to set either Date of Birth or Day Month Age

       var currentDate = new Date();
     var p_date_criteria=document.forms[0].P_DATE_CRITERIA.value;
	
	 if(p_date_criteria=="1")
		{
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
	
	}

