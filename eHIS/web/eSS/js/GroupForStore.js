/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
 var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;
var start = 0 ;
var end   = 0 ;
var maxRec = 0  ;
var displaySize = 0 ;
var firstTime	= true;6

function create() {
	f_query_add_mod.location.href="../../eSS/jsp/GroupForStoreFrame.jsp";
	

}

function query() {
	f_query_add_mod.location.href="../../eSS/jsp/GroupForStoreQueryCriteria.jsp?function_id="+function_id;
}


async function searchCode( target ) {


	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	
	if(target.name=="store_desc"){
		dataNameArray[0]   = "facility_id" ;
		dataValueArray[0]  = document.groupforstore_header.facility_id.value;
		dataTypeArray[0]   = STRING ;
		argumentArray[0]   = document.groupforstore_header.sql_ss_group_for_store_store_lookup.value;
		argumentArray[4]   = "2,3";
	}
	else if(target.name=="group_name"){

		argumentArray[0]   = document.groupforstore_header.sql_ss_group_for_store_group_lookup.value;
		
		argumentArray[4]   = "1,2";
	}
	
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[5]   = target.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 

	if(target.name=="store_desc"){
		if(!document.groupforstore_header.store_desc.readOnly){
			retVal = CommonLookup(getLabel( "eSS.Store.label","SS"), argumentArray );
		}else{
		retVal="";
		}
	}
	if(target.name=="group_name"){
		if(!document.groupforstore_header.group_name.readOnly){
			retVal = await CommonLookup( getLabel( "Common.Group.label","Common"), argumentArray );
		}
		else{
		retVal="";
		}
	}
	
	if(retVal != null && retVal != "" )  {
		
		if(retVal.length === 1){
			retVal = retVal[0].split(',');
		}
		target.value = retVal[1] ;
		if(target.name=="store_desc"){
		
		document.groupforstore_header.store_code.value=retVal[0];
		document.groupforstore_header.storeCodeSearch.disabled=true;
		document.groupforstore_header.store_desc.readOnly=true;
		populateSearchCode(document.groupforstore_header.store_code);
		}
		else if(target.name=="group_name"){
		document.groupforstore_header.group_code.value=retVal[0];
		document.groupforstore_header.groupCodeSearch.disabled=true;
		document.groupforstore_header.group_name.readOnly=true;
		populateGenericCode(document.groupforstore_header.group_code);
		}
	} 
	
	
}

function callByGroup(obj){
	document.groupforstore_tab.all.store.src='../../eSS/images/By_Store.gif';
	document.groupforstore_tab.all.group.src='../../eSS/images/By_Group.gif';

	parent.groupforstore_header.location.href="../../eSS/jsp/GroupForStoreHeader.jsp?from_source=bygroup";
	parent.groupforstore_button.location.href="../../eCommon/html/blank.html";
	parent.groupforstore_label.location.href="../../eCommon/html/blank.html";
	parent.groupforstore_dtls.location.href="../../eCommon/html/blank.html";
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
}

//call the service header jsp
function callByStore(){

document.groupforstore_tab.all.store.src='../../eSS/images/By_Store.gif';
document.groupforstore_tab.all.group.src='../../eSS/images/By_Group_click.gif';

parent.groupforstore_label.location.href="../../eCommon/html/blank.html";
parent.groupforstore_dtls.location.href="../../eCommon/html/blank.html";
parent.groupforstore_button.location.href="../../eCommon/html/blank.html";
parent.groupforstore_header.location.href="../../eSS/jsp/GroupForStoreHeader.jsp?from_source=bystore";
parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	
		
}



function populateSearchCode(obj){

	if(obj.value==''){
		obj.focus();
	}
	else{
		parent.groupforstore_button.location.href="../../eSS/jsp/GroupForStoreButton.jsp?from_source=bystore&store_code="+obj.value;
		
		
		parent.groupforstore_dtls.location.href="../../eCommon/html/blank.html";
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}
}

function populateGenericCode(obj){
	if(obj.value==''){
		obj.focus();
	}
	else{
		parent.groupforstore_button.location.href="../../eSS/jsp/GroupForStoreButton.jsp?from_source=bygroup&group_code="+obj.value;
		
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}
}


function populateGenericName(){
	parent.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetails.jsp";
}

