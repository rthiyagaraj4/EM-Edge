<!DOCTYPE html>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,java.sql.Statement,eCommon.Common.*"
%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp"%>
<html>
<head>
<%  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
	.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
	:"IeStyle.css" ;
	if(sStyle==null)sStyle="IeStyle.css";
	String facility_id=(String)session.getAttribute("facility_id");
	String locale=(String)session.getAttribute("LOCALE");
	String params = request.getQueryString() ;
	request.setCharacterEncoding("UTF-8");
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<Script language="JavaScript" src="../../eDS/js/MealOrderForStaffs.js"></Script>
	<script language="Javascript" src="../../framework/js/PopupWindow.js"></script>
	<script language="Javascript" src="../../eDS/js/DSCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!--Added Against ML-MMOH-CRF-0674-->
</head>

<body onload="noOfMealOrderReadOnly();" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%

	Connection con=null;
	PreparedStatement stmt=null;
	Statement st = null ;
	ResultSet rs=null;

	String sql = "",current_date="",meal_category_code="",meal_category_description="",diet_type_code="",diet_type_description="",meal_type_code="",meal_type_description="";

	//Added against ML-MMOH-CRF-0419
	String diet_location_code="",diet_location_description="",default_diet_request_location="";
	//Added against ML-MMOH-CRF-0419
		
	//ML-MMOH-CRF-0684_US6
	String menu_type_code = "";
	String menu_type_desc =  ""; 
	//ML-MMOH-CRF-0684_US6
	String sql_curr_date="SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CURRENT_DATE FROM DUAL";
	boolean isMealComplaints = false; //Added Against MMOH-CRF-1125[IN:067026]
	try{
		con	= ConnectionManager.getConnection(request);		
		isMealComplaints = CommonBean.isSiteSpecific(con,"DS","DS_MEAL_COMPLAINTS"); //Added Against CRF-1125		 
		st	= con.createStatement() ;
		rs	= st.executeQuery(sql_curr_date);
		while(rs!=null && rs.next()){
			current_date =com.ehis.util.DateUtils.convertDate(rs.getString("CURRENT_DATE"),"DMY","en",locale);
		}
%>
	<form name="DocumentMealOrderForm" id="DocumentMealOrderForm">
	<table align="center" width="85%" cellpadding="2" cellspacing="0">	
		<%
			//ML-MMOH-CRF-0684
			boolean isMenuType = false;
			isMenuType = CommonBean.isSiteSpecific(con,"DS","DS_MENU_TYPE");
			//ML-MMOH-CRF-0684
		if(isMenuType){%>
		<tr>
		<!-- ML-MMOH-CRF-0684_US6 Starts-->
			<td class ="label" align ="right">
			<fmt:message key="eDS.MenuType.Label" bundle="${ds_labels}"/>
            </td>
			<td>
		       <select name="menuType" id="menuType" id ='menuType' onchange="updateDetails()">
				<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />
			<%
				try{	
			
					String sql_Menu_Count="SELECT count(*) FROM ds_menu_type where eff_status ='E' and appl_for_staff_yn ='Y' AND DEFAULT_YN='Y'";
					stmt = con.prepareStatement(sql_Menu_Count);
					rs	= stmt.executeQuery();
					int defaultcount=0;
					if(rs.next()){
						defaultcount=rs.getInt(1);
					}
					
					String sql_Menu_Type = "SELECT menu_type,short_desc,DEFAULT_YN FROM ds_menu_type where eff_status ='E' and appl_for_staff_yn ='Y' ORDER BY short_desc asc";
					stmt = con.prepareStatement(sql_Menu_Type);
					rs	= stmt.executeQuery();
					while(rs != null && rs.next()){
					menu_type_code=rs.getString(1);
					menu_type_desc=rs.getString(2);
					String temp=rs.getString(3);
					if(defaultcount == 1 && temp.equals("Y"))
					{
				%>
					<option value="<%=menu_type_code%>" selected ><%=menu_type_desc%></option>			
				<%
				}
				else
				{
				%>
			       <option value="<%=menu_type_code%>"><%=menu_type_desc%></option>
			  <%
					}
					}
					}
					catch(Exception e){
						e.printStackTrace();
					}
					finally	{
						if(stmt != null){
							stmt.close();
						}
						if(rs != null){
							rs.close();
						}
					}
				%>
               </select>
			   <img id="menuTypeImage" src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>
			</td>	    
		</tr>
		<%}%>
		<!-- ML-MMOH-CRF-0684_US6 Ends -->
		<tr>
			<td class='label' align="right">
				<fmt:message key="eDS.DietRequestLocation.Label" bundle="${ds_labels}" />
			</td>
			<td class='label' >
					<select name="dietLocation" id="dietLocation" id ='dietLocation' onchange="updateDetails()">
										
						<option value="">
							<fmt:message key="Common.Select.label" bundle="${common_labels}" />
						</option>
					<% try
					      { 
							sql= "SELECT LOCATION_CODE, SHORT_DESC ,DEFAULT_DIET_REQUEST_LOCATION FROM ds_diet_request_loc_lang_vw WHERE language_id = 'en' and eff_status = 'E' ORDER BY 2, 1";//Modified against CRF-0419
		
							stmt=con.prepareStatement(sql);
							rs=stmt.executeQuery();
							if(rs!=null)
							{
							   while(rs.next())
							        {
								        diet_location_code=rs.getString(1);
								        diet_location_description=rs.getString(2);
										//Added against CRF-0419 Starts Here
										default_diet_request_location=rs.getString(3);
										 
					%>			 
								
					              <option value="<%=diet_location_code%>" ><%=diet_location_description%>
					<%
					//Added against CRF-0419 Ends Here
					}
					}
					%>
					</select>
					
			<% }catch(Exception e){
				e.printStackTrace();
			}
			finally{
			try{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			}
			%>
			</td>
		</tr>	
		
		<tr>
			<td class='label' align="right">
					<fmt:message key="eOT.MealOrderFrom.Label" bundle="${ot_labels}" />
			</td>
			<td>
					<input type="text" name="mealOrderFrom" id="mealOrderFrom" value="<%=current_date%>"  size="10" onblur="validDateObj(this,'DMY','en');ComparePeriodFromToTime(this,mealOrderTo);callpractdate();" onkeypress="return Valid_DT(event)" maxlength="10" /><!-- CRF-0419,CRF-0678-->
					<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('mealOrderFrom');callpractdate();"/><!-- CRF-0678-->
					<img src='../../eCommon/images/mandatory.gif'></img>
			</td>

			<td class='label' align="right">
					<fmt:message key="eOT.MealOrderTo.Label" bundle="${ot_labels}" />
			</td>
			<td>
					<input type="text" name="mealOrderTo" id="mealOrderTo" value=""  size="10" onblur="validDateObj(this,'DMY','en');ComparePeriodFromToTime(mealOrderFrom,this);callpractdate();" onkeypress="return Valid_DT(event)" maxlength="10" /><!-- CRF-0419,CRF-0678-->
					<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('mealOrderTo');callpractdate();"/><!-- CRF-0678-->
					<img src='../../eCommon/images/mandatory.gif'></img>
			</td>
		</tr>
		<tr>
				<td class='label' align="right">
					<fmt:message key="eOT.MealCategory.Label" bundle="${ot_labels}" />
				</td>
				<td class='label'>
					<select name="mealCategory" id="mealCategory" onChange="callPractitioner2(this);callpractdate();updateDetails();changeMealType_Doc();"><!--Added callpractdate Against ML-MMOH-SCF-1796-->
						<option value="">
							<fmt:message key="Common.Select.label" bundle="${common_labels}" />
						</option>
		<% try
			  {
				//Modified Against ML-MMOH-CRF-0678
				sql= "SELECT meal_category_code, description FROM ds_meal_category_lang_vw WHERE meal_category_code IN ('STF', 'ONC', 'STU','DOC','OPS') AND (language_id = '"+locale+"') ORDER BY 2, 1";

				stmt=con.prepareStatement(sql);
				rs=stmt.executeQuery();
				if(rs!=null)
				{
				   while(rs.next())
						{
							meal_category_code=rs.getString(1);
							meal_category_description=rs.getString(2);
							%>
						   <option value="<%=meal_category_code%>"><%=meal_category_description%>
					<%  }
			  }%>
						 </select>

					<img src='../../eCommon/images/mandatory.gif'></img>
	<%}catch(Exception e){
		e.printStackTrace();
	  }finally{
	  try{
	    if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		}catch(Exception e){
		e.printStackTrace();
		}
	}
%>			</td>

		</tr>
       <!-- Added Against CRF-0678 Starts Here-->
		<tr id="practName" style="display:none;">
				<td class='label' align="right">
						<fmt:message key="eDS.practitionerName.Label" bundle="${ds_labels}" />					
				</td>				

				<td colspan="4" id = 'practNameDesc'>
					<select name="practdetail" id="practdetail" id="practdetail" onchange="updateDetails()">
						<option value="">
							<fmt:message key="Common.Select.label" bundle="${common_labels}" />
						</option>
									</td>

		</tr>				
		<!-- Added Against CRF-0678 Ends Here-->
		<tr>
				<td class='label' align="right">
					<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}" />
				</td>				

				<td colspan="4">
								<select name="DietType" id="DietType" onchange="updateDetails()" onKeyUp="diettype_Autocomplete();return fecthDietType();" onClick="Select()"><!--Added Against ML-MMOH-CRF-0674-->
									<option value="">
										<fmt:message key="Common.Select.label" bundle="${common_labels}" />
									</option>
		<% try{
				sql= "select DIET_TYPE,SHORT_DESC from DS_DIET_TYPE_LANG_VW where (LANGUAGE_ID='"+locale+"') and (EFF_STATUS='E') and (appl_staff_order_yn = 'Y') order by LOWER (short_desc)";//Added Against ML-MMOH-CRF-0674
				stmt=con.prepareStatement(sql);
				rs=stmt.executeQuery();
				if(rs!=null){
				   while(rs.next()){
						diet_type_code=rs.getString(1);
						diet_type_description=rs.getString(2);
		%>
		   <option value="<%=diet_type_code%>"><%=diet_type_description%>
		<%}
		}%>
			</select>
			<img src='../../eCommon/images/mandatory.gif'></img>
		<%}catch(Exception e){e.printStackTrace();
	}finally{
	try{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	}
	%>
		</td>			
	</tr>
	<tr>
		<td class='label' align="right">
			<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}" />
		</td>
		<td colspan="4" id = 'MealTypeTD'>
			<select name="MealType" id="MealType" onchange="updateDetails()">
				<option value="">
					<fmt:message key="Common.Select.label" bundle="${common_labels}" />
				</option>
	<% try{
			sql= "select MEAL_TYPE,SHORT_DESC from DS_MEAL_TYPE_LANG_VW where (LANGUAGE_ID='"+locale+"') and (EFF_STATUS='E' ) AND (NVL(DOC_MEAL_ORDER_YN, 'N') = 'Y' OR NVL(OPS_MEAL_ORDER_YN, 'N') = 'Y' OR NVL(ONC_MEAL_ORDER_YN, 'N') = 'Y' OR NVL(STF_MEAL_ORDER_YN, 'N') = 'Y' OR NVL(STU_MEAL_ORDER_YN, 'N') = 'Y') order by meal_order";
			//ML-MMOH-CRF-0820 & ML-MMOH-CRF-1006-US3
			stmt=con.prepareStatement(sql);
			rs=stmt.executeQuery();
			if(rs!=null)
			{
			   while(rs.next())
					{
						meal_type_code=rs.getString(1);
						meal_type_description=rs.getString(2);
						%>
					   <option value="<%=meal_type_code%>"><%=meal_type_description%>
				<%  }
		  }%>
		</select>
		<img src='../../eCommon/images/mandatory.gif'></img>
	 <%}catch(Exception e){e.printStackTrace();
	 }finally{
	try{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}catch(Exception e){
		e.printStackTrace();
	}
}
%>
		</td>
	</tr>
	<tr>
		<td class='label' align="right">
			<fmt:message key="eOT.NoOfOrders.Label" bundle="${ot_labels}" />
		</td>
		<td colspan="4">
			<input type="text" onblur="" value="" name="noOfOrders" id="noOfOrders" size="6" maxlength="6" />
			<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
		</tr>
		<tr>
			<td class='label' align="right">
				<fmt:message key="eOT.TotalNoOfMealsServed.Label" bundle="${ot_labels}" />
			</td>
			<td colspan="4">
				<input type="text" onblur="" value="" name="totalNoOfMealsServed" id="totalNoOfMealsServed" size="6" maxlength="6" />
				<img src='../../eCommon/images/mandatory.gif'></img > <!-- Commented for ML-MMOH-CRF-0730-->
			</td>
		</tr>
		<tr>
			<td class='label' align="right">
				<fmt:message key="eOT.NoOfMealsServed.Label" bundle="${ot_labels}" />
			</td>
			<td colspan="4">
				<input type="text" onblur="" value="" name="noOfMealsServed" id="noOfMealsServed" size="6" maxlength="6" onkeypress="chkMealOrderServed()" onblur="chkOrders();" />
				<img src='../../eCommon/images/mandatory.gif'></img>
			</td>
		</tr>
		<!-- Added Start for ML-MMOH-CRF-0730 -->
		<tr>
			<td class='label' align="right">
				<fmt:message key="eDS.TotalNoofmealsreceived.Label" bundle="${ds_labels}" />
			</td>
			<td colspan="4">
				<input type="text" onblur="" value="" name="totalnoOfMealsreceived" id="totalnoOfMealsreceived" size="6" maxlength="6"  />
			</td>
		</tr>
		<tr>
			<td class='label' align="right">
				<fmt:message key="eDS.Noofmealsreceived.Label" bundle="${ds_labels}" />
			</td>
			<td colspan="4">
				<input type="text" onblur="" value="" name="noOfMealsreceived" id="noOfMealsreceived" size="6" maxlength="6" onkeypress="chkMealOrdersReceived()" onblur="chkOrders()"/>
				<img src='../../eCommon/images/mandatory.gif'></img> <!-- Added for ML-MMOH-CRF-0730 -->
			</td>
		</tr>
		<tr>
			<td class='label' align="right" >
				<fmt:message key="eDS.Totalnoofmealsreject.Label" bundle="${ds_labels}" />
			</td>
			<td colspan="4">
				<input type="text" onblur="" value="" name="totalNoOfMealsreject" id="totalNoOfMealsreject" size="6" maxlength="6" />
			</td>
		</tr>
		<tr>
		<td class='label' align="right">
			<fmt:message key="eDS.Noofmealreject.Label" bundle="${ds_labels}" />
		</td> 
		<td colspan="4"  >
			<input type="text"  value="" name="noOfMealsreject" id="noOfMealsreject" id="noOfMealsrejects" size="6" maxlength="6" onkeyup="mealsrejectVisiable()" onkeypress="chkMealOrdersRejected();" />
			<img src='../../eCommon/images/mandatory.gif'></img> <!-- Added for ML-MMOH-CRF-0730 -->
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;					
			
			<span id='complaint' style='visibility:hidden'><font size="2">
			<fmt:message key="eOT.Complaints.Label" bundle="${ot_labels}"/></font>
			&nbsp;&nbsp;&nbsp;&nbsp;		
			
			<input type="text" value="" id="complaintDesc" name="complaintDesc" id="complaintDesc" onblur="if(this.value!='') return complaintsLookup('complaintDesc'); else complaintCode.value=''" onchange="enableOthers();"/>
			<input type="hidden"  value="" name="complaintCode" id="complaintCode" />
			<input type="button" id="bt" class="BUTTON" value="?" onclick="complaintsLookup('complaintDesc')" />
			
			<!-- ML-MMOH-CRF-1125[IN:067026] -->
			<%if(isMealComplaints){%>
			<a id="othersLink" name="othersLink" href="javascript:OtherComplaints()";> Others </a>		
			<input type="hidden" id="othersComp" name="othersComp" id="othersComp" value="" />
			<%}%>
			<!-- ML-MMOH-CRF-1125[IN:067026] -->

		</span>

		</td>				
	</tr>		
		<!-- Added End for ML-MMOH-CRF-0730 -->
		<!-- Added against ML-MMOH-CRF-0684-->
		<input type="hidden" name="isMenuType" id="isMenuType" id ="isMenuType" value="<%=isMenuType%>" />
		<input type="hidden" name="isMealComplaints" id="isMealComplaints" id ="isMealComplaints" value="<%=isMealComplaints%>"> 
		<!-- Added Against MMOH-CRF-1125 -->
		</table>
	<% }catch(Exception e){
	System.err.println("DocumentMealServedCUD.jsp==============="+e);
	e.printStackTrace();
	}finally{
	try{
		if(rs!=null) rs.close();
		if(st!=null) st.close();
		ConnectionManager.returnConnection(con);
	}catch(Exception e){
		e.printStackTrace();
	}
	}
