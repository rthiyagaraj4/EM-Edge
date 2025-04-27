/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created

08/11/2011	  IN29177		 Dinesh T	 Changed for the thai language support
27/01/2012	  INO30714		 Menaka V	 THAI screen>View Clinical Event History>View>In the Recorded
										 Clinical Note the name is not displayed in THAI
19/03/2012	  Bru-HIMS-0154	 Menaka V	 The View Future Bookings/Appointments hyperlink will be visible for the patient in Chart summary
										 only if the patient has got any future bookings/Appointments.
05/04/2012	  IN031989		MenakaV	 	 When a patient is selected by using patient without encounter search function and when clinical
										 event history is accessed the note header is incomplete for all the existing notes for that patient.
20/06/2012	  IN033489		Menaka V	 Report header blank in clinical event history.										
06/12/2012   IN030466     Karthi L		CRF-025 Based on the access rights, practitioner can Record and update the Clinical Studies content in CA Patient Chart Menu									
12/7/2012 	  IN036617		vijayakumark Record Clinical Studies for the patient->Clinical Studies/Research category icon is not displayed in the Patient Context Banner even after refreshing the Patient Chart.
12/02/2013	IN030459	  Karthi L	 	To show diagnosis list with the encounter information in Chart Summary
21/02/2013    IN037950    Nijitha S     CRF-CA- CHL-CRF-0015/01- Referral Summary Widget->Referral Notes containing special characters cannot be viewed
02/06/2014	IN037701	 Nijitha			SKR-CRF-0036
16/06/2014  IN049663	 Nijitha		HSA_ADHOC_0010	
11/9/2014	IN050584	Nijitha 		Age component showing wrong age for deceased patient.
9/12/2014	IN052796		Nijitha			ML-BRU-SCF-1481
-----------------------------------------------------------------------------------------------------------------------
Date		Edit History	 Name			Rev.Date		Rev.Name		Description
-----------------------------------------------------------------------------------------------------------------------
29/02/2016	IN057106_changed Vijayakumar K		29/02/2016		Ramesh Goli		ML-MMOH-CRF-0328 files created newly
28/06/2018	IN065341	Prakash C		29/06/2018		Ramesh G		MMS-DM-CRF-0115
30/07/2019	IN070610		Dinesh T		30/07/2019		Ramesh G		TBMC-CRF-0011.1
23/03/2023	   38981        Krishna Pranay   23/03/2023     Ramesh G     ML-MMOH-CRF-1986
30/03/2023    42995        Krishna Pranay   30/03/2023     Ramesh G    CA-ML-MMOH-CRF-1986
05/04/2023    43287        Krishna Pranay   05/04/2023     Ramesh G    CA-ML-MMOH-CRF-1986
-----------------------------------------------------------------------------------------------------------------------
*/
var g_insert_record = ""; //IN030466
var g_update_record = ""; //IN030466
function ResearchRecord()
{ 
	var obj = top.content.workAreaFrame.ResearchPatientRecordframe.document.ResearchPatientRecordfrm.research_desc;
	var index = obj.selectedIndex; 
	var val = obj.options[index].value;
	top.content.workAreaFrame.ResearchPatientRecordframe.document.ResearchPatientRecordfrm.research_id.value = val;
	var check = top.content.workAreaFrame.ResearchPatientRecordframe.document.ResearchPatientRecordfrm.enabled.value;
	
	var mode = top.content.workAreaFrame.ResearchPatientRecordframe.document.ResearchPatientRecordfrm.mode.value; // added for CRF-025  IN030466
	if(top.content.workAreaFrame.ResearchPatientRecordframe.document.ResearchPatientRecordfrm.start_date.disabled == true)
		top.content.workAreaFrame.ResearchPatientRecordframe.document.ResearchPatientRecordfrm.start_date.disabled = false;	

	if(check == "D")
	{
		
		//var fields = new Array (top.content.workAreaFrame.ResearchPatientRecordframe.document.ResearchPatientRecordfrm.research_desc,top.content.workAreaFrame.ResearchPatientRecordframe.document.ResearchPatientRecordfrm.remarks,top.content.workAreaFrame.ResearchPatientRecordframe.document.ResearchPatientRecordfrm.start_date); Commented for IN030466 - CRF-025
		
		var fields = new Array (top.content.workAreaFrame.ResearchPatientRecordframe.document.ResearchPatientRecordfrm.research_desc,top.content.workAreaFrame.ResearchPatientRecordframe.document.ResearchPatientRecordfrm.res_categ_risk_factor,top.content.workAreaFrame.ResearchPatientRecordframe.document.ResearchPatientRecordfrm.remarks,top.content.workAreaFrame.ResearchPatientRecordframe.document.ResearchPatientRecordfrm.start_date); // IN030466 - CRF-025
		
		//var names = new Array ( getLabel("eCA.ResearchDescription.label",'CA'),getLabel("Common.remarks.label",'COMMON'),getLabel("Common.StartDate.label",'COMMON'));  Commented for IN030466 - CRF-025
		
		var names = new Array ( getLabel("eCA.ResearchPatientCategory.label",'CA'),getLabel("eCA.ResearchCategoryFactor.label",'CA'),getLabel("Common.remarks.label",'COMMON'),getLabel("Common.StartDate.label",'COMMON')); // IN030466 - CRF-025
		
		if(checkFields( fields, names,top.content.messageFrame))
		{
			getAccessRightsForUser(); //IN030466
			//document.ResearchPatientRecordfrm.submit(); commented for IN030466
			if((mode == "insert" && g_insert_record == "Y" ) || (mode == "modify" && g_update_record == "Y" ))
			{
				document.ResearchPatientRecordfrm.submit();
			}
			else
			{
				if(mode == "insert")
				{
					alert(getMessage("CHECK_INSERT_ACCESS","CA"));
				}
				else if (mode == "modify")
				{
					alert(getMessage("CHECK_UPDATE_ACCESS","CA"));
				}
			}
					
		}  
	}
	else
	{
		//var fields = new Array (top.content.workAreaFrame.ResearchPatientRecordframe.document.ResearchPatientRecordfrm.research_desc,top.content.workAreaFrame.ResearchPatientRecordframe.document.ResearchPatientRecordfrm.remarks,top.content.workAreaFrame.ResearchPatientRecordframe.document.ResearchPatientRecordfrm.start_date,top.content.workAreaFrame.ResearchPatientRecordframe.document.ResearchPatientRecordfrm.close_date); // Commented for IN030466 CRF-025
		
		var fields = new Array (top.content.workAreaFrame.ResearchPatientRecordframe.document.ResearchPatientRecordfrm.research_desc,top.content.workAreaFrame.ResearchPatientRecordframe.document.ResearchPatientRecordfrm.res_categ_risk_factor,top.content.workAreaFrame.ResearchPatientRecordframe.document.ResearchPatientRecordfrm.remarks,top.content.workAreaFrame.ResearchPatientRecordframe.document.ResearchPatientRecordfrm.start_date,top.content.workAreaFrame.ResearchPatientRecordframe.document.ResearchPatientRecordfrm.close_date); // IN030466 - CRF-025
		
		//var names = new Array ( getLabel("eCA.ResearchDescription.label",'CA'),getLabel("Common.remarks.label",'COMMON'),getLabel("Common.StartDate.label",'COMMON'),getLabel("eCA.CloseDate.label",'CA')); //IN030466 - CRF-025
		
		var names = new Array ( getLabel("eCA.ResearchDescription.label",'CA'),getLabel("eCA.ResearchCategoryFactor.label",'CA'),getLabel("Common.remarks.label",'COMMON'),getLabel("Common.StartDate.label",'COMMON'),getLabel("eCA.CloseDate.label",'CA')); // IN030466 - CRF-025

		if(checkFields( fields, names,top.content.messageFrame))
		{
			getAccessRightsForUser(); //IN030466
			//document.ResearchPatientRecordfrm.submit(); commented for IN030466
			if((mode == "insert" && g_insert_record == "Y" ) || (mode == "modify" && g_update_record == "Y" ))
			{
				document.ResearchPatientRecordfrm.submit();
			}
			else
			{
				if(mode == "insert")
				{
					alert(getMessage("CHECK_INSERT_ACCESS","CA"));
				}
				else if (mode == "modify")
				{
					alert(getMessage("CHECK_UPDATE_ACCESS","CA"));
				}
			}
		}
	}
}

