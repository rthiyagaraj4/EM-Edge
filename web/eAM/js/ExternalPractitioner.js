function moveToLink(LinkIndex) {

	if(LinkIndex==1)
	{
			parent.frames[1].document.getElementById('identitylink').scrollIntoView();
			var fname=document.practitioner1_form.function_name.value;
			if(fname=="modify")
			{
                var effstatus=document.practitioner1_form.effstatus12.value
				if(effstatus!='D'){
			   parent.frames[1].document.practitioner1_form.sex.focus();
				}else{
					if(effstatus!='E')
			 parent.frames[1].document.practitioner1_form.sex1.focus();
				}
			}
			if(fname!="modify")
			{
			 parent.frames[1].document.practitioner1_form.sex.focus();
			}
	}
	else if(LinkIndex==2)
	{
			parent.frames[1].document.getElementById('contactnolink').scrollIntoView();
			parent.frames[1].document.practitioner1_form.residencetelno.focus();
	}
	else if(LinkIndex==3)
	{
			parent.frames[1].document.getElementById('deglink').scrollIntoView();
			parent.frames[1].document.practitioner1_form.degree1.focus();
	}
}
function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/PractitionerMain.jsp?function_id=EXT_PRACT" ;	
}
function query() 
{
	f_query_add_mod.location.href ="../../eAM/jsp/PractitionerQueryCriteria.jsp?function_id=EXT_PRACT&function=setup practitioner";
}
function apply() 
{
	d = new Date();
	var ye=new Array();
	
	var year=f_query_add_mod.document.frames[1].practitioner1_form.date_of_birth.value
	var year1=f_query_add_mod.document.frames[1].practitioner1_form.year1.value
     var year2=f_query_add_mod.document.frames[1].practitioner1_form.year2.value
	var year3=f_query_add_mod.document.frames[1].practitioner1_form.year3.value
	var year4=f_query_add_mod.document.frames[1].practitioner1_form.year4.value
   

	ye=year.split("/");
    dobyear=ye[2] 
	currentyear=d.getYear()
	if(!(eval(year1)>eval(dobyear))&&(eval(year1)<=eval(currentyear)))
	{
	
	//alert("APP-AM0024 Year of Passing should be greater than BirthDate")
	alert(getMessage("AM0125","AM"));
	
	
	
	messageFrame.document.location='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_val='
	
	}else if(!(eval(year2)>eval(dobyear))&&(eval(year2)<=eval(currentyear)))
	{
	
	//alert("APP-AM0024 Year of Passing should be greater than BirthDate")
	alert(getMessage("AM0125","AM"));
	
	
	messageFrame.document.location='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_val='
	
	}else if(!(eval(year3)>eval(dobyear))&&(eval(year3)<=eval(currentyear)))
	{
	
	//alert("APP-AM0024 Year of Passing should be greater than BirthDate ")
	alert(getMessage("AM0125","AM"));
	
	
	messageFrame.document.location='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_val='
	
	}else if(!(eval(year4)>eval(dobyear))&&(eval(year4)<=eval(currentyear)))
	{
	
	//alert("APP-AM0024 Year of Passing should be greater than BirthDate ")
	alert(getMessage("AM0125","AM"));
	
	
	
	messageFrame.document.location='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_val='
	
	}
	else
	{

	
	f_query_add_mod.document.frames[1].practitioner1_form.job_title1.value=f_query_add_mod.document.frames[1].practitioner1_form.job_title.value
	
	
	if(f_query_add_mod.document.frames[1].practitioner1_form.function_name.value == "insert") 
	{
		f_query_add_mod.document.frames[1].practitioner1_form.pract_type1.value = f_query_add_mod.document.frames[0].practitioner_form.pract_type.value;
		f_query_add_mod.document.frames[1].practitioner1_form.practitioner_id1.value = f_query_add_mod.document.frames[0].practitioner_form.practitioner_id.value;
		f_query_add_mod.document.frames[1].practitioner1_form.practitioner_name1.value = f_query_add_mod.document.frames[0].practitioner_form.practitioner_name.value;
		f_query_add_mod.document.frames[1].practitioner1_form.short_name1.value = f_query_add_mod.document.frames[0].practitioner_form.short_name.value;
		f_query_add_mod.document.frames[1].practitioner1_form.eff_status1.value = f_query_add_mod.document.frames[0].practitioner_form.eff_status.value;
		f_query_add_mod.document.frames[1].practitioner1_form.date_of_birth1.value = f_query_add_mod.document.frames[1].practitioner1_form.date_of_birth.value;
		f_query_add_mod.document.frames[1].practitioner1_form.primary_speciality_codeh.value = f_query_add_mod.document.frames[0].practitioner_form.primary_speciality_code.value;

		var fields = new Array (
				 f_query_add_mod.document.frames[1].practitioner1_form.pract_type1,
				 f_query_add_mod.document.frames[1].practitioner1_form.practitioner_id1,
				 f_query_add_mod.document.frames[1].practitioner1_form.practitioner_name1,
				 f_query_add_mod.document.frames[1].practitioner1_form.short_name1,
				 f_query_add_mod.document.frames[1].practitioner1_form.sex,
				 f_query_add_mod.document.frames[1].practitioner1_form.empl_status,
				 f_query_add_mod.document.frames[1].practitioner1_form.date_of_birth1,
				 f_query_add_mod.document.frames[1].practitioner1_form.primary_speciality_codeh
		      );

		 var names = new Array( getLabel("Common.type.label","Common"),
			getLabel("Common.identification.label","Common"),
			getLabel("Common.FullName.label","Common"),
			getLabel("Common.shortname.label","Common"),
			"Sex",
			getLabel("Common.EmplStatus.label","Common"),
			getLabel("Common.birthDate.label","Common"),
			"Primary Specialty"
			);

		/*if((f_query_add_mod.document.frames[1].practitioner1_form.empl_status.value=="F") || (f_query_add_mod.document.frames[1].practitioner1_form.empl_status.value == "P")|| (f_query_add_mod.document.frames[1].practitioner1_form.empl_status.value == "S")) {
		fields[fields.length-1] =f_query_add_mod.document.frames[1].practitioner1_form.rep_facility;
		names[names.length-1]="Reporting Facility"
		}
		else {
       	fields.length=fields.length-1;
       	names.length=names.length-1;
        }*/

        var transform = new Array ( f_query_add_mod.document.frames[1].practitioner1_form,
        		    f_query_add_mod.document.frames[1].practitioner1_form.eff_date_from,
				    f_query_add_mod.document.frames[0].practitioner_form.eff_date_from1,
				    f_query_add_mod.document.frames[1].practitioner1_form.eff_date_to,
				    f_query_add_mod.document.frames[0].practitioner_form.eff_date_to1
			  );
	}
	else if(f_query_add_mod.document.frames[1].practitioner1_form.function_name.value == "modify") 
	{f_query_add_mod.document.frames[1].practitioner1_form.marital_status.value= f_query_add_mod.document.frames[1].practitioner1_form.marital_status2.value
		f_query_add_mod.document.frames[1].practitioner1_form.pract_type1.value = f_query_add_mod.document.frames[0].practitioner_form.pract_type3.value;
		f_query_add_mod.document.frames[1].practitioner1_form.practitioner_id1.value = f_query_add_mod.document.frames[0].practitioner_form.practitioner_id.value;
		f_query_add_mod.document.frames[1].practitioner1_form.practitioner_name1.value = f_query_add_mod.document.frames[0].practitioner_form.practitioner_name.value;
		f_query_add_mod.document.frames[1].practitioner1_form.short_name1.value = f_query_add_mod.document.frames[0].practitioner_form.short_name.value;
		f_query_add_mod.document.frames[1].practitioner1_form.eff_status1.value = f_query_add_mod.document.frames[0].practitioner_form.eff_status.value;
		f_query_add_mod.document.frames[1].practitioner1_form.date_of_birth1.value = f_query_add_mod.document.frames[1].practitioner1_form.date_of_birth.value;
		//f_query_add_mod.document.frames[1].practitioner1_form.all_facilities1.value=f_query_add_mod.frames[1].practitioner1_form.all_facilities.value;
		f_query_add_mod.document.frames[1].practitioner1_form.primary_speciality_codeh.value = f_query_add_mod.document.frames[0].practitioner_form.primary_speciality_code2.value;

		var fields = new Array (
				 f_query_add_mod.document.frames[1].practitioner1_form.pract_type1,
				 f_query_add_mod.document.frames[1].practitioner1_form.practitioner_id1,
				 f_query_add_mod.document.frames[1].practitioner1_form.practitioner_name1,
				 f_query_add_mod.document.frames[1].practitioner1_form.short_name1,
				 f_query_add_mod.document.frames[1].practitioner1_form.sex2,
				 f_query_add_mod.document.frames[1].practitioner1_form.date_of_birth1,
				 f_query_add_mod.document.frames[1].practitioner1_form.empl_status2,
   			     f_query_add_mod.document.frames[1].practitioner1_form.primary_speciality_codeh
			     );
		var names = new Array (  getLabel("Common.type.label","Common"),
			getLabel("Common.identification.label","Common"),
			getLabel("Common.FullName.label","Common"),
			getLabel("Common.shortname.label","Common"),
			"Sex",
			getLabel("Common.EmplStatus.label","Common"),
			getLabel("Common.birthDate.label","Common"),
			"Primary Specialty"
			);
		/*if((f_query_add_mod.document.frames[1].practitioner1_form.empl_status2.value == "F") || (f_query_add_mod.document.frames[1].practitioner1_form.empl_status2.value == "P")) {
	    fields[fields.length-1] =f_query_add_mod.document.frames[1].practitioner1_form.rep_facility2
        names[names.length-1]="Reporting facility";
        }
        else {
       	fields.length=fields.length-1;
       	names.length=names.length-1;
        }*/ 
        
		var transform = new Array ( f_query_add_mod.document.frames[1].practitioner1_form,
        		    f_query_add_mod.document.frames[1].practitioner1_form.eff_date_from,
				    f_query_add_mod.document.frames[0].practitioner_form.eff_date_from1,
				    f_query_add_mod.document.frames[1].practitioner1_form.eff_date_to,
				    f_query_add_mod.document.frames[0].practitioner_form.eff_date_to1
			  );
	}
	//////////Added by Manish Anand on 30-06-2002////////////////////
	var spFields = new Array (f_query_add_mod.document.frames[0].practitioner_form.practitioner_id);
	var spNames = new Array (getLabel("Common.identification.label","Common"));
	var error_page="../../eCommon/jsp/MstCodeError.jsp"
	
	if(SpecialCharCheck (spFields,spNames,messageFrame,"M",error_page))
	//////////----------------------------------////////////////////
	if(f_query_add_mod.document.frames[1].checkFieldsofMst( fields, names, messageFrame)) 
	{
		var proceed = true;
		var message = "";
		//if(f_query_add_mod.document.frames[1].DateTransform(transform,messageFrame)) {
		f_query_add_mod.document.frames[1].practitioner1_form.date_of_birth.disabled = false;
		var det1 = f_query_add_mod.document.frames[1].practitioner1_form.det1.value;
		var det2 = f_query_add_mod.document.frames[1].practitioner1_form.det2.value;
		var det3 = f_query_add_mod.document.frames[1].practitioner1_form.det3.value;
		var det4 = f_query_add_mod.document.frames[1].practitioner1_form.det4.value;
		
		if((det1 != null) || (det2 != null) || (det3 != null) || (det4 != null))
		{
			if((det1.length > 100) || (det2.length > 100) || (det3.length > 100) || (det4.length > 100))
			{
				messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num="+f_query_add_mod.frames[0].getMessage('TRNG_DTLS_MAX_CHAR','AM');
				proceed = false;
			}
		}
		if(proceed)
		{
			//alert(f_query_add_mod.document.frames[1].practitioner1_form.date_of_birth1.value);
			f_query_add_mod.document.frames[1].practitioner1_form.submit();
		}
		var fn_status = f_query_add_mod.document.frames[1].practitioner1_form.function_name.value ;
		//}
	}
}
}
function reset() 
{
	if (f_query_add_mod.document.forms[0] != null)
	{
	    f_query_add_mod.document.location.reload() ;
	}
   else 
	{
           f_query_add_mod.frames[0].document.location.reload() ;
           f_query_add_mod.frames[1].document.location.reload() ;
    }
/*   if(f_query_add_mod.frames[0].document.forms[0].name == "practitioner_form" && f_query_add_mod.frames[1].document.forms[1].name == "practitioner1_form") 
	{
           f_query_add_mod.frames[0].document.practitioner_form.reset() ;
           f_query_add_mod.frames[1].document.practitioner1_form.reset() ;
     }*/
     

}
function onSuccess() {

	f_query_add_mod.location.reload();
}
function sendToServer(Val) 
{
var HTMLVal = new String();
if (Val == 1)
{
	HTMLVal = "<HTML><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAM/jsp/ServerFunction.jsp'><input type='hidden' name='process_d' id='process_d' value='1'><input name='date_of_birth' id='date_of_birth' type='hidden' value='"+document.getElementById("greg_date_of_birth").value+"'></form></BODY></HTML>";
	parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.parent.messageFrame.document.form1.submit();
}
if ( Val == 2 )
{
	HTMLVal = "<HTML><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAM/jsp/ServerFunction.jsp'><input type='hidden' name='process_d' id='process_d' value='2'><input type='hidden' name='b_age' id='b_age' value='" + document.getElementById("b_age").value + "'><input type='hidden' name='b_months' id='b_months' value='" + document.getElementById("b_months").value +"'><input name='b_days' id='b_days' type='hidden' value='"+document.getElementById("b_days").value + "'></form></BODY></HTML>";
	parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.parent.messageFrame.document.form1.submit();
}
}
function gotoNext(Obj)	{
if ( Obj == document.getElementById('date_of_birth') )
{
	if ( CheckDate(document.getElementById('greg_date_of_birth')) == false) {
		document.getElementById('date_of_birth').focus();
	}
	else
	{
		if(doDateCheckAlert(Obj,document.getElementById('server_date')))
		{
			sendToServer(1);
		}
		else
		{
			//alert('APP-MP0071 Date of Birth cannot be greater than TODAY ');
			alert(getMessage("DOB_CHECK","Common"));
			document.getElementById('date_of_birth').focus();
		}
	}
}
else if ( Obj == document.getElementById("b_days") )
{
	if ( Obj.value > 31 )
	{
		//alert('APP-MP0073 Days cannot be greater than 31 ');
		alert(getMessage("DAYS_CHECK","Common"));
		Obj.focus();
	}
	else if(Obj.value < 0)
	{
		//alert('APP-MP0070 Age cannot be less than ZERO or Negative');
		alert(getMessage("NEG_AGE_CHECK","Common"));
		Obj.focus();
	}
	else
		sendToServer(2);
}
else if ( Obj == document.getElementById('b_months') )
{
	if ( Obj.value > 11 )
	{
		//alert('APP-MP0069 Months cannot be greater than 11');
		alert(getMessage("MONTHS_CHECK","Common"));
		Obj.focus();
	}
	else if(Obj.value < 0)
	{

		//alert('APP-MP0070 Age cannot be less than ZERO or Negative');
		alert(getMessage("NEG_AGE_CHECK","Common"));
		Obj.focus();
	}
		sendToServer(2);
}
else if ( Obj == document.getElementById('b_age') )
{
	if ( Obj.value < 0)
	{
		//alert('APP-MP0070 Age cannot be less than ZERO or Negative');
		alert(getMessage("NEG_AGE_CHECK","Common"));
		Obj.focus();
	}
	else if ( Obj.value == '')
		Obj.value = 0;
	else
		sendToServer(2);
}

}
function validateNationality(Nat_Id,nat_id_prompt,nat_id_check_digit_id)	
{

//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
var isResidencyApplYN = document.getElementById('isResidencyApplYN').value;
var eff_stat = document.getElementById('eff_stat').value;

var isNumber = new Boolean();
isNumber = true;

var ind = -1;

	if ( Nat_Id.value.length > 0 )
	{
		if ( (nat_id_check_digit_id=='M11') && (ind = Nat_Id.value.indexOf('X')) != -1)
		{
			if (ind < 12)           // X can be entered only at 13th position
			{
				msg = getMessage('INVALID_NAT_ID','MP');
				msg = msg.replace("#",nat_id_prompt);
				//Nat_Id.select();
				alert(msg);
				Nat_Id.value="";
				return false;
			}
		}
	}


/*if ( Nat_Id.value.length > 0 )
{
	if ( CheckForNumber(Nat_Id.value) )
		isNumber = true;
	else
	{
		isNumber = false;
		Nat_Id.focus();
	}
}
else if(Nat_Id.value.length == 0 )
{
	Nat_Id.value = '';
	isNumber = true;
}*/


if ( isNumber )
{
	var continue_yn = 'true';
	var nid = new String();
	nid = trimString(Nat_Id.value);
	Nat_Id.value = nid;

	if ( nid.length == Nat_Id.maxLength  && nid.length != 0)
	{
		if (document.getElementById('function_name').value=='modify')
		{	
			if (document.getElementById('oldnationalid').value ==  nid)
				continue_yn = 'false';
		}
		if (continue_yn=='true')
		{
			//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
			if(isResidencyApplYN == "true" && eff_stat == "E")
			{
				duplicateNatIdValidation(Nat_Id,nat_id_prompt);
			}else
			{
				var HTMLVal = new String();
				HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAM/jsp/CheckForNationality.jsp?step=second'><input type='hidden' name='national_id_no' id='national_id_no' value='"+Nat_Id.value+"'><input type='hidden' name='FROM_VAL' id='FROM_VAL' value='PRACTITIONER'></form></body></html>";
				parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				parent.parent.messageFrame.document.form1.submit();
			}
		}
	}
	else
	{
		if ( Nat_Id.value != '' )
		{
			//alert('APP-MP0068 Nationality Id should be of '+document.getElementById("national_id_no").maxLength+' Characters');
			var err1 = getMessage('AM0157','AM');
			err1= err1.replace('$',document.getElementById('national_id_no').maxLength);
			err1= err1.replace('Nationality Id',nat_id_prompt);
			alert(err1);

			document.getElementById('national_id_no').focus();
		}
	}
}
}
/*function calcage(obj1,obj2) {
	if(doDateCheckAlert(obj1,document.getElementById("server_date")))
		{
		if(CheckDate(obj1) == false)
		{
		}
		else
		{
		if(obj1.value.length !=0)
		{
		var datecal=obj1.value;
		strDateArray = datecal.split("/");
		if (strDateArray.length != 3) ;
		else {
			strDay = strDateArray[0];
			strMonth = strDateArray[1];
			strYear = strDateArray[2];
		}

	    var ageYears, ageMonths, ageDays
	    var datecal2=document.getElementById('server_date').value;
	    bornDate = new Date(strMonth+'/'+strDay+'/'+strYear);
	    mm = bornDate.getMonth()+1 ;
	    dd = bornDate.getDate();
	    yy = bornDate.getFullYear();
		
		strDateArray1 = datecal2.split("/");
				if (strDateArray.length != 3) ;
				else {
					strDay1 = strDateArray1[0];
					strMonth1 = strDateArray1[1];
					strYear1 = strDateArray1[2];
		}

	    testDate = new Date(strMonth1+'/'+strDay1+'/'+strYear1);
	    mm2 = testDate.getMonth()+1 ;
	    dd2 = testDate.getDate();
	    yy2 = testDate.getFullYear();

	if (yy < 100 && yy > 20) {
			        yy = yy + 1900
			        }
				if (yy2 < 100){
					if (yy2 > 20) {
						yy2 = yy2 + 1900
			        }else{
						yy2 = yy2 + 2000
			        }
			    }


	    //calcualate # of years
	    ageYears = yy2 - yy
		//adjust years by looking at months
	    //same month, no birthday yet (add 12 months)
	    if(mm2 == mm){
			if(dd2 < dd){
				mm2 = mm2 + 12;
				ageYears = ageYears - 1;
			}
	    }
	    //earlier month (add 12 months)
	    if(mm2 < mm){
			mm2 = mm2 + 12;
			ageYears = ageYears - 1;
			ageMonths = mm2 - mm;
		}

		ageMonths = mm2 - mm;
		

	    //adjust months by looking at days
	    if (dd2 < dd) {
			ageMonths = ageMonths - 1;
			if((ageMonths == 4) || (ageMonths == 6) || (ageMonths == 9) || (ageMonths == 11))
			{
				dd2 = dd2 + 30;
			}
			else
			if(ageMonths == 2)
			{
				dd2=dd2+30;
			}
			else
			{
				dd2=dd2+30;
			}
			if (mm2 == mm) {
				ageMonths = 0;
				ageYears = ageYears - 1;
				}
	        }
	        ageDays = dd2 - dd;
	
	

	document.getElementById('b_age').value= ageYears ;
	if(document.getElementById('b_age').value.length == 1  && document.getElementById('b_age').value !='0') document.getElementById('b_age').value="0"+ageYears ;
	//if(ageYears > 1 || ageYears < 10) parent.document.frames[0].document.forms[0].b_age.value="0"+ageYears ; 
	
	document.getElementById('b_months').value=ageMonths;
	if(document.getElementById('b_months').value.length == 1 && document.getElementById('b_months').value !='0') document.getElementById('b_months').value="0"+ageMonths;
	//if(ageMonths > 1 || ageMonths < 10) parent.document.frames[0].document.forms[0].b_months.value="0"+ageMonths;
	
	document.getElementById("b_days").value=ageDays;
	if(document.getElementById("b_days").value.length == 1 && document.getElementById("b_days").value !='0') document.getElementById("b_days").value="0"+ageDays;
	//if(ageDays > 1 || ageDays < 10 ) parent.document.frames[0].document.forms[0].b_days.value="0"+ageDays;
	}
}

return true;
}
else
{
//alert('APP-MP0071 Date of Birth cannot be greater than TODAY ');
alert(getMessage('DOB_CHECK','Common'));
document.getElementById('date_of_birth').focus();
return false;
}

}
*/
function doDateCheckAlert(from,to) {
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);	
			if(Date.parse(todt) < Date.parse(fromdt)) {
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}	
return true;
}




