/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCommon.resources;

import java.util.*;

public class Messages_th extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = {
		{"CAN_NOT_BE_BLANK","APP-000001 ต้องบันทึ�? $"},
		{"REMARKS_CANNOT_EXCEED","APP-000002 $ ต้องไม่เ�?ิน # ตัวอั�?ษร"},
		{"REMARKS_MUST_BE_GREATER","APP-000003 $ ต้องมีค่ามา�?�?ว่า # ตัวอั�?ษร"},
		{"REMARKS_MUST_GR_EQUAL","APP-000004 $ ควรมีค่ามา�?�?ว่า หรือ เท่า�?ับ จา�? #"},
		{"SHOULD_NOT_BE_BLANK","APP-000005 ต้องบันทึ�? {1} "},
		{"NEG_AGE_CHECK","APP-000006 อายุไม่ควรเป็นศูนย์ หรือเป็นลบ"},
		{"ANY_ONE_CRITERIA","APP-000007 ควรระบุอย่างน้อยหนึ่ง�?�?เ�?ณฑ์"},
		{"ATLEAST_ONE_RECORD_ENTERED","APP-000008 ต้องบันทึ�?อย่างน้อยหนึ่งข้อมูล"},
		{"ATLEAST_ONE_SELECTED","APP-000009 ต้องเลือ�?อย่างน้อยหนึ่งข้อมูล"},
		{"ATLEAST_ONE_REP_SELECT","APP-000010 ต้องเลือ�?อย่างน้อยหนึ่งรายงาน"},
		{"BASE_SLOT_TIME_FOR_ZERO","APP-000011 Base/slot time สำหรับคลินิ�?นี้ต้องไม่มีค่าเป็นศูนย์"},
		{"CA_NOT_INSTALLED","APP-000012 CA module ไม่ได้ถู�?ติดตั้งไว้"},
		{"CANNOT_BE_ZERO","APP-000013 ไม่สามารถเป็นศูนย์"},
		{"CANNOT_BE_SPECIAL_CHAR","APP-000014 ไม่สามารถใช้ตัวอั�?ษรพิเศษได้"},
		{"NO_CLINICS_FOR_USER","APP-000015 ไม่ได้เลือ�?คลินิ�? ไม่สามารถดำเนิน�?ารต่อได้"},
		{"DATE_NOT_GREATER_SYSDATE","APP-000016 วันที่ต้องมา�?่อนวันที่ของระบบ"},
		{"START_DATE_GREATER_SYSDATE","APP-000017 วันที่ต้องเป็นวันหลังจา�?วันที่ของระบบ"},
		{"DOB_CHECK","APP-000018 วันที่เ�?ิดต้องมา�?่อนวันที่ปัจจุบัน"},
		{"DAYS_CHECK","APP-000019 จำนวนวันไม่ควรเ�?ิน 31 วัน"},
		{"CONTINUE_REFERRAL","APP-000020 ต้อง�?ารดำเนิน�?ารลงทะเบียน�?ารส่งต่อผู้ป่วยต่อไปหรือไม่?"},
		{"REG_REFERRAL","APP-000021 ต้อง�?ารลงทะเบียน�?ารส่งตัวของผู้ป่วยรายนี้หรือไม่?"},
		{"DELETE_RECORD","APP-000022 ต้อง�?ารลบข้อมูลนี้หรือไม่?"},
		{"PRINT_CONFIRM","APP-000023 ท่านต้อง�?ารพิมพ์ # หรือไม่ ?"},
		{"REGISTER_REFERRAL_YN","APP-000024 ต้อง�?ารลงทะเบียน�?ารส่งตัวหรือไม่ ?"},
		{"APPT_REPRINT","APP-000025 ต้อง�?ารพิมพ์จดหมายส่งตัวอี�?หรือไม่?"},
		{"REFLETTER_REPRINT","APP-000026 ต้อง�?ารพิมพ์จดหมายส่งตัวอี�?หรือไม่?"},
		{"UPDATE_PAT_VAL","APP-000027 ต้อง�?ารปรับปรุงข้อมูลทรัพย์สินของผู้ป่วยหรือไม่ ?"},
		{"DUPLICATE_CODE_EXISTS","APP-000028 ไม่สามารถคัดลอ�?รหัสซ้ำได้"},
		{"DR_NOT_INSTALLED","APP-000029 ไม่ได้ติดตั้ง Duplicate Registration Check (DR) module"},
		{"RECORD_ALREADY_EXISTS","APP-000030 ไม่สามารถคัดลอ�?ซ้ำได้"},
		{"WELCOME","APP-000031 ยินดีต้อนรับสู่ระบบ eHIS"},
		{"EMER_CLINIC_NOT_ALLOWED","APP-000032 ไม่อนุ�?าตให้ลงทะเบียนที่คลินิ�?ฉุ�?เฉิน"},
		{"ENC_ID_REACHED_MAX","APP-000033 หมายเลข�?ารเข้าพบ�?พทย์เต็ม�?ล้ว"},
		{"INVALID_MAX_NUMBER","APP-000034 บันทึ�?จำนวนสูงสุดที่ถู�?ต้อง"},
		{"INVALID_NEXT_NUMBER","APP-000035 บันทึ�?จำนวนถัดไปที่ถู�?ต้อง ซึ่งควรมา�?�?ว่าศูนย์"},
		{"FIT_FOR_DUTY_GR_END_DATE","APP-000036 ันที่พร้อมป�?ิบัติงานควรเป็นวันเดียว�?ับวันที่�?จ้งลาหรือหลัง�?ว่านั้น"},
		{"INVALID_VALUE","APP-000037 # ไม่ถู�?ต้อง"},
		{"INVALID_DATE_RANGE","APP-000038 ช่วงวันที่ไม่ถู�?ต้อง"},
		{"INVALID_NUMBER_FORMAT","APP-000039 รูป�?บบตัวเลขไม่ถู�?ต้อง"},
		{"INVALID_USER_ID","APP-000040 หมายเลขประจำตัวผู้ใช้ไม่ถู�?ต้อง"},
		{"LV_DATE_EQ_CURR_DATE","APP-000041 วันที่ $ ลาควรเป็นวัน�?่อนวันที่ปัจจุบัน"},
		{"LV_DATE_LESS_DOB","APP-000042 วันที่เริ่มลาควรมาทีหลังจา�?วันเดือนปีเ�?ิด"},
		{"LV_END_DATE_EQ_FROM_DATE","APP-000043 วันที่ลาวันสุดท้ายควรมาทีหลังวันที่ลาวัน�?ร�? "},
		{"LOCATION_CHG_FIN_DTLS","APP-000044 ตำ�?หน่งถู�?เปลี่ยน�?ปลง�?ล้ว ให้ตรวจสอบรายละเอียดทาง�?ารเงิน"},
		{"MONTH_IS_GR_12","APP-000045 เลขเดือนต้องไม่เ�?ิน 12 "},
		{"MONTHS_CHECK","APP-000046 จำนวนเดือนต้องไม่เ�?ิน 11 ดือน"},
		{"MORE_ALT_ID_FOUND","APP-000047 มี # มา�?�?ว่าหนึ่ง"},
		{"MULTI_OPER_STN_FOR_USER","APP-000048 ท่านได้�?ำหนด�?ารใช้งานจา�?หลายสถานที่ ไม่สามารถดำเนิน�?ารต่อได้"},
		{"NEXT_NUM_GR_MAX_NUM","APP-000049 ตัวเลขถัดไปไม่ควรจะมา�?�?ว่าตัวเลขสูงสุด"},
		{"NO_CHANGE_TO_SAVE","APP-000050 13 ไม่มี�?ารเปลี่ยน�?ปลงที่ถู�?บันทึ�?"},
		{"ENCOUNTER_NOT_FOUND","APP-000051 ไม่พบ�?ารเข้ารับ�?ารตรวจ ไม่สามารถดำเนิน�?ารต่อได้"},
		{"NO_RECORD_FOUND","APP-000052 14 ไม่พบข้อมูล"},
		{"NOT_VALID","APP-000053 หน่วยงาน/หมายเลขของผู้ใช้งาน ไม่ถู�?ต้อง"},
		{"INVALID_POSITIVE_NUMBER","APP-000054 จำนวนตัวเลขต้องมา�?�?ว่าศูนย์"},
		{"NO_OPER_STN_FOR_USER","APP-000055 ผู้ใช้ระบบไม่ได้�?ำหนดสถานที่ใช้งาน"},
		{"ORDERBY_NOT_BLANK","APP-000056 ต้องบันทึ�?ว่าใครเป็นผู้สั่ง"},
		{"PAT_VAL_MAX_2000","APP-000057 รายละเอียดทรัพย์สินของผู้ป่วยไม่ควรเ�?ิน 2000 ตัวอั�?ษร"},
		{"PRF_DATE_CHECK","APP-000058 วันที่เลือ�?ควรเป็นหลังจา�?วันที่ส่งตัวผู้ป่วย"},
		{"PRF_DATE_NOT_GR_CURR_DATE","APP-000059 วันที่เลือ�?ควรเป้นวันเดียว�?ันหรือมาหลังวันที่ปัจจุบัน"},
		{"PRINT_ROUTING_NOT_DEFINED","APP-000060 ไม่ได้ระบุเครื่องพิมพ์ �?รุณาติดต่อผู้จัด�?ารระบบ"},
		{"NO_RECORD_FOUND_FOR_CRITERIA","APP-000061 ไม่มีข้อมูลที่ท่านค้นหา"},
		{"RECD_DATE_SYSDATE_CHECK","APP-000062 วันที่รับ ไม่ควรเป็นวันหลังจา�?วันที่ของระบบ"},
		{"RECDDATE_REFLDATE_CHECK","APP-000063 ันที่รับต้องเป็นวันหลังจา�?วันที่ส่งตัวผู้ป่วย"},
		{"CODE_ALREADY_EXISTS","APP-000064 ข้อมูลนี้มีอยู่�?ล้ว..."},
		{"REFL_DATE_CHECK","APP-000065 วันที่ส่งตัวผู้ป่วยต้องมา�?่อนหรือเป็นวันเดียว�?ับวันที่ของระบบ"},
		{"REFERRAL_BOOKED","APP-000066 �?ารลงทะเบียนส่งต่อผู้ป่วย�?ล้วเสร็จ�?ละได้หมายเลข�?ารลงทะเบียน�?ล้ว "},
		{"REFERRAL_MODIFIED","APP-000067 �?ารลงทะเบียนส่งต่อผู้ป่วยได้รับ�?ารปรับเปลี่ยนเสร็จ�?ละได้หมายเลข�?ารลงทะเบียน�?ล้ว "},
		{"REPORT_SUBMIT_SERVER","APP-000068 รายงานถู�?ส่งไปยัง Server �?ล้ว..."},
		{"REPORT_RULE_NOT_DEFINED","APP-000069 ไม่ได้ระบุเ�?ณฑ์ของรายงาน ไม่สามารถพิมพ์ได้ �?รุณาติดต่อผู้จัด�?ารระบบ"},
		{"RESOURCE_NOT_WORK","APP-000070 Resource ไม่ทำงานในวันนั้น"},
		{"RESUME_ACTIVITY_GR_END_DATE","APP-000071 วันที่ดำเนิน�?ารต่อ ควรเป็นวันเดียว�?ับวันที่ลาหรือหลังจา�?นั้น"},
		{"ROOM_NOT_AVBL","APP-000072 ห้องไม่ว่างในวันนั้น"},
		{"SEARCH_TEXT_BLANK","APP-000073 ต้อง�?รอ�?ช่องค้นหา"},
		{"MSG_NOT_MAINTAINED","APP-000074 ข้อความนี้ไม่ได้ถู�?เ�?็บรั�?ษาไว้"},
		{"CURRENTLY_IN_PATIENT","APP-000075 ผู้ป่วยรายนี้เป็นผู้ป่วยใน"},
		{"TO_TIME_LESS_FM_TIME","APP-000076 ถึงเวลา ต้องไม่เป็นเวลา�?่อน จา�?เวลา"},
		{"MIN_ONE_DETAIL_REQUIRED","APP-000077 ต้องมีอย่างน้อยหนึ่งราย�?ารในรายละเอียดของข้อมูล"},
		{"OBJ_CANNOT_EXCEED","APP-000078 ค่านี้ไม่ควรเ�?ิน $ ตัวอั�?ษร"},
		{"VALUE_SHOULD_BE_GR_ZERO","APP-000079 ค่าควรมา�?�?ว่าศูนย์"},
		{"VISIT_LESS_DATE","APP-000080 วันที่มาตรวจควรเป็นวันเดียว�?ันหรือมา�?่อนวันที่ของระบบ"},
		{"VISIT_TYPE_CHG_FIN_DTLS","APP-000081 ชนิดของ�?ารตรวจเยี่ยมได้ถู�?เปลี่ยน�?ปลง�?ล้ว ให้ตรวจสอบรายละเอียดค่าใช้จ่าย"},
		{"VISIT_TYPE_NOT_APPL_PRACT","APP-000082 ชนิดของ�?ารตรวจเยี่ยมไม่สามารถ�?ระทำได้ในบุคลา�?รทาง�?าร�?พทย์ท่านนี้"},
		{"SECURED_NOT_ALLOWED","APP-000083 ไม่ได้รับอนุ�?าตให้เข้าดูข้อมูลของผู้ป่วยรายนี้"}
		};			
}		
