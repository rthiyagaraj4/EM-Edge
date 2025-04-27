/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        Rev.Date	Rev.Name	Description
--------------------------------------------------------------------------------------------------------------
?             	100            		?           created
20/11/2013      IN040377		Chowminya 	   New Immunization report required Patient wise.
29/11/2013		IN045200		Nijitha S	   ML-BRU-SCF-1154	
04/12/2013      IN045400		Chowminya	   Link3:Wrong Error message is displayed at Manage Immunization
06/12/2013      IN045410        Chowminya      Link5:Two Immunization records are displayed in report,even though single record selected	
05/12/2017		IN065683		Ramesh G							After create vaccine category as age specific, System 																		automatically add this vaccine category in manage 																			immunization for all patients.
07/09/2023		41654			Twinkle	Shah		Ramesh Goli	    MMS-JU-CRF-0015.4															
---------------------------------------------------------------------------------------------------------------
*/
var prev_anchor="";

var Vaccin_CodeArr = new Array();
Vaccin_doseArr = new Array();
Vacc_siteArr = new Array(); 
Vacc_sch_dateArr = new Array(); 
var allow_multiple_yn1 ='T';
var interval_chk ='N';


function getSchedulePopUp()
{
	if (document.getElementById("schedule_categ").value != "")
	{	
		var schedule_catog=document.getElementById("schedule_categ").value;
		var query_string = document.getElementById("query_string").value;
		var patient_id = document.getElementById("patient_id").value;
		var encounter_id = document.getElementById("encounter_id").value;
		var adhoc_yn = "";
		
		var sch_cat = schedule_catog.split("~");	
		var vacc_categ_id = sch_cat[0];
		adhoc_yn = sch_cat[1];

		if (adhoc_yn == "N")
		{
			HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()' class=MESSAGE><form name='MultiScheduleform' id='MultiScheduleform' method='post' action='../../eCA/jsp/ScheduleMultiCategIntermediate.jsp?"+query_string+"'><input type=text name='schedule_catog' id='schedule_catog' value='"+vacc_categ_id+"'> </form></body></html>";

			top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
			//top.content.messageFrame.document.write(HTMLVal);
			
			top.content.messageFrame.document.MultiScheduleform.submit(); 
			var allow_multiple_yn = document.getElementById("allow_multiple_yn").value;		
			setTimeout('callPopup();',500);
		}else{	
				var CallFrom = "CREATE_ADHOC_SCH";
				var xmlStr ="<root><SEARCH ";			
				xmlStr += "  CallFrom=\""+  CallFrom + "\" ";
				xmlStr += "  PATIENT_ID=\""+  patient_id + "\" ";
				xmlStr += "  VACC_CATEG_ID=\""+  vacc_categ_id + "\" ";
				xmlStr += "  ENCOUNTER_ID=\""+ encounter_id + "\" ";														
				xmlStr +=" /></root>";
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","ScheduleImmuInterMediate.jsp?"+query_string,false);
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText ;	
				eval(responseText);
		}	
	}else{				
		var errmessage = getMessage("CREATE_SCHEDULE_NOT_BLANK","CA");		
		alert(errmessage);
		return false;
	}
}

function callPopup()
{
	//var allow_multiple_yn = top.content.workAreaFrame.frames[0].document.forms[0].allow_multiple_yn.value;
	var allow_multiple_yn = top.content.workAreaFrame.frames[0].document.getElementById('allow_multiple_yn').value;
	
	var schedule_catog=document.getElementById("schedule_categ").value;
	var query_string = document.getElementById("query_string").value;
	var patient_id = document.getElementById("patient_id").value;

	
	if( allow_multiple_yn=='Y')
	//if( allow_multiple_yn=='')
	{
		var catlog = schedule_catog.split("~");


		var popup = window.open('../../eCA/jsp/ScheduleAddVaccinCategoryMain.jsp?'+query_string+'&categ_id='+catlog[0],null,"height=600,width=1000,top=120,left=0,status=NO,toolbar=no,menubar=no,location=no");
		
	}
	else
	{
		var errmessage = getMessage("MULTIPLE_SCHEDULE_CHECK","CA")
		alert(errmessage);
		return false;
	} 
}

// start 41654
function getSchedulePopUpEdit(vac_sch_ref,vacc_categ_id,adhoc_yn,index)
{
	if (vacc_categ_id != "")
	{	
		var query_string = document.getElementById("query_string").value;
		var patient_id = document.getElementById("patient_id").value;
		var encounter_id = document.getElementById("encounter_id").value;
		
			HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()' class=MESSAGE><form name='MultiScheduleform' id='MultiScheduleform' method='post' action='ScheduleMultiCategIntermediate.jsp?"+query_string+"'><input type=hidden name='schedule_catog' id='schedule_catog' value='"+vacc_categ_id+"' </form></body></html>";
			top.content.messageFrame.document.write(HTMLVal);
			top.content.messageFrame.document.MultiScheduleform.submit(); 
			callPopupEdit(vac_sch_ref,vacc_categ_id,adhoc_yn,index,"editSchedule");
	}
	else{				
		var errmessage = getMessage("CREATE_SCHEDULE_NOT_BLANK","CA");		
		alert(errmessage);
		return false;
	}
}

function callPopupEdit(vac_sch_ref,vacc_categ_id,adhoc_yn,index,editSchedule)
{
	var query_string = document.getElementById("query_string").value;
	var patient_id = document.getElementById("patient_id").value;
	var popup = window.open('../../eCA/jsp/ScheduleAddVaccinCategoryMain.jsp?'+query_string+'&categ_id='+vacc_categ_id+'&editMode='+editSchedule+'&vac_sch_ref='+vac_sch_ref,null,"height=600,width=1000,top=120,left=0,status=NO,toolbar=no,menubar=no,location=no"); 	
	//scheduleResult(vac_sch_ref,vacc_categ_id,adhoc_yn,index);
}
//41654 end

