/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name        	Rev.Date	Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
?             	100            		?           	?			?				created
30/07/2015		IN037505			Karthi										[SRR20056-SCF-9373 ] - IN037471	After select Start Date/time and Duration, System doesn?t calculate and display Ending date/time. 
---------------------------------------------------------------------------------------------------------------
*/
function CheckSystemDateLesserDiag(from,today){ //args objects 1st is this object & second is the date in dd/mm/yyyy
	if(today != "" && from.value !="" ){
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today ;
				var fromdate1;
				var fromdate2;
				var todate1;
				var todate2;
				var tot1;
				var tot2;
				
				if(fromdate.length > 10)
				{
				 fromdate1 = fromdate.substring(11, 13) ;
				 fromdate2 = fromdate.substring(14, 16) ;	
				 fromdate = fromdate.substring(0, 10) ;
				 tot1=fromdate1+fromdate2;
				}
					

				if(todate.length > 10)
				{
				 todate1 = todate.substring(11, 13) ;
				 todate2 = todate.substring(14, 16) ;	
				 todate = todate.substring(0, 10) ;
				 tot2=todate1+todate2;
				}
					
					
		            
				if(fromdate.length > 0 && todate.length > 0 )
				{
					fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						
						if(Date.parse(todt) < Date.parse(fromdt))
						{
							
							var msg =getMessage("FROM_DATE_GREATER_SYSDATE","CA");
							//var msg =getMessage("DATE_GREATER_SYSDATE","");
							alert(msg);
							from.focus();
							from.select();
							return false;
							
						}
						
                        else if(Date.parse(todt) > Date.parse(fromdt))
						{
						return true
						}
						
						else 
						{
							
							if(Date.parse(todt) == Date.parse(fromdt))
							{
//							top.messageframe.location.href = '../../eCommon/jsp/error.jsp?';
                           if(tot1>tot2)
							{
								var msg =getMessage("FROM_DATE_GREATER_SYSDATE","CA");
								//var msg =getCAMessage("DATE_GREATER_SYSDATE");
								alert(msg);
								from.focus();
								from.select();
								return false;
							}

							}
						}
				}
			return true;
	 }
	 return true;
}



function checkIsNull(obj)
{
	if(trimCheck(obj.value)=='')
		return true;
	else
		return false;
}

function checkDateWithCurrentDate(toDateTime)
{
	var toDate = toDateTime.split(" ");
	var toarray = toDate[0].split("/");
	var enteredDate = new Date(toarray[2],toarray[1],toarray[0]);

	var today = new Date();
	var date= today.getDate();
	var month = today.getMonth() + 1;
	var year = today.getYear();
	today = new Date(year,month,date);
	if(enteredDate > today)
	{
		return true;
	}
	return false;
}

function checkPeriodFromTo(selOpt)
{
	
	var from_date_time	=	document.forms[0].from_date;
	var to_date_time	=	document.forms[0].to_date;
	if(checkIsNull(from_date_time) && checkIsNull(to_date_time) ) 
	{
		return true;
	}

	if(checkIsNull(from_date_time)==false)
	if(!doDateTimeChk(from_date_time))
	{
		
		alert(getMessage("INVALID_DATE_TIME","CA"));
		from_date_time.select();
		from_date_time.focus();
		return false;
	}
    if(checkIsNull(to_date_time)==false)
	if(!doDateTimeChk(to_date_time)) 
	{ 
		alert(getMessage("INVALID_DATE_TIME","CA"));
		to_date_time.select();
		to_date_time.focus();
		return false;
	}
	if(checkIsNull(to_date_time)==false)
	if(checkDateWithCurrentDate(to_date_time.value))
	{
		var msg =getMessage("FROM_DATE_GREATER_SYSDATE","CA");	
		//var msg =getCAMessage("DATE_GREATER_SYSDATE");
		alert(msg);
		to_date_time.select();
		to_date_time.focus();
		return false;
	}
	if(!checkIsNull(to_date_time) && !checkIsNull(from_date_time))
	if(!ValidateDateTime(from_date_time,to_date_time))
	{
		
		var msg=getMessage("TO_DT_GR_EQ_FM_DT","CA");		
		alert(msg);
//		to_date_time.select();
		//to_date_time.focus();
		/*if(selOpt == "F")
		{
			
			from_date_time.select();
			from_date_time.focus();
		}
		else
		{
			to_date_time.select();
			to_date_time.focus();
		}*/
		//from_date_time.select();
		//from_date_time.focus();
		return false;
	}
	
	
	
	//parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp";
	return true;
}


