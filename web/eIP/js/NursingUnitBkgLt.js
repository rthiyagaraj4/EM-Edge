 function create() {

	//f_query_add_mod.location.href = "../../eIP/jsp/NursingUnitMain.jsp?param=create&called_from=4" ;
	var paramStr = "../../eIP/jsp/NursingUnitMain.jsp?param=create&called_from=4" ;
	var params = (f_query_add_mod.location.href).split('&');

		for (i=1;i<params.length ;++i )
		{
			if 	(params[i].indexOf('function_id')>-1)
			{
				paramStr = paramStr + '&' + params[i];
			}
		}

	f_query_add_mod.location.href = paramStr ;

}

function query() {
	f_query_add_mod.location.href ="../../eIP/jsp/NursingUnitBkgLtQueryCriteria.jsp" ;
	/*var paramStr ="../../eIP/jsp/NursingUnitBkgLtQueryCriteria.jsp";
	var params = (f_query_add_mod.location.href).split('&');

		for (i=1;i<params.length ;++i )
		{
			if 	(params[i].indexOf('function_id')>-1)
			{
				paramStr = paramStr + '&' + params[i];
			}
		}

	f_query_add_mod.location.href = paramStr ;
	alert(paramStr);
	alert(f_query_add_mod.location.href);*/
}
function checkIsValidForProceed()
{
	var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
}
function apply()
{
	//var nursing_unit_code = parent.frames[1].frames[1].frames[0].document.forms[0].nursing_unit.value;
	if (! (checkIsValidForProceed())){
		parent.frames[2].messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}else{
			var nursing_unit_code = frames[1].frames[0].document.forms[0].nursing_unit.value;
			var proceed;
			if(nursing_unit_code=="")
			{
				proceed=0;
				var err= getMessage("CAN_NOT_BE_BLANK","Common");		
				err= err.replace("$",getLabel('Common.nursingUnit.label','common'));
				//parent.frames[1].frames[2].location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+err+'&err_value=0' ;
				parent.frames[2].frames[2].location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+err+'&err_value=0' ;
			}
			else
			{
				proceed=1;
			}

			s="<html><body class='message' onKeyDown='lockKey()'><form name='final' id='final' method='post' action= '../../servlet/eIP.NursingUnitBkgLtServlet'><input type=hidden name=nursing_unit_code value='"+nursing_unit_code+"'>";

			var bool=false;
			//var frm=parent.frames[1].frames[1].frames[1].document.forms[0];// frame2
			var frm=frames[1].frames[1].document.forms[0];// frame2
			var j=0;
			var k=0;
			var l=0;
			var m=0;
			var msg="";
			var row=0;
			var row_selected=0;
			var bedclassdesc="";
			if(frames[1].frames[0].document.forms[0].statusval.value !="")
			{
			if(proceed==1)
				{
				//parent.frames[1].frames[1].frames[1].last();
				frames[1].frames[1].last();
				for(i=0;i<frm.elements.length;i++)
				{
					if(frm.elements[i].name.substring(0,1) =="M")
					{
						j=frm.elements[i].name.substring(1,4)
						if(eval("frm.M"+j) !=null)
						{
							if(eval("frm.M"+j+".value")!="" || eval("frm.M"+j+".value")!=null) 
							{
								var fields = new Array (eval("frm.M"+j) );
								var names  =  new Array ( getLabel('eIP.MaxMaleDailyBookingLimit.label','IP') );
								//var messageFrame = parent.frames[1].frames[2]; 
								var messageFrame = frames[2]; 
								var error_page = "../../eCommon/jsp/MstCodeError.jsp";
				
								//if(parent.frames[1].frames[1].frames[1].SpecialCharCheck(fields,names,messageFrame,"M", error_page))
								if(frames[1].frames[1].SpecialCharCheck(fields,names,messageFrame,"M", error_page))
									bool=true;
								else
								{
									bool=false;
									break;
								}
							}
						}
					}
					else if(frm.elements[i].name.substring(0,1) =="F")
					{
						k=frm.elements[i].name.substring(1,4)
						if(eval("frm.F"+k) !=null)
						{
							if(eval("frm.F"+k+".value")!="" || eval("frm.F"+k+".value")!=null) 
							{
								var fields = new Array (eval("frm.F"+k) );
								var names  =  new Array ( getLabel('eIP.MaxFemaleDailyBookingLimit.label','IP') );
								//var messageFrame = parent.frames[1].frames[2]; 
								var messageFrame = frames[2]; 
								var error_page = "../../eCommon/jsp/MstCodeError.jsp";
					
								//if(parent.frames[1].frames[1].frames[1].SpecialCharCheck(fields,names,messageFrame,"M", error_page))
								if(frames[1].frames[1].SpecialCharCheck(fields,names,messageFrame,"M", error_page))
									bool=true;
								else
								{
									bool=false;
									break;
								}
							}
						}
					}
					else if(frm.elements[i].name.substring(0,1) =="U")
					{
						l=frm.elements[i].name.substring(1,4)
						if(eval("frm.U"+l) !=null)
						{
							if(eval("frm.U"+l+".value")!="" || eval("frm.U"+l+".value")!=null) 
							{
								var fields = new Array (eval("frm.U"+l) );
								var names  =  new Array ( getLabel('eIP.MaxUnknownDailyBookingLimit.label','IP') );
								//var messageFrame = parent.frames[1].frames[2]; 
								var messageFrame = frames[2]; 
								var error_page = "../../eCommon/jsp/MstCodeError.jsp";
					
								//if(parent.frames[1].frames[1].frames[1].SpecialCharCheck(fields,names,messageFrame,"M", error_page))
								if(frames[1].frames[1].SpecialCharCheck(fields,names,messageFrame,"M", error_page))
									bool=true;
								else
								{
									bool=false;
									break;
								}
							}
						}
					}

				//added on 27-11-2003 by dhanasekaran for checking total
					if(frm.elements[i].name.substring(0,1) == "S")
					{
						
						row = row + 1;

						if(frm.elements[i].checked) //If select checked
						{
							row_selected = row_selected + 1;
						}
						
					}	
				}
			
				if(msg.length > 0)
				{
					alert(msg);
					bool=false;
					messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
				}
				else if (row_selected == 0)
				{
					/*alert(getMessage("ATLEAST_ONE_SELECTED","Common"));
					bool=false;
					messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
					*/
						bool=true;

				}
			//end addition

				if(bool)
				{
					//var frm1=parent.frames[1].frames[1].frames[2].document.forms[0];
					var frm1=frames[1].frames[2].document.forms[0];
					for(i=0;i<frm1.elements.length;i++)
					{
						s+="<input type='hidden' name='"+frm1.elements[i].name+"' id='"+frm1.elements[i].name+"' value='"+frm1.elements[i].value+"'>"
					}

						s+="</form>";
						s+="</body>";
						s+="</html>";
						messageFrame.document.write(s); 
						messageFrame.document.forms[0].submit()
				}
			}
		}
		else
		{
			parent.frames[2].messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
						return false;
		}
	}
}

