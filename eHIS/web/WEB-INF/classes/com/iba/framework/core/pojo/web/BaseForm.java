/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.core.pojo.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.iba.framework.core.vo.BaseVO;

/**
 * @author Swetha
 */
public class BaseForm extends ActionForm {

	private BaseVO vo;

	private int method;

	private Class clazz;

	public BaseForm() {
	}

	public BaseForm(Class clazz) {
		this.clazz = clazz;
	}

	/*
	 * @return BaseVO
	 */
	public BaseVO getVo() {
		if (vo == null) {

			try {
				vo = (BaseVO) clazz.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vo;
	}

	/*
	 * parameter BaseVO
	 * 
	 */
	public void setVo(BaseVO vo) {
		this.vo = vo;
	}

	/*
	 * Validation @parameter ActionMapping,HttpServletRequest @return
	 * ActionErrors
	 * 
	 */
	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {

		return super.validate(arg0, arg1);
	}

	public int getMethod() {
		return method;
	}

	public void setMethod(int method) {
		this.method = method;
	}

}
