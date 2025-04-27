<!DOCTYPE html>
<!--DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"-->
<!-- DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> -->
<%@ page import="webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,java.sql.Connection,eCommon.Common.CommonBean ,eCommon.Common.*,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,java.util.ArrayList,java.util.HashMap,java.util.*,eDS.DSCommonBean,eDS.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends  %>
<html> 
<head>
<!-- CRF-427 -->
	<meta http-equiv="content-type" content="text/html; charset=utf-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="X-UA-Compatible" content="IE=5,8,9" >
	<meta charset="utf-8">
<!-- CRF-427 -->
<!-- Added Against Start CRF-673 -->
<jsp:useBean id="DSCommonBeanObj" class="eDS.DSCommonBean"/> 
<!-- Added Against End CRF-673 -->
<%
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
	if(sStyle==null)
		sStyle="IeStyle.css";

	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");

	String strloggeduser	=  (String) httpSession.getValue("login_user");
	String strclientip ="";
	strclientip=p.getProperty("client_ip_address");

	String facility_id	= (String)session.getAttribute("facility_id");
	String language_Id  = (String)session.getAttribute("LOCALE");
	String ward_Code = request.getParameter("locationCode");
	String location_type = request.getParameter("locationType");
	String encounterId=	request.getParameter("encounterId");
	String patientId=	request.getParameter("Patient_ID");
	String patientClass=	request.getParameter("patientClass");//ML-MMOH-CRF-0820	
	String remarks_1 = "";//MMS-KH-CRF-029.1	
	String flag=	request.getParameter("flag");
	String restrict_date_inpatients_yn="Y",maximum_days_allowed="";//ML-MMOH-CRF-0427
	
	//Added Against ML-MMOH-CRF-0672 Starts Here
	String diffDays	= checkForNull(request.getParameter("diffDays"));
	String isLos_gt7  = checkForNull(request.getParameter("isLos_gt7"));
	//Added Against ML-MMOH-CRF-0672 Ends Here
	
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt3 = null;
	PreparedStatement pstmt4 = null;
	PreparedStatement pstmt5 = null;//ML-MMOH-CRF-0427
	PreparedStatement pstmt6 = null;//ML-MMOH-CRF-0746
	PreparedStatement pstmt7 = null;//MMS-KH-CRF-029.1

	ResultSet rs = null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	ResultSet rs3 = null;
	ResultSet rs4 = null;
	ResultSet rs5 = null;//ML-MMOH-CRF-0427
	ResultSet rs6 = null;//ML-MMOH-CRF-0746
	ResultSet rs7 = null;//MMS-KH-CRF-029.1
	
	Connection conn = null;
	conn = ConnectionManager.getConnection(request);
	//Added Against Start ML-MMOH-CRF-0684
	boolean isMenuType =false;
	isMenuType = CommonBean.isSiteSpecific(conn,"DS","DS_MENU_TYPE");
	//Added Against End ML-MMOH-CRF-0684
	//Added Against Start KDAH-CRF-0352
	boolean isEditMealType =false;
	isEditMealType = CommonBean.isSiteSpecific(conn,"DS","DS_MEAL_MENU_ITEMS");
	//Added Against End KDAH-CRF-0352

	//Added Against Start KDAH-CRF-0349-US005
	boolean isDtCat_MlCls =false;
	isDtCat_MlCls = CommonBean.isSiteSpecific(conn,"DS","DS_MEAL_MENU_ITEMS");
	String CheckFlag = "";
	if(isDtCat_MlCls == true)
		CheckFlag = "Y";
	else
		CheckFlag = "N";
	//Added Against End KDAH-CRF-0349-US005

	//Added Against ML-MMOH-CRF-1123-US3 Starts Here
	boolean isAlaCarte=false;
	isAlaCarte=CommonBean.isSiteSpecific(conn,"DS","PLACE_ORDER_FOR_ATTENDANT");
	String CheckFlag1 = "";
	if(isAlaCarte == true)
		CheckFlag1 = "Y";
	else
		CheckFlag1 = "N";

	String alaCarte = checkForNull(request.getParameter("alaCarte"));
	//Added Against ML-MMOH-CRF-1123-US3 Ends Here
	
	//Added Against ML-MMOH-SCF-1676 Starts
	boolean isEnteral = false;
	isEnteral = CommonBean.isSiteSpecific(conn,"DS","DS_DIET_ENTERAL");
	
	//Added by Santhosh for ML-MMOH-SCF-2331 
	boolean isSpecialDiet = false;
	isSpecialDiet = CommonBean.isSiteSpecific(conn,"DS","SPECIAL_DIET_CATEGORY");
	
	//Added Against ML-MMOH-SCF-1676 Ends
	
	//Added Against ML-MMOH-CRF-1460 Starts
	boolean isMACNBM = false;
	isMACNBM = CommonBean.isSiteSpecific(conn,"DS","DS_MAC_NBM");
	//Added Against ML-MMOH-SCF-1460 Ends
	
	//Added Against ML-MMOH-CRF-1780...starts
	boolean isDateLabel = false;
	isDateLabel = CommonBean.isSiteSpecific(conn,"DS","DS_DATE_LABEL");
	System.err.println("isDateLabel --->"+isDateLabel);
	//Added Against ML-MMOH-CRF-1780...ends
	
	System.out.println("isMACNBM in PlaceDietOrderCUD.jsp : "+isMACNBM);
	String kitchen_Code =  "";
	String prfSL = "";
	String acceptDietForIndMealYn = "";
	String graceAplYN = "";
	boolean profileFlag=true;//ML-MMOH-CRF-0427
	String GEN_MEALPLAN_FOR_NBM_PAT_YN="";//MMS-QH-CRF-0078.1-US003
	String IRREGULAR_DIET_ORD_YN="",IRREGULAR_MEAL_ORD_MESSAGE="";//ML-MMOH-CRF-409
	String Attendent_Label_Name="";//ML-MMOH-CRF-0406
	String No_Of_Attendant="";//ML-MMOH-CRF-0412
	int periodHr = 0;
	String servingDate="";		
	//ML-MMOH-CRF-0406 STARTS
	String AttendantInstr=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.PCTAttendantInstr.Label","ds_labels");		
	//ML-MMOH-CRF-0406 ENDS
	//ML-MMOH-CRF-0746
	String attendantAge="";
	String yearValue ="0",monthValue="0",dayValue="0";
	String attendInstru ="";//SCF-735
	int yearIntValue =0;
	int monthIntValue =0;
	int dayIntValue =0;	
	int mc_defaultcount=0;//Added Against ML-MMOH-CRF-1005-US2
	boolean isAttendantAge = false;
	isAttendantAge = CommonBean.isSiteSpecific(conn,"DS","PLACE_ORDER_FOR_ATTENDANT");//Using same function for Selayang
	//ML-MMOH-CRF-0746
	//Added Against Start CRF-673 
	String bed  = checkForNull(request.getParameter("bed"));
	String bedClassCode ="";
	String meal_class_code="";
	String meal_class_desc="";
	String enableDrugFoodYN="";//MMS-KH-CRF-0029.1-US008
	//ArrayList<String> list =new  ArrayList<String>(); 
	// Added Against End CRF-673	
	try{
		// Added Against Start 673-CRF 
		bedClassCode = DSCommonBeanObj.getIPBedClass(ward_Code,bed,facility_id); //Added Against CRF-673
		if(bedClassCode!=null && bedClassCode.length()>0){		
			String sql_meal="SELECT MEAL_CLASS,SHORT_DESC FROM DS_MEAL_CLASS WHERE BED_CLASS_CODE like '%"+bedClassCode+"%' ";
			pstmt1 = conn.prepareStatement(sql_meal);
			rs1	= pstmt1.executeQuery();
			if (rs1!= null && rs1.next()){
			  meal_class_code = rs1.getString("MEAL_CLASS");				
			  meal_class_desc = rs1.getString("SHORT_DESC");				
			}
		}

		// Added Against End 673-CRF 
	String sql_ward_Code = "select ward_Code, kitchen_Code from Ds_Wards_For_Kitchen where operating_Facility_Id ='"+facility_id+"' and ward_Code ='"+ward_Code+"'";
	String profileSL_query = "";
	//Added Against ML-MMOH-CRF-1460 Starts
	 if(isMACNBM)
	{
		 profileSL_query = "SELECT NVL(MAX (profile_sl),0) max_profile_sl FROM (SELECT NVL (MAX (a.profile_sl), 0) profile_sl FROM ds_epsd_diet_profile_hdr a WHERE a.encounter_id = '"+encounterId+"' AND a.operating_facility_id = '"+facility_id+"' UNION SELECT NVL (MAX (b.profile_sl), 0) profile_sl FROM ds_epsd_nbm_profile b WHERE b.encounter_id = '"+encounterId+"' AND b.operating_facility_id = '"+facility_id+"' UNION SELECT NVL (MAX (a.profile_sl), 0) profile_sl FROM ds_epsd_diet_profile_att a WHERE a.encounter_id = '"+encounterId+"' AND a.operating_facility_id = '"+facility_id+"')";
	}
	//Added Against ML-MMOH-CRF-1460 Ends
	else{ 
	 profileSL_query = "SELECT NVL(MAX (profile_sl),0) max_profile_sl FROM (SELECT NVL (MAX (a.profile_sl), 0) profile_sl FROM ds_epsd_diet_profile_hdr a WHERE a.encounter_id = '"+encounterId+"' AND a.operating_facility_id = '"+facility_id+"' UNION SELECT NVL (MAX (b.profile_sl), 0) profile_sl FROM ds_epsd_nbm_profile b WHERE b.encounter_id = '"+encounterId+"' AND b.operating_facility_id = '"+facility_id+"')";//CRF-410
	}
	String profileFlag_query="select * from ds_epsd_diet_profile_hdr where encounter_id='"+encounterId+"' AND nvl(status, 'ZZ') <> 'X' and trunc(sysdate) between period_from AND nvl(period_to,to_date('31/12/2999','DD/MM/YYYY')) order by MODIFIED_DATE";//ML-MMOH-CRF-0427

	String acceptMealDiet_query = "select ACCEPT_DIET_FOR_IND_MEAL_YN from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = '"+facility_id+"'";

	String gPQuery = "select GRACE_PERIOD_APPLICABLE_YN,GRACE_PERIOD,restrict_date_inpatients_yn,nvl(maximum_days_allowed,'1') maximum_days_allowed,GEN_MEALPLAN_FOR_NBM_PAT_YN,LATE_IRREGULAR_DIET_ORD_FOR_IP,IRREGULAR_MEAL_ORD_MESSAGE,Attendent_Label_Name,NVL(No_Of_Attendant,'0') No_Of_Attendant, ENABLE_DRUG_FOOD_YN from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = '"+facility_id+"'";//ML-MMOH-CRF-0427 and  MMS-QH-CRF-0078.1-US003 and ML-MMOH-CRF-409 and ML-MMOH-CRF-0406 and ML-MMOH-CRF-0412 & ICN 72081

	//ML-MMOH-CRF-0746
	   if(isAttendantAge){		
		String sql_age="select mp_get_age_ymdh(b.date_of_birth) age from mp_patient b where patient_id = '"+patientId+"'";
		
		pstmt6 = conn.prepareStatement(sql_age);
		rs6	= pstmt6.executeQuery();

		if (rs6!= null && rs6.next()){
			attendantAge = rs6.getString("age");				
		 }
		  
		 int yearindx =0; int monthindx =0; int days=0;
		 
		 if(attendantAge.contains("Y")){
			yearindx=attendantAge.indexOf("Y");
			if(yearindx>0)
			yearValue=attendantAge.substring(0,yearindx);
			yearValue = yearValue.trim();
		  }  
		  
		if(attendantAge.contains("M")){
			monthindx=attendantAge.indexOf("M");
		if(monthindx>0 && yearindx!=0)			monthValue=attendantAge.substring(++yearindx,monthindx);monthValue = monthValue.trim();
		//monthValue=attendantAge.substring(0,monthindx);
		if(yearindx==0)  monthValue=attendantAge.substring(0,monthindx); monthValue =		monthValue.trim();			  
		  }  
		if(attendantAge.contains("D")){
			days=attendantAge.indexOf("D");

		if(days>0 && monthindx>0 &&yearindx==0){
			dayValue=attendantAge.substring(++monthindx,days);dayValue = dayValue.trim();
			}
			if(days>0 && yearindx!=0 && monthindx<=0){dayValue=attendantAge.substring(++yearindx,days);dayValue = dayValue.trim();
			}
			 if(days>0 && yearindx<=0 && monthindx<=0){dayValue=attendantAge.substring(0,days);dayValue = dayValue.trim();
			 }		
		  } 		 
		}

		yearIntValue = Integer.parseInt(yearValue);
		monthIntValue = Integer.parseInt(monthValue);
		dayIntValue = Integer.parseInt(dayValue);

		//ML-MMOH-CRF-0746
		pstmt = conn.prepareStatement(sql_ward_Code);
		pstmt1 = conn.prepareStatement(profileSL_query);
		pstmt2 = conn.prepareStatement(acceptMealDiet_query);
		pstmt3 = conn.prepareStatement(gPQuery);
		pstmt4 = conn.prepareStatement("SELECT to_char(SYSDATE,'dd/mm/yyyy') CURRENT_DATE FROM DUAL");
		pstmt5 = conn.prepareStatement(profileFlag_query);//ML-MMOH-CRF-0427
					
		rs	= pstmt.executeQuery();
		rs1	= pstmt1.executeQuery();
		rs2	= pstmt2.executeQuery();
		rs3	= pstmt3.executeQuery();
		rs4	= pstmt4.executeQuery();
		rs5	= pstmt5.executeQuery();//ML-MMOH-CRF-0427
					
		while(rs != null && rs.next()){
			ward_Code=rs.getString(1);
			kitchen_Code=rs.getString(2);
		}
		while(rs1 != null && rs1.next()){
			prfSL = rs1.getString(1);
			
		}
		if(rs2 != null && rs2.next()){
			acceptDietForIndMealYn = rs2.getString(1);
		}
		if(rs3 != null && rs3.next()){
			graceAplYN = rs3.getString(1);
			periodHr = rs3.getInt(2);
			//ML-MMOH-CRF-0427

			maximum_days_allowed=checkForNull(rs3.getString("maximum_days_allowed"));
			maximum_days_allowed=""+(Integer.parseInt(maximum_days_allowed)-1);
			//ML-MMOH-CRF-0427
			GEN_MEALPLAN_FOR_NBM_PAT_YN=checkForNull(rs3.getString("GEN_MEALPLAN_FOR_NBM_PAT_YN"));
			//ML-MMOH-CRF-409 -STARTS
			IRREGULAR_DIET_ORD_YN=checkForNull(rs3.getString("LATE_IRREGULAR_DIET_ORD_FOR_IP"));
			IRREGULAR_MEAL_ORD_MESSAGE=checkForNull(rs3.getString("IRREGULAR_MEAL_ORD_MESSAGE"));
			//ML-MMOH-CRF-409 -ENDS				
			Attendent_Label_Name=rs3.getString("Attendent_Label_Name");//ML-MMOH-CRF-0406
			enableDrugFoodYN =rs3.getString("ENABLE_DRUG_FOOD_YN");//MMS-KH-CRF-0029.1-US008
			AttendantInstr=AttendantInstr.replace("#",Attendent_Label_Name);
			No_Of_Attendant=rs3.getString("No_Of_Attendant");//ML-MMOH-CRF-0412
		}
		while(rs4.next()){
			servingDate = rs4.getString("CURRENT_DATE");
		}
		//ML-MMOH-CRF-0427
		if(rs5.next()){
			profileFlag=false;
		}
		//SCF-735
		
		while(rs5 != null && rs5.next()){
			attendInstru =checkForNull(rs5.getString("ATNDNT_INSTR"));			
		}
		//SCF-735
		if(restrict_date_inpatients_yn.equals("Y")){
			profileFlag=true;
		}
		else
		{
			profileFlag=false;
		}
		//ML-MMOH-CRF-0427
		//Added against MMS-KH-CRF-0029.1 Starts Here
		String sql_rem="SELECT remarks FROM ds_epsd_diet_profile_hdr WHERE encounter_id = '"+encounterId+"' AND profile_sl = '"+prfSL+"' ";
		pstmt7 = conn.prepareStatement(sql_rem);
		rs7	= pstmt7.executeQuery();
		while(rs7 != null && rs7.next()){
		remarks_1=rs7.getString(1);
		//Added against MMS-KH-CRF-0029.1 Ends Here
	} 
	}
	catch(Exception e){
		System.err.println("PlaceDietOrderCUD.jsp====="+e.getMessage());
		e.printStackTrace();
	}
	finally	{
		if(pstmt != null){
			pstmt.close();
		}
		if(conn != null){
			conn.close();
		}
	}
 %>
	 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	 <link rel='StyleSheet1' href='../../eCommon/html/body.css' type='text/css'/>
	 <style type="text/css">
		@import url(../../eDS/css/skin.css);		
	 </style>

	<!-- <script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script> AAKH-CRF-0065 -->
	<script language="JavaScript" src="../../framework/js/PopupWindow.js" type="text/javascript"></script>
	<script type="text/javascript" src="../../eDS/js/navbar.js"></script>
	<script type="text/javascript" src="../../eDS/js/simpletreemenu.js"></script>
	<script type="text/javascript" src="../../framework/js/hashtable.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../framework/js/PopupWindow.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eDS/js/DSCommon.js"></script>
	<script type="text/javascript" src="../../eDS/js/PlaceDietOrder.js"></script>
	<script language="Javascript" src="../../eDS/js/json.js"></script>
	<script language="javascript" src="../../eDS/js/PlaceDietOrderPHIS.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eDS/css/jquery-ui.css"/>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" type="text/css" href="../../eDS/js/common/semiDisableDate/jquery.datetimepicker.css"/>
	<link rel="stylesheet" type="text/css" href="../../eDS/js/common/semiDisableDate/jquery-ui-timepicker-addon.css"/>
	<link rel="stylesheet" type="text/css" href="../../eDS/js/common/semiDisableDate/timepicker.css"/>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ui-timepicker-addon/1.6.3/jquery-ui-timepicker-addon.min.js"></script>
	
	<!-- ML-MMOH-CRF-409 -->
	<script src="../../eDS/js/Moment.js"></script>
	<script src="../../eDS/js/MomentRange.js"></script>
	<!-- ML-MMOH-CRF-409 -->  

	<script type="text/javascript" src="../../eDS/js/common/semiDisabledDateTime/datepicker-<%=language_Id%>.js"></script>  
	<!--427-->

	<script type="text/javascript">
     _NavBar_pageID = "Home"; /* disable the current page from the menu */
	var profileSL;
	var myString = "<%=attendantAge%>";
	var dateSplit="";
	if(myString.length>0){
		dateSplit= myString.split(" ");
		var str1 = new String(dateSplit);
		var years="";
		var months="";
		var days="";
		var indx1=0;
		var indx2=0;
		var indx3=0;
	if(~str1.indexOf("Y")){
		indx1=str1.indexOf("Y");
	if(indx1>0)years=str1.substring(0,indx1);
	} 
	if(~str1.indexOf("M")){
		indx2=str1.indexOf("M");
	if(indx1>0)  months=str1.substring(++indx1,indx2);
	if(indx1==0) months=str1.substring(0,indx2);
	}
	if(~str1.indexOf("D")){
		indx3=str1.indexOf("D");	   
	if(indx1>0 && indx2>0)   days=str1.substring(++indx2,indx3);
	if(indx1==0 && indx2>0)  days=str1.substring(++indx2,indx3);
	if(indx1>0 && indx2==0)  days=str1.substring(++indx1,indx3);
	if(indx1==0 && indx2==0) days=str1.substring(0,indx3);	   
	}	

	if(years.indexOf(",")==0) years=years.replace(",", "");
	if(months.indexOf(",")==0) months=months.replace(",", "");
	if(days.indexOf(",")==0) days=days.replace(",", "");
	}

	var mealTypesArr = new Array();
	function hide()
	{
		document.getElementById("police_response1").style.display = 'none';
		document.getElementById("contentsForAssignDietType").style.display = 'none';
		document.getElementById("attendentListLayer").style="display";
		document.getElementById("dietlistContentLayer").style.display = 'none';
		document.getElementById("attendent").style="display";
		document.getElementById("pateint").style.display = 'none';
		document.getElementById("addAttendent").style="display";
		document.getElementById("dietOrders").style.display = 'none';
		document.getElementById("dietselect").style.display = 'none';
		document.getElementById("remarks").style.visibility = 'hidden';
		document.getElementById("SideMenuId").style.visibility = 'hidden'; //MMS-QH-CRF-0190
		document.getElementById("SideMenu").style.visibility = 'hidden'; //MMS-QH-CRF-0190
	}

	function show()
	{
		document.getElementById("police_response1").style="display";
		document.getElementById("contentsForAssignDietType").style="display";
		document.getElementById("attendentListLayer").style.display = 'none';
		document.getElementById("dietlistContentLayer").style="display";
		document.getElementById("attendent").style.display = 'none';
		document.getElementById("pateint").style="display";
		document.getElementById("addAttendent").style.display = 'none';
		document.getElementById("dietOrders").style="display";
		document.getElementById("dietselect").style="display";
		document.getElementById("remarks").style.visibility = 'visible';
		document.getElementById("SideMenuId").style.visibility = 'visible'; //MMS-QH-CRF-0190
		document.getElementById("SideMenu").style.visibility = 'visible'; //MMS-QH-CRF-0190
	}

