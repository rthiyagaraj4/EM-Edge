  //saved on 07/11/2005
var genderArray=new Array();
var minageArray=new Array();
var maxageArray=new Array();
var ageunitArray=new Array();
var maxageunitArray=new Array();
var result = false ;
var message = "" ;
var flag = "" ;
var radioval="C";

function create(){
	f_query_add_mod.location.href	=	"../../ePH/jsp/TDMAttributesFrames.jsp?mode="+MODE_INSERT;
}

function query() {
	f_query_add_mod.location.href="../../ePH/jsp/TDMAttributesQueryCriteria.jsp";
	
}

function apply() {
	if(!proceedOnApply()) {
		var frmObj		=	f_query_add_mod.TDM_attributes_details.document.getElementById("formTDMAtrributesResult");
		//var frmObj1	=	f_query_add_mod.TDM_attribute_header.document.getElementById("formTDMAtrributesCriteria");
		var frmObj1	=	f_query_add_mod.TDM_attribute_header.document.forms[0];
		var fields= new Array (frmObj1.drugCode, frmObj1.ageGrp, frmObj1.steadyState);
		var names= new Array(getLabel("Common.DrugName.label","Common"),getLabel("Common.agegroup.label","Common"),getLabel("ePH.SteadyState.label","PH"));
		if(checkFieldsofMst(fields,names,messageFrame) ) {
			var frmObj	=	f_query_add_mod.TDM_attributes_details.document.getElementById("formTDMAtrributesResult");
			if(frmObj!=undefined){
				var frmObj1	=	f_query_add_mod.TDM_attribute_header.document.getElementById("formTDMAtrributesCriteria");
				var flag						=	frmObj.applyFlag.value;		
				frmObj.mode.value				=	 frmObj1.mode.value;
				frmObj.drugCode.value			=	 frmObj1.drugCode.value;
				frmObj.ageGrp.value				=    frmObj1.ageGrp.value;
				frmObj.steadyState.value		=	 frmObj1.steadyState.value;
				frmObj.steadyStateType.value	=	 frmObj1.steadyStateType.value;
				
				if(frmObj.peakChk.checked){
					frmObj.peakFlag.value=1;
					if(frmObj.peakRowCount.value ==0)
						flag = 0;
				}
				else
					frmObj.peakFlag.value=0;

				if(frmObj.troughChk.checked){
					frmObj.troughFlag.value=1;
					if(frmObj.troughRowCount.value ==0)
						flag = 0;
				}
				else
					frmObj.troughFlag.value=0;

				if(frmObj.extendChk.checked){
						frmObj.extendFlag.value=1;
					if(frmObj.extendRowCount.value ==0)
						flag = 0;
				}
				else
					frmObj.extendFlag.value=0;

				if(frmObj.randomChk.checked){
					frmObj.randomFlag.value=1;
					if(frmObj.randomRowCount.value ==0)
						flag = 0;
				}
				else
					frmObj.randomFlag.value=0;
				if(flag ==1){
					eval( formApply( frmObj,PH_CONTROLLER) ) ;
					if(result){
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
						f_query_add_mod.location.href="../../ePH/jsp/TDMAttributesFrames.jsp?mode="+MODE_INSERT;
					}
					else
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
				}
				else{
					messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PH_ATLEAST_ONE_CATALOG_ASSOCIATED","PH");
					return false;
				}
			}
			else{
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
				return false;
			}
		}
	}
	else{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
}

function proceedOnApply() {
    var url = f_query_add_mod.location.href;
	var result;
    url = url.toLowerCase();

	if (url.indexOf("blank.html")!=-1)
		result	= true;
	 else if(url.indexOf("tdmattributesquery")!=-1)
		result	=	true;
   	else
		result	=	false;

	return result;
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function diplayResult(){
	var frmObj						=	parent.parent.f_query_add_mod.TDM_attribute_header.document.formTDMAtrributesCriteria;
	var steadyState				=	frmObj.steadyState.value;
	var drugName				=	frmObj.drugName.value;
	var ageGrp						=	frmObj.ageGrp.value;
	var mode						=frmObj.mode.value;

			
		if(CheckNum(frmObj.steadyState) && drugName!=""  &&ageGrp!="" )
				parent.TDM_attributes_details.location.href		=	"../../ePH/jsp/TDMAttributesResult.jsp";
}

function reset(){
		var url = f_query_add_mod.location.href;
		url = url.toLowerCase();

		if(url.indexOf("tdmattributesquerycriteria")!=-1)
			f_query_add_mod.document.query_form.reset();
		else if(url.indexOf("tdmattributesframes")!=-1)
			f_query_add_mod.location.href		=	"../../ePH/jsp/TDMAttributesFrames.jsp?mode="+MODE_INSERT;
	
}

async function searchDrugName(){
	var formObj				= document.formTDMAtrributesCriteria;
	var argumentArray		= new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray		= new Array() ;
	argumentArray[0]		= formObj.sql_ph_TDM_select1.value+"'"+document.formTDMAtrributesCriteria.language_id.value+"'";
	argumentArray[1]		= dataNameArray ;
	argumentArray[2]		= dataValueArray ;
	argumentArray[3]		= dataTypeArray ;
	argumentArray[4]	    = "1,2";
	argumentArray[5]		= formObj.drugName.value ;
	argumentArray[6]		= DESC_LINK ;
	argumentArray[7]		= DESC_CODE ; 
	retVal = await CommonLookup(getLabel("Common.DrugName.label","Common"), argumentArray );
	if(retVal != null && retVal != "" )  {
		var ret1=unescape(retVal);
	 	arr=ret1.split(",");
		formObj.drugName.value		=	 arr[1] ;
		formObj.drugCode.value		=	 arr[0];
		
		formObj.drugName.disabled				  =  true;
		formObj.drug_name_search.disabled =	  true;

	}
}

function ageGroupInfo(obj){
	var formObj		=	document.formTDMAtrributesCriteria;

	if (obj.value !=""){
	
		if (genderArray[obj.selectedIndex-1] != "null" && genderArray[obj.selectedIndex-1]!=undefined)
			document.getElementById("gender").innerHTML	="<label><B>&nbsp;&nbsp;"+   genderArray[obj.selectedIndex-1]+"</b></label>";		
		else
			document.getElementById("gender").innerHTML	=	"";

		if (minageArray[obj.selectedIndex-1] != "null" && minageArray[obj.selectedIndex-1]!=undefined)
			document.getElementById("minAge").innerHTML	="<label><B>&nbsp;&nbsp;"+minageArray[obj.selectedIndex-1]+"  "+ageunitArray[obj.selectedIndex-1] +"</b></label>";		
		else
			document.getElementById("minAge").innerHTML	=	"";
		
		if (maxageArray[obj.selectedIndex-1] != "null" && maxageArray[obj.selectedIndex-1]!=undefined)
			document.getElementById("maxAge").innerHTML	="<label><B>&nbsp;&nbsp;"+maxageArray[obj.selectedIndex-1]+"  "+maxageunitArray[obj.selectedIndex-1]+"</b></label>";		
		else
			document.getElementById("maxAge").innerText	=	"";   

	    formObj.gender_val.value		=	genderArray[obj.selectedIndex-1];

	}
}

function provideLink(obj) {

	var obj1;
	var sample		=	"";

	var formObj		=	document.formTDMAtrributesResult;
	
	if(obj==formObj.peakChk){
		obj1			=	document.getElementById("plc_order1");
		sample	=	"P";
	}
	else if(obj==formObj.troughChk){
		obj1			=	document.getElementById("plc_order2");
		sample	=	"T";
	}
	else if(obj==formObj.extendChk){
		obj1			=	document.getElementById("plc_order3");
		sample	=	"E";
	}
	else if(obj==formObj.randomChk){
		obj1			=	document.getElementById("plc_order4");
		sample	=	"R";
	}

	if(obj.checked){
		obj1.innerHTML		=	 "<label onClick=\"showOrderWindow('"+sample+"')\"  style='cursor:pointer;color:Blue'>"+getLabel('Common.Associate.label','Common')+"</label>"+"&nbsp;<img  src='../../eCommon/images/mandatory.gif'>";
		formObj.applyFlag.value='1';
	}
	else{
		obj1.innerHTML			=	"<label style='cursor:'>"+getLabel('Common.Associate.label','Common')+"</label>"
		var frmObj=parent.TDM_attributes_details.formTDMAtrributesResult;
		var bean_id		=	 frmObj.bean_id.value ;
		var bean_name	=	 frmObj.bean_name.value ;
		var xmlHttp = new XMLHttpRequest();
		xmlStr					=	"<root><SEARCH " ;
		xmlStr				  +=	 "sample =\"" + sample + "\" " ;
		xmlStr				  +=	" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "TDMAttributesValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=CLEAR_SAMPLE" + "&sample=" + sample,false);

		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
	}
}

function resetForm(formobj){
	var formobj=parent.TDM_attributes_ordercatalog_details.formTDMAtrributesCatalog;
	formobj.reset();
	var bean_id		=	 formobj.bean_id.value ;
	var bean_name	=	 formobj.bean_name.value ;
	var sample	=	 formobj.sample.value ;
	var xmlHttp = new XMLHttpRequest();
	xmlStr					=	"<root><SEARCH " ;
	xmlStr				  +=	" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open( "POST", "TDMAttributesValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=LAB_ORDER_RESET"+"&sample="+sample,false);

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;

}

 async function callremarks(reflag){
   /*   
   if(peak==undefined)peak="";
   if(Trough==undefined)Trough="";
   if(Extend==undefined)Extend="";
   if(random==undefined)random="";
 */
    var dialogHeight	= "22vh" ;
	var dialogWidth		= "30vw" ;
	var dialogTop		= "20" ;
	var dialogLeft		= "50" ;
	var center			= "1" ;
	var status			="no";
	var scroll			="no";
	//var features		= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	//var arguments		= "" ;
    var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + "; scroll:no" ;
    var arguments	= "";
																																			 
    bean_id				= document.formTDMAtrributesResult.bean_id.value;
 	bean_name			= document.formTDMAtrributesResult.bean_name.value;
    var retVal = await window.showModalDialog("../../ePH/jsp/TDMAttributeRemarks.jsp?reflag="+reflag+"&validate=seleRemark;",arguments,features);
    //var retVal = window.showModalDialog("../../ePH/jsp/TDMAttributeRemarks.jsp?bean_id="+bean_id+"&bean_name="+bean_name +"&reflag="+reflag+"&random="+random+"&Extend="+Extend+"&Trough="+Trough+"&peak="+peak+"&validate=seleRemark" ,arguments,features);

	 if(retVal!=null){
		retValArr					= retVal.split("||");
		retValue						= retValArr[1];
		
		//document.formTDMAtrributesResult.peak.value=retValue;
		stypecode = retValArr[0];
 		// Set it in the hidden variable
		//document.formTDMAtrributesResult.hidden_remarks.value = retVal;
 		var bean_id 	= document.formTDMAtrributesResult.bean_id.value ;
		var bean_name 	= document.formTDMAtrributesResult.bean_name.value ;
		var xmlHttp = new XMLHttpRequest();
		xmlStr			= "<root><SEARCH " ;
		xmlStr += "remarks=\""+ checkSpl(retValue) +"\" " ;
        xmlStr += "id=\""+ checkSpl(retVal) +"\" " ;
		xmlStr += "stypecode=\"" + stypecode + "\"";
		xmlStr 			+=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "TDMAttributesValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +"&remarks=" + retValue+"&stypecode=" + stypecode +"&validate=saveRemark", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText	= xmlHttp.responseText ;
		eval( responseText ) ;
		
 	}
}



function searchstring(sample){
	var formobj=parent.TDM_attribute_ordercatalog_header.formTDMAtrributesCatalogHdr;
	var searchstring=formobj.search_text.value;
	var sample=formobj.sample.value;
	if (formobj.search_by[0].checked)
			search_by="C";
		else
			search_by="D";

	var orderby=formobj.search_criteria.value;
	var sqlData="";	
	//if(searchstring!==""){
		if(search_by=="C"){
			if(orderby=="S"){
				sqlData+=escape("and upper(ORDER_CATALOG_CODE) like upper('"+searchstring+"%')  order by 2");
			}
			else if (orderby=="E"){
				sqlData+=escape("and upper(ORDER_CATALOG_CODE) like upper('%"+searchstring+"')  order by 2");
			}
			else if (orderby=="C"){
				sqlData+=escape("and upper(ORDER_CATALOG_CODE) like upper('%"+searchstring+"%')  order by 2");
			}
		}	
		if (search_by=="D"){
			if(orderby=="S"){
				sqlData+=escape("and upper(SHORT_DESC) like upper('"+searchstring+"%')  order by 1");
			}
			else if (orderby=="E"){
				sqlData+=escape("and upper(SHORT_DESC) like upper('%"+searchstring+"')  order by 1");
			}
			else if (orderby=="C"){
				sqlData+=escape("and upper(SHORT_DESC) like upper('%"+searchstring+"%')  order by 1");
			}
		}
	//}	
	parent.TDM_attributes_ordercatalog_details.location.href		=	"../../ePH/jsp/TDMAttribuesCatalog.jsp?flagyn=yes"+"&sqlData="+sqlData+"&sample="+sample;
}

async function showOrderWindow(sample){
	var dialogHeight		=	 "500px" ;
    var dialogWidth			=	 "700px" ;
    var status					=	 "no";
	var center					=	 "1" ;
	 var dialogFeatures  =	 "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; center: " + center + ";scroll=no; status:" + status;
	var arguments			= "" ;
	var retVal					= await window.showModalDialog("../../ePH/jsp/TDMAttribuesCatalogFrames.jsp?sample="+sample+"&called_from=Result",arguments,dialogFeatures);
	parent.TDM_attributes_details.location.href		=	"../../ePH/jsp/TDMAttributesResult.jsp";
	
}

function doAmendClose(rflag){
	var remarks=document.getElementById("tdm_remarks").value;
	if(remarks!=""){
		if(trimCheck(document.getElementById("tdm_remarks").value)!="")
			window.returnValue = rflag+"||"+document.getElementById("tdm_remarks").value; 
		const dialogTag =parent.document.getElementById("dialog_tag");    
	    dialogTag.close();
	}
	else {
		if(remarks==null)
			remarks="";
		window.returnValue = rflag+"||"+remarks; 
		const dialogTag = parent.document.getElementById("dialog_tag");    
	    dialogTag.close();
	}
} 

function showOrderWindow1(sample){
/*var dialogHeight		=	 "32" ;
    var dialogWidth			=	 "43" ;
    var status					=	 "no";
	var center					=	 "1" ;
	 var dialogFeatures  =	 "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; center: " + center + ";scroll=no; status:" + status;
	var arguments			= "" ;
	var retVal					= window.showModalDialog("../../ePH/jsp/TDMAttribuesCatalogFrames.jsp?sample="+sample,arguments,dialogFeatures);*/
}
function ChkMaxLen(obj,max) {
     
		if(obj.value.length >= max) {
				alert(getMessage("PH_TDM_RMK_MAXLEN_EXCEED"));
				obj.focus();
			return false;
		} else return true;

}

function navigation(frmObj,link){
	var formobjhdr=parent.TDM_attribute_ordercatalog_header.formTDMAtrributesCatalogHdr;
	var searchstring=formobjhdr.search_text.value;
	var sample=formobjhdr.sample.value;
	if (formobjhdr.search_by[0].checked)
			search_by="C";
		else
			search_by="D";

	var orderby=formobjhdr.search_criteria.value;
	var sqlData="";	
	//if(searchstring!==""){
		if(search_by=="C"){
			if(orderby=="S"){
				sqlData+=escape("and upper(ORDER_CATALOG_CODE) like upper('"+searchstring+"%')  order by 2");
			}
			else if (orderby=="E"){
				sqlData+=escape("and upper(ORDER_CATALOG_CODE) like upper('%"+searchstring+"')  order by 2");
			}
			else if (orderby=="C"){
				sqlData+=escape("and upper(ORDER_CATALOG_CODE) like upper('%"+searchstring+"%')  order by 2");
			}
		}	
		if (search_by=="D"){
			if(orderby=="S"){
				sqlData+=escape("and upper(SHORT_DESC) like upper('"+searchstring+"%')  order by 1");
			}
			else if (orderby=="E"){
				sqlData+=escape("and upper(SHORT_DESC) like upper('%"+searchstring+"')  order by 1");
			}
			else if (orderby=="C"){
				sqlData+=escape("and upper(SHORT_DESC) like upper('%"+searchstring+"%')  order by 1");
			}
		}
	//}


	var start		=	frmObj.start.value;
	var end		=	frmObj.end.value;
	var sample	=	frmObj.sample.value;
		
	if (link=="next"){
		start		=	parseInt(start)+14;
		end		=	parseInt(end)+14;
		parent.TDM_attributes_ordercatalog_details.location.href	=	"../../ePH/jsp/TDMAttribuesCatalog.jsp?from="+start+"&to="+end+"&sample="+sample+"&sqlData="+sqlData+"&flagyn=yes";
	}
	else if(link=="previous"){
		start		=	parseInt(start)-14;
		end		=	parseInt(end)-14;
		parent.TDM_attributes_ordercatalog_details.location.href		=	"../../ePH/jsp/TDMAttribuesCatalog.jsp?from="+start+"&to="+end+"&sample="+sample+"&sqlData="+sqlData+"&flagyn=yes";;
	}
}

function selectLabOrder(obj,objno,fromflag,sample1){
	var flag;
	var frmObj;
	var sample;
	var code_number;
	var labOrdercode;
	var desc_number;
	var labOrderdesc;
	var checkflag=obj.checked;
	if(obj.checked){
		flag	=	"Y";
	}
	else{
		flag	=	"N";
	}
	//if(checkflag){
	frmObj=parent.TDM_attributes_ordercatalog_details.formTDMAtrributesCatalog;
	sample=sample1;
	code_number		=  eval(" frmObj.code_"+objno);
	labOrdercode		=	code_number.value;

	desc_number		=  eval(" frmObj.desc_"+objno);
	labOrderdesc		=	desc_number.value;

	var bean_id		=	 frmObj.bean_id.value ;
	var bean_name	=	 frmObj.bean_name.value ;
	var xmlHttp = new XMLHttpRequest();
	xmlStr					=	"<root><SEARCH " ;
	xmlStr				  +=	 "labOrdercode =\"" +encodeURIComponent(labOrdercode,"UTF-8") + "\" " ;
	xmlStr				  +=	 "labOrderdesc =\"" + encodeURIComponent(labOrderdesc,"UTF-8") + "\" " ;
	xmlStr				  +=	" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "TDMAttributesValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=LAB_ORDER_SELECT_REMOVE" + "&labOrdercode=" + labOrdercode+"&flag="+flag+"&labOrderdesc=" + encodeURIComponent(labOrderdesc,"UTF-8")+"&sample=" +sample,false); //encoded for IN24564-reopen --04/11/2010-- priya

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
	if(fromflag!=1)
		loadResult();
//	}			
}

function selectLabOrder11(obj,objno,fromflag,sample){
	var flag;
	var frmObj;
	var sample;
	var code_number;
	var labOrdercode;
	var desc_number;
	var labOrderdesc;
	var checkflag=obj.checked;

	if(obj.checked){
		flag	=	"Y";
	}
	else{
		flag	=	"N";
			
	}	
	if(!checkflag){
		frmObj=parent.TDM_attributes_details.formTDMAtrributesResult;
		code_number		=  eval(" frmObj."+sample+"code_"+objno);
		labOrdercode		=	code_number.value;

		desc_number		=  eval(" frmObj."+sample+"desc_"+objno);
		labOrderdesc		=	desc_number.value;
	}
	var bean_id		=	 frmObj.bean_id.value ;
	var bean_name	=	 frmObj.bean_name.value ;
	var xmlHttp = new XMLHttpRequest();
	xmlStr					=	"<root><SEARCH " ;
	xmlStr				  +=	 "labOrdercode =\"" +encodeURIComponent(labOrdercode,"UTF-8") + "\" " ;
	xmlStr				  +=	 "labOrderdesc =\"" + encodeURIComponent(labOrderdesc,"UTF-8") + "\" " ;
	xmlStr				  +=	" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "TDMAttributesValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=LAB_ORDER_SELECT_REMOVE" + "&labOrdercode=" + labOrdercode+"&flag="+flag+"&labOrderdesc=" + encodeURIComponent(labOrderdesc,"UTF-8")+"&sample=" +sample+"&final_yn=Y",false); //encoded for IN24564-reopen --04/11/2010-- priya

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval( responseText ) ;
	if(fromflag!=1)
		loadResult();
}

function closeW(){
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
}

function identityOperation(symbol,type){
	var sign=symbol.innerText;
	if(sign=='+'){
		expand(type);
		symbol.innerText ="-";
	}
	else{
	   symbol.innerText ="+";
		collapse(type);
	}
}

function expand(type){
	var rowsize;
	var frmObj=document.getElementById("formTDMAtrributesResult");
	var Obj;
	var Obj1;
	if (type=='P')
		rowsize= parseInt(frmObj.peakRowCount.value);
	else if(type=='T')
		rowsize= parseInt(frmObj.troughRowCount.value);
	else if(type=='E')
		rowsize= parseInt(frmObj.extendRowCount.value);
	else if(type=='R')
		rowsize= parseInt(frmObj.randomRowCount.value);
		
	for( i=0;i<rowsize;i++){
		Obj = document.getElementById(type+"_"+i);
		Obj.style="display";
	}

}

function collapse(type){
	var rowsize;
	var frmObj=document.getElementById("formTDMAtrributesResult");
	var Obj;
	var Obj1;
	if (type=='P')
		rowsize= parseInt(frmObj.peakRowCount.value);
	else if(type=='T')
		rowsize= parseInt(frmObj.troughRowCount.value);
	else if(type=='E')
		rowsize= parseInt(frmObj.extendRowCount.value);
	else if(type=='R')
		rowsize= parseInt(frmObj.randomRowCount.value);
		
	for( i=0;i<rowsize;i++){
		Obj = document.getElementById(type+"_"+i);
		Obj.style.display="none";
	}

}

function loadResult(){
	parent.TDM_attributes_details.location.href		=	"../../ePH/jsp/TDMAttributesResult.jsp";
}

function checkforvalid(obj){

	var drugCode=document.formTDMAtrributesCriteria.drugCode.value;
	if(drugCode != "" ){
		var bean_id = document.formTDMAtrributesCriteria.bean_id.value ;
		var bean_name = document.formTDMAtrributesCriteria.bean_name.value ;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr += "drugCode=\""+ checkSpl(drugCode) +"\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "TDMAttributesValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +    "&drugCode="+drugCode+"&validate=CHECKFORVALID"+"&ageGrpCode="+obj.value, false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText) ;
	}
}

function chkforoverlap(){	
	var drugCode			=	document.formTDMAtrributesCriteria.drugCode.value;
	var age_group_code	=	document.formTDMAtrributesCriteria.ageGrp.value;
	var bean_id			=	document.formTDMAtrributesCriteria.bean_id.value ;
	var bean_name		=	document.formTDMAtrributesCriteria.bean_name.value ;
	var xmlHttp = new XMLHttpRequest();
	xmlStr				=	"<root><SEARCH " ;
	xmlStr				+= "drugCode=\""+ escape(drugCode) +"\" " ;
	xmlStr				+= "age_group_code=\""+ age_group_code +"\" " ;
	xmlStr				+=" /></root>" ;
	// alert(xmlStr);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "TDMAttributesValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +"&validate=CHECKFOROVERLAP", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText) ;
}

function clearCheckForValid(flag){
	
	if(flag>0){

		alert(getMessage("PH_TDM_AGE_RANGE_EXISTS","PH"));
		document.getElementById("ageGrp").selectedIndex=0;
		document.getElementById("minAge").innerHTML="";
		document.getElementById("maxAge").innerHTML="";
		document.getElementById("gender").innerHTML="";
		/*document.getElementById("ageUnit").innerHTML="";
		document.formTDMAtrributesCriteria.minAge.innerHTML="";
		document.formTDMAtrributesCriteria.maxAge.innerHTML="";
		document.formTDMAtrributesCriteria.gender.innerHTML="";
		document.formTDMAtrributesCriteria.ageUnit.innerHTML="";*/
	}
}

function clearCheckForOverlap(exists_yn){
	
	if(exists_yn=='Y'){

	   alert(getMessage("PH_TDM_AGE_RANGE_EXISTS","PH"));
		document.getElementById("ageGrp").selectedIndex=0;
		document.getElementById("minAge").innerHTML="";
		document.getElementById("maxAge").innerHTML="";
		document.getElementById("gender").innerHTML="";

    /*   document.formTDMAtrributesCriteria.minAge.innerHTML="";
	   document.formTDMAtrributesCriteria.maxAge.innerHTML="";
	   document.formTDMAtrributesCriteria.gender.innerHTML="";
	   document.formTDMAtrributesCriteria.ageUnit.innerHTML="";*/
	}
	else{
       ageGroupInfo(document.formTDMAtrributesCriteria.ageGrp);
	   checkforvalid(document.formTDMAtrributesCriteria.ageGrp);
	   diplayResult();
	}
}

function ModifyRow(drugCode,ageGrpCode) {
	parent.f_query_add_mod.location.href	=	"../../ePH/jsp/TDMAttributesFrames.jsp?mode="+MODE_MODIFY+"&drugCode="+drugCode+"&ageGrpCode="+ageGrpCode;

}

function store(sampleType){

	frmObj=parent.TDM_attributes_details.formTDMAtrributesResult;
	var sampleTime;
	var sampleTimeType;
	if(sampleType=='P'){
		sampleTime=frmObj.peakSampleTime.value;
		sampleTimeType=frmObj.peakSampleTimeType.value;
	}
	else if(sampleType=='T'){
		sampleTime=frmObj.troughSampleTime.value;
		sampleTimeType=frmObj.troughSampleTimeType.value;
	}
	else{
		sampleTime=frmObj.extendSampleTime.value;
		sampleTimeType=frmObj.extendSampleTimeType.value;
	}
	var bean_id		=	 frmObj.bean_id.value ;
	var bean_name	=	 frmObj.bean_name.value ;
	var xmlHttp = new XMLHttpRequest();
	xmlStr					=	"<root><SEARCH " ;
	xmlStr				  +=	 "sampleType =\"" +sampleType+ "\" " ;
	xmlStr				  +=	 "sampleTime =\"" +sampleTime+ "\" " ;
	xmlStr				  +=	 "sampleTimeType =\"" + sampleTimeType + "\" " ;
	xmlStr				  +=	" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open( "POST", "TDMAttributesValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=SAMPLETIME" + "&sampleType=" + sampleType+"&sampleTime="+sampleTime+"&sampleTimeType=" + sampleTimeType,false);

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
}

function storevalues(sample){
	var 	frmObj=parent.TDM_attributes_ordercatalog_details.formTDMAtrributesCatalog;
//	var count_1=frmObj.count_1.value;
/*	for(var j=0;j<count_1;j++)	{
		
		if(eval(" frmObj.select_"+j).checked){

			sample					=	frmObj.sample.value;
			code_number		=  eval(" frmObj.code_"+j);
			labOrdercode		=	code_number.value;
			desc_number		=  eval(" frmObj.desc_"+j);
			labOrderdesc		=	desc_number.value;
	
		var xmlDoc			=	 new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp			=	 new ActiveXObject( "Microsoft.XMLHTTP" ) ;

		xmlStr					=	"<root><SEARCH " ;
		xmlStr				  +=	 "labOrdercode =\"" +escape(labOrdercode) + "\" " ;
		xmlStr				  +=	 "labOrderdesc =\"" + escape(labOrderdesc) + "\" " ;
		xmlStr				  +=	" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

		xmlHttp.open( "POST", "TDMAttributesValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=LAB_ORDER_SELECT" + "&labOrdercode=" + labOrdercode+"&flag=Y"+"&labOrderdesc=" + escape(labOrderdesc)+"&sample=" +sample,false);
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
		}
		
	}*/
	//parent.TDM_attributes_ordercatalog_details.location.href		=	"../../ePH/jsp/TDMAttributesValidate.jsp?validate=LAB_ORDER_FINAL";
	var bean_id		=	 frmObj.bean_id.value ;
	var bean_name	=	 frmObj.bean_name.value ;
	var xmlHttp = new XMLHttpRequest();
	xmlStr					=	"<root><SEARCH " ;
	xmlStr				  +=	" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open( "POST", "TDMAttributesValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=LAB_ORDER_FINAL"+"&sample="+sample,false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
}
