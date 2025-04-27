//saved on 26/10/2005
var result		= false ;
var message		= "" ;
var flag		= "" ;
var mode=0;
var check_age_flag="";
var genderArray=new Array();
var minageArray=new Array();
var maxageArray=new Array();
var ageunitArray=new Array();

var firstTime=true;
var pageNum=1;
var function_id = "PH_DOSAGE_LIMIT" ;

function create(){
	mode=1;
	ConsLimitsAddModifyQueryFrame.location.href="../../ePH/jsp/PHTPNConsLimitsAddModify.jsp?function_id=TPN Constituents Limit&mode="+mode ;
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
}

function query(){
	
	mode=3;
	ConsLimitsAddModifyQueryFrame.location.href="../../ePH/jsp/PHTPNConsLimitsQueryCriteria.jsp?function_id=TPN Constituents Limit&mode="+mode ;
	
}

function apply()
{		
	     
	    setvalues();
		obj=ConsLimitsAddModifyQueryFrame.SearchResultsFrame;
		reload=0;
		if (typeof(obj)=="object")
		{
			url=obj.location.href;
			if (url.indexOf("Action")!=-1)
			{
				
				var frmobj =obj.document.FormTPNCons;

				var errorPage	= "../../eCommon/jsp/MstCodeError.jsp" ;
				//do validations here
				var res=checkSTD(frmobj);
				//alert("res---->"+res)
				if (res)
				{
						res1=checkRange(frmobj);

						if (res1)
						{
						frmobj.infusion_line.value	=	ConsLimitsAddModifyQueryFrame.SearchCriteriaFrame.document.FormTPNConsLimit.infusion_line.value;

						eval(formApply(frmobj, PH_CONTROLLER) ) ;
						//alert(formApply(frmobj, PH_CONTROLLER) ) ;
							if (result){
								onSuccess(frmobj);
							}
						}
						else
						{
						reload=1;
						}
					
				}else{
						reload=1;				
				}
			
			}
			
		}
		else
		{
			reload=1;
		}
		if (reload==1)
		{
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
						return false;

		}
	 


}

function searchItem(obj){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

//var sql="SELECT LONG_NAME,TPN_REGIMEN_CODE FROM PH_TPN_REGIMEN WHERE UPPER(LONG_NAME) LIKE UPPER (?) AND UPPER(TPN_REGIMEN_CODE) LIKE UPPER (?) AND STANDARD_REGIMEN_YN = 'N' ORDER BY 1";
	var sql= "SELECT LONG_NAME code,TPN_REGIMEN_CODE description FROM PH_TPN_REGIMEN WHERE STANDARD_REGIMEN_YN='N' AND LONG_NAME like upper(?) AND upper(TPN_REGIMEN_CODE) like upper(?) ORDER BY 1";
//var sql= "SELECT LONG_NAME,TPN_REGIMEN_CODE FROM PH_TPN_REGIMEN WHERE STANDARD_REGIMEN_YN = 'N' ORDER BY 1";

	argumentArray[0]   = sql;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = document.FormTPNConsLimit.regimen_name.value;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ;
	
		var retVal = CommonLookup(getLabel("ePH.RegimenCode.label","PH"), argumentArray );
		if(retVal != null && retVal != "" )  {
			document.FormTPNConsLimit.regimen_code.value= retVal[1];
			document.FormTPNConsLimit.regimen_name.value= retVal[0];
		}

	//alert(document.FormTPNConsLimit.regimen_name.value);
	//alert(document.FormTPNConsLimit.regimen_code.value);
}

