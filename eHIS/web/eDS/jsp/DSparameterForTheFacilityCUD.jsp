<!DOCTYPE html>
<%@ page import="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.util.ArrayList" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<html>
<head>
<%
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
	.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
	:"IeStyle.css" ;
	if(sStyle==null)sStyle="IeStyle.css";
	String facility_id	= (String)session.getAttribute("facility_id");
	String locale = (String) session.getAttribute("LOCALE");
	String generateDefaultDiet="",labelForDefaultDiet="",labelMessage="",blInterface="",inventoryInterface="",inventoryStoreCode="",multiKitchen="",kitchenCode="",chargeStdService="",dialyDietOrders="",maxMealPlanCreateDays="",trackMenuValidity="",mealPlanNextSeq="",acceptDietForMeal="",enableRDAAlert="",attendantOrderApplicable="",cutOffTimeForLiquidFood="",gracePeriod="",gracePeriodApplicable="", multifacility="";
	//ML-MMOH-CRF-0427
	String RestrictDateRangeforInpatients ="";
	String MaximumDaysAllowed_Value ="";
	//ML-MMOH-CRF-0427
	String GenerateNilByMouth="";//MMS-CRF-78.1
	String NotificationMessageforPlaceDietOrder="",RestrictMealServingStartTime="",LATE_IRREGULAR_DIET_ORD_FOR_IP="";//ML-MMOH-CRF-0409
	String Attendent_Label_Name="";//ML-MMOH-CRF-0406
	String No_Of_Attendant="";//ML-MMOH-CRF-0412
	//ML-MMOH-CRF-0600
	String op_em_served="",op_em_accept="",op_em_allow="";
	String ip_MealPrepared="",ip_MealReceived="",ip_MealServed="",ip_allow="";
	//ML-MMOH-CRF-0600
	//ML-MMOH-CRF-0825
	String LATE_IRREGULAR_DIET_ORD_FOR_OP="",LATE_IRREGULAR_DIET_ORD_FOR_EM="",LATE_IRREGULAR_DIET_ORD_FOR_ST="",LATE_IRREGULAR_DIET_ORD_FOR_SP="";
	//ML-MMOH-CRF-0825
	String enableDrugFoodYN="";//MMS-KH-CRF-0029.1-US008
	Connection con=null;
	con=ConnectionManager.getConnection(request);
	
	//Added by Santhosh for ML-MMOH-CRF-1961
	Boolean InstructionInLabelFormulaAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "DS","LABEL_STICKER_FORMULA");	
	String InstructionInLabelFormula = "";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eDS/js/DSparameterForTheFacility.js"></script>
	<script language="javascript" src="../../eDS/js/DSCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	<script>

	var nextMealPlanSeq;
	function getNextMealPlan(){
		nextMealPlanSeq=document.getElementById("mealPlanNextSeq").value;
	}
	function enabledField(){
		if(document.getElementById("gracePeriodApplicableYn").checked ==  true){
			document.getElementById("gracePeriod").disabled = false;
			document.getElementById("grace_image").style.visibility = "visible";
		}else{
			document.getElementById("gracePeriod").disabled = true;
			document.getElementById("grace_image").style.visibility = 'hidden';
			document.getElementById("gracePeriod").value = "";
		}
	}
	</script>
	</head>
	<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" Onload = "CheckAllow()"><!--CRF-600-->
	<br>
	<form target="messageFrame" name="DSparameterForTheFacilityForm" id="DSparameterForTheFacilityForm">
	<input type="hidden" name="mode" id="mode" value="insert"/>
