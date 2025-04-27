var area_legend;
var tab_name = "DC";
var isPartiallyErupted = false;
var isErupted = false;
var isExtracted = false; //Added by Sridevi Joshi for IN016115 on 17/11/09
var recorded_for_tooth_range = false;


// Copied from jsp
function setValuesFromMenu(type,site,code,arch_quad,thrng_nos,ref_tooth_no,tooth_numbering_system,permanent_deciduous_flag,surface,flag,cusp_tip_code,maxila_area,maxila_parts,maxila_sub_parts){
	var thrng_arr;
	var formObj = document.forms[0];
	var date_diff_flag = formObj.date_diff_flag.value;
	var super_tooth_ref = formObj.super_tooth_ref.value;
	formObj.oh_condition_type.value = type;

	if(formObj.oh_condition_type.value != "" && formObj.oh_condition_type.value != "undefined" && formObj.oh_condition_type.value != undefined){ //Added by Sridevi Joshi on 4/26/2010 for PE..site type has to be populated only when condition_type value is not null 
		populateSiteOptions(formObj.oh_condition_type);
	}
	formObj.oh_site.value = site;
	getAreaLegend(formObj.oh_site,thrng_nos);

	if(formObj.oh_condition_type.value != "" && formObj.oh_condition_type.value != "undefined" && formObj.oh_condition_type.value != undefined){ //Added by Sridevi Joshi on 4/26/2010 for PE..dental condition has to be populated only when condition_type value is not null 
		populateDentalcondition(formObj.oh_condition_type);
	}

	if(code != null && code != "null" && code != "" && code != "undefined"){
		formObj.oh_dental_condition.value = code;
		
	}														  

	var MD_area = populateArea(formObj.oh_site,tooth_numbering_system,permanent_deciduous_flag,ref_tooth_no,thrng_nos,flag,formObj.thrng_nos_ref.value,'',super_tooth_ref);

	if(formObj.oh_site.value == "MAXFS"){
		var surface_legend = getLabel("eOH.Parts.Label","OH");
		document.getElementById("surface_field").innerHTML ="<td><select name='oh_surface' id='oh_surface' onchange='populateSubParts(this);countSurface();clearDentalcondition(this);'><option value=''><fmt:message key='eOH.DefaultSelect.Label' bundle='${oh_labels}'/></option></select>&nbsp;<select name='oh_sub_parts' id='oh_sub_parts' onchange='clearDentalcondition(this);'><option value=''><fmt:message key='eOH.DefaultSelect.Label' bundle='${oh_labels}'/></option></select>&nbsp;<img id='MandatorySurface'  src='../../eCommon/images/mandatory.gif'></td>"
		
		document.getElementById("change_surface").innerHTML = surface_legend;
	
	}
	if(formObj.oh_site.value == "ARCH" || formObj.oh_site.value == "QUAD"){
		formObj.oh_area.value = arch_quad;

		//These values for the hidden variables
		formObj.area.value = arch_quad;
	}
	else if(formObj.oh_site.value == "TOOTH" && thrng_nos.indexOf(",") != -1){
		formObj.oh_area.value = thrng_nos;

		//These values for the hidden variables
		formObj.area.value = thrng_nos;
	}
	else if(formObj.oh_site.value == "THRNG"){     //  added by yadav for  476
		formObj.oh_area.value = thrng_nos;

		//These values for the hidden variables
		formObj.area.value = thrng_nos;
	}
	else if(formObj.oh_site.value == "MAXFS"){
		formObj.oh_area.value = maxila_area;

		//These values for the hidden variables
		formObj.area.value = maxila_area;
	}
	else{
		formObj.oh_area.value = ref_tooth_no;
		//formObj.oh_area.value = thrng_nos
				
		//These values for the hidden variables
		formObj.area.value = ref_tooth_no;

	}

	if(MD_area != ""){
		formObj.oh_area.value = MD_area;
		//formObj.oh_area.value = thrng_nos

		//These values for the hidden variables
		formObj.area.value = MD_area;
	}

	if(formObj.oh_site.value == "MAXFS"){//added by yadav for CRF 476 on 3/4/2010
		if(maxila_sub_parts!="" || maxila_sub_parts!="null" || maxila_sub_parts!=null){
			populateSurfaces(formObj.oh_area);
			populateSubParts(formObj.oh_surface,maxila_parts);
			populateSelectedSubParts(formObj.oh_sub_parts,maxila_parts,maxila_sub_parts,ref_tooth_no);
			formObj.oh_surface.value = maxila_parts;
			formObj.oh_sub_parts.value = maxila_sub_parts;


			if ((maxila_sub_parts=="THAB" || maxila_sub_parts=="THGM" || maxila_sub_parts=="THAG" || maxila_sub_parts=="THMF" || maxila_sub_parts=="THGAM") &&(maxila_sub_parts!="" || maxila_sub_parts!="null" && maxila_sub_parts!=null)){
					//populateSelectedSubParts(formObj.oh_sub_parts,maxila_parts,maxila_sub_parts);
					formObj.oh_selected_sub_parts.value = ref_tooth_no;
			}else {
				if (maxila_sub_parts=="TNGAB" || maxila_sub_parts=="TNGGM" || maxila_sub_parts=="TNGAG"  || maxila_sub_parts=="TNGGAM" || maxila_sub_parts=="TNGMF"){
					document.getElementById("surface_field").innerHTML = "<select name='oh_surface' id='oh_surface' onChange='populateSubParts(this)'></select>&nbsp;<select name='oh_sub_parts' id='oh_sub_parts' onChange='populateSelectedSubParts(this)'></select>&nbsp;<input type='text' name='oh_selected_sub_parts' id='oh_selected_sub_parts' onBlur='chkSelcetedForSuperRDyn(this);' value='"+thrng_nos+"'><img id='MandatorySurface'  src='../../eCommon/images/mandatory.gif'>";
				}else{

					document.getElementById("surface_field").innerHTML = "<select name='oh_surface' id='oh_surface' onChange='populateSubParts(this)'></select>&nbsp;<select name='oh_sub_parts' id='oh_sub_parts' onChange='populateSelectedSubParts(this)'></select><img id='MandatorySurface'  src='../../eCommon/images/mandatory.gif'>";
				
				}

			//populateSelectedSubParts(formObj.oh_sub_parts,maxila_parts,maxila_sub_parts);

		
			clear_list(document.forms[0].oh_surface); 
			optSel	= document.createElement("OPTION");
			optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
			optSel.value= ''; 
			document.forms[0].oh_surface.add(optSel);

			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "area_val="+maxila_area;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateMaxilaSurfaces&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(retVal.length>1){
				var retVal_arr = retVal.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					var code_desc_arr = retVal_arr[i].split("##");
					var element 	= document.createElement('OPTION') ;
					element.value 	= code_desc_arr[0];
					element.text 	= code_desc_arr[1] ;
					document.forms[0].oh_surface.add(element);
				}
				document.forms[0].oh_surface.value = maxila_parts;
			}

			clear_list(document.forms[0].oh_sub_parts); 
			optSel	= document.createElement("OPTION");
			optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
			optSel.value= ''; 
			document.forms[0].oh_sub_parts.add(optSel);

			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
		
			var params = "parts="+maxila_parts;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateSubParts&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal1 = trimString(xmlHttp.responseText);
			if(retVal1.length>1){
				var retVal_arr = retVal1.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					var code_desc_arr = retVal_arr[i].split("##");
					var element 	= document.createElement('OPTION') ;
					element.value 	= code_desc_arr[0];
					element.text 	= code_desc_arr[1] ;
					document.forms[0].oh_sub_parts.add(element);
				}
					document.forms[0].oh_sub_parts.value = maxila_sub_parts;

				}
		
			}
		}else{
			populateSurfaces(formObj.oh_area);
			populateSubParts(formObj.oh_surface,maxila_parts);
			formObj.oh_surface.value = maxila_parts;
		}
	}
	else{
		populateSurfaces(formObj.oh_area);
		formObj.oh_surface.value = surface;
	}

	enableDisableSurface(formObj.oh_site,type);

	
	//populateSurfaces(formObj.oh_area,formObj.called_from_viewchart_yn.value);
	if(formObj.oh_area.value != "" && formObj.oh_area.value != "undefined" && formObj.oh_area.value != undefined){ //Added by Sridevi Joshi on 4/26/2010 for PE..Surface has to be populated only when area value is not null
		populateSurfaces(formObj.oh_area);
	}

	if(formObj.oh_surface.value != "" && formObj.oh_surface.value != "undefined" && formObj.oh_surface.value != undefined){ //Added by Sridevi Joshi on 4/26/2010 for PE..Cusptip has to be populated only when surface value is not null 
		populateCuspTip(formObj.oh_surface);
	}

	formObj.oh_cusp_tip.value = cusp_tip_code;

	enableDisableCuspTip(formObj.oh_site);

	//These values for the hidden variables
	formObj.condition_type.value = type;
	formObj.site.value = site;
	if(code != null && code != "null" && code != "" && code != "undefined"){
		formObj.dental_condition.value = code;
	}

	// This is the flsg to find out the Retained Deciduous condition....
	formObj.RD_Normal_yn.value = flag;

	if(formObj.oh_condition_type.value != "" && formObj.oh_condition_type.value != null){
		formObj.oh_condition_type.disabled = true;
		formObj.oh_area.disabled = true;
		formObj.oh_site.disabled = true;

		if(code != null && code != "null" && code != "" && code != "undefined"){
			formObj.oh_dental_condition.disabled = true;
		}

		if(type == "PULPINV" || type == "PERIINV"){
			formObj.oh_surface.disabled = true;
			document.getElementById("MandatorySurface").style.visibility = 'hidden';
		}
	}
//Commented and Added by Sharon Crasta on 12/01/2010 for IN017822
	//Added formObj.chart_disable_from_main.value to disabled the area field on click of Cancel of APP-OH000153 message
//	if(formObj.called_from_viewchart_yn.value == 'Y' || date_diff_flag == "disable"){
	if(formObj.called_from_viewchart_yn.value == 'Y' || date_diff_flag == "disable"  || formObj.chart_disable_from_main.value == 'Y' ){
		
			if(formObj.oh_site.value == "MAXFS"){//added by yadav for CRF 476 on 3/4/2010
			formObj.oh_surface.value = maxila_parts;
			formObj.oh_sub_parts.value = maxila_sub_parts;
			if  (maxila_sub_parts=="THAB" || maxila_sub_parts=="THGM" || maxila_sub_parts=="THAG" || maxila_sub_parts=="THMF" || maxila_sub_parts=="THGAM"){		
				
				formObj.oh_selected_sub_parts.value =ref_tooth_no;			
				formObj.oh_selected_sub_parts.disabled = true;

			}
			else if(maxila_sub_parts=="TNGAB" || maxila_sub_parts=="TNGGM" || maxila_sub_parts=="TNGAG"  || maxila_sub_parts=="TNGGAM" || maxila_sub_parts=="TNGMF"){

				formObj.oh_selected_sub_parts.value = thrng_nos;
				formObj.oh_selected_sub_parts.disabled = true;

			}
			formObj.oh_sub_parts.disabled = true;
		}else if(formObj.oh_site.value == "MOUTH")
		{
		document.getElementById("AreaMandatory").style.visibility = 'hidden'
		document.getElementById("oh_area").disabled=false;
		var newElem = document.createElement("option");
		newElem.text = "---Select---";
		newElem.value = "";
		document.getElementById("oh_area").add(newElem);
		document.getElementById("oh_area").disabled= true;
		}

		
		
		//End
		//formObj.oh_surface.value = surface;
		//added by parul for CRF#0483 on 21/08/2009
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "surface_code="+surface;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=displaySurfacesDescription&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal_surface = trimString(xmlHttp.responseText);
		if(retVal_surface.length>1){
			if(retVal_surface.indexOf("~")!=-1){
				var retVal_surface_arr=retVal_surface.replace("~",",");
				var retVal_surface_arr1=retVal_surface_arr.replace("~",",");
				var retVal_surface_arr3=retVal_surface_arr1.replace("~",",");
				var val_surface=retVal_surface_arr3.substring(0,retVal_surface_arr3.length-1);
				var retVal_surface_arr2=val_surface.substring(0,val.lastIndexOf(','));
				//document.getElementById("surface_field").innerHTML="<input type='text' name='oh_surface' id='oh_surface'  value='"+retVal_surface_arr2+"'><img id='MandatorySurface'  src='../../eCommon/images/mandatory.gif'>";

				document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" value=""><option value="">'+retVal_surface_arr2+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';
			
			}else{
				//document.getElementById("surface_field").innerHTML="<input type='text' name='oh_surface' id='oh_surface' maxlength='1' value='"+retVal_surface+"'><img id='MandatorySurface'  src='../../eCommon/images/mandatory.gif'>";

				document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" value=""><option value="">'+retVal_surface+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';
			}
		}
	//end

	if(cusp_tip_code != "" && cusp_tip_code != "undefined" && cusp_tip_code != undefined){ //Added by Sridevi Joshi on 4/26/2010 for PE ---cusp tip has to be displyed only when cusp_tip_code is not null
		//added by parul for CRF#0483
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "cusp_tip_code="+cusp_tip_code;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=displayCuspTip&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		if(retVal.length>1){
			if(retVal.indexOf("~")!=-1){
				var retVal_arr=retVal.replace("~",",");
				var retVal_arr1=retVal_arr.replace("~",",");
				var retVal_arr3=retVal_arr1.replace("~",",");
				var val=retVal_arr3.substring(0,retVal_arr3.length-1);
				var retVal_arr2=val.substring(0,val.lastIndexOf(','))
			//	document.getElementById("cusp_field").innerHTML="<input type='text' name='oh_cusp_tip' id='oh_cusp_tip'  value='"+retVal_arr2+"'>";
				document.getElementById("cusp_field").innerHTML="<input type='text' name='oh_cusp_tip' id='oh_cusp_tip'  size='30' value='"+retVal_arr2+"'>";
			
			}else{
				document.getElementById("cusp_field").innerHTML="<input type='text' name='oh_cusp_tip' id='oh_cusp_tip' maxlength='1' value='"+retVal+"'>";				
			}
		}
	}
		
		//formObj.oh_cusp_tip.value = cusp_tip_code;
		formObj.oh_condition_type.disabled = true;
		formObj.oh_area.disabled = true;
		formObj.oh_site.disabled = true;
		formObj.oh_dental_condition.disabled = true;
		formObj.oh_surface.disabled = true;
		formObj.oh_cusp_tip.disabled = true;
		formObj.oh_cusp_tip.readOnly = true;
	}

	//Added by Sharon Crasta on 10/22/2009 for IN012603(PMG20089-CRF-0700)
	var patient_id = formObj.patient_id.value; 
	var chart_num = formObj.chart_num.value;
	var oh_chart_level = formObj.oh_chart_level.value; 
	var other_chart_facility_id = formObj.other_chart_facility_id.value; 
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getDentistComments&"+params,false);
	xmlHttp.send(xmlDoc);
	var dentist_comments_retVal = localTrimString(xmlHttp.responseText);

	formObj.dentist_comments.value = dentist_comments_retVal;
	//
}

function enableDisableSurface(obj){
	var formObj = document.forms[0];
	var oh_condition_type = formObj.oh_condition_type.value;
	var oh_surface = formObj.oh_surface.value;
	if(obj.value != null ){
		if(obj.value == 'ROOT' || obj.value == 'CROWN'){
			if(oh_condition_type == "PULPINV" || oh_condition_type == "PERIINV"){
				formObj.oh_surface.disabled = true;
				document.getElementById("MandatorySurface").style.visibility = 'hidden';
			}
			else{
				formObj.oh_surface.disabled = false;
				document.getElementById("MandatorySurface").style.visibility = 'visible';
			}
		}else{
			formObj.oh_surface.disabled = true;
			document.getElementById("MandatorySurface").style.visibility = 'hidden';
			if(oh_condition_type != "PULPINV" || oh_condition_type != "PERIINV"){
				formObj.oh_surface.disabled = false;
				document.getElementById("MandatorySurface").style.visibility = 'visible';
			}
		}
   }
}

function enableDisableCuspTip(obj){
	if(obj.value != null ){
		if(obj.value == 'ROOT' || obj.value == 'CROWN'){
			if (document.forms[0].oh_cusp_tip.options.length==1){
				document.forms[0].oh_cusp_tip.disabled = true;
			}
			else{
				document.forms[0].oh_cusp_tip.disabled = false;
			}
		}
		else{
			document.forms[0].oh_cusp_tip.disabled = true;

		}
	}
}

function populateSiteOptions(obj){
	if(obj.value != ""){ // This to clear the message frame when u are recording fresh condition..
		var messageFrame = parent.parent.parent.parent.parent.messageFrame;
		messageFrame.location.href="../../eCommon/jsp/error.jsp" ;
	}

	clear_list(document.forms[0].oh_site); 
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_site.add(optSel);
	var trmt_condition_type_val = obj.value;
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "trmt_condition_type_val="+trmt_condition_type_val+"&tab_name="+tab_name;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateSiteOptions&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	
	if(retVal.length>1){
		var retVal_arr = retVal.split("~");
		for(var i=0;i<retVal_arr.length-1;i++){
			var code_desc_arr = retVal_arr[i].split("##");
			var element 	= document.createElement('OPTION') ;
			element.value 	= code_desc_arr[0];
			element.text 	= code_desc_arr[1] ;
			document.forms[0].oh_site.add(element);
		}
	}
}

function populateDentalcondition(obj){
	clear_list(document.forms[0].oh_dental_condition); 
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_dental_condition.add(optSel);
	var condition_type_val = obj.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "condition_type_val="+condition_type_val;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateDentalcondition&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal.length>1){
		var retVal_arr = retVal.split("~");
		for(var i=0;i<retVal_arr.length-1;i++){
			var code_desc_arr = retVal_arr[i].split("##");
			var element 	= document.createElement('OPTION') ;
			element.value 	= code_desc_arr[0];
			element.text 	= code_desc_arr[1] ;
			document.forms[0].oh_dental_condition.add(element);
		}
	}
}

//commened by parul for surface
/*function populateSurfaces(obj){
	var formObj = document.forms[0];
	var site_type_val = document.forms[0].oh_site.value;
	var tooth_no_val = obj.value;
	//var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var dentalchartFormObj = parent.parent.conditionDentalChartDetails;
	var oh_condition_type = formObj.oh_condition_type.value;//added by parul on 151008

	var tooth_layer = "toothLayer"+tooth_no_val;
	var root_layer = "rootLayer"+tooth_no_val;
	var surface_applicable_yn = 'Y';
	
	if(site_type_val == "CROWN"){
		if(dentalchartFormObj.document.getElementById(tooth_layer) == null || dentalchartFormObj.document.getElementById(tooth_layer) == "" || dentalchartFormObj.document.getElementById(tooth_layer) == "null" || dentalchartFormObj.document.getElementById(tooth_layer) == "undefined"){
			surface_applicable_yn = "N";
			
		}
	}
	else if(site_type_val == "ROOT"){
		if(dentalchartFormObj.document.getElementById(root_layer) == null || dentalchartFormObj.document.getElementById(root_layer) == "" || dentalchartFormObj.document.getElementById(root_layer) == "null" || dentalchartFormObj.document.getElementById(root_layer) == "undefined"){
			surface_applicable_yn = "N";
		}
	}

	clear_list(document.forms[0].oh_surface); 
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_surface.add(optSel);
	if(oh_condition_type!="PERIINV"){  //added by parul on 151008 if condition is PERIINV than surface shpuld not come
	    if(surface_applicable_yn == "Y"){	
		//if(mixed_dentition_YN == "Y"){
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "site_type_val="+site_type_val+"&tooth_no_val="+tooth_no_val;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateSurfaces&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(retVal.length>1){
				if(document.forms[0].oh_condition_type.value == "PULPINV" || document.forms[0].oh_condition_type.value == "PERIINV"){
					document.getElementById("MandatorySurface").style.visibility = 'hidden';
				}
				else{
					document.getElementById("MandatorySurface").style.visibility = 'visible';
				}
				var retVal_arr = retVal.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					var code_desc_arr = retVal_arr[i].split("##");
					var element 	= document.createElement('OPTION') ;
					element.value 	= code_desc_arr[0];
					element.text 	= code_desc_arr[1] ;
					//commented fro surface
				     if (document.forms[0].oh_condition_type.value != "PULPINV" ||  document.forms[0].oh_condition_type.value == "PERIINV")	{// written by parul on 160908,if condition_type is PULPINV/PERIINV than surface should not come
					      document.forms[0].oh_surface.add(element);
						  }
						  
				     }
					 formObj.oh_surface.disabled = false;// written by parul on 230908 
			  }else{
					formObj.oh_surface.disabled = true;// written by parul on 220908 if there is no value in surface than it should be disable
				   document.getElementById("MandatorySurface").style.visibility = 'hidden';
			}
			
					      document.forms[0].oh_surface.add(element);
						  }
				     }
			  }else{
				   document.getElementById("MandatorySurface").style.visibility = 'hidden';
			}
		//}
	 } 
 }
	else{
		document.getElementById("MandatorySurface").style.visibility = 'hidden';
	}
}
*/

function populateSurfaces(obj){
	var formObj = document.forms[0];
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var site_type_val = formObj.oh_site.value;
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var tooth_no_val = obj.value;
	var dentalchartFormObj = parent.parent.conditionDentalChartDetails;
	var tooth_layer = "toothLayer"+tooth_no_val;
	var root_layer = "rootLayer"+tooth_no_val;
	var surface_applicable_yn = 'Y';
	//Commented by Sridevi Joshi on 2/19/2010 for IN019472
	/*if(site_type_val == "CROWN"){
		if((dentalchartFormObj.document.getElementById(tooth_layer) == null || dentalchartFormObj.document.getElementById(tooth_layer) == "" || dentalchartFormObj.document.getElementById(tooth_layer) == "null" || dentalchartFormObj.document.getElementById(tooth_layer) == "undefined") && called_from_viewchart_yn != "Y"){
			surface_applicable_yn = "N";
		}
	}
	else if(site_type_val == "ROOT"){
		if((dentalchartFormObj.document.getElementById(root_layer) == null || dentalchartFormObj.document.getElementById(root_layer) == "" || dentalchartFormObj.document.getElementById(root_layer) == "null" || dentalchartFormObj.document.getElementById(root_layer) == "undefined") && called_from_viewchart_yn != "Y"){
			surface_applicable_yn = "N";
		}
	}*/
	
	/* By Sridevi Joshi for IN009202(SRR20056-CRF-0454-OH) on 04/08/09.....To Remove surfaces from the list box when Deciduous tooth EXFOLTH and Permanent tooth ERUPTH.Applicable only for tooth 33,34,41,42,43,44,51,52 */
	if(site_type_val == "ROOT" && mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
		if(tooth_no_val == "33" || tooth_no_val == "34" || tooth_no_val == "41" || tooth_no_val == "42" || tooth_no_val == "43" || tooth_no_val == "44" || tooth_no_val == "51" || tooth_no_val == "52"){
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_val;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkROOTINVOnDecth&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal = localTrimString(retVal);
			
			if(retVal.length > 0 && retVal == "Y"){
				surface_applicable_yn = "N";
			}
		}
	}	/* End */
     if(site_type_val == "MAXFS"){
                surface_applicable_yn = "N";
        }

	
	clear_list(document.forms[0].oh_surface); 
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_surface.add(optSel);
	var surface_label=getLabel("eOH.DefaultSelect.Label","OH");
	if(surface_applicable_yn == "Y"){	
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "site_type_val="+site_type_val+"&tooth_no_val="+tooth_no_val;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateSurfaces&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		if(retVal.length>1){
			if(document.forms[0].oh_condition_type.value == "PULPINV" || document.forms[0].oh_condition_type.value == "PERIINV"){
				document.getElementById("MandatorySurface").style.visibility = 'hidden';
				retVal="";//should not populate surface added by parul 25/01/2010 for CRF-442
			}
			else{
				
				document.getElementById("oh_surface").disabled = false;
				document.getElementById("MandatorySurface").style.visibility = 'visible';
			}
			if (document.forms[0].oh_condition_type.value=="CARIES"){
					document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" size=3 multiple  onChange="populateCuspTip(this)"><option value="">'+surface_label+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';	

			}else{
				document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" onChange="populateCuspTip(this)"><option value="">'+surface_label+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';
				
				if(retVal.length>1){
					document.getElementById("oh_surface").disabled = false;
					//document.getElementById("MandatorySurface").style.visibility = 'hidden';
				}else{
					document.getElementById("oh_surface").disabled = true;
					document.getElementById("MandatorySurface").style.visibility = 'hidden';
				}
			}

			var retVal_arr = retVal.split("~");
			for(var i=0;i<retVal_arr.length-1;i++){
				var code_desc_arr = retVal_arr[i].split("##");
				var element 	= document.createElement('OPTION') ;
				element.value 	= code_desc_arr[0];
				element.text 	= code_desc_arr[1] ;
				document.forms[0].oh_surface.add(element);
			}
		}
		else{
			if (document.forms[0].oh_condition_type.value=="CARIES"){
				document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" size=3 multiple  onChange="populateCuspTip(this)"><option value="">'+surface_label+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';	

			}else{
				document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" onChange="populateCuspTip(this)"><option value="">'+surface_label+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';	
			}
			formObj.oh_surface.disabled = true;// written by Sridevi on 04/08/09 if there is no value in surface than it should be disable
			document.getElementById("MandatorySurface").style.visibility = 'hidden';
		}
	}
	else{
		if(site_type_val == "MAXFS"){ //Added by Sridevi Joshi on 3/3/2010 for IN019598
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "site_type_val="+site_type_val+"&tooth_no_val="+tooth_no_val;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateSurfaces&"+params,false);
			xmlHttp.send(xmlDoc);
			retVal = trimString(xmlHttp.responseText);
			if(retVal.length>1){
				document.getElementById("MandatorySurface").style.visibility = 'visible';
				var retVal_arr = retVal.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					var code_desc_arr = retVal_arr[i].split("##");
					var element 	= document.createElement('OPTION') ;
					element.value 	= code_desc_arr[0];
					element.text 	= code_desc_arr[1] ;
					document.forms[0].oh_surface.add(element);
				}
				 formObj.oh_surface.disabled = false;// written by parul on 070109 
			}
			else{
				formObj.oh_surface.disabled = true;// written by Sridevi on 20/10/09 if there is no value in surface than it should be disable
				document.getElementById("MandatorySurface").style.visibility = 'hidden';
			}
		}
		else{
			if (document.forms[0].oh_condition_type.value=="CARIES"){
				document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" size=3 multiple  onChange="populateCuspTip(this)"><option value="">'+surface_label+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';	

			}else{
				document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" onChange="populateCuspTip(this)"><option value="">'+surface_label+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';	
			}
			formObj.oh_surface.disabled = true;// written by Sridevi on 04/08/09 if there is no value in surface than it should be disable
			document.getElementById("MandatorySurface").style.visibility = 'hidden';
		}
	}
}



function populateCuspTip(obj){
	var formObj = document.forms[0];
	var tooth_num="";
	var tooth_name="";
	var mapped_tooth_no="";
	var mixed_dent_tooth_no="";
	var condition_type1="";
	var disply_tooth_no="";
	var surface_ref="";
	var tooth_no_hid=formObj.oh_area.value;
	var chart_num=formObj.chart_num.value;
	var patient_id=formObj.patient_id.value;
	var permanent_deciduous_flag=formObj.permanent_deciduous_flag.value;
	var mixed_dentition_YN=formObj.mixed_dentition_YN.value;
	var tooth_numbering_system=formObj.tooth_numbering_system.value;
	var condition_type=formObj.condition_type.value;	
	var super_tooth_ref=formObj.super_tooth_ref.value;	

	//Added Common block for these queries by Sridevi Joshi on 4/23/2010 for PE
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "tooth_no="+tooth_no_hid+"&patient_id="+patient_id+"&chart_num="+chart_num;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateDisplayCondition&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal1 = trimString(xmlHttp.responseText);
	retVal1 = localTrimString(retVal1);

	if(retVal1.length > 1){
		var retVal_arr1 = retVal1.split("~");
		for(var u=0;u<retVal_arr1.length-1;u++){
			condition_type1 = retVal_arr1[u];

			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+tooth_no_hid+"&numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateDisplayToothNoAndName&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal = localTrimString(retVal);
			if(retVal.length > 1){
				var retVal_arr = retVal.split("##");
				mapped_tooth_no = retVal_arr[2];
			}

			if ((permanent_deciduous_flag=="D" || permanent_deciduous_flag=="P") && mixed_dentition_YN=="Y"){
				if(super_tooth_ref=="RD"){
					if(permanent_deciduous_flag=="D" && mixed_dentition_YN=="Y"){
						tooth_no_hid=formObj.oh_area.value;
						break;
					}else{ 
						tooth_no_hid=mapped_tooth_no;
						break;
					}
				}else{
					if(condition_type1=="DECITH" || condition_type1=="ERUPTH" ){
						tooth_no_hid=mapped_tooth_no;
						if(mapped_tooth_no=="" || mapped_tooth_no=="null" || mapped_tooth_no==null) {
							tooth_no_hid=formObj.oh_area.value;	
						}
					}else if (permanent_deciduous_flag=="D" && mixed_dentition_YN=="Y" ){
						if(condition_type1=="ERUPTH" || condition_type1=="PARERTH") {
							tooth_no_hid=mapped_tooth_no;
							if (mapped_tooth_no=="" || mapped_tooth_no=="null" || mapped_tooth_no==null) {
								tooth_no_hid=formObj.oh_area.value;	
							}
							break;
						}
					}else{
						tooth_no_hid=formObj.oh_area.value;	
						break;
					}
				}
			}
			else{
				if(super_tooth_ref=="RD"){
					tooth_no_hid=mapped_tooth_no;
					break;
				}else{
					tooth_no_hid=formObj.oh_area.value;	
					break;
				}
			}
		}
	}

	
	clear_list(document.forms[0].oh_cusp_tip); 
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_cusp_tip.add(optSel);

	//var surface_code_val = obj.value;
 //added by parul for CRF#0483 on 21/08/2009
	for(var m=0;m<formObj.oh_surface.options.length;m++){
		
		if(formObj.oh_surface.options[m].selected==true){
			if(surface_ref==""){
				surface_ref=formObj.oh_surface.options[m].value;
			}else{
				surface_ref=surface_ref+","+formObj.oh_surface.options[m].value;
			}
	   }
   }

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
//	var params = "surface_code_val="+surface_code_val+"&tooth_no_hid="+tooth_no_hid;
	var params = "surface_code_val="+surface_ref+"&tooth_no_hid="+tooth_no_hid;

	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateCuspTip&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal.length>1){
		var retVal_arr = retVal.split("~");
		for(var i=0;i<retVal_arr.length-1;i++){
			var code_desc_arr = retVal_arr[i].split("##");
			var element 	= document.createElement('OPTION') ;
			element.value 	= code_desc_arr[0];
			element.text 	= code_desc_arr[1] ;
			document.forms[0].oh_cusp_tip.add(element);
			
		}
		formObj.oh_cusp_tip.disabled=false;
	}else{
		formObj.oh_cusp_tip.disabled=true;

	}
}