//on click of select or association links
function Display(from,code) 
{	
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";

	if(code=="bystore"){
			//from select
			var frmObj	=		parent.groupforstore_dtls.location.href.indexOf(".jsp");
		
			if(from == "1")
			{
				if(frmObj!=-1){
					if(parent.groupforstore_dtls.groupforstore_dtls.choosen_link.value=="association"){
						parent.groupforstore_dtls.groupforstore_dtls.choosen_link.value="select";
						
						document.getElementById("select_col").className="clicked";
						
						document.getElementById("association_col").className="normal";
						if(pageUpdateAssociation()){
							parent.groupforstore_label.location.href="../../eSS/jsp/GroupForStoreLabel.jsp";
							parent.groupforstore_dtls.location.href="../../eCommon/html/blank.html";
						}
					 }
				}
				else{
					
				}
			}//from association.
			else if(from == "2")
			{

				if(frmObj!=-1){
					if(parent.groupforstore_dtls.groupforstore_dtls.choosen_link.value=="select"){
						parent.groupforstore_dtls.groupforstore_dtls.choosen_link.value="association";
						
						document.getElementById("select_col").className="normal";
						
						document.getElementById("association_col").className="clicked";
						
						if(pageUpdate()){	
							parent.groupforstore_label.location.href="../../eCommon/html/blank.html";
							parent.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetailsAssociation.jsp?call_mode=association";
						}
					}
				}
				else{
					
					document.getElementById("select_col").className="normal";
					
					document.getElementById("association_col").className="clicked";
					parent.groupforstore_label.location.href="../../eCommon/html/blank.html";

					parent.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetailsAssociation.jsp?call_mode=association";
			}
		}

	}else{	// by group
		if(from == "1")	{
		
			if(parent.groupforstore_dtls.groupforstore_dtls.choosen_link.value=="association"){
				parent.groupforstore_dtls.groupforstore_dtls.choosen_link.value="select";
				
				document.getElementById("select_col").className="clicked";
				
				document.getElementById("association_col").className="normal";
				
				if(pageUpdateAssociationbyGroup()){
					parent.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetailsbyGroup.jsp?call_mode=select";
				}
			}
		}
		else if(from == "2"){
			if(parent.groupforstore_dtls.groupforstore_dtls.choosen_link.value=="select"){
				parent.groupforstore_dtls.groupforstore_dtls.choosen_link.value="association";
				
				document.getElementById("select_col").className="normal";				
			
				document.getElementById("association_col").className="clicked";
				if(pageUpdatebyGroup()){	
				
					parent.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetailsAssociationbyGroup.jsp?call_mode=association";
				}
			}
		}
	}
}


function pageUpdateAssociationbyGroup(){

	var initString = unescape(parent.groupforstore_dtls.groupforstore_dtls.initString.value) ;
	var finalString="";
	var fm=parseInt(parent.groupforstore_dtls.groupforstore_dtls.start.value);
	var tom=parseInt(parent.groupforstore_dtls.groupforstore_dtls.end.value);

	var count=parseInt(parent.groupforstore_dtls.groupforstore_dtls.count.value);
	if(count==tom){
	
	}else{
	tom=count;
	} 
	finalString=formFinalString(fm,tom,"parent","bygroup","association");
	xmlStr=formXMLString(initString,finalString,"bygroup","association");
	var result=formValidation("bygroup","association",xmlStr);

	return result;

}

function callDetailsPage(){

parent.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetailsbyGroup.jsp?call_mode=load";
}

