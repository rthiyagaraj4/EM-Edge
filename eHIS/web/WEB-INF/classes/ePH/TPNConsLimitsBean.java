/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH ;
import java.io.Serializable ;
import java.util.* ;
import java.sql.* ;
//import javax.rmi.PortableRemoteObject ;
//import javax.naming.InitialContext ;
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;
import ePH.TPNConsLimits.*;

//saved on 25/10/2005

public class TPNConsLimitsBean extends PhAdapter implements Serializable {

//	private HashMap initDatas	= null;
//	private TreeSet assoDatas	= null;

	
	private Hashtable recordSet		= new Hashtable();
	String regimen_code = "";
	String regimen_name = "";
	HashMap	regAdd =new HashMap();
    //private String remarks                      = ""; //Commented for common-icn-0048
	HashMap remarksmap=new HashMap();
	public TPNConsLimitsBean()
	{
		//Constructor
		try
		{
			doCommon() ;
		}
		catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	/* Over-ridden Adapter methods start here */
	private void doCommon() throws Exception
	{
	}

	public void clear()
	{
		super.clear() ;

	}

	/* Over-ridden Adapter methods endS here */
	/* Function specific methods start */



	public String getLoggedInFacility()
	{
		return login_facility_id;
	}
/*
//@
	public void setRegimen_code(String regimen_code)
	{
		this.regimen_code=regimen_code;
	}

	public String getRegimen_code(){
		return regimen_code;
	}
*/
public void setRegimen_name(String regimen_name){
		this.regimen_name=regimen_name;
	}

	public String getRegimen_name(){
		return regimen_name;
	}
	//@//
/*public void setTpnConsLimitsRemarks(String remarks){
	//System.out.println("in bean");
	    this.remarks = remarks;
		
	}

	public String getTpnConsLimitsRemarks(){
		return this.remarks;
		
	}*/

public void saveRemarks(String row_no,String remarks){
		remarksmap.put(row_no,remarks);
		//System.out.println("remarks in bean:"+remarks);
		//System.out.println("all remarks:"+remarksmap);
	}

public String getRemarks(String row_no){
		return ((String)remarksmap.get(row_no));
		
	}


	public HashMap validate() throws Exception {
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}
public String checkIfOrderUOMDefined()
{
		Connection connection= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String result="N";

		try {
			connection = getConnection() ;
			//this query retrieveds age groups
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_CONS_LIMIT_ORDERUOMDEFINED" )) ;
			resultSet = pstmt.executeQuery() ;
			if (resultSet.next()) {
				result="Y";
			}

		}
		catch ( Exception e ) {
			//System.err.println( "Error loading values from database1" ) ;
			e.printStackTrace() ;
			result=e.toString();
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {System.err.println(es);
			}

		}
		return result;


}

public ArrayList  getRegimenList()
{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList RegimenList=new ArrayList();

		try {
			connection = getConnection() ;
			
	       // pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_REGIMEN_MAST_SELECT13" )) ;
			pstmt = connection.prepareStatement("SELECT LONG_NAME,TPN_REGIMEN_CODE FROM PH_TPN_REGIMEN WHERE STANDARD_REGIMEN_YN = 'N' ORDER BY 1 ") ;
           	resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				RegimenList.add(resultSet.getString("LONG_NAME"));
				RegimenList.add(resultSet.getString("TPN_REGIMEN_CODE"));
				

			}
		}
		catch ( Exception e ) {
			//System.err.println( "Error loading values from database1" ) ;
			e.printStackTrace() ;
			RegimenList.add(e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				System.err.println(es);
			}

		}
		return RegimenList;
}
public ArrayList  getAgeGroups(String locale)
{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList result=new ArrayList();

		try {
			connection = getConnection() ;
			//this query retrieveds age groups
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_CONS_LIMIT_SELECT1" )) ;
			 pstmt.setString(1,locale);
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				result.add(resultSet.getString("AGE_GROUP_CODE"));
				result.add(resultSet.getString("SHORT_DESC"));
				result.add(resultSet.getString("GENDER"));
				result.add(resultSet.getString("MIN_AGE"));
				result.add(resultSet.getString("MAX_AGE"));
				result.add(resultSet.getString("AGE_UNIT"));

			}
		}
		catch ( Exception e ) {
			//System.err.println( "Error loading values from database1" ) ;
			e.printStackTrace() ;
			result.add(e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				System.err.println(es);
			}

		}
		return result;

}

