<!DOCTYPE html>
<%@ page import = "eDS.*,eCommon.Common.*,eCommon.XSSRequestWrapper,
								 java.sql.Connection,
								 java.sql.PreparedStatement,
								 java.sql.ResultSet,
								 webbeans.eCommon.ConnectionManager,
								 java.util.ArrayList,
								 java.util.LinkedHashMap,
								 java.net.URLEncoder" contentType="text/html;charset=UTF-8"
%><!--Modified against AMS-CRF-0112-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
 
<head target="_self">
<%  //Added Against MMS Vulnerability Issue - Starts
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
    //Added Against MMS Vulnerability Issue - Ends
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
	if(sStyle==null)
		sStyle="IeStyle.css";
	String itemsArray=request.getParameter("MealItemsArray");
	String dateFrom=request.getParameter("dateFrom");
	String dateTo=request.getParameter("dateTo");
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id	= (String)session.getAttribute("facility_id");
	String dayRefNo = request.getParameter("dayRef");
	String menuDate = request.getParameter("dateForMeanu");
	String dietTypes = request.getParameter("dietTypesForMeals");
	String mealTypes = request.getParameter("mealTypesforDietTypes");
	String prlSl =request.getParameter("profileSL");
	String kCode =request.getParameter("kitchenCode");
	String eID = request.getParameter("encounterId");
	String dType = request.getParameter("dietType");
	String mClass=request.getParameter("mealClass");
	String patientClass = request.getParameter("patientClass");
	//ML-MMOH-CRF-0427 US3 starts
	String restrict_date_inpatients_yn=checkForNull(request.getParameter("restrict_date_inpatients_yn"));
	String maximum_days_allowed=checkForNull(request.getParameter("maximum_days_allowed"));
	boolean profileFlag=Boolean.valueOf(request.getParameter("profileFlag"));
	//ML-MMOH-CRF-0427 US3 ends
	String params = request.getQueryString();
	String enableDrugYN="";//MMS-KH-CRF-0029.1-US008

	boolean isAdditionalInstructions = false;//Added Against AMS-CRF-112
	boolean isMealMenuDisplay = false;//Added Against KDAH-CRF-0352-US6	
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script> <%-- AAKH-CRF-0065 Sp2Us2Us3 --%>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eDS/js/PlaceDietOrder.js"></script>
	<script language="Javascript" src="../../framework/js/PopupWindow.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<!--ML-MMOH-CRF-0427 US3 start-->
	<script type="text/javascript" src="../../eDS/js/PlaceDietOrder.js"></script>
	<script type="text/javascript" src="../../eDS/js/PlaceDietOrderPHIS.js"></script>
	
	<link rel="stylesheet" href="../../eDS/css/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	
    <!--<script type="text/javascript" src="../../eDS/js/common/semiDisabledDateTime/datepicker-ar.js"></script>
	<script type="text/javascript" src="../../eDS/js/common/semiDisabledDateTime/common.datepicker-bg.js"></script>
	<script type="text/javascript" src="../../eDS/js/common/semiDisabledDateTime/datepicker-en.js"></script> --> 
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	
	<!--<script type="text/javascript" src="../../eDS/js/common/semiDisabledDateTime/datepicker-ar.js"></script>
  	<script type="text/javascript" src="../../eDS/js/common/semiDisabledDateTime/datepicker-th.js"></script>-->
	<script type="text/javascript" src="../../eDS/js/common/semiDisabledDateTime/datepicker-<%=locale%>.js"></script>
	<!--ML-MMOH-CRF-0427  US3ends-->
	<script > var lblAdditionalInstruction=getLabel("eDS.AdditionalInstruction.Label","DS")	</script><!-- Added aginst AMS-CRF-112-->
</head>
<body>
<script type="text/javascript" src="../../eOT/js/wz_tooltip.js"></script><!--Added Against AMS-CRF-0112-->
	<form>
	<a name= "reload" id= "reload" href="Reload" style='visibility:hidden'>Reload</a>
	<input type="hidden" name="MealItemsArray" id="MealItemsArray" value="<%=itemsArray%>"/>
	<input type="hidden" name="totalItems" id="totalItems" value=""/>
	<input type="hidden" name="paramValues" id="paramValues" value="<%=params%>"/>
	<script>
	var subtotal=0;
	var gt=0;
	var MealItems=document.getElementById("MealItemsArray").value;
	var itemList=(MealItems).split(',');
	var MealItemsArray=new Array();
	var k=0;
	for(var i=0;i<(itemList.length/9);i++) {
		MealItemsArray[i]=new Array();
		for(var j=0;j<9;j++,k++) {
			MealItemsArray[i][j]=itemList[k];
		}
	}
	</script>
		<table class='chkFormChange' width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td>
				<table border='0' cellpadding='2' cellspacing='0' width='90%' align='center' id="listContentTable" style="overflow-x:scroll;">
					<tr align="left">
						<td colspan="1" noWrap class="label" >
							<fmt:message key="eOT.menuForDate.Label" bundle="${ot_labels}" />
						</td>
						<td colspan="1">
							<input type="text" name="dateForMenu" id="dateForMenu" id="dateForMenu" size="10" value="<%=menuDate%>" onblur="isValidDate(this);return getDayRefNoForMealMenu(this.value,'<%=mClass%>','<%=dType%>','<%=facility_id%>');"  onmouseover="return getDayRefNoForMealMenu(this.value,'<%=mClass%>','<%=dType%>','<%=facility_id%>');">
							
							<!--ML-MMOH-CRF-0427 US3 start-->
							<%
								if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
							%>
								<img src="../../eCommon/images/CommonCalendar.gif"  name='datepickerimg' id='datepickerimg' onclick="grayOutCalendar('dateForMenu',<%=maximum_days_allowed%>,'<%=locale%>')">
								<!--img src='../../eCommon/images/mandatory.gif' /-->
							<%	
							}else{
							%>	
							<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dateForMenu');">																
																					
							<%	
							}
						%>
						<!--ML-MMOH-CRF-0427 US3 ends-->
							
							
 							<!--img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dateForMenu');"-->
						</td>
						<td colspan="1" noWrap class="label">
							<fmt:message key="eOT.orDietCycle.Label" bundle="${ot_labels}" /> :
						</td>
						<TD>
							<select name="dayRef" id="dayRef">
								<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
								<option value="<%=dayRefNo%>"><%=dayRefNo%></option>
								<script>
								document.getElementById("dayRef").value="<%=dayRefNo%>";
								</script>
							</select>
						</TD>
						<td noWrap>
							<input type="button" name="fecth" id="fecth" value="<fmt:message key='Common.Go.label' bundle='${common_labels}'/>" onclick="refreshWithNewData('<%=dietTypes%>','<%=mealTypes%>','<%=prlSl%>','<%=kCode%>','<%=eID%>','<%=dType%>','<%=mClass%>','<%=patientClass%>');" class="Button">
						</td>
					</tr>
				</table>