function actionToServlet(){
	var tooth_num = "";
	var tooth_name = "";
	var mapped_tooth_no = "";
	var tooth_no ;
	var super_before = "N";
	var status = "";
	var exfolth_count = 0;
	var retained_tooth_no = "";
	var retVal_SuperKey_count=0;
	var total_SuperKey_count=0;
	var super_recorded = "N";
	/* Added by Sridevi Joshi on 2/21/2010 for IN019472 */
	var unerth_rec = "";
	var parerth_rec = "";
	var erupth_rec = "";
	var exfolth_rec = "";
	var missth_rec = "";
	var impactn_rec = "";
	var impactn_rec = "";
	var extract_rec = "";
	var implant_rec = "";
	var denture_rec = "";
	var bridge_rec = "";
	var db_cond_type = "";
	var db_trmt_type = "";
	/* end for IN019472 */

	var formObj=document.forms[0];
	var RD_Normal_yn  = formObj.RD_Normal_yn.value;
	var selected_first_thno  = formObj.selected_first_thno.value;
	var messageFrame = parent.parent.parent.parent.parent.messageFrame;
	var patient_id = formObj.patient_id.value;
	var site_type = formObj.oh_site.value;
	var surface = formObj.oh_surface.value;
	var chart_num = formObj.chart_num.value;
	var surface_code = formObj.oh_surface.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var numbering_system = formObj.tooth_numbering_system.value;
	var addNewChart_yn = formObj.addNewChart_yn.value;
	var dentalChartFormObj = parent.parent.conditionDentalChartDetails;
	var condition_type = formObj.oh_condition_type.value;
	var thrng_nos_ref = formObj.thrng_nos_ref.value;

	var clinical_group_code = parent.f_query_add_mod_middle.document.forms[0].oh_clinical_group.value;
	var called_from_viewchart_yn = formObj.called_from_viewchart_yn.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	//added by parul on 14/08/2009 for CRF#483
	var oh_cusp_tip = formObj.oh_cusp_tip.value;
	var cusptip_ref = formObj.cusptip_ref.value;
	var surface_ref = formObj.surface_ref.value;//added by parul on 21/01/2010 for CRF-442
	if(called_from_viewchart_yn == "Y"){
		surface_code = formObj.surface_hid.value;  //Surface from RHS menu
		status = formObj.oh_status.value;
		cusptip_ref = formObj.cusp_tip_code_hid.value;
		surface_ref = formObj.surface_hid.value;//added by parul on 21/01/2010 for CRF-442
	}
	var chart_line_num= formObj.chart_line_num.value;
	//Added by Sharon Crasta on 9/18/2009 for IN009739(SRR20056-CRF-0457)
	var other_chart_facility_id= formObj.other_chart_facility_id.value;
   	var dental_condition = formObj.oh_dental_condition.value;

   	var super_tooth_ref = formObj.super_tooth_ref.value; //Added By Sridevi Joshi on 12/7/2009 for SUPRTH new Changes
   	var super_key_num = formObj.super_key_num.value; //Added By Sridevi Joshi on 1/24/2010 for SUPRTH new Changes (IN010894)

	parent.parent.conditionDentalChartView.document.forms[0].RD_Normal_yn.value = RD_Normal_yn;

	formObj.clinical_group_code.value = clinical_group_code
	formObj.condition_type.value = formObj.oh_condition_type.value;
	formObj.site.value = formObj.oh_site.value;
	formObj.area.value = formObj.oh_area.value;
	formObj.dental_condition.value = formObj.oh_dental_condition.value;

	//Added by Sharon Crasta on 12/22/2009 for RTDESTH new changes TO GET mapped tooth no
	var return_flag_alert = false;
	var return_surface_alert = false; 
	 if(super_tooth_ref == "RD"){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		params = "func_mode=getMappedToothNo&tooth_no="+tooth_no;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		retained_tooth_no = trimString(xmlHttp.responseText); 
		retained_tooth_no = localTrimString(retained_tooth_no); 
	}
	//End
    if(site_type == "MAXFS"){
	  thrng_nos_ref="";
	
	}

	if(condition_type == "DECITH"){
		formObj.decith_yn.value = "Y";
		dentalChartFormObj.document.forms[0].decith_yn.value = "Y";
	}
	
	//Added THRNG also in If condition to allow recording condition when selected from data entry for multiple tooth(In data entry multiple tooth is considered as THRNG but from menu multiple tooth is considered as TOOTH)
	
	if(site_type == "TOOTH" && thrng_nos_ref != ""){
		tooth_no = formObj.thrng_nos_ref.value;
	}
	else if((site_type == "TOOTH" || site_type == "THRNG") && thrng_nos_ref == ""){

		for (var m=0;m<formObj.oh_area.options.length; m++) {
			if (formObj.oh_area.options[m].selected == true) {
				if(thrng_nos_ref == ""){
					thrng_nos_ref = formObj.oh_area.options[m].value; 
				}
				else{
					thrng_nos_ref = thrng_nos_ref+","+formObj.oh_area.options[m].value; 
				}
			}
		}
		formObj.thrng_nos_ref.value = thrng_nos_ref;
		tooth_no = thrng_nos_ref;
	}
	else{
		tooth_no = formObj.oh_area.value;
	}
	if(site_type == "MAXFS" && thrng_nos_ref != ""){
		if(formObj.oh_selected_sub_parts.value == ""){ 
			formObj.oh_selected_sub_parts.options[0].selected =false;
		}
		tooth_no = formObj.thrng_nos_ref.value;
		var thrng_nos_ref_arr = thrng_nos_ref.split(",");
		tooth_range_count_for_order = thrng_nos_ref_arr.length 
	}
	else if (site_type == "MAXFS"){
		if(formObj.oh_sub_parts.value=="TNGAB" || formObj.oh_sub_parts.value=="TNGGM" || formObj.oh_sub_parts.value=="TNGAG" || formObj.oh_sub_parts.value=="TNGGAM" || formObj.oh_sub_parts.value=="TNGMF"){
			if(formObj.oh_selected_sub_parts.value == ""){ 
				formObj.oh_selected_sub_parts.options[0].selected =false;
			}
			if(thrng_nos_ref=="") {		if(formObj.oh_selected_sub_parts.options!=undefined){
				for(var m=0;m<formObj.oh_selected_sub_parts.options.length;m++){
				   if(formObj.oh_selected_sub_parts.options[m].selected==true){
					  if(thrng_nos_ref==""){
					  thrng_nos_ref=formObj.oh_selected_sub_parts.options[m].value;

					 }else{
						thrng_nos_ref=thrng_nos_ref+","+formObj.oh_selected_sub_parts.options[m].value;
					 }
				  }
				}
				formObj.thrng_nos_ref.value = thrng_nos_ref;
				tooth_no = thrng_nos_ref;
			}
			}else{
				tooth_no = formObj.oh_selected_sub_parts.value;
			}
		}
	}else if(site_type == "THRNG" && thrng_nos_ref == ""){
		tooth_range_count_for_order = formObj.oh_area.options.length 
		for (var m=0;m<formObj.oh_area.options.length; m++) {
			if (formObj.oh_area.options[m].selected == true) {
				formObj.oh_area.options[0].selected =false;     
				if(thrng_nos_ref == ""){
					thrng_nos_ref = formObj.oh_area.options[m].value; 
				}
				else{
					thrng_nos_ref = thrng_nos_ref+","+formObj.oh_area.options[m].value; 
				}
			}
		}
		formObj.thrng_nos_ref.value = thrng_nos_ref;
		tooth_no = thrng_nos_ref;
	}
	surface_ref="";//commented by parul on 04/08/2010 for  IN023050

	 //added by parul for SRR-CRF20056-0442 on 12/01/2010
	 if (surface_ref=="" || surface_ref=="null" || surface_ref==null || surface_ref=="undefined" || surface_ref==undefined){	
			for(var m=0;m<formObj.oh_surface.options.length;m++){
				formObj.oh_surface.options[0].selected =false;
			   if(formObj.oh_surface.options[m].selected == true){
				  if(surface_ref == ""){
					surface_ref = formObj.oh_surface.options[m].value;
				} else{
				  surface_ref = surface_ref+","+formObj.oh_surface.options[m].value;
				  }
			   }
		   }
		 formObj.surface_ref.value=surface_ref;
	   }else{
		
		 surface_ref=surface_ref;//commented by parul on 04/08/2010 for  IN023050
		 //surface_ref=formObj.oh_surface.value;
	   }
	  
	//Added to count the number of Exfoliated conditions recorded in case of Retained.
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH&RD_Normal_yn="+RD_Normal_yn;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfToothForSUPRTH&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	retVal = localTrimString(retVal);
	if(retVal.length > 0 && parseInt(retVal) > 0){ 
		var retVal_arr = retVal.split("##");
		exfolth_count = retVal_arr[0];			
	}

	//Added by SRidevi Joshi on 1/27/2010 for IN010894(SRR20056-CRF-0481). To get super_key_val
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	params = "func_mode=checkSuperKey&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn;

	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal_SuperKey = trimString(xmlHttp.responseText); 
	retVal_SuperKey = localTrimString(retVal_SuperKey); 
	var retVal_SuperKey_arr = retVal_SuperKey.split("~");

	if(retVal_SuperKey_arr.length >1){

		retVal_SuperKey_count = parseInt(retVal_SuperKey_arr.length)-1;
		
		total_SuperKey_count = parseInt(retVal_SuperKey_count)+1; //this is to include tooth_no count also
	}

	//To retrieve chart_line_num if SUPRTH is recorded
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=SUPRTH";
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithChrtLineNum&"+params,false);
	xmlHttp.send(xmlDoc);
	var suprth_chart_line_num = trimString(xmlHttp.responseText);
	suprth_chart_line_num = localTrimString(suprth_chart_line_num);
	if(suprth_chart_line_num.length > 0){
		super_recorded = "Y";
	}
	 
	 
	if(formObj != null){
		var area_title = area_legend;
		var condition_type_title=getLabel("eOH.ConditionType.Label","OH");
		var site_title = getLabel("Common.Site.label","Common");
		var dental_condition_title = getLabel("eOH.DentalCondition.Label","OH");
		var surface_title = getLabel("eOH.Surface.Label","OH");
		 var parts_title = getLabel("eOH.Parts.Label","OH");
		
		if(formObj.oh_surface.disabled == false && ((site_type=="CROWN" && formObj.oh_surface.options.length > 1) || (formObj.oh_surface.value=="" && site_type=="ROOT" && formObj.oh_condition_type.value != "PERIINV"))){
			
			var fields = new Array (formObj.oh_condition_type,formObj.oh_site,formObj.oh_area,formObj.oh_dental_condition,formObj.oh_surface);
			var names = new Array ( condition_type_title,site_title,area_title,dental_condition_title,surface_title);
		}
		else if(formObj.oh_site.value=="MOUTH" && formObj.oh_condition_type.value=="MXNTL"){
			var fields = new Array (formObj.oh_condition_type,formObj.oh_site,formObj.oh_dental_condition);
			var names = new Array ( condition_type_title,site_title,dental_condition_title);
	 }
                else if(formObj.oh_surface.disabled==false  && (formObj.oh_area.value=="I" || formObj.oh_area.value=="E")){
                        if (formObj.oh_sub_parts.value=="" ){
                                var fields = new Array (formObj.oh_condition_type,formObj.oh_site,formObj.oh_area,formObj.oh_dental_condition,formObj.oh_sub_parts);
                                var names = new Array ( condition_type_title,site_title,area_title,dental_condition_title,parts_title);
                                }
                                else if(formObj.oh_surface.value=="AB" || formObj.oh_surface.value=="GING" || formObj.oh_surface.value=="MBF")
                                {
                                        
                                 var count=0;
                                 if(formObj.oh_sub_parts.value=="TNGAB" || formObj.oh_sub_parts.value=="TNGGM" || formObj.oh_sub_parts.value=="TNGAG" || formObj.oh_sub_parts.value=="TNGGAM" || formObj.oh_sub_parts.value=="TNGMF"){ 
                                                for (var k=0;k<formObj.oh_selected_sub_parts.value+1; k++) {
                                                                        count++;
                                                }
                                                if (count==1 || count==0){
                                                        var fields = new Array (formObj.oh_condition_type,formObj.oh_site,formObj.oh_area,formObj.oh_selected_sub_parts,formObj.oh_surface,formObj.oh_dental_condition);
                                                        var names = new Array ( condition_type_title,site_title,area_title,parts_title,parts_title,dental_condition_title);
                                                }else{
														var fields = new Array (formObj.oh_condition_type,formObj.oh_site,formObj.oh_area,formObj.oh_dental_condition,formObj.oh_surface);
														var names = new Array ( condition_type_title,site_title,area_title,dental_condition_title,parts_title);
												}
									

									
                                 }              
                                else if (formObj.oh_sub_parts.value=="THAB" || formObj.oh_sub_parts.value=="THGM" || formObj.oh_sub_parts.value=="THAG" || formObj.oh_sub_parts.value=="THMF" || formObj.oh_sub_parts.value=="THGAM")
                                {
                                var fields = new Array (formObj.oh_condition_type,formObj.oh_site,formObj.oh_area,formObj.oh_dental_condition,formObj.oh_surface,formObj.oh_selected_sub_parts);
                                var names = new Array ( condition_type_title,site_title,area_title,dental_condition_title,parts_title,parts_title);
                                }
                                }
                                else
                                {
                                var fields = new Array (formObj.oh_condition_type,formObj.oh_site,formObj.oh_area,formObj.oh_dental_condition,formObj.oh_surface);
                                var names = new Array ( condition_type_title,site_title,area_title,dental_condition_title,parts_title);
                                }
								if(formObj.oh_sub_parts.disabled)
									{
										var fields = new Array (formObj.oh_condition_type,formObj.oh_site,formObj.oh_area,formObj.oh_dental_condition,formObj.oh_surface);
										var names = new Array ( condition_type_title,site_title,area_title,dental_condition_title,parts_title);
									}
                }
                else
                       
			{
			var fields = new Array (formObj.oh_condition_type,formObj.oh_site,formObj.oh_area,formObj.oh_dental_condition);
			var names = new Array ( condition_type_title,site_title,area_title,dental_condition_title);
		}

		if(checkFieldsofMst( fields, names, messageFrame)){	
			var dentalchartFormObj = parent.parent.conditionDentalChartDetails.document.forms[0];
			var thrng_nos = formObj.thrng_nos.value;
			var site_type = formObj.oh_site.value;
			formObj.chart_hdr_insert_yn.value  = dentalchartFormObj.chart_hdr_insert_yn.value;
			var chart_num  = dentalchartFormObj.chart_num.value;

			//To get mapped_tooth_no added by Sridevi Joshi on 1/11/2010 for IN010894
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateDisplayToothNoAndName&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal = localTrimString(retVal);
			if(retVal.length > 1){
				var retVal_arr = retVal.split("##");
				mapped_tooth_no = retVal_arr[2];
			}
			
			if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){ //Added by Sridevi Joshi on 1/11/2010 for IN010894
				var ns_tooth_no = "";
				var isRetainedYN = "";
				//To get Display_tooth_no
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "tooth_no="+mapped_tooth_no+"&numbering_system="+numbering_system;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				retVal=localTrimString(retVal);
				if(retVal.length > 0){
					ns_tooth_no = retVal;
				}

				//Added by Sridevi Joshi on 12/8/2009 for SUPRTH new changes
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				params = "func_mode=SuperRDyn&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal_cond = trimString(xmlHttp.responseText); 
				retVal_cond = localTrimString(retVal_cond); 
				var retVal_cond_arr = retVal_cond.split("##");
				var condition_type_ref = retVal_cond_arr[1];
				if(condition_type_ref == "RTDESTH"){
					isRetainedYN = "Y";
				}

				//if(super_tooth_ref != "RD" && super_tooth_ref != "s1" && super_tooth_ref != "s2" && isRetainedYN == "Y"){
				if(super_tooth_ref != "RD" && (super_tooth_ref == "" || super_tooth_ref == "undefined" || super_tooth_ref == undefined) && isRetainedYN == "Y"){
					//retained_tooth_no = ns_tooth_no; 
					retained_tooth_no = mapped_tooth_no;//commented above and Added by Sridevi Joshi on 4/8/2010 for IN020464..retained_tooth_no was going as dissplay tooth no
				}
			}
			else{
				if(super_tooth_ref == "RD" ){
					retained_tooth_no = mapped_tooth_no;
				}
			}

			// For getting PulpInvolvement Recorded_yn
			var pulpInvRecorded_yn = checkForPulpInvCond(site_type,tooth_no,patient_id,chart_num,called_from_viewchart_yn,condition_type,super_tooth_ref,retained_tooth_no);
			if(!pulpInvRecorded_yn){
				return;
			}

           //added by parul for SRR-CRF20056-0442 on 12/01/2010
          
		/* Block that will check for the applicable condition types and allow only those condition types recording*/
		if (cusptip_ref=="" || cusptip_ref=="null" || cusptip_ref==null || cusptip_ref=="undefined" || cusptip_ref==undefined){	
	        for(var m=0;m<formObj.oh_cusp_tip.options.length;m++){
				formObj.oh_cusp_tip.options[0].selected =false;
			   if(formObj.oh_cusp_tip.options[m].selected==true){
			      if(cusptip_ref==""){
				  cusptip_ref=formObj.oh_cusp_tip.options[m].value;
                 } else{
				  cusptip_ref=cusptip_ref+","+formObj.oh_cusp_tip.options[m].value;

				  }
			   }
           }

			formObj.cusptip_ref.value=cusptip_ref;

		}else{
	      cusptip_ref=formObj.oh_cusp_tip.value;
		  if (cusptip_ref=="" || cusptip_ref==null || cusptip_ref=="null"){
			   cusptip_ref=formObj.cusp_tip_code_hid.value;

		  }

          if (formObj.called_from_viewchart_yn.value=="Y") {//added by parul 14726
				 var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&condition_type="+condition_type+"&chart_num="+chart_num+"&dental_condition="+dental_condition+"&chart_line_num="+chart_line_num;//added by parul 14726
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=displayCuspTipName&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = localTrimString(xmlHttp.responseText);
				cusptip_ref=retVal;
		   }
	   }
	   var isSuprthError = ""
	   var isExfolthError = ""
	   var isRetainedError = ""

	   if(status == "E" && condition_type == "SUPRTH"){//Added by SRidevi Joshi on 1/26/2010 for (CRF-481 )IN010894
			isSuprthError = 'Y';
	   }

	    if(status == "E" && condition_type == "RTDESTH"){//Added by SRidevi Joshi on 1/26/2010 for (CRF-481 )IN010894
			isRetainedError = 'Y';
	   }

	   if(status == "E" && condition_type == "EXFOLTH"){//Added by SRidevi Joshi on 1/26/2010 for (CRF-481 )IN010894
			isExfolthError = 'Y';
	   }
	 

	if(status!="E" ){
			populateAllConditionTypes(site_type,RD_Normal_yn);
			// get the list of function_id's (menu_id)
			var function_id_list = formObj.function_id_list.value;
			var function_id_list_array  = function_id_list.split("##"); // the functions are separated by ##
			var menu_id_list = "";
			for (var i=0;i<function_id_list_array.length-1;i++ ){
				if(i==0)
					menu_id_list = function_id_list_array[i];
				else{
					menu_id_list += "~";
					menu_id_list += function_id_list_array[i];
				}
			}

			// get the list of function_names (menu_names)
			var function_name_list = formObj.function_name_list.value;
			var function_name_list_array  = function_name_list.split("##"); // the functions are separated by ##
			var menu_name_list = "";
			for (var i=0;i<function_name_list_array.length-1;i++ ){
				if(i==0)
					menu_name_list = function_name_list_array[i];
				else{
					menu_name_list += "~";
					menu_name_list += function_name_list_array[i];
				}
			}

			// get the list of function_types for each menu
			var function_type_list = formObj.function_type_list.value;
			var function_type_list_array  = function_type_list.split("##"); // the functions are separated by ##
			var menu_type_list = "";
			for (var i=0;i<function_type_list_array.length-1;i++ ){
				if(i==0)
					menu_type_list = function_type_list_array[i];
				else{
					menu_type_list += "~";
					menu_type_list += function_type_list_array[i];
				}
			}

			// get the list of function_types_desc for each menu
			var function_type_desc_list = formObj.function_type_desc_list.value;
			var function_type_desc_list_array  = function_type_desc_list.split("##"); // the functions are separated by ##
			var menu_type_desc_list = "";
			for (var i=0;i<function_type_desc_list_array.length-1;i++ ){
				if(i==0)
					menu_type_desc_list = function_type_desc_list_array[i];
				else{
					menu_type_desc_list += "~";
					menu_type_desc_list += function_type_desc_list_array[i];
				}
			}

			// get the list of function_cat_code for each menu
			var function_cat_code_list = formObj.function_cat_code_list.value;
			var function_cat_code_list_array  = function_cat_code_list.split("##"); // the functions are separated by ##
			var menu_cat_code_list = "";
			for (var i=0;i<function_cat_code_list_array.length-1;i++ ){
				if(i==0)
					menu_cat_code_list = function_cat_code_list_array[i];
				else{
					menu_cat_code_list += "~";
					menu_cat_code_list += function_cat_code_list_array[i];
				}
			}
			
			menu_id_list		= trimString(menu_id_list);
			menu_name_list		= trimString(menu_name_list);
			menu_type_list	    = trimString(menu_type_list);
			menu_type_desc_list	    = trimString(menu_type_desc_list);
			menu_cat_code_list	    = trimString(menu_cat_code_list);

			var id_rowval		= menu_id_list.split ("~"); // function_id
			var id_name_rowval  = menu_name_list.split ("~"); // function_name
			var id_type_rowval  = menu_type_list.split ("~"); // function_type
			var id_type_desc_rowval  = menu_type_desc_list.split ("~"); // function_type_desc
			var id_cat_code_rowval  = menu_cat_code_list.split ("~"); // function_cat_code

			var applicable_cond_types = id_type_rowval;
			var applicable_cond_desc = id_type_desc_rowval;

			var msg_arr = "";
			var alert_flag="";
			var applicable_yn="";

			if((tooth_no.indexOf(",") == -1 && site_type == "TOOTH" ) || (site_type == "ROOT" || site_type == "CROWN" || site_type == "ARCH" || site_type == "QUAD")){
				//Commented by Sharon Crasta on 6/16/2009 for #IN011409
				//var display_yn = checkApplicableConditionTypes(tooth_no,patient_id,chart_num,numbering_system,permanent_deciduous_flag,mixed_dentition_YN,RD_Normal_yn,site_type,thrng_nos_ref);

				//Added formObj.area.value by Sharon Crasta on 2/4/2010 for SRR20056-CRF-0498(IN010982)
				var display_yn = checkApplicableConditionTypes(tooth_no,patient_id,chart_num,numbering_system,permanent_deciduous_flag,mixed_dentition_YN,RD_Normal_yn,site_type,thrng_nos_ref,oh_chart_level,'',formObj.area.value);
				//
				var applicable_yn = display_yn.split("~~");
				var display_menu_yn = applicable_yn[0];
				
				//Commented and Added by Sharon Crasta on 3/13/2009 to pass the site_type to accept the data entry for the first quadrant.
				//var alert_flag = resultedConditionTypes(applicable_yn,applicable_cond_types,applicable_cond_desc,tooth_no,mixed_dentition_YN,permanent_deciduous_flag,display_menu_yn,condition_type,site_type);
				var alert_flag = resultedConditionTypes(applicable_yn,applicable_cond_types,applicable_cond_desc,tooth_no,mixed_dentition_YN,permanent_deciduous_flag,display_menu_yn,condition_type,site_type,RD_Normal_yn);
				//
				
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				params = "func_mode=checkForExtractionSupernumerary&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;  //Added super_tooth_ref and RTDESTH by Sharon Crasta on 12/21/2009 for SUPRTH changes
					
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal_trmt = trimString(xmlHttp.responseText); 
				retVal_trmt = localTrimString(retVal_trmt); 
				
				if(parseInt(retVal_trmt) >= 1){ 
					applicable_cond_types = "";
				}
				
				//added by parul for IN17337(Able to record deciduous tooth condition(from its own menu) on the permanent tooth in mixed dentition permanent chart after multiselecting with other permanent tooth no ) on 17/12/2009
				if(permanent_deciduous_flag=="P" && mixed_dentition_YN=="Y"){
					for(z=0;z<applicable_yn.length;z++){
						if((applicable_yn[z] == "cariestooth_not_applicable" || applicable_yn[z] =="pulpinv_not_applicable"|| applicable_yn[z] =="periinv_not_applicable" || applicable_yn[z] =="rootinvtooth_not_applicable") && condition_type=="DECITH" ){
							alert(getMessage("APP-OH000126","OH"));
								return;
						}
					
					}
				}
				//Added by Sharon Crasta on 12/16/2009 for IN016953
				//If an extraction order is placed/scheduled, then Deciduous/Missing/Unerupted/Partial Eruption/Impaction/Retained tooth should not be recorded on that tooth.
				var flag = ""; //added by Sridevi joshi getting sript eerror
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params_trmt = "func_mode=checkForExtractionConditions&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;

				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_trmt,false);
				xmlHttp.send(xmlDoc);																    
				var retVal_trmt = trimString(xmlHttp.responseText); 
				retVal_trmt = localTrimString(retVal_trmt);
				retVal_trmt = parseInt(retVal_trmt);
				
				//Added by Sharon Crasta on 12/23/2009 for new SUPRTH and RTDESTH changes.
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params_ext_trmt = "func_mode=checkForExtractionSupernumeraryExtTrmt&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_ext_trmt,false);
				xmlHttp.send(xmlDoc);
				var retVal_ext_trmt = trimString(xmlHttp.responseText); 
				retVal_ext_trmt = localTrimString(retVal_ext_trmt);
				retVal_ext_trmt = parseInt(retVal_ext_trmt);
				//End

				if(retVal_trmt > 0 && retVal_ext_trmt == 0 && (condition_type=="DECITH" || condition_type=="UNERTH" || condition_type=="PARERTH" || condition_type=="IMPACTN" || condition_type=="RTDESTH" || condition_type=="MISSTH")) { 
					if(condition_type=="DECITH"){
						var label = getLabel("eOH.Decedious.Label","OH");
					}
					else if(condition_type=="UNERTH"){
						var label = getLabel("eOH.Uneruption.Label","OH");
					}
					else if(condition_type=="PARERTH"){
						var label = getLabel("eOH.PartialEruption.Label","OH");							
					} 
					else if(condition_type=="IMPACTN"){
						var label = getLabel("eOH.Impaction.Label","OH");									
					}
					else if(condition_type=="MISSTH"){
						var label = getLabel("eOH.MissingTooth.Label","OH");								
					}
					else if(condition_type=="RTDESTH"){
						var label = getLabel("eOH.RetainedDeciduous.Label","OH");
					}
					
					var msg = getMessage("APP-OH000145","OH"); 
					msg_arr = msg.split("##");

					return_flag_alert = true;
					//Commented by Sharon Crasta on 12/23/2009
					//Record SUPRTH-->Primary Tooth->EXTRACT, then record MISSTH from data entry. Should show not applicable message first.
					//alert(msg_arr[0]+"'"+label+"'"+msg_arr[1]);
					//return;
				} //end 

				//Added by Sharon Crasta on 2/28/2010 for IN019467
				//If an Bridge order is placed/scheduled, then Deciduous/Missing/Unerupted/Partial Eruption/Impaction/Retained tooth should not be recorded on that tooth.
				var flag = ""; //added by Sridevi joshi getting sript eerror
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params_bridge_extract = "func_mode=getTrmtCatCode&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_bridge_extract,false);
				xmlHttp.send(xmlDoc);
				var retVal_bridge_extract = trimString(xmlHttp.responseText); 
				retVal_bridge_extract = localTrimString(retVal_bridge_extract);
				
				if(retVal_bridge_extract > 0 && retVal_bridge_extract == 0 && (condition_type=="DECITH" || condition_type=="UNERTH" || condition_type=="PARERTH" || condition_type=="IMPACTN" || condition_type=="RTDESTH" || condition_type=="MISSTH" )) { 
					if(condition_type=="DECITH"){
						var label = getLabel("eOH.Decedious.Label","OH");
					}
					else if(condition_type=="UNERTH"){
						var label = getLabel("eOH.Uneruption.Label","OH");
					}
					else if(condition_type=="PARERTH"){
						var label = getLabel("eOH.PartialEruption.Label","OH");							
					} 
					else if(condition_type=="IMPACTN"){
						var label = getLabel("eOH.Impaction.Label","OH");									
					}
					else if(condition_type=="MISSTH"){
						var label = getLabel("eOH.MissingTooth.Label","OH");								
					}
					else if(condition_type=="RTDESTH"){
						var label = getLabel("eOH.RetainedDeciduous.Label","OH");
					}
					
					
					var msg = getMessage("APP-OH000176","OH"); 
					msg_arr = msg.split("##");

					return_flag_alert = true;
					
				} //End
                //added by parul on 29/01/2010 for CRF-442
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
                 var super_tooth_no="";
                 //var retained_tooth_no="";//commented by Sridevi Joshi on 4/12/2010 for IN020635  .. retained_tooth_no was going as null bcoz of this
				 if (super_tooth_ref!="" && super_tooth_ref!="" && super_tooth_ref!="" && super_tooth_ref!="RD") {
					 super_tooth_no=tooth_no+""+super_tooth_ref.substring(super_tooth_ref.length-1,super_tooth_ref.length);

				 }
				 if(super_tooth_ref == "RD"){//Added by parul on 12/17/2009 for RTDESTH new changes
				//Added by parul on 12/17/2009 for RTDESTH new changes TO GET mapped tooth no
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					params = "func_mode=getMappedToothNo&tooth_no="+tooth_no;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
					xmlHttp.send(xmlDoc);
					retained_tooth_no = trimString(xmlHttp.responseText); 
					retained_tooth_no = localTrimString(retained_tooth_no); 
				}
				var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&super_tooth_no="+super_tooth_no+"&retained_tooth_no="+retained_tooth_no+"&treatment_int_ext=I";

				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=ChkAllsurfacePopulation&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal_surface = localTrimString(xmlHttp.responseText);
				if (retVal_surface=="*A"){
					return_surface_alert = true;
				}
				//end

				//Added by Sharon Crasta on 3/15/2010 for SRR20056-CRF-0475(IN010868)
				//If the Bridge Treatment is registered in the Trmt Tab, then crown related menu should not be seen
				var oh_chart_level = document.forms[0].oh_chart_level.value;
				var other_chart_facility_id = document.forms[0].other_chart_facility_id.value;
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&super_tooth_no="+super_tooth_no+"&retained_tooth_no="+retained_tooth_no+"&treatment_int_ext=I"+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getStatusForBridge&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal_status_for_bridge = localTrimString(xmlHttp.responseText);
				//End
			}
			else if(tooth_no.indexOf(",") != -1){
				var nors_arr = tooth_no.split(",");
				for(j=0;j<nors_arr.length;j++){
					//This function is to check the applicable menu options..
					//Commented by Sharon Crasta on 6/16/2009 for #IN011409
					//var display_yn = checkApplicableConditionTypes(nors_arr[j],patient_id,chart_num,numbering_system,permanent_deciduous_flag,mixed_dentition_YN,RD_Normal_yn,site_type,thrng_nos_ref);
					var display_yn = checkApplicableConditionTypes(nors_arr[j],patient_id,chart_num,numbering_system,permanent_deciduous_flag,mixed_dentition_YN,RD_Normal_yn,site_type,thrng_nos_ref,oh_chart_level);
					//
					var applicable_yn = display_yn.split("~~");
					var display_menu_yn = applicable_yn[0];

					var alert_flag = resultedConditionTypes(applicable_yn,applicable_cond_types,applicable_cond_desc,nors_arr[j],mixed_dentition_YN,permanent_deciduous_flag,display_menu_yn,condition_type,site_type,RD_Normal_yn);

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					params = "func_mode=checkForExtractionSupernumerary&tooth_no="+nors_arr[j]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&RD_Normal_yn="+RD_Normal_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;  //Added super_tooth_ref and retained_tooth_no by Sharon Crasta on 12/21/2009 for SUPRTH and RTDESTH changes;
				
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_trmt = trimString(xmlHttp.responseText); 
					retVal_trmt = localTrimString(retVal_trmt); 
			
					if(parseInt(retVal_trmt) >= 1){ 
						applicable_cond_types = "";
					}
					
					//added by parul for IN17337(Able to record deciduous tooth condition(from its own menu) on the permanent tooth in mixed dentition permanent chart after multiselecting with other permanent tooth no ) on 17/12/2009
					if(permanent_deciduous_flag=="P" && mixed_dentition_YN=="Y"){
						for(z=0;z<applicable_yn.length;z++){
							if((applicable_yn[z] == "cariestooth_not_applicable" || applicable_yn[z] =="pulpinv_not_applicable"|| applicable_yn[z] =="periinv_not_applicable" || applicable_yn[z] =="rootinvtooth_not_applicable") && condition_type=="DECITH" ){
								alert(getMessage("APP-OH000126","OH"));
									return;
							}
						
						}
					}

					//Added by Sharon Crasta on 12/16/2009 for IN016953
					//If an extraction order is placed/scheduled, then Deciduous/Missing/Unerupted/Partial Eruption/Impaction/Retained tooth should not be recorded on that tooth.
					var flag = ""; //added by Sridevi joshi getting sript eerror
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					params = "func_mode=checkForExtractionConditions&tooth_no="+nors_arr[j]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_trmt = trimString(xmlHttp.responseText); 
					retVal_trmt = localTrimString(retVal_trmt); 
					retVal_trmt = parseInt(retVal_trmt); 
					
					//Added by Sharon Crasta on 12/23/2009 for new SUPRTH and RTDESTH changes.
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params_ext_trmt = "func_mode=checkForExtractionSupernumeraryExtTrmt&tooth_no="+nors_arr[j]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_ext_trmt,false);
					xmlHttp.send(xmlDoc);
					var retVal_ext_trmt = trimString(xmlHttp.responseText); 
					retVal_ext_trmt = localTrimString(retVal_ext_trmt);
					retVal_ext_trmt = parseInt(retVal_ext_trmt);
					//End

					if(retVal_trmt > 0 && retVal_ext_trmt == 0 && (condition_type=="DECITH" || condition_type=="UNERTH" || condition_type=="PARERTH" || condition_type=="IMPACTN" || condition_type=="RTDESTH" || condition_type=="MISSTH")) { 
						if(condition_type=="DECITH"){
							var label = getLabel("eOH.Decedious.Label","OH");
						}
						else if(condition_type=="UNERTH"){
							var label = getLabel("eOH.Uneruption.Label","OH");
						}
						else if(condition_type=="PARERTH"){
							var label = getLabel("eOH.PartialEruption.Label","OH");							
						} 
						else if(condition_type=="IMPACTN"){
							var label = getLabel("eOH.Impaction.Label","OH");									
						}
						else if(condition_type=="MISSTH"){
							var label = getLabel("eOH.MissingTooth.Label","OH");								
						}
						else if(condition_type=="RTDESTH"){
							var label = getLabel("eOH.RetainedDeciduous.Label","OH");
						}
						
						var msg = getMessage("APP-OH000145","OH"); 
						var msg_arr = msg.split("##");
						//Commented by Sharon Crasta on 12/23/2009
						//Record SUPRTH-->Primary Tooth->EXTRACT, then record MISSTH from data entry. Should show not applicable message first.
						//alert(msg_arr[0]+"'"+label+"'"+msg_arr[1]);
						//return;
						return_flag_alert = true;
					} //end 
					
				}  //End
				
			}
			
			var count_conds = 0; // This count is to count the conditions available. If this count = 0 then dont show the menu.
			var return_menu_flag = "N";
			for(j=0;j<alert_flag.length;j++){
				if(applicable_cond_types[j] != "undefined" && applicable_cond_types[j] != undefined){
					count_conds++;
					if(alert_flag[j] == (document.forms[0].oh_condition_type.value)){
						return_menu_flag = "Y";
						break;
					}
					else{
						return_menu_flag = "N";
					}
				}
			}
			var condition_type_desc = document.forms[0].oh_condition_type.options[document.forms[0].oh_condition_type.selectedIndex].text;
			//Added by Sharon Crasta on 3/11/2010 for IN019407
			//If any trmt is recorded on a tooth, that tooth cannot be marked as Congenitally Missing Tooth.
			if(tooth_no.indexOf(",") == -1 && site_type == "TOOTH"){
				var xmlHttp = new XMLHttpRequest();
				var params_for_missing = "func_mode=countTreatments&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
						
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_for_missing,false);
				xmlHttp.send(xmlDoc);
				var count_trmts = trimString(xmlHttp.responseText); 
				count_trmts = localTrimString(count_trmts); 
						
				if(count_trmts > 0 && (document.forms[0].oh_condition_type.value == "MISSTH")){
					var msg = getMessage("APP-OH000104","OH");
					var msgArray = msg.split("##");
					alert(msgArray[0]+condition_type_desc+msgArray[1]);
					return;
				}
			}else if(tooth_no.indexOf(",") != -1){
				var nors_arr = tooth_no.split(",");
				for(j=0;j<nors_arr.length;j++){
					var xmlHttp = new XMLHttpRequest();
					var params_for_missing = "func_mode=countTreatments&tooth_no="+nors_arr[j]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
							
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_for_missing,false);
					xmlHttp.send(xmlDoc);
					var count_trmts = trimString(xmlHttp.responseText); 
					count_trmts = localTrimString(count_trmts); 
							
					if(count_trmts > 0 && (document.forms[0].oh_condition_type.value == "MISSTH")){
						var msg = getMessage("APP-OH000104","OH");
						var msgArray = msg.split("##");
						alert(msgArray[0]+condition_type_desc+msgArray[1]);
						return;
					}
				}
			}
			//End

			
			//var msg = getMessage("APP-OH00035","OH");
			var msg = getMessage("APP-OH000104","OH");
			var msgArray = msg.split("##");
			
			for(z=0;z<applicable_yn.length;z++){
				if(applicable_yn[z] == "missth_applicable" ){
					if(return_menu_flag == "N"){
						alert(msgArray[0]+condition_type_desc+msgArray[1]);
						return;
					}
					
				}
				else if((applicable_yn[z] == "parer_er_applicable" && mixed_dentition_YN == "N" && display_menu_yn == "N") || (count_conds == "0")){
					if(return_menu_flag == "N"){
						alert(msgArray[0]+condition_type_desc+msgArray[1]);
						return;
					}
				}
				else if((applicable_yn[z] == "parer_er_applicable" && display_menu_yn == "N") || (count_conds == "0")){
					if(return_menu_flag == "N"){
						alert(msgArray[0]+condition_type_desc+msgArray[1]);
						return;
					}
				}
				
				else {
					if(return_menu_flag == "N"){
						alert(msgArray[0]+condition_type_desc+msgArray[1]);
						return;
					}
					//Added by Sharon Crasta on 12/23/2009
					//Record SUPRTH-->Primary Tooth->EXTRACT, then record MISSTH from data entry. Should show not applicable message first.
					else if(return_flag_alert){
						alert(msg_arr[0]+"'"+label+"'"+msg_arr[1]);
						return;
					}else if (return_surface_alert ){ //added by parul on 29/01/2010 for CRF-442
					   if(site_type=="CROWN"){
						 alert(getMessage("APP-OH000165",'OH'));
						  return;
					   }
					}//Added by Sharon Crasta on 3/15/2010 for SRR20056-CRF-0475(IN010868)
					else if(retVal_status_for_bridge){
					    if(site_type == "CROWN"){
						 alert(getMessage("APP-OH000180",'OH'));
						  return;
					   }
					}//End
				}
				
			}
		}
		
			var tooth_layer = "toothLayer"+tooth_no;
			var root_layer = "rootLayer"+tooth_no;
			var ref_tooth_no = formObj.ref_tooth_no.value;
			if(status != "E"){
				if(super_tooth_ref == "RD"){//Added by Sridei Joshi on 2/23/2010 IN019485
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					params = "func_mode=getMappedToothNo&tooth_no="+tooth_no;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
					xmlHttp.send(xmlDoc);
					retained_tooth_no = trimString(xmlHttp.responseText); 
					retained_tooth_no = localTrimString(retained_tooth_no); 
				}

				if(site_type == "CROWN" || site_type == "ROOT"){ //Added by Sridevi Joshi on 2/21/2010 for IN019472
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&tab_code=DC";

					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateCondTrmtsRecorded&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					retVal=localTrimString(retVal);
					if(retVal.length > 1){
						var retVal_arr_cond_trmt = retVal.split("~");
						for(var m=0;m<retVal_arr_cond_trmt.length-1;m++){
							var cond_trmt_arr = retVal_arr_cond_trmt[m].split("##");
							db_cond_type = cond_trmt_arr[0];

							db_trmt_type = cond_trmt_arr[1];
							if(db_cond_type == "UNERTH"){
								unerth_rec = "Y";
							}
							else if(db_cond_type == "PARERTH"){
								parerth_rec = "Y";
							}

							if(db_cond_type == "ERUPTH"){
								erupth_rec = "Y";
							}

							if(db_cond_type == "EXFOLTH"){
								exfolth_rec = "Y";
							}
							
							if(db_cond_type == "MISSTH"){
								missth_rec = "Y";
							}
							
							if(db_cond_type == "IMPACTN"){
								impactn_rec = "Y";
							}
							
							if(db_trmt_type == "EXTRACT"){
								extract_rec = "Y";
							}
							
							if(db_trmt_type == "IMPLANT"){
								implant_rec = "Y";
							}
							
							if(db_trmt_type == "DENTURE"){
								denture_rec = "Y";
							}
							
							if(db_trmt_type == "BRIDGE"){
								bridge_rec = "Y";
							}
						}	  
					}
					
					if(site_type == "CROWN"){
						if(mixed_dentition_YN == "Y" && (tooth_no =="2" || tooth_no =="3" || tooth_no =="14" || tooth_no =="15" || tooth_no =="18" || tooth_no =="19" || tooth_no =="30" || tooth_no =="31")){
							if(parerth_rec != "Y" && erupth_rec != "Y" && (super_tooth_ref == "" || super_tooth_ref == undefined || super_tooth_ref == "undefined")){// super_tooth_ref is added by Sridevi Joshi on 3/15/2010 for IN019963
								alert(getMessage("APP-OH00023","OH"));
								return;
							}
						}
						else if(permanent_deciduous_flag=="P" && (tooth_no =="1" || tooth_no =="16" || tooth_no =="17" || tooth_no =="32")){
							if(parerth_rec != "Y" && erupth_rec != "Y" && (super_tooth_ref == "" || super_tooth_ref == undefined || super_tooth_ref == "undefined")){// super_tooth_ref is added by Sridevi Joshi on 3/15/2010 for IN019963
								alert(getMessage("APP-OH00023","OH"));
								return;
							}
						}
					//	else if(unerth_rec == "Y" && erupth_rec != "Y" ){
						else if(unerth_rec == "Y" && erupth_rec != "Y" && parerth_rec != "Y" ){// erupth_rec condition is Added by Sridevi Joshi on 31/03/2010 for IN020459
							alert(getMessage("APP-OH00023","OH"));
							return;
						}
						else if(impactn_rec == "Y" && parerth_rec != "Y" && erupth_rec != "Y"){
							alert(getMessage("APP-OH00023","OH"));
							return;
						}
						else if(exfolth_rec == "Y" && erupth_rec != "Y" && parerth_rec != "Y"){ //erupth_rec & parerth_rec is added by Sridevi Joshi on 4/6/2010 for IN020513. This is for MD-P and MD-D case DECITH-->EXFOLTH-->ERUPT-->Caries
							alert(getMessage("APP-OH00023","OH"));
							return;
						}
						else if(missth_rec == "Y"){
							alert(getMessage("APP-OH00023","OH"));
							return;
						}
						else if(extract_rec == "Y" || implant_rec == "Y" || denture_rec == "Y" || bridge_rec == "Y"){
							alert(getMessage("APP-OH00023","OH"));
							return;
						}
					}
					else if(site_type == "ROOT"){
						if(mixed_dentition_YN == "Y" && (tooth_no =="2" || tooth_no =="3" || tooth_no =="14" || tooth_no =="15" || tooth_no =="18" || tooth_no =="19" || tooth_no =="30" || tooth_no =="31")){
							if(erupth_rec != "Y" && (super_tooth_ref == "" || super_tooth_ref == undefined || super_tooth_ref == "undefined")){// super_tooth_ref is added by Sridevi Joshi on 3/15/2010 for IN019963
								alert(getMessage("APP-OH00024","OH"));
								return;
							}
						}
						else if(permanent_deciduous_flag=="P" && (tooth_no =="1" || tooth_no =="16" || tooth_no =="17" || tooth_no =="32")){
							if(erupth_rec != "Y" && (super_tooth_ref == "" || super_tooth_ref == undefined || super_tooth_ref == "undefined")){// super_tooth_ref is added by Sridevi Joshi on 3/15/2010 for IN019963
								alert(getMessage("APP-OH00024","OH"));
								return;
							}
						}
						else if((unerth_rec == "Y" || parerth_rec == "Y") && erupth_rec != "Y" ){
							alert(getMessage("APP-OH00024","OH"));
							return;
						}
						else if(impactn_rec == "Y" && erupth_rec != "Y"){
							alert(getMessage("APP-OH00024","OH"));
							return;
						}
						else if(exfolth_rec == "Y" && erupth_rec != "Y"){ //erupth_rec is added by Sridevi Joshi on 4/6/2010 for IN020513. This is for MD-P and MD-D case DECITH-->EXFOLTH-->ERUPT-->Caries
							alert(getMessage("APP-OH00024","OH"));
							return;
						}
						else if(missth_rec == "Y"){
							alert(getMessage("APP-OH00024","OH"));
							return;
						}
						//Commented by Sharon Crasta on 3/4/2010 for SRR20056-CRF-0475(IN010868)
						// Should not be applicable for Root since for Abutment tooth we have the Root available.
						//else if(extract_rec == "Y" || implant_rec == "Y" || denture_rec == "Y" || bridge_rec == "Y"){
						else if(extract_rec == "Y" || implant_rec == "Y" || denture_rec == "Y"){//End
							alert(getMessage("APP-OH00024","OH"));
							return;
						}
					}
				}
				else if(site_type == "TOOTH" && mixed_dentition_YN == "N"){
					if(tooth_no.indexOf(",") == -1){
						if((condition_type == "RTDESTH" || condition_type == "DECITH") &&(tooth_no <=3 || (tooth_no >= 14 && tooth_no <=19) || tooth_no >=30)){
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText);
							retVal=localTrimString(retVal);
							if(condition_type == "RTDESTH"){
								alert(getMessage("APP-OH00027","OH")+"("+retVal+")");
							}
							else if(condition_type == "DECITH"){
								alert(getMessage("APP-OH00026","OH")+"("+retVal+")");
							}
							return;
						}

						if((dentalchartFormObj.document.getElementById(root_layer) == null || dentalchartFormObj.document.getElementById(root_layer) == "" || dentalchartFormObj.document.getElementById(root_layer) == "null" || dentalchartFormObj.document.getElementById(root_layer) == "undefined") && (dentalchartFormObj.document.getElementById(tooth_layer) == null || dentalchartFormObj.document.getElementById(tooth_layer) == "" || dentalchartFormObj.document.getElementById(tooth_layer) == "null" || dentalchartFormObj.document.getElementById(tooth_layer) == "undefined")){
							if(condition_type != "PARERTH" && condition_type != "ERUPTH" && condition_type != "IMPACTN"){
								//alert(getMessage("APP-OH00025","OH"));//commented by parul
								//return;//commented by parul
							}
						}
					}
					else{
						var retVal_future ="";
						var thrng_nos_ref_RD = tooth_no;
						var thrng_nos_ref_arr = thrng_nos_ref_RD.split(",");

						for (var m=0;m<thrng_nos_ref_arr.length; m++){
							if((condition_type == "RTDESTH" || condition_type == "DECITH")&&(thrng_nos_ref_arr[m] <=3 || (thrng_nos_ref_arr[m] >= 14 && thrng_nos_ref_arr[m] <=19) || (thrng_nos_ref_arr[m] >=30) && thrng_nos_ref_arr[m] <=32)){
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "tooth_no="+thrng_nos_ref_arr[m]+"&numbering_system="+numbering_system;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal = trimString(xmlHttp.responseText);
								retVal=localTrimString(retVal);
								if(retVal_future == ""){
									retVal_future = retVal;
								}
								else{
									retVal_future = retVal_future+","+retVal;
								}
							}

							tooth_layer = "toothLayer"+thrng_nos_ref_arr[m];
							root_layer = "rootLayer"+thrng_nos_ref_arr[m];

							if((dentalchartFormObj.document.getElementById(root_layer) == null || dentalchartFormObj.document.getElementById(root_layer) == "" || dentalchartFormObj.document.getElementById(root_layer) == "null" || dentalchartFormObj.document.getElementById(root_layer) == "undefined") && (dentalchartFormObj.document.getElementById(tooth_layer) == null || dentalchartFormObj.document.getElementById(tooth_layer) == "" || dentalchartFormObj.document.getElementById(tooth_layer) == "null" || dentalchartFormObj.document.getElementById(tooth_layer) == "undefined")){
								//if(condition_type != "PARERTH" && condition_type != "ERUPTH" && condition_type != "IMPACTN"){
								if(condition_type != "PARERTH" && condition_type != "ERUPTH" && condition_type != "IMPACTN" && condition_type != "UNERTH"){
									thrng_nos_ref = "";
									formObj.thrng_nos_ref.value = "";
								//	 (getMessage("APP-OH00025","OH"));//commented by parul
								//	return;//commented by parul
								}
							}
						}

						if(retVal_future != "" ){
							thrng_nos_ref = "";
							formObj.thrng_nos_ref.value = "";

							if(condition_type == "RTDESTH"){
								alert(getMessage("APP-OH00027","OH")+"("+retVal_future+")");
							}
							else if(condition_type == "DECITH"){
								alert(getMessage("APP-OH00026","OH")+"("+retVal_future+")");
							}
							return;
						}

						if((RD_Normal_yn == "S" || condition_type == "SUPRTH")){
							for (var m=0;m<thrng_nos_ref_arr.length; m++){
								if(m>1){
									/* Commented by Sridevi on 10/11/08 for SCR-6434
									thrng_nos_ref = "";
									formObj.thrng_nos_ref.value = "";
									*/
									alert(getMessage("APP-OH00020", "OH"));
									return;
								}

								if(formObj.oh_site.disabled == false){
									var selected_first_thno = thrng_nos_ref_arr[0];
									formObj.selected_first_thno.value = selected_first_thno;
								}

								var selected_first_thno = thrng_nos_ref_arr[0];
								var incr_selected_first_thno = (parseInt(selected_first_thno))+1;
								var decr_selected_first_thno = (parseInt(selected_first_thno))-1;

								if(selected_first_thno != thrng_nos_ref_arr[m] && incr_selected_first_thno != thrng_nos_ref_arr[m]){
									if(decr_selected_first_thno != thrng_nos_ref_arr[m]){
										/* Commented by Sridevi on 10/11/08 for SCR-6434
										thrng_nos_ref = "";
										formObj.thrng_nos_ref.value = "";
										*/
										alert(getMessage("APP-OH00019", "OH"));
										return;
									}
								}

								if(selected_first_thno > thrng_nos_ref_arr[m]){
									super_before = "Y";
								}
							}
						}
					}
				}
			}
                 
			//To check wether the Impaction condition is recorded after Partially errupted condition in mark Error cases
			if(status == "E" && condition_type == "PARERTH"){
				var chart_line_num = formObj.chart_line_num.value;
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&tooth_no="+tooth_no;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForImpactionCond&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				retVal=localTrimString(retVal);
				if(retVal == "IMPACTN"){
					alert(getMessage("APP-OH00067","OH"));
					return;
				}
			}

			//check for duplicate record...
			var duplicate_record = checkForDuplicateRecord(status,patient_id,chart_num,tooth_no,condition_type,surface_code,site_type);
			if(!duplicate_record){
					return;
			}
			
			//To restrict conditions to be marked as error where some conditions are recorded on this.
			if(status == "E"){
				var erupth_yn = "";
				var parerth_yn = "";
				var impactn_yn = "";
				var erupth_chart_line_num = 0;
				var parerth_chart_line_num = 0;
				var impactn_chart_line_num = 0;
				var diff_chart_line_num = 0;
				var cond_cnt = 0;
				var chart_line_num = formObj.chart_line_num.value;
							
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&tooth_no="+tooth_no+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForRecordedData&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				retVal=localTrimString(retVal);
				var retVal_arr = retVal.split("~");
				for(p=0;p<retVal_arr.length-1;p++){
					var cond_recorded = retVal_arr[p].split("##");
					//Added by Sharon Crasta on 9/17/2009 for IN009739 (SRR20056-CRF-0457)
					//If gingival is recorded on an erupted tooth or Deciduous tooth then these tooth cannot be marked as error.
					if(cond_recorded[0] == "ERUPTH"){
						erupth_yn = "Y";
						erupth_chart_line_num = parseInt(cond_recorded[1]);
					}

					if(cond_recorded[0] == "PARERTH"){
						parerth_yn = "Y";
						parerth_chart_line_num = parseInt(cond_recorded[1]);
					}

					if(cond_recorded[0] == "IMPACTN"){
						impactn_yn = "Y";
						impactn_chart_line_num = parseInt(cond_recorded[1]);
					}

					if(cond_recorded[0] != "ERUPTH" && cond_recorded[0] != "PARERTH" && cond_recorded[0] != "IMPACTN"){
						diff_chart_line_num = parseInt(cond_recorded[1]);
					}
					

					if(erupth_yn == "Y" && parseInt(chart_line_num) == erupth_chart_line_num && diff_chart_line_num !=0 && diff_chart_line_num > erupth_chart_line_num){
						alert(getMessage("APP-OH000113","OH"));
						return;
					}

					if(parerth_yn == "Y" && parseInt(chart_line_num) == parerth_chart_line_num && diff_chart_line_num !=0 && diff_chart_line_num > parerth_chart_line_num){
						alert(getMessage("APP-OH000113","OH"));
						return;
					}

					if(impactn_yn == "Y" && parseInt(chart_line_num) == impactn_chart_line_num && diff_chart_line_num !=0 && diff_chart_line_num > impactn_chart_line_num){
						alert(getMessage("APP-OH000113","OH"));
						return;
					}
					if ((erupth_yn=="Y" || parerth_yn=="Y") && (parseInt(chart_line_num) <erupth_chart_line_num || parseInt(chart_line_num) <parerth_chart_line_num) && diff_chart_line_num !=0 && (diff_chart_line_num > erupth_chart_line_num|| diff_chart_line_num > parerth_chart_line_num))	{
						alert(getMessage("APP-OH000113","OH"));
						return;
					}
				}
			}

			if(site_type == "CROWN" || site_type == "ROOT"){ //Added at the end of all validations by Sridevi Joshi on 4/5/2010 for IN020467
				if(ref_tooth_no == "" || ref_tooth_no == "null" || ref_tooth_no == null){ //This block is addded to clear the ROOT and crown images while marking error any condition.. added by Sridevi joshi on 12/21/2009 for IN010894(CRF-481)
					if(permanent_deciduous_flag == "D" && mixed_dentition_YN == "Y"){
						//To retrieve chart_line_num if ERUPTH is recorded
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=ERUPTH";
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithChrtLineNum&"+params,false);
						xmlHttp.send(xmlDoc);
						var erupth_chart_line_num = trimString(xmlHttp.responseText);
						erupth_chart_line_num = localTrimString(erupth_chart_line_num);

						if(erupth_chart_line_num.length > 0){ //This is to change the ROOT image if tooth is Erupted(specially when we click on super tooth)
							if(tooth_no == "2" || tooth_no == "3" || tooth_no == "14" || tooth_no == "15" || tooth_no == "18" || tooth_no == "19" || tooth_no == "30" || tooth_no == "31"){
								var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
							}else{
								var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
							}
						}
						else{
							if(tooth_no == "33" || tooth_no == "34"){
								var imageSrc = "../../eOH/images/R3.gif";
							}
							else if(tooth_no == "41" || tooth_no == "42"){
								var imageSrc = "../../eOH/images/R14.gif";
							}
							else if(tooth_no == "43" || tooth_no == "44"){
								var imageSrc = "../../eOH/images/R19.gif";
							}
							else if(tooth_no == "51" || tooth_no == "52"){
								var imageSrc = "../../eOH/images/R30.gif";
							}
							else{
								if(tooth_no == "2" || tooth_no == "3" || tooth_no == "14" || tooth_no == "15" || tooth_no == "18" || tooth_no == "19" || tooth_no == "30" || tooth_no == "31"){
									var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
								}else{
									var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
								}
							}
						}
					}
					else if(permanent_deciduous_flag == "D" && mixed_dentition_YN == "N"){
						if(tooth_no == "33" || tooth_no == "34"){
							var imageSrc = "../../eOH/images/R3.gif";
						}
						else if(tooth_no == "41" || tooth_no == "42"){
							var imageSrc = "../../eOH/images/R14.gif";
						}
						else if(tooth_no == "43" || tooth_no == "44"){
							var imageSrc = "../../eOH/images/R19.gif";
						}
						else if(tooth_no == "51" || tooth_no == "52"){
							var imageSrc = "../../eOH/images/R30.gif";
						}
						else{
							if(tooth_no == "2" || tooth_no == "3" || tooth_no == "14" || tooth_no == "15" || tooth_no == "18" || tooth_no == "19" || tooth_no == "30" || tooth_no == "31"){
								var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
							}else{
								var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
							}
						}
					}
					else{
						var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
					}

					//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
					//On mark error, was getting script error.
					if(site_type != "ARCH" && site_type != "QUAD" && site_type != "THRNG"){ //Added by Sridevi Joshi on 1/21/2010 for IN010894
						var imageId = "R"+tooth_no;
						dentalChartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "','','"+super_tooth_ref+"')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>";

						var imageId = "T"+tooth_no;
						dentalChartFormObj.document.getElementById(imageId).innerHTML = "<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "','','"+super_tooth_ref+"')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'></div>";

						dentalChartFormObj.document.getElementById(tooth_no).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_no+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table>";

						
						if((permanent_deciduous_flag=="P" && (tooth_no =="1" || tooth_no =="16" || tooth_no =="17" || tooth_no =="32")) || (mixed_dentition_YN == "Y" && (tooth_no =="2" || tooth_no =="3" || tooth_no =="14" || tooth_no =="15" || tooth_no =="18" || tooth_no =="19" || tooth_no =="30" || tooth_no =="31"))){
							if(super_tooth_ref == "" || super_tooth_ref == "undefined" || super_tooth_ref == undefined){ //Added by Sridevi Joshi on 1/29/2010 for IN010894 ...SUPRTH-->Record Some comdition on super tooth, root and crown images were not displayed.
								var tooth_sn = tooth_no;

								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
					
								var imageId = "R"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>"

								var imageId = tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="&nbsp;";
							}
						}
					}
				}
			}

			if(called_from_viewchart_yn == 'Y'){
				formObj.action="../../servlet/eOH.OHDentalChartAmendServlet";
				formObj.called_from_viewchart_yn.value = "";
				formObj.submit();
			}
			else{
				parent.f_query_add_mod_middle.document.forms[0].called_from_viewchart_yn.value = "";
				formObj.submit();
			}

			//Added by Sharon Crasta on 9/17/2009 for IN009739(SRR20056-CRF-0457)
			if(status != "E"){
			   if(tooth_no.indexOf(",") != -1){
				var nors_arr = tooth_no.split(",");
				for(j=0;j<nors_arr.length;j++){
					if(mixed_dentition_YN == "N" ){
						//if(condition_type == "UNERTH" || condition_type == "PARERTH" || condition_type == "RTDESTH" || condition_type == "MISSTH" || condition_type == "IMPACTN" || (condition_type == "EXFOLTH" && RD_Normal_yn != "RD" && RD_Normal_yn != "S")){
						if(condition_type == "UNERTH" || condition_type == "PARERTH" || condition_type == "RTDESTH" || condition_type == "MISSTH" || condition_type == "IMPACTN" || (condition_type == "EXFOLTH" && (super_tooth_ref == "" || super_tooth_ref == "null" || super_tooth_ref == null || super_tooth_ref == "undefined" || super_tooth_ref == undefined ))){
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+nors_arr[j]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;

							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkForGingivalRecordedData&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_gingival_recorded = trimString(xmlHttp.responseText);
							retVal_GS=localTrimString(retVal_gingival_recorded);
							if(retVal_GS >= 1){
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+nors_arr[j]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
								
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=updateGingivalRecordedData&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_update_gingival_recorded = trimString(xmlHttp.responseText);
								var retVal_update_GS=localTrimString(retVal_update_gingival_recorded);
								if(retVal_update_GS != 0){
									//alert(getMessage("APP-OH000125","OH"));
									recorded_for_tooth_range = true;
								}
							}
						} 
					}

					if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P"){
						 if(condition_type == "UNERTH" || condition_type == "RTDESTH" || condition_type == "ERUPTH" || condition_type == "DECITH"  || condition_type == "MISSTH" || condition_type == "IMPACTN" || condition_type == "EXFOLTH" ){
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+nors_arr[j]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;

							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkForGingivalRecordedData&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_gingival_recorded = trimString(xmlHttp.responseText);
							retVal_GS=localTrimString(retVal_gingival_recorded);
							if(retVal_GS >= 1){
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+nors_arr[j]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=updateGingivalRecordedData&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_update_gingival_recorded = trimString(xmlHttp.responseText);
								var retVal_update_GS=localTrimString(retVal_update_gingival_recorded);
								if(retVal_update_GS != 0){
									//alert(getMessage("APP-OH000125","OH"));
									recorded_for_tooth_range = true;
								}
							}
						} 
					}
					
					if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
						//if((condition_type == "ERUPTH" && RD_Normal_yn != "NR") || (condition_type == "EXFOLTH" && RD_Normal_yn != "MRS" && RD_Normal_yn != "S") || condition_type == "MISSTH" || condition_type == "IMPACTN") {
						if((condition_type == "ERUPTH" && RD_Normal_yn != "NR") || (condition_type == "EXFOLTH" && (super_tooth_ref == "" || super_tooth_ref == "null" || super_tooth_ref == null || super_tooth_ref == "undefined" || super_tooth_ref == undefined )) || condition_type == "MISSTH" || condition_type == "IMPACTN") {
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+nors_arr[j]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkForGingivalRecordedData&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_gingival_recorded = trimString(xmlHttp.responseText);
							retVal_GS=localTrimString(retVal_gingival_recorded);
							if(retVal_GS >= 1){
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+nors_arr[j]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=updateGingivalRecordedData&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_update_gingival_recorded = trimString(xmlHttp.responseText);
								var retVal_update_GS=localTrimString(retVal_update_gingival_recorded);
								if(retVal_update_GS != 0){
									//alert(getMessage("APP-OH000125","OH"));
									recorded_for_tooth_range = true;
								}
							}
						} 
					}
				 }
				 if(recorded_for_tooth_range){
				 	alert(getMessage("APP-OH000125","OH"));
					recorded_for_tooth_range = false;
					var view_frame = parent.parent.conditionDentalChartView;
					view_frame.expandMenu('menuGS',view_frame.document.forms[0].GS_arrow);
					view_frame.expandMenu('menuGS',view_frame.document.forms[0].GS_arrow);
				 }
			   }
			   else if(tooth_no.indexOf(",") == -1){
					
					if(mixed_dentition_YN == "N" ){
						//if(condition_type == "UNERTH" || condition_type == "PARERTH" || condition_type == "RTDESTH" || condition_type == "MISSTH" || condition_type == "IMPACTN" || (condition_type == "EXFOLTH" && RD_Normal_yn != "RD" && RD_Normal_yn != "S")){
						//Added super_tooth_ref by Sridevi Joshi on 2/12/2010 for IN019265 
						if(condition_type == "UNERTH" || condition_type == "PARERTH" || condition_type == "RTDESTH" || condition_type == "MISSTH" || condition_type == "IMPACTN" || (condition_type == "EXFOLTH" && (super_tooth_ref == "" || super_tooth_ref == "null" || super_tooth_ref == null || super_tooth_ref == "undefined" || super_tooth_ref == undefined ))){
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;

							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkForGingivalRecordedData&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_gingival_recorded = trimString(xmlHttp.responseText);
							retVal_GS=localTrimString(retVal_gingival_recorded);
							if(retVal_GS >= 1){
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=updateGingivalRecordedData&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_update_gingival_recorded = trimString(xmlHttp.responseText);
								var retVal_update_GS=localTrimString(retVal_update_gingival_recorded);
								if(retVal_update_GS != 0){
									alert(getMessage("APP-OH000125","OH"));
								
									var view_frame = parent.parent.conditionDentalChartView;
									view_frame.expandMenu('menuGS',view_frame.document.forms[0].GS_arrow);
									view_frame.expandMenu('menuGS',view_frame.document.forms[0].GS_arrow);
									//return;
								}
							}
						} 
					}
					if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P"){
						//if(condition_type == "UNERTH" || condition_type == "RTDESTH" || condition_type == "ERUPTH" || condition_type == "DECITH"  || condition_type == "MISSTH"  || condition_type == "IMPACTN" || (condition_type == "EXFOLTH" && RD_Normal_yn != "RD")){
						//Added super_tooth_ref by Sridevi Joshi on 2/12/2010 for IN019265 
						if(condition_type == "UNERTH" || condition_type == "RTDESTH" || condition_type == "ERUPTH" || condition_type == "DECITH"  || condition_type == "MISSTH"  || condition_type == "IMPACTN" || (condition_type == "EXFOLTH" && (super_tooth_ref == "" || super_tooth_ref == "null" || super_tooth_ref == null || super_tooth_ref == "undefined" || super_tooth_ref == undefined ))){
							var status_exfoliate_deciduous = "";
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							if(condition_type == "EXFOLTH" && RD_Normal_yn == "D"){
								status_exfoliate_deciduous = "C";
							}else{
								status_exfoliate_deciduous = "N";
							}
							var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;

							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkForGingivalRecordedData&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_gingival_recorded = trimString(xmlHttp.responseText);
							retVal_GS=localTrimString(retVal_gingival_recorded);
							
							if(retVal_GS >= 1){
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&status_exfoliate_deciduous="+status_exfoliate_deciduous;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=updateGingivalRecordedData&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_update_gingival_recorded = trimString(xmlHttp.responseText);
								var retVal_update_GS=localTrimString(retVal_update_gingival_recorded);
								if(retVal_update_GS != 0){
									alert(getMessage("APP-OH000125","OH"));
									/*if(condition_type == "EXFOLTH" ){
										parent.parent.conditionDentalChartView.gs_mp_deciduous_tooth = "Y";
									} */
									var view_frame = parent.parent.conditionDentalChartView;
									view_frame.expandMenu('menuGS',view_frame.document.forms[0].GS_arrow);
									view_frame.expandMenu('menuGS',view_frame.document.forms[0].GS_arrow);
									//return;
								}
							}
						} 
					}
					if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
						//if((condition_type == "ERUPTH" && RD_Normal_yn != "NR") || (condition_type == "EXFOLTH" && RD_Normal_yn != "MRS" && RD_Normal_yn != "S") || condition_type == "MISSTH" || condition_type == "IMPACTN") {
						//Added super_tooth_ref by Sridevi Joshi on 2/12/2010 for IN019265 
						if((condition_type == "ERUPTH" && RD_Normal_yn != "NR") || (condition_type == "EXFOLTH" && (super_tooth_ref == "" || super_tooth_ref == "null" || super_tooth_ref == null || super_tooth_ref == "undefined" || super_tooth_ref == undefined )) || condition_type == "MISSTH" || condition_type == "IMPACTN") {
							
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;

							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkForGingivalRecordedData&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_gingival_recorded = trimString(xmlHttp.responseText);
							retVal_GS=localTrimString(retVal_gingival_recorded);

							if(retVal_GS >= 1){
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=updateGingivalRecordedData&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_update_gingival_recorded = trimString(xmlHttp.responseText);
								var retVal_update_GS=localTrimString(retVal_update_gingival_recorded);
								if(retVal_update_GS != 0){
									alert(getMessage("APP-OH000125","OH"));
									var view_frame = parent.parent.conditionDentalChartView;
									view_frame.expandMenu('menuGS',view_frame.document.forms[0].GS_arrow);
									view_frame.expandMenu('menuGS',view_frame.document.forms[0].GS_arrow);
									//return false;
								}
							}
						} 
					}
				 }
			   } 
			   //Added separtely becoz previous loop has a for loop
			  if(status == "E"){
				if(mixed_dentition_YN == "N" ){
					if(condition_type== "DECITH" || condition_type == "ERUPTH" || (condition_type == "EXFOLTH" && RD_Normal_yn != "N" && RD_Normal_yn != "RD" )){
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;

						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkForGingivalRecordedData&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal_gingival_recorded = trimString(xmlHttp.responseText);
						retVal_GS=localTrimString(retVal_gingival_recorded);
						if(retVal_GS >= 1){
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=updateGingivalRecordedData&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_update_gingival_recorded = trimString(xmlHttp.responseText);
								var retVal_update_GS=localTrimString(retVal_update_gingival_recorded);
								if(retVal_update_GS != 0){
									alert(getMessage("APP-OH000125","OH"));
									var view_frame = parent.parent.conditionDentalChartView;
									view_frame.expandMenu('menuGS',view_frame.document.forms[0].GS_arrow);
									view_frame.expandMenu('menuGS',view_frame.document.forms[0].GS_arrow);
								}
							}
						} 
					}
					else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P"){
						if(condition_type == "RTDESTH" || condition_type == "ERUPTH" || condition_type == "DECITH" ){
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
							
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							var status_exfoliate_deciduous = "E";
							xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkForGingivalRecordedData&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_gingival_recorded = trimString(xmlHttp.responseText);
							retVal_GS=localTrimString(retVal_gingival_recorded);
							if(retVal_GS >= 1){
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&status_exfoliate_deciduous="+status_exfoliate_deciduous;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=updateGingivalRecordedData&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_update_gingival_recorded = trimString(xmlHttp.responseText);
								var retVal_update_GS=localTrimString(retVal_update_gingival_recorded);
								if(retVal_update_GS != 0){
									alert(getMessage("APP-OH000125","OH"));
									var view_frame = parent.parent.conditionDentalChartView;
									view_frame.expandMenu('menuGS',view_frame.document.forms[0].GS_arrow);
									view_frame.expandMenu('menuGS',view_frame.document.forms[0].GS_arrow);
								
								}
							}
						}
					}
					else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
							//if((condition_type == "EXFOLTH" && RD_Normal_yn != "MRS" && RD_Normal_yn != "N" && RD_Normal_yn != "S") || condition_type == "RTDESTH" || (condition_type == "ERUPTH" && (tooth_no == "2" || tooth_no == "3" || tooth_no == "14" || tooth_no == "15" || tooth_no == "18" || tooth_no == "19" || tooth_no == "30" || tooth_no == "31"))){
							if((condition_type == "EXFOLTH" && RD_Normal_yn != "MRS" && RD_Normal_yn != "N" && RD_Normal_yn != "S") || condition_type == "RTDESTH" || condition_type == "ERUPTH") {
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkForGingivalRecordedData&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_gingival_recorded = trimString(xmlHttp.responseText);
								retVal_GS=localTrimString(retVal_gingival_recorded);
								if(retVal_GS >= 1){
									var xmlDoc = "" ;
									var xmlHttp = new XMLHttpRequest();
									var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
									var xmlStr ="<root><SEARCH ";
									xmlStr +=" /></root>";
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=updateGingivalRecordedData&"+params,false);
									xmlHttp.send(xmlDoc);
									var retVal_update_gingival_recorded = trimString(xmlHttp.responseText);
									var retVal_update_GS=localTrimString(retVal_update_gingival_recorded);
									if(retVal_update_GS != 0){
										alert(getMessage("APP-OH000125","OH"));
										var view_frame = parent.parent.conditionDentalChartView;
										view_frame.expandMenu('menuGS',view_frame.document.forms[0].GS_arrow);
										view_frame.expandMenu('menuGS',view_frame.document.forms[0].GS_arrow);
										
									}
								}
							}
						}
						
					}//End
			  
			//Check for root and crown images for extream tooth in MD cases
			//var appl_conds_yn = checkForRootCrownApplicableConds(mixed_dentition_YN,dentalChartFormObj,tooth_no,site_type);
			//callCaptureImage();

			//storeImageClob();
        	//parent.frames[1].location.href="../../eOH/jsp/OHCondDentalChartFrame.jsp;
			/*if(called_from_viewchart_yn == 'Y'){
				formObj.action="../../servlet/eOH.OHDentalChartAmendServlet";
				formObj.called_from_viewchart_yn.value = "";
				formObj.submit();
			}
			else{
				parent.f_query_add_mod_middle.document.forms[0].called_from_viewchart_yn.value = "";
				formObj.submit();
			} */
			
			var view_frame = parent.parent.conditionDentalChartView;
			view_frame.expandMenu('menuDC',view_frame.document.forms[0].DC_arrow);
			view_frame.expandMenu('menuDC',view_frame.document.forms[0].DC_arrow);

			//Added by Sridevi Joshi on 1/19/2010 for IN010939(SRR20056-CRF-0490).To refresh the Summary Menu once GS is recorded.
			view_frame.expandMenu('menuSummary',view_frame.document.forms[0].GS_arrow);
			view_frame.expandMenu('menuSummary',view_frame.document.forms[0].GS_arrow);

			//Added by Sridevi Joshi on 2/11/2010 for IN010894(SRR20056-CRF-0481).To refresh the ET menu .
			view_frame.expandMenu('menuET',view_frame.document.forms[0].ET_arrow);
			view_frame.expandMenu('menuET',view_frame.document.forms[0].ET_arrow);


			//DhanasekarV modified against the issue IN024089 29/09/2010 for otherLink Maxila refresh
			view_frame.expandMenu('menuOL',view_frame.document.forms[0].OL_arrow);
			view_frame.expandMenu('menuOL',view_frame.document.forms[0].OL_arrow);

		
			var clinical_group_before_refresh = parent.f_query_add_mod_middle.document.forms[0].oh_clinical_group.value;

			//Refreshing the form values with the original params
			var old_params = parent.parent.frames[2].document.forms[0].params.value;
			document.location.href = "../../eOH/jsp/DentalCondition.jsp?"+old_params;
			parent.f_query_add_mod_middle.document.location.href = "../../eOH/jsp/OHDentalChartSubTabSearch.jsp?"+old_params+"&clinical_group_before_refresh="+clinical_group_before_refresh+"&defaultTab=DentalCondition";

			parent.f_query_add_mod_middle.document.forms[0].oh_clinical_group.value = clinical_group_before_refresh;

			var super_tooth_selected = "N";
			var super_normal_tooth_selected = "N";
			var normal_tooth_selected = "N";

			//Added by SRidevi Joshi on 2/24/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			params = "func_mode=checkSuperKey&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal_SuperKey = trimString(xmlHttp.responseText); 
			retVal_SuperKey = localTrimString(retVal_SuperKey); 
			var retVal_SuperKey_arr = retVal_SuperKey.split("~");


			if(super_tooth_ref != "" && super_tooth_ref != "undefined" && super_tooth_ref != undefined && status == "E"){//Added by Sridevi Joshi on 2/22/2010 for IN010894
				if(eval("dentalchartFormObj.document.getElementById('"+super_tooth_ref+"_super_font"+tooth_no+"')") != null){
					super_tooth_selected = "Y";
				}
			}
			else if(super_tooth_ref == "" && status == "E"){
				if(eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')") != null){//Added by Sridevi Joshi on 2/22/2010 for IN010894
					super_normal_tooth_selected = "Y";
				}
				else{
					if(retVal_SuperKey_arr.length > 1){//Added by SRidevi Joshi on 2/24/2010 for IN010894(SRR20056-CRF-0481)
						for(var f=0;f<=retVal_SuperKey_arr-1;f++){
							if(eval("dentalchartFormObj.document.getElementById('"+retVal_SuperKey_arr[f]+"_super_font"+tooth_no+"')") != null){
								super_tooth_selected = "Y";
							}
						}
					}
					else{
						normal_tooth_selected = "Y";
					}
				}
			}
			else if(super_tooth_ref == "undefined" || super_tooth_ref == undefined || status != "E"){
				normal_tooth_selected = "Y";
			}

			if(status == "E" || (called_from_viewchart_yn == "Y" && status != "E")){ //This block is addded to clear the ROOT and crown images while marking error any condition.. added by Sridevi joshi on 12/21/2009 for IN010894(CRF-481)
				if(permanent_deciduous_flag == "D" && mixed_dentition_YN == "Y"){
					//To retrieve chart_line_num if ERUPTH is recorded
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=ERUPTH";
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithChrtLineNum&"+params,false);
					xmlHttp.send(xmlDoc);
					var erupth_chart_line_num = trimString(xmlHttp.responseText);
					erupth_chart_line_num = localTrimString(erupth_chart_line_num);

					if(erupth_chart_line_num.length > 0){ //This is to change the ROOT image if tooth is Erupted(specially when we click on super tooth)
						if(tooth_no == "2" || tooth_no == "3" || tooth_no == "14" || tooth_no == "15" || tooth_no == "18" || tooth_no == "19" || tooth_no == "30" || tooth_no == "31"){
							var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
						}else{
							var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
						}
					}
					else{
						if(tooth_no == "33" || tooth_no == "34"){
							var imageSrc = "../../eOH/images/R3.gif";
						}
						else if(tooth_no == "41" || tooth_no == "42"){
							var imageSrc = "../../eOH/images/R14.gif";
						}
						else if(tooth_no == "43" || tooth_no == "44"){
							var imageSrc = "../../eOH/images/R19.gif";
						}
						else if(tooth_no == "51" || tooth_no == "52"){
							var imageSrc = "../../eOH/images/R30.gif";
						}
						else{
							if(tooth_no == "2" || tooth_no == "3" || tooth_no == "14" || tooth_no == "15" || tooth_no == "18" || tooth_no == "19" || tooth_no == "30" || tooth_no == "31"){
								var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
							}else{
								var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
							}
						}
					}
				}
				else if(permanent_deciduous_flag == "D" && mixed_dentition_YN == "N"){
					if(tooth_no == "33" || tooth_no == "34"){
						var imageSrc = "../../eOH/images/R3.gif";
					}
					else if(tooth_no == "41" || tooth_no == "42"){
						var imageSrc = "../../eOH/images/R14.gif";
					}
					else if(tooth_no == "43" || tooth_no == "44"){
						var imageSrc = "../../eOH/images/R19.gif";
					}
					else if(tooth_no == "51" || tooth_no == "52"){
						var imageSrc = "../../eOH/images/R30.gif";
					}
					else{
						if(tooth_no == "2" || tooth_no == "3" || tooth_no == "14" || tooth_no == "15" || tooth_no == "18" || tooth_no == "19" || tooth_no == "30" || tooth_no == "31"){
							var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
						}else{
							var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
						}
					}
				}
				else{
					var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
				}

				//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
				//On mark error, was getting script error.
				if(site_type != "ARCH" && site_type != "QUAD" && site_type != "THRNG" && site_type != "MAXFS"  && site_type != "MOUTH"){ //Added by Sridevi Joshi on 1/21/2010 for IN010894
					//if(super_tooth_selected == "Y" || super_normal_tooth_selected == "Y" || normal_tooth_selected == "Y"){//Added by Sridevi Joshi on 2/22/2010 for IN010894---uncomment for screen changes
						//if(eval("dentalchartFormObj.document.getElementById('"+super_tooth_ref+"_super_font"+tooth_no+"')") != null){
							var imageId = "R"+tooth_no;
							dentalChartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "','','"+super_tooth_ref+"')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>";

							var imageId = "T"+tooth_no;
							dentalChartFormObj.document.getElementById(imageId).innerHTML = "<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "','','"+super_tooth_ref+"')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'></div>";

							dentalChartFormObj.document.getElementById(tooth_no).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_no+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table>";
						//}
					//}
				}
			}

			if(site_type == "TOOTH"&& status == "E"){
				imageReplace(condition_type,tooth_no,dentalchartFormObj,site_type,status,chart_num,super_before);//commented by Sridevi Joshi on 1/8/2010 for SUPRTH--->Exfolth-->MarkError EXFOLTH was not getting SUPRTh on the Chart
			}
			
			if(clinical_group_code != ""){
				parent.f_query_add_mod_middle.document.forms[0].oh_clinical_group.disabled = "true";
			}
          
			//commented by parul on 12/01/2010 for CRF-422
       /*  if(site_type == "CROWN"){ 							  
		   fillCrownImages('toothLayer'+tooth_no,surface_code,dentalChartFormObj,condition_type,status,tooth_no,'',super_tooth_ref,exfolth_count,retained_tooth_no);
				drawCircleForCusp(tooth_no,dentalChartFormObj,status,cusptip_ref,surface_code,tab_name,super_tooth_ref,exfolth_count,retained_tooth_no);//added by parul for CRF#0483 on 26/08/2009
				//	drawCircleForCusp(tooth_no,dentalChartFormObj,status,cusptip_ref_arr[i],surface_code);
		   }else if(site_type == "ROOT" && condition_type!="PERIINV"){
				drawLineForRootImage('rootLayer'+tooth_no,surface_code,dentalChartFormObj,condition_type,tab_name,tooth_no,status,super_tooth_ref,exfolth_count,retained_tooth_no);
		   }*/


		  // if(super_tooth_selected == "Y" || super_normal_tooth_selected == "Y" || normal_tooth_selected == "Y"){//Added by Sridevi Joshi on 2/22/2010 for IN010894 ---uncomment for screen changes
			   if(site_type == "CROWN"){		
					var surface_ref_arr=surface_ref.split(",");
					 if (surface_ref!="" && surface_ref!="null" && surface_ref!=null){	
						for(var i=0;i<surface_ref_arr.length;i++){	
							fillCrownImages('toothLayer'+tooth_no,surface_ref_arr[i],dentalChartFormObj,condition_type,status,tooth_no,'',super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded);
							drawCircleForCusp(tooth_no,dentalChartFormObj,status,cusptip_ref,surface_ref_arr[i],tab_name,super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded);//added by parul for CRF#0483 on 26/08/2009
						}
					}else{
							fillCrownImages('toothLayer'+tooth_no,surface_code,dentalChartFormObj,condition_type,status,tooth_no,'',super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded);		
							drawCircleForCusp(tooth_no,dentalChartFormObj,status,cusptip_ref,surface_code,tab_name,super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded);
					}
				}
				else if(site_type == "ROOT" && condition_type!="PERIINV"){
					  if (surface_ref!="" && surface_ref!="null" && surface_ref!=null){
							var surface_ref_arr=surface_ref.split(",");
							for(var i=0;i<surface_ref_arr.length;i++){
								drawLineForRootImage('rootLayer'+tooth_no,surface_ref_arr[i],dentalChartFormObj,condition_type,tab_name,tooth_no,status,super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded);
						 }
					}else{//for one surface
							drawLineForRootImage('rootLayer'+tooth_no,surface_code,dentalChartFormObj,condition_type,tab_name,tooth_no,status,super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded);
					}
				}else if(site_type == "ROOT" && condition_type == "PERIINV"){
					drawCircleForRoot(tooth_no,surface_code,dentalChartFormObj,condition_type,tab_name,tooth_no,status,super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded);
			   }else{
				   //block is added by parul on 7/10/2009
					//this block is for in permanent chart record erupted,extraction,Mark erupted as error than extraction,now root and crown Images was comng,after refresh it was not comng
					if(site_type == "TOOTH"  && permanent_deciduous_flag=="P" && (tooth_no =="1" || tooth_no =="16" || tooth_no =="17" || tooth_no =="32")){
						if(super_tooth_ref == "" || super_tooth_ref == "undefined" || super_tooth_ref == undefined){ //Added by Sridevi Joshi on 1/29/2010 for IN010894 ...SUPRTH-->Record Some comdition on super tooth, root and crown images were not displayed.
							var tooth_sn = tooth_no;

							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
				
							var imageId = "R"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>"

							var imageId = tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="&nbsp;";
							
						}

					}else if(site_type == "TOOTH" && tooth_no.indexOf(",") != -1 || site_type == "THRNG"){
						var tooth_no_arr = tooth_no.split(",");
						for (var k=0;k<tooth_no_arr.length; k++){

							//To retrieve the display tooth_no and the tooth_name...
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no_arr[k]+"&numbering_system="+numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateDisplayToothNoAndName&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText);
							retVal = localTrimString(retVal);
							if(retVal.length > 1){
								var retVal_arr = retVal.split("##");
								tooth_num = retVal_arr[0];
								tooth_name = retVal_arr[1];
								mapped_tooth_no = retVal_arr[2];
								mixed_dent_tooth_no = retVal_arr[3];
							}
							
							var tooth_sn = tooth_no_arr[k];
							var imageId = "T"+tooth_no_arr[k];
							if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){
								var imageSrc = "../../eOH/images/spacer.gif";	
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='"+imageSrc+"' width='41' height='25'/>";
							}
							else{
								var imageSrc = "../../eOH/images/T.gif";
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='"+imageSrc+"' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>";
							}

							var imageId = "R"+tooth_no_arr[k];
							if(permanent_deciduous_flag == "D" && (mixed_dentition_YN != "Y" || (mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null" || mixed_dent_tooth_no == ""))){ //For Deciduous or MD-P Chart
								if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
									var imageSrc = "../../eOH/images/R3.gif";
								}
								else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
									var imageSrc = "../../eOH/images/R14.gif";
								}
								else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
									var imageSrc = "../../eOH/images/R19.gif";
								}
								else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
									var imageSrc = "../../eOH/images/R30.gif";
								}
								else{
									var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
								}
							}
							else if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){ //For Permanent Tooth no's in MD Chart
								var imageSrc = "../../eOH/images/spacer.gif";	
							}
							else{
								if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
									var imageSrc = "../../eOH/images/R3.gif";
								}
								else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
									var imageSrc = "../../eOH/images/R14.gif";
								}
								else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
									var imageSrc = "../../eOH/images/R19.gif";
								}
								else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
									var imageSrc = "../../eOH/images/R30.gif";
								}
								else{
									var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
								}
							}

							var root_layer = "rootLayer"+tooth_no_arr[k];

							if(dentalchartFormObj.document.getElementById(root_layer) == "null" || dentalchartFormObj.document.getElementById(root_layer) == null){
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
							}

							var imageId = tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="&nbsp;";
						}
					}
			   }
				/*if(super_tooth_ref == "RD" && !(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D")){
					//Added by Sridevi Joshi on 12/17/2009 for RTDESTH new changes TO GET mapped tooth no
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					params = "func_mode=getMappedToothNo&tooth_no="+tooth_no;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
					xmlHttp.send(xmlDoc);
					var retained_tooth_no = trimString(xmlHttp.responseText); 
					retained_tooth_no = localTrimString(retained_tooth_no); 
				}				
				
				getImageFromDB(tooth_no,site_type,chart_num,tab_name,document.forms[0],dentalchartFormObj,status,super_tooth_ref,exfolth_count,retained_tooth_no,isSuprthError,total_SuperKey_count,super_recorded,isExfolthError,isRetainedError); //super_tooth_ref is added by Sridevi Joshi on 12/9/2009 for SUPRTH new Changes*/
			//}

			if(super_tooth_ref == "RD" && !(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D")){//--Added by Sridevi Joshi on 2/17/2010 outside if condition of tooth for IN019368

				//Added by Sridevi Joshi on 12/17/2009 for RTDESTH new changes TO GET mapped tooth no
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				params = "func_mode=getMappedToothNo&tooth_no="+tooth_no;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
				xmlHttp.send(xmlDoc);
				var retained_tooth_no = trimString(xmlHttp.responseText); 
				retained_tooth_no = localTrimString(retained_tooth_no); 
			}

			//if(super_tooth_selected == "Y" || super_normal_tooth_selected == "Y" || normal_tooth_selected == "Y"){//Added by Sridevi Joshi on 2/22/2010 for IN010894 ---uncomment for screen changes
				getImageFromDB(tooth_no,site_type,chart_num,tab_name,document.forms[0],dentalchartFormObj,status,super_tooth_ref,exfolth_count,retained_tooth_no,isSuprthError,total_SuperKey_count,super_recorded,isExfolthError,isRetainedError); //super_tooth_ref is added by Sridevi Joshi on 12/9/2009 for SUPRTH new Changes----Added by Sridevi Joshi on 2/17/2010 outside if condition of tooth for IN019368
			//}
			dentalchartFormObj.chart_hdr_insert_yn.value = "N";	
			DC_Tab_Reset(formObj,site_type,tooth_no,thrng_nos,clinical_group_before_refresh);//parul
			
		}
	}
}

