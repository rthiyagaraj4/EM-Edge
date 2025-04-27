/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package ePH ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
/*import javax.rmi.* ;
import javax.naming.* ;*/
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.DrugItemLink.*;
import javax.servlet.* ;
import javax.servlet.http.*;
import eCommon.SingleTableHandler.*;


public class DrugItemLinkBean extends PhAdapter implements Serializable {

	protected int maxCount	= 0;
	protected ArrayList DataList	= null;

public DrugItemLinkBean() {
        try
		{
         doCommon();
        }
		catch(Exception e) 
		{
		 System.err.println("Exception in constructor"+e.toString());
		}
    }

public int getmaxCount () 
{
	return maxCount;
}

public ArrayList getResult()
{
   return DataList;
}

public void modifyResult(String item_code,String link_yn,String head_link_yn)
{
	for(int j=0;j<DataList.size();j++){
			HashMap hh=new HashMap();
			hh=(HashMap) DataList.get(j);
			String str_id=(String)hh.get("ITEM_CODE");
				if(str_id.equals(item_code)){
					hh.put("LINK_YN",link_yn);
					hh.put("HEAD_LINK_YN",head_link_yn);
					break;
				}
		}
}

public boolean chkPhParamAvail()
{
	Connection connection       = null ;
    PreparedStatement pstmt     = null ;
    ResultSet rsMaxCount        = null ;
	int maxCount=0;
	String qry="";
	boolean chkphparamavail=false;

	try{
		connection = getConnection() ;
		qry= PhRepository.getPhKeyValue("SQL_PH_FACILITY_PARAM_SELECT4");
		pstmt				= connection.prepareStatement(qry) ;
		rsMaxCount			= pstmt.executeQuery();
		
		if( rsMaxCount!=null && rsMaxCount.next()){
			maxCount=rsMaxCount.getInt(1);		
		}

		if(maxCount>0){ 
			chkphparamavail=true;
		}
		else{ 
			chkphparamavail=false;
		}

	} catch ( Exception e ) {
				System.err.println( "Error loading Initial Values :"+e ) ;
                e.printStackTrace() ;
           
		} finally {
               try{
                    closeResultSet( rsMaxCount ) ;
					closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){ es.printStackTrace();}
              }
return chkphparamavail;
}

public boolean ParamDrugItemChkValue()
{
	Connection connection       = null ;
    PreparedStatement pstmt     = null ;
    ResultSet resultSet         = null ;
	String item_map="";
	String qry="";
	boolean paramdrugitemchkvalue=false;

	try
	{
		connection = getConnection() ;
		qry= PhRepository.getPhKeyValue("SQL_PH_DRUG_ITEM_LINK_SELECT4");
		pstmt				= connection.prepareStatement(qry) ;
		resultSet			= pstmt.executeQuery();
		
		if( resultSet!=null && resultSet.next())
		{
			item_map=resultSet.getString("DRUG_TO_ITEM_MAPPING");		
		}

		if(item_map!=null && item_map.equals("S")){ 
			paramdrugitemchkvalue=true;
		}
		else{ 
			paramdrugitemchkvalue=false;
		}

	} catch ( Exception e ) {
				System.err.println( "Error loading Initial Values :"+e ) ;
                e.printStackTrace() ;
           
		} finally {
               try{
                    closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){es.printStackTrace();}
              }
return paramdrugitemchkvalue;
}


public ArrayList SearchItemCodeResult(String from_code,String to_code,String criteria,int result_size)
	{
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet rsMaxCount         = null ;
		ResultSet resultSet         = null ;
		String sql_query_1			= "";	
		String sql_query_2			= "";	
		maxCount=0;
		DataList=new ArrayList();
		try{
		connection = getConnection() ;
		
		sql_query_1 = PhRepository.getPhKeyValue("SQL_PH_DRUG_ITEM_LINK_SELECT3");
		sql_query_2 = PhRepository.getPhKeyValue("SQL_PH_DRUG_ITEM_LINK_SELECT2");

		if(criteria!=null && criteria.equals("UA")){
			sql_query_1=sql_query_1+"AND B.ITEM_CODE IS NULL";
			sql_query_2=sql_query_2+"AND B.ITEM_CODE IS NULL GROUP BY A.ITEM_CODE,C.LONG_DESC ,B.DRUG_CODE,B.DRUG_DESC,B.IN_FORMULARY_YN,A.DRUG_ITEM_YN, B.CONTENT_IN_PRES_BASE_UOM,B.PRES_BASE_UOM_DESC,B.STOCK_UOM ,B.STOCK_UOM_DESC,ROWNUM HAVING ROWNUM<=? ORDER BY A.ITEM_CODE";
		}
		else if(criteria!=null && criteria.equals("AS")){
			sql_query_1=sql_query_1+"AND B.ITEM_CODE IS NOT NULL";
			sql_query_2=sql_query_2+"AND B.ITEM_CODE IS NOT NULL GROUP BY A.ITEM_CODE,C.LONG_DESC ,B.DRUG_CODE,B.DRUG_DESC,B.IN_FORMULARY_YN,A.DRUG_ITEM_YN, B.CONTENT_IN_PRES_BASE_UOM,B.PRES_BASE_UOM_DESC,B.STOCK_UOM ,B.STOCK_UOM_DESC,ROWNUM HAVING ROWNUM<=? order by A.ITEM_CODE ";
		}
		else if(criteria!=null && criteria.equals("NF")){
			sql_query_1=sql_query_1+"AND B.ITEM_CODE IS NOT NULL AND B.IN_FORMULARY_YN='N' order by A.ITEM_CODE";		
			sql_query_2=sql_query_2+"AND B.ITEM_CODE IS NOT NULL AND B.IN_FORMULARY_YN='N' GROUP BY A.ITEM_CODE,C.LONG_DESC,B.DRUG_CODE,B.DRUG_DESC,B.IN_FORMULARY_YN,A.DRUG_ITEM_YN, B.CONTENT_IN_PRES_BASE_UOM,B.PRES_BASE_UOM_DESC,B.STOCK_UOM ,B.STOCK_UOM_DESC,ROWNUM HAVING ROWNUM<=? ORDER BY A.ITEM_CODE";			
		}
		else if(criteria!=null && criteria.equals("ND")){
			sql_query_1=sql_query_1+"AND B.ITEM_CODE IS NOT NULL AND A.PS_YN='N'";
			sql_query_2=sql_query_2+"AND B.ITEM_CODE IS NOT NULL AND A.PS_YN='N' GROUP BY A.ITEM_CODE,C.LONG_DESC ,B.DRUG_CODE,B.DRUG_DESC,B.IN_FORMULARY_YN,A.DRUG_ITEM_YN, B.CONTENT_IN_PRES_BASE_UOM,B.PRES_BASE_UOM_DESC,B.STOCK_UOM ,B.STOCK_UOM_DESC,ROWNUM HAVING ROWNUM<=? ORDER BY A.ITEM_CODE";		
		}
		
		pstmt				= connection.prepareStatement(sql_query_1) ;
		pstmt.setString(1,from_code);
		pstmt.setString(2,to_code);
		pstmt.setInt(3,result_size);
		rsMaxCount			= pstmt.executeQuery();
		
		if( rsMaxCount!=null && rsMaxCount.next()){
			maxCount=rsMaxCount.getInt(1);		
		}
		closeStatement(pstmt);
		pstmt=null;	
		pstmt				= connection.prepareStatement(sql_query_2) ;
		pstmt.setString(1,from_code);
		pstmt.setString(2,to_code);
		pstmt.setString(3,getLanguageId());
		pstmt.setString(4,getLanguageId());
		pstmt.setString(5,getLanguageId());
		pstmt.setString(6,getLanguageId());
		pstmt.setString(7,getLanguageId());
		pstmt.setInt(8,result_size); 
	
		resultSet			= pstmt.executeQuery();		
		while ( resultSet!=null && resultSet.next())
			{
				HashMap rowSet=new HashMap();
				rowSet.put( "ITEM_CODE",resultSet.getString( "ITEM_CODE" ) ) ;
				rowSet.put( "ITEM_DESC",resultSet.getString( "LONG_DESC" ) ) ;
				rowSet.put( "DRUG_CODE",resultSet.getString( "DRUG_CODE" ) ) ;
				rowSet.put( "DRUG_DESC",resultSet.getString( "DRUG_DESC" ) ) ;
				rowSet.put( "IN_FORMULARY_YN",resultSet.getString( "IN_FORMULARY_YN" ) ) ;
				rowSet.put( "DRUG_YN",resultSet.getString( "DRUG_ITEM_YN" ) ) ;			
				rowSet.put( "CONTENT_IN_PRES_BASE_UOM",resultSet.getString( "CONTENT_IN_PRES_BASE_UOM" ) ) ;
				rowSet.put( "PRES_BASE_UOM_DESC",resultSet.getString( "PRES_BASE_UOM_DESC" ) ) ;
				rowSet.put( "STOCK_UOM",resultSet.getString( "STOCK_UOM" ) ) ;	
				rowSet.put( "STOCK_UOM_DESC",resultSet.getString( "STOCK_UOM_DESC" ) ) ;
				rowSet.put( "LINK_YN","N" ) ;
				rowSet.put( "HEAD_LINK_YN","N" ) ;
				DataList.add(rowSet);
				
			}
		} catch ( Exception e ) {
				DataList.add("error :"+e);
                System.err.println( "Error loading Initial Values :"+e ) ;
                e.printStackTrace() ;
           
		} finally {
               try{
                    closeResultSet( rsMaxCount ) ;
					closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){}
              }
return DataList;

	}
public ArrayList SearchItemCodeResultMR_IT(int start,int end)
{
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet rsMaxCount         = null ;
		ResultSet resultSet         = null ;
		String sql_query_1			= "";	
		String sql_query_2			= "";
		int i=1;
		maxCount=0;
		DataList=new ArrayList();
		try{
		connection = getConnection() ;
		sql_query_1 = PhRepository.getPhKeyValue("SQL_PH_DRUG_ITEM_LINK_SELECT8_DMY");
		sql_query_2 = PhRepository.getPhKeyValue("SQL_PH_DRUG_ITEM_LINK_SELECT7_DMY");
		
		pstmt				= connection.prepareStatement(sql_query_1) ;
		rsMaxCount			= pstmt.executeQuery();
		
		if( rsMaxCount!=null && rsMaxCount.next()){
			maxCount=rsMaxCount.getInt(1);		
		}
		closeStatement(pstmt);
		pstmt=null;	
		pstmt				= connection.prepareStatement(sql_query_2) ;
		pstmt.setString(1, getLanguageId());
		pstmt.setString(2, getLanguageId());

		resultSet			= pstmt.executeQuery();		
		if ( start != 0 )
				for( int j=1; j<start; i++,j++ ){
					resultSet.next() ; 
				}
		while ( resultSet.next() && i<=end )
		{
				HashMap rowSet=new HashMap();
				rowSet.put( "ITEM_CODE",resultSet.getString( "ITEM_CODE" ) ) ;
				rowSet.put( "ITEM_DESC",resultSet.getString( "LONG_DESC" ) ) ;
				rowSet.put( "DRUG_YN",resultSet.getString( "DRUG_ITEM_YN" ) ) ;
				rowSet.put( "STOCK_UOM",resultSet.getString( "SALE_UOM_CODE" ) ) ;	
				rowSet.put( "STOCK_UOM_DESC",resultSet.getString( "SHORT_DESC" ) ) ;
				DataList.add(rowSet);
				i++;

			}
		} catch ( Exception e ) {
				DataList.add("error :"+e);
                System.err.println( "Error loading Initial Values :"+e ) ;
                e.printStackTrace() ;
           
		} finally {
               try{
                    closeResultSet( rsMaxCount ) ;
					closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){}
              }
return DataList;

	}

public ArrayList SearchItemCodeResultMR_DR(int start,int end)
{
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet rsMaxCount        = null ;
		ResultSet resultSet         = null ;
		String sql_query_1			= "";	
		String sql_query_2			= "";
		maxCount=0;
		int i=1;
		DataList=new ArrayList();
		try{
		connection = getConnection() ;
		sql_query_1 = PhRepository.getPhKeyValue("SQL_PH_DRUG_ITEM_LINK_SELECT6_DMY");
		sql_query_2 = PhRepository.getPhKeyValue("SQL_PH_DRUG_ITEM_LINK_SELECT5_DMY");
		
		pstmt				= connection.prepareStatement(sql_query_1) ;
		rsMaxCount			= pstmt.executeQuery();
		
		if( rsMaxCount!=null && rsMaxCount.next()){
			maxCount=rsMaxCount.getInt(1);		
		}
		closeStatement(pstmt);
		pstmt=null;	
		pstmt				= connection.prepareStatement(sql_query_2) ;

		pstmt.setString(1, getLanguageId());
		pstmt.setString(2, getLanguageId());
		pstmt.setString(3, getLanguageId());
		pstmt.setString(4, getLanguageId());
		pstmt.setString(5, getLanguageId());

		resultSet			= pstmt.executeQuery();		
		if ( start != 0 )
				for( int j=1; j<start; i++,j++ ){
					resultSet.next() ; 
				}

		while ( resultSet.next() && i<=end )
		{
				HashMap rowSet=new HashMap();
				rowSet.put( "DRUG_CODE",resultSet.getString( "DRUG_CODE" ) ) ;
				rowSet.put( "DRUG_DESC",resultSet.getString( "DRUG_DESC" ) ) ;
				rowSet.put( "IN_FORMULARY_YN",resultSet.getString( "IN_FORMULARY_YN" ) ) ;
				rowSet.put( "CONTENT_IN_PRES_BASE_UOM",resultSet.getString( "CONTENT_IN_PRES_BASE_UOM" ) ) ;
				rowSet.put( "PRES_BASE_UOM_DESC",resultSet.getString( "PRES_BASE_UOM_DESC" ) ) ;
				rowSet.put( "STOCK_UOM",resultSet.getString( "STOCK_UOM" ) ) ;	
				rowSet.put( "STOCK_UOM_DESC",resultSet.getString( "STOCK_UOM_DESC" ) ) ;
				DataList.add(rowSet);
				i++;
				
			}
		} catch ( Exception e ) {
				DataList.add("error :"+e);
                System.err.println( "Error loading Initial Values :"+e ) ;
                e.printStackTrace() ;
           
		} finally {
               try{
                    closeResultSet( rsMaxCount ) ;
					closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){}
              }
return DataList;

}

public ArrayList SearchItemCodeResultMR_BT(int start,int end)
{
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet rsMaxCount         = null ;
		ResultSet resultSet         = null ;
		String sql_query_1			= "";	
		String sql_query_2			= "";	
		int i=1;
		maxCount=0;
		DataList=new ArrayList();
		try{
		connection = getConnection() ;
		sql_query_1 = PhRepository.getPhKeyValue("SQL_PH_DRUG_ITEM_LINK_SELECT10_DMY");
		sql_query_2 = PhRepository.getPhKeyValue("SQL_PH_DRUG_ITEM_LINK_SELECT9_DMY"); 
		
		pstmt				= connection.prepareStatement(sql_query_1) ;
		rsMaxCount			= pstmt.executeQuery();
		
		while( rsMaxCount!=null && rsMaxCount.next()){
			maxCount+=rsMaxCount.getInt(1);	
		}
		closeStatement(pstmt);
		pstmt=null;	
		pstmt				= connection.prepareStatement(sql_query_2) ;

		pstmt.setString(1, getLanguageId());
		pstmt.setString(2, getLanguageId());
		pstmt.setString(3, getLanguageId());
		pstmt.setString(4, getLanguageId());
		pstmt.setString(5, getLanguageId());
		pstmt.setString(6, getLanguageId());
		pstmt.setString(7, getLanguageId());

//		resultSet			= pstmt.executeQuery();		
		resultSet = pstmt.executeQuery() ;
		if ( start != 0 )
				for( int j=1; j<start; i++,j++ ){
					resultSet.next() ; 
				}

		while ( resultSet.next() && i<=end )
			{
					HashMap rowSet=new HashMap();
					rowSet.put( "CODE",resultSet.getString( "CODE" ) ) ;
					rowSet.put( "DESC",resultSet.getString( "DESCRIPTION" ) ) ;
					rowSet.put( "IN_FORMULARY_YN",resultSet.getString( "IN_FORMULARY_YN" ) ) ;
					rowSet.put( "CONTENT_IN_PRES_BASE_UOM",resultSet.getString( "CONTENT_IN_PRES_BASE_UOM" ) ) ;
					rowSet.put( "PRES_BASE_UOM_DESC",resultSet.getString( "PRES_BASE_UOM_DESC" ) ) ;
					rowSet.put( "DRUG_YN",resultSet.getString( "DRUG_ITEM_YN" ) ) ;
					rowSet.put( "STOCK_UOM",resultSet.getString( "STOCK_UOM" ) ) ;	
					rowSet.put( "STOCK_UOM_DESC",resultSet.getString( "STOCK_UOM_DESC" ) ) ;
					rowSet.put( "CODE_FLAG",resultSet.getString( "CODE_FLAG" ) ) ;
					DataList.add(rowSet);
					i++;
					
				}
				closeResultSet( resultSet ) ;
			} catch ( Exception e ) {
				DataList.add("error :"+e);
                System.err.println( "Error loading Initial Values :"+e ) ;
                e.printStackTrace() ;

		} finally {
               try{
                    closeResultSet( rsMaxCount ) ;
			//		closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){}
              }
return DataList;
}


public HashMap modify() {
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "success.." ) ;
		map.put( "flag", "test") ;
		HashMap modifyRow			= null ;
		ArrayList modifyData		= new ArrayList();
		ArrayList	mandatory_flds	=	new ArrayList();

		for(int j=0;j<DataList.size();j++){
			HashMap hh=new HashMap();
			hh=(HashMap) DataList.get(j);

					modifyRow = new HashMap() ;
					if( ((String)hh.get("LINK_YN")).equals("Y") ){
					modifyRow.put("ITEM_CODE", (String)hh.get("ITEM_CODE") );
					modifyRow.put("ITEM_DESC", (String)hh.get("ITEM_DESC") );
					modifyRow.put("DRUG_CODE", (String)hh.get("DRUG_CODE") );
					modifyRow.put("STOCK_UOM", (String)hh.get("STOCK_UOM") );
					modifyRow.put("CONTENT_IN_PRES_BASE_UOM", (String)hh.get("CONTENT_IN_PRES_BASE_UOM") );
					modifyData.add(modifyRow);
					}

			}
		
		mandatory_flds.add(login_by_id);
		mandatory_flds.add(login_at_ws_no);
		mandatory_flds.add(login_facility_id);

		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "ModifyData",modifyData);
		tabData.put( "mandatory_flds",mandatory_flds);

