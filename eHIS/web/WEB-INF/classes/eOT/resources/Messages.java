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

public class Messages extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = {
			{"CANNOT_BE_BLANK","APP-OT0001 & cannot be blank"},
			{"CANNOT_BE_ZERO","APP-OT0002 & cannot be zero."},
			{"OT_MANDATORY","APP-OT0003 Mandatory Fields Cannot be Blank"},
			{"DATE1_NOT_LESSER_THAN_DATE2","APP-OT0004 # should not be less than #..."},
			{"DATE1_NOT_GREATER_THAN_DATE2","APP-OT0007 # should not be greater than # ..."},
			{"INVALID_USER_FUNCTION","APP-OT0005 This User do not have access to this Function"},
			{"VALID_TIME_SLOTS","APP-OT0006 Valid Entry should be between 00:00 and 23:59 "},
			{"MIN_ONE_OPER_FOR_SPECIALITY","APP-OT0008 Atleast one operation must match with operating specialty"},
			{"NUMERIC_ENTRY_ONLY","APP-OT0011 Numeric only allowed in sequence"},
			{"MONTH_COMPARE_CURMONTH","APP-OT0019 Preferred Month/Year should not be less than Current Month/Year..."},
			{"TIME_LESS_THAN","APP-OT0023 Selected Time is Lesser than Current Time"},
			{"MAX_LENGTH_DATA","APP-OT0025 # Remarks should not be more than # characters"},
			{"INCOMPLETE_CHECKLIST","APP-OT0O28 CheckList is Incomplete"},
			{"SPECIALITY_DUPLICATE","APP-OT0031 Specialty cannot be duplicated"},
			{"APP-OT0034","APP-OT0034 Theatre Date > Current Date \n  # is not Allowed!"},
			{"APP-OT0036","APP-OT0036 Surgeon or Specialty or Procedure Should be entered"},
			{"APP-OT0037","APP-OT0037 Either Prefered  Date or Prefered Month should be entered"},
			{"APP-OT0038","APP-OT0038 Anaesthesia is not applicable for this operation"},
			{"APP-OT0040","APP-OT0040 Invalid Hours or Minutes ! Hours should be between 00 - 23 and Mins should be between 00 - 59"},
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
			{"APP-OT0075","APP-OT0075 Do you want to bring waitlisted patient to the vacated slot"},
			{"APP-OT0077","APP-OT0077 Patient has existing operations for this day, Do you want to continue?"},
			{"APP-OT0078","APP-OT0078 Documentation not completed, Do you want to continue?"},
			{"APP-OT0079","APP-OT0079 Do you want to continue?"},
			{"APP-OT0080","APP-OT0080 This Operation & Cannot be Performed in "},
			{"APP-OT0081","APP-OT0081 Patient $ is being Rescheduling for & Time(s)"},
			{"APP-OT0082","APP-OT0082 Operation Failed..."},
			{"APP-OT0083","APP-OT0082 Do you want to delete the existing Patient appointment schedule..."},
			{"APP-OT0084","APP-OT0084 Welcome to eHIS"},
			{"APP-OT0085","APP-OT0085 No Associated ICDPCS code for Mandatory Operation"},
			{"APP-OT0086","APP-OT0086 Values are not entered for "},
			{"APP-OT0087","APP-OT0087 Remarks are mandatory for Discrepancies in "},
			{"APP-OT0088","APP-OT0088 # is not entered.. "},
			{"APP-OT0089","APP-OT0089 No Consent Details to View "},
			{"APP-OT0090","APP-OT0090 User  is  Not  Authorized  to  Cancel/Transfer the Appointment "},
			{"APP-OT0090C","APP-OT0090C User  is  Not  Authorized  to  Cancel the Appointment "},
			{"APP-OT0090T","APP-OT0090T User  is  Not  Authorized  to  Transfer the Appointment "},
			{"APP-OT0091","APP-OT0091 CheckList is not associated with this order type "},			
			{"APP-OT0092","APP-OT0092 This User is Not Authorised for Booking "},
			{"APP-OT0093","APP-OT0093 Patient has refused for this operation. Cannot proceed further "},
			{"APP-OT0094","APP-OT0094 Procedure Coding Details are not entered \n for an Operation "},
			{"APP-OT0095","APP-OT0095 AtLeast One Surgeon is required to Complete Documentation "},		
			{"APP-OT0096","APP-OT0096 Selected Slots are blocked for # specialty. Atleast one operation should be of this specialty."},
			{"APP-OT0097","APP-OT0097 Selected Slots are blocked for Multiple Specialties. Atleast one operation should be selected for any of these specialties."},
			{"APP-OT0098","APP-OT0098 Select The Applicable Position And Create atleast One user."},
			{"APP-OT0099","APP-OT0099 Atleast one user is to be selected."},
			{"APP-OT0100","APP-OT0100 Select No Of Verifications For Pre Operative Checklist."},
			{"APP-OT0101","APP-OT0101 Select No Of Verifications For Post Operative Checklist."},
			{"APP-OT0102","APP-OT0102 Change Specific Indicator To All Users And Than Apply."},
			{"APP-OT0103","APP-OT0103 # Cannot Be Greater Than Or Equal To #."},
			{"APP-OT0104","APP-OT0104 PickList is generated."},				
			{"APP-OT0105","APP-OT0105 Atleast one week should be selected."},				
			{"APP-OT0106","APP-OT0106 Patient is WaitListed."},
			{"APP-OT0107","APP-OT0107 Consent is not taken for the patient."},
			{"APP-OT0108","APP-OT0108 Waitlist is Cancelled."},
			{"APP-OT0109","APP-OT0109 Time Slot Overlaps."}, 
			{"APP-OT0110","APP-OT0110 Entered Time should be a multiple of OT Unit Time "},
			{"APP-OT0111","APP-OT0111 Entered Time Should fall within the Booking Range of # to # on working days "},
			{"APP-OT0112","APP-OT0112 Entered Time Should fall within the Booking Range of # to # on Holidays "},
			{"APP-OT0113","APP-OT0113 This time slot should be greater than the previous time slot"},
			{"APP-OT0114","APP-OT0114 # should not be more than # character "},
			{"APP-OT0115","APP-OT0115 Entered Time Should be multiples of OT Unit Time "},
			{"APP-OT0116","APP-OT0116 Only one item value can be set as default "},
			{"APP-OT0117","APP-OT0117 Operative Notes is not entered... "},
			{"APP-OT0118","APP-OT0118 Do you want to create the Order Catalog for this Operation/Procedure? "},
			{"APP-OT0119","APP-OT0119 From Year and To Year should be the same! "},
			{"APP-OT0120","APP-OT0120 From Year and To Year cannot be greater than Current year! "},
			{"APP-OT0121","APP-OT0121 To Year cannot be greater than Current year! "},
			{"APP-OT0122","APP-OT0122 This function is not applicable, as ''Diary Schedule'' should be created for Theatre "},
			{"APP-OT0123","APP-OT0123 Either Surgery Date or Anaesthesia Ordered Date should be entered!"},
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
			{"APP-OT0156","APP-OT0156 Actual units should not be greater than Stock Available."},
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
			//{"APP-OT0175","APP-OT0175 Implants for the newly entred operatioon should be added manually"},
			{"APP-OT0175","APP-OT0175 Implants for the newly entered operation should be added manually"},//added against 046599
			{"APP-OT0176","APP-OT0176 Cancellation not allowed as Personnel details exists against this operation."},
			{"APP-OT0177","APP-OT0177 Cancellation not allowed as Visit Personnel details exists against this operation."},
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

