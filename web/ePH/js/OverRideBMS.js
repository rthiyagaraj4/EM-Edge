  //saved on 07/11/2005
var function_id = "" ;
var message		= "" ;
var flag		= "" ;
var result		= false ;

function query()	{
	f_query_criteria.location.href="../../ePH/jsp/OverRideBMSCriteria.jsp";
}


function reset()	{
	//alert("reset is working");
	if(f_query_criteria)	{
		f_query_criteria.document.formOverRideBMS.reset();
		
	}
	if(f_query_result.f_result!=undefined){
		f_query_result.f_result.location.href="../../eCommon/html/blank.html";
	}
}

function callResultPage()	{  
	var frm_obj		=	parent.f_query_criteria.document.formOverRideBMS.dt_from;
	var to_obj		=	parent.f_query_criteria.document.formOverRideBMS.dt_to;
	var disp_locn	=	parent.f_query_criteria.document.formOverRideBMS.disp_locn;
	var disp_code	=	parent.f_query_criteria.document.formOverRideBMS.disp_code.value;
	msg_frame		=	parent.messageFrame;
	var language_id	=   parent.f_query_criteria.document.formOverRideBMS.language_id.value;
	var fields	= new Array ();
	var names = new Array ();
	fields[0]	=  frm_obj;
	names[0]	=  getLabel("ePH.DispensedDateFrom.label","PH");
	fields[1]	=  to_obj;
	names[1]	=  getLabel("ePH.DispensedDateTo.label","PH");
	fields[2]	=  disp_locn;
	names[2]	=  getLabel("ePH.DispenseLocation.label","PH");

	
	if(checkFields( fields, names,msg_frame)){
		if(doDateCheck(frm_obj,to_obj,msg_frame) )	{
			var dt_from				=	frm_obj.value;
			var dt_to				=	to_obj.value;
			var disp_locn			=	parent.f_query_criteria.document.formOverRideBMS.disp_locn.value;
		
			
			parent.f_query_result.location.href="../../ePH/jsp/OverRideBMSResultFrame.jsp?dt_from="+convertDate(dt_from,"DMY",language_id,"en")+"&dt_to="+convertDate(dt_to,"DMY",language_id,"en")+"&disp_locn="+disp_locn+"&called_from=search&disp_code="+disp_code;
			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		}	else	{
			parent.f_query_result.location.href="../../eCommon/html/blank.html"
		}  

	}
}

function SubmitLink(from,to){
	var obj				=	document.formOverRideBMSResult;
	//alert(obj);
	obj.from.value		=	from;
	obj.to.value		=	to;
	obj.submit();
}

function storeCheckedRecords(mode){
	//alert("after calling this method "+mode)
	var formObj;
	if(mode=='apply') {
		  formObj = f_query_result.f_result.document.formOverRideBMSResult;
	} else {
		 formObj	= document.formOverRideBMSResult;
	 }
	//alert(formObj);

	var bean_id   = formObj.bean_id.value;
	var bean_name = formObj.bean_name.value;
	//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";

	var arrObj = formObj.elements;
	var from   = formObj.from.value;
	var val	   = "";
	for(var i=0;i<arrObj.length;i++) {
		//alert(arrObj[i].type);
		if(arrObj[i].type == "select-one") {
				if(arrObj[i].value!=null)	{
				   xmlStr+= arrObj[i].name+"=\"" + arrObj[i].value + "\" " ;
				} 		
		}
	}
	xmlStr += " from=\""+from+"\"";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//alert("xmlstr===="+xmlStr);
	xmlHttp.open("POST","ReleaseBatchesValidate.jsp?called_from=override",false);
	xmlHttp.send( xmlDoc ) ;
	//alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);
	
}

