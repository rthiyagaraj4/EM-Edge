/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package ePH ;

import java.io.Serializable ;
import java.util.* ;
import java.sql.* ;
/*import javax.rmi.PortableRemoteObject ;
import javax.naming.InitialContext ;*/
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.RFD.*;

public class RFDBean extends PhAdapter implements Serializable {

	private Hashtable recordSet		= new Hashtable();

	public RFDBean() 
	{
		//Constructor
		try 
		{
			doCommon() ;
		}
		catch(Exception e) 
		{
//			System.out.println("Exception in constructor"+e.toString());
			e.printStackTrace();
		}
	}

	/* Over-ridden Adapter methods start here */
	private void doCommon() throws Exception 
	{
	}

	public void clear() 
	{
		super.clear() ;
	}

	/* Over-ridden Adapter methods endS here */
	/* Function specific methods start */

	public  HashMap getRF(String dCode)
	{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList RFId=new ArrayList();
		ArrayList RFName=new ArrayList();
		ArrayList RFQty=new ArrayList();
		ArrayList RFUOM=new ArrayList();
		ArrayList RFInfo=new ArrayList();
		ArrayList RFAssociated=new ArrayList();
		ArrayList RFDefault=new ArrayList();
		HashMap RFCollection=new HashMap();

		try {
			connection = getConnection() ;
			//this query returns all the associated Reconstituent Fluids associated for a particular drug
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_RFD_SELECT" )) ;
			pstmt.setString(1,dCode);
			pstmt.setString(2,dCode);
			pstmt.setString(3,dCode);
			pstmt.setString(4, getLanguageId()); 
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				RFId.add(resultSet.getString("RF_ID"));
				RFName.add(resultSet.getString("RF_NAME"));
				RFQty.add(resultSet.getString("RF_QTY"));
				RFUOM.add(resultSet.getString("RF_BASE_UOM"));
				RFInfo.add(resultSet.getString("STABILITY_INFO"));
				if (resultSet.getString("RF_QTY")==null)
				{
					RFAssociated.add("N");
				}
				else
				{
     				RFAssociated.add("Y");
				}

				RFDefault.add(resultSet.getString("DEFAULT_YN"));
			}
			RFCollection.put("RF_ID",RFId);
			RFCollection.put("RF_NAME",RFName);
			RFCollection.put("RF_QTY",RFQty);
			RFCollection.put("RF_UOM",RFUOM);
			RFCollection.put("RF_INFO",RFInfo);
			RFCollection.put("RF_ASSOCIATED",RFAssociated);
			RFCollection.put("RF_DEFAULT",RFDefault);
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			RFCollection.put("ERROR",e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) 
			{   
				System.out.println("Exception while closing the statements and resultsets"+es.toString());
			}
		
		}
		return RFCollection;

	}


	public String getLoggedInFacility()  
	{
		return login_facility_id;
	}
	

	public HashMap validate() throws Exception {
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}