public String getAgegroupFlag(String regimencode,String ageGroupcode){

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String  age_group_flag="N";

		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_CONS_LIMIT_HDR_SELECT1" )) ;
			pstmt = connection.prepareStatement("SELECT DECODE(COUNT(*),0,'N','Y') FROM PH_TPN_CONSTITUENT_LIMIT WHERE AGE_GROUP_CODE = ? AND TPN_REGIMEN_CODE = ? ") ;
			pstmt.setString(1,ageGroupcode);
			pstmt.setString(2,regimencode);
			resultSet = pstmt.executeQuery() ;
			if (resultSet.next()) {
				age_group_flag=resultSet.getString(1);
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
				System.err.println(es);
			}

		}
	return age_group_flag;

}

public ArrayList getAgeGroupDetails(String ageGroupcode,String regimen_code){
	Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList result=new ArrayList();

		try {
			connection = getConnection() ;
			//this query retrieveds age groups

			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_CONS_LIMIT_HDR_SELECT2A" )) ;
			pstmt = connection.prepareStatement("SELECT GENDER SEL_GENDER, MIN_AGE * DECODE(AGE_UNIT,'D',1,'M',30,'Y',360) MIN_AGE_IN_DAYS,MAX_AGE * DECODE(AGE_UNIT_MAX,'D',1,'M',30,'Y',360) MAX_AGE_IN_DAYS FROM AM_AGE_GROUP a WHERE AGE_GROUP_CODE = ? AND NOT EXISTS (SELECT TPN_REGIMEN_CODE FROM PH_TPN_CONSTITUENT_LIMIT WHERE TPN_REGIMEN_CODE = ? AND AGE_GROUP_CODE = A.AGE_GROUP_CODE)") ;
			pstmt.setString(1,ageGroupcode);
			pstmt.setString(2,regimen_code);
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				result.add(resultSet.getString("SEL_GENDER"));
				result.add(resultSet.getString("MIN_AGE_IN_DAYS"));
				result.add(resultSet.getString("MAX_AGE_IN_DAYS"));
			
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			result.add(e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				System.err.println(es);
			}

		}
		return result;

}

