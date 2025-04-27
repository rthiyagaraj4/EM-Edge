<!DOCTYPE html>
<%@page import="eDS.Common.DlQuery"%>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eDS/js/MealType.js'></script>
<script language='javascript' src='../../eDS/js/DSCommon.js'></script>
<script language='javascript' src='../../eDS/js/jquery-latest.js'></script> <!-- ML-MMOH-CRF-409 -->
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onload="parent.commontoolbarFrame.document.forms[0].apply.disabled=false; Onload_enab_disb();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'><!-- Added Against ML-MOH-CRF-0825 -->

<% 
		String mealType = "";
		String shortDesc = "";
		String longDesc = "";
		String enabledYn = "";
		String order = "";
		String opmealorder_yn = "";
		String emmealorder_yn = "";
		String supldietorder_yn = "";//MMS-QH-CRF-0079
		String stmealorder_yn = "";//ML-MMOH-CRF-0820
		String mealTypeCode = request.getParameter("mealType");
		String disabled_flag = "";
		String readOnlyFlag = "";
		String facility_id	= (String)session.getAttribute("facility_id");
		String mode = request.getParameter("mode");
		//ML_MMOH_CRF_0409 STARTS
		String Serving_Start_Time="";
		String Serving_End_Time="";
		String Irregular_Start_Time="";
		String Irregular_End_Time="";	
		String IRREGULAR_DIET_ORD_YN="",IRREGULAR_MEAL_ORD_MESSAGE="",acceptDietForIndMealYn="",lateIrregularDietOrdForOp = ""; //ML-MMOH-CRF-409
		//Added Against Start ML-MOH-CRF-1006
		String ipmealorder_yn = ""; 
		String meal_category_code = ""; 
		String meal_category_description = ""; 
		String docMealOrderYn = ""; 
		String opsMealOrderYn = ""; 
		String oncMealOrderYn = ""; 
		String stcMealOrderYn = ""; 
		String stuMealOrderYn = ""; 
		//Added Against End ML-MOH-CRF-1006
		Connection con = null;
		ResultSet rst = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;//ML-MMOH-CRF-409
		ResultSet rs1 = null;//ML-MMOH-CRF-409
		/* Added Against Start ML-MOH-CRF-825 */
		String Op_Serving_Start_Time="",Op_Serving_End_Time="",Op_Irregular_Start_Time="",Op_Irregular_End_Time="";
		String Em_Serving_Start_Time="",Em_Serving_End_Time="",Em_Irregular_Start_Time="",Em_Irregular_End_Time="";
		String Supplement_Serving_Start_Time="",Supplement_Serving_End_Time="",Supplement_Irregular_Start_Time="",Supplement_Irregular_End_Time="";
		String Doc_Serving_Start_Time="",Doc_Serving_End_Time="",Doc_Irregular_Start_Time="",Doc_Irregular_End_Time="";
		String Ops_Serving_Start_Time="",Ops_Serving_End_Time="",Ops_Irregular_Start_Time="",Ops_Irregular_End_Time="";
		String Onc_Serving_Start_Time="",Onc_Serving_End_Time="",Onc_Irregular_Start_Time="",Onc_Irregular_End_Time="";
		String Staff_Serving_Start_Time="",Staff_Serving_End_Time="",Staff_Irregular_Start_Time="",Staff_Irregular_End_Time="";
		String Student_Serving_Start_Time="",Student_Serving_End_Time="",Student_Irregular_Start_Time="",Student_Irregular_End_Time="";
		/* Added Against End ML-MOH-CRF-825 */
		String setupquery = "select ACCEPT_DIET_FOR_IND_MEAL_YN,LATE_IRREGULAR_DIET_ORD_FOR_IP,IRREGULAR_MEAL_ORD_MESSAGE,LATE_IRREGULAR_DIET_ORD_FOR_OP from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = ? ";//ML-MMOH-CRF-409

		if("modify".equals(mode)){
   		try{
   			disabled_flag = "disabled";
   			readOnlyFlag = "readonly";
	   		con = ConnectionManager.getConnection(request);
	   		pstmt = con.prepareStatement(DlQuery.DL_GET_MEAL_TYPE);
	   		pstmt.setString(1,mealTypeCode);
	   		rst = pstmt.executeQuery();
	   		while(rst.next()){
	   			mealType = rst.getString("meal_type");
	   			longDesc = rst.getString("long_desc");
	   			shortDesc = rst.getString("short_desc");
	   			order = Integer.toString(rst.getInt("meal_order"));
	   			opmealorder_yn = rst.getString("opmealorder_yn");
	   			emmealorder_yn=rst.getString("em_meal_order_yn");
				supldietorder_yn=rst.getString("suppl_diet_order_yn");//MMS-QH-CRF-0079
				stmealorder_yn=rst.getString("st_meal_order_yn");//ML-MMOH-CRF-0820
	   			enabledYn = rst.getString("eff_status");
				//ML_MMOH_CRF_0409 Starts
				Serving_Start_Time=checkForNull(rst.getString("Serving_Start_Time"));
				Serving_End_Time=checkForNull(rst.getString("Serving_End_Time"));
				Irregular_Start_Time=checkForNull(rst.getString("Irregular_Start_Time"));
				Irregular_End_Time=checkForNull(rst.getString("Irregular_End_Time"));
				//ML_MMOH_CRF_0409 Ends
				//Added Against Start ML-MMOH-CRF-1006
				ipmealorder_yn = checkForNull(rst.getString("ip_meal_order_yn"));
				docMealOrderYn = checkForNull(rst.getString("DOC_MEAL_ORDER_YN"));
				opsMealOrderYn = checkForNull(rst.getString("OPS_MEAL_ORDER_YN"));
				oncMealOrderYn = checkForNull(rst.getString("ONC_MEAL_ORDER_YN"));
				stcMealOrderYn = checkForNull(rst.getString("STF_MEAL_ORDER_YN"));
				stuMealOrderYn = checkForNull(rst.getString("STU_MEAL_ORDER_YN"));
				//Added Against End ML-MMOH-CRF-1006
				//Added Against ML-MMOH-CRF-0825 Starts
				Op_Serving_Start_Time=checkForNull(rst.getString("Serving_Start_Time_OP"));
				Op_Serving_End_Time=checkForNull(rst.getString("Serving_End_Time_OP"));
				Op_Irregular_Start_Time=checkForNull(rst.getString("Irregular_Start_Time_OP"));
				Op_Irregular_End_Time=checkForNull(rst.getString("Irregular_End_Time_OP"));
				Em_Serving_Start_Time=checkForNull(rst.getString("Serving_Start_Time_EM"));
				Em_Serving_End_Time=checkForNull(rst.getString("Serving_End_Time_EM"));
				Em_Irregular_Start_Time=checkForNull(rst.getString("Irregular_Start_Time_EM"));
				Em_Irregular_End_Time=checkForNull(rst.getString("Irregular_End_Time_EM"));
				Supplement_Serving_Start_Time=checkForNull(rst.getString("Serving_Start_Time_SUP"));
				Supplement_Serving_End_Time=checkForNull(rst.getString("Serving_End_Time_SUP"));
				Supplement_Irregular_Start_Time=checkForNull(rst.getString("Irregular_Start_Time_SUP"));
				Supplement_Irregular_End_Time=checkForNull(rst.getString("Irregular_End_Time_SUP"));
				Doc_Serving_Start_Time=checkForNull(rst.getString("Serving_Start_Time_DOC"));
				Doc_Serving_End_Time=checkForNull(rst.getString("Serving_End_Time_DOC"));
				Doc_Irregular_Start_Time=checkForNull(rst.getString("Irregular_Start_Time_DOC"));
				Doc_Irregular_End_Time=checkForNull(rst.getString("Irregular_End_Time_DOC"));
				Ops_Serving_Start_Time=checkForNull(rst.getString("Serving_Start_Time_OPS"));
				Ops_Serving_End_Time=checkForNull(rst.getString("Serving_End_Time_OPS"));
				Ops_Irregular_Start_Time=checkForNull(rst.getString("Irregular_Start_Time_OPS"));
				Ops_Irregular_End_Time=checkForNull(rst.getString("Irregular_End_Time_OPS"));
				Onc_Serving_Start_Time=checkForNull(rst.getString("Serving_Start_Time_ONC"));
				Onc_Serving_End_Time=checkForNull(rst.getString("Serving_End_Time_ONC"));
				Onc_Irregular_Start_Time=checkForNull(rst.getString("Irregular_Start_Time_ONC"));
				Onc_Irregular_End_Time=checkForNull(rst.getString("Irregular_End_Time_ONC"));
				Staff_Serving_Start_Time=checkForNull(rst.getString("Serving_Start_Time_STF"));
				Staff_Serving_End_Time=checkForNull(rst.getString("Serving_End_Time_STF"));
				Staff_Irregular_Start_Time=checkForNull(rst.getString("Irregular_Start_Time_STF"));
				Staff_Irregular_End_Time=checkForNull(rst.getString("Irregular_End_Time_STF"));
				Student_Serving_Start_Time=checkForNull(rst.getString("Serving_Start_Time_STU"));
				Student_Serving_End_Time=checkForNull(rst.getString("Serving_End_Time_STU"));
				Student_Irregular_Start_Time=checkForNull(rst.getString("Irregular_Start_Time_STU"));
				Student_Irregular_End_Time=checkForNull(rst.getString("Irregular_End_Time_STU"));
				//Added Against ML-MMOH-CRF-0825 Ends
	   		}
   		}
   		catch(Exception e){
	   		System.err.println("Error in Meal Class->"+e);
   		}
   		finally{
   			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in Meal Class:"+e);
			}
		//ML-MMOH-CRF-409
   		}
   }
   	try{
   			
   		con = ConnectionManager.getConnection(request);	   		
		pstmt1 = con.prepareStatement(setupquery);	 
		pstmt1.setString(1,facility_id);	
		rs1	= pstmt1.executeQuery();
		while(rs1 != null && rs1.next()){
			IRREGULAR_DIET_ORD_YN = rs1.getString("LATE_IRREGULAR_DIET_ORD_FOR_IP");
			IRREGULAR_MEAL_ORD_MESSAGE = rs1.getString("IRREGULAR_MEAL_ORD_MESSAGE");
			acceptDietForIndMealYn=rs1.getString("ACCEPT_DIET_FOR_IND_MEAL_YN");				
		}
		if(pstmt1!=null) pstmt1.close();
		if(rs1!=null) rs1.close();
		
		
   		}catch(Exception e){
	   		System.err.println("Error in Meal Class->"+e);
			e.printStackTrace();
   		}finally{
   			try{
				if(pstmt1!=null) pstmt1.close();
				if(rs1!=null) rs1.close();
				ConnectionManager.returnConnection(con);
			}catch(Exception e){
				System.err.println("Exception in Meal Class:"+e);
				e.printStackTrace();
			}
   		}
		//ML-MMOH-CRF-409
