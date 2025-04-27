/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function callsubmit(term_code,term_set_id,accur_code_ind,curr_accuracy_code,sex,occur_srl_no,eid)
{
	var curr_enc = window.confirm('Do You Want update Previous encounter diagnosis to Currrent Encounter..');
	
	if(curr_enc)
	{
		parent.NewProcedure.document.RecDaignosis_form.accry_code_ind.value=accur_code_ind;
		parent.NewProcedure.document.RecDaignosis_form.accry_code.value=curr_accuracy_code;
		parent.NewProcedure.document.RecDaignosis_form.code_set.value=term_set_id;
		parent.NewProcedure.document.RecDaignosis_form.diagprob_code.value=term_code;
		parent.NewProcedure.document.RecDaignosis_form.occur_srl_no_hid.value=occur_srl_no;
		parent.NewProcedure.document.RecDaignosis_form.Encounter_Id.value=eid;
		parent.NewProcedure.document.RecDaignosis_form.mode.value='modify_curr_enc';
		//parent.NewProcedure.document.RecDaignosis_form.action="../../servlet/eMR.RecDiagnosisServlet";
		parent.NewProcedure.document.RecDaignosis_form.action="";
		parent.NewProcedure.document.RecDaignosis_form.submit();
	}
}

function Record()
{
	var  retVal=parent.NewProcBtn.document.RecDiagAddModifyForm.as_evidenced_by.value;
	parent.NewProcedure.document.RecDaignosis_form.as_evidenced_by_hid.value = retVal;
	checkrecord();
}

/* Valdiating for Mandatory field...by Ashok Raja modified date on 1/28/2005*/
function checkrecord()
{
	if(parent.NewProcedure.document.RecDaignosis_form.mode.value =='modify')
	{
		if(parent.NewProcedure.document.RecDaignosis_form.status.disabled==true)
		{
			parent.NewProcedure.document.RecDaignosis_form.status.disabled=false;
			if(parent.NewProcedure.document.RecDaignosis_form.status.value !='A')
			{
				alert(geteMRMessage("MR_DIAG_CURR_ACTIVE"));
				parent.NewProcedure.document.RecDaignosis_form.status.disabled=true;
				return false;
			}
		}
		
	}
	var p = parent.NewProcedure.document.RecDaignosis_form.diagprob_code.value;
	parent.NewProcedure.document.RecDaignosis_form.diagprob_code.value=p;

	var fields=new Array();
	var names = new Array();
	var p = 0;
		
	fields[p] = parent.NewProcedure.document.RecDaignosis_form.diagprob_code;
	names[p] = "Diagnosis/Problem Code";
	p++;
	fields[p] = parent.NewProcedure.document.RecDaignosis_form.accuracy;
	names[p] = "Accuracy";
	p++;
	if(parent.NewProcedure.document.RecDaignosis_form.nature_appl_yn.value=='Y')
	{
		fields[p]= parent.NewProcedure.document.RecDaignosis_form.nature;
		names[p] = "Nature";
		p++;
	}
	if(parent.NewProcedure.document.RecDaignosis_form.priority_appl_yn.value=='Y')
	{
		fields[p]= parent.NewProcedure.document.RecDaignosis_form.priority;
		names[p] = "priority";
		p++;
	}
	if(parent.NewProcedure.document.RecDaignosis_form.severity_appl_yn.value=='Y')
	{
		fields[p]= parent.NewProcedure.document.RecDaignosis_form.severity;
		names[p] = "Severity";
		p++;
	}
	if(parent.NewProcedure.document.RecDaignosis_form.type.value=='' && parent.NewProcedure.document.RecDaignosis_form.onset_type_appl_yn.value=='Y')
	{
		fields[p]= parent.NewProcedure.document.RecDaignosis_form.type;
		names[p] = "Onset Type";
		p++;
	}
	
	if(parent.NewProcedure.document.RecDaignosis_form.status.value=='E')
	{
		fields[p]= parent.NewProcedure.document.RecDaignosis_form.remarks;
		names[p] = "Remarks";
		p++;
	}
	
	if(parent.NewProcedure.checkFieldsofMst( fields, names, parent.frames[6])) 
	{
		var errors="";
		for (var i=0 ; i<fields.length ; i++)
		{
			if (trimCheck(fields[i].value))
			{
				fields[i].value=trimString(fields[i].value);
			}
			else
				errors =errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
		}
		if (errors.length !=0)
		{
			top.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
			return false ;
		}
		parent.NewProcedure.document.RecDaignosis_form.code_set.disabled=false;
		
		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value != "modify")
			parent.NewProcedure.document.RecDaignosis_form.status.disabled=false;

		parent.NewProcedure.document.RecDaignosis_form.action="../../servlet/eMR.RecDiagnosisServlet";
		//alert(parent.NewProcedure.document.RecDaignosis_form.Encounter_Id.value);
		parent.NewProcedure.document.RecDaignosis_form.submit();
		parent.NewProcedure.document.RecDaignosis_form.status.disabled=true;
		parent.NewProcedure.document.RecDaignosis_form.as_evidenced_by_hid.value='';
	}
}

