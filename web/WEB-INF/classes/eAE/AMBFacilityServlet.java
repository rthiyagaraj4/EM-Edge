/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/****** Last Modified Date Time 4/13/2009 11:25 AM *****/
package eAE;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;

import webbeans.eCommon.*;

public class AMBFacilityServlet extends javax.servlet.http.HttpServlet
{
    PrintWriter out;
    java.util.Properties p;

    String facility_id;
    String amb_prefix_ind;
    String amb_user_prefix;
    String start_case_no;
    String end_case_no;
    String next_case_no;
    String amb_mileage_uom;
    String amb_dflt_dys_behind;
    String amb_dflt_dys_ahead;
    String print_trip_sheet_yn;
    String print_trip_sheet_comp_yn;
    String virt_keypad_display_yn;

    String client_ip_address;
    String user_name;
    String ws_no;
    String locale;

    HttpSession session;

    public void init(ServletConfig config)throws ServletException
    {
        super.init(config);
    }

    public synchronized void doPost(HttpServletRequest request,
        HttpServletResponse res)throws javax.servlet.ServletException,
        IOException
    {
        session = request.getSession(false);
        this.p = (java.util.Properties)session.getValue("jdbc");
        this.facility_id = checkForNull((String)session.getValue("facility_id"));
		this.locale = p.getProperty("LOCALE");
        this.ws_no = p.getProperty("client_ip_address");
        this.user_name = checkForNull((String)session.getValue("login_user"));
        this.amb_prefix_ind = checkForNull((String)request.getParameter(
            "amb_prefix_ind"));
        this.amb_user_prefix = checkForNull((String)request.getParameter(
            "amb_user_prefix"));
        this.start_case_no = checkForNull((String)request.getParameter(
            "start_case_no"));
        this.end_case_no = checkForNull((String)request.getParameter(
            "end_case_no"));
        this.next_case_no = checkForNull((String)request.getParameter(
            "next_case_no"));
        this.amb_mileage_uom = checkForNull((String)request.getParameter(
            "amb_mileage_uom"));
        this.amb_dflt_dys_behind = checkForNull((String)request.getParameter(
            "amb_dflt_dys_behind"));
        this.amb_dflt_dys_ahead = checkForNull((String)request.getParameter(
            "amb_dflt_dys_ahead"));
		this.print_trip_sheet_yn = checkForNull((String)request.getParameter(
            "print_trip_sheet_yn"),"N");
        this.print_trip_sheet_comp_yn = checkForNull((String)request.getParameter(
            "print_trip_sheet_comp_yn"),"N");
        this.virt_keypad_display_yn = checkForNull((String)request.getParameter(
            "virt_keypad_display_yn"),"N");

        try
        {
            request.setCharacterEncoding("UTF-8");
            res.setContentType("text/html;charset=UTF-8");
            this.out = res.getWriter();
            String operation = request.getParameter("function_name");
            if (operation.equals("insert"))
                insertAmbParam(request, res);
            if (operation.equals("modify"))
                modifyAmbParam(request, res);
        }
        catch (Exception e)
        {
            out.println(e.toString());
        }
    }

