/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;
import java.util.*;

public interface SceduleFreqeuncyInterface {
	public ArrayList getScheduleFrequencyStr(String code, String row_value);
	public boolean   setScheduleFrequencyStr(Hashtable ht);
	// Added By Sridhar Reddy On 050909 SRR20056-CRF-0274
	public void setScheduleDates(HashMap schdMap);
	public HashMap  getScheduleDates();	
	//public void  getScheduleDates(HashMap paramMap,ArrayList day_list);
}
