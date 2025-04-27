var area_legend;
var tab_name = "ET";
var isMrkErrorYN = 'N';
var isPartiallyErupted = false;
var isErupted = false;

//function setValuesFromMenu(type,site,code,arch_quad,thrng_nos,ref_tooth_no,tooth_numbering_system,permanent_deciduous_flag,performed_date,status,trmt_location,outcome,surface,flag,cusp_tip_code){

function setValuesFromMenu(type,site,code,arch_quad,thrng_nos,ref_tooth_no,tooth_numbering_system,permanent_deciduous_flag,performed_date,status,trmt_location,outcome,surface,flag,cusp_tip_code,maxila_area,maxila_parts,maxila_sub_parts,failure_remarks){
	var formObj = document.forms[0];
	var disply_tooth_no="";
	formObj.oh_category.value = type;
	var mixed_dentition_YN=formObj.mixed_dentition_YN.value;
	var super_tooth_ref = formObj.super_tooth_ref.value;
	//populateConditionCode(formObj.oh_category)

	if(formObj.oh_category.value != "" && formObj.oh_category.value != "undefined" && formObj.oh_category.value != undefined){ //Added by Sridevi Joshi on 4/26/2010 for PE..treatment has to be populated only when oh_category value is not null
		populateTreatments(formObj.oh_category);
	}

	if(code != null && code != "null" && code != "" && code != "undefined"){
		formObj.oh_treatment.value = code;
	}
	
	if(formObj.oh_category.value != "" && formObj.oh_category.value != "undefined" && formObj.oh_category.value != undefined){ //Added by Sridevi Joshi on 4/26/2010 for PE..site type has to be populated only when oh_category value is not null														
		populateConditionCode(formObj.oh_category,formObj.oh_treatment)//Added by Sridevi Joshi on 2/10/2010 for IN010871(SRR20056-CRF-0478)
	}

	if(formObj.oh_category.value != "" && formObj.oh_category.value != "undefined" && formObj.oh_category.value != undefined){ //Added by Sridevi Joshi on 4/26/2010 for PE..site type has to be populated only when oh_category value is not null
		populateSiteOptions(formObj.oh_category);
	}

	formObj.oh_site.value = site;
	
	

	getAreaLegend(formObj.oh_site,thrng_nos);
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
	else if(formObj.oh_site.value == "THRNG"){
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

		//These values for the hidden variables
		formObj.area.value = ref_tooth_no;
	}
	if(MD_area != ""){
		formObj.oh_area.value = MD_area;
		//formObj.oh_area.value = thrng_nos

		//These values for the hidden variables
		formObj.area.value = MD_area;
	}
	
	if(formObj.oh_site.value == "MAXFS"){//added by parul for CRF 701 on 23/09/2009
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


	if(formObj.oh_area.value != "" && formObj.oh_area.value != "undefined" && formObj.oh_area.value != undefined){ //Added by Sridevi Joshi on 4/26/2010 for PE..Surface has to be populated only when area value is not null
		populateSurfaces(formObj.oh_area);
	}

	enableDisableSurface(formObj.oh_site);

	if(formObj.oh_surface.value != "" && formObj.oh_surface.value != "undefined" && formObj.oh_surface.value != undefined){ //Added by Sridevi Joshi on 4/26/2010 for PE..Cusptip has to be populated only when surface value is not null
		populateCuspTip(formObj.oh_surface);
	}

	formObj.oh_cusp_tip.value = cusp_tip_code;
	enableDisableCuspTip(formObj.oh_site);

	//These values for the hidden variables
	formObj.category.value = type;
	formObj.site.value = site;
	if(code != null && code != "null" && code != "" && code != "undefined"){
		formObj.treatment.value = code;
	}
	else{
		formObj.treatment.value = formObj.oh_treatment.value;
	}

	// This is the flag to find out the Retained Deciduous condition....
	formObj.RD_Normal_yn.value = flag;

	if(formObj.oh_category.value != "" && formObj.oh_category.value != null){
		formObj.oh_category.disabled = true;
		formObj.oh_area.disabled = true;
		formObj.oh_site.disabled = true;
		if(code != null && code != "null" && code != "" && code != "undefined"){
			formObj.oh_treatment.disabled = true;
		}
	}


	if(formObj.called_from_viewchart_yn.value == 'Y'){
		
		if(formObj.oh_site.value == "MAXFS"){//added by parul for CRF 701 on 23/09/2009
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
		}

       //formObj.oh_surface.value = surface;
	  //added by parul for CRF#0442 on 27/01/2010
		if (surface=="*A"){
			var retVal_surface=getLabel("eOH.AllSurfaces.Label","OH");
			document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" ><option value="">'+retVal_surface+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';
			
		}else{
			
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
						var retVal_surface_arr2=val_surface.substring(0,val_surface.lastIndexOf(','));
					//	document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" value=""><option value="">'+retVal_surface_arr2+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';

						document.getElementById("surface_field").innerHTML="<input type='text' name='oh_surface' id='oh_surface'  value='"+retVal_surface_arr2+"'><img id='MandatorySurface'  src='../../eCommon/images/mandatory.gif'>";

					
					}else{

						document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" value=""><option value="">'+retVal_surface+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';
					}
				}
			}
			//end
     
	 if(cusp_tip_code != "" && cusp_tip_code != "undefined" && cusp_tip_code != undefined){ //Added by Sridevi Joshi on 4/26/2010 for PE ---cusp tip has to be displyed only when cusp_tip_code is not null
	//added by parul for CRF#0483 on 24/08/2009
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
				document.getElementById("cusp_field").innerHTML="<input type='text' name='oh_cusp_tip' id='oh_cusp_tip'  size='40' value='"+retVal_arr2+"'>";
			
			}else{
				document.getElementById("cusp_field").innerHTML="<input type='text' name='oh_cusp_tip' id='oh_cusp_tip' maxlength='1' value='"+retVal+"'>";				
			}
		}
	 }
		
		
		formObj.oh_performed_date.value = performed_date;
		formObj.oh_location.value = trmt_location;
	//	formObj.oh_surface.value = surface;
		formObj.oh_outcome.value = outcome;
		if (outcome=="F"){
			formObj.oh_outcome.disabled=true;
			//added by parul on 28/02/2010 for CRF-477
			document.getElementById("reason_field").style.visibility = 'visible';
			document.getElementById("change_reason").style.visibility = 'visible'; 
			document.getElementById("reason_field").innerHTML="<textarea name='oh_failure' rows='3' cols='50' >"+failure_remarks+"</textarea>";
			formObj.oh_failure.readOnly = true;
		}
		formObj.oh_status.value = formObj.ext_trmt_status.value;

		formObj.oh_category.disabled = true;
		formObj.oh_area.disabled = true;
		formObj.oh_site.disabled = true;
		formObj.oh_treatment.disabled = true;
		formObj.oh_surface.disabled = true;
		formObj.oh_location.readOnly = true;
		formObj.oh_performed_date.disabled = true;
		//formObj.oh_cusp_tip.disabled = true;
		formObj.oh_cusp_tip.readOnly = true;
	}
	/*
	if(type == "MAXILLA" || type=="ORALCVT" || type=="PERIO" || type=="OTHERS"){
		document.getElementById("MandatoryRemarks").style.visibility = 'visible';
	}
	else{
		document.getElementById("MandatoryRemarks").style.visibility = 'hidden';
	}*/
	var mand_area = formObj.area.value;
	//Added by Sridevi Joshi for IN014258 ---- to make Remarks for some of the trmts mandatory.It was coming when selected from dataentry but not from menu
	checkForMaxilla(formObj.oh_category,mand_area); //mand_area added by Sridevi Joshi on 10/29/2009 for IN015842

	//Remove mandatory image when called from RHS menu
	if(type == "OTHERS" && formObj.called_from_viewchart_yn.value == 'Y'){ // For Trmt type OTHERS 
		if(document.getElementById("AreaMandatory")!=null){
			document.getElementById("AreaMandatory").style.visibility = 'hidden';
		}
	}
}
//commented by parul on 260908..added condition for disabling surface 
/*function enableDisableSurface(obj){
	if(obj.value != null ){
		if(obj.value == 'ROOT' || obj.value == 'CROWN'){
			document.forms[0].oh_surface.disabled = false;
		}
		else{
			//document.forms[0].oh_surface.value = 'AS';
			document.forms[0].oh_surface.disabled = true;
		}
	}
}*/

function enableDisableSurface(obj){
	var formObj = document.forms[0];
	var oh_category = formObj.oh_category.value;
	if(obj.value != null ){
		if(obj.value == 'ROOT' || obj.value == 'CROWN'){
			//if condition added by parul for surface on 260908
           if(oh_category == "ROOTTMT" ){
			    if (document.forms[0].oh_surface.options.length==1) {
					formObj.oh_surface.disabled = true;
					document.getElementById("MandatorySurface").style.visibility = 'hidden';
			}
		}
			else{
				formObj.oh_surface.disabled = false;
				document.getElementById("MandatorySurface").style.visibility = 'visible';
			}
		}else{
			document.forms[0].oh_surface.disabled = true;
		}
	}
}

function checkForMaxilla(obj,MD_area){//MD_area added by Sridevi Joshi on 10/29/2009 for IN015842
	if((obj.value=="ORALCVT" || obj.value=="PERIO") && MD_area != ""){//MD_area added by Sridevi Joshi on 10/29/2009 for IN015842
		if(document.getElementById("AreaMandatory") != null){
			document.getElementById("AreaMandatory").style.visibility = 'visible';
		}
	}
	
	if(MD_area != ""){//Added by Sridevi Joshi on 10/29/2009 for IN015842
		if(document.getElementById("AreaMandatory") != null){
			document.getElementById("AreaMandatory").style.visibility = 'visible';
		}
	}
	else{//Added by Sridevi Joshi on 10/29/2009 for IN015842
		if(document.getElementById("AreaMandatory") != null){
			document.getElementById("AreaMandatory").style.visibility = 'hidden';
		}
	}

	if(obj.value == "MAXILLA" || obj.value=="ORALCVT" || obj.value=="PERIO" || obj.value=="OTHERS"){
        var ext_trmt_status= document.forms[0].ext_trmt_status.value;
		
		if (ext_trmt_status=="E"){
			var remarks_title = getLabel("Common.remarks.label","Common");
			document.getElementById("maxillaTrmt").innerHTML ="<a href=\"javascript:showOperRemarks('"+remarks_title+"')\">"+remarks_title+"</a><IMG id='MandatoryRemarks' style='visibility:hidden' name='MandatoryRemarks' border='0' src='../../eCommon/images/mandatory.gif'>";
			document.getElementById("MandatoryRemarks").style.visibility = 'visible';
		}else{
			document.getElementById("MandatoryRemarks").style.visibility = 'visible';
		}
	}else{
		document.getElementById("MandatoryRemarks").style.visibility = 'hidden';

	}
}

async function showOperRemarks(title,remarks){
	var readOnlyYN = "N";
	var remarks = document.forms[0].remarks.value;
	var remarks_hid = document.forms[0].remarks.value;
	//Added by Sharon Crasta on 1/15/2009 for CRF #0377 to pass the encoded remarks to textarea.jsp
	remarks = trimString(remarks);
	remarks = encodeURIComponent(remarks);
	//
	var called_from_viewchart_yn = document.forms[0].called_from_viewchart_yn.value;
	
	readOnlyYN = "N";
	
	//Added by Sharon Crasta on 1/11/2010 for IN017822
	//Added chart_disable_from_main as "Y" in order to disable the chart on click of Cancel button of APP-OH000153 message
	var chart_disable_from_main = document.forms[0].chart_disable_from_main.value;

	if(called_from_viewchart_yn == "Y" || chart_disable_from_main == "Y"){
		readOnlyYN = "Y";
	} //End

	title = encodeURIComponent(title);
	//Added by Sharon Crasta on 1/15/2009 for CRF #0377 to pass the encoded remarks to textarea.jsp
	remarks = trimString(remarks);
	//
	remarks = encodeURIComponent(remarks);
	      
	var retVal =await window.showModalDialog("../../eOH/jsp/TextArea.jsp?heading="+title+"&remarks="+remarks+"&readOnlyYN="+readOnlyYN,window,"dialogHeight: 55vh; dialogWidth:65vw; center: yes; help: no; resizable: no; status: no;");
	//Commented by Sharon Crasta on 1/15/2009 for CRF #0377 to insert the special characters without encoding.
	//retVal = encodeURIComponent(retVal);
	//
	if(retVal == "undefined" || retVal == undefined || retVal == "CL_REM"){  // This when the user closed the TeaxtArea window with above 'X' 
		document.forms[0].remarks.value = remarks_hid;
	}
	else{
		document.forms[0].remarks.value = retVal;
	}
} 

/*
function showReasonForCancel(title){
	var reasonforcancel = document.forms[0].reasonforcancel.value;
	var remarks_hid = document.forms[0].reasonforcancel.value;

	title = encodeURIComponent(title);
	reasonforcancel = encodeURIComponent(reasonforcancel);

	var retVal = window.showModalDialog('../../eOH/jsp/TextArea.jsp?heading='+title+'&remarks='+reasonforcancel+'&readOnlyYN=N',window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
	retVal = encodeURIComponent(retVal);

	if(retVal == "undefined" || retVal == "CL_REM"){ // This when the user closed the TeaxtArea window with above 'X' 
		document.forms[0].reasonforcancel.value = remarks_hid;
	}
	else{
		document.forms[0].reasonforcancel.value = retVal;
	}
}*/

async function showReasonForCancel(title){
	var reasonforcancel = document.forms[0].reasonforcancel.value;
	var remarks_hid = document.forms[0].reasonforcancel.value;

	title = encodeURIComponent(title);
	reasonforcancel = encodeURIComponent(reasonforcancel);

	var retVal = await window.showModalDialog('../../eOH/jsp/TextArea.jsp?heading='+title+'&remarks='+reasonforcancel+'&readOnlyYN=N',window,"dialogHeight: 55vh; dialogWidth:65vw; center: yes; help: no; resizable: no; status: no;");
	retVal = encodeURIComponent(retVal);
	var retVal1 = decodeURIComponent(retVal);

	retVal1 = trimString(retVal1);

	if( retVal1 == "undefined" || retVal1 == "CL_REM" || retVal1 == "" || retVal1 == undefined || retVal == ""){ // This when the user closed the TeaxtArea window with above 'X' 
		document.forms[0].reasonforcancel.value = remarks_hid;
	}
	else{
		document.forms[0].reasonforcancel.value = retVal;
		
	}
}