//Added by Jyothi on 05/05/2010 to fix 21095
function CheckForNumsAndColon(event){
    var strCheck = '0123456789:/ ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}
//End
function scheduleCodeChange(obj)

{

	//alert('scheduleCodeChange 90 '+obj.value);
}

function scheduleResult(vac_sch_ref,vacc_categ_id,adhoc_yn,index)
{
	
	var field ="";
	
	if(index=="linkAll")
	{
		field = document.getElementById("linkAll");
		field.style.color='#0000FF';
		if(prev_anchor!=null&&prev_anchor!="")
		{
			if(field!=prev_anchor)
			{
				prev_anchor.style.color='#000066';
			}
		}
		prev_anchor = document.getElementById("linkAll");
		
	}else if (index=="linkVACCINE")
	{
		field = document.getElementById("linkVACCINE");
		field.style.color='#0000FF';
		if(prev_anchor!=null&&prev_anchor!="")
		{
			if(field!=prev_anchor)
			{
				prev_anchor.style.color='#000066';
			}
		}
		prev_anchor = document.getElementById("linkVACCINE");
	}
	else
	{
		var field =document.getElementById('linkSchCateg'+index);

		field.style.color='#0000FF';
		if(prev_anchor!=null&&prev_anchor!="")
		{
			if(field!=prev_anchor)
				{
					prev_anchor.style.color='#000066';
				}
		}
			prev_anchor = field;
	}
	
	

	
	var query_string = document.getElementById("query_string").value;

	var cbSchedule = "";  //document.getElementById("cbSchedule").value;
	if (vac_sch_ref=="ALL")
	{
		cbSchedule="Y";
	}/*else if (vac_sch_ref=="ADMINRXVACCINES")
	{
		cbSchedule="N";
		vac_sch_ref = "";
		vacc_categ_id = "ADMINRXVACCINES";
	}*/
	else
	{
		cbSchedule="N";
	}

	/*
		Modified by Kishore Kumar N on Sept-08-09 for CRF 691.

	parent.ExistScheduleDetailFrame.location.href="ScheduleVaccinResultMain.jsp?"+query_string+"&vac_sch_ref="+vac_sch_ref+"&vacc_categ_id="+vacc_categ_id+"&mode_new=modify&adhoc_yn="+adhoc_yn+"&cbSchedule="+cbSchedule;*/

	
	
	parent.ExistScheduleDetailFrame.location.href= "ScheduleVaccinTabResultMain.jsp?"+"&vac_sch_ref="+vac_sch_ref+"&vacc_categ_id="+vacc_categ_id+"&mode_new=modify&adhoc_yn="+adhoc_yn+"&cbSchedule="+cbSchedule+"&"+query_string;
	
	if(adhoc_yn=='Y')
	{
		parent.VaccinationFrame.VaccineAdminTabFrame.location.href="ScheduleVaccinAdminTab.jsp?"+query_string+"&mode_new=insert&adhoc_yn="+adhoc_yn;
		//parent.VaccinationFrame.VaccinAdminDetailsFrame.location.href="ScheduleVaccinMedAdminDetails.jsp?"+query_string+"&vacc_categ_id="+vacc_categ_id+"&mode_new=insert&adhoc_yn="+adhoc_yn;
		parent.VaccinationFrame.VaccinAdminDetailsFrame.location.href="ScheduleVaccinAdminDetails.jsp?"+query_string+"&vacc_categ_id="+vacc_categ_id+"&mode_new=insert&adhoc_yn="+adhoc_yn;
	}
	else
	{
		if (parent.VaccinationFrame.VaccineAdminTabFrame)
		{
			parent.VaccinationFrame.VaccineAdminTabFrame.location.href="../../eCommon/html/blank.html";
		}

		if (parent.VaccinationFrame.VaccinAdminDetailsFrame)
		{
			parent.VaccinationFrame.VaccinAdminDetailsFrame.location.href="../../eCommon/html/blank.html";
		}
		
		
	}
	parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';

	//parent.ExistScheduleDetailFrame.location.href="ScheduleVaccinResultMain.jsp";
	
	

}

function setcbSchedule(obj)

{
 if (obj.checked)
 {
	 document.getElementById("cbSchedule").value='Y';
 }
 else
 {
 	document.getElementById("cbSchedule").value='N';
 }

}

async function getUser()
{

	
	var target			= document.forms[0].creating_user;
	var stdval          = document.forms[0].creating_user.value;
	//var val				= document.forms[0].facilityid.value;
	//var pract_id		= document.forms[0].ca_practitioner_id.value;
	var retVal			=  new String();
	var dialogTop		= "40";
	var dialogHeight	= "10" ;
	var dialogWidth		= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "" ;
	var search_desc		= "";
	//var title			= getLabel("Common.practitioner.label","COMMON");
	var title			= document.getElementById("creating_user").innerText;
	var locale			= document.forms[0].locale.value;
	//var loc_type		= document.forms[0].locationType.value;
	//var sql="Select locn_code code,decode(locn_type,'C',OP_GET_DESC.OP_CLINIC('"+val+"',locn_code,'"+locale+"','1'), 'W',IP_GET_DESC.IP_NURSING_UNIT('"+val+"',locn_code,'"+locale+"','1') ) description  from ca_pract_by_locn_view where  upper(locn_code) like upper(?) AND UPPER(decode(locn_type,'C',OP_GET_DESC.OP_CLINIC('"+val+"',locn_code,'"+locale+"','1'), 'W',IP_GET_DESC.IP_NURSING_UNIT('"+val+"',locn_code,'"+locale+"','1') )) like upper(?) AND practitioner_id= '"+pract_id+"' and locn_type in ('C','W') and facility_id = '"+val+"' and PATIENT_CLASS = '"+loc_type+"' order by 2";
			
	var sql="SELECT APPL_USER_ID code,APPL_USER_NAME description FROM SM_APPL_USER WHERE EFF_STATUS ='E' and upper(APPL_USER_ID) like upper(?) AND UPPER(APPL_USER_NAME) like upper(?) ORDER BY 2 ";
	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();
	
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
							
		retArray = await CommonLookup( title, argArray );	
			var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if(retArray != null && retArray !="")
		{

		document.forms[0].creating_user_id.value = arr[0];
		document.forms[0].creating_user.value = arr[1];
					//document.forms[0].performed_by_code.value = retArray[0];
					
		}
		else
		{
			document.forms[0].creating_user_id.value ='';
			document.forms[0].creating_user.value = '';
		}


}

function showCalendarValidate(str){
	//var flg = showCalendar(str);
	//document.getElementById(str).focus();
	//return flg;

	var flg = showCalendar(str,null,'hh:mm'); 
	document.getElementById(str).focus();
	return flg;
}

function alignHeading()
			{
				
				if(document.getElementById("scheduleVaccTitle") != null) 
				{
					document.getElementById("scheduleVaccTitle").width =	eval(document.getElementById("scheduleVaccData").offsetWidth);
					for (j=0; j < document.getElementById("scheduleVaccData").rows[0].cells.length; j++) 
					{
						var wid=eval(document.getElementById("scheduleVaccData").rows[0].cells[j].offsetWidth);
						if(document.getElementById("scheduleVaccTitle").rows[0].cells[j] != null)
						{
							document.getElementById("scheduleVaccTitle").rows[0].cells[j].width=wid;
						}
					}
				}
			}

function record_catalog()
{

		var fields = new Array (parent.ScheduleCatalogDetailFrame.document.addCategoryForm.start_date);

		var names = new Array ( getLabel("Common.Schedule.label",'COMMON')+" "+getLabel("Common.StartDate.label",'COMMON')); //Common.Schedule.label


		if(checkFields( fields, names,parent.messageFrame))
		{
			//IN065683 Start.
			var totalCount = parent.ScheduleCatalogDetailFrame.document.addCategoryForm.count.value;			
			var summbitAllow = false;
			for(var i=0;i<parseInt(totalCount);i++){
				if(eval(" parent.ScheduleCatalogDetailFrame.document.addCategoryForm.select"+i+".value")=="Y"){					
					summbitAllow = true;
					break;
				}
			}

			if(summbitAllow){
			//IN065683 End.
				var locale = parent.ScheduleCatalogDetailFrame.document.addCategoryForm.locale.value;
				//parent.ScheduleCatalogDetailFrame.document.addCategoryForm.start_date.value=convertDate(parent.ScheduleCatalogDetailFrame.document.addCategoryForm.start_date.value,"DMYHM",locale,"en");//IN065683 commented by Dinesh T since date is not going with english date

				parent.ScheduleCatalogDetailFrame.document.addCategoryForm.submit();
			//IN065683 Start.
			}else{
				alert(getMessage("CHOOSE_AT_LEAST_ONE_SCHEDULE","CA"));
			}
			//IN065683 End.
		}


}

function cancel_catalog()
{
	parent.window.close();
}


function record_adminDet()
{
	
	var vac_sch_ref = parent.VaccinAdminDetailsFrame.document.forms[0].vac_sch_ref.value;
	var vacc_categ_id = parent.VaccinAdminDetailsFrame.document.forms[0].vacc_categ_id.value;
	var vaccine_id = parent.VaccinAdminDetailsFrame.document.forms[0].vaccine_name.value;
	var patient_id = parent.VaccinAdminDetailsFrame.document.forms[0].patient_id.value;
	var encounter_id = parent.VaccinAdminDetailsFrame.document.forms[0].encounter_id.value;
	var adhoc_yn = parent.VaccinAdminDetailsFrame.document.forms[0].adhoc_yn.value;
	var locale = parent.VaccinAdminDetailsFrame.document.forms[0].locale.value;
	
	
	var administer_date = parent.VaccinAdminDetailsFrame.document.forms[0].administer_date.value;
	//Date Convesion added by Archana Dhal on 12/8/2010 related to incident no IN025377.
	administer_date = convertDate(administer_date,"DMYHM",locale,"en");
	var msg ="";
	var action_mode ="dup_chk";
	
	
	var vacc_lab =getLabel("Common.Vaccine.label","COMMON")+" "+getLabel("Common.name.label","COMMON");
	
	if(parent.VaccinAdminDetailsFrame.document.forms[0].Outcome.value=='E')
	{

		var fields = new Array(parent.VaccinAdminDetailsFrame.document.forms[0].error_remarks);

		var names = new Array (getLabel("Common.remarks.label","COMMON"));
	

	}
	else {
	
	if (!parent.VaccinAdminDetailsFrame.document.forms[0].ext_administer.checked)
	{
		//IN045200 Start
		if(parent.VaccinAdminDetailsFrame.document.forms[0].Outcome.value=='N')
		{
			var fields = new Array (parent.VaccinAdminDetailsFrame.document.forms[0].vaccine_name,parent.VaccinAdminDetailsFrame.document.forms[0].Outcome,parent.VaccinAdminDetailsFrame.document.forms[0].administer_by,parent.VaccinAdminDetailsFrame.document.forms[0].batch_no,parent.VaccinAdminDetailsFrame.document.forms[0].manufacturer);

			var names = new Array (vacc_lab,getLabel("Common.outcome.label","COMMON"),getLabel("Common.AdministeredBy.label","COMMON"),getLabel("eCA.BatchNumber.label","CA"),getLabel("Common.Manufacturer.label","COMMON"));
		}
		else
		{
		//IN045200 Ends
			var fields = new Array (parent.VaccinAdminDetailsFrame.document.forms[0].vaccine_name,parent.VaccinAdminDetailsFrame.document.forms[0].Outcome,parent.VaccinAdminDetailsFrame.document.forms[0].administer_date,parent.VaccinAdminDetailsFrame.document.forms[0].administer_by,parent.VaccinAdminDetailsFrame.document.forms[0].batch_no,parent.VaccinAdminDetailsFrame.document.forms[0].manufacturer);

			var names = new Array (vacc_lab,getLabel("Common.outcome.label","COMMON"),getLabel("eCA.AdministerDate.label","CA"),getLabel("Common.AdministeredBy.label","COMMON"),getLabel("eCA.BatchNumber.label","CA"),getLabel("Common.Manufacturer.label","COMMON"));
		}//IN045200
	}
	else{
		
		var fields = new Array (parent.VaccinAdminDetailsFrame.document.forms[0].vaccine_name,parent.VaccinAdminDetailsFrame.document.forms[0].Outcome,parent.VaccinAdminDetailsFrame.document.forms[0].administer_date,parent.VaccinAdminDetailsFrame.document.forms[0].administer_by,parent.VaccinAdminDetailsFrame.document.forms[0].ext_facility);

		var names = new Array (vacc_lab,getLabel("Common.outcome.label","COMMON"),getLabel("eCA.AdministerDate.label","CA"),getLabel("Common.AdministeredBy.label","COMMON"),getLabel("Common.externalfacility.label","COMMON"));
	}
	}


		if(checkFields( fields, names,parent.parent.parent.messageFrame))
		{
			document.getElementById("ext_administer").disabled=false;
			if(parent.VaccinAdminDetailsFrame.document.forms[0].Outcome.value!='E')
			{
				/*var xmlDoc 				= new ActiveXObject( "Microsoft.XMLDom" ) ;
				var xmlHttp 			= new ActiveXObject( "Microsoft.XMLHTTP" ) ;*/
				
				var xmlDoc 				= "" ;
				var xmlHttp 			= new XMLHttpRequest() ;
				xmlStr					= "<root><SEARCH " ;
				xmlStr					+= "action_mode=\""+action_mode+"\" ";
				xmlStr					+= "vac_sch_ref=\""+vac_sch_ref+"\" ";
				xmlStr					+= "vaccine_id=\""+vaccine_id+"\" ";
				xmlStr					+= "vacc_categ_id=\""+vacc_categ_id+"\" ";
				xmlStr					+= "patient_id=\""+patient_id+"\" ";
				xmlStr					+= "encounter_id=\""+encounter_id+"\" ";
				xmlStr					+= "adhoc_yn=\""+adhoc_yn+"\" ";
				xmlStr					+= "administer_date=\""+administer_date+"\" ";
				xmlStr 			+=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST", "ScheduleForVacinationIntermediate.jsp", false ) ;
				xmlHttp.send( xmlDoc ) ;
				responseText=xmlHttp.responseText ;
				eval( responseText ) ;

			

				var interval = parent.VaccinAdminDetailsFrame.document.forms[0].interval.value;
				var prev_check_days = parent.VaccinAdminDetailsFrame.document.forms[0].prev_check_days.value;
				var dupl_check_action = parent.VaccinAdminDetailsFrame.document.forms[0].dupl_check_action.value;
				
				if((parseInt(interval,10) != 0) && (parseInt(prev_check_days,10) != 0))
				{				
					if((parseInt(interval,10)<=parseInt(prev_check_days,10)))
					{			
						
						if(dupl_check_action=='A'||dupl_check_action=='W')
						{
							
							msg = getMessage("ALREADY_ADMINISTERED","CA");
							msg = msg.replace('$$',interval);
							msg = msg.replace('##',prev_check_days);
							//var stat = confirm("This vaccine has already administered $$ days before. \n There should be a time interval of ## days. Do you want to continue...?");
							var stat = confirm(msg);
							if(stat==true)
							{
								parent.VaccinAdminDetailsFrame.document.forms[0].submit();						
							}
							else
							{
								//alert("This vaccine already administered $ days before .it cannot be administered again with in  # days." );
								return;
							}
						}
						else
						{
							msg = getMessage("CANT_ADMINISTER","CA");
							msg = msg.replace('$$',parseInt(interval));
							msg = msg.replace('##',prev_check_days);
							//alert("This vaccine has already administered $$ days before. \n There Must be a time interval of ## days." );
							alert(msg);
							return;
						}				
					}
					else
					{
						parent.VaccinAdminDetailsFrame.document.forms[0].submit();
						top.content.workAreaFrame.ExistScheduleDetailFrame.location.reload();
					}
				}
				else
				{	
					parent.VaccinAdminDetailsFrame.document.forms[0].submit();
					top.content.workAreaFrame.ExistScheduleDetailFrame.location.reload();
				}
			}
			else
			{	
				parent.VaccinAdminDetailsFrame.document.forms[0].submit();
				top.content.workAreaFrame.ExistScheduleDetailFrame.location.reload();
			}
		}	
}


function alignHeading1()
{
	if(parent.VaccineResTitle.document.getElementById("patVaccTitle") != null) 
		{
			parent.VaccineResTitle.document.getElementById("patVaccTitle").width =	eval(document.getElementById("patVaccData").offsetWidth);
			var Counter =document.getElementById("patVaccData").rows.length-1;
			
				for (j=0; j < document.getElementById("patVaccData").rows(Counter).cells.length; j++) 
				{
					var wid=eval(document.getElementById("patVaccData").rows(Counter).cells[j].offsetWidth);
					if(parent.VaccineResTitle.document.getElementById("patVaccTitle").rows[0].cells[j] != null)
					{
							parent.VaccineResTitle.document.getElementById("patVaccTitle").rows[0].cells[j].width=wid;
					}
				}
		}

}

function onSuccess(vac_sch_ref)
{
	var query_string = "" ;//parent.parent.ExistScheduleTreeFrame.document.getElementById("query_string").value;
	window.close();
	window.opener.location.reload();

	//parent.VaccineResult.location.href='ScheduleVaccinResult.jsp?'+query_string+'&vac_sch_ref='+vac_sch_ref+'&mode_new=modify';

	//parent.VaccinAdminDetailsFrame.location.reload();
	//window.parent.parent.ExistScheduleTreeFrame.location.reload();
	//top.content.frames[0].frames[0].relaod();
	//parent.parent.ExistScheduleTreeFrame.location.reload();

}

function loadAdminPage(vac_sch_ref,vaccine_id,dose_no,adhoc_yn,status,vacc_categ_id,alergry_exists_yn, vaccine_desc,order_id,ord_drug_code,schedule_date,administered_date,ord_drug_dose_no)
{	
	/* modified by ,ore kumar N on Sept-08-09 for CRF 691*/


	var query_string = parent.parent.parent.ExistScheduleTreeFrame.document.getElementById("query_string").value ;
	
	if (order_id == "" && ord_drug_code == "")
	{
		parent.parent.parent.VaccinationFrame.VaccineAdminTabFrame.location.href="ScheduleVaccinAdminTab.jsp?"+query_string+"&vac_sch_ref="+vac_sch_ref+"&vaccine_id="+vaccine_id+"&dose_no="+dose_no+"&status="+status+"&mode_new=modify&adhoc_yn="+adhoc_yn+"&alergry_exists_yn="+alergry_exists_yn+"&vaccine_desc="+vaccine_desc;
		parent.parent.parent.VaccinationFrame.VaccinAdminDetailsFrame.location.href="ScheduleVaccinAdminDetails.jsp?"+query_string+"&vac_sch_ref="+vac_sch_ref+"&vaccine_id="+vaccine_id+"&dose_no="+dose_no+"&mode_new=modify&adhoc_yn="+adhoc_yn+"&vacc_categ_id="+vacc_categ_id+"&vaccine_desc="+vaccine_desc+"&status="+status;
	}else{					
		parent.parent.parent.VaccinationFrame.VaccineAdminTabFrame.location.href="ScheduleVaccinAdminTab.jsp?"+query_string+"&vac_sch_ref="+vac_sch_ref+"&vaccine_id="+vaccine_id+"&dose_no="+ord_drug_dose_no+"&status="+status+"&mode_new=insert&adhoc_yn=Y&alergry_exists_ynN&vaccine_desc="+vaccine_desc+"&order_id="+order_id+"&ord_drug_code="+ord_drug_code+"&schedule_date="+schedule_date+"&administered_date="+administered_date+"&hideAlrgTab=Y";		
		parent.parent.parent.VaccinationFrame.VaccinAdminDetailsFrame.location.href="ScheduleVaccinMedAdminDetails.jsp?"+query_string+"&vac_sch_ref="+vac_sch_ref+"&vaccine_id="+vaccine_id+"&dose_no="+ord_drug_dose_no+"&mode_new=modify&adhoc_yn=N&vacc_categ_id="+vacc_categ_id+"&vaccine_desc="+vaccine_desc+"&order_id="+order_id+"&ord_drug_code="+ord_drug_code+"&schedule_date="+schedule_date+"&administered_date="+administered_date;
	}
	//parent.VaccinationFrame.VaccinAdminDetailsFrame.location.href="ScheduleVaccinAdminDetails.jsp?query_string&vacc_categ_id="+vacc_categ_id+"&mode=modify";
	
	//
	
	parent.parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	/* ends here.*/

}
/* modified by Kishore kumar N on Sept-08-09 for CRF 691*/
function loadAllergyPage(vac_sch_ref,vaccine_id,administered_date,dose_no,adhoc_yn,vaccine_desc)

{	
	//tab_clickAllergy('allergy_tab');
	var query_string = parent.parent.parent.ExistScheduleTreeFrame.document.getElementById("query_string").value ;	
	 parent.parent.parent.VaccinationFrame.VaccineAdminTabFrame.location.href="ScheduleVaccinAdminTab.jsp?"+query_string+"&vac_sch_ref="+vac_sch_ref+"&vaccine_id="+vaccine_id+"&administered_date="+administered_date+"&loadAlrg=Y&dose_no="+dose_no+"&mode_new=modify&adhoc_yn="+adhoc_yn+"&vaccine_desc="+vaccine_desc+"&alergry_exists_yn=Y";
	 parent.parent.parent.VaccinationFrame.VaccinAdminDetailsFrame.location.href="ScheduleVaccAllegyMain.jsp?"+query_string+"&vac_sch_ref="+vac_sch_ref+"&vaccine_id="+vaccine_id+"&mode_new=view&administered_date="+administered_date+"&dose_no="+dose_no+"&vaccine_desc="+vaccine_desc;;
/* ends here.*/
}

function changeSelectVal(obj,index)

{
	
	var field ="";
	field = document.getElementById("select"+index);
	if (obj.checked)
	{
		field.value='Y';
	}
	else
	{
		field.value='N';
	}
}

//start 41654
function changeSelectValEdit(obj,index)
{
	var field ="";
	var outCome_Code="";
	var mark_Status="";
	field = document.getElementById("select")+index;	
	outCome_Code=document.getElementById("outCome_Code"+index).value;
	mark_Status=document.getElementById("mark_Status"+index).value;

	if(outCome_Code =="C" || outCome_Code == "N" || (outCome_Code == "A" && mark_Status == "E"))
	{
		document.getElementById("select_check_box"+index).checked = true;
		alert(getMessage('UNCHK_CHKBOX_NOT_PERMITTED','CA'));
	}
	
   	if (obj.checked)
	{
		field.value='Y';
	}
	else
	{
		field.value='N';
	}
}
//end 41654

function loadFields(obj)
{

	deleteSiteName(top.content.workAreaFrame.VaccinationFrame.VaccinAdminDetailsFrame.document.adminDetailform.site_name);
	var index = obj.selectedIndex-1;
	var vaccine_id = obj.value;
	var action_mode = "pop_vac";
	
			var xmlHttp 			=  new XMLHttpRequest() ;
			xmlStr					= "<root><SEARCH " ;
			xmlStr					+= "action_mode=\""+action_mode+"\" ";
			xmlStr					+= "vaccine_id=\""+vaccine_id+"\" ";
			//xmlStr					+= "vacc_categ_id=\""+vacc_categ_id+"\" ";
			//xmlStr					+= "patient_id=\""+patient_id+"\" ";
			//xmlStr					+= "encounter_id=\""+encounter_id+"\" ";
			//xmlStr					+= "adhoc_yn=\""+adhoc_yn+"\" ";
			xmlStr 			+=" /></root>" ;
			var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "ScheduleForVacinationIntermediate.jsp", false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval( responseText ) ;

}

async function getAdminister(userName)
{

	var target			= document.forms[0].administer_by_name;
	var stdval          = document.forms[0].administer_by_name.value;
	//var val				= document.forms[0].facilityid.value;
	//var pract_id		= document.forms[0].ca_practitioner_id.value;
	var retVal			=  new String();
	var dialogTop		= "40";
	var dialogHeight	= "10" ;
	var dialogWidth		= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "" ;
	var search_desc		= "";
	var title			= getLabel("Common.AdministeredBy.label","COMMON");
	//var title			= document.getElementById("administer_by").innerText;
	//var locale			= document.forms[0].locale.value;
	//var loc_type		= document.forms[0].locationType.value;
	//var sql="Select locn_code code,decode(locn_type,'C',OP_GET_DESC.OP_CLINIC('"+val+"',locn_code,'"+locale+"','1'), 'W',IP_GET_DESC.IP_NURSING_UNIT('"+val+"',locn_code,'"+locale+"','1') ) description  from ca_pract_by_locn_view where  upper(locn_code) like upper(?) AND UPPER(decode(locn_type,'C',OP_GET_DESC.OP_CLINIC('"+val+"',locn_code,'"+locale+"','1'), 'W',IP_GET_DESC.IP_NURSING_UNIT('"+val+"',locn_code,'"+locale+"','1') )) like upper(?) AND practitioner_id= '"+pract_id+"' and locn_type in ('C','W') and facility_id = '"+val+"' and PATIENT_CLASS = '"+loc_type+"' order by 2";
			
	var sql="SELECT APPL_USER_ID code,APPL_USER_NAME description FROM SM_APPL_USER WHERE EFF_STATUS ='E' and upper(APPL_USER_ID) like upper(?) AND UPPER(APPL_USER_NAME) like upper(?) ORDER BY 2 ";
	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();
	
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
							
		retArray = await CommonLookup( title, argArray );	
				var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if(retArray != null && retArray !="")
		{

		document.forms[0].administer_user_id.value = arr[0];
		document.forms[0].administer_by.value = arr[0];
		document.forms[0].administer_by_name.value = arr[1];
					
		}
		else
		{		
			if(target.value!=userName)
			{
				document.forms[0].administer_by.value = "";
				document.forms[0].administer_by_name.value ="";				
				document.forms[0].administer_user_id.value = "";	
			}

		}
}

function setExtAdminVal(obj)
{
	var adhoc_yn =document.getElementById("adhoc_yn").value;
	if (obj.checked)
	{		
		document.getElementById("ext_administer").value='Y';
		document.getElementById("chkExtFclImg1").style.display='inline';//visible
		document.getElementById("chkBatchNoImg").style.display='none';
		document.getElementById("chkManuImg").style.display='none';	
		document.getElementById("ext_facility").readOnly=false;
		document.getElementById("Outcome").value='C';
		document.getElementById("Outcome1").value='C';
		document.getElementById("Outcome").disabled=true;
		document.getElementById("td_AdministeredBy").innerText = "Recorded By"
		document.getElementById("administer_date_mand").style.display='inline';//IN045200	

		if(document.forms[0].batch_no.value=='-NA-')
		{
			document.forms[0].batch_no.value='';
		}
		if(document.forms[0].manufacturer.value=='-NA-')
		{
			document.forms[0].manufacturer.value='';
		}


					
	}
	else
	{
		document.getElementById("ext_administer").value='N';
		document.getElementById("ext_facility").value='';
		document.getElementById("ext_facility").readOnly=true;		
		if(adhoc_yn=='Y')
		{
		document.getElementById("Outcome").disabled=true;
		document.getElementById("Outcome").value='C';
		document.getElementById("Outcome1").value='C';
		}
		else
		{
		document.getElementById("Outcome").disabled=false;
		document.getElementById("Outcome").value='';
		document.getElementById("Outcome1").value='';
		}
		document.getElementById("chkExtFclImg1").style.display='none';
		document.getElementById("chkBatchNoImg").style.display='inline';
		document.getElementById("chkManuImg").style.display='inline';
		
	}
}


function scheduleResByStatus(obj)

{
	
	var vac_sch_ref =parent.parent.parent.ExistScheduleTreeFrame.document.getElementById("vac_sch_ref").value;
	var cbSchedule =document.getElementById("cbSchedule").value;
	var status_ord =obj.value;
	var vacc_categ_id =parent.parent.parent.ExistScheduleTreeFrame.document.getElementById("vacc_categ_id").value;
	/* modified by Kishore kumar N on Sept-08-09 for CRF 691*/
	var query_string = parent.parent.parent.ExistScheduleTreeFrame.document.getElementById("query_string").value;
	/* ends here. */
	var include_err =  document.getElementById("include_err").value;

	if(status_ord=="")
	{
		query_string=query_string+"&include_err="+include_err;
		document.getElementById("include_err").disabled = false;
	}
	else
	{
		document.getElementById("include_err").checked = false;
		document.getElementById("include_err").disabled = true;
		 document.getElementById("include_err").value = 'N';
	}
	
//	parent.VaccineResult.location.href='ScheduleVaccinResult.jsp?'+query_string+'&status_ord='+status_ord+'&vac_sch_ref='+vac_sch_ref+'&cbSchedule='+cbSchedule+'&adhoc_yn=N&mode_new=modify'+'&vacc_categ_id='+vacc_categ_id;
parent.VaccineResult.location.href='ScheduleVaccinResult.jsp?'+query_string+'&status_ord='+status_ord+'&vac_sch_ref=ALL&cbSchedule='+cbSchedule+'&adhoc_yn=N&mode_new=modify'+'&vacc_categ_id=';
	parent.parent.parent.VaccinationFrame.VaccineAdminTabFrame.location.href='../../eCA/jsp/blank.jsp';
	parent.parent.parent.VaccinationFrame.VaccinAdminDetailsFrame.location.href='../../eCA/jsp/blank.jsp';

	
}

function scheduleResShowErr(obj)
{	
	var include_err =""
	if(obj.checked)
	{
		include_err='Y';
		obj.value='Y';
	}
	else
	{
		include_err='N';
		obj.value='N';
	}

	var vac_sch_ref =document.getElementById("vac_sch_ref").value;
	var cbSchedule =document.getElementById("cbSchedule").value;

	//var status_ord =obj.value;
	var status_ord =document.getElementById("schedule_status").value;
	var vacc_categ_id =document.getElementById("vacc_categ_id").value;
	/* modified by Kishore kumar N on Sept-08-09 for CRF 691*/
	var query_string = parent.parent.parent.ExistScheduleTreeFrame.document.getElementById("query_string").value;
	/* ends here.*/
	parent.VaccineResult.location.href='ScheduleVaccinResult.jsp?'+query_string+'&status_ord='+status_ord+'&vac_sch_ref='+vac_sch_ref+'&cbSchedule='+cbSchedule+'&adhoc_yn=N&mode_new=modify'+'&include_err='+include_err+'&vacc_categ_id='+vacc_categ_id;

	
}

function onSuccess1()
{
	if (parent.parent.ExistScheduleDetailFrame.VaccineTabResult )
	{
		parent.parent.ExistScheduleDetailFrame.VaccineTabResult.VaccineResult.location.reload();
	}
	
	parent.VaccinAdminDetailsFrame.location.reload();
}

function CheckDateTime(objText,field)
{
	
	objText.value= trim(objText.value," ");
	var locale		= document.forms[0].locale.value;
	var Dob		= document.forms[0].Dob.value;
	var label ="";	
	var localeName="";
	/*if(parent.VaccinAdminDetailsFrame.document.adminDetailform)
	{
		localeName=parent.VaccinAdminDetailsFrame.document.adminDetailform.locale.value
	}*/
	//else if()
	//{

	//}

	
	if(objText.value !='')
	{		
		/*if(!doDateTimeChk1(objText))
		{
			alert(getMessage("INVALID_DATE_FMT","CA"))
			objText.select();
			return false
		}*/
		//modified for checking 00/00/0000 condition
		if(validDateObj(objText,"DMYHM",locale)==false){			
		objText.select();
		return false;
		}
		if(isBeforeNow(objText.value,"DMYHM",locale))
		{
		if(isBefore(objText.value,Dob,'DMYHM',locale))
		{
				
				if(field=="ScheduleDate")
				{
					label=getLabel("Common.ScheduleDate.label","COMMON");
				}
				else if (field=="AdministerDate")
				{
					label=getLabel("eCA.AdministerDate.label","CA");
				}
				else if (field=="ReactionDate")
				{
					label=getLabel("Common.ReactionDate.label","COMMON");
				}
				else if (field=="startDate")
				{
					label=getLabel("Common.Schedule.label","CA")+" "+getLabel("Common.StartDate.label","COMMON");
				}
				
				var msg = getMessage("DATE_DOB_CHECK","CA");
				msg = msg.replace('$$',label);
				alert(msg);
				objText.select();
				return false;
		}
		
		}else
		{
			if(field=="ScheduleDate")
				{
					label=getLabel("Common.ScheduleDate.label","COMMON");
				}
				else if (field=="AdministerDate")
				{
					label=getLabel("eCA.AdministerDate.label","CA");
				}
				else if (field=="ReactionDate")
				{
					label=getLabel("Common.ReactionDate.label","COMMON");
				}
				else if (field=="startDate")
				{
					label=getLabel("Common.Schedule.label","CA")+" "+getLabel("Common.StartDate.label","COMMON");
				}
				var msg = getMessage("CANNOT_BE_GREATER_THAN_SYSDATE","CA");
				msg = msg.replace('$$',label);
				alert(msg);
			objText.value = getCurrentDate("DMYHM",locale);
			return false;
		}	
		
	}
} 

function trim(str, chars) {
    return ltrim(rtrim(str, chars), chars);
}

function ltrim(str, chars) {
    chars = chars || "\\s";
    return str.replace(new RegExp("^[" + chars + "]+", "g"), "");
}

function rtrim(str, chars) {
    chars = chars || "\\s";
    return str.replace(new RegExp("[" + chars + "]+$", "g"), "");
}

function onSuccess2()
{
	
	parent.parent.frames[1].frames[0].location.reload();
	parent.parent.frames[1].frames[1].location.reload();
	//parent.parent.parent.ExistScheduleDetailFrame.VaccineResult.location.reload();
	parent.parent.parent.ExistScheduleDetailFrame.VaccineTabResult.VaccineResult.location.reload();


	
}

function CheckForSpeChar(event)
{
 var strCheck=
'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
  var whichCode = (window.Event) ? event.which : event.keyCode;
 key = String.fromCharCode(whichCode);  
    if (strCheck.indexOf(key) == -1) 
		return false;  //Not a valid key

}	

function callGrpBy(obj)
{
	/* Added by kishore kumar N on 24-Sept=09 for CRF-691*/
	var incErr = document.getElementById("include_err");
	var include_err = 'N'
	if (incErr.checked)
	{
		include_err = 'Y';
	}
	/*
	 "include_err" This is added to qry string at the end.
	ends here.*/
	var cbSchedule =obj.value;
	var status_ord = document.getElementById("schedule_status").value;
	var vac_sch_ref = document.getElementById("vac_sch_ref").value;
	/* modified by Kishore kumar N on Sept-08-09 for CRF 691*/
	var query_string = parent.parent.parent.ExistScheduleTreeFrame.document.getElementById("query_string").value;
	/*ends here. */
	parent.VaccineResult.location.href='ScheduleVaccinResult.jsp?'+query_string+'&cbSchedule='+cbSchedule+'&status_ord='+status_ord+'&vac_sch_ref='+vac_sch_ref+'&adhoc_yn=N&mode_new=modif&include_err='+include_err;

}

function clearAlergyFields()

{
	/*document.forms[0].vaccine_name1.value="";
	document.forms[0].dose_no.value="";
	document.forms[0].reaction_Date.value="";
	document.forms[0].reaction_code.value="";
	document.forms[0].allergy_remark.value="";
	document.forms[0].allergy_treat.value="";*/			
	var query_string = parent.document.all.query_string.value;
	document.location.href="ScheduleVaccAllegyAddModify.jsp?query_string="+query_string+"&mode_new1=all_rec";
}

function clearAdminFields(status)
{
	

	/*document.forms[0].vaccine_name.value="";
	//document.forms[0].dose_no.value="";
	document.forms[0].batch_no.value="";
	document.forms[0].manufacturer.value="";
	document.forms[0].site_name.value="";
	document.forms[0].Outcome.value="";
	document.forms[0].Outcome1.value="";
	document.forms[0].Outcome.disabled=false;
	document.forms[0].Schedule_date.value="";
	document.forms[0].administer_date.value="";
	document.forms[0].ext_administer.value="";
	document.forms[0].ext_administer.checked=false;
	document.forms[0].ext_facility.value="";
	document.forms[0].administer_by_name.value="";
	document.forms[0].remark_text.value="";*/	
	if(document.forms[0])
	{
		if (status == 'L')
		{
			document.getElementById("ext_facility").value = '';
			document.getElementById("batch_no").value = '';
			document.getElementById("manufacturer").value = '';
			document.getElementById("remark_text").value = '';
			document.getElementById("site_name").selectedIndex = 0;
			document.getElementById("Outcome").value='C';
			document.getElementById("ext_administer").value='Y';
		}
		else {
			var chk=document.forms[0].ext_administer.checked;
			var disable=document.forms[0].ext_administer.disabled;		
			var outcomedis=document.forms[0].Outcome.disabled;
			if(outcomedis==true)
			var val =document.forms[0].Outcome.selectedIndex;
			document.forms[0].reset();	
			if(outcomedis==true)
			document.forms[0].Outcome.selectedIndex=val;
			if(disable != true)
			{		
				if(chk==true)
				{	
					var adhoc_yn =document.getElementById("adhoc_yn").value;
					document.getElementById("ext_administer").value='N';
					document.getElementById("ext_facility").value='';
					document.getElementById("ext_facility").readOnly=true;		
					if(adhoc_yn=='Y')
					{
						document.getElementById("Outcome").disabled=true;
						document.getElementById("Outcome").value='C';
						document.getElementById("Outcome1").value='C';
					}
					else
					{
						document.getElementById("Outcome").disabled=false;
						document.getElementById("Outcome").value='';
						document.getElementById("Outcome1").value='';
					}
					document.getElementById("chkExtFclImg1").style.display='none';
					document.getElementById("chkBatchNoImg").style.display='inline';
					document.getElementById("chkManuImg").style.display='inline';
				}
			}
		}
		
	}
}

function getAdministerName(obj,userName)
{
 
 if (obj.value!="")

 {

	 getAdminister(userName);
 }
 else
 {
	document.forms[0].administer_user_id.value = '';
	document.forms[0].administer_by.value = '';
	document.forms[0].administer_by_name.value = '';
	
  }

}
/* Start Added by Sridhar Reddy on 01082008 */

function doDateTimeChk1(obj)
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
                            if(!chkTime1(time))
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
function chkTime1(time1)
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
                if( (time1.charAt(time1.length-1) )!=":")                
                {
					
                    var time1arr=new Array()
                    time1arr=time1.split(":")

                    if(time1arr.length==2)
                    {
                        var time1hr=time1arr[0]
                        var time1hr1=time1arr[0]
                        var time1min=time1arr[1]
                        var time1min1=time1arr[1]

                        time1hr=eval(time1hr)
                        time1min=eval(time1min)							
                        if(time1hr<=23)
                        {
                            if (time1hr1.length != 2)
                            {
								 retval=false;
                            }
							if(time1min>59 || time1min1.length != 2)
                            {
                                    retval=false;
                            }
                        }
                        else
                                retval=false;
                    }
                    else
                        retval=false;
                }
                else
                        retval=false;
            }
            return retval
        }

