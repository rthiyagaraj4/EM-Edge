/* New file DocAcknowledgeReportForStaff.js created against ML-MMOH-CRF-0730 [IN:062776] */
function run()
{
	var flag;
	var error="";
	var frm=f_query_rep.document.forms[0];
	var ORDERDATE=getLabel("eOT.MealOrderFrom.Label","ot");
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
	var P_ORDER_DATE = frm.mealOrderFrom.value;
		if(P_ORDER_DATE.length<1){
		flag=false;
		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",ORDERDATE)+"<br>";
		}
		var P_DIET_REQ_LOC = frm.dietLocation.value;
		var P_MEAL_CAT = frm.mealCategory.value;
		var P_PRACTITIONER_ID="";
		if(P_MEAL_CAT == "DOC")
		{
			P_PRACTITIONER_ID=frm.practitioner_id.value;
			if(P_PRACTITIONER_ID.length<1){
			flag=false;
	    		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",PRACTITIONERNAME)+"<br>";
		}
		}
		var P_DIET_TYPE=frm.DietType.value;
		var P_MEAL_STATUS=frm.setStatus.value;
		var P_COMPLAINTS ="";
		if(P_MEAL_STATUS == "MJ")
		{
			P_COMPLAINTS =frm.complaintCode.value;
		}				
		messageFrame.location.href ='../../eCommon/jsp/error.jsp?err_num='+error;
		if(flag==false) return false; 
		frm.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&locale="+locale+"&datepattrn="+datepattrn+"&P_ORDER_DATE="+P_ORDER_DATE+"&P_DIET_REQ_LOC="+P_DIET_REQ_LOC+"&P_MEAL_CAT="+P_MEAL_CAT+"&P_PRACTITIONER_ID="+P_PRACTITIONER_ID+"&P_DIET_TYPE="+P_DIET_TYPE+"&P_MEAL_STATUS="+P_MEAL_STATUS+"&P_COMPLAINTS="+P_COMPLAINTS;
		frm.submit();		
}

function reset(){
    location.reload();
}

function callPractitioner(Category)
{
	var mealCategory = Category.value;
	if(mealCategory == "DOC")
	{
		document.getElementById("practitioner_id").value = '';
		document.getElementById("practitionerid").value = '';
		document.getElementById("practitioner_name").value = '';
		document.getElementById("practitionername").value = '';
		document.getElementById("practName").style.display = '';
		//document.getElementById("practId").style.display = '';
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

function callComplaint(status)
{
	var statusval = status.value;
	if(statusval == "MJ")
	{
		document.getElementById("complaintDesc").value = '';
		document.getElementById("complaintCode").value = '';
		document.getElementById("complaint").style.display = '';		
	}
	else
	{		
		document.getElementById("complaintDesc").value = '';
		document.getElementById("complaintCode").value = '';
		document.getElementById("complaint").style.display = 'none';		
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
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);

	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(practSearch(encodeURIComponent(practName_FName),encodeURIComponent(practName_FValue),splty,responseText));	  
}

async function practSearch(practName_FName,practName_FValue,splty,responseText) {
	var retVal = 	new String();
	var dialogTop = "10px" ;
	var dialogHeight= "500px" ;
	var dialogWidth	= "800px" ;
		
	if(responseText =="true") {        	
	    dialogWidth="700px";
	}
	
	var status = "no";
	var arguments	= "" ;
	var tit="Pract Search";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	var sqlArray= new Array();
	//var objName="<%=practName_FName%>";
	var objName=practName_FName;
    arguments='';
	
	//retVal = window.showModalDialog("<%=request.getContextPath()%>/eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+"<%=practName_FValue%>"+"&practitioner_type="+"<%=practitioner_type%>"+"&primary_specialty="+"<%=specialty_code%>"+"&job_title="+"<%=job_title%>"+"&gender="+"<%=gender%>",arguments,features);
	
	retVal = await window.showModalDialog("../../eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+practName_FValue+"&practitioner_type="+"\""+"&primary_specialty="+splty+"&job_title="+"\""+"&gender="+"\"",arguments,features);
	PractLookupRetVal(retVal,objName); 
		
	
}


function PractLookupRetVal(retVal,objName)
{ 
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

async function complaintsLookup(obj) {
	var formObj = document.forms[0];
	var locale = document.getElementById("locale").value;
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql = "SELECT COMPLAINTS.LONG_DESC DESCRIPTION, COMPLAINTS.COMPLAINT_CODE  CODE FROM DS_COMPLAINTS_LANG_VW COMPLAINTS WHERE UPPER(COMPLAINTS.LONG_DESC) LIKE UPPER(?) AND UPPER(COMPLAINTS.COMPLAINT_CODE) LIKE UPPER(?) AND COMPLAINTS.LANGUAGE_ID= '"
			+ locale + "' AND   COMPLAINTS.EFF_STATUS='E'";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = document.getElementById("complaintDesc").value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	var title=getLabel("eOT.Complaints.Label","OT");
	returnedValues = await CommonLookup(title, argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		document.getElementById("complaintDesc").value = arr[1];
		document.getElementById("complaintCode").value = arr[0];
	} else {
		document.getElementById("complaintDesc").value = '';
		document.getElementById("complaintCode").value = '';
	}
}

