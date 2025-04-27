function apply()
{
	var sdate= f_query_add_mod.document.generate_acct_period.acc_per_start_date.value;
	var acc_year= f_query_add_mod.document.generate_acct_period.acc_per_year1.value;

	var x=sdate;
	var arrDate = x.split("/");
    var date=arrDate[0];
    var month=arrDate[1];
    var year=arrDate[2];
	
	var year1=eval(year)+1;
	var year2=eval(year)-1;
	


	var fields = new Array ( f_query_add_mod.document.generate_acct_period.acc_per_year1,
						f_query_add_mod.document.generate_acct_period.acc_per_start_date);
	var names = new Array ( getLabel('eSM.AccountYear.label','common'),
						getLabel('Common.StartDate.label','common'));
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
	{
		if(acc_year==year || acc_year==year1 || acc_year==year2)
		{
			f_query_add_mod.document.forms[0].action="../../servlet/eSM.GenerateAcctPeriodServlet";

    		f_query_add_mod.document.forms[0].target="messageFrame"; 
			f_query_add_mod.document.forms[0].submit();
		}
		else{
			
			alert(getMessage("ACC_PER_START_DATE_VAL","SM"));
			f_query_add_mod.document.generate_acct_period.acc_per_start_date.value="";
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
            return false;
			

		}
	}
}
function reset()
{
		f_query_add_mod.document.location.reload();
		//f_query_add_mod.document.generate_acct_period.reset();
		//f_query_add_mod.document.generate_acct_period.acc_per_year1.focus();7/2/2009
}


function onSuccess() 
{
	f_query_add_mod.document.location.reload();
}

function chkYear(obj)	
	{ 
		//	var yr=generate_acct_period.acc_per_year1.value;
		var yr=obj.value;
		if(obj.value!='')
		{
			if(obj.value==0)
			{
				alert(getMessage('INVALID_YEAR_FORMAT','SM'));
				document.generate_acct_period.acc_per_year1.value="";
				document.generate_acct_period.acc_per_year1.focus();
				//document.location.reload();

			}
			else if (obj.value.length > 4 || obj.value.length <= 3)
			{
			alert(getMessage("INVALID_YR_FORMAT",'SM'));
			document.generate_acct_period.acc_per_year1.value="";
			document.generate_acct_period.acc_per_year1.focus();
			//document.location.reload(); 
			} 
			else if(obj.value < 1800)
			{
				alert(getMessage("INVALID_YEAR_FORMAT",'SM'));
				document.generate_acct_period.acc_per_year1.value="";
				document.generate_acct_period.acc_per_year1.focus();
			}
			else
				return true;
	   }
	}

function genYear()
{
	var HTMLVal = new String();

	HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eSM/jsp/GenerateAcctPeriodValPopulate.jsp'><input name='acc_per_year1' id='acc_per_year1' type='hidden' value=' "+document.getElementById("acc_per_year1").value + "'><input type='hidden' name='count' id='count' value='year'></form></BODY></HTML>";
	parent.frames[2].document.write(HTMLVal);
	parent.frames[2].document.form1.submit();

}

function chkDate()
{
	var HTMLVal = new String();
	HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eSM/jsp/GenerateAcctPeriodValPopulate.jsp'><input name='acc_per_start_dt' id='acc_per_start_dt' type='hidden' value=' "+document.getElementById("acc_per_start_date").value + "'><input name='acc_per_year1' id='acc_per_year1' type='hidden' value=' "+document.getElementById("acc_per_year1").value + "'><input type='hidden' name='count' id='count' value='date'</form></BODY></HTML>";
	parent.frames[2].document.write(HTMLVal);
	parent.frames[2].document.form1.submit();
}
 

/*function chkYear1()	{
	var yr=generate_acct_period.acc_per_year1.value;
var strdate=document.generate_acct_period.acc_per_start_date.value;
if(yr!=""&&strdate!=""){
	var x=strdate;
	var arrDate = x.split("/");
    var date=arrDate[0];
    var month=arrDate[1];
    var year=arrDate[2];
   if(!(year==yr))
	{

		alert("MONTH AND YEAR SHOULD BE SAME");
		//alert(getMessage("MONTH_AND_YEAR_SAME",'eSM'));
		document.generate_acct_period.acc_per_year1.value="";
		document.generate_acct_period.acc_per_year1.focus();
	}

}
}*/

function check_date(obj)
{
	if(obj.value!="")
	{
		if(!validDateObj(obj,"DMY",localeName))
		{
		obj.value="";
		document.generate_acct_period.acc_per_start_date.value="";
		return ;
		}
	var stdt = document.forms[0].sys_date.value;
	var obj2=convertDate(obj.value,"DMY",localeName,"en");
	if(isBefore(stdt,obj2,'DMY',localeName)==false)
		{
		alert(getMessage("DT_NLT_CURR_DT","SM"));
		obj.value="";
		document.generate_acct_period.acc_per_start_date.value="";
		obj.select();
		return false;
	   }
	}
}

