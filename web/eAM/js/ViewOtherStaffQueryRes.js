function moveToLink(LinkIndex) {
	if(LinkIndex==1)
	{
		document.getElementById('identitylink').scrollIntoView();
	}
	else if(LinkIndex==2)
	{
			document.getElementById('contactnolink').scrollIntoView();
	}

}
function create() {

	f_query_add_mod.location.href = "../../eAM/jsp/PractitionerMain.jsp" ;
	setTimeout("f_query_add_mod.document.frames[0].practitioner_form.pract_type.focus()",1000);
}

function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/PractitionerQueryCriteria.jsp?function=setup practitioner";
}


function apply() {

if(f_query_add_mod.document.frames[1].practitioner1_form.function_name.value == "insert") {
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
			getLabel("Common.shortname.label","Common") ,
			"Sex",
			getLabel("Common.EmplStatus.label","Commn"),
			getLabel("Common.birthDate.label","Common"),
			getLabel("Common.primaryspeciality.label","Common")+""+getLabel("Common.code.label","Common")
			);

      /* if((f_query_add_mod.document.frames[1].practitioner1_form.empl_status.value=="F") || (f_query_add_mod.document.frames[1].practitioner1_form.empl_status.value == "P")|| (f_query_add_mod.document.frames[1].practitioner1_form.empl_status.value == "S")) {
       fields[fields.length-1] =f_query_add_mod.document.frames[1].practitioner1_form.rep_facility;
       names[names.length-1]="Reporting Facility"

       }
       else {
       	fields.length=fields.length-1;
       	names.length=names.length-1;
        }
*/

        var transform = new Array ( f_query_add_mod.document.frames[1].practitioner1_form,
        			    f_query_add_mod.document.frames[1].practitioner1_form.eff_date_from,
				    f_query_add_mod.document.frames[0].practitioner_form.eff_date_from1,
				    f_query_add_mod.document.frames[1].practitioner1_form.eff_date_to,
				    f_query_add_mod.document.frames[0].practitioner_form.eff_date_to1

			  );
}
else if(f_query_add_mod.document.frames[1].practitioner1_form.function_name.value == "modify") {


f_query_add_mod.document.frames[1].practitioner1_form.pract_type1.value = f_query_add_mod.document.frames[0].practitioner_form.pract_type3.value;
f_query_add_mod.document.frames[1].practitioner1_form.practitioner_id1.value = f_query_add_mod.document.frames[0].practitioner_form.practitioner_id.value;
f_query_add_mod.document.frames[1].practitioner1_form.practitioner_name1.value = f_query_add_mod.document.frames[0].practitioner_form.practitioner_name.value;
f_query_add_mod.document.frames[1].practitioner1_form.short_name1.value = f_query_add_mod.document.frames[0].practitioner_form.short_name.value;
f_query_add_mod.document.frames[1].practitioner1_form.eff_status1.value = f_query_add_mod.document.frames[0].practitioner_form.eff_status.value;
f_query_add_mod.document.frames[1].practitioner1_form.date_of_birth1.value = f_query_add_mod.document.frames[1].practitioner1_form.date_of_birth.value;
f_query_add_mod.document.frames[1].practitioner1_form.all_facilities1.value=f_query_add_mod.frames[1].practitioner1_form.all_facilities.value;
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



 var names = new Array ( getLabel("Common.type.label","Common"),
			getLabel("Common.identification.label","Common"),
			getLabel("Common.FullName.label","Common"),
			getLabel("Common.shortname.label","Common") ,
			"Sex",
        	getLabel("Common.birthDate.label","Common"),
        	getLabel("Common.EmplStatus.label","Common"),
        	getLabel("Common.primaryspeciality.label","Common"));
/*
       if((f_query_add_mod.document.frames[1].practitioner1_form.empl_status2.value == "F") || (f_query_add_mod.document.frames[1].practitioner1_form.empl_status2.value == "P")) {


       fields[fields.length-1] =f_query_add_mod.document.frames[1].practitioner1_form.rep_facility2
       names[names.length-1]="Reporting facility";
       }
       else {
       	fields.length=fields.length-1;
       	names.length=names.length-1;
       }

*/ 
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
//	alert(spFields[0].value)
	if(SpecialCharCheck (spFields,spNames,messageFrame,"M",error_page))
//////////----------------------------------////////////////////
	if(f_query_add_mod.document.frames[1].checkFieldsofMst( fields, names, messageFrame)) {
		//if(f_query_add_mod.document.frames[1].DateTransform(transform,messageFrame)) {
		
			// //alert(f_query_add_mod.document.frames[1].practitioner1_form.res_add_postal_code2.value);	
			//alert(f_query_add_mod.document.frames[1].practitioner1_form.off_add_postal_code2.value);	
			//alert(f_query_add_mod.document.frames[1].practitioner1_form.mail_add_postal_code2.value);	
		f_query_add_mod.document.frames[1].practitioner1_form.date_of_birth.disabled=false;
			f_query_add_mod.document.frames[1].practitioner1_form.submit();
		   var fn_status = f_query_add_mod.document.frames[1].practitioner1_form.function_name.value ;
		//}
	}
}


