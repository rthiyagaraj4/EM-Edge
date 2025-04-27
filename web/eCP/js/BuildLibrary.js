										   //This file is saved on 18/10/2005


var goalcurr_obj ="parent.f_Goal_hyperlink.document.getElementById('associated_lbl')";
var goalprev_obj= "";
var outcomecurr_obj ="parent.f_Outcome_hyperlink.document.getElementById('associated_lbl')";
var outcomeprev_obj= "";
var interventioncurr_obj ="parent.f_Intervention_hyperlink.document.getElementById('associated_lbl')";
var interventionprev_obj= "";
//Function to create a value in insert mode...
function create()
{
	f_query_add_mod.location.href="../../eCP/jsp/BuildLibraryFrameSet.jsp"  
}


function reset()
{
	var url=f_query_add_mod.location.href;
	if(url.indexOf("blank")==-1) {
		if(url.indexOf("Query")==-1){
			f_query_add_mod.f_query_header.formBuiildLibraryHeader.reset();
			f_query_add_mod.f_query_header.formBuiildLibraryHeader.libraryLookupButton.disabled=false;
			f_query_add_mod.f_query_header.formBuiildLibraryHeader.preview.disabled=true;
			f_query_add_mod.f_query_headerdetails.location.href="../../eCommon/html/blank.html";
			f_query_add_mod.f_query_detail.location.href="../../eCommon/html/blank.html";
		}else if(parent.frames[1].frames[1].document.forms[0]!=null){
			//alert(parent.frames[1].frames[1].document.forms[0]);
			parent.frames[1].frames[1].document.forms[0].reset();
		}
	}


}

//function to check whether on apply,the flow can be proceeded...
function checkIsValidForProceed()
{
		var url =	f_query_add_mod.location.href;
		url		=	url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}

function apply()
{
	var formObj	=	parent.f_Detail_header.document.getElementById("formBuildLibraryShowDetails");
	formObj.submit();
	closelookupW();
}

async function Preview()
{
	var dialogHeight		=	 "400px" ;
	var dialogWidth			=	 "800px" ;
	var status				=	 "no";
	var center				=	 "1" ;
	var dialogFeatures		=	 "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; center: " + center + ";scroll=yes; status:" + status;
	var arguments			=	 "" ;
	var formobj				=	 parent.parent.f_query_add_mod.f_query_headerdetails.document.getElementById("formHeaderDetails");
	var retVal				=	 await window.showModalDialog("../../eCP/jsp/BuildLibrary_temp2.jsp?libraryid="+formobj.libraryid.value+"&versionno="+formobj.versionno.value,arguments,dialogFeatures);			
}


function onSuccess()
{
	//disableapply();
	create();
	//reset();
	
}


async function showLibrary(target)
{
	 
	var dialogHeight		=	 "500px" ;
    var dialogWidth			=	 "700px" ;
    var status				=	 "no";
	var center				=	 "1" ;
	var dialogFeatures		=	 "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; center: " + center + ";scroll=no; status:" + status;
	var arguments			=	 "" ;
	var retVal				=	await top.window.showModalDialog("../../eCP/jsp/LibraryLookup.jsp",arguments,dialogFeatures);
	if( retVal != undefined)
	{
		var formObj													=	parent.f_query_header.document.getElementById('formBuiildLibraryHeader');
		formObj.libraryLookupButton.disabled						=	true;
		var libraryid												=	retVal.split("||");
		parent.f_query_header.document.forms[0].LibraryDesc.value	=	libraryid[0];
		parent.f_query_headerdetails.location.href					=	"../../eCP/jsp/BuildLibraryHeaderDetails.jsp?library_id="+libraryid[0] +"&versionon="+libraryid[1];
		//	alert("retval "+retVal);

	}
}


async function showTermCodeLookup(libraryid,versionno)
{
	var dialogHeight		=	 "70vh" ;
    var dialogWidth			=	 "65vw" ;
    var status				=	 "no";
	var center				=	 "1" ;
	var dialogFeatures		=	 "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; center: " + center + ";scroll=no; status:" + status;
	var arguments			= "" ;
	var retVal				= await top.window.showModalDialog("../../eCP/jsp/TermCodeLookup.jsp?versionno="+versionno+"&libraryid="+libraryid,arguments,dialogFeatures);
	parent.f_query_detail.location.href="../../eCP/jsp/BuildLibraryTermCodeDetail.jsp?versionno="+versionno+"&libraryid="+libraryid;
}


