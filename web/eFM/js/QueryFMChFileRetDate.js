function ValidateDateTime (from,to)
{
	var obj=from;
	if(from.value!="")
	{
		if(doDateTimeChk(from))
		{
			from = from.value
			to		= to.value

		var a=  from.split(" ")
		splitdate=a[0];
		splittime=a[1]

		var splitdate1 =a[0].split("/")
		var splittime1= a[1].split(":")

		var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		a=  to.split(" ")
		splitdate=a[0];
		splittime=a[1]

		splitdate1 =a[0].split("/")
		splittime1= a[1].split(":")

		var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		if(Date.parse(to_date) < Date.parse(from_date))
		{
			//alert("Return date greater than Issue date");	;//msgframe.location.href='../../eCommon/jsp/error.jsp?err_num='+parent.parent.frames[0].getMessage("TO_DT_GR_EQ_FM_DT")
			return true;
		}
		else
		{
			var msg = getMessage('RETURN_DATE_LESS_ISSUE_DATE','FM');
			parent.frames[3].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
			obj.focus();
			obj.select();
			return false;
		}
	}
}
		
}


function doDateTimeChk(obj)
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
			//comp.focus()
		}
		else
		{
			if(time==null || time=="")
			{
				//alert(getMessage("INVALID_DATE_TIME"))
				//alert("1 :INVALID_DATE_TIME");
				retval= false;
				//comp.focus()
			}
			else
			{
				if(!chkTime(time))
				{
					retval= false
					//alert(getMessage("INVALID_DATE_TIME"))
					//alert("2 :INVALID_DATE_TIME");
					//comp.focus()
				}
			}
		}
	}
	else
	{
		
		//
		retval= false
		//alert("3 :INVALID_DATE_TIME");
		//comp.focus()
	}

	if(retval)
	{
		//callDateFunction(comp)
	}
	else
	{
		var msg = getMessage('FM_INVALID_DATE_TIME','FM');
		parent.frames[3].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		comp.focus();
		comp.select();
	}
	
	return retval
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

		date1d=eval(date1d)
		date1m=eval(date1m)
		date1yy=eval(date1y);

		if(date1m<=12)
		{
			if((date1m==1 || date1m==3 || date1m==5 || date1m==7 || date1m==8 || date1m==10 || date1m==12) && (date1d>31))
			{
				retval= false}
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

	function chkTime(time1)
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

					time1hr=eval(time1hr)
					time1min=eval(time1min)
					if(time1hr<=23)
					{
						if(time1min>60)
						{
								retval=false;
								//alert("Invalid Time")
						}
					}
					else
							retval=false;
							//alert("Invalid Time")
				}
				else
					retval=false;
					//alert("Invalid Time")
			}
			else
					retval=false;
					//alert("Invalid Time")

			return retval
		}


