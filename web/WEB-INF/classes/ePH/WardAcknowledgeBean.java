

/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
09/05/2017      GHL-SCF-1193  IN064097  SOFIA       RTN_MED_NO is empty when encounterID not there  
01/09/2017      GHL-SCF-1234   65133              	 Drugs are not showing in RETURN MEDICATION screen. 
10/10/2017      GHL-CRF-0466   IN064271    prathyusha   				GHL-CRF-0466(IN064271). 
28/01/2021	  	TFS:12662	        	Manickavasagam J  											MMS-KH-CRF-0039
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
import java.util.Map;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import ePH.Common.PhAdapter;
import ePH.Common.PhRepository;

public class WardAcknowledgeBean  extends PhAdapter implements Serializable {
	
	private Hashtable recordSet				= new Hashtable();
	private String order_type		        = ""; //MMS-KH-CRF-0039
	HashMap<String, Object> commonStoreMap = new HashMap<String, Object>();
	public HashMap<String, Object> getCommonStoreMap() {
		return commonStoreMap;
	}

	public void setCommonStoreMap(HashMap<String, Object> commonStoreMap) {
		this.commonStoreMap = commonStoreMap;
	}
	public void setAll( Hashtable recordSet ) {
		/* This function also is called by the controller when apply is pressed 
		recordSet is nothing but a hashtable containing all form values
		
		*/
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
		this.recordSet = recordSet;
	}
	//MMS-KH-CRF-0039 - start
	public void setOrderType(String order_type){
	  this.order_type = order_type;
	}
	public String getOrderType() {
		return order_type;
	}
	//MMS-KH-CRF-0039 - end
	public void clear(){
		super.clear() ;
		//this.disp_locn_code	= "";
		//this.encounter_id	= "";
		order_type = "";	//MMS-KH-CRF-0039
		if(this.recordSet !=null)
			recordSet.clear();
			commonStoreMap.clear();
	}