function validateAgegroup(){
	
	var ageGroupcode			=	document.FormTPNConsLimit.age_group.value;
	var regimen_code			=	document.FormTPNConsLimit.Regimen_Code.value;
	var xmlStr ="";
	var bean_id = document.FormTPNConsLimit.bean_id.value;
	var bean_name = document.FormTPNConsLimit.bean_name.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//alert("validating");
	xmlHttp.open( "POST","PHTPNConsLimitsValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=agegroup" + "&ageGroupcode="+ageGroupcode + "&regimen_code="+regimen_code,false) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText) ;
}
function ageGroupOverlapp(overlappFlag){
	if(overlappFlag=="Y"){
		parent.SearchResultsFrame.document.location.href="../../eCommon/html/blank.html";
		alert(getMessage("PH_TPN_CONST_ALREADY_EXIST","PH"));
		return;
	}

}
function constituentLimitsMode(mode,overlappFlag,age_code){

	if(overlappFlag=="Y")
	{
		//alert("returning");
		return;
	}
	else{ 
         document.FormTPNConsLimit.age_group.disabled=true;
	     document.FormTPNConsLimit.Regimen_Code.disabled=true;
	var regimen_code=document.FormTPNConsLimit.Regimen_Code.value;
	//alert("call result page");
parent.SearchResultsFrame.document.location.href="../../ePH/jsp/PHTPNConsLimitsAction.jsp?age_code="+ageCode+"&regimen_code="+regimen_code+"&mode="+1;//+"&infusion_line="+infusion_line
	}

}

function showResult()
{
	ageCode			=	document.FormTPNConsLimit.age_group.value;
	infusion_line	=	document.FormTPNConsLimit.infusion_line.value;

	document.getElementById("gender").innerText=genderArray[ageCode];	
	document.getElementById("gender_val").value=genderArray[ageCode];
	//if(check_age_flag==0)
	//{ 
	  /*var Max_Age		=	document.FormTPNConsLimit.Max_Age.value;
	  var Min_Age		=	document.FormTPNConsLimit.Min_Age.value;
	  var age_unit_code	=	document.FormTPNConsLimit.age_unit_code.value;
	  var gender         =   document.getElementById("gender").innerText;
	  var gender_val		=	"";
	  
	  if(gender=="MALE")
	    {
          gender_val="M";
		}else if(gender=="FEMALE"){
           gender_val="F";
		}else{
            gender_val="U";
		}	
 	alert("gender_val"+gender_val);*/ parent.SearchResultsFrame.document.location.href="../../ePH/jsp/PHTPNConsLimitsAction.jsp?age_code="+ageCode+"&mode="+1+"&infusion_line="+infusion_line;
    //}

	
}

