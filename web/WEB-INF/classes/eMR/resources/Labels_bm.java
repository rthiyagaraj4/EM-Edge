/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
  /*File created by Dharma against ML-MMOH-CRF-0717 [IN:062396] on 12th July 2018*/
package eMR.resources;

import java.util.*;

public class  Labels_bm  extends ListResourceBundle implements java.io.Serializable{
	public Object[][] getContents() {
         return contents;
    }


	static final Object[][] contents = {
			{"eMR.EncPeriod.label","Encounter Period"},
			{"eMR.PrevDelMedReport.label","Senarai Permohonan Terdahulu"},
			{"eMR.MedicalReport.label","Daftar Permohonan Baru"},
			{"eMR.ApplicantInformation.label","Maklumat Pemohon"},
			{"eMR.ApplicationType.label","Jenis Permohonan"},
			{"eMR.LetterDateTime.label","Tarikh/Masa Surat"},
			{"eMR.ApplicantName.label","Nama Pemohon"},
			{"eMR.RequestorType.label","Jenis Pemohon"},
			{"eMR.ConsentLetter.label","Surat Kebenaran"},
			{"eMR.Attentionto.label","Perhatian kepada"},
			{"eMR.ApplicationNo.label","No Permohonan"},
			{"eMR.CheckList.label","Senarai Semak"},
			{"eMR.ApplicantAddress.label","Alamat Pemohon"},
			{"eMR.ChargesApplicable.label","Bayaran Yang Dikenakan"}, 
			{"eMR.AdditionalCharges.label","Bayaran Tambahan"},
			{"eMR.CheckListDetails.label","Maklumat senarai semak"},
			{"eMR.PaymentAutolinkFromBilling.label","Bayaran (pautan auto dari bil)"},
			{"eMR.ContactNumber.label","Nombor Telefon"},
			{"eMR.MedicalReportStatus.label","Status Laporan Perubatan"},
			{"eMR.ApplicationStatus.label","Status Permohonan"},
			{"eMR.CollectDate.label","Tarikh Ambilan"},
			{"eMR.RequestedPractitioner.label","Doktor yang Diminta"},
			{"eMR.RequiredDocuments.label","Dokumen yang Diperlukan"},
			{"eMR.ApplicationCompletionDates.label","Tarikh Permohonan Lengkap"},
			{"eMR.DateDetails.label","Maklumat Permohonan"},
			{"eMR.DeliveredDate.label","Tarikh Laporan Diserahkan kepada Pemohon"},
			//{"eMR.ChargesApplicable.label","Jenis Bayaran"},//commented since duplicate entries are there
			{"eMR.AdditionalReceiptNo.label","No Resit Tambahan"},
			{"eMR.AdditionalAmount.label","Jumlah Tambahan"},
			{"eMR.AdditionalReceiptDate.label","Tarikh Resit Tambahan"},
			{"eMR.DepartmentSpecialty.label","Jabatan/Disiplin"},
			{"eMR.ForwardedHOD.label","Dihantar kepada HOD/Peg. Penyelaras"},	
			{"eMR.InformToHOD.label","Maklumkan kepada HOD/Peg. Penyelaras"},	
			{"eMR.ForwardedHODDate.label","Tarikh dihantar ke HOD/Peg. Penyelaras"},	
			{"eMR.AcknowledgedByHODCoordinator.label","Perakuan Oleh HOD/Peg. Penyelaras"},
			{"eMR.RejectedBy.label","Laporan Ditolak oleh"},
			{"eMR.DaystoComplete.label","Bilangan Hari Laporan Siap"},
			{"eMR.DeliverDispatchMode.label","Kaedah Serahan Laporan"},
			{"eMR.DatePosted.label","Tarikh Pos"},
			{"eMR.SectionFileNo.label","Seksyen/No Fail"},
			{"eMR.ReportTakenBy.label","Nama Pengambil"},
			{"eMR.DeliveryDispatchAdd.label","Ambil/Pos Semula"},
			{"eMR.StatusCompleted.label","Permohonan Lengkap"},
			{"eMR.ForwardedtoHOD.label","Dihantar kepada HOD/Penyelaras/Doktor"},
			{"eMR.ForwardedtoPractitioner.label","Dimajukan ke Doktor"},
			{"eMR.PreparedbyPractitioner.label","Laporan Disediakan oleh Doktor"},
			{"eMR.ReceivedbyMedicalRecord.label","Laporan Diterima oleh MRD"},
			{"eMR.ReportDelivered.label","Laporan Telah Siap"},
			{"eMR.ChargesDetails.label","Maklumat Bayaran"},
			{"eMR.OurReferenceNo.label","Ruj Kami"},//Added By Dharma on 28/11/2019 against  ML-MMOH-CRF-1360
			/*Added by Dharma on 19th Dec 2019 against ML-MMOH-CRF-0717.1 Start*/
			{"eMR.SelfPrepare.label","Penyediaan Sendiri"},
			{"eMR.InformToPractitioner.label","Maklumkan kepada Doktor"},
			{"eMR.ReasonforReturn.label","Sebab Dikembalikan"},
			{"eMR.RejectedOn.label","Ditolak Pada"},
			{"eMR.CompletedApplication.label","Permohonan Lengkap"},
			{"eMR.ForwardedtoHOD_Coordinator.label","Dihantar ke HOD/Peg. Penyelaras/Doktor Diminta"},
			{"eMR.AcceptedbyPractitioner.label","Penerimaan Oleh Doktor"},
			{"eMR.RejectedbyPractitionertoMRD.label","Ditolak ke MRD oleh Doktor"},
			{"eMR.RejectedbyPractitionertoHOD.label","Dipulangkan ke HOD/Peg. Penyelaras oleh Doktor"},
			{"eMR.RequestID.label","ID Permohonan"},
			{"eMR.RequestOrReportStatus.label","Status Laporan"},
			{"eMR.CancelledOrRejectedStatus.label","Permohonan Batal/Catatan"},
			{"eMR.CancelledApplication.label","Permohonan Batal"},
			{"eMR.MedicalRecordTask.label","Tugasan Jabatan Rekod"},
			{"eMR.HODCoordinatorTask.label","Tugasan HOD/Peg.Pnyelaras"},
			{"eMR.PractitionerTask.label","Tugasan Doktor"},
			{"eMR.MRDRemarks.label","Catatan Jabatan Rekod"},
			{"eMR.RevisedCollectDate.label","Semakan Tarikh Ambilan"},
			{"eMR.ForwardedDate.label","Tarikh Dihantar"},
			{"eMR.PendingAssgnPract.label","Tugasan Lewat Kepada Doktor"},
			{"eMR.ForwardedPractitioner.label","Dihantar kepada Doktor"},
			{"eMR.OverduebyPractitioner.label","Kelewatan oleh Doktor"},
			{"eMR.AssignReAssignPractitioner.label","Ditugaskan/Ditugaskan Semula Kepada Doktor"},
			{"eMR.PractitionerAssignedDate.label","Tarikh/Masa Doktor Terima"},
			{"eMR.HODCoordinatorRemarks.label","Catatan HOD/Peg. Penyelaras"},
			{"eMR.ReportPreparedDate.label","Tarikh Penyedian Laporan"},
			{"eMR.ViewMedicalReport.label","Papar Laporan Perubatan"},
			{"eMR.SubmitMedicalReport.label","Hantar Laporan Perubatan"},
			{"eMR.DeliveryMode.label","Cara Penghantaran"},
			{"eMR.PostageNo.label","No Pos"},
			{"eMR.ModificationRequired.label","Pindaan Diperlukan"},
			{"eMR.AcceptedbyHOD.label","Diterima oleh HOD/Peg. Penyelaras"},
			{"eMR.RejectedbyHOD.label","Ditolak oleh HOD/Peg. Penyelaras"},
			{"eMR.PractitionerRemarks.label","Catatan Doktor"}
			

	};
}


