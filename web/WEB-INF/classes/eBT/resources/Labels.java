package eBT.resources;

import java.util.*;

public class  Labels  extends ListResourceBundle{
	public Object[][] getContents() {
		return contents;
	}


	static final Object[][] contents = {		
		{"eBT.Antibody.label","Antibody"},
		{"eBT.LastReportedDate.label","Last Reported Date"},			
		{"eBT.VisittfrNo.label","Visit/tfr No"},		
		{"eBT.BloodType.label","Blood  Type"},
		{"eBT.Rhesus.label","Rhesus"},
		{"eBT.ReferralHospital.label","Referral Hospital"},
		{"eBT.ReferralPatientID.label","Referral PatientID"},
		{"eBT.RequestPerson.label","Request Person"},
		{"eBT.ReservedNotRequested.label","Reserved Not Requested"},
		{"eBT.ReservednotRequested.label","Reserved Not Requested"},
		{"eBT.ReservedRequested.label","Reserved already Requested"},
		{"eBT.ReservedandorRequested.label","Reserved and or Requested"},
		{"eBT.Transfused.label","Transfused"},
		{"eBT.UnitNo.label","Unit No"},
		{"eBT.Product.label","Product"},		
		{"eBT.Sel.label","Select"},
		{"eBT.CheckedPractioner.label","Check by Practitioner"},		
		{"eBT.Volume.label","Volume	UOM    Storage Location"},
		{"eBT.Code.label","Code"},				
		{"eBT.PartialTransfusionDesc.label","Partial Transfusion Reason &  Description"},	
		{"eBT.Adverse.label","Adverse"},
		{"eBT.SpecimenNo.label","Specimen No"},	
		{"eBT.PartialTransfusionReason.label","Partial Transfusion Reason"},
		{"eBT.RequestReprint.label","Request"},
		{"eBT.TransfusionDialog.label","Transfusion Dialog"},
		{"eBT.PatientAntibody.label","Patient Antibodies"},
		{"eBT.AutologusUnits.label","Autologous units"},
		{"eBT.DirectedUnits.label","Directed units"},
		{"eBT.TransfuseExpectDate.label","Transfuse ExpectDate"},
		{"eBT.ReservedDate.label","Reserved Date"},
		{"eBT.SpecregDate.label","Specimen Regd Date"},
		{"eBT.UnitsInEmergency.label","Units Issued in emergency"},
		{"eBT.TransfusionRemarks.label","Transfusion Remarks"},
		{"eBT.TransfuseByPractitioner.label","Transfuse by Practitioner"},
		{"eBT.startdatetime.label","Start Date Time"},
		{"eBT.CurrentVolume.label","Current Volume"},
		{"eBT.PreviousVolume.label","Previous Volume"},
		// added by Sanjay for 10.x conversion
		{"eBT.SampleID.label","Sample ID"},
		{"eBT.Anatomy.label","Anatomy"},
		{"eBT.TissueDescription.label","Tissue Description"},
		{"eBT.ImageLinks.label","Image Links"},
		{"eBT.UploadedDate.label","Uploaded Date"},
		// Below line added by Sanjay for ML-MMOH-CRF-0404 on 15-Oct-15
		//{"eBT.XMatchStatus.label","X-Match Status"}
		{"eBT.XMatchStatus.label","Cross Match Status"},
		{"eBT.ProdCodeDesc.label","Product Code/Description"},//Added by Ashwini on 20-Mar-2018 for MMS-DM-CRF-0137
		/*Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589*/
		{"eBT.Transfuse.label","Transfuse"},
		{"eBT.TransferBy.label","Transfer By"},
		{"eBT.Blood.label","Blood"},
		{"eBT.TransfusionTransferHistory.label","Transfusion / Transfer History"},
		{"eBT.ExternalTransfer.label","External Transfer"},
		 
		/*Added by Niveditha For GHL-CRF-0602.1*/
		{"eBT.LabDept.label","Lab Dept."},
		{"eBT.RegisteredDate.label","Registered Date"},
		{"eBT.RegisteredDateTo.label","To"},
		{"eBT.SpecimenNumber.label","Specimen Number"},
		{"eBT.OrderingFacility.label","Ordering Facility"},
		{"eBT.OrderingPractitioner.label","Ordering Practitioner"},
		{"eBT.LabOrderStatus.label","Lab. Order Status"},
		{"eBT.PerformingFacility.label","Performing Facility"},
		{"eBT.PatientID.label","Patient ID"},
		{"eBT.ReportingFacility.label","Reporting Facility"},
		{"eBT.AssignedPathologist.label","Assigned Pathologist"},
		{"eBT.AssignPathologist.label","Assign Pathologist"},
		{"eBT.Slno.label","S.No"},
		{"eBT.DateTime.label","Date/Time"},
		{"eBT.ViewRemark.label","View Remark"}
		
	};
}