  //saved on 27/10/2005
var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;
var start = 0 ;
var end   = 0 ;
var maxRec = 0  ;
var displaySize = 0 ;
var firstTime   = true;

function create() {
    f_query_add_mod.location.href="../../ePH/jsp/GenericNameForServiceFrame.jsp";

}
function query() {
    f_query_add_mod.location.href="../../ePH/jsp/GenericNameForServiceQueryCriteria.jsp" ;
}
function callByGenericName(obj){
	//alert("callByGenericName");
    //document.genericnameforservice_tab.service.src='../../ePH/images/By_Service.gif';
    //document.genericnameforservice_tab.generic_name.src='../../ePH/images/By_Generic_Name_click.gif';
    parent.genericnameforservice_header.location.href="../../ePH/jsp/GenericNameForServiceHeader.jsp?from_source=bygeneric";

    parent.genericnameforservice_button.location.href="../../eCommon/html/blank.html";
    parent.genericnameforservice_label.location.href="../../eCommon/html/blank.html";
    parent.genericnameforservice_dtls.location.href="../../eCommon/html/blank.html";

    parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
}

//call the service header jsp
function callByService(){
	//alert("callByService");
//document.genericnameforservice_tab.service.src='../../ePH/images/By_Service_click.gif';
//document.genericnameforservice_tab.generic_name.src='../../ePH/images/By_Generic_Name.gif';
parent.genericnameforservice_label.location.href="../../eCommon/html/blank.html";
parent.genericnameforservice_dtls.location.href="../../eCommon/html/blank.html";
parent.genericnameforservice_button.location.href="../../eCommon/html/blank.html";
parent.genericnameforservice_header.location.href="../../ePH/jsp/GenericNameForServiceHeader.jsp?from_source=byservice";
parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";


}

function tab_click1(id)
{


	selectTab(id);
	
	callByGenericName();
}
function tab_click2(id)
{


	selectTab(id);
	
	callByService();
}

//on click of select or association links
function Display(from,code)
{
	
    parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	if(from == "1")
	{   
		parent.genericnameforservice_button.document.getElementById('select_col').className="clicked";
		parent.genericnameforservice_button.document.getElementById('association_col').className="normal";
	}else if(from == "2")
	{   //alert("association_col 1")
		parent.genericnameforservice_button.document.getElementById('select_col').className="normal";
		parent.genericnameforservice_button.document.getElementById('association_col').className="clicked";
	}

    if(code=="byservice"){
		
            //from select
            var frmObj  =       parent.genericnameforservice_dtls.location.href.indexOf(".jsp");
            if(from == "1")
            {
                if(frmObj!=-1){
					
                    if(parent.genericnameforservice_dtls.genericnameforservice_dtls.choosen_link.value=="association"){
                        parent.genericnameforservice_dtls.genericnameforservice_dtls.choosen_link.value="select";
                        //document.getElementById("select").className="HIGHER_LEVEL_LINK";
                        //document.getElementById("select_col").className="clicked";
                        //document.getElementById("association").className="SUB_LEVEL_LINK";
                        //document.getElementById("association_col").className="normal";
                        if(pageUpdateAssociation()){
							
                            parent.genericnameforservice_label.location.href="../../ePH/jsp/GenericNameForServiceLabel.jsp";
                            parent.genericnameforservice_dtls.location.href="../../eCommon/html/blank.html";
                        }
                     }
                }
                else{

                }
            }//from association.
            else if(from == "2")
            {
                //alert("association_col 2")

                if(frmObj!=-1){
					 //alert("association_col 3")
                    if(parent.genericnameforservice_dtls.genericnameforservice_dtls.choosen_link.value=="select"){
                            parent.genericnameforservice_dtls.genericnameforservice_dtls.choosen_link.value="association";
                            if(pageUpdate()){
							 // alert("association_col 4")
                              parent.genericnameforservice_label.location.href="../../eCommon/html/blank.html";
                              parent.genericnameforservice_dtls.location.href="../../ePH/jsp/GenericNameForServiceDtlsAssc.jsp?call_mode=association";
                        }
                    }
                }
                else{
                    
					//alert("association_col 5")
                    parent.genericnameforservice_label.location.href="../../eCommon/html/blank.html";

                    parent.genericnameforservice_dtls.location.href="../../ePH/jsp/GenericNameForServiceDtlsAssc.jsp?call_mode=association";
            }
        }

    }else{
        if(from == "1") {
            if(parent.genericnameforservice_dtls.genericnameforservice_dtls.choosen_link.value=="association"){
                parent.genericnameforservice_dtls.genericnameforservice_dtls.choosen_link.value="select";
                //document.getElementById("select").className="HIGHER_LEVEL_LINK";
                //document.getElementById("select_col").className="clicked";
                //document.getElementById("association").className="SUB_LEVEL_LINK";
                //document.getElementById("association_col").className="normal";
                if(pageUpdateAssociationbyGeneric()){
                    parent.genericnameforservice_dtls.location.href="../../ePH/jsp/GenericNameForServiceDtlsbyGen.jsp?call_mode=select";
                }
            }
        }
        else if(from == "2"){
            if(parent.genericnameforservice_dtls.genericnameforservice_dtls.choosen_link.value=="select"){
                parent.genericnameforservice_dtls.genericnameforservice_dtls.choosen_link.value="association";
                //document.getElementById("select").className="SUB_LEVEL_LINK";
                //document.getElementById("select_col").className="normal";
                //document.getElementById("association").className="HIGHER_LEVEL_LINK";
                //document.getElementById("association_col").className="clicked";
                if(pageUpdatebyGeneric()){
                    parent.genericnameforservice_dtls.location.href="../../ePH/jsp/GenericNameForServiceDtlsAsscbyGen.jsp?call_mode=association";
                }
            }
        }
    }
}