function apply() {
   /*
	//alert("apply method");
	//alert("==1===="+parent.name);
	//alert("==2===="+f_query_result.f_result.document.formOverRideBMSResult);
	//alert("==3===="+f_query_result.frames[0].name);
	//alert("==4====="+f_query_result.frames[1].name);
	//alert("==4====="+f_query_result.frames[2].name);
	//alert("==4====="+f_query_result.frames[3].name);
	//alert(formApply(f_query_result.f_result.document.formOverRideBMSResult,PH_CONTROLLER  )) ;
	eval( formApply(f_query_result.f_result.document.formOverRideBMSResult,PH_CONTROLLER) ) ;
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
*/
	storeCheckedRecords('apply');
	if(!proceedOnApply())	{
			//alert(formApply(f_query_result.document.formOverRideBMSResult,PH_CONTROLLER  )) ;
			eval( formApply(f_query_result.f_result.document.formOverRideBMSResult,PH_CONTROLLER  ) ) ;
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;

			if( result ) {
				onSuccess();
			//f_query_result.location.href="../../eCommon/html/blank.html";
			}   

		}	else	{
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
			return false;
			
		}
}


async function searchDispLocn(obj){
var sql="";

 // sql="SELECT DISP_LOCN_CODE CODE, SHORT_DESC description FROM PH_DISP_LOCN_LANG_VW PH_DISP_LOCN WHERE EFF_STATUS='E' AND DISP_LOCN_CODE LIKE UPPER(?) AND Upper(SHORT_DESC) like upper(?) and facility_id ="; 


var argumentArray  = new Array() ;
var dataNameArray  = new Array() ; 
var dataValueArray = new Array() ;
var dataTypeArray  = new Array() ;
var FACILITY_ID=document.formOverRideBMS.facility_id.value;
var LANGUAGE_ID=document.formOverRideBMS.language_id.value;

	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;
	parNameArray[0] ="~FACILITY_ID`";
	parNameArray[1] ="~LOCALE_ID`";
	parValueArray[0]=document.formOverRideBMS.facility_id.value;
	parValueArray[1]=document.formOverRideBMS.language_id.value;

	argumentArray[0] =""; //sql+"'"+FACILITY_ID+"'"+" and language_id="+"'"+LANGUAGE_ID+"'"+"order by 2";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC
	// added for MOHE-SCF-0276 by lakshmanan 
	argumentArray[12]  = "SQL_PH_DISP_LOC_LOOKUP_SELECT";
	argumentArray[13]  = "ePH.Common.PhRepository";
	argumentArray[14]  = parNameArray
	argumentArray[15]  = parValueArray
	
	retVal = await CommonLookup(getLabel("Common.Location.label","Common"), argumentArray );
	var ret1=unescape(retVal);
 	arr=ret1.split(",");
		if(retVal != null && retVal != "") {
			document.formOverRideBMS.disp_locn.value = arr[1] ;
			document.formOverRideBMS.disp_code.value = arr[0];
	}


}



function proceedOnApply() {
    var url = f_query_result.location.href;
	var result;
    url = url.toLowerCase();

	if (url.indexOf("blank.html")!=-1)
		result	= true;
    else
		result	=	false;

	return result;
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function beforePost(xmlStr){
	//alert("Disp Medication(Verification)::"+xmlStr);
}

function onSuccess() {
		f_query_criteria.location.href="../../ePH/jsp/OverRideBMSCriteria.jsp";
		f_query_result.location.href="../../eCommon/html/blank.html";
}

function chkValue(obj) {
	 if(obj.checked==true)
		 obj.value = "Y";
	 else
		 obj.value = "N";
}

/* function showDetails(order_id,ord_line_no,pres_qty,pres_drug) {
	alert("hello ")
	var retVal;
	var dialogTop		= "210";
 	var dialogHeight	= "20" ;
 	var dialogWidth		= "35" ;
	var center			= "1" ;
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +';  dialogTop:'+dialogTop +'; scroll=auto; status=no';
 	var arguments		= "";
 	retVal 				= window.showModalDialog("../../ePH/jsp/OverRideBMSAlternate.jsp?order_id="+order_id+"&ord_line_no="+ord_line_no+"&pres_drug="+pres_drug+"&pres_qty="+pres_qty,arguments,features);
	alert("after jsp file")
}*/