//imageReplace Function was here..
//This function is shifted from DenralCondition.js to make this function common for both DentlCondition and DentalExternalTreatment.
	function imageReplace(condition_type,tooth_no,dentalchartFormObj,site_type,status,chart_num,super_before,show_RTDESTH_EXFOLTH_image_flag,hide_image_yn,mixed_dent_deciduous_yn,super_yn_1,super_key_num,isSuprthError,surface_code,isExfolthError,isRetainedError,treatments_outcome,image_source){// added by parul(added mixed_dent_deciduous_yn becoz when u record tooth trmt,supernum,Deciduoud now tooth no is D,Ds if u mark tooth trmt as error that tooth no is gong to change as 6,6s..it should be D,Ds so that we added mixed_dent_deciduous_yn in  imageReplace function )
	var numbering_system = document.forms[0].tooth_numbering_system.value;
	var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
	var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
	var patient_id = document.forms[0].patient_id.value;
	var chart_num = document.forms[0].chart_num.value;
	var super_tooth_ref = document.forms[0].super_tooth_ref.value;
	var RD_Normal_yn = document.forms[0].RD_Normal_yn.value;
	var ref_tooth_no = document.forms[0].ref_tooth_no.value;
	var tooth_num = "";
	var tooth_name = "";
	var mapped_tooth_no = "";
	var mixed_dent_tooth_no = "";	
	var isSuperCondYN = "";
	var isRetndCondYN = "";
	var super_cnt = "";
//alert("imageReplace site_type--------->"+site_type)
	if(condition_type != null && condition_type != "null" && condition_type != "" && condition_type != "undefined"){

		if(ref_tooth_no == "" || ref_tooth_no == "null" || ref_tooth_no == null || ref_tooth_no == "undefined" || ref_tooth_no == undefined){ //Added by Sridevi Joshi when recording conditions from data entry
			if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
				RD_Normal_yn = "MR";
			}
		}

		//Added by SRidevi Joshi on 1/19/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		//params = "func_mode=SuperRDyn&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn;
		params = "func_mode=checkSuperCount&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal_cond = trimString(xmlHttp.responseText); 
		retVal_cond = localTrimString(retVal_cond); 
		var retVal_cond_arr = retVal_cond.split("##");
		var condition_type_ref = retVal_cond_arr[1];
		if(condition_type_ref == "SUPRTH"){
			super_cnt = retVal_cond_arr[2];
		}

		if(site_type == "ARCH"){
			var imageId = "A"+tooth_no;
		}else if(site_type == "QUAD"){
			var imageId = "Q"+tooth_no;
		}else if(site_type == "TOOTH"){
			var imageId = tooth_no;
		}
		
		if(site_type == "TOOTH" && tooth_no.indexOf(",") != -1 || site_type == "THRNG"){ 
			
			var selected_first_thno = document.forms[0].selected_first_thno.value;
			var tooth_no_arr = tooth_no.split(",");
			for(var k=0;k<tooth_no_arr.length;k++){
				var tooth_sn = tooth_no_arr[k];

				//To retrieve the display tooth_no and the tooth_name...
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "tooth_no="+tooth_no_arr[k]+"&numbering_system="+numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateDisplayToothNoAndName&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				retVal = localTrimString(retVal);
				if(retVal.length > 1){
					var retVal_arr = retVal.split("##");
					tooth_num = retVal_arr[0];
					tooth_name = retVal_arr[1];
					mapped_tooth_no = retVal_arr[2];
					mixed_dent_tooth_no = retVal_arr[3];
				}

				if(status == 'E'){
					if( condition_type == "MISSTH"){
						var imageId = "T"+tooth_no_arr[k];
						var imageSrc = "../../eOH/images/T.gif";	

						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='"+imageSrc+"' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='45' height='25'/></div>";
						var imageId = "R"+tooth_no_arr[k];

						if(permanent_deciduous_flag == "D"){
							if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
								var imageSrc = "../../eOH/images/R3.gif";
							}
							else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
								var imageSrc = "../../eOH/images/R14.gif";
							}
							else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
								var imageSrc = "../../eOH/images/R19.gif";
							}
							else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
								var imageSrc = "../../eOH/images/R30.gif";
							}
							else{
								var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
							}
						}
						else{
							var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
						}

						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
					}
					else if(condition_type == "UNERTH" || condition_type=="IMPACTN"){ // 29feb BSHANKAR
						if(tooth_no_arr[k] != '1' && tooth_no_arr[k] != '16' && tooth_no_arr[k] != '17' && tooth_no_arr[k] != '32' ){
							var imageId = "T"+tooth_no_arr[k];

							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

							var imageId = "R"+tooth_no_arr[k];
							if(permanent_deciduous_flag == "D"){
								if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
									var imageSrc = "../../eOH/images/R3.gif";
								}
								else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
									var imageSrc = "../../eOH/images/R14.gif";
								}
								else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
									var imageSrc = "../../eOH/images/R19.gif";
								}
								else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
									var imageSrc = "../../eOH/images/R30.gif";
								}
								else{
									var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
								}
							}
							else{
								var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
							}

							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
						}
					}
					else if(condition_type == "EXFOLTH"){
						var RD_Normal_yn  = document.forms[0].RD_Normal_yn.value; // This value will be 'S' if we record any condition on supernumary tooth (ex : on 12s)

						var query_tooth_no = tooth_no_arr[k];
						if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && mapped_tooth_no != null && mapped_tooth_no != "null" && RD_Normal_yn != "S" && RD_Normal_yn != "N" && RD_Normal_yn != ""){ // For Mixed Dentition - Deciduous Chart
							query_tooth_no = mapped_tooth_no;

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText);
							retVal=localTrimString(retVal);
							if(retVal.length > 1){
								disply_tooth_no = retVal;
							}
						}
						else if(mixed_dentition_YN == "N" && permanent_deciduous_flag == "D"){ // For Deciduous Chart
							disply_tooth_no = tooth_num;
						}
						else{
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText);
							retVal=localTrimString(retVal);
							if(retVal.length > 1){
								disply_tooth_no = retVal;
							}
						}
						//if(RD_Normal_yn != "S" && RD_Normal_yn != "N" && RD_Normal_yn != ""){
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

							var imageId = "R"+tooth_no_arr[k];
							if(permanent_deciduous_flag == "D"){
								if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
									var imageSrc = "../../eOH/images/R3.gif";
								}
								else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
									var imageSrc = "../../eOH/images/R14.gif";
								}
								else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
									var imageSrc = "../../eOH/images/R19.gif";
								}
								else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
									var imageSrc = "../../eOH/images/R30.gif";
								}
								else{
									var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
								}
							}
							else{
								var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
							}
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
						//}

						var check_num_id = "check_num"+tooth_no_arr[k];
						
						if(RD_Normal_yn == "NS"){
							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','S')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "s</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
						}
						else{
							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
						}
					}
					else if(condition_type == "DECITH" || condition_type == "RTDESTH" || condition_type == "SUPRTH"){
						var numbering_system = document.forms[0].tooth_numbering_system.value;
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no_arr[k]+"&numbering_system="+numbering_system;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 1){
							var retVal_arr = retVal.split("##")
							if(retVal_arr[0] !="" && retVal_arr[0] != null && retVal_arr[0] != "null"){
								var imageId = "decith_table"+tooth_no_arr[k];
								var tooth_sn = tooth_no_arr[k];
								var tooth_num = retVal;
								var tooth_name = "";

								if(permanent_deciduous_flag == "D" && (mixed_dentition_YN != "Y" || (mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null" || mixed_dent_tooth_no == ""))){ //For Deciduous or MD-P chart
									if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
										var imgSrc = "../../eOH/images/R3.gif";
									}
									else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
										var imgSrc = "../../eOH/images/R14.gif";
									}
									else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
										var imgSrc = "../../eOH/images/R19.gif";
									}
									else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
										var imgSrc = "../../eOH/images/R30.gif";
									}
									else{
										var imgSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
									}
								}
								else if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){ //For Permanent Tooth no's in MD Chart
									var imgSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
								}
								else{
									if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
										var imgSrc = "../../eOH/images/R3.gif";
									}
									else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
										var imgSrc = "../../eOH/images/R14.gif";
									}
									else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
										var imgSrc = "../../eOH/images/R19.gif";
									}
									else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
										var imgSrc = "../../eOH/images/R30.gif";
									}
									else{
										var imgSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
									}
								}

								if(tooth_no_arr[k]>=1 && tooth_no_arr[k]<=16 || (tooth_no_arr[k]>=33 && tooth_no_arr[k]<=42)){
									dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='R"+tooth_no_arr[k]+ "' align='center'><div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imgSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td id='T"+tooth_no_arr[k]+"' align='center'><div id='toothLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no_arr[k]+"' id="+tooth_no_arr[k]+"D id="+tooth_no_arr[k]+"RD id="+tooth_no_arr[k]+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no_arr[k] +"' id='selcol_hidden"+ tooth_no_arr[k] +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no_arr[k] +"' id='selcol"+ tooth_no_arr[k] +"' value='' onClick = \"setCheckValue(this,'"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no_arr[k]+"' width='45'></td></tr></table></td></tr></table>";
								}else{
									dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='T"+tooth_no_arr[k]+"' align='center'><div id='toothLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td id='R"+tooth_no_arr[k]+ "' align='center'><div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/R" + tooth_no_arr[k] + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no_arr[k]+"' id="+tooth_no_arr[k]+"D id="+tooth_no_arr[k]+"RD id="+tooth_no_arr[k]+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no_arr[k] +"' id='selcol_hidden"+ tooth_no_arr[k] +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no_arr[k] +"' id='selcol"+ tooth_no_arr[k] +"' value='' onClick = \"setCheckValue(this,'"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no_arr[k]+"' width='45'></td></tr></table></td></tr></table>";
								}
							}
						}
					}
					else if(condition_type == "PARERTH"){
						if(tooth_no_arr[k] != '1' && tooth_no_arr[k] != '16' && tooth_no_arr[k] != '17' && tooth_no_arr[k] != '32' ){
							if(mixed_dentition_YN == "Y" && (mapped_tooth_no == null || mapped_tooth_no == "null" || mapped_tooth_no == "")){//This is to remove images for extream 3 tooth (in case of MD chart) when we record mark error on any of the treatments..
								var imageId = "R"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";
								
								var imageId = "T"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
							}
							else{
								var imageId = "R"+tooth_no_arr[k];
								if(permanent_deciduous_flag == "D" && (mixed_dentition_YN != "Y" || (mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null" || mixed_dent_tooth_no == ""))){ //For Deciduous or MD-P chart
									if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
										var imageSrc = "../../eOH/images/R3.gif";
									}
									else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
										var imageSrc = "../../eOH/images/R14.gif";
									}
									else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
										var imageSrc = "../../eOH/images/R19.gif";
									}
									else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
										var imageSrc = "../../eOH/images/R30.gif";
									}
									else{
										var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
									}
								}
								else if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){ //For Permanent Tooth no's in MD Chart
									var imageSrc = "../../eOH/images/spacer.gif";	
								}
								else{
									if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
										var imageSrc = "../../eOH/images/R3.gif";
									}
									else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
										var imageSrc = "../../eOH/images/R14.gif";
									}
									else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
										var imageSrc = "../../eOH/images/R19.gif";
									}
									else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
										var imageSrc = "../../eOH/images/R30.gif";
									}
									else{
										var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
									}
								}
							
								var root_layer = "rootLayer"+tooth_no_arr[k];
								if(dentalchartFormObj.document.getElementById(root_layer) == "null" || dentalchartFormObj.document.getElementById(root_layer) == null){
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
								}

								if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){
									var imageSrc = "../../eOH/images/spacer.gif";	
								}
								else{
									var imageSrc = "../../eOH/images/T.gif";	
								}
								var imageId = "T"+tooth_no_arr[k];
								var tooth_layer = "toothLayer"+tooth_no_arr[k];
								if(dentalchartFormObj.document.getElementById(tooth_layer) == "null" || dentalchartFormObj.document.getElementById(tooth_layer) == null){
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='"+imageSrc+"' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>";
								}
							}
						}
						else{
							var imageId = "R"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";
								
								var imageId = "T"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
						}
					}
					else if(condition_type == "ERUPTH"){
						if(tooth_no_arr[k] != '1' && tooth_no_arr[k] != '16' && tooth_no_arr[k] != '17' && tooth_no_arr[k] != '32' ){
							if(mixed_dentition_YN == "Y" && (mapped_tooth_no == null || mapped_tooth_no == "null" || mapped_tooth_no == "null")){//This is to remove images for extream 3 tooth (in case of MD chart) when we record mark error on any of the treatments..
								var imageId = "R"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";
								
								var imageId = "T"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
							}
							else{
								var imageId = "R"+tooth_no_arr[k];
								if(permanent_deciduous_flag == "D" && (mixed_dentition_YN != "Y" || (mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null" || mixed_dent_tooth_no == ""))){ //For Deciduous or MD-P Chart
									if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
										var imageSrc = "../../eOH/images/R3.gif";
									}
									else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
										var imageSrc = "../../eOH/images/R14.gif";
									}
									else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
										var imageSrc = "../../eOH/images/R19.gif";
									}
									else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
										var imageSrc = "../../eOH/images/R30.gif";
									}
									else{
										var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
									}
								}
								else if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){ //For Permanent Tooth no's in MD Chart
									var imageSrc = "../../eOH/images/spacer.gif";	
								}
								else{
									if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
										var imageSrc = "../../eOH/images/R3.gif";
									}
									else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
										var imageSrc = "../../eOH/images/R14.gif";
									}
									else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
										var imageSrc = "../../eOH/images/R19.gif";
									}
									else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
										var imageSrc = "../../eOH/images/R30.gif";
									}
									else{
										var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
									}
								}
							
								var root_layer = "rootLayer"+tooth_no_arr[k];
								if(dentalchartFormObj.document.getElementById(root_layer) == "null" || dentalchartFormObj.document.getElementById(root_layer) == null){
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
								}

								if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){
									var imageSrc = "../../eOH/images/spacer.gif";	
								}
								else{
									var imageSrc = "../../eOH/images/T.gif";	
								}
								var imageId = "T"+tooth_no_arr[k];
								var tooth_layer = "toothLayer"+tooth_no_arr[k];
								if(dentalchartFormObj.document.getElementById(tooth_layer) == "null" || dentalchartFormObj.document.getElementById(tooth_layer) == null){
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='"+imageSrc+"' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>";
								}
							}
						}
						else{
							var imageId = "R"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";
							
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
						}
					}

					if( condition_type == "EXTRACT"){
						var imageId = "T"+tooth_no_arr[k];
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

						var imageId = "R"+tooth_no_arr[k];
						if(permanent_deciduous_flag == "D"){
							if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
								var imageSrc = "../../eOH/images/R3.gif";
							}
							else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
								var imageSrc = "../../eOH/images/R14.gif";
							}
							else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
								var imageSrc = "../../eOH/images/R19.gif";
							}
							else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
								var imageSrc = "../../eOH/images/R30.gif";
							}
							else{
								var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
							}
						}
						else{
							var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
						}

						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
					}
					else if(condition_type == "IMPLANT"){
						var imageId = "T"+tooth_no_arr[k];
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

						var imageId = "R"+tooth_no_arr[k];
						if(permanent_deciduous_flag == "D"){
							if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
								var imageSrc = "../../eOH/images/R3.gif";
							}
							else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
								var imageSrc = "../../eOH/images/R14.gif";
							}
							else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
								var imageSrc = "../../eOH/images/R19.gif";
							}
							else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
								var imageSrc = "../../eOH/images/R30.gif";
							}
							else{
								var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
							}
						}
						else{
							var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
						}
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
					}
					else if(condition_type == "BRIDGE"){
						if(mixed_dentition_YN == "Y" && (mapped_tooth_no == null || mapped_tooth_no == "null")){//This is to remove images for extream 3 tooth (in case of MD chart) when we record mark error on any of the treatments..
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

							var imageId = "R"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
						}
						else{
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

							var imageId = "R"+tooth_no_arr[k];
							if(permanent_deciduous_flag == "D"){
								if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
									var imageSrc = "../../eOH/images/R3.gif";
								}
								else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
									var imageSrc = "../../eOH/images/R14.gif";
								}
								else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
									var imageSrc = "../../eOH/images/R19.gif";
								}
								else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
									var imageSrc = "../../eOH/images/R30.gif";
								}
								else{
									var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
								}
							}
							else{
								var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
							}

							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>"
						}
					}
					else if(condition_type == "DENTURE"){
						if(mixed_dentition_YN == "Y" && (mapped_tooth_no == null || mapped_tooth_no == "null")){//This is to remove images for extream 3 tooth (in case of MD chart) when we record mark error on any of the treatments..
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

							var imageId = "R"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
						}
						else{
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

							var imageId = "R"+tooth_no_arr[k];
							if(permanent_deciduous_flag == "D"){
								if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
									var imageSrc = "../../eOH/images/R3.gif";
								}
								else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
									var imageSrc = "../../eOH/images/R14.gif";
								}
								else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
									var imageSrc = "../../eOH/images/R19.gif";
								}
								else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
									var imageSrc = "../../eOH/images/R30.gif";
								}
								else{
									var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
								}
							}
							else{
								var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
							}

							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>"
						}
					}
					/*else if(condition_type == "TOOTHTM"){
						var imageId = "toothLayer"+tooth_no_arr[k];
						fillCrownImages(imageId,"ALL",dentalchartFormObj,condition_type,status,tooth_no_arr[k]);

						var imageId = "rootLayer"+tooth_no_arr[k];
						drawLineForRootImage(imageId,"ALL",dentalchartFormObj,condition_type,"ET",tooth_no_arr[k],status);
					}*/
				}
				else{
					if(condition_type == "MISSTH"){
						var imageId = "T"+tooth_no_arr[k];
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img height= '25' src='../../eOH/images/MissingTeeth.gif'>";

						var imageId = "R"+tooth_no_arr[k];
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='3' height='34'/><img height= '25' src='../../eOH/images/MissingTeeth.gif'>";
					}
					else if(condition_type == "UNERTH" || condition_type=="IMPACTN"){// 29FEB BSHANKAR
						var show_img_yn = "N";
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no_arr[k]+"&chart_num="+chart_num+"&patient_id="+patient_id;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=SuperRDyn&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal = localTrimString(retVal);
						if(retVal.length > 0){
							var retVal_arr = retVal.split("##");
							if(retVal_arr[1] == "RTDESTH"){
								show_img_yn = "Y";
							}
							else{
								show_img_yn = "N";
							}
						}
						if(show_img_yn == "N"){
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

							var imageId = "R"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
						}
					}
					else if(condition_type == "EXFOLTH"){
						var exfolth_count = 0;
						var super_recorded = "N";
						var retVal_SuperKey_count = 0;
						var total_SuperKey_count = 0;

						// This code is to get the value of the column SUPERNUMERARY_YN.This is to find out wether the tooth is supernumerary or not.
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "patient_id="+patient_id+"&tooth_no="+tooth_no_arr[k]+"&chart_num="+chart_num;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateSuperYN&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						
						if(retVal.length >= 1){
							var retVal_arr = retVal.split("##");
							super_yn = retVal_arr[0];
							RD_yn = retVal_arr[1];
						}

						//Added by SRidevi Joshi on 1/27/2010 for IN010894(SRR20056-CRF-0481). To get super_key_val
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=checkSuperKey&tooth_no="+tooth_no_arr[k]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_SUPR_yn;

						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal_SuperKey = trimString(xmlHttp.responseText); 
						retVal_SuperKey = localTrimString(retVal_SuperKey); 
						var retVal_SuperKey_arr = retVal_SuperKey.split("~");

						retVal_SuperKey_count = parseInt(retVal_SuperKey_arr.length)-1;
						
						total_SuperKey_count = parseInt(retVal_SuperKey_count)+1; //this is to include tooth_no count also

						//Added to count the number of Exfoliated conditions recorded in case of Retained.
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no_arr[k]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH&RD_Normal_yn="+RD_Normal_yn;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						//xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfToothForSUPRTH&"+params,false);
						xmlHttp.send(xmlDoc);
						var count_Exf = trimString(xmlHttp.responseText);
						count_Exf = localTrimString(count_Exf);
						if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
							var exfolth_retVal_arr = count_Exf.split("##");
							exfolth_count = exfolth_retVal_arr[0];			
						}

						//To retrieve chart_line_num if SUPRTH is recorded
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no_arr[k]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=SUPRTH";
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithChrtLineNum&"+params,false);
						xmlHttp.send(xmlDoc);
						var suprth_chart_line_num = trimString(xmlHttp.responseText);
						suprth_chart_line_num = localTrimString(suprth_chart_line_num);
						if(suprth_chart_line_num.length > 0){
							super_recorded = "Y";
						}

						if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && mapped_tooth_no != null && mapped_tooth_no != "null" && super_yn != "Y" && RD_yn == "M" && exfolth_count == "1" && super_recorded == "N"){ // For Mixed Dentition - Deciduous Chart
							query_tooth_no = mapped_tooth_no;
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText);
							retVal=localTrimString(retVal);
							if(retVal.length > 0){
								disply_tooth_no = retVal;
							}

							var check_num_id = "check_num"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";

						}
						else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" & exfolth_count == total_SuperKey_count){ // For Mixed Dentition - Permanent Chart
							query_tooth_no = mapped_tooth_no;
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText);
							retVal=localTrimString(retVal);
							if(retVal.length > 0){
								disply_tooth_no = retVal;
							}

							var check_num_id = "check_num"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
						}
						//else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && exfolth_count == "3"){ // For Mixed Dentition - Permanent Chart
						else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && exfolth_count == total_SuperKey_count){ // For Mixed Dentition - Permanent Chart
							query_tooth_no = tooth_no_arr[k];
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText);
							retVal=localTrimString(retVal);
							if(retVal.length > 0){
								disply_tooth_no = retVal;
							}

							var check_num_id = "check_num"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
						}
						else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && super_yn != "Y" && RD_yn == "D" && exfolth_count == "1" && super_recorded == "N"){ // Exfoliation on Deciduous Tooth Condition in Mixed Dentition - Permanent Chart
							query_tooth_no = tooth_no_arr[k];
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText);
							retVal=localTrimString(retVal);
							if(retVal.length > 0){
								disply_tooth_no = retVal;
							}

							var check_num_id = "check_num"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
						}


						var imageId = "T"+tooth_no_arr[k];
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

						var imageId = "R"+tooth_no_arr[k];
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
					}
					else if(condition_type == "RTDESTH"){ //Not Applicable to Deciduous Chart
						//Added by Sharon Crasta on 7/27/2009 for IN012514
							//	isSuperRD = true;
						//
						var disply_tooth_no = "";
						var numbering_system = document.forms[0].tooth_numbering_system.value;
						var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
						var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no_arr[k]+"&numbering_system="+numbering_system;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 0){
							disply_tooth_no = retVal;
						}
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no_arr[k]+"&numbering_system="+numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 0){
							var retVal_arr = retVal.split("##")
							if(retVal_arr[0] !="" && retVal_arr[0] != null && retVal_arr[0] != "null"){
								var imageId = "decith_table"+tooth_no_arr[k];
								var tooth_sn = retVal_arr[1];
								var tooth_num = retVal_arr[0];
								var tooth_name = "";
								if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
									//root_img_no = tooth_sn;
									// This condition is used when RTDESTH is recorded in MIXD Dent Dec case, where the DEC tooth is displayed 1st and then permanent tooth (51,11). In case of permanent chart, When RTDESTH is recorded, the permanent tooth is displayed 1st and then the dectooth (11,51)
									var rd_flag = 'RD';			//(51,11 case)
									var rd_normal_flag = "N";
									if(mixed_dent_deciduous_yn == "M" || mixed_dent_deciduous_yn == "R"){
										if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
											root_img_no = "3";
										}
										else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
											root_img_no = "14";
										}
										else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
											root_img_no = "19";
										}
										else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
											root_img_no = "30";
										}
										else{
											root_img_no = tooth_sn;
										}
									}
									else{
										root_img_no = tooth_sn;
									}
								}
								else{
									root_img_no = tooth_no_arr[k];
									var rd_flag = 'N';			//(11,51 case)
									var rd_normal_flag = "RD";
								}
								
								if(tooth_no_arr[k] >= 1 && tooth_no_arr[k] <= 16 || (tooth_no_arr[k]>=33 && tooth_no_arr[k]<=42)){
									dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='R"+root_img_no+ "' align='center'><div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/R" + root_img_no + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td id='T"+tooth_no_arr[k]+"' align='center'><div id='toothLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no_arr[k]+ "#" +tooth_num+ "','RD')\" /></div></td></tr><tr><td align='center' id = 'check_num"+tooth_no_arr[k]+"' id="+tooth_no_arr[k]+"D id="+tooth_no_arr[k]+"RD id="+tooth_no_arr[k]+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +tooth_num+ "','N')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + disply_tooth_no + "</a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +tooth_num+ "','RD')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no_arr[k] +"' id='selcol_hidden"+ tooth_no_arr[k] +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no_arr[k] +"' id='selcol"+ tooth_no_arr[k] +"' value='' onClick = \"setCheckValue(this,'"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no_arr[k]+"' width='45'></td></tr></table></td></tr></table>";
								}
								else{
									dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='T"+tooth_no_arr[k]+"' align='center'><div id='toothLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td id='R"+tooth_no_arr[k]+ "' align='center'><div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/R" + root_img_no + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td align='center' id = 'check_num"+tooth_no_arr[k]+"' id="+tooth_no_arr[k]+"D id="+tooth_no_arr[k]+"RD id="+tooth_no_arr[k]+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +tooth_num+ "','N')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + disply_tooth_no + "</a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +tooth_num+ "','RD')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no_arr[k] +"' id='selcol_hidden"+ tooth_no_arr[k] +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no_arr[k] +"' id='selcol"+ tooth_no_arr[k] +"' value='' onClick = \"setCheckValue(this,'"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no_arr[k]+"' width='45'></td></tr></table></td></tr></table>";
								}
							}
						}
						
					}
					else if(condition_type == "DECITH"){ //Not Applicable for MD-D chart
						var numbering_system = document.forms[0].tooth_numbering_system.value;
						var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
						var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no_arr[k]+"&numbering_system="+numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 0){
							var retVal_arr = retVal.split("##")
							if(retVal_arr[0] !="" && retVal_arr[0] != null && retVal_arr[0] != "null"){
								var imageId = "decith_table"+tooth_no_arr[k];
								var tooth_sn = retVal_arr[1];
								var tooth_num = retVal_arr[0];
								var tooth_name = "";
								if(tooth_no_arr[k]>=1 && tooth_no_arr[k]<=16 || (tooth_no_arr[k]>=33 && tooth_no_arr[k]<=42)){
									dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='R"+tooth_no_arr[k]+ "' align='center'><div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/R" + tooth_no_arr[k] + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td id='T"+tooth_no_arr[k]+"' align='center'><div id='toothLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no_arr[k]+"' id="+tooth_no_arr[k]+"D id="+tooth_no_arr[k]+"RD id="+tooth_no_arr[k]+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +tooth_num+ "','D')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no_arr[k] +"' id='selcol_hidden"+ tooth_no_arr[k] +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no_arr[k] +"' id='selcol"+ tooth_no_arr[k] +"' value='' onClick = \"setCheckValue(this,'"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no_arr[k]+"' width='45'></td></tr></table></td></tr></table>";
								}else{
									dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='T"+tooth_no_arr[k]+"' align='center'><div id='toothLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td id='R"+tooth_no_arr[k]+ "' align='center'><div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/R" + tooth_no_arr[k] + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no_arr[k]+"' id="+tooth_no_arr[k]+"D id="+tooth_no_arr[k]+"RD id="+tooth_no_arr[k]+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +tooth_num+ "','D')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no_arr[k] +"' id='selcol_hidden"+ tooth_no_arr[k] +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no_arr[k] +"' id='selcol"+ tooth_no_arr[k] +"' value='' onClick = \"setCheckValue(this,'"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no_arr[k]+"' width='45'></td></tr></table></td></tr></table>";
								}
							}
						}
					}
					else if(condition_type == "SUPRTH"){
					
					var disply_tooth_no = "";
					var super_str = "";
					var super_main = "";
					var super_check = "";
					var numbering_system = document.forms[0].tooth_numbering_system.value;
					var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
					var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
					var RD_Normal_yn = document.forms[0].RD_Normal_yn.value;
					var super_tooth_ref = document.forms[0].super_tooth_ref.value; //Added by Sridevi Joshi on 12/9/2009 for SUPRTH new changes

					//Added by SRidevi Joshi on 1/22/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					params = "func_mode=checkSuperKey&tooth_no="+tooth_no_arr[k]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_SuperKey = trimString(xmlHttp.responseText); 
					retVal_SuperKey = localTrimString(retVal_SuperKey); 
					var retVal_SuperKey_arr = retVal_SuperKey.split("~");
					
					if(mixed_dentition_YN == "Y" && (tooth_no_arr[k] == "2" || tooth_no_arr[k] == "3" || tooth_no_arr[k] == "14" || tooth_no_arr[k] == "15" || tooth_no_arr[k] == "18" || tooth_no_arr[k] == "19" || tooth_no_arr[k] == "30" || tooth_no_arr[k] == "31")){
						//This is to get display tooth no
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no_arr[k]+"&numbering_system="+numbering_system;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 0){
							var retVal_arr = retVal.split("##");
							disply_tooth_no = retVal_arr[0];
						}
					}
					else if(permanent_deciduous_flag == "P" && mixed_dentition_YN == "Y" && RD_Normal_yn == "D"){
						//This is to get display tooth no
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no_arr[k]+"&numbering_system="+numbering_system;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 0){
							var retVal_arr = retVal.split("##");
							disply_tooth_no = retVal_arr[0];
						}
					}
					else if(permanent_deciduous_flag == "D" && mixed_dentition_YN == "Y" && (RD_Normal_yn == "undefined" || RD_Normal_yn == undefined || RD_Normal_yn == "")){
						//This is to get display tooth no
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no_arr[k]+"&numbering_system="+numbering_system;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 0){
							var retVal_arr = retVal.split("##");
							disply_tooth_no = retVal_arr[0];
						}
					}else{
						//This is to get display tooth no
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no_arr[k]+"&numbering_system="+numbering_system;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 0){
							disply_tooth_no = retVal;
						}
					}


					if(permanent_deciduous_flag == "D" && (mixed_dentition_YN != "Y" || (mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null" || mixed_dent_tooth_no == ""))){ // For MD-P or Deciduous Chart
						if(((mixed_dent_deciduous_yn == "M" || mixed_dent_deciduous_yn == "R") && mixed_dentition_YN == "Y") || mixed_dentition_YN == "N"){
							if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
								var imageSrc = "../../eOH/images/R3.gif";
							}
							else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
								var imageSrc = "../../eOH/images/R14.gif";
							}
							else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
								var imageSrc = "../../eOH/images/R19.gif";
							}
							else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
								var imageSrc = "../../eOH/images/R30.gif";
							}
							else{
								var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
							}
						}
						else{
							var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
						}
					}
					else if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){ // For Permanent Tooth no's in MD-Chart
						var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
					}
					else{
						if(mixed_dent_deciduous_yn == "M" || mixed_dent_deciduous_yn == "R"){
							if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
								var imageSrc = "../../eOH/images/R3.gif";
							}
							else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
								var imageSrc = "../../eOH/images/R14.gif";
							}
							else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
								var imageSrc = "../../eOH/images/R19.gif";
							}
							else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
								var imageSrc = "../../eOH/images/R30.gif";
							}
							else{
								var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
							}
						}
						else{
							var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
						}
					}

					var imageId = "decith_table"+tooth_no_arr[k];
					var check_num_id = "check_num"+tooth_no_arr[k];
					/*if(RD_Normal_yn == "MR"){
						if(super_cnt == "2"){//To disply both Super tooth if SUPRTH is recorded twice
							super_main = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','MR')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no_arr[k]+"'>" + disply_tooth_no + "</font></a>";

							for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
								if(z==0){
									super_str = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','MR','"+retVal_SuperKey_arr[z]+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[z]+"_super_font"+tooth_no_arr[k]+"'>"+retVal_SuperKey_arr[z]+"</font></a>";
								}
								else{
									super_str = super_str+",<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','MR','"+retVal_SuperKey_arr[z]+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[z]+"_super_font"+tooth_no_arr[k]+"'>"+retVal_SuperKey_arr[z]+"</font></a>";
								}
							}

							super_check = "<input type='hidden' name='selcol_hidden"+ tooth_no_arr[k] +"' id='selcol_hidden"+ tooth_no_arr[k] +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no_arr[k] +"' id='selcol"+ tooth_no_arr[k] +"' value='' onClick = \"setCheckValue(this,'"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" >";

							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = super_main+","+super_str+super_check;
						}
						else{
							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','MR')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no_arr[k]+"'>" + disply_tooth_no + "</font></a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','MR','"+super_key_num+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[0]+"_super_font"+tooth_no_arr[k]+"'>"+super_key_num+"</font></a><input type='hidden' name='selcol_hidden"+ tooth_no_arr[k] +"' id='selcol_hidden"+ tooth_no_arr[k] +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no_arr[k] +"' id='selcol"+ tooth_no_arr[k] +"' value='' onClick = \"setCheckValue(this,'"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" >";
						}
					}
					else if(RD_Normal_yn == "D"){
						if(super_cnt == "2"){//To disply both Super tooth if SUPRTH is recorded twice
							super_main = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','D')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no_arr[k]+"'>" + disply_tooth_no + "</font></a>";

							for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
								if(z==0){
									super_str = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','D','"+retVal_SuperKey_arr[z]+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[z]+"_super_font"+tooth_no_arr[k]+"'>"+retVal_SuperKey_arr[z]+"</font></a>";
								}
								else{
									super_str = super_str+",<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','D','"+retVal_SuperKey_arr[z]+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[z]+"_super_font"+tooth_no_arr[k]+"'>"+retVal_SuperKey_arr[z]+"</font></a>";
								}
							}

							super_check = "<input type='hidden' name='selcol_hidden"+ tooth_no_arr[k] +"' id='selcol_hidden"+ tooth_no_arr[k] +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no_arr[k] +"' id='selcol"+ tooth_no_arr[k] +"' value='' onClick = \"setCheckValue(this,'"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" >";

							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = super_main+","+super_str+super_check;
						}
						else{
							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','D')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no_arr[k]+"'>" + disply_tooth_no + "</font></a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','D','"+super_key_num+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[0]+"_super_font"+tooth_no_arr[k]+"'>"+super_key_num+"</font></a><input type='hidden' name='selcol_hidden"+ tooth_no_arr[k] +"' id='selcol_hidden"+ tooth_no_arr[k] +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no_arr[k] +"' id='selcol"+ tooth_no_arr[k] +"' value='' onClick = \"setCheckValue(this,'"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" >";
						}
					}
					else{
						if(super_cnt == "2"){//To disply both Super tooth if SUPRTH is recorded twice
							super_main = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no_arr[k]+"'>" + disply_tooth_no + "</font></a>";

							for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
								if(z==0){
									super_str = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','','"+retVal_SuperKey_arr[z]+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[z]+"_super_font"+tooth_no_arr[k]+"'>"+retVal_SuperKey_arr[z]+"</font></a>";
								}
								else{
									super_str = super_str+",<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','','"+retVal_SuperKey_arr[z]+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[z]+"_super_font"+tooth_no_arr[k]+"'>"+retVal_SuperKey_arr[z]+"</font></a>";
								}
							}

							super_check = "<input type='hidden' name='selcol_hidden"+ tooth_no_arr[k] +"' id='selcol_hidden"+ tooth_no_arr[k] +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no_arr[k] +"' id='selcol"+ tooth_no_arr[k] +"' value='' onClick = \"setCheckValue(this,'"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" >";

							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = super_main+","+super_str+super_check;
						}
						else{
							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no_arr[k]+"'>" + disply_tooth_no + "</font></a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','','"+super_key_num+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[0]+"_super_font"+tooth_no_arr[k]+"'>"+super_key_num+"</font></a><input type='hidden' name='selcol_hidden"+ tooth_no_arr[k] +"' id='selcol_hidden"+ tooth_no_arr[k] +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no_arr[k] +"' id='selcol"+ tooth_no_arr[k] +"' value='' onClick = \"setCheckValue(this,'"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" >";
						}
					}

					if(super_tooth_ref != "" && super_tooth_ref != "undefined" && super_tooth_ref != undefined && status != "E"){//Added by Sridevi Joshi on 1/22/2010 for IN010894
						if(eval("dentalchartFormObj.document.getElementById('"+super_tooth_ref+"_super_font"+tooth_no_arr[k]+"')") != null){
							eval("dentalchartFormObj.document.getElementById('"+super_tooth_ref+"_super_font"+tooth_no_arr[k]+"')").style.backgroundColor = "gray";
							eval("dentalchartFormObj.document.getElementById('"+super_tooth_ref+"_super_font"+tooth_no_arr[k]+"')").style.color = "white";
						}

						if(eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no_arr[k]+"')") != null){
							eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no_arr[k]+"')").style.backgroundColor = "white";
							eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no_arr[k]+"')").style.color = "black";
						}
						
						for(var y=0;y<retVal_SuperKey_arr.length-1;y++){
							if(retVal_SuperKey_arr[y] != super_tooth_ref){
								if(eval("dentalchartFormObj.document.getElementById('"+retVal_SuperKey_arr[y]+"_super_font"+tooth_no_arr[k]+"')") != null){
									eval("dentalchartFormObj.document.getElementById('"+retVal_SuperKey_arr[y]+"_super_font"+tooth_no_arr[k]+"')").style.backgroundColor = "white";
									eval("dentalchartFormObj.document.getElementById('"+retVal_SuperKey_arr[y]+"_super_font"+tooth_no_arr[k]+"')").style.color = "black";
								}
							}
						}
					}
					else{
						if(eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no_arr[k]+"')") != null){
							eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no_arr[k]+"')").style.backgroundColor = "gray";
							eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no_arr[k]+"')").style.color = "white";
						}

						for(var y=0;y<retVal_SuperKey_arr.length-1;y++){//Added by Sridevi Joshi on 1/24/2010 for IN010894
							if(retVal_SuperKey_arr[y] != super_tooth_ref){
								if(eval("dentalchartFormObj.document.getElementById('"+retVal_SuperKey_arr[y]+"_super_font"+tooth_no_arr[k]+"')") != null){
									eval("dentalchartFormObj.document.getElementById('"+retVal_SuperKey_arr[y]+"_super_font"+tooth_no_arr[k]+"')").style.backgroundColor = "white";
									eval("dentalchartFormObj.document.getElementById('"+retVal_SuperKey_arr[y]+"_super_font"+tooth_no_arr[k]+"')").style.color = "black";
								}
							}
						}
					}*/

					if(RD_Normal_yn == "undefined" || RD_Normal_yn == undefined){
						RD_Normal_yn = "";
					}
					
					dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','"+RD_Normal_yn+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no_arr[k]+"'>" + disply_tooth_no + "</font></a><A onclick=\"populateMenuOnSuper('"+tooth_no_arr[k]+ "','" +disply_tooth_no+ "','"+RD_Normal_yn+"','"+super_key_num+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>+</a><input type='hidden' name='selcol_hidden"+ tooth_no_arr[k] +"' id='selcol_hidden"+ tooth_no_arr[k] +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no_arr[k] +"' id='selcol"+ tooth_no_arr[k] +"' value='' onClick = \"setCheckValue(this,'"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" >";
				}

					

					/*else if(condition_type == "SUPRTH"){
						var disply_tooth_no = "";
						var numbering_system = document.forms[0].tooth_numbering_system.value;
						
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no_arr[k]+"&numbering_system="+numbering_system;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 0){
							disply_tooth_no = retVal;

						}
						var imageId = "decith_table"+tooth_no_arr[k];

						if(permanent_deciduous_flag == "D" && (mixed_dentition_YN != "Y" || (mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null" || mixed_dent_tooth_no == ""))){ //For Deciduous or MD-P Chart
							//if(((mixed_dent_deciduous_yn == "M" || mixed_dent_deciduous_yn == "R") && mixed_dentition_YN == "Y") || mixed_dentition_YN == "N"){
								if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
									var imageSrc = "../../eOH/images/R3.gif";
								}
								else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
									var imageSrc = "../../eOH/images/R14.gif";
								}
								else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
									var imageSrc = "../../eOH/images/R19.gif";
								}
								else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
									var imageSrc = "../../eOH/images/R30.gif";
								}
								else{
									var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
								}
							//}
							//else{
								//var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
							//}
						}
						else if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){ //For Permanent Tooth no's in MD Chart
							var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
						}
						else{
							if(mixed_dent_deciduous_yn == "M" || mixed_dent_deciduous_yn == "R"){
								if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
									var imageSrc = "../../eOH/images/R3.gif";
								}
								else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
									var imageSrc = "../../eOH/images/R14.gif";
								}
								else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
									var imageSrc = "../../eOH/images/R19.gif";
								}
								else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
									var imageSrc = "../../eOH/images/R30.gif";
								}
								else{
									var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
								}
							}
							else{
								var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
							}
						}
						
						if(selected_first_thno == tooth_no_arr[k]){
							if(tooth_no_arr[k] >= 1 && tooth_no_arr[k] <= 16 || (tooth_no_arr[k]>=33 && tooth_no_arr[k]<=42)){
								if(super_before == "Y"){
									inter_str = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','S')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" >" + disply_tooth_no + "s</a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','N')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" >" + disply_tooth_no + "</a>";

								}
								else{
									inter_str = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','N')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" >" + disply_tooth_no + "</a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','S')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" >" + disply_tooth_no + "s</a>"

								}
								dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='R"+tooth_no_arr[k]+ "' align='center'><div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" /></div></td></tr><tr><td id='T"+tooth_no_arr[k]+"' align='center'><div id='toothLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" /></div></td></tr><tr><td align='center' id = 'check_num"+tooth_no_arr[k]+"' id="+tooth_no_arr[k]+"D id="+tooth_no_arr[k]+"RD id="+tooth_no_arr[k]+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','N')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + disply_tooth_no + "</a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','S')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + disply_tooth_no + "s</a><input type='hidden' name='selcol_hidden"+ tooth_no_arr[k] +"' id='selcol_hidden"+ tooth_no_arr[k] +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no_arr[k] +"' id='selcol"+ tooth_no_arr[k] +"' value='' onClick = \"setCheckValue(this,'"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no_arr[k]+"' width='45'></td></tr></table></td></tr></table>";
							}
							else{
								if(super_before == "Y"){
									inter_str = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','N')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" >" + disply_tooth_no + "</a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','S')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" >" + disply_tooth_no + "s</a>"
								}
								else{
									inter_str = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','S')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" >" + disply_tooth_no + "s</a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','N')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" >" + disply_tooth_no + "</a>";
								}
								dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='T"+tooth_no_arr[k]+"' align='center'><div id='toothLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" /></div></td></tr><tr><td id='R"+tooth_no_arr[k]+ "' align='center'><div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" /></div></td></tr><tr><td align='center' id = 'check_num"+tooth_no_arr[k]+"' id="+tooth_no_arr[k]+"D id="+tooth_no_arr[k]+"RD id="+tooth_no_arr[k]+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','N')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + disply_tooth_no + "</a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','S')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + disply_tooth_no + "s</a><input type='hidden' name='selcol_hidden"+ tooth_no_arr[k] +"' id='selcol_hidden"+ tooth_no_arr[k] +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no_arr[k] +"' id='selcol"+ tooth_no_arr[k] +"' value='' onClick = \"setCheckValue(this,'"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no_arr[k]+"' width='45'></td></tr></table></td></tr></table>";
							}
						}
						//Added by Sharon Crasta on 7/27/2009 for IN012514
						//isSuperRD = true;
						//
					}*/
					else if(condition_type == "PARERTH"){
						var root_layer = "rootLayer"+tooth_no_arr[k];
						var tooth_layer = "toothLayer"+tooth_no_arr[k];
						var imageId = "R"+tooth_no_arr[k];
						var show_img_yn = "N";
						if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no_arr[k]+"&chart_num="+chart_num+"&patient_id="+patient_id;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=SuperRDyn&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText);
							retVal = localTrimString(retVal);
							if(retVal.length > 0){
								var retVal_arr = retVal.split("##");
								if(retVal_arr[1] == "RTDESTH"){
									show_img_yn = "Y";
								}
								else{
									show_img_yn = "N";
								}
							}
						}
						if(show_img_yn == "N"){
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='41' height='34'/>";
						}

						var imageId = "T"+tooth_no_arr[k];
						
						if(dentalchartFormObj.document.getElementById(tooth_layer) == "null" || dentalchartFormObj.document.getElementById(tooth_layer) == null){
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>";
						}
					}
					else if(condition_type == "ERUPTH"){
					
						var imageId = "R"+tooth_no_arr[k];
						if(permanent_deciduous_flag == "D" && (mixed_dentition_YN != "Y" || (mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null" || mixed_dent_tooth_no == ""))){ //For Deciduous or MD-P Chart
							if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
								var imageSrc = "../../eOH/images/R3.gif";
							}
							else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
								var imageSrc = "../../eOH/images/R14.gif";
							}
							else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
								var imageSrc = "../../eOH/images/R19.gif";
							}
							else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
								var imageSrc = "../../eOH/images/R30.gif";
							}
							else{
								var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
							}
						}
						else if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){//For Permanent Tooth no's in MD Chart
							var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
						}
						else{
							if(mixed_dent_deciduous_yn == "M" || mixed_dent_deciduous_yn == "R"){
								if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
									var imageSrc = "../../eOH/images/R3.gif";
								}
								else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
									var imageSrc = "../../eOH/images/R14.gif";
								}
								else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
									var imageSrc = "../../eOH/images/R19.gif";
								}
								else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
									var imageSrc = "../../eOH/images/R30.gif";
								}
								else{
									var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
								}
							}
							else{
								var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
							}
						}
						
						var root_layer = "rootLayer"+tooth_no_arr[k];
						if(dentalchartFormObj.document.getElementById(root_layer) == "null" || dentalchartFormObj.document.getElementById(root_layer) == null){
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
						}

						var imageId = "T"+tooth_no_arr[k];
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>";
					}

					if(condition_type == "EXTRACT"){
						if(treatments_outcome=="F"){
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src=' "+image_source+" '>";

							var imageId = "R"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen_EF.gif'>";
						}else{
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src=' "+image_source+" '>";

							var imageId = "R"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen_E.gif'>";
						}
					}
					else if(condition_type == "IMPLANT"){
						var imageId = "T"+tooth_no_arr[k];
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img width='45' height='25' src=' "+image_source+" '>";
						var imageId = "R"+tooth_no_arr[k];
						if(treatments_outcome=="F"){
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_root_EF.gif' width='45' height=34'/>";
						}else{
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_root_E.gif' width='45' height=34'/>";						
						}
					}
					else if(condition_type == "BRIDGE" && hide_image_yn == "Y"){
						if(treatments_outcome=="F"){
							//Commented and Added by Sharon Crasta on 2/18/2010 for SRR20056-CRF-0475
							/*var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height='25'/>";

							var imageId = "R"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height=34'/>";	*/
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_EF.gif'/>";
							var imageId = "R"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
						}else{
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_E.gif'/>";
							var imageId = "R"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
						}
					}
					else if(condition_type == "BRIDGE" && hide_image_yn == "N"){
						if(treatments_outcome=="F"){
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_EF.gif'/>";
						}else{
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_E.gif'/>";
						}
					} //End
					else if(condition_type == "DENTURE"){
						var imageId = "T"+tooth_no_arr[k];
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img width='45' height='25' src=' "+image_source+" '>";
						var imageId = "R"+tooth_no_arr[k];
						if(treatments_outcome=="F"){
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_root_EF.gif' width='45' height=34'/>";
						}else{
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Dental_root_E.gif' width='45' height=34'/>";						
						}
					}
					/*else if(condition_type == "TOOTHTM"){
						var imageId = "toothLayer"+tooth_no_arr[k];
						fillCrownImages(imageId,"ALL",dentalchartFormObj,condition_type,status,tooth_no_arr[k]);
						var imageId = "rootLayer"+tooth_no_arr[k];
						drawLineForRootImage(imageId,"ALL",dentalchartFormObj,condition_type,"ET",tooth_no_arr[k],status);
					}*/
				}
			}
		}
		else if(site_type=="TOOTH" && tooth_no.indexOf(",") == -1 ||(site_type=="CROWN")||(site_type=="ROOT")){
			//var RD_Normal_yn = document.forms[0].RD_Normal_yn.value
			var header_tab = document.forms[0].header_tab.value

			var tooth_sn = tooth_no;
			var super_yn = "";
			//To retrieve the display tooth_no and the tooth_name...
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateDisplayToothNoAndName&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal = localTrimString(retVal);
			if(retVal.length > 1){
				var retVal_arr = retVal.split("##");
				tooth_num = retVal_arr[0];
				tooth_name = retVal_arr[1];
				mapped_tooth_no = retVal_arr[2];
				mixed_dent_tooth_no = retVal_arr[3];
			}

            //SCR-6103
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateSuperYN&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal = localTrimString(retVal);
			if(retVal.length > 1){
				var retVal_arr = retVal.split("##");
				super_yn = retVal_arr[0];			
				RD_yn  = retVal_arr[1];			
			}

			if(status == 'E'){	
				if(condition_type == "MISSTH"){
					var imageId = "T"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

					var imageId = "R"+tooth_no;
					if(permanent_deciduous_flag == "D"){
						if(tooth_no == "33" || tooth_no == "34"){
							var imageSrc = "../../eOH/images/R3.gif";
						}
						else if(tooth_no == "41" || tooth_no == "42"){
							var imageSrc = "../../eOH/images/R14.gif";
						}
						else if(tooth_no == "43" || tooth_no == "44"){
							var imageSrc = "../../eOH/images/R19.gif";
						}
						else if(tooth_no == "51" || tooth_no == "52"){
							var imageSrc = "../../eOH/images/R30.gif";
						}
						else{
							var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
						}
					}
					else{
						var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
					}
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='34'/></div>"
                
				}
				else if(condition_type == "UNERTH" || condition_type=="IMPACTN"){ // 29FEB BSHANKAR
					if(tooth_no != '1' && tooth_no != '16' && tooth_no != '17' && tooth_no != '32'){
						var imageId = "T"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

						var imageId = "R"+tooth_no;
						if(permanent_deciduous_flag == "D"){
							if(tooth_no == "33" || tooth_no == "34"){
								var imageSrc = "../../eOH/images/R3.gif";
							}
							else if(tooth_no == "41" || tooth_no == "42"){
								var imageSrc = "../../eOH/images/R14.gif";
							}
							else if(tooth_no == "43" || tooth_no == "44"){
								var imageSrc = "../../eOH/images/R19.gif";
							}
							else if(tooth_no == "51" || tooth_no == "52"){
								var imageSrc = "../../eOH/images/R30.gif";
							}else{
								var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
							}
						}
						else{
							var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
						}

						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>"
					}
				}
				else if(condition_type == "EXFOLTH"){
					var exfolth_count = 0;
					var super_recorded = "N";

					//Added by SRidevi Joshi on 1/27/2010 for IN010894(SRR20056-CRF-0481). To get super_key_val
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=checkSuperKey&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+mixed_dent_deciduous_yn;

						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal_SuperKey = trimString(xmlHttp.responseText); 
						retVal_SuperKey = localTrimString(retVal_SuperKey); 
						var retVal_SuperKey_arr = retVal_SuperKey.split("~");

						retVal_SuperKey_count = parseInt(retVal_SuperKey_arr.length)-1;
						
						total_SuperKey_count = parseInt(retVal_SuperKey_count)+1; //this is to include tooth_no count also

						//Added to count the number of Exfoliated conditions recorded in case of Retained.
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH&RD_Normal_yn="+mixed_dent_deciduous_yn;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						//xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfToothForSUPRTH&"+params,false);
						xmlHttp.send(xmlDoc);
						var count_Exf = trimString(xmlHttp.responseText);
						count_Exf = localTrimString(count_Exf);
						if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
							var exfolth_retVal_arr = count_Exf.split("##");
							exfolth_count = exfolth_retVal_arr[0];			
						}

					//To retrieve chart_line_num if SUPRTH is recorded
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=SUPRTH";
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithChrtLineNum&"+params,false);
					xmlHttp.send(xmlDoc);
					var suprth_chart_line_num = trimString(xmlHttp.responseText);
					suprth_chart_line_num = localTrimString(suprth_chart_line_num);
					if(suprth_chart_line_num.length > 0){
						super_recorded = "Y";
					}
					if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && mapped_tooth_no != null && mapped_tooth_no != "null" && super_yn != "Y" && RD_yn == "M" && exfolth_count == "1" && super_recorded == "N"){ // For Mixed Dentition - Deciduous Chart
						query_tooth_no = mapped_tooth_no;
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 0){
							disply_tooth_no = retVal;
						}

						var check_num_id = "check_num"+tooth_no;
						dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";

					}
					//else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && exfolth_count == "3"){ // For Mixed Dentition - Permanent Chart
					else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && exfolth_count == total_SuperKey_count){ // For Mixed Dentition - Permanent Chart
						query_tooth_no = mapped_tooth_no;
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 0){
							disply_tooth_no = retVal;
						}

						var check_num_id = "check_num"+tooth_no;
						dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
					}
					//else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && exfolth_count == "3"){ // For Mixed Dentition - Permanent Chart
					else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && exfolth_count == total_SuperKey_count){ // For Mixed Dentition - Permanent Chart
						query_tooth_no = tooth_no;
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 0){
							disply_tooth_no = retVal;
						}

						var check_num_id = "check_num"+tooth_no;
						dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
					}
					//else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && super_yn != "Y" && RD_yn == "D" && exfolth_count == "1" && super_recorded == "N"){ // Exfoliation on Deciduous Tooth Condition in Mixed Dentition - Permanent Chart
					else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && super_yn != "Y" && exfolth_count == "1" && RD_yn == "D" && super_recorded == "N"){ // Exfoliation on Deciduous Tooth Condition in Mixed Dentition - Permanent Chart(ERUPTH after this and check once the tooth no)
						query_tooth_no = tooth_no;
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 0){
							disply_tooth_no = retVal;
						}

						var check_num_id = "check_num"+tooth_no;
						dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
					}
					else{
						if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
							query_tooth_no = tooth_no;
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText);
							retVal=localTrimString(retVal);
							if(retVal.length > 0){
								disply_tooth_no = retVal;
							}

							var check_num_id = "check_num"+tooth_no;
							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
						}
					}


					var imageId = "T"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";
							var imageId = "R"+tooth_no;
							if(permanent_deciduous_flag == "D"){

								if(tooth_no == "33" || tooth_no == "34"){
									var imageSrc = "../../eOH/images/R3.gif";
								}
								else if(tooth_no == "41" || tooth_no == "42"){
									var imageSrc = "../../eOH/images/R14.gif";
								}
								else if(tooth_no == "43" || tooth_no == "44"){
									var imageSrc = "../../eOH/images/R19.gif";
								}
								else if(tooth_no == "51" || tooth_no == "52"){
									var imageSrc = "../../eOH/images/R30.gif";
								}
								else{
									var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
								}
							}
							else{
								var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
							}
						
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>" 
			
					
				}
				else if(condition_type == "DECITH" || condition_type == "RTDESTH" || condition_type == "SUPRTH"){
					var numbering_system = document.forms[0].tooth_numbering_system.value;
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					retVal=localTrimString(retVal);
					if(retVal.length > 0){
						var imageId = "decith_table"+tooth_no;
						var tooth_sn = tooth_no;
						var tooth_num = retVal;
						var tooth_name = "";

						if(permanent_deciduous_flag == "D" && (mixed_dentition_YN != "Y" || (mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null" || mixed_dent_tooth_no == ""))){ //For Deciduous or MD-P Chart
							if(tooth_no == "33" || tooth_no == "34"){
								var imageSrc = "../../eOH/images/R3.gif";
							}
							else if(tooth_no == "41" || tooth_no == "42"){
								var imageSrc = "../../eOH/images/R14.gif";
							}
							else if(tooth_no == "43" || tooth_no == "44"){
								var imageSrc = "../../eOH/images/R19.gif";
							}
							else if(tooth_no == "51" || tooth_no == "52"){
								var imageSrc = "../../eOH/images/R30.gif";
							}
							else{
								var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
							}
						}
						else if((permanent_deciduous_flag =="D" || permanent_deciduous_flag =="P" ) && mixed_dentition_YN=="Y" &&(mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){
							var imageId = "R"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";

							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
							var check_num_id = "check_num"+tooth_no;						
						}
						else if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){ //For Permanet Tooth no's in MD chart
							if(tooth_no == "33" || tooth_no == "34"){
								var imageSrc = "../../eOH/images/R3.gif";
							}
							else if(tooth_no == "41" || tooth_no == "42"){
								var imageSrc = "../../eOH/images/R14.gif";
							}
							else if(tooth_no == "43" || tooth_no == "44"){
								var imageSrc = "../../eOH/images/R19.gif";
							}
							else if(tooth_no == "51" || tooth_no == "52"){
								var imageSrc = "../../eOH/images/R30.gif";
							}else{
								var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
							}
						}
						else{
							if(tooth_no == "33" || tooth_no == "34"){
								var imageSrc = "../../eOH/images/R3.gif";
							}
							else if(tooth_no == "41" || tooth_no == "42"){
								var imageSrc = "../../eOH/images/R14.gif";
							}
							else if(tooth_no == "43" || tooth_no == "44"){
								var imageSrc = "../../eOH/images/R19.gif";
							}
							else if(tooth_no == "51" || tooth_no == "52"){
								var imageSrc = "../../eOH/images/R30.gif";
							}else{
								var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
							}
						}

					//added if ()  condition block for issue---Make any of extream 3 tooth as erupted, supernum than mark first erupted as error than suernum as error Before refresh root and crown is present,but after refresh its not coming.(previously else bolck was thr only )//parul on 6/29/2009

					if((permanent_deciduous_flag=="D" || permanent_deciduous_flag=="P") && mixed_dentition_YN=="Y"){
						var rd_flag = "";
						if(permanent_deciduous_flag=="D"){
							rd_flag = "MR";
						}
					
						if (tooth_no>=1 &&tooth_no<=3 ||tooth_no>=14 &&tooth_no<=19 ||tooth_no>=30 &&tooth_no<=32 ){
							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num +"</a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
						}
						else if((tooth_no>=4 && tooth_no<=13) || (tooth_no>=33 && tooth_no<=42)){
							dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_flag+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no+"' width='45'></td></tr></table></td></tr></table>";
						}else{
							dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_flag+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no+"' width='45'></td></tr></table></td></tr></table>";
						}
					}else{
						if((tooth_no>=1 && tooth_no<=16) || (tooth_no>=33 && tooth_no<=42)){
							dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no+"' width='45'></td></tr></table></td></tr></table>";
						}else{
							dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no+"' width='45'></td></tr></table></td></tr></table>";
							}
										
						}
					}
				}
				else if(condition_type == "PARERTH"){
					if(tooth_no != '1' && tooth_no != '16' && tooth_no != '17' && tooth_no != '32'){
						if(mixed_dentition_YN == "Y" && (mapped_tooth_no == null || mapped_tooth_no == "null" || mapped_tooth_no == "")){//This is to remove images for extream 3 tooth (in case of MD chart) when we record mark error on any of the treatments..
							var imageId = "R"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";

							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
							
						}
						else{
							var imageId = "R"+tooth_no;
							if(permanent_deciduous_flag == "D" && (mixed_dentition_YN != "Y" || (mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null" || mixed_dent_tooth_no == ""))){ // For Deciduous or MD-P chart
								if(tooth_no == "33" || tooth_no == "34"){
									var imageSrc = "../../eOH/images/R3.gif";
								}
								else if(tooth_no == "41" || tooth_no == "42"){
									var imageSrc = "../../eOH/images/R14.gif";
								}
								else if(tooth_no == "43" || tooth_no == "44"){
									var imageSrc = "../../eOH/images/R19.gif";
								}
								else if(tooth_no == "51" || tooth_no == "52"){
									var imageSrc = "../../eOH/images/R30.gif";
								}else{
									var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
								}
							}
							else if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){ //For Permanent Tooth no's in MD Chart
								var imageSrc = "../../eOH/images/spacer.gif";	
							}
							else{
								if(tooth_no == "33" || tooth_no == "34"){
									var imageSrc = "../../eOH/images/R3.gif";
								}
								else if(tooth_no == "41" || tooth_no == "42"){
									var imageSrc = "../../eOH/images/R14.gif";
								}
								else if(tooth_no == "43" || tooth_no == "44"){
									var imageSrc = "../../eOH/images/R19.gif";
								}
								else if(tooth_no == "51" || tooth_no == "52"){
									var imageSrc = "../../eOH/images/R30.gif";
								}else{
									var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
								}
							}
						
							var root_layer = "rootLayer"+tooth_no;
							if(dentalchartFormObj.document.getElementById(root_layer) == "null" || dentalchartFormObj.document.getElementById(root_layer) == null){
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
							}

							var imageId = "T"+tooth_no;
							if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){
								var imageSrc = "../../eOH/images/spacer.gif";	
							}
							else{
								var imageSrc = "../../eOH/images/T.gif";	
							}

							var tooth_layer = "toothLayer"+tooth_no;
							if(dentalchartFormObj.document.getElementById(tooth_layer) == "null" || dentalchartFormObj.document.getElementById(tooth_layer) == null){
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='"+imageSrc+"' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>";
							}
						}
					}
					else{
						var imageId = "R"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";

						var imageId = "T"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
					}
					
				}
				else if(condition_type == "ERUPTH"){
					if(tooth_no != '1' && tooth_no != '16' && tooth_no != '17' && tooth_no != '32'){
						if(mixed_dentition_YN == "Y" && (mapped_tooth_no == null || mapped_tooth_no == "null" || mapped_tooth_no == "" )){//This is to remove images for extream 3 tooth (in case of MD chart) when we record mark error on any of the treatments..
							var imageId = "R"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";

							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
						}
						else{
							var imageId = "R"+tooth_no;
							if(permanent_deciduous_flag == "D" && (mixed_dentition_YN != "Y" || (mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null" || mixed_dent_tooth_no == ""))){ // For Deciduous or MD-P chart
								if(tooth_no == "33" || tooth_no == "34"){
									var imageSrc = "../../eOH/images/R3.gif";
								}
								else if(tooth_no == "41" || tooth_no == "42"){
									var imageSrc = "../../eOH/images/R14.gif";
								}
								else if(tooth_no == "43" || tooth_no == "44"){
									var imageSrc = "../../eOH/images/R19.gif";
								}
								else if(tooth_no == "51" || tooth_no == "52"){
									var imageSrc = "../../eOH/images/R30.gif";
								}else{
									var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
								}
							}
							else if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){ //For Permanent Tooth no's in MD Chart
								var imageSrc = "../../eOH/images/spacer.gif";	
							}
							else{
								if(tooth_no == "33" || tooth_no == "34"){
									var imageSrc = "../../eOH/images/R3.gif";
								}
								else if(tooth_no == "41" || tooth_no == "42"){
									var imageSrc = "../../eOH/images/R14.gif";
								}
								else if(tooth_no == "43" || tooth_no == "44"){
									var imageSrc = "../../eOH/images/R19.gif";
								}
								else if(tooth_no == "51" || tooth_no == "52"){
									var imageSrc = "../../eOH/images/R30.gif";
								}else{
									var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
								}
							}
						
							var root_layer = "rootLayer"+tooth_no;
							if(dentalchartFormObj.document.getElementById(root_layer) == "null" || dentalchartFormObj.document.getElementById(root_layer) == null){
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
							}

							var imageId = "T"+tooth_no;
							if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){
								var imageSrc = "../../eOH/images/spacer.gif";	
							}
							else{
								var imageSrc = "../../eOH/images/T.gif";	
							}

							var tooth_layer = "toothLayer"+tooth_no;
							if(dentalchartFormObj.document.getElementById(tooth_layer) == "null" || dentalchartFormObj.document.getElementById(tooth_layer) == null){
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='"+imageSrc+"' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>";
							}
						}
					}
					else{
						var imageId = "R"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";

						var imageId = "T"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
					}
				}

				if( condition_type == "EXTRACT"){
					var imageId = "T"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

					var imageId = "R"+tooth_no;
					if(permanent_deciduous_flag == "D"){
						if(tooth_no == "33" || tooth_no == "34"){
							var imageSrc = "../../eOH/images/R3.gif";
						}
						else if(tooth_no == "41" || tooth_no == "42"){
							var imageSrc = "../../eOH/images/R14.gif";
						}
						else if(tooth_no == "43" || tooth_no == "44"){
							var imageSrc = "../../eOH/images/R19.gif";
						}
						else if(tooth_no == "51" || tooth_no == "52"){
							var imageSrc = "../../eOH/images/R30.gif";
						}else{
							var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
						}
					}
					else{
						var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
					}
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
				}
				else if(condition_type == "IMPLANT"){
					var imageId = "T"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } /></div>";

					var imageId = "R"+tooth_no;
					if(permanent_deciduous_flag == "D"){
						if(tooth_no == "33" || tooth_no == "34"){
							var imageSrc = "../../eOH/images/R3.gif";
						}
						else if(tooth_no == "41" || tooth_no == "42"){
							var imageSrc = "../../eOH/images/R14.gif";
						}
						else if(tooth_no == "43" || tooth_no == "44"){
							var imageSrc = "../../eOH/images/R19.gif";
						}
						else if(tooth_no == "51" || tooth_no == "52"){
							var imageSrc = "../../eOH/images/R30.gif";
						}else{
							var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
						}
					}
					else{
						var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
					}

					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
				}
			}
			else{
			//alert("imageReplace condition_type--------->"+condition_type)

				if(condition_type == "MISSTH"){
					var imageId = "T"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img height= '25' src='../../eOH/images/MissingTeeth.gif'>";					

					var imageId = "R"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='3' height='34'/><img height= '25' src='../../eOH/images/MissingTeeth.gif'>";
				}
				else if(condition_type == "UNERTH"){ 
					//When recording REtained Deciduous in Permanent Chart, dont show Root and Crown images.
					var imageId = "T"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

					var imageId = "R"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
				}
				else if(condition_type=="IMPACTN"){ 
					if(!isPartiallyErupted){//Added by Sridevi Joshi on 12/17/2009 for IN017296 to show Crown image after recording imaction on PARERTH
						var imageId = "T"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

						var imageId = "R"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
					}
				}
				else if(condition_type == "EXFOLTH"){
					var exfolth_count = 0;
					var super_recorded = "N";

					//Added by SRidevi Joshi on 1/27/2010 for IN010894(SRR20056-CRF-0481). To get super_key_val
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=checkSuperKey&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+mixed_dent_deciduous_yn;

						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal_SuperKey = trimString(xmlHttp.responseText); 
						retVal_SuperKey = localTrimString(retVal_SuperKey); 
						var retVal_SuperKey_arr = retVal_SuperKey.split("~");

						retVal_SuperKey_count = parseInt(retVal_SuperKey_arr.length)-1;
						
						total_SuperKey_count = parseInt(retVal_SuperKey_count)+1; //this is to include tooth_no count also

						//Added to count the number of Exfoliated conditions recorded in case of Retained.
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH&RD_Normal_yn="+mixed_dent_deciduous_yn;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						//xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfToothForSUPRTH&"+params,false);
						xmlHttp.send(xmlDoc);
						var count_Exf = trimString(xmlHttp.responseText);
						count_Exf = localTrimString(count_Exf);
						if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
							var exfolth_retVal_arr = count_Exf.split("##");
							exfolth_count = exfolth_retVal_arr[0];			
						}

					//To retrieve chart_line_num if SUPRTH is recorded
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=SUPRTH";
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithChrtLineNum&"+params,false);
					xmlHttp.send(xmlDoc);
					var suprth_chart_line_num = trimString(xmlHttp.responseText);
					suprth_chart_line_num = localTrimString(suprth_chart_line_num);
					if(suprth_chart_line_num.length > 0){
						super_recorded = "Y";
					}

					if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && mapped_tooth_no != null && mapped_tooth_no != "null" && super_yn != "Y" && RD_yn == "M" && exfolth_count == "1" && super_recorded == "N"){ // For Mixed Dentition - Deciduous Chart
						query_tooth_no = mapped_tooth_no;
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 0){
							disply_tooth_no = retVal;
						}

						var check_num_id = "check_num"+tooth_no;
						dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";

					}
					//else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && exfolth_count == "3"){ // For Mixed Dentition - Permanent Chart
					else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && exfolth_count == total_SuperKey_count && (retVal_SuperKey_arr != "" && retVal_SuperKey_arr != "null" && retVal_SuperKey_arr != null)){ // For Mixed Dentition - Permanent Chart
						query_tooth_no = mapped_tooth_no;
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 0){
							disply_tooth_no = retVal;
						}

						var check_num_id = "check_num"+tooth_no;
						dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
					}
					//else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && exfolth_count == "3"){ // For Mixed Dentition - Permanent Chart
					else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && exfolth_count == total_SuperKey_count && (retVal_SuperKey_arr != "" && retVal_SuperKey_arr != "null" && retVal_SuperKey_arr != null)){ // For Mixed Dentition - Permanent Chart
						query_tooth_no = tooth_no;
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 0){
							disply_tooth_no = retVal;
						}

						var check_num_id = "check_num"+tooth_no;
						dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
					}
					//else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && super_yn != "Y" && RD_yn == "D" && exfolth_count == "1" && super_recorded == "N"){ // Exfoliation on Deciduous Tooth Condition in Mixed Dentition - Permanent Chart
					else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && super_yn != "Y" && exfolth_count == "1" && RD_yn == "D" && super_recorded == "N"){ // Exfoliation on Deciduous Tooth Condition in Mixed Dentition - Permanent Chart(ERUPTH after this and check once the tooth no)
						query_tooth_no = tooth_no;
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 0){
							disply_tooth_no = retVal;
						}

						var check_num_id = "check_num"+tooth_no;
						dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
					}


					var imageId = "T"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

					var imageId = "R"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
					
					//alert('end..'+dentalchartFormObj.document.getElementById(imageId).innerHTML);

				}
				else if(condition_type == "RTDESTH"){ //Not Applicable for Deciduous Chart
					var disply_tooth_no = "";
					var MDD_flag = "";
					var numbering_system = document.forms[0].tooth_numbering_system.value;
					var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
					var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					retVal=localTrimString(retVal);

					if(retVal.length >=1){
						disply_tooth_no = retVal;
					}

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					retVal=localTrimString(retVal);
					if(retVal.length > 1){
						var retVal_arr = retVal.split("##")
						if(retVal_arr[0] !="" && retVal_arr[0] != null && retVal_arr[0] != "null"){
							var imageId = "decith_table"+tooth_no;
							var tooth_sn = retVal_arr[1];
							var tooth_num = retVal_arr[0];
							var tooth_name = "";
							if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
								if(mixed_dent_deciduous_yn == "M" || mixed_dent_deciduous_yn == "R"){
									if(tooth_no == "33" || tooth_no == "34"){
										root_img_no = "3";
									}
									else if(tooth_no == "41" || tooth_no == "42"){
										root_img_no = "14";
									}
									else if(tooth_no == "43" || tooth_no == "44"){
										root_img_no = "19";
									}
									else if(tooth_no == "51" || tooth_no == "52"){
										root_img_no = "30";
									}
									else{
										root_img_no = tooth_sn;
									}
								}
								else{
									root_img_no = tooth_sn;
								}

								// This condition is used when RTDESTH is recorded in MIXD Dent Dec case, where the DEC tooth is displayed 1st and then permanent tooth (51,11). In case of permanent chart, When RTDESTH is recorded, the permanent tooth is displayed 1st and then the dectooth (11,51)
								var rd_flag = 'RD';			//(51,11 case)
								var rd_normal_flag = "NR";
								MDD_flag = "RD"
							}
							else{
								root_img_no = tooth_no;
								var rd_flag = 'NR';			//(11,51 case)
								var rd_normal_flag = "RD";
							
							}
							//Added by Sharon Crasta on 10/28/2009 for IN012514
							//Added to display only the tooth no and not to replace the crown and root on Retained Deciduous.
							var check_num_id = "check_num"+tooth_no;
							if(mixed_dentition_YN == "Y" && permanent_deciduous_flag=="P"){
								dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_flag+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + disply_tooth_no + "</font></a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_normal_flag+"','RD')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='retained_font"+tooth_no+"'>" + tooth_num + "</font></a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
							}
							else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag=="D"){
								dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_flag+"','RD')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='retained_font"+tooth_no+"'>" + disply_tooth_no + "</font></a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_normal_flag+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + tooth_num + "</font></a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
							}
							else{
								if(tooth_no >= 1 && tooth_no <= 16 || (tooth_no>=33 && tooth_no<=42)){
									dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/R" + root_img_no + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "','"+MDD_flag+"')\" /></div></td></tr><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "','"+MDD_flag+"')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_flag+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + disply_tooth_no + "</font></a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_normal_flag+"','RD')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='retained_font"+tooth_no+"'>" + tooth_num + "</font></a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no+"' width='45'></td></tr></table></td></tr></table>";
								}
								else{
									dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "','"+MDD_flag+"')\" /></div></td></tr><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/R" + root_img_no + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "','"+MDD_flag+"')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_flag+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + disply_tooth_no + "</font></a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_normal_flag+"','RD')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='retained_font"+tooth_no+"'>" + tooth_num + "</font></a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no+"' width='45'></td></tr></table></td></tr></table>";
								}
							}
						}
					}

					if(super_tooth_ref == "RD"){
						eval("dentalchartFormObj.document.getElementById('retained_font"+tooth_no+"')").style.backgroundColor = "gray";
						eval("dentalchartFormObj.document.getElementById('retained_font"+tooth_no+"')").style.color = "white";
						eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')").style.backgroundColor = "white";
						eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')").style.color = "black";
					}
					else{
						if(mixed_dentition_YN == "Y" && permanent_deciduous_flag=="D"){
							if(eval("dentalchartFormObj.document.getElementById('retained_font"+tooth_no+"')") != null){
								eval("dentalchartFormObj.document.getElementById('retained_font"+tooth_no+"')").style.backgroundColor = "gray";
								eval("dentalchartFormObj.document.getElementById('retained_font"+tooth_no+"')").style.color = "white";
							}
							else if(eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')") != null){
								eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')").style.backgroundColor = "white";
								eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')").style.color = "black";
							}
						}
						else{
							if(eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')") != null){
								eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')").style.backgroundColor = "gray";
								eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')").style.color = "white";
							}

							else if(eval("dentalchartFormObj.document.getElementById('retained_font"+tooth_no+"')") != null){
								eval("dentalchartFormObj.document.getElementById('retained_font"+tooth_no+"')").style.backgroundColor = "white";
								eval("dentalchartFormObj.document.getElementById('retained_font"+tooth_no+"')").style.color = "black";
							}
						}
					}
				}
				else if(condition_type == "SUPRTH"){
					var disply_tooth_no = "";
					var super_str = "";
					var super_main = "";
					var super_check = "";
					var numbering_system = document.forms[0].tooth_numbering_system.value;
					var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
					var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
					//var RD_Normal_yn = document.forms[0].RD_Normal_yn.value;
					//var ref_tooth_no = document.forms[0].ref_tooth_no.value;
					var super_tooth_ref = document.forms[0].super_tooth_ref.value; //Added by Sridevi Joshi on 12/9/2009 for SUPRTH new changes

					//Added by SRidevi Joshi on 1/22/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					params = "func_mode=checkSuperKey&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_SuperKey = trimString(xmlHttp.responseText); 
					retVal_SuperKey = localTrimString(retVal_SuperKey); 
					var retVal_SuperKey_arr = retVal_SuperKey.split("~");

					if(mixed_dentition_YN == "Y" && (tooth_no == "2" || tooth_no == "3" || tooth_no == "14" || tooth_no == "15" || tooth_no == "18" || tooth_no == "19" || tooth_no == "30" || tooth_no == "31")){
						//This is to get display tooth no
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 0){
							var retVal_arr = retVal.split("##");
							disply_tooth_no = retVal_arr[0];
						}
					}
					else if(permanent_deciduous_flag == "P" && mixed_dentition_YN == "Y" && RD_Normal_yn == "D"){
						//This is to get display tooth no
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 0){
							var retVal_arr = retVal.split("##");
							disply_tooth_no = retVal_arr[0];
						}
					}
					else if(permanent_deciduous_flag == "D" && mixed_dentition_YN == "Y" && (RD_Normal_yn == "undefined" || RD_Normal_yn == undefined || RD_Normal_yn == "") &&( ref_tooth_no != "" && ref_tooth_no != "undefined" && ref_tooth_no != undefined)){
						//This is to get display tooth no
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 0){
							var retVal_arr = retVal.split("##");
							disply_tooth_no = retVal_arr[0];
						}
					}else{
						//This is to get display tooth no
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 0){
							disply_tooth_no = retVal;
						}
					}


					if(permanent_deciduous_flag == "D" && (mixed_dentition_YN != "Y" || (mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null" || mixed_dent_tooth_no == ""))){ // For MD-P or Deciduous Chart
						if(((mixed_dent_deciduous_yn == "M" || mixed_dent_deciduous_yn == "R") && mixed_dentition_YN == "Y") || mixed_dentition_YN == "N"){
							if(tooth_no == "33" || tooth_no == "34"){
								var imageSrc = "../../eOH/images/R3.gif";
							}
							else if(tooth_no == "41" || tooth_no == "42"){
								var imageSrc = "../../eOH/images/R14.gif";
							}
							else if(tooth_no == "43" || tooth_no == "44"){
								var imageSrc = "../../eOH/images/R19.gif";
							}
							else if(tooth_no == "51" || tooth_no == "52"){
								var imageSrc = "../../eOH/images/R30.gif";
							}
							else{
								var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
							}
						}
						else{
							var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
						}
					}
					else if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){ // For Permanent Tooth no's in MD-Chart
						var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
					}
					else{
						if(mixed_dent_deciduous_yn == "M" || mixed_dent_deciduous_yn == "R"){
							if(tooth_no == "33" || tooth_no == "34"){
								var imageSrc = "../../eOH/images/R3.gif";
							}
							else if(tooth_no == "41" || tooth_no == "42"){
								var imageSrc = "../../eOH/images/R14.gif";
							}
							else if(tooth_no == "43" || tooth_no == "44"){
								var imageSrc = "../../eOH/images/R19.gif";
							}
							else if(tooth_no == "51" || tooth_no == "52"){
								var imageSrc = "../../eOH/images/R30.gif";
							}
							else{
								var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
							}
						}
						else{
							var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
						}
					}

					var imageId = "decith_table"+tooth_no;
					var check_num_id = "check_num"+tooth_no;
					if(RD_Normal_yn == "MR"){
						if(super_cnt == "2"){//To disply both Super tooth if SUPRTH is recorded twice
							super_main = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','MR')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + disply_tooth_no + "</font></a>";

							for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
								if(z==0){
									super_str = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','MR','"+retVal_SuperKey_arr[z]+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[z]+"_super_font"+tooth_no+"'>"+retVal_SuperKey_arr[z]+"</font></a>";
								}
								else{
									super_str = super_str+",<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','MR','"+retVal_SuperKey_arr[z]+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[z]+"_super_font"+tooth_no+"'>"+retVal_SuperKey_arr[z]+"</font></a>";
								}
							}

							super_check = "<input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" >";

							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = super_main+","+super_str+super_check;
						}
						else{
							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','MR')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + disply_tooth_no + "</font></a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','MR','"+super_key_num+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[0]+"_super_font"+tooth_no+"'>"+super_key_num+"</font></a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" >";
						}
					}
					else if(RD_Normal_yn == "D"){
						if(super_cnt == "2"){//To disply both Super tooth if SUPRTH is recorded twice
							super_main = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','D')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + disply_tooth_no + "</font></a>";

							for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
								if(z==0){
									super_str = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','D','"+retVal_SuperKey_arr[z]+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[z]+"_super_font"+tooth_no+"'>"+retVal_SuperKey_arr[z]+"</font></a>";
								}
								else{
									super_str = super_str+",<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','D','"+retVal_SuperKey_arr[z]+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[z]+"_super_font"+tooth_no+"'>"+retVal_SuperKey_arr[z]+"</font></a>";
								}
							}

							super_check = "<input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" >";

							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = super_main+","+super_str+super_check;
						}
						else{
							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','D')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + disply_tooth_no + "</font></a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','D','"+super_key_num+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[0]+"_super_font"+tooth_no+"'>"+super_key_num+"</font></a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" >";
						}
					}
					else{
						if(super_cnt == "2"){//To disply both Super tooth if SUPRTH is recorded twice
							super_main = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + disply_tooth_no + "</font></a>";

							for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
								if(z==0){
									super_str = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','','"+retVal_SuperKey_arr[z]+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[z]+"_super_font"+tooth_no+"'>"+retVal_SuperKey_arr[z]+"</font></a>";
								}
								else{
									super_str = super_str+",<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','','"+retVal_SuperKey_arr[z]+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[z]+"_super_font"+tooth_no+"'>"+retVal_SuperKey_arr[z]+"</font></a>";
								}
							}

							super_check = "<input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" >";

							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = super_main+","+super_str+super_check;
						}
						else{
							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + disply_tooth_no + "</font></a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','','"+super_key_num+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[0]+"_super_font"+tooth_no+"'>"+super_key_num+"</font></a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" >";
						}
					}

					/*if(RD_Normal_yn == "undefined" || RD_Normal_yn == undefined){
						RD_Normal_yn = "";
					}
					
						dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','"+RD_Normal_yn+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + disply_tooth_no + "</font></a><A onclick=\"populateMenuOnSuper('"+tooth_no+ "','" +disply_tooth_no+ "','"+RD_Normal_yn+"','"+super_key_num+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>+</a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" >";

					*/
					if(isSuprthError == "Y" || isExfolthError == "Y"){
						if(retVal_SuperKey_arr.length > 0){
							if(eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')") != null){
								eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')").style.backgroundColor = "gray";
								eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')").style.color = "white";
							}
						}
					}
					else if(super_tooth_ref != "" && super_tooth_ref != "undefined" && super_tooth_ref != undefined){//Added by Sridevi Joshi on 1/22/2010 for IN010894
						if(eval("dentalchartFormObj.document.getElementById('"+super_tooth_ref+"_super_font"+tooth_no+"')") != null){
							eval("dentalchartFormObj.document.getElementById('"+super_tooth_ref+"_super_font"+tooth_no+"')").style.backgroundColor = "gray";
							eval("dentalchartFormObj.document.getElementById('"+super_tooth_ref+"_super_font"+tooth_no+"')").style.color = "white";
						}

						if(eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')") != null){
							eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')").style.backgroundColor = "white";
							eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')").style.color = "black";
						}
						
						for(var y=0;y<retVal_SuperKey_arr.length-1;y++){
							if(retVal_SuperKey_arr[y] != super_tooth_ref){
								if(eval("dentalchartFormObj.document.getElementById('"+retVal_SuperKey_arr[y]+"_super_font"+tooth_no+"')") != null){
									eval("dentalchartFormObj.document.getElementById('"+retVal_SuperKey_arr[y]+"_super_font"+tooth_no+"')").style.backgroundColor = "white";
									eval("dentalchartFormObj.document.getElementById('"+retVal_SuperKey_arr[y]+"_super_font"+tooth_no+"')").style.color = "black";
								}
							}
						}
					}
					else{
						if(eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')") != null){
							eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')").style.backgroundColor = "gray";
							eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')").style.color = "white";
						}

						for(var y=0;y<retVal_SuperKey_arr.length-1;y++){//Added by Sridevi Joshi on 1/24/2010 for IN010894
							if(retVal_SuperKey_arr[y] != super_tooth_ref){
								if(eval("dentalchartFormObj.document.getElementById('"+retVal_SuperKey_arr[y]+"_super_font"+tooth_no+"')") != null){
									eval("dentalchartFormObj.document.getElementById('"+retVal_SuperKey_arr[y]+"_super_font"+tooth_no+"')").style.backgroundColor = "white";
									eval("dentalchartFormObj.document.getElementById('"+retVal_SuperKey_arr[y]+"_super_font"+tooth_no+"')").style.color = "black";
								}
							}
						}
					}
				}
				else if(condition_type == "DECITH"){ //Not Applicable for MD-D Chart
					var numbering_system = document.forms[0].tooth_numbering_system.value;
					var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
					var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
					var RD_Normal_yn = document.forms[0].RD_Normal_yn.value;
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					retVal=localTrimString(retVal);
					if(retVal.length > 1){
						var retVal_arr = retVal.split("##")
						if(retVal_arr[0] !="" && retVal_arr[0] != null && retVal_arr[0] != "null"){
							var imageId = "decith_table"+tooth_no;
							var tooth_sn = retVal_arr[1];
							var tooth_num = retVal_arr[0];
							var tooth_name = "";

							var imageSrc = "../../eOH/images/R" + tooth_no + ".gif";
							if(tooth_no >= 1 && tooth_no <= 16 || (tooth_no>=33 && tooth_no<=42)){
								dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;cursor:pointer'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "','D')\" /></div></td></tr><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;cursor:pointer'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "','D')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','D')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no+"' width='45'></td></tr></table></td></tr></table>";								
							}
							else{
								dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;cursor:pointer'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "','D')\" /></div></td></tr><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;cursor:pointer'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "','D')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','D')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no+"' width='45'></td></tr></table></td></tr></table>";
							}
						}
					}
				}
				else if(condition_type == "PARERTH"){
					var imageId = "R"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='41' height='34'/>";

					var tooth_layer = "toothLayer"+tooth_no;
					var imageId = "T"+tooth_no;
					if(dentalchartFormObj.document.getElementById(tooth_layer) == "null" || dentalchartFormObj.document.getElementById(tooth_layer) == null){
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"
					}

					isPartiallyErupted = true;//Added by Sharon Crasta on 7/29/2009 for IN012514
				}
				else if(condition_type == "ERUPTH"){
					var RD_Normal_yn = document.forms[0].RD_Normal_yn.value;
					var imageId = "R"+tooth_no;
					//Added by Sharon Crasta on 10/27/2009 for IN012514
					//Added to count the number of Exfoliated conditions recorded in case of Retained.
					var count_exf = 0;
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					retVal = localTrimString(retVal);
					if(retVal.length > 0 && parseInt(retVal) > 0){ 
						var retVal_arr = retVal.split("##");
						count_exf = retVal_arr[0];			
					}

					//Added by Sharon Crasta on 11/4/2009 for IN015475
					//Added to count the number of Partially ERupted Conditions conditions recorded in case of Retained.
					var count_partially_erupted = 0;
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=PARERTH";
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_partially_erupted = trimString(xmlHttp.responseText);
					retVal_partially_erupted = localTrimString(retVal_partially_erupted);
					if(retVal_partially_erupted.length > 0 && parseInt(retVal_partially_erupted) > 0){ 
						var retVal_partially_erupted_arr = retVal_partially_erupted.split("##");
						count_partially_erupted = retVal_partially_erupted_arr[0];			
					}
					if(count_partially_erupted != 0){
						isPartiallyErupted = true;
					}
					//End
                    //added by parul on 08/01/2010 for super changes(Retained-> partially->implant trmt on permanent tooth->Erupted condition after eruption implant image was coming in place of crown)
					var count_impant = 0;
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&trmt_category_type=IMPLANT";
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_imp = trimString(xmlHttp.responseText);
					retVal_imp = localTrimString(retVal_imp);
					if(retVal_imp.length > 0 && parseInt(retVal_imp) > 0){ 
						var retVal_arr = retVal_imp.split("##");
						count_impant = retVal_arr[0];			
					}//end
					
					
					if(permanent_deciduous_flag == "D" && (mixed_dentition_YN != "Y" || (mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null" || mixed_dent_tooth_no == ""))){ //For Deciduous or MD-P Chart 
						//if(mixed_dent_deciduous_yn == "M" || mixed_dent_deciduous_yn == "R"){
						if(((mixed_dent_deciduous_yn == "M" || mixed_dent_deciduous_yn == "R") && mixed_dentition_YN == "Y") || mixed_dentition_YN == "N"){
							if(tooth_no == "33" || tooth_no == "34"){
								var imageSrc = "../../eOH/images/R3.gif";
							}
							else if(tooth_no == "41" || tooth_no == "42"){
								var imageSrc = "../../eOH/images/R14.gif";
							}
							else if(tooth_no == "43" || tooth_no == "44"){
								var imageSrc = "../../eOH/images/R19.gif";
							}
							else if(tooth_no == "51" || tooth_no == "52"){
								var imageSrc = "../../eOH/images/R30.gif";
							}
							else{
								var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
							}
						}
						else{
							if(permanent_deciduous_flag == "D" && mixed_dentition_YN =="Y"){//commented by parul changed for 16115 on 12/11/2009
								 var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
							}
						}
					}
					else if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){ //For Permanent Tooth no's In MD Chart
						var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
					}
					else{
					
						if(mixed_dent_deciduous_yn == "M" || mixed_dent_deciduous_yn == "R"){
							if(tooth_no == "33" || tooth_no == "34"){
								var imageSrc = "../../eOH/images/R3.gif";
							}
							else if(tooth_no == "41" || tooth_no == "42"){
								var imageSrc = "../../eOH/images/R14.gif";
							}
							else if(tooth_no == "43" || tooth_no == "44"){
								var imageSrc = "../../eOH/images/R19.gif";
							}
							else if(tooth_no == "51" || tooth_no == "52"){
								var imageSrc = "../../eOH/images/R30.gif";
							}
							else{
								var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
							}
						}
						else{
							var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
						}
					}
					//Added by Sharon Crasta on 7/29/2009 for IN012514
					//On Eruption only the root should be erupted in case of already Partially Erupted and root and crown should appear in case of unerupted condition.

					if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D") {
						if(mixed_dent_tooth_no == "" || mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null"){
							if(isPartiallyErupted && count_exf == 1){
								var root_layer = "rootLayer"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"

							}
							else if(isPartiallyErupted && count_exf == 2){//Added by Sharon Crasta on 11/4/2009 for IN015475 --//In case of Supernumerary -> Exfoliate both -> PArtially Erupt-> Caries -> ERupt
								var root_layer = "rootLayer"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>";
							  }
							  else if(count_exf == 2 && mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){//Added by Sridevi Joshi on 02/11/09 for IN015475
								var root_layer = "rootLayer"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"

								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"
							  }
							  else if (count_exf == 1){
								var root_layer = "rootLayer"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"

								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"
							  }
							  else if(isPartiallyErupted){ //Added by Sridevi Joshi on 1/11/2010 for IN010894 Retained-->Erupth on Permanent tooth
								var root_layer = "rootLayer"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"

							  }
						}else{
							if(isPartiallyErupted){
								var root_layer = "rootLayer"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
							}
							else{
								var root_layer = "rootLayer"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"

								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"
							}
						}
					}
					else{  
						if(isPartiallyErupted && count_exf!=0){		
							var root_layer = "rootLayer"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "','NR')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "','NR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"

							if (RD_Normal_yn=="N"){//condition added by parul on 19/11/2009 for IN016389
								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "','NR')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"
							}
						} 
						else if(count_partially_erupted == 1){
							var root_layer = "rootLayer"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "','NR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
							if (count_impant>0){ //added by parul on 08/01/2010 for super changes(Retained-> partially->implant trmt on permanent tooth->Erupted condition after eruption implant image was coming in place of crown)

								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"
							}
						} 
						else{
							var root_layer = "rootLayer"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"

							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"
						}
					}
					isErupted = true;
				}
				else if(condition_type == "EXTRACT"){
					/*var imageId = "T"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownGreen.gif'>";

					var imageId = "R"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen.gif'>";*/
					if(treatments_outcome=="F"){
						 var imageId = "T"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src=' "+image_source+" '>";

						var imageId = "R"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen_EF.gif'>";
					}else{
						var imageId = "T"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src=' "+image_source+" '>";

						var imageId = "R"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen_E.gif'>";
					}
				}
				else if(condition_type == "IMPLANT"){ //Applicable only for Permanent Chart
					var imageId = "T"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img  src=' "+image_source+" '>";

					var imageId = "R"+tooth_no;
					if(treatments_outcome=="F"){
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_root_EF.gif' width='45' height=34'/>";
					}else{
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_root_E.gif' width='45' height=34'/>";						
					}
				}
				else if(condition_type == "DENTURE"){/* starts(marking error on any condition after denture/bridge on same tooth ) by parul */
						var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src=' "+image_source+" '>";
						var imageId = "R"+tooth_no;
						if(treatments_outcome=="F"){
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_root_EF.gif'>";
						}else{
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_root_E.gif'>";
						}
				}
				//Commented and Added by Sharon Crasta on 2/18/2010 for SRR20056-CRF-0475
				/*else if(condition_type == "BRIDGE" && hide_image_yn == "Y"){
					var imageId = "T"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height='25'/>";

					var imageId = "R"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height=34'/>";
				}*/
				else if(condition_type == "BRIDGE" && hide_image_yn == "Y"){
					if(treatments_outcome=="F"){
						var imageId = "T"+tooth_no;
						//Commented and Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868)
						//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height='25'/>";
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_EF.gif' width='45' height='25'/>";
									
						/*var imageId = "R"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height=34'/>";*/

						var imageId = "R"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
					}else{
						var imageId = "T"+tooth_no;
						//Commented and Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868)
						//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height='25'/>";
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_E.gif' width='45' height='25'/>";
									
						/*var imageId = "R"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height=34'/>";*/

						var imageId = "R"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
						
					}
				}
				else if(condition_type == "BRIDGE" && hide_image_yn == "N"){
					if(treatments_outcome=="F"){
						var imageId = "T"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_EF.gif' width='45' height='25'/>";
					}else{
						var imageId = "T"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_E.gif' width='45' height='25'/>";
					}
				} //End
				else if(condition_type == "CROWN" && surface_code == "*A"){//Added by parul on 21/01/2010 for CRF-422
					var imageId = "T"+tooth_no;
					if(permanent_deciduous_flag=="P"){
						if (tooth_no>=1 && tooth_no<=16){
							if(treatments_outcome=="F"){
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownDown_EF.gif' width='45' height='25'/>";
							}else{
							   	dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownDown_E.gif' width='45' height='25'/>";
							}
						}else{
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img width='45' height='25' src=' "+image_source+" '>";
						}
					}else{
						if (tooth_no>=33 && tooth_no<=42){
							if(treatments_outcome=="F"){
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownDown_EF.gif' width='45' height='25'/>";
							}else{
							   	dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownDown_E.gif' width='45' height='25'/>";
							}
						}else{
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img width='45' height='25' src=' "+image_source+" '>";
						}
					}
				}
			}
		}
	}
}


