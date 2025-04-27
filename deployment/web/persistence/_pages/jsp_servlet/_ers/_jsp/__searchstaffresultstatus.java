package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __searchstaffresultstatus extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/SearchStaffResultStatus.jsp", 1709121651152L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n*\tCopyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED\n*\tApplication\t\t:\teRS\n*\tPurpose \t\t:\t\n*\tCreated By\t\t:\tSuchilagna Panigrahi\n*\tCreated On\t\t:\t22 nov 2004\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link> \n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<script>\nvar currentLink = new String();\ncurrentLink = \"experience_link\";\nfunction objClick(objName,role_type, staff_id)\n{\t\t//alert(\"objName\"+objName);\n\t\t//selectTab(objName);\n\t   \tchangeLink(objName);\n      \tif (objName == \'experience_link\')\n\t\t{\t\n\t\t\t/*document.getElementById(\"experience_link\").className = \"tabClicked\";\n\t\t\tdocument.getElementById(\"skill_link\").className\t   = \"tabA\";\t\n\t\t\tdocument.getElementById(\"licensure_link\").className = \"tabA\";\n\t\t\tdocument.getElementById(\"training_link\").className = \"tabA\";\n\n\t\t\tdocument.getElementById(\"experience_link_aspan\").className = \"tabSpanclicked\";\n\t\t\tdocument.getElementById(\"skill_link_aspan\").className\t   = \"tabAspan\";\t\n\t\t\tdocument.getElementById(\"licensure_link_aspan\").className = \"tabAspan\";\n\t\t\tdocument.getElementById(\"training_link_aspan\").className = \"tabAspan\";*/\n\n\t\t\tvar url=\"../../eRS/jsp/StaffExperience.jsp?staff_id=\"+staff_id+\"&role_type=\"+ role_type;\t\n\t\t\tvar dialogHeight  = \"28\" ;\n    var dialogWidth = \"50\" ;\n\tvar dialogTop\t= \'120\';\n\tvar dialogLeft = \'5\' ;\n    var arguments   = \"\" ;\n    var features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";dialogTop:\"+dialogTop+\";dialogLeft:\"+dialogLeft+\"; scroll=no; status=no;\";\n    var reportURL   = window.showModalDialog( url, arguments, features ) ;\n\t\t\tdocument.getElementById(\"experience_link\").className = \"tabA\";\n\t\t\tdocument.getElementById(\"experience_link_aspan\").className = \"tabAspan\";\n        }\n    \telse if(objName == \'skill_link\')\n    \t{    \n\t\t\t/*alert(\'name is  --- \'+document.forms[0].name);\n\t\t\talert(\'class is --- \'+document.getElementById(\"experience_link\").className);\n\t\t\talert(\'class is --- \'+document.getElementById(\"skill_link\").className);\n\t\t\tdocument.getElementById(\"experience_link\").className = \"tabA\";\n\t\t\tdocument.getElementById(\"skill_link\").className\t   = \"tabClicked\";\t\n\t\t\tdocument.getElementById(\"licensure_link\").className = \"tabA\";\n\t\t\tdocument.getElementById(\"training_link\").className = \"tabA\";\n\n\t\t\tdocument.getElementById(\"experience_link_aspan\").className = \"tabAspan\";\n\t\t\tdocument.getElementById(\"skill_link_aspan\").className\t   = \"tabSpanclicked\";\t\n\t\t\tdocument.getElementById(\"licensure_link_aspan\").className = \"tabAspan\";\n\t\t\tdocument.getElementById(\"training_link_aspan\").className = \"tabAspan\";*/\n\n\t\t\tvar url=\"../../eRS/jsp/StaffSkills.jsp?staff_id=\"+staff_id+\"&role_type=\"+ role_type;\n\t\t\tvar dialogHeight  = \"28\" ;\n    var dialogWidth = \"50\" ;\n\tvar dialogTop\t= \'120\';\n\tvar dialogLeft = \'5\' ;\n    var arguments   = \"\" ;\n    var features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";dialogTop:\"+dialogTop+\";dialogLeft:\"+dialogLeft+\"; scroll=no; status=no;\";\n    var reportURL   = window.showModalDialog( url, arguments, features ) ;\n\tdocument.getElementById(\"skill_link\").className\t   = \"tabA\";\n\tdocument.getElementById(\"skill_link_aspan\").className\t   = \"tabAspan\";\n\n    \t}\n\t\telse if(objName == \'training_link\')\n    \t{\n\t\t\t/*\n\t\t\tdocument.getElementById(\"experience_link\").className = \"tabA\";\n\t\t\tdocument.getElementById(\"skill_link\").className\t   = \"tabA\";\t\n\t\t\tdocument.getElementById(\"licensure_link\").className = \"tabA\";\n\t\t\tdocument.getElementById(\"training_link\").className = \"tabClicked\";\n\n\t\t\tdocument.getElementById(\"experience_link_aspan\").className = \"tabAspan\";\n\t\t\tdocument.getElementById(\"skill_link_aspan\").className\t   = \"tabAspan\";\t\n\t\t\tdocument.getElementById(\"licensure_link_aspan\").className = \"tabAspan\";\n\t\t\tdocument.getElementById(\"training_link_aspan\").className = \"tabSpanclicked\";*/\n\n\n\t\t\tvar url=\"../../eRS/jsp/StaffTraining.jsp?staff_id=\"+staff_id+\"&role_type=\"+ role_type;\t\n\t\t\tvar dialogHeight  = \"28\" ;\n    var dialogWidth = \"50\" ;\n\tvar dialogTop\t= \'120\';\n\tvar dialogLeft = \'5\' ;\n    var arguments   = \"\" ;\n    var features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";dialogTop:\"+dialogTop+\";dialogLeft:\"+dialogLeft+\"; scroll=no; status=no;\";\n    var reportURL   = window.showModalDialog( url, arguments, features ) ;\n\tdocument.getElementById(\"training_link\").className = \"tabA\";\n    document.getElementById(\"training_link_aspan\").className = \"tabAspan\";\n\t}\n\t\telse if(objName == \'licensure_link\')\n      \t{\n\t\t\tvar url=\"../../eRS/jsp/StaffLicensure.jsp?staff_id=\"+staff_id+\"&role_type=\"+ role_type;\t\n\t\t\tvar dialogHeight  = \"28\" ;\n\t\t\tvar dialogWidth = \"50\" ;\n\t\t\tvar dialogTop\t= \'120\';\n\t\t\tvar dialogLeft = \'5\' ;\n\t\t\tvar arguments   = \"\" ;\n\t\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";dialogTop:\"+dialogTop+\";dialogLeft:\"+dialogLeft+\"; scroll=no; status=no;\";\n\t\t\tvar reportURL   = window.showModalDialog( url, arguments, features ) ;\n\t\t\tdocument.getElementById(\"licensure_link\").className = \"tabA\";\n\t\t\tdocument.getElementById(\"licensure_link_aspan\").className = \"tabAspan\";\n      \t}\n\n   }\n/***************************************************************/\n\tfunction changeLink(LinkName) {\n\t\t//alert(\"LinkName-------->\"+LinkName)\n\t\t\tif (currentLink==\'experience_link\')\n\t\t\t{\t\t//alert(\"Experience link\");\n\t\t\t\tdocument.getElementById(\"experience_link\").className = \"tabClicked\";\n\t\t\t\tdocument.getElementById(\"skill_link\").className\t   = \"tabA\";\t\n\t\t\t\tdocument.getElementById(\"licensure_link\").className = \"tabA\";\n\t\t\t\tdocument.getElementById(\"training_link\").className = \"tabA\";\n\n\t\t\t\tdocument.getElementById(\"experience_link_aspan\").className = \"tabSpanclicked\";\n\t\t\t\tdocument.getElementById(\"skill_link_aspan\").className\t   = \"tabAspan\";\t\n\t\t\t\tdocument.getElementById(\"licensure_link_aspan\").className = \"tabAspan\";\n\t\t\t\tdocument.getElementById(\"training_link_aspan\").className = \"tabAspan\";\n\t\t\t}\n\t      \telse if (currentLink==\'skill_link\')\n\t\t\t{\t//alert(\"skill link\");\n\t\t\t\t/*alert(\'name is  --- \'+document.forms[0].name);\n\t\t\t\talert(\'class is --- \'+document.getElementById(\"experience_link\").className);\n\t\t\t\talert(\'class is --- \'+document.getElementById(\"skill_link\").className);*/\n\t\t\t\t\n\t\t\t\tdocument.getElementById(\"skill_link\").className\t   =\"tabClicked\";\n\t\t\t\tdocument.getElementById(\"experience_link\").className = \"tabA\";\n\t\t\t\tdocument.getElementById(\"licensure_link\").className = \"tabA\";\n\t\t\t\tdocument.getElementById(\"training_link\").className = \"tabA\";\n\n\t\t\t\tdocument.getElementById(\"experience_link_aspan\").className = \"tabAspan\";\n\t\t\t\tdocument.getElementById(\"skill_link_aspan\").className\t   = \"tabSpanclicked\";\n\t\t\t\tdocument.getElementById(\"licensure_link_aspan\").className = \"tabAspan\";\n\t\t\t\tdocument.getElementById(\"training_link_aspan\").className = \"tabAspan\";\n\t\t  \t\t\n\n\t\t\t}\n\t\t\telse if (currentLink==\'training_link\')\n\t\t\t{\t//alert(\"training link\");\n\t\t\t\tdocument.getElementById(\"experience_link\").className = \"tabA\";\n\t\t\t\tdocument.getElementById(\"skill_link\").className\t   = \"tabA\";\t\n\t\t\t\tdocument.getElementById(\"licensure_link\").className = \"tabA\";\n\t\t\t\tdocument.getElementById(\"training_link\").className = \"tabClicked\";\n\n\t\t\t\tdocument.getElementById(\"experience_link_aspan\").className = \"tabAspan\";\n\t\t\t\tdocument.getElementById(\"skill_link_aspan\").className\t   = \"tabAspan\";\t\n\t\t\t\tdocument.getElementById(\"licensure_link_aspan\").className = \"tabAspan\";\n\t\t\t\tdocument.getElementById(\"training_link_aspan\").className = \"tabSpanclicked\";\n\t\t\t}\n\t      \telse if (currentLink==\'licensure_link\')\n\t\t  \t{\t\t//alert(\"licensure_link\");\n\t\t\t\t\tdocument.getElementById(\"experience_link\").className = \"tabA\";\n\t\t\t\t\tdocument.getElementById(\"skill_link\").className\t   = \"tabA\";\t\n\t\t\t\t\tdocument.getElementById(\"licensure_link\").className = \"tabClicked\";\n\t\t\t\t\tdocument.getElementById(\"training_link\").className = \"tabA\";\n\n\t\t\t\t\tdocument.getElementById(\"experience_link_aspan\").className = \"tabAspan\";\n\t\t\t\t\tdocument.getElementById(\"skill_link_aspan\").className\t   = \"tabAspan\";\t\n\t\t\t\t\tdocument.getElementById(\"licensure_link_aspan\").className = \"tabSpanclicked\";\n\t\t\t\t\tdocument.getElementById(\"training_link_aspan\").className = \"tabAspan\";\n\t\t\t}\n\t\t\t\n\t\t\tif(LinkName==\'experience_link\')\n\t\t\t{\t\t//alert(\"experience in link name. link\");\n\t\t\t\tdocument.getElementById(\"experience_link\").className = \"tabClicked\";\n\t\t\t\tdocument.getElementById(\"skill_link\").className\t   = \"tabA\";\t\n\t\t\t\tdocument.getElementById(\"licensure_link\").className = \"tabA\";\n\t\t\t\tdocument.getElementById(\"training_link\").className = \"tabA\";\n\n\t\t\t\tdocument.getElementById(\"experience_link_aspan\").className = \"tabSpanclicked\";\n\t\t\t\tdocument.getElementById(\"skill_link_aspan\").className\t   = \"tabAspan\";\t\n\t\t\t\tdocument.getElementById(\"licensure_link_aspan\").className = \"tabAspan\";\n\t\t\t\tdocument.getElementById(\"training_link_aspan\").className = \"tabAspan\";\n\t\t\t}\n\t\t\telse if(LinkName==\'skill_link\')\n\t\t\t{\n\t\t\t\t//alert(\"skill in link name. link\");\n\t\t\t\t/*alert(\'name is  --- \'+document.forms[0].name);\n\t\t\t\talert(\'class is --- \'+document.getElementById(\"experience_link\").className);\n\t\t\t\talert(\'class is --- \'+document.getElementById(\"skill_link\").className);*/\n\t\t\t\t\n\t\t\t\tdocument.getElementById(\"skill_link\").className\t   = \"tabClicked\";\n\t\t\t\tdocument.getElementById(\"experience_link\").className = \"tabA\";\n\t\t\t\tdocument.getElementById(\"licensure_link\").className = \"tabA\";\n\t\t\t\tdocument.getElementById(\"training_link\").className = \"tabA\";\n\n\t\t\t\tdocument.getElementById(\"experience_link_aspan\").className = \"tabAspan\";\n\t\t\t\tdocument.getElementById(\"skill_link_aspan\").className\t   = \"tabSpanclicked\";\t\n\t\t\t\tdocument.getElementById(\"licensure_link_aspan\").className = \"tabAspan\";\n\t\t\t\tdocument.getElementById(\"training_link_aspan\").className = \"tabAspan\";\n\t\t\t}\t\n\t\t\tif(LinkName==\'licensure_link\')\n\t\t\t{\n\t\t\t\t\t//alert(\"licensure_link in link name. \");\n\t\t\t\t\tdocument.getElementById(\"experience_link\").className = \"tabA\";\n\t\t\t\t\tdocument.getElementById(\"skill_link\").className\t   = \"tabA\";\t\n\t\t\t\t\tdocument.getElementById(\"licensure_link\").className = \"tabClicked\";\n\t\t\t\t\tdocument.getElementById(\"training_link\").className = \"tabA\";\n\n\t\t\t\t\tdocument.getElementById(\"experience_link_aspan\").className = \"tabAspan\";\n\t\t\t\t\tdocument.getElementById(\"skill_link_aspan\").className\t   = \"tabAspan\";\t\n\t\t\t\t\tdocument.getElementById(\"licensure_link_aspan\").className = \"tabSpanclicked\";\n\t\t\t\t\tdocument.getElementById(\"training_link_aspan\").className = \"tabAspan\";\n\t\t\t}\t\n\t\t\telse if(LinkName==\'training_link\')\n\t\t\t{\n\t\t\t\t\t//alert(\"training_link in link name. \");\n\t\t\t\t\tdocument.getElementById(\"experience_link\").className = \"tabA\";\n\t\t\t\t\tdocument.getElementById(\"skill_link\").className\t   = \"tabA\";\t\n\t\t\t\t\tdocument.getElementById(\"licensure_link\").className = \"tabA\";\n\t\t\t\t\tdocument.getElementById(\"training_link\").className = \"tabClicked\";\n\n\t\t\t\t\tdocument.getElementById(\"experience_link_aspan\").className = \"tabAspan\";\n\t\t\t\t\tdocument.getElementById(\"skill_link_aspan\").className\t   = \"tabAspan\";\t\n\t\t\t\t\tdocument.getElementById(\"licensure_link_aspan\").className = \"tabAspan\";\n\t\t\t\t\tdocument.getElementById(\"training_link_aspan\").className = \"tabSpanclicked\";\n\t\t\t}\n\t\t\t\t\t\n\t\t\tcurrentLink = LinkName;\n\t\t\t//alert(\"currentLink=\"+currentLink);\n\t\t}\n</script>\n</head>\n\t<body>\n\t\t\t<form name=\'form_tab\' id=\'form_tab\'>\n\t\t\t\t<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t\t<li class=\"tablistitem\" title=\"Experience\">\n\t\t\t\t<a onclick=\"javascript:objClick(\'experience_link\',\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\',\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\') \" class=\"tabA\" id=\"experience_link\">\n\t\t\t\t<span class=\"tabAspan\" id=\"experience_link_aspan\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</span>\n\t\t\t\t</a>\n\t\t\t\t</li>\n      \n\t\t\t\t<li class=\"tablistitem\" title=\"Skill\">\n\t\t\t\t <a onclick=\"javascript:objClick(\'skill_link\',\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\')\" class=\"tabA\" id=\"skill_link\" >\n\t\t\t\t<span class=\"tabAspan\" id=\"skill_link_aspan\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</span>\n\t\t\t\t</a>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t</li>\n\t\t\t\t<li class=\"tablistitem\" title=\"Licensure\">\n\t\t\t\t<a onclick=\"javascript:objClick(\'licensure_link\',\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\')\"  class=\"tabA\" id=\"licensure_link\" >\n\t\t\t\t<span class=\"tabAspan\" id=\"licensure_link_aspan\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</span>\n\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t\t<li class=\"tablistitem\" title=\"Training\">\n\t\t\t\t<a onclick=\"javascript:objClick(\'training_link\',\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\')\"  class=\"tabA\" id=\"training_link\" >\n\t\t\t\t <span class=\"tabAspan\" id=\"training_link_aspan\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</span>\n\t\t\t\t</a>\n\t\t\t\t</li>\n\t   \n\t\t\t\t </ul>\n\t\t\t\t\n\t\t</form>\n\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);

	String staff_id= request.getParameter("staff_id");
	String role_type=request.getParameter("role_type");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(role_type));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(staff_id));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(role_type));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(staff_id));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(role_type));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(staff_id));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(role_type));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(staff_id));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.Experience.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.Skill.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.Licensure.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.Training.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }
}
