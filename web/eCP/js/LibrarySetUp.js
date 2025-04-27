//This file is saved on 18/10/2005

var	function_id		=	"" ;
var	result				=	false;
var	flag					=	"" ;
var	message			=	"" ;
var	ageGroupFinal	=	"";
var   paramValues		=	"";

//Function to query the database
function query()
{
	  f_query_add_mod.location.href="../../eCP/jsp/LibrarySetUpQueryCriteria.jsp";
}

//Function to create a value in insert mode...
function create()
{
    f_query_add_mod.location.href="../../eCP/jsp/LibrarySetUpFrameSet.jsp?mode=1";
}

//Function to change the tab color 
function changeButtonColor(obj,from_name)
{
       if(from_name=="CP_BUTTONS")
       {
		cellref = document.LibraryDetailTabsForm.querySelector("#tabsTable").rows[1].cells
		}
		for(i=0; i<cellref.length; i++)
        {
			if(cellref[i].id!="dummy")
				cellref[i].className = 'CAFIRSTSELECTHORZ';
		}

		obj.className = "CASECONDSELECTHORZ"
		currClass ="CASECONDSELECTHORZ";
}

//Function to display the corresponding tables
function Display(obj)
{
	var formobj=parent.parent.f_query_add_mod.LibrarySetup_Header.document.getElementById("LibraryHeaderForm");
	var data=formobj.finalString.value;
	var mode=formobj.mode.value;

   	if(obj=='VersionDetails'){
		parent.LibrarySetup_Detail.location.href	="../../eCP/jsp/LibrarySetUpVersionDetail.jsp?finalString="+data;
	}else if(obj=='PatientClass'){
			parent.LibrarySetup_Detail.location.href	="../../eCP/jsp/LibrarySetUpPatientClassDetail.jsp";
	}else if(obj=='AgeGroup'){
			parent.LibrarySetupDynamicvalues.location.href="../../eCP/jsp/LibrarySetUpAgeGroupDynamicValues.jsp"
			parent.LibrarySetup_Detail.location.href	="../../eCP/jsp/LibrarySetUpAgeGroupDetail.jsp?fromSearch=true&mode="+mode;		
	}
}

//  Function to enable and disable the header field based on eff_status
function allowUpdate(obj){
	formobj=parent.parent.f_query_add_mod.LibrarySetup_Header.document.getElementById("LibraryHeaderForm");
	formobj.long_desc.value=formobj.long_desc_chk.value;
	formobj.short_desc.value=formobj.short_desc_chk.value;
	var value=formobj.finalString.value;

	if(obj.checked==true){
		formobj.eff_status_yn.value			=	'E';
		formobj.short_desc_chk.disabled	=	false;	
		formobj.long_desc_chk.disabled		=	false;	
		parent.parent.f_query_add_mod.LibrarySetup_DetailHeader.location.href	=	"../../eCP/jsp/LibrarySetUpDetailHeadings.jsp";
		parent.parent.f_query_add_mod.LibrarySetup_Detail.location.href				=	"../../eCP/jsp/LibrarySetUpVersionDetail.jsp?finalString="+value;
	}
	else{
		formobj.eff_status_yn.value			=	'D';
		formobj.short_desc_chk.disabled	=	true;	
		formobj.long_desc_chk.disabled		=	true;
		unload();
	}

}

// Function to check whether on apply,the flow can be proceeded...
function checkIsValidForProceed()
{
		var url	 =	 f_query_add_mod.location.href;
		url			 =	 url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}