function Cancel()
{
	if(parent.NewProcedure.document.RecDaignosis_form.modal_yn.value =='Y')
	{
		parent.window.close();
	}
	else
	{
		top.content.workAreaFrame.RecDiagnosisMain.RecDiagnosisCurrentDiag.location.href ='../../eCommon/html/blank.html';
		top.content.workAreaFrame.RecDiagnosisMain.RecDiagnosisCurrentDiagLegend.location.href ='../../eCommon/html/blank.html';
		top.content.workAreaFrame.RecDiagnosisMain.RecDiagnosisAddModify.location.href ='../../eCommon/html/blank.html';
		top.content.workAreaFrame.RecDiagnosisMain.RecDiagnosisOpernToolbar.location.href ='../../eCommon/html/blank.html';
		top.content.workAreaFrame.RecDiagnosisMain.messageFrame.location.href ='../../eCommon/html/blank.html';
		top.content.workAreaFrame.RecDiagnosisMain.location.href='../../eCommon/html/blank.html';
		top.content.workAreaFrame.RecDiagnosisFrame.location.href='../../eCommon/html/blank.html';
	}
}

function Image_Enable()
{	
	
		var status_value=parent.NewProcedure.document.RecDaignosis_form.status.value;
		if(status_value =='E' )
		parent.RecDiagnosisAddModify.document.getElementById("remk_image").style.visibility = "Visible";
		else
		parent.RecDiagnosisAddModify.document.getElementById("remk_image").style.visibility ='hidden';
}

function CheckDate(Object2,focusflag) 
{
    var datefield = Object2;
    if (ChkDate(Object2) == false) 
	{
		alert("APP-SM0011 - Invalid Date Format");
		if(focusflag == null)
		{
		datefield.select();
		datefield.focus();
		}
		return false;
	}
	else 
	{
		return true;
	}
}

function CheckForNumber_L(Objval,obj1) 
{
	val = Objval.value;
	if ( trimCheck(val) && isNaN(val) == false && val >=0)
  	return true;
	else
	{
		if ( val.length > 0 ) 
		{
			if(obj1.name=="onset_date")
			document.forms[0].onset_date.value='';
			else if(obj1.name=="close")
			document.forms[0].close.value='';
			alert("APP-SM0046 - Only number is allowed");
			Objval.select();
			Objval.focus();
			return false;
		}
	}
}

function checkMonth(Obj,obj1)
{
	if( Obj.value  > 11) 
	{ 
		alert('APP-MP0069 Months cannot be greater than 11'); 
		Obj.focus(); 
		if (obj1.name=="onset_date")
		{
			document.forms[0].onset_date.value='';
		}
		else if(obj1.name=="close")
		document.forms[0].close.value='';
	}
}

function checkDays(Obj,obj1)
{
	if( Obj.value  > 31) 
	{ 
		alert('APP-MP0073 Days cannot be greater than 31'); 
		Obj.focus(); 
		if (obj1.name=="onset_date")
				document.forms[0].onset_date.value=''; 
		else if(obj1.name=="close")
				document.forms[0].close.value=''; 
	}
}

