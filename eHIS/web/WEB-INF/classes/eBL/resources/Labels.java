/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ************************************************************************************/
/* 
Sr No        Version        Incident/TFS         SCF/CRF             Developer Name
-------------------------------------------------------------------------------------
1            V201027            74212       MOHE-CRF-0050.2          Ram kumar S
2			 V201102			74099		NMC-JD-CF-0011.1		 Muthukumar N
3            V201103         74213/5475     MOHE-CRF-0050.3          Mohana Priya K
4            V201109            74212       MOHE-CRF-0050.2      	 Shikha Seth
5            V201117         74212/4939     MOHE-CRF-0050.2      	 Mohana Priya K
6            V201012        			    MOHE-CRF-0050.3      	 palaninarayanan
7            V201118        8071/74237      MOHE-CRF-0050.4          Mohana Priya K
8            V210113             8157       NMC-JD-CRF-0072          Shikha Seth
9            V210112            7661        MOHE-CRF-0050.1          Ram kumar S
10			 V210517			18503		BL-MOHE-CRF-0075-
											OP/IP Grouped Bills- 3T  Mohana Priya K
11			 V210517            16591		MOHE-CRF-0055.1			 Nandhini M
12           V210419			19422     	GHL-CRF-0639-US001		 NandhiniM/MuthuN
13			 V210602			19511		MMS-DM-CRF-118.9		 Nandhini M
14			 V210615            20139	    MOHE-CRF-0055.2			 Mohana Priya K
15			 V210727           21718		MOHE-SCF-0125-TF		Mohana Priya K
16			 V210802            16777	    PMG2021-COMN-CRF-0076	 Mohana Priya K
17			 V211027			18595	    MMS-DM-CRF-0185			 Mohana Priya K
18			V220525							GHL-CRF-0632     		 Mohanapriya K
19			V220905				33891		TH-KW-CRF-0093           Mohanapriya K
20           V221020						MMS-DM-CRF-0209 		 Namrata Charate
21			V221023							TH-KW-CRF-0020.7		Mohanapriya
22			V221108                        NMC-JD-CRF-0192          Namrata Charate
23			V221113           38319       MMS-DM-CRF-0209.3-US005 / 01          Namrata Charate
24                            34387       TH-KW-CRF-0084            KAMATCHI S
25			V221227								PMG2022-COMN-CRF-0009   Namrata Charate
26          V230106                       MMS-DM-CRF-0209.4            Srinivasa
27 			V230119								TH-KW-CRF-0163-0164			Namrata Charate
28			V230125								TH-KW-CRF-0097				Pruthvi Raj
29			V230210								MMS-DM-CRF-0209.5			Namrata Charate
30			V230707							AAKH-CRF-0142.1					Namrata Charate	
31 			V231017							NMC-JD-CRF-0102.3			Namrata Charate
32			V240229							NMC-JD-CRF-0102.15			Namrata Charate
33			V240213							NMC-JD-CRF-102.17			Monika Gupta
34			V240301							NMC-JD-CRF-0102.24			Namrata Charate
35			V240417							MOHE-CRF-0166				Namrata Charate
36          V240522                         MOHE-CRF-0166               Khaled Samir
--------------------------------------------------------------------------------------
 */
package eBL.resources;   
import java.util.*;