/*END Added by Sridhar Reddy on 01082008 */



function deleteSiteName(field)
{
	var selected = field;
	while ( selected.options.length > 0 )
		selected.remove(selected.options[0]);
	//var opt		=	parent.MultiOrdSelAdd.document.createElement("Option");
	var opt		=	top.content.workAreaFrame.VaccinationFrame.VaccinAdminDetailsFrame.document.createElement("Option");
	opt.text	=	"----"+getLabel("Common.defaultSelect.label","COMMON")+"----" ;
	opt.value	=	"";
	field.add(opt);
}
function setOutcome(obj)
{

	document.forms[0].Outcome1.value=obj.value;
	var Outcome_ext = document.forms[0].Outcome_ext.value;
	
	if(obj.value=='N')
	{
		if(Outcome_ext!='C'){
		document.forms[0].batch_no.value='-NA-';		
		document.forms[0].manufacturer.value='-NA-';	//-NA-	
		document.forms[0].batch_no.readOnly=true;		
		document.forms[0].manufacturer.readOnly=true;	
		document.getElementById("administer_date_mand").style.display='none';//IN045200
		}
		else
		{
			
			document.getElementById("remarkMandImg").style.display='none';
			document.getElementById("record").disabled=true;
		}

	}
	else if(obj.value=='C')
	{
		document.forms[0].batch_no.readOnly=false;		
			document.forms[0].manufacturer.readOnly=false;
		document.getElementById("administer_date_mand").style.display='inline';//IN045200			
		if(Outcome_ext!='C'){
		if(document.forms[0].batch_no.value=='-NA-')
		{
			document.forms[0].batch_no.value='';
		}
		if(document.forms[0].manufacturer.value=='-NA-')
		{
			document.forms[0].manufacturer.value='';
		}
		}
		else
		{
			document.getElementById("remarkMandImg").style.display='none';
			document.getElementById("record").disabled=true;
			document.getElementById("remark_text").readOnly=true;
		}

	}
	else if(obj.value=='E')
	{
		document.getElementById("remarkMandImg").style.display='inline';
		document.getElementById("record").disabled=false;
		document.getElementById("remark_text").readOnly=false;
				
	}
	else if(obj.value=='')
	{
		if(Outcome_ext!='C'){
		document.forms[0].batch_no.value='';
		document.forms[0].manufacturer.value='';
		
		}
		else
		{
			document.getElementById("remarkMandImg").style.display='none';
			document.getElementById("record").disabled=true;
			document.getElementById("remark_text").readOnly=true;
		}
	}



}


