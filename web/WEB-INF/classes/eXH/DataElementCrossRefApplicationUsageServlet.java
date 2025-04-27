/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.ArrayList;
import java.sql.*;
import eXH.ArrayAuditInfo;
import webbeans.eCommon.ConnectionManager; 
import webbeans.eCommon.*;
/**
 * Class used to update Data Element cross reference Application Usage Element values
 */
public class DataElementCrossRefApplicationUsageServlet extends HttpServlet
{
	/**
	 * Do post method which implements the functionalities  of Data Element cross reference Application Usage Element values
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 */

public void doPost (HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException 
{
    int result=0;
	HttpSession session = req.getSession(false);
	  Properties p;		
	  p = (Properties) session.getValue("jdbc");	
	  String locale  = p.getProperty("LOCALE");
    String query="";
	//req.setCharacterEncoding("UTF-8");
   //	res.setContentType("text/html;charset=UTF-8");

	PrintWriter out=res.getWriter();
	CallableStatement oraclecallablestatement = null;
	Statement s=null;
		Connection con = null;
	MessageManager mm=new MessageManager();
		String status="";
    String sStyle = "";
    String transqry="";
    try
    {
     
      out.println("<head>");
      sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
      out.println("<link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
      out.println("</head>");
      out.println("<body class='MESSAGE'>");      
   
	}
    catch(Exception exception)
    {
         System.out.println("Error in dopost method od dataelementcrossrefapplicationusageservlet:"+exception.toString());
		exception.printStackTrace(System.err); 
		
    }
	
	try
    {
    
		con = ConnectionManager.getConnection(req);
 
 


        XHApplicationElementControllerBean xhBean=XHApplicationElementControllerBean.getBean(XHApplicationElementControllerBean.strBeanName,req,session);
        xhBean.action(req,con);
		String strData[][]= xhBean.getDatabaseData();
		ArrayList arrAudit = ArrayAuditInfo.getArrayAuditInfo(session);
		//xhBean.action(req,con);
	    s=con.createStatement(); 
		for(int i=0;i<strData.length;i++) 
		 {
          transqry="";
		  
       	    oraclecallablestatement = con.prepareCall("{call XHMAST.element_code_usage_for_appl(?,?,?,?,?,?,?,?,?)}");
 
       	String  usr_added_by_id=(String)arrAudit.get(0);
		String  usr_added_at_ws_no=(String)arrAudit.get(1);
	    oraclecallablestatement.setString(1,strData[i][0]);
     //  System.out.println(strData[i][0]);

		oraclecallablestatement.setString(2,strData[i][1]);
	//	 System.out.println(strData[i][1]);
		oraclecallablestatement.setString(3,strData[i][2]);
	//	 System.out.println(strData[i][2]);
		oraclecallablestatement.setString(4,strData[i][3]);
	//	 System.out.println(strData[i][3]);
		oraclecallablestatement.setString(5,strData[i][4]); 
//		  System.out.println(strData[i][4]);

	    oraclecallablestatement.setString(6,usr_added_by_id);
		oraclecallablestatement.setString(7,usr_added_at_ws_no);

		oraclecallablestatement.registerOutParameter(8,java.sql.Types.VARCHAR);
		oraclecallablestatement.registerOutParameter(9,java.sql.Types.VARCHAR);
		
        oraclecallablestatement.execute();
		
        
		status = oraclecallablestatement.getString(8);
		if(oraclecallablestatement!=null) oraclecallablestatement.close();
	//	System.out.println(status);

	         if(strData[i][2].equals("Y"))
			 {
 		        transqry=java.net.URLDecoder.decode(strData[i][8].toString().trim());
            
               if(transqry.indexOf("'")!=-1)
				 {
                      transqry=transqry.replaceAll("'","''");
				 }
				 else
				 {
                       transqry=transqry;
				 }
                    
             
		                query="UPDATE XH_APPL_ELEMENT SET TRANSLATION_TABLE='"+strData[i][5].toString().trim()+"',EHIS_ENTITY='"+strData[i][6].toString().trim()+"',PK_ELEMENT_REF='"+strData[i][7].toString().trim()+"',TRANS_QUERY='"+transqry+"',ELE_POS='"+strData[i][1].toString().trim()+"' WHERE  ELEMENT_ID='"+strData[i][1].toString().trim()+"' and APPLICATION_ID='"+strData[i][0].toString().trim()+"'";
	    
                result=s.executeUpdate(query);
           
             }
			 else
			 {
                        query="UPDATE XH_APPL_ELEMENT SET TRANSLATION_TABLE='',EHIS_ENTITY='',PK_ELEMENT_REF='',TRANS_QUERY='',ELE_POS='"+strData[i][1].toString().trim()+"' WHERE  ELEMENT_ID='"+strData[i][1].toString().trim()+"' and APPLICATION_ID='"+strData[i][0].toString().trim()+"'";
	      
                result=s.executeUpdate(query);
            


			 }
				 if("0".equals(status))
				{
					con.commit();
					 final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
					//final java.util.Hashtable mesg = mm.getMessage(con, "XH1001") ;
					status = ((String) mesg.get("message"));
					mesg.clear();
				}
				 else
				{
				  con.rollback();
				   final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
//				  final java.util.Hashtable mesg = mm.getMessage(con, "XH1000") ;
				  status = ((String) mesg.get("message")); 
				  mesg.clear();
				}
			 
	  }
        out.println("");
        out.println(status);
        out.println("");
        out.println("</body>");  
        arrAudit.clear();
		
		}catch(Exception exception)
		{
			 System.out.println("Error in calling db realted statements in dopost method of dataelementcrossrefapplicationusageservlet :"+exception.toString());
		    exception.printStackTrace(System.err); 
		
		}finally{
			try
			{
		      if(s!=null)
				{
				  s.close();
				  
				}
			   ConnectionManager.returnConnection(con);
			}catch(Exception ex){
			   System.out.println("Eroor in closing dbconnection dopost method of dataelementcrossrefapplicationusageservlet :"+ex.toString());
		      ex.printStackTrace(System.err); 
			}
			//if(con!=null) 

		}
	}// end of do post
}//end of class