// AAKH-CRF-0065 start 
	$(document).ready(function()
	{
		$(".text").change(function()
		{
			chkFormValChange = true;
		});
		$(".chkFormChange").change(function()
		{
			chkFormValChange = true;
		});
		$("textarea").change(function()
			{
			chkFormValChange = true;
		});
		$("select").change(function()
		{
			var chkStatusChng = $(this).attr("id");
			if(chkStatusChng != 'status')
			{
				chkFormValChange = true;
			}
		});
	});
	/* window.onbeforeunload = function() 
	{
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		var params = "func_mode=chkSessionVal";
		xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		if((chkFormValChange || retVal == 'true') && !closeWindowFlag)
				return getMessage("DS_DISCARD_CHANGES","DS");
		else if(exclusionFlag==true && !closeWindowFlag)
				return "The Changes to Meal Exclusions will not be Saved. Are you sure you wish to continue?";
}; */
window.onbeforeunload = function(event) {
    // Perform any checks or prepare data to be sent
    var retVal = '';
    var url = "../../eDS/jsp/DLCommonValidation.jsp";
    var params = "func_mode=chkSessionVal";
    var data = new URLSearchParams(params).toString();

    // Use sendBeacon to send the data asynchronously
    if (navigator.sendBeacon) {
        var fullUrl = url + "?" + data;
        navigator.sendBeacon(fullUrl);
    }

    // Custom messages for the user
    if ((chkFormValChange || retVal == 'true') && !closeWindowFlag) {
        event.returnValue = getMessage("DS_DISCARD_CHANGES", "DS");
        return getMessage("DS_DISCARD_CHANGES", "DS");
    } else if (exclusionFlag == true && !closeWindowFlag) {
        event.returnValue = "The Changes to Meal Exclusions will not be Saved. Are you sure you wish to continue?";
        return "The Changes to Meal Exclusions will not be Saved. Are you sure you wish to continue?";
    }
};