//call the details result page onlclick of alphabates
function changeAlphaColor(obj){
	//alert("changeAlphaColor")

	if(obj=="celloth"){
		//alert("1")
		celloth.className="clicked";
		for(var i=0;i<=25;i++){
			var cell =eval("cell"+i);
			cell.className="normal";
		}
	}
	else{
		for(var i=0;i<=25;i++){
		
			var chk=eval(obj);
			var cell =eval("cell"+i);
			if(chk==cell){	
				chk.className="clicked";
			}else{
				cell.className="normal";
			}
		celloth.className="normal";
		}
	}
}
async function callGenericBean(generic_id,obj){

	//alert("Call Generic Bean..");
	changeAlphaColor(obj);
    parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
if(firstTime )  {
	//alert("firstTime")
parent.genericnameforservice_dtls.location.href="../../ePH/jsp/GenericNameForServiceDetails.jsp?call_mode=select&generic_id="+generic_id+"&mode="+MODE_INSERT;
firstTime=false;
}
else
    {
   var pageUpdateResult = await pageUpdate();
      if(pageUpdateResult)
	 {
		 

		  parent.genericnameforservice_dtls.location.href="../../ePH/jsp/GenericNameForServiceDetails.jsp?call_mode=select&generic_id="+generic_id+"&mode="+MODE_INSERT;
     }

    }
}

//onChange of service code
function populateSearchCode(obj){
    if(obj.value=='')
    {
        obj.focus();
    }
    else{
           
		//The following line is added by raghunath...
		//parent.genericnameforserviceframeid.rows="20,28,20,15,*";
    	parent.document.getElementById('genericnameforservice_button').style.height="3vh";
    	parent.document.getElementById('genericnameforservice_label').style.height="2vh";
		parent.genericnameforservice_button.location.href="../../ePH/jsp/GenericNameForServiceButton.jsp?from_source=byservice&service_code="+obj.value;


       //parent.genericnameforservice_label.location.href="../../ePH/jsp/GenericNameForServiceLabel.jsp?service_code="+obj.value;
        parent.genericnameforservice_dtls.location.href="../../eCommon/html/blank.html";
        parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
    }
}

function callLabelPage(service_code){
//alert("GenericNameForServiceLabel444444444")
parent.genericnameforservice_label.location.href="../../ePH/jsp/GenericNameForServiceLabel.jsp?service_code="+service_code;
}

function callDetailsPage(){
//alert("GenericNameForServiceLabel 5555555555")

parent.genericnameforservice_dtls.location.href="../../ePH/jsp/GenericNameForServiceDtlsbyGen.jsp?call_mode=load";
}
//onChange of Generic Name
function populateGenericCode(obj){
    if(obj.value==''){
        obj.focus();
    }
    else{
		//The following line is added by raghunath...
		//parent.genericnameforserviceframeid.rows="20,28,0,0,*";
    	parent.document.getElementById('genericnameforservice_button').style.height="0vh";
    	parent.document.getElementById('genericnameforservice_label').style.height="0vh";
		parent.genericnameforservice_button.location.href="../../ePH/jsp/GenericNameForServiceButton.jsp?from_source=bygeneric&generic_id="+obj.value;
		//parent.genericnameforservice_dtls.location.href="../../ePH/jsp/GenericNameForServiceDetailsbyGeneric.jsp?call_mode=load";
        parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
    }
}