function ValidateprefDateTime(obj1)
{	
	var obj=obj1.value;
	if(obj!='')
	{
	
		//alert(obj.length);
		if(obj.length != 16)
		{
			alert(getMessage("INVALID_DATE_TIME","CA"));
			//obj1.value = "";
			obj1.focus();
			obj1.select();
		}
	/*var a = obj.split(" ")
	splitdate=a[0];
	splittime=a[1]
	


	var splitdate1 =a[0].split("/")
	var splittime2= a[1].split(":")

	//alert("splitdate1 : "+splitdate1);
	//alert("splittime2[0] : "+splittime2[0]);
	//alert("splittime2[1] : "+splittime2[1]);


	if(splittime2[0].length <= 1)
	{
		alert("APP-SM0041 Invalid Date Time Format");
		//obj1.value = "";
		obj1.focus();
		obj1.select();
		//return false ;
	}
	else if(splittime2[1].length <= 1)
	{
		alert("APP-SM0041 Invalid Date Time Format");
		//obj1.value = "";
		obj1.focus();
		obj1.select();
		//return false ;
	}*/
	else
	{
		return true
	}
	}
}	







//function for PatListByLocationCriteria.jsp starts

function doDateCheckLoc(from,to,obj,obj1) {
			if(CheckSystemDateLesser(obj,obj1)){
				if(!doDateCheckAlert(from,to)){
					alert(top.header.getMessage("TO_DT_GR_EQ_FM_DT","CA"));
					obj.select();
					obj.focus();
					return false;
				}
			}
		}


function doDateCheckFrom(from,today) { //args greater should be passed as 1st Arguments
 if(from.value != "" && today.value !="" )
	 {
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today.value ;
				
				if(fromdate.length > 10)
				{
					
					 
					 fromdate = fromdate.substring(0, 10) ;
					 
				}
				if(todate.length > 10)
				{
					
					 todate = todate.substring(0, 10) ;
					 
				}

				
				if(fromdate.length > 0 && todate.length > 0 ) {
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						if(Date.parse(todt) > Date.parse(fromdt)) {
							var msg = getMessage("TO_DT_GR_EQ_FM_DT","CA");
							alert(msg);
							//top.messageframe.location.href = '../../eCommon/jsp/error.jsp?err_num='+msg;
							//today.focus();
							//today.select();
							return false;
						}
						else if(Date.parse(todt) <= Date.parse(fromdt))
						{
	//						top.messageframe.location.href = '../../eCommon/jsp/error.jsp?';
							return true;
						}

						
						
												
						}
			return true;
	 }
	 return true;
}

// to point to the object which is passed as third parameter

function doDateCheckFrom(from,today,obj) { //args greater should be passed as 1st Arguments
 if(from.value != "" && today.value !="" )
	 {
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today.value ;

				if(fromdate.length > 10)
					fromdate = fromdate.substring(0, 10) ;

				if(todate.length > 10)
					todate	=  todate.substring(0, 10) ;

				
				if(fromdate.length > 0 && todate.length > 0 ) {
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						if(Date.parse(todt) > Date.parse(fromdt)) {
							var msg = getMessage("TO_DT_GR_EQ_FM_DT","CA");
							alert(msg);
							//top.messageframe.location.href = '../../eCommon/jsp/error.jsp?err_num='+msg;
							//obj.focus();
							//obj.select();
							return false;
						}
						else if(Date.parse(todt) <= Date.parse(fromdt))
						{
	//						top.messageframe.location.href = '../../eCommon/jsp/error.jsp?';
							return true;
						}
						}
			return true;
	 }
	 return true;
}

