/*
--------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------------------------
03/08/2017	IN062992		Dinesh T	7/8/2017		Ramesh G			ML-MMOH-CRF-0345.1
--------------------------------------------------------------------------------------------------------------------------------
*/

package eOR;

import javax.servlet.* ;
import javax.servlet.http.*;
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

public class FrequencyScopeBean	 extends eOR.Common.OrAdapter implements Serializable {

String traceVal = "";
//	Connection connection			=null;
//	ResultSet resultSet	  			= null;
//java.sql.PreparedStatement pstmt	= null;


//  declaration of all properties of class

	protected String order_category_id 	= "" ;
	protected String freq_code						= "" ;
	protected String freq_desc						= "" ;
	protected String freq_scope					= "N" ;
	protected Hashtable hashMultiple			=null;
	protected int ordCatSize			=0;


// setter method for all properties
//return type@ void    parameter @ type of properties


	public void setOrderCategory(String OrderCategory_id){
		order_category_id = OrderCategory_id ;
	}

	public void setFreqCode(String freq_code){
		this.freq_code = freq_code;
	}
	public void setFreqDesc(String freq_desc){
		this.freq_desc = freq_desc;
	}

    public void  setFreqScope(String  freq_scope) {
		  if(freq_scope.trim().equals("") ){
			  this.freq_scope= "N";
		  }else{
			  this.freq_scope=  "Y";
		  }
	}


// getter method for all properties of class
// return type@ type of properties   parameter@ void or nothing

	public String getOrderCategory(){
		return order_category_id;
	}
	public String getFreqCode(){
		return freq_code;
	}
	public String getFreqDesc(){
		return freq_desc;
	}

