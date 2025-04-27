        function checkDt(date1)
        {
			if (date1.value != undefined)
			{
				date1 = date1.value;
			}
			else
			{
				date1=date1;
			}
            retval=true
            var date1arr=new Array()

            date1arr=date1.split("/")

            if(date1arr.length==3)
            {
                var date1d=date1arr[0]
                var date1m=date1arr[1]
                var date1y=date1arr[2]

				if (isNaN(date1d)==true) return false;
				if (isNaN(date1m)==true) return false;
				if (isNaN(date1y)==true) return false;

                date1d=eval(date1d)
                date1m=eval(date1m)
                date1yy=eval(date1y);

				if(date1m<=12)
                {

                    if((date1m==1 || date1m==3 || date1m==5 || date1m==7 || date1m==8 || date1m==10 || date1m==12) && (date1d>31))
                    {
                        retval= false
                    }

                    if((date1m==4 || date1m==6 || date1m==9 || date1m==11 ) && (date1d>30))
                    {
                        retval= false
                    }
                    if ((date1y.length <4) || (date1y.length >4))
                    {
                        retval= false
                    }
                    if (date1m == 2) {
                        if (date1d< 1) return false;

                        if (LeapYear(date1yy) == true) {
                            if (date1d> 29) return false;
                        }
                        else {
                            if (date1d > 28) return false;
                        }
                    }

                    if (isNaN(date1d)==true) retval = false;
                    if (isNaN(date1m)==true) retval = false;
                    if (isNaN(date1yy)==true) retval = false;
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
			if (time1.value != undefined)
			{
				time1 = time1.value;
			}
			else
			{
				time1=time1;
			}
		   time1=trimString(time1); 
           var retval=true;
           var strCheck = ':0123456789';
            for(var i=0;i<=time1.length;i++) {
                if (strCheck.indexOf(time1.charAt(i)) == -1){
                    retval = false;
                    break;
                }
            }			
            if (retval)
            {				
               // if( (time1.charAt(time1.length-1) )!=":")
                if( (time1.charAt(2) )==":")
                {
                    var time1arr=new Array()
                    time1arr=time1.split(":")
					
                    if(time1arr.length==2)
                    {
                        var time1hr=time1arr[0]
                        var time1min=time1arr[1]

						if (time1hr.length != 2 || time1min.length != 2)
						{
							 retval=false;
						}

                        time1hr=eval(time1hr)
                        time1min=eval(time1min)
                        if(time1hr<=23)
                        {
                            if(time1min>59)
                            {
                                    retval=false;
                                    //alert("Invalid Time")
                            }
                        }
                        else
                                retval=false;
                                //alert("Invalid Time")
                    }
                    else{						
                        retval=false;
					}
                        //alert("Invalid Time")
                }
                else
                        retval=false;
                        //alert("Invalid Time")
            }			
            return retval
        }

        function doDateTimeChk(obj)
        {
			if (obj.value != undefined)
			{
				obj = obj.value;
			}
			else
			{
				obj=obj;
			}
            if(obj.indexOf('.') !=-1 || obj.indexOf('-') !=-1)
            {
                retval= false
                if (obj.value != undefined) obj.focus()
            }
            else
            {
                var comp=obj
                obj=obj
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
						if (comp.value != undefined)
						  comp.focus()
                    }
                    else
                    {
                        if(time==null || time=="")
                        {
                            //alert(getMessage("INVALID_DATE_TIME"))
                            retval= false;
							if (comp.value != undefined)
                            comp.focus()
                        }

                        else
                        {
                            if(!chkTime(time))
                            {
                                    retval= false
                                    //alert(getMessage("INVALID_DATE_TIME"))
									if (comp.value != undefined)
                                    comp.focus()
                            }
                        }
                    }
                }
                else
                {
                    retval= false
                    //alert(getMessage("INVALID_DATE_TIME"))
					if (comp.value != undefined)
                    comp.focus()
                }

                if(retval)
                {
                    //callDateFunction(comp)
                }
            }
            return retval
        }



function ValidateDateTime (from,to)
{

			if (from.value != undefined)
			{
				from = from.value;
			}
			else
			{
				from=from;
			}

			if (to.value != undefined)
			{
				to = to.value;
			}
			else
			{
				to=to;
			}
    var objorval=from.value;
    var objorval2=to.value;
	if (objorval != undefined)
    {
		from = from.value;
    }
	else
	{
		from = from;
	}

	if (objorval2 != undefined)
    {
		 to      = to.value;
    }
	else
	{
		 to      = to;
	}

    var a=  from.split(" ")
    splitdate=a[0];
    splittime=a[1]

//alert("1:"+to)

    var splitdate1 =splitdate.split("/")
    var splittime1= splittime.split(":")

     var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

     a=  to.split(" ")
    splitdate=a[0];
    splittime=a[1]
  //  alert("to:"+to)
//alert("splitdate:"+splitdate)
//alert("splittime:"+splittime)

     splitdate1 =splitdate.split("/")
     splittime1= splittime.split(":")

     var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

     if(Date.parse(to_date) < Date.parse(from_date))
    {
        //msgframe.location.href='../../eCommon/jsp/error.jsp?err_num='+parent.parent.frames[0].getMessage("TO_DT_GR_EQ_FM_DT")
        return false
    }
    else
        return true;
}

/*        Added by Chitra on 13/09/2001 to chk Date of the format MM/YYYY     */
        function ChkDateFormat(Object2) {
			if (Object2.value != undefined)
			{
				Object2 = Object2.value;
			}
			else
			{
				Object2=Object2;
			}
            var datefield = Object2;
            if (ChkDate1(Object2) == false) {
                alert(top.header.getMessage("INVALID_DATE_FMT", "SM"));
			if (Object2.value != undefined)
			{
				datefield.select();
				datefield.focus();
			}
                return false;
            }
            else {
                return true;
            }
        }

        function ChkDate1(Object3) {
			if (Object3.value != undefined)
			{
				Object3 = Object3.value;
			}
			else
			{
				Object3=Object3;
			}
        var strDate;
        var strMonth;
        var strYear;
        var datefield = Object3;
        var strDateArray = new Array();

        strDate = datefield.value;
        if (strDate.length == 0) return true;

        strDateArray = strDate.split("/");
        if (strDateArray.length != 2) {
            return false;
        }
        else {
            strMonth = strDateArray[0];
            strYear = strDateArray[1];
        }


        if (strYear.length < 4 || strYear.length>4) return false;

        if (isNaN(strMonth)==true) return false;
        if (isNaN(strYear)==true) return false;

        if (strYear < 1900) return false;

        if (strMonth>12 || strMonth<1)  return false;

        return true;
 }

 function LeapYear(strYear) {
     if (strYear % 100 == 0) {
         if (strYear % 400 == 0)  return true;
     }
     else {
         if ((strYear % 4) == 0)  return true;
     }
     return false;
 }

function ValidateDate (from,to)
{
    if (from.value != undefined)
	{
		from = from.value;
	}
	else
	{
		from=from;
	}
	 if (to.value != undefined)
	{
		to = to.value;
	}
	else
	{
		to=to;
	}
//	from = from.value
    //to      = to.value
    splitdate=from;

    var splitdate1 =splitdate.split("/")

     var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]))

    splitdate=to;

     splitdate1 =splitdate.split("/")

     var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]))
     if(Date.parse(to_date) < Date.parse(from_date))
    {
        return false
    }
    else
        return true;
}
