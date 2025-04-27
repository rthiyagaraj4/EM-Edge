function apply()
{
	    var ipgenerate = f_query_add_mod.document.forms[0].ipgenerate.value;
	//	var opgenerate = f_query_add_mod.document.forms[0].opgenerate.value;
	//	var dcgenerate = f_query_add_mod.document.forms[0].dcgenerate.value;
	//	var emgenerate = f_query_add_mod.document.forms[0].emgenerate.value;
       // if (ipgenerate=='N' && opgenerate=='N' && dcgenerate=='N' && dcgenerate=='N')
        if (ipgenerate=='N')
        {
		//	var msg = 'APP-QA0014 Atleast one checkbox should be checked before apply';
			var msg = 'APP-QA0014 checkbox should be checked before apply';
			alert(msg);
			frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
        }
	 	else
		{
			//var fields = new Array (f_query_add_mod.document.forms[0].PROC_DATE_IP_TO,f_query_add_mod.document.forms[0].PROC_DATE_DC_TO,f_query_add_mod.document.forms[0].PROC_DATE_EM_TO,f_query_add_mod.document.forms[0].PROC_DATE_OP_TO);
			var fields = new Array (f_query_add_mod.document.forms[0].PROC_DATE_IP_TO);
			//var names = new Array ( "InPatient ","DayCare ","Emergency ","OutPatient ");
			var names = new Array ( "InPatient ");
			if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
				f_query_add_mod.document.forms[0].submit();
		} 
		
}
function reset() 
{
     f_query_add_mod.document.location.reload() ;
}
function onSuccess() 
{
   f_query_add_mod.document.location.reload();
}

function chkchar(obj,e)
{
 	var whichCode = (window.Event) ? e.which : e.keyCode;
	var sp=obj.value;
	var j=sp.length;
	if(whichCode >46 && whichCode<59)
		return true;
	else
		return false
}
function doDateTimeChk1(obj)
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
		if(!checkDt1(dt) )
		{
			retval= false
		}
		else
		{
			if(time==null || time=="")
			{
				retval= false;
			}
			else
			{
				if(!chkTime1(time))
				{
					retval= false
				}
			}
		}
	}
	else
	{
		retval= false
	}
	if(retval)
	{
		//callDateFunction(comp)
	}
	else 
	{
		alert('Invalid Date');
		comp.focus();
	}
	return retval
}
function checkDt1(date1)
{
	retval=true
	var date1arr=new Array()

    date1arr=date1.split("/")
	if(date1arr.length==3)
	{
		var date1d=date1arr[0]
		var date1m=date1arr[1]
		var date1y=date1arr[2]

		date1d=eval(date1d)
		date1m=eval(date1m)
		date1yy=eval(date1y);

		if(date1m<=12)
		{
			if((date1m==1 || date1m==3 || date1m==5 || date1m==7 || date1m==8 || date1m==10 || date1m==12) && (date1d>31))
			{
				retval= false
			}
			if((date1m==4 || date1m==6 || date1m==8 || date1m==11 ) && (date1d>30))
			{
	 			retval= false
			}
			if ((date1y.length <4) || (date1y.length >4))
			{
				retval= false
			}
		}
		else
		{
			retval= false;
		}
	}
	else
	{
		retval= false;
	}
	return retval;
}
function chkTime1(time1)
{
	var retval=true;
	if( (time1.charAt(time1.length-1) )!=":")
	{
		var time1arr=new Array()
		time1arr=time1.split(":")
		if(time1arr.length==3)
		{
			var time1hr=time1arr[0]
			var time1min=time1arr[1]
            var time1sec=time1arr[2]
			time1hr=eval(time1hr)
			time1min=eval(time1min)
			time1sec=eval(time1sec)
			if(time1hr<=23)
			{
				if(time1min>60)
				{
					retval=false;
				}
				if(time1sec>60)
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
}
function ValidateDateTimesp (from,obj)
{
  
  if(obj.value=='')
	{ 
	  return false;
	}

   else if(doDateTimeChk1(obj))
   {
			
	 if(obj.value=='')
	 {
		obj.value='';
	 } 
	 else 
	 {
		to   = obj.value
	    from = from.value
        var a=  from.split(" ")
        splitdate=a[0];
        splittime=a[1]
	
		var splitdate1 =splitdate.split("/")
		var splittime1= splittime.split(":")

		var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]),eval(splittime1[2]))
	 
		a=  to.split(" ")
		splitdate=a[0];
		splittime=a[1]
		splitdate1 =splitdate.split("/")
		splittime1= splittime.split(":")


		 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]),eval(splittime1[1]), eval(splittime1[2]))

     
	 if(Date.parse(to_date) < Date.parse(from_date))
      {
        
	     alert("To date should be always greater than fromdate ");
		 obj.focus();
      }
	}
   }
}
function checkyn(obj)
{
if(obj.checked==true)
	obj.value="Y"
else
obj.value="N"
}