public void setAll( Hashtable recordSet ) {
		/* This function also is called by the controller when apply is pressed 
		recordSet is nothing but a hashtable containing all form values
		*/
		
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;

		this.recordSet = recordSet;
	}

 public HashMap insert() {

		//HashMap result=new HashMap(); //Commented for common-icn-0048
		HashMap tabData=new HashMap();
		HashMap sqlMap=new HashMap();
		HashMap map=new HashMap();

		int updateableRows;

		tabData.put("flag","test flag");
		tabData.put("result",new Boolean(true));
		tabData.put("message","message");
		//This creates three tab data lists for insert,update and delete and calls the specific functions 


		tabData.put("DRUG_CODE",recordSet.get("drug_code"));
		tabData.put( "properties", getProperties() );

		//get the totalrows and run a loop up to totalrows time and then sort the data
		updateableRows=Integer.parseInt((String)recordSet.get("UpdateableRows"));

		ArrayList RFIdarrayI=new ArrayList();
		ArrayList RFQtyarrayI=new ArrayList();
		ArrayList StabilityInfoarrayI=new ArrayList();
		ArrayList DefaultarrayI=new ArrayList();
		ArrayList AssociatedarrayI=new ArrayList();
		ArrayList SelectarrayI=new ArrayList();

		ArrayList RFIdarrayU=new ArrayList();
		ArrayList RFQtyarrayU=new ArrayList();
		ArrayList StabilityInfoarrayU=new ArrayList();
		ArrayList DefaultarrayU=new ArrayList();
		ArrayList AssociatedarrayU=new ArrayList();
		ArrayList SelectarrayU=new ArrayList();

		ArrayList RFIdarrayD=new ArrayList();


		String temp,temp1;

		for (int i=1;i<=updateableRows ;i++ )
		{
			temp=(String)recordSet.get("Associated"+i);
			temp1=(String)recordSet.get("SELECT"+i);

			if ( temp.equals("Y")&&temp1.equals("Y")  )
			{
				// both are selected so we have to modify
				RFIdarrayU.add((String)recordSet.get("RFID"+i));
				RFQtyarrayU.add((String)recordSet.get("RFQTY"+i));
				StabilityInfoarrayU.add((String)recordSet.get("RFINFO"+i));
				DefaultarrayU.add((String)recordSet.get("DEFAULT"+i));
				AssociatedarrayU.add(temp);
				SelectarrayU.add(temp1);
			}
			else if (temp.equals("Y")&&temp1.equals("N"))
			{
				// to be deleted
				RFIdarrayD.add((String)recordSet.get("RFID"+i));
			}
			else if (temp.equals("N")&&temp1.equals("Y") ) 
			{
				// to be inserted
			RFIdarrayI.add((String)recordSet.get("RFID"+i));
			RFQtyarrayI.add((String)recordSet.get("RFQTY"+i));
			StabilityInfoarrayI.add((String)recordSet.get("RFINFO"+i));
			DefaultarrayI.add((String)recordSet.get("DEFAULT"+i));
			AssociatedarrayI.add(temp);
			SelectarrayI.add(temp1);
			}
		}

		tabData.put("RFIDI",RFIdarrayI);
		tabData.put("RFQTYI",RFQtyarrayI);
		tabData.put("RFINFOI",StabilityInfoarrayI);
		tabData.put("DEFAULTI",DefaultarrayI);
		tabData.put("SELECTI",SelectarrayI);
		tabData.put("RFIDU",RFIdarrayU);
		tabData.put("RFQTYU",RFQtyarrayU);
		tabData.put("RFINFOU",StabilityInfoarrayU);
		tabData.put("DEFAULTU",DefaultarrayU);
		tabData.put("SELECTU",SelectarrayU);
		tabData.put("RFIDD",RFIdarrayD);
		tabData.put("login_by_id",login_by_id);
		tabData.put("login_at_ws_no",login_at_ws_no);
		tabData.put("login_facility_id",login_facility_id);
		try
    	{
		sqlMap.put("SQLRFDINSERT", PhRepository.getPhKeyValue( "SQL_PH_RFD_INSERT" ) );
		sqlMap.put("SQLRFDUPDATE", PhRepository.getPhKeyValue( "SQL_PH_RFD_UPDATE" ) );
		sqlMap.put("SQLRFDDELETE", PhRepository.getPhKeyValue( "SQL_PH_RFD_DELETE" ) );
	    }
	    catch (Exception e)
	    {
          e.printStackTrace();
	    }

		/*RFDHome home=null;
		RFDRemote remote=null;*/

	   try {
					/*InitialContext context = new InitialContext() ;
					Object object = context.lookup( PhRepository.getPhKeyValue( "JNDI_PH_RFD" ) ) ;
					home  = (RFDHome) PortableRemoteObject.narrow( object, RFDHome.class ) ;
					remote = home.create() ; 

					map=remote.insert(tabData,sqlMap);*/

		Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue("JNDI_PH_RFD"),RFDHome.class,getLocalEJB());
		Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[]=new Object[2];
		argArray[0]=tabData;
		argArray[1]=sqlMap;

		Class[] paramArray=new Class[2];
		paramArray[0]=tabData.getClass();
		paramArray[1]=sqlMap.getClass();

		map=(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		if( ((Boolean) map.get( "result")).booleanValue() )
			map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid"),"PH") ) ;
		else
			map.put( "message", (String)map.get("msgid") ) ;
		 }
		 catch (Exception e)
		 {
		  System.err.println(e.toString());
		 }

		return map;

	 }

	private HashMap localInsert( HashMap tabData , HashMap sqlMap ) {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "inside Insert" ) ;
		
		Connection connection	= null ;
		PreparedStatement pstmt_insert		= null ;
		PreparedStatement pstmt_update=null;
		PreparedStatement pstmt_delete=null;
		
		ArrayList RFIdarrayI=new ArrayList();
		ArrayList RFQtyarrayI=new ArrayList();
		ArrayList StabilityInfoarrayI=new ArrayList();
		ArrayList DefaultarrayI=new ArrayList();

		ArrayList RFIdarrayU=new ArrayList();
		ArrayList RFQtyarrayU=new ArrayList();
		ArrayList StabilityInfoarrayU=new ArrayList();
		ArrayList DefaultarrayU=new ArrayList();

		ArrayList RFIdarrayD=new ArrayList();

		ResultSet resultSet = null ;
		int count=0;
		int tmpcount=0;

		RFIdarrayI=(ArrayList)tabData.get("RFIDI");
		RFQtyarrayI=(ArrayList)tabData.get("RFQTYI");
		StabilityInfoarrayI=(ArrayList)tabData.get("RFINFOI");
		DefaultarrayI=(ArrayList)tabData.get("DEFAULTI");

		
		RFIdarrayU=(ArrayList)tabData.get("RFIDU");
		RFQtyarrayU=(ArrayList)tabData.get("RFQTYU");
		StabilityInfoarrayU=(ArrayList)tabData.get("RFINFOU");
		DefaultarrayU=(ArrayList)tabData.get("DEFAULTU");

		RFIdarrayD=(ArrayList)tabData.get("RFIDD");

		try {
					
			 connection	= getConnection() ;

			count=RFIdarrayI.size();

			if (count>0)
			{
				//insert operations have to be performed
				pstmt_insert=connection.prepareStatement((String) sqlMap.get( "SQLRFDINSERT"));

				for (int i=0;i<count ;i++ )
				{
				pstmt_insert.setString(1,(String)tabData.get("DRUG_CODE"));
				pstmt_insert.setString(2,(String)RFIdarrayI.get(i));
				pstmt_insert.setString(3,(String)RFIdarrayI.get(i));
				pstmt_insert.setString(4,(String)tabData.get("DRUG_CODE"));
				pstmt_insert.setString(5,(String)tabData.get("DRUG_CODE"));
				pstmt_insert.setString(6,(String)RFQtyarrayI.get(i));
				pstmt_insert.setString(7,(String)RFIdarrayI.get(i));
				pstmt_insert.setString(8,(String)StabilityInfoarrayI.get(i));
				pstmt_insert.setString(9,login_by_id);
				pstmt_insert.setString(10,login_at_ws_no);
				pstmt_insert.setString(11,login_facility_id);
				pstmt_insert.setString(12,login_by_id);
				pstmt_insert.setString(13,login_at_ws_no);
				pstmt_insert.setString(14,login_facility_id);
				pstmt_insert.setString(15,(String)DefaultarrayI.get(i));


				tmpcount =pstmt_insert.executeUpdate() ;
				if (tmpcount==0) {
					map.put( "result", new Boolean( false ) ) ;
					map.put( "msgid", "Error During Insertion into RFD" );
					return map;
					}
			
			  }
			}
			//else check if update has to be performed				
			count=RFIdarrayU.size();

			if (count>0)
			{
				//update operations have to be performed
				pstmt_update=connection.prepareStatement((String) sqlMap.get( "SQLRFDUPDATE"));

				for (int i=0;i<count ;i++ )
				{
				pstmt_update.setString(1,(String)RFQtyarrayU.get(i));
				pstmt_update.setString(2,(String)StabilityInfoarrayU.get(i));
				pstmt_update.setString(3,login_by_id);
				pstmt_update.setString(4,login_at_ws_no);
				pstmt_update.setString(5,login_facility_id);
				pstmt_update.setString(6,(String)DefaultarrayU.get(i));
				pstmt_update.setString(7,(String)tabData.get("DRUG_CODE"));
				pstmt_update.setString(8,(String)RFIdarrayU.get(i));


				tmpcount =pstmt_update.executeUpdate() ;
				if (tmpcount==0) {
					map.put( "result", new Boolean( false ) ) ;
					map.put( "msgid", "Error During Updation into Fill Process Param" );
					return map;
					}
			
			  }
			}
			//else check if insert has to be performed				
			count=RFIdarrayD.size();

			if (count>0)
			{
				//update operations have to be performed
				pstmt_delete=connection.prepareStatement((String) sqlMap.get( "SQLRFDDELETE"));

				for (int i=0;i<count ;i++ )
				{
				pstmt_delete.setString(1,(String)tabData.get("DRUG_CODE"));
				pstmt_delete.setString(2,(String)RFIdarrayD.get(i));
			
				tmpcount =pstmt_delete.executeUpdate() ;
				if (tmpcount==0) {
					map.put( "result", new Boolean( false ) ) ;
					map.put( "msgid", "Error During Deletion into Fill Process Param" );
					return map;
					}
			
			  }
			}

			map.put( "result", new Boolean( true) ) ;
			map.put( "msgid", "RECORD_INSERTED") ;
			connection.commit();


		}//end of try
		
		catch( Exception e ) {
			map.put( "result", new Boolean( false ) ) ;
			map.put( "msgid", "Exception in EJB over here-Pushkala: " +e) ;

				}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt_insert ) ;
				closeStatement( pstmt_update );
				closeStatement( pstmt_delete );
				closeConnection( connection );
				connection.rollback();
			}
			catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
	
		return map ;

	}
			  
	/* Function specific methods end */
}