function populateSiteOptions(obj){
	if(obj.value != ""){ // This to clear the message frame when u are recording fresh condition..
		var messageFrame = parent.parent.parent.parent.parent.messageFrame;
		messageFrame.location.href="../../eCommon/jsp/error.jsp" ;
	}
	if(obj.value == "OTHERS"){ // For Trmt type OTHERS 
		if(document.getElementById("AreaMandatory")!=null){
			document.getElementById("AreaMandatory").style.visibility = 'hidden';
		}
		document.getElementById("SiteMandatory").style.visibility = 'hidden';
	}
	clear_list(document.forms[0].oh_site); 
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_site.add(optSel);
	if(document.forms[0].oh_area!=null){
		clear_list(document.forms[0].oh_area); 
		optSel	= document.createElement("OPTION");
		optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
		optSel.value= ''; 
		document.forms[0].oh_area.add(optSel);

		//To clear thrng_nos_ref once the trmt category is changes
		document.forms[0].thrng_nos_ref.value = "";
	}
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
		document.getElementById("SiteMandatory").style.visibility = 'visible';
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

function populateSurfaces(obj){
    var formObj = document.forms[0];
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var site_type_val = formObj.oh_site.value;
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var tooth_no_val = obj.value;
	var trmt_code = formObj.oh_treatment.value;
	var dentalchartFormObj = parent.parent.conditionDentalChartDetails;
	var tooth_layer = "toothLayer"+tooth_no_val;
	var root_layer = "rootLayer"+tooth_no_val;
	var surface_applicable_yn = 'Y';

	//Commented by Sridevi Joshi on 2/19/2010 for IN019472
	/*if(site_type_val == "CROWN"){
		if(dentalchartFormObj.document.getElementById(tooth_layer) == null || dentalchartFormObj.document.getElementById(tooth_layer) == "" || dentalchartFormObj.document.getElementById(tooth_layer) == "null" || dentalchartFormObj.document.getElementById(tooth_layer) == "undefined"){
			surface_applicable_yn = "N";
		}
	}
	else if(site_type_val == "ROOT"){
		if(dentalchartFormObj.document.getElementById(root_layer) == null || dentalchartFormObj.document.getElementById(root_layer) == "" || dentalchartFormObj.document.getElementById(root_layer) == "null" || dentalchartFormObj.document.getElementById(root_layer) == "undefined"){
			surface_applicable_yn = "N";
		}
	}*/

	//By Sridevi Joshi for IN009202(SRR20056-CRF-0454-OH) on 04/08/09.....To Remove surfaces from the list box when Deciduous tooth EXFOLTH and Permanent tooth ERUPTH.Applicable only for tooth 33,34,41,42,43,44,51,52 
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
	}


	clear_list(document.forms[0].oh_surface); 
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_surface.add(optSel);
	var surface_label=getLabel("eOH.DefaultSelect.Label","OH");
	var retVal="";
	var retVal_applicable="";
	if(surface_applicable_yn=="Y"){
		if(trmt_code != "" && trmt_code != "undefined" && trmt_code != undefined && trmt_code != null && trmt_code != "null"){//Added by Sridevi Joshi on 4/26/2010 for PE
			//added by parul on 20/01/2010 for CRF-422 
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params_trmt = "trmt_code="+trmt_code;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkCrownApplicable&"+params_trmt,false);
			xmlHttp.send(xmlDoc);
			retVal_applicable = trimString(xmlHttp.responseText);
			retVal_applicable = localTrimString(retVal_applicable);
		}

		if (retVal_applicable=="Y"){	
			var retVal_surface=getLabel("eOH.AllSurfaces.Label","OH");
			document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" ><option value="">'+retVal_surface+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';
			formObj.surface_ref.value="*A";
			formObj.oh_surface_hid.value="*A";//Added by Sridevi Joshi on 8/20/2010 for IN023363
			populateCuspTip();
			formObj.oh_surface.disabled = true;
		}else{
			if (trmt_code!=""){
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
					var surface_label=getLabel("eOH.DefaultSelect.Label","OH");
					document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" size=3 multiple  onChange="populateCuspTip(this)"><option value="">'+surface_label+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "site_type_val="+site_type_val+"&tooth_no_val="+formObj.oh_area.value;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateSurfaces&"+params,false);
					xmlHttp.send(xmlDoc);
					retVal = trimString(xmlHttp.responseText);
					tooth_layer = "toothLayer"+formObj.oh_area.value;

					if(retVal.length>1){
						 if (site_type_val=="CROWN"){
							document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" size=3 multiple  onChange="populateCuspTip(this)"><option value="">'+surface_label+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';

						}else{
							document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" onChange="populateCuspTip(this)"><option value="">'+surface_label+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';	
						}
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
                        
						 document.getElementById("cusp_field").innerHTML ='<select name="oh_cusp_tip" id="oh_cusp_tip" size=3 multiple ><option value="">'+surface_label+'</option></select>';
					}else{
						if (site_type_val=="CROWN"){
							document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" size=3 multiple  onChange="populateCuspTip(this)"><option value="">'+surface_label+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';	
							document.getElementById("cusp_field").innerHTML ='<select name="oh_cusp_tip" id="oh_cusp_tip" size=3 multiple ><option value="">'+surface_label+'</option></select>';

						}else{
							document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" onChange="populateCuspTip(this)"><option value="">'+surface_label+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';

							document.getElementById("cusp_field").innerHTML ='<select name="oh_cusp_tip" id="oh_cusp_tip" size=3 multiple ><option value="">'+surface_label+'</option></select>';
							formObj.oh_surface.disabled = true;
							formObj.oh_cusp_tip.disabled = true;

						}
						document.getElementById("MandatorySurface").style.visibility = 'hidden';
					}
				}
				
			}else{
				 if (site_type_val=="CROWN"){
						document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" size=3 multiple  onChange="populateCuspTip(this)"><option value="">'+surface_label+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';	
						
				}else{
					document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" onChange="populateCuspTip(this)"><option value="">'+surface_label+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';	
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
			}
		}
	}else{
		formObj.oh_surface.disabled = true;// written by parul on 070109 if there is no value in surface than it should be disable
		document.getElementById("MandatorySurface").style.visibility = 'hidden';	
	}
}





function populateTreatments(obj){
	clear_list(document.forms[0].oh_treatment); 
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_treatment.add(optSel);
	var category_val = obj.value;	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "category_val="+category_val;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateTreatments&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal.length>1){
		var retVal_arr = retVal.split("~");
		for(var i=0;i<retVal_arr.length-1;i++){
			var code_desc_arr = retVal_arr[i].split("##");
			var element 	= document.createElement('OPTION');
			element.value 	= code_desc_arr[0];
			element.text 	= code_desc_arr[1] ;
			document.forms[0].oh_treatment.add(element);
		}
	}
}

function populateConditionCode(obj,obj1){
	var trmt_category_type = obj.value;
	var trmt_code = obj1.value; //Added by Sridevi Joshi on 2/10/2010 for IN010871(SRR20056-CRF-0478)

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "condition_type="+trmt_category_type+"&trmt_code="+trmt_code;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateConditionCode&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	retVal = localTrimString(retVal);

	if(retVal.length>1){
		if(document.forms[0].cat_code != "null" && document.forms[0].cat_code != null){
			document.forms[0].cat_code.value = retVal;
			
		}
	}
	return retVal;
}

