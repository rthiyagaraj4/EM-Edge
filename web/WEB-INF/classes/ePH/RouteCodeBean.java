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
import javax.naming.*;*/
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;
//saved on 27/10/2005
public class RouteCodeBean extends PhAdapter implements Serializable {

    protected String route_code="";
    protected String route_desc="";
	protected String route_local="";
	protected String route_color="";  //Added for RUT-CRF-0034 ICN 29927
    protected String eff_status="";
	protected String extRouteCode="";
    protected Hashtable hashMultiple ;

    public RouteCodeBean() {
        try {
            doCommon();
        }
        catch(Exception e) 
		{
			System.out.println("Exception in constructor"+e.toString());
		}
    }


   /* Over-ridden Adapter methods start here */

    public void clear() {
        super.clear() ;
    }

    private void doCommon() throws Exception {
    }
    /* Over-ridden Adapter methods end here */

    /* Set Methods Start */
/****************************************************************/
    public void setRoute_Code( String route_code ) 
	{
        this.route_code = route_code  ;
    }
	public void setRoute_Color( String route_color )   //Method Added for RUT-CRF-0034 ICN 29927
	{
		// added by marwan EDGE WORK -- saving the color without # or spaces
        this.route_color = route_color.replaceAll("[#\\s]", "");
    }
    public void setRoute_Desc( String route_desc )  {
        this.route_desc = route_desc  ;
    }

    public void setRoute_Local( String route_local )  {
        this.route_local = route_local  ;
    }

	 public void setExternalRoute( String ext_route)  {
        this.extRouteCode = ext_route  ;
    }

    public void setEffStatus( String eff_status ){
        if(eff_status.equals("") || eff_status==null )
            this.eff_status = "D" ;
        else
            this.eff_status = eff_status ;
    }
    /* Get Methods Start */
/******************************************************************/

    public String getRoute_Code() {
        return this.route_code  ;
    }
    public String getRoute_Desc() {
        return this.route_desc  ;
    }

	public String getRoute_Local()
	{
	    return this.route_local  ;
	}
    public String getEffStatus (){
        return this.eff_status ;
    }
	public String getExternalRoute (){
       return  this.extRouteCode;
    }
	public String getRoute_color()  //Method Added for RUT-CRF-0034 ICN 29927
	{
	    return this.route_color  ;
	}
/********************************    setAll()    **************************************/
 public void setAll( Hashtable recordSetMultiple ) {
        hashMultiple = recordSetMultiple ;
        this.mode =(String)recordSetMultiple.get("mode");
 }

/**********************************  insert()  ****************************************/

public HashMap insert()
{

    ArrayList insertData = new ArrayList() ;
    ArrayList whereData = new ArrayList() ;

    for(int i=0; i<10;i++)
    {
        String routeCode = "route_code"  + i ;
        String routeDesc = "route_desc"  + i ;
		//String routeLocal = "route_local" + i ;

        ArrayList insertRow = new ArrayList() ;
        ArrayList whereRow = new ArrayList() ;

        if(!(  (((String)hashMultiple.get(routeCode))).trim().equals("") 
			|| (((String)hashMultiple.get(routeDesc))).trim().equals("")
		  )){

            /***** 5 values per row from the AddModify form  */

            insertRow.add( (String)hashMultiple.get(  ("route_code" + i)    )  ) ;
            insertRow.add( (String)hashMultiple.get(  ("route_desc" + i)    ) ) ;
            insertRow.add( (String)hashMultiple.get(  ("ext_route_code" + i)) ) ;
            insertRow.add( (String)hashMultiple.get(  ("ext_route_desc" + i)) ) ;

			if( ((String)hashMultiple.get(("eff_status" + i))) == null || ((String)hashMultiple.get(("eff_status" + i))).equals("") )
                insertRow.add(  "D"  ) ;
            else
                insertRow.add( (String)hashMultiple.get(  ("eff_status" + i)) ) ;

            insertRow.add( (String)hashMultiple.get(  ("route_color" + i)    ) ) ;  //Code Added For  //Added for RUT-CRF-0034 ICN 29927

 //           if( ((String)hashMultiple.get(("eff_status" + i))).equals("") )
  //             insertRow.add(  "D"  ) ;
   //         else
     //           insertRow.add( (String)hashMultiple.get(  ("eff_status" + i)        ) ) ;

            insertRow.add( login_by_id ) ;
            insertRow.add( login_at_ws_no ) ;
            insertRow.add( login_facility_id ) ;

            insertRow.add( login_by_id ) ;
            insertRow.add( login_at_ws_no ) ;
            insertRow.add( login_facility_id ) ;
			insertRow.add((String)hashMultiple.get(("route_local" + i))) ;
	
            whereRow.add( (String)hashMultiple.get(  ("route_code" + i) )  ) ;

            /* note:-
            The insertData and whereData should be arraylist of arraylist
            in case of insertMultiple() of SingleTableHandler
            */
            insertData.add( insertRow ) ;
            whereData.add( whereRow ) ;
        }
        }//for

        HashMap tabData = new HashMap() ;
        tabData.put( "properties", getProperties() );
        tabData.put( "InsertData",insertData);
        tabData.put( "WhereData",whereData);


        HashMap sqlMap = new HashMap() ;
        try{
            sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue( "SQL_PH_ROUTE_SELECT3" ) );
            sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue( "SQL_PH_ROUTE_INSERT") );
        }catch(Exception e){
            e.printStackTrace();
        }