function pageUpdatebyGroup(){
	var initString = unescape(parent.groupforstore_dtls.groupforstore_dtls.initString.value) ;
	var finalString="";
	var fm=parseInt(parent.groupforstore_dtls.groupforstore_dtls.start.value);
	var tom=parseInt(parent.groupforstore_dtls.groupforstore_dtls.end.value);

	var count=parseInt(parent.groupforstore_dtls.groupforstore_dtls.count.value);
	
	if(count==tom){
	
	}else{
	tom=count;
	} 
	
	finalString=formFinalString(fm,tom,"parent","bygroup","select");
	xmlStr=formXMLString(initString,finalString,"bygroup","select");
	var result=formValidation("bygroup","select",xmlStr);
	
	
	return result;
}
function formFinalString(fm,tom,pos_ref,source,mode){

	var count_page	=1;
	var finalString	="";
	var form_position="groupforstore_dtls.groupforstore_dtls";
	if(pos_ref=="parent"){
			var val1_frame	="parent."+form_position+".eff_status";
				if(mode=="select"){
					var val2_frame	="parent."+form_position+".process";
				}
				else if(mode=="association"){
					var val2_frame	="parent."+form_position+".oper_mode";
				}
				if(source=="bystore"){
					var val3_frame	="parent."+form_position+".group_id";
					var val4_frame	="parent."+form_position+".group_name";
				}
				else if(source=="bygroup"){
					var val3_frame	="parent."+form_position+".store_code";
					if(mode=="select"){
					var val4_frame	="parent."+form_position+".store_desc";
					}else if(mode=="association"){
					var val4_frame	="parent."+form_position+".short_desc";
					}
					var val5_frame	="parent."+form_position+".min_qty";
					var val6_frame	="parent."+form_position+".reorder_qty";
				}
	
	}
	else if(pos_ref=="child"){
			var val1_frame	="f_query_add_mod."+form_position+".eff_status";
				if(mode=="select"){
					var val2_frame	="f_query_add_mod."+form_position+".process";
				}
				else if(mode=="association"){
					var val2_frame	="f_query_add_mod."+form_position+".oper_mode";
				}
				if(source=="bystore"){
					var val3_frame	="f_query_add_mod."+form_position+".group_id";
					var val4_frame	="f_query_add_mod."+form_position+".group_name";
				}
				else if(source=="bygroup"){
					var val3_frame	="f_query_add_mod."+form_position+".store_code";
					if(mode=="select"){
					var val4_frame	="f_query_add_mod."+form_position+".store_desc";
					}else if(mode=="association"){
					var val4_frame	="f_query_add_mod."+form_position+".short_desc";
					}
					var val5_frame	="f_query_add_mod."+form_position+".min_qty";
					var val6_frame	="f_query_add_mod."+form_position+".reorder_qty";
				}
	}
	else if(pos_ref=="nextprev"){
			var val1_frame	="document.groupforstore_dtls.eff_status";
				if(mode=="select"){
					var val2_frame	="document.groupforstore_dtls.process";
				}
				else if(mode=="association"){
					var val2_frame	="document.groupforstore_dtls.oper_mode";
				}
				if(source=="bystore"){
					var val3_frame	="document.groupforstore_dtls.group_code";
					var val4_frame	="document.groupforstore_dtls.group_name";
				}
				else if(source=="bygroup"){
					var val3_frame	="document.groupforstore_dtls.store_code";
					if(mode=="select"){
					var val4_frame	="document.groupforstore_dtls.store_desc";
					}else if(mode=="association"){
					var val4_frame	="document.groupforstore_dtls.short_desc";
					}
					var val5_frame	="document.groupforstore_dtls.min_qty";
					var val6_frame	="document.groupforstore_dtls.reorder_qty";
				}
	}
	
	
	for(var i=fm;i<tom;i++){
	var val1 = eval(val1_frame+i);
	var val2 = eval(val2_frame+i);
	var val3 = eval(val3_frame+i);
	var val4 = eval(val4_frame+i);
	var val5 = eval(val5_frame+i);
	var val6 = eval(val6_frame+i);
	
	if(count_page==1){
	finalString=val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value+"|"+val5.value+"|"+val6.value;
	
	}
	else{
	finalString+="~"+val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value+"|"+val5.value+"|"+val6.value;
	}
	count_page++;
	
	}
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
		sep_final_string=final_string[i].split("|");
		
	//	alert("sep_init_string[4] = "+sep_init_string[4] +" sep_final_string[4] = "+sep_final_string[4]);
		
			
	/*		if( ((sep_init_string[1]) == (sep_final_string[1])) && ((sep_init_string[0]) == (sep_final_string[0])) && ((sep_init_string[4]) == (sep_final_string[4]))  ){
		//	if( ((sep_init_string[1]) == (sep_final_string[1])) && ((sep_init_string[0]) == (sep_final_string[0]))   ){
			}
			else{
				
				if(source=="bystore"){
					xmlStr += " GROUP_NAME"+i+"=\""+ checkSplChar((sep_init_string[3])) + "\" ";
					xmlStr += " GROUP_CODE"+i+"=\""+ (sep_final_string[2]) + "\" ";
				}
				else if(source=="bygroup"){
					xmlStr += " SHORT_DESC"+i+"=\""+ checkSplChar((sep_init_string[3])) + "\" ";
					xmlStr += " STORE_CODE"+i+"=\""+ (sep_final_string[2]) + "\" ";
				}
			
					xmlStr += " EFF_STATUS"+i+"=\""+ (sep_final_string[0])+"\"";
		
				if(mode=="association"){
					xmlStr += " OPER_MODE"+i+"=\""+ (sep_final_string[1])+"\"";
				}
				else if(mode=="select"){
					xmlStr += " PROCESS"+i+"=\""+ (sep_final_string[1])+"\"";
				}
				xmlStr += " MIN_QTY"+i+"=\""+ (sep_final_string[4])+"\"";
			}
		*/

		if( mode == "association" ){
			if( ((sep_init_string[1]) == (sep_final_string[1])) && ((sep_init_string[0]) == (sep_final_string[0])) && ((sep_init_string[4]) == (sep_final_string[4])) && ((sep_init_string[5]) == (sep_final_string[5]))  ){
				
			}else{
				if(source=="bystore"){
					xmlStr += " GROUP_NAME"+i+"=\""+ checkSplChar((sep_init_string[3])) + "\" ";
					xmlStr += " GROUP_CODE"+i+"=\""+ (sep_final_string[2]) + "\" ";
				}
				else if(source=="bygroup"){
					xmlStr += " SHORT_DESC"+i+"=\""+ checkSplChar((sep_init_string[3])) + "\" ";
					xmlStr += " STORE_CODE"+i+"=\""+ (sep_final_string[2]) + "\" ";
				}
			
					xmlStr += " EFF_STATUS"+i+"=\""+ (sep_final_string[0])+"\"";
		
				if(mode=="association"){
					xmlStr += " OPER_MODE"+i+"=\""+ (sep_final_string[1])+"\"";
				}
				else if(mode=="select"){
					xmlStr += " PROCESS"+i+"=\""+ (sep_final_string[1])+"\"";
				}
				xmlStr += " MIN_QTY"+i+"=\""+ (sep_final_string[4])+"\"";
				xmlStr += " REORDER_QTY"+i+"=\""+ (sep_final_string[5])+"\"";
			}
		}else if( mode == "select" ){
		
			if(sep_final_string[4] != ""){
			 if( ((sep_init_string[1]) == (sep_final_string[1])) && ((sep_init_string[0]) == (sep_final_string[0])) && ((sep_init_string[4]) == (sep_final_string[4])) && ((sep_init_string[5]) == (sep_final_string[5]))  ){
				
			}else{
				if(source=="bystore"){
					xmlStr += " GROUP_NAME"+i+"=\""+ checkSplChar((sep_init_string[3])) + "\" ";
					xmlStr += " GROUP_CODE"+i+"=\""+ (sep_final_string[2]) + "\" ";
				}
				else if(source=="bygroup"){
					xmlStr += " SHORT_DESC"+i+"=\""+ checkSplChar((sep_init_string[3])) + "\" ";
					xmlStr += " STORE_CODE"+i+"=\""+ (sep_final_string[2]) + "\" ";
				}
			
					xmlStr += " EFF_STATUS"+i+"=\""+ (sep_final_string[0])+"\"";
		
				if(mode=="association"){
					xmlStr += " OPER_MODE"+i+"=\""+ (sep_final_string[1])+"\"";
				}
				else if(mode=="select"){
					xmlStr += " PROCESS"+i+"=\""+ (sep_final_string[1])+"\"";
				}
				xmlStr += " MIN_QTY"+i+"=\""+ (sep_final_string[4])+"\"";
				xmlStr += " REORDER_QTY"+i+"=\""+ (sep_final_string[5])+"\"";
			}
			 
			
			}else{
		
				
						
			if( ((sep_init_string[1]) == (sep_final_string[1])) && ((sep_init_string[0]) == (sep_final_string[0])) ){
			//alert("1");
			
			}
			else{
				//alert("2");
				if(source=="bystore"){
					xmlStr += " GROUP_NAME"+i+"=\""+ checkSplChar((sep_init_string[3])) + "\" ";
					xmlStr += " GROUP_CODE"+i+"=\""+ (sep_final_string[2]) + "\" ";
				}
				else if(source=="bygroup"){
					xmlStr += " SHORT_DESC"+i+"=\""+ checkSplChar((sep_init_string[3])) + "\" ";
					xmlStr += " STORE_CODE"+i+"=\""+ (sep_final_string[2]) + "\" ";
				}
			
					xmlStr += " EFF_STATUS"+i+"=\""+ (sep_final_string[0])+"\"";
		
				if(mode=="association"){
					xmlStr += " OPER_MODE"+i+"=\""+ (sep_final_string[1])+"\"";
				}
				else if(mode=="select"){
					xmlStr += " PROCESS"+i+"=\""+ (sep_final_string[1])+"\"";
				}
				xmlStr += " MIN_QTY"+i+"=\""+ (sep_final_string[4])+"\"";
				xmlStr += " REORDER_QTY"+i+"=\""+ (sep_final_string[5])+"\"";
			}
		}
		}
		
		
	}
	
	xmlStr +=" /></root>";
	
