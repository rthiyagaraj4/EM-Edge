package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;

public final class __fetchvalforstatisticsgrpforprogram extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/FetchValForStatisticsGrpForProgram.jsp", 1709114003320L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<script>\n\t//alert(parent.frames[1].document.forms[0].Location.options.length);\n\tvar n=parent.frames[1].document.forms[0].program.options.length;\n\t\n\tfor(var i=0;i<n;i++)\n\t{\n\t\tparent.frames[1].document.forms[0].program.remove(\"Program\");\n\t}\n\t//var tp =\" ----- \"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ----- \";\n\tvar tp =\"----------\"+ new Array(parent.frames[1].getLabel(\"Common.defaultSelect.label\",\"Common\"))+\"----------\";\n\tvar opt=parent.frames[1].document.createElement(\"OPTION\");\n\topt.text=tp;\n\topt.value=\"\";\n\tparent.frames[1].document.forms[0].program.add(opt);\n\n\t</script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<script>\n\t\tvar element = parent.frames[1].document.createElement(\'OPTION\');\n\t\telement.value=  \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\telement.text= \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\tparent.frames[1].document.forms[0].program.add(element);\n\t</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

//String facility_Id = (String) session.getValue("facility_id");
request.setCharacterEncoding("UTF-8");
String Program_type = request.getParameter("Prog_type");
String Module_id = request.getParameter("Mod_id");

Connection conn = null;
Statement stmt=null;
ResultSet rset=null;
String sql1="";
String sql2="";

try
{
	conn = ConnectionManager.getConnection(request);
	stmt = conn.createStatement();
	if(Program_type.equals("F"))
	{
		sql1 = "SELECT function_name,function_id from SM_FUNCTION where module_id='"+Module_id+"' order by function_name ";
		rset = stmt.executeQuery(sql1);
			
	}
	else if(Program_type.equals("R"))
	{
		sql2 = "SELECT report_desc,report_id from SM_REPORT where module_id='"+Module_id+"' order by report_desc ";
		rset = stmt.executeQuery(sql2);
		
	}

String a1="<html><head>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"+"</script><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>";

out.println(a1);
/*out.println("<html><head>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"+"</script></head><body CLASS='MESSAGE'>");*/


            _bw.write(_wl_block6Bytes, _wl_block6);
	if(rset != null)
	{
	String desc="";
	String code="";
	
		while( rset.next() )
		{
			if(Program_type.equals("F"))
			{
			 desc= rset.getString("function_name") ;
			 code= rset.getString("function_id") ;
			}
			else  if(Program_type.equals("R"))
			{
			 desc= rset.getString("report_desc") ;
			 code= rset.getString("report_id") ;
			}
			code.replace('\n',' ');
			desc.replace('\n',' ');

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(code));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block9Bytes, _wl_block9);

		}
	}
	//out.println("</form></body></html>");
	if(rset!=null) rset.close();
    if(stmt!=null) stmt.close();
}
catch(Exception e)
{
	out.println("Exception :"+e);
}
finally
	{
	try
	{
if(rset!=null) rset.close();
if(stmt!=null) stmt.close();
	}
	catch(Exception e)
		{}
ConnectionManager.returnConnection(conn,request);
}

	

            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