// AAKH-CRF-0065 end
    </script>
</head>
	<%
		if(isMACNBM) //Added Against ICN:17117 ML-MMOH-CRF-1460
		{
	%>
		<body onload="fecthMealContents();isMACNBMUpdate();getSysDate();getDieticianFlag();losCheck();PlaceOrderRightsEdit();calledDietType();drugAlert();"><!--Added isMACNBMUpdate() Against ML-MMOH-CRF-1460-->
	<%}
	else{
	%>
		<body onload="fecthMealContents();getSysDate();getDieticianFlag();losCheck();PlaceOrderRightsEdit();calledDietType();drugAlert();"><!--Modified Against ML-MMOH-CRF-0672--> <!-- Added against ML-MMOH-CRF-0677 -->	
	<%	
	}
	%>
	<form id="input" name="PlaceDietOrderForm" id="PlaceDietOrderForm" action="../../servlet/eDS.PlaceDietOrderServlet" target="messageFrame" onsubmit="checkNull();">

		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td>
			<table width="100%" border="1" cellspacing="0" cellpadding="0" bordercolor="#9999FF">
			<tr>
				<td width="765" valign="top">
				<br/>
				<left>
				<table width="50%" class="webglobeBoxBorder" summary="asd" cellpadding="0" cellspacing="0">
				<tr>
					<td align="center" valign="top" class="smalltext"><fmt:message key="Common.patient.label" bundle="${common_labels}" /></td>
					<td align="center" valign="top" class="smalltext"><input type="Radio" name="Suballocator" id="Suballocator"  value="Yes" onclick="show();" checked></td>
					<td align="center" valign="top" class="smalltext"><%=Attendent_Label_Name%></td><!--ML-MMOH-CRF-0406-->
					<td align="center" valign="top" class="smalltext">
					<%
						String accept_Diet_For_Ind_Meal_Yn = null;
						String attendant_Order_Applicable_Yn = null;
						try{
							conn = ConnectionManager.getConnection(request);
							String attendentStatus = "select paramFacility.attendant_Order_Applicable_Yn, paramFacility.accept_Diet_For_Ind_Meal_Yn from Ds_Param_For_Facility paramFacility where paramFacility.operating_Facility_Id ='"+facility_id+"'";
							pstmt = conn.prepareStatement(attendentStatus);
							rs	= pstmt.executeQuery();
							while(rs != null && rs.next()) {
								attendant_Order_Applicable_Yn = rs.getString(1);
								accept_Diet_For_Ind_Meal_Yn = rs.getString(2);
							}
						}catch(Exception e){
							e.printStackTrace();
						}
						finally{
							conn.close();
							pstmt.close();
						}
					%>
					<%
					   if(!isAttendantAge){
					%>
					<%
						if(attendant_Order_Applicable_Yn!=null  && !(attendant_Order_Applicable_Yn.equals("")) && attendant_Order_Applicable_Yn.equals("Y"))										{
					%>									     
						<input type="Radio" name="Suballocator"  id="attendantRadio" value="No" onclick="hide();">
					<%
						}
					   else {									      
					%>
						<input type="Radio" name="Suballocator"  id="attendantRadio" value="No" disabled="disabled"></td>									
					<%}%>
					<%}%>
					<%
						 if(isAttendantAge && (attendant_Order_Applicable_Yn!=null  && !(attendant_Order_Applicable_Yn.equals("")) &&      attendant_Order_Applicable_Yn.equals("Y"))) {
					%>										
					<%	if (yearIntValue<18) 
						{
												
					%>
					   <input type="Radio" name="Suballocator"  id="attendantRadio" value="No" onclick="hide();">
					<%} else if( yearIntValue == 18 && monthIntValue == 0 && dayIntValue == 0) {
						%>
						<input type="Radio" name="Suballocator"  id="attendantRadio" value="No" onclick="hide();">
						<%}else if ((yearIntValue>18) || (yearIntValue == 18 && monthIntValue >0) ||(yearIntValue == 18 && dayIntValue > 0)){%>
						<input type="Radio" name="Suballocator"  id="attendantRadio" value="No" disabled="disabled">
						<%}
						}if(isAttendantAge && (attendant_Order_Applicable_Yn!=null  && !(attendant_Order_Applicable_Yn.equals("")) &&      attendant_Order_Applicable_Yn.equals("N"))) {
						%>
						<input type="Radio" name="Suballocator"  id="attendantRadio" value="No" disabled="disabled"></td>	
					<%}%>							
			</tr>
			</table>
		<br/>
		<table width="100%">
		<tr>
			<td align="center" valign="top" colspan="2">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
				<td>
				<table width="100%" border="0" cellspacing="0" cellpadding="2" id="pateint" >
				<tr>
				<th  valign="top" colspan="2" width="50%">
					<fmt:message key="eOT.patientOptionTitle.Label" bundle="${ot_labels}" />
				</th>
				</tr>
	<%if(isMenuType) { %>
		<!--ML-MMOH-CRF-0684 Starts-->
		<tr>
		<td class ="label" align ="right">
		<fmt:message key="eDS.MenuType.Label" bundle="${ds_labels}"/>
		<td>
			<select name="menu_type" id="menu_type" id ="menu_type">
				<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />
				<%
					try{
						conn = ConnectionManager.getConnection(request);
						String MenuTypecode = "";
						String MenuTypedescription =  "";
						String sql_Menu_Count="SELECT count(*) FROM ds_menu_type where eff_status ='E' and appl_for_ip_yn ='Y' AND DEFAULT_YN='Y'";

						pstmt = conn.prepareStatement(sql_Menu_Count);
						rs	= pstmt.executeQuery();
						int defaultcount=0;
						if(rs.next()){
							defaultcount=rs.getInt(1);
						}

						String sql_Menu_Type = "SELECT menu_type,short_desc,DEFAULT_YN FROM ds_menu_type where eff_status ='E' and appl_for_ip_yn ='Y' ORDER BY short_desc asc";

						pstmt = conn.prepareStatement(sql_Menu_Type);
						rs	= pstmt.executeQuery();
						while(rs != null && rs.next()){
							MenuTypecode=rs.getString(1);
							MenuTypedescription=rs.getString(2);
						String temp=rs.getString(3);
						if(defaultcount == 1 && temp.equals("Y"))
						{									
						 %>
							<option value="<%=MenuTypecode%>" selected>
								<%=MenuTypedescription%>
							</option>
						<%
						}
						else
						{								
						%>
						<option value="<%=MenuTypecode%>">
								<%=MenuTypedescription%>
						</option>
						<%
						}
						}
						}
						catch(Exception e){
							e.printStackTrace();
						}
						finally	{
							if(pstmt != null){
								pstmt.close();
							}
							if(conn != null){
								conn.close();
							}
						}
					 %>
				</select><img id="MenuImage" src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>
			</td>											
				</select>
		   </td>
		</tr>
	<%}%>
	<!--ML-MMOH-CRF-0684 Ends-->
	<tr>
		<td class="label"  nowrap><fmt:message key="eOT.DietCategory.Label" bundle="${ot_labels}" /></td>
		<td nowrap>
		<select name="dietCategory" id="dietCategory" id="dietCategory" onchange="checkExclusions_select(this);return fecthDietType(this.value);fecthDietTypeToMealClass();drugAlert();"> <!-- MMS-QH-CRF-0190 --><!--MMS-KH-CRF-0029.1-->
		<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
