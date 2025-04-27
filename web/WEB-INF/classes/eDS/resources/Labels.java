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

public class Labels extends ListResourceBundle{

	static final Object[][] CONTENTS = {
		{"eDS.DietType.Label","Diet Type"},
		{"eDS.LongDescription.Label","Long Description"},
		{"eDS.ShortDescription.Label","Short Description"},
		{"eDS.AgeGroup.Label","Age Group"},
		{"eDS.DefaultDietType.Label","Default Diet Type"},
		{"eDS.DefaultFeedType.Label","Default Feed Type"},
		{"eDS.DietCycleType.Label","Diet Cycle Type"},
		{"eDS.OrderCatalogcode.Label","Order Catalog code"},
		{"eDS.DietCategory.Label","Diet Category"},
		{"eDS.Enabled.Label","Enabled"},
		{"eDS.select.Label","-----select-----"},
		{"eDS.MealClass.Label","Meal Class"},
		{"eDS.MealType.Label","Meal Type"},
		{"eDS.ItemType.Label","Item Type"},
		{"eDS.ItemQty.Label","Item Qty"},
		{"eDS.Item.Label","Item"},
		{"eDS.ItemSrl.Label","Item Srl"},
		{"eDS.ItemsForMenu.Label","Items For Menu"},
		{"eDS.Order.Label","Order"},
		{"eDS.CommercialFormula.Label","Commercial Formula"},
		{"eDS.ApplDietCategory.Label","Applicable Diet Category"},
		{"eDS.FeedType.Label","Feed Type"},
		{"eDS.InstructionCode.Label","Instruction Code"},
		{"eDS.Description.Label","Description"},
		{"eDS.ComplaintCode.Label","Complaint Code"},
		{"eDS.DietCategoryCode.Label","Diet Category Code"},
		{"eDS.OrderType.Label","Order Type"},
		{"eDS.Attendents.Label","Attendents"},
		{"eDS.MealCategory.Label","Meal Category"},
		{"eDS.NursingUnit.Label","Nursing Unit"},
		{"eDS.PatientOrder.Label","Patient Order"},
		{"eDS.NoOfAttendent.Label","No of Attendent"},
		{"eDS.NutrientCode.Label","Nutrient Code"},
		{"eDS.Uom.Label","UOM"},
		{"eDS.EnergyConversion.Label","Energy Conversion"},
		{"eDS.KiloCalories.Label","Kilo Calories"},
		{"eDS.IngredientCode.Label","Ingredient Code"},
		{"eDS.Ingredients.Label","Ingredients"},
		{"eDS.ItemCode.Label","Item Code"},
		{"eDS.StockUOM.Label","Stock UOM"},
		{"eDS.FoodItemCode.Label","Food Item Code"},
		{"eDS.ServingUOM.Label","Serving UOM"},
		{"eDS.PreparationFactor.Label","Preparation Factor"},
		{"eDS.CalorieContentUOM.Label","Calorie Content / UOM"},
		{"eDS.PreparationUOM.Label","Preparation UOM"},
		{"eDS.PrepUOM.Label","Prep UOM"},
		{"eDS.PreparationBaseQty.Label","Preparation Base Qty"},
		{"eDS.PreparatoryFactor.Label","Preparatory Factor"},
		{"eDS.BaseQty.Label","Base Qty"},
		{"eDS.Qty.Label","Qty"},
		{"eDS.CommercialFormula.Label","Commercial Formula"},
		{"eDS.CrossReferenceItem.Label","Cross Reference Item"},
		{"eDS.Kitchen.Label","Kitchen"},
		{"eDS.KitchenArea.Label","Kitchen Area"},
		{"eDS.KitchenCode.Label","Kitchen Code"},
		{"eDS.KitchenAreaCode.Label","Kitchen Area Code"},
		{"eDS.Nutrient.Label","Nutrient"},
		{"eDS.ContentValue.Label","Content Value"},
		{"eDS.FoodItem.Label","Food Item"},
		{"eDS.UOMCode.Label","UOM Code"},
		{"eDS.NutrientsCommercialFormula.Label","Nutrients for Commercial Formula"},
		{"eDS.NutrientsFoodItem.Label","Nutrients for Food Item"},
		{"eDS.DayNo.Label","Day No"},
		{"eDS.Menu.Label","Menu"},
		{"eDS.MenuSchedCycle.Label","Menu Schedule Cycle"},
		{"eDS.MealPlanDate.Label","Meal Plan Date"},
		{"eDS.RefDayNo.Label","Reference Day No"},
		{"eDS.WardCode.Label","Ward Code"},
		{"eDS.EffectiveFromDate.Label","Effective From Date"},
		{"eDS.EffectiveToDate.Label","Effective To Date"},
		//CRF-230 changes
		{"eDS.FoodDislike.Label","Food Dislike"},
		{"eDS.SpecialFoodItem.Label","Special Food Item"},
		{"eDS.Remarks.Label","Remarks"},		
		{"eDS.alternateFacility.Label","Alternate facility"}, 
		{"eDS.placeOrder.Label","Place Order"},
		{"eDS.SelectedPatients.label", "Selected Patients"},
		{"eDS.accept.Label","Accept"}, 
		{"eDS.reject.Label","Reject"},
		{"eDS.served.Label", "Served"},
		{"eDS.MultiFacilityOP.Label","Enable Multi Facility Meal Order for Outpatients"},
		{"eDS.PlaceOPMealOrder.Label","Place Outpatient Meal Order"},
		{"eDS.VisitDateTime.label","Visit Date/Time"},
		{"eDS.groupOrder.Label","Group Order"},
		{"eDS.calorieGrandTotal.Label","Calorie Grand Total"},
		{"eDS.Total.Label","Total"},
		{"eDS.mealTotalCalorie.Label","Meal Total Calorie"},
		{"eDS.removeAttendent.Label","REMOVE ATTENDENT"},
		{"eDS.removeAttendentPCT.Label","REMOVE #"},
		{"eDS.mealTypes.Label","MealTypes..."},
		{"eDS.record.Label","Record"},
		{"eDS.entireList.Label","Entire List"},
		{"eDS.specificList.Label","Specific List"},
		{"eDS.listNo.Label","List No"},
		// Changes For CRF-412
		{"eDS.PlaceEMMealOrder.Label","Place Emergency Patient Meal Order"},
		{"eDS.EMMealOrder.Label","Emergency Patient Meal Order"},
		{"eDS.MealOrderFor.Label","Meal Order For"},
		{"eDS.EmergencyPatients.Label","Emergency Patients"},
		//ML-MMOH-CRF-0427 Starts
		{"eDS.RestrictDateRangeforInpatients.Label","Restrict Diet Order Date Range for Inpatients"},
		{"eDS.MaximumDaysAllowed.Label","Maximum Diet Order Date Range Allowed For Inpatients (Including Current Day)"},
		//ML-MMOH-CRF-0427 Ends
		{"eDS.GenerateMealPlanforpatientswithNilByMouth.Label","Generate Meal Plan for patients with Nil By Mouth"},
		//ML-MMOH-CRF-409 Starts		
		{"eDS.ServingTime.Label","Serving Time"},
		{"eDS.ServingStartTime.Label","Serving Start Time"},
		{"eDS.LateIrregularDietOrderTime.Label","Late/Irregular Diet Order Time"},
		{"eDS.ServingEndTime.Label","Serving End Time"},
		{"eDS.LateIrregularDietOrderStartTime.Label","Late/Irregular Diet Order Start Time"},
		{"eDS.LateIrregularDietOrderEndTime.Label","Late/Irregular Diet Order End Time"},
		{"eDS.LateIrregularDietOrdersApplicableforInpatients.Label","Late/Irregular Diet Orders Applicable for Inpatients"},
		{"eDS.NotificationMessageforPlaceDietOrder.Label","Notification Message for Place Diet Order"},
		{"eDS.RestrictPlacingDietOrderafterMealServingStartTime.Label","Restrict Placing Diet Order after Meal Serving Start Time"},
		{"eDS.SearchFor.Label","Search For"},
		{"eDS.RegularLateIrregularDietOrders.Label","Regular and Late/Irregular Diet Orders"},
		{"eDS.RegularDietOrders.Label","Regular Diet Orders"},
		{"eDS.LateIrregularDietOrders.Label","Late/Irregular Diet Orders"},	
        {"eDS.DietTypeModified.Label","Diet Type Modified"},//006
		{"eDS.ReferredToDietician.Label","Refer to Dietician"},//006
		//ML-MMOH-CRF-409 ends
		{"eDS.mealExclusions.Label","Meal Exclusions"},
		{"eDS.CurrentDietTypeModified.Label","Diet Type Modified for Current Order"},
		{"eDS.FutureDietTypeModified.Label","Diet Type Modified for Future Order(s)"},
		{"eDS.PatientCareTakerLabel.Label","Patient Care Taker (PCT) Label"},//ML-MMOH-CRF-0406
		{"eDS.OrdersAppl.Label"," Orders Applicable"},//ML-MMOH-CRF-0406
		{"eDS.MaxAttendant.Label","Maximum # Orders Allowed (For Each Day)"},//ML-MMOH-CRF-412
		{"eDS.TextureOfDiet.Label","Texture of Diet"},//ML-MMOH-CRF-412
		{"eDS.GenerateReportfor.Label","Generate Report for"},//ML-MMOH-CRF-413
		{"eDS.SpecialFoodItems.Label","Special Food Items"},//ML-MMOH-CRF-413
		{"eDS.PCTAttendantInstr.Label","# Instruction"},//ML-MMOH-CRF-406
		//MMS-QH-CRF-0079
		{"eDS.PlaceSupplementaryDietOrder.Label","Place Supplementary Diet Order"},
		{"eDS.SupplementaryDietOrder.Label","Supplementary Diet Order"},
		{"eDS.SupplementaryDietFor.Label","Supplementary Diet For"},
		{"eDS.ProcessedbyKitchen.Label","Processed by Kitchen"},
		{"eDS.RejectedbyKitchen.Label","Rejected by Kitchen"},
		{"eDS.AcceptedbyPatient.Label","Accepted by Patient/#"},
		{"eDS.RejectedbyPatient.Label","Rejected by Patient/# "},
		{"eDS.RoomNo.Label","Room No"},
		{"eDS.BedNo.Label","Bed No"},
		{"eDS.SupplementaryOrderFor.Label","Supplementary Order For"},
		{"eDS.SetStatusforallPatients.Label","Set Status for all Patients"},
		{"eDS.PlaceSupplementaryOrder.Label","Place Supplementary Order"},
		{"eDS.SupplementaryOrderAuditTrail.Label","Supplementary Order View All"},
		//MMS-QH-CRF-0079
		//ML-MMOH-CRF-0418
		{"eDS.PlaceOPDietType.Label","Place for Outpatient Diet Type"},
		{"eDS.PlaceEMDietType.Label","Place for Emergency Patient Diet Type"},
		{"eDS.OPDietType.Label","Outpatient Diet Type"},
		{"eDS.EMDietType.Label","Emergency Patient Diet Type"},
		//ML-MMOH-CRF-0418
		//ML-MMOH-CRF-0410
		{"eDS.NBMWithout.Label","NBM without Diet Order"},
		{"eDS.NBMWith.Label","NBM with Diet Order"},
		{"eDS.FullNilByMouth.Label","Full Nil By Mouth (NBM)"},
		//ML-MMOH-CRF-0410		
		//ML-MMOH-CRF-0419
		{"eDS.DietRequestLocation.Label","Diet Request Location"},
		{"eDS.Vegetarian.Label","Vegetarian"},
		{"eDS.FullDiet.Label","Full Diet"},
		{"eDS.Western.Label","Western"},
		{"eDS.FirstClass.Label","1st Class"},
		{"eDS.SecondClass.Label","2nd Class"},
		{"eDS.ThirdClass.Label","3rd Class"},
		{"eDS.LocationCode.Label","Location Code"},	
		//ML-MMOH-CRF-0419
		
        //ML-MMOH-CRF-0423 Starts Here
		{"eDS.WardClinic.Label","Ward/Clinic"},
		{"eDS.WardOrClinicDesc.Label","Ward Or Clinic Description"},
		{"eDS.TotalNoOfPatients.Label","Total No Of Patients"},
		{"eDS.TotalOrders.Label","Total Orders"},
		{"eDS.AttendantOrders.Label","Attendant Orders"},
		{"eDS.FullNBM.Label","Full NBM"},
		//ML-MMOH-CRF-0423 Ends Here
		{"eDS.ApplForStaffOrder.Label","Applicable For Staff Order"},
		{"eDS.DefaultDietRequestLocation.Label","Default Diet Request Location"},		
		//ML-MMOH-CRF-0678 Starts Here
		{"eDS.practitionerName.Label","Practitioner Name"},
		//ML-MMOH-CRF-0730 
		{"eDS.TotalNoofmealsreceived.Label","Total No. of meals received"},
        {"eDS.Noofmealsreceived.Label","No. of meals received"},
        {"eDS.Totalnoofmealsreject.Label","Total No. of meals rejected"},
	    {"eDS.Noofmealreject.Label","No. of meals rejected"},
		
		//Added against KDAH-CRF-0359.1 starts Here
		{"eDS.ExistingItem.Label","Existing Item"},
		{"eDS.NewItem.Label","New Item"},
		{"eDS.mealType.Label","Meal Type"},
		{"eDS.MenuDescription.Label","Menu Description"},
		//Added against KDAH-CRF-0359.1 Ends Here		
		{"eDS.AdditionalInstruction.Label","ADDITIONAL INSTRUCTIONS"},//Added against AMS-CRF-112
		//{"eDS.AdditionalInstructionError.Label","Additional Instructions"},//Added against AMS-CRF-112
	//ML-MMOH-CRF-0820
		{"eDS.IPDietType.Label","Inpatient Diet Type"},
		{"eDS.DCDietType.Label","Daycare Diet Type"},
		{"eDS.PlaceStaffMealOrder.Label","Place Staff Meal Order"},		
		{"eDS.FoodReplacement.Label","Food Replacement"},
		{"eDS.ApplicableEditMenu.Label","Applicable for Edit Menu"},//ML-MMOH-CRF-0669
		//ML-MMOH-CRF-0684
		{"eDS.MenuType.Label","Menu Type"},
		{"eDS.DefaultMenuType.Label","Default Menu Type"},
		{"eDS.ApplForInpatient.Label","Applicable For Inpatient"},
		{"eDS.ApplForOutpatient.Label","Applicable For Outpatient"},
		{"eDS.ApplForEmergencyPatient.Label","Applicable For Emergency Patient"},
		{"eDS.DefaultMealClassforBedClasses.Label","Default Meal Class for Bed Classes"},
		{"eDS.AllowPlaceDietOrderforOP/EM.Label","Allow Place Diet Order for Outpatient/Emergency"},
		{"eDS.AllowPlaceDietOrderforIP.Label","Allow Place Diet Order for Inpatient"},
		{"eDS.Staff.Label","Staff"},//ML-MMOH-CRF-0680
		//Added against ML-MMOH-CRF-0600 Starts Here
		{"eDS.PendingMealAcknowledgements.Label","Pending Meal Acknowledgements"},
		{"eDS.OrderDate.Label","Order Date"},
		{"eDS.Status.Label","Status"},
		//Added against ML-MMOH-CRF-0600 Ends Here
		{"eDS.BedNumber.Label","Bed Number"},
		//ML-MMOH-CRF-0677
		{"eDS.EditMeals.Label","Edit Meals"},
		{"eDS.NutrientSupplement.Label","Nutrient Supplement"},
		{"eDS.FoodDislike.Label","Food Dislike"},
		{"eDS.SpecialFoodOrder.Label","Special Food Order"},
        //ML-MMOH-CRF-0677
		
		//Added against ML-MMOH-CRF-0685 Starts Here
		{"eDS.ServingDateFrom.Label","ServingDate From"},
		{"eDS.ServingDateTo.Label","ServingDate To"},
		{"eDS.AcknowledgeStatus.Label","Acknowledge Status"},
		{"eDS.PatientStatus.Label","Patient Status"},
		{"eDS.RejectionDateAndTime.Label","Rejection Date and Time"},
		//Added against ML-MMOH-CRF-0685 Ends Here
		//Added against ML-MMOH-CRF-0687 Starts Here
		{"eDS.MealStatus.Label","Meal Status"},
		{"eDS.ComplaintDateAndTime.Label","Complaint Date and Time"},
		{"eDS.AcknowledgedBy.Label","Acknowledged By"},
		{"eDS.AcknowledgedDateAndTime.Label","Acknowledged Date and Time"},
		{"eDS.Acknowledge.Label","Acknowledge"},
		//Added against ML-MMOH-CRF-0687 Ends Here
		//Added Against Start ML-MMOH-CRF-1006
		{"eDS.PlaceIPMealOrder.Label","Place Inpatient Meal Order"},
		{"eDS.IPMealOrder.Label","Inpatient Meal Order"},
		{"eDS.MealOrder.Label","Meal Order"},		
		{"eDS.EmergencyPatient.Label","Emergency Patient"},		
		{"eDS.DietOrder.Label","Diet Order"},
		{"eDS.Supplementary.Label","Supplementary"},		
		{"eDS.DoctorOnCall.Label","Doctor On-Call"},		
		{"eDS.OTParamedicStaff.Label","OT/Paramedic Staff"},		
		{"eDS.OnCallStaff.Label","On Call Staff"},		
		{"eDS.Students.Label","Students"},		
		//Added Against End ML-MMOH-CRF-1006
		{"eDS.ApplicableFor.Label","Applicable For"},//Added against ML-MMOH-CRF-1005
		{"eDS.OrderPlacedFor.Label","Order Placed For"},//Added against ML-MMOH-CRF-1005
		//Added against ML-MMOH-CRF-1061 Starts Here
		{"eDS.DefineStatusForDocument/AcknowledgeOP/EMPatientMealOrder.Label","Define Status For Document/ Acknowledge Outpatient/ Emergency Patient Meal Order"},
		{"eDS.DefineStatusForDocument/AcknowledgeMealPrepared/Served/Complaints.Label","Define Status For Document/ Acknowledge Meal Prepared/ Served/ Complaints"},
		{"eDS.NumberOfStatusRequired.Label","Number Of Status Required"},
		//Added against ML-MMOH-CRF-1061 Ends Here
		{"eDS.CommercialFoodItem.Label","Commercial Food Item"}, //Added Against PMG2017-COMN-CRF-0012[IN066074]
		//Added Against ML-MMOH-CRF-1123[IN067026]
		{"eDS.placeOrderFor.Label","Place Order For"},
		{"eDS.AlaCartePatient.Label","Ala Carte Patients"},
		{"eDS.NonAlaCartePatient.Label","Non Ala Carte Patients"},
		//Added Against ML-MMOH-CRF-0825
		{"eDS.ServingLateTime.Label","Serving Time and Late/Irregular Diet Orders Applicable for"},
		{"eDS.StaffOrders.Label","Staff Orders"},
		{"eDS.SupplementaryOrders.Label","Supplementary Orders"},
		//Added Against KDAH-CRF-0353
		{"eDS.NutritionalDiagnosis.Label","Nutritional Diagnosis"},
		//Addded Against PMG2013-CRF-0009.1
		{"eDS.CancellationReason.Label","Cancellation Reason"},
		{"eDS.ReasonForCancellation.Label","Reason For Cancellation"},
		{"eDS.ComplaintReasonCode.Label","Complaint/Reason Code"}, 
		{"eDS.Reorder.Label","Reorder"}, //Addded Against KDAH-CRF-0511
		//Added Against MMS-KH-CRF-0029.1
		{"eDS.Drug-Food.Label","Drug-Food Interaction"},
		{"eDS.EnableDrugFoodYN.Label","Enable Drug Food Interaction Message For IP Patient"},
		//Added Against MMS-KH-CRF-0029.1		
	    {"eDS.OrderDateTime.Label","Order Date Time"}, // Addded against ML-MMOH-CRF-1780
		{"eDS.InstructionInLabelFormula.Label","Instruction in Label (Formula)"}, //Added by Santhosh for ML-MMOH-CRF-1961
		{"eDS.OrderedDate.label","Ordered Date"}, 
		{"eDS.AuthorizedDate.label","Authorized Date"},
		{"eDS.OrderPlacedBy.label","Order Placed by"},
		{"eDS.AuthorizedDateTime.label","Authorized Date/Time"}//END
	};
	@Override
	//protected Object[][] getContents() {
	public Object[][] getContents() {
		// TODO Auto-generated method stub
		return CONTENTS;
	}
}