/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package eIP.advbedmgmt.transaction;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import eCommon.Common.CommonAdapter;
import eIP.advbedmgmt.GBMConstants;
import eIP.advbedmgmt.common.CommonConstants;
import eIP.advbedmgmt.common.CommonHelper;
import eIP.advbedmgmt.common.PatientStatusConstants;
import eIP.advbedmgmt.common.bedcolor.BedColorConstants;
import eIP.advbedmgmt.common.bedcolor.bc.BedColorBC;
import eIP.advbedmgmt.common.bedcolor.dao.BedColorDAO;
import eIP.advbedmgmt.common.bedcolor.dao.BedColorDAOImpl;
import eIP.advbedmgmt.common.bedcolor.request.BedColorRequest;
import eIP.advbedmgmt.common.bedcolor.response.BedColorResponse;
import eIP.advbedmgmt.common.model.BasicBed;
import eIP.advbedmgmt.common.model.BedColor;
import eIP.advbedmgmt.common.model.BedStatusEnum;
import eIP.advbedmgmt.transaction.floorlayout.FloorLayoutConstants;
import eIP.advbedmgmt.transaction.floorlayout.response.BedIconSection;

/**
 * This is a helper class for bed related functionalities This class will
 * contain only static methods to get relevant information
 * 
 * @author GRamamoorthy
 * 
 */
public class BedHelper {

	/**
	 * This method gets an instance of basicbed given
	 * the array of values obtained from back end
	 * The array will contain bed number, encounter id etc
	 * @param structAttributes
	 * @return
	 */
	public static BasicBed getBedInstance(Object[] structAttributes){
		BasicBed bedInst = new BasicBed();
		// no need to check the array - it is already valid
		String bedNumber = (String)structAttributes[CommonConstants.BED_STAT_BED_NUM_INDEX];
		bedInst.setBedNumber(bedNumber);
		BedStatusEnum bedStatus = getBedStatus(structAttributes);
		bedInst.setBedStatus(bedStatus);
		
		return bedInst;
	}
	
	
	/**
	 * This method forms the bed status enum given the different attributes
	 * 
	 * @param structAttributes
	 * @return
	 */
	public static BedStatusEnum getBedStatus(Object[] structAttributes) {
		BedStatusEnum statusEnum = BedStatusEnum.NOT_INITIALIZED;

		// first check the admission status
		// if it is having value "00" or "01" - then no need to evaluate
		Object encIdObj = structAttributes[CommonConstants.BED_STAT_ENC_ID_INDEX];
		String encounterId = encIdObj != null ? encIdObj.toString() : "";
		encounterId = CommonAdapter.checkForNull(encounterId);

		String admissionStatus = (String) structAttributes[CommonConstants.ADMISSION_STATUS_INDEX];
		admissionStatus = CommonAdapter.checkForNull(admissionStatus);

		String transferStatus = (String) structAttributes[CommonConstants.TRANSFER_STATUS_INDEX];
		transferStatus = CommonAdapter.checkForNull(transferStatus);

		String leaveAbscondStatus = (String) structAttributes[CommonConstants.LEAVE_STATUS_INDEX];
		leaveAbscondStatus = CommonAdapter.checkForNull(leaveAbscondStatus);

		String blockedStatus = (String) structAttributes[CommonConstants.BLOCKED_STATUS_INDEX];
		blockedStatus = CommonAdapter.checkForNull(blockedStatus);

		String blkOverrideStatus = (String) structAttributes[CommonConstants.BLOCKED_OVERRIDE_STATUS_INDEX];
		blkOverrideStatus = CommonAdapter.checkForNull(blkOverrideStatus);

		String bookedStatus = (String) structAttributes[CommonConstants.BOOK_STATUS_INDEX];
		bookedStatus = CommonAdapter.checkForNull(bookedStatus);

		String dischargeStatus = (String) structAttributes[CommonConstants.DISCHARGE_STATUS_INDEX];
		dischargeStatus = CommonAdapter.checkForNull(dischargeStatus);

		String infantStatus = (String) structAttributes[CommonConstants.INFANT_STATUS_INDEX];
		infantStatus = CommonAdapter.checkForNull(infantStatus);

		String vacantStatus = (String) structAttributes[CommonConstants.VACANT_STATUS_INDEX];
		vacantStatus = CommonAdapter.checkForNull(vacantStatus);

		if (PatientStatusConstants.TRANSFER_OUT_VALUE.equals(transferStatus)) {
			statusEnum = BedStatusEnum.TRANSFER_OUT;
		} else if (PatientStatusConstants.TRANFER_ACCEPTED_VALUE
				.equals(transferStatus)) {
			statusEnum = BedStatusEnum.TRANSFER_ACCEPTED;
		} else if (PatientStatusConstants.TRANFER_INITIATED_VALUE
				.equals(transferStatus)) {
			statusEnum = BedStatusEnum.TRANSFER_INIT;
		} else if (PatientStatusConstants.BLOCKED_OVERRIDE_STATUS_VALUE
				.equals(blkOverrideStatus)) {
			statusEnum = BedStatusEnum.BLOCKED_OVERRIDEABLE;
		} else if (PatientStatusConstants.BLOCKED_STATUS_VALUE
				.contains(blockedStatus)) {
			statusEnum = BedStatusEnum.BLOCKED;
		} else if (PatientStatusConstants.LEAVE_STATUS_VALUE
				.equals(leaveAbscondStatus)) {
			statusEnum = BedStatusEnum.LEAVE;
		} else if (PatientStatusConstants.ABSCOND_STATUS_VALUE
				.equals(leaveAbscondStatus)) {
			statusEnum = BedStatusEnum.ABSCOND;
		} else if (!bookedStatus.trim().equals("")) {
			statusEnum = BedStatusEnum.BOOKED;
		} else if (PatientStatusConstants.DISCHARGE_INITIATED_STATUS_VALUE
				.equals(dischargeStatus)) {
			statusEnum = BedStatusEnum.DISCHARGE_INITIATED;
		} else if (PatientStatusConstants.DISCHARGED_STATUS_VALUE
				.equals(dischargeStatus)) {
			statusEnum = BedStatusEnum.DISCHARGED;
		} else if (!encounterId.trim().equals("")
				&& !infantStatus.trim().equals("")) {
			statusEnum = BedStatusEnum.INFANT;
		} else if (encounterId.trim().equals("")
				&& vacantStatus.trim().equals("")) {
			statusEnum = BedStatusEnum.VACANT;
		} else {
			if (PatientStatusConstants.ADMITTED_STATUS_DEFAULT_VALUE
					.equals(admissionStatus)) {
				statusEnum = BedStatusEnum.ADMITTED;
			} else if (PatientStatusConstants.ADMISSION_INITIATED_STATUS_DEFAULT_VALUE
					.equals(admissionStatus)) {
				statusEnum = BedStatusEnum.ADMISSION_INITIATED;
			}
		}

		return statusEnum;
	}

