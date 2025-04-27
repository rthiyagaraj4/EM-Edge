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
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;

public class TermCodeForDrugBean extends PhAdapter implements Serializable{
	
	protected String drug_code = "";
	protected String TermSetList = "";
	protected String Term_code = "";
	protected String chk_opt = "";
	protected String diag_scr_note_type = "";

	 public TermCodeForDrugBean(){
        try{
            doCommon();
        }
        catch(Exception e){
           System.err.println("Error in Constructor"+e.toString());
		   e.printStackTrace();
		}
    }
	
	private void doCommon() throws Exception{
	}

	public void setAll(Hashtable recordSet)
	{
		      
		//System.out.println("recordSet------>"+recordSet);
		
		if(recordSet.containsKey("drug_code"))
        drug_code=(String)recordSet.get("drug_code");
		//System.out.println("drug_code--->"+drug_code);
		
      
		if(recordSet.containsKey("TermSetList"))
        TermSetList=(String)recordSet.get("TermSetList");
		//System.out.println("TermSetList--->"+TermSetList);



		if(recordSet.containsKey("Term_code"))
        Term_code=(String)recordSet.get("Term_code");
		//System.out.println("Term_code--->"+Term_code);



		if(recordSet.containsKey("chk_opt"))
        chk_opt=(String)recordSet.get("chk_opt");
          if(chk_opt.equals(""))
		{
			  chk_opt="D";
		}
		//System.out.println("chk_opt--->"+chk_opt);


	}


public HashMap insert() {

  //System.err.println("insert---->");

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;

		ArrayList insertData = new ArrayList() ;
		

		try{
			   insertData.add( drug_code ) ;
		       insertData.add( TermSetList ) ;
		       insertData.add(	Term_code ) ;
		       insertData.add(	diag_scr_note_type ) ;
               insertData.add( chk_opt) ;
		
			
			insertData.add( login_by_id.trim() ) ;
			insertData.add( login_at_ws_no.trim() ) ;
			insertData.add( login_facility_id.trim() ) ;

			insertData.add( login_by_id.trim() ) ;
			insertData.add( login_at_ws_no.trim() ) ;
			insertData.add( login_facility_id.trim() ) ;

			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "InsertData",insertData);
	
           // System.err.println("tabData---------->"+tabData);

			HashMap sqlMap = new HashMap() ;
			
			sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue("SQL_PH_DRUG_ELIGIBLE_TERM_CODE_INSERT") );

			//System.err.println("sqlMap-------->"+sqlMap);

		/*	SingleTableHandlerHome home = null;
			SingleTableHandlerRemote remote = null;*/

			try {
/*				InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;

				home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote = home.create() ;
				map = remote.insert( tabData, sqlMap ) ;*/

    			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]=new Object[2];
				argArray[0]=tabData;
				argArray[1]=sqlMap;

				Class[] paramArray=new Class[2];
				paramArray[0]=tabData.getClass();
				paramArray[1]=sqlMap.getClass();

				map=(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				if( ((Boolean) map.get( "result" )).booleanValue() )
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;

				else{
					if( ((String)map.get( "msgid" )).equals("CODE_ALREADY_EXISTS" ) )
						map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ) ;
					else
						map.put( "message", (map.get("msgid"))) ;
				}
			}
			catch(Exception e) {
				System.err.println( "Error Calling EJB : "+e ) ;
				map.put( "message", e.getMessage()) ;
				e.printStackTrace() ;
			}
		}
		catch(Exception e)
		{
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", "exp :"+e.getMessage()) ;
			e.printStackTrace() ;
		}
/*		finally 
		{
			try {} 
			catch( Exception ee )
			{
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}//finally*/
		//System.err.println("map--insert method-->"+map);
		return map ;
	}





public HashMap modify() 
{
System.err.println("modify method is calling--------------->");
HashMap map = new HashMap() ;
map.put( "result", new Boolean( false ) ) ;		

ArrayList insertRow = new ArrayList() ;
	     
	insertRow.add( chk_opt  ) ;
	insertRow.add( drug_code ) ;
	insertRow.add(TermSetList) ;
	insertRow.add(Term_code) ;
	
	
	
	

	
	HashMap tabData = new HashMap() ;
	tabData.put( "properties", getProperties() );
	tabData.put( "ModifyData",insertRow);


//System.err.println("tabData---line 191--->"+tabData);

	HashMap sqlMap = new HashMap() ;
	try{
			sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue( "SQL_PH_DRUG_ELIGIBLE_TERM_CODE_UPDATE" ) );
			System.err.println("sqlMap------modify------>"+sqlMap);
		}catch(Exception e){
			e.printStackTrace();
		}
	

	try {
		
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
          
		   //System.err.println("map------line 217------>"+map);

	if( ((Boolean) map.get( "result" )).booleanValue() ){
		
	//map.put( "message", getMessage((String) map.get( "msgid" )) ) ;
	map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
	}
	
	}//try
	catch(Exception e) {
		map.put( "message", e.getMessage()) ;
		e.printStackTrace() ;
	}
	//System.err.println("map---modify method---->"+map);;
		return map ;		
	
}






  public ArrayList getTermList(){
	  Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		ArrayList TermArraylist =		new ArrayList();
		
		try {
			connection	 = getConnection() ;
			pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TERM_SET_SELECT1" )) ;
			resultSet      = pstmt.executeQuery() ;

			while (resultSet.next()) {
				HashMap rec		=	new HashMap();
				String code,desc;
				code					=	resultSet.getString("TERM_SET_ID");
				desc					=	resultSet.getString("TERM_SET_DESC");
				rec.put("code",code);
				rec.put("desc",desc);
				TermArraylist.add(rec);
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
		return TermArraylist;
	  }

 public ArrayList getTermResult(String drug_code){
	 System.err.println("drug_code--->" +drug_code);
	  Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		ArrayList TermResultArraylist =		new ArrayList();
		
		try {
			connection	 = getConnection() ;
			pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DRUG_ELIGIBLE_TERM_CODE_SELECT" )) ;
			pstmt.setString(1,drug_code);
			resultSet      = pstmt.executeQuery() ;

			while (resultSet.next()) {
				HashMap rec		=	new HashMap();
				String term_set_id,term_code,term_set_desc,term_code_desc,eff_status;
				term_set_id					=	resultSet.getString("TERM_SET_ID");
				term_code					=	resultSet.getString("TERM_CODE");
				term_set_desc					=	resultSet.getString("TERM_SET_DESC");
				term_code_desc					=	resultSet.getString("TERM_CODE_DESC");
				eff_status					=	resultSet.getString("EFF_STATUS");
				rec.put("term_set_id",term_set_id);
				rec.put("term_code",term_code);
				rec.put("term_set_desc",term_set_desc);
				rec.put("term_code_desc",term_code_desc);
				rec.put("eff_status",eff_status);
				TermResultArraylist.add(rec);
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
		return TermResultArraylist;
	  }
	
	
}
