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
/*import javax.rmi.PortableRemoteObject ;
import javax.naming.InitialContext ;*/
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.DiscontinueDrug.*;

public class DiscontinueDrugBean extends PhAdapter implements Serializable {

	private String drug_name			= "" ;
	private String drug_code			= "" ;
	private String generic_name			= "" ;
	private String strength_value		= "" ;
	private String form_of_drug			= "" ;
	private String admin_route			= "" ;
	private String base_unit			= "" ;
	private String compound_drug_yn		= "" ;
	private String discontinued_yn		= "Y" ;
	private String discontinued_reason	= "" ;
	
    public DiscontinueDrugBean() 
		{
        try 
		{
            doCommon();
        }
        catch(Exception e) 
		{
			System.err.println("Exception in constructor"+e.toString());
			e.printStackTrace();
		}
    }

	public void clear() 
	{
		super.clear() ;
		drug_name			= "" ;
		drug_code			= "" ;
		generic_name		= "" ;
		strength_value		= "" ;
		form_of_drug		= "" ;
		admin_route			= "" ;
		base_unit			= "" ;
		compound_drug_yn	= "" ;
		discontinued_yn		= "" ;
		discontinued_reason	= "" ;
	}

	private void doCommon() throws Exception {}

	public void setAll( Hashtable recordSet ) {
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;

		if(recordSet.containsKey("DRUG_NAME"))
			setDrugName((String)recordSet.get("DRUG_NAME")) ;

		if(recordSet.containsKey("DRUG_CODE"))
			setDrugCode((String)recordSet.get("DRUG_CODE")) ;

		if(recordSet.containsKey("GENERIC_NAME"))
			setGenericName((String)recordSet.get("GENERIC_NAME")) ;

		if(recordSet.containsKey("STRENGTH_VALUE"))
			setStrengthValue((String)recordSet.get("STRENGTH_VALUE")) ;

		if(recordSet.containsKey("FORM_OF_DRUG"))
			setFormOfDrug((String)recordSet.get("FORM_OF_DRUG")) ;

		if(recordSet.containsKey("ADMIN_ROUTE"))
			setAdminRoute((String)recordSet.get("ADMIN_ROUTE")) ;

		if(recordSet.containsKey("BASE_UNIT"))
			setBaseUnit((String)recordSet.get("BASE_UNIT")) ;

		if(recordSet.containsKey("COMPOUND_DRUG_YN"))
			setCompoundDrugYN((String)recordSet.get("COMPOUND_DRUG_YN")) ;

		if(recordSet.containsKey("DISCONTINUED_YN")){
			discontinued_yn =(String)recordSet.get("DISCONTINUED_YN");
			if((discontinued_yn==null)||(discontinued_yn.equals(""))){
			    setDiscontinuedYN("N") ;
			}else{
                setDiscontinuedYN((String)recordSet.get("DISCONTINUED_YN")) ;
			}
		}

		if(recordSet.containsKey("DISCONTINUED_REASON"))
			setDiscontinueReason((String)recordSet.get("DISCONTINUED_REASON")) ;
	}

	public void setDrugName(String drug_name) {
		this.drug_name = drug_name;
	}

	public void setDrugCode(String drug_code) {
		this.drug_code = drug_code;
	}

	public void setGenericName(String generic_name) {
		this.generic_name = generic_name;
	}

	public void setStrengthValue(String strength_value) {
		this.strength_value = strength_value;
	}

	public void setFormOfDrug(String form_of_drug) {
		this.form_of_drug = form_of_drug;
	}

	public void setAdminRoute(String admin_route) {
		this.admin_route = admin_route;
	}

	public void setBaseUnit(String base_unit) {
		this.base_unit = base_unit;
	}

	public void setCompoundDrugYN(String compound_drug_yn) {
		this.compound_drug_yn = compound_drug_yn;
	}

	public void setDiscontinuedYN(String discontinued_yn) {

		this.discontinued_yn = discontinued_yn;
	}

	public void setDiscontinueReason(String discontinued_reason) {
		this.discontinued_reason = discontinued_reason;
	}

	public String getDrugName() {
		return this.drug_name;
	}

	public String getDrugCode() {
		return this.drug_code;
	}

	public String getGenericName() {
		return this.generic_name;
	}

	public String getStrengthValue() {
		return this.strength_value;
	}

	public String getFormOfDrug() {
		return this.form_of_drug;
	}

	public String getAdminRoute() {
		return this.admin_route;
	}

	public String getBaseUnit() {
		return this.base_unit;
	}

	public String getCompoundDrugYN() {
		return this.compound_drug_yn;
	}

	public String getDiscontinuedYN() {
		return this.discontinued_yn;
	}

	public String getDiscontinueReason() {
		return this.discontinued_reason;
	}

	public HashMap validate() throws Exception {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map ;
	}

