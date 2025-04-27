package eMP.PatientPhoto;

import java.io.Serializable;

public class PatientPhotoComponent  implements Serializable {

	private static final long serialVersionUID = -5302010108271068350L;

    String patient_Id;
    int[][] imageData;
	String module_Id;
	String facility_id;
	String user_id;
	String ws_no;
	String locale;

    public PatientPhotoComponent(String patientID, int[][] imgData, String moduleID){
		this.patient_Id = patientID;
        this.imageData = imgData;
		this.module_Id = moduleID;
    }

	public PatientPhotoComponent(String patientID, int[][] imgData, String moduleID , String facilityid, String userid, String wsno, String locale ){
		this.patient_Id = patientID;
        this.imageData = imgData;
		this.module_Id = moduleID;
		this.facility_id = facilityid;
		this.user_id = userid;
		this.ws_no = wsno;
		this.locale = locale;
    }
 
 
	public String getPatientId(){
        return this.patient_Id;
    }
    public int[][] getImageData(){
        return this.imageData;
    }
	public String getModuleId(){
        return this.module_Id;
    }
	public String getFacilityId(){
        return this.facility_id;
    }
	public String getUserId(){
        return this.user_id;
    }
	public String getWsnoId(){
        return this.ws_no;
    }
	public String getlocale(){
        return this.locale;
    }
}
