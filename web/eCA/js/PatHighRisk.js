/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
15/11/2013 IN044619		vijayakumark	Alpha>CA>Pt Chart>Pt Profile>Print - Script Error occurs
----------------------------------------------------------------------------------------------------
*/
function apply()
{  
	//CHL-CRF Start.[IN035950]
	var path="";
	if(null!=top.content && null!=top.content.workAreaFrame){
		path="top.content.workAreaFrame.frame2."
	}
	
	if(eval(path+"document.highrisk_form.remarks.value").length > 200)
	{
		var error = getMessage("OBJ_CANNOT_EXCEED","Common");
		error = error.replace("$","200");
		alert(error);
		return false;
	}
	var fields=new Array();
	var names=new Array();
	if (eval(path+"document.highrisk_form.function_name.value") == "insert")
	{
		fields[0]= eval(path+"document.highrisk_form.high_risk_code").options[eval(path+"document.highrisk_form.high_risk_code").options.selectedIndex]
		fields[1]= eval(path+"document.highrisk_form.onset");
		names = new Array (   getLabel("Common.HighRiskConditions.label","COMMON"),getLabel("Common.onsetdate.label","COMMON"));

		document.highrisk_form.onset_date.value = document.highrisk_form.onset.value;
	}
	var callFromWidget = eval(path+"document.highrisk_form.p_called_from_widget.value");	
	var messageFrame = "";
	if(callFromWidget!=""){
		messageFrame = parent.messageFrame;
	}else{
		messageFrame = top.content.messageFrame
	}
	if(eval(path+"checkFields( fields, names, messageFrame)"))
	{
		if (eval(path+"document.highrisk_form.function_name.value") == "insert")
		{
			if(eval(path+"document.highrisk_form.onset") != null)
				{
					var  onsetarr =  new Array ( eval(path+"document.highrisk_form.onset_date"),eval(path+"document.highrisk_form.onset"));
				}
		}		
		else if (eval(path+"document.highrisk_form.function_name.value") == "modify")
		{
				document.highrisk_form.close_date.value = document.highrisk_form.close.value;
				if(eval(path+"document.highrisk_form.close") != null)
				{
					var  onsetarr =  new Array ( eval(path+"document.highrisk_form.onset_date"),eval(path+"document.highrisk_form.onset"));
					var closearr = new Array ( eval(path+"document.highrisk_form.close_date"),eval(path+"document.highrisk_form.close"));
				}
				clearform();
		}
		
		// added by marwan-EDGE work, since openning the date picker clears the action, target fields of the form
		if(document.getElementById('formAction').value !== ''){
			eval(path+"highrisk_form.action = document.getElementById('formAction').value");			
		}
		eval(path+"highrisk_form.target = 'messageFrame'");
		eval(path+"highrisk_form.submit()");
	}
	
	/*if(top.content.workAreaFrame.frame2.document.highrisk_form.remarks.value.length > 200)
	{
		var error = getMessage("OBJ_CANNOT_EXCEED","Common");
		error = error.replace("$","200");
		alert(error);
		return false;
	}

	var fields=new Array();
	var names=new Array();

	if (top.content.workAreaFrame.frame2.document.highrisk_form.function_name.value == "insert")
	{
		fields[0]= top.content.workAreaFrame.frame2.document.highrisk_form.high_risk_code.options[top.content.workAreaFrame.frame2.document.highrisk_form.high_risk_code.options.selectedIndex]
		fields[1]= top.content.workAreaFrame.frame2.document.highrisk_form.onset;
		names = new Array (   getLabel("Common.HighRiskConditions.label","COMMON"),					getLabel("Common.onsetdate.label","COMMON")
													);

		document.highrisk_form.onset_date.value = document.highrisk_form.onset.value;
	}

	if(top.content.workAreaFrame.frame2.checkFields( fields, names, top.content.messageFrame))
	{
		if (top.content.workAreaFrame.frame2.document.highrisk_form.function_name.value == "insert")
		{
			if(top.content.workAreaFrame.frame2.document.highrisk_form.onset != null)
				{
					var  onsetarr =  new Array ( top.content.workAreaFrame.frame2.document.highrisk_form.onset_date,
																	top.content.workAreaFrame.frame2.document.highrisk_form.onset);

//					Date_Transform(onsetarr,top.content.messageFrame);
				}
		}
		
		else if (top.content.workAreaFrame.frame2.document.highrisk_form.function_name.value == "modify")
		{
				document.highrisk_form.close_date.value = document.highrisk_form.close.value;
				if(top.content.workAreaFrame.frame2.document.highrisk_form.close != null)
				{
					var  onsetarr =  new Array ( top.content.workAreaFrame.frame2.document.highrisk_form.onset_date,
																				top.content.workAreaFrame.frame2.document.highrisk_form.onset);
//					Date_Transform(onsetarr,top.content.messageFrame);

					var closearr = new Array ( top.content.workAreaFrame.frame2.document.highrisk_form.close_date,
																				top.content.workAreaFrame.frame2.document.highrisk_form.close);
//					Date_Transform(closearr,top.content.messageFrame);

				}
				clearform();
		}
		
		top.content.workAreaFrame.frame2.highrisk_form.submit();
	} */
	//CHL-CRF End.[IN035950]
} 

