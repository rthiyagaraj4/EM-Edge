/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
11/08/2023   32902      Twinkle Shah    	    Ramesh Goli      MMS-DM-CRF-0210
--------------------------------------------------------------------------------------------------------
*/
clinicCodeArr = new Array();
clinicDescArr = new Array();
clinicTypeArr = new Array();
wardCodeArr = new Array();
wardDescArr = new Array();
dayCareCodArray =new Array();
dayCareDesArray =new Array();
OPEmerCodArray =new Array();
OPEmerDesArray =new Array();
MotherDetails = new Array();
MotherName= new Array();
scan_count_required_yn=new Array();//Added for MMS-DM-CRF-0170.1
alert_required_yn= new Array();//Added for MMS-DM-CRF-0170.1
remarks_required_yn=new Array();//Added for MMS-DM-CRF-0170.1
/*Result Page functions */ 

function patOpenChart(patid,encounterid,patclass,relnYn,relnreqYn,ind)//ind added  for MMS-DM-CRF-170.1
{
	//32902 start
    var restPatientYN =document.getElementById("restPatientYN"+ind).value;
    var accessRightsViewPatient =document.getElementById("accessRightsViewPatient").value;  
    if(patid !=="" && restPatientYN =="Y" && accessRightsViewPatient==0){
  	restrictOpenVIPPat(patid,restPatientYN,accessRightsViewPatient);
       return;
     } 
    //32902 end
	//Adding start for MMS-DM-CRF-0157.2
	var retval="";
	var entry_type ="";
	var formObj = top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm;
	var temp_scan_count_required_yn=scan_count_required_yn[ind];//Added for MMS-DM-CRF-0170.1
	var temp_alert_required_yn=alert_required_yn[ind]; //Added for MMS-DM-CRF-0170.1
	var temp_remarks_required_yn=remarks_required_yn[ind];//Added for MMS-DM-CRF-0170.1
	
		if(formObj.bar_code_scan_site_YN.value=="Y" && temp_scan_count_required_yn =='Y'){//Added for MMS-DM-CRF-0170.1

				 if((formObj.newbornid.value != "" || formObj.motherid.value !="") && temp_alert_required_yn == 'Y' ){
					 if(formObj.bar_code_scaned_YN.value =="N")
						 retval= callManualScanRemarks(patid,encounterid,patclass,temp_remarks_required_yn)
				 }else if(((formObj.newbornid.value != "" || formObj.motherid.value !="") && formObj.bar_code_scaned_YN.value =='Y') || (temp_scan_count_required_yn == 'Y' && temp_alert_required_yn =='N' )){
						 if(formObj.bar_code_scaned_YN.value=='Y' && temp_scan_count_required_yn == 'Y')
										entry_type = "S";
								 else
										entry_type = "M";

							 retval= scanBarcodeCount(patid,encounterid,patclass,entry_type)
					 }
			}
if(retval != undefined){//Adding end for MMS-DM-CRF-0157.2s
	if(encounterid == '')
		patclass='XT'

	top.content.workAreaFrame.NewBornResultFrame.document.NewBornForm.patient_class.value = patclass;
	top.content.workAreaFrame.NewBornResultFrame.document.NewBornForm.encounter_id.value = encounterid;
	top.content.workAreaFrame.NewBornResultFrame.document.NewBornForm.patient_id.value= patid;
	top.content.workAreaFrame.NewBornResultFrame.document.NewBornForm.reln_ReqYn.value= relnreqYn;

	if(relnreqYn == "Y")
		top.content.workAreaFrame.NewBornResultFrame.document.NewBornForm.reln_Yn.value= relnYn;
	else
		top.content.workAreaFrame.NewBornResultFrame.document.NewBornForm.reln_Yn.value= "Y";

	top.content.workAreaFrame.NewBornResultFrame.document.NewBornForm.submit();
 }
}

