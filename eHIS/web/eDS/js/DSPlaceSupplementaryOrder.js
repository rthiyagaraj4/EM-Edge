/* This file created against MMS-QH-CRF-0079 [IN:038156] for September 2016 Release */
function reset(){
	location.reload();
}

function loadIPNursingUnit()
{
	var facility_id=$("#facility_id").val();
	var locale=$("#locale").val();
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var mode="loadIPNursingUnit";	
	var xmlStr ="<root></root>";	
	var params="mode="+mode;
	params+="&facilityid="+facility_id;
	params+="&locale="+locale;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.MealTicketServlet?"+params,false);
	xmlHttp.send(xmlDoc);
	
	var retVal = xmlHttp.responseText;
	var jsonObjResponse=eval('(' + retVal + ')');
	var IPNursingList=new Array();
	IPNursingList = jsonObjResponse.IPNursingUnit;
	var listItems = '<option selected="selected" value="">'+getLabel("Common.Select.label","common")+'</option>';
	if(IPNursingList!=null && IPNursingList!="undefined" && IPNursingList!=""){
	for (var i = 0; i < IPNursingList.length; i++) {
         listItems += "<option value='" + IPNursingList[i].Nursing_Code + "'>" + IPNursingList[i].Nursing_Desc + "</option>";
    	}
		$("#nursing_Unit").html(listItems);
	}else{
		$("#nursing_Unit").html(listItems);		
	}
}
function setPatientIdLength()
{
	var facility_id=$("#facility_id").val();
	var locale=$("#locale").val();
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var mode="getPatientIdLength";	
	var xmlStr ="<root></root>";	
	var params="mode="+mode;
	params+="&facilityid="+facility_id;
	params+="&locale="+locale;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	xmlHttp.open("POST", "../../servlet/eDS.MealTicketServlet?"+params,false);
	xmlHttp.send(xmlDoc);
	
	var retVal = xmlHttp.responseText;
	var jsonObjResponse=eval('(' + retVal + ')');
	var PatientIdList=new Array();
	PatientIdList = jsonObjResponse.PatientIdLength;
	var len=PatientIdList[0].Patient_Id_Length;
	$("#patient_id").attr('maxlength',len);
}

function callPractSearch(obj,val)
	{	
		if(obj.value==""){		
		$("#practitioner_name").val("");
		$("#practitioner_id").val("");
		}
		if(obj.name=="practitioner_name" && obj.value==""){
			return false;
		}

		var practName_FName="";
		var practName_FValue="";
		var practId_FName="";
		
		practName_FName=$('#practitioner_name').attr('name');		
		practName_FValue=$("#practitioner_name").val();	
		
		var sql="";
		var sql2="";
		var open_to_all_pract_yn = "Y";
		var language_Id = document.all("language_Id")
		var facility_id=$("#facility_id").val();
		var requestContextPath=$("#requestContextPath").val();
		var clinic_code ="";
		clinic_code = "";

		sql= "SELECT a.PRACTITIONER_ID practitioner_id, a.PRACTITIONER_NAME practitioner_name,	b.pract_type_desc practitioner_type,b.primary_splty_short_desc primary_specialty,DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant','RG',  'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC',  'Sr.Consultant','SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' )job_title,b.gender	FROM am_pract_for_facility_vw a, am_practitioner_vw b 	WHERE operating_facility_id = '"+facility_id+"' 	 AND a.practitioner_id = b.practitioner_id  	AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))    AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code)) 	AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) 	OR UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name)))	AND DECODE(UPPER(b.gender),'MALE','M','FEMALE','F','Unknown','U')	LIKE NVL(UPPER(?),DECODE(UPPER(b.gender),'MALE','M','FEMALE','F','Unknown','U'))AND UPPER(NVL(job_title,'123')) LIKE UPPER(NVL(?,NVL(job_title,'123')))" ;

		sql2="SELECT a.PRACTITIONER_ID practitioner_id, a.PRACTITIONER_NAME practitioner_name,	b.pract_type_desc practitioner_type,b.primary_splty_short_desc primary_specialty,DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant','RG',  'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC',  'Sr.Consultant','SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' )job_title,b.gender	FROM am_pract_for_facility_vw a, am_practitioner_vw b 	WHERE operating_facility_id = '"+facility_id+"' 	 AND a.practitioner_id = b.practitioner_id  	AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))    AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code)) 	AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) 	AND UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name)))	AND DECODE(UPPER(b.gender),'MALE','M','FEMALE','F','Unknown','U')	LIKE NVL(UPPER(?),DECODE(UPPER(b.gender),'MALE','M','FEMALE','F','Unknown','U'))AND UPPER(NVL(job_title,'123')) LIKE UPPER(NVL(?,NVL(job_title,'123')))" ;
		var xmlDoc= "" ;
//		var xmlHttp= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
		var xmlHttp = new XMLHttpRequest();

		xmlStr	="<root><SEARCH " ;
		xmlStr += " practName_FName=\"" + encodeURIComponent(practName_FName) + "\"";
		xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
		xmlStr += " practId_FName=\"" + practId_FName + "\"";
		xmlStr += " sql=\"" +escape(sql)+ "\"";
		xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
		xmlStr += " practitioner_type=\"" + "" + "\"";
		xmlStr += " specialty_code=\"" + "" + "\"";
		xmlStr += " job_title=\"" + "" + "\"";
		xmlStr += " gender=\"" + "" + "\"";

		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		
		xmlHttp.open( "POST",requestContextPath+"/eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
		
		xmlHttp.send(xmlDoc);

		responseText= xmlHttp.responseText;
//		console.log(responseText);
		responseText = trimString(responseText);
		eval(responseText);
	}

function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		if(objName == "practitioner_name")
		{
			$("#practitioner_name").val(arr[1]);
			$("#practitioner_id").val(arr[0]);
		}
	}
	else
	{
		$("#practitioner_name").val("");
		$("#practitioner_id").val("");
	}
} 