		HashMap sqlMap = new HashMap() ;
	
/*		DrugItemLinkHome   home=null;
		DrugItemLinkRemote remote=null;*/
    	try 
		{
				sqlMap.put( "SQL_PH_DRUG_ITEM_LINK_UPDATE", PhRepository.getPhKeyValue("SQL_PH_DRUG_ITEM_LINK_UPDATE") );
				sqlMap.put( "SQL_PH_INVENTORY_ITEM_FOR_DRUG_INSERT", PhRepository.getPhKeyValue("SQL_PH_INVENTORY_ITEM_FOR_DRUG_INSERT") );

/*				InitialContext context = new InitialContext() ;
				Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_DRUG_ITEM_LINK") ) ;	
				home  = (DrugItemLinkHome) PortableRemoteObject.narrow( object, DrugItemLinkHome.class ) ;
				remote = home.create() ;

				HashMap result = remote.modify( tabData, sqlMap ) ;*/
				Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue("JNDI_PH_DRUG_ITEM_LINK"),DrugItemLinkHome.class,getLocalEJB());
				Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]=new Object[2];
				argArray[0]=tabData;
				argArray[1]=sqlMap;

				Class[] paramArray=new Class[2];
				paramArray[0]=tabData.getClass();
				paramArray[1]=sqlMap.getClass();

				HashMap result=(HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				if( ((Boolean) result.get( "result" )).booleanValue() )
				{
					map.put("flag",result.get("flag"));
					map.put( "result", new Boolean( true ) ) ;
					map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH") ) ;
				}
				else
			    {
					map.put("flag",result.get("flag"));
					map.put( "result", new Boolean( false ) ) ;
					map.put( "message", result.get("msgid") ) ;
				}
					
	}
	catch(Exception e) {
		map.put("flag",e.toString());
		e.printStackTrace() ;
	}
	/*finally {
			try {} 
			catch( Exception ee ){
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
	}*/
	
	return map ;
}//modify ends

public void setAll( Hashtable recordSet ) {
		if(recordSet.get("mode") != null)
             mode = (String)recordSet.get("mode") ; 
}
public HashMap validate() throws Exception {

        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "success.." ) ;
        return map ;
    }
public void clearBean() {
	maxCount	= 0;
	DataList	= null;
}
public void clear() {
	super.clear() ;
}
		 

private void doCommon() throws Exception 
{
}

    /* Function specific methods end */
}