function populateAllConditionTypes(site,flag){
	//selected_tooth_count = 0; // commented on 08/10/07 by sridevi (count was bcoming zero when u select 2 tooth and click on the tooth no(after populating menu) and if u try to select 3 rd tooth count was becoming 0)
	var formObj = document.forms[0];
	var params = "";
	var tab_name = "DC";

	// get the Menu Items
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	params = "func_mode=getMenu&tab_name="+tab_name+"&site="+site;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DentalRules.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText); 
	clearBean();

	
}

function assignFunctionIDList(function_id_list){
	var formObj = document.forms[0];
	formObj.function_id_list.value = function_id_list;
}
function assignFunctionNameList(function_name_list){
	var formObj = document.forms[0];
	formObj.function_name_list.value = function_name_list;
}
function assignFunctionTypeList(function_type_list){
	var formObj = document.forms[0];
	formObj.function_type_list.value = function_type_list;
}
function assignFunctionTypeDescList(function_type_desc_list){
	var formObj = document.forms[0];
	formObj.function_type_desc_list.value = function_type_desc_list;
}
function assignFunctionCatCodeList(function_cat_code_list){
	var formObj = document.forms[0];
	formObj.function_cat_code_list.value = function_cat_code_list;
}

function clearArea(field){
	var formObj = document.forms[0];
	if(field == "conditionType"){ // On Change of Condition Type reset the Area..
		clear_list(formObj.oh_area); 
		optSel	= document.createElement("OPTION");
		optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
		optSel.value= ''; 
		formObj.oh_area.add(optSel);
	}

	formObj.oh_dental_condition.value = "";

	clear_list(formObj.oh_surface); 
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	formObj.oh_surface.add(optSel);

	document.getElementById("MandatorySurface").style.visibility = 'hidden';

	clear_list(formObj.oh_cusp_tip); 
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	formObj.oh_cusp_tip.add(optSel);
}

