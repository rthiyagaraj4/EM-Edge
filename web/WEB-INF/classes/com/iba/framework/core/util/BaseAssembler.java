/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Created on Jun 7, 2006
 */
package com.iba.framework.core.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.logging.pojo.business.Logger;

/**
 * @author S Sabarinathan
 * 
 */
public abstract class BaseAssembler {

	/**
	 * @param vo
	 * @param classDO
	 * @return
	 * @throws AssemblerException
	 */
	public final Object getDO(BaseVO vo, Class classDO)
			throws AssemblerException {
		Object oDO = null;

		Logger logger = IBALogger.getLogger();
		logger.error(this.getClass(), vo + "-----" + classDO, "");
		try {
			oDO = Class.forName(classDO.getName()).newInstance();
			logger.error(this.getClass(), vo + "-----" + oDO, "");
			BeanUtils.copyProperties(oDO, vo);
		} catch (InstantiationException e) {
			throw new AssemblerException("Unable to convert VO to DO for "
					+ classDO.getName() + ")", e);
		} catch (IllegalAccessException e) {
			// throw new AssemblerException("Unable to convert VO to DO for "
			// + classDO.getName() + ")", e);
			logger.error(this.getClass(), "" + e.getMessage() + ": from "
					+ vo.getClass() + " : to" + classDO.getClass(), "");
		} catch (ClassNotFoundException e) {
			throw new AssemblerException("Unable to convert VO to DO for "
					+ classDO.getName() + ")", e);
		} catch (InvocationTargetException e) {
			throw new AssemblerException("Unable to convert VO to DO for "
					+ classDO.getName() + ")", e);
		}
		return oDO;
	}

	public final Object getVO(List oDO, Class classVO)
			throws AssemblerException {
		Object oVO = null;
		List oList = new ArrayList();

		for (int i = 0; i < oDO.size(); i++) {
			oList.add(getVO(oDO.get(i), classVO));
		}
		return oList;
	}

	public final Object getVO(Object oDO, Class classVO)
			throws AssemblerException {
		Object oVO;
		try {
			oVO = Class.forName(classVO.getName()).newInstance();
			BeanUtils.copyProperties(oVO, oDO);
		} catch (InstantiationException e) {
			throw new AssemblerException("Unable to convert DO to VO. ("
					+ classVO.getName() + ")", e);
		} catch (IllegalAccessException e) {
			throw new AssemblerException("Unable to convert DO to VO.("
					+ classVO.getName() + ")", e);
		} catch (ClassNotFoundException e) {
			throw new AssemblerException("Unable to convert DO to VO.("
					+ classVO.getName() + ")", e);
		} catch (InvocationTargetException e) {
			throw new AssemblerException("Unable to convert DO to VO.("
					+ classVO.getName() + ")", e);
		}
		return oVO;
	}

	public Object convertDO2VO(Object dObj, Class classVO)
			throws AssemblerException {
		return getVO(dObj, classVO);
	}

	public Object convertVO2DO(Object vo) throws AssemblerException {
		return null;
	}

	public Object convertVO2DO(BaseVO vo, Class classDO)
			throws AssemblerException {

		return getDO(vo, classDO);
	}

	public Object convertDO2VO(Object oDO) throws AssemblerException {
		return null;
	}

}
