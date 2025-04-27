
//This file is saved on 18/10/2005
var	function_id		= "" ;
var	result			= false;
var	flag			= "" ;
var	message			= "" ;

//Function to create a value in insert mode...
function create()
{
	f_query_add_mod.location.href="../../eCP/jsp/AssessmentBasedTerminologyCodeFrameSet.jsp"
   
}


//function to check whether on apply,the flow can be proceeded...
function checkIsValidForProceed()
{
		var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		{ 
			return true;
		}
		else
				return false;
	
}

function chkApply(){
	//alert("if checkapply");
	var url=f_query_add_mod.f_query_detail.location.href;
	url=url.toLowerCase();
	if((url.indexOf("AssessmentBasedTerminologyCodeDetail.jsp")) !=-1)
		return true;
	else 
	return false;


}
//function to submit the form.......
//Changes made by SANDHYA------17/11/08
function apply()
{
	
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	var flag=0;
	if(!checkIsValidForProceed())
		{
		var message=getMessage("APPLY_NOT_VALID","CP");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false;
		}
	var frmobj=f_query_add_mod.f_query_header.document.formAssessmentBasedTerminologyCode;
		var fields = new Array (frmobj.assessmentCategory,frmobj.terminologySet,frmobj.type,frmobj.classificationLevel);
		var names = new Array (getLabel("eCP.AssessmentCategory.label","CP"),getLabel("Common.TerminologySet.label","Common"),getLabel("Common.type.label","Common"),getLabel("eCP.ClassificationLevel.label","CP"))
		if(f_query_add_mod.f_query_header.checkFieldsofMst( fields, names, messageFrame))
		parent.frames[2].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		var formobj=f_query_add_mod.f_query_detail.document.assessmentBasedTerminologycodeDetailForm;
		if(f_query_add_mod.f_query_detail.document.assessmentBasedTerminologycodeDetailForm)
		formobj.submit();
		return false ;	
				
 }
//************************************************
function reset(){
	var url=f_query_add_mod.location.href;
	if(url.indexOf("blank")==-1) {
		f_query_add_mod.location.href="../../eCP/jsp/AssessmentBasedTerminologyCodeFrameSet.jsp";		
		}

}

function onSuccess()
{
	create();
}

async function viewAssessmentCategory(target)
{
	var frmobj=document.formAssessmentBasedTerminologyCode;
	frmobj.assessmentCategory.value="";
	 var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	dataNameArray[0] = "locale";
	dataValueArray[0]= frmobj.locale.value;
	dataTypeArray[0] = STRING;

 	argumentArray[0] ="SELECT ASSESS_CATG_CODE CODE, LONG_DESC DESCRIPTION FROM CP_ASSESS_CATG_lang_vw WHERE EFF_STATUS='E' and language_id like ? AND UPPER(ASSESS_CATG_CODE) LIKE UPPER(?) AND UPPER(LONG_DESC) LIKE UPPER(?) ORDER BY LONG_DESC";
	
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,3"; 
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_DESC_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal =await CommonLookup(getLabel("eCP.AssessmentCategory.label","CP"), argumentArray );
		if(retVal != null && retVal != "") {
			var ret1=unescape(retVal);
			 var arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
					arr[0]="";	
					arr[1]="";	
				}
			target.value = arr[1] ;
			document.forms[0].assessmentCategoryCode.value = arr[0];
			
		}else
			target.value ="";
}