function callOrderBy(id)
{
var admit=top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.admitted.value;
var health=top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.healthy.value;
//var viewlist=top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.viewList.value;
var newbornid=top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.newbornid.value;
var motherid=top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.motherid.value;
var newbornenc=top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.encounterId.value;
//var locationType=top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.locationType.value;

var locationType ="";
var locationCode=top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.locationCode.value;
var querystring=top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.querystring.value;


var reOrder=top.content.workAreaFrame.NewBornResultFrame.document.NewBornForm.reOrder.value;
var anchorID=top.content.workAreaFrame.NewBornResultFrame.document.NewBornForm.anchorID.value
var scrollValue=top.content.workAreaFrame.NewBornResultFrame.document.NewBornForm.scrol.value
var relnreqyn=top.content.workAreaFrame.NewBornResultFrame.document.NewBornForm.relnreqyn.value
var decease=top.content.workAreaFrame.NewBornResultFrame.document.NewBornForm.decease.value
scrollValue = document.body.scrollLeft;

//top.content.workAreaFrame.NewBornTitleFrame.location.href="../../eCA/jsp/NewBornListTitle.jsp";
top.content.workAreaFrame.NewBornResultFrame.location.href="../../eCA/jsp/NewBornListDetails.jsp?admit="+admit+"&health="+health+"&newbornid="+newbornid+"&motherid="+motherid+"&newbornenc="+newbornenc+"&locationType="+locationType+"&locationCode="+locationCode+"&ID="+id+"&reOrder="+reOrder+"&anchorID="+anchorID+"&leftScrolling="+scrollValue+"&"+querystring+"&reln_req_yn="+relnreqyn+"&decease="+decease;

//top.content.workAreaFrame.NewBornResultFrame.location.href="NewBornListDetails.jsp?ID="+id+"&reOrder="+reOrder+"&anchorID="+anchorID+"&leftScrolling="+scrollValue;
}
function changeColor(object)
{
	
	anchorID=object.id;
	//alert('object.style.color'+object.style.color);
	
	if(object.style.color=='yellow')
	{
		
		object.style.color='pink';
		top.content.workAreaFrame.NewBornResultFrame.document.NewBornForm.reOrder.value='1';
		top.content.workAreaFrame.NewBornResultFrame.document.NewBornForm.anchorID.value=anchorID;
		
		return;
	}
	
	if(object.style.color=='pink')
	{
		
		object.style.color='yellow';
		top.content.workAreaFrame.NewBornResultFrame.document.NewBornForm.reOrder.value='2';
		top.content.workAreaFrame.NewBornResultFrame.document.NewBornForm.anchorID.value=anchorID;
		return;
	}
	top.content.workAreaFrame.NewBornResultFrame.document.NewBornForm.reOrder.value='1';
	top.content.workAreaFrame.NewBornResultFrame.document.NewBornForm.anchorID.value=anchorID;
	//alert('anchorslength'+top.content.workAreaFrame.NewBornTitleFrame.document.anchors.length);
	for(i=0;i<top.content.workAreaFrame.NewBornTitleFrame.document.anchors.length;i++)
	{
		top.content.workAreaFrame.NewBornTitleFrame.document.anchors[i].style.color='white';

	}
	
}
function moveFrame(){
	var temp=top.content.workAreaFrame.NewBornResultFrame.document.body.scrollLeft;
	top.content.workAreaFrame.NewBornResultFrame.document.NewBornForm.scrol.value=temp;
}

/*Crieteria functions */
async function getNewbornId()
{
	var pat_id =  await PatientSearch();
	//alert("here");
	if(pat_id != undefined)	
	{
		top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.newbornid.value=pat_id;
		top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.newbornid.focus();
	}
}
async function getMotherId()
{
	var pat_id =  await PatientSearch();
	if(pat_id != undefined)	
	{
		top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.motherid.value=pat_id;
		top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.motherid.focus();
	}
}

function checkDuplicate(obj)	 {
						ChangeUpperCase(obj);
						if(obj.value != ""){
							var HTMLVal = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='frmDuplicateId' id='frmDuplicateId' method='post' action='../../eCA/jsp/CAValidatePatientId.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+escape(obj.value)+"'><input type='hidden' name='fromFunction' id='fromFunction' value='PatListByLocation'></form></body></html>";
							top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
							top.content.messageFrame.document.frmDuplicateId.submit();
						}
			}

