function create() {
	f_query_add_mod.location.href = "../../eSM/jsp/addModifyMaintainActPeriod.jsp" ;
}
function query() {
	//f_query_add_mod.location.href = "../../eSM/jsp/MaintainAcctPeriodResult.jsp" ;
	f_query_add_mod.location.href = "../../eSM/jsp/MaintainAcctPeriodQuery.jsp" ;
	
}


function reset()
{
	if (! (checkIsValidForProceed()) )
    {
       
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		f_query_add_mod.location.reload();

        return false;
    } 
		//f_query_add_mod.document.forms[0].reset();
		f_query_add_mod.document.location.reload();
		
}
function onSuccess() 
{
	f_query_add_mod.document.location.reload();
}
function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) && (url.indexOf("reset")==-1) ){
		 
        return true;
	 }
    else
	{
        return false;
	}
  }

function apply()
{
	if (! (checkIsValidForProceed()) )
    {
        
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
			
        return false;
	
    } 

	
	var fields = new Array ( f_query_add_mod.document.maintain_acc_period.acc_per_year,
		f_query_add_mod.document.maintain_acc_period.acc_per_mon,
		f_query_add_mod.document.maintain_acc_period.acc_per_start_date);
	var names = new Array ( getLabel('eSM.AccountPeriodYear.label','common'),
						getLabel('eSM.AccountPeriodMonth.label','common'),
		     getLabel('eSM.AccountPeriodSdate.label','common'));
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
	{
		genDate(frames[1].document.getElementById('acc_per_start_date'));
		
		//f_query_add_mod.document.forms[0].submit();
	}
		
	
}

function chkonblur(obj,datef,localeName)
{
	            document.maintain_acc_period.acc_per_end_date.value="";
				document.maintain_acc_period.acc_per_desc.value="";
				document.maintain_acc_period.acc_cal_year.value="";
				document.maintain_acc_period.acc_cal_month.value="";
				document.maintain_acc_period.acc_per_end_date.disabled=false;
				document.maintain_acc_period.acc_per_desc.disabled=false;
	if(obj.value!="")
	
	{
		//alert("1");
	//validDateObj(obj,datef,localeName);//
	calValidation(obj);

	}

}
function daysInMonth(month,year) {
var m = [31,28,31,30,31,30,31,31,30,31,30,31];
if (month != 2){
	return m[month - 1];
}
if (year%4 != 0){
	return m[1];
}
if (year%100 == 0 && year%400 != 0) 
{
	return m[1];
}
return m[1] + 1;
} 

function calValidation(obj){
	var x=obj.value;
    var arrDate = x.split("/");
    var month=arrDate[1];
	if (month==1) monthName=("JANUARY");
else if (month==2) monthName=("FEBRUARY");
else if (month==3) monthName=("MARCH");
else if (month==4) monthName=("APRIL");
else if (month==5) monthName=("MAY");
else if (month==6) monthName=("JUNE");
else if (month==7) monthName=("JULY");
else if (month==8) monthName=("AUGUST");
else if (month==9) monthName=("SEPTEMBER");
else if (month==10) monthName=("OCTOBER");
else if (month==11) monthName=("NOVEMBER");
else monthName=("DECEMBER");
 //document.maintain_acc_period.acc_per_desc.value=monthName+''+year;

	var year=arrDate[2];

	day1 = daysInMonth(month,year);

	date = day1+"/"+month+"/"+year;
	


     document.getElementById('acc_per_desc').value=monthName+ ' ' +year;
     document.getElementById('acc_per_end_date').value=date;
     document.getElementById('acc_cal_year').value=year;
     document.getElementById('acc_cal_month').value=month;
     document.getElementById('acc_per_end_date').disabled=true;
     //document.getElementById("img2").disabled=true;
     document.getElementById('acc_cal_year').disabled=true;
	 document.getElementById('acc_cal_month').disabled=true;
     document.getElementById('acc_per_desc').disabled=true;
	 document.getElementById('acc_per_desc1').value=monthName+ ' ' +year;
     document.getElementById('acc_per_end_date1').value=date;
     document.getElementById('acc_cal_year1').value=year;
     document.getElementById('acc_cal_month1').value=month;

}
/*function genYear(obj)
{
	var HTMLVal = new String();
	HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE'><form name='form1' id='form1' method='post' action='../jsp/MaintainAcctPeriodVal.jsp'><input name='acc_per_year' id='acc_per_year' type='hidden' value='"+obj.value+ "'><input type='hidden' name='count' id='count' value='year'></form></BODY></HTML>";
	parent.frames[2].document.write(HTMLVal);
	parent.frames[2].document.form1.submit();

}*/
function genMonth(obj)
{	
	var HTMLVal = new String();
	HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eSM/jsp/MaintainAcctPeriodVal.jsp'><input name='acc_per_year' id='acc_per_year' type='hidden' value='+document.forms[0].acc_per_year.value+ '><input name='acc_per_mon' id='acc_per_mon' type='hidden' value='+document.forms[0].acc_per_mon.value+ '><input type='hidden' name='count' id='count' value='year'></form></BODY></HTML>";
	//alert(HTMLVal);	
	parent.messageFrame.document.write(HTMLVal);//
	parent.messageFrame.document.form1.submit();

}