function calculateAge(Obj,Val,mod)
{
var flag=true;
var HTMLVal= new String();
if ( Val == 1 )
{
	if(Obj.value!="")
	{
if(!validDateObj(Obj,"DMY",localeName))
		{
			Obj.value="";
			return ;
		}
else
	{
	var greg_date_of_birth =convertDate(Obj.value,"DMY",localeName,"en");

 //  if(calcage(Obj,document.getElementById('ServerDate')))
 //  {   
 //  {   
	 
	 if(BirthDay_check(document.getElementById('server_date'),Obj))
		{ 
    HTMLVal = "<HTML><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAM/jsp/ServerValidation.jsp'><input type='hidden' name='reference' id='reference' value='parent.f_query_add_mod.document.practitioner_sub.document.practitioner1_form'><input type='hidden' name='process_id' id='process_id' value='1'><input name='date_of_birth' id='date_of_birth' type='hidden' value='"+greg_date_of_birth+"'></form></BODY></HTML>";
    parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
    parent.parent.messageFrame.document.form1.submit();
		}
// }
}
	}
}
if ( Val == 2 )
{
	if(Obj.name== 'b_months')
	{
			if(!checkMonth(Obj))
			{
				flag=false;
				document.getElementById('b_months').value=''
				document.getElementById('b_months').focus();
			}
	}
	if(flag)
	{
		   if(Obj.name == 'b_days')
		   {
		   	if(!chkDays(Obj))
		   	{
		   		flag=false;
		   		document.getElementById("b_days").focus();
		   		document.getElementById("b_days").value='';
		   	
		   	}
		   
		   
		   }
	}	   
		  if(flag)
		  {
			 
		  HTMLVal = "<HTML><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAM/jsp/ServerValidation.jsp'><input type='hidden' name='reference' id='reference' value='parent.f_query_add_mod.document.practitioner_sub.document.practitioner1_form'><input type='hidden' name='process_id' id='process_id' value='2'><input type='hidden' name='b_age' id='b_age' value='" + document.getElementById('b_age').value + "'><input type='hidden' name='b_months' id='b_months' value='" + document.getElementById("b_months").value +"'><input name='b_days' id='b_days' type='hidden' value='"+document.getElementById("b_days").value + "'></form></BODY></HTML>";
		    parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		    parent.parent.messageFrame.document.form1.submit();
	  }
	
	}
}

