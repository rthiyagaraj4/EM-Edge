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

public class PkgDiscountBean extends BlAdapter implements Serializable
{
	
	
	protected ArrayList discPkgs=new ArrayList();//Pakagecode~~PackageseqNo~~Disc type~~Disc amount~~Reason code~~Reason desc~~cust_grp_code~~custcode
	
	public PkgDiscountBean()
	{	
		System.out.println("Bean Initialized");
	}
	public void setdiscPkgs(ArrayList discPkgs ){
		this.discPkgs=discPkgs;
	}
	public ArrayList getdiscPkgs(){
		return this.discPkgs;
	}
	public HashMap validate() throws Exception
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." );
		return map;
	}
		
	public void clearBean()
	{
		System.out.println("Bean Cleared");		
		if(discPkgs != null)
			discPkgs.clear();		
		
	}

	
}