function navigation(frmObj,link)
{
	var start		=	frmObj.start.value;
	var end			=	frmObj.end.value;
	var versionno	=	frmObj.versionno.value;
	var libraryid	=	frmObj.libraryid.value;
	var tableName	=	frmObj.tableName.value;
	if (link=="next")
	{
		start		=	parseInt(start)+12;
		end			=	parseInt(end)+12;
	}
	else if(link=="previous")
	{
		start		=	parseInt(start)-12;
		end			=	parseInt(end)-12;
	}
		
	parent.f_query_detail.location.href	=	"../../eCP/jsp/BuildLibraryTermCodeDetail.jsp?from="+start+"&to="+end+"&versionno="+versionno+"&libraryid="+libraryid+"&tableName="+tableName;
}


function updateValueTermCode(obj,value)
{
	var flag;
	if(obj.checked==true)
		flag	=	"Y";
	else
		flag	=	"N";

	var xmlDoc	=	"";// new ActiveXObject( "Microsoft.XMLDom" ) ;
	//var xmlHttp =	 new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr		=	 "<root><SEARCH " ;
	xmlStr     +=	 " /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCP/jsp/BuildlibraryDynamic.jsp?code="+obj.value+"&termSet="+value+"&validate=UPDATECODE&flag="+flag, false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
	
}


async function ShowGoalDialog(termSet,termCode,termDesc,libraryid,versionno,tableName)
{
	var dialogHeight		=	 "35vh" ;
    var dialogWidth			=	 "48vw" ;
    var status				=	 "no";
	var center				=	 "1" ;
	var dialogFeatures		=	 "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; center: " + center + ";scroll=no; status:" + status;
	var arguments			=	 "" ;
	var retVal				=	 await top.window.showModalDialog("../../eCP/jsp/BuildLibraryGoalFrameset.jsp?termSet="+termSet+"&termCode="+termCode+"&termDesc="+termDesc+"&libraryid="+libraryid+"&versionno="+versionno+"&tableName="+tableName,arguments,dialogFeatures);
}


function Goalnavigation(frmObj,link)
{
	var start		=	frmObj.start.value;
	var end			=	frmObj.end.value;
	var alphalink	=	frmObj.alphalink.value;
	var termSet		=	frmObj.termSet.value;
	var termCode	=	frmObj.termCode.value;
	var termDesc	=	frmObj.termDesc.value;
	var libraryid	=	frmObj.libraryid.value;
	var versionno	=	frmObj.versionno.value;
	var tableName	=	frmObj.tableName.value;

	if (link=="next")
	{
		start		=	parseInt(start)+10;
		end			=	parseInt(end)+10;
	}
	else if(link=="previous")
	{
		start		=	parseInt(start)-10;
		end			=	parseInt(end)-10;
	}
		
		parent.f_Goal_detail.location.href	=	"../../eCP/jsp/BuildLibraryGoalDetails.jsp?from="+start+"&to="+end+"&alphalink="+alphalink+"&termSet="+termSet+"&termCode="+termCode+"&termDesc="+termDesc+"&versionno="+versionno+"&libraryid="+libraryid+"&tableName="+tableName;
}


async function showInterventiondialog(libraryid,versionno,termSet,termCode,goalCode,tableName)
{
	var dialogHeight		=	 "50vh" ;
    var dialogWidth			=	 "73vw" ;
    var status				=	 "no";
	var center				=	 "1" ;
	var dialogFeatures		=	 "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; center: " + center + ";scroll=no; status:" + status;
	var arguments			=	 "" ;
	var retVal				=	 await window.showModalDialog("../../eCP/jsp/BuildLibraryInterventionsOutcomesFrameset.jsp?termSet="+termSet+"&termCode="+termCode+"&goalCode="+goalCode+"&libraryid="+libraryid+"&versionno="+versionno+"&tableName="+tableName,arguments,dialogFeatures);
}


