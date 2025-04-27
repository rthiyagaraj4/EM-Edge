/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------
Date				Edit History      Name			 Description
-------------------------------------------------------------------------------------------------------
?				100            		?				created
08/01/2014		LICN_1				Karthi			MMS Issue.
10/03/2014	  	IN024984			Chowminya		Duplicate order recording with reason - new mandatory option
26/08/2014    	IN050607			Nijitha S		KDAH-SCF-0255
24/07/2015		IN054381			Karthi			MMS-QF-CRF-0211
06/10/2015		IN055737			Karthi L		IN055737 HSA-CRF-0250.1 - Dispatch Slip
29/06/2016		IN060516			Karthi L		MMS-MD-SCF-0017 
-------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name       Rev.Date   Rev.By    Description
--------------------------------------------------------------------------------------------------------------
22/08/2016		IN059646		Raja S								ML-BRU-SCF-1676
10/05/2017		IN064215		Krishna Gowtham J	10/05/2017		Ramesh G		PMG2017-SH-CRF-0001
09/06/2017	IN063816		Vijayakumar K										GHL-CRF-0445.1 [IN:063816]	
03/08/2017	IN062992		Dinesh T		07/08/2017	Ramesh G	ML-MMOH-CRF-0345.1
26/10/2017	IN061892		Prakash C		31/10/2017	Ramesh G	ML-MMOH-CRF-0544
15/12/2017	IN065942	Dinesh T	15/12/2017	Ramesh G	In Nuclear medicine  department we required the barcode 																		functionality at the time of Registration of order,required patient 															Id,patient name,age,sex,register date and name of study.
06/02/2018		IN065642		Prathyusha P				 		GHL-CRF-0487 [IN:065642]
08/10/2018	  IN063719		Kamalakannan 	08/10/2018	Ramesh G		GHL-CRF-0419
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015
27/05/2019	IN069027	Ramesh G								MMS-DM-CRF-0150
--------------------------------------------------------------------------------------------------------------
*/
package eOR.resources;

import java.util.*;

