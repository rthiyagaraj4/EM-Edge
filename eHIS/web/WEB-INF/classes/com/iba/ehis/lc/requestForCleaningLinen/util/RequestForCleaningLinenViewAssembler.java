/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.requestForCleaningLinen.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.bcel.generic.INSTANCEOF;

import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.lc.requestForCleaningLinen.vo.CleaningLinenRequestList;
import com.iba.ehis.lc.requestForCleaningLinen.vo.RequestForCleaningLinenMainVO;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.logging.pojo.business.IBALogger;

public class RequestForCleaningLinenViewAssembler extends AppAssembler {

	
	public Object convertDO2VO(Object oDO) throws AssemblerException {
			
			
		RequestForCleaningLinenMainVO mainVO=new RequestForCleaningLinenMainVO() ;
			for (Iterator iter = ((List) oDO).iterator(); iter.hasNext();) {
				Object[] obj = (Object[]) iter.next();
				
				CleaningLinenRequestList cleaningLinenRequestList=new CleaningLinenRequestList();	
				cleaningLinenRequestList.setLinenItem((String) obj[0]);
				cleaningLinenRequestList.setRemark((String) obj[1]);
				cleaningLinenRequestList.setRequestedQty((Long) obj[2]);
				try{
					
					if(obj[2]!="")
					{
						cleaningLinenRequestList.setDeliveredQty((Long) obj[3]);
						
					}
					}catch(Exception e){e.printStackTrace();}
				
				mainVO.getCleaningRequestsListVO().getLinenRequest().add(cleaningLinenRequestList);
			}
			return mainVO;
	}

	
}