function Interventionnavigation(frmObj,link)
{
	var start		=	frmObj.start.value;
	var end			=	frmObj.end.value;
	var alphalink	=	frmObj.alphalink.value;
	var termSet		=	frmObj.termSet.value;
	var termCode	=	frmObj.termCode.value;
	var goalCode	=	frmObj.goalCode.value;
	var libraryid	=	frmObj.libraryid.value;
	var versionno	=	frmObj.versionno.value;
	var GroupID		=	frmObj.GroupID.value;
	var maxGrpID	=	frmObj.maxGrpID.value;

	if (link=="next")
	{
		start		=	parseInt(start)+5;
		end			=	parseInt(end)+5;
	}
	else if(link=="previous")
	{
		start		=	parseInt(start)-5;
		end			=	parseInt(end)-5;
	}
		parent.f_Intervention_detail.location.href	=	"../../eCP/jsp/BuildLibraryInterventionDetail.jsp?from="+start+"&to="+end+"&alphalink="+alphalink+"&termSet="+termSet+"&termCode="+termCode+"&goalCode="+goalCode+"&versionno="+versionno+"&libraryid="+libraryid+"&=maxGrpID"+maxGrpID+"&GroupID="+GroupID;
}


function Outcomenavigation(frmObj,link)
{
	var start		=	frmObj.start.value;
	var end			=	frmObj.end.value;
	var alphalink	=	frmObj.alphalink.value;
	var termSet		=	frmObj.termSet.value;
	var termCode	=	frmObj.termCode.value;
	var goalCode	=	frmObj.goalCode.value;
	var libraryid	=	frmObj.libraryid.value;
	var versionno	=	frmObj.versionno.value;
	var tableName	=	frmObj.tableName.value;
	var maxGrpID	=	frmObj.maxGrpID.value;
	var GroupID		=	frmObj.GroupID.value;

	if (link=="next")
	{
		start		=	parseInt(start)+5;
		end			=	parseInt(end)+5;
	}
	else if(link=="previous")
	{
		start		=	parseInt(start)-5;
		end			=	parseInt(end)-5;
	}
		
	parent.f_Outcome_detail.location.href	=	"../../eCP/jsp/BuildLibraryOutcomeDetail.jsp?from="+start+"&to="+end+"&alphalink="+alphalink+"&termSet="+termSet+"&termCode="+termCode+"&goalCode="+goalCode+"&versionno="+versionno+"&libraryid="+libraryid+"&tableName="+tableName+"&maxGrpID="+maxGrpID+"&GroupID="+GroupID;
}


function updateGoalList(index)
{
	var formObj		=	parent.f_Goal_detail.document.getElementById("formBuildLibraryGoalDetails");
	var obj			=	eval("formObj.select"+index);
	var termSet		=	formObj.termSet.value;
	var termCode	=	formObj.termCode.value;
	var goalCode	=	obj.value;
	var flag		=	0;

	if(obj.checked==true)
		flag="Y";
	else
		flag="N";
			
	
	var goalDescobj				=	eval("formObj.goalDesc"+index);
	var goalDesc				=	goalDescobj.value;
	
	var targetPeriodobj			=	eval("formObj.targetPeriod"+index);
	var targetPeriod			=	targetPeriodobj.value;

	var targetPeriodTypeobj		=	eval("formObj.targetPeriodType"+index);
	var targetPeriodType		=	targetPeriodTypeobj.value;

	var practitionerTypeobj		=	eval("formObj.practitionerType"+index);
	var practitionerType		=	practitionerTypeobj.value;

	
	var xmlDoc		=	"";//new ActiveXObject( "Microsoft.XMLDom" ) ;
//	var xmlHttp		=	new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var xmlHttp		= new XMLHttpRequest();
	xmlStr			=	"<root><SEARCH " ;
	xmlStr		   +=	" /></root>" ;
 	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCP/jsp/BuildlibraryDynamic.jsp?termCode="+termCode+"&termSet="+termSet+"&flag="+flag+"&goalCode="+goalCode+"&targetPeriod="+targetPeriod+"&targetPeriodType="+targetPeriodType+"&goalDesc="+goalDesc+"&practitionerType="+practitionerType+"&validate=UPDATEGOAL", false);
	xmlHttp.send( xmlDoc ) ;
	responseText	=	xmlHttp.responseText ;
//	alert(responseText);
	eval(responseText);

}