function chkDays(Obj)
{
if(parseInt(Obj.value) >31)
	{
		alert(getMessage('DAYS_CHECK','Common'));
		Obj.value="";
		return false;	
	}
	else
	return true;

}

function leapyear(a) {
if(((a % 4 == 0) && (a % 100 != 0)) || (a % 400 == 0))
return true;
else
return false;
}

function checkMonth(Obj)
{
if( Obj.value  > 11) {
//alert('APP-MP0069 Months cannot be greater than 11');
alert(getMessage("MONTHS_CHECK","Common"));
document.getElementById('date_of_birth').value='';
Obj.value="";

return false;
}
else{
return true;

}

}

function checkDays(Obj)
{
if( Obj.value  > 31) { //alert('APP-MP0073 Days cannot be greater than 31'); 
alert(getMessage('DAYS_CHECK','Common'));
Obj.focus();
Obj.value="";
document.getElementById('date_of_birth').value='';
return false;

}else{
	calci(Obj);
}
}


function BirthDay_check(Sys_date,obj)
{
	

if(obj.value!="")
		{
			var obj1=convertDate(obj.value,"DMY",localeName,"en");

			if(isBefore(obj1,Sys_date.value,'DMY',localeName)==false)
				{
				alert(getMessage('DOB_CHECK','Common'));
				//obj.select();
				obj.value="";
				return false;
			}
			else
				return true;
		}

}


function CheckForCharsNatID(event){
    var strCheck = '0123456789X';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

