/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import java.io.*;
import java.util.*;
import java.sql.*;

import eCommon.Common.*;
import javax.rmi.* ;
import javax.naming.* ;
import eOR.Common.* ;
import eCommon.SingleTableHandler.*;

import webbeans.eCommon.*;

public class ClosingProcessOrderBean extends OrAdapter implements java.io.Serializable {

	StringBuffer traceVals = new StringBuffer() ;

	protected String  total_records = "";
	protected String  orderType	= "" ;
	protected Integer unprocess ;
	protected Integer inprocess;
	protected Integer ingoreOrderInHrs;
	protected String  closeRinprReverseChrg;
	protected String  closeInprBilledOrd;
	protected String  closeUnprReverseChrg;
	protected String  closeUnprBilledOrd;
	protected Integer closeUnprFutOrd;
	protected Hashtable allValues = new Hashtable();

	public void setOrderTpye(String order_type){
		this.orderType =order_type ;
	}
	public void setUnprocess(String unproc){

		this.unprocess =new Integer(unproc) ;
	}
	public void setInprocess(String inproc){
		this.inprocess =new Integer(inproc);
	}

	public String  getOrderTpye(){
		return orderType;
	}
	public Integer getUnprocess(){
		return unprocess;
	}

	public Integer getInprocess(){
		return inprocess;
	}
	public Hashtable getAllValues() {
        return allValues;
    }

	public void setTotalRecs(String total_records){	this.total_records = total_records;	}
	public String getTotalRecs(){			return total_records;	}

