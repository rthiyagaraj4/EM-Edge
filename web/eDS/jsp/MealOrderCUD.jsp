<!DOCTYPE html>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,java.sql.Statement,eCommon.Common.*"
%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp"%>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head> 
<style>
	div.listContentLayer {
		width: 100%;		
		height: 400px; 	
		overflow-x: auto;
		overflow-y: auto;
		margin: 0 auto;
	}
	
	table.mealOrderTable {
	width: 100%;		
	border: none;
	background-color: #f7f7f7;
	}
	
	table>tbody	{  
	overflow: auto; 
	height: 250px;
	overflow-x: hidden;
	}
	thead tr	{
	position:relative; 
	top: expression(offsetParent.scrollTop); 
	}
</style>
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
	<script language="Javascript" src="../../eDS/js/DSCommon.js"></script><!--Added Against ML-MMOH-CRF-0674-->
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	<script language='javascript' src='../../eCommon/js/tableheaderscroll.js'></script><!-- Supporting Js File For Fixed Header with scroll.... -->
	<script type="text/javascript">
	window.onload = function () { 
		if(document.getElementById("Overlap_appt_dtls")!=null){
			fxheaderInit('Overlap_appt_dtls',350);
		}
	}
	</script>

<IBATagLibs:initCalendar />
</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%

	Connection con=null;
	PreparedStatement stmt=null;
	Statement st = null ;
	ResultSet rs=null;	

	String sql = "",current_date="",meal_category_code="",meal_category_description="",diet_type_code="",diet_type_description="",meal_class_code="",meal_class_description="",meal_type_code="",meal_type_description="";
	
	String rownum="",order_from_date="",order_to_date="",menu_type="",menu_type_descrption="",diet_type="",diet_type_desc="",meal_class="",meal_class_desc="",meal_category="",meal_category_desc="",noof_orders="",practId="",practName="",diet_req_location="",diet_req_location_desc="",meal_type="",meal_type_desc="",last_addedById="",orderedBy="",last_modifiedById="",staff_order_id="";//CRF-832
	String class_val = "";
	String mealOrderFromDate = checkForNull(request.getParameter("mealOrderFromDate"));
	String mealOrderToDate = checkForNull(request.getParameter("mealOrderToDate"));	
	String sql_curr_date="SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CURRENT_DATE FROM DUAL";
	//ML-MMOH-CRF-0684_US6
	 String menu_type_code = "";
	 String menu_type_desc =  "";
 	//ML-MMOH-CRF-0684_US6
	//Added against ML-MMOH-CRF-0419
	String diet_location_code="",diet_location_description="",default_diet_request_location="";
	//Added against ML-MMOH-CRF-0419
	int rowCount = 0,total_cnt = 0;
	String mode="";
	String DELETE="DELETE";
	//ML-MMOH-CRF-825 starts
	PreparedStatement pstmt = null;
	String LATE_IRREGULAR_DIET_ORD_FOR_ST = "";
	//ML-MMOH-CRF-825 end
	try{
		con	= ConnectionManager.getConnection(request);
		st	= con.createStatement() ;
		rs	= st.executeQuery(sql_curr_date);
		while(rs!=null && rs.next()){
			current_date = com.ehis.util.DateUtils.convertDate(rs.getString("CURRENT_DATE"),"DMY","en",locale);
			}
		if(rs != null) rs.close();
		/* Added Againt Start ML-MMOH-CRF-825 */
		String SetupQuery = "select LATE_IRREGULAR_DIET_ORD_FOR_ST from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = ? "; 
		pstmt = con.prepareStatement(SetupQuery);	
		pstmt.setString(1,facility_id);	
		rs	= pstmt.executeQuery();
		if(rs != null && rs.next()){
				LATE_IRREGULAR_DIET_ORD_FOR_ST=rs.getString("LATE_IRREGULAR_DIET_ORD_FOR_ST");
			}
		/* Added Againt End ML-MMOH-CRF-825 */	 	
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}finally {
		try{
			if(rs!=null) rs.close();
			if(st!=null) st.close();
		}catch(Exception es){
			es.printStackTrace();
		} 
	}
