<!DOCTYPE html>
<%@page import="eDS.Common.DlQuery"%>
<%@ page import="webbeans.eCommon.ConnectionManager,java.sql.Connection,eCommon.Common.*,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,java.sql.Timestamp,java.text.DateFormat,java.text.SimpleDateFormat"%><!--Modified Against ML-MMOH-CRF-0672-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<head>

<%
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ?
	(String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
	if(sStyle==null)sStyle="IeStyle.css";
	String facility_Id	= (String)session.getAttribute("facility_id");
	String language_Id  = (String)session.getAttribute("LOCALE");
	session.removeAttribute("ALLMENUITEMSMAP"); // AAKH-CRF-0065
	String param = request.getQueryString();
 %>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eDS/js/json.js"></script>
	<script type="text/javascript">
		var jsonPatientArr = new Array();
		var checkAllPatientArr = new Array(); 
		var jsonPatientObject = new Object();	
		var jsonData;
		var pageJsonData;
		var checkAllData;
		var tempObj=eval('(' + parent.patientObj_NextPrev + ')');

		if(tempObj !=null && tempObj.patients !=null) {
			jsonPatientArr=eval('(' + parent.patientObj_NextPrev + ')').patients;
			jsonPatientObject.patients=jsonPatientArr;
			jsonData=parent.patientObj_NextPrev;		
		}
		
		//Added for CRF-0113 Started
		var scrollValue=0;
        	var reorder = ''; 
		var anchorID =''; 
		
//Added Against ML-MMOH-CRF-0600 Starts Here ToolTip
function PendingMealAckToolTip(facility_Id,encounter_Id){	   
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var param="facility_Id="+facility_Id+"&encounter_Id="+encounter_Id+"&mode=pendingMealOrderAckDetail_IP";
	xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;	
	var jsonObjResponse=eval('(' + retVal + ')');	
	var orderList=new Array();
	orderList = jsonObjResponse.jsonMealPendingListIP; 
	var OrderDate=getLabel("eDS.OrderDate.Label","ds_labels");
	var MealType=getLabel("eDS.MealType.Label","ds_labels");
	var Status=getLabel("eDS.Status.Label","ds_labels");	
	var tab_dat  = "<table id ='tooltiptable1' cellpadding='3' cellspacing=0 border='1' class='BOX' width='100%' height='100%' align='center'>";
		tab_dat     += "<tr>"
		tab_dat     += "<th nowrap> <B>"+OrderDate+"</B> </a> </th>"
		tab_dat     += "<th nowrap> <B>"+MealType+" </B> </a> </th>"
		tab_dat     += "<th nowrap> <B>"+Status+"</B> </a> </th>"
		tab_dat     += "</tr> ";
		for(var i=0;i<orderList.length;i++)
		{	
			tab_dat     += "<tr>"
			tab_dat     += "<td class='label'> "+(orderList[i].serving_date).substring(0,10)+" </td>"
			tab_dat     += "<td class='label'>"+orderList[i].mealtypeDesc+" </td>"
			tab_dat     += "<td class='label'>"+orderList[i].status+"</td>"
			tab_dat     += "</tr> ";
		}	
		tab_dat     += "</table> ";
		return tab_dat;
   }
//Added Against ML-MMOH-CRF-0600 Ends Here ToolTip

//function callOrderBy(obj,searchFor,status,NursingUnit,encounterId,patientId,patient_Name,room,bed,sex,fromDate,toDate){
function callOrderBy(obj,alaCarte,searchFor,status,NursingUnit,encounterId,patientId,patient_Name,room,bed,sex,fromDate,toDate){//ML-MMOH-CRF-1123-US2
	var url='&orderBy='+obj+'&reOrder='+reOrder+'&anchorID='+anchorID+'&leftScrolling='+scrollValue+'&alaCarte='+alaCarte+'&searchFor='+searchFor+'&status='+status+'&NursingUnit='+NursingUnit+'&encounterId='+encounterId+'&patientId='+patientId+'&room='+room+'&bed='+bed+'&sex='+sex+'&patient_Name='+patient_Name+'&fromDate='+fromDate+'&toDate='+toDate;//ML-MMOH-CRF-1123-US2
     parent.parent.workListResult.qa_query_result.location.href ='WorkListResultPage.jsp?'+url;
   }       	
	
function changeColor(object)
{
	anchorID=object.id;		
	if(object.style.color=='white')
  {
	reOrder='1';		
	object.style.color='pink';
	return;
  }
	if(object.style.color=='pink')
  {
	reOrder='2';
	object.style.color='yellow';
	return;
  }
	if(object.style.color=='yellow')
  {
	reOrder='1';
	object.style.color='pink';
	return;
  }
}
//Added for CRF-0113 End	

async function showContent(encounterId,patientId,locationCode,patientClass,room,bed,locationType,dateOfBirth,gender,flag,isLos_gt7,diffDays,alaCarte){
	if(!placedietorder())	//IN::39863
	return;	
	var params = "&encounterId="+encounterId+"&patientId="+patientId+"&locationCode="+locationCode+"&patientClass="+patientClass+"&room="+room+"&bed="+bed+"&locationType="+locationType+"&dateOfBirth="+dateOfBirth+"&gender="+gender+"&flag="+flag+"&diffDays="+diffDays+"&isLos_gt7="+isLos_gt7+"&alaCarte="+alaCarte;//Modified Against ML-MMOH-CRF-0672 and ML-MMOH-CRF-1123-US3
	var url = "../../eDS/jsp/PlaceDietOrderDSMain.jsp?"+params;
	var returnVal="";
	//var dialogFeatures = "dialogHeight:" + 500 + "; dialogWidth:" + 500 + "; scroll:no; status:no;";
	var dialogTop   = "65";
    var dialogHeight    = "900px" ; //30.5
    var dialogWidth = "1200px" ;
    var dialogFeatures    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
	var arguments = "";
	returnVal =await top.window.showModalDialog(url, arguments, dialogFeatures);
	parent.frames.qa_query_result.location.href ="../../eDS/jsp/WorkListResultPage.jsp?<%=param%>";
	parent.frames.qa_query_result_tail.location.href ="../../eDS/jsp/WorkListResultTailLegend.jsp";				
}
		
async function PlaceDietOrder_Group(){			
	var encounterIds_BulkOrder=document.getElementById("encounterIds_BulkOrder").value;
	var patientIds_BulkOrder=document.getElementById("patientIds_BulkOrder").value;
	var locationCode=document.getElementById("locationCode").value;
	var locationType=document.getElementById("locationType").value;		
	var patientClass_bulk=document.getElementById("patientClass_bulk").value;//ML-MMOH-CRF-0820
	var alaCarte=document.getElementById("alaCarte").value;//ML-MMOH-CRF-1123-US4
	var params ="locationCode="+locationCode+"&locationType="+locationType+"&patientClass_bulk="+patientClass_bulk+"&alaCarte="+alaCarte;//ML-MMOH-CRF-0820 and Modified Against ML-MMOH-CRF-1123-US4

	var url = "../../eDS/jsp/PlaceBulkDietOrderMain.jsp?"+params;
	var returnVal="";
	var dialogFeatures = "dialogHeight:" + 100 + "; dialogWidth:" + 100 + "; scroll:yes; status:no;";
	var arguments = "";
	var obj=eval('(' + jsonData + ')');
	if(obj==null) {
		alert(getMessage("DS_SEL_ATLEAST_2PAT","DS"));
		return;				
	}
	if(obj.patients==null) {
		alert(getMessage("DS_SEL_ATLEAST_2PAT","DS"));
		return;				
	}			
	if(obj.patients.length<2) {
		alert(getMessage("DS_SEL_ATLEAST_2PAT","DS"));
		return;
	}
	returnVal = await window.showModalDialog(url, obj, dialogFeatures);

	parent.frames.qa_query_result.location.href ="../../eDS/jsp/WorkListResultPage.jsp?<%=param%>";
	parent.frames.qa_query_result_tail.location.href ="../../eDS/jsp/WorkListResultTailLegend.jsp";			
}
		
function bulkOrder(encounterId,patientId,patientClass,dob,gender,profileSL,profileFromDate,obj,age,ageUnit,spFlag,dislikeFlag,diffDays) {//Added Against ML-MMOH-CRF-0672	
	var encounterIds_BulkOrder=document.getElementById("encounterIds_BulkOrder").value;
	var patientIds_BulkOrder=document.getElementById("patientIds_BulkOrder").value;
	var patientClass_bulk=document.getElementById("patientClass_bulk").value;//ML-MMOH-CRF-0820
	
	var jsonDataObject = new Object();
	if(obj.checked) {
		document.getElementById("encounterIds_BulkOrder").value=encounterIds_BulkOrder+""+encounterId+"~";
		document.getElementById("patientIds_BulkOrder").value=patientIds_BulkOrder+""+patientId+"~";
		document.getElementById("patientClass_bulk").value =patientClass_bulk+""+patientClass+"~";//ML-MMOH-CRF-0820
		jsonDataObject.encounterId=encounterId;
		jsonDataObject.patientId=patientId;
		jsonDataObject.patientClass=patientClass;
		jsonDataObject.dob=dob;
		jsonDataObject.gender=gender;
		jsonDataObject.profileSL=profileSL;
		jsonDataObject.fromDate=profileFromDate;
		jsonDataObject.age=age;
		jsonDataObject.ageUnit=ageUnit;
		jsonDataObject.spFlag=spFlag;
		jsonDataObject.dislikeFlag=dislikeFlag;
		jsonDataObject.newFlag="";				
		jsonDataObject.diffDays=diffDays;//Added Against ML-MMOH-CRF-0672 
		jsonPatientArr.push({patient:jsonDataObject});
	}
	else {
		for(var i=0;i<jsonPatientArr.length;i++) {
			var testObj=new Object();
			testObj=jsonPatientArr[i];
			if(testObj.patient.encounterId==encounterId) {
				jsonPatientArr.splice(i,1);
			}
		}
		document.getElementById("chkAll").checked=false;
		
		if(tempObj !=null && tempObj.patients !=null) {
			var obj=eval('(' + parent.patientObj_NextPrev + ')').patients;
			for(var cnt=0;cnt<obj.length;cnt++) {
				var testObj=new Object();
				testObj=obj[cnt];
				if(testObj.patient.encounterId==encounterId) {
					obj.splice(cnt,1);
					break;
				}
			}
			var obj1={};
			obj1.patients=obj;
			parent.patientObj_NextPrev=JSON.stringify(obj1);
		}
	}
	jsonPatientObject.patients=jsonPatientArr;			
	jsonData = JSON.stringify(jsonPatientObject);

	var obj=eval('(' + jsonData + ')');
	if(obj.patients==null) {
		document.getElementById("Button_BulkOrder").disabled=true;
		return;
	}	
	else if(obj.patients.length<2) {
		document.getElementById("Button_BulkOrder").disabled=true;
	}
	else {
		document.getElementById("Button_BulkOrder").disabled=false;
	}
}

function checkAll(obj){
	var encounterId=" ";
	if(obj.checked) {
		if(tempObj !=null && tempObj.patients !=null) {
			jsonPatientArr=eval('(' + parent.patientObj_NextPrev + ')').patients;
		}
		else {
			jsonPatientArr.splice(0,jsonPatientArr.length);
			jsonPatientObject={};					
		}
		for(var i=0;i<checkAllPatientArr.length;i++) {					
			encounterId=checkAllPatientArr[i].patient.encounterId;					
			if(document.getElementById("chk"+encounterId)!=null && document.getElementById("chk"+encounterId).disabled !=true) {//Added Against ML-MMOH-CRF-0600
				jsonPatientArr.push({patient:checkAllPatientArr[i].patient});
				document.getElementById("chk"+encounterId).checked=true;
			}
		}
		jsonPatientObject.patients=jsonPatientArr;
	}
	else {
		if(tempObj!=null && tempObj.patients!=null) {
			jsonPatientArr.splice(0,jsonPatientArr.length);
			jsonPatientArr=eval('(' + parent.patientObj_NextPrev + ')').patients;
			jsonPatientObject={};
			jsonPatientObject.patients=jsonPatientArr;
		}
		else {
			jsonPatientArr.splice(0,jsonPatientArr.length);
			jsonPatientObject={};
		}
		for(var i=0;i<checkAllPatientArr.length;i++) {
			encounterId=checkAllPatientArr[i].patient.encounterId;
			if(document.getElementById("chk"+encounterId)) {
			
				document.getElementById("chk"+encounterId).checked=false;
				
				for(var cnt=0;cnt<jsonPatientArr.length;cnt++) {
					var testObj=new Object();
					testObj=jsonPatientArr[cnt];
					if(testObj.patient.encounterId==encounterId) {
						jsonPatientArr.splice(cnt,1);
						break;
					}
				}
				
				if(tempObj !=null && tempObj.patients !=null) {
					var obj=eval('(' + parent.patientObj_NextPrev + ')').patients;
					for(var cnt=0;cnt<obj.length;cnt++) {
						var testObj=new Object();
						testObj=obj[cnt];
						if(testObj.patient.encounterId==encounterId) {
							obj.splice(cnt,1);
							break;
						}
					}
					var obj1={};
					obj1.patients=obj;
					parent.patientObj_NextPrev=JSON.stringify(obj1);
				}
			}
		}
		jsonPatientObject={};
		jsonPatientObject.patients=jsonPatientArr;				
	}
	jsonData = JSON.stringify(jsonPatientObject);
	var obj=eval('(' + jsonData + ')');
	if(obj==null || obj.patients==null) {
		document.getElementById("Button_BulkOrder").disabled=true;
		return;
	}			
	else if(obj.patients.length<2) {
		document.getElementById("Button_BulkOrder").disabled=true;
	}
	else {
		document.getElementById("Button_BulkOrder").disabled=false;
	}			
}
		
function savePatientObj() {	
	parent.patientObj_NextPrev=JSON.stringify(jsonPatientObject);		
}
</script>

<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<script type="text/javascript" src="../../eOT/js/wz_tooltip.js"></script><!--Added Against ML-MMOH-CRF-0600-US2 ToolTip--> 

	<%
		String whereClause = checkForNull(request.getParameter("whereclause"));
		if(whereClause==null) whereClause="";
   	    String sql = "";
   	    int maxRecord = 0;
		//MMS-CRF-006
		PreparedStatement pstmt=null,pstmt1 = null,pstmt2=null,pstmt3=null,pstmt4=null,pstmt5=null,pstmt6=null,pstmt7=null,pstmt_KitchenCode = null,pstmt8=null,pstmt9=null,pstmt10 = null,pstmt11 = null;//Modified Against ML-MMOH-CRF-1005-US2 
		ResultSet rst=null,rst1 = null,rst2=null,rst3=null,rst4=null,rst5=null,rst6=null,rst7=null,rst_KitchenCode=null,rst8=null,rst9=null,rst10=null,rst11=null;//Modified Against ML-MMOH-CRF-1005-US2 

		Connection conn = null;
		conn = ConnectionManager.getConnection(request);
       //  	String visitStyle ="";//Added for CRF-0113
		//Added Against ML-MMOH-CRF-0672 Starts Here
		boolean isLos_gt7=false;
		isLos_gt7=CommonBean.isSiteSpecific(conn,"DS","PLACE_ORDER_FOR_ATTENDANT");
		//Using same function for Selayang
		//Added Against ML-MMOH-CRF-1123-US2 Starts Here
		boolean isAlaCarte=false;
		isAlaCarte=CommonBean.isSiteSpecific(conn,"DS","PLACE_ORDER_FOR_ATTENDANT");
		//Added Against ML-MMOH-CRF-1123-US2 Ends Here
		
		//Added Against ML-MMOH-SCF-1804 Starts
		boolean isBedNum = false;
		isBedNum = CommonBean.isSiteSpecific(conn,"DS","DS_MEAL_COMPLAINTS");
		//Added Against ML-MMOH-SCF-1804 Ends
		
		//Added Against ML-MMOH-CRF-0672 Ends Here
		String NursingUnit = request.getParameter("NursingUnit");
		String encounterId = request.getParameter("encounterId");
		String patientId = request.getParameter("patientId");
		String practitionerId = request.getParameter("practitionerId");
		String sex = request.getParameter("sex");
		String fromDate = com.ehis.util.DateUtils.convertDate(request.getParameter("fromDate"),"DMY", language_Id, "en");
		String toDate = com.ehis.util.DateUtils.convertDate(request.getParameter("toDate"),"DMY", language_Id, "en");
		String from = checkForNull(request.getParameter("from"));
		String to = checkForNull(request.getParameter( "to" ));
		String status = checkForNull(request.getParameter("status"));
		//MMS-CRF-006
		String searchFor = checkForNull(request.getParameter("SearchFor"));
		//ML-MMOH-CRF-1123-US2
		String alaCarte="";
		if(isAlaCarte==true){
			alaCarte = checkForNull(request.getParameter("alaCarte"));
		}else{
			alaCarte = "";
		}
		//ML-MMOH-CRF-1123-US2
		String DIET_TYPE_MODIFIED="";
		//String dietician="";
		//MMS-CRF-006
		String NBM_DIET="";//ML-MMOH-CRF-0410
		//Added for CRF-0113
        String reOrder = request.getParameter("reOrder")==null?"":request.getParameter("reOrder");
		String orderBy = request.getParameter("orderBy")==null?"":request.getParameter("orderBy");
		//String leftScrolling= request.getParameter("leftScrolling")==null?"":request.getParameter("leftScrolling");
	    String anchorID= request.getParameter("anchorID")==null?"":request.getParameter("anchorID");
		//Added for CRF-0113
		int start = (from.equals(""))?1:Integer.parseInt(from);
		int end = (to.equals(""))?10:Integer.parseInt(to);//Added Against ML-MMOH-CRF-1005-US2
		int gracePeriod = 0;
	  	//Modified against ML-MMOH-CRF-0600-US2 starts here
		String AllowOrderIP = "";
		String strQury = "select grace_period,ALLOW_PLACE_ORD_IP  from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = '"+facility_Id+"'";
		String patientAge = "";   //Added Against PMG2017-COMN-CRF-0012[IN:066074]
    	try{
    		pstmt = conn.prepareStatement(strQury);
    		rst	= pstmt.executeQuery();
    		if(rst != null && rst.next()){
    			gracePeriod = rst.getInt(1);
				AllowOrderIP = rst.getString(2);			
		//Modified against ML-MMOH-CRF-0600-US2 ends here
    		}
    	}
    	catch(Exception ee){
    		System.err.println("Exception in WorkListResultPage-->"+ee.getMessage());
		ee.printStackTrace();
    	}

    	boolean flag=false;    	
		//Commented against CRF-0410
		//String strsql = "select distinct to_char(a.visit_Adm_Date_Time,'DD/MM/YYYY HH24:MI:SS'),a.encounter_Id,a.patient_Id, m.patient_name,m.sex, to_char(m.date_Of_Birth,'DD/MM/YYYY'),a.assign_Care_Locn_Type, a.assign_Care_Locn_Code, i.short_Desc,a.assign_Room_Num, a.assign_Bed_Num,a.patient_Class,a.discharge_date_time,a.adt_status from Pr_Encounter a, Mp_Patient m,Mp_Episode_Type_Vw v, Ip_Nursing_Unit_Lang_Vw i,ds_epsd_diet_profile_hdr hdr,ds_epsd_meal_plan_hdr mealplan,ds_epsd_dietician_referral ref where a.PATIENT_CLASS = v.patient_Class and i.facility_Id = a.facility_Id and i.nursing_Unit_Code = a.assign_Care_Locn_Code and i.language_Id='"+language_Id+"'and ((a.discharge_date_time + '"+gracePeriod+"' / 24) >=  SYSDATE or a.discharge_Date_Time is null) and  a.adt_Status <> '09' and a.PATIENT_CLASS in ('IP','DC') and a.deceased_Date_Time is null and a.FACILITY_ID ='"+facility_Id+"' and a.patient_Id = m.patient_Id(+) AND ref.encounter_id(+) = a.encounter_id AND ref.operating_facility_id(+) = a.facility_id ";//MMS-CRF-006
		 //Modified against CRF-0410 Starts
		 //String strsql = "select distinct to_char(a.visit_Adm_Date_Time,'DD/MM/YYYY HH24:MI:SS'),a.encounter_Id,a.patient_Id,TRIM(m.patient_name) patient_name, m.sex, to_char(m.date_Of_Birth,'DD/MM/YYYY'),a.assign_Care_Locn_Type, a.assign_Care_Locn_Code, i.short_Desc,a.assign_Room_Num, a.assign_Bed_Num,a.patient_Class,a.discharge_date_time,a.adt_status,a.visit_adm_date_time vst_dt_tm, get_age (m.date_of_birth) || ' / ' || DECODE (m.sex, 'M', 'Male', 'F', 'Female', 'Unknown') age from Pr_Encounter a, Mp_Patient m,Mp_Episode_Type_Vw v, Ip_Nursing_Unit_Lang_Vw i,ds_epsd_diet_profile_hdr hdr,ds_epsd_dietician_referral ref";//Added for CRF-0113 & ICN-64265 & PMG2017-CRF-0012[IN:066074]
		 String strsql = DlQuery.DL_PLACE_DIET_ORDER;
		
		 if ((status != null && status.equals("M")) || (status != null && status.equals("ALL"))){
		 		strsql=strsql+",ds_epsd_meal_plan_hdr mealplan ";
		}
		 	if ((status != null && status.equals("A")) || (status != null && status.equals("ALL"))){
		 		strsql=strsql+",ds_epsd_nbm_profile nbm ";
		}		 
				strsql=strsql+" where a.PATIENT_CLASS = v.patient_Class and i.facility_Id = a.facility_Id and i.nursing_Unit_Code = a.assign_Care_Locn_Code and i.language_Id='"+language_Id+"'and ((a.discharge_date_time + '"+gracePeriod+"' / 24) >=  SYSDATE or a.discharge_Date_Time is null) and  a.adt_Status <> '09' and a.PATIENT_CLASS in ('IP','DC') and a.deceased_Date_Time is null and a.FACILITY_ID ='"+facility_Id+"' and a.patient_Id = m.patient_Id(+) AND ref.encounter_id(+) = a.encounter_id AND ref.operating_facility_id(+) = a.facility_id ";//MMS-CRF-006
		//Modified against CRF-0410 Ends
		
		if(isBedNum) strsql=strsql+"and assign_bed_num not in(' ')";	//Added Against ML-MMOH-SCF-1804
					
    	if((whereClause == null || whereClause.equals(""))){
    		int cnt=0;
     			if ( !(NursingUnit == null || NursingUnit.equals("")) ){
    				sql = sql + "and i.nursing_Unit_Code = replace('"+NursingUnit+"','%','')";
    					cnt++;
    			}
    			if ( !(encounterId == null || encounterId.equals("")) ){
    				if(cnt>0)
						sql = sql + "and a.encounter_Id = NVL('"+encounterId+"',a.encounter_id)";
	    			else{
						sql=sql+"where a.encounter_Id = NVL('"+encounterId+"',a.encounter_id)";
						cnt=1;
					}
				}
				if ( !(patientId == null || patientId.equals("")) ){
					if(cnt>0)
						sql = sql + " and a.patient_Id = NVL('"+patientId+"',a.patient_id)";
					else{
						sql=sql+" where a.patient_Id = NVL('"+patientId+"',a.patient_id)";
						cnt=1;
					}
				}
				if ( !(sex == null || sex.equals("")) ){
					if(cnt>0)
						sql = sql + "and m.sex =  NVL('"+sex+"',m.sex)";
					else{
						sql=sql+" where m.sex =  NVL('"+sex+"',m.sex)";
						cnt=1;
					}
				}
				if ( !(practitionerId == null || practitionerId.equals("")) ){
					if(cnt>0)
						sql = sql + "and nvl(a.attend_Practitioner_Id,'XX') = NVL('"+practitionerId+"',a.attend_Practitioner_Id) ";
					else{
						sql=sql+" where nvl(a.attend_Practitioner_Id,'XX') = NVL('"+practitionerId+"',a.attend_Practitioner_Id)";
						cnt=1;
					}
				}

				if ( !(fromDate == null || fromDate.equals("")) ){
					if(cnt>0)
						sql = sql + " and (trunc(a.visit_Adm_Date_Time) between to_date(nvl(replace('"+fromDate+"'||'%','%',''),'15/09/1947'),'dd/mm/yyyy')";
					else{
						sql=sql+" where (trunc(a.visit_Adm_Date_Time) between to_date(nvl(replace('"+fromDate+"'||'%','%',''),'15/09/1947'),'dd/mm/yyyy')";
						cnt=1;
					}
				}else{
					sql = sql + " and (trunc(a.visit_Adm_Date_Time) between to_date(nvl(replace('"+fromDate+"'||'%','%',''),'15/09/1947'),'dd/mm/yyyy')";
				}
				if ( !(toDate == null || toDate.equals("")) ){
					if(cnt>0)
						sql = sql + "and to_date(nvl(replace('"+toDate+"'||'%','%',''),'31/12/2999'),'dd/mm/yyyy'))";
					else{
						sql=sql+"where and to_date(nvl(replace('"+toDate+"'||'%','%',''),'31/12/2999'),'dd/mm/yyyy')) ";
						cnt=1;
					}
        		}else{
        			sql = sql + "and to_date(nvl(replace('"+toDate+"'||'%','%',''),'31/12/2999'),'dd/mm/yyyy'))";
        		}				
				
				if (status != null && status.equals("A")){
					if(cnt>0)
							//Commented against CRF-0410
							//sql = sql + "AND nvl(hdr.status, 'ZZ') <> 'X' and hdr.encounter_id(+)=a.encounter_id and mealplan.encounter_id(+)=a.encounter_id and trunc(sysdate) between hdr.period_from AND nvl(hdr.period_to,to_date('31/12/2999','DD/MM/YYYY'))";
							//Modified against CRF-0410
							sql = sql + " AND nbm.encounter_id(+) = a.encounter_id AND nbm.operating_facility_id(+) = a.facility_id AND NVL (nbm.status, 'ZZ') <> 'X' AND nvl(hdr.status, 'ZZ') <> 'X' and hdr.encounter_id(+)=a.encounter_id and ((trunc(sysdate) between hdr.period_from AND nvl(hdr.period_to,to_date('31/12/2999','DD/MM/YYYY'))) OR (TRUNC (SYSDATE) BETWEEN TRUNC(nbm.NIL_BY_MOUTH_FRM) AND NVL (nbm.NIL_BY_MOUTH_TO,TO_DATE ('31/12/2999','DD/MM/YYYY')))) AND NOT EXISTS (SELECT 1 from ds_epsd_meal_plan_hdr mealplan where mealplan.encounter_id = a.encounter_id and mealplan.operating_facility_id = a.facility_id AND TRUNC (mealplan.serving_date) = TRUNC (SYSDATE)  AND mealplan.meal_plan_modified_yn = 'Y')";
					else{
							//Commented against CRF-0410
							//sql=sql+"where hdr.encounter_id(+)=a.encounter_id AND nvl(hdr.status, 'ZZ') <> 'X' and mealplan.encounter_id(+)=a.encounter_id and trunc(sysdate) between hdr.period_from AND nvl(hdr.period_to,to_date('31/12/2999','DD/MM/YYYY'))";
							//Modified against CRF-0410						
							sql=sql+"where nbm.encounter_id(+) = a.encounter_id AND nbm.operating_facility_id(+) = a.facility_id AND NVL (nbm.status, 'ZZ') <> 'X' AND hdr.encounter_id(+)=a.encounter_id AND nvl(hdr.status, 'ZZ') <> 'X' and ((trunc(sysdate) between hdr.period_from AND nvl(hdr.period_to,to_date('31/12/2999','DD/MM/YYYY')))OR (TRUNC (SYSDATE) BETWEEN TRUNC(nbm.NIL_BY_MOUTH_FRM) AND NVL (nbm.NIL_BY_MOUTH_TO,TO_DATE ('31/12/2999','DD/MM/YYYY')))) AND NOT EXISTS (SELECT 1 from ds_epsd_meal_plan_hdr mealplan where mealplan.encounter_id = a.encounter_id and mealplan.operating_facility_id = a.facility_id AND TRUNC (mealplan.serving_date) = TRUNC (SYSDATE)  AND mealplan.meal_plan_modified_yn = 'Y')";
							cnt=1;
					}
				}
				
				if (status != null && status.equals("P")){
					if(cnt>0)
					//Commented against CRF-0410
					   //sql = sql + "and hdr.encounter_id=a.encounter_id and mealplan.encounter_id=a.encounter_id and sysdate not between hdr.period_from AND nvl(hdr.period_to,to_date('31/12/2999','DD/MM/YYYY'))";
						
						//Modified against CRF-0410 Starts
						sql=sql+"and  hdr.encounter_id(+)=a.encounter_id and (a.facility_id ,a.ENCOUNTER_ID) NOT IN (select hdr1.OPERATING_FACILITY_ID ,hdr1.ENCOUNTER_ID from ds_epsd_diet_profile_hdr hdr1 where hdr1.OPERATING_FACILITY_ID = '"+facility_Id+"' and hdr1.encounter_Id =NVL('"+encounterId+"',hdr1.encounter_id) and trunc(sysdate) between hdr1.period_from AND nvl(hdr1.period_to,to_date('31/12/2999','DD/MM/YYYY')) AND NVL (hdr1.status, 'ZZ') <> 'X' ) AND NOT EXISTS (SELECT 1 from ds_epsd_nbm_profile where encounter_id = a.encounter_id and operating_facility_id = a.facility_id AND TRUNC (SYSDATE) BETWEEN TRUNC(NIL_BY_MOUTH_FRM) AND NVL (TRUNC(NIL_BY_MOUTH_TO), TO_DATE ('31/12/5000', 'DD/MM/YYYY' )))";
					
					else{
					//Commented against CRF-0410
						//sql = sql + "where hdr.encounter_id=a.encounter_id and sysdate not between hdr.period_from AND nvl(hdr.period_to,to_date('31/12/2999','DD/MM/YYYY'))";
						//Modified against CRF-0410 Starts
						sql=sql+"where hdr.encounter_id(+)=a.encounter_id and (a.facility_id ,a.ENCOUNTER_ID) NOT IN (select hdr1.OPERATING_FACILITY_ID ,hdr1.ENCOUNTER_ID from ds_epsd_diet_profile_hdr hdr1 where hdr1.OPERATING_FACILITY_ID = '"+facility_Id+"' and hdr1.encounter_Id =NVL('"+encounterId+"',hdr1.encounter_id) and trunc(sysdate) between hdr1.period_from AND nvl(hdr1.period_to,to_date('31/12/2999','DD/MM/YYYY')) AND NVL (hdr1.status, 'ZZ') <> 'X' ) AND NOT EXISTS (SELECT 1 from ds_epsd_nbm_profile where encounter_id = a.encounter_id and operating_facility_id = a.facility_id AND TRUNC (SYSDATE) BETWEEN TRUNC(NIL_BY_MOUTH_FRM) AND NVL (TRUNC(NIL_BY_MOUTH_TO), TO_DATE ('31/12/5000', 'DD/MM/YYYY' )))";
						
						cnt=1;
					}
				}

				if (status != null && status.equals("M")){
					if(cnt>0)
						sql = sql + "and hdr.encounter_id(+)=a.encounter_id and mealplan.encounter_id(+)=a.encounter_id and mealplan.meal_plan_modified_yn='Y' and trunc(mealplan.serving_date)=trunc(sysdate)";
					else{
						sql=sql+"where hdr.encounter_id(+)=a.encounter_id and mealplan.encounter_id(+)=a.encounter_id and mealplan.meal_plan_modified_yn='Y' and trunc(mealplan.serving_date)=trunc(sysdate)";
						cnt=1;
					}
				}
				//Maheshwaran K modified the query for performance issue for specific ward -ML-MMOH-SCF-2366
				if (status != null && status.equals("ALL")){
					if(cnt>0){
						//sql = sql + "AND nbm.encounter_id(+) = a.encounter_id AND nbm.operating_facility_id(+) = a.facility_id and hdr.encounter_id(+)=a.encounter_id and mealplan.encounter_id(+)=a.encounter_id ";
						sql = sql + "AND nbm.encounter_id(+) = hdr.encounter_id AND nbm.operating_facility_id(+) = hdr.operating_facility_id AND nbm.profile_sl (+) = hdr.profile_sl and hdr.encounter_id(+)=a.encounter_id  AND hdr.operating_facility_id (+) = a.facility_id AND mealplan.encounter_id(+)=a.encounter_id AND mealplan.operating_facility_id (+) = a.facility_id "; 
					}else{
						//sql=sql+"where nbm.encounter_id(+) = hdr.encounter_id AND nbm.operating_facility_id(+) = a.facility_id AND hdr.encounter_id(+)=a.encounter_id and mealplan.encounter_id(+)=a.encounter_id ";
						sql=sql+"where nbm.encounter_id(+) = hdr.encounter_id AND nbm.operating_facility_id(+) = hdr.operating_facility_id AND nbm.profile_sl (+) = hdr.profile_sl AND hdr.encounter_id(+)=a.encounter_id  AND hdr.operating_facility_id (+) = a.facility_id AND mealplan.encounter_id(+)=a.encounter_id AND mealplan.operating_facility_id (+) = a.facility_id ";
						cnt=1;
					}				
				}
				
				//Added Below Conditition Against KDAH-CRF-0511
				 if (status != null && status.equals("R")){
					if(cnt>0)
						sql = sql + " AND hdr.encounter_id(+)=a.encounter_id AND TRUNC(SYSDATE) = hdr.PERIOD_TO  ";
					else{
						sql=sql+" where hdr.encounter_id(+)=a.encounter_id AND TRUNC(SYSDATE) = hdr.PERIOD_TO  ";
						cnt=1;
					}				
				} 
				
				
				//MMS-CRF-006
				if(searchFor!=null && searchFor.equals("RD"))	{
					sql=sql+"	AND ref.dietician_refrl_yn='Y' 	";
				}//MMS-CRF-006
				
			     if(searchFor!=null && searchFor.equals("DM")) {					
					sql=sql+"AND hdr.diet_type_modified = 'Y' AND (TRUNC (SYSDATE) BETWEEN hdr.period_from AND NVL (hdr.period_to,TO_DATE ('31/12/2999', 'DD/MM/YYYY')) OR hdr.PERIOD_FROM > TRUNC (SYSDATE)) AND hdr.diet_type_modified='Y' and nvl(hdr.status,'N') !='X' ";//59325
				 }
				 if(searchFor!=null && searchFor.equals("CD")){
					sql=sql+"	AND  hdr.diet_type_modified = 'Y' AND TRUNC (SYSDATE) BETWEEN hdr.period_from AND NVL (hdr.period_to,TO_DATE ('31/12/2999', 'DD/MM/YYYY')) and nvl(hdr.status,'N') !='X' ";
				 }
				 if(searchFor!=null && searchFor.equals("FD")){
					sql=sql+"	AND hdr.PERIOD_FROM > TRUNC (SYSDATE) AND hdr.diet_type_modified='Y' and nvl(hdr.status,'N') !='X'	";
				 }
				//Added for ML-MMOH-CRF-1123-US2 Starts
				if(isAlaCarte==true){
				 if(alaCarte.equals("AC")){
					sql=sql+"	AND trunc(sysdate - a.visit_adm_date_time) > 8 ";
				 } 
				  if(alaCarte.equals("NAC")){
					 sql=sql+"	AND trunc(sysdate - a.visit_adm_date_time) < 8 ";
				 }
				}
				//Added for ML-MMOH-CRF-1123-US2 Ends
	//Added for CRF-0113 Starts
//	String desc="";
          		   if (orderBy.equals("AD")){
					if(reOrder.equals("1")){
							sql= sql+" order by vst_dt_tm desc ";
							
					}else{
							sql =sql+" order by vst_dt_tm  ";
						
					}
			   }else if (orderBy.equals("EN")){
					if(reOrder.equals("1")){
						     sql =sql+" order by encounter_id desc ";
					}else{
							sql= sql+" order by encounter_id ";
					}
			   }else if (orderBy.equals("PI")){
					if(reOrder.equals("1")){
							 sql =sql+" order by patient_id desc ";
					}else{
							 sql= sql+" order by patient_id ";
					}
			  }else if (orderBy.equals("PN")){
					if(reOrder.equals("1")){
							 sql =sql+" order by lower(trim(patient_name)) desc ";
					}else{
							 sql =sql+" order by lower(trim(patient_name)) ";//Modified for ICN-64265
					}
			  }else if(orderBy.equals("GN")){
				    if(reOrder.equals("1")){
						   sql =sql+" order by sex desc ";
					}else{
						   sql =sql+" order by sex ";
				    }
			  }
			  else if(orderBy.equals("RM")){
				       if(reOrder.equals("1")){
						   sql =sql+" order by assign_Room_Num desc ";
					}else{
						   sql =sql+" order by assign_Room_Num ";						  
					}
					} 
			  else if(orderBy.equals("BD")){
		              if(reOrder.equals("1")){
						   sql =sql+" order by assign_Bed_Num desc ";
					}else{
						   sql =sql+" order by assign_Bed_Num";
					}
					  }                
    }
    	//Added for CRF-0113 Ends
       else
            sql = whereClause;
             //end of where clause IF
 			strsql=strsql+sql;			
 	  try{
	     	String adm_Date = "";
	     	String encounter_Id = "";
	     	String patient_Id = "";
	     	String patient_Name = ""; 
	     	String gender = "";
	     	String location = "";
	     	String bed = "";
	     	String room = "";
	     	String classValue= "";
	     	String dateOfBirth = "";
	     	String locationType = "";
	     	String patientClass = "";
	     	String isMealPlanModified="";
	     	String dieticianReferral="";
	     	String dieticianReferralNew="";
	     	String fromdate="";
	     	String profileSL="";
	     	Boolean isMealOrderActive=false;
	     	String classStatus= "";
	     	String classDieticianReferral="";
	     	String classDieticianReferralNew="";
	     	String language_id = (String)session.getAttribute("LOCALE");
	     	//int i = 0;
	     	String flag1 = "";
	     	pstmt = conn.prepareStatement(strsql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE) ;		
			rst	= pstmt.executeQuery();
			//getting maximum record
	    	rst.last();	maxRecord = rst.getRow();
	    	if(maxRecord == 0){
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
			}
			//again move the resultset pointer to initial position
			rst.beforeFirst();			
			
			//IN::39863 - Check if the selected nursing unit is  mapping value
			String strQuery_kitchencode = "select count(*) from Ds_Wards_Kitchen_Vw where operating_Facility_Id = '"+facility_Id+"' and  NURSING_UNIT_CODE='"+NursingUnit+"' and linked_yn = 'Y'";
			pstmt_KitchenCode = conn.prepareStatement(strQuery_kitchencode);
			rst_KitchenCode	= pstmt_KitchenCode.executeQuery();
			int count = 0;
    		if(rst_KitchenCode != null && rst_KitchenCode.next()){
    			count = rst_KitchenCode.getInt(1);
    		}
			if(count == 0){
				out.println("<script>function placedietorder(){alert(getMessage('DS_KIT_NOTSET_FOR_NURSUNIT','DS'));return false;}</script>");
			}else{
				out.println("<script>function placedietorder(){return true;}</script>");
			}
		 	//IN:39863
	%>	
	<form name='QueryResult' id='QueryResult'>
	<input type="hidden" name="locationCode" id="locationCode" value="">
	<input type="hidden" name="locationType" id="locationType" value="">
	<input type="hidden" name="maxAge" id="maxAge" value="">
	<input type="hidden" name="ageUnit" id="ageUnit" value="">
	<input type="hidden" name="patientClass" id="patientClass" value="">
	<input type="hidden" name="alaCarte" id="alaCarte" id="alaCarte" value="<%=alaCarte%>"><!--Added Against ML-MMOH-CRF-1123-US4 -->
<table  align='right'>
<tr><td>
<%
if ( !(start <= 1) ){ 
%>
	<A HREF="../../eDS/jsp/WorkListResultPage.jsp?from=<%=(start-10)%>&to=<%=(end-10)%>&whereclause=<%=URLEncoder.encode(sql)%>&NursingUnit=<%=NursingUnit%>&status=<%=status%>&encounterId=<%=encounterId%>&patientId=<%=patientId%>&patient_Name=<%=patient_Name%>&room=<%=room%>&bed=<%=bed%>&sex=<%=sex%>&fromDate=<%=fromDate%>&toDate=<%=toDate%>&reOrder=<%=reOrder%>&anchorID=<%=anchorID%>&alaCarte=<%=alaCarte%>" onclick ="savePatientObj();" text-decoration='none'><fmt:message key="Common.previous.label" bundle='${common_labels}' /></A> 
	<!--CRF-410 & CRF-0113 & CRF-1005-US2 and Modified Against ML-MMOH-CRF-1123-US3-->
<%}if ( !( (start+10) > maxRecord ) ) {
	%>     
	<A HREF="../../eDS/jsp/WorkListResultPage.jsp?from=<%=(start+10)%>&to=<%=(end+10)%>&whereclause=<%=URLEncoder.encode(sql)%>&NursingUnit=<%=NursingUnit%>&status=<%=status%>&encounterId=<%=encounterId%>&patientId=<%=patientId%>&patient_Name=<%=patient_Name%>&room=<%=room%>&bed=<%=bed%>&sex=<%=sex%>&fromDate=<%=fromDate%>&toDate=<%=toDate%>&reOrder=<%=reOrder%>&anchorID=<%=anchorID%>&alaCarte=<%=alaCarte%>"  onclick="savePatientObj();"  text-decoration='none'><fmt:message key="Common.next.label" bundle='${common_labels}' /></A>
	<!--CRF-410 & CRF-0113 & CRF-1005-US2 and Modified Against ML-MMOH-CRF-1123-US3-->
<%}%>
</td></tr>
</table>
<br><br>
<!-- Added for CRF-0113 Start -->
<table  class='grid' id='PatCriteriaTbl' name='PatCriteriaTbl' border="1" cellpadding="1" cellspacing="0" width="100%" >
	<tr>
	
		<TH class='columnHeadercenter' nowrap> <a id = 'w10' href="javascript:callOrderBy('AD','<%=alaCarte%>','<%=searchFor%>','<%=status%>','<%=NursingUnit%>','<%=encounterId%>','<%=patientId%>','<%=patient_Name%>','<%=location%>','<%=room%>','<%=bed%>','<%=locationType%>','<%=sex%>','<%=fromDate%>','<%=toDate%>');" onclick='changeColor(this);' style='color:white' ><fmt:message key="eOT.admDate.Label" bundle="${ot_labels}" /><!-- CRF-0113-->
    <div style='vertical-align:middle; display:inline;'>
	<span id='admId' value="w10"></span>
	</div>
		    </TH>
		<TH  class='columnHeadercenter' nowrap> <a id = 'w01' href="javascript:callOrderBy('EN','<%=alaCarte%>','<%=searchFor%>','<%=status%>','<%=NursingUnit%>','<%=encounterId%>','<%=patientId%>','<%=patient_Name%>','<%=location%>','<%=locationType%>','<%=room%>','<%=bed%>','<%=sex%>','<%=fromDate%>','<%=toDate%>');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.encounterid.label" bundle="${common_labels}" /></a><!--Modified Against ICN:74084-->
		<div style='vertical-align:middle; display:inline;'>
		<span id='encId' value="w01"></span>
		</div>
        </TH>
		<TH   class='columnHeadercenter' nowrap>
			<fmt:message key="Common.status.label" bundle="${common_labels}" />
		</TH>
		<!-- //CRF-410TH>
			<fmt:message key="eOT.DieticianReferral.label" bundle="${ot_labels}" />
		</TH //CRF-410-->		
		<TH   class='columnHeadercenter' nowrap> <a id = 'w03' href="javascript:callOrderBy('PI','<%=alaCarte%>','<%=searchFor%>','<%=status%>','<%=NursingUnit%>','<%=encounterId%>','<%=patientId%>','<%=patient_Name%>','<%=location%>','<%=room%>','<%=bed%>','<%=locationType%>','<%=sex%>','<%=fromDate%>','<%=toDate%>');" onclick='changeColor(this);' style='color:white'>
			<fmt:message key="Common.patientId.label" bundle="${common_labels}" /></a><!--Modified Against ICN:74084-->
			<div style='vertical-align:middle; display:inline;'>
			<span id='patId' value="w03"></span>
			</div> <!-- CRF-0113-->
		</TH>
		<TH   class='columnHeadercenter' nowrap> <a id = 'w04' href="javascript:callOrderBy('PN','<%=alaCarte%>','<%=searchFor%>','<%=status%>','<%=NursingUnit%>','<%=encounterId%>','<%=patientId%>','<%=patient_Name%>','<%=location%>','<%=room%>','<%=bed%>','<%=locationType%>','<%=sex%>','<%=fromDate%>','<%=toDate%>');" onclick='changeColor(this);' style='color:white'>
			<fmt:message key="Common.PatientName.label" bundle="${common_labels}" /></a>
			<div style='vertical-align:middle; display:inline;'>
			<span id='patNamId' value="w04"></span>
			</div><!-- CRF-0113-->
		</TH>
		<TH   class='columnHeadercenter' nowrap> <a id = 'w05' href="javascript:callOrderBy('GN','<%=alaCarte%>','<%=searchFor%>','<%=status%>','<%=NursingUnit%>','<%=encounterId%>','<%=patientId%>','<%=patient_Name%>','<%=location%>','<%=room%>','<%=bed%>','<%=locationType%>','<%=sex%>','<%=fromDate%>','<%=toDate%>');" onclick='changeColor(this);' style='color:white'>
			<fmt:message key="Common.gender.label" bundle="${common_labels}" /></a>
			<div style='vertical-align:middle; display:inline;'>
			<span id='genId' value="w05"></span>
			</div><!-- CRF-0113-->  
		</TH>
		<!--TH class='columnHeadercenter' nowrap> 
			<fmt:message key="Common.Location.label" bundle="${common_labels}" /></a>
			<div style='vertical-align:middle; display:inline;'>	
			<span id='locId' value="w06"></span>
         	</div>
		</TH--><!-- Commented Against PMG2017-COMN-CRF-0012[IN066074] -->
		<TH   class='columnHeadercenter' nowrap> <a id = 'w07' href="javascript:callOrderBy('BD','<%=alaCarte%>','<%=searchFor%>','<%=status%>','<%=NursingUnit%>','<%=encounterId%>','<%=patientId%>','<%=patient_Name%>','<%=location%>','<%=room%>','<%=bed%>','<%=locationType%>','<%=sex%>','<%=fromDate%>','<%=toDate%>');" onclick='changeColor(this);' style='color:white'>
			<fmt:message key="Common.Bed.label" bundle="${common_labels}" /></a>
			<div style='vertical-align:middle; display:inline;'>
			<span id='bedId' value="w07"></span><!-- CRF-0113-->
			</div>
		</TH>
		<TH   class='columnHeadercenter' nowrap> <a id = 'w08' href="javascript:callOrderBy('RM','<%=alaCarte%>','<%=searchFor%>','<%=status%>','<%=NursingUnit%>','<%=encounterId%>','<%=patientId%>','<%=patient_Name%>','<%=location%>','<%=room%>','<%=bed%>','<%=locationType%>','<%=sex%>','<%=fromDate%>','<%=toDate%>');" onclick='changeColor(this);' style='color:white'><fmt:message key="Common.room.label" bundle="${common_labels}" /></a>
		<div style='vertical-align:middle; display:inline;'>
		<span id='roomId' value="w08"></span> <!-- CRF-0113-->
		</div>
		</TH>
		<TH>
			<input type="checkbox" name="chkAll" id="chkAll" id ="ChkAll" onclick="checkAll(this)"/>
		</TH>
	</tr>
<!-- Added for CRF-0113 End -->
	<%
		if ( start!= 1 ) rst.absolute(start-1);
		int i=start;
		while(rst != null && rst.next() && i<=end){
				classStatus= "";
				classDieticianReferral= "";
				classDieticianReferralNew=""; // Refer to Dietician IN 42110
				isMealPlanModified="";
				isMealOrderActive=false;
				dieticianReferral="";
				dieticianReferralNew="";	// Refer to Dietician IN 42110
				fromdate="";
				profileSL="0";
				
				flag=true;
				if ( i % 2 == 0 )
					classValue = "QRYODD" ;
				else
					classValue = "QRYEVEN" ;

				adm_Date = com.ehis.util.DateUtils.convertDate(rst.getString(1),"DMYHMS", "en", language_id);
				encounter_Id = rst.getString(2);
				patient_Id = rst.getString(3);
				patient_Name = rst.getString(4);
				gender = rst.getString(5);
				dateOfBirth = rst.getString(6);
				locationType = rst.getString(7);
				location = rst.getString(8);
				//MMS-CRF-006
				//DIET_TYPE_MODIFIED=checkForNull(rst.getString("DIET_TYPE_MODIFIED"));
				//DIET_TYPE_MODIFIED="Y";
				//MMS-CRF-006
				
				if(rst.getString(10) ==  null){
					room = "&nbsp;";
				}else{
					room = rst.getString(10);
				}
				if(rst.getString(11) == null){
					bed = "&nbsp;";
				}else{
					bed = rst.getString(11);
				}
				if(rst.getString(13) != null && rst.getString(14).equals("08")){
					flag1 = "Y";
				}else{
					flag1 = "N";
				}				
				
				if(dateOfBirth.length()<11){dateOfBirth=dateOfBirth+" 00:00";}
				
				String ageGroupArray[] = null;
				String ageGroupArray1[] = null;
				
				ageGroupArray	=  dateOfBirth.split(" ");
				ageGroupArray1	=	ageGroupArray[0].split("/");
				Date today=new Date();
				
				Date dob=new Date(Integer.parseInt(ageGroupArray1[2])-1900, Integer.parseInt(ageGroupArray1[1]), Integer.parseInt(ageGroupArray1[0]));
				
				
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date tDate = dateFormat.parse(dateFormat.format(today));
								
				int one_day=1000*60*60*24;

				//Calculate difference btw the two dates, and convert to days
				//int days1=Math.floor((dob.getTime()-today.getTime())/(one_day))+1;				
				//long diff = Math.abs((today.getTime() - dob.getTime()));

				java.sql.Timestamp dateCompare = new 	Timestamp(tDate.getTime());
				
				long diff = Math.abs(dateCompare.getTime() - dob.getTime());
				
				int days1 = (int) Math.floor(diff/one_day);
				int year=365;
				int month=30;
				int years = days1/year;
				int days2=days1%year;
				int months=Math.abs(days2/month);
				int days=Math.abs(days2%month);
				
				int maxAge = 0;
				String ageUnit = "";

				if(Math.abs(years) > 0){
					maxAge=  Math.abs(years);
					ageUnit = "Y";
				}else if(Math.abs(months) > 0){
					maxAge =  Math.abs(months);
					ageUnit = "M";
				}else if( Math.abs(days) > 0){
					maxAge =  Math.abs(days);
					ageUnit = "D";
				}				
				
				patientClass = rst.getString(12);
				/*Added Against Start PMG2017-COMN-CRF-0012[IN:066074]*/
				patientAge = checkForNull(rst.getString("age"));				
				/*Added Against End PMG2017-COMN-CRF-0012[IN:066074]*/
				
				String sql_mealplan ="select MEAL_PLAN_MODIFIED_YN from ds_epsd_meal_plan_hdr where encounter_id='"+encounter_Id+"' and trunc(SERVING_DATE)=trunc(sysdate) and MEAL_PLAN_MODIFIED_YN='Y'";
				//String sql_activeMealOrder="select * from ds_epsd_diet_profile_hdr where encounter_id='"+encounter_Id+"' AND nvl(status, 'ZZ') <> 'X' and trunc(sysdate) between period_from AND nvl(period_to,to_date('31/12/2999','DD/MM/YYYY')) ";//CRF-410
				
				//Added Against ML-MMOH-CRF-1460 Starts
				boolean isMACNBM = false;
				isMACNBM = CommonBean.isSiteSpecific(conn,"DS","DS_MAC_NBM");
				String sql_activeMealOrder = "";
				if(isMACNBM)
				{
				 sql_activeMealOrder="select 'X' from ds_epsd_diet_profile_hdr where encounter_id='"+encounter_Id+"' AND nvl(status, 'ZZ') <> 'X' and trunc(sysdate) between period_from AND nvl(period_to,to_date('31/12/2999','DD/MM/YYYY')) union all select 'X' from ds_epsd_nbm_profile where encounter_id='"+encounter_Id+"' and nvl(status,'ZZ')<>'X' and trunc(sysdate) between trunc(NIL_BY_MOUTH_FRM) and trunc(NIL_BY_MOUTH_TO) UNION ALL SELECT 'X' FROM ds_epsd_diet_profile_att WHERE encounter_id = '"+encounter_Id+"' AND NVL (status, 'ZZ') <> 'X' AND TRUNC (SYSDATE) BETWEEN TRUNC (period_from) AND TRUNC (period_to) "; 
				}
				//Added Against ML-MMOH-CRF-1460 Ends
				else{
					sql_activeMealOrder="select 'X' from ds_epsd_diet_profile_hdr where encounter_id='"+encounter_Id+"' AND nvl(status, 'ZZ') <> 'X' and trunc(sysdate) between period_from AND nvl(period_to,to_date('31/12/2999','DD/MM/YYYY')) union all select 'X' from ds_epsd_nbm_profile where encounter_id='"+encounter_Id+"' and nvl(status,'ZZ')<>'X' and trunc(sysdate) between trunc(NIL_BY_MOUTH_FRM) and trunc(NIL_BY_MOUTH_TO)";//CRF-410
				}
				String sql_dieticianReferral="select dietician_refrl_yn from ds_epsd_diet_profile_hdr where encounter_id='"+encounter_Id+"' and trunc(sysdate) between period_from AND nvl(period_to,to_date('31/12/2999','DD/MM/YYYY'))";

				// Refer to Dietician IN 42110
				String sql_dieticianReferral_New = "select dietician_refrl_yn from ds_epsd_dietician_referral where encounter_id='"+encounter_Id+"'";

				String sql_maxProfileSL="select to_char(period_from,'DD/MM/YYYY'),(select max(profile_sl) from ds_epsd_diet_profile_hdr where encounter_id='"+encounter_Id+"') profile_sl from ds_epsd_diet_profile_hdr where encounter_id='"+encounter_Id+"' and profile_sl=(select max(profile_sl) from ds_epsd_diet_profile_hdr where encounter_id='"+encounter_Id+"')";
 
				//MMS-CRF-006				
		     	pstmt1 = conn.prepareStatement(sql_mealplan,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE) ;
				rst1	= pstmt1.executeQuery();
				while(rst1 != null && rst1.next()){
					isMealPlanModified="Y";
				}
				
		     	pstmt2 = conn.prepareStatement(sql_activeMealOrder,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE) ;
				rst2	= pstmt2.executeQuery();
				while(rst2 != null && rst2.next()){
					isMealOrderActive=true;
				}
				
		     	pstmt3 = conn.prepareStatement(sql_dieticianReferral,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE) ;
				rst3	= pstmt3.executeQuery();
				while(rst3 != null && rst3.next()){
					dieticianReferral = rst3.getString(1);
					if(dieticianReferral==null) dieticianReferral="&nbsp;"; 
				}
				
				pstmt4 = conn.prepareStatement(sql_maxProfileSL,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE) ;
				rst4	= pstmt4.executeQuery();
				while(rst4 != null && rst4.next()){
					fromdate=rst4.getString(1);
					profileSL = rst4.getString(2);
					if(fromdate==null) profileSL="";
					if(profileSL==null) profileSL="0"; 
				}
				
				// Refer to Dietician IN 42110
				pstmt5 = conn.prepareStatement(sql_dieticianReferral_New,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE) ;
				rst5	= pstmt5.executeQuery();
				while(rst5 != null && rst5.next()){
					dieticianReferralNew = rst5.getString(1);
					if(dieticianReferralNew==null) dieticianReferralNew="&nbsp;"; 
				}
				
				String sql_spl_foodItem_exists="select * from ds_epsd_diet_profile_spl where encounter_id ='"+encounter_Id+"' and profile_sl='"+profileSL+"' and operating_facility_id='"+facility_Id+"'";
				String sql_foodDislikes_exists="select * from ds_patient_food_dislikes where patient_id ='"+patient_Id+"'";
				String sp_flag="N";
				String dislike_flag="N";
				
				if(isMealPlanModified.equals("Y"))	classStatus="OAYELLOW";
				else if(isMealOrderActive) classStatus="OAGREEN";
				else classStatus="OARED";
				
				if(dieticianReferral.equals("Y"))	classDieticianReferral="CYANCLR";
				else classDieticianReferral=classValue;
				
				// Refer to Dietician IN 42110
				if(dieticianReferralNew.equals("Y"))	classDieticianReferralNew="CYANCLR";
				else classDieticianReferralNew=classValue;
				
				pstmt6 = conn.prepareStatement(sql_spl_foodItem_exists,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE) ;
				rst6	= pstmt6.executeQuery();
				while(rst6 != null && rst6.next()){
					sp_flag="Y";
					break;
				}

				pstmt7 = conn.prepareStatement(sql_foodDislikes_exists,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE) ;
				rst7	= pstmt7.executeQuery();
				while(rst7 != null && rst7.next()){
					dislike_flag="Y";
					break;
				}
				//006 starts
				
				String sql_DIET_TYPE_MODIFIED="select DIET_TYPE_MODIFIED from ds_epsd_diet_profile_hdr where encounter_id='"+encounter_Id+"' and ( trunc(sysdate) between period_from AND nvl(period_to,to_date('31/12/2999','DD/MM/YYYY')) ";//59325
					
				if(!isMealOrderActive){
					sql_DIET_TYPE_MODIFIED+=" OR PERIOD_FROM  > TRUNC (SYSDATE) ";
				}
					
				sql_DIET_TYPE_MODIFIED+=" ) and diet_type_modified='Y' and nvl(STATUS,'N') !='X'";
				
				//006 ends				
				pstmt8=conn.prepareStatement(sql_DIET_TYPE_MODIFIED,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				 rst8 =pstmt8.executeQuery();
				 if(rst8!=null && rst8.next())
				 {
				 DIET_TYPE_MODIFIED=checkForNull(rst8.getString("DIET_TYPE_MODIFIED"));//006		 
				 }else{
				 DIET_TYPE_MODIFIED="N";
				 }
				 
				 //410 color code changes starts 
				 if(classDieticianReferralNew.equals("CYANCLR")){
					classDieticianReferralNew="<img src=../../eDS/css/blue.png></img>";
				 }else{
					classDieticianReferralNew="";
				 }
				 
				 if(classStatus.equals("OAGREEN")){
					classStatus="<img src=../../eDS/css/green.png></img>";
				 }else if(classStatus.equals("OARED")){
					classStatus="<img src=../../eDS/css/red.png></img>";
				 }else if(classStatus.equals("OAYELLOW")){
					classStatus="<img src=../../eDS/css/yellow.png></img>";
				 }
				 //410 color code changes ends
				 
				String sql_NBM_diet ="SELECT 'F',to_char(nil_by_mouth_frm,'dd/mm/yyyy - hh24:mi'),to_char(nil_by_mouth_to,'dd/mm/yyyy - hh24:mi') FROM ds_epsd_nbm_profile WHERE encounter_id = '"+encounter_Id+"' AND TRUNC (SYSDATE) BETWEEN (TRUNC (nil_by_mouth_frm)) AND (TRUNC (nil_by_mouth_to)) AND operating_facility_id = '"+facility_Id+"' AND status is null UNION ALL SELECT 'P',to_char(nil_by_mouth_frm,'dd/mm/yyyy - hh24:mi'),to_char(nil_by_mouth_to,'dd/mm/yyyy - hh24:mi') FROM ds_epsd_diet_profile_hdr WHERE encounter_id = '"+encounter_Id+"' AND TRUNC (SYSDATE) BETWEEN (TRUNC (nil_by_mouth_frm)) AND (TRUNC (nil_by_mouth_to)) AND TRUNC(SYSDATE) BETWEEN PERIOD_FROM AND PERIOD_TO AND operating_facility_id = '"+facility_Id+"' AND status is null ";
				
				pstmt9=conn.prepareStatement(sql_NBM_diet,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				rst9 =pstmt9.executeQuery();
				NBM_DIET="";
				if(rst9!=null && rst9.next())
				{
					if(rst9.getString(1).equals("F")){
						NBM_DIET="<img src=../../eDS/css/NBM_Without_Diet.PNG title='"+rst9.getString(2)+"\n"+rst9.getString(3)+"'></img>";
					}else{						
						NBM_DIET="<img src=../../eDS/css/NBM_With_Diet.PNG title='"+rst9.getString(2)+"\n"+rst9.getString(3)+"'></img>";
				}
				}				 
				//410 color code changes ends				
		//ML-MMOH-CRF-0600-US2 Starts Here		
	    String meal="";		
		//String sql_Action_Pending = "SELECT 1 FROM (SELECT distinct a.encounter_id, a.serving_date, b.status curr_stat, a.meal_type, CASE WHEN b.status = 'MP'  THEN 1 WHEN b.status = 'MR'  THEN 2 WHEN b.status = 'MS'  THEN 3 WHEN b.status = 'MJ'  AND  1 = (SELECT 1 from ds_param_for_facility WHERE ip_mealreject_yn = 'Y') THEN 4 ELSE 0 END status FROM ds_epsd_meal_plan_dtl a, ds_epsd_meal_plan_hdr_audit b, ds_epsd_diet_profile_hdr c  WHERE a.operating_facility_id =  '"+facility_Id+"' AND a.encounter_id = '"+encounter_Id+"' AND a.operating_facility_id = b.operating_facility_id(+) AND a.encounter_id = b.encounter_id(+) AND a.serving_date = b.serving_date(+) AND a.meal_type = b.meal_type(+) AND a.spl_food_item_yn = 'N' AND a.OPERATING_FACILITY_ID = c.OPERATING_FACILITY_ID AND a.ENCOUNTER_ID = c.ENCOUNTER_ID AND c.PROFILE_SL = (SELECT MAX(PROFILE_SL) from ds_epsd_diet_profile_hdr where operating_facility_id = a.operating_facility_id and encounter_id = a.encounter_id) AND a.serving_date between c.PERIOD_FROM and c.PERIOD_TO UNION SELECT distinct a.encounter_id, a.serving_date, b.status curr_stat, a.meal_type, CASE WHEN b.status = 'MP'  THEN 1 WHEN b.status = 'MR'  THEN 2 WHEN b.status = 'MS'  THEN 3 WHEN b.status = 'MJ'  AND  1 = (SELECT 1 from ds_param_for_facility WHERE ip_mealreject_yn = 'Y') THEN 4 ELSE 0 END status FROM ds_epsd_meal_plan_dtl a,ds_epsd_meal_plan_spl_audit b, ds_epsd_diet_profile_hdr c WHERE a.operating_facility_id =  '"+facility_Id+"' AND a.encounter_id = '"+encounter_Id+"' AND a.operating_facility_id    = b.operating_facility_id(+) AND a.encounter_id = b.encounter_id(+) AND a.serving_date = b.serving_date(+) AND a.spl_food_item_yn = 'Y' AND a.OPERATING_FACILITY_ID = c.OPERATING_FACILITY_ID AND a.ENCOUNTER_ID = c.ENCOUNTER_ID AND c.PROFILE_SL = (SELECT MAX(PROFILE_SL) from ds_epsd_diet_profile_hdr where operating_facility_id = a.operating_facility_id and encounter_id = a.encounter_id) AND a.serving_date between c.PERIOD_FROM and c.PERIOD_TO) WHERE status <(SELECT CASE WHEN ip_mealprepared_yn = 'Y'  THEN 1 WHEN ip_mealreceived_yn = 'Y'  THEN 2 WHEN ip_mealserved_yn   = 'Y'  THEN 3 WHEN ip_mealreject_yn   = 'Y'  THEN 4 ELSE 0 END status FROM ds_param_for_facility)";//Special Food Item Concept Included
		String sql_Action_Pending = "SELECT 1 FROM (SELECT distinct a.encounter_id, a.serving_date, b.status curr_stat, a.meal_type, CASE WHEN b.status = 'MP'  THEN 1 WHEN b.status = 'MR'  THEN 2 WHEN b.status = 'MS'  THEN 3 WHEN b.status = 'MJ'  AND  1 = (SELECT 1 from ds_param_for_facility WHERE ip_mealreject_yn = 'Y' AND operating_facility_id = '"+facility_Id+"') THEN 4 ELSE 0 END status FROM ds_epsd_meal_plan_dtl a, ds_epsd_meal_plan_hdr_audit b, ds_epsd_diet_profile_hdr c  WHERE a.operating_facility_id =  '"+facility_Id+"' AND a.encounter_id = '"+encounter_Id+"' AND a.operating_facility_id = b.operating_facility_id(+) AND a.encounter_id = b.encounter_id(+) AND a.serving_date = b.serving_date(+) AND a.meal_type = b.meal_type(+) AND a.spl_food_item_yn = 'N' AND a.OPERATING_FACILITY_ID = c.OPERATING_FACILITY_ID AND a.ENCOUNTER_ID = c.ENCOUNTER_ID AND c.PROFILE_SL = (SELECT MAX(PROFILE_SL) from ds_epsd_diet_profile_hdr where operating_facility_id = a.operating_facility_id and encounter_id = a.encounter_id) AND a.serving_date between c.PERIOD_FROM and c.PERIOD_TO UNION SELECT distinct a.encounter_id, a.serving_date, b.status curr_stat, a.meal_type, CASE WHEN b.status = 'MP'  THEN 1 WHEN b.status = 'MR'  THEN 2 WHEN b.status = 'MS'  THEN 3 WHEN b.status = 'MJ'  AND  1 = (SELECT 1 from ds_param_for_facility WHERE ip_mealreject_yn = 'Y' AND operating_facility_id = '"+facility_Id+"') THEN 4 ELSE 0 END status FROM ds_epsd_meal_plan_dtl a,ds_epsd_meal_plan_spl_audit b, ds_epsd_diet_profile_hdr c WHERE a.operating_facility_id =  '"+facility_Id+"' AND a.encounter_id = '"+encounter_Id+"' AND a.operating_facility_id    = b.operating_facility_id(+) AND a.encounter_id = b.encounter_id(+) AND a.serving_date = b.serving_date(+) AND a.spl_food_item_yn = 'Y' AND a.OPERATING_FACILITY_ID = c.OPERATING_FACILITY_ID AND a.ENCOUNTER_ID = c.ENCOUNTER_ID AND c.PROFILE_SL = (SELECT MAX(PROFILE_SL) from ds_epsd_diet_profile_hdr where operating_facility_id = a.operating_facility_id and encounter_id = a.encounter_id) AND a.serving_date between c.PERIOD_FROM and c.PERIOD_TO) WHERE status <(SELECT MAX (ip_param_val) FROM (SELECT CASE WHEN ip_mealprepared_yn = 'Y' THEN 1 ELSE 0 END ip_param_val FROM ds_param_for_facility WHERE operating_facility_id = '"+facility_Id+"' UNION ALL SELECT CASE WHEN ip_mealreceived_yn = 'Y' THEN 2 ELSE 0 END ip_param_val FROM ds_param_for_facility WHERE operating_facility_id = '"+facility_Id+"' UNION ALL SELECT CASE WHEN ip_mealserved_yn = 'Y' THEN 3 ELSE 0 END ip_param_val FROM ds_param_for_facility WHERE operating_facility_id = '"+facility_Id+"'))";//Special Food Item & IP Status Validation included & 67340 , 67340
		pstmt10 = conn.prepareStatement(sql_Action_Pending,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rst10	= pstmt10.executeQuery(); 
		if(rst10 != null && rst10.next())
		 {
		 	meal = rst10.getString(1);		   	
		 }	
		//ML-MMOH-CRF-0600-US2 Ends Here
		
		//Added Against ML-MMOH-CRF-1005-US2 Starts Here
		String APPL_FOR_ATT="";
			String sql_APPL_ATT="select 1 from DS_EPSD_DIET_PROFILE_ATT where encounter_id = ? and  (trunc(sysdate) between period_from AND nvl(period_to,to_date('31/12/2999','DD/MM/YYYY'))OR PERIOD_FROM  > TRUNC (SYSDATE))";//59325
								
				pstmt11=conn.prepareStatement(sql_APPL_ATT,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				pstmt11.setString(1,encounter_Id);
				 rst11 =pstmt11.executeQuery();
				 if(rst11!=null && rst11.next())
				 {
				 APPL_FOR_ATT=checkForNull(rst11.getString(1));//006		 
				 }
		//Added Against ML-MMOH-CRF-1005-US2 Ends Here
		%>
		<script>
				document.getElementById("locationCode").value='<%=location%>';
				document.getElementById("locationType").value='<%=locationType%>';
				var ageGroup = "<%=dateOfBirth%>";
				
				if(parseInt(ageGroup.length)<11){ageGroup=ageGroup+" 00:00";}
				
				var ageGroupArray = new Array();
				ageGroupArray	=  ageGroup.split(" ");
				ageGroupArray1	=	ageGroupArray[0].split("/");
				var today=new Date();
				var dob=new Date(ageGroupArray1[2], ageGroupArray1[1], ageGroupArray1[0]);
				var one_day=1000*60*60*24;

				//Calculate difference btw the two dates, and convert to days

				var days1=Math.floor((dob.getTime()-today.getTime())/(one_day))+1;

				var year=365;
				var month=30;
				var years = parseInt(days1)/parseInt(year)
				days2=parseInt(days1)%parseInt(year)
				var months=Math.floor(parseInt(days2)/parseInt(month));
				var days=Math.floor(parseInt(days2)%parseInt(month));
				
				var maxAge = '';
				var ageUnit = '';

				if( parseInt(Math.abs(years)) > 0){
					maxAge=  parseInt(Math.abs(years));
					ageUnit = 'Y';
				}else if(parseInt(Math.abs(months)) > 0){
					maxAge =  parseInt(Math.abs(months));
					ageUnit = 'M';
				}else if( parseInt(Math.abs(days)) > 0){
					maxAge =  parseInt(Math.abs(days));
					ageUnit = 'D';
				}
				document.getElementById("maxAge").value=maxAge;
				document.getElementById("ageUnit").value=ageUnit; 
			</script>
				<tr>
					<td class='<%=classValue%>' width='12%' nowrap><%=adm_Date%></td>
					<td class='<%=classValue%>' width='12%' nowrap><%=encounter_Id%></td>
				
				<!--MMS-CRF-006-->
				<!-- Modified against ML-MMOH-CRF-0600-US2 and ML-MMOH-CRF-1005-US2 starts-->
					<%
					    if(AllowOrderIP.equals("Y")){
					%>
					<%
						if((DIET_TYPE_MODIFIED.equals("Y")) && (meal.equals("1")) && (APPL_FOR_ATT.equals("1"))) {
					%>
						   <td width='12%' nowrap style="font-size:7pt;font-weight:normal;color:;background-color:" ><%=classStatus%><%=classDieticianReferralNew%><%=NBM_DIET%>
						   <img src="../../eDS/css/Action_Pending.PNG" onClick="Tip(PendingMealAckToolTip('<%=facility_Id%>','<%=encounter_Id%>'),FONTFACE, 'TimesNewRoman', FONTSIZE, '9pt',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)"  onmouseout='UnTip();'></img><img src="../../eOT/images/drugInfo.gif"></img><img src="../../eDS/css/Mother_Accompany_Child.png"></img><!--Changes against on Mouseout issue-->
						  
					<%
						}else if((DIET_TYPE_MODIFIED.equals("Y")) && (meal.equals("1"))){
					%>
					       <td width='12%' nowrap><%=classStatus%><%=classDieticianReferralNew%><%=NBM_DIET%> 
						   <img src="../../eOT/images/drugInfo.gif"></img><img src="../../eDS/css/Action_Pending.PNG"  onClick="Tip(PendingMealAckToolTip('<%=facility_Id%>','<%=encounter_Id%>'),FONTFACE, 'TimesNewRoman', FONTSIZE, '9pt',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)" onmouseout='UnTip();'></img><!--Changes against on Mouseout issue-->
					
					<%
						}else if((DIET_TYPE_MODIFIED.equals("Y"))  && (APPL_FOR_ATT.equals("1"))){
					%>
					       <td width='12%' nowrap><%=classStatus%><%=classDieticianReferralNew%><%=NBM_DIET%>
						   <img src="../../eOT/images/drugInfo.gif"></img><img src="../../eDS/css/Mother_Accompany_Child.png"></img>
					<%
						}else if((meal.equals("1")) && (APPL_FOR_ATT.equals("1"))){
					%>
					       <td width='12%' nowrap><%=classStatus%><%=classDieticianReferralNew%><%=NBM_DIET%>
						   <img src="../../eDS/css/Action_Pending.PNG"  onClick="Tip(PendingMealAckToolTip('<%=facility_Id%>','<%=encounter_Id%>'),FONTFACE, 'TimesNewRoman', FONTSIZE, '9pt',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)" onmouseout='UnTip();'></img><img src="../../eDS/css/Mother_Accompany_Child.png"></img><!--Changes against on Mouseout issue-->
					<%
						}else if((meal.equals("1"))){
					%>
					       <td width='12%' nowrap><%=classStatus%><%=classDieticianReferralNew%><%=NBM_DIET%>
						   <img src="../../eDS/css/Action_Pending.PNG"  onClick="Tip(PendingMealAckToolTip('<%=facility_Id%>','<%=encounter_Id%>'),FONTFACE, 'TimesNewRoman', FONTSIZE, '9pt',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)" onmouseout='UnTip();'></img><!--Changes against on Mouseout issue-->
					
					<%
						}else if((DIET_TYPE_MODIFIED.equals("Y"))){
					%>
					       <td width='12%' nowrap><%=classStatus%><%=classDieticianReferralNew%><%=NBM_DIET%><img src="../../eOT/images/drugInfo.gif"></img>

					<%}
						else if((APPL_FOR_ATT.equals("1"))){
					%>
					    <td width='12%' nowrap><%=classStatus%><%=classDieticianReferralNew%><%=NBM_DIET%><img src="../../eDS/css/Mother_Accompany_Child.png"></img>
					<%}else{
						%>
					    <td width='12%' nowrap><%=classStatus%><%=classDieticianReferralNew%><%=NBM_DIET%>
					<% }
					   }else if((DIET_TYPE_MODIFIED.equals("Y")) && (APPL_FOR_ATT.equals("1"))){
					%>
					       <td width='12%' nowrap><%=classStatus%><%=classDieticianReferralNew%><%=NBM_DIET%><img src="../../eOT/images/drugInfo.gif"></img><img src="../../eDS/css/Mother_Accompany_Child.png"></img>
					<%
						}else if((DIET_TYPE_MODIFIED.equals("Y"))){
					%>
					    <td width='12%' nowrap><%=classStatus%><%=classDieticianReferralNew%><%=NBM_DIET%><img src="../../eOT/images/drugInfo.gif"></img>

					<%}
						else if((APPL_FOR_ATT.equals("1"))){
					%>
					    <td width='12%' nowrap><%=classStatus%><%=classDieticianReferralNew%><%=NBM_DIET%><img src="../../eDS/css/Mother_Accompany_Child.png"></img>
					<%}else{
						%>
					    <td width='12%' nowrap><%=classStatus%><%=classDieticianReferralNew%><%=NBM_DIET%>
					<%}%>
					<!-- Modified against ML-MMOH-CRF-0600-US2 and ML-MMOH-CRF-1005-US2 ends-->
					<!--MMS-CRF-006-->
					
					<td class='<%=classValue%>' width='12%' nowrap>
					<!-- Added Against ML-MMOH-CRF-0672 Starts Here-->
					<% 
					long diffDays=0;
					if(isLos_gt7){ 					
						DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
						Date current_date = null;
						Date adm_date2 = null;					
						current_date=dateFormat1.parse(dateFormat1.format(new Date()));
						adm_date2=dateFormat1.parse(adm_Date);
						long date_diff = current_date.getTime() - adm_date2.getTime();
						diffDays = date_diff / (24 * 60 * 60 * 1000);
					}
					%>
					
				  <!--Modified Against ML-MMOH-CRF-0600-US2 starts -->
				    <%
						if(AllowOrderIP.equals("Y")){
					%>
					<%
						if(meal.equals("1")){	
					%>
						<a href disabled = "javascript:showContent('<%=encounter_Id%>','<%=patient_Id%>','<%=location%>','<%=patientClass%>','<%=room%>','<%=bed%>','<%=locationType%>','<%=dateOfBirth%>','<%=gender%>','<%=flag1%>','<%=isLos_gt7%>','<%=diffDays%>','<%=alaCarte%>')"><%=patient_Id%> </a> <!-- Modified Against ML-MMOH-CRF-1123-US3 -->	
					<%					
					    }else{
					%>
						<a href = "javascript:showContent('<%=encounter_Id%>','<%=patient_Id%>','<%=location%>','<%=patientClass%>','<%=room%>','<%=bed%>','<%=locationType%>','<%=dateOfBirth%>','<%=gender%>','<%=flag1%>','<%=isLos_gt7%>','<%=diffDays%>','<%=alaCarte%>')"><%=patient_Id%> </a> <!--Modified Against ML-MMOH-CRF-1123-US3 -->	
					<%
						}
						}else{
					%>
						<a href = "javascript:showContent('<%=encounter_Id%>','<%=patient_Id%>','<%=location%>','<%=patientClass%>','<%=room%>','<%=bed%>','<%=locationType%>','<%=dateOfBirth%>','<%=gender%>','<%=flag1%>','<%=isLos_gt7%>','<%=diffDays%>','<%=alaCarte%>')"><%=patient_Id%> </a> <!--Modified Against ML-MMOH-CRF-1123-US3 -->		
					<%
						}
					%>
               			  <!--Modified Against ML-MMOH-CRF-0600-US2 ends-->
						  			
					<!-- Added Against ML-MMOH-CRF-0672 Ends Here-->
					</td>
					<td class='<%=classValue%>' width='12%' nowrap><%=patient_Name%><%=isMealPlanModified%></td>
					<td class='<%=classValue%>' width='12%' nowrap><%=patientAge%></td><!-- Added Against  PMG2017-CRF-0012[IN:066074]-->
					<!--td class= width='12%' nowrap></td>--location -->
					<td class='<%=classValue%>' nowrap><%=bed%></td>
					<td class='<%=classValue%>' nowrap><%=room%></td>
					<td style="display:none;">
						<input type="hidden" name="dischargePatientYN" id="dischargePatientYN" value="<%=flag1%>">
					</td>
					<!--ML-MMOH-CRF-0600-US2  and  ML-MMOH-CRF-0672 Ends Here-->
					<!--Modified Against ML-MMOH-CRF-0600-US2 starts -->
					<%
						if(AllowOrderIP.equals("Y")){
					%>
					<%
						if(meal.equals("1")){	
					%>
					<td class='<%=classValue%>' >
						<input type="checkbox" name="chk<%=encounter_Id%>" id="chk<%=encounter_Id%>" id='chk<%=encounter_Id%>' <%if(flag1.equals("Y")) {%>disabled<%}%> onclick="bulkOrder('<%=encounter_Id%>','<%=patient_Id%>','<%=patientClass%>','<%=dateOfBirth%>','<%=gender%>','<%=profileSL%>','<%=fromdate%>',this,'<%=maxAge%>','<%=ageUnit%>','<%=sp_flag%>','<%=dislike_flag%>','<%=diffDays%>')"/disabled></td>
					<%					
						}
						else{
					%>
					<td class='<%=classValue%>'>
						<input type="checkbox" name="chk<%=encounter_Id%>" id="chk<%=encounter_Id%>" id='chk<%=encounter_Id%>' <%if(flag1.equals("Y")) {%>disabled<%}%> onclick="bulkOrder('<%=encounter_Id%>','<%=patient_Id%>','<%=patientClass%>','<%=dateOfBirth%>','<%=gender%>','<%=profileSL%>','<%=fromdate%>',this,'<%=maxAge%>','<%=ageUnit%>','<%=sp_flag%>','<%=dislike_flag%>','<%=diffDays%>')"/></td>
					<%  
						}
						}else{
					%>
					<td class='<%=classValue%>'>
						<input type="checkbox" name="chk<%=encounter_Id%>" id="chk<%=encounter_Id%>" id='chk<%=encounter_Id%>' <%if(flag1.equals("Y")) {%>disabled<%}%> onclick="bulkOrder('<%=encounter_Id%>','<%=patient_Id%>','<%=patientClass%>','<%=dateOfBirth%>','<%=gender%>','<%=profileSL%>','<%=fromdate%>',this,'<%=maxAge%>','<%=ageUnit%>','<%=sp_flag%>','<%=dislike_flag%>','<%=diffDays%>')"/></td>
					<%}%>
					<!--Modified Against ML-MMOH-CRF-0600-US2 ends -->
				
				<script>
						var obj=new Object();
						var flag1="<%=flag1%>";						
						obj.encounterId="<%=encounter_Id%>";
						obj.patientId="<%=patient_Id%>";
						obj.patientClass="<%=patientClass%>";
						obj.dob="<%=dateOfBirth%>";
						obj.gender="<%=gender%>";
						obj.profileSL="<%=profileSL%>";
						obj.fromDate="<%=fromdate%>";						
						obj.age="<%=maxAge%>";
						obj.ageUnit="<%=ageUnit%>";
						obj.spFlag="<%=sp_flag%>";
						obj.dislikeFlag="<%=dislike_flag%>";
						obj.newFlag="";
						obj.diffDays=<%=diffDays%>;//Added Against ML-MMOH-CRF-0672 
						
						if(flag1!='Y') {
 							checkAllPatientArr.push({patient:obj});
						}
 						
				</script>
				</tr>
			<%
				i++;
				}
		     	}
		     	catch(Exception e){
		     		e.printStackTrace();
		     	}
		     	finally{
					if(pstmt!=null)	pstmt.close();
					if(rst!=null)	rst.close();
					if(pstmt1!=null)	pstmt1.close();
					if(rst1!=null)	rst1.close();
					
					if(pstmt_KitchenCode != null)  pstmt_KitchenCode.close();
					if(rst_KitchenCode != null) rst_KitchenCode.close();
					
					if(conn != null){
						ConnectionManager.returnConnection(conn,request);
					}
				}
		 %>
</table>
	<input type="hidden" name="patientIds_BulkOrder" id="patientIds_BulkOrder" value="">
	<input type="hidden" name="encounterIds_BulkOrder" id="encounterIds_BulkOrder" value="">
	<input type="hidden" name="patientClass_bulk" id="patientClass_bulk" value="">
	
	<!-- Added for CRF-0113 -->
	<input type="hidden" name="reOrder" id="reOrder"  value="<%=reOrder%>">
	<input type="hidden" name="orderBy" id="orderBy"  value="<%=orderBy%>">
	<input type="hidden" name="anchorID" id="anchorID"  value="<%=anchorID%>">
	<!-- Added for CRF-0113 -->
      
<% if(flag) {%>
	 <table border='1' width='100%'>
	<tr align="right">
		<td>
			<input type="button" name="Button_BulkOrder" id="Button_BulkOrder" value="<fmt:message key='eDS.groupOrder.Label' bundle='${ds_labels}' />" class="button" onClick="PlaceDietOrder_Group()" disabled="true"/>
		</td>
	</tr>
	</table>
	<script>
	if(jsonPatientArr.length >=2) {
		document.getElementById("Button_BulkOrder").disabled=false;
	}
	var count=0;
	for(var i=0;i<jsonPatientArr.length;i++) {
		var testObj=new Object();
		testObj=jsonPatientArr[i];
		var id=testObj.patient.encounterId;
		if(document.getElementById("chk"+id)) {
			document.getElementById("chk"+id).checked=true;
			count++;
		}
	}
	if(checkAllPatientArr.length==count) {
		document.getElementById("chkAll").checked=true;
	}
	
	</script>	
<%} %>

</form>
<!-- Added for CRF-0113-->
 <script >
       <%-- var str = document.getElementById('PatCriteriaTbl').<%=anchorID%>; --%>
       var str = document.querySelectorAll('#PatCriteriaTbl');
        console.log(str);
		var con = str.toString();
		var ch1 = con.split(",");
		var res = ch1[0].substring(24,26);
	
	  if('<%=reOrder%>'=='1')
	  {   
       var ch = "";
       <%-- ch = document.getElementById('PatCriteriaTbl').<%=anchorID%>.style.color= 'pink'; --%>
       ch = document.getElementById('PatCriteriaTbl').style.color= 'pink';
		if(res == "EN")
		{		   
			ch.innerHTML =document.getElementById('PatCriteriaTbl').encId.innerHTML= " "+"<img src=../../eDS/css/Maxtomin.PNG></img>";			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').admId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patNamId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').genId.innerHTML= " ";
			//ch.innerHTML =document.getElementById('PatCriteriaTbl').locId.innerHTML= " "; //Commented Against PMG2017-COMN-CRF-0012[IN066074]
			ch.innerHTML =document.getElementById('PatCriteriaTbl').bedId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').roomId.innerHTML= " ";
		}
		else if(res == "AD")
		{	
			ch.innerHTML =document.getElementById('PatCriteriaTbl').admId.innerHTML= " "+"<img src=../../eDS/css/Maxtomin.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').encId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patNamId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').genId.innerHTML= " ";
			//ch.innerHTML =document.getElementById('PatCriteriaTbl').locId.innerHTML= " "; //Commented Against PMG2017-COMN-CRF-0012[IN066074]
			ch.innerHTML =document.getElementById('PatCriteriaTbl').bedId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').roomId.innerHTML= " ";
			
		}
		else if (res == "PI"){			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patId.innerHTML= " "+"<img src=../../eDS/css/Maxtomin.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').encId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').admId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patNamId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').genId.innerHTML= " ";
			//ch.innerHTML =document.getElementById('PatCriteriaTbl').locId.innerHTML= " "; //Commented Against PMG2017-COMN-CRF-0012[IN066074]
			ch.innerHTML =document.getElementById('PatCriteriaTbl').bedId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').roomId.innerHTML= " "         
		}
		else if (res == "PN"){			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').encId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').admId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patNamId.innerHTML= " "+"<img src=../../eDS/css/Maxtomin.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').genId.innerHTML= " ";
			//ch.innerHTML =document.getElementById('PatCriteriaTbl').locId.innerHTML= " "; //Commented Against PMG2017-COMN-CRF-0012[IN066074]
			ch.innerHTML =document.getElementById('PatCriteriaTbl').bedId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').roomId.innerHTML= " "         
		}
		else if (res == "GN"){			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').encId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').admId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patNamId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').genId.innerHTML= " "+"<img src=../../eDS/css/Maxtomin.PNG></img>";
			//ch.innerHTML =document.getElementById('PatCriteriaTbl').locId.innerHTML= " "; //Commented Against PMG2017-COMN-CRF-0012[IN066074]
			ch.innerHTML =document.getElementById('PatCriteriaTbl').bedId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').roomId.innerHTML= " "         
		}		
		else if (res == "BD"){			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').bedId.innerHTML= " "+"<img src=../../eDS/css/Maxtomin.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').encId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').admId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patNamId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').genId.innerHTML= " ";
			//ch.innerHTML =document.getElementById('PatCriteriaTbl').locId.innerHTML= " "; //Commented Against PMG2017-COMN-CRF-0012[IN066074]
			ch.innerHTML =document.getElementById('PatCriteriaTbl').roomId.innerHTML= " ";
         
		}else if (res == "RM"){			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').roomId.innerHTML= " "+"<img src=../../eDS/css/Maxtomin.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').encId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').admId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patNamId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').genId.innerHTML= " ";
			//ch.innerHTML =document.getElementById('PatCriteriaTbl').locId.innerHTML= " "; //Commented Against PMG2017-COMN-CRF-0012[IN066074]
			ch.innerHTML =document.getElementById('PatCriteriaTbl').bedId.innerHTML= " ";			         
		}		
	}
	else if('<%=reOrder%>'=='2')
	{		
		ch = document.getElementById('PatCriteriaTbl').style.color='yellow';
		if(res == 'EN')
		{
			ch.innerHTML =document.getElementById('PatCriteriaTbl').encId.innerHTML= " "+"<img src=../../eDS/css/Mintomax.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').admId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patNamId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').genId.innerHTML= " ";
			//ch.innerHTML =document.getElementById('PatCriteriaTbl').locId.innerHTML= " "; //Commented Against PMG2017-COMN-CRF-0012[IN066074]
			ch.innerHTML =document.getElementById('PatCriteriaTbl').bedId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').roomId.innerHTML= " ";
		}
		else if(res == "AD")
		{	
			ch.innerHTML =document.getElementById('PatCriteriaTbl').admId.innerHTML= " "+"<img src=../../eDS/css/Mintomax.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').encId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patNamId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').genId.innerHTML= " ";
			//ch.innerHTML =document.getElementById('PatCriteriaTbl').locId.innerHTML= " "; //Commented Against PMG2017-COMN-CRF-0012[IN066074]
			ch.innerHTML =document.getElementById('PatCriteriaTbl').bedId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').roomId.innerHTML= " ";			
		}
		else if (res == "PI"){			
			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patId.innerHTML= " "+"<img src=../../eDS/css/Mintomax.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').encId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').admId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patNamId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').genId.innerHTML= " ";
			//ch.innerHTML =document.getElementById('PatCriteriaTbl').locId.innerHTML= " "; //Commented Against PMG2017-COMN-CRF-0012[IN066074]
			ch.innerHTML =document.getElementById('PatCriteriaTbl').bedId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').roomId.innerHTML= " "         
		}
		else if (res == "PN"){			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').encId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').admId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patNamId.innerHTML= " "+"<img src=../../eDS/css/Mintomax.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').genId.innerHTML= " ";
			//ch.innerHTML =document.getElementById('PatCriteriaTbl').locId.innerHTML= " "; //Commented Against PMG2017-COMN-CRF-0012[IN066074]
			ch.innerHTML =document.getElementById('PatCriteriaTbl').bedId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').roomId.innerHTML= " "         
		}
		else if (res == "GN"){			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').encId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').admId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patNamId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').genId.innerHTML= " "+"<img src=../../eDS/css/Mintomax.PNG></img>";
			//ch.innerHTML =document.getElementById('PatCriteriaTbl').locId.innerHTML= " "; //Commented Against PMG2017-COMN-CRF-0012[IN066074]
			ch.innerHTML =document.getElementById('PatCriteriaTbl').bedId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').roomId.innerHTML= " "         
		}		
		else if (res == "BD"){
			ch.innerHTML =document.getElementById('PatCriteriaTbl').bedId.innerHTML= " "+"<img src=../../eDS/css/Mintomax.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').encId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').admId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patNamId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').genId.innerHTML= " ";
			//ch.innerHTML =document.getElementById('PatCriteriaTbl').locId.innerHTML= " "; //Commented Against PMG2017-COMN-CRF-0012[IN066074]
			ch.innerHTML =document.getElementById('PatCriteriaTbl').roomId.innerHTML= " "         
		}else if (res == "RM"){			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').roomId.innerHTML= " "+"<img src=../../eDS/css/Mintomax.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').encId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').admId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').patNamId.innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').genId.innerHTML= " ";
			//ch.innerHTML =document.getElementById('PatCriteriaTbl').locId.innerHTML= " "; //Commented Against PMG2017-COMN-CRF-0012[IN066074]
			ch.innerHTML =document.getElementById('PatCriteriaTbl').bedId.innerHTML= " ";         
		}		
	}	
</script>
</body>