function updateInterventionList(index,termSet,termCode,goalCode,maxGrpID)
{
	var formObj		=	parent.f_Intervention_detail.document.getElementById("formBuildLibraryInterventionDetails");
	var obj			=	eval("formObj.select"+index);
	var flag		=	0;
	var frequency;

	//alert("inside");

	if(obj.checked==true)
		flag="Y";
	else
		flag="N";

	//alert("formObj "+formObj.termSet.value);

	var termSet					=	termSet;
	var termCode				=	termCode;
	var goalCode				=	goalCode;
	var interventionCode		=	obj.value;

	var interventionDescobj		=	eval("formObj.interventionDesc"+index);
	var interventionDesc		=	interventionDescobj.value;
	
	var altObj					=	eval("formObj.Alt"+index);
	var Alt						=	altObj.value;

	var relativeStartObj		=	eval("formObj.relativeStart"+index);
	var relativeStart			=	relativeStartObj.value;

	var relativeStartTypeObj	=	eval("formObj.relativeStartType"+index);
	var relativeStartType		=	relativeStartTypeObj.value;
	                                    
	var frequencyObj			=	eval("formObj.frequency"+index);
	frequencylist				=	frequencyObj.value;
	freq_arr					=	frequencylist.split(",")
	frequency					=	freq_arr[1];
	
	//alert("frequency "+frequency);
	var DurationObj				=	eval("formObj.Duration"+index);
	var Duration				=	DurationObj.value;

	var DurationTypeObj			=	eval("formObj.DurationType"+index);
	var DurationType			=	DurationTypeObj.value;

	var DependencyObj			=	eval("formObj.Dependency"+index);
	var Dependency				=	DependencyObj.value;

	var stageObj				=	eval("formObj.stage"+index);
	var stage					=	stageObj.value;

	var GroupNo=maxGrpID;

	var xmlDoc					=	"";//	new ActiveXObject( "Microsoft.XMLDom" ) ;
	//var xmlHttp				=		new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var xmlHttp = new XMLHttpRequest();
	xmlStr				=		"<root><SEARCH " ;
	xmlStr			   +=		" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCP/jsp/BuildlibraryDynamic.jsp?termCode="+termCode+"&termSet="+termSet+"&flag="+flag+"&goalCode="+goalCode+"&interventionCode="+interventionCode+"&Alt="+Alt+"&relativeStart="+relativeStart+"&relativeStartType="+relativeStartType+"&frequency="+frequency+"&Duration="+Duration+"&DurationType="+DurationType+"&Dependency="+Dependency+"&stage="+stage+"&GroupNo="+GroupNo+"&interventionDesc="+interventionDesc+"&validate=UPDATEINTERVENTION", false);
	xmlHttp.send( xmlDoc ) ;
	responseText		=	xmlHttp.responseText ;
	eval(responseText);
}


function updateOutcomeList(index)
{
	var formObj		=	parent.f_Outcome_detail.document.getElementById("formBuildLibraryOutcomeDetails");
	var obj			=	eval("formObj.select"+index);
	var flag		=	0;

	if(obj.checked==true)
		flag="Y";
	else
		flag="N";

	var Nature	;
	var termSet				=	formObj.termSet.value;
	var termCode			=	formObj.termCode.value;
	var goalCode			=	formObj.goalCode.value;
	var outcomeCode			=	obj.value;

	var outcomeDescobj		=	eval("formObj.outcomeDesc"+index);
	var outcomeDesc			=	outcomeDescobj.value;

	
	var NatureObj			=	eval("formObj.Nature"+index);
	if(NatureObj !=undefined){
		Nature				=	NatureObj.value;
	}

	var targetPeriodObj		=	eval("formObj.targetPeriod"+index);
	var targetPeriod		=	targetPeriodObj.value;

	var targetPeriodTypeObj	=	eval("formObj.targetPeriodType"+index);
	var targetPeriodType	=	targetPeriodTypeObj.value;
	var GroupNo				=	formObj.maxGrpID.value;
	
	var xmlDoc				=	"";//new ActiveXObject( "Microsoft.XMLDom" ) ;
	//var xmlHttp			=	new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var xmlHttp 			= new XMLHttpRequest();
	xmlStr					=	"<root><SEARCH " ;
	xmlStr				   +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCP/jsp/BuildlibraryDynamic.jsp?termCode="+termCode+"&termSet="+termSet+"&flag="+flag+"&goalCode="+goalCode+"&outcomeCode="+outcomeCode+"&Nature="+Nature+"&targetPeriod="+targetPeriod+"&targetPeriodType="+targetPeriodType+"&GroupNo="+GroupNo+"&outcomeDesc="+outcomeDesc+"&validate=UPDATEOUTCOME", false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
}


function closeW()
{
	//parent.window.close();
	parent.document.getElementById("dialog_tag").close();
}


