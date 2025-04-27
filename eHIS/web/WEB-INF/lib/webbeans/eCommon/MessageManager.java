/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package webbeans.eCommon;

import java.sql.*;
import java.util.*;
import java.io.*;

import com.ehis.persist.*;

public class MessageManager{

	public static java.util.Hashtable getMessage(Connection con,String messageId){ 
 		Hashtable results = new java.util.Hashtable() ;
		StringBuffer sb = new StringBuffer( "" ) ;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement( "select 'APP-'||message_id||' '||message_text_sysdef from sm_message where message_ref = ?" ) ;
			pstmt.setString( 1, messageId ) ;
			rs = pstmt.executeQuery() ;
			if ( rs != null ) {
				rs.next() ;
				sb.append(rs.getString(1) + "<br>" ) ;
			} else {
				sb.append( "No message found. Contact System Administrator." + "<br>" ) ;
			}
		}catch(Exception e ) {
			results.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;
		} finally {
			try {
				if(rs != null )rs.close() ;
				if(pstmt != null )pstmt.close() ;				
			}catch(Exception ee ){}
		}
		results.put( "message", sb.toString() ) ;
		return results  ;
	}	

	public static java.util.Hashtable getMessage(String locale,String messageId,String moduleId){
		
		String returnText = SpringCacheBean.getMessage(locale,messageId,moduleId);
	
		Hashtable results = new java.util.Hashtable() ;		
		results.put( "message",returnText) ;

		return results  ;
	}

	public static String getLabel(String locale,String messageId,String moduleId){ 	
		 java.util.ResourceBundle myResources =java.util.ResourceBundle.getBundle("e"+moduleId+".resources.Labels", new java.util.Locale(locale));
		 return myResources.getString( messageId );
	}

}
