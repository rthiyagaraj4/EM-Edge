/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
---------------------------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           created
27/01/2012	  INO30714		Menaka V	 THAI screen>View Clinical Event History>View>In the Recorded
										 Clinical Note the name is not displayed in THAI
01/02/2012	  IN030859		Menaka V	CA>HTML code is displayed if we view the recorded Chief complaints in
										Clinical Events History and Chart Summary.
05/04/2012	  IN031989		MenakaV	 	When a patient is selected by using patient without encounter search function and when clinical
										event history is accessed the note header is incomplete for all the existing notes for that patient.
18/05/2012	  IN032794			Menaka V	Clinical Event History>View Mode- Flow Sheet>when we click on More values to view other recording
										of the Note for the same time we get Java Exception Error.	
20/06/2012	IN033489		Menaka V		Report header blank in clinical event history.		
28/05/2013	IN037793		Karthi L	To be able to view the Specimen image attachment in 'Existing Orders' function and 'Clinical Event History' function in OR and CA.
06/09/2013	IN034512		Karthi L	A print Option existed next to Close Button in Clinical Event History.										
17/09/2013	IN043274		Karthi L  	While printing a radiology resulted note from Clinical Event History>Flow sheet, it printed as empty 							
26/05/2015	IN052637		Ramesh G	Maximise option for clinical event history view window						
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------		
04/11/2015	IN057138		Karthi L										Chief Complaint ( Long Text ) which has been recorded  from the Manage Patient ...										
11/11/2015	IN057113		Karthi L							 			ML-MMOH-CRF-0335 - IN057113								
12/17/2015  IN058156		Prathyusha					        			Once encounter is closed, there is no way for the user to check if the clinical notes in
                                                                            the event history has been forwarded or modified by another practitioner.  
11/01/2016	IN58138			Karthi L										Need to provide an alternative view to enable the quicksheet view by event and not by group.
18/01/2016	IN58886			Karthi L										Search,Clear and More Criteria buttons are truncated in View Clinical Event History Screen.
05/02/2016	IN004500		Raja S											GHL-SCF-1000
07/10/2016	IN047572		Karthi L										[MMS-QH-CRF-0177]To provide attending doctor and specialty  filter in the ?View Clinical Notes? and ?Clinical Event History?
11/05/2017	IN064071		Krishna Gowtham		11/05/2017		Ramesh G 	Alpha - CA-Clinical Event History-Flow sheet View-System does not display the 
08/01/2018	IN064446		Raja S			08/01/2018		Ramesh G	GHL-CRF-0469
18/04/2018	IN061884		Raja S			18/04/2018		Ramesh G		ML-MMOH-CRF-0536
03/06/2018	IN067842		Raja S			03/06/2018		Ramesh G		CA-ML-MMOH-CRF-0536-US007/02
06/06/2018	IN067806		Raja S			06/06/2018		Ramesh G		MO-CRF-20144
31/07/2018	IN065341		Prakash C		31/07/2018		Ramesh G	MMS-DM-CRF-0115		
31/08/2018  	IN068080		Sharanraj		31/08/2018   		Ramesh G	MMS-ICN-00091
16/10/2018  	IN0068145		Raja S		16/10/2018   		Ramesh G	ML-MMOH-CRF-1212
02/01/2019  	IN066453		Kamalakannan G  02/01/2019		Ramesh G		ML-BRU-CRF-0491
30/07/2019	IN070610		Dinesh T		30/07/2019		Ramesh G		TBMC-CRF-0011.1
07/09/2023	  31792	   Ranjith P R		08/09/2023		RAMESH G		ML-MMOH-CRF-1913
---------------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
var dtArr = new Array();
var reset_yn="";
var isPrintPinValidationReq; //ML-MMOH-CRF-0335 - IN057113
function getMessageFrame()
{
	if(top.content!=null)
	{
		
		return top.content.messageFrame;
	}
	else
	{
		return parent.messageFrame;
	}
}

function getWorkAreaCriteriaFrame()
{
	//if(top.content!=null) commented for IN065341
	if(top.content!=null && top.content.workAreaFrame!=undefined && typeof top.content.workAreaFrame.criteria_f1 !== 'undefined')//IN065341
	{
		return top.content.workAreaFrame.criteria_f1;
	}
	else
	{
		if(parent.criteria_f1 != null && typeof parent.criteria_f1 !== 'undefined')
			return parent.criteria_f1;
		else if(parent.parent.criteria_f1 != null && typeof parent.parent.criteria_f1 !== 'undefined')
			return parent.parent.criteria_f1;
		else if(parent.parent.parent.criteria_f1 != null && typeof parent.parent.parent.criteria_f1 !== 'undefined')
			return parent.parent.parent.criteria_f1;
	}
}

function getWorkAreaControlFrame()
{
	if(top.content!=null)
	{
		return top.content.workAreaFrame.controlsForm;
	}
	else
	{
		return parent.controlsForm;
	}
}

var messageFrameReference = getMessageFrame();
var workAreaFrameReference = getWorkAreaCriteriaFrame();


function searchForDetails(firstDateTime,lastDateTime,prevOrNext,prevNextFlag)
{
	if(prevNextFlag == 'prevNextFlag')
	{
		workAreaFrameReference = parent.parent.criteria_f1;
	}
	
	var queryStrForCmnts = workAreaFrameReference.document.forms[0].queryStrForCmnts.value;
	var viewConfRes = workAreaFrameReference.document.forms[0].viewConfRes.value;
	var historytype = workAreaFrameReference.document.forms[0].history_type.value;
	
		var patientid = workAreaFrameReference.document.forms[0].Patient_id.value;
		var episodetype = workAreaFrameReference.document.forms[0].episode_type.value;

		var eventclass = workAreaFrameReference.document.forms[0].event_class.value;
		var eventgroup = workAreaFrameReference.document.forms[0].event_group.value;
		var eventitem = workAreaFrameReference.document.forms[0].event_item.value;
		var facility_id = workAreaFrameReference.document.forms[0].facility_id.value;

		var fromdate = '';
		var todate = '';
		
		todate = lastDateTime;
		fromdate = firstDateTime;

		var abnormal = "";
		
		if(workAreaFrameReference.document.forms[0].chkAbnormal.checked)
		{
			abnormal = "Y";
		}
		else
		{
			abnormal = "N";
		}

		var normalcy = "";
		/*if(workAreaFrameReference.document.forms[0].chkNormalcy.checked){
			normalcy = "Y";
		}else{
			normalcy = "N";
		}*/
		
		// graph order..

		var graphorder = workAreaFrameReference.document.forms[0].graphorder.value;
		
		var errorEvent ="";
		//var errorEvent = workAreaFrameReference.document.forms[0].chkErrorEvent.checked == true?"Y":"N";
		var encounter_id = workAreaFrameReference.document.forms[0].encounter_id.value;
		var enc_id = workAreaFrameReference.document.forms[0].enc.value;
		if(!doDateCheckFrom(workAreaFrameReference.document.forms[0].to_date,workAreaFrameReference.document.forms[0].from_date))
			return ;

		if(workAreaFrameReference.document.forms[0].view_mode[0].checked)
		{
			
			var params = " a.patient_id = '"+patientid+"' ";
			if(historytype != ""){
				params += " and a.hist_rec_type='"+historytype+"' ";
		}

		//	var params = " a.hist_rec_type='"+historytype+"' ";
	
			if (episodetype != "")
			{
				if(episodetype=="I")
					params+= " and a.PATIENT_CLASS in ('IP')";
				else if(episodetype=="O")
					params+= " and a.PATIENT_CLASS in ('OP')";
				else if(episodetype=="D")
					params+= " and a.PATIENT_CLASS in ('DC')";
				else if(episodetype=="E")
					params+= " and a.PATIENT_CLASS in ('EM')";
				else if(episodetype=="X")
					params+= " and a.PATIENT_CLASS in ('XT')";
			}
			//if(episodetype != "")
			//	params += " and a.episode_type = '"+episodetype+"' ";
			if(encounter_id != "")
				params += " and a.encounter_id = '"+encounter_id+"' ";
			if(eventclass != "")
				params += " and a.event_class = '"+eventclass+"' ";
			if(eventgroup != "")
				params += " and a.event_group = '"+eventgroup+"' ";
			if(eventitem != "")
				params += " and a.event_code = '"+eventitem+"' ";
			if(fromdate != "")
				params += " and a.event_date >= to_date('"+fromdate+"','dd/mm/yyyy HH24:MI') ";
			//alert(params);
			if(todate != "")
				params += " and a.event_date <= to_date('"+todate+"','dd/mm/yyyy HH24:MI') ";

			if(facility_id != "")
				params += " and a.facility_id = '"+facility_id+"' ";

			if(abnormal == "Y")
			{
				params += " and a.normalcy_ind is not null ";
			}
			
			//alert("Params " + params);
			var flowSheetComp = workAreaFrameReference.document.forms[0].cboFlowSheetComp.value;
			normalcy = workAreaFrameReference.document.forms[0].cboNormalcyInd.value;
			//alert("152 in flowsheet"+params);         
			var HTMLVal = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name=PopulateFlowSheetClass method=post 	action=\"../../eCA/jsp/FlowSheetDetails.jsp?Params="+params+"&graphorder="+graphorder+"&errorEvent="+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&cboFlowSheetComp="+flowSheetComp+"&prevOrNext="+prevOrNext+"&queryStrForCmnts="+queryStrForCmnts+"&viewConfRes="+viewConfRes+"&enc_id="+enc_id+"\"> </form></body></html>";

			//alert(HTMLVal);
			if(top.content!=null)
			{
				top.content.workAreaFrame.details.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				top.content.workAreaFrame.details.document.forms[0].submit();
			}
			else
			{
				if(prevNextFlag == 'prevNextFlag')
				{
					parent.parent.details.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
					parent.parent.details.document.forms[0].submit();
				}
				else
				{
					parent.details.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
					parent.details.document.forms[0].submit();
				}
			}
		}
		else
		{
		
			var episode_wise = "N";
			/*if(workAreaFrameReference.document.forms[0].episode_wise.checked){
				episode_wise = "Y";
			}*/
			var view_by="";
			if(workAreaFrameReference.document.forms[0].view_by[0].checked)
			{
				
				view_by = workAreaFrameReference.document.forms[0].view_by[0].value;
			}
			else if(workAreaFrameReference.document.forms[0].view_by[1].checked)
			{
				view_by = workAreaFrameReference.document.forms[0].view_by[1].value;
			}
			
			normalcy = workAreaFrameReference.document.forms[0].cboNormalcyInd.value;	
			
			var params = '?patient_id='+patientid+'&episode_type='+episodetype+'&hist_type='+historytype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&from_date='+fromdate+'&to_date='+todate+'&view_by='+view_by+'&episode_wise='+episode_wise+'&facility_id='+facility_id+'&encounter_id='+encounter_id+'&performed_by=&errorEvent='+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&viewConfRes="+viewConfRes+'&enc_id='+enc_id;
			
			//alert(params);
			if(top.content!=null)
			{
				top.content.workAreaFrame.details.location.href="../../eCA/jsp/EncounterListMain.jsp"+params+"&enc_id="+enc_id;
			}
			else
			{
				parent.details.location.href="../../eCA/jsp/EncounterListMain.jsp"+params+"&enc_id="+enc_id;
			}
			//top.content.workAreaFrame.details.location.href="../../eCommon/jsp/error.jsp";
		
		}
}

function clearForm(mode)
{
	/*workAreaFrameReference.document.forms[0].chkFlowSheet.checked='false';*/
	if(mode != 'FS')
		workAreaFrameReference.document.forms[0].reset();
		//workAreaFrameReference.document.location.href=workAreaFrameReference.document.location.href;
	reset_yn="yes";//Changed by DineshT
	if(top.content!=null && !top.document.getElementById('dialog-body'))
	{
		//workAreaFrameReference.document.forms[0].event_group1.value = "";
		//The following 5 commented lines are made for IN17478
		
		if(mode != 'FS')//Changed by DineshT
		{var hist_type=workAreaFrameReference.document.forms[0].history_type;
		//selectEventClass(hist_type);
		hist_type.onchange();
		}
		workAreaFrameReference.document.forms[0].event_group1.value=workAreaFrameReference.document.forms[0].event_group_defaulted.value;
		workAreaFrameReference.document.forms[0].event_item1.value=workAreaFrameReference.document.forms[0].event_item_defaulted.value;
		workAreaFrameReference.document.forms[0].event_group1.readOnly = false;
		workAreaFrameReference.document.forms[0].event_group_but.disabled = false;
		workAreaFrameReference.document.forms[0].event_class.disabled = false;
		//workAreaFrameReference.document.forms[0].event_item1.value = '';
		workAreaFrameReference.document.forms[0].event_item1.readOnly = false;		
		workAreaFrameReference.document.forms[0].event_item_but.disabled = false;
		top.content.workAreaFrame.details.location.href = "../../eCommon/html/blank.html";
	}
	else
	{
		//The changes made for IN17478
		workAreaFrameReference.document.forms[0].event_group1.value = "";
		workAreaFrameReference.document.forms[0].event_group1.readOnly = true;//changed
		workAreaFrameReference.document.forms[0].event_group_but.disabled = true;//changed
		workAreaFrameReference.document.forms[0].event_class.value ="";
		workAreaFrameReference.document.forms[0].event_class.disabled = true;//changed
		workAreaFrameReference.document.forms[0].event_item1.value = '';
		workAreaFrameReference.document.forms[0].event_item1.readOnly = true;	//changed
		workAreaFrameReference.document.forms[0].event_item_but.disabled = true;//changed
		if(parent.parent.details != null)
			parent.parent.details.location.href = "../../eCommon/html/blank.html";
		else
			parent.details.location.href = "../../eCommon/html/blank.html";
	}
	/*
	top.content.workAreaFrame.details_f11.location.href = "../../eCommon/html/blank.html";
	top.content.workAreaFrame.details_f2.location.href = "../../eCommon/html/blank.html";
	top.content.workAreaFrame.details_f22.location.href = "../../eCommon/html/blank.html"; */
}

function OnSelect()
{
	
	var params = top.content.workAreaFrame.details_f1.document.forms[0].Params.value;
	var errorEvent = top.content.workAreaFrame.details_f1.document.forms[0].errorEvent.value;
	var eventClassCode = top.content.workAreaFrame.details_f1.document.forms[0].eventClassCode.value;

	var HTMLVal = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name=PopulateFlowSheetDetails method=post 	action=\"../../eCA/jsp/FlowSheetPopulate.jsp?Params="+params+"&eventClassCode="+eventClassCode+"&errorEvent="+errorEvent+"\"> </form></body></html>";

	top.content.workAreaFrame.details_f2.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	top.content.workAreaFrame.details_f2.document.forms[0].submit();
	top.content.workAreaFrame.details_f11.location.href = "../../eCA/jsp/FlowSheetButton.jsp";
	top.content.workAreaFrame.details_f22.location.href = "../../eCA/jsp/FlowSheetColorLegend.jsp";
}

async function SearchEventItem()
{
	var his_type = document.forms[0].history_type.value;
	var locale=document.forms[0].locale.value;
	var whereClause = "";
//	if(his_type != "")
//	{
		whereClause = "where hist_rec_type='"+his_type+"'";
//	}

	var retVal = 	new String();
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var arguments	= "" ;
	//var sql=" select EVENT_CODE,long_desc SHORT_DESC from CR_CLIN_EVENT_MAST  "+whereClause;

	var sql="select EVENT_CODE code,long_desc description from CR_CLN_EVT_MST_LANG_VW "+whereClause+" and LANGUAGE_ID ='"+locale+"' and EVENT_CODE like upper(?) and upper(long_desc) like upper(?)";

	//alert(sql);
	//var search_code="EVENT_CODE";
	//var search_desc="LONG_DESC";

	var tit=getLabel("eCA.EventItem.label","CA");
	var target = workAreaFrameReference.document.forms[0].event_item1;

	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	//retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
	
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
	retVal = await CommonLookup( tit, argArray );

	var arr=new Array();
	if (retVal != null && retVal != '')
	{
		var retVal=unescape(retVal);
	   	arr=retVal.split(",");

		workAreaFrameReference.document.forms[0].event_item.value = arr[0];
		workAreaFrameReference.document.forms[0].event_item1.value = arr[1];
	}
	else
	{
		workAreaFrameReference.document.forms[0].event_item.value = '';
		workAreaFrameReference.document.forms[0].event_item1.value ='';
	}
}

async function SearchEventGroup()
{
	var his_type = document.forms[0].history_type.value;
	var locale=document.forms[0].locale.value;
	var whereClause = "";

	//if(his_type != "")
	//{
		whereClause = "where hist_rec_type='"+his_type+"'";
	//}

	var retVal = 	new String();
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var arguments	= "" ;
	//var sql=" select EVENT_GROUP,long_desc SHORT_DESC from CR_CLIN_EVENT_GROUP "+whereClause;
	
	var sql=" select EVENT_GROUP code,long_desc description from CR_CLN_EVT_GRP_LANG_VW "+whereClause+" and LANGUAGE_ID ='"+locale+"' and EVENT_GROUP  like upper(?) and upper(long_desc) like upper(?) ";

	//var search_code="EVENT_GROUP";
	//var search_desc="LONG_DESC";
	
	var tit=getLabel("eCA.EventGroup.label","CA");
	var target = workAreaFrameReference.document.forms[0].event_group1;

	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	//retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
	
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
	retVal = await CommonLookup( tit, argArray );

	
	var arr=new Array();
	if (retVal != null && retVal != '')
	{
			var retVal=unescape(retVal);
		   	arr=retVal.split(",");
			workAreaFrameReference.document.forms[0].event_group.value = arr[0];
			workAreaFrameReference.document.forms[0].event_group1.value = arr[1];
	}
	else
	{
		workAreaFrameReference.document.forms[0].event_group.value = '';
		workAreaFrameReference.document.forms[0].event_group1.value ='';
	}
/*	var his_type = document.forms[0].history_type.value;
	var whereClause = "";

	if(his_type != "")
	{
		whereClause = "where hist_rec_type=`"+his_type+"`";
	}

	var retVal = 	new String();
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var sql=" select EVENT_GROUP,long_desc SHORT_DESC from CR_CLIN_EVENT_GROUP "+whereClause;
	var search_code="EVENT_GROUP";
	var search_desc="LONG_DESC";
	var tit="Event Group";
	var target = workAreaFrameReference.document.forms[0].event_group;

	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);
	alert('retVal        '+retVal);
	if (!(retVal == null))
	{
		target.value=retVal;
	}
	else
		target.focus();

	alert('workAreaFrameReference.document.forms[0].event_group=>'+workAreaFrameReference.document.forms[0].event_group.value);
	alert('workAreaFrameReference.document.forms[0].event_group1=>'+workAreaFrameReference.document.forms[0].event_group1.value);
*/
}

function Refresh()
{
	var eventClassCode = "";
	var chval = 1;
	rows = top.content.workAreaFrame.details_f1.document.forms[0].rows.value;

	for(i = 1;i < rows;i++)
	{
		if( eval("top.content.workAreaFrame.details_f1.document.forms[0].chbox"+i+".checked") == true)
		{
			var temp = eval("top.content.workAreaFrame.details_f1.document.forms[0].field"+i+".value");
			if(chval == 1)
			{
				eventClassCode = " and a.event_class in ('"+temp+"'";
				chval = 2;
			}
			else
				eventClassCode += ",'"+temp+"'";
		}
	}

	if(chval == 2)
	{
		eventClassCode += ") ";

		var params = top.content.workAreaFrame.details_f1.document.forms[0].Params.value;

		var HTMLVal = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name=PopulateFlowSheetDetails method=post 	action=\"../../eCA/jsp/FlowSheetPopulate.jsp?Params="+params+"&eventClassCode="+eventClassCode+"\"> </form></body></html>";
		if(top.content.workAreaFrame.details_f2.document.body!=null){
		top.content.workAreaFrame.details_f2.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		top.content.workAreaFrame.details_f2.document.forms[0].submit();
		top.content.workAreaFrame.details_f22.location.href = "../../eCA/jsp/FlowSheetColorLegend.jsp";
		}
	}
	else
	{
		top.content.workAreaFrame.details_f2.location.href = "../../eCommon/html/blank.html";
		top.content.workAreaFrame.details_f22.location.href = "../../eCommon/html/blank.html";
	}
}


function  callPACS(ext_image_obj_id,server_name,virtual_directory,executable_name)
{
	messageFrameReference.location.href = '../../eCommon/jsp/error.jsp';
	HTMLVal = " <html><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>";
	HTMLVal += " <head><script src='../../eCommon/js/ValidateControl.js' language='JavaScript'></script>"  ;
	HTMLVal += " <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>"  ;
	HTMLVal += "	<script>function execute() {"  ;
	HTMLVal += "		var e = testForm.executableName.value ;"  ;
	HTMLVal += "		testForm.runtest.setExecutable( e ) ;"  ;
	HTMLVal += "		testForm.runtest.runExecutable() ;"  ;
	HTMLVal += " 	 </script></head>";
	HTMLVal += " <body onKeyDown='lockKey()' class='MESSAGE'>"  ;
	HTMLVal += " <form name='testForm' id='testForm'>"  ;
	HTMLVal += " <object id='runtest' classid='clsid:E2F834AE-D926-4EEE-991C-D15F82E92A58'></object>"  ;
	HTMLVal += " <input type='hidden' name='executableName' id='executableName' value='"+executable_name+" "+server_name+" "+virtual_directory+" sa="+ext_image_obj_id+"&ia=y&is=y'> ";
	HTMLVal += " <script>execute();</script></form></body></html>"  ;

	var messageframes =messageFrameReference.document
	messageframes.write(HTMLVal);
}

