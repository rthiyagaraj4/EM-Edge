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

public class BLPatRegChargesBean extends BlAdapter implements Serializable
{
	protected String panel_string			= "";	
	protected String tot_pat_payable="";
	protected String tot_charges="";
	protected String success_pat_reg_chr="";
	protected HashMap finDtls		= new HashMap();
	

	
	

	public BLPatRegChargesBean()
	{	
		System.out.println("BLCashChequeHandOverBean Bean Initialized");
	}

	public HashMap validate() throws Exception
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." );
		return map;
	}
	

	

	public void  setPanelString(String  panel_string)
	{ 
		this.panel_string = panel_string;
//		System.out.println("in set panel_string="+this.panel_string);
	}
	

	public String getPanelString()
	{ 
		return this.panel_string ; 
	}

	

		
	public void  setTotPatPay(String  tot_pat_payable)
	{ 
		this.tot_pat_payable = tot_pat_payable;
//		System.out.println("in set tot_pat_payable="+this.tot_pat_payable);
	}

	public String getTotPatPay()
	{ 
		return this.tot_pat_payable ; 
	}

	public void  setTotPay(String  tot_charges)
	{ 
		this.tot_charges = tot_charges;
//		System.out.println("in set tot_pat_payable="+this.tot_pat_payable);
	}

	public String getTotPay()
	{ 
		return this.tot_charges ; 
	}


	public void  setFinDtls(HashMap  finDtls)
	{ 
		this.finDtls = finDtls;
//		System.out.println("in set finDtls="+this.finDtls);
	}
	

	public HashMap getFinDtls()
	{ 
		return this.finDtls ; 
	}


	public void setSuccess(String success_pat_reg_chr)
	{
		this.success_pat_reg_chr=success_pat_reg_chr;
	}
	
	public String getSuccess()
	{
		return this.success_pat_reg_chr;
	}

	
	public void clearBean()
	{
//		System.out.println("Bean Cleared");		
		if(finDtls != null)
			finDtls.clear();
		tot_charges="";
		tot_pat_payable="";
		panel_string="";
		success_pat_reg_chr="";
		
	}

	
}