public class Messages_th extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = {		
			{"NO_SERVICE_AVAILABLE"       ,					"APP-OR0001 ไม่มีบริการที่เลือกใช้ได้" },
			{"NEXT_NUMBER_GREATER_MAX"    ,					"APP-OR0002 หมายเลขคำสั่งการรักษาต้องไม่เกินค่าสูงสุด" },
			{"OVERLAPPING"                ,					"APP-OR0003 หมายเลขนี้ทับซ้อนกับชนิดบริการที่มีอยู่แล้ว" },
			{"VALIDNUMBER"                ,					"APP-OR0004 โปรดใส่จำนวนที่ถูกต้องและมากกว่า 0" },
			{"CODEISUSED"                 ,					"APP-OR0005 รหัสส่วนนี้ถูกใช้ในบริการสำหรับรูปแบบคำสั่งการรักษา" },
			{"USERACCESS"                 ,					"APP-OR0006 ผู้ใช้ไม่ได้รับอนุญาตให้ใช้ฟังก์ชั่นนี้" },
			{"ALLAUTHORIZE"               ,					"APP-OR0007 ท่านสามารถอนุมัติคำสั่งการรักษานี้ ท่านจะอนุมัติหรือไม่"},
			{"UNSUCCESS"                  ,					"APP-OR0008 คำสั่งการรักษานี้ต้องได้รับการอนุมัติก่อน" },
			{"AUTHORIZE_ATLEAST_ONE"      ,					"APP-OR0009 ต้องเลือกคำสั่งรักษาอย่างน้อย 1 อย่าง" },
			{"RESULT_AUTH_ATLEAST_ONE"    ,					"APP-OR0010 ต้องอนุมัติผลการตรวจอย่างน้อย 1 อย่าง" },
			{"NO_ORDER_FORMAT_AVAILABLE"  ,					"APP-OR0011 ไม่มีรูปแบบของคำสั่งการรักษาที่เลือกใช้ได้" },
			{"BLANK_RESULT_DATA"          ,					"APP-OR0012 ไม่สามารถเว้นว่างผลของการบริการ &SERVICE ได้" },
			{"ATLEAST_ONE_RESULT"         ,					"APP-OR0013 ควรใส่ผลของการรักษา/บริการอย่างน้อย 1 อย่าง" },
			{"DUP_CHK"                    ,					"APP-OR0014 บันทึกซ้ำ" },
			{"SERVICE_DATE_BLANK"         ,					"APP-OR0015 ต้องใส่วันที่ของการบริการ" },
			{"INVALID_STATUS"             ,					"APP-OR0016 สถานะของบริการ &SERVICE ไม่ถูกต้อง" },
			{"INVALID_DECIMAL"            ,					"APP-OR0017 ค่าทศนิยมเกินกว่าที่กำหนด" },
			{"CHECK_CODE_DESC"            ,					"APP-OR0018 ไม่สามารถเว้นว่างรหัสและคำอธิบายได้" },
			{"CHK_DESC"                   ,					"APP-OR0019 ควรลงคำอธิบาย" }, //append the required text
			{"CHK_ID"                     ,					"APP-OR0020 ควรลงหมายเลขประจำตัว" }, //append the required text
			{"CHK_CODE"                   ,					"APP-OR0021 ควรลงรหัส" }, //append the required text
			{"ATLEAST_ONE_RECORD"         ,					"APP-OR0022 ต้องเลือกอย่างน้อย 1 บันทึก" },
			{"ORDER_CATEGORY"             ,					"APP-OR0023 ต้องใส่หมวดของคำสั่งการรักษา" },
			{"MAX_RECORDS"                ,					"APP-OR0024 บันทึกได้สูงสุด 200 ตัวอักษร"},
			//{"NO_RECORDS_FOUND_FOR_CRITERIA"				,	  "APP-002415 Query caused no records to be retrieved_th_th"},
			{"UNPROCESS_INPROCESSED"      ,					"APP-OR0026 ไม่สามารถเว้นว่างการตรวจที่ยังไม่ได้ดำเนินการหรืออยู่ในระหว่างการดำเนินการได้"},
			{"VALID_DATA"                 ,					"APP-OR0027 ต้องใส่หมายเลขสำหรับคำสั่งที่ยังไม่ได้ดำเนินการหรือกำลังดำเนินการ" },
			{"INVALID_NUMBER"             ,					"APP-OR0028 หมายเลขคำสั่งที่ยังไม่ได้ดำเนินการหรือกำลังดำเนินการต้องมากกว่า 0" },
			{"NOT_VALID"                  ,					"APP-OR0029 ไม่สามารถใช้งานนี้ได้" },
			{"ONLY_PRACT_OR_RESP"         ,					"APP-OR0030 ต้องเลือกบุคลากรทางการแพทย์หรือหน้าที่ของบุคลากร" },
			{"BLANK_RECORD"               ,					"APP-OR0031 ไม่สามารถบันทึกข้อมูลเปล่าได้" },
		//	{"INVALID_ZERO"				  ,					"APP-OR0032 Unprocessed  cannot be zero" +"<br>" +" APP-OR0032 InProcess cannot be zero_th"},
			{"INVALID_DESC"               ,					"APP-OR0033 ควรบันทึกคำอธิบายสำหรับเลขประจำตัวนี้"},
			{"INVALID_ID"                 ,					"APP-OR0034 ควรบันทึกคำอธิบายสำหรับเลขประจำตัวที่เลือกนี้"},
			{"CHK_SPEC_GEN"               ,					"APP-OR0035 ถ้าเลือกพิมพ์ฉลากสำหรับติดสิ่งส่งตรวจ ต้องใส่ระยะเวลาเก็บสิ่งส่งตรวจก่อนพิมพ์ฉลากนี้"},
			{"EXPIRY_PERIOD"              ,					"APP-OR0036 ต้องใส่ระยะเวลาสิ้นสุด"},
			{"TIME_BASED_RULE"            ,					"APP-OR0037 ต้องใส่ประเภทของหน่วยเวลา"},
			{"MIN_LESS_THAN_MAX"          ,					"APP-OR0038 ค่าต่ำสุดต้องไม่เกินค่าสูงสุด"},
			{"ONLY_POSITIVE_NUM"          ,					"APP-OR0039 สามารถใส่ได้เฉพาะ"},
			{"MAX_VAL_NOT_BLANK"          ,					"APP-OR0040 ต้องใส่ค่าสูงสุดเสมอ"},
			{"MAX_VAL_NOT_ZERO"           ,					"APP-OR0041 ค่าสูงสุดต้องมากกว่า 0"},
			{"MIN_VAL_NOT_BLANK"          ,					"APP-OR0042 ต้องใส่ค่าต่ำสุดเสมอ"},
		//	{"DISCRETE_MSR_NOT_NULL"      ,					"APP-OR0043 ต้องบันทึกค่า Discrete Measure "},
			{"DESC_NOT_BLANK"             ,					"APP-OR0044 ไม่สามารถเว้นว่างคำอธิบายได้"},
		//	{"SEQ_NO_NOT_BLANK"           ,					"APP-OR0045 Sequence Number cannot be blank_th"},
			{"ONLY_NUMBERS"               ,					"APP-OR0046 สามารถใส่ได้เฉพาะตัวเลข"},
			{"FIELD_CANNOT_BE_EMPTY"      ,					"APP-OR0047 ไม่สามารถเว้นว่างรายชื่อ โปรดคลิกที่ปุ่ม 'ฟิลด์'"},
			{"DUP_DESC"                   ,					"APP-OR0048 คำอธิบายของการบันทึกซ้ำ"},
			{"DUP_SEQ_NUM"                ,					"APP-OR0049 หมายเลขลำดับของการบันทึกซ้ำ"},
		//	{"SEQ_NO_NOT_ZERO"            ,					"APP-OR0050 Sequence Number cannot be Zero_th"},
			{"SELECT_TO_CLEAR"            ,					"APP-OR0051 เลือกบันทึกที่ต้องการลบ"},
			{"DESC_NOT_SPACES"            ,					"APP-OR0052 ไม่สามารถใช้การเว้นวรรคอย่างเดียวในคำอธิบายได้"},
			{"VAL_NOT_ZERO"               ,					"APP-OR0053 ต้องใส่จำนวนที่ไม่ใช่ 0"},
			{"PRACT_NOT_BLANK"            ,					"APP-OR0054 ต้องใส่ชื่อบุคลากรทางการแพทย์"},
			{"RESP_NOT_BLANK"             ,					"APP-OR0055 ต้องใส่ตำแหน่ง/หน้าที่ของบุคลากร"},
			{"SELECT_RESP_OR_PRACT"       ,					"APP-OR0056 เลือกบุคลากรทางการแพทย์/หน้าที่ของบุคลากร"},
			{"FREQ_NOT_BLANK"             ,					"APP-OR0057 ต้องเลือกความถี่"},
			{"OTHER_LOC_PRINT"            ,					"APP-OR0058 ต้องเลือกสถานที่สำหรับพิมพ์เอกสารนี้"}, //used in or_parameter for facility
			{"DISCHARGE_LOC_PRINT"        ,					"APP-OR0059 ต้องเลือกสถานที่พิมพ์เอกสารสำหรับผู้ป่วยจำหน่ายจากโรงพยาบาล"}, //used in or_parameter for facility
			{"INVALID_TIME_ENTRY"         ,					"APP-OR0060 ควรบันทึกเวลาจากน้อยไปหามาก"}, //used in or_parameter for facility
			{"INVALID_TIME_DAY_COMB"      ,					"APP-OR0061 เวลาที่ใช้ไม่ตรงกับจำนวนของการทำซ้ำ" },
			{"INVALID_TIME_FMT"           ,					"APP-OR0062 รูปแบบเวลาไม่ถูกต้อง" },//order entry format
			{"FIELD_MNEMONIC_CANNOT_BE_EMPTY",				"APP-OR0063 ไม่สามารถเว้นว่างชื่อฟิลด์ช่วยจำได้"},
			{"DESC_FORTEXT_NOT_BLANK"     ,					"APP-OR0064 ไม่สามารถเว้นว่างคำอธิบายหรือส่วนรายละเอียดใด ๆ ได้" },
			{"ORDER_TYPE"                 ,					"APP-OR0065 ต้องใส่ชนิดคำสั่งการรักษา" },
			{"PATIENT_CLASS"              ,					"APP-OR0066 ต้องใส่ประเภทของผู้ป่วย" },
			{"RECORD_EXISTS1"             ,					"APP-OR0067 มีบันทึกอยู่แล้ว โปรดตรวจสอบจาก Query Mode" }, //order entry format
			{"INVALID_TIME_FMT_HRS"       ,					"APP-OR0068 รูปแบบที่ถูกต้องคือระหว่าง 00:00 ถึง 00:59" }, //
			{"MAX_LIMIT"                  ,					"APP-OR0069 บันทึกได้สูงสุด 2000 ตัวอักษร" }, //consent format
			{"SYSTEM_USER_DEFINED"        ,					"APP-OR0070 ไม่สามารถเปลี่ยนแปลงค่าที่ระบบกำหนดได้" }, //Order Entry Format
			{"PRACT_RESP_NO_ACCESS"       ,					"APP-OR0071 บุคลากรทางการแพทย์ไม่สามารถเรียกดูรายงานคำสั่งการรักษาได้"}, //Result Reporting.
			{"CATALOG_AUTH_CHECK"         ,					"APP-OR0072 ระดับการอนุมัติควรสูงกว่าหรือเท่ากับระดับการใช้งาน"}, //Order catalog
			{"ONE_ENTRY_MIN_AGE"          ,					"APP-OR0073 จำเป็นต้องเลือกอย่างน้อย 1 ตัวเลือกสำหรับอายุต่ำสุด"}, //Order catalog..Instructions
			{"ONE_ENTRY_MAX_AGE"          ,					"APP-OR0074 จำเป็นต้องเลือกอย่างน้อย 1 ตัวเลือกสำหรับอายุสูงสุด"}, //Order catalog..Instructions
			{"MIN_MAX_AGE_CHECK"          ,					"APP-OR0075 อายุสูงสุดควรมากกว่าอายุต่ำสุด"}, //Order catalog..Instructions
			{"SEX_MAX_MIN_OVERLAP_CHK"    ,					"APP-OR0076 เพศเดียวกันมีค่าอายุน้อยที่สุดและมากที่สุดเหลื่อมกันไม่ได้"}, //Order catalog..Instructions
			{"ENTER_MONTH_CHK"            ,					"APP-OR0077 เดือนควรอยู่ระหว่าง 0 ถึง 11"}, //Order catalog..Instructions
			{"ENTER_DAY_CHK"              ,					"APP-OR0078 วันที่ควรอยู่ระหว่าง 1 ถึง 31"}, //Order catalog..Instructions
			{"INSTRN_BLANK_CHK"           ,					"APP-OR0079 ต้องใส่"}, //Order catalog..Instructions
			{"AUTH_REQD_CONFIRM"          ,					"APP-OR0080 ท่านสามารถอนุมัติคำสั่งการรักษานี้ ท่านจะอนุมัติหรือไม่"}, // Order Entry
			{"SINGLE_RECORD_CHK"          ,					"APP-OR0081 สามารถเลือกบันทึกได้ฉบับเดียว"},// Order entry formats
		//	{"INVALID_DATE_FMT"           ,					"APP-OR0082 Invalid Date Format. Valid entry dd/mm/yyyy_th" },//Transactions Dinesh
		//	{"INVALID_DATE_TIME_FMT"      ,					"APP-OR0083 Invalid Date and Time Format. Valid entry dd/mm/yyyy hh:mi_th" },//Transactions Dinesh
			{"ENTER_RPT_PRACT"            ,					"APP-OR0084 ใส่ชื่อบุคลากรทางการแพทย์ผู้รายงานผล" },//Transactions Dinesh
			{"ALL_MAND_FIELDS"            ,					"APP-OR0085 โปรดใส่ข้อมูลที่จำเป็นทุกช่อง" },//Transactions Dinesh
			{"VARIABLE_DEC_DIGIT"         ,					"APP-OR0086 ใส่จุดทศนิยมได้เพียง @ หลัก" },//Transactions Dinesh
			{"RSLT_NOT_LESS_DIGIT"        ,					"APP-OR0087 ต้องใส่ค่าไม่น้อยกว่า @ หลัก" },//Transactions Dinesh
			{"RSLT_NOT_MORE_DIGIT"        ,					"APP-OR0088 ต้องใส่ค่าไม่เกิน @ หลัก" },//Transactions Dinesh
			{"AUTH_RESULT"                ,					"APP-OR0089 ท่านสามารถอนุมัติผลนี้ ท่านจะอนุมัติหรือไม่" },//Transactions Dinesh
			{"FUTURE_DATE_TIME"           ,					"APP-OR0090 วันที่สั่งการรักษาต้องมาก่อนวันที่สั่งการรักษาล่วงหน้า" },//OrderEntry
			{"BACK_DATE_TIME"             ,					"APP-OR0091 Oวันที่สั่งการรักษาต้องมาหลังจากวันที่สั่งการรักษาก่อนหน้านี้" },//OrderEntry
		//	{"FILL_ORDER_FORMAT_FLDS"     ,					"APP-OR0092 Additional info cannot be Blank_th" },//OrderEntry
			//{"VALUE_BETWEEN_RANGE"        ,					"APP-OR0093 Entered value should be between _th" },//OrderEntry
			{"ADMDATE_LESS_DATE"          ,					"APP-OR0094 วันที่สั่งการรักษาต้องมาหลังจากวันที่รับไว้ในโรงพยาบาล" },//OrderEntry
			{"CANNOT_BE_BLANK"            ,					"APP-OR0095 ไม่สามารถเว้นว่าง @ ได้" },//Common usage
			{"SELECT_STATUS"              ,					"APP-OR0096 ต้องใส่สถานะ" },//Common usage
			{"ROUT_STATUS"                ,					"APP-OR0097 ต้องใส่คำสั่งการรักษาปกติสำหรับสถานที่ 1 และ 2" },
			{"URG_STATUS"                 ,					"APP-OR0098 ต้องสั่งการรักษาด่วนสำหรับสถานที่ 1 และ 2" },
			{"SYSTEM_DEFINED_CANNOT_DELETE",				"APP-OR0099 ไม่สามารถลบค่าที่ระบบกำหนดได้" }, //Order Entry Format
			{"ORDER_SET_SELECTED"          ,				"APP-OR0100 ได้เลือกชุดคำสั่งการรักษาแล้ว" }, //Order Entry
			{"ORDER_SET_BLANK"             ,				"APP-OR0101 ต้องใส่ชุดคำสั่งการรักษา" }, //Order Entry
			{"DUP_ORDER_SET_ENTRY"         ,				"APP-OR0102 ไม่อนุญาตให้บันทึกซ้ำ" }, // Index Order Set
			{"PRACT_RESP_NOT_AUTHORISED"   ,				"APP-OR0103 บุคลากรทางการแพทย์ไม่สามารถอนุมัติคำสั่งการรักษาได้" }, // Authorise Order
			{"IMAGE_PRE_SELECT_CATEGORY"   ,				"APP-OR0104 ไม่สามารถเลือกรูปในหมวดนี้ได้" }, // Order Entry
			{"DURATION_CANNOT_BE_BLANK"    ,				"APP-OR0105 ต้องบันทึกระยะเวลา" }, // Order Entry
			{"LABEL_TEXT_CANNOT_BE_BLANK"  ,				"APP-OR0106 โปรดใส่ข้อมูล" }, // Order Entry
			{"INVALID_INTEGER_RANGE"       ,				"APP-OR0107 ค่าเลขจำนวนเต็มไม่ถูกต้อง" }, // Order Entry
			{"INVALID_DECIMAL_RANGE"       ,				"APP-OR0108 ช่วงของค่าทศนิยมไม่ถูกต้อง" }, // Order Entry
			{"SEQ_ORDER_CAT_SECTION_CHK"   ,				"APP-OR0109 ไม่สามารถใช้หมายเลขลำดับเหมือนกันในคำสั่งการรักษาต่างกัน" }, // Order Catalog  by section
			{"LAB_MODULE_INSTALLED"        ,				"APP-OR0110 ไม่สามารถเลือกฟังก์ชั่นนี้ได้ โปรดเลือก Lab Module" }, // Register order
			{"PRACT_RESP_CANNOT_REGISTER"  ,				"APP-OR0111 บุคลากรทางการแพทย์ไม่สามารถบันทึกคำสั่งการรักษาได้"}, //Register Order.
			{"CLICK_ANY_ONE"               ,				"APP-OR0112 เลือกอย่างน้อย 1 คำสั่ง"}, //General Message.
			{"MAX_DURN_MAND_CHK"           ,				"APP-OR0113 ค่าสูงสุดควรมากกว่าค่าระยะเวลา"}, //Order catalog
			{"NOT_VALID_DELETE"            ,				"APP-OR0114 ไม่สามารถลบได้"},
			{"SELECT_HOTSPOT"              ,				"APP-OR0115 เลือกส่วนที่ต้องการตรวจ"},
			{"COSIGN_REQD_CONFIRM"         ,				"APP-OR0116 ท่านสามารถลงนามกำกับ/ลงนามร่วมคำสั่งการรักษานี้ได้ ท่านจะลงนามหรือไม่"}, // OrderEntry
			{"SCHEDULE_CANNOT_BE_BLANK"    ,				"APP-OR0117 ต้องใส่ความถี่ห่าง"}, // OrderEntry
			{"SPECIAL_APPROVAL_REQD_CONFIRM",				"APP-OR0118 ท่านสามารถเห็นชอบคำสั่งการรักษานี้ ท่านจะเห็นชอบหรือไม่"}, // OrderEntry
			{"DECIMAL_NOT_ALLOWED"         ,				"APP-OR0119 ไม่อนุญาตให้ใช้จุดทศนิยม"},
			{"SCH_FREQ_BLANK"              ,				"APP-OR0120 ต้องใส่จำนวน/ปริมาณ" }, // included for PH
			{"DOSE_LIMIT"                  ,				"APP-OR0121 ยา/การรักษาเกินขนาดสูงสุด" },// included for PH
			{"QTY_NOT_EQUAL"               ,				"APP-OR0122 จำนวน/ปริมาณต้องไม่เท่ากัน" },// included for PH
			{"QTY_VAL_NOT_SAME"            ,				"APP-OR0123 จำนวน/ปริมาณทั้งหมดต้องไม่เหมือนกัน" },// included for PH
			{"START_DATE_TIME_VALIDATE"    ,				"APP-OR0124 วันและเวลาที่เริ่มควรอยู่ระหว่างวันและเวลาที่กำหนด" },//Scheduled Frequncy
			{"PRACT_RESP_CANNOT_SPECIAL_APPRV",				"APP-OR0125 บุคลากรทางการแพทย์ไม่สามารถใช้รายการอนุมัติพิเศษได้" }, // Special approval order
			{"INVALID_DECIMAL_NUMBER"      ,				"APP-OR0126 Iค่าทศนิยมไม่ถูกต้อง" }, // order entry format
			{"MAX_NO_DECIMAL"              ,				"APP-OR0127 อนุญาตให้ใช้หลักทศนิยมได้สูงสุด 3 หลัก" }, // order entry format
			{"MAX_255_CHARS"               ,				"APP-OR0128 บันทึกได้สูงสุด 255 ตัวอักษร" }, // cancel reason
			{"REASON_CANNOT_BLANK"         ,				"APP-OR0129 ต้องใส่เหตุผลการตรวจ" }, // cancel reason
			{"TO_LOCATION_GR_EQ_FROM_LOCATION",				"APP-OR0130 ลำดับของสถานที่ 2 ควรอยู่หลังจากลำดับของสถานที่แรก" }, // Print Specimen Labels
			{"TO_ORDER_TYPE_GR_EQ_FROM_ORDER_TYPE",			"APP-OR0131 ลำดับของชนิดคำสั่งรักษาที่ 2 ควรอยู่หลังจากลำดับของชนิดคำสั่งรักษาแรก" }, // Print Specimen Labels
			{"SHEDULE_FUTURE_DATE_TIME"    ,				"APP-OR0132 วันที่เริ่มต้องมาก่อนวันที่สั่งการรักษาล่วงหน้า" },//OrderEntry  -Schedule Frequency
			{"SHEDULE_BACK_DATE_TIME"      ,				"APP-OR0133 วันที่เริ่มต้องมาหลังจากวันที่สั่งการรักษาเดิม" },//OrderEntry  -Schedule Frequency
			{"RADIOLOGY_MODULE_INSTALLED"  ,				"APP-OR0134 ไม่สามารถใช้ฟังก์ชั่นนี้ได้ โปรดเลือก Radiology Module" }, // Register order
			{"START_ORDER_DATE_TIME"       ,				"APP-OR0135 วันที่เริ่มต้องมาหลังจากวันที่สั่งการรักษา" },//OrderEntry
			{"CLICK_ONE_ORDERABLE"         ,				"APP-OR0136 เลือกคำสั่งการรักษาอย่างน้อย 1 อย่าง"}, //General Message.
			{"CLICK_ONE_NEW_ORDERABLE"     ,				"APP-OR0137 เลือกการรักษาอย่างน้อย 1 อย่างเพื่อเลือกดู"}, //General Message.
			{"OR_MODULE_INSTALL"           ,				"APP-OR0138 หน่วยงานนี้ไม่สามารถใช้ส่วน OR ได้"}, //General Message.
			{"SPECIMEN_COLLECTION_DATE_BLANK",				"APP-OR0139 ต้องบันทึกวันและเวลาเก็บสิ่งส่งตรวจ"},
			{"PERF_LOCN_CANNOT_BLANK"      ,				"APP-OR0140 ต้องใส่สถานที่รักษา"},// Order Entry
			{"CHECK_ATLEAST_ONE_EVENT"     ,				"APP-OR0141 เลือกอย่างน้อย 1 อย่าง"},
			{"SPECIMEN_COLLECTION_ORDER_DATE",				"APP-OR0142 วันที่ต้องมาก่อนหรือตรงกับวันที่สั่งการรักษา"},
			{"SPECIMEN_COLLECTION_PREV_COLLECTION_DATE",	"APP-OR0143 วันที่ต้องมาหลังวันที่เก็บสิ่งส่งตรวจเดิม"},
			{"RESULT_REPORTING_LOCN_BLANK" ,				"APP-OR0144 ต้องใส่สถานที่"},
			{"PRACT_RESP_AUTH_NO_ACCESS"  ,				"APP-OR0145 บุคลากรทางการแพทย์ไม่สามารถอนุมัติผลการตรวจได้"}, //Result Reporting.
			{"NEW_ORDER_CONFIRM"           ,				"APP-OR0146 สั่งการรักษาใหม่ ท่านต้องการดำเนินการต่อหรือไม่"}, //Order Entry
			{"QTY_CANNOT_BE_BLANK"         , 				"APP-OR0147 ต้องใส่จำนวน/ปริมาณมากกว่า 0" }, // Order Entry
			{"RPT_SUBMIT_TO_PRINTER"       ,				"APP-OR0148 สั่งพิมพ์รายงานนี้ที่เครื่องพิมพ์เรียบร้อยแล้ว" },
			{"SUBMIT_TO_PRINTER"       ,				"APP-OR0148 # has been Submitted to the Printer" },//IN065942, Child of RPT_SUBMIT_TO_PRINTER
			{"RPT_CANNOT_BE_BLANK"         ,				"APP-OR0149 ไม่สามารถเว้นว่างรายงานได้" },  //Reprint
			{"PRINT_AT_LOCN_CANNOT_BE_BLANK",				"APP-OR0150 ต้องเลือกสถานที่สำหรับพิมพ์เอกสารนี้" }, //Reprint
			{"ORDERS_CANNOT_BE_PLACED"     ,				"APP-OR0151 ไม่สามารถสั่งการรักษาได้เนื่องจากมีข้อจำกัดสำหรับผู้ป่วยประเภทนี้"}, //Order Entry
			{"DIRECT_CARE_ANCILLARY_DEPT_ACTIVATE",			"APP-OR0153 ไม่ได้เลือกคำเสมือนสำหรับ Direct Care/Ancillary Dept. ข้อมูลนี้จะไม่ถูกบันทึก ท่านต้องการบันทึกหรือไม่"},
			{"CLICK_RENEW_ORDER"           ,				"APP-OR0154 ต้องต่ออายุการรักษานี้ใหม่ ไม่สามารถเลือกคำสั่งการรักษาใหม่อย่างอื่นได้"}, // Renew Order(Order Entry)
			{"REFUSAL_LESS_VISIT_DATE_TIME",				"APP-OR0155 วันและเวลาที่ปฏิเสธต้องมาหลังจากวันและเวลาที่ผู้ป่วยมาโรงพยาบาล"}, // Refusal Orders
			{"REFUSAL_LESS_REGN_DATE_TIME" ,				"APP-OR0156 วันและเวลาที่ปฏิเสธต้องมาหลังจากวันและเวลาที่ลงทะเบียน"}, // Refusal Orders
			{"REFUSAL_LESS_SYS_DATE_TIME"  ,				"APP-OR0157 วันและเวลาที่ปฏิเสธต้องมาก่อนวันและเวลาปัจจุบัน"}, // Refusal Orders
			{"AT_LEAST_ONE_PERFORMING_LOCATION",			"APP-OR0158 ต้องเลือกสถานที่รักษาอย่างน้อย 1 แห่ง"},
			{"DUPLICATE_PERFORMING_LOCATION",				"APP-OR0159 ไม่อนุญาตให้เลือกสถานที่รักษาซ้ำ"},
			{"CLICK_ANY_ONE_PATIENT"       ,				"APP-OR0160 เลือกผู้ป่วยอย่างน้อย 1 คน"}, //External Orders
			{"CLICK_ANY_ONE_USER_DEFINED_TABS",				"APP-OR0161 เลือก Tab อย่างน้อย 1 อัน"}, // Order Tabs
			{"SHD_NOT_BE_BLANK"             ,				"APP-ORO162 ต้องใส่เลขประจำตัวผู้ป่วย"},
			{"INVALID_PATIENT"              ,				"APP-ORO163 Invalid Patient Id"},
			{"ADDITIONAL_SEARCH_TABNAME_NOT_BLANK",			"APP-ORO164 ต้องใส่ชื่อ Tab สำหรับการค้นหาเพิ่มเติม"},
			{"ADDITIONAL_SEARCH_SEQNO_NOT_BLANK",			"APP-ORO165 ต้องใส่หมายเลขลำดับสำหรับการค้นหาเพิ่มเติม"},
			{"TICK_SHEETS_TABNAME_NOT_BLANK",				"APP-ORO166 ต้องใส่ชื่อ Tab สำหรับ Tick Sheet"},
			{"TICK_SHEETS_SEQNO_NOT_BLANK"  ,				"APP-ORO167 ต้องใส่หมายเลขลำดับสำหรับ Tick Sheet"},
			{"ORDER_SETS_TABNAME_NOT_BLANK" ,				"APP-ORO168 ต้องใส่ชื่อ Tab สำหรับชุดคำสั่งการรักษา"},
			{"ORDER_SETS_SEQNO_NOT_BLANK"   ,				"APP-ORO169 ต้องใส่หมายเลขลำดับสำหรับชุดคำสั่งการรักษา"},
			{"IMAGE_TABNAME_NOT_BLANK"      ,				"APP-ORO170 ต้องใส่ชื่อ Tab สำหรับรูปภาพ"},
			{"IMAGE_SEQNO_NOT_BLANK"        ,				"APP-ORO171 ต้องใส่หมายเลขลำดับสำหรับรูปภาพ"},
			{"PLACE_ORDER_TABNAME_NOT_BLANK",				"APP-ORO172 ต้องใส่ชื่อ Tab เมื่อสั่งการรักษา"},
			{"PLACE_ORDER_SEQNO_NOT_BLANK"  ,				"APP-ORO173 ต้องใส่หมายเลขลำดับเมื่อสั่งการรักษา"},
			{"LOCN_TYPE_NOT_BLANK"          ,				"APP-OR0174 ต้องใส่ชนิดของสถานที่"},
			{"LOCN_NOT_BLANK"               ,				"APP-OR0175 ต้องใส่สถานที่"},
			{"SPECIMEN_COLLECTION_COLLECTION_DATE"       ,	"APP-OR0176 วันที่ต้องมาหลังหรือตรงกับวันเก็บสิ่งส่งตรวจ"},
			{"SPECIMEN_COLLECTION_DISPATCH_DATE_BLANK"   ,	"APP-OR0177 ต้องบันทึกวันและเวลาส่ง"},
			{"SPECIMEN_COLLECTION_DISPATCH_MODE_BLANK"   ,	"APP-OR0178 ต้องบันทึกวิธีการส่ง"},
			{"SPECIMEN_COLLECTION_DISPATCH_BY_BLANK"     ,	"APP-OR0179 ต้องบันทึกผู้ส่ง"},
			{"SPECIMEN_COLLECTION_DISPATCH_REMARKS_BLANK",	"APP-OR0180 ต้องบันทึกหมายเหตุ"},
			{"SPECIMEN_COLLECTION_COLLECTION_BY_BLANK"   ,	"APP-OR0181 ต้องบันทึกผู้เก็บสิ่งส่งตรวจ"},
			{"SPECIMEN_COLLECTION_DISPATCH_LOCN_BLANK"   ,	"APP-OR0182 ต้องบันทึกสถานที่ส่ง"},
//			{"ATLEAST_ONE_EXCEPTION_IDENTIFIER"          ,	"APP-OR0183 Atleast One Exception Identifier should be selected_th"},
			{"PREFERRED_SURGERY_DATE_LESSER_SYSDATE"     ,	"APP-OR0184 วันที่และเวลาที่ต้องการผ่าตัดต้องมาหลังจากวันและเวลาปัจจุบัน"},
			{"SEQ_TICK_SHEET_SECTION_CHK"                ,	"APP-OR0185 ไม่สามารถใช้หมายเลขลำดับเหมือนกันในคำสั่งการรักษา"},
			{"PERF_SURGEON_BLANK"                        ,	"APP-OR0186 ต้องใส่ทีมรักษา/ศัลยแพทย์"},
			{"REVIEW_REMARKS_MAX_LENGTH"                 ,	"APP-OR0187 บันทึกได้สูงสุด 2000 ตัวอักษร"},
			{"REVIEW_RESULTS_PREVIOUS_ORDERS"            ,	"APP-OR0188 ไม่สามารถเลือกผู้ป่วยหลายคนในคำสั่งการรักษาเดิมได้"},
			{"RENEW_ORDERS_SUCCESSFUL"                   ,	"APP-OR0189 ทำการต่ออายุเป็นผลสำเร็จ"},
			{"STAT_DURATION_TYPE_BLANK"                  ,	"APP-OR0190 ต้องบันทึกชนิดของระยะเวลา"},
			{"URGENT_DURATION_TYPE_BLANK"                ,	"APP-OR0191 ต้องใส่หน่วยของระยะเวลา"},
			{"ROUTINE_DURATION_TYPE_BLANK"               ,	"APP-OR0192 ต้องใส่ชนิดของระยะเวลาการรักษา"},
			{"STAT_DURATION_BLANK"                       ,	"APP-OR0193 ต้องบันทึกระยะเวลาh"},
			{"URGENT_DURATION_BLANK"                     ,	"APP-OR0194 ต้องใส่ค่าระยะเวลา"},
			{"ROUTINE_DURATION_BLANK"                    ,	"APP-OR0195 ต้องใส่ระยะเวลาของการรักษา"},
			{"ATLEAST_ONE_PRIVILEGE"                     ,	"APP-OR0196 ต้องเลือกสิทธิของท่านอย่างน้อย 1 อย่าง"},
			{"ATLEAST_ONE_RECORD_ACTIVE"                  ,	"APP-OR0197 ต้องเลือกฟิลด์บังคับสำหรับ active"},
			{"REFERRAL_RECEIVED_DATE_LESSER_REPORTING_DATE","APP-OR0198 วันที่ได้รับการส่งต่อผู้ป่วยต้องมาก่อนวันรายงานผล"},
			{"REFERRAL_RECEIVED_DATE_BLANK"              ,  "APP-OR0199 ต้องใส่วันที่ได้รับการส่งต่อผู้ป่วย"},
			{"RECEIVE_REPORTING_PRACTITIONER_BLANK"      ,	"APP-OR0200 ต้องใส่บุคลากรทางการแพทย์ผู้รับรายงาน"},
			{"REPORTING_PRACTITIONER_BLANK"              ,  "APP-OR0201 ต้องใส่ชื่อบุคลากรทางการแพทย์ผู้รายงานผล"},
			{"REFERRAL_FACILITY_BLANK"                   ,	"APP-OR0202 ต้องใส่สถานที่การักษา"},
			{"REFERRAL_RECEIVED_DATE_LESSER_SYSDATE"     ,  "APP-OR0203 วันที่ได้รับการส่งต่อผู้ป่วยต้องมาก่อนวันปัจจุบัน"},
			{"PERFORMING_LOCATION_BLANK"                 ,	"APP-OR0204 ต้องใส่สถานที่รักษา"},
			{"PERFORMING_FACILITY_BLANK"                 ,	"APP-OR0205 ต้องใส่สถานที่รักษา"},
			{"DUPLICATE_ORDERABLES"                      ,	"APP-OR0206 ไม่สามารถบันทึกคำสั่งการรักษาซ้ำได้"},
			{"REPORTING_DATE_LESSER_ORDER_DATE"          ,	"APP-OR0207 วันที่รายงานผลต้องมาหลังจากวันที่สั่งการรักษา"},
			{"COL_SEQ_NO_NOT_BLANK"                      ,	"APP-OR0208 ไม่สามารถเว้นว่างหมายเลขคอลัมน์"},
			{"COL_NO_CANNOT_REPEATED_SAME_ROW"           ,	"APP-OR0209 ไม่สามารถใช้หมายเลขคอลัมน์ซ้ำในแถวเดียวกันได้"},
			{"CLINICAL_EVENT_BLANK"                      ,	"APP-OR0210 ไม่สามารถเว้นว่างเหตุการณ์ทางคลินิกได้"},
			{"ATLEAST_ONE_PRIVILEGE_VALUE"               ,  "APP-OR0211 ต้องเลือกสิทธิของท่านอย่างน้อย 1 อย่างสำหรับสิทธิเกี่ยวเนื่องประเภทนี้"},
			{"ATLEAST_ONE_PRIVILEGE_TYPE"                ,  "APP-OR0212 ต้องเลือกสิทธิของท่านอย่างน้อย 1 อย่างสำหรับสิทธิเกี่ยวเนื่อง"},
			{"ATLEAST_ONE_PRIVILEGE_TYPE_VALUE"          ,	"APP-OR0213 ต้องเลือกประเภทและชนิดของสิทธิอย่างน้อย 1 อย่าง"},
			{"DUPLICATE_ORGANISM"                        ,	"APP-OR0214 ค่า @ ไม่สามารถใช้ซ้ำได้"},
			{"DIAGNOSIS_EVENT_BLANK"                     ,	"APP-OR0215 ไม่สามารถเว้นว่างการวินิจฉัยโรคได้"},
			{"MAX_ORDERABLES"                            ,	"APP-OR0216 ไม่สามารถใส่การรักษาเกิน 10 อย่าง"},
			{"RESULT_TYPE_BLANK"                         ,	"APP-OR0217 ต้องใส่ค่าในตารางผลการตรวจ"},
			{"EXT_ORD_CAT_BLANK"                         ,	"APP-OR0218 ถ้าเลือกการรักษาต้องใส่หมวดคำสั่งการรักษา"},
			{"PRACT_RESP_NOT_COSIGN"                     ,	"APP-OR0219 บุคลากรทางการแพทย์ไม่สามารถลงนามกำกับ/ลงนามร่วมคำสั่งการรักษาได้" }, // Cosign Order
			{"ATLEAST_ONE_TAB_SELECTED"                  ,	"APP-ORO220 ควรเลือกคำสั่งรักษาอย่างน้อย 1 อย่าง"},
			{"EXISTING_ORDERS_TABNAME_NOT_BLANK"         ,  "APP-ORO221 ต้องใส่ชื่อ Tab สำหรับคำสั่งการรักษา"},
			{"NEW_ORDERS_TABNAME_NOT_BLANK"              ,	"APP-ORO222 ต้องใส่ชื่อ Tab สำหรับคำสั่งการรักษาใหม่"},
			{"EXISTING_ORDER_SEQNO_NOT_BLANK"            ,	"APP-ORO223 ต้องใส่หมายเลขลำดับสำหรับคำสั่งการรักษา"},
			{"NEW_ORDER_SEQNO_NOT_BLANK"                 ,	"APP-ORO224 ต้องใส่หมายเลขลำดับของคำสั่งการรักษาใหม่"},
			{"SOURCE_TYPE_BLANK"                         ,	"APP-OR0225 ต้องเลือกชนิดของสถานที่เก็บสิ่งส่งตรวจ"},
			{"MAX_LMT_PERIOD_MONTH"                      ,	"APP-OR0226 ระยะเวลาสูงสุดคือ 12 เดือน"},
			{"SEQ_NO_EXISTS"                             ,	"APP-OR0227 ไม่สามารถใช้หมายเลขลำดับซ้ำได้"},
			{"PH_NOT_ALLOWED"                            ,	"APP-OR0228 ไม่สามารถปรับปรุงรายการยาที่นี่ได้"},
			{"ATLEAST_ONE_DISCR_MEASURE"                 ,	"APP-OR0229 Atleast One record should have Discrete Measure."},
			{"EXT_ORD_TYPE_BLANK"                        ,	"APP-OR0230 ถ้าเลือกการรักษาต้องใส่ชนิดคำสั่งการรักษา"},
			{"BOOK_APPT_CATALOG"                         ,	"APP-OR0231 ท่านต้องการจองการนัดหมายสำหรับ"},
			{"CLINICAL_COMMENTS_BLANK"                   ,	"APP-OR0232 ไม่สามารถเว้นว่างรายละเอียดทางคลินิกได้"},
			{"PH_SELECT_NOT"                             ,	"APP-OR0233 ไม่สามารถเลือกรายการยาที่นี่ได้"},
			{"LB_ORDER_NOT_ALLOWED_SOURCE"               ,  "APP-OR0234 หน่วยงานนี้ไม่ได้รับอนุญาตให้สั่งการตรวจทางห้องปฏิบัติการ"},
			{"RD_ORDER_NOT_ALLOWED_SOURCE"               ,  "APP-OR0235 หน่วยงานนี้ไม่สามารถใช้คำสั่งการตรวจทางรังสีได้"},
			{"CP_START_DATE_TIME"                        ,	"APP-OR0236 ท่านต้องการเปลี่ยนแปลงวันเริ่มต้นหรือไม่"},
			{"BOOK_OT_APPT"                              ,	"APP-OR0237 ท่านต้องการจองการนัดหมายหรือไม่"},
			{"FREQUENT_NOT_SELECT"                       ,	"APP-OR0238 ไม่สามารถคำสั่งการรักษาที่ใช้บ่อยได้" }, // Order Entry
			{"ADMISSION_DATE_LESSER_SYSDATE"             ,  "APP-OR0239 วันที่รับไว้ในโรงพยาบาลต้องมาก่อนวันเวลาปัจจุบัน"},
			{"FORMAT_ITEM_CANNOT_BE_EMPTY"               ,  "APP-OR0240 ไม่สามารถเว้นว่างตัวเลือกรูปแบบได้" },
			{"CHECK_ATLEAST_ONE_CATEGORY"                ,  "APP-OR0241 เลือกอย่างน้อย 1 หมวด" },
			{"ATLEAST_ONE_SERVICE"                       ,	"APP-OR0242 ควรเลือกบริการอย่างน้อย 1 อย่าง" },
			{"ATLEAST_ONE_PRACTITIONER"                  ,	"APP-OR0243 ต้องเลือกบุคลากรทางการแพทย์อย่างน้อย 1 ท่าน" },
			{"ATLEAST_ONE_NUR_UNIT"                      ,	"APP-OR0244 ต้องเลือกหน่วยพยาบาล/หอผู้ป่วยอย่างน้อย 1 แห่ง" },
			{"ATLEAST_ONE_CLINIC"                        ,	"APP-OR0245 ต้องเลือกอย่างน้อย 1 คลินิก" },
			{"GREEN_TIME_IND_LESS"                       ,	"APP-OR0246 ควรให้ความสำคัญต่อเครื่องหมายสีเหลืองก่อนสีเขียว" },
			{"YELLOW_TIME_IND_GREATER"                   ,	"APP-OR0247 ควรให้ความสำคัญต่อเครื่องหมายสีเหลืองก่อนสีเขียว" },
			{"YELLOW_TIME_IND_LESS"                      ,	"APP-OR0248 ควรให้ความสำคัญต่อเครื่องหมายสีแดงก่อนสีเหลือง" },
			{"RED_TIME_IND_SHUD_GREATER"                 ,	"APP-OR0249 ควรให้ความสำคัญต่อเครื่องหมายสีแดงก่อนสีเหลืองหรือเขียว" },
			{"CONSENT_TO_BE_OBTAINED"                    ,	"APP-OR0250 ต้องขอบันทึกคำยินยอมของผู้ป่วยก่อนสั่งการรักษา" },
			{"ATLEAST_ONE_PROC_CODE"                     ,	"APP-OR0251 ต้องเลือกรหัสของหัตถการอย่างน้อย 1 รหัส" },
			{"MORE_CODES_NOT_SELECT"                     ,	"APP-OR0252 สามารถเลือกได้สูงสุด 10 รหัส" },
			{"MULTI_PRESENTATION_CANNOT_BE_SELECTED"     ,	"APP-OR0253 ไม่สามารถเลือกการแสดงผลแบบหลากหลายได้" },
			{"REFERRAL_RECORD_NOT_FOUND"                 ,	"APP-OR0254 ไม่พบบันทึกการส่งต่อผู้ป่วย" },
			{"REFERRAL_MORE_THAN_ONE_RECORD"             ,  "APP-OR0255 พบบันทึกในการส่งต่อผู้ป่วยมากกว่า 1 ฉบับ" },
			{"NEW_ORDER_CATALOG_BLANK"                   ,	"APP-OR0256 ต้องใส่คำสั่งการรักษา" },
			{"NEW_CHARGE_TYPE_BLANK"                     ,	"APP-OR0257 ต้องลงประเภทของการจ่ายเงิน" },
			{"CHARGE_TYPE_NOT_SAME"                      ,	"APP-OR0258 ชนิดของ" },
			{"CHANGE_CHARGE_TYPE_NO_ACCESS"              ,  "APP-OR0259 ไม่มีสิทธิเข้าใช้งาน" },
			{"COMPLETE_DATE_TIME_CANNOT_BLANK"           ,	"APP-OR0260 ไม่สามารถเว้นว่างวันที่สั่งการรักษาไปแล้ว" }, // Order completion
			{"COMPLETE_DATE_TIME_START_DATE_TIME_CHK"    ,  "APP-OR0261 วันที่สั่งการรักษาควรมาหลังจากวันเริ่มต้น" }, // Order completion
			{"COMPLETE_DATE_TIME_SYSDATE_TIME_CHK"       ,	"APP-OR0262 วันที่สั่งการรักษาควรมาก่อนวันของระบบ" }, // Order completion
			{"FUTURE_ORDER_ACTIVATED_LINKED"             ,  "APP-OR0263 จะนำคำสั่งการรักษาล่วงหน้ามาใช้ในการรักษาคราวนี้หรือไม่" }, // Future Order
			{"FUTURE_ORDER_ACTIVATED_CURRENT"            ,	"APP-OR0264 Oคำสั่งการรักษาถูกนำมาใช้ในการรักษาคราวนี้" }, // Orders Activated
			{"FUTURE_ORDER_NOTACTIVATED_CURRENT"         ,	"APP-OR0265 ไม่สามารถนำคำสั่งการรักษาล่วงหน้ามาใช้ในการรักษาคราวนี้ได้" }, // Orders cannot be Activated
			{"CONTINUE_RESULT_REPORT"                    ,	"APP-OR0267 ต้องการรายงานผลต่อหรือไม่" }, 
			{"PROCEDURE_LINK_MAND"                       ,	"APP-OR0268 ต้องใส่ส่วนการเชื่อมโยงหัตถการ" }, 
//			{"INVALID_DATE_TIME_FORMAT"                  ,  "APP-OR0269 Invalid Date and Time Format. Valid entry dd/mm/yyyy hh:mi:ss_th" },
			{"OT_MODULE_INSTALLED"                       ,	"APP-OR0270 ไม่สามารถใช้ฟังก์ชั่นนี้ได้ โปรดเลือก OT Surgery Module" }, // Register order and Result Reporting
			{"OR_STATUS_CHANGED"					     , 	"APP-OR0271 Cannot Perform this Opeartion. Since Order Status has been Changed by Some Other User"},
//			{"OR_REPORT_PRACT_CHANGE_TO_OTHER"		     ,	"APP-OR0272 Continue with the Same Reporting Practitioner for Other Results_th"},
//			{"OR_ORDER_TRACKING_MANDATORY"			     ,	"APP-OR0273 Specify Atleast One Search Criteria among Order Type, Patient Id, Location_th"},
//			{"DUPLICATE_FIELD_MNEMONIC"					 ,	"APP-OR0274 Duplicate Value for the Field Mnemonic_th "                            }, 												  
/*			{"VALU_RANGE"					             ,	"APP-OR0275 Entered value should be between " +min_num_value+" and "+max_num_va }, 												  */
//			{"OPTION_SELECTED"					         ,	"APP-OR0276 Option cannot be selected again_th...."                               }, 				
			{"PRINT_LOC1_AND_LOC2"					     ,	"APP-OR0277 ต้องเลือกสถานที่ปลายทางสำหรับพิมพ์คำสั่งการรักษาปกติ"     }, 			
			{"PRINT_DEST_URG_START"					     ,	"APP-OR0278 ต้องเลือกสถานที่ปลายทางสำหรับพิมพ์คำสั่งการรักษาด่วน"    }, 
			{"PRINT_DEPT_AT_LOC1_LOC2"					 ,	"APP-OR0279 ต้องเลือกภาควิชาสำหรับพิมพ์คำสั่งการรักษาปกติ"      }, 												  
			{"PRINT_DEPT_URG_START"   					 ,	"APP-OR0280 ต้องเลือกภาควิชาสำหรับพิมพ์คำสั่งการรักษาด่วน"     }, 												  
			{"PRINT_AT_OTHER_LOC"					     ,	"APP-OR0281 ต้องเลือกสถานที่สำหรับพิมพ์คำสั่งการรักษาปกติ"  }, 												  
			{"PRINT_AT_OTHER_URG_START"					 ,	"APP-OR0282 ต้องเลือกสถานที่สำหรับพิมพ์คำสั่งการรักษาด่วน" }, 												  
			{"START_TIME"					             ,	"APP-OR0283 ต้องบันทึกเวลาที่เริ่ม"                                         },
		 	{"START_DATE"				                 ,	"APP-OR0284 ต้องบันทึกวันที่เริ่ม"                                         },
//			{"IMAGE_LINK_ALREADY_EXISTS"				 ,  "APP-OR0285 Image Link already exists_th"},
//			{"ORDER_ID_GENERATION_PATIENT"               ,  "APP-OR0286 Order Id Generation For the Patient"},
//		    {"DUPLICATE_SEQ_NO"                          ,  "APP-OR0287 Duplicate Sequence number exists"},
  //   		{"VERIFICATION_SUCCESS"                      ,  "APP-OR0288 Verification Successful"},
//			{"DUPLICATE_VALUES"                          ,  "APP-0R0289 Duplicate values are passed"},
//		    {"RECORD_INSERTED"							 ,  "APP-OR0285 Operation Completed Successfully......_th" },
//		    {"RECORD_MODIFIED"							 ,  "APP-OR0286 Operation Completed Successfully......_th" },
//		    {"RECORD_DELETED"							 ,  "APP-OR0287 Operation Completed Successfully......_th" },
//			{"CODE_ALREADY_EXISTS"						 ,  "APP-OR0288 Record Already Exists......" }

