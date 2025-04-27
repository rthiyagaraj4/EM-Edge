package eDS.SupplementaryOrder.model;

public class SupplementaryPlaceOrderRequest {
	private String Facility_Id;
	private String Nursing_Unit_Code;
	private String Locale;
	private String Admission_From_Date;
	private String Admission_To_Date;
	private String PatientId;
	private String EncounterId;
	private String PractionerId;
	private String Gender;
	private String Start_Num;
	private String End_Num;
	private String Grace_Period;
	private String Status;
	
	public void setFacility_Id(String Facility_Id){
		this.Facility_Id=Facility_Id;		
	}
	public String getFacility_Id(){
		return Facility_Id;		
	}
	
	public void setNursing_Unit_Code(String Nursing_Unit_Code){
		this.Nursing_Unit_Code=Nursing_Unit_Code;		
	}
	public String getNursing_Unit_Code(){
		return Nursing_Unit_Code;		
	}
	public void setLocale(String Locale){
		this.Locale=Locale;		
	}
	public String getLocale(){
		return Locale;		
	}
	public void setAdmission_From_Date(String Admission_From_Date){
		this.Admission_From_Date=Admission_From_Date;
	}
	public String getAdmission_From_Date(){
		return Admission_From_Date;
	}
	public void setAdmission_To_Date(String Admission_To_Date){
		this.Admission_To_Date=Admission_To_Date;
	}
	public String getAdmission_To_Date(){
		return Admission_To_Date;
	}
	public void setPatientId(String PatientId){
		this.PatientId=PatientId;
	}
	public String getPatientId(){
		return PatientId;
	}
	public void setEncounterId(String EncounterId){
		this.EncounterId=EncounterId;
	}
	public String getEncounterId(){
		return EncounterId;
	}
	public void setPractionerId(String PractionerId){
		this.PractionerId=PractionerId;
	}
	public String getPractionerId(){
		return PractionerId;
	}
	public void setGender(String Gender){
		this.Gender=Gender;
	}
	public String getGender(){
		return Gender;
	}
	public void setStart_Num(String Start_Num){
		this.Start_Num=Start_Num;
	}
	public String getStart_Num()
	{
		return Start_Num;
	}
	public void setEnd_Num(String End_Num){
		this.End_Num=End_Num;
	}
	public String getEnd_Num(){
		return End_Num;
	}
	public void setGrace_Period(String Grace_Period){
		this.Grace_Period=Grace_Period;
	}
	public String getGrace_Period()
	{
		return Grace_Period;
	}
	public void setStatus(String Status){
		this.Status=Status;
	}
	public String getStatus(){
		return Status;
	}
}