function onSuccess() {
	
	frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	frames[1].frames[0].location.reload();
	//alert(frames[1].frames[1].name);
	//alert(frames[1].frames[0].name);
}

function reset()
{
	 if (! (checkIsValidForProceed())){
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}else{
	var loc=frames[1].document.forms[0];

	if (loc!=null )
	{
			f_query_add_mod.document.forms[0].reset();
	}
	else 
	{
	f_query_add_mod.location.reload();
	}
	}
}

//functions moved from addModifyNursingUnitBkgLt.jsp


function checkNum(obj,id) {
	var doTotal=false;
	if(obj.readOnly)
		return;
	if(obj.value == "") {
		//obj.value='0';
		//alert(obj.value);
		obj.value='';
		if(id != 'NA') setTotal(id);
		return;
	}
	if(CheckNum(obj)) {
	//alert("1111111==="+obj.value);
		if(id != 'NA') setTotal(id);
	}
	else {	//alert("2222222="+obj.value);
		//obj.value='0';
		obj.value='';
		if(id != 'NA') setTotal(id);
		obj.select();
		obj.focus();
	}
}
function enableText(obj)
{
	var frm=document.forms[0]
	var gender=document.forms[0].gender.value

	var x=obj.name.substring(1,4);

//alert(eval("frm.T"+x+".value"))

	var total=eval("frm.T"+x+".value");
	if(total=='')
	{
		var err= getMessage("CAN_NOT_BE_BLANK","Common");		
		err= err.replace("$",getLabel('Common.total.label','Common') +" "+getLabel('eIP.MaxDailyBookingLimit.label','IP') );
		alert(err);
		obj.checked =false;
		return false;
    }else if(total=='0')
	{
		var err1= getMessage("CANNOT_BE_ZERO","IP");		
		err1= err1.replace("$",getLabel('Common.total.label','Common') +" "+getLabel('eIP.MaxDailyBookingLimit.label','IP') );
		alert(err1);
		obj.checked =false;
		return false;


	}else{
	if(obj.checked)
	{
		 if(gender=="M") eval("frm.M"+x+".readOnly=false"); 
		 else if(gender=="F") eval("frm.F"+x+".readOnly=false");
		 else if(gender=="U") eval("frm.U"+x+".readOnly=false"); 
		 else
		{
	  		 eval("frm.M"+x+".readOnly=false"); 
			 eval("frm.F"+x+".readOnly=false"); 
			 eval("frm.U"+x+".readOnly=false"); 
		}
	}
	 else
	{
 		/* 
		eval("frm.M"+x+".value='0'") 
 		 eval("frm.F"+x+".value='0'") 
 		 eval("frm.U"+x+".value='0'") 
 		  eval("frm.T"+x+".value='0'") 
		  */
		  eval("frm.M"+x+".value=''"); 
 		  eval("frm.F"+x+".value=''"); 
 		  eval("frm.U"+x+".value=''"); 
 		  eval("frm.T"+x+".value=''"); 
			  
	}
}
}