function ResearchClosefunc(obj)
{
	if(!obj.checked)
	{
		document.ResearchPatientRecordfrm.close_date.value="";
		document.getElementById("calc").disabled=true;
		document.getElementById("img1").style.display="none";
		document.ResearchPatientRecordfrm.close_date.disabled=true;
		document.ResearchPatientRecordfrm.enabled.value = "D";
	}
	else
	{
		document.getElementById("img1").style.display="inline";
		document.ResearchPatientRecordfrm.close_date.disabled=false;
		document.getElementById("calc").disabled=false;
		document.ResearchPatientRecordfrm.enabled.value = "E";
	}
}

function ResearchClear()
{
	var mode = top.content.workAreaFrame.ResearchPatientRecordframe.document.ResearchPatientRecordfrm.mode.value;

	if(mode == "insert")
	{
		top.content.workAreaFrame.ResearchPatientRecordframe.document.ResearchPatientRecordfrm.reset();
	}
	else
	{
		var patient_id = top.content.workAreaFrame.ResearchPatientRecordframe.document.ResearchPatientRecordfrm.patient_id.value;
		location.href='../../eCA/jsp/ResearchPatientRecord.jsp?mode=insert&patient_id='+patient_id;
	}

	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}

function ResearchCancel()
{
	top.content.workAreaFrame.location.href="../../eCommon/html/blank.html";
}

