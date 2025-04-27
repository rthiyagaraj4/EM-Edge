/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?           100            ?           created
08/11/2011	IN28273		 Dinesh T	 Added the change event to that control
30/01/2012	IN030566		Ramesh G	When we place another Order of the same category the Pin No. is prompted again even if the Patient chart is not closed.
12/09/2012 IN034999			vijayakumark	-Encounter details and Confirm hyperlink not displayed for Enterprise Referral Type
----------------------------------------------------------------------------------------------------------------------------------
Date			Edit History	Name			Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------
04/02/2016		IN057201		Karthi L											View Forwarded Referral Letter Under Consults
09/08/2016		IN064836		Krishna Gowtham		09/08/2017		Ramesh G		ML-MMOH-CRF-0566.1
 6/11/2023     32902             Krishna Pranay    	     7/11/2023      Ramesh G      MMS-DM-CRF-0210	

---------------------------------------------------------------------------------------------------------*/
var babyDetails = new Array();
var motherName = new Array();
episodeIdArr = new Array();
patient_class = new Array();
var scrollValue=0;

/*var babyDetails = new Array();
	var motherName = new Array();

	patIdArr = new Array();
	visitIdArr = new Array();
	episodeIdArr = new Array();
	locnCodeArr = new Array();
	locnType = new Array();
	episodeTypeArr = new Array();
	pLineArr = new Array();
	bed_no = new Array();
	room_no = new Array()
	discharge_date = new Array()
	visit_adm_date = new Array()
	episode_status = new Array()
	pat_sex = new Array()
	pat_dob = new Array();
	pat_age = new Array();
	patient_class = new Array();*/

function clearLayer()
{
	hidePopUp();
} 

function showMotherLinks(episodeid,obj,babyCount)
{
	var babyLegend = "";

	if(babyCount > 1)
		babyLegend = "Babies";
	else
		babyLegend = "Baby";

	var tabdata = "<html><head><link rel='stylesheet' type='text/css' 		href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()'><table cellpadding=0 cellspacing=0 border=1 bordercolor=BLACK><tr><th><font size=1><b>"+babyLegend+" of "+motherName[episodeid]+"</b></font></th></tr><tr><td><table cellpadding=0 cellspacing=0 border=1><tr><td class=SENPAT nowrap>Patient ID</td><td class=SENPAT nowrap>Name</td><td class=SENPAT nowrap>Sex</td><td class=SENPAT nowrap>Date of Birth</td><td class=SENPAT nowrap>Time</td><td class=SENPAT nowrap>Weight</td><td class=SENPAT nowrap>Length</td><td class=SENPAT nowrap>Circumference</td><td class=SENPAT nowrap>Apgar Score</td></tr>";

	if(babyDetails[episodeid] != '')
	{
		tabdata +=babyDetails[episodeid]+"</td></tr></table></table></body></html>";
		document.getElementById("motherLink").innerHTML = tabdata;
		document.getElementById("motherLink").style.top  = obj.offsetTop;
		document.getElementById("motherLink").style.left  = obj.offsetLeft+50 ;
		document.getElementById("motherLink").style.visibility='visible' ;
	}
	else
	{
		hidePopUp();
	}
}

function hidePopUp()
{
	document.getElementById("motherLink").style.visibility='hidden' ;
}

function patClick(ind)
{
	self.document.PatCriteriaFrm.encounter_id.value = episodeIdArr[ind];
	self.document.PatCriteriaFrm.patient_class.value = patient_class[ind];		
	self.document.PatCriteriaFrm.unAssigned_yn.value = eval("self.document.PatCriteriaFrm.unAssigned_yn"+ind+".value");
	self.document.PatCriteriaFrm.referral_id.value = eval("self.document.PatCriteriaFrm.referral_id"+ind+".value");
	self.document.PatCriteriaFrm.submit();
}
//[IN030566] Starts
function patClick_new(ind,pat_id)
{
	   //32902 start
    var restPatientYN =document.getElementById("restPatientYN"+ind).value;
    var accessRightsViewPatient =document.getElementById("accessRightsViewPatient").value;  
    if(pat_id !=="" && restPatientYN =="Y" && accessRightsViewPatient==0){
  	restrictOpenVIPPat(pat_id,restPatientYN,accessRightsViewPatient);
     return ;
     } 
    //32902 end
    
	self.document.PatCriteriaFrm.encounter_id.value = episodeIdArr[ind];
	self.document.PatCriteriaFrm.patient_class.value = patient_class[ind];		
	self.document.PatCriteriaFrm.unAssigned_yn.value = eval("self.document.PatCriteriaFrm.unAssigned_yn"+ind+".value");
	self.document.PatCriteriaFrm.referral_id.value = eval("self.document.PatCriteriaFrm.referral_id"+ind+".value");
	//var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;		
	//var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var xmlHttp = new XMLHttpRequest();
	var	xmlStr			= "<root><SEARCH " ;
	xmlStr 			+=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "../../eOR/jsp/EnterOrderValidate.jsp?patient_id="+pat_id, false ) ;
	xmlHttp.send( xmlDoc ) ;
	if(trimString(xmlHttp.responseText)=="true")
	{
		self.document.PatCriteriaFrm.submit();
	}	
	
}