function checkSTD(frmobj)
{ 
	var res=true;	
	var firstblank;
	totalrows=frmobj.totalrows.value;
	
	for (i=1;i<=totalrows ;i++ )
	{ 
		generic=eval("frmobj.GCODE"+i).value;
		//alert(generic);
		min=eval("frmobj.MIN"+i).value;
		max=eval("frmobj.MAX"+i).value;
		stdobj=eval("frmobj.STD"+i);
		if(generic=="FLUID" || generic=="CHO")
		{
			if((min=="") || (max==""))
			{
				alert(getMessage("PH_MIN_MAX_VAL_CANT_BLNK","PH"));
				//alert("PH_MIN_MAX_VAL_CANT_BLNK");
			    eval("frmobj.MIN"+i).focus();
			   return false;
			}
		}
		stdobj.style.backgroundColor="white";
			if (min=="")
			{
				min=0;
			}
			if (max=="")
			{
				max=100;
			}
		
		if((min!=0)||(max!=100) )
		{
			var fields=new Array();
			fields[0]=stdobj;
			var names=new Array();
			names[0]="Standard";

			var errorPage	= "../../eCommon/jsp/MSTCodeError.jsp" ;
			blankObject  = getBlankField( fields, names, messageFrame, errorPage) ;
			if (blankObject!=null)
			{
				res=false;
				blankObject.style.backgroundColor="pink";
				if (typeof(firstblank)!="object")
				{
					firstblank=stdobj;
				}

			}
		
		}

	}
	
	if (!res)
	{	
		firstblank.focus();
		alert(getMessage("PH_STD_VAL_CANT_BLNK","PH"));
		//alert("PH_STD_VAL_CANT_BLNK");
	}
	return res;

}
function checkRange(frmobj)
{

	var res	=	true;	
	var min_val	=	true;
	var max_val	=	true;
	var firstblank;
	totalrows=frmobj.totalrows.value;
	var blankObject 	= null ;

	for (i=1;i<=totalrows ;i++ )
	{
		min=eval("frmobj.MIN"+i).value;
		max=eval("frmobj.MAX"+i).value;
		
		stdobj=eval("frmobj.STD"+i);
		minobj=eval("frmobj.MIN"+i);
		maxobj=eval("frmobj.MAX"+i);

		stdobj.style.backgroundColor="white";
		minobj.style.backgroundColor="white";

			if (min=="")
			{
				min=0;
			}
			if (max=="")
			{
				max=100;
			}
		
			if( parseFloat(min) > parseFloat(max) ){
						res=false;
						minobj.style.backgroundColor="pink";
						if (typeof(firstblank)!="object")
						{
									firstblank=minobj;
						}				
			} else if ( parseFloat(stdobj.value) > parseFloat(max)|| parseFloat(stdobj.value) < parseFloat(min)) {
							res=false;
							stdobj.style.backgroundColor="pink";
							if (typeof(firstblank)!="object")
							{
										firstblank=stdobj;
							}

								
			}
		
					
		}
		
	if (!res)
	{	
		firstblank.focus();
		if( (firstblank.name.substr(0,1))=="M") {
			alert(getMessage("PH_MIN_GREATER_MAX","PH"));
		} else {
			alert(getMessage("PH_STD_BTWN_MINMAX","PH"));
		}
		messageFrame.location.href="../../eCommon/jsp/MSTCodeError.jsp?err_num=";
		
	}
	return res;

}



function reset()
{
		obj=ConsLimitsAddModifyQueryFrame.SearchResultsFrame;
		url1=ConsLimitsAddModifyQueryFrame.document.location.href;
		if (typeof(obj)=="object")
		{
			url=obj.location.href;
			if(mode==1)
			{
				//we have to reset the form object
				create();
			}
			
		}
		else if ( (mode==3)&&(url1.indexOf("Result")==-1)  )
		{
				//we have to reset the form object
				query();
		}
		else
		{
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			return false;
		}
}

function onSuccess(frmobj)
{
	
			create();
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;

		

}
function assignResult( result1, message1, flag1 ,temp) {
	result	= result1 ;
    message	= message1 ;
    flag	= flag1 ;
}
function checkIsNotZero(obj, appendObj) {
	if (obj.value == "0") {
		obj.select();
		alert(getMessage("ZERO_NOT_ALLOWED","PH") + appendObj);
		return true;
	}
	//else {
		//checkSplChars(obj);
	//}
}

function checkSplChars(obj, mode)	{
	if(!CheckChars(obj)) {
		obj.select();
		alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
		return true;
	}
	else {
		if (mode == undefined)
			validNumber(obj);
	}
}

function validNumber(obj) {
	if (obj.value != "") {
		CheckNum(obj);
	}
}

function setagevalues(obj)
{      
	ageCode			=	document.FormTPNConsLimit.age_group.value;
	infusion_line	=	document.FormTPNConsLimit.infusion_line.value;

	document.getElementById("gender").innerText=genderArray[ageCode];	
	document.getElementById("gender_val").value=genderArray[ageCode];

		if (minageArray[ageCode] != "null" && minageArray[ageCode]!=undefined)
				document.FormTPNConsLimit.Min_Age.value=minageArray[ageCode];		
		else
				document.FormTPNConsLimit.Min_Age.value="";

		if (maxageArray[ageCode] != "null" && maxageArray[ageCode]!=undefined)
				document.FormTPNConsLimit.Max_Age.value=maxageArray[ageCode];		
		else
				document.FormTPNConsLimit.Max_Age.value="";

         var age_unit		="";
		 var age_unit_desc	="";
		if (ageunitArray[ageCode] != "null" && ageunitArray[ageCode]!=undefined)
	    {  
				age_unit=ageunitArray[ageCode];	
				if(age_unit=='D')
					age_unit_desc="Days";
				else if(age_unit=='W')
					age_unit_desc="Weeks";
				else if(age_unit=='M')
					age_unit_desc="Months";
				else if(age_unit=='Y')
					age_unit_desc="Years";
				document.FormTPNConsLimit.Age_Unit.value=age_unit_desc;
				document.FormTPNConsLimit.age_unit_code.value=age_unit;
				
		}
		else
				document.FormTPNConsLimit.Age_Unit.value="";
}



