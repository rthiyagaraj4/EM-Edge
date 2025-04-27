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
//import javax.rmi.* ;
//import javax.naming.* ;
import ePH.ReconstituentFluid.*;
import ePH.Common.* ;
import eCommon.Common.* ;

public class ReconstituentFluidBean extends PhAdapter implements Serializable {

	protected Hashtable hashMultiple       ;
//	java.util.Properties p=null;
	protected String debug="";

//	protected String RF_ID = "";
//	protected String RF_NAME = "";
//	protected String RF_BASE_UNIT ="";
//	protected String number_of_rows = "";
	protected String Immodule_Yn = "";

	public ReconstituentFluidBean() {
        try {
            doCommon();
        }catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void doCommon() throws Exception {
    }

	public String getDebug(){
		return this.debug;
	}

	/* Over-ridden Adapter methods end here */
	public HashMap validate() throws Exception {
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}

  	public String getImModule(){
	Connection connection       = null ;
    PreparedStatement pstmt     = null ;
	ResultSet resultSet         = null ;
	String Immodule_Yn	="0";		
	try{
		connection = getConnection() ;
		String str_qry	=PhRepository.getPhKeyValue("SQL_PH_RECONSTITUENT_FLUID_SELECT1");
		pstmt			= connection.prepareStatement(str_qry) ;
		resultSet		= pstmt.executeQuery();
		if(resultSet!=null && resultSet.next()){
			Immodule_Yn=resultSet.getString(1);
		}
		 
	}catch ( Exception e ) {
		Immodule_Yn+=e.toString();
	
        e.printStackTrace() ;
     } finally {
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}catch(Exception es){System.err.println(es);}
      }
	return Immodule_Yn;
	}

// method for controlling violation

	  public int getFluidId(String fluid) {
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
	//	ArrayList Fluidval = new ArrayList();
		int Fluid_id=0; 

		try{
		connection = getConnection() ;

//	   String fluid_qry	="select count(*) rfcount from PH_RECONST_FLUID where RF_ID=Upper(?)";
	   String fluid_qry	=PhRepository.getPhKeyValue("SQL_PH_RECONSTITUENT_FLUID_SELECT9");

    	pstmt			= connection.prepareStatement(fluid_qry) ;
		pstmt.setString(1,fluid);
		resultSet		= pstmt.executeQuery();
		while(resultSet!=null && resultSet.next()){
		Fluid_id =resultSet.getInt("rfcount") ;

		}  

		}catch ( Exception e ) {
			
                e.printStackTrace() ;
           
			} finally {
                try{
                    closeResultSet( resultSet ) ; 
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){es.printStackTrace();}
              }
		
		return Fluid_id;

		}

	  public ArrayList loadUom() {
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ArrayList all = new ArrayList();
		ArrayList base_uom	= new ArrayList();
		ArrayList uom_desc	= new ArrayList();
		try{
		connection = getConnection() ;
		String str_qry	=PhRepository.getPhKeyValue("SQL_PH_RECONSTITUENT_FLUID_SELECT3");
		pstmt			= connection.prepareStatement(str_qry) ;
		pstmt.setString(1, getLanguageId());
		resultSet		= pstmt.executeQuery();
		while(resultSet!=null && resultSet.next()){
			base_uom.add( resultSet.getString( "UOM_CODE" ) ) ;
			uom_desc.add( resultSet.getString( "SHORT_DESC" ) );
		}
		 
	    }catch ( Exception e ) {
			
                e.printStackTrace() ;
           
			} finally {
                try{
                    closeResultSet( resultSet ) ; 
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){es.printStackTrace();}
              }

		all.add(base_uom);
		all.add(uom_desc);

		return all;


  }
	
