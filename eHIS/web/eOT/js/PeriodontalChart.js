/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create()
{  
	var cmf=commontoolbarFrame.document.forms[0];
	if(cmf.apply.disabled==true)
	{
      cmf.apply.disabled=false;
    }
	var source=document.forms[0].source.value;
	f_query_add_mod.location.href='../../eOH/jsp/PeriodontalChartMain.jsp?'+source;
}

function apply(){	
	
	var frm=f_query_add_mod.document.forms[0];
	//alert(frm.name);
	if(frm == null){
		commontoolbarFrame.location.reload();
	}
	else if(frm != null){ 
		var frm=f_query_add_mod.document.forms[0];
		var fields = new Array (frm.chartid,frm.chart_desc);
		var chartid = getLabel("eOH.Chartid.Label","OH");
		var chart_desc = getLabel("Common.description.label","Common")
		var names = new Array (chartid,chart_desc);
		if(checkFieldsofMst( fields, names, messageFrame)&&chksequence()&&CheckDupeSeq()){	
			//if(validateCheckBox(obj,indx){
			var formObj = window.parent.frames[1].frames[1].document.forms[0];
			//alert(formObj.name);
			var params = formObj.params.value;
			var mode = formObj.mode.value;
			var arr = formObj.elements;
		    var xmlStr=formXMLString(formObj);	
			//alert(xmlStr);
			if(xmlStr!="<root></root>"){
				var action="../../servlet/eOH.PeriodontalChartServlet?mode="+mode;
				var xmlDoc = "";
				var xmlHttp = new XMLHttpRequest();
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST",action,false);
				xmlHttp.send(xmlDoc);
				var retVal = xmlHttp.responseText;
				var mesg = retVal;
				var mesg1=mesg.split(" ");
				//alert(mesg);
				if(mesg1[0]=="APP-000064")
				{  
					frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
				}
				else if(mesg1[0]!="APP-000064")
				{
				onSuccess();
				frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
				}
			}else{
				var msg = getMessage("NO_CHANGE_TO_SAVE","common");
				messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			} 
		}
		else
		{  
			commontoolbarFrame.location.reload();
			var chkmsg=getMessage("APP-OH00041","OH");
			//alert(chkmsg)
			var flag=checkFieldsofMst( fields, names, messageFrame);
			
			if(flag==false)
			{
				var errors = "" ;
				for( var i=0; i<fields.length; i++ ) {
				if(trimCheck(fields[i].value)) {
				fields[i].value = trimString(fields[i].value);
				}
				else   {

				errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>"
				}
				}
				if ( errors.length != 0 ) {
				messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
			    }
			}
			else
			{
			messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+chkmsg;
			
			}
		}
		
	}
	
}


function reset()
{
	var frm=f_query_add_mod.document.forms[0];
	
	if(frm == null){
		commontoolbarFrame.location.reload();
	}
	else if(frm != null){
	f_query_add_mod.document.forms[0].reset();
	}
}

function query()
{
	var cmf=commontoolbarFrame.document.forms[0];
	var source=document.forms[0].source.value;
	if(cmf.apply.disabled==false)
	{
      cmf.apply.disabled=true;
    }
	f_query_add_mod.location.href='../../eOH/jsp/PeriodontalChartQueryCriteria.jsp'
}

function setCheckValue()
{
	if(document.forms[0].status.checked==true) {
		document.forms[0].status.value="E";
		document.forms[0].status.db_change='Y';
	}	else {
		document.forms[0].status.value="D";
		document.forms[0].status.db_change='Y';
	}
}

function assignGraphCheckboxValue(obj){
	
	if(obj.checked==true)
	{obj.value="Y";
	    document.forms[0].status.db_change='Y';}
	else
	{obj.value="N";
	document.forms[0].status.db_change='Y';}
}