function showCalendarValidate(str)
{
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}

//Functions for the file name GeneticMarkersDisplay.jsp-start
async function showRemarks(patient_id,research_categ_id,start_date)
{
	var dialogHeight	= "10" ;
	var dialogWidth	= "30" ;
	var status = "no";
	var scroll = "yes";
	var dialogTop = "140";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;	
	retVal 			= await window.showModalDialog('../../eCA/jsp/ResearchPatientRemarksDialog.jsp?patient_id='+patient_id+'&research_categ_id='+research_categ_id+'&start_date='+start_date,arguments,features); 
	
}

//Functions for the file name ResearchPatientQueryResult.jsp-start
async function showRemarksResearchPatient(patient_id,research_categ_id,research_categ_fact_id,start_date)// additional parameter research_categ_fact_id added for CRF-025
{
	var dialogHeight	= "10" ;
	var dialogWidth	= "30" ;
	var status = "no";
	var scroll = "yes";
	var dialogTop = "140";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;	
	//retVal 			= window.showModalDialog('../../eCA/jsp/ResearchPatientRemarksDialog.jsp?patient_id='+patient_id+'&research_categ_id='+research_categ_id+'&start_date='+start_date,arguments,features); // commented for CRF-025
	retVal 			= await window.showModalDialog('../../eCA/jsp/ResearchPatientRemarksDialog.jsp?patient_id='+patient_id+'&research_categ_id='+research_categ_id+'&research_categ_fact_id='+research_categ_fact_id+'&start_date='+start_date,arguments,features); // modified for CRF-025
}
function scrollTitle()
{
	var y = top.content.workAreaFrame.ResearchPatientQueryframe.document.body.scrollTop;

	if(y == 0)
	{
		top.content.workAreaFrame.ResearchPatientQueryframe.document.getElementById("divDataTitle").style.position = 'static';
		top.content.workAreaFrame.ResearchPatientQueryframe.document.getElementById("divDataTitle").style.posTop  = 0;
	}
	else
	{
		top.content.workAreaFrame.ResearchPatientQueryframe.document.getElementById("divDataTitle").style.position = 'relative';
		top.content.workAreaFrame.ResearchPatientQueryframe.document.getElementById("divDataTitle").style.posTop  = y-2;
	}
}

function alignWidth()
{
	var totalRows =  top.content.workAreaFrame.ResearchPatientQueryframe.document.getElementById("dataTable").rows.length;
	var counter = totalRows-1;
	var temp = top.content.workAreaFrame.ResearchPatientQueryframe.document.getElementById("dataTitleTable").rows[0].cells.length;
	
	for(var i=0;i<temp;i++) 
	{
		top.content.workAreaFrame.ResearchPatientQueryframe.document.getElementById("dataTitleTable").rows[0].cells[i].width=top.content.workAreaFrame.ResearchPatientQueryframe.document.getElementById("dataTable").rows[counter].cells[i].offsetWidth;
	}
}

//Functions for the file name ResearchPatientQueryResult.jsp-end
//Functions for the file name ResearchPatientRecord.jsp-start
function msgframereload()
{
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}

