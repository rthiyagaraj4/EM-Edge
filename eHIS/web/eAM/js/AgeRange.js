  
var  glb=0;  
var  weight_yn=0;

function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyAgeRangeMain.jsp";
}

function edit() {  
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/queryAgeRangeForm.jsp?function=agerange" ;
}

function apply() {
	
 if (! (checkIsValidForProceed()))
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	
	var fields = new Array (f_query_add_mod.frames[0].document.agerange_form.range_type,
						f_query_add_mod.frames[0].document.agerange_form.range_id,
						f_query_add_mod.frames[0].document.agerange_form.long_desc,
						f_query_add_mod.frames[0].document.agerange_form.short_desc,
						f_query_add_mod.frames[0].document.agerange_form.no_of_ranges
					    );
	var names = new Array (
						f_query_add_mod.getLabel("Common.type.label","Common"),
						f_query_add_mod.getLabel("Common.identification.label","Common"),
						f_query_add_mod.getLabel("Common.longdescription.label","Common"),
						f_query_add_mod.getLabel("Common.shortdescription.label","Common"),
						f_query_add_mod.getLabel("eAM.NoofRanges.label","AM")
					      );


if(f_query_add_mod.frames[0].checkFieldsofMst( fields, names, messageFrame)) {
	var count=f_query_add_mod.frames[0].agerange_form.no_of_ranges.value;

	
	var flds=new Array();
	var i=0;
	if(count>=1)
	{
	for(var u=1;u<=count;u++)
			{
			flds[i]=eval("f_query_add_mod.frames[1].document.agerange_form.range_"+u+"_fr").value;

			i++;
			
			flds[i]=eval("f_query_add_mod.frames[1].document.agerange_form.range_"+u+"_to").value;

				
			i++;
			
						
			}
	}


	var chk=0;
	var cn=0;
	var c1=0;
	var c2=1;
	var ct=1;


	for(cn=0;cn<count;cn++)
	{

	     	if(Chkflds(flds[c1],flds[c2]))
		{
			c1=c1+2;
			c2=c2+2;
		}
		else
		{

			chk++;
			ct=cn+1;

			var rangeLbl = frames[1].frames[1].getLabel("Common.Range.label","Common");				
			rangeLbl = 	rangeLbl+" "+ct;	
			var err1=frames[1].frames[1].getMessage("CAN_NOT_BE_BLANK","Common");
			err1= err1.replace('$',rangeLbl);
		
			//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=APP-0000001 Range cannot be blank......Range "+(cn+1);
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+err1;
			
			break;

		}

	}


		if(chk==0)
		{

				if (ChkOverLap())
				{

						if(f_query_add_mod.frames[0].document.forms[0].eff_status.value == 'D')
							{
								for(var u1=0;u1<f_query_add_mod.frames[1].document.agerange_form.elements.length;u1++)
									f_query_add_mod.frames[1].document.agerange_form.elements[u1].disabled=false;
							}
						
						f_query_add_mod.frames[1].document.agerange_form.range_type.value= f_query_add_mod.frames[0].document.forms[0].range_type.value;
						f_query_add_mod.frames[1].document.agerange_form.range_id.value= f_query_add_mod.frames[0].document.forms[0].range_id.value;
						f_query_add_mod.frames[1].document.agerange_form.long_desc.value= f_query_add_mod.frames[0].document.forms[0].long_desc.value;
						f_query_add_mod.frames[1].document.agerange_form.short_desc.value= f_query_add_mod.frames[0].document.forms[0].short_desc.value;
						f_query_add_mod.frames[1].document.agerange_form.no_of_ranges.value= f_query_add_mod.frames[0].document.forms[0].no_of_ranges.value;
						if(f_query_add_mod.frames[0].document.forms[0].eff_status.checked)
							f_query_add_mod.frames[1].document.agerange_form.eff_status.value ="E";
						else
							f_query_add_mod.frames[1].document.agerange_form.eff_status.value ="D";
						
							
						f_query_add_mod.frames[1].document.agerange_form.submit();
				}
				else
				{
					
					var rangeType=f_query_add_mod.frames[0].agerange_form.range_type.value;
			
				
			    if(glb==0)
				{

						if((rangeType =="W") || (rangeType =="Weight"))
					{
						var err_msg = f_query_add_mod.frames[0].getMessage("AM0116","AM");
						
						err_msg = err_msg.replace("Working Days",f_query_add_mod.frames[0].getLabel("Common.weight.label","common"));
						
						messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+err_msg;


					}

						else if((rangeType =="A") || (rangeType =="Age"))
					{
					
						var err_msg = f_query_add_mod.frames[0].getMessage("AM0116","AM");
						err_msg=err_msg.replace("Working Days",f_query_add_mod.frames[0].getLabel("Common.age.label","common"));
						
						messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+err_msg;
					}
				}

					else 
		
				
					{
						if((rangeType =="W") || (rangeType =="Weight"))
							messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+f_query_add_mod.frames[0].getMessage("FR_WEIGHT_LESS_THAN_PR","AM");
						else if((rangeType =="A") || (rangeType =="Age"))
							messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+f_query_add_mod.frames[0].getMessage("FM_AGE_LESS_PREV_TO_AGE","AM");
							
					}

				}

			}

		
	}

}