function checkforvalid(obj)
{
	
var age_group_code=obj.value;
//var infusion_line=obj1.value;

//alert("infusion_line"+infusion_line);
if(obj.value!= "" )
{
		var bean_id = document.FormTPNConsLimit.bean_id.value ;
		var bean_name = document.FormTPNConsLimit.bean_name.value ;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;


		xmlStr ="<root><SEARCH " ;
		xmlStr += "age_group_code=\""+ age_group_code +"\" " ;
		xmlStr += "infusion_line=\""+ infusion_line +"\" " ;

		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		//alert(xmlStr);

		xmlHttp.open( "POST", "TPNConsLimitsValidate.jsp?function_id="+function_id+"&bean_id=" + bean_id + "&bean_name=" + bean_name +"&validate=checkforvalid"+"&age_group_code="+obj.value, false ) ;
		xmlHttp.send( xmlDoc ) ;
		//alert(xmlHttp.responseText);
		eval(xmlHttp.responseText) ;

	//alert("all vals"+globalDrugRelated);
	//	Assigning the values starts from here...
		
	}
}

function addtocheckforvalid(flag)
{
	check_age_flag=flag;
	if(flag>1)
	{
     alert(getMessage("PH_TPN_CONS_RECORD_AGE_RANGE_EXIST","PH"));
	 
     parent.parent.commontoolbarFrame.CommonToolbar_form.reset.click();
	   
       
	}else
	{
     ageCode			=	document.FormTPNConsLimit.age_group.value;
	 infusion_line		=	document.FormTPNConsLimit.infusion_line.value;

	 parent.SearchResultsFrame.document.location.href="../../ePH/jsp/PHTPNConsLimitsAction.jsp?age_code="+ageCode+"&mode="+1+"&infusion_line="+infusion_line;
    
	}
}
function setvalues()
{
	//alert("setvalues---"+ConsLimitsAddModifyQueryFrame.SearchResultsFrame.document.FormTPNCons.name);
	
         var formobj=ConsLimitsAddModifyQueryFrame.SearchCriteriaFrame.document.FormTPNConsLimit;
		var formobj1=ConsLimitsAddModifyQueryFrame.SearchResultsFrame.document.FormTPNCons;
	    var Max_Age			=	formobj.Max_Age.value;
		var Min_Age			=	formobj.Min_Age.value;
		var age_unit_code	=	formobj.age_unit_code.value;
		var gender			=   formobj.gender_val.value;
		var infusion_line   =   formobj.infusion_line.value;
		var gender_val		=	"";
		 if(gender=="MALE")
	    {
          gender_val="M";
		}else if(gender=="FEMALE"){
           gender_val="F";
		}else{
            gender_val="U";
		}
		//alert(" formobj1.gender_val1.value---->"+ gender_val);
        formobj1.Max_Age1.value=Max_Age;
		formobj1.Min_Age1.value=Min_Age;
        formobj1.age_unit_code1.value=age_unit_code;
        formobj1.gender_val1.value=gender_val;
		//alert(" formobj1.gender_val1.value---->"+ formobj1.gender_val1.value);
		

		
}


function enableagegrp()
{
	document.FormTPNConsLimit.age_group.disabled=false;
}