function clearDentalcondition(obj){
	var formObj = document.forms[0];
	formObj.oh_dental_condition.value = "";
	
	clear_list(formObj.oh_cusp_tip); 
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	formObj.oh_cusp_tip.add(optSel);
	if(formObj.oh_site.value != "THRNG"){
		formObj.thrng_nos_ref.value = obj.value;
	}

}

function checkForRootCrownApplicableConds(mixed_dentition_YN,dentalChartFormObj,tooth_no,site_type){
	if(mixed_dentition_YN == "Y"){
		var root_layer = "rootLayer"+tooth_no;
		var tooth_layer = "toothLayer"+tooth_no;
		if(dentalChartFormObj.document.getElementById(root_layer) == null && site_type == "ROOT"){
			return false;
		}
		else if(dentalChartFormObj.document.getElementById(tooth_layer) == null && site_type == "CROWN"){
			return false;
		}

		return true;
	}
}

function checkForPulpInvCond(site_type,tooth_no,patient_id,chart_num,called_from_viewchart_yn,condition_type,super_tooth_ref,retained_tooth_no){
	if(site_type == "CROWN"){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateConditionForTooth&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		retVal=localTrimString(retVal);
		if(retVal.length > 1){
			var retVal_arr = retVal.split("##")
			if(retVal_arr[0] == "Y" && called_from_viewchart_yn != "Y" && retVal_arr[1] != 'E' && condition_type == "CARIES"){
				alert(getMessage("APP-OH00015",'OH'));
				return false;
			}
		}
	}
	return true;
}

