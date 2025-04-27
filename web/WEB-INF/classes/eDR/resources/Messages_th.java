/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eDR.resources;

import java.util.*;

public class Messages_th extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = {		
		{"THREE_FIELD","APP-DR0001 ต้องเลือ�?อย่างน้อย 3 ฟิลด์"},
		{"CHECK_DAY_MONTH","APP-DR0002 �?ารตรวจสอบวันเดือนปีเสร็จสิ้น"},
		{"CHECK_MONTH_YEAR","APP-DR0003 �?ารตรวจสอบเดือนปีเสร็จสิ้น"},
		{"ATLEAT_ONE_NAME","APP-DR0004 ควรเลือ�?ส่วนประ�?อบของชื่ออย่างน้อย 1 อย่าง"},
		{"SEARCH_ACTIVE","APP-DR0005 ท่านได้ใช้ฟัง�?์ชั่นค้นหาอยู่�?ล้ว"},
		{"ONLY_TWO","APP-DR0006 เลือ�?ผู้ป่วยได้เพียง 2 คน"},
		{"TWO_PATIENTS","APP-DR0007 ควรเลือ�?ผู้ป่วยอย่างน้อย 2 คน"},
		{"TEN_PATIENTS","APP-DR0008 ไม่สามารถเรีย�?ดูผู้ป่วยเ�?ิน 10 คนได้ โปรดเลือ�?ผู้ป่วย 2 คนในตัวเลือ�?"},
		{"NO_RECORD","APP-DR0009 ไม่มีบันทึ�?ผู้ป่วย"},
		{"PATIENT_NOT_SELECTED","APP-DR0010 ไม่ได้เลือ�?บันทึ�?ผู้ป่วย"},
		{"CYCLE_IN_PROGRESS","APP-DR0011 วงจรอยู่ระหว่างดำเนิน�?าร"},
		{"NO_RECORD_AVAILABLE","APP-DR0012 ไม่มีบันทึ�?ในตาราง"},
		{"DR_PARAM_NOT_AVAILABLE","APP-DR0013 ยังไม่ได้ตั้งค่า DR"},
		{"ATLEAST_ONE_VALID","APP-DR0014 ควรเลือ�?หมายเลขประจำตัวผู้ป่วยอย่างน้อย 1 หมายเลข"},
		{"INVALID_DATETIME","APP-DR0015 รูป�?บบวัน�?ละเวลาไม่ถู�?ต้อง"},
		{"NON_DUPLICATES","APP-DR0016 พบหมายเลขประจำตัวผู้ป่วยซ้ำอยู่�?ล้ว"},
		{"PATIENT_POSSIBLE_DUPLICATES","APP-DR0017 พบหมายเลขประจำตัวผู้ป่วยที่อาจซ้ำอยู่�?ล้ว"},
		{"DUPLICATE_PATIENT_ENTRY","APP-DR0018 ข้อมูลผู้ป่วยซ้ำ"},
		{"START_LATER_TIME","APP-DR0019 วัน�?ละเวลาปัจจุบันต้องมา�?่อนวัน�?ละเวลาเริ่มภายหลัง"},
		{"ONLY_ONE_PAIR","APP-DR0020 เลือ�?เพียงบันทึ�?เดียวเท่านั้น"},
		{"CHANGE_ID_SERIES_NOT_ALLOWED","APP-DR0021 ไม่อนุ�?าตให้เปลี่ยน�?ปลงหมายเลขประจำตัวประชาชนหรือหมายเลขประจำตัวประชา�?รอื่น"},
		{"SHD_NOT_BE_BLANK","APP-DR0022 ต้องใส่หมายเลขประจำตัวผู้ป่วย"},
		{"ID_NO_NOT_BLANK","APP-DR0023 ต้องใส่หมายเลขประจำตัว"},
		{"DUPLICATE_ID_NO","APP-DR0024 มีหมายเลขประจำตัวนี้�?ล้ว"},
		{"RECORD_EXISTS","APP-DR0025 มีบันทึ�?นี้�?ล้ว"},
		{"SEARCH_MERGE_JOB_EXISTS","APP-DR0026 งานค้นหา/รวมอยู่ในคิวงาน�?ล้ว"},
		{"NO_USER_RIGHTS","APP-DR0027 ผู้ใช้ไม่มีสิทธิในฟัง�?์ชั่นนี้"},
		{"REMARKS_CANNOT_BE_BLANK","APP-DR0028 ต้องบันทึ�?หมายเหตุ"},
		{"DR_USER_ID_NOT_BLANK","APP-DR0029 ต้องใส่หมายเลขประจำตัวผู้ใช้"},
		{"MINIMUM_TWO_PATIENTS","APP-DR0030 ควรเลือ�?ผู้ป่วยอย่างน้อย 2 คน"},
		{"DECEASED_PATIENT","APP-DR0031 ผู้ป่วยเสียชีวิต"},
		{"DATE_TIME_NOT_BLANK","APP-DR0032 ต้องใส่วัน�?ละเวลา"},
		{"NO_SEARCH_PROCESS","APP-DR0033 ไม่มี�?ระบวน�?าร DR ที่�?ำลังดำเนิน�?ารอยู่"},
		{"NO_RECORDS_FOR_REVIEW","APP-DR0034 ไม่มีข้อมูลสำหรับพิจารณา"},
		{"NAME_MANDATORY","APP-DR0035 ต้องเลือ�?ส่วนประ�?อบชื่ออย่างน้อย 1 อย่างสำหรับเ�?ณฑ์นี้"},
		{"PATIENT_REGISTERED_FACILITY","APP-DR0036 ผู้ป่วยไม่ได้ลงทะเบียนในสถานพยาบาลนี้"},
		{"SEARCH_ALL_FACILITY","APP-DR0037 จะทำ�?ารค้นหาในทุ�?สถานพยาบาล"},
		{"SEARCH_PROCESS_JOB","APP-DR0038 ได้ส่ง�?ระบวน�?ารค้นหาเข้าสู่ระบบงาน�?ล้ว"},
		{"MERGE_PROCESS_JOB","APP-DR0039 ได้ส่ง�?ระบวน�?ารรวมเข้าสู่ระบบงาน�?ล้ว"},
		{"UNMERGE_PROCESS_JOB","APP-DR0040 ได้ส่ง�?ระบวน�?ารย�?เลิ�?�?ารรวมเข้าสู่ระบบงาน�?ล้ว"},
		{"IDSERIES_PROCESS_JOB","APP-DR0041 ได้ส่ง�?ระบวนเปลี่ยนหมายเลขประจำตัวประเภทผู้ป่วยเข้าสู่ระบบงาน�?ล้ว"},
		{"NO_USER_RIGHTS_ALL_FCY","APP-DR0042 ผู้ใช้ไม่มีสิทธิในฟัง�?์ชั่นนี้จา�?ทุ�?สถานพยาบาล"},
		{"ATLEAST_ONE_DUPLICATE","APP-DR0043 ควรเลือ�?หมายเลขประจำตัวผู้ป่วยที่ซ้ำอย่างน้อย 1 หมายเลข"},
		{"DR_PROCESS_CYCLE","APP-DR0044 �?ระบวน�?าร DR ได้ดำเนิน�?ารอยู่"},
		{"REMARKS_NOT_EXCEED_500_CH","APP-DR0045 ไม่สามารถบันทึ�?หมายเหตุได้เ�?ิน 500 ตัวอั�?ษร"},
		{"ID_MIN_LENGTH","APP-DR0046 หมายเลขประจำตัวต้องมีความยาวอย่างน้อย"},
		{"INVALID_PAT","APP-DR0047 หมายเลขประจำตัวผู้ป่วยไม่ถู�?ต้อง"},
		{"DELETE_RECORD","APP-DR0048 ท่านต้อง�?ารลบบันทึ�?นี้หรือไม่"},
		{"CANT_BE_LT","APP-DR0049 $ ต้องมา�?�?ว่า #"},
		{"NO_MERGED_PAT_REC","APP-DR0050 ไม่มีบันทึ�?�?ารรวมข้อมูลผู้ป่วย"},
		{"PATIENT_CUR_OUTPATIENT","APP-DR0051 ผู้ป่วยขณะนี้ เป็นผู้ป่วยนอ�?"},
		{"START_LATER_DATE_BLANK","APP-DR0052 ต้องระบุวันเวลาที่จะ�?ระทำภายหลัง"},
		{"ABORT_PROCESS","APP-DR0053 คุณต้อง�?ารจะยุติขั้นตอนหรือไม่"},
		{"NEXT_EXE_DATE_GRT_CUR_DATE","APP-DR0054 วันที่ลงทะเบียน"},
		{"ONE_MAIN_AND_ATLEAST_ONE_DUPLICATE","APP-DR0064 th_One main and atleast one duplicate patient id should be selected"},
		{"ONLY_ONE_INPATIENT","APP-DR0065 th_This patient is currently an inpatient. Cannot have more than one patient as inpatient for merging."},
		{"ATLEAST_ONE_VALID_EXISTS","APP-DR0066 th_Atleast one duplicate record should Exists. Cannot Proceed"},
		{"SELECT_MANDATORY_NAME","APP-DR0067 Atleast One of # Component should be selected as the criteria"}
	};			
}		  