	public String getFreqScope(){
		return freq_scope;
	}




/**
	This will populate all the frequency with scope of each category
	@return		:	ArrayList     parameter - string type
*/
/*
public  ArrayList getFrequency()throws Exception{
	ArrayList   frequency = new ArrayList() ;
	Connection connection	=null;
	ResultSet resultSet	  	= null;
	PreparedStatement pstmt		= null;
	try {
		connection= getConnection() ;

		pstmt	= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_FREQUENCY"));
		resultSet		= pstmt.executeQuery();

			String[] record=null;
		while ( resultSet != null && resultSet.next() ) {
			record = new String[2];
			record[0]=resultSet.getString( "FREQ_CODE" ) ;
			record[1] = resultSet.getString( "FREQ_DESC" )  ;

			frequency.add(record) ;
		}
	} catch ( Exception e )	{
		System.err.println( "Error loading values from database" ) ;
		e.printStackTrace() ;
		throw e ;
	} finally {
		closeResultSet(resultSet);
		closeStatement(pstmt);
		closeConnection(connection) ;
	}

	return frequency ;

}*/ //end of getTickSheetSectionTickSheet method



// getting the order category from the database to fill order category combo at the loading time
// return type @arraylist    parameter - none


public ArrayList  getOrderCategoryList(String freqCode) throws Exception {
		ArrayList OrderCat = new ArrayList() ;
		Connection connection=null;
		ResultSet resultSet=null;
		PreparedStatement	pstmt = null;

		try {
			connection=	getConnection() ;
			pstmt=connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_FREQUENCY_SCOPE")) ;
			pstmt.setString(1,freqCode);
			pstmt.setString(2,freqCode);

			if(!(pstmt==null)){
				resultSet = pstmt.executeQuery() ;
			}
			String[] record=null;
			while ( resultSet != null && resultSet.next() ) {
				record = new String[3];
				record[0] = resultSet.getString( "ORDER_CATEGORY" )  ;
				record[1] = resultSet.getString( "SHORT_DESC" )  ;
				record[2] = resultSet.getString( "FREQ_SCOPE_YN" )  ;
				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			ordCatSize=OrderCat.size();
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}

		return OrderCat;
}// end of  getTickSheetSectionOrderCategory () method


   public  int getTotalOrdCat(){
   return 				 ordCatSize;

   }
// setall method get called from controller jsp

 public void setAll( Hashtable recordSetMultiple ) {
		setMode((String)recordSetMultiple.get("mode"));
		hashMultiple = recordSetMultiple ;
		//System.out.println("###in frequency scope bean,set all(),hashMultiple="+hashMultiple);
		//System.out.println("###in frequency scope bean,set all(),mode="+(String)recordSetMultiple.get("mode"));
		//System.out.println("###in frequency scope bean,set all(),ordCatSize="+ordCatSize);

}

// insert method start here putting all sql in sql map that used to check duplicate and insert operation,also put all the data in hash map that used to check duplicate and inert operation

public HashMap insert(){
			HashMap tabDataParam =  new HashMap() ;


		tabDataParam.put( "result", new Boolean( false ) ) ;
		tabDataParam.put( "flag", "true") ;

		HashMap sqlMapIn = new HashMap();

		try{
			sqlMapIn.put("InsertSQL",OrRepository.getOrKeyValue("SQL_OR_FREQUENCY_INSERT"));
			  sqlMapIn.put("SelectSQL",null);	/*sqlMapIn.put("SelectSQL",OrRepository.getOrKeyValue("SQL_OR_FREQUENCY_DUP_CHECK"));*/
		}catch(Exception e){e.printStackTrace();}

		ArrayList whereData=new ArrayList();
		ArrayList recordStore = new ArrayList() ;

		String scope="";
		String ID = "" ;
		ArrayList tabData = null;
		ArrayList tabData1 = null;


			for(int i=0 ; i < ordCatSize ; i++){
				scope="";
				ID = "ordercategory"  + i ;
				tabData = new ArrayList() ;
				tabData1 = new ArrayList() ;

				if(!(((String)hashMultiple.get(ID)).equals("")||(String)hashMultiple.get(ID)==null)){

					tabData.add(((String)hashMultiple.get("frequency")).trim());
					tabData1.add(((String)hashMultiple.get("frequency")).trim());
					tabData.add( ((String)hashMultiple.get(ID)).trim()) ;

					if(!(((String)hashMultiple.get("scope"+i)).equals("")||(String)hashMultiple.get("scope"+i)==null))
										scope="Y";
					else				scope="N";
					tabData.add((String)scope) ;


					tabData.add(((String)login_by_id).trim()) ;
																		//		tabData.add(added_date.trim()) ;
					tabData.add(((String)login_facility_id).trim()) ;
					tabData.add(((String)login_at_ws_no).trim()) ;
					tabData.add(((String)login_by_id).trim()) ;
																		//	tabData.add(modified_date.trim()) ;
					tabData.add((String)login_at_ws_no.trim()) ;
					tabData.add((String)login_facility_id.trim()) ;
					//insert into or_frequency_scope (freq_code,order_category,freq_scope_yn,added_by_id,added_facility_id,added_at_ws_no,modified_id,modified_ws_no,modify_facility_id,added_date,modified_date) values (?,?,?,?,?,?,?,?,?,Sysdate,Sysdate)";
					recordStore.add(tabData);
					whereData.add(tabData1);
					//traceVal.append("putting the record store" + recordStore.size()+"wheredata:"+whereData.size());
				 }
			}

 			tabDataParam.put( "InsertData", recordStore);
//			tabDataParam.put("WhereData",whereData);
			tabDataParam.put("WhereData",null);
			tabDataParam.put( "properties", getProperties() );
		return  getResult(tabDataParam,sqlMapIn) ;

}// end of insert method



public void clear() {
		super.clear();
		 order_category_id 		= "" ;
		 freq_code				= "" ;
		 freq_desc				= "" ;
		 freq_scope			= "N" ;
		 hashMultiple			=null;
}

// method to get the combo string that passed query criteria method to get order category from data base at the loading time


public String getComboString(){
Connection 	connection  = null;
PreparedStatement pstmt		= null;
ResultSet rs	= null;
	try {
		connection  = getConnection();

		pstmt			= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST"));
		pstmt.setString(1,language_id);
		rs				= pstmt.executeQuery();
	    StringBuffer sb			    = new StringBuffer();
		String  codeCol			    = "";
		String  codeDesc			="";

		while (rs.next()){
				codeCol			    = ChkDef.defaultString(rs.getString(1));
				codeDesc			= ChkDef.defaultString(rs.getString(2));
			    sb.append(codeDesc + "," + codeCol + ",");
		}

		 String str =   sb.toString() ;
		 sb.setLength(0);
		 return str.substring(0, str.length()-1);
	}catch(Exception e){
		System.err.println(e.getMessage());
		return null;
	}finally{
		try{
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(connection);
		 }catch(Exception e){e.printStackTrace();}
	}
}
// start of modify method putting all the in hash map and call get result method
// start of check freq code function
public boolean dupliFreqCodeYn(String freqcode)
{
Connection 	connection  = null;
PreparedStatement pstmt		= null;
ResultSet rs	= null;
		try {
			connection  = getConnection();

			String sql=OrRepository.getOrKeyValue("SQL_OR_FREQUENCY_DUP_CHECK");
			pstmt	= connection.prepareStatement(sql);
			pstmt.setString(1,freqcode);
			rs		= pstmt.executeQuery();
			rs.next();

		int total=rs.getInt("total");

		if(total!=0)
				return true;
		else
			return   false;



	}catch(Exception e){
		System.err.println(e.getMessage());
		return false;
	}finally{
		try{
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(connection);
		 }catch(Exception e){e.printStackTrace();}
	}
}


// checkfreqcode function end here
public HashMap modify() {
//	String traceVal = "";
	HashMap map  = new HashMap() ;
	//SingleTableHandlerHome home = null;
	//SingleTableHandlerRemote remote = null;
    map.put( "result", new Boolean( false ) ) ;
    map.put( "flag", "true" ) ;

	try
	{
		HashMap tabData = new HashMap();
		StringBuffer tmpBuff	= new StringBuffer();
		ArrayList delData = new ArrayList() ;
		HashMap sqlMap = new HashMap();
		delData.add(( (String)hashMultiple.get("frequency")).trim() ) ;
		sqlMap.put("DeleteSQL",OrRepository.getOrKeyValue("SQL_OR_FREQUENCY_SCOPE_DELETE"));
		tabData.put("properties",getProperties());
		tabData.put("DeleteData",delData);
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"), SingleTableHandlerHome.class, getLocalEJB());
    	Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[]	= new Object[2];
			argArray[0]		= tabData;
			argArray[1]		= sqlMap;
 		Class [] paramArray = new Class[2];
 		 	paramArray[0]	= tabData.getClass();
			paramArray[1]	= sqlMap.getClass();
		map = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				
				argArray	= null;
				paramArray	= null;

		//String message = (String)map.get("msgid");
		boolean result = ((Boolean) map.get("result")).booleanValue() ;
		//System.out.println("###in modify() before inserting records,result="+result);
        if( result ) 
		{
			map.put( "result", new Boolean( true ) ) ;
			//map.put( "message", (String) map.get("msgid") ) ;
			map.put( "message", getMessage(getLanguageId(), (String) map.get( "msgid" ), "SM")) ;
			map.put("traceVal", (String)tmpBuff.toString());
		}
	//System.out.println("###in modify() before inserting records,,map="+map);
	//	return map;

	}catch(Exception e)
	{
		map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		return map ;
	}
	setMode("1");
	HashMap tabDataParam =  new HashMap() ;


	tabDataParam.put( "result", new Boolean( false ) ) ;
	tabDataParam.put( "flag", "true") ;

	HashMap sqlMapIn = new HashMap();

	try{
		sqlMapIn.put("InsertSQL",OrRepository.getOrKeyValue("SQL_OR_FREQUENCY_INSERT"));
		  sqlMapIn.put("SelectSQL",null);	
	}catch(Exception e){e.printStackTrace();}

	ArrayList whereData=new ArrayList();
	ArrayList recordStore = new ArrayList() ;
	String scope="";
	String ID = "" ;
	ArrayList tabData = null;
	ArrayList tabData1 = null;

	//System.out.println("###in frequency scope bean,modify(),ordCatSize="+ordCatSize);
	for(int i=0 ; i < ordCatSize ; i++){
		scope="";
		ID = "ordercategory"  + i ;
		tabData = new ArrayList() ;
		tabData1 = new ArrayList() ;
		if(!(((String)hashMultiple.get(ID)).equals("")||(String)hashMultiple.get(ID)==null)){
			tabData.add(((String)hashMultiple.get("frequency")).trim());
			tabData1.add(((String)hashMultiple.get("frequency")).trim());
			tabData.add( ((String)hashMultiple.get(ID)).trim()) ;
			if(!(((String)hashMultiple.get("scope"+i)).equals("")||(String)hashMultiple.get("scope"+i)==null))
										scope="Y";
					else				scope="N";
			tabData.add((String)scope) ;


			tabData.add(((String)login_by_id).trim()) ;
															//		tabData.add(added_date.trim()) ;
			tabData.add(((String)login_facility_id).trim()) ;
			tabData.add(((String)login_at_ws_no).trim()) ;
			tabData.add(((String)login_by_id).trim()) ;
															//	tabData.add(modified_date.trim()) ;
			tabData.add((String)login_at_ws_no.trim()) ;
			tabData.add((String)login_facility_id.trim()) ;
			//insert into or_frequency_scope (freq_code,order_category,freq_scope_yn,added_by_id,added_facility_id,added_at_ws_no,modified_id,modified_ws_no,modify_facility_id,added_date,modified_date) values (?,?,?,?,?,?,?,?,?,Sysdate,Sysdate)";
			recordStore.add(tabData);
			whereData.add(tabData1);
			//traceVal.append("putting the record store" + recordStore.size()+"wheredata:"+whereData.size());
		 }
	}

		tabDataParam.put( "InsertData", recordStore);
//		tabDataParam.put("WhereData",whereData);
		tabDataParam.put("WhereData",null);
		tabDataParam.put( "properties", getProperties() );
		return  getResult(tabDataParam,sqlMapIn) ;

/*




	System.out.println("###in frequency scope bean, modify()");

		HashMap dataMap = new HashMap() ;
		//HashMap whereData = new HashMap() ;
		ArrayList tabdataK = new ArrayList() ;

		traceVal +=" mehtod modify get called  ";
		String scope;

		ArrayList tabdata =null;
System.out.println("###ordCatSize="+ordCatSize);
		for(int i=0;i<ordCatSize;i++){
			tabdata  = new ArrayList() ;

			if(!(((String)hashMultiple.get("ordercategory"+i)).equals("")||(String)hashMultiple.get("ordercategory"+i)==null)){
				if(!(((String)hashMultiple.get("scope"+i)).equals("")||(String)hashMultiple.get("scope"+i)==null))
						scope="Y";
				else
			           scope="N";

				tabdata.add((String)scope ) ;
				tabdata.add( ((String)hashMultiple.get("frequency")).trim() ) ;
				tabdata.add(((String)hashMultiple.get("ordercategory"+i)).trim() ) ;
				tabdataK.add((ArrayList)tabdata);
			}
		}

		HashMap sqlMapUp = new HashMap() ;

		try{
				sqlMapUp.put( "ModifySQL",OrRepository.getOrKeyValue("SQL_OR_FREQUENCY_SCOPE_MODIFY"));

				traceVal +=OrRepository.getOrKeyValue("SQL_OR_FREQUENCY_SCOPE_MODIFY");
			}catch(Exception e){e.printStackTrace();}


				dataMap.put("properties", getProperties() );
				dataMap.put("ModifyData",tabdataK);
					traceVal +=dataMap.toString();
				return getResult(dataMap,sqlMapUp);

	*/ 
	}// end of modify method

public String getNature(String freq_code){
Connection 	connection = null ;
PreparedStatement pstmt		= null;
ResultSet rs	= null;
String   nature ="";
try{
		connection								= getConnection();

		pstmt									= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_FREQUENCY_NATURE"));
		pstmt.setString(1,freq_code.trim())	;

		rs					= pstmt.executeQuery();

		while (rs.next()){
			nature = rs.getString("freq_nature");
		}


		return 	  nature ;

}catch(Exception e){
		System.err.println(e.getMessage());
		return null;
	}finally{
		try{
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(connection);
		 }catch(Exception e){e.printStackTrace();}
	}

}


// get result method -> using single table handler class to talk to the server for dml operation
private  HashMap getResult(HashMap tabData , HashMap sqlMap1 ){


		HashMap map  = new HashMap() ;
		StringBuffer tmpBuff	= new StringBuffer();
		//SingleTableHandlerHome home = null;
		//SingleTableHandlerRemote remote = null;
	//traceVal +=":: in get result  method and value of mode ::"+mode;
	traceVal =traceVal+":: in get result  method and value of mode ::"+mode;
//        map.put( "result", new Boolean( false ) ) ;
//        map.put( "flag", "true" ) ;

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
				argArray[1]		= sqlMap1;
 				Class [] paramArray = new Class[2];
 		 		paramArray[0]	= tabData.getClass();
				paramArray[1]	= sqlMap1.getClass();

			if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))
			{
					//map = remote.singleBatchHandler(tabData,sqlMap1);
					map = (java.util.HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);		

			}
			else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
				//traceVal +=(String)sqlMap1.get("ModifySQL");
					//map=remote.singleBatchHandler(tabData,sqlMap1);
					map = (java.util.HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);		
					//traceVal+=":: in get result modify :: ";
					//traceVal+="result of singletab : "+map.toString();
					traceVal =traceVal+":: in get result modify :: ";
					traceVal =traceVal+"result of singletab : "+map.toString();

			}
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				
			argArray	= null;
			paramArray	= null;
			if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					
				map.put( "message", getMessage(language_id, (String) map.get( "msgid" ), "SM")) ;
			}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
					
					if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
				{
						
						map.put( "message", getMessage(language_id, (String) map.get( "msgid" ), "Common")) ;
				}
				    else
				{
						
						map.put( "message", getMessage(getLanguageId(), (String) map.get( "msgid" ), "SM")) ;
				}
			}
			map.put("traceVal", (String)tmpBuff.toString());
			tmpBuff.setLength(0);


			/*if( ((Boolean) map.get( "result" )).booleanValue() )
				map.put( "message", getMessage((String) map.get( "msgid" )) ) ;

			else{
				if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
					map.put( "message", getMessage((String) map.get( "msgid" )) ) ;
				else
					map.put( "message", (map.get("msgid"))) ;
			}*/
			

			//String message = (String)map.get("msgid");

			//map.put("message",message);
			//traceVal += "rmessage after coming out cform single tab: "+message;
			

			return map;


 }catch(Exception e){
		System.err.println( "Error Calling EJB in get result:" + e ) ;
//		traceVal=traceVal+"inside exception block";
		traceVal=traceVal+" exception cause"+e.getMessage();
		map.put("traceVal",traceVal);
		e.printStackTrace() ;
		return map;
  }finally{
		//		traceVal=traceVal+check;
				map.put("traceVal",traceVal);

		  }
	  }

