/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//saved on 08/11/2005
package ePH.TDMAttributes ;

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
*	name="TDMAttributes"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="TDMAttributes"
*	local-jndi-name="TDMAttributes"
*	impl-class-name="ePH.TDMAttributes.TDMAttributesManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.TDMAttributes.TDMAttributesLocal"
*	remote-class="ePH.TDMAttributes.TDMAttributesRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.TDMAttributes.TDMAttributesLocalHome"
*	remote-class="ePH.TDMAttributes.TDMAttributesHome"
*	generate= "local,remote"
*
*
*/
public class TDMAttributesManager extends PhEJBSessionAdapter {

	Properties prop=null;

	
	// insert method starts here
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap insert( HashMap tabData, HashMap sqlMap )  {
		
		String sample_type			= "";
		String sample_time			= "";
		String sample_timetype		= "";
		int insert_record1			=	0;
		int insert_record2			=	0;
		ArrayList traversalList		=	new ArrayList();

		HashMap map					=	new HashMap();
		HashMap commonData			=	new HashMap() ;
		HashMap insertData			=	new HashMap();
		HashMap record				=	new HashMap();
		Connection connection		=	null ;
		PreparedStatement pstmt1	=	null ;
		PreparedStatement pstmt2	=	null ;
		PreparedStatement pstmt_delete1 =	null ;
		PreparedStatement pstmt_delete2 =	null ;
		ResultSet resultSet			=	null ;

		commonData					=	(HashMap)tabData.get("COMMONDATA");
		insertData					=	(HashMap)tabData.get("INSERTDATA");
		//sqlMap	=(HashMap)tabData.get("SQLMAP");
		prop						=	(Properties)tabData.get( "properties" );	

		String pFlag				=	(String)commonData.get("peakFlag");
		String tFlag				=	(String)commonData.get("troughFlag");
		String eFlag				=	(String)commonData.get("extendFlag");
		String rFlag				=	(String)commonData.get("randomFlag");

		String remarks="";

		ArrayList peakRecords		=	(ArrayList)insertData.get("P");
		ArrayList troughRecords		=	(ArrayList)insertData.get("T");
		ArrayList extendRecords		=	(ArrayList)insertData.get("E");
		ArrayList randomRecords		=	(ArrayList)insertData.get("R");

	
		String insertquery1			=	(String)sqlMap.get("INSERTSQL1");
		String insertquery2			=	(String)sqlMap.get("INSERTSQL2");
		String deletequery1			=	(String)sqlMap.get("DELETESQL1");
		String deletequery2			=	(String)sqlMap.get("DELETESQL2");

		try {
			connection = getConnection( prop ) ;
			pstmt_delete1	  =	  connection.prepareStatement(deletequery1);
			pstmt_delete2	  =	  connection.prepareStatement(deletequery2);

			pstmt_delete1.setString(1,(String)commonData.get("drugCode"));
			pstmt_delete1.setString(2,(String)commonData.get("ageGrp"));
			pstmt_delete1.executeUpdate();

			pstmt_delete2.setString(1,(String)commonData.get("drugCode"));
			pstmt_delete2.setString(2,(String)commonData.get("ageGrp"));
			pstmt_delete2.executeUpdate();
			
			pstmt1			 =		connection.prepareStatement(insertquery1);
			pstmt2			 =		connection.prepareStatement(insertquery2);

			//Insertion
			 for (int i=0; i<4; i++) {
								
				traversalList	=	new ArrayList();
				sample_type		=	"";

				 if(i==0 && pFlag.equals("1")) {
					 sample_type = "P";
					 sample_time =(String)commonData.get("peakSampleTime");
					 sample_timetype= (String)commonData.get("peakSampleTimeType");
					 remarks =(String)commonData.get("peakremarks");
					 traversalList=peakRecords;
				}else if(i==1 && tFlag.equals("1")){
					sample_type="T";
					sample_time =(String)commonData.get("troughSampleTime");
					sample_timetype= (String)commonData.get("troughSampleTimeType");
					remarks =(String)commonData.get("troughremarks");
					traversalList=troughRecords;
				}else if(i==2 && eFlag.equals("1")){
					sample_type="E";
					sample_time =(String)commonData.get("extendSampleTime");
					sample_timetype= (String)commonData.get("extendSampleTimeType");
					remarks =(String)commonData.get("extendremarks");
					traversalList=extendRecords;
				}else if(i==3 && rFlag.equals("1")){
					sample_type="R";
					sample_time="";
					sample_timetype="";
					remarks =(String)commonData.get("randomremarks");
					traversalList=randomRecords;
				 }

			if(!sample_type.equals("")) {
				pstmt1.setString(1,(String)commonData.get("drugCode"));
				pstmt1.setString(2,(String)commonData.get("ageGrp"));
				/*pstmt1.setString(3,(String)commonData.get("minAge"));
				pstmt1.setString(4,(String)commonData.get("maxAge"));
				pstmt1.setString(5,(String)commonData.get("ageUnit"));
				pstmt1.setString(6,(String)commonData.get("gender"));*/
				pstmt1.setString(3,(String)commonData.get("steadyState"));
				pstmt1.setString(4,(String)commonData.get("steadyStateType"));
				pstmt1.setString(5,sample_type);
				pstmt1.setString(6,sample_time);
				pstmt1.setString(7,sample_timetype);
				pstmt1.setString(8,(String)commonData.get("login_by_id"));
				pstmt1.setString(9,(String)commonData.get("login_at_ws_no"));
				pstmt1.setString(10,(String)commonData.get("login_facility_id"));
				pstmt1.setString(11,(String)commonData.get("login_by_id"));
				pstmt1.setString(12,(String)commonData.get("login_at_ws_no"));
				pstmt1.setString(13,(String)commonData.get("login_facility_id"));
				pstmt1.setString(14,remarks);
				pstmt1.addBatch();
			}
			
			if(traversalList!=null && traversalList.size()>0){

				
				pstmt2.setString(1,(String)commonData.get("drugCode"));
				pstmt2.setString(2,(String)commonData.get("ageGrp"));
				pstmt2.setString(3,sample_type);

				pstmt2.setString(5,(String)commonData.get("login_by_id"));
				pstmt2.setString(6,(String)commonData.get("login_at_ws_no"));
				pstmt2.setString(7,(String)commonData.get("login_facility_id"));
				pstmt2.setString(8,(String)commonData.get("login_by_id"));
				pstmt2.setString(9,(String)commonData.get("login_at_ws_no"));
				pstmt2.setString(10,(String)commonData.get("login_facility_id"));
				
				for(int j=0;j<traversalList.size();j++)
				{
					record=(HashMap)traversalList.get(j);
					pstmt2.setString(4,(String)record.get("code"));
					pstmt2.addBatch();
				}
			}
		 }

			int result1[]=pstmt1.executeBatch();
			for(int i=0;i<result1.length;i++){
				if(result1[i]<0 && result1[i]!=-2){
					insert_record1=0;
					break;
				}
				else{
					insert_record1=1;
				}
			}

			int result2[]=pstmt2.executeBatch();
			for(int i=0;i<result2.length;i++){
				if(result2[i]<0 && result2[i]!=-2){
					insert_record2=0;
					break;
				}
				else{
					insert_record2=1;
				}
			}

			if(insert_record1==1 && insert_record2==1) {
				map.put( "result", new Boolean( true) ) ;
				map.put("message","RECORD_INSERTED");
				map.put("flag","");
				connection.commit();
			} else {
				map.put( "result", new Boolean( false) ) ;
				map.put("message","Transaction failed");
				map.put("flag","");
				connection.rollback();
				throw new Exception("Error : PH_TDM");
			}	

	
	}catch ( Exception e ){
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
					}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt1 ) ;
				closeStatement( pstmt2 ) ;
				closeStatement( pstmt_delete1 ) ;
				closeStatement( pstmt_delete2 ) ;
				closeConnection( connection,prop );
			}catch(Exception es){ es.printStackTrace();
			}
		}
		return map;
	}

	// insert method ends here

	//  modify method starts here
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "flag", "0" ) ;
		return map;
	}
	//  modify method ends here

	// delete method starts here
	public HashMap delete( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "flag", "0" ) ;
		return map;
	}
	// delete method ends here
}
