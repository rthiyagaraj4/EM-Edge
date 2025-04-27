/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOH ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.sql.Types;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.io.Serializable;
import eOH.Common.OHAdapter;
import java.util.Properties;
import com.ehis.util.DateUtils;
import eCommon.Common.CommonBean;

public class OHHistoryBean extends OHAdapter implements Serializable {
	StringBuffer concatImage = null;
	StringBuffer concatImage_2 = null;
	public OHHistoryBean() {
		try {
			doCommon();
		}catch(Exception e) {}
	}

	public void doCommon() throws Exception {}

	public void clear(){
		this.concatImage = null;
	}

	public void setAllImagesForHistory(StringBuffer concatImage){
		concatImage = new StringBuffer();
		this.concatImage = concatImage;
	}
	public StringBuffer getAllImagesForHistory(){
		if(concatImage != null)
			return this.concatImage;
		else
			return new StringBuffer();
	}
	public void setAllImagesForHistory_2(StringBuffer concatImageBuf){
		concatImage_2 = new StringBuffer();
		this.concatImage_2 = concatImageBuf;
	}
	public StringBuffer getAllImagesForHistory_2(){
			return this.concatImage_2;
	}
}