function Checkrmks(obj)
{
	if(obj.value == "")
	{
		document.forms[0].remarks.value="";
	}
}

/*function CheckCloseDate(obj)
{
	if(obj.value.length>0)
	{
		var close = obj.value;
		var start = top.content.workAreaFrame.ResearchPatientRecordframe.document.forms[0].start_date.value;
		var sys = top.content.workAreaFrame.ResearchPatientRecordframe.document.forms[0].sys_date.value;


		var closeArry = close.split("/");
		var startArry = start.split("/");
		var sysArry =sys.split("/");
		var close_date = new Date(closeArry[0],closeArry[1],closeArry[2]);
		var start_date = new Date(startArry[0],startArry[1],startArry[2]);
		var sys_date = new Date(sysArry[0],sysArry[1],sysArry[2]);


		if(Date.parse(start_date) > Date.parse(close_date)) 
		{	alert("hi");
			alert( "APP-SM0043 Close Date should be greater than or equal to the Start date " );
			obj.select();
			obj.focus();
			return false;
		}else 
			if(Date.parse(close_date) > Date.parse(sys_date))
		{
			alert( "APP-SM0043 Close Date cannot be greater than current date  " );
			obj.select();
			obj.focus();
			return false;
		}
	}
}*/

function CheckCloseDate1(obj)
{
	if(obj.value.length>0)
	{
		CheckDate(obj);
		/*if(doDateCheckAlert(document.forms[0].start_date,document.forms[0].end_date)==false) {
				alert(getMessage("TO_DT_GR_EQ_FM_DT"));
				to.select();
				to.focus();
			  } */

		if(!doDateCheck1(obj,document.forms[0].close_date))
		{
			
			alert(getMessage("STARTDT_LESS_ENDDT",'CA'));
			//obj.select();
			obj.value="";
			obj.focus();					
		}
        
	/*	if(!doDateCheck1(obj,document.forms[0].sys_date))
		{
			var msg=getMessage("DATE_GREATER_SYSDATE");
			alert(msg);
			obj.select();
			obj.focus();
		}
		*/
	}
}

/*
function CheckCloseDate(obj)
{
	if(obj.value.length>0)
	{
		CheckDate(obj);
		/*if(doDateCheckAlert(document.forms[0].start_date,document.forms[0].end_date)==false) {
				alert(getMessage("TO_DT_GR_EQ_FM_DT"));
				to.select();
				to.focus();
			  } 
		if(!doDateCheck1(document.forms[0].start_date,obj))
		{
			alert(getMessage("STARTDT_LESS_ENDDT",'CA'));
			obj.select();
			obj.focus();					
		}
        
	/*	if(!doDateCheck1(obj,document.forms[0].sys_date))
		{
			var msg=getMessage("DATE_GREATER_SYSDATE");
			alert(msg);
			obj.select();
			obj.focus();
		}
		
	}
}*/

function CheckCloseDate(fromDate,toDate,currDate,format,locale)
{
	if((!fromDate.value==""))
	{	
		if(!CheckDate(fromDate))
			return false;
		else
		{
			if(!isBeforeNow(fromDate.value, format, locale))
			{			
				alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
				//fromDate.select();
				fromDate.value="";
				fromDate.focus();
				return false;
			}
			else
			{	
				if((!toDate.value==""))
				{
					if(!CheckDate(toDate))
						return false;
					else
					{
						if(isBeforeNow(toDate.value, format, locale))
						{
							if(isAfter(toDate.value, fromDate.value, format, locale))
								return true;
							else
							{
								alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
								//toDate.focus();
								toDate.value="";
								return false;
							}
						}
						else
						{
							alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
							//toDate.select();
							toDate.value="";
							toDate.focus();
							return false;
						}
					}
				}
			}
		}
	}
	else
	{
		if((!toDate.value==""))
		{
			if(!isBeforeNow(toDate.value, format, locale))
			{
				alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
				toDate.select();
				toDate.focus();
				return false;
			}
		}
	}
}	 