function validateCheckBox(obj,indx){
	var formObj = document.forms[0];
	var arrObj = document.forms[0].elements;
	var mode = document.forms[0].mode.value;
    var count= document.forms[0].count.value;
	var k=0;
		
   var target=eval("document.forms[0].select_"+indx);
		var target1=eval("document.forms[0].sequence_"+indx);
	
   // uncheck(indx);

	if(formObj.status.db_change=='Y'){
	formObj.status.db_change='N'
	}
	var db_mode="";
//	if (validatevalues(indx)){
	validatevalues(indx)
			if (mode=="insert"){
				var objname=obj.name;
				var id = objname.replace("select_","");
				var target1 = eval("formObj.hdb_mode_"+id);
				target1.value="I";
			} else if (mode=="modify")	{
				if(obj.checked==true){
					var objname=obj.name;
					var id = objname.replace("select_","");
					var target2 = eval("formObj.sequence_"+id);
						//target2.value=eval("formObj.hsequence_no"+id).value;
						target2.value=eval("formObj.sequence_"+id).value;
						
					var target3 = eval("formObj.minvalue_"+id);
                        target3.value=eval("formObj.hmin_value"+id).value;
						
					var target4 = eval("formObj.maxvalue_"+id);
					    target4.value=eval("formObj.hmax_value"+id).value;
					var target5 = eval("formObj.redif_"+id);
					    target5.value=eval("formObj.hcut_off"+id).value;
					//var target6 = eval("formObj.graph_reqd_yn_"+id);
					//target6.value=eval("formObj.hgraph_reqd_yn_"+id).value;
					//alert(target6.value);
					//eval("formObj.graph_reqd_yn_"+id).checked=true;
					db_mode=Insmodcheck(obj,indx);
					var target1 = eval("formObj.hdb_mode_"+id);
					if(db_mode=="I"){
					target1.value="I";
					} else {
					target1.value="M";
					}
				}else{
					var objname=obj.name;
					var id = objname.replace("select_","");
					var target1 = eval("formObj.hdb_mode_"+id);
					var target2 = eval("formObj.sequence_"+id);
					target2.value="";
					var target3 = eval("formObj.minvalue_"+id);
					target3.value="";
					var target4 = eval("formObj.maxvalue_"+id);
					target4.value="";
					var target5 = eval("formObj.redif_"+id);
					target5.value="";
					//var target6 = eval("formObj.graph_reqd_yn_"+id);
					//target6.value="N";
					//eval("formObj.graph_reqd_yn_"+id).checked=false;
					target1.value="D";
					
				}
				validatevalues(indx)
			}
	//	}// TESt
if(obj.value!="" || obj.value!=null){
	formObj.modified_flag.value="false";
			obj.selected_yn="Y";
			 obj.db_change="Y";
			var target1=eval("document.forms[0].hselect_"+indx);
			target1.value='Y';
}
}

function Insmodcheck(obj,indx){
	var formObj = document.forms[0];
	var arrObj = document.forms[0].elements;
	var mode = document.forms[0].mode.value;
	var objname=obj.name;
	var id = objname.replace("select_","");
	var target1 = eval("formObj.sequence_"+id+".value");
	var target2 = eval("formObj.hsequence_no"+id+".value");
	var target3 = eval("formObj.minvalue_"+id+".value");
	var target4 = eval("formObj.hmin_value"+id+".value");
	var target5 = eval("formObj.maxvalue_"+id+".value");
	var target6 = eval("formObj.hmax_value"+id+".value");
	var target7 = eval("formObj.redif_"+id+".value");
	var target8 = eval("formObj.hcut_off"+id+".value");
	var db_mode="";
	if(target1==target2 || target3==target4 || target5==target6 || target7==target8 ){
		db_mode="I";
	} else if(target2=="" || target4=="" || target6=="" || target8=="") {
		db_mode="I";
	}else if (target1!=target2 || target3!=target4 || target5!=target6 || target7!=target8 ) {
		db_mode="M";
	}
	return db_mode;
}



