package eDS.SupplementaryOrder.model;

public class PlaceSupplementaryMealOrderRequest {
	private String encounter_Id;
	private String patient_Id;
	private String locale;
	private String facility_Id;
	private String date;
	private String supplementaryMeal;
	private String str_client_ip_address,login_user;
	
	public void setEncounterId(String encounter_Id){
		this.encounter_Id=encounter_Id;
	}
	public String getEncounterId(){
		return encounter_Id;
	}
	
	public void setPatient_Id(String patient_Id){
		this.patient_Id=patient_Id;
	}
	public String getPatient_Id(){
		return patient_Id;
	}
	
	public void setLocale(String locale){
		this.locale=locale;
	}
	public String getLocale(){
		return locale;
	}
	
	public void setFacility_Id(String facility_Id){
		this.facility_Id=facility_Id;
	}
	public String getFacility_Id(){
		return facility_Id;
	}
	
	public void setDate(String date){
		this.date=date;
	}
	public String getDate(){
		return date;
	}
	
	public void setSupplementaryMeal(String supplementaryMeal){
		this.supplementaryMeal=supplementaryMeal;
	}
	
	public String getSupplementaryMeal(){
		return supplementaryMeal;
	}
	
	public void setStr_client_ip_address(String str_client_ip_address){
		this.str_client_ip_address=str_client_ip_address;
	}
	
	public String getStr_client_ip_address(){
		return str_client_ip_address; 
	}
	
	public void setLogin_user(String login_user){
		this.login_user=login_user;
	}
	
	public String getLogin_user(){
		return login_user;
	}
	
	public String toString(){
		return "PlaceSupplementaryMealOrderRequest ,encounter_Id->"+encounter_Id+",patient_Id->"+patient_Id+",supplementaryMeal->"+supplementaryMeal;
	}

}