function populateGenericName(){
    parent.genericnameforservice_dtls.location.href="../../ePH/jsp/GenericNameForServiceDetails.jsp";
}

function activeLink() {
    if( start != 0 ){
        document.getElementById("prev").style.visibility='visible';
    }
    else{
    document.getElementById("prev").style.display='none';
    }

    if( end >= maxRec )
        document.getElementById("next").style.display='none';
    else
        document.getElementById("next").style.visibility='visible';
}


async function pageUpdate(){

    var finalString="";
    var initString = unescape(parent.genericnameforservice_dtls.genericnameforservice_dtls.initString.value) ;
    var fm=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.start.value);
    var tom=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.end.value);

    var count=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.count.value);
    if(count==tom){

    }else{
    tom=count;
    }
    finalString= await formFinalString(fm,tom,"parent","byservice","select");
    xmlStr=await formXMLString(initString,finalString,"byservice","select");
    var result=await formValidation("byservice","select",xmlStr);
    return result;
    

}
function pageUpdateApply(){
    var initString = unescape(f_query_add_mod.genericnameforservice_dtls.genericnameforservice_dtls.initString.value );
    var finalString="";
    var fm=parseInt(f_query_add_mod.genericnameforservice_dtls.genericnameforservice_dtls.start.value);
    var tom=parseInt(f_query_add_mod.genericnameforservice_dtls.genericnameforservice_dtls.end.value);

    var count=parseInt(f_query_add_mod.genericnameforservice_dtls.genericnameforservice_dtls.count.value);
    if(count==tom){

    }else{
    tom=count;
    }
    finalString=formFinalString(fm,tom,"child","byservice","select");
    xmlStr=formXMLString(initString,finalString,"byservice","select");
    var result=formValidation("byservice","select",xmlStr);
    return result;


}
async function pageUpdateApplybyGeneric(){
    var initString = unescape(f_query_add_mod.genericnameforservice_dtls.genericnameforservice_dtls.initString.value );
    var finalString="";
    var fm=parseInt(f_query_add_mod.genericnameforservice_dtls.genericnameforservice_dtls.start.value);
    var tom=parseInt(f_query_add_mod.genericnameforservice_dtls.genericnameforservice_dtls.end.value);

    var count=parseInt(f_query_add_mod.genericnameforservice_dtls.genericnameforservice_dtls.count.value);
    if(count==tom){

    }else{
    tom=count;
    }
    finalString= await formFinalString(fm,tom,"child","bygeneric","select");
    xmlStr=await formXMLString(initString,finalString,"bygeneric","select");
    var result=await formValidation("bygeneric","select",xmlStr);
    return result;

}
async function pageUpdateAssociation(){
    var initString = unescape(parent.genericnameforservice_dtls.genericnameforservice_dtls.initString.value) ;
    var finalString="";
    var fm=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.start.value);
    var tom=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.end.value);

    var count=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.count.value);
    if(count==tom){

    }else{
    tom=count;
    }
    finalString=await formFinalString(fm,tom,"parent","byservice","association");
    xmlStr= await formXMLString(initString,finalString,"byservice","association");
    var result=await formValidation("byservice","association",xmlStr);
    return result;

}
function pageUpdateAssociationApply(){

    var initString = unescape(f_query_add_mod.genericnameforservice_dtls.genericnameforservice_dtls.initString.value );
    var finalString="";
    var fm=parseInt(f_query_add_mod.genericnameforservice_dtls.genericnameforservice_dtls.start.value);
    var tom=parseInt(f_query_add_mod.genericnameforservice_dtls.genericnameforservice_dtls.end.value);

    var count=parseInt(f_query_add_mod.genericnameforservice_dtls.genericnameforservice_dtls.count.value);
    if(count==tom){

    }else{
    tom=count;
    }
    finalString=formFinalString(fm,tom,"child","byservice","association");

    xmlStr=formXMLString(initString,finalString,"byservice","association");
    var result=formValidation("byservice","association",xmlStr);
    return result;

}
function pageUpdateAssociationApplybyGeneric(){

    var initString = unescape(f_query_add_mod.genericnameforservice_dtls.genericnameforservice_dtls.initString.value );
    var finalString="";
    var fm=parseInt(f_query_add_mod.genericnameforservice_dtls.genericnameforservice_dtls.start.value);
    var tom=parseInt(f_query_add_mod.genericnameforservice_dtls.genericnameforservice_dtls.end.value);

    var count=parseInt(f_query_add_mod.genericnameforservice_dtls.genericnameforservice_dtls.count.value);
    if(count==tom){

    }else{
    tom=count;
    }
    finalString=formFinalString(fm,tom,"child","bygeneric","association");
    xmlStr=formXMLString(initString,finalString,"bygeneric","association");
    var result=formValidation("bygeneric","association",xmlStr);
    return result;


}


