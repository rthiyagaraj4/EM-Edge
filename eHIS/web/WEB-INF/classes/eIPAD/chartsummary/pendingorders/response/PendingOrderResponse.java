/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.pendingorders.response;
import eIPAD.chartsummary.common.response.*;
import eIPAD.chartsummary.pendingorders.healthobject.*;
import java.util.*;

public class PendingOrderResponse  extends GenericResponse{
	private List<PendingOrders> pendingOrderList;

	/**
	 * @return the pendingOrderList 
	 */
	public List<PendingOrders> getPendingOrderList() {
		return pendingOrderList;
	}

	/**
	 * @param pendingOrderList the pendingOrderList to set
	 */
	public void setPendingOrderList(List<PendingOrders> pendingOrderList) {
		this.pendingOrderList = pendingOrderList;
	}
	
	/**
	 * @override this method is overridden since Pending orders will have the error item PENDINGORDER_EMPTY_DATA
	 */
	public boolean isEmptyDataResponse(){
		boolean isEmpty = false;
		ArrayList<ErrorInfo> errorsList = getErrorsList();
		if(!errorsList.isEmpty()){
			for(ErrorInfo errorInfo:errorsList){
				if(errorInfo.getErrorType() == Errors.PENDINGORDER_EMPTY_DATA)
				{
					isEmpty = true;
					break;
				}
			}
		}
		return isEmpty;
	}
}
