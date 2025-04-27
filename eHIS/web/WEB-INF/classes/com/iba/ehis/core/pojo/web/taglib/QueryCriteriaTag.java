/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.core.pojo.web.taglib;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import org.apache.struts.taglib.TagUtils;
import org.apache.struts.taglib.bean.MessageTag;
import org.apache.struts.taglib.html.ButtonTag;
import org.apache.struts.taglib.html.FormTag;
import org.apache.struts.taglib.html.HiddenTag;
import org.apache.struts.taglib.html.OptionsTag;
import org.apache.struts.taglib.html.SelectTag;
import org.apache.struts.taglib.html.SubmitTag;
import org.apache.struts.taglib.html.TextTag;
import org.apache.struts.util.LabelValueBean;

import com.iba.ehis.core.pojo.web.AppForm;
import com.iba.ehis.core.util.QueryCriteriaConstants;
import com.iba.ehis.core.vo.QueryCriteriaItem;
import com.iba.ehis.core.vo.QueryCriteriaVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.logging.pojo.business.IBALogger;

public class QueryCriteriaTag extends FormTag {

	public QueryCriteriaTag() {
		super();
	}

	public int doStartTag() throws JspException {
		
		setAction("/QueryAction");
		setMethod("post");
		setPageContext(pageContext);
		return super.doStartTag();
	}

	public int doEndTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		QueryCriteriaVO queryCriteriaVO = (QueryCriteriaVO) ((AppForm) request
				.getAttribute("QueryCriteriaForm")).getVo();
		TagUtils
				.getInstance()
				.write(
						pageContext,
						"<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center' class='COMMON_TOOLBAR'>");
		TagUtils.getInstance().write(pageContext,
				"<tr class='button'><th colspan=3 align='left'>");
		buildMessage("dsLabels", "com.iba.ehis.ds.queryCriteria");
		TagUtils.getInstance().write(pageContext, "</th></tr>");
		for (int items = 0; items < queryCriteriaVO.getCriteriaItems().size(); items++) {
			QueryCriteriaItem criteriaItem = (QueryCriteriaItem) queryCriteriaVO
					.getCriteriaItems().get(items);
			TagUtils.getInstance().write(pageContext,
					"<tr class='COMMON_TOOLBAR' align='right'>");
			switch (criteriaItem.getType()) {
			case QueryCriteriaConstants.TEXT_ITEM:
				buildCriteriaTextBox(criteriaItem, items);
				break;

			case QueryCriteriaConstants.SELECT_ITEM:
				buildCriteriaSelect(criteriaItem, items);
				break;
				
			case QueryCriteriaConstants.HIDDEN_ITEM:
				buildCriteriaHiddenBox(criteriaItem,items);
				break;
				
			default:				
				break;
			}
		
	
			TagUtils.getInstance().write(pageContext, "</tr>");
		}

		buildOrderBy(queryCriteriaVO.getOrderByOriginal(), queryCriteriaVO
				.getOrderBySelected());
		createHidden("method", String.valueOf(Constants.QUERY));
		createHidden("vo.queryResultPage", null);
		createHidden("vo.functionId", null);
		createHidden("vo.moduleId", null);
		createHidden("vo.pageAction", null);
		TagUtils.getInstance().write(pageContext, "</table>");

		return super.doEndTag();
	}
