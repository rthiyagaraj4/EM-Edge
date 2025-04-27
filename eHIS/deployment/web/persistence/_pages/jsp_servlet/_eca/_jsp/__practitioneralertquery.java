package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;

public final class __practitioneralertquery extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/eca/jsp/PractitionerAlertQuery.jsp", 1709115220843L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\t\t\tmsgCount = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n\t\t\t\t\t\tappl_user_id = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n\t\t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\t\tpractArryMessage[";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="] = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
	
	String sql = "";
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement stmt = null;
	
	String event_indicator = "";
	String event_title = "";
	String event_desc = "";
	String patient_id = "";
	String mesg_id = "";
	int msgCount = 0;
	String client_ip_address ="";

	String messageDetails = "";
	int i = 0;

	String funcId = request.getParameter("function_id");

	String appl_user_id=(String)session.getValue("login_user");

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	client_ip_address = p.getProperty("client_ip_address");


	System.out.println(" -----------------FUNCID ----------------------: "+funcId);

	System.out.println(" -----------------APPL_USER_ID ----------------------: "+appl_user_id);

	System.out.println(" -----------------CLIENT_IP_ADDRESS ----------------------: "+client_ip_address);


	if (funcId.equals("query"))
	{
		try
		{
			con		= ConnectionManager.getConnection(request);
			Map hash = (Map)obj.parseXMLString( request ) ;
			hash = (Map)hash.get("SEARCH") ;
			
			sql="Select count(*) msg_count from sm_user_notification where APPL_USER_ID = ? and EVENT_READ_YN = 'N' ";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,appl_user_id);
			rs=stmt.executeQuery();
			
			System.out.println(" -----------------MESSAGE COUNT QUERY--------------- "+sql);

			if (rs!=null){
				if(rs.next())
				{
					msgCount = rs.getInt("msg_count");
					System.out.println(" -----------------MSGCOUNT COUNT--------------- "+msgCount);
					
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(msgCount));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(appl_user_id));
            _bw.write(_wl_block4Bytes, _wl_block4);

				}
			}
			

			sql="Select EVENT_NORMALACY_IND, EVENT_TITLE, EVENT_DESC, PATIENT_ID, MESG_ID from sm_user_notification where APPL_USER_ID = ? and EVENT_MSG_SHOWN_YN = 'N' ";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,appl_user_id);
			rs=stmt.executeQuery();
			
			System.out.println(" -----------------MESSAGE DETAILS QUERY--------------- "+sql);
			if(rs!=null)
			{
				while(rs.next())
				{
					event_indicator = rs.getString("EVENT_NORMALACY_IND") == null ? "" : rs.getString("EVENT_NORMALACY_IND");
					event_title = rs.getString("EVENT_TITLE") == null ? "" : rs.getString("EVENT_TITLE");
					event_desc = rs.getString("EVENT_DESC") == null ? "" : rs.getString("EVENT_DESC");
					patient_id = rs.getString("PATIENT_ID") == null ? "" : rs.getString("PATIENT_ID");
					mesg_id = rs.getString("MESG_ID") == null ? "" : rs.getString("MESG_ID");

					messageDetails = event_indicator + "~" + event_title + "~" + event_desc + "~" + patient_id + "~" + mesg_id;
					
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(i));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(messageDetails));
            _bw.write(_wl_block4Bytes, _wl_block4);

					i++;
				}			
				
			}			
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}
		catch(Exception e){
			out.println("Exception"+e.toString());
		}
		finally
		{
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}
	}
	else if (funcId.equals("EVENT_MSG_SHOWN_YN"))
	{
		mesg_id = request.getParameter("messageId");

		System.out.println(" ----------------EVENT_MSG_SHOWN_YN MESG_ID ----------------------: "+mesg_id);

		try
		{
			con		= ConnectionManager.getConnection(request);
			Map hash = (Map)obj.parseXMLString( request ) ;
			hash = (Map)hash.get("SEARCH") ;

			sql="UPDATE SM_USER_NOTIFICATION set EVENT_MSG_SHOWN_YN = 'N' WHERE MESG_ID = ? AND APPL_USER_ID = ? ";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,mesg_id);
			stmt.setString(2,appl_user_id);
			i=stmt.executeUpdate();
			
			System.out.println(" -----------------I--------------- "+i);
			if(i == 1)
			{
				System.out.println(" -----------------SM_USER_NOTIFICATION EVENT_MSG_SHOWN_YN UPDATED SUCCESSFULLY ----------------------: ");
				con.commit();
			}			
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}
		catch(Exception e){
			out.println("Exception"+e.toString());
		}
		finally
		{
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}

	}
	else if (funcId.equals("EVENT_READ_YN"))
	{
		mesg_id = request.getParameter("messageId");

		System.out.println(" -----------------EVENT_READ_YN MESG_ID ----------------------: "+mesg_id);

		try
		{
			con		= ConnectionManager.getConnection(request);
			Map hash = (Map)obj.parseXMLString( request ) ;
			hash = (Map)hash.get("SEARCH") ;

			sql="UPDATE SM_USER_NOTIFICATION set EVENT_READ_YN = 'Y' WHERE MESG_ID = ? AND APPL_USER_ID = ? ";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,mesg_id);
			stmt.setString(2,appl_user_id);
			i=stmt.executeUpdate();
			
			System.out.println(" -----------------I--------------- "+i);
			if(i == 1)
			{
				System.out.println(" -----------------SM_USER_NOTIFICATION EVENT_READ_YN UPDATED SUCCESSFULLY ----------------------: ");
				con.commit();
			}			
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}
		catch(Exception e){
			out.println("Exception"+e.toString());
		}
		finally
		{
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}

	}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
