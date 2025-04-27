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
import javax.ejb.* ;
import eCommon.Common.*;
import javax.rmi.* ;
import javax.naming.* ;
import eOR.Common.* ;
import eCommon.SingleTableHandler.*;
import webbeans.eCommon.*;

public class SectionForTickSheet	  extends OrAdapter implements Serializable 
{
	//StringBuffer messages = new StringBuffer() ;
	//Connection connection = null ;
	//PreparedStatement pstmt = null ;
//  declaration of all properties of class
	protected String order_category_id 	= "" ;
	protected String tick_sheet_id				= "" ;
	protected String section_code				= "" ;
	protected String description					= "" ;
	protected String eff_status 					= "D" ;
	protected Hashtable hashMultiple			=null;
	//protected int total=0;
// setter method for all properties
//return type@ void    parameter @ type of properties

	public void setOrderCategory(String OrderCategory_id)
	{
		order_category_id = OrderCategory_id ;
	}
	public void setTickSheetID(String ticksheet_id)
	{
		this.tick_sheet_id = ticksheet_id;
	}
	public void setSectionCode(String section_code)
	{
		this.section_code = section_code;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
    public void  setEff_status(String  eff_status) 
	{
		  if(eff_status.trim().equals("") )
		 {
			  this.eff_status = "D";
		  }
		  else
		 {
			  this.eff_status=  eff_status;
		  }
	}
// getter method for all properties of class
// return type@ type of properties   parameter@ void or nothing
	public String getOrderCategory()
	{
		return order_category_id;
	}
	public String getTickSheetID()
	{
		return tick_sheet_id;
	}
	public String getSectionCode()
	{
		return section_code;
	}
	public String getDescription()
	{
		return description;
	}
	public String getEffectiveStatus()
	{
		return eff_status;
	}

/**
	This will populate all the order categories with scope of each category
	@return		:	ArrayList     parameter - string type
*/
public  ArrayList getTickSheetSectionTickSheet(String order_category)throws Exception
{
	ArrayList TickSheetSection = new ArrayList() ;
	Connection connection	=null;
	ResultSet resultSet	  	= null;
	java.sql.PreparedStatement pstmt		= null;
	try 
	{
		connection=getConnection() ;
		pstmt	= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_TICK_SHEETS_SECTION"));
		pstmt.setString(1,order_category);
		resultSet		= pstmt.executeQuery();
		//StringBuffer sb			    = new StringBuffer();
		String[] record=null;
		while ( resultSet != null && resultSet.next() ) 
		{
			record = new String[2];
			record[0]=resultSet.getString( "TICK_SHEET_DESC" ) ;
			record[1] = resultSet.getString( "TICK_SHEET_ID" )  ;
			TickSheetSection.add(record) ;
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
		closeResultSet(resultSet);
		closeStatement(pstmt);
		closeConnection(connection) ;
	}
	return TickSheetSection;
}// end of getTickSheetSectionTickSheet method
// getting the order category from the database to fill order category combo at the loading time
// return type @arraylist    parameter - none
public ArrayList getTickSheetSectionOrderCategory () throws Exception 
{
		ArrayList OrderCat = new ArrayList() ;
		Connection connection=null;
		java.sql.ResultSet resultSet=null;
		java.sql.PreparedStatement pstmt = null;
		try 
		{
			connection=	getConnection() ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_TICK_SHEETS_ORD_CAT_SELECT_CODE") ) ;
			//pstmt.setString( 1, language_id);
			if(!(pstmt==null))
			{
				resultSet = pstmt.executeQuery() ;
			}
			String[] record =null;
			while ( resultSet != null && resultSet.next() ) 
			{
				record = new String[2];
				record[0] = resultSet.getString( "ORDER_CATEGORY" )  ;
				record[1] = resultSet.getString( "SHORT_DESC" )  ;
				OrderCat.add(record) ;
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
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}
		return OrderCat;
}// end of  getTickSheetSectionOrderCategory () method
// setall method get called from controller jsp

 public void setAll( Hashtable recordSetMultiple ) 
{
	try
	{

		hashMultiple = recordSetMultiple ;
	//	total=(recordSetMultiple.get("totalRecords"));
		setMode((String)recordSetMultiple.get("mode"));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
 }
// insert method start here putting all sql in sql map that used to check duplicate and insert operation,also put all the data in hash map that used to check duplicate and inert operation
public HashMap insert()
{
	HashMap map = new HashMap() ;
	map.put( "result", new Boolean( false ) ) ;
	map.put( "flag", "true") ;
	ArrayList whereData=new ArrayList();
	ArrayList recordStore = new ArrayList() ;
	HashMap sqlMap = new HashMap();
	try
	{
		sqlMap.put("InsertSQL",(String)OrRepository.getOrKeyValue("SQL_OR_TICK_SHEET_SECTION_INSERT_N"));	sqlMap.put("SelectSQL",(String)OrRepository.getOrKeyValue("SQL_OR_TICK_SHEETS_SECTION_DUPLICATE_CHK"));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	String ID="";
	ArrayList tabData = null;
	ArrayList tabData1 = null ;
	for(int i=0 ; i < 10 ; i++)
	{
		 ID = "tick_sheet_section_sec"  + i ;
		tabData = new ArrayList() ;
		tabData1 = new ArrayList() ;
		if(!(((String)hashMultiple.get(ID)).equals("")||(String)hashMultiple.get(ID)==null))
		{
			tabData.add(((String)hashMultiple.get("order_category_id")).trim());
			//tabData1.add(((String)hashMultiple.get("order_category_id")).trim());
			tabData.add( ((String)hashMultiple.get("tick_sheet_id")).trim()) ;
			tabData1.add( ((String)hashMultiple.get("tick_sheet_id")).trim()) ;
			tabData.add(((String)hashMultiple.get("tick_sheet_section_sec"+ i)).trim()) ;
			tabData1.add(((String)hashMultiple.get("tick_sheet_section_sec"+ i)).trim()) ;
			tabData.add(((String)hashMultiple.get("seq_no"+ i)).trim()) ;
			//tabData1.add(((String)hashMultiple.get("seq_no"+ i)).trim()) ;
			tabData.add(((String)hashMultiple.get("tick_sheet_section_dsec"+ i)).trim() );
			if(((String)hashMultiple.get("eff_status"+i)).equals("")||(String)hashMultiple.get("eff_status"+i)==null)
			{
				tabData.add("D");
			}
			else
			{
				tabData.add("E");
			}
			tabData.add(((String)login_by_id).trim()) ;
	//		tabData.add(added_date.trim()) ;
			tabData.add(((String)login_facility_id).trim()) ;
			tabData.add(((String)login_at_ws_no).trim()) ;
			tabData.add(((String)login_by_id).trim()) ;
		//	tabData.add(modified_date.trim()) ;
			tabData.add((String)login_facility_id.trim()) ;
			tabData.add((String)login_at_ws_no.trim()) ;
//	public static  String SQL_OR_TICK_SHEET_SECTION_INSERT="INSERT INTO or_tick_sheet_section
//(order_category, tick_sheet_id, section_code,section_desc,eff_status,
//added_by_id,added_at_ws_no,added_facility_id,
//modified_by_id,modified_facility_id,modified_at_ws_no,added_date,modified_date) VALUES (?,?,?,?,?,?,?,?,?,?,?,sysdate,sysdate)";
			recordStore.add((ArrayList)tabData);
			whereData.add((ArrayList)tabData1);
		 }
	 }
	HashMap tabDataParam =  new HashMap() ;
	tabDataParam.put( "InsertData", recordStore);
	tabDataParam.put("WhereData",whereData);
	tabDataParam.put( "properties", getProperties() );

// sql used in insert and check for duplicate operation
//INSERT INTO or_tick_sheet_section (order_category, tick_sheet_id, section_code,section_desc,eff_status,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) VALUES (?,?,?,?,?,?,to_date(?,'yyyy-mm-dd hh24:mi:ss'),?,?,?,to_date(?,'yyyy-mm-dd hh24:mi:ss'),?,?)";
//"SELECT section_code FROM OR_TICK_SHEET_SECTION WHERE Order_Category =? and Tick_Sheet_Id = ?  and Section_code IN (?)";
	return getResult(tabDataParam,sqlMap) ;
}// end of insert method

public void clear() 
{
	super.clear();
	 order_category_id 	= "" ;
	 tick_sheet_id				= "" ;
	 section_code				= "" ;
	 description					= "" ;
	 eff_status 					= "E" ;
	 hashMultiple			=null;
}

// method to get the combo string that passed query criteria method to get order category from data base at the loading time

public String getComboString()
{
	Connection 	connection  = null;
	java.sql.PreparedStatement pstmt		= null;
	java.sql.ResultSet rs	= null;
	try 
	{
		connection  = getConnection();
		pstmt						= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_TICK_SHEETS_ORD_CAT_SELECT_CODE"));
		rs							= pstmt.executeQuery();
	    StringBuffer sb			    = new StringBuffer();
		String  codeCol			    = "";
		String  codeDesc			= "";
		while (rs.next())
		{
			codeCol			    = ChkDef.defaultString(rs.getString(1));
			codeDesc			= ChkDef.defaultString(rs.getString(2));
			sb.append(codeDesc + "," + codeCol + ",");
		}
		 String str =   sb.toString() ;
		 sb.setLength(0);
		 return str.substring(0, str.length()-1);
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		return null;
	}
	finally
	{
		try
		{		
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(connection);
		 }
		 catch(Exception e)
		{
			 e.printStackTrace();
		}
	}
}
// start of modify method putting all the in hash map and call get result method
public HashMap modify() 
{
		HashMap dataMap = new HashMap() ;
		ArrayList tabdata = new ArrayList() ;
		String eff_stat;
		tabdata.add(( (String)hashMultiple.get("seq_no")).trim() ) ;
		tabdata.add( ((String)hashMultiple.get("description")).trim() ) ;
		if(((String)hashMultiple.get("eff_status")).equals("") ||( (String)hashMultiple.get("eff_status")==null))
			eff_stat="D";
		else
			eff_stat="E";
		tabdata.add(eff_stat);
		tabdata.add( ((String)hashMultiple.get("order_category")).trim() ) ;
		tabdata.add(((String)hashMultiple.get("tick_sheet_id")).trim() ) ;
		tabdata.add(( (String)hashMultiple.get("section_code")).trim() ) ;
		HashMap sqlMap = new HashMap() ;
		try
		{
			sqlMap.put( "ModifySQL",OrRepository.getOrKeyValue("SQL_OR_TICK_SHEET_SECTION_UPDATE_N") );
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		dataMap.put("properties", getProperties() );
		dataMap.put("ModifyData",tabdata);
//   sql used for modify SQL_OR_TICK_SHEET_SECTION_UPDATE="update or_tick_sheet_section
//   set section_desc = ? ,
//   eff_status =?
//   where order_category =?
//	  and Tick_sheet_id =? and
//     	section_code =?";
		return getResult(dataMap,sqlMap) ;
}// end of modify method
// get result method -> using single table handler class to talk to the server for dml operation
private  HashMap getResult(HashMap tabData , HashMap sqlMap )
{
		String traceVal = "";
		//HashMap retMap  = new HashMap() ;
		HashMap map  = new HashMap() ;
		//SingleTableHandlerHome home = null;
		//SingleTableHandlerRemote remote = null;
	//	traceVal.append("in get result  method and value of mode "+mode);
        map.put( "result", new Boolean( false ) ) ;
        map.put( "flag", "true" ) ;
		try
		{
			/********************LOOK UP*************************/
		/*	InitialContext context = new InitialContext() ;
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
			if(mode.equals(CommonRepository.getCommonKeyValue("MODE_DELETE") ) ) 
			{
				return null ;
			}
			else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) ) 
			{
/*		traceVal += "inside insert with tabsize:"+tabData.size();
			traceVal += "values :::::::::::::";
			ArrayList records	=	(ArrayList) tabData.get("InsertData");
			ArrayList record1	=	(ArrayList) tabData.get("WhereData");
			traceVal+="size of wheredata record"+record1.size()+"::::::";
			traceVal  +="the no of records of insert data    :::"+  records.size();
			ArrayList record	 =  (ArrayList) records.get(0);
			traceVal  +="Value 1:"+ (String) record.get(0);
			traceVal  +="Value 2:"+(String) record.get(1);
			traceVal  +="Value 3:"+(String) record.get(2);
			traceVal  +="Value 4:"+(String) record.get(3);
			traceVal  +="Value 5:"+(String) record.get(4);
			traceVal  +="Value 6:"+(String) record.get(5);
			traceVal  +="Value 7:"+(String) record.get(6);
			traceVal  +="Value 8:"+(String) record.get(7);
			traceVal  +="Value 9:"+(String) record.get(8);
			traceVal  +="Value 10:"+(String) record.get(9);
			traceVal  +="Value 11:"+(String) record.get(10);*/
	//	traceVal  +="Value 12:"+(String) record.get(11);
		//	traceVal  +="Value 13:"+(String) record.get(12);

/*			traceVal   +="sql1:"+(String)  sqlMap.get("InsertSQL");
			traceVal   +="sql2:"+(String)  sqlMap.get("SelectSQL");*/
			//map = remote.singleBatchHandler(tabData,sqlMap);
 				map = (java.util.HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);		
	//		map=remote.insertMultiple(tabData,sqlMap);
//			traceVal=traceVal+" after   <-:->inside  map"+map.toString();
			}
			else if ( mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) )
			{
				// map = remote.modify(tabData, sqlMap ) ;		
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
					//map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
					//System.out.println("===map=="+map);
					/*String invalidCode_1=delimitedString((ArrayList)map.get("invalidCode"));
					String temp="";
					//System.err.println("==invalidCode_1======"+invalidCode_1+"----");	
					StringBuffer invalidCode= new StringBuffer();
					StringTokenizer invalidCode_2=new StringTokenizer(invalidCode_1,",");
					
					while (invalidCode_2.hasMoreTokens())
					{
						temp=invalidCode_2.nextToken();
						StringTokenizer invalidCode_3=new StringTokenizer(temp,":");
						while(invalidCode_3.hasMoreTokens())
						{
							invalidCode_3.nextToken();
							invalidCode_3.nextToken();
							invalidCode.append(invalidCode_3.nextToken());
							invalidCode.append(",");
						}
					}							
					map.put( "invalidCode",invalidCode.substring(0,invalidCode.length()-1)) ;*/
					map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode"))) ;
				}
                else
                    map.put( "message", getMessage(language_id,(String) map.get("msgid"),"Common")) ;
            }
			return map;
	  }
	  catch(Exception e)
	 {
		System.err.println( "Error Calling EJB :" + e ) ;
		map.put( "message", e.getMessage() );
	//	map.put("traceVal",traceVal);
		e.printStackTrace() ;
		return map ;
	  }
	  finally
	  {
		 clear();
			/*try {
				if( remote != null )
					remote.remove() ;
			} catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}*/
			map.put("traceVal",traceVal);
	  }
}
	 // end of get result method

public String[] loadData(ArrayList selectData)throws Exception
{
			if(selectData.size()==0)return null;
	String[] TickSheetSection = new String[3] ;
	Connection connection	=null;
	ResultSet resultSet	  	= null;
	java.sql.PreparedStatement pstmt		= null;
	try 
	{
		connection=getConnection() ;
		pstmt	= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_TICK_SHEET_SECTION_SELECT"));
		pstmt.setString(1,((String)selectData.get(0)).trim());
		pstmt.setString(2,((String)selectData.get(1)).trim());
		pstmt.setString(3,((String)selectData.get(2)).trim());
/*		for(int i=0;i<selectData.size();i++){
				pstmt.setString(i+1,((String)selectData.get(i)).trim());
		}*/

		resultSet		= pstmt.executeQuery();
		if(resultSet != null && resultSet.next())
		{
			TickSheetSection[0]=resultSet.getString( "section_desc" ) ;
			TickSheetSection[1] = resultSet.getString( "eff_status" )  ;
			TickSheetSection[2] = (resultSet.getString( "section_seq_num" ) == null)?"":resultSet.getString( "section_seq_num" );
		}
		return TickSheetSection;

	} 
	catch ( Exception e )	
	{
		System.err.println( "Error loading values from database" ) ;
		e.printStackTrace() ;
		throw e ;
	} 
	finally 
	{
		closeResultSet(resultSet);
		closeStatement(pstmt);
		closeConnection(connection) ;
	}
  }
}
// end of the bean class tick sheet for section