function goNext(source_mode) {
    start = parseInt( start + displaySize ) ;
    end = parseInt( end + displaySize ) ;

    var initString = unescape(document.genericnameforservice_dtls.initString.value) ;
    var finalString="";
    var count_next=1;
    var fm=parseInt(document.genericnameforservice_dtls.start.value);
    var tom=parseInt(document.genericnameforservice_dtls.end.value);
    finalString=formFinalString(fm,tom,"nextprev","byservice",source_mode);
    xmlStr=formXMLString(initString,finalString,"byservice",source_mode);
    var result=formValidation("byservice",source_mode,xmlStr);
    if(source_mode=="association"){
		parent.genericnameforservice_dtls.location.href="../../ePH/jsp/GenericNameForServiceDtlsAssc.jsp?dispMode=fromlink&from="+start+"&to="+end;
    }
    else if(source_mode=="select"){
		var generic_id=document.genericnameforservice_dtls.generic_id.value;   
		parent.genericnameforservice_dtls.location.href="../../ePH/jsp/GenericNameForServiceDetails.jsp?dispMode=fromlink&from="+start+"&to="+end+"&generic_id="+generic_id;
    }
}

function goPrev(source_mode) {
    start = parseInt( start - displaySize ) ;
    end = parseInt( end - displaySize ) ;

    var initString = unescape(document.genericnameforservice_dtls.initString.value) ;
    var finalString="";
    var count_prev=1;

    var fm=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.start.value);
    var tom=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.end.value);

    var count=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.count.value);
    if(count==tom){

    }
	else{
		tom=count;
    }
    finalString=formFinalString(fm,tom,"nextprev","byservice",source_mode);
    xmlStr=formXMLString(initString,finalString,"byservice",source_mode);
    var result=formValidation("byservice",source_mode,xmlStr);
    if(source_mode=="association"){
            parent.genericnameforservice_dtls.location.href="../../ePH/jsp/GenericNameForServiceDtlsAssc.jsp?dispMode=fromlink&from="+start+"&to="+end;
    }
    else if(source_mode=="select"){
        var generic_id=document.genericnameforservice_dtls.generic_id.value;    
		parent.genericnameforservice_dtls.location.href="../../ePH/jsp/GenericNameForServiceDetails.jsp?dispMode=fromlink&from="+start+"&to="+end+"&generic_id="+generic_id;
    }
}


function assignValue(obj){
if(obj.checked)
    obj.value="Y";
else
    obj.value="N";

//alert(obj.checked);
}

function assignEffStatus(obj){
if(obj.checked)
    obj.value="E";
else
    obj.value="D";
}


function assignValueAssociation(obj){

if(obj.checked)
    obj.value="I";
else
    obj.value="DN";
}

function assignEffStatusAssociation(obj){
if(obj.checked)
    obj.value="E";
else
    obj.value="D";
}
function checkIsValidForProceed() {
    var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("genericnameforservicequery")==-1) )
        return true;
    else
        return false;
}