function ChkNewGrp(fromobj)
{
//	alert("fromobj " +fromobj);
//alert("inside chknewgrp function");
	var formObj		=	parent.f__InterventionOutcome_Group.document.getElementById("formLibraryInterventionOutcomeGroup");
	var formObj1=	parent.f_Outcome_hyperlink.document.getElementById("formLibraryOutcomeHyperlinks");	
	var termSet		=	formObj.termSet.value;
	var termCode	=	formObj.termCode.value;
	var goalCode	=	formObj.goalCode.value;
	var maxGrpID	=	formObj1.maxGrpID.value;
	var GroupID		=	formObj1.GroupID.value;
//	alert("maxGrpID "+maxGrpID);
//	alert("fromobj "+fromobj);
	var xmlDoc		=	"";//new ActiveXObject( "Microsoft.XMLDom" ) ;
	//var xmlHttp		=	new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr			=	"<root><SEARCH " ;
	xmlStr		   +=	" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCP/jsp/BuildlibraryDynamic.jsp?termCode="+termCode+"&termSet="+termSet+"&goalCode="+goalCode+"&maxGrpID="+maxGrpID+"&GroupID="+GroupID+"&validate=CHKGROUP&fromobj="+fromobj, false);
	xmlHttp.send( xmlDoc ) ;
	responseText	=	xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText);
}


function LoadPages(flag,GroupID)
{
	formObj			=	parent.f__InterventionOutcome_Group.document.getElementById("formLibraryInterventionOutcomeGroup");
	var firstTime;
	var libraryid	=	formObj.libraryid.value;
	var versionno	=	formObj.versionno.value;
	var termSet		=	formObj.termSet.value;
	var termCode	=	formObj.termCode.value;
	var goalCode	=	formObj.goalCode.value;
	var tableName	=	formObj.tableName.value;
	var maxGrpID	=	formObj.maxGrpID.value;
	var alphalink	=	formObj.alphalink.value;
//	alert("maxGrpID in load "+maxGrpID);
//	alert("GroupID in load"+GroupID);
	
	if(flag==1){
		firstTime="N";
	}else{
		firstTime="Y";
	}

	parent.f_Intervention_hyperlink.location.href	=	"../../eCP/jsp/BuildLibraryInterventionHyperlinks.jsp?termSet="+termSet+"&termCode="+termCode+"&goalCode="+goalCode+"&libraryid="+libraryid+"&versionno="+versionno+"&tableName="+tableName+"&maxGrpID="+maxGrpID+"&firstTime="+firstTime+"&GroupID="+GroupID;
	parent.f_Intervention_detail.location.href		=	"../../eCP/jsp/BuildLibraryInterventionDetail.jsp?termSet="+termSet+"&termCode="+termCode+"&goalCode="+goalCode+"&libraryid="+libraryid+"&versionno="+versionno+"&tableName="+tableName+"&maxGrpID="+maxGrpID+"&alphalink="+alphalink+"&GroupID="+GroupID;
	parent.f_Outcome_hyperlink.location.href		=	"../../eCP/jsp/BuildLibraryOutcomeHyperlinks.jsp?termSet="+termSet+"&termCode="+termCode+"&goalCode="+goalCode+"&libraryid="+libraryid+"&versionno="+versionno+"&tableName="+tableName+"&maxGrpID="+maxGrpID+"&firstTime="+firstTime+"&GroupID="+GroupID;
	parent.f_Outcome_detail.location.href			=	"../../eCP/jsp/BuildLibraryOutcomeDetail.jsp?termSet="+termSet+"&termCode="+termCode+"&goalCode="+goalCode+"&libraryid="+libraryid+"&versionno="+versionno+"&tableName="+tableName+"&maxGrpID="+maxGrpID+"&alphalink="+alphalink+"&GroupID="+GroupID;
}


