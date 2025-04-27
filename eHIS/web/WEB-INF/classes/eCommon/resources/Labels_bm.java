/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
  /*File created by Dharma against ML-MMOH-CRF-0717 [IN:062396] on 12th July 2018*/
package eCommon.resources;

import java.util.*;

public class  Labels_bm  extends ListResourceBundle implements java.io.Serializable{
	public Object[][] getContents() {
         return contents;
    }

	static final Object[][] contents = {
				/*Medical Report Request Search/Result Start*/
				{"Common.Request.label","Permohonan"},
				{"Common.OtherAltType.label","Lain-lain Pengenalan Diri"},
				{"Common.otheraltid.label","Pengenalan Diri Lain"},
				{"Common.patientId.label","ID Pesakit"},
				{"Common.orderBy.label","Susunatur Mengikut"},
				{"Common.search.label","Carian"},
				{"Common.clear.label","Padam"},
				{"Common.defaultSelect.label","Pilih"},
				{"Common.encounterdate.label","Tarikh Kedatangan"},
				{"Common.Location.label","Lokasi"},
				{"Common.speciality.label","Disiplin"},
	     		{"Common.Specialty.label","Disiplin"},
				{"Common.room.label","Bilik"},
				{"Common.Bed.label","Katil"},
				{"Common.practitioner.label","Doktor"},
				/*Medical Report Request Search/Result End*/
				/*Medical Report Encounter Details Start*/
				{"Common.facility.label","Fasiliti"},
				{"Common.dischargedatetime.label","Tarikh/Masa Discaj"},
				{"Common.admissiontype.label","Jenis Kemasukan"},
				{"Common.service.label","Perkhidmatan"},
				{"Common.episodeid.label","ID Episod"},
				{"Common.referraldetails.label","Maklumat Rujukan"},
				{"Common.staydetails.label","Maklumat Kemasukan"},
				{"Common.date.label","Tarikh"},
				{"Common.nursingUnit.label","Unit Rawatan"}, 
				{"Common.roomno.label","No Bilik"},
				{"Common.bedno.label","No Katil"},
				{"Common.remarks.label","Catatan"},
				/*Medical Report Encounter Details End*/
				{"Common.MedicalReportRequest.label","Daftar Permohonan Laporan Perubatan"},
				{"Common.regndatetime.label","Tarikh/Masa Pendaftaran"},
				{"Common.referenceno.label","No Rujukan"},
				{"Common.ApplicationCategory.label","Kategori Permohonan"},
				{"Common.relationship.label","Hubungan"},
				{"Common.RelationshipType.label","Jenis Pemohon"},
				{"Common.Requestor.label","Pemohon"},
				{"Common.Charges.label","Bayaran"},
				{"Common.amount.label","Jumlah"},
				{"Common.receiptno.label","No Resit"},
				{"Common.receiptdate.label","Tarikh Resit"},
				{"Common.record.label","Simpan"},
				{"Common.close.label","Tutup"},
				{"Common.ApplicationMode.label","Kaedah Permohonan"},
				{"Common.CollectionMode.label","Kaedah Pengambilan"},
				{"Common.NotificationMode.label","Kaedah Pemberitahuan"},
				{"Common.ContactDetails.label","Maklumat Untuk Dihubungi"},
				{"Common.country.label","Negara"},
				{"Common.email.label","Emel"},
				{"Common.RequestDateFrom.label","Tarikh Permohonan"},
				{"Common.cancelledby.label","Dibatalkan Oleh"},
				{"Common.CancelledOn.label","Dibatalkan Pada"},
				{"Common.ReasonforCancellation.label","Sebab Pembatalan"},
				{"Common.RequestDate.label","Tarikh Dipohon"},
				{"Common.PrepareDate.label","Tarikh Disediakan Laporan oleh Dr"},
				{"Common.ReceivedDate.label","Tarikh Terima Laporan Siap"},
				{"Common.ChargeDetails.label","Maklumat Bayaran"},
				{"Common.PaymentDetails.label","Maklumat Pembayaran"},
				{"Common.receiptno.label","No Resit"},
				{"Common.additionaldetails.label","Maklumat Tambahan"},
				{"Common.reporttype.label","Jenis Laporan"},
				{"Common.authorizedby.label","Disahkan Oleh"},
				{"Common.CancelRequest.label","Batal Permohonan"},
				{"Common.ReceivedBy.label","Laporan Diterima oleh"},
				{"Common.telephone.label","Telefon"},
				{"Common.PatientName.label","Nama Pesakit"},
				{"Common.dischargedate.label","Tarikh/Masa Discaj"},
				{"Common.Requested.label","Permohonan Baru"},
				{"Common.cancelled.label","Permohonan Batal"},
				{"Common.statusincomplete.label","Permohonan Tidak Lengkap"},
				{"Common.AcceptedRequest.label","Terima Permohonan oleh HOD/Penyelaras"},
				{"Common.Rejectedreport.label","Laporan Ditolak oleh MRD"},
				{"Common.RejectedRequest.label","Penyelaras Tolak Permohonan oleh HOD/Penyelaras"},
				{"Common.NotDelivered.label","Laporan Belum Diserah kepada Pemohon"},
				{"Common.Overdue.label","Melebihi Tempoh"},
				{"Common.all.label","Semua Transaksi"},
				{"Common.Accept.label","Terima"},
				{"Common.Reject.label","Ditolak"},
				{"Common.AcceptDateTime.label","Tarikh Terima/Masa"},
				{"Common.RejectDateTime.label","Tarikh/Masa Tolak"},
				{"Common.ReasonforRejection.label","Sebab Ditolak"},
				{"Common.gender.label","Jantina"},
				{"Common.PatientDetails.label","Maklumat Pesakit"},
				{"Common.female.label","Perempuan"},
				{"Common.male.label","Lelaki"},
				{"Common.registrationno.label","No Pendaftaran"},
				{"Common.complete.label","Lengkap"},
				{"Common.incomplete.label","Tidak Lengkap"},
				{"Common.searchtext.label","Carian Teks"}, 
				{"Common.searchby.label","Carian Dari"}, 
				{"Common.code.label","Kod"},
				{"Common.description.label","Keterangan"},
				{"Common.SearchCriteria.label","Jenis Carian"},
				{"Common.cancel.label","Batal"}
	};      
}
