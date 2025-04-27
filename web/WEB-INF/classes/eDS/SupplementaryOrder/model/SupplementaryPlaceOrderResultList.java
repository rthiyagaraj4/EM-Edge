package eDS.SupplementaryOrder.model;

import java.util.ArrayList;
import java.util.List;

public class SupplementaryPlaceOrderResultList {
	List<SupplementaryPlaceOrderResult> list=new ArrayList<SupplementaryPlaceOrderResult>();
	
	public void setList(SupplementaryPlaceOrderResult list){
		this.list.add(list);
	}
	public List getList(){
		return list;
	}

}
