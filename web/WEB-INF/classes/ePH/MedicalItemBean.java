/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package ePH;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import javax.naming.* ;
import eCommon.Common.* ;
import ePH.MedicalItem.*;
import javax.rmi.* ;



public class MedicalItemBean extends PhAdapter implements Serializable{
	
	private String pres_base_uom="";
	protected String drug_code="";
	protected String item_code="";
	protected String drug_desc="";
	protected String pres_base_uom1="";
	protected String stock_uom="";
	protected String DispenseAlternate="";
	protected String generic_id="";
	protected String chk_opt="";
	protected String pack_size="";
	protected String disp_pres_uom="";
	protected String Eqvlvalue="";
	protected String in_formulary_yn="";
	protected String link_to_existing_item="";
	protected String strength_value="0";
	protected String debug="";
	protected String in_formulary_yn_value="";
	protected String disp_pres_uom_Update="";
	protected String DrugCodeValue="";
	protected String or_yn			= "";
	
	protected	ArrayList	trade				=	new ArrayList();
	protected	ArrayList	tradeValues				=	new ArrayList();
	protected	ArrayList	tradeResult				=	new ArrayList();
	 public MedicalItemBean(){
        try{
            doCommon();
        }
        catch(Exception e){
           System.err.println("Error in Constructor"+e.toString());
		   e.printStackTrace();
		}
    }
public void clear()
	{  pres_base_uom="";
       trade=new ArrayList();
       tradeValues=new ArrayList();
	}
public void setTradeNamesAll(HashMap trade_map)	{
	if(this.trade==null)
		this.trade = new ArrayList();
	this.trade.add(trade_map);
}
public ArrayList getTradeNamesAll()	{
		return this.trade;
	}



public void setTradeResult(ArrayList tradeValues)	{
	this.tradeValues = tradeValues;
}
public ArrayList getTradeResult()	{
		return this.tradeValues;
	}


public void setResult(ArrayList tradeResult){
	this.tradeResult = tradeResult;
}
public ArrayList getResult(){
		return this.tradeResult;
	}

public void setDrugCodeValue(String DrugCodeValue)
	{
	this.DrugCodeValue=DrugCodeValue;
	}

public String getDrugCodeValue(){
		return this.DrugCodeValue;
	}


public void setEqvlvalue(String Eqvlvalue){
	  this.Eqvlvalue=Eqvlvalue;
}
public String getEqvlvalue(){
		return this.Eqvlvalue;
	}


public void setORModuleYN(String or_yn)	{
		this.or_yn = or_yn;
	}











private void doCommon() throws Exception{
	}
public void setAll(Hashtable recordSet)
	{
		
		if(recordSet.containsKey("drug_code"))
        drug_code=(String)recordSet.get("drug_code");
		      
		if(recordSet.containsKey("item_code"))
        item_code=(String)recordSet.get("item_code");
		if(item_code.equals(""))
		{
               link_to_existing_item="N";
		}
		else
		{
                 link_to_existing_item="Y";
		}
		if(recordSet.containsKey("drug_desc"))
        drug_desc=(String)recordSet.get("drug_desc");

		if(recordSet.containsKey("pres_base_uom"))
        pres_base_uom1=(String)recordSet.get("pres_base_uom");
		
		 if(recordSet.containsKey("stock_uom"))
        stock_uom=(String)recordSet.get("stock_uom");
				
		if(recordSet.containsKey("DispenseAlternate"))
 DispenseAlternate = ((String)recordSet.get("DispenseAlternate")).equals("")?"N":(String)recordSet.get("DispenseAlternate") ;
				
		if(recordSet.containsKey("generic_id"))
        generic_id=(String)recordSet.get("generic_id");
		        
		if(recordSet.containsKey("chk_opt"))
 chk_opt = ((String)recordSet.get("chk_opt")).equals("")?"D":(String)recordSet.get("chk_opt") ;

		if(recordSet.containsKey("pack_size"))
        pack_size=(String)recordSet.get("pack_size");
		
		if(recordSet.containsKey("disp_pres_uom"))
        disp_pres_uom=(String)recordSet.get("disp_pres_uom");
		        
		if(recordSet.containsKey("in_formulary_yn_value"))
        in_formulary_yn_value=(String)recordSet.get("in_formulary_yn_value");

		

       if(recordSet.containsKey("disp_pres_uom_Update"))
        disp_pres_uom_Update=(String)recordSet.get("disp_pres_uom_Update");
				
	}

