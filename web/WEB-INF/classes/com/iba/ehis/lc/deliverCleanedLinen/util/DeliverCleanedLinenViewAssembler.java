/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.deliverCleanedLinen.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.bcel.generic.INSTANCEOF;

import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.lc.deliverCleanedLinen.vo.DeliverCleanedLinenMainVO;
import com.iba.ehis.lc.deliverCleanedLinen.vo.LinenDeliverList;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.DateUtil;
import com.iba.framework.core.util.IBADateTime;


public class DeliverCleanedLinenViewAssembler extends AppAssembler {

	
	public Object convertDO2VO(Object oDO) throws AssemblerException {
			
			
		DeliverCleanedLinenMainVO mainVO=new DeliverCleanedLinenMainVO() ;
			for (Iterator iter = ((List) oDO).iterator(); iter.hasNext();) {
				Object[] obj = (Object[]) iter.next();
				
				LinenDeliverList linenDeliverList=new LinenDeliverList();	
				linenDeliverList.setLinenItem((String) obj[0]);
				linenDeliverList.setRequestedQty((Long)obj[2]);
				linenDeliverList.setRemark((String) obj[1]);
				try{
				if(obj[3]!=null)
				{	
				linenDeliverList.setDeliveredQty((Long) obj[3]);
				}
				if(obj[4]!=null)
				{
				linenDeliverList.setSchedDeliveryDate(DateUtil.getDateTime("dd/MM/yyyy HH:mm",((Date)obj[4])));
				}
				if(obj[5]!=null)
				{
				linenDeliverList.setLateDeliveryReason((String)obj[5]);
				}
				}catch(Exception e){e.printStackTrace();}
				mainVO.getDeliverCleanedLinenVO().getLinenDeliverList().add(linenDeliverList);
			}
			return mainVO;
	}

	
}