function formXMLString(formObj){
	var mode=formObj.mode.value;
	var arrObj = formObj.elements;
	
	var xmlString="<root>";
	for(var i=0;i<arrObj.length;i++){
		if(arrObj[i].type=="checkbox" && arrObj[i].db_change=="Y"){
			
		   var indx =  arrObj[i].name;
		   
		   if (indx.length==9){
			   
		   		   indx = indx.substr(indx.length-2,2);
				   
				 
		   } else {
			   indx = indx.substr(indx.length-1,1);
			  
		   }
		   
				//alert(eval("arrObj[i].graph_reqd_yn_"+indx));
				//alert(eval("formObj.graph_reqd_yn_"+indx+".value"));
			   xmlString+="<RECORD_"+indx+" ";
 			   xmlString+=" chart_id=\""+formObj.chartid.value+"\""+" ";
 			   xmlString+=" chart_desc=\""+formObj.chart_desc.value+"\""+" ";
 			   xmlString+=" status=\""+formObj.status.value+"\""+" ";
			   
			   if (arrObj[i].name!='status' && eval("formObj.hselect_"+indx+".value")=='Y'){
//			   if (arrObj[i].name!='status' ){
	           
 			   xmlString+=" db_mode=\""+eval('formObj.hdb_mode_'+indx+'.value')+"\""+" ";
			   xmlString+=" component_code=\""+eval('arrObj[i].component_code'+indx)+"\""+" ";
 			   xmlString+=" sequence_no=\""+eval('formObj.sequence_'+indx+'.value')+"\""+" ";
 			   xmlString+=" min_value=\""+eval('formObj.minvalue_'+indx+'.value')+"\""+" ";
 			   xmlString+=" max_value=\""+eval("formObj.maxvalue_"+indx+'.value')+"\""+" ";
 			   xmlString+=" redif_value=\""+eval("formObj.redif_"+indx+'.value')+"\""+" ";
			   //-->xmlString+=" graph_reqd_yn=\""+eval("formObj.graph_reqd_yn_"+indx+".value")+"\""+" ";
			   xmlString+=" selected_value=\""+eval("arrObj[i].select_yn_"+indx)+"\""+" "+" />";
			  // alert(xmlString)
	/*		   } else if(mode!="insert") {
 			   xmlString+=" db_mode=\"H\""+" ";
			   xmlString+=" component_code=\"''\""+" ";
 			   xmlString+=" sequence_no=\"''\""+" ";
 			   xmlString+=" min_value=\"''\""+" ";
 			   xmlString+=" max_value=\"''\""+" ";
 			   xmlString+=" redif_value=\"''\""+" ";
			   xmlString+=" selected_value=\"\""+" />";
			   } else {
 			   xmlString+=" db_mode=\"H\""+" ";
			   xmlString+="/>";
			   }*/
			   } else if(formObj.status.db_change=='Y'){
 			   xmlString+=" db_mode=\"H\""+" ";
			   xmlString+=" component_code=\"''\""+" ";
 			   xmlString+=" sequence_no=\"''\""+" ";
 			   xmlString+=" min_value=\"''\""+" ";
 			   xmlString+=" max_value=\"''\""+" ";
 			   xmlString+=" redif_value=\"''\""+" ";
			  //--> xmlString+=" graph_reqd_yn=\"\""+" ";
			   xmlString+=" selected_value=\"\""+" />";
			   } else {
 			   xmlString="<root>";
			   }
		 }
	}
	xmlString+="</root>";
//alert(xmlString);
	//return false;
	return xmlString;
}

function Checkdbmode(obj,indx){
if(obj.value.length!=0){
var formObj=document.forms[0];
var mode=formObj.mode;
var target=eval("document.forms[0].select_"+indx);
if(target.checked && obj.value==""){obj.focus();}
if (mode.value=="modify" && obj.type=="text"){
	var target="";
	if (("sequence_"+indx)==obj.name) {
	target=eval("formObj.hsequence_no"+indx+".value");
	} else if (("minvalue_"+indx)==obj.name) {
	target=eval("formObj.hmin_value"+indx+".value");
	} else if (("maxvalue_"+indx)==obj.name) {
	target=eval("formObj.hmax_value"+indx+".value");
	} else if (("redif_"+indx)==obj.name) {
	target=eval("formObj.hcut_off"+indx+".value");
	}
if(obj.value!="" && target!="") {
var target3=eval("formObj.hdb_mode_"+indx);
target3.value="M";
var tempu=eval("formObj.select_"+indx);
tempu.db_change="Y";
} else {
var target4=eval("formObj.hdb_mode_"+indx);
 target4.value="I";
var tempu=eval("formObj.select_"+indx);
tempu.db_change="Y";
}
}
}
}

