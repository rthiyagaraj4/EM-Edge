async function recordMatUsed(obj){
	var formObj = document.forms[0];
	var site_type = formObj.oh_site.value;
	var thrng_nos_ref = formObj.thrng_nos_ref.value;
	var trmt_cat_type = formObj.oh_category.value;
	var patient_id    = formObj.patient_id.value;
	var chart_num=  formObj.chart_num.value;
	var chart_line_num= formObj.chart_line_num.value;
	var	trmt_code= formObj.trmt_code.value;
    var	task_code= formObj.task_code.value;
    var	task_desc= encodeURIComponent(formObj.task_desc.value);//Added encodeURIComponent by Sridevi Joshi on 8/16/2010 for IN023245


    var	task_seq= formObj.task_seq_no.value;
    var	treatment_status_param= formObj.treatment_status_param.value;
	var tooth_range_count_for_order = 0;
	var display_tooth_no= formObj.display_tooth_no.value;
	var ind_chart_line_num= formObj.ind_chart_line_num.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var tooth_no=formObj.oh_area.value;
	var tooth_numbering_system=formObj.tooth_numbering_system.value;
	var super_tooth_ref = formObj.super_tooth_ref.value;//Added by Sridevi Joshi on 2/24/2010 for IN010894
	var baseline_chart_yn = formObj.baseline_chart_yn.value;//Added by Sridevi Joshi on 5/27/2010 for IN021653
	var date_diff_flag = formObj.date_diff_flag.value;//Added by Sridevi Joshi on 5/27/2010 for IN021668
	if(site_type == "THRNG" && thrng_nos_ref != ""){
		var thrng_nos_ref_arr = thrng_nos_ref.split(",");
		tooth_range_count_for_order = thrng_nos_ref_arr.length 
	}
	else if(site_type == "THRNG" && thrng_nos_ref == ""){
		tooth_range_count_for_order = formObj.oh_area.options.length 
	}
 //added below lines by parul on 120309 (Wrong display for Tooth Number / area in ?View Treatment Details?(site issue))
	if(site_type == "QUAD" || site_type == "ARCH" || site_type == "MAXFS"){//Condition for MAXFS is added for IN021414 by Sridevi Joshi on 5/17/2010
		 display_tooth_no = formObj.oh_area.options[formObj.oh_area.options.selectedIndex].text;
	}
	else{
		if (site_type=="TOOTH" || site_type=="ROOT" || site_type=="CROWN")
		{
			 display_tooth_no = formObj.oh_area.options[formObj.oh_area.options.selectedIndex].text;
		}else{
			 display_tooth_no=formObj.oh_area.value;
		}
	}//end
	//Commented for CRF #0423 on 3/28/2009 by Sharon Crasta
	//var params = "trmt_cat_type="+trmt_cat_type+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&display_tooth_no="+display_tooth_no+"&ind_chart_line_num="+ind_chart_line_num+"&task_code="+task_code+"&treatment_status_param="+treatment_status_param+"&task_desc="+task_desc+"&site_type="+site_type;
	var params = "trmt_cat_type="+trmt_cat_type+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&display_tooth_no="+display_tooth_no+"&ind_chart_line_num="+ind_chart_line_num+"&task_code="+task_code+"&treatment_status_param="+treatment_status_param+"&task_desc="+unescape(task_desc)+"&site_type="+site_type+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&task_seq="+task_seq+"&super_tooth_ref="+super_tooth_ref+"&tooth_no="+tooth_no+"&tooth_numbering_system="+tooth_numbering_system+"&baseline_chart_yn="+baseline_chart_yn+"&date_diff_flag="+date_diff_flag;
	//Added unescape(task_desc) for 23245 by AnithaJ
	//alert(params);

	var url	= "../../eOH/jsp/TrmtMatFrames.jsp?"+params;

	var dialogHeight= "70vh" ;
	var dialogWidth	= "70vw" ;
	var dialogTop ="";
	var dialogLeft ="";
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop +"  ;dialogLeft:" + dialogLeft + ";scroll=auto; status:" + status;
	var retVal =await top.window.showModalDialog(url,arguments,features);
	
}
/* Not used
function callDetailForm()
{   formObj= document.forms[0];
    var composition_class=formObj.composition_class.value;
	var composition_class_desc=formObj.composition_class_desc.value;
	var patient_id= formObj.patient_id.value;
	var chart_num=  formObj.chart_num.value;
	var chart_line_num= formObj.chart_line_num.value;
	var	trmt_code= formObj.trmt_code.value;
	var tooth_range_count_for_order=formObj.tooth_range_count_for_order.value;

	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var oh_chart_level = formObj.oh_chart_level.value;
   // var params = "composition_class="+composition_class+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&composition_class_desc="+composition_class_desc;
    var params = "composition_class="+composition_class+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&composition_class_desc="+composition_class_desc+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
    parent.frames[1].location.href="../../eOH/jsp/TrmtMatDetails.jsp?"+params;
    var hash = new Hashtable();
    hash = window.parent.frames[2].hash;
    hash.clear();
}
*/

