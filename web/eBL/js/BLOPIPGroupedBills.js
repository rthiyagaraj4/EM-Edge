/**
Sr No        Version           Incident        SCF/CRF                    Developer Name
-----------------------------------------------------------------------------------
1            New File            14520       MOHE-CRF-0075.1      	    Shikha Seth
2            V210416             14520        MOHE-CRF-0075.2      	    Shikha Seth
3            V210420             16905        MOHE-SCF-0099      	    Shikha Seth/Muthu
4	     V210427		 14170	      MOHE-CRF-0075      	    Mohana Priya K
5	     V210511		 18503	      BL-MOHE-CRF-0075-
						OP/IP Grouped Bills- 3T     Mohana Priya K
4            V210723             20377        MOHE-CRF-0110	            MuthuN/Nandhini M
5            V210922             23622       ALPHA-BL-MOHE-CRF-0110
						/01-Date validation	     Mohana Priya K
*/

function reset()
{
	summaryreport.location.reload();
}

function run()  
{
  var formsObj = parent.content.summaryreport.document.forms[0];
  var facilityid=formsObj.facilityid.value;
  var patient_id=formsObj.patient_id.value;
  var encounter_id=formsObj.encounter_id.value;
  var episode_type=formsObj.episode_type.value;
  var p_report_idOP=formsObj.p_report_idOP.value;
  var p_report_idIP=formsObj.p_report_idIP.value;
  //V210427 Starts
  var p_report_idOP_en=formsObj.p_report_idOP_EN.value;
  var p_report_idIP_en=formsObj.p_report_idIP_EN.value;
  //V210427 Ends
  
  var Effective_from=formsObj.Effective_from.value;
  var Effective_to=formsObj.Effective_to.value;
  //V210723 starts
  var Billdate_from=formsObj.BillEffective_from.value;
  var Billdate_to=formsObj.BillEffective_to.value;
  //V210723 ends
  var session_id=formsObj.p_session_id.value;
  var p_module_id=formsObj.p_module_id.value;
  var loggedUserId = formsObj.p_user_name.value;
 	//var locale=formsObj.locale.value; 
  var language_id=formsObj.language_id.value; //V210511
  
 if(facilityid == 'ALL') facilityid='**';
 
	var starr = Effective_from.split("/");
	var enarr = Effective_to.split("/");	
	var startdt = new Date();
	var enddt = new Date();
	startdt.setFullYear(starr[2], starr[1]-1, starr[0]);
	enddt.setFullYear(enarr[2], enarr[1]-1, enarr[0]);
	var timeDiff;
	var daysDiff;
	
	if(startdt>enddt)
	{
		alert(getMessage('BL4115','BL'));
		return;
	}
	timeDiff = enddt.getTime() - startdt.getTime();
	daysDiff =  Math.floor(timeDiff / (1000 * 60 * 60 * 24));	
	var dayDiff = 31;	
	if(Effective_from != "" && Effective_to != "") {
		if (daysDiff > dayDiff - 1) {
			alert("Encounter To Date Cannot be greater than " + dayDiff + " Days from Encounter from Date");
			return false;
		}
	}
	//added by Nandhini V210723 starts
	var Bstarr = Billdate_from.split("/");
	var Benarr = Billdate_to.split("/");	
	var Billstartdt = new Date();
	var Billenddt = new Date();
	Billstartdt.setFullYear(Bstarr[2], Bstarr[1]-1, Bstarr[0]);
	Billenddt.setFullYear(Benarr[2], Benarr[1]-1, Benarr[0]);
	var BilltimeDiff;
	var BilldaysDiff;	
	//V210922 Starts
	if(Billstartdt>Billenddt) 
	{
		alert(getMessage('BL4115','BL'));
		return;
	}
	BilltimeDiff = Billenddt.getTime() - Billstartdt.getTime();
	BilldaysDiff =  Math.floor(BilltimeDiff / (1000 * 60 * 60 * 24));	
	var dayDiff = 31;	
	
	if(Billdate_from != "" && Billdate_to != "") {
		if (BilldaysDiff > dayDiff - 1) {
			alert("BillDate To Cannot be greater than " + dayDiff + " Bill from  Date");
			return false;
		}
	}
	//V210922 Ends
	//added by Nandhini V210723 ends.
	if(patient_id == "") {		 
		  alert(getMessage('BL00948','BL'));
		  formsObj.patient_id.focus();  
			return;
	}	
		
  if(encounter_id == "") {
	  formsObj.encounter_id.focus();
	  alert(getMessage('BL00948','BL'));
		return;
  }
  //added by Nandhini V210723
  if(facilityid == ""){
	  formsObj.facilityid.focus();
	  alert(getMessage('BL00017','BL'));
		return;
  }
  var p_report_id ;  
  /*
  if (episode_type == 'O') {
		  p_report_id = p_report_idOP;
	  } else {
		  p_report_id = p_report_idIP;
	  }  */ //Commented against V210427 
  //V210427 Starts
  if(language_id=='en'){   //V210511
	  if (episode_type == 'O') {
		  p_report_id = p_report_idOP_en;
	  } else {
		  p_report_id = p_report_idIP_en;
	  }  
  }
  else{
	  if (episode_type == 'O') {
		  p_report_id = p_report_idOP;
	  } else {
		  p_report_id = p_report_idIP;
	  }  
  }
  //V210427 Ends
 
  
/*var xmlDoc = new ActiveXObject( "Microsoft.XMLDom" ) ;
var xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" ) ;*/
var xmlDoc = "";
var xmlHttp = new XMLHttpRequest();

var xmlStr ="<root><SEARCH ";
xmlStr +=" /></root>";

var htmlVal = "<html><body>";
htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
htmlVal += "<input type='hidden' name='p_facility' id='p_facility' value='"+facilityid+"'>";
htmlVal += "<input type='hidden' name='p_episode_type' id='p_episode_type' value='"+episode_type+"'>";
htmlVal += "<input type='hidden' name='p_encounter_id' id='p_encounter_id' value='"+encounter_id+"'>";
//htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='ar'>"; //Commented against V210426
htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+language_id+"'>"; //V210426 //V210511
htmlVal += "<input type='hidden' name='p_fm_date' id='p_fm_date' value='"+Effective_from+"'>";
htmlVal += "<input type='hidden' name='p_to_date' id='p_to_date' value='"+Effective_to+"'>";
htmlVal += "<input type='hidden' name='p_bill_fm_date' id='p_bill_fm_date' value='"+Billdate_from+"'>"; //V210723
htmlVal += "<input type='hidden' name='p_bill_to_date' id='p_bill_to_date' value='"+Billdate_to+"'>"; //V210723
htmlVal += "<input type='hidden' name='p_patient_id' id='p_patient_id' value='"+patient_id+"'>";
htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+p_report_id+"'>";
htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+p_module_id+"'>";
htmlVal += "<input type='hidden' name='P_USER' id='P_USER' value='"+loggedUserId+"'>"; //V210416
htmlVal += "</form></body></html>"; 
dummy_frame.document.body.insertAdjacentHTML("afterbegin",HTMLVal);
dummy_frame.document.dummy_frm.submit();		 

}	