%> 
		<input type='hidden' name='mode' id='mode'/>
		<input type='hidden' name='locale' id='locale'  value='<%=locale%>' />
		<input type='hidden' name='moduleId' id='moduleId'  value="DS" />
		<input type='hidden' name='functionId' id='functionId' value="DS_MEAL_ORDER_STAFF"/>
		<input type='hidden' name='viewCode' id='viewCode' value="mealOrderFrame" />
		<input type='hidden' name='recordId' id='recordId' />
		<input type='hidden' name='recordOrderLineNum' id='recordOrderLineNum' />
		<input type='hidden' name='rowId' id='rowId' />
		<input type='hidden' name='params' id='params' value='<%=params%>' >
		<input type="hidden" name="facilityId" id="facilityId" value="<%=facility_id%>" />
		<input type="hidden" name="current_date" id="current_date" value="<%=current_date%>" /> <!--Added Against ML-MMOH-SCF-1796 -->
		<input type="hidden" name="locale" id="locale" value="<%=locale%>" />
		<input type="hidden" name="datepattern" id="datepattern" value="dd/MM/yyyy" />
		<input type="hidden" name="tabId" id="tabId" value="mealServedTab"/>
		<INPUT type="hidden" name="diettype_auto" id="diettype_auto" id="diettype_auto" value=""><!-- Added against ML-MMOH-CRF-0674-->
		<INPUT type="hidden" name="auto_flag" id="auto_flag" id="auto_flag" value="false"><!-- Added against ML-MMOH-CRF-0674-->
		</form>
	</body>
</html>