return CallSingleTableHandler( tabData,sqlMap );
}
/**********************************************************************************/
public HashMap modify()
{
        ArrayList insertRow = new ArrayList() ;

            insertRow.add( (String)hashMultiple.get(  "route_desc"  ) ) ;
			//if( ((String)hashMultiple.get(("eff_status"))).equals("") )
            //    insertRow.add(  "D"  ) ;
//			if( ((String)hashMultiple.get(("eff_status" + i))) == null || ((String)hashMultiple.get(("eff_status" + i))).equals("") )
//			   insertRow.add(  "D"  ) ;
  //          else
	//			insertRow.add( (String)hashMultiple.get( ("eff_status" )) ) ;


			
			if( ((String)hashMultiple.get("eff_status")) == null || 		((String)hashMultiple.get("eff_status")).equals("") )
				   insertRow.add(  "D"  ) ;
            else
				insertRow.add( (String)hashMultiple.get( ("eff_status" )) ) ;
		    
			insertRow.add( (String)hashMultiple.get(  "ext_route_code"  ) ) ;
		    insertRow.add( (String)hashMultiple.get(  "ext_route_desc"  ) ) ;
            insertRow.add( (String)hashMultiple.get(  "route_color"  ) ) ; //Added for RUT-CRF-0034 ICN 29927
            insertRow.add( login_by_id ) ;
            insertRow.add( login_at_ws_no ) ;
            insertRow.add( login_facility_id ) ;
            insertRow.add( (String)hashMultiple.get(  "route_local"  ) ) ;
            insertRow.add( route_code  ) ;

            HashMap tabData = new HashMap() ;
            tabData.put( "properties", getProperties() );
            tabData.put( "ModifyData",insertRow);

            HashMap sqlMap = new HashMap() ;

       try
	   {
            sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue( "SQL_PH_ROUTE_UPDATE" ) );
        }catch(Exception e){
            e.printStackTrace();
        }


return CallSingleTableHandler(tabData,sqlMap );
}


/********************************************************************************/

/********************************************************************************/
    public void loadData() throws Exception {
        String []stParameters   =   {getRoute_Code(), getLanguageId()};
        HashMap hmRecord        =   null;
     hmRecord    =   fetchRecord(PhRepository.getPhKeyValue( "SQL_PH_ROUTE_SELECT2" ), stParameters);

           setRoute_Desc( (String)hmRecord.get  ("ROUTE_DESC")  ) ;
		setRoute_Local( (String)hmRecord.get  ("ROUTE_DESC_LOCAL_LANG")  ) ;
           setEffStatus( (String)hmRecord.get  ("EFF_STATUS")  ) ;
           setExternalRoute( (String)hmRecord.get  ("EXT_ROUTE_CODE")  ) ;
		  setRoute_Color( (String)hmRecord.get  ("ROUTE_COLOR")  ) ;  //Added for RUT-CRF-0034 ICN 29927
 }
/******************************************************************************/
/*
public HashMap fetchRecord(String sql, String[] stParameters) throws Exception {
        HashMap hmRecord                    =   new HashMap();
        Connection connection               = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet                 = null;
        ResultSetMetaData resultSetMetaData = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);

            if (stParameters!=null)
                for (int index=0; index<stParameters.length ;index++ )
                    preparedStatement.setString( index+1, stParameters[index]);

            resultSet = preparedStatement.executeQuery();
            resultSetMetaData   =   resultSet.getMetaData();

            resultSet.next();
            for (int i=1; i<=resultSetMetaData.getColumnCount(); i++ )
               hmRecord.put(resultSetMetaData.getColumnName(i),resultSet.getString(resultSetMetaData.getColumnName(i)));

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
}*/
/*********************************************************************************/
public HashMap fetchRecord(String sql, String[] stParameters) throws Exception {
        HashMap hmRecord                    =   new HashMap();
        Connection connection               = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet                 = null;
        ResultSetMetaData resultSetMetaData = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);

            if (stParameters!=null)
                for (int index=0; index<stParameters.length ;index++ )
                    preparedStatement.setString( index+1, stParameters[index]);

            resultSet = preparedStatement.executeQuery();
            resultSetMetaData   =   resultSet.getMetaData();

            while(resultSet.next()){
            for (int i=1; i<=resultSetMetaData.getColumnCount(); i++ )
                hmRecord.put(resultSetMetaData.getColumnName(i),resultSet.getString(resultSetMetaData.getColumnName(i)));
				
			}

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

/********************/



private  HashMap CallSingleTableHandler(HashMap tabData , HashMap sqlMap )
 {
    HashMap map = new HashMap() ;
    map.put( "result", new Boolean( false ) ) ;

/*  SingleTableHandlerHome home = null;
    SingleTableHandlerRemote remote = null;*/
    try {
/*      InitialContext context = new InitialContext() ;
        Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;
        home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
        remote = home.create() ;

        if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ))  ){
            map = remote.singleBatchHandler( tabData, sqlMap ) ;
        }else if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ){
            map = remote.modify( tabData, sqlMap ) ;
        }else if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_DELETE" )) ){
             map = remote.delete( tabData, sqlMap ) ;
        }*/

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
		
		}
		else if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) )
		{
		map=(java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
		}
		else if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_DELETE" )) )
		{
		map=(java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
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
/*        finally {
                try {
                    if( remote != null )
                        remote.remove() ;
                    } catch( Exception ee ) {
                        System.err.println( ee.getMessage() ) ;
                            map.put( "message", ee.getMessage() ) ;
                    }
                }*/
return map;
}
}