function clearform(){
	//CHL-CRF Start.[IN035950]
	var path="";
	if(null!=top.content && null!=top.content.workAreaFrame){
		path="top.content.workAreaFrame.frame2."
	}
	var p_called_from_widget 	= eval(path+"document.highrisk_form.p_called_from_widget.value");
	if(eval(path+"document.highrisk_form.function_name.value") == "modify")
	{
				var P_Encounter_Id 			= eval(path+"document.highrisk_form.Encounter_Id.value");
				var P_Practitioner_Id 		= eval(path+"document.highrisk_form.Practitioner_Id.value");
				var P_Clinic_Code 			= eval(path+"document.highrisk_form.Clinic_Code.value");
				var P_Patient_Id 			= eval(path+"document.highrisk_form.Patient_Id.value");
				var P_Location_Type 		= eval(path+"document.highrisk_form.Location_Type.value");
				
				if(p_called_from_widget!=""){
					parent.frame2.location.href ='../../eCA/jsp/addModifyPatHighRisk.jsp?Encounter_Id='+P_Encounter_Id+'&Practitioner_Id='+P_Practitioner_Id+'&Clinic_Code='+P_Clinic_Code+'&Patient_Id='+P_Patient_Id+'&Location_Type='+P_Location_Type+'&p_called_from_widget='+p_called_from_widget;
				}else{
					top.content.workAreaFrame.frame2.location.href ='../../eCA/jsp/addModifyPatHighRisk.jsp?Encounter_Id='+P_Encounter_Id+'&Practitioner_Id='+P_Practitioner_Id+'&Clinic_Code='+P_Clinic_Code+'&Patient_Id='+P_Patient_Id+'&Location_Type='+P_Location_Type+'&p_called_from_widget='+p_called_from_widget;
				}
	}
	else
	{
				eval(path+"document.highrisk_form.reset()");
	}
	if(p_called_from_widget!=""){
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	}else{
		top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	}
	/*
		if(top.content.workAreaFrame.frame2.document.highrisk_form.function_name.value == "modify")
		{
					var P_Encounter_Id = top.content.workAreaFrame.frame2.document.highrisk_form.Encounter_Id.value;
					var P_Practitioner_Id = top.content.workAreaFrame.frame2.document.highrisk_form.Practitioner_Id.value;
					var P_Clinic_Code = top.content.workAreaFrame.frame2.document.highrisk_form.Clinic_Code.value;
					var P_Patient_Id = top.content.workAreaFrame.frame2.document.highrisk_form.Patient_Id.value;
					var P_Location_Type = top.content.workAreaFrame.frame2.document.highrisk_form.Location_Type.value;

					top.content.workAreaFrame.frame2.location.href ='../../eCA/jsp/addModifyPatHighRisk.jsp?Encounter_Id='+P_Encounter_Id+'&Practitioner_Id='+P_Practitioner_Id+'&Clinic_Code='+P_Clinic_Code+'&Patient_Id='+P_Patient_Id+'&Location_Type='+P_Location_Type
		}
		else
		{
					top.content.workAreaFrame.frame2.document.highrisk_form.reset() ;
		}
		top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	*/
	//CHL-CRF End.[IN035950]
}

function cancel1(){
	//top.content.workAreaFrame.tools.location.href = '../../eCommon/html/blank.html' ;
	top.content.workAreaFrame.frame2.location.href = '../../eCommon/html/blank.html' ;
	top.content.workAreaFrame.frame1.location.href = '../../eCommon/html/blank.html' ;
	top.content.workAreaFrame.title.location.href ='../../eCommon/html/blank.html' ;
	
//	parent.parent.parent.frames[5].location.href='../../eCommon/jsp/error.jsp';
	top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp';
		
}
function checkFields( fields, names, messageFrame) {
//	alert('fields.length'+fields.length);
//	alert('names.length'+names.length);
	if(fields.length >0 && names.length > 0)
	{
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else	
		{
			errors =getMessage("SHOULD_NOT_BE_BLANK","Common") + "<br>";
			errors=errors.replace('{1}', names[i]);
			//errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
		}
	}
	if ( errors.length != 0 ) {
		messageFrame.document.location.href="../../eCA/jsp/error1.jsp?err_num="+errors ;
		return false ;
	}
	}
	return true ;

}