<%
						String dietTypeStr="",menuCode="",mealTypeStr="",kitchenCode="",mealClass="",dayRef="",encounterId="",dateForMenu="",profileSL="",item_Type="",item_Code="",itemShortDesc="",item_Qty="",meal_Type="",meal_Type1="",mealTypeShortDesc="",serving_Uom_Code="",calorific_Cont_Per_Uom="",itemSL="",energy_Uom="",reviewType="",reviewSLNo="",AdditionalInstruction="",DBAdditionalInstruction="",additionalInstrDate="",serving_Uom_Desc="",energy_Uom_Desc="",NutrientDesc_temp="",NutrientUomQty="",dsNutrientValues="";//Modified against Ams-CRf-0112,KDAH-CRF-0352, and ICN-#65555 and IN:067604
						ArrayList<String> mealList = new ArrayList<String>();
						Connection connection   = null ;
						PreparedStatement pstmt = null ;
						ResultSet resultSet = null ,rs = null,rs1=null,rs2=null ;
						int counter=0,i=0,k=0;
						int chkUnchkCnt = 0, chkedCnt = 0, menuItemsCnt = 0;
						String menuCodeVal = "";//054259

						try
						{

							String bean_id = "UpdateMealMenuObject";
							String bean_name = "eDS.UpdateMealMenuObject";
							UpdateMealMenuObject bean = (UpdateMealMenuObject)mh.getBeanObject( bean_id, request, bean_name );
							LinkedHashMap updateMealsDetailsMap = (LinkedHashMap)session.getAttribute("ALLMENUITEMSMAP");	
							UpdateMealMenuObject updateMealMenuObject = null;
							LinkedHashMap allMenuItems = new LinkedHashMap();
							ArrayList allMenuItemsList = new ArrayList();
							ArrayList menuItemsList = new ArrayList();
							ArrayList reviewedMenuItemsList = new ArrayList();

							dietTypeStr=request.getParameter("dietTypesForMeals");
							//System.err.println("159,dietTypeStr==="+dietTypeStr);
							mealTypeStr=request.getParameter("mealTypesforDietTypes");
							//System.err.println("161,mealTypeStr==="+mealTypeStr);
							kitchenCode=request.getParameter("kitchenCode");
							mealClass=request.getParameter("mealClass");
							dayRef=request.getParameter("dayRef");
							encounterId=request.getParameter("encounterId");
							dateForMenu=request.getParameter("dateForMeanu");
							profileSL=request.getParameter("profileSL");
							//System.err.println("168,profileSL==="+profileSL);
							String mealTypeDesc = "";//054259
							String[] dietType = dietTypeStr.split(",");
							String[] mealType = mealTypeStr.split(",");
							//System.err.println("170,dietType==="+dietType.length);
							//System.err.println("171,mealType==="+mealType.length);
							connection = ConnectionManager.getConnection(request);
							String dietTypeSql="select meal_type,short_desc from ds_meal_type";
							pstmt=connection.prepareStatement(dietTypeSql);
							rs2 = pstmt.executeQuery();
							HashMap dietTypeMap=new HashMap();
							while(rs2 != null && rs2.next())
								dietTypeMap.put(rs2.getString(1), rs2.getString(2));							
		                        	isAdditionalInstructions = CommonBean.isSiteSpecific(connection,"DS","PLACE_DIET_ORDER_INSTR");//Added against Ams-CRf-0112									
							
%>
							<div style="overflow-y: scroll;height:65vh;width:100%;">
<%
							for(i=0; i < dietType.length; i++)
							{
								String menuCodesql="select menu.SHORT_DESC , menu.MENU_CODE from DS_DIET_MENU_TIME_TABLE menuTimeTable, DS_MEAL_TYPE mealType, DS_MENU menu where menuTimeTable.MEAL_TYPE=mealType.MEAL_TYPE and menuTimeTable.MENU_CODE=menu.MENU_CODE and ((menuTimeTable.OPERATING_FACILITY_ID='"+facility_id+"' )and(menuTimeTable.KITCHEN_CODE='"+kitchenCode+"' )and(menuTimeTable.DIET_TYPE='"+dietType[i]+"' )and(menuTimeTable.MEAL_TYPE='"+mealType[i].trim()+"' )and(menuTimeTable.MEAL_CLASS='"+mealClass+"' )and(menuTimeTable.DAY_NO='"+Integer.parseInt(dayRef)+"' )) and menu.EFF_STATUS ='E'  order by  mealType.MEAL_ORDER , 2 , 1";	//Added EFF_STATUS Against AMS-SCF-0835 and Added EFF_STATUS in ds_menu against ML-MMOH-SCF-1881
								pstmt = connection.prepareStatement(menuCodesql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
								//System.err.println("185,menuCodesql==="+menuCodesql);
								resultSet = pstmt.executeQuery();
								//054259
								if(mealType[i] != null && mealType[i].trim().length() > 0)
									mealTypeDesc = dietTypeMap.get((mealType[i]).trim()).toString();
									
								//System.err.println("191,mealTypeDesc==="+mealTypeDesc);	
								//System.err.println("194,mealType[i]==="+mealType[i]);	
								//054259
								mealList.clear();
								while(resultSet != null && resultSet.next())
								{
									menuCode = resultSet.getString(2);
									mealList.add(menuCode);
								}

//Added Against KDAH-CRF-0352 US4 & US6 starts Here
isMealMenuDisplay = CommonBean.isSiteSpecific(connection,"DS","DS_MEAL_MENU_ITEMS");
//System.err.println("205, isMealMenuDisplay===>"+isMealMenuDisplay);
//KDAH-CRF-0352-Scroll Starts here
if(isMealMenuDisplay){
%>
<style>
	.ALLTABLES{
	   width:980px;
	   min-width: 100%;
	   overflow-x:auto;
	   height:auto;	 
	}
	
	.ALLTABLESDATA{
		table-layout: fixed;
		width: 100%;
	    margin-bottom:10px;
	}
	
	.widthSmallpx{
	 width:160 px;
	}
	
	.widthBigpx{
	 width:350px;
	}

	.TABSCENTER{
	display:table;
	text-align :center;
	vertical-align :middle;
	}
	</style>
<%}else{%>
<%}%>
<%
// KDAH-CRF-0352-Scroll Ends here
		LinkedHashMap allMenuItemsnew = new LinkedHashMap();
		ArrayList allMenuItemsListnew = new ArrayList();									
		ArrayList menuItemsListnew = new ArrayList();
		ArrayList reviewedMenuItemsListnew = new ArrayList();
		String fooditemcodetemp ="''";								
		if(mealList != null)
		{
		for(int j=0; j<mealList.size(); j++)
		{
		if(updateMealsDetailsMap == null)
			{												
				UpdateMealMenuObject updateMealMenuObjectnew = new UpdateMealMenuObject();
				updateMealMenuObjectnew.setMealList(mealList.get(j));
				updateMealMenuObjectnew.setLocale(locale);
				updateMealMenuObjectnew.setFacilityId(facility_id);
				updateMealMenuObjectnew.setKitchenCode(kitchenCode);
				updateMealMenuObjectnew.setDietType(dietType[i]);
				updateMealMenuObjectnew.setMealClass(mealClass);
				updateMealMenuObjectnew.setDayRef(dayRef);
				updateMealMenuObjectnew.setMealType(mealType[i].trim());
				updateMealMenuObjectnew.setEncounterId(encounterId);
				updateMealMenuObjectnew.setProfileSL(profileSL);
				updateMealMenuObjectnew.setDateforMenu(dateForMenu);											
				allMenuItemsnew = bean.getAllMenuItems(updateMealMenuObjectnew);
				menuItemsListnew = (ArrayList)allMenuItemsnew.get("MENUITEMS");
				reviewedMenuItemsListnew = (ArrayList)allMenuItemsnew.get("REVIEWEDMENUITEMS");
			}	
			else
			{
				allMenuItemsListnew = (ArrayList)(((LinkedHashMap)updateMealsDetailsMap.get("MEALTYPEMENUITEMSLISTMAP")).get(mealType[i].toString()));												
				if(allMenuItemsListnew != null)
				{
					menuItemsListnew = (ArrayList)allMenuItemsListnew.get(0);
					reviewedMenuItemsListnew = (ArrayList)allMenuItemsListnew.get(1);
				}
				else
				{
					menuItemsListnew = new ArrayList();
					reviewedMenuItemsListnew = new ArrayList();
				}
			}											
										//Modified Against 	ICN-#65555 0352							
			if(menuItemsListnew != null)
				{												
					for(int z=0; z<menuItemsListnew.size(); z++)
						{ 
						/* Setup related items for Assign DietType - Eg-Breakfast (Carrot,Idly, Milk) */
						updateMealMenuObject = (UpdateMealMenuObject)menuItemsListnew.get(z);
										if(mealType[i].trim().equalsIgnoreCase(updateMealMenuObject.getMealType()))
											{
												if(z==0)
												fooditemcodetemp="'"+updateMealMenuObject.getItemCode()+"'";
												else
												fooditemcodetemp+=",'"+updateMealMenuObject.getItemCode()+"'";
												}
												}
										}				
										//Modified Against 	ICN-#65555 0352
									/* Newly Added items for Assign DietType - Eg-Breakfast (Dosai) */	
											if(reviewedMenuItemsListnew != null)
										  {
												for(int z=0; z<reviewedMenuItemsListnew.size(); z++)
												{
													updateMealMenuObject = (UpdateMealMenuObject)reviewedMenuItemsListnew.get(z);
										if(mealType[i].trim().equalsIgnoreCase(updateMealMenuObject.getMealType()))
												{
														  if(z==0)
															fooditemcodetemp+=","+"'"+updateMealMenuObject.getItemCode()+"'";
															else
															fooditemcodetemp+=",'"+updateMealMenuObject.getItemCode()+"'";
															
															}
												}																
										}
						
								
								}	
							}	
			String nutrient_desc="",nutrient_code="";
		//Commented against ICN-#65555 0352							
		//	String ItemDescsql="SELECT DISTINCT nutrient_code, ds_get_desc.ds_nutrients (nutrient_code, ?, '2') nutrient_desc, SUM(CONTENT_VALUE) totkcal,am_get_desc.am_uom (b.uom_code, ?, '2') serving_uom_desc FROM ds_food_item_nutrients a, ds_nutrients b WHERE a.food_item_code IN ("+fooditemcodetemp+") AND b.nutrients_code = a.nutrient_code GROUP BY nutrient_code, uom_code";
		//Modified against ICN-#65555 0352
		String ItemDescsql="SELECT  nutrient_code, nutrient_desc, sum(totkcal) totkcal,serving_uom_desc FROM(SELECT c.item_code, c.item_qty, a.nutrient_code, a.food_item_code,b.short_desc nutrient_desc, c.item_qty * a.content_value totkcal,am_get_desc.am_uom (b.uom_code, ?, '2') serving_uom_desc  FROM ds_menu_item c, ds_food_item_nutrients a, ds_nutrients b WHERE c.item_code IN ("+fooditemcodetemp+") AND a.food_item_code = c.item_code  AND b.nutrients_code = a.nutrient_code   AND menu_code = ? AND item_code NOT IN (SELECT item_code FROM ds_epsd_diet_prof_dtl_reviewed dtlreviewed WHERE dtlreviewed.operating_facility_id = ? AND (dtlreviewed.encounter_id = ?)           AND (dtlreviewed.profile_sl = ?) AND dtlreviewed.MEAL_TYPE = ? AND (   (    (dtlreviewed.serving_date IS NOT NULL) AND (TO_CHAR (dtlreviewed.serving_date, 'dd/mm/yyyy') = ?)) OR ((    (dtlreviewed.serving_date IS NULL) AND (dtlreviewed.cycle_day_ref = '"+Integer.parseInt(dayRef)+"'))))) UNION ALL SELECT dtlreviewed.item_code, dtlreviewed.item_qty,a.nutrient_code, a.food_item_code, b.short_desc nutrient_desc,       case when dtlreviewed.review_type = 'M' THEN 0 else dtlreviewed.item_qty * a.content_value END totkcal,am_get_desc.am_uom (b.uom_code, ?, '2') serving_uom_desc FROM ds_epsd_diet_prof_dtl_reviewed dtlreviewed,ds_food_item_nutrients a,ds_nutrients b WHERE dtlreviewed.operating_facility_id = ? AND (dtlreviewed.encounter_id = ?) AND (dtlreviewed.profile_sl = ?)  AND dtlreviewed.item_code IN ("+fooditemcodetemp+") AND a.food_item_code = dtlreviewed.item_code AND b.nutrients_code = a.nutrient_code AND dtlreviewed.MEAL_TYPE =? AND (   (    (dtlreviewed.serving_date IS NOT NULL) AND (TO_CHAR (dtlreviewed.serving_date, 'dd/mm/yyyy') = ?)) OR ((    (dtlreviewed.serving_date IS NULL) AND (dtlreviewed.cycle_day_ref = '"+Integer.parseInt(dayRef)+"') ))) ) Group by  nutrient_code, nutrient_desc, serving_uom_desc ";	
		//System.err.println("mealMenuItems.jsp,ItemDescsql========="+ItemDescsql);
			pstmt = connection.prepareStatement(ItemDescsql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE); 
			//Modified against ICN-#65555 0352
				pstmt.setString(1,locale);
				pstmt.setString(2,menuCode);
				pstmt.setString(3,facility_id);								
				pstmt.setString(4,encounterId);	
				pstmt.setString(5,profileSL);
				pstmt.setString(6,mealType[i].trim());
				pstmt.setString(7,dateForMenu);
				pstmt.setString(8,locale);
				pstmt.setString(9,facility_id);
				pstmt.setString(10,encounterId);
				pstmt.setString(11,profileSL);
				pstmt.setString(12,mealType[i].trim());
				pstmt.setString(13,dateForMenu);
				resultSet = pstmt.executeQuery();
				
				//Added Against KDAH-CRF-0352 US4 Ends Here
%>
	<table border='1' cellpadding='2' cellspacing='0' width='90%' align='center' bordercolor="#9999FF" >
		<tr>
			<th colspan="3">
				<img id="showHideArrow<%=i%>" src="../../eDS/css/arrow-up.png" alt="Arrow" align="left" onclick="showHideTab('<%=i%>');" />
				<%=mealType[i].trim()%>-<%=mealTypeDesc.trim()%>
				<input type="text" name="subtotal<%=i%>" id="subtotal<%=i%>" size=4 style="background:transparent;align:right;color=white;border=0" readonly="true" class="label" />
				<input type="text" name="Uom<%=i%>" id="Uom<%=i%>" size=4 style="background:transp arent;align:left;color=white;border=0" readonly="true" class="label" />
			</th>
		</tr>
	</table>	
	<!-- KDAH-CRF-0352-Scroll Start -->
		<div class="TABSCENTER" id="showHideTab<%=i%>" >
		<div  class= "ALLTABLES" >
	<table class="ALLTABLESDATA" width="90%" border='1' cellpadding='2' cellspacing='0' align='center' bordercolor="#9999FF" id="<%=mealType[i].trim()%>-<%=mealTypeDesc.trim()%>">
	<!-- KDAH-CRF-0352-Scroll End -->
		<tr align="center">
		<!--Modified Against KDAH-CRF-0352 Serve US4-->
			<td class="data widthSmallpx"> <!-- KDAH-CRF-0352-Scroll -->
				<input type='checkbox' id="serveChkUnchkAll<%=i%>" checked="checked" onclick="chkUnchkAll('<%=i%>')" /> 
				<%-- AAKH-CRF-0065 Sp2Us2Us3 --%>
				<fmt:message key="eOT.serve.Label" bundle="${ot_labels}" />
			</td>
	<!-- KDAH-CRF-0352-Scroll Start -->
			<td class="data widthSmallpx" > Item </td>
			<td class="data widthBigpx"> <fmt:message key="eOT.qty.Label" bundle="${ot_labels}" /> </td>
	<!-- KDAH-CRF-0352-Scroll End -->
	<!--Added Against KDAH-CRF-0352 US4 Starts Here-->					
<%
		int count_nutrients=0;
		int rows_count =0;
		if (resultSet.last()) {
				rows_count = resultSet.getRow();			
				resultSet.beforeFirst();
			}
		String Kcalo_Total[]=new String[rows_count];
		String NutrientDesc[]=new String[rows_count];
		while(resultSet != null && resultSet.next())
		{
			nutrient_code= resultSet.getString(1);				
			nutrient_desc = resultSet.getString(2);	
			NutrientDesc[count_nutrients]=nutrient_desc;
			Kcalo_Total[count_nutrients]=resultSet.getString(3)+" "+resultSet.getString(4);
			count_nutrients++;
%>
<%
//System.err.println("374, isMealMenuDisplay===>"+isMealMenuDisplay);
if(isMealMenuDisplay){//KDAH-CRF-0352-US6
%>
									
			<td class="data widthSmallpx" > <%=nutrient_desc%> </td><!-- KDAH-CRF-0352-Scroll -->
<%	
	}
%>
<%
	}
	//String ServingUomQty[]=new String[count_nutrients];
%>
	<!--Added Against KDAH-CRF-0352 US4 Ends Here-->							
	</tr>
<%
if(mealList != null)
{
for(int j=0; j<mealList.size(); j++)
{
	chkUnchkCnt = 0;
	menuItemsCnt = 0;
	chkedCnt = 0;
	menuCodeVal = mealList.get(j);//054259
	if(updateMealsDetailsMap == null)
	{
		updateMealMenuObject = new UpdateMealMenuObject();
		updateMealMenuObject.setMealList(mealList.get(j));
		updateMealMenuObject.setLocale(locale);
		updateMealMenuObject.setFacilityId(facility_id);
		updateMealMenuObject.setKitchenCode(kitchenCode);
		updateMealMenuObject.setDietType(dietType[i]);
		updateMealMenuObject.setMealClass(mealClass);
		updateMealMenuObject.setDayRef(dayRef);
		updateMealMenuObject.setMealType(mealType[i].trim());
		updateMealMenuObject.setEncounterId(encounterId);
		updateMealMenuObject.setProfileSL(profileSL);
		updateMealMenuObject.setDateforMenu(dateForMenu);
		allMenuItems = bean.getAllMenuItems(updateMealMenuObject);
		menuItemsList = (ArrayList)allMenuItems.get("MENUITEMS");
		reviewedMenuItemsList = (ArrayList)allMenuItems.get("REVIEWEDMENUITEMS");
%>

<%
if(isMealMenuDisplay){//KDAH-CRF-0352-US6
%>
			<td class="widthSmallpx"><%updateMealMenuObject.setMealList(mealList.get(j));%></td><!-- KDAH-CRF-0352-Scroll -->
			</tr>
<%
}
%>

<%	
		}
		else
		{
			allMenuItemsList = (ArrayList)(((LinkedHashMap)updateMealsDetailsMap.get("MEALTYPEMENUITEMSLISTMAP")).get(mealType[i].toString()));												
			if(allMenuItemsList != null)
			{
				menuItemsList = (ArrayList)allMenuItemsList.get(0);
				reviewedMenuItemsList = (ArrayList)allMenuItemsList.get(1);
			}//054259
			else
			{
				menuItemsList = new ArrayList();
				reviewedMenuItemsList = new ArrayList();
			}
		}						
						
		if(menuItemsList != null)
		{
			chkedCnt = menuItemsList.size();
			for(int z=0; z<menuItemsList.size(); z++)
			{
				updateMealMenuObject = (UpdateMealMenuObject)menuItemsList.get(z);
				k = 0;
				itemSL = updateMealMenuObject.getItemSL();
				item_Type = updateMealMenuObject.getItemType();
				item_Code = updateMealMenuObject.getItemCode();
				//System.err.println("280,item_Code==="+item_Code);
				itemShortDesc = updateMealMenuObject.getItemShortDesc();
				item_Qty = updateMealMenuObject.getItemQty();
				//Added against AMS-CRF-0112 Starts here
				if(isAdditionalInstructions)
				{
					additionalInstrDate=checkForNull(updateMealMenuObject.getAdditionalInstrDate());
				if(additionalInstrDate.equals(menuDate))
					AdditionalInstruction=checkForNull(updateMealMenuObject.getAdditionalInstructions2(mealType[i].trim()));//Added against AMS-CRF-0112 	
				else													
					AdditionalInstruction="";
				}
				//Added against AMS-CRF-0112 Ends here
				meal_Type = updateMealMenuObject.getMealType();
				mealTypeShortDesc = updateMealMenuObject.getMealTypeShortDesc();
				//Added Against KDAH-CRF-0352 Starts Here
				serving_Uom_Code = updateMealMenuObject.getServingUomCode();
				serving_Uom_Desc=updateMealMenuObject.getServingUomDesc();
				//Added Against KDAH-CRF-0352 Ends Here
				if(updateMealMenuObject.getCalorificContPerUom() != null)//054259
					calorific_Cont_Per_Uom = updateMealMenuObject.getCalorificContPerUom();
				//Added Against KDAH-CRF-0352 starts Here
				energy_Uom = updateMealMenuObject.getEnergyUom();
				energy_Uom_Desc=updateMealMenuObject.getEnergyUomDesc();
				//Added Against KDAH-CRF-0352 Ends Here
				//Added Against KDAH-CRF-0352 starts Here and ICN-#65555
				NutrientDesc_temp = updateMealMenuObject.getNutrientDesc();
				NutrientUomQty=updateMealMenuObject.getServingUomQty();
				dsNutrientValues=checkForNull(updateMealMenuObject.getdsNutriValue()); //14 Added Against IN:067604 by SelvinM
				// Added Against IN:067604 Start by SelvinM
				if(dsNutrientValues.length()>0)
				{
				StringTokenizer tokenizer = new StringTokenizer(dsNutrientValues, "$$");        				
				while(tokenizer.hasMoreTokens()){						
					System.err.println("522,==="+tokenizer.nextToken());				
					NutrientDesc_temp = tokenizer.nextToken();
					NutrientUomQty = tokenizer.nextToken();
					}  					
				}
				// Added Against IN:067604 End by SelvinM
				//Added Against KDAH-CRF-0352 Ends Here and ICN-#65555
				reviewType = "F";											
%>
			<tr>
		<!--Modified Against KDAH-CRF-0352 Serve US4-->
			<td align='center' class="widthSmallpx"><!-- KDAH-CRF-0352-Scroll -->
				<input type='checkbox' name="check<%=mealType[i].trim()%>-<%=mealTypeDesc.trim()%>" id="check<%=mealType[i].trim()%>-<%=mealTypeDesc.trim()%>" id="serveChkUnchk<%=i%><%=menuItemsCnt%>" checked="checked" onclick="updateCalori('<%=counter%>','<%=i%>','true',' ',this,'chk');return changeIT('<%=counter%>',this)" value="<%=i%>" /> <%-- AAKH-CRF-0065 Sp2Us2Us3 --%>
			</td>
								
			<td id="<%=meal_Type%>_<%=item_Code%>" class="label widthSmallpx" ><!-- KDAH-CRF-0352-Scroll -->
				<div id="div<%=meal_Type%>_<%=item_Code%>"><%=itemShortDesc%></div>
				<input type="hidden" name="mealType<%=counter%>" id="mealType<%=counter%>" value="<%=meal_Type%>"/>
				<input type="hidden" name="itemCode<%=counter%>" id="itemCode<%=counter%>" value="<%=item_Code%>"/>
				<input type="hidden" name="menuCode<%=counter%>" id="menuCode<%=counter%>" value="<%=mealList.get(j)%>"/>
				<input type="hidden" name="foodItemDesc<%=counter%>" id="foodItemDesc<%=counter%>" value="<%=itemShortDesc%>"/>
				<input type="hidden" name="dietType<%=counter%>" id="dietType<%=counter%>" value="<%=dietType[i]%>"/>
				<input type="hidden" name="menuSL<%=counter%>" id="menuSL<%=counter%>" value=""/>
				<input type="hidden" name="mealmenuSL<%=counter%>" id="mealmenuSL<%=counter%>" value="0"/>
				<input type="hidden" name="reviewType<%=counter%>" id="reviewType<%=counter%>" value="N"/>
				<!--input type="hidden" name="methodFlag<%=counter%>" value="9"/-->
				<input type="hidden" name="methodFlag<%=counter%>" id="methodFlag<%=counter%>" value="5"/><!-- Modified Against AMRI-SCF-0701-->
				<input type="hidden" name="itemType<%=counter%>" id="itemType<%=counter%>" value="<%=item_Type%>"/>
				<input type="hidden" name="servingCodeUom<%=counter%>" id="servingCodeUom<%=counter%>" value="<%=serving_Uom_Code%>"/>
				<input type="hidden" name="servingCodeUomDesc<%=counter%>" id="servingCodeUomDesc<%=counter%>" value="<%=serving_Uom_Desc%>"/>
		<!-- Modified against KDAH-CRF-0352-->
				<input type="hidden" name="mealTypeDesc<%=counter%>" id="mealTypeDesc<%=counter%>" value="<%=mealTypeDesc%>"/>
			</td>
			<td class="widthBigpx"><!-- KDAH-CRF-0352-Scroll -->
				<%--IN:39962 chkifPositive method is invoked on keydown to allow only numbers.--%>
				<input type="text" name="itemQty<%=counter%>" id="itemQty<%=counter%>" onkeydown="return chkifPositive(event, this);" onblur="updateCalori('<%=counter%>','<%=i%>','true',' ',this,'true');return changeOfQty('<%=counter%>','<%=mealType[i].trim()%>-<%=mealTypeDesc.trim()%>','<%=k%>');" size="4" value='<%=Double.parseDouble(item_Qty)%>'/>
				<%=serving_Uom_Desc%><!--Modified against KDAH-CRF-0352-->
				<input type="hidden" name="calori<%=k%>" id="calori<%=k%>" />
				<input type="hidden" name="calorificContPerUom<%=counter%>" id="calorificContPerUom<%=counter%>"	value="<%=calorific_Cont_Per_Uom%>"/>
				<input type="hidden" size=4 name="energy" id="energy" value="<%=energy_Uom%>" /><!--Modified Against KDAH-CRF-0352 -->
				<input type="hidden" size=4 name="energyUomDesc" id="energyUomDesc" value="<%=energy_Uom_Desc%>" /><!--Modified Against KDAH-CRF-0352 -->
				<input type="hidden" size=4 name="NutrientDesc<%=counter%>" id="NutrientDesc<%=counter%>" value="<%=NutrientDesc_temp%>" /><!--Modified Against KDAH-CRF-0352 ICN-#65555-->																<input type="hidden" size=4 name="NutrientUomQty<%=counter%>" id="NutrientUomQty<%=counter%>" value="<%=NutrientUomQty%>" /><!--Modified Against KDAH-CRF-0352 ICN-#65555-->											
				<input type="hidden" size=4 name="energyUomDesc" id="energyUomDesc" value="<%=energy_Uom_Desc%>" /><!--Modified Against KDAH-CRF-0352 -->															(
				<input type="text" size=4 name="totalCal<%=counter%>" id="totalCal<%=counter%>"  style="background:transparent;border=0" readonly="true" class="label" />
				<%=energy_Uom_Desc%><!--Modified Against KDAH-CRF-0352 -->
				)
			<script>
				var caloriPerMeal;
				var calorific_Cont_Per_Uom='<%=Float.parseFloat(calorific_Cont_Per_Uom)%>';
				var item_Qty='<%=item_Qty%>';
				if(calorific_Cont_Per_Uom==0 || item_Qty==0)
					caloriPerMeal=0;
				else
					caloriPerMeal=parseInt("<%=item_Qty%>")*parseInt("<%=calorific_Cont_Per_Uom%>");
				document.getElementById("calori<%=k%>").value=caloriPerMeal;
				document.getElementById("totalCal<%=counter%>").value=caloriPerMeal;
			</script>
			<input type="hidden" name="Qty<%=counter%>" id="Qty<%=counter%>" value="<%=Double.parseDouble(item_Qty)%>" />
			<input type="hidden" name="IntQty<%=counter%>" id="IntQty<%=counter%>" value="<%=Double.parseDouble(item_Qty)%>" />
								</td>														 
		<input type="hidden" name="foodItem<%=mealType[i].trim()%>-<%=mealTypeDesc.trim()%>" id="foodItem<%=mealType[i].trim()%>-<%=mealTypeDesc.trim()%>" value="<%=item_Code%>" />
<!--Added Against KDAH-CRF-0352 US4 Starts Here-->											 
<%
	if(isMealMenuDisplay){//KDAH-CRF-0352-US6
				int m=0;														
				String NutrientDesctemp[]=new String[count_nutrients];
				String ServingUomQtytemp[]=new String[count_nutrients];
				HashMap<String,String> NutrientUOMQtyMap=new HashMap<String,String>();
				if(count_nutrients>0)
				{
				/* Added Against IN:067604 Start by SelvinM */
				//for(String Nutrient:checkForNull(updateMealMenuObject.getNutrientDesc()).split(","))
				for(String Nutrient:checkForNull(NutrientDesc_temp).split(","))
				/* Added Against IN:067604 End by SelvinM */
				{
					NutrientDesctemp[m]=Nutrient; //Eg-Fat,Vitamin (Carrot)
					m++;
				}
				m=0;
				/* Added Against IN:067604 Start by SelvinM */
				//for(String ServingUomQtytemp2:checkForNull(updateMealMenuObject.getServingUomQty()).split(","))
				for(String ServingUomQtytemp2:checkForNull(NutrientUomQty).split(","))
				/* Added Against IN:067604 End by SelvinM */
				{
					if(!ServingUomQtytemp2.equals("") && count_nutrients!=0 )
					{
						ServingUomQtytemp[m]=ServingUomQtytemp2; //Eg-5%, 7 Gram (Carrot)
						m++;
					}
				}
				m=0;
				for(;m<NutrientDesctemp.length;m++)
				{
					NutrientUOMQtyMap.put(NutrientDesctemp[m],ServingUomQtytemp[m]);
				}
				m=0;
				String ServingUomQtytempVal="";
				for(;m<count_nutrients;m++)
				{														
					ServingUomQtytempVal=checkForNull(NutrientUOMQtyMap.get(NutrientDesc[m]));//Fat,5% & protein,"" & vitamin,7gm
				%>
					<input type="hidden" size=4 name="ServingUomColcnt<%=counter%>" id="ServingUomColcnt<%=counter%>" value="<%=NutrientDesctemp.length%>" />
				<%
				if(ServingUomQtytempVal.equalsIgnoreCase("")){
				%>
					<td>&nbsp;</td>
				<%
				}
				else{
				%>
					<td class="widthSmallpx"><!-- KDAH-CRF-0352-Scroll -->
					<input type="text" size=20 name="ServingUom<%=counter%><%=m%>" id="ServingUom<%=counter%><%=m%>"  style="background:transparent;border=0" readonly="true" class="label" />
					<script>					
						document.getElementById("ServingUom<%=counter%><%=m%>").value='<%=ServingUomQtytempVal%>';
					</script>
					</td><!-- Alignment -->					
				<%
				}
				}														
				}
				else
				{
				%>
				<input type="hidden" size=4 name="ServingUomColcnt<%=counter%>" id="ServingUomColcnt<%=counter%>" value="0" />
				<%
				}
	}//KDAH-CRF-0352-US6
				%>
<!--Added Against KDAH-CRF-0352 US4 Ends Here-->
						</tr>
						<script>
							var reviewType='<%=reviewType%>';
							if(reviewType!='M')
								subtotal=parseInt(subtotal)+parseInt(document.getElementById("calori<%=k%>").value);
						</script>
<%
						counter++;k++;
						menuItemsCnt++;
						chkUnchkCnt++;
					}
				}
				if(reviewedMenuItemsList != null)
				{
					for(int z=0; z<reviewedMenuItemsList.size(); z++)
					{
						updateMealMenuObject = (UpdateMealMenuObject)reviewedMenuItemsList.get(z);
						item_Type = updateMealMenuObject.getItemType();
						item_Code = updateMealMenuObject.getItemCode();
						itemShortDesc = updateMealMenuObject.getItemShortDesc();
						item_Qty = updateMealMenuObject.getItemQty();
						reviewType= updateMealMenuObject.getReviewType();
						meal_Type1 = updateMealMenuObject.getMealType();
						mealTypeShortDesc = updateMealMenuObject.getMealTypeShortDesc();
						//Added Against KDAH-CRF-0352 Starts here
						serving_Uom_Code = updateMealMenuObject.getServingUomCode();
						serving_Uom_Desc=updateMealMenuObject.getServingUomDesc();
						//Added Against KDAH-CRF-0352 Ends Here
						reviewSLNo= updateMealMenuObject.getReviewSLNo();
						if(updateMealMenuObject.getCalorificContPerUom() != null)
							calorific_Cont_Per_Uom = updateMealMenuObject.getCalorificContPerUom();
						//Modified Against KDAH-CRF-0352 starts Here
						energy_Uom = updateMealMenuObject.getEnergyUom();
						energy_Uom_Desc = updateMealMenuObject.getEnergyUomDesc();
						//Modified Against KDAH-CRF-0352 Ends Here
						//Added Against KDAH-CRF-0352 starts Here and ICN-#65555
						NutrientDesc_temp = updateMealMenuObject.getNutrientDesc(); //18
						NutrientUomQty=updateMealMenuObject.getServingUomQty(); //19
						/* Added Against IN:067604 Start by SelvinM */
						dsNutrientValues=checkForNull(updateMealMenuObject.getdsNutriValue()); //14 Added Against IN:067604 by SelvinM
						// Added Against IN:067604 Start by SelvinM
						if(dsNutrientValues.length()>0)
						{
						StringTokenizer tokenizer = new StringTokenizer(dsNutrientValues, "$$");        				
						while(tokenizer.hasMoreTokens()){						
							System.err.println("683,==="+tokenizer.nextToken());				
							NutrientDesc_temp = tokenizer.nextToken();
							NutrientUomQty = tokenizer.nextToken();
							}  					
						}
						// Added Against IN:067604 End by SelvinM
						//Added Against KDAH-CRF-0352 Ends Here and ICN-#65555
						//Added against AMS-CRF-0112 Starts here
						if(isAdditionalInstructions)
						{
							additionalInstrDate=checkForNull(updateMealMenuObject.getAdditionalInstrDate());
						if(additionalInstrDate.equals(menuDate))
							AdditionalInstruction=checkForNull(updateMealMenuObject.getAdditionalInstructions2(mealType[i].trim()));//Added against AMS-CRF-0112 
						else
							AdditionalInstruction="";													
						}
									
						if((mealType[i].trim()).equals(meal_Type1)) 
						{
%>
							<tr>
							<!--Modified Against KDAH-CRF-0352 Serve US4 -->
							<td align ='center' class="widthSmallpx"><!-- KDAH-CRF-0352-Scroll -->
							<input type="hidden" name="reviewType<%=counter%>" id="reviewType<%=counter%>" value="<%=reviewType%>"/>
<%
							if(!reviewType.equals("M")) 
							{
								chkUnchkCnt++;
%>
								<input type='checkbox' name="check<%=mealType[i].trim()%>-<%=mealTypeDesc.trim()%>" id="check<%=mealType[i].trim()%>-<%=mealTypeDesc.trim()%>"  id="serveChkUnchk<%=i%><%=menuItemsCnt%>" checked="checked" onclick="updateCalori('<%=counter%>','<%=i%>','true',' ',this,'chk');return changeIT('<%=counter%>',this)" value="<%=i%>" /> <%-- AAKH-CRF-0065 Sp2Us2Us3 --%>
<%
							}
							else
							{
%>
								<input type='checkbox' name="check<%=mealType[i].trim()%>-<%=mealTypeDesc.trim()%>" id="check<%=mealType[i].trim()%>-<%=mealTypeDesc.trim()%>"  id="serveChkUnchk<%=i%><%=menuItemsCnt%>" onclick="updateCalori('<%=counter%>','<%=i%>','true',' ',this,'chk');return changeIT('<%=counter%>',this)" value="<%=i%>" /> <%-- AAKH-CRF-0065 Sp2Us2Us3 --%>
<%
							}
%>
						</td>
										
<%
						if(reviewType.equals("M"))
						{
%>
							<td id="<%=meal_Type1%>_<%=item_Code%>" class="label" style="FONT-SIZE: 8pt;COLOR: Brown;">
								<div id="div<%=meal_Type1%>_<%=item_Code%>" style="FONT-SIZE: 8pt;COLOR: Brown;" ><%=itemShortDesc%></div>
<% 
						}
						else
						{
%>
							<td id="<%=meal_Type1%>_<%=item_Code%>" class="label">
								<div id="div<%=meal_Type1%>_<%=item_Code%>" ><%=itemShortDesc%></div>
<%
						}
%>
						</td>
						<input type="hidden" name="mealType<%=counter%>" id="mealType<%=counter%>" value="<%=meal_Type1%>"/>
						<input type="hidden" name="itemCode<%=counter%>" id="itemCode<%=counter%>" value="<%=item_Code%>"/>
						<input type="hidden" name="menuCode<%=counter%>" id="menuCode<%=counter%>" value="<%=mealList.get(j)%>"/>
						<input type="hidden" name="foodItemDesc<%=counter%>" id="foodItemDesc<%=counter%>" value="<%=itemShortDesc%>"/>
						<input type="hidden" name="dietType<%=counter%>" id="dietType<%=counter%>" value="<%=dietType[i]%>"/>
						<input type="hidden" name="menuSL<%=counter%>" id="menuSL<%=counter%>" value="<%=reviewSLNo%>"/>
<%
						if(reviewSLNo == null)
						{
%>
							<input type="hidden" name="mealmenuSL<%=counter%>" id="mealmenuSL<%=counter%>" value="0"/>
<%
						}
						else
						{
%>
						<input type="hidden" name="mealmenuSL<%=counter%>" id="mealmenuSL<%=counter%>" value="2"/>
<%
						}
%>
						<input type="hidden" name="reviewType<%=counter%>" id="reviewType<%=counter%>" value="<%=reviewType%>"/>
						<input type="hidden" name="methodFlag<%=counter%>" id="methodFlag<%=counter%>" value="5"/>
						<input type="hidden" name="itemType<%=counter%>" id="itemType<%=counter%>" value="<%=item_Type%>"/>
						<input type="hidden" name="servingCodeUom<%=counter%>" id="servingCodeUom<%=counter%>" value="<%=serving_Uom_Code%>"/>
						<input type="hidden" name="servingCodeUomDesc<%=counter%>" id="servingCodeUomDesc<%=counter%>" value="<%=serving_Uom_Desc%>"/><!-- Modified against KDAH-CRF-0352-->
						<input type="hidden" name="mealTypeDesc<%=counter%>" id="mealTypeDesc<%=counter%>" value="<%=mealTypeDesc%>"/>
						<td>
							<%--IN:39962 chkifPositive method is invoked on keydown to allow only numbers.--%>
							<input type="text" name="itemQty<%=counter%>" id="itemQty<%=counter%>" onkeydown="return chkifPositive(event, this);" onblur="updateCalori('<%=counter%>','<%=i%>','true',' ',this,'true');return changeOfQty('<%=counter%>','<%=mealType[i].trim()%>-<%=mealTypeDesc.trim()%>','<%=k%>');" size="4" value='<%=Double.parseDouble(item_Qty)%>'/>
							<%=serving_Uom_Desc%><!-- Modified against KDAH-CRF-0352-->
							<script>
								var counter=<%=counter%>;
								if(document.getElementById('reviewType'+counter).value=='M')
									document.getElementById("itemQty"+counter).readOnly=true;
							</script>
							<input type="hidden" name="calori<%=k%>" id="calori<%=k%>" />
							<input type="hidden" name="calorificContPerUom<%=counter%>" id="calorificContPerUom<%=counter%>"	value="<%=calorific_Cont_Per_Uom%>"/>
							<input type="hidden" size=4 name="energy" id="energy" value="<%=energy_Uom%>" /><!--Modified Against KDAH-CRF-0352-->																
							<input type="hidden" size=4 name="NutrientDesc<%=counter%>" id="NutrientDesc<%=counter%>" value="<%=NutrientDesc_temp%>" /><!--Modified Against KDAH-CRF-0352 ICN-#65555-->
							<input type="hidden" size=4 name="NutrientUomQty<%=counter%>" id="NutrientUomQty<%=counter%>" value="<%=NutrientUomQty%>" /><!--Modified Against KDAH-CRF-0352 ICN-#65555-->												
							<input type="hidden" size=4 name="energyUomDesc" id="energyUomDesc" value="<%=energy_Uom_Desc%>" /><!--Modified Against KDAH-CRF-0352-->
							(
								<input type="text" size=4 name="totalCal<%=counter%>" id="totalCal<%=counter%>"  style="background:transparent;border=0" readonly="true" class="label" />
								<%=energy_Uom_Desc%><!--Modified against KDAH-CRF-0352-->
							 )
				<script>
					var caloriPerMeal;
					var calorific_Cont_Per_Uom='<%=Float.parseFloat(calorific_Cont_Per_Uom)%>';
					var item_Qty='<%=item_Qty%>';
					if(calorific_Cont_Per_Uom==0 || item_Qty==0)
						caloriPerMeal=0;
					else 
						caloriPerMeal=parseInt("<%=item_Qty%>")*parseInt("<%=calorific_Cont_Per_Uom%>");
					document.getElementById("calori<%=k%>").value=caloriPerMeal;
					document.getElementById("totalCal<%=counter%>").value=caloriPerMeal;
				</script>
				<input type="hidden" name="Qty<%=counter%>" id="Qty<%=counter%>" value="<%=item_Qty%>" />
				<input type="hidden" name="IntQty<%=counter%>" id="IntQty<%=counter%>" value="<%=Double.parseDouble(item_Qty)%>" />
			</td>
															
	<input type="hidden" name="foodItem<%=mealType[i].trim()%>-<%=mealTypeDesc.trim()%>" id="foodItem<%=mealType[i].trim()%>-<%=mealTypeDesc.trim()%>" value="<%=item_Code%>" />			
														
	<!-- Added Against ICN-#65555 0352 KDAH-CRF-0352 US4 Starts Here-->
	<%						
		if(isMealMenuDisplay){//KDAH-CRF-0352-US6		
			int m=0;														
			String NutrientDesctemp[]=new String[count_nutrients];
			String ServingUomQtytemp[]=new String[count_nutrients];
			HashMap<String,String> NutrientUOMQtyMap=new HashMap<String,String>();
			if(count_nutrients>0)
			{
			/* Added Against IN:067604 Start by SelvinM */
			//for(String Nutrient:checkForNull(updateMealMenuObject.getNutrientDesc()).split(","))
			for(String Nutrient:checkForNull(NutrientDesc_temp).split(","))
			/* Added Against IN:067604 End by SelvinM */
			{
				NutrientDesctemp[m]=Nutrient;
				m++;
			}
			m=0;
			/* Added Against IN:067604 Start by SelvinM */
			//for(String ServingUomQtytemp2:checkForNull(updateMealMenuObject.getServingUomQty()).split(","))
			for(String ServingUomQtytemp2:checkForNull(NutrientUomQty).split(","))
			/* Added Against IN:067604 End by SelvinM */
			{
				if(!ServingUomQtytemp2.equals("") && count_nutrients!=0 )
				{
					ServingUomQtytemp[m]=ServingUomQtytemp2;
					m++;
				}
			}
			m=0;
			for(;m<NutrientDesctemp.length;m++)
			{
				NutrientUOMQtyMap.put(NutrientDesctemp[m],ServingUomQtytemp[m]);
			}
			m=0;
			String ServingUomQtytempVal="";
			for(;m<count_nutrients;m++)
			{														
				ServingUomQtytempVal=checkForNull(NutrientUOMQtyMap.get(NutrientDesc[m]));
			%>
				<input type="hidden" size=4 name="ServingUomColcnt<%=counter%>" id="ServingUomColcnt<%=counter%>" value="<%=NutrientDesctemp.length%>" />
			<%
			if(ServingUomQtytempVal.equalsIgnoreCase(""))
			%>
				<td>&nbsp;</td>
			<%
			else{
			%>
				<td>
				<input type="text" size=4 name="ServingUom<%=counter%><%=m%>" id="ServingUom<%=counter%><%=m%>"  style="background:transparent;border=0" readonly="true" class="label" />&nbsp;
				<script>									
				document.getElementById("ServingUom<%=counter%><%=m%>").value='<%=ServingUomQtytempVal%>';
				</script>
				</td>					
			<%
			}
			}														
			}
			else
			{
			%>
			<input type="hidden" size=4 name="ServingUomColcnt<%=counter%>" id="ServingUomColcnt<%=counter%>" value="0" />
			<%
			}
			}//KDAH-CRF-0352-US6
			%>
		<!--Added Against ICN-#65555 0352 KDAH-CRF-0352 US4 Ends Here-->					
		</tr>
		<script>
			var reviewType='<%=reviewType%>';
			if(reviewType!='M')
				subtotal=parseInt(subtotal)+parseInt(document.getElementById("calori<%=k%>").value);
		</script>
<% 
					counter++;k++;
					menuItemsCnt++;
					chkedCnt++;
					meal_Type = meal_Type1;
					}
				}
			}
%>
			<input type="hidden" name="tabSize<%=i%>" id="tabSize<%=i%>" id="tabSize<%=i%>" value="<%=menuItemsCnt%>"> <%-- AAKH-CRF-0065 Sp2Us2Us3 --%>
<%
			}
%>
			<input type="hidden" name="<%=mealType[i].trim()%>" id="<%=mealType[i].trim()%>" id="<%=mealType[i].trim()%>" value="<%=menuCodeVal%>">
<%
			}
%>
<%
if(isMealMenuDisplay){//KDAH-CRF-0352-US6
%>
			<!--Added Against KDAH-CRF-0352 US4 Starts Here-->
					<tr>
					<td colSpan="3">Total</td>
					<%
					for(int m=0;m<count_nutrients;m++)
					{									
					%>
					<td><input type="text" size=20 name="Kcalo_Total<%=i%><%=m%>" id="Kcalo_Total<%=i%><%=m%>"  style="background:transparent;border=0" readonly="true" class="label" value='<%=Kcalo_Total[m]%>'/>&nbsp;</td>
					<%}%>									
					</tr>
<%
}//KDAH-CRF-0352-US6
%>
				<!--Added Against KDAH-CRF-0352 US4 Ends Here-->							
					<tr>
						<td align="right" colspan="3" class="label" >
							<script>
							// AAKH-CRF-0065 Sp2Us2Us3 start
							
							if('<%=chkedCnt%>' != '<%=chkUnchkCnt%>'){								
								$("#serveChkUnchkAll"+'<%=i%>').prop("checked", false);
							}	
							// AAKH-CRF-0065 Sp2Us2Us3 end
							gt=parseInt(gt)+parseInt(subtotal);
							var uom;
							document.getElementById("subtotal<%=i%>").value=subtotal;
							//Commented Against ICN-#65555 0352
							/*if(document.getElementById("energy") != null && document.getElementById("energy") != "") {
								uom = document.getElementById("energy").value;
							}*/
							
					//Added Against ICN-#65555 0352 starts Here
					if(document.getElementById("energyUomDesc") != null && document.getElementById("energyUomDesc") != ""){
						uom=document.getElementById("energyUomDesc").value;
					}
					//Added Against ICN-#65555 0352 Ends Here

								var uomLower;
								if(uom != "" && uom != null)
									 uomLower = uom.toLowerCase();
								else uomLower="";
									document.getElementById("Uom<%=i%>").value= uomLower;
								subtotal=0;
								</script>
						</td>
					</tr>					
					<!--Added against AMS-CRF-112 Starts Here-->
					<!-- KDAH-CRF-0352-Scroll Start -->		
					</table>
					</div>					
					<table border='1' cellpadding='2' cellspacing='0' width='90%' align='center' bordercolor="#9999FF">
					<!-- KDAH-CRF-0352-Scroll End -->		
					<tr>
					<% if(isAdditionalInstructions) 
						{
						
						String DBAdditionalInstructionsql="select MEAL_ADDT_INST  from DS_ADDT_INST_FOR_MEAL   where MEAL_TYPE='"+mealType[i].trim()+"' and  ENCOUNTER_ID='"+encounterId+"' and PROFILE_SL='"+profileSL+"' and (to_char(MENU_DATE , 'dd/mm/yyyy')='"+menuDate+"')  ";
						pstmt = connection.prepareStatement(DBAdditionalInstructionsql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
						resultSet = pstmt.executeQuery();		
									DBAdditionalInstruction="";								
						while(resultSet != null && resultSet.next())
							{
								DBAdditionalInstruction = checkForNull(resultSet.getString(1));						
							}
								
						if(AdditionalInstruction.equals("") || AdditionalInstruction.equals("null"))
						{
						%>						
						<input type='hidden' id="DBAdditionalInstruction<%=mealType[i].trim()%>" name="DBAdditionalInstruction<%=mealType[i].trim()%>" value="<%=DBAdditionalInstruction%>"><!--Added against AMS-CRF-112 Ends Here-->	
						
					   <input type='hidden' id="AdditionalInstruction<%=mealType[i].trim()%>" name="AdditionalInstruction<%=mealType[i].trim()%>" value="<%=DBAdditionalInstruction%>"><!--Modified Against ICN-64406 -->
					<%}else {%>					
						<input type='hidden' id="DBAdditionalInstruction<%=mealType[i].trim()%>" name="DBAdditionalInstruction<%=mealType[i].trim()%>" value="<%=DBAdditionalInstruction%>"><!--Added against AMS-CRF-112 Ends Here-->	
						
					   <input type='hidden' id="AdditionalInstruction<%=mealType[i].trim()%>" name="AdditionalInstruction<%=mealType[i].trim()%>" value="<%=AdditionalInstruction%>"><!--Modified Against ICN-64406 -->
					<%}%>
					<td align="left">							
						<a href="javascript:callBlank()" onclick="return openDialogWindow1(lblAdditionalInstruction,document.forms[0].AdditionalInstruction<%=mealType[i].trim()%>,document.forms[0].DBAdditionalInstruction<%=mealType[i].trim()%>,'150')" OnMouseOver="Tip(additionalInstructionToolTip(document.forms[0].AdditionalInstruction<%=mealType[i].trim()%>,document.forms[0].DBAdditionalInstruction<%=mealType[i].trim()%>),JUMPHORZ,true)"  onmouseout="UnTip()"> + <fmt:message key="eDS.AdditionalInstruction.Label" bundle="${ds_labels}" /> <!--Modified Against ICN-64406 -->
						</a>						
					</td>
					<%	}
					if(menuCode!=""){	//Added Against ML-MMOH-SCF-1881
					%>
				<!-- Added Against CRF-0112 Ends Here-->
					<td align="right" colspan="3">
						<a href="javascript:callBlank()" onclick="return AddItem('<%=mealType[i].trim()%>-<%=mealTypeDesc.trim()%>');"> + <fmt:message key="eOT.addItem.Label" bundle="${ot_labels}" /> </a>
					</td>
					<%	}
					%>
					</tr>					
				</table>
				</div>
				<table>
					<tr>
						<td> &nbsp; </td>
					</tr>
				</table>
<%								
			}
			//MMS-KH-CRF-0029.1-US008 Start
			String enableDrugFood="select ENABLE_DRUG_FOOD_YN from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = '"+facility_id+"'";
			pstmt=connection.prepareStatement(enableDrugFood);						
			rs2=pstmt.executeQuery();
			while(rs2 != null && rs2.next()){
				enableDrugYN=checkForNull(rs2.getString("ENABLE_DRUG_FOOD_YN"));
			}
			if(rs2!=null) rs2.close();
			if(pstmt!=null) pstmt.close();
			//MMS-KH-CRF-0029.1-US008 Ends
%>
						</div>
<%
					}
				catch(Exception e) 
				{
					e.printStackTrace();
					System.err.println("Exception in mealMenuItems.jsp=="+e);
				}
				finally{
					if(resultSet!=null) resultSet.close();
					if(rs!=null) rs.close();
					if(rs1!=null) rs1.close();
					if(rs2!=null) rs2.close();
					if(pstmt!=null) pstmt.close();
					if(connection!=null)
						ConnectionManager.returnConnection(connection,request);
				}
%>
		<input type="hidden" name="mealTypelen" id="mealTypelen" value="<%=i%>"/>
		<input type="hidden" name="textlen" id="textlen" value="<%=counter%>" />

		<table border='1' cellpadding='2' cellspacing='0' width='90%' align='center' bordercolor="#9999FF" style="overflow-x:scroll;"><tr><!-- KDAH-CRF-0352-Scroll -->
		<tbody id="dispGTClorie" align="center" BORDER = 1 style="overflow:auto;" class="label"></tbody>
		<td>
		<script>
			var cal1;
			var uom;
			//Commented Against ICN-#65555 0352 starts Here
			/*if(document.getElementById("energy") != null && document.getElementById("energy") != ""){
				cal1=document.getElementById("energy").value;
			}*/
			//Commented Against ICN-#65555 0352 Ends Here
			
			//Added Against ICN-#65555 0352 starts Here
		if(document.getElementById("energyUomDesc") != null && document.getElementById("energyUomDesc") != ""){
			cal1=document.getElementById("energyUomDesc").value;
		}
		//Added Against ICN-#65555 0352 Ends Here

			var cal;
			if(cal1 != "" && cal1 != null)
				cal=cal1.toLowerCase();
			else
				cal = "";

			var tbodyObj = document.all("dispGTClorie");
			if(tbodyObj.rows.length>=1)
				tbodyObj.deleteRow(0);
			var newRow1 = tbodyObj.insertRow(0);
			var labelCel = newRow1.insertCell(newRow1.cells.length);

			labelCel.className = "lable";
			labelCel.style.fontWeight = "700";
			labelCel.style.fontSize ="8pt";
			labelCel.style.color ="#2B1B17";
			labelCel.setAttribute("border", "0px");
			labelCel.align = "left";
			labelCel.colSpan = "9";

			var label=getLabel("eOT.CalorieGrandTotal.Label","OT");
			//Commented Against ICN-#65555 0352
		/*if(document.getElementById("energy") != null && document.getElementById("energy") != ""){
			uom=document.getElementById("energy").value;
		}*/
		//Added Against ICN-#65555 0352 starts Here
		if(document.getElementById("energyUomDesc") != null && document.getElementById("energyUomDesc") != ""){
			uom=document.getElementById("energyUomDesc").value;
		}
		//Added Against ICN-#65555 0352 Ends Here
		var uomLowr;
		if(uom != "" && uom != null)
			uomLowr = uom.toLowerCase();
		else
			uomLowr = "";
		labelCel.appendChild(document.createTextNode(label+" :" +gt+" "+uomLowr));
			</script>
			</td></tr></table>
			<table border='0' cellpadding='2' cellspacing='0' width='90%' align='center' id="listContentTable" style="overflow-x:scroll;"><!-- KDAH-CRF-0352-Scroll -->
			<tr>
				<td align="right">
					
					<!-- input type="button" name="update" value="Ok" class="Button" onclick="return updateAllFields();" /--> <!-- Commented Against KDAH-CRF-0349.1[IN062717]US1 -->
					<input type="button" name="update" id="update" value="Update for Current Date" class="Button" onclick="return updateAllFields();" /> <!-- Added Against KDAH-CRF-0349.1[IN062717]US1 -->
					<input type="button" name="updateAll" id="updateAll" value="Update for All" class="Button" onclick="return updateAllFieldsAll();" /> <!-- Added Against KDAH-CRF-0349.1[IN062717]US2 -->
				</td>
			</tr>
			</table>
		<input type="hidden" name="foodItemCode" id="foodItemCode" value=""/>
		<input type="hidden" name="itemType" id="itemType" value=""/>
		<input type="hidden" name="mode" id="mode"/>
		<input type="hidden" name="insertMethod" id="insertMethod" value="<%=new Integer(com.iba.ehis.core.util.AppConstants.CREATE).toString()%>" />

		<br />
			<table border='0' cellpadding='2' cellspacing='0' width='90%' align='center' id="addItem" class="webglobeBoxBorder" style="overflow-x:scroll;"><!-- KDAH-CRF-0352-Scroll -->
			<tr>
				<th colspan="1" align="right">
					<fmt:message key="eOT.AddItemto.Label" bundle="${ot_labels}" />
				</th>
				<Th id="getName" colspan="3" align="left"></Th>
			</tr>
			<tr align="center">
			<!-- KDAH-CRF-0349-US004 Starts -->
			<td align="right" class="label">
					<fmt:message key="Common.Itemtype.label" bundle="${common_labels}"/>
			</td>
			<td>
			<select name="additemType" id="additemType" id="additemType" >
				<option value="">
					<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
				</option>
			<%
				try{
						String sql_meal ="SELECT DS_GET_DESC.DS_ITEM_TYPE(ITEM_TYPE,'"+locale+"','2'),ITEM_TYPE FROM DS_item_type WHERE NVL (EFF_STATUS, 'E') = 'E'";
						connection			= ConnectionManager.getConnection(request);
						pstmt			= connection.prepareStatement(sql_meal) ;
						rs				= pstmt.executeQuery();
						while(rs!=null && rs.next()){
						item_Code=rs.getString(2);
						itemShortDesc=rs.getString(1);
						if(itemShortDesc != null && !itemShortDesc.equals("")){
						
			%>
					<option value="<%=item_Code%>">
						<%=itemShortDesc%>
					</option>
			<%
						}
						}
						}catch(Exception e){
						e.printStackTrace();
					   }finally{
						try{
						if(rs!=null)rs.close();
						if(pstmt!=null)pstmt.close();
						if(connection!=null) ConnectionManager.returnConnection(connection,request);
						}catch(Exception e){}
						}
			%>
				</select>				
				</td>
			<!-- KDAH-CRF-0349-US004 Ends -->
				<td class="label">
					<fmt:message key="eOT.SelectItem.Label" bundle="${ot_labels}" />
				</td>				
				<td colspan="1">
					<input type="text" name="foodDesc" id="foodDesc" id="ItemS" maxlength="8" size="8" onblur="getFoodLookup_mealMenuItems(this);" value=""/>
					<input type="button" name="click" id="click" value="?" onClick='showLookup_mealMenuItems(document.getElementById("foodDesc"));' class="button"/>
				</td>
				
				<td class="label">
					<fmt:message key="eOT.qty.Label" bundle="${ot_labels}" />
				</td>
				<td>
					<INPUT type="text" name="Qty" id="Qty"  onkeydown="return chkifPositive(event,this);" size="6"> <!-- IN::41066 -->			
				</td>
			</tr>

			<tr>
				<td colspan="3" align="right">
					<input type="button" name="ADD" id="ADD" value="<fmt:message key='Common.Add.label' bundle='${common_labels}'/>" onclick="return addNewItem();" class="Button">
				</td>
				<td colspan="1" align="right" id="hiddn">
				</td>
			</tr>
		</table>					
										  
          	<input type="hidden" name="encounterId" id="encounterId"  value='<%=request.getParameter("encounterId")%>' />
			<input type="hidden" name="patientId" id="patientId" value='<%=request.getParameter("patientId")%>'/>
			<input type="hidden" name="patientClass" id="patientClass" value='<%=request.getParameter("patientClass")%>'/>
			<input type="hidden" name="mealClass" id="mealClass" value='<%=request.getParameter("mealClass")%>'/>
			<input type="hidden" name="to" id="to" />
			<input type="hidden" name="from" id="from" />
			<input type="hidden" name="locale" id="locale" value="<%=locale%>"/>
			<input type="hidden" name="language_Id" id="language_Id" value="<%=locale%>"/>
			<input type="hidden" name="toPattern" id="toPattern" value="dd/MM/yyyy" />
			<input type="hidden" name="fromPattern" id="fromPattern" value="dd/MM/yyyy" />
			<input type="hidden" name="profileSL" id="profileSL" value='<%=request.getParameter("profileSL")%>'/>
			<input type="hidden" name="dietTypesForMeals" id="dietTypesForMeals" value="<%=dietTypeStr%>" />
			<input type="hidden" name="dateFrom" id="dateFrom" value="<%=dateFrom%>"/>
			<input type="hidden" name="dateFromPattern" id="dateFromPattern" value="dd/MM/yyyy" />
			<input type="hidden" name="dateTo" id="dateTo" value="<%=dateTo%>"/>
			<input type="hidden" name="dateTo.pattern" id="dateTo.pattern" value="dd/MM/yyyy" />
			<input type="hidden" name="cycleDayRef" id="cycleDayRef" value="" />
			<input type="hidden" name="mealTypesforDietTypes" id="mealTypesforDietTypes" value="<%=mealTypeStr%>"/>
			<input type="hidden" name="kitchenCode" id="kitchenCode" />
			<INPUT type="hidden" name="servingUomCode" id="servingUomCode">
			<input type="hidden" name="addedFacilityId" id="addedFacilityId" />
			<input type="hidden" name="itemCal" id="itemCal" />
			<input type="hidden" name="subTotalItemCal" id="subTotalItemCal" />
			<input type="hidden" name="totalItemCal" id="totalItemCal" />
			<input type="hidden" name="foodType" id="foodType" />
			<input type="hidden" name="isMealMenuDisplay" id="isMealMenuDisplay" value="<%=isMealMenuDisplay%>" />
			<!--ML-MMOH-CRF-0427-->
			<input type="hidden" name="profileFlag" id="profileFlag" id="profileFlag" value="<%=profileFlag%>" />
			<input type="hidden" name="restrict_date_inpatients_yn" id="restrict_date_inpatients_yn" id="restrict_date_inpatients_yn" value="<%=restrict_date_inpatients_yn%>" />
			<input type="hidden" name="maximum_days_allowed" id="maximum_days_allowed" id="maximum_days_allowed" value="<%=maximum_days_allowed%>" />
			<input type="hidden" name="allValue" id="allValue" id="allValue" value="" /> <!-- Added Against  KDAH-CRF-0349.1 [IN062717]US2 -->
			<!-- MMS-KH-CRF-0029.1-US008 -->
			<input type="hidden" name="enableDrugYN" id="enableDrugYN" id="enableDrugYN" value="<%=enableDrugYN%>"/>
			<!--ML-MMOH-CRF-0427-->
				</td>
			</tr>
		</table>
	</form>
	<script>
		var count = '<%=counter%>';
		function AddItem(val)
		{
			// 055388 Start
			if(val != '-')
				document.getElementById("getName").innerText=val;
			else
				alert("No Meal types are available");
			// 055388 End
		}
	</script>
</body> 

