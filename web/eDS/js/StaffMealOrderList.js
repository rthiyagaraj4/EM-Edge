
	function run(){
		var flag =checkNull();
		if(flag==true){
			var formObj = parent.content.f_query_rep.StaffMealOrderList;

			var p_module_id = formObj.p_module_id.value;
			var p_report_id = formObj.p_report_id.value;
			var p_facility_id = formObj.p_facility_id.value;
			var p_user_name = formObj.p_user_name.value;
			var p_language_id = formObj.p_language_id.value;
			var facility_id = formObj.facility_id.value;
			var locale = formObj.locale.value;
			var datepattrn = formObj.datepattrn.value;
			var report_id = formObj.report_id.value;

			var date = formObj.date.value;
			var mealCategory = formObj.mealCategory.value;
			var dietType = formObj.dietType.value;
			var mealClass = formObj.mealClass.value;
			var mealType = formObj.mealType.value;
			var p_searchfor = formObj.SearchFor.value;//ML-MMOH-CRF-0825 - US08
			//CRF-0419
			var selectedValuesAll=formObj.selectedAll.value;
			var selectedValuesAllText=formObj.selectedAlldescription.value;	
			//CRF-0419			
			
			//CRF-0678
			var practid="";
			if(mealCategory == "DOC")
				practid=formObj.practitioner.value;
			//CRF-0678
			
			formObj.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&facility_id="+facility_id+
			"&locale="+locale+"&p_order_date="+date+"&p_meal_category="+mealCategory+"&p_diet_type="+dietType+"&p_meal_class="+mealClass+"&p_meal_type="+mealType+"&P_LOCATION_CODE="+selectedValuesAll+"&P_LOCATION_DESC="+selectedValuesAllText+"&P_PRACT_ID="+practid+"&p_searchfor="+p_searchfor;//CRF-0419 and CRF-0678
			formObj.submit();
		}
	}

	function checkNull(){
		var flag;
		var error="";
		var formObj = parent.content.f_query_rep.StaffMealOrderList;
		var date=formObj.date.value;
		var to_label=getLabel("Common.date.label","Common");
		if(date=="") {
			flag=false;
			error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",to_label)+"<br>";
		}
		
			messageFrame.location.href ='../../eCommon/jsp/error.jsp?err_num='+error;
		if(flag==false) return false; else return true;
	}

	function reset(){
		location.reload();
	}
	
//Added for List view CRF-0419	
function getlocation()
{     
	var facility = document.getElementById("facility_id").value;
	var formObj = parent.frames[1].document.forms[0];
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "func_mode=getlocationstaff&facility="+facility;//+"&locCode="+locCode;
	xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var loc = formObj.loc;
		while(loc.length > 0){
		loc.remove(0);
	}
	if(retVal != null && retVal != ""){
		var retValArr = retVal.split("???");
		if(retValArr!=''){
			var listOption	= document.createElement('option');
			listOption.value = "All";
			listOption.text = "All";
			listOption.selected="selected";
			loc.add(listOption);
				
			for(var i=0; i<retValArr.length; i++){
				var locCode = retValArr[i].split(":::");
				var listOption1	= document.createElement('option');
					listOption1.value = locCode[0];
					listOption1.text = locCode[1];					
					loc.add(listOption1);
			}
		}
	}
	else
	{
			var listOption	= document.createElement('option');
			listOption.value = "All";
			listOption.text = "All";
			listOption.selected="selected";
			loc.add(listOption);
	}	
}

function selectAll(selectedAll)
{
	    var selectedValues = $('#loc').val();
		var selectedValuesAll="";
		selectedValues=selectedValues.toString();
		selectedValuesAll = selectedValues.replace(/,/g, "','");
		selectedValues = selectedValues.replace(/,/g, "','");
		$('#selectedAll').val(selectedValuesAll);
						
		var selectedValuesText = $("#loc :selected").map(function() {
        	return $(this).text();}).get();
		var selectedValuesTextAll="";
		selectedValuesText=selectedValuesText.toString();

		selectedValuesTextAll =selectedValuesText.replace(/,/g, ",");
		selectedValuesText =  selectedValuesText.replace(/,/g, ",");
				
		$('#selectedAlldescription').val(selectedValuesTextAll);
		var formObj = parent.frames[1].document.forms[0];
		var loc = formObj.loc;
	
		if(selectedAll == "All"){			
				document.getElementById("selectedAll").value = "";
				document.getElementById("selectedAlldescription").value = "";			
			}
		else
			return;
}

 function checkForSpecCharsforID(event)
   {
	var strCheck = '0123456789/';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);
	if (strCheck.indexOf(key) == -1) return false;
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
  }
  
  