function chckDate(Object2)
{
	//var localeName="en";
	var localeName="";
	if(parent.VaccinAdminDetailsFrame.document.adminDetailform)
	{
		localeName=parent.VaccinAdminDetailsFrame.document.adminDetailform.locale.value
	}
	
	if(validDateObj(Object2,"DMYHM",localeName)==false){	
		//parent.VaccinAdminDetailsFrame.document.adminDetailform.administer_date.value='';
		//parent.VaccinAdminDetailsFrame.document.adminDetailform.administer_date.select();	
		Object2.select();
		return false;
	}
}
async function record_ErrorDet()
{
	
		var retVal				=  new String();
		//var dialogTop			= "10";
		var dialogHeight		= "29vh" ;
		var dialogWidth			= "21vw" ;
		var features			="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments	= "" ;
		var search_desc="";
		//var title=getLabel("eCA.SpecialitySearch.label","CA");
		var title='Remarks';
		//var sql=" select speciality_code,short_desc from am_speciality where eff_status=`E`";
		
		//search_code="speciality_code";
		//search_desc="short_desc";
		var err_rem = document.forms[0].error_remarks.value;
		retVal=await top.window.showModalDialog("../../eCA/jsp/ScheduleVaccinErrRemarks.jsp?error_remarks="+err_rem,arguments,features);
				
		if(retVal== undefined)
		{
		   retVal="";
		  
		}
		if(retVal!="")
		{
			document.forms[0].Outcome.selectedIndex = 2 ;
			document.getElementById("Outcome1").value='E';
			document.forms[0].error_remarks.value = retVal;
			//document.forms[0].record.disabled =false ;
			record_adminDet();
		}
		else
		{
			document.forms[0].Outcome.selectedIndex = 1 ;
			document.getElementById("Outcome1").value='C';
			document.forms[0].record.disabled =true ;
		}
		//document.forms[0].error_remarks.value = retVal;
		

		
}