function doDateCheck(from,to,obj,obj1) {
			if(CheckSystemDateLesser(obj,obj1)){
				if(!doDateCheckAlert(from,to)){
					alert(getMessage("FROM_DATE_GREAT_EFF","CA"));
					//alert('APP-SM0005 From Date Should Not Be Less than To Date');
					obj.select();
					obj.focus();
					return false;
				}
			}
		}




//Functions for the file name AddModifyOPProc.jsp-start


function checkminutes(obj,sysdt,flag)
{
	var from = obj.value;
	var to = sysdt;
	
if(to!="" && from!="")
{
	
	var a=  from.split(" ")
	
		splitdate=a[0];
		splittime=a[1];

		var splitdate1 =splitdate.split("/")
		var splittime1= splittime.split(":")

		var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		var from_date1 = new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]))

		a=  to.split(" ")
		splitdate=a[0];
		splittime=a[1];

		splitdate1 =splitdate.split("/")
		splittime1= splittime.split(":")

		var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		var to_date1 = new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]));

  // alert( to_date +" "+from_date);
	
if(Date.parse(to_date1) == Date.parse(from_date1)){
/*	if(Date.parse(to_date) > Date.parse(from_date)){

        if(flag=='S')
			alert('Starting Time Should Not Be Less than System Time');
		else
			alert('Ending Time Should Not Be Less than System Time');
	    obj.select();
	    obj.focus();
     	return false;
    }*/
    if((Date.parse(to_date) < Date.parse(from_date))){
		if(flag=='S')
		{
			alert(getMessage("START_TIME_LESS_SYS_TIME","CA"));
			
		}
		else{
			document.OPProc_form.Hrs.value="0";
			document.OPProc_form.Min.value="0";	
			alert(getMessage("END_TIME_MORE_SYS_TIME","CA"));
			}
	 	obj.value="";
//		obj.select();
	    obj.focus();
		window.event.returnValue = false;
		return false;
    }
	else
        return true;
}
else if(Date.parse(to_date1) < Date.parse(from_date1)){
	var msg =getMessage("FROM_DATE_GREATER_SYSDATE","CA");
		alert(msg);
		obj.value="";
		document.forms[0].Hrs.value = 0;
		document.forms[0].Min.value = 0;
		//obj.select();
		obj.focus();
		window.event.returnValue = false;
		return false;
}
else
	return true;
}	

}
function clear_hrs()
{
	if(document.OPProc_form.enddate.value==""){
		document.OPProc_form.Hrs.value="";			document.OPProc_form.Min.value="";
	}
}

function ValidateStartDateTime(from,to,obj,obj1,flag)
{
 
  if(checkminutes(obj,obj1,flag)){
	
	if(doDateCheckFrom(to,from,obj))
	{
	from = from.value
    to   = to.value
	if(to!="" && from!="")
	{
		var a=  from.split(" ")
		splitdate=a[0];
		splittime=a[1]

		var splitdate1 =splitdate.split("/")
		var splittime1= splittime.split(":")

		var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		a=  to.split(" ")
		splitdate=a[0];
		splittime=a[1]

		splitdate1 =splitdate.split("/")
		splittime1= splittime.split(":")

		var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

    if(Date.parse(to_date) < Date.parse(from_date)){

        alert(getMessage("START_TIME_LESS_END_TIME","CA"));
		obj.value="";
		//obj.select();
		document.forms[0].Hrs.value = 0;
		document.forms[0].Min.value = 0;
	    obj.focus();
		window.event.returnValue = false;
     	return false;
    }
    else
        return true;
	}
   }
 }
}

