var encounter
var practitioner
var clinic
var PatientId
var logicalSeqNo
var Sec_Hdg="default"
var sex=""
var qstat
var loctype = ''
var visitstatus = ''

function callSelectPatient(det)
{
	parent.frames[1].frames[1].location.href='CompleteVisitSelectPatientFrames.jsp'
	parent.frames[1].frames[0].location.href='/eCIS/common/html/blank.html';

	if(det=="true")
	{
		det="false"
		location.href='/eCIS/op/jsp/CompleteVisitOptions.jsp?Detail='+det
	}
}
async function callCompleteVisit(det)
{
		parent.parent.frames[0].document.Ids.PatientId.value=""
		parent.parent.frames[0].document.Ids.EncounterId.value=""
		parent.parent.frames[0].document.Ids.ClinicCode.value=""
		parent.parent.frames[0].document.Ids.PractitionerId.value=""

		parent.frames[1].frames[0].location.href='/eCIS/common/html/blank.html';
		parent.frames[1].frames[1].location.href='/eCIS/common/html/blank.html';

		location.href='/eCIS/op/jsp/CompleteVisitOptions.jsp?Detail=false'
}

/*Function that is executed on click of options from the menu*/
function loadPages(functionname,locntype)
{
	/*To get values that is to be passed as arguement to the called pages/functions  */
	getParameters();

	/*method to clear messageframe*/
	clrMessageFrame()
	if(functionname!="Disposition")
	{
		if(practitioner==null || practitioner=="null")
		{
			alert(parent.parent.parent.frames[0].getMessage("PRACT_NOT_ASSIGN","IP"))
			return
		}
	}
	if(functionname=="Notes")
	{
		parent.frames[1].frames[1].location.href='/eCIS/ca/jsp/GeneralRemarks.jsp?Encounter_Id='+encounter+'&Practitioner_Id='+practitioner+'&Clinic_Code='+clinic+'&Patient_Id='+PatientId+'&Logical_Seq=8&Sec_Hdg=GEN'
	}
	if(functionname=="Consults")
	{
		parent.frames[1].frames[1].location.href='/eCIS/op/jsp/PaintAddPractInCompleteVisit.jsp?Encounter_Id='+encounter+'&Practitioner_Id='+practitioner+'&Clinic_Code='+clinic+'&Patient_Id='+PatientId
	}
	if(functionname=="Procedures")
	{
		loctype = locntype

		parent.frames[1].frames[1].location.href='/eCIS/ca/jsp/OPProc.jsp?Encounter_Id='+encounter+'&Practitioner_Id='+practitioner+'&Clinic_Code='+clinic+'&Patient_Id='+PatientId+"&Locn_Type="+loctype
	}
	if(functionname=="Disposition")
	{
			var retVal = 	new String();
			var dialogHeight= "50vh" ;
			var dialogWidth	= "55vw" ;
			var status = "no";
			var scroll = "no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
			var arguments	= "" ;

			if( !(visitstatus=="08" || visitstatus=="09" || visitstatus=="99"  || visitstatus=="07") )
			{
				retVal = await window.showModalDialog('/eCIS/ca/jsp/PatCheckoutCall.jsp?p3='+encounter+'&p6='+practitioner+'&p5='+clinic+'&p2='+PatientId+'&p4='+loctype+"&QS="+qstat+"&title=Disposition",arguments,features);
				if(retVal=="TRUE")
						document.location.href='/eCIS/op/jsp/CompleteVisitOptions.jsp?'
			}
			else
				alert(parent.parent.parent.frames[0].getMessage("DISP_COMPLETE","IP"))
	}

	if(functionname=="Diagnosis")
	{


			parent.frames[1].frames[1].location.href='/eCIS/ca/jsp/PatProblemMain.jsp?Function=CV&Encounter_Id='+encounter+'&Practitioner_Id='+practitioner+'&Clinic_Code='+clinic+'&Patient_Id='+PatientId+'&Sec_Hdg=ASES'+'&Locn_Type='+loctype;
	}

	if(functionname=="VitalSigns")
	{
		parent.frames[1].frames[1].location.href='/eCIS/ca/jsp/VitalSigns.jsp?p3='+encounter+'&p6='+practitioner+'&p5='+clinic+'&p2='+PatientId+'&Logical_Seq=3&Sec_Hdg=VSGN&p8='+sex+'&p4='+loctype+"&FP=CV"+"&p1="+qstat

	}
	if(functionname=="Lab")
	{
			parent.frames[1].frames[1].location.href='/eCIS/op/jsp/RecConsInvestigations.jsp?Encounter_Id='+encounter+'&Practitioner_Id='+practitioner+'&Clinic_Code='+clinic+'&Patient_Id='+PatientId+'&p_mode=LAB'+'&Locn_Type='+loctype
	}
	if(functionname=="Radio")
	{
		parent.frames[1].frames[1].location.href='/eCIS/op/jsp/RecConsInvestigations.jsp?Encounter_Id='+encounter+'&Practitioner_Id='+practitioner+'&Clinic_Code='+clinic+'&Patient_Id='+PatientId+'&p_mode=RAD'+'&Locn_Type='+loctype
	}
}

function getParameters()
{

		encounter=parent.parent.frames[0].document.Ids.EncounterId.value
		practitioner=parent.parent.frames[0].document.Ids.PractitionerId.value
		clinic=parent.parent.frames[0].document.Ids.ClinicCode.value
		PatientId=parent.parent.frames[0].document.Ids.PatientId.value
		sex=parent.parent.frames[0].document.Ids.Sex.value
		visitstatus=parent.parent.frames[0].document.Ids.VisitStatus.value
}
function clrMessageFrame()
{
	parent.parent.frames[2].location.href='/eCIS/common/jsp/error.jsp'
}
