<!DOCTYPE html>
<%@  page import ="java.util.*,java.sql.*,java.net.*,eCommon.Common.*,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<Script src="../../eOA/js/Validate.js" language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eDS/js/GenerateMealPlan.js' language='javascript'></script>
<script type="text/javascript">
async function callPatientSearch(){
	var pat_id =  await parent.window.PatientSearch();
	if(pat_id != null)
	document.getElementById("patientId").value = pat_id;
}

	function getSysForGenerateMealPlanDate(){
		var locale = document.getElementById("locale").value;
	}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onload="" OnMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<br>
	<form name="GenerateMealPlanForm" id="GenerateMealPlanForm" method="post" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<%
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rst=null;
	String facility_id  = (String) session.getValue("facility_id");
	String login_user = "";
	java.util.Properties prop;
	prop = (java.util.Properties) session.getValue( "jdbc" ) ;
	login_user = prop.getProperty( "login_user" ) ;
	String locale = (String) session.getValue("LOCALE");
	String sql="";
	String strCode="";
	String strDesc="";
	String servingDate="";
	String p_facility_id= facility_id;
	boolean isMultiDietType =false; //Added By Gaurav Against MMS-KH-SCF-0207
	boolean isDietReport =false; //MMS-JU-SCF-0174
	try{
		conn = ConnectionManager.getConnection(request);	
		isMultiDietType = CommonBean.isSiteSpecific(conn,"DS","DS_MULTI_DIET_TYPES"); //Added By Gaurav Against MMS-KH-SCF-0207
		pstmt = conn.prepareStatement("SELECT to_char(SYSDATE,'dd/mm/yyyy') CURRENT_DATE FROM DUAL");
		rst = pstmt.executeQuery();
		while(rst.next()){
			servingDate = com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
		}
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		/* Added Against KDAH-CRF-0353 US1 */  
		boolean isDtCat_MlCls =false;
		isDtCat_MlCls = CommonBean.isSiteSpecific(conn,"DS","DS_MEAL_MENU_ITEMS");
		isDietReport = CommonBean.isSiteSpecific(conn,"DS","PLACE_ORDER_FOR_ATTENDANT");//MMS-JU-SCF-0174
		%>
		<table border='0' cellpadding='2' cellspacing='0' width='50%' align='left'>
			<tr>
				<td align="left" class='label'>
					<fmt:message key="eOT.ServingDate.Label" bundle="${ot_labels}"/>
				</td>
				<td align="left" class='label'>
					<input type="text" name="servingDate" id="servingDate" maxlength="10" size="10" value="<%=servingDate%>" onkeypress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);CheckDate(this)'>
								<img src="../../eCommon/images/CommonCalendar.gif"  name='imagemonth' onClick="return showCalendar('servingDate');">
					<img src='../../eCommon/images/mandatory.gif' />
				</td>
			</tr>
			<tr>
				<td align="left" class='label'> <fmt:message key="eOT.DietCategory.Label" bundle="${ot_labels}"/>   	</td>
				<td align="left" class='label'>
					<select id="dietCategory" name="dietCategory" id="dietCategory"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
					<%
					try{
						sql ="SELECT  DIET_CATEGORY_CODE,ds_get_desc.ds_diet_category(DIET_CATEGORY_CODE,'"+locale+"',1) SHORT_DESC FROM ds_diet_category";
						pstmt=conn.prepareStatement(sql);
						rst = pstmt.executeQuery();
						while(rst.next()){
						strCode = rst.getString(1);
						strDesc =  rst.getString(2);
					%>
				<option value="<%=strCode%>"><%=strDesc%></option>
				<%}
				  }catch(Exception  DCat){
					  System.out.println("DS generateMeal plan "+DCat);
				  }finally{
					   if(rst !=null) rst.close();
					   if(pstmt !=null) pstmt.close();
				   }
				%>
				</td>
			</tr>
			<tr>
				<td align="left" class='label'>
				<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}"/>
				</td>
				<td align="left" class='label'>
					<select id="kitchen" name="kitchen" id="kitchen" ><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>

				<%
					try{
						sql ="select  KITCHEN_CODE,ds_get_desc.ds_kitchens('"+facility_id+"',KITCHEN_CODE,'"+locale+"',2)  from ds_kitchens";
						pstmt=conn.prepareStatement(sql);
						rst = pstmt.executeQuery();
						while(rst.next()){
						strCode = rst.getString(1);
						strDesc =  rst.getString(2);
						if(strDesc != null && !strDesc.equals("")){
				%>
				<option value="<%=strCode%>"><%=strDesc%></option>
				<%}
					}
					  }catch(Exception DCat){
						  System.out.println("GenerateMeal Plan Kitchen"+DCat);
					  }finally{
						   if(rst != null) rst.close();
							if(pstmt != null) pstmt.close();
					  }
				  %>
				</td>
			</tr>
			<tr>
				<td align="left" class='label'>
						<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}"/>
				</td>
				<td align="left" class='label'>
					<select id="mealType" name="mealType" id="mealType"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>

					<%
					try{
						sql ="select MEAL_TYPE,ds_get_desc.ds_meal_type(MEAL_TYPE,'"+locale+"',2) From  ds_meal_type where eff_status='E' order by meal_order";
						
						pstmt=conn.prepareStatement(sql);
						rst = pstmt.executeQuery();
						while(rst.next()){
						strCode = rst.getString(1);
						strDesc =  rst.getString(2);
						%>
						<option value="<%=strCode%>"><%=strDesc%></option>
						<%}%>
						<%}catch(Exception DCat){}
							   finally{
									if(rst !=null) rst.close();
									if(pstmt !=null) pstmt.close();
						 }%>
					</select>	
					<%if(isDtCat_MlCls){%>	
						<img id="mandatory" name="mandatory" src="../../eCommon/images/mandatory.gif"/><!-- Added Against KDAH-CRF-0353 US1 -->	 
					<%}%>	
				</td>	
			</tr>
			<tr>
				<td align="left" class='label'>
				<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}"/>
				</td>
				<td align="left" class='label'>
					<select id="mealClass" name="mealClass" id="mealClass">
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
					<%
					try{
						sql = "SELECT MEAL_CLASS, ds_get_desc.ds_meal_class(MEAL_CLASS,'"+locale+"',2)  FROM DS_MEAL_CLASS where EFF_STATUS='E'" ;
						pstmt=conn.prepareStatement(sql);
						rst = pstmt.executeQuery();
						while(rst.next()){
						strCode = rst.getString(1);
						strDesc =  rst.getString(2);
					%>
					<option value="<%=strCode%>"><%=strDesc%></option>
					<%}
						}catch(Exception DCat){}
						   finally{
								if(rst !=null) rst.close();
								if(pstmt !=null) pstmt.close();
						}%>
				</td>
			</tr>
			<tr>
				<td align="left" class='label'>
				<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}"/>
				</td>
				<td align="left" class='label'>
				<%if(isMultiDietType){%>
					<select name="dietType" id="dietType" onchange="selectAll(this.value)"> <!-- Changes against ML-MMOH-CRF-1818 -->
				<%}else{%>	
					<select name="dietType" id="dietType" onchange="selectAll(this.value)" multiple> 
				<%}%>	
					<option value="All">All</option><!-- MMS-DM-CRF-0043 -->

					<%
					try{	
					sql ="SELECT DIET_TYPE,DS_GET_DESC.DS_DIET_TYPE(DIET_TYPE,'"+locale+"',2) from  DS_DIET_TYPE WHERE EFF_STATUS='E'" ;
						pstmt=conn.prepareStatement(sql);
						rst = pstmt.executeQuery();
						while(rst.next()){
						strCode = rst.getString(1);
						strDesc =  rst.getString(2);
					%>
					<option value="<%=strCode%>"><%=strDesc%></option>
					<%}
					}catch(Exception DCat){}
					   finally{
						    if(rst !=null) rst.close();
							if(pstmt !=null) pstmt.close();
					   }%>
					   </select>
					</td>
			</tr>
			<tr>
				<td align="left" class='label'>
				<fmt:message key="eOT.NursingUnit.Label" bundle="${ot_labels}"/>
				</td>
				<td align="left" class='label'>
					<select id="nursingUnit" name="nursingUnit" id="nursingUnit"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
					<%
					try{
						sql ="SELECT NURSING_UNIT_CODE ,SHORT_DESC  FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' order by 2";

						pstmt=conn.prepareStatement(sql);
						rst = pstmt.executeQuery();
						while(rst.next()){
						strCode = rst.getString(1);
						strDesc =  rst.getString(2);
					%>
					<option value="<%=strCode%>"><%=strDesc%></option>
					<%}
					}catch(Exception DCat){
					}finally{
						if(rst !=null) rst.close();
						if(pstmt !=null) pstmt.close();
					}%>
				</td>
			</tr>
			<tr>
				<%   
				String pat_id_length=""; //IN:40826
					try{
					    pstmt = conn.prepareStatement("select patient_id_length from mp_param where MODULE_ID='MP'");
			            rst	=pstmt.executeQuery();
			            if (rst.next() && rst != null){
			 	          pat_id_length = rst.getString(1);
						}
						 }catch(Exception e){
							e.printStackTrace();
						 }finally{
                          if(rst !=null) rst.close();
						  if(pstmt != null) pstmt.close();
						}
				%>
				<td align="left" class='label'>
					<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
				</td>
				<td align="left" class='label'>
					<input type="text" name="patientId" id="patientId" maxlength='<%=pat_id_length%>' onKeypress='return CheckForSpecChars(event);' size='12' value="">
					<input align='right' type="button" class='BUTTON' name=search value='?'  class="button" onClick="callPatientSearch()">
				</td>
			</tr>
			<tr>
				<td align="left" class='label'>
					<fmt:message key="Common.status.label" bundle="${common_labels}"/>
				</td>
				<TD align="left" class='label'>
					<select name="status" id="status" onChange="">
						<option value="A" selected><fmt:message key="Common.all.label" bundle="${common_labels}" /></option>
						<option value="O"><fmt:message key="eOT.OrderPlaced.Label" bundle="${ot_labels}" /></option>
						<option value="P"><fmt:message key="eOT.OrderPending.Label" bundle="${common_labels}" /></option>
						<option value="M"><fmt:message key="eOT.OrderModified.Label" bundle="${common_labels}" /></option>
					</select>
				</TD>
			</tr>
			<!-- Added Against Start KDAH-CRF-0353 US1 -->
			<%if(isDtCat_MlCls){%>		
			<tr>
				<td align="left" class='label'>
					<fmt:message key="Common.reporttype.label" bundle="${common_labels}" />
				</td>
				<td align="left" class='label'>
					<select name="reportStatus" id="reportStatus" onChange="reportOrExcel(this);">
						<option value="S"><fmt:message key="Common.Summary.label" bundle="${common_labels}" /></option>
						<option value="D"><fmt:message key="Common.Detail.label" bundle="${common_labels}" /></option>
					</select>
				</td>
				<td class='fields' id="excel" style='visibility:hidden' width="18%" > 
					<image src='../../eDS/css/excel.gif' onClick="callExcelDisplay();" width="15" height="15" title='<fmt:message key="eOT.ReportinExcelFormat.Label" bundle="${ot_labels}"/>'  >
				</td>
			</tr>
			<%}%>		
			<!-- Added Against End KDAH-CRF-0353 US1 -->
		</table>
		<INPUT type="hidden" name="isDtCat_MlCls" id="isDtCat_MlCls" id="isDtCat_MlCls" value="<%=isDtCat_MlCls%>"> <!-- Added Against KDAH-CRF-353-US1 -->
		<%	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		if(conn!=null)
			ConnectionManager.returnConnection(conn, request);
		}
		%>
		<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
		<input type="hidden" name="p_user_id" id="p_user_id"		value="<%=login_user%>">
		<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=login_user%>">
		<input type="hidden" name="p_module_id" id="p_module_id"		value="DS">
		<input type="hidden" name="p_report_id" id="p_report_id"		value="DSORSHET">
		<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
		<input type="hidden" name="pgm_id" id="pgm_id"		value="DSORSHET">
		<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%=facility_id%>">
		<input type='hidden' name='locale' id='locale' value="<%=locale%>"/>
		<input type="hidden" name="tab_id" id="tab_id" value="DietOrderSheet">
		<input type="hidden" name="nd_serv_date" id="nd_serv_date"/>
		<input type="hidden" name="nd_diet_category" id="nd_diet_category"/>
		<input type="hidden" name="nd_fr_meal" id="nd_fr_meal"/>
		<input type="hidden" name="nd_to_meal" id="nd_to_meal"/>
		<input type="hidden" name="nd_fr_meal_class" id="nd_fr_meal_class"/>
		<input type="hidden" name="nd_to_meal_class" id="nd_to_meal_class"/>
		<input type="hidden" name="nd_fr_diet_type" id="nd_fr_diet_type"/>
		<input type="hidden" name="nd_to_diet_type" id="nd_to_diet_type"/>
		<input type="hidden" name="nd_fr_ward_code" id="nd_fr_ward_code"/>
		<input type="hidden" name="nd_to_ward_code" id="nd_to_ward_code"/>
		<input type="hidden" name="selectedAll" id="selectedAll" value="" />
		<INPUT type="hidden" name="isDietReport" id="isDietReport" id="isDietReport" value="<%=isDietReport%>">
	</form>
	<form name="dummy1" id="dummy1">
		<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>">
		<input type="hidden" name="qryStr" id="qryStr" value="">
		<input type="hidden" name="qryHeader" id="qryHeader" value="">
		<input type="hidden" name="header_Details" id="header_Details" value="">
		<input type="hidden" name="noOfCols" id="noOfCols" value="">
		<input type="hidden" name="sql_site_name" id="sql_site_name" value="">
		<input type="hidden" name="sql_facility_name" id="sql_facility_name" value="">
		<input type="hidden" name="sql_report_desc" id="sql_report_desc" value="">
		<input type="hidden" name="p_module_id" id="p_module_id"  value="DS">
		<input type="hidden" name="p_report_id" id="p_report_id" value="DSORSHET">
		<input type='hidden' name='locale' id='locale' value="<%=locale%>">
		<input type='hidden' name='p_patient_id' id='p_patient_id' value="">
	</form>
	<!-- Added Against End KDAH-CRF-0353 US1 -->
</body>
</html>