function calci(Obj)
{
	var hide= document.forms[0].onset_date1.value;
	strDateArray = hide.split("/");
	if (strDateArray.length != 3) ;
	else 
	{
		strDay = strDateArray[0];
		strMonth = strDateArray[1];
		strYear = strDateArray[2];
	}
	if(Obj.name == 'b_age' || Obj.value >0)
	{
		var yy=document.forms[0].b_age.value;
		days = new Date();
		gdate = days.getDate();
		gmonth = days.getMonth();
		gyear = days.getFullYear();
		age = strYear - yy;
		
		document.forms[0].onset_date.value=strDay+"/"+strMonth+"/"+age;
		document.forms[0].text5.value=document.forms[0].onset_date.value;
	}
	
	if(Obj.name == 'b_months' || (document.forms[0].b_months.value >0 && document.forms[0].b_months.value <12))
	{
	if(document.forms[0].text5.value == '') 	document.forms[0].text5.value=document.forms[0].onset_date.value;
	var hide1= document.forms[0].text5.value;
	var mm=document.forms[0].b_months.value;
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

	if(strMonth1 == "1") strMonth1="01";
	if(strMonth1 == "2") strMonth1="02";
	if(strMonth1 == "3") strMonth1="03";
	if(strMonth1 == "4") strMonth1="04";
	if(strMonth1 == "5") strMonth1="05";
	if(strMonth1 == "6") strMonth1="06";
	if(strMonth1 == "7") strMonth1="07";
	if(strMonth1 == "8") strMonth1="08";
	if(strMonth1 == "9") strMonth1="09";

	if(strDay == "1") strDay="01";
	if(strDay == "2") strDay="02";
	if(strDay == "3") strDay="03";
	if(strDay == "4") strDay="04";
	if(strDay == "5") strDay="05";
	if(strDay == "6") strDay="06";
	if(strDay == "7") strDay="07";
	if(strDay == "8") strDay="08";
	if(strDay == "9") strDay="09";

	document.forms[0].onset_date.value=strDay+"/"+strMonth1+"/"+strYear1;
	document.forms[0].text6.value=document.forms[0].onset_date.value;
	}
	if(Obj.name == 'b_days' || (document.forms[0].b_days.value >0 && document.forms[0].b_days.value <32))
	{
	if(document.forms[0].text6.value == '')  document.forms[0].text6.value=document.forms[0].onset_date.value;
	var hide2= document.forms[0].text6.value;
	var dd=document.forms[0].b_days.value;
	strDateArray2 = hide2.split("/");

	strDay2 = strDateArray2[0];
	strMonth2= strDateArray2[1];
	strYear2 = strDateArray2[2];
	strDay=strDay2-dd;

	if(strDay <=0)
	{
		strMonth2=strMonth2-1;
		if(strMonth2 == 2)
		{
			if(leapyear(strYear2))
			{
				strDay=29+strDay+2;
			}
			else
			{	
				strDay=28+strDay;
			}
		}
		else if((strMonth2 == 4) || (strMonth2 == 6) || (strMonth2 == 9) || (strMonth2 == 11))
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

	if(strDay == "1") strDay="01";
	if(strDay == "2") strDay="02";
	if(strDay == "3") strDay="03";
	if(strDay == "4") strDay="04";
	if(strDay == "5") strDay="05";
	if(strDay == "6") strDay="06";
	if(strDay == "7") strDay="07";
	if(strDay == "8") strDay="08";
	if(strDay == "9") strDay="09";

	document.forms[0].onset_date.value=strDay+"/"+strMonth2+"/"+strYear2;
	}
}

function calcage(obj1,obj2) 
{
	if(doDateCheckAlert(obj1,obj2))
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
		    var datecal2=obj2.value;
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
	
			if(	document.forms[0].b_age!=null)
			{
				document.forms[0].b_age.value= ageYears ;
				if(document.forms[0].b_age.value.length == 1  && document.forms[0].b_age.value !='0') document.forms[0].b_age.value="0"+ageYears ;
						document.forms[0].b_months.value=ageMonths;
				if(document.forms[0].b_months.value.length == 1 && document.forms[0].b_months.value !='0') document.forms[0].b_months.value="0"+ageMonths;
					document.forms[0].b_days.value=ageDays;
				if(document.forms[0].b_days.value.length == 1 && document.forms[0].b_days.value !='0') document.forms[0].b_days.value="0"+ageDays;
			}
			else
			{
				document.forms[0].b_age1.value= ageYears ;
				if(document.forms[0].b_age1.value.length == 1  && document.forms[0].b_age1.value !='0') document.forms[0].b_age1.value="0"+ageYears ;
					document.forms[0].b_months1.value=ageMonths;
				if(document.forms[0].b_months1.value.length == 1 && document.forms[0].b_months1.value !='0') document.forms[0].b_months1.value="0"+ageMonths;
					document.forms[0].b_days1.value=ageDays;
				if(document.forms[0].b_days1.value.length == 1 && document.forms[0].b_days1.value !='0') document.forms[0].b_days1.value="0"+ageDays;
			}
			}
		}
	}
}

