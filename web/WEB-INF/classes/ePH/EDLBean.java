/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH;

import java.io.Serializable;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import ePH.Common.*;
import eCommon.Common.*;
import eCommon.SingleTableHandler.*;

/**
 *	EDLBean used to carry out necessary functionality associated with EDL Functionality
 */

public class EDLBean extends PhAdapter implements Serializable {

    protected Hashtable htMultiple ;
    
	public EDLBean() {
        try {
            doCommon();
        }
        catch(Exception e){
			System.out.println("Exception EDLBean in constructor"+e.toString());
		}
    }

   /* Over-ridden Adapter methods start here */

    public void clear() {
        super.clear() ;
    }

    private void doCommon() throws Exception {
    }

	public HashMap fetchValues(String[] strParams, String strQuery) throws Exception
	{
        HashMap hmRecord                    =   new HashMap();
        Connection connection               = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet                 = null;
        ResultSetMetaData resultSetMetaData = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(strQuery);

            if (strParams!=null)
                for (int index=0; index<strParams.length ;index++ )
                    preparedStatement.setString( index+1, strParams[index]);

            resultSet = preparedStatement.executeQuery();
            resultSetMetaData   =   resultSet.getMetaData();

			int iColumnCount = resultSetMetaData.getColumnCount();

			ArrayList[] alValues = new ArrayList[iColumnCount];

			for(int i=0;i<iColumnCount;i++)
			{
				alValues[i] = new ArrayList();
			}

            while(resultSet.next()){
            for (int i=0; i<iColumnCount; i++ )
				alValues[i].add(resultSet.getString(resultSetMetaData.getColumnName(i+1)));
			}

            for (int i=0; i<iColumnCount; i++ )
				hmRecord.put(resultSetMetaData.getColumnName(i+1),alValues[i]);
        }
        catch (Exception exception )    {
            System.err.println("Error loading values from database");
            exception.printStackTrace();
            throw exception;
        }
        finally {
            try{
                closeResultSet(resultSet);
                closeStatement(preparedStatement);
                closeConnection(connection);
            }
            catch(Exception exception) {
                exception.printStackTrace();
            }
        }