	public void setAll(Hashtable recordSetMultiple)
	{

		if(recordSetMultiple.containsKey("mode"))
			setMode((String)recordSetMultiple.get("mode")) ;

		if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ))||mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ){
			hashMultiple = recordSetMultiple ;
		}else {
		//	if(recordSetMultiple.containsKey("RF_ID"))
		//		RF_ID = (String)recordSetMultiple.get("RF_ID");
		//	if(recordSetMultiple.containsKey("RF_NAME"))
		//		RF_NAME = (String)recordSetMultiple.get("RF_NAME");
		//	if(recordSetMultiple.containsKey("RF_BASE_UNIT"))
		//		RF_BASE_UNIT = (String)recordSetMultiple.get("RF_BASE_UNIT");
			if(recordSetMultiple.containsKey("Immodule_Yn"))
				Immodule_Yn = (String)recordSetMultiple.get("Immodule_Yn");

			
			/*if(Immodule_Yn.equals("1"))
			{
			
			
			if(recordSetMultiple.containsKey("number_of_rows"))
				number_of_rows = (String)recordSetMultiple.get("number_of_rows");
			}*/
		}         
	}

	
	// insert Method  starts here...
	public HashMap insert() {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		
		ArrayList arrListData = new ArrayList();
		ArrayList insertRowCommonData = new ArrayList() ;
		
		//--Add ur ejb names
		//ReconstituentFluidHome   home=null;
		//ReconstituentFluidRemote remote=null;

		try{

			String RF_ID = ((String)hashMultiple.get("RF_ID"));
			String RF_NAME = ((String)hashMultiple.get("RF_NAME"));
			String RF_BASE_UNIT	= ((String)hashMultiple.get("RF_BASE_UNIT"));
			String Immodule_Yn	= ((String)hashMultiple.get("Immodule_Yn"));

			insertRowCommonData.add(RF_ID);
			insertRowCommonData.add(RF_NAME);
			insertRowCommonData.add(RF_BASE_UNIT);
			insertRowCommonData.add(Immodule_Yn);

			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "CommonData",insertRowCommonData);

			if(Immodule_Yn.equals("1"))
			{
			int noOfRows = Integer.parseInt((String)hashMultiple.get("number_of_rows"));

			for(int i=0; i<=noOfRows; i++){

				ArrayList insertRowMultipleData = new ArrayList();

				
					
					String item_code = "";
					String content_in_base_uom = "";

					String icode=(String)hashMultiple.get("item_code"+i) ;
					if ( icode==null ||icode.equals("")||icode.equals("null") )
					{
						continue;
					}
					else
					{
						item_code = ((String)hashMultiple.get("item_code"+i));
						content_in_base_uom = ((String)hashMultiple.get("content_in_base_uom"+i));
					}					

					insertRowMultipleData.add(item_code);
					insertRowMultipleData.add(content_in_base_uom);
					arrListData.add(insertRowMultipleData);								

/************
					// duplicate check
					Connection connection = null ;
					PreparedStatement pstmt = null ;
					ResultSet resultSet = null ;
					if (routingLevel.equals("S")){
						try {
							connection = getConnection() ;
							pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT11") ) ;
							pstmt.setString(1,ordering_facility_id.trim());
							pstmt.setString(2,ordering_source_type.trim());
							pstmt.setString(3,ordering_source_code.trim());
							resultSet = pstmt.executeQuery() ;
							if ( resultSet != null ) {
								if ( resultSet.next() ) {
									if (resultSet.getInt("count")>0){
										map.put( "result", new Boolean( false ) ) ;		
										map.put( "message", getMessage("CODE_ALREADY_EXISTS") ) ;
										map.put("flag","0");
										return map;
									}
								}
							}
						}
						catch(Exception e){
						}
					}else if (!routingLevel.equals("S")){
						try {
							connection = getConnection() ;
							pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT12") ) ;
							pstmt.setString(1,ordering_facility_id.trim());
							pstmt.setString(2,ordering_source_type.trim());
							pstmt.setString(3,ordering_source_code.trim());
							pstmt.setString(4,routingLevel.trim());
							pstmt.setString(5,routing_code.trim());
							resultSet = pstmt.executeQuery() ;
							if ( resultSet != null ) {
								if ( resultSet.next() ) {
									if (resultSet.getInt("count")>0){
										map.put( "result", new Boolean( false ) ) ;		
										map.put( "message", getMessage("CODE_ALREADY_EXISTS") ) ;
										map.put("flag","0");
										return map;
									}
								}
							}
						}
						catch(Exception e){
						}
					}
				//}  
			*********/
			}

			tabData.put( "MultipleData",arrListData);
			}


			tabData.put("login_by_id", login_by_id ) ;
			tabData.put("login_at_ws_no", login_at_ws_no ) ;
			tabData.put("login_facility_id", login_facility_id ) ;

	
			HashMap sqlMap = new HashMap() ;
			sqlMap.put("SQL_PH_RECONSTITUENT_FLUID_INSERT",PhRepository.getPhKeyValue("SQL_PH_RECONSTITUENT_FLUID_INSERT"));

			if(Immodule_Yn.equals("1"))
			{			
			sqlMap.put("SQL_PH_RECONSTITUENT_FLUID_DTL_INSERT",PhRepository.getPhKeyValue("SQL_PH_RECONSTITUENT_FLUID_DTL_INSERT"));
			}			
			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_RECONS_FLUID") ) ;
			home  = (ReconstituentFluidHome) PortableRemoteObject.narrow( object, ReconstituentFluidHome.class ) ;
			remote = home.create() ;
			
			HashMap result = remote.insert( tabData, sqlMap ) ;*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_RECONS_FLUID" ),ReconstituentFluidHome.class,getLocalEJB());


				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); ;
				paramArray[1] = sqlMap.getClass();
				HashMap result = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			if( ((Boolean) result.get( "result" )).booleanValue() )	{
				map.put( "result", new Boolean( true ) ) ;		
				map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH") ) ;
				map.put("flag","0");
			}
			else{
				map.put( "message", result.get("msgid") ) ;
				map.put("flag","0");
			}
		}//try
		catch(Exception e){
			
			map.put( "message", "exp :"+e.getMessage()) ;
			map.put("flag","0");
			e.printStackTrace() ;
		}//catch
		finally{
			map.put("flag","0");
			}//finally
		return map ;		
	}//insert ends


	

	// insert Method  starts here...
	public HashMap modify() {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		
		ArrayList arrListData = new ArrayList();
		ArrayList insertRowCommonData = new ArrayList() ;
		
		//--Add ur ejb names
		//ReconstituentFluidHome   home=null;
		//ReconstituentFluidRemote remote=null;

		try{

			String RF_ID = ((String)hashMultiple.get("RF_ID"));
			String RF_NAME = ((String)hashMultiple.get("RF_NAME"));
			String RF_BASE_UNIT	= ((String)hashMultiple.get("RF_BASE_UNIT"));
			String Immodule_Yn	= ((String)hashMultiple.get("Immodule_Yn"));

	
			insertRowCommonData.add(RF_ID);
			insertRowCommonData.add(RF_NAME);
			insertRowCommonData.add(RF_BASE_UNIT);
			insertRowCommonData.add(Immodule_Yn);

			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "CommonData",insertRowCommonData);

			if(Immodule_Yn.equals("1"))
			{
			int noOfRows = Integer.parseInt((String)hashMultiple.get("number_of_rows"));


			for(int i=0; i<=noOfRows; i++){

				ArrayList insertRowMultipleData = new ArrayList();

				
					
					String item_code = "";
					String content_in_base_uom = "";

					String icode=(String)hashMultiple.get("item_code"+i) ;
					if ( icode==null||icode.equals("")||icode.equals("null") )
					{
						continue;
					}
					else
					{
						item_code = ((String)hashMultiple.get("item_code"+i));
						content_in_base_uom = ((String)hashMultiple.get("content_in_base_uom"+i));
					}							

					insertRowMultipleData.add(item_code);
					insertRowMultipleData.add(content_in_base_uom);

					arrListData.add(insertRowMultipleData);								


			}
			tabData.put( "MultipleData",arrListData);

			}


			tabData.put("login_by_id", login_by_id ) ;
			tabData.put("login_at_ws_no", login_at_ws_no ) ;
			tabData.put("login_facility_id", login_facility_id ) ;

			
			HashMap sqlMap = new HashMap() ;

			sqlMap.put("SQL_PH_RECONSTITUENT_FLUID_UPDATE",PhRepository.getPhKeyValue("SQL_PH_RECONSTITUENT_FLUID_UPDATE"));
			if(Immodule_Yn.equals("1"))
			{			
			sqlMap.put("SQL_PH_RECONSTITUENT_FLUID_DTL_INSERT",PhRepository.getPhKeyValue("SQL_PH_RECONSTITUENT_FLUID_DTL_INSERT"));
			sqlMap.put("SQL_PH_RECONSTITUENT_FLUID_DTL_DELETE",PhRepository.getPhKeyValue("SQL_PH_RECONSTITUENT_FLUID_DTL_DELETE"));
			}			
			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_RECONS_FLUID") ) ;
			home  = (ReconstituentFluidHome) PortableRemoteObject.narrow( object, ReconstituentFluidHome.class ) ;
			remote = home.create() ;
			
			HashMap result = remote.modify( tabData, sqlMap ) ;
		//	HashMap result = localmodify( tabData, sqlMap ) ;*/

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_RECONS_FLUID" ),ReconstituentFluidHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); ;
				paramArray[1] = sqlMap.getClass();

				HashMap result = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				

			if( ((Boolean) result.get( "result" )).booleanValue() )	{
				map.put( "result", new Boolean( true ) ) ;		
				map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH") ) ;
				map.put("flag","0");
			}
			else{
				map.put( "message", result.get("msgid") ) ;
				map.put("flag","0");
			}
		}//try
		catch(Exception e){
			
			map.put( "message", "exp :"+e.getMessage()) ;
			map.put("flag","0");
			e.printStackTrace() ;
		}//catch
		finally{
		map.put("flag","0");
		}//finally

		return map ;		
	}//modify ends
















