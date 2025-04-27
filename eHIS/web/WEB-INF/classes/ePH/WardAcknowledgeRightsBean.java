
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
09/05/2017      GHL-SCF-1193  IN064097  SOFIA       RTN_MED_NO is empty when encounterID not there  
01/09/2017      GHL-SCF-1234   65133              	 Drugs are not showing in RETURN MEDICATION screen. 
10/10/2017      GHL-CRF-0466   IN064271    prathyusha   				GHL-CRF-0466(IN064271). 
16/03/2021   IN15664         Manickavasagam J	 	   			COMMON-ICN-0029
---------------------------------------------------------------------------------------------------------------
*/
package ePH;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
//import eCommon.Common.CommonRepository;//commented for GHL-CRF-0466 
//import eCommon.SingleTableHandler.SingleTableHandlerHome;//commented for GHL-CRF-0466 
import ePH.Common.* ;
import eCommon.Common.* ;

public class WardAcknowledgeRightsBean  extends PhAdapter implements Serializable {
	
	private Hashtable recordSet				= new Hashtable();
	//protected String nursing_unit_code="";//commented for GHL-CRF-0466 
	protected String nursing_unit_name="";
	protected String user_id="";
	protected String user_name="";
//	protected String genral_drug_yn="";//commented for GHL-CRF-0466 
//	protected String narcotic_drug_yn="";//commented for GHL-CRF-0466 
//	protected String controlled_drug_yn="";//commented for GHL-CRF-0466 
	String locale= null;
	//ADDED FOR GHL-CRF-0466 START 
	int count=0;
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}//ADDED FOR GHL-CRF-0466 END
	
	/*COMMENTED FOR GHL-CRF-0466 START
	public String getNursing_unit_code() {
		return nursing_unit_code;
	}

	public void setNursing_unit_code(String nursing_unit_code) {
		this.nursing_unit_code = nursing_unit_code;
	} COMMENTED FOR GHL-CRF-0466 END
*/

	public String getNursing_unit_name() {
		return nursing_unit_name;
	}

	public void setNursing_unit_name(String nursing_unit_name) {
		this.nursing_unit_name = nursing_unit_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
/* COMMENTED FOR GHL-CRF-0466 START
	public String getGenral_drug_yn() {
		return genral_drug_yn;
	}

	public void setGenral_drug_yn(String genral_drug_yn) {
		this.genral_drug_yn = genral_drug_yn;
	}

	public String getNarcotic_drug_yn() {
		return narcotic_drug_yn;
	}

	public void setNarcotic_drug_yn(String narcotic_drug_yn) {
		this.narcotic_drug_yn = narcotic_drug_yn;
	}

	public String getControlled_drug_yn() {
		return controlled_drug_yn;
	}

	public void setControlled_drug_yn(String controlled_drug_yn) {
		this.controlled_drug_yn = controlled_drug_yn;
	}  COMMENTED FOR GHL-CRF-0466  END*/

	
	public HashMap validate() throws Exception {// validate method starts here..
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		return map;
	}

	
	public void setAll( Hashtable recordSet ) {
		/* This function also is called by the controller when apply is pressed 
		recordSet is nothing but a hashtable containing all form values
		
		*/
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
/*	COMMENTED FOR GHL-CRF-0466 START	if(recordSet.containsKey("nursing_unit_code"))
			setNursing_unit_code((String)recordSet.get("nursing_unit_code")) ;	COMMENTED FOR GHL-CRF-0466 END */
		if(recordSet.containsKey("nursing_unit"))
			setNursing_unit_name((String)recordSet.get("nursing_unit")) ;
		if(recordSet.containsKey("user_id"))
			setUser_id((String)recordSet.get("user_id")) ;
		if(recordSet.containsKey("user_name"))
			setUser_name((String)recordSet.get("user_name")) ;
	/*	COMMENTED FOR GHL-CRF-0466 START	if(recordSet.containsKey("general_yn"))
			setGenral_drug_yn((String)recordSet.get("general_yn")) ;
		if(recordSet.containsKey("narcotic_yn")) //added for MMS-QH-CRF-0200 [IN:052044] -start
			setNarcotic_drug_yn((String)recordSet.get("narcotic_yn")) ;
		if(recordSet.containsKey("controlled_yn"))
			setControlled_drug_yn((String)recordSet.get("controlled_yn")) ; 
				COMMENTED FOR GHL-CRF-0466 END*/
		this.recordSet = recordSet;
	}
	
	public void clear(){
		super.clear() ;
		if(this.recordSet !=null)
			recordSet.clear();
		
	}

	// insert method  starts here...
		public HashMap insert(){/*
		
		/*COMMENTED FOR GHL-CRF-0466  START
			locale= getLanguageId()==null?"en":getLanguageId();
			StringBuffer debug=new StringBuffer();
			debug.append("INSIDE INSERT");

			HashMap map = new HashMap() ;
			map.put( "result", new Boolean( false ) ) ;		
			
			ArrayList insertData = new ArrayList() ;
			ArrayList whereData = new ArrayList() ;

			try{
				insertData.add( nursing_unit_code ) ;
				//insertData.add( nursing_unit_name ) ;
				insertData.add(	user_id ) ;
				//insertData.add( user_name) ;
				
				if(genral_drug_yn.equals("")){
					insertData.add( "N" ) ;
				}
				else{
					insertData.add( genral_drug_yn ) ;
				}
				if(narcotic_drug_yn.equals("")){
					insertData.add( "N" ) ;
				}
				else{
					insertData.add( narcotic_drug_yn ) ;
				}
				if(controlled_drug_yn.equals("")){
					insertData.add( "N" ) ;
				}
				else{
					insertData.add( controlled_drug_yn ) ;
				}
				//insertData.add( genral_drug_yn ) ;
				//insertData.add( narcotic_drug_yn ) ;
                 //insertData.add( controlled_drug_yn ) ;
                 
				insertData.add( login_by_id ) ;   //added_by_id 
				insertData.add( login_by_id ) ;    //modified_by_id
				insertData.add( login_facility_id ) ; //added_faclilty_id
				insertData.add( login_facility_id ) ;//modified_FACILITY_ID
				insertData.add( login_at_ws_no ) ; // added_at_ws_no
				insertData.add( login_at_ws_no ) ;//modified_at_ws_no
				
				
				whereData.add( nursing_unit_code ) ;
				whereData.add( user_id ) ;
				whereData.add( login_facility_id ) ;//added_faclilty_id

				HashMap tabData = new HashMap() ;
				tabData.put( "properties", getProperties() );
				tabData.put( "InsertData",insertData);
				tabData.put( "WhereData",whereData);

				HashMap sqlMap = new HashMap() ;
				try{
					sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue( "WARD_ACK_COUNT_SELECT" ) );
					sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue( "WARD_ACK_RIGHTS_INSERT") );
				}
				catch(Exception e){
					e.printStackTrace();
				}
		
				//SingleTableHandlerHome home = null;
				//SingleTableHandlerRemote remote = null;
				try {
					debug.append("Before Initial Context");
					InitialContext context = new InitialContext() ;
					Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER")  ) ;
					debug.append("After lookup");
					home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
					remote = home.create() ;
					debug.append("BEfore insert");
					map = remote.insert( tabData, sqlMap ) ;
					debug.append("After Insert");

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

					Object argArray[] = new Object[2];
					argArray[0] = tabData;
					argArray[1] = sqlMap;

					Class [] paramArray = new Class[2];
					paramArray[0] = tabData.getClass(); ;
					paramArray[1] = sqlMap.getClass();

					map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

					System.out.println("map========="+map);
					if( ((Boolean) map.get( "result" )).booleanValue() )
						//map.put( "message", getMessage((String) map.get( "msgid" )) ) ;
						{System.out.println("map====string ===="+(String) map.get( "msgid" ));
						System.out.println("map====string  full===="+getMessage("en",(String) map.get( "msgid" ),"PH") ) ;
						map.put( "message", getMessage(locale,(String) map.get( "msgid" ),"PH") ) ;}
					else{
						if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
							//map.put( "message", getMessage((String) map.get( "msgid" )) ) ;
							map.put( "message", getMessage(locale,(String) map.get( "msgid" ),"Common") ) ;
						else
							map.put( "message", (map.get("msgid"))) ;
					}
				}
				catch(Exception e) {
					map.put( "message", e.getMessage()) ;
					map.put("flag",debug.toString());
					e.printStackTrace() ;
				}
			}
			catch(Exception e){
				map.put( "message", "exp :"+e.getMessage()) ;
				map.put("flag",debug.toString());
				e.printStackTrace() ;
			}
			map.put("flag",debug.toString());
			return map ;		
		*/
		//COMMENTED FOR GHL-CRF-0466 END	
		//ADDED FOR GHL-CRF-0466 START
			locale= getLanguageId()==null?"en":getLanguageId();
			StringBuffer debug=new StringBuffer();
			debug.append("INSIDE INSERT");

			HashMap map = new HashMap() ;
			map.put( "result", new Boolean( false ) ) ;		
			
			//ArrayList insertData = new ArrayList() ;
		//	ArrayList whereData = new ArrayList() ;
		
			Connection connection				  = null;
			PreparedStatement pstmt             = null ;
			ResultSet resultSet				      = null ;
			String genral_drug_yn="";
			 String narcotic_drug_yn="";
			 String controlled_drug_yn="";
			  String nursing_unit_code="";
			  PreparedStatement delete             = null ;
			  int count=0;
			try{
				connection				= getConnection() ;
				delete			= connection.prepareStatement(PhRepository.getPhKeyValue( "WARD_ACK_RIGHTS_DELETE")); 
				delete.setString(1,login_facility_id.trim());
				delete.setString(2, user_id);
				//delete.setString(3, nursing_unit_code.trim());
				int deleted=delete.executeUpdate();
				if(deleted>0){
					connection.commit();
					map.put( "result", new Boolean( true ) ) ;
					map.put( "message", getMessage(locale.trim(),"RECORD_INSERTED","PH") ) ;
				}	
				count=(Integer.parseInt((String) recordSet.get("count")));
				pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue( "WARD_ACK_RIGHTS_INSERT") );
				
				if(((String)recordSet.get("select_all_yn")).equals("Y")){
					
					pstmt.setString(1,"*A");
					pstmt.setString(2,	user_id);
					pstmt.setString(3,"Y");
					pstmt.setString(4,"Y");
					pstmt.setString(5,"Y");
					pstmt.setString(6,login_by_id);
					pstmt.setString(7,login_by_id);
					//pstmt.setString(8,this.encounter_id);
					pstmt.setString(8,login_facility_id);
					pstmt.setString(9,login_facility_id);
					pstmt.setString(10,login_at_ws_no);
					pstmt.setString(11,login_at_ws_no);
					int insert=pstmt.executeUpdate();
					if(insert>0){
						connection.commit();
						map.put( "result", new Boolean( true ) ) ;
						map.put( "message", getMessage(locale.trim(),"RECORD_INSERTED","PH") ) ;
					}	
				
				}
				else{
				for(int i=0;i<=count;i++){
				
					
				  genral_drug_yn="general_yn_"+i;
				  narcotic_drug_yn="narcotic_yn_"+i;
				  controlled_drug_yn="controlled_yn_"+i;
				   nursing_unit_code="code_"+i;
				//if(((String)recordSet.get(genral_drug_yn)).equals("Y") || ((String)recordSet.get(narcotic_drug_yn)).equals("Y") || ((String)recordSet.get(controlled_drug_yn)).equals("Y")){
				   pstmt.setString(1,(String)recordSet.get(nursing_unit_code));
				    pstmt.setString(2,	user_id);
				   if(!((String)recordSet.get(genral_drug_yn)).equals("Y")){
						//insertData.add( "N" ) ;
					   pstmt.setString(3,"N");
					}
					else{
						 pstmt.setString(3,"Y");
					}
				   if(!((String)recordSet.get(narcotic_drug_yn)).equals("Y")){
						//insertData.add( "N" ) ;
					   pstmt.setString(4,"N");
					}
					else{
						  pstmt.setString(4,"Y");
					}
				   if(!((String)recordSet.get(controlled_drug_yn)).equals("Y")){
					   pstmt.setString(5,"N");
					}
					else{
						  pstmt.setString(5,"Y");
					}
				pstmt.setString(6,login_by_id);
				pstmt.setString(7,login_by_id);
				//pstmt.setString(8,this.encounter_id);
				pstmt.setString(8,login_facility_id);
				pstmt.setString(9,login_facility_id);
				pstmt.setString(10,login_at_ws_no);
				pstmt.setString(11,login_at_ws_no);
			
				pstmt.addBatch();
				//}
				}
				int[] rowsInserted			= pstmt.executeBatch();
				boolean wardRetStatus = true;
				for (int iC=0; iC<rowsInserted.length; iC++) {
					if ( rowsInserted[iC] < 0 && rowsInserted[iC] != -2) {
						connection.rollback();
						wardRetStatus = false;
						break;
					}
				}
			
				connection.commit();   
				map.put( "result", new Boolean( true ) ) ;	
				map.put( "message", getMessage(locale,"RECORD_INSERTED","PH") ) ;	
			}
				
				
				
			
			}
			catch(Exception e){
				map.put( "message", "exp :"+e.getMessage()) ;
				map.put("flag",debug.toString());
				e.printStackTrace() ;
			}
			finally {
				try {
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeStatement( delete ) ;
					
					closeConnection( connection );
				}
				catch(Exception es) { 
					es.printStackTrace() ;
				}
			}
			
			map.put("flag",debug.toString());
			return map ;		
// ADDED FOR GHL-CRF-0466 END 
		
		}
		/* This  function is called when delete is pressed */
		public HashMap delete() {
			locale= getLanguageId()==null?"en":getLanguageId();
			HashMap map = new HashMap() ;
			map.put( "result", new Boolean( false ) ) ;
			Connection connection				  = null;
			PreparedStatement delete             = null ;
			try{
				connection		= getConnection() ;
				delete			= connection.prepareStatement(PhRepository.getPhKeyValue( "WARD_ACK_RIGHTS_DELETE")); 
				delete.setString(1,login_facility_id.trim());
				delete.setString(2, user_id.trim());
				//delete.setString(3, nursing_unit_code.trim());// COMMENTED FOR GHL-CRF-0466
				int deleted=delete.executeUpdate();
				if(deleted>0){
					connection.commit();
					map.put( "result", new Boolean( true ) ) ;
					map.put( "message", getMessage(locale.trim(),"RECORD_INSERTED","PH") ) ;
				}				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
					try {
						connection.rollback();
						delete.close();
						closeConnection( connection );//common-icn-0029
					}
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
			return map ;	
			
		}
		
		
		public ArrayList getAckrights(String userId,String nursingUnit){
			Connection connection	= null;
	        PreparedStatement pstmt	= null;
	        ResultSet resultSet		= null;
		    ArrayList result=new ArrayList();
			StringBuffer sql						 = new StringBuffer();
		  
	        try {
	            connection = getConnection() ;
				//	To get the dispense locations associated with the user
				sql.append(PhRepository.getPhKeyValue("WARD_ACK_RIGHTS_SELECT"));
				
				pstmt= connection.prepareStatement(  sql.toString()) ;
				pstmt.setString(1,login_facility_id);
				pstmt.setString(2,userId);
				pstmt.setString(3,nursingUnit);

	            resultSet = pstmt.executeQuery() ;
	            while ( resultSet.next() ) {
	            	
					result.add(resultSet.getString("genral_drug_yn"));
					result.add(resultSet.getString("narcotic_drug_yn"));
					result.add(resultSet.getString("controlled_drug_yn"));
				}
			}
			catch ( Exception e ) {
				result.add(e.toString());
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
			return result;
		}
		
		/*	COMMENTED FOR GHL-CRF-0466 START  public HashMap modify() {
			locale= getLanguageId()==null?"en":getLanguageId();
			StringBuffer debug=new StringBuffer();
			//debug.append("INSIDE MODIFY//");
           System.out.println("in modify");
			HashMap map = new HashMap() ;
			map.put( "result", new Boolean( false ) ) ;		
			try{
				ArrayList insertRow = new ArrayList() ;
				
				
				//insertData.add( nursing_unit_name ) ;
				
				//insertData.add( user_name) ;
				 if(genral_drug_yn.equals("")){
						insertRow.add( "N" ) ;
					}
					else{
						insertRow.add( genral_drug_yn ) ;
					}
					if(narcotic_drug_yn.equals("")){
						insertRow.add( "N" ) ;
					}
					else{
						insertRow.add( narcotic_drug_yn ) ;
					}
					if(controlled_drug_yn.equals("")){
						insertRow.add( "N" ) ;
					}
					else{
						insertRow.add( controlled_drug_yn ) ;
					}
				//insertRow.add( genral_drug_yn ) ;
				//insertRow.add( narcotic_drug_yn ) ;
				//insertRow.add( controlled_drug_yn ) ;
				insertRow.add( login_facility_id ) ; 
				insertRow.add(	user_id ) ;
				insertRow.add( nursing_unit_code ) ;
				

				HashMap tabData = new HashMap() ;
				tabData.put("properties", getProperties() );
				tabData.put( "ModifyData",insertRow);

				HashMap sqlMap = new HashMap() ;
				sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue( "WARD_ACK_RIGHTS_UPDATE" ) );
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;
				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); 
				paramArray[1] = sqlMap.getClass();

				map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", getMessage((String) map.get( "msgid" )) ) ;
					map.put( "message", getMessage(locale,(String) map.get( "msgid" ),"PH") ) ;
				}
				else{
					if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
						map.put( "message", getMessage(locale,(String) map.get( "msgid" ),"Common") ) ;
					else{
						//debug.append("Inside else result fails here ejb call modify()//"+((Boolean) map.get( "result" )).booleanValue()+"//messageid//"+(map.get("msgid")) );
						map.put( "message", (map.get("msgid"))) ;
					}
				}
			}//try
			catch(Exception e) {
				map.put( "message", e.getMessage()) ;
				map.put("flag",debug.toString());
				e.printStackTrace() ;
			}
			map.put("flag",debug.toString());
				return map ;		
		} COMMENTED FOR GHL-CRF-0466 END*/
		// ADDED FOR GHL-CRF-0466
		public HashMap nursingAckRights(String locale, String user_id){             
			ArrayList result=new ArrayList();
			Connection connection       = null ;
			PreparedStatement pstmt     = null ;     
			ResultSet resultSet         = null ;
			int count=0;
			int gen_YN_cnt=0;
			int cnt_YN_cnt=0;
			int nar_YN_cnt=0;
			int gen_YN_cnt_indvl=0;
			int cnt_YN_cnt_indvl=0;
			int nar_YN_cnt_indvl=0;
			int gen_count=0;
	     	int nar_count=0;
	     	int con_count=0;
			HashMap map = new HashMap() ;
			try{
				connection		= getConnection() ;
				
				
				pstmt	   = connection.prepareStatement(PhRepository.getPhKeyValue("PH_WARD_ACK_RIGHTS_ALL"));
				pstmt.setString(1,user_id);
				pstmt.setString(2,login_facility_id);
				   resultSet = pstmt.executeQuery() ;
				
				   if ( resultSet!=null && resultSet.next()) {
					 
					 closeResultSet( resultSet ); //common-icn-0029
					 closeStatement( pstmt ) ; //common-icn-0029
		   			 
					   pstmt	   = connection.prepareStatement(PhRepository.getPhKeyValue("PH_WARD_ACK_RIGHTS_NURSING_UNIT"));
				   
					   pstmt.setString(1,login_facility_id);
					   resultSet = pstmt.executeQuery() ;
					   while ( resultSet!=null && resultSet.next() ) {

		            		result.add(checkForNull(resultSet.getString("NURSING_UNIT_CODE")));//0
		            		result.add(checkForNull(resultSet.getString("SHORT_DESC")));//1
		            		
		            		result.add("Y");//2
		            		
		            		result.add("Y");//3
		            		
		            		result.add("Y");//4
		            
		            	   result.add(1);//5
		            		
		            	}
					     	count=1;
					     	gen_count=1;
					     	nar_count=1;
					     	con_count=1;
					     	
	        					   }
				
				   else{  
					   pstmt	   = connection.prepareStatement(PhRepository.getPhKeyValue("PH_WARD_ACK_RIGHTS_SELECT_NUNIT"));
				//pstmt	   = connection.prepareStatement("select  distinct a.NURSING_UNIT_CODE,B.GENRAL_DRUG_YN,B.NARCOTIC_DRUG_YN,B.CONTROLLED_DRUG_YN,a.SHORT_DESC from (SELECT   nursing_unit_code  ,short_desc FROM ip_nursing_unit_lang_vw  WHERE eff_status = 'E' and language_id = ? AND facility_id = ? UNION  all select  NURSING_UNIT_CODE, null short_desc FROM ph_ward_ack_rights WHERE added_facility_id = ? AND user_id = ?) a, ph_ward_ack_rights b where a.NURSING_UNIT_CODE = b.NURSING_UNIT_CODE(+) and a.SHORT_DESC is not null");
				//	pstmt	   = connection.prepareStatement("SELECT NURSING_UNIT_CODE FROM ph_ward_ack_rights WHERE added_facility_id = ? AND user_id = ?") ;
				pstmt.setString(1,locale);
				pstmt.setString(2,login_facility_id);
				pstmt.setString(3,login_facility_id);
				pstmt.setString(4,user_id);
				pstmt.setString(5,login_facility_id);
				pstmt.setString(6,locale);
				pstmt.setString(7,login_facility_id);
				pstmt.setString(8,user_id);
				
	            resultSet = pstmt.executeQuery() ;
	            
	            while ( resultSet!=null && resultSet.next() ) {
	            		result.add(checkForNull(resultSet.getString("NURSING_UNIT_CODE")));//0
	            		result.add(checkForNull(resultSet.getString("SHORT_DESC")));//1
	            		
	            		result.add(checkForNull(resultSet.getString("GENRAL_DRUG_YN")));//2
	            		
	            		result.add(checkForNull(resultSet.getString("NARCOTIC_DRUG_YN")));//3
	            		
	            		result.add(checkForNull(resultSet.getString("CONTROLLED_DRUG_YN")));//4
	            		if(checkForNull(resultSet.getString("GENRAL_DRUG_YN")).equalsIgnoreCase("Y")){
	            		
	            			gen_YN_cnt++;
	            			gen_YN_cnt_indvl=1;
	            		}
	            		if(checkForNull(resultSet.getString("NARCOTIC_DRUG_YN")).equalsIgnoreCase("Y")){
	            			cnt_YN_cnt_indvl=1;
	            			cnt_YN_cnt++;
	            		}
	            		if(checkForNull(resultSet.getString("NARCOTIC_DRUG_YN")).equalsIgnoreCase("Y")){
	            			nar_YN_cnt_indvl=1;
	            			nar_YN_cnt++;
		            	}
	            		
	            		if(gen_YN_cnt_indvl==1 && cnt_YN_cnt_indvl == 1 && nar_YN_cnt_indvl==1  ){
	            			
	            			result.add(1);//5
	            		}
	    	            else{
	    	            	result.add(0);//5
	    	            }
	            		
	            		
	            		 gen_YN_cnt_indvl=0;
	        			 cnt_YN_cnt_indvl=0;
	        			 nar_YN_cnt_indvl=0;
	        			 count++;
	          
	            }	
	       
	            if(gen_YN_cnt == count  ){
        			
	            	gen_count=1;
	        			
	        		}
		            else{
		            	gen_count=0;
		            }
	            if(cnt_YN_cnt == count  ){
       			
	            	con_count=1;
	        			
	        		}
		            else{
		            	con_count=0;
		            }
	            if( nar_YN_cnt == count ){
       			
	            	nar_count=1;
	        			
	        		}
		            else{
		            	nar_count=0;
		            }
	            if(gen_YN_cnt == count  && cnt_YN_cnt == count && nar_YN_cnt == count ){
        			
        		 count=1;
        			
        		}
	            else{
	            	count=0;
	            }
	            
	            
	            
			}
	            
	            map.put("result", result);
	            map.put("count", count);
	            map.put("genral_count", gen_count);
	            map.put("narcotic_count", nar_count);
	            map.put("contr_count", con_count);
	           
	          //  System.err.println("result===>"+result);
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
					es.printStackTrace();
				}
			}
			
			return map;
		}
		//GHL-CRF-0466 end

}
