/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.ORIndexTickSheet;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import javax.ejb.* ;
import eOR.Common.* ;

/**
*
* @ejb.bean
*	name="ORIndexTickSheet"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORIndexTickSheet"
*	local-jndi-name="ORIndexTickSheet"
*	impl-class-name="eOR.ORIndexTickSheet.ORIndexTickSheetManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORIndexTickSheet.ORIndexTickSheetLocal"
*	remote-class="eOR.ORIndexTickSheet.ORIndexTickSheetRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORIndexTickSheet.ORIndexTickSheetLocalHome"
*	remote-class="eOR.ORIndexTickSheet.ORIndexTickSheetHome"
*	generate= "local,remote"
*
*
*/

public class ORIndexTickSheetManager extends OrEJBSessionAdapter {
	//SessionContext context ;
	//StringBuffer messages = new StringBuffer() ;
	//StringBuffer traceVal = new StringBuffer() ;

	//Connection connection = null ;
	//PreparedStatement pstmt = null ;
	//PreparedStatement pstmt_del = null ;

/**
* @ejb.interface-method
*	 view-type="both"
*/

    public HashMap insert( HashMap tabDataParam, HashMap sqlMap ) 
	{
		HashMap map = new HashMap() ;
		StringBuffer messages = new StringBuffer() ;
		StringBuffer traceVal = new StringBuffer() ;

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		PreparedStatement pstmt_del = null ;
		map.put( "result", new Boolean( false ) ) ;
		//map.put( "flag", "insert" ) ;
		boolean insert_flag = false ;
		boolean delete_flag = false ;
		
		String order_category			= "";
		String tick_sheet_id			= "";
		String index_type				= "";
		String facility_id				= "";
		String source_type				= "";
		String multiRec					= "";

		String login_by_id				= "";
		String login_at_ws_no			= "";
		String login_facility_id		= "";

		int [] insertCounts ;
		int [] deleteCounts ;
		int insSourceCount = 0;
			
		String SQL_OR_INDEX_TICK_SHEET_INSERT = (String) sqlMap.get("SQL_OR_INDEX_TICK_SHEET_INSERT");
		String SQL_OR_INDEX_TICK_SHEET_DELETE = (String) sqlMap.get("SQL_OR_INDEX_TICK_SHEET_DELETE");
		String SQL_OR_INDEX_TICK_SHEET_REC_CNT = (String) sqlMap.get("SQL_OR_INDEX_TICK_SHEET_REC_CNT");	
			
		//traceVal.append(SQL_OR_INDEX_TICK_SHEET_DELETE);
			
		ArrayList deleteArrList	= new ArrayList();
		ArrayList insertArrList = new ArrayList();

		Hashtable HashHdrData			= new Hashtable();

		insertArrList			= (ArrayList)tabDataParam.get("insertArrList");
		deleteArrList			= (ArrayList)tabDataParam.get("deleteArrList");
		HashHdrData				= (Hashtable)tabDataParam.get("MultiHashData");

		///traceVal.append(HashHdrData.toString());
		///traceVal.append(insertArrList.toString());

		order_category			= (String)HashHdrData.get("order_category");
		tick_sheet_id			= (String)HashHdrData.get("tick_sheet_id");
		index_type				= (String)HashHdrData.get("index_type");
		facility_id				= (String)HashHdrData.get("facility_id");
		source_type				= (String)HashHdrData.get("source_type");
		multiRec				= (String)HashHdrData.get("multiRec");
	
		login_by_id			= (String)HashHdrData.get("login_by_id");							
		login_at_ws_no		= (String)HashHdrData.get("login_at_ws_no");
		login_facility_id		= (String)HashHdrData.get("login_facility_id");
		boolean status 	= true;

		try 
		{
			connection				= getConnection((Properties)tabDataParam.get( "properties" )) ;
		}catch(Exception Exp)
		{
			throw new EJBException( Exp.getMessage() ) ;
		}
		try
		{
			if(!multiRec.equals("A"))
			{
				if(insertArrList.size() >0)
					insert_flag = false;
				else
					insert_flag = true;
				if(deleteArrList.size() >0)
					delete_flag = false;
				else
					delete_flag = true;
				if(insertArrList.size()>0)
				{
					pstmt					= connection.prepareStatement(SQL_OR_INDEX_TICK_SHEET_INSERT);
					HashMap tabData  = new HashMap();
					for(int k=0 ; k < insertArrList.size() ; k++)
					{
						tabData  = (HashMap)insertArrList.get(k);						 
						//status 	= validateDuplicateCheck(connection,order_category,tick_sheet_id,index_type,(String)tabData.get("code"),facility_id,source_type,SQL_OR_INDEX_TICK_SHEET_REC_CNT);
						pstmt.setString(1 , order_category);
						pstmt.setString(2 , tick_sheet_id);
						pstmt.setString(3 , index_type);
						if(index_type.equals("F"))
						{
							pstmt.setString(4 , facility_id);
							pstmt.setString(5 , source_type);
						}else
						{
							pstmt.setNull(4 , java.sql.Types.NUMERIC);
							pstmt.setNull(5 , java.sql.Types.NUMERIC);
						}
						if((multiRec.equals("C")) || (multiRec.equals("N")))
							pstmt.setString(6 , (String)tabData.get("code"));
						else
							pstmt.setNull(6 , java.sql.Types.NUMERIC);
						if(multiRec.equals("P"))
							pstmt.setString(7 , (String)tabData.get("code"));
						else
							pstmt.setNull(7 , java.sql.Types.NUMERIC);
						if(multiRec.equals("S"))
							pstmt.setString(8 , (String)tabData.get("code"));
						else
							pstmt.setNull(8 , java.sql.Types.NUMERIC);						
						pstmt.setString(9  , login_by_id);
						pstmt.setString(10 , login_at_ws_no);
						pstmt.setString(11 , login_facility_id);
						pstmt.setString(12 , login_by_id);
						pstmt.setString(13 , login_at_ws_no);
						pstmt.setString(14 , login_facility_id);						
						//updatedCounts = pstmt.executeUpdate();	
						pstmt.addBatch();
					}	
					insertCounts = pstmt.executeBatch();
					//traceVal.append("insertCount's Count:*** "+insertCounts.length );								
					for (int i=0;i<insertCounts.length ;i++ )
					{
						if(insertCounts[i]<0  && insertCounts[i] != -2 )
						{
							insert_flag=false;
							break;
						}
						else
						{
							insert_flag=true;
						}
					}
				}	
				
				//traceVal.append("insert_flag:*** "+insert_flag);

				//traceVal.append("SQL_OR_INDEX_TICK_SHEET_DELETE :"+SQL_OR_INDEX_TICK_SHEET_DELETE);

				if(insert_flag && deleteArrList.size() >0 )
				{
					pstmt_del	= connection.prepareStatement(SQL_OR_INDEX_TICK_SHEET_DELETE);
					HashMap delMapData  = new HashMap();	
					for(int k=0 ; k < deleteArrList.size() ; k++)
					{
						delMapData  = (HashMap)deleteArrList.get(k);
						pstmt_del.setString(1 , order_category);
						pstmt_del.setString(2 , tick_sheet_id);
						if(multiRec.equals("P") || multiRec.equals("S"))
						{
							pstmt_del.setString(3 ,(String)delMapData.get("code"));
						}
						else if(multiRec.equals("N") || multiRec.equals("C"))
						{
							pstmt_del.setString(3 , facility_id);
							pstmt_del.setString(4 , multiRec);
							pstmt_del.setString(5 , (String)delMapData.get("code"));
						}
						pstmt_del.addBatch();
					}

				deleteCounts = pstmt_del.executeBatch();
				//traceVal.append("deleteCounts's Count:*** "+deleteCounts.length );
				
				closeStatement(pstmt_del);
				for (int i=0;i<deleteCounts.length ;i++ )
				{
					if(deleteCounts[i]<0  && deleteCounts[i] != -2 )
					{
						delete_flag=false;
						break;
					}
					else
					{
						delete_flag=true;
					}
				}
			}
			
			//traceVal.append("delete_flag:*** "+delete_flag);
			
		}
		else if(multiRec.equals("A"))
		{
			status 	= validateDuplicateCheck(connection,order_category,tick_sheet_id,index_type,"*ALL",facility_id,"A",SQL_OR_INDEX_TICK_SHEET_REC_CNT);
			if(status)
			{
				map.put( "result", new Boolean( false ) ) ;	
				connection.rollback();
				map.put( "message", "Record already exists" ) ;
				messages.append( "RECORD_ALREADY_EXISTS" ) ;
				map.put( "msgid", messages.toString() ) ;
				return map;
			}
			else
			{
				pstmt					= connection.prepareStatement(SQL_OR_INDEX_TICK_SHEET_INSERT);
			
				pstmt.setString(1 , order_category);
				pstmt.setString(2 , tick_sheet_id);
				pstmt.setString(3 , index_type);
				pstmt.setString(4 , facility_id);
				pstmt.setString(5 , "A");
				pstmt.setString(6 , "*ALL");
				pstmt.setNull(7 , java.sql.Types.NUMERIC);
				pstmt.setNull(8 , java.sql.Types.NUMERIC);
				pstmt.setString(9  , login_by_id);
				pstmt.setString(10 , login_at_ws_no);
				pstmt.setString(11 , login_facility_id);
				pstmt.setString(12 , login_by_id);
				pstmt.setString(13 , login_at_ws_no);
				pstmt.setString(14 , login_facility_id);
			
				try
				{
					insSourceCount = pstmt.executeUpdate();	
				}catch(Exception eSrc)
				{
					traceVal.append(eSrc.getMessage());
					map.put( "traceVal", traceVal.toString() ) ;
				}
			}
			if(insSourceCount > 0)
			{
				insert_flag = true;
				delete_flag = true;
			}
		}
		if(insert_flag && delete_flag)
		{

			//traceVal.append("abt to commit");
			connection.commit();
			map.put( "result", new Boolean( true ) ) ;
			messages.append( "RECORD_INSERTED" ) ;
		}
		else
		{
			connection.rollback();
			map.put( "result", new Boolean( false ) ) ;
			throw new EJBException("Insert/Update Failed");		
		}
	}
	catch(Exception e)
	{
		traceVal.append(e.getMessage());
		map.put( "traceVal", traceVal.toString() ) ;
	}
	finally
	{
	   try 
		{
		    closeStatement( pstmt ) ;
			closeStatement( pstmt_del ) ;
			closeConnection( connection, (Properties)tabDataParam.get( "properties" ) );
		}catch ( Exception fe ) 
		{
			System.err.println( fe.getMessage() ) ;
			fe.printStackTrace() ;
			traceVal.append(fe.getMessage());
			map.put( "traceVal", traceVal.toString() ) ;
		}
	}
	map.put( "msgid", messages.toString() ) ;
	map.put( "traceVal", traceVal.toString() ) ;
	return map ;
}

/**
* @ejb.interface-method
*	 view-type="both"
*/

