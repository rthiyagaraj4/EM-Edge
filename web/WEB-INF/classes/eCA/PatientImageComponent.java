package eCA;
import java.io.Serializable;

public class PatientImageComponent  implements Serializable{
	private static final long serialVersionUID = -5302010108271068350L;

    String facility_Id;
    String encounter_Id;
    String patient_Id;
    int[][] imageData;

    public PatientImageComponent(String facilityID, String encounterID, String patientID, int[][] imgData){
        this.facility_Id = facilityID;
		this.encounter_Id = encounterID;
		this.patient_Id = patientID;
        this.imageData = imgData;
    }
    public String getFacilityId(){
        return this.facility_Id;
    }
	public String getEncounterId(){
        return this.encounter_Id;
    }
	public String getPatientId(){
        return this.patient_Id;
    }
    public int[][] getImageData(){
        return this.imageData;
    }
}