public String getOverlappFlag(String sel_gender, String min_age_in_days, String max_age_in_days,String regimencode){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String  overlapp_flag="N";

		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_CONS_LIMIT_HDR_SELECT3" )) ;
			pstmt = connection.prepareStatement("SELECT 'Y' FROM DUAL WHERE EXISTS ( SELECT 1 FROM AM_AGE_GROUP WHERE AGE_GROUP_CODE IN (SELECT DISTINCT AGE_GROUP_CODE FROM PH_TPN_CONSTITUENT_LIMIT WHERE TPN_REGIMEN_CODE=?) AND ( (? IS NULL AND ( ? BETWEEN MIN_AGE * DECODE(AGE_UNIT,'D',1,'M',30,'Y',360) AND MAX_AGE * DECODE(AGE_UNIT_MAX,'D',1,'M',30,'Y',360) OR ?  BETWEEN MIN_AGE * DECODE(AGE_UNIT,'D',1,'M',30,'Y',360) AND MAX_AGE * DECODE(AGE_UNIT_MAX,'D',1,'M',30,'Y',360) OR min_age * DECODE (age_unit,'D', 1,'M', 30,'Y', 360) BETWEEN ? AND ? OR max_age * DECODE (age_unit_max,'D',1,'M',30,'Y',360) BETWEEN ? AND ? )) OR (? IS NOT NULL AND ( GENDER IS NULL OR GENDER = ? ) AND ( ? BETWEEN MIN_AGE * DECODE(AGE_UNIT,'D',1,'M',30,'Y',360) AND MAX_AGE * DECODE(AGE_UNIT_MAX,'D',1,'M',30,'Y',360) OR ?  BETWEEN MIN_AGE * DECODE(AGE_UNIT,'D',1,'M',30,'Y',360) AND MAX_AGE * DECODE(AGE_UNIT_MAX,'D',1,'M',30,'Y',360) OR min_age * DECODE (age_unit,'D', 1,'M', 30,'Y', 360) BETWEEN ? AND ? OR max_age * DECODE (age_unit_max,'D',1,'M',30,'Y',360) BETWEEN ? AND ? ))))") ;
			pstmt.setString(1,regimencode);
			pstmt.setString(2,sel_gender);
			pstmt.setString(3,min_age_in_days);
			pstmt.setString(4,max_age_in_days);
			pstmt.setString(5,min_age_in_days);
			pstmt.setString(6,max_age_in_days);
			pstmt.setString(7,min_age_in_days);
			pstmt.setString(8,max_age_in_days);
			pstmt.setString(9,sel_gender);
			pstmt.setString(10,sel_gender);
			pstmt.setString(11,min_age_in_days);
			pstmt.setString(12,max_age_in_days);
			pstmt.setString(13,min_age_in_days);
			pstmt.setString(14,max_age_in_days);
			pstmt.setString(15,min_age_in_days);
			pstmt.setString(16,max_age_in_days);
			resultSet = pstmt.executeQuery() ;
			if (resultSet.next()) {
				overlapp_flag=resultSet.getString(1);
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
				System.err.println(es);
			}

		}
	return overlapp_flag;


}
public ArrayList  getResult(String regimen_code,String agegroup)//,String infusion_line
{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList result=new ArrayList();
		try {
			//System.out.println("in bean.get result");
			connection = getConnection() ;
			//this query retrieveds age groups

		//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_CONS_LIMIT_SELECT2" )) ;
			pstmt = connection.prepareStatement("SELECT  DISTINCT C.CONST_GENERIC_CODE,B.CONST_GROUP_NAME,  B.DISP_SRL_NO,  C.CONST_GENERIC_NAME,  (SELECT SHORT_DESC FROM AM_UOM WHERE UOM_CODE = A.ORDERING_UNIT and EFF_STATUS='E')CONST_QTY_UNIT,  (SELECT CONST_MIN_VAL FROM   PH_TPN_CONSTITUENT_LIMIT WHERE   C.CONST_GENERIC_CODE=CONST_GENERIC_CODE AND   AGE_GROUP_CODE=? AND TPN_REGIMEN_CODE = ?) CONST_MIN_VAL,   (SELECT CONST_MAX_VAL FROM PH_TPN_CONSTITUENT_LIMIT   WHERE C.CONST_GENERIC_CODE=CONST_GENERIC_CODE AND   AGE_GROUP_CODE=? AND TPN_REGIMEN_CODE = ?) CONST_MAX_VAL,  (SELECT CONST_STD_VAL FROM PH_TPN_CONSTITUENT_LIMIT   WHERE C.CONST_GENERIC_CODE=CONST_GENERIC_CODE AND   AGE_GROUP_CODE=? AND TPN_REGIMEN_CODE = ?) CONST_STD_VAL,(SELECT CONST_CEIL_VAL FROM PH_TPN_CONSTITUENT_LIMIT   WHERE C.CONST_GENERIC_CODE=CONST_GENERIC_CODE AND   AGE_GROUP_CODE=? AND TPN_REGIMEN_CODE = ?) CONST_CEIL_VAL,(SELECT CONST_USAGE_IND FROM PH_TPN_CONSTITUENT_LIMIT   WHERE C.CONST_GENERIC_CODE=CONST_GENERIC_CODE AND   AGE_GROUP_CODE=? AND TPN_REGIMEN_CODE = ?) CONST_USAGE_IND,(SELECT CONST_REMARKS FROM PH_TPN_CONSTITUENT_LIMIT   WHERE C.CONST_GENERIC_CODE=CONST_GENERIC_CODE AND   AGE_GROUP_CODE=? AND TPN_REGIMEN_CODE = ?) CONST_REMARKS ,(SELECT ORD_UNIT_IND FROM PH_TPN_CONSTITUENT_LIMIT   WHERE C.CONST_GENERIC_CODE=CONST_GENERIC_CODE AND   AGE_GROUP_CODE=? AND TPN_REGIMEN_CODE = ?) PREP_UNIT , ORD_UNIT_IND, ORDERING_UNIT,	C.DISP_SRL_NO SRL_NO  FROM       PH_TPN_PARAM_FOR_CONST A,PH_TPN_CONSTITUENT_GROUP B,PH_TPN_CONST_GENERIC_NAME C  	 WHERE  C.CONST_GROUP_CODE=B.CONST_GROUP_CODE AND    A.CONST_GROUP_CODE=B.CONST_GROUP_CODE AND    GROUP_OR_INDIVIDUAL_IND=C.UOM_SETUP_LEVEL_IND  AND   c.disp_srl_no=DECODE(c.const_group_code,'OT',A.srl_no,A.srl_no) AND ORDERING_UNIT <> 'X'ORDER BY  C.DISP_SRL_NO,B.DISP_SRL_NO,C.CONST_GENERIC_CODE") ;


			pstmt.setString(1,agegroup);
			pstmt.setString(2,regimen_code);			
			pstmt.setString(3,agegroup);
			pstmt.setString(4,regimen_code);
			pstmt.setString(5,agegroup);
			pstmt.setString(6,regimen_code);
			pstmt.setString(7,agegroup);
			pstmt.setString(8,regimen_code);			
			pstmt.setString(9,agegroup);
			pstmt.setString(10,regimen_code);
			pstmt.setString(11,agegroup);
			pstmt.setString(12,regimen_code);
			pstmt.setString(13,agegroup);
			pstmt.setString(14,regimen_code);
			//System.out.println("agegroup before result page"+agegroup);
            //System.out.println("regimen code before result page"+regimen_code);
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				//System.out.println("inside result set in bean");
				result.add(resultSet.getString("CONST_GROUP_NAME")==null?"":resultSet.getString("CONST_GROUP_NAME"));
				result.add(resultSet.getString("CONST_GENERIC_CODE")==null?"":resultSet.getString("CONST_GENERIC_CODE"));
				result.add(resultSet.getString("CONST_GENERIC_NAME")==null?"":resultSet.getString("CONST_GENERIC_NAME"));
				//result.add(resultSet.getString("CONST_QTY_UNIT")==null?"":resultSet.getString("CONST_QTY_UNIT"));		    
				result.add(resultSet.getString("ORDERING_UNIT")==null?"":resultSet.getString("ORDERING_UNIT"));
									//added line
			// result.add(resultSet.getString("ORD_UNIT_IND")==null?"":resultSet.getString("ORD_UNIT_IND"));
				result.add(resultSet.getString("CONST_MAX_VAL")==null?"":resultSet.getString("CONST_MAX_VAL"));
				result.add(resultSet.getString("CONST_MIN_VAL")==null?"":resultSet.getString("CONST_MIN_VAL"));
				result.add(resultSet.getString("CONST_STD_VAL")==null?"":resultSet.getString("CONST_STD_VAL"));
				result.add(resultSet.getString("ORD_UNIT_IND")==null?"":resultSet.getString("ORD_UNIT_IND"));
				result.add(resultSet.getString("CONST_QTY_UNIT")==null?"":resultSet.getString("CONST_QTY_UNIT"));	
				result.add(resultSet.getString("CONST_CEIL_VAL")==null?"":resultSet.getString("CONST_CEIL_VAL"));
				result.add(resultSet.getString("CONST_USAGE_IND")==null?"":resultSet.getString("CONST_USAGE_IND"));
				result.add(resultSet.getString("CONST_REMARKS")==null?"":resultSet.getString("CONST_REMARKS"));
				result.add(resultSet.getString("PREP_UNIT")==null?"":resultSet.getString("PREP_UNIT"));
				
			}
		}
		catch ( Exception e ) {
			//System.err.println( "Error loading values from database1" ) ;
			e.printStackTrace() ;
			result.add(e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {System.err.println(es);
			}

		}
		return result;
}


