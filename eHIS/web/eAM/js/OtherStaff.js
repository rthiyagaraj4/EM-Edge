var function_id="";

function create() {
	
	f_query_add_mod.location.href = "../../eAM/jsp/OtherStaffMain.jsp" ;	
}

function moveToLink(LinkIndex) {
	if(LinkIndex==1)
	{
		//alert("LinkIndex"+LinkIndex.value)
			parent.OtherStaff_sub.document.getElementById('identitylink').scrollIntoView();
			if(parent.OtherStaff_sub.document.getElementById("effstatus").value!="D")
			parent.OtherStaff_sub.document.getElementById("sex").focus();
	}
	else if(LinkIndex==2)
	{
			parent.OtherStaff_sub.document.getElementById('contactnolink').scrollIntoView();
			parent.OtherStaff_sub.document.forms[1].residencetelno.focus();;
	}
}

function query() {
	
	f_query_add_mod.location.href ="../../eAM/jsp/OtherStaffQueryCriteria.jsp";
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
//alert("inside apply");
	//var messageFrame = parent.frames[1].frames[2]; 
	
	
	  
	var messageFrame = frames[2]; 
	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 

	var error_page = "../../eCommon/jsp/MstCodeError.jsp";
	var frameobj=f_query_add_mod.document.OtherStaff_sub.OtherStaff1_form;
	var frameobj1=f_query_add_mod.document.OtherStaff_main_one.OtherStaff_form;

	//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
	var isResidencyApplYN = frameobj.isResidencyApplYN.value;
	var eff_stat = frameobj.eff_stat.value;
	  
	if(frameobj.function_name.value == "insert") 
		{
		//alert("inside insert");
		

			frameobj.other_staff_type1.value = frameobj1.other_staff_type.value;
			frameobj.other_staff_id1.value = frameobj1.other_staff_id.value;
			frameobj.other_staff_name1.value = frameobj1.other_staff_name.value;
			frameobj.short_name1.value = frameobj1.short_name.value;
			frameobj.eff_status1.value = frameobj1.eff_status.value;
			frameobj.date_of_birth1.value = frameobj.date_of_birth.value;
			frameobj.long_name1.value = frameobj1.long_name.value;			
			frameobj.other_alt_no1.value = frameobj.other_alt_no.value; //Added for this CRF HSA-CRF-160
           
			//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
			var fields = new Array();
			var names  = new Array();

			fields[0] = frameobj.other_staff_type1;
			fields[1] = frameobj.other_staff_id1;
			fields[2] = frameobj.other_staff_name1;
			fields[3] = frameobj.short_name1;
			fields[4] = frameobj.sex;
			fields[5] = frameobj.empl_status;
			fields[6] = frameobj.date_of_birth1;

			if(isResidencyApplYN == "true" && eff_stat == "E")
			{
				fields[7] = frameobj.citizen;
				if(frameobj.national_id_no && frameobj.nat_mandatory.style.visibility == "visible")
				{
					fields[8] = frameobj.national_id_no;
				}
				else if(frameobj.oth_alt_mand.style.visibility == "visible")
				{
					fields[8] = frameobj.other_alt_no;
				}
			}

			names[0] = getLabel("Common.OtherStaffType.label","Common");
			names[1] = getLabel("Common.identification.label","Common");
			names[2] = getLabel("Common.FullName.label","Common");
			names[3] = getLabel("Common.shortname.label","Common");
			names[4] = getLabel("Common.gender.label","Common");
			names[5] = getLabel("Common.EmplStatus.label","Common");
			names[6] = getLabel("Common.birthDate.label","Common");

			if(isResidencyApplYN == "true" && eff_stat == "E")
			{
				names[7] = getLabel("Common.Citizenship.label","Common");
				if(frameobj.national_id_no && frameobj.nat_mandatory.style.visibility == "visible")
				{
					names[8] = frameobj.nat_id_prompt.value;
				}
				else if(frameobj.oth_alt_mand.style.visibility == "visible")
				{
					names[8] = getLabel("eMP.OtherAltNo.label","MP");
				}
			}

    
	//alert("1");
        var transform = new Array (frameobj,
        			    frameobj.eff_date_from,
				    frameobj1.eff_date_from1,
				    frameobj.eff_date_to,
				    frameobj1.eff_date_to1);
}
else if(frameobj.function_name.value == "modify") 
	{
	//alert("inside modify");


frameobj.other_staff_type1.value = frameobj1.other_staff_type3.value;
frameobj.other_staff_id1.value = frameobj1.other_staff_id.value;
frameobj.other_staff_name1.value = frameobj1.other_staff_name.value;
frameobj.short_name1.value = frameobj1.short_name.value;
frameobj.eff_status1.value = frameobj1.eff_status.value;
frameobj.date_of_birth1.value = frameobj.date_of_birth.value;
frameobj.all_facilities1.value=frameobj.all_facilities.value;
frameobj.all_facilities1.disabled=false;
frameobj.long_name1.value = frameobj1.long_name.value;

frameobj.other_alt_no1.value = frameobj.other_alt_no.value; //Added for this CRF HSA-CRF-160

	//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
	var fields = new Array();
	var names  = new Array();

	fields[0] = frameobj.other_staff_type1;
	fields[1] = frameobj.other_staff_id1;
	fields[2] = frameobj.other_staff_name1;
	fields[3] = frameobj.short_name1;
	fields[4] = frameobj.sex2;
	fields[5] = frameobj.date_of_birth1;
	fields[6] = frameobj.empl_status2;

	if(isResidencyApplYN == "true" && eff_stat == "E")
	{
		fields[7] = frameobj.citizen;
		if(frameobj.national_id_no && frameobj.nat_mandatory.style.visibility == "visible")
		{
			fields[8] = frameobj.national_id_no;
		}
		else if(frameobj.oth_alt_mand.style.visibility == "visible")
		{
			fields[8] = frameobj.other_alt_no;
		}
	}

	names[0] = getLabel("Common.OtherStaffType.label","Common");
	names[1] = getLabel("Common.identification.label","Common");
	names[2] = getLabel("Common.FullName.label","Common");
	names[3] = getLabel("Common.shortname.label","Common");
	names[4] = getLabel("Common.gender.label","Common");
	names[5] = getLabel("Common.birthDate.label","Common");
	names[6] = getLabel("Common.EmplStatus.label","Common");

	if(isResidencyApplYN == "true" && eff_stat == "E")
	{
		names[7] = getLabel("Common.Citizenship.label","Common");
		if(frameobj.national_id_no && frameobj.nat_mandatory.style.visibility == "visible")
		{
			names[8] = frameobj.nat_id_prompt.value;
		}
		else if(frameobj.oth_alt_mand.style.visibility == "visible")
		{
			names[8] = getLabel("eMP.OtherAltNo.label","MP");
		}
	}

       var transform = new Array ( frameobj,
        			    frameobj.eff_date_from,
				    frameobj1.eff_date_from1,
				    frameobj.eff_date_to,
				    frameobj1.eff_date_to1);



}
	var spFields = new Array (frameobj1.other_staff_id);
	var spNames = new Array (getLabel("Common.identification.label","Common"));
	var error_page="../../eCommon/jsp/MstCodeError.jsp"

	if(f_query_add_mod.document.OtherStaff_sub.checkFieldsofMst( fields, names, messageFrame)) {
		
		frameobj.date_of_birth.disabled=false;

		//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
		if(isResidencyApplYN == "true" && frameobj.other_alt_type.disabled==true){
			 frameobj.other_alt_type.disabled=false;
		}
		frameobj.submit();
		//alert(frameobj.rep_facility2.value);	
		var fn_status = frameobj.function_name.value ;
		
		//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
		if(isResidencyApplYN == "true" && eff_stat == "E" && frameobj.other_alt_type.disabled==false && frameobj.res_citizen.item(1).checked == true){
			 frameobj.other_alt_type.disabled=true;
		}
	}
}