/*function checkForPatient(objText,flag)
{
	 
	if(objText.value != '')
	{

		var htmlVal = "<html><form name='tempForm' id='tempForm' action='../../eCA/jsp/PatTaskListSortIntermediate.jsp' method='post'><input type='hidden' name='patientId' id='patientId' value='"+objText.value+"'><input type='hidden' name='flag' id='flag' value='"+flag+"'></form></html>";
		top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',htmlVal);
		top.content.messageFrame.document.tempForm.submit();
		
	}
	
}*/

function locnTypeChange(obj){ 
		

		document.getElementById("locLed").innerText=getLabel("Common.Location.label","Common");
		//document.getElementById("locLed").innerText='Location';
		document.getElementById("locVal").style.visibility='visible';
		document.forms[0].locationCode.disabled = false;
		var optlen = document.forms[0].locationCode.options.length;
		
		for (i=0; i<optlen; i++){
			document.forms[0].locationCode.remove(0);
		}

		
		if(obj.value == 'Z' ){
			document.getElementById("locLed").innerText='';
			document.getElementById("locVal").style.visibility='hidden';
			document.forms[0].locationCode.disabled = true;
			var oOption = document.createElement("OPTION");
			oOption.text= getLabel("Common.all.label","Common");
			//oOption.text="All";
			oOption.value="*ALL";
			document.forms[0].locationCode.add(oOption);
		}else if(obj.value == 'OP') {
			document.getElementById("locLed").innerText=getLabel("Common.clinic.label","Common");
			//document.getElementById("locLed").innerText='Clinic ';
			var oOption = document.createElement("OPTION");
			oOption.text= getLabel("Common.all.label","Common");
			//oOption.text="All";
			oOption.value="*ALL";
			document.forms[0].locationCode.add(oOption);
			
			for(j=0; j<clinicCodeArr.length; j++){
				if (clinicTypeArr[j]=='A'){
					var oOption = document.createElement("OPTION");
					oOption.text=clinicDescArr[j];
					oOption.value=clinicCodeArr[j];
					document.forms[0].locationCode.add(oOption);
				}			
			}
	}else if(obj.value == 'IP'){ 
		document.getElementById("locLed").innerText=getLabel("Common.nursingUnit.label","Common");
		//document.getElementById("locLed").innerText='Nursing Unit ';
		var oOption = document.createElement("OPTION");
		oOption.text= getLabel("Common.all.label","Common");
		//oOption.text="All";
			oOption.value="*ALL";
		document.forms[0].locationCode.add(oOption);
		for(j=0; j<wardCodeArr.length; j++) {
			var oOption = document.createElement("OPTION");
			oOption.text=wardDescArr[j];
			oOption.value=wardCodeArr[j];
			document.forms[0].locationCode.add(oOption);
		}
	}else if (obj.value=='DC'){
		document.getElementById("locLed").innerText=getLabel("Common.DaycareUnit.label","Common");
		//document.getElementById("locLed").innerText='Day Care Units ';
		var oOption = document.createElement("OPTION");
		oOption.text= getLabel("Common.all.label","Common");
		//oOption.text="All";
		oOption.value="*ALL";
		document.forms[0].locationCode.add(oOption);
		for(j=0; j<dayCareCodArray.length; j++) {
			var oOption = document.createElement("OPTION");
			oOption.text=dayCareDesArray[j];
			oOption.value=dayCareCodArray[j];
			document.forms[0].locationCode.add(oOption);
		}
	}else if( obj.value=='EM'){
		document.getElementById("locLed").innerText=getLabel("Common.EmergencyUnits.label","Common");
		//document.getElementById("locLed").innerText='Emergency Units ';
		var oOption = document.createElement("OPTION");
		oOption.text= getLabel("Common.all.label","Common");
		//oOption.text="All";
		oOption.value="*ALL";
		document.forms[0].locationCode.add(oOption);
		for(j=0; j<OPEmerCodArray.length; j++) {
			var oOption = document.createElement("OPTION");
			oOption.text=OPEmerDesArray[j];
			oOption.value=OPEmerCodArray[j];
			document.forms[0].locationCode.add(oOption);
		}
	}
	

}
function healthyClick(obj)
{

if(obj.checked == true)
	{
	
top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.healthy.checked=true;
top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.healthy.value='Y';
	}
	else
	{
top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.healthy.checked=false;
top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.healthy.value='N';
	}

}

