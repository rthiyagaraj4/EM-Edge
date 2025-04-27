package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __roompopulate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/RoomPopulate.jsp", 1727713057336L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t<script>\n\t\t\t\t\t\t\tvar n=parent.f_query_add_mod.document.getElementById(\'floor_code\').options.length;\n                                                     \n\t\t\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.f_query_add_mod.document.getElementById(\'floor_code\').remove(\"floor_code\");\t\t\t\t\n\t\t\t\t\t\t\t}\t\t\t\n\t\t\t\t\t\t\tvar tp =\" ---\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"--- \";\n\t\t\t\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\t\t\topt.text=tp;\n\t\t\t\t\t\t\topt.value=\"\";\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.getElementById(\'floor_code\').add(opt);\t\t\t\t\t\n\t\t\t\t</script>\t   \n\t\t\t\t\t\n\n\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<script>\n\t\t\t\t\t\t\tvar n=parent.f_query_add_mod.document.getElementById(\'bldng_code\').options.length;\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.f_query_add_mod.document.getElementById(\'bldng_code\').remove(\"floor_code\");\t\t\t\t\n\t\t\t\t\t\t\t}\t\t\t\n\t\t\t\t\t\t\tvar tp =\" ---\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"--- \";\n\t\t\t\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\t\t\topt.text=tp;\n\t\t\t\t\t\t\topt.value=\"\";\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.getElementById(\'bldng_code\').add(opt);\t\t\t\t\t\n\t\t\t\t</script>\t        \n\n\n\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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
	String bldngcode = request.getParameter("bldng_code")==null ? "" : request.getParameter("bldng_code");
	

	Connection con= null; //(Connection) session.getValue("connection");
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String operating_facilityID = request.getParameter("operating_facilityID");
		if(operating_facilityID == null) operating_facilityID="";
	
	String fieldName = request.getParameter("fieldName");
		if(fieldName == null) fieldName="";
	String bldng_code="",short_desc="";
	
	out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
	
		
	try{
			con = ConnectionManager.getConnection(request);
			if(fieldName.equals(""))
			{
				String popSql="Select floor_code,short_desc from am_bldng_floor where operating_facility_id =? and bldng_code = ? and eff_status='E' order by short_desc";
				pstmt 	= con.prepareStatement(popSql) ;
				pstmt.setString	(	1,	operating_facilityID		);
				pstmt.setString	(	2,	bldngcode		);
				rs = pstmt.executeQuery() ;
				String str1 = "";
				String str2 = "";

				if( rs != null ) 
				{	
			
            _bw.write(_wl_block6Bytes, _wl_block6);

				while( rs.next() ) 
						{
							str1 = rs.getString( "floor_code" ) ;
							str2 = rs.getString( "short_desc" );
							out.println(	"<script> var element = parent.f_query_add_mod.document.createElement('OPTION');"+
								"element.text = '"+str2+"';"+ 
								"element.value= '"+str1+"';"+
								"parent.f_query_add_mod.document.room_form.floor_code.add(element);</script>");
						}
					}
					if(rs!=null) 	rs.close();
	                if(pstmt!=null) 	pstmt.close();
			}
			else
			{
				String strStmt = "select bldng_code,short_desc from am_bldng where eff_status='E'and operating_facility_id =? order by short_desc";
				pstmt 	= con.prepareStatement( strStmt ) ;
				pstmt.setString	(	1,	operating_facilityID		);
				rs = pstmt.executeQuery() ;
				if( rs != null ) 
				{	
			
            _bw.write(_wl_block7Bytes, _wl_block7);

				while( rs.next() ) 
						{
							bldng_code = rs.getString( "bldng_code" ) ;
							short_desc = rs.getString( "short_desc" );
							out.println(	"<script> var element = parent.f_query_add_mod.document.createElement('OPTION');"+
								"element.text = '"+short_desc+"';"+ 
								"element.value= '"+bldng_code+"';"+
								"parent.f_query_add_mod.document.room_form.bldng_code.add(element);</script>");
						}
					}			
			
			}
			if(rs!=null) 	rs.close();
	        if(pstmt!=null) 	pstmt.close();
				out.println("</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>");		
	}
		catch(Exception e) { 
		//out.println(e.toString());
			e.printStackTrace();
		}

		finally 
			{
				try
				{
				  if (pstmt != null)	pstmt.close();
				  if (rs != null)		rs.close();
				}
				catch(Exception e)
				{}
		  ConnectionManager.returnConnection(con,request);
		}


            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
