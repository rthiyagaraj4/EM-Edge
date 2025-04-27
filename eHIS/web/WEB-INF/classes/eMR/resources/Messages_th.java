/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR.resources;

import java.util.*;

public class Messages_th extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = {
		{"MR_INVALID_DIAG_CODE_FOR_PATIENT","APP-MR0001  รหัสโรคที่บันทึ�?ไม่เหมาะสม�?ับผู้ป่วย"},
		{"MRDATE1_GT_DATE2","APP-MR0002 $ มา�?�?ว่า # ไม่ได้"},
		{"MRDATE1_LT_DATE2","APP-MR0003 $ ต้องไม่น้อย�?ว่า #"},
		{"MRDATE1_GTR_DATE2","APP-MR0004 $ ควรมา�?�?ว่า #"},
		{"MR_VIEW_DTH_REG","APP-MR0005  ต้องเลือ�?เลขประจำตัวผู้ป่วย หรือ ช่วงเวลาที่ผู้ป่วยเสียชีวิต"},
		{"DIAG_REC0D_AUDIT","APP-MR0006  ต้องเลือ�?เลขประจำตัวผู้ป่วย หรือ ช่วงเวลาที่ผู้ป่วยมาพบ"},
		{"APPLY_NOT_VALID","APP-MR0007 ไม่สามารถ�?ระทำ�?ารได้"},
		{"APPT_NOT_GIVEN","APP-MR0008 ไม่สามารถเตรียมรายงาน�?ารรั�?ษาเนื่องจา�?ไม่ทราบข้อมูล�?ารนัดหมายผู้ป่วย"},
		{"SELECT_TWO_PRACT","APP-MR0009 ต้องเลือ�?�?พทย์อย่างน้อย 2 คน"},
		{"TERM_DESC_SHOULD_NOT_BE_BLANK","APP-MR0010 ต้องบันทึ�?คำบรรยาย"},
		{"MR_DIAG_DIFFGRP_CONFIRM","APP-MR0011 คุณต้อง�?าร�?ำหนดหรือสร้าง�?ลุ่ม�?ารวินิจฉัยโรคสำหรับ�?ารวินิจฉัยครั้งนี้"},
		{"MR_CONFIRM_PRINT","APP-MR0012 คุณต้อง�?ารพิมพ์รายงาน - # หรือไม่"},
		{"DUPLI_SRL_NO","APP-MR0013 สร้างเลขคำสั่งซ้ำไม่ได้"},
		{"DUP_SERIAL_NO","APP-MR0014 สร้างเลขประจำตัวซ้ำ"},
		{"END_DT_GR_START_DT","APP-MR0015 วันสิ้นสุดต้องมา�?�?ว่าหรือเท่า�?ับวันเริ่มต้น"},
		{"CANT_XCEED_250_CHARS","APP-MR0016 บันทึ�?ได้ไม่เ�?ิน 250 ตัวอั�?ษร"},
		{"CANT_XCEED_2000_CHARS","APP-MR0017 บันทึ�?เหตุ�?ารณ์ได้ไม่เ�?ิน 2000 ตัวอั�?ษร "},
		{"EVENT_START_GREATER_DOB","APP-MR0018 วันที่เริ่มเ�?ิดเหตุต้องมา�?�?ว่าวันเ�?ิดของผู้ป่วย"},
		{"EVENT_START_LESS_SYSDATE","APP-MR0019 วันที่เริ่มเ�?ิดเหตุต้องน้อย�?ว่าหรือเท่า�?ับวันปัจจุบัน"},
		{"FILE_DOESNOT_EXIST","APP-MR0020 ไม่พบ�?ฟ้มประวัติผู้ป่วยรายนี้"},
		{"FILE_ALREADY_CREATED_FCY","APP-MR0021 ผู้ป่วยมี�?ฟ้มประวัติของสถานพยาบาลนี้�?ล้ว"},
		{"GROUP_NAME_LENGTH","APP-MR0022 ความยาวชื่อต้องไม่มา�?�?ว่า # ตัวอั�?ษร"},
		{"HIGHER_LVL_SEL","APP-MR0023 ต้องเลือ�?ระดับที่ต่ำ�?ว่า"},
		{"INVALID_SRL_NO","APP-MR0024 เลขคำสั่งไม่ถู�?ต้อง"},
		{"MASTER_SELECT","APP-MR0025 ต้องเลือ�?ตัวควบคุม"},
		{"ALREADY_EXIST_MBOARD","APP-MR0026 ไม่สามารถดำเนิน�?ารเนื่องจา�?ประเภทของคณะ�?รรม�?าร�?พทย์เ�?ี่ยวข้อง�?ับคณะ�?รรม�?าร�?พทย์"},
		{"NOTE_DOESNOT_EXIST_CANT_PROCEED","APP-MR0027 ดำเนิน�?ารต่อไปไม่ได้เพราะไม่มีรายงานของผู้ป่วย "},
		{"NOTE_DOESNOT_EXIST","APP-MR0028 �?สดงรายงาน�?ารรั�?ษาไม่ได้เนื่องจา�?ไม่มีรายงานของผู้ป่วย "},
		{"CONT_MRTHN_ONE_CHIEF","APP-MR0029 หัวหน้างานมีมา�?�?ว่าหนึ่งคนไม่ได้"},
		{"MR_EOC_MULT_NOT_ALLOWED","APP-MR0030 เลือ�?หลายราย�?ารไม่ได้"},
		{"ONLY_TEN_SEL_ALLOWED","APP-MR0031 เลือ�?ได้เพียง 10 หัวข้อเท่านั้น"},
		{"INVALID_SERIAL_NO","APP-MR0032 ค่าเลขคำสั่งต้องมา�?�?ว่าศูนย์"},
		{"PATIENT_NOT_REGISTERED","APP-MR0033 ดำเนิน�?ารต่อไปไม่ได้เนื่องจา�?ผู้ป่วยไม่ได้ลงทะเบียน�?ับสถานพยาบาล"},
		{"PAYMENT_NOT_COMPLETE","APP-MR0034 รายละเอียด�?ารชำระเงินยังไม่ครบ"},
		{"MR_PRY_CONT_MRT_ONE","APP-MR0035 มีได้�?ค่�?ารวินิจฉัยเบื้องต้นเดียว"},
		{"MR_INCLUDE_DIG","APP-MR0036 ช่วยรวม�?ารวินิจฉัยโรค"},
		{"MR_EX_SELECT_ONE_DIAG","APP-MR0037 เลือ�?อย่างน้อยหนึ่ง�?ารวินิจฉัยโรค"},
		{"MR_DIAG_DIFF_GROUP","APP-MR0038 โปรดเลือ�?ในช่องที่ให้เลือ�?"},
		{"RANGE_LENGTH","APP-MR0039 ความยาวของ Range ต้องไม่มา�?�?ว่า 200 ตัวอั�?ษร"},
		{"REF_DATE_GREATER_DOB","APP-MR0040 ันที่อ้างอิงต้องมา�?�?ว่าวันเ�?ิดของผู้ป่วย"},
		{"REF_DATE_LESS_SYSDATE","APP-MR0041 วันที่อ้างอิงต้องน้อย�?ว่าหรือเท่า�?ับวันนี้"},
		{"REMARKS_XCEED_2000_CHARS","APP-MR0042 ข้อสังเ�?ตต้องไม่เ�?ิน 2000 ตัวอั�?ษร"},
		{"REQUEST_ALREADY_MADE","APP-MR0043 มีสิ่งที่ขอ�?ล้ว ขออี�?ไม่ได้"},
		{"REQ_REAL_IS_MANDATORY","APP-MR0044 ต้องเลือ�?ผู้ขอหรือความสัมพันธ์"},
		{"REQ_DOCS_CANT_XCEED_100_CHARS","APP-MR0045 เอ�?สารที่ต้อง�?ารต้องไม่เ�?ิน 100 ตัวอั�?ษร"},
		{"SERIAL_NO_NOT_BLANK","APP-MR0046 ต้องบันทึ�?เลขประจำตัว"},
		{"STAT_DT_BT_ONSET_AND_CURR","APP-MR0047 Status date ควรอยู่ระหว่าง Onset date �?ละ Current date"},
		{"TERM_CODE_SHOULD_NOT_BE_BLANK","APP-MR0048  ต้องบันทึ�?รหัสศัพท์"},
		{"TERM_CODE_LEVEL_1_IS_MANDATORY","APP-MR0049 ต้องลงรหัสศัพท์ในระดับที่หนึ่ง"},
		{"TERM_SET_SHOULD_NOT_BE_BLANK","APP-MR0050 ต้องบันทึ�?ชุดของคำศัพท์"},
		{"MR_REC_DIAG_NO_EXIT_GRP","APP-MR0051 ไม่มี�?ลุ่ม�?ารวินิจฉัยโรคอื่นอยู่"},
		{"MR_DIAG_CURR_ACTIVE","APP-MR0052 คุณไม่สามารถปรับปรุง�?�?้ไข/ลบ/ข้อผิดพลาด�?ารวินิจฉัยโรค"}
		
     };
}