function admittedClick(obj)
{
if(obj.checked == true)
	{
top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.admitted.checked=true;
top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.admitted.value='Y';
	}
	else
	{
top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.admitted.checked=false;
top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.admitted.value='N';
	}
}

function deceasedClick(obj)
{
if(obj.checked == true)
	{
top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.deceased.checked=true;
top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.deceased.value='Y';
	}
	else
	{
top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.deceased.checked=false;
top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.deceased.value='N';
	}
}

function searchClick()
{
var admit = top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.admitted.value;
var health = top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.healthy.value;
var decease = top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.deceased.value;
if(admit == 'Y' || health == 'Y' || decease == 'Y')
	{

//var viewlist=top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.viewList.value;
var newbornid=top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.newbornid.value;
var motherid=top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.motherid.value;
var newbornenc=top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.encounterId.value;

//var locationType=top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.locationType.value;
var locationType="";

var locationCode=top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.locationCode.value;
var querystring=top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.querystring.value;
var establishRelnYN=top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.establishRelnYN.value;
var bar_code_scan_site_YN =top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.bar_code_scan_site_YN.value;//Added for MMS-DM-CRF-0170.1
//alert("admit="+admit+"&health="+health+"&viewlist="+viewlist+"&newbornid="+newbornid+"&motherid="+motherid+"&newbornenc="+newbornenc);
//alert("newbornid"+newbornid);
//alert("querystring"+querystring);

top.content.workAreaFrame.NewBornTitleFrame.location.href="../../eCA/jsp/NewBornListTitle.jsp";
top.content.workAreaFrame.NewBornResultFrame.location.href="../../eCA/jsp/NewBornListDetails.jsp?admit="+admit+"&health="+health+"&decease="+decease+"&newbornid="+newbornid+"&motherid="+motherid+"&newbornenc="+newbornenc+"&locationType="+locationType+"&locationCode="+locationCode+"&"+querystring+'&reln_req_yn='+establishRelnYN+"&bar_code_scan_site_YN="+bar_code_scan_site_YN;//bar_code_scan_site_YN added for MMS-DM-CRF-0170.1
	}
	else
	{
		parent.NewBornTitleFrame.location.href="../../eCommon/html/blank.html";
		parent.NewBornResultFrame.location.href="../../eCommon/html/blank.html";
		alert(getMessage("NEWBORN_DISPLAY_CRITERIA","CA"));
	}

}
function clearClick()
{
var querystring=top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm.querystring.value;
top.content.workAreaFrame.NewBornCriteriaFrame.location.href="../../eCA/jsp/NewBornListCriteria.jsp?"+querystring;
top.content.workAreaFrame.NewBornTitleFrame.location.href="../../eCommon/html/blank.html";
top.content.workAreaFrame.NewBornResultFrame.location.href="../../eCommon/html/blank.html";
}
function showMotherDetail(index,obj)
{
	
var tabdata = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><table cellpadding='3' cellspacing=0 border=1 bordercolor=BLACK><tr><th class='columnheader'><font size=1><b><fmt:message key='eCA.Motherof.label' bundle='${ca_labels}'/>"+MotherName[index]+"</b></font></th></tr><tr><td><table cellpadding='3'cellspacing=0 border=1><tr><td class=SENPAT nowrap><fmt:message key='eCA.MothersName.label' bundle='${ca_labels}'/></td><td class=SENPAT nowrap><fmt:message key='Common.age.label' bundle='${common_labels}'/></td><td class=SENPAT nowrap><fmt:message key='eCA.MothersID.label' bundle='${ca_labels}'/></td><td class=SENPAT nowrap><fmt:message key='Common.nursingUnit.label' bundle='${common_labels}'/></td><td class=SENPAT nowrap><fmt:message key='Common.room.label' bundle='${common_labels}'/></td><td class=SENPAT nowrap><fmt:message key='Common.Bed.label' bundle='${common_labels}'/></td><td class=SENPAT nowrap><fmt:message key='Common.admissiondate.label' bundle='${common_labels}'/></td></tr>";
	if(MotherDetails[index] != '')
	{
		tabdata +=MotherDetails[index]+"</td></tr></table></table></body></html>";

		document.getElementById("motherLink").innerHTML = tabdata;
		document.getElementById("motherLink").style.top  = obj.offsetTop+"px";
		document.getElementById("motherLink").style.left  = obj.offsetLeft+200+"px" ;
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
function clearLayer()
{
	hidePopUp();
}


function allowValidNo(fld, e, maxInt, deci)
{
    var count=fld.value.length;//ok
    var whichCode = (window.Event) ? e.which : e.keyCode;//ok
	var minusOccurance = fld.value.indexOf('-');

	if(minusOccurance != -1)
		maxInt++;

	if(whichCode == 45)
		return false

    if(count>=maxInt)
    {
        if(count==maxInt)
        {
            var dotOccurance = fld.value.indexOf('.');
			//alert("dotOccurance : "+dotOccurance);

            if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt)&& deci>0)
            {
				if(whichCode!=46)
                {
                    fld.value = fld.value+".";
                    //alert("APP-0001 Reached Maximum Integer value");
                    //return false;
                }
            }
        }
        else if(count>maxInt)
        {
            var objectValue = fld.value;
            var dotOccurance = objectValue.indexOf('.');
            //alert(objectValue.charAt(maxInt));
            if((objectValue.charAt(maxInt))!='.')
            {
                if(dotOccurance==-1 && parseInt(deci)>0 )
                {
                    fld.value = objectValue.substring(0,maxInt)+".";
                    return false;
                }
            }
        }
    }
	//you donot require this just var strCheck = '.0123456789' for deci > 0
	//strCheck = '0123456789' for deci=0
	      var strCheck = '.0123456789-';

//	alert(e.getKeyCode())
    if (parseInt(deci)==0)//For Only Nos 0 - 9
        strCheck = '0123456789-';

    var fldvalue=fld.value;
    var whichCode = (window.Event) ? e.which : e.keyCode;
    if (whichCode == 13) return true;  // Enter
    var pointCount=0;

    for(var i=0;i<fldvalue.length;i++)
    {
        if(fldvalue.charAt(i)=='.') pointCount++;
    }

    if (pointCount>0 && whichCode == 46) return false;

    var fldValue    =   fld.value;
    var dotIndex    =   fldValue.indexOf(".");
    var fldLength   =   fldValue.length;
    if(dotIndex!=-1)
        if( fldLength > (dotIndex+deci) ) return false;


	key = String.fromCharCode(whichCode);  // Get key value from key code

	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	else if(key == "-" && fldValue.indexOf(key) != -1  )
	{
		if(fldValue.indexOf(key) != 1 )
			return false
	}
    return true;
}

