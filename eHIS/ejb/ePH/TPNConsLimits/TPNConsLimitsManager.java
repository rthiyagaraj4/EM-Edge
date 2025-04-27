/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH.TPNConsLimits ;

import java.rmi.* ;
import java.util.HashMap ;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.* ;
import javax.ejb.* ;
import ePH.Common.PhEJBSessionAdapter ;

/**
*
* @ejb.bean
*	name="TPNConsLimits"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="TPNConsLimits"
*	local-jndi-name="TPNConsLimits"
*	impl-class-name="ePH.TPNConsLimits.TPNConsLimitsManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.TPNConsLimits.TPNConsLimitsLocal"
*	remote-class="ePH.TPNConsLimits.TPNConsLimitsRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.TPNConsLimits.TPNConsLimitsLocalHome"
*	remote-class="ePH.TPNConsLimits.TPNConsLimitsHome"
*	generate= "local,remote"
*
*
*/



public class TPNConsLimitsManager extends PhEJBSessionAdapter {

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap insert( HashMap tabData, HashMap sqlMap )  {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "inside Insert" ) ;
		String debug="0";

		Connection connection					= null ;
		PreparedStatement pstmt_insert		= null ;
		PreparedStatement pstmt_delete		=null;
	//	PreparedStatement pstmt_insert1		= null ;
	//	PreparedStatement pstmt_delete1		=null;


		ArrayList CGCodearray	=new ArrayList();
		ArrayList QtyUnitarray	=new ArrayList();
		ArrayList Minarray			=new ArrayList();
		ArrayList Maxarray	 		=new ArrayList();
		ArrayList Stdarray			=new ArrayList();
        ArrayList Ceilarray=new ArrayList();
		ArrayList UsgIndarray=new ArrayList();
        ArrayList Remrksarray=new ArrayList();
        ArrayList OrderingLimitarray=new ArrayList();

		String user="";
		String wsno="";
		String facility="";
		String agegroup=(String)tabData.get("AGEGROUP");
		String regimen_code=(String)tabData.get("regimen_code");


//		ResultSet resultSet = null ;
		int count				=0;
	//	int count1				=0;
//		int tmpcount			=0;

		CGCodearray	 	           =(ArrayList)tabData.get("CGCODEARRAY");
		QtyUnitarray		       =(ArrayList)tabData.get("QTYUNITARRAY");
		Minarray			       =(ArrayList)tabData.get("MINARRAY");
		Maxarray			       =(ArrayList)tabData.get("MAXARRAY");
		Stdarray			       =(ArrayList)tabData.get("STDARRAY");
        Ceilarray                  =(ArrayList)tabData.get("CEILARRAY");
		UsgIndarray                =(ArrayList)tabData.get("USGINDARRAY");
		Remrksarray                =(ArrayList)tabData.get("REMARRAY");
		OrderingLimitarray         =(ArrayList)tabData.get("ORDLIMITARRAY");
       // System.out.println("ceil in ejb"+Ceilarray);
		//System.out.println("indicator in ejb"+UsgIndarray);
		//System.out.println("remarks in ejb"+Remrksarray);
        //System.out.println("OrderingLimitarray in ejb"+OrderingLimitarray);
           
		user					=(String)tabData.get("LOGIN_BY_ID");
		facility				=(String)tabData.get("LOGIN_FACILITY_ID");
		wsno	 				=(String)tabData.get("LOGIN_AT_WS_NO");
		/*String infusion_line	=(String)tabData.get("infusion_line");
		String min_age			=(String)tabData.get("Min_Age");
		String Max_Age			=(String)tabData.get("Max_Age");
		String Age_Unit			=(String)tabData.get("Age_Unit");
		String gender			=(String)tabData.get("gender");*/ //Commented for COMMON-ICN-0048