function click_ok()
{
	returnVal = document.forms[0].remark_text.value;

	if(returnVal=="")
	{
		alert(getMessage('REMARKS_CANNOT_BLANK','CA'));
		return false;
	}
	
	parent.window.returnValue = returnVal;
	parent.window.close();

}

function showTaskList(qryString)
{
		var viewBy = document.getElementById("sleView").value;
		var To_date = document.getElementById("date_to").value;
		var From_date = document.getElementById("date_from").value;
		To_date = convertDate(To_date,'DMY',localeName,'en');
		From_date = convertDate(From_date,'DMY',localeName,'en');
		/*if (To_date != '' && From_date != '')
		{*/			
			qryString += "&To_date="+To_date;
			qryString += "&From_date="+From_date;
			qryString += "&viewBy="+viewBy;
			parent.parent.VaccineTabResult.PendingRxResultFrm.location.href="../../eCA/jsp/TaskListRightResult.jsp?"+qryString;
			parent.parent.parent.VaccinationFrame.VaccinAdminDetailsFrame.location.href='../../eCommon/html/blank.html';
			parent.parent.parent.VaccinationFrame.VaccineAdminTabFrame.location.href='../../eCommon/html/blank.html';
		/*}
		else
		{	
			
			if (From_date == '' && To_date == '')
			{
				alert(getMessage("FROM_TO_DATE_NOT_BLANK","CA"));
				document.getElementById("date_from").focus();
				return false;
			}
				
			if (From_date == '')
			{
				alert(getMessage("FROM_DATE_NOT_BLANK","CA"));
				document.getElementById("date_from").focus();
				return false;
			}
			
			if(To_date == '' )
			{
				alert(getMessage("TO_DATE_NOT_BLANK","CA"));
				document.getElementById("date_to").focus();
				return false;
			}			
		}*/
		
}
var headTop = -1;
function fixHeadPos()
{
	parTable = document.getElementById("divPatVaccData");
	if (parTable != null)
	{
		headTop = parTable.offsetTop + 3;
		FloatHead1 = document.getElementById("heading");
		FloatHead1.style.position = "relative";
	}
}

