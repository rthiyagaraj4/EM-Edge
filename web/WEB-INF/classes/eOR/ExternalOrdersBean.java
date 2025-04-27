/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* Multi Patient Orders Bean is used as an Session Bean, because from the Application
 * Will be setting all the patient_id selected to this bean, so that it can be
   accessed from the Orders, etc.
*/
package eOR ;

import java.io.* ;
import java.util.* ;
import java.sql.*;

import eOR.Common.* ;
import eCommon.Common.*;

public class ExternalOrdersBean extends eOR.Common.OrAdapter implements Serializable {
	protected String patientId;
	protected String facility;
	protected String practitioner;
	protected String Referral_date;
	protected String remarks;
	protected String qryString;
	protected String order_category;
	protected String order_type;
	protected String order_catalog_code;
	protected String called_from;
	protected String ohorder_id;
	protected String activity_code;
	protected String activity_desc;

/**********************SET METHODS**************************************/
 public void  setPatientId(String  patientId) {this.patientId=  patientId; } ;
 public void  setFacilityId(String  facility) {this.facility=  facility; } ;
 public void  setPractitionerId(String  practitioner) {this.practitioner=  practitioner; } ;
 public void  setReferral_date(String  Referral_date) {this.Referral_date=  Referral_date; } ;
 public void  setRemarks(String  remarks) {this.remarks=  remarks; } ;
 public void  setQryString(String qryString) {this.qryString = qryString;};
 public void setOrderCategory(String order_category) { this.order_category = order_category; };
 public void setOrderType(String order_type) {  this.order_type = order_type; };
public void setActivity_Type(String activity_code) {  this.activity_code = activity_code; };
public void setActivity_Desc(String activity_desc) {  this.activity_desc = activity_desc; };

 public void  setOrderCatalogCode(String order_catalog_code) {this.order_catalog_code = order_catalog_code;};
 public void  setCalledFrom(String called_from) {this.called_from = called_from;};
 public void  setOrderId(String ohorder_id) {this.ohorder_id = ohorder_id;};
	 


/**********************END OF SET METHODS*********************************/	

/**********************GET METHODS***************************************/

 public String getPatientId() { return this.patientId ; } ;
 public String getFacilityId() { return this.facility ; } ;
 public String getPractitionerId() { return this.practitioner ; } ;
 public String getReferral_date() { return this.Referral_date ; } ;
 public String getRemarks() { return this.remarks ; } ;
 public String getExistingQueryString(){ return this.qryString;};
 public String getOrderCategory() {  return this.order_category; };
 public String getOrderType() {  return this.order_type; };
 public String getActivity_Type() {  return this.activity_code; };
 public String getActivity_Desc() {  return this.activity_desc; };
public String getOrderCatalogCode(){ return this.order_catalog_code; }
public String getCalledFrom(){ return this.called_from; }
public String getOrderId(){ return this.ohorder_id; }

/**********************END OF GET METHODS********************************/


	
	
	/* Over-ridden Adapter methods start here */
	public HashMap validate() throws Exception {
		
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;

		return map ;
	}

	public HashMap insert() {
	      HashMap map			= new HashMap() ;
	      map.put( "result", new Boolean( false ) ) ;
   	      return map ;
	} // end of insert



	public HashMap modify() {

      HashMap map = new HashMap() ;
      map.put( "result", new Boolean( false ) ) ;

		return map ;
	} // end of modify