		try {

			connection	= getConnection( (Properties)tabData.get( "PROPERTIES" )) ;
		
			pstmt_delete=connection.prepareStatement((String) sqlMap.get( "SQLDELETE"));
			pstmt_delete.setString(1,agegroup);
            pstmt_delete.setString(2,regimen_code);
			count=pstmt_delete.executeUpdate();
			
			count=CGCodearray.size();
			/*
			pstmt_delete1=connection.prepareStatement((String) sqlMap.get( "SQLDELETE1"));
			pstmt_delete1.setString(1,agegroup);
			count1=pstmt_delete1.executeUpdate();
			*/
		

				if (count>0)
				{
				//insert operations have to be performed
			/*	System.err.println("@@@@@@@@@@@@@@@@@===3");

					pstmt_insert1=connection.prepareStatement((String) sqlMap.get( "SQLINSERT1"));
					pstmt_insert1.setString(1,agegroup);
					pstmt_insert1.setString(2,gender);
					pstmt_insert1.setString(3,min_age);
					pstmt_insert1.setString(4,Max_Age);
					pstmt_insert1.setString(5,Age_Unit);
					pstmt_insert1.setString(6,user);
					pstmt_insert1.setString(7,wsno);
					pstmt_insert1.setString(8,facility);
					pstmt_insert1.setString(9,user);
					pstmt_insert1.setString(10,wsno);
					pstmt_insert1.setString(11,facility);
					
					count1 = pstmt_insert1.executeUpdate();
				*/
					pstmt_insert=connection.prepareStatement((String) sqlMap.get( "SQLINSERT"));

					for (int i=0;i<count ;i++ )
					{
					pstmt_insert.setString(1,agegroup);
					pstmt_insert.setString(2,(String)CGCodearray.get(i));
					pstmt_insert.setString(3,(String)QtyUnitarray.get(i));
					pstmt_insert.setString(4,(String)Minarray.get(i));
					pstmt_insert.setString(5,(String)Maxarray.get(i));
					pstmt_insert.setString(6,(String)Stdarray.get(i));
					pstmt_insert.setString(7,user);
					pstmt_insert.setString(8,wsno);
					pstmt_insert.setString(9,facility);
					pstmt_insert.setString(10,user);
					pstmt_insert.setString(11,wsno);
					pstmt_insert.setString(12,facility);
					//pstmt_insert.setString(13,infusion_line);
					pstmt_insert.setString(13,regimen_code);
					pstmt_insert.setString(14,(String)Ceilarray.get(i));
					pstmt_insert.setString(15,(String)UsgIndarray.get(i));
					pstmt_insert.setString(16,(String)Remrksarray.get(i));
					pstmt_insert.setString(17,(String)OrderingLimitarray.get(i));
					pstmt_insert.addBatch() ;
			 		 }
	  				debug+="5";
					int[] result1=pstmt_insert.executeBatch();

					for ( int k=0;k<result1.length ;k++ ){
						if(result1[k]<0  && result1[k] != -2 )
						{
								pstmt_insert.cancel();
								connection.rollback();
								map.put( "result", new Boolean( false) ) ;
								map.put( "msgid", "Exception Occured During Insert Process!!!") ;
								return map;
						}
					}

			}



			debug+="11";

			map.put( "result", new Boolean( true) ) ;
			map.put( "msgid", "RECORD_INSERTED") ;
			connection.commit();


		}//end of try

		catch( Exception e ) {
			try{
				connection.rollback();
				throw new EJBException( e.getMessage() ) ;
			}
			catch ( Exception ee ) {
				//messages.append( ee.getMessage() ) ;
				System.err.println(ee);
			}

			map.put( "result", new Boolean( false ) ) ;
			map.put( "msgid", "Exception in EJB over here " +e+debug) ;

				}
		finally {
			try {
				closeStatement( pstmt_insert ) ;
				closeStatement( pstmt_delete ) ;
			//	closeStatement( pstmt_insert1 ) ;
			//	closeStatement( pstmt_delete1 ) ;
				//closeConnection( connection );
				closeConnection( connection, (Properties)tabData.get( "PROPERTIES" ) );
				//connection.rollback();
			}
			catch ( Exception fe ) {

				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}
		return map ;
	}
// insert method ends here

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
public HashMap modify( HashMap tabData, HashMap sqlMap )  {

				return new HashMap() ;
	}


	/* Function specific methods end */



/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

public HashMap delete( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		return map;
	}
	// delete method ends here
}
