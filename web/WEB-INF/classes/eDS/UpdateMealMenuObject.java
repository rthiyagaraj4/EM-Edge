/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eDS;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import eDS.Common.DSAdapter;
//67181
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
//67181
//import eOT.JDBCStatementLogger;//Commented Against 11g Issue
public class UpdateMealMenuObject extends DSAdapter implements Serializable
{

	// Getters and Setters
	private static final long serialVersionUID = 1L;

	private String languageId = "";
	private int totalItems = 0;
	private String patientId = "";
	private String patientClass = "";
	private String encounterId = "";
	private String mealClass = "";
	private String dateforMenu = "";
	private String profileSL = "";
	private String dateFrom = "";
	private String dateTo = "";

	private String mealType = "";
	private String itemCode = "";
	private String menuCode = "";
	private String dietType = "";
	private String menuSL = "";
	private String mealmenuSL = "";
	private String reviewType = "";
	private String methodFlag = "";
	private String itemQty = "";
	//Added against AMS-CRF-0112 starts Here
	private LinkedHashMap<String,String> additionalInstructions2=new LinkedHashMap<String,String>();  	
	private String additionalInstrDate="";
	//Added against AMS-CRF-0112 Ends Here
	private String itemType = "";
	private String status = "";
	
	private String mealList = "";
	private String locale = "";
	private String facilityId = "";
	private String kitchenCode = "";
	private String dayRef = "";
	
