package eDS.SupplementaryOrder.model;

public class SupplementaryPlaceOrderResult {
	private String Patient_Id;
	private String Patient_Name;
	private String Encounter_Id;
	private String Visit_Adm_Date;
	private String Sex;
	private String DOB;
	private String Assign_Care_Locn_Type;
	private String Assign_Care_Locn_code;
	private String Short_Desc;
	private String Assign_Room_Num;
	private String Assign_Bed_Num;
	private String Patient_Class;
	private String Discharge_Date_Time;
	private String ADT_Status;
	private String Total_Record;
	private String Color_Code;
	//Added Against Start PMG2017-CRF-0012[IN:066074]
	private String Patient_Age; 

	public void setPatient_Age(String Patient_Age){ 
		this.Patient_Age=Patient_Age;
	}
	public String getPatient_Age(){
		return Patient_Age;
	}
	//Added Against End PMG2017-CRF-0012[IN:066074]

	public void setPatient_Id(String Patient_Id){
		this.Patient_Id=Patient_Id;
		
	}
	public void setPatient_Name(String Patient_Name){
		this.Patient_Name=Patient_Name;		
	}
	public void setEncounter_Id(String Encounter_Id){
		this.Encounter_Id=Encounter_Id;
	}
	public void setVisit_Adm_Date(String Visit_Adm_Date){
		this.Visit_Adm_Date=Visit_Adm_Date;
	}
	public void setSex(String Sex){
		this.Sex=Sex;
	}
	public void setDOB(String DOB){
		this.DOB=DOB;
		
	}
	public void setAssign_Care_Locn_Type(String Assign_Care_Locn_Type){
		this.Assign_Care_Locn_Type=Assign_Care_Locn_Type;
	}
	public void setAssign_Care_Locn_code(String Assign_Care_Locn_code){
		this.Assign_Care_Locn_code=Assign_Care_Locn_code;
	}
	public void setShort_Desc(String Short_Desc){
		this.Short_Desc =Short_Desc;
	}
	public void setAssign_Room_Num(String Assign_Room_Num){
		this.Assign_Room_Num =Assign_Room_Num;
	}
	public void setAssign_Bed_Num(String Assign_Bed_Num){
		this.Assign_Bed_Num =Assign_Bed_Num;
	}
	public void setPatient_Class(String Patient_Class){
		this.Patient_Class =Patient_Class;
	}
	public void setDischarge_Date_Time(String Discharge_Date_Time){
		this.Discharge_Date_Time =Discharge_Date_Time;
	}
	public void setADT_Status(String ADT_Status){
		this.ADT_Status =ADT_Status;
	}
	public void setColor_Code(String Color_Code){
		this.Color_Code=Color_Code;
	}
	
	
	public String getPatient_Id(){
		return Patient_Id;
		
	}
	public String getPatient_Name(){
		return Patient_Name;		
	}
	public String getEncounter_Id(){
		return Encounter_Id;
	}
	public String getVisit_Adm_Date(){
		return Visit_Adm_Date;
	}
	public String getSex(){
		return Sex;
	}
	public String getDOB(){
		return DOB;
		
	}
	public String getAssign_Care_Locn_Type(){
		return Assign_Care_Locn_Type;
	}
	public String getAssign_Care_Locn_code(){
		return Assign_Care_Locn_code;
	}
	public String getShort_Desc(){
		return Short_Desc;
	}
	public String getAssign_Room_Num(){
		return Assign_Room_Num;
	}
	public String getAssign_Bed_Num(){
		return Assign_Bed_Num;
	}
	public String getPatient_Class(){
		return Patient_Class;
	}
	public String getDischarge_Date_Time(){
		return Discharge_Date_Time;
	}
	public String getADT_Status(){
		return ADT_Status;
	}
	
	public void setTotal_Record(String Total_Record){
		this.Total_Record=Total_Record;
	}
	public String getTotal_Record(){
		return Total_Record;
	}
	public String getColor_Code(){
		return Color_Code;
	}	
}
