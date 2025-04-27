package jsp_servlet._datadictionary._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.DatabaseMetaData;
import webbeans.eCommon.ConnectionManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

public final class __moduledetailsmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/datadictionary/jsp/ModuleDetailsMain.jsp", 1737911776047L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Language\" content=\"en\" />\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n<title>jQuery Horizontal splitter</title>\n<script type=\"text/javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<script type=\"text/javascript\" src=\"../js/splitter.js\"></script>\n\n<!-- General page styles (not critical to the demos) -->\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/main.css\" />\n<link rel=\"stylesheet\" href=\"../css/moduleDetails.css\"/> \n<style type=\"text/css\" media=\"all\">\n\n/*\n * Splitter container. Set this to the desired width and height\n * of the combined left and right panes.\n */\n#MySplitter {\n\theight: 620px;\n\twidth: 98%;\n\tborder: 1px solid #F2F2F5;\n\t/* No padding allowed */\n}\n/*\n * Top element of the splitter. Use pixel units for the\n * min-height and max-height; the splitter plugin parses them to\n * determine the splitter movement limits. Set the height to\n * the desired initial height of the element; the plugin changes\n * the height of this element dynamically.\n */\n#TopPane {\n\tbackground: #ffe;\n\toverflow: auto;\n\t/* Initial/min/max height for this pane */\n\theight: 400px;\n\tmin-height: 200px;\n\tmax-height: 620px;\n\tposition: relative;\n\t/* No margin or border allowed */\n}\n/*\n * Bottom element of the splitter; the plugin changes the top\n * position and height of this element dynamically.\n */\n#BottomPane {\n\tbackground: #ffd;\n\toverflow: auto;\n\tposition: relative;\n\tmin-height: 0px;\n\tmax-height: 400px;\n\t/* No margin or border allowed */\n}\n/* \n * Splitter bar style; the .active class is added when the\n * mouse is over the splitter or the splitter is focused\n * via the keyboard taborder or an accessKey. \n */\n#MySplitter .hsplitbar {\n\theight: 10px;\n\twidth: 500px;\n\tbackground: #c8c8d2 url(../images/Separator.PNG) no-repeat center;\n}\n\n#MySplitter .hsplitbar.active {\n\tbackground: #c8c8d2 url(../images/Separator.PNG) no-repeat center;\n}\n</style >\n<style  type=\"text/css\" >\n\n</style>\n<script type=\"text/javascript\">\n\t$().ready(function() {\n\t\t$(\"#MySplitter\").splitter({\n\t\t\ttype : \"h\",\n\t\t\tsizeBottom : 0, /* use height set in stylesheet */\n\t\t\taccessKey : \"P\"\n\t\t});\n\t});\n\n\tfunction showInBottomFrame() {\n\t\tvar bottomDiv = document.getElementById(\"BottomPane\");\n\t\tif (bottomDiv) {\n\t\t\tbottomDiv.style.height = \'300px\';\n\t\t}\n\t\tvar topDiv = document.getElementById(\"TopPane\");\n\t\tif (topDiv) {\n\t\t\ttopDiv.style.height = \'300px\';\n\t\t}\n\n\t}\n\t\n\tfunction resizeSplitter(){\n\t\t$(\"#MySplitter\").trigger(\"resize\", [ 300 ]);\n\t}\n\t\n\tfunction showAttr(entityName){\n\t\t//var url = \"EntityAttributes.jsp?entityName=\"+entityName;\n\t\t//parent.REPWINDOW.location.href = url;\n\t\t//showInBottomFrame(url);\n\t\t//window.location.href = url;\n\t\tvar hdnAttributeClickedComp = document.getElementById(\"hdnAttributeClicked\");\n\t\tif(hdnAttributeClickedComp){\n\t\t\thdnAttributeClickedComp.value = \"yes\";\n\t\t}\n\t\t\n\t\tvar hdnModuleNameComp = document.getElementById(\"hdnModuleName\");\n\t\tif(hdnModuleNameComp){\n\t\t\thdnModuleNameComp.value = entityName;\n\t\t}\n\t\t\n\t\t\n\t\tvar hdnModuleIdComp = document.getElementById(\"moduleId\");\n\t\tvar moduleId = \"\";\n\t\tif(hdnModuleIdComp){\n\t\t\tmoduleId = hdnModuleIdComp.value;\n\t\t}\n\t\t\n\t\tvar hdnModuleNameComp = document.getElementById(\"moduleName\");\n\t\tvar moduleName = \"\";\n\t\tif(hdnModuleNameComp){\n\t\t\tmoduleName = hdnModuleNameComp.value;\n\t\t}\n\t\t\n\t\tvar actionScr = \"ModuleDetailsMain.jsp?moduleId=\"+moduleId+\"&moduleName=\"+moduleName+\"&hdnAssociateClicked=&hdnAttributeClicked=yes&hdnModuleName=\"+entityName;\n\t\tdocument.forms[0].action = actionScr;\n\t\t\n\t\tdocument.forms[0].submit();\n\t}\n\t\n\tfunction showAssociatedEntities(entityName){\n\t\t//var url = \"EntityAssociates.jsp?entityName=\"+entityName;\n\t\t//parent.REPWINDOW.location.href = url;\n\t\t//showInBottomFrame(url);\n\t\t//window.location.href = url;\n\t\t\n\t\tvar hdnAttributeClickedComp = document.getElementById(\"hdnAttributeClicked\");\n\t\tif(hdnAttributeClickedComp){\n\t\t\thdnAttributeClickedComp.value = \"yes\";\n\t\t}\n\t\t\n\t\tvar hdnModuleNameComp = document.getElementById(\"hdnModuleName\");\n\t\tif(hdnModuleNameComp){\n\t\t\thdnModuleNameComp.value = entityName;\n\t\t}\n\t\t\n\t\t\n\t\tvar hdnModuleIdComp = document.getElementById(\"moduleId\");\n\t\tvar moduleId = \"\";\n\t\tif(hdnModuleIdComp){\n\t\t\tmoduleId = hdnModuleIdComp.value;\n\t\t}\n\t\t\n\t\tvar hdnModuleNameComp = document.getElementById(\"moduleName\");\n\t\tvar moduleName = \"\";\n\t\tif(hdnModuleNameComp){\n\t\t\tmoduleName = hdnModuleNameComp.value;\n\t\t}\n\t\t\n\t\tvar actionScr = \"ModuleDetailsMain.jsp?moduleId=\"+moduleId+\"&moduleName=\"+moduleName+\"&hdnAssociateClicked=yes&hdnAttributeClicked=&hdnModuleName=\"+entityName;\n\t\tdocument.forms[0].action = actionScr;\n\t\t\t\t\n\t\tdocument.forms[0].submit();\n\t}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body bgcolor=\"#F8F8F9\" onload=\"resizeSplitter()\">\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<form method=\"post\" id=\"moduleForm\" name=\"moduleForm\" id=\"moduleForm\">\n\t<div id=\"MySplitter\" style=\"background-color: #F8F8F9;\">\n\n\t\t<div id=\"TopPane\" class=\"viewpanestyle\">\n\t\t\t<table width=\"98%\" style=\"min-height: 290;\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n\t\t\t\tclass=\"viewtablestyle\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"viewtabletdstyle\"><b><span class=\"viewtabletitlestyle\" >List of views for Module\n\t\t\t\t\t\t\t:&nbsp;</span></b><b><span class=\"viewtabletitleviewnamestyle\" >";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="</span></b></td>\n\t\t\t\t</tr>\n\n\t\t\t\t<tr>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\t\t<table border=\"0\" width=\"98%\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin-left:5px;margin-bottom: 5px;\"\n\t\t\t\t\t\t\tclass=\"viewdatatablestyle\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<th style=\"padding-left: 10px;\" align=\"left\" class=\"viewdatatableheaderstyle\">View Name</th>\n\t\t\t\t\t\t\t\t<th style=\"padding-left: 10px;\" align=\"left\" class=\"viewdatatableheaderstyle\">Description</th>\n\t\t\t\t\t\t\t\t<th align=\"center\" class=\"viewdatatableheaderstyle\">Attributes</th>\n\t\t\t\t\t\t\t\t<th align=\"center\" class=\"viewdatatableheaderstyle\">Associated\n\t\t\t\t\t\t\t\t\tEntities</th>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td  align=\"left\" valign=\"middle\" style=\"padding-left: 5px;\" width=\"25%\" class=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t<td  align=\"left\" valign=\"middle\" width=\"48%\" style=\"padding-left: 5px;\" class=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">This is a test for\n\t\t\t\t\t\t\t\t\tdescription column this is a very long description in deed just\n\t\t\t\t\t\t\t\t\tto test how the GUI is showing this column</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">&nbsp;</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t<td align=\"center\" width=\"10%\" class=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"><img\n\t\t\t\t\t\t\t\t\tsrc=\"List_Attr.gif\" onclick=\"showAttr(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\')\" style=\"cursor:pointer;cursor: hand;\"></img>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td align=\"center\" width=\"15%\" class=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"><img\n\t\t\t\t\t\t\t\t\tsrc=\"Linked_Entities.gif\"\n\t\t\t\t\t\t\t\t\tonclick=\"showAssociatedEntities(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\')\"  style=\"cursor:pointer;cursor: hand;\"></img></td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t</table> ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" <span class=\"spanstyle\">No records obtained for the selected\n\t\t\t\t\t\t\tmodule</span> ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\n\t\t<div id=\"BottomPane\" style=\"background-color: #F8F8F9;\" width=\"99%\">\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t<table width=\"98%\" cellpadding=\"0\" cellspacing=\"0\" class=\"viewdatatablestyle\">\n\t\t\t\t\t\t<tr>\n     \t\t\t\t\t\t<td class=\"viewtabletdstyle\"> <span class=\"viewtabletitlestyle\" >List of attributes for view :&nbsp;</span><span class=\"viewtabletitleviewnamestyle\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</span>\n     \t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t<table width=\"98%\" cellpadding=\"0\" cellspacing=\"0\" class=\"viewdatatablestyle\" style=\"margin-left:5px;margin-bottom: 5px;\">\n\t\t\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t\t\t<th class=\"viewdatatableheaderstyle\">No</th>\n\t\t\t\t\t\t\t\t<th style=\"padding-left: 10px;\" align=\"left\" class=\"viewdatatableheaderstyle\">Name</th>\n\t\t\t\t\t\t\t\t<th style=\"padding-left: 10px;\" align=\"left\" class=\"viewdatatableheaderstyle\">Type</th>\n\t\t\t\t\t\t\t\t<th style=\"padding-left: 10px;\" align=\"left\" class=\"viewdatatableheaderstyle\">Descriptions</th>\n\t\t\t\t\t\t\t</tr>\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td width=\"7%\" class=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" align=\"center\" valign=\"middle\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\t\t\t\t\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td width=\"25%\" class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" style=\"padding-left: 10px;\" align=\"left\" valign=\"middle\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td width=\"20%\" class=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\t\t\t\t\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td width=\"48%\" class=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t\t\t\t</tr>\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\t\n\t\t\t\t</table>\t\n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\n\t\t\t\t\t<table width=\"98%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"viewdatatablestyle\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t     <td class=\"viewtabletdstyle\"><span class=\"viewtabletitlestyle\" >List of associated entities for view :&nbsp;</span><span class=\"viewtabletitleviewnamestyle\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</span>\n\t\t\t\t\t     </td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t<table width=\"98%\" cellpadding=\"0\" cellspacing=\"0\" class=\"viewdatatablestyle\" style=\"margin-left:5px;margin-bottom: 5px;\">\n\t\t\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t\t\t<th style=\"padding-left: 10px;\" align=\"left\" class=\"viewdatatableheaderstyle\">Table Owner</th>\n\t\t\t\t\t\t\t\t<th style=\"padding-left: 10px;\" align=\"left\" class=\"viewdatatableheaderstyle\">Table Name</th>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td  align=\"left\" valign=\"middle\" style=\"padding-left: 10px;\" class=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t\t\t\t\t\t<td  align=\"left\" valign=\"middle\" style=\"padding-left: 10px;\" class=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t\t\t\t\t\t\t</tr>\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t</table>\n\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t</div>\n\n\t</div>\n\n\t<input type=\"hidden\" id=\"hdnAssociateClicked\" value=\"\"/> \n\t<input type=\"hidden\" id=\"hdnAttributeClicked\" value=\"\"/>\n\t<input type=\"hidden\" id=\"hdnModuleName\" value=\"\"/>\n\t<input type=\"hidden\" id=\"moduleId\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"/>\n\t<input type=\"hidden\" id=\"moduleName\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"/>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String moduleId = request.getParameter("moduleId");
	if (moduleId == null) {
		moduleId = "";
	}
	String moduleName = request.getParameter("moduleName");
	if (moduleName == null) {
		moduleName = "";
	}
	
	String associateClicked = request.getParameter("hdnAssociateClicked");
	if(associateClicked == null){
		associateClicked = "";
	}
	
	String attributeClicked = request.getParameter("hdnAttributeClicked");
	if(attributeClicked == null){
		attributeClicked = "";
	}
	
	String entityName = request.getParameter("hdnModuleName");
	if(entityName == null){
		entityName = "";
	}
	
	int rowCounter = 0;
	String styleClassName = "";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(moduleName));
            _bw.write(_wl_block4Bytes, _wl_block4);

							String completeModuleName = moduleId + "%";

							String query = "";

							PreparedStatement prepStmt = null;
							Connection conn = null;

							try {
								conn = ConnectionManager.getConnection(request);
							} catch (Exception e) {
								out.println("<span class='spanstyle'>Could not get connection. Error Message ="
										+ e.getMessage() + "</span>");
								return;
							}

							// safe approach
							if (conn == null) {
								out.println("<span class='spanstyle'>Error in showing details as connection to the database was not obtained</span>");
								return;
							}

							String userName = "";
							DatabaseMetaData dbmd = null;
							try {
								dbmd = conn.getMetaData();
							} catch (Exception ex) {
								out.println("<span class='spanstyle'>Error in showing details</span>");
								return;
							}

							if (dbmd == null) {
								out.println("<span class='spanstyle'>Error in showing details</span>");
								return;
							}

							userName = dbmd.getUserName();

							query = "SELECT A.OWNER,A.VIEW_NAME,B.TABLE_TYPE,B.COMMENTS FROM ALL_VIEWS A, ALL_TAB_COMMENTS B WHERE A.OWNER = B.OWNER AND A.VIEW_NAME = B.TABLE_NAME and A.owner = '"
									+ userName
									+ "' AND A.VIEW_NAME LIKE ('"
									+ completeModuleName + "') AND B.TABLE_TYPE = 'VIEW'";

							String entName = "";
							ResultSet rs = null;
							int rowCount = 0;
							try {
								prepStmt = conn.prepareStatement(query);
								rs = prepStmt.executeQuery();
								if (rs != null) {
						
            _bw.write(_wl_block5Bytes, _wl_block5);

								while (rs.next()) {
											if (rowCount == 0) {
							
            _bw.write(_wl_block6Bytes, _wl_block6);

								rowCount++;
											}
											
											if(rowCount % 2 == 0){
												styleClassName = "viewdatarowoddstyle";
											}else{
												styleClassName = "viewdatarowevenstyle";
											}
											
											entName = rs.getString("VIEW_NAME");
											if (entName != null && !entName.trim().equals("")) {
							
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(styleClassName));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(entName));
            _bw.write(_wl_block9Bytes, _wl_block9);

									if (rowCount == 1) {
								
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(styleClassName));
            _bw.write(_wl_block11Bytes, _wl_block11);

									} else {
								
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(styleClassName));
            _bw.write(_wl_block12Bytes, _wl_block12);

									}
								
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(styleClassName));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(entName));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(styleClassName));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(entName));
            _bw.write(_wl_block17Bytes, _wl_block17);

								}
											rowCount++;
										}
							
            _bw.write(_wl_block18Bytes, _wl_block18);

 	// indicates no records were fetched
 			if (rowCount == 0) {
 
            _bw.write(_wl_block19Bytes, _wl_block19);

 	}
 		}

 	} catch (Exception ex) {
 		out.println("<span class='spanstyle'>Could not obtain records for the module "
 				+ moduleName + "</span>");
 		return;
 	} finally {
 		if (rs != null) {
 			try {
 				rs.close();
 			} catch (Exception ex) {

 			}
 		}

 		if (prepStmt != null) {
 			try {
 				prepStmt.close();
 			} catch (Exception ex) {

 			}
 		}
 		ConnectionManager.returnConnection(conn, request);
 	}
 
            _bw.write(_wl_block20Bytes, _wl_block20);

			if (rs != null) {
	 			try {
	 				rs.close();
	 			} catch (Exception ex) {

	 			}
	 		}

	 		if (prepStmt != null) {
	 			try {
	 				prepStmt.close();
	 			} catch (Exception ex) {

	 			}
	 		}
			
	 		
	 		styleClassName = "";
				if("yes".equalsIgnoreCase(attributeClicked)){
					if(entityName == null || entityName.trim().equals("")){
						out.println("<span>A view should be selected first.</span")	;
						return;
					}
					
					try {
						conn = ConnectionManager.getConnection(request);
					} catch (Exception e) {
						out.println("Could not get connection. Error Message ="+e.getMessage());
						return;
					}

					// safe approach
					if(conn == null){
						out.println("Error in showing the details as connection to the database was not obtained");
						return;
					}
					
					query = "SELECT ROWNUM NUMB, ATTRIBUTE_NAME, data_type||'('||data_length||')' data_type, DESCRIPTIONS FROM ( SELECT  A.column_name ATTRIBUTE_NAME, A.data_type, A.data_length, B.COMMENTS DESCRIPTIONS FROM all_tab_columns A, user_col_comments B WHERE A.table_name = '"+entityName+"' AND OWNER = 'IBAEHIS' AND A.TABLE_NAME = B.TABLE_NAME AND A.COLUMN_NAME = B.COLUMN_NAME ORDER BY 1 )";
					
					
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(entityName ));
            _bw.write(_wl_block22Bytes, _wl_block22);

						try{
							prepStmt = conn.prepareStatement(query);
							rs = prepStmt.executeQuery();
							if(rs != null){
						
            _bw.write(_wl_block23Bytes, _wl_block23);
	
							Object numbObj = null;
							
							while(rs.next()){
								String desc = rs.getString("DESCRIPTIONS");
								if(desc == null){
									desc = "&nbsp;";
								}
								
								if(rowCounter % 2 == 1){
									styleClassName = "viewdatarowoddstyle";
								}else{
									styleClassName = "viewdatarowevenstyle";
								}
								rowCounter++;
						
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(styleClassName));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rs.getObject("NUMB") ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(styleClassName));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rs.getString("ATTRIBUTE_NAME") ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(styleClassName));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rs.getObject("data_type") ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(styleClassName));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(desc ));
            _bw.write(_wl_block30Bytes, _wl_block30);
		
								}
							// reset the rowCounter to 1
								rowCounter = 0;
							
            _bw.write(_wl_block31Bytes, _wl_block31);

							}else{
								out.println("Could not obtain records for "+entityName);
								return;
							}
						
            _bw.write(_wl_block32Bytes, _wl_block32);
	
					}catch(Exception ex){
						out.println("Could not obtain records for "+entityName);
						return;
					}finally{
						if(rs != null){
							try{
								rs.close();
							}catch(Exception ex){
								
							}
						}
						
						if(prepStmt != null){
							try{
								prepStmt.close();
							}catch(Exception ex){
								
							}
						}
						ConnectionManager.returnConnection(conn, request);
					}
					
					
					
            _bw.write(_wl_block33Bytes, _wl_block33);
	
				}else if("yes".equalsIgnoreCase(associateClicked)){
					if(entityName == null || entityName.trim().equals("")){
						out.println("<span>A view should be selected first.</span")	;
						return;
					}
					
					try {
						conn = ConnectionManager.getConnection(request);
					} catch (Exception e) {
						out.println("Could not get connection. Error Message ="+e.getMessage());
						return;
					}
					
					// safe approach
					if(conn == null){
						out.println("Error in showing the details as connection to the database was not obtained");
						return;
					}
					
					query = "SELECT referenced_owner AS TABLE_OWNER, referenced_name AS TABLE_NAME, OWNER AS REFERENCED_BY_OBJECT_OWNER, name AS REFERENCED_BY_OBJECT_NAME, TYPE AS REFERENCED_BY_OBJECT_TYPE FROM sys.dba_dependencies WHERE referenced_type='TABLE' AND referenced_owner='IBAEHIS' and name='"+entityName+"' ORDER BY 1,2";
					
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(entityName ));
            _bw.write(_wl_block35Bytes, _wl_block35);

					try{
						prepStmt = conn.prepareStatement(query);
						rs = prepStmt.executeQuery();
						if(rs != null){
					
					
            _bw.write(_wl_block36Bytes, _wl_block36);
	
							while(rs.next()){
								if(rowCounter % 2 == 1){
									styleClassName = "viewdatarowoddstyle";
								}else{
									styleClassName = "viewdatarowevenstyle";
								}
								rowCounter++;
								
					
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(styleClassName));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(rs.getString("TABLE_OWNER")));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(styleClassName));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(rs.getString("TABLE_NAME") ));
            _bw.write(_wl_block39Bytes, _wl_block39);
		
							}
					
            _bw.write(_wl_block40Bytes, _wl_block40);

						}
					
            _bw.write(_wl_block41Bytes, _wl_block41);
	
						}catch(Exception ex){
							out.println("Could not obtain records for "+entityName);
							return;
						}finally{
							if(rs != null){
								try{
									rs.close();
								}catch(Exception ex){
									
								}
							}
							
							if(prepStmt != null){
								try{
									prepStmt.close();
								}catch(Exception ex){
									
								}
							}
							ConnectionManager.returnConnection(conn, request);
						}
					
					
					
            _bw.write(_wl_block42Bytes, _wl_block42);
	
				}
			
			
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(moduleId ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(moduleName ));
            _bw.write(_wl_block45Bytes, _wl_block45);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