			{"APP-OT0196","APP-OT0196 Check-In date should not be less than Booking date"},//Added by lakshmi against IN20056
			{"APP-OT0197","APP-OT0197 Check-In date should not be less than Surgery date"},//Added by Sanjay against IN20056
			{"APP-OT0198","APP-OT0198 Check-In date should not be less than Order date time"},//Added by Sanjay against IN20056
			//CRF-004 Authorize Slots for Booking - Rajesh V
			{"APP-OT0199","APP-OT0199 This booking utilises reserved slots. Only Authorised users may complete the booking. Do you want to proceed?"},
			{"APP-OT0200","APP-OT0200 The user is already added"},
			{"APP-OT0201","APP-OT0201 The value cannot be greater than value provided for the field Total slots available for surgeon"},
			{"APP-OT0202","APP-OT0201 The username and password does not match"},
			//CRF-004 Authorize Slots for Booking - Rajesh V
			//CRF-268 Instrument Count - Rajesh V
			{"APP-OT0204","APP-OT0204 Required Quantity cannot be Empty"},
			//CRF-268 Instrument Count - Rajesh V
			//CRF-008 Turn Around Time - Rajesh V
			{"APP-OT0205","APP-OT0205 Please configure the status in the right order"},
			//CRF-008 Turn Around Time - Rajesh V
			{"APP-OT0206","APP-OT0206 # Should be entered !"},//AAKH-CRF-0069			
			
