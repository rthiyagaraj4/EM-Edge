var moduleid="";
var patientid="";
var aclass="";
function apply() {

	var frameRef;

	if(top.content != null)
	{
		frameRef = top.content.messageFrame;
	}
	else
	{
		frameRef = parent.messageFrame;
	}

	if(parent.add_modify.document.PatientAllergy_form.remarks.value.length > 200)
	{
		var error = getMessage("OBJ_CANNOT_EXCEED","common");
		error = error.replace("$","200");
		alert(error);
		return false;
	}

	var allergicto	= "";
	var allergyclass	=	parent.add_modify.document.PatientAllergy_form.allergyclass;
	var function_name	=	parent.add_modify.document.PatientAllergy_form.function_name.value;

	var fields = new Array ();
	var names = new Array();

	if(function_name == "insert")	
	{
		fields[0]=allergyclass;
		names[0] =getLabel("eCA.AllergyClass.label","CA");
	
		if(allergyclass.value=="D")	
		{
			parent.add_modify.document.forms[0].allergicto.value=parent.add_modify.document.PatientAllergy_form.generic_id.value+"$"+parent.add_modify.document.PatientAllergy_form.generic_name.value;
			fields[1]=parent.add_modify.document.PatientAllergy_form.generic_name;
			names[1] =getLabel("eCA.GenericName.label","CA");
		}
		else
		{
			allergicto	=	parent.add_modify.document.PatientAllergy_form.allergicto.value;
			fields[1]=parent.add_modify.document.PatientAllergy_form.allergicto;
			names[1] =getLabel("eCA.AllergicTo.label","CA");
		}
		
		fields[2]=parent.add_modify.document.PatientAllergy_form.allergydesc
		names[2] =getLabel("eCA.AllergicDesc.label","CA");
	}
/*	else if(frameRef.add_modify.document.PatientAllergy_form.function_name.value == "modify")
	{
		fields[0] = frameRef.add_modify.document.PatientAllergy_form.close;
		names[0] =  getLabel("Common.enddate.label","Common");
	}
*/	
	
	if(checkFields( fields, names, frameRef))
	{
		parent.add_modify.document.PatientAllergy_form.submit();
	}
}


function clearform(){
	var frameRef;
	if(top.content != null)
	{
		frameRef = top.content.workAreaFrame;
	}
	else
	{
		frameRef = parent;
	}
	if(frameRef.add_modify.document.PatientAllergy_form.function_name.value == "modify")
	{
		var P_Encounter_Id = frameRef.add_modify.document.PatientAllergy_form.Encounter_Id.value;
		//alert(P_Encounter_Id);
		var P_Practitioner_Id = frameRef.add_modify.document.PatientAllergy_form.Practitioner_Id.value;
		var P_Clinic_Code = frameRef.add_modify.document.PatientAllergy_form.Clinic_Code.value;
		var P_Patient_Id = frameRef.add_modify.document.PatientAllergy_form.Patient_Id.value;
		var P_Location_Type = frameRef.add_modify.document.PatientAllergy_form.Location_Type.value;
		frameRef.add_modify.location.href ='../../eCA/jsp/addModifyPatAllegy.jsp?aclass=S&Encounter_Id='+P_Encounter_Id+'&Practitioner_Id='+P_Practitioner_Id+'&Clinic_Code='+P_Clinic_Code+'&Patient_Id='+P_Patient_Id+'&Location_Type='+P_Location_Type
	}
	else
	{
		//alert(frameRef.value);
		//alert(frameRef.messageFrame.value);
		frameRef.add_modify.document.PatientAllergy_form.reset() ;
		//frameRef.messageFrame.location.href='../../eCA/jsp/error1.jsp' ;
		if(top.content != null)
		{
			top.content.messageFrame.document.location.href="../../eCA/jsp/error1.jsp";
		}
		else
		{
			parent.messageFrame.document.location.href="../../eCA/jsp/error1.jsp";
		}
		frameRef.add_modify.document.PatientAllergy_form.allergyclass.value='';
	}
}
function cancel()
{
	if(top.content != null)
	{
		top.content.workAreaFrame.tools.location.href = '../../eCommon/html/blank.html' ;
		top.content.workAreaFrame.add_modify.location.href = '../../eCommon/html/blank.html' ;
		top.content.workAreaFrame.query.location.href = '../../eCommon/html/blank.html' ;
		top.content.messageFrame.document.location.href="../../eCA/jsp/error1.jsp";
	}
	else
		window.close();		
}