function trimString(sInString) {
	  return sInString.replace(/^\s+|\s+$/g,"");
}

function callExcelDisplay(){
	var formObj=document.forms[0];
	
	var locale=formObj.locale.value;
	var facilityId=document.getElementById('facilityid').value;
	var episode_type=document.getElementById('episode_type').value;
	var month_year ="";
	if (document.getElementById('Month').value >9)
	month_year=document.getElementById('Year').value+""+document.getElementById('Month').value;
	else
		month_year=document.getElementById('Year').value+"0"+document.getElementById('Month').value;
	var err_msg="";
	var err_code="";
	
	if(episode_type==undefined || episode_type=='')
	{
		alert(getMessage("BL00028","BL"));
		return false;
	}
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";

	var param1 = "&p_facility_id="+facilityId+"&p_year_month="+month_year+"&p_episode_type="+episode_type+"&p_language_id="+locale ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eBL/jsp/BLGenerateEClaimValidation.jsp?func_mode=insert"+param1,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var retValArr = retVal.split(":::");
	
	if(retValArr[0] ==''){	
			tmpformObj = document.BLGenerateEClaims;
			tmpformObj.noOfCols.value = "20";
			tmpformObj.method ="post";
			tmpformObj.action="../../servlet/eBL.BLGenerateEClaimservlet";
			tmpformObj.target = "messageFrame";
			tmpformObj.submit();
			parent.window.frames["summaryreport"].location.href = 'BLGenerateEClaims.jsp';
	}else{
			alert(retValArr[1]);
		}
}

