/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXI.resources;

import java.util.*;

public class  Labels  extends ListResourceBundle{
	public Object[][] getContents() {
         return contents;
    }

	static final Object[][] contents = {

{"eXI.FinalizedBy.Label","Finalized By"},
{"eXI.QtyFinalized.Label","Quantity Finalized"},
{"eXI.QtyIssued.Label","Quantity Issued"},
{"eXI.QtyReceived.Label","Quantity Received"},
{"eXI.QtyApproved.Label","Quantity Approved"},
{"eXI.ItemCategory.Label","Item Category"},
{"eXI.ReqProc.Label","Requisitions Processed"},
{"eXI.ReqNotProc.Label","Requisitions Not Processed"},
{"eXI.GoodsRecWOrg.Label","Goods Receipts (w Reqn)"},
{"eXI.GoodsRecWithoutOrg.Label","Goods Receipts (w/o Reqn)"},
{"eXI.GRNReturns.Label","GRN Returns"},
{"eXI.NormalReturns.Label","Normal Returns/ Transfers"},
{"eXI.UnapprOrCancel.Label","Unapproved / Cancelled"},
{"eXI.NotProcByIBA.Label","Not Processed by IBA"},
{"eXI.NotProcByExtSys.Label","Not Processed by Ext System"},
{"eXI.raccluster.Label","ClusterYN"},
{"eXI.Partial/FullReceipt.Label","Partial/Full Receipt"},
{"eXI.RequestedOrg.Label","Requested Organization"},
{"eXI.Summary/DetailBy.Label","Summary/Detail By"},
{"eXI.ReqRejByPO.Label","Request Rejected by PO Dept"},
{"eXI.ReqCancelled.Label","Request Cancelled"},
{"eXI.ReqRecPartially.Label","Request Received Partially"},
{"eXI.ReqRecCompletely.Label","Request Received Completely"},
{"eXI.SummaryType.Label","Summary Type"},
{"eXI.ExtApplication.Label","External Application"},
{"eXI.DefaultAttributes.Label","Default Attributes"},
{"eXI.PartialReceipt.Label","Partial Receipt"},
{"eXI.FullReceipt.Label","Full Receipt"},
{"eXI.PendingApproval.Label","Pending Approval"},
{"eXI.AfterDate.Label","After Date"},
{"eXI.clustertns.Label","ClusterTNS"},
{"eXI.CreationDate.Label","Creation Date"},
{"eXI.Requisitions.Label","Requisitions"},
{"eXI.GRNReturns.Label","Returns (w GRN No)"},
{"eXI.NormalReturns.Label","Returns (w/o GRN No)"},
//Labels added for Ammend New Item
{"eXI.Genuom.Label","Gen Uom"},
{"eXI.Saleuom.Label","Sale Uom"},
{"eXI.MaterialGroupCode.Label","Material Group Code"}, 
{"eXI.GenUOMSaleUOM.Label","Gen UOM / Sale UOM for the selected items "},
// Labels added for View Interfaced GRN function
{"eXI.grn_unit_cost_in_pur_uom.Label","Pur UOM GRN Unit Cost"},
{"eXI.grn_unit_cost_in_stk_uom.Label","Stock UOM GRN Unit Cost"},
{"eXI.pur_uom_conv.Label", "Pur UOM Conv"},
{"eXI.po_cost.Label","PO Cost"},
{"eXI.po_discount.Label","PO Discount"},						 
{"eXI.po_tax.Label","PO Tax"},
{"eXI.tot_invoice_qty.Label","Total Invoice Qty" },
{"eXI.replace_on_expiry_yn.Label","Replace On ExpiryYN"}, 
{"eXI.xi_brand_name.Label","Interface Brand Name"},
{"eXI.xi_packing_size.Label","Interface Packing Size"}, 
{"eXI.xi_packing_kind.Label","Interface Packing Kind"}, 
{"eXI.xi_batch_id.Label","Interface Batch ID"},  
{"eXI.xi_organization_id.Label","Interface Organization Id"}, 
{"eXI.xi_remarks.Label","Interface Remarks"}, 
{"eXI.ViewSingleFrameDtls.Label","View Single Frame Details"},
{"eXI.DocSrlNo.Label","Doc Srl.No"},
{"eXI.GrnDate.Label","GRN Date"}, 
{"eXI.ProcBy.Label","Processed By"},  			
{"eXI.ProcDate.Label","Processed Date"},	 
{"eXI.Generated.Label","Generated"},
{"eXI.no.Label","Number"},	
{"eXI.lot_no.Label","Lot No"}, 
{"eXI.grn_item_qty.Label","GRN Item Qty"}, 							 
{"eXI.pur_uom_code.Label","Purchase UOM Code"},
{"eXI.rtv_item_qty.Label", "Retrieve Item Qty"},
{"eXI.type_of_issue.Label","Type of Issue"},   
{"eXI.customer_num.Label","Customer Number"}, 
{"eXI.site_num.Label","Site Number"},
{"eXI.request_num.Label","Request Number"}, 
{"eXI.request_line_num.Label","Request Line Number"},
{"eXI.inventory_item_id.Label","Inventory Item Id"},
{"eXI.sale_price.Label","Sale Price"}, 
{"eXI.hdr_remarks.Label","HDR Remarks"}, 
{"eXI.processed_by_id.Label","Processed By Id"},
{"eXI.iba_doc_type_code.Label","IBA Doc Type Code"},
{"eXI.iba_doc_num.Label","IBA Doc Number"},
{"eXI.iba_doc_line_num.Label","IBA Doc Line Num"},
{"eXI.trans_status.Label","Trans Status"}, 
{"eXI.supp_name.Label","Supplier Name"},
{"eXI.bin_location_code.Label","Bin Location Code"},  
{"eXI.Processed.Label","Processed"},
{"eXI.UnProcessed.Label","UnProcessed"},
{"eXI.UnProcessed.Label","UnProcessed"},
{"eXI.err_msg.Label","Error Message"},
{"eXI.seq_no.Label","Seq No"},
{"eXI.Loadstatus.Label","Load Status"},
{"eXI.CommStatus.Label","Comm Status"},
{"eXI.trx_no.Label","Transaction Number"},
{"eXI.reprocess.Label","Re Process"}
};
}