//[IN030566] Ends
async function viewReferral(ref)
{
	var retVal = 	new String();
	var dialogHeight= "95vh" ;
	var dialogTop = "100" ;
	var dialogWidth	= "65vw" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	var retVal = await top.window.showModalDialog("../../eMP/jsp/ViewPatReferral.jsp?referral_id="+ref,arguments,features);
}

function moveFrame()
{
	var temp=document.body.scrollLeft;
	scrollValue=temp;
}

//------------------------new functions for fixed frame sorting-------------

var reOrder='';
var anchorID='';

function callForOrderBy(obj)
{
	var qryStr = top.content.workAreaFrame.PatResultFr.LocnResultLocation.document.forms[0].url.value;
	top.content.workAreaFrame.PatCriteriaFr.document.forms[0].order_by.value=obj;
	top.content.workAreaFrame.PatCriteriaFr.document.forms[0].re_order.value=reOrder;
	top.content.workAreaFrame.PatCriteriaFr.document.forms[0].anchor_id.value=anchorID;	

	//deleting the old locn_type
	val=qryStr.indexOf("&locn_type=");
	len=qryStr.length;
	sr1=qryStr.substring(0,val+1);
	sr2=qryStr.substring(val+11,len);
	qryStr=sr1+sr2;

	var locType=top.content.workAreaFrame.PatCriteriaFr.document.forms[0].locn_type.value;
	var url = qryStr + '&locn_type=' + locType + '&orderBy=' + obj + '&reOrder=' + reOrder + '&anchorID=' + anchorID + '&leftScrolling=' + scrollValue;
	top.content.workAreaFrame.PatResultFr.LocnResult.location.href='PatientListByLocationResult.jsp?'+url;
} 

function changeColor(object)
{
	anchorID=object.id;
	
	if(object.style.color=='yellow')
	{	
		reOrder='1';
		object.style.color='pink';
		return;
	}

	if(object.style.color=='pink')
	{   
		reOrder='2';
		object.style.color='yellow';
		return;
	}

	reOrder='1';
	
	for(i=0;i<document.anchors.length;i++)
	{
		document.anchors(i).style.color='white';
	}

	object.style.color='pink';	
}

function storeValues(locn_type)
{
	if(locn_type != 'null')
		top.content.workAreaFrame.PatCriteriaFr.document.forms[0].locn_type.value=locn_type;
}

var reOrder='';
var scrollLeft='';

function callForOrderByLoc(obj)
{
	var qryStr = top.content.workAreaFrame.PatCriteriaFr.PatCriteriaFrm.url.value;
	top.content.workAreaFrame.PatCriteriaFr.document.forms[0].order_by.value=obj;
	top.content.workAreaFrame.PatCriteriaFr.document.forms[0].re_order.value=reOrder;	        top.content.workAreaFrame.PatCriteriaFr.document.forms[0].anchor_id.value=anchorID;
	var url=qryStr+'&orderBy='+obj+'&reOrder='+reOrder+'&anchorID=' + anchorID;
	var loc_code = document.PatCriteriaFrm.loc_code.value;
	var locn_type = document.PatCriteriaFrm.locn_type.value;
	top.content.workAreaFrame.PatResultFr.LocnResultPatClass.location.href='ReferralPatListResult.jsp?loc_code='+loc_code+'&locn_type='+locn_type+'&'+url+'&leftScrolling='+scrollValue;
}

var currClass = '';
var url='';

function callOnMouseOver(obj)
{
	if(obj.className != "WHITE")
	{
		currClass = obj.className ;
		if("H" == "H") 	
			obj.className = 'FIRSTSELECTED';
		else	
			obj.className = 'FIRSTNORMAL';
	}
}

