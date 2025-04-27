/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;

import eOR.Common.* ;
import eCommon.Common.*;



public class PlaceOrdersForOthPractBean extends OrAdapter implements java.io.Serializable 
{
	StringBuffer traceVals = new StringBuffer();
	protected Hashtable hashMultiple = new Hashtable();
	eOR.Common.MultiRecordBean multiRecBean  = new eOR.Common.MultiRecordBean();

	protected String allowed_type;
	
	/*********************Constructor *************************/

	public PlaceOrdersForOthPractBean()
	{
		allowed_type	= ""    ;
		try
		{
			doCommon();
		}
		catch(Exception e) 
		{
			e.printStackTrace() ;
		}
	}

	/**********************SET METHODS*************************/
	public void setAllowedType(String allowed_type) {this.allowed_type = allowed_type;};

	/**********************GET METHODS*************************/
	public String getAllowedType() {return this.allowed_type ; };
	
	/*
		This method is called on Click of Apply button, to update the records based on the Allowed Type
		Selected in the header screen and bottom screen.

	*/
	public HashMap insert()
	{
		HashMap map		 = new HashMap() ;
		HashMap tabData	 = new HashMap() ;
		HashMap split	 = new HashMap();

		ArrayList deleteArrList = new ArrayList();
		ArrayList insertArrList = new ArrayList();
		ArrayList allRecords	= new ArrayList();
		Hashtable multiHashData = new Hashtable();

		String valid= "", associate_yn="";
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag","") ;
		
		int total_count	= 0;
		String pract_type = "";
		try
		{
			// If the allowed type is practitioner_type and adding the checked records from hashmultiple
			if(allowed_type.equals("T"))
			{
				total_count = Integer.parseInt((String)hashMultiple.get("tot_count"));
				
				for(int i=0;i<total_count;i++)
				{
					pract_type = (String) hashMultiple.get("pract_type"+i);
					if(!pract_type.equals(""))
					{
						insertArrList.add(pract_type);
					}
				}
			}
			// Getting all the Associated records from the multirecord bean for the other allowed types
			else
			{
				allRecords = multiRecBean.getAllDBRecords();
				// If Associated Records size is greater than Zero
				if(allRecords.size()>0)
				{
					for(int j=0;j<allRecords.size();j++)
					{
						split			= (HashMap)allRecords.get(j);
						valid			= (String) split.get("valid");
						associate_yn	= (String) split.get("associate_yn");
						if(valid.equals("Y"))
						{
							if(associate_yn.equals("D"))
							{
								deleteArrList.add(split);
							}
						}
						else if(valid.equals("N"))
						{
							if(associate_yn.equals("Y"))
							{
								insertArrList.add(split);
							}
						}
					}
				}
				// Else displaying error message to the user and suspending the operation
				else
				{
					map.put( "result", new Boolean( false ) ) ;
					if(allowed_type.equals("P"))
					{
						map.put( "message","ATLEAST_ONE_PRACTITIONER");
					}
					else if(allowed_type.equals("T"))
					{
						map.put( "message","ATLEAST_ONE_PRACTITIONER_TYPE");
					}
					else if(allowed_type.equals("R"))
					{
						map.put( "message","ATLEAST_ONE_RESPONSIBILITY");
					}
					return map;	
				}
			}

			multiHashData.put("allowed_type",allowed_type);
			multiHashData.put("login_by_id", login_by_id);
			multiHashData.put("login_at_ws_no",login_at_ws_no);
			multiHashData.put("login_facility_id",login_facility_id);
			// Setting the values in the tabdata which is passed to EJB for updation in the DB
			tabData.put("multiHashData",multiHashData);
			tabData.put("deleteArrList",deleteArrList);
			tabData.put("insertArrList",insertArrList);
			tabData.put("properties", (Properties)getProperties());

			HashMap sqlMap = new HashMap();
			// Queries
			sqlMap.put("SQL_OR_PLACE_ORDER_FOR_OTH_PRACT_DELETE", OrRepositoryExt.getOrKeyValue("SQL_OR_PLACE_ORDER_FOR_OTH_PRACT_DELETE") );
			sqlMap.put("SQL_OR_PLACE_ORDER_FOR_OTH_PRACT_INSERT", OrRepositoryExt.getOrKeyValue("SQL_OR_PLACE_ORDER_FOR_OTH_PRACT_INSERT") );
			sqlMap.put("SQL_OR_PLACE_ORDER_FOR_OTH_PRACT_TYPE_DELETE", OrRepositoryExt.getOrKeyValue("SQL_OR_PLACE_ORDER_FOR_OTH_PRACT_TYPE_DELETE") );
			// Locating the EJB
			map=PlaceOrderForOtherPractitioner(tabData,sqlMap);
			
		}
		catch (Exception e)
		{
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage()) ;
			e.printStackTrace() ;
		}
		finally
		{
			clear();
		}
		return map;
	}

	public HashMap PlaceOrderForOtherPractitioner(HashMap tabDataParam,HashMap sqlMap)throws Exception
	{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		PreparedStatement pstmt_del = null ;

		StringBuffer messages = new StringBuffer() ;
		StringBuffer traceVal = new StringBuffer() ;
		
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		boolean insert_flag = false ;
		boolean delete_flag = false ;
		
		String allowed_type				= "";
		String login_by_id				= "";
		String login_at_ws_no			= "";
		String login_facility_id		= "";

		int [] insertCounts ;
		int [] deleteCounts ;

		String SQL_OR_PLACE_ORDER_FOR_OTH_PRACT_INSERT		= (String) sqlMap.get("SQL_OR_PLACE_ORDER_FOR_OTH_PRACT_INSERT");
		String SQL_OR_PLACE_ORDER_FOR_OTH_PRACT_DELETE		= (String) sqlMap.get("SQL_OR_PLACE_ORDER_FOR_OTH_PRACT_DELETE");
		String SQL_OR_PLACE_ORDER_FOR_OTH_PRACT_TYPE_DELETE = (String) sqlMap.get("SQL_OR_PLACE_ORDER_FOR_OTH_PRACT_TYPE_DELETE");

		ArrayList deleteArrList	= null;
		ArrayList insertArrList = null;
		Hashtable hashHdrData	= null;
		String    pract_type    = null;

		insertArrList			= (ArrayList)tabDataParam.get("insertArrList");
		deleteArrList			= (ArrayList)tabDataParam.get("deleteArrList");
		hashHdrData				= (Hashtable)tabDataParam.get("multiHashData");
		
		allowed_type			= (String)hashHdrData.get("allowed_type");
		login_by_id				= (String)hashHdrData.get("login_by_id");
		login_at_ws_no			= (String)hashHdrData.get("login_at_ws_no");
		login_facility_id		= (String)hashHdrData.get("login_facility_id");
		
		try 
		{
			connection = getConnection() ;
		}
		catch(Exception Exp)
		{
			System.err.println( "Error in getting the query : "+Exp ) ;
			map.put( "message", Exp.getMessage() ) ;
		}

		try
		{
			 if(insertArrList.size() >0)
				insert_flag = false;
			else
				insert_flag = true;

			if(deleteArrList.size() >0)
				delete_flag = false;
			else
				delete_flag = true;
			
			// deleting the records for the pract type as this is not the record bean
			if(allowed_type.equals("T"))
			{
				try
				{
					pstmt_del = connection.prepareStatement(SQL_OR_PLACE_ORDER_FOR_OTH_PRACT_TYPE_DELETE);
					pstmt_del.setString(1,allowed_type);
					pstmt_del.execute();
					closeStatement( pstmt_del ) ;
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
				
			}

			if(insertArrList.size() >0)
			{
				// Inserting the records
				pstmt = connection.prepareStatement(SQL_OR_PLACE_ORDER_FOR_OTH_PRACT_INSERT);
				HashMap tabData  = new HashMap();

				for(int k=0 ; k < insertArrList.size() ; k++)
				{
					if(allowed_type.equals("T"))
					{
						pract_type = (String)insertArrList.get(k);
						pstmt.setString(2 ,pract_type);
					}
					else
					{
						tabData  = (HashMap)insertArrList.get(k);
						pstmt.setString(2 ,(String)tabData.get("code"));
					}
					pstmt.setString(1,allowed_type);
					pstmt.setString(3 ,login_by_id);
					pstmt.setString(4 ,login_at_ws_no);
					pstmt.setString(5 ,login_facility_id);
					pstmt.setString(6 ,login_by_id);
					pstmt.setString(7 ,login_at_ws_no);
					pstmt.setString(8 ,login_facility_id);
					pstmt.addBatch();
					
				}
				tabData.clear();
				insertCounts = pstmt.executeBatch();
				
				for (int i=0;i<insertCounts.length ;i++ )
				{
					if(insertCounts[i]<0 && insertCounts[i]!=-2)
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
			// Deleting the records, if any, for practitioner or responsibility
			if(insert_flag && deleteArrList.size() >0 )
			{
				pstmt_del	= connection.prepareStatement(SQL_OR_PLACE_ORDER_FOR_OTH_PRACT_DELETE);
				HashMap delMapData  = new HashMap();
				for(int k=0 ; k < deleteArrList.size() ; k++)
				{
					delMapData  = (HashMap)deleteArrList.get(k);
					pstmt_del.setString(1 ,allowed_type);
					pstmt_del.setString(2 ,(String)delMapData.get("code"));
					pstmt_del.addBatch();
					
				}
				delMapData.clear();
				deleteCounts = pstmt_del.executeBatch();
				for (int i=0;i<deleteCounts.length ;i++ )
				{
					if(deleteCounts[i]<0 && deleteCounts[i] != -2)
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

			if(insert_flag && delete_flag)
			{
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				messages.append(getMessage(language_id,"RECORD_INSERTED", "SM")) ;
			}
			else
			{
				connection.rollback();
				map.put( "result", new Boolean( false ) ) ;
				messages.append( getMessage(language_id,"ERROR_INSERTING", "SM"));
			}
		}
		catch(Exception e)
		{
			traceVal.append(e.getMessage());
			map.put( "result", new Boolean( false ) ) ;
			map.put( "traceVal", traceVal.toString() ) ;
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				closeStatement( pstmt ) ;
				closeStatement( pstmt_del ) ;
				closeConnection( connection );
				deleteArrList.clear();
				insertArrList.clear();
				hashHdrData.clear();
			}
			catch ( Exception fe ) 
			{
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
				traceVal.append(fe.getMessage());
				map.put( "traceVal", traceVal.toString() ) ;
				fe.printStackTrace();
			}
		}
	map.put( "message", messages.toString() ) ;
	map.put( "traceVal", traceVal.toString() ) ;
	
	return map ;
	}
	public void setAll( Hashtable recordSetMultiple ) 
	{
		try
		{
			setMode((String)recordSetMultiple.get("mode"));
			hashMultiple = recordSetMultiple ;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public HashMap validate() throws Exception 
	{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map ;
	}

	public void clear() 
	{
		allowed_type = "";
		super.clear() ;
	}

	public HashMap modify()
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}
 
	public HashMap delete()
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "delete failure.." );
		return map;
	 }

	 /*********************doCommon METHOD *************************/

	 private void doCommon() throws Exception {
	 }

	 /*********************loadData METHOD *************************/
	 public void loadData() throws Exception {
	 }
	
	/*
		This method is called on Click of Select/Associate tabs in the middle Frame
		To display the records which is already updated/inserted in the DB
	*/
	public int fetchDBRecords()throws Exception 
	{
		Connection connection = null ;
		PreparedStatement pstmt=null;
		HashMap htMapRecord = null;
		ResultSet rs=null;
		int total_rec =0;
		String SQL_QUERY="", code="", long_desc="" ;
		try
		{
			// Getting the size from multirecord bean
			int checkRec = multiRecBean.getSize("DB");
			if(checkRec==0)
			{
				connection = getConnection();
				// Query based on the Allowed Type selected
				if(allowed_type.equals("P"))
				{
					SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_OR_PLACE_ORDER_GET_PRACTITIONER");
				}
				else if(allowed_type.equals("R"))
				{
					SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_OR_PLACE_ORDER_GET_RESPONSIBILITY");
				}
				pstmt = connection.prepareStatement(SQL_QUERY);
				pstmt.setString(1,allowed_type);
				// executing the query
				rs = pstmt.executeQuery();
				if(rs != null)
				{
					while(rs.next())
					{
						code					=	rs.getString("code");
						long_desc				=	rs.getString("long_desc");
						if(long_desc == null || long_desc.equals("null"))long_desc="";
						htMapRecord				=	new HashMap();
						htMapRecord.put("code"			,	code);
						htMapRecord.put("long_desc"		,	long_desc);
						htMapRecord.put("valid"			,	"Y");
						htMapRecord.put("associate_yn"	,   "N");
						htMapRecord.put("status"		,   "N");
						multiRecBean.putObject(htMapRecord);
					}
				}
			}
			total_rec = multiRecBean.getSize("DB");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		finally
		{
			try
			{
				closeResultSet( rs ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		return total_rec;
	}
	/*
		This method is called on Click of Alphabets in the middle Frame
		to display the records based on the Alphabet selected
	*/
	public Object getRecordSet(String index)throws Exception
	{
		Connection connection = null ;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try
		{
			java.util.HashMap htRecord = null;
			String  long_desc="", SQL_QUERY="", code="";
			connection = getConnection();

			multiRecBean.clearSelectRec();
			// Query based on the allowed type selected
			if(allowed_type.equals("P"))
			{
				if(!(index.equals("OTH")))
				{
					SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_OR_PLACE_ORDER_GET_PRACTITIONER_DESC");
				}
				else
				{
					SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_OR_PLACE_ORDER_GET_PRACTITIONER_DESC_OTH");
				}
			}
			else if(allowed_type.equals("R"))
			{
				if(!(index.equals("OTH")))
				{
					SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_OR_PLACE_ORDER_GET_RESPONSIBILITY_DESC");
				}
				else
				{
					SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_OR_PLACE_ORDER_GET_RESPONSIBILITY_DESC_OTH");
				}
			}
			pstmt = connection.prepareStatement(SQL_QUERY);
			if(!(index.equals("OTH")))
			{
				pstmt.setString(1,index+"%");
			}
			// executing the query
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					code				=	rs.getString("code");
					long_desc			=	rs.getString("long_desc");
					if(long_desc == null || long_desc.equals("null"))long_desc="";
					htRecord			=	new HashMap();
					htRecord.put("code"			,	code);
					htRecord.put("long_desc"	,	long_desc);
					htRecord.put("valid"		,	"N");
					htRecord.put("associate_yn" ,   "N");
					htRecord.put("status"		,	"N");
					multiRecBean.putListObject(htRecord);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		finally
		{
			try
			{
				closeResultSet( rs ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		return multiRecBean;
	}
	

	/*
		This method returns all the practitioner types
	*/
	public ArrayList getPractTypes() throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList practTypes		= new ArrayList();
		String[] practRecords		= null;
		
		try
		{
			connection = getConnection();
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_DEPT_ONLY_CATALOG_APPL_GET_PRACT_TYPE")) ;
			resultSet = pstmt.executeQuery();

			while(resultSet !=null && resultSet.next())
			{
				practRecords	= new String[2];
				practRecords[0] = resultSet.getString("CODE");
				practRecords[1] = resultSet.getString("LONG_DESC");
				practTypes.add(practRecords);
			}
		}
		catch(Exception e)
		{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		return practTypes;
	}

	/*
		This method returns all the selected practitioner types
	*/
	public ArrayList getSelectedPractTypes(String allowed_type) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList practTypes		= new ArrayList();
		
		try
		{
			connection = getConnection();
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_PLACE_ORDER_GET_SELECTED_PRACT_TYPES")) ;
			pstmt.setString(1,allowed_type);
			resultSet = pstmt.executeQuery();

			while(resultSet !=null && resultSet.next())
			{
				practTypes.add((String)resultSet.getString("CODE").trim());
			}
		}
		catch(Exception e)
		{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		return practTypes;
	}


	public Object getBean()
	{
		return this.multiRecBean;
	}

	public boolean clearDBRec()throws Exception
	{
		boolean clearFlag = false;
		clearFlag = multiRecBean.clearDBRec();
		return clearFlag;
	}
}