async function apply() {

if(checkIsValidForProceed()){
var frmObj  =   f_query_add_mod.genericnameforservice_dtls.location.href.indexOf(".jsp");
if(frmObj!=-1){
    var formarray = new Array ( f_query_add_mod.genericnameforservice_dtls.document.genericnameforservice_dtls );
    if(f_query_add_mod.genericnameforservice_dtls.genericnameforservice_dtls.choosen_link.value=="select"){
            if(f_query_add_mod.genericnameforservice_dtls.genericnameforservice_dtls.location_ref.value=="byservice"){
                if(pageUpdateApply()){
                    eval( formApply( formarray,PH_CONTROLLER) ) ;
                }
            }
            else{
            	var pageUpdateApplybyGenericResult = await pageUpdateApplybyGeneric();
                if(pageUpdateApplybyGenericResult){
                    eval( formApply( formarray,PH_CONTROLLER) ) ;
                }

            }
        }
        else{
            if(f_query_add_mod.genericnameforservice_dtls.genericnameforservice_dtls.location_ref.value=="byservice"){
            if(pageUpdateAssociationApply()){
                eval( formApply( formarray,PH_CONTROLLER) ) ;
            }
            }
            else{
            if(pageUpdateAssociationApplybyGeneric()){
                eval( formApply( formarray,PH_CONTROLLER) ) ;
            }
            }
        }
        //messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
            if( result ) {
                onSuccess();
            }
            else{
                if(flag=="nochange"){
                    var errormessage  = getMessage("NO_CHANGE_TO_SAVE","Common");
                    messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ errormessage;
                //f_query_add_mod.genericnameforservice_dtls.location.href="../../eCommon/html/blank.html";
                //reset();

                        if(f_query_add_mod.genericnameforservice_dtls.genericnameforservice_dtls.choosen_link.value=="select"){
                        }
                        else{
                        if(f_query_add_mod.genericnameforservice_dtls.genericnameforservice_dtls.location_ref.value=="byservice"){
                        f_query_add_mod.genericnameforservice_dtls.location.href="../../ePH/jsp/GenericNameForServiceDetailsAssociation.jsp";

                        }
                        else{
                            f_query_add_mod.genericnameforservice_dtls.location.href="../../ePH/jsp/GenericNameForServiceDtlsAsscbyGen.jsp";

                        }
                      }


                }

            }

}
else{
//	alert(f_query_add_mod.genericnameforservice_dtls.location.href);
	var formObj = f_query_add_mod.genericnameforservice_header.genericnameforservice_header;

	var fields  = new Array() ;
	var names   = new Array() ;

	var Service = getLabel("Common.service.label","Common");
    var GenericName = getLabel("Common.GenericName.label","Common");
	 
	if(formObj.generic_name == undefined){
		fields[0]   = formObj.service_desc ;
		names[0]   = Service ;
	}else{
		fields[0]   = formObj.generic_name ;
		names[0]   = GenericName;
	}
	messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+checkFlds( fields, names);
}
}
else{
messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
}
}

function checkFlds( fields, names) {
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else{
			errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "\n" ;			
			if(fields[i].disabled==false){
				fields[i].focus();
			}
		}
	}
	if ( errors.length != 0 ) {
		return errors;
	}
}

function assignResult( _result, _message, _flag ) {
    result = _result ;
    message  = _message ;
    flag = _flag ;
}

function onSuccess() {
    messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
    f_query_add_mod.genericnameforservice_header.location.href="../../ePH/jsp/GenericNameForServiceHeader.jsp?from_source="+f_query_add_mod.genericnameforservice_header.genericnameforservice_header.from_source.value;
    f_query_add_mod.genericnameforservice_button.location.href="../../eCommon/html/blank.html";
    f_query_add_mod.genericnameforservice_label.location.href="../../eCommon/html/blank.html";
    f_query_add_mod.genericnameforservice_dtls.location.href="../../eCommon/html/blank.html";
}

function reset() {
if(checkIsValidForProceed()){
var frmObj  =       f_query_add_mod.genericnameforservice_header.location.href.indexOf(".jsp");
if(frmObj !=-1){
f_query_add_mod.genericnameforservice_header.location.href="../../ePH/jsp/GenericNameForServiceHeader.jsp?from_source="+f_query_add_mod.genericnameforservice_header.genericnameforservice_header.from_source.value;
f_query_add_mod.genericnameforservice_button.location.href="../../eCommon/html/blank.html";
f_query_add_mod.genericnameforservice_label.location.href="../../eCommon/html/blank.html";
f_query_add_mod.genericnameforservice_dtls.location.href="../../eCommon/html/blank.html";
}
}   else    {

	if(f_query_add_mod.document.query_form != null)
	    f_query_add_mod.document.query_form.reset();

}

}

