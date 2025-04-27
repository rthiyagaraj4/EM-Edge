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
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.AlternateDispLocn.*;

public class AltDispLocnBean extends PhAdapter implements Serializable {

	private HashMap initDatas	= null;

   private  ArrayList altdisp=new ArrayList();
            private ArrayList desptimes=new ArrayList();

	String ord_fcy_id			= "";
	String ord_src_type			= "";
	String order_src_locn		= "";
	String perform_fcy_id		= "";
	String disp_locn_code		= "";
//,.,
	String Time_from		    = "";
	String Time_to		        = "";
	String Eff_status		    = "";
	String disp_loc_code        ="";
	String day_type		        ="";
	String routing_level		="";
	String routing_code			="";
	String priority		        ="";
	public AltDispLocnBean() {
		try {
			doCommon() ;
		}
		catch(Exception e) {e.printStackTrace();}
	}

	/* Over-ridden Adapter methods start here */
	private void doCommon() throws Exception {
	}

	public void clear() {
		super.clear() ;
		altdisp					= new ArrayList();
		desptimes				= new ArrayList();
		ord_fcy_id				= "";
		ord_src_type			= "";
		order_src_locn		= "";
		perform_fcy_id		= "";
		disp_locn_code		= "";
		                          
		Time_from			    = "";
		Time_to					= "";
		Eff_status				= "";
		disp_loc_code		= "";
		routing_level ="";
		routing_code="";
		priority="";
	}	
	public void setRoutingLevel(String routing_level)
	{
		this.routing_level=routing_level;
	}
	public void setRoutingCode(String routing_code)
	{
		this.routing_code=routing_code;
	}
	public void setPriority(String priority)
	{
		this.priority=priority;
	}
	public void setOrderFcyId(String ord_fcy_id) {
		this.ord_fcy_id = ord_fcy_id;
	}

	public void setOrderSrcType(String ord_src_type) {
		this.ord_src_type = ord_src_type;
	}

	public void setOrderSrcLocn(String order_src_locn) {
		this.order_src_locn = order_src_locn;
	}

	public void setPerformFcyId(String perform_fcy_id) {
		this.perform_fcy_id = perform_fcy_id;
	}

	public void setPerformLocn(String disp_locn_code) {
		this.disp_locn_code = disp_locn_code;
	}
    public void setTimefrom(String Time_from) {
		this.Time_from = Time_from;
		
	}
	public void setTimeto(String Time_to) {
		this.Time_to = Time_to;
	}
	public void seteffstatusval(String Eff_status) {
		this.Eff_status = Eff_status;
	}
	public void setaltdisploc(String alt_disp_loc_code) {
		this.disp_loc_code =disp_loc_code;
	}
	public void setDayType(String day_type) {
		this.day_type =day_type;
	}
	public String getPriority()
	{
		return priority;
	}
	public String getRoutingLevel()
	{
		return routing_level;
	}
	public String setRoutingCode()
	{
		return routing_code;
	}
 	public String getOrderFcyId() {
		return this.ord_fcy_id;
	}

	public String getOrderSrcType() {
		return this.ord_src_type;
	}

	public String getOrderSrcLocn() {
		return this.order_src_locn;
	}

	public String getPerformFcyId() {
		return this.perform_fcy_id;
	}

	public String getPerformLocn() {
		return this.disp_locn_code;
	}


   public String getTimefrom() {
		return this.Time_from;
	}
	public String getTimeto() {
		return this.Time_to;
	}
	public String geteffstatusval() {
		return this.Eff_status;
	}
	public String getaltdisploc() {
		return this.disp_loc_code;
	}
	public String getDayType() {
		return this.day_type;
	}