	public void clear() {
		patientId = null;
		facility = null;
		 practitioner = null;
		 Referral_date = null;
		 remarks = null;
		 order_category = null;
		 order_type = null;
		 activity_code=null;
		activity_desc=null;
		super.clear() ;
	}

//to Populate the patient name and age

public ArrayList getPatientName(String patient_id)throws Exception{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER1") ) ;
			pstmt.setString( 1, language_id ) ;
			pstmt.setString( 2, patient_id.trim() ) ;
          	resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
					String[] record = new String[4];
					record[0] = resultSet.getString( "patient_name" )  ;
					record[1] = resultSet.getString( "sex_default" )  ;
					record[2] = resultSet.getString( "age" )  ;
					record[3] = resultSet.getString( "date_of_birth" )  ;
					OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return OrderCat;
	}


//will be called on to populate referral facility listbox

public ArrayList getfacility()throws Exception{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_EXTERNAL_ORDERS_REFERRAL_SELECT") ) ;
				pstmt.setString( 1, language_id);
				resultSet = pstmt.executeQuery() ;
				while ( resultSet != null && resultSet.next() ) {
					String[] record = new String[5];
					record[0] = resultSet.getString( "referral_code" )  ;
					record[1] = resultSet.getString( "long_desc" )  ;
					record[2] = resultSet.getString( "source_use_at_lb_ord_yn" )  ;
					record[3] = resultSet.getString( "source_use_at_rd_ord_yn" )  ;
					record[4] = resultSet.getString( "applicability_for_direct_ord" )  ;
					OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return OrderCat;
	}

	public ArrayList getOrderCat()
		{
			ArrayList orderCat = new ArrayList();
			Vector shDesc = new Vector(); // for storing all the short descriptions of patients
			Vector ordCat = new Vector(); // for storing all the patient classes

			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			String desc = "";
			String category = "";
			String SQL_OR_EXTERNAL_ORDERS_ORDER_CAT_SELECT="";

		try{
			SQL_OR_EXTERNAL_ORDERS_ORDER_CAT_SELECT = OrRepositoryExt.getOrKeyValue("SQL_OR_EXTERNAL_ORDERS_ORDER_CAT_SELECT");
			connection = getConnection();
			preparedStatement = connection.prepareStatement(SQL_OR_EXTERNAL_ORDERS_ORDER_CAT_SELECT);
			preparedStatement.setString( 1, language_id);

			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				desc = resultSet.getString("short_desc");
				category = resultSet.getString("order_category");
				shDesc.add(desc);
				ordCat.add(category);
			}
		
			orderCat.add(shDesc);
			orderCat.add(ordCat);

		}catch(SQLException sqle)
		{
			System.err.println(sqle.getMessage());
			sqle.printStackTrace();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		finally
		{  //freeing the memory by closing the connections and resultsets which are opened
			try{
			closeResultSet( resultSet ) ;
			closeStatement( preparedStatement ) ;
			closeConnection( connection );
			}catch(Exception e)
			{
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}

		return orderCat; //returning the ArrayList Object which contains all the patient details
	}


	public ArrayList getOrderTypes(String order_category)
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderTypes = new ArrayList() ;
		//System.err.println("Size @@@@@@@@@@@@@@@@@@@@@@@@ " + OrderTypes.size());

		//OrderTypes.ensureCapacity(0);

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SELECT_ORDER_TYPE") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, order_category.trim() ) ;
          	resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
					OrderTypes.add((String )resultSet.getString("short_desc")) ;
					OrderTypes.add((String )resultSet.getString("order_type_code")) ;
			}

		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
		} finally {
			try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
			}catch(Exception e){
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}
		//System.err.println("from External Orders  @@@@@@@@ " + OrderTypes);
		return OrderTypes;
	}

	public ArrayList getActivityType(String order_category, String order_type)
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList ActivityType		= new ArrayList() ;
 
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ACTIVITY_TYPE_SELECT") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, order_category.trim() ) ;
			pstmt.setString( 3, order_type.trim() ) ;
			//pstmt.setString( 4, language_id);
			//pstmt.setString( 5, order_category.trim() ) ;
			
          	resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
					ActivityType.add((String )resultSet.getString("activity_type")) ;
					ActivityType.add((String )resultSet.getString("short_desc")) ;
 			}

		} catch ( Exception e )	{
			System.err.println( "Error loading values from database activity" ) ;
			e.printStackTrace() ;
		} finally {
			try{
		 		closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}catch(Exception e){
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
 		}
 		return ActivityType;
	}

    public ArrayList getPractitioner(String ref_facility_id)
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList PractTypes = new ArrayList() ;
	 
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_EXTERNAL_ORDERS_PRACTITIONER_SELECT") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, ref_facility_id.trim() ) ;
          	resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
					String[] record = new String[2];
					record[0] = resultSet.getString( "practitioner_id" )  ;
					record[1] = resultSet.getString( "short_name" )  ;
					PractTypes.add(record) ;
			}
			 

		} catch ( Exception e )	{
			System.err.println( "Error loading values from database Practitioner" ) ;
			e.printStackTrace() ;
		} finally {
			try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
			}catch(Exception e){
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}
 
		return PractTypes;
	}
	
	public String[] getCatalogNatureOrderType(String order_catalog_code) throws Exception 
	{
 		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
 		ResultSet resultSet 		= null;
		String[] CatalogNatureOrderType = new String[2];
 		try
 		{
			connection = getConnection();
 			pstmt			= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_EXTERNAL_ORDER_CATALOG_NATURE_ORDER_TYPE") ) ;
			pstmt.setString(1,order_catalog_code);
  			resultSet		= pstmt.executeQuery() ;
  			if(resultSet!=null) // Only One Record
			{
 				while (resultSet.next() ) {
  					CatalogNatureOrderType[0]= resultSet.getString("order_catalog_nature");
  					CatalogNatureOrderType[1]= resultSet.getString("order_type_code");
				}
			}
 		 }catch ( Exception e )
		{
 			System.err.println( "Error loading values from database getCatalogNature" +e) ;
 			e.printStackTrace() ;
 			return null;
 		 } 
		 finally 
		{
  			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
 		}
		return CatalogNatureOrderType;
	} // end of the getCatalogNatureOrderType

	public ArrayList getReferralData(String referral_code)throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList referralData = new ArrayList() ;

		try 
		{
			connection = getConnection();
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_EXTERNAL_ORDERS_REFERRAL_DETAILS") ) ;
			pstmt.setString( 1, referral_code);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) 
			{
				String[] record = new String[3];
				record[0] = resultSet.getString( "source_use_at_lb_ord_yn" )  ;
				record[1] = resultSet.getString( "source_use_at_rd_ord_yn" )  ;
				record[2] = resultSet.getString( "applicability_for_direct_ord" )  ;
				referralData.add(record) ;
			}

		} 
		catch ( Exception e )	
		{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return referralData;
	}

}//end of class