function processScroll()
{
	if (headTop < 0)
	{
		fixHeadPos();
		
	}
	if (headTop>0)
	{
		if (document.documentElement && document.documentElement.scrollTop)
			theTop = document.documentElement.scrollTop;
		else if (document.body)
			theTop = document.body.scrollTop;

		if (theTop>headTop)
			FloatHead1.style.top = (theTop-headTop) + 'px';
		else
			FloatHead1.style.top = '0px';
	}
}

async function callMednDetails(patient_id,nursing_unit,patient_class,admin_date){
	admin_date = document.getElementById("date_to").value;	
	/*var dialogHeight	= "40";
	var dialogWidth	= "65"; //modified by Arvind @ 04-12-2008
//	var dialogTop		= "60";
	var dialogTop		= "78";
	var dialogLeft		= "00";
	var center			= "0";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	retVal 				= window.showModalDialog("../../ePH/jsp/QueryMednAdminChart.jsp?patient_id="+patient_id+"&nursing_unit="+nursing_unit+"&admin_date="+admin_date+"&patient_class="+patient_class+"&called_from=MEDADMIN",arguments,features);*/ // commenteed for PMG2014-CRF-0026 [IN:052701]
	var dialogHeight	= "90vh";// Added for PMG2014-CRF-0026 [IN:052701] -start
	var dialogWidth		= "90vw";
	var dialogTop		= "0";
	//dialogWidth		= (window.innerHeight);
	dialogWidth		= "90vw";
	win_width		= (window.innerWidth);	
	if(win_width==undefined){
		dialogHeight		= (document.documentElement.clientHeight);
		dialogWidth		= (document.documentElement.clientWidth);			
		if(dialogWidth==0){				
			dialogHeight		= (parseInt(document.body.clientHeight));
			dialogWidth		= (parseInt(document.body.clientWidth));				
		}			 
	}		
	dialogTop			= "0px"; 
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight+ "; dialogWidth:" + dialogWidth  + "; status: " + status + "; dialogTop :" + dialogTop+";resizable=yes;maximize:yes;minimize:no;";
	var arguments		= "";
	retVal 				= await top.window.showModalDialog("../../ePH/jsp/QueryMednAdminChart.jsp?patient_id="+patient_id+"&nursing_unit="+nursing_unit+"&admin_date="+admin_date+"&patient_class="+patient_class+"&called_from=MEDADMIN",arguments,features);// Added for PMG2014-CRF-0026 [IN:052701]
}