return xmlStr;

}

function formValidation(source,mode,xmlStr){
	var temp_jsp="";

	if(source=="bygroup"){
		if(mode=="association"){
		
			temp_jsp="GroupForStoreValidationAssociationGroup.jsp";
		}
		else if(mode=="select"){
		
			temp_jsp="GroupForStoreValidationGroup.jsp";
		}
	
	}else if(source=="bystore"){
		if(mode=="association"){
			temp_jsp="GroupForStoreValidationAssociation.jsp";
		}
		else if(mode=="select"){
			temp_jsp="GroupForStoreValidation.jsp";
		}
	
	}
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	return true;

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
	if ( (url.indexOf("blank.html")==-1) && (url.indexOf("groupforstorequery")==-1) )
		return true;
	else
		return false;
}


function callGroupBean(group_id,obj){
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";

	if(obj=="celloth"){
		
		celloth.className="clicked";
			for(var i=0;i<=25;i++){
				var cell =eval("cell"+i);
				cell.className="normal";
			}
	}
	else{
		for(var i=0;i<=25;i++){
			var obj=eval(obj);
			var cell =eval("cell"+i);
				if(obj==cell){	
					obj.className="clicked";
				}
				else{
					cell.className="normal";
				}
	celloth.className="normal";
	}
}

if(firstTime )	{
parent.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetails.jsp?call_mode=select&group_code="+group_code+"&mode="+MODE_INSERT;
firstTime=false;
}
else
	{
	  if(pageUpdate()){	 parent.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetails.jsp?call_mode=select&group_code="+group_code+"&mode="+MODE_INSERT;
	 }

	}
}

function callLabelPage(store_code){

parent.groupforstore_label.location.href="../../eSS/jsp/GroupForStoreLabel.jsp?store_code="+store_code;
}

function activeLink() {
	if( start != 0 ){
		document.getElementById("prev").style.visibility='visible';
	}
	else{
	document.getElementById("prev").style.visibility='hidden';
	}

	if( end >= maxRec )
		document.getElementById("next").style.visibility='hidden';
	else
		document.getElementById("next").style.visibility='visible';
}