/*function clearvalues(){
	document.forms[0].reset();
	window.parent.frames[1].location.href="../../eCommon/html/blank.html";
	var hash = new Hashtable();
    hash = window.parent.frames[2].hash;
    hash.clear();
}*/
/* Not Used
function previous(){
	formObj= document.forms[0];
	var patient_id= formObj.patient_id.value;
	var chart_num=  formObj.chart_num.value;
	var chart_line_num= formObj.chart_line_num.value;
	var	trmt_code= formObj.trmt_code.value;
	var tooth_range_count_for_order=formObj.tooth_range_count_for_order.value;
	var formObj1=window.parent.frames[0].document.forms[0]; 
    var composition_class=formObj1.composition_class.value;
	var composition_class_desc=formObj.composition_class_desc.value;
	var formObj2 = document.forms[0];
	var start = formObj2.start.value;
	formObj2.start.value=parseInt(start)-14;
	start = formObj2.start.value;
	var end = formObj2.end.value;
	formObj2.end.value=parseInt(end)-14;
	end = formObj2.end.value;
	var hash = new Hashtable();
    hash = window.parent.frames[2].hash;
    var keys = hash.keys();

	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	//document.location.href="../../eOH/jsp/TrmtMatDetails.jsp?from="+start+"&to="+end+"&composition_class="+composition_class+"&totalSelected="+keys+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&composition_class_desc="+composition_class_desc;
	document.location.href="../../eOH/jsp/TrmtMatDetails.jsp?from="+start+"&to="+end+"&composition_class="+composition_class+"&totalSelected="+keys+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&composition_class_desc="+composition_class_desc+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
}
*/
/* Not Used
 function next(){
	var formObj= document.forms[0];
	var patient_id= formObj.patient_id.value;
	var chart_num=  formObj.chart_num.value;
	var chart_line_num= formObj.chart_line_num.value;
	var	trmt_code= formObj.trmt_code.value;
	var tooth_range_count_for_order=formObj.tooth_range_count_for_order.value;
	var formObj1=window.parent.frames[0].document.forms[0]; 
	var composition_class=formObj1.composition_class.value;
	var composition_class_desc=formObj.composition_class_desc.value;
	var formObj2 = document.forms[0];
	var start = formObj2.start.value;
	formObj2.start.value=parseInt(start)+14;
	start = formObj2.start.value;
    var end = formObj2.end.value;
	formObj2.end.value=parseInt(end)+14;
	end = formObj2.end.value;
	var hash = new Hashtable();
	hash = window.parent.frames[2].hash;
	var keys = hash.keys();

	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	//document.location.href="../../eOH/jsp/TrmtMatDetails.jsp?from="+start+"&to="+end+"&composition_class="+composition_class+"&totalSelected="+keys+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&composition_class_desc="+composition_class_desc;
	document.location.href="../../eOH/jsp/TrmtMatDetails.jsp?from="+start+"&to="+end+"&composition_class="+composition_class+"&totalSelected="+keys+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&composition_class_desc="+composition_class_desc+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
 }
 */
 
 function assingListItemValue(key){
	var formObj = document.forms[0];
	var hash = new Hashtable();
	//hash = window.parent.frames[3].hash;
	hash = window.parent.hidden_frame.hash;
	if(hash.get(key)!=null){
		if(hash.get(key)[2]=="Y")
			eval("formObj.chk_select"+key).checked=true;
		else
			eval("formObj.chk_select"+key).checked=false;
	}
}

function validateCheckBox(obj){
	//var frmObj = window.parent.frames[3];
	var frmObj = window.parent.hidden_frame;
	var formObj = document.forms[0];
	var record= new Array();
    var composition_class_code=obj.composition_class_code;
	var composition_code=obj.composition_code;
	var composition_remarks=obj.composition_remarks;
	var composition_seq_no=obj.composition_seq_no;

    var hash = new Hashtable();
	hash = frmObj.hash;
    var indx = obj.name.replace("chk_select" , "");
	
	if(obj.checked==true ){
		record[0]=composition_class_code;
		record[1]=composition_code;
		record[2]="Y";		
		record[3]=composition_remarks;	
		record[4]=composition_seq_no;	
	}else{
		record[0]=composition_class_code;
		record[1]=composition_code;
		record[2]="N";
		record[3]=composition_remarks;	
		record[4]=composition_seq_no;	
	}
	if(hash.get(indx)!=null){
		hash.remove(indx);	
	}else{
		hash.put(indx,record);	
	}
}
/* Not Used
function callAccept(){
	formObj= document.forms[0];
	var formObj1=window.parent.frames[0].document.forms[0]; 
	var concat_str= "";
    var composition_class=formObj1.composition_class.value;
	var composition_class_desc=formObj.composition_class_desc.value;
	hash = window.parent.frames[2].hash;
	var keys = hash.keys();
	val=keys;
    var patient_id= formObj.patient_id.value;
	var chart_num=  formObj.chart_num.value;
	var chart_line_num= formObj.chart_line_num.value;
	var	trmt_code= formObj.trmt_code.value;
	var tooth_range_count_for_order=formObj.tooth_range_count_for_order.value;

	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var oh_chart_level = formObj.oh_chart_level.value;
    //var params1 = "composition_class="+composition_class+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&composition_class_desc="+composition_class_desc;
    var params1 = "composition_class="+composition_class+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&composition_class_desc="+composition_class_desc+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
    var duplicate_yn = "N";
    var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "composition_class="+composition_class+"&patient_id="+patient_id+"&chart_num="+chart_num;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DentalTrmtCommonValidation.jsp?func_mode=getcompositioncode&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
    var composition_code_db=retVal.split("$$");
    
	for(p = 0;p<val.length;p++){
	   if(hash.get(val[p])!=null){
		  if(hash.get(val[p])[2]=="Y"){
				
            for(i=0;i<composition_code_db.length-1;i++){
			   if(hash.get(val[p])[0] == composition_code_db[i]){
				   var msg = getMessage("APP-OH00034","OH");
				   var msgArray = msg.split("##");
			       alert(msgArray[0]+hash.get(val[p])[0]+msgArray[1]+" "+composition_class_desc);
				   duplicate_yn = "Y";
			       break;
			   }
		    }
			 
		   if(duplicate_yn == "Y"){
					break; 
		   }
		   else if(duplicate_yn != "Y"){
			  if(concat_str != ""){
				   concat_str = concat_str+"~"+hash.get(val[p])[0]+"##"+composition_class;
			   }
			  else{
				   concat_str =hash.get(val[p])[0]+"##"+composition_class;
			  }
		   }
		}
     } 
  }
  document.forms[0].concat_str1.value = concat_str;
   
  if(concat_str.length != 0){
	if(duplicate_yn != "Y"){
		document.forms[0].submit();
		parent.frames[1].location.href="../../eOH/jsp/TrmtMatDetails.jsp?"+params1;
		var hash = new Hashtable();
		hash = window.parent.frames[2].hash;
		hash.clear();
    } 
   }
 }
 */