	public void setAll( Hashtable recordSet ) {
		if(recordSet.containsKey("routing_level")){
			setRoutingLevel((String)recordSet.get("routing_level"));
		}
		if(recordSet.containsKey("LOCN_BS_ORDRS")){
			setPriority((String)recordSet.get("LOCN_BS_ORDRS"));
		}
		if(recordSet.containsKey("routing_code")){
			String rout=(String)recordSet.get("routing_code");
			if(rout.equals("")|| rout==null){
				if(recordSet.containsKey("drug_code"))
					rout=(String)recordSet.get("drug_code");
				else
					rout="";
			}
			setRoutingCode(rout);
		}
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
		if(recordSet.containsKey("ORDER_FCY"))
			setOrderFcyId((String)recordSet.get("ORDER_FCY")) ;
		if(recordSet.containsKey("ORDER_SRC_TYPE")){
			String orsrctp=(String)recordSet.get("ORDER_SRC_TYPE");
			
			if(orsrctp.equals("N")||orsrctp.equals("D"))
					orsrctp="N";
			if(orsrctp.equals("C")||orsrctp.equals("E"))
					orsrctp="C";
			setOrderSrcType(orsrctp) ;
		}
		if(recordSet.containsKey("ORDER_SRC_LOCN"))
			setOrderSrcLocn((String)recordSet.get("ORDER_SRC_LOCN")) ;
		if(recordSet.containsKey("PERFORM_FCY"))
			setPerformFcyId((String)recordSet.get("PERFORM_FCY")) ;
		if(recordSet.containsKey("disp_locn_code"))
			setPerformLocn(((String)recordSet.get("disp_locn_code")).trim()) ;
		if(recordSet.containsKey("Time_from"))
			setTimefrom((String)recordSet.get("Time_from")) ;
		if(recordSet.containsKey("Time_to"))
			setTimeto((String)recordSet.get("Time_to")) ;
		if(recordSet.containsKey("day_type"))
			setDayType((String)recordSet.get("day_type")) ;
		if(recordSet.containsKey("Eff_status"))
		 seteffstatusval(((String)recordSet.get("Eff_status")).equalsIgnoreCase("E")?((String)recordSet.get("Eff_status")):"D") ;

		if(recordSet.containsKey("alt_disp_loc_code"))
			setaltdisploc((String)recordSet.get("alt_disp_loc_code")) ;

	}

	public HashMap validate() throws Exception {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map ;
	}

	public String TimeChk() {
		Connection connection	         = null ;
		ResultSet resultSet				 = null;
		PreparedStatement cstmt		 = null ;
		StringBuffer st						 = new StringBuffer();
		String res="ss";
		HashMap	record = null;
		/* st.append(Time_from);
		 st.append(",");
		 st.append(Time_to);
		 st.append(",");*/
		for(int i=0; i<altdisp.size(); i++) {
			record = (HashMap)altdisp.get(i);
			if((((String)record.get("frmtime"))!="") && (((String)record.get("totime"))!="")) {
				if(((String)record.get("eff_status")).equals("E")){
					st.append((String)record.get("frmtime"));
                    st.append(",");
			        st.append((String)record.get("totime"));
			        st.append(",");			
				}
			}
		}
		String se = st.toString();
		try {
			connection		= getConnection() ;
			cstmt= connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ALT_DISP_LOCN_SELECT1F" )) ;
			cstmt.setString(1, se);
			resultSet = cstmt.executeQuery();
			
			while (resultSet.next()) {
				res	= resultSet.getString(1);
			}
		}
		catch (Exception e) {
			e.printStackTrace() ;
		}
			 
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement(cstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { es.printStackTrace();}
		}
		return res;
	}

	public HashMap insert() {
		String res = TimeChk();
		 if (res.equals("Y")) {
			
			HashMap map = new HashMap() ;
			map.put( "result", new Boolean( false ) ) ;
			map.put( "flag", "test" ) ;
			//map.put( "message", "APP-PH001 The Alternate Dispence Timings Are Overlapping") ;
			map.put( "message", getMessage(getLanguageId(),"ALT_TIMINGS_OVERLAP","PH")) ;
			return map;
 
		}
		else {
			return updateTable(); 
		}
	}

	public HashMap modify() {
		return updateTable();
	}

	/* Over-ridden Adapter methods end here */

	/* Function specific methods start */
	private HashMap updateTable() {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "test" ) ;
		map.put( "message", getMode() ) ;