function pageUpdate(){
	
	var finalString="";
	var initString = unescape(parent.groupforstore_dtls.groupforstore_dtls.initString.value) ;
	var fm=parseInt(parent.groupforstore_dtls.groupforstore_dtls.start.value);
	var tom=parseInt(parent.groupforstore_dtls.groupforstore_dtls.end.value);

	var count=parseInt(parent.groupforstore_dtls.groupforstore_dtls.count.value);
	if(count==tom){
	
	}else{
	tom=count;
	} 
	finalString=formFinalString(fm,tom,"parent","bystore","select");
	xmlStr=formXMLString(initString,finalString,"bystore","select");
	var result=formValidation("bystore","select",xmlStr);
	return result;
	
}
function pageUpdateApply(){
	var initString = unescape(f_query_add_mod.groupforstore_dtls.groupforstore_dtls.initString.value );
	var finalString="";
	var fm=parseInt(f_query_add_mod.groupforstore_dtls.groupforstore_dtls.start.value);
	var tom=parseInt(f_query_add_mod.groupforstore_dtls.groupforstore_dtls.end.value);

	var count=parseInt(f_query_add_mod.groupforstore_dtls.groupforstore_dtls.count.value);
	if(count==tom){
	
	}else{
	tom=count;
	} 
	finalString=formFinalString(fm,tom,"child","bystore","select");
	xmlStr=formXMLString(initString,finalString,"bystore","select");
	var result=formValidation("bystore","select",xmlStr);
	return result;
	
	
}
function pageUpdateApplybyGeneric(){
	var initString = unescape(f_query_add_mod.groupforstore_dtls.groupforstore_dtls.initString.value );
	var finalString="";
	var fm=parseInt(f_query_add_mod.groupforstore_dtls.groupforstore_dtls.start.value);
	var tom=parseInt(f_query_add_mod.groupforstore_dtls.groupforstore_dtls.end.value);

	var count=parseInt(f_query_add_mod.groupforstore_dtls.groupforstore_dtls.count.value);
	if(count==tom){
	
	}else{
	tom=count;
	} 
	finalString=formFinalString(fm,tom,"child","bygroup","select");
	xmlStr=formXMLString(initString,finalString,"bygroup","select");
	var result=formValidation("bygroup","select",xmlStr);
	return result;
	
}
function pageUpdateAssociation(){
	var initString = unescape(parent.groupforstore_dtls.groupforstore_dtls.initString.value) ;
	var finalString="";
	var fm=parseInt(parent.groupforstore_dtls.groupforstore_dtls.start.value);
	var tom=parseInt(parent.groupforstore_dtls.groupforstore_dtls.end.value);

	var count=parseInt(parent.groupforstore_dtls.groupforstore_dtls.count.value);
	if(count==tom){
	
	}else{
	tom=count;
	} 
	finalString=formFinalString(fm,tom,"parent","bystore","association");
	xmlStr=formXMLString(initString,finalString,"bystore","association");
	var result=formValidation("bystore","association",xmlStr);
	return result;
	
}
function pageUpdateAssociationApply(){
		
	var initString = unescape(f_query_add_mod.groupforstore_dtls.groupforstore_dtls.initString.value );
	var finalString="";
	var fm=parseInt(f_query_add_mod.groupforstore_dtls.groupforstore_dtls.start.value);
	var tom=parseInt(f_query_add_mod.groupforstore_dtls.groupforstore_dtls.end.value);

	var count=parseInt(f_query_add_mod.groupforstore_dtls.groupforstore_dtls.count.value);
	if(count==tom){
	
	}else{
	tom=count;
	} 
	finalString=formFinalString(fm,tom,"child","bystore","association");
		
	xmlStr=formXMLString(initString,finalString,"bystore","association");
	var result=formValidation("bystore","association",xmlStr);
	return result;
	
}
function pageUpdateAssociationApplybyGeneric(){
	
	var initString = unescape(f_query_add_mod.groupforstore_dtls.groupforstore_dtls.initString.value );
	var finalString="";
	var fm=parseInt(f_query_add_mod.groupforstore_dtls.groupforstore_dtls.start.value);
	var tom=parseInt(f_query_add_mod.groupforstore_dtls.groupforstore_dtls.end.value);

	var count=parseInt(f_query_add_mod.groupforstore_dtls.groupforstore_dtls.count.value);
	if(count==tom){
	
	}else{
	tom=count;
	} 
	finalString=formFinalString(fm,tom,"child","bygroup","association");
	xmlStr=formXMLString(initString,finalString,"bygroup","association");
	var result=formValidation("bygroup","association",xmlStr);
	return result;
	
	
}


function goNext(source_mode) {

	start = parseInt( start + displaySize ) ;
	end = parseInt( end + displaySize ) ;
	
	var initString = unescape(document.groupforstore_dtls.initString.value) ;
	var finalString="";
	var count_next=1;
	var fm=parseInt(document.groupforstore_dtls.start.value);
	var tom=parseInt(document.groupforstore_dtls.end.value);
	finalString=formFinalString(fm,tom,"nextprev","bystore",source_mode);
	xmlStr=formXMLString(initString,finalString,"bystore",source_mode);
	var result=formValidation("bystore",source_mode,xmlStr);
	if(source_mode=="association"){
	parent.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetailsAssociation.jsp?dispMode=fromlink&from="+start+"&to="+end;
	}
	else if(source_mode=="select"){
	var group_id=document.groupforstore_dtls.group_id.value;	parent.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetails.jsp?dispMode=fromlink&from="+start+"&to="+end+"&group_id="+group_id;
	}
}	

function goPrev(source_mode) {
	start = parseInt( start - displaySize ) ;
	end = parseInt( end - displaySize ) ;
	
	var initString = unescape(document.groupforstore_dtls.initString.value) ;
	var finalString="";
	var count_prev=1;

	var fm=parseInt(parent.groupforstore_dtls.groupforstore_dtls.start.value);
	var tom=parseInt(parent.groupforstore_dtls.groupforstore_dtls.end.value);

	var count=parseInt(parent.groupforstore_dtls.groupforstore_dtls.count.value);
	if(count==tom){
	
	}else{
	tom=count;
	} 
	finalString=formFinalString(fm,tom,"nextprev","bystore",source_mode);
	xmlStr=formXMLString(initString,finalString,"bystore",source_mode);
	var result=formValidation("bystore",source_mode,xmlStr);
	if(source_mode=="association"){
			parent.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetailsAssociation.jsp?dispMode=fromlink&from="+start+"&to="+end;
	}
	else if(source_mode=="select"){
		var group_id=document.groupforstore_dtls.group_id.value;	parent.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetails.jsp?dispMode=fromlink&from="+start+"&to="+end+"&group_id="+group_id;
	}
}	