function pageUpdatebyGeneric(){
    var initString = unescape(parent.genericnameforservice_dtls.genericnameforservice_dtls.initString.value) ;
    var finalString="";
    var fm=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.start.value);
    var tom=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.end.value);

    var count=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.count.value);
    if(count==tom){

    }else{
    tom=count;
    }
    finalString=formFinalString(fm,tom,"parent","bygeneric","select");
    xmlStr=formXMLString(initString,finalString,"bygeneric","select");
    var result=formValidation("bygeneric","select",xmlStr);
    return result;
}

function pageUpdateAssociationbyGeneric(){
    var initString = unescape(parent.genericnameforservice_dtls.genericnameforservice_dtls.initString.value) ;
    var finalString="";
    var fm=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.start.value);
    var tom=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.end.value);

    var count=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.count.value);
    if(count==tom){

    }else{
    tom=count;
    }
    finalString=formFinalString(fm,tom,"parent","bygeneric","association");
    xmlStr=formXMLString(initString,finalString,"bygeneric","association");
    var result=formValidation("bygeneric","association",xmlStr);
    return result;

}

function goNextbyGeneric(source_mode) {
    start = parseInt( start + displaySize ) ;
    end = parseInt( end + displaySize ) ;
    var initString = unescape(document.genericnameforservice_dtls.initString.value) ;
    var finalString="";
    var count_next=1;
    var fm=parseInt(document.genericnameforservice_dtls.start.value);
    var tom=parseInt(document.genericnameforservice_dtls.end.value);
    finalString=formFinalString(fm,tom,"nextprev","bygeneric",source_mode);
    xmlStr=formXMLString(initString,finalString,"bygeneric",source_mode);
    var result=formValidation("bygeneric",source_mode,xmlStr);
    if(source_mode=="association"){
        parent.genericnameforservice_dtls.location.href="../../ePH/jsp/GenericNameForServiceDtlsAsscbyGen.jsp?dispMode=fromlink&from="+start+"&to="+end;
    }
    else if(source_mode=="select"){
        parent.genericnameforservice_dtls.location.href="../../ePH/jsp/GenericNameForServiceDtlsbyGen.jsp?dispMode=fromlink&from="+start+"&to="+end;
    }
}

function goPrevbyGeneric(source_mode) {
    start = parseInt( start - displaySize ) ;
    end = parseInt( end - displaySize ) ;
    var initString = unescape(document.genericnameforservice_dtls.initString.value) ;
    var finalString="";
    var count_prev=1;

    var fm=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.start.value);
    var tom=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.end.value);

    var count=parseInt(parent.genericnameforservice_dtls.genericnameforservice_dtls.count.value);
    if(count==tom){

    }else{
    tom=count;
    }
    finalString=formFinalString(fm,tom,"nextprev","bygeneric",source_mode);
    xmlStr=formXMLString(initString,finalString,"bygeneric",source_mode);
    var result=formValidation("bygeneric",source_mode,xmlStr);

    if(source_mode=="association"){
        parent.genericnameforservice_dtls.location.href="../../ePH/jsp/GenericNameForServiceDtlsAsscbyGen.jsp?dispMode=fromlink&from="+start+"&to="+end;
    }
    else if(source_mode=="select"){
        parent.genericnameforservice_dtls.location.href="../../ePH/jsp/GenericNameForServiceDtlsbyGen.jsp?dispMode=fromlink&from="+start+"&to="+end;
            }
}

function changeCursor(obj) {
    obj.style.cursor = "pointer" ;
}


