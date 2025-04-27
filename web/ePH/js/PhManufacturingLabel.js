

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			     Edit History		         Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
02/11/2017	  	ML-MMOH-CRF-0973(IN0065451)  prathyusha 									Request to have re-print option for : 1. TPN Cover Bag label 2. TPN Lipid label
02/11/2017	  	ML-MMOH-CRF-0973(IN0065451)  Narasimhulu 									Request to have re-print option for : 1. TPN Cover Bag label 2. TPN Lipid label
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

//saved on 02.11.2005
function run() {
	var frmObject = f_query_add_mod.document.formPhManufacturingLabelCriteria;
	if(f_query_add_mod.document.formPhManufacturingLabelCriteria) {
		var fields= new Array (frmObject.p_report_id,frmObject.p_disp_locn_code,frmObject.p_worksheet_id);
		var names= new Array (getLabel("Common.reporttype.label","Common"),getLabel("ePH.DispenseLocation.label","PH"),getLabel("ePH.WorksheetID.label","PH"));

		if(checkFields(fields,names,messageFrame) ) {
						f_query_add_mod.document.formPhManufacturingLabelCriteria.submit();
		
		}
	}
}




function reset() {
    f_query_add_mod.formPhManufacturingLabelCriteria.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

function changeLegend(obj)
	{  
			
			if (obj.value == "PHBRMFGLB")
				{	document.getElementById("label_drug").innerText="Worksheet ID";
					formPhManufacturingLabelCriteria.p_worksheet_id.value="";
										
				}
			else if (obj.value == "PHBRMFGTP")
				{	document.getElementById("label_drug").innerText="TPN Worksheet ID";
					formPhManufacturingLabelCriteria.p_worksheet_id.value="";
					
				}
			else if (obj.value == "PHCPMFGLB")
				{	document.getElementById("label_drug").innerText="Compound Worksheet ID";
					formPhManufacturingLabelCriteria.p_worksheet_id.value="";
					
				}
				else if (obj.value == "PHCYTOMFGLB")
				{	document.getElementById("label_drug").innerText="Cyto Worksheet ID";
					formPhManufacturingLabelCriteria.p_worksheet_id.value="";
					
				}
				
			//  Added for ML-MMOH-CRF-0973 start
			else if (obj.value == "PHTPNDISPLBF")
				{	document.getElementById("label_drug").innerText="TPN Worksheet ID";
					formPhManufacturingLabelCriteria.p_worksheet_id.value="";
					
				}
				else if (obj.value == "PHTPNCOB")
				{	document.getElementById("label_drug").innerText="TPN Worksheet ID";
					formPhManufacturingLabelCriteria.p_worksheet_id.value="";
					
				}
				else if (obj.value == "PHTPNSCOB")
				{	document.getElementById("label_drug").innerText="TPN Worksheet ID";
					formPhManufacturingLabelCriteria.p_worksheet_id.value="";
					
				}
				else if (obj.value == "PHTPNLIP")
				{	document.getElementById("label_drug").innerText="TPN Worksheet ID";
					formPhManufacturingLabelCriteria.p_worksheet_id.value="";
					
				}
			// Added for ML-MMOH-CRF-0973  end

			document.formPhManufacturingLabelCriteria.p_report_id.value=obj.value;//ADDED  for ML-MMOH-CRF-1089
		}

function getDuration(ws_type){

		if(ws_type=="PHBRMFGLB" || ws_type == "PHCYTOMFGLB"){
		ws_type = "WS_FINALIZE";
		var wrksht_id = document.formPhManufacturingLabelCriteria.p_worksheet_id.value;
		var disp_locn_code =document.formPhManufacturingLabelCriteria.p_disp_locn_code.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " wrksht_id=\""+wrksht_id+"\"";
		xmlStr += " ws_type=\""+ws_type+"\"";
		xmlStr += " disp_locn_code=\""+disp_locn_code+"\"";
		xmlStr += " bean_id=\"DispMedicationBean\"";
		xmlStr += " bean_name=\"ePH.DispMedicationBean\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","ReportsValidate.jsp?called_from=get_duration",false);
		xmlHttp.send(xmlDoc);
		//alert(xmlHttp.responseText);
		eval(xmlHttp.responseText);  }
		//ws_type=="PHTPNDISPLBF"   || ws_type=="PHTPNCOB" || || ws_type=="PHTPNLIP" added for ML-MMOH-CRF-0973
		else if(ws_type=="PHBRMFGTP" || ws_type=="PHTPNDISPLBF"   || ws_type=="COB" || ws_type=="PHTPNCOB" ||  ws_type=="PHTPNLIP") {
		
			var wrksht_id = document.formPhManufacturingLabelCriteria.p_worksheet_id.value;
			var disp_locn_code =document.formPhManufacturingLabelCriteria.p_disp_locn_code.value;
			//ADDED for ML-MMOH-CRF-1089 START
			if( ws_type=="COB"){
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				var xmlStr ="<root><SEARCH ";
				xmlStr += " wrksht_id=\""+wrksht_id+"\"";
				xmlStr += " bean_id=\"PHReportsBean\"";
				xmlStr += " bean_name=\"ePH.PHReportsBean\"";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","ReportsValidate.jsp?called_from=PRESCRIPTIONTYPE",false);
//				alert(xmlStr);
				xmlHttp.send(xmlDoc);
//				alert(xmlHttp.responseText);
				eval(xmlHttp.responseText); 
			}
			//ADDED FOR  for ML-MMOH-CRF-1089 END
			ws_type = "TPN_WS_FINALIZE";
		
		
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " wrksht_id=\""+wrksht_id+"\"";
		xmlStr += " ws_type=\""+ws_type+"\"";
		xmlStr += " disp_locn_code=\""+disp_locn_code+"\"";
		xmlStr += " bean_id=\"DispMedicationBean\"";
		xmlStr += " bean_name=\"ePH.DispMedicationBean\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","ReportsValidate.jsp?called_from=get_duration",false);
//		alert(xmlStr);
		xmlHttp.send(xmlDoc);
//		alert(xmlHttp.responseText);
		eval(xmlHttp.responseText); 
		} 
		else if(ws_type=="PHCPMFGLB")
				ws_type = "WS_FINALIZE";
	}



function assignDuration(duration,ord_type,repeat_value){
	document.formPhManufacturingLabelCriteria.p_duration_value.value = duration;
	document.formPhManufacturingLabelCriteria.p_ord_type.value = ord_type;
	document.formPhManufacturingLabelCriteria.p_freq.value = repeat_value;
}
//ADDED for ML-MMOH-CRF-1089 START
function in_prep_yn(in_prep_yn){
	
	if(in_prep_yn == "7"){
		
		//document.formPhManufacturingLabelCriteria.p_report_id.value="PHTPNSCOB";
		document.formPhManufacturingLabelCriteria.p_report_id.value="PHTPNSCOB";
	}
	else if(in_prep_yn == "8")
		{
		
		document.formPhManufacturingLabelCriteria.p_report_id.value="PHTPNCOB";
		}
	
}
//ADDED FOR   ML-MMOH-CRF-1089 END