//end of apply


function reset() 
{
  
   if (f_query_add_mod.document.forms[0] != null)
	{
	    f_query_add_mod.document.location.reload() ;
	}
   else 
	{

	   f_query_add_mod.document.location.reload() ;
	  //f_query_add_mod.frames[0].location.reload();
	  //f_query_add_mod.frames[1].location.reload();
         // f_query_add_mod.frames[0].document.OtherStaff_form.reset() ;
         //  f_query_add_mod.frames[1].document.OtherStaff1_form.reset() ;
			//alert(f_query_add_mod.frames[0].OtherStaff1_form.rep_facility.disabled)
    }
}

function onSuccess() {
if(f_query_add_mod.document.OtherStaff_sub.OtherStaff1_form.function_name.value !="modify")
	{
f_query_add_mod.location.reload();
	}else
	{
f_query_add_mod.location.reload();
	}
	//f_query_add_mod.location.reload();
}


function sendToServer(Val) {

var HTMLVal = new String();

if (Val == 1)
{

	HTMLVal = "<HTML><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAM/jsp/ServerFunction.jsp'><input type='hidden' name='process_d' id='process_d' value='1'><input name='date_of_birth' id='date_of_birth' type='hidden' value='"+document.getElementById("date_of_birth").value+"'></form></BODY></HTML>";
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
	if ( CheckDate(document.getElementById('date_of_birth')) == false) {
		document.getElementById('date_of_birth').focus();
	}
	else
	{

		if ( doDateCheckAlert(Obj,document.getElementById('server_date')) )
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

function validateNationality(Nat_Id,nat_id_prompt,nat_id_check_digit_id)	{

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
				Nat_Id.select();
				alert(msg);
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
				HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form id='form1' name='form1' method='post' action='../../eAM/jsp/CheckForNationality.jsp?step=second'><input id='national_id_no'  type='hidden' name='national_id_no' value='"+Nat_Id.value+"'><input id='FROM_VAL'  type='hidden' name='FROM_VAL' value='OTHER_STAFF'></form></body></html>";
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
function CheckDate1(Object2,focusflag) {
    var datefield = Object2;
    if (ChkDate(Object2) == false) {
      //  alert(getMessage("INVALID_DATE_FMT", "SM"));
        if(focusflag == null)
        {
            datefield.select();
          // document.getElementById("date_of_birth").focus();
        }
        return false;
    }
    else {
        return true;
    }
}


/*function calcage(obj1,obj2) {
	if(doDateCheckAlert(obj1,document.getElementById("server_date")))
		{
		if(CheckDate1(obj1) == false)
			{
		}
		//document.getElementById("date_of_birth").focus();
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
	    var datecal2=document.getElementById("server_date").value;
		 //bornDate = new Date(mm+'/'+ dd +'/'+ yy)
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
	
	

	document.getElementById("b_age").value= ageYears ;
	if(document.getElementById("b_age").value.length == 1  && document.getElementById("b_age").value !='0') document.getElementById("b_age").value="0"+ageYears ;
	//if(ageYears > 1 || ageYears < 10) parent.document.frames[0].document.forms[0].b_age.value="0"+ageYears ; 
	
	document.getElementById("b_months").value=ageMonths;
	if(document.getElementById("b_months").value.length == 1 && document.getElementById("b_months").value !='0') document.getElementById("b_months").value="0"+ageMonths;
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
alert(getMessage('DOB_CHECK','Common'));
document.getElementById("date_of_birth").focus();
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


function calculateAge(Obj,Val)
{
var greg_date_of_birth ="";

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
	
	greg_date_of_birth =convertDate(Obj.value,"DMY",localeName,"en");
	document.getElementById('greg_date_of_birth').value=greg_date_of_birth;

	

  // if(calcage(document.getElementById("greg_date_of_birth"),document.getElementById("ServerDate")))
//{ 
	if(BirthDay_check(document.getElementById('server_date'),Obj))
		{
			 
    HTMLVal = "<HTML><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAM/jsp/ServerValidation1.jsp'><input type='hidden' name='reference' id='reference' value='parent.f_query_add_mod.document.OtherStaff_sub.document.OtherStaff1_form'><input type='hidden' name='process_id' id='process_id' value='1'><input name='date_of_birth' id='date_of_birth' type='hidden' value='"+greg_date_of_birth+ "'></form></BODY></HTML>";
	parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
    parent.parent.messageFrame.document.form1.submit();
		}
  // }
}
	}
	else
	{
			document.forms[1].b_months.value='';
			document.forms[1].b_age.value='';
			document.forms[1].b_days.value='';
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
		   		document.getElementById("b_days").value=''
		   	
		   	}
		   
		   
		   }
	}	   
		  if(flag)
		  {
		  HTMLVal = "<HTML><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAM/jsp/ServerValidation1.jsp'><input type='hidden' name='reference' id='reference' value='parent.f_query_add_mod.document.OtherStaff_sub.document.OtherStaff1_form'><input type='hidden' name='process_id' id='process_id' value='2'><input type='hidden' name='b_age' id='b_age' value='" + document.getElementById("b_age").value + "'><input type='hidden' name='b_months' id='b_months' value='" + document.getElementById("b_months").value +"'><input name='b_days' id='b_days' type='hidden' value='"+document.forms[1].b_days.value + "'></form></BODY></HTML>";
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
		Obj.focus();
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
alert(getMessage('MONTHS_CHECK','Common'));
document.getElementById('date_of_birth').value='';
Obj.focus(); 

return false;
}
else{
return true;

}

}
function checkActive(target)
{
	tabKeyFlag=false;
	if(target.checked == false)
	{
		target.value = "D";
		target.checked = false;
		target.focus();
	}
	else
	{
		target.value = "E";
		target.checked = true;
		target.focus();
	}

}

function checkDays(Obj)
{
if( Obj.value  > 31) { //alert('APP-MP0073 Days cannot be greater than 31'); 
alert(getMessage('DAYS_CHECK','Common'));
Obj.focus();
document.getElementById('date_of_birth').value='';
return false;

}else{
	calci(Obj);
}
}
function check12() {
			
	      	
      	}
function tab_click2(id){
			selectTab(id);
			objClick(id);
	}
		function callfocus1(obj)
		{
		
		if(parent.frames[1].document.forms[1].effstatus.value=='D')
		  parent.parent.frames[2].focus();
		else
			document.forms[0].other_staff_type.focus();

		}
      	function objClick(objName)
      	{
			
      		//changeLink(objName);
			
      		if (objName == 'search_tab')
			{
      			parent.OtherStaff_sub.moveToLink(1);
			}
      		else if(objName == 'additional_tab')
      		{
      		parent.OtherStaff_sub.moveToLink(2);	
      		}
      	}

/*	function searchCode(obj,target)
		{ 
			var retVal = new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			
			if(obj.name=="postal_code")
			{
				tit=encodeURIComponent(getLabel("eMP.postalcode.label","mp"));

				sql="select postal_code, short_desc from mp_postal_code";
				search_code="postal_code";
				search_desc= "short_desc"
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
		}*/

		async function searchCode(obj,target_code,target_desc)
				{
					
				var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				//var locale=document.forms[0].locale.value;
				var tit="";
				var sql="";


				
				tit=getLabel("eMP.postalcode.label","mp");
				
				sql="select postal_code code, short_desc description from mp_postal_code where  upper(postal_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
							
							
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target_code.value;
				argumentArray[6] = CODE_LINK ;
				argumentArray[7] = CODE_DESC ;
				
				retVal = await CommonLookup( tit, argumentArray );
				if (retVal !=null && retVal !="")
				{
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target_desc.value=arr[1];
					target_code.value=arr[0];
				}else
				{
				target_desc.value="";
				target_code.value="";
				}
			
			}


	
	

      	function check() {
	      	if (document.OtherStaff1_form.all_facilities.checked == true) {
		  		document.OtherStaff1_form.all_facilities.value="Y";
     
				if(document.getElementById('rep_facility')!=null)
				{
				document.getElementById('rep_facility').disabled=true;
				document.getElementById('rep_facility').value="";
				if(document.getElementById('rep_facility2'))
					{
				document.getElementById('rep_facility2').disabled=true;
				document.getElementById('rep_facility2').value="";
					}
				}

					

			}
	      	else{
		  		document.OtherStaff1_form.all_facilities.value="N";
				if(document.getElementById('rep_facility')!=null)
					document.getElementById('rep_facility').disabled=false;
		 		} 


      	}
		
		function checkOtherStaff()
		{

			if(OtherStaff1_form.function_name.value == "insert") {
				parent.frames[1].document.OtherStaff1_form.other_staff_type1.value=parent.frames[1].document.OtherStaff_form.other_staff_type.value;
	
				}
			else if(OtherStaff1_form.function_name.value == "modify") {

				check1();
				OtherStaff1_form.other_staff_type1.value=OtherStaff_form.other_staff_type3.value;
				}
		}
		function  checkPosition(form,current)
		{
			var otherstafftype1=current.value;
			var otherstafftype=current.name;
				if(otherstafftype=="other_staff_type")
				//	document.forms[0].other_staff_type.value='';
					removeitems(parent.frames[1].document.forms[1].Position);

					var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'>";
					HTMLVal = HTMLVal +"<form name='form1' id='form1' method='post' action='../../eAM/jsp/OtherStaffFetchPosition.jsp'>";
					HTMLVal = HTMLVal +"<input name='otherstafftype' id='otherstafftype' type='hidden' value= '"+otherstafftype1 +"'>";
					HTMLVal = HTMLVal +"</form></BODY></HTML>";
				parent.parent.messageFrame.document.write(HTMLVal);
				parent.parent.messageFrame.document.forms[0].submit();
					
				
		}
		function removeitems(obj)
				{
					var len=obj.length;
					var i=1;
					while(i<len)
					{
						len=obj.length
						obj.remove(i)
					}
				}
		
		function check1() {
		if(OtherStaff_form.other_staff_type)
			OtherStaff_form.other_staff_type3.value = OtherStaff_form.other_staff_type.value;
		}

		function check2() {
			OtherStaff1_form.sex2.value=OtherStaff1_form.sex.value;
		}

		function check3() {
		OtherStaff1_form.empl_status2.value=OtherStaff1_form.empl_status.value;

		}

		function check4() {
			OtherStaff1_form.pref_contact_mode2.value=OtherStaff1_form.pref_contact_mode.value;
		}

		function check5() {
			//OtherStaff1_form.marital_status.value=OtherStaff1_form.marital_status.value;
		}

		function check6() {
			OtherStaff1_form.citizen2.value=OtherStaff1_form.citizen.value;
		}
		

		function check7() {
			if(OtherStaff1_form.function_name.value == "modify") {
				
				OtherStaff1_form.rep_facility2.value=OtherStaff1_form.rep_facility.value;
			}
		}

		function check8() {
			OtherStaff1_form.res_add_postal_code2.value=OtherStaff1_form.res_add_postal_code.value;
		}

		function check9() {
			OtherStaff1_form.res_add_country_code2.value= OtherStaff1_form.res_add_country_code.value;
		}

		function check10() {
			OtherStaff1_form.off_add_postal_code2.value =OtherStaff1_form.off_add_postal_code.value;
		}

		function check11() {
			OtherStaff1_form.off_add_country_code2.value =OtherStaff1_form.off_add_country_code.value;
		}

		function check12() {
			OtherStaff1_form.mail_add_postal_code2.value =OtherStaff1_form.mail_add_postal_code.value;
		}

		function check13() {
			OtherStaff1_form.mail_add_country_code2.value =OtherStaff1_form.mail_add_country_code.value;
		}

	
function allowValidNumber(fld, e, maxInt, deci)
{
	var count=fld.value.length;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if(count>=maxInt)
	{
		if(count==maxInt)
		{
		    var dotOccurance = fld.value.indexOf('.');
			if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt))
			{
				if(whichCode!=46)
				{
					var errors = getMessage("AM0126","am");
					return false;
				}
			}
		}
		else if(count>maxInt)
		{
			var objectValue = fld.value;
		    var dotOccurance = objectValue.indexOf('.');
			if((objectValue.charAt(maxInt))!='.')
			{
				if(dotOccurance==-1)
				{
					fld.value = objectValue.substring(0,maxInt)+".";
					return false;
				}
			}
		}
	}
	if (parseInt(deci)==1)//For Minus,Decimal Point and 0-9
	  var strCheck = '.0123456789-';
	else if (parseInt(deci)==2) //For Decimal Point and 0-9
	{
	   var strCheck = '.0123456789';
	}
	else if (parseInt(deci)==0)//For Only Nos 0 - 9
	{
		var strCheck = '0123456789';
	}
	else if (parseInt(deci)==3)//For Minus and 0-9 Only
	{
		var strCheck = '0123456789-';
	}
	if (parseInt(deci)==1)
	{
		var fldvalue=fld.value;
		if (whichCode == 45 && (fldvalue.length==0)) return 
true;  // minus 
		if (whichCode == 45 && (fldvalue.length>0)) return 
false;  // minus 
	}

	var fldvalue=fld.value;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13) return true;  // Enter
	var pointCount=0;
	for(var i=0;i<fldvalue.length;i++)
	{
		if(fldvalue.charAt(i)=='.') pointCount++;
	}
	if (pointCount>0 && whichCode == 46) return false;
	var fldValue	=	fld.value;
	var dotIndex	=	fldValue.indexOf(".");
	var fldLength	=	fldValue.length;
	if(dotIndex!=-1)
		if( fldLength > (dotIndex+3) ) return false;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true;
}

function resMove()
{
	var error=getMessage("WELCOME","common");
	//alert(error);
}
function changeFocus()
{
	if (document.getElementById('other_staff_type'))
		document.getElementById('other_staff_type').focus();
}
	
function changeFocus1()
{
	objClick('identity_link');
	
}

var errorsThere = new Boolean(false);

function chkY()
	{
		var maxAge = parent.frames[1].document.getElementById('max_pa_age').value;
		var actAge = parent.frames[1].document.getElementById('b_age').value;
		var actMonth = parent.frames[1].document.getElementById('b_months').value;
		var actDay =parent.frames[1].document.getElementById("b_days").value; 
		if (maxAge != '')
		{
			if (parseInt(actAge) > parseInt(maxAge) || 
			   ((parseInt(actAge) == parseInt(maxAge)) && (parseInt(actMonth) > 0 || parseInt(actDay) > 0)))
			{
				var msg= getMessage("MAX_PATIENT_AGE",'MP')+" "+maxAge+" "+getLabel("Common.Years.label","common");
				alert(msg);
				parent.frames[1].document.getElementById('b_age').focus();
			}
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
				obj.select();	
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

function tab_click22(){
	//alert('23')
		//alert(parent.frames[1].name)
	//contactnolink
	//tab_click2('additional_tab');
	//prevTabObj='additional_tab';
	parent.frames[1].document.getElementById('contactnolink').scrollIntoView();
}

function CheckForAlphaCharsNatID(event){

	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-';
	
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}


function setfocus()
{	if( parent.frames[0].document.forms[0])
	   if( parent.frames[0].document.forms[0].other_staff_type)
          parent.frames[0].document.forms[0].other_staff_type.focus();
}

/*Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011*/
function validateCitizen(nat_code)
{
	document.OtherStaff1_form.citizen.value = nat_code;

	if(document.OtherStaff1_form.citizen2)
	{
		document.OtherStaff1_form.citizen2.value = nat_code;
	}
	if(document.OtherStaff1_form.national_id_no)
	{
		document.OtherStaff1_form.national_id_no.value = document.OtherStaff1_form.oldnationalid.value;
		document.OtherStaff1_form.national_id_no.disabled = false;
		if(document.OtherStaff1_form.natid_mand_yn.value == "Y")
		{
			document.OtherStaff1_form.nat_mandatory.style.visibility = "visible";
		}
	}
	if(document.OtherStaff1_form.other_alt_type_no.value != "")
	{
		document.OtherStaff1_form.other_alt_type.value = document.OtherStaff1_form.other_alt_type_no.value;
		document.OtherStaff1_form.other_alt_type.disabled = false;
		document.OtherStaff1_form.other_alt_no.value = document.OtherStaff1_form.other_alt_type_desc.value;
		document.OtherStaff1_form.other_alt_no.disabled = false;
		document.OtherStaff1_form.oth_alt_mand.style.visibility = "hidden";
	}else
	{
		document.OtherStaff1_form.other_alt_type.value = "";
		document.OtherStaff1_form.other_alt_type.disabled = false;
		document.OtherStaff1_form.other_alt_no.value = "";
		document.OtherStaff1_form.other_alt_no.disabled = true;
		document.OtherStaff1_form.oth_alt_mand.style.visibility = "hidden";
	}
	
	document.OtherStaff1_form.other_alt_no.maxLength = "20";
}

function validateNonCitizen(nat_code,citzn_code)
{
	var alt_id1_type = document.OtherStaff1_form.alt_id1_type.value;

	if(nat_code == citzn_code)
	{
		document.OtherStaff1_form.citizen.value = "";
		if(document.OtherStaff1_form.citizen2) 
		{
			document.OtherStaff1_form.citizen2.value = "";
		}
	}else
	{
		document.OtherStaff1_form.citizen.value = citzn_code;
		if(document.OtherStaff1_form.citizen2)
		{
			document.OtherStaff1_form.citizen2.value = citzn_code;
		}
	}

	if(document.OtherStaff1_form.national_id_no)
	{
		document.OtherStaff1_form.national_id_no.value = "";
		document.OtherStaff1_form.national_id_no.disabled = true;
		document.OtherStaff1_form.nat_mandatory.style.visibility = "hidden";
	}
	if(document.OtherStaff1_form.oth_alt_val.value != "")
	{
		if(document.OtherStaff1_form.other_alt_type_no.value == document.OtherStaff1_form.oth_alt_val.value)
		{
			document.OtherStaff1_form.other_alt_no.value = document.OtherStaff1_form.other_alt_type_desc.value;
		}
		else
		{
			document.OtherStaff1_form.other_alt_no.value = "";			
		}
		document.OtherStaff1_form.other_alt_type.value = document.OtherStaff1_form.oth_alt_val.value;
		document.OtherStaff1_form.other_alt_type.disabled = true;
		document.OtherStaff1_form.other_alt_no.disabled = false;
		document.OtherStaff1_form.oth_alt_mand.style.visibility = "visible";
	}else
	{
		document.OtherStaff1_form.other_alt_type.value = "";
		document.OtherStaff1_form.other_alt_type.disabled = true;
		document.OtherStaff1_form.other_alt_no.value = "";
		document.OtherStaff1_form.other_alt_no.disabled = true;
		document.OtherStaff1_form.oth_alt_mand.style.visibility = "hidden";
	}

	if(document.OtherStaff1_form.oth_alt_val.value == alt_id1_type)
	{
		document.OtherStaff1_form.other_alt_no.maxLength = document.OtherStaff1_form.alt_id1_length.value;
	}else
	{
		document.OtherStaff1_form.other_alt_no.maxLength = "20";
	}
}

function checkCitznOrNonCitzn()
{
	var nat_code = document.OtherStaff1_form.citizen_nat_code.value;
	var citzn_code = document.OtherStaff1_form.citizen.value;
	var alt_id1_type = document.OtherStaff1_form.alt_id1_type.value;

	if(citzn_code != "")
	{
		if(citzn_code == nat_code)
		{
			document.OtherStaff1_form.res_citizen.item(0).checked = true;

			if(document.OtherStaff1_form.national_id_no)
			{
				document.OtherStaff1_form.national_id_no.value = document.OtherStaff1_form.oldnationalid.value;
				document.OtherStaff1_form.national_id_no.disabled = false;
				if(document.OtherStaff1_form.natid_mand_yn.value == "Y")
				{
					document.OtherStaff1_form.nat_mandatory.style.visibility = "visible";
				}
			}
			if(document.OtherStaff1_form.other_alt_type_no.value != "")
			{
				document.OtherStaff1_form.other_alt_type.value = document.OtherStaff1_form.other_alt_type_no.value;
				document.OtherStaff1_form.other_alt_type.disabled = false;
				document.OtherStaff1_form.other_alt_no.value = document.OtherStaff1_form.other_alt_type_desc.value;
				document.OtherStaff1_form.other_alt_no.disabled = false;
				document.OtherStaff1_form.oth_alt_mand.style.visibility = "hidden";
			}else
			{
				document.OtherStaff1_form.other_alt_type.value = "";
				document.OtherStaff1_form.other_alt_type.disabled = false;
				document.OtherStaff1_form.other_alt_no.value = "";
				document.OtherStaff1_form.other_alt_no.disabled = true;
				document.OtherStaff1_form.oth_alt_mand.style.visibility = "hidden";
			}

			document.OtherStaff1_form.other_alt_no.maxLength = "20";
		}else
		{
			document.OtherStaff1_form.res_citizen.item(1).checked = true;

			if(document.OtherStaff1_form.national_id_no)
			{
				document.OtherStaff1_form.national_id_no.value = "";
				document.OtherStaff1_form.national_id_no.disabled = true;
				document.OtherStaff1_form.nat_mandatory.style.visibility = "hidden";
			}
			if(document.OtherStaff1_form.oth_alt_val.value != "")
			{
				if(document.OtherStaff1_form.other_alt_type_no.value == document.OtherStaff1_form.oth_alt_val.value)
				{
					document.OtherStaff1_form.other_alt_no.value = document.OtherStaff1_form.other_alt_type_desc.value;
				}
				else
				{
					document.OtherStaff1_form.other_alt_no.value = "";			
				}
				document.OtherStaff1_form.other_alt_type.value = document.OtherStaff1_form.oth_alt_val.value;
				document.OtherStaff1_form.other_alt_type.disabled = true;
				document.OtherStaff1_form.other_alt_no.disabled = false;
				document.OtherStaff1_form.oth_alt_mand.style.visibility = "visible";
			}else
			{
				document.OtherStaff1_form.other_alt_type.value = "";
				document.OtherStaff1_form.other_alt_type.disabled = true;
				document.OtherStaff1_form.other_alt_no.value = "";
				document.OtherStaff1_form.other_alt_no.disabled = true;
				document.OtherStaff1_form.oth_alt_mand.style.visibility = "hidden";
			}

			if(document.OtherStaff1_form.oth_alt_val.value == alt_id1_type)
			{
				document.OtherStaff1_form.other_alt_no.maxLength = document.OtherStaff1_form.alt_id1_length.value;
			}else
			{
				document.OtherStaff1_form.other_alt_no.maxLength = "20";
			}
		}
	}
}

function duplicateNatIdValidation(nat_id,nat_id_prompt)
{
	var national_id = nat_id.value;
	var old_nat_id = document.OtherStaff1_form.oldnationalid.value;

	if(national_id.toUpperCase() != old_nat_id.toUpperCase())
	{
		var xmlDoc=""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH national_id=\""+national_id+"\" action='getOthStaffName' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eAM/jsp/AMIntermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText = xmlHttp.responseText
		var retval = trimString(responseText);
		retval = retval.split("|~|");
		var rec_cnt = retval[0];
		var oth_staff_name = retval[1];

		if(rec_cnt == 1)
		{
			msg = getMessage('PRACT_DUP_NAT_ID','AM');
			msg = msg.replace("$",oth_staff_name);
			msg = msg.replace("#",nat_id_prompt);
			nat_id.select();
			alert(msg);
			return false;
		}else if(rec_cnt > 1)
		{
			msg = getMessage('PRACT_DUP_NAT_ID_MULTIPLE','AM');
			msg = msg.replace("#",nat_id_prompt);
			nat_id.select();
			alert(msg);
			return false;
		}
	}
}

function duplicateOthAltIdValidation(alt_id,oth_alt_type)
{
	var alt_id1_type = document.OtherStaff1_form.alt_id1_type.value;

	if(document.OtherStaff1_form.res_citizen.item(1).checked == true)
	{
		var other_alt_type_desc = document.OtherStaff1_form.other_alt_type_desc.value;
		var oth_alt_id = alt_id.value;

		if ( oth_alt_id.length == alt_id.maxLength && oth_alt_id.length != 0)
		{
			validateDuplicate(other_alt_type_desc,oth_alt_id,alt_id,oth_alt_type);
		}else
		{
			if (alt_id.value != '')
			{
				if(document.OtherStaff1_form.oth_alt_val.value == alt_id1_type)
				{
					var err = getMessage('MAX_LENGHT_VALIDATE','AM');
					err= err.replace('$',getLabel("eMP.OtherAltNo.label","MP"));
					err= err.replace('#',document.getElementById('other_alt_no').maxLength);
					alert(err);
					document.getElementById('other_alt_no').focus();
				}else
				{
					validateDuplicate(other_alt_type_desc,oth_alt_id,alt_id,oth_alt_type);
				}
			}
		}
	}
}

function validateDuplicate(other_alt_type_desc,oth_alt_id,alt_id,oth_alt_type)
{
	if(other_alt_type_desc.toUpperCase() != oth_alt_id.toUpperCase())
	{
		var xmlDoc=""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH oth_alt_type=\""+oth_alt_type+"\" oth_alt_id=\""+oth_alt_id+"\" action='getOthAltStaffName' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eAM/jsp/AMIntermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText = xmlHttp.responseText
		var retval = trimString(responseText);
		retval = retval.split("|~|");
		var rec_cnt = retval[0];
		var oth_staff_name = retval[1];

		if(rec_cnt == 1)
		{
			msg = getMessage('PRACT_DUP_NAT_ID','AM');
			msg = msg.replace("$",oth_staff_name);
			msg = msg.replace("#",getLabel("eMP.OtherAltNo.label","MP"));
			alt_id.select();
			alert(msg);
			return false;
		}else if(rec_cnt > 1)
		{
			msg = getMessage('PRACT_DUP_NAT_ID_MULTIPLE','AM');
			msg = msg.replace("#",getLabel("eMP.OtherAltNo.label","MP"));
			alt_id.select();
			alert(msg);
			return false;
		}
	}
}
/*End MOHE-CRF-0011*/

