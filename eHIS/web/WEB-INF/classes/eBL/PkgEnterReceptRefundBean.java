/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
  /*
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210416             17021        	Common-ICN-0009-TF	           NandhiniM
 */
package eBL;
import java.io.*;
import java.util.*;
import java.sql.*;
import eBL.Common.*;
import webbeans.eCommon.*;
import eCommon.Common.CommonAdapter;

public class PkgEnterReceptRefundBean extends BlAdapter implements Serializable
{	
	protected String packageCode			= "";
	protected String min_dep_amt			= "";
	protected double tot_pkg_amt			= 0;
	protected ArrayList priceFromDate	    = new ArrayList();
	protected ArrayList priceToDate			= new ArrayList();
	protected ArrayList price				= new ArrayList();
	protected ArrayList flag				= new ArrayList();
	protected HashMap support_data		= new HashMap();
	protected HashMap mult_slmt_vals		= new HashMap();
	protected HashMap mult_slmt_vals1		= new HashMap();
	
	HashMap hashPrice						= new HashMap();	
	protected ArrayList subscribedPkgs=new ArrayList();//pkg_code~~pkg_short_desc~~pkg_seq_no	
	

	public PkgEnterReceptRefundBean()
	{	
		//System.out.println("Bean Initialized");
	}
	public HashMap validate() throws Exception
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." );
		return map;
	}	

	public void  setSupportData(HashMap  support_data)
	{ 
		this.support_data = support_data;
	}	

	public HashMap getSupportData()
	{ 
		return this.support_data ; 
	}
	public void  setMultSlmtVals(HashMap  mult_slmt_vals)
	{ 
		this.mult_slmt_vals = mult_slmt_vals;		
	}	

	public HashMap getMultSlmtVals()
	{ 
		return this.mult_slmt_vals ; 
	}
	public void  setSlmtVals(HashMap  mult_slmt_vals1)
	{ 
		this.mult_slmt_vals1 = mult_slmt_vals1;
	}	

	public HashMap getSlmtVals()
	{ 
		return this.mult_slmt_vals1 ; 
	}
	
	public HashMap getDBValues(HashMap  patPackSubsDetails,String patient_id,String facilityid) throws Exception
	{
		Connection con 	= getConnection();	
		HashMap  results = new HashMap();
		String str_tot_min_dep_amt="",str_tot_package_amt="",str_min_dep_amt="";
		double tot_min_dep_amt=0;
		double d_tot_package_amt=0;
		String str_err_level="";
		String str_sys_message_id ="";
		String str_error_text= "";	
		try{
		if(patPackSubsDetails!=null && patPackSubsDetails.size()>0)
		{
			ArrayList	pkgDtls		=	new ArrayList();
			ArrayList	pkgCodes		=	new ArrayList();
			ArrayList	pkgFrmDate		=	new ArrayList();
			ArrayList	pkgToDate		=	new ArrayList();
			ArrayList	pkgAmt		=	new ArrayList();
			ArrayList	blng_class_code_list	=	new ArrayList();
			ArrayList	blng_class_desc_list	=	new ArrayList();	
			ArrayList	payerGrpCode_list	=	new ArrayList();
			ArrayList	payerGrpDesc_list	=	new ArrayList();
			ArrayList	payerCode_list	=	new ArrayList();
			ArrayList	payerDesc_list	=	new ArrayList();
			String packageCode="",fromDate="",toDate="",packAmt="0";
			String blng_class_code	="",blng_class_desc="", payerGrpCode="", payerGrpDesc="", payerCode="", payerDesc="", pkg_codes_for_disc="",ppkgprice="";			
			
			if(patPackSubsDetails.containsKey(patient_id))
			{
				pkgDtls					=(ArrayList)patPackSubsDetails.get(patient_id);		
				if(pkgDtls.size()>0)
				{
					pkgCodes = (ArrayList)pkgDtls.get(0);
					pkgFrmDate = (ArrayList)pkgDtls.get(2);
					pkgToDate = (ArrayList)pkgDtls.get(3);
					pkgAmt = (ArrayList)pkgDtls.get(4);
					blng_class_code_list = (ArrayList)pkgDtls.get(5);
					blng_class_desc_list = (ArrayList)pkgDtls.get(6);			
					payerGrpCode_list=(ArrayList)pkgDtls.get(7);
					payerGrpDesc_list=(ArrayList)pkgDtls.get(8);
					payerCode_list=(ArrayList)pkgDtls.get(9);
					payerDesc_list=(ArrayList)pkgDtls.get(10);				
				}
				int totRec = 0;
				if(pkgCodes.size() >0)
				totRec = pkgCodes.size();			
				for(int i=0;i<totRec;i++)
				{	
					packageCode	=(String)pkgCodes.get(i);
					pkg_codes_for_disc = packageCode+"|"+pkg_codes_for_disc;
					fromDate	=(String)pkgFrmDate.get(i);
					toDate	=(String)pkgToDate.get(i);
					packAmt	=(String)pkgAmt.get(i);	
					d_tot_package_amt=d_tot_package_amt+Double.parseDouble(packAmt);		
					blng_class_code	=(String)blng_class_code_list.get(i);
					blng_class_desc	=(String)blng_class_desc_list.get(i);
					payerGrpCode	=(String)payerGrpCode_list.get(i);	
					payerGrpDesc	=(String)payerGrpDesc_list.get(i);		
					payerCode	=(String)payerCode_list.get(i);
					payerDesc	=(String)payerDesc_list.get(i);	
					CallableStatement call12 = con.prepareCall("{ call  blpackage.getpackageMinDeposit(?,?,?,?,?,sysdate,?,?,?,?,?)}");		
					call12.setString(1,facilityid);				
					call12.setString(2,packageCode);				
					call12.setString(3,blng_class_code);				
					call12.setString(4,payerGrpCode);	
					call12.setString(5,payerCode);	
					call12.registerOutParameter(6,java.sql.Types.VARCHAR); // p_min_dep_amt		
					call12.registerOutParameter(7,java.sql.Types.VARCHAR); //p_err_level		
					call12.registerOutParameter(8,java.sql.Types.VARCHAR); // p_sys_message_id	
					call12.registerOutParameter(9,java.sql.Types.VARCHAR); // p_error_text	
					call12.registerOutParameter(10,java.sql.Types.VARCHAR); // p_error_text		
					call12.execute();				
					ppkgprice	 = call12.getString(6);
					str_min_dep_amt	 = call12.getString(7);	
					str_err_level		 = call12.getString(8);		
					str_sys_message_id	 = call12.getString(9);		
					str_error_text		 = call12.getString(10);			
					call12.close();	

					if ( ppkgprice == null ) ppkgprice = "";
					if ( str_min_dep_amt == null ) str_min_dep_amt = "";
					if ( str_err_level == null ) str_err_level = "";
					if ( str_sys_message_id == null ) str_sys_message_id = "";
					if ( str_error_text == null ) str_error_text = "";						
					
					tot_min_dep_amt =tot_min_dep_amt + Double.parseDouble(str_min_dep_amt);	   
			}//for
		}//if
			str_tot_min_dep_amt = Double.toString(tot_min_dep_amt);
			str_tot_package_amt = Double.toString(d_tot_package_amt);
			str_err_level= "";	str_sys_message_id= "";	str_error_text= "";	
			results.put("str_sys_message_id",str_sys_message_id) ;	
			results.put("str_error_text",str_error_text) ;
			results.put("str_error_level",str_err_level) ;
			results.put("str_tot_min_dep_amt",str_tot_min_dep_amt);
			results.put("str_tot_package_amt",str_tot_package_amt) ;			
			}
		}catch(Exception e)
		{
			System.out.println("get DBValues :"+e);
			e.printStackTrace();
		}
		finally
		{			
			if(con!=null) ConnectionManager.returnConnection(con);
			//call12.close(); //commented against V210416.
		}
		return results;
	}

	public void clearBean()
	{
		if(mult_slmt_vals != null)
		mult_slmt_vals.clear();
		if(support_data != null)
		support_data.clear();
		if(mult_slmt_vals1 != null)
		mult_slmt_vals1.clear();		
	}	
}