function formFinalString(fm,tom,pos_ref,source,mode){
    var count_page  =1;
    var finalString ="";
    var form_position="genericnameforservice_dtls.genericnameforservice_dtls";
    if(pos_ref=="parent"){
            var val1_frame  ="parent."+form_position+".eff_status";
                if(mode=="select"){
                    var val2_frame  ="parent."+form_position+".process";
                }
                else if(mode=="association"){
                    var val2_frame  ="parent."+form_position+".oper_mode";
                }
                if(source=="byservice"){
                    var val3_frame  ="parent."+form_position+".generic_id";
                    var val4_frame  ="parent."+form_position+".generic_name";
                }
                else if(source=="bygeneric"){
                    var val3_frame  ="parent."+form_position+".service_code";
                    if(mode=="select"){
                    var val4_frame  ="parent."+form_position+".service_desc";
                    }else if(mode=="association"){
                    var val4_frame  ="parent."+form_position+".short_desc";
                    }
                }

    }
    else if(pos_ref=="child"){
            var val1_frame  ="f_query_add_mod."+form_position+".eff_status";
                if(mode=="select"){
                    var val2_frame  ="f_query_add_mod."+form_position+".process";
                }
                else if(mode=="association"){
                    var val2_frame  ="f_query_add_mod."+form_position+".oper_mode";
                }
                if(source=="byservice"){
                    var val3_frame  ="f_query_add_mod."+form_position+".generic_id";
                    var val4_frame  ="f_query_add_mod."+form_position+".generic_name";
                }
                else if(source=="bygeneric"){
                    var val3_frame  ="f_query_add_mod."+form_position+".service_code";
                    if(mode=="select"){
                    var val4_frame  ="f_query_add_mod."+form_position+".service_desc";
                    }else if(mode=="association"){
                    var val4_frame  ="f_query_add_mod."+form_position+".short_desc";
                    }
                }
    }
    else if(pos_ref=="nextprev"){
            var val1_frame  ="document.genericnameforservice_dtls.eff_status";
                if(mode=="select"){
                    var val2_frame  ="document.genericnameforservice_dtls.process";
                }
                else if(mode=="association"){
                    var val2_frame  ="document.genericnameforservice_dtls.oper_mode";
                }
                if(source=="byservice"){
                    var val3_frame  ="document.genericnameforservice_dtls.generic_id";
                    var val4_frame  ="document.genericnameforservice_dtls.generic_name";
                }
                else if(source=="bygeneric"){
                    var val3_frame  ="document.genericnameforservice_dtls.service_code";
                    if(mode=="select"){
                    var val4_frame  ="document.genericnameforservice_dtls.service_desc";
                    }else if(mode=="association"){
                    var val4_frame  ="document.genericnameforservice_dtls.short_desc";
                    }
                }
    }
    for(var i=fm;i<tom;i++){
    var val1 = eval(val1_frame+i);
    var val2 = eval(val2_frame+i);
    var val3 = eval(val3_frame+i);
    var val4 = eval(val4_frame+i);
    if(! (val1==undefined && val2==undefined && val3==undefined && val4==undefined) ){
        if(count_page==1){
        finalString=val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value;
        }
        else{
        finalString+="~"+val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value;
        }
    }
    count_page++;
    }
    //alert("FINAL STRING :"+finalString);
    //alert(finalString);
    return finalString;

}

function formXMLString(initString,finalString,source,mode){
    var init_string=new Array();
    var final_string=new Array();

    init_string=initString.split("~");
    final_string=finalString.split("~");
    var xmlStr ="<root><SEARCH ";

    for(var i=0;i<final_string.length;i++){
        var sep_init_string=new Array();
        var sep_final_string=new Array();
        sep_init_string=init_string[i].split("|");
//alert(final_string[i]);
        sep_final_string=final_string[i].split("|");
            if( ((sep_init_string[1]) == (sep_final_string[1])) && ((sep_init_string[0]) == (sep_final_string[0]))  ){

            }
            else{

                if(source=="byservice"){
                    xmlStr += " GENERIC_NAME"+i+"=\""+ checkSplChar((sep_init_string[3])) + "\" ";
                    xmlStr += " GENERIC_CODE"+i+"=\""+ (sep_final_string[2]) + "\" ";
                }
                else if(source=="bygeneric"){
                    xmlStr += " SHORT_DESC"+i+"=\""+ checkSplChar((sep_init_string[3])) + "\" ";
                    xmlStr += " SERVICE_CODE"+i+"=\""+ (sep_final_string[2]) + "\" ";
                }

                    xmlStr += " EFF_STATUS"+i+"=\""+ (sep_final_string[0])+"\"";

                if(mode=="association"){
                    xmlStr += " OPER_MODE"+i+"=\""+ (sep_final_string[1])+"\"";
                }
                else if(mode=="select"){
                    xmlStr += " PROCESS"+i+"=\""+ (sep_final_string[1])+"\"";
                }
        }
    }
    xmlStr +=" /></root>";
    //alert(xmlStr);


return xmlStr;

}