function getLocCode(obj)
{
	
	if(obj.value!="")
	{
		populateLoc();
	}
	else
	{
		document.forms[0].locationCode.value="*ALL";
		document.forms[0].locationDesc.value="";	
	}
}

async function populateLoc()//onclick

{

		//var patient_class=obj.value;
		var target				= document.forms[0].locationDesc;
		var retVal				=  new String();
		var dialogTop			= "40";
		var dialogHeight		= "30" ;
		var dialogWidth			= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc			= "";
		var title				= getLabel("Common.nursingUnit.label","COMMON");
		var locale				= document.forms[0].locale.value; 
		var facilityId			= document.forms[0].facilityId.value; 
		var ca_practitioner_id	= document.forms[0].ca_practitioner_id.value; 

		//var sql="select DISTINCT a.SERVICE_CODE code,B.SHORT_DESC description from CA_PRACT_BY_SPLTY_LOCN_VIEW A,AM_SERVICE_LANG_VW B  where FACILITY_ID='"+facilityId+"' and upper(B.SHORT_DESC) like upper(?)and A.SERVICE_CODE like upper(?) and PRACTITIONER_ID='"+ca_practitioner_id+"' and PATIENT_CLASS='"+patient_class+"' AND A.SERVICE_CODE = B.SERVICE_CODE AND B.LANGUAGE_ID = '"+locale+"'";
		var sql ="Select locn_code code,IP_GET_DESC.IP_NURSING_UNIT('"+facilityId+"',locn_code,'"+locale+"','1') description from ca_pract_by_locn_view where upper(LOCN_SHORT_DESC) like upper(?)and locn_code like upper(?) and practitioner_id= '"+ca_practitioner_id+"'and locn_type ='W' and facility_id = '"+facilityId+"'order by 2"
		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "2,1";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		
		retArray = await CommonLookup( title, argArray );
		
		if (retArray != null  && retArray != "")
		{
			var ret1=unescape(retArray);
			var arr=ret1.split(",");
			if(arr[1]==undefined) { 
			arr[1]="";
			arr[0]="";
			}
		   	document.forms[0].locationDesc.value=arr[1];
			document.forms[0].locationCode.value=arr[0];
		}
		else
		{	
			document.forms[0].locationCode.value="*ALL";
			document.forms[0].locationDesc.value="";
		}
}

