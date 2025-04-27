/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS ;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Properties;
import java.util.StringTokenizer;

//import javax.naming.InitialContext ;
//import javax.rmi.PortableRemoteObject;
import javax.servlet.http.HttpSession;
import eSS.Common.SsAdapter;

public class ReportAutoclaveLoadSummaryBean extends eSS.Common.SsTransaction implements Serializable {
	public ReportAutoclaveLoadSummaryBean() {
	}

	
	public String getVals(){
		return getStaticListOptionTag( "B,Both;Y,Yes;N,No;" );
	}
	public String getStatus(){
		return getStaticListOptionTag( "B,Both;P,Passed;F,Failed;" );
	}
		
}