 public ArrayList getPrescribingUnit(String locale){
	  Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		ArrayList PrescribingUnit =		new ArrayList();
		
		try {
			connection	 = getConnection() ;
             pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_MEDICAL_ITEM_UOM_SELECT" )) ;
	         // pstmt			 = connection.prepareStatement("SELECT UOM_CODE, SHORT_DESC FROM AM_UOM WHERE QTY_UOM_YN = 'Y' and EFF_STATUS='E' Order by SHORT_DESC") ;
			 pstmt.setString(1,locale);
			 resultSet      = pstmt.executeQuery() ;

			while (resultSet.next()) {
				HashMap rec		=	new HashMap();
				String code,desc;
				code					=	resultSet.getString("UOM_CODE");
				desc					=	resultSet.getString("SHORT_DESC");
				rec.put("code",code);
				rec.put("desc",desc);
				PrescribingUnit.add(rec);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
				es.printStackTrace() ;
			}
		}
		return PrescribingUnit;
	  }

public ArrayList getDispensingUnitrelated (String pres_base_uom,String locale){
	  Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		ArrayList DispensingUnitrelated =		new ArrayList();
		
		try {
			connection	 = getConnection() ;
            pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_MEDICAL_ITEM_UOM_SELECT1")) ;
         // pstmt			 = connection.prepareStatement("SELECT UOM_CODE, SHORT_DESC FROM AM_UOM WHERE UOM_CODE != ? AND QTY_UOM_YN = 'Y' and EFF_STATUS='E' Order by SHORT_DESC") ;
              pstmt.setString(1,pres_base_uom);
              pstmt.setString(2,locale);
			 resultSet      = pstmt.executeQuery() ;

			while (resultSet.next()) {
				HashMap rec		=	new HashMap();
				String code,desc;
				code					=	resultSet.getString("UOM_CODE");
				desc					=	resultSet.getString("SHORT_DESC");
				rec.put("code",code);
				rec.put("desc",desc);
				DispensingUnitrelated.add(rec);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
				es.printStackTrace() ;
			}
		}
		return DispensingUnitrelated;
	  }

