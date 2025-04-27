/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBT.resources;

import java.util.*;

public class Messages extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents =

	{
			{"RECORD_SELECT"," Select Any record en Press Request or Print"},	
			{"COMPLETE"," Successfully Completed"},	
			{"VOLUME_NULL","  BT0120 Transfused volume should not be Null"},	
			{"VOLUME_LT","  BT0121 Transfused volume should  be less an Current Volume"},				
			{"DATE_ST_GT_ISSUE","  BT0114 Transfuse start date should be greater en ISSUED Date"},		
			{"DATE_EN_LT_RESER"," BT0119 Transfuse end date should be less en RESERVED Date"},		
			{"DATE_EN_LT_SYS"," BT0117 Transfuse end date should not be greater en SYSTEM Date"},
			{"DATE_EN_GT_TRANS"," BT0118 Transfuse end date should be greater en  Transfuse start date"},	
			{"DATE_EN_LT_RESER"," BT0119 Transfuse end date should be less en RESERVED Date"},	


			{"TXT_PRACT_NULL"," BT0141 Transfuse Practitioner Name should be Null"},
			{"PRACT_ID_CURRENT_USER"," BT0122 Error in Practitioner Selection"},	
			{"REACTION_CODE_NULL"," BT0131 Reaction code should not be Null"},	
			{"DATE_ST_NULL"," BT0113 Transfuse start date can not be Null"},	
			{"DATE_EN_NULL"," BT0116 Transfuse End date can not be Null"},	
			{"PARTIAL_TRANS_CODE"," BT0132 Partial Transfusion Reason  should not be Null"},	
			{"PRACT_ID_CURRENT_USER"," BT0122 Error in Practitioner Selection"},	
			{"PARTIAL_TRANS_CODE"," BT0132 Partial Transfusion Reason  should not be Null"},	
			{"DATE_ST_LT_RESER"," BT0115 Transfuse start date should be less en RESERVED Date"},		
			{"DATE_EN_GT_TRANS"," BT0118 Transfuse end date should be greater en  Transfuse start date"},		
			{"DATE_EN_LT_RESER"," BT0119 Transfuse end date should be less en RESERVED Date"},		
			{"TRANS_INVESTIGATE"," Please order transfusion reaction investigation"},
			{"DEPT_NOT_BLANK"," BT0120 Department cannot be blank"},	
			{"FROMTO_DATE_GRTR_THAN_CURR_DATE"," BT0121 From Date/To Date Cannot be greater than Current Date"},
			{"UPLOAD_PROPER_FILE_TYPE"," BT0122 Please upload JPG, GIF, PNG, TIF or PDF Files Only"},
			{"NO_IMAGE_TO_DELETE"," BT0123 No Image selected to Delete"},
			{"UNIT_NO_NOT_VALID"," BT0125 Unit No is not valid"},//Added by Ashwini on 15-Mar-2018 for MMS-DM-CRF-0137
			{"PRODUCT_CODE_NOT_VALID"," BT0126 Product Code is not valid"},//Added by Ashwini on 15-Mar-2018 for MMS-DM-CRF-0137
			{"BLOOD_UNIT_TRANSFUSED"," BT0127 Blood unit is already transfused. Cannot proceed further."},//Added by Ashwini on 15-Mar-2018 for MMS-DM-CRF-0137
			{"UNIT_TRANSFUSED"," BT0128 Blood unit is Transfused."},//Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589
			{"UNIT_TRANSFERRED"," BT0129 Blood unit is Transferred."},//Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589
			
			/*Added by Niveditha For GHL-CRF-0602.1*/
			{"DATE_MORE_THAN_30_DAYS"," BT0130 Date range exceeds a month period"},
			{"ASSIGN_PATHOLOGIST_BLANK","BT0133 Please select the assign pathologist."},
			{"REPORING_FACILITY_PATHOLOGIST_BLANK","BT0134 Please select the reporting facility."},
			{"NO_RECORDS_HAVE_BEEN_SELECTED","BT0135 Please select a record."},
			{"RECORD_INSERTED","BT0136 Operation Completed Successfully."},
			{"LAB_DEPT_BLANK","BT0137 Lab Dept Cannot Be Blank."},
			{"GREATER_THAN_SYS_DATE","BT0138 Date cannot be greater than system date."},
			{"TO_DT_GR_EQ_FM_DT","BT0139 To Date should be greater than or equal to From date" },
			{"SPNO_DATE_BLANK","BT0140 Please Enter Specimen Registered Date or Specimen Number" },
			{"SP_NO_INVALID_TYPE","BT0141 Please Enter a Valid Specimen Number" }
			 
			
		};
}		
