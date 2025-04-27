package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;

public final class __helpcontent extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/helpcontent.jsp", 1709116506451L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n\n<html>\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../html/IeStyle.css\"></link>\n\t\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\nfunction OnSelect(index)\n{\n\tvar file = \"../../eMP/help/PATREG\"+index+\".htm\";\tparent.frames[0].document.location.href=file;\n}\n\nfunction Dialog(ind)\n{\n\t\tvar retVal = new String();\n\t\tvar dialogHeight = \"25\" ;\n\t\tvar dialogWidth = \"48\" ;\n\t\tvar status = \"no\";\n\t\tvar scroll = \"yes\";\n\t\tvar features = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; status:\"+ status + \"; scroll:\"+ scroll;\n\t\tvar arguments\t= \"\" ;\n\t\tvar file = \"/eHIS/ph/DOC/PATREG\"+ind+\".html\";\n\n\t\tretVal = window.showModalDialog(file,arguments,features);\n}\n\nfunction Previous()\n{\n\tvar min = \'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\';\n\tif(min != \"1\")\n\t\tmin = parseInt(min)-1;\n\n\tparent.frames[1].document.location.href=\"../../eCommon/jsp/helpcontent.jsp?FunctionID=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="&no_of_pages=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&minimum_value=\"+min;\n}\n\nfunction Next()\n{\n\tvar minimum = \'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\';\n\tvar noofpages = \'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\';\n\tvar maximum = parseInt(minimum)+9;\n\n\tif(maximum != noofpages)\n\t\tminimum = parseInt(minimum)+1;\n\n\tparent.frames[1].document.location.href=\"../../eCommon/jsp/helpcontent.jsp?FunctionID=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&minimum_value=\"+minimum;\n}\n\n</script>\n</head>\n<body  OnMouseDown=\'CodeArrest()\'  onKeyDown = \'lockKey()\'>\n<form name=\'helpcontent\' id=\'helpcontent\' >\n<table width=\'50%\' align=\'center\'>\n<br>\n<tr>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</tr>\n\n</table>\n</form>\n</body>\n</html>\n\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");	

	String FunctionID = request.getParameter("FunctionID");
	String no_of_pages =  request.getParameter("no_of_pages");
	String min_val = request.getParameter("minimum_value");

	if(min_val == null)
		min_val = "1";

	int max_val = Integer.parseInt(min_val)+10;
	int i=1;

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(min_val));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(FunctionID));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(no_of_pages));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(min_val));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(no_of_pages));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(FunctionID));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(no_of_pages));
            _bw.write(_wl_block9Bytes, _wl_block9);


//	for(i = 1;i < Integer.parseInt(no_of_pages);i++)
	out.println("<td width='3%'><input type='button' class='button' name='prev' id='prev' value='<--' onClick='Previous();'></td>");
	for(i = Integer.parseInt(min_val);i < max_val;i++)
	{
		out.println("<td width='5%' align='center'><a href=\"javascript:OnSelect('"+i+"')\">");
		out.println(i+"</a></td>");
	}
	out.println("<td width='3%'><input type='button' class='button' name='next' id='next' value='-->' onClick='Next();'></td>");

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