<%
	try{
		conn = ConnectionManager.getConnection(request);
		String dietCategoryCode = "";
		String description =  "";		
		String sql_diet_Category;
		//Modified Against ML-MMOH-CRF-1123-US3 Starts Here
		if(CheckFlag1.equalsIgnoreCase("Y")){
			if(alaCarte.equalsIgnoreCase("NAC"))
			{
				sql_diet_Category = "select diet_Category_Code, ds_get_desc.ds_diet_category(diet_Category_Code,?, 1) description from Ds_Diet_Category where diet_category_code != 'ALAC'";
				}
			else{
				sql_diet_Category = "select diet_Category_Code, ds_get_desc.ds_diet_category(diet_Category_Code,?, 1) description from Ds_Diet_Category";
				}
			}else{
				sql_diet_Category = "select diet_Category_Code, ds_get_desc.ds_diet_category(diet_Category_Code,?, 1) description from Ds_Diet_Category";
				}
		pstmt = conn.prepareStatement(sql_diet_Category);
		pstmt.setString(1,language_Id);
		rs	= pstmt.executeQuery();
		while(rs != null && rs.next()){
		dietCategoryCode=rs.getString(1);
		description=rs.getString(2);
		
	//Added by Santhosh for ML-MMOH-SCF-2331
	if(isSpecialDiet){
		if(!dietCategoryCode.equals("SD01")){	
	if(dietCategoryCode.equalsIgnoreCase("ALAC") && (CheckFlag1.equalsIgnoreCase("Y"))){
		if(alaCarte.equalsIgnoreCase("AC")){
	%>
			<option value="<%=dietCategoryCode%>" selected>
						<%=description%>
			</option>
	<% }else{
	%>
			<option value="<%=dietCategoryCode%>" >
						<%=description%>
			</option>
	<% }
	}
	else if(dietCategoryCode.equals("THEU") && (CheckFlag.equals("Y"))) {
	%>
		<option value="<%=dietCategoryCode%>" selected>
						<%=description%>
			</option>
	<%	
	}else{				
	%>
			<option value="<%=dietCategoryCode%>" ><%=description%> </option>
	<%
		} //end of else condition					
		} //End of dietCategoryCode
		} else if(isEnteral){//Added Against ML-MMOH-CRF-1123-US3 Starts Here
		if(!dietCategoryCode.equals("ENTE")){	//Added Against ML-MMOH-SCF-1676
	if(dietCategoryCode.equalsIgnoreCase("ALAC") && (CheckFlag1.equalsIgnoreCase("Y"))){
		if(alaCarte.equalsIgnoreCase("AC")){
	%>
			<option value="<%=dietCategoryCode%>" selected>
						<%=description%>
			</option>
	<% }else{
	%>
			<option value="<%=dietCategoryCode%>" >
						<%=description%>
			</option>
	<% }
	}
	//Added Against ML-MMOH-CRF-1123-US3 Ends Here
	//Added Against Start KDAH-CRF-349-US5
	else if(dietCategoryCode.equals("THEU") && (CheckFlag.equals("Y"))) {
	%>
		<option value="<%=dietCategoryCode%>" selected>
						<%=description%>
			</option>
	<%	
	}else{				
	%>
			<option value="<%=dietCategoryCode%>" ><%=description%> </option>
	<%
		} //end of else condition					
		} //End of dietCategoryCode
		} //End of Enteral	  
	 else{
		 if(dietCategoryCode.equalsIgnoreCase("ALAC") && (CheckFlag1.equalsIgnoreCase("Y"))){
		if(alaCarte.equalsIgnoreCase("AC")){
	%>
			<option value="<%=dietCategoryCode%>" selected>
						<%=description%>
			</option>
	<% }else{
	%>
			<option value="<%=dietCategoryCode%>" >
						<%=description%>
			</option>
	<% }
	}
	//Added Against ML-MMOH-CRF-1123-US3 Ends Here
	//Added Against Start KDAH-CRF-349-US5
	else if(dietCategoryCode.equals("THEU") && (CheckFlag.equals("Y"))) {
	%>
		<option value="<%=dietCategoryCode%>" selected>
						<%=description%>
			</option>
	<%	
	}else{				
	%>
			<option value="<%=dietCategoryCode%>" ><%=description%> </option>
	<%
		}
	 }
	} //end of while condition
	
	%>
	</select><img id="dietCatImage" src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>
		<INPUT type="hidden" name="dietCategory1" id="dietCategory1"  value="<%=dietCategoryCode%>"> <!-- Added Against End KDAH-CRF-349-US5 -->	
	<%
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}
	%>
	
		
		</td>
		</tr>

		<!--ML-MMOH-CRF-0427 start-->
		<tr>
			<td class="label"  nowrap><fmt:message key="Common.fromdate.label" bundle="${common_labels}" /></td>
				<td nowrap>
					<input type="text" class='chkFormChange' name="dateFrom" id="dateFrom" id="dateFrom" size="10" maxlength="10" value="" onchange="checkExclusions(this)">
						
					<%
						if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
					%>						
							
					<img src="../../eCommon/images/CommonCalendar.gif"  name='datepickerimg' id='fromdatepickerimg' onclick="grayOutCalendar('dateFrom','<%=maximum_days_allowed%>','<%=language_Id%>');">
					<img id="fromDateImage" src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>

					<%		
						}else{
					%>

					<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dateFrom');">
					<img id="fromDateImage" src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>

					<%	
						}
					%>
					
					<input type="hidden" name="testDate" id="testDate" size="8" />
				</td>
				<td class="label"  nowrap><fmt:message key="Common.todate.label" bundle="${common_labels}" /></td>
					<td>
					<input type="text" name="dateTo" id="dateTo" id="dateTo" class='chkFormChange' size="10" maxlength="10" value="" onchange="checkExclusions(this)">
					<%
						if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
					%>

					<img src="../../eCommon/images/CommonCalendar.gif"  name='datepickerimg' id='todatepickerimg' onclick="grayOutCalendar('dateTo',<%=maximum_days_allowed%>,'<%=language_Id%>')">
					<img id="dateToImage" src='../../eCommon/images/mandatory.gif' style='visibility:visible'/>

					<%	
						}else{
					%>

					<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dateTo');">
					<img id="dateToImage" src='../../eCommon/images/mandatory.gif' style='visibility:visible'/><!-- CRF-412-->

					<%	
					}
					%>
			
			<input type='hidden' name='dateTo.pattern' id='dateTo.pattern' value='dd/MM/yyyy'>
			</td>																
			<td>
			</td>
			<td class="label"  nowrap><fmt:message key="eOT.ReferredToDietician.Label" bundle="${ot_labels}" /></td>
			<td>
				<input type="checkbox" name="dieticianReferral" id="dieticianReferral" id="dieticianReferral" value="" onclick="enableMandatory();">
			</td>
		</tr>
		<tr>
			<td class="label"  nowrap><fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}" /></td>
			<td nowrap>
			<!--select name="mealClass" id="mealClass" onchange="checkExclusions_select(this);drugAlert();return fecthDietTypeToMealClass();"--><!--MMS-KH-CRF-0029.1-->
			<select name="mealClass" id="mealClass" id="mealClass" onchange="checkExclusions_select(this);fecthDietTypeToMealClass(); drugAlert();"><!--MMS-KH-CRF-0029.1-->
		<option value="">																	<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />
<%
	try{
		conn = ConnectionManager.getConnection(request);
		String mealClass = "";
		String description =  "";

		String sql_meal_Class = "select meal_Class,ds_get_desc.ds_meal_class(meal_Class,'"+language_Id+"', 2)  short_Desc from Ds_Meal_Class where eff_Status ='E'";

		pstmt = conn.prepareStatement(sql_meal_Class);
		rs	= pstmt.executeQuery();
		while(rs != null && rs.next()){
		mealClass=rs.getString(1);
		description=rs.getString(2);
	if(mealClass.equals(meal_class_code)){
		%>
			<option value="<%=mealClass%>" selected><%=description%></option>
		<%}else{%>
			<option value="<%=mealClass%>" >
			<%=description%>
			</option>
		<%}
	}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally	{
		if(pstmt != null){																	pstmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}
	 %>
		</select><img id="MealClassImage" src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>
		</td>
		<td  class="label" nowrap><fmt:message key="eOT.DietType.Label" bundle="${ot_labels}" /></td>
		<td nowrap>
		<select name="dietType" id="dietType" id="dietType" onKeyUp="diettype_Autocomplete();" onClick="Select()" onchange="checkExclusions_select(this);fecthDietTypeToMealClass();drugAlert();"><!--Modified against ML-MMOH-CRF-0674--><!--MMS-KH-CRF-0029.1-->
		<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />
		</option>
		</select><img id="dietTypeImage" src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>
		</td>
		<td></td>
		<td class="label"  nowrap>
		<fmt:message key="eDS.FullNilByMouth.Label" bundle="${ds_labels}" />
		</td>
		<td>
		<input type="checkbox" name="Full_Day_NBM_YN" id="Full_Day_NBM_YN" id="Full_Day_NBM_YN" value="" onclick="enableDisableField();enableMandatory();">
		</td>
		</tr>
	<!-- Modified Against Start ML-MMOH-CRF-0671 [IN:062266] -->
	<%if(!isAttendantAge){%>
	<tr id="police_response1" >
		<td  class="label" nowrap>
			<fmt:message key="eOT.FeedType.Label" bundle="${ot_labels}" />
		</td>
		<td>
		<select name="feedType" id="feedType" id="feedType">
			<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />
			<%
				try{
					conn = ConnectionManager.getConnection(request);
					String feedType = "";
					String description =  "";
					String sql_feed_Type = "select feed_Type, ds_get_desc.ds_feed_type(feed_Type,'"+language_Id+"', 2)  short_Desc from Ds_Feed_Type where eff_Status='E'";
					pstmt = conn.prepareStatement(sql_feed_Type) ;
					rs	= pstmt.executeQuery();
					while(rs != null && rs.next()){
						feedType=rs.getString(1);
						description=rs.getString(2);
			 %>
					<option value="<%=feedType%>">
						<%=description%>
					</option>
			<%
				}
				}
				catch(Exception e){
					e.printStackTrace();
				}
				finally	{
					if(pstmt != null){
						pstmt.close();
					}
					if(conn != null){
						conn.close();
					}
				}
			 %>
			</select>
			</td>
			<td  class="label" nowrap>
				<fmt:message key="eOT.deliveryInstruction.Label" bundle="${ot_labels}" />
			</td>
			<td>
				<select name="dsDeliveryInstr" id="dsDeliveryInstr" id="dsDeliveryInstr" indexed="10">
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />
					<%
						try{
							conn = ConnectionManager.getConnection(request);
							String instrCode = "";
							String description =  "";
							String sql_Delivery_Instr = "select substr(ds_get_desc.ds_delivery_instr(instr_Code,'"+language_Id+"', 1) ,1,30), instr_Code from Ds_Delivery_Instr  where eff_Status ='E'";
							pstmt = conn.prepareStatement(sql_Delivery_Instr) ;
							rs	= pstmt.executeQuery();
							while(rs != null && rs.next()){
								description=rs.getString(1);
								instrCode=rs.getString(2);
					 %>
						<option value="<%=instrCode%>">
							<%=description%>
						</option>
					<%
						}
						}
						catch(Exception e){
							e.printStackTrace();
						}
						finally	{
							if(pstmt != null){
								pstmt.close();
							}
							if(conn != null){
								conn.close();
							}
						}
					 %>
			</select>
		</td>
	</tr>
		<%}else{%>
			<tr id="police_response1" >
		<%}%>
		<!-- Modified Against End ML-MMOH-CRF-0671 [IN:062266] -->
		<!--ML-MMOH-CRF-0412 STARTS-->
		<tr>
			<td  class="label" nowrap><fmt:message key="eDS.TextureOfDiet.Label" bundle="${ds_labels}" /></td>
			<td>
				<select name="texture_of_diet" id="texture_of_diet" id="texture_of_diet" indexed="10"><!-- CRF-412-->
				<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" /></option><!-- CRF-412-->
			<%
				try{
					conn = ConnectionManager.getConnection(request);
					String texture_code = "";
					String texture_description =  "";
					String sql_texture_of_diet = "select texture_of_diet,short_desc from ds_texture_of_diet_lang_vw where language_Id like '"+language_Id+"' and eff_status='E' order by short_desc ASC";
					pstmt = conn.prepareStatement(sql_texture_of_diet) ;
					rs	= pstmt.executeQuery();
					while(rs != null && rs.next()){
						texture_code=rs.getString(1);
						texture_description=rs.getString(2);				
			 %>
				<option value="<%=texture_code%>">
					<%=texture_description%>
				</option>
			<%
				}
				}
				catch(Exception e){
					e.printStackTrace();
				}
				finally	{
					if(pstmt != null){
						pstmt.close();
					}
					if(conn != null){
						conn.close();
					}
				}
			 %>
			</select>
		</td>
		<td  class="label" nowrap></td>
		<td></td>
	</tr>
		<!--ML-MMOH-CRF-0412 ENDS-->
	<tr>
		<!-- Modified Against Start ML-MMOH-CRF-0671 [IN:062266] -->
		<%if(!isAttendantAge){%>
			<td  class="label" nowrap><fmt:message key="eOT.feedingInstruction.Label" bundle="${ot_labels}" /></td>
			<td><textarea name="feedingInstructions" id="feedingInstructions" style="resize:none;" onblur="return callsimbly();" onkeypress="restrictSpecialChars(event)"></textarea></td>
		<%}%>
		<!-- Modified Against End ML-MMOH-CRF-0671 [IN:062266] -->
		<td  class="label" nowrap>
		<!-- Modified Against Start ML-MMOH-CRF-0668 [IN:062263] -->
		<%if(isAttendantAge){%>
			<fmt:message key="eDS.Remarks.Label" bundle="${ds_labels}" />
		<%}else{%>
		<!--  Added Against Start KDAH-CRF-0353 US1 -->  
			<%if(isDtCat_MlCls){%>
				<fmt:message key="eDS.NutritionalDiagnosis.Label" bundle="${ds_labels}" />
			<%}else{%>
				<fmt:message key="eOT.preparatoryInstruction.Label" bundle="${ot_labels}" />
			<%}%>	
		<!--  Added Against End KDAH-CRF-0353 US1 -->  
		<%}%>
		<!-- Modified Against End ML-MMOH-CRF-0668 [IN:062263] -->
		</td>
		<td><textarea name="prepInstr" id="prepInstr" cols='35' style="resize:none;" onkeypress="restrictSpecialChars(event)" onblur="textAreaLimit(this,4000);"></textarea></td>
	</tr>
	</table>
	</td>
	</tr>
	<tr>
	<td>
	<table width="100%" border="0" cellspacing="0" cellpadding="2" id="attendent" style="display:none;">
		<tr>
			<th   colspan="2" width="45%"><fmtmessage key="eOT.patientAttendantTitle.Label" bundle="${ot_labels}" /></th>
		</tr>
 <!--ML-MMOH-CRF-0684 Starts-->
 <%if(isMenuType) {%>
	<tr>
	<td class ="label" align ="right">
	<fmt:message key="eDS.MenuType.Label" bundle="${ds_labels}"/>
		<td >
		<select name="mac_menu_type" id="mac_menu_type" id ="mac_menu_type"> <!--Added Against TFS:32135-->
			<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />
			<%
				try{
					conn = ConnectionManager.getConnection(request);
					String MenuTypecode = "";
					String MenuTypedescription =  "";
					String sql_Menu_Count="SELECT count(*) FROM ds_menu_type where eff_status ='E' and appl_for_ip_yn ='Y' AND DEFAULT_YN='Y'";
					pstmt = conn.prepareStatement(sql_Menu_Count);
					rs	= pstmt.executeQuery();
					int defaultcount=0;
					if(rs.next()){
						defaultcount=rs.getInt(1);
						}
					
					String sql_Menu_Type = "SELECT menu_type,short_desc,DEFAULT_YN FROM ds_menu_type where eff_status ='E' and appl_for_ip_yn ='Y' ORDER BY short_desc asc";
					pstmt = conn.prepareStatement(sql_Menu_Type);
					rs	= pstmt.executeQuery();
					while(rs != null && rs.next()){
						MenuTypecode=rs.getString(1);
						MenuTypedescription=rs.getString(2);
					String temp=rs.getString(3);
				if(defaultcount == 1 && temp.equals("Y"))
				{
			 %>
				<option value="<%=MenuTypecode%>" selected>
					<%=MenuTypedescription%>
				</option>
			<%
				}
				else
				{
			%>
			<option value="<%=MenuTypecode%>">
					<%=MenuTypedescription%>
				</option>
			<%
				}
				}
				}
				catch(Exception e){
					e.printStackTrace();
				}
				finally	{
					if(pstmt != null){
						pstmt.close();
					}
					if(conn != null){
						conn.close();
					}
				}
			 %>
		</select><img id="MenuImage" src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>
	</td>											
		</select>
   </td>
</tr>
 <%}%>
<!--ML-MMOH-CRF-0684 Ends-->
<tr>
	<td class="label" ><fmt:message key="Common.fromdate.label" bundle="${common_labels}" /></td>
	<td>
		<input type="text" class='chkFormChange' name="attendentFromDate" id="attendentFromDate" id="attendentFromDate" maxlength="10" onBlur='isValidDate(this)' size="10" >
	<%
		if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
	%>
		<img src='../../eCommon/images/CommonCalendar.gif' onClick="return grayOutCalendar('attendentFromDate','<%=maximum_days_allowed%>','<%=language_Id%>');">
	<%
	}else{
	%>
		<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('attendentFromDate');">
	<%
	}
	%>
	<!--img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('attendentFromDate');"-->
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td class="label" ><fmt:message key="Common.todate.label" bundle="${common_labels}" /></td>
	<td>
		<input type="text" class='chkFormChange' name="attendentToDate" id="attendentToDate" id="attendentToDate" size="10" maxlength="10" onBlur='isValidDate(this)' >
	<%
		if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
	%>
	<img src='../../eCommon/images/CommonCalendar.gif' onClick="return grayOutCalendar('attendentToDate','<%=maximum_days_allowed%>','<%=language_Id%>');">
	<img src='../../eCommon/images/mandatory.gif'></img> <!-- 58902 -->	
	<%			
		}else{
	%>
		<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('attendentToDate');">
		<img src='../../eCommon/images/mandatory.gif'></img> <!-- CRF-412-->
	<%															
		}
	%>		
		<input type='hidden' name='attendentToDate.pattern' id='attendentToDate.pattern' value='dd/MM/yyyy'>
	</td>
</tr>
	<tr>
		<!-- start MMS-QH-CRF-0190 -->
		<td class="label" nowrap><fmt:message key="eOT.DietCategory.Label" bundle="${ot_labels}" /></td>
		<td nowrap>
			<select name="attendentDietCategory" id="attendentDietCategory" onchange="return fecthDietTypes_Attendant(this.value);fecthDietTypeToMealClass();drugAlert();"> <!-- MMS-QH-CRF-0190 --><!--MMS-KH-CRF-0029.1-->
			<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><!-- CRF-412-->
			<%
				try{
						conn = ConnectionManager.getConnection(request);
						String dietCategoryCode = "";
						String description =  "";
						String sql_diet_Category = "select diet_Category_Code, ds_get_desc.ds_diet_category(diet_Category_Code,'"+language_Id+"', 1) description from Ds_Diet_Category where diet_Category_Code in (SELECT diet_Category_Code FROM ds_diet_type WHERE NVL (appl_att_yn, 'N') = 'Y')";//ML-MMOH-SCF-1046
						
						pstmt = conn.prepareStatement(sql_diet_Category);
						rs	= pstmt.executeQuery();
						while(rs != null && rs.next()){
						dietCategoryCode=rs.getString(1);
						description=rs.getString(2);
			%>
					<option value="<%=dietCategoryCode%>">
					<%=description%>
						</option>
			<%
					}
					}
					catch(Exception e){
						e.printStackTrace();
					}
					finally	{
						if(pstmt != null){
							pstmt.close();
						}
						if(conn != null){
							conn.close();
						}
					}
			%>
		</select>
		<img id="dietCatImage" src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img> <!-- 52776 -->
	</td>
	<td  class="label" nowrap><fmt:message key="eOT.DietType.Label" bundle="${ot_labels}" /></td>
	<td nowrap>
		<select name="attendentDiet" id="attendentDiet" onKeyUp="attendentdiettype_Autocomplete();" onClick="attendentSelect()"><!--ML-MMOH-CRF-0674-->
			<option><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" /></option>
		</select>
		<img id="dietTypeImage" src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>
	</td>
</tr>
<tr>
	<td class="label" >
		<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}" />
	</td>
	<td nowrap>
		<select name="attendentMealClass" id="attendentMealClass">
			<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />
