/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT.resources;

import java.util.*;

public class Messages_th extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = {
			{"CANNOT_BE_BLANK",				"APP-OT0001 ต้องบันทึก & "},//APP-OT0001
			{"CANNOT_BE_ZERO",				"APP-OT0002  & ต้องไม่เป็นศูนย"},//APP-OT0002์
			{"OT_MANDATORY",				"APP-OT0003  ต้องกรอกช่องข้อมูลที่จำเป็นให้ครบ"},//APP-OT0003
			{"DATE1_NOT_LESSER_THAN_DATE2",	"APP-OT0004 # should not be less than #..."},
			{"DATE1_NOT_GREATER_THAN_DATE2","APP-OT0007 # should not be greater than # ..."},
			{"INVALID_USER_FUNCTION",		" ไม่สามารถใช้งานในหัวข้อนี้ได้"},//APP-OT0005้
			{"VALID_TIME_SLOTS",			"APP-OT0006 จำนวนที่บันทึกต้องอยู่ระหว่าง 00:00 และ 23:59"},//APP-OT0006
			{"MIN_ONE_OPER_FOR_SPECIALITY",	"APP-OT0008 อย่างน้อย 1 การกระทำต้องเข้ากับสาขาเฉพาะทางนั้น"},//APP-OT0008 
			{"NUMERIC_ENTRY_ONLY",			"APP-OT0011 Numeric only allowed in sequence"},//APP-OT0011 Numeric only allowed in sequence;
			{"MONTH_COMPARE_CURMONTH",		"APP-OT0019 Preferred Month/Year should not be less than Current Month/Year..."},//APP-OT0019
			{"TIME_LESS_THAN",				"APP-OT0023 เวลาที่เลือกเป็นเวลาก่อนเวลาปัจจุบัน"},//APP-OT0023
			{"MAX_LENGTH_DATA",				"APP-OT0025 # Remarks should not more than # characters"},
			{"INCOMPLETE_CHECKLIST",		"APP-OT0O28 CheckList ยังไม่เสร็จสมบูรณ์"},//APP-OT0O28 
			{"SPECIALITY_DUPLICATE",		"APP-OT0031  สาขาเฉพาะทางไม่สามารถซ้ำกันได"},//APP-OT0031้
			{"APP-OT0034","APP-OT0034  ไม่อนุญาตให้ Theatre Date > Current Date \n # is not Allowed!"},//APP-OT0032
			{"APP-OT0036","APP-OT0036 ควรบันทึกศัลยแพทย์หรือสาขาเฉพาะทางหรือหัตถการ"},//APP-OT0034 
			{"APP-OT0037","APP-OT0037 ควรบันทึกวันหรือเดือนที่ต้องการ"},//APP-OT0035 
			{"APP-OT0038","APP-OT0038 การผ่าตัดนี้ไม่ต้องใช้การวางยาสลบ"},//APP-OT0036
			{"APP-OT0040","APP-OT0040 'ชั่งโมง'ไม่ถูกต้อง ควรอยู่ระหว่าง 00 - 23"},//APP-OT0038 
			{"APP-OT0041","APP-OT0041 'นาที'ไม่ถูกต้อง ควรอยู่ระหว่าง 00 - 59"},//APP-OT0039 
			{"APP-OT0046","APP-OT0046 เลือก'หมายเลขของรายชื่อ'ที่ถูกต้อง"},//APP-OT0044 
			{"APP-OT0047","APP-OT0047 Serial number ควร > 0"},//APP-OT0045 
			{"APP-OT0050","APP-OT0050 Set และ Tray combination นี้มีอยู่แล"},//APP-OT0048 ้ว
			{"APP-OT0053","APP-OT0053 การผ่าตัดนี้ไม่สามารถทำได้ที่ห้อง # "},//APP-OT0051 
			{"APP-OT0054","APP-OT0054 เลือกห้อง ก่อนลงบันทึกผ่าตัด"},//APP-OT0052 
			{"APP-OT0056","APP-OT0056 การผ่าตัดนี้ไม่ต้องใช้การวางยาสลบก่อนผ่าตัด"},//APP-OT0054 
			{"APP-OT0057","APP-OT0057  การผ่าตัดนี้ไม่ต้องใช้การวางยาสลบก่อน/ขณะผ่าตัด"},//APP-OT0055
			{"APP-OT0058","APP-OT0058 ไม่ได้เลือก'การจอง'ไว"},//APP-OT0056 ้
			{"APP-OT0060","APP-OT0060 'วันที่' ไม่ควรเป็นหลังวันที่ทำสมุดบันทึก 'ถึงวันที'"},//APP-OT0058 
			{"APP-OT0062","APP-OT0062 ไม่ได้กำหนดตารางนัดของศัลยแพทย์ในตำแหน่งนี้"},//APP-OT0060 ้
			{"APP-OT0063","APP-OT0063  หมายเลขไม่ถูกต้อง"},//APP-OT0061
			{"APP-OT0064","APP-OT0064 สัญลักษณ์ - ควรอยู่หน้าตัวเลข"},//APP-OT0062 
			{"APP-OT0065","APP-OT0065  ไม่สามารถลดจำนวนไปมากกว่าจำนวนรวม  # ได้ "},//APP-OT0063
			{"APP-OT0068","APP-OT0068 # cannot be less than or equal to ZERO"},
			{"APP-OT0070","APP-OT0070 เวลา check out ไม่ควรเป็นวันเดียวกับวันที่ของระบบหรือก่อนหน้านั้น"},//APP-OT0068 
			{"APP-OT0071","APP-OT0071 # ยังไม่ทำ/ยังไม่เสร็จ"},//APP-OT0069 
			{"APP-OT0072","APP-OT0072 ไม่มีสิทธิ์เปลี่ยนแปลงระดับน"},//APP-OT0070ี้
			{"APP-OT0073","APP-OT0073 ช่องที่เลือกไม่มีในสาขาเฉพาะทาง # นี้ ต้องการดำเนินการต่อหรือไม่?"},//APP-OT0071
			{"APP-OT0074","APP-OT0074  ต้องการจองหรือไม่?"},//APP-OT0072
			{"APP-OT0075","APP-OT0075 Do you want to bring waitlisted patient to the vacated slot"},
			{"APP-OT0077","APP-OT0077 ผู้ป่วยรายนี้มีนัดวันนี้อยู่แล้ว ต้องการดำเนินการต่อหรือไม่?"},//APP-OT0075 
			{"APP-OT0078","APP-OT0078 ข้อมูลยังไม่เสร็จสมบูรณ์ ต้องการดำเนินการต่อหรือไม่?"},//APP-OT0076
			{"APP-OT0079","APP-OT0079 ต้องการดำเนินการต่อหรือไม่?"},//APP-OT0077
//newly added messages
			{"APP-OT0080","APP-OT0080 This Operation & Cannot be Performed in "},
			{"APP-OT0081","APP-OT0081 Patient $ is being Rescheduling for & Time(s)"},
			{"APP-OT0082","APP-OT0082 Operation Failed..."},
			{"APP-OT0083","APP-OT0082 Do you want to delete the existing Patient appointment schedule..."},
			//{"APP-OT0083","APP-OT0083 Please Apply the Changes..."},
			{"APP-OT0084","APP-OT0084 Welcome to eHIS"},
			{"APP-OT0085","APP-OT0085 No Associated ICDPCS code for Mandatory Operation"},
			{"APP-OT0086","APP-OT0086 Values are not entered for "},
			{"APP-OT0087","APP-OT0087 Remarks are mandatory for Discrepancies in "},
			{"APP-OT0088","APP-OT0088 # is not entered.. "},
			{"APP-OT0089","APP-OT0089 No Consent Details to View "},
			{"APP-OT0090","APP-OT0090 ผู้ใช้งานไม่ได้รับสิทธิให้ทำการยกเลิกหรือเลื่อนการจองการผ่าตัด "},
			{"APP-OT0090C","APP-OT0090C User  is  Not  Authorized  to  Cancel the Appointment "},
			{"APP-OT0090T","APP-OT0090T User  is  Not  Authorized  to  Transfer the Appointment "},
			{"APP-OT0091","check list ใช้ไม่ได้กับ order นี้ "},			
			{"APP-OT0092","APP-OT0092 ผู้ใช้ระบบไม่ได้รับสิทธิให้ทำการจองการผ่าตัด"},
			{"APP-OT0093","APP-OT0093 ผู้ป่วยปฏิเสธการผ่าตัดชนิดนี้ ไม่สามารถดำเนินการต่อได้ "},
			//{"APP-OT0094","APP-OT0094 รายละเอียดการผ่าตัดยังไม่ได้ถูกบันทึก"},
			{"APP-OT0094","APP-OT0094 Procedure Coding Details are not entered \n for an Operation "},
			{"APP-OT0095","APP-OT0095 ต้องบันทึกชื่อศัลยแพทย์อย่างน้อย 1 ชื่อ เอกสารจึงจะสมบูรณ์ "},		
			{"APP-OT0096","APP-OT0096 ต้องระบุการผ่าตัดสำหรับสาขาเฉพาะทางนี้อย่างน้อย 1 ชนิด"},
			{"APP-OT0097","APP-OT0097 ต้องระบุการผ่าตัดสำหรับกลุ่มสาขาเฉพาะทางนี้อย่างน้อย 1 ชนิด"},
			{"APP-OT0098","APP-OT0098 Select The Applicable Position And Create atleast One user."},
			{"APP-OT0099","APP-OT0099 ต้องเลือกผู้ใช้ระบบอย่างน้อย 1 ชื่อ"},
			{"APP-OT0100","APP-OT0100 เลือกจำนวนครั้งของการยืนยันสำหรับ Pre-op check list."},
			{"APP-OT0101","APP-OT0101 เลือกจำนวนครั้งของการยืนยันสำหรับ  Post-op check list"},
			{"APP-OT0102","APP-OT0102 เปลี่ยน Specific Indicator เป็น All Users แล้ว Apply"},
			{"APP-OT0103","APP-OT0103 # ต้องน้อยกว่า  #"},
			{"APP-OT0104","APP-OT0104 pick list ถูกสร้างขึ้น"},				
			{"APP-OT0105","APP-OT0105 ต้องเลือกอย่างน้อย 1 สัปดาห์"},				
			{"APP-OT0106","APP-OT0106 ผู้ป่วยได้รับการนัดทำ wait list"},
			{"APP-OT0107","APP-OT0107 ยังไม่ได้รับใบยินยอมรับการรักษา"},
			{"APP-OT0108","APP-OT0108 ยกเลิกการนัด wait list"},
			{"APP-OT0109","APP-OT0109 Time Slot Overlaps."}, // from 2nd November
			{"APP-OT0110","APP-OT0110 Entered Time should be a multiple of OT Unit Time "},
			{"APP-OT0111","APP-OT0111 Entered Time Should fall within the Booking Range of # to # on working days "},
			{"APP-OT0112","APP-OT0112 Entered Time Should fall within the Booking Range of # to # on Holidays "},
			{"APP-OT0113","APP-OT0113 This time slot should be greater than the previous time slot"},
			{"APP-OT0114","APP-OT0114 # should not be more than # character "},
			{"APP-OT0115","APP-OT0115 Entered Time Should be multiples of OT Unit Time... "},
			{"APP-OT0116","APP-OT0116 Only one item value can be set as default "},
			{"APP-OT0117","APP-OT0117 Operative Notes is not entered... "},
			{"APP-OT0118","APP-OT0118 Do you want to create the Order Catalog for this Operation/Procedure? "},
			{"APP-OT0119","APP-OT0119 From Year and To Year should be the same! "},
			{"APP-OT0120","APP-OT0120 From Year and To Year cannot be greater than Current year! "},
			{"APP-OT0121","APP-OT0121 To Year cannot be greater than Current year! "},
			{"APP-OT0122","APP-OT0122 This function is not applicable, as ''Diary Schedule'' should be created for Theatre "},
			{"APP-OT0124","APP-OT0124 Cannot schedule ELECTIVE booking after Elective Cut-Off time has crossed!!"},
			{"APP-OT0125","APP-OT0125 Enter Principal Surgeon Name In Personal Details"},
			{"APP-OT0126","APP-OT0126 Please apply the changes! Before Documentation Complete"},	
			{"APP-OT0127","APP-OT0127 This function is not applicable, as ''Diary Schedule'' should be created for Surgeon "},
			{"APP-OT0128","APP-OT0128 Record failed at back order creation"},
			{"APP-OT0129","APP-OT0129 Record failed at booking billing process.."},
			{"APP-OT0130","APP-OT0130 Invalid Format : Duration Hours/Minutes (00:00)"},
			{"APP-OT0131","APP-OT0131 'Across Specialities' is selected as Documentation Level, Do you want to Proceed?"},
			{"APP-OT0132","APP-OT0132 'Speciality' is selected as Documentation Level, Do you want to Proceed?"},			
			{"APP-OT0133","APP-OT0133 Theatre Period From/To can not be blank"},
			{"APP-OT0134","APP-OT0134 Theatre Date From can not be greater than to date"},
			{"APP-OT0135","APP-OT0135 This function is not applicable, as Inventory is not Interfaced."},
			{"APP-OT0156","APP-OT0156 Actual units should not be greater than Stock Available."},
			//{"APP-OT0135","APP-OT0135 Check Out Time Cannot Be Blank..."},
			{"APP-OT0136","APP-OT0136 Invalid Date Format..."},
			{"APP-OT0137","APP-OT0137 Check out from Recovery Room is not done."},
			{"APP-OT0138","APP-OT0138 Check-in to Recovery Area/Document is not done."},
			{"APP-OT0139","APP-OT0139 Only one default store can be set for a store type."},
			{"APP-OT0140","APP-OT0140 Default Store is already defined for this theatre."},
			{"APP-OT0141","APP-OT0141 Select an Operating Room."},
			{"APP-OT0142","APP-OT0142 Please select a store type."},
			{"APP-OT0143","APP-OT0143 Cross Reference setup is not done for the selected item."},
			{"APP-OT0144","APP-OT0144 Prosthesis/Implants entry is not completed."},
			{"APP-OT0145","APP-OT0145 Surgical Accessories entries are not completed."},
			{"APP-OT0146","APP-OT0146 Duration exceeds Theatre End Time."},
			{"APP-OT0147","APP-OT0147 Entered Date/Time Should Not Be Greater Than Current Date/Time."},
			{"APP-OT0148","APP-OT0148 # Should Be Greater Than Or Equal To #."},
			{"APP-OT0149","APP-OT0149 Please Check Record Surgeon Notes Check Box."},
			{"APP-OT0150","APP-OT0150 Please Check Record Nursing Notes Check Box."},
			{"APP-OT0151","APP-OT0151 Please Check Admin Function Check Box."},
			{"APP-OT0152","APP-OT0152 Prosthesis/Implants Finalisation Stages Cannot be blank."},
			{"APP-OT0153","APP-OT0153 Equipments Finalisation Stages Cannot be blank."},
			{"APP-OT0154","APP-OT0154 Instruments/CSSD Finalisation Stages Cannot be blank."},
			{"APP-OT0155","APP-OT0155 Consumables Finalisation Stages Cannot be blank."},
			{"APP-OT0157","APP-OT0157 # Cannot Be Lesser Than $ "},
			{"APP-OT0158","APP-OT0158 CheckIn To OR Time should be greater than or equal to Holding Area Time "},
			{"APP-OT0159","APP-OT0159 CheckIn To OR Time should be greater than or equal to Check in Time "},
			{"APP-OT0160","APP-OT0160 Surgery Date exceeds the Check-In Backdate Limit defined for Facility. "},
			{"APP-OT0161","APP-OT0161 Surgery Date Should Not be Greater than the Current Date. "},
			{"APP-OT0162","APP-OT0162 Special Characters other than _ * / - . , = +  are not allowed. "},
			{"APP-OT0163","APP-OT0163 # Should Be Less Than $. "},
			{"APP-OT0164","APP-OT0164 Surgeon Or Assistant Surgeon Should Not Be Blank. "},
			{"APP-OT0165","APP-000165 Value should be greater than ONE"},
			{"APP-OT0166","APP-000166 Start Time Cannot Be Greater Than or Equal To End Time."},
			{"APP-OT0167","APP-OT0167 Operations/Procedures entry is not completed."},
			{"APP-OT0168","APP-OT0168 Administrative Function for All Charges  is not Applicable for Transfer back to OT Case."},
			{"APP-OT0169","APP-OT0169 Administrative Function for All Charges  is not Applicable for this Facility."},
			{"APP-OT0170","APP-OT0170 Speciality does not have checklist defined."},
			{"APP-OT0171","APP-OT0171 Initial Count should be completed before the Final Count."},
			{"APP-OT0172","APP-OT0172 Confirmation is not done, changes will be lost, Do you want to continue?"},
			{"APP-OT0173","APP-OT0173 Item Details are stored"},
			{"APP-OT0174","APP-OT0174 Appointment Alerady exists for this Operating Room, So room timings cannot be changed."},
			{"APP-OT0175","APP-OT0175 Implants for the newly entred operatioon should be added manually"},
			{"APP-OT0176","APP-OT0176 Cancellation not allowed as Personal details exists against this operation."},
			{"APP-OT0177","APP-OT0177 Cancellation not allowed as Visit Personal details exists against this operation."},
			{"APP-OT0178","APP-OT0178 Cancellation not allowed as Wound details exists against this operation."},
			{"APP-OT0179","APP-OT0179 Cancellation not allowed as Notes details exists against this operation."},
			{"APP-OT0180","APP-OT0180 Cancellation not allowed as Time details exists against this operation."},
			{"APP-OT0181","APP-OT0181 Procedure Codes exist for this Operation, Do you want to Cancel them?"},
			{"APP-OT0182","APP-OT0182 One or More Operation is mapped with Billing Panel, Hence Billing Sub Services is not Applicable."},
			{"APP-OT0183","APP-OT0183 Duration should be greater than 00:00."},
			{"APPT_TO_TIME_BLANK","APP-OT0184 To time cannot be blank"},
			{"APPT_FROM_TIME_BLANK","APP-OT0185 From Time cannot be blank"},
			{"APP-OT0186","APP-OT0186 Items are not finalized so Consumables cannot be completed"},
			{"APP-OT0187","APP-OT0187 Consent Not Taken"},
			{"APP-OT0188","APP-OT0188 Patient Refused"},
			{"APP-OT0189","APP-OT0189 Assistant Surgeon 1 and Assistant Surgeon 2 cannont be same."},
			{"APP-OT0190","APP-OT0190 Notes is already recorded, So cannot select another note type."},
			{"APP-OT0191","APP-OT0191 Do you want to save changes?"},
			{"APP-OT0192","APP-OT0192 There is no schedule available for this theatre. Do you want to continue?"},
			{"APP-OT0193","APP-OT0193 There is no vacant slot available for this theatre. Do you want to continue? "},
			{"APP-OT0194","APP-OT0194 There is no schedule generated for the selected date"},
			{"APP-OT0195","APP-OT0195 Record already exists in database cannont be deleted"},