/*
function populateService(obj,ca_practitioner_id,facilityId)
{

		var patient_class=obj.value;
		var target			= document.forms[0].medServiceDesc;
		var retVal			=  new String();
		var dialogTop	= "40";
		var dialogHeight		= "10" ;
		var dialogWidth	= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc			= "";
		var title				=getLabel("eCA.MedicalService.label","CA");
		var locale =document.forms[0].locale.value; 
		
		if (patient_class == "Z")
			var sql="select DISTINCT a.SERVICE_CODE code,b.SHORT_DESC description from CA_PRACT_BY_SPLTY_LOCN_VIEW a,AM_SERVICE_LANG_VW B where FACILITY_ID='"+facilityId+"' and upper(B.SHORT_DESC) like upper(?)and A.SERVICE_CODE like upper(?) and PRACTITIONER_ID='"+ca_practitioner_id+"' and a.service_code =  b.SERVICE_CODE AND B.LANGUAGE_ID = '"+locale+"'";	
		else
			var sql="select DISTINCT a.SERVICE_CODE code,B.SHORT_DESC description from CA_PRACT_BY_SPLTY_LOCN_VIEW A,AM_SERVICE_LANG_VW B  where FACILITY_ID='"+facilityId+"' and upper(B.SHORT_DESC) like upper(?)and A.SERVICE_CODE like upper(?) and PRACTITIONER_ID='"+ca_practitioner_id+"' and PATIENT_CLASS='"+patient_class+"' AND A.SERVICE_CODE = B.SERVICE_CODE AND B.LANGUAGE_ID = '"+locale+"'"; 

		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "2,1";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		
		retArray = CommonLookup( title, argArray );
		
		if (retArray != null  && retArray != "")
		{
		   	document.forms[0].medServiceDesc.value=retArray[1];
			document.forms[0].medServiceCode.value=retArray[0];
		}
		else
		{	
			document.forms[0].medServiceCode.value="ALL";
			document.forms[0].medServiceDesc.value="";
		}
}

function getServiceCode(obj1,obj2,ca_practitioner_id,facilityId)
{
	if(obj1.value!="")
	{
		populateService(obj2,ca_practitioner_id,facilityId);
	}
	else
	{
		document.forms[0].medServiceCode.value="ALL";
		document.forms[0].medServiceDesc.value="";	
	}
}




*/

function alignHeading()
{
	
	if(parent.NewBornTitleFrame.document.getElementById("PatCriteriaTbl") != null) 
	{
											
			parent.NewBornTitleFrame.document.getElementById("PatCriteriaTbl").width =	eval(document.getElementById("PatCriteriaTb").offsetWidth);
				
				for(j=0;j < document.getElementById("PatCriteriaTb").rows[0].cells.length; j++) 
				{
					
					var wid=eval(document.getElementById("PatCriteriaTb").rows[0].cells[j].offsetWidth);
										
					if(parent.NewBornTitleFrame.document.getElementById("PatCriteriaTbl").rows[2].cells[j] != null)
						{
						   parent.NewBornTitleFrame.document.getElementById("PatCriteriaTbl").rows[2].cells[j].width=wid;
						}
				}
	}
}