public HashMap delete() {
	HashMap map=new HashMap();
	map.put( "result", new Boolean( true ) ) ;
	map.put( "message", "success.." ) ;
	return map;
	}

public String getSaleUOM(String item_code){
	Connection connection       = null ;
    PreparedStatement pstmt     = null ;
	ResultSet resultSet         = null ;
	String sale_uom				= "";		
	try{
		connection = getConnection() ;
		pstmt			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_CONS_NS_REGIMEN_SELECT4")) ;
		pstmt.setString(1,item_code);
		resultSet		= pstmt.executeQuery();
		if(resultSet!=null && resultSet.next()){
			sale_uom	= checkForNull(resultSet.getString("SALE_UOM_CODE"));
		}		 
	}catch ( Exception e ) {
        e.printStackTrace() ;
     } finally {
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}catch(Exception es){System.err.println(es);}
      }
	return sale_uom ;
}


public String validate(String sale_uom,String base_uom){
	Connection connection       = null ;
    PreparedStatement pstmt     = null ;
	ResultSet resultSet         = null ;
	String vldstr	="";		
	try{
		connection = getConnection() ;
	
		String str_qry	=PhRepository.getPhKeyValue("SQL_PH_RECONSTITUENT_FLUID_SELECT8");
		pstmt			= connection.prepareStatement(str_qry) ;
		pstmt.setString(1,sale_uom);
		pstmt.setString(2,base_uom);
		resultSet		= pstmt.executeQuery();
		if(resultSet!=null && resultSet.next()){
			vldstr	= checkForNull(resultSet.getString("EQVL_VALUE"));
		}else {
			resultSet	=	null;
			pstmt.setString(1,base_uom);
			pstmt.setString(2,sale_uom);
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				vldstr	= checkForNull(resultSet.getString("EQVL_VALUE"));
			}
		}
		 
	}catch ( Exception e ) {
		vldstr+=e.toString();
		
        e.printStackTrace() ;
     } finally {
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}catch(Exception es){System.err.println(es);}
      }
	return vldstr ;
	}

 	public ArrayList getRecords(String rfid){
	Connection connection       = null ;
    PreparedStatement pstmt     = null ;
	ResultSet resultSet         = null ;
	ArrayList arec = new ArrayList();
	String Immodule_Yn	="0";		
	try{
		connection = getConnection() ;
		String str_qry	=PhRepository.getPhKeyValue("SQL_PH_RECONSTITUENT_FLUID_SELECT6");
		pstmt			= connection.prepareStatement(str_qry) ;
		pstmt.setString(1,rfid);
		pstmt.setString(2, getLanguageId());
		resultSet		= pstmt.executeQuery();
		if(resultSet!=null && resultSet.next()){
			arec.add((String)resultSet.getString(1));
			arec.add((String)resultSet.getString(2));
			arec.add((String)resultSet.getString(3));
		}

		 
	}catch ( Exception e ) {
		Immodule_Yn+=e.toString();
	
        e.printStackTrace() ;
     } finally {
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}catch(Exception es){System.err.println(es);}
      }
	return arec;
	} 