function checkForDuplicateRecord(status,patient_id,chart_num,tooth_no,condition_type,surface_code,site_type){
	if(status != "E"){
		var formObj = document.forms[0];
		var super_yn = "";
		var chart_line = "";
		var retained_tooth_no = "";
		var isSuperYN = "N";
		var isRetainedYN = "N";
		var dental_condition = formObj.oh_dental_condition.value;
		var tooth_numbering_system = formObj.tooth_numbering_system.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var RD_Normal_yn  = document.forms[0].RD_Normal_yn.value;
		var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
		var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
		var chart_line_num = document.forms[0].chart_line_num.value;
		var RD_Normal_yn = document.forms[0].RD_Normal_yn.value;
		var super_tooth_ref=formObj.super_tooth_ref.value;//added by parul for super changes
			if (mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
				   var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					params = "func_mode=SuperRDyn&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_cond = trimString(xmlHttp.responseText); 
					retVal_cond = localTrimString(retVal_cond); 
					var retVal_cond_arr = retVal_cond.split("##");
					var condition_type_ref = retVal_cond_arr[1];
					if(condition_type_ref == "SUPRTH"){
						isSuperYN = "Y";
					}else if(condition_type_ref == "RTDESTH"){
						isRetainedYN = "Y";
					}

					//if (isRetainedYN=="Y" && (super_tooth_ref != "RD" && super_tooth_ref != "s1" && super_tooth_ref != "s2")){
					if (isRetainedYN=="Y" && (super_tooth_ref != "RD" && (super_tooth_ref == "" || super_tooth_ref == "undefined" || super_tooth_ref == undefined))){
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=getMappedToothNo&"+params,false);
						xmlHttp.send(xmlDoc);
						var mapped_tooth_no = trimString(xmlHttp.responseText);
						mapped_tooth_no=localTrimString(mapped_tooth_no);

						var ns_tooth_no = "";
						//To get Display_tooth_no
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+mapped_tooth_no+"&numbering_system="+tooth_numbering_system;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 0){
							retained_tooth_no = retVal;
						}

						retained_tooth_no = mapped_tooth_no;//commented above and Added by Sridevi Joshi on 4/12/2010 for IN020464..retained_tooth_no was going as dissplay tooth no
					}

			   }else{
					if(super_tooth_ref == "RD"){//Added by parul on 12/17/2009 for RTDESTH new changes
					//Added by parul on 12/17/2009 for RTDESTH new changes TO GET mapped tooth no
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getMappedToothNo&tooth_no="+tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						retained_tooth_no = trimString(xmlHttp.responseText); 
						retained_tooth_no = localTrimString(retained_tooth_no); 
					}
			   }
		//added by parul for IN16418 on 27/11/2009

		var xmlDoc = "" ;  
		var xmlHttp = new XMLHttpRequest();
		var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForRTDESTH&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal_Rtdesth = trimString(xmlHttp.responseText);
		retVal_Rtdesth = localTrimString(retVal_Rtdesth); 
		//commented by parul for IN13473 on 11/09/2009(should be able to record duplicate condition on both of super num tooth)
		//var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&condition_type="+condition_type+"&surface_code="+surface_code+"&dental_condition="+dental_condition+"&site_type="+site_type;
		var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&condition_type="+condition_type+"&surface_code="+surface_code+"&dental_condition="+dental_condition+"&site_type="+site_type+"&RD_Normal_yn="+RD_Normal_yn+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&chart_line_num_Rtdesth="+retVal_Rtdesth+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&RD_Normal_yn="+RD_Normal_yn;
          
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForDuplicateRecord&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		retVal=localTrimString(retVal);
		if(retVal.length > 0 && parseInt(retVal) > 0){ //Record Already Present
    		var condition_desc_text = formObj.oh_dental_condition.options[formObj.oh_dental_condition.options.selectedIndex].text;
			var condition_type = formObj.oh_condition_type.value;
			var display_tooth_no_text = formObj.oh_area.options[formObj.oh_area.options.selectedIndex].text;
			//if(condition_type != "IMPACTN"){ //Added by Sridevi on 04/July/08 //commented by Sridevi Joshi on 18/12/2008 to get alert for impaction also
				if(site_type == "ARCH" || site_type == "QUAD"){
					var msg = getMessage("APP-OH00078","OH");
				}
				else{
					var msg = getMessage("APP-OH00075","OH");
				}
				var msg_arr = msg.split("##");
				//Added by SRidevi Joshi on 2/17/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				params = "func_mode=checkSuperKey&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal_SuperKey = trimString(xmlHttp.responseText); 
				retVal_SuperKey = localTrimString(retVal_SuperKey); 
				var retVal_SuperKey_arr = retVal_SuperKey.split("~");
				if(retVal_SuperKey_arr.length > 1){
					for(var d=0;d<retVal_SuperKey_arr.length-1;d++){
						if(retVal_SuperKey_arr[d] == super_tooth_ref){
							display_tooth_no_text = retVal_SuperKey_arr[d]+"["+display_tooth_no_text+"]";
						}
					}
				}
			var surface_ref="";
			  if (surface_ref=="") {		
				for(var m=0;m<formObj.oh_surface.options.length;m++){
					formObj.oh_surface.options[0].selected =false;  
				   if(formObj.oh_surface.options[m].selected==true){
					  if(surface_ref==""){
					  surface_ref=formObj.oh_surface.options[m].value;

					 } else{
					  surface_ref=surface_ref+","+formObj.oh_surface.options[m].value;
					  }
				   }
			   }
			 formObj.surface_ref.value=surface_ref;
		   }else{
			  surface_ref=formObj.oh_surface.value;
		   }

		var Surface_label=getLabel("eOH.Surface.Label","OH");

		 if ((surface_code!="")){
				var retVal_surface_arr2="";
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "surface_code="+surface_ref;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=displaySurfacesDescription&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal_surface = trimString(xmlHttp.responseText);
				retVal_surface = localTrimString(retVal_surface);

				if(retVal_surface.length>1){
					if(retVal_surface.indexOf("~")!=-1){
						var retVal_surface_arr=retVal_surface.replace("~",",");
						var retVal_surface_arr1=retVal_surface_arr.replace("~",",");
						var retVal_surface_arr3=retVal_surface_arr1.replace("~",",");
						var val_surface=retVal_surface_arr3.substring(0,retVal_surface_arr3.length-1);
						 retVal_surface_arr2=val_surface.substring(0,val_surface.lastIndexOf(','));						

					}else{
						retVal_surface_arr2=retVal_surface;
					}
				}
            
				  alert(msg_arr[0]+"'"+condition_desc_text+"'"+msg_arr[1]+display_tooth_no_text+msg_arr[2]+"("+Surface_label+"#"+retVal_surface_arr2+")");

              }else{
				alert(msg_arr[0]+"'"+condition_desc_text+"'"+msg_arr[1]+display_tooth_no_text+msg_arr[2]);
			  }
				return false;
			
				
		}
	}
	return true;
}