function creatNewGrp(flag,fromobj,interventionFlag,outcomeFlag)
{
	formObj			=		parent.f__InterventionOutcome_Group.document.getElementById("formLibraryInterventionOutcomeGroup");
	var libraryid	=		formObj.libraryid.value;
	var versionno	=		formObj.versionno.value;
	var termSet		=		formObj.termSet.value;
	var termCode	=		formObj.termCode.value;
	var goalCode	=		formObj.goalCode.value;
	var tableName	=		formObj.tableName.value;
	var alphalink	=		"Associated";
//	alert(fromobj);
	//alert("F "+flag);
//	alert("interventionFlag "+interventionFlag);
//	alert("outcomeFlag "+outcomeFlag);

	if(flag=='true')
	{
		if(fromobj=='new' || fromobj=='new1'){		
			parent.f__InterventionOutcome_Group.location.href="../../eCP/jsp/BuildLibraryInterventionOutcomeGroups.jsp?termSet="+termSet+"&termCode="+termCode+"&goalCode="+goalCode+"&libraryid="+libraryid+"&versionno="+versionno+"&tableName="+tableName+"&alphalink="+alphalink;
		}
		else{
				closeW();
		}
	}else if(fromobj=='new1'|| fromobj=='close'){

		message  = getMessage("ATLEAST_1_INT_1_OUTC","CP");
		alert(message);
		if(interventionFlag=='false' && outcomeFlag=='false' && fromobj!='new1' ){
			closeW();
		}else if(interventionFlag=='false' && outcomeFlag=='false' && fromobj=='new1'){
			parent.f__InterventionOutcome_Group.location.href="../../eCP/jsp/BuildLibraryInterventionOutcomeGroups.jsp?termSet="+termSet+"&termCode="+termCode+"&goalCode="+goalCode+"&libraryid="+libraryid+"&versionno="+versionno+"&tableName="+tableName+"&alphalink="+alphalink;
		}
		
	}
}


function closelookupW()
{
	//parent.window.close();
	parent.document.getElementById("dialog_tag").close();
}


function loadDetail(libraryid,versionno)
{

	parent.f_query_detail.location.href	=	"../../eCP/jsp/BuildLibraryTermCodeDetail.jsp?libraryid="+libraryid+"&versionno="+versionno;
	var formObj							=	parent.f_query_header.document.getElementById("formBuiildLibraryHeader");
	formObj.preview.disabled			=	false;
}


function LoadClose(flag)
{
	parent.f_Close_window.location.href	=	"../../eCP/jsp/BuildLibrary_temp3.jsp?flag="+flag;
}

function loadGoalDetail(obj,termSet,termCode,termDesc,libraryid,versionno,tableName,alphalink)
	{
	
		goalprev_obj	=	eval(goalcurr_obj);
		goalcurr_obj	=	document.getElementById(obj.id);
		new_obj		=	eval(goalcurr_obj);
		old_obj		=	eval(goalprev_obj);

		new_obj.innerHTML	=	"<u><font color='maroon'>"+new_obj.innerText+"</font></u>";
		old_obj.innerHTML	=	"<td><u>"+old_obj.innerText+"</u></td>";

		parent.f_Goal_detail.location.href="../../eCP/jsp/BuildLibraryGoalDetails.jsp?alphalink="+alphalink+"&termSet="+termSet+"&termCode="+termCode+"&termDesc="+termDesc+"&libraryid="+libraryid+"&versionno="+versionno+"&tableName="+tableName;
	
	}

	function loadOutcomeDetail(obj,termSet,termCode,goalCode,libraryid,versionno,tableName,maxGrpID,GroupID,alphalink)
	{
		
		outcomeprev_obj	=	eval(outcomecurr_obj);
		outcomecurr_obj	=	document.getElementById(obj.id);
		new_obj		=	eval(outcomecurr_obj);
		old_obj		=	eval(outcomeprev_obj);
		
		new_obj.innerHTML	=	"<u><font color='maroon'>"+new_obj.innerText+"</font></u>";
		old_obj.innerHTML	=	"<td><u>"+old_obj.innerText+"</u></td>";
		
		parent.f_Outcome_detail.location.href="../../eCP/jsp/BuildLibraryOutcomeDetail.jsp?alphalink="+alphalink+"&termSet="+termSet+"&termCode="+termCode+"&goalCode="+goalCode+"&libraryid="+libraryid+"&versionno="+versionno+"&tableName="+tableName+"&maxGrpID="+maxGrpID+"&GroupID="+GroupID;
	
	}
	function loadInterventionDetail(obj,termSet,termCode,goalCode,libraryid,versionno,maxGrpID,GroupID,alphalink)
	{
		
		interventionprev_obj	=	eval(interventioncurr_obj);
		interventioncurr_obj	=	document.getElementById(obj.id);
		new_obj		=	eval(interventioncurr_obj);
		old_obj		=	eval(interventionprev_obj);

		new_obj.innerHTML	=	"<u><font color='maroon'>"+new_obj.innerText+"</font></u>";
		old_obj.innerHTML	=	"<td><u>"+old_obj.innerText+"</u></td>";

		parent.f_Intervention_detail.location.href="../../eCP/jsp/BuildLibraryInterventionDetail.jsp?alphalink="+alphalink+"&termSet="+termSet+"&termCode="+termCode+"&goalCode="+goalCode+"&libraryid="+libraryid+"&versionno="+versionno+"&maxGrpID="+maxGrpID+"&GroupID="+GroupID;
	
	}