function doDateCheck1(from,to,messageframe,val) 
{
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;

	if(fromdate.length > 0 && todate.length > 0 ) 
	{
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);	

		if(Date.parse(todt) < Date.parse(fromdt)) 
		{
			
			if(val=="1")  
			{
				alert(getMessage("FROM_DATE_GREAT_EFF",'CA'));
				to.select();
				to.focus();
			}
			else if(val=="2") 
			{
				alert(getMessage("TO_DATE_LESS_EFF_DATE",'CA'));
				from.select();
				from.focus();
			}
			else if(val=="3")
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT",'CA'));
				to.select();
				to.focus();
			}
			else if(val=="4")
			{
				alert(getMessage("FROM_DATE_GREAT_SYS",'CA'));
				to.select();
				to.focus();
			}
			else if(val=="5")
			{
				alert(getMessage("END_DATE_VALIDATION",'CA'));
				to.select();
				to.focus();
			}
			return false;
		}
		else if(Date.parse(todt) >= Date.parse(fromdt)) 
			return true;
	}	
	return true;
}
  
//Functions for the file name ResearchPatientRecord.jsp-end
function refresh()
{
//IN036617 starts here
if(top.plineFrame != null)
{
top.plineFrame.location.reload();
}
////IN036617 ends here
	top.content.workAreaFrame.location.reload();
}
 
function scrollTitleImmunization()
{
	var y = parent.MedicalEventsResultFrame.document.body.scrollTop;

	if(y == 0)
	{
		parent.MedicalEventsResultFrame.document.getElementById("divDataTitle").style.position = 'static';
		parent.MedicalEventsResultFrame.document.getElementById("divDataTitle").style.posTop  = 0;
	}
	else
	{
		parent.MedicalEventsResultFrame.document.getElementById("divDataTitle").style.position = 'relative';
		parent.MedicalEventsResultFrame.document.getElementById("divDataTitle").style.posTop  = y-2;
	}  
}

function showToolTip(obj,authorizeyn)
{
	var displayText = '<table cellpadding=0 cellspacing=0 border=0><td class=YELLOW>'
	if(authorizeyn == 'Y')
	{
		displayText += getLabel("eCA.ClicktoNormalize.label","CA");
	}
	else
	{
		displayText += getLabel("eCA.ClicktoAuthorize.label","CA");
	}

	displayText += '</td></table>';
	/*document.getElementById("authorizeMode").innerHTML = displayText;
	document.getElementById("authorizeMode").style.top  = obj.offsetTop+25; 
	document.getElementById("authorizeMode").style.left  = obj.offsetLeft-20 ;
	document.getElementById("authorizeMode").style.visibility='visible' ;*/
	
	document.getElementById("authorizeMode").innerHTML = displayText;

    // Position the tooltip below the sensitive element (obj)
    var objRect = obj.getBoundingClientRect();  // Get element's position relative to the viewport
    var tooltip = document.getElementById("authorizeMode");

    // Adjust tooltip position below the obj element
    tooltip.style.top = (objRect.bottom + window.scrollY + 5) + "px"; // 5px below the obj
    tooltip.style.left = (objRect.left + window.scrollX - 20) + "px"; // Align left, with an offset for margin

    // Make the tooltip visible
    tooltip.style.visibility = 'visible';
}


function hideToolTip()
{
	document.getElementById("authorizeMode").style.visibility='hidden' ;
}

//function getText(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode)//IN031989
//function getText(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,enctr_id,fac_id)//IN031989//IN033489
async function getText(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,enctr_id,fac_id,RepDb,clob_data)//IN065341
{
	//IN037701 Starts
	//var patient_id = document.forms[0].patient_id.value;//INO30714
	var patient_id="";
	if(undefined != document.forms[0] && undefined!=document.forms[0].patient_id)
		patient_id = document.forms[0].patient_id.value;//IN050584
	else
		patient_id = document.getElementById("patient_id").value;//IN050584
	//IN037701 Ends
	//var enc_id = document.forms[0].enc_id.value;//INO30714
	var win_height		= "95vh";
	var win_width		= "80vw";
	var win_scroll_yn	= "yes";

	if(Histrectype != 'CLNT')
	{
		win_height		= "95vh";
		win_width		= "80vw";
		//win_scroll_yn	= "no";
	} 

	var retVal = new String();
	var dialogHeight = win_height ;
	var dialogWidth = win_width ;
	var dialogTop = "";
	var status = "no";
	var scroll = win_scroll_yn;
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll+";dialogTop :" + dialogTop;
	var arguments	= Accessionnum ;
	Accessionnum	=	escape(Accessionnum);
	//var finalString	= "Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode+"&patient_id="+patient_id+"&enc_id="+enc_id;//INO30714
	//var finalString	= "Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode+"&patient_id="+patient_id+"&enc_id="+enctr_id+"&fac_id="+fac_id;//IN031989//IN033489
	var finalString	= "Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode+"&patient_id="+patient_id+"&enc_id="+enctr_id+"&fac_id="+fac_id;//IN065341
	//retVal = window.showModalDialog("../../eCA/jsp/FlowSheetText.jsp?Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode,arguments,features);//INO30714
	if((RepDb != undefined && RepDb != "undefined")&&(clob_data != undefined && clob_data != "undefined")){
		finalString=finalString+"&RepDb="+RepDb+"&clob_data="+clob_data ;
	}
	retVal = await top.window.showModalDialog("../../eCA/jsp/FlowSheetText.jsp?"+finalString,arguments,features);//INO30714
	return false;
}