	private String itemSL = "";
	private String itemShortDesc = "";
	private String mealTypeShortDesc = "";
	private String servingUomCode = "";
	private String calorificContPerUom = "";
	private String energyUom = "";
	private String reviewSLNo = "";
	//Added Against KDAH-CRF-0352 Starts Here
	private String servingUomDesc = "";
	private String energyUomDesc = "";
   //Added Against KDAH-CRF-0352 Ends Here   
   //Added Against KDAH-CRF-0352 US4 Starts Here
	private String nutrientDesc = "";
	private String servingUomQty = "";	
   //Added Against KDAH-CRF-0352 US4 Ends Here
   /* Added Against Start IN:067604 by SelvinM */
	private String dsNutriValue = ""; 		
	public String getdsNutriValue(){
		return dsNutriValue;
	}
	public void setdsNutriValue(String dsNutriValue){
		this.dsNutriValue = dsNutriValue;
	} 
   /* Added Against End IN:067604 by SelvinM */
   /* Added Against Start KDAH-CRF-0349.1 [IN062717]US2*/
	private String allValue = ""; 		
	public String getAllValue(){
		return allValue;
	}
	public void setAllValue(String allValue){
		this.allValue = allValue;
	} 
	/* Added Against End KDAH-CRF-0349.1 [IN062717]US2 */
	public String getLanguageId() {
		return languageId;
	}
	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}
	public int getTotalItems() {
		return totalItems;
	} 
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getPatientClass() {
		return patientClass;
	}
	public void setPatientClass(String patientClass) {
		this.patientClass = patientClass;
	}
	public String getEncounterId() {
		return encounterId;
	}
	public void setEncounterId(String encounterId) {
		this.encounterId = encounterId;
	}
	public String getMealClass() {
		return mealClass;
	}
	public void setMealClass(String mealClass) {
		this.mealClass = mealClass;
	}
	public String getDateforMenu() {
		return dateforMenu;
	}
	public void setDateforMenu(String dateforMenu) {
		this.dateforMenu = dateforMenu;
	}
	public String getProfileSL() {
		return profileSL;
	}
	public void setProfileSL(String profileSL) {
		this.profileSL = profileSL;
	}
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	public String getMealType() {
		return mealType;
	}
	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getDietType() {
		return dietType;
	}
	public void setDietType(String dietType) {
		this.dietType = dietType;
	}
	public String getMenuSL() {
		return menuSL;
	}
	public void setMenuSL(String menuSL) {
		this.menuSL = menuSL;
	}
	public String getMealmenuSL() {
		return mealmenuSL;
	}
	public void setMealmenuSL(String mealmenuSL) {
		this.mealmenuSL = mealmenuSL;
	}
	public String getReviewType() {
		return reviewType;
	}
	public void setReviewType(String reviewType) {
		this.reviewType = reviewType;
	}
	public String getMethodFlag() {
		return methodFlag;
	}
	public void setMethodFlag(String methodFlag) {
		this.methodFlag = methodFlag;
	}
	public String getItemQty() {
		return itemQty;
	}
	public void setItemQty(String itemQty) {
		this.itemQty = itemQty;
	}
	//Added Against KDAH-CRF-0352 Starts Here
	public String getServingUomDesc() {
		return servingUomDesc;
	}
	public void setServingUomDesc(String servingUomDesc) {
		this.servingUomDesc = servingUomDesc;
	}
	
	public String getEnergyUomDesc() {
		return energyUomDesc;
	}
	public void setEnergyUomDesc(String energyUomDesc) {
		this.energyUomDesc = energyUomDesc;
	}
   //Added Against KDAH-CRF-0352 Ends Here

   //Added Against KDAH-CRF-0352 US4 Starts Here
   public String getNutrientDesc() {
		return nutrientDesc;
	}
	public void setNutrientDesc(String nutrientDesc) {
		this.nutrientDesc = nutrientDesc; 
	}
	
	public String getServingUomQty() {
		return servingUomQty;
	}
	public void setServingUomQty(String servingUomQty) {
		this.servingUomQty = servingUomQty;
	}
   //Added Against KDAH-CRF-0352 US4 Ends Here
	
	//Added against AMS-CRF-0112 Starts Here
	public String getAdditionalInstructions2(String mealType) {
	String temp=additionalInstructions2.get(mealType);
	return temp;
	}
	public void setAdditionalInstructions2(String mealType, String additionalInstructions) {
		additionalInstructions2.put(mealType,additionalInstructions);
	}
	public String getAdditionalInstrDate()
	{	
		return additionalInstrDate;
	}
	public void setAdditionalInstrDate(String additionalInstrDate)
	{
		this.additionalInstrDate=additionalInstrDate;	
	}
	//Added against AMS-CRF-0112 Ends Here 
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getMealList() {
		return mealList;
	}
	public void setMealList(String mealList) {
		this.mealList = mealList;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}
	public String getKitchenCode() {
		return kitchenCode;
	}
	public void setKitchenCode(String kitchenCode) {
		this.kitchenCode = kitchenCode;
	}
	public String getDayRef() {
		return dayRef;
	}
	public void setDayRef(String dayRef) {
		this.dayRef = dayRef;
	}

	public String getItemSL() {
		return itemSL;
	}
	public void setItemSL(String itemSL) {
		this.itemSL = itemSL;
	}
	public String getItemShortDesc() {
		return itemShortDesc;
	}
	public void setItemShortDesc(String itemShortDesc) {
		this.itemShortDesc = itemShortDesc;
	}
	public String getMealTypeShortDesc() {
		return mealTypeShortDesc;
	}
	public void setMealTypeShortDesc(String mealTypeShortDesc) {
		this.mealTypeShortDesc = mealTypeShortDesc;
	}
	public String getServingUomCode() {
		return servingUomCode;
	}
	public void setServingUomCode(String servingUomCode) {
		this.servingUomCode = servingUomCode;
	}
	public String getCalorificContPerUom() {
		return calorificContPerUom;
	}
	public void setCalorificContPerUom(String calorificContPerUom) {
		this.calorificContPerUom = calorificContPerUom;
	}
	public String getEnergyUom() {
		return energyUom;
	}
	public void setEnergyUom(String energyUom) {
		this.energyUom = energyUom;
	}
	public String getReviewSLNo() {
		return reviewSLNo;
	}
	public void setReviewSLNo(String reviewSLNo) {
		this.reviewSLNo = reviewSLNo;
	}

	//Method Calls
	public LinkedHashMap getAllMenuItems(UpdateMealMenuObject mealMenuObject)
	{
		Connection conn = null;
		PreparedStatement menuItemsPstmt = null, reviewedMenuItemsPstmt = null;
		ResultSet menuItemsRs = null, reviewedMenuItemsRs = null;
		StringBuffer menuItemsSql = new StringBuffer();
		StringBuffer reviewedMenuItemsSql = new StringBuffer();
		UpdateMealMenuObject updateMealMenuObject = null;
		LinkedHashMap allMenuItemsMap = null;
		ArrayList menuItemsList = null;
		ArrayList reviewedMenuItemsList = null;
		String dateForMenu = "";
		int index = 0;
		try
		{
			//conn = getConnection();
			conn = ConnectionManager.getConnection();//67181
			if(conn == null)
				return allMenuItemsMap;
			allMenuItemsMap = new LinkedHashMap();
			menuItemsList = new ArrayList();
			reviewedMenuItemsList = new ArrayList();
			//67181
			boolean isMealMenuDisplay =false;        
			isMealMenuDisplay = CommonBean.isSiteSpecific(conn,"DS","DS_MEAL_MENU_ITEMS");
			//67181			
			
			//Modified  Against KDAH-CRF-0352 US4 Starts Here
			//67181
			//menuItemsSql.append("	select item_sl, item_type, item_code,itemshortdesc, item_qty, meal_type,mealtypeshortdesc,serving_uom_code,cal_cnt,eng_uom,item_serving_uom_desc,energy_uom_desc,meal_order, ");			
			
			//if(isMealMenuDisplay){
			//menuItemsSql.append(" WM_CONCAT(nutrient_code) nutrient_code,WM_CONCAT(nutrient_desc) nutrient_desc, WM_CONCAT(serving_uom_desc) serving_uom_desc from(		");
			//}else{
			//menuItemsSql.append(" null nutrient_code, null nutrient_desc, null serving_uom_desc from(		");
			//}
			//67181

			menuItemsSql.append(" SELECT   menuitem.item_sl, menuitem.item_type, menuitem.item_code,		"); //3
			menuItemsSql.append(" items.short_desc AS itemshortdesc, menuitem.item_qty, menu.meal_type,		"); //6
			menuItemsSql.append(" mealtype.short_desc AS mealtypeshortdesc, items.serving_uom_code,		"); //8
			menuItemsSql.append(" TO_CHAR (items.calorific_cont_per_uom, '999999.99') cal_cnt,		"); //9
			//Modified Against KDAH-CRF-0352
			menuItemsSql.append(" LOWER (dsparam.energy_uom) eng_uom, am_get_desc.am_uom (items.serving_uom_code, ?, '2') item_serving_uom_desc,am_get_desc.am_uom (dsparam.energy_uom, ?, '2') energy_uom_desc, meal_order,  "); //13
			
			//menuItemsSql.append(" fd_nut.nutrient_code nutrient_code,ds_get_desc.ds_nutrients (fd_nut.nutrient_code, ?, '2')nutrient_desc,menuitem.item_qty * fd_nut.content_value || ' ' || am_get_desc.am_uom (nut1.UOM_CODE, ?, '2')serving_uom_desc ");
			menuItemsSql.append(" ds_nutrient_val(menuitem.item_qty, menuitem.item_code, ?) ds_nut_val "); //14
			menuItemsSql.append(" FROM ds_menu_item menuitem, ");//Modified Against ICN-#65555 0352 
			menuItemsSql.append("	ds_menu menu, ds_items items, ds_diet_menu_time_table menutimetable, "); 
			menuItemsSql.append(" ds_param dsparam, ds_meal_type mealtype ");
			//menuItemsSql.append(" ds_food_item_nutrients fd_nut, ds_nutrients nut1 ");
			menuItemsSql.append("	WHERE menutimetable.meal_type = mealtype.meal_type		");
			menuItemsSql.append("	AND (    (menuitem.menu_code = ?)		");
			menuItemsSql.append("	AND (menuitem.menu_code = menu.menu_code)		");
			menuItemsSql.append("	AND (menuitem.item_code = items.food_item_code)		");
			menuItemsSql.append("	AND (items.language_id LIKE ?)		");
			menuItemsSql.append("	AND (items.EFF_STATUS = 'E')	");//Added against AMS-SCF-0797 NMuthu@12-Jul-19
			menuItemsSql.append("	AND (menutimetable.menu_code = menu.menu_code) ");
			//menuItemsSql.append(" AND (menuitem.item_code = fd_nut.food_item_code(+)) ");
			//menuItemsSql.append(" AND (fd_nut.NUTRIENT_CODE = nut1.NUTRIENTS_CODE(+)) ");
			menuItemsSql.append("	AND (menutimetable.operating_facility_id = ?)		");
			menuItemsSql.append("	AND (menutimetable.kitchen_code = ?)		");
			menuItemsSql.append("	AND (menutimetable.diet_type = ?)		");
			menuItemsSql.append("	AND (menutimetable.meal_class = ?)		");
			menuItemsSql.append("	AND (menutimetable.day_no = ?)		");
			menuItemsSql.append("	AND (menutimetable.meal_type = ?)		");
			menuItemsSql.append("	AND (menuitem.item_code NOT IN (		");
			menuItemsSql.append("	SELECT dtlreviewed.item_code		");
			menuItemsSql.append("	FROM ds_epsd_diet_prof_dtl_reviewed dtlreviewed		");
			menuItemsSql.append("	WHERE (dtlreviewed.operating_facility_id = ?)		");
			menuItemsSql.append("	AND (dtlreviewed.encounter_id = ?)		");
			menuItemsSql.append("	AND (dtlreviewed.profile_sl = ?)		");
			menuItemsSql.append("	AND (dtlreviewed.meal_type = ?)		");
			menuItemsSql.append("	AND (   (    (dtlreviewed.serving_date IS NULL)		");
			menuItemsSql.append("	AND (dtlreviewed.cycle_day_ref = ?))		");
			menuItemsSql.append("	OR (TO_CHAR (dtlreviewed.serving_date, 'dd/mm/yyyy') = ?)))))		");
			//menuItemsSql.append("	) GROUP BY item_sl, item_type, item_code,itemshortdesc, item_qty, meal_type,mealtypeshortdesc, serving_uom_code,cal_cnt,eng_uom,item_serving_uom_desc,energy_uom_desc,meal_order     ");			
			menuItemsSql.append("	ORDER BY meal_order		");
			//Modified  Against KDAH-CRF-0352 US4 Ends Here
			menuItemsPstmt=conn.prepareStatement(menuItemsSql.toString().trim());
			System.err.println("413,menuItemsSql==="+menuItemsSql.toString().trim());
			//Added Against KDAH-CRF-0352 starts Here
			menuItemsPstmt.setString(++index, mealMenuObject.getLocale());
			menuItemsPstmt.setString(++index, mealMenuObject.getLocale());
			//Added Against KDAH-CRF-0352 Ends Here
			//Added Against KDAH-CRF-0352 US4 starts Here
			menuItemsPstmt.setString(++index, mealMenuObject.getLocale());
			//menuItemsPstmt.setString(++index, mealMenuObject.getLocale());
			//Added Against KDAH-CRF-0352 US4 Ends Here
			menuItemsPstmt.setString(++index, mealMenuObject.getMealList());
			menuItemsPstmt.setString(++index, mealMenuObject.getLocale());
			menuItemsPstmt.setString(++index, mealMenuObject.getFacilityId());
			menuItemsPstmt.setString(++index, mealMenuObject.getKitchenCode());
			menuItemsPstmt.setString(++index, mealMenuObject.getDietType());
			menuItemsPstmt.setString(++index, mealMenuObject.getMealClass());
			menuItemsPstmt.setString(++index, mealMenuObject.getDayRef());
			menuItemsPstmt.setString(++index, mealMenuObject.getMealType());
			menuItemsPstmt.setString(++index, mealMenuObject.getFacilityId());
			menuItemsPstmt.setString(++index, mealMenuObject.getEncounterId());
			menuItemsPstmt.setString(++index, mealMenuObject.getProfileSL());
			menuItemsPstmt.setString(++index, mealMenuObject.getMealType());
			menuItemsPstmt.setString(++index, mealMenuObject.getDayRef());
			menuItemsPstmt.setString(++index, mealMenuObject.getDateforMenu());
			
			
			menuItemsRs = menuItemsPstmt.executeQuery();
			while(menuItemsRs != null && menuItemsRs.next())
			{
				updateMealMenuObject = new UpdateMealMenuObject();
				updateMealMenuObject.setItemSL(menuItemsRs.getString("ITEM_SL"));
				updateMealMenuObject.setItemType(menuItemsRs.getString("ITEM_TYPE"));
				updateMealMenuObject.setItemCode(menuItemsRs.getString("ITEM_CODE"));
				updateMealMenuObject.setItemShortDesc(menuItemsRs.getString("ITEMSHORTDESC"));
				updateMealMenuObject.setItemQty(menuItemsRs.getString("ITEM_QTY"));
				updateMealMenuObject.setMealType(menuItemsRs.getString("MEAL_TYPE"));
				updateMealMenuObject.setMealTypeShortDesc(menuItemsRs.getString("MEALTYPESHORTDESC"));
				updateMealMenuObject.setServingUomCode(menuItemsRs.getString("SERVING_UOM_CODE"));
				updateMealMenuObject.setCalorificContPerUom(menuItemsRs.getString(9));
				updateMealMenuObject.setEnergyUom(menuItemsRs.getString(10));
				//Added Against KDAH-CRF-0352 starts Here
				updateMealMenuObject.setServingUomDesc(menuItemsRs.getString(11));
				updateMealMenuObject.setEnergyUomDesc(menuItemsRs.getString(12));
				//Added Against KDAH-CRF-0352 Ends Here
				//Added Against KDAH-CRF-0352 US4 starts Here
				/* Added Against Start IN:067604 by SelvinM */
				updateMealMenuObject.setdsNutriValue(menuItemsRs.getString(14)); 
				//updateMealMenuObject.setNutrientDesc(menuItemsRs.getString(15));
				//updateMealMenuObject.setServingUomQty(menuItemsRs.getString(16));			
				/* Added Against End IN:067604 by SelvinM */
				//Added Against KDAH-CRF-0352 US4 Ends Here
				menuItemsList.add(updateMealMenuObject);
			}
			allMenuItemsMap.put("MENUITEMS", menuItemsList);

			index = 0;			
			
			//Modified Against ICN-#65555 0352 & 67181
			//reviewedMenuItemsSql.append("	select item_sl, item_type, item_code,itemshortdesc, item_qty,review_type , meal_type,         mealtypeshortdesc, diet_type,serving_uom_code,review_slno,cal_cnt,eng_uom,item_serving_uom_desc,energy_uom_desc,meal_order,  ");						
			//if(isMealMenuDisplay){
			//reviewedMenuItemsSql.append(" WM_CONCAT(nutrient_code) nutrient_code,WM_CONCAT(nutrient_desc) nutrient_desc,WM_CONCAT(serving_uom_desc) serving_uom_desc from(		");
			//}else{
			//reviewedMenuItemsSql.append(" null nutrient_code, null nutrient_desc, null serving_uom_desc from(		");
			//}
			//67181
			reviewedMenuItemsSql.append(" SELECT   dtlreviewed.item_sl, dtlreviewed.item_type, dtlreviewed.item_code,	");
			reviewedMenuItemsSql.append(" items.short_desc AS itemshortdesc, dtlreviewed.item_qty, ");
			reviewedMenuItemsSql.append(" dtlreviewed.review_type, dtlreviewed.meal_type,	");
			reviewedMenuItemsSql.append(" mealtype.short_desc AS mealtypeshortdesc, dtlreviewed.diet_type,		");
			reviewedMenuItemsSql.append(" items.serving_uom_code, dtlreviewed.review_slno, ");
			reviewedMenuItemsSql.append(" TO_CHAR (items.calorific_cont_per_uom, '999999.99') cal_cnt, ");
			//Modified Against KDAH-CRF-0352
			reviewedMenuItemsSql.append(" LOWER (param.energy_uom) eng_uom,am_get_desc.am_uom (items.serving_uom_code, ?, '2') item_serving_uom_desc,am_get_desc.am_uom (param.energy_uom, ?, '2') energy_uom_desc,meal_order, ");
			reviewedMenuItemsSql.append(" ds_nutrient_val(dtlreviewed.item_qty,dtlreviewed.item_code,?)ds_nut_val ");
			//reviewedMenuItemsSql.append(" fd_nut.nutrient_code nutrient_code,ds_get_desc.ds_nutrients (fd_nut.nutrient_code, ?, '2')nutrient_desc,dtlreviewed.item_qty * fd_nut.content_value || ' ' || am_get_desc.am_uom (nut1.UOM_CODE, ?, '2') serving_uom_desc ");
			reviewedMenuItemsSql.append(" FROM ds_epsd_diet_prof_dtl_reviewed dtlreviewed, ");//Modified Against ICN-#65555 0352
			reviewedMenuItemsSql.append("	ds_meal_type mealtype, ds_items items, ds_param param ");
			//reviewedMenuItemsSql.append("	ds_food_item_nutrients fd_nut,ds_nutrients nut1	");
			reviewedMenuItemsSql.append(" WHERE (dtlreviewed.operating_facility_id = ?) ");
			reviewedMenuItemsSql.append(" AND (dtlreviewed.encounter_id = ?) ");
			reviewedMenuItemsSql.append(" AND (dtlreviewed.profile_sl = ?) ");
			reviewedMenuItemsSql.append(" AND (dtlreviewed.meal_type = mealtype.meal_type)		");
			reviewedMenuItemsSql.append(" AND (dtlreviewed.item_code = items.food_item_code) ");
			//reviewedMenuItemsSql.append(" AND (dtlreviewed.item_code = fd_nut.food_item_code(+)) AND (fd_nut.NUTRIENT_CODE = nut1.NUTRIENTS_CODE(+))	");
			reviewedMenuItemsSql.append(" AND (items.language_id LIKE ?)		");
			reviewedMenuItemsSql.append(" AND (((dtlreviewed.serving_date IS NOT NULL)		");
			reviewedMenuItemsSql.append(" AND (TO_CHAR (dtlreviewed.serving_date, 'dd/mm/yyyy') = ?)) ");
			reviewedMenuItemsSql.append(" OR(((dtlreviewed.serving_date IS NULL) ");
			reviewedMenuItemsSql.append(" AND (dtlreviewed.cycle_day_ref = ?)))) ");
			//reviewedMenuItemsSql.append(" ) GROUP BY item_sl, item_type, item_code, itemshortdesc, item_qty, review_type, meal_type,mealtypeshortdesc, diet_type,serving_uom_code,review_slno,cal_cnt,eng_uom,item_serving_uom_desc,    energy_uom_desc,meal_order ");
			reviewedMenuItemsSql.append(" ORDER BY meal_order ");
			reviewedMenuItemsPstmt=conn.prepareStatement(reviewedMenuItemsSql.toString().trim());//Added Against 11g Issue			
			System.err.println("495,reviewedMenuItemsSql====="+reviewedMenuItemsSql.toString());
			//Added Against KDAH-CRF-0352 US4 starts Here
			reviewedMenuItemsPstmt.setString(++index, mealMenuObject.getLocale());
			reviewedMenuItemsPstmt.setString(++index, mealMenuObject.getLocale());
			//Added Against KDAH-CRF-0352 US4 Ends Here
			//Added Against KDAH-CRF-0352 starts Here
			reviewedMenuItemsPstmt.setString(++index, mealMenuObject.getLocale());
			//reviewedMenuItemsPstmt.setString(++index, mealMenuObject.getLocale());
			//Added Against KDAH-CRF-0352 Ends Here
			reviewedMenuItemsPstmt.setString(++index, mealMenuObject.getFacilityId());
			reviewedMenuItemsPstmt.setString(++index, mealMenuObject.getEncounterId());
			reviewedMenuItemsPstmt.setString(++index, mealMenuObject.getProfileSL());
			reviewedMenuItemsPstmt.setString(++index, mealMenuObject.getLocale());
			dateForMenu = com.ehis.util.DateUtils.convertDate(mealMenuObject.getDateforMenu(), "DMY", mealMenuObject.getLocale(), "en");		
			reviewedMenuItemsPstmt.setString(++index, dateForMenu);
			reviewedMenuItemsPstmt.setString(++index, mealMenuObject.getDayRef());			
			reviewedMenuItemsRs = reviewedMenuItemsPstmt.executeQuery();
			while(reviewedMenuItemsRs != null && reviewedMenuItemsRs.next())
			{
				updateMealMenuObject = new UpdateMealMenuObject();
				updateMealMenuObject.setItemType(reviewedMenuItemsRs.getString(2));
				updateMealMenuObject.setItemCode(reviewedMenuItemsRs.getString(3));
				updateMealMenuObject.setItemShortDesc(reviewedMenuItemsRs.getString(4));
				updateMealMenuObject.setItemQty(reviewedMenuItemsRs.getString(5));
				updateMealMenuObject.setReviewType(reviewedMenuItemsRs.getString(6));
				updateMealMenuObject.setMealType(reviewedMenuItemsRs.getString(7));
				updateMealMenuObject.setMealTypeShortDesc(reviewedMenuItemsRs.getString(8));
				updateMealMenuObject.setServingUomCode(reviewedMenuItemsRs.getString(10));
				updateMealMenuObject.setReviewSLNo(reviewedMenuItemsRs.getString(11));
				updateMealMenuObject.setCalorificContPerUom(reviewedMenuItemsRs.getString(12));
				updateMealMenuObject.setEnergyUom(reviewedMenuItemsRs.getString(13));
				//Added Against KDAH-CRF-0352 starts Here
				updateMealMenuObject.setServingUomDesc(reviewedMenuItemsRs.getString(14));
				updateMealMenuObject.setEnergyUomDesc(reviewedMenuItemsRs.getString(15));
				//Added Against KDAH-CRF-0352 Ends Here				
				//Added Against KDAH-CRF-0352 US4 starts Here
				updateMealMenuObject.setdsNutriValue(reviewedMenuItemsRs.getString(17));
				//updateMealMenuObject.setNutrientDesc(reviewedMenuItemsRs.getString(18));
				//updateMealMenuObject.setServingUomQty(reviewedMenuItemsRs.getString(19));
				updateMealMenuObject.getAllValue(); //Added Against KDAH-CRF-0349.1 [IN062717]US2
				//Added Against KDAH-CRF-0352 US4 Ends Here
			
				reviewedMenuItemsList.add(updateMealMenuObject);
			}
			allMenuItemsMap.put("REVIEWEDMENUITEMS", reviewedMenuItemsList);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				//conn.close();
				if(conn!=null) ConnectionManager.returnConnection(conn); //Common-ICN-0052
				menuItemsPstmt.close();
				reviewedMenuItemsPstmt.close();
				menuItemsRs.close();
				reviewedMenuItemsRs.close();
				menuItemsSql = null;
				reviewedMenuItemsSql = null;
				updateMealMenuObject = null;
				menuItemsList = null;
				reviewedMenuItemsList = null;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return allMenuItemsMap;
	}
}
