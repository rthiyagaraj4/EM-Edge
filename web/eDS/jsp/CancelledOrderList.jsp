<!DOCTYPE html>
<!--
File Name		: CancelledOrderList.jsp
CRF#			: PMG2013-CRF-0009.1[IN050329]
Author			: Selvin Manoharan
Date			: Nov-2018
-->
<%@ page import="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,java.util.ArrayList,java.util.Collections,java.util.Comparator,java.util.HashMap,java.util.List,java.util.Map,java.util.Set,java.util.Map.Entry,eCommon.Common.CommonBean,java.util.Map,java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<jsp:useBean id="DSCommonBeanObj" class="eDS.DSCommonBean"/> 
<head>
<%
	String locale = (String)session.getAttribute("LOCALE");
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
	.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
	:"IeStyle.css" ;
	if(sStyle==null)sStyle="IeStyle.css";
	String facility_id=(String)session.getAttribute("facility_id");
%>
	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src='../../eCommon/js/messages.js' language='javascript'></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script Language="JavaScript" src="../../eDS/js/CancelledOrderList.js"></script>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rst=null;
	boolean isMultiDietType =false; //Added By Gaurav Against MMS-KH-SCF-0207
	String sql="",servingDate="",patient_id_length="";
try{
		HashMap<String,String> kitchenMap = DSCommonBeanObj.getKitchenQuery(locale,facility_id);		
		Set<Entry<String, String>> kitchenSet = kitchenMap.entrySet();
        List<Entry<String, String>> kitchenList = new ArrayList<Entry<String, String>>(kitchenSet);		
		Collections.sort(kitchenList,new Comparator<Map.Entry<String,String>>()
		{
			public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2){
				return (o1.getValue().compareTo(o2.getValue()) );				
			}
		});
		
		HashMap<String,String> MealClassMap = DSCommonBeanObj.getMealClassValues(locale);
		Set<Entry<String, String>> mealClassSet  = MealClassMap.entrySet();
		List<Entry<String, String>> mealClassList = new ArrayList<Entry<String, String>>(mealClassSet);
		Collections.sort(mealClassList, new Comparator<Map.Entry<String, String>>()
		{
			public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2){
				return (o1.getValue().compareTo(o2.getValue()) );
			}				
		});
		
		HashMap<String,String> dietTypeMap = DSCommonBeanObj.getDietType(locale);
		Set<Entry<String, String>> dietTypeSet = dietTypeMap.entrySet();
		List<Entry<String, String>> dietTypeList = new ArrayList<Entry<String, String>>(dietTypeSet);
		Collections.sort(dietTypeList, new Comparator<Map.Entry<String, String>>(){
			public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2){
				return (o1.getValue().compareTo(o2.getValue()) );
			}			
		}
		);
	
		conn = ConnectionManager.getConnection(request);	
		isMultiDietType = CommonBean.isSiteSpecific(conn,"DS","DS_MULTI_DIET_TYPES"); //Added By Gaurav Against MMS-KH-SCF-0207
		pstmt = conn.prepareStatement("SELECT to_char(SYSDATE,'dd/mm/yyyy') CURRENT_DATE FROM DUAL");
		rst = pstmt.executeQuery();
		while(rst.next()){
			servingDate = rst.getString("CURRENT_DATE");
		}
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();	
%>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<br>
		<form name="CancelledOrderList" id="CancelledOrderList" target="messageFrame" method="POST">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>

		   <tr>
			  <td class="label">
				  <fmt:message key="Common.Order.label" bundle="${common_labels}" />				  <fmt:message key="Common.Cancellation.label" bundle="${common_labels}" />			  <fmt:message key="Common.from.label" bundle="${common_labels}" />
			  </td>
			  <td class='label'>
			  <input type="text" name="fromDate" id="fromDate" maxlength="10" size="10" value="<%=servingDate%>" onkeypress="return checkForSpecCharsforID(event);" onblur='validDateObj(this,"DMY","<%=locale%>");'>
			  <img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('fromDate');">
			  <img src='../../eCommon/images/mandatory.gif' />
			  </td>
				              
		  </tr>
		  <tr>
				  <td class="label">
					  <fmt:message key="Common.Order.label" bundle="${common_labels}" /> <fmt:message key="Common.Cancellation.label" bundle="${common_labels}" />	<fmt:message key="Common.to.label" bundle="${common_labels}" />
				  </td>
				  <td class='label'>
					<input type="text" name="toDate" id="toDate" maxlength="10" size="10" value="<%=servingDate%>" onkeypress="return checkForSpecCharsforID(event);" onblur='validDateObj(this,"DMY","<%=locale%>");'>
				  <img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('toDate');">
				  <img src='../../eCommon/images/mandatory.gif' />
				  </td>           
		  </tr>
          <tr>
				<td class="label">
					  <fmt:message key="eDS.Kitchen.Label" bundle="${ds_labels}" />					
				</td>
				<td class='label'>
						<select name="kitchenCode" id="kitchenCode" onchange="getWards(this.value);">
							<option value="">							
								<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
							</option>
							<%for(Map.Entry<String, String> entry : kitchenList){%>
							<option value="<%=entry.getKey()%>"> <%=entry.getValue()%>
							<%}%>
						</select>	
					<img src='../../eCommon/images/mandatory.gif' />	
				</td>
     	</tr>
		<tr>	
			<td class="label">
				<fmt:message key="Common.Ward.label" bundle="${common_labels}"/>
			</td>
			<td class='label'>	
			<%if(isMultiDietType){%>
				<select name="ward" id="ward" onchange="selectAll(this.value)"><!-- Changes against ML-MMOH-CRF-1818 -->
			<%}else{%>	
				<select name="ward" id="ward" onchange="selectAll(this.value)" multiple style="height: auto; overflow: auto; min-width: 9vw;"> 
			<%}%>
					<option value="">   <!-- modified against ML-MMOH-CRF-1818-->
				      <fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
				   </option>
				</select>
			</td>
		</tr>	
		<tr>	
				<td class="label">
					<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}" />
				</td>					
				<td class="label" >
					<select name="mealClass" id="mealClass">
						<option value="">
						<fmt:message key="eDS.select.Label" bundle="${ds_labels}"/>
						</option>
							
							<%for(Map.Entry<String, String> entry : mealClassList){%>
						<option value="<%=entry.getKey()%>"> <%=entry.getValue()%>
							<%}%>
					</select>
				</td>				
			</tr>		
		<tr>
				<td class="label">
					<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}" />
				</td>			
				<td class="label" id="dietType">
					<select name="dietType" id="dietType">
						<option value="">
						<fmt:message key="eDS.select.Label" bundle="${ds_labels}"/>
						</option>
						<%for(Map.Entry<String, String> entry : dietTypeList){%>
						<option value="<%=entry.getKey()%>"> <%=entry.getValue()%>
						<%}%>
					</select>
				</td>				
		</tr>
		<tr>
			<td class="label">
					<fmt:message key="Common.ReasonforCancellation.label" bundle="${common_labels}"/>
			</td>
			<td class="label">
				<input type="text" value="" id="complaintDesc" name="complaintDesc" id="complaintDesc" onblur="if(this.value!='') return complaintsLookup('complaintDesc'); else complaintCode.value=''"/>
				<input type="hidden"  value="" name="complaintCode" id="complaintCode" />
				<input type="button" id="bt" class="BUTTON" value="?" onclick="complaintsLookup('complaintDesc')" />
		   </td>
			
		</tr><%
				try
				{
					sql ="select patient_id_length from MP_PARAM where MODULE_ID='MP'";
					pstmt = conn.prepareStatement(sql);
					rst = pstmt.executeQuery();
					while(rst.next()){
						patient_id_length = rst.getString("patient_id_length");
					}
					if(rst!=null)rst.close();
					if(pstmt!=null)pstmt.close();	
				}catch(Exception e){
				  e.printStackTrace();
				}finally{
					  if(rst !=null) rst.close();
					  if(pstmt !=null) pstmt.close();
					  }
		%>
		
		 <tr>
		   <td class="label">
				<fmt:message  key="Common.patientId.label"bundle="${common_labels}"/>  
		   </td>
			<td class="label">
			<input type=text  onblur="ChangeUpperCase(this);" name='patientId' id='patientId' size="20" maxlength="<%=patient_id_length%>" onkeypress="return CheckForSpecChars(event)" align="center">
			<input type='button' name='patient_id' id='patient_id' value='?' class='button' onclick='callSearchScreen();'>
			</td>
     </tr>

<%
		}catch(Exception e){
				e.printStackTrace();
		}finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(conn);
			}catch(Exception e){
				e.printStackTrace();
			}	
		}
%>		
		<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
		</table>
				<hidden property="method"/>
				<hidden property="moduleId" value="DS"/>
				<INPUT type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
				<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= session.getValue( "login_user" ) %>"/>			
				<input type="hidden" name="p_module_id" id="p_module_id" value="DS">						
				<input type='hidden' name='locale' id='locale' value='<%=locale%>'>				
				<input type='hidden' name='p_report_id' id='p_report_id' value="DSCANORDS">				
				<input type='hidden' name='P_Diet_Type' id='P_Diet_Type' value=''>
				<input type='hidden' name='P_Meal_Class' id='P_Meal_Class' value=''>
				<input type='hidden' name='P_Meal_Type' id='P_Meal_Type' value=''>
                <input type="hidden" id="selectedAll" name="selectedAll" id="selectedAll" value="" />
</form>
</body>
</html>