function reset()
	{
		 if (! (checkIsValidForProceed()))
        {			 
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
			return false;
		} 		
		if(f_query_add_mod.document.forms[0])
			f_query_add_mod.document.forms[0].reset();
		if(f_query_add_mod.frames[0])
		{
			f_query_add_mod.frames[0].document.forms[0].reset();
			//f_query_add_mod.frames[1].document.forms[0].reset();
			var range_type = f_query_add_mod.frames[0].document.forms[0].range_type.value;
			var range_id = f_query_add_mod.frames[0].document.forms[0].range_id.value;
			f_query_add_mod.frames[1].location.href = '../../eAM/jsp/RangeDisplay.jsp?range_id='+range_id+'&range_type='+range_type			
		}
	}




function ChkOverLap()
	{
	var n=f_query_add_mod.frames[0].agerange_form.no_of_ranges.value;
	var y=0;
	var fldvals=new Array();
	if(n>=1)
	{
		for(x=1;x<=n;x++)
		{
		fldvals[y]=eval("f_query_add_mod.frames[1].document.agerange_form.range_"+x+"_fr").value;
		y++;
		fldvals[y]=eval("f_query_add_mod.frames[1].document.agerange_form.range_"+x+"_fr_unit").value;
		y++;
		fldvals[y]=eval("f_query_add_mod.frames[1].document.agerange_form.range_"+x+"_to").value;
		y++;
		fldvals[y]=eval("f_query_add_mod.frames[1].document.agerange_form.range_"+x+"_to_unit").value;
		y++;
		
		}
	}

	var i=0;
	var count=0;
	var w=0;var x=1;var y=2;var z=3;

	var k=0;
	if(n==1)
	 {
	    k=1;
	}
	else if(n==2)
	  k=3;
	else if(n>=3){
		k=3;
	for(var jj=3;jj<=n;jj++)
		{
			k=k+2;
		}
	}

/*	else if(n==2)
	  k=3;
	else if(n==3)
	  k=5;
	else if(n==4)
	  k=7;
	else if(n==5)
	  k=9;
	else if(n==6)
	  k=11;
	else if(n==7)
	  k=13;
	else if(n==8)
	  k=15;
*/

	for(i=0;i<k;i++)
	{

		if(ComRowChk(fldvals[w],fldvals[x],fldvals[y],fldvals[z]))
		{
			w=w+2;
			x=x+2;
			y=y+2;
			z=z+2;
		}
		else
		{
			if(w==2||w==6||w==10||w==14||w==18||w==22)
				glb++;
			else
				glb=0;

			return false;

		}


	}

	return true;

}