function apply() {
var errorPage = "../../eCommon/jsp/error.jsp";
messageFrame.location.href = errorPage+"?err_num=";
var formObjHeader=  f_query_add_mod.frames[1].document.forms[0];


var fields = new Array ( formObjHeader.group_name);
	var names  =  new Array ( getLabel("Common.GroupName.label","Common"));
	var obj    =null;
	obj=getBlankField( fields, names, messageFrame,errorPage);
	
	if(obj==null) {
		
	
if(checkIsValidForProceed()){

var frmObj	=	f_query_add_mod.groupforstore_dtls.location.href.indexOf(".jsp");
if(frmObj!=-1){
	var formarray = new Array ( f_query_add_mod.groupforstore_dtls.document.groupforstore_dtls );
	if(f_query_add_mod.groupforstore_dtls.groupforstore_dtls.choosen_link.value=="select"){
			if(f_query_add_mod.groupforstore_dtls.groupforstore_dtls.location_ref.value=="bystore")
			{
				if(pageUpdateApply()){
					eval(formApply( formarray,SS_CONTROLLER).replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "")) ;
				}
			}
			else{
				if(pageUpdateApplybyGeneric()){
					eval( formApply( formarray,SS_CONTROLLER).replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "") ) ;
				}

			}
		}
		else{
			if(f_query_add_mod.groupforstore_dtls.groupforstore_dtls.location_ref.value=="bystore"){
			if(pageUpdateAssociationApply()){
				eval( formApply( formarray,SS_CONTROLLER).replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "") ) ;
			}
			}
			else{
			if(pageUpdateAssociationApplybyGeneric()){
				eval( formApply( formarray,SS_CONTROLLER).replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "") ) ;
			}
			}
		}
			if( result ) {
				onSuccess();
			}
			else{
				if(flag=="nochange")
				{
					var errormessage  = getMessage("NO_CHANGE_TO_SAVE","Common");
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ errormessage;
						
						if(f_query_add_mod.groupforstore_dtls.groupforstore_dtls.choosen_link.value=="select"){
						}
						else{
						if(f_query_add_mod.groupforstore_dtls.groupforstore_dtls.location_ref.value=="bystore"){
						f_query_add_mod.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetailsAssociation.jsp";

						}
						else{
							f_query_add_mod.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetailsAssociationbyGroup.jsp";	
							
						}
					  }
					  
	
				}
			
			}
		
}
else{
messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
}
}
else{
messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
}
}

else{
		obj.focus();
	}
}
function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function onSuccess() {
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
	f_query_add_mod.groupforstore_header.location.href="../../eSS/jsp/GroupForStoreHeader.jsp?from_source="+f_query_add_mod.groupforstore_header.groupforstore_header.from_source.value;
	f_query_add_mod.groupforstore_button.location.href="../../eCommon/html/blank.html";
	f_query_add_mod.groupforstore_label.location.href="../../eCommon/html/blank.html";
	f_query_add_mod.groupforstore_dtls.location.href="../../eCommon/html/blank.html";
}

function reset() {
if(checkIsValidForProceed()){
	var frmObj	=		f_query_add_mod.groupforstore_header.location.href.indexOf(".jsp");
	if(frmObj !=-1){
		f_query_add_mod.groupforstore_header.location.href="../../eSS/jsp/GroupForStoreHeader.jsp?from_source="+f_query_add_mod.groupforstore_header.groupforstore_header.from_source.value;
		f_query_add_mod.groupforstore_button.location.href="../../eCommon/html/blank.html";
		f_query_add_mod.groupforstore_label.location.href="../../eCommon/html/blank.html";
		f_query_add_mod.groupforstore_dtls.location.href="../../eCommon/html/blank.html";
		}
	}
	else
	{
       if(f_query_add_mod.document.query_form!=null)
		f_query_add_mod.document.query_form.reset();
	}
} 


function goNextbyGeneric(source_mode) {
	start = parseInt( start + displaySize ) ;
	end = parseInt( end + displaySize ) ;
	var initString = unescape(document.groupforstore_dtls.initString.value) ;
	var finalString="";
	var count_next=1;
	var fm=parseInt(document.groupforstore_dtls.start.value);
	var tom=parseInt(document.groupforstore_dtls.end.value);
	finalString=formFinalString(fm,tom,"nextprev","bygroup",source_mode);
	xmlStr=formXMLString(initString,finalString,"bygroup",source_mode);
	var result=formValidation("bygroup",source_mode,xmlStr);
	if(source_mode=="association"){
		parent.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetailsAssociationbyGroup.jsp?dispMode=fromlink&from="+start+"&to="+end;
	}
	else if(source_mode=="select"){
		parent.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetailsbyGroup.jsp?dispMode=fromlink&from="+start+"&to="+end;
	}
}	