function getFacility(obj,code,val) {		
	var loc_code_desc = '';
	var loc_code_link = ''
	var locale = document.forms[0].locale.value;
	var user_id	= document.getElementById("p_user_name").value; //Added by Nandhini against V210723
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';	
	/*sql="select description,code from (SELECT facility_name description, facility_id code FROM sm_facility_param_lang_vw WHERE upper(language_id) = upper('"+locale+"') "+
	" union select 'All Facility' description, '**' code  from dual ) where upper(description) like upper(?) and upper(code) like upper(?) "+
	" order by 2";*/
	/*sql="select description,code from (SELECT facility_name description, facility_id code FROM sm_facility_param_lang_vw WHERE upper(language_id) = upper('"+locale+"') union select 'All Facility' description, 'ALL' code  from dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";*///commented by Nandhini against V210723 
	/*sql="SELECT   description, code FROM (SELECT facility_name description, facility_id code FROM sm_facility_param_lang_vw   WHERE UPPER (language_id) = UPPER ('en') and facility_id in (select facility_id from sm_facility_for_user where appl_user_id ='CHANDRA') UNION SELECT 'All Facility' description, 'ALL' code FROM DUAL) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";*///commneted by Nandhini V210723 02-08-2021 
	sql="SELECT   description, code FROM (SELECT facility_name description, facility_id code FROM sm_facility_param_lang_vw   WHERE UPPER (language_id) = UPPER ('"+locale+"') and facility_id in (select facility_id from sm_facility_for_user where appl_user_id ='"+user_id+"')) where upper(description) like upper(?) and upper(code) like upper(?) order by 2"; //Added by Nandhini against V210723
	//sql="select description,code from (SELECT facility_name description, facility_id code FROM sm_facility_param_lang_vw WHERE upper(language_id) = upper(?) union select 'All Facility' description, '**' code  from dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
		title = 'Facility';
		loc_code_desc = DESC_CODE;
		loc_code_link = DESC_LINK;
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;		
		if (val==1) {
			argumentArray[4] = "1,2";	
			argumentArray[5] = code;		
		}
		if (val==2) {
			argumentArray[4] = "2,1";	
			argumentArray[5] = obj.value;
		}
	//	argumentArray[6] = locale;
		argumentArray[6] = loc_code_link;
		argumentArray[7] = loc_code_desc;
		returnedValues = CommonLookup(title, argumentArray );		
		if((returnedValues != null) && (returnedValues != "") )  {							
			$('#facilityidName').val(returnedValues[1]);
			$('#facilityid').val( returnedValues[0]);
		}	
}