%>
		<br>	
		<form name="mealClass_form" id="mealClass_form"  onload='FocusFirstElement()'  action="../../servlet/eDS.MealTypeServlet" method="post" target="messageFrame">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
				<tr>
					<td class='label' align="right">
						<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="meal_Type" id="meal_Type" value="<%=mealType %>" onkeypress="restrictSpecialChars(event)" size="4" maxlength="4" onkeyup="setFieldToUpperCase(this)"  onkeypress="return checkAlpha(event)" <%=disabled_flag %>/>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>

				<tr>
					<td class='label' align="right">
						<fmt:message key="eOT.LongDescription.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="long_Desc" id="long_Desc" value="<%=longDesc %>"  onkeypress="restrictSpecialChars(event)" size="30" maxlength="30" />
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>

				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.ShortDescription.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="short_Desc" id="short_Desc" value="<%=shortDesc %>" onkeypress="restrictSpecialChars(event)" size="15" maxlength="15" />
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>

				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.Order.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="order_no" id="order_no" value="<%=order %>" size="2" maxlength="2" onblur="CheckPosNumber(this);CheckConstraint(this);" <%=disabled_flag %> />
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>

				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.Enabled.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){
							if("E".equals(enabledYn)){ %>
								<input type="checkbox" name="enabled_Yn" id="enabled_Yn"  checked="checked"/>
							<%}
							else{%>
								<input type="checkbox" name="enabled_Yn" id="enabled_Yn"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="enabled_Yn" id="enabled_Yn"  checked="checked"/>
						<%} %>
					</td>
				<!-- CRF-230 changes - For adding meal type for Place OPmealorder-->
				</tr>
				<!-- Added Against Start ML-MMOH-CRF-0825 -->
				<tr>
				<td></td>
				<td></td>
					<td align="right" class='label'>
							<fmt:message key="eDS.ServingStartTime.Label" bundle="${ds_labels}"/>
						</td>
						<td align="right" class='label'>
							<fmt:message key="Common.EndTime.label" bundle="${common_labels}"/>
					</td>
					<td align="right" class='label'>
							<fmt:message key="eDS.LateIrregularDietOrderStartTime.Label" bundle="${ds_labels}"/>
					</td>
					<td align="right" class='label'>
							<fmt:message key="Common.EndTime.label" bundle="${common_labels}"/>
					</td>
				</tr>
				<!-- Added Against End ML-MMOH-CRF-0825 -->
				<!-- Added Against Start ML-MOH-CRF-1006 -->
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eDS.PlaceIPMealOrder.Label" bundle="${ds_labels}"/>
					</td>
					<td>
					<%if("modify".equals(mode)){
						if("Y".equals(ipmealorder_yn)){%>
							<input type="checkbox" name="ipmealorder_yn" id="ipmealorder_yn"  checked="checked" onclick="enable_disable(this);"/> <!-- Added Against ML-MOH-CRF-0825 -->
					  <%}else{%>
							<input type="checkbox" name="ipmealorder_yn" id="ipmealorder_yn" onclick="enable_disable(this);"/> <!-- Added Against ML-MOH-CRF-0825 -->
					  <%}
					}else{%>
						<input type="checkbox" name="ipmealorder_yn" id="ipmealorder_yn" onclick="enable_disable(this);"/>
					<%}%>
					</td>					
					 <!-- Added Against ML-MOH-CRF-0825 Starts -->
					 <!-- Inpatient  -->
					<td>
						<input type="text" name="ServingStartTime" id="ServingStartTime" id="ServingStartTime" size="5" maxlength="5"  onkeyup="enableDisabletextField('ServingStartTime','ServingEndTime');" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Serving_Start_Time%>>(hh24:mi)
					</td>					
					
					<td>
						<input type="text" name="ServingEndTime" id="ServingEndTime" id="ServingEndTime" size="5" maxlength="5"  onkeyup="enableDisabletextField('ServingStartTime','ServingEndTime');" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Serving_End_Time%>>(hh24:mi)
					</td>
					<td>
						<input type="text" name="IrregularStartTime" id="IrregularStartTime" id="IrregularStartTime" size="5" maxlength="5" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Irregular_Start_Time%> >(hh24:mi)
					</td>					
					<td>
						<input type="text" name="IrregularEndTime" id="IrregularEndTime" id="IrregularEndTime" size="5" maxlength="5" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Irregular_End_Time%> >(hh24:mi)
					</td>
					<!-- Added Against End ML-MOH-CRF-0825  -->
				</tr>	
				<!-- Added Against End ML-MOH-CRF-1006 -->
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.PlaceOPMealOrder.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){	
							if("Y".equals(opmealorder_yn)){ %>
								<input type="checkbox" name="opmealorder_yn" id="opmealorder_yn"  checked="checked" onclick="enable_disable(this);"/> <!-- Added Against ML-MOH-CRF-0825 -->
							<%}
							else{%>
								<input type="checkbox" name="opmealorder_yn" id="opmealorder_yn" onclick="enable_disable(this);"/> <!-- Added Against ML-MOH-CRF-0825 -->
							<%}
						}
						else{ %>
							<input type="checkbox" name="opmealorder_yn" id="opmealorder_yn" onclick="enable_disable(this);"/>
						<%} %>
					</td>
					<!-- Added Against ML-MOH-CRF-0825 Starts -->
					<!-- OutPatient  -->
					<td>
						<input type="text" name="OpServingStartTime" id="OpServingStartTime" id="OpServingStartTime" size="5" maxlength="5"  onkeyup="enableDisabletextField('OpServingStartTime','OpServingEndTime');" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Op_Serving_Start_Time%>>(hh24:mi)
					</td>					
					
					<td>
						<input type="text" name="OpServingEndTime" id="OpServingEndTime" id="OpServingEndTime" size="5" maxlength="5"  onkeyup="enableDisabletextField('OpServingStartTime','OpServingEndTime');" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Op_Serving_End_Time%>>(hh24:mi)
					</td>
					<td>
						<input type="text" name="OpIrregularStartTime" id="OpIrregularStartTime" id="OpIrregularStartTime" size="5" maxlength="5" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Op_Irregular_Start_Time%> >(hh24:mi)
					</td>					
					<td>
						<input type="text" name="OpIrregularEndTime" id="OpIrregularEndTime" id="OpIrregularEndTime" size="5" maxlength="5" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Op_Irregular_End_Time%> >(hh24:mi)
					</td>
					<!-- Added Against End ML-MOH-CRF-0825 -->
				</tr>

				<tr>
					<td align="right" class='label'>
						<fmt:message key="eDS.PlaceEMMealOrder.Label" bundle="${ds_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){	
							if("Y".equals(emmealorder_yn)){ %>
								<input type="checkbox" name="emmealorder_yn" id="emmealorder_yn"  checked="checked" onclick="enable_disable(this);"/> <!-- Added Against ML-MOH-CRF-0825 -->
							<%}
							else{%>
								<input type="checkbox" name="emmealorder_yn" id="emmealorder_yn" onclick="enable_disable(this);"/> <!-- Added Against ML-MOH-CRF-0825 -->
							<%}
						}
						else{ %>
							<input type="checkbox" name="emmealorder_yn" id="emmealorder_yn" onclick="enable_disable(this);"/>
						<%} %>
					</td>	
					<!-- Added Against End ML-MOH-CRF-0825 Starts -->
					<!-- EmergencyPatient  -->
					<td>
						<input type="text" name="EmServingStartTime" id="EmServingStartTime" id="EmServingStartTime" size="5" maxlength="5"  onkeyup="enableDisabletextField('EmServingStartTime','EmServingEndTime');" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Em_Serving_Start_Time%>>(hh24:mi)
					</td>					
					
					<td>
						<input type="text" name="EmServingEndTime" id="EmServingEndTime" id="EmServingEndTime" size="5" maxlength="5"  onkeyup="enableDisabletextField('EmServingStartTime','EmServingEndTime');" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Em_Serving_End_Time%>>(hh24:mi)
					</td>
					<td>
						<input type="text" name="EmIrregularStartTime" id="EmIrregularStartTime" id="EmIrregularStartTime" size="5" maxlength="5" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Em_Irregular_Start_Time%> >(hh24:mi)
					</td>					
					<td>
						<input type="text" name="EmIrregularEndTime" id="EmIrregularEndTime" id="EmIrregularEndTime" size="5" maxlength="5" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Em_Irregular_End_Time%> >(hh24:mi)
					</td>
					<!-- Added Against End ML-MOH-CRF-0825 Ends -->
				</tr>

				<!-- MMS-QH-CRF-0079 STARTS Place Supplementary Diet Order-->
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eDS.PlaceSupplementaryDietOrder.Label" bundle="${ds_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){	
							if("Y".equals(supldietorder_yn)){ %>
								<input type="checkbox" name="supldietorder_yn" id="supldietorder_yn"  checked="checked" onclick="enable_disable(this);"/> <!-- Added Against ML-MOH-CRF-0825 -->
							<%}
							else{%>
								<input type="checkbox" name="supldietorder_yn" id="supldietorder_yn" onclick="enable_disable(this);"/> <!-- Added Against ML-MOH-CRF-0825 -->
							<%}
						}
						else{ %>
							<input type="checkbox" name="supldietorder_yn" id="supldietorder_yn" onclick="enable_disable(this);"/>
						<%} %>
					</td>
					<!-- Added Against End ML-MOH-CRF-0825 Starts -->
					<!-- Supplementary Order  -->
					<td>
						<input type="text" name="SupplementServingStartTime" id="SupplementServingStartTime" id="SupplementServingStartTime" size="5" maxlength="5"  onkeyup="enableDisabletextField('SupplementServingStartTime','SupplementServingEndTime');" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Supplement_Serving_Start_Time%>>(hh24:mi)
					</td>					
					
					<td>
						<input type="text" name="SupplementServingEndTime" id="SupplementServingEndTime" id="SupplementServingEndTime" size="5" maxlength="5"  onkeyup="enableDisabletextField('SupplementServingStartTime','SupplementServingEndTime');" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Supplement_Serving_End_Time%>>(hh24:mi)
					</td>
					<td>
						<input type="text" name="SupplementIrregularStartTime" id="SupplementIrregularStartTime" id="SupplementIrregularStartTime" size="5" maxlength="5" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Supplement_Irregular_Start_Time%> >(hh24:mi)
					</td>					
					<td>
						<input type="text" name="SupplementIrregularEndTime" id="SupplementIrregularEndTime" id="SupplementIrregularEndTime" size="5" maxlength="5" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Supplement_Irregular_End_Time%> >(hh24:mi)
					</td>
					<!-- Added Against End ML-MOH-CRF-0825 Ends -->
				</tr>
				<!-- MMS-QH-CRF-0079 ENDS -->				
				<!-- ML-MMOH-CRF-0820 STARTS-->
			<BR>	
			<BR>	
			<!-- Place Staff Meal Order  -->
			<tr>
				<td>
				</td>
			</tr>
			<tr>
				<td align="right" class='label'>
					<fmt:message key="eDS.PlaceStaffMealOrder.Label" bundle="${ds_labels}"/>
				</td>
			</tr>
			
			<!--tr>
			<td-->
			<!--Added Against Start ML-MMOH-CRF-1006 -->
	<!--div id="MealTypeCheck" style="visibility:visible;overflow:auto;height:125;width:200;border: 1px outset white" align="right" -->
	   <!--table border='0' cellpadding='2' cellspacing='0' width='100%' align='center'-->
		  <!--tr-->
			<!--td-->
			<%	
			//if("modify".equals(mode)){
			//if("Y".equals(docMealOrderYn)){ %>
				<!--input type="checkbox" name="docMealOrderYn"  checked="checked" /-->
			<%//}else{%>
				<!--input type="checkbox" name="docMealOrderYn" /-->
			<%//}%>
			
			<BR>
			<%//if("Y".equals(opsMealOrderYn)){ %>
				<!--input type="checkbox" name="opsMealOrderYn"  checked="checked"/-->
			<%//}else{%>
				<!--input type="checkbox" name="opsMealOrderYn"--/>				
			<%//}%>
			<!--fmt:message key="eDS.OTParamedicStaff.Label" bundle="${ds_labels}"/-->
			<!--BR-->
			<%//if("Y".equals(oncMealOrderYn)){ %>
				<!--input type="checkbox" name="oncMealOrderYn"  checked="checked" /-->
			<%//}else{%>
				<!--input type="checkbox" name="oncMealOrderYn"/-->
			<%//}%>
			<!--fmt:message key="eDS.OnCallStaff.Label" bundle="${ds_labels}"/-->
			<BR>
			<%//if("Y".equals(stcMealOrderYn)){ %>
				<!--input type="checkbox" name="stcMealOrderYn"  checked="checked" /-->
			<%//}else{%>
				<!--input type="checkbox" name="stcMealOrderYn"/>
			<%//}%>
			<!--fmt:message key="eDS.Staff.Label" bundle="${ds_labels}"/-->
			<!--BR-->
			<%//if("Y".equals(stuMealOrderYn)){ %>
				<!--input type="checkbox" name="stuMealOrderYn"  checked="checked"/-->
			<%//}else{%>
				<!--input type="checkbox" name="stuMealOrderYn"/-->
			<%//}%>
			<!--fmt:message key="eDS.Students.Label" bundle="${ds_labels}"/-->
			<%//} // Modify Mode End
			/* else{ //Insert Mode Start
				try{
				String ds_meal_category_sql= "SELECT MEAL_CATEGORY_CODE, DESCRIPTION FROM DS_MEAL_CATEGORY_LANG_VW WHERE MEAL_CATEGORY_CODE IN ('STF', 'ONC', 'STU','DOC','OPS') AND (LANGUAGE_ID = ?) ORDER BY 2, 1";
				con = ConnectionManager.getConnection(request);
				pstmt1 = con.prepareStatement(ds_meal_category_sql);
				pstmt1.setString(1,locale);
				rs1	= pstmt1.executeQuery();
				while(rs1 != null && rs1.next()){
				meal_category_code = rs1.getString(1);
				meal_category_description = rs1.getString(2); */
				
				%>
				<!--input type="checkbox" id="mealTypeId" name="check" value="<!%=meal_category_code%>">
				<!%=meal_category_description%><BR-->	
				
				<%
				/* } // end of while
				}catch(Exception e){
				e.printStackTrace();
				}finally{
				try{
					if(rs1!=null) rs1.close();
					if(pstmt1!=null) pstmt1.close();
					ConnectionManager.returnConnection(con);
					}catch(Exception e){
					e.printStackTrace();
					}
				}
				} // end of insert mode */
				%>
			<!--/td-->
		<!--/tr-->
	  <!--/table-->
	<!--/div-->
			<!--/td >					
		</tr-->
			<!-- Start 825 -->
			<tr>
					<td align="right" class='label'>
						<fmt:message key="eDS.DoctorOnCall.Label" bundle="${ds_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){	
							if("Y".equals(docMealOrderYn)){ %>
								<input type="checkbox" name="docMealOrderYn" id="docMealOrderYn"  checked="checked" onclick="enable_disable(this);"/>
							<%}
							else{%>
								<input type="checkbox" name="docMealOrderYn" id="docMealOrderYn" onclick="enable_disable(this);"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="docMealOrderYn" id="docMealOrderYn" id="docMealOrderYn" onclick="enable_disable(this);"/>
						<%} %>
						
					</td>
					<td>
						<input type="text" name="DocServingStartTime" id="DocServingStartTime" id="DocServingStartTime" size="5" maxlength="5"  onkeyup="enableDisabletextField('DocServingStartTime','DocServingEndTime');" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Doc_Serving_Start_Time%>>(hh24:mi)
					</td>					
					
					<td>
						<input type="text" name="DocServingEndTime" id="DocServingEndTime" id="DocServingEndTime" size="5" maxlength="5"  onkeyup="enableDisabletextField('DocServingStartTime','DocServingEndTime');" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Doc_Serving_End_Time%>>(hh24:mi)
					</td>
					<td>
						<input type="text" name="DocIrregularStartTime" id="DocIrregularStartTime" id="DocIrregularStartTime" size="5" maxlength="5" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Doc_Irregular_Start_Time%> >(hh24:mi)
					</td>					
					<td>
						<input type="text" name="DocIrregularEndTime" id="DocIrregularEndTime" id="DocIrregularEndTime" size="5" maxlength="5" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Doc_Irregular_End_Time%> >(hh24:mi)
					</td>
				</tr>
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eDS.OTParamedicStaff.Label" bundle="${ds_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){	
							if("Y".equals(opsMealOrderYn)){ %>
								<input type="checkbox" name="opsMealOrderYn" id="opsMealOrderYn"  checked="checked" onclick="enable_disable(this);"/>
							<%}
							else{%>
								<input type="checkbox" name="opsMealOrderYn" id="opsMealOrderYn" onclick="enable_disable(this);"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="opsMealOrderYn" id="opsMealOrderYn" onclick="enable_disable(this);"/>
						<%} %>
					</td>
					<td>
						<input type="text" name="OpsServingStartTime" id="OpsServingStartTime" id="OpsServingStartTime" size="5" maxlength="5"  onkeyup="enableDisabletextField('OpsServingStartTime','OpsServingEndTime');" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Ops_Serving_Start_Time%>>(hh24:mi)
					</td>					
					
					<td>
						<input type="text" name="OpsServingEndTime" id="OpsServingEndTime" id="OpsServingEndTime" size="5" maxlength="5"  onkeyup="enableDisabletextField('OpsServingStartTime','OpsServingEndTime');" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Ops_Serving_End_Time%>>(hh24:mi)
					</td>
					<td>
						<input type="text" name="OpsIrregularStartTime" id="OpsIrregularStartTime" id="OpsIrregularStartTime" size="5" maxlength="5" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Ops_Irregular_Start_Time%> >(hh24:mi)
					</td>					
					<td>
						<input type="text" name="OpsIrregularEndTime" id="OpsIrregularEndTime" id="OpsIrregularEndTime" size="5" maxlength="5" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Ops_Irregular_End_Time%> >(hh24:mi)
					</td>
				</tr>
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eDS.OnCallStaff.Label" bundle="${ds_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){	
							if("Y".equals(oncMealOrderYn)){ %>
								<input type="checkbox" name="oncMealOrderYn" id="oncMealOrderYn"  checked="checked" onclick="enable_disable(this);"/>
							<%}
							else{%>
								<input type="checkbox" name="oncMealOrderYn" id="oncMealOrderYn" onclick="enable_disable(this);"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="oncMealOrderYn" id="oncMealOrderYn" onclick="enable_disable(this);"/>
						<%} %>
					</td>
					<td>
						<input type="text" name="OncServingStartTime" id="OncServingStartTime" id="OncServingStartTime" size="5" maxlength="5"  onkeyup="enableDisabletextField('OncServingStartTime','OncServingEndTime');" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Onc_Serving_Start_Time%>>(hh24:mi)
					</td>					
					
					<td>
						<input type="text" name="OncServingEndTime" id="OncServingEndTime" id="OncServingEndTime" size="5" maxlength="5"  onkeyup="enableDisabletextField('OncServingStartTime','OncServingEndTime');" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Onc_Serving_End_Time%>>(hh24:mi)
					</td>
					<td>
						<input type="text" name="OncIrregularStartTime" id="OncIrregularStartTime" id="OncIrregularStartTime" size="5" maxlength="5" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Onc_Irregular_Start_Time%> >(hh24:mi)
					</td>					
					<td>
						<input type="text" name="OncIrregularEndTime" id="OncIrregularEndTime" id="OncIrregularEndTime" size="5" maxlength="5" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Onc_Irregular_End_Time%> >(hh24:mi)
					</td>
				</tr>
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eDS.Staff.Label" bundle="${ds_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){	
							if("Y".equals(stcMealOrderYn)){ %>
								<input type="checkbox" name="stcMealOrderYn" id="stcMealOrderYn"  checked="checked" onclick="enable_disable(this);"/>
							<%}
							else{%>
								<input type="checkbox" name="stcMealOrderYn" id="stcMealOrderYn" onclick="enable_disable(this);"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="stcMealOrderYn" id="stcMealOrderYn" onclick="enable_disable(this);"/>
						<%} %>
					</td>
					<td>
						<input type="text" name="StaffServingStartTime" id="StaffServingStartTime" id="StaffServingStartTime" size="5" maxlength="5"  onkeyup="enableDisabletextField('StaffServingStartTime','StaffServingEndTime');" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Staff_Serving_Start_Time%>>(hh24:mi)
					</td>					
					
					<td>
						<input type="text" name="StaffServingEndTime" id="StaffServingEndTime" id="StaffServingEndTime" size="5" maxlength="5"  onkeyup="enableDisabletextField('StaffServingStartTime','StaffServingEndTime');" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Staff_Serving_End_Time%>>(hh24:mi)
					</td>
					<td>
						<input type="text" name="StaffIrregularStartTime" id="StaffIrregularStartTime" id="StaffIrregularStartTime" size="5" maxlength="5" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Staff_Irregular_Start_Time%> >(hh24:mi)
					</td>					
					<td>
						<input type="text" name="StaffIrregularEndTime" id="StaffIrregularEndTime" id="StaffIrregularEndTime" size="5" maxlength="5" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Staff_Irregular_End_Time%> >(hh24:mi)
					</td>
				</tr>
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eDS.Students.Label" bundle="${ds_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){	
							if("Y".equals(stuMealOrderYn)){ %>
								<input type="checkbox" name="stuMealOrderYn" id="stuMealOrderYn"  checked="checked" onclick="enable_disable(this);"/>
							<%}
							else{%>
								<input type="checkbox" name="stuMealOrderYn" id="stuMealOrderYn" onclick="enable_disable(this);"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="stuMealOrderYn" id="stuMealOrderYn" onclick="enable_disable(this);"/>
						<%} %>
					</td>
					<td>
						<input type="text" name="StudentServingStartTime" id="StudentServingStartTime" id="StudentServingStartTime" size="5" maxlength="5"  onkeyup="enableDisabletextField('StudentServingStartTime','StudentServingEndTime');" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Student_Serving_Start_Time%>>(hh24:mi)
					</td>					
					
					<td>
						<input type="text" name="StudentServingEndTime" id="StudentServingEndTime" id="StudentServingEndTime" size="5" maxlength="5"  onkeyup="enableDisabletextField('StudentServingStartTime','StudentServingEndTime');" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Student_Serving_End_Time%>>(hh24:mi)
					</td>
					<td>
						<input type="text" name="StudentIrregularStartTime" id="StudentIrregularStartTime" id="StudentIrregularStartTime" size="5" maxlength="5" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Student_Irregular_Start_Time%> >(hh24:mi)
					</td>					
					<td>
						<input type="text" name="StudentIrregularEndTime" id="StudentIrregularEndTime" id="StudentIrregularEndTime" size="5" maxlength="5" onkeypress="return checkForSpecCharsforID_mt(event);" onBlur="isValidTime(this);" disabled="true" value=<%=Student_Irregular_End_Time%> >(hh24:mi)
					</td>
				</tr>
		
			<!--Added Against End ML-MMOH-CRF-1006 -->
				<!-- ML-MMOH-CRF-0820 ENDS -->
	</table>
			<!--ML-MMOH-CRF-409 STARTS-->
			<!--ENABLE THE IRREGULAR START AND END TIME TEXT FIELDS IN QUERY MODE IF THE SERVING START TIME AND END TIME IS FILLED STARTS-->
		
	<%
		//if(!(Serving_Start_Time.equals("")&&Serving_End_Time.equals("")) && IRREGULAR_DIET_ORD_YN.equals("Y") && acceptDietForIndMealYn.equals("Y")){
	%>

		<!--script type="text/javascript">
			$('#IrregularStartTime').prop('disabled', false);
			$('#IrregularEndTime').prop('disabled', false);
		</script-->

	<%//IN059007
		//}if(IRREGULAR_DIET_ORD_YN.equals("Y") && acceptDietForIndMealYn.equals("Y")){
	%>
		<!--script type="text/javascript">
			$('#ServingStartTime').prop('disabled', false);
			$('#ServingEndTime').prop('disabled', false);
		</script-->	
	<%
		//} //Added Against Start ML-MOH-CRF-825
	%>
		<!--ENABLE THE IRREGULAR START AND END TIME TEXT FIELDS IN QUERY MODE IF THE SERVING START TIME AND END TIME IS FILLED ENDS-->
		<!--ML-MMOH-CRF-409 ENDS-->
	
		<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
		<input type='hidden' name='updMealType' id='updMealType' value='<%=mealType%>'>
		<input type='hidden' name='updLongDesc' id='updLongDesc' value='<%=longDesc%>'>
		<input type='hidden' name='updShortDesc' id='updShortDesc' value='<%=shortDesc%>'>
		<input type='hidden' name='updOrder' id='updOrder' value='<%=order%>'>
		<input type='hidden' name='updEnabledYn' id='updEnabledYn' value='<%=enabledYn%>'>
		<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
		<input type='hidden' name='acceptDietForIndMealYn' id='acceptDietForIndMealYn' value='<%=acceptDietForIndMealYn%>'>
		<input type='hidden' name='irregular_diet_ord_yn' id='irregular_diet_ord_yn' value='<%=IRREGULAR_DIET_ORD_YN%>'>
		</form>
	</body>
</html>