	/*
	 * 
	 */
	/*public String getSysdate(){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sys_date				= "";
		try{
			connection				= getConnection() ;
			String str_qry			= "SELECT to_char(SYSDATE,'dd/mm/yyyy hh:mm') SYS_DATE from dual";
			pstmt					= connection.prepareStatement(str_qry) ;
			resultSet				= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
						sys_date	=	resultSet.getString("SYS_DATE");
				}
		}catch ( Exception e ) {
				sys_date+=e.toString();
                e.printStackTrace() ;

		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
        }
		return sys_date;
	}*/
	public ArrayList getFrom_and_To_date() {
		ArrayList from_and_to_date=new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
		//31 is changed to 1 for GHL-CRF-0451
			pstmt = connection.prepareStatement( "select to_char(sysdate,'dd/mm/yyyy hh24:mi')to_day,to_char(sysdate-1,'dd/mm/yyyy hh24:mi')from_day  from dual") ;
			
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					from_and_to_date.add(resultSet.getString( "to_day" ));
					from_and_to_date.add(resultSet.getString("from_day"));
					
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
				closeConnection( connection );
			}
			catch(Exception es) {es.printStackTrace();}
		}

		return from_and_to_date;
	}
	public ArrayList getPatientDetails(String patientid){
        Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		 ArrayList result		= new ArrayList();
        try {
            connection = getConnection() ;

			String sql=PhRepository.getPhKeyValue("SQL_PH_RET_MEDN_SELECT8") ;
			pstmt = connection.prepareStatement( sql) ;
			pstmt.setString(1,getLanguageId());
			pstmt.setString(2,patientid);
            resultSet = pstmt.executeQuery() ;
            while ( resultSet.next() ) {
				result.add(resultSet.getString("PATIENT_NAME"));
				result.add(resultSet.getString("SEX"));
				result.add(resultSet.getString("AGE"));
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
				es.printStackTrace() ;
			}
		}
		return result;
	}
	public String getPatientIDLength(){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	pat_txt_length	=	null ;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_COMMON_SELECT1") ) ;
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				pat_txt_length	=	checkForNull(resultSet.getString("PATIENT_ID_LENGTH"));
			}						
		}
		catch(Exception e){
			pat_txt_length	=e.toString();
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
		return pat_txt_length;	
	}
	
	public ArrayList<String> getWardAcknowledgeDetails(String sql,String local,String patientId,String dispNo,String facilityId,String srlNo,String order_type,String disp_locn_code){
	//order_type,disp_locn_code added MMS-KH-CRF-0039
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
        System.out.println("batchDetails In bean");
		 ArrayList<String> result		= new ArrayList<String>();
		 try {	
			
			connection = getConnection() ;
			
			int cnt	=	1;
        	pstmt = connection.prepareStatement( sql) ;
			//MMS-KH-CRF-0039 - start
			if(order_type!=null && order_type.equals("A")){
				pstmt.setString(cnt,facilityId);
				pstmt.setString(++cnt,disp_locn_code);
				pstmt.setString(++cnt,dispNo);
			
			}else{ //MMS-KH-CRF-0039- end
				pstmt.setString(cnt,local);
				pstmt.setString(++cnt,local);
				pstmt.setString(++cnt,patientId);
				pstmt.setString(++cnt,facilityId);
				pstmt.setString(++cnt,dispNo);
				pstmt.setString(++cnt,"IP");
				pstmt.setString(++cnt,srlNo);			
			}	
			
            resultSet = pstmt.executeQuery() ;
          
            while ( resultSet.next() ) {
				result.add(resultSet.getString("DRUG_DESC"));//	1	
				result.add(resultSet.getString("ORDER_QTY"));	//2
				result.add(resultSet.getString("issue_uom_desc"));//3
				result.add(resultSet.getString("DISPENSEDQTY"));	//4
				result.add(resultSet.getString("DESPED_UOM_DESC"));//5
				result.add(resultSet.getString("EXPIRY_DATE"));//6
				result.add(resultSet.getString("BATCH_ID"));//7
				result.add(resultSet.getString("MODIFIED_DATE"));//8
				result.add(resultSet.getString("ORDER_ID"));//9    //Added for GHL-CRF-0451
				
			}
		}
		catch ( Exception e ) {
			e.printStackTrace();
			result.add(e.toString());
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
		
		return result;
	}
	
	public HashMap modify(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println(recordSet);
//		Set<Entry<String, Object>> dispNos=getCommonStoreMap().entrySet();  Removed for IN063877
		String key=null;
		ArrayList insertRow				= new ArrayList();
		//MMS-KH-CRF-0039 - start
		Connection con=null;
		PreparedStatement pstmt1 = null;
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt_update_or_order_line	=	null; 
		PreparedStatement pstmt_update_or_order	=	null; 
		boolean successFlag = false;
		String worksheet_id = "";
		try{
		con = getConnection();
		pstmt1 =  con.prepareStatement("select ORDER_LINE_NUM,ORDER_LINE_STATUS  from OR_ORDER_LINE WHERE ORDER_ID=? AND ORDER_CATEGORY='PH' ");
		pstmt2 = con.prepareStatement("UPDATE PH_WORKSHEET_HDR A SET A.WARD_ACKNOWLEDGE='A',A.ACK_MODIFIED_DATE = SYSDATE,A.ACKNOWLEDGE_BY_ID = '"+login_by_id+"' WHERE WORKSHEET_ID = ? AND FACILITY_ID=? and ORDER_ID=?");

		//MMS-KH-CRF-0039 - end
		for(Map.Entry entry: getCommonStoreMap().entrySet()){
           
                key = (String)entry.getKey();
                StringTokenizer st=new StringTokenizer(key,"_");
                String dispno =""; // Added for MMS-KH-CRF-0014 [IN:067953] - Start
                String srlNo="";
                String orderlineNo = "";
                String orderStatus = "";
                String orderId = "";
                if(st.countTokens()>4){
               	    dispno=st.nextToken();
                    srlNo=st.nextToken();
                    orderId    = st.nextToken();
                    orderlineNo = st.nextToken(); 
                    orderStatus = st.nextToken();     
					insertRow.add(dispno);
					insertRow.add(srlNo);
					insertRow.add(orderId);
					insertRow.add(orderStatus);
					insertRow.add(orderlineNo);  // Added for MMS-KH-CRF-0014 [IN:067953] - End
                }else{  //MMS-KH-CRF-0039 - start
					 if(st.countTokens()==2){
						orderId    = st.nextToken();
						worksheet_id = st.nextToken();
						pstmt1.setString(1,orderId);
						resultSet = pstmt1.executeQuery() ;
				
					   while ( resultSet!=null && resultSet.next()){
							
							orderStatus = resultSet.getString("order_line_status");
							if(orderStatus.trim().equals("DF")){
								orderStatus = "DE";
							}
							else if(orderStatus.trim().equals("DP")){
								orderStatus = "DD";
							}
							insertRow.add(worksheet_id);
							insertRow.add("1");
							insertRow.add(orderId);
							insertRow.add(orderStatus);
							insertRow.add(resultSet.getString("order_line_num"));  
					   }
					   closeResultSet( resultSet ) ;
					 }
				}                 
		}
		if(getOrderType()!=null && getOrderType().equals("A")){
			StringTokenizer st =null;
			String orderId = "";
			
			//boolean update_flag = false; //Commented for common-icn-0048
			for(Map.Entry entry: getCommonStoreMap().entrySet()){
			   
					key = (String)entry.getKey();
					st=new StringTokenizer(key,"_");
					if(st.countTokens()==2){
						orderId    = st.nextToken();
						worksheet_id = st.nextToken();
						successFlag = true;						
						pstmt2.setString(1,worksheet_id);
						pstmt2.setString(2,login_facility_id);
						pstmt2.setString(3,orderId);
						pstmt2.addBatch();
					}
			}
			if(successFlag){
			int result[] = pstmt2.executeBatch();
			for (int i=0;i<result.length ;i++ ){
				if(result[i]<0  && result[i] != -2 ){
					successFlag = false; 
					pstmt2.cancel();
					closeStatement(pstmt2);
					con.rollback();
					map.put( "result", new Boolean( false ) ) ;	
					map.put( "message", "ERROR While updating the record in PH_WORKSHEET_HDR") ;
					}		
				}
		}
		}
//MMS-KH-CRF-0039 - end		
		//int tot_rec=Integer.parseInt((String)recordSet.get("total_count"));
		//ArrayList insertRow				= new ArrayList();
		
	
		/*for(int i=0;i<tot_rec;i++){
			if (((String)recordSet.get("chk_"+ i)).trim().equals("Y")){
				insertRow.add(recordSet.get("dispno"+i));
				insertRow.add(recordSet.get("orderId"+i));
				insertRow.add(recordSet.get("srlNo"+i));
			}
		}*/
		
		//pstmt = con.prepareStatement("UPDATE PH_DISP_DRUG_BATCH A SET A.WARD_ACKNOWLEDGE='A',A.MODIFIED_DATE = SYSDATE WHERE DISP_NO = ? AND FACILITY_ID=?");
		System.err.println("loginid"+login_by_id);
		pstmt = con.prepareStatement("UPDATE PH_DISP_DRUG_BATCH A SET A.WARD_ACKNOWLEDGE='A',A.ACK_MODIFIED_DATE = SYSDATE,A.ACKNOWLEDGE_BY_ID = '"+login_by_id+"' WHERE DISP_NO = ? AND FACILITY_ID=? and SRL_NO=?");
		pstmt_update_or_order_line = con.prepareStatement("UPDATE OR_ORDER_LINE SET ORDER_LINE_STATUS = ? WHERE ORDER_ID=? AND ORDER_LINE_NUM =?"); // Added for MMS-KH-CRF-0014 [IN:067953]
		pstmt_update_or_order = con.prepareStatement("UPDATE OR_ORDER SET ORDER_STATUS = ? WHERE ORDER_ID=?"); // Added for MMS-KH-CRF-0014 [IN:067953]
		/*if(insertRow.size()>0){
			for(int j=0;j<insertRow.size();j+=2){
				pstmt.setString(1,(String) insertRow.get(j));
				pstmt.setString(2,login_facility_id);
				pstmt.addBatch();
				successFlag = true;
			}*/
			if(insertRow.size()>0){
			for(int j=0;j<insertRow.size();j+=5){ // 2 changed to 5 for MMS-KH-CRF-0014 [IN:067953]				

				if(getOrderType()!=null && !getOrderType().equals("A")){ //MMS-KH-CRF-0039
					pstmt.setString(1,(String) insertRow.get(j));
					pstmt.setString(2,login_facility_id);
					pstmt.setString(3,(String)insertRow.get(j+1));
				}
				pstmt_update_or_order_line.setString(1, (String)insertRow.get(j+3)); // Added for MMS-KH-CRF-0014 [IN:067953] - Start
				pstmt_update_or_order_line.setString(2, (String)insertRow.get(j+2)); // order_id
				pstmt_update_or_order_line.setString(3, (String)insertRow.get(j+4)); // line_no
				pstmt_update_or_order.setString(1, (String)insertRow.get(j+3)); 
				pstmt_update_or_order.setString(2, (String)insertRow.get(j+2));// Added for MMS-KH-CRF-0014 [IN:067953] - End
				if(getOrderType()!=null && !getOrderType().equals("A")){ //MMS-KH-CRF-0039
					pstmt.addBatch();
				}
				pstmt_update_or_order_line.addBatch(); // Added for MMS-KH-CRF-0014 [IN:067953]
				pstmt_update_or_order.addBatch(); // Added for MMS-KH-CRF-0014 [IN:067953]
				
				successFlag = true;
			}
			if(getOrderType()!=null && !getOrderType().equals("A")){ //MMS-KH-CRF-0039
			if(pstmt!=null){ // if condition Added for MMS-KH-CRF-0014 [IN:067953]
			int result[] = pstmt.executeBatch();
			for (int i=0;i<result.length ;i++ ){
				// A number greater than or equal to zero  indicates success
				// A number -2 indicates that command is successful but number of rows updated is unknow
				// If it won't satisfy any of the above cancel the statement and throw an exception
				if(result[i]<0  && result[i] != -2 ){
						successFlag = false; // Added for MMS-KH-CRF-0014
					pstmt.cancel();
					closeStatement(pstmt);
					con.rollback();
					map.put( "result", new Boolean( false ) ) ;	
					map.put( "message", "ERROR While updating the record in PH_DISP_DRUG_BATCH") ;
					}		
				}
			 }			
			}
			if(pstmt_update_or_order_line!=null){ 
				int result[] = pstmt_update_or_order_line.executeBatch();
				for (int i=0;i<result.length ;i++ ){ 
					if(result[i]<0  && result[i] != -2 ){
						successFlag = false;
						pstmt.cancel();
						closeStatement(pstmt_update_or_order_line);
						con.rollback();
						map.put( "result", new Boolean( false ) ) ;	
						map.put( "message", "ERROR While updating the record in OR_ORDER_LINE") ;
					}		
				}
			}
			if(pstmt_update_or_order!=null){ 
				int result[] = pstmt_update_or_order.executeBatch();
				for (int i=0;i<result.length ;i++ ){ 
					if(result[i]<0  && result[i] != -2 ){
						successFlag = false;
						pstmt.cancel();
						closeStatement(pstmt_update_or_order);
						con.rollback();
						map.put( "result", new Boolean( false ) ) ;	
						map.put( "message", "ERROR While updating the record in OR_ORDER") ;
					}		
				}		
			}
		}else{
			map.put( "result", new Boolean( false ) ) ;	
			map.put( "message", getMessage(getLanguageId(),"PH_REASON_ONE_SELECTED","PH") ) ;
		}
		if(successFlag){
			con.commit();
		map.put( "result", new Boolean( true ) ) ;	
		map.put( "message", getMessage(getLanguageId(),"RECORD_INSERTED","PH") ) ;
		}
		}catch (Exception e) {
			e.printStackTrace();
			map.put( "result", new Boolean( false ) ) ;	
			map.put( "message", "ERROR While updating the record in PH_DISP_DRUG_BATCH"+e.getMessage() ) ;
		}finally{
			try{
			con.close();
			pstmt.close();
			closeStatement(pstmt);
			closeStatement(pstmt1); //common-icn-0029
			closeStatement(pstmt2);//common-icn-0029
			closeStatement(pstmt_update_or_order_line);
			closeStatement(pstmt_update_or_order);
			}catch (Exception eclose) {
				// TODO: handle exception
				eclose.printStackTrace();
			}
		}
		
		return map;
	}
	
	 //added for GHL-CRF-0466 start
	public String getAckRightsDetails(String userid){
        Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
        String status=null;
		
        try {
        	  connection		= getConnection() ;
				
				
				pstmt	   = connection.prepareStatement(PhRepository.getPhKeyValue("PH_WARD_ACK_RIGHTS_ALL"));
				pstmt.setString(1,userid);
				pstmt.setString(2,login_facility_id);
				   resultSet = pstmt.executeQuery() ;
			
				   if ( resultSet!=null && resultSet.next()) {
					   status="Y";
				
			}
				   else{
					   status="N";
				   }
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			//result.add(e.toString());
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
		return status;
	}// //added for GHL-CRF-0466 end
	//ADDED FOR MMS-KH-CRF-0014 START
	public String checkToProceed(String facility_id) {
	    	String result		= "";
			Connection connection	= null;
			PreparedStatement pstmt	= null;
			ResultSet resultSet		= null;
			try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_WRD_ACK_APPLICABLE_YN") ) ;
				pstmt.setString(1,facility_id.trim());
				resultSet = pstmt.executeQuery() ;
				if ( resultSet.next() ) {
					//result=resultSet.getString("WARD_ACK_REQUIRED_YN");
					result=resultSet.getString("WARD_ACK_REQUIRED_YN")==null?"N":resultSet.getString("WARD_ACK_REQUIRED_YN");
					}
					closeStatement(pstmt);
				closeResultSet(resultSet);
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
				catch(Exception es) { es.printStackTrace();
			}
				}
	
			return result;
	}
	//ADDED FOR MMS-KH-CRF-0014 END
}
