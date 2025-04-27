/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var messageArray;

if( messageArray == null ) {
    messageArray = new Array() ;
}

//Commented old Messages
//messageArray["OPERATION_CODE_EXIST"]="APP-OT0016 Operation Code already exist";
//messageArray["DESCRIPTION_NULL_STATUS"]="APP-OT0017 Description Code should not be empty";
//messageArray["DATE_COMPARE_CURDATE"]="APP-OT0018 Date should be greater than SYSDATE";
//messageArray["NO_CHANGES"]="APP-OT0022 No Changes to Commit"; 
//messageArray["ORDER_CATEGORY_NULL"]="APP-OT0026 Order Category value should not be Null";
//messageArray["ORDER_TYPE_NULL"]="APP-OT0O27 Order type must be enter";
//messageArray["REASON_CODE_NOT"]="APP-OT0024 Reason code must be entered"; 
//messageArray["MAXM_LENGTH_DATA"]="APP-OT0025 Pre oper diagnostic should not more than 500 character";
//messageArray["MAXM_LENGTH_REMARKS"]="APP-OT0029 Header Remarks should not more than 1500 character";
//messageArray["MAXM_LENGTH_REMARKS1"]="APP-OT0030 Operation Remarks should not more than 500 character";
//messageArray["REMARKS_CANNOT_EXCEED"]="APP-OT0032 & characters only allowed";
//messageArray["APP-OT0035"]="APP-OT0035 Theatre Date > Current Date \n  Check-In to OR is not Allowed!";
//messageArray["APP-OT0042"]="APP-OT0042 Check-Out time should be < system date and time";
//messageArray["APP-OT0043"]="APP-OT0043 Check-Out time should be > Recovery Check-In Time";
//messageArray["APP-OT0044"]="APP-OT0044 Checkin time should be < system date and time";
//messageArray["APP-OT0045"]="APP-OT0045 Enter a valid no";
//messageArray["APP-OT0048"]="APP-OT0048 Order ID to be selected";
//messageArray["APP-OT0049"]="APP-OT0049 Tray Information cannot be blank";
//messageArray["APP-OT0051"]="APP-OT0051 To Date should be greater than or equal to From Date";
//messageArray["APP-OT0052"]="APP-OT0052 Invalid Date Format";
//messageArray["APP-OT0055"]="APP-OT0055 Anaesthesia is not applicable for this operation";
//messageArray["APP-OT0059"]="APP-OT0059 Date should be greater than Current Date";
//messageArray["APP-OT0061"]="APP-OT0061 From Date should be lesser than or equal to To Date";
//messageArray["APP-OT0066"]="APP-OT0066 Zero Numbers are not allowed";
//messageArray["APP-OT0067"]="APP-OT0067 Select the Nursing Unit";
// messageArray["APP-OT0069"]="APP-OT0069 check out time should be greater than case call time";
//messageArray["APP-OT0076"]="APP-OT0076 Do you want to Delete the Record?";


//OT Messages Start from Here
messageArray["CANNOT_BE_BLANK"]	=   "APP-OT0001 &cannot be blank";
messageArray["CANNOT_BE_ZERO"]	=   "APP-OT0002 &cannot be zero.";
messageArray["OT_MANDATORY"]	= "APP-OT0003 Mandatory Fields Cannot be Blank" ;
messageArray["DATE1_NOT_LESSER_THAN_DATE2"] = "APP-OT0004 # Date & Time should not be less than # Date & Time..." ;
messageArray["INVALID_USER_FUNCTION"]	= "APP-OT0005 This User do not have access to this Function" ;
messageArray["VALID_TIME_SLOTS"]		=  "APP-OT0006 Valid Entry should be between 00:00 and 23:59 ";
//messageArray["APP-OT0039"]="APP-OT0039 Invalid Time format! Allowed Format is HH24:MI";
messageArray["DATE1_NOT_GREATER_THAN_DATE2"] = "APP-OT0007 # date & time should not be greater than # Date & Time..." ;
messageArray["MIN_ONE_OPER_FOR_SPECIALITY"]="APP-OT0008 Atleast one operation must match with operating speciality";
messageArray["NUMERIC_ENTRY_ONLY"]="APP-OT0011 Numeric only allowed in sequence";
messageArray["MONTH_COMPARE_CURMONTH"]="APP-OT0019 Month and year should be greater than current"; 
messageArray["TIME_LESS_THAN"]="APP-OT0023 Selected Time is Lesser than Current Time"; 