// Function to submit the form.......
function apply()
{
	var flag	 =	0;
	if (! checkIsValidForProceed() ) 
	{
		message  = getMessage("APPLY_NOT_VALID","CP");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	formObj=f_query_add_mod.LibrarySetup_Header.document.getElementById("LibraryHeaderForm");
	formObj.long_desc.value=formObj.long_desc_chk.value;
	formObj.short_desc.value=formObj.short_desc_chk.value;

	if(formObj.eff_status.checked==true)
		formObj.eff_status_yn.value="E";
	else
		formObj.eff_status_yn.value="D";
	
	if(formObj.mode.value==2){
			 paramValues="&library_id="+formObj.libraryid.value+"&version_no="+formObj.version_no.value+	"&eff_status="+formObj.eff_status_yn.value;
	}

	for(var i=1;i<6;i++){
		var obj=eval("formObj.patientchk_"+i);
		if(obj.value !=""){
			flag=1;
		}
	}

	var fields = new Array ( formObj.library_id,
											formObj.short_desc,
											formObj.long_desc,
											formObj.version_remarks,
											formObj.libraryBasis																			
						);
	var names=new Array(getLabel("Common.code.label","common"),getLabel("Common.shortdescription.label","common"),getLabel("Common.longdescription.label","common"),getLabel("eCP.VersionRemarks.label","CP"),getLabel("eCP.LibraryBasis.label","CP"));

	var disp_type		=		"M";
	var specfield		=		new Array(formObj.library_id);
	var specname	=		new Array(getLabel("Common.code.label","common"));
	var error_jsp		=		"../../eCommon/jsp/MstCodeError.jsp";
	if(f_query_add_mod.LibrarySetup_Header.SpecialCharCheck( specfield, specname, messageFrame,disp_type,error_jsp)){
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){
			if(formObj.dependency_level.value=='0'){
				message  =getMessage("DEPENDENCY_LEVEL_CANNOT_ZERO","CP");
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				return false ;
			}
			else{			
				if(formObj.libraryBasis.value=='0'){
					message  =getMessage("LIBRARY_BASIS_CANNOT_ZERO","CP");
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					return false ;
				}else{
					if(flag!=1){
						message  =getMessage("ATLEAST_ONE_PATIENT_CLASS","CP");
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
						return false ;
					}else{
						//alert("inside submit");
						formObj.submit();
						if(formObj.mode.value==1)
							document.getElementById("f_query_add_mod").src="../../eCP/jsp/LibrarySetUpFrameSet.jsp?mode=1";
					}
				}
			}
		}
	}
}

// Function to update the object in the header form
function updateObj(Obj)
{
		
	formObj	=		parent.parent.f_query_add_mod.LibrarySetup_Header.document.getElementById("LibraryHeaderForm");
	var name	=		Obj.name;
	var Obj1	=		eval("formObj."+name);
		
	if(Obj.type=='checkbox'){
		if(Obj.checked==true){
				Obj1.value=Obj.value;			
		}else{
				Obj1.value="";		
		}	
	}else{
	
		Obj1.value=Obj.value;
	}
}

// Function to default values of the corresponding screen
function defaultValues(formname)
{
		if(formname=='LibraryVersionDetailForm'){
				defaultVersionDetails();
		}
		else if(formname=='LibraryPatientClassForm')	{
				defaultPatientClassDetails();
		}
		else if(formname='LibraryAgeGroupForm'){
			defaultAgeGroupDetails();
		}

}

// Function to Default the values of the Age Group screen
function defaultAgeGroupDetails()
{
	var formobj1			=		parent.parent.f_query_add_mod.LibrarySetup_Detail.document.getElementById("LibraryAgeGroupForm");
	var formobj2			=		parent.parent.f_query_add_mod.LibrarySetup_Header.document.getElementById("LibraryHeaderForm");
	var start				=		parseInt(formobj1.start.value)+1;
	var end					=		parseInt(formobj1.end.value)+1;
	var maxrecords		=		parseInt(formobj1.maxRecords.value)+1;
	if(end>maxrecords)
		end=maxrecords;

	for(var index=start;index<end;index++){
		var obj	 =	eval("formobj2.AgeGrpChk"+index);
		var obj1	 =	eval("formobj1.AgeGrpChk"+index);
		if(obj.value!="")
			obj1.checked=true;
	}
	
	var chkval			=		eval("formobj2.chkAll");
	var chkvalage	=		eval("formobj1.chkAll");
	if(chkval.value !="")
		chkvalage.checked=true;
}