public class Labels extends ListResourceBundle implements java.io.Serializable{
	public Object[][] getContents() {
         return contents;
    }
	static final Object[][] contents = {
		{"eBL.ACCOUNT_CODE.label","Account Code"},
		{"eBL.ACTUAL_AMT.label","Actual Amount"},
		{"eBL.ADDITIONAL_FACTOR.label","Additional Factor"},
		{"eBL.AMT_SETTLED.label","Amount Settled"},
		{"eBL.ANNUAL_INCOME.label","Annual Income"},
		{"eBL.APPROVAL_CODE.label","Approval Code"},
		{"eBL.APPROVED_AMT.label","Approved Amount"},
		{"eBL.APPROVED_DAY.label","Approved Days"},
		{"eBL.AUTH_SCREEN.label","Authorization Screen"},
		{"eBL.AVAILABLE_PACKAGE.label","Available Packages"},
		{"eBL.AVAILED.label","Availed"},
		{"eBL.AVAILED_PRICE.label","Availed Price"},
		{"eBL.BANK_NAME.label","Bank Name"},
		{"eBL.BASE_CHARGE_AMT.label","Base Charge Amount"},
		{"eBL.BASE_QTY.label","Base Qty"},
		{"eBL.BASE_RATE.label","Base Rate"},
		{"eBL.BASIC_BILLING_GROUP.label","Basic Billing Group"},
		{"eBL.BILL_DATE.label","Bill Date"},
		{"eBL.BILL_DOC_NO.label","Bill Document No"},
		{"eBL.BILL_DOC_TYPE.label","Bill Document Type/Number"},
		{"eBL.BILL_NO.label","Bill No"},
		{"eBL.BILL_SLMT_DTL.label","Bill Settlement Details"},
		{"eBL.BILLED_AMT.label","Billed Amount"},
		{"eBL.BILLING_GROUP_EXPLANATORY_NOTE.label","Billing Group Explanatory Note"},
		{"eBL.BILLING_GROUP_REMARK.label","Billing Group Remarks"},
		{"eBL.BILLING_SERVICE_PANEL.label","Billing Service/Panel"},
		{"eBL.BRANCH_NAME.label","Branch Name"},
		{"eBL.CANCEL_AMT.label","Cancel Amount"},
		{"eBL.CASH_CLOSING_BALANCE.label","Cash Closing Balance"},
		{"eBL.CASH_COUNTER.label","Cash Counter"},
		{"eBL.CASH_COUNTER_LOGOUT.label","Cash Counter Logout"},
		{"eBL.CASH_INSTR_DATE.label","Cash Instrument Date"},
		{"eBL.CASH_INSTR_REF.label","Cash Instrument Reference"},
		{"eBL.CASH_INSTR_REMARKS.label","Cash Instrument Remarks"},
		{"eBL.CASH_OPENING_BALANCE.label","Cash Opening Balance"},
		{"eBL.CASH_SLMT_TYPE.label","Cash Settlement Type"},
		{"eBL.CASHIER_JOURNAL.label","Cashier Journal"},
		{"eBL.CLOSED_YN.label","Closed {Y/N}"},
		{"eBL.CLOSING_DATE_TIME.label","Closing Date Time"},
		{"eBL.CONFIRMATION_OF_BILLING_GROUP.label","Confirmation of Billing group"},
		{"eBL.COPAY_INDICATOR.label","Copay Indicator"},
		{"eBL.COPAY_VALUE.label","Copay Value"},
		{"eBL.CREDIT_AUTH_DATE.label","Credit Auth Date"},
		{"eBL.CREDIT_AUTH_REF.label","Credit Auth Reference"},
		{"eBL.CREDIT_AUTH.label","Credit Authorization"},
		{"eBL.CREDIT_CARD_CO.label","Credit Card Co."},
		{"eBL.CREDIT_DOC_DATE.label","Credit Doc Date"},
		{"eBL.CREDIT_DOC_DESC.label","Credit Doc Desc"},
		{"eBL.CREDIT_DOC_REF.label","Credit Doc Ref"},
		{"eBL.CUSTOMER_DTL.label","Customer Details"},
		{"eBL.CUSTOMER_GROUP.label","Customer Group"},
		{"eBL.CUSTOMER_GROUPS.label","Customer Short Name"},
		{"eBL.long_name.label","Customer  Long Name"},
		{"eBL.long_desc.label","Customer Group Long Name"},
		{"eBL.description.label","Customer Group Short Name"},
		{"eBL.IncludeHomeMedication.label","Include Home Medication"},
		{"eBL.includeHomeMedication.label","Include Home Medication"},//sarath
		{"eBL.InclHomeMedication.label","Include Home Medication"},
		{"eBL.cust_group_long_name.label","Long Description"},

		{"eBL.CUSTOMER_PAYABLE_AMT.label","Customer Payable Amount"},
		{"eBL.DAY_TYPE_CODE.label","Day Type Code"},
		{"eBL.DISCOUNT_PERC.label","Discount %"},
		{"eBL.DISC_PERC_ON_CURR_PRICE.label","Discount % on Current Price"},
		{"eBL.DISC_PERC_ON_PROP_PRICE.label","Discount % on Proportionate Price"},
		{"eBL.DISCOUNT_AMT.label","Discount Amount"},
		{"eBL.DISCREPANCY_AMT.label","Discrepancy Amount"},
		{"eBL.DOC_AMT.label","Document Amount"},
		{"eBL.DOC_END_DATE.label","Document End Date"},
		{"eBL.DOC_REF.label","Document Reference"},
		{"eBL.DOC_START_DATE.label","Document Start Date"},
		{"eBL.ELIG_LEVEL.label","Eligibility Level"},
		{"eBL.EMPLOYER_NAME.label","Employer Name"},
		{"eBL.EXCLUSION_SERVICE.label","Exclusion Services"},
		{"eBL.EXT_ALLOWED.label","External Allowed"},
		{"eBL.FAMILY_ASSET.label","Family Asset"},
		{"eBL.GL_HOLDER_NAME_NRIC.label","GL Holder Name/NRIC"},
		{"eBL.GOVT_REFERRAL.label","Govt. Referral"},
		{"eBL.GROSS_AMT.label","Gross Amount"},
		{"eBL.GROSS_CHARGE.label","Gross Charge"},
		{"eBL.GROSS_CHARGE_AMT.label","Gross Charge Amount"},
		{"eBL.HOSPITAL_REQUEST.label","Hospital's Request"},
		{"eBL.ILLNESS_DEDUCTIBLE.label","Illness Deductible"},
		{"eBL.INCLUSION_SERVICE.label","Inclusion Services"},
		{"eBL.IP_ALLOWED.label","Inpatient Allowed"},
		{"eBL.INSTR_DATE.label","Instrument Date"},
		{"eBL.INSTR_REF.label","Instrument Reference"},
		{"eBL.INSTR_REMARK.label","Instrument Remarks"},
		{"eBL.INS_DTL.label","Insurance Details"},
		{"eBL.INS_DTL_DOC_REF.label","Insurance Details / Document References"},
		{"eBL.LOGGED_IN_USER.label","Logged In User"},
		{"eBL.LOGIN_DATE_TIME.label","Login Date Time"},
		{"eBL.LOGOUT_DATE_TIME.label","Logout Date Time"},
		{"eBL.NET_CHARGE.label","Net Charge"},
		{"eBL.NO_OF_DEPENDANTS.label","No. of Dependants"},
		{"eBL.NON_INS_BILLING_GROUP.label","Non Insurance Billing Group"},
		{"eBL.NON_INS_CUSTOMER_CODE.label","Non Insurance Customer Code"},
		{"eBL.NON_INS_FRAME_TITLE.label","Non-Insurance Settlement Details / Document References"},
		{"eBL.ONLINE_APPROVAL.label","Online Approval"},
		{"eBL.OP_EMG_ALLOWED.label","Outpatient/Emergency Allowed"},
		{"eBL.OPERATOR_ID.label","Operator Id"},
		{"eBL.OTHER_SERVICE_AMT.label","Other Service Amount"},
		{"eBL.PACKAGE_BILL.label","Package Bill"},
		{"eBL.PKG_BILL_NUM_DATE.label","Package Bill No/Date"},
		{"eBL.PACKAGE_BILL_REF.label","Package Bill Reference"},
		{"eBL.PKG_BILL_TYPE.label","Package Bill Type"},
		{"eBL.PACKAGE_DTL.label","Package Details"},
		{"eBL.PKG_PRICE.label","Package Price"},
		{"eBL.PAID_AMT.label","Paid Amount"},
		{"eBL.PATIENT_HCARD_NOT_AVAILABLE_EXPIRED.label","Patient Healthcard is not available / Expired"},
		{"eBL.PATIENT_REMARK.label","Patient Remarks"},
		{"eBL.PATIENT_REQUEST.label","Patient's Request"},
		{"eBL.PAYABLE_AMT.label","Payable Amount"},
		{"eBL.PAYER_NAME.label","Payer's Name"},
		{"eBL.PAYER_REF_ID.label","Payer's Ref ID"},
		{"eBL.POLICY.label","Policy"},
		{"eBL.POLICY_DTL.label","Policy Details"},
		{"eBL.POLICY_EXPIRY_DATE.label","Policy Expiry Date"},
		{"eBL.POLICY_NO.label","Policy No"},
		{"eBL.POLICY_TYPE.label","Policy Type"},
		{"eBL.POLICY_TYPE_CODE.label","Policy Type Code"},
		{"eBL.PRE_APP_YN.label","Pre-Approval?"},
		{"eBL.PRICE_CLASS_CUST_SPECIFIC.label","Price Class/Customer Specific"},
		{"eBL.PVT_REFERRAL.label","Private Referral"},
		{"eBL.RECEIPT_AMT.label","Receipt Amount"},
		{"eBL.RECEIPT_TIME.label","Receipt Time"},
		{"eBL.RECEIPT_TYPE.label","Receipt Type"},
		{"eBL.FrombillNumber.label","BillDocType/Number"},
		{"eBL.From_doc_type_code.label","From doc type code"},
		{"eBL.To_doc_type_code.label","To doc type code"},
		{"eBL.REFUND.label","Refund"},
		{"eBL.RELATIONSHIP_WITH_GL_HOLDER.label","Relationship with GL Holder"},
		{"eBL.HIGHER_CLASS_CHARGE_BASIS_TITLE.label","Request for Higher Class and Associated Charging Basis"},
		{"eBL.RESPONSIBLE_FOR_PAYMENT.label","Responsible for Payment"},
		{"eBL.SALE_DRAFT_NO.label","Sale Draft No"},
		{"eBL.SELF_PAY_BILL_AMT.label","Self Pay Bill Amount"},
		{"eBL.SetDefaultValue.label","Set Default Value"},
		{"eBL.SLMT.label","Settlement"},
		{"eBL.SLMT_CLOSING_DTL.label","Settlement Closing Details"},
		{"eBL.SLMT_DTL_DOC_REF.label","Settlement Details / Document References"},
		{"eBL.SLMT_INDICATOR.label","Settlement Indicator"},
		{"eBL.SHIFT_STARTED_BY.label","Shift Started By"},
		{"eBL.TIME_TYPE_CODE.label","Time Type Code"},
		{"eBL.TOTAL_SLMT.label","Total Settlements"},
		{"eBL.UNBILLED_AMT.label","	Unbilled Amount"},
		{"eBL.UPDATE_PATIENT_FIN_DTL.label","Update Patient Financial Details"},
		{"eBL.VALID_DAYS.label","Valid Days"},
		{"eBL.VALUE_QTY.label","Value/Qty"},
		{"eBL.VISIT_CHARGE_DTL.label","Visit Charge Details"},
		{"eBL.VISIT_DEDUCTIBLE.label","Visit Deductible"},
		{"eBL.ADD_SERV_PRICE.label","Additional Service Price"},
		{"eBL.ADD_SERV_QTY.label","Additional Service Qty"},
		{"eBL.BLNG_SERV_CODE.label","Billing Service Code"},
		{"eBL.SERV_PRICE.label","Service Price"},
		{"eBL.PKG_VAL_QTY.label","Package Value/Qty"},
		{"eBL.APPLY_REFUND.label","Apply Refund"},
		{"eBL.EXPLANATORY_NOTE.label","Explanatory Note"},
		{"eBL.VALID_DOCUMENTS.label","Valid Documents"},
		{"eBL.VALID_FROM.label","Valid From"},
		{"eBL.VALID_TO.label","Valid To"},
		{"eBL.RELATIONSHIP_CODE.label","relationship_code"},
		{"eBL.LONG_DESCRIPTION.label","long_desc"},
		{"eBL.RELATIONSHIPS.label","Relationships"},
		{"eBL.CASH_SETTLEMENT.label","Cash Settlement"},
		{"eBL.USER_SEARCH.label","User Search"},
		{"eBL.RECEIPT_TYPES.label","Receipt Types"},
		{"eBL.ACCOUNT_CODES.label","Account Codes"},
		{"eBL.ACCOUNTING_DEPT.label","Accounting Departments"},
		{"eBL.CREDIT_CARD_COMP_NAMES.label","Credit Card Company Names"},
		{"eBL.SUBMIT_REPORT.label","Submit Report"},
		{"eBL.VIEW_CASHIER_JOURNAL.label","View Cashier journal"},
		{"eBL.CLOSE_CASH_COUNTER.label","Close Cash Counter"},
		{"eBL.CASHIER_SETTLEMENTS.label","Cashier Settlements"},
		{"eBL.BED_TYPE_FOR_CHARGING_BASIS.label","Bed Type for Charging Basis"},
		{"eBL.CASH_COUNTER_USER.label","Cash Counter User"},
		{"eBL.CASH_COUNTER_SEARCH.label","Cash Counter Search"},
		{"eBL.CASH_COUNTER_CODE.label","Cash Counter Code"},
		{"eBL.CASH_COUNTER_USER_SEARCH.label","Cash Counter User Search"},
		{"eBL.LOGIN_TIME.label","Login Time"},
		{"eBL.LOGOUT_TIME.label","Logout Time"},
		{"eBL.CASH_COUNTER_IS_FILTERED_FOR.label","Cash Counter is Filtered for"},
		{"eBL.CASH_COUNTER_IN_USAGE_LIST.label","Cash Counter in Usage List"},
		{"eBL.CASH_COUNTER_LOGIN.label","Cash Counter Login"},
		{"eBL.LOGGEDIN_USER_COUNTER_DTLS.label","Logged In User/Counter Details"},
		{"eBL.SHIFT_STARTED_AT.label","Shift Started At"},
		{"eBL.CONFIRM_LOGIN.label","Confirm Login"},
		{"eBL.PRIMARY_BILLING_GROUP.label","Primary Billing Group"},
		{"eBL.FAMILY_ANNUAL_INCOME.label","Family Annual Income"},
//		{"eBL.PATIENT_RELN_WITH_RESP_PERSON.label","Patient Reln with Responsible Person"},
		{"eBL.PATIENT_RELN_WITH_RESP_PERSON.label","Relationship"},
		{"eBL.GL_HOLDER_NAME.label","GL Holder Name"},
		{"eBL.PATIENT_RELN_WITH_GL_HOLDER.label","Patient Reln with GL Holder"},
		{"eBL.PAYER_POLICY_DTLS.label","Payers/Policy Details"},
		{"eBL.IN_USE_BY.label","In Use By"},
		{"eBL.CANCELLED_COUNT.label","Cancelled Count"},
		{"eBL.BOUNCED_COUNT.label","Bounced Count"},
		{"eBL.NOS.label","Nos"},
		{"eBL.ADD_MORE_PAYERS.label","Add More Payers"},
		{"eBL.SETTLEMENT_WISE_COLLECTION.label","Settlement-wise Collection"},
		{"eBL.PAYER_GROUP_DESC.label","Payer Group Description"},
		{"eBL.ADJUSTMENT_RULE_INDICATOR.label","Adjustment Rule Indicator"},
		{"eBL.PERC_AMOUNT_INDICATOR.label","%/Amount Indicator"},
		{"eBL.ADJUSTMENT_VALUE.label","Adjustment Value"},
		{"eBL.ADJUSTMENT_INTERFACE_CODE.label","Adjustment Interface Code"},
		{"eBL.DRG_ADJUSTMENET_INTERFACE_CODE.label","DRG Adjustmenet Interface Code"},
		{"eBL.SPL_SERVICE_ADJUSTMENT_INTERFACE_CODE.label","Spl Service Adjustment Interface Code"},
		{"eBL.FIN_DTLS_QRY.label","Financial Details Query"},
		{"eBL.PAT_ENCOUNTER_FIN_DTLS.label","Patient/Encounter Financial Details"},
		{"eBL.PATIENT_FIN_DTLS.label","Patient Financial Details"},
		{"eBL.ENCOUNTER_FIN_DTLS.label","Encounter Financial Details"},
		{"eBL.FINANCIAL_REMARKS.label","Financial Remarks"},	
		{"eBL.SERVICE_DISC_AMT.label","Service Discount Amt"},
		{"eBL.OTHER_DISC_AMT.label","Other Discount Amt"},
		{"eBL.DEPOSIT_AMT.label","Deposit Amt"},
		{"eBL.SURGERY_DEPOSIT_AMT.label","Surgery Deposit Amt"},
		{"eBL.REFUNDABLE_DEPOSIT_AMT.label","Refundable Deposit Amt"},
		{"eBL.PACKAGE_DEPOSIT_AMT.label","Package Deposit Amt"},
		{"eBL.PREPAYMENT_AMT.label","Prepayment Amt"},
		{"eBL.UNADJUSTED_DEPOSIT_PREPAYMENT.label","Unadjusted Deposit/Pre-Payment"},
		{"eBL.EDIT_ENTER_CHARGE_DETAILS.label","Edit/Enter Charge Details"},
		{"eBL.RATE.label","Rate"},
		{"eBL.TOTAL_QTY.label","Total Quantity"},
		{"eBL.REVISE_QTY.label","Revise Quantity"},
		{"eBL.TOTAL_PAYABLE.label","Total Payable"},
		{"eBL.ADD_PAYER.label","Add Payer"},
		{"eBL.MODIFY_PAYER.label","Modify Payer"},
		{"eBL.REMOVE_PAYER.label","Remove Payer"},
		{"eBL.INCLUDED_EXCLUDED.label","Included/Excluded"},
		{"eBL.INCLUDED_EXCLUDED_ACTION.label","Included/Excluded Action"},
		{"eBL.ORIG_QTY_PER_PANEL.label","Original Quantity per Panel"},
		{"eBL.REVISED_QTY_PER_PANEL.label","Revised Quantity per Panel"},
		{"eBL.RATE_CHARGE.label","Rate/Charge"},
		{"eBL.PRACT_STAFF_TYPE.label","Practitioner/Staff Type"},
		{"eBL.PRACTITIONER_STAFF.label","Practitioner/Staff"},
		{"eBL.PREAPPR_REQD.label","Preapproved Reqd"},
		{"eBL.POLICY_START_DATE.label","Policy Start Date"},
		{"eBL.POLICY_EFFECTIVE_FROM.label","Policy Effective From"},
		{"eBL.POLICY_EFFECTIVE_TO.label","Policy Effective To"},
		{"eBL.ADD_MORE_SECONDARY_BILLING_GROUPS.label","Add More Secondary Billing Groups"},
		{"eBL.VISIT_CHRG_EXEMPT_UPTO.label","Visit charge exempted upto"},
		{"eBL.VISIT_CHRG.label","Visit charge"},
		{"eBL.PLS_NOTE_DOWN_THE_BILL.label","Please note down the bill"},
		{"eBL.FOR_THE_VISIT_CHRG.label","for the visit charge"},
		{"eBL.HOSP_CHRG.label","Hospital Charge"},
		{"eBL.PROF_CHRG.label","Professional Charge"},
		{"eBL.PAYER_CODE.label","Payer Code"},
		{"eBL.PAYER_DESC.label","Payer Description"},
		{"eBL.PAYER_GROUP_CODE.label","Payer Group Code"},
		{"eBL.CASH_GIVEN.label","Cash Given"},
		{"eBL.AMOUNT_REND.label","Amount Tendered"},
		{"eBL.CASH_RETURNED.label","Cash Returned"},
		{"eBL.RECD_THRU_MAIL.label","Received through mail"},
		{"eBL.ADD_CHARGE_DETAILS.label","Add Charge Details"},
		{"eBL.EDIT_CHARGE_DETAILS.label","Edit Charge Details"},
		{"eBL.REMOVE_CHARGE_DETAILS.label","Remove Charge Details"},
		{"eBL.ADD_BILL_SLMT_DTL.label","Add Bill Settlements Details"},
		{"eBL.MODI_BILL_SLMT_DTL.label","Modify Bill Settlements Details"},
		{"eBL.REMOVE_BILL_SLMT_DTL.label","Remove Bill Settlements Details"},
		{"eBL.SLMT_AMT.label","Settlement Amount"},
		{"eBL.AMT_COLL.label","Amount Collected"},
		{"eBL.REM_SLMT_AMT.label","Remaining Settlement Amount"},
		{"eBL.ADJUST_DEPOSIT.label","Adjust Deposit"},
		{"eBL.ADJUSTED_DEPOSIT.label","Adjusted Deposit"},
		{"eBL.PAYABLE_AMT_EXCEED.label","Payable Amount Exceeding"},
		{"eBL.INTERIM_BILL_GEN_FREQ_EVERY.label","Interim Bill Generation Frequency Every"},
		{"eBL.CURR_IPS.label","Current Inpatients"},
		{"eBL.PAYABLE_TYPE.label","Payable Type"},
		{"eBL.ANY.label","Any"},
		{"eBL.PENDING_SETTLEMENT.label","Pending Settlement"},
		{"eBL.CURRENT_SETTLEMENT.label","Current Settlement"},
		{"eBL.SETTLED_AMOUNT.label","Settled Amount"},
		{"eBL.SETTLEMENT_BY_SERVICES.label","Settlement By Services"},
		{"eBL.LOGIN_TIME_SEARCH.label","Login Time Search"},
		{"eBL.POLICY_COVERAGE_BASIS_IND.label","Policy Coverage Basis Indicator"},
		{"eBL.PATIENT_BASED.label","Patient Based"},
		{"eBL.PAYER_BASED.label","Payer Based"},
		{"eBL.PREPAY_ADJUST_YN.label","Adjust Prepay"},
		{"eBL.BILL_GENERATED.label","Bill Generated"},
		{"eBL.NOT_GENERATED_FOR_DAYS.label","Not Generated For Days"},		
		{"eBL.EXEMPT_AMOUNT.label","Exempt Amount"},
		{"eBL.EXEMPTION_AMOUNT.label","Exemption Amount"},
		{"eBL.ADJUST_AMT.label","Adjust Amount"},
		{"eBL.ADJUSTMENT_AMT.label","Adjustment Amount"},
		{"eBL.WRITOFF_ROUND.label","Write-off Amt Rounded"},
		{"eBL.SERVICE_DATE.label","Service Date"},
		{"eBL.BILL_CHARGE_DET.label","Bill Charge Details"},
		{"eBL.UNBILLED_CHARGE_DET.label","UnBilled Charge Details"},
		{"eBL.CASHIER.label","Cashier"},
		{"eBL.RECEIVED_BACK_ON.label","Received Back On"},
		{"eBL.REMAINDER.label","Remainder"},
		{"eBL.PRIMARY_PRIVILEGE.label","Primary Privilege"},
		{"eBL.PRIMARY_PAYER.label","Primary Payer"},
		{"eBL.ADJUSTMENT_DETAILS.label","Adjustment Details"},
		{"eBL.EXEMPTION_DETAILS.label","Exemption Details"},
		{"eBL.REMAINDER_DETAILS.label","Remainder Details"},
		{"eBL.WRITE_OFF_DETAILS.label","Write-off Details"},
		{"eBL.PAT_ENCOUNTER_DETAILS.label","Patient Encounter Details"},
		{"eBL.PRV_ENCOUNTER_FIN_DETAILS.label","Previous Encounters Financial Details"},
		{"eBL.CAPTURE_REF_SOURCE_DTL.label","Capture Referral Source"},
		{"eBL.PMY_REF_SRC.label","Primary Referral Source"},
		{"eBL.SEC_REF_SRC.label","Secondary Referral Source"},
		{"eBL.SEL_FRM_PREV_ENC.label","Select From Previous Encounters"},
		{"eBL.REFERRAL_LINK.label","Referral Link"},
		{"eBL.CASH.label","Cash"},
		{"eBL.CREDIT.label","Credit"},
		{"eBL.SPONSOR.label","Sponsor"},
		{"eBL.INSURANCE.label","Insurance"},
		{"eBL.UPD_PAT_FIN_DTLS_VALIDATE.label","Update Patient Financial Details - CheckList"},
		{"eBL.PREREQ_UPD_PAT_FIN_DTLS.label","Prerequisite - For Updating Patient Level Financial Details"},
		{"eBL.NON_INS_CUSTOMER.label","Non Insurance Customer"},
		{"eBL.NON_INS_CUST_GRP.label","Non Insurance Customer Group"},
		{"eBL.SEC_INS_BLNG_GRP.label","Secondary Insurance Billing Group(s)"},
		{"eBL.PRIO_1_INS_PYR.label","Priority 1 Insurance Payer"},
		{"eBL.OTH_INS_PYR.label","Other Insurance Payer(s)"},
		{"eBL.CASH_REFUNDED.label","Cash Refunded"},
		{"eBL.GET_CC_INFO.label","Get Credit Card Info"},
		{"eBL.FROM_ADM_NO.label","From Admission No"},
		{"eBL.TO_ADM_NO.label","To Admission No"},
		{"eBL.LAST_BED_CHARGE_DATE.label","Last Bed Charge Date"},
		{"eBL.UNADJUST_AMT.label","Unadjust Amount"},
		{"eBL.SUBMIT_BED_CHARGE_PROCESS.label","Submit Bed Charge Process"},
		{"eBL.PRMY_REF_SRC_MAND.label","Primary Referral Source Mandatory"},
		{"eBL.SEC_REF_SRC_MAND.label","Secondary Referral Source Mandatory"},
		{"eBL.OUTSTANDING_BILLED_AMT.label","Outstanding Billed Amount"},
		{"eBL.CUST_GROUP_CODE.label","Customer Group Code"},
		{"eBL.CHQ_CARD_BANK_NO.label","Cheque / Card / Bank A/C No."},
		{"eBL.PAYER_DEP_REF_NO.label","Payer Ref Id / Deposit Ref No."},
		{"eBL.SERVICE_GROUP.label","Service Group"},
		{"eBL.PANEL_CATEGORY.label","Panel Category"},
		{"eBL.SERVICE_CLASSIFICATION.label","Service Classification"},
		{"eBL.APPRL.label","Apprl"},
		{"eBL.EXIST_SERV_PANEL.label","Existing Service/Panel"},
		{"eBL.ENT_SERV_PANEL_REQ.label","Enter Service/Panel Request"},
		{"eBL.ADDL_SERV_PANEL.label","Additional Service/Panel"},
		{"eBL.PLACE_SERV_PANEL_REQ.label","Place Service/Panel Request"},
		{"eBL.USE_DEFAULT_REASON.label","Use Default Reason"},
		{"eBL.R_C.label","R/C"},
		{"eBL.VIEW_EDIT.label","View/Edit"},
		{"eBL.PLS_NOTE_TRX_REF_NO.label","Please note the Transaction Reference No. :- "},
		{"eBL.PAYER_GROUP.label","Payer Group"},
		{"eBL.ADM_DEP.label","Admission Deposit"},
		{"eBL.REC_NATURE.label","Receipt Nature"},
		{"eBL.RECEIPT_REFUND.label","Receipt/Refund"},
		{"eBL.DEPOSIT_TYPE.label","Deposit Type"},
		{"eBL.THRU_MAIL.label","Thru Mail"},
		{"eBL.TRN_DEP.label","Transfer Deposit"},
		{"eBL.OTH_DEP.label","Other Deposit"},
		{"eBL.ADDL_CHARGE.label","Additional Charge"},
		{"eBL.CURR_CODE.label","Currency Code"},
		{"eBL.CURR_DESC.label","Currency Description"},
		{"eBL.PAT_PAY_SIM_MES_1.label","Patient Payable Amt simulated above is calculated based on the Availed Approved Amt by the payers for the current visit details."},
		{"eBL.PAT_PAY_SIM_MES_2.label","On record of Revise Visit Details, Patient Payable amount will be adjusted accordingly if any discrepancy exist."},
		{"eBL.DOC_GEN.label","Please note down the Document Number(s):"},
		{"eBL.REC_ADHOC_DISC.label","Record Adhoc Discount"},
		{"eBL.ADHOC_DISC_AMT.label","Adhoc Discount Amount"},
		{"eBL.ADHOC_DISC_PERC.label","Adhoc Discount %age"},
		{"eBL.ADHOC_DISC_REASON.label","Adhoc Discount Reason"},
		{"eBL.ACT_GROSS_AMT.label","Actual Gross Amount"},
		{"eBL.USE_PREV_REASON.label","Use Previous Reason"},
		{"eBL.DISC_FOR_ENC_CHARGE_DTLS.label","Discount for Encounter Charge Details"},
		{"eBL.DISC_SLMT_FOR_ENC_CHARGE_DTLS.label","Discount/Settlement for Encounter Charge Details"},
		{"eBL.ADDL_SERV_CHAGE_DTLS.label","Additional Service Charge Details"},
		{"eBL.DEPENDENT_SERVICE.label","Dependent Service"},
		{"eBL.DISC_AMT.label","Disc Amt"},
		{"eBL.VIEW_ADDL_CHARGE_DTL.label","View Additional Charge Details"},
		{"eBL.VISIT_BILL_GEN_AFTER_DISC.label","Pls note down the Visit Bill No. Generated after Discounts:"},		
		{"eBL.RECORD_ADDL_SUR_CHARGES.label","Record Additional Surgery Charges"},
		{"eBL.VW_SUBS_OPEN_PACKAGE_DTL.label","View Subscribed Open Package Details"},
		{"eBL.SUBS_OPEN_PACKAGE_DTL.label","Subscribed Open Package Dtls"},
		{"eBL.PKG_DESC.label","Package Description"},			
		{"eBL.PKG_AMT.label","Package Amount"},			
		{"eBL.AVAILD_AMT.label","Availed Amount"},			
		{"eBL.PKG_COMPONENT.label","Package Components"},			
		{"eBL.QTY_LMT.label","Quantity Limit"},			
		{"eBL.AVAILD_QTY.label","Availed Quantity"},			
		{"eBL.AMT_LMT.label","Amount Limit"},
		{"eBL.AVAILD_PACK_DTLS.label","Availed Package Details"},
		{"eBL.CHARGE_FOR_MAIN_SERV.label","Charge for Main Service"},
		{"eBL.CHARGE_FOR_ADDL_SERV.label","Charge For Additional Service"},
		{"eBL.INVALID_ADDL_SERV.label","Invalid Additional Service"},
		{"eBL.IS_SPL_CLINIC_ENC_YN.label","Special Clinic Related Encounter"},
		{"eBL.MAX_NO_OF_ENC_ALLOW_FOR_CREDIT_DOC.label","Maximum No.of Encounters allowed or the Credit Doc Reference"},
		{"eBL.CLASS_TYPE.label","Classification Type"},
		{"eBL.CLASS_CODE.label","Classification Code"},
		{"eBL.CASH_PAY_PAT.label","Cash Paying Patient"},
		{"eBL.INCOME_ASSET.label","Income/Asset"},
		{"eBL.INCOME_ASSET_BASED.label","Income/Asset Based"},
		{"eBL.EXEMPTED.label","Exempted"},
		{"eBL.SOCIAL_GRANT.label","Social Grant"},
		{"eBL.INCOME_ASSET_BASED.label","Income/Asset Based"},
		{"eBL.SPECIAL_CASE.label","Special Case"},
		{"eBL.SPONSORED.label","Sponsored"},
		{"eBL.INCOME.label","Income"},
		{"eBL.ASSET.label","Asset"},
		{"eBL.INDVL_INC_FREQ.label","Individual Income Frequency"},
		{"eBL.SPOUSE_INC_FREQ.label","Spouse Income Frequency"},
		{"eBL.DEP_INC_FREQ.label","Dependents Income Frequency"},
		{"eBL.FIN_CLASS.label","Financial Classification"},
		{"eBL.SOCIAL_PENSIONER_ID.label","Social Pensioner Id"},
		{"eBL.WRITOFF_AMT.label","Write-off Amount"},
		{"eBL.INSTLMT_DUE_AMT.label","Installment Due Amount"},
		{"eBL.CHRG_NON_CHRG_PAT_DUR_ENC.label","Charge Non-Chargeable Patient during Encounter"},
		{"eBL.PAT_REG_CHARGE_BILL_GEN.label","Please note down the bill # for the Patient Registration Charge % Patient Payable &"},
		{"eBL.PAT_REG_CHRG.label","Patient Registration Charge"},
		{"eBL.SERV_PANEL_CODE.label","Service/Panel Code"},
		{"eBL.SERV_PANEL_DESC.label","Service/Panel Description"},
		{"eBL.BLNG_GRP_DESC.label","Billing Group Description"},
		{"eBL.INV_AMT.label","Invoiced Amount"},
		{"eBL.AUTOMATIC.label","Automatic"},
		{"eBL.CURR_IP.label","Current Inpatients"},
		{"eBL.TOD_EXP_DISCHRG.label","Expected Discharges for the Day"},
		{"eBL.TOD_DISCHRGD_PAT.label","Discharged Patients for the Day"},
		{"eBL.BILL_PYMT_DTLS.label","Bill/Payment Details"},
		{"eBL.FIN_SUMM_BY_BG.label","Fin. Summary by Billing Group"},
		{"eBL.FIN_SUMM_BY_PYR.label","Fin. Summary by Payer"},
		{"eBL.NO_OF_DAYS_OCCU_FORECAST.label","No. of Days Occupancy Forecast is Required"},
		{"eBL.EXPECTED_IP.label","Expected Inpatients"},
		{"eBL.OUTST_PAT_BILLS.label","Outstanding Patient Bill(s)"},
		{"eBL.CREDIT_CARD_NO.label","Credit Card No."},
		{"eBL.ROUND_OFF.label","Round-Off"},
		{"eBL.CHARGE_DTL.label","Charge Details"},
		{"eBL.FOR_THE_CHRG.label","for the charges"},
		{"eBL.CASH_IN_HAND.label","Cash in Hand"},
		{"eBL.CHQ_IN_HAND.label","Cheque in Hand"},
		{"eBL.CASH_HANDED_OVER.label","Cash Handed Over"},
		{"eBL.DENO.label","Denominations"},
		{"eBL.NUM.label","Number"},
		{"eBL.CHEQ_NUM.label","Cheq No"},
		{"eBL.CHEQ_DATE.label","Cheq Date"},
		{"eBL.CASH_COLLECTION.label","Cash Collection"},
		{"eBL.CHEQ_COLLECTION.label","Cheque Collection"},
		{"eBL.HAND_OVER_REQ_AMT.label","Handover Request Amount"},
		{"eBL.NOS.label","Nos."},
		{"eBL.CHEQUE.label","Cheque"},
		{"eBL.REQ_DATE_TIME.label","Requested Date Time"},
		{"eBL.TRANS_DTLS.label","Transcation Details"},
		{"eBL.HANDOVER_REQ_DTLS.label","Handover Request Details"},
		{"eBL.CASH_CHEQ_COLL_DTLS.label","Cash/Cheque Collection Details"},
		{"eBL.CASH_DTLS.label","Cash Details"},
		{"eBL.CHEQ_DTLS.label","Cheque Details"},
		{"eBL.OP_OVERRIDE_REIM_DTLS.label","Modify OP/EXT Bill Reimbursable Amt"},
		{"eBL.IP_OVERRIDE_REIM_DTLS.label","Modify IP Bill Reimbursable Amt"},
		{"eBL.OP_OVERRIDE_UNBLD_REIM_DTLS.label","Modify OP/EXT Unbilled Reimbursable Amt"},
		{"eBL.IP_OVERRIDE_UNBLD_REIM_DTLS.label","Modify IP Unbilled Reimbursable Amt"},
		{"eBL.LIST_OF_SERV.label","List of Services"},
		{"eBL.DFND_REIMB.label","Defined Reimbursable"},
		{"eBL.DFN_REIMB_TYPE.label","Defined Reimbursable Type"},
		{"eBL.DFN_REIMB_AMT.label","Defined Reimbursable Amount"},
		{"eBL.CURR_REIMB.label","Current Reimbursable"},
		{"eBL.CURR_REIMB_TYPE.label","Current Reimbursable Type"},
		{"eBL.REVISED_AMT.label","Revised Amount"},
		{"eBL.FULL.label","Full"},
		{"eBL.PART.label","Part"},
		{"eBL.NA.label","N/A"},
		{"eBL.AUDIT_DTLS.label","Audit Details"},
		{"eBL.AUDIT_NO.label","Audit No"},
		{"eBL.OLD_REIMB.label","Old Reimbursable"},
		{"eBL.OLD_REIMB_TYPE.label","Old Reimbursable Type"},
		{"eBL.OLD_REIMB_AMT.label","Old Reimbursable Amount"},
		{"eBL.NEW_REIMB.label","New Reimbursable"},
		{"eBL.NEW_REIMB_TYPE.label","New Reimbursable Type"},
		{"eBL.NEW_REIMB_AMT.label","New Reimbursable Amount"},
		{"eBL.OVERRIDING_REASON.label","Overriding Reason"},
		{"eBL.HO_AMOUNT.label","HO Aamount"},
		{"eBL.REG_BILL_GEN_AFTER_DISC.label","Pls note down the Registration Bill No. Generated after Discounts:"},
		{"eBL.CHRG_DUR_ENC.label","Chargeable at Encounter"},
		{"eBL.DISC_FOR_REG_CHARGE_DTLS.label","Discount for Registration Charge Details"},
		{"eBL.CHAR_AT_REG.label","Chargeable at Registration"},
		{"eBL.LAST_MOD_DATE_TIME.label","Last Modified Date/Time"},
		{"eBL.EX.label","EX"},
		{"eBL.RateBased.label","Rate Based"},
		{"eBL.AmountIndicator.label","Amount Indicator"},
		{"eBL.FactorRate.label","Factor/Rate"},
		{"eBL.NoLimit.label","No Limit"},
		{"eBL.Dtls.label","Dtls"},
		{"eBL.PERCENT.label","%"},
		{"eBL.addRow.label","Click to add row"},
		{"eBL.serviceLimit.label","Service Limit"},
		{"eBL.PercentageLimit.label","% Limit"},
		{"eBL.del.label","Del"},
		{"eBL.replaceableService.label","Replaceable Service"},
		{"eBL.replaceableCatalog.label","Replaceable Catalog"},
		{"eBL.orderAssociated.label","Order Associated"},
		{"eBL.AsPerRule.label","As per Rule"},
		{"eBL.Pack_Subs.label","Package Subscription"},
		{"eBL.Subs_pack.label","Subscribe Package"},
		{"eBL.Bill_CLASS_CODE.label","Billing Class Code"} ,
		{"eBL.FACTOR_APPL_SER.label","Factor Applicable For Service"},
		{"eBL.FACTOR.label","Factor"},
		{"eBL.ApplyFactorForServiceLimit.label","Factor applicable for service limit"},
		{"eBL.AcrossEncounters.label","Across Encounters"},
		{"eBL.CashCredit.label","Cash & Credit"},
		{"eBL.Customers.label","Customers"},
		{"eBL.PRICE_FACT.label","Price/Factor"},
		{"eBL.CopyFrom.label","Copy From"},
		{"eBL.CopyTo.label","Copy To"},
		{"eBL.CopyPackage.label","Copy Package"},
		{"eBL.PayerDtls.label","Payer Details"},
		{"eBL.CUSTOMERS_SPECIFIC.label","Customers Specific Price & Coverage"},
		{"eBL.PACKAGE_PRICE_CLASS.label","Package Price Class"},
		{"eBL.OUTSIDE_PACKAGE_PRICE_CLASS.label","Outside Package Price Class"},
		{"eBL.AssociateSubscribedPackage.label","Associate Subscribed Package"},
		{"eBL.APPROVED_DATE.label","Approved Date"},
		{"eBL.UNLIMITED.label","Unlimited"},
		{"eBL.PERC_AMOUNT.label","%/Amount"},
		{"eBL.PRICE_CLASS.label","Price Class"},
		{"eBL.packageApprovalAmt.label","Package Approval Amt"},
		{"eBL.additionalApprovals.label","Additional Approvals"},
		{"eBL.additionalApproval.label","Additional Approval"},
		{"eBL.packageApprovals.label","Package Approvals"},
		{"eBL.packageApproval.label","Package Approval"},
		{"eBL.userGroup.label","User Group"},
		{"eBL.userGroupId.label","User Group Id"},
		{"eBL.userGroupName.label","User Group Name"},
		{"eBL.PackageCreation.label","Package Creation"},
		{"eBL.PackageTransfer.label","Package Transfer"},
		{"eBL.PackageDiscount.label","Package Discount"},
		{"eBL.PackageRefund.label","Package Refund"},
		{"eBL.PackageCancel.label","Package Cancel"},
		{"eBL.InitialCreditAuthorization.label","Initial Credit Authorization"},
		{"eBL.InitialCreditAuthorizationDate.label","Initial Credit Auth Date"},
		{"eBL.ROUND_TO.label","Round-To"},
		{"eBL.ROUND_INDICATOR.label","Round Indicator"},
		{"eBL.DOWN.label","Down"},
		{"eBL.AUTO_REFUND.label","Auto Refund"},
		{"eBL.DEPOSIT.label","Deposit"},
		{"eBL.PARTIAL_DEPOSIT.label","Partial Deposit"},
		{"eBL.MIN_DEPOSIT_AMOUNT.label","Minimum Deposit Amount"},
		{"eBL.PackageCode-Desc-Seqno.label","Package Code-Desc-Seq No"},
		{"eBL.CLOSE_PACKAGE.label","Close Package"},
		{"eBL.packageSeqNo.label","Package Seq No"},
		{"eBL.UtilizedAmt.label","Utilized Amt"},
		{"eBL.BillingClassCode.label","Billing Class Code"},
		{"eBL.BillingClassDesc.label","Billing Class Desc"},		
		{"eBL.RateIndicator.label","Rate Indicator"},	
		{"eBL.RefundRate.label","Refund Rate"},
		{"eBL.UtilizedServiceQty.label","Utilized Service Qty"},
		{"eBL.UtilizedServiceAmt.label","Utilized Service Amt"},
		{"eBL.Excl.label","Excl."},
		{"eBL.RefundAmt.label","Refund Amt"},
		{"eBL.PackageServiceCode.label","Package Service Code"},
		{"eBL.PackageApplicable.label","Package Applicable"},
		{"eBL.PackageEffBackDated.label","Package Efective From Back dated"},
		{"eBL.GLPostingBySmmry.label","GL Posting by Summary"},
		{"eBL.ValidDysPkgSerOrds.label","Validity for Availing Package Service Orders"},
		{"eBL.unavailedSrvCode.label","Unavailed Service Code"},
		{"eBL.AutoRefundApplicable.label","Auto Refund Applicable"},
		{"eBL.ValidDysForPkgRefund.label","Validity for Package Service Refund"},
		{"eBL.fromDateOfBlGen.label","(from the date of bill generation)"},
		{"eBL.AccountingCode.label","Accounting Code"},
		{"eBL.DISC_ACC_CODE.label","Discount Accounting Code"},
		{"eBL.CustomerBasePrice.label","Customer Base Price"},
		{"eBL.CustomerRateBasedServices.label","Customer Rate Based Services"},
		{"eBL.CustomerChargeBasedServices.label","Customer Charge Based Services"},
		{"eBL.PackageRateBaseHdr.label","Package Services(Rate Based)"},
		{"eBL.PackageChargeBaseHdr.label","Package Services(Charge Based)"},
		{"eBL.UtilizedQty.label","Utilized Qty"},
		{"eBL.Refunded.label","Refunded"},
		{"eBL.DEPOSITCOLECTD.label","Deposit Collected"},
		{"eBL.ELIGIBLE.label","Eligible"},
		{"eBL.PLACED.label","Placed"},
		{"eBL.REGISTERED.label","Registered"},
		{"eBL.DISCOUNT_AS_PER_SETUP.label","Discount As per Setup"},
		{"eBL.discountType.label","Discount Type"},
		{"eBL.Discount.label","Discount"},
		{"eBL.Transactionreference.label","Transaction Reference"},
		{"eBL.EXEMPTINPKG.label","Exempt in Package"},
		{"eBL.PAYERCOVERAGE.label","Payer Coverage"},
		{"eBL.PKG_DEP.label","Package Deposit"},
		{"eBL.BLNG_CLASS_ELIG_PKG.label","Billing Class Eligibility for Package"},
		{"eBL.PackageAdhocRefund.label","Package Adhoc Refund"},
		{"eBL.VarianceSrvCode.label","Variance Service Code"},
		{"eBL.RefundRatePer.label","Refund Rate %"},
		{"eBL.CUST_GROUP_DESC.label","Customer Group Desc"},
		{"eBL.CUST_NAME.label","Customer  Name"},
		{"eBL.AvailableServiceAmt.label","Available Service Amt"},
		{"eBL.PatientDepositForPackage.label","Patient Deposit for Package"},
		//Added Label by Muthukumar.N against CRF on 15/6/2012
		{"eBL.FactorForServiceRate.Label","Factor For Service Rate"},
		//Below PackageGrouping is Added by Muthukumar.N against CRF on 21-2-2012
		{"eBL.PackageGrouping.label","Package Group"},
		//Added Label by Muthukumar.N against 31860 on 5/3/2012
		{"eBL.CopyBaseDef.label","Copy Base Def"},
		{"eBL.ReplaceWithBaseDef.label","Replace With Base Def"},
		{"eBL.SalesCategory.label","Sales Category"},
		//Added Label by Muthukumar.N against CRF on 9/5/2012
		{"eBL.DrugPenalty.label","Drug Penalty"},
		{"eBL.DISC_APPL.label","Discount Applicable"},
		//Added Label by Muthukumar.N against CRF on 15/6/2012
		{"eBL.RegistrationFee.Label","Registration Fee"},
		{"eBL.ConsultationFee.Label","Consultation Fee"},
		//Added Label by Muthukumar.N against CRF on 27/6/2012
		{"eBL.PackageCode.Label","Package Code"},
		{"eBL.PackageDesc.Label","Package Desc"},
		{"eBL.EffectiveFrom.Label","Effective From"},
		{"eBL.BillingClass.Label","Billing Class"},
		{"eBL.Price.Label","Price"},
		{"eBL.BillingService.Label","Billing Service"},
		{"eBL.BillingServCode.Label","Billing Serv Code"},
		{"eBL.AmountInd.Label","Amount Ind"},		
		{"eBL.QtyLimit.Label","Qty Limit"},
		{"eBL.Cost.Label","Cost"},
		{"eBL.PackageCost.Label","Package Cost"},//Newly added by Muthukumar.N against CRF on 03/07/2012 
		{"eBL.Customer.label","Customer"},//Added Label by Muthukumar.N against CRF on 27/6/2012	
		//Labels Added for Payment.jsp
		{"eBL.Currency.label","Currency"},
		{"eBL.ConversionRate.label","Conversion Rate"},
		{"eBL.OutstandingAmount.label","Outstanding Amount"},
		{"eBL.ModeOfPayment.label","Mode Of Payment"},
		{"eBL.PaymentMode.label","Payment Mode"},
		{"eBL.CashDetails.label","Cash Details"},
		{"eBL.CashOutstandingAmount.label","Outstanding Amount"},
		{"eBL.CashPaid.label","Cash Paid"},
		{"eBL.RefundAmount.label","Refund Amount"},
		{"eBL.CardDetails.label","Card Details"},
		{"eBL.CardOutstandingAmount.label","Outstanding Amount"},
		{"eBL.CardType.label","Card Type"},
		{"eBL.CardNumber.label","Card Number"},
		{"eBL.IssuingAuthority.label","Issuing Authority"},
		{"eBL.IssuingBranchName.label","Issuing Branch Name"},
		{"eBL.CardHoldersName.label","Card Holder's Name"},
		{"eBL.AuthCode.label","APPR/Auth Code"},
		{"eBL.BatchNo.label","Batch No"},
		{"eBL.CardAmount.label","Card Amount"},
		{"eBL.CounterShift.label","Cash Counter/Shift"},
		{"eBL.DocumentNo.label","Document No"},
		{"eBL.Date.label","Date"},
		
		//Labels Addes for Receipt.jsp
		{"eBL.TransactionType.label","Transaction Type"},
		{"eBL.Nature.label","Nature"},
		{"eBL.Amount.label","Amount"},
		{"eBL.BlockedforOP.label","Blocked for OP"},
		{"eBL.BlockedforIP.label","Blocked for IP"},
		{"eBL.BlockedForDC.label","Blocked For DC"},
		{"eBL.FromDate.label","From Date"},
		{"eBL.ToDate.label","To Date"},
		{"eBL.ServiceLimit.label","Service Limit"},
		{"eBL.Remarks.label","Remarks"},
		
		//Added For Billing Banner
		{"eBL.BannerFormat.label","Banner Format"},
		{"eBL.BannerAssociation.label","Banner Association"},
		{"eBL.StaticInformation.label","Static Information"},
		
		//Added For Billing Banner Header
		{"eBL.Format.label","Format"},
		{"eBL.BannerCode.label","Banner Code"},
		{"eBL.BannerDescription.label","Banner Description"},
		{"eBL.FormatSelection.label","Format Selection"},
		{"eBL.SeqNo.label","Seq No"},
		{"eBL.Column1.label","Column 1"},
		{"eBL.Column2.label","Column 2"},
		{"eBL.Column3.label","Column 3"},
		{"eBL.StaticLegend.label","Static Legend"},
		{"eBL.Static Value.label","Static Value"},
		
		
		//Added For Billing Banner Association
		{"eBL.AssociateBillingGroup.label","Associate Billing Group"},
		{"eBL.FunctionId.label","Function Id"},
		{"eBL.FunctionDesc.label","Function Desc"},
		{"eBL.RightsType.label","Rights Type"},
		{"eBL.RightsCode.label","Rights Code"},
		{"eBL.BillingGroupId.label","Billing Group"},
		{"eBL.BillingGroupDesc.label","Billing Group Desc"},
		{"eBL.EpisodeType.label","Episode Type"},
		{"eBL.EffFrom.label","Eff From Date"},
		{"eBL.EffTo Value.label","Eff To Date"},
		
        //Added for Patient Search
		{"eBL.encounterperiod.label","Encounter Period"}, 
        {"eBL.DOCTOR_NAME.label","Doctor Name"},
        {"eBL.EPISODE_STATUS.label","Episode Status"},
        {"eBL.EPISODE_TYPE.label","Episode Type"},
        {"eBL.OneWeek.label","1Week"},
        {"eBL.OneMonth.label","1Month"},
		{"eBL.CURRENT_INPATIENT.label","Current IP/DC"},
    	{"eBL.CURRENT_EMERGENCY.label","Current Emergency"}, 	
        {"eBL.CURRENT_OUTPATIENT.label","Current OP/EM"}, 
        {"eBL.EXISTING_ORDERS.label","Existing Orders"},		
        {"eBL.NEW_ORDERS.label","New Orders"},	
		{"eBL.CLASSIFICATION.label","Classification"}, 
    	{"eBL.BILLING_SERVICE_CODE.label","Service Code"}, 	
        {"eBL.BILLING_SERVICE_DISC.label","Service Disc"},
        {"eBL.ORDER_CATEGORY.label","Order Category"},
		{"eBL.ORDER_TYPE.label","Order Type"},
		{"eBL.ORDER_CATALOG_CODE.label","Order Catalog Code"},
		{"eBL.ORDER_CATALOG_DISC.label","Order Catalog Disc"}, 
		{"eBL.CONTAINS.label","Contains"},
        {"eBL.PANEL_CODE.label","Panel Code"},
        {"eBL.BILLING_SERVICE_PANEL.label","Service/Panel"},
		{"eBL.POLICY_IN_EX.label","Policy In/Ex"},	
        {"eBL.ACTION_REASON.label","Action Reason"},
        {"eBL.PRE_APP_REQ.label","Pre Approval Required"},
		
		//Added for Revenue Recognition Stage
		{"eBL.Revenue_Stage.label","Revenue Stage"},	
		{"eBL.ORDER_TYPE_DESC.label","Order Type Desc"},	


		//Added For Billing Static Information
		{"eBL.StaticInformation.label","Static Information"},
		{"eBL.LegendCode.label","Legend Code"},
		{"eBL.Description.label","Description"},
		

		/* Receipt Master changes starts here - done by boopathy on 11/10/2012 */
		{"eBL.ReceiptNatureCode.Label","Receipt Nature Code"},
		{"eBL.ReceiptDescription.Label","Receipt Description"},
		{"eBL.ApplicableFor.Label","Applicable For"},
		{"eBL.DefaultRemarks.Label","Default Remarks"},
		{"eBL.ReceiptType.Label","Receipt Type"},
		{"eBL.ServiceRestriction.Label","Service Restriction"},
		{"eBL.Refundable.Label","Refundable"},
		{"eBL.AdjDuringBillGeneration.Label","Adjust During Bill Generation"},
		{"eBL.AdjustFully.Label","Adjust Fully"},
		{"eBL.AcrossEncounter.Label","Across Encounter"},
		{"eBL.ApplicableEpisode.Label","Applicable Episode"}, 
		{"eBL.GenReceiptForAdj.Label","Generate Receipt For Adjustment"},
		{"eBL.CancelandGenIntdocForPartial.Label","Cancel and Generate Internal Document For Partial Settlement"},
		{"eBL.AlwaysAdjFullDurBillGen.Label","Always Adjust During Bill Generation"},
		{"eBL.AllowPartAdjDurBillGen.Label","Allow Partial Adjustment During Bill Generation"},
		{"eBL.AdjustDurSettle.Label","Adjust During Settlement"},
		{"eBL.AlwaysAdjFullDurSettle.Label","Always Adjust Full During Settlement"},
		{"eBL.AllowPartAdjDurSettle.Label","Allow Partial Adjustment During Settlement"},
		//added against MOHE-CRF-0039
		{"eBL.PatientDeposit.label","Patient Deposit"},
		{"eBL.CustomerDeposit.Label","Customer Deposit"},
		{"eBL.AllowAdjwithCustBills.Label","Allow Adjustment With Customer Bills"},
		{"eBL.AllowAdjwithPatBills.Label","Allow Adjustment With Patient Bills"},
		{"eBL.AllowAdjForMultPat.Label","Allow Adjustment For Multiple Patients"},
		{"eBL.ReceiptNatureShortDesc.Label","Short Description"},
		{"eBL.ReceiptNatureLongDesc.Label","Long Description"},
		{"eBL.EffectiveTo.Label","Effective To"},
		/* Receipt Master changes Ends here - done by boopathy on 11/10/2012 */

        /*Added by karthik on 25-Oct-2012 for Admin Access Rights Module Starts*/
		{"eBL.RIGHTS_TYPE.label","Rights Type"},
		{"eBL.RIGHTS_CODE.label","Rights Code"},
		{"eBL.EPISODE_TYPE.label","Episode Type"},
		{"eBL.EFFECTIVE_FROM_TO.label","Effective(From-To)"},
		{"eBL.ALL.label","ALL"},
		{"eBL.IP.label","IP"},
		{"eBL.OP.label","OP"},
		{"eBL.DC.label","DC"},
		{"eBL.EM.label","EM"},
		{"eBL.EX.label","EX"},
		{"eBL.ADDED_BY.label","Added By"},
		{"eBL.ADDED_DATE.label","Date Added"},
		{"eBL.MODIFIED_BY.label","Modified By"},
		{"eBL.MODIFIED_DATE.label","Date Modified"},
		{"eBL.CHUNK_VALUE.label","Chunk Value"},
		{"eBL.RECORDS_PER_PAGE.label","Records per Page"},
		/*Added by karthik on 25-Oct-2012 for Admin Access Rights Module Ends*/
		
		//Added for Banks and Branches Date : 30/10/2012
		{"eBL.BankCode.label","Bank Code"},
		{"eBL.BankName.label","Bank Name"},
		{"eBL.BranchName.label","Branch Name"},
		{"eBL.UseForDep.label","Use for Deposit Bank-in"},
		{"eBL.CreditCardProvided.label","Credit Card M/c Provided"},
		{"eBL.SurchargeOnRefund.label","Surcharge % on Refund"},
		{"eBL.CreditCardTitle.label","Credit Card Machines Supplied By Bank"},
		{"eBL.OperatingFacilityId.label","Operating Facility Id"},
		{"eBL.CreditCardMachineId.label","Credit Card Machine Id"},
		{"eBL.Status.label","Enabled"},		
		
		//Added for Credit Card Companies : 08/12/2012
		{"eBL.CreditCardCompany.label","Credit Card Companies"},
		{"eBL.CompanyCode.label","Company Code"},
		{"eBL.CompanyName.label","Company Name"},

		/*Added by karthik on 14-Nov-2012 for Calendar Module Begins*/
		{"eBL.CALENDAR_YEAR.label","Calendar Year"},
		{"eBL.HOLIDAY_DATE.label","Holiday Date"},
		{"eBL.DAY_TYPE.label","Day Type"},
		{"eBL.CREATE_CALENDAR.label","Create Calendar"},
		{"eBL.MAINTAIN_CALENDAR.label","Maintain Calendar"},
		/*Added by karthik on 14-Nov-2012 for Calendar Module Ends*/

		/* Billing Calender Day Type changes starts here - done by boopathy on 14/11/2012 */
		{"eBL.DayTypes.Label","Day Types"},
		{"eBL.TimeTypes.Label","Time Types"},
		{"eBL.TimeSlabs.Label","Time Slabs"},
		{"eBL.DayType.Label","Day Type"},
		{"eBL.WorkingDay.Label","Working Day"},
		{"eBL.LongDesc.Label","Long Description"},
		{"eBL.ShortDesc.Label","Short Description"},
		/* Billing Calender Day Type changes Ends here - done by boopathy on 14/11/2012 */
		
		
		//Added for Service Item Mapping Date : 14/11/2012
		{"eBL.FacilityId.label","Facility Id"},
		{"eBL.ServiceInd.label","Service Indicator"},
		{"eBL.MappingCode.label","Mapping Code"},
		{"eBL.ShortDesc.label","Short Description"},
		{"eBL.LongDesc.label","Long Description"},
		{"eBL.LevelAppCov.label","Level Applicable for Coverage"},
		{"eBL.PhyDiagAppCov.label","Physician and Disgnostics Applicable for Coverage"},
		{"eBL.ServItemTitle.label","Service/Items for Mapping Code"},
		{"eBL.ItemCode.label","Code"},
		{"eBL.BillingService.label","Billing Service"},
		{"eBL.MaterialItem.label","Material Item"},
		
		
		//Added for Service Item Mapping Date : 14/11/2012
		{"eBL.PayerGroupHeading.label","Payer by Payer Group"},
		{"eBL.PayerGroup.label","Payer Group"},
		{"eBL.PayerCode.label","Payer Code"},
		{"eBL.PayerName.label","Payer Name"},
		{"eBL.PayerPaymentHeading.label","Payment Basis by Payer/Referral Hospital"},
		{"eBL.RefHospital.label","Referral Hospital"},
		{"eBL.PatientClass.label","Patient Class"},
		{"eBL.PaymentBasisInd.label","Payment Basis Indicator"},
		{"eBL.AmtRw.label","Amount for Rw"},
		{"eBL.LessPaymentPer.label","Expected less Payment %ge"},
		{"eBL.SpPayerGrpRelm.label","Specific Payer Group Relm"},
		
		/*Added by karthik on 03-Dec-2012 for Service Groups/Classifications*/
		{"eBL.NEW_SERVICE_GROUP_CON.label","New Service Groups needs to be 'Saved' before proceeding with Service Classifications"},
		
		/* EnterpriseServiceGroup changes starts here - done by boopathy on 14/11/2012 */
		{"eBL.EnterpriseServiceGroup.Label","Enterprise Service Group"},
		{"eBL.ConsiderIncomeReporting.Label","Consider For Income Reporting"},
		{"eBL.PrintLine.Label","Print Line"},
		{"eBL.PrintingPractionerName.Label","Incl/Excl Basis For Printing Practioner Name"},
		{"eBL.DocumentPrintSecquence.Label","Document Print Secquence"},
		/* EnterpriseServiceGroup changes Ends here - done by boopathy on 14/11/2012 */
		
		//Added for Payer Service Group Date : 29/11/2012
		{"eBL.PayServGrpHdrTabTitle.label","Payer Service Group Header"},
		{"eBL.PayServGrpLineTabTitle.label","Payer Service Group Line"},
		{"eBL.ServicesByPayerTitle.label","Services by Payer Service Group/Lines"},
		{"eBL.ServiceGroup.label","Service Group"},
		{"eBL.ServiceGroupLine.label","Service Group Line"},
		{"eBL.LongDesc.label","Long Description"},
		{"eBL.ShortDesc.label","Short Description"},
		{"eBL.PrintSeqNo.label","Print Seq. No."},
		{"eBL.MarkUpDown.label","Mark Up/Down"},
		{"eBL.PaymentBasisInd.label","Payment Basis Indicator"},
		{"eBL.HomeMed.label","Home Medication"},
		{"eBL.ICUBedCharge.label","ICU/Bed Charge"},
		{"eBL.ServiceGrpLine.label","Service Group Line"},
		{"eBL.DocPrintSeq.label","Doc Print Seq"},
		{"eBL.NonDrgRel.label","Non DRG Related"},
		{"eBL.BillingServices.label","Billing Services"},
		
		//Added for Billing Class Date : 13/12/2012
		{"eBL.BillingClassTitle.label","Billing Classes"},
		{"eBL.BillingClass.label","Billing Class"},
		{"eBL.ServiceLevel.label","Level of Service"},
		{"eBL.ServRulAppInd.label","Time Factor Applicable"},
		
		/* PackageServiceGroup changes starts here - done by boopathy on 10/12/2012 */
		{"eBL.PackageGroupCode.Label","Package Group Code"},
		{"eBL.INDICATOR.label","Indicator"},
		{"eBL.ServiceCode.label","Service Code"},
		{"eBL.ServiceDescription.label","Service Description"},
		/* PackageServiceGroup changes Ends here - done by boopathy on 10/12/2012 */
		
		//Added for Set up Rule Factors Date : 18/12/2012
		{"eBL.MaintainTimeTabTitle.label","Maintain Time-based Factors"},
		{"eBL.CreateTimeTabTitle.label","Create Time-Based Factors"},
		{"eBL.CreateTimeSlabs.label","Create Time Slabs"},
		{"eBL.BillingClass.label","Billing Class"},
		{"eBL.DayType.label","Day Type"},
		{"eBL.TimeType.label","Time Type"},
		{"eBL.From.label","From"},
		{"eBL.To.label","To"},
		{"eBL.Hrs.label","Hrs"},
		{"eBL.BillingService.label","Billing Service"},
		{"eBL.Description.label","Description"},
		{"eBL.AddlFactor.label","Additional Factor"},
		{"eBL.To.label","To"},
		{"eBL.Option.label","Option"},
		{"eBL.AddlFactor.label","Additional Factor"},
		{"eBL.TimeSlabs.label","Time Slabs"},
		
		//Added for Discharge Cust and Cash Group 
		{"eBL.CustGrpTabTitle.label","Customer Grp"},
		{"eBL.CashGrpTabTitle.label","Cash Billing Grp"},
		{"eBL.PolicyCode.label","Policy Code"},
		{"eBL.AppyForPayers.label","Apply For Other Payers Y/N"},

		//CRF - Health card Subscription - Rajesh V
		{"eBL.CARD_TYPE.label","Card Type"},
        {"eBL.MEMBER_SHIP_FEES.label","Member Ship Fees"}, 
        {"eBL.PRIVILIEGE_CARD_MEMBER.label","Privilege Card Member"}, 
		{"eBL.ActiveHealthCard.label","Active Health Card"}, 
		//CRF - Health card Subscription - Rajesh V

		/* BillingGroupCategory changes starts here - done by boopathy on 24/12/2012 */
		{"eBL.BillingGroupCategoryCode.Label","Billing Group Code"},
		{"eBL.BillingGroupCategory.Label","Billing Group Category"},
		{"eBL.DetailDescription.label","Detail Description"},
		/* BillingGroupCategory changes Ends here - done by boopathy on 24/12/2012 */

		/* MaintainPrevilageCard changes starts here - done by boopathy on 09/01/2013 */
		{"eBL.BLClinic.label","Clinic"}, 
		{"eBL.BLVisitType.label","Visit Type"}, 
		{"eBL.BLNoOfVisit.label","# of Visit"}, 	
		{"eBL.BLAvailed.label","Availed"}, 	
		{"eBL.BLOpVisitUtilazationStatus.label","OP Visit Utilization Status"}, 	
		{"eBL.BLNoOfOPAllotment.label","No Of OP Allotment"}, 	
		{"eBL.BLTillDateAvailed.label","Till Date Availed"}, 	
		{"eBL.BLDetails.label","Details"},
		{"eBL.CARD_TYPE.label","Card Type"},
        {"eBL.MEMBER_SHIP_FEES.label","Membership Fees"}, 
        {"eBL.PRIVILIEGE_CARD_MEMBER.label","Privilege Card Member"},
		{"eBL.PrimaryPatientID.label","Primary Patient ID"},
		/* MaintainPrevilageCard changes Ends here - done by boopathy on 09/01/2013 */
        
        /* HealthCardMaster changes start here. Added by karthik on 22-Jan-2013 */
		{"eBL.HCMasterValidity.label","Card Validity(Days)"}, 
		{"eBL.HCMasterApplicability.label","Card Applicability(From-To)"}, 
		{"eBL.HCMasterEnabled.label","Enabled"}, 
		{"eBL.HCMasterAgeGroup.label","Age Group"}, 
		{"eBL.HCMasterPriceClass.label","Price Class"}, 
		{"eBL.HCMasterOPAllotment.label","OP Allotment"}, 
		{"eBL.HCMasterBGDetails.label","Applicable Billing Group Details"}, 
		{"eBL.HCMasterBGCode.label","Billing Group Code"},
		{"eBL.HCMasterNoOfPat.label","No Of Patients Allowed"},
        /*HealthCardMaster changes start here.Added by karthik on 22-Jan-2013*/
		
		//Policy Definition Screen
		{"eBL.PolicyApplicability.label","Policy Applicability"},
		{"eBL.DefPolicyStartDate.label","Default Policy Start Date"},
		{"eBL.PolicySettlementApplicability.label","Policy Settlement Applicability"},
		{"eBL.PolicyEndDate.label","Policy End Date"},
		{"eBL.PolicycoverageBasis.label","Policy coverage Basis"},
		{"eBL.PolicycoverageRules.label","Policy coverage Rules"},
		{"eBL.CoveragePercent.label","Coverage %"},
		{"eBL.PolicyExpDays.label","Default Policy Exp Days"},
		{"eBL.PolicyInclExclCoverage.label","Policy Incl/Excl Coverage Details"},
		{"eBL.PreApprovalDetails.label","Pre Approval Details"},
		{"eBL.PAYER.label","Payer"},
		
		{"eBL.PolicyInclExclDetails.label","Policy Include/Exclude Details"},
		{"eBL.CoverageDetails.label","Coverage Details"},
		
		{"eBL.DefaultInclExclCriteria.label","Default Exclude/Include Criteria"},
		{"eBL.ServiceInclExclCriteria.label","Service Exclude/Include Criteria"},
		{"eBL.ServiceCoverageLimit.label","Service Coverage Limit Criteria"},
		{"eBL.OverrideInclExcl.label","Override Inclusion/Exclusion for Unspecified services"},
		{"eBL.CoverageOtherPayer.label","Coverage includes Other Payers"},
		{"eBL.LastPayer.label","Last Payer"},
		
		{"eBL.OutpatientEmergency.label","Outpatient/Emergency"},
		{"eBL.InpatientDayCare.label","Inpatient/DayCare"},

		{"eBL.CreditAuthReq.label","Credit Auth required"},
		{"eBL.CreditAuthMand.label","Credit Auth Entry Mandatory"},
		{"eBL.CreditAuthrefNo.label","Default Credit Auth Ref as Policy No"},
		{"eBL.Covered.label","Covered"},
		{"eBL.LimitAmt.label","Limit Amt"},
		{"eBL.CoverageType.label","Coverage Limit Type"},
		{"eBL.MandChkBillGen.label","Mandatory Check for Bill Gen"},
		{"eBL.MandChkInvoiceGen.label","Mandatory Check for Invoice Gen"},
		
		{"eBL.ServicePolicyCoverage.label","Policy Coverage"},
		{"eBL.MaterialPolicyCoverage.label","Material Item Policy Coverage"},
		
		{"eBL.DefaultInclExclItem.label","Default Item Exclude/Include criteria"},
		{"eBL.MaterialInclExclItem.label","Material Item Exclude/Include criteria"},
		{"eBL.MaterialItemLimit.label","Material Item Coverage limit criteria"},
		{"eBL.OPCoverageLimit.label","Outpatient Coverage limit type"},
		{"eBL.OPCoverageAmt.label","Outpatient Coverage limit amount"},
		{"eBL.IPCoverageLimit.label","Inpatient Coverage limit type"},
		{"eBL.IPCoverageAmt.label","Inpatient Coverage limit amount"},
		
		{"eBL.EpisodeEncounter.label","Episode/ Encounter"},
		{"eBL.ClinicNu.label","Clinic / Nursing unit"},
		{"eBL.ClinicNuDetails.label","Clinic / Nursing unit Details"},
		{"eBL.SpecDetails.label","Speciality Details"},
		{"eBL.BGServiceDetails.label","Billing Services Details"},
		{"eBL.IncExcCriteria.label","Inc / Exc Criteria"},
		{"eBL.IncExcInd.label","Inc / Exc Ind"},
		{"eBL.InclusionBasis.label","Inclusion Basis"},
		{"eBL.ServItemQty.label","Serv/Item Qty"},
		{"eBL.AmtVisit.label","Amount Limit"},
		{"eBL.AmtAdmission.label","Amt per Admission"},
		{"eBL.AmtIPDay.label","Amount Limit per Day"},
		{"eBL.EffFromDate.label","Eff From Date"},
		{"eBL.EffToDate.label","Eff To Date"},
		{"eBL.PreAppAmtCap.label","Pre Approval Amt Capping"},
		{"eBL.PreAppQtyCap.label","Pre Approval Qty Capping"},
		{"eBL.EffToDate.label","Eff To Date"},
		
		{"eBL.SoleCoverage.label","Sole Coverage by Payer"},
		{"eBL.SharedCoverage.label","Shared Coverage with Other Payer"},
		{"eBL.AllIncluded.label","All Services Included"},
		{"eBL.AllExcluded.label","All Services Excluded"},
		{"eBL.ServGrpClass.label","Service Group/Classification"},
		{"eBL.EntGrpLine.label","Enterprise Group/Line"},
		{"eBL.PayerServiceGrp.label","Payer Service Group"},
		{"eBL.ByEntGrpLine.label","By Enterprise Service Group/Line"},
		{"eBL.EntServGrpLine.label","Enterprise Service Group/Line"},
		{"eBL.ByPayerServiceGrp.label","By Payer Service Group"},
		{"eBL.Restricted.label","Restricted"},
		{"eBL.UnRestricted.label","Un-Restricted"},
		{"eBL.DiagnosisMR.label","Diagnosis by MR"},
		{"eBL.DiagnosisPractioner.label","Diagnosis by Practioner"},
		{"eBL.Percentage.label","Percentage"},
		{"eBL.AllItemsIncluded.label","All Items Included"},
		{"eBL.AllItemsExcluded.label","All Items Excluded"},
		{"eBL.PayerMatGroup.label","Payer Material Group"},
		{"eBL.EnterpriseMatGroup.label","Enterprise Material Group"},
		{"eBL.SaleCategory.label","Sale Category"},
		{"eBL.servicedtls.label","Serv Level Reqd"},

		{"eBL.Episode.label","Episode"},
		{"eBL.Encounter.label","Encounter"},
		{"eBL.OrthoClinic.label","Ortho Clinic"},
		{"eBL.NuroClinic.label","Nuro Clinic"},
		{"eBL.GeneralWard.label","General Ward"},
		{"eBL.SingleBed.label","Single Bed"},
		{"eBL.DoubleBed.label","Double Bed"},
		{"eBL.Rad.label","Rad"},
		{"eBL.Cardio.label","Cardio"},
		{"eBL.Nuro.label","Nuro"},
		{"eBL.Ortho.label","Ortho"},
		{"eBL.PrintGroup.label","Print Group"},
		{"eBL.PrintGroupLine.label","Print Group/Line"},
		{"eBL.Gross.label","Gross"},
		{"eBL.Net.label","Net"},
		{"eBL.ScreeningPolicy.label","Screening Policy"},
		{"eBL.PatCopay.label","Patient Copay"},
		{"eBL.PatAmtLimit.label","Pat Amt Limit"},
		{"eBL.RecalculationCharges.label","Recalculation Charges"},
		{"eBL.SplitReqd.label","Split Reqd"},
		{"eBL.DefGrpIdSameEpisode.label","Default Grp Id for Same Episode"},
		{"eBL.TimeLimitDefaultGrp.label","Time Limit for Default Group"},
		//Policy Definition Screen

		//Billing Print Format - Added by Rajesh V
		{"eBL.BillFormatTabHeading.label","Bill Format"},
		{"eBL.FmtDetailsTabHeading.label","Format Details"},
		{"eBL.CustBgGrpBillFmtTabHeading.label","Customer/Billing Group Bill Format"},
		{"eBL.SummByBlgServTabHeading.label","Summary by Billing Service"},
		{"eBL.BillPrintFmtServTabHeading.label","Bill Print Format Service"},
		{"eBL.BillFmtCustTabHeading.label","Bill Format for Customer"},
		{"eBL.BillFmtBgTabHeading.label","Bill Format for Billing Group"},
		{"eBL.StaticInfoTabHeading.label","Static Information"},
		
		{"eBL.BillFormatTabHeading.label","Bill Format"},
		{"eBL.FmtDetailsTabHeading.label","Format Details"},
		{"eBL.CustBgGrpBillFmtTabHeading.label","Customer/Billing Group Bill Format"},
		{"eBL.SummByBlgServTabHeading.label","Summary by Billing Service"},
		{"eBL.BillPrintFmtServTabHeading.label","Bill Print Format Service"},
		{"eBL.BillFmtCustTabHeading.label","Bill Format for Customer"},
		{"eBL.BillFmtBgTabHeading.label","Bill Format for Billing Group"},
		{"eBL.StaticInfoTabHeading.label","Static Information"},
		
		{"eBL.FormatCode.label","Format Code"},
		{"eBL.FormatDesc.label","Format Description"},
		{"eBL.toolBarFuncName.label","ToolBar Function Name"},
		{"eBL.LinkingURL.label","Linking URL "},
		{"eBL.ToolBarFormat.label","ToolBar Format"},
		{"eBL.ToolBarAssociation.label","ToolBar Association "},
		{"eBL.IconDetail.label","Icon Detail "},
		{"eBL.FirstTimePrintInd.label","First Time Print Indicator"},
		{"eBL.RePrintInd.label","RePrint Indicator"},
		{"eBL.ApplicableTo.label","Applicable To"},
		{"eBL.IP.label","IP"},
		{"eBL.DC.label","DC"},
		{"eBL.OP.label","OP"},
		{"eBL.EM.label","EM"},
		{"eBL.EX.label","EX"},
		{"eBL.ALL.label","ALL"},
		
		{"eBL.SummaryByPrintGroup.label","Summary By Print Group"},
		{"eBL.PrintDoctor.label","Print Doctor"},
		{"eBL.PrintDoctorInsteadOfDescription.label","Print Doctor Instead Of Description"},
		{"eBL.DetailByPrintGroupLine.label","Detail By Print Group Line"},
		{"eBL.PrintDoctorSpeciality.label","Print Doctor Speciality"},
		{"eBL.PrintServiceDescforItem.label","Print Service Desc for Item"},
		{"eBL.DetailByService.label","Detail By Service"},
		{"eBL.PrintRemarksforMiscServiceinsteadofDescription.label","Print Remarks for Misc Service insteadof Description"},
		{"eBL.SummaryByBillingService.label","Summary By Billing Service"},
		{"eBL.Subtotal.label","Subtotal"},
		{"eBL.SupressZeroGross.label","Supress Zero Gross"},
		{"eBL.PrintDischargeSepLine.label","Print Disch Med in separate line"},
		
		{"eBL.BillTitleHeading.label","Bill Title"},
		{"eBL.BillHeaderHeading.label","Bill Header"},
		{"eBL.ServiceHeading.label","Service"},
		{"eBL.TotalHeading.label","Total"},
		{"eBL.EndOfBillHeading.label","End Of Bill"},
		
		{"eBL.SeqNo.label","Seq No"},
		{"eBL.Column1.label","Column1"},
		{"eBL.Column2.label","Column2"},
		{"eBL.Column3.label","Column3"},
		{"eBL.Column4.label","Column4"},
		{"eBL.Column5.label","Column5"},
		{"eBL.Column6.label","Column6"},
		{"eBL.StaticValue.label","Static Value"},
		{"eBL.StaticLegend.label","Static Legend"},
		{"eBL.DetailOnly.label","Detail Only"},
		{"eBL.DetailRequired.label","Detail Required"},
		{"eBL.SupressZero.label","Supress Zero"},
		{"eBL.Justification.label","Justification"},
		
		{"eBL.CustomerHeading.label","Customer"},
		{"eBL.BillingGroupHeading.label","Cash Billing Group"},
		{"eBL.CustomerGroupCode.label","Customer Group Code"},
		{"eBL.CustomerCode.label","Customer Code"},
		{"eBL.CustomerName.label","Customer Name"},
		{"eBL.BillingGroup.label","Billing Group"},
		{"eBL.BillType.label","Bill Type"},
		{"eBL.PrintReprint.label","Print/Reprint"},
		{"eBL.SummHeading.label","Billing Services of the selected print group will be printed in summary"},
		{"eBL.PrintGroupHdrCode.label","Print Group Hdr Code"},

		{"eBL.ServiceDescription.label","Service Description"},
		{"eBL.PrintGrpLineServInd.label","Print Grp Line Service Indicator"},
		{"eBL.PrintGroupServiceCode.label","Print Group Service Code"},
		{"eBL.PrintGroupLineCode.label","Print Group Line Code"},
		{"eBL.PrintGroupDescription.label","Print Group Description"},
		{"eBL.ServiceLongDescription.label","Service Long Description"},
		//Billing Print Format - Added by Rajesh V

     //Added for Customer Specification Master Changes by Boopathy
        
        {"eBL.CUSTOMER_SPECIFIC.label","Customer Specific"},
        {"eBL.CASH_BILNG_GRP_SPECIF.label","Cash Billing Group Specific"}, 
        {"eBL.CUSTOMER_DETAILS.label","Customer Details"},
        {"eBL.CUST_SPEC_LONG_DESC.label","Cust Spec Long Desc"},  
        {"eBL.CUST_SPEC_SHORT_DESC.label","Cust Spec Short Desc"}, 
        {"eBL.CUST_SPEC_BLNG_SERV_CODE.label","Cust Spec Blng Serv Code"},
        {"eBL.BLNG_GRP_ID.label","Blng Grp Id"},	
        {"eBL.BLNG_GRP_SPEC_LONG_DESC.label","Blng Grp Spec Long Desc"},  
        {"eBL.BLNG_GRP_SPEC_SHORT_DESC.label","Blng Grp Spec Short Desc"},
        {"eBL.BLNG_GRP_BLNG_SERV_CODE.label","Blng Grp Spec Blng Serv Code"}, 

		{"eBL.AGELIMIT.label","Age Limit"}, 
		{"eBL.AGELIMITFROM.label","Age Limit (From)"}, 
		{"eBL.AGELIMITTO.label","Age Limit (To)"}, 
		{"eBL.INSIMAGEUPLOAD.label","Upload Image"}, 
		{"eBL.INSIMAGEUPLOADDOC.label","Uploaded Insurance Document"}, 

	
			
        //Added for Customer Specification Master Changes by Boopathy

		 //Added for Billing Panel Master Changes by Boopathy
        
        {"eBL.PanelDetails.label","Panel Details"},  
        {"eBL.PanelConstituents.label","Panel Constituents"},
        {"eBL.PanelCategories.label","Panel Categories"}, 
        {"eBL.InterCompanySetup.label","InterCompany Setup"}, 
        {"eBL.QtyModifiable.label","Qty Modifiable"}, 
        {"eBL.FromFacility.label","From Facility"},
        {"eBL.InterCompanyToFacility.label","InterCompany To Facility"}, 
        
        
        //Added for Billing Panel Master Changes by Boopathy
        
        //Added for Record Approval Changes by Boopathy
        
        {"eBL.BillingServiceDesc.label","Billing Service Description"},
        {"eBL.ApprovalNumber.label","Approval Number"},
        {"eBL.ServiceAmount.label","Service Amount"},
        {"eBL.ApprovalRequiredDate.label","Approval Requested Date"},
        {"eBL.ApprovalGivenDate.label","Approval Given Date"},
        {"eBL.ServiceQuantity.label","Serv Qty"},
        {"eBL.APPROVED_QTY.label","Approved Qty"},
      //Added for Record Approval Changes by Boopathy

		//Added by Rajesh V for Transactions
		{"eBL.DrName.label","DR Name"},
		{"eBL.PercSymbol.label","(%)"},
		{"eBL.BilledUnBilled.label","Billed/Un Billed"},
		{"eBL.Billed.label","Billed"},
		{"eBL.UnBilled.label","Un Billed"},
		{"eBL.Directchgs.label","Direct Charges"},
		{"eBL.Indirectchgs.label","In Direct Charges"},
		{"eBL.Direct/Indirectchgs.label","Direct/In Direct Charges"},
		{"eBL.EntGrpCode.label","Ent Grp Code"},
		{"eBL.EntLineCode.label","Ent Line Code"},
		{"eBL.BillingServiceDtls.label","Billing Service Details"},
		{"eBL.AdhocDisc.label","Adhoc Discount"},
		{"eBL.FromBillNumber.label","Bill Number From"},
		{"eBL.BillNumber.label","Bill Number "},//Added for MOHE-CRF-0050.3
		{"eBL.ToBillNumber.label","Bill Number To"},
		//Added for MOHE-CRF-0050.3_US003 starts
		{"eBL.FromBillNo.label","From Bill Number"}, 
		{"eBL.ToBillNo.label","To Bill Number"},
		{"eBL.FromPolicy.label","From Policy"},
		{"eBL.ToPolicy.label","To Policy"},
		{"eBL.FromPatientID.label","From Patient ID"},
		{"eBL.PatientID.label","Patient ID"},
		{"eBL.ToPatientID.label","To Patient ID"},
		{"eBL.FromCustomer.label","From Customer"},
		{"eBL.ToCustomer.label","To Customer"},
		{"eBL.CutOffDate.label","Cutoff Date"},
		//Added for MOHE-CRF-0050.3_US003 ends
		{"eBL.FromBillDate.label","Bill Date From"},
		{"eBL.ToBillDate.label","Bill Date To"},
		{"eBL.DetailedBillPrint.label","Detailed Bill Print"},
		{"eBL.QTY.label","Qty"},
		{"eBL.BL_RATE_CHARGE_TYPE.label","Rate/Charge"},
		{"eBL.ServiceLocation.label","Service Location"},
		{"eBL.InterCoEncounters.label","InterCo Encounters"},
		{"eBL.NRIC.label","NRIC"},
		{"eBL.UnBilledOrExists.label","UnBilled Exists"},
		{"eBL.PendCancelVisit.label","Pending Bill for Cancelled Visit"},
		{"eBL.PendZeroAmt.label","Pending Bill for Zero Charged Amt"},
		{"eBL.PendPayment.label","Pending Payment"},
		{"eBL.PendVisit.label","Pending Visit Bill"},
		{"eBL.PayerOne.label","Payer 1"},
		{"eBL.PayerTwo.label","Payer 2"},
		{"eBL.PayerThree.label","Payer 3"},
		{"eBL.PayerFour.label","Payer 4"},
		{"eBL.PayerFive.label","Payer 5"},
		{"eBL.ServiceDiscount.label","Service Discount"},
		{"eBL.AdminRemarks.label","Admin Remarks"},
		{"eBL.LessDeposit.label","Less Deposit"},
		{"eBL.Payment.label","Payment"},
		{"eBL.Card.label","Card"},
		{"eBL.DD.label","DD"},
		{"eBL.ForeignCurrency.label","Foreign Currency"},
		{"eBL.Debit.label","Debit"},
		{"eBL.IssuingBranch.label","Issuing Branch"},
		{"eBL.ApprAuthCode.label","Appr / Auth Code"},
		{"eBL.ValidFromMMYY.label","Valid From (MM/YY)"},
		{"eBL.ValidToMMYY.label","Valid Upto (MM/YY)"},
		{"eBL.DDNo.label","DD No"},
		{"eBL.DDAmount.label","DD Amount"},
		{"eBL.DDDate.label","DD Date"},
		{"eBL.ChequeNo.label","Cheque No"},
		{"eBL.ChequeAmount.label","Cheque Amount"},
		{"eBL.ChequeDate.label","Cheque Date"},
		{"eBL.BillGeneration.label","Bill Generation"},
		{"eBL.OutstandAmount.label","Outstanding Amount"},
		{"eBL.SetDefaultValue.label","Set Default Value"},
		{"eBL.OutstandingOnly.label","Outstanding Only"},
		//Added by Rajesh V for Policy Definition Reports

		//Added by Rajesh V for Price Discount
		//{"eBL.PriceInd.label","Price Indicator"},
		{"eBL.PriceCode.label","Price Code"},
		{"eBL.PriceDescription.label","Price Description"},
		{"eBL.ValidFrom.label","Valid From"},
		{"eBL.ValidTo.label","Valid To"},
		{"eBL.ChargeType.label","Charge Type"},
		{"eBL.DiscExists.label","Disc Exists"},
		//{"eBL.DiscApplicability.label","Disc Applicability"},
		//{"eBL.PolicyDesc.label","Policy Description"},
		//{"eBL.CustGroupCode.label","Cust Group Code"},
		//{"eBL.CustGroupDesc.label","Cust Group Desc"},
		{"eBL.PriceDetails.label","Price Details"},
		{"eBL.ChkCostAvl.label","Check Cost Avl"},
		{"eBL.CostIndicator.label","Cost Indicator"},
		{"eBL.CostAmt.label","Cost Amount"},
		//{"eBL.MinCharge.label","Min Charge"},
		//{"eBL.MaxCharge.label","Max Charge"},
		{"eBL.Applicability.label","Applicability"},
		{"eBL.ApplyDiscount.label","Apply Discount"},
		{"eBL.EffectiveFromTo.label","Effective (From-To)"},
		
		{"eBL.DiscountDetails.label","Discount Details"},
		{"eBL.DiscountPercentage.label","Discount Percentage"},
		{"eBL.ApplyDiscount.label","Apply Discount"},
		{"eBL.DiscountIndicator.label","Discount Indicator"},
		{"eBL.DiscFromTo.label","Disc Validity (From-To)"},
		{"eBL.BillingGroup.label","Billing Group"},
		{"eBL.BillingServiceGroup.label","Billing Service Group"},	
        //Added by Rajesh V for Price Discount
        //Added By Ruban
		{"eBL.ServiceIndDesc.label","Service Ind-Desc"},
		{"eBL.PriceInd.label","Price Indicator"},
		{"eBL.PriceIndCode.label","Price Ind Code"},
		{"eBL.PriceIndDescription.label","Price Ind Description"},
		{"eBL.ValidFrom.label","Valid From"},
		{"eBL.ValidTo.label","Valid To"},
		{"eBL.ChargeType.label","Charge Type"},
		{"eBL.DiscExists.label","Disc Exists"},
		{"eBL.DiscApplicability.label","Disc Applicability"},
		{"eBL.PolicyDesc.label","Policy Description"},
		{"eBL.CustGroupCode.label","Cust Group Code"},
		{"eBL.CustGroupDesc.label","Cust Group Desc"},
		{"eBL.IP_RATE.label","IP Rate"},
		{"eBL.OP_RATE.label","OP Rate"},
		{"eBL.EMG_RATE.label","Emg Rate"},
		{"eBL.EXT_RATE.label","Ext Rate"},
		{"eBL.DC_RATE.label","DC Rate"},
		{"eBL.MIN_CHARGE.label","Min Amt"},
		{"eBL.MAX_CHARGE.label","Max Amt"},
		{"eBL.DISC_APPLICABILITY.label","Applicability"},
		{"eBL.DISC_APPLY.label","Apply Disc"},
		//Added By Ruban
        /*Added for OutpatientPharmacyBillRuleSetup by Karhtik on 14-8-2013 Starts*/
        {"eBL.GenerateBill.label","Generate Bill"},
        {"eBL.SettleBill.label","Settle Bill"},
        {"eBL.PrintOption.label","Print Option"},
        {"eBL.GenerateZeroBill.label","Generate Zero Bill"},
        {"eBL.PrintZeroBill.label","Print Zero Bill"},        
       /*Added for OutpatientPharmacyBillRuleSetup by Karhtik on 14-8-2013 Ends*/
        /*Added*/
		{"eBL.USER_TYPE.label","User Type"},
		{"eBL.USER_CODE.label","User Code"},
		{"eBL.PRIVILEGE.label","Privilege"},
		{"eBL.DEFLT_PRIVILEGE.label","Default Previlege"},
		{"eBL.ALLOWED_YN.label","Allowed Y/N "},
        /*Added*/        
		{"eBL.SETTLEMENT_WISE_DISC.label","Settlement wise Discount"},
		{"eBL.PRIORITY_SEQUENCE.label","Priority Sequence"},
		{"eBL.DISC_APPLICABILITY.label","Discount Applicability"},
		{"eBL.DISCOUNT_AMT/%.label","Discount Amt / %"},
        /*Added for OutpatientPharmacyBillRuleSetup by Karhtik on 20-8-2013 Starts*/
        {"eBL.AeCheckoutReceiptPrint.label","A/E Checkout Receipt Print option"},
        {"eBL.AeCheckoutPrintZeroBill.label","Print Zero Bill for A/E Checkout"},        
       /*Added for OutpatientPharmacyBillRuleSetup by Karhtik on 20-8-2013 Ends*/
		{"eBL.eBL.ALLOWED_YN","Allowed Y/N "},
        /*Added for PkgDef PartialDeposit by Karthik on 26-2-2014 Starts*/
        {"eBL.EncounterSequenceNo.label","Encounter Sequence No"},
        {"eBL.PartialDepositType.label","Partial Deposit Type"},
        {"eBL.PartialDeposit.label","Partial Deposit"},
        {"eBL.PartialDepositMandatory.label","Partial Deposit Mandatory"} ,              
       /*Added for PkgDef PartialDeposit by Karthik on 26-2-2014 Ends*/
        
        /*Added for Report Engine  by Karthik on 16-6-2014 Starts*/
        {"eBL.ReportTitle.label","Report Title"},
        {"eBL.ReportHeader.label","Report Header"},
        {"eBL.AllUser.label","All User"},
        {"eBL.UserGroup.label","User Group"},
        {"eBL.Information.label","Information"},
        {"eBL.Alignment.label","Alignment"},
        {"eBL.StaticLegend.label","Static Legend"},
        {"eBL.Middle.label","Middle"},
        {"eBL.Left.label","Left"},
        {"eBL.Right.label","Right"},
        {"eBL.ReportHeader.label","Report Header"},
        {"eBL.ReportDetails.label","Report Details"},
        {"eBL.DataGroup.label","Data Group"},
        {"eBL.ReportPreview.label","Report Preview"},
        {"eBL.DataGroupInformation.label","Data Group Information"},
        {"eBL.TotalRequired.label","Total Required"},
        {"eBL.ReportCriteria.label","Report Criteria"},
		{"eBL.SeqNo.label","Seq No"},
		{"eBL.CriteriaSeqNo.label","Criteria Seq No"},
        {"eBL.OrderBy.label","Order By"},  
        {"eBL.Type.label","Type"},  
        {"eBL.DefaultValue.label","Default Value"},  
        {"eBL.Mandatory.label","Mandatory"} , 	
        {"eBL.DropDown.label","DropDown"},  
        {"eBL.Selection.label","Selection"}  ,
        {"eBL.CalendarSelection.label","Calendar Selection"} , 	
		{"eBL.ViewReportCriteria.label","View Report Criteria"},  	
	    {"eBL.SelectCriteria.label","Select Criteria"},
		{"eBL.ProvideAccessRights.label","Provide Access Rights"},
		{"eBL.UserAccessRights.label","User Access Rights"},	
		{"eBL.ExistingUsersList.label","Existing Users List"},
        {"eBL.ReportData.label","Report Data"},
		{"eBL.ViewDownloadFile.label","Click to View/Download File"},
        /*Added for Report Engine  by Karthik on 16-6-2014 Ends*/
        {"eBL.ClaimCode.label","Claim Code"},
		{"eBL.CreditAuthorisationBy.label","Credit Authorisation By"},
		//Policy Definition
		{"eBL.TimeLimitGrpOP.label","Time Limit Dflt Grp"},
		{"eBL.TimeLimitGrpIP.label","Time Limit Dflt Grp - IP"},
		//Policy Definition 
		//Added by Rajesh V for Package ulk Update
		{"eBL.CurrentPrice.label","Current Price"},
		{"eBL.RevisedPrice.label","Revised Price"},
		{"eBL.StdCustPrice.label","Std / Customer Price"},
		{"eBL.CustomerPrice.label","Customer Price"},
		{"eBL.StandardPrice.label","Standard Price"},
		{"eBL.BulkUpdPkgPrice.label","Bulk Update / Individual Package"},
		{"eBL.BulkUpdate.label","Bulk Update"},
		
		{"eBL.PkgPriceType.label","Package Price Type"},
		{"eBL.PercentageOrAmt.label","Percentage / Amt"},
		{"eBL.MarkUpOrDown.label","Mark Up / Down"},
		{"eBL.RoundOff.label","Round Off"},
		{"eBL.RoundUpOrDown.label","Round Up / Down"},
		{"eBL.PackageRate.label","Package Rate"},
		{"eBL.IndPkg.label","Individual Package"},
		{"eBL.JobId.label","Job Id"},
		{"eBL.ProcessDate.label","Process Date"},
		{"eBL.JobStatus.label","Job Status"},
		{"eBL.JobList.label","Job List"},
		{"eBL.BulkPkgPrice.label","Bulk/Pkg Price"},
		{"eBL.PackagePriceType.label","Package Price Type"},
		{"eBL.ErrorDesc.label","Error Desc"},		
		{"eBL.RevisedDiscountValue.label","Revised Discount Value"},
		{"eBL.RevisedDiscountType.label","Revised Discount Type"},
		{"eBL.CurrentPriceFactor.label","Current Price / Factor"},
			
		//Added by Rajesh V for Package ulk Update
        {"eBL.ScreeningServiceApplicable.label","Screening Service Applicable"},	 
        {"eBL.ScreeningServiceApplicabilityStatus.label","Screening Service Applicability Status"},	
        {"eBL.ApplicableQuantity.label","Applicable Quantity"},	
        {"eBL.ApplicableAmount.label","Applicable Amount"},
        {"eBL.BillPaidAmt.label","Bill Paid Amt"},	 
        {"eBL.BillOutStdAmt.label","Bill Out Std. Amt"},	
        {"eBL.InterimBill.label","Interim Bill"},	 
        {"eBL.DischargeBill.label","Discharge Bill"},	
        {"eBL.UnderchargeAdvice.label","Undercharge Advice"},	
        {"eBL.ExternalBill.label","External Bill"},	        
        {"eBL.VisitBill.label","Visit Bill"},
		//Added by Rajesh V for KDAH-CRF-0318
		{"eBL.CosmeticRuleHeader.label","Bill Tax Rule"},
		{"eBL.RuleCode.label","Rule Code"},
		{"eBL.CriteriaForTax.label","Criteria For Tax"},
		{"eBL.InclusionExclusion.label","Inclusion/Exclusion"},
		{"eBL.AllPatClass.label","All Patient Class"},
		//Added by Rajesh V for KDAH-CRF-0318
		//Added by Rajesh V for MMS-CRF-0198.1
		{"eBL.BillApprovedInv.label","Bill Approved / Invoiced"},
		//Added by Rajesh V for MMS-CRF-0198.1
		{"eBL.IDENTIFY_TYPE.label","Identifier type"},
		{"eBL.NID.label","NID"},		

		//IRB-Conversion
		{"eBL.CANCELREASON.label","Reason For Cancel"}, 
		{"eBL.Service.label","Services"},
		{"eBL.Print.label","Print "},
		{"eBL.Cancel.label","Cancel"},
		{"eBL.consolidatedBillSettlement.label","Consolidated Bill Settlement"},
		{"eBL.Fromreceiptnumber.label","From Doc Type/Number"},
		{"eBL.downtimereceiptno.label","Downtime Document"},		
		{"eBL.documentnumber.label","Document Number"},
		{"eBL.FromreceiptDate.label","From Date"},
		{"eBL.ToreceiptNumber.label","To Doc Type/Number"},
		{"eBL.ToreceiptDate.label","To Date"},		
		{"eBL.Receipt_Detail.label","Settlement Details"},
		{"eBL.Slash.label","/"},
		{"eBL.HealthcareApplnnumber.label","Hcare Appln No"},
		{"eBL.Options.label","Print Options"},
		{"eBL.RECEIPT.label","Receipt"},
		{"eBL.ACKNOWLEDGEMENT.label","Acknowledgement Letter"},
		{"eBL.BOTH.label","Both"},
		{"eBL.VOIDNUMBER.label","Void Number"},
		{"eBL.REASONFORCANCEL.label","Reason For Cancel"},
		{"eBL.CURRENT_DAYCARE.label","Current Daycare"},
		//IRB-Conversion
		//	added by suganya for cancel receipt
		{"eBL.episodeid.label","Episode Id/Visit Id"},
		{"eBL.episodeId.label","Episode Id"},	
		{"eBL.doc_srno.label","Doc SrNo"},
		{"eBL.doc_amt.label","Document Amount"},
		{"eBL.slmt_type_code.label","Settlement Type Code"},
		{"eBL.cash_amt_given.label","Cash Amt Given"},
		{"eBL.cash_amt_returned.label","Cash Amt Returned"},
		{"eBL.slmt_doc_ref_desc.label","Settlement Doc Ref Desc"},
		{"eBL.bank_code.label","Bank Code"},
		{"eBL.slmt_doc_remarks.label","Settlement Doc Remarks"},
		{"eBL.bank_branch.label","Bank Branch"},
		{"eBL.cc_batch_no.label","Cc Batch No"},
		{"eBL.approval_ref_no.label" ,"Approval Ref No"},
		{"eBL.cc_swapped_yn.label","Cc Swapped Y/N"},
		{"eBL.cc_sale_draft_no.label","Cc Sale Draft No"},
		{"eBL.payer_name.label","Payer Name"},
		{"eBL.nominee_name.label","Nominee Name"},
		{"eBL.post_month.label","Post Month"},
		{"eBL.post_year.label","Post Year"},
		{"eBL.consolidated_receipt_yn.label","Consolidated Receipt Y/N"},
		{"eBL.DocAmt.label","Document Amount"},
		{"eBL.Removeall.label","Remove All"},
		{"eBL.ReceiptNatureCode.label","Receipt Nature"},
		{"eBL.ReceiptTypeCode.label","Receipt Type"},
		{"eBL.receiptno.label","Document No"},
		{"eBL.PAT_DEP_PKG.label","Patient Deposit Against Pkg"},
		{"eBL.DEP_SRGY.label","Deposit Against Surgery"},

        {"eBL.IRBSelect.label","Select"},	 
        {"eBL.IRBDocumentType.label","Document Type"},	
        {"eBL.IRBDocumentNumber.label","Document Number"},	
        {"eBL.IRBDocumentSrNo.label","Document Sr No"},
        {"eBL.IRBSettlementType.label","Settlement Type"},	 
        {"eBL.IRBAmount.label","Amount"},	
        {"eBL.IRBAdjustedAmount.label","Adjusted Amount"},	 
        {"eBL.IRBAmountPayable.label","Amount Payable"},	
        {"eBL.IRBBillNo.label","Bill No"},	
        {"eBL.IRBServiceDate.label","Service Date"},	        
        {"eBL.IRBDocRef.label","Doc Ref"},
        {"eBL.IRBDocLineNo.label","Doc LineNo"},	 
        {"eBL.IRBDocSeqNo.label","Doc Seq No"},	
        {"eBL.IRBBlngServiceCode.label","Blng Service Code"},	
        {"eBL.IRBApplicableAmount.label","Applicable Amount"},
        {"eBL.IRBAdjAmt.label","Adj Amt"},	 
        {"eBL.IRBServiceAmt.label","Service Amt"},
        {"eBL.IRBIncludeExclude.label","Include/Exclude"},		
        {"eBL.IRBDelete.label","Delete"},
		//Added by Karthik for IRB changes for Bill Settlement - Ends
		{"eBL.Document_Number.label","Document Number"},
		{"eBL.DepositReason.label","Reason"},
		{"eBL.DepositDate.label","Date"},
		{"eBL.DownTimeEntry.label","DownTime Entry"},
		{"eBL.DocNoslash.label","/"},		     
		{"eBL.EpisodeNo.label","Episode No."},		     
		{"eBL.OriginalDocNo.label","Original Doc No"},		     		
		{"eBL.BookingReference.label","Booking Ref.No"},		     
		{"eBL.EstimateForDeposit.label","Estimate For Deposit"},		     
		{"eBL.PostMthYr.label","Post Mth/Yr"},		     
		{"eBL.EnterServiceItem.label","Enter Service Item"},		     
		{"eBL.ServiceIndicator.label","Service Indicator"},		     
		{"eBL.ServiceDate/Time.label","Service Date/Time"},		     
		{"eBL.TotalBillAmount.label","Total Bill Amount"},		    
		{"eBL.BillPaidAmount.label","Bill Paid Amount"},		    
		{"eBL.Emergency.label","Emergency"},		    
		{"eBL.External.label","External"},		    
		{"eBL.Depositdetails.label","Deposit Details"},		    
		{"eBL.Utilizedamount.label","Utilized Amount"},		    
		{"eBL.Depositamount.label","Deposit Amount"},
		{"eBL.requestid.label","Request Id"},
		{"eBL.serviceCode.label","Service Code"},
		{"eBL.EnterBillingServiceDetails.label","Enter Billing Service Details"},
		{"eBL.DepositAgainstSurgery.label","Deposit Against Surgery"},
		{"eBL.DepositReceipt.label","Deposit Receipt/Refund"}, 
		//Added by Vijay A.P For IRB-Deposit Refund 
		//IRB Bill Generation
		{"eBL.Alternative id.label","Alternate Id Type"},
		{"eBL.Id.label","Id"},
		{"eBL.Patient Name.label","Patient Name"}, 
		//IRB Bill Generation
		 {"eBL.records.label","Records"},
		 {"eBL.modules.label","Modules"},
		 {"eBL.prmodule.label","Pr.Module"},
		 {"eBL.prkeymain.label","Pr.Key Main"},
		 {"eBL.patientno.label","Patient No"},
		 {"eBL.servicelocation.label","Service Location"},
		 {"eBL.chargedate.label","Charge Date"},
		 {"eBL.PhysicianId.label","Physician Id"},
		 {"eBL.PrimaryKey.label","Primary Key"},
		 {"eBL.SecondaryKey.label","Secondary Key"},
		 {"eBL.ServiceItemcode.label","Service Item Code"},
		 {"eBL.InterfacedDate.label","Interfaced Date"},
		 {"eBL.Charged.label","Charged"},
		 {"eBL.ChargingState.label","ChargingState"},
		 {"eBL.notCharged.label","Not Charged"},
		 {"eBL.FutureOrder.label","Future Order"},
		{"eBL.Excluded.label","Excluded"},
		{"eBL.DepositAmount.label","Deposit Amount"},
		{"eBL.UtilizedAmount.label","Utilized Amount"},
		{"eBL.DepositDetails.label","Deposit Details"},
		{"eBL.POLICY_NAME.label","Policy Name"},
		{"eBL.BILL_DOC_NUMBER.label","Bill Number/Code"},                
		{"eBL.SelectBillingService.label","Select Billing Service"},
		{"eBL.BASE_PRICE.label","Base Price"},
		{"eBL.PRINT_GROUP.label","Prnt GRP"},
		{"eBL.PRINT_LINE.label","Prnt Line"},
		{"eBL.DIR_ENTRY.label","Dir Entry"},
		{"eBL.DR_FEE.label","Dr Fee"},
		{"eBL.MISC_SERV.label","Misc Serv"},
		{"eBL.MINIMUM_AMOUNT.label" ,"Minimum Amount"},
		{"eBL.NET_CHARGE.label","Net Amount"},
		{"eBL.voidNumber.label","Void Number"},
		{"eBL.DocNum.label","Doc Num"},
        {"eBL.SRNO.label","Sr No"},
        {"eBL.RN.label","RN"},
        {"eBL.SE.label","SE"},
        {"eBL.docamt.label","Doc Amt"},
        {"eBL.oustamt.label","Oust Amt"},
		{"eBL.chargedate.label","From Charge Date"},
		 {"eBL.tochargedate.label","To Charge Date"},
		{"eBL.Exempt Type.label","Exempt Type"},
		{"eBL.Assign To.label","Assign To"},
		//Added by Pradeepa K for GHL-CRF-424
		{"eBL.PKG_SUBS_MSG.label","Multi Encounter Package subscribed for the patient is Active"}, 
		//Added for Unbilled Summary of Company Invoice by sarathkumar
		{"eBL.ApprovalStatus.label","Approval Status"},
		{"eBL.PatientWise.label","Patientwise"},
		{"eBL.PayerWise.label","Payerwise"}, 
		//Added by Pradeepa K for PMG-CRF--0005
		{"eBL.VisitAdmissionDate.label","Check-in/Admission DateTime"},
		{"eBL.CheckOutDischargeDate.label","Check-out/Discharge DateTime"},
		{"eBL.MembershipNo.label","Membership No."},
		{"eBL.DependantNo.label","Dependant No."},
		{"eBL.DependantRelatiosnhip.label","Dependant Relationship"},
		{"eBL.WCANo.label","WCA No."},
		{"eBL.ResponseCode.label","Response Code"},
		{"eBL.ValidityPeriod.label","Validity Period"},
		{"eBL.EligibilityCode.label","Eligibility Code"},
		{"eBL.StatusDescription.label","Status Description"},
		//Added by Sethu for GHL-CRF-0415 ON 18/04/2017 
		{"eBL.PAYTM_USER_CODE.label","PayTM User Code"},
		{"eBL.PAYTM_PROMO_CODE.label","Promo Code"},
		{"eBL.PAYTM_PAY.label","PayTM"},
		{"eBL.PAYTM_CHECK_STATUS.label","Check Status"},
		{"eBL.PAYTM_TXN_NO.label","Transaction ID"},
		{"eBL.ADDL_CHARGE.label","Additional Charge"},	//Added V171212-Gayathri/MMS-DM-CRF-0118
		//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts

		{"eBL.VAT_APPLICABLE.label","VAT Applicable"},
		{"eBL.VAT_PERCENTAGE.label","VAT Rule"},
		{"eBL.RULE_COVERAGE.label","Rule Coverage"},
		{"eBL.AS_PER_POLICY.label","As Per Policy"},
		{"eBL.PAYER_COVERAGE.label","Payer Coverage"},
		{"eBL.PATIENT_COVERAGE.label","Patient Coverage"},
		//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
		{"eBL.PAYTM_ORDER_NO.label","Merchant Order ID"},
		//Added by Sethu for GHL-CRF-0415 ON 18/04/2017
		{"eBL.Patient_Id_From.label","Patient ID (From)"},
		{"eBL.Patient_Id_To.label","Patient ID (To)"},
		//Added by Sethu for GHL-CRF-0415.2 ON 02/02/2018
		{"eBL.PAYTM_PAYBY_OPTION.label","Pay By Option"},
		{"eBL.PAYTM_PAYBY_BARCODE.label","Barcode"},
		{"eBL.PAYTM_PAYBY_TOTP.label","Phone + OTP"},
		{"eBL.PAYTM_PHONE_NO.label","Phone Number"},
		{"eBL.PAYTM_OTP.label","OTP"},
		{"eBL.UNBILLED_NEW.label","Unbilled"},  /* Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/if condition */
		//Added by Rajesh V for ML-MMOH-CRF-1088
		{"eBL.CHQ_CARD_BANK_NO_OTH.label","Cheque / Card / Bank A/c / Others No."},
		//Added V181005-Gayathri/MMS-DM-SCF-0243.1
		{"eBL.Public.label","Public"},
	
		{"eBL.AVERAGE_COST.label","Average Cost"},
		{"eBL.COMPUTED_VALUE.label","Computed Value"},
		{"eBL.Basis.label","Basis"},
		// Added for LDOH-CRF-0059  BY Krupa ON 25/05/2018
		{"eBL.billfromdate.label", "Bill From Date"},
		{"eBL.billtodate.label" , "Bill To Date"},
		{"eBL.ClaimedAmount.label", "Claimed Amount"},
		{"eBL.SchemeAuthNumber.label", "Scheme Aurthorization Number"},
		{"eBL.Membersuname.label", "Membership Surname"},
		{"eBL.MemberInitial.label", "Membership Initial"},
		//Added V180727-Gayathri/MMS_DM-CRF-0126
		{"eBL.PreAppDurCap.label","Pre Approval Duration Capping"},
		//Added V20072018-Subha/ML-MMOH-CRF-1173/Starts
		{"eBL.ReprintDateFrom.label", "Reprint Date From"},
		{"eBL.ReprintDateTo.label", "Reprint Date To"},
		{"eBL.DocTypeFrom.label", "Doc Type/No From"},
		{"eBL.DocTypeTo.label", "Doc Type/No To"},
		//Added V20072018-Subha/ML-MMOH-CRF-1173/Ends
		{"eBL.CoverReferencePrice.label","Cover Reference Price"},//Added V181003-Aravindh/AAKH-CRF-0107/
		{"eBL.CoverRefPrice.label","Cover Ref. price"},//Added V181003-Aravindh/AAKH-CRF-0107/
		//Added V20181003-Subha/AAKH-CRF-0103/Starts
		{"eBL.InclLabRadiologyStatus.label", "Include Lab/Radiology Status in"},
		{"eBL.Resulted.label", "Resulted"},
		{"eBL.JobSubmittedUser.label", "Job Submitted User"},
		{"eBL.JobSubmittedDate.label", "Job Submitted Date"},
		{"eBL.JobSubmittedDateTime.label", "Job Submitted Date/Time"},
		//Added V20181003-Subha/AAKH-CRF-0103/Ends
		//Added V190118-Gayathri/GHL-CRF-0532
		{"eBL.EMPLOYER.label", "Employers Name"},
		{"eBL.CHRG_DUR_REW.label", "Chargeable at Renewal"},  //Added V190305-Gayathri/AMRI-CRF-0357.1
		{"eBL.UHID_RENEW_CHARGE_DTLS.label","UHID Renew Service Charge Details"}, //Added V190305-Gayathri/AMRI-CRF-0357.1
		{"eBL.PractoRcptDateFrom.label","Practo Receipt Date From"},//Added V190128-Aravindh/KDAH-CRF-0513/
		{"eBL.PractoRcptDateTo.label","Practo Receipt Date To"},//Added V190128-Aravindh/KDAH-CRF-0513/
		{"eBL.ReceiptsStatus.label","Receipts Status"},//Added V190128-Aravindh/KDAH-CRF-0513/
		{"eBL.Generated.label","Generated"},//Added V190128-Aravindh/KDAH-CRF-0513/
		{"eBL.InError.label","In Error"},//Added V190128-Aravindh/KDAH-CRF-0513/
		{"eBL.VendorType.label","Vendor Type"},//Added V190128-Aravindh/KDAH-CRF-0513/
		{"eBL.PRACTO.label","Practo"},//Added V190128-Aravindh/KDAH-CRF-0513/
		{"eBL.MASPACK.label","Master Package"},//Added V190325 Gayathri/KDAH-CRF-0503
		{"eBL.Preacrossenc.label","Across Encounters"},//Added V190326-Dhananjay/MMS-DM-CRF-0158 
		{"eBL.DailyLimit.label","Daily Limit"},//Added V190320-Aravindh/MMS-DM-CRF-0129/
		{"eBL.DailyLimitPerDay.label","Daily limit per day"}, //Added V190320-Aravindh/MMS-DM-CRF-0129/
		//Added V190405-MuthuKN/AMRI-CRF-0357.1/Start
		{"eBL.RenewalDescription.label","Service Renewal Description"},
		{"eBL.REN_SERV_PANEL_CODE.label","Renewal Service/Panel Code"},
		{"eBL.REN_SERV_PANEL_DESC.label","Renewal Service/Panel Description"},
		//Added V190405-MuthuKN/AMRI-CRF-0357.1/End
		{"eBL.CREDIT_PATIENT.label","Credit Patient"},//Added V190509-Aravindh/GHL-CRF-0553
		{"eBL.SPONSORED_PATIENT.label","Sponsored Patient"},//Added V190509-Aravindh/GHL-CRF-0553
		{"eBL.MULTIPKGDISC.label","Multi Package Discount"},//Added V190325 Gayathri/MMS-DM-CRF-0130
		{"eBL.ALLOW.label","Allow"},//Added V190325 Gayathri/MMS-DM-CRF-0130
		{"eBL.PKGORCUSTDISC.label","Package/Customer Discount"},//Added V190325 Gayathri/MMS-DM-CRF-0130
		{"eBL.PKGADHOCDISC.label","Package Adhoc Discount"},//Added V190325 Gayathri/MMS-DM-CRF-0130
		{"eBL.HIGHCOSTPKG.label","Only High Cost Package"},//Added V190325 Gayathri/MMS-DM-CRF-0130
		{"eBL.LOWCOSTPKG.label","Only Low Cost Package"},//Added V190325 Gayathri/MMS-DM-CRF-0130
		{"eBL.ALLEXCHIGHCOST.label","All Packages Except High Cost"},//Added V190325 Gayathri/MMS-DM-CRF-0130
		{"eBL.UNAPPROVED.label","Unapproved"},//Added V190531-Aravindh/NMC-JD-CRF-0010
		{"eBL.PkgServiceLimitBy.label","Package Service Limit By"},//Added V190617-Aravindh/MMS-DM-CRF-0129.1
		{"eBL.DailyPkgLimit.label","Daily Package Limit"},//Added V190617-Aravindh/MMS-DM-CRF-0129.1
		{"eBL.PIPDLimit.label","PIPD Limit (Per Item Per Day)"},//Added V190617-Aravindh/MMS-DM-CRF-0129.1
		{"eBL.PkgServicesDailyLmt.label","Package Services Daily Limit"},//Added V190617-Aravindh/MMS-DM-CRF-0129.1
		{"eBL.PIPD.label","PIPD"},//Added V190617-Aravindh/MMS-DM-CRF-0129.1
		{"eBL.ClaimsAgrmtExts.label","Claims Agreement Exists"},//Added V190522 MuthuN/NMC-JD-CRF-0002-1.1
		{"eBL.PATIENT_BED_CATEGORY.label","Patient Bed Category"},//Added V190801 Gayathri/GHL-CRF-0523
		//Added V190820-MuthuN/NMC-JD-SCF-0015
		{"eBL.Vat_Charges.label","VAT Charges"},
		{"eBL.VIEW_VAT_CHARGE_DTL.label","View VAT Charge Details"},
		{"eBL.VAT_SERV_CHAGE_DTLS.label","VAT Service Charge Details"},//Added V190820-MuthuN/NMC-JD-SCF-0015
		{"eBL.GET_CC_STATUS.label","Get Payment Status"},// Added by Sethu for KDAH-CRF-0504.4
		//Added V191030-Aravindh/GHL-CRF-0550
		{"eBL.UploadDocuments.label","Upload Documents"},
		{"eBL.AuthorizationLetter.label","Authorization Letter"},
		{"eBL.PanCard.label","PAN Card"},
		{"eBL.Passport.label","Passport"},
		{"eBL.CreditAuthNoDate.label","Credit Auth No. / Date"},
		{"eBL.CreditAuthNo.label","Credit Auth No"},
		{"eBL.ViewDocument.label","View Document"},
		{"eBL.ErrorDecs.label","Select Document Type"},
		{"eBL.UploadImages.label","Upload Images"},
		{"eBL.ViewDocuments.label","View Documents"},
		{"eBL.Show_Image.label","Show Image"},
		{"eBL.View_Image.label","View Image"},
		{"eBL.Show_Documents.label","Show Documents"},
		{"eBL.docTypeManditory.label","Document Type is Mandatory"},
		{"eBL.imageOrPdf.label","Image/pdf is Mandatory"},
		{"eBL.ModifiedDateRange.label","Modified Date Range"},
		//Added V191030-Aravindh/GHL-CRF-0550
		
		//Added By Shikha For GHL-CRF-0520.1
		{"eBL.BillingGroupBasePrice.label","Billing Group Base Price"},
		{"eBL.BillingGroupRateBasedServices.label","Billing Group Rate Based Services"},
		{"eBL.BillingGroupChargeBasedServices.label","Billing Group Charge Based Services"},
		//Ended By Shikha For GHL-CRF-0520.1
		
		//Added against V200612-MuthuN/MMS-QH-CRF-0128.1-US001 & US004
		{"eBL.ApplyCustPkgDiscNew.label","Apply customer package discount - New packages"},
		{"eBL.ApplyCustDistPolicy.label","Apply customer discount by policy"},
		{"eBL.Query_Criteria.label","Query Criteria"},
		{"eBL.ActivePackDiscount.label","Active Package Discount"},		
		//Added against V200612-MuthuN/MMS-QH-CRF-0128.1-US001 & US004
		{"eBL.grouppolicy.label","Group Purchaser Policy"},// Added against NMC-JD-CRF-0045
		{"eBL.PkgLmtInd.label","Package Limit Indicator"},//added MMS-QH-CRF-0170-US-5
		{"eBL.GroupService.label","Group / Service"},//added MMS-QH-CRF-0170-US-4
		{"eBL.PkgLmtIndLevel.label","Group/Service Level"},//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020		
		//Added By Ram kumar S For NMC-JD-CRF-0042 on 05-Aug-2020
		{"eBL.Record_Approval.label","Record Approval"},
		{"eBL.Request_Status.label","Request Status"},
		{"eBL.Time_Limit.label","Time Limit"},
		{"eBL.Color_Indicaotr.label","Color Indicator"},
		{"eBL.HH_MM.label","HH:MM"},
		//Ended By Ram kumar S For NMC-JD-CRF-0042	
		{"eBL.DISC_PERC.label","Discount %age"},	//Added By Ram kumar S For NMC-JD-CRF-0066 on 08-Oct-2020
		{"eBL.GosiPolicy.label","Gosi Policy"},//Added V200928-Mohana Priya K/NMC-JD-CRF-0059
		{"eBL.Facility.label","Facility"}, //Added V200928-Mohana Priya K/NMC-JD-CRF-0059
		//Added V201021-Mohana Priya K/MOHE-CRF-0050.2/starts
		{"eBL.Invoices_month_yr.label","Invoices Month/Year"}, //Added by Nandhini for MOHE-CRF-0055
		{"eBL.frmbilldate.label","From Bill Date"},
		{"eBL.tobilldate.label","To Bill Date"},
		{"eBL.user.label","User"},
		//Added V201021-Mohana Priya K/MOHE-CRF-0050.2/ends
		{"eBL.OperaterID.label","Operater ID"}, //Added V201012-Palani Narayanan/MOHE-CRF-0050.2
		{"eBL.UserIds.label","UserIDs"},//Added V201012-Palani Narayanan/MOHE-CRF-0050.2
		{"eBL.CASH_COUNTER_LOGIN_DATE_TIME.label","Cash Counter Log in Date & Time"},//Added V201012-Palani Narayanan/MOHE-CRF-0050.2		
		//Added V201028-Gomathi Sivakumar/MOHE-CRF-0050.2 Starts
		{"eBL.BillingType.label","Billing Type"}, 
		{"eBL.PostedBillsOnly.label","Posted Bills Only"},
		{ "eBL.DAYCARE.label", "Daycare" },
		//Added V201028-Gomathi Sivakumar/MOHE-CRF-0050.2 Ends
		//V201102 Starts
		{"eBL.PharmacyMedical.label","Pharmacy / Medical Items"},
		{"eBL.AutoDistPkgVarServOP.label","Auto Distribute Package Variance to Services - OP"},
		{"eBL.AutoDistPkgVarServIP.label","Auto Distribute Package Variance to Services - IP"},
		//V201102 Starts
		//V201103 /starts
		{"eBL.FrmBillingGrp.label","From Billing Group"},
		{"eBL.ToBillingGrp.label","To Billing Group"},
		{"eBL.FrmPatno.label","From Patient No"},
		{"eBL.ToPatno.label","To Patient No"},
		{"eBL.FrmCustCode.label","From Customer Code"},
		{"eBL.ToCustCode.label","To Customer Code"},
		{"eBL.NOTE.label","NOTE: While Cancelling Cash Bill,System Cancels Payer Bills,if this is associated (Vice Versa)"}, 
		{"eBL.inc_cur_IP/DC_Pat.label","Include Current Inpatients/Daycare Patients"},
		{"eBL.Inc_Zero_Rcrds.label","Include Zero Records"},
		// V201103/ends
		//V201109 start
		{"eBL.CancelledDocsOnly.label","Cancelled Docs only"},
		{"eBL.ReceiptsRefundsBoth.label","Receipts/Refunds/Both"},
		{"eBL.frmReportdate.label","From Report Date"},
		{"eBL.toReportdate.label","To Report Date"},
		//V201109 end
		{"eBL.Zero_bill_Also.label","Zero Bill Also"},//V201117
		//V201111 Starts
		{"eBL.frmBillingClass.label","From Billing Class"},
		{"eBL.toBillingClass.label","To Billing Class"},
		{"eBL.frmBillingServ.label","From Billing Service"},
		{"eBL.toBillingServ.label","To Billing Service"},
		{"eBL.frmEffDate.label","From Effective Date"},
		{"eBL.toEffDate.label","To Effective Date"},
		{"eBL.frmCreateAmendBy.label","From Created / Amended By"},
		{"eBL.toCreateAmendBy.label","To Created / Amended By"},
		{"eBL.frmCreateAmendDate.label","From Created / Amended Date"},
		{"eBL.toCreateAmendDate.label","To Created / Amended Date"},
		//V201111 Ends
		//V201012 starts
		{"eBL.ItemType.label","Item Type"}, 
		{"eBL.Drugs.label","Drugs"},
		{"eBL.Consumables.label","Consumables"}, 
		{"eBL.Status.label","Status"}, 
		{"eBL.TradeNameorBatch.label","By TradeName/Batch"}, 
		{"eBL.FromItemCode.label","From Item Code"}, 
		{"eBL.ToItemCode.label","To Item Code"}, //changed 23/12/2020-Palani Narayanan/MOHE-CRF-0050.3
		{"eBL.ItemName.label","ItemName"}, 
		{"eBL.ItemCodeTitle.label","ItemCode"}, 
		{"eBL.CreatedAmendedName.label","NAME"},
		{"eBL.CreatedAmendedCode.label","CODE"},
		{"eBL.Users.label","Users"},
		//V201012 starts
		//V201118 
		{"eBL.report_list.label","Report List"},
		{"eBL.posted.label","Posted"},
		{"eBL.unposted.label","Un Posted"},
		{"eBL.posted_mth/Yr_frm.label","Posted Month/Year From"},
		{"eBL.posted_mth/Yr_To.label","Posted Month/Year To"},
		{"eBL.stat_date_frm.label","Statement Date From"},
		{"eBL.stat_date_To.label","Statement Date To"},
		{"eBL.Visit_period_frm.label","Visit Period From"},
		{"eBL.Visit_period_To.label","Visit Period To"},
		{"eBL.disc_period_frm.label","Discharge Period From"},
		{"eBL.disc_period_To.label","Discharge Period To"},
		//V201118
		//Added V201012-Palani Narayanan/MOHE-CRF-0100.1-US-2
		{"eBL.BilledDate.label","Billed Date"}, //Added V201012-Palani Narayanan/MOHE-CRF-0100.1 	US-2 //changed on 17-01-21
		{"eBL.PreviousInterimBillDocNo.label","Previous Interim Bill Doc No"}, //Added V201012-Palani Narayanan/MOHE-CRF-0100.1 	US-2
		{"eBL.UnBilledAmount.Label","Unbilled Amount"}, //Added V201012-Palani Narayanan/MOHE-CRF-0100.1 	US-2 // changed on 17-01-21
		{"eBL.SelectAll.Label","Select All"}, //Added V201012-Palani Narayanan/MOHE-CRF-0100.1 	US-2
		{"eBL.Reason.Label","Reason"}, //Added V201012-Palani Narayanan/MOHE-CRF-0100.1 	US-2
		{"eBL.ReasonCode.Label","Code"},
		//Added V201012-Palani Narayanan/MOHE-CRF-0100.1-US-2
		//V210113 start
		{"eBL.MembershipID.Label","Membership ID"},
		{"eBL.CouponCode.Label","Coupon Code"},
		{"eBL.CouponCodes.Label","Coupon Codes"},
		{"eBL.Find.Label","Find"},
		//V210113 end
		{"eBL.PkgDepositSubscription.Label","Package Deposit during Subscription"},
		//Added Against MOHE-CRF-0039 Starts
		{"eBL.Special_Clinic.label","Special Clinic"}, 
		{"eBL.Exempted_Amount.label","Exempted Amount"}, 
		{"eBL.RePrint_Bill.label","Reprint Bill"},
		{"eBL.Reprint_Bill_Item_Wise.label","Reprint Bill-Item Wise"}, 
		{"eBL.Reprint_Bill_Date_Wise.label","Reprint Bill-Date Wise"}, 
		{"eBL.Include_Zero_Bill.label","Include Zero Bill"},
		//Added Against MOHE-CRF-0039 Ends
		//Added V210111 -Mohana Priya K/MOHE-CRF-0050 STARTS
		{"eBL.Dailydayclrpt.label","Generate Day Collection Report"},
		{"eBL.setupsplgrp.label","Setup Special Group"},
		{"eBL.reportdate.label","Report Date"},
		{"eBL.detail.label","Detail"},
		{"eBL.Reportingservgrp.label","Reporting Service Groupings"},
		{"eBL.Assocservrptservgrp.label","Associate Services to Reporting Service Group"},
		{"eBL.createReportingservgrp.label","Create Services by Reporting Service Group"},
		{"eBL.MaintReportingservgrp.label","Maintain Services by Reporting Service Group"},
		{"eBL.ServiceType.label","Service Type"},
		{"eBL.Breakdelform.label","Break On Delivery Form"},
		{"eBL.UsedForUndefItms.label","Used For Undefined Items"},
		{"eBL.UsedForExemptItms.label","Used For Exempted Items"},
    	{"eBL.MaterialItems.label","Material Items"},
		//Added V210111 -Mohana Priya K/MOHE-CRF-0050 ENDS
		//V210112 Starts
		{"eBL.NursingUnit.label","Nursing Unit"},
		{"eBL.AdmissionNo.label","Admission No"},
		{"eBL.ReportPrintOption.label","Report Print Option"},
		{"eBL.Language.label","Language"},
		{"eBL.PatientDetails.label","Patient Details"},
		{"eBL.AdmissionDate.label","Admission Date"},
		{"eBL.Room.label","Room"},
		{"eBL.UnadjustedAmt.label","UnAdjusted Amt"},
		{"eBL.DischargeAdvice.label","Discharge Advice Y/N"},
		//added against mohe-crf-0038.4
		{"eBL.Bill_slmt_amt.label","Bill slmt. Amt"},
		{"eBL.Print_Bill.label","Print Bill"},
		//V210112 Ends
		//Added V210211-Palani Narayanan/MMS-CRF-100.1-US-2
		{"eBL. AfterBillApproval.label","Return of Ph items ( After bill approval and posting) will not be displayed in approval Bill New function for further claims"},
		{"eBL.EClaim.label","E-Claim"}, //added against MOHE-CRF-0055.1 V210517
		{"eBL.Encounterdatefrom.label","Encounter Date From"}, //added against MOHE-CRF-0055.1 V210517
		{"eBL.Encounterdateto.label","Encounter Date To"},//added against MOHE-CRF-0055.1 V210517
		{"eBL.Arabic.Label","Arabic"}, 	//Added against V210517
		//V210419 starts
		{"eBL.practitionerspeciality.label","Practitioner Speciality"},
		{"eBL.practitionername.label","Practitioner Name"},
		{"eBL.practitionerid.label","Practitioner Id"},//V210419 ends
		{"eBL.Retainpackageprice.label","Retain Package Price"},//added against MMS-DM-CRF-118.9 starts
		{"eBL.Revisepackageprice.label","Revise Package Price"},
		{"eBL.Retainvat.label","Retain VAT"},
		{"eBL.Revisevat.label","Revise VAT"},
		{"eBL.VAT.label","VAT"},//added against MMS-DM-CRF-118.9 ends
		{"eBL.Fetchdataby.label","Fetch Data By"}, //V210615
		{"eBL.ListOfRemarks.label","List_Of_Remarks"},
		{"eBL.modify.label","Modify"}, //V210727
		{"eBL.copypolicy.label","Copy Policy"}, //V210727
		{"eBL.Gross/Net.label","Gross / Net"}, //V210727
		{"eBL.DeleteRecord.label","Delete Record"}, //V210727
		{"eBL.PrimRecNo.label","Primary Resi No"},//V210727
		{"eBL.Items.label","Items"},//V210802
		{"eBL.Availablepatdeposit.label","Avail Pat Dep"}, //added against MOHE-scf-0136
		{"eBL.Availablepatprepay.label","Avail Pat Prepay"},
		{"eBL.PrepayAmount.label","Prepay Amount"},
		{"eBL.InpatientBillType.label","Inpatient Bill type"},
		{"eBL.PendingInterimBill.label","Pending Interim Bill"},
		{"eBL.PendingDischargeBill.label","Pending Discharge Bill"},
		{"eBL.PendingUnderchargeBill.label","Pending Undercharge Bill"},
		{"eBL.BillGenOption.label","Bill Gen Option"},
		{"eBL.ExpectedDischargeDate.label","Expected Discharge Date"},
		{"eBL.LastBedChargeDate.label","Last Bed Charge Date"},
		{"eBL.UnderChargePatient.label","Under Charge Patient"},
		{"eBL.UnderChargeOnly.label","Under Charge Only"},
		{"eBL.FilterBy.label","Filter By"},
		{"eBL.Processed.label","Processed"},
		{"eBL.UnProcessed.label","Un Processed"},
		{"eBL.UnConfirmed.label","Un Confirmed"},
		{"eBL.Adjust.label","Adjust"},	
		{"eBL.Service/Package.label","Service / Package"},
		{"eBL.GenerateBillCumReceipt.label","Generate Bill Cum Receipt"},
		{"eBL.OtherUnbilledOutstanding.label","Other Unbilled Outstanding"},
		{"eBL.UnConfirmedServices.label","Unconfirmed Services"},
		{"eBL.EncounterBillingDetails.label","Encounter Billing Details"},
		{"eBL.draft.label","Draft"},
		{"eBL.checkOut.label","Checkout Date/Time"},
		{"eBL.Visit.label","Visit Date/Time"},
		{"eBL.Discharge.label","Discharge Date"},
		{"eBL.Admission.label","Admission Date/Time"},
			//Added by Sethu for MOHE-CRF-0076 ON 26/08/2021 
		{"eBL.PAYSKY_PAY.label","PaySky"},
		{"eBL.PAYSKY_TXN_NO.label","Transaction ID"},
		{"eBL.payer_ref_code.label","Payer reference code"}, //V211027
		{"eBL.cust_code.label","Cust Code"},
		{"eBL.policy_code.label","Policy Code"},
		{"eBL.cust_description.label","Price/Cust Description"},
		{"eBL.IP_amt.label","IP(%/Amt)"},
		{"eBL.OP_amt.label","OP(%/Amt)"},
		{"eBL.EM_amt.label","EM(%/Amt)"},
		{"eBL.EX_amt.label","EX(%/Amt)"},
		{"eBL.DC_amt.label","DC(%/Amt)"},
		{"eBL.Disc.label","Disc"},
		
		{"eBL.PKG_EXCL.label","Package Exclusions"},
		//V220525
		{"eBL.RestrctOPserv.label","Restrict cancellation of OP/AE/EX indirect service"},
		{"eBL.RestrctIPserv.label","Restrict cancellation of IP/DC indirect service"},
		//V220525
		{"eBL.MCNno.label","MCN Number"},//V220905
		{"eBL.AutoFillMCNno.label","Auto Fill - MCN#"},//V220905
	    {"eBL.Agreement.label","Agreement Items"}, //V221113
		{"eBL.Generic.label","Generic Items"}, //V221113		
	    {"eBL.BrandWithoutAlternate.label","Brand Items(Without alternate)"}, //V221113
	    {"eBL.BrandWithAlternate.label","Brand Items(With alternate)"}, //V221113
		{"eBL.MultiFactorDeductibleRule.label","Multi Factor Deductible Rule"},	//V221020
		{"eBL.queuePKID.label","Queue PKID"},//V221023
		{"eBL.CancelCC.label","Cancel coder Clearance"},//Added by Kamatchi S for TH-KW-CRF-0143
		{"eBL.GenerateCC.label","Generate coder Clearance"}, //Added by Kamatchi S for TH-KW-CRF-0143
		{"eBL.ReceiptDocType.label","Receipt Doc Type"}, //V221108
		{"eBL.ReceiptDocNum.label","Receipt Doc Num"}, //V221108
		{"eBL.INS_APPRVD_DRUGS.label","Insurance Approved Drugs"}, //V221113
		{"eBL.DiagnosisCategory.label","Diagnosis Category"}, //V221128
		{"eBL.MFDRCategory.label","MFDR Category"},
		{"eBL.Chronic.label","Chronic"},
		{"eBL.Non-Chronic.label","Non-Chronic"},
		{"eBL.MFDRCategory.label","MFDR Category"},
		{"eBL.Maternity.label","Maternity"},		
		{"eBL.GEN_DISC_CLEARANCE.label","Generate Discharge Clearance"},
		{"eBL.REP_CAN_DISC_CLEARANCE.label","Re-Print/Cancel Discharge Clearance"},
		{"eBL.REP_DISC_CLEARANCE.label","Re-Print Discharge Clearance"},
		{"eBL.CAN_DISC_CLEARANCE.label","Cancel Discharge Clearance"},
		{"eBL.DISCR_ADV_DATE.label","Discharge Advice Date"},
		{"eBL.DISCR_BILL_DOC.label","Discharge Bill Document"},
		{"eBL.PAT_OS_AMT.label","Patient Outstanding Amount"},
		{"eBL.PolicyTypeDescription.label","Policy Type Description"},
		{"eBL.DeductibleCategory.label","Deductible Category"},
		{"eBL.cancelInsClear.label","Cancel Insurance Clearance"},//V221129/TH-KW-CRF-0084.1
		{"eBL.genInsClear.label","Generate Insurance Clearance"},//V221129/TH-KW-CRF-0084.1	
		{"eBL.InsuranceTeam.label","Insurance Team"},//Added by Kamatchi S for TH-KW-CRF-0084
		{"eBL.FrontOffTeam.label","Front Office Team"},//Added by Kamatchi S for TH-KW-CRF-0084
		{"eBL.ClickDetails.label","Click for more details"},//Added by Kamatchi S for TH-KW-CRF-0084
		{"eBL.PendCoder.label","Pending Coder Clearance"},//Added by Kamatchi S for TH-KW-CRF-0084
		{"eBL.PendIns.label","Pending Insurance Clearance"},//Added by Kamatchi S for TH-KW-CRF-0084
		{"eBL.PendDiscBill.label","Pending Discharge Bill"},//Added by Kamatchi S for TH-KW-CRF-0084
		{"eBL.PendDiscClear.label","Pending for Discharge Clearance"},//Added by Kamatchi S for TH-KW-CRF-0084
		{"eBL.PatDiscAdv.label","Patient with Discharge Advice"},//Added by Kamatchi S for TH-KW-CRF-0084
		{"eBL.ApprStatusPayer.label","Approval Status by Payer"},//Added by Kamatchi S for TH-KW-CRF-0084
		{"eBL.RecApprView.label","Record Approval User View"},//Added by Kamatchi S for TH-KW-CRF-0084
		{"eBL.FrontOffView.label","Front Office User View"},//Added by Kamatchi S for TH-KW-CRF-0084
		{"eBL.OrgBillRefNo.label","Original Bill Reference Number"},//V221230
		{"eBL.WithDischargeBill.label","With Discharge Bill"}, //V221227
		{"eBL.WithoutDischargeBill.label","Without Discharge Bill"},//V221227
		{"eBL.DischargeBillDocType.label","Discharge Bill Doc Type"},//V221227
		{"eBL.DischAdvFromDate.label","Discharge Advice Date From"},//V221227
		{"eBL.DischAdvToDate.label","Discharge Advice Date To"},//V221227
		{"eBL.DischClearFromDate.label","Discharge Clearance Date From"},//V221227
		{"eBL.DischClearToDate.label","Discharge Clearance Date To"},//V221227
		{"eBL.AuthForDischClearWithoutBill.label","Authorization for Discharge Clearance without Bill"}, //V221227
		{"eBL.AuthForDischClearWithOutsBill.label","Authorization for Discharge Clearance with Outst Bill"}, //V221227
		{"eBL.AuthToCancelDischClear.label","Authorization To Cancel Discharge Clearance"}, //V221227
		{"eBL.ReprintDischClearBill.label","Reprint IP Discharge Clearance and Bill"}, //V221227
		{"eBL.AuthBy.label","Authorized By"}, //V221227
		{"eBL.Bill.label","Bill"}, //V221227
		{"eBL.PatOutsAmt.label","Pat Outstanding Amount"}, //V221227
		{"eBL.DischClearDate.label","Discharge Clearance Date"}, //V221227
		{"eBL.DischClear.label","Disch. Clearance Doc Type"}, //V221227
		{"eBL.DocTypeNumber.label","Document Type Number"}, //V221227
		{"eBL.exit.label","Exit"}, //V221227
		{"eBL.DischargeClear.label","Discharge Clearance"}, //V221227		
		{"eBL.AuthForDischClearWithBill.label","Authorization for Discharge Clearance with Bill"}, //V221227
		{"eBL.Services&Items.label","Services and Items"},//V230106
		{"eBL.ServicesName.label","Service Name"},
		{"eBL.ServiceQnty.label","Service Quantity"},
		{"eBL.ApprovedAmt.label","Approved Amt"},		
		{"eBL.DOC_GEN_FROM.label","Doc Generated From"},
		{"eBL.DOC_GEN_TO.label","Doc Generated To"},
		{"eBL.RCM_IN_ERROR.label","In Error"},
		{"eBL.RCM_DOC_GEN_REVIEW.label","Doc Generated/To be Reviewed"},
		{"eBL.RCM_REV_APPRV.label","Review & Approve"},
		{"eBL.RCM_GEN_CLAIM.label","Generate Claim"},
		{"eBL.RCM_SUB_TO_INS.label","Submit to Insurance"},
		{"eBL.RCM_INS_FEEDBACK.label","Insurance Feedback"},
		{"eBL.RCM_PROCESS_CLAIM.label","Process Claim"},
		{"eBL.CLAIM_STATUS.label","Claim Status"},
		{"eBL.CLAIM_NUMBER.label","Claim Number"},
		{"eBL.INS_STATUS.label","Insurance Status"},
		{"eBL.INCL_PAST_RECS.label","Include Past Records"},
		{"eBL.ConsentFormOption.label","Consent Form Option"},//V230125
		{"eBL.Browsebtn.label","Browse"},
		{"eBL.RelativeDetails.label","Relative Details"},//V230125
		{"eBL.BrowseClaimDoc.label","Browse Claim Document"},   //V230119
		{"eBL.eSign.label","e-Sign"},//V230125
		{"eBL.view_print_save.label","View/Print/Save"},//V230125
		{"eBL.Patient.label","Patient"},//V230125		
		{"eBL.Relative.label","Relative"},//V230125
		{"eBL.ConsentAmount.label","Consent Amount"},//V230125
		{"eBL.ConsentDate.label","Consent Date"},//V230125		
		{"eBL.ESignature.label","e-signature"},//V230125
		{"eBL.CivilId.label","CIVIL ID"},//V230125	
		{"eBL.telnum.label","Telephone number"},//V230125
		{"eBL.exit.label","Exit"}, //V221227
		{"eBL.CIVIL_ID.label","Civil ID"},
		{"eBL.VISIT_ADMN_DATE.label","Visit/Admission Date"},
		{"eBL.CHKOUT_DISCH_DATE.label","Checkout/Discharge Date"},
		{"eBL.NET_BILL_AMT.label","Net Bill Amount"},
		{"eBL.STATUS_DATE.label","Status Date"},
		{"eBL.BrowseClaimDoc.label","Browse Claim Document"},   //V230119
		{"eBL.PAT_SHARE.label","Patient Share"},
		{"eBL.CLAIM_AMT.label","Claim Amount"},	
		{"eBL.INVOICE_AMT.label","Invoice Amount"},
		{"eBL.ServicesandItem.label","Services and Items"}, //V230210
		{"eBL.Servicedtls.label","Service Details"}, //V230210
		{"eBL.NonReferral.label","Non Referral"}, //V230210
		{"eBL.ServicesandItemsClinicCategory.label","Services and Items - Clinic Category"}, //V230210
		{"eBL.Clinic_Proc_unit.label","Clinic/Procedure unit"},//V230210	

		
		//Added by Monika for AAKH-0152
		{"eBL.INS_Status.label","Insurance Status"},
		{"eBL.Order_status.label","Order Status"},
		{"eBL.Coding_Status.label","Coding Status"},
		{"eBL.Pending.label","Pending"},
		{"eBL.Approval.label","Approval"},
		{"eBL.Send_To_Ins.label","Sent to Insurance"},
		{"eBL.Clarification.label","Clarification"},
		{"eBL.Doctor_Query.label","Doctor Query"},
		{"eBL.Supervisor_Query.label","Supervisor Query"},
		{"eBL.Supervisor_Clearance_completed.label","Supervisor Clearance completed"},
		{"eBL.Signed_Date.label","Signed Date"},
		{"eBL.Fut_Ord_Li_Da_Ti.label","Future Order Linked Date & Time"},
		{"eBL.Coder_Name.label","Coder Name"},
		{"eBL.Approval_inf_to_Patient.label","Approval Informed To Patient"},
		{"eBL.Approval_inf_By.label","Approval Informed By"},
		{"eBL.Approval_EXPIRY_DATE.label","Approval Expiry Date"},
		{"eBL.Service_Performed_Date.label","Service Performed Date"},
		{"eBL.Service_Status.label","Service Status"},
		{"eBL.VISIT_ADMN_DATE_TIME.label","Visit/Admission Date & Time"},
		{"eBL.APPT_DATE_TIME.label","Appointment Date & Time"},		
		//Added by Monika for NMC-JD-CRF-0199
		{"eBL.TID_NO.label","TID NO"},		
		{"eBL.ListOfReasons.label","List_Of_Reasons"},   //V230707
		{"eBL.Reasons.label","Reasons"},  //V230707
		//Added by MOHANA for NMC-JD-CRF-0102.2
		{"eBL.PreAuth.label","Pre-Authorization"},
		{"eBL.ApprStatusPayerEncLvl.label","Approval Status by Payer at Encounter Level"},
		{"eBL.dep_bal_amt.label","Deposit Balance Amount"},//ML-MMOH-CRF-1614
		//Added by Monika for NMC-JD-CRF-0102.3
		{"eBL.approval_doc_ref_no.label" ,"Approval Doc Ref No"},
		{"eBL.claim_id.label","Claim ID"},
		{"eBL.claims.label","Claims"},
		{"eBL.services.label","Services"},
		{"eBL.claims_services_level.label","Claims/Services Level"},
		{"eBL.claims_by_payer_enc_level.label","Claims by Payer at Encounter Level"},
		{"eBL.INS_Status_By.label","Insurance Status By "},
		{"eBL.Approved_Amt.label","Approved Amt"}, //V231017
		{"eBL.Receipt_Doc_Reference_No.label","Receipt Doc Reference No"}, //V231017
		{"eBL.Approval_Amount.label","Approval Amount"}, //V231017
		{"eBL.approval_ref_no.label" ,"Approval Ref No"}, //V231017	
		{"eBL.Approval_ref_doc_type_code.label" ,"Approval Ref Doc Type Code"}, //V231017
		{"eBL.bedUpgraded.label" ,"Bed Upgraded"}, //V240209
		{"eBL.TotalAmount.label","Total Amount"},	//V240209
		//Added by Monika for NMC-JD-CRF-0102.17
		{"eBL.NationalID.Label","National ID"},
		{"eBL.IqamaID.Label","Iqama ID"},
		{"eBL.PolledData.Label","Polled Data"},
		{"eBL.APA_Status.Label","APA Status"},
        {"eBL.ApprovalNo.Label","Approval No"},
		{"eBL.APA.label","APA"},			//V240213 end
		
		
		{"eBL.PYMT_REF_ID.Label","Payment Reference ID"},
		{"eBL.PYMT_REF_ID_FRM_DATE.Label","Payment Reference ID Received From Date"},
		{"eBL.PYMT_REF_ID_TO_DATE.Label","Payment Reference ID Received To Date"},
		{"eBL.INS_ACK_PYMT.Label","Acknowledge Payment"},
		{"eBL.PreauthReqId.label" ,"Pre-auth Request ID"}, //102.15
		{"eBL.PreauthRespId.label" ,"Pre-auth Response ID"}, //102.15
		{"eBL.audit_trail.label","Audit trail"},  //V240229
		{"eBL.Offline_Eligibility_Check.label","Offline Eligibility Check"},  //V240301
		{"eBL.Offline_Eligibility_Date.label","Offline Eligibility Date"},  //V240301
		{"eBL.claim_response_id.label","Claim Response ID"},  //V240229
		{"eBL.claim_request_id.label","Claim Request ID"},  //V240229
		{"eBL.form60.label" ,"Forms 60"},
		{"eBL.altId.label" ,"Alt ID"},
		{"eBL.reEnter.label" ,"Re-enter"},	
		{"eBL.holderName.label" ,"HolderName"},//RBU-GHL-CRF-0022.1
		{"eBL.offline.label" ,"offline"},//102.25	
		{"eBL.BackdatedJobRun.label","Backdated Job Run"},
		{"eBL.MaxNumOfEncInc.label","Max number of Encounters included"},
		{"eBL.REP_SERVER_MAP_PATH.label","Report Server Mapped Path"},
		{"eBL.SharedFolderPath.label","Shared Folder Path"},
		{"eBL.TriggerJobFor.label","Trigger Job For"},
		{"eBL.GenOfSuppDocs.label","Generation of Supporting Documents"},
		{"eBL.MAX_BACKDATE_JOB_RUN.Label","(0 to 99 Days)"},
		{"eBL.MAX_ENC_LIMIT_INCL.Label","(1 to 9,999,999 Records)"},
		{"eBL.IPDisch.label","IP Discharge"},
		{"eBL.OPChkout.label","OP Check-out"},
		{"eBL.OPAutocls.label","OP Auto closure"},
		{"eBL.DCDisch.label","DC Discharge"},
		{"eBL.EMChkout.label","EM Check-out"},
		{"eBL.EMAutocls.label","EM Auto closure"},
		{"eBL.Document.label","Document"},
		{"eBL.Active.label","Active"},
		{"eBL.Sequence.label","Sequence"},
		{"eBL.EpisodeEncounterType.label","Episode/Encounter Type"},
		{"eBL.document.label","Document"},
		{"eBL.ServiceGroup.label","Service/group"},//MMS-DM-CRF-0247.4
		{"eBL.DailyAmountlimit.label","Daily Amount limit"},//
		{"eBL.DailyQtylimit.label","Daily Qty limit"},
		{"eBL.Item.label","Item"},//0247.1
		{"eBL.PackageGroupingDetails.label","Package Grouping Details"},
		{"eBL.Pending_Review_and_Approval.label","Pending Review & Approval"},   //V240417
		{"eBL.Pending_Submission.label","Pending Submission"},   //V240417
		{"eBL.Response_Level.label","Response level"},   //V240417
		{"eBL.Bill_Duration_From.label","Bill Duration From"},   //V240417
		{"eBL.Bill_Duration_To.label","Bill Duration To"},   //V240417
		{"eBL.Bill_Doc_Type_Code.label","Bill Doc Type Code"},   //V240417
		{"eBL.Bill_Doc_No.label","Bill Doc No"},   //V240417
		{"eBL.Payment_Reference.label","Payment Reference"}, //V231017
		{"eBL.Eligible_for_Resubmission.label","Eligible for Resubmission Only"}, //V240417
		{"eBL.Sno.label","S.NO"}, //0247.4
		{"eBL.CUSTOMER_DESC.label","Customer Desc."},
		{"eBL.POLICY_TYPE_DESC.label","Policy Type Description"},
		{"eBL.NON_INS_BILL_DTLS.label","Non Ins Billing Details"},
		{"eBL.CREDIT_DOC_DTLS.label","Credit Doc Details"},
		{"eBL.MOD_FIN_DTLS.label","Modify Financial Details"},
	    {"eBL.Discharged_Checked_out.label","Discharged/Checked out"}, //V240522
		{"eBL.Auto_Closed.label","Auto Closed"}, //V240522
		{"eBL.Encounter_Status.label","Encounter Status"}, //V240522
		{"eBL.Encounter_Type_ID.label","Encounter Type/ID"}, //V240522
		{"eBL.Visit_Type_Admit_Date.label","Visit Type/Admit Date"}, //V240522
		{"eBL.Checkout_Dis_Date.label","Checkout/Dis. Date"}, //V240522
		{"eBL.Orders_Completed.label","Orders Completed"}, //V240522
		{"eBL.Orders_Not_Completed.label","Orders Not Completed"}, //V240522
	
		{"eBL.MedicalItems.label","Medical Items"},  //V240722
		{"eBL.SaleDetailBy.label","Sale Detail by"},  //V240722
		{"eBL.ServiceItemDesc.label","Service/Item Description"},  //V240722
		{"eBL.ServiceItemCode.label","Service/Item Code"},  //V240722
		{"eBL.ServiceItemInd.label","Service/Item Indicator"},   //V240722
		{"eBL.PharmacyItem.label","Pharmacy Item"},   //V240722
			
		{"eBL.Reimbursable.label","Reimbursable"},   //V240722
		{"eBL.ReimbursableType.label","Reimbursement Type"},   //V240722
		
		{"eBL.PublicPrice.label","Public Price"},   //V240722
		{"eBL.ReimbursableAmt.label","Reimbursement Amount"},   //V240722
		
		
		{"eBL.ImportedItem.label","Imported Item"},   //V240722
		{"eBL.EssentialItem.label","Essential Item"},   //V240722
		{"eBL.offlineClaims.label","Offline Claims"},	//CRF 166.1	
		{"eBL.submissionType.label","Submission Type"}, //CRF 166.1
	    {"eBL.Select.label" ,"Select"},//RBU-GHL-CRF-0034
		{"eBL.ReportType.label" ,"Report Type"},//RBU-GHL-CRF-0034
		{"eBL.ServicePriceList.label" ,"Service Price List"},//RBU-GHL-CRF-0034
		{"eBL.DrugsPriceList.label" ,"Drugs Price List"},//RBU-GHL-CRF-0034
		{"eBL.ConsumablesPriceList.label" ,"Consumables Price List"},//RBU-GHL-CRF-0034
		{"eBL.PriceIndicator.label" ,"Price Indicator"},//RBU-GHL-CRF-0034
		{"eBL.Status.label" ,"Status"},//RBU-GHL-CRF-0034
		{"eBL.FacilityID.label" ,"Facility ID"},//RBU-GHL-CRF-0034
		{"eBL.GroupBy.label" ,"Group By"},//RBU-GHL-CRF-0034
		{"eBL.BillingServiceItemCode.label" ,"Billing Service / Item Code"},//RBU-GHL-CRF-0034
		{"eBL.EffectiveDate.label" ,"Effective Date"},//RBU-GHL-CRF-0034
		{"eBL.CreatedAmendedby.label" ,"Created / Amended by"},//RBU-GHL-CRF-0034
		{"eBL.CreatedAmendedDate.label" ,"Created / Amended Date"},//RBU-GHL-CRF-0034
		{"eBL.ServiceItemPriceList.label" ,"Service / Item Price List"},//RBU-GHL-CRF-0034
		
		{"eBL.gender.label" ,"Gender"},//RBU-GHL-CRF-0033
		{"eBL.days.label" ,"Days"},//RBU-GHL-CRF-0033
		{"eBL.month.label" ,"Months"},//RBU-GHL-CRF-0033
		{"eBL.age.label" ,"Age Years"},//RBU-GHL-CRF-0033
		{"eBL.section.label" ,"Section/Wing"},//RBU-GHL-CRF-0033
		{"eBL.VisitID.label" ,"Visit ID"},//RBU-GHL-CRF-0033
		{"eBL.InsuranceBillingManagement.label" ,"REVIEW AND TRANSFER CHARGES"},//RBU-GHL-CRF-0033
		{"eBL.Associate_Encounter.label" ,"Associate Encounter"}
		
	};
}

	