function getLevels(obj){
	var termSetid=obj.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCP/jsp/AssessmentBasedTerminologyCodeDynamicValues.jsp?termSetid="+termSetid+"&validate=LEVEL", false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function assignLevels(values)
{
		var levels=values.split("||");
		var frmobj=document.formAssessmentBasedTerminologyCode;
		var obj = eval(frmobj.type);
		var obj1 = eval(frmobj.classificationLevel);
		var flag=0;

		clearData(obj);
		clearData(obj1);

		if(levels[1]=='Y'){
		var opt	= eval(document.createElement('OPTION'));
		opt.value =	trimString("DX");
		opt.text =getLabel("Common.diagnosis.label","Common");
		obj.add(opt);
		flag=1;
		}
		if(levels[2]=='Y'){
		var opt	= eval(document.createElement('OPTION'));
		opt.value =	trimString("PR");
		opt.text =getLabel("Common.Procedure.label","Common");
		obj.add(opt);
		flag=1;
		}
		if(flag==0){
			var opt	= eval(document.createElement('OPTION'));
			opt.value =	trimString("");
			opt.text ="--"+getLabel("Common.defaultSelect.label","Common")+"--";
			obj.add(opt);
		}
		

		for(var i=1;i<=parseInt(levels[3]);i++)
		{
			var opt	= eval(document.createElement('OPTION'));
			opt.value =i;
			opt.text =levels[i+3];
			obj1.add(opt);
			
		}
}

function clearData(obj) {
	obj = eval(obj);
	var len = obj.length;
	for (var i=0; i<=len; i++) {
		obj.remove("");
	}
}

function searchDetails()
{
	var frmobj=parent.f_query_header.document.formAssessmentBasedTerminologyCode;
	var fields = new Array (frmobj.assessmentCategory,
										frmobj.terminologySet,
										frmobj.classificationLevel
									   );
	var names=new Array(getLabel("eCP.AssessmentCategory.label","CP"),
									 getLabel("Common.TerminologySet.label","Common"),
									 getLabel("eCP.ClassificationLevel.label","CP")
									);
	var msgFrame=parent.parent.messageFrame;

		if(parent.f_query_header.checkFieldsofMst( fields, names,msgFrame))
		{
		parent.f_query_hyperlink.location.href='../../eCP/jsp/AssessmentBasedTerminologyCodeHyperLinks.jsp?assessmentCategoryCode='+frmobj.assessmentCategoryCode.value+'&terminologySetId='+frmobj.terminologySet.value+'&classificationLevel='+frmobj.classificationLevel.value+'&type='+frmobj.type.value;
		parent.f_query_detail.location.href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=Associated &assessmentCategoryCode='+frmobj.assessmentCategoryCode.value+'&terminologySetId='+frmobj.terminologySet.value+'&type='+frmobj.type.value+'&firstTime=Y&classificationLevel='+frmobj.classificationLevel.value;
		frmobj.assessementCategoryButton.disabled=true;
		frmobj.search_button.disabled=true;
		frmobj.assessmentCategory.disabled=true;
		frmobj.terminologySet.disabled=true;
		frmobj.type.disabled=true;
		frmobj.classificationLevel.disabled=true;
		}
 }

 function submitPrevNext(from, to){
	 var frmobj=document.assessmentBasedTerminologycodeDetailForm;
	    frmobj.from.value = from;
	    frmobj.to.value = to; 
		parent.f_query_detail.location.href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink='+frmobj.alphaLink.value+'&assessmentCategoryCode='+frmobj.assessmentCategoryCode.value+'&terminologySetId='+frmobj.terminologySetId.value+'&type='+frmobj.type.value+'&from='+from+'&to='+to+'&classificationLevel='+frmobj.classificationLevel.value;
		
	}

function updateValue(obj){
	var frmobj=document.assessmentBasedTerminologycodeDetailForm;
	var alphaLink=frmobj.alphaLink.value;
	var code=obj.value;
	var flag=0;
	if(obj.checked==true)
		flag=1;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCP/jsp/AssessmentBasedTerminologyCodeDynamicValues.jsp?code="+code+"&flag="+flag+"&alphaLink="+alphaLink+"&validate=TERMINOLOGYCODE", false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText);
}

function selectAll(obj)
{
	 var frmobj=document.assessmentBasedTerminologycodeDetailForm;
	 var frmobj1=parent.f_query_header.document.formAssessmentBasedTerminologyCode;
	 var name=obj.name;
	  var obj1=eval("frmobj1."+name);
	 	 flag=0;
	 if(obj.checked==true){
		 flag=1;
		 obj1.value="Y"
	 }else{
		 obj1.value="";

	 }
	 
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCP/jsp/AssessmentBasedTerminologyCodeDynamicValues.jsp?alphalink="+frmobj.alphaLink.value+"&classificationLevel="+frmobj.classificationLevel.value+"&assessmentCategoryCode="+frmobj.assessmentCategoryCode.value+"&terminologySetId="+frmobj.terminologySetId.value+"&type="+frmobj.type.value+"&flag="+flag+"&validate=SELECTALL", false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
	checkAll(flag);

}

function checkselectAll(){
	 var frmobj=document.assessmentBasedTerminologycodeDetailForm;
	 var frmobj1=parent.f_query_header.document.formAssessmentBasedTerminologyCode;
	
	 var alphalink=frmobj.alphaLink.value;
	 obj=eval("frmobj."+alphalink+"chkAll");
	 obj1=eval("frmobj1."+alphalink+"chkAll");
	 	 if(obj1.value=='Y')
		 obj.checked=true;

}

function checkAll(flag)
{
	var frmobj=document.assessmentBasedTerminologycodeDetailForm;
	var alphalink=frmobj.alphaLink.value;
	var start				=		parseInt(frmobj.start.value)+1;
	var end					=		parseInt(frmobj.end.value)+1;
	var maxrecords		=		parseInt(frmobj.maxRecords.value)+1;
	if(end>maxrecords)
		end=maxrecords;
	for(var index=start;index<end;index++){
		obj=eval("frmobj."+alphalink+"chk"+index);
		if(flag==1)
			obj.checked=true;
		else
			obj.checked=false;

	}

}

function setchkAll(obj)
{
	var formobj	=		document.assessmentBasedTerminologycodeDetailForm;
	 var frmobj1=parent.f_query_header.document.formAssessmentBasedTerminologyCode;
	 var alphalink=formobj.alphaLink.value;
	var obj1=eval("formobj."+alphalink+"chkAll");
	var obj2=eval("frmobj1."+alphalink+"chkAll");
	 	if(obj.checked==false && obj2.value=="Y")
	{
		obj2.value="";
		obj1.checked=false;
	}
	
}
