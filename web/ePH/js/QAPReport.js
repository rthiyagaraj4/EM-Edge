 //saved on 02.11.2005
function run() 
	{ 
	var frmObject=f_query_add_mod.document.QapReportCriteria;
	var obj=frmObject.group_by; 
	if(f_query_add_mod.document.QapReportCriteria) {
		
		initialize_date(obj);
		var fields= new Array (frmObject.location_type,frmObject.facility_name,frmObject.dt_from1,frmObject.dt_to1);
		var names= new Array (getLabel("Common.QAPReport.label","Common"),getLabel("Common.FacilityName.label","Common"),getLabel("Common.periodfrom.label","Common"),getLabel("Common.periodto.label","Common"));
		
		if(checkFields(fields,names,messageFrame) ){
			
			frmObject.dt_from.value = frmObject.dt_from1.value + " 00:00";
			frmObject.dt_to.value = frmObject.dt_to1.value + " 23:59";
			f_query_add_mod.document.QapReportCriteria.submit();	
	     } 
	}	
}
function reset() {    
	f_query_add_mod.QapReportCriteria.reset();    
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';   
}

function locationLookup(target,inc){
	var formObj = document.QapReportCriteria;
	var facility_name=formObj.facility_name.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ; 
	var dataValueArray = new Array() ; 
	var dataTypeArray  = new Array() ; 
	if (facility_name!=""){

			dataNameArray[0]	= "FACILITY_ID";
			dataValueArray[0]	= formObj.facility_name.value;  
			dataTypeArray[0]	= STRING ;

			argumentArray[0]   = document.getElementById("SQL_PH_PRINT_FACILITIES_SELECT").value;
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "2,3";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( "", argumentArray );
			if(retVal != null && retVal != "" ) {
				if(inc == "1"){ 
					formObj.locn_code1.value=retVal[0];
				}else{
					formObj.locn_code2.value=retVal[0];
				}
			target.value = retVal[1] ;
			} 
	}
	else{
		formObj.facility_name.focus(); 
	 }
}
function chkDate(dt_from,dt_to){ 
	
	var ref=parent.frames[2]; 
	if(doDateCheck(dt_from,dt_to,ref)){
		parent.frames[2].location.href='../../eCommon/jsp/error.jsp'; 
	}
	else{
		dt_from.select(); 
	}
}
function disable_disp(obj){ 
	var formObj = document.QapReportCriteria;
	var report_id=formObj.p_report_id.value;
	var facility=obj.value;
	if(facility == '*A'){
		formObj.p_cond.value="";
		formObj.from_desp_loc.value=""; 
		formObj.to_desp_loc.value="";
		formObj.locn_code1.value="";   
		formObj.locn_code2.value="";
		document.getElementById("disp_lookup").style.display="none";
	 }else{
		 formObj.p_cond.value=obj.value;
		 document.getElementById("disp_lookup").style.display="inline";
	 }   
	if(report_id == 'PHQAPPC1' ){
		if(facility == '*A'){
			formObj.CLAUSE.value="WHERE A.FACILITY_ID=B.ADDED_FACILITY_ID AND A.FACILITY_ID IN(SELECT FACILITY_ID FROM SM_FACILITY_PARAM AND B.ADDED_FACILITY_ID=C.ADDED_FACILITY_ID)";
		}
		else{
			formObj.CLAUSE.value="WHERE A.FACILITY_ID=B.ADDED_FACILITY_ID AND B.ADDED_FACILITY_ID=C.ADDED_FACILITY_ID AND A.FACILITY_ID='"+facility+"'"; 
		}

	}else if(report_id == 'PHQAPPC2'){
		if(facility == '*A'){
			formObj.CLAUSE.value="WHERE A.FACILITY_ID=B.ADDED_FACILITY_ID AND A.FACILITY_ID IN(SELECT FACILITY_ID FROM SM_FACILITY_PARAM)";
		}
		else{
			formObj.CLAUSE.value="WHERE A.FACILITY_ID=B.ADDED_FACILITY_ID AND A.FACILITY_ID='"+facility+"'"; 
		}
	}else if(report_id == 'PHQAPPC3' || report_id == 'PHQAPPC4' || report_id == 'PHQAPPC3A' || report_id == 'PHQAPPC4A'|| report_id == 'PHQAPPC5A'){
			if(facility == '*A'){
			formObj.CLAUSE.value="AND A.FACILITY_ID IN(SELECT FACILITY_ID FROM SM_FACILITY_PARAM)";
		}
		else{
			formObj.CLAUSE.value="AND A.FACILITY_ID='"+facility+"'"; 
		}
	}else if(report_id == 'PHQAPPC5' || report_id == 'PHQAPPC6' || report_id == 'PHQAPPC10' || report_id == 'PHQAPPC11' || report_id == 'PHQAPPC8'){
			if(facility == '*A'){
			formObj.CLAUSE.value="AND A.ORDERING_FACILITY_ID IN(SELECT FACILITY_ID FROM SM_FACILITY_PARAM)";
		}
		else{
			formObj.CLAUSE.value="AND A.ORDERING_FACILITY_ID='"+facility+"'"; 
		}
	}
}
function initialize_date(obj){
	var mode=obj.value;
	var formObj = document.QapReportCriteria;
	if(formObj == undefined){
		formObj=f_query_add_mod.document.QapReportCriteria;  
	}
	var from_date=formObj.dt_from1; 
	var to_date=formObj.dt_to1;
	if(mode == 'M'){
		assigndate(from_date,'M');
		assigndate(to_date,'M');
	}else if(mode == 'Y'){
		assigndate(from_date,'Y');
		assigndate(to_date,'Y');
	}
}
function assigndate(obj,flag){
	var strDate=obj.value;
	var strDateArray=new Array() ; 
	if(strDate != ''){
	strDateArray = strDate.split("/");
		var	strday   = strDateArray[0];
		var strMonth = strDateArray[1];
		var StrYear  = strDateArray[2];
		if(flag == 'Y'){
			obj.value='01/01/'+StrYear;
		}else if(flag == 'M'){
			obj.value='01/'+strMonth+'/'+StrYear; 
		}
	}
}
function assignReportid(obj){
	document.QapReportCriteria.p_report_id.value=obj.value;
	document.QapReportCriteria.facility_name.value='';
	document.QapReportCriteria.dt_from.value='';
	document.QapReportCriteria.dt_to.value='';
 }