function clear_list(obj){
  while(obj.options.length > 0){
   obj.remove(obj.options[0]);
 }
}  


function CheckForOHSpecChars(event){
	if((event.keyCode==61) || (event.keyCode==43) || (event.keyCode==163) || (event.keyCode==96) || (event.keyCode==126) || (event.keyCode==64) || (event.keyCode==35) || (event.keyCode==36) || (event.keyCode==37) || (event.keyCode==38) || (event.keyCode==42) || (event.keyCode==40) || (event.keyCode==41) || (event.keyCode==45) || (event.keyCode==95) || (event.keyCode==91) || (event.keyCode==93) || (event.keyCode==123) || (event.keyCode==125) || (event.keyCode==92) || (event.keyCode==124) || (event.keyCode==59) || (event.keyCode==58) || (event.keyCode==39) || (event.keyCode==34) || (event.keyCode==44) || (event.keyCode==46) || (event.keyCode==47) || (event.keyCode==60) || (event.keyCode==62) || (event.keyCode==63) || (event.keyCode==62) || (event.keyCode==60) ||(event.keyCode==36)||(event.keyCode==94) ||(event.keyCode==126)||(event.keyCode==37)||(event.keyCode==33)||(event.keyCode==38)){
	return false; 
		}
	}

function populateComposition(obj){
	var composition_desc=document.forms[0].composition_desc.value;
	var composition_class_code = obj.value;
	//Added for IN012626(CRF-709) by Sridevi Joshi
	if(composition_class_code == "OTH"){
		//Commented by rajesh for 19604 on 170310
		//document.getElementById("comp_code_id").innerHTML = "<input type='text' name='composition_code' id='composition_code' maxlength='100' onKeyPress = 'return checkForSpecCharsforCompRemarks(event)' />";
		document.getElementById("comp_code_id").innerHTML = "<input type='text' name='composition_code' id='composition_code' maxlength='100' onKeyPress = 'return CheckForOHSpecChars(event)' />";
	}
	else{
		//Added for IN012626(CRF-709) by Sridevi Joshi
		document.getElementById("comp_code_id").innerHTML = '<select name="composition_code" id="composition_code" <%=status_disabled%>><option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option></select>';
		
		clear_list(document.forms[0].composition_code); 
		optSel	= document.createElement("OPTION");
		optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
		optSel.value= ''; 
		document.forms[0].composition_code.add(optSel);
		

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "composition_class_code="+composition_class_code;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DentalTrmtCommonValidation.jsp?func_mode=populateComposition&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		
		if(retVal.length>1){
			var retVal_arr = retVal.split("~");
			for(var i=0;i<retVal_arr.length-1;i++){
				var code_desc_arr = retVal_arr[i].split("##");
				var element 	= document.createElement('OPTION') ;
				element.value 	= code_desc_arr[0];
				element.text 	= code_desc_arr[1] ;
				document.forms[0].composition_code.add(element);
			}
		}
	}
}

function clearvalues()
{
	if(document.forms[0].composition_code.type == "text"){
		document.forms[0].reset();
		document.getElementById("comp_code_id").innerHTML = '<select name="composition_code" id="composition_code" <%=status_disabled%>><option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option></select>';

		clear_list(document.forms[0].composition_code);
		optSel	= document.createElement("OPTION");
		optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
		optSel.value= ''; 
		document.forms[0].composition_code.add(optSel);
	}
	else{
		document.forms[0].reset();
		clear_list(document.forms[0].composition_code);
		optSel	= document.createElement("OPTION");
		optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
		optSel.value= ''; 
		document.forms[0].composition_code.add(optSel);
	}
}

function checkField( fields, names) 
{
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) 
	{
	 if(fields[i].value) {
	   fields[i].value = trimString(fields[i].value);
	 }
	 else { 
	   errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"\n"
	 }
	}
	if ( errors.length != 0 )
	{
	 return false ;
	}
	return true;
}