function goPrevbyGeneric(source_mode) {
	start = parseInt( start - displaySize ) ;
	end = parseInt( end - displaySize ) ;
	var initString = unescape(document.groupforstore_dtls.initString.value) ;
	var finalString="";
	var count_prev=1;

	var fm=parseInt(parent.groupforstore_dtls.groupforstore_dtls.start.value);
	var tom=parseInt(parent.groupforstore_dtls.groupforstore_dtls.end.value);

	var count=parseInt(parent.groupforstore_dtls.groupforstore_dtls.count.value);
	if(count==tom){
	
	}else{
	tom=count;
	} 
	finalString=formFinalString(fm,tom,"nextprev","bygroup",source_mode);
	xmlStr=formXMLString(initString,finalString,"bygroup",source_mode);
	var result=formValidation("bygroup",source_mode,xmlStr);
	
	if(source_mode=="association"){
		parent.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetailsAssociationbyGroup.jsp?dispMode=fromlink&from="+start+"&to="+end;
	}
	else if(source_mode=="select"){
		parent.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetailsbyGroup.jsp?dispMode=fromlink&from="+start+"&to="+end;
			}
}	

function changeCursor(obj) {
	obj.style.cursor = "hand" ;
}

function populate_group_details(group_id){
	var dialogHeight= "26" ;
	var dialogWidth	= "50" ;
	var dialogTop = "131" ;
	var center = "1" ;
	var status="no";
	var scrolling="auto";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop +";scroll:"+scrolling;
	var arguments	= "" ;
	retVal = window.showModalDialog("../../eSS/jsp/GroupForStoreViewFrames.jsp?group_id="+group_id,arguments,features);
}


function assignValue(obj){
if(obj.checked)
	obj.value="Y";
else
	obj.value="N";

}


function checkSplChar( val ) {
    var result = "" ;
    var ch = "" ;

    var spChars = new Array( "<", ">", "&", "\"", "'" ) ;
    var chChars = new Array( "&lt;", "&gt;", "&amp;", "&quot;", "&apos;" ) ;
    for(i=0; i<val.length; i++) {
        for(j=0; j<spChars.length; j++) {
            if ( val.substring(i,i+1) == spChars[j] ) {
                ch = chChars[j] ;
                j=spChars.length ;
            } else {
                ch = val.substring(i,i+1) ;
            }
        }
        result += ch ;
    }

    return result ;
}



function goNextbyGroup(source_mode) {
	start = parseInt( start + displaySize ) ;
	end = parseInt( end + displaySize ) ;


//validation
	var initString = unescape(document.groupforstore_dtls.initString.value) ;
	var finalString="";
	var count_next=1;

	//fm=start-displaySize;
	//tom=end-displaySize;
	

	var fm=parseInt(document.groupforstore_dtls.start.value);
	var tom=parseInt(document.groupforstore_dtls.end.value);
	

	for(var i=fm;i<tom;i++){
	var val1 = eval('document.groupforstore_dtls.eff_status'+i);
	
	if(source_mode=="association"){
	var val2 = eval('document.groupforstore_dtls.oper_mode'+i);
	var val4 = eval('document.groupforstore_dtls.short_desc'+i);
	}
	else if(source_mode=="select"){
	var val2 = eval('document.groupforstore_dtls.process'+i);
	var val4 = eval('document.groupforstore_dtls.store_desc'+i);
	}
	
	
	var val3 = eval('document.groupforstore_dtls.store_code'+i);
	var val5 = eval('document.groupforstore_dtls.min_qty'+i);
	var val6 = eval('document.groupforstore_dtls.reorder_qty'+i);

	if(count_next==1){
	finalString=val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value+"|"+val5.value+"|"+val6.value;
	}
	else{
	finalString+="~"+val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value+"|"+val5.value+"|"+val6.value;
	}
	count_next++;
	}

	var init_string=new Array();
	var final_string=new Array();
	
	init_string=initString.split("~");
	final_string=finalString.split("~");
	var xmlStr ="<root><SEARCH ";
	
	for(var i=0;i<parseInt((init_string.length));i++){
		
	var sep_init_string=new Array();
	var sep_final_string=new Array();
	sep_init_string=init_string[i].split("|");
	sep_final_string=final_string[i].split("|");

	

	if( ((sep_init_string[1]) == (sep_final_string[1])) && ((sep_init_string[0]) == (sep_final_string[0]))  ){
	
	}
	else{
		
	xmlStr += " SHORT_DESC"+i+"=\""+ checkSpl((sep_init_string[3])) + "\" ";
	xmlStr += " STORE_CODE"+i+"=\""+ (sep_final_string[2]) + "\" ";
	xmlStr += " EFF_STATUS"+i+"=\""+ (sep_final_string[0])+"\"";
	if(source_mode=="association"){
	xmlStr += " OPER_MODE"+i+"=\""+ (sep_final_string[1])+"\"";
	}
	else if(source_mode=="select"){
	xmlStr += " PROCESS"+i+"=\""+ (sep_final_string[1])+"\"";	
	}
	xmlStr += " MIN_QTY"+i+"=\""+ (sep_final_string[4])+"\"";	
	xmlStr += " REORDER_QTY"+i+"=\""+ (sep_final_string[5])+"\"";	
	
	}
	}
	xmlStr +=" /></root>";
	//alert(xmlStr);
	

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	if(source_mode=="association"){
		xmlHttp.open("POST","GroupForStoreValidationAssociationbyGroup.jsp",false);
	}else if(source_mode=="select"){
	xmlHttp.open("POST","GroupForStoreValidationGroup.jsp",false);
	}
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	
	
//end validation
if(source_mode=="association"){
parent.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetailsAssociationbyGroup.jsp?dispMode=fromlink&from="+start+"&to="+end;
}
else if(source_mode=="select"){
parent.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetailsbyGroup.jsp?dispMode=fromlink&from="+start+"&to="+end;
}
}	