/*function ChkFielditems(fields, names, messageFrame)
{
	var errors="";
	var err=""
	for (var i=0 ; i<fields.length ; i++)
	{
		if (trimCheck(fields[i].value))
			fields[i].value=trimString(fields[i].value);
		else
			err=getMessage("CAN_NOT_BE_BLANK",'Common');
			err=err.replace('$',"");
			errors = errors + err ;
	}
	if (errors.length !=0)
	{
		if(top.content != null)
		{
			messageFrame.document.location.href="../../eCA/jsp/error1.jsp?err_num="+errors ;
		}
		else
		{
			parent.messageFrame.document.location.href="../../eCA/jsp/error1.jsp?err_num="+errors ;
		}
		return false ;
	}
	return true ;
}*/
function Date_Transform (transform,messageFrame) 
{
	dateset = transform[0];
	dateset1 = transform[1];
	if(dateset1.value=="") 
	{
		dateset.value="";
	}
	else 
	{
		var tst=dateset1.value;
		var arr = new Array();
		arr = tst.split("/");
		var strDay = arr[0];
		var strMonth = arr[1];
		var strYear = arr[2];
		var dt= strYear + "-" + strMonth + "-" + strDay;
		dateset.value= dt;
	}
}

function showCalendarValidate(str){
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}


function onSuccess(){
	var abc = "";
	if(top.content != null)
	{
		abc = top.content.workAreaFrame.add_modify.document.PatientAllergy_form.allergyclass;
	}
	else
	{
		abc = parent.add_modify.document.PatientAllergy_form.allergyclass;
	}
	alert(abc);
}

function loadformr()
{
  allergy=r.mrallergy.value;
  allergy_item=r.mraitem.value;
  allergy_class=r.mrallergyclass.value;
  allergy_type_code=r.mrallergytcode.value;
  allergy_class_desc=r.mrallergytypedesc.value;
  srlno=r.mrsrl_no.value;
  Patient_Id=r.mrPatient_Id.value;  
  moduleid=r.mrmoduleid.value;
  //alert(allergy+allergy_item+allergy_class+allergy_type_code+allergy_class_desc+srlno+Patient_Id+moduleid);
  
	if(top.content != null)
	{
		top.content.workAreaFrame.add_modify.document.location.href='addModifyPatAllegy.jsp?allergy='+allergy+'&allergyitem='+allergy_item+ '&allergyclass='+allergy_class+'&allergytcode='+allergy_type_code+'&allergytypedesc='+allergy_class_desc+'&srl_no='+srlno+'&Patient_Id='+Patient_Id+'&module_id='+moduleid;
	}
	else
	{
		parent.add_modify.document.location.href='addModifyPatAllegy.jsp?allergy='+allergy+'&allergyitem='+allergy_item+ '&allergyclass='+allergy_class+'&allergytcode='+allergy_type_code+'&allergytypedesc='+allergy_class_desc+'&srl_no='+srlno+'&Patient_Id='+Patient_Id+'&module_id='+moduleid;
	}
}