function selectEventClass(obj)
{
	var hist_type = obj.value;
	var event_called=workAreaFrameReference.document.forms[0].event_called.value;	
	if(reset_yn=="yes"){//Changed by DineshT
	reset_yn="no";
	var event_class_defaulted=workAreaFrameReference.document.forms[0].event_class_defaulted.value;
	}
	var optlength = document.forms[0].event_class.options.length;
	

	for (var i=0; i<optlength; i++)
	{
		document.forms[0].event_class.options.remove("event_class");
	}

	if((hist_type=="") ||(hist_type=="select"))
	{
		document.flowsheet_criteria_form.event_class.disabled = true;
		document.flowsheet_criteria_form.event_item1.value = '';
		document.flowsheet_criteria_form.event_item.value = '';
		document.flowsheet_criteria_form.event_item1.readOnly = true;		
		document.flowsheet_criteria_form.event_item_but.disabled = true;
		if(document.flowsheet_criteria_form.event_group1.readOnly == false)
		{
			document.flowsheet_criteria_form.event_group1.value = "";
			document.flowsheet_criteria_form.event_group.value = "";
			document.flowsheet_criteria_form.event_group1.readOnly = true;
		}
		if(document.flowsheet_criteria_form.event_group_but.disabled == false)
		{

			document.flowsheet_criteria_form.event_group_but.disabled = true;
		}
		
		
		var event_class	= '';

		var short_desc	= " ----------" +getLabel('Common.defaultSelect.label','COMMON')+" -----------";
		var opt=document.createElement('OPTION');
		opt.text	=	short_desc;
		opt.value	=	event_class;
		document.forms[0].event_class.add(opt);
		document.forms[0].event_class.selectedIndex = 0;
		return false;
	}
	else if(hist_type != '')
	{
		document.flowsheet_criteria_form.event_class.disabled = false;
		document.flowsheet_criteria_form.event_item1.readOnly = false;
		document.flowsheet_criteria_form.event_item_but.disabled = false;
		var evnt_class = document.flowsheet_criteria_form.event_class.value;
		if((evnt_class=="") ||(evnt_class=="select"))
		{
			document.flowsheet_criteria_form.event_group1.value = "";
			document.flowsheet_criteria_form.event_group.value = "";
			document.flowsheet_criteria_form.event_group1.readOnly = true;
		    document.flowsheet_criteria_form.event_group_but.disabled = true;
		}
		else
		{
		   document.flowsheet_criteria_form.event_group1.readOnly = false;
		   document.flowsheet_criteria_form.event_group_but.disabled = false;
		}

		var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='EventClassPop' id='EventClassPop' method='post' action='../../eCA/jsp/PopulateEventClass.jsp?event_called="+event_called+"&event_class_defaulted="+event_class_defaulted+"'>"+
		"<input type='hidden' name='hist_type' id='hist_type' value='"+hist_type+"'>"+
		"</form></body></html>";
		//alert(top.content);
		if(top.content!=null && top.document.getElementById('dialog-body') == null )
		{			
			if(messageFrameReference.document.body!=null){
				messageFrameReference.document.body.innerHTML = '';
				messageFrameReference.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
				if(messageFrameReference.document.EventClassPop.canHaveHTML==true){
					messageFrameReference.document.EventClassPop.submit();
				}
			}
		}
		else
		{	
			//if(parent.parent.messageFrame.document.body!=null)//CHL_CRF
			if(parent.parent.messageFrame!=null && parent.parent.messageFrame.document.body!=null)//CHL_CRF
				{
				parent.parent.messageFrame.document.body.innerHTML = '';
				parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
				if(parent.parent.messageFrame.document.EventClassPop.canHaveHTML==true)
					{
					parent.parent.messageFrame.document.EventClassPop.submit();
				}
			}
		}
	}
	return true;
}


async function showCalendarValidate(str)
{
	var flg = await showCalendar(str,null,'hh:mm');
	document.getElementById(str).focus();
	return flg;
}

async function openGraph1()
{
	//alert("638"+parent.parent.details.dataFrame.document.forms[0].graphValuesOnChk);
	//alert("1"+top.content.workAreaFrame);
	//alert("2"+top.content.workAreaFrame.details);
	//alert("5"+top.content.workAreaFrame.details.document.forms[0].name);
	//alert("4"+top.content.workAreaFrame.dataFrame.document.forms[0]);
	//alert("3"+top.content.workAreaFrame.button_f1.dataFrame.document.forms[0]);
	//if(top.content != null)
		//top.content.workAreaFrame.button_f1.dataFrame.document.forms[0].graphValuesOnChk.value = "";
	//else
		//parent.parent.details.dataFrame.document.forms[0].graphValuesOnChk.value = "";
	
	//alert(parent.frames[0].name);
	if(parent.unitFrame.document.forms[0].chkGraph){
		//var counter = parent.unitFrame.document.forms[0].chkGraph.length;
		//var counter = parent.unitFrame.document.forms[0].check.value;
		var check=0;
		var eventKeys = "";
		var resultNum = "";
		var resultUOM = "";
		var eventDesc = "";
		var eventDate = "";
		var tempeventKeys = "";
		var totCols = "";
		//if(top.content != null)
			//totCols = top.content.workAreaFrame.dataFrame.document.forms[0].totCols.value;
		//else
			totCols = parent.parent.details.dataFrame.document.forms[0].totCols.value;

		if(parent.unitFrame.document.forms[0].noOfChkdBoxes.value == 0)
		{
			alert(getMessage("NO_EVENTS_SELECTED","CA"));
			return;
		}
		/*for(var j=0;j<counter;j++)
		{
			if(eval("document.getElementById("chkGraphID")"+j).checked == true)
				check++;
		}*/
		//if(counter >1){
		//if(parent.unitFrame.document.forms[0].chkGraph.length != undefined || parent.unitFrame.document.forms[0].chkGraph.length != null){
			//for(var i=0;i<counter;i++){
			//	if(parent.unitFrame.document.forms[0].chkGraph[i].checked){					
					/*if(eval("document.getElementById("chkGraph")"+i) != null) 
						eventKeys +="^"+eval("document.forms[0].chkGraph"+i).value;
					if(eval("document.forms[0].UOM"+i) != null) 
						resultUOM +="^"+eval("document.forms[0].UOM"+i).value;
					if(eval("document.forms[0].desc"+i) != null) 
						eventDesc +="^"+eval("document.forms[0].desc"+i).value;*/
				//	check++;
			//	}
			//}
		//}
		//else{
			/*eventKeys += "^"+document.forms[0].chkGraph.value;
			resultUOM += "^"+document.forms[0].UOM.value;
			eventDesc += "^"+document.forms[0].desc.value;*/
			//check++;
		//}

/*************************************************************************/
		for(var r=0;r<resultUOM.length;r++)
		{
			resultUOM = resultUOM.replace(" ","#");
		}

		for(var t=0;t<eventDesc.length;t++)
		{
			eventDesc = eventDesc.replace(" ","?");
		}

		var tempRowValues = " ";
		var totCols = "";		
		var totRows = "";
		//if(top.content != null)
		//{
			//totCols = top.content.workAreaFrame.details.dataFrame.document.forms[0].totCols.value;
			//totRows = top.content.workAreaFrame.details.unitFrame.document.forms[0].rowsForGraph.value;
		//}
		//else
		//{
			totCols = parent.parent.details.dataFrame.document.forms[0].totCols.value;
			totRows = parent.parent.details.unitFrame.document.forms[0].rowsForGraph.value;
		//}


		var testVar = "";
		var chkTest = "";

		for(var y=0;y<parseInt(totRows,10);y++)
		{	
			tempRowValues = "";
			chkTest = eval("document.forms[0].chkGraphID"+y);
			if(chkTest != undefined && chkTest != null && (chkTest.checked)) 
			{
				for(var t=0;t<parseInt(totCols,10);t++)
				{
					//if(top.content != null)
					//{
						//testVar = eval("top.content.workAreaFrame.details.dataFrame.document.forms[0].hidden"+y+"Values"+t);
					//}
					//else
					//{
						testVar = eval("parent.parent.details.dataFrame.document.forms[0].hidden"+y+"Values"+t);
					//}
					tempRowValues += ">"+testVar.value;
				}
				//if(top.content != null)
				//{
					//top.content.workAreaFrame.details.dataFrame.document.forms[0].graphValuesOnChk.value += tempRowValues+"^%^";
				//}
				//else
				//{
					parent.parent.details.dataFrame.document.forms[0].graphValuesOnChk.value += tempRowValues+"^%^";
				//}
			}
		}
			var tempGrafValues = ""; 
			//if(top.content != null)
			//{
				//tempGrafValues = top.content.workAreaFrame.details.dataFrame.document.forms[0].graphValuesOnChk.value;
			//}
			//else
			//{
				tempGrafValues = parent.parent.details.dataFrame.document.forms[0].graphValuesOnChk.value;
			//}

			var totalRows = parent.dataFrame.document.dataForm.totRows.value;
			var totalCols = parent.dataFrame.document.dataForm.finalTotCols.value;
			var visID = "";
			var hiddenColumns = "";
			for(var i=0;i<totalCols;i++)
			{
				visID = eval(parent.dataFrame.document.getElementById("visID"+i));
				hiddenColumns += "!!" + visID.innerText;
			}
			parent.dataFrame.document.dataForm.hiddenColumns.value = hiddenColumns;			
/*************************************************************************/
		
		/*if(check >0 && check <11){
			eventKeys = eventKeys.substring(1);
		}else{
			if(check == 0)
			{
				alert(getMessage('NO_EVENTS_SELECTED','CA'));
				return false;
			}
			else if(check > 10)
			{
				alert(getMessage('NO_OF_EVENTS_MORE_THAN_10','CA'));
				return false;
			}
		}*/
		//alert(eventKeys);
	/*	var dialogHeight= "35" ;//"29"
		var dialogWidth	= "50" ;//"42"
		var dialogTop	= "10";
		var dialogLeft	= "40";//"85"
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=no; status:no ";

		var called_from_or = "";
		if(top.content != null){
			called_from_or ="N";
		}else{
			called_from_or = "Y"; 
		}
		var htmlValue = "<html><body><form action='../../eCA/jsp/FlowSheetEventsGraphParams.jsp' method='post' name='frmEvent' id='frmEvent'><input type='hidden' name='eventKeys' id='eventKeys' value="+eventKeys+"><input type='hidden' name='resultUOM' id='resultUOM' value="+resultUOM+"><input type='hidden' name='eventDesc' id='eventDesc' value="+eventDesc+"><input type='hidden' name='dateNumvals' id='dateNumvals' value='"+tempGrafValues+"'><input type='hidden' name='totCols' id='totCols' value="+totCols+"><input type='hidden' name='eventDate' id='eventDate' value="+eventDate+"><input type='hidden' name='hiddenColumns' id='hiddenColumns' value='"+hiddenColumns+"'><input type='hidden' name='called_from_or' id='called_from_or' value="+called_from_or+"></form></body></html>"

		if(top.content != null){
			messageFrameReference.document.body.insertAdjacentHTML("afterbegin",htmlValue);
			messageFrameReference.document.forms[0].submit();
		}else if(parent.parent.messageFrame!=null){
			parent.parent.messageFrame.document.body.insertAdjacentHTML("afterbegin",htmlValue);
			parent.parent.messageFrame.document.forms[0].submit();
		}else{
			parent.parent.parent.messageFrame.document.body.insertAdjacentHTML("afterbegin",htmlValue);
			parent.parent.parent.messageFrame.document.forms[0].submit();
		}*/
		
		/* var noOfGroups = parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.noOfGroups.value;
		var noOfChkdBoxes = parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.noOfChkdBoxes.value;
		var sentFromGraph = parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.sentFromGraph.value;
		var flagGraph = parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.flagGraph.value;
		var numOfchkedBoxes = parent.dataFrame.document.dataForm.noOfChkdBoxes.value;*/
		var numOfchkedBoxes =  parseInt(parent.unitFrame.document.forms[0].noOfChkdBoxes.value);

		var noOfGroups = parent.dataFrame.document.dataForm.noOfGroups.value;
		var allDatesForGraph = parent.dataFrame.document.dataForm.allDatesForGraph.value;
		var patient_id = parent.dataFrame.document.dataForm.patient_id.value;
//		var encounter_id = parent.dataFrame.document.dataForm.encounter_id.value;

		var encounter_id = parent.dataFrame.document.dataForm.enc_id.value;
		// if(encounter_id==null||encounter_id=="null"||encounter_id=="")
			// encounter_id =0;	
        /*instead of passing the parameter as check,now numOfchkedBoxes has been passed to view the graph. (Archana) */
		
		var dialogTop		=	"0vh" ;
		var dialogHeight= "100vh" ;
		var dialogWidth = "80vw" ;
		var status			=	"no";
		var arguments		=	"" ;
		var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;	
		var action_url		=	'../../eCA/jsp/ChartRecordingGroupGraphMain.jsp?noOfGroups='+noOfGroups+'&numOfchkedBoxes='+numOfchkedBoxes+'&flowsheetGraph=Y&allDatesForGraph='+allDatesForGraph+'&patient_id='+patient_id+'&encounter_id='+encounter_id;
		var retVal=await top.window.showModalDialog(action_url,arguments,features);
		if(retVal != undefined)
		{
			parent.dataFrame.document.dataForm.noOfGroups.value = retVal;
		}
	}
	//when there will be no check boxes in the FlowSheetEvents.jsp page then it will go to else condition added by Archana
	else
	{		
			alert(getMessage("NO_EVENTS_SELECTED","CA"));
			return;
		
	}
}

async function openGraph()
{
	if(top.content != null)
		top.content.workAreaFrame.details.dataFrame.document.forms[0].graphValuesOnChk.value = "";
	else
		parent.parent.details.dataFrame.document.forms[0].graphValuesOnChk.value = "";
	
	if(document.forms[0].chkGraph){
		var counter = document.forms[0].chkGraph.length;
		var check=0;
		var eventKeys = "";
		var resultNum = "";
		var resultUOM = "";
		var eventDesc = "";
		var eventDate = "";
		var tempeventKeys = "";
		var totCols = "";
		if(top.content != null)
			totCols = top.content.workAreaFrame.details.dataFrame.document.forms[0].totCols.value;
		else
			totCols = parent.parent.details.dataFrame.document.forms[0].totCols.value;

		//if(counter >1){
		if(document.forms[0].chkGraph.length != undefined || document.forms[0].chkGraph.length != null){
			for(var i=0;i<counter;i++){
				if(document.forms[0].chkGraph[i].checked){					
					/*if(eval("document.getElementById("chkGraph")"+i) != null) 
						eventKeys +="^"+eval("document.forms[0].chkGraph"+i).value;
					if(eval("document.forms[0].UOM"+i) != null) 
						resultUOM +="^"+eval("document.forms[0].UOM"+i).value;
					if(eval("document.forms[0].desc"+i) != null) 
						eventDesc +="^"+eval("document.forms[0].desc"+i).value;*/
					check++;
				}
			}
		}
		else{
			/*eventKeys += "^"+document.forms[0].chkGraph.value;
			resultUOM += "^"+document.forms[0].UOM.value;
			eventDesc += "^"+document.forms[0].desc.value;*/
			check++;
		}

/*************************************************************************/
		for(var r=0;r<resultUOM.length;r++)
		{
			resultUOM = resultUOM.replace(" ","#");
		}

		for(var t=0;t<eventDesc.length;t++)
		{
			eventDesc = eventDesc.replace(" ","?");
		}

		var tempRowValues = " ";
		var totCols = "";		
		var totRows = "";
		if(top.content != null)
		{
			totCols = top.content.workAreaFrame.details.dataFrame.document.forms[0].totCols.value;
			totRows = top.content.workAreaFrame.details.unitFrame.document.forms[0].rowsForGraph.value;
		}
		else
		{
			totCols = parent.parent.details.dataFrame.document.forms[0].totCols.value;
			totRows = parent.parent.details.unitFrame.document.forms[0].rowsForGraph.value;
		}


		var testVar = "";
		var chkTest = "";

		for(var y=0;y<parseInt(totRows,10);y++)
		{	
			tempRowValues = "";
			chkTest = eval("document.forms[0].chkGraphID"+y);
			if(chkTest != undefined && chkTest != null && (chkTest.checked)) 
			{
				for(var t=0;t<parseInt(totCols,10);t++)
				{
					if(top.content != null)
					{
						testVar = eval("top.content.workAreaFrame.details.dataFrame.document.forms[0].hidden"+y+"Values"+t);
					}
					else
					{
						testVar = eval("parent.parent.details.dataFrame.document.forms[0].hidden"+y+"Values"+t);
					}
					tempRowValues += ">"+testVar.value;
				}
				if(top.content != null)
				{
					top.content.workAreaFrame.details.dataFrame.document.forms[0].graphValuesOnChk.value += tempRowValues+"^%^";
				}
				else
				{
					parent.parent.details.dataFrame.document.forms[0].graphValuesOnChk.value += tempRowValues+"^%^";
				}
			}
		}
			var tempGrafValues = ""; 
			if(top.content != null)
			{
				tempGrafValues = top.content.workAreaFrame.details.dataFrame.document.forms[0].graphValuesOnChk.value;
			}
			else
			{
				tempGrafValues = parent.parent.details.dataFrame.document.forms[0].graphValuesOnChk.value;
			}

			var totalRows = parent.dataFrame.document.dataForm.totRows.value;
			var totalCols = parent.dataFrame.document.dataForm.finalTotCols.value;
			var visID = "";
			var hiddenColumns = "";
			for(var i=0;i<totalCols;i++)
			{
				visID = eval(parent.dataFrame.document.getElementById("visID"+i));
				hiddenColumns += "!!" + visID.innerText;
			}
			parent.dataFrame.document.dataForm.hiddenColumns.value = hiddenColumns;			
/*************************************************************************/
		
		if(check >0 && check <11){
			eventKeys = eventKeys.substring(1);
		}else{
			if(check == 0)
			{
				alert(getMessage('NO_EVENTS_SELECTED','CA'));
				return false;
			}
			else if(check > 10)
			{
				alert(getMessage('NO_OF_EVENTS_MORE_THAN_10','CA'));
				return false;
			}
		}
		//alert(eventKeys);
	/*	var dialogHeight= "35" ;//"29"
		var dialogWidth	= "50" ;//"42"
		var dialogTop	= "10";
		var dialogLeft	= "40";//"85"
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=no; status:no ";

		var called_from_or = "";
		if(top.content != null){
			called_from_or ="N";
		}else{
			called_from_or = "Y"; 
		}
		var htmlValue = "<html><body><form action='../../eCA/jsp/FlowSheetEventsGraphParams.jsp' method='post' name='frmEvent' id='frmEvent'><input type='hidden' name='eventKeys' id='eventKeys' value="+eventKeys+"><input type='hidden' name='resultUOM' id='resultUOM' value="+resultUOM+"><input type='hidden' name='eventDesc' id='eventDesc' value="+eventDesc+"><input type='hidden' name='dateNumvals' id='dateNumvals' value='"+tempGrafValues+"'><input type='hidden' name='totCols' id='totCols' value="+totCols+"><input type='hidden' name='eventDate' id='eventDate' value="+eventDate+"><input type='hidden' name='hiddenColumns' id='hiddenColumns' value='"+hiddenColumns+"'><input type='hidden' name='called_from_or' id='called_from_or' value="+called_from_or+"></form></body></html>"

		if(top.content != null){
			messageFrameReference.document.body.insertAdjacentHTML("afterbegin",htmlValue);
			messageFrameReference.document.forms[0].submit();
		}else if(parent.parent.messageFrame!=null){
			parent.parent.messageFrame.document.body.insertAdjacentHTML("afterbegin",htmlValue);
			parent.parent.messageFrame.document.forms[0].submit();
		}else{
			parent.parent.parent.messageFrame.document.body.insertAdjacentHTML("afterbegin",htmlValue);
			parent.parent.parent.messageFrame.document.forms[0].submit();
		}*/
		
		/* var noOfGroups = parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.noOfGroups.value;
		var noOfChkdBoxes = parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.noOfChkdBoxes.value;
		var sentFromGraph = parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.sentFromGraph.value;
		var flagGraph = parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.flagGraph.value;
		var numOfchkedBoxes = parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.noOfChkdBoxes.value;*/

		var noOfGroups = parent.dataFrame.document.dataForm.noOfGroups.value;
		var allDatesForGraph = parent.dataFrame.document.dataForm.allDatesForGraph.value;
		var patient_id = parent.dataFrame.document.dataForm.patient_id.value;
//		var encounter_id = parent.dataFrame.document.dataForm.encounter_id.value;

		var encounter_id = parent.dataFrame.document.dataForm.enc_id.value;
		// if(encounter_id==null||encounter_id=="null"||encounter_id=="")
			// encounter_id =0;
			 

		
		var dialogTop		=	"90" ;
		var dialogHeight= "100" ;
		var dialogWidth = "80" ;
		var status			=	"no";
		var arguments		=	"" ;
		var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;	
		var action_url		=	'../../eCA/jsp/ChartRecordingGroupGraphMain.jsp?noOfGroups='+noOfGroups+'&noOfChkdBoxes='+check+'&flowsheetGraph=Y&allDatesForGraph='+allDatesForGraph+'&patient_id='+patient_id+'&encounter_id='+encounter_id;
		var retVal= await window.showModalDialog(action_url,arguments,features);		
		if(retVal != undefined)
		{
			parent.dataFrame.document.dataForm.noOfGroups.value = retVal;
		}
	}
}