async function viewComments(i,name){
	//alert(remarks);
	var agegroup=document.FormTPNCons.AGEGROUP.value;
	var regimen_code=document.FormTPNCons.regimen_code.value;
	//alert(agegroup);
	//alert(regimen_code);
		var retVal;
	var dialogHeight	= '33vh' ;
	var dialogWidth 	= '35vw' ;
	var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	var remarks=eval("document.FormTPNCons.hidden_remarks"+i).value;
	hdg_name			= "";
	retVal 				= await window.showModalDialog("../../ePH/jsp/PHTPNConsLimitsRemarks.jsp?hdg_name="+hdg_name+ "&row_no=" +i+ "&name=" +name+"&agegroup=" +agegroup+"&regimen_code=" +regimen_code+"&remarks="+encodeURIComponent(remarks,'UTF-8'),arguments,features);
	
	    if(retVal!=undefined){
		var retValArr					= retVal.split("||");
		retValue						= retValArr[1];
		eval("document.FormTPNCons.hidden_remarks"+i).value = retValue;
		parent.document.getElementById('dialog_tag').close();
       //	window.close();
		}
		else if(retVal==undefined)
	    {
			eval("document.FormTPNCons.hidden_remarks"+i).value = "";
			parent.document.getElementById('dialog_tag').close();
       	   // window.close();
		}
		//retValArr					= retVal.split("||");
		//retValue						= retValArr[1];
		//clin_cmts_value_entered_yn  = retValArr[0]; // Willbe always Y
		//if(retVal == null) retVal="";
		//alert(retValue);
		
		//eval("document.FormTPNCons."+comments).value = retVal;
 		// Set it in the hidden variable
 		//document.formDispenseLocation.hidden_remarks.value = retVal;
 		//var bean_id 	= document.FormTPNCons.bean_id.value ;
		//var bean_name 	= document.FormTPNCons.bean_name.value ;
		//var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;

		//xmlStr			= "<root><SEARCH " ;
		//xmlStr += "remarks=\""+ checkSpl(retValue) +"\" " ;
		//xmlStr 			+=" /></root>" ;
		
		//xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		
		//xmlHttp.open( "POST", "PHTPNConsLimitsValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+ "&validate=saveRemarks", false ) ;
		//xmlHttp.send( xmlDoc ) ;
		//responseText	= xmlHttp.responseText ;
		//eval( responseText ) ;
 	
}


function saveRemarksForDrug(count){
        var bean_id 	= document.getElementById('bean_id').value ;
		var bean_name 	= document.getElementById('bean_name').value ;
		var agegroup= document.getElementById('agegroup').value;
	    var regimen_code=document.getElementById('regimen_code').value;
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		xmlStr			= "<root><SEARCH " ;
		xmlStr += "remarks=\""+ document.getElementById('tpncons_remarks').value +"\" " ;
		xmlStr 			+=" /></root>" ;
		
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		
		xmlHttp.open( "POST", "PHTPNConsLimitsValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+ "&row_no=" + count +"&ageGroupcode=" + agegroup+"&regimen_code=" + regimen_code + "&validate=saveRemarks", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText	= xmlHttp.responseText ;
		eval( responseText ) ;
		//alert(responseText);
}
function doAmendClose()
{
	 if(trimCheck(document.getElementById("tpncons_remarks").value)!="")
	
		window.returnValue = "Y"+"||"+document.getElementById("tpncons_remarks").value; // since comments is entered
	 	const dialogTag = parent.document.getElementById("dialog_tag");
	 	dialogTag.close();

} 

function chkRange(formObj)
{
	var totalrows=formObj.totalrows.value;
 for (i=1;i<=totalrows ;i++ )
	{
		ceil=eval("formObj.CEIL"+i).value;
		max=eval("formObj.MAX"+i).value;
		if( parseFloat(max) > parseFloat(ceil) ){
//		 alert("PH_CEIL_GREATER_MAX");
		 alert(getMessage("PH_CEIL_GREATER_MAX","PH"));
		 eval("formObj.CEIL"+i).value="";
		  eval("formObj.CEIL"+i).focus();
		}
	}
}
