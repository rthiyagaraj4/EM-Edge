/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePO ;
import java.util.HashMap;

public class PurchaseUnitBean  extends MultipleInsertPurchaseUnitBean implements java.io.Serializable{

	public PurchaseUnitBean() 	{
		System.out.println("PurchaseUnitBean");
		super.InsertSQL = ePO.Common.PoRepository.getPoKeyValue("SQL_PO_PURCHASE_UNIT_INSERT");
		super.ModifySQL = ePO.Common.PoRepository.getPoKeyValue("SQL_PO_PURCHASE_UNIT_MODIFY");
		super.UpdateSQL = ePO.Common.PoRepository.getPoKeyValue("SQL_PO_PURCHASE_UNIT_UPDATE");
		super.SelectSQL = ePO.Common.PoRepository.getPoKeyValue("SQL_PO_PURCHASE_UNIT_EXISTS");
		//super.codeFieldName = "purchase_unit";
	}
	 
	public HashMap validate() throws Exception {
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "" ) ;
        return map ;
    }

	
}
