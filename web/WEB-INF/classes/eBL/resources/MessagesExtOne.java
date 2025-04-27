/* 
Sr No        Version        Incident/TFS         SCF/CRF             Developer Name
-------------------------------------------------------------------------------------
1            V210113             8157       NMC-JD-CRF-0072             Shikha Seth
2            V210208			 7339  	    MOHE-CRF-0050		        Mohana Priya K
3            V210223			     	    AMS-CRF-0249		        Ram kumar S
4            V210224             8157       NMC-JD-CRF-0072             Shikha Seth
5			 V210226 			 			MOHE-CRF-0050.1				Ram kumar S
6			 V210615			20139	    MOHE-CRF-0055.2			   Mohana Priya K
7            V210618            16777	      PMG2021-COMN-CRF-0076      Palani 
8                               34387       TH-KW-CRF-0084            KAMATCHI S
9 			 V221227						PMG2022-COMN-CRF-0009     Namrata Charate
10 			V230125								TH-KW-CRF-0097				Pruthvi Raj
11			V230707							AAKH-CRF-0142.1					Namrata Charate	
12			V230911						NMC-JD-CRF-0102.2				Mohanapriya	
13 			V240119            56189        BL-RBU-GHL-CRF-0025-US001-01   Namrata Gurav
14			V240131						RBU-GHL-CRF-0026-US003				Namrata Charate
15			V240213				56587	NMC-JD-CRF-102.17				Monika Gupta
16			V240301						NMC-JD-CRF-0102.24							  Namrata Charate
17			V240417							MOHE-CRF-0166		  Namrata Charate
18 			V240722				62855	ML-MMOH-CRF-2045				Monika Gupta
--------------------------------------------------------------------------------------
 */

package eBL.resources;

import java.util.ListResourceBundle;

/**
 * @author Aravindh H
 *
 */