function ValidateEndDateTime(from,to,obj,obj1,flag)
{

//alert("o "+obj+" s "+obj1);
if(checkminutes(obj,obj1,flag)){
	if(doDateCheckFrom(to,from,obj))
	{
	
	from = from.value
    to   = to.value
	if(to!="" && from!="")
	{
		var a=  from.split(" ")
		splitdate=a[0];
		splittime=a[1]

		var splitdate1 =splitdate.split("/")
		var splittime1= splittime.split(":")

		var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		a=  to.split(" ")
		splitdate=a[0];
		splittime=a[1]

		splitdate1 =splitdate.split("/")
		splittime1= splittime.split(":")

		var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

    if(Date.parse(to_date) < Date.parse(from_date)){

        alert(getMessage("END_TIME_LESS_START_TIME","CA"));
		obj.value="";
		//obj.select();
		document.forms[0].Hrs.value = 0;
		document.forms[0].Min.value = 0;
	    obj.focus();
		window.event.returnValue = false;
     	return false;
    }
    else
        return true;
	}
  }
 }
}



/*	
function doDateCheckFrom1(from,to){
		if(!doDateCheckFrom(to,from)){
			alert(1);
		}else{
			alert(2);
		}
	}
*/

function checkDur(obj){
		/*if (obj.name=='Hrs'){
				if (eval(obj.value)>23){
						alert("Hours Should be less than 24");
						obj.select();
						obj.focus();
				}
		}else  if (obj.name=='Min'){
					if (eval(obj.value)>59){
						alert("Min Should be less than 60");
						obj.select();
						obj.focus();
					}
		}*/
}
	function doDateCheck(from,to,obj) {
			if(!doDateCheckAlert(from,to)){
				 alert(getMessage("STAR_DATE_LESS_END_DATE","CA"));
				obj.value="";
				//obj.select();
				obj.focus();
				window.event.returnValue = false;
				return false;
			}
	}

	function timeCalculate(obj)
	{
		var startdate = document.forms[0].date.value;
		var enddate = document.forms[0].enddate.value;
		var hours = document.forms[0].Hrs.value;
		var minutes = document.forms[0].Min.value;
		var modal_yn = document.forms[0].modal_yn.value;
		var p_called_from_widget = document.forms[0].p_called_from_widget.value; //CHL-CRF [IN035950]
		var p_locale = document.forms[0].locale.value; //SRR20056-SCF-9395 [IN037505]
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	= "<root><SEARCH " ;
		xmlStr += " /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		//CHL-CRF Start. [IN035950]
		//xmlHttp.open( "POST","../../eCA/jsp/PatProcTimeCalculate.jsp?startdate="+startdate+"&enddate="+enddate+"&hours="+hours+"&minutes="+minutes+"&flag="+obj.name+"&modal="+modal_yn, false);
		xmlHttp.open( "POST","../../eCA/jsp/PatProcTimeCalculate.jsp?startdate="+startdate+"&enddate="+enddate+"&hours="+hours+"&minutes="+minutes+"&flag="+obj.name+"&modal="+modal_yn+"&p_called_from_widget="+p_called_from_widget+"&p_locale="+p_locale, false); //added p_locale for SRR20056-SCF-9395 [IN037505]
		//CHL-CRF End. [IN035950]
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval( responseText.replace(/<\/?[^>]+(>|$)/g, "")) ;
		
		//Commented by Jyothi to fix 26248 on 07/02/2011
		/*HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempForm' id='tempForm' method='post' action='PatProcTimeCalculate.jsp'><input type=hidden name='startdate' id='startdate' value='"+startdate+"'><input type=hidden name='enddate' id='enddate' value='"+enddate+"'><input type=hidden name='hours' id='hours' value='"+hours+"'><input type=hidden name='minutes' id='minutes' value='"+minutes+"'><input type=hidden name='flag' id='flag' value='"+obj.name+"'><input type=hidden name='modal' id='modal' value='"+ document.OPProc_form.modal_yn.value+"'></form></body></html>"
		

			//	alert('modal_yn='+modal_yn);
		if(modal_yn == "N"){
				top.content.messageFrame.document.write(HTMLVal);
				top.content.messageFrame.document.tempForm.submit();
		}else{
				parent.messageFrame.document.write(HTMLVal);
	            parent.messageFrame.document.tempForm.submit();
		}*/
	}


//Functions for the file name AddModifyOPProc.jsp-end