	/**
	 * This method gets the bed status color given the bed status enum
	 * @param bedStatus
	 * @return
	 */
	public static String getBedStatusColor(BedStatusEnum bedStatus){
		String bedStatusColor = null;
		
		BedColorRequest request = new BedColorRequest();
		request.setBedStatus(bedStatus.toString());
		ApplicationContext context = new ClassPathXmlApplicationContext(GBMConstants.SPRING_BEANS_XML_NAME);
		BedColorBC bcInst = (BedColorBC)context.getBean(BedColorConstants.BED_COLOR_BC_NAME);
		BedColorResponse response = bcInst.getBedColor(request);
		/*BedColorDAO daoInst = new BedColorDAOImpl();
		BedColorResponse response = daoInst.getBedColor(request);*/
		
		if(response.isSuccessful()){
			List<BedColor> colorList = response.getColorList();
			// here the assumption is that required color
			// will be at the top of the list
			BedColor reqdColor = colorList.get(0);
			if(reqdColor != null){
				bedStatusColor = reqdColor.getColor();
			}
		}
		
		return bedStatusColor;
	}
	//Below Method Added By Dharma on 16th Mar 2016
	public static String getBedTxtColor(BedStatusEnum bedStatus){
		String bedTxtColor = null;
		
		BedColorRequest request = new BedColorRequest();
		request.setBedStatus(bedStatus.toString());
		ApplicationContext context = new ClassPathXmlApplicationContext(GBMConstants.SPRING_BEANS_XML_NAME);
		BedColorBC bcInst = (BedColorBC)context.getBean(BedColorConstants.BED_COLOR_BC_NAME);
		BedColorResponse response = bcInst.getBedColor(request);
		/*BedColorDAO daoInst = new BedColorDAOImpl();
		BedColorResponse response = daoInst.getBedColor(request);*/
		
		if(response.isSuccessful()){
			List<BedColor> colorList = response.getColorList();
			// here the assumption is that required color
			// will be at the top of the list
			BedColor reqdColor = colorList.get(0);
			if(reqdColor != null){
				bedTxtColor = reqdColor.getBedTextColor();
			}
		}
		
		return bedTxtColor;
	}
	
