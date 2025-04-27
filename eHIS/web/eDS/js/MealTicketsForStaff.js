/* New file MealTicketForStaff.js created against ML-MMOH-CRF-0675  */
function run(){
	var flag;
	var error="";
	var frm=f_query_rep.MealTicketForstaff;
	var ORDERDATE=getLabel("Common.OrderDate.label","common");
	var PRACTITIONERID = getLabel("Common.practitionerid.label","common");
	var PRACTITIONERNAME = getLabel("Common.practitionername.label","common");
	var p_facility_id = frm.p_facility_id.value;
	var p_user_name = frm.p_user_name.value;
	var p_module_id = frm.p_module_id.value;
	var p_report_id = frm.p_report_id.value;
	var p_language_id = frm.p_language_id.value;
	var facility_id = frm.facility_id.value;
	var locale = frm.locale.value;
	var datepattrn = frm.datepattrn.value;
	var p_menu_type = frm.MenuType.value;
	var P_ORDER_DATE = frm.date.value;
		if(P_ORDER_DATE.length<1){
		flag=false;
		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",ORDERDATE)+"<br>";
		}
		var P_DIET_REQ_LOC = frm.dietLocation.value;
		var P_MEAL_CAT = frm.mealCategory.value;
		if(P_MEAL_CAT == ""){
			flag=false;
			error+= getMessage("DS_MEAL_CATEGORY","DS")+"<br>";
		}
		var P_PRACTITIONER_ID="";
		if(P_MEAL_CAT == "DOC")
		{
			P_PRACTITIONER_ID=frm.practitioner_id.value;
			/*if(P_PRACTITIONER_ID.length<1 ){
			flag=false;
				error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",PRACTITIONERNAME)+"<br>";
		}*/
		}
		var P_DIET_TYPE=frm.DietType.value;
		var p_meal_class = frm.mealClass.value;
		var p_meal_type = frm.mealType.value;

						
		messageFrame.location.href ='../../eCommon/jsp/error.jsp?err_num='+error;
		if(flag==false) return false; 
		frm.target = "messageFrame";
		frm.action = "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&facility_id="+facility_id+"&locale="+locale+"&datepattrn="+datepattrn+"&p_menu_type="+p_menu_type+"&P_ORDER_DATE="+P_ORDER_DATE+"&P_DIET_REQ_LOC="+P_DIET_REQ_LOC+"&P_MEAL_CAT="+P_MEAL_CAT+"&P_PRACTITIONER_ID="+P_PRACTITIONER_ID+"&P_DIET_TYPE="+P_DIET_TYPE+"&p_meal_class="+p_meal_class+"&p_meal_type="+p_meal_type;
		frm.submit();		
}

function reset()
  {	
	 location.reload();
  }

function callPractitioner(Category){
	var mealCategory = Category.value;
	if(mealCategory == "DOC")
	{
		document.getElementById("practitioner_id").value = '';
		document.getElementById("practitionerid").value = '';
		document.getElementById("practitioner_name").value = '';
		document.getElementById("practitionername").value = '';
		document.getElementById("practName").style.display = '';		
	}
	else
	{
	    document.getElementById("practitioner_id").value = '';
		document.getElementById("practitionerid").value = '';
		document.getElementById("practitioner_name").value = '';
		document.getElementById("practitionername").value = '';
		document.getElementById("practName").style.display = 'none';
		document.getElementById("practId").style.display = 'none';
	}
}

function callPractSearch1(obj,target,locale, facilityid){ 	
	var spl_code="";
	var resource_type = "";
	var pract_type="";
	var practitioner_id1="";
	var clinic_code = "";	
		getPractitioner(obj,target,facilityid,spl_code,pract_type,clinic_code,practitioner_id1,"Q2");	
}

function checkForSpecCharsforID(event){
	var strCheck = '0123456789/';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);
	if (strCheck.indexOf(key) == -1) return false;
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
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
	xmlStr += " specialty_code=\"" +splty+ "\"";
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

function PractLookupRetVal(retVal,objName){ 
	var arr;
	if (retVal != null)
	{
		arr=unescape(retVal).split("~");		
		document.forms[0].practitioner_id.value=arr[0];	
		document.forms[0].practitionerid.value=arr[1];	
	    	document.forms[0].practitioner_name.value=arr[1];
		document.forms[0].practitionername.value=arr[0];	
     	}else
	{
	    	document.forms[0].practitioner_id.value="";	
		document.forms[0].practitionerid.value="";	
		document.forms[0].practitioner_name.value= "";
		document.forms[0].practitionername.value="";			
	}
}