// Function to default the values of  version details screen
function defaultVersionDetails()
{
	var formobj1		=		parent.parent.f_query_add_mod.LibrarySetup_Detail.document.getElementById("LibraryVersionDetailForm");
	var formobj2		=		parent.parent.f_query_add_mod.LibrarySetup_Header.document.getElementById("LibraryHeaderForm");
		//alert("form2  Status  "+formobj2.Status.value);
	formobj1.version_remarks.value		=		formobj2.version_remarks.value;
	formobj1.Status.value				=		formobj2.Status.value;
	if(formobj2.Status.value=='F')
		formobj1.Status.disabled=true;
	formobj1.dependency_level.value		=		formobj2.dependency_level.value;
	formobj1.libraryBasis.value			=		formobj2.libraryBasis.value;
	
}

// Function to default the values of Patient class screen
function defaultPatientClassDetails()
{
	var formobj1		=		parent.parent.f_query_add_mod.LibrarySetup_Detail.document.getElementById("LibraryPatientClassForm");
	var formobj2		=		parent.parent.f_query_add_mod.LibrarySetup_Header.document.getElementById("LibraryHeaderForm");

	if(formobj2.patientchk_1.value !="")
		formobj1.patientchk_1.checked=true;
	if(formobj2.patientchk_2.value !="")
		formobj1.patientchk_2.checked=true;
	if(formobj2.patientchk_3.value !="")
		formobj1.patientchk_3.checked=true;
	if(formobj2.patientchk_4.value !="")
		formobj1.patientchk_4.checked=true;
	if(formobj2.patientchk_5.value !="")
		formobj1.patientchk_5.checked=true;
}

// Function to unload the screen when enable chk is disabled
function unload()
{
	parent.parent.f_query_add_mod.LibrarySetup_DetailHeader.location.href	=	"../../eCommon/html/blank.html";
	parent.parent.f_query_add_mod.LibrarySetup_Detail.location.href				=	"../../eCommon/html/blank.html";

}

//Function to disable the headerform when enable is disabled
function disableAll()
{
	formobj											=		parent.parent.f_query_add_mod.LibrarySetup_Detail.document.getElementById("LibraryVersionDetailForm");
	formobj.version_remarks.disabled	=		true;
	formobj.Status.disabled					=		true;
	formobj.dependency_level.disabled	=		true;
	formobj.libraryBasis.disabled			=		true;
}

//Function to display the msg in the message frame after apply operation
function onSuccess()
{
	formObj		=		f_query_add_mod.LibrarySetup_Header.document.getElementById("LibraryHeaderForm");
	var status		=		formObj.eff_status_yn.value;
	var mode		=		formObj.mode.value;
	//alert("inside success");
//	alert(paramValues);
	 if(mode==2){
		 //alert(paramValues);
		f_query_add_mod.location.href='../../eCP/jsp/LibrarySetUpFrameSet.jsp?mode=2'+paramValues;
	 }
	else
   		reset();   
}

// Function to reset the values 
 function reset()
{
	var url	=	f_query_add_mod.location.href;
	url			=	url.toLowerCase();

	if(url.indexOf("librarysetupquerycriteria")!=-1)
		f_query_add_mod.document.query_form.reset();
	else if(url.indexOf("librarysetupframes")!=-1){
		formObj	 =		f_query_add_mod.LibrarySetup_Header.document.getElementById("LibraryHeaderForm");
		formObj2 =		f_query_add_mod.LibrarySetup_Detail.document;
		formObj1 =		f_query_add_mod.document;
		var mode		=		formObj.mode.value;
		if (mode==2){
		//	alert("inside if");
			formObj1.location.reload();
		}
		else{
		//	f_query_add_mod.location.href="../../eCP/jsp/LibrarySetUpFrameSet.jsp?mode=1";
			formObj.reset();
			formObj2.forms[0].reset();
		}
	}
}