	 public HashMap modify( HashMap tabDataParam, HashMap sqlMap )
	{
	
		//StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		return map ;
	}

/**
* @ejb.interface-method
*	 view-type="both"
*/

	 public HashMap delete( HashMap tabDataParam, HashMap sqlMap ) 
	{
		//StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		return map ;
	}
	
	private boolean validateDuplicateCheck(Connection connection,String order_category,String tick_sheet_id,String index_type,String code,String facility_id,String source_type,String sql) throws Exception 
	{
			PreparedStatement pstmt 	= null;
			ResultSet RsltSet 	= null;
			String RecordExists="";
			int cnt = 0;
			if(index_type.equalsIgnoreCase("P"))
			{					
				sql=sql.replace("##FILTER$$"," AND PRACTITIONER_ID =?");	
			}
			else if(index_type.equalsIgnoreCase("S"))
			{
				sql=sql.replace("##FILTER$$"," AND SERVICE_CODE=?");
			}
			else if(index_type.equalsIgnoreCase("F"))
			{		
				sql=sql.replace("##FILTER$$"," AND FACILITY_ID = ? AND SOURCE_TYPE =? AND SOURCE_CODE =?");
			}
		
			try
			{
				pstmt 				=  connection.prepareStatement(sql);
				pstmt.setString(++cnt , order_category);
				pstmt.setString(++cnt , tick_sheet_id);
				pstmt.setString(++cnt , index_type);
				if(index_type.equalsIgnoreCase("P"))
				{					
					pstmt.setString(++cnt , code);
				}
				else if(index_type.equalsIgnoreCase("S"))
				{
					pstmt.setString(++cnt , code);
				}
				else if(index_type.equalsIgnoreCase("F"))
				{		
					pstmt.setString(++cnt , facility_id);
					pstmt.setString(++cnt ,  source_type);	
					pstmt.setString(++cnt , code);
				}
				 RsltSet = pstmt.executeQuery() ;
				 if (RsltSet !=null&& RsltSet.next())
				{
					RecordExists = RsltSet.getString(1);
				}
								
			}catch ( Exception e )	{
				System.err.println( "Prepared Statement for DuplicateCheck" +e.toString()) ;
				e.printStackTrace() ;
				throw e ;
			} finally
			{
				closeResultSet(RsltSet) ;
				closeStatement(pstmt) ;
			}
			if(RecordExists.equals("1"))	//If there are duplicate checks return it as true
				return true;
			else
				return false;
		} // End of the validateDuplicateCheck


}///End of Class