//Displaying Image
function callCaptureImage(){
	var formObj=document.forms[0];
	var sno="25";
	var params = "sno="+sno;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","SampleScreenShot_test.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
}

function storeImageClob(){
	var formObj=document.forms[0];
	var params = parent.parent.conditionDentalChartDetails.document.forms[0].ca_params.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DentalChartHistoryBuilding.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
}

async function tempDiagDetail(){
	var url	= "../../eOH/jsp/OHDiagLinkConditionsFrame.jsp?";

	var dialogHeight= "50vh" ;
	var dialogWidth	= "65vw" ;
	var dialogTop ="215";
	var dialogLeft ="29";
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop +"  ;dialogLeft:" + dialogLeft + ";scroll=auto; status:" + status;
	await window.showModalDialog(url,arguments,features);
}

//Added by Sharon Crasta on 1/7/2009 for CRF #0377 to display the remarks field .
 async function showOperRemarks(title,locale){
	var readOnlyYN = "N";
	var remarks = document.forms[0].remarks.value;
	var remarks_hid = document.forms[0].remarks.value;
	//if(locale != 'en'){
		//remarks =escape(remarks);
		remarks = trimString(remarks);
		remarks = encodeURIComponent(remarks);
			
	//}
	var called_from_viewchart_yn = document.forms[0].called_from_viewchart_yn.value;
	var date_diff_flag = document.forms[0].date_diff_flag.value;
	//Commented and Added by Sharon Crasta on 1/11/2010 for IN017822
	//Added chart_disable_from_main as "Y" in order to disable the chart on click of Cancel button of APP-OH000153 message
	var chart_disable_from_main = document.forms[0].chart_disable_from_main.value;

	//if(called_from_viewchart_yn == "Y" || date_diff_flag == "disable"){
	if(called_from_viewchart_yn == "Y" || date_diff_flag == "disable" || chart_disable_from_main == "Y"){
	//End
		readOnlyYN = "Y";
	}else{
		readOnlyYN = "N";
	}
	
	remarks = encodeURIComponent(remarks);
	title = encodeURIComponent(title);
	
	var retVal = await window.showModalDialog("../../eOH/jsp/TextArea.jsp?heading="+title+"&remarks="+remarks+"&readOnlyYN="+readOnlyYN,window,"dialogHeight: 50vh; dialogWidth:65vw; center: yes; help: no; resizable: no; status: no;");
	//retVal = encodeURIComponent(retVal);
	if(retVal == "undefined" || retVal == undefined || retVal == "CL_REM"){ // This when the user closed the TeaxtArea window with above 'X' 
		document.forms[0].remarks.value = remarks_hid;
	}
	else{
		document.forms[0].remarks.value = retVal;
	}

}