function reset() {
       /*if(f_query_add_mod.frames[0].document.forms[0].name == "practitioner_form" && f_query_add_mod.frames[1].document.forms[1].name == "practitioner1_form") {
           f_query_add_mod.frames[0].document.practitioner_form.reset() ;
           f_query_add_mod.frames[1].document.practitioner1_form.reset() ;
          }
       else
	    *///f_query_add_mod.document.query_form.reset() ;
		f_query_add_mod.location.reload();

}

function onSuccess() {//alert('here');
//	if(f_query_add_mod.document.practitioner1_form.function_name=='insert'){
		
//f_query_add_mod.location.href = "../../eAM/jsp/PractitionerMain.jsp" ;
//	}
	f_query_add_mod.location.reload();
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
	//alert(document.getElementById("b_age").value );
	//alert(document.getElementById("b_months").value );
	//alert(document.getElementById("b_days").value );

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
			Obj.focus();
		}

	}
}
else if ( Obj == document.getElementById('b_days') )
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

function validateNationality(Nat_Id)	{

var isNumber = new Boolean();
if ( Nat_Id.value.length > 0 )
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
}

if ( isNumber )
{

	var nid = new String();
	nid = trimString(Nat_Id.value);
	Nat_Id.value = nid;

	if ( nid.length == Nat_Id.maxLength  && nid.length != 0)
	{


		var HTMLVal = new String();
		HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAM/jsp/CheckForNationality.jsp?step=second'><input type='hidden' name='national_id_no' id='national_id_no' value='"+Nat_Id.value+"'><input type='hidden' name='FROM_VAL' id='FROM_VAL' value=''></form></body></html>";
		parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.parent.messageFrame.document.form1.submit();
	}
	else
	{

		if ( Nat_Id.value != '' )
		{
			alert('APP-MP0068 Nationality Id should be of '+document.getElementById("national_id_no").maxLength+' Characters');
			document.getElementById("national_id_no").focus();
		}
	}
}
}


function calcage(obj1,obj2) {
	if(doDateCheckAlert(obj1,document.getElementById('server_date')))
		{
		if(CheckDate(obj1) == false)
		obj1.focus();
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
	
	

	document.getElementById('b_age').value= ageYears ;
	if(document.getElementById('b_age').value.length == 1  && document.getElementById('b_age').value !='0') document.getElementById('b_age').value="0"+ageYears ;
	//if(ageYears > 1 || ageYears < 10) parent.document.frames[0].document.forms[0].b_age.value="0"+ageYears ; 
	
	document.getElementById('b_months').value=ageMonths;
	if(document.getElementById('b_months').value.length == 1 && document.getElementById('b_months').value !='0') document.getElementById('b_months').value="0"+ageMonths;
	//if(ageMonths > 1 || ageMonths < 10) parent.document.frames[0].document.forms[0].b_months.value="0"+ageMonths;
	
	document.getElementById('b_days').value=ageDays;
	if(document.getElementById('b_days').value.length == 1 && document.getElementById('b_days').value !='0') document.getElementById('b_days').value="0"+ageDays;
	//if(ageDays > 1 || ageDays < 10 ) parent.document.frames[0].document.forms[0].b_days.value="0"+ageDays;
	}
}
}
else
{
//alert('APP-MP0071 Date of Birth cannot be greater than TODAY ');
alert(getMessage("DOB_CHECK","Common"));
obj1.focus();
}

}
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