public ArrayList getItemList(String rfid){
	Connection connection       = null ;
    PreparedStatement pstmt     = null ;
	ResultSet resultSet         = null ;
	ArrayList arec = new ArrayList();

	try{
		connection = getConnection() ;
		String str_qry	=PhRepository.getPhKeyValue("SQL_PH_RECONSTITUENT_FLUID_SELECT7");
		pstmt			= connection.prepareStatement(str_qry) ;
		pstmt.setString(1,rfid);
		pstmt.setString(2, getLanguageId());
		resultSet		= pstmt.executeQuery();
		while(resultSet!=null && resultSet.next()){
			arec.add((String)resultSet.getString("ITEM_CODE"));
			arec.add((String)resultSet.getString("LONG_DESC"));
			arec.add((String)resultSet.getString("CONTENT_IN_BASE_UOM"));
		}

		 
	}catch ( Exception e ) {
	
        e.printStackTrace() ;
     } finally {
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}catch(Exception es){System.err.println(es);}
      }
	return arec;
	}




    public HashMap localmodify( HashMap tabData, HashMap sqlMap ) 
		{
	
		StringBuffer messages = new StringBuffer() ;
		StringBuffer debug = new StringBuffer() ;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;			

		String SQL_PH_RECONSTITUENT_FLUID_UPDATE				=	"";
		String SQL_PH_RECONSTITUENT_FLUID_DTL_INSERT		=	"";
		String SQL_PH_RECONSTITUENT_FLUID_DTL_DELETE="";

		//prop  = (Properties)tabData.get( "properties" );			            
		String  login_by_id			= (String)tabData.get("login_by_id");
		String	login_at_ws_no		= (String)tabData.get("login_at_ws_no");
		String	login_facility_id	= (String)tabData.get("login_facility_id");

		ArrayList CommonData		= (ArrayList)tabData.get("CommonData");
		String	rf_id			= (String)CommonData.get(0);
		String	rf_name			= (String)CommonData.get(1);
		String	rf_base_uom		= (String)CommonData.get(2);
		String Im_module_yn		= (String)CommonData.get(3);	
		
		SQL_PH_RECONSTITUENT_FLUID_UPDATE	= (String) sqlMap.get( "SQL_PH_RECONSTITUENT_FLUID_UPDATE" );

		if(Im_module_yn.equals("1"))
		{
		SQL_PH_RECONSTITUENT_FLUID_DTL_INSERT = (String) sqlMap.get( "SQL_PH_RECONSTITUENT_FLUID_DTL_INSERT" );
		SQL_PH_RECONSTITUENT_FLUID_DTL_DELETE = (String) sqlMap.get( "SQL_PH_RECONSTITUENT_FLUID_DTL_DELETE" );
		}


		debug.append( " rf_id:"+rf_id);
		debug.append( " rf_name:"+rf_name);
		debug.append( " rf_base_uom:"+rf_base_uom);

		ArrayList MultipleData		= (ArrayList)tabData.get("MultipleData");
		
		Connection connection = null ;
		PreparedStatement pstmt_insert1=null,pstmt_insert2 = null ,pstmt_delete=null;
		try{
			//connection = getConnection( prop ) ;
			connection=getConnection();
			
			pstmt_insert1 = connection.prepareStatement( SQL_PH_RECONSTITUENT_FLUID_UPDATE ) ;
	
			pstmt_insert1.setString(1,rf_name.trim());
			pstmt_insert1.setString(2,rf_base_uom.trim());
			pstmt_insert1.setString(3,login_by_id.trim());
			pstmt_insert1.setString(4,login_at_ws_no.trim());
			pstmt_insert1.setString(5,login_facility_id.trim());
			pstmt_insert1.setString(6,rf_id.trim());
			int result1	=	pstmt_insert1.executeUpdate();

			if(result1!=0) {


			if(Im_module_yn.equals("1")) {
				pstmt_delete = connection.prepareStatement( SQL_PH_RECONSTITUENT_FLUID_DTL_DELETE ) ;
				pstmt_delete.setString(1,rf_id.trim());

				pstmt_delete.executeUpdate();
				
				pstmt_insert2 = connection.prepareStatement( SQL_PH_RECONSTITUENT_FLUID_DTL_INSERT ) ;
	
			for (int i=0;i<MultipleData.size() ;i++ ){
				
				ArrayList dataRow = (ArrayList)MultipleData.get(i);
				
				String item_code	= (String)dataRow.get(0);
				String content_in_base_uom	= (String)dataRow.get(1);

				if (item_code==null || item_code.equals("")|| item_code.equals("null") )
				{
					continue; 
				}
				//rtn_ord_disp_locn_code will be null only if routing_level is source
				
				debug.append( " rf_id:"+rf_id);
				debug.append( " item_code:"+item_code);
				debug.append( " content_in_base_uom:"+content_in_base_uom);

					pstmt_insert2.setString(1,rf_id.trim());
					pstmt_insert2.setString(2,item_code.trim());
					pstmt_insert2.setString(3,content_in_base_uom.trim());
					pstmt_insert2.setString(4,login_by_id.trim());
					pstmt_insert2.setString(5,login_at_ws_no.trim());
					pstmt_insert2.setString(6,login_facility_id.trim());
					pstmt_insert2.setString(7,login_by_id.trim());
					pstmt_insert2.setString(8,login_at_ws_no.trim());
					pstmt_insert2.setString(9,login_facility_id.trim());
					pstmt_insert2.addBatch();			
			}
				int[] result2= pstmt_insert2.executeBatch();
				for (int i=0;i<result2.length ;i++ ){
					// A number greater than or equal to zero  indicates success
					// A number -2 indicates that command is successful but number of rows updated is unknow
					// If it won't satisfy any of the above cancel the statement and throw an exception
					debug.append("Source::Result:"+result2[i]);
					if(result2[i]<0  && result2[i] != -2 ){
						pstmt_insert2.cancel();
						//throw new EJBException("Modify Failed");
					}			
				}
					

			

			}
			
			}
			else{
				map.put("flag","exception");
				//throw new EJBException("Failed in Reconstituent Modify");
			}

			map.put( "result", new Boolean( true ) ) ;
			messages.append( "RECORD_INSERTED" ) ;
			connection.commit();
		}catch( Exception e ) {
			try{
				connection.rollback();
				//throw new EJBException( e.getMessage() ) ;
			}
			catch ( Exception ee ) {
				messages.append( ee.getMessage() ) ;
			}
			messages.append( e.getMessage() ) ;
			e.printStackTrace() ;
		} finally {
			try {
				closeStatement(pstmt_delete);
				closeStatement( pstmt_insert1 ) ;
				closeStatement( pstmt_insert2 ) ;
				//closeConnection( connection,prop );
				closeConnection(connection);
			} catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		map.put( "msgid", messages.toString() ) ;
		map.put( "flag",debug.toString());
		return map ;
	}

}
