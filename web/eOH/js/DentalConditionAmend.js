var area_legend;
var tab_name = "DC";

// Copied from jsp
function amendCondition(){
	var tooth_no ;
	var status = "";
	var formObj=document.forms[0];
	var messageFrame = parent.parent.parent.parent.parent.messageFrame;
	var patient_id = formObj.patient_id.value;
	var site_type = formObj.site.value;
	var surface = formObj.oh_surface.value;
	var chart_num = formObj.chart_num.value;
	var surface_code = formObj.oh_surface.value;
	surface_code = formObj.surface_hid.value;  //Surface from RHS menu
	status = formObj.oh_status.value; 
	var dentalChartFormObj = parent.parent.conditionDentalChartDetails;
	var condition_type = formObj.condition_type.value;
	var thrng_nos_ref = formObj.thrng_nos_ref.value;
	var clinical_group_code = parent.f_query_add_mod_middle.document.forms[0].oh_clinical_group.value;

	if(site_type == "THRNG" && thrng_nos_ref != ""){
		tooth_no = formObj.thrng_nos_ref.value;
	}
	else if(site_type == "THRNG" && thrng_nos_ref == ""){
		for (var m=0;m<formObj.area.options.length-1; m++) {
			if (formObj.area.options[m].selected == true) {
				if(thrng_nos_ref == ""){
					thrng_nos_ref = formObj.area.options[m].value; 
				}
				else{
					thrng_nos_ref = thrng_nos_ref+","+formObj.area.options[m].value; 
				}
			}
		}
		formObj.thrng_nos_ref.value = thrng_nos_ref;
		tooth_no = thrng_nos_ref;
	}
	else{
		tooth_no = formObj.area.value;
	}
	if(formObj != null){
		var status_title=getLabel("Common.status.label","Common");
		var fields = new Array (formObj.oh_status);
		var names = new Array ( status_title);
		if(checkFieldsofMst( fields, names, messageFrame)){	
			var dentalchartFormObj = parent.parent.conditionDentalChartDetails.document.forms[0];
			var thrng_nos = formObj.thrng_nos.value;
			formObj.chart_hdr_insert_yn.value  = dentalchartFormObj.chart_hdr_insert_yn.value;
			var chart_num  = dentalchartFormObj.chart_num.value;
			formObj.submit();

			//Refreshing the form values with the original params
			var old_params = parent.parent.frames[2].document.forms[0].params.value;
			document.location.href = "../../eOH/jsp/DentalCondition.jsp?"+old_params;

			parent.f_query_add_mod_middle.document.location.href = "../../eOH/jsp/OHDentalChartSubTabSearch.jsp?"+old_params+"&defaultTab=DentalCondition";

			// Call the expandMenu twice to reload the page
			parent.parent.frames[2].expandMenu('menuDC',parent.parent.frames[2].document.forms[0].DC_arrow);
			parent.parent.frames[2].expandMenu('menuDC',parent.parent.frames[2].document.forms[0].DC_arrow);
			if(site_type == "TOOTH" || site_type == "THRNG"){
				imageReplace(condition_type,tooth_no,dentalchartFormObj,site_type,status);
			}
			
			if(clinical_group_code != ""){
				parent.f_query_add_mod_middle.document.forms[0].oh_clinical_group.disabled = "true";
			}
			//DC_Tab_Reset(formObj,site_type,tooth_no,thrng_nos);
			if(site_type == "CROWN"){				
				tooth_no = 'toothLayer'+tooth_no;
				fillCrownImages(tooth_no,surface_code,dentalChartFormObj,condition_type,status);
			}else if(site_type == "ROOT"){
				// "E" to draw a white line on the existing line
				drawLineForRootImage('rootLayer'+tooth_no,surface_code,dentalChartFormObj,condition_type,tab_name,tooth_no,"E");
			}else{
				//if(condition_type != "MISSTH" && condition_type != "EXFOLTH" && status != 'E'){
				if(condition_type != "EXFOLTH"){
					getImageFromDB(tooth_no,site_type,chart_num,tab_name,document.forms[0]);
				}
			}
			dentalchartFormObj.chart_hdr_insert_yn.value = "N";			
		}
	}
}

function imageReplace(condition_type,tooth_no,dentalchartFormObj,site_type,status){
	if(site_type == "ARCH"){
		var imageId = "A"+tooth_no;
	}else if(site_type == "QUAD"){
		var imageId = "Q"+tooth_no;
	}else if(site_type == "TOOTH"){
		var imageId = tooth_no;
	}
	if(site_type == "THRNG"){
		var tooth_no_arr = tooth_no.split(",");
		for(var k=0;k<tooth_no_arr.length;k++){
			if(status == 'E'){
				if( condition_type == "MISSTH"){
					var imageId = "T"+tooth_no_arr[k];
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/T.gif'>";

					var imageId = "R"+tooth_no_arr[k];
					var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='"+imageSrc+"'>";
				}
				else if(condition_type == "UNERTH"){
					var imageId = "T"+tooth_no_arr[k];
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/T.gif'>";

					var imageId = "R"+tooth_no_arr[k];
					var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='"+imageSrc+"'>";
				}
				else if(condition_type == "EXFOLTH"){
					var imageId = "T"+tooth_no_arr[k];
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/T.gif'/>";

					var imageId = "R"+tooth_no_arr[k];
					var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='"+imageSrc+"'>";
				}
				//else{
					//var imageId = tooth_no_arr[k];
					//dentalchartFormObj.document.getElementById(imageId).innerHTML ="&nbsp;";
				//}
				
			}
			else{
				if( condition_type == "MISSTH"){
					var imageId = "T"+tooth_no_arr[k];
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img height= '25' src='../../eOH/images/MissingTeeth.gif'>";

					var imageId = "R"+tooth_no_arr[k];
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='3' height='34'/><img height= '25' src='../../eOH/images/MissingTeeth.gif'>";
				}
				else if(condition_type == "UNERTH"){
					var imageId = "T"+tooth_no_arr[k];
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

					var imageId = "R"+tooth_no_arr[k];
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
				}
				else if(condition_type == "EXFOLTH"){
					var imageId = "T"+tooth_no_arr[k];
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

					var imageId = "R"+tooth_no_arr[k];
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
				}
			}
		}
	}
	
	else{
		if(status == 'E'){
			if( condition_type == "MISSTH"){
				var imageId = "T"+tooth_no;
				dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/T.gif'>";

				var imageId = "R"+tooth_no;
				var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
				dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='"+imageSrc+"'>";
			}
			else if(condition_type == "UNERTH"){
				var imageId = "T"+tooth_no;
				dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/T.gif'>";

				var imageId = "R"+tooth_no;
				var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
				dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='"+imageSrc+"'>";
			}
			else if(condition_type == "EXFOLTH"){
				var imageId = "T"+tooth_no;
				dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/T.gif'/>";

				var imageId = "R"+tooth_no;
				var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
				dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='"+imageSrc+"'>";
			}
			
		}

		else{
			if( condition_type == "MISSTH"){
				var imageId = "T"+tooth_no;
				dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img height= '25' src='../../eOH/images/MissingTeeth.gif'>";

				var imageId = "R"+tooth_no;
				dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='3' height='34'/><img height= '25' src='../../eOH/images/MissingTeeth.gif'>";
			}
			else if(condition_type == "UNERTH"){
				var imageId = "T"+tooth_no;
				dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

				var imageId = "R"+tooth_no;
				dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
			}
			else if(condition_type == "EXFOLTH"){
				var imageId = "T"+tooth_no;
				dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

				var imageId = "R"+tooth_no;
				dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
			}
			
		}
	}
}

