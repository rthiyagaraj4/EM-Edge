/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.allergies.request;
import eIPAD.chartsummary.common.request.*;
/**
 * @author GaneshkumarC 
 *
 */
public class AllergyRequest extends GenericRequest {

		private String allergenCode;
		private String eventTypeCode;
		private String eventTypeInd;
		/**
		 * @return the allergenCode
		 */
		public String getAllergenCode() {
			return allergenCode;
		}

		/**
		 * @param allergenCode the allergenCode to set
		 */
		public void setAllergenCode(String allergenCode) {
			this.allergenCode = allergenCode;
		}

		/**
		 * @return the eventTypeCode
		 */
		public String getEventTypeCode() {
			return eventTypeCode;
		}

		/**
		 * @param eventTypeCode the eventTypeCode to set
		 */
		public void setEventTypeCode(String eventTypeCode) {
			this.eventTypeCode = eventTypeCode;
		}

		/**
		 * @return the eventTypeInd
		 */
		public String getEventTypeInd() {
			return eventTypeInd;
		}

		/**
		 * @param eventTypeInd the eventTypeInd to set
		 */
		public void setEventTypeInd(String eventTypeInd) {
			this.eventTypeInd = eventTypeInd;
		}
}