function limitTheGraphs(obj){
	/*var counter = document.forms[0].chkGraph.length;
	var check=0;
	if(counter >1){
		for(var i=0;i<counter;i++){
			if(document.forms[0].chkGraph[i].checked){
				check++;
			}
		}

		if(check > 3){
			alert('CA0123 - Only three events can be selected');
			obj.checked = false;
			return false;
		}
	}*/
	return true;
}
function alignUnitsAndTitle(){
	var temp = parent.unitFrame.document.getElementById("unitTitleTable").rows[0].cells.length;
	var total = parent.unitFrame.document.getElementById("unitTable").rows.length;
	total = total-1;

	var counter = parent.unitFrame.document.getElementById("unitTable").rows[total].cells.length;
//var counter = parent.unitFrame.document.getElementById("unitTable").rows(parent.unitFrame.document.getElementById("unitTable").rows.length-1).cells.length;
	for(var i=0;i<counter;i++){
		parent.unitFrame.document.getElementById("unitTitleTable").rows[0].cells[i].width=	parent.unitFrame.document.getElementById("unitTable").rows[total].cells[i].offsetWidth;

//		parent.unitFrame.document.getElementById("unitTitleTable").rows(0).cells(i).width=	parent.unitFrame.document.getElementById("unitTable").rows(counter).cells(i).offsetWidth;
	}
}


        function alignUnitsAndData(){
			
			var totalRows =  parent.dataFrame.document.getElementById("dataTable").rows.length;
	        var counter = totalRows-1;
            var temp = parent.dataFrame.document.getElementById("dataTitleTable").rows[1].cells.length;
            for(var i=0;i<temp;i++) {							
				parent.dataFrame.document.getElementById("dataTitleTable").rows[1].cells[i].width=parent.dataFrame.document.getElementById("dataTable").rows[counter].cells[i].offsetWidth;				
            }
            
			parent.unitFrame.document.getElementById("unitTitleTable").rows[0].height =   parent.dataFrame.document.getElementById("dataTitleTable").rows[0].offsetHeight;
			parent.unitFrame.document.getElementById("unitTitleTable").rows[1].height =   parent.dataFrame.document.getElementById("dataTitleTable").rows[1].offsetHeight;
			
        }

		function getPos(inputElement)
		{
			var coords =  new Object();
			coords.x = 0;
			coords.y = 0;
			try
			{
				targetElement = inputElement;
				if(targetElement.x && targetElement.y)
				{
					coords.x = targetElement.x;
					coords.y = targetElement.y;
				}
				else
				{
					if(targetElement.offsetParent)
					{
						coords.x += targetElement.offsetLeft;
						coords.y += targetElement.offsetTop;
						while(targetElement = targetElement.offsetParent)
						{
							coords.x += targetElement.offsetLeft;
							coords.y += targetElement.offsetTop;
						}
					}
				}
				return coords;
			}
			catch(error)
			{
				return coords;
			}
		}

        function displayToolTip(toolTip,toolTip1,rowNum,colNum)
		{
			var tdObj = eval(document.getElementById("visibility"+rowNum+"ID"+colNum));
			if(toolTip1 != '')
			{
				//IN067806 changes starts
				tempVal=unescape(toolTip1);
				for(var i=0; i<tempVal.length;i++){
					tempVal = tempVal.replace("+"," ");
					tempVal = tempVal.replace("&#92","\\");
					tempVal = tempVal.replace("&#126","~");
					tempVal = tempVal.replace("&#124","|");
					tempVal = tempVal.replace("&#96","`");
					tempVal = tempVal.replace("&#39","'");
					
				}
				for(var i=0; i<tempVal.length;i++){
					tempVal = tempVal.replace("&#43","+");
					tempVal=  tempVal.replace("~ ","<BR>");
				}
				document.getElementById("t").innerHTML = tempVal;
				//IN067806 changes ends
				var wdth 	  = tdObj.offsetWidth;
				var hght1 	  = tdObj.offsetHeight;

				var wdth1 = getPos(tdObj).x ;
				var hght = getPos(tdObj).y + hght1;

				var bodwidth  = document.body.offsetWidth
				var bodheight = document.body.offsetHeight
	
				var x 	  = event.x;
				var y 	  = event.y;

				x 	  = x + (document.getElementById("tooltiplayer").offsetWidth);
				y 	  = hght + (document.getElementById("tooltiplayer").offsetHeight);

				/*if((wdth1+document.getElementById("tooltiplayer").offsetWidth) < document.getElementById("dataTable").offsetWidth)
				{*/
					x = wdth1;	
				/*}
				else
				{			
					x = document.getElementById("dataTable").offsetWidth - document.getElementById("tooltiplayer").offsetWidth;
				}

				if((hght+document.getElementById("tooltiplayer").offsetHeight ) < document.getElementById("dataTable").offsetHeight)
				{*/		
					y = hght;
				/*}
				else
				{
					y = document.getElementById("dataTable").offsetHeight - (document.getElementById("tooltiplayer").offsetHeight+hght1);	
				}*/

				document.getElementById("tooltiplayer").style.left = x+"px";
				document.getElementById("tooltiplayer").style.top = y+"px";
				document.getElementById("tooltiplayer").style.visibility = 'visible';
	
				if(tdObj.className != 'gridDataSelect')
					tdObj.className = 'gridDataHover';
			}

			var temp="<DIV STYLE='BACKGROUND-COLOR:yellow'>";
			
			temp += toolTip;
			temp += "</DIV>";
			if(top.content!=null && !top.document.getElementById('dialog-body'))
			{					
				messageFrameReference.document.body.innerHTML = temp;
			}
			else if(parent.parent.messageFrame!=null)
			{
				
				parent.parent.messageFrame.document.body.innerHTML = temp;
			}
			else
			{	
				if(parent.parent.parent.messageFrame!=null)
				{
					
					parent.parent.parent.messageFrame.document.body.innerHTML = temp;
				}
			}
		}

        function hideToolTip(rowNum,colNum)
		{
			document.getElementById("tooltiplayer").style.visibility = 'hidden'
			var tdObj = eval(document.getElementById("visibility"+rowNum+"ID"+colNum));
			
			if(tdObj.className != 'gridDataSelect')
				tdObj.className = 'gridDataChart';

			if(top.content != null && !top.document.getElementById('dialog-body'))
			{
				messageFrameReference.document.body.innerHTML = "";
			}
			else if(parent.parent.mesasgeFrame!=null)
			{
				parent.parent.messageFrame.document.body.innerHTML = "";
			}
			else
			{
			  if(parent.parent.parent.messageFrame!=null)
				{
					parent.parent.parent.messageFrame.document.body.innerHTML = "";
				}
			}
		}

		function showToolTip1(obj,rowNum,colNum)
		{
				var displayText = '<table cellpadding=0 cellspacing=0 border=0><td class=YELLOW>'
				
				displayText += "Click to view other recording of this event for the same time";
				
				
				displayText += '</td></table>';
				document.getElementById("moredetailMode").innerHTML = displayText;
				document.getElementById("moredetailMode").style.top  = obj.offsetTop+130; 
				document.getElementById("moredetailMode").style.left  = obj.offsetLeft+100 ;
				document.getElementById("moredetailMode").style.visibility='visible' ;
		}
			
		function hideToolTip1(rowNum,colNum)
		{
				document.getElementById("moredetailMode").style.visibility='hidden' ;

		}

        function alignDivs(){
                 var x = document.body.clientHeight;
                 var y = document.body.clientWidth;
                 //alert(parent.unitFrame.document.getElementById("unitTitleTable").style.posLeft);
                 //parent.unitFrame.document.getElementById("divUnitTitle").style.position = 'relative';
                 //parent.unitFrame.document.getElementById("unitTitleTable").style.offsetLeft = y;
                 //alert(x);alert(y);

        }
        function fnEnterQuickNotes(){
                var x = document.body.scrollLeft;
               //alert(x)
                window.showModalDialog('../../eCommon/jsp/error.jsp','Quick Notes','width=400;height=300;');
				parent.dataFrame.document.body.scrollLeft = x;
				//alert(x);
                return false;
        }
        function scrollFrame(){
          parent.unitFrame.document.body.scrollTop=
          parent.dataFrame.document.body.scrollTop;
          setTimeout("scrollTitle()",50);
        }

        function scrollTitle(){
          var x = parent.dataFrame.document.body.scrollTop;
          var y = parent.unitFrame.document.body.scrollTop;
          if(y == 0){
           parent.dataFrame.document.getElementById("divDataTitle").style.position = 'static';
           parent.dataFrame.document.getElementById("divDataTitle").style.posTop  = 0;
           parent.unitFrame.document.getElementById("divUnitTitle").style.position = 'static';
           parent.unitFrame.document.getElementById("unitTitleTable").style.position = 'static';
           parent.unitFrame.document.getElementById("unitTitleTable").style.posTop  = y;
          }else{
            parent.unitFrame.document.getElementById("divUnitTitle").style.position = 'relative';
            parent.unitFrame.document.getElementById("unitTitleTable").style.position = 'relative';
           parent.unitFrame.document.getElementById("unitTitleTable").style.posTop  = y-2;
           parent.dataFrame.document.getElementById("divDataTitle").style.position = 'relative';
           parent.dataFrame.document.getElementById("divDataTitle").style.posTop  = y-2;
          }

        }


		function alignHeight()
		{
			//IN058144 Start.
			var totalTitleRows = parent.dataFrame.document.getElementById("dataTitleTable").rows.length;
			for(var i=0;i<totalTitleRows;i++){
				var thgt = parent.dataFrame.document.getElementById("dataTitleTable").rows[i].offsetHeight;
				var thgt1 =parent.unitFrame.document.getElementById("unitTitleTable").rows[i].offsetHeight;				
				if(thgt > thgt1){
					parent.unitFrame.document.getElementById("unitTitleTable").rows[i].height = thgt;
				}else if(thgt < thgt1){
					parent.dataFrame.document.getElementById("dataTitleTable").rows[i].height = thgt1;				
				}
				
			}
			//IN058144 End.
			var totalRows =  parent.dataFrame.document.getElementById("dataTable").rows.length;
			var totalRows =  parent.unitFrame.document.getElementById("unitTable").rows.length;
			//alert("left :"+parent.unitFrame.document.getElementById("unitTable").rows.length);
			//alert("right :"+parent.dataFrame.document.getElementById("dataTable").rows.length);
			var counter = eval(totalRows);
		
            for(var i=0;i<counter;i++){
				var hgt=parent.dataFrame.document.getElementById("dataTable").rows[i].offsetHeight;
				var hgt1=parent.unitFrame.document.getElementById("unitTable").rows[i].offsetHeight;				
				if(hgt > hgt1){
					parent.unitFrame.document.getElementById("unitTable").rows[i].height = hgt;
				}else if(hgt < hgt1){
					parent.dataFrame.document.getElementById("dataTable").rows[i].height = hgt1;				
				}
            }

        }


	




//Functions for the file name FlowSheetCriteria.jsp-start

function makeVisible(obj)
{	
	workAreaFrameReference = getWorkAreaCriteriaFrame();	
	var val =obj.value;	
	
	var rows;
	if (document.forms[0].more.value==getLabel("Common.lesscriteria.label","COMMON"))
		bool='no';
	else bool='yes';


	if (val==getLabel("Common.search.label","COMMON")||obj.name=='search') //OR condition added by Arvind For ICN 19333 on 2/19/2010
		bool='no';
		

	if(top.content != null)
	{
		/** Modified by kishore kumar N on 05/12/2008 for CRF 0387 **/
				if(bool == 'yes')
					rows = "48%,*"; // modified from 40 to 42 for IN058886 - modified from 42 to 44 for  MMS-QH-CRF-0177 [IN047572]	
				else if(bool == 'no')
					rows = "26%,*"; // modified from 22 to 24 for IN058886 - modified from 24 to 26 for  MMS-QH-CRF-0177 [IN047572]	 
				
	}
	else
	{
		if(workAreaFrameReference.document.forms[0].view_mode[0].checked)
		{
			if(bool == 'yes')
				rows = "48%,*,0%"; // modified from 40 to 41 for IN058886 - modified from 41 to 48 for MMS-QH-CRF-0177 [IN047572]	
			else{
				rows = '26%,*,0%'; // modified from 22 to 24 for IN058886 - modified from 24 to 26 for MMS-QH-CRF-0177 [IN047572]	 
			}
		}
		else
		{
			if(bool == 'yes')
				rows = "48%,*,0%"; // modified from 40 to 41 for IN058886 - modified from 41 to 48 for  MMS-QH-CRF-0177 [IN047572]	 
			else
				rows = '26%,*,0%'; // modified from 22 to 24 for IN058886 - modified from 24 to 26 for  MMS-QH-CRF-0177 [IN047572]	
		}		
		/** Ends here*/
	}
	
	if(bool == 'yes')
	{
//			rows = "37%,*";
			//parent.myFrameSet.removeAttribute(rows);
			//parent.myFrameSet.rows = rows;
			document.getElementById("moreCriteria").style='display';
			document.forms[0].more.value=getLabel("Common.lesscriteria.label","COMMON");
			//parent.document.getElementById("criteria_f1").style.height='42vh';
			parent.document.getElementById("criteria_f1").style.height="31vh";
			parent.document.getElementById("details").style.height="63vh";
			parent.document.getElementById("addToGroupsFrame").style.height="0vh";
	}
	else if(bool == 'no')
	{
//			rows = "19%,*";
			//parent.myFrameSet.removeAttribute(rows);
			//parent.myFrameSet.rows = rows;
			document.getElementById("moreCriteria").style.display = 'none';
			document.forms[0].more.value=getLabel("Common.morecriteria.label","COMMON");
			//parent.document.getElementById("criteria_f1").style.height='20vh';
			parent.document.getElementById("criteria_f1").style.height="17vh";
			parent.document.getElementById("details").style.height="77vh";
			parent.document.getElementById("addToGroupsFrame").style.height="0vh";
	}
}

function getMessageFrame()
{
	if(top.content!=null){
		return top.content.messageFrame;
	}else{
		return parent.parent.messageFrame;
	}
}
var messageFrameReference = getMessageFrame();

function displayViewBy()
{
	if(document.forms[0].view_mode[0].checked)
	{
		//IN061884 changes starts
		if (document.forms[0].more.value==getLabel("Common.lesscriteria.label","COMMON")){
			document.getElementById("moreCriteria").style='display';
			parent.myFrameSet.rows = "47%,*,0%";
		}
		else
			parent.myFrameSet.rows = "26%,*,0%";

		//document.getElementById("history_type").value = "";//Commented for 067842
		//document.getElementById("history_type").disabled=false//Commented for 067842
		document.getElementById("grp_view").style.display = "none"; 		
		document.getElementById("grp_view_val").style.display = "none"; 
		document.getElementById("NorInd").style.visibility = "visible";
		document.getElementById("NorIndval").style.visibility = "visible";
		document.getElementById("moreCri").style='display';
		document.getElementById("NorInd").style='display';
		document.getElementById("NorIndval").style='display';
		document.getElementById("grphisttype").style.display = "none";
		document.getElementById("grphisttypeval").style.display = "none";
		//IN061884 changes ends
		document.getElementById("FS").style='display';
		document.getElementById("CE").style.display = "none";
		document.getElementById("show_txt_rsult").style.display = "none";
		document.getElementById("show_exp").style.display = "none";
		document.getElementById("evtcod_label_id").style='display'; //INT-CRF-BRU-CIS-004 - IN058138
		document.getElementById("evtcod_check_id").style='display'; //INT-CRF-BRU-CIS-004 - IN058138
	}
	else if(document.forms[0].view_mode[1].checked)
	{
		document.getElementById("CE").style='display';	
		document.getElementById("FS").style.display = "none";
		document.getElementById("show_txt_rsult").style.display = "";
		document.getElementById("show_exp").style.display = "";
		document.getElementById("evtcod_label_id").style.display = "none"; //INT-CRF-BRU-CIS-004 - IN058138
		document.getElementById("evtcod_check_id").style.display = "none"; //INT-CRF-BRU-CIS-004 - IN058138
		//IN061884 changes starts
		if (document.forms[0].more.value==getLabel("Common.lesscriteria.label","COMMON")){
			document.getElementById("moreCriteria").style='display';
			parent.myFrameSet.rows = "46%,*,0%";
			/*parent.document.getElementById("criteria_f1").style.height='46vh';
			parent.document.getElementById("details").style.height='54vh';
			parent.document.getElementById("messageFrame").style.height='0vh';*/
		}
		else 
			parent.myFrameSet.rows = "32%,*,0%";
			/*parent.document.getElementById("criteria_f1").style.height='40vh';
			parent.document.getElementById('details').style.height='57vh';
			parent.document.getElementById("addToGroupsFrame").style.height='0vh';*/
			
		

		//document.getElementById("history_type").value = "";//Commented for 067842
		//document.getElementById("history_type").disabled=false//Commented for 067842
		document.getElementById("grp_view").style.display = "none"; 		
		document.getElementById("grp_view_val").style.display = "none"; 
		document.getElementById("NorInd").style.visibility = "visible";
		document.getElementById("NorIndval").style.visibility = "visible";
		document.getElementById("moreCri").style='display';
		document.getElementById("NorInd").style='display';
		document.getElementById("NorIndval").style='display';
		document.getElementById("grphisttype").style.display = "none";
		document.getElementById("grphisttypeval").style.display = "none";
		//IN061884 changes ends
	}
	//IN061884 changes starts
	else if(document.forms[0].view_mode[2].checked)
	{
		document.getElementById("CE").style.display = "none";	
		document.getElementById("FS").style.display = "none";
		document.getElementById("show_txt_rsult").style='display';//IN068145 inline
		document.getElementById("show_exp").style='display';//IN068145 inline
		document.getElementById("evtcod_label_id").style.display = "none"; 
		document.getElementById("evtcod_check_id").style.display = "none"; 
		document.getElementById("moreCri").style.display = "none";
		document.getElementById("moreCriteria").style.display = "none"; 
		document.getElementById("NorInd").style.visibility = "visible";
		document.getElementById("NorIndval").style.visibility = "visible";
		document.getElementById("grphisttype").style='display';
		document.getElementById("grphisttypeval").style='display';
		document.getElementById("grphistory_type").value = "LBIN";
		document.getElementById("grphistory_type").disabled=true
		document.getElementById("grp_view").style='display';	
		document.getElementById("grp_view_val").style='display';
		parent.myFrameSet.rows = "20%,*,0%";
	
	}
	//IN061884 changes ends
}
function checkGroup(obj){
	if(obj.value!=""){
			HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempForm' id='tempForm' method='post' action='FlowSheetCriteriaGroupSearch.jsp'><input type=hidden name='eventGroup' id='eventGroup' value='"+obj.value+"'><input type=hidden name='history_type' id='history_type' value='"+document.forms[0].history_type.value+"'> </form></body></html>"
			messageFrameReference.document.write(HTMLVal);
			messageFrameReference.document.tempForm.submit();
	}else{
		document.getElementById("event_group").value = "";
	}
}

function checkItem(obj){
	if(obj.value!=""){
			HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempForm' id='tempForm' method='post' action='FlowSheetCriteriaItemSearch.jsp'><input type=hidden name='eventItem' id='eventItem' value='"+obj.value+"'><input type=hidden name='history_type' id='history_type' value='"+document.forms[0].history_type.value+"'></form></body></html>"
			messageFrameReference.document.write(HTMLVal);
			messageFrameReference.document.tempForm.submit();
	}else{
		document.getElementById("event_item").value = "";
	}
}


async function ShowChart()
{
	var rows = details_f2.document.forms[0].j.value;
	var cols = details_f2.document.forms[0].i.value;
	for(i=0;i<rows;i++)
	{
	obj = eval("details_f2.document.forms[0].ch"+i);
	if(obj) {
		if(obj.checked) {
			sele_row=obj.value;
			val2bsent ='';
			dates2bsent='';
			total_col = 0;
			event_val = eval("details_f2.document.forms[0].event"+sele_row+"0.value");
			unit_val = eval("details_f2.document.forms[0].unit"+sele_row+"2.value");
			//alert("*"+unit_val+"*"+unit_val.length);
			if(unit_val == "" || unit_val == " ") {
				//alert('here');
				unit_val = " ";
			}
			for(j=3;j<cols;j++) {
				if(eval("details_f2.document.forms[0].data"+sele_row+""+j+".value") != '*') {
					dates2bsent+=eval("details_f2.document.forms[0].date"+j+".value")+'`';
					val2bsent += eval("details_f2.document.forms[0].data"+sele_row+""+j+".value")+'`';
					total_col ++;
				}
			}
			var retVal = 	new String();
			var dialogHeight= "29" ;
			var dialogWidth	= "42" ;
			var dialogTop	= "135";
			var dialogLeft	= "150";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=no; status:no;";
			var url = "../jsp/FlowSheetGraphFrame.jsp?values="+val2bsent+"&dates="+dates2bsent+"&totcols="+total_col+"&eventval="+event_val+"&unitval="+unit_val;
			//alert(url);
			retVal =await window.showModalDialog(url,arguments,features);
		}
	}
}
}
function DateTimeCheck(Obj)
{	
	if(Obj.value != "")
	{retVal = doDateTimeChk(Obj);
		if(retVal == false)
		{	
			var msg=getMessage('INVALID_DATE_TIME','CA');
			alert(msg);
			Obj.value="";
			Obj.focus();
		}
	}
}

//Functions for the file name FlowSheetCriteria.jsp-end


//Functions for the file name FlowSheetDetails.jsp-start




async function callfunction()
{
	if(top.content!=null)
	{
		var target			= top.content.workAreaFrame.frames[0].document.forms[0].event_group1;
		var serviceVal   = top.content.workAreaFrame.frames[0].document.forms[0].event_group1.value;
		var his_type		=  top.content.workAreaFrame.frames[0].document.forms[0].history_type.value;
		var whereClause = "";
		var locale=top.content.workAreaFrame.frames[0].document.forms[0].locale.value;

		whereClause = "and hist_rec_type='"+his_type+"'";
			
		var title			=getLabel("eCA.EventGroup.label","CA"); 
		
		//var sql="select EVENT_GROUP code, long_desc description from CR_CLIN_EVENT_GROUP where  upper(EVENT_GROUP)  like upper(?) and upper(long_desc) like upper(?) "+whereClause

			var sql="select EVENT_GROUP code, long_desc description from CR_CLN_EVT_GRP_LANG_VW where  EVENT_GROUP  like upper(?) and upper(long_desc) like upper(?) AND LANGUAGE_ID='"+locale+"'"+whereClause;

		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();

		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;

		retArray = await CommonLookup( title, argArray );
		if(retArray != null && retArray !="")	{
			top.content.workAreaFrame.frames[0].document.forms[0].event_group.value = retArray[0];
			top.content.workAreaFrame.frames[0].document.forms[0].event_group1.value = retArray[1];
		}else{
			top.content.workAreaFrame.frames[0].document.forms[0].event_group.value = '';
			top.content.workAreaFrame.frames[0].document.forms[0].event_group1.value ='';
		}
		top.content.workAreaFrame.frames[0].document.forms[0].event_group_but.disabled = false;
	   top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp';
   }
   else
	{

		var target			= parent.criteria_f0.criteria_f1.document.forms[0].event_group1;
		var serviceVal   = parent.criteria_f0.criteria_f1.document.forms[0].event_group1.value;
		var his_type		=  parent.criteria_f0.criteria_f1.document.forms[0].history_type.value;
		var whereClause = "";
		var locale = parent.criteria_f0.criteria_f1.document.forms[0].locale.value;

		whereClause = "and hist_rec_type='"+his_type+"'";
			
		var title			=getLabel("eCA.EventGroup.label","CA"); 
		
		//var sql="select EVENT_GROUP code, long_desc description from CR_CLIN_EVENT_GROUP where  upper(EVENT_GROUP)  like upper(?) and upper(long_desc) like upper(?) "+whereClause

			var sql="select EVENT_GROUP code, long_desc description from CR_CLN_EVT_GRP_LANG_VW where  EVENT_GROUP  like upper(?) and upper(long_desc) like upper(?) AND LANGUAGE_ID='"+locale+"'"+whereClause;

		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();

		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;

		retArray = await CommonLookup( title, argArray );
		if(retArray != null && retArray !="")	{
			parent.criteria_f0.criteria_f1.document.forms[0].event_group.value = retArray[0];
			parent.criteria_f0.criteria_f1.document.forms[0].event_group1.value = retArray[1];
		}else{
			parent.criteria_f0.criteria_f1.document.forms[0].event_group.value = '';
			parent.criteria_f0.criteria_f1.document.forms[0].event_group1.value ='';
		}
		parent.criteria_f0.criteria_f1.document.forms[0].event_group_but.disabled = false;
	    parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	}
}