    private void modifyAmbParam(HttpServletRequest request, HttpServletResponse
        res)
    {

        Connection con = null;
        PreparedStatement pstmt = null;
        int updated = 0;
       /* String error = "";*/
        String error_value = "0";
        try
        {
            con = ConnectionManager.getConnection(request);

            pstmt = con.prepareStatement(
                "update ae_amb_param_for_facility set amb_prefix_ind=?, amb_user_prefix=?, start_case_no=?, next_case_no=?, end_case_no=?, amb_mileage_uom=?, added_by_id=?, added_date=sysdate, added_at_ws_no=?, added_facility_id=?, modified_by_id=?, modified_date=sysdate, modified_at_ws_no=?, modified_facility_id=?,amb_dflt_dys_behind=?,amb_dflt_dys_ahead=?, print_trip_sheet_yn=?,print_trip_sheet_comp_yn=?,virt_keypad_display_yn=? where facility_id =?");

           /* out.println("Modify mode " + facility_id + " " + amb_prefix_ind + 
                " " + amb_user_prefix + " " + start_case_no + " " +
                next_case_no + " " + end_case_no + " " + amb_mileage_uom + " " 
                + amb_dflt_dys_behind + " " + amb_dflt_dys_ahead + " " +
                user_name + " " + ws_no + " " + facility_id + " " + user_name);
			*/
		/*	 System.out.println(facility_id + " " + amb_prefix_ind + " " +
                amb_user_prefix + " " + start_case_no + " " + next_case_no + 
                " " + end_case_no + " " + amb_mileage_uom + " " +
                amb_dflt_dys_behind + " " + amb_dflt_dys_ahead + " " +
                user_name + " " + ws_no + " " + facility_id + " " + user_name+" "+print_trip_sheet_yn+" "+print_trip_sheet_comp_yn+" "+virt_keypad_display_yn);
		*/
            pstmt.setString(1, amb_prefix_ind);
            pstmt.setString(2, amb_user_prefix);
            if (start_case_no.equals(""))
                pstmt.setInt(3, 0);
            else
                pstmt.setInt(3, Integer.parseInt(start_case_no));
            pstmt.setString(4, next_case_no);
            if (end_case_no.equals(""))
                pstmt.setInt(5, 0);
            else
                pstmt.setInt(5, Integer.parseInt(end_case_no));
            pstmt.setString(6, amb_mileage_uom);
            pstmt.setString(7, user_name);
            pstmt.setString(8, ws_no);
            pstmt.setString(9, facility_id);
            pstmt.setString(10, user_name);
            pstmt.setString(11, ws_no);
            pstmt.setString(12, facility_id);
            if (amb_dflt_dys_behind.equals(""))
                pstmt.setInt(13, 0);
            else
                pstmt.setInt(13, Integer.parseInt(amb_dflt_dys_behind));
            if (amb_dflt_dys_ahead.equals(""))
                pstmt.setInt(14, 0);
            else
                pstmt.setInt(14, Integer.parseInt(amb_dflt_dys_ahead));
			pstmt.setString(15, print_trip_sheet_yn);
            pstmt.setString(16, print_trip_sheet_comp_yn);
            pstmt.setString(17, virt_keypad_display_yn);
            pstmt.setString(18, facility_id);
            updated = pstmt.executeUpdate();
            con.commit();

            if (updated > 0)
            {
               /* res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +
                    java.net.URLEncoder.encode(
                    "APP-SM0071 Operation Completed Successfully ....", "UTF-8")
                    + "&err_value=1");*/
					java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_MODIFIED", "SM");
					String error = ((String) message.get("message"));
					message.clear();
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +
                    java.net.URLEncoder.encode(error, "UTF-8")
                    + "&err_value=1");
            }
            else
            {
                res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +
                    java.net.URLEncoder.encode("Error inserting record", 
                    "UTF-8") + "&err_value=" + error_value);
            }
            if (pstmt != null)
                pstmt.close();
        }
        catch (Exception e)
        {
            /* out.println(
                "<script>parent.frames(2).location.href='../eCommon/jsp/error.jsp?err_num=" + e.toString() + "<br>'</script>"); */
            e.printStackTrace();
        }
        finally
        {

            if (con != null)
                ConnectionManager.returnConnection(con, request);
        }

    }

    private void insertAmbParam(HttpServletRequest request, HttpServletResponse
        res)
    {
        Connection con = null;
        PreparedStatement pstmt = null;
        int updated = 0;
       /* String error = "";*/
        String error_value = "0";
        try
        {
            con = ConnectionManager.getConnection(request);

            pstmt = con.prepareStatement(
                "insert into ae_amb_param_for_facility(facility_id, amb_prefix_ind, amb_user_prefix, start_case_no, next_case_no, end_case_no, amb_mileage_uom, amb_dflt_dys_behind, amb_dflt_dys_ahead,print_trip_sheet_yn,print_trip_sheet_comp_yn,virt_keypad_display_yn, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)");
          /* System.out.println(facility_id + " " + amb_prefix_ind + " " +
                amb_user_prefix + " " + start_case_no + " " + next_case_no + 
                " " + end_case_no + " " + amb_mileage_uom + " " +
                amb_dflt_dys_behind + " " + amb_dflt_dys_ahead + " " +
                user_name + " " + ws_no + " " + facility_id + " " + user_name+" "+print_trip_sheet_yn+" "+print_trip_sheet_comp_yn+" "+virt_keypad_display_yn);
*/
            pstmt.setString(1, facility_id);
            pstmt.setString(2, amb_prefix_ind);
            pstmt.setString(3, amb_user_prefix);
            if (start_case_no.equals(""))
                pstmt.setInt(4, 0);
            else
                pstmt.setInt(4, Integer.parseInt(start_case_no));
            pstmt.setString(5, next_case_no);
            if (end_case_no.equals(""))
                pstmt.setInt(6, 0);
            else
                pstmt.setInt(6, Integer.parseInt(end_case_no));
            pstmt.setString(7, amb_mileage_uom);
            if (amb_dflt_dys_behind.equals(""))
                pstmt.setInt(8, 0);
            else
                pstmt.setInt(8, Integer.parseInt(amb_dflt_dys_behind));
            if (amb_dflt_dys_ahead.equals(""))
                pstmt.setInt(9, 0);
            else
                pstmt.setInt(9, Integer.parseInt(amb_dflt_dys_ahead));

			pstmt.setString(10, print_trip_sheet_yn);
			pstmt.setString(11, print_trip_sheet_comp_yn);
			pstmt.setString(12, virt_keypad_display_yn);
            pstmt.setString(13, user_name);
            pstmt.setString(14, ws_no);
            pstmt.setString(15, facility_id);
            pstmt.setString(16, user_name);
            pstmt.setString(17, ws_no);
            pstmt.setString(18, facility_id);

            updated = pstmt.executeUpdate();
            con.commit();
            if (updated > 0)
            {
              /*  res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +
                    java.net.URLEncoder.encode(
                    "APP-SM0070 Operation Completed Successfully ....", "UTF-8")
                    + "&err_value=1");*/
					java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED", "SM");
					String error = ((String) message.get("message"));
					message.clear();
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +
                    java.net.URLEncoder.encode(error, "UTF-8")
                    + "&err_value=1");
            }
            else
            {
                res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +
                    java.net.URLEncoder.encode("Error inserting record", 
                    "UTF-8") + "&err_value=" + error_value);
            }
            if (pstmt != null)
                pstmt.close();

        }

        catch (Exception e)
        {
            /* out.println(
                "<script>parent.frames(2).location.href='../eCommon/jsp/error.jsp?err_num=" + e.toString() + "<br>'</script>"); */
            e.printStackTrace();
        }
        finally
        {
            if (con != null)
                ConnectionManager.returnConnection(con, request);
        }
    }

    private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}