		return hmRecord;
	}
	public void setAll( Hashtable htRecordSetMultiple ) 
	{
        htMultiple = htRecordSetMultiple ;
        this.mode =(String)htRecordSetMultiple.get("mode");
	}

	public HashMap insert()
	{
		ArrayList alInsertData = new ArrayList() ;
		ArrayList alWhereData = new ArrayList() ;
		String strTotalRecords = (String)htMultiple.get("totalRecords");
//System.out.println("Inserting in EDL Bean 1111111111111"+htMultiple);
		for(int i=0; i<Integer.parseInt(strTotalRecords);i++)
		{
//System.out.println("entered in For loop ============== "+i);
			String strEDLCode = "EDLCode"  + i ;
			String strEDLDesc = "EDLDescription"  + i ;
			String strEDLSelect = "EDLSelect" + i ;

			ArrayList alInsertRow = new ArrayList() ;
			ArrayList alWhereRow = new ArrayList() ;

			if(htMultiple.get(strEDLSelect) != null && htMultiple.get(strEDLSelect).toString().equals("Y"))
			{
//System.out.println("entered in htMultiple.get(htMultiple.get(strEDLDesc) ============== "+htMultiple.get(strEDLDesc));

				alInsertRow.add((String)htMultiple.get(strEDLCode)) ;
				alInsertRow.add((String)htMultiple.get(strEDLDesc)) ;
				alInsertRow.add((String)htMultiple.get("EDLCode"));
				alInsertRow.add("E") ;


				alInsertRow.add(login_by_id) ;
				alInsertRow.add(login_at_ws_no) ;
				alInsertRow.add(login_facility_id) ;

				alInsertRow.add(login_by_id) ;
				alInsertRow.add(login_at_ws_no) ;
				alInsertRow.add(login_facility_id) ;

				alWhereRow.add((String)htMultiple.get(strEDLCode));

				/* note:-
				The alInsertData and alWhereData should be arraylist of arraylist
				in case of insertMultiple() of SingleTableHandler
				*/
				alInsertData.add(alInsertRow) ;
				alWhereData.add(alWhereRow) ;
			}
		}//for

        HashMap tabData = new HashMap() ;
        tabData.put( "properties", getProperties());
        tabData.put( "InsertData",alInsertData);
        tabData.put( "WhereData",alWhereData);

        HashMap sqlMap = new HashMap() ;
        try{
            sqlMap.put( "SelectSQL",PhRepository.getPhKeyValue("SQL_PH_EDL_CLASSIFICATIONS_SELECT_ROWID") );
            sqlMap.put( "InsertSQL",PhRepository.getPhKeyValue("SQL_PH_EDL_CLASSIFICATIONS_INSERT") );
        }catch(Exception e){
            e.printStackTrace();
        }
	return CallSingleTableHandler( tabData,sqlMap );
	}

	public HashMap modify()
	{
		ArrayList alUpdateData = new ArrayList();

//System.out.println("htMultiple ===== "+htMultiple);
		int iMaxSeqNumber = Integer.parseInt(htMultiple.get("MaxSeqNumber").toString());

		for(int i=1; i<=iMaxSeqNumber;i++)
		{
			if(htMultiple.get("EDLCode"+i) !=null)
			{
				ArrayList alUpdateRow = new ArrayList() ;
				alUpdateRow.add((String)htMultiple.get("EDLDescription"+i));
				alUpdateRow.add(htMultiple.get("eff_status"+i).toString().equals("")?"D":htMultiple.get("eff_status"+i).toString());
				alUpdateRow.add((String)htMultiple.get("EDLCode"+i));
				alUpdateData.add(alUpdateRow);
			}
		}

//System.out.println("alUpdateData ===== "+alUpdateData);
		
		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "ModifyData",alUpdateData);

		HashMap sqlMap = new HashMap() ;

	   try
	   {
			sqlMap.put( "ModifySQL",PhRepository.getPhKeyValue("SQL_PH_EDL_CLASSIFICATIONS_UPDATE"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return CallSingleTableHandler(tabData,sqlMap );
	}

	private  HashMap CallSingleTableHandler(HashMap tabData , HashMap sqlMap )
	{
		HashMap map = new HashMap() ;
	    map.put( "result", new Boolean( false ) ) ;

    try {

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerLocalHome.class,getLocalEJB());
		Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[]=new Object[2];
		argArray[0]=tabData;
		argArray[1]=sqlMap;

		Class[] paramArray=new Class[2];
		paramArray[0]=tabData.getClass();
		paramArray[1]=sqlMap.getClass();

        if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ))  )
		{
		
			map =  (java.util.HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
//System.out.println("Inserting in EDL Bean CallSingleTableHandler insert"+ tabData +" ======= map =====  "+ sqlMap);
		}
		else if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) )
		{
			map=(java.util.HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
		}

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		argArray	= null;
		paramArray	= null;

        if( ((Boolean) map.get( "result" )).booleanValue() )
               map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
        else{
            if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
            {
                map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common")  ) ;
                map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
            }
            else
                map.put( "message", (map.get("msgid"))) ;
            }
        }
        catch(Exception e) {
        System.err.println( "Error Calling EJB classcast : "+e ) ;
        map.put( "message", e.getMessage()+"classcast") ;
        e.printStackTrace() ;
        }
	return map;
	}

	public String getFDAPregnancyCategoryDesc(String category_group_code, String category_code)throws Exception {

       
        Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
      
		String categoryDescription = "";

        try {
            connection = getConnection() ;
           // pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_DETAILS_SELECT5") ) ;
			String qryString = "  SELECT CATEGORY_DESC FROM PH_PREGN_CAT_GROUP_DTL_LANG_VW  WHERE CATEGORY_GROUP_CODE = ? AND CATEGORY_CODE = ? AND LANGUAGE_ID = ?";
            pstmt = connection.prepareStatement(qryString ) ;
            pstmt.setString(1,category_group_code) ;
            pstmt.setString(2,category_code) ;
            pstmt.setString(3,getLanguageId()) ;
            resultSet = pstmt.executeQuery() ;

            if ( resultSet != null && resultSet.next() ) {
				categoryDescription= checkForNull(resultSet.getString("CATEGORY_DESC"));				
			}
        }
		catch ( Exception e ) {
             e.printStackTrace() ;
            throw e ;
        }
		finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
			catch(Exception es){
				es.printStackTrace() ;
            }

        }
		return categoryDescription;
    }
	public ArrayList getPregnancyCategoryDetails(String drug_code)throws Exception {

       
        Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
      
		ArrayList pregnancyCategoryDescription = new ArrayList();

        try {
            connection = getConnection() ;
           // pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_DETAILS_SELECT5") ) ;
			String qryString = "  SELECT PREG_CATEGORY_GROUP_CODE, PREG_CATEGORY_CODE1, PREG_CATEGORY_CODE2, PREG_CATEGORY_CODE3 FROM PH_DRUG  WHERE DRUG_CODE= ?";
            pstmt = connection.prepareStatement(qryString ) ;
            pstmt.setString(1,drug_code) ;
           
            resultSet = pstmt.executeQuery() ;

            if ( resultSet != null && resultSet.next() ) {
				pregnancyCategoryDescription.add(checkForNull(resultSet.getString("PREG_CATEGORY_GROUP_CODE")));	
				pregnancyCategoryDescription.add(checkForNull(resultSet.getString("PREG_CATEGORY_CODE1")));		
				pregnancyCategoryDescription.add(checkForNull(resultSet.getString("PREG_CATEGORY_CODE2")));			
				pregnancyCategoryDescription.add(checkForNull(resultSet.getString("PREG_CATEGORY_CODE3")));				
			}
        }
		catch ( Exception e ) {
             e.printStackTrace() ;
            throw e ;
        }
		finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
			catch(Exception es){
				es.printStackTrace() ;
            }

        }
		return pregnancyCategoryDescription;
    }

	public String getFDACategoryDescription(String category_code){
		//ArrayList fdaCategoryList = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		//Statement stmt = null;
		ResultSet resultSet = null ;
		String sql;
		String categoryDescription = "";

		try {
			connection = getConnection() ;
			//sql = (String) PhRepository.getPhKeyValue("SQL_PH_DRUG_SLIDING_SCALE_TMPL_SELECT");
			sql = "SELECT CATEGORY_GROUP_DESC FROM PH_PREGN_CAT_GROUP_HDR_LANG_VW   WHERE CATEGORY_GROUP_CODE = ? AND LANGUAGE_ID = ?";
			pstmt				= connection.prepareStatement(sql) ;
			pstmt.setString(1, category_code);
			pstmt.setString(2, getLanguageId());

			resultSet = pstmt.executeQuery();

			if  ( resultSet.next() ) {
				categoryDescription = resultSet.getString( "CATEGORY_GROUP_DESC" )  ;
			}					
		}
		catch ( Exception e ) {	
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement(pstmt);
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return categoryDescription;
	} // end function
}