function callOnMouseOut(obj)
{
	if(obj.className != "WHITE")
	{
		obj.className = currClass;
	}
}  

function display(from)
{
	cellref = document.getElementById("tab").rows[0].cells

	if("H" == "V")
		cellref = document.getElementById("tab").rows

	for(i=0; i<cellref .length; i++)
	{
		if("H" == "H")
			cellref[i].className = 'FIRSTNORMAL'
		else
			cellref[i].cells[0].className = 'SECONDNORMAL'
	}
	
	if("H" == "H")
	{
		from.className = "FIRSTSELECTED"
		currClass ="FIRSTSELECTED";
	}
	else
	{
		from.className = "FIRSTNORMAL";
		currClass ="FIRSTNORMAL";
	}
} 

function displayLoc(from)
{
	if(from.className != "WHITE")
	{
		cellref = document.getElementById("locnTab").rows[0].cells
		
		if("H" == "V")
			cellref = document.getElementById("locnTab").rows

		for(i=0; i<cellref .length; i++)
		{
			if("H" == "H")
			{
				if(cellref[i].className != "WHITE")
				{
					cellref[i].className = 'FIRSTNORMAL';
				}
			}
			else
			{
				if(cellref[i].cells[0].className != "WHITE")
				{
					cellref[i].cells[0].className = 'SECONDNORMAL';
				}
			}
		}
		if("H" == "H")
		{
			if(from.className !="WHITE")
			{
				from.className = "FIRSTSELECTED"
				currClass ="FIRSTSELECTED";
			}
		}
		else
		{
			if(from.className != "WHITE")
			{
				from.className = "FIRSTNORMAL";
				currClass ="FIRSTNORMAL";
			}
		}
	}
}
   
function showPrevLocn()
{
	var qryStr = top.content.workAreaFrame.PatResultFr.LocnResultPatClass.document.forms[0].queryString.value;
	qryStr=qryStr.substring(0,qryStr.length-10);
	var pat_type =  document.forms[0].pat_type.value;
	var cur_pos=document.forms[0].currentPos.value;

	if(document.forms[0].flagYN.value=='true' || document.forms[0].flagYN.value==true)
	{
		var from=eval(document.forms[0].from_disp.value)-5;
		var to=eval(document.forms[0].to_disp.value)-6;
		if(eval(cur_pos)>eval(to))
		{
			var url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false&flagLastYN=true';
		}
		else
		{
			var url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false';
		}
	}

	if(document.forms[0].flagYN.value==false || document.forms[0].flagYN.value=="false")
	{
		var from=eval(document.forms[0].from_disp.value)-5;
		var to=eval(document.forms[0].to_disp.value)-5;
		var url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false';

		if(eval(cur_pos)>eval(to))
		{
			var url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false&flagLastYN=true';
		}

		if(eval(cur_pos)<=to && eval(cur_pos)>=from)
		{
			from=eval(from)-1;
			url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=true';
		}
		//code for chaecking when the from become < 0
		if(eval(from)<0)
		{
			if(eval(cur_pos)>=0 && eval(cur_pos)<=5)//spacial case
			{
				from=0;
				to=5;
				url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=true';
			}
			else
			{
				from=0;
				to=4;
				url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false';
				//**checking for whether to display label on right side or not
				if(eval(cur_pos)>eval(to))
				{
					url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false&flagLastYN=true';
				} 
			}
		}
	}
	top.content.workAreaFrame.PatResultFr.LocnResultLocation.location.href="../../eCA/jsp/PatListByLocationPatLocn.jsp?"+url;
}

function showNextLocn()
{
	var pat_type =  document.forms[0].pat_type.value;
	var cur_pos=document.forms[0].currentPos.value;
	var qryStr   =  top.content.workAreaFrame.PatResultFr.LocnResultPatClass.document.forms[0].queryString.value;
	qryStr=qryStr.substring(0,qryStr.length-10);
	
	if(document.forms[0].flagYN.value=='true' || document.forms[0].flagYN.value==true)
	{
		var from=eval(document.forms[0].from_disp.value)+6;
		var to=eval(document.forms[0].to_disp.value)+5;
		var url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false';

		//**checking for whether to display label on right side or not
		if(eval(cur_pos)>eval(to))
		{
			var url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false&flagLastYN=true';
		}
	}
	if(document.forms[0].flagYN.value==false || document.forms[0].flagYN.value=="false")
	{
		var from=eval(document.forms[0].from_disp.value)+5;
		var to=eval(document.forms[0].to_disp.value)+5;
		var url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false';

		//**checking for whether to display label on right side or not
		if(eval(cur_pos)>eval(to))
		{
			var url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false&flagLastYN=true';
		}

		if(eval(cur_pos)<=to && eval(cur_pos)>=from)
		{
			to=eval(to)+1;
			url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=true';
		} 
	}

	top.content.workAreaFrame.PatResultFr.LocnResultLocation.location.href="../../eCA/jsp/PatListByLocationPatLocn.jsp?"+url;
}

