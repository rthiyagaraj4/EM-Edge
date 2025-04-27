/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
public class CommClientOfflineResponseServlet extends HttpServlet {
    HttpSession session;
	static Driver oracleDriver = null;
    //MEDSTART
    String protocolId = "";
	String protocolName="";
	String fieldName="";
   PreparedStatement pstmt = null;
   String checkField="";
    ResultSet rs = null;
	XMLStringParser obj	=null;	

    public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out;
						   
        out = res.getWriter();
      																			  
		obj=new XMLStringParser();
		Map hash = (Map)obj.parseXMLString( req ) ;
		hash = (Map)hash.get("SEARCH") ;
		protocolId=(String) hash.get("protocolId");	
		protocolName=(String) hash.get("protocolName");	
		fieldName=(String) hash.get("fieldName");
		checkField=(String) hash.get("checkField");
		processLevel1(req,res,protocolId);		
		hash.clear();
	}
    
    private void processLevel1(HttpServletRequest req, HttpServletResponse res,String protocolId) {

		String offline_sequence_id=""; 
		//System.out.println("processLevel1");
	    PrintWriter out=null;	
		
        Connection conForPwd = null;
		try{
			 out = res.getWriter();
				conForPwd = ConnectionManager.getConnection(req);
				Statement stmtPwd = null;
				ResultSet rsPwd = null;
	 
				try {		
					
				   
					stmtPwd = conForPwd.createStatement();
					rsPwd = stmtPwd.executeQuery("SELECT OFFLINE_SEQUENCE_ID FROM xh_protocol WHERE PROTOCOL_ID ='"+protocolId+"'");
				//	System.out.println("SELECT OFFLINE_SEQUENCE_ID FROM xh_protocol WHERE PROTOCOL_ID ='"+protocolId+"'");	 
					while(rsPwd.next()) {
						offline_sequence_id = XHDBAdapter.checkNull(rsPwd.getString(1));
					//	System.out.println("offline_sequence_id :"+offline_sequence_id);

					}
					//System.out.println("primary_lang :"+primary_lang);		 
				

					if(offline_sequence_id.equals(""))
					{
					 									   
					}
					else
					{	
				//	  System.out.println("offline_sequence_id1 :");

						MessageManager mm=new MessageManager();
						final java.util.Hashtable mesg = mm.getMessage("en", "XH0088", "XH") ;
						String message = ((String) mesg.get("message"));	
			    //	    System.out.println("offline_sequence_id2 :"+message);
						out.println("setFrames('"+message+"','"+protocolName+"','"+fieldName+"','"+checkField+"')");	     
					//	out.println("<script>parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num="+message+"'</script>");  
					
						//parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num="+message+"'

					//	out.println("<script>parent.f_query_add_mod.document.getElementById(<%=protocolName%>).checked=false;parent.f_query_add_mod.document.getElementById(<%=fieldName%>).style.display = 'none';	</script>");   							
						mesg.clear();
					
					}

					if(rsPwd != null)rsPwd.close();
				   if(stmtPwd != null)stmtPwd.close();
				} catch (Exception e1) {
					System.out.println("CommClientOfflineResponseServlet.java er:" +e1);
				}
			
			
		
			if(conForPwd != null)conForPwd.close();
		}catch(Exception connEx){
			connEx.printStackTrace();
		}finally {
                if (conForPwd != null)
                 ConnectionManager.returnConnection(conForPwd,req);
				
       }
    }
    
   
    
    
    
   
    
    
}//class
														 