//Functions for the file name FlowSheetCriteriaGroupSearch.jsp-end


//Functions for the file name FlowSheetCriteriaItemSearch.jsp-end


async function callfunctionitemsearch()
{
	if(top.content!=null)
	{
		var target			= top.content.workAreaFrame.frames[0].document.forms[0].event_item1;
	//	var serviceVal   = top.content.workAreaFrame.frames[0].document.forms[0].event_item1.value;
		var his_type		=  top.content.workAreaFrame.frames[0].document.forms[0].history_type.value;
		var whereClause = "";
		
	//	if (his_type !=""){
					whereClause = "and hist_rec_type='"+his_type+"'";
	//	}
	//	alert('wc  =>'+whereClause);
		var title			= getLabel("eCA.EventItem.label","CA");
		var locale=top.content.workAreaFrame.frames[0].document.forms[0].locale.value;
		//var sql="select EVENT_CODE code, long_desc description  from CR_CLIN_EVENT_MAST  where upper(EVENT_CODE)   like upper(?) and upper(long_desc) like upper(?)  "+whereClause

		var sql="select EVENT_CODE code, long_desc description  from CR_CLN_EVT_MST_LANG_VW  where EVENT_CODE like upper(?) and upper(long_desc) like upper(?) AND  LANGUAGE_ID='"+locale+"'"+whereClause;

		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();

		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retArray = await CommonLookup( title, argArray );

		if(retArray != null && retArray !="")	{
			top.content.workAreaFrame.frames[0].document.forms[0].event_item.value = retArray[0];
			top.content.workAreaFrame.frames[0].document.forms[0].event_item1.value = retArray[1];
		}else{
			top.content.workAreaFrame.frames[0].document.forms[0].event_item.value = '';
			top.content.workAreaFrame.frames[0].document.forms[0].event_item1.value ='';
		}
		top.content.workAreaFrame.frames[0].document.forms[0].event_item_but.disabled=false;
	    top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	}
	else
	{
		var target			= parent.criteria_f0.criteria_f1.document.forms[0].event_item1;
	//	var serviceVal   = top.content.workAreaFrame.frames[0].document.forms[0].event_item1.value;
		var his_type		=  parent.criteria_f0.criteria_f1.document.forms[0].history_type.value;
		var whereClause = "";
		
	//	if (his_type !=""){
					whereClause = "and hist_rec_type='"+his_type+"'";
	//	}
	//	alert('wc  =>'+whereClause);
		var title			= getLabel("eCA.EventItem.label","CA");
		var locale=parent.criteria_f0.criteria_f1.document.forms[0].locale.value;
		//var sql="select EVENT_CODE code, long_desc description  from CR_CLIN_EVENT_MAST  where upper(EVENT_CODE)   like upper(?) and upper(long_desc) like upper(?)  "+whereClause

		var sql="select EVENT_CODE code, long_desc description  from CR_CLN_EVT_MST_LANG_VW  where EVENT_CODE like upper(?) and upper(long_desc) like upper(?) AND  LANGUAGE_ID='"+locale+"'"+whereClause;

		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();

		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retArray = await CommonLookup( title, argArray );

		if(retArray != null && retArray !="")	{
			parent.criteria_f0.criteria_f1.document.forms[0].event_item.value = retArray[0];
			parent.criteria_f0.criteria_f1.document.forms[0].event_item1.value = retArray[1];
		}else{
			parent.criteria_f0.criteria_f1.document.forms[0].event_item.value = '';
			parent.criteria_f0.criteria_f1.document.forms[0].event_item1.value ='';
		}
		parent.criteria_f0.criteria_f1.document.forms[0].event_item_but.disabled=false;
	    parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	}
}


//Functions for the file name FlowSheetCriteriaItemSearch.jsp-end

//Functions for the file name FlowSheetGraphFrame.jsp-start

/**********************changes made ******************/
var args0;
var args1;
var args2;
var args3;
var args4;
var args5;			
function splitArray()
{
	
	var arrValues	=	new Array();
	arrValues		=	top.dialogArguments;
	args0 = arrValues[0];
	args1 = arrValues[1];
	args2 = arrValues[2];
	args3 = arrValues[3];
	args4 = arrValues[4];
	args5 = arrValues[5];
	if(args5=='1')
	{
		document.getElementById("frmset").rows='*%,0%'
		//args0=args0+"-1`-12`";
		//args1=args1+"12/12/2003 17:20`12/12/2003 17:20`";
		args0=args0;
		args1=args1;
		args2=eval(args2)+2;
		callGraphDisplay1('0');
	}
	else if(args5=='2')
	{
		
		document.getElementById("frmset").rows='50%,50%,0%';
		callGraphDisplay('0');
		callGraphDisplay('1');
	}

	else if(args5=='3')
	{
		document.getElementById("frmset").rows='33%,33%,33%,0%';
		callGraphDisplay('0');
		callGraphDisplay('1');
		callGraphDisplay('2');
	}
	
//alert(document.getElementById("frmset").rows);

}	
function callGraphDisplay1(val)
{
	var HTMLVal		=	"<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='argumentForm' id='argumentForm' "+
						" action='../../eCA/jsp/FlowSheetApplet.jsp' method='post'>"+
						"<input type='hidden' name='values' id='values' value='"+args0+"'>"+
						"<input type='hidden' name='dates' id='dates' value='"+args1+"'>"+
						"<input type='hidden' name='totcols' id='totcols' value='"+args2+"'>"+
						"<input type='hidden' name='eventval' id='eventval' value='"+args3+"'>"+
						"<input type='hidden' name='unitval' id='unitval' value='"+args4+"'>"+
						"<input type='hidden' name='seriescount' id='seriescount' value='"+args5+"'>"+
						"</form></body></html>";
		
	eval("self.chart_frame"+val+".document.body.insertAdjacentHTML('afterbegin',HTMLVal)");
	eval("self.chart_frame"+val+".document.argumentForm.submit()");
}
function callGraphDisplay(val)
{
	
		var HTMLVal		=	"<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='argumentForm' id='argumentForm' "+
						" action='../../eCA/jsp/FlowSheetApplet.jsp' method='post'>"+
						"<input type='hidden' name='values' id='values' value='"+args0[val]+"'>"+
						"<input type='hidden' name='dates' id='dates' value='"+args1[val]+"'>"+
						"<input type='hidden' name='totcols' id='totcols' value='"+args2[val]+"'>"+
						"<input type='hidden' name='eventval' id='eventval' value='"+args3[val]+"'>"+
						"<input type='hidden' name='unitval' id='unitval' value='"+args4[val]+"'>"+
						"<input type='hidden' name='seriescount' id='seriescount' value='"+args5+"'>"+
						"</form></body></html>";

	
	eval("self.chart_frame"+val+".document.body.insertAdjacentHTML('afterbegin',HTMLVal)");
	eval("self.chart_frame"+val+".document.argumentForm.submit()");
}
/********************ends here**********/

//Functions for the file name FlowSheetGraphFrame.jsp-end


//Functions for the file name FlowSheetEventsData.jsp-start

var arrObjects = new Array();
var arrValues = new Array();
var arrClassValues = new Array();

function changeColor(obj,encounter_id,eventDate,Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,histDataType,eventDesc,resultNum,textCount,classValue,sortEventDateTime,rowNum,colNum){

	var patient_id = document.dataForm.patient_id.value;
	//var encounter_id = document.dataForm.encounter_id.value;
	var enc_id = document.dataForm.enc_id.value;
	
	//if(encounter_id == '' || encounter_id == null || encounter_id == undefined) encounter_id = enc_id;
	if(enc_id == "" || enc_id == null) enc_id = "0";
	//encounter_id = enc_id;
	if(encounter_id == "" || encounter_id == null) encounter_id = "0";

	rowNum = parseInt(rowNum,10);
	colNum = parseInt(colNum,10);

	var uom = eval("parent.unitFrame.document.flowSheetEventsForm.UOM"+rowNum);
	if(uom != null && uom != undefined) uom = uom.value;
	if(uom == undefined || uom == null || uom == "") uom = "";
	Accessionnum = unescape(Accessionnum);
	eventDesc = unescape(eventDesc);

	 var addRemove = "Add";
	 var x = 0;
	 //var comImg = eval("document.forms[0].commentVisibility"+rowNum+"ID"+colNum);
	 var tdObj = eval(document.getElementById("visibility"+rowNum+"ID"+colNum));

/*	 if(obj.className == 'CAGREEN')
	 {
		addRemove = "Remove";
		obj.className = "CACHARTQRYEVEN";
	 }
	 else
	 {
		 addRemove = "Add";
		 obj.className = 'CAGREEN';
	 }*/

	 if(tdObj.className == 'gridDataSelect')
	 {
		addRemove = "Remove";
		//comImg.style.display = 'none';
		tdObj.className = 'gridDataChart';
	 }
	 else
	 {
		// x = tdObj.style.posLeft;
		 addRemove = "Add";
		// comImg.style.position = 'relative';
		// comImg.style.posLeft = x + 30;
		// comImg.style.display = 'inline';
		 tdObj.className = 'gridDataSelect';
	 }

	 var hist_data_type = histDataType;
	 var event_desc = eventDesc;
	 var result_num = resultNum;
	// var result_str = resultStr;
	 var txt_count = textCount;
 	if(result_num == "") result_num = "&nbsp;";
	//if(result_str == "") result_str = "&nbsp;";

	if(uom == " ") uom = "";

 	//var eMailVal = eventDate+"`"+Histrectype+"`"+Contrsysid+"`"+Accessionnum+"`"+Contrsyseventcode+"`"+hist_data_type+"`"+event_desc+"`"+result_num+uom+"`"+result_str;

	var valsToRemove = encounter_id+"`"+Histrectype+"`"+Contrsysid+"`"+Accessionnum+"`"+Contrsyseventcode;

	var valsToSort = encounter_id+"`"+Histrectype+"`"+sortEventDateTime+"`"+Contrsysid+"`"+Accessionnum+"`"+Contrsyseventcode;

	parent.manageEmailFrame.location.href = '../../eCA/jsp/EncountersManageEmail.jsp?addRemove='+addRemove+'&valsToRemove='+escape(valsToRemove)+'&valsToSort='+escape(valsToSort)+'&patient_id='+patient_id+'&encounter_id='+enc_id;

	/*var temp = obj.className;
	var check = 0;
	for(var i=0;i<arrObjects.length;i++){
		if(arrObjects[i] == obj){
			check++;
			if(obj.className == 'CAGREEN'){
				obj.className = arrClassValues[i];
				arrObjects[i] = null;
				arrClassValues[i] = null;
				arrValues[i] = null;
				break;
			}
		}
	}
	//alert("document.forms[0].txtFlagQuickText.value="+document.forms[0].txtFlagQuickText.value);
	if(check == 0){
		obj.className = 'CAGREEN';
		arrObjects[arrObjects.length] = obj;
		arrValues[arrValues.length] = eventDate+"`"+Histrectype+"`"+Contrsysid+"`"+Accessionnum+"`"+Contrsyseventcode;
		arrClassValues[arrClassValues.length] = temp;
		//document.forms[0].txtFlagQuickText.value ="N";
	}

	if(document.forms[0].txtFlagQuickText.value == "Y"){
		obj.className = temp;
		document.forms[0].txtFlagQuickText.value ="N";
		arrObjects = new Array();
		arrValues = new Array();
		arrClassValues = new Array();
	}*/
}


async function ShowComments(resultStr)
	{
		document.forms[0].txtFlagComments.value = 'Y';
		
		resultStr = (resultStr);
		var comments;
		var retVal;
		var dialogHeight ='300px' ;
		var dialogWidth = '500px' ;
		var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
		retVal 			= await window.showModalDialog('../../eCA/jsp/ResComments.jsp?resultStr='+resultStr,arguments,features);

		retVal =1;
		if(retVal != null && retVal != undefined){
			for(var i=0;i<arrObjects.length;i++){
				if(arrObjects[i] != null){
					var temp1 = arrClassValues[i];
					arrObjects[i].className = temp1;
				}
			}
			arrObjects = new Array();
			arrValues = new Array();
			arrClassValues = new Array();
		}
}

function getFile(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,extimageapplid)
{
	
	if(messageFrameReference == null) //added for the condition, called_from = "OR" in FlowSheetEvents.jsp
	{
		messageFrameReference = 	parent.parent.parent.messageFrame;
	}
	var htmlVal = "<html><head><link ref='stylesheet' type='text/css' href='../../eCommon/html/IeStyle/css'> </link> </head> <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'> <form name=tempForm method=post action='../../eCA/jsp/CAOpenExternalApplication.jsp'><input type=hidden name=Histrectype value='"+Histrectype+"'><input type=hidden name=Contrsysid value='"+Contrsysid+"'><input type=hidden name=Accessionnum value='"+Accessionnum+"'><input type=hidden name=Contrsyseventcode value='"+Contrsyseventcode+"'><input type=hidden name=extimageapplid value='"+extimageapplid+"'></form></body></html>"

	messageFrameReference.document.write(htmlVal);
	messageFrameReference.document.tempForm.submit();
 
}

/*function getFile(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,extn){
	document.forms[0].txtFlagQuickText.value = 'Y';
	var url = "../../eXI/reports/";
	if(extn == "jpg" || extn == "doc" || extn == "jpeg" || extn == "JPG" || extn == "DOC" || extn == "JPEG"){
		url = url +Accessionnum+"."+extn;
		window.open(url,'Document','height=570,width=790,top=0,left=0,resizable=yes');
	}else if(extn == "avi" || extn == "AVI" || extn == "dcm" || extn == "DCM"){
		callAviDcm(extn)
	}

	for(var i=0;i<arrObjects.length;i++){
		if(arrObjects[i] != null){
			var temp1 = arrClassValues[i];
			arrObjects[i].className = temp1;
		}
	}
	arrObjects = new Array();
	arrValues = new Array();
	arrClassValues = new Array();
	return false;
}*/

