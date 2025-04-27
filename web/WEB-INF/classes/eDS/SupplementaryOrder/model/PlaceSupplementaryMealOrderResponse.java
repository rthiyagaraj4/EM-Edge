package eDS.SupplementaryOrder.model;

public class PlaceSupplementaryMealOrderResponse {
	
	private String SupplementaryOrderForCode;
	private String SupplementaryOrderForDesc;
	private String Date;
	private String Meal_Type_Code;
	private String Meal_Type_Desc;
	private String Item_Type_Code;
	private String Item_Type_Desc;
	private String Item_Code;
	private String Item_Desc;
	//private String Item_Type;
	private String Qty;
	private String Instructions;
	private String Status;
	private String sno;
	
	
	private String remarks;
	
	public void setSupplementaryOrderForCode(String SupplementaryOrderForCode){
		this.SupplementaryOrderForCode=SupplementaryOrderForCode;
	}
	public void setSupplementaryOrderForDesc(String SupplementaryOrderForDesc){
		this.SupplementaryOrderForDesc=SupplementaryOrderForDesc;
	}
	public void setDate(String Date){
		this.Date=Date;
	}
	public void setMeal_Type_Code(String Meal_Type_Code){
		this.Meal_Type_Code=Meal_Type_Code;
	}
	public void setMeal_Type_Desc(String Meal_Type_Desc){
		this.Meal_Type_Desc=Meal_Type_Desc;
	}
	public void setItem_Type_Code(String Item_Type_Code){
		this.Item_Type_Code=Item_Type_Code;
	}
	public void setItem_Type_Desc(String Item_Type_Desc){
		this.Item_Type_Desc=Item_Type_Desc;
	}
	public void setItem_Code(String Item_Code){
		this.Item_Code=Item_Code;
	}
	public void setItem_Desc(String Item_Desc){
		this.Item_Desc=Item_Desc;
	}
	public void setQty(String Qty){
		this.Qty=Qty;
	}
	public void setInstructions(String Instructions){
		this.Instructions=Instructions;
	}
	public void setStatus(String Status){
		this.Status=Status;
	}
	public void setsno(String sno){
		this.sno=sno;
	}
	public void setRemarks(String remarks){
		this.remarks=remarks;
	}
	public String getRemarks(){
		return remarks;
	}
}
