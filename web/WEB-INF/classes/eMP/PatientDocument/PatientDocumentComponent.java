package eMP.PatientDocument;
import java.util.List;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.Serializable;


public class PatientDocumentComponent  implements Serializable{
	private static final long serialVersionUID = -5302010108271068350L;

    String facility_Id;
    String encounter_Id;
    String patient_Id;
    ArrayList<byte[]> scannedImagesList;

	String document_Id;
    String docMainType;
    String docType;

    public PatientDocumentComponent(String facilityID, String encounterID, String patientID, ArrayList<byte[]> imgList){
        this.facility_Id = facilityID;
		this.encounter_Id = encounterID;
		this.patient_Id = patientID;
        this.scannedImagesList = imgList;
    }

	public PatientDocumentComponent(String facilityID, String encounterID, String patientID, String documentId, String docMainType, String docType, ArrayList<byte[]> imgList){
        this.facility_Id = facilityID;
		this.encounter_Id = encounterID;
		this.patient_Id = patientID;
		this.document_Id = documentId;
		this.docMainType = docMainType;
		this.docType = docType;
        this.scannedImagesList = imgList;
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
    public ArrayList getImageData(){
        return this.scannedImagesList;
    }

	public String getDocumentId(){
        return this.document_Id;
    }
	public String getDocMainType(){
        return this.docMainType;
    }
	public String getDocType(){
        return this.docType;
    }   
}
