/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.scheduler.jobs;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.iba.framework.cache.pojo.business.CacheManager;
import com.iba.framework.logging.pojo.business.LogFactory;
import com.iba.framework.logging.pojo.business.Logger;

/**
 * <p>This Quartz job gets executed at regular interval as mentioned in the
 * application configuration and cleans up the expired session objects from the
 * <B>USER SESSION CACHE AREA</b>.
 * 
 * @author S Sabarinathan
 * 
 */
public class CacheWatchDog extends QuartzJobBean {
	final static Logger logger = LogFactory.getApplicationLogger();

	protected void executeInternal(JobExecutionContext jobContext)
			throws JobExecutionException {
		String jobName = jobContext.getJobDetail().getFullName();
		logger.debug(this.getClass(), jobName + " executing at " + new Date(),null);
		
		/*if (CacheManager.getCache().isRunning()) {
			CacheManager.getCache().invalidateTemporaryRegion();
		} else{
			logger.info(this.getClass(),"Cache service is down. Cleanup job failed.", null);
		}*/
	}
}