async function ShowComments(resultStr)
{
	var comments;
	var retVal;
	var dialogHeight ='50vh' ;
	var dialogWidth = '50vw' ;
	var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	retVal 			= await window.showModalDialog('../../eCA/jsp/ResComments.jsp?resultStr='+encodeURIComponent(resultStr),arguments,features);//IN29177
}

async function showEncounterDialog(encounter_id,from_date,to_date,facilityId)
{
	var patient_id		=	document.forms[0].patient_id.value;
	var Encounter_Id	=	document.forms[0].Encounter_Id.value;
	var p_called_from_widget	=	document.getElementById("p_called_from_widget").value;//IN049663 
	var dialogTop			= "";
	var dialogHeight	=	"85vh";
	var dialogWidth		=	"85vw";
	var action_url		=	'../../eCA/jsp/EncounterInDialog.jsp?patient_id='+patient_id+'&encounter_id='+encounter_id+'&from_date='+from_date+'&to_date='+to_date+'&facilityId='+facilityId+'&p_called_from_widget=CA_RESULT_ENCT_WIDGET';//IN049663 //IN052796
	var arguments		=	"" ;
	var features		=	"dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no ;status:no";
	retVal				=	await top. window.showModalDialog(action_url,arguments,features);
}

//function viewReferral(ref)IN065341
async function viewReferral(ref,RepDb,called_from,clob_data,facilityId,patientId,encounterId)//IN065341
{
	var retVal = 	new String();
	var dialogHeight= "80vh" ;
	var dialogTop = "" ;
	var dialogLeft = "0" ;
	var dialogWidth	= "80vw";
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ; dialogTop:" + dialogTop + " ;dialogLeft:" + dialogLeft + "; scroll=no; status:" + status ;
	//var retVal = window.showModalDialog("../../eMP/jsp/ViewPatReferral.jsp?referral_id="+ref,arguments,features);
	var retVal = await top.window.showModalDialog("../../eMP/jsp/ViewPatReferral.jsp?referral_id="+ref+"&RepDb="+RepDb+"&called_from="+called_from+"&clob_data="+clob_data+"&facilityId="+facilityId+"&patientId="+patientId,arguments,features);
	return false;
}
String.prototype.replaceAll=function(s1, s2) {return this.split(s1).join(s2)}//IN038340
async function ref_notes(notes)
{
	var dialogHeight= "60vh" ;
	var dialogWidth = "60vw" ;
	var dialogTop = "280" ;
	var dialogLeft = "90" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";dialogTop:" + dialogTop + " ;dialogLeft:" + dialogLeft + ";status=no;scroll=no" ;
	//var arguments	= notes;//IN037950
	var temp=notes;
	var arr =new Array();
	notes = notes.replaceAll("+","%20");//IN038340
	notes=decodeURIComponent(notes);//IN037950

	for(var i=0; i<notes.length;i++)
		notes = notes.replace("~","\n");//IN037950
		//notes = notes.replace("~","");//IN037950
	
	var arguments	= notes;
	var retVal = await window.showModalDialog("../../eMP/jsp/Referral_Notes.jsp?from=search&ref_comp=viewpat",arguments,features);
}