			{"PRC-OT0001","PRC-OT0001 # Parameter is null"},
			{"PRC-OT0002","PRC-OT0002 Appointment already exists for this Patient for the selected date."},
			{"PRC-OT0003","PRC-OT0003 This Surgeon has existing Appointments for the same Date/Time."},
			{"PRC-OT0004","PRC-OT0004 This Appointment time clashes with another Clinic Appointment which is scheduled for this Patient"},
			{"PRC-OT0005","PRC-OT0005 This Appointment time clashes with another Radiology Appointment which is scheduled for this Patient"},
			{"PRC-OT0006","PRC-OT0006 Time Slots are Over Lapping,Continuous Slots not Available,Please choose Another time or reduce the duration"},
			{"PRC-OT0007","PRC-OT0007 Error in creating Checklist Request"},
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
			{"PRC-OT0025","PRC-OT0025 This patient is currently an Inpatient.  Encounter # is changed to Inpatient encounter $"},
			{"PRC-OT0026","PRC-OT0026 This patient encounter is changed from # to current open Inpatient encounter $ "},
			{"PRC-OT0027","PRC-OT0027 Patient is currently not an Inpatient.  Patient has to be admitted before finalizing the schedule."},
			{"PRC-OT0028","PRC-OT0028 Patient is currently not an Inpatient."},
			{"PRC-OT0029","PRC-OT0029 Patient is curently an Inpatient.  Link the encounter details and proceed. "},
			{"PRC-OT0030","PRC-OT0030 Patient has a different open episode.  Link the encounter details and proceed. "},
			{"PRC-OT0031","PRC-OT0031 Patient is currently not an Inpatient.  This schedule can not be finalized."},
			{"PRC-OT0032","PRC-OT0032 Patient is currently not an Inpatient.  Do you want to continue?"},
			{"PRC-OT0033","PRC-OT0033 No such operation number"},
			{"PRC-OT0034","PRC-OT0034 Opeartion Selection failed."},
			{"PRC-OT0035","PRC-OT0035 No Such Order Id is available"},
			{"PRC-OT0036","PRC-OT0036 Order update failed."},
			{"PRC-OT0037","PRC-OT0037 Facility ID parameter is null."}, 
			{"PRC-OT0038","PRC-OT0038 Accession flag parameter is null."},
			{"PRC-OT0039","PRC-OT0039 accession parameter is null."},
			{"PRC-OT0040","PRC-OT0040 Checklist stage parameter is null."},
			{"PRC-OT0041","PRC-OT0041 Checklist user parameter is null."},
			{"PRC-OT0042","PRC-OT0042 User ID parameter is null."},
			{"PRC-OT0043","PRC-OT0043 Work Station ID parameter is null."},		
			{"PRC-OT0044","PRC-OT0044 Existing appointment is clashing with # # # block."},
			{"PRC-OT0045","PRC-OT0045 Existing block is clashing with # # # block."},				
			{"PRC-OT0046","PRC-OT0046 Cannot block when appointments are already booked for # ."},
			{"PRC-OT0047","PRC-OT0047 Cannot block. Selected slot date / time clashes with an existing block."},	
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
			{"PRC-OT0059","PRC-OT0059 Resource Busy click Apply button again. "},
			{"PRC-OT0060","PRC-OT0060 Time Slots are Blocked,Continuous Slots not Available,Please choose Another time or reduce the duration "},//047067 Bharati
			
			//Added by MuthuN against BRU-CRF-268
			{"APP-OT200","No Sufficient Quantity,item cannot be finalized. Do you want to send a request to CSSD? "},
			{"APP-OT201","Equipment will be added to the booking but not available "},
			//{"APP-OT202","Equipment not added, Kindly regenerate the Pick List when sufficient quantity is available. "},
			{"APP-OT202","Equipment/Instrument not requested but added into the pick list; kindly regenerate the Pick list when equipment/Instrument is available."},
			{"APP-OT203","Kindly enter a value less than or equal to the value in Quantity on hand"},
			{"APP-OT204","Quantity on Hand is zero. Do you want to continue?"},
				
