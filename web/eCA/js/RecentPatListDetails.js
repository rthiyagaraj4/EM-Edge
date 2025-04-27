/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------

6/11/2023     32902             Krishna Pranay    	     7/11/2023      Ramesh G      MMS-DM-CRF-0210	

---------------------------------------------------------------------------------------------------------------

*/


var babyDetails = new Array();
var motherName = new Array();
patIdArr = new Array();
episodeIdArr = new Array();
patient_class = new Array();
patCount=0;
var scrollValue=0;
function clearLayer()
{
	hidePopUp();
}
function showMotherLinks(episodeid,obj)
{
	var tabdata = "<html><head></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><table cellpadding=0 cellspacing=0 border=1 bordercolor=BLACK><tr><th><font size=1><b>Babies of "+motherName[episodeid]+"</b></font></th></tr><tr><td><table cellpadding=0 cellspacing=0 border=1><tr><td class=SENPAT nowrap>Patient ID</td><td class=SENPAT nowrap>Name</td><td class=SENPAT nowrap>Sex</td><td class=SENPAT nowrap>Date of Birth</td><td class=SENPAT nowrap>Time</td><td class=SENPAT nowrap>Weight</td><td class=SENPAT nowrap>Length</td><td class=SENPAT nowrap>Circumference</td><td class=SENPAT nowrap>Apgar Score</td></tr>";
	if(babyDetails[episodeid] != '')
	{
		tabdata +=babyDetails[episodeid]+"</td></tr></table></table></body></html>";
		document.getElementById("motherLink").innerHTML = tabdata;
		document.getElementById("motherLink").style.top  = obj.offsetTop+"px";
		document.getElementById("motherLink").style.left  = obj.offsetLeft+50+"px" ;
		document.getElementById("motherLink").style.visibility='visible' ;
	}
	else
	{
		hidePopUp();
	}
}
function hidePopUp()
{
	//console.log(parent.frames[0].document.getElementById("motherLink"));
	parent.frames[0].document.getElementById("motherLink").style.visibility='hidden' ;
}
function patClick(ind)
{
	
	//alert(episodeIdArr[ind]);
	//refreshArray(); //CAMenu.js
	
	document.PatCriteriaFrm.patient_class.value = patient_class[ind];
	document.PatCriteriaFrm.encounter_id.value = episodeIdArr[ind] ;
	document.PatCriteriaFrm.patient_id.value= patIdArr[ind];
	//document.PatCriteriaFrm.submit();//32902

	//Start.32902
	var restPatientYN=document.getElementById("restPatientYN"+ind).value; 
	var accessRightsViewPatient=document.getElementById("accessRightsViewPatient").value; 
	if(patIdArr[ind] !=="" && restPatientYN =="Y" && accessRightsViewPatient==0)
	{
	  	restrictOpenVIPPat(patIdArr[ind],restPatientYN,accessRightsViewPatient);
	}
	else
	{
	document.PatCriteriaFrm.submit();
	}
	//end. 32902
}
var reOrder='';
var anchorID='';
function callForOrderBy(obj)
{	
	var relnReqyn=document.forms[0].reln_req_yn.value;
	var url='&reln_req_yn='+relnReqyn+'&orderBy='+obj+'&reOrder='+reOrder+'&anchorID='+anchorID+'&leftScrolling='+scrollValue;
	parent.frames[0].location.href='RecentPatListDetails.jsp?'+url;
}
function changeColor(object)
{
	anchorID=object.id;
	//scrollLeft=document.body.scrollLeft;
	
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
		document.anchors[i].style.color='white';

	}
	object.style.color='pink';
}
function moveFrame(){
	var temp=document.body.scrollLeft;
	scrollValue=temp;
}