function Date_Transform (transform,messageFrame) {
	
		dateset = transform[0];
		dateset1 = transform[1];
		//alert(dateset.value);
		if(dateset1.value=="") {
			dateset.value="";
		}
		else {
			//alert('in else');
			var tst=dateset1.value;
			var arr = new Array();
			arr = tst.split("/");
			var strDay = arr[0];
			var strMonth = arr[1];
			var strYear = arr[2];
			var dt= strYear + "-" + strMonth + "-" + strDay;
			dateset.value= dt;
			//alert('in else 2');
		}

	}
function onsuccess(){
	//alert("success");	
	top.frames[4].frames[1].frames[0].location.href ="../../eCA/jsp/PatHighRiskQueryResult.jsp";

}

function showCalendarValidate(str){
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}

// Following function are included by Suresh Babu .C on 14/01/04

function CheckForNumber_L(Objval,obj1) 
{
  	//if(obj1.value == '')
	//{
	//	obj1.value = document.forms[0].closedate.value; 
	//}

	val = Objval.value;
	if ( trimCheck(val) && isNaN(val) == false && val >=0)
  		return true;
	else
	{

		if ( val.length > 0 ) {
			if(obj1.name=="onset")
	  			document.forms[0].onset.value='';
			else if(obj1.name=="close")
				document.forms[0].close.value='';
  			alert(getMessage("ONLY_NUMBER_ALLOWED","CA"));
			Objval.select();
  			Objval.focus();
  			return false;
  			
  		}
	}
	
}

function checkMonth(Obj,obj1)
{
	if( Obj.value  > 11) { 
		alert(getMessage("MONTHS_CHECK","Common"));

		//Obj.focus(); 
		Obj.value = '0' ;

		if (obj1.name=="onset"){
				document.forms[0].onset.value='';}
		else if(obj1.name=="close")
				document.forms[0].close.value='';
	}
//	document.forms[0].onset.onblur();
}

function checkYear()
{
//	document.forms[0].onset.onblur();
}

function checkDays(Obj,obj1)
{
	if( Obj.value  > 31) 
	{ 
		alert(getMessage("DAYS_CHECK","Common"));
		//Obj.focus(); 
		Obj.value = '0' ;
		if (obj1.name=="onset")
				document.forms[0].onset.value=''; 
		else if(obj1.name=="close")
				document.forms[0].close.value=''; 
	}
//	document.forms[0].onset.onblur();
}


