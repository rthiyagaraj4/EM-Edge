package eDS.SupplementaryOrder.model;

import java.util.List;

public class SupplementaryPlaceOrderResponse {
	private SupplementaryPlaceOrderResultList list;
	private List<SupplementaryProcessResponse> processSupplementaryOrderResponseList;
	
	public void setResultList(SupplementaryPlaceOrderResultList list){
		this.list=list;
		
	}
	public SupplementaryPlaceOrderResultList getResultList(){
		return list;
	}
	
	public void setProcessSearchList(List<SupplementaryProcessResponse> processSupplementaryOrderResponseList){
		this.processSupplementaryOrderResponseList=processSupplementaryOrderResponseList;
	}
	public List<SupplementaryProcessResponse> getProcessSearchList(){
		return processSupplementaryOrderResponseList;
	}

}
