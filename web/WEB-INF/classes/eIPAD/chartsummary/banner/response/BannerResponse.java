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
package eIPAD.chartsummary.banner.response;

/**
 * @author GaneshkumarC 
 *
 */
import eIPAD.chartsummary.common.response.*;
import eIPAD.chartsummary.banner.healthobject.*;

public class BannerResponse extends GenericResponse {
	private BannerConfigHO oBannerConfig;
	private BannerContentsHO oBannerContentHO;
	/**
	 * @return the oBannerConfig
	 */
	public BannerConfigHO getBannerConfig() {
		return oBannerConfig;
	}
	/**
	 * @param oBannerConfig the oBannerConfig to set
	 */
	public void setBannerConfig(BannerConfigHO oBannerConfig) {
		this.oBannerConfig = oBannerConfig;
	}
	/**
	 * @return the oBannerContentHO
	 */
	public BannerContentsHO getBannerContent() {
		return oBannerContentHO;
	}
	/**
	 * @param oBannerContentHO the oBannerContentHO to set
	 */
	public void setBannerContent(BannerContentsHO oBannerContentHO) {
		this.oBannerContentHO = oBannerContentHO;
	}
	
}