function calcage(obj1,obj2) 
{
	if(obj1.value != '' || obj2.value != '' )
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
					else 
					{
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
					else 
					{
						strDay1 = strDateArray1[0];
						strMonth1 = strDateArray1[1];
						strYear1 = strDateArray1[2];
					}

					testDate = new Date(strMonth1+'/'+strDay1+'/'+strYear1);
					mm2 = testDate.getMonth()+1 ;
					dd2 = testDate.getDate();
					yy2 = testDate.getFullYear();
			
					if (yy < 100 && yy > 20) 
					{
						yy = yy + 1900
			        }
					if (yy2 < 100)
					{
						if (yy2 > 20) 
						{
							yy2 = yy2 + 1900
				        }
						else
						{
							yy2 = yy2 + 2000
				        }
				    }
			
					ageYears = yy2 - yy

				    if(mm2 == mm)
					{
						if(dd2 < dd)
						{
							mm2 = mm2 + 12;
							ageYears = ageYears - 1;
						}
				    }

				    if(mm2 < mm)
					{
						mm2 = mm2 + 12;
						ageYears = ageYears - 1;
						ageMonths = mm2 - mm;
					}

					ageMonths = mm2 - mm;

				    if (dd2 < dd) 
					{
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
						if (mm2 == mm) 
						{
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
}



////////////////////////////////////////////////////////////////////////////////////////////////////




function leapyear(a) {
if(((a % 4 == 0) && (a % 100 != 0)) || (a % 400 == 0))
return true;
else
return false;
}



//functions for the file name AddDaggerCodeAddModify.jsp-start

function Checkdiagcode(obj)
{
	var convals = document.form1.convals.value;  
	if(obj.checked)
	{
		if(convals != "")
			convals += "|";
		var obj_temp = obj.name.split("~");
		convals += obj_temp[0].replace('+','%2B') + "~" + obj_temp[1];
		document.form1.convals.value = convals;
	}
	else
	{
		var diag_code = obj.name.split("~");
		var delconvals = "";
		var del_code = unescape(diag_code[0]);
		var convals1 = unescape(document.form1.convals.value);
		var convals_array = convals1.split('|');		
		if(convals_array.length > 0)
		{
			for(i=0;i<convals_array.length;i++)
			{				
				var temp_conval = convals_array[i].split('|');
				for(j=0;j<temp_conval.length;j++)
				{
					var temp_conval_code = temp_conval[j].split('~');
					if(temp_conval_code[0] != del_code)
					{
						if(delconvals != '')
							delconvals += "|";
						delconvals += (temp_conval[j].replace('+', '%2B'));
					}
				}
			}
		}
		document.form1.convals.value = delconvals;
	}
}


//functions for the file name AddDaggerCodeAddModify.jsp-end

//functions for the file name GroupHeading.jsp-end
var prevClassName = "";
var prevRowObject = "";
function changeRowColor(obj, changeClassName)
{
	if( changeClassName==null )	changeClassName = "ITEMSELECT";
	if(	prevClassName != "" )
		for(i=0; i<prevRowObject.cells.length; i++)
			if(prevRowObject.cells(i).className==changeClassName)
				prevRowObject.cells(i).className = prevClassName;

	prevRowObject	=	obj;
	prevClassName	=	obj.cells(0).className;

    for(i=0; i<obj.cells.length; i++)
		if(obj.cells(i).className=="QRYODD" || obj.cells(i).className == "QRYEVEN" ||  obj.cells(i).className == "" )
			obj.cells(i).className = changeClassName;
}

//functions for the file name GroupHeading.jsp-end



//Functions for the file name CAAssThirdScreen.jsp & CAAssFourthScreen.jsp-start


var prev=0
function  change_row_color(obj)
{
		document.getElementById("t").rows(prev).cells(0).style.backgroundColor=obj.bgColor
		obj.cells(0).style.backgroundColor="#B2B6D7"
		prev	=obj.rowIndex
}
function closewin(code,desc)
{
	parent.parent.frames[1].document.forms[0].elements(1).disabled=false
	while(desc.indexOf(";")!=-1)
		desc=desc.replace(";" ,' ')
	parent.parent.frames[1].document.forms[0].elements(0).value=desc+", "+code
	parent.parent.frames[1].document.forms[0].elements(2).value=code
}
/*function loadOtherFrames(scheme,code,desc)
{
	parent.parent.frames[1].document.forms[0].elements(1).disabled=false
	while(desc.indexOf(";")!=-1)
		desc=desc.replace(";" ,' ')
	parent.parent.frames[1].document.forms[0].elements(0).value=desc//+", "+code
	parent.parent.frames[1].document.forms[0].elements(2).value=code
	
	parent.frames[3].location.href='../../eCA/jsp/CAAssFourthScreen.jsp?p_auth_yn=<%=auth%>&Scheme='+scheme+'&Search_Code='+code+'&cause_indicator=<%=cause_indicator%>'
	//parent.parent.frames[1].document.forms[0].elements(1).disabled=true
}*/

//Functions for the file name CAAssThirdScreen.jsp & CAAssFourthScreen.jsp-end

//Functions for the file name addModifyPatHighRisk.jsp-start
/*function check(obj)
{
	if(obj.value.length!="")
	{
		if(CheckDate(obj))
		{
			if(validate_date1(document.forms[0].close,document.forms[0].onset))
				validate_date1(document.forms[0].sys_date,document.forms[0].close)
		}
	}
}*/

/*
function validate_date(from,to) {
	var fromarray;
	var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	var dob = document.forms[0].dob.value;
	if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);
			if(Date.parse(todt) > Date.parse(fromdt)) {
//				var invaldt = parent.parent.parent.parent.parent.frames[0].getMessage("INVALID_ONSET_DATE") ;
				var invaldt = getMessage("INVALID_ONSET_DATE","CA") ;
				alert(invaldt);
				to.select();
				//to.value='';
				to.focus();
			}
			else if(Date.parse(todt) <= Date.parse(fromdt)) return true;

			if( Date.parse(dob) < Date.parse(fromdate) )
			{	
					alert(getMessage("FROM_DATE_MORE_BIRTH","CA"));
					return false;
			}
	}
	
	return true;
}

function validate_date1(from,to) {
	var fromarray;
	var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	var dob = document.forms[0].dob.value;
	if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);
			
			if(Date.parse(todt) > Date.parse(fromdt)) 
			{
				var invaldt = getMessage("INVALID_CLOSE_DATE","CA") ;
				alert(invaldt);
				if(from.value=="onset")
					to.value='';
				else
					from.value='';
				//to.focus();
			}
			else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
	}
	return true;
}

function validate_onsetdate(obj)
{
	var fromdate=document.forms[0].dob.value;
	var todate=document.forms[0].onset.value;

	if(fromdate.length > 0 && todate.length > 0 ) 
	{
		fromarray = fromdate.split("/");
		toarray = todate.split("/");

		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);

		if(Date.parse(todt) < Date.parse(fromdt)) 
		{
			var invaldt = getMessage("LESS_THAN_BDAY_DATE","CA") ;
			alert(invaldt);
			document.forms[0].onset.value='';
			document.forms[0].onset.focus();
		}
			else if(Date.parse(todt) >= Date.parse(fromdt)) 
			return true;
	}

}

*/

//Functions for the file name addModifyPatHighRisk.jsp-end


//Functions for the file name PatientProfiletree.jsp-starts  added by Jupitora

function funOver(a)
	{

		a.style.background="gray";
	}

	function funOut(a)
	{
		a.style.background="#E2E3F0";
	}
	function show()
	{
		var patient_profile = document.forms[0].patient_profile.value;
		document.forms[0].submit();
	}
	function showLink(cnt,patient_id,obj)
	{
		if(obj!=null)
		{
			var objName = 'chk'+cnt;
			var val = document.forms[0];
			//val = eval(document.forms[0].chk+cnt);
			val[objName].checked = true;
		
				if(cnt==8)
					callHighRisk(patient_id,val[objName]);
					//callHighRisk(patient_id,eval(document.forms[0].chk+cnt));
		              
			//val.value="Y";
			
			document.forms[0].submit();
			
		}	
	}
	
	function checkAll(patient_id,obj)
	{
		
		var count = document.forms[0].counter.value;
		if(obj.checked)
		{
			for(var i=0;i<count;i++)
			{
				//var counter=eval(document.forms[0].contentId+i+".value");
				var val = document.forms[0];
				var obj = "contentId"+i;
				var counter = val[obj].value;
				var objName = 'chk'+counter;
				val[objName].checked=true;
				//eval(document.forms[0].chk+counter+".checked=true");
				if(counter==8)
				{
					//callHighRisk(patient_id,eval(document.forms[0].chk+counter));
					callHighRisk(patient_id,val[objName]);
				}
			}
		}
		else
		{
			for(var i=0;i<count;i++)
			{
				var val = document.forms[0];
				var obj = "contentId"+i;
				var counter = val[obj].value;
				var objName = 'chk'+counter;
				//var counter=eval(document.forms[0].contentId+i+".value");
				//var objName = 'chk'+counter;
				
				val[objName].checked=false;
				//eval(document.forms[0].chk+counter+".checked=false");
			}
		}
	}
	async function callHighRisk(patient_id,obj)
	{
		
		if(obj.checked)
		{
			var dialogHeight= "9" ;
			var dialogWidth	= "25" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" 
			var arguments   = '';
			
			var url ='../../eCA/jsp/AuthorizeMRAccess.jsp?Patient_Id='+patient_id+'&modal_yn=Y&constr=V/HR/D';
			var retVal=	await window.showModalDialog(url,arguments,features);
			if(retVal =="T"){
				obj.checked = true;			
				//var retVal=	window.showModalDialog('../../eCA/jsp/PatHighRiskQueryResult.jsp?Patient_Id='+patient_id+'&modal_yn=Y',arguments,features);
			}
			else
			{
				obj.checked = false;			
			}
		}
	}

	//Functions for the file name PatientProfiletree.jsp-ends

	function chkpasswd() {
	var p1 = document.Authorize_form.appl_user_passwd.value;
	var p2 = document.Authorize_form.screen_passwd.value;
	var ar = document.Authorize_form.access_rights.value;
	var nr = document.Authorize_form.no_records.value;
	var modal_yn = document.Authorize_form.modal_yn.value;
	p2 = p2.toUpperCase();	
 	if (nr==0 || ar == "N"){
		alert(getMessage("NO_AUTH_SENSITIVE_DIAGNOSIS","CA"));
		if(modal_yn == "Y"){
			top.window.returnValue = "X" ;

			top.window.close();
			//const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		  //  dialogTag.close(); 
		}
	}else if (p1 != p2){
		alert(getMessage("PWD_MISMATCH","CA"));
		if(modal_yn == "Y"){
			top.window.returnValue = "X" ;
			top.window.close();
			//const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		  //  dialogTag.close(); 
		}

	}else{
		top.window.returnValue = "T" ;
		top.window.close();
		//const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	   // dialogTag.close(); 
	}

}

function closeAuthorization(){
	top.window.returnValue = "F";
//	const dialogTag = parent.document.getElementById("dialog_tag");    
 //   dialogTag.close(); 
	top.window.close();
}
	
function FocusFirstElement()
{
	for(i=0;i<document.forms[0].elements.length;i++)
	{

		if(document.forms[0].elements(i).type!="hidden" && document.forms[0].elements(i).type!="button"  )
		{
			if( document.forms[0].elements(i).readOnly!=true && document.forms[0].elements(i).disabled!=true) 
			{
				break;
			}
		}
	}
}

//functions for PatientProfileActionButton.jsp starts
/*function funPrint()
	{
		var obj = parent.fraPatientContent.document.frmPatientContent;
		
		var patient_markers =false;         
		var current_problems = false;
		var current_allergies = false;
		var vital_signs = false;
		var medications = false;
		var current_encounters = false;
		var procedure_performed = false;
		var high_risk = false;
		var referral_diagnosis=false;

		if(obj.chk1!=null)
			patient_markers =obj.chk1.checked;
		if(obj.chk2!=null)
			current_problems = obj.chk2.checked;
		if(obj.chk3!=null)
			current_allergies = obj.chk3.checked;
		if(obj.chk4!=null)
			vital_signs = obj.chk4.checked;
		if(obj.chk5!=null)
			medications = obj.chk5.checked;
		if(obj.chk6!=null)
			current_encounters = obj.chk6.checked;
		if(obj.chk7!=null)
			procedure_performed = obj.chk7.checked;
		if(obj.chk8!=null)
			high_risk = obj.chk8.checked;
		if(obj.chk9!=null)
			referral_diagnosis = obj.chk9.checked;

		var dialogTop	= "60";
		var dialogHeight	= "34" ;
		var dialogWidth	= "50" ;
		var features	="dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;


		//content to embed into the print page
		var css = "<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>";
		var titlemsg = "<font size='4'><p align='center'> <b> Patient Profile </b> </p></font>";
		var header =  "<font size='4'>" +  parent.fraPatientinfo.document.getElementById("printArea").innerHTML + "</font>";
		//alert(header);
		var content="";
		if (patient_markers)
		{
			obj.chk1.style.visibility="hidden";
			content = parent.fraPatientContent.document.getElementById("one").innerHTML;
		}
		
		if (current_problems)
		{
			obj.chk2.style.visibility="hidden";
			content = content + parent.fraPatientContent.document.getElementById("two").innerHTML;
		}

		if (current_allergies)
		{

			obj.chk3.style.visibility="hidden";
			content = content + parent.fraPatientContent.document.getElementById("three").innerHTML;

			//alert("html==="+ parent.fraPatientContent.document.getElementById("three").innerHTML)
		}

		if (vital_signs)
		{
			obj.chk4.style.visibility="hidden";
			content = content + parent.fraPatientContent.document.getElementById("four").innerHTML;
		}

		if(medications)
		{
			obj.chk5.style.visibility="hidden";
			content = content + parent.fraPatientContent.document.getElementById("five").innerHTML;			
		}

		if (current_encounters)
		{
			obj.chk6.style.visibility="hidden";
			content = content + parent.fraPatientContent.document.getElementById("six").innerHTML;			
		}

		if(procedure_performed)
		{
			obj.chk7.style.visibility="hidden";
			content = content + parent.fraPatientContent.document.getElementById("seven").innerHTML;			
		}
		if (high_risk)
		{
			obj.chk8.style.visibility="hidden";
			content = content + parent.fraPatientContent.document.getElementById("eight").innerHTML;			
		}
		if (referral_diagnosis)
		{
			obj.chk9.style.visibility="hidden";
			content = content + parent.fraPatientContent.document.getElementById("nine").innerHTML;			
		}
		//alert(content);
		//content = parent.fraPatientContent.document.getElementById("printArea").innerHTML;
		var printContent = css + titlemsg +  header + content;
		
		if(obj.chk1!=null)
			obj.chk1.style.visibility="visible";
		if(obj.chk2!=null)
			obj.chk2.style.visibility="visible";
		if(obj.chk3!=null)
			obj.chk3.style.visibility="visible";
		if(obj.chk4!=null)
			obj.chk4.style.visibility="visible";
		if(obj.chk5!=null)
			obj.chk5.style.visibility="visible";
		if(obj.chk6!=null)
			obj.chk6.style.visibility="visible";
		if(obj.chk7!=null)
			obj.chk7.style.visibility="visible";
		if(obj.chk8!=null)
			obj.chk8.style.visibility="visible";
		if(obj.chk9!=null)
			obj.chk9.style.visibility="visible";
//alert("printContent"+printContent);
		retVal = window.showModalDialog("../../eCA/jsp/PatientProfilePrint.jsp",printContent,features);
	}*/

	async function funPrint()
	{
		var obj = parent.fraPatientContent.document.all;
		
		var chk1 = "N";
		var chk2 = "N";
		var chk3 = "N";
		var chk4 = "N";
		var chk5 = "N";
		var chk6 = "N";
		var chk7 = "N";
		var chk8 = "N";
		var chk9 = "N";
		var chk10 = "N";//IN044619

		if(obj.chk1 != null && obj.chk1.checked == true)
			chk1 = "Y";
		if(obj.chk2 != null && obj.chk2.checked == true)
			chk2 = "Y";
		if(obj.chk3 != null && obj.chk3.checked == true)
			chk3 = "Y";
		if(obj.chk4 != null && obj.chk4.checked == true)
			chk4 = "Y";
		if(obj.chk5 != null && obj.chk5.checked == true)
			chk5 = "Y";
		if(obj.chk6 != null && obj.chk6.checked == true)
			chk6 = "Y";
		if(obj.chk7 != null && obj.chk7.checked == true)
			chk7 = "Y";
		if(obj.chk8 != null && obj.chk8.checked == true)
			chk8 = "Y";
		if(obj.chk9 != null && obj.chk9.checked == true)
			chk9 = "Y";
		if(obj.chk10 != null && obj.chk10.checked == true)  //IN043676
			chk10 = "Y";									//IN043676
		var header =  parent.fraPatientinfo.document.getElementById("printArea").innerHTML;
		var patient_id = parent.fraPatientTree.document.frm.patient_id.value;
		var encounter_id = parent.fraPatientTree.document.frm.encounter_id.value;
		var dialogTop		= "30";
		var dialogHeight	= "40";
		var dialogWidth		= "100";
		var features		= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
			
		//retVal = window.showModalDialog("../../eCA/jsp/PatientProfilePrint.jsp",printContent,features);
		
		//retVal = window.showModalDialog("../../eCA/jsp/PatientProfilePrint.jsp?chk1="+chk1+"&chk2="+chk2+"&chk3="+chk3+"&chk4="+chk4+"&chk5="+chk5+"&chk6="+chk6+"&chk7="+chk7+"&chk8="+chk8+"&chk9="+chk9+"&encounter_id="+encounter_id+"&patient_id="+patient_id+"&header="+encodeURIComponent(header),features);
		retVal = await window.showModalDialog("../../eCA/jsp/PatientProfilePrint.jsp?chk1="+chk1+"&chk2="+chk2+"&chk3="+chk3+"&chk4="+chk4+"&chk5="+chk5+"&chk6="+chk6+"&chk7="+chk7+"&chk8="+chk8+"&chk9="+chk9+"&chk10="+chk10+"&encounter_id="+encounter_id+"&patient_id="+patient_id+"&header="+encodeURIComponent(header),features); //IN043676
	}

	function funClose()
	{
		parent.close();
	}

	function disallowEnterKey()
	{
		var keyVal = parseInt(event.keyCode);
		if(keyVal == 13)
			return false;
	}


function checkMaxLimitOnBlur(obj,maxSize) 
{
	if ( obj.value.length >= maxSize )
	{
		//alert("Size cannot be more than "+maxSize);
		var error = getMessage("OBJ_CANNOT_EXCEED","Common");
		error = error.replace("$","200");
		alert(error);
		return false;
	}
}

function isVaidwithSysDate(obj, format,locale)
{
  if (obj.value!=null && obj.value != "")
  {
	if(isBeforeNow(obj.value, format,locale))
			return true;
	else
	{
		if( obj.name == "onset")
		{	
			alert(getMessage("INVALID_ONSET_DATE","CA"));
			obj.value = document.forms[0].sys_date.value;
			return false;
		}
	}
  }
}

function isBetweenCurrDate(onset,currDate,close,format,locale)
{
  if (close.value!=null && close.value != "")
  {
	if(isBetween(onset,currDate,close.value,format,locale))
		return true;
	else
	{
		alert(getMessage("INVALID_CLOSE_DATE","CA"));
		close.value = currDate;
		
		return false;

	}
  }
  else   if (close.value==null)
	{
	  return false;
	}
}

function isBetweenDate(onset,currDate,close,format,locale)
{
  if (close!=null && close != "")
  {
	if(isBetween(onset,currDate,close,format,locale))
		return true;
	else
	{
		alert(getMessage("INVALID_CLOSE_DATE","CA"));
		return false;
	}
  }
  else   if (close==null)
	{
	  return false;
	}
}


/*function calci(Obj,format,locale,dateObj)
{
	
	var dob			= document.forms[0].dob.value;
	var sysDate		= document.forms[0].sys_date.value;

	var currDate = document.forms[0].ServerDate.value;

	if(dateObj.value == null || dateObj.value == "")
		dateObj.value = currDate;

	var intervalY='Y',intervalM='M',intervalD='d';

	if(Obj.name == 'b_age' && Obj.value >0)
		dateObj.value = minusDate(dateObj.value, format, locale, Obj.value, intervalY);

	if(Obj.name == 'b_months' && (Obj.value >0 && Obj.value <12))
		dateObj.value = minusDate(dateObj.value, format, locale, Obj.value, intervalM);

	if(Obj.name == 'b_days' && (Obj.value >0 && Obj.value <32))
		dateObj.value = minusDate(dateObj.value, format, locale, Obj.value, intervalD);

	if(dob.value!= null && dob != "")
	{	
		if(!checkWithDob(dateObj.value,dob, sysDate, format, locale))
		{
				dateObj.value = currDate;
				Obj.value = 0;
				document.forms[0].b_months.value = 0;
				document.forms[0].b_days.value = 0;
				document.forms[0].b_age.value = 0;
		}
	}
	document.forms[0].onset_date.value = dateObj.value;
}*/

function new_calci(Obj,format,locale,dateObj)

{
	var currDate = document.forms[0].ServerDate.value;
	var intervalY='Y',intervalM='M',intervalD='d';
	var years="0";
	years=document.forms[0].b_age.value;
	var months="0";
	months=document.forms[0].b_months.value;
	var days="0";
	days=document.forms[0].b_days.value;
	var tempDate="";
	if(years>=0){
			tempDate=minusDate(currDate, format, locale, years, intervalY);
	}
	if(months>=0){
		if(months >=0 && months <12)
			tempDate=minusDate(tempDate, format, locale, months, intervalM);
	}
	if(days>=0){
		if(days >=0 && days <32)
			tempDate=minusDate(tempDate, format, locale, days, intervalD);
	}
		dateObj.value=tempDate;
}


function new_calci1(Obj,format,locale,dateObj)

{
	var currDate = document.forms[0].ServerDate1.value;
	var intervalY='Y',intervalM='M',intervalD='d';
	var years="0";
	years=document.forms[0].b_age1.value;
	var months="0";
	months=document.forms[0].b_months1.value;
	var days="0";
	days=document.forms[0].b_days1.value;
	var tempDate="";
	if(years>=0){
			tempDate=minusDate(currDate, format, locale, years, intervalY);
	}
	if(months>=0){
		if(months >=0 && months <12)
			tempDate=minusDate(tempDate, format, locale, months, intervalM);
	}
	if(days>=0){
		if(days >=0 && days <32)
			tempDate=minusDate(tempDate, format, locale, days, intervalD);
	}
		
		//alert('tempDate ='+tempDate);
		if(!isBetweenDate(document.forms[0].onset.value,currDate,tempDate,format,locale))
    	{
				dateObj.value = currDate;
				Obj.value = 0;
				document.forms[0].b_months1.value = 0;
				document.forms[0].b_days1.value = 0;
				document.forms[0].b_age1.value = 0;
		}
		else
		{
			dateObj.value=tempDate;
		}			
}
/*function calci1(Obj,format,locale,dateObj)
{
	var currDate	= document.forms[0].ServerDate1.value;
	var sysDate		= document.forms[0].sys_date.value;


//		dateObj.value = currDate;

	var intervalY='Y',intervalM='M',intervalD='d';

	if(dateObj.value != null && dateObj.value != "")
	{
		if(Obj.name == 'b_age1' && Obj.value >0)
			dateObj.value = minusDate(dateObj.value, format, locale, Obj.value, intervalY);

		if(Obj.name == 'b_months1' && (Obj.value >0 && Obj.value <12))
			dateObj.value = minusDate(dateObj.value, format, locale, Obj.value, intervalM);

		if(Obj.name == 'b_days1' && (Obj.value >0 && Obj.value <32))
				dateObj.value = minusDate(dateObj.value, format, locale, Obj.value, intervalD);
		//alert("dateObj.value"+dateObj.value);
		if(!isBetweenCurrDate(document.forms[0].onset.value, currDate,dateObj,format,locale))
		{
				//alert("inside");
				dateObj.value = currDate;
				Obj.value = 0;
				document.forms[0].b_months1.value = 0;
				document.forms[0].b_days1.value = 0;
				document.forms[0].b_age1.value = 0;
		}
	}
		
	document.forms[0].close_date.value = dateObj.value;
		//if(document.forms[0].close !=null&&document.forms[0].close.value!="")
		//{
		//	document.forms[0].close_date.value=document.forms[0].close.value;
		//}

}*/

function checkWithDob(onset, dob,sysDate, format, locale)
{
	if(onset != "")
	{
		if(!isBetween(dob,sysDate,onset, format, locale))
		{	
			alert(getMessage("LESS_THAN_BDAY_DATE","CA"));
			return false;
		}
		else
			 return true;
	}
}

function reset_date(obj)
{
if(obj==null)
	{
	document.forms[0].close_date.value='';
	}
 else
	document.forms[0].close_date.value= obj.value;
}

function reset_date1(obj)
{
if(obj==null)
	{
	
	document.forms[0].onset_date.value='';
	}
 else
	{
		document.forms[0].onset_date.value= obj.value;
}	}

function enableDate()
{
	if(document.forms[0].date_type.checked == false)
	{
		document.forms[0].b_days.value = '';
		document.forms[0].b_days.disabled = true;
		document.forms[0].b_months.value = '';
		document.forms[0].b_months.disabled = true;
		document.forms[0].b_age.value = '';
		document.forms[0].b_age.disabled = true;
		document.forms[0].date_indicator.style.display = 'none';
		document.forms[0].onset.value = document.forms[0].ServerDate.value;
		document.forms[0].date_type1.value = 'A';
	}
	else
	{
		document.forms[0].b_days.disabled = false;
		document.forms[0].b_months.disabled = false;
		document.forms[0].b_age.disabled = false;
		document.forms[0].date_indicator.style.display = 'inline';
		document.forms[0].date_type1.value = 'E';
	}
}
