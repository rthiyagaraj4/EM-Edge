/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eDS.resources;

import java.util.*;

public class Labels_bm extends ListResourceBundle{

	static final Object[][] CONTENTS = {
		{"eDS.DietType.Label","bm_Diet Type"},
		{"eDS.LongDescription.Label","bm_Long Description"},
		{"eDS.ShortDescription.Label","bm_Short Description"},
		{"eDS.AgeGroup.Label","bm_Age Group"},
		{"eDS.DefaultDietType.Label","bm_Default Diet Type"},
		{"eDS.DefaultFeedType.Label","bm_Default Feed Type"},
		{"eDS.DietCycleType.Label","bm_Diet Cycle Type"},
		{"eDS.OrderCatalogcode.Label","bm_Order Catalog code"},
		{"eDS.DietCategory.Label","bm_Diet Category"},
		{"eDS.Enabled.Label","bm_Enabled"},
		{"eDS.select.Label","bm_-----select-----"},
		{"eDS.MealClass.Label","bm_Meal Class"},
		{"eDS.MealType.Label","bm_Meal Type"},
		{"eDS.ItemType.Label","bm_Item Type"},
		{"eDS.ItemQty.Label","bm_Item Qty"},
		{"eDS.Item.Label","bm_Item"},
		{"eDS.ItemSrl.Label","bm_Item Srl"},
		{"eDS.ItemsForMenu.Label","bm_Items For Menu"},
		{"eDS.Order.Label","bm_Order"},
		{"eDS.CommercialFormula.Label","bm_Commercial Formula"},
		{"eDS.ApplDietCategory.Label","bm_Applicable Diet Category"},
		{"eDS.FeedType.Label","bm_Feed Type"},
		{"eDS.InstructionCode.Label","bm_Instruction Code"},
		{"eDS.Description.Label","bm_Description"},
		{"eDS.ComplaintCode.Label","bm_Complaint Code"},
		{"eDS.DietCategoryCode.Label","bm_Diet Category Code"},
		{"eDS.OrderType.Label","bm_Order Type"},
		{"eDS.Attendents.Label","bm_Attendents"},
		{"eDS.MealCategory.Label","bm_Meal Category"},
		{"eDS.NursingUnit.Label","bm_Nursing Unit"},
		{"eDS.PatientOrder.Label","bm_Patient Order"},
		{"eDS.NoOfAttendent.Label","bm_No of Attendent"},
		{"eDS.NutrientCode.Label","bm_Nutrient Code"},
		{"eDS.Uom.Label","bm_UOM"},
		{"eDS.EnergyConversion.Label","bm_Energy Conversion"},
		{"eDS.KiloCalories.Label","bm_Kilo Calories"},
		{"eDS.IngredientCode.Label","bm_Ingredient Code"},
		{"eDS.Ingredients.Label","bm_Ingredients"},
		{"eDS.ItemCode.Label","bm_Item Code"},
		{"eDS.StockUOM.Label","bm_Stock UOM"},
		{"eDS.FoodItemCode.Label","bm_Food Item Code"},
		{"eDS.ServingUOM.Label","bm_Serving UOM"},
		{"eDS.PreparationFactor.Label","bm_Preparation Factor"},
		{"eDS.CalorieContentUOM.Label","bm_Calorie Content / UOM"},
		{"eDS.PreparationUOM.Label","bm_Preparation UOM"},
		{"eDS.PrepUOM.Label","bm_Prep UOM"},
		{"eDS.PreparationBaseQty.Label","bm_Preparation Base Qty"},
		{"eDS.PreparatoryFactor.Label","bm_Preparatory Factor"},
		{"eDS.BaseQty.Label","bm_Base Qty"},
		{"eDS.Qty.Label","bm_Qty"},
		{"eDS.CommercialFormula.Label","bm_Commercial Formula"},
		{"eDS.CrossReferenceItem.Label","bm_Cross Reference Item"},
		{"eDS.Kitchen.Label","bm_Kitchen"},
		{"eDS.KitchenArea.Label","bm_Kitchen Area"},
		{"eDS.KitchenCode.Label","bm_Kitchen Code"},
		{"eDS.KitchenAreaCode.Label","bm_Kitchen Area Code"},
		{"eDS.Nutrient.Label","bm_Nutrient"},
		{"eDS.ContentValue.Label","bm_Content Value"},
		{"eDS.FoodItem.Label","bm_Food Item"},
		{"eDS.UOMCode.Label","bm_UOM Code"},
		{"eDS.NutrientsCommercialFormula.Label","bm_Nutrients for Commercial Formula"},
		{"eDS.NutrientsFoodItem.Label","bm_Nutrients for Food Item"},
		{"eDS.DayNo.Label","bm_Day No"},
		{"eDS.Menu.Label","bm_thMenu"},
		{"eDS.MenuSchedCycle.Label","bm_Menu Schedule Cycle"},
		{"eDS.MealPlanDate.Label","bm_Meal Plan Date"},
		{"eDS.RefDayNo.Label","bm_Reference Day No"},
		{"eDS.WardCode.Label","bm_Ward Code"},
		{"eDS.EffectiveFromDate.Label","bm_Effective From Date"},
		{"eDS.EffectiveToDate.Label","bm_Effective To Date"},
		//CRF-230 changes
		{"eDS.FoodDislike.Label","bm_Food Dislike"},
		{"eDS.SpecialFoodItem.Label","bm_Special Food Item"},
		{"eDS.Remarks.Label","bm_Remarks"},
		{"eDS.alternateFacility.Label","bm_Alternate facility"}, 
		{"eDS.placeOrder.Label","bm_Place Order"},
		{"eDS.SelectedPatients.label", "bm_Selected Patients"},
		{"eDS.accept.Label","bm_Accept"}, 
		{"eDS.reject.Label","bm_Reject"},
		{"eDS.served.Label", "bm_Served"},
		{"eDS.MultiFacilityOP.Label","bm_Enable Multi Facility Meal Order for Outpatients"},
		{"eDS.PlaceOPMealOrder.Label","bm_Place Outpatient Meal Order"},
		{"eDS.VisitDateTime.label","bm_Visit Date/Time"},
		{"eDS.groupOrder.Label","bm_Group Order"},
		{"eDS.calorieGrandTotal.Label","bm_Calorie Grand Total"},
		{"eDS.Total.Label","bm_Total"},
		{"eDS.mealTotalCalorie.Label","bm_Meal Total Calorie"},
		{"eDS.removeAttendent.Label","bm_REMOVE ATTENDENT"},
		{"eDS.mealTypes.Label","bm_MealTypes..."},
		{"eDS.record.Label","bm_Record"},
		{"eDS.entireList.Label","bm_Entire List"},
		{"eDS.specificList.Label","bm_Specific List"},
		{"eDS.listNo.Label","bm_List No"},
		// Changes For CRF-412
		{"eDS.PlaceEMMealOrder.Label","bm_Place Emergency Patient Meal Order"},
		{"eDS.EMMealOrder.Label","bm_Emergency Patient Meal Order"},
		{"eDS.MealOrderFor.Label","bm_Meal Order For"},
		{"eDS.EmergencyPatients.Label","bm_Emergency Patients"}
		
	};

	@Override
	//protected Object[][] getContents() {
	public Object[][] getContents() {
		// TODO Auto-generated method stub
		return CONTENTS;
	}

}
