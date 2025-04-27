/*Created by Ashwini on 06-May-2024 for ML-MMOH-CRF-2125*/
package eAM;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;

public class ServiceforSpecialityServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	String service;
	String splcode;
	String facilityId;
	String facilityID="";
	String finalserviceList="";
	Connection con;
	String client_ip_address ;
	String locale="";

	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);		
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		locale= p.getProperty("LOCALE");
		
		try
		{
			con = ConnectionManager.getConnection(req);
			res.setContentType("text/html");
			this.out = res.getWriter();
			String operation = req.getParameter("function_name");

			if ( operation.equals("insert") ) insertServiceforSpec(req, res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			ConnectionManager.returnConnection(con, req);
		}
	}

	private void insertServiceforSpec(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			PreparedStatement pslPrepStmtdel=null;
			PreparedStatement stmtdel=null;
			String ServiceCode="",selectYN="",delInsYN="";
			PreparedStatement pslPrepStmt = null;
			RecordSet accessRightRecSet	= null;
			accessRightRecSet =	(webbeans.eCommon.RecordSet) session.getAttribute("AXSRightRecSet");
			finalserviceList = req.getParameter("finalserviceList");
			String unLinkservice = req.getParameter("unLinkserviceList");
			String[] unLinkserviceList = unLinkservice.split(",");
			
			if(finalserviceList == null) finalserviceList="";

			StringTokenizer mainTkn = new StringTokenizer(finalserviceList,"~");
			int maintkns= mainTkn.countTokens();
			
			for(int main=0;main<maintkns;main++)
			{
				String sub1=mainTkn.nextToken();
				accessRightRecSet.putObject(sub1);
		    }

			splcode=req.getParameter("splty_code");
			facilityID=req.getParameter("facility_id");

			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId = facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation = client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

			HashMap tabdata=new HashMap();
			tabdata.put("facility_id",addedFacilityId);
			tabdata.put("speciality_code",splcode);
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("facilityID",facilityID);

			String totCount	= ""+accessRightRecSet.getSize();
			if(totCount.equals("")) totCount="0";

			tabdata.put("totCount", new Integer(totCount));

			for(int j=0;j<accessRightRecSet.getSize();j++)
			{
				tabdata.put(("chk"+j),(String)accessRightRecSet.getObject(j));
			}

			int ilStatus = 0;

			String sql=	" insert into am_service_for_speciality( "+
					"  facility_id			"+
					" , speciality_code		"+
					" , service_code		"+
					" , added_by_id			"+
					" , added_date			"+
					" , added_at_ws_no		"+
					" , added_facility_id	"+
					" , modified_by_id		"+
					" , modified_date		"+
					" , modified_at_ws_no	"+
					" , modified_facility_id ) values(?,?,?,?,sysdate,?,?,?,sysdate,?,?) ";

			pslPrepStmt = con.prepareStatement(sql);

			String delSql= "delete from am_service_for_speciality where facility_id =? and speciality_code= ?  and service_code= ?";
			pslPrepStmtdel = con.prepareStatement(delSql);
			stmtdel = con.prepareStatement(delSql);
				
			String chkYN = "";
			if (Integer.parseInt(totCount) != 0)
			{
				for(int i=0; i<Integer.parseInt(totCount); i++)
				{
					chkYN = (String)tabdata.get("chk"+i);

					StringTokenizer st =new StringTokenizer(chkYN,"$");
					ServiceCode=st.nextToken();
					
					selectYN=st.nextToken();
					delInsYN=st.nextToken();
	
					if(selectYN.equals("Y") && (delInsYN.equals("N") || delInsYN.equals("Y")))
					{									
						stmtdel.setString(1,(String)tabdata.get("facilityID"));
						stmtdel.setString(2,splcode);
						stmtdel.setString(3,ServiceCode);
						ilStatus = stmtdel.executeUpdate();

						pslPrepStmt.setString(1,(String)tabdata.get("facilityID"));
						pslPrepStmt.setString(2,splcode);
						pslPrepStmt.setString(3,ServiceCode);
						pslPrepStmt.setString(4,addedById);
						pslPrepStmt.setString(5,modifiedAtWorkstation);
						pslPrepStmt.setString(6,modifiedFacilityId);
						pslPrepStmt.setString(7,addedById);
						pslPrepStmt.setString(8,modifiedAtWorkstation);
						pslPrepStmt.setString(9,modifiedFacilityId);
						ilStatus = pslPrepStmt.executeUpdate();
					}
					else if(selectYN.equals("N") && (delInsYN.equals("Y")|| delInsYN.equals("N")))
					{							
						pslPrepStmtdel.setString(1,(String)tabdata.get("facilityID"));
						pslPrepStmtdel.setString(2,splcode);
						pslPrepStmtdel.setString(3,ServiceCode);
						ilStatus=pslPrepStmtdel.executeUpdate();
					}

				}
				if(pslPrepStmt!=null) pslPrepStmt.close();
				if(pslPrepStmtdel!=null) pslPrepStmtdel.close();
			}

			String s20 = "";

			if(ilStatus == 1){
				con.commit();
				java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_INSERTED","SM" ) ;
				s20 = (String)message.get("message");
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(s20,"UTF-8" ) + "&err_value=1");
				message.clear();
			}else{
				con.rollback();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=1");
			}

			tabdata.clear();
		
			if(stmtdel!=null) stmtdel.close();
			if(pslPrepStmt!=null) pslPrepStmt.close();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
}