function recordComposition()
{
	var composition_desc=document.forms[0].composition_desc.value;
	formObj=document.forms[0];
	var patient_id= formObj.patient_id.value;
	var chart_num=  formObj.chart_num.value;
	var chart_line_num= formObj.chart_line_num.value;
	var	trmt_code= formObj.trmt_code.value;
	var task_code=formObj.task_code.value;
	//var task_code_req=formObj.task_code_req.value;
	var	dtl_params= formObj.params.value;
	var tooth_range_count_for_order=formObj.tooth_range_count_for_order.value;
	var composition_class=formObj.composition_class.value;
	var composition_code=formObj.composition_code.value;
	var display_tooth_no= parent.TrmtMatHeaderTitle.document.forms[0].display_tooth_no.value;
	var ind_chart_line_num = parent.TrmtMatHeader.document.forms[0].ind_chart_line_num.value;
	var composition_class_title=getLabel("eOH.CompositionClass.Label","OH");
	var composition_title = getLabel("Common.Composition.label","Common");
	var fields = new Array (formObj.composition_class,formObj.composition_code);
    var names = new Array ( composition_class_title,composition_title);
	//var composition_class_desc=formObj.composition_class_desc.value;
	var composition_class_desc=formObj.composition_class.options[formObj.composition_class.options.selectedIndex].text;
	var composition_code_db=new Array();
	var composition_desc_db=new Array();
	var composition="";
	var duplicate_yn='N';
	var hdr_title_params=parent.TrmtMatHeaderTitle.document.forms[0].params.value;
	var hdr_params= parent.TrmtMatHeader.document.forms[0].params.value;
	var trmt_cat_type=formObj.trmt_cat_type.value;
	//Added by Sharon Crasta on 11/13/2008 for SCR #6492
	//Added to display the Task Description on successful completion of record.
	var task_desc = formObj.task_desc.value;
	//End

	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var seq_no = formObj.seq_no.value;

		 	
    //if(checkField( fields, names)){
		var messageFrame = parent.messageFrame;
	if(checkFieldsofMst( fields, names, messageFrame)){	
		//if(composition_class == "OTH"){
			//var msg = getMessage("APP-OH00034","OH");
			//var msgArray = msg.split("##");
			//alert(msgArray[0]+"'"+composition_desc_db[j]+"'"+msgArray[1]+" "+"'"+composition_class_desc+"'");
			//duplicate_yn='Y';
		//}
		//else{

			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params1="composition_class="+composition_class+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&ind_chart_line_num="+ind_chart_line_num+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&task_code="+task_code+"&seq_no="+seq_no;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtCommonValidation.jsp?func_mode=getCompositioncode&"+params1,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);

			if(retVal.length >  1){
				composition= retVal.split("~");
			
				for(j=0;j<composition.length;j++){
					composition1=composition[j].split("$$");
					composition_code_db[j]=composition1[0];
					composition_desc_db[j]=composition1[1];
					if(composition_code == composition_code_db[j]){
						var msg = getMessage("APP-OH00034","OH");
						var msgArray = msg.split("##");
						alert(msgArray[0]+"'"+composition_desc_db[j]+"'"+msgArray[1]+" "+"'"+composition_class_desc+"'");
						duplicate_yn='Y';
						break;
					}
					else{
						duplicate_yn='N';
					}
				}
			}
		//}
	    //var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&composition_class_code="+composition_class+"&composition_code="+composition_code+"&trmt_code="+trmt_code+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&composition_class="+composition_class+"&display_tooth_no="+display_tooth_no+"&ind_chart_line_num="+ind_chart_line_num+"&task_code="+task_code;
	    var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&composition_class_code="+composition_class+"&composition_code="+composition_code+"&trmt_code="+trmt_code+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&composition_class="+composition_class+"&display_tooth_no="+display_tooth_no+"&ind_chart_line_num="+ind_chart_line_num+"&task_code="+task_code+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
		if(duplicate_yn == 'N'){
			 document.forms[0].submit();
			 var msg = getMessage("RECORD_INSERTED","SM");
			 alert(msg);
             //alert("Operation Completed Successfully........")
			 //window.setTimeout(refresh,10);
		 	
			//Commented by Sharon Crasta on 11/13/2008 for SCR #6492
			// parent.TrmtMatHeaderTitle.location.href = '../../eOH/jsp/TrmtMatHeaderTitle.jsp?'+params;	
			// parent.TrmtMatHeader.location.href="../../eOH/jsp/TrmtMatHeader.jsp?"+params;			 
			/*
			//Added to display the Task Description on successful completion of record
			 parent.TrmtMatHeaderTitle.location.href = '../../eOH/jsp/TrmtMatHeaderTitle.jsp?'+params+"&task_desc="+task_desc;
			 parent.TrmtMatHeader.location.href="../../eOH/jsp/TrmtMatHeader.jsp?"+params+"&task_desc="+task_desc;
			 //End

		     document.location.href="../../eOH/jsp/TrmtMatDetails.jsp?"+dtl_params;
			 */
			 //parent.TrmtMatHeaderTitle.location.href = '../../eOH/jsp/TrmtMatFrames.jsp?'+params+"&task_desc="+task_desc;

			 var formObj = document.forms[0];

			var patient_id = formObj.patient_id.value;
			var chart_num= formObj.chart_num.value;
			var chart_line_num= formObj.chart_line_num.value;
			var	trmt_code= formObj.trmt_code.value;
			var	task_code_req= task_code;

			var	from= formObj.from.value;
			var	to= formObj.to.value;
			var	totalSelected= formObj.totalSelected.value;
			var	tooth_range_count_for_order= formObj.tooth_range_count_for_order.value;
			var	display_tooth_no= formObj.display_tooth_no.value;
			var	ind_chart_line_num= formObj.ind_chart_line_num.value;
			var	status_disabled= formObj.status_disabled.value;
			var	oh_chart_level= formObj.oh_chart_level.value;
			var	other_chart_facility_id= formObj.other_chart_facility_id.value;
			var	seq_no= formObj.seq_no.value;
			var	maxRecord= formObj.maxRecord.value;
			var	trmt_cat_type= formObj.trmt_cat_type.value;
			var	task_desc= formObj.task_desc.value;

			var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code_req="+task_code_req+"&from="+from+"&to="+to+"&totalSelected="+totalSelected+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&display_tooth_no="+display_tooth_no+"&ind_chart_line_num="+ind_chart_line_num+"&status_disabled="+status_disabled+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&seq_no="+seq_no+"&maxRecord="+maxRecord+"&trmt_cat_type="+trmt_cat_type+"&task_desc="+task_desc;

			var messageFrame = parent.parent.parent.parent.parent.messageFrame
			messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
			parent.TrmtMatHeader.location.href="../../eOH/jsp/TrmtMatHeader.jsp?"+params;
			parent.TrmtMatDetails.location.href="../../eOH/jsp/TrmtMatDetails.jsp?"+params;
			
		}
	}
}
function refresh()
{
	formObj=document.forms[0];
	var	dtl_params= formObj.params.value;
	var patient_id= formObj.patient_id.value;
	var chart_num=  formObj.chart_num.value;
	var chart_line_num= formObj.chart_line_num.value;
	var	trmt_code= formObj.trmt_code.value;
	var	dtl_params= formObj.params.value;
	var tooth_range_count_for_order=formObj.tooth_range_count_for_order.value;
	var composition_class=formObj.composition_class.value;
	var composition_code=formObj.composition_code.value;
	var display_tooth_no= parent.TrmtMatHeaderTitle.document.forms[0].display_tooth_no.value;

	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var	oh_chart_level = formObj.oh_chart_level.value; 

		
	//var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&composition_class_code="+composition_class+"&composition_code="+composition_code+"&trmt_code="+trmt_code+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&composition_class="+composition_class+"&display_tooth_no="+display_tooth_no;
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&composition_class_code="+composition_class+"&composition_code="+composition_code+"&trmt_code="+trmt_code+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&composition_class="+composition_class+"&display_tooth_no="+display_tooth_no+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
	parent.TrmtMatHeaderTitle.location.href = '../../eOH/jsp/TrmtMatHeaderTitle.jsp?'+params;	
	parent.TrmtMatHeader.location.href="../../eOH/jsp/TrmtMatHeader.jsp?"+params;
	document.location.href="../../eOH/jsp/TrmtMatDetails.jsp?"+dtl_params;

}

