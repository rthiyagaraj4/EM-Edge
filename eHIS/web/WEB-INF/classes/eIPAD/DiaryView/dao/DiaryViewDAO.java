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
package eIPAD.DiaryView.dao;

import eIPAD.DiaryView.request.DiaryViewRequest;
import eIPAD.DiaryView.response.DiaryViewResponse;
import eIPAD.DiaryView.response.OTProcDetailResponse;

/**
 * @author vchoughule
 *
 */
public interface DiaryViewDAO {
	public DiaryViewResponse getDiaryViewDetails (DiaryViewRequest diaryViewRequest);
	/*public OTProcDetailResponse getProcDetails (String bookingNo, String facilityID, String locale);*/

}