			//Messages Coming from Database Procedures
			{"PRC-OT0001"," # Parameter เว้นว่าง"},//PRC-OT0001
			{"PRC-OT0002","PRC-OT0002  .รายการนัดผู้ป่วยรายนี้มีอยู่แล้วในวันที่ที่เลือกน"},//PRC-OT0002ี้
			{"PRC-OT0003","PRC-OT0003  ศัลยแพทย์รายนี้มีรายการนัดผู้ป่วยในวันที่/เวลานี้แล้ว"},//PRC-OT0003
			{"PRC-OT0004","PRC-OT0004 การนัดครั้งนี้ตรงกับการนัดที่คลินิกอื่น"},//PRC-OT0004 
			{"PRC-OT0005","PRC-OT0005  การนัดครั้งนี้ตรงกับการนัดตรวจทางรังสีวิทยา"},//PRC-OT0005
			{"PRC-OT0006","PRC-OT0006  ช่วงเวลาซ้ำซ้อนกัน กรุณาเลือกเวลาใหม่หรือลดระยะเวลาเดิม"},//PRC-OT0006
			{"PRC-OT0007","PRC-OT0007  เกิดข้อผิดพลาดขณะทำ checklist ที่ขอ"},//PRC-OT0007
			{"PRC-OT0008","PRC-OT0008 เกิดข้อผิดพลาดขั้นวิกฤติ ไม่พบ OT Parameter Record จัดตั้งใหม่และดำเนินการต่อหรือไม่?"},//PRC-OT0008 
			{"PRC-OT0009","PRC-OT0009 เกิดข้อผิดพลาดขั้นวิกฤติ ไม่พบ OT Facility wise Parameter Record จัดตั้งใหม่และดำเนินการต่อหรือไม่?"},//PRC-OT0009 
			{"PRC-OT0010","PRC-OT0010 จัดหมายเลขจองให้ไม่ได้ Parameter record ถูกระงับใช้ช้"},//PRC-OT0010้
			{"PRC-OT0011","PRC-OT0011  จัดหมายเลขจองให้ไม่ได้ เนื่องจากครบจำนวนแล้ว"},//PRC-OT0011
			{"PRC-OT0012","PRC-OT0012  จัดหมายเลขการทำงานให้ไม่ได้ Parameter record ถูกระงับใช"},//PRC-OT0012้
			{"PRC-OT0013","PRC-OT0013  จัดหมายเลขให้ไม่ได้ เนื่องจากครบจำนวนแล้ว"},//PRC-OT0013
			{"PRC-OT0014","PRC-OT0014  ไม่พบรายงานนี้ใน ตาราง OT_QUEUE "},//PRC-OT0014
			{"PRC-OT0015","PRC-OT0015  ไม่พบ # ในตาราง $ "},//PRC-OT0015
			{"PRC-OT0016","PRC-OT0016  ไม่ได้กำหนดสถานะของการทำงาน กรุณาตรวจสอบ"},
			{"PRC-OT0017","PRC-OT0017  เกิดความผิดพลาดขณะดำเนินการ"},//PRC-OT0017
			{"PRC-OT0018","PRC-OT0018 การจัดตั้ง Anaesthesia Parameter ไม่เสร็จสมบูรณ"},//PRC-OT0018 ์
			{"PRC-OT0019","PRC-OT0019  เกิดความผิดพลาดในการเลือกรายงานจาก Anaesthesia Parameter"},//PRC-OT0019
			{"PRC-OT0020","PRC-OT0020  ผู้ป่วยยังอยู่ในห้องผ่าตัด"},//PRC-OT0020
			{"PRC-OT0021","PRC-OT0021  ไม่มีช่องว่างสำหรับวันที่/ห้องน"},//PRC-OT0021ี้
			{"PRC-OT0022","PRC-OT0022  OT Parameter record ไม่ถูกจัดตั้ง จัดตั้งและดำเนินการต่อหรือไม่?"},//PRC-OT0022
			{"PRC-OT0023","PRC-OT0023  บริการนี้ไม่ได้รับการอนุมัติมาก่อนหน้านี้ กรุณาบอกผู้ป่วยว่าจำเป็นต้องเสียค่าใช้จ่าย ต้องการดำเนินการต่อหรือไม"},//PRC-OT0023่
			{"PRC-OT0024","PRC-OT0024  บริการนี้ไม่รวมอยู่ในแผนการดำเนินการน"},//PRC-OT0024ี้
			{"PRC-OT0025","PRC-OT0025   ผู้ป่วยรายนี้เป็นผู้ป่วยใน  วันนัดตรวจผู้ป่วยนอก # ถูกเปลี่ยนเป็นวันนัดตรวจผู้ป่วยใน $"},//PRC-OT0025
			{"PRC-OT0026","PRC-OT0026  วันนัดตรวจของผู้ป่วยรายนี้ถูกเปลี่ยนจาก # เป็นวันนัดตรวจของผู้ป่วยใน $"},//PRC-OT0026
			{"PRC-OT0027","PRC-OT0027  ผู้ป่วยรายนี้ไม่ใช่ผู้ป่วยใน ต้องทำเรื่อง admit ก่อนทำตารางนัดได"},//PRC-OT0027้
			{"PRC-OT0028","PRC-OT0028  ผู้ป่วยรายนี้ไม่ใช่ผู้ป่วยใน"},//PRC-OT0028
			{"PRC-OT0029","PRC-OT0029  ผู้ป่วยรายนี้เป็นผู้ป่วยใน กรุณาดูรายละเอียดที่เกี่ยวข้องและดำเนินการต่อ"},//PRC-OT0029
			{"PRC-OT0030","PRC-OT0030  ผู้ป่วยรายนี้มีการตรวจอยู่แล้ว กรุณาดูรายละเอียดที่เกี่ยวข้องและดำเนินการต่อ"},//PRC-OT0030
			{"PRC-OT0031","PRC-OT0031  ผู้ป่วยรายนี้ไม่ใช่ผู้ป่วยใน ตารางนัดนี้ไม่สามารถทำได"},//PRC-OT0031้
			{"PRC-OT0032","PRC-OT0032  ผู้ป่วยรายนี้ไม่ใช่ผู้ป่วยใน ต้องการดำเนินการต่อหรือไม่?"},//PRC-OT0032
			{"PRC-OT0033","PRC-OT0033	ไม่มีหมายเลขการกระทำน"},//PRC-OT0033 ี้
			{"PRC-OT0034","PRC-OT0034  การเลือกกระทำนิไม่สามารถทำได"},//PRC-OT0034้
			{"PRC-OT0035","PRC-OT0035  ไม่มีหมายเลขของ order ดังกล่าว"},//PRC-OT0035
			{"PRC-OT0036","PRC-OT0036 ไม่สามารถปรับเปลี่ยน order ได้"},//PRC-OT0036 
			{"PRC-OT0037","PRC-OT0037 ไม่ได้กำหนด facility 10 ไว้"}, // new messages start from here
			{"PRC-OT0038","PRC-OT0038 ไม่ได้กำหนด Accession flag ไว้"},
			{"PRC-OT0039","PRC-OT0039 ไม่ได้กำหนด Accession ไว้"},
			{"PRC-OT0040","PRC-OT0040 ไม่ได้กำหนด Checklist stage ไว้"},
			{"PRC-OT0041","PRC-OT0041 ไม่ได้กำหนด Checklist user ไว้"},
			{"PRC-OT0042","PRC-OT0042 ไม่ได้กำหนด User ID ไว้"},
			{"PRC-OT0043","PRC-OT0043 ไม่ได้กำหนด Work Station ID ไว้"},		
			{"PRC-OT0044","PRC-OT0044 มีการนัดหมายเดิมที่ทับซ้อนกับช่วงแรกที่ทำการ block"},
			{"PRC-OT0045","PRC-OT0045 มีการ block เดิมที่ทับซ้อนกับช่วงแรกที่ทำการ block"},				
			{"PRC-OT0046","PRC-OT0046 ไม่สามารถ block ช่วงเวลาที่มีการนัดหมายไว้แล้วได้"},
			{"PRC-OT0047","PRC-OT0047 ไม่สามารถ block ซ้อนทับ block เดิมได้"},	
			{"PRC-OT0048","PRC-OT0048 Sum of Reserve Quantity and Request Quantity should be equal to No of Units."},
			{"PRC-OT0049","PRC-OT0049 Either Reserve Quantity or Request Quantity should be entered."},
			{"PRC-OT0050","PRC-OT0050 All Operations cannot be cancelled."},
			{"PRC-OT0051","PRC-OT0051 Cancellation not allowed when Surgical accessories exists against this operation."},
			{"PRC-OT0052","PRC-OT0052 Reserve Quantity cannont be greater than QOH Of Request Store."},
			{"PRC-OT0053","PRC-OT0053 Request Store and Issuing Store cannont be blank."},
			{"PRC-OT0054","PRC-OT0054 Stock is not available for the Item/Store combination."},
			{"PRC-OT0055","PRC-OT0055 Sale Document type and Request Document Type is not set up in the OT Parameter."},
			{"PRC-OT0056","PRC-OT0056 This patient encounter is changed from # to current open encounter $ "},
			{"PRC-OT0057","PRC-OT0057 Patient is already linked to current Encounter. "},
			{"PRC-OT0058","PRC-OT0058 Status is already changed for some bookings. "},
			{"PRC-OT0059","PRC-OT0059 Resource Busy click Apply button again. "}

	
		/* Backup before copying the Thai Messages
			{"CANNOT_BE_BLANK","APP-OT0001 & cannot be blank"},
			{"CANNOT_BE_ZERO","APP-OT0002 & cannot be zero."},
			{"OT_MANDATORY","APP-OT0003 Mandatory Fields Cannot be Blank"},
			{"DATE1_NOT_LESSER_THAN_DATE2","APP-OT0004 # should not be less than #..."},
			{"DATE1_NOT_GREATER_THAN_DATE2","APP-OT0007 # should not be greater than # ..."},
			{"INVALID_USER_FUNCTION","APP-OT0005 This User do not have access to this Function"},

			{"VALID_TIME_SLOTS","APP-OT0006 Valid Entry should be between 00:00 and 23:59 "},
			{"MIN_ONE_OPER_FOR_SPECIALITY","APP-OT0008 Atleast one operation must match with operating specialty"},
			{"NUMERIC_ENTRY_ONLY","APP-OT0011 Numeric only allowed in sequence"},
			{"MONTH_COMPARE_CURMONTH","APP-OT0019 Month and year should be greater than current"},
			{"TIME_LESS_THAN","APP-OT0023 Selected Time is Lesser than Current Time"},
			{"MAX_LENGTH_DATA","APP-OT0025 # Remarks should not more than # character"},
			{"INCOMPLETE_CHECKLIST","APP-OT0O28 CheckList is Incomplete"},
			{"SPECIALITY_DUPLICATE","APP-OT0031 Specialty cannot be duplicated"},
			{"APP-OT0034","APP-OT0034 Theatre Date > Current Date \n  # is not Allowed!"},
			{"APP-OT0036","APP-OT0036 Surgeon or Specialty or Procedure Should be entered"},
			{"APP-OT0037","APP-OT0037 Either Prefered  Date or Prefered Month should be entered"},
			{"APP-OT0038","APP-OT0038 Anaesthesia is not applicable for this operation"},
			{"APP-OT0040","APP-OT0040 Invalid Hours! Hours should be between 00 - 23"},
			{"APP-OT0041","APP-OT0041 Invalid Minutes!  Mins should be between 00 - 59"},
			{"APP-OT0046","APP-OT0046 Select a valid List ID"},
			{"APP-OT0047","APP-OT0047 Srl No should be > 0"},
			{"APP-OT0050","APP-OT0050 This Set and Tray combination already exists!"},
			{"APP-OT0053","APP-OT0053 Selected operation cannot be performed in # Theatre"},
			{"APP-OT0054","APP-OT0054 Select the theatre before recording operations"},
			{"APP-OT0056","APP-OT0056 Anaesthesia is not applicable for this operation or \n Pre Anesthesia is not done for this operation"},
			{"APP-OT0057","APP-OT0057 Anaesthesia is not applicable for this operation \n or Pre/Intra Anesthesia are not done for this operation"},
			{"APP-OT0058","APP-OT0058 Bookings are not selected"},
			{"APP-OT0060","APP-OT0060 Date should be greater than Diary Generated Upto Date"},
			{"APP-OT0062","APP-OT0062 Schedule is not defined for this Surgeon for the selected Theatre."},
			{"APP-OT0063","APP-OT0063 Invalid PIN No."},
			{"APP-OT0064","APP-OT0064 Minus symbol should be in the beginning of the number entered"},
			{"APP-OT0065","APP-OT0065 Cannot deduct items more than the total additions for the item, #"},
			{"APP-OT0068","APP-OT0068 # cannot be less than or equal to ZERO"},
			{"APP-OT0070","APP-OT0070 check out time should be less than or equal to system time"},
			{"APP-OT0071","APP-OT0071 # is not done"},
			{"APP-OT0072","APP-OT0072 User doesn't have privilege to change the stage"},
			{"APP-OT0073","APP-OT0073 Selected Slots are blocked for # specialty.  Selected operation(s) do not belong to this specialty.  Do you want to continue?"},
			{"APP-OT0074","APP-OT0074 Do you want to Waitlist this Patient"},
			{"APP-OT0075","APP-OT0075 Do you want to bring waitlisted patient to the vaccated slot"},
			{"APP-OT0077","APP-OT0077 Patient has existing operations for this day, Do you want to continue?"},
			{"APP-OT0078","APP-OT0078 Documentation not completed, Do you want to continue?"},
			{"APP-OT0079","APP-OT0079 Do you want to continue?"},

//newly added messages
			{"APP-OT0080","APP-OT0080 This Operation & Cannot be Performed in "},
			{"APP-OT0081","APP-OT0081 This Patient is being Rescheduled for & Time(s)"},
			{"APP-OT0082","APP-OT0082 Operation Failed..."},
			//{"APP-OT0083","APP-OT0083 Please Apply the Changes..."},
			{"APP-OT0084","APP-OT0084 Welcome to eHIS"},
			{"APP-OT0085","APP-OT0085 No Associated ICDPCS code for Mandatory Operation"},
			{"APP-OT0086","APP-OT0086 Values are not entered for "},
			{"APP-OT0087","APP-OT0087 Remarks are mandatory for Discrepancies in "},
			{"APP-OT0088","APP-OT0088 # is not entered.. "},
			{"APP-OT0089","APP-OT0089 No Consent Details to View "},
			{"APP-OT0090","APP-OT0090 User  is  Not  Authorized  to  Cancel/Transfer Booking "},
			{"APP-OT0091","APP-OT0091 CheckList is not associated with this order type "},			
			{"APP-OT0092","APP-OT0092 This User is Not Authorised for Booking "},
			{"APP-OT0093","APP-OT0093 Patient has refused for this operation. Cannot proceed further "},
				
//Messages Coming from Database Procedures
			{"PRC-OT0001","PRC-OT0001 # Parameter is null"},
			{"PRC-OT0002","PRC-OT0002 Appointment already exists for this Patient for the selected date."},
			{"PRC-OT0003","PRC-OT0003 This Surgeon has existing Appointments for the same Date/Time."},
			{"PRC-OT0004","PRC-OT0004 This Appointment time clashes with another Clinic Appointment which is scheduled for this Patient"},
			{"PRC-OT0005","PRC-OT0005 This Appointment time clashes with another Radiology Appointment which is scheduled for this Patient"},
			{"PRC-OT0006","PRC-OT0006 Time Slots are Over Lapping,Continuous Slots not Available,Please choose Another time or reduce the duration"},
			{"PRC-OT0007","PRC-OT0007 Error in creating Chek list Request"},
			{"PRC-OT0008","PRC-OT0008 Fatal Error! OT Parameter Record not found - set up and continue"},
			{"PRC-OT0009","PRC-OT0009 Fatal Error! OT Facilitywise Parameter Record not found - set up and continue"},
			{"PRC-OT0010","PRC-OT0010 Could not get next Booking number, Parameter record locked"},
			{"PRC-OT0011","PRC-OT0011 Could not get next Booking number, Max Limit Reached"},
			{"PRC-OT0012","PRC-OT0012 Could not get next Operation number, Parameter record locked"},
			{"PRC-OT0013","PRC-OT0013 Could not get next Operation number, Maximum number is reached"},
			{"PRC-OT0014","PRC-OT0014 Record is not there in OT_QUEUE table"},
			{"PRC-OT0015","PRC-OT0015 # is not there in $ table"},
			{"PRC-OT0016","PRC-OT0016 Status not defined for this function, Check the Status definition"},
			{"PRC-OT0017","PRC-OT0017 Error while getting the status"},
			{"PRC-OT0018","PRC-OT0018 Anaesthesia Parameter set up is not complete"},
			{"PRC-OT0019","PRC-OT0019 Error in selecting record from Anaesthesia Parameter"},
			{"PRC-OT0020","PRC-OT0020 Patient Still in Operating Room"},
			{"PRC-OT0021","PRC-OT0021 Slots not avaliable for the date/room"},
			{"PRC-OT0022","PRC-OT0022 OT Parameter record not been setup - setup and continue"},
			{"PRC-OT0023","PRC-OT0023 Pre-Approval not obtained for this service.  Please inform the Patient. He/She has to Pay.  Do you want to continue?"},
			{"PRC-OT0024","PRC-OT0024 This service is excluded from the policy"},
			{"PRC-OT0025","PRC-OT0025 This patient is currently an Inpatient.  Outpatient encounter # is changed to Inpatient encounter $"},
			{"PRC-OT0026","PRC-OT0026 This patient encounter is changed from # to current open Inpatient encounter $ "},
			{"PRC-OT0027","PRC-OT0027 Patient is currently not an Inpatient.  Patient has to be admitted before finalizing the schedule."},
			{"PRC-OT0028","PRC-OT0028 Patient is currently not an Inpatient."},
			{"PRC-OT0029","PRC-OT0029 Patinet is curently an Inpatient.  Link the encounter details and proceed. "},
			{"PRC-OT0030","PRC-OT0030 Patient has a different open episode.  Link the encounter details and proceed. "},
			{"PRC-OT0031","PRC-OT0031 Patient is currently not an Inpatient.  This schedule can not be finalized."},
			{"PRC-OT0032","PRC-OT0032 Patient is currently not an Inpatient.  Do you want to continue?"},
			{"PRC-OT0033","PRC-OT0033 No such operation number"},
			{"PRC-OT0034","PRC-OT0034 Opeartion Selection failed."},
			{"PRC-OT0035","PRC-OT0035 No Such Order Id is available"},
			{"PRC-OT0036","PRC-OT0036 Order update failed."}};			
			*/
	};
}			