//function showAllChartSummaryReferralInfo(patient_id,title)//IN065341
async function showAllChartSummaryReferralInfo(patient_id,title,called_from,clob_data,RepDb)//IN065341
{
	var dialogHeight	= "90vh" ;
	var dialogWidth	= "80vw" ;
	var status = "no";
	var scroll = "yes";
	var dialogTop = "";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
	//retVal 			= window.showModalDialog('../../eCA/jsp/ChartSummayReferralInfo.jsp?patient_id='+patient_id+'&modal_yn=Y'+'&title='+encodeURIComponent(title,"UTF-8"),arguments,features);//IN065341
	retVal 			= await top.window.showModalDialog('../../eCA/jsp/ChartSummayReferralInfo.jsp?patient_id='+patient_id+'&modal_yn=Y'+'&title='+encodeURIComponent(title,"UTF-8")+'&title='+encodeURIComponent(title,"UTF-8")+'&called_from='+called_from+'&clob_data='+clob_data+'&RepDb='+RepDb,arguments,features);//IN065341
}
//Bru-HIMS-0154 Starts
async function showFutureAppointments(patient_id)
{
	var retVal = 	new String();
	var dialogHeight= "80vh" ;
	var dialogWidth	= "80vw" ;
	var status = "no";
	var dialogTop = "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scrollWidth=yes; status: " + status+"; dialogTop :" + dialogTop ;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eOA/jsp/BookAppointmentOther.jsp?patient_id="+patient_id+"&calling_from=IP",arguments,features);
}
	//Bru-HIMS-0154 Ends	
//added by LK CRF-025 / IN030466 - Start
	
function getResCategRiskFact(){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += " p_research_category=\""+ document.forms[0].research_desc.value + "\" ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml") ;
	xmlHttp.open( "POST", "AccessRightForResearchStudiesValidate.jsp", false );
	xmlHttp.send(xmlDoc) ;
	responseText = xmlHttp.responseText ;
		eval(responseText);
}
function addResearchFactorsList(code,desc)
{
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = desc ;	
	eval("document.forms.ResearchPatientRecordfrm.res_categ_risk_factor.add(element)");		
}
function clearResearchFactorsList() 
{
	eval("document.forms.ResearchPatientRecordfrm.res_categ_risk_factor.length=0");
	var tp = getLabel("Common.defaultSelect.label","Common");
	var element = document.createElement('OPTION') ;
	element.value = "" ;
	element.text = "------------------"+tp+"--------------" ;	
	eval("document.forms.ResearchPatientRecordfrm.res_categ_risk_factor.add(element)");		
} 
function getAccessRightsForUser()
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += " p_research_category=\""+ document.forms[0].research_desc.value + "\" ";
	xmlStr += " p_research_categ_factor=\""+ document.forms[0].res_categ_risk_factor.value + "\" ";
	xmlStr += " p_practitioner=\""+document.forms[0].practitioner_id.value+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml") ;
	xmlHttp.open( "POST", "ResearchPatientRecordValidate.jsp", false );
	xmlHttp.send(xmlDoc) ;
	responseText = xmlHttp.responseText ;
		eval(responseText);
}
function addAccessRights(record,update)
{
	
	g_insert_record = record;
	g_update_record = update;
	
}

