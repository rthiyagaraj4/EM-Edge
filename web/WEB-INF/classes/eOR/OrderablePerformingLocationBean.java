/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import eOR.Common.* ;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;
import javax.servlet.* ;
import eCommon.Common.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;

import eOR.OROrderablePeformLocn.*;

//import eOR.Common.*;

/** Fuction OrderablePerformingLocationBean
 * @author sivakumar
 */
public class OrderablePerformingLocationBean extends OrAdapter implements Serializable {
    public String test() {
        return "Ask";
    }
    /** Instance variables */
    /** Location Type */
    protected String location_type;
    /** Location Code */
    protected String location_code;
    /** Order Type */
    protected String order_type;
    /** Instance of MultiRecordBean1 */
    //public MultiRecordBean1 recStoreHandler;
    public eOR.Common.MultiRecordBean1 recStoreHandler;
    //public PerformingLocation test;
    /** Detail Page Mode */
    protected String detailPageMode;
    /** Action */
    protected String action;
    /** OrderCatalogIndex */
    protected String OrderCatalogIndex;
    /** tempChk */
    public  String tempChk	="";
    /** tempHash*/
    public String deleteall = "0";

    /** Creates new Instance of OrderablePerformingLocationBean */
    public OrderablePerformingLocationBean() {
       // clear();
        //recStoreHandler = new MultiRecordBean1();
        recStoreHandler = new eOR.Common.MultiRecordBean1();
        //test = new PerformingLocation();
    }
    /** Method for insert operations
     *@return HashMap results of insert operations
     */
    public HashMap insert() {
    	//System.out.println("####ASK in insert()");
        HashMap map = new HashMap();
        HashMap sqlMap = new HashMap();
        HashMap recordStoreParam = new HashMap();
        map.put("result",new Boolean(true));
        try {
            //To be changed Accordingly
            sqlMap.put("SQL_OR_ORDERABLES_BY_PERFORM_LOCN_DEFAULT_YN_CHECK",OrRepository.getOrKeyValue("SQL_OR_ORDERABLES_BY_PERFORM_LOCN_DEFAULT_YN_CHECK"));
            sqlMap.put("SQL_OR_ORDERABLES_BY_PERFORM_LOCN_INSERT",OrRepository.getOrKeyValue("SQL_OR_ORDERABLES_BY_PERFORM_LOCN_INSERT"));
            /***sqlMap.put("SQL_OR_ORDERABLES_BY_PERFORM_LOCN_UPDATE",OrRepository.getOrKeyValue("SQL_OR_ORDERABLES_BY_PERFORM_LOCN_UPDATE"));
            sqlMap.put("SQL_OR_ORDERABLES_BY_PERFORM_LOCN_DELETE",OrRepository.getOrKeyValue("SQL_OR_ORDERABLES_BY_PERFORM_LOCN_DELETE"));***/
            sqlMap.put("SQL_OR_ORDERABLES_BY_PERFORM_LOCN_DELETE_ALL",OrRepository.getOrKeyValue("SQL_OR_ORDERABLES_BY_PERFORM_LOCN_DELETE_ALL"));

            //End of changes
			//System.out.println("###########recStoreHandler.getAllDBRecords():"+recStoreHandler.getAllDBRecords());
            recordStoreParam.put("records"			,recStoreHandler.getAllDBRecords());
            //System.out.println("###########records:"+recordStoreParam.get("records"));
            recordStoreParam.put("deleteall"		,deleteall);
            recordStoreParam.put("login_by_id"		, login_by_id);
            recordStoreParam.put("login_at_ws_no"	, login_at_ws_no);
            recordStoreParam.put("login_facility_id", login_facility_id);
            return getResult(recordStoreParam,sqlMap);
        } catch (Exception e) {
            tempChk =tempChk+e.getMessage();
            logErrorMessage(e);
            return null;
        }
    }
    /** Method for modify operations
     *@return HashMap results of modify operations
     */
    public HashMap modify() {
		//System.out.println("####in modify");
        HashMap map = new HashMap();
        map.put("result", new Boolean(false));
        map.put("message", "update failure...");
        return map;
    }
    /** Method for delete operations
     *@return HashMap results of delete operations
     */
    public HashMap delete() {
        HashMap map = new HashMap();
        map.put("result", new Boolean(false));
        map.put("message", "delete failure...");
        return map;
    }
    /** Method for all database operations(called by insert,modify,delete)
     * Responsible for calling the EJB
     *@param HashMap record values for the database operations
     *@param HashMap sqlMap sql statements
     *@return HashMap results of database operations
     */
    private HashMap getResult(HashMap record, HashMap sqlMap) {
    	//System.out.println("###ASK in getResult()");
        HashMap map = new HashMap();
        try {
        	//System.out.println("ASK in try");
           /* InitialContext context = new InitialContext();
            //System.out.println("ASK after initial context");
            Object object = context.lookup(OrRepository.getOrKeyValue("OR_ORDERABLEPERFORMLOCN_JNDI"));
            //System.out.println("ASK after object");
            OROrderablePeformLocnHome home = (OROrderablePeformLocnHome)PortableRemoteObject.narrow(object, OROrderablePeformLocnHome.class);
            //System.out.println("ASK after home");
            OROrderablePeformLocnRemote remote = home.create();*/
            //System.out.println("ASK after remote");
			
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_ORDERABLEPERFORMLOCN_JNDI"), OROrderablePeformLocnHome.class, getLocalEJB());
    		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

            HashMap tabDataParam = new HashMap();
            tabDataParam.put("properties", getProperties());
            //System.out.println("ASK after getProperties()");
            tabDataParam.put("tabData", record);
            //System.out.println("ASK before calling EJB:Mode:"+mode+",recode size:"+record.size());

			Object argArray[]	= new Object[2];
				argArray[0]		= tabDataParam;
				argArray[1]		= sqlMap;
 			Class [] paramArray = new Class[2];
 		 		paramArray[0]	= tabDataParam.getClass();
				paramArray[1]	= sqlMap.getClass();

            if (mode.equals(CommonRepository.getCommonKeyValue("MODE_DELETE")))
                return null;
            else if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){

                //map = remote.insert(tabDataParam, sqlMap);
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				

			}
            else if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")))
                return null;

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				
					argArray	= null;
					paramArray	= null;
if(map.get("message").equals("ATLEAST_ONE_DEFAULT" ))
			{
map.put( "message", getMessage(language_id, (String) map.get( "message" ), "OR")) ;
			}else {
				
 map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
			}
		   // return map;
        } catch (Exception e) {
            System.err.println("Error calling EJB.." + e.getMessage());
            map.put("message", e.getMessage());
            e.printStackTrace();
           // return map;
        }return map;
    }
	
    /** Method for all validations
     *@return HashMap results of validations
     */
  /***  public HashMap validate() throws Exception {
		//System.out.println("####in validate() of bean,recStoreHandler="+recStoreHandler.getAllDBRecords());
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "" ) ;
		 HashMap tabData     =null;		 
		 Connection connection=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;		
	  try {
		 connection=getConnection();
		 ArrayList records   = (ArrayList)recStoreHandler.getAllDBRecords();
		System.out.println("####records="+records);
		 int noOfRecords = records.size() ;
		 System.out.println("noOfRecords="+noOfRecords);
		 pstmt=connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDERABLES_BY_PERFORM_LOCN_DEFAULT_YN_CHECK"));
		 //String temp_order_catalog_code="";
		 //String temp_default_yn="";
		 for(int k=0 ; k< noOfRecords ; k++){
			System.out.println("#####");
			tabData     =(HashMap)records.get(k);
			//System.out.println("####order_catalog_code="+order_catalog_code);
			pstmt.setString(1,(String)tabData.get("location_type"));
			pstmt.setString(2,(String)tabData.get("order_catalog_code"));
			System.out.println("####tabData="+tabData);
			rs=pstmt.executeQuery();
			int record_count=0;
			if(rs!=null && rs.next()){				
				//temp_order_catalog_code=rs.getString("order_catalog_code");
				//temp_default_yn=rs.getString("default_yn");
				//if(!(temp_order_catalog_code.equals((String)tabData.get("order_catalog_code"))) )
				record_count++;
			}
			closeResultSet(rs);
			System.out.println("####record_count="+record_count);
			if(record_count>1 && (((String)tabData.get("default_yn")).equals("Y"))){				
				System.out.println("###more than default");
				map.put("result",new Boolean(false));
				map.put("message","ATLEAST_ONE_DEFAULT");
				break;		
			}else{
				System.out.println("###aaaaaaaaaaaaaaaaaa");
				map.put("result",new Boolean(true));
				map.put("message","");					
			}
	  }
    } catch (Exception e) {
           System.err.println("Error validate.." + e.getMessage());
           e.printStackTrace();
		   map.put("result",new Boolean(false));
  		   map.put("message","");	
    }
	finally{
			closeResultSet(rs);
           	closeStatement(pstmt);
			closeConnection(connection);
	}
		
		
        return map;
    }***/
    /** Method for clearing all the database results
     */
    public void clearAll() {
        recStoreHandler.clearDBRec();
        recStoreHandler.clearSelectRec();
        recStoreHandler.clearDBRecOriginal();
    }
    /** Method for setting all the variables
     *@param Hashtable recordSet contains all the values for setter methods
     */
    public void setAll(Hashtable recordSet) {
		//System.out.println("####in setall() of bean recordSet ="+recordSet);

        this.mode 				= ((String)recordSet.get("mode")==null)?"1":(String)recordSet.get("mode");
        String detailPageMode_p = ((String)recordSet.get("detailPageMode")==null)?"":(String)recordSet.get("detailPageMode") ;
        this.deleteall 			= ((String)recordSet.get("deleteall")==null)?"0":(String)recordSet.get("deleteall") ;
        //System.out.println("ASK:in setAll:mode:"+mode+",detailPageMode_p:"+detailPageMode_p+",deleteall:"+deleteall);
        if(detailPageMode_p.equalsIgnoreCase("S")){
            this.detailPageMode = "S" ;
            updateCurrentPageForAsscStore(recordSet);
        }
        //System.out.println("in setAll record size:"+recStoreHandler.getAllDBRecords().size());
        if(detailPageMode_p.equalsIgnoreCase("A")){
            this.detailPageMode = "A" ;
            synAsscStore(recordSet);
        }
    }
    //Setter Methods
    /** Method for setting Location Type
     *@param String location_type
     */
    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }
    /** Method for setting Location Code
     *@param String location_code
     */
    public void setLocation_code(String location_code) {
        this.location_code = location_code;
    }
    /** Method for setting Order Type
     *@param String order_type
     */
    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }
    public void setDeleteall(String deleteall) {
    	this.deleteall = deleteall;
    }
    //Getter Methods
    /** Method for getting Location Type
     *@return String location_type
     */
    public String getLocation_type() {
        return location_type;
    }
    /** Method for getting Location Code
     *@return String location_code
     */
    public String getLocation_code() {
        return location_code;
    }
    /** Method for getting Order Type
     *@return String order_type
     */
    public String getOrder_type() {
        return order_type;
    }
    /** Method for getting Detail Page Mode
     * @return String detailPageMode
     */
    public String getDetailPageMode() {
        return detailPageMode;
    }
    /** Method for getting Action
     * @return String action
     */
    public String getAction() {
        return action;
    }
    public String getDeleteall() {
    	return this.deleteall;
    }
    /** Method for resetting all the instance variables
     */
    public void clear() {
        location_type   = "";
        location_code   = "";
        order_type      = "";
    }
    /** Method for geting Combo Options Dynamically
     */
    public String getComboBoxHtml(Hashtable ht) throws Exception {
		//System.out.println("####in getComboBoxHtml() of bean");
        String comboBoxString = "";
        String sql = "";
        String optionString = "";
        Connection connection = null;

        try {
            if (ht == null)
                return "Hash Table passed to this method is null";

            connection = getConnection();
            String type = (String)ht.get("type");
            if (type.trim().equalsIgnoreCase("LocationCode")) {
                //sql = "SELECT PERFORMING_DEPTLOC_CODE FROM OR_ORDER_FACILITY_CROSS_REF WHERE PERFORMING_FACILITY_ID=? AND PERFORMING_DEPTLOC_TYPE=?";
                sql = OrRepository.getOrKeyValue("SQL_OR_ORDERABLES_BY_PERFORM_LOCN_PERF_LOCN");
                sql = replace(sql, "?", this.getLoginFacilityId());
                sql = replace(sql, "?", (String)ht.get("location_type"));
                //System.out.println("ASK1 LOCATION CODE:"+sql);
                optionString = Populate.getComboOptions(sql,connection,"performing_deptloc_code","performing_deptloc_short_desc");
                comboBoxString="<select name='location_code' ><option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>" + optionString + "</select><img src='../../eCommon/images/mandatory.gif'></img>" ; //onChange='parent.parent.fillComboOptions(this);'
            }
            else if (type.trim().equalsIgnoreCase("OrderType")) {
                sql = OrRepository.getOrKeyValue("SQL_OR_ORDERABLES_BY_PERFORM_LOCN_ORDER_TYPE");
                String locType = (String)ht.get("location_type");
                String orderCategory = "";
                if (locType.trim().equalsIgnoreCase("L"))
                    orderCategory = "LB";
                else if (locType.trim().equalsIgnoreCase("R"))
                    orderCategory = "RD";
                else if (locType.trim().equalsIgnoreCase("I"))
                    orderCategory = "RX";
                else if (locType.trim().equalsIgnoreCase("P"))
                    orderCategory = "PC";
                else if (locType.trim().equalsIgnoreCase("M"))
                    orderCategory = "MI";
				else if (locType.trim().equalsIgnoreCase("T"))
					orderCategory = "TR";
				else if (Constants.LOCATION_TYPE.equalsIgnoreCase(locType.trim()))//IN31901
					orderCategory = Constants.ORDER_CATEGORY;//IN31901
                sql = replace(sql, "?", orderCategory);
                //System.out.println("ASK ORDER TYPE:"+sql);
                optionString = Populate.getComboOptions(sql,connection,"order_type_code","short_desc");
                comboBoxString="<select name='order_type' onChange='parent.parent.select(this);'><option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>" + optionString + "</select><img src='../../eCommon/images/mandatory.gif'></img>" ;
            }
            else
                throw new Exception("Exception :-in Bean getComboBoxHtml function Hashtable Passed should contain LocationCode or OrderType only");
        }
        catch (Exception e) {
            throw e;
        }
        finally {
        	try {
        		closeConnection(connection);
        	} catch (Exception ee) {ee.printStackTrace();}
        }
        return comboBoxString;
    }
    /** Method to replace the first occurance of the search variable
     *@param String str The Original String
     *@param String change The String to be replaced
     *@param String replace The String with which to be replaced
     */
    public String replace(String str, String change, String replace) {
        int index = str.indexOf(change);
         if (index == -1)
            return str;

        str = str.substring(0,index) + replace + str.substring(index+1);
        return str;
    }
    /**********************Handle Action in all scenario's***********************/
    public synchronized void handleAction(HttpServletRequest request) {
		//System.out.println("####in handleAction");
        String detailPageMode_p = request.getParameter("detailPageMode");
        action = request.getParameter("action");
  //System.out.println("####detailPageMode_p="+detailPageMode_p);
  //System.out.println("####action="+action);
        if (detailPageMode_p.equalsIgnoreCase("N")) {
            if (action.equalsIgnoreCase("IndexSelect")) {
                //System.out.println("in IndexSelect :");
                loadIndexData(request);
                this.detailPageMode = "S";
            }
            if (action.equalsIgnoreCase("select")) {
            	//System.out.println("in Select :");
                this.detailPageMode = "S";
            }
            if (action.equalsIgnoreCase("associated")) {
            	//System.out.println("in Associate :");
                this.detailPageMode = "A";
            }
            loadRecordedData(request);
        }
        if (detailPageMode_p.equalsIgnoreCase("S")) {
            updateCurrentPageForAsscStore(request);

            if(action.equalsIgnoreCase("indexSelect")){
                loadIndexData(request);
                this.detailPageMode = "S" ;
            }

            if(action.equalsIgnoreCase("associated")){
                this.detailPageMode = "A" ;
            }
        }
        if (detailPageMode_p.equalsIgnoreCase("A")) {
            synAsscStore(request);
            this.detailPageMode = "A";
        }
    }
    private int loadIndexData(HttpServletRequest request) {
		//System.out.println("####loadIndexData");
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        location_type = request.getParameter("location_type");
        location_code = request.getParameter("location_code");
        order_type = request.getParameter("order_type");
        OrderCatalogIndex = request.getParameter("OrderCatalogIndex");
		//System.out.println("###OrderCatalogIndex="+OrderCatalogIndex);
       // String sql = "";

        try {
            connection = getConnection();
            if (OrderCatalogIndex.trim().equalsIgnoreCase("others")) {
            	pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDERABLES_BY_PERFORM_LOCN_CATALOG_OTH"));
                OrderCatalogIndex = "A%";
            }
            else {
                OrderCatalogIndex = OrderCatalogIndex.trim() + "%";
                pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDERABLES_BY_PERFORM_LOCN_CATALOG"));
            }
            pstmt.setString(1, order_type.trim());
            pstmt.setString(2, OrderCatalogIndex.trim());

            rs = pstmt.executeQuery();

            recStoreHandler.clearSelectRec();
			HashMap tempHash=null;
			String tempCatalog="";
			String associate_yn="";
			HashMap tempChk=null;

            while (rs.next()) {
                tempHash = new HashMap();
                tempCatalog = rs.getString("order_catalog_code");

                String pk[] ={tempCatalog};//Primary Key
	            //System.out.println("pk[]="+pk[0]);
	            int index =	recStoreHandler.containsElement(pk) ;
	            //System.out.println("index="+index);
	            //this.tempChk += "  " + index;
				this.tempChk=this.tempChk+ "  " + index;
	            associate_yn = "N";
	            if(index != -1){//Rec is there in Ascc store
	                tempChk	 =(HashMap)recStoreHandler.getObject(index);
	                associate_yn = (String)tempChk.get("associate_yn");
	                //System.out.print("in loadIndex:associate_yn="+associate_yn);
	            }
				//System.out.println("appt_reqd_yn 501"+rs.getString("appt_reqd_yn"));
				//System.out.println("tempCatalog 502"+tempCatalog);
                tempHash.put("location_type", location_type);
                tempHash.put("location_code", location_code);
                tempHash.put("order_type", order_type);
                tempHash.put("order_catalog_code", tempCatalog);
                tempHash.put("order_catalog_desc",  rs.getString("short_desc"));
                tempHash.put("appt_reqd_yn", rs.getString("appt_reqd_yn"));
                tempHash.put("default_yn", "N");
                tempHash.put("valid", "N");
                tempHash.put("associate_yn", associate_yn);
				tempHash.put("cat_appt_reqd_yn"		,   rs.getString("appt_reqd_yn"));
                //System.out.println("in loadIndexData(HttpServletRequest)");
                tempHash.put("status", "N");
				//System.out.println("tempHash 514"+tempHash);

                recStoreHandler.putListObject(tempHash);
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        finally {
            try {
            	closeResultSet(rs);
            	closeStatement(pstmt);
                closeConnection(connection);
            } catch (Exception ee) {ee.printStackTrace();}
        }

        return recStoreHandler.getSize("SELECT");
    }
    private void updateCurrentPageForAsscStore(HttpServletRequest request) {
		//System.out.println("###in updateCurrentPageForAsscStore in http request");
        int fm_disp  =ChkDef.defaultInt(request.getParameter("previousRecord"));
        int to_disp	 =ChkDef.defaultInt(request.getParameter("nextRecord"));
        try {
			String ascc = "";
                HashMap ht  =null;
            for (int i = fm_disp-1; i <to_disp ; i++){
            	//System.out.println("in updateCurrentPageForAsscStore(HttpServletRequest)");
                ascc = checkForNull((String)request.getParameter("include" + i),"N");
                ht  =(HashMap)recStoreHandler.getListObject(i);
				//System.out.println("####ht="+ht);
                String pk[] ={(String)ht.get("order_catalog_code")};//Primary Key
                ht = Validaty(ht); //this will give the inserted record if already present in the database
                if(((String)ht.get("valid")).trim().equalsIgnoreCase("Y")) continue;
                if(ascc.trim().equalsIgnoreCase("Y")){
                    ht.put("appt_reqd_yn", (String)request.getParameter("appt_reqd_yn" + i));
                    ht.put("default_yn", (String)request.getParameter("default_yn" + i));
                    ht.put("valid","N");
                    ht.put("associate_yn", "Y");
                    //System.out.println("appt_reqd_yn in updateCurrentPageForAsscStore(HttpServletRequest)");
                    ht.put("status", "Y");
					recStoreHandler.setObject(pk,ht);
                }
                else {
                    int indx = recStoreHandler.containsElement(pk);
                    if(indx != -1 )
                        recStoreHandler.removeObject(indx);
                }
            }
        }
        catch (Exception e) {e.printStackTrace();
        }
    }
    private void updateCurrentPageForAsscStore(Hashtable request){
        int fm_disp  =ChkDef.defaultInt(((String)request.get("previousRecord")));
        int to_disp	 =ChkDef.defaultInt(((String)request.get("nextRecord")));
      //System.out.println("####in updateCurrentPageForAsscStore:fm_disp:"+fm_disp+",to_disp:"+to_disp);
        try {
			String ascc = "";
             HashMap ht  =null;
            for (int i = fm_disp-1; i <to_disp ; i++){
                ascc = checkForNull(((String)request.get("include" + i)),"N");
                //System.out.println("ASK ascc:"+ascc);
                ht  =(HashMap)recStoreHandler.getListObject(i);
               //System.out.println("#####ASK ht"+ht);
                String pk[] ={(String)ht.get("order_catalog_code")};//Primary Key
               // System.out.println("pk[]:"+(String)ht.get("order_catalog_code"));
                //System.out.println("ASK pk.length:"+pk.length);
                ht = Validaty(ht); //this will give the inserted record if already present in the database
				//System.out.println("####ht="+ht);
                if(((String)ht.get("valid")).trim().equalsIgnoreCase("Y"))
                    continue;
                //System.out.println("#####ASK after valid");
                if(ascc.trim().equalsIgnoreCase("Y")){
                    ht.put("appt_reqd_yn", request.get("appt_reqd_yn" + i)==null?"":(String)request.get("appt_reqd_yn" + i));
					ht.put("default_yn", request.get("default_yn" + i)==null?"":(String)request.get("default_yn" + i));
                    //System.out.println("ASK after appt_reqd_yn="+ht.get("appt_reqd_yn")+","+ (String)request.get("appt_reqd_yn" + i));
                    ht.put("valid","N");
                    //System.out.println("ASK after valid put");
                    ht.put("associate_yn","Y");
                    //System.out.println("ASK after associate_yn put in updateCurrentPageForAsscStore="+ht.get("associate_yn"));
                    ht.put("status","Y");
                    //System.out.println("ASK after status put");
                    recStoreHandler.setObject(pk,ht);//Will add or set depending upon the primary key match
                } else {
                    //System.out.println("in updateCurrentPageForAsscStore records size:"+recStoreHandler.getAllDBRecords().size());
					int indx = recStoreHandler.containsElement(pk);
                    //System.out.println("ASK after indx:"+indx);
                    if(indx != -1 ) recStoreHandler.removeObject(indx);
                    //System.out.println("ASK after removeObject(index)");
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public synchronized HashMap Validaty(HashMap record ){
        try{
			//System.out.println("####in validaty() ");
			//System.out.println("####in validaty() detailPageMode="+detailPageMode);
            if(detailPageMode.equalsIgnoreCase("A"))
                return record ; //return Original
            String pk[] ={(String)record.get("order_catalog_code")};//Primary Key
            //System.out.println("### in Validaty,pk="+(String)record.get("order_catalog_code"));
            int index =	recStoreHandler.containsElement(pk) ;
            //System.out.println("index="+index);
            //this.tempChk += "  " + index;
			this.tempChk = this.tempChk+ "  " + index;
            if(index != -1){//Rec is there in Ascc store
                HashMap tempChk	 =(HashMap)recStoreHandler.getObject(index);
                String valid = (String)tempChk.get("valid");
                //System.out.println("valid="+valid);
              //  String associate_yn = (String)tempChk.get("associate_yn");
                //System.out.println("Validaty:associate_yn="+associate_yn);
                if(valid.trim().equalsIgnoreCase("Y")){//if it was form DataBase
                    int indexOriginal = recStoreHandler.containsElementInOriginalDB(pk);
                    //System.out.println("indexOriginal="+indexOriginal);
                    if(indexOriginal != -1){
						//System.out.println("in if");
                        return (HashMap)recStoreHandler.getObjectOriginal(indexOriginal) ;//DataBase record
					}
                    else
					{
						//System.out.println("in else");
                        return null ;//Some Error Condition Chk it
					}
                }
                else return (HashMap)recStoreHandler.getObject(index) ;//Ascc record
            }
            else return record;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private void  synAsscStore(HttpServletRequest request){
		//System.out.println("#####synAsscStore()1");
        int fm_disp  =ChkDef.defaultInt(request.getParameter("previousRecord"));
        int to_disp	 =ChkDef.defaultInt(request.getParameter("nextRecord"));
        try {
			Hashtable ht=null;
            for (int i = fm_disp-1; i <to_disp ; i++){
                ht  = new Hashtable();
                ht.put("appt_reqd_yn", checkForNull((String)request.getParameter("appt_reqd_yn" + i),"N"));
				ht.put("default_yn", checkForNull((String)request.getParameter("default_yn" + i),"N"));
                ht.put("include",checkForNull((String)request.getParameter("include" + i),"N"));
                recStoreHandler.setDBBeanValue(i,ht);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void  synAsscStore(Hashtable request){
		//System.out.println("#####synAsscStore()2####");
        int fm_disp  =ChkDef.defaultInt(((String)request.get("previousRecord")));
        int to_disp	 =ChkDef.defaultInt(((String)request.get("nextRecord")));
        //System.out.println("in synAsscStore:fm_disp:"+fm_disp+",to_disp:"+to_disp);
        try{
			Hashtable ht =null;
            for (int i = fm_disp-1; i <to_disp ; i++){
            ht  = new Hashtable();
         ht.put("appt_reqd_yn", checkForNull((String)request.get("appt_reqd_yn" + i),"N"));
         ht.put("default_yn", checkForNull((String)request.get("default_yn" + i),"N"));
         ht.put("include",checkForNull((String)request.get("include" + i),"N"));
         //System.out.println("in synAsscStore(Hashtable) appt_reqd_yn:"+checkForNull((String)request.get("appt_reqd_yn" + i),"N")+",include:"+checkForNull((String)request.get("include" + i),"N"));
         recStoreHandler.setDBBeanValue(i,ht);
                //System.out.println("in synAsscStore(Hashtable) after recStoreHandler.setDBBeanValue");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public synchronized Object getRecord(int i){
		//System.out.println("####in getRecord(),detailPageMode="+detailPageMode);
      //  String action	= request.getParameter("action") ;
	 // System.out.println("####recStoreHandler="+recStoreHandler);
	 // System.out.println("####detailPageMode="+detailPageMode);
        try{
            if(detailPageMode.equalsIgnoreCase("A")){
				//System.out.println("####in getRecord of bean,recStoreHandler.getObject(i)="+recStoreHandler.getObject(i));
                return recStoreHandler.getObject(i) ;
            }else{
				//System.out.println("####in getRecord of bean recStoreHandler.getListObject(i)="+recStoreHandler.getListObject(i));
                return recStoreHandler.getListObject(i) ;}
        }catch(Exception e){
            return null ;
        }
    }
    public synchronized int getRecordsNo(){
			//System.out.println("####in getRecord(),detailPageMode="+detailPageMode);
        //String action	= request.getParameter("action") ;
        if(detailPageMode.equalsIgnoreCase("A"))
            return recStoreHandler.getSize("DB") ;
        else
            return recStoreHandler.getSize("SELECT") ;
    }
    //public  synchronized void SortedArrayListAscc(){
    //}
    public  synchronized void SortedArrayListAscc(){
			//System.out.println("####in SortedArrayListAscc(),########");

        java.util.ArrayList tempRef		= recStoreHandler.getAllDBRecords();
        java.util.TreeMap sorter			= new java.util.TreeMap();
        java.util.ArrayList holdDuplicate = new java.util.ArrayList();

        int sizeAscc = tempRef.size(); //ref of the Object DB Array List
		HashMap tempHash = null;
        String seqNoStr = "";
        for(int i=0 ; i < sizeAscc ; i++){
            tempHash = (java.util.HashMap)tempRef.get(i);
            seqNoStr = checkForNull(((String)tempHash.get("order_catalog_code")),"0");
            //Integer seqNo   = new Integer( Integer.parseInt(seqNoStr));
            if(!sorter.containsKey(seqNoStr)){
                sorter.put(seqNoStr,tempHash);
            }else{
                holdDuplicate.add(tempHash);//array List of Dup records
            }
        }
        tempRef.clear();//Clear  the  DB  records

        Collection  coll = sorter.values();
        Iterator iter    = coll.iterator();

        int dupSize = holdDuplicate.size();
		 HashMap tempSrt	 =null;
         String  seqNoStr1  ="";
		 HashMap tempDup	= null;
         String seqNoStr2	= "";

        while(iter.hasNext()){
            tempSrt	 =(java.util.HashMap)iter.next();
            seqNoStr1  =checkForNull(((String)tempSrt.get("order_catalog_code")),"0");
            //int     seqNoSrt   =Integer.parseInt(seqNoStr1);

            for(int j=0;j<dupSize;j++){
                tempDup	= (java.util.HashMap)holdDuplicate.get(j);
                seqNoStr2	= checkForNull(((String)tempDup.get("order_catalog_code")),"0");
                //int  seqNoDup		=Integer.parseInt(seqNoStr2);
                if(seqNoStr1.equals(seqNoStr2))
                    tempRef.add(tempDup);	//inserting Dup Values
            }

            tempRef.add(tempSrt);
        }
    }

    public String getLbInstall(String module_id) throws Exception {
		//System.out.println("####in getLbInstall(),########");
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String lb_install_yn	= "N";
		try{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));
			pstmt.setString(1, checkForNull(module_id.trim(),""));
			pstmt.setString(2, login_facility_id);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				while(resultSet.next())
				{
					lb_install_yn = checkForNull(resultSet.getString( "operational_yn" ),"N")  ;
				}
			}
		}catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			} catch (Exception ee) {ee.printStackTrace();}
		}
		return lb_install_yn;
	}
    public synchronized int  loadRecordedData(HttpServletRequest request){
	//System.out.println("####in loadRecordedData(),########");

        Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet rs		 		= null;
		
		if(recStoreHandler.getSize("DB")>0){
			//System.out.println("****here*****");
            return recStoreHandler.getSize("DB");
		}

        location_type = request.getParameter("location_type");
        location_code = request.getParameter("location_code");
        order_type = request.getParameter("order_type");
        String sql		 ="";

        try
        {
            //System.out.println("in loadRecordedData:in try");
			connection	 = getConnection();
            sql = OrRepository.getOrKeyValue("SQL_OR_ORDERABLES_BY_PERFORM_LOCN_SELECT");
            //sql = "SELECT a.order_catalog_code order_catalog_code,b.short_desc order_catalog_short_desc,a.appt_reqd_yn appt_reqd_yn FROM or_orderables_for_deptloc a,or_order_catalog b WHERE a.order_catalog_code=b.order_catalog_code AND a.performing_facility_id=? AND a.performing_deptloc_type=? AND a.performing_deptloc_code=? AND a.order_type_code=?";

            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,ChkDef.defaultString(login_facility_id));
            pstmt.setString(2,ChkDef.defaultString(location_type));
            pstmt.setString(3,ChkDef.defaultString(location_code));
            pstmt.setString(4,ChkDef.defaultString(order_type));

            rs = pstmt.executeQuery();
			//System.out.println("in loadRecordedData: after executeQuery");

           /*** HashMap allHash = new HashMap();
            allHash.put("location_type"		, location_type);
            allHash.put("location_code"		, location_code);
            allHash.put("order_type"		, order_type);
            allHash.put("order_catalog_code", "*ALL");
            allHash.put("order_catalog_desc", "ALL");
            allHash.put("appt_reqd_yn"		, "N");
            allHash.put("default_yn"		, "N");
            allHash.put("valid"				, getAllSelect(location_type,location_code,order_type));
            allHash.put("associate_yn"		, getAllSelect(location_type,location_code,order_type));
            allHash.put("status"			, "N");

            recStoreHandler.putObject(allHash);***/

			 HashMap	tempHash = null;
             HashMap	tempHashO = null;
				//System.out.println("in loadRecordedData: in rs.next");

             String order_catalog_code 	= "";
             String order_catalog_desc 	= "";
             String appt_reqd_yn 		= "";
             String cat_appt_reqd_yn 		= "";
             String default_yn 		= "";

            while(rs.next()){

                tempHash = new HashMap();
                tempHashO = new HashMap();
				//System.out.println("in loadRecordedData: in rs.next");

                order_catalog_code 	= rs.getString("order_catalog_code");
                order_catalog_desc 	= rs.getString("order_catalog_short_desc");
                appt_reqd_yn 		= rs.getString("appt_reqd_yn");
                default_yn 		= rs.getString("default_yn");
                cat_appt_reqd_yn 		= rs.getString("cat_appt_reqd_yn");

                tempHash.put("location_type"	,location_type);
                tempHash.put("location_code"	,location_code);
                tempHash.put("order_type"		, order_type);
                tempHash.put("order_catalog_code", order_catalog_code);
                tempHash.put("order_catalog_desc", order_catalog_desc);
                tempHash.put("appt_reqd_yn"		, appt_reqd_yn);
                tempHash.put("default_yn"		, default_yn);
                tempHash.put("valid"			,	"Y");
                tempHash.put("associate_yn"		,   "y");
                tempHash.put("cat_appt_reqd_yn"		,   cat_appt_reqd_yn);
                //System.out.println("in loadRecordedData");
                tempHash.put("status"			,   "N");

                //Holding Original value
                tempHashO.put("location_type"		, location_type);
                tempHashO.put("location_code"		, location_code);
                tempHashO.put("order_type"			, order_type);
                tempHashO.put("order_catalog_code"	, order_catalog_code);
                tempHashO.put("order_catalog_desc"	, order_catalog_desc);
                tempHashO.put("appt_reqd_yn"		, appt_reqd_yn);
                tempHashO.put("default_yn"		, default_yn);
                tempHashO.put("valid"				, "Y");
                tempHashO.put("associate_yn"		, "y");
                tempHashO.put("status"				, "N");
				tempHashO.put("cat_appt_reqd_yn"		,   cat_appt_reqd_yn);

                recStoreHandler.putObject(tempHash);
                //System.out.println("in loadRecordedData: after putObject");
                recStoreHandler.putObjectOriginal(tempHashO);
                //System.out.println("in loadRecordedData: after putObjectOriginal");
            } //End of while loop

        }catch(Exception e){
			e.printStackTrace();
        }finally{
            try
            {
                closeResultSet(rs);
                closeStatement(pstmt);
				closeConnection(connection);
            }catch(Exception e){e.printStackTrace();}
        }

        return recStoreHandler.getSize("DB");

    }
    public String getAllSelect(String location_type,String location_code,String order_type) throws Exception {
//System.out.println("####in getAllSelect(),########");
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String all_select_yn		= "N";
		try{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDERABLES_BY_PERFORM_LOCN_ALL_SELECT"));
			pstmt.setString(1, login_facility_id);
			pstmt.setString(2, location_type);
			pstmt.setString(3, location_code);
			pstmt.setString(4, order_type);
			pstmt.setString(5, "*ALL");
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				if(resultSet.next())
				{
					if (resultSet.getInt(1) > 0) all_select_yn = "Y";
				}
			}
		}catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			} catch (Exception ee) {ee.printStackTrace();}
		}
		return all_select_yn;
	}

    /*****************Synchronization*****************************/
	public synchronized boolean  doSync(Hashtable request) throws Exception{
	try
	{
//System.out.println("####in doSync(),########");

	//	String tabType  = "";

	/*	if(request.containsKey("tabType"))
			tabType = (String)request.get("tabType");
    */
	//	tempChk = "tabType=" + tabType ;

		//if(tabType.trim().equalsIgnoreCase("C"))
		//System.out.println("in doSync");
			componentSyn(request);

		return true;

	    }catch(Exception e){
		   throw new Exception(e.getMessage());
	  }
	}
	/**********************Store the Freq,dura type,value for Components Tab********/

	/********componentSyn************************************************************/
	private void componentSyn(Hashtable request){
	
		String detailPageMode_p	=(String)request.get("detailPageMode") ;
		this.action				=(String)request.get("action") ;
		//System.out.println("####in componentSyn()detailPageMode_p="+detailPageMode_p);
		//System.out.println("####in componentSyn(),action="+this.action	);

		//tempChk += "componentSyn"	;
		//System.out.println("in componentSyn="+detailPageMode_p);

	
		if(detailPageMode_p.equalsIgnoreCase("S")){//i:e if detail page mode was selected
		//	tempChk += "update for componentSyn"	;
			updateCurrentPageForAsscStore(request);
		}

		if(detailPageMode_p.equalsIgnoreCase("A")){
			synAsscStore(request);
		}

	}
}
