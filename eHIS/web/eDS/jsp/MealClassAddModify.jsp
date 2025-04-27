<!DOCTYPE html>
<%@page import="eDS.Common.DlQuery,eCommon.Common.CommonBean,eOT.*,eOT.Common.*,java.util.*,java.util.concurrent.ConcurrentHashMap,java.util.TreeMap,java.util.HashMap,java.util.LinkedHashMap,java.sql.*"%>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eDS.*,eDS.MealClassServlet" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% 
	String locale = (String)session.getAttribute("LOCALE");
%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<jsp:useBean id="DSCommonBeanObj" class="eDS.DSCommonBean"/>
<jsp:setProperty name="DSCommonBeanObj" property="FacilityId" value='<%=session.getAttribute("facility_id").toString()%>'/> <!--Added Against ML-MMOH-CRF-1005-US1 -->
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eDS/js/MealClass.js'></script>
<script language='javascript' src='../../eDS/js/DSCommon.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onload="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<% 
	String mealClass = "";
	String shortDesc = "";
	String longDesc = "";
	String enabledYn = "";
	String mealClassCode = request.getParameter("mealClass");	
	String disabled_flag = "";
	String readOnlyFlag = "";
	String applstafforder_yn="";//ML-MMOH-CRF-0419-US8
	String editmenuappl_yn ="";//ML-MMOH-CRF-0669-US1
	String attdntorderappl_yn ="";//ML-MMOH-CRF-1005-US1
	//ML-MMOH-CRF-0673
	String bedClassCode ="";
	//ML-MMOH-CRF-0673
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
	String mode = request.getParameter("mode");
	//ML-MMOH-CRF-0673
	try{
	TreeMap<String,String> mealMap = new TreeMap<String,String>();
	ConcurrentHashMap<String,String> bedMap = DSCommonBeanObj.getBedClass(locale);
	TreeMap<String,String> Temp_map = new TreeMap<String,String>();
	//TreeMap<String,String> Check_map = new TreeMap<String,String>();
	TreeMap<String,String> initMealMap = new TreeMap<String,String>();
	String chk1="";
	String disabled="";
	//ArrayList<String> codesList = new ArrayList<String>(); // checkstyle
	Set<String> tempSet = new HashSet<String>();
	HashMap<String,String> getmealMap = DSCommonBeanObj.getMealClass();	
	//ML-MMOH-CRF-0673
   if("modify".equals(mode)){
   		try{
   			disabled_flag = "disabled";
   			readOnlyFlag = "readonly";
	   		con = ConnectionManager.getConnection(request);
	   		pstmt = con.prepareStatement(DlQuery.DL_GET_MEAL_CLASS);
	   		pstmt.setString(1,mealClassCode);
	   		rst = pstmt.executeQuery();
			while(rst.next()){
	   			mealClass = rst.getString("meal_class");
	   			longDesc = rst.getString("long_desc");
				shortDesc = rst.getString("short_desc");
				enabledYn = rst.getString("eff_status");
				applstafforder_yn = rst.getString("appl_staff_order_yn"); //ML-MMOH-CRF-0419-US8
				editmenuappl_yn =rst.getString("EDIT_MENU_APPL_YN");//ML-MMOH-CRF-0669-US1
				bedClassCode =rst.getString("BED_CLASS_CODE");//ML-MMOH-CRF-0673
				attdntorderappl_yn =rst.getString("APPL_ATT_YN");//ML-MMOH-CRF-1005-US1
	   		}
			//ML-MMOH-CRF-0673
			
			if(bedClassCode !=null){
			String[] myStrArr = bedClassCode.split(",");
			for( int i=0 ; i<myStrArr.length ; i++){
				String str_ip_bed_class=  "SELECT BED_CLASS_CODE,SHORT_DESC FROM IP_BED_CLASS_LANG_VW WHERE EFF_STATUS = 'E' AND LANGUAGE_ID = ? AND BED_CLASS_CODE=? ORDER BY 2 ";
				pstmt = con.prepareStatement(str_ip_bed_class);			
		   		pstmt.setString(1,locale);
		   		pstmt.setString(2,myStrArr[i]);
		   		rst = pstmt.executeQuery();
	   		while(rst.next()){
				mealMap.put(rst.getString("BED_CLASS_CODE"),rst.getString("SHORT_DESC"));
				}		
			} 			
			Temp_map.putAll(mealMap);
			mealMap.putAll(bedMap);
			}			
			//ML-MMOH-CRF-0673
			
			for (String temp : getmealMap.values()) { // Part-1
			StringTokenizer st = new StringTokenizer(temp, ",");
			String[] tempArr = new String[st.countTokens()];

			for (int i = 0; i < tempArr.length; i++) {
				tempArr[i] = st.nextToken();
				tempArr[i] = tempArr[i].trim();
				tempSet.add(tempArr[i].toString());
			}
			}
			for (String tempString : tempSet){ // Part-2
			StringTokenizer st1 = new StringTokenizer(tempString, ",");
			String[] myStrArr = new String[st1.countTokens()];
			for( int j=0 ; j<myStrArr.length ; j++){
				myStrArr[j] = st1.nextToken();
				myStrArr[j] = myStrArr[j].trim();
				String str_ip_bed_class=  "SELECT BED_CLASS_CODE,SHORT_DESC FROM IP_BED_CLASS_LANG_VW WHERE EFF_STATUS = 'E' AND LANGUAGE_ID = ? and bed_class_code=? ";
				pstmt = con.prepareStatement(str_ip_bed_class);			
		   		pstmt.setString(1,locale);
		   		pstmt.setString(2,myStrArr[j]);
		   		rst = pstmt.executeQuery();
	   		while(rst.next()){
				initMealMap.put(rst.getString("BED_CLASS_CODE"),rst.getString("SHORT_DESC"));
				}		
			}
		}  // Part-2 ending 
  	}catch(Exception e){
	   		System.err.println("100,Error in Modify Mode Meal Class->"+e);
			e.printStackTrace();
   		}
   		finally{
   			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}catch(Exception e){
				System.err.println("110,Exception in Meal Class:"+e);
				e.printStackTrace();
			}
   		}
   }else{
   		try{
   			con = ConnectionManager.getConnection(request);
			for (String temp : getmealMap.values()) {
			StringTokenizer st = new StringTokenizer(temp, ",");
			String[] tempArr = new String[st.countTokens()];
			for (int i = 0; i < tempArr.length; i++) {
				tempArr[i] = st.nextToken();
				tempArr[i] = tempArr[i].trim();
				tempSet.add(tempArr[i].toString());
			}
				}
			for(String tempString : tempSet) {
			StringTokenizer st1 = new StringTokenizer(tempString, ",");
			String[] myStrArr = new String[st1.countTokens()];
			for( int j=0 ; j<myStrArr.length ; j++){
				myStrArr[j] = st1.nextToken();
				myStrArr[j] = myStrArr[j].trim();
				String str_ip_bed_class=  "SELECT BED_CLASS_CODE,SHORT_DESC FROM IP_BED_CLASS_LANG_VW WHERE EFF_STATUS = 'E' AND LANGUAGE_ID = ? and bed_class_code=? ";
				pstmt = con.prepareStatement(str_ip_bed_class);			
		   		pstmt.setString(1,locale);
		   		pstmt.setString(2,myStrArr[j]);
		   		rst = pstmt.executeQuery();
	   		while(rst.next()){
				initMealMap.put(rst.getString("BED_CLASS_CODE"),rst.getString("SHORT_DESC"));
				}		
			}
		 }
		}catch(Exception e){
	   		System.err.println("170,Error in Meal Class->"+e);
			e.printStackTrace();
   		}
   		finally{
   			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}catch(Exception e){
				System.err.println("179,Exception in Meal Class:"+e);
				e.printStackTrace();
			}
   		}
}  
%>
		<br>
		<form name="mealClass_form" id="mealClass_form"  onload='FocusFirstElement()'  action="../../servlet/eDS.MealClassServlet" method="post" target="messageFrame">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
				<tr>
					<td class='label' align="right">
						<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="mealClass" id="mealClass" value="<%=mealClass %>" onkeypress="restrictSpecialChars(event)" size="4" maxlength="2" onkeyup="setFieldToUpperCase(this)"  onkeypress="return checkAlpha(event)" <%=disabled_flag %>/>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<tr>
					<td class='label' align="right">
						<fmt:message key="eOT.LongDescription.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="longDesc" id="longDesc" value="<%=longDesc %>"  onkeypress="restrictSpecialChars(event)" size="30" maxlength="30" />
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.ShortDescription.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="shortDesc" id="shortDesc" value="<%=shortDesc %>" onkeypress="restrictSpecialChars(event)" size="15" maxlength="15" />
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>

				<!-- ML-MMOH-CRF-0419-US8 Starts-->
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eDS.ApplForStaffOrder.Label" bundle="${ds_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){
							if("Y".equals(applstafforder_yn)){
							%>
								<input type="checkbox" name="applstafforder_yn" id="applstafforder_yn"  checked="checked"/>
							<%}
							else{
							%>
								<input type="checkbox" name="applstafforder_yn" id="applstafforder_yn"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="applstafforder_yn" id="applstafforder_yn" checked="checked" />
						<%} %>
					</td>
				</tr>
				<!-- ML-MMOH-CRF-0669-US1 Starts-->
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eDS.ApplicableEditMenu.Label" bundle="${ds_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){
							if("Y".equals(editmenuappl_yn)){
							%>
								<input type="checkbox" name="editmenuappl_yn" id="editmenuappl_yn"  checked="checked"/>
							<%}
							else{
							%>
								<input type="checkbox" name="editmenuappl_yn" id="editmenuappl_yn"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="editmenuappl_yn" id="editmenuappl_yn" checked="checked" />
						<%} %>
					</td>
				</tr>
					<!-- ML-MMOH-CRF-0669-US1 Ends-->
					<!-- ML-MMOH-CRF-1005-US1 Starts Here-->
				<tr>
					<td align="right" class='label'>
					<fmt:message key="eDS.ApplicableFor.Label" bundle="${ds_labels}"/>
					<option><%=DSCommonBeanObj.getAttendantLabel()%></option>
					</td>
					<td>
						<%if("modify".equals(mode)){
							if("Y".equals(attdntorderappl_yn)){
							%>
								<input type="checkbox" name="attdntorderappl_yn" id="attdntorderappl_yn"  checked="checked"/>
							<%}
							else{
							%>
								<input type="checkbox" name="attdntorderappl_yn" id="attdntorderappl_yn"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="attdntorderappl_yn" id="attdntorderappl_yn"  checked="checked"/>
						<%} %>
					</td>
				</tr>
				<!-- ML-MMOH-CRF-1005-US1 Ends Here-->
					
				<!--Added Start Against 673 CRF-->	
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eDS.DefaultMealClassforBedClasses.Label" bundle="${ds_labels}"/>
					</td>
					<td>
					<div id="MealClassCheck" style="visibility:visible;overflow:auto;height: 20vh;width: 300px;border: 1px outset white" align="left" >
					<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
					<tr>
					<td>
					<%if("modify".equals(mode)){						
					int j = 0;
					boolean value1 = Temp_map.isEmpty();
					if(value1==true){
					 for (String keymap : bedMap.keySet()) {  //Part-3
						if(initMealMap.containsKey(keymap)){			
							disabled="disabled";	
						}
					%>
					<input id="bedClassId<%=j%>" name="check" type="checkbox" value="<%=keymap%>" <%=disabled%>  onclick="checkValue(this)";/><%=bedMap.get(keymap)%><BR>	
					<%j++;
					disabled="";	
					}
					}else{
					mealMap.putAll(bedMap);
					for(String key : mealMap.keySet()){
					
					if(Temp_map.containsKey(key)){
							chk1="checked";
					}else if(initMealMap.containsKey(key)){			
							disabled="disabled";	
					}
					%>
					<input id="bedClassId<%=j%>" name="check" type="checkbox" value="<%=key%>" <%=chk1%>  <%=disabled%> onclick="checkValue(this)";/><%=mealMap.get(key)%><BR>	
					<%j++;
					chk1="";
					disabled="";
					}
					}
					}
					else{ %>
					<!-- Insert mode -->
					<%
					int i = 0;
					for(String key : bedMap.keySet()){
					if(initMealMap.containsKey(key)){			
					disabled="disabled";
					}
					%>
					<input id="bedClassId<%=i%>" name="check" type="checkbox" value="<%=key%>" <%=disabled%> onclick="checkValue(this)";/><%= bedMap.get(key)%><BR>
					<input type="hidden" id="bedclassValue<%=i%>" name="bedClassValue<%=i%>" value="<%=key%>">
					</td>
					</tr>
					<% //i++;
					disabled="";
						}
					}
					%>
					</table>
					</div>
					</td>
				</tr>
				<!--Added End Against 673 CRF-->
				<tr>
				<td align="right" class='label'>
						<fmt:message key="eOT.Enabled.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){
							if("E".equals(enabledYn)){
							%>
								<input type="checkbox" name="enabledYn" id="enabledYn"  checked="checked"/>
							<%}
							else{
							%>
								<input type="checkbox" name="enabledYn" id="enabledYn"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="enabledYn" id="enabledYn"  checked="checked"/>
						<%} %>
					</td>
			</tr>
			</table>
						<%}catch(Exception e){
							System.err.println("e====="+e.getMessage());
							e.printStackTrace();
						}
						finally
						{
							try{						
							}
								catch(Exception ee){
								ee.printStackTrace();	
							}
						}
						%>
			<input type='hidden' name='locale' id='locale' value="<%=locale%>">
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'> 
			<input type='hidden' name='updMealClass' id='updMealClass' value='<%=mealClass%>'>
			<input type='hidden' name="bedClassCode" id="bedClassCode" value=""/>
		</form>
	</body>
</html>


