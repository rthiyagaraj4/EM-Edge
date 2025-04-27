/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law. 
 ******************************************************************************/
package eRD.Common;

import eCommon.Common.* ;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import webbeans.eCommon.*;


public abstract class RDAdapter extends CommonAdapter implements Serializable {

	public boolean flag = false;

		
	public RDAdapter() {
		super(CommonRepository.getCommonKeyValue( "ID_RD" ));
		System.out.println("RD adaptor");
	}

	public void setLocalEJB(boolean flag){
		this.flag=flag;
	}

	// To get the Mode for the Local EJB or Remote EJB
	public boolean getLocalEJB(){
		return flag;
	}
	

}