//IN030466 - END
// added for IN030459 CRF-018 - Start
async function showEncounterDialogList(encounter_id,from_date,to_date,facilityId,patient_id)
{
	var dialogTop			= "";
	var dialogHeight	=	"95vh";
	var dialogWidth		=	"95vw";
	var action_url		=	'../../eCA/jsp/EncounterInDialog.jsp?patient_id='+patient_id+'&encounter_id='+encounter_id+'&from_date='+from_date+'&to_date='+to_date+'&facilityId='+facilityId;
	var arguments		=	"" ;
	var features		=	"dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no ;status:no";
	retVal				=	await top.window.showModalDialog(action_url,arguments,features);
} 
async function showLinkedEncounters(patient_id,term_set_id,diag_code,content_id)
{	
	var dialogHeight	= "90vh" ;
	var dialogWidth	= "95vw" ;
	var status = "no";
	var scroll = "yes";
	var dialogTop = "";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;	
	retVal 			= await top.window.showModalDialog('../../eCA/jsp/ChartSummaryActiveProblemsEncDetails.jsp?patient_id='+patient_id+'&term_set_id='+term_set_id+'&diag_code='+diag_code+'&content_id='+content_id,arguments,features); 
}
// added for IN030459 CRF-018 - END
//IN057106_changed starts
async function getAntibodyResults(patient_id)
{
	
	var dialogHeight	= "20" ;
	var dialogWidth	= "30" ;
	var status = "no";
	var scroll = "yes";
	var dialogTop = "140";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;	
	retVal 			=await  window.showModalDialog('../../eCA/jsp/CAAnitbodyResultsMain.jsp?p_patient_id='+patient_id,arguments,features); 
}
//IN057106_changed ends
//ML-MMOH-CRF-0898.1 starts 
async function birth(callingfrom,patient_id,encounter_id,visit_adm_date,patient_class,Locn_Code,facilityId){
	var retVal;
	var dialogHeight= "600";
	var dialogWidth	= "500";
	var status = "no";
	var arguments	= "";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=yes; status:" + status;
	var action_url;
	var contr_oth_accession_num=facilityId+"$"+patient_id+"$"+encounter_id; 
	action_url	=	"../../eCA/jsp/RecClinicalNotesModal.jsp?function_id=BIRTH_REG_NOTES&appl_task_id=BIRTH_REG_NOTES&patient_id="+patient_id+"&encounter_id="+encounter_id+"&visit_adm_date="+visit_adm_date+"&patient_class="+patient_class+"&location_code="+Locn_Code+"&facility_id="+facilityId+"&callingfrom="+callingfrom+"&called_from=ViewCharSummary&contr_oth_accession_num="+contr_oth_accession_num; // modified senthil
	
	var title="";
	retVal=await window.showModalDialog(action_url,arguments,features);
}
//ML-MMOH-CRF-0898.1 end 

//IN070610, starts
function uploadedDocuments(accession_num, discr_msr_panel_id){	
	window_id = window.open("../../eOR/jsp/ImageVideosFileUploadMain.jsp?p_called_from=View&p_acc_no="+accession_num+"&p_discr_msr_panel_id="+discr_msr_panel_id,'',"height=700,width=700,top=80,left=130,resizable=yes,directories=no,location=no,menubar=no,status=no");
}
//IN070610, ends


/*//38981 start
function ShowRemarksDiag(curr_remarks) {
	var retVal;
	var dialogTop		= "310";
 	var dialogHeight	= "14" ;
 	var dialogWidth		= "28" ;
	var dialogLeft		= "240" ;
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=no; status=no';
 	var arguments		= "";
 	retVal 				= window.showModalDialog("../../eCA/jsp/ShowRemarksFrame.jsp?curr_remarks="+curr_remarks,arguments,features);
 
} //38981 end
*/

//42995 start
async function ShowRemarksDiag(patientid,diag_code,term_set_id,term_code_short_desc,occur_srl_no)  //42995
{	
	var dialogHeight= "10" ;
    var dialogWidth = "30" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	var title="Remark";
	var arg = "";
	//window.showModalDialog("../../eCA/jsp/ShowRemarksFrame.jsp?curr_remarks="+encodeURIComponent(curr_remarks)+"&patient_id="+patientid+"&diag_code="+diag_code+"&term_set_id="+term_set_id+"&term_code_short_desc="+term_code_short_desc+"&occur_srl_no="+occur_srl_no+"&title="+encodeURIComponent(title),arg, features );
	await window.showModalDialog("../../eCA/jsp/ShowRemarksFrame.jsp?patient_id="+patientid+"&diag_code="+diag_code+"&term_set_id="+term_set_id+"&term_code_short_desc="+term_code_short_desc+"&occur_srl_no="+occur_srl_no+"&title="+encodeURIComponent(title),arg, features );//43287
}//42995 end

//38981 start
async function ShowSupportingDiag(diag_code,occur_srl_no,patientid,term_set_id,title)
{
	var dialogHeight= "15" ;
    var dialogWidth = "35" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	await window.showModalDialog("../../eCA/jsp/ShowSupportingFrame.jsp?diag_code="+diag_code+"&title="+encodeURIComponent(title)+"&occur_srl_no="+occur_srl_no+"&patient_id="+patientid+"&term_set_id="+term_set_id,arguments,features);
}
//38981 end
//70705 start
async function menstHistDtl(patient_id, facility_id)
{
	var dialogHeight= "70vh" ;
    var dialogWidth = "50vw" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	await window.showModalDialog("../../eCA/jsp/CAMenstrualHistDtlResultView.jsp?patient_id="+patient_id+"&facility_id="+facility_id,arguments,features);
}//70705 End
