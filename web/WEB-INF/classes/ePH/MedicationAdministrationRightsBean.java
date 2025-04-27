
/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name		Rev.Date   	Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------

28/11/2019        IN059899        PRATHYUSHA                          JD-CRF-0200
-------------------------------------------------------------------------------------------------------------------------------
*/

package ePH;

import java.util.ArrayList;
import java.sql.Connection;
import eCommon.SingleTableHandler.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Hashtable;

import ePH.Common.PhAdapter;
import ePH.Common.PhRepository;
import eSS.Common.SsTransaction;
import eSS.Common.SsRepository;
import eCommon.Common.CommonRepository;
import java.util.Properties;
import eSS.UserAccessForStore.*;
import java.io.Serializable;


public class MedicationAdministrationRightsBean  extends PhAdapter implements Serializable{

	private Hashtable recordSet				= new Hashtable();
	protected String	locale="";
	protected String user_id="";
	protected String Admin_yn="";
	protected String self_admin_yn="";
	protected String hold_yn="";
	protected String could_not_admin_yn="";
	protected String discontinue_yn="";
	protected String cancel_admin_yn="";
	
	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getAdmin_yn() {
		return Admin_yn;
	}


	public void setAdmin_yn(String admin_yn) {
		Admin_yn = admin_yn;
	}


	public String getSelf_admin_yn() {
		return self_admin_yn;
	}


	public void setSelf_admin_yn(String self_admin_yn) {
		this.self_admin_yn = self_admin_yn;
	}


	public String getHold_yn() {
		return hold_yn;
	}


	public void setHold_yn(String hold_yn) {
		this.hold_yn = hold_yn;
	}


	public String getCould_not_admin_yn() {
		return could_not_admin_yn;
	}


	public void setCould_not_admin_yn(String could_not_admin_yn) {
		this.could_not_admin_yn = could_not_admin_yn;
	}


	public String getDiscontinue_yn() {
		return discontinue_yn;
	}


	public void setDiscontinue_yn(String discontinue_yn) {
		this.discontinue_yn = discontinue_yn;
	}


	public String getCancel_admin_yn() {
		return cancel_admin_yn;
	}


	public void setCancel_admin_yn(String cancel_admin_yn) {
		this.cancel_admin_yn = cancel_admin_yn;
	}


	public MedicationAdministrationRightsBean() {
		

	}