private void buildCriteriaHiddenBox(QueryCriteriaItem criteriaItem,int itemIndex) 
{
	
	if (criteriaItem.getLabelKey() != null) {
		try {
			
			TagUtils.getInstance().write(pageContext, "<td class='label'>");
			buildMessage(criteriaItem.getBundleName(), criteriaItem
					.getLabelKey());
			TagUtils.getInstance().write(pageContext, "</td>");
			
		} catch (JspException e) {
			e.printStackTrace();
		}

	}

	HiddenTag hiddenTag = new HiddenTag();
	hiddenTag.setPageContext(pageContext);
	hiddenTag.setParent(this);
	hiddenTag.setProperty("vo.criteriaItems[" + itemIndex + "].itemValue");
	hiddenTag.setSize(Integer.toString(criteriaItem.getSize()));
	hiddenTag.setCols(Integer.toString(criteriaItem.getLength()));
	
	try {
		
		TagUtils.getInstance().write(pageContext, "<td align='left'>");
		hiddenTag.doStartTag();
		hiddenTag.doEndTag();
		TagUtils.getInstance().write(pageContext, "</td>");
		createHidden("vo.criteriaItems[" + itemIndex + "].property", null);
		
	} catch (JspException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	
	private void createHidden(String propName, String value) {
		HiddenTag hiddenTag = new HiddenTag();
		hiddenTag.setPageContext(pageContext);
		hiddenTag.setParent(this);
		hiddenTag.setProperty(propName);
		if (value != null)
			hiddenTag.setValue(value);
		try {
			hiddenTag.doStartTag();
			hiddenTag.doEndTag();
		} catch (JspException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void buildCriteriaTextBox(QueryCriteriaItem criteriaItem,
			int itemIndex) {
		if (criteriaItem.getLabelKey() != null) {
			try {
				TagUtils.getInstance().write(pageContext, "<td class='label'>");
				buildMessage(criteriaItem.getBundleName(), criteriaItem
						.getLabelKey());
				TagUtils.getInstance().write(pageContext, "</td>");
			} catch (JspException e) {
				// TODO: handle exception
			}

		}
		TextTag textTag = new TextTag();
		textTag.setPageContext(pageContext);
		textTag.setParent(this);
		textTag.setProperty("vo.criteriaItems[" + itemIndex + "].itemValue");
		textTag.setSize(Integer.toString(criteriaItem.getSize()));
		textTag.setCols(Integer.toString(criteriaItem.getLength()));
		try {
			TagUtils.getInstance().write(pageContext, "<td align='left'>");
			textTag.doStartTag();
			textTag.doEndTag();
			TagUtils.getInstance().write(pageContext, "</td>");

			createHidden("vo.criteriaItems[" + itemIndex + "].property", null);
		} catch (JspException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void buildCriteriaSelect(QueryCriteriaItem criteriaItem,
			int itemIndex) {
		try {
			if (criteriaItem.getSelectValMap() == null)
				criteriaItem.setOptions(reformValues(criteriaItem.getOptions(),
						criteriaItem.getBundleName()));

		} catch (ApplicationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (criteriaItem.getLabelKey() != null) {
			try {
				TagUtils.getInstance().write(pageContext, "<td class='label'>");
				buildMessage(criteriaItem.getBundleName(), criteriaItem
						.getLabelKey());
				TagUtils.getInstance().write(pageContext, "</td>");
			} catch (JspException e) {
				// TODO: handle exception
			}

		}
		SelectTag selectTag = new SelectTag();

		selectTag.setPageContext(pageContext);
		selectTag.setParent(this);
		selectTag.setValue("");
		if (itemIndex == -1)
			selectTag.setProperty(criteriaItem.getProperty());
		else
			selectTag.setProperty("vo.criteriaItems[" + itemIndex
					+ "].itemValue");
		IBALogger.getLogger().debug(
				this.getClass(),
				String.valueOf(criteriaItem.isMultiple()),
				((HttpServletRequest) pageContext.getRequest()).getSession()
						.getId());

		if (criteriaItem.isMultiple())
			selectTag.setMultiple(String.valueOf(criteriaItem.isMultiple()));
		try {
			if (criteriaItem.isMultiple())
				TagUtils.getInstance()
						.write(pageContext, "<td align='center'>");
			else
				TagUtils.getInstance().write(pageContext, "<td align='left'>");
			selectTag.doStartTag();
			if (criteriaItem.getSelectValMap() == null)
				pageContext.setAttribute("options", criteriaItem.getOptions());
			else
				pageContext.setAttribute("options", criteriaItem
						.getSelectValMap());

			OptionsTag optionsTag = new OptionsTag();
			optionsTag.setCollection("options");

			optionsTag.setPageContext(pageContext);
			if (criteriaItem.getSelectValMap() == null) {
				optionsTag.setProperty("value");
				optionsTag.setLabelProperty("label");
			} else {
				optionsTag.setProperty("key");
				optionsTag.setLabelProperty("value");
			}
			optionsTag.setParent(selectTag);
			optionsTag.doStartTag();
			optionsTag.doEndTag();
			selectTag.doEndTag();
			TagUtils.getInstance().write(pageContext, "</td>");
			if (itemIndex != -1)
				createHidden("vo.criteriaItems[" + itemIndex + "].property",
						null);

		} catch (JspException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void buildMessage(String bundleName, String messageKey) {
		MessageTag message = new MessageTag();

		message.setPageContext(pageContext);
		message.setParent((FormTag) this);
		message.setBundle(bundleName);
		message.setKey(messageKey);

		try {
			// TagUtils.getInstance().write(pageContext, "<td>");
			message.doStartTag();
			message.doEndTag();
			// TagUtils.getInstance().write(pageContext, "</td>");
		} catch (JspException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void buildOrderBy(QueryCriteriaItem criteriaItemOriginal,
			QueryCriteriaItem criteriaItemSelected) {
		try {
			TagUtils.getInstance().write(pageContext, "</table><br><br>");
			TagUtils.getInstance().write(pageContext,
					"<table width=75% align='center'>");
			TagUtils.getInstance().write(pageContext,
					"<tr><th class='button' colspan=3 align='left'>");

			buildMessage("dsLabels", "com.iba.ehis.ds.sortOrder");

			TagUtils.getInstance().write(pageContext,
					"</th></tr><tr><td align='center'>");
			TagUtils
					.getInstance()
					.write(pageContext,
							"<table border='0' cellpadding='5' cellspacing='0' width='60%' align='center'>");

			TagUtils.getInstance().write(pageContext,
					"<tr><td align='center'><b>");
			buildMessage("lcLabels", "com.iba.ehis.lc.selectforbutton");
			TagUtils.getInstance().write(pageContext,
					"</b></td><td>&nbsp</td><td align='center'><b>");
			buildMessage("dsLabels", "com.iba.ehis.ds.orderBy");
			TagUtils.getInstance().write(pageContext, "</b></td></tr>");
			TagUtils.getInstance().write(pageContext, "<tr>");
			buildCriteriaSelect(criteriaItemOriginal, -1);

			TagUtils.getInstance().write(pageContext,
					"<td class='COMMON_TOOLBAR' align='center'>");
			ButtonTag selectOrderBy = new ButtonTag();
			selectOrderBy.setPageContext(pageContext);
			selectOrderBy.setStyleClass("button");
			selectOrderBy.setValue("---->");
			selectOrderBy
					.setOnclick("moveSelectedOptions(document.getElementById('vo.orderByOriginal.itemArr'),document.getElementById('vo.orderBySelected.itemArr'))");
			selectOrderBy.doStartTag();
			selectOrderBy.doEndTag();
			TagUtils.getInstance().write(pageContext, "<br>");

			ButtonTag removeOrderBy = new ButtonTag();
			removeOrderBy.setPageContext(pageContext);
			removeOrderBy.setStyleClass("button");
			removeOrderBy.setValue("<----");
			removeOrderBy
					.setOnclick("moveSelectedOptions(document.getElementById('vo.orderBySelected.itemArr'),document.getElementById('vo.orderByOriginal.itemArr'))");
			removeOrderBy.doStartTag();
			removeOrderBy.doEndTag();
			TagUtils.getInstance().write(pageContext, "</td>");
			buildCriteriaSelect(criteriaItemSelected, -1);
			TagUtils.getInstance().write(pageContext, "</tr>");

			TagUtils.getInstance().write(pageContext, "<tr><td>&nbsp</td>");
			TagUtils.getInstance().write(pageContext,
					"<td class='COMMON_TOOLBAR'align='center'>");
			SubmitTag executeButton = new SubmitTag();
			executeButton.setStyleClass("button");
			executeButton.setPageContext(pageContext);
			executeButton.setParent(this);
			executeButton.setValue("Execute");
			executeButton.setOnclick("selectOrder();this.form.submit()");
			executeButton.doStartTag();
			executeButton.doEndTag();
			TagUtils.getInstance().write(pageContext,
					"</td><td>&nbsp</td></tr></table></td></tr></table>");

		} catch (JspException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private List reformValues(List labelValues, String bundle) {
		for (int i = 0; i < labelValues.size(); i++) {
			MessageTag msgTag = new MessageTag();
			LabelValueBean labelValBean = (LabelValueBean) labelValues.get(i);
			String message = "";
			try {
				message = TagUtils.getInstance().message(pageContext, bundle,
						msgTag.getLocale(), labelValBean.getLabel());
			} catch (JspException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			labelValBean.setLabel(message);
			labelValues.set(i, labelValBean);

		}

		return labelValues;
	}
}