function deleteCompRecorded(){
	 formObj=document.forms[0];
	 var patient_id= formObj.patient_id.value;
	 var chart_num = formObj.chart_num.value;
	 var trmt_code =formObj.trmt_code.value;
	 var task_code_req=formObj.task_code_req.value;
	 var chart_line_num = formObj.chart_line_num.value;
	 var ind_chart_line_num = formObj.ind_chart_line_num.value;
	 var tooth_range_count_for_order = formObj.tooth_range_count_for_order.value;
     var dtl_params = parent.TrmtMatDetails.document.forms[0].params.value;
	 var hdr_params= formObj.params.value;
	 var hdr_title_params=parent.TrmtMatHeaderTitle.document.forms[0].params.value;
	 var display_tooth_no= parent.TrmtMatHeaderTitle.document.forms[0].display_tooth_no.value;
	 //Added by Sharon Crasta on 11/13/2008 for SCR #6492
	 //Added to display the Task Description on deletion of record.
	 var task_desc = formObj.task_desc.value;
	 //End

	 var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var	oh_chart_level = formObj.oh_chart_level.value; 
	var	seq_no = formObj.seq_no.value; 

		
	 var hash = new Hashtable(); 
	 //hash = parent.frames[3].hash;
	 hash = parent.hidden_frame.hash;
	 var keys_arr = hash.keys();
	if(keys_arr.length > 0)
	{
	for(k=0;k<keys_arr.length;k++){
	  if(hash.get(keys_arr[k])!=null){
		if(hash.get(keys_arr[k])[2]=="Y"){
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			//var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&composition_class_code="+hash.get(keys_arr[k])[0]+"&composition_code="+hash.get(keys_arr[k])[1]+"&trmt_code="+trmt_code+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&display_tooth_no="+display_tooth_no+"&task_code_req="+task_code_req;   
			var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&composition_class_code="+hash.get(keys_arr[k])[0]+"&composition_code="+hash.get(keys_arr[k])[1]+"&trmt_code="+trmt_code+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&display_tooth_no="+display_tooth_no+"&task_code_req="+task_code_req+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&composition_remarks="+hash.get(keys_arr[k])[3]+"&composition_seq_no="+hash.get(keys_arr[k])[4]+"&seq_no="+seq_no;   
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtCommonValidation.jsp?func_mode=deleteCompRecorded&"+params,false);
			xmlHttp.send(xmlDoc);
		 }
	   }
	 }
	 params = params+"&task_code="+task_code_req;
	hash.clear();
	//Commented by Sharon Crasta on 11/13/2008 for SCR #6492
	//document.location.href = '../../eOH/jsp/TrmtMatHeader.jsp?'+params+"&ind_chart_line_num="+ind_chart_line_num;	
	//parent.TrmtMatHeaderTitle.location.href = '../../eOH/jsp/TrmtMatHeaderTitle.jsp?'+params;

	var messageFrame = parent.parent.parent.parent.parent.messageFrame
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
	
	//Added to display the Task Description on deletion of record.
	document.location.href = '../../eOH/jsp/TrmtMatHeader.jsp?'+params+"&ind_chart_line_num="+ind_chart_line_num+"&task_desc="+task_desc+"&seq_no="+seq_no;	
	//parent.TrmtMatHeaderTitle.location.href = '../../eOH/jsp/TrmtMatHeaderTitle.jsp?'+params+"&task_desc="+task_desc;
	//End

	parent.TrmtMatDetails.location.href = '../../eOH/jsp/TrmtMatDetails.jsp?'+dtl_params;	
   }
      else
	{
	   //alert("Select atleast one Composition");
		alert(getMessage("APP-OH00062","OH"))
	}
}
function showRecords(count){
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var chart_num= formObj.chart_num.value;
	var chart_line_num= formObj.chart_line_num.value;
	var	trmt_code= formObj.trmt_code.value;
    var	task_code_req= formObj.task_code_req.value;
    var	task_desc= formObj.task_desc.value;
    //var	baseline_chart_yn= formObj.baseline_chart_yn.value;

    //var	from= formObj.from.value;
    //var	to= formObj.to.value;
    //var	totalSelected= formObj.totalSelected.value;
    var	tooth_range_count_for_order= formObj.tooth_range_count_for_order.value;
    //var	display_tooth_no= formObj.display_tooth_no.value;
    var	ind_chart_line_num= formObj.ind_chart_line_num.value;
    var	status_disabled= formObj.status_disabled.value;
    var	oh_chart_level= formObj.oh_chart_level.value;
    var	other_chart_facility_id= formObj.other_chart_facility_id.value;
    var	seq_no= formObj.seq_no.value;
    var	maxRecord= formObj.maxRecord.value;
    //var	trmt_cat_type= formObj.trmt_cat_type.value;

	var start = count;
	var end = count+9;

	var hash = new Hashtable(); 
	//hash = window.parent.frames[3].hash;
	hash = window.parent.hidden_frame.hash;
	var keys = hash.keys();

	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code_req="+task_code_req+"&from="+start+"&to="+end+"&totalSelected="+keys+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&display_tooth_no="+"&ind_chart_line_num="+ind_chart_line_num+"&status_disabled="+status_disabled+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&seq_no="+seq_no+"&maxRecord="+maxRecord+"&task_desc="+task_desc;

	parent.TrmtMatHeader.location.href='../../eOH/jsp/TrmtMatHeader.jsp?'+params;
}

