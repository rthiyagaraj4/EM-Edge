/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.core.vo;

import java.io.Serializable;

public class SourceBean implements Serializable {

	private String SourceType;

	private String sourcetype;

	private String Source;

	private String SourceCode;

	private String functionId;

	private String moduleId;

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	public String getSourceCode() {
		return SourceCode;
	}

	public void setSourceCode(String sourceCode) {
		SourceCode = sourceCode;
	}

	public String getSourceType() {
		return SourceType;
	}

	public void setSourceType(String sourceType) {
		SourceType = sourceType;
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getSourcetype() {
		return sourcetype;
	}

	public void setSourcetype(String sourcetype) {
		this.sourcetype = sourcetype;
	}

}