function fillUrl()
{
	document.forms[0].url.value=top.content.workAreaFrame.PatResultFr.LocnResultPatClass.document.forms[0].url.value;
}

function alignHeading()
{
	if(top.content.workAreaFrame.PatResultFr.LocnResultTitle.document.getElementById("TitleTab") != null) 
	{
		top.content.workAreaFrame.PatResultFr.LocnResultTitle.document.getElementById("TitleTab").width =	eval(document.getElementById("PatCriteriaTbl").offsetWidth);
		for (j=0; j < document.getElementById("PatCriteriaTbl").rows[0].cells.length; j++) 
		{
			var wid=eval(document.getElementById("PatCriteriaTbl").rows[0].cells[j].offsetWidth);

			if(top.content.workAreaFrame.PatResultFr.LocnResultTitle.document.getElementById("TitleTab").rows[0].cells[j] != null)
			{
				top.content.workAreaFrame.PatResultFr.LocnResultTitle.document.getElementById("TitleTab").rows[0].cells[j].width=wid;
			}
		}
	}
}

function navigate(start,end)
{
	if(document.forms[0].prev != null)
		document.forms[0].prev.disabled = 'true';

	if(document.forms[0].nex != null)
		document.forms[0].nex.disabled = 'true';

	top.content.workAreaFrame.PatResultFr.LocnResultPatClass.document.getElementById("from").value = start ;
	top.content.workAreaFrame.PatResultFr.LocnResultPatClass.document.getElementById("to").value = end ;	

	var flag1=false;

	for(i=0;i<top.content.workAreaFrame.PatResultFr.LocnResultPatClass.document.anchors.length;i++)
	{
		if(top.content.workAreaFrame.PatResultFr.LocnResultPatClass.document.anchors(i).style.color == 'pink' || top.content.workAreaFrame.PatResultFr.LocnResultPatClass.document.anchors(i).style.color == 'yellow')
		{
			flag1 = true;
			break;
		}
	}

	if(!flag1)
	{
		top.content.workAreaFrame.PatCriteriaFr.document.getElementById("order_by").value = "";
		top.content.workAreaFrame.PatCriteriaFr.document.getElementById("re_order").value = "";
		top.content.workAreaFrame.PatCriteriaFr.document.getElementById("anchor_id").value = "";
	}
	var orderBy = top.content.workAreaFrame.PatCriteriaFr.document.getElementById("order_by").value;
	var reOrder = top.content.workAreaFrame.PatCriteriaFr.document.getElementById("re_order").value;
	var anchorID = top.content.workAreaFrame.PatCriteriaFr.document.getElementById("anchor_id").value;
	var fromDate = parent.parent.frames[0].document.getElementById("from_date").value;//IN28273
	var toDate = parent.parent.frames[0].document.getElementById("to_date").value;//IN28273
		
	if(top.content.workAreaFrame.PatResultFr.LocnResultPatClass.document.forms[0].form.value == "ReferralList")
	{
		//top.content.workAreaFrame.PatResultFr.LocnResultPatClass.document.forms[0].action = '../jsp/ReferralPatListResult.jsp?orderBy='+orderBy+'&reOrder='+reOrder+'&anchorID='+anchorID;//IN28273
		top.content.workAreaFrame.PatResultFr.LocnResultPatClass.document.forms[0].action = '../jsp/ReferralPatListResult.jsp?orderBy='+orderBy+'&reOrder='+reOrder+'&anchorID='+anchorID+"&fromDate="+fromDate+"&toDate="+toDate;//IN28273
	}
	
	top.content.workAreaFrame.PatResultFr.LocnResultPatClass.document.forms[0].method = 'post'
    top.content.workAreaFrame.PatResultFr.LocnResultPatClass.document.forms[0].target = ''
    top.content.workAreaFrame.PatResultFr.LocnResultPatClass.document.forms[0].submit() ; 

}