/*
function showRecords(count)
{
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var trmt_code = formObj.trmt_code.value;
	var tooth_range_count_for_order=formObj.tooth_range_count_for_order.value;
	var chart_line_num=formObj.chart_line_num.value;
	var maxRecord=formObj.maxRecord.value;
	var display_tooth_no= parent.TrmtMatHeaderTitle.document.forms[0].display_tooth_no.value;
	var ind_chart_line_num= parent.TrmtMatHeader.document.forms[0].ind_chart_line_num.value;
    var start = count;
	var end = count+9;

	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var	oh_chart_level = formObj.oh_chart_level.value; 

    
	var hash = new Hashtable(); 
	hash = window.parent.frames[3].hash;
	var keys = hash.keys();
	//parent.TrmtMatHeader.location.href='../../eOH/jsp/TrmtMatHeader.jsp?from='+start+'&to='+end+'&patient_id='+patient_id+"&chart_num="+chart_num+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&trmt_code="+trmt_code+"&chart_line_num="+chart_line_num+"&totalSelected="+keys+"&maxRecord="+maxRecord+"&ind_chart_line_num="+ind_chart_line_num;
	parent.TrmtMatHeader.location.href='../../eOH/jsp/TrmtMatHeader.jsp?from='+start+'&to='+end+'&patient_id='+patient_id+"&chart_num="+chart_num+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&trmt_code="+trmt_code+"&chart_line_num="+chart_line_num+"&totalSelected="+keys+"&maxRecord="+maxRecord+"&ind_chart_line_num="+ind_chart_line_num+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
}
*/
function showRecords1(count)
{
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var trmt_code = formObj.trmt_code.value;
	var tooth_range_count_for_order=formObj.tooth_range_count_for_order.value;
	var chart_line_num=formObj.chart_line_num.value;
	var maxRecord=formObj.maxRecord.value;
	var task_code=formObj.task_code.value;
	var trmt_cat_type=formObj.trmt_cat_type.value;

	var display_tooth_no= parent.TrmtMatHeaderTitle.document.forms[0].display_tooth_no.value;
	var ind_chart_line_num= parent.TrmtMatHeader.document.forms[0].ind_chart_line_num.value;
    var start = count;
	var end = count+9;

	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var	oh_chart_level = formObj.oh_chart_level.value; 

    
	var hash = new Hashtable(); 
	//hash = window.parent.frames[3].hash;
	hash = window.parent.hidden_frame.hash;
	var keys = hash.keys();
	//parent.TrmtMatDetails.location.href='../../eOH/jsp/TrmtMatDetails.jsp?from='+start+'&to='+end+'&patient_id='+patient_id+"&chart_num="+chart_num+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&chart_line_num="+chart_line_num+"&maxRecord="+maxRecord+"&task_code="+task_code;
	parent.TrmtMatDetails.location.href='../../eOH/jsp/TrmtMatDetails.jsp?from='+start+'&to='+end+'&patient_id='+patient_id+"&chart_num="+chart_num+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&chart_line_num="+chart_line_num+"&maxRecord="+maxRecord+"&task_code="+task_code+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
}