function ComRowChk(FrValue,FrUnt,ToValue,ToUnt)
{
	var Fr_unit=FrUnt;
	var To_unit=ToUnt;
	var FrVal=FrValue;
	var ToVal=ToValue;

			if(Fr_unit=="W" && To_unit=="M")
			{
				FrVal=FrValue*7;
				ToVal=ToValue*30;
			}
			if(Fr_unit=="M" && To_unit=="W")
			{
				FrVal=FrValue*30;
				ToVal=ToValue*7;
			}
			if(Fr_unit=="W" && To_unit=="D")
			{
				FrVal=FrValue*7;
				ToVal=ToValue;
			}
			if(Fr_unit=="D" && To_unit=="W")
			{
				FrVal=FrValue;
				ToVal=ToValue*7;
			}
			if(Fr_unit=="W" && To_unit=="Y")
			{
				FrVal=FrValue*7;
				ToVal=ToValue*365;
			}
			if(Fr_unit=="Y" && To_unit=="W")
			{
				FrVal=FrValue*365;
				ToVal=ToValue*7;
			}
			if(Fr_unit=="D" && To_unit=="M")
			{
				FrVal=FrValue;
				ToVal=ToValue*30;
			}
			else if(Fr_unit=="M" && To_unit=="D")
			{

				FrVal=FrValue*30;
				ToVal=ToValue;
			}
			else if(Fr_unit=="M" && To_unit=="Y")
			{

				FrVal=FrValue*30;
				ToVal=ToValue*365;
			}
			else if(Fr_unit=="Y" && To_unit=="M")
			{

				FrVal=FrValue*365;
				ToVal=ToValue*30;
			}
			else if(Fr_unit=="D" && To_unit=="Y")
			{

				FrVal=FrValue;
				ToVal=ToValue*365;
			}
			else if(Fr_unit=="Y" && To_unit=="D")
			{

				FrVal=FrValue*365;
				ToVal=ToValue;
			}
			else if(Fr_unit=="K" && To_unit=="L")
			{
				weight_yn=1;
				FrVal=FrValue;
				ToVal=ToValue * 0.45359237;
			}
			else if(Fr_unit=="L" && To_unit=="K")
			{
				weight_yn=2;
				FrVal=FrValue * 0.45359237;
				ToVal=ToValue;
			}

			var nam=FrVal;
			var nam1=ToVal;
			if ((Fr_unit	!= "L" && Fr_unit	!= "K")||(To_unit	!= "L" && To_unit	!= "K"))
			{
				nam=parseInt(FrVal,10);
				nam1=parseInt(ToVal,10);
			}


			if(eval(nam) >= eval(nam1) )
				{
					return false;
				}
			else
				return true;




}


function Chkflds(Fld1,Fld2){

	if(Fld1=="" ||Fld2=="")
		return false;
	else
		return true;
}

function onSuccess() {
	f_query_add_mod.location.reload() ;
}

function checkIsValidForProceed()
{
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}
function CheckForSpecChars(event){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

function CheckSpecialChar(obj)
{
	var fieldval = obj.value;
	var fieldlen = fieldval.length;
	var to_check = true;
	var SpChar = new Array();

	SpChar[0] = '~';
	SpChar[1] = '`';
	SpChar[2] = '!';
	SpChar[3] = '@';
	SpChar[4] = '#';
	SpChar[5] = '$';
	SpChar[6] = '%';
	SpChar[7] = '^';
	SpChar[8] = '&';
	SpChar[9] = '*';
	SpChar[10] = '(';
	SpChar[11] = ')';
	SpChar[12] = '-';
	SpChar[13] = '+';
	SpChar[14] = '=';
	SpChar[15] = '|';
	SpChar[16] = '\\';
	SpChar[17] = '[';
	SpChar[18] = ']';
	SpChar[19] = '{';
	SpChar[20] = '}';
	SpChar[21] = ':';
	SpChar[22] = ';';
	SpChar[23] = '"';
	SpChar[24] = '<';
	SpChar[25] = '>';
	SpChar[26] = '?';
	SpChar[27] = '/';
	SpChar[28] = '\'';
	SpChar[29] = '';
	SpChar[30] = ',';
	SpChar[31] = '.';

	if (fieldval.substr(0,1) == '_' ) 
	{
		to_check = false;
	}

	for (var i=0;i<fieldlen;i++)
	{

		if (fieldval.substr(i,1) == ' ' || fieldval.substr(i,1) == null)
		{
			to_check = false;
		}

		for (var j=0;j<=31;j++)
		{
			if (fieldval.substr(i,1) == SpChar[j])
			{
				to_check = false;
			}
		}
	}

	if (to_check == false)
	{
		alert(getMessage('SPECIAL_CHARCTERS_NOT_ALLOWED','SM'));
		obj.select();
		//obj.value='';
		//obj.focus();
	}


}

 	







