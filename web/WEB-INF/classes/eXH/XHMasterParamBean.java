/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------------------------------
Date       	 Name        	Description
-----------------------------------------------------------------------------------------------
30/07/2020   G.Niveditha    created

-----------------------------------------------------------------------------------------------
*/
package eXH;

import org.apache.commons.lang.StringUtils;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.io.*;
import java.lang.*;

public class XHMasterParamBean implements java.io.Serializable
{

	private String altId1TypeName;
	private String altId2TypeName;
	private String altId3TypeName;
	private String altId4TypeName;
	
	public String getAltId1TypeName() {
		return altId1TypeName;
	}
	public void setAltId1TypeName(String altId1TypeName) {
		this.altId1TypeName = altId1TypeName;
	}
	public String getAltId2TypeName() {
		return altId2TypeName;
	}
	public void setAltId2TypeName(String altId2TypeName) {
		this.altId2TypeName = altId2TypeName;
	}
	public String getAltId3TypeName() {
		return altId3TypeName;
	}
	public void setAltId3TypeName(String altId3TypeName) {
		this.altId3TypeName = altId3TypeName;
	}
	public String getAltId4TypeName() {
		return altId4TypeName;
	}
	public void setAltId4TypeName(String altId4TypeName) {
		this.altId4TypeName = altId4TypeName;
	}

}