//Ml-MMOH-CRF-0678 starts Here
function callPractitioner(Category)
{
	var mealCategory = Category.value;
	if(mealCategory == "DOC")
	document.getElementById("practName").style.display = '';
	else
	document.getElementById("practName").style.display = 'none';
}

function callPractSearch1(obj,target,locale, facilityid){ 	
	var spl_code="";
	var resource_type = "";
	var pract_type="";
	var practitioner_id1="";
	var clinic_code = "";	
    	getPractitioner(obj,target,facilityid,spl_code,pract_type,clinic_code,practitioner_id1,"Q2");
	
}

function getPractitioner(obj,target,facility_id,splty,pract_type,clinic_code,practitioner_id,executeQuery){
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";
	practName_FName=target.name;
	practName_FValue=target.value;
	var sql="";
	var sql2="";
	var facilityId = facility_id;	
	if (executeQuery == "Q2"){		
		sql="SELECT DISTINCT a.practitioner_id, a.practitioner_name, a.PRACT_TYPE_DESC practitioner_type, a.POSITION_CODE  job_title, a.gender, am_get_desc.am_speciality(b.primary_speciality_code,'"+localeName+"','2') primary_specialty  FROM AM_PRACTITIONER_LANG_VW a, AM_PRACT_ALL_SPLTY_VW b WHERE A.PRACTITIONER_ID = b.PRACTITIONER_ID AND b.facility_id=NVL('"+facility_id+"',b.facility_id) AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND ";		
		if(pract_type!="")
		{
			sql=sql+"	a.pract_type='"+pract_type+"' AND ";
		}

		sql = sql+" UPPER(B.primary_speciality_code) LIKE  UPPER(nvl(replace(?,'%',''),a.primary_speciality_code)) AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.PRACTITIONER_NAME)  LIKE UPPER(NVL(?, a.PRACTITIONER_NAME))) AND UPPER(a.gender) LIKE NVL(UPPER(?), UPPER(a.gender)) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND a.LANGUAGE_ID = '"+localeName+"' ORDER BY 2 ";

		sql2= "SELECT DISTINCT a.practitioner_id, a.practitioner_name, a.PRACT_TYPE_DESC practitioner_type, a.POSITION_CODE  job_title, a.gender, am_get_desc.am_speciality(b.primary_speciality_code,'"+localeName+"','2') primary_specialty  FROM AM_PRACTITIONER_LANG_VW a, AM_PRACT_ALL_SPLTY_VW b WHERE A.PRACTITIONER_ID = b.PRACTITIONER_ID AND b.facility_id=NVL('"+facility_id+"',b.facility_id) AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND ";
		
		if(pract_type!="")
		{
			sql2=sql2+"	a.pract_type='"+pract_type+"' AND ";
		}
		sql2 = sql2+" UPPER(B.primary_speciality_code) LIKE  UPPER(nvl(replace(?,'%',''),a.primary_speciality_code)) AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) and UPPER(a.PRACTITIONER_NAME)  LIKE UPPER(NVL(?, a.PRACTITIONER_NAME))) AND UPPER(a.gender) LIKE NVL(UPPER(?), UPPER(a.gender)) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND a.LANGUAGE_ID = '"+localeName+"' ORDER BY 2 ";
	}
	/*var xmlDoc= new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp= new ActiveXObject( "Microsoft.XMLHTTP" ) ;*/
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +encodeURIComponent(practName_FName) + "\"";
	xmlStr += " practName_FValue=\"" +encodeURIComponent(practName_FValue)+ "\"";
	xmlStr += " practId_FName=\"" + practId_FName + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" +splty+ "\""; // Thursday, February 18, 2010 19335 Venkat S.
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);

	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);
	return;
}

function PractLookupRetVal(retVal,objName)
{ 
	var arr;
	if (retVal != null)
	{
		arr=unescape(retVal).split("~");		
        	document.forms[0].practitioner_name.value=arr[1];
		document.forms[0].practitioner.value=arr[0];		
	}else
	{
		document.forms[0].practitioner_name.value= "";
		document.forms[0].practitioner.value="";	
	}
}
//Ml-MMOH-CRF-0678 Ends Here
	
