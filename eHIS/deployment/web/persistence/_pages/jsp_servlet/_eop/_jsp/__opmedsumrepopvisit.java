package jsp_servlet._eop._jsp;

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
import java.util.*;
import com.ehis.util.*;

public final class __opmedsumrepopvisit extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/OpMedSumRepopVisit.jsp", 1709119451257L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t<script>\n\t\tvar n=parent.frames[1].document.forms[0].opvisit.options.length;\n\t\tfor(var i=0;i<n;i++)\n\t\t{\n\t\t\tparent.frames[1].document.forms[0].opvisit.remove(\"opvisit\");\t\n\t\t}\n\t\tvar tp =\" -------- \"+getLabel(\"Common.defaultSelect.Label\",\"Common\")+\" -------- \";\n\t\tvar opt=parent.frames[1].document.createElement(\"OPTION\");\n\t\topt.text=tp;\n\t\topt.value=\"\";\n\t\tparent.frames[1].document.forms[0].opvisit.add(opt);\n\t</script>\n\t\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rset=null;

	StringBuffer sql = new StringBuffer();

	String Facility_Id = (String) session.getValue("facility_id");
	String loc_code = request.getParameter("locn_code");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	try
	{
		conn=ConnectionManager.getConnection(request);
		if( loc_code == null || loc_code.equals("") )
		{
		
		/* The following sql query is used to select the Visit type based on various Clinic_code and facilities  ---  Srijagadeesh */

			sql =sql.append( "select visit_type_code,visit_type_short_desc from op_visit_type_for_clinic_vw where clinic_code = '"+loc_code+"' and facility_id = '"+Facility_Id+"' order by 2");
		}
		else
		{
			if (loc_code.equals("*ALL") ) 
			{
				sql = sql.append("select '*A' visit_type_code,'*ALL' visit_type_short_desc from dual union ");
				sql =sql.append("select visit_type_code,visit_type_short_desc from op_visit_type_for_clinic_vw where facility_id = '"+Facility_Id+"' order by 2");
			}
			else
			{
				sql =sql.append( "select '*A' visit_type_code,'*ALL' visit_type_short_desc from dual union ");
				sql =sql.append( "select visit_type_code,visit_type_short_desc from op_visit_type_for_clinic_vw where clinic_code = '"+loc_code+"' and facility_id = '"+Facility_Id+"' order by 2");
			}
		}

			pstmt = conn.prepareStatement(sql.toString());
			rset = pstmt.executeQuery();
			String a1="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"
			+"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey();'></body></html>";
			out.println(a1);

            _bw.write(_wl_block5Bytes, _wl_block5);
	
		if(rset != null)
		{	
			while( rset.next() ) 
			{
				String str1 = rset.getString("visit_type_code") ;
				String str2 = rset.getString("visit_type_short_desc");
	
				out.println("<script>var element = parent.f_query_add_mod.document.createElement('OPTION');"+
					"element.text = '"+str2+"';"+ 
					"element.value= '"+str1+"';"+
					"parent.f_query_add_mod.document.forms[0].opvisit.add(element);</script>");
			}
		}
	}
	catch(Exception e){out.println("Excep VISIT:"+e);}
	finally
	{
		if (pstmt != null) pstmt.close();
		if (rset != null)   rset.close();
		if (conn!=null) ConnectionManager.returnConnection(conn,request);
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