function first()
{
	var M=parent.frames[2].document.forms[0].M.value;
	var F=parent.frames[2].document.forms[0].F.value;
	var U=parent.frames[2].document.forms[0].U.value;
	var T=parent.frames[2].document.forms[0].T.value;
	var S=parent.frames[2].document.forms[0].S.value;

	frm = document.forms[0];

	var bool = true;

	for(var i=0;i<frm.length;i++)
	{
		if(frm.elements[i].name.substring(0,1) == "S")
			if(S.indexOf(frm.elements[i].name) != -1)
			{
				bool = false;
					break; 
			}
	}

	if(!bool)
	{
		for(var i=0;i<frm.length;i++)
		{
			if(frm.elements[i].name.substring(0,1) == "S")
				if(frm.elements[i].type == "checkbox")
					frm.elements[i].checked = false;
		}
	}

	var arr  = S.split("`");
	var arr1 = M.split("`");
	var arr2 = F.split("`");
	var arr3 = U.split("`");
	var arr4 = T.split("`");
	if(arr != null && arr != '' )
	{
		for ( i=0; i<arr.length; i++)
		{
			if( arr[i] != null && arr[i] != '')
			{
				if(eval(document.getElementById(arr[i])) != null )
				{
					eval(document.getElementById(arr[i])).checked = true;
					add=arr[i].substring(1,3);

					/*eval("document.getElementById("M")"+add+".value = arr1[i];")
					eval("document.getElementById("F")"+add+".value = arr2[i];")
					eval("document.getElementById("U")"+add+".value = arr3[i];")
					eval("document.getElementById("T")"+add+".value = arr4[i];")*/
					
					eval(document.getElementById('M' + add)).value = arr1[i];
					eval(document.getElementById('F' + add)).value = arr2[i];
					eval(document.getElementById('U' + add)).value = arr3[i];
					eval(document.getElementById('T' + add)).value = arr4[i];
					

				}
			}
		}
	}
}	
	
	function last()
	{
	var frm=document.forms[0];
	var 	tempVal1 =parent.Dummy.document.forms[0].M.value ;
	var 	tempVal2 =parent.Dummy.document.forms[0].F.value ;
	var 	tempVal3 =parent.Dummy.document.forms[0].U.value ;
	var 	tempVal4 =parent.Dummy.document.forms[0].T.value ;
	var 	tempVal5 =parent.Dummy.document.forms[0].S.value ;
	var 	tempVal6 =parent.Dummy.document.forms[0].B.value ;

	for(i=0;i<frm.elements.length;i++)
	{
		if(frm.elements[i].type == "checkbox")
		{
			if(frm.elements[i].name.substring(0,1) == "S")
			{
				var bool= chkExists("S",frm.elements[i].name)	// chk if the element exists in the string
				var continue_yn =false;
				if(!bool && frm.elements[i].checked)	continue_yn = true
				if(!bool )	continue_yn = true

				if(continue_yn) //ELEMENT is not there in the string 
				{
					if(frm.elements[i].checked) 
					{	
					
						var e = tempVal6; //B
						var z = tempVal5;	 //S
						var y = tempVal4;	 //T
						var x = tempVal3;	 //U
						var w = tempVal2;	 //F
						var v = tempVal1;	 //M

							tempVal5=z+frm.elements[i].name+"`";
							add=frm.elements[i].name.substring(1,3);
							
						
							add1="M"+add;
							if(eval("frm."+add1+".value")!="")
								tempVal1=v+eval("frm."+add1+".value")+"`";
							else
								tempVal1=v+"0"+"`";

							add1="F"+add;
							if(eval("frm."+add1+".value")!="")
								tempVal2=w+eval("frm."+add1+".value")+"`";
							else
								tempVal2=w+"0"+"`";

							add1="U"+add;
							if(eval("frm."+add1+".value")!="")
								tempVal3=x+eval("frm."+add1+".value")+"`";
							else
								tempVal3=x+"0"+"`";

							add1="T"+add;
							if(eval("frm."+add1+".value")!="")
								tempVal4=y+eval("frm."+add1+".value")+"`";
							else
								tempVal4=y+"0"+"`";

							add1="B"+add;
							tempVal6=e+eval("frm."+add1+".value")+"`";
					}
			    }
				else
				{
					if(!bool && !frm.elements[i].checked )
					{
						var arr = tempVal5.split('`');
							tempVal5 = ''; 
						for(var j=0; j<arr.length;j++)
						{
							if( arr[j] != frm.elements[i].name )
							{
								tempVal5 += arr[j] + '`';
								add=frm.elements[i].name.substring(1,3);

							add1="M"+add;
							if(eval("frm."+add1+".value")!="")
								tempVal1=v+eval("frm."+add1+".value")+"`";
							else
								tempVal1=v+"0"+"`";

							add1="F"+add;
							if(eval("frm."+add1+".value")!="")
								tempVal2=w+eval("frm."+add1+".value")+"`";
							else
								tempVal2=w+"0"+"`";

							add1="U"+add;
							if(eval("frm."+add1+".value")!="")
								tempVal3=x+eval("frm."+add1+".value")+"`";
							else
								tempVal3=x+"0"+"`";

							add1="T"+add;
							if(eval("frm."+add1+".value")!="")
								tempVal4=y+eval("frm."+add1+".value")+"`";
							else
								tempVal4=y+"0"+"`";

							add1="B"+add;
							tempVal6=e+eval("frm."+add1+".value")+"`";

							}
						}
					}
				}
			}
		}
	}
		parent.Dummy.document.forms[0].M.value=tempVal1;
		parent.Dummy.document.forms[0].F.value=tempVal2;
		parent.Dummy.document.forms[0].U.value=tempVal3;
		parent.Dummy.document.forms[0].T.value=tempVal4;
		parent.Dummy.document.forms[0].S.value=tempVal5;
		parent.Dummy.document.forms[0].B.value=tempVal6;
}
	