function calci(Obj)
{
var hide= document.getElementById('server_date').value;
strDateArray = hide.split("/");
	if (strDateArray.length != 3) ;
	else {
		strDay = strDateArray[0];
		strMonth = strDateArray[1];
		strYear = strDateArray[2];
	}
if(Obj.name == 'b_age' || Obj.value >0)
	{
	var yy=document.getElementById('b_age').value;
	days = new Date();
	gdate = days.getDate();
	gmonth = days.getMonth();
	gyear = days.getYear();
	age = strYear - yy;
	document.getElementById('date_of_birth').value=strDay+"/"+strMonth+"/"+age;
	document.getElementById('text5').value=document.getElementById('date_of_birth').value;
	}
	
if(Obj.name == 'b_months' || (document.getElementById('b_months').value >0 && document.getElementById('b_months').value <12))
{
if(document.getElementById('text5').value == '') document.getElementById('text5').value=document.getElementById('server_date').value;
var hide1= document.getElementById('text5').value;
var mm=document.getElementById('b_months').value;

strDateArray1 = hide1.split("/");

		strDay1 = strDateArray1[0];
		strMonth1 = strDateArray1[1];
		strYear1 = strDateArray1[2];
strMonth1=strMonth1-mm;
if(strMonth1 <=0)
{
strMonth1=12+strMonth1;
strYear1=strYear1-1;
}


//if(strMonth1 <=9 && strMonth1 >=1) strMonth1="0"+strMonth1;
if(strMonth1 == "1") strMonth1="01";
if(strMonth1 == "2") strMonth1="02";
if(strMonth1 == "3") strMonth1="03";
if(strMonth1 == "4") strMonth1="04";
if(strMonth1 == "5") strMonth1="05";
if(strMonth1 == "6") strMonth1="06";
if(strMonth1 == "7") strMonth1="07";
if(strMonth1 == "8") strMonth1="08";
if(strMonth1 == "9") strMonth1="09";



//if(strDay <=9 && strDay >=1) strDay="0"+strDay;
if(strDay == "1") strDay="01";
if(strDay == "2") strDay="02";
if(strDay == "3") strDay="03";
if(strDay == "4") strDay="04";
if(strDay == "5") strDay="05";
if(strDay == "6") strDay="06";
if(strDay == "7") strDay="07";
if(strDay == "8") strDay="08";
if(strDay == "9") strDay="09";


document.getElementById('date_of_birth').value=strDay+"/"+strMonth1+"/"+strYear1;
document.getElementById('text6').value=document.getElementById('date_of_birth').value;
}
if(Obj.name == 'b_days' || (document.getElementById('b_days').value >0 && document.getElementById('b_days').value <32))
{

if(document.getElementById('text6').value == '')  document.getElementById('text6').value=document.getElementById('server_date').value;
var hide2= document.getElementById('text6').value;
var dd=document.getElementById('b_days').value;
strDateArray2 = hide2.split("/");

		strDay2 = strDateArray2[0];
		strMonth2= strDateArray2[1];
		strYear2 = strDateArray2[2];

strDay=strDay2-dd;
if(strDay <=0)
{
strMonth2=strMonth2-1;
if(strMonth2 == 0) { strMonth2="12"; strYear2=strYear2-1}
if(strMonth2 == 2)
	{
	if(leapyear(strYear2))
		{
		strDay=29+strDay+2;
		}
		else
	strDay=28+strDay;
	}
	else
	if((strMonth2 == 4) || (strMonth2 == 6) || (strMonth2 == 9) || (strMonth2 == 11))
	{
	strDay=30+strDay;
	}
	else
	{
	strDay=31+strDay-1;
	}
	}

if(strMonth2 == "1") strMonth2="01";
if(strMonth2 == "2") strMonth2="02";
if(strMonth2 == "3") strMonth2="03";
if(strMonth2 == "4") strMonth2="04";
if(strMonth2 == "5") strMonth2="05";
if(strMonth2 == "6") strMonth2="06";
if(strMonth2 == "7") strMonth2="07";
if(strMonth2 == "8") strMonth2="08";
if(strMonth2 == "9") strMonth2="09";

//if(strDay <=9 && strDay >=1) strDay="0"+strDay;
if(strDay == "1") strDay="01";
if(strDay == "2") strDay="02";
if(strDay == "3") strDay="03";
if(strDay == "4") strDay="04";
if(strDay == "5") strDay="05";
if(strDay == "6") strDay="06";
if(strDay == "7") strDay="07";
if(strDay == "8") strDay="08";
if(strDay == "9") strDay="09";

document.getElementById('date_of_birth').value=strDay+"/"+strMonth2+"/"+strYear2;

}
}


function leapyear(a) {
if(((a % 4 == 0) && (a % 100 != 0)) || (a % 400 == 0))
return true;
else
return false;
}

function checkMonth(Obj)
{
if( Obj.value  > 11) { //alert('APP-MP0069 Months cannot be greater than 11'); 
alert(getMessage("MONTHS_CHECK","Common"));
Obj.focus(); 
document.getElementById('date_of_birth').value='';
}
else{
calci(Obj);
}

}

function checkDays(Obj)
{
if( Obj.value  > 31) { //alert('APP-MP0073 Days cannot be greater than 31'); 
alert(getMessage("DAYS_CHECK","Common"));
Obj.focus();
document.getElementById('date_of_birth').value='';
return false;

}else{
	calci(Obj);
}
}