/*
	Added by kishore kumar N on 02-Nov-09, for CRF 0691.1 ,
*/
function calculateBMI()
{
	var height = document.getElementById("txtHeight").value;
	var weight = document.getElementById("txtWeight").value;
	var bmi = getLabel("Common.BMI.label","COMMON");

	if (height != '' && weight != '')
	{
		height = parseInt(height);
		var weight = parseInt(weight);
		document.getElementById("tdBMI").innerText = bmi +'  '+weight/(height * height  * 10000);
	}
	else
	{
		document.getElementById("tdBMI").innerText = bmi;
	}
}

function AllowNumbers()
{	
	var e = event || evt; // for trans-browser compatibility
	var charCode = e.which || e.keyCode;
	if ((charCode < 48 || charCode > 57))
	{
		return false;
	}

	return true;

}

function loadMarkErrPage(vaccSchReff, vaccID, doseNO, vaccine_desc)
{
	var dialogHeight		= "55vh" ;
	var dialogWidth			= "47vw" ;
	var features			="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments	= "" ;
	var search_desc="";	
	var title='Remarks';	
	
	top.window.showModalDialog("../../eCA/jsp/ScheduleVaccinMarkErrMain.jsp?vaccine_desc="+vaccine_desc+"&vaccSchReff="+vaccSchReff+"&vaccID="+vaccID+"&doseNO="+doseNO,arguments,features);
	if (top.content.workAreaFrame.VaccinationFrame)
	{
		top.content.workAreaFrame.VaccinationFrame.location.reload();
	}

	
}