async function getConfirm(i)
{
	var patient_id = eval("self.document.PatCriteriaFrm.patient_id"+i+".value");
	var referral_id = eval("self.document.PatCriteriaFrm.referral_id"+i+".value");
	var location_code = eval("self.document.PatCriteriaFrm.location_code"+i+".value");
	var practitioner_Id = eval("self.document.PatCriteriaFrm.practitioner_Id"+i+".value");
	var sex = eval("self.document.PatCriteriaFrm.sex"+i+".value");
	
	 //32902 start
    var restPatientYN =document.getElementById("restPatientYN"+i).value;
   var accessRightsViewPatient =document.getElementById("accessRightsViewPatient").value;  
    if(patient_id !=="" && restPatientYN =="Y" && accessRightsViewPatient==0){
  	restrictOpenVIPPat(patient_id,restPatientYN,accessRightsViewPatient);
       return;
     } 
    //32902 end
    
	var function_id = self.document.PatCriteriaFrm.function_id.value;
	var encounterId = episodeIdArr[i];	
	var dialogTop		= "72";
	var dialogHeight	= "90vh";
	var dialogWidth		= "70vw";
	var features		= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "";

	var retVal =await top.window.showModalDialog("../../eIP/jsp/PaintReferralPatientDetails.jsp?function_id="+function_id+"&encounterId="+encounterId+"&patientid="+patient_id+"&called_from=CA&call_function=BedSideReferral&referralID="+referral_id,arguments,features);
	
	if(retVal == 'Success')
		//document.location.reload();IN28273
		parent.parent.PatCriteriaFr.document.getElementById('searchID').click();//IN28273
}
/* IN034999 starts */
//function showEncounterDeatils(i,encounterId)
async function showEncounterDeatils(i,encounterId,facilityid)
/* IN034999 ends */
{
	var patient_id = eval("self.document.PatCriteriaFrm.patient_id"+i+".value");
	var dialogTop		= "100";
	var dialogHeight	= "40vh";
	var dialogWidth		= "65vw";
	var title ="enc det ";
	var features		= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTitle:"+title+ "; status=no" ;
	var arguments		= "";
	/*IN034999 starts*/
	/*var retVal = window.showModalDialog("../../eCA/jsp/CurrentEncounter.jsp?patientId="+patient_id+"&encounterId="+encounterId,arguments,features);*/
	var retVal = await top.window.showModalDialog("../../eCA/jsp/CurrentEncounter.jsp?patientId="+patient_id+"&encounterId="+encounterId+"&facilityid="+facilityid,arguments,features);
	/*IN034999 ends*/
}
//ML-MMOH-CRF-0362 [IN057201] - Start
async function getRefClinicalNotes(patient_id, encounter_id, patient_class, facility_id)
{	
	var episode_type = "";
	if(patient_class == "IP" || patient_class=="DC")
		episode_type ="I";
	if(patient_class=="OP" ||patient_class=="EM")
		episode_type ="O";
	
	var retVal;
	var dialogHeight= "600";
	var dialogWidth	= "500";
	var status = "no";
	var arguments	= "";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=yes; status:" + status;
	var action_url;
	action_url	=	"../../eCA/jsp/RecClinicalNotesModal.jsp?function_id=REFERRAL_LETTER&appl_task_id=REFERRAL_LETTER&title=Record Referral Note&patient_id="+patient_id+"&encounter_id="+encounter_id+"&episode_type="+episode_type+"&patient_class="+patient_class+"&called_from=REFFERAL_NOTE_FROM_PAS&deflt_search_mode_from_refral_yn=Y"; 
	retVal=await window.showModalDialog(action_url,arguments,features);
}
//ML-MMOH-CRF-0362 [IN057201] - End
//IN064836 start
async function ReferralRegAuditTrial(i){                               
	var retVal = new String();
	var referral_id = eval("self.document.PatCriteriaFrm.referral_id"+i+".value");
	var dialogHeight= "30" ;                                                 
	
	var dialogWidth              = "70" ;
	
	var status = "no";                                             
	var features       = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=auto; status:" + status; 
	retVal =await window.showModalDialog("../../eIP/jsp/ReferralRegAuditTrialFrame.jsp?referral_id="+referral_id,arguments,features);
}
//IN064836 ends

