/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;
import java.io.*;
import java.util.*;
import java.sql.*;
import eBL.Common.*;
import webbeans.eCommon.*;
import eCommon.Common.CommonAdapter;

public class PkgSubsBean extends BlAdapter implements Serializable
{
	protected String packageCode			 = "";
	protected ArrayList priceFromDate   = new ArrayList();
	protected ArrayList priceToDate		 = new ArrayList();
	protected ArrayList price				     = new ArrayList();
	protected ArrayList flag				         = new ArrayList();
	protected HashMap packageDetails	 = new HashMap();
					    HashMap hashPrice	   		= new HashMap();	
	protected ArrayList subscribedPkgs =new ArrayList();//pkg_code~~pkg_short_desc~~pkg_seq_no

	public PkgSubsBean()
	{	
		System.out.println("Bean Initialized");
	}
	public void setSubscribedPkgs(ArrayList subscribedPkgs ){
		this.subscribedPkgs=subscribedPkgs;
	}
	public ArrayList getSubscribedPkgs(){
		return this.subscribedPkgs;
	}
	public HashMap validate() throws Exception
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." );
		return map;
	}

	public void  setPatientPackSubsDtls(HashMap  packageDetails)
	{ 
		this.packageDetails = packageDetails;
		System.out.println("in PkgSubsBean.java set packageDetails="+this.packageDetails);
	}
	
	public HashMap getPatientPackSubsDtls()
	{ 
		return this.packageDetails ; 
	}
	
	public void clearBean()
	{
		System.out.println("Bean Cleared");		
		if(packageDetails != null)
			packageDetails.clear();
				if(subscribedPkgs != null)
			subscribedPkgs.clear();	
	}
}
