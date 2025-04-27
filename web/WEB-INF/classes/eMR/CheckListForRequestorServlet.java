package eMR;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
public class CheckListForRequestorServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
PrintWriter out;
java.util.Properties p;
String userid;
String s20 = "";
String err_value="0";
String  facility ;
String locale="";
String remarks;
PreparedStatement pslPrepStmt1=null;
PreparedStatement pslPrepStmt2=null;
PreparedStatement  pslPrepStmt=null;
//Statement stmt				 = null;
PreparedStatement stmt = null;
Statement stmt1				 = null;
String facilityId ;
String client_ip_address ;

Connection con ;
String insert_vals="";

String delete_vals="";
String respID="";
	HttpSession session;
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		locale = p.getProperty("LOCALE");
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		if(facilityId==null) facilityId="";
		client_ip_address = p.getProperty("client_ip_address");
		try
		{
			req.setCharacterEncoding("UTF-8");
		    res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			con = ConnectionManager.getConnection(req);
			insertChecklist(req, res);


			pslPrepStmt1=null; 
			pslPrepStmt2=null;
			pslPrepStmt=null;
			out = null;
		}
		catch(Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();
		}
	finally
		{
			ConnectionManager.returnConnection(con, req);
		}

	}
	private void insertChecklist(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			userid=req.getParameter("userID");
			
			String addedById = p.getProperty( "login_user" ) ;
	
		
                   

			int ilStatus =0 ;
			int ilStatus1 =0 ;
			
            String	from	=	"",	to		=	"";
            from		=	(req.getParameter("from")==null)	?	"0"	:	req.getParameter("from");
            to			=	(req.getParameter("to")==null)		?	"0"	:	req.getParameter("to");
			insert_vals = req.getParameter("insert_vals");
			
			delete_vals = req.getParameter("delete_vals");
			String i="";
			
		
			if(!insert_vals.equals(""))
			{
			StringTokenizer insToken = new StringTokenizer(insert_vals, "~");
			String sql="insert into MR_CHKLIST_FOR_REQUESTOR (REQUESTOR_ID ,CHK_LIST_CODE,ADDED_BY_ID ,ADDED_DATE ,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_FACILITY_ID ) values (?,?,?,sysdate,?,?,sysdate,?,?,?)";
			pslPrepStmt = con.prepareStatement(sql);
				while(insToken.hasMoreTokens())
				{
						i = insToken.nextToken();
						respID = (req.getParameter("respID"+i)==null)	?	""	:	req.getParameter("respID"+i);
						
												
						pslPrepStmt.setString(1,userid);
						pslPrepStmt.setString(2,respID);
						pslPrepStmt.setString(3,addedById);
						pslPrepStmt.setString(4,client_ip_address);
						pslPrepStmt.setString(5,addedById);
						pslPrepStmt.setString(6,client_ip_address);
						pslPrepStmt.setString(7,facilityId);
						pslPrepStmt.setString(8,facilityId);
						ilStatus = pslPrepStmt.executeUpdate();

						 
						if(!(ilStatus >=1))
						{
							break;
						}
				}
				if(pslPrepStmt!=null) pslPrepStmt.close(); 
			}
			
			if(!delete_vals.equals(""))
			{
			StringBuffer sblQry = new StringBuffer();
			StringBuffer sblQry1 = new StringBuffer();
			StringTokenizer insToken = new StringTokenizer(delete_vals, "~");
			String ids_to_delete = "(";
			int k=0;
			stmt1 = con.createStatement();
			
				while(insToken.hasMoreTokens())
				{
					if(k != 0)
						ids_to_delete = ids_to_delete +",";
					i = insToken.nextToken();
					
					ids_to_delete =ids_to_delete+ "'"+i+"'";
					k++;
				}
				ids_to_delete = ids_to_delete +")";
				
				sblQry.append("delete from MR_CHKLIST_FOR_REQUESTOR where REQUESTOR_ID = ? and ADDED_FACILITY_ID= ?  and CHK_LIST_CODE IN "+ids_to_delete);
				stmt = con.prepareStatement(sblQry.toString());
						stmt.setString (1,userid);
						stmt.setString (2,facilityId);
				ilStatus1 = stmt.executeUpdate();

				
			}
			if(stmt!=null) stmt.close();	
			if(stmt1!=null) stmt1.close();	
			
			
         
			if(ilStatus >=1 || ilStatus1 >=1 )
			{
				con.commit();
				err_value="1";
				java.util.Hashtable hashtable1 = MessageManager.getMessage(locale,"RECORD_INSERTED", "SM");
				s20 = (String)hashtable1.get("message");
				hashtable1.clear();
			}else con.rollback();

           	res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode("", "UTF-8") + "&err_value=" + err_value);
	
			if(pslPrepStmt1!=null) pslPrepStmt1.close();
			if(pslPrepStmt2!=null) pslPrepStmt2.close();
			if(pslPrepStmt!=null) pslPrepStmt.close();
		}
	catch ( Exception e )
	{
	//	out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		
		e.printStackTrace();
	}
}
}