function scrollTitle(){
	if(parent.query!=null)
	{
		var y = parent.query.document.body.scrollTop;
		if(y == 0){
			parent.query.document.getElementById("divDataTitle").style.position = 'static';
			parent.query.document.getElementById("divDataTitle").style.posTop  = 0;
		}else{
			parent.query.document.getElementById("divDataTitle").style.position = 'relative';
			parent.query.document.getElementById("divDataTitle").style.posTop  = y-2;
		}
	}
}
function alignWidth(){
	if(parent.query!=null)
	{
		var totalRows =  parent.query.document.getElementById("dataTable").rows.length;
		var counter = totalRows-1;
		var temp = parent.query.document.getElementById("dataTitleTable").rows(0).cells.length;
		for(var i=0;i<temp;i++) {
			parent.query.document.getElementById("dataTitleTable").rows(0).cells(i).width=parent.query.document.getElementById("dataTable").rows(counter).cells(i).offsetWidth;
			
		}
	}	
}

function loadToolsFrame(){
	parent.frames[3].location.href='../../eCA/jsp/PatAllergyQueryTools.jsp?errorModify=Y&patient_id='+document.forms[0].mrPatient_Id.value;
}


async function showErrorList()
{
	var patient_id=document.forms[0].patient_id.value;
	var retVal;
	var dialogHeight=20;
	var dialogWidth=50;
	var features='dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';
	retVal=await window.showModalDialog('../../eCA/jsp/PatAllergyViewErrorList.jsp?patient_id='+patient_id,arguments,features);	
}

async function markError()
{
		var value=parent.frames[2].document.forms[0].errorRemarks.value;
		var comments;
		var retVal;
		var dialogHeight ='7' ;
		var dialogWidth = '30' ;
		var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
		retVal 			=await window.showModalDialog('../../eCA/jsp/RemarksDialog.jsp?allDia=Y&resultStr='+value,arguments,features);
		if(retVal==undefined){
					//checking undefined			
		}else if(retVal!=null && retVal!=''){
			parent.frames[2].document.forms[0].errorRemarks.value=retVal;
			parent.frames[2].document.getElementById("disMar").innerHTML="<font color=yellow  size=2>"+getLabel("eCA.MarkedforError.label","CA")+" &nbsp;&nbsp;</font>";
		}else{
				parent.frames[2].document.getElementById("disMar").innerText="";
				parent.frames[2].document.forms[0].errorRemarks.value="";
		}
}

async function callGenericSearch()
{
		var target				= document.forms[0].generic_name;
		var retVal				=  new String();
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc="";
		var title=getLabel('eCA.GenericName.label','CA');
		var sql="SELECT GENERIC_ID code, GENERIC_NAME description FROM PH_GENERIC_NAME ";

		search_code="GENERIC_ID";
		search_desc="GENERIC_NAME";
		retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
		
		var arr=new Array();

		if (retVal != null && retVal != '' && retVal != "null")
		{

			var retVal=unescape(retVal);
		   	 arr=retVal.split("::");

		    document.forms[0].generic_name.value=arr[0];
			document.forms[0].generic_id.value=arr[1];
			document.forms[0].generic_name.focus();
		}
		else
		{
			document.forms[0].generic_name.value="";
			document.forms[0].generic_id.value="";
			target.focus();
		}
	
	}

/*
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
					alert(getMessage("INVALID_ONSET_DATE",'CA'));
					
					document.forms[0].onset.focus();
					document.forms[0].onset.select();
			}
			else if(Date.parse(todt) <= Date.parse(fromdt)) 
				return true;
		}
		
		return true;
}

function validate_date1(from,to) {
		var fromarray;
		var toarray;
		var fromdate = from.value ;
		var todate = to.value ;
		if(fromdate.length > 0 && todate.length > 0 ) {
				fromarray = fromdate.split("/");
				toarray = todate.split("/");
				var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
				var todt = new Date(toarray[2],toarray[1],toarray[0]);
				if(Date.parse(todt) > Date.parse(fromdt)) 
				{
					var invaldt = getMessage("INVALID_CLOSE_DATE",'CA') ;
					alert(invaldt);
					document.forms[0].close.focus();
					document.forms[0].close.select();
				}
				else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
		}
		return true;
	}
*/
async function openModal(qryString)
{
	var patient_id=document.forms[0].mrPatient_Id.value;
	var retVal;
	var dialogHeight=20;
	var dialogWidth=50;
	var features='dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';
	retVal=await window.showModalDialog('../../eCA/jsp/RecPatAllergy.jsp?'+qryString+'&patient_id='+patient_id+'&modalYN=Y',arguments,features);	
}