 public String getManufacturerName(String trade_id){
	
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
		String manufacturer_id		=	"";
		String manufacturer_name	=	"";
		String manufacturer_detail	=	"";
		try{

			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT24") ) ;
			pstmt.setString(1,trade_id.trim());
			pstmt.setString(2,getLanguageId());
			resultSet	= pstmt.executeQuery(); 
			if ( resultSet != null && resultSet.next() ) {
				manufacturer_id		=	resultSet.getString("code");
				manufacturer_name	=	resultSet.getString("description");
			}
			manufacturer_detail	=	manufacturer_id+":"+manufacturer_name;
		}
		catch(Exception e){
			manufacturer_detail=e.toString();
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
		return manufacturer_detail;	
	}



public ArrayList getTradeNames(String itemcode){
           
			Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
		ArrayList trade =		new ArrayList();
		try{

			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TRADE_NAME_FOR_DRUG_SELECT") ) ;
			pstmt.setString(1,itemcode.trim());
			resultSet	= pstmt.executeQuery(); 
			
			while ( resultSet != null && resultSet.next() )
				{
				HashMap rec		=	new HashMap();
				rec.put("trade_id",resultSet.getString("TRADE_ID"));
				rec.put("trade_name",resultSet.getString("SHORT_DESC1"));
				rec.put("manufacturer_id",resultSet.getString("MANUFACTURER_ID"));
				rec.put("manufacturer_name",resultSet.getString("SHORT_DESC2"));
				trade.add(rec);
			}
			
		}
		catch(Exception e){
			e.printStackTrace() ;
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
		//System.err.println("trade------>"+trade);
		return trade;	
	}
	
public String getEqvlValue(String uom_code, String eqvl_uom_code){
	
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		String	 eqvl_value		= "";
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT13") ) ;
			pstmt.setString(1,uom_code.trim());
			pstmt.setString(2,eqvl_uom_code.trim());
			resultSet	= pstmt.executeQuery(); 
			if ( resultSet != null && resultSet.next() ) {
					eqvl_value	=	resultSet.getString("eqvl_value");
			}
			else{
				resultSet	=	null;
				pstmt.setString(1,eqvl_uom_code.trim());
				pstmt.setString(2,uom_code.trim());
				resultSet	= pstmt.executeQuery();	
				if ( resultSet != null && resultSet.next() ) 
					eqvl_value	=	resultSet.getString("eqvl_value");
			}
		}
		catch(Exception e){
			eqvl_value=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return eqvl_value;	
	}


public int getDrug_Code(String Drug_code){
	
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		int	 drug_code_value		=0;
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MEDICAL_ITEM_TRADE_COUNT") ) ;
			//pstmt				= connection.prepareStatement("SELECT COUNT(1) CNT FROM ph_drug WHERE drug_code = ?") ;
			pstmt.setString(1,Drug_code.trim());
			
			resultSet	= pstmt.executeQuery(); 
			if ( resultSet != null && resultSet.next() ) {
					drug_code_value	=	resultSet.getInt("CNT");
			}
			
		}
		catch(Exception e){
			e.printStackTrace() ;
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return drug_code_value;	
	}


public ArrayList getTradeResult(String DrugCodeValue,String local){
        
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
		ArrayList allTraderecords =		new ArrayList();
		try{
			connection			= getConnection() ;
	        pstmt	= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_MEDICAL_ITEM_SELECT2") ) ;
			//pstmt				= connection.prepareStatement("SELECT trade.trade_id,trade.short_name trade_name,manufact.short_name manufact_name,drgtrade.eff_status FROM ph_trade_name_for_drug drgtrade, am_trade_name_lang_vw trade,am_manufacturer_lang_vw manufact WHERE  drgtrade.trade_code = trade.trade_id AND drgtrade.drug_code = ? AND trade.language_id =? AND trade.manufacturer_id = manufact.manufacturer_id(+) AND manufact.language_id(+) = ?") ;
			pstmt.setString(1,DrugCodeValue.trim());
			pstmt.setString(2,local);
			pstmt.setString(3,local);
			resultSet	= pstmt.executeQuery(); 
			
			while ( resultSet != null && resultSet.next() )
				{
				HashMap rec		=	new HashMap();
				rec.put("trade_id",resultSet.getString("trade_id"));
				rec.put("trade_name",resultSet.getString("trade_name"));
				rec.put("manufacturer_name",resultSet.getString("manufact_name"));
				rec.put("select",resultSet.getString("eff_status"));
				allTraderecords.add(rec);
				
			}
			
		}
		catch(Exception e){
			e.printStackTrace() ;
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
		//System.err.println("allTraderecords---from bean--->"+allTraderecords);
		return allTraderecords;	
	}

public ArrayList getResult(String DrugCodeValue,String local){
        
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
		ArrayList allrecords =		new ArrayList();
		try{
			connection			= getConnection() ;
			pstmt	= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_MEDICAL_ITEM_SELECT3") ) ;
			//pstmt				= connection.prepareStatement("SELECT drg.drug_code,drg.item_code, drg.drug_desc, drg.in_formulary_yn, disp_alt_form_yn,generic_name,drg.generic_id, drg.discontinued_yn,drg.disp_multi_strength_yn,drg.pres_base_uom,drg.stock_uom,drg.content_in_pres_base_uom FROM ph_drug_lang_vw drg,mm_item_lang_vw itm,ph_generic_name_lang_vw genname  WHERE drg.item_code = itm.item_code(+) AND drg.generic_id = genname.generic_id(+) AND drg.language_id = itm.language_id(+) AND drg.drug_code = ? AND drg.language_id = ? AND genname.language_id(+) = ?");
			pstmt.setString(1,DrugCodeValue.trim());
			pstmt.setString(2,local);
			pstmt.setString(3,local);
			resultSet	= pstmt.executeQuery(); 
			
			while ( resultSet != null && resultSet.next() )
				{
				HashMap rec		=	new HashMap();
				rec.put("drug_code",resultSet.getString("drug_code"));
				rec.put("item_code",resultSet.getString("item_code"));
				rec.put("drug_desc",resultSet.getString("drug_desc"));
				rec.put("in_formulary_yn",resultSet.getString("in_formulary_yn"));
				rec.put("disp_alt_form_yn",resultSet.getString("disp_alt_form_yn"));
				rec.put("generic_name",resultSet.getString("generic_name"));
				rec.put("generic_id",resultSet.getString("generic_id"));
				rec.put("discontinued_yn",resultSet.getString("discontinued_yn"));
				rec.put("disp_multi_strength_yn",resultSet.getString("disp_multi_strength_yn"));
				rec.put("pres_base_uom",resultSet.getString("pres_base_uom"));
				rec.put("stock_uom",resultSet.getString("stock_uom"));
				rec.put("content_in_pres_base_uom",resultSet.getString("content_in_pres_base_uom"));
				allrecords.add(rec);
				
			}
			
		}
		catch(Exception e){
			e.printStackTrace() ;
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
		//System.err.println("allrecords------>"+allrecords);
		return allrecords;	
	}

public String getORModuleYN() {
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		String module_id		= "";

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT11"));
			resultSet	= pstmt.executeQuery();

			while(resultSet.next()) {
				module_id = resultSet.getString("MODULE_ID");

				if ((module_id.trim().equals("OR"))) {
					setORModuleYN("Y");
				}
			}
		}
		catch(Exception e) {
			System.err.println("Error while checking OR installation :" + e);
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Error while checking OR installation :" + es);}
		}
		return this.or_yn;
	}



/***Used to check the drug code is present in OR ***/
public boolean getDrugStatusInOR(String drug_code){

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		String	 drug_name		= "";

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_OR_PH_COUNT_CHECK") ) ;
			pstmt.setString(1,drug_code.trim());
			resultSet	= pstmt.executeQuery(); 
			if ( resultSet != null && resultSet.next() ) {
				drug_name		=	resultSet.getString("ORDER_CATALOG_CODE");
			}
	
		}catch(Exception e){
			drug_name=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		if(drug_name.equals(""))
				return false;
		else 
			return true;
	}

public HashMap insert() {
	
	HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		ArrayList insertData = new ArrayList() ;
		HashMap tabData = new HashMap() ;
		HashMap sqlMap = new HashMap() ;
		try {
               insertData.add( drug_code ) ;
			   insertData.add( drug_desc ) ;
		       insertData.add( in_formulary_yn_value ) ;
		       insertData.add( link_to_existing_item ) ;
			   insertData.add( item_code ) ;
			   insertData.add( generic_id ) ;
			   insertData.add( strength_value ) ;
		       insertData.add( pres_base_uom1 ) ;
               insertData.add( stock_uom) ;
               insertData.add( Eqvlvalue) ;
               insertData.add( DispenseAlternate) ;
               insertData.add( DispenseAlternate) ;
               insertData.add( chk_opt) ;
		       insertData.add( login_by_id.trim() ) ;
			   insertData.add( login_at_ws_no.trim() ) ;
			   insertData.add( login_facility_id.trim() ) ;
			   insertData.add( login_by_id.trim() ) ;
			   insertData.add( login_at_ws_no.trim() ) ;
			   insertData.add( login_facility_id.trim() ) ;

			   tabData.put( "properties", getProperties() );
			   tabData.put("insertData",insertData);
    		   tabData.put("trade",trade);
		       sqlMap.put("SQL_PH_DRUG_MEDICAL_ITEM_INSERT",PhRepository.getPhKeyValue("SQL_PH_DRUG_MEDICAL_ITEM_INSERT") );
			   sqlMap.put("SQL_PH_DRUG_MEDICAL_ITEM_TRADE_NAME_INSERT",PhRepository.getPhKeyValue("SQL_PH_DRUG_MEDICAL_ITEM_TRADE_NAME_INSERT") );

           
			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue("JNDI_PH_MEDICAL_ITEM"),MedicalItemLocalHome.class,getLocalEJB());
			Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);
						
			
          
			Object argArray[]=new Object[2];
			Class[] paramArray=new Class[2];
			
   			argArray[0]=tabData;
			argArray[1]=sqlMap;

			paramArray[0]=tabData.getClass();
			paramArray[1]=sqlMap.getClass();

			
			HashMap result=(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			if( ((Boolean) result.get( "result" )).booleanValue() ){
				map.put("flag","result is true");
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH") ) ;
			}
			else{
				map.put("flag","result is false");
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH")) ;
			}
			
		}
		catch(Exception e) {
			map.put("message",e.toString());
			e.printStackTrace() ;

		}
		/*finally {
			try {
			
			} 
			catch( Exception ee ){
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}*/

		map.put("flag",debug);
		return map ;
	 }

public HashMap modify() {
          HashMap map = new HashMap() ;
		  ArrayList mandatory_flds=new ArrayList();
		  
         map.put( "result", new Boolean( false ) ) ;
			
		 mandatory_flds.add( drug_desc ) ;
		 mandatory_flds.add( in_formulary_yn_value ) ;
		 mandatory_flds.add( link_to_existing_item ) ;
		 mandatory_flds.add( item_code ) ;
		 mandatory_flds.add( generic_id ) ;
		 mandatory_flds.add( strength_value ) ;
		 mandatory_flds.add( pres_base_uom1 ) ;
         mandatory_flds.add( stock_uom) ;
         mandatory_flds.add( disp_pres_uom_Update) ;
         mandatory_flds.add( DispenseAlternate) ;
         mandatory_flds.add( DispenseAlternate) ;
         mandatory_flds.add( chk_opt) ;
		 mandatory_flds.add( login_by_id.trim() ) ;
		 mandatory_flds.add( login_at_ws_no.trim() ) ;
		 mandatory_flds.add( login_facility_id.trim() ) ;
		 mandatory_flds.add( drug_code ) ;
		

		HashMap tabData = new HashMap() ;
		HashMap sqlMap = new HashMap() ;
		//StringBuffer messages			=	new StringBuffer() ;
		String  debug				="";

		try {
				
			   tabData.put( "properties", getProperties() );
			   tabData.put("mandatory_flds",mandatory_flds);
			   tabData.put("tradeValues",tradeValues);
			
					
					
sqlMap.put("SQL_PH_DRUG_MEDICAL_ITEM_UPDATE",PhRepository.getPhKeyValue("SQL_PH_DRUG_MEDICAL_ITEM_UPDATE") );
sqlMap.put("SQL_PH_DRUG_MEDICAL_ITEM_TRADE_NAME_UPDATE",PhRepository.getPhKeyValue("SQL_PH_DRUG_MEDICAL_ITEM_TRADE_NAME_UPDATE") );

sqlMap.put("SQL_PH_DRUG_MEDICAL_ITEM_TRADE_NAME_INSERT",PhRepository.getPhKeyValue("SQL_PH_DRUG_MEDICAL_ITEM_TRADE_NAME_INSERT") );

sqlMap.put("SQL_PH_MEDICAL_ITEM_TRADE_COUNT1",PhRepository.getPhKeyValue("SQL_PH_MEDICAL_ITEM_TRADE_COUNT1") );





			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue("JNDI_PH_MEDICAL_ITEM"),MedicalItemLocalHome.class,getLocalEJB());
			Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);
			
			
          
			Object argArray[]=new Object[2];
			Class[] paramArray=new Class[2];
			
   			argArray[0]=tabData;
			argArray[1]=sqlMap;

			paramArray[0]=tabData.getClass();
			paramArray[1]=sqlMap.getClass();

			
			HashMap result=(HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

            //System.err.println("result--------from bean----->"+result);


			if( ((Boolean) result.get( "result" )).booleanValue() ){
				map.put("flag","result is true");
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH") ) ;
			}
			else{
				map.put("flag","result is false");
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH")) ;
			}
			
		}
		catch(Exception e) {
			map.put("message",e.toString());
			e.printStackTrace() ;

		}
		

		map.put("flag",debug);
		return map ;
	 }

 public HashMap validate() throws Exception {
	// System.err.println("calling validate method");
		
        HashMap map                 =   new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "success.." ) ;

		
		return map ;
    }

	
}