public class MessagesExtOne  extends ListResourceBundle implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	protected Object[][] getContents() {
		return contents;
	}	
	static final Object[][] contents = {
		{"BL0862", "APP-BL0862 Billing service period should be within the discount service period"},
		{"BL0863", "APP-BL0863 Discount service period should be within the Billing service period"},
		{"BL0875", "APP-BL0875 Billing group duration expired on '$'. Hence, couldn't be selected. Pl contact IT dept"},//Added V191218-Aravindh/GHL-CRF-0599
		{"BL0876", "APP-BL0876 Billing group was valid from '$' to '#'. Hence, couldn’t be selected. Pl contact IT dept"},//Added V191218-Aravindh/GHL-CRF-0599
		{"BL0878", "APP-BL0878 Bill Date cannot be null"},
		{"BL0738", "APP-BL0738 Statement From/To Date Cannot Be Null"}, //Added V201204- MOHE-CRF-0050.4/Mohana Priya K
		{"BL0734", "APP-BL0734 Select From Period and then proceed with To Period selection"}, //Added against MOHE-CRF-0050.4
		{"BL0735", "APP-BL0735 To Period should be Greater than or Equal to From period"},//Added against MOHE-CRF-0050.4
		//V210113 start
		{"BL0922", "APP-BL0922 Coupon code not found"},
		{"BL0923", "APP-BL0923 Total Coupon amount exceeds remaining settlement amount. This excess will get lapsed if you proceed."},
		{"BL0924", "APP-BL0924 Coupons already selected, do you want to release them"},
		//V210113 end
		{"BL0932", "APP-BL0932 Coupon Codes Selected. Still do you want to cancel?"},	//V210224 
		{"BL0934", "APP-BL0934 Please select the coupons to proceed"}, 	//V210224 
	
		{"BL0733", "APP-BL0733 Selected Period should be less than system Date Period"}, //Added against MOHE-CRF-0050.4/V210107
		{"BL0926", "APP-BL0926 Practitioner Cannot be Blank"}, //Added against GHL-CRF-0631
		{"BL0930", "APP-BL0930 Save or discard changes before proceeding"}, //V210208
		{"BL7141", "APP-BL7141 No Group is Setup for Exempted Receipts,Cannot Proceed"},//Added against MOHE-CRF-0050
		{"BL6389", "APP-BL6389 No Group is Setup for Undefined Services,Cannot Proceed"},
		{"BL0929", "APP-BL0929 Interim Bill Authorization Cannot Be Applicable"},//Added FOR MMS-CRF-100.1 
		{"BL0931", "APP-BL0931 This record is Duplicated"},//Added against MOHE-CRF-0050/V210216
		{"BL0928", "APP-BL0928 Patient age does not fall under billing group age range"},//Added V210223
		{"BL7448", "APP-BL7448 Either Nursing Unit or Admisson No. Should be Entered"},//V210226 MOHE-CRF-50.1
		{"BL2098", "APP-BL2098 Only Single Admission No can be processed at a time"}, //Added V210226
		{"BL0939", "APP-BL0939 Date range cannot be more than 31 days"}, //V210615
		{"BL0940", "APP-BL0940 Bill From date cannot be blank"},//V210615
		{"BL0941", "APP-BL0941 Bill To date cannot be blank"}, //V210615
		{"BL0942", "APP-BL0942 Package will be associated and recalculated"},//Added V210618
		{"SM2159", "APP-SM2159 Operation Completed Sucessfully..."},//Added V210618 
		{"BL0943", "APP-BL0943 Recalculation will be done"}, //V210818
		{"BL8654", "APP-BL8654 Replace is not allowed for Charge Base Service "}, //V210818
		{"BL0919", "APP-BL0919 Min charge cannot be null "}, //Added against MMS-QH-CRF-0128	by Manivel N
		{"BL8673", "APP-BL8673 Refund not allowed for classification/Material Item "},	
		{"BL0949", "APP-BL0949 Policy Diagnosis Details already exists for this combination "},
		{"BL0950", "APP-BL0950 Date range given in the line level should be equal or within the date range given in diagnosis type "},
		{"BL0951", "APP-BL0951 Cannot proceed please select the service location"},
		{"BL0952", "APP-BL0952 Token dispensed details cannot be captured as Primary key of queue number is blank"},
		{"BL0953", "APP-BL0953 Primary key of queue number is blank. Do you wish to proceed?"},//V221023/TH-KW-CRF-0020.7	/Mohanapriya
		{"BL0954", "APP-BL0954 Coder Clearance not completed. Cannot proceed."},
		{"BL0955", "APP-BL0955 Discharge Advice not prepared. Cannot provide Coder Clearance."},
		{"BL0956", "APP-BL0956 Discharge Bill is generated. Cannot provide Cancel Coder Clearance"},
		{"BL0957", "APP-BL0957 Discharge advice not prepared cannot provide Insurance Clearance"},//V221130
		{"BL0958", "APP-BL0958 Discharge bill generated cannot cancel insurance clearance"},//V221130
		{"BL0959", "APP-BL0959 Discharge bill generated cannot provide insurance clearance"},//V221130
		{"BL1414", "APP-BL1414 Cannot cancel Bill, as this is under claim"},
		{"BL0960", "APP-BL0960 Insurance clearance not provided, cannot generate discharge bill"},//V221130
		{"BL0961", "APP-BL0961 Insurance Clearance cancelled successfully"},//V221130
		{"BL0962", "APP-BL0962 Insurance clearance is already provided, cannot change approval status"},//V221130
		{"BL0963", "APP-BL0963 Privilege is not provided for the selected User Type"},//Added by Kamatchi S for TH-KW-CRF-0084
		{"BL0964", "APP-BL0964 Encounter From Date should not be greater than To Date and Current Date"},//Added by Kamatchi S for TH-KW-CRF-0084
		{"BL0965", "APP-BL0965 Encounter From and To Date Should not be blank"},//Added by Kamatchi S for TH-KW-CRF-0084
		{"BL0966", "APP-BL0966 Encounter To Date should not be greater than the current system date"},//Added by Kamatchi S for TH-KW-CRF-0084
		{"BL0967", "APP-BL0967 User Type cannot be blank"},//Added by Kamatchi S for TH-KW-CRF-0084
		{"BL0968", "APP-BL0968 Privilege is not provided for Login User. Cannot Proceed"},//Added by Kamatchi S for TH-KW-CRF-0084
		{"BL0969", "APP-BL0969 Selected Date should not greater than 7 days"},//Added by Kamatchi S for TH-KW-CRF-0084
		{"BL0970", "APP-BL0970 Privilege is not provided for the Record Approval User View and Front Office User View"},//Added by Kamatchi S for TH-KW-CRF-0084
		{"BL0971", "APP-BL0971 Record Approval User View or Front Office User View need to be Selected"},//Added by Kamatchi S for TH-KW-CRF-0084
		{"BL0972", "APP-BL0972 Privilege is not provided for the selected View"},//Added by Kamatchi S for TH-KW-CRF-0084
		{"BL0973", "APP-BL0973 Encounter To Date should not be lesser than Encounter From Date"},//Added by Kamatchi S for TH-KW-CRF-0084
		{"BL6334", "APP-BL6334 No Record has been Selected! Please Select Any One of the Record"},//V221227
		{"BL0974", "APP-BL0974 No bill generated for the selected records – cannot print"},//V221227
		{"BL7489", "APP-BL7489 Patient already checked out - cannot cancel clearance"}, //V240119
		{"BL0975", "APP-BL0975 Unbilled charges exist for previous encounter - Do you want to generate bill"},	
		{"BL0976", "APP-BL0976 Consent Amount cannot be blank or zero"},
		{"BL0977", "APP-BL0977 Consent date cannot be blank"},
		{"BL0978", "APP-BL0978 Consent date cannot be past date"}, //V230125
		{"BL2006","APP-BL2006 Invalid Package Group code"},//V230217
		{"BL0979", "APP-BL0979 Exclusion not applicable for Items"},//V231121
		{"BL0980", "APP-BL0980 Same category (Primary or Specialized) cannot be mapped against the same referral category twice."},  //V230210
		{"BL0981", "APP-BL0981 Encounter To Date Cannot be greater than 30 Days from Encounter from Date"},		//Added by Monika for AAKH-0152 CRF-US0013
		{"BL0983", "APP-BL0983 Patient not eligible"},		//Added by Namrata for AAKH-0141.1 CRF-US0003
		{"BL0984", "APP-BL0984 Eligibility check has not been performed. Unable to proceed with visit registration!"},   //Added by Namrata for AAKH-0141.1 CRF-US0003
		{"BL0985", "APP-BL0985 Invalid response received. Unable to proceed with visit registration!"},   //Added by Namrata for AAKH-0141.1 CRF-US0003
		{"BL0986", "APP-BL0986 Authorization Reason Cannot be Blank"},   //Added by Namrata for AAKH-0141.1 CRF-US0003
		{"BL0987", "APP-BL0987 Please select the authorisation reason"},  //Added by Namrata for AAKH-0141.1 CRF-US0003
		{"BL0990", "APP-BL0990 Uploading File size must be less than 2MB"},		
		{"BL0991", "APP-BL0991 Only pdf files are allowed!"},   
		{"BL0992", "APP-BL0992 Please Provide Clarification Document"},  //NMC-JD-CRF-0102.2
		{"BL0871", "APP-BL0871 Markup Charges Applicable for this Encounter , Generating Markup Charges now."}, //RBU-GHL-CRF-0022
		{"BL0994", "Emergency charges are there. Do you want to transfer charges from Emergency to IP?"},	//Added By Monika For RBU-GHL-CRF-0023 TF
		{"BL0709", "APP-BL0709 Neither PAN card nor Form 60 is collected for this patient, Please get the details"},		//Added By Monika For RBU-GHL-CRF-0023 TF
		{"BL0768", "APP-BL0768 Package Subscription Date should be greater than or equals to Encounter Date"}, //V240131
		{"BL0049", "APP-BL0049 Settlement has been done for one or more bills for this encounter. Cannot Modify the billing Group"}, //V240131
		{"BL0917", "APP-BL0917 Only PDF or JPEG file type is allowed"},  //V240213
		{"BL0997", "APP-BL0997 Eligibility Code is Mandatory"}, //V240301
		{"BL0998", "APP-BL0998 Offline Eligibility Date is Mandatory"}, //V240301
		{"BL0999", "APP-BL0999 Future Date is not allowed"}, //V240301
		//V240404-RBU-GHL-CRF-0022.1
		{"BL6351","APP-BL6351 Special characters are not allowed"},
		{"BL0055","APP-BL0055 Additional ID Mandatory for Taxation. Please get the details from the patient"},
		{"BL0058","APP-BL0058 Forms-60 is mandatory for all Non Citizens."},
		{"BL0066","APP-BL0066 Enter matching values for both the ID fields"},
		{"BL0756","APP-BL0756 # must be combination of alphabet and numeric characters."},
		{"BL0755","APP-BL0755 # value length should be of $ Characters."},
		{"BLSS0072","APP-BLSS0072 $ # value cannot be blank"},
		{"BLSS0073","APP-BLSS0073 Please select concern id personnel/ Form 60 "},
		{"BL0067","APP-BL0067 PAN holder name is mandatory when Relation - Others is selected"},
		
		{"BL0070", "APP-BL0070 Encounter Date range cannot be more than 31 days"}, //V240417
		{"BL0071", "APP-BL0071 Bill Duration Date range cannot be more than 31 days"}, //V240417
		{"BL0072", "APP-BL0072 Document Generation Date range cannot be more than 31 days"}, //V240417
		{"BL0073","APP-BL0073 Bill Duration From date should not be greater than Current date "},  //V240417
		{"BL0074","APP-BL0074 Bill Duration To date should not be greater than Current date "},  //V240417
		{"BL0075","APP-BL0075 Document Generation From date should not be greater than Current date "},  //V240417
		{"BL0076","APP-BL0076 Document Generation To date should not be greater than Current date "},	//V240417	
		{"BL0077","APP-BL0077 Folder path is not available for the Encounter "},	//V240417	
		{"BL1543","APP-BL1543 Operation Completed Successfully "},	
		{"BL6354","APP-BL6354 Package Bill Exists in this Encounter, Do you want to Continue? "},
		{"BL6299","APP-BL6299 Bill transferred to DCP cannot modify "},	
		{"BL0049", "APP-BL0049 Settlement has been done for one or more bills for this encounter. Cannot Modify the billing Group"},
		{"BL6518", "APP-BL6518 Encounter ID cannot be blank"},
	    {"BL9851", "APP-BL9851 No Payers for Primary Billing Group. Click OK to change secondary billing group as a primary one"},
	    {"BL8663","APP-BL8663 Different Billing Class, Cannot Associate"},
		{"BL6160", "APP-BL6160 No Changes are made in Financial Details"},
		{"BL0993", "APP-BL0993 Package amount will be increased/decreased as per the modified Billing Group"},
		{"BL1415","APP-BL1415 Cannot Cancel Discharge/Checkout, as this is under claim"},
		{"BL1413", "APP-BL1413 Rate cannot be less than the minimum charge in billing service setup"},//V240722
		{"BL0996", "APP-BL0996-EM User # is linked to another AD User. Cannot login."},
		{"BL1090", "APP-BL1090-This User is disabled. Contact System Administrator"},
		{"BL0995", "APP-BL0995-This AD User is disabled. Contact System Administrator"},
		{"BL1418", "APP-BL1418 Please select report type"},	//RBU GHL CRF-0034
		{"BL1419", "APP-BL1419 Customer Code Input must be 'JPNIND'"},	//RBU GHL CRF-0034
		{"BL00613","APP-BL00613 To date cannot be less than From date"},// RBU-GHL-CRF-0034
		{"BL009150", "APP-BL009150 This field cannot be Blank"},	//RBU GHL CRF-0033
		{"BL9809", "APP-BL9809 From Encounter cannot be same as the To Encounter"},	//RBU GHL CRF-0033
		{"BL1472","APP-BL1472 To modify the search criteria, please clear the current values"}, //Added by Siraj for RBU GHL CRF-0034 
		{"BL1546","APP-BL1546 Transfers can only occur within the same patient ID."} ////Added by Siraj for RBU GHL CRF-0034
		
		

	};
}
