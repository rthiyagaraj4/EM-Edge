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
import javax.servlet.* ;
import javax.servlet.http.*;
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;

public class ADRQuestionBean extends PhAdapter implements Serializable 
{
	protected String question_code					= "";
	protected String question_desc					= "";
	protected String seq_no							= "";
	protected String relative_score_yes				= "";
	protected String relative_score_no				= "";
	protected String relative_score_not_known		= "";
	protected String eff_status						= "";
	
	public ADRQuestionBean() 
	{
		try 
		{
			doCommon();
		}
		
		catch(Exception e) { e.printStackTrace();}
	}

	/* Over-ridden Adapter methods start here */
	public void clear() 
	{
		super.clear() ;
	}

	private void doCommon() throws Exception 
	{
	}

	/* Over-ridden Adapter methods end here */

	
	public void setQuestion_Code(String question_code)
	{
		this.question_code = question_code;
	}
	public void setQuestion_Desc(String question_desc)
	{
		this.question_desc = question_desc;
	}
	
	public void setSeq_No(String seq_no)
	{
		this.seq_no = seq_no;
	}
	public void setRelativeScoreYes(String relative_score_yes)
	{
		this.relative_score_yes = relative_score_yes;
	}
	public void setRelativeScoreNo(String relative_score_no)
	{
		this.relative_score_no = relative_score_no;
	}
	public void setRelativeScoreNotKnown(String relative_score_not_known)
	{
		this.relative_score_not_known = relative_score_not_known;
	}
	public void setEffStatus(String eff_status)
	{
		if (eff_status.equals("") || eff_status==null )
			eff_status="D";
		
		this.eff_status = eff_status;
	}
	public String getQuestion_Code()
	{
		return question_code;
	}
	public String getQuestion_Desc()
	{
		return question_desc;
	}

	public String getSeq_No()
	{
		return seq_no;
	}
	public String getRelativeScoreYes()
	{
		return relative_score_yes;
	}
	public String getRelativeScoreNo()
	{
		return relative_score_no;
	}
	public String getRelativeScoreNotKnown()
	{
		return relative_score_not_known;
	}
	public String getEff_Status()
	{
		return eff_status;
	}

	public HashMap validate() throws Exception 
	{
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}

	// setAll method to set all the values
	public void setAll(Hashtable recordSet)
	{
		
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
		if(recordSet.containsKey("ques_code"))
			setQuestion_Code((String)recordSet.get("ques_code")) ;
		if(recordSet.containsKey("ques_desc"))
			setQuestion_Desc((String)recordSet.get("ques_desc")) ;
		if(recordSet.containsKey("seq_no"))
			setSeq_No((String)recordSet.get("seq_no")) ;
		if(recordSet.containsKey("relative_score_yes"))
			setRelativeScoreYes((String)recordSet.get("relative_score_yes")) ;
		if(recordSet.containsKey("relative_score_no"))
			setRelativeScoreNo((String)recordSet.get("relative_score_no")) ;
		if(recordSet.containsKey("relative_score_not_known"))
			setRelativeScoreNotKnown((String)recordSet.get("relative_score_not_known")) ;
		if(recordSet.containsKey("eff_status"))
			setEffStatus((String)recordSet.get("eff_status")) ;		
	
	}