<%
	PreparedStatement stmt=null,stmtParam=null;
	ResultSet rs=null,rsParam=null;
	String sql = "",sqlParam="";

	try
	  {
		con=ConnectionManager.getConnection(request);
		
		sqlParam= "SELECT OPERATING_FACILITY_ID, GENERATE_DEFAULT_DIET_YN, LABEL_FOR_DEFAULT_DIET_YN, LABEL_MESSAGE, BL_INTERFACE_YN, INVENTORY_INTERFACE_YN, INVENTORY_STORE_CODE, MULTI_KITCHEN_YN, KITCHEN_CODE, CHARGE_STD_SERVICE_YN, DAILY_DIET_ORDERS_YN, MAX_MEAL_PLAN_CREAT_DAYS, TRACK_MENU_VALIDITY_YN, MEAL_PLAN_NEXT_SEQ, ACCEPT_DIET_FOR_IND_MEAL_YN, ENABLE_RDA_ALERT_YN, ATTENDANT_ORDER_APPLICABLE_YN, CUTOFF_TIME_FOR_ACK_LIQFOOD,GRACE_PERIOD, GRACE_PERIOD_APPLICABLE_YN, MULTIFACILITY_YN, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO,Restrict_Date_Inpatients_YN,MAXIMUM_DAYS_ALLOWED,GEN_MEALPLAN_FOR_NBM_PAT_YN,RESTRICT_MEAL_SERVING_ST_TIME,IRREGULAR_MEAL_ORD_MESSAGE,LATE_IRREGULAR_DIET_ORD_FOR_IP,Attendent_Label_Name,No_Of_Attendant,OP_EM_SERVED_YN,OP_EM_ACCEPT_YN,ALLOW_PLACE_ORD_OP_EM,IP_MEALPREPARED_YN,IP_MEALRECEIVED_YN,IP_MEALSERVED_YN,ALLOW_PLACE_ORD_IP,LATE_IRREGULAR_DIET_ORD_FOR_OP,LATE_IRREGULAR_DIET_ORD_FOR_EM,LATE_IRREGULAR_DIET_ORD_FOR_ST,LATE_IRREGULAR_DIET_ORD_FOR_SP, ENABLE_DRUG_FOOD_YN, INSTRUCTION_IN_LABEL FROM DS_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID=?";//MMS-CRF-78.1 //ML-MMOH-CRF-0409 AND ML-MMOH-CRF-0406 and ML-MMOH-CRF-0412 & CRF-600 & CRF-0825 & MMS-KH-CRF-0029.1-US008

		stmtParam=con.prepareStatement(sqlParam);
		stmtParam.setString(1,facility_id);
		rsParam=stmtParam.executeQuery();

		if(rsParam !=null)
		{
		while(rsParam.next())
		{ %>
		<script>
		document.getElementById("mode").value="modify";
		</script>

	<%
		generateDefaultDiet=rsParam.getString(2);
		labelForDefaultDiet=rsParam.getString(3);
		if(rsParam.getString(4) == null){
			labelMessage = "";
		}else{
			labelMessage=rsParam.getString(4);	
		}
		blInterface=rsParam.getString(5);
		inventoryInterface=rsParam.getString(6);
		inventoryStoreCode=rsParam.getString(7);
		if(rsParam.getString(8) == null){
			multiKitchen = "";
		}else{
			multiKitchen=rsParam.getString(8);	
		}
		if(rsParam.getString(9) == null){
			kitchenCode = "";
		}else{
			kitchenCode=rsParam.getString(9);
		}
		if(rsParam.getString(10) == null){
			chargeStdService = "";
		}else{
			chargeStdService=rsParam.getString(10);
		}
		if(rsParam.getString(11) == null){
			dialyDietOrders = "";
		}else{
			dialyDietOrders=rsParam.getString(11);
		}
		if(rsParam.getString(12) == null){
			maxMealPlanCreateDays = "";
		}else{
			maxMealPlanCreateDays=rsParam.getString(12);
		}

		trackMenuValidity=rsParam.getString(13);
		mealPlanNextSeq=rsParam.getString(14);
		acceptDietForMeal=rsParam.getString(15);
		enableRDAAlert=rsParam.getString(16);
		attendantOrderApplicable=rsParam.getString(17);
		if(rsParam.getString(18) == null){
			cutOffTimeForLiquidFood = "";
		}else{
			cutOffTimeForLiquidFood=rsParam.getString(18);
		}
		if(rsParam.getString(19) == null){
			gracePeriod = "";
		}else{
			gracePeriod = rsParam.getString(19);
		}
		if(rsParam.getString(20) == null){
			gracePeriodApplicable = "";
		}else{
			 gracePeriodApplicable = rsParam.getString(20);
		}

		//CRF-230 changes - Added for enabling Multifacility in Place OP order screen based on the inputs
		if(rsParam.getString("MULTIFACILITY_YN") == null){
			multifacility = "N";
		}else{
			 multifacility = rsParam.getString("MULTIFACILITY_YN");
		}
		//0427 starts
		if(rsParam.getString("Restrict_Date_Inpatients_YN")==null){
			//RestrictDateRangeforInpatients="N";
			RestrictDateRangeforInpatients="Y";
			//RestrictDateRangeforInpatients="";
		}else{
			RestrictDateRangeforInpatients=rsParam.getString("Restrict_Date_Inpatients_YN");
		}

		if(rsParam.getString("MAXIMUM_DAYS_ALLOWED")==null){
			MaximumDaysAllowed_Value="";
		}else{
			MaximumDaysAllowed_Value=rsParam.getString("MAXIMUM_DAYS_ALLOWED");
		}

		//0427 ends
		//MMS-CRF-78.1 starts
		if(rsParam.getString("GEN_MEALPLAN_FOR_NBM_PAT_YN")==null){
			GenerateNilByMouth="N";
		}else{
			GenerateNilByMouth=rsParam.getString("GEN_MEALPLAN_FOR_NBM_PAT_YN");
		}
		//MMS-CRF-78.1 ends

		//Added Against MMS-KH-CRF-0029.1-US008
		if(rsParam.getString("ENABLE_DRUG_FOOD_YN") == null){
			enableDrugFoodYN = "N";
		}else{
			 enableDrugFoodYN = rsParam.getString("ENABLE_DRUG_FOOD_YN");
		}//Added Against MMS-KH-CRF-0029.1-US008

		//ML-MMOH-CRF-0409 Starts
		if(rsParam.getString("IRREGULAR_MEAL_ORD_MESSAGE")==null){
			NotificationMessageforPlaceDietOrder="";
		}
		else{
			NotificationMessageforPlaceDietOrder=rsParam.getString("IRREGULAR_MEAL_ORD_MESSAGE");
		}
		
		//Added by Santhosh for ML-MMOH-CRF-1961
		if(rsParam.getString("INSTRUCTION_IN_LABEL")==null){
			InstructionInLabelFormula="";
		}
		else{
			InstructionInLabelFormula=rsParam.getString("INSTRUCTION_IN_LABEL");
		}
		
		
			RestrictMealServingStartTime=rsParam.getString("RESTRICT_MEAL_SERVING_ST_TIME");
			LATE_IRREGULAR_DIET_ORD_FOR_IP=rsParam.getString("LATE_IRREGULAR_DIET_ORD_FOR_IP");
			//ML-MMOH-CRF-0409 Ends
			Attendent_Label_Name=rsParam.getString("Attendent_Label_Name");//ML-MMOH-CRF-0406
			No_Of_Attendant=rsParam.getString("No_Of_Attendant");//ML-MMOH-CRF-0412
			if(No_Of_Attendant==null)No_Of_Attendant="";//ML-MMOH-CRF-0412
			if(No_Of_Attendant.equals("0"))No_Of_Attendant="";//ML-MMOH-CRF-0412
			if(kitchenCode == null) kitchenCode="";

					//ML-MMOH-CRF-0600
					op_em_served=rsParam.getString("op_em_served_yn");
					if(op_em_served=="" || op_em_served==null){
						op_em_served="N";
					}
					op_em_accept=rsParam.getString("op_em_accept_yn");
					if(op_em_accept=="" || op_em_accept==null){
						op_em_accept="N";
					}
					op_em_allow=rsParam.getString("ALLOW_PLACE_ORD_OP_EM");
					if(op_em_allow=="" || op_em_allow==null){
						op_em_allow="N";
					}
					ip_MealPrepared=rsParam.getString("ip_MealPrepared_yn");
					if(ip_MealPrepared=="" || ip_MealPrepared==null){
						ip_MealPrepared="N";
					}
					ip_MealReceived=rsParam.getString("ip_MealReceived_yn");
					if(ip_MealReceived=="" || ip_MealReceived==null){
						ip_MealReceived="N";
					}
					ip_MealServed=rsParam.getString("ip_MealServed_yn");
					if(ip_MealServed=="" || ip_MealServed==null){
						ip_MealServed="N";
					}
					ip_allow=rsParam.getString("ALLOW_PLACE_ORD_IP");
					if(ip_allow=="" || ip_allow==null){
						ip_allow="N";
					}
					//ML-MMOH-CRF-0600

					//ML-MMOH-CRF-0825 Starts
					LATE_IRREGULAR_DIET_ORD_FOR_OP=rsParam.getString("LATE_IRREGULAR_DIET_ORD_FOR_OP");
					if(LATE_IRREGULAR_DIET_ORD_FOR_OP=="" || LATE_IRREGULAR_DIET_ORD_FOR_OP==null){
						LATE_IRREGULAR_DIET_ORD_FOR_OP="N";
					}
					LATE_IRREGULAR_DIET_ORD_FOR_EM=rsParam.getString("LATE_IRREGULAR_DIET_ORD_FOR_EM");
					if(LATE_IRREGULAR_DIET_ORD_FOR_EM=="" || LATE_IRREGULAR_DIET_ORD_FOR_EM==null){
						LATE_IRREGULAR_DIET_ORD_FOR_EM="N";
					}
					LATE_IRREGULAR_DIET_ORD_FOR_ST=rsParam.getString("LATE_IRREGULAR_DIET_ORD_FOR_ST");
					if(LATE_IRREGULAR_DIET_ORD_FOR_ST=="" || LATE_IRREGULAR_DIET_ORD_FOR_ST==null){
						LATE_IRREGULAR_DIET_ORD_FOR_ST="N";
					}
					LATE_IRREGULAR_DIET_ORD_FOR_SP=rsParam.getString("LATE_IRREGULAR_DIET_ORD_FOR_SP");
					if(LATE_IRREGULAR_DIET_ORD_FOR_SP=="" || LATE_IRREGULAR_DIET_ORD_FOR_SP==null){
						LATE_IRREGULAR_DIET_ORD_FOR_SP="N";
					}
					//ML-MMOH-CRF-0825 Ends
				}
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception==" + e);
		} finally {
			if (rsParam != null) rsParam.close();
			if (stmtParam != null) stmtParam.close();			
		}
	%>
<!-- Added Against ML-MMOH-CRF-1061 US2 Starts Here -->		
<%
	String ser_status_code="MS";
	String MP_status_code="MP";
	String MR_status_code="MR";
	String patient_class_OP="OP";
	String patient_class_IP="IP";
	String OPstatus_Ser_YN="";
	String IPstatus_Pre_YN="";
	String IPstatus_Rec_YN="";

	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rst=null;
	String sql_served = "",sql_MP="",sql_MR="";

	try
	{
		conn=ConnectionManager.getConnection(request);				
		sql_served ="select STATUS_ACT_YN from DS_MEAL_ACK_STATUS_MAST where status_code = '"+ser_status_code+"' and patient_class='"+patient_class_OP+"' ";

		pstmt=conn.prepareStatement(sql_served);
		rst=pstmt.executeQuery();	
		while (rst != null && rst.next()) {
		OPstatus_Ser_YN = checkForNull(rst.getString(1));
	}
				
	sql_MP ="select STATUS_ACT_YN from DS_MEAL_ACK_STATUS_MAST where status_code ='"+MP_status_code+"' and patient_class='"+patient_class_IP+"' ";
	pstmt=conn.prepareStatement(sql_MP);
	rst=pstmt.executeQuery();	
	while (rst != null && rst.next()) {
			IPstatus_Pre_YN = checkForNull(rst.getString(1));
	}
			
	sql_MR ="select STATUS_ACT_YN from DS_MEAL_ACK_STATUS_MAST where status_code ='"+MR_status_code+"' and patient_class='"+patient_class_IP+"' ";
	pstmt=conn.prepareStatement(sql_MR);
	rst=pstmt.executeQuery();	
	while (rst != null && rst.next()) {
			IPstatus_Rec_YN = checkForNull(rst.getString(1));
	}			
	}catch (Exception e) {
		e.printStackTrace();
		System.err.println("266 Exception==" + e);
	} finally {
		if (rst != null) rst.close();
		if (pstmt != null) pstmt.close();
		ConnectionManager.returnConnection(conn);
	}
%>	
<!-- Added Against ML-MMOH-CRF-1061 US2 Ends Here -->
		<table border='0' cellpadding='2' cellspacing='0' width='85%' align='center'>		
			<tr>
				<td class='label' align="left">
					<fmt:message key="eOT.DefaultDietForPatientsWoOrders.Label" bundle="${ot_labels}" />
				</td>
				<td width="12%">
					<input type="checkbox" name="generateDefaultDietYn" id="generateDefaultDietYn" value="Y" />
				</td>
				
				<td width="27%" align="left" class='label'>
					<fmt:message key="eOT.Labelmessage.Label" bundle="${ot_labels}" />
				</td>
				<td width="19%" class='label' align="left">
					<input type="text" name="labelMessage" id="labelMessage" maxlength='30' size='20'/><!-- EMR-4000 -->
				</td>
			</tr>

			<tr>
				<td class='label' align="left">
					<fmt:message
						key="eOT.MultiKitchen.Label" bundle="${ot_labels}" />
				</td>
				<td>
					<input type="checkbox" name="multiKitchenYn" id="multiKitchenYn" value="Y"  onclick="enableKitchen();" />
				</td>
				<td class='label' align="left">
					<fmt:message
						key="eOT.KitchenCode.Label" bundle="${ot_labels}" />
				</td>
				<td class='label' align="left">
					<select name="kitchenCode" id="kitchenCode">
					<option value="">
						<fmt:message key="eOT.select.Label" bundle="${ot_labels}" />
					</option>
					<%
					try {sql= "SELECT KITCHEN_CODE, SHORT_DESC FROM DS_KITCHENS_LANG_VW WHERE (OPERATING_FACILITY_ID LIKE ? )AND(LANGUAGE_ID=? )AND(EFF_STATUS='E' ) ORDER BY  2 , 1";

							stmt=con.prepareStatement(sql);

							stmt.setString(1,facility_id);
							stmt.setString(2,locale);

							rs=stmt.executeQuery();

							if(rs!=null)
							{
							   while(rs.next())
									{
										String kitchen_code=rs.getString(1);
										String kitchen_desc=rs.getString(2);
										System.out.println("kitchenCode"+kitchenCode+"****");
										System.out.println("kitchen_code"+kitchen_code+"****");
										if(kitchenCode.equals(kitchen_code)) {System.out.println("I am in if condition"+kitchen_code+"****");
									%>
									<option value="<%=kitchen_code%>"  selected><%=kitchen_desc%>
									<% }
									   else {
									%>
									<option value="<%=kitchen_code%>"><%=kitchen_desc%>
								<% }
									}
						  }
						}
					 catch (Exception e) {
								e.printStackTrace();
								System.err.println("Exception==" + e);
							} finally {
								if (rs != null)	rs.close();
								if (rsParam != null) rsParam.close();
								if (stmt != null) stmt.close();
								if (stmtParam != null) stmtParam.close();
								if (con != null)
									ConnectionManager.returnConnection(con, request);
							}
							%>
					</option>
					</option>
					</select>
				</td>
			</tr>

			<tr>
				<td class='label' align="left">
					<fmt:message
						key="eOT.MaxMealPlanAllowed.Label" bundle="${ot_labels}" />
				</td>
				<td>
					<input type="text" name="maxMealPlanCreatDays" id="maxMealPlanCreatDays" maxlength="2" size="2" onkeypress="return checkNumber();"  />
				</td>
				<td class='label' align="left">
					<fmt:message key="eOT.NextMealPlanNo.Label" bundle="${ot_labels}" />
				</td>
				<td class='label' align="left">
					<input type="text" name="mealPlanNextSeq" id="mealPlanNextSeq" maxlength="10" size="2" onkeypress="checkNumber()"/>
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
			</tr>

			<tr>
				<td class='label' align="left">
					<fmt:message key="eOT.AcceptDietTypeForMealType.Label" bundle="${ot_labels}" />
				</td>
				<td>
					<input type="checkbox" name="acceptDietForIndMealYn" id="acceptDietForIndMealYn" id="acceptDietForIndMealYn" value="Y" onclick="chkBoxValue(this);" /><!--ML-MMOH-CRF-0409-->					
				</td>
				<td  class='label' align="left">
					<fmt:message key="eOT.InterfacePatBilling.Label" bundle="${ot_labels}" />
				</td>
				<td>
					<input type="checkbox" name="blInterfaceYn" id="blInterfaceYn" value="Y" />
				</td>
			</tr>

			<tr>
				<td  class='label' align="left" >					
					<%=Attendent_Label_Name%><fmt:message key="eDS.OrdersAppl.Label" bundle="${ds_labels}" /><!--ML-MMOH-CRF-406-->
				</td>
				<td>
					<input type="checkbox" name="attendantOrderApplicableYn" id="attendantOrderApplicableYn" value="Y" onclick="chkBoxValue(this);"/><!--ML-MMOH-CRF-406-->
				
				</td>
				<!--ML-MMOH-CRF-412 STARTS-->
				<%
				String MaxAttendant= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.MaxAttendant.Label","ds_labels");
				MaxAttendant=MaxAttendant.replace("#",Attendent_Label_Name);
				%>
				<td class='label' align="left">
					<%=MaxAttendant%>
				</td>
				<td class='label' align="left">
					<input type="text" name="attendantcount" id="attendantcount" id="attendantcount" size="1" maxlength="1" onkeypress="checkDigit();restrictSpecialChars(event)"  disabled=true><!-- 059955 -->
					<img id="attendant_count_check" src='../../eCommon/images/mandatory.gif' style='visibility:hidden'></img>
				</td>				
			</tr>

			<tr>
				<td class='label' align="left">
					<fmt:message key="eOT.GracePeriodApplicable.Label" bundle="${ot_labels}" />
				</td>
				<td>
					<input type="checkbox" name="gracePeriodApplicableYn" id="gracePeriodApplicableYn" value="Y" onclick="enabledField();"/>
				</td>
				<td  class='label' align="left" >
					<fmt:message key="eOT.gracePeriod.Label" bundle="${ot_labels}" />
				</td>
				<td class='label' align="left">
					<input type="text" name="gracePeriod" id="gracePeriod" maxlength="2" size="2" onkeypress="gracePeriodCheck()"/>
					<fmt:message key="eOT.Hours.Label" bundle="${ot_labels}" />
					<img id="grace_image" src='../../eCommon/images/mandatory.gif' style='visibility:hidden'>
					<script type="text/javascript">
					if(document.getElementById("gracePeriodApplicableYn").checked ==  false){
						document.getElementById("gracePeriod").disabled = true;
					}
					</script>
				</td>					
			</tr>

	<!-- ML-MMOH-CRF-0427 Starts -->
			<input type="checkbox" name="RestrictDateRangeforInpatientsYN" id="RestrictDateRangeforInpatientsYN" id="RestrictDateRangeforInpatientsYN" value="Y" onclick="chkBoxValue(this);" style='visibility:hidden'/>
			<tr>
				<td  class='label' align="left" >
					<fmt:message key="eDS.MaximumDaysAllowed.Label" bundle="${ds_labels}" />
					
				</td>
				<td class='label' align="left">
					<input type="text" name="MaximumDaysAllowed" id="MaximumDaysAllowed" id="MaximumDaysAllowed" maxlength="3" size="1" onkeypress="checkDigit()"/>		
					<fmt:message key="Common.days.label" bundle="${common_labels}" />
					<img id="count_check" src='../../eCommon/images/mandatory.gif'></img>
					<script type="text/javascript">
					if(document.getElementById("RestrictDateRangeforInpatientsYN").checked ==  false){
						document.getElementById("MaximumDaysAllowed").disabled = true;
					}
					</script>
				</td>		
				<!--ML-MMOH-CRF-0406 STARTS-->
				<td class='label' align="left">
				<fmt:message key="eDS.PatientCareTakerLabel.Label" bundle="${ds_labels}" />
				</td>				
				<td>
					<input type="text" name="Attendent_Label_Name" id="Attendent_Label_Name" id="Attendent_Label_Name" value="" maxlength="30" onkeypress="restrictSpecialChars(event)" size="18">
					<img src='../../eCommon/images/mandatory.gif'>
				</td>				
				<!--ML-MMOH-CRF-0406 ENDS-->
			</tr>
	<!-- ML-MMOH-CRF-0427 Ends -->

			<!-- CRF-230 changes - Added for enabling Multifacility in Place OP order screen based on the inputs-->
			<tr>
			  <td class='label' align="left"><fmt:message key="eOT.MultiFacilityOP.Label" bundle="${ot_labels}" /></td>
			  <td><input type="checkbox" name="multiFacilityOPyn" id="multiFacilityOPyn"/></td>
			  <!--ML-MMOH-CRF-0412-->
			  <td  class='label' align="left" ><fmt:message key="eOT.CutOffTimeToAckFreq.Label" bundle="${ot_labels}" /></td>
			  <td class='label' align="left"><input type="text" name="cutoffTimeforFreqBased" id="cutoffTimeforFreqBased" maxlength="2" size="2" onkeypress="checkNumber()"/>
			    <fmt:message key="eOT.Hours.Label" bundle="${ot_labels}" /></td>
			  <!--ML-MMOH-CRF-0412-->
		  </tr>
			<tr>
				<!-- MMS-KH-CRF-29.1 Starts -->
			  <td class='label' align="left"><fmt:message key="eDS.EnableDrugFoodYN.Label" bundle="${ds_labels}" /></td>
			  <td><input type="checkbox" id="enableDrugFoodYN" name="enableDrugFoodYN" id="enableDrugFoodYN"/></td>
			  <!-- MMS-KH-CRF-29.1 Ends -->
			  <td class='label' align="left"><fmt:message key="eDS.NotificationMessageforPlaceDietOrder.Label" bundle="${ds_labels}" /></td>
			  <td class='label' align="left"><input type="text" name="NotificationMessageforPlaceDietOrder" id="NotificationMessageforPlaceDietOrder" id="NotificationMessageforPlaceDietOrder" value="" onkeypress="restrictSpecialChars(event)" maxlength="150" size="18" disabled="true">
			    <!--IN059007 --></td>
		  </tr>

          <tr>
			<td></td>
			<td></td>
			<!-- Added by Santhosh for ML-MMOH-CRF-1961-->
			<%if(InstructionInLabelFormulaAppl){ %>
			<td class='label' align="left"><fmt:message key="eDS.InstructionInLabelFormula.Label" bundle="${ds_labels}" /></td>
			  <td class='label' align="left"><input type="text" name="InstructionInLabelFormula" id="InstructionInLabelFormula" value="" maxlength="50" size="18">
			    </td>
			<%}%>
				<!--END -->
		  </tr>
	

		<!--ML-MMOH-CRF-0409 Starts-->						
		
			<!--ML-MMOH-CRF-409 ENDS-->
			<!-- ML-MMOH-CRF-0600 Starts --> 
			<tr>
			<td colspan="2" align="left" valign="top" class="BORDER"><table border='0' cellpadding=3  cellspacing='0' width='100%'>
				
				<tr>
					<td  colspan="2" class="COLUMNHEADERCENTER">
                 
						<fmt:message key="eDS.AllowPlaceDietOrderforOP/EM.Label" bundle="${ds_labels}"/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" id="allow_op_em_yn" name="allow_op_em_yn" id="allow_op_em_yn" value="Y" onclick ="chkBoxValue(this);" />
						
					</td>
                 
				</tr>
			  <tr>
				<td width="70%" class="label"><fmt:message key="eDS.served.Label" bundle="${ds_labels}"/>
				  <input type="checkbox" id="op_served_yn" name="op_served_yn" id="op_served_yn" value="Y" onclick="chkBoxValue(this);" /></td>
				<td width="30%" class="label"><fmt:message key="eDS.accept.Label" bundle="${ds_labels}"/>
				  <input type="checkbox"  id="op_accept_yn" name="op_accept_yn" id="op_accept_yn" value="Y" onclick="chkBoxValue(this);" /></td>
			  </tr>
			  </table>
              		  </td>
				<td colspan="2" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
				  <tr>
				    <td align="left" valign="top"><table border='0' cellpadding=3  cellspacing='0' width='100%'>
				      <tr>
				        <td class="COLUMNHEADERCENTER">&nbsp;
				          <fmt:message key="eDS.ServingLateTime.Label" bundle="${ds_labels}"/>
				          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			          </tr>
			        </table></td>
			      </tr>
				  <tr>
				    <td align="left" valign="top"><table border='0' cellpadding=3  cellspacing='0' width='100%'>
				      <tr>
				        <td width="25%" class="label"><fmt:message key="Common.Inpatients.label" bundle="${common_labels}"/>
				          <input type="checkbox" id="LATE_IRREGULAR_DIET_ORD_FOR_IP" name="LATE_IRREGULAR_DIET_ORD_FOR_IP" id="LATE_IRREGULAR_DIET_ORD_FOR_IP" value="Y" onclick="chkBoxValue(this);" /></td>
				        <td width="25%" class="label"><fmt:message key="Common.Outpatients.label" bundle="${common_labels}"/>
				          <input type="checkbox" id="LATE_IRREGULAR_DIET_ORD_FOR_OP" name="LATE_IRREGULAR_DIET_ORD_FOR_OP" id="LATE_IRREGULAR_DIET_ORD_FOR_OP" value="Y" onclick="chkBoxValue(this);" /></td>
				        <td width="25%" class="label"><fmt:message key="eDS.EmergencyPatients.Label" bundle="${ds_labels}"/>
				          <input type="checkbox" id="LATE_IRREGULAR_DIET_ORD_FOR_EM" name="LATE_IRREGULAR_DIET_ORD_FOR_EM" id="LATE_IRREGULAR_DIET_ORD_FOR_EM" value="Y" onclick="chkBoxValue(this);" /></td>
			          </tr>
				      <tr>
				        <td width="25%" class="label"><fmt:message key="eDS.StaffOrders.Label" bundle="${ds_labels}"/>
				          <input type="checkbox" id="LATE_IRREGULAR_DIET_ORD_FOR_ST" name="LATE_IRREGULAR_DIET_ORD_FOR_ST" id="LATE_IRREGULAR_DIET_ORD_FOR_ST" value="Y" onclick="chkBoxValue(this);" /></td>
				        <td width="25%" class="label"><fmt:message key="eDS.SupplementaryOrders.Label" bundle="${ds_labels}"/>
				          <input type="checkbox" id="LATE_IRREGULAR_DIET_ORD_FOR_SP" name="LATE_IRREGULAR_DIET_ORD_FOR_SP" id="LATE_IRREGULAR_DIET_ORD_FOR_SP" value="Y" onclick="chkBoxValue(this);" /></td>
			          </tr>
			        </table></td>
			      </tr>
			    </table></td>
			</tr>

			<tr>
			  <td colspan="2" align="center" valign="top" class="BORDER"><table border='0' cellpadding=3  cellspacing='0' width='100%'>
				<tr>
				  <td class="COLUMNHEADERCENTER"><b>
					<fmt:message key="eDS.AllowPlaceDietOrderforIP.Label" bundle="${ds_labels}"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="checkbox" id="allow_ip_yn" name="allow_ip_yn" id="allow_ip_yn" value="Y" onclick ="chkBoxValue(this);" />
					</b></td>
				</tr>

				<tr>
				  <td width="100%" class="BORDERX"><table border='0' cellpadding=3  cellspacing='0' width='100%'>
					<tr>
					  <td width="33%" class="label"><fmt:message key="eOT.MealPrepared.Label" bundle="${ot_labels}"/>
						<input type="checkbox" id="ip_MealPrepared_yn" name="ip_MealPrepared_yn" id="ip_MealPrepared_yn" value="Y" onclick="chkBoxValue(this);" /></td>
					  <td width="33%" class="label"><fmt:message key="eOT.MealReceived.Label" bundle="${ot_labels}"/>
						<input type="checkbox" id="ip_MealReceived_yn" name="ip_MealReceived_yn" id="ip_MealReceived_yn" value="Y" onclick="chkBoxValue(this);" /></td>
					  <td width="34%" class="label"><fmt:message key="eOT.MealServed.Label" bundle="${ot_labels}"/>
						<input type="checkbox" id="ip_MealServed_yn" name="ip_MealServed_yn" id="ip_MealServed_yn" value="Y" onclick="chkBoxValue(this);" /></td>
					</tr>
					</table>
			  </table></td>
			  <td colspan="2">&nbsp;</td>
		  </tr>

		  <tr>
			<td colspan="2" class="BORDER">&nbsp;</td>
				  <td>&nbsp;
				</td>
				  <td>&nbsp;
				</td>
				 
			</tr>
			<!-- ML-MMOH-CRF-0600 ENDS -->

			<!-- ML-MMOH-CRF-0825 STARTS -->
			<tr>
			<td class="BORDER">&nbsp;</td>
				 <td>&nbsp;
				</td>
				  <td>&nbsp;
				</td>
				  <td>&nbsp;
				</td>
			</tr>
			<tr>
				<td width="42%" class="BORDERX">&nbsp;</td>
				 <td>&nbsp;
				</td>
				  <td>&nbsp;
				</td>
				  <td>&nbsp;
				</td>
			</tr>				
				<!-- ML-MMOH-CRF-0825 ENDS -->
				<script type="text/javascript">
				populateFields();
				function populateFields() {
					document.getElementById("mealPlanNextSeq").value="<%=mealPlanNextSeq%>";
					document.getElementById("maxMealPlanCreatDays").value="<%=maxMealPlanCreateDays%>";
					document.getElementById("cutoffTimeforFreqBased").value="<%=cutOffTimeForLiquidFood%>";
					document.getElementById("labelMessage").value="<%=labelMessage%>";
					document.getElementById("gracePeriod").value="<%=gracePeriod%>";
					document.getElementById("multiFacilityOPyn").value="<%=multifacility%>";
					document.getElementById("MaximumDaysAllowed").value="<%=MaximumDaysAllowed_Value%>";
					// <!--427 crf-->
					// <!--document.getElementById("GenerateNilByMouth_YN").value="<%=GenerateNilByMouth%>";
					// <!--MMS-CRF-78.1--><!--Commented for 409 CRF-->
					document.getElementById("enableDrugFoodYN").value="<%=enableDrugFoodYN%>";
					// <!-- MMS-KH-CRF-0029.1 -->
					document.getElementById("NotificationMessageforPlaceDietOrder").value="<%=NotificationMessageforPlaceDietOrder%>"; //<!--ML-MMOH-CRF-0409-->
					document.getElementById("Attendent_Label_Name").value="<%=Attendent_Label_Name%>";
					// <!--ML-MMOH-CRF-0406-->
					document.getElementById("attendantcount").value="<%=No_Of_Attendant%>";
					// <!--ML-MMOH-CRF-0412-->
					if(document.getElementById('InstructionInLabelFormula'))
						document.getElementById('InstructionInLabelFormula').value="<%=InstructionInLabelFormula%>" ; // <!-- Added by Santhosh for ML-MMOH-CRF-1961 -->
				}
				</script>
				<%if(generateDefaultDiet.equals("Y"))%>
					<script type="text/javascript">
					document.getElementById("generateDefaultDietYn").checked=true
					</script>
				<%if(multiKitchen.equals("Y"))%><script type="text/javascript">document.getElementById("multiKitchenYn").checked=true;document.getElementById("multiKitchenYn").disabled=false;</script>

				<%if(acceptDietForMeal.equals("Y"))%>
					<script type="text/javascript">
						document.getElementById("acceptDietForIndMealYn").checked=true;
						//document.getElementById("LATE_IRREGULAR_DIET_ORD_FOR_IP").disabled=false;
					</script><!--ML-MMOH-CRF-0409-->
				<%if(blInterface.equals("Y"))%><script type="text/javascript">document.getElementById("blInterfaceYn").checked=true</script>
				<%if(attendantOrderApplicable.equals("Y"))%><script type="text/javascript">document.getElementById("attendantOrderApplicableYn").checked=true;document.getElementById("attendantcount").disabled=false;document.getElementById('attendant_count_check').style.visibility='visible';</script><!--ML-MMOH-CRF-0412-->
				<%if(gracePeriodApplicable.equals("Y"))%><script type="text/javascript">document.getElementById("gracePeriodApplicableYn").checked=true;document.getElementById("gracePeriodApplicableYn").disabled=true;document.getElementById("gracePeriod").disabled = true;document.getElementById("grace_image").style.visibility = "visible";</script>
				<%if(multifacility.equals("Y"))%><script type="text/javascript">document.getElementById("multiFacilityOPyn").checked=true;</script>
				<!-- MMS-KH-CRF-29.1 -->
				
				<%if(RestrictDateRangeforInpatients.equals("Y"))%><script type="text/javascript">document.getElementById("RestrictDateRangeforInpatientsYN").checked=true;document.getElementById('count_check').style.visibility='visible';document.getElementById("MaximumDaysAllowed").disabled = false;</script><!-- ML-MMOH-CRF-0427 -->
				
				<%if(RestrictDateRangeforInpatients.equals("N"))%><script type="text/javascript">document.getElementById("RestrictDateRangeforInpatientsYN").checked=false;document.getElementById('count_check').style.visibility='hidden';document.getElementById("MaximumDaysAllowed").disabled = true;</script><!-- ML-MMOH-CRF-0427 -->
				
				<!-- MMS-KH-CRF-29.1 Starts -->
				<%if(enableDrugFoodYN.equals("Y"))%>
				<script type="text/javascript">document.getElementById("enableDrugFoodYN").checked=true;
				</script>
				<!-- MMS-KH-CRF-29.1 ends -->
				
				<!--%if(GenerateNilByMouth.equals("Y"))%--><!--<script type="text/javascript">document.getElementById("GenerateNilByMouth_YN").checked=true;document.getElementById("GenerateNilByMouth_YN").disabled=true;</script>--><!--MMS-CRF-78.1--><!--Commented for 409 CRF-->
				<!--ML-MMOH-CRF-0409 Starts-->
				<%if(LATE_IRREGULAR_DIET_ORD_FOR_IP.equals("Y") && acceptDietForMeal.equals("Y"))%>
				<script type="text/javascript">
					document.getElementById("NotificationMessageforPlaceDietOrder").disabled=false;
				</script>							
				<!--ML-MMOH-CRF-0409 Ends-->

				<!--ML-MMOH-CRF-0600 Starts-->
				<%if(op_em_allow.equals("Y"))%>
				<script type="text/javascript">
				document.getElementById("allow_op_em_yn").checked=true;
				</script>
				<%if(op_em_served.equals("Y"))%>
					<script type="text/javascript">
					document.getElementById("op_served_yn").checked=true;
					</script>
				<%if(op_em_accept.equals("Y"))%>
					<script type="text/javascript">
					document.getElementById("op_accept_yn").checked=true;
					</script>
				
				<%if(ip_MealPrepared.equals("Y"))%>
					<script type="text/javascript">
					document.getElementById("ip_MealPrepared_yn").checked=true;
					</script>
				<%if(ip_MealReceived.equals("Y"))%>
					<script type="text/javascript">
					document.getElementById("ip_MealReceived_yn").checked=true;
					</script>
				<%if(ip_MealServed.equals("Y"))%>
					<script type="text/javascript">
					document.getElementById("ip_MealServed_yn").checked=true;
					</script>
			    <%if(ip_allow.equals("Y")){%>
					<script type="text/javascript">
					document.getElementById("allow_ip_yn").checked=true;
					</script>	
				<%}%>
				<!--ML-MMOH-CRF-0600 Ends-->
				<!--ML-MMOH-CRF-0825 Starts-->
				<%if(LATE_IRREGULAR_DIET_ORD_FOR_IP.equals("Y"))%>
				<script type="text/javascript">
					document.getElementById("LATE_IRREGULAR_DIET_ORD_FOR_IP").checked=true;
				</script>
				<%if(LATE_IRREGULAR_DIET_ORD_FOR_OP.equals("Y"))%>
					<script type="text/javascript">
					document.getElementById("LATE_IRREGULAR_DIET_ORD_FOR_OP").checked=true;
					</script>
				<%if(LATE_IRREGULAR_DIET_ORD_FOR_EM.equals("Y"))%>
					<script type="text/javascript">
					document.getElementById("LATE_IRREGULAR_DIET_ORD_FOR_EM").checked=true;
					</script>
				<%if(LATE_IRREGULAR_DIET_ORD_FOR_ST.equals("Y"))%>
					<script type="text/javascript">
					document.getElementById("LATE_IRREGULAR_DIET_ORD_FOR_ST").checked=true;
					</script>
				<%if(LATE_IRREGULAR_DIET_ORD_FOR_SP.equals("Y"))%>
					<script type="text/javascript">
					document.getElementById("LATE_IRREGULAR_DIET_ORD_FOR_SP").checked=true;
					</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



				<!--ML-MMOH-CRF-0825 Ends-->
			</table>			
			
<%-- 			<ibaHTML:hidden property="method" /> --%>
			<input type="hidden" name="function_id" id="function_id" value="DS_PARAM_FOR_FACILITY"/>
			<input type="hidden" name="moduleId" id="moduleId" value="DS"/>
			<input type="hidden" name="facilityId" id="facilityId" value="<%=facility_id%>"/>
			<input type="hidden" name="Attendent_Name" id="Attendent_Name" id="Attendent_Name" value="<%=Attendent_Label_Name%>"/><!--ML-MMOH-CRF-0406-->
			<input type="hidden" name="reset_generateDefaultDiet" id="reset_generateDefaultDiet" value="<%=generateDefaultDiet%>"/>
			<input type="hidden" name="reset_labelMessage" id="reset_labelMessage" value="<%=labelMessage%>"/>
			<input type="hidden" name="reset_multiKitchen" id="reset_multiKitchen" value="<%=multiKitchen%>"/>
			<input type="hidden" name="reset_maxMealPlanCreatDays" id="reset_maxMealPlanCreatDays" value="<%=maxMealPlanCreateDays%>"/>
			<input type="hidden" name="reset_mealPlanNextSeq" id="reset_mealPlanNextSeq" value="<%=mealPlanNextSeq%>"/>
			<input type="hidden" name="reset_acceptDietForMeal" id="reset_acceptDietForMeal" value="<%=acceptDietForMeal%>"/>
			<input type="hidden" name="reset_blInterface" id="reset_blInterface" value="<%=blInterface%>"/>
			<input type="hidden" name="reset_attendantOrderApplicable" id="reset_attendantOrderApplicable" value="<%=attendantOrderApplicable%>"/>
			<input type="hidden" name="reset_cutOffTimeForLiquidFood" id="reset_cutOffTimeForLiquidFood" value="<%=cutOffTimeForLiquidFood%>"/>
			<input type="hidden" name="reset_gracePeriodApplicable" id="reset_gracePeriodApplicable" value="<%=gracePeriodApplicable%>"/>
			<input type="hidden" name="reset_gracePeriod" id="reset_gracePeriod" value="<%=gracePeriod%>"/>
			<input type="hidden" name="reset_multiFacility" id="reset_multiFacility" value="<%=multifacility%>"/>						
			<!-- CRF - 78.1 & CRF - 427 & MMS-KH-CRF-0029.1 -->
			<input type="hidden" name="reset_GenerateNilByMouth" id="reset_GenerateNilByMouth" value="<%=GenerateNilByMouth%>"/>			
			<input type="hidden" name="GenerateNilByMouth_YN" id="GenerateNilByMouth_YN" value="<%=GenerateNilByMouth%>"/>			<!--Added for 409 CRF-->
			<input type="hidden" name="reset_RestrictDateRangeforInpatients" id="reset_RestrictDateRangeforInpatients" value="<%=RestrictDateRangeforInpatients%>"/>			
			<input type="hidden" name="reset_MaximumDaysAllowed_Value" id="reset_MaximumDaysAllowed_Value" value="<%=MaximumDaysAllowed_Value%>"/>			
			<!-- CRF - 78.1 & CRF - 427 -->			
			<!--ML-MMOH-CRF-0409 Starts-->
			<input type="hidden" name="reset_LATE_IRREGULAR_DIET_ORD_FOR_IP" id="reset_LATE_IRREGULAR_DIET_ORD_FOR_IP" value="<%=LATE_IRREGULAR_DIET_ORD_FOR_IP%>"/>			
			<input type="hidden" name="reset_RestrictMealServingStartTime" id="reset_RestrictMealServingStartTime" value="<%=RestrictMealServingStartTime%>"/>
			<!-- MMS-KH-CRF-29.1 Starts -->
			<input type="hidden" name="reset_enableDrugFoodYN" id="reset_enableDrugFoodYN" value="<%=enableDrugFoodYN%>"/>			
			<!-- MMS-KH-CRF-29.1 Ends -->
			<input type="hidden" name="reset_NotificationMessageforPlaceDietOrder" id="reset_NotificationMessageforPlaceDietOrder" value="<%=NotificationMessageforPlaceDietOrder%>"/>
			<!--ML-MMOH-CRF-0409 Ends-->				
			<input type="hidden" name="reset_Attendent_Label_Name" id="reset_Attendent_Label_Name" value="<%=Attendent_Label_Name%>"><!--ML-MMOH-CRF-0406-->
			<input type="hidden" name="reset_No_Of_Attendant" id="reset_No_Of_Attendant" value="<%=No_Of_Attendant%>"><!--ML-MMOH-CRF-0412-->
			<!--ML-MMOH-CRF-0600 Starts-->
			<input type="hidden" name="reset_op_em_served" id="reset_op_em_served" id ="reset_op_em_served" value="<%=op_em_served%>">
			<input type="hidden" name="reset_op_em_accept" id="reset_op_em_accept" id ="reset_op_em_accept" value="<%=op_em_accept%>">
			<input type="hidden" name="reset_ip_MealPrepared" id="reset_ip_MealPrepared" id ="reset_ip_MealPrepared" value="<%=ip_MealPrepared%>">
			<input type="hidden" name="reset_ip_MealReceived" id="reset_ip_MealReceived" id ="reset_ip_MealReceived" value="<%=ip_MealReceived%>">
			<input type="hidden" name="reset_ip_MealServed" id="reset_ip_MealServed" id ="reset_ip_MealServed" value="<%=ip_MealServed%>">
			<input type="hidden" name="reset_op_em_allow" id="reset_op_em_allow" id ="reset_op_em_allow" value="<%=op_em_allow%>">
			<input type="hidden" name="reset_ip_allow" id="reset_ip_allow" id ="reset_ip_allow" value="<%=ip_allow%>">
			<!--ML-MMOH-CRF-0600 Ends -->
			<!-- Added Against ML-MMOH-CRF-1061 US2 Starts Here -->
			<input type="hidden" name="OPstatus_Ser_YN" id="OPstatus_Ser_YN" id ="OPstatus_Ser_YN" value="<%=OPstatus_Ser_YN%>">
			<input type="hidden" name="OPstatus_Acc_YN" id="OPstatus_Acc_YN" id ="OPstatus_Acc_YN" value="Y">
			<input type="hidden" name="IPstatus_Pre_YN" id="IPstatus_Pre_YN" id ="IPstatus_Pre_YN" value="<%=IPstatus_Pre_YN%>">
			<input type="hidden" name="IPstatus_Rec_YN" id="IPstatus_Rec_YN" id ="IPstatus_Rec_YN" value="<%=IPstatus_Rec_YN%>">
			<input type="hidden" name="IPstatus_Ser_YN" id="IPstatus_Ser_YN" id="IPstatus_Ser_YN" value="Y"/>
			<input type="hidden" name="reset_OPstatus_Ser" id="reset_OPstatus_Ser" id ="reset_OPstatus_Ser" value="<%=OPstatus_Ser_YN%>">
			<input type="hidden" name="reset_OPstatus_Acc" id="reset_OPstatus_Acc" id ="reset_OPstatus_Acc" value="Y">
			<input type="hidden" name="reset_IPstatus_Pre" id="reset_IPstatus_Pre" id ="reset_IPstatus_Pre" value="<%=IPstatus_Pre_YN%>">
			<input type="hidden" name="reset_IPstatus_Rec" id="reset_IPstatus_Rec" id ="reset_IPstatus_Rec" value="<%=IPstatus_Rec_YN%>">
			<input type="hidden" name="reset_IPstatus_Ser" id="reset_IPstatus_Ser" id ="reset_IPstatus_Ser" value="Y">
			<!-- Added Against ML-MMOH-CRF-1061 US2 Ends Here -->
			<!-- Added Against ML-MMOH-CRF-0825 Starts Here -->
			<input type="hidden" name="reset_LATE_IRREGULAR_DIET_ORD_FOR_OP" id="reset_LATE_IRREGULAR_DIET_ORD_FOR_OP" value="<%=LATE_IRREGULAR_DIET_ORD_FOR_OP%>"/>
			<input type="hidden" name="reset_LATE_IRREGULAR_DIET_ORD_FOR_EM" id="reset_LATE_IRREGULAR_DIET_ORD_FOR_EM" value="<%=LATE_IRREGULAR_DIET_ORD_FOR_EM%>"/>
			<input type="hidden" name="reset_LATE_IRREGULAR_DIET_ORD_FOR_ST" id="reset_LATE_IRREGULAR_DIET_ORD_FOR_ST" value="<%=LATE_IRREGULAR_DIET_ORD_FOR_ST%>"/>
			<input type="hidden" name="reset_LATE_IRREGULAR_DIET_ORD_FOR_SP" id="reset_LATE_IRREGULAR_DIET_ORD_FOR_SP" value="<%=LATE_IRREGULAR_DIET_ORD_FOR_SP%>"/>
			<!-- Added Against ML-MMOH-CRF-0825 Starts Here -->
			<!-- Added by Santhosh for ML-MMOH-CRF-1961-->
			<input type="hidden" name="reset_InstructionInLabelFormula" id="reset_InstructionInLabelFormula" value="<%=InstructionInLabelFormula%>"/>
		</form>
	</body>
</html>
<!-- 059916 -->
<script>
$('body').bind('paste',function(e) {
    e.preventDefault(); return false; 
});
</script>
<!-- 059916 -->