function moveFrame()
{
	var temp=document.body.scrollLeft;
	scrollValue=temp;

	if(parent.NewBornTitleFrame.location.href.indexOf(".jsp") != -1)
	{
		top.content.workAreaFrame.NewBornTitleFrame.document.body.scrollLeft=temp;
	}
}
//Adding start for MMS-DM-CRF-0157.2

function barcodeScan(evnt,pat_id,called_from){
	//alert()
	var keyVal	= parseInt(evnt.keyCode);
	var formObj =top.content.workAreaFrame.NewBornCriteriaFrame.document.NewBornCriteriaForm;
	 var bar_code_site_yn = formObj.bar_code_scan_site_YN.value;
	   if(bar_code_site_yn =="Y" && pat_id.value!="" && pat_id.value.length>1 && keyVal==17){
		   if(called_from=="CHILD"){
		      formObj.baby_bar_code_scaned_YN.value="Y";
			  if(formObj.motherid.value != "" && formObj.mother_bar_code_scaned_YN.value =="Y" ){
                   formObj.bar_code_scaned_YN.value="Y";
			  } else if(formObj.motherid.value == ""){
				  formObj.bar_code_scaned_YN.value="Y";
			  }else
				  formObj.bar_code_scaned_YN.value="N";
		   } else if(called_from=="MOTHER"){
              formObj.mother_bar_code_scaned_YN.value="Y";
			   if(formObj.newbornid.value != "" && formObj.baby_bar_code_scaned_YN.value =="Y" ){
                   formObj.bar_code_scaned_YN.value="Y";
			  } else if(formObj.newbornid.value == ""){
				  formObj.bar_code_scaned_YN.value="Y";
			  }else
				  formObj.bar_code_scaned_YN.value="N";
		   }
	   }else{
		  // alert("else")
		  if(formObj.baby_bar_code_scaned_YN.value =""){//Added condition for testing issue MMS-DM-CRF-0170.1 raised by MMS
		  if(called_from=="CHILD"){
		      formObj.baby_bar_code_scaned_YN.value="N";
			  formObj.bar_code_scaned_YN.value="N";
		  }else if(called_from=="MOTHER"){
              formObj.mother_bar_code_scaned_YN.value="N";
			  formObj.bar_code_scaned_YN.value="N";
		    }
		  }
		   }
        
		 
}

async function callManualScanRemarks(patient_id,encounter_id,patclass,temp_remarks_required_yn){//temp_remarks_required_yn aAdded  for MMS-DM-CRF-0170.1
	var retVal = new String();
	var dialogHeight= "17" ;                                                 
	
	var dialogWidth              = "40" ;

	var status = "no";                                             
	var features       = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=auto; status:" + status; 
	retVal =await window.showModalDialog("../../eOR/jsp/BarCodeManualEntryReason.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patclass+"&remarks_mandetory_yn="+temp_remarks_required_yn+"&module_id=CA&menu_id=NEW_BORN_LIST&entry_type=M",arguments,features);
		return retVal;//temp_remarks_required_yn added for MMS-DM-CRF-0170.1
}

function scanBarcodeCount(patient_id,encounter_id,patclass,entry_type){//patclass,entry_type added for MMS-DM-CRF-0170.1
	    var retVal = "";
	    var menu_id ="NEW_BORN_LIST";
	    var module_id ="CA";
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " patient_id=\""+patient_id+"\"";
		xmlStr += " encounter_id=\""+encounter_id+"\"";
		xmlStr += " menu_id=\""+menu_id+"\"";
		xmlStr += " module_id=\""+module_id+"\"";
        xmlStr += " entry_type=\""+entry_type+"\"";
		xmlStr += " patient_class=\""+patclass+"\"";
		xmlStr +=" /></root>";
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
		xmlHttp.open("POST","../../eOR/jsp/BarCodeManualEntryReasonSave.jsp?",false);
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText;
		return true;
}

//Adding end for MMS-DM-CRF-0157.2

/*function AllowNoOnly(obj)
{
	var encounterId = document.forms[0].encounterId.value;

	  if(encounterId!=null)
	   {
		  if (isNaN(encounterId))
			{
			  alert(getMessage("NUM_ALLOWED","CA"));
			  obj.select();
			  return false;
			 }	
		  }
}*/