//

/*
function retieveHistory(){
	var formObj=document.forms[0];
	var params = formObj.ca_params.value;
	//window.open(url);

	//var params = '&patient_id='+patient_id+'&treatment_condition_tab_flag='+treatment_condition_tab_flag+'&tooth_no='+tooth_no+'&title_desc='+title_desc+"&display_tooth_no="+display_tooth_no+"&called_from_viewchart_yn="+called_from_viewchart_yn+"&chart_num="+chart_num+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN;
	var url	= "../../eOH/jsp/OHHistory.jsp?"+params;
	
	var dialogHeight= "22" ;
	var dialogWidth	= "47" ;
	var dialogTop ="215";
	var dialogLeft ="29";
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop +"  ;dialogLeft:" + dialogLeft + ";scroll=auto; status:" + status;
	window.showModalDialog(url,arguments,features);
	
}
*/


/*function printChart(){
	window = parent.parent.frames[1];
	window.print();
} */

/*function framePrint(frameName){
	frameName.focus();
	frameName.print();
}*/

//Commented by Sharon Crasta on 7/27/2009
//Code written for Print Preview
/* function printOverview(){

	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
//	var trmt_code = formObj.oh_treatment.value;
//	var order_id = formObj.order_id.value;
//	var order_line_num = formObj.order_line_num.value;

	var DentalChartFormObj = parent.parent.conditionDentalChartDetails.document.forms[0];
	var header_tab = DentalChartFormObj.header_tab.value;
	var tooth_numbering_system = DentalChartFormObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = DentalChartFormObj.permanent_deciduous_flag.value;
	var mixed_dentition_YN = DentalChartFormObj.mixed_dentition_YN.value;
	var upper_arch_desc = DentalChartFormObj.upper_arch_desc.value;
	var lower_arch_desc = DentalChartFormObj.lower_arch_desc.value;
	var Q1_id = DentalChartFormObj.Q1_id.value;
	var Q2_id = DentalChartFormObj.Q2_id.value;
	var Q3_id = DentalChartFormObj.Q3_id.value;
	var Q4_id = DentalChartFormObj.Q4_id.value;
	var Q1_desc = DentalChartFormObj.Q1_desc.value;
	var Q2_desc = DentalChartFormObj.Q2_desc.value;
	var Q3_desc = DentalChartFormObj.Q3_desc.value;
	var Q4_desc = DentalChartFormObj.Q4_desc.value;

	var qry_string = "patient_id="+patient_id+"&header_tab="+header_tab+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num;

	var testwindow= window.open ("PrintChart.jsp?"+qry_string, "WindowTitle",
    "location=0,status=0,scrollbars=0,width=800,height=450");
	//testwindow.moveTo(95,100);

}  

function getImageForHistoryDummy(){
	var formObj = document.forms[0];
	var imgDisplay_arch_quad = "";
	var imgDisplay_tooth_thrng = "";
	var crown_concat = ""; // Crown
	var concat = ""; //For Tooth_Range, Tooth
	var concat_val = "";
	var code_desc_arr;
	var concat_cond_val = "";
	var concat_cond_type = "";
	var cond_type = "";
	var rootLineDisplayParams = new Array();
	var root_count = 0;
	var chart_num  = formObj.chart_num.value;
	var patient_id = formObj.patient_id.value;
	//var locale = formObj.locale.value;
	var baseline_chart_yn = "N";
	var status_int = 0;
	var j = 0;
	

	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var treatment_condition_tab_flag = "C";//formObj.header_tab.value;
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_numbering_system="+tooth_numbering_system+"&treatment_condition_tab_flag="+treatment_condition_tab_flag+"&baseline_chart_yn="+baseline_chart_yn;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=getAllImagesForHistory&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText); 
	return retVal;
	
}  

function getStaticImageForHistoryDummy(){
	var formObj = document.forms[0];
	var imgDisplay_arch_quad = "";
	var imgDisplay_tooth_thrng = "";
	var crown_concat = ""; // Crown
	var concat = ""; //For Tooth_Range, Tooth
	var concat_val = "";
	var code_desc_arr;
	var concat_cond_val = "";
	var concat_cond_type = "";
	var cond_type = "";
	var rootLineDisplayParams = new Array();
	var root_count = 0;
	var chart_num  = formObj.chart_num.value;
	var patient_id = formObj.patient_id.value;
	//var locale = formObj.locale.value;
	var baseline_chart_yn = "N";
	var status_int = 0;
	var j = 0;
	

	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	
	//var xmlDoc = "" ;
	//var xmlHttp = new XMLHttpRequest();
	//var treatment_condition_tab_flag = "T";//formObj.header_tab.value;
	//var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_numbering_system="+tooth_numbering_system+"&treatment_condition_tab_flag="+treatment_condition_tab_flag+"&baseline_chart_yn="+baseline_chart_yn;
	//var xmlStr ="<root><SEARCH ";
	//xmlStr +=" /></root>";
	//xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=getAllImagesForHistory&"+params,false);
	//xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText); 
	
	//var retVal = formObj.applyTrmts.value;
	var retVal = getImageForHistoryDummy();
	//retVal = "../../eOH/images/Trauma.gif##3##TOOTH##16##TRUMTH##C##null##N##null~../../eOH/images/Extraction-CrownGreen.gif##5##TOOTH##14##EXTRACT##T##60##N##N~../../eOH/images/Extraction-CrownGreen.gif##11##TOOTH##23##EXTRACT##T##60##N##N~../../eOH/images/Extraction-CrownGreen.gif##13##TOOTH##25##EXTRACT##T##60##N##N~../../eOH/images/Extraction-CrownGreen.gif##25##TOOTH##41##EXTRACT##T##60##N##N~";
	if(retVal.length>1){
		var retVal_arr = retVal.split("~");
		var show_RTDESTH_EXFOLTH_image_flag="";
		var show_SUPRTH_EXFOLTH_image_flag="";
		var image_count=0;
		for(i=retVal_arr.length-2;i>=0;i--){
			code_desc_arr = retVal_arr[i].split("##");
				if(code_desc_arr[4]=="RTDESTH"){ 
					show_RTDESTH_EXFOLTH_image_flag=code_desc_arr[1]+"RTDESTH";
				}else if(code_desc_arr[4]=="EXFOLTH" && show_RTDESTH_EXFOLTH_image_flag!=""){
					show_RTDESTH_EXFOLTH_image_flag=show_RTDESTH_EXFOLTH_image_flag+"EXFOLTH";
				}

				if(code_desc_arr[2] == "TOOTH"){ // Initialuze the flag
					if(show_RTDESTH_EXFOLTH_image_flag.indexOf(code_desc_arr[1]+"RTDESTH")<0){ // Initialuze the flag
						show_RTDESTH_EXFOLTH_image_flag="";
					}
				}
						
				if((code_desc_arr[0]!=null && code_desc_arr[0]!="null") || (code_desc_arr[4] == "TOOTHTM" || code_desc_arr[4] == "EXFOLTH" || code_desc_arr[4] == "MISSTH" || code_desc_arr[4] == "EXTRACT"  || code_desc_arr[4] == "DECITH" || code_desc_arr[4] == "IMPLANT" || code_desc_arr[4] == "RTDESTH" || code_desc_arr[4] == "SUPRTH" || code_desc_arr[4] == "PERIINV" || code_desc_arr[4] == "ERUPTH" || code_desc_arr[4] == "DENTURE")){// image_id will be null for ROOT and CROWN site_types
					var imageId = "";
					var site_type = code_desc_arr[2];
					
					if(site_type == "QUAD"){
						imageId = "Q"+code_desc_arr[1];
					}
					else if(site_type == "ARCH"){
						imageId = "A"+code_desc_arr[1];
					}
					else{
						imageId = code_desc_arr[1];
					}
					status_int = parseInt(code_desc_arr[6]);

					if(status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){ //This is to get the status from OR table with respect to the status is stored in the chart_dtl table..
						var fill_color = "YELLOW";
					}
					else{
						var fill_color = "LIGHTGREEN";
					}
					if(site_type == "ARCH" || site_type == "QUAD" ){

						if(code_desc_arr[4] == "TOOTHTM"){
							if(code_desc_arr[7] != "null"&& code_desc_arr[7] != null){ //code_desc_arr[7]: This is to get the status which is stored in the chart_dtl table..
								if(site_type == "ARCH"){
									var imageId = "COLORA"+code_desc_arr[1];
								}else if(site_type == "QUAD"){
									var imageId = "COLORQ"+code_desc_arr[1];
								}
								document.getElementById(imageId).style.backgroundColor = fill_color;
						   }
						}
						else{
							var ind = concat.indexOf(":");
							if(ind != -1){
								concat_val = concat.split(":");
								for(;j<concat_val.length-1;j++){
									if(concat_val[j] == code_desc_arr[1] && site_type == code_desc_arr[2]){ // For the same area(Q,A,T)
										image_count++;
										status_int = parseInt(code_desc_arr[6]);
										imgDisplay_arch_quad = "<img src='"+code_desc_arr[0]+"'  />" + imgDisplay_arch_quad;
											
										if(image_count >= 4){
											var imgDisplay_arch_quad_arr = imgDisplay_arch_quad.split("<img");
											var imgDisplay_arch_quad_temp = "";
										
											for(k=1;k<=3;k++){
												imgDisplay_arch_quad_temp = imgDisplay_arch_quad_temp+"<img"+imgDisplay_arch_quad_arr[k];
											}
											imgDisplay_arch_quad = imgDisplay_arch_quad_temp + "...";
												
										}
										document.getElementById(imageId).innerHTML = imgDisplay_arch_quad;
										break;
									}
									else{ // For every next set of area
										image_count=1;
										concat = concat + code_desc_arr[1] + ":"  ;
										imgDisplay_arch_quad = "<img src='"+code_desc_arr[0]+"'  />";
										document.getElementById(imageId).innerHTML = imgDisplay_arch_quad;
									}
								}
							}
							else{
								image_count=1;
								concat = code_desc_arr[1] + ":" ;
								imgDisplay_arch_quad = "<img src='"+code_desc_arr[0]+"'  />";
								document.getElementById(imageId).innerHTML = imgDisplay_arch_quad;
							}
						}
					}
					else if(site_type == "TOOTH" || site_type == "THRNG" || (site_type == "ROOT" && code_desc_arr[4]=="PERIINV")){
						if(code_desc_arr[4] == "MISSTH" || code_desc_arr[4] == "UNERTH" || code_desc_arr[4] == "EXFOLTH" || code_desc_arr[4] == "DECITH" || code_desc_arr[4] == "EXTRACT" || code_desc_arr[4] == "DECITH" || code_desc_arr[4] == "IMPLANT" || code_desc_arr[4] == "PARERTH" || code_desc_arr[4] == "RTDESTH" || code_desc_arr[4] == "SUPRTH" || code_desc_arr[4] == "ERUPTH" || code_desc_arr[4] == "IMPACTN" || code_desc_arr[4] == "BRIDGE" || code_desc_arr[4] == "DENTURE"){ //29FEB bshankar
							imageReplaceForHistory(code_desc_arr[4],code_desc_arr[1],code_desc_arr[6],show_RTDESTH_EXFOLTH_image_flag,show_SUPRTH_EXFOLTH_image_flag,code_desc_arr[7],code_desc_arr[8]);
						}
						if(site_type == "ROOT" && code_desc_arr[4]=="PERIINV"){
							drawCircleForRootHistory(code_desc_arr[1],"ALL",formObj,code_desc_arr[4],code_desc_arr[5],code_desc_arr[1],code_desc_arr[6]);
						}
						else if(code_desc_arr[4] != "MISSTH" && code_desc_arr[4] != "EXFOLTH" && code_desc_arr[4] != "DECITH" && code_desc_arr[4] != "EXTRACT" && code_desc_arr[4] != "DECITH" && code_desc_arr[4] != "IMPLANT" && code_desc_arr[4] != "DENTURE" && code_desc_arr[4] != "RTDESTH" && code_desc_arr[4] != "ERUPTH" && code_desc_arr[7] == "N"){

							var ind = concat.indexOf(":");
							if(ind != -1){
								concat_val = concat.split(":");
								for(;j<concat_val.length-1;j++){
									if(concat_val[j] == code_desc_arr[1] && site_type == code_desc_arr[2]){ // For the same area(Q,A,T)
										image_count++;
										status_int = parseInt(code_desc_arr[6]);
											if(code_desc_arr[4] == "TOOTHTM" && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
												code_desc_arr[0] = "../../eOH/images/TRMT_Planned.gif";
											}
											imgDisplay_tooth_thrng = "<img src='"+code_desc_arr[0]+"'  />" + imgDisplay_tooth_thrng;
											
											if(image_count >= 4){
												var imgDisplay_tooth_thrng_arr = imgDisplay_tooth_thrng.split("<img");
												var imgDisplay_tooth_thrng_temp = "";
												
												for(k=1;k<=3;k++){
													imgDisplay_tooth_thrng_temp = imgDisplay_tooth_thrng_temp+"<img"+imgDisplay_tooth_thrng_arr[k];
												}
												imgDisplay_tooth_thrng = imgDisplay_tooth_thrng_temp + "...";
												
											}
											document.getElementById(imageId).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>"+imgDisplay_tooth_thrng+"</td></tr></table>";
										
										break;

									}
									else{ // For every next set of area
										status_int = parseInt(code_desc_arr[6]);

										if(code_desc_arr[4] == "TOOTHTM" && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
											code_desc_arr[0] = "../../eOH/images/TRMT_Planned.gif";
										}
										image_count=1;
										concat = concat + code_desc_arr[1] + ":"  ;
										imgDisplay_tooth_thrng = "<img src='"+code_desc_arr[0]+"' />";
										
										document.getElementById(imageId).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' >"+imgDisplay_tooth_thrng+"</td></tr></table>";
									}
								}
							}
							else{
								image_count=1;
								concat = code_desc_arr[1] + ":" ;
								status_int = parseInt(code_desc_arr[6]);

								if(code_desc_arr[4] == "TOOTHTM" && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
									code_desc_arr[0] = "../../eOH/images/TRMT_Planned.gif";
								}
								imgDisplay_tooth_thrng = "<img src='"+code_desc_arr[0]+"'  />";
								document.getElementById(imageId).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td width='45'>"+imgDisplay_tooth_thrng+"</td></tr></table>";
							}	
						}
					}
					else if(site_type == "CROWN"){
						var ind_crown = crown_concat.indexOf(":");
						if(ind_crown != -1){
							concat_val = crown_concat.split(":");
							concat_cond_val = concat_cond_type.split(":");
							for(m=0;m<concat_val.length-1;m++){
								if(concat_val[m] == code_desc_arr[0]){ // For the same area(Q,A,T)
									if(code_desc_arr[3] != "" && concat_cond_val[m] != "" && concat_cond_val[m] == "PULPINV" && code_desc_arr[4] != "PULPINV"){
										cond_type = "PULPINV";
									}
									else{
										cond_type = code_desc_arr[4];
									}
									fillCrownImagesForHistory("toothLayer"+code_desc_arr[0],code_desc_arr[3],formObj,cond_type,code_desc_arr[6],code_desc_arr[0],permanent_deciduous_flag);
								}
								else{
									crown_concat = crown_concat + code_desc_arr[0] + ":"  ;
									concat_cond_type = concat_cond_type + code_desc_arr[4] + ":"  ;
									fillCrownImagesForHistory("toothLayer"+code_desc_arr[0],code_desc_arr[3],formObj,code_desc_arr[4],code_desc_arr[6],code_desc_arr[0],permanent_deciduous_flag);
								}
							}
						}
						else{
							crown_concat = code_desc_arr[0] + ":"  ;
							concat_cond_type = code_desc_arr[4] + ":"  ;
							fillCrownImagesForHistory("toothLayer"+code_desc_arr[0],code_desc_arr[3],formObj,code_desc_arr[4],code_desc_arr[6],code_desc_arr[0],permanent_deciduous_flag);					
						}
					}else if(site_type == "ROOT" && code_desc_arr[4]!="PERIINV"){
						root_count = parseInt(root_count);
						root_count++;
						
						rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[8]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6];
					}
				}
				else{
					var site_type = code_desc_arr[2];
					if(site_type == "ROOT" && code_desc_arr[4]!="PERIINV"){
						root_count = parseInt(root_count);
						root_count++;
						rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[8]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6];
					}
				}
		}
		if(root_count >0){	
			for(j=1;j<=root_count;j++){				
				var params_arr = rootLineDisplayParams[j].split("##");
				drawLineForRootImage(params_arr[0],params_arr[1],formObj,params_arr[3],params_arr[4],params_arr[5],params_arr[6]);
			}				
		}			
	}
	return retVal;
	
	
}
*/
//End here

