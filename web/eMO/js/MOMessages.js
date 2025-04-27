// *** Automatically Generated Using Java Program *** //

var messageArray = new Array() ;

// General Messages

messageArray["INVALID_PATIENT_ID"]				= "APP-MO0001 Invalid Patient Id" ;
messageArray["PATIENT_IS_NOT_DECEASED"]			= "APP-MO0002 Patient is not deceased" ;
messageArray["PATIENT_ALREADY_REGISTERED"]		= "APP-MO0003 Patient is already registered" ;
messageArray["MAX_SHOULD_BE_GT_NEXT"]			= "APP-MO0004 Max number should be greater than next number";
messageArray["MAX_SHOULD_BE_GT_START"]			= "APP-MO0005 Max number should be greater than start number";
messageArray["START_NUM_CANT_BE_ZERO"]			= "APP-MO0006 Start Number cannot be zero";
messageArray["CANT_BE_LT_DECEASED_DATE"]		= "APP-MO0007 Body Receipt/Burial Permit date cannot be less than Deceased date";
messageArray["PM_END_CANT_BE_LT_PM_START"]		= "APP-MO0008 Postmortem End Date/Time cannot be less than Start Date/Time";
messageArray["DATE_CANT_BE_LT_RECEIPT"]			= "APP-MO0009 Date cannot be less than Body Receipt Date";
messageArray["REG_NO_EXCEEDS_MAX_NO"]			= "APP-MO0010 Registration No exceeds the Max No set in the Parameter";
messageArray["AREA_EXCEEDS_CAPACITY"]			= "APP-MO0011 Capacity is full for the Area";
messageArray["REGN_NO_CTRL_TO_BE_SETUP"]		= "APP-MO0012 Registration No Control Parameter has to be setup";
messageArray["SAME_PRACT_ID_NOT_ALLOWED"]		= "APP-MO0013 Same Practitioner cannot be selected" ;
messageArray["PARAMETER_TO_BE_SETUP"]			= "APP-MO0014 MO Parameter Setup has to be done";
messageArray["CUTOFF_PERIOD_CHECK"]				= "APP-MO0015 Less than hours should be greater than More than hours";
messageArray["REGN_NOT_ALLOWED"]				= "APP-MO0016 Registration is not allowed";
messageArray["CANNOT_CREATE_BAYS"]				= "APP-MO0017 Locations are already created as per the Area Capacity";
messageArray["BURIAL_PERMIT_NO_EXISTS"]			= "APP-MO0018 Burial Permit No already Exists" ;
messageArray["BURIAL_PERMIT_NO_GT_ZERO"]		= "APP-MO0019 Next Burial Permit No should be greater than Zero and should not be less than Next Burial Permit No" ;
messageArray["INVALID_BAY"]					    = "APP-MO0020 Invalid Location" ;
messageArray["DONOR_DETAILS_EXCEEDS_LIMIT"]		= "APP-MO0021 Donor Details cannot be greater than 500 characters" ;
messageArray["SAME_WITNESS"]	                = "APP-MO0022 Cannot have the same Witness" ;
messageArray["SPECI_ANOTOM_UNIQUE"]	            = "APP-MO0023 Specimen Type and Anotomical Site should be unique" ;
messageArray["POSTMORTEM_FINDINGS"]	            = "APP-MO0024 Postmortem Findings cannot be greater than 500 characters" ;
messageArray["DATE_CANT_BE_LT_ASSIGN"]	        = "APP-MO0025 Date cannot be less than Assign Date" ;
messageArray["DATE_CANT_BE_LT_PM_START"]	    = "APP-MO0026 Date cannot be less than Postmortem Start Date" ;
messageArray["DATE_CANT_BE_LT_CHECKED_IN"]	    = "APP-MO0027 Date cannot be less than Checked In Date" ;
messageArray["CNT_ASIGN_SAME_DIAG_CODE"]	    = "APP-MO0028 Cannot assign same Diagnosis Code" ;
messageArray["PM_PURPOSE"]	                    = "APP-MO0029 Purpose of performing Postmortem cannot exceed 250 characters" ;
messageArray["DEATH_CAUSE_EXCEEDS_LMT"]	        = "APP-MO0030 Cause of death cannot exceed 250 characters" ;
messageArray["POLICE_DET_EXCEEDS_LMT"]	        = "APP-MO0031 Police details cannot exceed 500 characters" ;
messageArray["EXPRT_ADR_EXCEEDS_LMT"]	        = "APP-MO0032 Address cannot exceed 500 characters" ;
messageArray["BURIAL_PERMIT_NOT_EXIST"]			= "APP-MO0033 Burial Permit does not exist";
messageArray["BURIAL_PERMIT_NOT_ALLOWED"]		= "APP-MO0034 Burial Permit is not allowed because Postmortem is required";
messageArray["OBTAINFROM_SELECT"]	            = "APP-MO0035 Obtained From must be selected" ;
messageArray["REFRESH_INTERVAL_CHK"]	        = "APP-MO0036 Refresh interval should be in between 1 and 9999";
messageArray["BLK_DATE_TIME"]	                = "APP-MO0037 Blocked Until Date time should be greater than system date time" ;
messageArray["VAC_BED_SEL"]	                    = "APP-MO0038 Selected Location is currently allocated/blocked" ;
messageArray["BUR_NT_GEN"]	                    = "APP-MO0039 Burial Permit is not yet generated.Cannot Proceed...." ;
messageArray["POLICE_DET_MAND"]					= "APP-MO0040 Police 61 details must be captured" ;
messageArray["DATE_CANT_BE_LT_RELEASE"]			= "APP-MO0041 Date cannot be less than Release Date";
messageArray["CAUSE_OF_DEATH_NOT_REC"]			= "APP-MO0042 Cause of Death not Recorded. Cannot Proceed." ;
messageArray["CNT_REASSIGN"]			        = "APP-MO0043 Order has been placed.Cancel Order To Reassign Area." ;
messageArray["START_DATE_GREATER_SYSDATE"]		= "APP-OP0045 Date cannot be greater than system date";
messageArray["INVALID_DATE_TIME"]		        = "APP-SM0004 Invalid Date Format" ;
messageArray["SHD_NOT_BE_BLANK"]				= "APP-DR0022 Patient ID cannot be blank" ;
messageArray["SHOULD_NOT_BE_BLANK"]				= "APP-002000 Cannot be Blank" ;
messageArray["RECORD_INSERTED"]				    = "APP-SM0001 Operation Completed Successfully ...." ;
messageArray["RECORD_MODIFIED"]				    = "APP-SM0002 Operation Completed Successfully ...." ;

function getMessage( message_ref ) {    
	var message = messageArray[message_ref] ;
    if ( message == null ) message = "Message Not Available"  ;
    return message ;
}


