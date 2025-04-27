/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.net.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import java.util.regex.*;
public class ReArrangeMentServlet extends HttpServlet
{
	HttpServletRequest req=null;
	HttpSession session=null;
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException 
	{
		session=request.getSession(false);
Update(request,response);
	}
public  void Update(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException 
	{
PrintWriter pw = null;
response.setContentType("text/html");
pw = response.getWriter();
String pass;
try {
		Connection connection	= null;
	
		
		int errFlag				= 0;
		String exceptions		= "";
		
		String useDefStructure;
	try{		
	   try{
			if(connection==null) connection = ConnectionManager.getConnection();      
		}
		catch(Exception exp){
			System.out.println("Error in calling getconnection method of ElementSegmentValidateQry  :"+exp.toString());
		exp.printStackTrace(System.err);

		}
	pass = request.getParameter("UserDefind_id");
String user=pass.toString().trim();
String UsrdefStr1=user.substring(0,user.length());


	//pw.println("<script>alert(pass)</script>");
	
   CallableStatement callableStatement=null;				
    callableStatement=connection.prepareCall("{ call XHGENERIC.xh_update_user_def_structure(?,?)}");
    callableStatement.setString(1,UsrdefStr1);
	callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
   callableStatement.execute();
   useDefStructure=callableStatement.getString(2);
	RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/RearrangementResult.jsp?message="+useDefStructure);
 reqDis.forward(request,response);
     
	   /*pw.println("</body>");
    pw.println("</html>");*/

   /*if(useDefStructure.equals("S"))
   {
	   pw.println("alert('Successfully update')");    
  RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/RearrangementLayerSelectMaster.jsp");
 reqDis.forward(request,response);
 RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/RearrangementLayerSelectMaster.jsp?message=");
 reqDis.forward(request,response);
   }
   else
  {
	   pw.println("alert('couldnt update')");

	
   //pw.println("<script>alert('should not update')</script>");
  RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/RearrangementLayerSelectMaster.jsp");
  reqDis.forward(request,response);
  }*/
    if(callableStatement!=null) callableStatement.close();


  }
			catch(Exception exp){
			errFlag = 1;
			System.out.println("Error in executing QueryResult of ElementSegmentValidateQry  :"+exp.toString());
			exp.printStackTrace(System.err);
			exceptions=exp.toString();        
		}
		finally{
//				System.out.println(" RearrangementLayerQryStructures errFlag UserDefStructure : "+errFlag);

			ConnectionManager.returnConnection(connection,request);
//				String sdt = java.net.URLEncoder.encode(SysDefStructure);
//				String udt = java.net.URLEncoder.encode(UserDefStructure);
//out.println("parent.setSystUsrDefStr('"+sdt.toString().trim()+"','"+udt.toString().trim()+"')");
		}
		

	}
	catch (Exception e) {
		e.printStackTrace() ;
	}


pw.close();
pw.flush();


/*try {
		Connection connection	= null;
		Statement statement		= null;
		ResultSet resultSet		= null;
		int errFlag				= 0;
		String exceptions		= "";
		String SysDefStructure  = "";
		String UserDefStructure = "";
		try{		
	try{
			if(connection==null) connection = ConnectionManager.getConnection();      
		}
		catch(Exception exp){
			System.out.println("Error in calling getconnection method of ElementSegmentValidateQry  :"+exp.toString());
		exp.printStackTrace(System.err);

		}
	pass = request.getParameter("UsrDefStr");
    CallableStatement callableStatement=null;				
    callableStatement=connection.prepareCall("{ call xh_update_user_def_structure(?)}");
    callableStatement.setString(1,pass);
   	callableStatement.execute();
SysDefStructure=callableStatement.getString(2);

	if(SysDefStructure.equals("Y"))
		{

	    }
   else
	{
	
	}

        	}
			catch(Exception exp){
			errFlag = 1;
			System.out.println("Error in executing QueryResult of ElementSegmentValidateQry  :"+exp.toString());
			exp.printStackTrace(System.err);
			exceptions=exp.toString();        
		}
		finally{
				System.out.println(" RearrangementLayerQryStructures errFlag UserDefStructure : "+errFlag);

			ConnectionManager.returnConnection(con,request);
//				String sdt = java.net.URLEncoder.encode(SysDefStructure);
//				String udt = java.net.URLEncoder.encode(UserDefStructure);
//out.println("parent.setSystUsrDefStr('"+sdt.toString().trim()+"','"+udt.toString().trim()+"')");
		}
		

	}
	catch (Exception e) {
		e.printStackTrace() ;
	}*/

	}







}