function setCheckValue(){
	formObj=document.forms[0];
	var patient_id= formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var trmt_code =formObj.trmt_code.value;
	var task_code_req=formObj.task_code_req.value;
    var chart_line_num = formObj.chart_line_num.value;
    var count = formObj.count.value;
    var tooth_range_count_for_order = document.forms[0].tooth_range_count_for_order.value;
	for(var i=0;i<=count;i++){
		if(eval("formObj.completed"+i) != "null" && eval("formObj.completed"+i) != "undefined" && eval("formObj.completed"+i) != undefined){
			if(eval("formObj.completed"+i).checked==true){
				eval("formObj.completed"+i).value="Y";
			}
			else{
				eval("formObj.completed"+i).value="N";
			}
		}
	}
}


function updatetrmtdtlsentry(obj,task_code_req,task_desc,seq_no,count)
{
	formObj=document.forms[0];
	var count_records = 0;
	var patient_id= formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var trmt_code =formObj.trmt_code.value;
	var chart_line_num = formObj.chart_line_num.value;
	var tooth_range_count_for_order = document.forms[0].tooth_range_count_for_order.value;
	var trmt_dtls_entry_cmpl_yn=obj.value;
	var i=document.forms[0].i.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var	oh_chart_level = formObj.oh_chart_level.value; 

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params1="patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code_req+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&seq_no="+seq_no;

	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateCompositionDetails&"+params1,false);
	xmlHttp.send(xmlDoc);
	var i = trimString(xmlHttp.responseText);

	var j=i-1;
	if(j<1){
		var flag=confirm(getMessage("APP-OH00061","OH"))
		if(flag){
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			
			var params1="patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&task_code_req="+task_code_req+"&trmt_dtls_entry_cmpl_yn="+trmt_dtls_entry_cmpl_yn+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&seq_no="+seq_no;

			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtCommonValidation.jsp?func_mode=updateTrmtDtlEntry&"+params1,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(retVal==1){
				if(parent.TrmtMatHeader.document.forms[0] != null && parent.TrmtMatHeader.document.forms[0] != "null"){
					if(parent.TrmtMatHeader.document.forms[0].task_code_req.value == task_code_req && parent.TrmtMatHeader.document.forms[0].seq_no.value == seq_no){
						count_records = parent.TrmtMatHeader.document.forms[0].i.value;
						if(parent.TrmtMatDetails.document.forms[0].composition_class.value == "OTH"){
							parent.TrmtMatDetails.document.getElementById("comp_code_id").innerHTML = '<select name="composition_code" id="composition_code" <%=status_disabled%>><option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option></select>';
		
							clear_list(parent.TrmtMatDetails.document.forms[0].composition_code); 
							optSel	= document.createElement("OPTION");
							optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
							optSel.value= ''; 
							parent.TrmtMatDetails.document.forms[0].composition_code.add(optSel);
						}
						parent.TrmtMatDetails.document.forms[0].composition_class.value="";
						parent.TrmtMatDetails.document.forms[0].composition_code.value="";
						parent.TrmtMatDetails.document.forms[0].record.disabled=true;
						parent.TrmtMatDetails.document.forms[0].clear.disabled=true;
						parent.TrmtMatDetails.document.forms[0].composition_class.disabled=true;
						parent.TrmtMatDetails.document.forms[0].composition_code.disabled=true;
						parent.TrmtMatHeader.document.forms[0].delete1.disabled=true;
						for(var m=1;m<=count_records-1;m++){
							eval("parent.TrmtMatHeader.document.forms[0].chk_select"+m).disabled=true
						}
						
					}
				}
				eval("formObj.completed"+count).checked=true;
				eval("formObj.completed"+count).disabled=true;
				eval("formObj.completed"+count).value="Y";
			}
		}
		else{
			eval("formObj.completed"+count).checked=false;
			eval("formObj.completed"+count).value="N";
			return;
		}
	}
	else{
		//var data_entry_completed = confirm("Treatments Data Entry will be completed.Do you want to proceed?")
		var data_entry_completed = confirm(getMessage("APP-OH000124","OH"));
		if(data_entry_completed){
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			
			var params1="patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&task_code_req="+task_code_req+"&trmt_dtls_entry_cmpl_yn="+trmt_dtls_entry_cmpl_yn+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&seq_no="+seq_no;
			//
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtCommonValidation.jsp?func_mode=updateTrmtDtlEntry&"+params1,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(retVal==1){
				if(parent.TrmtMatHeader.document.forms[0] != null && parent.TrmtMatHeader.document.forms[0] != "null"){
					if(parent.TrmtMatHeader.document.forms[0].task_code_req.value == task_code_req && parent.TrmtMatHeader.document.forms[0].seq_no.value == seq_no){
						count_records = parent.TrmtMatHeader.document.forms[0].i.value;
						parent.TrmtMatDetails.document.forms[0].record.disabled=true;
						parent.TrmtMatDetails.document.forms[0].clear.disabled=true;
						if(parent.TrmtMatDetails.document.forms[0].composition_class.value == "OTH"){
							parent.TrmtMatDetails.document.getElementById("comp_code_id").innerHTML = '<select name="composition_code" id="composition_code" <%=status_disabled%>><option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option></select>';
		
							clear_list(parent.TrmtMatDetails.document.forms[0].composition_code); 
							optSel	= document.createElement("OPTION");
							optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
							optSel.value= ''; 
							parent.TrmtMatDetails.document.forms[0].composition_code.add(optSel);
						}
						parent.TrmtMatDetails.document.forms[0].composition_class.value="";
						parent.TrmtMatDetails.document.forms[0].composition_code.value="";
						parent.TrmtMatDetails.document.forms[0].composition_class.disabled=true;
						parent.TrmtMatDetails.document.forms[0].composition_code.disabled=true;
						parent.TrmtMatHeader.document.forms[0].delete1.disabled=true;
						for(var m=1;m<=count_records-1;m++){
							eval("parent.TrmtMatHeader.document.forms[0].chk_select"+m).disabled=true
						}
						
					}
				}
				eval("formObj.completed"+count).checked=true;
				eval("formObj.completed"+count).disabled=true;
				eval("formObj.completed"+count).value="Y";
			}
		}
		else{
			eval("formObj.completed"+count).checked=false;
			eval("formObj.completed"+count).value="N";
			return;
		}
	}
}

