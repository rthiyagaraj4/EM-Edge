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

public class ADRCertainityBean extends PhAdapter implements Serializable 
{
	protected String Certainity_code = "";
	protected String System_Description = "";
	protected String user_desc  = "";
	protected String rel_score_from  = "";
	protected String rel_score_to  = "";

	public ADRCertainityBean() 
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

	
	public void setCertainity_Code(String Certainity_code)
	{
		this.Certainity_code = Certainity_code;
	}
	public void setSystem_Description(String System_Description)
	{
		this.System_Description = System_Description;
	}
	
	public void setUser_desc(String user_desc)
	{
		this.user_desc = user_desc;
	}
	public void setRel_score_from(String rel_score_from)
	{
		this.rel_score_from = rel_score_from;
	}
	public void setRel_score_to(String rel_score_to)
	{
		this.rel_score_to = rel_score_to;
	}
	
	public String getCertainity_Code()
	{
		return Certainity_code;
	}
	public String getSystem_Description()
	{
		return System_Description;
	}

	public String getUser_desc()
	{
		return user_desc;
	}
	public String getRel_score_from()
	{
		return rel_score_from;
	}
	public String getRel_score_to()
	{
		return rel_score_to;
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
		if(recordSet.containsKey("Certainity_code"))
			setCertainity_Code((String)recordSet.get("Certainity_code")) ;
		if(recordSet.containsKey("System_Description"))
			setSystem_Description((String)recordSet.get("System_Description")) ;
		if(recordSet.containsKey("user_desc"))
			setUser_desc((String)recordSet.get("user_desc")) ;
		if(recordSet.containsKey("rel_score_from"))
			setRel_score_from((String)recordSet.get("rel_score_from")) ;
		if(recordSet.containsKey("rel_score_to"))
			setRel_score_to((String)recordSet.get("rel_score_to")) ;
				
	}


	public HashMap modify() 
	{
		StringBuffer debug =new StringBuffer();
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		ArrayList modifyData = new ArrayList() ;
		try
		{
			
			modifyData.add( user_desc ) ;
			modifyData.add( rel_score_from ) ;
			modifyData.add( rel_score_to ) ;
			modifyData.add( login_by_id.trim() ) ;
			modifyData.add( login_at_ws_no.trim() ) ;
			modifyData.add( login_facility_id.trim() ) ;
			modifyData.add( Certainity_code) ;
			modifyData.add( System_Description ) ;
			
			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "ModifyData",modifyData);

			
			HashMap sqlMap = new HashMap() ;
		
			sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("SQL_PH_ADR_CERTAINITY_UPDATE") );
		
		

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
	public String checkOverlapping(String rel_score_from,String rel_score_to,String Certainity_code)
	{
		String result="";
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		Connection con=null;
		try
		{
			con=getConnection();
			//String selectsql="SELECT DECODE(NVL(COUNT(*),0),0,'N','Y') OVERLAPS_YN   FROM   PH_ADR_CERTAINITY  WHERE CERTAINITY_CODE != 'E'    AND CERTAINITY_CODE !=?  AND       ( (? BETWEEN REL_SCORE_FROM AND REL_SCORE_TO ) or       (? BETWEEN REL_SCORE_FROM AND REL_SCORE_TO )  OR   ( REL_SCORE_FROM BETWEEN ? AND ?  ) or    (REL_SCORE_TO BETWEEN ? AND ?))";
	
			//pstmt=con.prepareStatement(selectsql);
			 pstmt=con.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ADR_CERTAINITY_SELECT_OVERLAP"));
			 pstmt.setString(1,Certainity_code);
			 pstmt.setString(2,rel_score_from);
			 pstmt.setString(3,rel_score_to);
			 pstmt.setString(4,rel_score_from);
			 pstmt.setString(5,rel_score_to);
			 pstmt.setString(6,rel_score_from);
			 pstmt.setString(7,rel_score_to);
			 resultSet=pstmt.executeQuery();
		     resultSet.next();
			 result=resultSet.getString("OVERLAPS_YN");
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