	public HashMap modify() {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;

		boolean validateORUpdate = checkforORUpdate();

		ArrayList forDrugTable	= new ArrayList() ;
		ArrayList forOrderTable	= null ;

		forDrugTable.add( getDiscontinuedYN() ) ;
		forDrugTable.add( getDiscontinueReason() ) ;
		forDrugTable.add( login_by_id ) ;
		forDrugTable.add( login_at_ws_no ) ;
		forDrugTable.add( login_facility_id ) ;
		forDrugTable.add( login_by_id ) ;
		forDrugTable.add( getDrugCode() ) ;

		HashMap tabData	= new HashMap() ;
		HashMap sqlMap	= new HashMap() ;

		try {
			tabData.put( "PROPERTIES", getProperties() );
			tabData.put( "DRUGDATA", forDrugTable);

			sqlMap.put( "SQLPHDRUG", PhRepository.getPhKeyValue( "SQL_PH_DISC_DRUG_UPDATE" ) );

			if (validateORUpdate) {
				forOrderTable	= new ArrayList();
				
				if(getDiscontinuedYN().equals("Y"))
				    forOrderTable.add("D");
                else
					forOrderTable.add("E"); 
				forOrderTable.add(getDrugCode());

				tabData.put( "ORDERDATA", forOrderTable);
				//sqlMap.put( "SQLORCATALOG", PhRepository.getPhKeyValue( "SQL_PH_DISC_OR_ORDER_UPDATE" ) );
				sqlMap.put( "SQLORCATALOG","UPDATE OR_ORDER_CATALOG SET EFF_STATUS=? WHERE ORDER_CATALOG_CODE=?");
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return CallDiscontinueDrug(tabData,sqlMap);
	}

	private  HashMap CallDiscontinueDrug(HashMap tabData , HashMap sqlMap ) {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

/*		DiscontinueDrugHome home = null;
		DiscontinueDrugRemote remote = null;*/

		try {

/*			InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_DISC_DRUG") ) ;
			home  = (DiscontinueDrugHome) PortableRemoteObject.narrow( object, DiscontinueDrugHome.class ) ;
			remote = home.create() ;

			if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) )
				map = remote.modify( tabData, sqlMap ) ;*/

			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue("JNDI_PH_DISC_DRUG"),DiscontinueDrugHome.class,getLocalEJB());
			Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]=new Object[2];
			argArray[0]=tabData;
			argArray[1]=sqlMap;

			Class[] paramArray=new Class[2];
			paramArray[0]=tabData.getClass();
			paramArray[1]=sqlMap.getClass();

			map=(HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) map.get( "result" )).booleanValue() )
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			else
				map.put( "message", (map.get("msgid"))) ;
		}
		catch(Exception e) {
			System.err.println( "Error Calling EJB classcast : "+e ) ;
			map.put( "message", e.getMessage()) ;
			e.printStackTrace() ;
			map.put( "flag", "EXP HERE:" + e);
		}
		/*finally {
			try {
				if( remote != null )
					remote.remove() ;
			}
			catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}*/
		return map;
	}

	public void loadData(String drug_code) throws Exception {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISC_DRUG_SELECT3" )) ;
			pstmt.setString(1, drug_code) ;
			pstmt.setString(2, getLanguageId()) ;
			resultSet = pstmt.executeQuery() ;

			if ( resultSet.next() ) {
				setDrugName(resultSet.getString("DRUG_DESC"));
				setDrugCode(resultSet.getString("DRUG_CODE"));
				setGenericName(resultSet.getString("GENERIC_NAME"));
				setStrengthValue(resultSet.getString("STRENGTH_VALUE"));
				setFormOfDrug(resultSet.getString("FORM_DESC"));
				setAdminRoute(resultSet.getString("ROUTE_DESC"));
				setBaseUnit(resultSet.getString("PRES_BASE_DESC"));
				setCompoundDrugYN(resultSet.getString("COMPOUND_DRUG_YN"));
				setDiscontinuedYN(resultSet.getString("DISCONTINUED_YN"));
				setDiscontinueReason(resultSet.getString("DISCONTINUED_REASON"));
			}
		}
		catch ( Exception e ) {
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) 
			{
			System.err.println("Error while closing statements and resultsets"+es.toString());
			}
		}
	}

	private boolean checkforORUpdate() {
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		boolean chkORInstalled	= false ;
		boolean retVal			= false ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISC_DRUG_SELECT4" )) ;
			resultSet = pstmt.executeQuery() ;

			if ( resultSet.next() ) {
				if (resultSet.getString("MODULE_ID").trim().equals("OR"))
					chkORInstalled = true ;
			}

			if (chkORInstalled) {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISC_DRUG_SELECT5" )) ;
				pstmt.setString(1, getDrugCode()) ;
				resultSet = pstmt.executeQuery() ;

				if ( resultSet.next() )
					retVal = true ;
			}
		}
		catch ( Exception e ) {
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) 
			{
				System.err.println("Error while closing statements and resultsets"+es.toString());
			}
		}
		return retVal;
	}
	// added for #IN008177 by Abdul Sukkur on 26/2/09
	public boolean isItemEnabledInMM(String itemcode)
	{
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		boolean enabledInMM=true;
		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement("select EFF_STATUS from MM_ITEM where ITEM_CODE=?") ;
			pstmt.setString(1,itemcode.trim());
			resultSet = pstmt.executeQuery() ;
			if ( resultSet.next() ) 
			{
				if (resultSet.getString("EFF_STATUS").trim().equals("D"))
					enabledInMM = false ;
			}
		}
		catch ( Exception e ) 
		{
			System.err.println( "Error in isItemEnabledInMM()" ) ;
			e.printStackTrace() ;
		}
		finally 
		{
			try 
			{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) 
			{
				System.err.println("Error while closing statements and resultsets in isItemEnabledInMM()"+es.toString());
			}
		}
		return enabledInMM;
	}
	//end addition
}
