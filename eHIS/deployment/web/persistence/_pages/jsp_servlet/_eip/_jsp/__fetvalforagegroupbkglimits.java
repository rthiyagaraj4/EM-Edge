package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.text.*;

public final class __fetvalforagegroupbkglimits extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/FetValForAgeGroupBkgLimits.jsp", 1709117758943L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n\t<head>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t</head>\n\n\t<body class=\'message\' onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar obj= parent.frames[1].document.forms[0]\n\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' == \"M\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tif(obj.function_name.value!=\"modify\")\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tobj.max_male.value=\"\";\n\t\t\t\t\t\t\t\t\tobj.max_female.value=\"\";\n\t\t\t\t\t\t\t\t\tobj.max_total.value=\"\";\n\t\t\t\t\t\t\t\t\tobj.max_unknown.value=\"\";\n\t\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\t\tobj.max_male.readOnly=false;\n\t\t\t\t\t\t\t\tobj.max_female.readOnly=true;\n\t\t\t\t\t\t\t\tobj.max_total.readOnly = true;\n\t\t\t\t\t\t\t\tobj.max_unknown.readOnly=true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' ==\"F\")\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tif(obj.function_name.value!=\"modify\")\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tobj.max_male.value=\"\";\n\t\t\t\t\t\t\t\t\t\tobj.max_female.value=\"\";\n\t\t\t\t\t\t\t\t\t\tobj.max_total.value=\"\";\n\t\t\t\t\t\t\t\t\t\tobj.max_unknown.value=\"\";\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tobj.max_female.readOnly=false;\n\t\t\t\t\t\t\t\t\tobj.max_male.readOnly=true;\n\t\t\t\t\t\t\t\t\tobj.max_total.readOnly = true;\t\n\t\t\t\t\t\t\t\t\tobj.max_unknown.readOnly=true;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' ==\"U\")\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tif(obj.function_name.value!=\"modify\")\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tobj.max_male.value=\"\";\n\t\t\t\t\t\t\t\t\t\tobj.max_female.value=\"\";\n\t\t\t\t\t\t\t\t\t\tobj.max_total.value=\"\";\n\t\t\t\t\t\t\t\t\t\tobj.max_unknown.value=\"\";\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tobj.max_female.readOnly=true;\n\t\t\t\t\t\t\t\t\tobj.max_male.readOnly=true;\n\t\t\t\t\t\t\t\t\tobj.max_total.readOnly = true;\t\n\t\t\t\t\t\t\t\t\tobj.max_unknown.readOnly=false;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse \n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tif(obj.function_name.value!=\"modify\")\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tobj.max_male.value=\"\";\n\t\t\t\t\t\t\t\t\t\tobj.max_female.value=\"\";\n\t\t\t\t\t\t\t\t\t\tobj.max_total.value=\"\";\n\t\t\t\t\t\t\t\t\t\tobj.max_unknown.value=\"\";\n\t\t\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\t\t\tobj.max_female.readOnly=false;\n\t\t\t\t\t\t\t\t\tobj.max_male.readOnly=false;\n\t\t\t\t\t\t\t\t\tobj.max_total.readOnly = true;\t\n\t\t\t\t\t\t\t\t\tobj.max_unknown.readOnly=false;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar obj= parent.frames[1].document.forms[0]\n\t\t\t\t\t\tif(obj.function_name.value!=\"modify\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tobj.max_male.value=\"\";\n\t\t\t\t\t\t\tobj.max_female.value=\"\";\n\t\t\t\t\t\t\tobj.max_total.value=\"\";\n\t\t\t\t\t\t\tobj.max_unknown=\"\";\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tobj.max_male.readOnly=true;\n\t\t\t\t\t\tobj.max_female.readOnly=true;\n\t\t\t\t\t\tobj.max_unknown.readOnly=true;\n\t\t\t\t\t\tobj.max_total.readOnly = false;\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

			request.setCharacterEncoding("UTF-8"); 
			Connection con = null;
			Statement stmt = null;
			ResultSet rs =null;
			String gend="";
			String age_group = request.getParameter("age_grp_code");
		
            _bw.write(_wl_block4Bytes, _wl_block4);

		try{
			con = ConnectionManager.getConnection(request);;
			String sql = "select gender from am_age_group where age_group_code='"+age_group+"'";
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			if(rs!=null)
			{
				if(rs.next())
				{
					 gend=rs.getString(1);
					
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(gend));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(gend));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(gend));
            _bw.write(_wl_block8Bytes, _wl_block8);

				}
				else
				{
					
            _bw.write(_wl_block9Bytes, _wl_block9);

				}
			}

			if(rs!=null)	rs.close();
			if(stmt!=null)	stmt.close();				

		}catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}				
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}	
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