function chekdup(obj)
{
	//alert("calling function chek dup");
	if(obj.name == "allergydesc")
	{
		if(document.PatientAllergy_form.allergydesc.value == "")
		{
		document.PatientAllergy_form.allergydesc2.value = "";
		document.PatientAllergy_form.allergydesc3.value = "";
		document.PatientAllergy_form.allergydesc2.disabled=true;
		document.PatientAllergy_form.allergydesc3.disabled=true;

		}
		else
		{
		document.PatientAllergy_form.allergydesc2.disabled=false;
		var anaes1 = document.PatientAllergy_form.allergydesc.value;
		var anaes2 = document.PatientAllergy_form.allergydesc2.value;
		var anaes3 = document.PatientAllergy_form.allergydesc3.value;
		if(anaes1 != "" && anaes2 != "")
		{
			if(anaes1 == anaes2)
			{
				alert(getMessage("ALRGY_ALREADY_SELECTED",'CA'));
				document.PatientAllergy_form.allergydesc.value = "";
				document.PatientAllergy_form.allergydesc2.value = "";
				document.PatientAllergy_form.allergydesc3.value = "";
				document.PatientAllergy_form.allergydesc2.disabled=true;
				document.PatientAllergy_form.allergydesc3.disabled=true;
			}
		}
		if(anaes1 != "" &&  anaes3 != "")
		{
			if(anaes1 == anaes3)
			{
				alert(getMessage("ALRGY_ALREADY_SELECTED","CA"));
				document.PatientAllergy_form.allergydesc.value = "";
				document.PatientAllergy_form.allergydesc2.value = "";
				document.PatientAllergy_form.allergydesc3.value = "";
				document.PatientAllergy_form.allergydesc2.disabled=true;
				document.PatientAllergy_form.allergydesc3.disabled=true;
			}
		}
		}
	}
	else if(obj.name == "allergydesc2")
	{
		if(document.PatientAllergy_form.allergydesc2.value == "")
		{
		document.PatientAllergy_form.allergydesc3.value = "";
		document.PatientAllergy_form.allergydesc3.disabled=true;
		}
		else
		{

		document.PatientAllergy_form.allergydesc3.disabled=false;
		var anaes1 = document.PatientAllergy_form.allergydesc.value;
		var anaes2 = document.PatientAllergy_form.allergydesc2.value;
		var anaes3 = document.PatientAllergy_form.allergydesc3.value;
		if(anaes2 != "" && anaes1 != "")
		{
			if(anaes2 == anaes1)
			{
				alert(getMessage("ALRGY_ALREADY_SELECTED","CA"));
				document.PatientAllergy_form.allergydesc2.value = "";
				document.PatientAllergy_form.allergydesc3.value = "";
				document.PatientAllergy_form.allergydesc3.disabled=true;
			}
		}
		if(anaes2 != "" &&  anaes3 != "")
		{
			if(anaes2 == anaes3)
			{
				alert(getMessage("ALRGY_ALREADY_SELECTED","CA"));
				document.PatientAllergy_form.allergydesc2.value = "";
				document.PatientAllergy_form.allergydesc3.value = "";
				document.PatientAllergy_form.allergydesc3.disabled=true;
			}
		}
		}
	}
	else if(obj.name == "allergydesc3")
	{
		var anaes1 = document.PatientAllergy_form.allergydesc.value;
		var anaes2 = document.PatientAllergy_form.allergydesc2.value;
		var anaes3 = document.PatientAllergy_form.allergydesc3.value;
		if(anaes3 != "" && anaes1 != "")
		{
			if(anaes3 == anaes1)
			{
				alert(getMessage("ALRGY_ALREADY_SELECTED","CA"));
				document.PatientAllergy_form.allergydesc3.value = "";
			}
		}
		if(anaes3 != "" && anaes2 != "")
		{
			if(anaes3 == anaes2)
			{
				alert(getMessage("ALRGY_ALREADY_SELECTED","CA"));
				document.PatientAllergy_form.allergydesc3.value = "";
			}
		}
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

function calci(Obj,format,locale,dateObj)
{
	var dob			= document.forms[0].Dob.value;
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

	if(dob != null && dob != "")
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
}

function calci1(Obj,format,locale,dateObj)
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

		if(!isBetweenCurrDate(document.forms[0].onset.value, currDate,dateObj,format,locale))
		{
				dateObj.value = currDate;
				Obj.value = 0;
				document.forms[0].b_months1.value = 0;
				document.forms[0].b_days1.value = 0;
				document.forms[0].b_age1.value = 0;
		}
	}
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
/*
function validate(close,onset,obj,format,locale)
	{
		currDate = getCurrentDate("DMY",locale);

		
		//if(close.value !="" && onset != "" && currDate != "")
		if( onset != "" && currDate != "")
		{
			
			if(isBetween(onset.value,currDate,close.value,format,locale)){
				return true;
			}  
			else
			{
				
				alert(getMessage("INVALID_CLOSE_DATE","CA"));
				obj.value='';
				//document.forms[0].close.value = getCurrentDate("DMY",locale);
				document.forms[0].close.value = '';
				document.forms[0].text9.value = '';
				return false;
			}
		}
	}
*/

function checkDays(Obj,obj1)
{
	if( Obj.value  > 31) 
	{ 
		alert(getMessage("DAYS_CHECK","Common"));
		Obj.focus(); 
		if (obj1.name=="onset")
				document.forms[0].onset.value=''; 
		else if(obj1.name=="close")
				document.forms[0].close.value=''; 
	}
//	document.forms[0].onset.onblur();
}

function checkMonth(Obj,obj1)
{
	if( Obj.value  > 11) { 
		alert(getMessage("MONTHS_CHECK","Common"));
		Obj.focus(); 
		if (obj1.name=="onset"){
				document.forms[0].onset.value='';}
		else if(obj1.name=="close")
				document.forms[0].close.value='';
	}
//	document.forms[0].onset.onblur();
}

/*
function calculate(Obj,close,format,locale)
{
	if(close.value==null ||close.value=='')
	{
		 
		// document.forms[0].close.value=document.forms[0].text10.value;
		 return false;
	}
	else
	{
		var currDate = close.value;
		var intervalY='Y',intervalM='M',intervalD='d';
		if(Obj.name == 'b_age1' && Obj.value >0)
		{	
			document.forms[0].close.value = minusDate(currDate, format, locale, Obj.value, intervalY);
			document.forms[0].text9.value=document.forms[0].close.value;
			
		}
		if(Obj.name == 'b_months1' && (document.forms[0].b_months1.value >0 && document.forms[0].b_months1.value <12))
		{
			document.forms[0].close.value = minusDate(currDate, format, locale, Obj.value, intervalM);
			document.forms[0].text9.value=document.forms[0].close.value;
			
		}
		if(Obj.name == 'b_days1' && (document.forms[0].b_days1.value >0 && document.forms[0].b_days1.value <32))
		{
			document.forms[0].close.value = minusDate(currDate, format, locale, Obj.value, intervalD);
			document.forms[0].text9.value=document.forms[0].close.value;
			
		}
	}
}
*/
function CheckForNumber_L(Objval,obj1) 
{
  	if(obj1.value == ''&& document.forms[0].closedate !=null)
	{
		obj1.value = document.forms[0].closedate.value;
	}

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