function chkExists(mode, chkStr)
{
	var condStr ;
	if(mode == 'S')	condStr  = parent.Dummy.document.forms[0].S.value
    else				    condStr  = parent.Dummy.document.forms[0].E.value

	if( condStr  != null && condStr !='')
	{
		var tempStr = "" ;
		var arr = condStr.split("`") ;

		if( arr != null && arr !='' )
		{
			for(var i=0;i<arr.length;i++)
			{
				if( arr[i] == chkStr )	
				{
					return true;
				}
			}
			return false ;
		}
	}
	else	
			return false
}
	
	function getGender()
    {
            var ncode        = document.NursingUnitBkgLt_form.nursing_unit_code.value;
            if (ncode != '')
            {
          
                var xmlHttp = new XMLHttpRequest()
                xmlStr ="<root><SEARCH nursing_unit_code=\""+ncode+"\" /></root>"
                xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
                xmlHttp.open("POST","GetGender.jsp",false)
                xmlHttp.send(xmlDoc)
                responseText=xmlHttp.responseText
                responseText = trimString(responseText)
                eval(responseText) 
           }
    }
    function setTotal(id)
    {
        
       var max_male=0;
        var max_female=0;
        var max_unknown=0;
        var max_tot="";
		
		

        var frm=document.forms[0]
 
        
        i=id

        var max_male_dly_booking=eval(document.getElementById('M'+i)).value;
        var max_female_dly_booking= eval(document.getElementById('F'+i)).value;
        var max_unknown_dly_booking=eval(document.getElementById('U'+i)).value;
        var max_total_dly_booking=  eval(document.getElementById('T'+i)).value;
                                                                       	

		

         if((max_male_dly_booking !=null)&&(max_male_dly_booking !="")) 
            max_male= max_male_dly_booking; 
		 
       // else 
			
          // max_male=0;
		
          
         
         if((max_female_dly_booking !=null)&&(max_female_dly_booking !=""))
            max_female= max_female_dly_booking ;
       // else 
         // max_female=0;
           
        
         if((max_unknown_dly_booking !=null)&&(max_unknown_dly_booking !="") )
            max_unknown= max_unknown_dly_booking;
       // else 
          //max_unknown=0;  
     
       // alert(max_male_dly_booking);
       // max_tot = parseInt(max_male)+parseInt(max_female)+parseInt(max_unknown);
		//alert(max_male_dly_booking);
     

/*if(max_tot==0)
		{
	
	max_tot='';

		}*/
		if(max_male_dly_booking=='' && max_female_dly_booking=='' && max_unknown_dly_booking==''){
			
			max_tot='';
		}
	else{
		
		 max_tot = parseInt(max_male)+parseInt(max_female)+parseInt(max_unknown);
	}
	
		
        max_total_dly_booking =max_tot;
		//alert("max_total_dly_booking"+max_total_dly_booking);
		/*if(max_total_dly_booking=="")
		{
			alert("Total can not be blank")
		}*/

        /*eval("document.getElementById("T")"+i+".value= max_tot;")
			//changes are  made for this incident:17616 date:Saturday, January 09, 2010
			if(  eval("document.getElementById("T")"+i+".value==0")||eval("document.getElementById("T")"+i+".value==''"))
				eval("document.getElementById("S")"+i+". checked=false");

        }  */ 
        eval(document.getElementById('T'+i)).value= max_tot;
        //changes are  made for this incident:17616 date:Saturday, January 09, 2010
			if(  eval(document.getElementById('T'+i)).value=="0"||eval(document.getElementById('T'+i)).value=='')
				eval(document.getElementById("S"+i)). checked=false;


        }
    
    function ChkNumInput(fld, e, deci)
        {
            if (parseInt(deci)>0)   
               var strCheck = '0123456789';

            var whichCode = (window.Event) ? e.which : e.keyCode;
            if (whichCode == 13) return true;  // Enter

            key = String.fromCharCode(whichCode);  // Get key value from key code

            if (strCheck.indexOf(key) == -1) return false;  // Not a valid key

            if(key == "." && fld.value.indexOf(key) != -1) return false; // Not more than one '.' char
        }

	/*	function chk_total()
		{

			 var chk_total=eval("document.forms[0].T"+i+".value");
			// alert("chk_total"+chk_total)
				 if(chk_total=="")
		{	
			alert("Total can not be blank")
		}

		}*/