<%
	String attendentmealClass = "";
	String attendentdescription = "";
	try{
		conn = ConnectionManager.getConnection(request);
		//Modified Against ML-MMOH-CRF-1005-US2 Starts Here
		String sql_MealClass_Count="SELECT count(*) FROM ds_meal_class where eff_status ='E' and APPL_ATT_YN ='Y'";
		pstmt = conn.prepareStatement(sql_MealClass_Count);
		rs	= pstmt.executeQuery();
		if(rs.next()){
		mc_defaultcount=rs.getInt(1);
		}
		String sql_meal_Class = "select meal_Class,ds_get_desc.ds_meal_class(meal_Class,'"+language_Id+"', 2)  short_Desc from Ds_Meal_Class where eff_Status ='E' and APPL_ATT_YN='Y'";
		pstmt = conn.prepareStatement(sql_meal_Class);
		rs	= pstmt.executeQuery();
		while(rs != null && rs.next()){
		attendentmealClass=rs.getString(1);
		attendentdescription=rs.getString(2);
	if(mc_defaultcount == 1)
	{
%>																						<option value="<%=attendentmealClass%>" selected>										<%=attendentdescription%>														</option>
<%
		}
		else
		{
%>
		<option value="<%=attendentmealClass%>">										<%=attendentdescription%>												</option>
<%
	}
	//Modified Against ML-MMOH-CRF-1005-US2 Ends Here
	}
	}
	catch(Exception e){
	e.printStackTrace();
	}
	finally	{
	if(pstmt != null){																pstmt.close();
	}
	if(conn != null){
	conn.close();
	}
	}
%>
	</select>
	<img src='../../eCommon/images/mandatory.gif'></img>
	<!-- Added Against ML-MMOH-CRF-1005-US2 Starts Here -->
	<input type="hidden" name="mc_defaultcount" id="mc_defaultcount" id ="mc_defaultcount" value="<%=mc_defaultcount%>">
	<!-- Added Against ML-MMOH-CRF-1005-US2 Ends Here -->
	</td>
		<!-- end MMS-QH-CRF-0190 -->
	<td class="label" >
		<!--<fmt:message key="eOT.AttendantInstr.Label" bundle="${ot_labels}" />--> <!--COMMENTED FOR ML-MMOH-CRF-0406-->
		<%=AttendantInstr%> <!--ML-MMOH-CRF-0406-->
	</td>
	<td><textarea name="atndInstr" id="atndInstr" style="resize:none;" cols='35'
	onkeypress="restrictSpecialChars(event)"
	onblur="textAreaLimit(this,120);"></textarea>
	<input type="hidden" name="atndInstr1" id="atndInstr1" value=""></td> <!-- ML-MMOH-SCF-735 -->
	</tr><!-- MMS-DM-SCF-0077 onkeypress function is added -->
