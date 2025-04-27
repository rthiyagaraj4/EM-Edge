package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __getdeptroom extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/GetDeptRoom.jsp", 1711622826250L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar tp =\"-----\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"-----\";\n\t\t\t\t\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\topt.text=tp;\n\t\t\t\t\t\t\t\topt.value=\"\";\n\n\t\t\t\t\t\t\t\tparent.f_query_add_mod.document.getElementById(\'service\').add(opt);\n\t\t\t\t\t\t</script>\n\n\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t\t\t\t\t\t<script>\n\n\t\t\t\t\t\t\t\tvar scode=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\t\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tif (scode==temp)\n\t\t\t\t\t\t\t\t\topt.selected=true;\n\t\t\t\t\t\t\t\tparent.f_query_add_mod.document.getElementById(\'service\').add(opt);\n\n\t\t\t\t\t\t\t</script>\n\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar tp =\"-----\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"-----\";\n\t\t\t\t\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\topt.text=tp;\n\t\t\t\t\t\t\t\topt.value=\"\";\n\n\t\t\t\t\t\t\t\tparent.f_query_add_mod.document.getElementById(\'room\').add(opt);\n\t\t\t\t\t\t</script>\n\n\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\t\t\t\t\t\t\t<script>\n\n\t\t\t\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\t\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\t\t\tparent.f_query_add_mod.document.getElementById(\'room\').add(opt);\n\n\t\t\t\t\t\t\t</script>\n\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar tp =\"-----\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"-----\";\n\t\t\t\t\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\topt.text=tp;\n\t\t\t\t\t\t\t\topt.value=\"\";\n\n\t\t\t\t\t\t\t\tparent.f_query_add_mod.document.getElementById(\'department\').add(opt);\n\t\t\t\t\t\t</script>\n\n\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\t\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\t\t\tparent.f_query_add_mod.document.getElementById(\'department\').add(opt);\n\n\t\t\t\t\t\t\t</script>\n\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

			request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			Connection con = null;
			Statement stmt = null;
			PreparedStatement pstmt = null;
			PreparedStatement pstmt1 = null;
			Statement stmt1 = null;
			ResultSet rset=null;
			ResultSet rset1=null;
			
			String servicecode="";
			String servicedesc="";
			String common=request.getParameter("Common_Text");
			String scode = request.getParameter("Service_code");
			String facilityId=(String)session.getValue("facility_id");
			String chksrc=request.getParameter("Chksrc");
			String operating_facilityID = request.getParameter("operating_facilityID");
			if(operating_facilityID == null) operating_facilityID="";
			String short_desc="",room_num ="";
			String dept_code="", dept_short_desc ="";
			
			if(scode!=null)
				scode=scode.trim();

		try{
			con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			stmt1 = con.createStatement();
		
			if(operating_facilityID.equals(""))
			{
			
			if(chksrc.trim().equals("department"))
			{
                        
						//String sql = "SELECT service_short_desc, service_code from am_facility_service_vw where eff_status='E' and operating_facility_id='"+facilityId+"' "+" and dept_code='"+common.trim()+"' order by service_short_desc" ;
						//rset = stmt.executeQuery(sql);
						
						String sql = "SELECT service_short_desc, service_code from am_facility_service_vw where eff_status='E' and operating_facility_id=? "+" and dept_code=? order by service_short_desc" ;
						pstmt   = con.prepareStatement(sql);
						pstmt.setString	(	1,	facilityId );
						pstmt.setString	(	2,	common.trim() );
						rset		 = pstmt.executeQuery();

						out.println("<html><HEAD>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");
						if(rset != null)
						{
			
            _bw.write(_wl_block6Bytes, _wl_block6);

						while( rset.next() )
						{
							servicecode=rset.getString("service_code");
							servicedesc=rset.getString("service_short_desc");

			
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(scode));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(servicecode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(servicedesc));
            _bw.write(_wl_block10Bytes, _wl_block10);

						}
						}
						if(rset!=null) rset.close();
                        if(stmt!=null) stmt.close();
                        if(pstmt!=null) pstmt.close();
						out.println("</form></body></html>");
			}
			
			}
			else
			{
				
				String sql = "select short_desc,room_num from am_facility_room where operating_facility_id=? and eff_status='E' order by short_desc";
				String sql1=" SELECT dept_code, dept_short_desc from am_facility_dept_vw where operating_facility_id=? and eff_status='E' order by Dept_Short_desc " ;
				stmt = con.createStatement();
				//rset = stmt.executeQuery(sql);
				//rset1 = stmt1.executeQuery(sql1);
				
				pstmt   = con.prepareStatement(sql);
				pstmt.setString	(	1,	operating_facilityID );
				rset		 = pstmt.executeQuery();
				
				pstmt1   = con.prepareStatement(sql1);
				pstmt1.setString	(	1,	operating_facilityID );
				rset1		 = pstmt1.executeQuery();
				
				out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");
				if(rset != null)
				{
			
            _bw.write(_wl_block11Bytes, _wl_block11);

						while( rset.next() )
						{
							room_num=rset.getString("room_num");
							short_desc=rset.getString("short_desc");

			
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);

						}
						
					}
					
				if(rset1 != null)
				{
			
            _bw.write(_wl_block14Bytes, _wl_block14);

						while( rset1.next() )
						{
							dept_code=rset1.getString("dept_code");
							dept_short_desc=rset1.getString("dept_short_desc");

			
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(dept_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dept_short_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);

						}
						
					}					
					
					
						out.println("</form></body></html>");
				}			
			
			}
		catch(Exception e) { out.println(e.toString());}

		finally {
			try{
		  if (rset != null)   rset.close();
		  if (rset1!= null)   rset1.close();
		  if (stmt != null)   stmt.close();
		  if (stmt1 != null)  stmt1.close();
		  if (pstmt!=null) pstmt.close();
		  if (pstmt1!=null) pstmt1.close();
			}
			catch(Exception e)
			{}
		  ConnectionManager.returnConnection(con,request);

		}

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
