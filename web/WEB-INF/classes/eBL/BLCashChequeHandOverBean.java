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

public class BLCashChequeHandOverBean extends BlAdapter implements Serializable
{
	protected String cashCounterCode			= "";
	protected HashMap cashCollDtls		= new HashMap();
	protected HashMap chequeCollDtls		= new HashMap();
	protected String tot_chk_amt="";
	protected String tot_cash_amt="";
	

	
	

	public BLCashChequeHandOverBean()
	{	
		//System.out.println("BLCashChequeHandOverBean Bean Initialized");
	}

	public HashMap validate() throws Exception
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." );
		return map;
	}
	

	

	public void  setCashCollectionDtls(HashMap  cashCollDtls)
	{ 
		this.cashCollDtls = cashCollDtls;
		//System.out.println("in set cashCollDtls="+this.cashCollDtls);
	}
	

	public HashMap getCashCollectionDtls()
	{ 
		return this.cashCollDtls ; 
	}

	public void  setChequeCollectionDtls(HashMap  chequeCollDtls)
	{ 
		this.chequeCollDtls = chequeCollDtls;
		//System.out.println("in set chequeCollDtls="+this.chequeCollDtls);
	}
	

	public HashMap getChequeCollectionDtls()
	{ 
		return this.chequeCollDtls ; 
	}

	public void  setTotCashAmt(String  tot_cash_amt)
	{ 
		this.tot_cash_amt = tot_cash_amt;
		//System.out.println("in set v="+this.tot_cash_amt);
	}

	public String getTotCashAmt()
	{ 
		return this.tot_cash_amt ; 
	}

	public void  setTotChequeAmt(String  tot_chk_amt)
	{ 
		this.tot_chk_amt = tot_chk_amt;
		//System.out.println("in set v="+this.tot_chk_amt);
	}

	public String getTotChequeAmt()
	{ 
		return this.tot_chk_amt ; 
	}




	
	public void setDBValues(String cash_counter_code,String login_userid,String req_date_time,String language_id,String operating_facility_id) throws Exception {
	/*	Connection connection 		= null;		
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;		

		ArrayList	curr_deno	    =	new ArrayList();
		ArrayList	curr_num	    =	new ArrayList();
		ArrayList	curr_amt	    =	new ArrayList();
		ArrayList	cash_colloction_details	    =	new ArrayList();
		HashMap cashCollectionDtlsMap    =   new HashMap();
try{
		String sqlStr="SELECT DEN_AMT,DEN_QTY ,DEN_AMT*DEN_QTY TOT_AMT FROM bl_handed_cash_amt_den WHERE requested_date_time = ? AND loggedin_user_id = ?";				
		System.out.println("in setDBValues,sqlStr="+sqlStr);
		System.out.println("in setDBValues,connection==null?="+(connection==null));
				if(rs!=null) rs=null;
				if(pstmt!=null) pstmt=null;
			
				pstmt=connection.prepareStatement(sqlStr);	
				pstmt.setString(1,req_date_time);
				pstmt.setString(2,login_userid);
				rs = pstmt.executeQuery();
				while (rs.next()){
					curr_deno.add(checkForNull(rs.getString("DEN_AMT")));
					curr_num.add(checkForNull(rs.getString("DEN_QTY")));
					curr_amt.add(checkForNull(rs.getString("TOT_AMT")));
				}
				if(curr_deno.size()>0)
				{
					cash_colloction_details.add(curr_deno)	;
					cash_colloction_details.add(curr_num);
					cash_colloction_details.add(curr_amt)	;
				}
				cashCollectionDtlsMap.put(cash_counter_code,cash_colloction_details);
				System.out.println("in setDBValues,cashCollectionDtlsMap="+cashCollectionDtlsMap);
				setCashCollectionDtls(cashCollectionDtlsMap);		
				
}catch(Exception e)
				{
					System.out.println("Error cash dbvaues = "+e);
				}	*/

	}
	
	public void clearBean()
	{
		//System.out.println("Bean Cleared");		
		if(cashCollDtls != null)
			cashCollDtls.clear();
		if(chequeCollDtls != null)
			chequeCollDtls.clear();
		
		
	}

	
}