messageArray["MAX_LENGTH_DATA"]="APP-OT0025 # Remarks should not more than # character";

messageArray["INCOMPLETE_CHECKLIST"]="APP-OT0O28 CheckList is Incomplete";
messageArray["SPECIALITY_DUPLICATE"]="APP-OT0031 Speciality cannot be duplicated";
messageArray["APP-OT0034"]="APP-OT0034 Theatre Date > Current Date \n  # is not Allowed!";

messageArray["APP-OT0036"]="APP-OT0036 Surgeon or Speciality or Procedure Should be entered";
messageArray["APP-OT0037"]="APP-OT0037 Either Prefered  Date or Prefered Month should be entered";
messageArray["APP-OT0038"]="APP-OT0038 Anaesthesia is not applicable for this operation";
messageArray["APP-OT0040"]="APP-OT0040 Invalid Hours! Hours should be between 00 - 23";
messageArray["APP-OT0041"]="APP-OT0041 Invalid Minutes!  Mins should be between 00 - 59";
messageArray["APP-OT0046"]="APP-OT0046 Select a valid List ID";
messageArray["APP-OT0047"]="APP-OT0047 Srl No should be > 0";
messageArray["APP-OT0050"]="APP-OT0050 This Set and Tray combination already exists!";
messageArray["APP-OT0053"]="APP-OT0053 Selected operation cannot be performed in # Theatre";
messageArray["APP-OT0054"]="APP-OT0054 Select the theatre before recording operations";
messageArray["APP-OT0056"]="APP-OT0056 Anaesthesia is not applicable for this operation or \n Pre Anesthesia is not done for this operation";
messageArray["APP-OT0057"]="APP-OT0057 Anaesthesia is not applicable for this operation \n or Pre/Intra Anesthesia are not done for this operation";
messageArray["APP-OT0058"]="APP-OT0058 Bookings are not selected";
messageArray["APP-OT0060"]="APP-OT0060 Date should be greater than Diary Generated Upto Date";
messageArray["APP-OT0062"]="APP-OT0062 Schedule is not defined for this Surgeon for the selected Theatre.";
messageArray["APP-OT0063"]="APP-OT0063 Invalid PIN No.";
messageArray["APP-OT0064"]="APP-OT0064 Minus symbol should be in the beginning of the number entered";
messageArray["APP-OT0065"]="APP-OT0065 Cannot deduct items more than the total additions for the item, #";
messageArray["APP-OT0068"]="APP-OT0068 # cannot be less than or equal to ZERO";
messageArray["APP-OT0070"]="APP-OT0070 check out time should be less than or equal to system time";

messageArray["APP-OT0071"]="APP-OT0071 # is not done";
messageArray["APP-OT0072"]="APP-OT0072 User doesn't have privilege to change the stage";
messageArray["APP-OT0073"]="APP-OT0073 Selected Slots are blocked for # speciality.  Selected operation(s) do not belong to this speciality.  Do you want to continue?";
messageArray["APP-OT0074"]="APP-OT0074 Do you want to Waitlist this Patient";
messageArray["APP-OT0075"]="APP-OT0075 Do you want to bring waitlisted patient to the vaccated slot";
messageArray["APP-OT0077"]="APP-OT0077 Patient has existing operations for this day, Do you want to continue?";
messageArray["APP-OT0078"]="APP-OT0078 Documentation not completed, Do you want to continue?";
messageArray["APP-OT0079"]="APP-OT0079 Do you want to continue?";

//newly added messages
messageArray["APP-OT0080"]="APP-OT0080 This Operation & Cannot be Performed in ";
messageArray["APP-OT0081"]="APP-OT0081 This Patient is being Rescheduled for & Time(s)";
messageArray["APP-OT0082"]="APP-OT0082 Operation Failed...";
//messageArray["APP-OT0083"]="APP-OT0083 Please Apply the Changes...";
messageArray["APP-OT0084"]="APP-OT0084 Welcome to eHIS";
messageArray["APP-OT0085"]="APP-OT0085 No Associated ICDPCS code for Mandatory Operation";
messageArray["APP-OT0086"]="APP-OT0086 Values are not entered for ";
messageArray["APP-OT0087"]="APP-OT0087 Remarks are mandatory for Discrepancies in ";

function getOTMessage( message_ref ) {
	//alert(message_ref);
    var message = messageArray[message_ref] ;
    if ( message == null ) message = "Message Not Available" ;
    return message ;
}
