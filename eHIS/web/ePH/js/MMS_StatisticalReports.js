function run() {
	var frmObject = f_query_add_mod.document.MMS_StatisticalReportsCriteria;
	if(f_query_add_mod.document.MMS_StatisticalReportsCriteria) {
		var fields= new Array (frmObject.p_report_type,frmObject.p_year);
		var names= new Array (getLabel("ePH.reporttype.label","PH"),getLabel("Common.year.label","Common"));
			
		if(checkFields(fields,names,messageFrame)){	
			if(document.f_query_add_mod.window.document.getElementById('fldfacility').style.visibility=='visible')
				frmObject.p_facility_id.value = frmObject.facility_id.value;
			if (frmObject.p_report_type.value == 'CP'){ //Cost per prescription Report
				frmObject.p_report_id.value = 'PHCSTPERPRS';	
			}
			else if (frmObject.p_report_type.value == 'CC'){ //Cost per Capita Report
				frmObject.p_report_id.value = 'PHCSTPERCAP';
			}
			else if (frmObject.p_report_type.value == 'SC'){ //Medication Sales to Customer Report
				frmObject.p_report_id.value = 'PHARAMCOREP';
			}
			else {
				frmObject.p_report_id.value = '';
			}
			f_query_add_mod.document.MMS_StatisticalReportsCriteria.submit();
		}
	}
}


function reset() {
	f_query_add_mod.location.reload();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

function validateMonths(callFrom){
	var formObj = document.MMS_StatisticalReportsCriteria;
	var monthFromObj =formObj.p_fm_month;
	var monthToObj =formObj.p_to_month;
	if( monthFromObj.value > monthToObj.value){
		var msg = getMessage("PH_MUST_GR_EQUAL","PH");
		msg = msg.replace("$",getLabel("Common.MonthTo.label","Common"));
		msg = msg.replace("#",getLabel("Common.MonthFrom.label","Common"));
		alert(msg);
		if(callFrom=='TO')
			monthToObj.selectedIndex=(formObj.p_to_month.length)-1;
		else
			monthFromObj.selectedIndex=0;
	}
}

function checkYear(obj){
    if (obj.value != '' && (obj.value.length<4 || parseInt(obj.value)<=0))  {
		alert(getMessage("PH_INVALID_YEAR","PH"));
		obj.value=document.MMS_StatisticalReportsCriteria.currYear.value;
		obj.focus();
		return false;
    }
}

function dispReqFields(repTypeObj){
	var repTypeVal = repTypeObj.value;
	var formObj = document.MMS_StatisticalReportsCriteria;
	formObj.p_year.value=document.MMS_StatisticalReportsCriteria.currYear.value;
	formObj.p_cust_group_code.selectedIndex=0;
	formObj.p_cust_code.selectedIndex=0;
	formObj.p_policy_type_code.selectedIndex=0;
	formObj.p_fm_month.selectedIndex=0;
	formObj.p_to_month.selectedIndex=(formObj.p_to_month.length)-1;
	if(repTypeVal=='CP' || repTypeVal=='CC'){
		document.getElementById("lblfacility").style.visibility='visible';
		document.getElementById("fldfacility").style.visibility='visible';
		document.getElementById("lblCustGroup").style.visibility='visible';
		document.getElementById("fldCustGroup").style.visibility='visible';
		document.getElementById("lblCustomer").style.visibility='visible';
		document.getElementById("fldCustomer").style.visibility='visible';
		if(repTypeVal=='CC'){
			document.getElementById("lblPolicy").style.visibility='visible';
			document.getElementById("fldPolicy").style.visibility='visible';
		}
		else if(repTypeVal=='CP'){
			document.getElementById("lblPolicy").style.visibility='hidden';
			document.getElementById("fldPolicy").style.visibility='hidden';
		}
		document.getElementById("lblYear").style.visibility='visible';
		document.getElementById("fldYear").style.visibility='visible';
		document.getElementById("lblMonthFrom").style.visibility='visible';
		document.getElementById("fldMonthFrom").style.visibility='visible';
		document.getElementById("lblMonthTo").style.visibility='visible';
		document.getElementById("fldMonthTo").style.visibility='visible';
	}
	else if(repTypeVal=='SC'){
		document.getElementById("lblYear").style.visibility='visible';
		document.getElementById("fldYear").style.visibility='visible';
		document.getElementById("lblfacility").style.visibility='hidden';
		document.getElementById("fldfacility").style.visibility='hidden';
		document.getElementById("lblCustGroup").style.visibility='hidden';
		document.getElementById("fldCustGroup").style.visibility='hidden';
		document.getElementById("lblCustomer").style.visibility='hidden';
		document.getElementById("fldCustomer").style.visibility='hidden';
		document.getElementById("lblPolicy").style.visibility='hidden';
		document.getElementById("fldPolicy").style.visibility='hidden';
		document.getElementById("lblMonthFrom").style.visibility='hidden';
		document.getElementById("fldMonthFrom").style.visibility='hidden';
		document.getElementById("lblMonthTo").style.visibility='hidden';
		document.getElementById("fldMonthTo").style.visibility='hidden';
	}
	else{
		document.getElementById("lblfacility").style.visibility='hidden';
		document.getElementById("fldfacility").style.visibility='hidden';
		document.getElementById("lblCustGroup").style.visibility='hidden';
		document.getElementById("fldCustGroup").style.visibility='hidden';
		document.getElementById("lblCustomer").style.visibility='hidden';
		document.getElementById("fldCustomer").style.visibility='hidden';
		document.getElementById("lblPolicy").style.visibility='hidden';
		document.getElementById("fldPolicy").style.visibility='hidden';
		document.getElementById("lblYear").style.visibility='hidden';
		document.getElementById("fldYear").style.visibility='hidden';
		document.getElementById("lblMonthFrom").style.visibility='hidden';
		document.getElementById("fldMonthFrom").style.visibility='hidden';
		document.getElementById("lblMonthTo").style.visibility='hidden';
		document.getElementById("fldMonthTo").style.visibility='hidden';
	}
}