	/**
	 * This method returns the bed icon section instance
	 * the array of values obtained from back end
	 * The array will contain bed number, encounter id etc
	 * @param structAttributes
	 * @return
	 */
	public static BedIconSection getBedIconSection(Object[] structAttributes){
		BedIconSection bedIconSection = new BedIconSection();
		// no need to check the array - it is already valid
		String encId = ((Object) structAttributes[FloorLayoutConstants.BED_ICON_SECTION_ENC_ID_INDEX]).toString();
		String bedNum = (String)structAttributes[FloorLayoutConstants.BED_ICON_SECTION_BED_NUM_INDEX];
		String knownAllergy = (String)structAttributes[FloorLayoutConstants.BED_ICON_SECTION_K_ALLERGY_INDEX];
		String billExists = (String)structAttributes[FloorLayoutConstants.BED_ICON_SECTION_BILL_EXIST_INDEX];
		BigDecimal futureBookObj = (BigDecimal)structAttributes[FloorLayoutConstants.BED_ICON_SECTION_FUTURE_BOOK_INDEX];
		int futureBookCnt = CommonHelper.getIntegerValue(futureBookObj, 0);
		BigDecimal medOverDueObj = (BigDecimal)structAttributes[FloorLayoutConstants.BED_ICON_SECTION_MED_OVERDUE_INDEX];
		int medOverDueCnt = CommonHelper.getIntegerValue(medOverDueObj, 0);
		BigDecimal abnormalResultsObj = (BigDecimal)structAttributes[FloorLayoutConstants.BED_ICON_SECTION_ABNORMAL_RESULTS_INDEX];
		int abnormalResultsCnt = CommonHelper.getIntegerValue(abnormalResultsObj, 0);
		BigDecimal pubResultsObj = (BigDecimal)structAttributes[FloorLayoutConstants.BED_ICON_SECTION_PUB_RESULTS_INDEX];
		int pubResultsCnt = CommonHelper.getIntegerValue(pubResultsObj, 0);
		BigDecimal ordersObj = (BigDecimal)structAttributes[FloorLayoutConstants.BED_ICON_SECTION_ORDERS_INDEX];
		int ordersCnt = CommonHelper.getIntegerValue(ordersObj, 0);
		
		bedIconSection.setEncounterId(encId);
		bedIconSection.setBedNumber(bedNum);
		bedIconSection.setKnownAllergy(knownAllergy);
		bedIconSection.setBillExists(billExists);
		bedIconSection.setFutureBookingCount(futureBookCnt);
		bedIconSection.setMedicationOverDueCount(medOverDueCnt);
		bedIconSection.setAbnormalResultCount(abnormalResultsCnt);
		bedIconSection.setPublishedResultCount(pubResultsCnt);
		bedIconSection.setOrdersCount(ordersCnt);
		
		return bedIconSection;
	}
	
	
	
	
	/**
	 * 
	 * @param args
	 */
	/*public static void main(String[] args) {
		// [10088529, 01, 01, null, null, B, Y, null, null, null, B, GN01]
		// [10096743, 03, 01, null, null, B, Y, null, 0, null, B, GN01]
		// [10083459, 04, 01, 0, null, null, null, null, null, null, null, GN01]
		// [10101522, 00002A, 01, null, null, B, Y, null, 0, null, B, GN01]
		// [null, 567567, null, null, null, null, null, null, null, null, null,GN01]

		String structAttributes[] = new String[] { "10106220", "G0001", "01",
				null, null, null, null, null, null, null, null, "GN01" };
		structAttributes = new String[] { "10088529", "01", "01", null, null,
				"B", "Y", null, null, null, "B", "GN01" };
		structAttributes = new String[] { "10096743", "01", "01", null, null,
				"B", "Y", null, null, null, "B", "GN01" };
		BedStatusEnum statusEnum = BedHelper.getBedStatus(structAttributes);
		System.out.println(statusEnum);
	}*/

}
