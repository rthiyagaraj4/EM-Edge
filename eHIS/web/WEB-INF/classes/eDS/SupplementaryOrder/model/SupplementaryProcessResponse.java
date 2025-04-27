package eDS.SupplementaryOrder.model;

public class SupplementaryProcessResponse {
	private String total_record;
	private String patient_id;
	private String patient_name;
	private String gender;
	private String roomno;
	private String bedno;
	
	private String supplementaryOrderFor;
	private String supplementaryOrderForCode;
	
	private String ItemType;
	private String ItemTypeCode;
	
	private String FoodItem;
	private String FoodItemCode;
	
	private String ItemQty;
	
	private String MealType;
	private String MealTypeCode;
	private String Status;
	private String Remarks;
	private String Encounter_Id;
	
	public void setTotalRecord(String total_record){
		this.total_record=total_record;
	}
	public String getTotalRecord(){
		return total_record;
	}
	public void setPatientId(String patient_id){
		this.patient_id=patient_id;
	}
	public String getPatientId(){
		return patient_id;
	}
	public void setPatientName(String patient_name){
		this.patient_name=patient_name;
	}
	public String getPatientName(){
		return patient_name;
	}
	public void setGender(String gender){
		this.gender=gender;
	}
	public String getGender(){
		return gender;
	}
	public void setRoomNo(String roomno){
		this.roomno=roomno;
	}
	public String getRoomNo(){
		return roomno;
	}
	public void setBedNo(String bedno){
		this.bedno=bedno;
	}
	public String getBedNo(){
		return bedno;
	}
	public void setSupplementaryOrderFor(String supplementaryOrderFor){
		this.supplementaryOrderFor=supplementaryOrderFor;
	}
	public String getSupplementaryOrderFor(){
		return supplementaryOrderFor;
	}
	
	
	public void setSupplementaryOrderForCode(String supplementaryOrderForCode){
		this.supplementaryOrderForCode=supplementaryOrderForCode;
	}
	public String getSupplementaryOrderForCode(){
		return supplementaryOrderForCode;
	}
	
	public void setItemType(String ItemType){
		this.ItemType=ItemType;
	}
	public String getItemType(){
		return ItemType;
	}
	
	public void setItemTypeCode(String ItemTypeCode){
		this.ItemTypeCode=ItemTypeCode;
	}
	public String getItemTypeCode(){
		return ItemTypeCode;
	}
	
	public void setFoodItem(String FoodItem){
		this.FoodItem=FoodItem;
	}
	public String getFoodItem(){
		return FoodItem;
	}
	
	public void setFoodItemCode(String FoodItemCode){
		this.FoodItemCode=FoodItemCode;
	}
	public String getFoodItemCode(){
		return FoodItemCode;
	}
	
	public void setItemQty(String ItemQty){
		this.ItemQty=ItemQty;
	}
	public String getItemQty(){
		return ItemQty;
	}
	
	public void setMealType(String MealType){
		this.MealType=MealType;
	}
	public String getMealType(){
		return MealType;
	}
	
	public void setMealTypeCode(String MealTypeCode){
		this.MealTypeCode=MealTypeCode;
	}
	public String getMealTypeCode(){
		return MealTypeCode;
	}
	
	
	public void setStatus(String Status){
		this.Status=Status;
	}
	public String getStatus(){
		return Status;
	}
	public void setReamarks(String Remarks){
		this.Remarks=Remarks;
	}
	public String getRemarks(){
		return Remarks;
	}
	public void setEncounter_Id(String Encounter_Id){
		this.Encounter_Id=Encounter_Id;
	}
	public String getEncounter_Id(){
		return Encounter_Id;
	}

}