			{"NUM_CANT_bLANK"					         ,     "APP-OR0290 ไม่สามารถเริ่มหมายเลขจาก 0"},
//			{"ONLY_POSITIVE_INTEGERS"					 ,		"APP-OR0291 Only positive integers are allowed exculding zero_th"},
//			{"SEQUENCE_NUMBER_FOR_CHKBOX"              	,       "APP-OR0292 Sequence no's for Check Box Checked should be filled_th"},
//		    {"DELETE_CONFIRM"                            ,      "APP-OR0293 Are you sure you want to delete this record_th"},
///	    	{"CONFIRM_ZOOM"                              ,      "APP-OR0294 Would you like to view the editor in Zoom mode ?_th"},
	//		{"CONFIRM_COPY"                              ,      "APP-OR0295 Cannot copy this Orderable. Do you wish to continue?_th"},
	//		{"FACILITY_BLANK"                            ,      "APP-OR0296 Facility cannot be blank......._th"},
	//		{"SERVICE_BLANK"                             ,      "APP-OR0297 Service cannot be blank..._th"},
			{"TRY_AFTER"					             ,	    "APP-OR0298 โปรดรอสักครู่แล้วลองอีกครั้งหนึ่ง"                                                       }, 	
	//		{"TIMENOTCORRECT"                            ,      "APP-OR0299 Time Not Correct_th"},
			{"VIEW_CONFIRM"                              ,   	"APP-OR0300 Do You Want to View Other Records... Current Selected Data Will be Lost"},
    //		{"CANNOT_SYNC"	                             ,      "APP-OR0301 Cannot Sync......_th"},
	//	    {"CHECK_ANY_ONE"                             ,       "APP-OR0302 Check any one_th"},
	//		{"NO_OF_CHARACTERS"                          ,	    "APP-OR0302 The number of characters cannot exceed "},
			{"DO_WANT_VIEW"					             ,	    "APP-OR0303 ท่านต้องการดูหรือไม่"                                                          }, 												  
	  //  	{"NEW_ORDERS_SHOULD_BE_SELECTED"             ,    	"APP-OR0304 New Orders should be selected"},
		//    {"PRIVILEGE_LEVEL_BLANK"                     ,      "APP-OR0305 Privilege Level cannot be blank"},
	//	    {"CONFIRM_SEND"                            	,       "APP-OR0306 Do you want to Send Out?"},
	//	    {"CONFIRM_RESULT"	                         ,      "APP-OR0307 Do you want to Result?"},
	//	    {"DATE_MORE_THAN_SYS_DATE"                   ,      "APP-OR0308 Date should be greater than or equal to Current Date"},
	//		{"REASON_CANT_BLANK"					     ,	    "APP-OR0309 Reason Can not be Blank..."                                                    }, 												  
			{"NUM_OF_CHARACTERS"					     ,	    "APP-OR0310 บันทึกได้สูงสุด 255 ตัวอักษร"                                               },   
			{"NAME_BLANK"					             ,	    "APP-OR0311 ต้องใส่ชื่อเสมอ"                                            }, 												  
			{"CONSENT_NOTE_CANT_BLANK"					 ,	    "APP-OR0312 ต้องมีบันทึกคำยินยอมของผู้ป่วย"                                   }, 						  
	//		{"DATE_COMPARE"					             ,	    "APP-OR0313 Date should be less than or equal to System Date"                 },  												  
			{"FIELD_MNEMONIC_START_WITH"				 ,	     "APP-OR0314 ไม่สามารถเริ่มฟิลด์ช่วยจำด้วยตัวเลขได้"                               }, 								  
	//		{"WRONG_ACSSESS"					         ,	     "APP-OR0315 Wrong Acssess....."                                                            }, 												  
	//		{"FROM_VISIT"	                             ,        "APP-OR0316 from visit admin:"                                                            },
	//		{"COMMENT_CANT_EXCEED_255"		             ,		 "APP-OR0317 Comment cannot exceed 255 characters"                             },
	//		{"DATE_LESS_SYS_DATE"		                 ,		 "APP-OR0318 Date should be less than or equal to System Date"                 },
			{"TEXT_CANT_EXCEED_255"			             ,		 "APP-OR0319 บันทึกได้สูงสุด 255 ตัวอักษร"                               },
			{"REMARK_CANT_EXCEED_255_CHAR"				 ,	     "APP-OR0320 Remark cannot exceed 255 characters."                             },
//		    {"NO_MORE_MNEMONICS_SELECTED"					,		"APP-OR0321 No More Mnemonics can be selected"},
			{"REPORTING_DATE_BLANK"                      ,	"APP-OR0322 APP-OR0322 ต้องใส่วันที่รายงานผล"},
//			{"CHECK_ANY_ONE"                             ,      "APP-OR0323 Check any one"},
//			{"TEXT_MAX"                                  ,      "APP-OR0324 Text cannnot exceed {1} characters"},
//			{"PRINT_CONFIRM"                             ,      "APP-OR0325 Would you like to print this report"},
//			{"CONFIRM_ABNORMAL_RESULT"                   ,      "APP-OR0326 Do you want see  Abnormal Result Only ?"},
//			{"CONFIRM_COMPLETE_REVIEW"                   ,      "APP-OR0327	Do you want to complete the review?"},
			{"REFUSAL_TYPE"                              ,      "APP-OR0328 ต้องลงประเภทของการปฏิเสธ"},
			{"MAX_LIMIT_TEXT"					         ,	    "APP-OR0329 บันทึกได้สูงสุด 255 ตัวอักษร"  },
			{ "ATLEAST_ONE_DEFAULT"						 ,	"APP-OR0330 ATLEAST_ONE_DEFAULT TO BE SELECTED....."   } ,
			{ "NO_RECORDS_TO_RECORD"					,	"APP-OR0331 No Records to Record the Results"},
			{ "ATLEAST_ONE_CONSENT"						,	"APP-OR0332 Atleast One Consent Should be Selected"},
			{ "OR_ORDER_CATALOG_MULTICONSENT_MANDATORY"						,	"APP-OR0333 Please enter all the required Mandatory Consents"},
			{ "OR_ORDER_CATALOG_MULTICONSENT_CHECKBOX"						,	"APP-OR0334 Please select atleast one Select Checkbox for the entered Consent"},
			{ "OR_ORDER_CATALOG_MULTICONSENT"						,	"APP-OR0335 Please select a Valid Consent"},
			//Added by Prasad on 09/05/2007 start
			{ "NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REALEASE_EXC_SPEC_COUNT"						,	"APP-OR0336 No of Consent to be Recorded Before Order Release Exceeds the Specified Count"},
			{ "NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REGISTRATION_EXC_SPEC_COUNT"						,	"APP-OR0337 No of Consent to be Recorded Before Order Registration Exceeds the Specified Count"},
			{ "ASSIGN_CONSENT_FORM_TO_RECORD"						,	"APP-OR0338 Please Assign a Consent Form to Record"},
			{ "DUPLICATE_CONSENT_FORM_NOT_ALLOWED"						,	"APP-OR0339 Duplicate Consent Form are Not Allowed"},
			{ "UNCHECK_CONSENT_FORM_CLEAR_ENTERED_CONSENT"						,	"APP-OR0340 Unchecking the Consent Form will Clear the Entered Content"},
			{ "CHANGING_CONSENT_FORM_CLEAR_ENTERED_CONSENT"						,	"APP-OR0341 Changing the Consent Form will Clear the Entered Content"},
			{ "NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REALEASE_LESS_THAN_SPEC_COUNT"						,	"APP-OR0342 No of Consent to be Recorded Before Order Release is Less Than the Specified Count"},
			{ "NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REGISTRATION_LESS_THAN_SPEC_COUNT"						,	"APP-OR0343 No of Consent to be Recorded Before Order Registration is Less Than the Specified Count"},
			{ "NO_OF_CONSENT_RECORDED_BEFOR_BEFOR_ORDER_REALEASE_AND_ORDER_REGISTRATION_LESS_THAN_SPEC_COUNT"						,	"APP-OR0344 No of Consent to be Recorded Before Order Release and Before Registration is Less Than the Specified Count"},