	public ArrayList getAllOrderCategory() throws Exception {
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 			= null;
	ArrayList OrderCat = new ArrayList() ;

	try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST") ) ;
			pstmt.setString(1,language_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_category" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
		}

		return OrderCat;
	}
	 public ArrayList getClosedOrderType(String order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		if(order_category.equals(""))
			order_category = null;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDERSET_ORDER_TYPE") ) ;
			pstmt.setString( 1, order_category ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_type_code" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return OrderCat;
	}
	public ArrayList getPatientClass() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList arlPatientClass = new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_DISPENSE_PATIENT_CLASS ") ) ;
			pstmt.setString(1, language_id);
			resultSet = pstmt.executeQuery() ;

			String[] record=null;

			while ( resultSet != null && resultSet.next() ) {
				record = new String[2];
				record[0] = resultSet.getString( "patient_class" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;
				arlPatientClass.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return arlPatientClass;
	}

	public ArrayList getPatientClassValues(String order_type) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList PatientClass = new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_CLOSED_PROCESSED_ORDER_SELECT ") ) ;
			pstmt.setString(1, (String)order_type);
			pstmt.setString(2, (String)order_type);
			resultSet = pstmt.executeQuery() ;

			String[] record=null;

			while ( resultSet != null && resultSet.next() ) {
				record = new String[10];
				record[0] = resultSet.getString( "short_desc" )  ;
				record[1] = resultSet.getString( "patient_class" )  ;
				record[2] = resultSet.getString( "elapsed_prd_close_unpr" )  ;
				record[3] = resultSet.getString( "elapsed_prd_close_inpr" )  ;
				record[4] = resultSet.getString( "close_unpr_fut_ord" )  ;
				record[5] = resultSet.getString( "ingore_order_in_hrs" )  ;
				record[6] = resultSet.getString( "close_unpr_billed_ord" )  ;
				record[7] = resultSet.getString( "close_unpr_reverse_chrg" )  ;
				record[8] = resultSet.getString( "close_inpr_billed_ord" )  ;
				record[9] = resultSet.getString( "close_inpr_reverse_chrg" )  ;
				PatientClass.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return PatientClass;
	}

	public ArrayList getAllPatientClassValues(String order_type) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList allPatientClass = new ArrayList();

		try
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_CLOSED_PROCESSED_ORDER_ALL_PATIENT_CLASS_SELECT") ) ;
			pstmt.setString(1, (String)order_type);
			resultSet = pstmt.executeQuery() ;

			String[] record=null;

			while ( resultSet != null && resultSet.next() )
			{
				record = new String[9];
				record[0] = resultSet.getString( "patient_class" )  ;
				record[1] = resultSet.getString( "elapsed_prd_close_unpr" )  ;
				record[2] = resultSet.getString( "elapsed_prd_close_inpr" )  ;
				record[3] = resultSet.getString( "close_unpr_fut_ord" )  ;
				record[4] = resultSet.getString( "ingore_order_in_hrs" )  ;
				record[5] = resultSet.getString( "close_unpr_billed_ord" )  ;
				record[6] = resultSet.getString( "close_unpr_reverse_chrg" )  ;
				record[7] = resultSet.getString( "close_inpr_billed_ord" )  ;
				record[8] = resultSet.getString( "close_inpr_reverse_chrg" )  ;
				allPatientClass.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return allPatientClass;
	}


public void clear()
{
		orderType 	= "" ;
		unprocess			= null ;
		inprocess			=null;


		super.clear() ;
}
public void setAll( Hashtable recordSetMultiple )
{
	allValues = recordSetMultiple;
	if(recordSetMultiple.containsKey("unprocessed"))
				setUnprocess((String)recordSetMultiple.get("unprocessed"));

	if(recordSetMultiple.containsKey("inprocess"))
				setInprocess((String)recordSetMultiple.get("inprocess"));

	if(recordSetMultiple.containsKey("order_type"))
				setOrderTpye((String)recordSetMultiple.get("order_type"));
	setMode((String)recordSetMultiple.get("mode"));
	if(recordSetMultiple.containsKey("totalLength"))
	{
		setTotalRecs((String)recordSetMultiple.get("totalLength"));
	}
	if(recordSetMultiple.containsKey("close_unpr_fut_ord"))
	{
		setCloseUnprFutOrd((Integer)recordSetMultiple.get("close_unpr_fut_ord"));
	}
	if(recordSetMultiple.containsKey("close_unpr_billed_ord"))
	{
		setCloseUnprBilledOrd((String)recordSetMultiple.get("close_unpr_billed_ord"));
	}

	if(recordSetMultiple.containsKey("close_unpr_reverse_chrg"))
	{
		setCloseUnprReverseChrg((String)recordSetMultiple.get("close_unpr_reverse_chrg"));
	}

	if(recordSetMultiple.containsKey("ingore_order_in_hrs"))
	{
		setIngoreOrderInHrs((Integer)recordSetMultiple.get("ingore_order_in_hrs"));
	}
	if(recordSetMultiple.containsKey("close_inpr_billed_ord"))
	{
		setCloseInprBilledOrd((String)recordSetMultiple.get("close_inpr_billed_ord"));
	}
	if(recordSetMultiple.containsKey("close_inpr_reverse_chrg"))
	{
		setCloseRinprReverseChrg((String)recordSetMultiple.get("close_inpr_reverse_chrg"));
	}

 }

private  HashMap getResult(HashMap tabData , HashMap sqlMap ){
		HashMap map  = new HashMap() ;


		try
		{
			/********************LOOK UP*************************/
			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER")) ;
			home		 = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
			remote		 = home.create() ;*/
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"), SingleTableHandlerHome.class, getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]	= new Object[2];
				argArray[0]		= tabData;
				argArray[1]		= sqlMap;
			Class [] paramArray = new Class[2];
				paramArray[0]	= tabData.getClass();
				paramArray[1]	= sqlMap.getClass();

			if(mode.equals(CommonRepository.getCommonKeyValue("MODE_DELETE" )) ) {
				return null ;
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) ) {
				//map = remote.insert(tabData, sqlMap ) ;
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			}else if ( mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
				 //map = remote.modify(tabData, sqlMap ) ;
				 map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			}

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			argArray	= null;
			paramArray	= null;

			String message = (String)map.get("msgid");
		boolean result = ((Boolean) map.get("result")).booleanValue() ;
		 if( result )
		{
			map.put( "result", new Boolean( true ) ) ;
			map.put( "message", getMessage(language_id,(String) map.get("msgid"),"SM") ) ;
		}
        else
		{
			map.put( "result", new Boolean( false ) ) ;
            if( message.equals( "CODE_ALREADY_EXISTS" ) )
			{

				map.put( "message", getMessage(language_id,(String) map.get("msgid"),"Common") ) ;


				map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;


			}
            else
				map.put( "message", getMessage(language_id,(String) map.get("msgid"),"Common")) ;
        }

			map.put("traceVal",traceVals.toString());


	  }catch(Exception e){

		map.put( "message", e.getMessage() );
		e.printStackTrace() ;

	  }
return map;
 }//End of Method





public HashMap modify() {



		ArrayList modifyData = new ArrayList() ;

		HashMap tabdata = new HashMap() ;// here friday i have to look for that bind error
		modifyData.add((Integer) getUnprocess() );
		modifyData.add((Integer)getInprocess() );
		modifyData.add(getOrderTpye()) ;


		HashMap sqlMap = new HashMap() ;
		try{
		sqlMap.put( "ModifySQL", OrRepository.getOrKeyValue("SQL_OR_CLOSED_PROCESSED_ORDER_UPDATE"));
		}catch(Exception e){e.printStackTrace() ;}
		tabdata.put("ModifyData",modifyData);
		tabdata.put("properties", getProperties() );

		return getResult(tabdata,sqlMap) ;
	}

	public HashMap insert_Order() throws Exception
	{
		Connection connection = null ;
		PreparedStatement pstmt_closing_rule_insert = null ;
		PreparedStatement pstmt_closing_rule_select_count = null ;
		PreparedStatement pstmt_closing_rule_update = null ;

		ResultSet rs			= null;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;

		StringBuffer messages = new StringBuffer() ;

		int int_total_records = Integer.parseInt(total_records);
		int total=0;
		int inserted=0;
		try
		{
			connection = getConnection() ;
			connection.setAutoCommit( false ) ;
			for(int i=0; i<int_total_records; i++)
			{
				pstmt_closing_rule_select_count		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_CLOSED_PROCESSED_ORDER_COUNT")) ;
				pstmt_closing_rule_select_count.setString(1,(String)allValues.get("order_type"));
				pstmt_closing_rule_select_count.setString(2,(String)(allValues.get("patient_class"+i)));
				rs  = pstmt_closing_rule_select_count.executeQuery() ;
				while(rs != null && rs.next())
				{
					total = Integer.parseInt(rs.getString("total"));
				}
				closeStatement(pstmt_closing_rule_select_count) ;
				closeResultSet(rs) ;
				if(total>0)
				{
					pstmt_closing_rule_update		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_CLOSED_PROCESSED_ORDER_UPDATE")) ;
					pstmt_closing_rule_update.setString(1,allValues.get("unprocess"+i).toString());
					pstmt_closing_rule_update.setString(2,allValues.get("inprocess"+i).toString());
					pstmt_closing_rule_update.setString(3,login_by_id);
					pstmt_closing_rule_update.setString(4,login_at_ws_no);
					pstmt_closing_rule_update.setString(5,login_facility_id);
					pstmt_closing_rule_update.setString(6,login_by_id);
					pstmt_closing_rule_update.setString(7,login_at_ws_no);
					pstmt_closing_rule_update.setString(8,login_facility_id);				
					pstmt_closing_rule_update.setString(9,allValues.get("close_unpr_fut_ord"+i).toString());
					pstmt_closing_rule_update.setString(10,allValues.get("ingore_order_in_hrs"+i).toString());
					pstmt_closing_rule_update.setString(11,allValues.get("close_unpr_billed_ord"+i).toString());
					pstmt_closing_rule_update.setString(12,allValues.get("close_unpr_reverse_chrg"+i).toString());
					pstmt_closing_rule_update.setString(13,allValues.get("close_inpr_billed_ord"+i).toString());
					pstmt_closing_rule_update.setString(14,allValues.get("close_inpr_reverse_chrg"+i).toString());
					pstmt_closing_rule_update.setString(15,(String)allValues.get("order_type"));
					pstmt_closing_rule_update.setString(16,(String)(allValues.get("patient_class"+i)));
					pstmt_closing_rule_update.executeUpdate() ;
					inserted++;
					closeStatement(pstmt_closing_rule_update) ;
				}
				else
				{
					pstmt_closing_rule_insert = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_CLOSED_PROCESSED_ORDER_INSERT") ) ;
			    	pstmt_closing_rule_insert.setString(1,(String)allValues.get("order_type"));
					pstmt_closing_rule_insert.setString(2,(String)(allValues.get("patient_class"+i)));
					pstmt_closing_rule_insert.setString(3,allValues.get("unprocess"+i).toString());
					pstmt_closing_rule_insert.setString(4,allValues.get("inprocess"+i).toString());
					pstmt_closing_rule_insert.setString(5,login_by_id);
					pstmt_closing_rule_insert.setString(6,login_at_ws_no);
					pstmt_closing_rule_insert.setString(7,login_facility_id);
					pstmt_closing_rule_insert.setString(8,login_by_id);
					pstmt_closing_rule_insert.setString(9,login_at_ws_no);
					pstmt_closing_rule_insert.setString(10,login_facility_id);				
					pstmt_closing_rule_insert.setString(11,allValues.get("close_unpr_fut_ord"+i).toString());
					pstmt_closing_rule_insert.setString(12,allValues.get("ingore_order_in_hrs"+i).toString());
					pstmt_closing_rule_insert.setString(13,allValues.get("close_unpr_billed_ord"+i).toString());
					pstmt_closing_rule_insert.setString(14,allValues.get("close_unpr_reverse_chrg"+i).toString());
					pstmt_closing_rule_insert.setString(15,allValues.get("close_inpr_billed_ord"+i).toString());
					pstmt_closing_rule_insert.setString(16,allValues.get("close_inpr_reverse_chrg"+i).toString());
					pstmt_closing_rule_insert.executeUpdate() ;
					inserted++;
			}
		}

		if(inserted==int_total_records)
		{
			connection.commit();
			map.put( "result", new Boolean( true ) ) ;
			map.put( "message", "Operation Completed Successfully..." ) ;
			messages.append(getMessage(language_id,"RECORD_INSERTED","SM"));
		}else if(inserted==0)
		{
			 connection.rollback();
			 messages.append( "Insert Failed" ) ;
		}
		else
		{
			 connection.rollback();
			 messages.append( "Insert Failed" ) ;
		}

	}
	catch  ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally
	{

		closeStatement(pstmt_closing_rule_insert) ;
		//closeStatement(pstmt_closing_rule_update) ;
		//closeStatement(pstmt_closing_rule_select_count) ;
		//closeResultSet(rs) ;
		closeConnection(connection) ;
	}
		map.put( "message", messages.toString() ) ;
		return map ;
	}

	public HashMap insert()
	{
		HashMap map = new HashMap() ;

        map.put( "result", new Boolean( false ) ) ;
		try{
			map = insert_Order();
		}catch(Exception e){
			map.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;
		}
		return map ;
	}


	/**
	 * @return the ingoreOrderInHrs
	 */
	public Integer getIngoreOrderInHrs()
	{
		return ingoreOrderInHrs;
	}

	/**
	 * @param ingoreOrderInHrs the ingoreOrderInHrs to set
	 */
	public void setIngoreOrderInHrs(Integer ingoreOrderInHrs)
	{
		this.ingoreOrderInHrs = ingoreOrderInHrs;
	}

	/**
	 * @return the closeRinprReverseChrg
	 */
	public String getCloseRinprReverseChrg()
	{
		return closeRinprReverseChrg;
	}

	/**
	 * @param closeRinprReverseChrg the closeRinprReverseChrg to set
	 */
	public void setCloseRinprReverseChrg(String closeRinprReverseChrg)
	{
		this.closeRinprReverseChrg = closeRinprReverseChrg;
	}

	/**
	 * @return the closeInprBilledOrd
	 */
	public String getCloseInprBilledOrd()
	{
		return closeInprBilledOrd;
	}

	/**
	 * @param closeInprBilledOrd the closeInprBilledOrd to set
	 */
	public void setCloseInprBilledOrd(String closeInprBilledOrd)
	{
		this.closeInprBilledOrd = closeInprBilledOrd;
	}

	/**
	 * @return the closeUnprReverseChrg
	 */
	public String getCloseUnprReverseChrg()
	{
		return closeUnprReverseChrg;
	}

	/**
	 * @param closeUnprReverseChrg the closeUnprReverseChrg to set
	 */
	public void setCloseUnprReverseChrg(String closeUnprReverseChrg)
	{
		this.closeUnprReverseChrg = closeUnprReverseChrg;
	}

	/**
	 * @return the closeUnprBilledOrd
	 */
	public String getCloseUnprBilledOrd()
	{
		return closeUnprBilledOrd;
	}

	/**
	 * @param closeUnprBilledOrd the closeUnprBilledOrd to set
	 */
	public void setCloseUnprBilledOrd(String closeUnprBilledOrd)
	{
		this.closeUnprBilledOrd = closeUnprBilledOrd;
	}

	/**
	 * @return the closeUnprFutOrd
	 */
	public Integer getCloseUnprFutOrd()
	{
		return closeUnprFutOrd;
	}

	/**
	 * @param closeUnprFutOrd the closeUnprFutOrd to set
	 */
	public void setCloseUnprFutOrd(Integer closeUnprFutOrd)
	{
		this.closeUnprFutOrd = closeUnprFutOrd;
	}
}//end of class
