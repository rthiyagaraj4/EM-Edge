/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------
?             100         ?            created
14/11/2011    IN028981    Dinesh T     Added labels for KDAH-CRF-41
03/01/2012	  IN028417	  Menaka V	   The registered lab samples can be discontinued from CA-OR even though
									    the discontinuation reasons are not defined for lab module.
20/01/2012	IN029143	  Menaka V	   <JD-CRF-0111 This option is available in HIS 2.x and KAUH needs to be in
										EM version. In the current workflow the option is being used frequently. When a physician selects the patient, system will ask to enter the PIN Code. Physician needs to authenticate in the Prescription screen using the PIN code. This will prevent from unauthorised access while the physician is on rounds>.
-----------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      		Name        		Rev.Date				Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
04/07/2017		IN061903			Krishna Gowtham J.		05/07/2017				Ramesh G.		ML-MMOH-CRF-0555
------------------------------------------------------------------------------------------------------------------------------------------------------
*/
package eOR;

import eOR.Common.* ;
import java.io.*;
import java.util.*;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import eOR.Common.* ;
import eCommon.Common.*;

public class OrderCategoryBean extends OrAdapter implements java.io.Serializable 
{
	Hashtable recordSet = null;

	public ArrayList getOrderCategory() throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		try 
		{
			connection = getConnection() ;
			//pstmt = connection.prepareStatement("SELECT ORDER_CATEGORY,SHORT_DESC,CLIN_CMTS_REQD_YN,EXT_APPL_ACCESSION_GEN_YN,MULTI_PAT_RESULT_APPL_YN FROM OR_ORDER_CATEGORY order by ORDER_CATEGORY");
			//pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_CATEGORY_SELECT") ) ; //IN028981
			//pstmt = connection.prepareStatement("SELECT ORDER_CATEGORY,LONG_DESC,SHORT_DESC,CLIN_CMTS_REQD_YN,EXT_APPL_ACCESSION_GEN_YN, MULTI_PAT_RESULT_APPL_YN,PREFERRED_VIEW_RESULT_YN,COMPLETE_REMARKS_MAND_YN,PROMPT_FOR_APPT_ON_ORD_YN,CHK_PEND_ORD_CATEGORY FROM OR_ORDER_CATEGORY order by ORDER_CATEGORY ") ;//IN028981//IN028417
			//pstmt = connection.prepareStatement("SELECT ORDER_CATEGORY,LONG_DESC,SHORT_DESC,CLIN_CMTS_REQD_YN,EXT_APPL_ACCESSION_GEN_YN, MULTI_PAT_RESULT_APPL_YN,PREFERRED_VIEW_RESULT_YN,COMPLETE_REMARKS_MAND_YN,PROMPT_FOR_APPT_ON_ORD_YN,CHK_PEND_ORD_CATEGORY,HOLD_DISCONTINUE_CATEGORY_YN,SECURE_PIN_REQUIRED FROM OR_ORDER_CATEGORY order by ORDER_CATEGORY ") ;//IN028417//IN029143
			//IN061903 start
			//pstmt = connection.prepareStatement("SELECT ORDER_CATEGORY,LONG_DESC,SHORT_DESC,CLIN_CMTS_REQD_YN,EXT_APPL_ACCESSION_GEN_YN, MULTI_PAT_RESULT_APPL_YN,PREFERRED_VIEW_RESULT_YN,COMPLETE_REMARKS_MAND_YN,PROMPT_FOR_APPT_ON_ORD_YN,HOLD_DISCONTINUE_CATEGORY_YN,SECURE_PIN_REQUIRED FROM OR_ORDER_CATEGORY order by ORDER_CATEGORY ") ;//IN028763
			pstmt = connection.prepareStatement("SELECT ORDER_CATEGORY,LONG_DESC,SHORT_DESC,CLIN_CMTS_REQD_YN,EXT_APPL_ACCESSION_GEN_YN, MULTI_PAT_RESULT_APPL_YN,PREFERRED_VIEW_RESULT_YN,COMPLETE_REMARKS_MAND_YN,PROMPT_FOR_APPT_ON_ORD_YN,HOLD_DISCONTINUE_CATEGORY_YN,SECURE_PIN_REQUIRED, NOT_DONE_REASON_MAND_YN FROM OR_ORDER_CATEGORY order by ORDER_CATEGORY ") ;
			//IN061903 ends
			resultSet = pstmt.executeQuery() ;
			String[] record=null;

			while ( resultSet != null && resultSet.next() ) 
			{
				//IN061903 start
				//record = new String[12];//IN028417//IN029143
				record = new String[13];
				//IN061903 ends
				record[0] = resultSet.getString( "ORDER_CATEGORY" )  ;
				record[1] = resultSet.getString( "LONG_DESC" )  ;
				record[2] = resultSet.getString( "SHORT_DESC" )  ;
				record[3] = resultSet.getString( "CLIN_CMTS_REQD_YN" );
				record[4] = resultSet.getString( "EXT_APPL_ACCESSION_GEN_YN" );
				record[5] = resultSet.getString( "MULTI_PAT_RESULT_APPL_YN" );
				record[6] = resultSet.getString("PREFERRED_VIEW_RESULT_YN")==null?"N":resultSet.getString("PREFERRED_VIEW_RESULT_YN");
				/*Added by Uma on 1/29/2010 for IN016226 PMG20089-CRF-0804*/
				record[7] = resultSet.getString("COMPLETE_REMARKS_MAND_YN")==null?"N":resultSet.getString("COMPLETE_REMARKS_MAND_YN");
				/*Ends Here*/
				/*Added by Channaveer B on 22/11/2010 for SCF-24737*/
				record[8] = resultSet.getString("PROMPT_FOR_APPT_ON_ORD_YN")==null?"N":resultSet.getString("PROMPT_FOR_APPT_ON_ORD_YN");
				//record[9] = resultSet.getString("CHK_PEND_ORD_CATEGORY")==null?"N":resultSet.getString("CHK_PEND_ORD_CATEGORY");//IN028981//IN028763
				record[9] = resultSet.getString("HOLD_DISCONTINUE_CATEGORY_YN")==null?"N":resultSet.getString("HOLD_DISCONTINUE_CATEGORY_YN");//IN028417
				record[10] = resultSet.getString( "SECURE_PIN_REQUIRED" )  ;//IN029143
				record[11] = resultSet.getString( "NOT_DONE_REASON_MAND_YN" )  ;//IN061903
				
				OrderCat.add(record) ;
			}
		} 
		catch ( Exception e )	
		{			
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}
		return OrderCat;
	}

	public HashMap insert() 
	{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		return map;
	}
	public HashMap validate() throws Exception 
	{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map ;
	}

	public HashMap modify() 
	{
		Connection con 		= null;
		PreparedStatement pstmt 	= null;	
		HashMap map = new HashMap() ;
		//map.put( "result", new Boolean( false ) ) ;
        map.put( "flag","") ;
		map.put( "traceVal","");
		boolean	flag		  = false;
		StringBuffer messages = new StringBuffer() ;
		StringBuffer traceVal = new StringBuffer() ;

		try
		{
			con = getConnection(); 
			int totalNum = 0;
			
			if(recordSet.containsKey("totalRecords"))
				totalNum = Integer.parseInt((String)recordSet.get("totalRecords"));

			//String sql = OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_CATEGORY_UPDATE");//IN028981
			//String sql = "UPDATE OR_ORDER_CATEGORY SET SHORT_DESC=? , LONG_DESC=?,CLIN_CMTS_REQD_YN=?,EXT_APPL_ACCESSION_GEN_YN=?,MULTI_PAT_RESULT_APPL_YN =?,PREFERRED_VIEW_RESULT_YN=?,COMPLETE_REMARKS_MAND_YN=?,PROMPT_FOR_APPT_ON_ORD_YN=?,CHK_PEND_ORD_CATEGORY=?  WHERE ORDER_CATEGORY=?";//IN028981
			//String sql = "UPDATE OR_ORDER_CATEGORY SET SHORT_DESC=? , LONG_DESC=?,CLIN_CMTS_REQD_YN=?,EXT_APPL_ACCESSION_GEN_YN=?,MULTI_PAT_RESULT_APPL_YN =?,PREFERRED_VIEW_RESULT_YN=?,COMPLETE_REMARKS_MAND_YN=?,PROMPT_FOR_APPT_ON_ORD_YN=?,CHK_PEND_ORD_CATEGORY=?,HOLD_DISCONTINUE_CATEGORY_YN=?,SECURE_PIN_REQUIRED=?  WHERE ORDER_CATEGORY=?";//IN028417//IN029143
			//IN061903 start
			//String sql = "UPDATE OR_ORDER_CATEGORY SET SHORT_DESC=? , LONG_DESC=?,CLIN_CMTS_REQD_YN=?,EXT_APPL_ACCESSION_GEN_YN=?,MULTI_PAT_RESULT_APPL_YN =?,PREFERRED_VIEW_RESULT_YN=?,COMPLETE_REMARKS_MAND_YN=?,PROMPT_FOR_APPT_ON_ORD_YN=?,HOLD_DISCONTINUE_CATEGORY_YN=?,SECURE_PIN_REQUIRED=?  WHERE ORDER_CATEGORY=?";//IN028763
			String sql = "UPDATE OR_ORDER_CATEGORY SET SHORT_DESC=? , LONG_DESC=?,CLIN_CMTS_REQD_YN=?,EXT_APPL_ACCESSION_GEN_YN=?,MULTI_PAT_RESULT_APPL_YN =?,PREFERRED_VIEW_RESULT_YN=?,COMPLETE_REMARKS_MAND_YN=?,PROMPT_FOR_APPT_ON_ORD_YN=?,HOLD_DISCONTINUE_CATEGORY_YN=?,SECURE_PIN_REQUIRED=?, NOT_DONE_REASON_MAND_YN=?  WHERE ORDER_CATEGORY=?";
			//IN061903 ends
			//java.lang.String sql = "UPDATE OR_ORDER_CATEGORY SET CLIN_CMTS_REQD_YN=?,EXT_APPL_ACCESSION_GEN_YN=?,MULTI_PAT_RESULT_APPL_YN=? WHERE ORDER_CATEGORY=?";
			pstmt = con.prepareStatement(sql);
			
			String orCat = null;
			String chk1 = null;
			String chk2 = null;
			String chk3 = null;
			String chk4 = null;
			String chk5 = null;
			/*Added by Channaveer B on 22/11/2010 for SCF-24737*/
			String chk6 = null;
			/*Ends Here*/
			//String chk7="";//IN028981
			String chk8 = null;//IN028417
			String secure_PIN = null;//IN029143
			String shortdesc = null;
			String longdesc = null;
			String chk9 = null;//IN061903
			totalNum=totalNum-1;

			for(int i=0;i<=totalNum;i++)
			{
				orCat = "";
				chk1  = "";
				chk2  = "";
				chk3  = "";
				chk4  = "";
				/*Added by Uma on 1/29/2010 for IN016226 for PMG20089-CRF-804*/
				chk5 = "";
				/*Ends Here*/
				/*Added by Channaveer B on 22/11/2010 for SCF-24737*/
				chk6 = "";
				/*Ends Here*/
				//chk7="";//IN028981
				chk8 = "";//IN028417
				secure_PIN = "";//IN029143
				chk9 = "";//IN061903
				shortdesc="";
				longdesc="";

 				if(recordSet.containsKey("order_cat"+i))
					orCat  = (String) recordSet.get("order_cat"+i); 

				if(recordSet.containsKey("chk1_"+i))
					chk1   = (String) recordSet.get("chk1_"+i);
				chk1 = chk1.equals("")?"N":chk1;

				if(recordSet.containsKey("chk2_"+i))
					chk2   = (String) recordSet.get("chk2_"+i);
				chk2 = chk2.equals("")?"N":chk2;

				if(recordSet.containsKey("chk3_"+i))
					chk3   = (String) recordSet.get("chk3_"+i);
				chk3 = chk3.equals("")?"N":chk3;

				if(recordSet.containsKey("chk4_"+i))
					chk4   = (String) recordSet.get("chk4_"+i);
				chk4 = chk4.equals("")?"N":chk4;
				
				/*Added by Uma on 1/29/2010 for IN016226 for PMG20089-CRF-804*/
				if(recordSet.containsKey("chk5_"+i))
					chk5   = (String) recordSet.get("chk5_"+i);
				chk5 = chk5.equals("")?"N":chk5;
				/*Ends Here*/

				/*Added by Channaveer B on 22/11/2010 for SCF-24737*/
				if(recordSet.containsKey("chk6_"+i))
					chk6   = (String) recordSet.get("chk6_"+i);
				chk6 = chk6.equals("")?"N":chk6;
				/*Ends Here*/
				//IN028763 Starts
				/*if(recordSet.containsKey("chk7_"+i))//IN028981
					chk7   = (String) recordSet.get("chk7_"+i);//IN028981
				chk7 = chk7.equals("")?"N":chk7;*///IN028981
				//IN028763 Ends
				//IN028417 Starts
				if(recordSet.containsKey("chk8_"+i))
					chk8   = (String) recordSet.get("chk8_"+i);
				chk8 = chk8.equals("")?"N":chk8;
				//IN028417 Ends
				//IN029143 Starts
				if(recordSet.containsKey("secure_PIN"+i))
					secure_PIN   = (String) recordSet.get("secure_PIN"+i);
				secure_PIN = secure_PIN.equals("")?"":secure_PIN;
				//IN029143 Ends
				if(recordSet.containsKey("short_desc"+i))
					shortdesc   = (String) recordSet.get("short_desc"+i);
				shortdesc = shortdesc.equals("")?"N":shortdesc;

				if(recordSet.containsKey("long_desc"+i))
					longdesc   = (String) recordSet.get("long_desc"+i);
				longdesc = longdesc.equals("")?"N":longdesc;
	            
				//IN061903 Starts
				if(recordSet.containsKey("chk9_"+i))
					chk9   = (String) recordSet.get("chk9_"+i);
				chk9 = chk9.equals("")?"N":chk9;
				//IN061903 Ends
				pstmt.setString(1,shortdesc);
				pstmt.setString(2,longdesc);
				pstmt.setString(3,chk1);
				pstmt.setString(4,chk2);
				pstmt.setString(5,chk3);
				pstmt.setString(6,chk4);
				/*Added by Uma on 1/29/2010 for IN016226 for PMG20089-CRF-804*/
				pstmt.setString(7,chk5);
				/*Ends Here*/
				/*Added by Channaveer B on 22/11/2010 for SCF-24737*/
				pstmt.setString(8,chk6);
				/*Ends Here*/
				//pstmt.setString(9,chk7);//IN028981//IN028763
				pstmt.setString(9,chk8);//IN028417
				pstmt.setString(10,secure_PIN);//IN029143
				pstmt.setString(11,chk9);//IN061903
				pstmt.setString(12,orCat);//IN028417//IN029143//IN061903
				pstmt.addBatch();
			}
			int [] updateCounts = pstmt.executeBatch();	
			flag = true;
			
			for (int k=0;k<updateCounts.length ;k++ )
			{
				if(updateCounts[k]<0  && updateCounts[k] != -2 )
				{
					flag=false;
					break;
				}
			}

			if(flag == true)
			{
				//map.put("result", new Boolean(true));
				messages.append( getMessage(language_id, "RECORD_MODIFIED", "SM") ) ;				
    			con.commit() ;
			}
			else
			{
				con.rollback();
			}
		}
		catch(Exception e) 
		{
			flag = false;
			traceVal.append(e.getMessage());
			try
			{
				con.rollback();
			}
			catch(Exception e1)
			{
				traceVal.append(e.getMessage());
				e.printStackTrace();
			}
		}
		finally
		{
			map.clear();

			if(pstmt != null)	
			{
				try
				{
					pstmt.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
					traceVal.append(e.getMessage());
				}
			}

			if(con != null)
			{
				try
				{
					closeConnection(con);
				}
				catch(Exception e)
				{
					e.printStackTrace();
					traceVal.append(e.getMessage());
				}
			}
		}
		map.put( "result", new Boolean(flag));
		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVal.toString() ) ;
   		return map ;
	}

	public void setAll( Hashtable recordSet ) 
	{		
		this.recordSet = recordSet;	
	}

	public void clear() 
	{
		recordSet = null;
		super.clear() ;
	}
}