function genDate(obj)
{	


    var HTMLVal = new String();
	HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' target='messageFrame' action='../../eSM/jsp/MaintainAcctPeriodVal.jsp'><input name='acc_per_start_date' id='acc_per_start_date' type='hidden' value='\"+obj.value+ \"'><input name='acc_per_year' id='acc_per_year' type='hidden' value='+frames[1].document.forms[0].acc_per_year.value+ '><input type='hidden' name='count' id='count' value='date'></form></BODY></HTML>";
	
	frames[2].document.write(HTMLVal);
	
	frames[2].document.form1.submit();

}


function genDate1(obj)
{	

    var HTMLVal = new String();
	HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eSM/jsp/MaintainAcctPeriodVal.jsp'><input name='acc_per_end_date' id='acc_per_end_date' type='hidden' value='\"+obj.value+ \"'><input type='hidden' name='count' id='count' value='date1'></form></BODY></HTML>";
	parent.frames[2].document.write(HTMLVal);
	
	parent.frames[2].document.form1.submit();

}


function check_date(obj)
	{


if(obj.value!="")
	{
	
	if(!validDateObj(obj,"DMY",localeName))
		{
		
			obj.value="";
			    document.maintain_acc_period.acc_per_end_date.value="";
				document.maintain_acc_period.acc_per_desc.value="";
				document.maintain_acc_period.acc_cal_year.value="";
				document.maintain_acc_period.acc_cal_month.value="";
				
			return ;
			
		}
		
	var stdt = document.forms[0].sys_date.value;

	var obj2=convertDate(obj.value,"DMY",localeName,"en");
	
		if(isBefore(stdt,obj2,'DMY',localeName)==false)
				{
			
				//alert("date should be ");
				alert(getMessage("DT_NLT_CURR_DT","SM"));
				obj.value="";
				document.maintain_acc_period.acc_per_end_date.value="";
				document.maintain_acc_period.acc_per_desc.value="";
				document.maintain_acc_period.acc_cal_year.value="";
				document.maintain_acc_period.acc_cal_month.value="";
				obj.select();
			
				return false;
			}

	}

}


/*function chkYear()	{
	var yr=maintain_acc_period.acc_per_year.value;
	var strdate=document.maintain_acc_period.acc_per_start_date.value;
	if(yr!="" && strdate!=""){
	var x=strdate;
    var arrDate = x.split("/");
    var date=arrDate[0];
    var month=arrDate[1];
    var year=arrDate[2];
   if(!(year==yr))
	{
	alert("Month and year should be same");
	//alert(getMessage("MONTH_AND_YEAR_SAME",'eSM'));
		document.maintain_acc_period.acc_per_year.value="";
		document.maintain_acc_period.acc_per_year.focus();
	}

}
}
function chkMonthVal()	{
		var yr=maintain_acc_period.acc_per_mon.value;
		var strdate=document.maintain_acc_period.acc_per_start_date.value;
		
		if (yr >12)
	{
		
		document.maintain_acc_period.acc_per_mon.value="";
		alert(getMessage("MONTH_IS_GR_12",'ecommon'));
		document.maintain_acc_period.acc_per_mon.focus();
	
}
}*/

function chkYear()	
{

	var yr=document.maintain_acc_period.acc_per_year.value;//
	if(yr!='')
	{
	if(yr=='0000')
		{
			alert(getMessage("INVALID_YEAR_FORMAT",'SM'));
		document.maintain_acc_period.acc_per_year.value="";
		document.maintain_acc_period.acc_per_year.focus();
	}
	else if (yr.length > 4 || yr.length <= 3)
	{
		alert(getMessage("INVALID_YR_FORMAT",'SM'));
		document.maintain_acc_period.acc_per_year.value="";
		document.maintain_acc_period.acc_per_year.focus();
	} 
	else if(yr < 1800)
   	{
		alert(getMessage("INVALID_YEAR_FORMAT",'SM'));
		document.maintain_acc_period.acc_per_year.value="";
		document.maintain_acc_period.acc_per_year.focus();
	}
	}
}

function checkMonth(Obj)
	{
	if(Obj.value!='')
	{
	if(Obj.value==0)
	{
		var errors = "" ;
		var err = getMessage('INVALID_VALUE','Common');
		err = err.replace('#', getLabel("Common.month.label","Common"));
		errors = errors + err;
		alert(errors) ;
		Obj.focus(); 
	} 
	else{
	if(  Obj.value  > 12) {
	alert(getMessage("MONTH_IS_GR_12","Common"));
	Obj.focus(); 

	return false;
	}
	else{
	return true;
	}
	}
	}
	}