function changeColor(i,obj)
{
	var formObj=document.forms[0];
	var min_value=eval("formObj.minvalue_"+i).value;
	var max_value=eval("formObj.maxvalue_"+i).value;
	var cutoff=eval("formObj.redif_"+i).value;
	if(cutoff=="") cutoff="0"
//	if(max_value=="") max_value="0"
	msg
	if(max_value=="") {
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var maxv  = getLabel("Common.MaxValue.label","Common");
		target1=eval("formObj.maxvalue_"+i);
		target1.focus();
		alert(msgArray[0]+maxv+(msgArray[1]));
	}
//	if(min_value=="") min_value="0"
	if(min_value=="") {
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var minv  = getLabel("eAM.MinValue.label","AM");
		target1=eval("formObj.minvalue_"+i);
		target1.focus();
		alert(msgArray[0]+minv+(msgArray[1]));
	}

	max_value= parseInt(max_value);
	min_value= parseInt(min_value);
	cutoff= parseInt(cutoff);
	if(cutoff>max_value) {
		obj.style.color="#FF0033";
		var msg_1 = getMessage("APP-OH0002","OH");
		var msgArray = msg_1.split("#");
		obj.focus();
		alert(msgArray[0]+(getLabel("eOH.RedIfGreaterEqual.Label","OH"))+msgArray[1]+(getLabel("Common.MaxValue.label","Common")));	
	}else if (cutoff<min_value)	{
		obj.style.color="#FF0033";
		var msg_2 = getMessage("APP-OH0003","OH");
		var msgArray = msg_2.split("#");
		obj.focus();
		alert(msgArray[0]+(getLabel("eOH.RedIfGreaterEqual.Label","OH"))+msgArray[1]+(getLabel("eAM.MinValue.label","AM")));	
	}else if (cutoff=="") {	
		obj.style.color="#400040";
	} else {
		obj.style.color="#400040";
	}
}


function validatevalues(indx){
	var formObj=document.forms[0];
    var seq_no=eval('formObj.sequence_'+indx);
    var min_value=eval('formObj.minvalue_'+indx);
    var max_value=eval('formObj.maxvalue_'+indx);
    var redif_value=eval('formObj.redif_'+indx);
	var fields = new Array (seq_no,min_value,max_value,redif_value);
		var seq_no_title = getLabel("eOT.Sequence.Label","OT");
		var min_value_title = getLabel("eAM.MinValue.label","AM")
		var max_value_title  = getLabel("Common.MaxValue.label","Common");
		var redif_value_title  = getLabel("eOH.RedIfGreaterEqual.Label","OH");
		var names = new Array (seq_no_title,min_value_title, max_value_title,redif_value_title);
		messageFrame=window.parent.messageFrame;
		//if(eval('formObj.select_'+indx+'.checked') && min_value.disabled==false){
		if(eval('formObj.select_'+indx+'.checked')){
		checkFieldsofMst( fields, names, messageFrame)
		if (seq_no.value==""){
			seq_no.focus();
		}
		else 
		if (min_value.value=="" && min_value.disabled==false ){
			min_value.focus();
		}else if (max_value.value=="" && max_value.disabled==false ){
			max_value.focus();
		}else if (redif_value.value=="" && redif_value.disabled==false ){
			redif_value.focus();
		} else {
			return true;
		}
		}
		else
	{
    
	// messageFrame.document.location.href="../../eCommon/html/blank.html";
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp";
	}

}


function CheckDupeSeq(val,indx){
    var exist=false;
	var formObj=document.forms[0];
	var obj=eval("formObj.sequence_"+indx);
    //alert(eval("formObj.sequence_"+indx).value)
	var j=formObj.ival.value;
	for(i=0;i<j;i++){
		var seq=eval("formObj.sequence_"+i);
		if(obj!=seq && seq!=null){
	//	if(seq.value!="" || seq.value!=null)
		seq=parseInt(seq.value);
		val=parseInt(val);
		if(seq==val){
		exist=true;
		break;
		} 
		}
	}
    if(exist){
		obj.focus();
		alert(getMessage("RECORD_ALREADY_EXISTS","common"));
		if(formObj.mode.value=="modify"){
		obj.select();
	     return false;
		}
    }else{
	     return true;
    }
}