async function callPatientSearch()
{
	var	window_styl='O';
        var close_yn='Y';
        var jsp_name='';
        var win_top= '61';
        var win_height= '34';
        var win_width= '50';
        var act_yn= 'N';
        var register_button_yn = 'N';
        var func_act='';
        var dr_function_id='';
        var srr='Y';
        window_styl = window_styl.toUpperCase();
        close_yn = close_yn.toUpperCase();
        act_yn = act_yn.toUpperCase();
	
	var url ="";
	url     ="../../eMP/jsp/ModelPatientSearch.jsp?jsp_name="+jsp_name+"&window_styl="+window_styl+"&close_yn="+close_yn+"&win_top="+win_top+"&win_height="+win_height+"&win_width="+win_width+"&act_yn="+act_yn+"&srr="+srr+"&register_button_yn="+register_button_yn+"&func_act="+func_act+"&dr_function_id="+dr_function_id;
	var dialogTop   = "65";
        var dialogHeight    = "900px" ; //30.5
        var dialogWidth = "900px" ;
        var arguments   = "" ;
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
        var returnval = await window.showModalDialog( url, arguments, features ) ;
		$('#patient_id').val(returnval);
}

function searchResult(calledfrom)
{	
	var flag=true;
	if(calledfrom=="search"){
	flag=checkNull();
		if(flag==true){
			var from_date=$("#dateFrom").val();
			var to_date=$("#dateTo").val();
			if(from_date!="" && to_date!=""){
				flag=compareDate(from_date,to_date);
				
				if(flag==1){
					flag=false;
					alert(getMessage("DS_ADMTODAT_GRTREQL_FRMDAT","DS"));
					
				}else{
					flag=true;
				}
			}			
		}
		//61215
		//check wards for kitchen set up
		var nursing_Unit=$("#nursing_Unit").val();
		var facility_id=$("#facility_id").val();
		wardsForKitchenSetUp(nursing_Unit,facility_id);
		//61215
		}
		
	if(flag==true){
		if(calledfrom!="ReLoad"){
		setPaginationNumber(calledfrom);
		}
		if(calledfrom=="search"){
		setHiddenFieldSearchValue();
		}
	}
	if(flag==true){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var nursing_unit_code=$("#nursing_Unit_hidden").val();
	var facility_id=$("#facility_id").val();
	var locale=$("#locale").val();
	var Admission_From_Date=$("#dateFrom_hidden").val();
	var Admission_To_Date=$("#dateTo_hidden").val();
	var PatientId=$("#patient_id_hidden").val();
	var EncounterId=$("#encounter_id_hidden").val();
	var PractionerId=$("#practitioner_id_hidden").val();
	var Gender=$("#gender_hidden").val();
	var status=$("#status_hidden").val();
	var Start_Num=$("#Start_Num").val();
	var End_Num=$("#End_Num").val();
	var Grace_Period=$("#Grace_Period").val();
	var Total_Record=0;
	
	var params = "mode=Place_Supplementary_Result_New4&facility_id="+facility_id+"&locale="+locale+"&nursing_unit_code="+nursing_unit_code;
	params+="&Admission_From_Date="+Admission_From_Date;
	params+="&Admission_To_Date="+Admission_To_Date;
	params+="&PatientId="+PatientId;
	params+="&EncounterId="+EncounterId;
	params+="&PractionerId="+PractionerId;
	params+="&Gender="+Gender;
	params+="&status="+status;
	params+="&Start_Num="+Start_Num;
	params+="&End_Num="+End_Num;
	params+="&Grace_Period="+Grace_Period;
	
	xmlHttp.open("POST", "../../servlet/eDS.SupplementaryOrderServlet?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;	
	
	var jsonObjResponse=eval('(' + retVal + ')');
	
	var ResultList=new Array();
	ResultList = jsonObjResponse.list.list;
	var table		= $('#supplementaryplacesearchtable');
	$("#supplementaryplacesearchtable").find("tr").remove();
	$('#supplementaryplacesearchtable').attr("style", "overflow-y:scroll;overflow-x:scroll;border-bottom: 1pt solid black" );
	var nextprevtable=$('#nextprevtable');
	var nextprevlinkname="";
	$("#nextprevtable").find("tr").remove();	
	
	var row=$('<tr><th >'+getLabel("eOT.admDate.Label","ot_labels")+'</th></tr>').addClass("thwrap").appendTo(table);
	$('<th >'+getLabel("Common.encounterid.label","common")+'</th>').appendTo(row);
	$('<th >'+getLabel("Common.status.label","common")+'</th>').appendTo(row);
	$('<th >'+getLabel("Common.patientId.label","common")+'</th>').appendTo(row);
	$('<th >'+getLabel("Common.PatientName.label","common")+'</th>').appendTo(row);
	$('<th >'+getLabel("Common.gender.label","common")+'</th>').appendTo(row);
	//$('<th >'+getLabel("Common.Location.label","common")+'</th>').appendTo(row); //Commented Against PMG2017-COMN-CRF-0012[IN066074]
	$('<th >'+getLabel("Common.Bed.label","common")+'</th>').appendTo(row);
	$('<th >'+getLabel("Common.room.label","common")+'</th>').appendTo(row);
	
	
	if(ResultList.length==0){
		
		alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
		return ;
	}
	
	$("#footer").css("visibility","visible");
	$.each(ResultList, function (i, item) {
		var row1=$("<tr><td>"+ResultList[i].Visit_Adm_Date+"</td></tr>").appendTo(table);
		$('<td align="center">'+ResultList[i].Encounter_Id+'</td>').appendTo(row1);
		if(ResultList[i].Color_Code=="1"){
		$('<td align="center" class="ORANGE"></td>').appendTo(row1);
		}else{
			$('<td align="left">&nbsp;</td>').appendTo(row1);
		}
		//$('<td align="left"><a href=javascript:launchSupplmentaryWindow("'+ResultList[i].Patient_Id+','+ResultList[i].Encounter_Id+','+ResultList[i].Assign_Care_Locn_code+','+ResultList[i].Sex+','+ResultList[i].Assign_Bed_Num+','+ResultList[i].Assign_Room_Num+','+ResultList[i].Patient_Class+'")>'+ResultList[i].Patient_Id+'</a></td>').appendTo(row1);
		$('<td align="left"><a href=javascript:launchSupplmentaryWindow("'+ResultList[i].Patient_Id+'","'+ResultList[i].Encounter_Id+'","'+ResultList[i].Assign_Care_Locn_code+'","'+ResultList[i].Sex+'","'+checkForNulls(ResultList[i].Assign_Bed_Num)+'","'+checkForNulls(ResultList[i].Assign_Room_Num)+'","'+ResultList[i].Patient_Class+'","'+ResultList[i].Assign_Care_Locn_Type+'","'+ResultList[i].DOB+'")>'+ResultList[i].Patient_Id+'</a></td>').appendTo(row1);
		$('<td align="left">'+ResultList[i].Patient_Name+'</td>').appendTo(row1);
		/* Modified Against Start PMG2017-COMN-CRF-0012[IN066074] */
		//$('<td align="left">'+ResultList[i].Sex+'</td>').appendTo(row1);
		$('<td align="left">'+ResultList[i].Patient_Age+'</td>').appendTo(row1);
		//$('<td align="left">'+ResultList[i].Assign_Care_Locn_code+'</td>').appendTo(row1); 
		/*Modified Against End PMG2017-COMN-CRF-0012[IN066074]*/
		if(checkForNulls(ResultList[i].Assign_Bed_Num)=="" || checkForNulls(ResultList[i].Assign_Bed_Num)=="undefined"){
			$('<td align="left">&nbsp;</td>').appendTo(row1);
		}else{
		$('<td align="center">'+checkForNulls(ResultList[i].Assign_Bed_Num)+'</td>').appendTo(row1);
		}
		if(checkForNulls(ResultList[i].Assign_Room_Num)==""){
			$('<td align="left">&nbsp;</td>').appendTo(row1);
		}else{
		$('<td align="left">'+checkForNulls(ResultList[i].Assign_Room_Num)+'</td>').appendTo(row1);
		}
		
		Total_Record=ResultList[i].Total_Record;
    });	
	
	if(Total_Record>14 && Start_Num==1 && End_Num==14){
	nextprevlinkname="next";
	var nextprevrow=$('<tr><td><a href=javascript:searchResult("'+nextprevlinkname+'") >Next</a></td></tr>').appendTo(nextprevtable);
	}
	else if(parseInt(Total_Record)>14 && parseInt(Start_Num)>14 && parseInt(End_Num)<parseInt(Total_Record)){
		nextprevlinkname="next";
		var nextprevrow=$('<tr><td><a href=javascript:searchResult("'+nextprevlinkname+'") >Next</a></td></tr>').appendTo(nextprevtable);
		nextprevlinkname="previous";
		$('<td><a href=javascript:searchResult("'+nextprevlinkname+'") >previous</a></td>').appendTo(nextprevrow);
	}else if(parseInt(Total_Record)<=parseInt(End_Num) && Start_Num>=14){	
	nextprevlinkname="previous";
	var nextprevrow=$('<tr><td><a href=javascript:searchResult("'+nextprevlinkname+'") >previous</a></td></tr>').appendTo(nextprevtable);
	}
	}
}
function checkNull(){
	var flag=true;
	var nursing_Unit=$("#nursing_Unit").val();
	if(nursing_Unit==""){
		alert(getMessage("DS_NURSGUNIT_NOT_BLANK","DS"));
		flag=false;
	}
	return flag;
}
function setHiddenFieldSearchValue(){
	$("#nursing_Unit_hidden").val($("#nursing_Unit").val());
	$("#dateFrom_hidden").val($("#dateFrom").val());
	$("#dateTo_hidden").val($("#dateTo").val());
	$("#patient_id_hidden").val($("#patient_id").val());
	$("#encounter_id_hidden").val($("#encounter_id").val());
	$("#practitioner_id_hidden").val($("#practitioner_id").val());
	$("#gender_hidden").val($("#gender").val());
	$("#status_hidden").val($("#status").val());
	
	
}

async function launchSupplmentaryWindow(patientId,Encounter_Id,Assign_Care_Locn_code,Sex,Assign_Bed_Num,Assign_Room_Num,Patient_Class,Assign_Care_Locn_Type,date_of_birth)
{			
			//61215
			var wardsForKitchenSetUp=$("#wardsForKitchenSetUp").val();
			if(wardsForKitchenSetUp=="N"){
				alert(getMessage('DS_KIT_NOTSET_FOR_NURSUNIT','DS'));
				return;
			}
			//61215
			var params="";
			params+="&encounterId="+Encounter_Id;
			params+="&patientId="+patientId;
			params+="&locationCode="+Assign_Care_Locn_code;
			params+="&patientClass="+Patient_Class;
			params+="&room="+Assign_Room_Num;
			params+="&bed="+Assign_Bed_Num;
			params+="&locationType="+Assign_Care_Locn_Type;
			params+="&dateOfBirth="+date_of_birth;
			params+="&gender="+Sex;
			var url = "../../eDS/jsp/PlaceSupplementaryOrderFrames.jsp?"+params;
			var returnVal="";
			var dialogFeatures = "dialogHeight:" + "730px" + "; dialogWidth:" + "1100px" + "; scroll:no; status:no;";
			var arguments = "";
			var returnVal = await window.showModalDialog(url, arguments, dialogFeatures);
			searchResult("ReLoad");
}

function setPaginationNumber(calledfrom)
{
	var start_num=$("#Start_Num").val();
	var end_num=$("#End_Num").val();
	
	if(calledfrom=="search"){
		start_num=1;
		end_num=14;
	}
	else if(calledfrom=="next"){
		start_num=parseInt(start_num)+14;
		end_num=parseInt(end_num)+14;		
	}else if(calledfrom=="previous"){
		start_num=parseInt(start_num)-14;
		end_num=parseInt(end_num)-14;	
	}
		
	$("#Start_Num").val(start_num);
	$("#End_Num").val(end_num);
}
   function CheckNumVal(obj)
    {
		if (parseInt(obj.value) <= 0)
		{
			alert(getMessage('IP_VAL_NOT_LESS_ZERO',"IP"));
			obj.select();
		}
		else
		{
			CheckNum(obj);
		}
    }
//61215 starts
function wardsForKitchenSetUp(nursing_Unit,facility_id){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	var params = "mode=WardsForKitchenSetUp&facility_id="+facility_id+"&nursing_unit_code="+nursing_Unit;	
	xmlHttp.open("POST", "../../servlet/eDS.SupplementaryOrderServlet?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	$("#wardsForKitchenSetUp").val(retVal);
}	
//61215 ends
function isValidDate(obj)
{
	if(obj.value!="")
	{
		//var RE_NUM = /^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(20)[0-9]{2}$/;
		var RE_NUM =  /^\/?\d+$/;
		var str_date = obj.value;
		var arr_date = str_date.split('/');
		if (arr_date.length!=3) return cal_error ("Invalid date format: '" + str_date + "'.\nFormat accepted is DD/MM/YYYY.",obj);
		if (!arr_date[0]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo day of month value can be found.",obj);
		if (!RE_NUM.exec(arr_date[0])) return cal_error ("Invalid day of month value: '" + arr_date[0] + "'.\nAllowed values are unsigned integers.",obj);
		if (!arr_date[1]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo month value can be found.",obj);
		if (!RE_NUM.exec(arr_date[1])) return cal_error ("Invalid month value: '" + arr_date[1] + "'.\nAllowed values are unsigned integers.",obj);
		if (!arr_date[2]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo year value can be found.",obj);
		if (arr_date[2].length!=4) return cal_error ("Invalid year value: '" + arr_date[2] + "'.\nAllowed format YYYY.",obj);
		var dt_date = new Date();
		dt_date.setDate(1);
		if (arr_date[1] < 1 || arr_date[1] > 12) return cal_error ("Invalid month value: '" + arr_date[1] + "'.\nAllowed range is 01-12.",obj);
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);
		if (dt_date.getMonth() != (arr_date[1]-1)) return cal_error ("Invalid day of month value: '" + arr_date[0] + "'.\nAllowed range is 01-"+dt_numdays.getDate()+".",obj);
		//if(arr_date[2].length==4 && arr_date[2]>=dt_date.getFullYear() ) return cal_error ("Not a valid Year value: '" + arr_date[2] + "'.\nCurrent Year "+dt_date.getFullYear()+" Only Allowed .",obj);
	}
	return true;
}
function cal_error (str_message,obj)
{
		alert (str_message);
		obj.focus();
		obj.select();
		return null;
}
