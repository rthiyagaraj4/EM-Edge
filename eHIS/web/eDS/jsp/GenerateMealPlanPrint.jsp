<!DOCTYPE html>
<%@  page import ="java.util.*,java.util.HashMap,java.sql.*,java.net.*,eCommon.Common.*,webbeans.eCommon.ConnectionManager,eDS.DSCommonBean,eDS.*" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<jsp:useBean id="DSCommonBeanObj" class="eDS.DSCommonBean"/>
<jsp:setProperty name="DSCommonBeanObj" property="FacilityId" value='<%=session.getAttribute("facility_id").toString()%>'/>
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
<script language='javascript' src='../../eDS/js/jquery-latest.js'></script>
<script type="text/javascript">

function getSysForGenerateMealPlanDate(){
	var locale = document.getElementById("locale").value;
}

function setListNoValue(obj1){
   var formObj = document.forms[0];
   var locale = document.getElementById("locale").value;
   
   if(obj1.value == 'EL')
		formObj.listNo.disabled = true;
	else
		formObj.listNo.disabled = false;
		var listType = obj1.value;
		var servingDate = formObj.servingDate.value;
		var facility = formObj.p_facility_id.value;
		var p_language_id = formObj.p_language_id.value;
		var obj = formObj.listNo;

		while(obj.length > 0){
			obj.remove(0);
		}
	
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		var params = "func_mode=getmealPlanSeqNo&facility="+facility+"&servingDate="+convertDate(servingDate,'DMY',locale,'en');
		xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		if(retVal!=''){
			var retValArr = retVal.split("???");
			var mealPlanSeqNo = "";
			if(retValArr!=''){
				var listOption1	= document.createElement('OPTION');
				var msg = "----select----"
				listOption1.text = msg;
				listOption1.value= "";
				obj.add(listOption1);
				for(var i=0; i<retValArr.length; i++){
					mealPlanSeqNo = retValArr[i].split(":::");
					var listOption1	= document.createElement('option');
					var msg = "----select----"
					listOption1.text = msg;
					listOption1.value= "";					
					listOption1.value = mealPlanSeqNo[1];
					listOption1.text = mealPlanSeqNo[0];					
					obj.add(listOption1);				
				}					
			}
		}
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
	boolean isMenuType =false;//KDAH-CRF-0352
	boolean isMultiDietType =false; //Added By Gaurav Against MMS-KH-SCF-0207
	ResultSet rst=null;
	String facility_id  = (String) session.getValue("facility_id");	
	String locale = (String) session.getValue("LOCALE");
	HashMap<String,String> feedMap = DSCommonBeanObj.getFeedType(locale);//KDAH-CRF-0352
	String login_user = "";
	java.util.Properties prop;
	prop = (java.util.Properties) session.getValue( "jdbc" );
	login_user = prop.getProperty( "login_user" );
	
	String sql="";
	String strCode="";
	String strDesc="";
	String servingDate="";

	try{

		conn = ConnectionManager.getConnection(request);
		//KDAH-CRF-0352	
        	isMenuType = CommonBean.isSiteSpecific(conn,"DS","PLACE_ORDER_FOR_ATTENDANT");
		//KDAH-CRF-0352
		//Added by Santhosh for ML-MMOH-SCF-2331 
		boolean isSpecialDiet = false;
		isSpecialDiet = CommonBean.isSiteSpecific(conn,"DS","SPECIAL_DIET_CATEGORY");
		isMultiDietType = CommonBean.isSiteSpecific(conn,"DS","DS_MULTI_DIET_TYPES"); //Added By Gaurav Against MMS-KH-SCF-0207
			
		pstmt = conn.prepareStatement("SELECT to_char(SYSDATE,'dd/mm/yyyy') CURRENT_DATE FROM DUAL");
		rst = pstmt.executeQuery();
		while(rst.next()){
			servingDate = com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
		}
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();

%>
		<table border='0' cellpadding='2' cellspacing='0' width='40%' align='left'>
		<tr>
				<td align="left" class='label'>
					<fmt:message key="eOT.ServingDate.Label" bundle="${ot_labels}"/>
				</td>
				<td align="left" class='label'>
					<input type="text" name="servingDate" id="servingDate" id="servingDate" maxlength="10" size="10" value="<%=servingDate%>" onkeypress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);checkDateValidate(this)'>
								<img src="../../eCommon/images/CommonCalendar.gif"  name='imagemonth' onClick="return showCalendar('servingDate');">
					<img src='../../eCommon/images/mandatory.gif' />
				</td>
		</tr>

		<tr>
				<td align="left" class='label'> <fmt:message key="eOT.DietCategory.Label" bundle="${ot_labels}"/>   	</td>
				<td align="left" class='label'>
					<select name="dietCategory" id="dietCategory"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
						try
						{						
						  sql ="SELECT  DIET_CATEGORY_CODE,ds_get_desc.ds_diet_category(DIET_CATEGORY_CODE,'"+locale+"',1) SHORT_DESC FROM ds_diet_category";
								pstmt=conn.prepareStatement(sql);
								rst = pstmt.executeQuery();
								while(rst.next()){
								strCode = rst.getString(1);
								strDesc =  rst.getString(2);
								
						if(isSpecialDiet){//Added by Santhosh for ML-MMOH-SCF-2331
								if(!strCode.equals("SD01")){%>
									<option value="<%=strCode%>"><%=strDesc%></option>
								<%}
							} else{ %>
									<option value="<%=strCode%>"><%=strDesc%></option>
							<%}
						}
						}
						catch(Exception  DCat)
						{
							  System.out.println("DS generateMeal plan "+DCat);
						}
						finally
						{
						   if(rst !=null) rst.close();
						   if(pstmt !=null) pstmt.close();
						}
				%>
				</td>
			</tr>

			<tr>
				<td align="left" class='label'>
						<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}"/>
				</td>
				<td align="left" class='label'>
				<select name="mealType" id="mealType"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
					try
					{					
						sql ="select MEAL_TYPE,ds_get_desc.ds_meal_type(MEAL_TYPE,'"+locale+"',2) From  ds_meal_type where eff_status='E' order by meal_order";
						pstmt=conn.prepareStatement(sql);
						rst = pstmt.executeQuery();
						while(rst.next()){
						strCode = rst.getString(1);
						strDesc =  rst.getString(2);
				%>
				<option value="<%=strCode%>"><%=strDesc%></option>
				<%}
					}
					  catch(Exception DCat)	  {}
					  finally
					   {
						   if(rst !=null) rst.close();
						   if(pstmt !=null) pstmt.close();
					   }
				%>
				</td>
			</tr>
			<%if(!isMenuType) { %> 
			<!-- KDAH-CRF-0352 Start -->
			<tr>
				<td align="left" class='label'>
					<fmt:message key="eOT.FeedType.Label" bundle="${ot_labels}" />
				</td>
				<td align="left" class='label'>
					<select name="feedType" id="feedType" id="feedType">
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
					try
					{								
						for (String keymap : feedMap.keySet()) {					
					%>
					<option value="<%=keymap%>"><%=feedMap.get(keymap)%></option>
					<%}%>
					</select>
				</td>
				<%
						}
						  catch(Exception ft)	  {
							  ft.printStackTrace();
							  }
						   finally
						   {
							   if(rst !=null) rst.close();
							   if(pstmt !=null) pstmt.close();
						   }
					%>
			</tr>
			<!-- KDAH-CRF-0352 End -->
			<%}%>
			<tr>
				<td align="left" class='label'>
					<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}"/>
				</td>
				<td align="left" class='label'>
					<select name="mealClass" id="mealClass">
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
					try
					{
						sql = "SELECT MEAL_CLASS, ds_get_desc.ds_meal_class(MEAL_CLASS,'"+locale+"',2)  FROM DS_MEAL_CLASS where EFF_STATUS='E'";
							pstmt=conn.prepareStatement(sql);
							rst = pstmt.executeQuery();
							while(rst.next()){
							strCode = rst.getString(1);
							strDesc =  rst.getString(2);
				%>
				<option value="<%=strCode%>"><%=strDesc%></option>
				<%}
					}
					catch(Exception DCat)	  {}
					finally
					{
						if(rst !=null) rst.close();
						if(pstmt !=null) pstmt.close();
					}
				%>
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
					try
					{
						sql ="SELECT DIET_TYPE,DS_GET_DESC.DS_DIET_TYPE(DIET_TYPE,'"+locale+"',2) from  DS_DIET_TYPE WHERE EFF_STATUS='E'" ;
						pstmt=conn.prepareStatement(sql);
						rst = pstmt.executeQuery();
						while(rst.next()){
						strCode = rst.getString(1);
						strDesc =  rst.getString(2);
				%>
				<option value="<%=strCode%>"><%=strDesc%></option>
				<%}
					}
					catch(Exception DCat)	  {}
					   finally
						   {
							   if(rst !=null) rst.close();
					     	   if(pstmt !=null) pstmt.close();
						   }
				%>
				</select>
				</td>
			</tr>

			<tr>
				<td align="left" class='label'>
				<fmt:message key="eOT.FreqBased.Label" bundle="${ot_labels}"/>
				</td>
				<td  align="left" class='label'>
					<input type="checkbox" name="frequencyYn" id="frequencyYn" value="on">
				</td>
			</tr>

			<tr>
				<td align="left" class='label'>
				<fmt:message key="eOT.NursingUnit.Label" bundle="${ot_labels}"/>
				</td>
				<td align="left" class='label'>
					<select name="nursingUnit" id="nursingUnit"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
					try
					{
						sql ="SELECT NURSING_UNIT_CODE ,SHORT_DESC  FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E'";
						pstmt=conn.prepareStatement(sql);
						rst = pstmt.executeQuery();
						while(rst.next()){
						strCode = rst.getString(1);
						strDesc =  rst.getString(2);
				%>
				<option value="<%=strCode%>"><%=strDesc%></option>
				<%}
					}
					  catch(Exception DCat)	  {}
					   finally
					   {
						   if(rst !=null) rst.close();
							if(pstmt !=null) pstmt.close();
					   }
				%>
				</td>
			</tr>

			<tr>
				<td align="left" class='label'>
					<fmt:message key="eOT.DietCategory.Label" bundle="${ot_labels}"/>
				</td>
				<td  align="left" class='label'>
						<select name="listType" id="listType"  onChange='setListNoValue(this);'>
						<option value="EL">
							<fmt:message key="eDS.entireList.Label" bundle="${ds_labels}"/>
						</option>
						<option value="SL">
							<fmt:message key="eDS.specificList.Label" bundle="${ds_labels}"/>
						</option>
						</select>
						<fmt:message key="eDS.listNo.Label" bundle="${ds_labels}"/>
						<select name="listNo" id="listNo" disabled>
							<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
						</select>
				</td>
			</tr>
		</table>
		<%
		}
		catch(Exception e){
			e.printStackTrace();
			out.println(e);
		}finally{
		if(conn!=null)
			ConnectionManager.returnConnection(conn, request);
		}
		%>

		<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
		<input type="hidden" name="p_user_id" id="p_user_id"		value="<%=login_user%>">
		<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=login_user%>">
		<input type="hidden" name="p_user" id="p_user"		value="<%=login_user%>"><!--55878-->
		<input type="hidden" name="p_module_id" id="p_module_id"		value="DS">
		<input type="hidden" name="p_report_id" id="p_report_id"		value="DSRSTDMT">
		<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
		<input type="hidden" name="pgm_id" id="pgm_id"		value="DSRSTDMT">
		<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%=facility_id%>">
		<input type='hidden' name='locale' id='locale' value="<%=locale%>"/>
		<input type="hidden" name="tab_id" id="tab_id" value="GenerateMealPlanPrint">
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
		<input type="hidden" name="P_MEAL_PLAN_SEQ_NO" id="P_MEAL_PLAN_SEQ_NO"/>
		<input type="hidden" name="selectedAll" id="selectedAll" value="" />
		<INPUT type="hidden" name="isMenuType" id="isMenuType" id="isMenuType" value="<%=isMenuType%>">
	</form>
</body>
</html>