			// BRU-HIMS-008  Turn Around Time
			{"APP-OT0209","'Please set parameter for Turn Around time Report'"},
			{"APP-NF0008","APP-NF0008 Hours should be between 0 - 23"},
			{"APP-OT0210","APP-OT0210 Role 3 has not been defined"},//Maheshwaran K added for the CHL-CRF-0043 [IN:035927] as on 28/02/2013
			{"APP-OT0211","APP-OT0211 Order Details not found in the current facility"},// Added for CRF 298
			{"APP-OT0212","APP-OT0212 Entered Date should Be greater than or equal to Current Date"},
			{"APP-OT0213","APP-OT0213 To Date should be greater than or equal to From Date"},
			{"APP-OT0214","APP-OT0214 Selected Items should not be more than 3 "},//BRU-CRF-006
			{"APP-OT0215","APP-OT0215 Atleast one Item should be selected "},
			{"APP-OT0216","APP-OT0216 Auto refresh Time cannot be less than 5 "},
			{"APP-OT0217","APP-OT0217 Auto refresh Time cannot be blank "},
			{"APP-OT0218","APP-OT0218 Authorisation for booking is not possible when multiple rooms are selected. "},
			{"APP-OT0219","APP-OT0219 Over Booking Quota is completed "},
			{"APP-OT0220","APP-OT0220 Combination with 'ALL' is not possible"},
			{"APP-OT0221","APP-OT0221 Item Already Exist"},//CRF 0092
			{"APP-OT0222","APP-OT0222 Date Should be Within One Week from the Current Date "}, //047546
			{"APP-OT0223","APP-OT0223 Date & Time Cannot be Before the Check-In Date/Time"},//047546
			{"APP-OT0224","APP-OT0224 Default User Role Feature is not enabled in OT Setup Parameter for Facility"},//CRF-003
			{"APP-OT0225","APP-OT0225 Atleast one field should be entered!"},//Added against GHL-CRF-0357
			{"APP-OT0226","APP-OT0226 One user role should be Applicable"},//PMG-CRF-003
			{"APP-OT0227","APP-OT0227 Patient has Scheduled Operation(s) for this day. Do You Want to Continue?"},//PMG-CRF-0024
			{"APP-OT0228","APP-OT0228 Patient has Un-Scheduled Operation(s) for this day. Do You Want to Continue?"},//PMG-CRF-0024
			{"APP-OT0229","APP-OT0229 Patient has Scheduled and Un-Scheduled Operation(s) for this day. Do You Want to Continue?"},//PMG-CRF-0024
			{"APP-OT0230","APP-OT0230 # already exists against this operation. Are you sure you wish to proceed?"},//PMG MOD-0005
			{"APP-OT0231","APP-OT0231 No. of Swab Counts reqd (Mandatory) should be less than or equal to No. of Swab Counts reqd (including Initial and Final Count)"}, //IN054191
			{"APP-OT0232","APP-OT0232 The maximum allowed count for an item is 999."},
			{"APP-OT0233","APP-OT0233 No future bookings available to amend."},//MMS-CRF-186
			{"APP-OT0234","APP-OT0234 Anesthesia Required is set as 'N' for the selected operation and there is a mismatch with the Anesthesia requirement for remaining operations in the list. If this operaton is set as the default operation then Anesthesia functionality will be turned OFF for this order. Are you sure you wish to proceed?"},
			//Added against PMG2016-KDAH-CRF-0001 Starts
			{"APP-OT0235","APP-OT0235 Operation Theatre is not available"},//Transfer to ot message
			{"APP-OT0236","APP-OT0236 Multiple Check-In restriction will be applicable for existing records."},//Set up message
			{"APP-OT0237","APP-OT0237 Operation Theatre is not available for the Check-Out from OR Date/Time"},//check out message
			{"APP-OT0238","APP-OT0238 Operation Theatre is not available for the Checked-In Date/Time."},//check in message
			//Added against PMG2016-KDAH-CRF-0001 Ends
			{"APP_TIME_DTLS_BLANK","APP-OT0239 Please tick any one of the fields in Function Level parameter."}//Added by Arthi for ML-MMOH-CRF-1936
			
	};
}
