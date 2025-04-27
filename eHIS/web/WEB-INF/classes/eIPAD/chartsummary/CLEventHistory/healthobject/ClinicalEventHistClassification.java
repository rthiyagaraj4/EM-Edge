/**
 * 
 */
package eIPAD.chartsummary.CLEventHistory.healthobject;

/**
 * @author saraswathir
 *
 */
public enum ClinicalEventHistClassification {
	ADVERSE_EVENT("ALGY"),
	BLOOD_TRANSFUSION("BLTF"),
	CLINICAL_NOTE("CLNT"),
	PROBLEM_DIAGNOSIS("DIAG"),
	DIETARY("DIET"),
	DOCUMENT_IMAGING("DIMG"),
	FREE_DOCUMENTATION("FDOC"),
	FUTURE_EVENTS("FEVT"),
	LABORATORY("LBIN"),
	MEDICATION("MEDN"),
	NEWBORN_DETAIL("NBDT"),
	MONITORING("NCIN"),
	PATIENT_CARE("PTCR"),
	RADIOLOGY_IMAGING("RDIN"),
	DEPT_DIAGNOSTICS("RXIN"),
	SURGERY_PROCEDURE("SUNT"),
	TREATMENT_PROCEDURE("TRET");
	
	private final String code;
	
	ClinicalEventHistClassification(String code){
		this.code = code;
	}
	
	public String getCode() { return code; }
}