function clearCode(obj){
	obj.value = '';
}
function enCounterIdLookup()
{
   // alert("5");
	var tdesc="";
    var tcode="";

    var retVal =new String();
    var argumentArray  = new Array() ;
    var dataNameArray  = new Array() ;
    var dataValueArray = new Array() ;
    var dataTypeArray  = new Array() ;
    var tit= getLabel("Common.encounterid.label","Common");			
    var target=this.document.forms[0].encounter_id;
    var facility = document.forms[0].facilityid.value;
	var Effective_from=document.getElementById("Effective_from").value;
	var Effective_to=document.getElementById("Effective_to").value;	  
    var e = document.getElementById("episode_type"); 
	var selectedValue;
	var episodeType;
	var Billdate_from=document.getElementById("BillEffective_from").value;//Added against V210723
	var Billdate_to=document.getElementById("BillEffective_to").value;//Added against V210723
	for(var j=0; j<e.options.length; j++)
    {
		if(e.options[j].selected)
			selectedValue=e.options[j].value;
    }
	if(selectedValue=='O') 
		episodeType = 'OP';
	else if(selectedValue=='I')
		episodeType = 'IP';	
	
	var patient_id = this.document.forms[0].patient_id.value;
	if(patient_id == undefined || patient_id == null || patient_id == '' || patient_id == 'undefined')
	{		
		  alert(getMessage('BL00948','BL'));
		  document.getElementById('patient_id').focus();    
			return;		
	}
	
	if(facility=='ALL') {		
		 if(Effective_from != undefined && Effective_from != null && Effective_from != '' && Effective_from != 'undefined' && Effective_to != undefined && Effective_to != null && Effective_to != '' && Effective_to != 'undefined')
			sql="SELECT EPISODE_ID description,ENCOUNTER_ID code  FROM pr_encounter WHERE  PATIENT_ID='"+patient_id+"' AND PATIENT_CLASS='"+episodeType+"' AND TRUNC(VISIT_ADM_DATE_TIME) BETWEEN TRUNC (to_date('" + Effective_from +"','dd/MM/yyyy')) AND TRUNC (to_date('" + Effective_to +"','dd/MM/yyyy')) AND UPPER(EPISODE_ID) LIKE UPPER(?) AND UPPER(ENCOUNTER_ID) LIKE UPPER(?) ORDER BY 1 ";
		 else
			 sql="SELECT EPISODE_ID description,ENCOUNTER_ID code  FROM pr_encounter WHERE  PATIENT_ID='"+patient_id+"' AND PATIENT_CLASS='"+episodeType+"' AND UPPER(EPISODE_ID) LIKE UPPER(?) AND UPPER(ENCOUNTER_ID) LIKE UPPER(?) ORDER BY 1 ";
	}
	//Added by Nandhini against V210723 starts
	else if(Effective_from != undefined && Effective_from != null && Effective_from != '' && Effective_from != 'undefined' && Effective_to != undefined && Effective_to != null && Effective_to != '' && Effective_to != 'undefined' && Billdate_from != undefined && Billdate_from != null && Billdate_from != '' && Billdate_from != 'undefined' && Billdate_to != undefined && Billdate_to != null && Billdate_to != '' && Billdate_to != 'undefined' )
	{
			/*sql="SELECT EPISODE_ID description,ENCOUNTER_ID code  FROM pr_encounter WHERE  FACILITY_ID = '"+facility+"' AND PATIENT_ID='"+patient_id+"' AND PATIENT_CLASS='"+episodeType+"' AND TRUNC(VISIT_ADM_DATE_TIME) BETWEEN TRUNC (to_date('" + Effective_from +"','dd/MM/yyyy')) AND TRUNC (to_date('" + Effective_to +"','dd/MM/yyyy')) AND UPPER(EPISODE_ID) LIKE UPPER(?) AND UPPER(ENCOUNTER_ID) LIKE UPPER(?) ORDER BY 1";AND UPPER(EPISODE_ID) LIKE UPPER(?) AND UPPER(ENCOUNTER_ID) LIKE UPPER(?)*/
			/*sql="SELECT a.episode_id description, a.encounter_id code, visit_adm_date_time FROM pr_encounter a WHERE EXISTS  (SELECT 1 FROM bl_patient_charges_folio b WHERE a.facility_id = b.operating_facility_id AND a.patient_id = b.patient_id AND a.episode_id = b.episode_id AND TRUNC (b.bill_doc_date) BETWEEN TRUNC (TO_DATE ('" + Billdate_from +"','dd/MM/yyyy')) AND TRUNC (TO_DATE ('" + Billdate_to +"','dd/MM/yyyy'))) AND FACILITY_ID = '"+facility+"' AND PATIENT_ID='"+patient_id+"' AND PATIENT_CLASS='"+episodeType+"' AND TRUNC (a.visit_adm_date_time) BETWEEN TRUNC (TO_DATE ('" + Effective_from +"','dd/MM/yyyy')) AND TRUNC (TO_DATE ( '" + Effective_to +"','dd/MM/yyyy')) AND UPPER(EPISODE_ID) LIKE UPPER(?) AND UPPER(ENCOUNTER_ID) LIKE UPPER(?) ORDER BY 1";*/
			sql="SELECT a.episode_id description,a.encounter_id code,visit_adm_date_time FROM pr_encounter a WHERE EXISTS (SELECT 1 FROM bl_patient_charges_folio b WHERE a.facility_id = b.operating_facility_id AND a.patient_id = b.patient_id AND a.episode_id = b.episode_id AND TRUNC(b.bill_doc_date) BETWEEN TRUNC(TO_DATE('" +Billdate_from+"','dd/MM/yyyy')) AND TRUNC(TO_DATE('"+Billdate_to+"','dd/MM/yyyy'))) AND FACILITY_ID ='"+facility+"' AND PATIENT_ID='"+patient_id+"' AND PATIENT_CLASS='"+episodeType+"' AND TRUNC(a.visit_adm_date_time) BETWEEN TRUNC(TO_DATE('"+Effective_from+"','dd/MM/yyyy')) AND TRUNC(TO_DATE('"+Effective_to+"','dd/MM/yyyy')) AND UPPER(EPISODE_ID) LIKE UPPER(?) AND UPPER(ENCOUNTER_ID) LIKE UPPER(?) ORDER BY 1";
	}
	else if(Effective_from != undefined && Effective_from != null && Effective_from != '' && Effective_from != 'undefined' && Effective_to != undefined && Effective_to != null && Effective_to != '' && Effective_to != 'undefined' && Billdate_from == undefined && Billdate_from == null) {
			sql="SELECT EPISODE_ID description, ENCOUNTER_ID code FROM pr_encounter WHERE FACILITY_ID = '"+facility+"' AND	PATIENT_ID='"+patient_id+"' AND PATIENT_CLASS='"+episodeType+"' AND TRUNC (VISIT_ADM_DATE_TIME) BETWEEN TRUNC (TO_DATE ( '" + Effective_from +"','dd/MM/yyyy')) AND TRUNC (TO_DATE ('" + Effective_to +"','dd/MM/yyyy')) AND UPPER(EPISODE_ID) LIKE UPPER(?) AND UPPER(ENCOUNTER_ID) LIKE UPPER(?)";		
	}
	else if(Billdate_from != undefined && Billdate_from != null && Billdate_from != '' && Billdate_from != 'undefined' && Billdate_to != undefined && Billdate_to != null && Billdate_to != '' && Billdate_to != 'undefined' && Effective_from == undefined && Effective_from == null) {
			sql="SELECT EPISODE_ID description, ENCOUNTER_ID code FROM pr_encounter WHERE FACILITY_ID = '"+facility+"' AND PATIENT_CLASS='"+episodeType+"' AND PATIENT_ID IN ( SELECT PATIENT_ID FROM BL_BILL_HDR WHERE TRUNC (DOC_DATE) BETWEEN TRUNC (TO_DATE ('" + Billdate_from +"','dd/MM/yyyy')) AND TRUNC (TO_DATE ('" + Billdate_to +"','dd/MM/yyyy')) AND PATIENT_ID ='"+patient_id+"') AND UPPER(EPISODE_ID) LIKE UPPER(?) AND UPPER(ENCOUNTER_ID) LIKE UPPER(?) ORDER BY 1";		
	}
	//Added by Nandhini against V210723 ends
		else{
			sql="SELECT EPISODE_ID description,ENCOUNTER_ID code  FROM pr_encounter WHERE  FACILITY_ID = '"+facility+"' AND PATIENT_ID='"+patient_id+"' AND PATIENT_CLASS='"+episodeType+"' AND UPPER(EPISODE_ID) LIKE UPPER(?) AND UPPER(ENCOUNTER_ID) LIKE UPPER(?) ORDER BY 1 ";
	}
	
    argumentArray[0] = sql;
    argumentArray[1] = dataNameArray ;
    argumentArray[2] = dataValueArray ;
    argumentArray[3] = dataTypeArray ;
    argumentArray[4] = "1,2";
    argumentArray[5] = target.value;
    argumentArray[6] = DESC_LINK  ;
    argumentArray[7] = DESC_CODE ;

    // retVal = await CommonLookup( tit, argumentArray );
	
		var dialogTop			= "90";
		var dialogHeight		= "27" ;
		var dialogWidth			= "40" ;
		var features= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	
			
			var code=encodeURIComponent(getLabel("Common.episodeid.label","common"));
			var description=encodeURIComponent(getLabel("Common.encounterid.label","common"));;

			var column_descriptions =code+","+description;
			var column_sizes = escape("50%,50%");
			
			var param = "title="+tit+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&target="+encodeURIComponent(target.value)+"&episodeType="+episodeType+"&facility="+facility+"&patient_id="+patient_id+"&effFrom="+Effective_from+"&effTo="+Effective_to+"&billDateFrom="+Billdate_from+"&billDateTo="+Billdate_to;
			
			param = param + "&srch_by_clmn_index=1"+"&col_show_hide=YY&called_for=EncounterLookup";
			
			retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);	
	
    if(retVal != null && retVal != "" ){
        var ret1=unescape(retVal);
        arr=ret1.split("^~^");
        target.value=arr[1]; 
    }
    else{
        target.value="";
    }

}
	function isValidDate(obj){
		if(obj.value!=""){
			var flag=true;
			var RE_NUM =  /^\/?\d+$/;
			var str_date = obj.value;
			var arr_date = str_date.split('/');
			if (arr_date.length != 3) {  alert(getMessage('INVALID_DATE_FMT','SM'));//flag=false;
			return false;
			}
		
			if(arr_date[0]!=null)
			{
			if (arr_date[0].length !=2 ) flag=false;
			}
			if(arr_date[1]!=null)
			{
			if (arr_date[1].length !=2 ) flag=false;
			}
			if(arr_date[2]!=null)
			{
			if (arr_date[2].length !=4 ) flag=false;
			}
			if (!arr_date[0]) flag=false;
			if (!RE_NUM.exec(arr_date[0])) flag=false;
			if (!arr_date[1]) flag=false;
			if (!RE_NUM.exec(arr_date[1])) flag=false;
			if (!arr_date[2]) flag=false;
			if (!RE_NUM.exec(arr_date[2])) flag=false;
			if (arr_date[2].length!=4) flag=false;
			var dt_date = new Date();
			dt_date.setDate(1);
			if (arr_date[1] < 1 || arr_date[1] > 12) flag=false;
			dt_date.setMonth(arr_date[1]-1);
			var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
			dt_date.setDate(arr_date[0]);
			if (dt_date.getMonth() != (arr_date[1]-1)) flag=false;

			if (flag==false){
				  alert(getMessage('INVALID_DATE_FMT','SM'));
				  return false;
			}
		}
		return true;
	}