/*********************************************************************/
/*public String getFreqValues(String str){
	Statement stmt = null ;
	ResultSet rs = null;
	String returnStr = "";
try{

			connection  = getConnection();
			String SCHEDULE_FREQUENCY_FREQLEGEND ="SELECT  freq_code, freq_desc, repeat_value, interval_durn_type, repeat_value || ' '|| 'Repeats Per ' || b.Durn_desc || ' ' ||b.for_text || ' Every  ' || Interval_value || ' ' || c.durn_Desc  Frequency_Legend, START_TIME_ROUND, START_TIME_ASSIGN FROM   am_frequency a,  or_duration_type b, or_duration_type c WHERE  interval_durn_type IN ('H','D','W','M') AND  Scheduled_yn ='Y' AND  eff_status ='E' AND a.repeat_durn_type =b.durn_type AND a.interval_durn_type = c.durn_type and  freq_code = ?";
			pstmt	= connection.prepareStatement(SCHEDULE_FREQUENCY_FREQLEGEND);
			pstmt.setString(1,str.trim());
			rs		= pstmt.executeQuery();

			if(rs.next()){
			returnStr = checkForNull(rs.getString("Frequency_Legend"));
			}

			return returnStr;

}catch(Exception e){
		System.out.println(e.getMessage());
//		tempChk +="e=" +e.getMessage();
		return null;
}finally{

		try
		 {
			closeConnection(connection);
		 }catch(Exception e){}
  }

} */

	//IN062992, starts
	public String getFrequencyNature(String freqCode)
	{
		Connection connection = null;
		PreparedStatement pstmt = null ;
		ResultSet rs = null;
		String returnStr = "";
		
		try
		{
			connection  = getConnection();
			String SCHEDULE_FREQUENCY_FREQLEGEND ="SELECT  FREQ_NATURE FREQUENCY_NATURE FROM AM_FREQUENCY WHERE FREQ_CODE = ?";
			pstmt	= connection.prepareStatement(SCHEDULE_FREQUENCY_FREQLEGEND);
			pstmt.setString(1,freqCode.trim());
			rs		= pstmt.executeQuery();

			if(rs.next())
			{
				returnStr = checkForNull(rs.getString("FREQUENCY_NATURE"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
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

		return returnStr;
	}
	//IN062992, ends
}// end of the bean class FrequencyScopeBean
