/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
14/02/2017		IN060945			Badmavathi B						MMS-DM-CRF-0084 - FDA_CODE added
06/04/2017	    IN063261		        Manoj kumar KV							GHL-CRF-0444			
09/05/2017				62881		B.Badmavathi					    PO Mandatory in GRN 
20/08/2020      IN073342            Prabha	  							PH-PMG2020-TECH-CRF-0001/01 - Unable to select the Medical Supply
13/5/2021		TFS:14012			Shazana											MO-CRF-20165
---------------------------------------------------------------------------------------------------------
*/
package eMM.resources;

import java.util.*;

public class Labels extends ListResourceBundle implements java.io.Serializable{
	public Object[][] getContents() {
         return contents;
    }

	static final Object[][] contents = {
			{"eMM.Adjustment.label","Adjustment"},
			{"eMM.AllowBonusEntry.label","Allow Bonus Entry"},
			{"eMM.AllowSampleEntry.label","Allow Sample Entry"},
			{"eMM.AssemblyDetails/MFGFormulary.label","Assembly Details/MFG Formulary"},
			{"eMM.AssemblyInstructions.label","Assembly Instructions"},
			{"eMM.BillableItem.label","Billable Item"},
			{"eMM.BinLocationCode.label","Bin Location Code"},
			{"eMM.CategoryType.label","Category Type"},
			{"eMM.ContactReference.label","Contact Reference"},
			{"eMM.DecentralizedInventory.label","Decentralized Inventory"},
			{"eMM.DefaultBatchIDifBatchIDisNotApplicable.label","Default Batch ID if Batch ID is Not Applicable"},
			{"eMM.DefaultTradeIDifTradeIDisNotApplicable.label","Default Trade ID if Trade ID is Not Applicable"},
			{"eMM.FacilityLevel.label","Facility Level"},
			{"eMM.InchargeName.label","Incharge Name"},
			{"eMM.InchargeTitle.label","Incharge Title"},
			{"eMM.InventoryManagement.label","Inventory Management"},
			{"eMM.ItemAlphaCode.label","Item Alpha Code"},
			{"eMM.ItemAnalysisCode.label","Item Analysis Code"},
			{"eMM.ItemClassforStore.label","Item Class for Store"},
			{"eMM.ItemforStore.label","Item for Store"},
			{"eMM.ItemMaster.label","Item Master"},
			{"eMM.ItemRemarks.label","Item Remarks"},
			{"eMM.ItemSpecification.label","Item Specification"},
			{"eMM.ItemStoreBinLocation.label","Item Store Bin Location"},
			{"eMM.LastPurchaseAdviceDate.label","Last Purchase Advice Date"},
			{"eMM.Machine.label","Machine"},
			{"eMM.MaterialCode.label","Material Code"},
			{"eMM.MaterialGroup.label","Material Group"},
			{"eMM.MaterialGroupCode.label","Material Group Code"},
			{"eMM.ModuleApplicability.label","Module Applicability"},
			{"eMM.Non-Inventory.label","Non-Inventory"},
			{"eMM.PeriodEndScope.label","Period End Scope"},
			{"eMM.PharmacyStockItem.label","Pharmacy Stock Item"},
			{"eMM.PurchaseControl.label","Purchase Control"},
			{"eMM.QuantityOnOrder.label","Quantity On Order"},
			{"eMM.SearchString.label","Search String"},
			{"eMM.SterileStock.label","Sterile Stock"},
			{"eMM.StoreInchargeDetails.label","Store Incharge Details"},
			{"eMM.TradeNameforItem.label","Trade Name for Item"},
			{"eMM.TransactionRemarksCode.label","Transaction Remarks Code"},
			{"eMM.ItemAnalysisDesc.label","Item Analysis Description"},									
			{"eMM.BinDesciption.label","Bin Location Description"},							
			{"eMM.SupplierDescription.label","Supplier Description"},			
			{"eMM.TRNRemarksDescription.label","Transaction Remarks Description"},  
			{"eMM.CSSDComponent.label","CSSD Component"},				
			{"eMM.ShowSimilarItems.label","Show Similar Items"},																				
			{"eMM.DefaultBatchIDforNonExpiryItems.label","Default Batch ID for Non Expiry Items"},							
			{"eMM.Materials.label","Materials"}, 
			{"eMM.ItemUOMDefinition.label","Item UOM Definition"}, 
			{"eMM.OccupationStatus.label","Occupation Status"},
			{"eMM.ApplModules.label","Appl Modules"},
			{"eMM.ItemClassCodeFrom.label","Item Class Code From"},
			{"eMM.MaterialCodeFrom.label","Material Code From"},
			{"eMM.DepartmentCodeFrom.label","Department Code From"},
			{"eMM.StoreLocation.label","Store Location"},
			{"eMM.TotalNoofDepartments.label","Total No of Departments"},
			{"eMM.TotalNoofStore.label","Total No of Store"},
			{"eMM.SupplierCodeFrom.label","Supplier Code From"},
			{"eMM.SupplierAlphaCode.label","Supplier Alpha Code"},
			{"eMM.TradeIdFrom.label","Trade Id From"},
			{"eMM.EffectiveStatus.label","Effective Status"},
			{"eMM.TRNCode.label","TRN Code"},
			{"eMM.ItemAnalysisCodeFrom.label","Item Analysis Code From"},
			{"eMM.ReturnPeriodFrom.label","Return Period From"},
			{"eMM.ReceivedQty.label","Received Qty"},
			{"eMM.SupplierTotal.label","Supplier Total"},
			{"eMM.DirectSalesPatient.label","Direct Sales Patient"},
			{"eMM.KitTemplate.label","Kit Template"},
			{"eMM.ParentStoreforStore.label","Parent Store For Store"}, 
   		    {"eMM.MaterialsGroupDesc.label", "Materials Group Desc"},
			{"eMM.DirectSalesAllowed.label", "Direct Sales Allowed"},
			{"eMM.ImportedItem.label","Imported Item"},
			{"eMM.EssentialItem.label","Essential Item"},
			{"eMM.ReimburseType.label","Reimburse Type"},
			{"eMM.NonReimbursable.label","Non Reimbursable"},
			{"eMM.PartialReimbursable.label","Partial Reimbursable"},
			{"eMM.FullyReimbursable.label","Fully Reimbursable"},
			{"eMM.UOMDescription.label","UOM Description"},
			{"eMM.EquivalentUOMCode.label","Equivalent UOM Code"},
			{"eMM.EquivalentUOMDescription.label","Equivalent UOM Description"},
			{"eMM.TRNRemarksFrom.label","TRN Remarks From"},
			{"eMM.UserAccessForMaterialGroup.label","User Access For Material Group"},
			{"eMM.PODepartment.label", "PO Department"},
			{"eMM.StoreGroupCode.label", "Store Group Code"},
			{"eMM.StoreGroupDescription.label", "Store Group Description"},
			{"eMM.StoreGroup.label", "Store Group"},
			{"eMM.SimilarItems.label", "Similar Items"},
						//Added By Sakti Sankar on 16/04/2012
			{"eMM.BankNumber.label", "Bank No."},
			{"eMM.AccountNumber.label", "Account No."},
			{"eMM.BankAccountName.label", "Bank Account Name"},
			{"eMM.BranchNumber.label", "Branch No"},
			{"eMM.Currency.label", "Currency"},
			{"eMM.SupplierAddress1.label", "Supplier Address Line 1"},
			{"eMM.SupplierAddress2.label", "Address Line 2"},
			{"eMM.SupplierAddress3.label", "Address Line 3"},
			{"eMM.ZipCode.label", "Zip Code"},
			{"eMM.TelephoneNumber.label", "Telephone No."},
			{"eMM.FaxNumber.label", "Fax No."},
			{"eMM.EmailID.label", "E-mail ID"},
			{"eMM.TitleOfTheContactPerson.label", "Title Of The Contact Person"},
			{"eMM.ContactPerson.label", "Contact Person For Purchase"},
			{"eMM.PaymentTerms.label", "Payment Terms"},			//Added ends.
			{"eMM.ImageCatalogueFileName.label", "Image/Catalogue File Name"},
			{"eMM.PlaceOfOrigin.label", "Country of Origin"},
			{"eMM.ShelfLife.label", "Shelf Life"},
			{"eMM.Non-Drug.label","Non Drug"},//Added for ML-MMOH-CRF-0524
		    {"eMM.InterfaceItemCode.label","Interface Item Code"},
			{"eMM.InterfaceMaterialGroupCode.label","Interface Material Group"},
			{"eMM.FDACode.label","SFDA Code"},//Added for MMS-DM-CRF-0084
			{"eMM.DrugLicenseNo.label","Drug License No"}, // addded for GHL-CRF-0444
			{"eMM.POMandatory.label","PO Number Mandatory in GRN"},// addded for GDOH-CRF-0109		
			{"eMM.HSNCode.label","HSN Code"},
			{"eMM.ItemTechCode.label","Item Technical Name Code"},//Sharanraj GHL-CRF-0548.1
			{"eMM.ItemTechName.label","Item Technical Name"},//Sharanraj GHL-CRF-0548.1			
			
			{"eMM.ItemType.label","Item Type:"},//added for GHL-CRF-0549.1
			{"eMM.LowCostItem.label","Low Cost(LC) Item"},//added for GHL-CRF-0549.1
			{"eMM.HighMarginItem.label","High Margin(HM) Item"},//added for GHL-CRF-0549.1
			{"eMM.InnovatorItem.label","Innovator Item"},//added for GHL-CRF-0549.1
			{"eMM.TradeID.label","Trade ID"}, //uncommented for IN073342
			{"eMM.TradeName.label","Trade Name"}, //uncommented for IN073342
			
			{"eMM.CatalogCode.label","Catalogue Code"},//MO-CRF-20165[19213]
			{"eMM.CatalogCodeDesc.label","Catalogue Code Desc"},//MO-CRF-20165  [19213]
			{"eMM.PriceType.label","Price Type"},//TH-KW-CRF-0046  [32744]
			{"eMM.BatchPrice.label","Batch Price"},//TH-KW-CRF-0046  [32744]
			{"eMM.GlobalPrice.label","Global Price"},//TH-KW-CRF-0046  [32744]
			{"eMM.Category.label","Category"},     //Added for MMS-DM-CRF-0209.2 
			{"eMM.Alternate.label","Alternate"},   //Added for MMS-DM-CRF-0209.2 
			{"eMM.Brand.label","Brand"},          // Added for MMS-DM-CRF-0209.2
			{"eMM.CSSDGroupType.label","CSSD Group Type"},//added for ML-MMOH-CRF-1968
			{"eMM.Set.label","Set"}, //Added for ML-MMOH-CRF-1968
			{"eMM.Single.label","Single"},//Added for ML-MMOH-CRF-1968
			{"eMM.Linen.label","Linen"}, //Added for ML-MMOH-CRF-1968
			{"eMM.SoftPack.label","SoftPack"}, //Added for ML-MMOH-CRF-1968 
			{"eMM.Tray.label","Tray"}, // Added for ML-MMOH-CRF-1968
			{"eMM.ReusableItem.label","Reusable Item"}   // Added for ML-MMOH-SCF-1968.1
			
			//following labels will  be removed soon for the objective of removing dublication.
			/*{"eMM.AlphaCode.label","Alpha Code"},
			{"eMM.BinLocation.label","Bin Location"},
			{"eMM.ConversionFactor.label","Conversion Factor"},
			{"eMM.Customer.label","Customer"},
			{"eMM.DepartmentCode.label","Department Code"},
			{"eMM.Inventory.label","Inventory"},
			{"eMM.ItemAnalysis.label","Item Analysis"},
			{"eMM.ItemClass.label","Item Class"},
			{"eMM.ItemClassCode.label","Item Class Code"},
			{"eMM.Manufacturer.label","Manufacturer"},
			{"eMM.ManufacturerName.label","Manufacturer Name"},
			{"eMM.Module.label","Module"},
			{"eMM.ModuleID.label","Module ID"},
			{"eMM.Nature.label","Nature"},
			{"eMM.PrepareLocation.label","Prepare Location"},
			{"eMM.PurchaseUOM.label","Purchase UOM"},
			{"eMM.RepackingGroup.label","Repacking Group"},
			{"eMM.SoleSource.label","Sole Source"},
			{"eMM.SpecialItem.label","Special Item"},
			{"eMM.Store.label","Store"},
			{"eMM.StoreCode.label","Store Code"},
			{"eMM.Supplier.label","Supplier"},
			{"eMM.SupplierCode.label","Supplier Code"},
			{"eMM.TradeID.label","Trade ID"},   //moved to top
			{"eMM.TradeName.label","Trade Name"},  //moved to top
			{"eMM.TransactionRemarks.label","Transaction Remarks"},
			{"eMM.UnitCost.label","Unit Cost"},
			{"eMM.ItemClassDesc.label","Item Class Description"},							
			{"eMM.Execute.label","Execute"},													
			{"eMM.ExecuteQuery.label","Execute Query"},							
			{"eMM.EquivalentUOM.label"," Equivalent UOM"},
			{"eMM.Highest.label","Highest"},
			{"eMM.Lowest.label","Lowest"},
			{"eMM.StoreCodeFrom.label","Store Code From"},
			{"eMM.ItemCodeFrom.label","Item Code From"},
			{"eMM.TRNTYPE.label","TRN TYPE"},
			{"eMM.ReplacementStatus.label","Replacement Status"},
			{"eMM.ReturnedQty.label","Returned Qty"},
			{"eMM.ReturnedValue.label","Returned Value"},
			{"eMM.ReceivedValue.label","Received Value"},
			{"eMM.PendingQty.label","Pending Qty"},
			{"eMM.GrandTotal.label","Grand Total"},
			{"eMM.ReimburseYN.label","Reimburse"},
			{"eMM.UOMCode.label","UOM Code"}*/
	};
}