async function actionToServlet(){
	var tooth_num = "";
	var tooth_name = "";
	var mapped_tooth_no = "";
	var retained_tooth_no = "";
	var exfolth_count = 0;
	var retVal_SuperKey_count=0;
	var total_SuperKey_count=0;
	var super_recorded = "N";
	var check_cat_type = ""; //Added by Sridevi Jsohi on 2/12/2010 for IN010871(SRR20056-CRF-0478)
	var diff_den_tooth = "N";//Added by Sridevi Jsohi on 2/12/2010 for IN010871(SRR20056-CRF-0478)
	var failure_yn = "N";//Added by Sridevi Jsohi on 2/12/2010 for IN010871(SRR20056-CRF-0478)

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

	var tooth_no ;
	var formObj=document.forms[0];
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var numbering_system = formObj.tooth_numbering_system.value;
	var patient_id = formObj.patient_id.value;
	var site_type = formObj.oh_site.value;
	var status = formObj.oh_status.value;
	var trmt_category_type = formObj.oh_category.value;
	var remarks = formObj.remarks.value;
	var surface = formObj.oh_surface.value;
	var chart_num = formObj.chart_num.value;
	var RD_Normal_yn=formObj.RD_Normal_yn.value;
	
	var surface_code = formObj.oh_surface.value;
	var dentalChartFormObj = parent.parent.conditionDentalChartDetails;
	var thrng_nos_ref = formObj.thrng_nos_ref.value;
	var clinical_group_code = parent.f_query_add_mod_middle.document.forms[0].oh_clinical_group.value;
	var called_from_viewchart_yn=formObj.called_from_viewchart_yn.value;
	var chart_line_num = formObj.chart_line_num.value;
	formObj.clinical_group_code.value = clinical_group_code;
	formObj.category.value = formObj.oh_category.value;
	formObj.site.value = formObj.oh_site.value;
	formObj.area.value = formObj.oh_area.value;
	formObj.treatment.value = formObj.oh_treatment.value;
	var treatment_category_type = formObj.oh_category.value;
	//added by parul on 23/08/2009 for CRF#483
	var oh_cusp_tip = formObj.oh_cusp_tip.value;
	var cusptip_ref = formObj.cusptip_ref.value;
	//added by parul for CRF-477&496 on 09/02/2010
	var treatments_outcome = formObj.oh_outcome.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var trmt_category_code = formObj.cat_code.value;//Added by Sridevi joshi on 2/11/2010 for IN010871(SRR20056-CRF-0478)
	var trmt_code = formObj.oh_treatment.value;//Added by Sridevi joshi on 2/11/2010 for IN010871(SRR20056-CRF-0478)

	var surface_ref = formObj.surface_ref.value;
	var super_tooth_ref = formObj.super_tooth_ref.value; //Added By Sridevi Joshi on 12/7/2009 for SUPRTH new Changes
	var return_surface_alert=false;
     if (treatments_outcome=="F") {
		 var oh_failure=formObj.oh_failure.value;
     }
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

	// This is to validate the Performed date field
	var locale = formObj.locale.value;
	if(!checkDateNotLessSysDate(formObj.oh_performed_date,locale)){
		return;
	}

	if(site_type == "THRNG" && thrng_nos_ref != ""){
		//Added by Sharon Crasta on 11/3/2009 for reopen IN015725
		if(formObj.oh_area.value == ""){ 
			formObj.oh_area.options[0].selected =false; //added by parul for reopen 15725 on 03/11/2009
		}
	
		tooth_no = formObj.thrng_nos_ref.value;
		
	}
	else if(site_type == "THRNG" && thrng_nos_ref == ""){
		for (var m=0;m<formObj.oh_area.options.length; m++) {
			formObj.oh_area.options[0].selected =false;// unselecting   --select---  for 15725
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

	if (site_type == "MAXFS"){
		if(formObj.oh_sub_parts.value=="TNGAB" || formObj.oh_sub_parts.value=="TNGGM" || formObj.oh_sub_parts.value=="TNGAG" || formObj.oh_sub_parts.value=="TNGGAM" || formObj.oh_sub_parts.value=="TNGMF"){
			if(formObj.oh_selected_sub_parts.value == ""){ 
				formObj.oh_selected_sub_parts.options[0].selected =false;
			}

			if(thrng_nos_ref=="") {		
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
			}else{
				tooth_no = formObj.oh_selected_sub_parts.value;
			}
		}
		else{//Added by Sridevi Joshi on 4/5/2010 for IN020465 to get the tooth_no for tooth for Maxilla Treatment .tooth_no was coming as subparts
			if(formObj.oh_selected_sub_parts != null && formObj.oh_selected_sub_parts != "null"){//Added by Sridevi Joshi on 4/6/2010.. Was not able to record Maxilla for other than tooth and tooth range 
				tooth_no = formObj.oh_selected_sub_parts.value;
			}
		}
	}

	if(called_from_viewchart_yn == "Y"){
		surface_code = formObj.surface_hid.value;  //Surface from RHS menu
		status = formObj.oh_status.value;
		cusptip_ref = formObj.cusp_tip_code_hid.value;//cusp tip  from RHS menu
		surface_ref = formObj.surface_hid.value;//Surface from RHS menu

		//var sub_parts = formObj.sub_parts.value;

		//sub_parts = formObj.surface_hid.value;
	}
	//added by parul for SRR-CRF20056-0442 on 19/01/2010
		//surface_ref="";//Commented this by Sridevi Joshi on 8/30/2010 for IN023363
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
	   }//end

	//written by parul for multiple cusp tip CRF#0483 on 23/08/2009
	if (cusptip_ref==""){	
		for(var m=0;m<formObj.oh_cusp_tip.options.length;m++){
			formObj.oh_cusp_tip.options[0].selected =false;  // unselecting   --select---  for 15725
		   if(formObj.oh_cusp_tip.options[m].selected==true){
			  if(cusptip_ref==""){
			  cusptip_ref=formObj.oh_cusp_tip.options[m].value;

			 } else{
			  cusptip_ref=cusptip_ref+","+formObj.oh_cusp_tip.options[m].value;
			 
			  }
		   }
		}
		formObj.cusptip_ref.value=cusptip_ref;
	}
	else{
	  cusptip_ref=formObj.oh_cusp_tip.value;

	  if(cusptip_ref=="" || cusptip_ref==null || cusptip_ref=="null"){
		   cusptip_ref=formObj.cusp_tip_code_hid.value;
	  }
	  if(formObj.called_from_viewchart_yn.value=="Y") {//added by parul 14726 
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_line_num="+chart_line_num+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num;;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=displayCuspTipName&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = localTrimString(xmlHttp.responseText);
		cusptip_ref=retVal;
	  }
	}

	var messageFrame = parent.parent.parent.parent.parent.messageFrame;

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
		var category_title=getLabel("Common.category1.label","Common");
		var site_title = getLabel("Common.Site.label","Common");
		var area_title = area_legend;
		var status_title = getLabel("Common.status.label","Common");
		var treatment_title = getLabel("Common.Treatment.label","Common");
		var location_title = getLabel("Common.Location.label","Common");
		var surface_title = getLabel("eOH.Surface.Label","OH");
		var performed_date_title = getLabel("Common.PerformedDate.label","Common");
		var outcome_title = getLabel("Common.outcome.label","Common");
		var remarks_title = getLabel("Common.remarks.label","Common");
		var cancel_reason_title = getLabel("eOR.CancelReason.label","OR");
		var parts_title = getLabel("eOH.Parts.Label","OH");
		var failure_title = getLabel("eOH.FailureReason.Label","OH");

		if(trmt_category_type == "OTHERS" && status != "E" ){
			if(formObj.oh_outcome.value=="F"){
				var fields = new Array (formObj.oh_category,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome,formObj.remarks,formObj.oh_failure);
				var names = new Array ( category_title,status_title,treatment_title,location_title,performed_date_title,outcome_title,remarks_title,failure_title);
			
			}else{
				var fields = new Array (formObj.oh_category,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome,formObj.remarks);
				var names = new Array ( category_title,status_title,treatment_title,location_title,performed_date_title,outcome_title,remarks_title);
			}
		}
		else if(trmt_category_type == "OTHERS" && status == "E" ){
			var fields = new Array (formObj.oh_category,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome,formObj.reasonforcancel);
			var names = new Array ( category_title,status_title,treatment_title,location_title,performed_date_title,outcome_title,cancel_reason_title);
		}
		else if(trmt_category_type == "ORALCVT" && site_type=="MOUTH" && status != "E"){
			if(formObj.oh_outcome.value=="F"){
				var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome,formObj.remarks,formObj.oh_failure);
				var names = new Array ( category_title,site_title,status_title,treatment_title,location_title,performed_date_title,outcome_title,remarks_title,failure_title);
			
			}else{
				var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome,formObj.remarks);
				var names = new Array ( category_title,site_title,status_title,treatment_title,location_title,performed_date_title,outcome_title,remarks_title);
			}
		}
		else if(trmt_category_type == "ORALCVT" && site_type=="MOUTH" && status == "E"){
			var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome,formObj.reasonforcancel);
			var names = new Array ( category_title,site_title,status_title,treatment_title,location_title,performed_date_title,outcome_title,cancel_reason_title);
		}
		else if((trmt_category_type == "ORALCVT" || trmt_category_type == "PERIO") && status != "E"){
				if(formObj.oh_outcome.value=="F"){
				var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome,formObj.remarks,formObj.oh_failure);
				var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,location_title,performed_date_title,outcome_title,remarks_title,failure_title);
			
			}else{
				var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome,formObj.remarks);
				var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,location_title,performed_date_title,outcome_title,remarks_title);
			}
		}
		else if((trmt_category_type == "ORALCVT" || trmt_category_type == "PERIO") && status == "E"){
			var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome,formObj.reasonforcancel);
			var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,location_title,performed_date_title,outcome_title,cancel_reason_title);
		}
		else if((trmt_category_type == "MAXILLA" || site_type=="MOUTH") && status != "E"){
				if(formObj.oh_area.value=="I" || formObj.oh_area.value=="E" || formObj.site.value=="MAXFS"){//added by parul for CRF 701 on 23/09/2009
			
					 if ((formObj.oh_sub_parts.value=="" || formObj.oh_sub_parts.value=="null" || formObj.oh_sub_parts.value==null )&& formObj.oh_area.value!=""){
						 if(formObj.oh_sub_parts.disabled==false){
                          	if(formObj.oh_outcome.value=="F"){
								var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_sub_parts,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome,formObj.remarks,formObj.oh_failure);
								var names = new Array ( category_title,site_title,area_title,parts_title,status_title,treatment_title,location_title,performed_date_title,outcome_title,remarks_title,failure_title);
							}else{
								var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_sub_parts,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome,formObj.remarks);
								var names = new Array ( category_title,site_title,area_title,parts_title,status_title,treatment_title,location_title,performed_date_title,outcome_title,remarks_title);
							}
						}else{
							if(formObj.oh_outcome.value=="F"){
								var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_surface,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome,formObj.remarks,formObj.oh_failure);
								var names = new Array (	category_title,site_title,area_title,parts_title,status_title,treatment_title,location_title,performed_date_title,outcome_title,remarks_title,failure_title);	
			
							}else{
								var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_surface,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome,formObj.remarks);
								var names = new Array (	category_title,site_title,area_title,parts_title,status_title,treatment_title,location_title,performed_date_title,outcome_title,remarks_title);	
							}
						}
					 }else{
					var count=0;
					if(formObj.oh_sub_parts.disabled==false && (formObj.oh_surface.value=="AB" || formObj.oh_surface.value=="GING" || formObj.oh_surface.value=="MBF") && (formObj.oh_area.value=="I" || formObj.oh_area.value=="E")){

						if (formObj.oh_sub_parts.value=="THAB" || formObj.oh_sub_parts.value=="THGM" || formObj.oh_sub_parts.value=="THAG" || formObj.oh_sub_parts.value=="THMF" || formObj.oh_sub_parts.value=="THGAM"){
							if(formObj.oh_outcome.value=="F"){
									var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_selected_sub_parts,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome,formObj.remarks,formObj.oh_failure);
									var names = new Array ( category_title,site_title,area_title,parts_title,status_title,treatment_title,location_title,performed_date_title,outcome_title,remarks_title,failure_title);
			
							}else{
								var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_selected_sub_parts,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome,formObj.remarks);
								var names = new Array ( category_title,site_title,area_title,parts_title,status_title,treatment_title,location_title,performed_date_title,outcome_title,remarks_title);
							}
						
					}else if(formObj.oh_sub_parts.value=="TNGAB" || formObj.oh_sub_parts.value=="TNGGM" || formObj.oh_sub_parts.value=="TNGAG" || formObj.oh_sub_parts.value=="TNGGAM" || formObj.oh_sub_parts.value=="TNGMF"){
					 for (var k=0;k<formObj.oh_selected_sub_parts.value+1; k++) {
								count++;
						}
						if (count==1 || count==0){
							if(formObj.oh_outcome.value=="F"){
								var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_selected_sub_parts,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome,formObj.remarks,formObj.oh_failure);

								var names = new Array ( category_title,site_title,area_title,parts_title,status_title,treatment_title,location_title,performed_date_title,outcome_title,remarks_title,failure_title);
			
							}else{
								var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_selected_sub_parts,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome,formObj.remarks);

								var names = new Array ( category_title,site_title,area_title,parts_title,status_title,treatment_title,location_title,performed_date_title,outcome_title,remarks_title);
							}
						}else{
							if(formObj.oh_outcome.value=="F"){
								var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome,formObj.remarks,formObj.oh_failure);

								var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,location_title,performed_date_title,outcome_title,remarks_title,failure_title);
			
							}else{
								var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome,formObj.remarks);

								var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,location_title,performed_date_title,outcome_title,remarks_title);
							}
						
						}
					}

				}else{
					if(formObj.oh_outcome.value=="F"){
							var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome,formObj.remarks,formObj.oh_failure);

							var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,location_title,performed_date_title,outcome_title,remarks_title,failure_title);
		
						}else{
							var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome,formObj.remarks);

							var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,location_title,performed_date_title,outcome_title,remarks_title);
						}
				}
			 }
		}else{
				var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome,formObj.remarks);
				var names = new Array ( category_title,site_title,status_title,treatment_title,location_title,performed_date_title,outcome_title,remarks_title);
			}
		}
		else if((trmt_category_type == "MAXILLA" || site_type=="MOUTH") && status == "E"){
				var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome,formObj.reasonforcancel);
				var names = new Array ( category_title,site_title,status_title,treatment_title,location_title,performed_date_title,outcome_title,cancel_reason_title);
		}
		else if((formObj.oh_surface.disabled == false && site_type=="CROWN" && formObj.oh_surface.options.length >= 1) || (formObj.oh_surface.options.length >1 && site_type=="ROOT") && status != "E"){
          	if(formObj.oh_outcome.value=="F"){
				var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_surface,formObj.oh_performed_date,formObj.oh_outcome,formObj.oh_failure);
				var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,location_title,surface_title,performed_date_title,outcome_title,failure_title);
			
			}else{
				var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_surface,formObj.oh_performed_date,formObj.oh_outcome);
				var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,location_title,surface_title,performed_date_title,outcome_title);
			}
		}
		else if((formObj.oh_surface.disabled == false && site_type=="CROWN" && formObj.oh_surface.options.length >1) || (formObj.oh_surface.options.length > 1 && site_type=="ROOT") && status == "E"){
			var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_surface,formObj.oh_performed_date,formObj.oh_outcome,formObj.reasonforcancel);
			var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,location_title,surface_title,performed_date_title,outcome_title,cancel_reason_title);
		}
		else if(status == "E"){
			var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome,formObj.reasonforcancel);
			var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,location_title,performed_date_title,outcome_title,cancel_reason_title);
		}
		else{
			if(formObj.oh_outcome.value=="F"){
				var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome,formObj.oh_failure);
				var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,location_title,performed_date_title,outcome_title,failure_title);
			
			}else{
				var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_status,formObj.oh_treatment,formObj.oh_location,formObj.oh_performed_date,formObj.oh_outcome);
				var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,location_title,performed_date_title,outcome_title);
			}
		}

		if(checkFieldsofMst( fields, names, messageFrame)){
			
			var dentalchartFormObj = parent.parent.conditionDentalChartDetails.document.forms[0];
			var thrng_nos = formObj.thrng_nos.value;
			formObj.chart_hdr_insert_yn.value  = dentalchartFormObj.chart_hdr_insert_yn.value;

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
			
			if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){ //Added by Sridevi Joshi on 1/18/2010 for IN010894
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
					//retained_tooth_no = ns_tooth_no;//commented above and Added by Sridevi Joshi on 4/8/2010 for IN020464..retained_tooth_no was going as dissplay tooth no
					retained_tooth_no = mapped_tooth_no;
				}
			}
			else{
				if(super_tooth_ref == "RD" ){
					retained_tooth_no = mapped_tooth_no;
				}
			}

				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				 var super_tooth_no="";
				 //var retained_tooth_no="";//commented by Sridevi Joshi on 4/12/2010 for IN020635  .. retained_tooth_no was going as null bcoz of this
				 if (super_tooth_ref!="" && super_tooth_ref!="" && super_tooth_ref!="" && super_tooth_ref!="RD" && super_tooth_ref!="undefined" && super_tooth_ref!=undefined) {
					 super_tooth_no=tooth_no+""+super_tooth_ref.substring(super_tooth_ref.length-1,super_tooth_ref.length);

				 }

				 if (mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
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
							var params = "tooth_no="+mapped_tooth_no+"&numbering_system="+numbering_system;
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

				var msg = getMessage("APP-OH000105","OH");
				var msgArray = msg.split("##");

				/*if(site_type == "CROWN"){ //Added by Sridevi Joshi on 4/27/2010 for PE..This block has to be executed only for CRown
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&super_tooth_no="+super_tooth_no+"&retained_tooth_no="+retained_tooth_no+"&treatment_int_ext=E";	
				
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=ChkAllsurfaceOnsuper&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_surface = localTrimString(xmlHttp.responseText);
					if(retVal_surface.length>1){
						var retVal_trmt_arr = retVal_surface.split("~");
						for(var m=0;m<retVal_trmt_arr.length-1;m++){
							var code_trmt_arr = retVal_trmt_arr[m].split("##");
							var code_surface=code_trmt_arr[0];
							var code_outcome=code_trmt_arr[1];
						}
					}
				
				
					if( (formObj.called_from_viewchart_yn.value != 'Y') && site_type == "CROWN"){
						if (code_surface=="*A" && (code_outcome!="F" && (code_outcome == "" || code_outcome == "null" || code_outcome == null || code_outcome == "undefined" || code_outcome == undefined))) {
							alert(msgArray[0]+site_type+msgArray[1]);
							  return;
						}else if (code_surface=="*A" && formObj.oh_surface.value!="*A" && (formObj.oh_surface.value!="" && formObj.oh_surface.value!="null" && formObj.oh_surface.value!=null) )
						{  
							alert(msgArray[0]+site_type+msgArray[1]);
							  return;
						}
					}
				}*/
			

				if(formObj.called_from_viewchart_yn.value != 'Y'){
				//check for duplicate record...
		
					var duplicate_record = checkForDuplicateTrmtRecord(status,patient_id,chart_num,tooth_no,trmt_category_type,surface_code,site_type,treatments_outcome);
				
					if(!duplicate_record){
						return;
					}
				}

		
			/* Block that will check for the applicable condition types and allow only those condition types recording*/
		if( called_from_viewchart_yn!="Y"){
			populateAllTrmtCategories(site_type);

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
			var applicable_trmt_types = id_type_rowval;
			var applicable_trmt_desc = id_type_desc_rowval;
			
			if((site_type == "TOOTH" && tooth_no != null && tooth_no != "" && tooth_no.indexOf(",") == -1) || (site_type == "ROOT" || site_type == "CROWN" || site_type == "ARCH" || site_type == "QUAD")){ // This code is for single tooth selection 
				//This function is to check the applicable menu options..
				var applicable_trmt_types_arr = applicableTrmtMenuOptions(applicable_trmt_types,tooth_no,patient_id,chart_num,numbering_system,permanent_deciduous_flag,mixed_dentition_YN,RD_Normal_yn,site_type,thrng_nos_ref,'','','',super_tooth_ref,retained_tooth_no);
				//Added formObj.area.value,site_type by Sharon Crasta on 2/4/2010 for SRR20056-CRF-0498(IN010982)
				applicable_trmt_types = resultTrmtMenuOptions(applicable_trmt_types_arr,applicable_trmt_desc,tooth_no,mixed_dentition_YN,permanent_deciduous_flag,formObj.area.value,site_type);
				//End
				 //added by parul on 29/01/2010 for CRF-442
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				 var super_tooth_no="";
				// var retained_tooth_no="";
				 if (super_tooth_ref!="" && super_tooth_ref!="" && super_tooth_ref!="") {
					 super_tooth_no=tooth_no+""+super_tooth_ref.substring(super_tooth_ref.length-1,super_tooth_ref.length);
				 }
				/*  if(super_tooth_ref == "RD"){//Added by parul on 12/17/2009 for RTDESTH new changes
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
				  }*/
				var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&super_tooth_no="+super_tooth_no+"&retained_tooth_no="+retained_tooth_no;
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
			else if(site_type == "THRNG" && tooth_no.indexOf(",") != -1){ // This code is for multiple tooth selection 
				var nors_arr = thrng_nos_ref.split(",");
				var flag_not_consecutive = false;
				for(j=0;j<nors_arr.length;j++){
					 
					// Added flag_not_consecutive by Sharon Crasta on 3/3/2010 for SRR20056-CRF-0475(IN010868) for Bridge Trmt to check if consecutive tooth are selected.
					
					var nos_length = nors_arr.length;
					
					var tooth1 = parseInt(nors_arr[j]);
					var tooth2 = parseInt(nors_arr[j+1]);
					var tooth_add = parseInt(tooth1 + 1);

					if(nors_arr[j+1] != "" && nors_arr[j+1] != "undefined" && nors_arr[j+1] != "null" && nors_arr[j+1] != null && nors_arr[j+1] <= nors_arr[nos_length-1]){
							//if(parseInt(nors_arr[j+1]) != ((parseInt(nors_arr[j]) + 1))) {
							if(tooth_add != tooth2) {
							   flag_not_consecutive = true;
						}
					}//End
					
					var len = nors_arr.length;
					var no_of_tooth = parseInt(nors_arr[len-1])-parseInt(nors_arr[0])-1;
					
					//This function is to check the applicable menu options..
					var applicable_trmt_types_arr = applicableTrmtMenuOptions(applicable_trmt_types,nors_arr[j],patient_id,chart_num,numbering_system,permanent_deciduous_flag,mixed_dentition_YN,RD_Normal_yn,site_type,thrng_nos_ref,j,nors_arr.length-1,no_of_tooth,super_tooth_ref,retained_tooth_no,flag_not_consecutive);

					applicable_trmt_types = resultTrmtMenuOptions(applicable_trmt_types_arr,applicable_trmt_desc,nors_arr[j],mixed_dentition_YN,permanent_deciduous_flag,'','',site_type,thrng_nos_ref);
				
				}
			}

		/*if(super_tooth_ref == "RD"){//Added by parul on 12/17/2009 for RTDESTH new changes
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
			}*/
			var count_trmts = 0; // This count is to count the conditions available. If this count = 0 then dont show the menu.
			var return_menu_flag = "N";
			for(j=0;j<applicable_trmt_types.length;j++){
				if(applicable_trmt_types[j] != "undefined" && applicable_trmt_types[j] != undefined){
					count_trmts++;
					/*if(document.forms[0].oh_category.value!="OTHERS"){// if condition is added by parul on 7/21/2009 for IN012545(System was not allowing to record Others External Treatment)
						if(applicable_trmt_types[j] == (document.forms[0].oh_category.value)){
							return_menu_flag = "Y";
							break;
						}
						else{
								return_menu_flag = "N";
						}
					}
					else{
						return_menu_flag = "Y";
					}*/

					if(document.forms[0].oh_category.value=="OTHERS"){// if condition is added by parul on 7/21/2009 for IN012545(System was not allowing to record Others External Treatment)
						return_menu_flag = "Y";
					}
					else{
						var show_menu = "Y";//Added by Sridevi joshi on 2/11/2010 for IN010871(SRR20056-CRF-0478)
						
						if(thrng_nos != null && thrng_nos != "" && thrng_nos.indexOf(",") != -1 && (document.forms[0].oh_category.value == "BRIDGE")){ // This code is for multiple tooth selection 
							var nors_arr = thrng_nos_ref.split(",");
							for(var d=0;d<nors_arr.length;d++){
								//check_cat_type = populateConditionCode(formObj.oh_category,formObj.oh_treatment);
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								params = "func_mode=checkForTreatments&tooth_no="+nors_arr[d]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type="+applicable_trmt_types[j]+"&header_tab=ET"+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
								xmlHttp.send(xmlDoc);
								
								var retVal_trmt1 = trimString(xmlHttp.responseText); 
								retVal_trmt1 = localTrimString(retVal_trmt1); 
								if(retVal_trmt1.length > 1){
									var retVal_trmt1_arr = retVal_trmt1.split("~");
									for(var h=0;h<retVal_trmt1_arr.length-1;h++){
										var thrng_val = "";
										var rec_trmt_arr = retVal_trmt1_arr[h].split("##");
										var denture_removable = rec_trmt_arr[1];
										var trmt_outcome = rec_trmt_arr[2];
										var tooth_range = rec_trmt_arr[4];
										var treatments_status = rec_trmt_arr[5];
										
										if(tooth_range != "" && tooth_range != "null" && tooth_range != null){
											var tooth_chart_arr = tooth_range.split(",");
											for(var g=0;g<tooth_chart_arr.length;g++){
												var tooth_range_arr = tooth_chart_arr[g].split("$$");
												if(thrng_val == ""){
													thrng_val = tooth_range_arr[1];
												}
												else{							   
													thrng_val = thrng_val+","+tooth_range_arr[1];
												}
												
											}
											if(applicable_trmt_types[j] == "DENTURE"){//Added by Sridevi Joshi on 3/4/2010 for CRF-478
												if(parseInt(treatments_status) < 25){//Addded by Sridevi Joshi on 3/10/2010 for IN019920
													show_menu = "N"; 
												}
												else if(thrng_val != nors_arr && trmt_outcome != "F" ){
													show_menu = "N"; //If Denture is recorded on any one of the tooth in case of range
												}
												else if(thrng_val == nors_arr && trmt_outcome != "F" && denture_removable != "Y"){ // denture_removable is added by Sridevi Joshi on 3/4/2010 for CRF-478
													show_menu = "N"; //If Denture is recorded on any one of the tooth in case of range
												}
												else{
													show_menu = "Y"; //If Denture is recorded on any one of the tooth in case of range
												}
											}
											else{
												if(thrng_val != tooth_no && trmt_outcome != "F" ){
													//show_menu = "N"; //If Denture is recorded on any one of the tooth in case of range
												}
												else if(thrng_val == tooth_no && trmt_outcome != "F" ){
													show_menu = "N"; //If Denture is recorded on any one of the tooth in case of range
												}
												else{
													show_menu = "Y"; //If Denture is recorded on any one of the tooth in case of range
												}
											}
										}
										else{
											thrng_val = nors_arr;
											if(trmt_outcome != "F"){
												show_menu = "N"; //If Denture is recorded on any one of the tooth in case of range
											}
											else{
												show_menu = "Y"; //If Denture is recorded on any one of the tooth in case of range
											}
										}										
									}
								}
								else{
									show_menu = "N"; //If Denture is not recorded on any one of the tooth in case of range
								}
							}
						}

						if((document.forms[0].oh_category.value != "BRIDGE") && (site_type=="THRNG" || site_type=="TOOTH" || site_type == "ARCH" || site_type == "QUAD" || site_type == "MAXFS")){//added by parul for CRF-477 on 02/03/2010 ,for Crown,root written seprate blk/
						//if((site_type=="THRNG" || site_type=="TOOTH" || site_type == "ARCH" || site_type == "QUAD")){//added by parul for CRF-477 on 02/03/2010 ,for Crown,root written seprate blk
							if(applicable_trmt_types[j] == (document.forms[0].oh_category.value)){
							//	if(document.forms[0].oh_category.value == "DENTURE"){ //Added by Sridevi joshi on 2/11/2010 for IN010871(SRR20056-CRF-0478)//commented by parul for CRF-477 & 496 (this validation should be done for all trmts)
								if (site_type == "THRNG" && tooth_no.indexOf(",") != -1){
									var nors_arr = thrng_nos_ref.split(",");
									for(var u=0;u<nors_arr.length;u++){
											var xmlDoc = "" ;
											var xmlHttp = new XMLHttpRequest();
											//Site and arch_quad is added in the params by Sridevi Joshi on 3/30/2010 for IN020404
											
											params = "func_mode=checkForTreatments&tooth_no="+nors_arr[u]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&trmt_category_type="+applicable_trmt_types[j]+"&other_chart_facility_id="+other_chart_facility_id+"&header_tab=ET&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&arch_quad="+tooth_no+"&site="+site_type+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
									
											var xmlStr ="<root><SEARCH ";
											xmlStr +=" /></root>";
											xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
											xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
											xmlHttp.send(xmlDoc);
											var retVal_trmt1 = trimString(xmlHttp.responseText); 
											retVal_trmt1 = localTrimString(retVal_trmt1); 
											if(retVal_trmt1.length > 1){
												var retVal_trmt1_arr = retVal_trmt1.split("~");
												for(var h=0;h<retVal_trmt1_arr.length-1;h++){
													var rec_trmt_arr = retVal_trmt1_arr[h].split("##");
													var denture_removable = rec_trmt_arr[1];
													var treatments_outcome_ext = rec_trmt_arr[2];
													if(treatments_outcome_ext == "S" && denture_removable != "Y"){
														show_menu = "N"; 
														break;
													}
												}
											}
											if(retVal_trmt1.length > 1){
												var retVal_trmt1_arr = retVal_trmt1.split("~");
											
												for(var h=0;h<retVal_trmt1_arr.length-1;h++){
													var rec_trmt_arr = retVal_trmt1_arr[h].split("##");
													var denture_removable = rec_trmt_arr[1];
													var treatments_outcome_ext = rec_trmt_arr[2];
													
													if((denture_removable == "Y" || treatments_outcome_ext == "F") && show_menu == "Y"){
														return_menu_flag = "Y";
														//break;
													}
													else{
														return_menu_flag = "N";
														//show_menu == "N";
														break;//added by parul on 14/04/2010 for IN020573 
													}
												}

												if(return_menu_flag == "Y"){
													break;
												}
												break;//parul on 14/04/2010 for IN020573
											}
											else{
												return_menu_flag = "Y";
												//break;
											}
										}
									}else{
										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest();
										//Site and arch_quad is added in the params by Sridevi Joshi on 3/30/2010 for IN020404
										
										params = "func_mode=checkForTreatments&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&trmt_category_type="+applicable_trmt_types[j]+"&other_chart_facility_id="+other_chart_facility_id+"&header_tab=ET&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&arch_quad="+tooth_no+"&site="+site_type+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
								
										var xmlStr ="<root><SEARCH ";
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
										xmlHttp.send(xmlDoc);
										var retVal_trmt1 = trimString(xmlHttp.responseText); 
										retVal_trmt1 = localTrimString(retVal_trmt1); 
										if(retVal_trmt1.length > 1){
											var retVal_trmt1_arr = retVal_trmt1.split("~");
											for(var h=0;h<retVal_trmt1_arr.length-1;h++){
												var rec_trmt_arr = retVal_trmt1_arr[h].split("##");
												var denture_removable = rec_trmt_arr[1];
												var treatments_outcome_ext = rec_trmt_arr[2];
												if(treatments_outcome_ext == "S" && denture_removable != "Y"){
													show_menu = "N"; 
													break;
												}
											}
										}
										if(retVal_trmt1.length > 1){
											var retVal_trmt1_arr = retVal_trmt1.split("~");
										
											for(var h=0;h<retVal_trmt1_arr.length-1;h++){
												var rec_trmt_arr = retVal_trmt1_arr[h].split("##");
												var denture_removable = rec_trmt_arr[1];
												var treatments_outcome_ext = rec_trmt_arr[2];
												
												if((denture_removable == "Y" || treatments_outcome_ext == "F") && show_menu == "Y"){
													return_menu_flag = "Y";
													//break;
												}
												else{
													return_menu_flag = "N";
													//show_menu == "N";
												}
											}

											if(return_menu_flag == "Y"){
												break;
											}
										}
										else{
											return_menu_flag = "Y";
											break;
										}
																	
									}
								}//end
							else{
								return_menu_flag = "N";
							}
						}else{
							if(applicable_trmt_types[j] == (document.forms[0].oh_category.value)){
									var xmlDoc = "" ;
									var xmlHttp = new XMLHttpRequest();
									if (formObj.surface_ref.value=="*A"){
										surface_ref="*A"
									}

									var surface_ref_arr=surface_ref.split(",");
									if (surface_ref_arr.length>1){
										for(var u=0;u<surface_ref_arr.length;u++){	
											params = "func_mode=checkForTreatmentsOnCrown&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&trmt_category_type="+applicable_trmt_types[j]+"&other_chart_facility_id="+other_chart_facility_id+"&surface_code="+surface_ref_arr[u]+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
										}
									}else{
									    params = "func_mode=checkForTreatmentsOnCrown&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&trmt_category_type="+applicable_trmt_types[j]+"&other_chart_facility_id="+other_chart_facility_id+"&surface_code="+surface_ref+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;									
									}
									var xmlStr ="<root><SEARCH ";
									xmlStr +=" /></root>";
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
									xmlHttp.send(xmlDoc);
									var retVal_trmt1 = trimString(xmlHttp.responseText); 
									retVal_trmt1 = localTrimString(retVal_trmt1); 
									if(retVal_trmt1.length > 1){
										var retVal_trmt1_arr = retVal_trmt1.split("~");
										for(var h=0;h<retVal_trmt1_arr.length-1;h++){
											var rec_trmt_arr = retVal_trmt1_arr[h].split("##");
											//var denture_removable = rec_trmt_arr[1];
											var treatments_outcome_ext = rec_trmt_arr[1];

											if(treatments_outcome_ext == "S"){
												show_menu = "N"; 
												break;
											}
										}
									}
									if(retVal_trmt1.length > 1){
										var retVal_trmt1_arr = retVal_trmt1.split("~");
										for(var h=0;h<retVal_trmt1_arr.length-1;h++){
											var rec_trmt_arr = retVal_trmt1_arr[h].split("##");
											//var denture_removable = rec_trmt_arr[1];
											var treatments_outcome_ext = rec_trmt_arr[1];
											if((treatments_outcome_ext == "F") && show_menu == "Y"){
												return_menu_flag = "Y";
												//break;
											}
											else{
												return_menu_flag = "N";
												//show_menu == "N";
											}
										}

										if(return_menu_flag == "Y"){
											break;
										}
									}
									else{
										return_menu_flag = "Y";
										break;
									}
							
								}
							else{
								return_menu_flag = "N";
							}
						
						}
					}
				}
			}
			var msg = getMessage("APP-OH000105","OH");
			var msgArray = msg.split("##");
			var trmt_cat_desc = document.forms[0].oh_category.options[document.forms[0].oh_category.selectedIndex].text;
			if(parseInt(count_trmts) > 0){
				if(return_menu_flag == "N"){
						alert(msgArray[0]+trmt_cat_desc+msgArray[1]);
						//Commented by Sharon Crasta on 12/18/2009 for IN017397
						//Since the tooth range value is made null, the menu check does not happen for the tooth range. i.e., for the second time when the bridge/denture trmt is recorded on the same tooth range, tooth_no.indexOf(",") was going as -1
						//To clear thrng_nos_ref once the trmt category is changes
						//document.forms[0].thrng_nos_ref.value = "";
						//End
						return;
					}else if(site_type=="CROWN"){
							if (return_surface_alert){  //added by parul on 29/01/2010 for CRF-442
								alert(getMessage("APP-OH000165",'OH'));
							  return;
						}
						//Added by Sharon Crasta on 3/15/2010 for SRR20056-CRF-0475(IN010868)
						else if(retVal_status_for_bridge){
						     alert(getMessage("APP-OH000180",'OH'));
							 return;
					   	}//End
					} 
			}
			else{
				if(return_menu_flag == "N"){
						alert(msgArray[0]+trmt_cat_desc+msgArray[1]);
						//Commented by Sharon Crasta on 12/18/2009 for IN017397
						//Since the tooth range value is made null, the menu check does not happen for the tooth range. i.e., for the second time when the bridge/denture trmt is recorded on the same tooth range, tooth_no.indexOf(",") was going as -1
						//To clear thrng_nos_ref once the trmt category is changes
						//document.forms[0].thrng_nos_ref.value = "";
						//End
						return;
					}
			}
		}
			/* Ends here */

		    
			//Added by Sharon Crasta on 2/9/2010 for SRR20056-CRF-0475(IN010868)
			var modalReturnedVal = "";
			var pontic_tooth = new Array();
			var pontic_tooth_split_values = new Array();
			var abutment_tooth_values = "";
			var title_desc = getLabel("eOH.PonticToothDtls.Label","OH");

			if(status != "E" && trmt_category_type == "BRIDGE"){
				var nors_arr = thrng_nos_ref.split(",");
				if(nors_arr.length >= 6){
					alert(getMessage("APP-OH000170","OH"));
					return;
				}
				
			}
			
			if(status != "E" && trmt_category_type == "EXTRACT"){
				
				var flag_for_pontic_tooth =  false;
			   	var j =0;
				
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
				pontic_tooth = retVal_bridge_extract.split(",") ;
				
				if(tooth_no == (retVal_bridge_extract.substring(retVal_bridge_extract.lastIndexOf("$")+1,retVal_bridge_extract.length))){	// toothno == to the last number in the bridge 
				 	for(i = pontic_tooth.length-1;i >= 0;i--,j++){

						pontic_tooth_split_values[j] = pontic_tooth[i].substring((pontic_tooth[i].lastIndexOf("$")+1),pontic_tooth[i].length) ;

					} 
				}else{
					for(i = 0; i < pontic_tooth.length;i++){
						pontic_tooth_split_values[i] = pontic_tooth[i].substring((pontic_tooth[i].lastIndexOf("$")+1),pontic_tooth[i].length) ;
					} 
				}
				abutment = pontic_tooth_split_values.length-1;
			    abutment_tooth_values = pontic_tooth_split_values[abutment];

				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params_abutment_extract = "func_mode=getAbutmentToothExtraction&tooth_no="+abutment_tooth_values+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_abutment_extract,false);
				xmlHttp.send(xmlDoc);
				var retVal_abutment_extract = trimString(xmlHttp.responseText); 
				retVal_abutment_extract = localTrimString(retVal_abutment_extract);

				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params_pontic_update = "func_mode=getMaxChartLineNum&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=BRIDGE";
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_update,false);
				xmlHttp.send(xmlDoc);
				var retVal_max_chart_line_num = trimString(xmlHttp.responseText); 
				retVal_max_chart_line_num = localTrimString(retVal_max_chart_line_num);

				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params_pontic_tooth = "func_mode=getPonticCutToothValues&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+retVal_max_chart_line_num+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&trmt_category_type=BRIDGE";
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_tooth,false);
				xmlHttp.send(xmlDoc);
				var retVal_bridge = trimString(xmlHttp.responseText); 
				retVal_bridge = localTrimString(retVal_bridge);
				
				if(retVal_bridge.length > 0){
					var retVal_pontic = retVal_bridge.split("##");
					
					formObj.pontic_tooth_values.value = retVal_pontic[0]; 
				}
			
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params_bridge_extract = "func_mode=getOutcomeForExtraction&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+retVal_max_chart_line_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=BRIDGE";
				
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_bridge_extract,false);
				xmlHttp.send(xmlDoc);
				var retVal_outcome_bridge = trimString(xmlHttp.responseText); 
				retVal_outcome_bridge = localTrimString(retVal_outcome_bridge);
				if(retVal_outcome_bridge == "" || retVal_outcome_bridge == "null" || retVal_outcome_bridge == null || retVal_outcome_bridge == "undefined" || retVal_outcome_bridge == undefined){
					retVal_outcome_bridge = "S";
				}
				var retVal_pontic_arr = retVal_pontic[0].split("$$"); // Pontic Values
				var pontic_cut_length = 0;
				
				for(var j = 0; j< retVal_pontic_arr.length;j++){
					if(retVal_pontic_arr[j].length > 0){
						pontic_cut_length++;
					}
				}
			
				var pontic_length = 0;
				
				for(var i = 1; i< pontic_tooth_split_values.length-1;i++){
					pontic_length++;
				}
				
				if(retVal_abutment_extract > 0 &&  retVal_outcome_bridge == "S" && (pontic_cut_length != pontic_length)){
					alert(getMessage("APP-OH000168","OH"));	
					return;
				}

				if(retVal_bridge_extract.length > 0 && retVal_outcome_bridge == "S"){

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params_pontic_update = "func_mode=getMaxChartLineNum&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=EXTRACT";
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_update,false);
					xmlHttp.send(xmlDoc);
					var retVal_max_chart_line_num = trimString(xmlHttp.responseText); 
					retVal_max_chart_line_num = localTrimString(retVal_max_chart_line_num);
					
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params_bridge_extract = "func_mode=getOutcomeForExtraction&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+retVal_max_chart_line_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=EXTRACT";

					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_bridge_extract,false);
					xmlHttp.send(xmlDoc);
					var retVal_outcome_ext = trimString(xmlHttp.responseText); 
					retVal_outcome_ext = localTrimString(retVal_outcome_ext);
					//Extraction Trmt - Success, Call from RHS record Success again for the same trmt, then the pontic window should not be called.If recording failure after success then it should be called.
					if(formObj.called_from_viewchart_yn.value == "Y" && ((retVal_outcome_ext == "" || retVal_outcome_ext == "null" || retVal_outcome_ext == null || retVal_outcome_ext == "undefined" || retVal_outcome_ext == undefined) || ( retVal_outcome_ext == "S" && treatments_outcome == "F"))) {

						 var params = "&patient_id="+patient_id+"&site_type="+site_type+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&pontic_tooth="+pontic_tooth_split_values+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&title_desc="+title_desc+"&numbering_system="+numbering_system;
						 
						 var url	= "../../eOH/jsp/PonticTooth.jsp?"+params;
							
						 var dialogHeight   = "35vh" ;
						 var dialogWidth	= "50vw" ;
						 var dialogTop      = "170";
						 var dialogLeft     = "300";  	
							
						 var status = "no";
						 var arguments	= "" ;
						 var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop +"  ;dialogLeft:" + dialogLeft + ";scroll=auto; status:" + status;
						 modalReturnedVal = await window.showModalDialog(url,arguments,features);
						
					}else if(formObj.called_from_viewchart_yn.value != "Y") {
						
						 var params = "&patient_id="+patient_id+"&site_type="+site_type+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&pontic_tooth="+pontic_tooth_split_values+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&title_desc="+title_desc+"&numbering_system="+numbering_system;
						 
						 var url	= "../../eOH/jsp/PonticTooth.jsp?"+params;
							
						 var dialogHeight   = "35vh" ;
						 var dialogWidth	= "55vw" ;
						 var dialogTop      = "170";
						 var dialogLeft     = "300";  	
							
						 var status = "no";
						 var arguments	= "" ;
						 var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop +"  ;dialogLeft:" + dialogLeft + ";scroll=auto; status:" + status;
						 modalReturnedVal =await window.showModalDialog(url,arguments,features);
						  						
					}
				}
				
			}

			if(status == "E" && trmt_category_type == "EXTRACT"){
				var l = 0;
				var modalReturnedVal = "";	 // While mark Error marking the PONTIC_TOOTH_DTLS as null.
				var pontic_tooth_split_values_err = new Array();
				var pontic_tooth_err = new Array();

				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params_bridge_extract = "func_mode=getTrmtCatCode&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_bridge_extract,false);
				xmlHttp.send(xmlDoc);
				var retVal_bridge_extract_err = trimString(xmlHttp.responseText); 
				retVal_bridge_extract_err = localTrimString(retVal_bridge_extract_err);
				pontic_tooth_err = retVal_bridge_extract_err.split(",") ;
								
				if(tooth_no == (retVal_bridge_extract_err.substring(retVal_bridge_extract_err.lastIndexOf("$")+1,retVal_bridge_extract_err.length))){	// toothno == to the last number in the bridge 
				 	for(i = pontic_tooth_err.length-1;i >= 0;i--,l++){

						pontic_tooth_split_values_err[l] = pontic_tooth_err[i].substring((pontic_tooth_err[i].lastIndexOf("$")+1),pontic_tooth_err[i].length) ;

					} 
				}else{
					for(i = 0; i < pontic_tooth_err.length;i++){
						pontic_tooth_split_values_err[i] = pontic_tooth_err[i].substring((pontic_tooth_err[i].lastIndexOf("$")+1),pontic_tooth_err[i].length) ;
					} 
				}

				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params_pontic_tooth = "func_mode=getPonticCutToothValues&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&trmt_category_type=EXTRACT";
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_tooth,false);
				xmlHttp.send(xmlDoc);
				var retVal_extract_pontics = trimString(xmlHttp.responseText); 
				retVal_extract_pontics = localTrimString(retVal_extract_pontics);
				retVal_extract_pontics = retVal_extract_pontics.split("##");

				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params_pontic_update = "func_mode=getMaxChartLineNum&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=BRIDGE";
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_update,false);
				xmlHttp.send(xmlDoc);
				var retVal_max_chart_line_num_err = trimString(xmlHttp.responseText); 
				retVal_max_chart_line_num_err = localTrimString(retVal_max_chart_line_num_err);

				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params_pontic_tooth = "func_mode=getPonticCutToothValues&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+retVal_max_chart_line_num_err+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&trmt_category_type=BRIDGE";
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_tooth,false);
				xmlHttp.send(xmlDoc);
				var retVal_bridge = trimString(xmlHttp.responseText); 
				retVal_bridge = localTrimString(retVal_bridge);

				if(retVal_bridge.length > 0){
					var retVal_pontic = retVal_bridge.split("##");
					formObj.pontic_tooth_values.value = retVal_pontic[0];
					
					
							for(var j =0; j < pontic_tooth_split_values_err.length; j++){
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params_pontic_update = "func_mode=getMaxChartLineNum&tooth_no="+pontic_tooth_split_values_err[j]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=BRIDGE";
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_update,false);
								xmlHttp.send(xmlDoc);
								var retVal_max_chart_line_num_err = trimString(xmlHttp.responseText); 
								retVal_max_chart_line_num_err = localTrimString(retVal_max_chart_line_num_err);

								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params_pontic_bridge_update = "func_mode=updateCutPonticTooth&tooth_no="+pontic_tooth_split_values_err[j]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+retVal_max_chart_line_num_err+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&tooth_nos="+modalReturnedVal+"&treatments_outcome="+treatments_outcome+"&trmt_category_type=BRIDGE";
															
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_bridge_update,false);
								xmlHttp.send(xmlDoc);
								var retVal_pontic_bridge_tooth = trimString(xmlHttp.responseText); 
								retVal_pontic_bridge_tooth = localTrimString(retVal_pontic_bridge_tooth);
								
							}
					//}  
								
				}
			} //End
			var tooth_layer = "toothLayer"+tooth_no;
			var root_layer = "rootLayer"+tooth_no;
			var ref_tooth_no = formObj.ref_tooth_no.value;//Added by Sridevi Joshi on 2/21/2010 for IN019472

			if(status != "E" && formObj.called_from_viewchart_yn.value != 'Y'){ //called_from_viewchart_yn is added by Sridevi Joshi on 1/8/2010
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
					var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&retained_tooth_no="+retained_tooth_no+"&super_tooth_ref="+super_tooth_ref+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&tab_code=ET";

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
								alert(getMessage("APP-OH000106","OH"));
								return;
							}
						}
						else if(permanent_deciduous_flag=="P" && (tooth_no =="1" || tooth_no =="16" || tooth_no =="17" || tooth_no =="32")){
							if(parerth_rec != "Y" && erupth_rec != "Y" && (super_tooth_ref == "" || super_tooth_ref == undefined || super_tooth_ref == "undefined")){// super_tooth_ref is added by Sridevi Joshi on 3/15/2010 for IN019963
								alert(getMessage("APP-OH000106","OH"));
								return;
							}
						}
						//else if(unerth_rec == "Y" && erupth_rec != "Y" ){
						else if(unerth_rec == "Y" && erupth_rec != "Y" && parerth_rec != "Y" ){// erupth_rec condition is Added by Sridevi Joshi on 31/03/2010 for IN020459
							alert(getMessage("APP-OH000106","OH"));
							return;
						}
						else if(impactn_rec == "Y" && parerth_rec != "Y" && erupth_rec != "Y"){
							alert(getMessage("APP-OH000106","OH"));
							return;
						}
						else if(exfolth_rec == "Y" && erupth_rec != "Y" && parerth_rec != "Y"){ //erupth_rec & parerth_rec is added by Sridevi Joshi on 4/6/2010 for IN020513. This is for MD-P case DECITH-->EXFOLTH-->ERUPT-->Caries
							alert(getMessage("APP-OH000106","OH"));
							return;
						}
						else if(missth_rec == "Y"){
							alert(getMessage("APP-OH000106","OH"));
							return;
						}
						else if(extract_rec == "Y" || implant_rec == "Y" || denture_rec == "Y" || bridge_rec == "Y"){
							alert(getMessage("APP-OH000106","OH"));
							return;
						}
					}
					else if(site_type == "ROOT"){
						if(mixed_dentition_YN == "Y" && (tooth_no =="2" || tooth_no =="3" || tooth_no =="14" || tooth_no =="15" || tooth_no =="18" || tooth_no =="19" || tooth_no =="30" || tooth_no =="31")){
							if(erupth_rec != "Y" && (super_tooth_ref == "" || super_tooth_ref == undefined || super_tooth_ref == "undefined")){// super_tooth_ref is added by Sridevi Joshi on 3/15/2010 for IN019963
								alert(getMessage("APP-OH000107","OH"));
								return;
							}
						}
						else if(permanent_deciduous_flag=="P" && (tooth_no =="1" || tooth_no =="16" || tooth_no =="17" || tooth_no =="32")){
							if(erupth_rec != "Y" && (super_tooth_ref == "" || super_tooth_ref == undefined || super_tooth_ref == "undefined")){// super_tooth_ref is added by Sridevi Joshi on 3/15/2010 for IN019963
								alert(getMessage("APP-OH000107","OH"));
								return;
							}
						}
						else if((unerth_rec == "Y" || parerth_rec == "Y") && erupth_rec != "Y" ){
							alert(getMessage("APP-OH000107","OH"));
							return;
						}
						else if(impactn_rec == "Y" && erupth_rec != "Y"){
							alert(getMessage("APP-OH000107","OH"));
							return;
						}
						else if(exfolth_rec == "Y" && erupth_rec != "Y" ){ //erupth_rec is added by Sridevi Joshi on 4/6/2010 for IN020513. This is for MD-P case DECITH-->EXFOLTH-->ERUPT-->Caries
							alert(getMessage("APP-OH000107","OH"));
							return;
						}
						else if(missth_rec == "Y"){
							alert(getMessage("APP-OH000107","OH"));
							return;
						}
						//Commented by Sharon Crasta on 3/4/2010 for SRR20056-CRF-0475(IN010868)
						// Should not be applicable for Root since for Abutment tooth we have the Root available.
						//else if(extract_rec == "Y" || implant_rec == "Y" || denture_rec == "Y" || bridge_rec == "Y"){
						else if(extract_rec == "Y" || implant_rec == "Y" || denture_rec == "Y"){//End
							alert(getMessage("APP-OH000107","OH"));
							return;
						}
					}
				}
			}
			//Added by Sridevi joshi on 2/11/2010 for IN010871(SRR20056-CRF-0478) to allow denture trmt of same category is recorded denture is removable.
			if(trmt_category_type == "DENTURE" && status != "E" && formObj.called_from_viewchart_yn.value != 'Y'){
				if(site_type == "THRNG"){ 
					var upper_arch_yn = "N";
					var lower_arch_yn = "N";
					var tooth_no_arr = tooth_no.split(",");
					
					for (var k=0;k<tooth_no_arr.length; k++){
						if(tooth_no_arr[k] == "1"  || tooth_no_arr[k] == "16"){
							upper_arch_yn = "Y";
						}

						if(tooth_no_arr[k] == "17" || tooth_no_arr[k] == "32"){
							lower_arch_yn = "Y";
						}

						if(lower_arch_yn == "Y" && upper_arch_yn == "Y" && trmt_category_type == "DENTURE"){
							alert(getMessage("APP-OH000175","OH"));
							return;
						}
						check_cat_type = populateConditionCode(formObj.oh_category,formObj.oh_treatment);

						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=checkForTreatments&tooth_no="+tooth_no_arr[k]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=DENTURE&header_tab=ET&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal_trmt_cat_code = trimString(xmlHttp.responseText); 
						retVal_trmt_cat_code = localTrimString(retVal_trmt_cat_code); 

						if(retVal_trmt_cat_code.length > 1){
							var retVal_trmt_cat_code_arr = retVal_trmt_cat_code.split("~");
							for(var h=0;h<retVal_trmt_cat_code_arr.length-1;h++){
								var thrng_val = "";
								var rec_trmt_arr = retVal_trmt_cat_code_arr[h].split("##");
								var denture_removable = rec_trmt_arr[1];
								var trmt_outcome = rec_trmt_arr[2];
								var rec_cat_code = rec_trmt_arr[3];
								var tooth_range = rec_trmt_arr[4];
								
								if(rec_cat_code != check_cat_type && denture_removable == "Y" && trmt_outcome != "F"){ //If recoding Denture with diffrent category on removable denture 
									alert(getMessage("APP-OH000173","OH"));
									return;
								}
								else{
									//tooth_range:==6$$23,7$$24
									if(tooth_range != "" && tooth_range != "null" && tooth_range != null){
										var tooth_chart_arr = tooth_range.split(",");
										for(var g=0;g<tooth_chart_arr.length;g++){
											var tooth_range_arr = tooth_chart_arr[g].split("$$");
											if(thrng_val == ""){
												thrng_val = tooth_range_arr[1];
											}
											else{
												thrng_val = thrng_val+","+tooth_range_arr[1];
											}
										}
									
										if(thrng_val != tooth_no && trmt_outcome != "F"){
											diff_den_tooth = "Y";
										}
										else if(thrng_val == tooth_no && trmt_outcome != "F" && denture_removable != "Y"){
											failure_yn = "Y";
											diff_den_tooth = "N";
										}
										else{
											failure_yn = "N";
											diff_den_tooth = "N";
										}
									}
									else{
										thrng_val = tooth_no;
										if(trmt_outcome != "F"){
											diff_den_tooth = "N";
											failure_yn = "Y";
										}
									}
								}
							}

							if(diff_den_tooth == "Y"){
								alert(getMessage("APP-OH000172","OH"));
								return;
							}
							
							if(failure_yn == "Y"){
								alert(getMessage("APP-OH000174","OH"));
								return;
							}
						}
					}
				}
				else{
					check_cat_type = populateConditionCode(formObj.oh_category,formObj.oh_treatment);
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					params = "func_mode=checkForTreatments&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&arch_quad="+tooth_no+"&site="+site_type+"&trmt_category_type="+trmt_category_type+"&header_tab=ET&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_trmt_cat_code = trimString(xmlHttp.responseText); 
					retVal_trmt_cat_code = localTrimString(retVal_trmt_cat_code); 
					if(retVal_trmt_cat_code.length > 1){
						var retVal_trmt_cat_code_arr = retVal_trmt_cat_code.split("~");
						for(var h=0;h<retVal_trmt_cat_code_arr.length-1;h++){
							var thrng_val = "";
							var rec_trmt_arr = retVal_trmt_cat_code_arr[h].split("##");
							var denture_removable = rec_trmt_arr[1];
							var trmt_outcome = rec_trmt_arr[2];
							var rec_cat_code = rec_trmt_arr[3];
							var tooth_range = rec_trmt_arr[4];
							var treatments_status = rec_trmt_arr[5];
							var treatment_int_ext = rec_trmt_arr[7];

							if(rec_cat_code != check_cat_type && denture_removable == "Y" && trmt_outcome != "F"){
								alert(getMessage("APP-OH000173","OH"));
								return;
							}
							else{
								//tooth_range:==6$$23,7$$24
								if(tooth_range != "" && tooth_range != "null" && tooth_range != null){
									var tooth_chart_arr = tooth_range.split(",");
									for(var g=0;g<tooth_chart_arr.length;g++){
										var tooth_range_arr = tooth_chart_arr[g].split("$$");
										if(thrng_val == ""){
											thrng_val = tooth_range_arr[1];
										}
										else{
											thrng_val = thrng_val+","+tooth_range_arr[1];
										}
									}
								}
								else{
									thrng_val = tooth_no;
									
								}
								if(thrng_val != tooth_no && trmt_outcome != "F"){
									alert(getMessage("APP-OH000172","OH"));
									return;
								}
							}

							if(parseInt(treatments_status) < 25 && treatment_int_ext == "I"){ //Added by Sridevi Joshi on 3/8/2010  ---order placed for removable denture in Treatments and trying to record denture on that in Ext trmt
								alert(getMessage("APP-OH000174","OH"));
								return;
							}

							if(trmt_outcome != "F" && denture_removable != "Y"){
								alert(getMessage("APP-OH000174","OH"));
								return;
							}
						}
					}
				}
			}
			//End 

			//return;
			if(status != "E" && formObj.called_from_viewchart_yn.value != 'Y'){ 
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
					if((site_type != "" && site_type != "null" && site_type != null && site_type != "undefined" && site_type != undefined) && site_type != "ARCH" && site_type != "QUAD" && site_type != "THRNG" && site_type != "MAXFS" && site_type != "MOUTH"){ //Added by Sridevi Joshi on 1/21/2010 for IN010894--Mouth condition is added by Sridevi Joshi on 3/11/2010

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

			var moblty_confirm="";

			if(formObj.called_from_viewchart_yn.value == 'Y'){
				formObj.action="../../servlet/eOH.OHDentalChartAmendServlet";
				formObj.called_from_viewchart_yn.value = "";
				formObj.submit();
			}
			else{
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateTrmtCatType&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal_type = trimString(xmlHttp.responseText);
				retVal_type = localTrimString(retVal_type);
				if(retVal_type.length>1){
					var retVal_type_arr = retVal_type.split("~")
					for(k=0;k<=retVal_type_arr.length;k++){
						if(retVal_type_arr[k] != "EXTRACT" && trmt_category_type == retVal_type_arr[k]){
							var moblty_flag="";
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&site_type="+site_type;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateCheckMobility&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText);
							retVal = localTrimString(retVal);
							if(retVal.length > 0){
								moblty_flag = retVal;
							if(moblty_flag=="Y" ){//
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateMobilityDisplayCondition&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal1 = trimString(xmlHttp.responseText);
								retVal1 = localTrimString(retVal1);
								if(retVal1!='Y'){
										var confirm_msg=window.confirm(getMessage("APP-OH000123","OH"));
										if(confirm_msg==true){
											formObj.submit();
											moblty_confirm="Y";
										}else{
											moblty_flag="";
											moblty_confirm="N";
										messageFrame.location.href="../../eCommon/jsp/error.jsp" ;
										}
									}else{
										formObj.submit();
									}
								}else{
									formObj.submit();
								}
							}else{
								formObj.submit();
							}
						}
					}
				}
				if(trmt_category_type == "EXTRACT"){
					formObj.submit();
				}
			}
			
			if(status != "E"){
				//if(trmt_category_type == "EXTRACT"){
				//Added super_tooth_ref by Sridevi Joshi on 2/12/2010 for IN019265 
				if(trmt_category_type == "EXTRACT" && (super_tooth_ref == "" || super_tooth_ref == "null" || super_tooth_ref == null || super_tooth_ref == "undefined" || super_tooth_ref == undefined )){
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

			var view_frame = parent.parent.conditionDentalChartView;
			view_frame.expandMenu('menuET',view_frame.document.forms[0].ET_arrow);
			view_frame.expandMenu('menuET',view_frame.document.forms[0].ET_arrow);

			//Added by Sridevi Joshi on 1/19/2010 for IN010939(SRR20056-CRF-0490).To refresh the Summary Menu once GS is recorded.
			view_frame.expandMenu('menuSummary',view_frame.document.forms[0].GS_arrow);
			view_frame.expandMenu('menuSummary',view_frame.document.forms[0].GS_arrow);
			
			//Refreshing the form values with the original params
			var old_params = parent.parent.frames[2].document.forms[0].params.value;
			document.location.href = "../../eOH/jsp/DentalExtTreatment.jsp?"+old_params;
			//parent.f_query_add_mod_middle.document.location.href = "../../eOH/jsp/OHDentalChartSubTabSearch.jsp?"+old_params+"&defaultTab=ExtTreatment";
			parent.f_query_add_mod_middle.document.location.href = "../../eOH/jsp/OHDentalChartSubTabSearch.jsp?"+old_params+"&defaultTab=ExtTreatment"+"&called_from_Ext_Trmt=Y";
			var super_tooth_selected = "N";
			var super_normal_tooth_selected = "N";
			var normal_tooth_selected = "N";

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
				if(site_type != "ARCH" && site_type != "QUAD" && site_type != "THRNG" && site_type != "MAXFS"){ //Added by Sridevi Joshi on 1/21/2010 for IN010894
					//if(super_tooth_selected == "Y" || super_normal_tooth_selected == "Y" || normal_tooth_selected == "Y"){//Added by Sridevi Joshi on 2/22/2010 for IN010894 ---uncomment for screen changes
						var imageId = "R"+tooth_no;
						dentalChartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "','','"+super_tooth_ref+"')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>";

						var imageId = "T"+tooth_no;
						dentalChartFormObj.document.getElementById(imageId).innerHTML = "<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "','','"+super_tooth_ref+"')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'></div>";

						dentalChartFormObj.document.getElementById(tooth_no).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_no+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table>";
					//}
				}
			}

			//Added by Sharon Crasta on 2/9/2010 for SRR20056-CRF-0475(IN010868)
			//Added becoz the Extraction should be inserted 1st and then the pontic tooth should be updated against the extracted record.
			if(status != "E" && trmt_category_type == "EXTRACT" && modalReturnedVal != "undefined" && modalReturnedVal != undefined && modalReturnedVal != "" && modalReturnedVal != "null" && modalReturnedVal != null){
					if(formObj.pontic_tooth_values.value != ""){
						var modalReturnedValForBridge = formObj.pontic_tooth_values.value+"$$"+modalReturnedVal;
					} else{
						var modalReturnedValForBridge = modalReturnedVal;
					}
					
					
					/*var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params_pontic_update = "func_mode=getMaxChartLineNum&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=EXTRACT";
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_update,false);
					xmlHttp.send(xmlDoc);
					var retVal_max_chart_line_num = trimString(xmlHttp.responseText); 
					retVal_max_chart_line_num = localTrimString(retVal_max_chart_line_num);

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params_pontic_update = "func_mode=updateCutPonticTooth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+retVal_max_chart_line_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&tooth_nos="+modalReturnedVal+"&treatments_outcome="+treatments_outcome+"&trmt_category_type=EXTRACT";
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_update,false);
					xmlHttp.send(xmlDoc);
					var retVal_pontic_tooth = trimString(xmlHttp.responseText); 
					retVal_pontic_tooth = localTrimString(retVal_pontic_tooth);

					var modalReturnedVal_arr = modalReturnedVal.split("$$");
					if(retVal_pontic_tooth.length > 0){	
						if(modalReturnedVal_arr != ""){
							for(k =0; k < pontic_tooth_split_values.length; k++){
							
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params_pontic_update = "func_mode=getMaxChartLineNum&tooth_no="+pontic_tooth_split_values[k]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=BRIDGE";
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_update,false);
								xmlHttp.send(xmlDoc);
								var retVal_max_chart_line_num = trimString(xmlHttp.responseText); 
								retVal_max_chart_line_num = localTrimString(retVal_max_chart_line_num);

								var params_pontic_bridge_update = "func_mode=updateCutPonticTooth&tooth_no="+pontic_tooth_split_values[k]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+retVal_max_chart_line_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&tooth_nos="+modalReturnedValForBridge+"&treatments_outcome="+treatments_outcome+"&trmt_category_type=BRIDGE";
							
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_bridge_update,false);
								xmlHttp.send(xmlDoc);
								var retVal_pontic_bridge_tooth = trimString(xmlHttp.responseText); 
								retVal_pontic_bridge_tooth = localTrimString(retVal_pontic_bridge_tooth);


							}
						}
					} */
			   var modalReturnedVal_arr = modalReturnedVal.split("$$");
				for(k = 0; k < modalReturnedVal_arr.length; k++){
					 var imageId = "T"+modalReturnedVal_arr[k];
					 dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
				 }
			} 
			//End

			if(site_type == "TOOTH" || site_type == "THRNG"){
				//imageReplace(trmt_category_type,tooth_no,dentalchartFormObj,site_type,status);
				imageReplace(trmt_category_type,tooth_no,dentalchartFormObj,site_type,status,chart_num,'','','','','','','','','',retained_tooth_no,treatments_outcome);

			}
			if(clinical_group_code != ""){
				parent.f_query_add_mod_middle.document.forms[0].oh_clinical_group.disabled = "true";
			}
			

			//if(super_tooth_selected == "Y" || super_normal_tooth_selected == "Y" || normal_tooth_selected == "Y"){//Added by Sridevi Joshi on 2/22/2010 for IN010894 ---uncomment for screen changes
				if(site_type == "CROWN"){
					if (moblty_confirm!="N"){
						var surface_ref_arr=surface_ref.split(",");
						if (surface_ref_arr.length>1){
							for(var i=0;i<surface_ref_arr.length;i++){	
								fillCrownImages( 'toothLayer'+tooth_no,surface_ref_arr[i],dentalChartFormObj,trmt_category_type,status,tooth_no,'',super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded);
								drawCircleForCusp(tooth_no,dentalChartFormObj,status,cusptip_ref,surface_code,tab_name,super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded);//added by parul for CRF#0483 on 26/08/2009
							}
						 }else{
								fillCrownImages( 'toothLayer'+tooth_no,surface_code,dentalChartFormObj,trmt_category_type,status,tooth_no,'',super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded);
								drawCircleForCusp(tooth_no,dentalChartFormObj,status,cusptip_ref,surface_code,tab_name,super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded);//added by parul for CRF#0483 on 26/08/2009
							
						 }
					}
				}
				else if(site_type == "ROOT"){
					if (moblty_confirm!="N"){
						drawLineForRootImage('rootLayer'+tooth_no,surface_code,dentalChartFormObj,treatment_category_type,"ET",tooth_no,status,super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded,treatments_outcome);
					
					}
				}
				else if(site_type == "THRNG" || site_type == "TOOTH" && tooth_no.indexOf(",") != -1){
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
						}
						var tooth_sn = tooth_no_arr[k];
						if(mixed_dentition_YN == "Y" && (mapped_tooth_no == null || mapped_tooth_no == "null" || mapped_tooth_no == "" )){//This is to remove images for extream 3 tooth (in case of MD chart) when we record mark error on any of the treatments..
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
				
							var imageId = "R"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>"

							var imageId = tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="&nbsp;";
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

							var imageId = tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="&nbsp;";
						}
					}
				}else { 
					//block is added by parul on 7/10/2009
					//this block is for in permanent chart record erupted,extraction,Mark erupted as error than extraction,now root and crown Images was comng,after refresh it was not comng
					if( site_type == "TOOTH"  && permanent_deciduous_flag=="P" && (tooth_no =="1" || tooth_no =="16" || tooth_no =="17" || tooth_no =="32")){
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
			//}

			if(super_tooth_ref == "RD"){
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
				getImageFromDB(tooth_no,site_type,chart_num,"ET",document.forms[0],dentalchartFormObj,'',super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded); //super_tooth_ref is added by Sridevi Joshi on 12/9/2009 for SUPRTH new Changes
			//}

			dentalchartFormObj.chart_hdr_insert_yn.value = "N";
			ET_Tab_Reset(formObj,site_type,tooth_no,thrng_nos);
		}
	}
}

//imageReplace Function was here..
//This function is shifted from DenralCondition.js to make this function common for both DentlCondition and DentalExternalTreatment.
	function imageReplace(condition_type,tooth_no,dentalchartFormObj,site_type,status,chart_num,super_before,show_RTDESTH_EXFOLTH_image_flag,hide_image_yn,mixed_dent_deciduous_yn,super_yn_1,super_key_num,isSuprthError,surface_code,isExfolthError,retained_tooth_no,treatments_outcome,image_source){
		
	// added by parul(added mixed_dent_deciduous_yn becoz when u record tooth trmt,supernum,Deciduoud now tooth no is D,Ds if u mark tooth trmt as error that tooth no is gong to change as 6,6s..it should be D,Ds so that we added mixed_dent_deciduous_yn in  imageReplace function )
	var numbering_system = document.forms[0].tooth_numbering_system.value;
	var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
	var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
	var patient_id = document.forms[0].patient_id.value;
	var chart_num = document.forms[0].chart_num.value;
	var super_tooth_ref = document.forms[0].super_tooth_ref.value;
	var RD_Normal_yn = document.forms[0].RD_Normal_yn.value;
	var ref_tooth_no = document.forms[0].ref_tooth_no.value;
	var other_chart_facility_id = document.forms[0].other_chart_facility_id.value;
	var oh_chart_level = document.forms[0].oh_chart_level.value;
	var super_tooth_ref = document.forms[0].super_tooth_ref.value;
	//var retained_tooth_no = "";
	var tooth_num = "";
	var tooth_name = "";
	var mapped_tooth_no = "";
	var mixed_dent_tooth_no = "";	
	var isSuperCondYN = "";
	var isRetndCondYN = "";
	var super_cnt = "";

	

	if(condition_type != null && condition_type != "null" && condition_type != "" && condition_type != "undefined"){

		if(ref_tooth_no == "" || ref_tooth_no == "null" || ref_tooth_no == null || ref_tooth_no == "undefined" || ref_tooth_no == undefined){ //Added by Sridevi Joshi when recording conditions from data entry
			if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
				RD_Normal_yn = "MR";
			}
		}

		if(retained_tooth_no == "undefined" || retained_tooth_no == undefined){
			retained_tooth_no = "";
		}

		//Added by SRidevi Joshi on 1/19/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
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
						//var RD_Normal_yn  = document.forms[0].RD_Normal_yn.value; // This value will be 'S' if we record any condition on supernumary tooth (ex : on 12s)

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
						params = "func_mode=checkSuperKey&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn;

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
						var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH&RD_Normal_yn="+RD_Normal_yn;
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
					}
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
							var s = 0;
							var j = 0;
							var oh_chart_level = document.forms[0].oh_chart_level.value;
							var other_chart_facility_id = document.forms[0].other_chart_facility_id.value;

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params_pontic_update = "func_mode=getMaxChartLineNum&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=BRIDGE";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_update,false);
							xmlHttp.send(xmlDoc);
							var retVal_max_chart_line_num = trimString(xmlHttp.responseText); 
							retVal_max_chart_line_num = localTrimString(retVal_max_chart_line_num);

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params_bridge_extract = "func_mode=getPonticCutToothValues&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+retVal_max_chart_line_num+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&trmt_category_type=BRIDGE";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_bridge_extract,false);
							xmlHttp.send(xmlDoc);
							var retVal_bridge = trimString(xmlHttp.responseText); 
							retVal_bridge = localTrimString(retVal_bridge);
							
							if(retVal_bridge.length > 0){
								var retVal_pontic = retVal_bridge.split("##");
								var code_desc_arr = retVal_pontic[0].split("$$");
								var code_desc_arr_str = code_desc_arr.join("~~");
								if(code_desc_arr_str.length > 0){
								   for(var k=0;k<code_desc_arr.length;k++){
									   if(tooth_no == code_desc_arr[k]){
											if(treatments_outcome=="F"){
												var imageId = "T"+code_desc_arr[k];
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
																	
												var imageId = "R"+code_desc_arr[k];
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
												break;
											}else{
												var imageId = "T"+code_desc_arr[k];
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
																	
												var imageId = "R"+code_desc_arr[k];
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
												break;
											}
										}else{
											if(treatments_outcome=="F"){
												var imageId = "T"+tooth_no;
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_EF.gif' width='45' height='25'/>";
										
												var imageId = "R"+tooth_no;
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
											}else{
												var imageId = "T"+tooth_no;
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_E.gif' width='45' height='25'/>";
										
												var imageId = "R"+tooth_no;
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
											
											}
										 }
								   }
								}
								else{
									
									if(treatments_outcome=="F"){
										var imageId = "T"+tooth_no;
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_EF.gif' width='45' height='25'/>";
								
										var imageId = "R"+tooth_no;
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
									}else{
										var imageId = "T"+tooth_no;
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_E.gif' width='45' height='25'/>";
								
										var imageId = "R"+tooth_no;
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
									}
								} 
							}else{
								
								if(treatments_outcome=="F"){
									var imageId = "T"+tooth_no;
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_EF.gif' width='45' height='25'/>";

									var imageId = "R"+tooth_no;
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
								}else{
									var imageId = "T"+tooth_no;
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_E.gif' width='45' height='25'/>";

									var imageId = "R"+tooth_no;
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
								}
							}
							/*var imageId = "T"+tooth_no_arr[k];
							//Commented and Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868)
							//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height='25'/>";
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_EF.gif' width='45' height='25'/>";
						
							//var imageId = "R"+tooth_no_arr[k];
							//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height=34'/>";

							var imageId = "R"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img  src='../../eOH/images/spacer.gif' width='45' height=34'/>";	*/
						}else{
							var imageId = "T"+tooth_no_arr[k];
							//Commented and Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868)
							//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height='25'/>";
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_E.gif'/>";
						
							/*var imageId = "R"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height=34'/>";*/

							var imageId = "R"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
						}
					}
					else if(condition_type == "BRIDGE" && hide_image_yn == "N"){
						if(treatments_outcome == "F"){
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_EF.gif' width='45' height='25'/>";
						}else{
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_E.gif' width='45' height='25'/>";
						}
					} //End
					else if(condition_type == "DENTURE"){
						var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src=' "+image_source+" '>";
						var imageId = "R"+tooth_no_arr[k];
						if(treatments_outcome=="F"){
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_root_EF.gif'>";

						}else{
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_root_E.gif'>";
						}

					}else if(condition_type == "CROWN" && surface_code == "*A"){//Added by parul on 21/01/2010 for CRF-422
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
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownUp_EF.gif' width='45' height='25'/>";
							}else{
							   	dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownUp_E.gif' width='45' height='25'/>";
							}
						}else{
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img width='45' height='25' src=' "+image_source+" '>";
						}
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
					//var RD_Normal_yn = document.forms[0].RD_Normal_yn.value
					var query_tooth_no = tooth_no;
					if(mixed_dentition_YN == "N" && permanent_deciduous_flag == "D"){ // For Deciduous Chart
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
						if(retVal.length > 0){
							disply_tooth_no = retVal;

						}
					}
					//if(RD_Normal_yn != "S" && RD_Normal_yn != "N" && RD_Normal_yn != ""){
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
					//}
				
					var check_num_id = "check_num"+tooth_no;
					/*if(RD_Normal_yn == "NS"){ //Mark error of condition recorded on supernumerary tooth
					  dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','S')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
					}
					else{
						dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
					}*/
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

				if(condition_type == "EXTRACT"){
					//super_tooth_ref
					//To retrieve chart_line_num if ERUPTH is recorded
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					//var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&trmt_category_type=EXTRACT&super_tooth_no="+super_tooth_no;
					var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForExtractionConditions&"+params,false);
					xmlHttp.send(xmlDoc);
					var extract_retVal = trimString(xmlHttp.responseText);
					extract_retVal = localTrimString(extract_retVal);
					
					if(parseInt(extract_retVal) >= 1){
						var imageId = "T"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img height= '25' src='../../eOH/images/MissingTeeth.gif'>";

						var imageId = "R"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='3' height='34'/><img height= '25' src='../../eOH/images/MissingTeeth.gif'>";
					}
					else{
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
					//Added by Sharon Crasta on 2/23/2010 for SRR20056-CRF-0475 (IN010868)
					var pontic_tooth_split_values = new Array();
					var modalReturnedVal = "";
										
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params_bridge_extract = "func_mode=getOutcomeForExtraction&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+retVal_max_chart_line_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=BRIDGE";
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_bridge_extract,false);
					xmlHttp.send(xmlDoc);
					var retVal_outcome_bridge = trimString(xmlHttp.responseText); 
					retVal_outcome_bridge = localTrimString(retVal_outcome_bridge);

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

					if(retVal_bridge_extract.length > 0){
						//if(treatments_outcome=="F"){
						if(retVal_outcome_bridge == "F"){
							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_EF.gif' width='45' height='25'/>";
						}else{
							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_E.gif' width='45' height='25'/>";
						}
					}
					pontic_tooth = retVal_bridge_extract.split(",") ;
					if(tooth_no == (retVal_bridge_extract.substring(retVal_bridge_extract.lastIndexOf("$")+1,retVal_bridge_extract.length))){	// toothno == to the last number in the bridge 
						for(i = pontic_tooth.length-1;i >= 0;i--,j++){

							pontic_tooth_split_values[j] = pontic_tooth[i].substring((pontic_tooth[i].lastIndexOf("$")+1),pontic_tooth[i].length) ;

						} 
					}else{
						for(i = 0; i < pontic_tooth.length;i++){
							pontic_tooth_split_values[i] = pontic_tooth[i].substring((pontic_tooth[i].lastIndexOf("$")+1),pontic_tooth[i].length) ;
						} 
					}
					if(retVal_bridge_extract.length > 0){
						var retVal_pontic = document.forms[0].pontic_tooth_values.value;
						var code_desc_arr = retVal_pontic.split("$$");
						var code_desc_arr_str = code_desc_arr.join("~~");
						if(code_desc_arr_str.length > 0){
						   for(var k=0;k<code_desc_arr.length;k++){
							   	//if(treatments_outcome=="F"){
							   	if(retVal_outcome_bridge == "F"){
									var imageId = "T"+code_desc_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_EF.gif' width='45' height='25'/>";
															
									var imageId = "R"+code_desc_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
							   }else{
							   	   var imageId = "T"+code_desc_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_E.gif' width='45' height='25'/>";
															
									var imageId = "R"+code_desc_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
							   }
						   }
						}
					}//End	
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
				/*else if(condition_type == "TOOTHTM" && site_type == "TOOTH"){
					var imageId = "toothLayer"+tooth_no;
					fillCrownImages(imageId,"ALL",dentalchartFormObj,condition_type,status,tooth_no);
					var imageId = "rootLayer"+tooth_no;
					drawLineForRootImage(imageId,"ALL",dentalchartFormObj,condition_type,"ET",tooth_no,status);
				}*/
			}
			else{
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
						params = "func_mode=checkSuperKey&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn;

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
						var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH&RD_Normal_yn="+RD_Normal_yn;
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
					else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && super_yn != "Y" && RD_yn == "D" && super_recorded == "N"){ // Exfoliation on Deciduous Tooth Condition in Mixed Dentition - Permanent Chart
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
					
					if(mixed_dentition_YN == "Y" && (tooth_no == "2" || tooth_no == "3" || tooth_no == "14" || tooth_no == "15" || tooth_no == "18" || tooth_no == "19" || tooth_no == "30" || tooth_no == "31")){//Added by Sridevi Joshi on 2/19/2010 for extreame tooth in Mixed Chart
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
					/*
					if(RD_Normal_yn == "undefined" || RD_Normal_yn == undefined){
						RD_Normal_yn = "";
					}
					
					dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','"+RD_Normal_yn+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + disply_tooth_no + "</font></a><A onclick=\"populateMenuOnSuper('"+tooth_no+ "','" +disply_tooth_no+ "','"+RD_Normal_yn+"','"+super_key_num+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>+</a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" >";
					*/

					if(super_tooth_ref != "" && super_tooth_ref != "undefined" && super_tooth_ref != undefined){//Added by Sridevi Joshi on 1/22/2010 for IN010894
						eval("dentalchartFormObj.document.getElementById('"+super_tooth_ref+"_super_font"+tooth_no+"')").style.backgroundColor = "gray";
						eval("dentalchartFormObj.document.getElementById('"+super_tooth_ref+"_super_font"+tooth_no+"')").style.color = "white";
						eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')").style.backgroundColor = "white";
						eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')").style.color = "black";
						
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
					//var RD_Normal_yn = document.forms[0].RD_Normal_yn.value;
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
					//var RD_Normal_yn = document.forms[0].RD_Normal_yn.value;
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
					//To retrieve chart_line_num if ERUPTH is recorded
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					//var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&trmt_category_type=EXTRACT&super_tooth_no="+super_tooth_no;

					var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;

					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForExtractionConditions&"+params,false);
					xmlHttp.send(xmlDoc);
					var extract_retVal = trimString(xmlHttp.responseText);
					extract_retVal = localTrimString(extract_retVal);
					if(parseInt(extract_retVal) >= 1){
						var imageId = "T"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img height= '25' src='../../eOH/images/MissingTeeth.gif'>";

						var imageId = "R"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='3' height='34'/><img height= '25' src='../../eOH/images/MissingTeeth.gif'>";
					}
					else{
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
				}
				else if(condition_type == "IMPLANT"){ //Applicable only for Permanent Chart
					var imageId = "T"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src=' "+image_source+" '>";

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
				/*else if(condition_type == "BRIDGE" && hide_image_yn == "Y"){
					if(treatments_outcome=="F"){
						var imageId = "T"+tooth_no;
						//Commented and Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868)
						//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height='25'/>";
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_EF.gif' width='45' height='25'/>";
									
						//var imageId = "R"+tooth_no;
						//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height=34'/>";

						var imageId = "R"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
					}else{
						var imageId = "T"+tooth_no;
						//Commented and Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868)
						//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height='25'/>";
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_E.gif' width='45' height='25'/>";
									
						//var imageId = "R"+tooth_no;
						//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height=34'/>";

						var imageId = "R"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
						
					}									
				}*/
				else if(condition_type == "BRIDGE" && hide_image_yn == "Y"){
					
					var s = 0;
					var j = 0;
					var oh_chart_level = document.forms[0].oh_chart_level.value;
					var other_chart_facility_id = document.forms[0].other_chart_facility_id.value;

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params_pontic_update = "func_mode=getMaxChartLineNum&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=BRIDGE";
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_update,false);
					xmlHttp.send(xmlDoc);
					var retVal_max_chart_line_num = trimString(xmlHttp.responseText); 
					retVal_max_chart_line_num = localTrimString(retVal_max_chart_line_num);

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params_bridge_extract = "func_mode=getPonticCutToothValues&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+retVal_max_chart_line_num+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&trmt_category_type=BRIDGE";
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_bridge_extract,false);
					xmlHttp.send(xmlDoc);
					var retVal_bridge = trimString(xmlHttp.responseText); 
					retVal_bridge = localTrimString(retVal_bridge);
				
					if(retVal_bridge.length > 0){
						var retVal_pontic = retVal_bridge.split("##");
						var code_desc_arr = retVal_pontic[0].split("$$");
						var code_desc_arr_str = code_desc_arr.join("~~");
						if(code_desc_arr_str.length > 0){
						   for(var k=0;k<code_desc_arr.length;k++){
							   if(tooth_no == code_desc_arr[k]){
									if(treatments_outcome=="F"){
										var imageId = "T"+code_desc_arr[k];
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
															
										var imageId = "R"+code_desc_arr[k];
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
										break;
									}else{
										var imageId = "T"+code_desc_arr[k];
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
															
										var imageId = "R"+code_desc_arr[k];
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
										break;
									}
								}else{
									if(treatments_outcome=="F"){
										var imageId = "T"+tooth_no;
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_EF.gif' width='45' height='25'/>";
								
										var imageId = "R"+tooth_no;
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
									}else{
										var imageId = "T"+tooth_no;
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_E.gif' width='45' height='25'/>";
								
										var imageId = "R"+tooth_no;
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
									
									}
								 }
						   }
						}
						else{

							if(treatments_outcome=="F"){
								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_EF.gif' width='45' height='25'/>";
						
								var imageId = "R"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
							}else{
								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_E.gif' width='45' height='25'/>";
						
								var imageId = "R"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
							}
						} 
					}else{

						if(treatments_outcome=="F"){
							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_EF.gif' width='45' height='25'/>";
				
							var imageId = "R"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
						}else{
							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_E.gif' width='45' height='25'/>";
				
							var imageId = "R"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
						}
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

function callCalender(obj,date_obj){
	var called_from_viewchart_yn = document.forms[0].called_from_viewchart_yn.value;
	if(called_from_viewchart_yn != "Y"){
		return showCalendar(date_obj);
	}
	else{
		return false;
	}
}

function clearDentalcondition(){
	var formObj = document.forms[0];
	formObj.oh_treatment.value = "";
}


function showCancelForReasonLink(obj){
	var formObj = document.forms[0];
	var called_from_viewchart_yn = formObj.called_from_viewchart_yn.value;
	if(called_from_viewchart_yn == "Y"){
		if(obj.value == "E"){
			document.getElementById("cancelReason").style.visibility = "visible";
			document.getElementById("MandatoryCancelReason").style.visibility = "visible";
		}
		else{
			document.getElementById("cancelReason").style.visibility = "hidden";
			document.getElementById("MandatoryCancelReason").style.visibility = "hidden";
		}
	}

}

function checkForDuplicateTrmtRecord(status,patient_id,chart_num,tooth_no,trmt_category_type,surface_code,site_type,treatments_outcome){
	if(status != "E"){
		var formObj = document.forms[0];
		var trmt_code = formObj.oh_treatment.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var RD_Normal_yn  = document.forms[0].RD_Normal_yn.value;
		var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
		var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
		var numbering_system = formObj.tooth_numbering_system.value;

		var header_tab = formObj.header_tab.value
	    var retained_tooth_no="";
	    var isRetainedYN="";
		var super_tooth_ref=formObj.super_tooth_ref.value;//added by parul for super changes
		/*  if(super_tooth_ref == "RD"){//Added by parul on 12/17/2009 for RTDESTH new changes
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
		}*/
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

		 if (mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
			
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
						var params = "tooth_no="+mapped_tooth_no+"&numbering_system="+numbering_system;
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
        var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForRTDESTH&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal_Rtdesth = trimString(xmlHttp.responseText);
		retVal_Rtdesth = localTrimString(retVal_Rtdesth); 

		//commented by parul for IN13473 on 11/09/2009(should be able to record duplicate condition on both of super num tooth)

		//	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&trmt_category_type="+trmt_category_type+"&surface_code="+surface_code+"&trmt_code="+trmt_code+"&site_type="+site_type;
		//Added by Sharon Crasta on 2/20/2010 for IN019270
		if(site_type == "THRNG"){
			var tooth_no_range = tooth_no.split(",");
			var tooth_no_range_txt = new Array();
			if(site_type == "THRNG"){
				if(formObj.oh_area.options == "" || formObj.oh_area.options == "null" || formObj.oh_area.options == null || formObj.oh_area.options.length == "undefined" || formObj.oh_area.options == undefined){
					var tooth_no_range_values = formObj.oh_area.value;
					tooth_no_range_txt = tooth_no_range_values.split(",");
				}else{
					for(var tr=0;tr<tooth_no_range.length; tr++) {
						for (var m=0;m<formObj.oh_area.options.length; m++) {
							if(tooth_no_range[tr] == formObj.oh_area.options[m].value){
									tooth_no_range_txt[tr] = formObj.oh_area.options[m].text;
							}
						
						}	
					}
				}
			}
			var k = 0;
			var display_tooth_no_text = new Array();
			var numbering_system = formObj.tooth_numbering_system.value;
			var retVal = "";
			var msg = getMessage("APP-OH00076","OH");
			var msg_arr = msg.split("##");
			var msg_count = 0;
			var mapped_tooth_no ="";
			for(var j = 0;j < tooth_no_range.length; j++){
				var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_range[j]+"&trmt_category_type="+trmt_category_type+"&surface_code="+surface_code+"&trmt_code="+trmt_code+"&site_type="+site_type+"&RD_Normal_yn="+RD_Normal_yn+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&header_tab="+header_tab+"&chart_line_num_Rtdesth=0"+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForDuplicateTrmtRecord&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				retVal=localTrimString(retVal);
				if(retVal.length > 0 && parseInt(retVal) > 0){ //Record Already Present
					msg_count++;
					var trmt_desc_text = formObj.oh_treatment.options[formObj.oh_treatment.options.selectedIndex].text;
					display_tooth_no_text[k] = tooth_no_range_txt[k];
					k++;
			
				}
			}
			if(msg_count > 0){
				alert(msg_arr[0]+"'"+trmt_desc_text+"'"+msg_arr[1]+display_tooth_no_text+msg_arr[2]);
				return false;
			}
		}else{ //End
		    if (site_type == "MAXFS"){
			var tooth_no1=tooth_no;
			var organ_code=formObj.oh_surface.value;
			var sub_organ_code=formObj.oh_sub_parts.value;
			var intraoral_extraoral=formObj.oh_area.value;
			var called_from_viewchart_yn=formObj.called_from_viewchart_yn.value;
			if(typeof formObj.oh_selected_sub_parts!="undefined"){
			//var tooth_no=formObj.oh_selected_sub_parts.value;
			var tooth_no="";
			var thrng_nos_ref="";
            	if(formObj.oh_sub_parts.value=="TNGAB" || formObj.oh_sub_parts.value=="TNGGM" || formObj.oh_sub_parts.value=="TNGAG" ||			formObj.oh_sub_parts.value=="TNGGAM" || formObj.oh_sub_parts.value=="TNGMF"){
						if(thrng_nos_ref=="") {
							if(called_from_viewchart_yn != "Y"){
								for(var m=0;m<formObj.oh_selected_sub_parts.options.length;m++){
									formObj.oh_selected_sub_parts.options[0].selected =false;     
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
					}else{
							tooth_no = formObj.oh_selected_sub_parts.value;
						}
					
			}
            if (tooth_no.indexOf("s")>=0){
				super_tooth_ref=tooth_no.substring(tooth_no.indexOf("s"),tooth_no.length);
				tooth_no=tooth_no.substring(0,tooth_no.indexOf("s"));
            }
			 if (tooth_no.indexOf("r")>=0){
                 retained_tooth_no=tooth_no.substring(0,tooth_no.indexOf("r"));
                 tooth_no=tooth_no.substring(0,tooth_no.indexOf("r"));
			 }
			
			if(typeof formObj.oh_selected_sub_parts!="undefined"){
			var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&trmt_category_type="+trmt_category_type+"&surface_code="+surface_code+"&trmt_code="+trmt_code+"&site_type="+site_type+"&RD_Normal_yn="+RD_Normal_yn+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&header_tab="+header_tab+"&chart_line_num_Rtdesth="+retVal_Rtdesth+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&treatments_outcome="+treatments_outcome+"&organ_code="+organ_code+"&sub_organ_code="+sub_organ_code+"&intraoral_extraoral="+intraoral_extraoral+"&numbering_system="+numbering_system;
			}else{
			var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&trmt_category_type="+trmt_category_type+"&surface_code="+surface_code+"&trmt_code="+trmt_code+"&site_type="+site_type+"&RD_Normal_yn="+RD_Normal_yn+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&header_tab="+header_tab+"&chart_line_num_Rtdesth="+retVal_Rtdesth+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&treatments_outcome="+treatments_outcome+"&organ_code="+organ_code+"&sub_organ_code="+sub_organ_code+"&intraoral_extraoral="+intraoral_extraoral+"&numbering_system="+numbering_system;
			}
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForDuplicateTrmtRecord&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal1 = trimString(xmlHttp.responseText);
			retVal1=localTrimString(retVal1);
			
           if(retVal1.indexOf("$$")>=0)
			{
			retVal1=retVal1.split("$$");
			for(var j=1;j<retVal1.length;j++)
			{
			if(j==1) {
				display_tooth_no_text=retVal1[j];
			}else{
            display_tooth_no_text=display_tooth_no_text+","+retVal1[j];
			}
			
			}var retVal=retVal1[0];	
			}else{
				  if(typeof formObj.oh_selected_sub_parts!="undefined"){
				  display_tooth_no_text = formObj.oh_selected_sub_parts.options[formObj.oh_selected_sub_parts.options.selectedIndex].text;
				  retVal=retVal1;
				  }else{
					  retVal=retVal1;
					  display_tooth_no_text = formObj.oh_sub_parts.options[formObj.oh_sub_parts.options.selectedIndex].text;
				  }
			   }
			
			if(retVal.length > 0 && parseInt(retVal) > 0){ //Record Already Present
				var trmt_desc_text = formObj.oh_treatment.options[formObj.oh_treatment.options.selectedIndex].text;
				
				/*if (site_type == "MAXFS"){
					
				var display_tooth_no_text = formObj.oh_selected_sub_parts.options[formObj.oh_selected_sub_parts.options.selectedIndex].text;
				}else{
				var display_tooth_no_text = formObj.oh_area.options[formObj.oh_area.options.selectedIndex].text;
				}*/
				if(site_type == "ARCH" || site_type == "QUAD" || typeof formObj.oh_selected_sub_parts=="undefined"){
					var msg = getMessage("APP-OH00077","OH");
				}
				else{
					var msg = getMessage("APP-OH00076","OH");
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
				/*if(retVal_SuperKey_arr.length > 1){
					for(var d=0;d<retVal_SuperKey_arr.length-1;d++){
						if(retVal_SuperKey_arr[d] == super_tooth_ref){
							display_tooth_no_text = retVal_SuperKey_arr[d]+"["+display_tooth_no_text+"]";
						}
					}
				}*/
				alert(msg_arr[0]+"'"+trmt_desc_text+"'"+msg_arr[1]+display_tooth_no_text+msg_arr[2]);
				return false;
			}
		   }else{
			var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&trmt_category_type="+trmt_category_type+"&surface_code="+surface_code+"&trmt_code="+trmt_code+"&site_type="+site_type+"&RD_Normal_yn="+RD_Normal_yn+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&header_tab="+header_tab+"&chart_line_num_Rtdesth="+retVal_Rtdesth+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&treatments_outcome="+treatments_outcome;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForDuplicateTrmtRecord&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal=localTrimString(retVal);
			if(retVal.length > 0 && parseInt(retVal) > 0){ //Record Already Present
				
				var trmt_desc_text = formObj.oh_treatment.options[formObj.oh_treatment.options.selectedIndex].text;
				var display_tooth_no_text = formObj.oh_area.options[formObj.oh_area.options.selectedIndex].text;
				if(site_type == "ARCH" || site_type == "QUAD"){
					var msg = getMessage("APP-OH00077","OH");
				}
				else{
					var msg = getMessage("APP-OH00076","OH");
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
            
				  alert(msg_arr[0]+"'"+trmt_desc_text+"'"+msg_arr[1]+display_tooth_no_text+msg_arr[2]+"("+Surface_label+"#"+retVal_surface_arr2+")");

              }else{
				alert(msg_arr[0]+"'"+trmt_desc_text+"'"+msg_arr[1]+display_tooth_no_text+msg_arr[2]);
			  }
				return false;
			}
		}
		}
		
	}
	return true;
}

//Function to disable all special characters
/*function CheckForOHSpecChars(event){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
 }*/
  function CheckForOHSpecChars(event){
	if((event.keyCode==61) || (event.keyCode==43) || (event.keyCode==163) || (event.keyCode==96) || (event.keyCode==126) || (event.keyCode==64) || (event.keyCode==35) || (event.keyCode==36) || (event.keyCode==37) || (event.keyCode==38) || (event.keyCode==42) || (event.keyCode==40) || (event.keyCode==41) || (event.keyCode==45) || (event.keyCode==95) || (event.keyCode==91) || (event.keyCode==93) || (event.keyCode==123) || (event.keyCode==125) || (event.keyCode==92) || (event.keyCode==124) || (event.keyCode==59) || (event.keyCode==58) || (event.keyCode==39) || (event.keyCode==34) || (event.keyCode==44) || (event.keyCode==46) || (event.keyCode==47) || (event.keyCode==60) || (event.keyCode==62) || (event.keyCode==63) || (event.keyCode==62) || (event.keyCode==60) ||(event.keyCode==36)||(event.keyCode==94) ||(event.keyCode==126)||(event.keyCode==37)||(event.keyCode==33)||(event.keyCode==38)){
	return false; 
		}
	}



function populateAllTrmtCategories(site){
	//selected_tooth_count = 0; // commented on 08/10/07 by sridevi (count was bcoming zero when u select 2 tooth and click on the tooth no(after populating menu) and if u try to select 3 rd tooth count was becoming 0)
	var formObj = document.forms[0];
	var params = "";
	var tab_name = "ET";
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

function clearBean(){
	var dummy="dummy";
	var xmlStr ="<root><SEARCH ";
	xmlStr+=" dummy=\""+ dummy + "\" ";
	xmlStr +=" /></root>";
	return fieldValidation(xmlStr,"clearBean");
}

function fieldValidation(xmlStr,source){
	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DentalRules.jsp?func_mode="+source,false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(trimString(responseText));
    return true;
}

//written by parul on 24/08/2009 for CRf 0483
function populateCuspTip(obj){
	var formObj = document.forms[0];
	var tooth_num="";
	var tooth_name="";
	var mapped_tooth_no="";
	var mixed_dent_tooth_no="";
	var condition_type="";
	var condition_type1="";
	var disply_tooth_no="";
	var surface_ref="";
	var tooth_no_hid=formObj.oh_area.value;
	var chart_num=formObj.chart_num.value;
	var patient_id=formObj.patient_id.value;
	var permanent_deciduous_flag=formObj.permanent_deciduous_flag.value;
	var mixed_dentition_YN=formObj.mixed_dentition_YN.value;
	var tooth_numbering_system=formObj.tooth_numbering_system.value;
	var super_tooth_ref=formObj.super_tooth_ref.value;

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
		for(var i=0;i<retVal_arr1.length-1;i++){
			condition_type1 = retVal_arr1[i];
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
				tooth_num = retVal_arr[0];
				tooth_name = retVal_arr[1];
				mapped_tooth_no = retVal_arr[2];
				mixed_dent_tooth_no = retVal_arr[3];
			}

			if((permanent_deciduous_flag=="D" || permanent_deciduous_flag=="P") && mixed_dentition_YN=="Y"){
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
						if (mapped_tooth_no=="" || mapped_tooth_no=="null" || mapped_tooth_no==null) {
							tooth_no_hid=formObj.oh_area.value;	
						}
					}else if (permanent_deciduous_flag=="D" && mixed_dentition_YN=="Y" ){
						if (condition_type1=="ERUPTH" || condition_type1=="PARERTH") {
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
	 //added by parul for CRF#0483 on 21/01/2010
	 for(var m=0;m<formObj.oh_surface.options.length;m++){
		 formObj.oh_surface.options[0].selected =false;  
		if(formObj.oh_surface.options[m].selected==true){

			if(surface_ref==""){
				surface_ref=formObj.oh_surface.options[m].value;
			}else{
				surface_ref=surface_ref+","+formObj.oh_surface.options[m].value;
			}
	   }
   }
    var surface_ref_all="";
    for(var m=0;m<formObj.oh_surface.options.length;m++){
		 if(!formObj.oh_surface.options[0].selected){
		     document.forms[0].surface_ref.value="";
		 }else{
		     surface_ref_all=document.forms[0].surface_ref.value;
		 }
	}
   if (surface_ref_all=="*A"  && formObj.called_from_viewchart_yn.value != 'Y'){
	   surface_ref="*A";
	   tooth_no_hid="";
	 //  document.forms[0].surface_ref.value="";
   }
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
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
//written by parul on 24/08/2009 for CRf 0483 

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


