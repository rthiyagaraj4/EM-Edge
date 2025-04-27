package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __staffprofiletab extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/StaffProfileTab.jsp", 1709121664480L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n*\tCopyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED\n*\tApplication\t\t:\teRS\n*\tPurpose \t\t:\n*\tCreated By\t\t:\tSubbulakshmy. K\n*\tCreated On\t\t:\t25 Oct 2004\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<script>\n\tvar currentLink = new String();\n   \tcurrentLink = \"experience_link\";\n\tfunction objClick(objName,role_type, staff_id) {\n\t   \tchangeLink(objName);\n      \tif (objName == \'experience_link\'){\n\t\t\tparent.frames[1].location.href=\"../../eRS/jsp/StaffExperience.jsp?staff_id=\"+staff_id+\"&role_type=\"+ role_type;\t\n\t\t}\n    \telse if(objName == \'skill_link\'){    \t\t\n\t\t\tparent.frames[1].location.href=\"../../eRS/jsp/StaffSkills.jsp?staff_id=\"+staff_id+\"&role_type=\"+ role_type;\t\n    \t}\n\t\telse if(objName == \'training_link\'){\n\t\t\tparent.frames[1].location.href=\"../../eRS/jsp/StaffTraining.jsp?staff_id=\"+staff_id+\"&role_type=\"+ role_type;\t\n    \t}\n\t\telse if(objName == \'licensure_link\'){\n\t\t\tparent.frames[1].location.href=\"../../eRS/jsp/StaffLicensure.jsp?staff_id=\"+staff_id+\"&role_type=\"+ role_type;\t\n      \t}\n\n   }\n/***************************************************************/\n\tfunction changeLink(LinkName) {\n\t\t\tif (currentLink==\'experience_link\')\n\t\t\t\tdocument.getElementById(\"experience_link\").src=\'../../eRS/images/Experience_click.gif\';\n\t      \telse if (currentLink==\'skill_link\')\n\t\t  \t\tdocument.getElementById(\"skill_link\").src = \'../../eRS/images/Skill_click.gif\';\n\t\t\telse if (currentLink==\'training_link\')\n\t\t\t\tdocument.getElementById(\"training_link\").src=\'../../eRS/images/Training_click.gif\';\n\t      \telse if (currentLink==\'licensure_link\')\n\t\t  \t\tdocument.getElementById(\"licensure_link\").src = \'../../eRS/images/Licensure_click.gif\';\n\n\t\t\tif(LinkName==\'experience_link\')\n\t\t\t\tdocument.getElementById(\"experience_link\").src=\'../../eRS/images/Experience.gif\';\n\t\t\telse if(LinkName==\'skill_link\')\n\t\t\t\tdocument.getElementById(\"skill_link\").src=\'../../eRS/images/Skill.gif\';\n\t\t\tif(LinkName==\'training_link\')\n\t\t\t\tdocument.getElementById(\"training_link\").src=\'../../eRS/images/Training.gif\';\n\t\t\telse if(LinkName==\'licensure_link\')\n\t\t\t\tdocument.getElementById(\"licensure_link\").src=\'../../eRS/images/Licensure.gif\';\n\t\t\tcurrentLink = LinkName;\n\n\t\t}\n</script>\n</head>\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n\t\t<form name=\'form_tab\' id=\'form_tab\'>\n\t\t\t<table name=\'insert_tab\' id=\'insert_tab\' cellspacing=\'0\' cellpadding=\'0\' border=\'0\' width=\'*\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'right\' >\n\t\t\t\t\t<a href=\"javascript:objClick(\'experience_link\',\'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\',\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\') \" alt=\'Experience\'><img name= \'experience_link\' border=\'0\' src=\'../../eRS/images/Experience.gif\' alt=\'Experience\' ></img></a></td>\n\t\t\t\t\t<td align=\'left\'>\n\t\t\t\t\t<a href=\"javascript:objClick(\'skill_link\',\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\')\"    alt=\'Skill\'> <img name=\'skill_link\' border=\'0\' src=\'../../eRS/images/Skill_click.gif\' alt=\'Skill\' onBlur=\'changeFocus()\'  ></img></a></td>\n\t\t\t\t\t<td align=\'left\'>\n\t\t\t\t\t<a href=\"javascript:objClick(\'licensure_link\',\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\')\"    alt=\'Licensure\'> <img name=\'licensure_link\' border=\'0\' src=\'../../eRS/images/Licensure_click.gif\' alt=\'Licensure\' onBlur=\'changeFocus()\'  ></img></a>\n\t\t\t\t\t<td align=\'right\' >\n\t\t\t<a  href=\"javascript:objClick(\'training_link\',\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\') \" alt=\'Training\'><img name= \'training_link\' border=\'0\' src=\'../../eRS/images/Training_click.gif\' alt=\'Training\'   ></img></a></td>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);

request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block1Bytes, _wl_block1);

	String staff_id= request.getParameter("staff_id");
	String role_type=request.getParameter("role_type");

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(role_type));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(staff_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(role_type));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(staff_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(role_type));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(staff_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(role_type));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(staff_id));
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