	public void setAll( Hashtable recordSet ) {
		/* This function also is called by the controller when apply is pressed 
		recordSet is nothing but a hashtable containing all form values
		
		*/
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
/*	COMMENTED FOR GHL-CRF-0466 START	if(recordSet.containsKey("nursing_unit_code"))
			setNursing_unit_code((String)recordSet.get("nursing_unit_code")) ;	COMMENTED FOR GHL-CRF-0466 END */
		
		if(recordSet.containsKey("user_id"))
			setUser_id((String)recordSet.get("user_id")) ;
		if(recordSet.containsKey("admin"))
			setAdmin_yn((String)recordSet.get("admin")) ;
		if(recordSet.containsKey("self_admin"))
			setSelf_admin_yn((String)recordSet.get("self_admin")) ;
		if(recordSet.containsKey("hold"))
			setHold_yn((String)recordSet.get("hold")) ;
		if(recordSet.containsKey("cancel_admin"))
			{
			setCancel_admin_yn((String)recordSet.get("cancel_admin")) ;
			if(cancel_admin_yn == null || cancel_admin_yn == "")
				cancel_admin_yn="N";
			}
		if(recordSet.containsKey("could_not_admin"))
			setCould_not_admin_yn((String)recordSet.get("could_not_admin")) ;
		if(recordSet.containsKey("discontinue"))
			setDiscontinue_yn((String)recordSet.get("discontinue")) ;

		
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

	

	public java.util.HashMap insert() {
			
		locale= getLanguageId()==null?"en":getLanguageId();
			StringBuffer debug=new StringBuffer();
			debug.append("INSIDE INSERT");

			HashMap map = new HashMap() ;
			map.put( "result", new Boolean( false ) ) ;		
		     Connection connection				  = null;
			PreparedStatement pstmt             = null ;
			ResultSet resultSet				      = null ;
			
			  PreparedStatement delete             = null ;
			 
			try{
				connection				= getConnection() ;
				delete			= connection.prepareStatement(PhRepository.getPhKeyValue("PH_MED_CANCEL_RIGHTS_DELETE")); 
				delete.setString(1,login_facility_id.trim());
				delete.setString(2, user_id);
				//delete.setString(3, nursing_unit_code.trim());
				int deleted=delete.executeUpdate();
				if(deleted>0){
					connection.commit();
					map.put( "result", new Boolean( true ) ) ;
					map.put( "message", getMessage(locale.trim(),"RECORD_INSERTED","PH") ) ;
				}	
			
				pstmt= connection.prepareStatement(PhRepository.getPhKeyValue("PH_MED_CANCEL_RIGHTS_INSERT"));
					pstmt.setString(1,user_id);
					pstmt.setString(2,login_facility_id);
					pstmt.setString(3,Admin_yn);
					pstmt.setString(4,self_admin_yn);
					pstmt.setString(5,hold_yn);
					pstmt.setString(6,could_not_admin_yn);
					pstmt.setString(7,discontinue_yn);
					pstmt.setString(8,cancel_admin_yn);
					pstmt.setString(9,login_by_id);
					pstmt.setString(10,login_by_id);
					pstmt.setString(11,login_facility_id);
					pstmt.setString(12,login_facility_id);
					pstmt.setString(13,login_at_ws_no);
					pstmt.setString(14,login_at_ws_no);
					int insert=pstmt.executeUpdate();
					if(insert>0){
						connection.commit();
						map.put( "result", new Boolean( true ) ) ;
						map.put( "message", getMessage(locale.trim(),"RECORD_INSERTED","PH") ) ;
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

	}


	
	   public java.util.HashMap modify() {StringBuffer debug =new StringBuffer();
		
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		ArrayList modifyData = new ArrayList() ;

		
		modifyData.add( Admin_yn ) ;
		modifyData.add( self_admin_yn ) ;
		modifyData.add( hold_yn ) ;
		modifyData.add( could_not_admin_yn ) ;
		modifyData.add( discontinue_yn ) ;
		modifyData.add( cancel_admin_yn ) ;
		modifyData.add( login_by_id.trim() ) ;
		modifyData.add( login_at_ws_no.trim() ) ;
		modifyData.add( login_facility_id.trim() ) ;
		modifyData.add(user_id);
		modifyData.add(login_facility_id);
		
		
		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "ModifyData",modifyData);

		HashMap sqlMap = new HashMap() ;
		try{
		sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("PH_MED_CANCEL_RIGHTS_UPDATE"));
		}catch(Exception e){
			e.printStackTrace();
		}

//		SingleTableHandlerHome home = null;
//		SingleTableHandlerRemote remote = null;


		try {
			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;

			home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
			debug.append("BEFOER CREATE(IN MODIFY)");
			remote = home.create() ;
			debug.append("BEFOER MODIFY");
			map = remote.modify( tabData, sqlMap ) ;*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); ;
				paramArray[1] = sqlMap.getClass();

			map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);



			debug.append("After MODIFY:::"+(Boolean) map.get( "result" ));

			if( ((Boolean) map.get( "result" )).booleanValue() )
			{
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) map.get("msgid"),"PH")) ;
				map.put( "flag",debug.toString());
			}
			else{
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", (map.get("msgid"))) ;
				map.put( "flag",debug.toString());
			}
		} catch(Exception e) {
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage()) ;
			map.put( "flag",debug.toString());
			e.printStackTrace() ;
		} 
		/*finally {
			try {
			//	if( remote != null )
			//		remote.remove() ;
			} catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}*/
		return map ;
		}
	public HashMap validate(){
		HashMap hmReturn	=	new HashMap();
		hmReturn.put("result",new Boolean(true));
		hmReturn.put("message","");
		return hmReturn;
		}

	
		
}