function query()
{
	  f_query_add_mod.location.href="../../eCP/jsp/BuildLibraryQueryCriteria.jsp";
}

async function showQueryDetails(library_id,short_desc,versionno){
	//alert();
	var dialogHeight		=	 "70vh" ;
    var dialogWidth			=	 "60vw" ;
    var status				=	 "no";
	var center				=	 "1" ;
	var dialogFeatures		=	 "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; center: " + center + ";scroll=yes; status:" + status;
	var arguments			=	 "" ;
	var retVal				=	 await window.showModalDialog("../../eCP/jsp/BuildLibraryQueryResultDetail.jsp?library_id="+library_id+"&short_desc="+short_desc+"&versionno="+versionno,arguments,dialogFeatures);
}

function loadDurntypes(obj,index){
	var tmp_value=obj.value;
	var freq_arr = tmp_value.split(",")
	var freq_code = freq_arr[0];
	var freq_durn_value =freq_arr[1];
	var freq_durn_unit=freq_arr[2];

	var formObj		=	parent.f_Intervention_detail.document.getElementById("formBuildLibraryInterventionDetails");
	var obj1=eval("formObj.DurationType"+index);
	clearData(obj1);

	switch(freq_durn_unit){
			case 'M':
				var opt = document.createElement("OPTION");
				opt.text = getLabel("Common.Minutes.label","Common") ;
				opt.value = "M";
				eval("formObj.DurationType"+index).add(opt);
			case 'H':
				var opt = document.createElement("OPTION");
				opt.text = getLabel("Common.Hour(s).label","Common");
				opt.value = "H";
				eval("formObj.DurationType"+index).add(opt);
			case 'D':
				var opt = document.createElement("OPTION");
				opt.text = getLabel("Common.days.label","CP");
				opt.value = "D";
				eval("formObj.DurationType"+index).add(opt);
			case 'W':
				var opt = document.createElement("OPTION");
				opt.text = getLabel("eCP.Weeks.label","CP");
				opt.value = "W";
				eval("formObj.DurationType"+index).add(opt);
			case 'L':
				var opt = document.createElement("OPTION");
				opt.text = getLabel("eCP.Months.label","CP");
				opt.value = "L";
				eval("formObj.DurationType"+index).add(opt);
				break;
			default:
				var opt = document.createElement("OPTION");
				opt.text = getLabel("Common.Minute(s).label","Common");
				opt.value = "M";
				eval("formObj.DurationType"+index).add(opt);
				var opt = document.createElement("OPTION");
				opt.text = getLabel("Common.Hour(s).label","Common");
				opt.value = "H";
				eval("formObj.DurationType"+index).add(opt);
				var opt = document.createElement("OPTION");
				opt.text = getLabel("Common.days.label","CP");
				opt.value = "D";
				eval("formObj.DurationType"+index).add(opt);
				var opt = document.createElement("OPTION");
				opt.text =getLabel("eCP.Weeks.label","CP");
				opt.value = "W";
				eval("formObj.DurationType"+index).add(opt);
				var opt = document.createElement("OPTION");
				opt.text =getLabel("eCP.Months.label","CP");
				opt.value = "L";
				eval("formObj.DurationType"+index).add(opt);
				break;
	}

}

function clearData(obj) {
	obj = eval(obj);
	var len = obj.length;
	for (var i=0; i<=len; i++) {
		obj.remove("");
	}
}

function disableapply(){
	var formobj1=commontoolbarFrame.document.forms[0];
	//var formobj1=parent.frames[1].frames[0];
	//alert(commontoolbarFrame.document.forms[0]);
	//alert(formobj1.name);
	var applyobj=formobj1.apply;
	//alert("B "+applyobj.disabled);
	applyobj.disabled=true;
	//alert("a "+applyobj.disabled);
	
}