function formValidation(source,mode,xmlStr){
    var temp_jsp="";

    if(source=="bygeneric"){
        if(mode=="association"){
            temp_jsp="GenericNameForServiceValidationAG.jsp";
        }
        else if(mode=="select"){
            temp_jsp="GenericNameForServiceValidationGen.jsp";
        }

    }else if(source=="byservice"){
        if(mode=="association"){
            temp_jsp="GenericNameForServiceValidationAssc.jsp";
        }
        else if(mode=="select"){
            temp_jsp="GenericNameForServiceValidation.jsp";
        }

    }
    //alert(temp_jsp);
    var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST",temp_jsp,false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
//  alert(responseText);
    return true;

}

async function populate_generic_details(generic_id){

    var dialogHeight= "80vh" ;
    var dialogWidth = "90vw" ;
    var dialogTop = "10" ;
    var center = "1" ;
    var status="no";
    var scrolling="auto";
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop +";scroll:"+scrolling;
    var arguments   = "" ;
    retVal = await window.showModalDialog("../../ePH/jsp/GenericNameForServiceViewFrames.jsp?generic_id="+generic_id,arguments,features);
}


async function searchCode( target ) {
	
    parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
    var argumentArray  = new Array() ;
    var dataNameArray  = new Array() ;
    var dataValueArray = new Array() ;
    var dataTypeArray  = new Array() ;

    if(target.name=="service_desc"){
        if(document.genericnameforservice_header.choose_service[0].checked){
                var id  = document.forms[0].locale.value;
                dataNameArray[0]   = "facility_id" ;
                dataValueArray[0]  = document.genericnameforservice_header.facility_id.value;
                dataTypeArray[0]   = STRING ;
                argumentArray[0]  = document.genericnameforservice_header.sql_ph_am_service_select_lookup.value+"'"+id+"' ORDER BY 2";
			    argumentArray[4]   = "2,3";

        }else{
                var id  = document.forms[0].locale.value;
                argumentArray[0]  = document.genericnameforservice_header.sql_ph_am_service_ip_op_lookup.value+"'"+id+"' ORDER BY 2";
				argumentArray[4]   = "1,2";

        }
    }
    else if(target.name=="generic_name"){
		
	var language_id  = document.forms[0].locale.value;
			
		//dataNameArray[0]   = "facility_id" ;
        //dataValueArray[0]  = document.genericnameforservice_header.facility_id.value;
        //dataTypeArray[0]   = STRING ;
		

        argumentArray[0]   = document.genericnameforservice_header.sql_ph_generic_name_select_lookup.value+"'"+language_id+"' ORDER BY 2";
        argumentArray[4]   = "1,2";
    }
	

    argumentArray[1]   = dataNameArray ;
    argumentArray[2]   = dataValueArray ;
    argumentArray[3]   = dataTypeArray ;
    argumentArray[5]   = target.value ;
    argumentArray[6]   = DESC_LINK ;
    argumentArray[7]   = DESC_CODE ;

    if(target.name=="service_desc"){
        if(!document.genericnameforservice_header.service_desc.readOnly){
            retVal = await CommonLookup( "Service Name", argumentArray );
			var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
        }else{
        retVal="";
        }
    }
    if(target.name=="generic_name"){
        if(!document.genericnameforservice_header.generic_name.readOnly){
            retVal = await CommonLookup( "Generic Name", argumentArray );
            var ret1=unescape(retVal);
        	//alert("ret1"+ret1);
        		 	var arr=ret1.split(",");
        		 	if(arr[1]==undefined) 
        	 		{
        		 		arr[0]="";	
        		 		arr[1]="";	
        	 		}
        }
        else{
        retVal="";
        }
    }

    if(retVal != null && retVal != "" )  {
        target.value = arr[1] ;
        if(target.name=="service_desc"){
			//alert("service_desc");
        document.genericnameforservice_header.service_code.value=arr[0];
        document.genericnameforservice_header.serviceCodeSearch.disabled=true;
        document.genericnameforservice_header.service_desc.readOnly=true;
        populateSearchCode(document.genericnameforservice_header.service_code);
        document.genericnameforservice_header.choose_service[1].disabled=true;
        document.genericnameforservice_header.choose_service[0].disabled=true;
        }
        else if(target.name=="generic_name"){
			//alert("generic_name");
        document.genericnameforservice_header.generic_id.value=arr[0];
        document.genericnameforservice_header.genericIdSearch.disabled=true;
        document.genericnameforservice_header.generic_name.readOnly=true;
        populateGenericCode(document.genericnameforservice_header.generic_id);
        }
 }
}