function CheckNum(obj) {

    if ( trimCheck(obj.value) && isNaN(obj.value) == false && (obj.value >= -10 ||  obj.value <= 10)) {
		var value=trimString(obj.value);
		obj.value=value;
        return true;
    }
    else {
        if ( obj.value.length > 0 ) {

            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.select();
            obj.focus();
            return false;
        }
    }
}

function CheckNumMaxMin(obj,obj1,obj2) {
	var formObj=document.forms[0];
//	obj=trimString(obj);
	    if ( trimCheck(obj.value) && isNaN(obj.value) == false) {
		var value=trimString(obj.value);
		obj.value=parseInt(value);
			if (obj.value >= -10){
//		return true;
			}else	 {
				obj.focus();
				var msg_1 = getMessage("APP-OH0001","OH");
				var msgArray = msg_1.split("#");
				if(obj1=="max"){
					var title  = getLabel("Common.MaxValue.label","Common");
				}	else {
					var title = getLabel("eAM.MinValue.label","AM")
				}
				alert(msgArray[0]+title+msgArray[1]+" -10");	
			}
			if (obj.value <= 10)
			{
//		return true;
			} else {
				obj.focus();
				var msg_1 = getMessage("APP-OH0001","OH");
				var msgArray = msg_1.split("#");
				if(obj1=="max"){
					var title  = getLabel("Common.MaxValue.label","Common");
				}	else {
					var title = getLabel("eAM.MinValue.label","AM")
				}
				alert(msgArray[0]+title+msgArray[1]+"10");	
			}
			if(obj1=="max"){
				var min=eval("formObj.minvalue_"+obj2+".value");
				var max=eval("formObj.maxvalue_"+obj2+".value");

				if(parseInt(min)>parseInt(max)) {
				obj.focus();
				//alert("Max Value should be greater than Min Value");
				var msg_1 = getMessage("APP-OH0004","OH");
				var msgArr = msg_1.split("#");
				var minvalue = getLabel("eAM.MinValue.label","AM");
				var maxvalue =getLabel("Common.MaxValue.label","Common");
				alert(msgArr[0]+ maxvalue +msgArr[1]+ minvalue +msgArr[2]);
				}
			}
		if(obj1=="min"){
				var min=eval("formObj.minvalue_"+obj2+".value");
				var max=eval("formObj.maxvalue_"+obj2+".value");

				if(parseInt(min)>parseInt(max)) {
				obj.focus();
					//alert("Max Value should be greater than Min Value");
				var msg_1 = getMessage("APP-OH0001","OH");
				var msgArr = msg_1.split("#");
				var minvalue = getLabel("eAM.MinValue.label","AM");
				var maxvalue =getLabel("Common.MaxValue.label","Common");
				alert(msgArr[0]+ minvalue +msgArr[1]+ maxvalue +msgArr[2]);
				}
			}
    }
    else {
        if ( obj.value.length > 0 ) {
            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.select();
            obj.focus();
            return false;
        }
    }
}


function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert") {
		f_query_add_mod.location.href="../../eOH/jsp/PeriodontalChartMain.jsp?mode=insert";
	} /*else {
         f_query_add_mod.location.reload();
	}*/
}


 function alreadyExist()
 {
	var formObj = document.forms[0];
	var codeDtl = parent.frames[1].code;
	var rows = parent.parent.parent.ObjectCollect.personnel_rows;
	//var pract_type=formObj.pract_type.value;
	var chart_id=formObj.chartid.value;

	var codeRecord = chart_id;
	if(codeDtl.indexOf(codeRecord)>=0)
	   return false;
	else
	  return true;
 }

function CheckSeqNum(obj) {

    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
		var value=trimString(obj.value);
		obj.value=parseInt(value);
        return true;
    }
    else {
        if ( obj.value.length > 0 ) {

            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.select();
            obj.focus();
            return false;
        }
    }
}

function CheckRedifNum(obj) {

    if ( trimCheck(obj.value) && isNaN(obj.value) == false && (obj.value >= -10 ||  obj.value <= 10)) {
		var value=trimString(obj.value);
		obj.value=parseInt(value);
        return true;
    }
    else {
        if ( obj.value.length > 0 ) {

            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.select();
            obj.focus();
            return false;
        }
    }
}