function populateCompositionDetails(task_code,task_desc,status_disabled,seq_no){
	var formObj = document.forms[0];

	var patient_id = formObj.patient_id.value;
	var chart_num= formObj.chart_num.value;
	var chart_line_num= formObj.chart_line_num.value;
	var	trmt_code= formObj.trmt_code.value;
    var	task_code_req= task_code;

    var	from= formObj.from.value;
    var	to= formObj.to.value;
    var	totalSelected= formObj.totalSelected.value;
    var	tooth_range_count_for_order= formObj.tooth_range_count_for_order.value;
    var	display_tooth_no= formObj.display_tooth_no.value;
    var	ind_chart_line_num= formObj.ind_chart_line_num.value;
    //var	status_disabled= formObj.status_disabled.value;
    var	oh_chart_level= formObj.oh_chart_level.value;
    var	other_chart_facility_id= formObj.other_chart_facility_id.value;
    //var	seq_no= formObj.seq_no.value;
    var	maxRecord= formObj.maxRecord.value;
    var	trmt_cat_type= formObj.trmt_cat_type.value;
    var	baseline_chart_yn= formObj.baseline_chart_yn.value;//Added by Sridevi Joshi on 5/27/2010 for IN021653
    var	date_diff_flag= formObj.date_diff_flag.value;//Added by Sridevi Joshi on 5/27/2010 for IN021668

	//Added on 9/16/2010 for 23245 by AnithaJ
	var	task_desc= encodeURIComponent(formObj.task_desc.value);

	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code_req="+task_code_req+"&from="+from+"&to="+to+"&totalSelected="+totalSelected+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&display_tooth_no="+display_tooth_no+"&ind_chart_line_num="+ind_chart_line_num+"&status_disabled="+status_disabled+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&seq_no="+seq_no+"&maxRecord="+maxRecord+"&trmt_cat_type="+trmt_cat_type+"&task_desc="+task_desc+"&seq_no="+seq_no+"&baseline_chart_yn="+baseline_chart_yn+"&date_diff_flag:=="+date_diff_flag;
	var messageFrame = parent.parent.parent.parent.parent.messageFrame
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
	parent.TrmtMatHeader.location.href="../../eOH/jsp/TrmtMatHeader.jsp?"+params;
	parent.TrmtMatDetails.location.href="../../eOH/jsp/TrmtMatDetails.jsp?"+params;
	
	

}
/*
function setDataEntryCompleted(count){
	var formObj = document.forms[0];
	alert(count);
	var patient_id = formObj.patient_id.value;
	var chart_num= formObj.chart_num.value;
	var chart_line_num= formObj.chart_line_num.value;
	var	trmt_code= formObj.trmt_code.value;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params1="patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkDataEntryCompleted&"+params1,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	retVal = localTrimString(retVal);
	alert("retVal:=="+retVal);
	var retVal_arr = retVal.split("~");
	for(var i=0;i<=retVal_arr.length-1;i++){
		if(retVal_arr[i] == "Y"){
			eval("formObj.completed"+i).checked=true;
			eval("formObj.completed"+i).value="Y";
		}
		else{
			eval("formObj.completed"+i).checked=false;
			eval("formObj.completed"+i).value="N";
		}
	}
}
*/

 function closewindow()
 {
	 window.close();
 }

 function localTrimString(sInString) {
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

function checkForSpecCharsforCompRemarks(event){   
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*/-.,=+ ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode); 
	
    if (strCheck.indexOf(key) == -1 && event.keyCode!=13) return false;  // Not a valid key
	if (whichCode == 13) return false;
	return true ;
}