			//Added by Prasad on 09/05/2007 End
			//added by uma on 5/10/2007
    		{"ATLEAST_ONE_CONSENT_FORM_SHOULD_BE_SELECTED_OR_DEFINED"						,	"APP-OR0345 Atleast One Consent Form Should be Selected or Defined"},
			{"CONSENT_FORM_SELECTED_IS_ALREADY_RECORDED"						,	"APP-OR0346 Consent Form Selected is Already Recorded"},
			{"YOU_ARE_NOT_ELIGIBLE_TO_RECORD_THIS_CONSENT"						,	"APP-OR0347 You are Not Eligible to Record this Consent"},
			{"CHECK_ATLEAST_ONE_CONSENT_FORM_TO_RECORD"						,	"APP-OR0348 Check Atleast One Consent Form to Record"},
			{"CHECK_DATE_ORDERID_PATIENTID"						,	"APP-OR0349 Check! Either date range should be with in a month or Patient ID or Order ID should be entered."},
			{"OR_ORDER_CATALOG_CONSENT_REQUIRED"			,	"APP-OR0350 Total number Of Consent Required should be more than one"},
			{"OR_PRIVILEGE_GROUP_COPY_FROM"			,	"APP-OR0351 No values to copy from  "},
			{"OR_PRIVILEGE_GROUP_UNDO"			,	"APP-OR0352 Unable to perform undo operation_th "},
			{"INVALID_BLOOD_TRANS_EXPECTED_DATE"			,	"APP-OR0353 Invalid Blood Transfusion Expected Date_th "},
			{"FUTURE_ORDER_DURATION"			,	"APP-OR0354 Future Order Duration Cannot Be Blank_th "},
			{"CONSENT_FOR_BEFORE_REGISTERATION"			,	"APP-OR0355 Consent For Before Registeration is Recorded_th "},
			{"CONSENT_FOR_BEFORE_RELEASE"			,	"APP-OR0356 Consent For Before Release is Recorded_th "},
			{"BEFORE_ORDER_RELEASE_CANNOT_BE_MORE_THAN","APP-OR0357 Before Order Release cannot be more than_th :: "},
			{"BEFORE_ORDER_REGISTRATION_CANNOT_BE_MORE_THAN","APP-OR0358 Before Order Registeration cannot be more than_th  ::"},
			//Added by prasad
			{"CONSENTS_RECORD_MORE_THAN_COUNT"			,	"APP-OR0359 No of Consent to be Recorded Exceeds the Specified Count_th"},
			{"CONSENTS_RECORD_LESS_THAN_COUNT"			,	"APP-OR0360 No of Consent to be Recorded Less than the Specified Count_th"},
			{ "NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REALEASE_MORE_THAN_SPEC_COUNT"						,	"APP-OR0361 No of Consent to be Recorded Before Order Release is More Than the Specified Count_th"},
			{ "NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REGISTRATION_MORE_THAN_SPEC_COUNT"						,	"APP-OR0362 No of Consent to be Recorded Before Order Registration is More Than the Specified Count_th"},
			{ "DUPLICATE_CONSENTS_NOT_ALLOWED"	,"APP-OR0363 Duplicate Consent Form are Not Allowed_th"},
			{ "SPECAILTY_SHOULD_NOT_BLANK"	,"APP-OR0364 Speciality Should not be blank"},
			{ "BILLING_SERVICE_NOT_DEFINED"	,"APP-OR0365 Billing Service not defined for {1} and cannot be included for place order_th"},
			{ "NO_OF_CONSENTS_TO_BE_RECORD_ARE_MORE_THAN_REQUIRED"	,"APP-OR0366 No.of Consents to be record are more than Required_th"},
			{ "NO_OF_CONSENTS_TO_BE_RECORD_ARE_MORE_THAN_REQUIRED"	,"APP-OR0366 No.of Consents to be record are more than Required"},
			{ "NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REALEASE_MORE_THAN_SPEC_COUNT"						,	"APP-OR0367 No of Consent to be Recorded Before Order Release is More Than the Specified Count"},
			{ "NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REGISTRATION_MORE_THAN_SPEC_COUNT"						,	"APP-OR0368 No of Consent to be Recorded Before Order Registration is More Than the Specified Count"},
			{ "DELETE_NOT_ALLOWED"						,	"APP-OR0369  The list value marked for delete cannot be deleted! - Delink from Order Catalog and try."},
			{ "ORDERTRACKING_SEARCH_VALIDATE",	"APP-OR0370 Atleast one of the below condition should be true. \n1. Patient ID  entered.\n2. Status is -All-  and the period range is one day.\n3. Status is not -All- and period range is max of one week. "},
			{ "REGORDER_SEARCH_VALIDATE",	"APP-OR0371 Atleast one of the below condition should be true. \n1. Patient ID  entered.\n2. Order ID  entered.\n3. Period range is max of one week.\n4. Order Category is selected  and the period range is within one month."},
			{ "ORDER_SET_EXPLN_TEXT",	"APP-OR0372 View Order Set Details"},
			{"UPDATE_FUTDAT_CURRDAT_SPECIMEN","APP-OR0449 This action will update the Start Date/Time of the selected future order to Current Date/Time. Click on OK to confirm and RECORD to complete the action."}, //CRF 360 //IN041138
{"ORDER_ALREADY_VERIFIED"         ,				"APP-OR0450 Order status changed, cannot proceed..." },//IN043143
			{"MAND_CHECK"         ,				"APP-OR0451 Please select atleast one Privilege Group..." },  // LICN_1
			{"DUP_REASON_REQD"         ,				"APP-OR0452 Duplicate Override reason is mandatory..." },  // IN024984
			{"OR_ORDERING_RULE_CHK"         ,		"APP-OR0454 Ordering rule setup exists, cannot proceed... " },  // IN050607
			{"PERIOD_SHOULD_LESS_THAN_YEAR", "APP-OR0455 The selected period should not be more than a Year" }, //IN054381
			{"SPECIMENNO_SELECTED", "APP-OR0456 Specimen no is selected..." }, // IN055737 HSA-CRF-0250.1
			{"SPECIMENNO_IS_NOT_AVAIL", "APP-OR0457 Selected Specimen no is not available in the list..." }, // IN055737 HSA-CRF-0250.1
			{"SPECIMENNO_ALREADY_SELECTED", "APP-OR0458 Selected Specimen no is already added in the list..." }, // IN055737 HSA-CRF-0250.1
			{"SPECIMEN_COLLECTION_ORDER_DATE_WARN",	"APP-OR0459 Date should be greater than or equal to Ordered Date for the Order $$. \n Please Uncheck and check the Auto-Update Collection Date and Time again to continue..."}, //MMS-MD-SCF-0017 [IN060516]
			{"UPDATE_FUTDAT_CURR_SPECIMEN_DATE","APP-OR0460 This action will update the Start Date/Time of the selected future order to Specimen Collection Date/Time. Click on OK to confirm and RECORD to complete the action."}, //IN059646
			{"NOT_AUTHORIZED_TO_VIEW_CONFIDENTIAL_RESULT","APP-OR0461 You are not authorized to view Confidential Result."}, //IN064215
			{"BARCODE_RPT_SUBMIT_TO_PRINTER"       ,				"APP-OR0462 Barcode report has been Submitted to the Printer" }, //IN063816
			{"AGE_WISE_DATA_REQUIRED"       ,				"APP-OR0463 At least one age group must be included" },//IN062992
			{"TIME_FRAME_EMPTY_ALERT","APP-OR0464 Time duration shall not be blank. Please enter the Numeric value" },//IN061892
			{"RECORD_INSERTED","APP-OR0466 Operation Completed Successfully" },//IN065642
			{"OR_DATE_RANGE","APP-OR0467 Date range exceeds a month period." },//IN065642
			{"REPORINGFACILITYBLANK","APP-OR0467 Please select the Reporting facility." },//IN065642
			{"NO_RECORDS_HAVE_BEEN_SELECTED","APP-OR0468 No records have been selected!!!" },//IN065642
			{"ASSIGNEDPRACTATIONERBLANK","APP-OR0469 Please select the Assign radiologist." },//IN065642
			{"ORDER_RESTRICT_AE_AND_OP_ENCOUNTER","APP-OR0470 Patient has an active admission. Orders for Open AE encounter cannot be placed"},//IN063719
			{"OCC_NO_CANNOT_BLANK","APP-OR0471 Occurance no cannot be blank" },//IN68241
			{"DUPLICATE_OCC_NO","APP-OR0472 Contains duplicate Occurrance No" },//IN68241
			{"DUPLICATE_OCC_NO_SHLD_NOT_SELECT","APP-OR0473 Duplicate Occurrance No cannot be selected" },//IN68241
			{"MULTI_DOSAGE_TYPE_CONFIG","APP-OR0474 This catalog has multi Dosage Type configuration" },//IN68241
			{"ORDERSET_INCORRECT_CATALOG_COMB","APP-OR0475 Selected order catalogs not assigned to selected facilitty, so cannot create order set" },//IN068370,IN068373
			{"ATLEAST_ONE_FAC_SHLD_BE_MAPPED","APP-OR0476 Atleast one facility should be mapped" },//IN068370,IN068373
			{"ATLEAST_ONE_SPECIALTY_TO_BE_SELECTED","APP-OR0477 At least one Specialty to be selected" },//IN69021
			{"ATLEAST_ONE_ORDER_CATEGORY_TO_BE_SELECTED","APP-OR0478 At least one Order Category to be selected" },//IN69021
			{"ATLEAST_ONE_PATIENT_CLASS_TO_BE_SELECTED","APP-OR0479 At least one Patient Class to be selected" },//IN69021
			{"DIAG_NOT_RECORDED","APP-OR0480 Patient Diagnosis not recorded, please complete to proceed further." },//IN69027
			{"NO_VIDEO_FILES_TO_LINK","APP-OR0477 No Video Files to Link" }

		//end
			/*{"APP_SM0002_OPERATION"					     ,     "APP-SM0002 Operation Completed Successfully..."						  
												  
			{"OPERATION_STATUS"					         ,	    "APP-SM0002 Operation Completed Successfully ..."                               }, 				
									  
			{"TIME_NOT_CORRECT"					         ,	    "Time Not Correct"                                                              }, 												  
			{"CANT_SYNC"			 		             ,	    "Cannot Sync......"                                                             }, 															  
			{"RUN_CLICKED"								 ,		 "run clicked"                                                                   },
			{"INVALID_TIME_FORMAT"						 ,		 "Invalid Time Format"                                                           },


			{"VERIFICATION_SUCC"						 ,	     "Verification Successful"                                                       },

			{"OPERATION_COMPLETE"						 ,		 "APP-SM0002 Operation Completed Successfully..."                                },

			*/
			};
}
		
					
			
										                                                   