// Function to load the page in updatemode
function loadpage()
{
	var formobj	=	parent.parent.f_query_add_mod.LibrarySetup_Header.document.getElementById("LibraryHeaderForm");
	var data		=	formobj.finalString.value;
	//alert(data);
	parent.LibrarySetup_Detail.location.href="../../eCP/jsp/LibrarySetUpVersionDetail.jsp?finalString="+data;
}

// Function to chk whether the length is exceed max length..
function CheckMaxLength(obj,max) {
	if(obj.value.length >= max){
		alert("Max limit is "+max+" Characters");
		return false;
	} else
	return true;
}

// Function to set all the values in the age group screen
function setAll()
{
	var formobj1		=		parent.parent.f_query_add_mod.LibrarySetup_Detail.document.getElementById("LibraryAgeGroupForm");
	var formobj2		=		parent.parent.f_query_add_mod.LibrarySetup_Header.document.getElementById("LibraryHeaderForm");

	var start			=		parseInt(formobj1.start.value)+1;
	var end				=		parseInt(formobj1.end.value)+1;
	var maxrecords	=		parseInt(formobj1.maxRecords.value)+1;

	if(end>maxrecords)
		end=maxrecords;
	
	for(var index=start;index<end;index++){
		var obj=eval("formobj2.AgeGrpChk"+index);
		var obj1=eval("formobj1.AgeGrpChk"+index);
		if(formobj2.chkAll.value=="Y")
		{
			obj.value=obj1.value;
		}
		else 
		{
			obj.value="";	
		}
	}
	setOthervalues(start,end);
}
function setOthervalues(start,end){
//	alert("S "+start);
//	alert("E "+end);
//	alert(formobj2.ege_grp_len.value);

	var formobj1		=	parent.parent.f_query_add_mod.LibrarySetup_Detail.document.getElementById("LibraryAgeGroupForm");
	var formobj2		=	parent.parent.f_query_add_mod.LibrarySetup_Header.document.getElementById("LibraryHeaderForm");
	var len				=	parseInt(formobj2.ege_grp_len.value);
	for( var i=1;i<=len;i++){
		var obj=eval("formobj2.BAgeGrpChk"+i);
		var obj1=eval("formobj2.AgeGrpChk"+i);
		if(formobj2.chkAll.value=="Y"){
			obj1.value=obj.value;
		}
		else{
			obj1.value="";
		}

		//alert(obj);
		//alert(obj.value);
	}
}
// Function to set the other values of the agegroup screen
/*function setOthervalues(start,end){

	var formobj1		=	parent.parent.f_query_add_mod.LibrarySetup_Detail.document.getElementById("LibraryAgeGroupForm");
	var formobj2		=	parent.parent.f_query_add_mod.LibrarySetup_Header.document.getElementById("LibraryHeaderForm");
	if(start==1 && end==8){
		if(formobj2.chkAll.value=="Y"){
			formobj2.AgeGrpChk8.value	=	"GT";
			formobj2.AgeGrpChk9.value	=	"IN";
			formobj2.AgeGrpChk10.value	=	"MA";
			formobj2.AgeGrpChk11.value	=	"MW";
			formobj2.AgeGrpChk12.value	=	"NB";
			formobj2.AgeGrpChk13.value	=	"NR";
			formobj2.AgeGrpChk14.value	=	"PD";
			formobj2.AgeGrpChk15.value	=	"S9";
			formobj2.AgeGrpChk16.value	=	"SM";
		}else{
			formobj2.AgeGrpChk8.value	=	"";
			formobj2.AgeGrpChk9.value	=	"";
			formobj2.AgeGrpChk10.value	=	"";
			formobj2.AgeGrpChk11.value	=	"";
			formobj2.AgeGrpChk12.value	=	"";
			formobj2.AgeGrpChk13.value	=	"";
			formobj2.AgeGrpChk14.value	=	"";
			formobj2.AgeGrpChk15.value	=	"";
			formobj2.AgeGrpChk16.value	=	"";
		}

	}else if(start==8 && end==15){
		if(formobj2.chkAll.value=="Y"){
			formobj2.AgeGrpChk1.value		=	"AD";
			formobj2.AgeGrpChk2.value		=	"FA";
			formobj2.AgeGrpChk3.value		=	"FG";
			formobj2.AgeGrpChk4.value		=	"FM";
			formobj2.AgeGrpChk5.value		=	"FW";
			formobj2.AgeGrpChk6.value		=	"GL";
			formobj2.AgeGrpChk7.value		=	"GN";
			formobj2.AgeGrpChk15.value	=	"S9";
			formobj2.AgeGrpChk16.value	=	"SM";
		}else{
			formobj2.AgeGrpChk1.value		=	"";
			formobj2.AgeGrpChk2.value		=	"";
			formobj2.AgeGrpChk3.value		=	"";
			formobj2.AgeGrpChk4.value		=	"";
			formobj2.AgeGrpChk5.value		=	"";
			formobj2.AgeGrpChk6.value		=	"";
			formobj2.AgeGrpChk7.value		=	"";
			formobj2.AgeGrpChk15.value	=	"";
			formobj2.AgeGrpChk16.value	=	"";
		}

	}else if(start==15 && end==17){
		if(formobj2.chkAll.value=="Y"){
			formobj2.AgeGrpChk1.value		=	"AD";
			formobj2.AgeGrpChk2.value		=	"FA";
			formobj2.AgeGrpChk3.value		=	"FG";
			formobj2.AgeGrpChk4.value		=	"FM";
			formobj2.AgeGrpChk5.value		=	"FW";
			formobj2.AgeGrpChk6.value		=	"GL";
			formobj2.AgeGrpChk7.value		=	"GN";
			formobj2.AgeGrpChk8.value		=	"GT";
			formobj2.AgeGrpChk9.value		=	"IN";
			formobj2.AgeGrpChk10.value		=	"MA";
			formobj2.AgeGrpChk11.value		=	"MW";
			formobj2.AgeGrpChk12.value		=	"NB";
			formobj2.AgeGrpChk13.value		=	"NR";
			formobj2.AgeGrpChk14.value		=	"PD";
		}else{
			formobj2.AgeGrpChk1.value		=	"";
			formobj2.AgeGrpChk2.value		=	"";
			formobj2.AgeGrpChk3.value		=	"";
			formobj2.AgeGrpChk4.value		=	"";
			formobj2.AgeGrpChk5.value		=	"";
			formobj2.AgeGrpChk6.value		=	"";
			formobj2.AgeGrpChk7.value		=	"";
			formobj2.AgeGrpChk8.value		=	"";
			formobj2.AgeGrpChk9.value		=	"";
			formobj2.AgeGrpChk10.value		=	"";
			formobj2.AgeGrpChk11.value		=	"";
			formobj2.AgeGrpChk12.value		=	"";
			formobj2.AgeGrpChk13.value		=	"";
			formobj2.AgeGrpChk14.value		=	"";
		}

	}

}*/

// Function to uncheck the chkall when any one is unchecked
function setchkAll(obj)
{
	var formobj	=		parent.parent.f_query_add_mod.LibrarySetup_Header.document.getElementById("LibraryHeaderForm");
	var formobj1	=		parent.parent.f_query_add_mod.LibrarySetup_Detail.document.getElementById("LibraryAgeGroupForm");
	var name		=		obj.name;
	if(obj.checked==false && formobj.chkAll.value=="Y"){
		formobj1.chkAll.checked	=	false;
		formobj.chkAll.value			=	"";
	}
	
}

function CheckMaxLength1(obj,len){
	if(!CheckMaxLength(obj,len)){
		obj.value="";
		obj.focus();
	}
		
}
