

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		           Name		          Rev.Date		        Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
02/11/2017	  	ML-MMOH-CRF-0977(IN065505)    prathyusha 											   TPN Standard ? Request for Offline label should follow TPN Online Label format. 
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

//saved on 02.11.2005
function run() {
	var frmObject = f_query_add_mod.document.formPhWorksheetChartCriteria;

	if(f_query_add_mod.document.formPhWorksheetChartCriteria) {
		var fields= new Array (frmObject.report_by,frmObject.p_disp_locn_code,frmObject.p_worksheet_id);
	var names= new Array (getLabel("Common.reporttype.label","Common"), getLabel("ePH.DispenseLocation.label","PH"),getLabel("ePH.WorksheetID.label","PH"));

		if(checkFields(fields,names,messageFrame) ) {
			if(frmObject.report_by.value =='IVCYTO' ||frmObject.report_by.value =='CMP' )
				frmObject.p_report_id.value ='PHBRWRKSH' ;
				else 
				frmObject.p_report_id.value ='PHBRWRKTP' ;
				f_query_add_mod.document.formPhWorksheetChartCriteria.submit();
		
		}
	}
}




function reset() {
    f_query_add_mod.formPhWorksheetChartCriteria.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

/*function changeLegend(obj){  
	//	alert(	obj.value);

			if (obj.value == "IVCYTO" || obj.value == "CMP" )
				{	parent.document.getElementById("label_drug").innerText="Worksheet ID";
					formPhWorksheetChartCriteria.p_worksheet_id.value="";
					
				}
			else {
					if (obj.value == "TPN")
					{	parent.document.getElementById("label_drug").innerText="TPN Worksheet ID";
					formPhWorksheetChartCriteria.p_worksheet_id.value="";
					}

		}

}
*/
function showResults(){
    var from_date="";
	var to_date	="";
	var report_type		= parent.f_query_add_mod.document.formPhWorksheetChartCriteria.report_by.value;
	var locale		= parent.f_query_add_mod.document.formPhWorksheetChartCriteria.locale.value;
	var patient_class	= parent.f_query_add_mod.document.formPhWorksheetChartCriteria.patient_class.value;
	var stage			= parent.f_query_add_mod.document.formPhWorksheetChartCriteria.stage.value;
	var disp_locn_code	= parent.f_query_add_mod.document.formPhWorksheetChartCriteria.p_disp_locn_code.value;
	from_date		= parent.f_query_add_mod.document.formPhWorksheetChartCriteria.from_date.value;
	to_date			= parent.f_query_add_mod.document.formPhWorksheetChartCriteria.to_date.value;
    from_date=convertDate(from_date,"DMY",locale); 
    to_date=convertDate(to_date,"DMY",locale); 
	parent.f_query_results.location.href="../../ePH/jsp/PhWorksheetChartResult.jsp?report_type="+report_type+"&patient_class="+patient_class+"&stage="+stage+"&disp_locn_code="+disp_locn_code+"&from_date="+from_date+"&to_date="+to_date;
}

function showPrintReport(worksheet_id,report_type,stage,order_status){

	var formObj = parent.f_query_add_mod.formPhWorksheetChartCriteria;

	formObj.p_worksheet_id.value = worksheet_id ;
	
	if(stage == "DL" || order_status == 'DP' || order_status == 'DF')
	{
		if(report_type == "IV" || report_type == "CYTO" || report_type == "CMP")
		{
			formObj.p_report_id.value = "PHBRWRKSH" ;
		}
		else  if(report_type == "TPN")
		{
			formObj.p_report_id.value = "PHBRWRKTP" ;
		}
		// Added for ml-mmoh-crf-0977 start 
		else  if(report_type == "TPNN")
		{
			formObj.p_report_id.value = "PHBRWRKTP" ;
		}
		else  if(report_type == "TPNS")
		{
			formObj.p_report_id.value = "PHBRWRKTP" ;
		}
		// Added for ml-mmoh-crf-0977 end
	}
	else if(stage == "FA")
	{
		if(report_type == "IV" || report_type == "CYTO" || report_type == "CMP")
		{
			formObj.p_report_id.value = "PHBRWRKSH1" ;
		}
		else if(report_type == "TPN")
		{
			formObj.p_report_id.value = "PHBRWRKTP";
		}
		// Added for ml-mmoh-crf-0977 start 
		else if(report_type == "TPNN")
		{
			formObj.p_report_id.value = "PHBRWRKTP";
		}
		else if(report_type == "TPNS")
		{
			formObj.p_report_id.value = "PHBRWRKTP";
		}
		// Added for ml-mmoh-crf-0977 end 
	}

	parent.f_query_add_mod.document.formPhWorksheetChartCriteria.submit();


}
