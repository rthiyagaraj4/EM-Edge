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

public class  Labels_zh  extends ListResourceBundle{
	public Object[][] getContents() {
         return contents;
    }


	static final Object[][] contents = {
		{"eXI.FinalizedBy.Label","完�?"},
		{"eXI.QtyFinalized.Label","数�?完�?"},
		{"eXI.QtyIssued.Label","�?�放数�?"},
		{"eXI.QtyReceived.Label","接收数�?"},
		{"eXI.QtyApproved.Label","�?��?数�?"},
		{"eXI.ItemCategory.Label","项目分类"},
		{"eXI.ReqProc.Label","申购处�?�"},
		{"eXI.ReqNotProc.Label","申购�?处�?�"},
		{"eXI.GoodsRecWOrg.Label","货物收�?�"},
		{"eXI.GoodsRecWithoutOrg.Label","货物收�?�"},
		{"eXI.GRNReturns.Label","退回GRN"},
		{"eXI.NormalReturns.Label","正常退回/转让"},
		{"eXI.UnapprOrCancel.Label","�?�?��?/�?�消"},
		{"eXI.NotProcByIBA.Label","IBA�?处�?�"},
		{"eXI.NotProcByExtSys.Label","�?外系统�?处�?�"},
//		{"eXI.raccluster.Label","Raccluster"},
		{"eXI.Partial/FullReceipt.Label","部分/完整收�?�"},
		{"eXI.RequestedOrg.Label","�?求组织"},
		{"eXI.Summary/DetailBy.Label","综述/详细"},
		{"eXI.ReqRejByPO.Label","订购部门驳回请求"},
		{"eXI.ReqCancelled.Label","请求�?�消"},
		{"eXI.ReqRecPartially.Label","收到部分请求"},
		{"eXI.ReqRecCompletely.Label","收到完整请求"},
		{"eXI.SummaryType.Label","综述型"},
		{"eXI.ExtApplication.Label","外部程�?"},
		{"eXI.DefaultAttributes.Label","默认属性"},
		{"eXI.PartialReceipt.Label","部分收�?�"},
		{"eXI.FullReceipt.Label","完整的收�?�"},
		{"eXI.PendingApproval.Label","待批准"},
		{"eXI.AfterDate.Label","�?�日期"},
//		{"eXI.clustertns.Label","Clustertns"},
		{"eXI.CreationDate.Label","�?�表日期"},
//Newly added legends on 21/01/09
{"eXI.clustertns.Label","ClusterTNS"},
{"eXI.raccluster.Label","集群 是/�?�"},
//added for Ammend New Item
{"eXI.Genuom.Label","zh_Gen Uom"},
{"eXI.Saleuom.Label","zh_Sale Uom"},
{"eXI.MaterialGroupCode.Label","zh_Material Group Code"}, 
{"eXI.GenUOMSaleUOM.Label","zh_Gen UOM / Sale UOM for the selected items "}


};
}
