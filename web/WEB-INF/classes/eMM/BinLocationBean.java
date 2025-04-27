/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMM ;
import java.util.HashMap;

public class BinLocationBean  extends MultipleInsertBinLocationBean implements java.io.Serializable{

	public BinLocationBean() 	{
		super.InsertSQL = eMM.Common.MmRepository.getMmKeyValue("SQL_MM_BINLOCATION_INSERT");
		super.ModifySQL = eMM.Common.MmRepository.getMmKeyValue("SQL_MM_BINLOCATION_MODIFY");
		super.UpdateSQL = eMM.Common.MmRepository.getMmKeyValue("SQL_MM_BINLOCATION_UPDATE");
		super.SelectSQL = eMM.Common.MmRepository.getMmKeyValue("SQL_MM_BINLOCATION_EXISTS");
		super.codeFieldName = "bin_location_code";
	}
	 
	public HashMap validate() throws Exception {
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "" ) ;
        return map ;
    }

	
}