%>
	<form name="MealOrderForm" id="MealOrderForm" target="messageFrame">
		<table border='0' cellspacing='0' width='85%' align='center'>
		<!--ML-MMOH-CRF-0684-US6 Starts-->
		<%
			//ML-MMOH-CRF-0684
			boolean isMenuType = false;
			isMenuType = CommonBean.isSiteSpecific(con,"DS","DS_MENU_TYPE");
			//ML-MMOH-CRF-0684
		if(isMenuType){%>
		<tr>
			<td class ="label" >
			<fmt:message key="eDS.MenuType.Label" bundle="${ds_labels}"/>
            </td>
			  <td  class='label' >
		       <select name="menuType" id="menuType" id ='menuType'>
				<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />
				<%
					try{			
						String sql_Menu_Count="SELECT count(*) FROM ds_menu_type where eff_status ='E' and appl_for_staff_yn ='Y' AND DEFAULT_YN='Y'";
						stmt = con.prepareStatement(sql_Menu_Count);
						rs = stmt.executeQuery();
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
		<!--ML-MMOH-CRF-0684-US6 Ends-->
		<tr>
			<td class='label' >
				<fmt:message key="eDS.DietRequestLocation.Label" bundle="${ds_labels}" />
			</td>
			<td  class='label' >
				<select name="dietLocation" id="dietLocation" id ='dietLocation'>
				<% try
				      { 
					  //Added Against CRF-0419 US08 Starts Here
					  /*sql="SELECT count(*) FROM ds_diet_request_loc_lang_vw WHERE language_id = 'en' and  eff_status = 'E' and DEFAULT_DIET_REQUEST_LOCATION='Y' ";*/
					  //Added against CRF-0419 US8
					  sql="SELECT SUM (eff_count) eff_count, SUM (default_count) default_count FROM (SELECT COUNT (*) eff_count, 0 default_count FROM ds_diet_request_loc_lang_vw b WHERE b.language_id = ? AND b.eff_status = 'E' UNION SELECT 0 eff_count, COUNT (*) default_count FROM ds_diet_request_loc_lang_vw d WHERE d.language_id = ? AND d.eff_status = 'E' AND d.default_diet_request_location = 'Y')";  
					  int eff_status_Count=0;//CEF-0419
					  int default_Count=0;
					  stmt=con.prepareStatement(sql);
					  stmt.setString(1,locale);
					  stmt.setString(2,locale);
					 rs=stmt.executeQuery();
					 if (rs.next())
					 {
					 eff_status_Count = rs.getInt(1);
					 default_Count = rs.getInt(2);
					 }
						
					 //Added Against CRF-0419 US8 Ends Here
					 if(default_Count != 1 && eff_status_Count != 1)
					 {
					%>
					<option value="">
							<fmt:message key="Common.Select.label" bundle="${common_labels}" />
						</option>
					<%
							}
							sql= "SELECT LOCATION_CODE, SHORT_DESC,DEFAULT_DIET_REQUEST_LOCATION FROM ds_diet_request_loc_lang_vw WHERE language_id = ? and eff_status = 'E' ORDER BY 2, 1";//Modified against CRF-0419		
							stmt=con.prepareStatement(sql);
							stmt.setString(1,locale);
							rs=stmt.executeQuery();
							if(rs!=null)
							{
							   while(rs.next())
							        {
								        diet_location_code=rs.getString(1);
								        diet_location_description=rs.getString(2);
									//Added against CRF-0419 Starts Here
									default_diet_request_location=rs.getString(3);
									 if(default_Count == 1 && default_diet_request_location.equalsIgnoreCase("Y"))
									 {
				%>
							              <option value="<%=diet_location_code%>" selected><%=diet_location_description%>
								  <%
								  }
								  else
								  {
								  %>
					              	<option value="<%=diet_location_code%>" ><%=diet_location_description%>
					<%  }	//Added against CRF-0419 Ends Here
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
				<td class='label' >
					<fmt:message key="eOT.MealCategory.Label" bundle="${ot_labels}" />
				</td>
				<td  class='label' >				
					<select name="mealCategory" id="mealCategory" onChange="callPractitioner(this);changeMealType(this);"><!--CRF-0678 & CRF-1006-US3 -->
						<option value="">
							<fmt:message key="Common.Select.label" bundle="${common_labels}" />
						</option>
					<% try
					      { 
							//Added against ML-MMOH-CRF-0678
							sql= "SELECT meal_category_code, description FROM ds_meal_category_lang_vw WHERE meal_category_code IN ('STF', 'ONC', 'STU','DOC','OPS') AND (language_id = ?) ORDER BY 2, 1";

							stmt=con.prepareStatement(sql);
							stmt.setString(1,locale);
							rs=stmt.executeQuery();
							if(rs!=null)
							{
							   while(rs.next())
							        {
								        meal_category_code=rs.getString(1);
								        meal_category_description=rs.getString(2);
					%>
					              <option value="<%=meal_category_code%>"><%=meal_category_description%>
					<%  
									}
							}
					%>
					</select>
					<img src='../../eCommon/images/mandatory.gif'></img>
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
		<!-- Added Against CRF-0678 Starts Here-->
		<tr id="practName" style="display:none;">
			<td class='label' >
				<fmt:message key="eDS.practitionerName.Label" bundle="${ds_labels}" />					
			</td>
         	<td class='label' >
			<input type=text name='practitioner_name' id='practitioner_name'  onblur="callPractSearch1(this,practitioner_name,'en','<%=facility_id%>');" value=''  onblur="" size='25' >
			<input type=hidden name='practitioner' id='practitioner'  value='' size='30' maxlength='30' ></input>
			<input type='button' class='button' value='?'  name='search_pract' id='search_pract'  onClick="callPractSearch1(this,practitioner_name,'en','<%=facility_id%>');" >
			<img src='../../eCommon/images/mandatory.gif'></img>
			</td>
       	</tr>				
		<!-- Added Against CRF-0678 Ends Here-->
		<tr>
			<td class='label' >
					<fmt:message key="eOT.MealOrderFrom.Label" bundle="${ot_labels}" />
				</td>
				<td class='label' >
					<input type="text" name="mealOrderFrom" id="mealOrderFrom" value="<%=current_date%>"  size="10"onblur="validDateObj(this,'DMY','en');ComparePeriodFromToTime(this,mealOrderTo);checkDateValidate(this);" onkeypress="return Valid_DT(event)" maxlength="10" /><!-- CRF-0419-->
					<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('mealOrderFrom');"/>	
					<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
		</tr>
		<tr>
			<td class='label' >
				<fmt:message key="eOT.MealOrderTo.Label" bundle="${ot_labels}" />
			</td>
			<td   class='label' >
					<input type="text" name="mealOrderTo" id="mealOrderTo" value="<%=current_date%>"  size="10" onblur="validDateObj(this,'DMY','en');ComparePeriodFromToTime(mealOrderFrom,this);checkDateValidate(this);" onkeypress="return Valid_DT(event)" maxlength="10" /><!-- CRF-0419-->
					<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('mealOrderTo');"/>
					<img src='../../eCommon/images/mandatory.gif'></img>
			</td>
		</tr>
		<!--/table-->
		<!--table border="0" width="85%" align='center'-->
		<tr>
				<!--td width="40%"-->
			<td class='label' >
					<!--table border="0" align="center" -->
				<tr>
					<td class='label'>
						<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}" />
					</td>							
					<td class='label'>
						<select name="DietType" id="DietType" id='DietType' onKeyUp="diettype_Autocomplete()"   onClick="Select();"><!--Added Against ML-MMOH-CRF-0674-->
							<option value="">
								<fmt:message key="Common.Select.label" bundle="${common_labels}" />
							</option>
								<% try
								      {
										/* appl_staff_order_yn is added newly */
										//sql= "select DIET_TYPE,SHORT_DESC from DS_DIET_TYPE_LANG_VW where (LANGUAGE_ID = ?) and (EFF_STATUS='E') and (appl_staff_order_yn = 'Y') order by  2 , 1";//CRF-0419-US8 Commented Against ML-MMOH-CRF-0674
										// Added Against ML-MMOH-CRF-0674
										sql= "select DIET_TYPE,SHORT_DESC from DS_DIET_TYPE_LANG_VW where (LANGUAGE_ID = ?) and (EFF_STATUS='E') and (appl_staff_order_yn = 'Y') order by  LOWER (short_desc)";//CRF-0419-US8 
										stmt=con.prepareStatement(sql);
										stmt.setString(1,locale);
										rs=stmt.executeQuery();
										if(rs!=null)
										{
										   while(rs.next())
										        {
											        diet_type_code=rs.getString(1);
											        diet_type_description=rs.getString(2);
								                    %>
									               <option value="<%=diet_type_code%>"><%=diet_type_description%>
								            <%  }
									  }%>
				</select>
				<img src='../../eCommon/images/mandatory.gif'></img>
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
			<td class='label' >
				<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}" />
			</td>
			<td class='label'>
					<select name="MealClass" id="MealClass" id='MealClass'>
							<option value="">
								<fmt:message key="Common.Select.label" bundle="${common_labels}" />
							</option>
								<% try
								      {
										/* appl_staff_order_yn is added newly */
										sql= "select MEAL_CLASS as col_1_0_,SHORT_DESC as col_0_0_ from DS_MEAL_CLASS_LANG_VW where (EFF_STATUS='E') and (LANGUAGE_ID = ?) and (appl_staff_order_yn ='Y') order by  2 , 1";//CRF-0419-US8
										stmt=con.prepareStatement(sql);
										stmt.setString(1,locale);
										rs=stmt.executeQuery();
										if(rs!=null)
										{
										   while(rs.next())
										        {
											  	 	meal_class_code=rs.getString(1);
											   		meal_class_description=rs.getString(2);
								                    %>
									               <option value="<%=meal_class_code%>"><%=meal_class_description%>
								            <%  }
									  }%>
									</select>
								<img src='../../eCommon/images/mandatory.gif'></img>
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
			<td class='label' >
				<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}" />
			</td>
			<td class='label' id = 'MealTypeTD'>
				<select name="MealType" id="MealType" id="MealType"> 
					<option value="">
						<fmt:message key="Common.Select.label" bundle="${common_labels}" />
					</option>
					
		<% try
			  {
				sql= "select MEAL_TYPE,SHORT_DESC from DS_MEAL_TYPE_LANG_VW where LANGUAGE_ID = ? AND  EFF_STATUS='E' AND (NVL(DOC_MEAL_ORDER_YN, 'N') = 'Y' OR NVL(OPS_MEAL_ORDER_YN, 'N') = 'Y' OR NVL(ONC_MEAL_ORDER_YN, 'N') = 'Y' OR NVL(STF_MEAL_ORDER_YN, 'N') = 'Y' OR NVL(STU_MEAL_ORDER_YN, 'N') = 'Y') order by meal_order";
				//ML-MMOH-CRF-0820 & ML-MMOH-CRF-1006-US3 
				stmt=con.prepareStatement(sql);
				stmt.setString(1,locale);
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
		<% }catch(Exception e){
			e.printStackTrace();
			}
		finally{
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
}
%>
			</td>
		</tr>
		<tr>
			<td class='label' >
				<fmt:message key="eOT.NoOfOrders.Label" bundle="${ot_labels}" />
			</td>
			<td class='label'>
				<input type="text" value="" name="noOfOrders" id="noOfOrders" size="6" maxlength="6" onkeypress="chkMealOrders()" /> 
								
			</td>
		</tr>
		<tr>
			<td  align="center" colspan="2">
			<!--td  align="center" colspan="2" -->
				<input type="button" class='BUTTON' name="select" id="select" value="<fmt:message key="Common.Select.label" bundle="${common_labels}"/>" onClick="selectItemsMenu();"/>
			<!--</td>-->
			<!-- Added Against Start 832-CRF -->
				<input type="button" class='BUTTON' name="search" id="search" value="<fmt:message key="Common.search.label" bundle="${common_labels}"/>" onClick="searchItemMenu();"/>			
			<!-- Added Against End 832-CRF -->
			</td>
		</tr>
			<!--/table-->
			</td>
		</tr>
		<!--/table-->
	</table>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<!-- table border="0" width="85%" align='center' style="overflow:auto" -->
	<!--div id="listContentLayer" style="visibility:visible;overflow:auto;height:270;width:450;border: 1px outset white"  -->
	<div id="listContentLayer" style="position:relative;height:335px;vertical-align:top;overflow:auto"> 		
	<table border='1' cellpadding='2' cellspacing='0' width='100%' align='center' id="mealOrderTable">
	<THEAD>
		<tr>
		
		<%if(isMenuType){%>
			<th align="center">
				<fmt:message key="eDS.MenuType.Label" bundle="${ds_labels}"/>
			</th>
		<%}%>
			<th align="center">
				<fmt:message key="eOT.MealOrderFrom.Label" bundle="${ot_labels}" />
			</th>

			<th align="center">
				<fmt:message key="eOT.MealOrderTo.Label" bundle="${ot_labels}" />
			</th>
		
			<th align="center">
				<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}" />
			</th>

			<th align="center">
				<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}" />
			</th>

			<th align="center">
				<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}" />
			</th>

			<th align="center">
				<fmt:message key="eOT.NoOfOrders.Label" bundle="${ot_labels}" />
			</th>
			<th align="center">
				<fmt:message key="eDS.MealCategory.Label" bundle="${ds_labels}" />
			</th>
			<th align="center">
				<fmt:message key="eDS.practitionerName.Label" bundle="${ds_labels}" />
			</th>
			<th align="center">
				<fmt:message key="eDS.DietRequestLocation.Label" bundle="${ds_labels}" />
			</th>
			<th align="center">
				<fmt:message key="Common.OrderedBy.label" bundle="${common_labels}" />
			</th>
			<th align="center">
				<fmt:message key="Common.LastModifiedBy.label" bundle="${common_labels}" />
			</th>
			<th align="center">
				 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</th>					
		</tr>
	</THEAD>	
<TBODY>	
	<%try{
			if(mealOrderFromDate.equals(""))
					mealOrderFromDate=current_date;
			if(mealOrderToDate.equals(""))
					mealOrderToDate=current_date;

			con	= ConnectionManager.getConnection(request);
			String sql_OnLoadQuery="SELECT ROWNUM, staff_order_id, menu_type, menu_type_desc, order_from_date, order_to_date, meal_category, meal_cat_desc, practitioner_id, prac_name, location_code, diet_req_loc_desc,diet_type, diet_type_desc, meal_class, meal_class_desc, meal_type, meal_type_desc, no_of_meals_orders, added_by_id, ordered_by, modified_by,total_cnt FROM (SELECT ROWNUM, a.staff_order_id, a.menu_type, ds_get_desc.ds_menu_type (a.menu_type, ?, '2') menu_type_desc, TO_CHAR (a.order_from_date, 'DD/MM/YYYY') AS order_from_date, TO_CHAR (a.order_to_date, 'DD/MM/YYYY') AS order_to_date, a.meal_category, ds_get_desc.ds_meal_category (a.meal_category, ?, '1') meal_cat_desc, a.practitioner_id, am_get_desc.am_practitioner (a.practitioner_id, ?, '1') prac_name,  a.location_code, ds_get_desc.ds_diet_req_loc (a.location_code, ?, '2') diet_req_loc_desc, b.diet_type, ds_get_desc.ds_diet_type (b.diet_type, ?, '2') diet_type_desc, b.meal_class, ds_get_desc.ds_meal_class (b.meal_class, ?, '2') meal_class_desc, b.meal_type, ds_get_desc.ds_meal_type (b.meal_type, ?, '2') meal_type_desc, b.no_of_meals_orders, b.added_by_id, sm_get_desc.sm_appl_user (b.added_by_id, ?, '1') ordered_by, CASE WHEN b.modified_date > b.added_date THEN sm_get_desc.sm_appl_user (b.modified_by_id, ?, '1') WHEN a.modified_date > a.added_date  THEN sm_get_desc.sm_appl_user (a.modified_by_id, ?,'1') END modified_by,(no_of_meals_served + no_of_meals_received + no_of_meals_rejected) total_cnt FROM ds_staff_orders_hdr a, ds_staff_orders_dtl b WHERE a.facility_id = b.facility_id AND a.staff_order_id = b.staff_order_id AND NVL(a.eff_status,'A') != 'D' AND (   (   a.order_from_date BETWEEN TO_DATE (?, 'dd/mm/yyyy') AND TO_DATE (?, 'dd/mm/yyyy') OR a.order_to_date BETWEEN TO_DATE (?, 'dd/mm/yyyy') AND TO_DATE (?, 'dd/mm/yyyy') ) OR (   TO_DATE (?, 'dd/mm/yyyy') BETWEEN a.order_from_date AND a.order_to_date OR TO_DATE (?, 'dd/mm/yyyy') BETWEEN a.order_from_date AND a.order_to_date))  order by staff_order_id)"; //CRF-832 and Modified Against IN-065835
			stmt	= con.prepareStatement(sql_OnLoadQuery) ;					
			stmt.setString(1,locale);	
			stmt.setString(2,locale);	
			stmt.setString(3,locale);	
			stmt.setString(4,locale);	
			stmt.setString(5,locale);	
			stmt.setString(6,locale);	
			stmt.setString(7,locale);	
			stmt.setString(8,locale);	
			stmt.setString(9,locale);	
			stmt.setString(10,locale);	
			stmt.setString(11,mealOrderFromDate);	
			stmt.setString(12,mealOrderToDate);	
			stmt.setString(13,mealOrderFromDate);	
			stmt.setString(14,mealOrderToDate);	
			stmt.setString(15,mealOrderFromDate);	
			stmt.setString(16,mealOrderToDate);	
			rs	= stmt.executeQuery();
			while(rs!=null && rs.next()){ 
				staff_order_id =checkForNull(rs.getString("staff_order_id")); //hdr
				rownum =checkForNull(rs.getString("rownum"));
				order_from_date =checkForNull(rs.getString("order_from_date")); // hdr
				order_to_date =checkForNull(rs.getString("order_to_date")); // hdr
				menu_type =checkForNull(rs.getString("MENU_TYPE")); //hdr
				menu_type_descrption =checkForNull(rs.getString("MENU_TYPE_DESC"));
				diet_type =checkForNull(rs.getString("DIET_TYPE"));
				diet_type_desc =checkForNull(rs.getString("DIET_TYPE_DESC"));
				meal_class =checkForNull(rs.getString("MEAL_CLASS"));
				meal_class_desc =checkForNull(rs.getString("MEAL_CLASS_DESC"));
				meal_category =checkForNull(rs.getString("MEAL_CATEGORY")); // hdr
				meal_category_desc =checkForNull(rs.getString("MEAL_CAT_DESC"));
				noof_orders =checkForNull(rs.getString("NO_OF_MEALS_ORDERS"));
				practId =checkForNull(rs.getString("PRACTITIONER_ID")); //hdr
				practName =checkForNull(rs.getString("PRAC_NAME"));
				diet_req_location =checkForNull(rs.getString("LOCATION_CODE")); //hdr
				diet_req_location_desc =checkForNull(rs.getString("DIET_REQ_LOC_DESC"));
				meal_type =checkForNull(rs.getString("MEAL_TYPE"));
				meal_type_desc =checkForNull(rs.getString("MEAL_TYPE_DESC"));
				last_addedById =checkForNull(rs.getString("ADDED_BY_ID")); //hdr
				orderedBy =checkForNull(rs.getString("ORDERED_BY"));
				last_modifiedById =checkForNull(rs.getString("MODIFIED_BY"));
				total_cnt =rs.getInt("total_cnt");
				/*Added Against Start IN-065835 */  
				if(practName==""){
					practName="&nbsp";
				}
				if(orderedBy==""){
					orderedBy="&nbsp";
				}
				if(last_modifiedById==""){
					last_modifiedById="&nbsp";
				}
				/*Added Against End IN-065835 */  
				if(staff_order_id!=null)
				mode="update";
			
	 out.println("<tr>");
	 if(isMenuType){
	out.println("<td id='"+"menu_type"+rowCount+"' class='"+class_val+"'>"+menu_type_descrption+"</td><input type='hidden' name='"+"hid_menu_type_descrption"+rowCount+"' id='"+"hid_menu_type_descrption"+rowCount+"' value='"+menu_type+"'/>");	
	}
	out.println("<td id='"+"order_from_date"+rowCount+"' class='"+class_val+"'>"+order_from_date+"</td><input type='hidden' name='"+"hid_order_from_date"+rowCount+"' id='"+"hid_order_from_date"+rowCount+"' value='"+order_from_date+"'/>");	
	
	out.println("<td id='"+"order_to_date"+rowCount+"' class='"+class_val+"'>"+order_to_date+"</td><input type='hidden' name='"+"hid_order_to_date"+rowCount+"' id='"+"hid_order_to_date"+rowCount+"' value='"+order_to_date+"'/>");	
	
	if(isMenuType){ 
	if(total_cnt > 0){
	out.println("<td id='"+"diet_type"+rowCount+"' class='"+class_val+"'>"+ diet_type_desc +"</td><input type='hidden' name='"+"hid_diet_type"+rowCount+"' id='"+"hid_diet_type"+rowCount+"' value='"+diet_type+"'/>");
	}else{
	out.println("<td id='"+"diet_type"+rowCount+"' class='"+class_val+"'>"+"<a href=\"javascript:updateRecord1('" + menu_type_descrption + "','" + menu_type + "','" + order_from_date + "','" + order_to_date + "','" + diet_type_desc + "','" + diet_type + "','" + meal_class_desc + "','" + meal_class + "','" + meal_type_desc + "','" + meal_type + "','" + noof_orders + "','" + meal_category_desc + "','" + meal_category + "','" + practName + "','" + diet_req_location_desc + "','" + diet_req_location + "','"+practId+"','"+orderedBy+"','"+last_addedById+"','"+last_modifiedById+"','"+mode+"','"+staff_order_id+"','"+total_cnt+"','" + rowCount + "');\">" + diet_type_desc + "</a></td><input type='hidden' name='"+"hid_diet_type"+rowCount+"' id='"+"hid_diet_type"+rowCount+"' value='"+diet_type+"'/>");
	}
	}else{
 	if(total_cnt > 0){
	out.println("<td id='"+"diet_type"+rowCount+"' class='"+class_val+"'>"+ diet_type_desc +"</td><input type='hidden' name='"+"hid_diet_type"+rowCount+"' id='"+"hid_diet_type"+rowCount+"' value='"+diet_type+"'/>");
	}else{ 
	out.println("<td id='"+"diet_type"+rowCount+"' class='"+class_val+"'>"+"<a href=\"javascript:updateRecord('" + order_from_date + "','" + order_to_date + "','" + diet_type_desc + "','" + diet_type + "','" + meal_class_desc + "','" + meal_class + "','" + meal_type_desc + "','" + meal_type + "','" + noof_orders + "','" + meal_category_desc + "','" + meal_category + "','" + practName + "','" + diet_req_location_desc + "','" + diet_req_location + "','"+practId+"','"+orderedBy+"','"+last_addedById+"','"+last_modifiedById+"','"+mode+"','"+staff_order_id+"','"+total_cnt+"','" + rowCount + "');\">" + diet_type_desc + "</a></td><input type='hidden' name='"+"hid_diet_type"+rowCount+"' id='"+"hid_diet_type"+rowCount+"' value='"+diet_type+"'/>");
	}
	}
	out.println("<td id='"+"meal_class"+rowCount+"' class='"+class_val+"'>"+meal_class_desc+"</td><input type='hidden' name='"+"hid_meal_class"+rowCount+"' id='"+"hid_meal_class"+rowCount+"' value='"+meal_class+"'/>");		
	
	out.println("<td id='"+"meal_type"+rowCount+"' class='"+class_val+"'>"+meal_type_desc+"</td><input type='hidden' name='"+"hid_meal_type"+rowCount+"' id='"+"hid_meal_type"+rowCount+"'  value='"+meal_type+"'/>");		
	
	out.println("<td id='"+"noof_orders"+rowCount+"' class='"+class_val+"'>"+noof_orders+"</td><input type='hidden' name='hid_noof_orders"+rowCount+"' id='hid_noof_orders"+rowCount+"' id='hid_noof_orders"+rowCount+"' value='"+noof_orders+"'/>");	
	
	out.println("<td id='"+"meal_category"+rowCount+"' class='"+class_val+"'>"+meal_category_desc+"</td><input type='hidden' name='"+"hid_meal_category"+rowCount+"' id='"+"hid_meal_category"+rowCount+"' value='"+meal_category+"'/>");		
	
	out.println("<td id='"+"practId"+rowCount+"' class='"+class_val+"'>"+practName+"</td><input type='hidden' name='"+"hid_practId"+rowCount+"' id='"+"hid_practId"+rowCount+"' id='"+"hid_practId"+rowCount+"' value='"+practId+"'/>");		
	
	out.println("<td id='"+"diet_req_location"+rowCount+"' class='"+class_val+"'>"+diet_req_location_desc+"</td><input type='hidden' name='"+"mode"+rowCount+"' id='"+"mode"+rowCount+"' id='"+"mode"+rowCount+"' value='update'/><input type='hidden' name='"+"hid_diet_req_location"+rowCount+"' id='"+"hid_diet_req_location"+rowCount+"' id='hid_diet_req_location"+rowCount+"'    value='"+diet_req_location+"'/>");		
	
	out.println("<td id='"+"last_addedById"+rowCount+"' class='"+class_val+"'>"+orderedBy+"</td><input type='hidden' name='"+"hid_orderedby"+rowCount+"' id='"+"hid_orderedby"+rowCount+"' id='"+"hid_orderedby"+rowCount+"' value='"+last_addedById+"'/>");		
	
	out.println("<td id='"+"last_modifiedById"+rowCount+"' class='"+class_val+"'>"+last_modifiedById+"</td><input type='hidden' name='"+"hid_last_modifiedById"+rowCount+"' id='"+"hid_last_modifiedById"+rowCount+"' value='"+last_modifiedById+"'/>");	
		
	out.println("<input type='hidden' name='"+"hid_total_cnt"+rowCount+"' id='"+"hid_total_cnt"+rowCount+"' value='"+total_cnt+"'/>");
	
	if(total_cnt > 0){
	out.println("<td id='"+"staff_order_id"+rowCount+"' class='"+class_val+"'>"+ DELETE + "</a></td><input type='hidden' name='"+"hid_staff_order_id"+rowCount+"' id='"+"hid_staff_order_id"+rowCount+"' value='"+staff_order_id+"'/>");
	}else{
	out.println("<td id='"+"staff_order_id"+rowCount+"' class='"+class_val+"'>"+"<a href=\"javascript:deleteRecord('"+staff_order_id+"','" + rowCount + "');\">" + DELETE + "</a></td><input type='hidden' name='"+"hid_staff_order_id"+rowCount+"' id='"+"hid_staff_order_id"+rowCount+"' value='"+staff_order_id+"'/>");
	}

	out.println("</tr>"); 
	
	%>
	<script>
 	var chkYN="";
	if(<%=isMenuType%> == true) // Modified Against DS-Ml-MMOH-CRF-0832-US00402 [IN065739]
		chkYN="Y";
	else	
		chkYN="N";
		
	//CRF-832
	parent.mealOrderArray[<%=rowCount%>] = new Array();
	if(chkYN=="Y"){
	parent.mealOrderArray[<%=rowCount%>][0] = "<%=menu_type_descrption%>";	
	parent.mealOrderArray[<%=rowCount%>][1] = "<%=menu_type%>";	
	parent.mealOrderArray[<%=rowCount%>][2] = "<%=order_from_date%>";	
	parent.mealOrderArray[<%=rowCount%>][3] = "<%=order_to_date%>";
	parent.mealOrderArray[<%=rowCount%>][4] = "<%=diet_type_desc%>";
	parent.mealOrderArray[<%=rowCount%>][5] = "<%=diet_type%>";
	parent.mealOrderArray[<%=rowCount%>][6] = "<%=meal_class_desc%>";
	parent.mealOrderArray[<%=rowCount%>][7] = "<%=meal_class%>";
	parent.mealOrderArray[<%=rowCount%>][8] = "<%=meal_type_desc%>";
	parent.mealOrderArray[<%=rowCount%>][9] = "<%=meal_type%>";
	parent.mealOrderArray[<%=rowCount%>][10] = "<%=noof_orders%>";
	parent.mealOrderArray[<%=rowCount%>][11] = "<%=meal_category_desc%>";
	parent.mealOrderArray[<%=rowCount%>][12] = "<%=meal_category%>";
	parent.mealOrderArray[<%=rowCount%>][13] = "<%=practName%>";
	parent.mealOrderArray[<%=rowCount%>][14] = "<%=diet_req_location_desc%>";
	parent.mealOrderArray[<%=rowCount%>][15] = "<%=diet_req_location%>";
	parent.mealOrderArray[<%=rowCount%>][16] = "<%=practId%>";
	parent.mealOrderArray[<%=rowCount%>][17] = "<%=orderedBy%>";
	parent.mealOrderArray[<%=rowCount%>][18] = "<%=last_addedById%>";
	parent.mealOrderArray[<%=rowCount%>][19] = "<%=last_modifiedById%>";
	parent.mealOrderArray[<%=rowCount%>][20] = "<%=mode%>";
	parent.mealOrderArray[<%=rowCount%>][21] = "<%=staff_order_id%>";
	parent.mealOrderArray[<%=rowCount%>][22] = "<%=total_cnt%>";
	}else{
	parent.mealOrderArray[<%=rowCount%>][0] = "<%=order_from_date%>";	
	parent.mealOrderArray[<%=rowCount%>][1] = "<%=order_to_date%>";
	parent.mealOrderArray[<%=rowCount%>][2] = "<%=diet_type_desc%>";
	parent.mealOrderArray[<%=rowCount%>][3] = "<%=diet_type%>";
	parent.mealOrderArray[<%=rowCount%>][4] = "<%=meal_class_desc%>";
	parent.mealOrderArray[<%=rowCount%>][5] = "<%=meal_class%>";
	parent.mealOrderArray[<%=rowCount%>][6] = "<%=meal_type_desc%>";
	parent.mealOrderArray[<%=rowCount%>][7] = "<%=meal_type%>";
	parent.mealOrderArray[<%=rowCount%>][8] = "<%=noof_orders%>";
	parent.mealOrderArray[<%=rowCount%>][9] = "<%=meal_category_desc%>";
	parent.mealOrderArray[<%=rowCount%>][10] = "<%=meal_category%>";
	parent.mealOrderArray[<%=rowCount%>][11] = "<%=practName%>";
	parent.mealOrderArray[<%=rowCount%>][12] = "<%=diet_req_location_desc%>";
	parent.mealOrderArray[<%=rowCount%>][13] = "<%=diet_req_location%>";
	parent.mealOrderArray[<%=rowCount%>][14] = "<%=practId%>";
	parent.mealOrderArray[<%=rowCount%>][15] = "<%=orderedBy%>";
	parent.mealOrderArray[<%=rowCount%>][16] = "<%=last_addedById%>";
	parent.mealOrderArray[<%=rowCount%>][17] = "<%=last_modifiedById%>";
	parent.mealOrderArray[<%=rowCount%>][18] = "<%=mode%>";
	parent.mealOrderArray[<%=rowCount%>][19] = "<%=staff_order_id%>";
	parent.mealOrderArray[<%=rowCount%>][20] = "<%=total_cnt%>";	
	}
//CRF-832
	</script>
	<%
	rowCount++;
	}
	if(rowCount==0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); //history.go(-1);</script>");
		}				
	}catch(Exception e){
			System.err.println("Exception in catch MealOrderCUD.jsp==="+e);
			e.printStackTrace();
	}finally{
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			System.err.println("Exception in Final MealOrderCUD.jsp==="+e);
			e.printStackTrace();
		}
	}%>
	</table>
	</div >
	<!--/table -->
		<input type='hidden' name='mode' id='mode' />
		<input type='hidden' name='locale' id='locale'  value='<%=locale%>' />
		<input type='hidden' name='moduleId' id='moduleId'  value="DS" />
		<input type='hidden' name='functionId' id='functionId' value="DS_MEAL_ORDER_STAFF"/>
		<input type='hidden' name='viewCode' id='viewCode' value="mealOrderFrame" />
		<input type='hidden' name='fromDatepattern' id='fromDatepattern' value="dd/MM/yyyy" />
		<input type='hidden' name='toDatepattern' id='toDatepattern' value="dd/MM/yyyy" />
		<input type='hidden' name='recordId' id='recordId' />
		<input type='hidden' name='rowId' id='rowId' />
		<input type='hidden' name='staff_order_id' id='staff_order_id' />
		<input type='hidden' name='last_addedById' id='last_addedById' />
		<input type='hidden' name='orderedBy' id='orderedBy' />
		<input type='hidden' name='last_modifiedById' id='last_modifiedById' />
		<input type='hidden' name='total_cnt' id='total_cnt' />
		<input type='hidden' name='rowCount1' id='rowCount1' value="<%=rowCount%>"/>
		<input type='hidden' name='params' id='params' value='<%=params%>' >
		<input type="hidden" name="facilityId" id="facilityId" value="<%=facility_id%>" />
		<input type="hidden" name="locale" id="locale" value="<%=locale%>" />
		<input type="hidden" name="datepattern" id="datepattern" value="dd/MM/yyyy" />
		<input type='hidden' name='totalRows' id='totalRows' />
		<input type="hidden" name="tabId" id="tabId" value="mealOrderTab"/>
		 <!-- Ml-MMOH-CRF-0674 Starts Here -->
		<INPUT type="hidden" name="diettype_auto" id="diettype_auto" id="diettype_auto" value="">
		<INPUT type="hidden" name="auto_flag" id="auto_flag" id="auto_flag" value="false">
		<!-- Ml-MMOH-CRF-0674 Ends Here -->
		<!-- Ml-MMOH-CRF-0684 Starts Here -->
		<input type="hidden" name="menuType" id="menuType" value="">
		<input type="hidden" name="current_date" id="current_date" value="<%=current_date%>">
		<input type="hidden" name="isMenuType" id="isMenuType" id ="isMenuType" value="<%=isMenuType%>">
		<!-- ML-MMOH-CRF-825 Start -->
		<input type="hidden" name="LATE_IRREGULAR_DIET_ORD_FOR_ST" id="LATE_IRREGULAR_DIET_ORD_FOR_ST" id="LATE_IRREGULAR_DIET_ORD_FOR_ST" value="<%=LATE_IRREGULAR_DIET_ORD_FOR_ST%>" />
		<!-- ML-MMOH-CRF-825 End -->
		<!-- Ml-MMOH-CRF-0684 Ends Here -->			
	</form>
</body>
</TBODY>
<html>