	public HashMap insert() 
	{
	
		StringBuffer debug =new StringBuffer();
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		ArrayList insertData = new ArrayList() ;
		ArrayList whereData = new ArrayList() ;
		try
		{	insertData.add( question_code ) ;
			insertData.add( question_desc ) ;
			insertData.add(relative_score_yes ) ;
			insertData.add(  relative_score_no ) ;
			insertData.add( relative_score_not_known ) ;
			insertData.add( seq_no ) ;
			insertData.add( login_by_id.trim() ) ;
			//DATE
			insertData.add( login_at_ws_no.trim() ) ;
			insertData.add( login_facility_id.trim() ) ;
			insertData.add( login_by_id.trim() ) ;
			//DATE
			insertData.add( login_at_ws_no.trim() ) ;
			insertData.add( login_facility_id.trim() ) ;
			insertData.add( eff_status ) ;

			whereData.add(question_code ) ;
			
			HashMap tabData = new HashMap() ;

			tabData.put( "properties", getProperties() );
			tabData.put( "InsertData",insertData);
			tabData.put( "WhereData",whereData);

			//String sql="INSERT INTO PH_ADR_QUESTION(QUESTION_CODE, QUESTION_DESC, YES_SCORE,NO_SCORE,NOT_KNOWN_SCORE,SEQ_NO, ADDED_BY_ID, ADDED_DATE , ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,EFF_STATUS)VALUES(?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)";
			//sqlMap.put( "InsertSQL", sql );
			//String selectsql="SELECT COUNT(ROWID) FROM PH_ADR_QUESTION WHERE QUESTION_CODE=?";
			//sqlMap.put( "SelectSQL",  selectsql );
			
			HashMap sqlMap = new HashMap() ;
		
			sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue("SQL_PH_ADR_QUESTION_INSERT") );
			sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue("SQL_PH_ADR_QUESTION_SELECT") );
			
		
			
		
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
                    if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
                    map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common"));
                    else
                      map.put( "message", getMessage(getLanguageId(),(String) map.get("msgid"),"PH"));
                }
	}
		catch(Exception e) 
		{
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage()) ;
			map.put( "flag",debug.toString());
			e.printStackTrace() ;
		}
		
	    return map ;	
	}
	public HashMap modify() 
	{
		StringBuffer debug =new StringBuffer();
	
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		ArrayList modifyData = new ArrayList() ;
		try 
		{
		modifyData.add( question_desc) ;
		modifyData.add( relative_score_yes ) ;
		modifyData.add( relative_score_no ) ;
		modifyData.add( relative_score_not_known ) ;
		modifyData.add( seq_no ) ;
		
		modifyData.add( login_by_id.trim() ) ;
		//date
		modifyData.add( login_at_ws_no.trim() ) ;
		modifyData.add( login_facility_id.trim() ) ;
		modifyData.add( eff_status ) ;
		modifyData.add( question_code) ;
		
		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "ModifyData",modifyData);

		HashMap sqlMap = new HashMap() ;

		//String modifySql="UPDATE PH_ADR_QUESTION SET QUESTION_DESC=?,YES_SCORE=?,NO_SCORE=?,NOT_KNOWN_SCORE=?,SEQ_NO=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,EFF_STATUS=? WHERE QUESTION_CODE=?";
		//sqlMap.put( "ModifySQL", modifySql);
	
		
			sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("SQL_PH_ADR_QUESTION_UPDATE") );
		
	
			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
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
				map.put("message",map.get("msgid"));	
		
		}
		catch(Exception e) 
		{
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage()) ;
			map.put( "flag",debug.toString());
			e.printStackTrace() ;
		}

		return map ;	
	}

	public ArrayList checkOverlapping()
	{
		ArrayList result=new ArrayList();
		String min_rel_score="";
		String max_rel_score="";
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		Connection con=null;
		

		try{
			con=getConnection();
			//String selectsql="SELECT MIN(REL_SCORE_FROM) MIN_REL_SCORE,MAX(REL_SCORE_TO) MAX_REL_STORE FROM PH_ADR_CERTAINITY WHERE CERTAINITY_CODE!='E'";
			//pstmt=con.prepareStatement(selectsql );

			 pstmt=con.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ADR_QUESTION_SELECT_OVERLAP") );
			
			
			 resultSet=pstmt.executeQuery();
		     resultSet.next();
			 min_rel_score =resultSet.getString("MIN_REL_SCORE");
			 max_rel_score=resultSet.getString("MAX_REL_STORE");
			
			 result.add(min_rel_score);
			 result.add(max_rel_score);
			

		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
		finally{
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( con );
		}
		catch(Exception e){
			e.printStackTrace() ;
		}
		}
	   return result;
	}
	
} 
