/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package eIPAD.chartsummary.common.bc;

/**
 * @author GaneshkumarC 
 *
 */
import eIPAD.chartsummary.common.request.*;
import eIPAD.chartsummary.common.response.*;
import eIPAD.chartsummary.common.healthobject.*;
import eIPAD.chartsummary.common.dao.*;
import eIPAD.chartsummary.common.daoimpl.*;
import java.util.*;

public class SfsBC {
	public SfsResponse getSfsDetails(SFSRequest oSfsReq)
	{
		SfsResponse oSfsRes;
		SfsQuery oSfsQuery = oSfsReq.getQuery();
		SfsExecuteQuery oSfsExeQuery = new SfsDAOImpl();
		oSfsRes = oSfsExeQuery.executeSfsQuery(oSfsQuery);
		if(oSfsReq.isbDuplicateValues())
		{
			HashMap<String,String> oSfsMap = new HashMap<String, String>();
			int nCount = 0;
			int nListSize = 0;
			if(oSfsRes != null && oSfsRes.getLstSfsHO() != null)
			{
				nListSize = oSfsRes.getLstSfsHO().size();
				if(nListSize > 0)
				{
					for(nCount = 0 ; nCount < nListSize; nCount++)
					{
						//if(!oSfsMap.containsKey(key))
						SfsHo oSfsHo;
						oSfsHo = oSfsRes.getLstSfsHO().get(nCount);
						if(oSfsHo != null)
						{
							if(!oSfsMap.containsKey(oSfsHo.getCode()))
							{
								oSfsMap.put(oSfsHo.getCode(), oSfsHo.getDescription());
							}
						}
					}
				}
			}
			oSfsRes.setoSfsMap(oSfsMap);
			oSfsRes.setbDuplicateValues(true);
			oSfsRes.setLstSfsHO(null);
			
		}
		return oSfsRes;
	}
}
