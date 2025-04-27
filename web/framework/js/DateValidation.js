/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
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
                    if (( date1y.length <4) || (date1y.length >4))
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