		HashMap commonData = new HashMap() ;
		commonData.put( "ord_fcy_id",			ord_fcy_id ) ;
		commonData.put( "ord_src_type",			ord_src_type ) ;
		commonData.put( "order_src_locn",		order_src_locn ) ;
		commonData.put( "perform_fcy_id",		perform_fcy_id ) ;
		commonData.put( "disp_locn_code",	    disp_locn_code ) ;
		commonData.put( "day_type",				day_type ) ;
		commonData.put( "login_by_id",			login_by_id ) ;
		commonData.put( "login_at_ws_no",		login_at_ws_no ) ;
		commonData.put( "login_facility_id",	login_facility_id ) ;
		commonData.put( "routing_level",	    routing_level ) ;
		commonData.put( "routing_code",	        routing_code ) ;
		commonData.put( "priority",				priority ) ;

		HashMap tabData = new HashMap() ;
		tabData.put( "COMMONDATA", commonData ) ;
		tabData.put( "PROPERTIES", getProperties() ) ;
		tabData.put( "INSERTDATA", altdisp ) ;
		HashMap sqlMap = new HashMap() ;
		try {
			//sqlMap.put( "INSERTSQL", PhRepository.getPhKeyValue( "SQL_PH_ALT_DISP_LOCN_INSERT" ) ) ;
			sqlMap.put( "INSERTSQL", "INSERT INTO PH_ALT_DISP_LOCN(ORDERING_FACILITY_ID, ORDERING_SOURCE_TYPE, ORDERING_SOURCE_CODE, PERFORMING_FACILITY_ID, DISP_LOCN_CODE,ALT_DISP_LOCN_CODE, DAY_TYPE,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE,  MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,TIME_FROM,TIME_TO,EFF_STATUS, ORD_LEVEL_IND, ROUTING_LEVEL, ROUTING_CODE)VALUES (?, ?, ?, ?, ?, ?, ?, ?,SYSDATE, ?, ?, ?, SYSDATE, ?, ?,TO_DATE(?,'hh24:mi'),TO_DATE(?,'hh24:mi'),?,?,?,?)" ) ;
			//sqlMap.put( "UPDATESQL", PhRepository.getPhKeyValue( "SQL_PH_ALT_DISP_LOCN_UPDATE" ) );
			sqlMap.put( "UPDATESQL", "DELETE FROM PH_ALT_DISP_LOCN WHERE ORDERING_FACILITY_ID=? AND ORDERING_SOURCE_TYPE=? AND ORDERING_SOURCE_CODE=? AND PERFORMING_FACILITY_ID=? AND DISP_LOCN_CODE=? AND DAY_TYPE=? AND ORD_LEVEL_IND=? AND ROUTING_LEVEL=? AND ROUTING_CODE=?" );
		 
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_ALT_DISP_LOCN" ),AlternateDispLocnHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;
			
			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();

			if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )  || mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) )
			map=(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) map.get( "result" )).booleanValue() ) {
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH" )) ;
			}
			else {
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH" ) ) ;
			}
		}
		catch (Exception e) {
			System.err.println( "Error Calling EJB11--bean : "+tabData) ;
			map.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;
		}
		map.put( "flag", map.get( "flag" ));
		return map ;
	}


	public HashMap getHashData() {
		return initDatas;
	}

	public String getLoggedInFacility()  {
		return login_facility_id;
	}

	public ArrayList getFacilities() {
		Connection connection		= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet				= null ;
		ArrayList facilities				= new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ALT_DISP_LOCN_SELECT1" )) ;
			pstmt.setString(1,getLanguageId());
			resultSet = pstmt.executeQuery() ;

			while (resultSet.next()) {
				facilities.add(resultSet.getString("FACILITY_ID"));
				facilities.add(resultSet.getString("FACILITY_NAME"));
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
			catch(Exception es) { es.printStackTrace();}
		}
		return facilities;
	}

	public ArrayList getCurrDispLocation(String logged_fcy,String ord_src_type,String ord_src_code1) {
		Connection connection			= null ;
		PreparedStatement pstmt		= null ;
		PreparedStatement pstmt1		= null ;
		PreparedStatement pstmt2		= null ;
		ResultSet resultSet					= null ;
		ResultSet resultSet1				= null ;
		ResultSet resultSet2				= null ;
		ArrayList displocation				= new ArrayList();
		HashMap disp_code				= null;
		String flag="N";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ALT_DISP_LOCN_SELECT1A" )) ;
			pstmt.setString(1, logged_fcy);
			pstmt.setString(2, ord_src_type);
			pstmt.setString(3, ord_src_code1);
			pstmt.setString(4,getLanguageId());
			pstmt.setString(5,getLanguageId());
			resultSet = pstmt.executeQuery() ;

			while (resultSet.next()) {
				disp_code = new HashMap();
				disp_code.put("CODE",resultSet.getString("RTN_ORD_DISP_LOCN_CODE"));
				disp_code.put("DESC",resultSet.getString("RTN_ORD_DISP_LOCN_DESC"));
				if(!displocation.contains(disp_code)){
					displocation.add(disp_code);
				}
				disp_code = new HashMap();
				disp_code.put("CODE",resultSet.getString("STAT_ORD_DISP_LOCN_CODE"));
				disp_code.put("DESC",resultSet.getString("STAT_ORD_DISP_LOCN_DESC"));
				if(!displocation.contains(disp_code)){
					displocation.add(disp_code);
				}
				disp_code = new HashMap();
			    disp_code.put("CODE",resultSet.getString("DISCH_ORD_DISP_LOCN_CODE"));
				disp_code.put("DESC",resultSet.getString("DISCH_ORD_DISP_LOCN_DESC"));
				if(!displocation.contains(disp_code)){
					displocation.add(disp_code);
				}
				disp_code=null;
			}
			if(displocation.size() == 0){
				pstmt1 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ALT_DISP_LOCN_SELECT1B" )) ;
				pstmt1.setString(1, logged_fcy);
				pstmt1.setString(2, ord_src_type);
				pstmt1.setString(3, ord_src_code1);
				pstmt1.setString(4,getLanguageId());
				pstmt1.setString(5,getLanguageId());
				resultSet1 = pstmt1.executeQuery() ;
				
				while (resultSet1.next()) {
					flag="Y";
					disp_code = new HashMap();
					disp_code.put("CODE",resultSet1.getString("RTN_ORD_DISP_LOCN_CODE"));
					disp_code.put("DESC",resultSet1.getString("RTN_ORD_DISP_LOCN_DESC"));
					if(!displocation.contains(disp_code)){
						displocation.add(disp_code);
					}
					disp_code = new HashMap();
					disp_code.put("CODE",resultSet1.getString("STAT_ORD_DISP_LOCN_CODE"));
					disp_code.put("DESC",resultSet1.getString("STAT_ORD_DISP_LOCN_DESC"));
					if(!displocation.contains(disp_code)){
						displocation.add(disp_code);
					}
					disp_code = new HashMap();
					disp_code.put("CODE",resultSet1.getString("DISCH_ORD_DISP_LOCN_CODE"));
					disp_code.put("DESC",resultSet1.getString("DISCH_ORD_DISP_LOCN_DESC"));
					if(!displocation.contains(disp_code)){
						displocation.add(disp_code);
					}
				}
			}
            if(displocation.size() == 0 || flag.equals("N")) { 
			  // pstmt2 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_PRESCRIPTION_SELECT27" )) ;
				pstmt2 = connection.prepareStatement( "SELECT	Decode(?,'C',A.OP_DISP_LOCN_RTN_ORD,'N',IP_DISP_LOCN_RTN_ORD)  RTN_ORD_DISP_LOCN_CODE,Decode(?,'C',B.SHORT_DESC,'N',E.SHORT_DESC)  RTN_ORD_DISP_LOCN_DESC, 	Decode(?,'C',A.OP_DISP_LOCN_STAT_ORD,'N',IP_DISP_LOCN_STAT_ORD)  STAT_ORD_DISP_LOCN_CODE, 	Decode(?,'C',C.SHORT_DESC,'N',f.SHORT_DESC)  STAT_ORD_DISP_LOCN_DESC,	A.DISCH_MED_DISP_LOCN DISCH_ORD_DISP_LOCN_CODE ,	D.SHORT_DESC DISCH_ORD_DISP_LOCN_DESC  FROM	PH_FACILITY_PARAM A, 	PH_DISP_LOCN_LANG_VW B, PH_DISP_LOCN_LANG_VW C, PH_DISP_LOCN_LANG_VW D, PH_DISP_LOCN_LANG_VW E, PH_DISP_LOCN_LANG_VW F   WHERE	A.FACILITY_ID=B.FACILITY_ID(+) 	AND A.OP_DISP_LOCN_RTN_ORD=B.DISP_LOCN_CODE(+) AND A.FACILITY_ID=C.FACILITY_ID(+)   AND A.OP_DISP_LOCN_STAT_ORD=C.DISP_LOCN_CODE(+) AND A.FACILITY_ID=D.FACILITY_ID(+) 	AND A.DISCH_MED_DISP_LOCN = D.DISP_LOCN_CODE(+) AND A.FACILITY_ID=E.FACILITY_ID(+) 	AND A.IP_DISP_LOCN_RTN_ORD = E.DISP_LOCN_CODE(+)AND A.FACILITY_ID=E.FACILITY_ID(+)   AND A.IP_DISP_LOCN_RTN_ORD = E.DISP_LOCN_CODE(+) 	AND A.FACILITY_ID=F.FACILITY_ID(+) AND A.IP_DISP_LOCN_STAT_ORD = F.DISP_LOCN_CODE(+) 	AND A.FACILITY_ID=?  AND B.LANGUAGE_ID(+) = ? AND C.LANGUAGE_ID(+) = ? AND D.LANGUAGE_ID(+) = ? AND E.LANGUAGE_ID(+) = ? AND F.LANGUAGE_ID(+) = ?") ;
				if(ord_src_type.equals("N")||ord_src_type.equals("D"))
					ord_src_type="N";
				if(ord_src_type.equals("C")||ord_src_type.equals("E"))
					ord_src_type="C";
				pstmt2.setString(1, ord_src_type);
				pstmt2.setString(2, ord_src_type);
				pstmt2.setString(3, ord_src_type);
				pstmt2.setString(4, ord_src_type);
				pstmt2.setString(5, logged_fcy);
				pstmt2.setString(6,getLanguageId());
				pstmt2.setString(7,getLanguageId());
				pstmt2.setString(8,getLanguageId());
				pstmt2.setString(9,getLanguageId());
				pstmt2.setString(10,getLanguageId());
				resultSet2 = pstmt2.executeQuery() ;
				while (resultSet2.next()) {
					disp_code = new HashMap();
					disp_code.put("CODE",resultSet2.getString("RTN_ORD_DISP_LOCN_CODE"));
					disp_code.put("DESC",resultSet2.getString("RTN_ORD_DISP_LOCN_DESC"));
					if(!displocation.contains(disp_code)){
						displocation.add(disp_code);
					}
					disp_code = new HashMap();
					disp_code.put("CODE",resultSet2.getString("STAT_ORD_DISP_LOCN_CODE"));
					disp_code.put("DESC",resultSet2.getString("STAT_ORD_DISP_LOCN_DESC"));
					if(!displocation.contains(disp_code)){
						displocation.add(disp_code);
					}
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;
				closeResultSet( resultSet2 ) ;
				closeStatement( pstmt2 ) ;
				closeConnection( connection );
			}
			catch(Exception es) { es.printStackTrace();}
		}
		return displocation;
	}

	public ArrayList getDespTimings(String order_fcy,String short_desc){
		Connection connection			= null ;
		PreparedStatement pstmt		= null ;
		ResultSet resultSet					= null ;
		ArrayList desptimes				= new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ALT_DISP_LOCN_SELECT1C" )) ;
			pstmt.setString(1, order_fcy);
			pstmt.setString(2, short_desc);
			resultSet = pstmt.executeQuery() ;

			while (resultSet.next()) {
				desptimes.add(resultSet.getString("WORKING_HOURS_FROM"));
				desptimes.add(resultSet.getString("WORKING_HOURS_TO"));
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
			catch(Exception es) { es.printStackTrace();}
		}
		return desptimes;
	}
	public ArrayList getLocns( String order_src_type, String perform_fcy,String Ordering_Facility,String flag ) {
		Connection connection		= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet				= null ;
		ArrayList ordSrcLocns			= new ArrayList();
		altdisp=new ArrayList();
		try {
			connection = getConnection() ;
			if (perform_fcy.equals("") && order_src_type.equals("N")) {
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ALT_DISP_LOCN_SELECT2" )) ;
				pstmt.setString(1, Ordering_Facility.trim());
				pstmt.setString(2, getLanguageId());
			}
			else if (perform_fcy.equals("") && order_src_type.equals("C")) {
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ALT_DISP_LOCN_SELECT3" )) ;
				pstmt.setString(1, Ordering_Facility.trim());
				pstmt.setString(2,getLanguageId());
			}
			else {
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ALT_DISP_LOCN_SELECT4" )) ;
				altdisp=new ArrayList();
				pstmt.setString(1, perform_fcy.trim());
				pstmt.setString(2, order_src_type.trim());
				pstmt.setString(3, getLanguageId());
			}
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				HashMap record	=	new HashMap();
				String code,type,desc;
				code=resultSet.getString("LOCN_CODE");
				ordSrcLocns.add(code);
				if (!perform_fcy.equals("")) {
					type=resultSet.getString("DISP_LOCN_TYPE");
					ordSrcLocns.add(type);
				}
				desc=resultSet.getString("SHORT_DESC");
				ordSrcLocns.add(desc);

				
//				record=null;
				record.put("code",code);
				record.put("desc",desc);
				record.put("totime","");
				record.put("frmtime","");
				record.put("flag","N");
				record.put("eff_status","E");
				record.put("repeat","0");
				altdisp.add(record);
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
				es.printStackTrace();
			}
		}
		if(flag.equals("1"))
		   return ordSrcLocns;
		else
			return altdisp;
	}

	/* Function specific methods end */

	public ArrayList  selectedlocn(String code,String frmtime,String totime,String flag,String eff_status,String repeat){
		int rpt;
		boolean updated = false;
		try	{
			rpt=Integer.parseInt(repeat.trim());
		}
		catch(Exception e){
			rpt=1;
		}
		if(eff_status.equals("D")){
			frmtime="";
			totime="";
		}
		HashMap rec=new HashMap();
		//HashMap recor=new HashMap();
		HashMap new1;
		for (int i=0;i<altdisp.size() ;i++ ){
			rec=(HashMap)altdisp.get((i));
			String code1	=	(String)rec.get("code");
			String repeat1 = (String)rec.get("repeat");
			 //if(code1.equals(code) && (frmtime1.equals("")||totime1.equals("")))
			if(code1.equals(code) && repeat1.equals(repeat)){
				rec.put("flag",flag);
				rec.put("frmtime",frmtime);
				rec.put("totime",totime);
				rec.put("eff_status",eff_status);
				updated = true;
				break;
			}
		}
		if (!updated){	
			new1=new HashMap();
			new1.put("code",code);
			new1.put("desc",rec.get("desc"));
			new1.put("totime",totime);
			new1.put("frmtime",frmtime);
			new1.put("flag","I");
			new1.put("eff_status","E");
			new1.put("repeat",repeat);									
			altdisp.add(new1);	
			new1=null;
		}
		return altdisp;
	}

	public ArrayList getaltdisplocmodify22(String order_src_type, String perform_fcy,String order_fcy,String order_src_code,String day_type,String disp_locn_code,String routlevel, String routcode, String priorit){
		
		Connection connection			= null ;
		PreparedStatement pstmt		= null ;
		ResultSet resultSet					= null ;

		ArrayList altdispres					=new ArrayList();
		HashMap rec							=new HashMap();
		String sql_query="";
		altdisp=new ArrayList();

		if (altdisp != null){
			altdisp.clear();
		}
		altdisp=getLocns(order_src_type,perform_fcy,order_fcy,"");
		try{
			connection	= getConnection() ;
			//sql_query   = PhRepository.getPhKeyValue("SQL_PH_ALT_DISP_LOCN_SELECT9");
			if(!routcode.equals("")){
				sql_query   = "SELECT ALT_DISP_LOCN_CODE,EFF_STATUS,to_char(TIME_FROM,'hh24:mi') TIME_FROM,to_char(TIME_TO,'hh24:mi')TIME_TO  FROM PH_ALT_DISP_LOCN  WHERE ORDERING_FACILITY_ID=? AND  ORDERING_SOURCE_TYPE=?  AND ORDERING_SOURCE_CODE=? AND PERFORMING_FACILITY_ID=? AND DAY_TYPE=? AND DISP_LOCN_CODE=? AND ORD_LEVEL_IND =? AND ROUTING_LEVEL =? AND ROUTING_CODE =?";
				pstmt = connection.prepareStatement(sql_query) ;
				pstmt.setString(1,order_fcy.trim());
				pstmt.setString(2,order_src_type.trim());
				pstmt.setString(3,order_src_code.trim());
				pstmt.setString(4,perform_fcy.trim());
				pstmt.setString(5,day_type.trim());
				pstmt.setString(6,disp_locn_code.trim());
				pstmt.setString(7,priorit.trim());
				pstmt.setString(8,routlevel.trim());
				pstmt.setString(9,routcode.trim());
			}
			else{
				sql_query   = "SELECT ALT_DISP_LOCN_CODE,EFF_STATUS,to_char(TIME_FROM,'hh24:mi') TIME_FROM,to_char(TIME_TO,'hh24:mi')TIME_TO  FROM PH_ALT_DISP_LOCN  WHERE ORDERING_FACILITY_ID=? AND  ORDERING_SOURCE_TYPE=?  AND ORDERING_SOURCE_CODE=? AND PERFORMING_FACILITY_ID=? AND DAY_TYPE=? AND DISP_LOCN_CODE=? AND ORD_LEVEL_IND =? AND ROUTING_LEVEL =?";
				pstmt		= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,order_fcy.trim());
				pstmt.setString(2,order_src_type.trim());
				pstmt.setString(3,order_src_code.trim());
				pstmt.setString(4,perform_fcy.trim());
				pstmt.setString(5,day_type.trim());
				pstmt.setString(6,disp_locn_code.trim());
				pstmt.setString(7,priorit.trim());
				pstmt.setString(8,routlevel.trim());
				//pstmt.setString(9,routcode.trim());
			}
			resultSet			= pstmt.executeQuery();
			while (resultSet.next()) {
				String code2=(String)resultSet.getString("ALT_DISP_LOCN_CODE");
				String status=(String)resultSet.getString("EFF_STATUS");
				String frmtime=(String)resultSet.getString("TIME_FROM");
				String totime=(String)resultSet.getString("TIME_TO");
				altdispres.add(code2);
				altdispres.add(status);
				altdispres.add(frmtime);
				altdispres.add(totime);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
	   
		} 
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}

		for (int i=0;i<altdisp.size() ;i++ ){	
			rec=(HashMap)altdisp.get((i));
			HashMap rec1;
			String code	=	(String)rec.get("code");
			int rep=0;
			try{
				rep=Integer.parseInt((String)rec.get("repeat"));
			}
			catch(Exception e){}
			for(int j=0;j<altdispres.size();j+=4){
				String code1=(String)altdispres.get((j));
				String eff_status=(String)altdispres.get((j+1));
				String frm_time=(String)altdispres.get((j+2));
				String to_time=(String)altdispres.get((j+3));
				
				if(code.equals(code1)){				
					if(rep==0){
						rec.put("flag","I");
						rec.put("eff_status",eff_status);
						rec.put("totime",to_time);
						rec.put("frmtime",frm_time);
						rep++;
					}
					else{		
						rec1=new HashMap();
						rec1.put("code",code);
						rec1.put("desc",rec.get("desc"));
						rec1.put("totime",to_time);
						rec1.put("frmtime",frm_time);
						rec1.put("flag","I");
						rec1.put("eff_status","E");
						rec1.put("repeat",new Integer(rep).toString());
						rep++;
						altdisp.add(i,rec1);
						i++;
						rec1=null;
					}
				}
			}
		}
		return altdisp;
	}

	public ArrayList  getselectedlocn(){
		return altdisp;
	}

	public String getAltDispLocnCode( String order_fcy, String ord_src_type, String order_src_locn ) {
		Connection connection			= null ;
		PreparedStatement pstmt		= null ;
		ResultSet resultSet					= null ;
		String alt_disp_loc_code="";
		 
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ALT_DISP_LOCN_SELECT7" )) ;
			pstmt.setString(1, order_fcy);
			pstmt.setString(2, ord_src_type);
			pstmt.setString(3, order_src_locn);
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				alt_disp_loc_code		= resultSet.getString("RTN_ORD_DISP_LOCN_CODE");
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
			catch(Exception es) { es.printStackTrace();}
		}
		return alt_disp_loc_code;
	}
}