//function getText(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode)
async function getText(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,called_from,RepDb,clob_data)//IN065341
{
	document.forms[0].txtFlagQuickText.value = 'Y';
	var win_height		= "90vh";
	var win_width		= "80vw";
	var win_scroll_yn	= "yes";

	if(Histrectype != 'CLNT'){

		win_height		= "90vh";
		win_width		= "80vw";
		win_scroll_yn	= "no";
	}
	var retVal = new String();
	var dialogHeight = win_height ;
	var dialogWidth = win_width ;
	var dialogTop = "122";
	var status = "no";
	var scroll = win_scroll_yn;
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll+";dialogTop :" + dialogTop;
	var arguments	= Accessionnum ;

	Accessionnum	=	escape(Accessionnum);
	//retVal = window.showModalDialog("../../eCA/jsp/FlowSheetText.jsp?Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode,arguments,features);
	retVal = await window.showModalDialog("../../eCA/jsp/FlowSheetText.jsp?Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode+"&called_from="+called_from+"&RepDb="+RepDb+"&clob_data="+clob_data,arguments,features);//IN065341
	for(var i=0;i<arrObjects.length;i++){
		if(arrObjects[i] != null){
			var temp1 = arrClassValues[i];
			arrObjects[i].className = temp1;
		}
	}
	arrObjects = new Array();
	arrValues = new Array();
	arrClassValues = new Array();
	return false;
}

//Functions for the file name FlowSheetEventsData.jsp-end


//Functions for the file name FlowSheetEventsQuickTextView.jsp-start

async function ShowComments(resultStr)
	{		
		var comments;
		var retVal;
		var dialogHeight ='500px' ;
		var dialogWidth = '700px' ;
		var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
		//var arguments = resultStr;
		var arguments = escape(resultStr).replace(/\+/g,' '); //ML-BRU-SCF-1642 - IN057138
		retVal 			= await window.showModalDialog('../../eCA/jsp/QuickText.jsp',arguments,features); //ML-BRU-SCF-1642 - IN057138
}

async function getText(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode){


	var win_height		= "90vh";
	var win_width		= "80vw";
	var win_scroll_yn	= "yes";

	if(Histrectype != 'CLNT'){
		win_height		= "90vh";
		win_width		= "80vh";
		win_scroll_yn	= "no";
}


var retVal = new String();
var dialogHeight = win_height ;
var dialogWidth = win_width ;
var dialogTop = "122";
var status = "no";
var scroll = win_scroll_yn;
var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll+";dialogTop :" + dialogTop;
var arguments	= Accessionnum ;

Accessionnum	=	escape(Accessionnum);
retVal = await window.showModalDialog("../../eCA/jsp/FlowSheetText.jsp?Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode,arguments,features);
return false;
}

//Functions for the file name FlowSheetEventsQuickTextView.jsp-end



//Functions for the file name FlowSheetEventsQuickText.jsp-start

function fnClear(){
	document.frmQuickTextButtons.reset();
}

function fnCancel(){
	//window.close();
	//window.returnValue = "";
	
    /*const dialogTag = parent.document.getElementById("dialog_tag");    
    dialogTag.close();
	let dialogBody = parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = "";*/
	
	var diagElement = parent.parent.document.getElementsByTagName("dialog");
								var i = 0; var j = 0;
	    						for (i = 0; i < diagElement.length; i++) {
	    							for (j = 0; j < diagElement[i].children.length; j++) {
	    								var element = diagElement[i].children[j];
	    								let dialogSrc = element.src;
	    								if (typeof dialogSrc !== "undefined")
	    								{ 
											if (dialogSrc.includes("FlowSheetEventsQuickTextMain.jsp")) 
											{
		        								var dialogTag = diagElement[i];    
												dialogTag.close(); 
											}
	    								}    		
	    							} 
								}
}

function fnRecord(){
	if(document.frmQuickTextButtons.txtRemarks.value == ""){
		alert(getMessage("REMARKS_CANNOT_BLANK",'CA'));
		document.frmQuickTextButtons.txtRemarks.focus();
		return false;
	}
	//document.frmQuickText.submit();
	document.frmQuickTextButtons.txtHistRecTypes.value = parent.details.document.frmQuickText.txtHistRecTypes.value;
	document.frmQuickTextButtons.txtContrSysIds.value = parent.details.document.frmQuickText.txtContrSysIds.value;
	document.frmQuickTextButtons.txtAccessionNos.value = parent.details.document.frmQuickText.txtAccessionNos.value;
	document.frmQuickTextButtons.txtEventCodes.value = parent.details.document.frmQuickText.txtEventCodes.value;
	document.frmQuickTextButtons.submit();
}

async function ShowCommentstext(resultStr)
{
		resultStr = escape(resultStr);
		var comments;
		var retVal;
		var dialogHeight ='300px' ;
		var dialogWidth = '500px' ;
		var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
		retVal 			= await window.showModalDialog('../../eCA/jsp/ResComments.jsp?resultStr='+resultStr,arguments,features);
		//return false;
}

//function getText(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode){//IN031989
async function getText(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,enctr_id,fac_id){//IN031989//IN033489

	var patient_id = document.forms[0].patient_id.value;//INO30714
//	var enc_id = document.forms[0].enc_id.value;//commented for IN068080
	var win_height		= "90vh";
	var win_width		= "80vw";
	var win_scroll_yn	= "yes";
	//IN052637 Start.
	/*if(Histrectype != 'CLNT'){
		win_height		= "37.5";
		win_width		= "50";
		win_top			= "200";
		//win_scroll_yn	= "no";
	}
	*/	
	var features1="";
	if(Histrectype != 'CLNT'){
		win_height		= "90vh";
		win_width		= "80vw";
		win_top			= "10";
	}else{		
		win_height		= "90vh";
		win_width		= "80vw";
		
		if(win_width==undefined){
			win_height		= (document.documentElement.clientHeight);
			win_width		= (document.documentElement.clientWidth);			
			if(win_height==0){				
				win_height		= (parseInt(document.body.clientHeight));
				win_width		= (parseInt(document.body.clientWidth));				
			}			 
		}		
		win_top			= "0px";
		features1 ="resizable=yes;maximize:yes;minimize:no;";
	}	
	//IN052637 End.
	var retVal = new String();
	var dialogHeight = win_height ;
	var dialogWidth = win_width ;
	var dialogTop = win_top;
	var status = "no";
	var scroll = win_scroll_yn;
	//IN052637 Start.
	//var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll+";dialogTop :" + dialogTop+";";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll+";dialogTop :" + dialogTop+";"+features1;
	//IN052637 End.
	var arguments	= Accessionnum ;

	Accessionnum	=	escape(Accessionnum);
	//var finalString	= "Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode+"&patient_id="+patient_id+"&enc_id="+enc_id;//INO30714
	var finalString	= "Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode+"&patient_id="+patient_id+"&enc_id="+enctr_id+"&fac_id="+fac_id;//IN031989//IN033489
	//retVal = window.showModalDialog("../../eCA/jsp/FlowSheetText.jsp?Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode,arguments,features);//INO30714
	retVal = await top.window.showModalDialog("../../eCA/jsp/FlowSheetText.jsp?"+finalString,arguments,features);//INO30714
	return false;
}


//Functions for the file name FlowSheetEventsQuickText.jsp-end 

//Functions for the file name FlowSheetEventsData-start

async function enterQuickText(eventDate,Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,singleMultiFlag)
{
	var qsForComments = document.forms[0].queryStringForComments.value;
	var patient_id = document.forms[0].patient_id.value;
	var encounter_id = document.forms[0].encounter_id.value;
	var enc_id = document.forms[0].enc_id.value;
	var fac_id = document.forms[0].fac_id.value;//IN033489
	var enctr_id = document.forms[0].enctr_id.value;//IN033489
	var viewConfRes = document.forms[0].viewConfRes.value;
	var graphorder = document.forms[0].graphorder.value;
	var flowsheetCompId = document.forms[0].flowsheetCompId.value;
	var errorEvent = document.forms[0].errorEvent.value;
	//if(encounter_id == '' || encounter_id == null || encounter_id == undefined) encounter_id = enc_id;

	if(enc_id == "" || enc_id == null) enc_id = "0";
	encounter_id = enc_id;

	if(singleMultiFlag == null)
	{
		singleMultiFlag='M';
     }

	document.forms[0].txtFlagQuickText.value = 'Y';
	var tempValues = "";
	var count=0;
	for(var i=0;i<arrObjects.length;i++){
		if(arrObjects[i] != null){
			//alert(arrObjects[i]);
			count++;
		}
	}

/*	if(count == 0 && singleMultiFlag == "M"){
		alert(getMessage("EVENTS_FOR_QUICKTEXT","CA"));
		return false;
	}*/
	count =0;

	for(var i=0;i<arrObjects.length;i++){
		if(arrObjects[i] != null){
			//alert(arrValues[i]);
			tempValues+= "~"+arrValues[i];
			count++;
		}
	}

	if(count == 0){
		tempValues+= "~"+eventDate+"`"+Histrectype+"`"+Contrsysid+"`"+Accessionnum+"`"+Contrsyseventcode;
		count =1;
	}


	if(tempValues != ""){
		tempValues = tempValues.substring(1);
	}

	var dialogHeight= "90vw" ;
	var dialogWidth	= "80vh" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;	
	
	//var retVal = window.showModalDialog("../../eCA/jsp/FlowSheetEventsQuickTextMain.jsp?qsForComments="+qsForComments+"&quickTextCodes="+tempValues+"&singleMultiFlag="+singleMultiFlag+"&noOfEvents="+count+"&graphorder="+graphorder+"&flowsheetCompId="+flowsheetCompId+"&errorEvent="+errorEvent+"&viewConfRes="+viewConfRes+"&patient_id="+patient_id+"&encounter_id="+encounter_id,'',features);//IN033489
	var retVal = await window.showModalDialog("../../eCA/jsp/FlowSheetEventsQuickTextMain.jsp?qsForComments="+qsForComments+"&quickTextCodes="+tempValues+"&singleMultiFlag="+singleMultiFlag+"&noOfEvents="+count+"&graphorder="+graphorder+"&flowsheetCompId="+flowsheetCompId+"&errorEvent="+errorEvent+"&viewConfRes="+viewConfRes+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&fac_id="+fac_id+"&enctr_id="+enctr_id,'',features);//IN033489
	//var retVal = window.open("../../eCA/jsp/FlowSheetEventsQuickTextMain.jsp?quickTextCodes="+tempValues);	
	//retVal =1;
	if(retVal != null && retVal != undefined && retVal != "")
	{
		//self.location.reload();
		parent.dataFrame.location = parent.dataFrame.location;
	}
	return false;		
}

function enableEventGrp(obj)
{
	if(obj.value != '')
	{
		document.flowsheet_criteria_form.event_group1.readOnly = false;
		document.flowsheet_criteria_form.event_group_but.disabled = false;
	}
	else
	{		
		document.flowsheet_criteria_form.event_group1.value = "";
		document.flowsheet_criteria_form.event_group.value = "";
		document.flowsheet_criteria_form.event_group1.readOnly = true;
		document.flowsheet_criteria_form.event_group_but.disabled = true;		
	}
}

function collapseColumn(colNum)
{
	var totalRows = document.dataForm.totRows.value;
	var totalCols = document.dataForm.totCols.value;	
	//alert("Columns = "+totalCols);
	//alert("Rows = "+totalRows);
	var obj = eval(document.getElementById("visID"+colNum));
	var objDup = eval(document.getElementById("visIDup"+colNum));
	var objPrev = eval(document.getElementById("visID"+(parseInt(colNum,10)+1)));	
	//IN058144 Start.
	var objCel = eval(document.getElementById("cellID"+colNum).value);
	var objTh = eval(document.getElementById("rowId"+objCel));
	document.getElementById("rowIdT1"+objCel).value = (parseInt(eval(document.getElementById("rowIdT1"+objCel).value))-1);
	if(eval(document.getElementById("rowIdT1"+objCel)).value==0)
		objTh.innerHTML = "+ &nbsp;";
	//IN058144 End.
	var oldText = obj.innerText;
	var oldWidth = obj.width;
	//IN058144 Start.
	//obj.width = "10%";
	//objDup.width = "10%";
	obj.width = "10px";
	objDup.width = "10px";
	//IN058144 End.
	obj.height = parent.unitFrame.document.getElementById("unitTitleTable").rows[0].height;	
	obj.innerHTML = "<a href=`javascript:expandColumn(\""+colNum+"\",\""+oldText+"\",\""+oldWidth+"\")` title='Click here to view "+oldText+"'>+ &nbsp;</a>";
	objDup.innerHTML = "<a href=`javascript:expandColumn(\""+colNum+"\",\""+oldText+"\",\""+oldWidth+"\")` title='Click here to view "+oldText+"'>+ &nbsp;</a>";
	
	var colIDs = "";
	var dupColIDs = "";
	var colHead = "";
	var colIDsTemp = "";
	var colIDsTemp1 = "";
	var sepID = "";
	var dupID = "";
	var duplicateID = "";
	var dummy = "";
	var dummy1 = "";
	var dummy2 = 0;
	var temp = 0;
	var imageFlowTxtVis = "";

	for(var i=0;i<totalRows;i++)
	{
		/*imageFlowTxtVis = eval("document.getElementById("imageFlowTextVis")"+i+"ID"+colNum);
		if(imageFlowTxtVis != undefined)
		{
			imageFlowTxtVis.style.display = "none";
		}*/
		colIDs = eval(document.getElementById("visibility"+i+"ID"+colNum));
		if(colIDs != undefined)
		{
			colIDs.style.display = "none";	
		}
		dupColIDs = eval(document.getElementById("duplicate"+i+"ID"+colNum));
		if(dupColIDs != undefined)
		{
			dupColIDs.style.display = "inline";
		}
		//document.dataForm.totCols.value = parseInt(totalCols,10) - 1;
		sepID = eval(document.getElementById("sepID"+i));
		if(sepID == null || sepID == "undefined")
		{		
			//colIDs = eval("document.getElementById("visibility")"+i+"ID"+colNum);
			//dupColIDs = eval("document.getElementById("duplicate")"+i+"ID"+colNum);
			//colIDs.style.display = "none";	
			//dupColIDs.style.display = "inline";
			//document.dataForm.totCols.value = parseInt(totalCols,10) - 1;
		}		
	}
	alignHeight();
	alignUnitsAndData(); //IN058144
}

function expandColumn(colNum,oldText,oldWidth)
{
	var totalRows = document.dataForm.totRows.value;
	var totalCols = document.dataForm.totCols.value;	
	var obj = eval(document.getElementById("visID"+colNum));
	var objDup = eval(document.getElementById("visIDup"+colNum));
	obj.width = oldWidth;
	objDup.width = oldWidth;
	//IN058144 Start.
	var objCel = eval(document.getElementById("cellID"+colNum).value);
	var objTh = eval(document.getElementById("rowId"+objCel));	
	document.getElementById("rowIdT1"+objCel).value = parseInt(eval(document.getElementById("rowIdT1"+objCel).value)+1);
	objTh.innerHTML = eval(document.getElementById("rowIdT2"+objCel).value);
	//IN058144 End.
	
	obj.innerHTML = "<a href=`javascript:collapseColumn(\""+colNum+"\")`title='Click here to collapse the column'>"+oldText+"</a><br>";
	obj.noWrap = true;
	objDup.innerHTML = "<a href=`javascript:collapseColumn(\""+colNum+"\")`>"+oldText+"</a><br>";

	var colIDs = "";
	var sepID = "";
	var duplicateID = "";
	var dupID = "";
	var imageFlowTxtVis = "";
	for(var i=0;i<totalRows;i++)
	{
		/*imageFlowTxtVis = eval("document.getElementById("imageFlowTextVis")"+i+"ID"+colNum);
		if(imageFlowTxtVis != undefined)
		{
			imageFlowTxtVis.style.display = "inline";
		}*/
		colIDs = eval(document.getElementById("visibility"+i+"ID"+colNum));
		if(colIDs != undefined)
		{
			colIDs.style.display = "inline";
		}
		duplicateID = eval(document.getElementById("duplicate"+i+"ID"+colNum));	
		if(duplicateID != undefined)
		{
			duplicateID.style.display = "none";
		}
		//document.dataForm.totCols.value = parseInt(totalCols,10) + 1;
		sepID = eval(document.getElementById("sepID"+i));
		//dupID = eval("document.getElementById("dupID")"+i);
		if(sepID == null)
		{
			//colIDs = eval("document.getElementById("visibility")"+i+"ID"+colNum);
			//duplicateID = eval("document.getElementById("duplicate")"+i+"ID"+colNum);						
			//colIDs.style.display = "inline";
			//duplicateID.style.display = "none";
			//document.dataForm.totCols.value = parseInt(totalCols,10) + 1;
		}		
	}
	
	alignHeight();
	alignUnitsAndData(); //IN058144
}
//Functions for the file name FlowSheetEventsData-end

function loadPrevNext(obj)
{
	var called_from = parent.controlsFrame.document.forms[0].called_from;
	var NxtBtn		= parent.controlsFrame.document.forms[0].next;
	
	var PrvBtn		= parent.controlsFrame.document.forms[0].prev;

	var curidxval	= eval(parent.controlsFrame.document.forms[0].cur_idx_value.value);
	
	var totalidx	= eval(parent.controlsFrame.document.forms[0].idx_value.value);
	
	var graphorder	= parent.controlsFrame.document.forms[0].strGraphOrder.value;
	var uptoidxval = 0;

	if(obj.id == 'next')
	{
		//alert("inside if");
		if(curidxval < totalidx)
		{
			curidxval++;
			uptoidxval = curidxval+1;
		
			if(uptoidxval > totalidx)
				uptoidxval = curidxval;
		}
	}
	else if(obj.id == 'prev')
	{
		if(curidxval > 0)
		{
			curidxval--;
			uptoidxval = eval(curidxval)+1;
			
			if(uptoidxval < 0)
				uptoidxval = 0;
		}
	}
	else if(obj.id == 'first')
	{
		curidxval = 0;
		uptoidxval = eval(curidxval)+1;
	}
	else if(obj.id == 'last')
	{
		curidxval = totalidx - 1;
		uptoidxval = totalidx;
		
	}
	//NxtBtn.disabled = true;
	//PrvBtn.disabled = true;
	var displstart	= eval(curidxval) + 1;
	var displend	= eval(totalidx); 

	parent.controlsFrame.document.getElementById("label_cap").innerText = "Page "+ displstart + " of " + displend;
	parent.controlsFrame.document.forms[0].cur_idx_value.value = curidxval;

	/*
	if (uptoidxval == totalidx )
		NxtBtn.disabled = true;
	else
		NxtBtn.disabled = false;
	
	if (curidxval == 0)
		PrvBtn.disabled = true;
	else
		PrvBtn.disabled = false;
		*/
	
	var firstDateTime;
	var lastDateTime;

	if((graphorder == "asc") || (graphorder == "A"))
	{
		firstDateTime	= dtArr[curidxval]
		lastDateTime	= dtArr[uptoidxval]
	}
	else
	  if ((graphorder == "desc") || (graphorder == "D"))
	{
		firstDateTime	= dtArr[uptoidxval]
		lastDateTime	= dtArr[curidxval]

	}

	if(called_from.value=="OR")
		populateControlOR(firstDateTime,lastDateTime)
	else
		populateControl(firstDateTime,lastDateTime);
}






function constructValsForGraph(rowNumber)
{
	var obj = document.getElementById("chkGraphID"+rowNumber);
	if(parent.dataFrame.document.forms[0] != null)
	{
		var noOfChkdBoxes =  parseInt(parent.unitFrame.document.forms[0].noOfChkdBoxes.value);

		if(obj.checked == true)
		{
			//alert("here"+noOfChkdBoxes);
			if(noOfChkdBoxes > 9)
			{
				alert(getMessage('NO_OF_EVENTS_MORE_THAN_10','CA'));
				obj.checked = false;
				return false;
			}
			else
				parent.unitFrame.document.forms[0].noOfChkdBoxes.value = noOfChkdBoxes+1;
		}
		else if(obj.checked == false)
			parent.unitFrame.document.forms[0].noOfChkdBoxes.value = noOfChkdBoxes-1;

		var patient_id = parent.dataFrame.document.dataForm.patient_id.value;
		var encounter_id = parent.dataFrame.document.dataForm.encounter_id.value;
		var enc_id = parent.dataFrame.document.dataForm.enc_id.value;

		if((encounter_id=="")||(encounter_id==null)||(encounter_id=="null"))
			encounter_id =0;

		if((enc_id=="")||(enc_id==null)||(enc_id=="null"))
			enc_id =0; 
	
		var colCount = parseInt(parent.dataFrame.document.dataForm.finalTotCols.value,10);
		var tdObj;
		var tdObjValue;
		var concTdObjValues = "";
		
		var code = document.getElementById("chkGraphID"+rowNumber).value;
		var desc = eval("document.flowSheetEventsForm.desc"+rowNumber.value);
		var UOM = eval("document.flowSheetEventsForm.UOM"+rowNumber).value;

		for(var j=0;j<colCount;j++)
		{
			tdObj = eval(parent.dataFrame.document.getElementById("hidden"+parseInt(rowNumber,10)+"Values"+j));
			if(tdObj != null)
			{
				tdObjValue = tdObj.value;
				concTdObjValues = concTdObjValues + tdObjValue +">";
			}
		}
		parent.parent.addToGroupsFrame.document.write("<html><form name='chartRecAddToGrpFrom' id='chartRecAddToGrpFrom' action='../../eCA/jsp/ChartRecordingAddToGrpIntermediate.jsp'><input type='hidden' name='ChkdBoxes' id='ChkdBoxes' value = '"+obj.checked+"'><input type='hidden' name='desc' id='desc' value = '"+encodeURIComponent(desc,"UTF-8")+"'><input type='hidden' name='code' id='code' value = '"+code+"'><input type='hidden' name='concTdObjValues' id='concTdObjValues' value = '"+concTdObjValues+"'><input type='hidden' name='uom' id='uom' value = '"+UOM+"'><input type='hidden' name='patient_id' id='patient_id' value = '"+patient_id+"'><input type='hidden' name='encounter_id' id='encounter_id' value = '"+enc_id+"'><input type='hidden' name='flowsheetGraph' id='flowsheetGraph' value = 'Y'></form></html>");
		parent.parent.addToGroupsFrame.document.chartRecAddToGrpFrom.submit();
	}

}

function populateControl(fmDt,toDt)
{
	workAreaFrameReference = getWorkAreaCriteriaFrame();

	var patientid		= workAreaFrameReference.document.forms[0].Patient_id.value;
	var episodetype		= workAreaFrameReference.document.forms[0].episode_type.value;

	var eventclass		= workAreaFrameReference.document.forms[0].event_class.value;

	var eventgroup		= workAreaFrameReference.document.forms[0].event_group.value;

	
	var eventitem		= workAreaFrameReference.document.forms[0].event_item.value;

	var stdParams		= workAreaFrameReference.document.forms[0].queryStrForCmnts.value;
	var viewConfRes		= workAreaFrameReference.document.forms[0].viewConfRes.value;
	var historytype		= workAreaFrameReference.document.forms[0].history_type.value;
	var facility_id		= workAreaFrameReference.document.forms[0].facility_id.value;
	var graphorder		= workAreaFrameReference.document.forms[0].graphorder.value;
	
	var encounter_id	= workAreaFrameReference.document.forms[0].encounter_id.value;
	var enc_id	= workAreaFrameReference.document.forms[0].enc_id.value;
	var relationship_id	= workAreaFrameReference.document.forms[0].relationship_id.value;

	var fromdate		= workAreaFrameReference.document.forms[0].from_date.value;
	var todate			= workAreaFrameReference.document.forms[0].to_date.value;
	var show_mode='';
	var p_called_from		= workAreaFrameReference.document.forms[0].p_called_from_widget.value;//CHL_CRF_0044
	var p_event_class			= workAreaFrameReference.document.forms[0].p_event_class_widget.value;//CHL_CRF_0044
	var hist_type			= workAreaFrameReference.document.forms[0].hist_type.value;//CHL_CRF_0044
	var speciality_code		= workAreaFrameReference.document.forms[0].speciality_code.value; // MMS-QH-CRF-0177 [IN047572] 
	var attend_pract_code	= workAreaFrameReference.document.forms[0].attend_pract_code.value; //MMS-QH-CRF-0177 [IN047572] 
	var isSiteSpecificForLabPrint = workAreaFrameReference.document.forms[0].isSiteSpecificForLabPrint.value;//IN066453
	var p_review_rad_yn		= workAreaFrameReference.document.forms[0].p_review_rad_yn.value;//IN071561
	if(workAreaFrameReference.document.forms[0].show_mode[0].checked)			
		 show_mode=workAreaFrameReference.document.forms[0].show_mode[0].value;	

	else if(workAreaFrameReference.document.forms[0].show_mode[1].checked)			
		 show_mode=workAreaFrameReference.document.forms[0].show_mode[1].value;	
	//var EHR_YN			= workAreaFrameReference.document.forms[0].EHR_YN.value;

	var order_type_3T		= workAreaFrameReference.document.forms[0].order_type_3T.value; //39052
	//var called_from		= workAreaFrameReference.document.forms[0].called_from.value;
	var archivalYN		= workAreaFrameReference.document.forms[0].archivalYN.value; //52176
	if(fmDt == undefined)
		fmDt = '';
	if(toDt == undefined)
		toDt = '';

	var abnormal = "";
	// added for IN034514 - Start
	var encntr_yn = "";
	if(encounter_id == ""){
		encntr_yn = "N";
	}
	else {
		encntr_yn = "";
	}
	// added for IN034514 - End
	if(workAreaFrameReference.document.forms[0].chkAbnormal.checked)
		abnormal = "Y";
	else
		abnormal = "N";
	// INT-CRF-BRU-CIS-004 - IN058138 - Start
	var order_by_evtcode = "";
	
	if(workAreaFrameReference.document.forms[0].orderByEvent.checked)
		order_by_evtcode = "Y";
	else
		order_by_evtcode = "N";
	// INT-CRF-BRU-CIS-004 - IN058138 - End
	if(workAreaFrameReference.document.forms[0].view_mode[0].checked)
	{
		if(parent.myFrameSet != null)
		{
			/**  Modified by kishor kumar N on 05/12/2008 for the CRF 0387
				Modified width of frameset
			**/
			//parent.myFrameSet.rows = '26%,*,0%'; // modified from 22 to 24 for IN058886 -- // modified from 24 to 26 for MMS-QH-CRF-0177 [IN047572]
			parent.document.getElementById("criteria_f1").style.height="17vh";
			parent.document.getElementById("details").style.height="77vh";
			parent.document.getElementById("addToGroupsFrame").style.height="0vh";
			/** ends here **/
		}
		var flowSheetComp	= workAreaFrameReference.document.forms[0].cboFlowSheetComp.value;
		//var normalcy = "";
		var normalcy = workAreaFrameReference.document.forms[0].cboNormalcyInd.value;
		var errorEvent ="N";
		if(!doDateCheckFrom(workAreaFrameReference.document.forms[0].to_date,workAreaFrameReference.document.forms[0].from_date))
				return ;

		if (fmDt == '' && toDt == '' )
		{
		
			
			dtArr = new Array();
			//var HTMLVal = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name=PopulateFlowSheetClass method=post 	action=\"../../eCA/jsp/FlowSheetDetails.jsp?graphorder="+graphorder+"&errorEvent="+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&cboFlowSheetComp="+flowSheetComp+"&viewConfRes="+viewConfRes+"&c_from_date="+fromdate+"&c_to_date="+todate+"&p_patient_id="+patientid+"&p_hist_rec_type="+historytype+"&p_event_class="+eventclass+"&p_event_group="+eventgroup+"&episode_type="+episodetype+"&encounter_id="+encounter_id+"&c_facility_id="+facility_id+"&eventitem="+eventitem+"&enc_id="+enc_id+"&stdParams="+stdParams+"&show_mode="+show_mode+"&relationship_id="+relationship_id+"\"> </form></body></html>";//CHL_CRF_0044
			//var HTMLVal = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name=PopulateFlowSheetClass method=post 	action=\"../../eCA/jsp/FlowSheetDetails.jsp?graphorder="+graphorder+"&errorEvent="+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&cboFlowSheetComp="+flowSheetComp+"&viewConfRes="+viewConfRes+"&c_from_date="+fromdate+"&c_to_date="+todate+"&p_patient_id="+patientid+"&p_hist_rec_type="+historytype+"&p_event_class="+eventclass+"&p_event_group="+eventgroup+"&episode_type="+episodetype+"&encounter_id="+encounter_id+"&c_facility_id="+facility_id+"&eventitem="+eventitem+"&enc_id="+enc_id+"&stdParams="+stdParams+"&show_mode="+show_mode+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&p_hist_type="+hist_type+"\"> </form></body></html>";//CHL_CRF_0044 0 -- commented for  BRU-HIMS-CRF-356 [IN038643]
			//var HTMLVal = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name=PopulateFlowSheetClass method=post 	action=\"../../eCA/jsp/FlowSheetDetails.jsp?graphorder="+graphorder+"&errorEvent="+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&cboFlowSheetComp="+flowSheetComp+"&viewConfRes="+viewConfRes+"&c_from_date="+fromdate+"&c_to_date="+todate+"&p_patient_id="+patientid+"&p_hist_rec_type="+historytype+"&p_event_class="+eventclass+"&p_event_group="+eventgroup+"&episode_type="+episodetype+"&encounter_id="+encounter_id+"&c_facility_id="+facility_id+"&eventitem="+eventitem+"&enc_id="+enc_id+"&stdParams="+stdParams+"&show_mode="+show_mode+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&p_hist_type="+hist_type+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code+"\"> </form></body></html>"; // modified for  MMS-QH-CRF-0177 [IN047572] ->commented for IN066453
			var HTMLVal = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name=PopulateFlowSheetClass method=post 	action=\"../../eCA/jsp/FlowSheetDetails.jsp?isSiteSpecificForLabPrint="+isSiteSpecificForLabPrint+"&graphorder="+graphorder+"&errorEvent="+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&cboFlowSheetComp="+flowSheetComp+"&viewConfRes="+viewConfRes+"&c_from_date="+fromdate+"&c_to_date="+todate+"&p_patient_id="+patientid+"&p_hist_rec_type="+historytype+"&p_event_class="+eventclass+"&p_event_group="+eventgroup+"&episode_type="+episodetype+"&encounter_id="+encounter_id+"&c_facility_id="+facility_id+"&eventitem="+eventitem+"&enc_id="+enc_id+"&stdParams="+stdParams+"&show_mode="+show_mode+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&p_hist_type="+hist_type+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code+"&order_type_3T="+order_type_3T+"\"> </form></body></html>"; // modified for IN066453
			if(top.content!=null && !top.document.getElementById('dialog-body'))
			{
				top.content.workAreaFrame.details.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				top.content.workAreaFrame.details.document.forms[0].submit();
			}
			else
			{
				
				parent.details.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				
				parent.details.document.forms[0].submit();
			}
		}
		else
		{
			//parent.unitFrame.location.href = "../../eCA/jsp/FlowSheetEvents.jsp?graphorder="+graphorder+"&errorEvent="+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&cboFlowSheetComp="+flowSheetComp+"&viewConfRes="+viewConfRes+"&c_from_date="+fmDt+"&c_to_date="+toDt+"&p_patient_id="+patientid+"&p_hist_rec_type="+historytype+"&p_event_class="+eventclass+"&p_event_group="+eventgroup+"&episode_type="+episodetype+"&encounter_id="+encounter_id+"&c_facility_id="+facility_id+"&eventitem="+eventitem+"&enc_id="+enc_id+"&stdParams="+stdParams+"&show_mode="+show_mode;//CHL_CRF_0044
			//parent.unitFrame.location.href = "../../eCA/jsp/FlowSheetEvents.jsp?graphorder="+graphorder+"&errorEvent="+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&cboFlowSheetComp="+flowSheetComp+"&viewConfRes="+viewConfRes+"&c_from_date="+fmDt+"&c_to_date="+toDt+"&p_patient_id="+patientid+"&p_hist_rec_type="+historytype+"&p_event_class="+eventclass+"&p_event_group="+eventgroup+"&episode_type="+episodetype+"&encounter_id="+encounter_id+"&c_facility_id="+facility_id+"&eventitem="+eventitem+"&enc_id="+enc_id+"&stdParams="+stdParams+"&show_mode="+show_mode+"&p_event_class_widget="+p_event_class+"&hist_type="+p_called_from+"&p_hist_type="+hist_type+"&p_order_by_evtcode="+order_by_evtcode;//CHL_CRF_0044 // added 'order_by_evtcode' for INT-CRF-BRU-CIS-004 - IN058138 -- //commented for  BRU-HIMS-CRF-356 [IN038643]
      //parent.unitFrame.location.href = "../../eCA/jsp/FlowSheetEvents.jsp?graphorder="+graphorder+"&errorEvent="+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&cboFlowSheetComp="+flowSheetComp+"&viewConfRes="+viewConfRes+"&c_from_date="+fmDt+"&c_to_date="+toDt+"&p_patient_id="+patientid+"&p_hist_rec_type="+historytype+"&p_event_class="+eventclass+"&p_event_group="+eventgroup+"&episode_type="+episodetype+"&encounter_id="+encounter_id+"&c_facility_id="+facility_id+"&eventitem="+eventitem+"&enc_id="+enc_id+"&stdParams="+stdParams+"&show_mode="+show_mode+"&p_event_class_widget="+p_event_class+"&hist_type="+p_called_from+"&p_hist_type="+hist_type+"&p_order_by_evtcode="+order_by_evtcode+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code; //modified for MMS-QH-CRF-0177 [IN047572] //IN071561
			parent.unitFrame.location.href = "../../eCA/jsp/FlowSheetEvents.jsp?graphorder="+graphorder+"&errorEvent="+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&cboFlowSheetComp="+flowSheetComp+"&viewConfRes="+viewConfRes+"&c_from_date="+fmDt+"&c_to_date="+toDt+"&p_patient_id="+patientid+"&p_hist_rec_type="+historytype+"&p_event_class="+eventclass+"&p_event_group="+eventgroup+"&episode_type="+episodetype+"&encounter_id="+encounter_id+"&c_facility_id="+facility_id+"&eventitem="+eventitem+"&enc_id="+enc_id+"&stdParams="+stdParams+"&show_mode="+show_mode+"&p_event_class_widget="+p_event_class+"&hist_type="+p_called_from+"&p_hist_type="+hist_type+"&p_order_by_evtcode="+order_by_evtcode+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code+"&p_review_rad_yn="+p_review_rad_yn+"&order_type_3T="+order_type_3T; //modified for MMS-QH-CRF-0177 [IN047572] //IN071561
		}
	}
	else if(workAreaFrameReference.document.forms[0].view_mode[1].checked)
	{
			var episode_wise = "N";
			var view_by="";
			//CHL-CRF Start. [Ramesh]
			if(p_called_from=="CA_RESULTS_WIDGET"){
				//if(top.content == null) parent.myFrameSet.rows = '26%,*,6%,0%'; // modified from 22 to 24 for IN058886 - modified from 24 to 26 for BRU-HIMS-CRF-356 [IN038643]
				if(top.content == null) {
					parent.document.getElementById("criteria_f1").style.height="17vh";
					parent.document.getElementById("details").style.height="77vh";
					parent.document.getElementById("addToGroupsFrame").style.height="0vh";
				}
			}else{
			//CHL-CRF End.[Ramesh]
				//if(top.content == null) parent.myFrameSet.rows = '26%,*,0%'; // modified from 22 to 24 for IN058886 - modified from 24 to 26 for BRU-HIMS-CRF-356 [IN038643]
				if(top.content == null)
				{
					parent.document.getElementById("criteria_f1").style.height="17vh";
					parent.document.getElementById("details").style.height="77vh";
					parent.document.getElementById("addToGroupsFrame").style.height="0vh";
				}
				
			}//CHL-CRF [Ramesh]
			if(workAreaFrameReference.document.forms[0].view_by[0].checked)
				view_by = workAreaFrameReference.document.forms[0].view_by[0].value;
			else if(workAreaFrameReference.document.forms[0].view_by[1].checked)
				view_by = workAreaFrameReference.document.forms[0].view_by[1].value;
			
			normalcy = workAreaFrameReference.document.forms[0].cboNormalcyInd.value;	
			if (fmDt == '' && toDt == '' )
			{
				//var params = '?patient_id='+patientid+'&episode_type='+episodetype+'&hist_type='+historytype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&from_date='+fromdate+'&to_date='+todate+'&view_by='+view_by+'&episode_wise='+episode_wise+'&facility_id='+facility_id+'&encounter_id='+encounter_id+'&performed_by=&errorEvent='+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&viewConfRes="+viewConfRes+'&enc_id='+enc_id+"&graphorder="+graphorder+"&stdParams="+stdParams+"&EHR_YN="+EHR_YN;
				//var params = '?patient_id='+patientid+'&episode_type='+episodetype+'&hist_type='+historytype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&from_date='+fromdate+'&to_date='+todate+'&view_by='+view_by+'&episode_wise='+episode_wise+'&facility_id='+facility_id+'&encounter_id='+encounter_id+'&performed_by=&errorEvent='+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&viewConfRes="+viewConfRes+'&enc_id='+enc_id+"&graphorder="+graphorder+"&stdParams="+stdParams+"&show_mode="+show_mode+"&relationship_id="+relationship_id;//CHL_CRF_0044
				//var params = '?patient_id='+patientid+'&episode_type='+episodetype+'&hist_type='+historytype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&from_date='+fromdate+'&to_date='+todate+'&view_by='+view_by+'&episode_wise='+episode_wise+'&facility_id='+facility_id+'&encounter_id='+encounter_id+'&performed_by=&errorEvent='+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&viewConfRes="+viewConfRes+'&enc_id='+enc_id+"&graphorder="+graphorder+"&stdParams="+stdParams+"&show_mode="+show_mode+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&p_hist_type="+hist_type;//CHL_CRF_0044 commented for IN034514
				//var params = '?patient_id='+patientid+'&episode_type='+episodetype+'&hist_type='+historytype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&from_date='+fromdate+'&to_date='+todate+'&view_by='+view_by+'&episode_wise='+episode_wise+'&facility_id='+facility_id+'&encounter_id='+encounter_id+'&performed_by=&errorEvent='+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&viewConfRes="+viewConfRes+'&enc_id='+enc_id+"&graphorder="+graphorder+"&stdParams="+stdParams+"&show_mode="+show_mode+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&p_hist_type="+hist_type+"&encntr_yn="+encntr_yn;//added for IN034514  -- commented for  BRU-HIMS-CRF-356 [IN038643]
				//var params = '?patient_id='+patientid+'&episode_type='+episodetype+'&hist_type='+historytype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&from_date='+fromdate+'&to_date='+todate+'&view_by='+view_by+'&episode_wise='+episode_wise+'&facility_id='+facility_id+'&encounter_id='+encounter_id+'&performed_by=&errorEvent='+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&viewConfRes="+viewConfRes+'&enc_id='+enc_id+"&graphorder="+graphorder+"&stdParams="+stdParams+"&show_mode="+show_mode+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&p_hist_type="+hist_type+"&encntr_yn="+encntr_yn+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code; //modified for  MMS-QH-CRF-0177 [IN047572] commented for IN066453
        //var params = '?patient_id='+patientid+'&episode_type='+episodetype+'&hist_type='+historytype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&from_date='+fromdate+'&to_date='+todate+'&view_by='+view_by+'&episode_wise='+episode_wise+'&facility_id='+facility_id+'&encounter_id='+encounter_id+'&performed_by=&errorEvent='+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&viewConfRes="+viewConfRes+'&enc_id='+enc_id+"&graphorder="+graphorder+"&stdParams="+stdParams+"&show_mode="+show_mode+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&p_hist_type="+hist_type+"&encntr_yn="+encntr_yn+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code+"&isSiteSpecificForLabPrint="+isSiteSpecificForLabPrint; //modified for IN066453//IN071561
        var params = '?patient_id='+patientid+'&episode_type='+episodetype+'&hist_type='+historytype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&from_date='+fromdate+'&to_date='+todate+'&view_by='+view_by+'&episode_wise='+episode_wise+'&facility_id='+facility_id+'&encounter_id='+encounter_id+'&performed_by=&errorEvent='+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&viewConfRes="+viewConfRes+'&enc_id='+enc_id+"&graphorder="+graphorder+"&stdParams="+stdParams+"&show_mode="+show_mode+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&p_hist_type="+hist_type+"&encntr_yn="+encntr_yn+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code+"&isSiteSpecificForLabPrint="+isSiteSpecificForLabPrint+"&p_review_rad_yn="+p_review_rad_yn; //modified for IN066453//IN071561
				params =params +"&order_type_3T="+order_type_3T; //39052
				params =params +"&archivalYN="+archivalYN; //52176
				
				if(top.content!=null && top.content.workAreaFrame && typeof top.content.workAreaFrame.details !== 'undefined')
				{		
						top.content.workAreaFrame.details.location.href="../../eCA/jsp/EncounterListMain.jsp"+params;
						//top.content.workAreaFrame.details.document.forms[0].submit();
				}
				else
				{			
						  parent.details.location.href="../../eCA/jsp/EncounterListMain.jsp"+params;
						//top.content.workAreaFrame.details.document.forms[0].submit();
				}

			}

			else{
			
			//var params =	'?patient_id='+patientid+'&episode_type='+episodetype+'&hist_type='+historytype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&from_date='+fmDt+'&to_date='+toDt+'&view_by='+view_by+'&episode_wise='+episode_wise+'&facility_id='+facility_id+'&encounter_id='+encounter_id+'&performed_by=&errorEvent='+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&viewConfRes="+viewConfRes+'&enc_id='+enc_id+"&graphorder="+graphorder+"&EHR_YN="+EHR_YN;
			//var params =	'?patient_id='+patientid+'&episode_type='+episodetype+'&hist_type='+historytype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&from_date='+fmDt+'&to_date='+toDt+'&view_by='+view_by+'&episode_wise='+episode_wise+'&facility_id='+facility_id+'&encounter_id='+encounter_id+'&performed_by=&errorEvent='+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&viewConfRes="+viewConfRes+'&enc_id='+enc_id+"&graphorder="+graphorder+"&show_mode="+show_mode;//CHL_CRF_0044
			//var params =	'?patient_id='+patientid+'&episode_type='+episodetype+'&hist_type='+historytype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&from_date='+fmDt+'&to_date='+toDt+'&view_by='+view_by+'&episode_wise='+episode_wise+'&facility_id='+facility_id+'&encounter_id='+encounter_id+'&performed_by=&errorEvent='+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&viewConfRes="+viewConfRes+'&enc_id='+enc_id+"&graphorder="+graphorder+"&show_mode="+show_mode+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&p_hist_type="+hist_type;//CHL_CRF_0044 commented for IN034514
			//var params =	'?patient_id='+patientid+'&episode_type='+episodetype+'&hist_type='+historytype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&from_date='+fmDt+'&to_date='+toDt+'&view_by='+view_by+'&episode_wise='+episode_wise+'&facility_id='+facility_id+'&encounter_id='+encounter_id+'&performed_by=&errorEvent='+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&viewConfRes="+viewConfRes+'&enc_id='+enc_id+"&graphorder="+graphorder+"&show_mode="+show_mode+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&p_hist_type="+hist_type+"&encntr_yn="+encntr_yn;//added for IN034514 -- //commented for  BRU-HIMS-CRF-356 [IN038643]
			//var params =	'?patient_id='+patientid+'&episode_type='+episodetype+'&hist_type='+historytype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&from_date='+fmDt+'&to_date='+toDt+'&view_by='+view_by+'&episode_wise='+episode_wise+'&facility_id='+facility_id+'&encounter_id='+encounter_id+'&performed_by=&errorEvent='+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&viewConfRes="+viewConfRes+'&enc_id='+enc_id+"&graphorder="+graphorder+"&show_mode="+show_mode+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&p_hist_type="+hist_type+"&encntr_yn="+encntr_yn+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code; //modified for  MMS-QH-CRF-0177 [IN047572] ->commented for IN066453
      //var params =	'?patient_id='+patientid+'&episode_type='+episodetype+'&hist_type='+historytype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&from_date='+fmDt+'&to_date='+toDt+'&view_by='+view_by+'&episode_wise='+episode_wise+'&facility_id='+facility_id+'&encounter_id='+encounter_id+'&performed_by=&errorEvent='+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&viewConfRes="+viewConfRes+'&enc_id='+enc_id+"&graphorder="+graphorder+"&show_mode="+show_mode+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&p_hist_type="+hist_type+"&encntr_yn="+encntr_yn+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code+"&isSiteSpecificForLabPrint="+isSiteSpecificForLabPrint; //modified for IN066453 //IN071561
      var params =	'?patient_id='+patientid+'&episode_type='+episodetype+'&hist_type='+historytype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&from_date='+fmDt+'&to_date='+toDt+'&view_by='+view_by+'&episode_wise='+episode_wise+'&facility_id='+facility_id+'&encounter_id='+encounter_id+'&performed_by=&errorEvent='+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&viewConfRes="+viewConfRes+'&enc_id='+enc_id+"&graphorder="+graphorder+"&show_mode="+show_mode+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&p_hist_type="+hist_type+"&encntr_yn="+encntr_yn+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code+"&isSiteSpecificForLabPrint="+isSiteSpecificForLabPrint+"&p_review_rad_yn="+p_review_rad_yn; //modified for IN066453//IN071561 
				params =params +"&order_type_3T="+order_type_3T; //39052
				params =params +"&archivalYN="+archivalYN; //52176
				
			if(top.content!=null && typeof top.content.workAreaFrame.details !== 'undefined')

		{		
				top.content.workAreaFrame.details.location.href="../../eCA/jsp/EncounterListMain.jsp"+params;
				//top.content.workAreaFrame.details.document.forms[0].submit();
		}
			else
		{			
			      parent.details.location.href="../../eCA/jsp/EncounterListMain.jsp"+params;
				//top.content.workAreaFrame.details.document.forms[0].submit();
		}
			}

			
			
	}
	//IN061884 changes starts
	else if(workAreaFrameReference.document.forms[0].view_mode[2].checked)
	{
			var episode_wise = "N";
			var view_by="";
			if(p_called_from=="CA_RESULTS_WIDGET"){
				if(top.content == null) parent.myFrameSet.rows = '26%,*,6%,0%'; 
			}else{
				if(top.content == null) parent.myFrameSet.rows = '26%,*,0%';
			}
			if(workAreaFrameReference.document.forms[0].view_by[0].checked)
				view_by = workAreaFrameReference.document.forms[0].view_by[0].value;
			else if(workAreaFrameReference.document.forms[0].view_by[1].checked)
				view_by = workAreaFrameReference.document.forms[0].view_by[1].value;

			normalcy = workAreaFrameReference.document.forms[0].cboNormalcyInd.value;	
			grphistory_type = workAreaFrameReference.document.forms[0].grphistory_type.value;	

			if(workAreaFrameReference.document.forms[0].group_panel[0].checked)			
				 orderCatalogNature=workAreaFrameReference.document.forms[0].group_panel[0].value;	

			else if(workAreaFrameReference.document.forms[0].group_panel[1].checked)			
				orderCatalogNature=workAreaFrameReference.document.forms[0].group_panel[1].value;

			if (fmDt == '' && toDt == '' )
			{
				var params = '?patient_id='+patientid+'&episode_type='+episodetype+'&hist_type='+historytype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&from_date='+fromdate+'&to_date='+todate+'&view_by='+view_by+'&episode_wise='+episode_wise+'&facility_id='+facility_id+'&encounter_id='+encounter_id+'&performed_by=&errorEvent='+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&viewConfRes="+viewConfRes+'&enc_id='+enc_id+"&graphorder="+graphorder+"&stdParams="+stdParams+"&show_mode="+show_mode+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&p_hist_type="+hist_type+"&encntr_yn="+encntr_yn+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code+"&grphistory_type="+grphistory_type+"&orderCatalogNature="+orderCatalogNature;
				if(top.content!=null && typeof top.content.workAreaFrame.details !== 'undefined')
				{		
						top.content.workAreaFrame.details.location.href="../../eCA/jsp/GroupDisplayFrame.jsp"+params;
				}
				else
				{			
						  parent.details.location.href="../../eCA/jsp/GroupDisplayFrame.jsp"+params;
				}
			}
			else{
				var params =	'?patient_id='+patientid+'&episode_type='+episodetype+'&hist_type='+historytype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&from_date='+fmDt+'&to_date='+toDt+'&view_by='+view_by+'&episode_wise='+episode_wise+'&facility_id='+facility_id+'&encounter_id='+encounter_id+'&performed_by=&errorEvent='+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&viewConfRes="+viewConfRes+'&enc_id='+enc_id+"&graphorder="+graphorder+"&show_mode="+show_mode+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&p_hist_type="+hist_type+"&encntr_yn="+encntr_yn+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code+"&grphistory_type="+grphistory_type+"&orderCatalogNature="+orderCatalogNature;
				if(top.content!=null && typeof top.content.workAreaFrame.details !== 'undefined')
				{		
					top.content.workAreaFrame.details.location.href="../../eCA/jsp/GroupDisplayFrame.jsp"+params;
				}
				else
				{			
				      parent.details.location.href="../../eCA/jsp/GroupDisplayFrame.jsp"+params;
				}
			}

	}
	//IN061884 changes ends
}






function populateControlOR(fmDt,toDt)
{
	//alert("calling OR function also");
	var patientid	= document.forms[0].strPatientId.value;
	var episodetype =  document.forms[0].strEpisodeType.value;

	var eventclass =  document.forms[0].strEventClass.value;
	var eventgroup =  document.forms[0].strEventGroup.value;
	var eventitem =  document.forms[0].strEventCode.value;

//	var stdParams		=  document.forms[0].queryStrForCmnts.value;
	var viewConfRes		=  document.forms[0].strViewConfRes.value;
	var historytype		=  document.forms[0].strHistRecType.value;
	var facility_id		=  document.forms[0].strFacilityId.value;
	var graphorder		=  document.forms[0].strGraphOrder.value;
	
	var encounter_id	=  document.forms[0].strEncounterId.value;
	
	//if((encounter_id=="")||(encounter_id==null)||(encounter_id=="null"))
		//encounter_id =0;
	
	var fromdate =  document.forms[0].strFromDate.value;
	var todate =  document.forms[0].strToDate.value;
	var abnormal = document.forms[0].strAbnormal.value;
	var flowSheetComp	=  document.forms[0].strFlowSheetId.value;
	var normalcy	=  document.forms[0].strNormalcyInd.value;
	var errorEvent	=  document.forms[0].strErrorEvent.value;
	var called_from=document.forms[0].called_from.value;
	var speciality_code		= document.forms[0].speciality_code.value; //MMS-QH-CRF-0177 [IN047572] 
	var attend_pract_code	= document.forms[0].attend_pract_code.value; //MMS-QH-CRF-0177 [IN047572] 
	if(fmDt == undefined)
		fmDt = '';
	if(toDt == undefined)
		toDt = '';

		if (fmDt == '' && toDt == '' )
		{
			//var HTMLVal = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name=PopulateFlowSheetClass method=post 	action=\"../../eCA/jsp/FlowSheetDetails.jsp?graphorder="+graphorder+"&p_called_from="+called_from+"&errorEvent="+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&cboFlowSheetComp="+flowSheetComp+"&viewConfRes="+viewConfRes+"&c_from_date="+fmDt+"&c_to_date="+toDt+"&p_patient_id="+patientid+"&p_hist_rec_type="+historytype+"&p_event_class="+eventclass+"&p_event_group="+eventgroup+"&episode_type="+episodetype+"&encounter_id="+encounter_id+"&c_facility_id="+facility_id+"&eventitem="+eventitem+"\"> </form></body></html>"; // commented for  BRU-HIMS-CRF-356 [IN038643] 
			var HTMLVal = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name=PopulateFlowSheetClass method=post 	action=\"../../eCA/jsp/FlowSheetDetails.jsp?graphorder="+graphorder+"&p_called_from="+called_from+"&errorEvent="+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&cboFlowSheetComp="+flowSheetComp+"&viewConfRes="+viewConfRes+"&c_from_date="+fmDt+"&c_to_date="+toDt+"&p_patient_id="+patientid+"&p_hist_rec_type="+historytype+"&p_event_class="+eventclass+"&p_event_group="+eventgroup+"&episode_type="+episodetype+"&encounter_id="+encounter_id+"&c_facility_id="+facility_id+"&eventitem="+eventitem+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code+"\"> </form></body></html>"; //modified for  BRU-HIMS-CRF-356 [IN038643] MMS-QH-CRF-0177 [IN047572] 
			if(top.content!=null && typeof top.content.workAreaFrame.details !== 'undefined')
			{
				top.content.workAreaFrame.details.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				top.content.workAreaFrame.details.document.forms[0].submit();
			}
			else
			{
				parent.parent.details.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				parent.parent.details.document.forms[0].submit();
			}
		}
		else
		{
			//parent.unitFrame.location.href = "../../eCA/jsp/FlowSheetEvents.jsp?graphorder="+graphorder+"&p_called_from="+called_from+"&errorEvent="+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&cboFlowSheetComp="+flowSheetComp+"&viewConfRes="+viewConfRes+"&c_from_date="+fmDt+"&c_to_date="+toDt+"&p_patient_id="+patientid+"&p_hist_rec_type="+historytype+"&p_event_class="+eventclass+"&p_event_group="+eventgroup+"&episode_type="+episodetype+"&encounter_id="+encounter_id+"&c_facility_id="+facility_id+"&eventitem="+eventitem+""; // commented for  BRU-HIMS-CRF-356 [IN038643] 
			parent.unitFrame.location.href = "../../eCA/jsp/FlowSheetEvents.jsp?graphorder="+graphorder+"&p_called_from="+called_from+"&errorEvent="+errorEvent+"&abnormal="+abnormal+"&normalcy="+normalcy+"&cboFlowSheetComp="+flowSheetComp+"&viewConfRes="+viewConfRes+"&c_from_date="+fmDt+"&c_to_date="+toDt+"&p_patient_id="+patientid+"&p_hist_rec_type="+historytype+"&p_event_class="+eventclass+"&p_event_group="+eventgroup+"&episode_type="+episodetype+"&encounter_id="+encounter_id+"&c_facility_id="+facility_id+"&eventitem="+eventitem+""+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code; // modified for MMS-QH-CRF-0177 [IN047572] 
		}
}

function chkDateTime(toDate,format,locale)
{
	
	if(toDate.value != '') 
	{		
		var from_date = document.getElementById("from_date");
		var to_date = document.getElementById("to_date")
		// Added by Sridhar Reddy on 28/06/2009 to fix INCIDENT IN011617
		if(validDateObj(toDate,format,locale))
		{			
			if(from_date.value != "" || to_date.value != "")
			{
				chkToDate(from_date,to_date,format,locale);
			}
		}
		
		
		// Commented by Sridhar Reddy on 28/06/2009.
		/*if(!(doDateTimeChk(toDate)) )
		{
			msg = getMessage("INVALID_DATE_TIME","CA");
			alert(msg);
			toDate.focus();
			toDate.select();
			return false;
		}*/
	}
}
function chkToDate(fromDate,toDate,format,locale)
{	
	if(fromDate.value != "")
	{		
		if(!isBeforeNow(fromDate.value,format,locale))
		{
			alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
			fromDate.select();
			fromDate.focus();
			fromDate.value="";
			return false;
				
		}else
		{ 
		  if( toDate.value != "")
			{
				if(isBeforeNow(toDate.value,format,locale))
				{
					if(isAfter(toDate.value,fromDate.value, format, locale))
						return true;
					else
					{
						alert(getMessage("TO_DT_GR_EQ_FM_DT","CA")); 
						toDate.select();
						toDate.focus();
						return false;
					}
				}
				else
				  {
					alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
					toDate.select();
					toDate.focus();
					return false;
				  }
			}
		}
	}else
	{		
		if((toDate.value!=""))
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

async function showDocDetailsInModal(histDataType,histRecType,accNum,eventDesc,contrSysId,contrSysEventCode)
{
	var dialogHeight= "90vh" ;
	var dialogWidth	= "80vw" ;
	var dialogTop	= "120" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal = await top.window.showModalDialog("../../eCA/jsp/EncountersDocDisplay.jsp?data_type="+histDataType+"&hist_type="+histRecType+"&accession_num="+accNum+"&event_desc="+eventDesc+"&contr_sys_id="+contrSysId+"&contr_sys_event_code="+contrSysEventCode,arguments,features);
}

async function manageText()
{
	var patient_id = document.forms[0].strPatientId.value;
	var encounter_id = document.forms[0].strEncounterId.value;
	var enc_id = document.forms[0].enc_id.value;

//	if(encounter_id == '' || encounter_id == null || encounter_id == undefined) encounter_id = enc_id;

	if(enc_id == "" || enc_id == null) enc_id = "0";
	encounter_id = enc_id;

	var dialogHeight= "100vh" ;
	var dialogWidth	= "80vw" ;
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll:no;  status:no";		
	retVal=await top.window.showModalDialog("../../eCA/jsp/EncountersManageTxtMain.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id,arguments,features);
	if(retVal == null)
	{
		//parent.dataFrame.location.reload();
		parent.dataFrame.location = parent.dataFrame.location;
	}
}

async function emailText()
{
	var patient_id = document.forms[0].strPatientId.value; 
	var encounter_id = document.forms[0].strEncounterId.value;
	var enc_id = document.forms[0].enc_id.value;
	var called_from = document.forms[0].enc_called_from.value;
	

	//if(encounter_id == '' || encounter_id == null || encounter_id == undefined) encounter_id = enc_id;
	if(enc_id == "" || enc_id == null) enc_id = "0";
	encounter_id = enc_id;

	var messageFrameName;
	if(top.content != null) messageFrameName = top.content.messageFrame.name;
	else if(parent.parent.parent.messageFrame != null) messageFrameName = parent.parent.parent.messageFrame.name;
	
	
//	document.forms[0].method = 'post';
//	document.forms[0].action = '../../eCA/jsp/EncountersEmailDetails.jsp?patient_id='+patient_id+'&encounter_id='+encounter_id;
		
		var dialogHeight ='90vh' ;
		var dialogWidth = '80vw' ;
		var dialogTop	= '40'; //'189'
		var dialogLeft = '95' ;//'167'
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
		var arguments="";

	var action_url = '../../eCA/jsp/EncountersEmailDetails.jsp?patient_id='+patient_id+'&encounter_id='+encounter_id;
	if(called_from!="OR")
	{
	//var win = //window.open(action_url,'emailWin','height=570,width=760,top=70,left=120,resizable=yes,scrollbars=yes');
	//var win = window.showModalDialog(action_url,'emailWin','height=570,width=760,top=70,left=120,resizable=yes,scrollbars=yes');
	var win = await top.window.showModalDialog(action_url,arguments,features);
}
	else
	{
 		var retVals = await top.window.showModalDialog(action_url,arguments,features);
	}

//	document.forms[0].target = messageFrameName;
//	document.forms[0].submit();

}

function valsForPrint()
{
	var patient_id = document.forms[0].strPatientId.value;
	var encounter_id = document.forms[0].strEncounterId.value;
	var enc_id = document.forms[0].enc_id.value;
	var called_from = document.forms[0].enc_called_from.value;
	
//	if(encounter_id == '' || encounter_id == null || encounter_id == undefined) encounter_id = enc_id;
	if(enc_id == "" || enc_id == null) enc_id = "0";
	encounter_id = enc_id;
	
	//ML-MMOH-CRF-0335 - IN057113 - Start
	var conf_pin_req_yn = document.forms[0].l_conf_pin_req_yn.value;
	if(conf_pin_req_yn == 'Y') {
		var print_cal_req = 'CEH_MULTI_PRINT'; 
		isPinValidationReq(patient_id, encounter_id, '', print_cal_req);
		if(isPrintPinValidationReq == 'Y') {
			retVal =  validatePintoPrint();
			if(retVal == 'X')
				return false;
		}
	}	
	//ML-MMOH-CRF-0335 - IN057113 - End
	var dialogTop	= "60";
	var dialogHeight= "34" ;
	var dialogWidth	= "50" ;
	var arguments = "";
	var features	= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;

	/**
		modified by Jyothi on 19/08/2010 to fix IN022756
		changed window.showmodaldialog to window.open, since the print button would not respond in IE8
	**/

	var retVal = window.open("../../eCA/jsp/EncountersPrint.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&called_from="+called_from,arguments,features);//Menaka
	//var retVal = window.open("../../eCA/jsp/EncountersPrint.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&called_from="+called_from+"&fac_id="+fac_id+"&enctr_id="+enctr_id,arguments,features);//Menaka
}

function staticTitleForManage()
{
	var x = document.body.scrollTop;
	if(x == 0)
	{
		document.getElementById("titleId").style.position = 'relative';
		document.getElementById("titleId").style.posTop  = 0;
	}
	else
	{
		document.getElementById("titleId").style.position = 'relative';
		document.getElementById("titleId").style.posTop  = x-2;
	}
}

function staticTitleForCommentDetails()
{
	var x = document.body.scrollTop;
	if(x == 0)
	{
		document.getElementById("commentTitleId").style.position = 'relative';
		document.getElementById("commentTitleId").style.posTop  = 0;
		document.getElementById("commentTitleId1").style.position = 'relative';
		document.getElementById("commentTitleId1").style.posTop  = 0;
	}
	else
	{
		document.getElementById("commentTitleId").style.position = 'relative';
		document.getElementById("commentTitleId").style.posTop  = x-15;
		document.getElementById("commentTitleId1").style.position = 'relative';
		document.getElementById("commentTitleId1").style.posTop  = x-15;		
	}
}

function clearMailPrintBean()
{
	addToGroupsFrame.location.href = '../../eCA/jsp/EncountersManageEmail.jsp?clearBean=Yes';
}
async function callEHRViewer()
{
	
	var queryString = document.forms[0].queryStrForCmnts.value;
	
    var arguments='';
	var features	= "dialogHeight: 40 ; dialogWidth: 100 ;dialogTop: 100; scroll=no;  status:no";		
	var retVal=await window.showModalDialog("../../eCA/jsp/FlowSheet.jsp?EHR_YN=Y&queryString="+queryString,arguments,features);


	//var patientid	= document.flowsheet_criteria_form.patient_id.value;
	//parent.details.location.href="../../eCA/jsp/EncounterInEHRWrapper.jsp?patient_id="+patientid;
//	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no;  status:" + status;		
//	retVal=window.showModalDialog("../../eCA/jsp/EncounterInEHRWrapper.jsp?patient_id="+patientid,arguments,features);
}


//Added for displaying the comments properly
async function ShowRemarks(i)
	{
		var resultStr = document.getElementById("result"+i).value;		
		var comments;
		var retVal;
		var dialogHeight ='40vh' ;
		var dialogWidth = '50vw' ;
		var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
		var arguments = resultStr;
		retVal 			= await window.showModalDialog('../../eCA/jsp/QuickText.jsp',arguments,features);
}

function clearLayer()
{
	hidePopUp();
}
function showToolTip(obj,objcount,text)
{	
	if(text.length>15)
	{
		var tab_dat  = "<table class='grid' id='tooltiptable1'  width='' height='100%' align='center'>"
		tab_dat   =  tab_dat+"<tr bgcolor='lightyellow' >" ;
		tab_dat    = tab_dat+ "<td class = 'contextMenuItem' style='padding-left:10px;padding-right:10px' >"+text+"</td>" ;
		tab_dat     =tab_dat+ "</tr>" ;		
		tab_dat     =tab_dat+ "</table> ";	
		document.getElementById("descLink").innerHTML = tab_dat;
		document.getElementById("descLink").style.top  = obj.offsetTop+27;
		if(objcount=="5")
		{
			document.getElementById("descLink").style.left  = obj.offsetLeft+30;
		}
		else
		{
		document.getElementById("descLink").style.left  = obj.offsetLeft+90;}
		document.getElementById("descLink").style.visibility='visible' ;
	}
	else
	{
		hidePopUp();
	}
}

function hidePopUp()
{
	if(document.getElementById("descLink"))
	document.getElementById("descLink").style.visibility='hidden' ;
}

//Function for the file name FlowSheetEventsQuickText.jsp to display the text-start

//function getTextInModal(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode){//IN031989
async function getTextInModal(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,enc_id,fac_id){//IN031989//IN033489
	var patient_id = document.forms[0].patient_id.value;//INO30714
	//var enc_id = document.forms[0].enc_id.value;//INO30714
	var win_height		= "90vh";
	var win_width		= "80vw";
	var win_scroll_yn	= "yes";

	if(Histrectype != 'CLNT'){
		win_height		= "80vh";
		win_width		= "90vw";
		//win_top			= "200";
		//win_scroll_yn	= "no";
}

var retVal = new String();
//var dialogHeight = "28" ;
//var dialogWidth = "50" ;

var dialogHeight = win_height ;
var dialogWidth = win_width ;
var dialogTop = "122";
var status = "no";
var scroll = win_scroll_yn;
var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll+";dialogTop :" + dialogTop;
var arguments	= Accessionnum ;

Accessionnum	=	escape(Accessionnum);
var finalString	= "Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode+"&patient_id="+patient_id+"&enc_id="+enc_id+"&fac_id="+fac_id;//INO30714//IN033489
//retVal = window.showModalDialog("../../eCA/jsp/FlowSheetText.jsp?Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode,arguments,features);//IN030859
retVal = await window.showModalDialog("../../eCA/jsp/FlowSheetText.jsp?"+finalString,arguments,features);//INO30714
}
//Function for the file name FlowSheetEventsQuickText.jsp-end

//Funtion for button Birth Register-start

   async function modalForBirth(patient_id)
	{
		//alert("patient_id"+patient_id);
		//var dialogHeight= "39" ;
		//var dialogWidth	= "52" ;
		var dialogHeight= "90vh" ;
	    var dialogWidth = "80vw" ;
		var status = "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=yes;  status:" + status;		
		retVal=await window.showModalDialog("../../eMP/jsp/ViewBirthRegMain.jsp?Patient_ID="+patient_id,arguments,features);
		
	}
//Added by Archana Dhal related to display of More Values link -start
async function callResults(tempEventDate1,tempEventDate2,eventDesc,histRecType,tempEventClass,tempEventGroup,tempEventCode,modified_date_YN)//24094
{
    var query_string    = parent.dataFrame.document.dataForm.query_string.value;
	var patientid	    = document.forms[0].patient_id.value;
	//var hist_rec_type	= document.forms[0].hist_rec_type.value;
	//var event_class	    = document.forms[0].event_class.value;
	//var event_group	    = document.forms[0].event_group.value;
	//var event_code	    = document.forms[0].event_code.value;
	var event_date_time	= document.forms[0].event_date_time.value;
	var encounter_id	= document.forms[0].encounter_id.value;
	var episode_type	= document.forms[0].episode_type.value;
	var abnormal	    = document.forms[0].abnormal.value;
	var view_conf_res	= document.forms[0].view_conf_res.value;
	var error_event	    = document.forms[0].error_event.value;
	var enc_id	        = document.forms[0].enc_id.value;
	var flowsheet_Id	= document.forms[0].flowsheet_Id.value;
	var facility_id	    = document.forms[0].facility_id.value;
	var graph_order	    = document.forms[0].graph_order.value;
	var from_date	    = document.forms[0].from_date.value;
	var to_date	        = document.forms[0].to_date.value;
	var narmalcy	    = document.forms[0].narmalcy.value;
	//var title = "Recording of "+eventDesc+" for the Date time :"+tempEventDate1;
	//var  title = getMessage("REC_DESC_DATE_TIME","CA");
	var title=getLabel("eCA.RecordingForDateTime.label","CA");
	title = title.replace("$$",eventDesc);
	title = title.replace("$$",tempEventDate2);//'tempEventDate2' is passed instead of 'tempEventDate1' modified by Archana Dhal on 11/9/2010 related to IN024920.
	
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "80vw" ;
	var status			= "no";
	var scroll			= "yes";
	var dialogTop		= "140";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;

	retVal 			= await window.showModalDialog('../../eCA/jsp/FlowSheetMoreResultsMain.jsp?query_string='+query_string+'&patientid='+patientid+'&hist_rec_type='+histRecType+'&event_class='+tempEventClass+'&event_group='+tempEventGroup+'&event_code='+tempEventCode+'&event_date_time='+event_date_time+'&encounter_id='+encounter_id+'&episode_type='+episode_type+'&abnormal='+abnormal+'&view_conf_res='+view_conf_res+'&error_event='+error_event+'&enc_id='+enc_id+'&flowsheet_Id='+flowsheet_Id+'&facility_id='+facility_id+'&from_date='+from_date+'&to_date='+to_date+'&graph_order='+graph_order+'&narmalcy='+narmalcy+'&tempEventDate1='+tempEventDate1+'&title='+encodeURIComponent(title,"UTF-8"),arguments,features);
}

//function getText1(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode)//IN032794
function getText1(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,enctr_id,fac_id)//IN032794 //Menaka
{
	var patient_id = document.forms[0].patient_id.value;//IN032794
	document.forms[0].txtFlagQuickText.value = 'Y';
	var arguments	= Accessionnum ;

	Accessionnum	=	escape(Accessionnum);

	//parent.FlowSheetTextFrame.location.href= "../../eCA/jsp/FlowSheetText.jsp?Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode;//IN032794
	parent.FlowSheetTextFrame.location.href= "../../eCA/jsp/FlowSheetText.jsp?Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode+"&patient_id="+patient_id+"&enc_id="+enctr_id+"&fac_id="+fac_id;//IN032794//Menaka

	parent.FlowSheetFrameSet.rows = "75%,110%,0%";

	/*for(var i=0;i<arrObjects.length;i++){
		if(arrObjects[i] != null){
			var temp1 = arrClassValues[i];
			arrObjects[i].className = temp1;
		}
	}
	arrObjects = new Array();
	arrValues = new Array();
	arrClassValues = new Array();
	return false;*/
}
// added for IN037793
async function viewUploadedImg(showImageLocn)
{
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "80vw" ;
	var status			= "no";
	var scroll			= "yes";
	var dialogTop		= "140";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
	var arguments		="";
	await window.showModalDialog(showImageLocn,"",arguments,features);
}
//end

// added for IN034512
async function printData(){
	
	//ML-MMOH-CRF-0335 - IN057113 - Start
	var accession_num = parent.FlowsheetToolbarFrame.document.flowsheet_text_toolbar.accession_num.value; 
	var sourceprint = parent.FlowsheetToolbarFrame.document.flowsheet_text_toolbar.sourceprint.value; //IN004500
	var patient_id = parent.FlowSheetTextMainFrame.document.flowsheet_text.patient_id.value;
	var encounter_id = parent.FlowSheetTextMainFrame.document.flowsheet_text.encounter_id.value;
	var conf_pin_req_yn = document.flowsheet_text_toolbar.l_conf_pin_req_yn.value;
	if(conf_pin_req_yn == 'Y') {
		isPinValidationReq(patient_id, encounter_id, accession_num, '');
		if(isPrintPinValidationReq == 'Y') {
			retVal = await  validatePintoPrint();
			if(retVal == 'X')
				return false;
		}
	}
	//ML-MMOH-CRF-0335 - IN057113 - End
	
	var retVal		= 	new String();
	var dialogTop	=	"60"; 
	var dialogHeight=	"90vh" ;
	var dialogWidth	=	"80vw" ;
	var header = "";
	var header1 = "";
	
	var footer="";
	var data		=	new Array();
	var features	=	"dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	
	//var accession_num = parent.FlowSheetTextMainFrame.document.flowsheet_text.accession_num.value;
	//var accession_num = parent.FlowsheetToolbarFrame.document.flowsheet_text_toolbar.accession_num.value; // IN043274
	var facility_id = parent.FlowSheetTextMainFrame.document.flowsheet_text.facility_id.value;
	//var patient_id = parent.FlowSheetTextMainFrame.document.flowsheet_text.patient_id.value;  // moved top for - ML-MMOH-CRF-0335 - IN057113
	//var encounter_id = parent.FlowSheetTextMainFrame.document.flowsheet_text.encounter_id.value;  // moved top for - ML-MMOH-CRF-0335 - IN057113
	var visit_adm_date = parent.FlowSheetTextMainFrame.document.flowsheet_text.visit_adm_date.value;
	var discharge_date = parent.FlowSheetTextMainFrame.document.flowsheet_text.discharge_date.value;
	var specialty_name = parent.FlowSheetTextMainFrame.document.flowsheet_text.speciality_name.value;
	var location_code = parent.FlowSheetTextMainFrame.document.flowsheet_text.location_code.value;
	var performed_by_pract = parent.FlowSheetTextMainFrame.document.flowsheet_text.performed_by_pract.value;
	var performed_by_name = parent.FlowSheetTextMainFrame.document.flowsheet_text.performing_phy_name.value;
	var event_title_desc = parent.FlowSheetTextMainFrame.document.flowsheet_text.event_title_desc.value;
	var patient_sex = parent.FlowSheetTextMainFrame.document.flowsheet_text.sex.value;
	var patient_age = parent.FlowSheetTextMainFrame.document.flowsheet_text.age.value;
	var patient_class = parent.FlowSheetTextMainFrame.document.flowsheet_text.patient_class.value;
	var title = parent.FlowSheetTextMainFrame.document.flowsheet_text.note_header_desc.value; 
	var event_date_time = parent.FlowSheetTextMainFrame.document.flowsheet_text.event_date_time.value;
	var med_service = parent.FlowSheetTextMainFrame.document.flowsheet_text.med_service.value;
	var	attending_practitioner = parent.FlowSheetTextMainFrame.document.flowsheet_text.attending_practitioner.value;
	var performed_date = parent.FlowSheetTextMainFrame.document.flowsheet_text.performed_date.value;
	var note_status = parent.FlowSheetTextMainFrame.document.flowsheet_text.note_status.value;
	var printDateTime = parent.FlowSheetTextMainFrame.document.flowsheet_text.printDateTime.value;
	var note_type = parent.FlowSheetTextMainFrame.document.flowsheet_text.note_type.value;
	var patient_name = parent.FlowSheetTextMainFrame.document.flowsheet_text.patient_name.value;
	var printDateTime = parent.FlowSheetTextMainFrame.document.flowsheet_text.printDateTime.value;
	var appl_task_id = parent.FlowSheetTextMainFrame.document.flowsheet_text.appl_task_id.value;
	var admitting_practitioner = parent.FlowSheetTextMainFrame.document.flowsheet_text.admitting_practitioner.value;
	var appl_task_id = "";
	var lastModifiedBy = parent.FlowSheetTextMainFrame.document.flowsheet_text.lastModifiedBy.value;
	var dischargeDateTime	=	parent.FlowSheetTextMainFrame.document.flowsheet_text.dischargeDateTime.value;
	var episode_type = parent.FlowSheetTextMainFrame.document.flowsheet_text.episode_type.value;
	var episodeDesc = parent.FlowSheetTextMainFrame.document.flowsheet_text.patient_class.value;
	var locationDesc = "";
	if(episode_type == "O"  || episode_type == "I")
		episodeDesc = episode_type + "P";
	
	
   
    {
		header = "<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >";
		/*header +="<tr><td align='left' width='5%' rowspan='2'><img valign='top' src='../../eCommon/images/Entilogo.jpg' border='0'></td><td  align=center><h3>"+document.forms[0].siteName.value+"</h3></td></tr>";*/
		header +="<tr> <td class='HEADER' align='center' width='5%' id='headerImageID'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' width='40' height='40'></td><td  align=center><h3>"+parent.FlowSheetTextMainFrame.document.flowsheet_text.siteName.value+"</h3></td></tr>";
		header +="<tr><td width='5%' >&nbsp;</td><td align=center><h3>"+parent.FlowSheetTextMainFrame.document.flowsheet_text.facility_name.value+"</h3></td></tr>";
		header +="<tr><td>&nbsp;</td><td align=center><h4>"+title+"</h4></td></tr></table>";
		header +="<br>";

		header1 +="<table border='1' cellpadding='3' cellspacing='0' width = '100%' style='font-family:Verdana;:background-color:#ADADAD'>";
		header1 +="<tr><td>";
		header1 +="<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center>";
		header1 +="<tr><td nowrap><b>"+getLabel("Common.patientId.label","common")+"</b></td><td nowrap><font size='2'>: "+patient_id+"</font></td>";
		header1 +="<td nowrap><b>"+getLabel("Common.name.label","common")+"</b></td><td colspan =3><font size=2>: "+patient_name+"</font></td></tr>";
		header1 +="<tr><td nowrap><b>"+getLabel("Common.gender.label","common")+"</b></td><td nowrap><font size=2>: "+patient_sex+"</font></td><td nowrap><b>"+getLabel("Common.age.label","common")+"</b></td><td nowrap><font size=2>: "+patient_age+"</font></td></tr>";

		if(encounter_id != "0" )
		{
			header1 +="<tr><td nowrap><b>"+getLabel("Common.encounterid.label","common")+"</b></td><td nowrap><font size='2'>: "+encounter_id+"</font></td><td nowrap><b>"+getLabel("Common.encountertype.label","common")+"</b></td><td><font size='2'>: "+patient_class+"</font></td><td align='right' nowrap><b>"+getLabel("Common.encounterdate.label","common")+"</b></td><td nowrap><font size='2'>&nbsp;: "+visit_adm_date+"</font></td></tr>";
			header1 +="<tr><td nowrap><b>"+getLabel("Common.Location.label","common")+"</b></td>";
		}
		

    }
    
    
    if(encounter_id != "0")
	{
		if(episode_type=="O")
		{
			header1 += "<td colspan='3' nowrap><font size='2'>: "+locationDesc+"</font></td>";
		}
		else
		{
			header1 += 	"<td colspan='3' nowrap><font size='2'>: "+locationDesc+"</font></td>";
		}
		
		header1+="<td align='right' nowrap><b>"+getLabel("Common.dischargedate.label","common")+"</b></td><td><font size='2'>&nbsp;: "+parent.FlowSheetTextMainFrame.document.flowsheet_text.dischargeDateTime.value+"</font></td></tr>";
		
		header1+="<tr><td nowrap><b>"+getLabel("Common.speciality.label","common")+"</b></td><td colspan='2' nowrap><font size='2'>: "+parent.FlowSheetTextMainFrame.document.flowsheet_text.speciality_name.value+"</font></td>";
		header1+="<td colspan='2'  align='right' nowrap><b>"+getLabel("Common.AttendingPractitioner.label","common")+"</b></td><td nowrap><font size='2'>&nbsp;: "+parent.FlowSheetTextMainFrame.document.flowsheet_text.attending_practitioner.value+"</font></td></tr>";
	}

	header1 += "</table></td></tr></table>";		

	footer	=  "<table width='100%' border=1 cellpadding=0 cellspacing=0 align=center>";
	footer +=  "<tr><td><table width='100%' border=0 cellpadding=0 cellspacing=0 align=center>";
	footer +=  "<tr><td width='20%'><b>";
	footer +=  getLabel("Common.authorizedby.label","common");
	footer +=  "</b></td><td width='45%' align='left'>:  <font size='2'>";
	footer +=  parent.FlowSheetTextMainFrame.document.flowsheet_text.authorizedBy.value;
	footer +=  "</font></td><td width='15%'><b>Signature</b></td><td width='20%' align='left'>:  </td></tr>";
	footer +=  "<tr><td width='20%'><b>";
	footer +=  getLabel("Common.LastModifiedBy.label","common");
	footer +=  "</b></td><td width='45%' align='left'>:  <font size='2'>";
	footer +=  lastModifiedBy;
	footer +=  "</font></td><td width='15%'><b>";
	footer +=  getLabel("Common.Signature.label","common");
	footer +=  "</b></td><td width='20%' align='left'>:  </td></tr>";
	footer +=  "<tr><td width='20%'><b>";
	footer +=  getLabel("Common.PrintDateTime.label","common");
	footer +=  "</b></td><td width='45%' align='left'> <font size='2'>:  ";
	footer +=  parent.FlowSheetTextMainFrame.document.flowsheet_text.printDateTime.value;
	footer +=  "</font></td><td width='15%'><b>";
	footer +=  getLabel("Common.LoggedUser.label","common");
	footer +=  "</b></td><td width='20%' align='left'><font size='2'>:  ";
	footer +=  parent.FlowSheetTextMainFrame.document.flowsheet_text.loggedUser.value;
	footer +=  "</font></td></tr></table></td></tr></table>";
    
	data[0] =  parent.FlowSheetTextMainFrame.document.flowsheet_text.siteName.value;
	data[1] =  parent.FlowSheetTextMainFrame.document.flowsheet_text.facility_name.value;
	data[2] = title;
	
	var dischargeSummary =  parent.FlowSheetTextMainFrame.document.flowsheet_text.discharge_summary_text.value;
    var disclaimer ="";
	
    if(dischargeSummary !="")
	{
		disclaimer ="<br><table width='100%' border=0 cellpadding=0 cellspacing=0 align=center><tr><td>"+dischargeSummary+"</td><tr></table>"
		data[3] = disclaimer;
	}
  
	var arguments = data; 
	//retVal = window.showModalDialog("../../eCA/jsp/RecClinicalNotesPrint.jsp?accession_num="+encodeURIComponent(accession_num,"UTF-8")+"&title="+encodeURIComponent(title,"UTF-8")+"&facility_id="+facility_id+"&patient_id="+encodeURIComponent(patient_id,"UTF-8")+"&encounter_id="+encounter_id+"&visit_adm_date="+visit_adm_date+"&discharge_date="+dischargeDateTime+"&specialty_name="+encodeURIComponent(specialty_name,"UTF-8")+"&location_code="+encodeURIComponent(locationDesc,"UTF-8")+"&performed_by_pract="+encodeURIComponent(performed_by_name,"UTF-8")+"&performing_phy_name="+encodeURIComponent(performed_by_name,"UTF-8")+"&event_title_desc="+encodeURIComponent(title,"UTF-8")+"&Sex="+encodeURIComponent(patient_sex,"UTF-8")+"&age="+encodeURIComponent(patient_age,"UTF-8")+"&patient_class="+encodeURIComponent(patient_class,"UTF-8")+"&note_type_desc="+encodeURIComponent(title,"UTF-8")+"&event_date_time="+event_date_time+"&med_service="+encodeURIComponent(med_service,"UTF-8")+"&attending_practitioner="+encodeURIComponent(attending_practitioner,"UTF-8")+"&performed_date="+"&note_status="+"&printDateTime="+printDateTime+"&note_type="+encodeURIComponent(note_type,"UTF-8")+"&patient_name="+encodeURIComponent(patient_name,"UTF-8")+"&printDateTime="+printDateTime+"&appl_task_id="+appl_task_id+'&admitting_practitioner='+admitting_practitioner,arguments,features);
	//retVal = window.showModalDialog("../../eCA/jsp/RecClinicalNotesPrint.jsp?accession_num="+encodeURIComponent(accession_num,"UTF-8")+"&title="+encodeURIComponent(title,"UTF-8")+"&facility_id="+facility_id+"&patient_id="+encodeURIComponent(patient_id,"UTF-8")+"&encounter_id="+encounter_id+"&visit_adm_date="+visit_adm_date+"&discharge_date="+dischargeDateTime+"&specialty_name="+encodeURIComponent(specialty_name,"UTF-8")+"&location_code="+encodeURIComponent(locationDesc,"UTF-8")+"&performed_by_pract="+encodeURIComponent(performed_by_name,"UTF-8")+"&performing_phy_name="+encodeURIComponent(performed_by_name,"UTF-8")+"&event_title_desc="+encodeURIComponent(title,"UTF-8")+"&Sex="+encodeURIComponent(patient_sex,"UTF-8")+"&age="+encodeURIComponent(patient_age,"UTF-8")+"&patient_class="+encodeURIComponent(patient_class,"UTF-8")+"&note_type_desc="+encodeURIComponent(title,"UTF-8")+"&event_date_time="+event_date_time+"&med_service="+encodeURIComponent(med_service,"UTF-8")+"&attending_practitioner="+encodeURIComponent(attending_practitioner,"UTF-8")+"&performed_date="+"&note_status="+"&printDateTime="+printDateTime+"&note_type="+encodeURIComponent(note_type,"UTF-8")+"&patient_name="+encodeURIComponent(patient_name,"UTF-8")+"&printDateTime="+printDateTime+"&appl_task_id="+appl_task_id+"&sourceprint="+sourceprint+'&admitting_practitioner='+admitting_practitioner,arguments,features); //IN004500 added sourceprint//Commented for IN064446
	retVal = await window.showModalDialog("../../eCA/jsp/RecClinicalNotesPrint.jsp?accession_num="+encodeURIComponent(accession_num,"UTF-8")+"&title="+encodeURIComponent(title,"UTF-8")+"&facility_id="+facility_id+"&patient_id="+encodeURIComponent(patient_id,"UTF-8")+"&encounter_id="+encounter_id+"&visit_adm_date="+visit_adm_date+"&discharge_date="+dischargeDateTime+"&specialty_name="+encodeURIComponent(specialty_name,"UTF-8")+"&location_code="+encodeURIComponent(locationDesc,"UTF-8")+"&performed_by_pract="+encodeURIComponent(performed_by_name,"UTF-8")+"&performing_phy_name="+encodeURIComponent(performed_by_name,"UTF-8")+"&event_title_desc="+encodeURIComponent(title,"UTF-8")+"&Sex="+encodeURIComponent(patient_sex,"UTF-8")+"&age="+encodeURIComponent(patient_age,"UTF-8")+"&patient_class="+encodeURIComponent(patient_class,"UTF-8")+"&note_type_desc="+encodeURIComponent(title,"UTF-8")+"&event_date_time="+event_date_time+"&med_service="+encodeURIComponent(med_service,"UTF-8")+"&attending_practitioner="+encodeURIComponent(attending_practitioner,"UTF-8")+"&performed_date="+"&note_status="+"&printDateTime="+printDateTime+"&note_type="+encodeURIComponent(note_type,"UTF-8")+"&patient_name="+encodeURIComponent(patient_name,"UTF-8")+"&printDateTime="+printDateTime+"&appl_task_id="+appl_task_id+"&sourceprint="+sourceprint+'&admitting_practitioner='+admitting_practitioner+'&data[0]='+data[0]+'&data[1]='+data[1]+'&data[2]='+data[2]+'&ppFlag=N',arguments,features); //Modified for IN064446
}
//ML-MMOH-CRF-0335 - IN057113
async function validatePintoPrint() {
	var retVal = 	new String();
	var dialogHeight= "250px" ;
	var dialogWidth	= "400px" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eCA/jsp/AuthorizePinAccess.jsp?"+"",arguments,features);
	if(retVal == undefined || retVal == 'undefined') retVal = "X";
	return retVal;
}
function disallowEnterKey()
{
	var keyVal = parseInt(event.keyCode);
	if(keyVal == 13)
		return false;
}
function chkpasswd() {
	var appl_pwd = document.Authorize_form.appl_user_passwd.value;
	var screen_pwd = document.Authorize_form.screen_passwd.value;
	if (appl_pwd != screen_pwd){
		alert(getMessage("PWD_MISMATCH","CA"));
		top.window.returnValue = "X" ;
		top.window.close();
	}else{
		top.window.returnValue = "T" ;
		top.window.close();
	}

}
function closeAuthorization(){
	top.window.returnValue = "X";
	top.window.close();
}

function isPinValidationReq(patient_id, encounter_id, accession_num, print_cal_req){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "../../eOR/jsp/PrintConfidentPinValidate.jsp?p_patient_id=" + patient_id +"&p_encounter_id="+encounter_id+"&p_accession_num="+accession_num+"&p_validate=CONF_PIN_VALIDATE"+"&p_print_req_from="+print_cal_req, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText )
}
function isPinForPrintRequired(pinRequired) {
	isPrintPinValidationReq = pinRequired;
}
//ML-MMOH-CRF-0335 - IN057113
// IN058156 start
async function showNotesAuditFlow(accession_num)
{	
		
	var retArray		=	new Array();
	var dialogHeight	=	"90vh" ;
	var dialogWidth		=	"80vw" ;
	var status			=	"no";
	var arguments		=	"" ;
	var action_url		=	'../../eCA/jsp/RecClinicalNotesSearchMain.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	action_url			+=	"?accession_num="+accession_num+"&operation_mode=ViewNoteStatus";
	retArray			=	await window.showModalDialog(action_url,arguments,features);
}
//IN058156 end
//MMS-QH-CRF-0177 [IN047572] -Start
async function getSpecialty1(obj)
{
	if (obj.value != "")
	{
		var oldValFlag = false;
		if(document.forms[0].Splcode_desc_hid.value != document.forms[0].specialty.value)
			oldValFlag = true;
			
		if(oldValFlag)
		{
			await getSpecialty();
		}
		else
		{	
			if(obj.value == "" || obj.value == null) {
			
				document.forms[0].speciality_code.value = "";
				
			}	
		}
	}
	else
	{
		document.forms[0].speciality_code.value = "";
		document.forms[0].attend_pract_desc.value = ""; // MMS-QH-CRF-0177 [IN047572] 
		document.forms[0].attend_pract_code.value = ""; // MMS-QH-CRF-0177 [IN047572] 
	}
}

async function getSpecialty()
{		
		// MMS-QH-CRF-0177 [IN047572] - Start
			document.forms[0].attend_pract_desc.value = "";  
			document.forms[0].attend_pract_code.value = ""; 
		// MMS-QH-CRF-0177 [IN047572] - End
		var target			= document.forms[0].specialty.value;
		var stdval          = document.forms[0].speciality_code.value;
		var facilityid      = document.forms[0].facilityid.value;
		var locale			= document.forms[0].locale.value;
       
		var retVal			= new String();
		var dialogTop		= "40";
		var dialogHeight	= "400px" ;
		var dialogWidth		= "700px" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= getLabel("Common.Specialty.label","Common");
		
		var sql="select a.SPECIALITY_CODE code, a.SHORT_DESC description from AM_SPECIALITY_lang_vw  a where eff_status = 'E' and LANGUAGE_ID='"+locale+"'" ;
		sql = sql + " and upper(a.SPECIALITY_CODE) like upper(?) and upper(a.SHORT_DESC) like upper(?) order by 2";
		
		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retVal = await CommonLookup( title, argArray )
		var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if (retVal != null && retVal != '' && retVal != "null")
		{
		   	document.forms[0].specialty.value = arr[1];
		   	document.forms[0].speciality_code.value = arr[0];
			document.forms[0].Splcode_desc_hid.value = document.forms[0].specialty.value; 
			if(arr[0] == "*ALL" || arr[0] == "ALL") {
				document.forms[0].speciality_code.value = "";
			}
		}
		else
		{	
			document.forms[0].specialty.value = "";
			document.forms[0].speciality_code.value = "";
			document.forms[0].Splcode_desc_hid.value = "";
		} 
}
//[IN062196] - Start
async function getPractitioner1(obj)
{	
	if (obj.value != "") 
	{
		var oldValFlag = false;
		if(document.forms[0].practCode_desc_hid.value != document.forms[0].attend_pract_desc.value)
			oldValFlag = true;
			
		if(oldValFlag)
		{
			await getPractitioner();
		}
		else
		{	
			if(obj.value == "" || obj.value == null) {
			
				document.forms[0].attend_pract_code.value = "";
				
			}	
		}
	}
	else
	{
		document.forms[0].attend_pract_code.value = ""; 
	}
}
//[IN062196] - End
async function getPractitioner()
{
		var target			= document.forms[0].attend_pract_desc;
		var locale			= document.forms[0].locale.value;
		var spec_code		= document.forms[0].speciality_code.value;
		
		var retVal			= new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= getLabel("Common.AttendingPractitioner.label","Common");
		
		var sql="select a.PRACTITIONER_ID code, a.SHORT_NAME description from am_practitioner_lang_vw  a where eff_status = 'E' and LANGUAGE_ID='"+locale+"'" ;
		if(spec_code == '' || spec_code == '*ALL' )
		{	
			sql = sql + " and upper(a.PRACTITIONER_ID) like upper(?) and upper(a.SHORT_NAME) like upper(?) order by 2";
		}
		else {
			sql = sql + " and PRIMARY_SPECIALITY_CODE like '"+spec_code+"' and upper(a.PRACTITIONER_ID) like upper(?) and upper(a.SHORT_NAME) like upper(?) order by 2";
		}
		
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
		retVal = await CommonLookup( title, argArray )
		
		var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			
		if (retVal != null && retVal != '' && retVal != "null")
		{
		   	document.forms[0].attend_pract_desc.value = arr[1];
		   	document.forms[0].attend_pract_code.value = arr[0];
			document.forms[0].practCode_desc_hid.value = document.forms[0].attend_pract_desc.value; //[IN062196]
			if(arr[0] == "*ALL" || arr[0] == "ALL") {
				document.forms[0].attend_pract_code.value = "";
			}
		}
		else
		{
			document.forms[0].attend_pract_desc.value = "";
			document.forms[0].attend_pract_code.value = "";
			document.forms[0].practCode_desc_hid.value = ""; //[IN062196]
		} 
}
//MMS-QH-CRF-0177 [IN047572] - End
//IN066453 start
function disableButtons(obj,siteSpecific){
	if(parent.details.controlsFrame !=undefined && parent.details.controlsFrame !='undefined'){
		formobj = parent.details.controlsFrame.document.forms[0];
		var hist_type = obj.value;
		if(siteSpecific && hist_type=="LBIN"){
			formobj.print.disabled = true;
			formobj.manage.disabled = true;
			formobj.comments.disabled = true;
		}else{
			formobj.print.disabled = false;
			formobj.manage.disabled = false;
			formobj.comments.disabled = false;
		}
	}	
	if(parent.details.details_f2 !=undefined && parent.details.details_f2 !='undefined'){
		formobj = parent.details.details_f2.encountercontrol.document.forms[0];
		var hist_type = obj.value;
		if(siteSpecific && hist_type=="LBIN"){
			formobj.print.disabled = true;
			formobj.manage.disabled = true;
			formobj.comments.disabled = true;
		}else{
			formobj.print.disabled = false;
			formobj.manage.disabled = false;
			formobj.comments.disabled = false;
		}
	}	
}
//IN066453 end
//IN070610, starts
function uploadedDocuments(accession_num, discr_msr_panel_id) {	
	window_id = window.open("../../eOR/jsp/ImageVideosFileUploadMain.jsp?p_called_from=View&p_acc_no="+accession_num+"&p_discr_msr_panel_id="+discr_msr_panel_id,'',"height=700,width=700,top=80,left=130,resizable=yes,directories=no,location=no,menubar=no,status=no");
}
//IN070610, ends
//31792 starts
async function NeonatalMotherSpecimenDetails(order_id,patient_id,accession_num,hist_rec_type)
{
	var dialogHeight ='90vh' ;
    var dialogWidth = '80vw' ;
    var dialogTop	= '129';
    var dialogLeft = '30' ;
	var title = ''
	//if(patientId!=undefined)
	var patient_id = document.forms[0].patient_id.value;	
	
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

	var arguments = "";
		
	var retVals = await window.showModalDialog("../../eOR/jsp/NeoNatalMotherSpecimenDetails.jsp?order_id="+order_id+"&patient_id="+patient_id+"&accession_num="+encodeURIComponent(accession_num)+"&history_type="+hist_rec_type,arguments,features);
	
}

//31792 ends 

