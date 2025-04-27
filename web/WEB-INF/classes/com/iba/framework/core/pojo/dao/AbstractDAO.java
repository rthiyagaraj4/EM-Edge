/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.core.pojo.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class AbstractDAO extends HibernateDaoSupport implements DAO {
	private HibernateTemplate ormTemplate = null;

	private boolean statsStatus = false;

	protected HibernateTemplate getOrmTemplate() {
		if (ormTemplate == null)
			ormTemplate = getHibernateTemplate();

		if (!statsStatus)
			enableStatsStatus();
		return ormTemplate;
	}

	private void enableStatsStatus() {
		statsStatus = true;
		getOrmTemplate().getSessionFactory().getStatistics()
				.setStatisticsEnabled(true);
	}

	public void setOrmTemplate(HibernateTemplate ormTemplate) {
		this.ormTemplate = ormTemplate;
	}
}