function DateCheck(from,to) 
{
   	var fromarray;
	var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) 
	{
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt   = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) > Date.parse(fromdt)) 
		{
			var invaldt=getMessage("INVALID_ONSET_DATE");
			alert(invaldt);
			document.forms[0].onset_date.value=parent.NewProcedure.document.RecDaignosis_form.onset_date_temp.value;
			document.forms[0].onset_date.focus();

		}
		else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
	}
return true;
}

function validate_date1(from,to) 
{
	var fromarray;
	var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) 
	{
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) > Date.parse(fromdt)) 
			{
			alert("APP-CA0003 Status Date should be between Onset Date and Current Date");
			document.forms[0].status_date.value=parent.NewProcedure.document.RecDaignosis_form.status_date_temp.value;
			document.forms[0].status_date.focus();
			}
			else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
	}
	return true;
}

function clearform()
{
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value == "modify")
	{
		var Practitioner_Id = parent.NewProcedure.document.RecDaignosis_form.Practitioner_Id.value;
		var relationship_id= parent.NewProcedure.document.RecDaignosis_form.relationship_id.value;
		var Locn_Code = parent.NewProcedure.document.RecDaignosis_form.Locn_Code.value;
		var Locn_Type = parent.NewProcedure.document.RecDaignosis_form.Locn_Type.value;
		var Patient_Id = parent.NewProcedure.document.RecDaignosis_form.Patient_Id.value;
		var patient_class = parent.NewProcedure.document.RecDaignosis_form.patient_class.value;
		var Encounter_Id = parent.NewProcedure.document.RecDaignosis_form.Encounter_Id.value;
		var dob= parent.NewProcedure.document.RecDaignosis_form.dob.value;
		var sex = parent.NewProcedure.document.RecDaignosis_form.sex.value;
		var age = parent.NewProcedure.document.RecDaignosis_form.age.value;
		var modal_yn = parent.NewProcedure.document.RecDaignosis_form.modal_yn.value;

		parent.RecDiagnosisAddModify.location.href ="../../eMR/jsp/RecDiagnosisAddModify.jsp?Practitioner_Id="+Practitioner_Id+"&relationship_id="+relationship_id+"&Locn_Code="+Locn_Code+"&Locn_Type="+Locn_Type+"&Patient_Id="+Patient_Id+"&patient_class="+patient_class+"&Encounter_Id="+Encounter_Id+"&Dob="+dob+"&Age="+age+"&Sex="+sex+"&modal_yn="+modal_yn;
	}	
	else
	{
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.reset();
	}
parent.RecDiagnosisOpernToolbar.document.getElementById("notice_anchor").innerText="";
parent.NewProcedure.document.getElementById("evidence_anchor").innerText = "";
}

function ChkNumberInput(fld, e, deci)
{
	if (parseInt(deci)>0)
	   var strCheck = '.0123456789 /:';
	else
	   var strCheck = '0123456789 /:';

	   var whichCode = (window.Event) ? e.which : e.keyCode;
		if (whichCode == 13) return true;  // Enter
		key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

function leapyear(a) {
	if(((a % 4 == 0) && (a % 100 != 0)) || (a % 400 == 0))
		return true;
	else
		return false;
}

function checkforOK(obj)
{
	if(obj.checked == true)
	{
		//alert(parent.frames[2].document.forms[0].OK);
		if(top.frames[2].document.forms[0].OK.disabled == true)
		{
			top.frames[2].document.forms[0].OK.disabled = false;
		}
	}
}
