<!DOCTYPE html>
<%@ page import="webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,java.util.ArrayList,eCommon.Common.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<html>
<head>
<% 
        //Added Against MMS Vulnerability Issue - Starts
	    request= new XSSRequestWrapper(request);
	    response.addHeader("X-XSS-Protection", "1; mode=block");
	    response.addHeader("X-Content-Type-Options", "nosniff");
		//Added Against MMS Vulnerability Issue - Ends
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ?
		(String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
		if(sStyle==null)sStyle="IeStyle.css";		

		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");

		String strloggeduser	=  (String) httpSession.getValue("login_user");
		String strclientip ="";
		strclientip=p.getProperty("client_ip_address");

		String facility_id	= (String)session.getAttribute("facility_id");
		String language_Id  = (String)session.getAttribute("LOCALE");
		String ward_Code = request.getParameter("locationCode");
		String location_type = request.getParameter("locationType");
		String encounterId=	request.getParameter("encounterIds");
		String patientId=	request.getParameter("patientIds");
     	String patientClass=	request.getParameter("patientClass_bulk");//ML-MMOH-CRF-0820	
		String enableDrugYN="";	//MMS-KH-CRF-0029.1
		String restrict_date_inpatients_yn="",maximum_days_allowed="";//ML-MMOH-CRF-0427
		boolean profileFlag=true;//ML-MMOH-CRF-0427
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		Connection conn = null;
		conn = ConnectionManager.getConnection(request);
		//Added Against ML-MMOH-SCF-1874 Starts
		boolean isEnteral = false;
		isEnteral = CommonBean.isSiteSpecific(conn,"DS","DS_DIET_ENTERAL");
		
		//Added by Santhosh for ML-MMOH-SCF-2331 
		boolean isSpecialDiet = false;
		isSpecialDiet = CommonBean.isSiteSpecific(conn,"DS","SPECIAL_DIET_CATEGORY");
	
		//Added Against ML-MMOH-SCF-1874 Ends
		//ML-MMOH-CRF-0684
		boolean isMenuType =false;
        	isMenuType = CommonBean.isSiteSpecific(conn,"DS","DS_MENU_TYPE");		
		//ML-MMOH-CRF-0684
		//KDAH-CRF-0349-US5 Start 
		boolean isDtCat_MlCls =false;
        	isDtCat_MlCls = CommonBean.isSiteSpecific(conn,"DS","DS_MEAL_MENU_ITEMS");		
		//KDAH-CRF-0349-US5 End
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
		String kitchen_Code =  "";
		String prfSL = "";
		String acceptDietForIndMealYn = "";
		String GEN_MEALPLAN_FOR_NBM_PAT_YN="";//MMS-QH-CRF-0078.1-US003
		String IRREGULAR_DIET_ORD_YN="",IRREGULAR_MEAL_ORD_MESSAGE="";//ML-MMOH-CRF-409
		//Added Against Start ML-MMOH-CRF-0671 and 0668
		boolean isAttendantAge = false;
		isAttendantAge = CommonBean.isSiteSpecific(conn,"DS","PLACE_ORDER_FOR_ATTENDANT");//Using same function for Selayang
		//Added Against End ML-MMOH-CRF-0671 and 0668
		
		//Added Against ML-MMOH-CRF-0672 Starts Here
	 	boolean isLos_gt=false;
		isLos_gt = CommonBean.isSiteSpecific(conn,"DS","PLACE_ORDER_FOR_ATTENDANT");//Using same function for Selayang
		//Added Against ML-MMOH-CRF-0672 Ends Here		
		
		try{
			String sql_ward_Code = "select ward_Code, kitchen_Code from Ds_Wards_For_Kitchen where operating_Facility_Id ='"+facility_id+"' and ward_Code ='"+ward_Code+"'";
			String profileSL_query = "SELECT NVL(MAX(PROFILE_SL),0) FROM DS_EPSD_DIET_PROFILE_HDR WHERE ENCOUNTER_ID ='"+encounterId+"'";
			String acceptMealDiet_query = "select ACCEPT_DIET_FOR_IND_MEAL_YN,GEN_MEALPLAN_FOR_NBM_PAT_YN,restrict_date_inpatients_yn,nvl(maximum_days_allowed,'1') maximum_days_allowed,LATE_IRREGULAR_DIET_ORD_FOR_IP,IRREGULAR_MEAL_ORD_MESSAGE from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = '"+facility_id+"'";//ML-MMOH-CRF-0427 and  MMS-QH-CRF-0078.1-US003 and ML-MMOH-CRF-409
			pstmt = conn.prepareStatement(sql_ward_Code);
			pstmt1 = conn.prepareStatement(profileSL_query);
			pstmt2 = conn.prepareStatement(acceptMealDiet_query);
			rs	= pstmt.executeQuery();
// 			rs1	= pstmt1.executeQuery();
			rs2	= pstmt2.executeQuery();
			
			while(rs != null && rs.next()){
				ward_Code=rs.getString(1);
				kitchen_Code=rs.getString(2);
			}
			while(rs1 != null && rs1.next()){
				prfSL = rs1.getString(1);
			}
			if(rs2 != null && rs2.next()){
				acceptDietForIndMealYn = rs2.getString(1);
				GEN_MEALPLAN_FOR_NBM_PAT_YN=checkForNull(rs2.getString("GEN_MEALPLAN_FOR_NBM_PAT_YN"));//MMS-QH-CRF-0078.1-US003
				//ML-MMOH-CRF-0427
				restrict_date_inpatients_yn=checkForNull(rs2.getString("restrict_date_inpatients_yn"));
				maximum_days_allowed=checkForNull(rs2.getString("maximum_days_allowed"));
				maximum_days_allowed=""+(Integer.parseInt(maximum_days_allowed)-1);
				//ML-MMOH-CRF-0427
				//ML-MMOH-CRF-409 Starts
				IRREGULAR_DIET_ORD_YN=checkForNull(rs2.getString("LATE_IRREGULAR_DIET_ORD_FOR_IP"));
				IRREGULAR_MEAL_ORD_MESSAGE=checkForNull(rs2.getString("IRREGULAR_MEAL_ORD_MESSAGE"));
				//ML-MMOH-CRF-409 Ends
			}
			
			//ML-MMOH-CRF-0427
			if(restrict_date_inpatients_yn.equals("Y")){
				profileFlag=true;
			}
			else
			{
				profileFlag=false;
			}
			//ML-MMOH-CRF-0427
			//MMS-KH-CRF-0029.1-US008 Start
			String enableDrugFood="select ENABLE_DRUG_FOOD_YN from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = '"+facility_id+"'";
				pstmt3=conn.prepareStatement(enableDrugFood);					
				rs3=pstmt3.executeQuery();
				while(rs3 != null && rs3.next()){
					enableDrugYN=checkForNull(rs3.getString(1));
				}
				if(rs3!=null) rs3.close();
				if(pstmt3!=null) pstmt3.close();
			//MMS-KH-CRF-0029.1-US008 Ends
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
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='StyleSheet1' href='../../eCommon/html/body.css' type='text/css'/>
	<style type="text/css">
	/*@import url(../../eDS/css/css2/themes/winxp/skin.css);*/
	@import url(../../eDS/css/skin.css);
	</style>
	
	<script language="JavaScript" src="../../framework/js/PopupWindow.js" type="text/javascript"></script>
	<script type="text/javascript" src="../../eDS/js/navbar.js"></script>
	<script type="text/javascript" src="../../eDS/js/simpletreemenu.js"></script>
	<script type="text/javascript" src="../../framework/js/hashtable.js"></script>
	<script type="text/javascript" src="../../eDS/js/PlaceBulkDietOrder.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eDS/js/json.js"></script>
	<script language="Javascript" src="../../framework/js/PopupWindow.js"></script>
	<script language="javascript" src="../../eDS/js/PlaceDietOrderPHIS.js"></script>
	<!--ML-MMOH-CRF-427 starts-->
		
	<link rel="stylesheet" type="text/css" href="../../eDS/css/jquery-ui.css"/>
	<link rel="stylesheet" type="text/css" href="../../eDS/js/common/semiDisableDate/jquery.datetimepicker.css"/>
	<link rel="stylesheet" type="text/css" href="../../eDS/js/common/semiDisableDate/jquery-ui-timepicker-addon.css"/>
	<link rel="stylesheet" type="text/css" href="../../eDS/js/common/semiDisableDate/timepicker.css"/>  
  
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	
	<script type="text/javascript" src="../../eDS/js/common/semiDisabledDateTime/datepicker-<%=language_Id%>.js"></script>
	<!--ML-MMOH-CRF-427 ends-->	
	<!-- ML-MMOH-CRF-428 starts -->
	<script src="../../eDS/js/Moment.js"></script>
	<script src="../../eDS/js/MomentRange.js"></script>
	<!-- ML-MMOH-CRF-428 ends -->
	<input type="hidden" name="languageId" id="languageId" value="<%=language_Id%>" />
	<input type="hidden" name="enableDrugYN" id="enableDrugYN" id="enableDrugYN" value="<%=enableDrugYN%>"/>	<!--MMS-KH-CRF-0029.1-->

	<script type="text/javascript">
	_NavBar_pageID = "Home"; /* disable the current page from the menu */

	var profileSL;
	var mealTypesArr = new Array();
// 	parent.patientsObj =eval('(' + parent.jsonObj + ')');
	parent.patientsObj =parent.jsonObj;
	
	function hide(){
		document.getElementById("police_response1").style.display = 'none';
		document.getElementById("contentsForAssignDietType").style.display = 'none';
		document.getElementById("attendentListLayer").style.display = 'inline';
		document.getElementById("dietlistContentLayer").style.display = 'none';
		document.getElementById("attendent").style.display = 'inline';
		document.getElementById("pateint").style.display = 'none';
		document.getElementById("addAttendent").style.display = 'inline';
		document.getElementById("dietOrders").style.display = 'none';
		document.getElementById("dietselect").style.display = 'none';
		getAttendDitypes();
	}
	function show(){
		 document.getElementById("police_response1").style.display = 'inline';
		 document.getElementById("contentsForAssignDietType").style.display = 'inline';
		 document.getElementById("attendentListLayer").style.display = 'none';
		 document.getElementById("dietlistContentLayer").style.display = 'inline';
		 document.getElementById("attendent").style.display = 'none';
		 document.getElementById("pateint").style.display = 'inline';
		 document.getElementById("addAttendent").style.display = 'none';
		 document.getElementById("dietOrders").style.display = 'inline';
		 document.getElementById("dietselect").style.display = 'inline';
	}

	function checkStatus(status,object)
	{	
		if(object)
		{
		for(var i=0;i<object.length;i++)
		{
			if(status!="")
			{
			if(object[i].value==status)
			{
				var obj = document.all(object[i].value);
				if (obj) {
					if (obj.length > 1) {
						for (var j = 0; j < obj.length; j++) {
							obj[j].style.display = "inline";
						}
					} else {
						obj.style.display = "inline";
					}
				}
			}
			else
			{
				var obj = document.all(object[i].value);
				if (obj) {
					if (obj.length > 1) {
						for (var k = 0; k < obj.length; k++) {
							obj[k].style.display = "none";
						}
					} else {
						obj.style.display = "none";
					}
				}

			}
			}
			else
			{
				var obj = document.all(object[i].value);
				if (obj) {
					if (obj.length > 1) {
						for (var iter = 0; iter < obj.length; iter++) {
							obj[iter].style.display = "inline";
						}
					} else {
						obj.style.display = "inline";
					}
				}
			}
		}
	 }
	}

	// Added Start for AMRI-SCF-0385 [IN056722]
	function restrictSpecialChars(event){
		var strCheck = '~!@#$%^&*()+=`{}|[];:_-,/\\?<>"\'';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  
		if (strCheck.indexOf(key) != -1) 
		{
			window.event.keyCode = 27;
			return false;  
		}
		return true;
		}
// Added End for AMRI-SCF-0385 [IN056722]
    </script>
</head>

<!-- <body onmouseup="disabledField();" onload="fecthMealContents();getSysDate();"> -->
<body onload="onloadPage();getSysDate();fetchDietType(this.value);">
<script type="text/javascript" src="../../eOT/js/wz_tooltip.js"></script><!--Added Against ML-MMOH-CRF-0672-->
	<form id="input" name="PlaceDietOrderForm" id="PlaceDietOrderForm"  action="../../servlet/eDS.PlaceDietOrderServlet" target="messageFrame" onsubmit="checkNull();">
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
	<td>
	<table width="100%" border="1" cellspacing="0" cellpadding="0" bordercolor="#9999FF" height="100%">
	<TR>
	<td colspan="3" style="background-color:grey"><br/><font size="4"><b>Group Order</b><br/></font>
	<br/>
	<br/>
	</td></tr>
	<tr>
	<div style="overflow-y: scroll;overflow-x: scroll;">
	<td valign="top" width="20%">
	<br/>
	<br/>
	
	<div style="height:90%; overflow:auto;">
		<table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" id="patientList">
			<tr>
				<th colspan="4" align="center" >Selected Patients</th>
			</tr>								
			<tr>
				<th>Encounter ID</th>
				<th>Patient ID</th>
				<th>Special FoodItems&nbsp;&nbsp;<input type="checkbox" name="chk_spl_checkAll" id="chk_spl_checkAll" id="spl_checkAll" onclick="checkAll_Spl()"/></th>
				<th>Food Dislikes	<input type="checkbox" name="chk_dislike_checkAll" id="chk_dislike_checkAll" id="dislike_checkAll" onclick="checkAll_Dislikes()"/></th>
			</tr>
		</table>	
	 </div>
	</td>
	</div>
	<td width="60%" valign="top">
	<div overflow="auto">
	<br/>
	<left>
<%-- <table width="50%" class="webglobeBoxBorder" summary="asd" cellpadding="0" cellspacing="0">
		<tr>
			<td align="center" valign="top" class="smalltext"><fmt:message key="Common.patient.label" bundle="${common_labels}" /></td>
			<td align="center" valign="top" class="smalltext"><input type="Radio" name="Suballocator" id="Suballocator" value="Yes" onclick="show();" checked></td>
			<td align="center" valign="top" class="smalltext"><fmt:message key="eOT.attendant.Label" bundle="${ot_labels}" /></td>

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
				if(attendant_Order_Applicable_Yn!=null  && !(attendant_Order_Applicable_Yn.equals("")) && attendant_Order_Applicable_Yn.equals("Y")){
			%>
				<input type="Radio" name="Suballocator" id="Suballocator" value="No" onclick="hide();">
			<%
			}
			else{
			%>
				<input type="Radio" name="Suballocator" id="Suballocator" value="No" disabled="disabled"></td>
			<%
			}
			%>
		</tr>
	</table> --%>
	<br />
	<table width="100%">
	<tr>
		<td align="center" valign="top" colspan="2">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
		<td>
		<table width="100%" border="0" cellspacing="0" cellpadding="2" id="pateint" style="display:inline;">
		<tr>
		<th align="left" valign="top" colspan="6" width="50%">
		<fmt:message key="eOT.patientOptionTitle.Label" bundle="${ot_labels}" />
		</th>
	</tr>
								
	<!--ML-MMOH-CRF-0684 Starts-->
	<%if(isMenuType){%>
		<tr>
			<td class ="label" align ="right">
			<fmt:message key="eDS.MenuType.Label" bundle="${ds_labels}"/>
		<td>
		   <select name="menu_type" id="menu_type" id = "menu_type">
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
		</select><img id="dietCatImage" src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>
		</td>											
		 </select>
		</td>
	 </tr>
	<%}%>
<!--ML-MMOH-CRF-0684 Ends-->
	<tr>
		<td class="label" align="right" nowrap><fmt:message key="eOT.DietCategory.Label" bundle="${ot_labels}" /></td>
		<td nowrap>
		<!-- 																<select name="dietCategory" id="dietCategory" onchange="return fecthDietType(this.value);fecthDietTypeToMealClass();"> -->
		<select name="dietCategory" id="dietCategory" onchange="checkExclusions_select(this);return fetchDietType(this.value);fecthDietTypeToMealClass();onloadItems();">	
		<option><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
		<%
			try{
				conn = ConnectionManager.getConnection(request);
				String dietCategoryCode = "";
				String description =  "";
				//String sql_diet_Category = "select diet_Category_Code,description from Ds_Diet_Category_Lang_Vw where language_Id ='"+language_Id+"'";
				String sql_diet_Category = "select diet_Category_Code, ds_get_desc.ds_diet_category(diet_Category_Code,'"+language_Id+"', 1) description from Ds_Diet_Category";
				pstmt = conn.prepareStatement(sql_diet_Category);
				rs	= pstmt.executeQuery();
				while(rs != null && rs.next()){
				dietCategoryCode=rs.getString(1);
				description=rs.getString(2);
				if(isSpecialDiet){
					if(!dietCategoryCode.equals("SD01")){	
					if(dietCategoryCode.equalsIgnoreCase("ALAC") && (CheckFlag1.equalsIgnoreCase("Y"))){
						if(alaCarte.equalsIgnoreCase("AC")){
						%>
							<option value="<%=dietCategoryCode%>" selected><%=description%></option>
						<% }else{
						%>
								<option value="<%=dietCategoryCode%>" >
											<%=description%>
								</option>
						<% }}
					else if(dietCategoryCode.equals("THEU") && isDtCat_MlCls){
					%>
							<option value="<%=dietCategoryCode%>" selected><%=description%></option>
							<%}else{%>
						<option value="<%=dietCategoryCode%>">
							<%=description%>
						</option>
					<%}
					} //End of dietCategoryCode
				} else if(isEnteral){//Added Against ML-MMOH-CRF-1123-US3 Starts Here	//Added if condition Against ML-MMOH-SCF-1874
				if(!dietCategoryCode.equals("ENTE")){	
				if(dietCategoryCode.equalsIgnoreCase("ALAC") && (CheckFlag1.equalsIgnoreCase("Y"))){
					if(alaCarte.equalsIgnoreCase("AC")){
					%>
						<option value="<%=dietCategoryCode%>" selected><%=description%></option>
					<% }else{
					%>
							<option value="<%=dietCategoryCode%>" >
										<%=description%>
							</option>
					<% }}
				//Added Against ML-MMOH-CRF-1123-US3 Ends Here
				else if(dietCategoryCode.equals("THEU") && isDtCat_MlCls){
		%>
				<option value="<%=dietCategoryCode%>" selected><%=description%></option>
				<%}else{%>
			<option value="<%=dietCategoryCode%>">
				<%=description%>
			</option>
		<%}
		} //End of dietCategoryCode
		} //End of Enteral	
			
			else{
		if(dietCategoryCode.equalsIgnoreCase("ALAC") && (CheckFlag1.equalsIgnoreCase("Y"))){
					if(alaCarte.equalsIgnoreCase("AC")){
					%>
						<option value="<%=dietCategoryCode%>" selected><%=description%></option>
					<% }else{
					%>
							<option value="<%=dietCategoryCode%>" >
										<%=description%>
							</option>
					<% }}
				//Added Against ML-MMOH-CRF-1123-US3 Ends Here
				else if(dietCategoryCode.equals("THEU") && isDtCat_MlCls){
		%>
				<option value="<%=dietCategoryCode%>" selected><%=description%></option>
				<%}else{%>
			<option value="<%=dietCategoryCode%>">
				<%=description%>
			</option>
		<%}
		}	
				}//End of While Loop
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
			</select><img src='../../eCommon/images/mandatory.gif'></img>
		</td>
<%-- 															<td class="label" align="right" nowrap><fmt:message key="eOT.ReferredToDietician.Label" bundle="${ot_labels}" /></td>
		<td>
			<input type="checkbox" name="dieticianReferral" id="dieticianReferral" value="">
		</td> --%>															
	</tr>
	<tr>
		<td class="label" align="right" nowrap><fmt:message key="Common.fromdate.label" bundle="${common_labels}" /></td>
			<td nowrap>
			<!--orginal starts
				<input type="text" name="dateFrom" id="dateFrom" size="10" maxlength="10" value="" onblur="isValidDate(this)">
				<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dateFrom');">
				<img src='../../eCommon/images/mandatory.gif'></img>
				<input type="hidden" name="testDate" id="testDate" size="8" />
				orignal ends
				-->
				<input type="text" name="dateFrom" id="dateFrom" id="dateFrom" size="10" maxlength="10" value="" onblur="isValidDate(this)" onchange="onloadItems();checkExclusions(this);">
					<!--ML-MMOH-CRF-0427 US3 start-->
					<%
						if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
					%>					
				<img src="../../eCommon/images/CommonCalendar.gif"  name='datepickerimg' id='datepickerimg' onclick="grayOutCalendar('dateFrom','<%=maximum_days_allowed%>','<%=language_Id%>')">	
				<img id="fromDateImage" src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>
				<%		
					}else{
				%>
				<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dateFrom');">
				<img id="fromDateImage" src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>
				<%	
					}
				%>	
				<!--ML-MMOH-CRF-0427 US3 ends-->
				<input type="hidden" name="testDate" id="testDate" size="8" />
				</td>
				<td class="label" align="right" nowrap><fmt:message key="Common.todate.label" bundle="${common_labels}" /></td>
				<td>
					<!--
					<input type="text" name="dateTo" id="dateTo" id="dateTo" size="10" maxlength="10" value="" onblur="isValidDate(this)">
						<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dateTo');">
					<input type='hidden' name='dateTo.pattern' id='dateTo.pattern' value='dd/MM/yyyy'>-->
					<input type="text" name="dateTo" id="dateTo" id="dateTo" class='chkFormChange' size="10" maxlength="10" value="" onchange="onloadItems();checkExclusions(this);">
					<!--ML-MMOH-CRF-0427 US3 start-->
				<%
					if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
				%>
					<img src="../../eCommon/images/CommonCalendar.gif"  name='datepickerimg' id='datepickerimg' onclick="grayOutCalendar('dateTo','<%=maximum_days_allowed%>','<%=language_Id%>')">
					<img id="dateToImage" src='../../eCommon/images/mandatory.gif' style='visibility:visible'/>
				<%	
					}else{
				%>	
					<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dateTo');">
					<img id="dateToImage" src='../../eCommon/images/mandatory.gif' style='visibility:hidden'/>
				<%	
					}
				%>
				<!--ML-MMOH-CRF-0427 US3 start-->
				
					<input type='hidden' name='dateTo.pattern' id='dateTo.pattern' value='dd/MM/yyyy'>
				</td>
				<%-- 															<td class="label" align="right" nowrap><fmt:message key="eOT.ReferredToDietician.label" bundle="${ot_labels}" /></td>
				<td>
					<input type="checkbox" name="dieticianReferral" id="dieticianReferral" value="">
				</td> --%>
			</tr>
			<tr>
				<td class="label" align="right" nowrap><fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}" /></td>
				<td nowrap>
				<select name="mealClass" id="mealClass" onchange="checkExclusions_select(this);fecthDietTypeToMealClass();onloadItems();">
					<option><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />
					<%
						try{
							conn = ConnectionManager.getConnection(request);
							String mealClass = "";
							String description =  "";
							//String sql_meal_Class = "select meal_Class,short_Desc from Ds_Meal_Class_Lang_Vw where language_Id like '"+language_Id+"' and eff_Status ='E'";
							String sql_meal_Class = "select meal_Class,ds_get_desc.ds_meal_class(meal_Class,'"+language_Id+"', 2)  short_Desc from Ds_Meal_Class where eff_Status ='E'";
							pstmt = conn.prepareStatement(sql_meal_Class);
							rs	= pstmt.executeQuery();
							while(rs != null && rs.next()){
							mealClass=rs.getString(1);
							description=rs.getString(2);
							if(mealClass.equals("GE") && isDtCat_MlCls){
					 %>
							<option value="<%=mealClass%>" selected><%=description%></option>
							<%}else{%>
							<option value="<%=mealClass%>">
							<%=description%>
						</option>
					<%}
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
					</select><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
				<td align="right" class="label" nowrap><fmt:message key="eOT.DietType.Label" bundle="${ot_labels}" /></td>
				<td nowrap>
					<select name="dietType" id="dietType" onKeyUp="diettype_Autocomplete();" onClick="Select()" onchange="checkExclusions_select(this);fecthDietTypeToMealClass();onloadItems();"><!--Modified against ML-MMOH-CRF-0674-->
						<option><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />
						</option>
					</select><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
				</tr>
				<!-- Modified Against Start ML-MMOH-CRF-0671 [IN:062266] -->
				<%if(!isAttendantAge){%>
				<tr id="police_response1" style="display:inline;">
					<td align="right" class="label" nowrap>
						<fmt:message key="eOT.FeedType.Label" bundle="${ot_labels}" />
					</td>
					<td>
					<select name="feedType" id="feedType">
					<option><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />
					<%
						try{
							conn = ConnectionManager.getConnection(request);
							String feedType = "";
							String description =  "";
							//String sql_feed_Type = "select feed_Type, short_Desc from Ds_Feed_Type_Lang_Vw where eff_Status='E' and language_Id='"+language_Id+"'";
							String sql_feed_Type = "select feed_Type, ds_get_desc.ds_feed_type(feed_Type,'"+language_Id+"', 2)  short_Desc from Ds_Feed_Type where eff_Status='E'";
							pstmt = conn.prepareStatement(sql_feed_Type) ;
							rs	= pstmt.executeQuery();
							while(rs != null && rs.next()){
								feedType=rs.getString(1);
								description=rs.getString(2);
					 %>
						<option value="<%=feedType%>"><%=description%></option>
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
					<td align="right" class="label" nowrap>
						<fmt:message key="eOT.deliveryInstruction.Label" bundle="${ot_labels}" />
					</td>
					<td>
					<select name="dsDeliveryInstr" id="dsDeliveryInstr" indexed="10">
					<option><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />
					<%
							try{
								conn = ConnectionManager.getConnection(request);
								String instrCode = "";
								String description =  "";
								//String sql_Delivery_Instr = "select substr(long_Desc,1,30), instr_Code from Ds_Delivery_Instr_Lang_Vw where eff_Status ='E' and language_Id = '"+language_Id+"'";
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
				<%}%>
				<!-- Modified Against End ML-MMOH-CRF-0671 [IN:062266] -->
				<!--ML-MMOH-CRF-0412 STARTS-->
				<tr>
					<td align="right" class="label" nowrap><fmt:message key="eDS.TextureOfDiet.Label" bundle="${ds_labels}" /></td>
					<td>
					<select name="texture_of_diet" id="texture_of_diet" indexed="10">
					<option><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />
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
					<td align="right" class="label" nowrap></td>
					<td></td>
				</tr>
				<!--ML-MMOH-CRF-0412 ENDS-->
				
				<tr>
					<!-- Modified Against Start ML-MMOH-CRF-0671 [IN:062266] -->
					<%if(!isAttendantAge){%>
						<td align="right" class="label" nowrap><fmt:message key="eOT.feedingInstruction.Label" bundle="${ot_labels}" /></td>
						<td><textarea name="feedingInstructions" onkeypress="restrictSpecialChars(event)"></textarea></td> <!-- Added for AMRI-SCF-0385 [IN056722] -->
					<%}%>
					<!-- Modified Against End ML-MMOH-CRF-0671 [IN:062266] -->
						<td align="right" class="label" nowrap>
					<!-- Modified Against Start ML-MMOH-CRF-0668 [IN:062263] -->
					<%if(isAttendantAge){%>
						<fmt:message key="eDS.Remarks.Label" bundle="${ds_labels}" />
					<%}else{%>
						<fmt:message key="eOT.preparatoryInstruction.Label" bundle="${ot_labels}" />
					<%}%>
					<!-- Modified Against End ML-MMOH-CRF-0668 [IN:062263] -->
					</td>
						<td><textarea name="prepInstr"  cols='35' onblur="textAreaLimit(this,4000);"onkeypress="restrictSpecialChars(event)"></textarea></td><!-- Added for AMRI-SCF-0385 [IN056722] -->
					</tr>
				</table>
				</td>
				</tr>
				<tr>
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="2" id="attendent" style="display:none;">
						<tr>
							<th align="left" valign="top" colspan="2" width="45%"><fmtmessage key="eOT.patientAttendantTitle.Label" bundle="${ot_labels}" /></th>
						</tr>
						<tr>
							<td class="label" align="right"><fmt:message key="Common.fromdate.label" bundle="${common_labels}" /></td>
							<td>
								<input type="text" name="attendentFromDate" id="attendentFromDate" maxlength="10" onBlur='isValidDate(this)' size="10" >
								<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('attendentFromDate');">
								<img src='../../eCommon/images/mandatory.gif'></img>
							</td>
							<td class="label" align="right"><fmt:message key="Common.todate.label" bundle="${common_labels}" /></td>
							<td>
								<input type="text" name="attendentToDate" id="attendentToDate" size="10" maxlength="10" onBlur='isValidDate(this)' >
								<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('attendentToDate');">
								<input type='hidden' name='attendentToDate.pattern' id='attendentToDate.pattern' value='dd/MM/yyyy'>
							</td>
						</tr>
						<tr>
						<td class="label" align="right">
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

									//String sql_meal_Class = "select meal_Class,short_Desc from Ds_Meal_Class_Lang_Vw where language_Id like '"+language_Id+"' and eff_Status ='E'";
									String sql_meal_Class = "select meal_Class,ds_get_desc.ds_meal_class(meal_Class,'"+language_Id+"', 2)  short_Desc from Ds_Meal_Class where eff_Status ='E'";
									pstmt = conn.prepareStatement(sql_meal_Class);
									rs	= pstmt.executeQuery();
									while(rs != null && rs.next()){
										attendentmealClass=rs.getString(1);
										attendentdescription=rs.getString(2);
								 %>
									<option value="<%=attendentmealClass%>">
										<%=attendentdescription%>
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
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
					<td class="label" align="right">
						<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}" />
					</td>
					<td nowrap>
						<select name="attendentDiet" id="attendentDiet">
							<option><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />
						</select>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
					<td colspan="2"></td>
						</tr>
					</table>
				</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr id="contentsForAssignDietType" style="display:inline;">
			<TD>
				<div id="listContentLayer1" style="display:block;visibility:visible;overflow-n: scroll;height:20;width:450;border: 1px outset #9999FF" align="center">
					<TABLE width="100%" id="Able1" CELLSPACING="0" cellpadding="0">
						<TR>
							<TH colspan="3">
								<fmt:message key="eOT.assign.Label" bundle="${ot_labels}" />
							</TH>
						</TR>
					</TABLE>
					<div id="listContentLayer" style="display:block;visibility:visible;overflow-y: scroll;height:98;width:450;border: 0px outset #9999FF" align="center">
						<TABLE width="100%" id="Able" CELLSPACING="0" cellpadding="0">
							<TR>
							</TR>
						</TABLE>
					</div>
				</div>
			</TD>
			<TD>
			<div id="NilByMounth" style="display:block;visibility:visible;height:116;width:250;border: 1px outset #9999FF" align="center">
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
					<!-- <TD>
						<input type="text" name="from" id="from" size="10" maxlength="10" value="" onblur="isValidDate(this);" >
						<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('from');">
					</TD> -->
					<TD>
					<!--MMS-QH-CRF-0078.1-US003 58572-->
						<input type="text" name="from" id="from" id="from" size="16" value="" onblur="if(this.value!='') validateDate(this,this.value)">
						<!--img src="../../framework/images/img.gif" onclick="return showCalForNilByMouth('from','%d/%m/%Y %H:%M','24',true,'from');"/-->
						
						<!--ML-MMOH-CRF-0427 US3 start-->
						<%
								if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
						%>
								<img src="../../framework/images/img.gif" onclick="return grayOutCalendarDateTime('from','<%=maximum_days_allowed%>','<%=language_Id%>');"/>
						<%
						}else{
						%>	
								<img src="../../framework/images/img.gif" onclick="return showCalForNilByMouth('from','%d/%m/%Y %H:%M','24',true,'from');"/>
						<%
						
						}
						%>							
						<!--ML-MMOH-CRF-0427 US3 ends-->							
					</TD>													
				</TR>
				<TR>
					<TD class="label">
						<fmt:message key="Common.todate.label" bundle="${common_labels}" />
					</TD>
					<TD>
						<!-- <input type="text" name="to" id="to" size="10" maxlength="10" value="" onblur="isValidDate(this);" >
						<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('to');"> -->
						<!--MMS-QH-CRF-0078.1-US003 58572-->
						<input type="text" name="to" id="to" id="to" size="16" value="" onblur="if(this.value!='') validateToDate(this,this.value)" >
						<!--img src="../../framework/images/img.gif" onclick="return showCalForNilByMouth('to','%d/%m/%Y %H:%M','24',true,'to');"/-->							
						<!--ML-MMOH-CRF-0427 US3 Starts-->
						<%
								if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
						%>
								<img src="../../framework/images/img.gif" onclick="return grayOutCalendarDateTime('to','<%=maximum_days_allowed%>','<%=language_Id%>');"/>
						<%
						}else{
						%>
								<img src="../../framework/images/img.gif" onclick="return showCalForNilByMouth('to','%d/%m/%Y %H:%M','24',true,'to');"/>
						<%
						}
						%>
						<!--ML-MMOH-CRF-0427 US3 ends-->							
					</TD>
				</TR>
			</TABLE>
			</div>
			</TD>
		</tr>
	</table>
<br/>
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
<table align="right" id="addAttendent" style="display:none;">
	<tr>
		<td align="right" class="data">
			<a href="javascript:callBlank()" onclick="return checkDates();"><br>+ <fmt:message key="eOT.aaaAttendent.Label" bundle="${ot_labels}" /></a>
		</td>
	</tr>
</table>
</div>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>							
</td>
<td valign="top" align="left" width="20%"  >
	<div style="width:110%;overflow-n:border: 1px ;scroll;height:70;width:100%;">
		<table id="tableData" border="0" cellpadding="0" cellspacing="0" width="100%" align="left">
		<tr align="left">
			<td style="text-align: left" class="label" id="as" colspan="2" NOWRAP>
				<fmt:message key="eOT.date.Label" bundle="${ot_labels}" /> :
			</td>
			<td style="text-align: left" class="label" id="as" colspan="2" NOWRAP>
			<input type="text" name="dateForMenu" id="dateForMenu" id="dateForMenu" size="10" maxlength="10" value="" onblur="isValidDate(this),getDayRefNo(this.value);">
				<!--
				<input type="text" name="dateForMenu" id="dateForMenu" size="10" maxlength="10" value="" onblur="isValidDate(this),getDayRefNo(this.value);">
					<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dateForMenu');">
					-->
				<!--ML-MMOH-CRF-0427 US3 start-->	
				<%
					if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
				%>				
					<img src="../../eCommon/images/CommonCalendar.gif"  name='datepickerimg_1' id='datepickerimg_1' onclick="grayOutCalendar('dateForMenu','<%=maximum_days_allowed%>','<%=language_Id%>')">
					<!--img src="../../framework/images/img.gif" onclick="return showCalForNilByMouth('dateForMeanu','%d/%m/%Y %H:%M','24',true,'to');"/-->			
				<%	
				}else{
				%>	
				<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dateForMenu');">										
				<%	
				}
				%>		
				<!--ML-MMOH-CRF-0427 US3 start-->									
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
			<div id="html-section" title='<fmt:message key="eOT.meals.Label" bundle="${ot_labels}" />' style="width:100%;overflow-y: scroll;height:350;width:100%;">
			<table border="1">
			<tbody id="treemenu3" align="left" BORDER = 1 style="overflow:auto;" class="label"></tbody>
			<tbody id="treemenu4" align="left" BORDER = 1 style="overflow:auto;" class="label"></tbody>
			<tr>
			<td>
			<br/>
			</td>
		</tr>
		</table>
		</div>
		<div id="spFoodItems" style="width:100%;overflow-y: scroll;height:60;width:100%;">
			<table border="1">
				<tbody id="FoodItems" align="center" BORDER = 1 style="overflow:auto;" class="data" ></tbody>
				<tbody id="FoodItems1" align="center" BORDER = 1 style="overflow:auto;" class="label"></tbody>
				<tr>
					<td id="splFoodItem_flow_text" align="right" class="label" colspan="9"
					onclick="return spFoodItemsModalWindow(this,'<%=encounterId%>','');" align="right" class="label" colspan="9" disabled>
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
					<td id="foodItem_dislike_flow_text" onclick="return foodDislikesModelWindow(this);" align="right" class="label" colspan="2" disabled>
						<img src='../../eCommon/images/flow_text.gif' alt='Want To Edit' />
						<fmt:message key="eOT.edit.Label" bundle="${ot_labels}" />
					</td>
				</tr>
			</table>
		</div>
		<div id="mealTypeExclusions" style="width:100%;overflow-y: scroll;height:105;width:100%;">
			<table border="0">														
				<tr>
					<td id="exclusions_flow_text" onclick="return openExclusionsWindow(this);" align="right" class="label" colspan="2" >
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
		<input type="hidden" name="GEN_MEALPLAN_FOR_NBM_PAT_YN" id="GEN_MEALPLAN_FOR_NBM_PAT_YN" id="GEN_MEALPLAN_FOR_NBM_PAT_YN" value="<%=GEN_MEALPLAN_FOR_NBM_PAT_YN%>" /><!-- MMS-QH-CRF-0078.1-US003-->
		<input type="hidden" name="profileFlag" id="profileFlag" id="profileFlag" value="<%=profileFlag%>" /><!--ML-MMOH-CRF-0427-->
		<input type="hidden" name="restrict_date_inpatients_yn" id="restrict_date_inpatients_yn" id="restrict_date_inpatients_yn" value="<%=restrict_date_inpatients_yn%>" /><!--ML-MMOH-CRF-0427-->
		<input type="hidden" name="maximum_days_allowed" id="maximum_days_allowed" id="maximum_days_allowed" value="<%=maximum_days_allowed%>" /><!--ML-MMOH-CRF-0427-->
		<input type="hidden" name="IRREGULAR_DIET_ORD_YN" id="IRREGULAR_DIET_ORD_YN" id="IRREGULAR_DIET_ORD_YN" value="<%=IRREGULAR_DIET_ORD_YN%>" /><!-- ML-MMOH-CRF-409-->
		<input type="hidden" name="IRREGULAR_MEAL_ORD_MESSAGE" id="IRREGULAR_MEAL_ORD_MESSAGE" id="IRREGULAR_MEAL_ORD_MESSAGE" value="<%=IRREGULAR_MEAL_ORD_MESSAGE%>" /> <!-- ML-MMOH-CRF-409-->
		<input type="hidden" name="irregular_meal_code" id="irregular_meal_code" id="irregular_meal_code" value="" /> <!-- ML-MMOH-CRF-409-->
		<input type="hidden" name="dietTypesStatus" id="dietTypesStatus" id="dietTypesStatus" value="<%=acceptDietForIndMealYn%>"/> <!-- ML-MMOH-CRF-409-->
		<input type="hidden" name="patientClass" id="patientClass" value="<%=patientClass%>" /><!--ML-MMOH-CRF-0820-->
			<!-- Added against ML-MMOH-CRF-0674 Starts Here-->
		<INPUT type="hidden" name="diettype_auto" id="diettype_auto" id="diettype_auto" value="">
		<INPUT type="hidden" name="auto_flag" id="auto_flag" id="auto_flag" value="false">
		<!-- Added against ML-MMOH-CRF-0674 Ends Here-->
		
<%-- 		<input type="hidden" name="languageId" id="languageId" value="<%=language_Id%>" /> --%>
		<input type="hidden" name="kitchenCode" id="kitchenCode" value="<%=kitchen_Code%>">
		<input type="hidden" name="encounterId" id="encounterId" value="<%=encounterId%>">
		<input type="hidden" name="profileSL" id="profileSL" value="" />
		<input type="hidden" name="profileSL1" id="profileSL1" value="<%=prfSL%>" />
		<input type="hidden" name="addedFacilityId" id="addedFacilityId" value="<%=facility_id%>" />
		<input type="hidden" name="Patient_ID" id="Patient_ID" value="<%=patientId%>" />
<%-- 		<input type="hidden" name="patientClass" id="patientClass" value="<%=patientClass%>" /> --%>
		<input type="hidden" name="locationType" id="locationType" value="<%=location_type%>" />
		<input type="hidden" name="locationCode" id="locationCode" value="<%=ward_Code%>" />
		<input type="hidden" name="addedById" id="addedById" value="<%=strloggeduser%>" />
		<input type="hidden" name="addedAtWsNo" id="addedAtWsNo" value="<%=strclientip%>" />
		<input type ="hidden" name="defalutDietType" id="defalutDietType" />
		<input type ="hidden" name="defalutMealType" id="defalutMealType" />
		<input type ="hidden" name="dietTypesStatus" id="dietTypesStatus" value="<%=acceptDietForIndMealYn%>"/>
		<input type="hidden" name="mealTotalCalorie" id="mealTotalCalorie" />
		<input type="hidden" name="datepattrn1" id="datepattrn1" value="dd/MM/yyyy"/>
		<input type="hidden" name="isNEW" id="isNEW" />
		<input type="hidden" name="orderID" id="orderID" />
		<input type="hidden" name="ageGroupCode1" id="ageGroupCode1"  />
		<input type="hidden" name="ageGroupArr" id="ageGroupArr"  />
		<input type="hidden" name="nFITotalCalorie" id="nFITotalCalorie" />
		<input type="hidden" name="splFITotalCalorie" id="splFITotalCalorie" />
		<input type="hidden" name="mealTotalCalorie" id="mealTotalCalorie" />
		<input type="hidden" name="dieticianReferral" id="dieticianReferral" value="">
		<INPUT type="hidden" name="isAttendantAge" id="isAttendantAge" id="isAttendantAge" value="<%=isAttendantAge%>">
		<!-- Added Against ML-MMOH-CRF-0671[IN:062266] -->
		<%if(isAttendantAge){%>
			<INPUT type="hidden" name="feedingInstructions" id="feedingInstructions" id="feedingInstructions" value="">
			<INPUT type="hidden" name="feedType" id="feedType" id="feedType" value="">
			<INPUT type="hidden" name="dsDeliveryInstr" id="dsDeliveryInstr" id="dsDeliveryInstr" value="">
		<%}%>
		<INPUT type="hidden" name="isMenuType" id="isMenuType" id="isMenuType" value="<%=isMenuType%>"><!--ML-MMOH-CRF-0684-->
		<INPUT type="hidden" name="isAlaCarte" id="isAlaCarte" id="isAlaCarte" value="<%=isAlaCarte%>"> <!-- Added Against ML-MMOH-CRF-1123-US3 -->
		<script type="text/javascript" src="../../eDS/js/setupmenu.js"></script>
		<INPUT type="hidden" name="encounter" id="encounter" value="">		<!--MMS-KH-CRF-0029.1-->
		<INPUT type="hidden" name="remarkDrugAlert" id="remarkDrugAlert" value="">	<!--MMS-KH-CRF-0029.1-->
		<script type="text/javascript">

		var menu = new NavBar("SideMenu");
		new NavSection(menu, '<fmt:message key="eOT.meals.Label" bundle="${ot_labels}" />', "html-section"); // look in the HTML code for a DIV with ID="html-section"
		new NavSection(menu, '<fmt:message key="eOT.nutriEntSupp.Label" bundle="${ot_labels}" />', "NutriEntSup");
		new NavSection(menu, '<fmt:message key="eOT.SpclFoodItems.Label" bundle="${ot_labels}" />', "spFoodItems");<!-- Modified Against PMG2017-COMN-CRF-0012 [IN066074] -->
		//new NavSection(menu, '<fmt:message key="eDS.SpecialFoodItem.Label" bundle="${ds_labels}" />', "spFoodItems");//5th Dec17
		new NavSection(menu, '<fmt:message key="eOT.foodDislikes.Label" bundle="${ot_labels}" />', "foodDislikes");
		new NavSection(menu, '<fmt:message key="Common.others.label" bundle="${common_labels}" />', "Others");
		//new NavSection(menu, '<fmt:message key="eDS.mealExclusions.Label" bundle="${common_labels}" />', "mealTypeExclusions");
		new NavSection(menu, '<fmt:message key="eDS.mealExclusions.Label" bundle="${ds_labels}" />', "mealTypeExclusions","exc");
		menu.generate(true);
		menu.sync(true);
		//$("#exc")[0].onclick();		//Commented for MMS-KH-CRF-0029.1

		if(document.getElementById("defalutMealType").value){
			document.getElementById("mealClass").value = document.getElementById("defalutMealType").value;
		}

/* 		if(document.getElementById("profileSL1") != null && document.getElementById("profileSL1") != ""){
			checkStatus("",document.all("status"));
			document.getElementById("status").value="";
		} */

		function setdayRef(obj){
			document.getElementById("dayRef").value=obj.value;
		}

		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</form>
</body>
<script>

		var encounter_ID = [];
		var newRow = "";
		var isLos_gt7=""+<%=isLos_gt%>;//Added Against ML-MMOH-CRF-0672 
		function onloadPage(){
		for(i=0;i<parent.patientsObj.patients.length;i++) {
			obj=parent.patientsObj.patients[i].patient;
			newRow = document.all("patientList").insertRow();
			newRow.setAttribute("id","patientRow"+obj.encounterId);
			var cell1=newRow.insertCell(0);
			cell1.innerHTML="<a id='delete"+obj.encounterId+"' href = javascript:deletePatient('"+obj.encounterId+"');><img src='../../eCommon/images/RRnwd.gif'></img></a>"+"     "+obj.encounterId;
			var cell2=newRow.insertCell(1);
			cell2.innerHTML="<a href='javascript:selectPatient();'>"+obj.patientId+"<div id='rem_"+obj.encounterId+"' style='visibility:hidden'>&nbsp;<a href='#' onclick='return Remarks1("+obj.encounterId+");'><fmt:message key='eOT.Remarks.Label' bundle='${ot_labels}'/><img id='MenuImage"+obj.encounterId+"' src='../../eCommon/images/mandatory.gif' style='visibility:hidden'></img></div></a>";	//Added against MMS-KH-CRF-0029.1
			var cell3=newRow.insertCell(2);
			cell3.textAlign="center";
			//cell3.innerHTML="<p align='center'><input type='checkbox' name='chk_spl_"+obj.encounterId+"' id='chk_spl_"+obj.encounterId+"' id='spl_"+obj.encounterId+"' onclick='check_SplFoodItems('"+obj.encounterId+"')/></p>";
			//Added Against ML-MMOH-CRF-0672 starts Here
			var diffDays=obj.diffDays;
			if(isLos_gt7 =="true" && isLos_gt7!="" && diffDays > 7 && diffDays!="")
				cell3.innerHTML="<p align='center'><input type='checkbox' name='chk_spl_"+obj.encounterId+"' id='chk_spl_"+obj.encounterId+"' id='spl_"+obj.encounterId+"' onclick='check_SplFoodItems("+obj.encounterId+")'/><img  name='chk_spl_image"+obj.encounterId+"' id='spl_image"+obj.encounterId+"' src='../../eDS/css/food_item_los.jpg' OnMouseOver='Tip(losToolTip(),JUMPHORZ,true)' onmouseout='UnTip()'></img></p>";
			else
				cell3.innerHTML="<p align='center'><input type='checkbox' name='chk_spl_"+obj.encounterId+"' id='chk_spl_"+obj.encounterId+"' id='spl_"+obj.encounterId+"' onclick='check_SplFoodItems("+obj.encounterId+")'/></p>";
			//Added Against ML-MMOH-CRF-0672 Ends Here
			var cell4=newRow.insertCell(3);
			cell4.innerHTML="<p align='center'><input type='checkbox' name='chk_dislike_"+obj.encounterId+"' id='chk_dislike_"+obj.encounterId+"' id='dislike_'"+obj.encounterId+"' onclick='check_FoodDislikes("+obj.encounterId+",this)'/></p>";
		
			encounter_ID.push(obj.encounterId);	//Added against MMS-KH-CRF-0029.1
		}
		}
		
		//Added against MMS-KH-CRF-0029.1 Starts Here	
		
		function encounter_IDs()
		{
		return encounter_ID;	
		}
		
		function onloadItems(){
			var deleteEncounter = [];
			var enabledrugfoodYN = document.getElementById("enableDrugYN").value;		
			if(enabledrugfoodYN=="Y")
			{
			remark_yn = groupOrder(); 
			document.getElementById("remarkDrugAlert").value = remark_yn;
			var remark_alert_yn = document.getElementById("remarkDrugAlert").value;
			var warning = remark_alert_yn.split(",");
		for(i=0;i<parent.patientsObj.patients.length;i++) {
			obj=parent.patientsObj.patients[i].patient;
			var retValLen = warning.length/2;
			var count =0;
			var drug_patient=[];
			var countInc =1;
			for(var k=1;k<=retValLen;k++){
			for(var j=count;j<=countInc;j++)
				{
				drug_patient.push(warning[j]);	
				}
			if(trim(drug_patient[0])=="N" && trim(drug_patient[1])==obj.patientId)
			{	
				document.getElementById("rem_"+obj.encounterId).style.visibility = 'visible';	
				document.getElementById("MenuImage"+obj.encounterId).style.visibility = 'visible';	
			}
			else if(trim(drug_patient[0])=="Y" && trim(drug_patient[1])==obj.patientId)
			{
				deleteEncounter.push(obj.encounterId);
			}
			count=count+2;
			countInc = countInc+2;
			drug_patient = [];
			}
			}
			deleteDrugPatient(deleteEncounter);
			}}
		
		function deleteDrugPatient(encounterId) {
			var outputArray = [];
			var count = 0;
			var start = false;
			for (var m = 0; m < encounterId.length; m++) {
			for(var k=0; k < outputArray.length; k++) {
			if(encounterId[m] == outputArray[k] ) {
			start = true;
			}
			}
			count++;
			if(count == 1 && start == false) {
			outputArray.push(encounterId[m]);
			}
			start=false;
			count=0;
			}
			var uniqueEncounter =outputArray;
			for(var j=0;j<uniqueEncounter.length;j++)
			{
				encounterId = uniqueEncounter[j];
			obj=parent.patientsObj.patients;
			var flag=false;
			var flag_spl=false;
			var flag_dislike=false;
			
			if(obj.length==1) {
				alert(getMessage("DS_SEL_PAT","DS")); //"Atleast one patient should be selected";
				return;
			}
			document.getElementById("chk_spl_"+encounterId).checked=false; 
			document.getElementById("chk_dislike_"+encounterId).checked=false;
			if(isLos_gt7 =="true" && isLos_gt7!="" && diffDays > 7 && diffDays!="")
			{
				var splimageobj=document.getElementById("spl_image"+encounterId);
			if(splimageobj != null && splimageobj != undefined && splimageobj !="" && splimageobj !="null" && splimageobj !="undefined")
				document.getElementById("spl_image"+encounterId).onmouseover=null;
			}
			if(splJSONObj.items !=null) {
				if((parseInt(jsonPatientArr_Spl.length) ==1) && parseInt(splJSONObj.items.length)!=0 ) {
					if(jsonPatientArr_Spl[0].patient.encounterId == encounterId) {
						alert("Special Food Items is selected. Atleast one Special Food Item Check box should be selected");
						document.getElementById("chk_spl_"+encounterId).checked=true;
						flag=true;
					}
				}
			}
			else {
				if(parseInt(jsonPatientArr_Spl.length) ==1) {
					if(jsonPatientArr_Spl[0].patient.encounterId == encounterId) {
						document.getElementById("splFoodItem_flow_text").disabled=true;
					}
					document.getElementById("chk_spl_"+encounterId).checked=false;
				}
			}
			if(dislikeJSONObj.items !=null) {
				if((parseInt(jsonPatientArr_Dislikes.length) ==1) && parseInt(dislikeJSONObj.items.length)!=0 ) {
					if(jsonPatientArr_Dislikes[0].patient.encounterId == encounterId) {
						alert("Food Dislikes are selected. Atleast one Food Dislikes Check box should be selected");
						document.getElementById("chk_dislike_"+encounterId).checked=true;
						return;
					}
				}
			}
			else {
				if(parseInt(jsonPatientArr_Dislikes.length) ==1) {
					if(jsonPatientArr_Dislikes[0].patient.encounterId == encounterId) {
						document.getElementById("foodItem_dislike_flow_text").disabled=true;
					}
					document.getElementById("chk_dislike_"+encounterId).checked=false;
				}
			}
			if(flag==true)			 return; 
			
			jsonPatientArr_Dislikes.splice(0,jsonPatientArr_Dislikes.length);
			
			for(var i=0;i<obj.length;i++) {
				var encId=obj[i].patient.encounterId;
				chk=document.getElementById("chk_dislike_"+encId);
				if(chk) {
					if(chk.checked==true) {
						jsonPatientArr_Dislikes.push({patient:obj[i].patient});
						document.getElementById("foodItem_dislike_flow_text").disabled=false;
						flag_dislike=true;
					}
					else {
						document.getElementById("chk_dislike_checkAll").checked=false;
					}			
				}
			}
			if (flag_dislike==false)  document.getElementById("foodItem_dislike_flow_text").disabled=true;
			
			jsonPatientArr_Spl.splice(0,jsonPatientArr_Spl.length)
			
			for(var i=0;i<obj.length;i++) {
				var encId=obj[i].patient.encounterId;
				chk=document.getElementById("chk_spl_"+encId);
				if(chk) {
					if(chk.checked==true) {
						jsonPatientArr_Spl.push({patient:obj[i].patient});
						document.getElementById("splFoodItem_flow_text").disabled=false;
						flag_spl=true;
					}
					else {
						document.getElementById("chk_spl_checkAll").checked=false;
					}			
				}
			}
		
			if (flag_spl==false)  document.getElementById("splFoodItem_flow_text").disabled=true;
			for(var i=0;i<obj.length;i++) {
				var testObj=new Object();
				testObj=obj[i];
				if(testObj.patient.encounterId==encounterId) {
					obj.splice(i,1);
				document.getElementById("delete"+encounterId).href="#";
				document.getElementById("patientRow"+encounterId).disabled=true;
			}
		}		
		}}
	
	//Added against MMS-KH-CRF-0029.1 Ends Here	
	
		function selectPatient() {
			
		}
		
	function deletePatient(encounterId) {
			obj=parent.patientsObj.patients;
			var flag=false;
			var flag_spl=false;
			var flag_dislike=false;
			
			if(obj.length==1) {
				alert(getMessage("DS_SEL_PAT","DS")); //"Atleast one patient should be selected";
				return;
			}
			document.getElementById("chk_spl_"+encounterId).checked=false; 
			document.getElementById("chk_dislike_"+encounterId).checked=false;
			//Added Against ML-MMOH-CRF-0672 starts Here 
			if(isLos_gt7 =="true" && isLos_gt7!="" && diffDays > 7 && diffDays!="")
			{
				var splimageobj=document.getElementById("spl_image"+encounterId);
			if(splimageobj != null && splimageobj != undefined && splimageobj !="" && splimageobj !="null" && splimageobj !="undefined")
				document.getElementById("spl_image"+encounterId).onmouseover=null;
			}
			//Added Against ML-MMOH-CRF-0672 Ends Here
			if(splJSONObj.items !=null) {
				if((parseInt(jsonPatientArr_Spl.length) ==1) && parseInt(splJSONObj.items.length)!=0 ) {
					if(jsonPatientArr_Spl[0].patient.encounterId == encounterId) {
						alert("Special Food Items is selected. Atleast one Special Food Item Check box should be selected");
						document.getElementById("chk_spl_"+encounterId).checked=true;
						flag=true;
					}
				}
			}
			else {
				if(parseInt(jsonPatientArr_Spl.length) ==1) {
					if(jsonPatientArr_Spl[0].patient.encounterId == encounterId) {
						document.getElementById("splFoodItem_flow_text").disabled=true;
					}
					document.getElementById("chk_spl_"+encounterId).checked=false;
				}
			}
			if(dislikeJSONObj.items !=null) {
				if((parseInt(jsonPatientArr_Dislikes.length) ==1) && parseInt(dislikeJSONObj.items.length)!=0 ) {
					if(jsonPatientArr_Dislikes[0].patient.encounterId == encounterId) {
						alert("Food Dislikes are selected. Atleast one Food Dislikes Check box should be selected");
						document.getElementById("chk_dislike_"+encounterId).checked=true;
						return;
					}
				}
			}
			else {
				if(parseInt(jsonPatientArr_Dislikes.length) ==1) {
					if(jsonPatientArr_Dislikes[0].patient.encounterId == encounterId) {
						document.getElementById("foodItem_dislike_flow_text").disabled=true;
					}
					document.getElementById("chk_dislike_"+encounterId).checked=false;
				}
			}
			if(flag==true)			 return; 
			
			jsonPatientArr_Dislikes.splice(0,jsonPatientArr_Dislikes.length);
			
			for(var i=0;i<obj.length;i++) {
				var encId=obj[i].patient.encounterId;
				chk=document.getElementById("chk_dislike_"+encId);
				if(chk) {
					if(chk.checked==true) {
						jsonPatientArr_Dislikes.push({patient:obj[i].patient});
						document.getElementById("foodItem_dislike_flow_text").disabled=false;
						flag_dislike=true;
					}
					else {
						document.getElementById("chk_dislike_checkAll").checked=false;
					}			
				}
			}
			if (flag_dislike==false)  document.getElementById("foodItem_dislike_flow_text").disabled=true;
			
			jsonPatientArr_Spl.splice(0,jsonPatientArr_Spl.length)
			
			for(var i=0;i<obj.length;i++) {
				var encId=obj[i].patient.encounterId;
				chk=document.getElementById("chk_spl_"+encId);
				if(chk) {
					if(chk.checked==true) {
						jsonPatientArr_Spl.push({patient:obj[i].patient});
						document.getElementById("splFoodItem_flow_text").disabled=false;
						flag_spl=true;
					}
					else {
						document.getElementById("chk_spl_checkAll").checked=false;
					}			
				}
			}
			
			if (flag_spl==false)  document.getElementById("splFoodItem_flow_text").disabled=true;
			
			for(var i=0;i<obj.length;i++) {
				var testObj=new Object();
				testObj=obj[i];
				if(testObj.patient.encounterId==encounterId) {
					obj.splice(i,1);
				document.getElementById("delete"+encounterId).href="#";
				document.getElementById("patientRow"+encounterId).disabled=true;
			}
		}		
	}
	
//Added against MMS-KH-CRF-0029.1 Starts Here	
var remarks = "";
async function Remarks1(obj){	
	var remarkHdr = "";
	if(document.getElementById("rem_"+obj).value != "null" &&  document.getElementById("rem_"+obj).value != "" && remarks == ""){
		remarkHdr = document.getElementById("rem_"+obj).value;
	}
	if(remarks != null || remarks == undefined){
		if(remarkHdr != ""){
		 remarks = document.getElementById("rem_"+obj).value;
		}
		else{
		 remarkHdr = document.getElementById("rem_"+obj).value;
		}
	}
	else{
		remarkHdr = "";
	}
	var dialogUrl1 = "../../eDS/jsp/Remarks.jsp?&remarkHdr="+encodeURIComponent(document.getElementById("rem_"+obj).value);
	var dialogArguments = remarks;
	var dialogFeatures = "dialogHeight:13;dialogWidth:28;status:no;scroll:yes";
	returnRemarks = await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
	if(returnRemarks != null){
		document.getElementById("rem_"+obj).value = returnRemarks;
		document.getElementById("MenuImage"+obj).style.visibility = 'hidden';
	}
	if(returnRemarks == undefined){
		returnRemarks = dialogArguments;
	}
} 

//Added against MMS-KH-CRF-0029.1 Ends Here	
</script>
</html>

