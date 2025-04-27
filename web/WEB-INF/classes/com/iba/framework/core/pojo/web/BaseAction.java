/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.core.pojo.web;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.pojo.business.BaseBusinessDelegate;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.IBADate;
import com.iba.framework.core.util.ServiceLocator;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.core.vo.UserPreferences;
import com.iba.framework.logging.pojo.business.IBALogger;

/*
 * @author Swetha
 * 
 * */
public abstract class BaseAction extends Action {

	private BaseBusinessDelegate delegator;
	private UserPreferences userPreferences ;

	private String delegateId = null;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		/* Create an instance of ActionForm */
		BaseForm baseForm = (BaseForm) form;

		DTO result = null;

		int method = baseForm.getMethod();

		BaseVO valueObject = baseForm.getVo();
		
		PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
		java.beans.PropertyDescriptor[] pp = propertyUtilsBean
				.getPropertyDescriptors(valueObject);
				
		for (int i = 0; i < pp.length; i++) {
			IBALogger.getLogger().debug(this.getClass(), 
					"pp[i].getPropertyType().getName()==="
					
					, pp[i].getPropertyType().getName());
			if (pp[i].getPropertyType().getName().equals(
					IBADate.class.getName())) {

				Method dateReader = pp[i].getReadMethod();
				Object dateObj = dateReader.invoke(valueObject, null);
				if (dateObj != null) {
					IBADate date = (IBADate) dateObj;
					date.setSessionId(request.getSession().getId());
					Method dateWriter = pp[i].getWriteMethod();

					//dateWriter.invoke(valueObject, new Object[] { new IBADate(request.getSession().getId()) });
				}
			}
		}
		
		IBALogger.getLogger().debug(this.getClass(), ("Method::"+method), request.getSession().getId());
		switch (method) {
		/* On Create */
		case Constants.CREATE:
			result = doActionCreate(valueObject, request, response);
			break;
		/* On Load */
		case Constants.LOAD:
			result = doPrePopulate(valueObject, request, response);
			Object value = result.getObject();
			if (value instanceof BaseVO)
				baseForm.setVo((BaseVO) value);
			break;
		case Constants.UPDATE:
			/* On Update */
			result = doActionUpdate(valueObject, request, response);
			break; 
		case Constants.DELETE:
			/* On Delete */
			result = doActionDelete(valueObject, request, response);
			break;
		case Constants.QUERY:
			/* On Query */
			result = doActionQuery(valueObject, request, response);
			break;
		}
		
		/* Create an instance of the ActionMessages */
		ActionMessages message = new ActionMessages();
		/*
		 * Add the messages from the DTO ,so that it can be displayed in the
		 * front end
		 */
		IBALogger.getLogger().debug(this.getClass(),result.getMessageId(),null);
		if (result.getMessageId() != null) {
				message.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(result.getMessageId()));
				saveMessages(request,message);
			}
		
		request.setAttribute("status",new Integer(result.getStatus()));
		
		/* Set the valueObject */
		
		baseForm.setVo((BaseVO) result.getObject());
		baseForm.setMethod(result.getMode());
		// baseForm.setVo(valueObject);
		
		String key = (baseForm.getClass()).getName();
		key = key.substring(key.lastIndexOf(".") + 1);

		request.setAttribute(key, baseForm);
		
		IBALogger.getLogger().debug(this.getClass(),result.getTarget(),null);
		return (mapping.findForward(result.getTarget()));
	}

	public BaseBusinessDelegate getDelegator() {
		return delegator;
	}
	
	public void setDelegator(BaseBusinessDelegate delegator) {
		this.delegator = delegator;

	}

	/*
	 * doActionCreate method @return DTO @parameter Object
	 */
	protected abstract DTO doActionCreate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException;

	/*
	 * doActionRead method @return DTO @parameter Object
	 */
	protected abstract DTO doPrePopulate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException;

	/*
	 * doActionUpdate method @return DTO @parameter Object
	 */
	protected abstract DTO doActionUpdate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException;

	/*
	 * doActionDelete method @return DTO @parameter Object
	 */
	protected abstract DTO doActionDelete(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException;

	/*
	 * doActionQuery method @return DTO @parameter Object
	 */
	protected abstract DTO doActionQuery(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException;

	public String getDelegateId() {
		return delegateId;
	}

	public void setDelegateId(String delegateId) {
		this.delegateId = delegateId;
		setDelegator((BaseBusinessDelegate) ServiceLocator.getInstance()
				.getBean(this.delegateId));
	}
	
	public BaseBusinessDelegate getDelegatorById(String delegateId){
		IBALogger.getLogger().debug(this.getClass(), "In BaseAction Business Delegate", null);
		return((BaseBusinessDelegate) ServiceLocator.getInstance()
					.getBean(delegateId));
	}

	public UserPreferences getUserPreferences() {
		if(userPreferences ==null)	userPreferences = new UserPreferences();
		return userPreferences;
	}

	public void setUserPreferences(UserPreferences userPreferences) {
		this.userPreferences = userPreferences;
	}
}
