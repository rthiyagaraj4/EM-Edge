/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAE;

import com.ehis.eslp.ServiceLocator;
import java.io.*;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.sql.*;
import java.util.HashMap;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;

public class AMBVehicleServlet extends HttpServlet 
{
    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
		PrintWriter out = null;
	
        try
        {
            res.setContentType("text/html");
            out = res.getWriter();

			String mode = req.getParameter("mode") != null ? req.getParameter("mode") : "";
            
			if(mode.trim().equalsIgnoreCase("insert"))
                insert(req, res, out);
            if(mode.trim().equalsIgnoreCase("update"))
                modify(req, res, out);
           
        }
        catch(Exception e)
        {
            out.println(e.toString());
            System.out.println("Exception 1 from amb vehicle.java : "+e.toString());
			e.printStackTrace(System.err);
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
		PrintWriter out = null;
        try
        {
			out = res.getWriter();
            doPost(req, res);
        }
        catch(Exception e)
        {
            out.println("Exception in invoking doPost Method");
            System.out.println("Exception in invoking doPost Method of NoteDisclaimerServlet.java : "+e.toString());
			e.printStackTrace(System.err);
        }
    }


    private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
    {
		Properties p;
		HashMap tabdata;	

		String amb_veh_id			=	"",						amb_veh_desc				=	"";
		String amb_veh_regnno		=	"",						amb_vehicle_type				=	"";
		String amb_veh_model_no		=	"",						amb_veh_DOM					=	"";
		String amb_veh_remarks		=	"",						eff_status					=	"";
		String amb_veh_location		=	"";
//		mode						=	"";
		String facilityId			=	"",						client_ip_address			=	"";
		String addedById			=	"",						modifiedById				=	"";
		String addedAtWorkstation	=	"",						modifiedAtWorkstation		=	"";
		String sql					=	"",						errorMsg					=	"";
		String s2					=	"0",						amb_user_prefix				=	"";
		String amb_start_case_no	=	"",						amb_end_case_no				=	"";
		String amb_mileage_uom	=	""; 
		int count=0;
		String locale;


		int nUpd					=	0;

		int nStart,nEnd;

		Connection	con				=	null;

		PreparedStatement pstmt		=	null,pstmt1=null;
		ResultSet rs1=null;

		HttpSession session;

		session		= req.getSession(false);

		p						= (Properties)session.getValue("jdbc");
		facilityId				= (String)session.getValue("facility_id");
		client_ip_address		= p.getProperty("client_ip_address");
		modifiedById			= checkForNull((String) p.getProperty("login_user"));
		modifiedAtWorkstation	= checkForNull(client_ip_address);
		locale = p.getProperty("LOCALE");
		tabdata = new HashMap();

		addedById			= checkForNull((String) p.getProperty("login_user"));
        addedAtWorkstation	= checkForNull(client_ip_address);

		amb_user_prefix				= checkForNull(req.getParameter("amb_user_prefix"));

		try
        {
			amb_veh_id					= checkForNull(req.getParameter("amb_veh_id"));
			amb_veh_desc				= checkForNull(req.getParameter("amb_veh_desc"));
			amb_veh_regnno				= checkForNull(req.getParameter("amb_veh_regnno"));
			amb_vehicle_type			= checkForNull(req.getParameter("amb_vehicle_type"));
			amb_veh_model_no			= checkForNull(req.getParameter("amb_veh_model_no"));
			amb_veh_DOM					= checkForNull(req.getParameter("amb_veh_DOM"));
			amb_veh_remarks				= checkForNull(req.getParameter("amb_veh_remarks"));
			amb_veh_location			= checkForNull(req.getParameter("amb_veh_location"));
			eff_status					= checkForNull(req.getParameter("eff_status"));
			if(eff_status.equals("")) eff_status="D";
			amb_start_case_no			= checkForNull(req.getParameter("amb_start_case_no"));
			amb_end_case_no				= checkForNull(req.getParameter("amb_end_case_no"));
			amb_mileage_uom				= checkForNull(req.getParameter("amb_mileage_uom"));
			
			con = ConnectionManager.getConnection(req);
			pstmt1	=	con.prepareStatement("select count(*) cnt from AE_AMB_VEHICLE where facility_id=? and AMB_VEHICLE_ID=?");
			pstmt1.setString(1,facilityId);
			pstmt1.setString(2,amb_veh_id);
			rs1=pstmt1.executeQuery();
			if(rs1!=null && rs1.next())
			count =rs1.getInt("cnt");
			if(count<1){
			
				if(amb_user_prefix.equals("A") )
					sql		=	"INSERT INTO AE_AMB_VEHICLE (FACILITY_ID,AMB_VEHICLE_ID,AMB_VEHICLE_NAME,AMB_REGN_NO,AMB_MODEL_NO,AMB_DATE_MANUFCT,AMB_REMARKS,EFF_STATUS,AMB_VEHICLE_TYPE,AMB_LOCATION,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,START_CASE_NO,NEXT_CASE_NO,END_CASE_NO,AMB_MILEAGE_UOM) VALUES (?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY'),?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?)";
				else
					sql		=	"INSERT INTO AE_AMB_VEHICLE (FACILITY_ID,AMB_VEHICLE_ID,AMB_VEHICLE_NAME,AMB_REGN_NO,AMB_MODEL_NO,AMB_DATE_MANUFCT,AMB_REMARKS,EFF_STATUS,AMB_VEHICLE_TYPE,AMB_LOCATION,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,AMB_MILEAGE_UOM) VALUES (?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY'),?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)";
				

				pstmt	=	con.prepareStatement(sql);	
				pstmt.setString(1,facilityId);
				pstmt.setString(2,amb_veh_id);
				pstmt.setString(3,amb_veh_desc);
				pstmt.setString(4,amb_veh_regnno);
				pstmt.setString(5,amb_veh_model_no);
				pstmt.setString(6,amb_veh_DOM);
				pstmt.setString(7,amb_veh_remarks);
				pstmt.setString(8,eff_status);
				pstmt.setString(9,amb_vehicle_type);
				pstmt.setString(10,amb_veh_location);
				pstmt.setString(11,addedById);			// after this added date 
				pstmt.setString(12,addedAtWorkstation);
				pstmt.setString(13,facilityId);
				pstmt.setString(14,modifiedById);			// AFTER THIS MODIF DATE
				pstmt.setString(15,modifiedAtWorkstation);
				pstmt.setString(16,facilityId);

				if(amb_user_prefix.equals("A") )
				{
					if(!amb_start_case_no.equals("") )
						nStart		= Integer.parseInt(amb_start_case_no);
					else
						nStart	=	0;

					if(!amb_end_case_no.equals("") )
						nEnd		= Integer.parseInt(amb_end_case_no);
					else
						nEnd		=	0;

					pstmt.setInt(17,nStart);
					pstmt.setInt(18,nStart);
					pstmt.setInt(19,nEnd);
					pstmt.setString(20,amb_mileage_uom);
				}else{
					pstmt.setString(17,amb_mileage_uom);
				}
				nUpd	=		pstmt.executeUpdate();

				if(nUpd >= 0)
				{
					con.commit();
					//errorMsg	=	"APP-SM0071 Operation Completed Successfully......";
					java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED", "SM");
					errorMsg = ((String) message.get("message"));
					message.clear();
					s2="1";
				}
				else
				{
					con.rollback();
					errorMsg	=	"APP-AE902 Insertion Failed......";
				}
			}else{
	
				//errorMsg="APP-SM0095 Record Already Exists...";
					java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_EXISTS", "SM");
					errorMsg = ((String) message.get("message"));
					message.clear();
			}

//			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(errorMsg) + "&err_value=" + s2);
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg ) + "&err_value=" + s2 );
        }
        catch(Exception e)
        {
            //out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : " + e.toString());
            System.out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : " + e.toString());
			e.printStackTrace(System.err);
        }
		finally
		{
				try
			{
				tabdata.clear();
				if (pstmt != null) pstmt.close();
				if (pstmt1 != null) pstmt1.close();	
				if (rs1 != null) rs1.close();	
				if(con != null) ConnectionManager.returnConnection(con,req);
			}
			catch (Exception e1)
			{
			}
		}
    }

	 private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
    {
        Properties p;
		HashMap tabdata;	

		String amb_veh_id			=	"",						amb_veh_desc				=	"";
		String amb_veh_regnno		=	"";
//		amb_vehicle_type				=	"";
		String amb_veh_model_no		=	"",						amb_veh_DOM					=	"";
		String amb_veh_remarks		=	"",						eff_status					=	"";
		String amb_veh_location		=	"";
//		mode						=	"";
		String facilityId			=	"",						client_ip_address			=	"";
		String addedById			=	"",						modifiedById				=	"";
		String addedAtWorkstation	=	"",						modifiedAtWorkstation		=	"";
		String sql					=	"",						errorMsg					=	"";
		String s2					=	"0",amb_mileage_uom="";
		String locale;

		int nUpd					=	0;

		Connection	con				=	null;

		PreparedStatement pstmt		=	null;

		HttpSession session;
		
		session					= req.getSession(false);
		p						= (Properties)session.getValue("jdbc");
		facilityId				= (String)session.getValue("facility_id");
		client_ip_address		= p.getProperty("client_ip_address");
		modifiedById			= p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
		modifiedAtWorkstation	= client_ip_address != null ? client_ip_address : "";
		locale = p.getProperty("LOCALE");
		tabdata = new HashMap();

		addedById				= p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
        addedAtWorkstation		= client_ip_address != null ? client_ip_address : "";

		try
        {
			con = ConnectionManager.getConnection(req);

			sql	=	"UPDATE AE_AMB_VEHICLE SET AMB_VEHICLE_NAME = ?,AMB_REGN_NO = ?,AMB_MODEL_NO = ?,AMB_DATE_MANUFCT = TO_DATE(?,'DD/MM/YYYY'),AMB_REMARKS = ?,AMB_MILEAGE_UOM=?,EFF_STATUS = ? ,AMB_LOCATION = ? ,MODIFIED_BY_ID = ?,MODIFIED_DATE = SYSDATE,MODIFIED_AT_WS_NO = ?,MODIFIED_FACILITY_ID = ? WHERE FACILITY_ID = ? AND AMB_VEHICLE_ID = ?";

			// Please modify only the above columns, rest of the columns are not modifiable

			amb_veh_id					= checkForNull(req.getParameter("amb_veh_id"));
			amb_veh_desc				= checkForNull(req.getParameter("amb_veh_desc"));
			amb_veh_regnno				= checkForNull(req.getParameter("amb_veh_regnno"));
			amb_veh_model_no			= checkForNull(req.getParameter("amb_veh_model_no"));
			amb_veh_DOM					= checkForNull(req.getParameter("amb_veh_DOM"));
			amb_veh_remarks				= checkForNull(req.getParameter("amb_veh_remarks"));
			amb_veh_location			= checkForNull(req.getParameter("amb_veh_location"));
			amb_mileage_uom			= checkForNull(req.getParameter("amb_mileage_uom"));
			eff_status					= checkForNull(req.getParameter("eff_status"));
			if(eff_status.equals("")) eff_status="D";

			pstmt	=	con.prepareStatement(sql);

			pstmt.setString(1,amb_veh_desc);
			pstmt.setString(2,amb_veh_regnno);
			pstmt.setString(3,amb_veh_model_no);
			pstmt.setString(4,amb_veh_DOM);
			pstmt.setString(5,amb_veh_remarks);
			pstmt.setString(6,amb_mileage_uom);
			pstmt.setString(7,eff_status);
			pstmt.setString(8,amb_veh_location);
			pstmt.setString(9,modifiedById);
			pstmt.setString(10,modifiedAtWorkstation);
			pstmt.setString(11,facilityId);
			pstmt.setString(12,facilityId);
			pstmt.setString(13,amb_veh_id);

			nUpd	=	pstmt.executeUpdate();

			if(nUpd > 0)
			{
				con.commit();
				//errorMsg	=	"APP-AE901 Operation Completed Successfully......";
				java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_MODIFIED", "SM");
				errorMsg = ((String) message.get("message"));
				message.clear();
				s2="1";
			}
			else
			{
				con.rollback();
				errorMsg	=	"APP-AE902 Updation failed......";
			}

//			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(errorMsg) + "&err_value=" + s2);
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg ) + "&err_value=" + s2 );
        }
        catch(Exception exception)
        {
        //    out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
            System.out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
			exception.printStackTrace(System.err);
        }
		finally
		{
			try
			{
				tabdata.clear();
				if (pstmt != null) pstmt.close();				
				if(con != null) ConnectionManager.returnConnection(con,req);
			}
			catch (Exception e2)
			{
			}

	
		}
    }

	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
}