public void setAll( Hashtable recordSet ) {
		/* This function also is called by the controller when apply is pressed
		recordSet is nothing but a hashtable containing all form values

		*/
		

		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;

		if(recordSet.containsKey("regimen_name")){
			regAdd.put("regimen_name",(String)recordSet.get("regimen_name"));
         
		}

if(recordSet.containsKey("regimen_code")){
			regAdd.put("regimen_code",(String)recordSet.get("regimen_code"));
         
		}


//System.err.println("set all..@342 BEAN...>"+recordSet);
this.recordSet = recordSet;
		}

 public HashMap insert() {

//		HashMap result=new HashMap();
		HashMap tabData=new HashMap();
		HashMap sqlMap=new HashMap();
		HashMap map=new HashMap();
//		String gender="";
//		String gender_val="";

		int totalRows;
		tabData.put("flag","test flag");
		tabData.put("result",new Boolean(true));
		tabData.put("message","message");
		//This creates three tab data lists for insert,update and delete and calls the specific functions
//System.err.println("regAdd....@.363.bean ....>"+regAdd);	
//System.err.println("regimen_code....@.364.bean ....>"+recordSet.get("regimen_code"));	
//		tabData.put("regimen_code",regAdd);
		tabData.put("regimen_code",recordSet.get("regimen_code"));
		tabData.put("AGEGROUP",recordSet.get("AGEGROUP"));
		tabData.put("infusion_line",recordSet.get("infusion_line"));
		tabData.put("Min_Age",recordSet.get("Min_Age1"));
		tabData.put("Max_Age",recordSet.get("Max_Age1"));
		tabData.put("Age_Unit",recordSet.get("age_unit_code1"));
//System.err.println("tab_data....@.349.bean ....>"+tabData);	

       //String gender			=(String)recordSet.get("gender_val1"); //Commented for common-icn-0048
	   //System.err.println("gender---------->"+gender);
		/*if(gender.equals("MALE"))
	    {
          gender_val="M";
		}else if(gender.equals("FEMALE")){
           gender_val="F";
		}else{
            gender_val="U";
		}*/
 		tabData.put("gender",recordSet.get("gender_val1"));
 		

		tabData.put( "PROPERTIES", getProperties() );

		//System.err.println("from tab data:"+tabData.get("PROPERTIES"));

		//get the totalrows and run a loop up to totalrows time and then sort the data
		totalRows=Integer.parseInt((String)recordSet.get("totalrows"));

		ArrayList CGCodearray=new ArrayList();
		ArrayList QtyUnitarray=new ArrayList();
		ArrayList Minarray=new ArrayList();
		ArrayList Maxarray=new ArrayList();
		ArrayList Stdarray=new ArrayList();
		ArrayList Ceilarray=new ArrayList();
		ArrayList UsgIndarray=new ArrayList();
        ArrayList Remrksarray=new ArrayList();
		ArrayList OrderingLimitarray=new ArrayList();
		String std;
//		temp,

		for (int i=1;i<=totalRows ;i++ )
		{
//			temp=(String)recordSet.get("FROMDB"+i);
			std=(String)recordSet.get("STD"+i);
			if  ( !(std.equals("")) )
			{

			CGCodearray.add((String)recordSet.get("GCODE"+i));		
			if ( ((String)recordSet.get("MIN"+i)).equals(""))
			{
					Minarray.add("0");
			}
			else
			{
					Minarray.add((String)recordSet.get("MIN"+i));
			}
			if ( ((String)recordSet.get("MAX"+i)).equals(""))
			{
					Maxarray.add("0");
			}
			else
			{
					Maxarray.add((String)recordSet.get("MAX"+i));
			}
			Stdarray.add((String)recordSet.get("STD"+i));
			QtyUnitarray.add((String)recordSet.get("QTYUNIT"+i));

			Ceilarray.add((String)recordSet.get("CEIL"+i));
			UsgIndarray.add((String)recordSet.get("Usage_Ind"+i));
			Remrksarray.add((String)recordSet.get("hidden_remarks"+i));
			OrderingLimitarray.add((String)recordSet.get("ordering_limit"+i));
			//System.err.println("OrderingLimitarray IN BEAN"+OrderingLimitarray);
			//System.err.println("usage array"+UsgIndarray);
			//System.err.println("remarks array"+Remrksarray);
			}
			//Ceilarray.add((String)recordSet.get("CEIL"+i));
			//UsgIndarray.add((String)recordSet.get("Usage_Ind"+i));
			//Remrksarray.add((String)recordSet.get("hidden_remarks"+i));
		 }

		tabData.put("CGCODEARRAY",CGCodearray);
		tabData.put("QTYUNITARRAY",QtyUnitarray);
		tabData.put("MAXARRAY",Maxarray);
		tabData.put("STDARRAY",Stdarray);
		tabData.put("MINARRAY",Minarray);
		tabData.put("CEILARRAY",Ceilarray);
		tabData.put("USGINDARRAY",UsgIndarray);
		tabData.put("REMARRAY",Remrksarray);
		tabData.put("ORDLIMITARRAY",OrderingLimitarray);
		tabData.put("LOGIN_BY_ID",login_by_id);
		tabData.put("LOGIN_AT_WS_NO",login_at_ws_no);
		tabData.put("LOGIN_FACILITY_ID",login_facility_id);

	try {
				
		  String SQL_PH_TPN_CONS_LIMIT_INSERT="INSERT INTO PH_TPN_CONSTITUENT_LIMIT ( AGE_GROUP_CODE, CONST_GENERIC_CODE, CONST_QTY_UNIT, CONST_MIN_VAL, CONST_MAX_VAL, CONST_STD_VAL, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,TPN_REGIMEN_CODE,CONST_CEIL_VAL,CONST_USAGE_IND,CONST_REMARKS,ORD_UNIT_IND)  VALUES (?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?) ";
          String SQL_PH_TPN_CONS_LIMIT_DELETE=" DELETE FROM PH_TPN_CONSTITUENT_LIMIT  WHERE AGE_GROUP_CODE=? AND TPN_REGIMEN_CODE=? ";

			sqlMap.put("SQLINSERT",SQL_PH_TPN_CONS_LIMIT_INSERT);
			sqlMap.put("SQLDELETE",SQL_PH_TPN_CONS_LIMIT_DELETE);
				
			//System.err.println("tabData-------------->"+tabData);
			//System.err.println("sqlMap-------------->"+sqlMap);
			
			//sqlMap.put("SQLINSERT", PhRepository.getPhKeyValue( "SQL_PH_TPN_CONS_LIMIT_INSERT" ) );
			//sqlMap.put("SQLDELETE", PhRepository.getPhKeyValue( "SQL_PH_TPN_CONS_LIMIT_DELETE" ) );

			
//			TPNConsLimitsHome home=null;
//			TPNConsLimitsRemote remote=null;
/*			InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue( "JNDI_PH_TPNCONSLIMITS" ) ) ;
			home  = (TPNConsLimitsHome) PortableRemoteObject.narrow( object, TPNConsLimitsHome.class ) ;
    		remote = home.create() ;
            map=localInsert (tabData,sqlMap );
			map=remote.insert(tabData,sqlMap);  */

   Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_TPNCONSLIMITS" ),TPNConsLimitsHome.class,getLocalEJB());

   Object busObj =(home.getClass().getMethod("create",null)).invoke(home,null);

   Object argArray[] =new Object[2];
		argArray[0]= tabData;
		argArray[1]=sqlMap;

   Class  paramArray[] = new Class[2];
		paramArray[0]= tabData.getClass();
		paramArray[1] = sqlMap.getClass();
	
	map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

//System.err.println("map at 598 ---- "+map);
					if( ((Boolean) map.get( "result")).booleanValue() )
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
					else
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
				 }
				 catch (Exception e)
				 {
				System.err.println(e.toString()); e.printStackTrace();
				 }

//System.err.println("map..@461 BEAN...>"+map);
				return map;

}

 public HashMap modify() {

		return new HashMap();


}
/*
private HashMap localInsert( HashMap tabData , HashMap sqlMap ) {
       

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "inside Insert" ) ;

		String debug="0";

		Connection connection					= null ;
		PreparedStatement pstmt_insert		= null ;
		PreparedStatement pstmt_delete		=null;


		ArrayList CGCodearray	=new ArrayList();
		ArrayList QtyUnitarray	=new ArrayList();
		ArrayList Minarray			=new ArrayList();
		ArrayList Maxarray	 		=new ArrayList();
		ArrayList Stdarray			=new ArrayList();


		String user="";
		String wsno="";
		String facility="";
		String agegroup=(String)tabData.get("AGEGROUP");

		//ResultSet resultSet = null ;
		int count				=0;
		

		CGCodearray	 	=(ArrayList)tabData.get("CGCODEARRAY");
		QtyUnitarray		=(ArrayList)tabData.get("QTYUNITARRAY");
		Minarray			=(ArrayList)tabData.get("MINARRAY");
		Maxarray			=(ArrayList)tabData.get("MAXARRAY");
		Stdarray			=(ArrayList)tabData.get("STDARRAY");
		user					=(String)tabData.get("LOGIN_BY_ID");
		facility				=(String)tabData.get("LOGIN_FACILITY_ID");
		wsno	 				=(String)tabData.get("LOGIN_AT_WS_NO");

		try {

			connection	= getConnection() ;
			pstmt_delete=connection.prepareStatement((String) sqlMap.get( "SQLDELETE"));
			pstmt_delete.setString(1,agegroup);
			count=pstmt_delete.executeUpdate();

				count=CGCodearray.size();

				if (count>0)
				{
				//insert operations have to be performed
					pstmt_insert=connection.prepareStatement((String) sqlMap.get( "SQLINSERT"));

					for (int i=0;i<count ;i++ )
					{
					pstmt_insert.setString(1,agegroup);
					pstmt_insert.setString(2,(String)CGCodearray.get(i));
					pstmt_insert.setString(3,(String)QtyUnitarray.get(i));
					pstmt_insert.setString(4,(String)Minarray.get(i));
					pstmt_insert.setString(5,(String)Maxarray.get(i));
					pstmt_insert.setString(6,(String)Stdarray.get(i));
					pstmt_insert.setString(7,user);
					pstmt_insert.setString(8,wsno);
					pstmt_insert.setString(9,facility);
					pstmt_insert.setString(10,user);
					pstmt_insert.setString(11,wsno);
					pstmt_insert.setString(12,facility);
					pstmt_insert.addBatch() ;
			 		 }
	  				debug+="5";
					int[] result1=pstmt_insert.executeBatch();
					for ( int k=0;k<result1.length ;k++ ){
						if(result1[k]<0  && result1[k] != -2 )
						{
								pstmt_insert.cancel();
								connection.rollback();
								map.put( "result", new Boolean( false) ) ;
								map.put( "msgid", "Exception Occured During Insert Process!!!") ;
								return map;
						}
					}

			}



			debug+="11";

			map.put( "result", new Boolean( true) ) ;
			map.put( "msgid", "RECORD_INSERTED") ;
			connection.commit();


		}//end of try

		catch( Exception e ) {
			map.put( "result", new Boolean( false ) ) ;
			map.put( "msgid", "Exception in EJB over here-Pushkala: " +e+debug) ;

				}
		finally {
			try {
				//closeResultSet( resultSet ) ;
				closeStatement( pstmt_insert ) ;
				closeStatement( pstmt_delete ) ;
				closeConnection( connection );
				//closeConnection( connection, (Properties)tabData.get( "properties" ) );
			}
			catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}

		return map ;

	}



	/* Function specific methods end */

	public int checkforvalid(String age_group_code) throws Exception
	{	
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;
		String gender			=	"";
		String age_unit			=	"";
		String min_age			=	"";
		String max_age			=	"";
		String gender1			=	"";
		String age_unit1		=	"";
		String min_age1			=	"";
		String max_age1			=	"";
//		String age_group_code1	=	"";
//		String infusion_line	=	"";
//		int count=0;
		int flag=0;

		

		try {
           	connection = getConnection() ;

             pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DOSG_LMT_SELECT6") );			
			pstmt.setString(1,age_group_code.trim());
			resultSet = pstmt.executeQuery() ;
			if ( resultSet.next() ){				
				gender1	    =	resultSet.getString("GENDER");
				 if(gender1==null)gender1="";
				age_unit1	=	resultSet.getString("AGE_UNIT");
				 if(age_unit1==null)age_unit1="";
				min_age1	=	resultSet.getString("MIN_AGE");
                 if(min_age1==null)min_age1="";
				max_age1	=	resultSet.getString("MAX_AGE");
				 if(max_age1==null)max_age1="";
				
			}
			    //System.err.println("gender1"+gender1);
				//System.err.println("age_unit1"+age_unit1);
				//System.err.println("min_age1"+min_age1);
				//System.err.println("max_age1"+max_age1);
			
           /* pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_CONS_LIMIT_SELECT4") );
			pstmt.setString(1,min_age1.trim());
			pstmt.setString(2,max_age1.trim());
			pstmt.setString(3,age_unit1.trim());
			pstmt.setString(4,gender1.trim());

			resultSet = pstmt.executeQuery() ;
			if(resultSet.next())
			{
             count	    =	resultSet.getInt("COUNT1");
			}*/

            // if(count>0)
			//{          	

			if(resultSet!=null)		closeResultSet(resultSet);
			if(pstmt!=null)			closeStatement(pstmt);

			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_CONS_LIMIT_SELECT3") );	
			
			resultSet = pstmt.executeQuery() ;
			while ( resultSet.next() ){
                gender="";
				age_unit="";
				min_age="";
				max_age="";
				
				gender	    =	resultSet.getString("GENDER");
				 if(gender==null)gender="";
				age_unit	=	resultSet.getString("AGE_UNIT");
				 if(age_unit==null)age_unit="";
				min_age	    =	resultSet.getString("MIN_AGE");
				 if(min_age==null)min_age="";
				max_age	    =	resultSet.getString("MAX_AGE");
				 if(max_age==null)max_age="";
				//max_age	    =	resultSet.getString("INFUSION_LINE");
				// if(infusion_line==null)infusion_line="";
				 //INFUSION_LINE
				//System.err.println("gender"+gender);
				//System.err.println("age_unit"+age_unit);
				//System.err.println("min_age"+min_age);
				//System.err.println("max_age"+max_age);


				if(gender.equals(gender1) && age_unit.equals(age_unit1)&&( (Integer.parseInt(min_age)>=Integer.parseInt(min_age1)&& Integer.parseInt(min_age)<=Integer.parseInt(max_age1))||Integer.parseInt(min_age)<= Integer.parseInt(min_age1)&& Integer.parseInt(min_age)<=Integer.parseInt(max_age1) ))
			    {
				//System.err.println("gender==e=="+gender);
				//System.err.println("age_unit==e=="+age_unit);
				//System.err.println("min_age==e=="+min_age);
				//System.err.println("max_age==e=="+max_age);
				//System.err.println("gender1==e=="+gender1);
				///System.err.println("age_unit1==e=="+age_unit1);
				//System.err.println("min_age1==e=="+min_age1);
				//System.err.println("max_age1==e=="+max_age1);



				flag=1;
				break;
			    }			
			}
		//}else
		//{
		//	flag=0;
           
		//}
           if(flag==1)
		   {	
				if(resultSet!=null)		closeResultSet(resultSet);
				if(pstmt!=null)			closeStatement(pstmt);

				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_CONS_LIMIT_SELECT4") );
				pstmt.setString(1,min_age1.trim());
				pstmt.setString(2,max_age1.trim());
				pstmt.setString(3,age_unit1.trim());
				pstmt.setString(4,gender1.trim());
				resultSet = pstmt.executeQuery() ;
				if(resultSet.next())
				{
//				 age_group_code1	    =	resultSet.getString("AGE_GROUP_CODE");
				 flag=2;
				}

		  }

		}
		catch ( Exception e ){
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){System.err.println(es);
			}
		}

		return flag;
	}

}