function uncheck(indx)
{
	
//var target=eval("document.forms[0].select_"+indx);
//var target1=eval("document.forms[0].sequence_"+indx);
var count= document.forms[0].count.value;
var k=0;
   
	
	for(i=0;i<count;i++)
	{   
		var target=eval("document.forms[0].select_"+i);
		var target1=eval("document.forms[0].sequence_"+i);
		 
	     if(k==0 && target.checked && target1.value=="" && indx==i ){
		  var msg = getMessage("CANNOT_BE_BLANK","OT");
		  var msgArray = msg.split("&");
		  var sequence  = getLabel("eOT.Sequence.Label","OT");
		  alert(msgArray[0]+sequence+(msgArray[1]));
		   target1.focus();
		  //alert("sequence should not be blank");
		 // alert("551");
		  
		  target.checked=true;
		  target.value="Y";
		  k++;
		  }
         
		if(k>0 && target.checked && target1.value=="" && indx!=i){
		 // target1.focus();
		 // alert("558");
		  target.checked=false;
		  target.value="N";
		  
		 }
	}
}

function chksequence()
{
var i;
var errors="";
var frm=f_query_add_mod.document.forms[0];
var Sequence = getLabel("eOT.Sequence.Label","OT")
var not_blank = getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(Sequence)));
var chkmsg=getMessage("APP-OH00041","OH");
//var chkmsg=getLabel("eOH.AtleastOneComponentShouldBeSelected.Label","OH");
//alert(chkmsg);

//var chkmsg="AtleastOneComponentShouldBeSelected";
var j=frm.ival.value;
var flag;

for(i=0;i<j;i++ )
 {
 
  if(eval('frm.select_'+i+'.checked'))
  {        
		   if(eval("frm.sequence_"+i).value==""||eval("frm.sequence_"+i).value==null)
			{
			errors +=not_blank;
			messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
			return false;	
			}
			else 
		   {
			  if(i>11)
		      return true;
			  
			}
  }
  
 }
for(i=0;i<j;i++ ){
	if((eval("frm.sequence_"+i).value==""||eval("frm.sequence_"+i).value==null)&&(eval('frm.select_'+i+'.checked')==false))
	{
      i++;
	}
	else if(eval("frm.sequence_"+i).value!=""||eval("frm.sequence_"+i).value!=null)
		{
		
		 if(eval('frm.select_'+i+'.checked')==false)
			{ 
			
			errors +=chkmsg;
			messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
			//eval('frm.select_'+i+'.checked')=false;
			return false;
			}
		 
		 else  if(eval('frm.select_'+i+'.checked')==true){
			
			  // if(eval("frm.sequence_"+i).value!=null)
			 // eval('frm.select_'+i+'.checked')=true;
			  return true;
		 }
		
			//else {
			//eval('frm.select_'+i+'.checked')=false;
			//}
	}
}
 
}






function checkFieldsofMst( fields, names, messageFrame) {
    var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
        if(trimCheck(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
        }
        else   {
			
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>"
		}
    }
    if ( errors.length != 0 ) {
        messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
        return false ;
    }
    return true ;
}


function CheckDupeSeq(){
    var exist=false;
	var flag;
	var formObj=document.forms[0];
	var frm=f_query_add_mod.document.forms[0];
	var indx;
	var errors="";
	for(indx=0;indx<13;indx++)
	{
	var obj=eval("frm.sequence_"+indx);
    //alert(eval("formObj.sequence_"+indx).value)
	var val=eval("frm.sequence_"+indx).value;
	var dup = getMessage("RECORD_ALREADY_EXISTS","common");
	
	var j=frm.ival.value;
	for(i=0;i<j;i++){
		var seq=eval("frm.sequence_"+i);
		if(obj!=seq && seq!=null){
	//	if(seq.value!="" || seq.value!=null)
		seq=parseInt(seq.value);
		val=parseInt(val);
		if(seq==val){
		exist=true;
		break;
		} 
		}
	}
	}
    if(exist){
		//alert(getMessage("RECORD_ALREADY_EXISTS","common"));
		errors +=dup;
			  messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
		return false;
    }
	else{
	   return true;
    }

}