async function fnLinkVaccineCategory(vac_sch_ref, vaccine_id, dose_no, vacc_categ_id, order_id, ord_drug_code,vaccine_desc,linked_sch_yn)
{
	var query_string = document.getElementById("query_string").value;
	var patient_id = document.getElementById("patient_id").value;
	var encounter_id = document.getElementById("encounter_id").value;
	var dialogHeight		= "35" ;
	var dialogWidth			= "55" ;
	var features			="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments	= "" ;
	var search_desc="";	
	var callFrom="";	
	var title='Link Vaccine Schedule';	
	var vacc_category_link = vacc_categ_id+"~"+vaccine_id+"~"+dose_no+"~"+vac_sch_ref;	
	if (order_id == "")	
		callFrom = "CA_IMMU";
	else
		callFrom = "ADMIN_RX";
	var retVal =await window.showModalDialog("../../eCA/jsp/linkedVaccinescheduleMain.jsp?vacc_category_link="+vacc_category_link+"&callFrom="+callFrom+"&order_id="+order_id+"&"+query_string,arguments,features);
	
	if(retVal != undefined && retVal != null)
	{
		retVal = retVal[0].split("~");
		var new_vacc_categ_id= retVal[0];
		var new_vaccine_id= retVal[1];
		var new_dose_no= retVal[2];
		var new_vac_sch_ref= retVal[3];		
		
		var CallFrom = "LINK_VACCINE_SCH";
		var xmlStr ="<root><SEARCH ";			
		xmlStr += "  CallFrom=\""+  CallFrom + "\" ";
		xmlStr += "  PATIENT_ID=\""+  patient_id + "\" ";
		xmlStr += "  VACC_CATEG_ID=\""+  vacc_categ_id + "\" ";
		xmlStr += "  ENCOUNTER_ID=\""+ encounter_id + "\" ";														
		xmlStr += "  VACCINE_ID=\""+ vaccine_id + "\" ";														
		xmlStr += "  DOSE_NO=\""+ dose_no + "\" ";														
		xmlStr += "  VAC_SCH_REF=\""+ vac_sch_ref + "\" ";	
		xmlStr += "  NEW_VACC_CATEG_ID=\""+  new_vacc_categ_id + "\" ";
		xmlStr += "  NEW_VACCINE_ID=\""+ new_vaccine_id + "\" ";														
		xmlStr += "  NEW_DOSE_NO=\""+ new_dose_no + "\" ";														
		xmlStr += "  NEW_VAC_SCH_REF=\""+ new_vac_sch_ref + "\" ";
		xmlStr += "  LINKED_SCH_YN=\""+ linked_sch_yn + "\" ";
		xmlStr += "  ORDER_ID=\""+ order_id + "\" ";
		xmlStr += "  ORD_DRUG_CODE=\""+ ord_drug_code + "\" ";
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","ScheduleImmuInterMediate.jsp?"+query_string,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;	
		eval(responseText);
	}
	if (top.content.workAreaFrame.ExistScheduleDetailFrame)
	{
		top.content.workAreaFrame.ExistScheduleDetailFrame.location.reload();
	}

	if (top.content.workAreaFrame.ExistScheduleTreeFrame)
	{
		top.content.workAreaFrame.ExistScheduleTreeFrame.location.reload();
	}

	if (top.content.workAreaFrame.VaccinationFrame)
	{
		top.content.workAreaFrame.VaccinationFrame.location.reload();
	}
	
}
/*ends here.*/
//IN040377  - Start
function clickLine(chk) {
	if (chk.checked == true) {
		chk.value = 'Y';
	} else {
		chk.value = 'N';
	}
}

function run()
{
	var no_of_checked = 0;
	var formObj = "";
	var vaccine_id ="";
	var vaccine_id_all ="";
	var vaccine_ref ="";
	var vaccine_ref_all ="";
	//IN045410 - Start
	var dose_no ="";
	var dose_no_all ="";
	//IN045410 - End
	
	
	if(parent.VaccineResult && parent.VaccineResult.document.vaccineResult)
		formObj = parent.VaccineResult.document.vaccineResult;
	
	if(formObj){
		for(cnt=0; cnt<formObj.total_recs.value; cnt++){
			val = eval("parent.VaccineResult.document.vaccineResult.chk"+cnt);
			if(val.checked == true){
				val.value = "Y";
				vaccine_id = eval("parent.VaccineResult.document.vaccineResult.vaccine_id"+cnt+".value");
				vaccine_ref = eval("parent.VaccineResult.document.vaccineResult.vac_sch_ref"+cnt+".value");
				dose_no = eval("parent.VaccineResult.document.vaccineResult.dose_no"+cnt+".value"); //IN045410
				
		
				if(no_of_checked==0)
				{
					dose_no_all = "'"+vaccine_ref+"~"+vaccine_id+"~"+dose_no+"'"; //IN045410
				}	
				else	
				{
					dose_no_all = dose_no_all+",'"+vaccine_ref+"~"+vaccine_id+"~"+dose_no+"'" ; //IN045410
				}	
				
				no_of_checked++;
			}
		}
		parent.VaccineResTitle.document.repPatImmun.P_DOSE_NO.value=dose_no_all; //IN045410
		
	}

	if(parseInt(no_of_checked) == 0){
		//alert(getMessage('CLICK_ANY_ONE','OR'));//Commented IN045400
		alert(getMessage('CA_VACC_PRINT','CA')); //IN045400
		return false;
	}else
	{
		//alert(getMessage('GEN_REP','CA'));//IN050829
		if(parent.VaccineResTitle.document.repPatImmun)
		{
			parent.VaccineResTitle.document.repPatImmun.submit() ;
		}
	}
}
//IN040377  - End