</table>
</td>
</tr>
</table>
</td>
</tr>
	<tr id="contentsForAssignDietType" >
		<TD>
		<div id="listContentLayer1" style="display:block;visibility:visible;overflow-n: scroll;height:20;width:502;border: 1px outset #9999FF" align="center">
			<TABLE width="100%" id="Able1" CELLSPACING="0" cellpadding="0">
				<TR>
					<TH colspan="3">
						<fmt:message key="eOT.assign.Label" bundle="${ot_labels}" />
					</TH>
				</TR>
			</TABLE>
			<div id="listContentLayer" style="display:block;visibility:visible;overflow-y: scroll;height:98;width:500;border: 0px outset #9999FF" align="center">
				<TABLE width="100%" id="Able" CELLSPACING="0" cellpadding="0">
					<TR>
					</TR>
				</TABLE>
			</div>
			</div>
		</TD>
		<TD>
			<div id="NilByMounth" style="display:block;visibility:visible;height:116;width:230;border: 1px outset #9999FF" align="center">
			<TABLE class="webglobeBoxBorder" width="100%" CELLSPACING="0" cellpadding="0">
			<TR>
				<TH colspan="2">
					<fmt:message key="eOT.nilBYMounth.Label" bundle="${ot_labels}" />
				</TH>
			</TR>
			<TR>
			<TD class="label" NOWRAP>
				<fmt:message key="Common.fromdate.label" bundle="${common_labels}" />
			</TD>
			<TD>
				<input type="text" class='chkFormChange' name="from" id="from" id="from" size="16" value="" onblur="if(this.value!='') validateDate(this,this.value)">
						
				<%
					if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
				%>
					<img src="../../framework/images/img.gif" id="nbmfromimg" onclick="return grayOutCalendarDateTime('from',<%=maximum_days_allowed%>,'<%=language_Id%>');" style='visibility:visible'/>
				<%
				}else{
				%>	
					<img src="../../framework/images/img.gif" onclick="return showCalForNilByMouth('from','%d/%m/%Y %H:%M','24',true,'from');"/>
				<%
				}
				%>													
			</TD>
			</TR>
			<TR>
			<TD class="label">
				<fmt:message key="Common.todate.label" bundle="${common_labels}" />
			</TD>
			<TD>
				<input type="text" class='chkFormChange' name="to" id="to" id="to" size="16" value="" onblur="if(this.value!='') validateToDate(this,this.value)" >
				<%
					if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
				%>
					<img src="../../framework/images/img.gif" onclick="return grayOutCalendarDateTime('to',<%=maximum_days_allowed%>,'<%=language_Id%>');"/>
				<%
				}else{
				%>
					<img src="../../framework/images/img.gif" onclick="return showCalForNilByMouth('to','%d/%m/%Y %H:%M','24',true,'to');"/>
				<%
				}
				%>
			</TD>
		</TR>
	</TABLE>
	</div>
	</TD>
	</tr>
	</table>
		<br/>
		<table width="100%" summary="asd">
			<tr>
				<th colspan="8"  id="dietOrders">
					<fmt:message key="eOT.dietOrders.Label" bundle="${ot_labels}" />
				</th>
			</tr>
			<tr  id="dietselect">
			<td colspan="8" class="label">
				<fmt:message key="eOT.show.Label" bundle="${ot_labels}" />:
				<select name="status" id="status" id="status" onchange="checkStatus(this.value, this)">
					<option value=""> <fmt:message key="Common.all.label" bundle="${common_labels}" /> </option>
					<option value="A"> <fmt:message key="eOT.activeOrders.Label" bundle="${ot_labels}" /> </option>
					<option value="C"> <fmt:message key="eOT.closedOrders.Label" bundle="${ot_labels}" /> </option>
					<option value="F"> <fmt:message key="eOT.futureOrders.Label" bundle="${ot_labels}" /> </option>
					<option value="X"> Cancelled Orders </option>
					<option value="A~F" selected> Active/Future Orders </option> 
				</select>
			</td>
			</tr>
			<tr>
			<td id="myId">
				<div id="dietlistContentLayer" style="display:block;visibility:visible;overflow-y: scroll;height:100;width:100%;border: 1px outset #9999FF" align="center">
					<table width="100%" summary="asd" id="result_Id">
						<tr>
							<th> </th>
							<th><fmt:message key="eOT.DietType.Label" bundle="${ot_labels}" /></th>
							<th colspan="1"><fmt:message key="Common.Period.label" bundle="${common_labels}" /></th>
							
							<%
							if(isDateLabel){  
							%>
							<th><fmt:message key="eDS.OrderDateTime.Label" bundle="${ds_labels}" /></th> <!--Added against ML-MMOH-CRF-1780-->
							<%
							  }else{
							%>
							<th><fmt:message key="Common.OrderDate.label" bundle="${common_labels}" /></th>
							<%
							  }
							%>
							<th><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}" /></th>
						</tr>
					</table>
				</div>
			</td>
			</tr>
			</table>
			<div id="remarks" style='visibility:visible'>&nbsp;<a href="#" onclick="return Remarks();"><fmt:message key="eOT.Remarks.Label" bundle="${ot_labels}" /></a>
			<img id="remarksImg" src='../../eCommon/images/mandatory.gif' style='visibility:hidden'></img>	<!--Added Against ICN-72015-->
			</div>
			<br/>
			<div id="attendentListLayer" style="display:none;visibility:visible;overflow-y: scroll;height:100;width:100%;border: 1px outset #9999FF" align="center">
				<table width="100%" summary="asd">
				<tr>
					<td>
					<table width="100%" summary="asd" id="attendentListTable">
					<tr>
						<th><fmt:message key="Common.Period.label" bundle="${common_labels}" /></th>
						<th><fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}" /></th>
						<th><fmt:message key="eOT.DietType.Label" bundle="${ot_labels}" /></th>
						<th colspan="2"></th>
					</tr>
					</table>
					</Td>
				</tr>
				</table>
			</div>
			<br/>
			<table  id="addAttendent" align="right" style="display:none;">
			<tr>
				<td  class="data">
					<a href="#" onclick="return checkDates();"><br>+ <fmt:message key="Common.Add.label" bundle="${common_labels}" /> <%=Attendent_Label_Name%></a><!--ML-MMOH-CRF-0406-->
				</td>
			</tr>
			</table>
			</td>
			<td valign="top"  width="20%" id='SideMenuId'> <!-- MMS-QH-CRF-0190 -->
			<div style="visibility:visible;width:110%;overflow-n:border: 1px ;scroll;height:70;width:100%;">
				<table id="tableData" border="0" cellpadding="0" cellspacing="0" width="100%" >
					<tr >
						<td style="text-align: left" class="label" id="as" colspan="2" NOWRAP>
							<fmt:message key="eOT.date.Label" bundle="${ot_labels}" /> :
						</td>
						<td style="text-align: left" class="label" id="as" colspan="2" NOWRAP>
							<input type="text" class='chkFormChange' name="dateForMeanu" id="dateForMeanu" size="10" maxlength="10" value="" onblur="isValidDate(this),getDayRefNo(this.value);" onmouseover="return getDayRefNo(this.value)">
						<!--ML-MMOH-CRF-0427 US3 start-->
						<%
							if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
						%>								
					<img src="../../eCommon/images/CommonCalendar.gif"  name='datepickerimg_1' id='datepickerimg_1' onclick="grayOutCalendar('dateForMeanu',<%=maximum_days_allowed%>,'<%=language_Id%>')">
					<%	
					}else{
					%>	
					<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dateForMeanu');">			
					<%	
						}
					%>
					<!--ML-MMOH-CRF-0427 US3 ends-->	
					</td>
					</tr>
					<tr>
					<td style="text-align: left" class="label" colspan="2" NOWRAP>
						<fmt:message key="eOT.dietCycles.Label" bundle="${ot_labels}" /> :
					</td>
					<td style="text-align: left" class="label" id="as" colspan="2" NOWRAP >
						<select name="dayRef" id="dayRef" onchange="setdayRef(this)" disabled="disabled">
							<option value="">
								<fmt:message key="Common.Select.label" bundle="${common_labels}" />
							</option>
						</select>
						<input type="button" value="<fmt:message key="Common.Go.label" bundle="${common_labels}" />" class="button" onClick="getMenuForDayRef();" />
					</td>
					</tr>
					<tr><td>&nbsp;&nbsp;&nbsp;<td></tr>
					<tbody id="dispGTC" align="center" BORDER = 1 style="overflow:auto;" class="label">
					</tbody>
					</table>
				</div>
			<table>
				<tr>
				<td>
				<div id="SideMenu" style="visibility:visible;overflow-y: scroll"></div>
					<%-- AAKH-CRF-0065 Sp2Us1 --%>
					<div id="html-section" title='<fmt:message key="eOT.meals.Label" bundle="${ot_labels}" />' >
					<table border="1">
						<tr>
							<td id="editMenu_flow_text" onclick="modelWindow(this);"  colspan="9" class="label">
								<%-- AAKH-CRF-0065 Sp1Us1 Start --%>
								<img src='../../eCommon/images/flow_text.gif' alt='Want To Edit' />
								<fmt:message key="eOT.edit.Label" bundle="${ot_labels}" />
								<%-- AAKH-CRF-0065 Sp1Us1 End --%>
							</td>
						</tr>
						<tr><td>&nbsp;</td></tr>
					</table>
					<div style="overflow-y: scroll;height:250;width:100%;">
						<table style="overflow-y: scroll;height:250;width:100%;">
							<tbody id="treemenu3"  BORDER = 1 style="overflow:auto;" class="label"></tbody>
							<tbody id="treemenu4"  BORDER = 1 style="overflow:auto;" class="label"></tbody>
						</table>
					</div>
					</div>
						<%-- AAKH-CRF-0065 Sp2Us1 --%>
					<div id="NutriEntSup" title='<fmt:message key="eOT.nutriEntSupp.Label" bundle="${ot_labels}" />' style="width:100%;overflow-y: scroll;height:60;width:100%;">
					<table border="1">
						<tbody id="Nutrient" align="center" BORDER = 1 style="overflow:auto;" class="label" ></tbody>
						<tbody id="Nutrient1" align="center" BORDER = 1 style="overflow:auto;" class="label"></tbody>
						<tr>
							<td id="nutrient_flow_text" onclick="document.getElementById('nutrientDeleteFlag').value='Y';return nuitrientModelWindow(this);"  colspan="9" class="label">
							<%if (prfSL!=null && !prfSL.equals("") && !prfSL.equals("0")) { %> 
								<img src='../../eCommon/images/flow_text.gif' alt='Want To Edit' />
								<fmt:message key="eOT.edit.Label" bundle="${ot_labels}" />
							<%} %>
							</td>
						</tr>
					</table>
					</div>
					<div id="spFoodItems" style="width:100%;overflow-y: scroll;height:60;width:100%;">
						<table border="1">
							<tbody id="FoodItems" align="center" BORDER = 1 style="overflow:auto;" class="data" ></tbody>
							<tbody id="FoodItems1" align="center" BORDER = 1 style="overflow:auto;" class="label"></tbody>
							<tr>
								<td id="splFoodItem_flow_text" onclick="return spFoodItemsModelWindow(this,'<%=encounterId%>','<%=patientClass%>');"  class="label" colspan="9">
									<img src='../../eCommon/images/flow_text.gif' alt='Want To Edit' />
									<fmt:message key="eOT.edit.Label" bundle="${ot_labels}" />
								</td>
							</tr>
						</table>
					</div>
					<div id="foodDislikes" style="width:100%;overflow-y: scroll;height:45;width:100%;">
						<table border="0">
							<tbody id="DislikesFoodItems"></tbody>
							<tr>
								<td id="foodItem_dislike_flow_text" onclick="return foodDislikesModelWindow(this);"  class="label" colspan="2" >
									<img src='../../eCommon/images/flow_text.gif' alt='Want To Edit' />
									<fmt:message key="eOT.edit.Label" bundle="${ot_labels}" />
								</td>
							</tr>
						</table>
					</div>
					<div id="Others" style="width:110%;overflow-y:height:45;width:100%;">
					<table border="0">
						<tbody id="Others"></tbody>
						<tr>
						<td colspan="2"  class="label">
							<a
								href="javascript:callDiagnosis()"><fmt:message key="eOT.activeProblems.Label" bundle="${ot_labels}" />
							</a>
						</td>
						</tr>
						<tr>
							<td colspan="2"  class="label">
								<a
									href="javascript:callDiagnosis1()"><fmt:message key="eOT.allergies.Label" bundle="${ot_labels}" />
								</a>
							</td>
						</tr>
					</table>
					</div>
					<div id="mealTypeExclusions" style="width:100%;overflow-y: scroll;height:105;width:100%;background-color:white;">
						<table border="0">
							<tr>
								<td id="exclusions_flow_text" onclick="return openExclusionsWindow(this);"  class="label" colspan="2" >
								<img src='../../eCommon/images/flow_text.gif' alt='Want To Edit' />
								<fmt:message key="eOT.edit.Label" bundle="${ot_labels}" />
								</td>
							</tr>
							<tbody id="exclusions"></tbody>					
						</table>
					</div>
					</td>
					</tr>
					</table>
				</td>
			</tr>
			</table>
			</td>
		</tr>
		</table>
		<input type="hidden" name="languageId" id="languageId" id="languageId" value="<%=language_Id%>" />
		<input type="hidden" name="kitchenCode" id="kitchenCode" value="<%=kitchen_Code%>">
		<input type="hidden" name="encounterId" id="encounterId" id="encounterId" value="<%=encounterId%>">
		<input type="hidden" name="profileSL" id="profileSL" id="profileSL" value="<%=prfSL%>" />
		<input type="hidden" name="remarks_1" id="remarks_1" id="remarks_1" value="<%=remarks_1%>" />	<!-- MMS-KH-CRF-029.1 -->
		<input type="hidden" name="profileSL1" id="profileSL1" id="profileSL1" value="<%=prfSL%>" />
		<input type="hidden" name="addedFacilityId" id="addedFacilityId" id="addedFacilityId" value="<%=facility_id%>" />
		<input type="hidden" name="Patient_ID" id="Patient_ID" value="<%=patientId%>" />
		<input type="hidden" name="patientClass" id="patientClass" value="<%=patientClass%>" />
		<input type="hidden" name="locationType" id="locationType" value="<%=location_type%>" />
		<input type="hidden" name="locationCode" id="locationCode" value="<%=ward_Code%>" />
		<input type="hidden" name="addedById" id="addedById" id="addedById" value="<%=strloggeduser%>" />
		<input type="hidden" name="addedAtWsNo" id="addedAtWsNo" id="addedAtWsNo" value="<%=strclientip%>" />
		<input type ="hidden" name="defalutDietType" id="defalutDietType" />
		<input type ="hidden" name="defalutMealType" id="defalutMealType" />
		<input type ="hidden" name="deitTypesStatus" id="deitTypesStatus" id="deitTypesStatus" value="<%=acceptDietForIndMealYn%>"/>
		<input type ="hidden" name="gracePeriodApplicableYN" id="gracePeriodApplicableYN" value="<%=graceAplYN%>"/>
		<input type ="hidden" name="gracePeriod" id="gracePeriod" value="<%=periodHr%>"/>
		<input type="hidden" name="mealTotalCalorie" id="mealTotalCalorie" />
		<input type="hidden" name="datepattrn1" id="datepattrn1" value="dd/MM/yyyy"/>
		<input type="hidden" name="isNEW" id="isNEW" />
		<input type="hidden" name="orderID" id="orderID" />
		<input type="hidden" name="ageGroupCode1" id="ageGroupCode1"  />
		<input type="hidden" name="ageGroupArr" id="ageGroupArr"  />
		<input type="hidden" name="nFITotalCalorie" id="nFITotalCalorie" />
		<input type="hidden" name="splFITotalCalorie" id="splFITotalCalorie" />
		<input type="hidden" name="selectedProfile" id="selectedProfile" id="selectedProfile" />
		<input type="hidden" name="checkMealType" id="checkMealType" value="" />
		<input type="hidden" name="checkDietType" id="checkDietType" value="" />
		<input type="hidden" name="unCheckedMType" id="unCheckedMType" value="" />
		<input type="hidden" name="unCheckedDType" id="unCheckedDType" value="" />
		<input type="hidden" name="checkedMType" id="checkedMType" value="" />
		<input type="hidden" name="checkedDType" id="checkedDType" value="" />
		<input type="hidden" name="flag" id="flag" value="<%=flag%>" />
		<input type="hidden" name="hdrFlag" id="hdrFlag" value="" />
		<input type="hidden" name="servingDate" id="servingDate" id="servingDate" value="<%=servingDate%>" />
		<!--<input type="hidden" name="remarks" id="remarks" value="" /> --><!-- Commented Against AMRI-SCF-0497 -->
		<input type="hidden" name="splFlagArr" id="splFlagArr" value="false" />
		<input type="hidden" name="nutriFlagArr" id="nutriFlagArr" value="false" />
		<input type="hidden" name="profileFlag" id="profileFlag" id="profileFlag" value="<%=profileFlag%>" /><!--ML-MMOH-CRF-0427-->
		<input type="hidden" name="restrict_date_inpatients_yn" id="restrict_date_inpatients_yn" id="restrict_date_inpatients_yn" value="<%=restrict_date_inpatients_yn%>" /><!--ML-MMOH-CRF-0427-->
		<input type="hidden" name="maximum_days_allowed" id="maximum_days_allowed" id="maximum_days_allowed" value="<%=maximum_days_allowed%>" /><!--ML-MMOH-CRF-0427-->
		<input type="hidden" name="GEN_MEALPLAN_FOR_NBM_PAT_YN" id="GEN_MEALPLAN_FOR_NBM_PAT_YN" id="GEN_MEALPLAN_FOR_NBM_PAT_YN" value="<%=GEN_MEALPLAN_FOR_NBM_PAT_YN%>" /><!-- MMS-QH-CRF-0078.1-US003-->
		<input type="hidden" name="IRREGULAR_DIET_ORD_YN" id="IRREGULAR_DIET_ORD_YN" id="IRREGULAR_DIET_ORD_YN" value="<%=IRREGULAR_DIET_ORD_YN%>" /><!-- ML-MMOH-CRF-409-->
		<input type="hidden" name="IRREGULAR_MEAL_ORD_MESSAGE" id="IRREGULAR_MEAL_ORD_MESSAGE" id="IRREGULAR_MEAL_ORD_MESSAGE" value="<%=IRREGULAR_MEAL_ORD_MESSAGE%>" /><!-- ML-MMOH-CRF-409-->
		<input type="hidden" name="irregular_meal_code" id="irregular_meal_code" id="irregular_meal_code" value="" /><!-- ML-MMOH-CRF-409-->
		<input type="hidden" name="No_Of_Attendant" id="No_Of_Attendant" id="No_Of_Attendant" value="<%=No_Of_Attendant%>" /><!-- ML-MMOH-CRF-412-->
		<input type="hidden" name="Attendent_Label_Name" id="Attendent_Label_Name" id="Attendent_Label_Name" value="<%=Attendent_Label_Name%>" /><!-- ML-MMOH-CRF-406-->
		<input type="hidden" name="enable_drugfood_YN" id="enable_drugfood_YN" id="enable_drugfood_YN" value="<%=enableDrugFoodYN%>" /> 
		<!-- MMS-KH-CRF-0029.1-US008 -->
		<!--ML-MMOH-CRF-0672 Starts Here-->
		<input type="hidden" name="diffDays" id="diffDays" id="diffDays" value="<%=diffDays%>">
		<input type="hidden" name="isLos_gt7" id="isLos_gt7" id="isLos_gt7" value="<%=isLos_gt7%>">
		<!--ML-MMOH-CRF-0672 Ends Here-->
		<script type="text/javascript" src="../../eDS/js/setupmenu.js"></script>
		<script type="text/javascript">
		var menu = new NavBar("SideMenu");
		new NavSection(menu, '<fmt:message key="eOT.meals.Label" bundle="${ot_labels}" />', "html-section","sec"); // look in the HTML code for a DIV with ID="html-section"
		new NavSection(menu, '<fmt:message key="eOT.nutriEntSupp.Label" bundle="${ot_labels}" />', "NutriEntSup","nutsuppl");
		new NavSection(menu, '<fmt:message key="eOT.SpclFoodItems.Label" bundle="${ot_labels}" />', "spFoodItems","spfood"); <!-- Modified Against PMG2017-COMN-CRF-0012 [IN066074] -->
		new NavSection(menu, '<fmt:message key="eOT.foodDislikes.Label" bundle="${ot_labels}" />', "foodDislikes","dslk");
		new NavSection(menu, '<fmt:message key="Common.others.label" bundle="${common_labels}" />', "Others","oth");
		new NavSection(menu, '<fmt:message key="eDS.mealExclusions.Label" bundle="${ds_labels}" />', "mealTypeExclusions","exc");
		menu.generate(true);
		menu.sync(true);
		//$("#exc")[0].onclick();

		if(document.getElementById("defalutMealType").value){
			document.getElementById("mealClass").value = document.getElementById("defalutMealType").value;
		}

		if(document.getElementById("profileSL1") != null && document.getElementById("profileSL1") != "")
		{
			checkStatus("A~F",document.all("status"));
			document.getElementById("status").value="A~F";
		}

	function setdayRef(obj){
		document.getElementById("dayRef").value=obj.value;
	}

	var pArgumentArray = new Array();
	pArgumentArray[0]=document.getElementById("Patient_ID").value;
	pArgumentArray[1]=document.getElementById("locationCode").value;
	pArgumentArray[2]=document.getElementById("patientClass").value;
	pArgumentArray[3]=document.getElementById("locationType").value;
	pArgumentArray[4]=document.getElementById("encounterId").value;

	function callDiagnosis(){
		var retVal = new String();
		var dialogHeight = "600px";
		var dialogWidth = "900px";
		var status = "no";
		var dialogUrl = "../../eCA/jsp/PatProblemList.jsp?patient_id="+pArgumentArray[0]+"&location_code="+pArgumentArray[1]+"&patient_class="+pArgumentArray[2]+"&locn_type="+pArgumentArray[3]+"&episode_id="+pArgumentArray[4]+"&modal_yn=Y";
		var dialogArguments = pArgumentArray;
		var dialogFeatures = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + " ; scroll=no; status:" + status;
		window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);
	}

	function callDiagnosis1(){
		var retVal = new String();
		var dialogHeight = "600px";
		var dialogWidth = "900px";
		var status = "no";
		var dialogUrl =  "../../eCA/jsp/AllergyList.jsp?patient_id="+pArgumentArray[0]+"&called_from_ip=Y";
		var dialogArguments = pArgumentArray;
		var dialogFeatures = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + " ; scroll=no; status:" + status;
		window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);
	}
	  
	function restrictSpecialChars(event){
		var strCheck = '~!@#$%^&*()+=`{}|[];:_-,/\\?<>"\'';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  
		if (strCheck.indexOf(key) != -1) 
		{
			window.event.keyCode = 27;
			return false;  
		}
		return true ;
	}
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		<input type="hidden" name="maxprofileSL" id="maxprofileSL" id="maxprofileSL" value="" />
 		<input type="hidden" name="maxActiveprofileSL" id="maxActiveprofileSL" id="maxActiveprofileSL" value="" /> <!-- AMRI-SCF-0385 [IN:056722] -->
		<input type="hidden" name="dieticianReferral_hidden" id="dieticianReferral_hidden" id="dieticianReferral_hidden" value=""/><!--CRF-410-->
		<INPUT type="hidden" name="nutrientDeleteFlag" id="nutrientDeleteFlag" value="N">
		<INPUT type="hidden" name="language_Id" id="language_Id" id="language_Id" value="<%=language_Id%>">
		<INPUT type="hidden" name="attendantAge" id="attendantAge" id="attendantAge" value="<%=attendantAge%>"> <!-- ML-MMOH-CRF-746-->
		<INPUT type="hidden" name="yearIntValue" id="yearIntValue" id="yearIntValue" value="<%=yearIntValue%>"> <!-- ML-MMOH-CRF-746-->
		<INPUT type="hidden" name="monthIntValue" id="monthIntValue" id="monthIntValue" value="<%=monthIntValue%>"> <!-- ML-MMOH-CRF-746-->
		<INPUT type="hidden" name="dayIntValue" id="dayIntValue" id="dayIntValue" value="<%=dayIntValue%>"> <!-- ML-MMOH-CRF-746-->
		<INPUT type="hidden" name="attendant_Order_Applicable_Yn" id="attendant_Order_Applicable_Yn" id="attendant_Order_Applicable_Yn" value="<%=attendant_Order_Applicable_Yn%>"> <!-- ML-MMOH-CRF-746-->		
		
		<INPUT type="hidden" name="isAttendantAge" id="isAttendantAge" id="isAttendantAge" value="<%=isAttendantAge%>">
		<INPUT type="hidden" name="editMenu_flow_text" id="editMenu_flow_text" id="editMenu_flow_text" value=""/><!--ML-MMOH-CRF-0669-->
		<!-- Added Against ML-MMOH-CRF-0671[IN:062266] -->
		<%if(isAttendantAge){%>
			<INPUT type="hidden" name="feedingInstructions" id="feedingInstructions" id="feedingInstructions" value="">
			<INPUT type="hidden" name="feedType" id="feedType" id="feedType" value="">
			<INPUT type="hidden" name="dsDeliveryInstr" id="dsDeliveryInstr" id="dsDeliveryInstr" value="">
		<%}%>
		    <INPUT type="hidden" name="isMenuType" id="isMenuType" id="isMenuType" value="<%=isMenuType%>">
		<!-- Added against KDAH-CRF-0352 Starts Here-->
		    <INPUT type="hidden" name="isEditMealType" id="isEditMealType" id="isEditMealType" value="<%=isEditMealType%>">	
		<!-- Added against KDAH-CRF-0352 Ends Here-->
			<INPUT type="hidden" name="isDtCat_MlCls" id="isDtCat_MlCls" id="isDtCat_MlCls" value="<%=isDtCat_MlCls%>"> <!-- Added Against KDAH-CRF-349-US5 -->
			<INPUT type="hidden" name="isAlaCarte" id="isAlaCarte" id="isAlaCarte" value="<%=isAlaCarte%>"> <!-- Added Against ML-MMOH-CRF-1123-US3 -->
		<!-- Added against ML-MMOH-CRF-0674 Starts Here-->
		<INPUT type="hidden" name="diettype_auto" id="diettype_auto" id="diettype_auto" value="">
		<INPUT type="hidden" name="auto_flag" id="auto_flag" id="auto_flag" value="false">			
		<INPUT type="hidden" name="remarkDrugAlert" id="remarkDrugAlert" value="">		
		<!-- Added against ML-MMOH-CRF-0674 Ends Here-->
		<INPUT type="hidden" name="isMACNBM" id="isMACNBM" id="isMACNBM" value="<%=isMACNBM%>"><!--Added Against ML-MMOH-CRF-1460 Starts-->
	<script>
	function calledDietType(){
		var isDtCat_MlCls = "";
		if(document.getElementById("isDtCat_MlCls")!=null)
		isDtCat_MlCls=document.getElementById("isDtCat_MlCls").value;
		//Added Against ML-MMOH-CRF-1123-US3 Starts Here
		var isAlaCarte = "";
		if(document.getElementById("isAlaCarte")!=null)
		isAlaCarte=document.getElementById("isAlaCarte").value;	
		//Added Against ML-MMOH-CRF-1123-US3 Ends Here
		var diet_Category1 = "";
		diet_Category1 = document.getElementById("dietCategory1").value;
		diet_Category = document.getElementById("dietCategory").value;
		var assign_val = "";
			if(isDtCat_MlCls == "true" || isDtCat_MlCls == true){
				assign_val=diet_Category1;
				fecthDietType(assign_val);
				fecthDietTypeToMealClass();
				fecthMealContents();
			}
			//Added Against ML-MMOH-CRF-1123-US3 Starts Here
			if(isAlaCarte ==true || isAlaCarte == "true" ){
				assign_val=diet_Category;
				fecthDietType(assign_val);
				fecthDietTypeToMealClass();
				fecthMealContents();
			}
			//Added Against ML-MMOH-CRF-1123-US3 Ends Here
		}
	</script>
	</form>
</body>
</html>

