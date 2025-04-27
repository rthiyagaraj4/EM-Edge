package eDS.SupplementaryOrder.model;

public class SupplementaryProcessRequest {
	private String locale;
	private String facility_id;
	private String date;
	private String patient_id;
	private String kitchen;
	private String nursing_unit;
	private String Supplementary_order_for;
	private String setStatusForAllPatient;
	private String start_num;
	private String end_num;
	private String gracePeriod;
	private String str_client_ip_address,login_user;
	
	private String processSupplementaryMealArray;//This variable is required only on click of apply
	
	public void setLocale(String locale){
		this.locale=locale;		
	}
	public String getLocale(){
		return locale;
	}
	public void setFacilityId(String facility_id){
		this.facility_id=facility_id;
	}
	public String getFaciltyId(){
		return facility_id;
	}
	public void setDate(String date){
		this.date=date;		
	}
	public String getDate(){
		return date;
	}
	public void setPatientId(String patient_id){
		this.patient_id=patient_id;
	}
	public String getPatientId(){
		return patient_id;
	}
	public void setKitchen(String kitchen){
		this.kitchen=kitchen;
	}
	public String getKitchen(){
		return kitchen;
	}
	public void setNursingUnit(String nursing_unit){
		this.nursing_unit=nursing_unit;
	}
	public String getNursingUnit(){
		return nursing_unit;
	}
	public void setSupplementaryOrderFor(String Supplementary_order_for){
		this.Supplementary_order_for=Supplementary_order_for;
	}
	public String getSupplementaryOrderFor(){
		return Supplementary_order_for;
	}
	public void setStatusForAllPatient(String setStatusForAllPatient){
		this.setStatusForAllPatient=setStatusForAllPatient;
	}
	public String getSetStatusForAllPatient(){
		return setStatusForAllPatient;
	}
	public void setStartNum(String start_num){
		this.start_num=start_num;
	}
	public String getStartNum()
	{
		return start_num;
	}
	
	public void setEndNum(String end_num){
		this.end_num=end_num;
	}
	public String getEndNum(){
		return end_num;
	}
	public void setGracePeriod(String gracePeriod){
		this.gracePeriod=gracePeriod;
	}
	public String getGracePeriod(){
		return gracePeriod;
	}
	public void setProcessSupplementaryMealArray(String processSupplementaryMealArray){
		this.processSupplementaryMealArray=processSupplementaryMealArray;
	}
	public String getProcessSupplementaryMealArray(){
		return processSupplementaryMealArray;
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

}
