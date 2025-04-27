/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;

//import eCommon.Common.CommonAdapter;
import eST.Common.StAdapter;
//import eST.Common.StRepository;
import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class ReportStockFSMoveBean extends StAdapter
    implements Serializable
{
 	
    
/*	public String getReportType()
    {
        return getStaticListOptionTag("STBSTKS1,Item Consolidated;STBSTKS2,By Item Store;STBSTKS3,By Store Batch;STBSTKS4,By Store Bin Location;STBSTKS5,By Store;STBSTKS6,By Item Batch;");
    }
	*/

    public String getReportOption()
    {
        return getStaticListOptionTag("A,All Items;Q,By Quantity;V,By Value;N,No Movement");
    }

	public String getReportOrder()
    {
        return getStaticListOptionTag("I,Item Consolidated;S,By Store","I");
    }
   
   // public String module_id;
}