function goPrevbyGroup(source_mode) {
	start = parseInt( start - displaySize ) ;
	end = parseInt( end - displaySize ) ;
	//fm=parseInt(start+displaySize);
	//tom=parseInt(end+displaySize);

	//validation
	var initString = unescape(document.groupforstore_dtls.initString.value );
	var finalString="";
	var count_prev=1;

	var fm=parseInt(parent.groupforstore_dtls.groupforstore_dtls.start.value);
	var tom=parseInt(parent.groupforstore_dtls.groupforstore_dtls.end.value);

	var count=parseInt(parent.groupforstore_dtls.groupforstore_dtls.count.value);
	if(count==tom){
	
	}else{
	tom=count;
	} 

	

	for(var i=fm;i<tom;i++){
	var val1 = eval('document.groupforstore_dtls.eff_status'+i);
	
	if(source_mode=="association"){
	var val2 = eval('document.groupforstore_dtls.oper_mode'+i);
	var val4 = eval('document.groupforstore_dtls.short_desc'+i);
	}
	else if(source_mode=="select"){
	var val2 = eval('document.groupforstore_dtls.process'+i);
	var val4 = eval('document.groupforstore_dtls.store_desc'+i);
	}
	
	
	var val3 = eval('document.groupforstore_dtls.store_code'+i);
	
	var val5 = eval('document.groupforstore_dtls.min_qty'+i);
	var val6 = eval('document.groupforstore_dtls.reorder_qty'+i);

	if(count_prev==1){
	finalString=val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value+"|"+val5.value+"|"+val6.value;
	}
	else{
	finalString+="~"+val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value+"|"+val5.value+"|"+val6.value;
	}
	count_prev++;
	}

	//alert(initString);
	//alert(finalString);

	var init_string=new Array();
	var final_string=new Array();
	
	init_string=initString.split("~");
	final_string=finalString.split("~");
	var xmlStr ="<root><SEARCH ";
	
	for(var i=0;i<init_string.length;i++){
	var sep_init_string=new Array();
	var sep_final_string=new Array();
	sep_init_string=init_string[i].split("|");
	sep_final_string=final_string[i].split("|");
	if( (sep_init_string[1]) == (sep_final_string[1])  && ((sep_init_string[0]) == (sep_final_string[0]))  ){
	
	}
	else{
	
	xmlStr += " SHORT_DESC"+i+"=\""+ checkSpl((sep_init_string[3])) + "\" ";
	xmlStr += " STORE_CODE"+i+"=\""+ (sep_final_string[2]) + "\" ";
	xmlStr += " EFF_STATUS"+i+"=\""+ (sep_final_string[0])+"\"";
	if(source_mode=="association"){
	xmlStr += " OPER_MODE"+i+"=\""+ (sep_final_string[1])+"\"";
	}
	else if(source_mode=="select"){
	xmlStr += " PROCESS"+i+"=\""+ (sep_final_string[1])+"\"";
	}
	xmlStr += " MIN_QTY"+i+"=\""+ (sep_final_string[4])+"\"";
	xmlStr += " REORDER_QTY"+i+"=\""+ (sep_final_string[5])+"\"";

	}
	}
	xmlStr +=" /></root>";
	//alert(xmlStr);

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	if(source_mode=="association"){
		xmlHttp.open("POST","GroupForStoreValidationAssociationbyGroup.jsp",false);
	}else if(source_mode=="select"){
	xmlHttp.open("POST","GroupForStoreValidationGroup.jsp",false);
	}
	
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
//alert( responseText ) ;
	
	
//end validation
	if(source_mode=="association"){
		parent.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetailsAssociationbyGroup.jsp?dispMode=fromlink&from="+start+"&to="+end;
			}
			else if(source_mode=="select"){
			parent.groupforstore_dtls.location.href="../../eSS/jsp/GroupForStoreDetailsbyGroup.jsp?dispMode=fromlink&from="+start+"&to="+end;
			}
}	

function enableqty(obj,i){
	var formObject = document.groupforstore_dtls;
	if(obj.checked){
		var min_qty = eval("formObject.min_qty"+i);
		min_qty.disabled=false;
		var reorder_qty = eval("formObject.reorder_qty"+i);
		reorder_qty.disabled=false;
	}else{
		var min_qty = eval("formObject.min_qty"+i);
		min_qty.disabled=true;
		var reorder_qty = eval("formObject.reorder_qty"+i);
		reorder_qty.disabled=true;
	}
}

function validate_reorder_qty(i){
	var formObject = document.groupforstore_dtls;
	var min_qty = eval("formObject.min_qty"+i+".value");
	var reorder_qty = eval("formObject.reorder_qty"+i+".value");
	//if(parseInt(min_qty) >= parseInt(reorder_qty)){
	if(parseFloat(min_qty) >= parseFloat(reorder_qty)){
		alert(getMessage("REORDER_QTY_GR_REORDER_LEVEL","SS"));
		eval("formObject.reorder_qty"+i).focus();
	}
	
}

