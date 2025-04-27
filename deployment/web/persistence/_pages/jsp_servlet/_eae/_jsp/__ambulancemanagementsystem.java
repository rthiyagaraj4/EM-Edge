package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __ambulancemanagementsystem extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AmbulanceManagementSystem.jsp", 1709113870193L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eae/jsp/AmbulanceManagementSystemCode.jsp", 1709113772488L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eae/jsp/AmbulanceManagementSystemRequestDetail.jsp", 1709113870756L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eAE/html/fonts-min.css\"></link>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eAE/html/button.css\"></link>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eAE/html/stdbutton.css\"></link>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eAE/html/menu.css\"></link>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eAE/html/datatable.css\"></link>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eAE/html/AmbulanceManagementSystem.css\"></link>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\'../../eAE/html/autocomplete.css\'></link>\n \t<link rel=\"stylesheet\" type =\"text/css\" href=\'../../eAE/html/container.css\'></link>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\'../../eAE/html/container-skin.css\'></link> \n\t<link rel=\"stylesheet\" type =\"text/css\" href=\'../../eAE/html/skin.css\'></link> \n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eAE/html/keyboard.css\"> </link> \n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eAE/html/paginator.css\"> </link> \n\n\t<script type=\"text/javascript\" src=\"../../eAE/js/keyboard.js\" charset=\"UTF-8\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\t\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\" ></Script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/common.js\" ></Script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\" ></Script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/FieldFormatMethods.js\" ></Script>\n\t\n\t<script src=\'../../eAE/js/yahoo-dom-event.js\' language=\'javascript\'></script>\n\t<script src=\'../../eAE/js/connection-min.js\' language=\'javascript\'></script>\n\t<script src=\'../../eAE/js/element-min.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eAE/js/container-min.js\' language=\'javascript\'></script>\n    <script src=\'../../eAE/js/menu-min.js\' language=\'javascript\'></script>\n\t<script src=\'../../eAE/js/dragdrop-min.js\' language=\'javascript\'></script>\n\t<script src=\'../../eAE/js/datasource-min.js\' language=\'javascript\'></script> \n\t<script src=\'../../eAE/js/datatable-min.js\' language=\'javascript\'></script>  \n  \t<script src=\'../../eAE/js/animation-min.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eAE/js/autocomplete-min.js\' language=\'javascript\'></script>\n\t<script src=\'../../eAE/js/button-min.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eAE/js/paginator-min.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eAE/js/json-min.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eAE/js/event-min.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eAE/js/yahoo-min.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eAE/js/get-min.js\' language=\'javascript\'></script>\t\n\n\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></script>\n\t<script src=\'../../eAE/js/AmbulanceManagementSystem.js\' language=\'javascript\'></script>\n\t\n\t\n\t<style>\n\t.yui-simple-dialog .bd span.warnicon {\n    background: url(\"../../eAE/images/warn16_1.gif\") no-repeat;\n\t}\t\n\n\n\t</style>\n\n</head>\n<script type=\"text/javascript\">\n\nYAHOO.namespace(\"yuiData.StaticList\"); \nYAHOO.yuiData.StaticList.sex = [\"Male\", \"Female\",\"Unknown\"];\nYAHOO.yuiData.StaticList.priority= [\"Low\", \"Medium\", \"High\"];\nYAHOO.yuiData.StaticList.period= [\"Hours\", \"Days\"];\nYAHOO.yuiData.StaticList.tripStatus1= [\"Cancelled\", \"Completed\"];\nYAHOO.yuiData.StaticList.tripStatus2= [\"Cancelled\"];\n\n\nYAHOO.widget.DataTable.prototype.getTdEl = function(cell) {\n\tvar Dom = YAHOO.util.Dom,lang = YAHOO.lang,elCell,el = Dom.get(cell);\n\t// Validate HTML element\n\tif(el && (el.ownerDocument == document)) {\n\t\t// Validate TD element\n\t\tif(el.nodeName.toLowerCase() != \"td\") {\n\t\t\t// Traverse up the DOM to find the corresponding TR element\n\t\t\telCell = Dom.getAncestorByTagName(el, \"td\");\n\t\t}else {\n\t\t\telCell = el;\n\t\t}\n\t\t\n\t\t// Make sure the TD is in this TBODY\n\t\tif(elCell && (elCell.parentNode.parentNode == this._elTbody)) {\n\t\t\t// Now we can return the TD element\n\t\t\treturn elCell;\n\t\t}\n\t}else if(cell) {\n\t\tvar oRecord, nColKeyIndex;\n\t\t\n\t\tif(lang.isString(cell.columnKey) && lang.isString(cell.recordId)) {\n\t\t\toRecord = this.getRecord(cell.recordId);\n\t\t\tvar oColumn = this.getColumn(cell.columnKey);\n\t\t\tif(oColumn) {\n\t\t\t\tnColKeyIndex = oColumn.getKeyIndex();\n\t\t\t}\n\t\t}\n\t\tif(cell.record && cell.column && cell.column.getKeyIndex) {\n\t\t\toRecord = cell.record;\n\t\t\tnColKeyIndex = cell.column.getKeyIndex();\n\t\t}\n\t\tvar elRow = this.getTrEl(oRecord);\n\t\tif((nColKeyIndex !== null) && elRow && elRow.cells && elRow.cells.length > 0) {\n\t\t\treturn elRow.cells[nColKeyIndex] || null;\n\t\t}\n\t}\n\treturn null;\n};\n\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n<body class=\"yui-skin-sam\" OnMouseDown=\'CodeArrest()\' onload=\'getDfltValues()\' onkeydown=\"tabOnEnterKey();lockKey()\" > \n\n<div id=\"Layer1\" class=\"main\" > \n<form name=\"frmAmbMangmntSystem\" id=\"frmAmbMangmntSystem\"  action=\"..\\..\\servlet\\eAE.AmbulanceManagementServlet\" method=\'post\'>\n<input type=\'hidden\' id=\'virtKeypadDisplayYn\' name=\'virt_keypad_display_yn\' id=\'virt_keypad_display_yn\' value=\'N\'>\n<input type=\'hidden\' id=\'virKeypadDispFldYn\' name=\'virt_keypad_disp_fld_yn\' id=\'virt_keypad_disp_fld_yn\' value=\'N\'>\n<input type=\'hidden\' id=\'mode\' name=\'mode\' id=\'mode\' value=\'insert\'>\n\n<!----------------------------top-------------------------------------------------->\n\t\t<div id=\"Layer3\" class=\"top\">\n\t\t\t<table width=\"100%\" height=\"100%\"  border=\"0\" cellpadding=\"0\" cellspacing=\"0\" valign=\"top\">\n\t\t\t\t<tr class=\"SUB\">\n\t\t\t\t\t<td >\n\t\t\t\t\t\t<table width=\"100%\" height=\"100%\"  border=\"0\" cellpadding=\"0\" cellspacing=\"0\" valign=\"top\">\n\t\t\t\t\t\t\t<tr height=\"4%\"  valign=\"top\" width=\"100%\">\n\t\t\t\t\t\t\t\t<td align=\'left\' id=\'keyPadId\'>&nbsp;<input id=\'VkbImg\' type=\'text\' size=1  maxlength=1 class=\'img\'></td>\n\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" align=\"right\" valign=\"center\" width=\"97%\"><b>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</b>&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" align=\"right\" valign=\"center\" width=\"3%\"><img onclick=\"reQueryPage(\'refresh\')\" alt=\'Refresh\' src=\'../../eAE/images/Reset.gif\'/><img onclick=\"goHomePage()\" alt=\'Close\' src=\'../../eAE/images/MI_Close.gif\'></img></td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div> <!------------------------End -top-------------------------------------------------->\n\t\t\n\t\t\t  <!----------------------------Left-------------------------------------------------->\n\t\t<div id=\"Layer5A\" class=\"left-outer\" align=\"left\" valign=\"center\">&nbsp;<b>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</b> \n\t\t\t\t<div id=\'fillerDiv\'><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></div>\n\t\t\t<div id=\"Layer5\" class=\"left\" style=\'display:inline\'>\n\n\t\t\t<table border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"2\" valign=\"center\" align=\"left\" nowrap><input id=\"checkbutton1\" type=\"checkbox\" name=\"chkRqstd\" id=\"chkRqstd\" value=\"1\" ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="><label  class=\"label\" style=\"background-color:#BBBBFF\" >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</label></input>\n\t\t\t\t\t\t<input id=\"checkbutton2\" type=\"checkbox\" name=\"chkAssnd\" id=\"chkAssnd\" value=\"1\" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="><label  class=\"label\" style=\"background-color:#ECD9D9\" >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</label></input>\n\t\t\t\t\t\t<input id=\"checkbutton3\" type=\"checkbox\" name=\"chkCmpltd\" id=\"chkCmpltd\" value=\"1\"  ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="><label  class=\"label\" style=\"background-color:#DFFFDF\" >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</label></input>\n\t\t\t\t\t\t<input id=\"checkbutton4\" type=\"checkbox\" name=\"chkCancld\" id=\"chkCancld\" value=\"1\" ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="><label style=\"background-color:#FAABC0\" class=\"label\" >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</label></input>\n\t\t\t\t\t\t<label  class=\"label-blue\" style=\"background-color:white;cursor:pointer\" id=\"lblFromDate\" onclick=\"showCalendar1(\'from_date\',null,null,true,\'lblFromDate\',\'From\',\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\');return false;\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =":";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</label>\n                       <label class=\"label-blue\" id=\"lblToDate\" style=\"background-color:none;cursor:pointer\" onclick=\"showCalendar1(\'to_date\',null,null,true,\'lblToDate\',\'To\',\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</label>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'from_date\' id=\'from_date\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'/ >\n\t\t\t\t\t\t<input type=\'hidden\' name=\'to_date\' id=\'to_date\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'/ >\n\t\t\t\t\t\t \n\t\t\t\t\t\t <td align=\'right\' width=\'10%\'><div id=\"menubuttonsfromjavascript\" style=\"display:none\">\n\t\t\t\t\t\t </div>&nbsp;</td>\n\t\t\t\t\t\t <td align=\'right\' width=\'1%\'>&nbsp;</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr><td colspan=\"4\">&nbsp;</td></tr>\n\t\t\t\t\t<tbody>\n\t\t\t\t\t<tr >\t\n\t\t\t\t\t\t<td width=\"1%\">&nbsp;</td>\t\t\t\t\t\n\t\t\t\t\t\t<td  colspan=\"2\" valign=\"top\" align=\"left\" ><div id=\"ambRequst\" class=\"ambRequst\" style=\"left:1%\" style=\"display:inline\"></div><div id=\"ambRequstAll\" class=\"ambRequstAll\" style=\"display:none\" ></div>\n\t\t\t\t\t\t<table border = \'0\' width=\"95%\" height=\"3%\" cellpadding=\"0\" cellspacing=\"0\" >\n\t\t\t\t\t\t<tr id=\'search\' style=\"background: #7D98B8 url(\'../../eAE/images/sprite.png\') repeat-x 0 -1700px;\" >\n\t\t\t\t\t\t<td   align=\"right\"  class=\'label\' valign=\'center\' nowrap width=\"5%\" style=\"background: #7D98B8 url(\'../../eAE/images/sprite.png\') repeat-x 0 -1700px;\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =":</td><td  align=\"left\"  valign=\'center\' class=\'label\' nowrap width=\"25%\" style=\"background: #7D98B8 url(\'../../eAE/images/sprite.png\') repeat-x 0 -1700px;\"><input name=\"findText\" id=\"findText\" style=\"border : 1px normal #696969;font-size : 10px;font-family : Verdana;font-weight : normal;\" type=\"text\"   maxlength=\'30\' size=\'35\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"></td><td   align=\"left\"  valign=\'center\' width=\"5%\" nowrap class=\'label\' style=\"background: #7D98B8 url(\'../../eAE/images/sprite.png\') repeat-x 0 -1700px;\"><div class=button onClick=\'find()\' >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</div></td>\n\t\t\t\t\t\t<td   valign=\'center\' align=\"right\" nowrap style=\"background: #7D98B8 url(\'../../eAE/images/sprite.png\') repeat-x 0 -1700px;\">&nbsp;<div id=\"dt-paginator\" class=\"yui-skin-sam yui-pg-container\" style=\"text-align:right\"></div>\n\t\t\t\t\t\t<div id=\"dt-paginatorAll\" class=\"yui-skin-sam yui-pg-container\" style=\"display:none;text-align:right\"></div></td></tr></table>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td valign=\"center\" align=\"left\" width=\"1%\" height=\"100%\" nowrap><img id=\"imgleft\" src=\"../../eAE/images/ADSRight.gif\" onClick=\"expandHorizontaly(\'Layer5A\',\'Layer6A\',\'imgleft\',\'right\',\'1%\',\'98%\',\'1%\',\'54%\');\"/></td>\n\t\t\t\t\t</tr>\t\n\t\t\t\t\t\t</tbody>\n\t\t\t\t</table>\n\t\t\t\t<input type=\"hidden\" name=\"pat_name\" id=\"pat_name\" value=\"\"/>\n\t\t\t\t\n\t\t\t</div>\n\t\t</div>\n\t<!----------------------------End   Left----------------------------------------------->\n\t<!----------------------------Right-------------------------------------------------->\n\t\t<div id=\"Layer6A\" class=\"right-outer\" align=\"left\" valign=\"center\">&nbsp;<b>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</b>\n\t\t<div id=\'fillerDiv\'><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></div>\n\t\t\t<div id=\"Layer6\" class=\"right\" style=\'display:inline\'>\n\t\t\t\n\t\t\t<table border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\n<tr>\n\t<td width=\"3%\">&nbsp;</td>\n\t<td  width=\"87%\"><input id=\"checkbutton1\" type=\"checkbox\" name=\"ambAssnd\" id=\"ambAssnd\" value=\"1\" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</label></input>\n\t<input id=\"checkbutton2\" type=\"checkbox\" name=\"ambMntnce\" id=\"ambMntnce\" value=\"1\" ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" ><label style=\"background-color:#E1E1E1\"  class=\"label\" >";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</label></input>\n\t<input id=\"checkbutton3\" type=\"checkbox\" name=\"ambAvlble\" id=\"ambAvlble\" value=\"1\" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="><label style=\"background-color:#DFFFDF\"  class=\"label\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</label></input>\n\t</td>\n\t<td align=\"right\" width=\"10%\"><span id=\'spnPrevNext\'>\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="<img src=\"../../eAE/images/ADSprevious.gif\" id=\'imgPrev\' onClick=\"javascript:loadPage(\'chartPrev\');\" style=\"display:none\" />\n\t\t<img src=\"../../eAE/images/ADSnext.gif\" id=\'imgNext\' onClick=\"javascript:loadPage(\'chartNext\')\" />";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t</span></td>\n   <!-- <td align=\'right\' class=\"button\" onclick=\";\" onMouseOver=\'style.cursor=\"hand\";title=\"Go\"\'>Go</td>-->\n\t\n</tr>\n<tr>\n\t<td width=\"3%\">&nbsp;</td>\n\t<td colspan=\"2% width=\"97%\" valign=\"top\">\n<!------------------------------------when div is in normal size----------------------------------->\n\t<div id=\"ambChartImage\">\n\n\t<div id=\"ambChartImageAll\"><!----------------showing all Ambulance----------------------->\n\t\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\n\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t<div id=\'divPage";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' style=\"display:";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t<table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\n\t<tr>\n\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\n\t<td valign=\"top\" align=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t<div id=\"ambChart";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" name=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"class=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" valign=\"top\" ondblclick=\"loadAmbEntryDiv(\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\',\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\');\" > \n\t<div  class=\"chartText\">\n\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</div>\n\t</div>\n\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t</td>\n\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t</tr>\n\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="<tr>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t</table>\n\t</div>\n\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\n\t<input type=\"hidden\" name=\"totPage\" id=\"totPage\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" />\n\t<input type=\"hidden\" name=\"currPage\" id=\"currPage\" value=\"1\" />\n\n\t</div><!-----------End of showing all Ambulance--------------------->\n\n<div id=\"ambSatausB\" style=\"display:none\" style=\"background-color:ALICEBLUE;\"> <!-----------Div for Status B--------------------->\n\n<table border=\"0\" width=\"100%\" height=\"98%\" cellpadding=\"0\" cellspacing=\"0\" >\n<tr height=\"35%\">\n<td align=\"left\" valign=\"top\"><br>\n<div id=\"ambSelAmbB\" ></div>\n</td>\n</tr>\n<tr height=\"55%\">\n<td valign=\"top\">\n<table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" >\n<th colspan=\"2\" style=\"background-color:#CCCCCC\">";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</th>\n\n<tr>\n\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t <td width=\"75%\">\n\t \n\t <!--<input type=\"text\" class=\"text-box-nkb\" size=\"40\" id=\'txtCurrLocB\' name=\"txtCurrLocB\" id=\"txtCurrLocB\" onfocus=\'assignCurEle(this)\' /> -->\n\t <div id=\"toLocnAutoComplete\">\n\t\t\t\t<input id=\"txtCurrLocB\" name=\'txtCurrLocB\' id=\'txtCurrLocB\' type=\"text\" maxlength=\'60\' value=\'\'class=text-box onfocus=\'assignCurEle(this)\'> \n\t\t\t\t<input name=\"txtCurrLocB_code\" id=\"txtCurrLocB_code\" id=\"txtCurrLocB_code\" type=\"hidden\">\n\t\t\t\t<div id=\"currLocnBContainer\"></div>\n\t</div>\n\t \n\t \n\t </td>\n </tr>\n\n <tr>\n\t<td class=\"label\">";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n\t <td align=\"left\"><input type=\"checkbox\"  id=\'chkUnderRepairB\' name=\"chkUnderRepairB\" id=\"chkUnderRepairB\"  onclick=\"toggleDiv(this,divRprDetB,underRepairB)\"/>\n\t <input type=\"hidden\"  name=\"underRepairB\" id=\"underRepairB\" value=\"N\"/>\n\t </td>\n </tr>\n</table>\n<div id=\"divRprDetB\" style=\"display:none\">\n<table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" >\n<tr>\n\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t <td width=\"75%\"><input type=\"text\" class=\"text-box-mand-nkb\" size=\'19\'maxLength=\'19\' onblur=\'if(!ChkDate(this) || this.value==\"\") Alert(getMessage(\"AE_AMB_DATE\",\"AE\"),\"001\");\' id=\'txtprdFromB\' name=\"txtprdFromB\" id=\"txtprdFromB\" > <img  class=\"img\" align=\'ABSBOTTOM\' src=\"../../eAE/images/Calendar.gif\"  onClick=\"return showCalendar(\'txtprdFromB\',null,\'hh:mm\',true);\"></td>\n </tr>\n <tr>\n\t<td class=\"label\">";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\n\t<td class=\"label\">\n   \t<div id=\"periodAutoComplete\">\n\t<input name=\"txtPeriodB\" id=\"txtPeriodB\" maxlength=\'3\' type=\"text\" class=\"text-box-mand-nkb\" size=\"2\" onfocus=\'assignCurEle(this)\' id=\'txtPeriodB\'>\n\t\t\t\t<input id=\"periodInput\"  name=\"txtPeriodType\" id=\"txtPeriodType\" type=\"text\" class=text-box-mand-nkb>\n\t\t\t\t<div id=\"periodContainer\"></div>\n\t</div>\n\t</td>\n</tr>\n<!--<tr>\n\t<td class=\"label\">Period To</td>\n\t <td><input type=\"text\" class=\"text-box-nkb\" name=\"txtprdToA\" id=\"txtprdToA\" /> </td>\n </tr>-->\n<tr>\n\t<td class=\"label\">";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td>\n\t<td><textarea class=\'text-area\' wrap=virtual id=\'txtRemarksB\' name=\'txtRemarksB\' maxlength=\'500\'  onKeyPress=\'return CheckSpecChars(event);checkMaxLimit(this,500)\' onBlur=\"makeValidString(this)\" onkeyup=\'chopText(this,500)\' onchange=\'chopText(this,500)\' onfocus=\'assignCurEle(this)\'></textarea></td>\n</tr>\n\n</table>\n</div>\n</td>\n</tr>\n<tr>\n<td valign=\"bottom\" align=\"right\" colspan=\"2\"><input type=\"button\" id=\"btnRecB\" name=\"btnRecord\" id=\"btnRecord\" value=\"Record\" /><input type=\"button\" name=\"btnClose\" id=\"btnClose\" value=\"Close\" id=\"btnClB\" onclick=\"closeEntryDiv(\'ambSatausB\')\"/></td>\n</tr>\n</table>\n</div><!----------End of Div for Status B--------------------->\n\n<div id=\"ambSatausM\" style=\"display:none\" style=\"background-color:ALICEBLUE;\"><!----------Div for Status M--------------------->\n<table border=\"0\" width=\"100%\" height=\"98%\" cellpadding=\"0\" cellspacing=\"0\" >\n<tr height=\"35%\">\n<td valign=\"top\" align=\"left\"><br>\n<div id=\"ambSelAmbM\" ></div>\n</td>\n</tr>\n<tr height=\"55%\">\n<td valign=\"top\">\n<table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" >\n<th colspan=\"2\" style=\"background-color:#CCCCCC\">";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" </th>\n<tr>\n\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\t <td width=\"75%\">\n\t \n\t\n\n\t  <div id=\"toLocnAutoComplete\">\n\t\t\t\t<input id=\"txtCurrLocM\" name=\'txtCurrLocM\' id=\'txtCurrLocM\' type=\"text\" maxlength=\'60\' value=\'\'class=text-box onfocus=\'assignCurEle(this)\'> \n\t\t\t\t<input name=\"txtCurrLocM_code\" id=\"txtCurrLocM_code\" id=\"txtCurrLocM_code\" type=\"hidden\">\n\t\t\t\t<div id=\"currLocnMContainer\"></div>\n\t</div>\n\t \t \n\t \n\t </td>\n\n\t\n </tr>\n<tr>\n\t<td class=\"label\">";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t <td><input type=\"text\" class=\"text-box-nkb\" name=\"txtprdFromM\" id=\"txtprdFromM\" readonly/> </td>\n</tr>\n<tr>\n\t<td class=\"label\">";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\n\t <td><input name=\"txtPeriodM\" id=\"txtPeriodM\" type=\"text\" class=\"text-box-mand-nkb\" size=\"2\" readonly>\n\t\t <input name=\"txtPeriodTypeM\" id=\"txtPeriodTypeM\" type=\"text\" size=\"5\" class=text-box-nkb readonly> </td>\n</tr>\n<tr>\n\t<td class=\"label\">";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" </td>\n\t<td><textarea class=\'text-area\' wrap=virtual  readonly name=\'txtRemarksM\' id=\"txtRemarksM\" onfocus=\'assignCurEle(this)\'></textarea> </td>\n</tr>\n<tr>\n\t<td class=\"label\">";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td>\n\t <td align=\"left\"><input type=\"checkbox\"  id=\"chkRevokeRepairM\" onfocus=\'assignCurEle(this)\' name=\"chkRevokeRepairM\" id=\"chkRevokeRepairM\" onclick=\"setValueForCheckbox(chkRevokeRepairM,RevokeRepairM)\"/>\n\t <input type=\"hidden\"  name=\"RevokeRepairM\" id=\"RevokeRepairM\" value=\"N\"/>\n\t </td>\n </tr>\n</table>\n</td>\n</tr>\n<tr>\n\t<td align=\"right\" valign=\"bottom\"><input type=\"button\" id=\"btnRecM\" name=\"btnRecord\" id=\"btnRecord\" value=\"Record\"/><input type=\"button\" name=\"btnClose\" id=\"btnClose\" value=\"Close\" id=\"btnClM\" onclick=\"closeEntryDiv(\'ambSatausM\')\"/></td>\n</tr>\n</table>\n</div><!----------End of Div for Status M--------------------->\n\n<div id=\"ambSatausA\" style=\"display:none\" style=\"background-color:ALICEBLUE;\"><!----------Div for Status A--------------------->\n<table border=\"0\" width=\"100%\" height=\"98%\" cellpadding=\"0\" cellspacing=\"0\" >\n<tr height=\"30%\">\n<td align=\"left\" valign=\"top\">\n<div id=\"ambSelAmbA\" ></div>\n</td>\n</tr>\n<tr height=\"60%\">\n<td valign=\"top\">\n<table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" >\n<th colspan=\"4\" style=\"background-color:#CCCCCC\">";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" </th>\n<tr>\n\t<td  class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n\t <td colspan=\"3\" width=\"75%\">\n\t \n\t<!-- <input type=\"text\" class=\"text-box-nkb\" size=\"40\" name=\"txtCurrLocA\" id=\"txtCurrLocA\" id=\"txtCurrLocA\" onfocus=\'assignCurEle(this)\' />-->\n\t <div id=\"toLocnAutoComplete\">\n\t\t\t\t<input id=\"txtCurrLocA\" name=\'txtCurrLocA\' id=\'txtCurrLocA\' type=\"text\" maxlength=\'60\' value=\'\'class=text-box onfocus=\'assignCurEle(this)\'> \n\t\t\t\t<input name=\"txtCurrLocA_code\" id=\"txtCurrLocA_code\" id=\"txtCurrLocA_code\" type=\"hidden\">\n\t\t\t\t<div id=\"currLocnAContainer\"></div>\n\t</div>\n\t \n\t \n\t </td>\n </tr>\n<tr>\n\t<td class=\"label\" >";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" </td>\n\t<td colspan=\"3\"><textarea class=\'text-area\' wrap=virtual  name=\'txtRemarksA\' id=\"txtRemarksA\" onfocus=\'assignCurEle(this)\'></textarea> </td>\n</tr>\n<!--<tr>\n\t<td class=\"label\" colspan=\"2\">Reached Droping Location </td>\n\t<td colspan=\"2\"><input type=\"checkbox\"  name=\"chkReachDropLocnA\" id=\"chkReachDropLocnA\" onclick=\"setValueForCheckbox(chkReachDropLocnA,ReachDropLocnA);loadDestn();\"/>\n\t <input type=\"hidden\"  name=\"ReachDropLocnA\" id=\"ReachDropLocnA\" value=\"N\"/> </td>\n</tr>-->\n<tr>\n\t<td class=\"label\" >";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</td>\n\t<td colspan=\"3\"><input type=\"text\" class=\"text-box-nkb\" maxlength=\'12\' size=\"19\" name=\"txtDistCovrdA\" id=\"txtDistCovrdA\"  onblur=\"calcEndMeter(this,txtStartMeterA,txtEndMeterA,txtEndTimeA)\" /> <label id=\"distncUOM\" class=\"label\"></label></td>\n</tr>\n\n<tr>\n\t<td class=\"label\" >";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\n\t<td ><input type=\"text\" class=\"text-box-nkb\" size=\"19\" name=\"txtStartTimeA\" id=\"txtStartTimeA\" readonly /> </td>\n\t<td class=\"label\">";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td>\n\t<td><input type=\"text\" class=\"text-box-nkb\" size=\"19\" name=\"txtEndTimeA\" id=\"txtEndTimeA\" onblur=\'if(!ChkDate(this) || this.value==\"\") Alert(getAEMessage(\"AE_AMB_DATE\"),\"001\");\' /> <img  class=\"img\" align=\'ABSBOTTOM\' src=\"../../eAE/images/Calendar.gif\"  onClick=\"return showCalendar(\'txtEndTimeA\',null,\'hh:mm\',true);\"></td>\n</tr>\n\n<tr>\n\t<td class=\"label\" >";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n\t<td ><input type=\"text\" class=\"text-box-nkb\" size=\"19\" name=\"txtStartMeterA\" id=\"txtStartMeterA\" readonly/> </td>\n\t<td class=\"label\">";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</td>\n\t<td><input type=\"text\" class=\"text-box-nkb\" size=\"19\" maxlength=\'12\' name=\"txtEndMeterA\" id=\"txtEndMeterA\" onblur=\"calcDistCoverd(txtDistCovrdA,txtStartMeterA,this,txtEndTimeA)\"/> </td>\n</tr>\n\n</table>\n</td>\n</tr>\n<tr>\n\t<td align=\"right\" valign=\"bottom\"><input type=\"button\" id=\"btnRecA\" name=\"btnRecord\" id=\"btnRecord\" value=\"Record\"/><input type=\"button\" name=\"btnClose\" id=\"btnClose\" value=\"Close\" id=\"btnClA\" onclick=\"closeEntryDiv(\'ambSatausA\')\"/></td>\n</tr>\n</table>\n</div><!----------End of Div for Status A--------------------->\n\n</div>\n<!-------------------------------End of Div in normal size----------------------------------------->\n\n<!----------------when div is in expand mode----------------->\n<div id=\"ambChartTable\" style=\"display:none;font-size : 10px;font-family : Verdana;font-weight : normal;\"></div><div id=\'chartPaginatorTbl\'><table border = \'0\' width=\"98%\" height=\"3%\" cellpadding=\"0\" cellspacing=\"0\" ><tr id=\'search\' style=\"background: #7D98B8 url(\'../../eAE/images/sprite.png\') repeat-x 0 -1700px;\" ><td   valign=\'center\' align=\"right\" nowrap style=\"background: #7D98B8 url(\'../../eAE/images/sprite.png\') repeat-x 0 -1700px;\">&nbsp;<div id=\"dt-chartPaginator\" class=\"yui-skin-sam yui-pg-container\" style=\"display:none;text-align:right\"></div></td></tr></table></div>\n<!----------------when div is in expand mode----------------->\n\n</td>\n<td colspan=\"4\" valign=\"center\" align=\"right\" width=\"1%\" height=\"100%\"><img id=\"imgRight\" src=\"../../eAE/images/ADSLeft.gif\" onClick=\"expandHorizontaly(\'Layer6A\',\'Layer5A\',\'imgRight\',\'left\',\'1%\',\'98%\',\'55%\',\'44%\');\"/></td>\n</tr>\n\n</table>\n<input type=\"hidden\" name=\"dragAmbId\" id=\"dragAmbId\" value=\"\"/>\n<input type=\"hidden\" name=\"selAmbId\" id=\"selAmbId\" value=\"\"/>\n<input type=\"hidden\" name=\"selCaseno\" id=\"selCaseno\" value=\"\"/>\n\n<script>\nYAHOO.yuiData.ACJSArray = new function() {\n    // Instantiate first JS Array DataSource\n    this.oACDS = new YAHOO.widget.DS_JSArray(YAHOO.yuiData.StaticList.period);\n\n    // Instantiate first AutoComplete\n    this.oAutoComp = new YAHOO.widget.AutoComplete(\'periodInput\',\'periodContainer\', this.oACDS);\n    this.oAutoComp.prehighlightClassName = \"yui-ac-prehighlight\";\n    this.oAutoComp.typeAhead = true;\n    this.oAutoComp.useShadow = true;\n    this.oAutoComp.minQueryLength = 0;\n\tthis.oAutoComp.forceSelection = true; \n\n    this.oAutoComp.textboxFocusEvent.subscribe(function(){\n        var sInputValue = YAHOO.util.Dom.get(\'periodInput\').value;\n        if(sInputValue.length === 0) {\n            var oSelf = this;\n            setTimeout(function(){oSelf.sendQuery(sInputValue);},0);\n        }\n    });\n}\n\nYAHOO.namespace(\"yuiData.DynamicList.curLocnM\"); \nYAHOO.yuiData.DynamicList.curLocnM.ACJson = new function(){\n    this.oACDS = new YAHOO.widget.DS_XHR(\"AMBGetJSON.jsp\", [\"mp_res_town\",\"short_desc\",\"res_town_code\"]);\n\tthis.oACDS.responseType = YAHOO.widget.DS_XHR.TYPE_JSON; \n    this.oACDS.queryMatchContains = true;\n\tthis.oACDS.scriptQueryParam = \"short_desc\";\n    this.oACDS.scriptQueryAppend = \"table=mp_res_town\";\n \n    // Instantiate AutoComplete\n\tvar txtCurrLocM = document.getElementById(\'txtCurrLocM\');\n\tvar currLocnMContainer = document.getElementById(\'currLocnMContainer\');\n    this.oAutoComp = new YAHOO.widget.AutoComplete(txtCurrLocM,currLocnMContainer, this.oACDS);\n    this.oAutoComp.useShadow = true;\n\tthis.oAutoComp.minQueryLength = 1;\n\tthis.oAutoComp.maxResultsDisplayed = 7;\n\tthis.oAutoComp.connTimeout = 3000;\n\tthis.oAutoComp.typeAhead = true;\n\tthis.oAutoComp.maxCacheEntries = 0;\n\t//this.oAutoComp.forceSelection = true; \n\n    this.oAutoComp.formatResult = function(oResultItem, sQuery){\n\t\t var sValue = oResultItem[0];  \n\t\t var sKey = oResultItem[1];  // Has the Code \n\t\t var aMarkup = [\"<div class=\'text-box\'><span class=\'text-box\'>\",sValue,\"</span></div>\"];\n\t\t return (aMarkup.join(\"\"));\n\t};\n\n\n\tthis.oAutoComp.doBeforeExpandContainer = function(oTextbox, oContainer, sQuery, aResults) {\n        var pos = YAHOO.util.Dom.getXY(oTextbox);\n        pos[1] += YAHOO.util.Dom.get(oTextbox).offsetHeight + 2;\n        YAHOO.util.Dom.setXY(oContainer,pos);\n        return true;\n    };\n \n\t//Define the itemSelect handler function: To assign the NOC code to hidden variable\n\tvar itemSelectHandler = function(sType, aArgs) {\n\tYAHOO.log(sType); // this is a string representing the event;\n\t\t\t\t      \n\tvar oACInstance = aArgs[0]; // Current AutoComplete instance\n\tvar elListItem = aArgs[1];  // the <li> element selected in the suggestion container\n\tvar oData = aArgs[2];\t\t// object literal of data for the result, Code and description\n\tvar code = oData[1];\n\tdocument.getElementById(\'txtCurrLocM_code\').value=trimString(code);// Assign Code to hidden variable\n\t};//subscribe the handler to the event\n\tthis.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);};\n\n\n\tYAHOO.namespace(\"yuiData.DynamicList.curLocnA\"); \nYAHOO.yuiData.DynamicList.curLocnA.ACJson = new function(){\n    this.oACDS = new YAHOO.widget.DS_XHR(\"AMBGetJSON.jsp\", [\"mp_res_town\",\"short_desc\",\"res_town_code\"]);\n\tthis.oACDS.responseType = YAHOO.widget.DS_XHR.TYPE_JSON; \n    this.oACDS.queryMatchContains = true;\n\tthis.oACDS.scriptQueryParam = \"short_desc\";\n    this.oACDS.scriptQueryAppend = \"table=mp_res_town\";\n \n    // Instantiate AutoComplete\n\tvar txtCurrLocA = document.getElementById(\'txtCurrLocA\');\n\tvar currLocnAContainer = document.getElementById(\'currLocnAContainer\');\n    this.oAutoComp = new YAHOO.widget.AutoComplete(txtCurrLocA,currLocnAContainer, this.oACDS);\n    this.oAutoComp.useShadow = true;\n\tthis.oAutoComp.minQueryLength = 1;\n\tthis.oAutoComp.maxResultsDisplayed = 7;\n\tthis.oAutoComp.connTimeout = 3000;\n\tthis.oAutoComp.typeAhead = true;\n\tthis.oAutoComp.maxCacheEntries = 0;\n\t//this.oAutoComp.forceSelection = true; \n\n    this.oAutoComp.formatResult = function(oResultItem, sQuery){\n\t\t var sValue = oResultItem[0];  \n\t\t var sKey = oResultItem[1];  // Has the Code \n\t\t var aMarkup = [\"<div class=\'text-box\'><span class=\'text-box\'>\",sValue,\"</span></div>\"];\n\t\t return (aMarkup.join(\"\"));\n\t};\n\n\n\tthis.oAutoComp.doBeforeExpandContainer = function(oTextbox, oContainer, sQuery, aResults) {\n        var pos = YAHOO.util.Dom.getXY(oTextbox);\n        pos[1] += YAHOO.util.Dom.get(oTextbox).offsetHeight + 2;\n        YAHOO.util.Dom.setXY(oContainer,pos);\n        return true;\n    };\n \n\t//Define the itemSelect handler function: To assign the NOC code to hidden variable\n\tvar itemSelectHandler = function(sType, aArgs) {\n\tYAHOO.log(sType); // this is a string representing the event;\n\t\t\t\t      \n\tvar oACInstance = aArgs[0]; // Current AutoComplete instance\n\tvar elListItem = aArgs[1];  // the <li> element selected in the suggestion container\n\tvar oData = aArgs[2];\t\t// object literal of data for the result, Code and description\n\tvar code = oData[1];\n\tdocument.getElementById(\'txtCurrLocA_code\').value=trimString(code);// Assign Code to hidden variable\n\t};//subscribe the handler to the event\n\tthis.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);};\n\n\n\tYAHOO.namespace(\"yuiData.DynamicList.curLocnB\"); \nYAHOO.yuiData.DynamicList.curLocnB.ACJson = new function(){\n    this.oACDS = new YAHOO.widget.DS_XHR(\"AMBGetJSON.jsp\", [\"mp_res_town\",\"short_desc\",\"res_town_code\"]);\n\tthis.oACDS.responseType = YAHOO.widget.DS_XHR.TYPE_JSON; \n    this.oACDS.queryMatchContains = true;\n\tthis.oACDS.scriptQueryParam = \"short_desc\";\n    this.oACDS.scriptQueryAppend = \"table=mp_res_town\";\n \n    // Instantiate AutoComplete\n\tvar txtCurrLocB = document.getElementById(\'txtCurrLocB\');\n\tvar currLocnBContainer = document.getElementById(\'currLocnBContainer\');\n    this.oAutoComp = new YAHOO.widget.AutoComplete(txtCurrLocB,currLocnBContainer, this.oACDS);\n    this.oAutoComp.useShadow = true;\n\tthis.oAutoComp.minQueryLength = 1;\n\tthis.oAutoComp.maxResultsDisplayed = 7;\n\tthis.oAutoComp.connTimeout = 3000;\n\tthis.oAutoComp.typeAhead = true;\n\tthis.oAutoComp.maxCacheEntries = 0;\n\t//this.oAutoComp.forceSelection = true; \n\n    this.oAutoComp.formatResult = function(oResultItem, sQuery){\n\t\t var sValue = oResultItem[0];  \n\t\t var sKey = oResultItem[1];  // Has the Code \n\t\t var aMarkup = [\"<div class=\'text-box\'><span class=\'text-box\'>\",sValue,\"</span></div>\"];\n\t\t return (aMarkup.join(\"\"));\n\t};\n\n\n\tthis.oAutoComp.doBeforeExpandContainer = function(oTextbox, oContainer, sQuery, aResults) {\n        var pos = YAHOO.util.Dom.getXY(oTextbox);\n        pos[1] += YAHOO.util.Dom.get(oTextbox).offsetHeight + 2;\n        YAHOO.util.Dom.setXY(oContainer,pos);\n        return true;\n    };\n \n\t//Define the itemSelect handler function: To assign the NOC code to hidden variable\n\tvar itemSelectHandler = function(sType, aArgs) {\n\tYAHOO.log(sType); // this is a string representing the event;\n\t\t\t\t      \n\tvar oACInstance = aArgs[0]; // Current AutoComplete instance\n\tvar elListItem = aArgs[1];  // the <li> element selected in the suggestion container\n\tvar oData = aArgs[2];\t\t// object literal of data for the result, Code and description\n\tvar code = oData[1];\n\tdocument.getElementById(\'txtCurrLocB_code\').value=trimString(code);// Assign Code to hidden variable\n\t};//subscribe the handler to the event\n\tthis.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);};\n</script>\n\t\t\t\t\n\t\t\t</div>\n\t\t</div><!------------------------End -Right-------------------------------------------------->\n\t\t<div  id=\"Layer4A\" class=\"bottom-outer\" align=\"LEFT\" valign=\"Center\" ondblclick=\"switchView();\">\n\t\t<TABLE border=0 width=\'100%\' cellspacing=\"0\" cellpadding=\"0\">\n\t\t<TR>\n\t\t\t<TD valign=top width=\'53%\'>&nbsp;<b>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</b></TD>\n\t\t\t<TD valign =top align=\'left\'><img id=\"imgTop\" src=\"../../eAE/images/ADSUp.gif\" onClick=\"expandVertically(\'Layer4A\',\'Layer6A\',\'Layer5A\',\'imgTop\',\'6%\',\'92%\',\'48%\',\'49%\');\"/></TD>\n\t\t\t<td id=\'fillerCell\'><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></td>\n\t\t</TR>\n\t\t</TABLE>\n\t\t\t<div id=\"Layer4\" class=\"bottom\" style=\'display:inline\'>\n\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="<!DOCTYPE html>\n<!-- To display Ambulance Request Details - 4/14/2009 -->\n\n\t<div id=\'bottomLeft\' class=\'Bottom-Inner-Left\' style=\'display:inline\'>\n    <input type=hidden id=\'ambTripSheetNo\' name=\'ambTripSheetNo\' id=\'ambTripSheetNo\'> \n\t<input type=hidden id=\'ambUom\' name=\'amb_uom\' id=\'amb_uom\' value=\'\'> \n\t<input type=hidden id=\'amb_prefix_ind\' name=\'amb_prefix_ind\' id=\'amb_prefix_ind\'>\n\t<table border=0 width=\"100%\" height=\"95%\" cellspacing=\"0\" cellpadding=\"0\" style=\'\'>\n\t<tr><td colspan=4 class=label>&nbsp;</td></tr>\n\t<tr id=\'nocRow\'>\n\t\t<td class=label width=\'22%\'>";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</td>\n\t\t<td class=label >\n\t\t<div id=\"nocAutoComplete\">\n\t\t\t<input id=\"nocInput\" name=\"Nature_Of_Call\" id=\"Nature_Of_Call\" type=\"text\" class=text-box-mand   maxlength=\'6\' onfocus=\'assignCurEle(this)\' >\n\t\t\t<input id=\"nocInputCode\" name=\"amb_nature_call_code\" id=\"amb_nature_call_code\" type=\"hidden\">\n\t\t\t<div id=\"nocContainer\"></div>\n\t\t</div>\n\t\t</td>\n\t\t<td class=label align=\'right\'>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="&nbsp;</td>\n\t\t<td class=label align=\'left\'>\n\t\t\t<div id=\"priorityAutoComplete\">\n\t\t\t\t<input id=\"priorityInput\" name=\"Priority\" id=\"Priority\" type=\"text\" class=text-box  onfocus=\'assignCurEle(this)\' >\n\t\t\t\t<div id=\"priorityContainer\"></div>\n\t\t\t</div>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td class=label align=\'left\' nowrap>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="&nbsp;</td>\n\t\t<td class=label colspan=3>\n\t\t\t<input type=\'radio\'   name=\'Pickup_Location\' id=\'Pickup_Location\' id=\'pickUpLocn\' value=\'Y\' onClick=\'clearLocn(this);\' checked>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t<input type=\'radio\'   name=\'Pickup_Location\' id=\'Pickup_Location\' id=\'pickUpLocn\' value=\'N\' onClick=\'getLocn(this);\'>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td class=label>&nbsp;</td>\n\t\t<td colspan=3 class=pad >\n\t\t\t<div id=\"locnAutoComplete\">\n\t\t\t\t<input id=\"locnInput\" name=\"pickup_locn_desc\" id=\"pickup_locn_desc\" type=\"text\"  maxlength=\'60\' value=\'\' class=text-box onblur=\"insertMapVals();\" onKeyPress=\'return CheckSpecChars(event);\' onfocus=\'assignCurEle(this)\'>\n\t\t\t\t<input name=\"pickup_locn_code\" id=\"pickup_locn_code\" id=\"locnInputCode\" type=\"hidden\" value=\"\">\n\t\t\t\t<div id=\"locnContainer\"></div>\n\t\t\t</div>\n\t\t</td>\n\t</tr> \n\t<tr id=\'pickUpAddRow\' style=\'display:none\'>\n\t\t<td class=label align=\'left\'>";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="&nbsp;</td>\n\t\t<td colspan=3 class=label >\n\t\t<textarea  class=\'text-area\' WRAP=PHYSICAL id=\'pickUpAddress\' maxlength=\'2000\'  name=\'Pickup_Address\'  onKeyPress=\'return CheckSpecChars(event);checkMaxLimit(this,2000)\' onBlur=\"makeValidString(this)\" onkeyup=\'chopText(this,2000)\' onchange=\'chopText(this,2000)\' onfocus=\'assignCurEle(this)\'></textarea>\n\t\t</td>\n\t</tr>\n\t<tr id=\"trPickUpTime\">\n\t\t<td class=label align=\'left\'>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t\t<td class=label >";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="&nbsp;&nbsp;<input type=\'checkbox\'  id=\'immdtly\' name=\'immdtly\' id=\'immdtly\' align=\'ABSBOTTOM\' onclick=\'setPicupTime(this,\"pickupTime\")\'></td><td class=label colspan=2 align=\'left\'><input type=\'text\' class=\'text-box-nkb\' name=\'Pickup_Time\' id=\'Pickup_Time\' id=\'pickupTime\' size=\'19\'maxLength=\'19\' onblur=\'if(document.getElementById(\"mode\").value!=\"update\") validateDate(this,\"true\");\' value=\'\'><img  class=img align=\'ABSBOTTOM\' src=\"../../eAE/images/Calendar.gif\"  onClick=\"document.getElementById(\"Pickup_Time\").focus();return showCalendar(\'Pickup_Time\',null,\'hh:mm\',true);\">\n\t</tr>\n\t<tr id=\"trPickUpTimeText\" style=\"display:none\">\n\t\t<td class=label align=\'left\' >";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</td>\n\t\t<td class=label id=\"tdPickUpTime\" style=\"font-weight:bold\"></td>\n\t</tr>\n\t<tr>\n\t\t<td class=label align=\'left\' nowrap>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="&nbsp</td>\n\t\t<td class=label colspan=3 align=\'left\'>\n\t\t\t<input type=\'radio\' name=\'Dropping_Locn\' id=\'Dropping_Locn\' id=\'dropLocn\' value=\'Y\' checked onClick=\'clearLocn(this);\'>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =" \n\t\t\t<input type=\'radio\' name=\'Dropping_Locn\' id=\'Dropping_Locn\' id=\'dropLocn\' value=\'N\'onClick=\'getLocn(this);\'>";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td class=label>&nbsp;</td>\n\t\t<td colspan=3 class=pad>\n\t\t<div id=\"toLocnAutoComplete\">\n\t\t\t\t<input id=\"toLocnInput\" name=\'Dropping_Location\' id=\'Dropping_Location\' maxlength=\'60\' type=\"text\"  value=\'\'class=text-box onKeyPress=\'return CheckSpecChars(event);\' onfocus=\'assignCurEle(this)\'> \n\t\t\t\t<input name=\"destn_locn_code\" id=\"destn_locn_code\" id=\"toLocnInputCode\" type=\"hidden\">\n\t\t\t\t<div id=\"toLocnContainer\"></div>\n\t\t\t</div>\n\t\t</td>\n\t</tr>\n\t<tr id=\'dropAddRow\' style=\'display:none\'>\n\t\t<td class=label align=\'left\'>";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="&nbsp;</td>\n\t\t<td class=label colspan=3 >\n\t\t<textarea class=\'text-area\' WRAP=VIRTUAL id=\'dropAddress\' maxlength=\'2000\'  name=\'Drop_Address\'  onKeyPress=\'return CheckSpecChars(event);checkMaxLimit(this,2000)\' onBlur=\"makeValidString(this)\" onkeyup=\'chopText(this,2000)\' onchange=\'chopText(this,2000)\' onfocus=\'assignCurEle(this)\'></textarea>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td class=label >";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="&nbsp;&nbsp;</td>\n\t\t<td colspan=3>\n\t\t<table border=0  cellspacing=\"0\" cellpadding=\"0\">\n\t\t<tr>\n\t\t<td class=label align=\'right\'><input type=\'text\' class=\'text-box-mand\' id=\'patName\' name=\'Patient_Name\' id=\'Patient_Name\' size=\'30\' maxlength=\'30\' value=\'Unknown\' onfocus=\'if(this.value==\"Unknown\") this.value=\"\";assignCurEle(this)\' onblur=\'if(this.value==\"\")this.value=\"Unknown\";\'></td>\n\t\t<td align=\'left\' id=\"patSearch\" class=label><div class=button onClick=\'getPatID()\' title=\"Search Patients\" >?<div></td>\n\t\t<td class=label align=\'left\'>\n\t\t<td class=label align=\'right\'>&nbsp;&nbsp;";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="&nbsp;</td>\n\t\t<td class=label align=\'left\'>\n\t\t\t<div id=\"sexAutoComplete\">\n\t\t\t\t<input id=\"sexInput\" name=\"Gender\" id=\"Gender\" type=\"text\" class=text-box-nkb>\n\t\t\t\t<div id=\"sexContainer\"></div>\n\t\t\t</div>\n\t\t</td>\n\t\t<input type= hidden name=\'patient_id\' id=\'patient_id\' value=\'\'> \n\t\t<td class=label align=\'right\'>&nbsp;";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="&nbsp;</td>\n\t\t<td class=label><input type=\'text\' class=\'text-box-nkb\' id=\'patAge\' name=\'Age\' id=\'Age\' size=\'10\' maxlength=\'10\' onfocus=\'assignCurEle(this)\'></td>\n\t\t<td class=ymd id=\"YMD\" class=label onMouseOver=\'style.cursor=\"hand\";title=\"Click to Change to Y/M/D Format\"\' onClick=\'switchAgeUOM()\'><b>Y</b></td>\n\t\t<input type=\"hidden\" id=\'ageUom\' name=\'age_uom\' id=\'age_uom\' value=\'Y\'> \n\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t</tr>\n\n\t<tr id=\'escortRow\' style=\'display:none\'>\n\t\t<td class=label >";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</td>\n\t\t<td colspan=3 ><div id=\"escortAutoComplete\">\n\t\t\t<input id=\"escortInput\" name=\'Escort\' id=\'Escort\' type=\"text\" class=text-box>\n\t\t\t<input id=\"escortcInputCode\" name=\"escort_type_code\" id=\"escort_type_code\" type=\"hidden\">\n\t\t\t<div id=\"escortContainer\"></div>\n\t\t</div>\n\t\t</td>\n\t</tr>\n\t<tr id=\'attdByRow\' style=\'display:none\'>\n\t<td class=label >";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</td>\n\t\t<td colspan=3 class=pad>\n\t\t\t<div id=\"attdByAutoComplete\">\n\t\t\t\t<input id=\"attdByInput\" name=\'Attended_By\' id=\'Attended_By\' type=\"text\" class=text-box>\n\t\t\t\t<input id=\"attdByInputCode\" name=\"amb_case_recorded_by\" id=\"amb_case_recorded_by\" type=\"hidden\">\n\t\t\t\t<div id=\"attdByContainer\"></div>\n\t\t\t</div>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td class=label >";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="</td>\n\t\t<td colspan=3><input type=\'text\' class=\'text-box-mand\' id=\'callerName\' name=\'Requester_Name\' id=\'Requester_Name\' size=\'40\' maxlength=\'60\' onfocus=\'assignCurEle(this);\'></td>\n\t</tr>\n\t\n\t<tr>\n\t\t<td class=label >";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</td>\n\t\t<td colspan=3><input type=\'text\' class=\'text-box\' id=\'requestorphone\' name=\'Contact\' id=\'Contact\' size=\'40\' maxlength=\'30\' onKeyPress=\'return CheckSpecChars(event);\' onfocus=\'assignCurEle(this);\'></td>\n\t</tr>\n\t<tr> \n\t\t<td class=label >";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</td>\n\t\t<td class=label colspan=3>\n\t\t<textarea class=\'text-area\' wrap=virtual  id=\'rqstrRemarks\' name=\'Requester_Remarks\' maxlength=\'2000\'  onKeyPress=\'return CheckSpecChars(event);checkMaxLimit(this,2000)\' onBlur=\"makeValidString(this)\" onkeyup=\'chopText(this,2000)\' onchange=\'chopText(this,2000)\'  onfocus=\'assignCurEle(this);\'></textarea>\n\t\t</td>\n\t</tr>\n\t<tr id=\'gMapRow\' style=\'display:none\'>\n\t\t\t<td class=label >";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</td>\n\t\t\t<td class=label colspan=3><input type=\'text\' class=\'text-box\' id=\'mapLocnRegn\' name=\'Google_Map\' id=\'Google_Map\' size=\'50\' onfocus=\'assignCurEle(this)\'>\n\t\t\t<span align=\"left\" title= \"Print Location Map\" onclick = \"PrintLocnMap()\" onmouseover=\"style.cursor=\'hand\'\">&nbsp;<img align=\'middle\' src=\'../../eCommon/images/beprint.gif\'></img></span></td>\n\t</tr>\n\t</table>\n\t</div>\n\n\t<!-- Bottom-Inner-Right -->\n\t<div id=\'bottomRight\' class=\'Bottom-Inner-Right\' style=\'display:inline\'>\n\t<table id=\'bottomRightTab\' border=0 width=\"100%\" height=\"50%\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr>\n\t\t<td class=header width=\'25%\'></td>\n\t\t<td class=label  align=\'Right\'>&nbsp;</td>\n\t</tr>\n\n\t<tr>\n\t\t<td class=label valign=\'top\'>";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</td>\n\t\t<td valign=\'top\' >\n\t\t\t<div id=\"ambAutoComplete\">\n\t\t\t\t<input id=\"ambInput\" name=\'Ambulance\' id=\'Ambulance\' type=\"text\" onKeyPress=\'return CheckSpecChars(event);\' class=text-box>\n\t\t\t\t<input id=\"ambInputCode\" name=\'amb_vehicle_id\' id=\'amb_vehicle_id\' type=\"hidden\">\n\t\t\t\t<div id=\"ambContainer\"></div>\n\t\t\t</div>\n\t\t</td>\n\t</tr>\n\n\t\n\t<tr>\n\t\t<td class=label align=\'left\'>";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</td>\n\t\t<td  align=\'left\'><input type=\'checkbox\'  id=\'ambStartedYn\' name=\'amb_started_yn\' id=\'amb_started_yn\' align=\'ABSBOTTOM\' value=\"\" onclick=\'showActPickUp(this);\'></td>\n\t</tr>\n\n\t<tr id=\'tripStatusRow\'  style=\'display:none\'>\n\t<td class=label align=\'left\'>";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="</td>\n\t<td align=\'left\' colspan=\"2\" >\n\t<table border=\"0\" align=\'left\' cellspacing=\"0\" cellpadding=\"0\"> \n\t<tr >\n\t\t<td  class=label> &nbsp;<div  id=\"tripStatusAutoComplete1\" style=\'display:none;\'>\n\t\t\t\t<input id=\"tripStatusInput1\"  name=\'Trip_Status\' id=\'Trip_Status\' type=\"text\" class=text-box style=\"margin-top:-4px;\"><div id=\"tripStatusContainer1\"></div>\n\t\t\t</div>\n\t\t\t<div id=\"tripStatusAutoComplete2\" style=\'display:none;\'>\n\t\t\t\t<input id=\"tripStatusInput2\"  name=\'Trip_Status\' id=\'Trip_Status\' type=\"text\" class=text-box  style=\"margin-top:-4px;\">\n\t\t\t\t<div id=\"tripStatusContainer2\"></div>\n\t\t\t</div>\n\t\t</td>\n\t\t<td class=label> \n\t\t\t\t&nbsp;<input type=\'text\' class=\'text-box-nkb\' id=\'tripStatusTime\' value=\'\' name=\'Trip_Status_Time\' id=\'Trip_Status_Time\' size=\'19\' maxLength=\'19\' onblur=\'validateDate(this,\"true\");\' onfocus=\'assignCurEle(this)\'>\n\t\t\t\t<img  class=img align=\'ABSBOTTOM\' style=\"cursor:pointer\" src=\"../../eAE/images/Calendar.gif\"  onClick=\"document.getElementById(\"Trip_Status_Time\").focus();return showCalendar(\'Trip_Status_Time\',null,\'hh:mm\',true);\">\n\t\t\t\t<input id=\"tripStatusCode\" name=\'trip_status_code\' id=\'trip_status_code\' type=\"hidden\">\n\t\t</td>\n\t</tr></table>\n\t</td>\n\t</tr>\n\t\n\t<tr id=\"tripStatusText\" style=\"display:none\">\n\t<td class=label align=\'left\' width=\"30%\">";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</td>\n\t<td class=label id=\"tdCancelled\" style=\"font-weight:bold;\" width=\"70%\"></td>\n\t</tr>\n\t\n\t<tr id=\'amdTypeRow\' style=\'display:none\'>\n\t\t<td class=label >";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</td>\n\t\t<td >\n\t\t\t<div id=\"ambTypeAutoComplete\">\n\t\t\t\t<input id=\"ambTypeInput\" name=\'Ambulance_Type\' id=\'Ambulance_Type\' type=\"text\" class=text-box>\n\t\t\t\t<input id=\"ambTypeInputCode\" name=\'amb_service_type\' id=\'amb_service_type\' type=\"hidden\">\n\t\t\t\t<div id=\"ambTypeContainer\"></div>\n\t\t\t</div>\n\t\t</td>\n\t</tr>\n\n\t<tr id=\'ambStartMeter\' style=\'display:none\'>\n\t\t<td class=label >";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =" &nbsp;</td>\n\t\t<td class=label ><input type=\'text\' class=\'text-box-nkb\' id=\'startMileage\' name=\'Start_Mileage\' id=\'Start_Mileage\' maxlength=\'12\' size=\'10\' onfocus=\'assignCurEle(this)\' onKeyPress=\"return ChkNumberInput(this,event,0)\" >&nbsp;<span id=\'ambStrtMilUom\' class=label></span></td>\n\t\t<input type=hidden name=\'facAStrtMilUom\' id=\'facAStrtMilUom\' id=\'facAStrtMilUom\' value=\'\'>\n\t\t<input type=hidden name=\'facAStrtMilUomText\' id=\'facAStrtMilUomText\' id=\'facAStrtMilUomText\' value=\'\'>\n\t</tr>\n\t\n\t<tr id=\'ambExpDist\' style=\'display:none\'>\n\t\t<td class=label align=\'left\'>";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="&nbsp;</td>\n\t\t<td class=label><input type=\'text\' class=\'text-box-nkb\' id=\'totalDist\' maxlength=\'12\' name=\'Expected_Distance\' id=\'Expected_Distance\' size=\'10\' onfocus=\'assignCurEle(this)\' onKeyPress=\"return ChkNumberInput(this,event,0)\">&nbsp;<span id=\'totDistUom\' class=label></span></td>\n\t</tr>\n\t\n\t<tr id=\'actualPickupRow\' style=\'display:none\'>\n\t\t<td class=label >";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="&nbsp;</td>\n\t\t<td  align=\'left\'> <input type=\'text\' class=\'text-box-mand-nkb\' name=\'Actual_Pickup_Time\' id=\'Actual_Pickup_Time\' id=\'actualPickupTime\' size=\'19\'maxLength=\'19\' onfocus=\'assignCurEle(this)\' onblur=\'validateDate(this,\"true\");\' readonly>\n\t\t<img  class=img align=\'ABSBOTTOM\' id=\"imgActual_Pickup_Time\" style=\"cursor:pointer\" src=\"../../eAE/images/Calendar.gif\"  onClick=\"document.getElementById(\"Actual_Pickup_Time\").focus();return showCalendar(\'Actual_Pickup_Time\',null,\'hh:mm\',true);\">\n\t\t</td>\n\t</tr>\n\n\t<tr id=\"actualPickupRowText\" style=\"display:none\">\n\t\t<td class=label align=\'left\'>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="&nbsp;</td>\n\t\t<td class=label id=\"tdActPickUpTime\" style=\"font-weight:bold\"></td>\n\t</tr>\n\n\t<tr id=\'distCoveredRow\' style=\'display:none\'>  \n\t\t<td class=label align=\'left\'>";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="&nbsp;</td>\n\t\t<td class=label><input type=\'text\' class=\'text-box-nkb\' id=\'distCovered\' maxlength=\'12\' name=\'Distance_Covered\' id=\'Distance_Covered\' size=\'10\' onfocus=\'assignCurEle(this)\' onKeyPress=\"return ChkNumberInput(this,event,0)\" onblur=\"calcEndMeter(this,Start_Mileage,End_Mileage,Actual_Drop_Time)\">&nbsp;<span id=\'distCovUom\' class=label></span></td>\n\t</tr>\n\n\t<tr id=\'emRow\' style=\'display:none\'>\n\t\t<td class=label align=\'left\'>";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="&nbsp;</td>\n\t\t<td class=label><input type=\'text\' class=\'text-box-nkb\' id=\'endMileage\' maxlength=\'12\' name=\'End_Mileage\' id=\'End_Mileage\' size=\'10\' onfocus=\'assignCurEle(this)\'  onKeyPress=\"return ChkNumberInput(this,event,0)\" onblur=\"calcDistCoverd(Distance_Covered,Start_Mileage,this,Actual_Drop_Time)\">&nbsp;<span id=\'ambEndMilUom\' class=label></span></td>\n\t</tr>\n\t\n\t<tr id=\'dropTime\' style=\'display:none\'>\n\t\t<td class=label align=\'left\' >";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="&nbsp;</td>\n\t\t<td align=\'left\' ><input type=\'text\' class=\'text-box-nkb\' id=\'actualDropTime\' value=\'\' name=\'Actual_Drop_Time\' id=\'Actual_Drop_Time\' size=\'19\' maxLength=\'19\' onblur=\'validateDate(this,\"true\");\' onfocus=\'assignCurEle(this)\'>\n\t\t<img  class=img align=\'ABSBOTTOM\' style=\"cursor:pointer\" src=\"../../eAE/images/Calendar.gif\"  onClick=\"document.getElementById(\"Actual_Drop_Time\").focus();return showCalendar(\'Actual_Drop_Time\',null,\'hh:mm\',true);\">\n\t\t</td>\n\t</tr>\n\t\n\n\t<tr>\n\t\t<td class=label >";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="</td>\n\t\t<td class=label >\n\t\t<textarea class=\'text-area\' wrap=virtual  id=\'dispRemarks\' maxlength=\'2000\' name=\'Dispatch_Remarks\'  onKeyPress=\'return CheckSpecChars(event);checkMaxLimit(this,2000)\' onBlur=\"makeValidString(this)\" onkeyup=\'chopText(this,2000)\' onchange=\'chopText(this,2000)\' onfocus=\'assignCurEle(this)\'></textarea>\n\t\t</td>\n\t</tr>\n\t<tr id=\'ambResEq\' style=\'display:none\'>\n\t\t<td class=label>";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</td>\n\t\t<td align=\'left\' class=label>\n\t\t<div id=\"rsrcAutoComplete\">\n\t\t\t\t<input id=\"rsrcInput\" name=\'Resource\' id=\'Resource\' type=\"text\" class=text-box>\n\t\t\t\t<input id=\"rsrcInputCode\" type=\"hidden\">\n\t\t\t\t<div id=\"rsrcContainer\" ></div>\n\t\t\t</div>\n\t\t</td>\n\t</tr>\n\t</table>\n\t<input type=\'hidden\' name=\'rsrc_allocated\' id=\'rsrc_allocated\' id=\'rsrcAllocated\' value=\"\">\n\t<div id=\"ResDetails\" class=Res-Details >\n\t<table id=\"rsrcAllocDiv\" border=0 width=\"100%\"  cellspacing=\"0\" cellpadding=\"0\" style=\"display:none\">\n\t</table>\n\t<table id=\"rsrcDiv\" border=0 width=\"100%\"  cellspacing=\"0\" cellpadding=\"0\">\n\t</table>\n\t</div>\n\t\n\t<!-- Division to paint the Ambulance image -->\n\n\t<div id=\"ambChartR\" name=\"Req_Amb_Det\" class=\"Bottom-Inner-Right-Corner\" valign=\"top\"  style=\'display:none\'> \n\t</div>\n\t</div>\n\n\t<div id=\'bottomDown\' class=\'Bottom-Inner-Down\'>\n\t<div id=\'recClrBut\' align=\'right\' vAlign=\'middle\'><input type=\"button\" id=\"btnRec\" name=\"btn_record\" id=\"btn_record\" value=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\' /><input type=\"button\" name=\"btn_clear\" id=\"btn_clear\" value=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\' id=\"btnClear\" onclick=\"closeEntryDiv(\'ambSatausB\')\"/>&nbsp;</div>\n\t</div>\n\n\n<SCRIPT >\n\n\tinputArr = document.getElementsByTagName(\"input\");\n\tvar elemStr=\"\";\n\tvar tempstr = \"\";\n\tfor (var i = 0, elem; elem = inputArr[i++];)\n\t{\t/* Only text items */\n\t\ttempstr += \'~\'+elem.id+\'~\';\n\t\tif (elem.type==\'text\' || elem.type==\'textarea\')\n\t\t{\t/* With only valid ID names and class name should not have \"-nkb\" */\n\t\t\tif ( (elem.id != \'\') && (elem.className.indexOf(\"-nkb\")==-1) )\n\t\t\telemStr += \'~\'+elem.id;\n\t\t}\n\t}\n\tvar oPushButtonRec = new YAHOO.widget.Button(\"btnRec\");\n\toPushButtonRec.on(\"click\", recordDtl); \n\tvar oPushButtonClr = new YAHOO.widget.Button(\"btnClear\");\n\toPushButtonClr.on(\"click\", clearDtl); \n\n\n//-------------------------------Auto Complete---------------------------------------------------\n\tYAHOO.yuiData.ACJSArray = new function() {\n    // Instantiate first JS Array DataSource\n    this.oACDS = new YAHOO.widget.DS_JSArray(YAHOO.yuiData.StaticList.sex);\n\n    // Instantiate first AutoComplete\n    this.oAutoComp = new YAHOO.widget.AutoComplete(\'sexInput\',\'sexContainer\', this.oACDS);\n    this.oAutoComp.prehighlightClassName = \"yui-ac-prehighlight\";\n    this.oAutoComp.typeAhead = true;\n    this.oAutoComp.useShadow = true;\n    this.oAutoComp.minQueryLength = 0;\n\tthis.oAutoComp.forceSelection = true; \n\n    this.oAutoComp.textboxFocusEvent.subscribe(function(){\n        var sInputValue = YAHOO.util.Dom.get(\'sexInput\').value;\n        if(sInputValue.length === 0) {\n            var oSelf = this;\n            setTimeout(function(){oSelf.sendQuery(sInputValue);},0);\n        }\n    });\n\n    // Instantiate second JS Array DataSource\n    this.oACDS2 = new YAHOO.widget.DS_JSArray(YAHOO.yuiData.StaticList.priority);\n\n    // Instantiate second AutoComplete\n    this.oAutoComp = new YAHOO.widget.AutoComplete(\'priorityInput\',\'priorityContainer\', this.oACDS2);\n    this.oAutoComp.prehighlightClassName = \"yui-ac-prehighlight\";\n    this.oAutoComp.typeAhead = true;\n    this.oAutoComp.useShadow = true;\n    this.oAutoComp.minQueryLength = 0;\n\tthis.oAutoComp.forceSelection = true; \n\n\tthis.oAutoComp.textboxFocusEvent.subscribe(function(){\n        var sInputValue2 = YAHOO.util.Dom.get(\'priorityInput\').value;\n        if(sInputValue2.length === 0) {\n            var oSelf2 = this;\n            setTimeout(function(){oSelf2.sendQuery(sInputValue2);},0);\n        }\n    });\n\n\t\n    // Instantiate 3rd JS Array DataSource\n    this.oACDS = new YAHOO.widget.DS_JSArray(YAHOO.yuiData.StaticList.tripStatus1);\n\n    // Instantiate first AutoComplete\n    this.oAutoComp = new YAHOO.widget.AutoComplete(\'tripStatusInput1\',\'tripStatusContainer1\', this.oACDS);\n    this.oAutoComp.prehighlightClassName = \"yui-ac-prehighlight\";\n    this.oAutoComp.typeAhead = true;\n    this.oAutoComp.useShadow = true;\n    this.oAutoComp.minQueryLength = 0;\n\tthis.oAutoComp.forceSelection = true; \n\n    this.oAutoComp.textboxFocusEvent.subscribe(function(){\n        var sInputValue = YAHOO.util.Dom.get(\'tripStatusInput1\').value;\n        if(sInputValue.length === 0) {\n            var oSelf = this;\n            setTimeout(function(){oSelf.sendQuery(sInputValue);},0);\n        }\n    });\n\t//Define the itemSelect handler function: To assign the Escort code to hidden variable\n\tvar itemSelectHandler = function(sType, aArgs) {\n\tYAHOO.log(sType); // this is a string representing the event;\n\t\t\t\t      \n\tvar oACInstance = aArgs[0]; // Current AutoComplete instance\n\tvar elListItem = aArgs[1];  // the <li> element selected in the suggestion container\n\tvar oData = aArgs[2];\t\t// object literal of data for the result, Code and description\n\tvar code ;\n\tif (aArgs[1].innerText==\'Cancelled\')\n\t\tcode = \'X\';\n\telse\n\t\tcode = \'C\';\n\tassignStatusDate();\n\tdocument.getElementById(\'tripStatusCode\').value=code; // Assign Code to hidden variable\n\n\t};\n\t//subscribe the handler to the event\n\tthis.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);\n\n\t\n    // Instantiate 4th JS Array DataSource\n    this.oACDS = new YAHOO.widget.DS_JSArray(YAHOO.yuiData.StaticList.tripStatus2);\n\n    // Instantiate first AutoComplete\n    this.oAutoComp = new YAHOO.widget.AutoComplete(\'tripStatusInput2\',\'tripStatusContainer2\', this.oACDS);\n    this.oAutoComp.prehighlightClassName = \"yui-ac-prehighlight\";\n    this.oAutoComp.typeAhead = true;\n    this.oAutoComp.useShadow = true;\n    this.oAutoComp.minQueryLength = 0;\n\tthis.oAutoComp.forceSelection = true; \n\n    this.oAutoComp.textboxFocusEvent.subscribe(function(){\n        var sInputValue = YAHOO.util.Dom.get(\'tripStatusInput2\').value;\n        if(sInputValue.length === 0) {\n            var oSelf = this;\n            setTimeout(function(){oSelf.sendQuery(sInputValue);},0);\n        }\n    });\n\t\n\t//Define the itemSelect handler function: To assign the Escort code to hidden variable\n\tvar itemSelectHandler = function(sType, aArgs) {\n\tYAHOO.log(sType); // this is a string representing the event;\n\t\t\t\t      \n\tvar oACInstance = aArgs[0]; // Current AutoComplete instance\n\tvar elListItem = aArgs[1];  // the <li> element selected in the suggestion container\n\tvar oData = aArgs[2];\t\t// object literal of data for the result, Code and description\n\tvar code ;\n\tif (aArgs[1].innerText==\'Cancelled\')\n\t\tcode = \'X\';\n\telse\n\t\tcode = \'C\';\n\tassignStatusDate();\n\tdocument.getElementById(\'tripStatusCode\').value=code; \n\t// Assign Code to hidden variable\n\t};\n\t//subscribe the handler to the event\n\tthis.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);\n};\n\n\n\n\nYAHOO.namespace(\"yuiData.DynamicList.NOC\"); \nYAHOO.yuiData.DynamicList.NOC.ACJson = new function(){\n    this.oACDS = new YAHOO.widget.DS_XHR(\"AMBGetJSON.jsp\", [\"ae_amb_nature\",\"short_desc\",\"amb_nature_Code\"]);\n\tthis.oACDS.responseType = YAHOO.widget.DS_XHR.TYPE_JSON; \n    this.oACDS.queryMatchContains = true;\n\tthis.oACDS.scriptQueryParam = \"short_desc\";\n    this.oACDS.scriptQueryAppend = \"table=ae_amb_nature\";\n \n    // Instantiate AutoComplete\n\tvar nocInput = document.getElementById(\'nocInput\');\n\tvar nocContainer = document.getElementById(\'nocContainer\');\n    this.oAutoComp = new YAHOO.widget.AutoComplete(nocInput,nocContainer, this.oACDS);\n    this.oAutoComp.useShadow = true;\n\tthis.oAutoComp.minQueryLength = 1;\n\tthis.oAutoComp.maxResultsDisplayed = 20;\n\tthis.oAutoComp.connTimeout = 3000;\n\tthis.oAutoComp.typeAhead = true;\n\tthis.oAutoComp.maxCacheEntries = 0;\n\tthis.oAutoComp.forceSelection = true; \n\tthis.oAutoComp.autoHighlight  = true; \n\tthis.oAutoComp.useIFrame    = true; \n    this.oAutoComp.animVert  = true;\n\n    this.oAutoComp.formatResult = function(oResultItem, sQuery){\n\t\t var sValue = oResultItem[0];  \n\t\t var sKey = oResultItem[1];  // Has the Code \n\t\t var aMarkup = [\"<div class=\'text-box\'><span class=\'text-box\'>\",sValue,\"</span></div>\"];\n\t\t return (aMarkup.join(\"\"));\n\t};\n\n\n\tthis.oAutoComp.doBeforeExpandContainer = function(oTextbox, oContainer, sQuery, aResults) {\n        var pos = YAHOO.util.Dom.getXY(oTextbox);\n        pos[1] += YAHOO.util.Dom.get(oTextbox).offsetHeight + 2;\n        YAHOO.util.Dom.setXY(oContainer,pos);\n        return true;\n    };\n \n\t//Define the itemSelect handler function: To assign the NOC code to hidden variable\n\tvar itemSelectHandler = function(sType, aArgs) {\n\tYAHOO.log(sType); // this is a string representing the event;\n\tvar oACInstance = aArgs[0]; // Current AutoComplete instance\n\tvar elListItem = aArgs[1];  // the <li> element selected in the suggestion container\n\tvar oData = aArgs[2];\t\t// object literal of data for the result, Code and description\n\tvar code = oData[1];\n\tdocument.getElementById(\'nocInputCode\').value=code; // Assign Code to hidden variable\n\t};\n\t//subscribe the handler to the event\n\tthis.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);\n\n\n\t/*var typedItemHandler = function(sType, aArgs) {\n\tYAHOO.log(sType); // this is a string representing the event;\n\tvar oACInstance = aArgs[0]; // Current AutoComplete instance\n\tvar oData = aArgs[2];\t\t// sPrefill <String>  The prefill string. \n\talert(\'aArgs[1] \'+aArgs[1]);\n\talert(\'aArgs[2] \'+aArgs[2]);\n\t//document.getElementById(\'nocInput\').value=aArgs[1]+oData; // Assign Code to hidden variable\n\t};\n\tthis.oAutoComp.typeAheadEvent.subscribe(typedItemHandler);\n\t*/\n\n\tvar refocus = function(sType, aArgs) {\n\t\tYAHOO.log(sType); // this is a string representing the event;\n\t\tvar oACInstance = aArgs[0]; // Current AutoComplete instance\n\t\tdocument.getElementById(\'nocInput\').focus(); // Assign Code to hidden variable\n\t};\n\t//this.oAutoComp.selectionEnforceEvent.subscribe(refocus);\n\n};\n\nYAHOO.namespace(\"yuiData.DynamicList.Escort\"); \nYAHOO.yuiData.DynamicList.Escort.ACJson = new function(){\n    this.oACDS = new YAHOO.widget.DS_XHR(\"AMBGetJSON.jsp\", [\"am_escort_type\",\"short_desc\",\"escort_type_code\"]);\n\tthis.oACDS.responseType = YAHOO.widget.DS_XHR.TYPE_JSON; \n    this.oACDS.queryMatchContains = true;\n\tthis.oACDS.scriptQueryParam = \"short_desc\";\n    this.oACDS.scriptQueryAppend = \"table=am_escort_type\";\n\t\n    // Instantiate AutoComplete\n\tvar escortInput = document.getElementById(\'escortInput\');\n\tvar escortContainer = document.getElementById(\'escortContainer\');\n    this.oAutoComp = new YAHOO.widget.AutoComplete(escortInput,escortContainer, this.oACDS);\n    this.oAutoComp.useShadow = true;\n\tthis.oAutoComp.minQueryLength = 1;\n\tthis.oAutoComp.maxResultsDisplayed = 10;\n\tthis.oAutoComp.connTimeout = 3000;\n\tthis.oAutoComp.typeAhead = true;\n\tthis.oAutoComp.maxCacheEntries = 0;\n\tthis.oAutoComp.forceSelection = true; \n\n\t\n    this.oAutoComp.formatResult = function(oResultItem, sQuery){\n\t\t var sValue = oResultItem[0];  \n\t\t var sKey = oResultItem[1];  // Has the Code \n\t\t var aMarkup = [\"<div class=\'text-box\'><span class=\'text-box\'>\",sValue,\"</span></div>\"];\n\t\t return (aMarkup.join(\"\"));\n\t};\n\n\n\tthis.oAutoComp.doBeforeExpandContainer = function(oTextbox, oContainer, sQuery, aResults) {\n        var pos = YAHOO.util.Dom.getXY(oTextbox);\n        pos[1] += YAHOO.util.Dom.get(oTextbox).offsetHeight + 2;\n        YAHOO.util.Dom.setXY(oContainer,pos);\n        return true;\n    };\n \n   //Define the itemSelect handler function: To assign the Escort code to hidden variable\n\tvar itemSelectHandler = function(sType, aArgs) {\n\tYAHOO.log(sType); // this is a string representing the event;\n\t\t    \n\tvar oACInstance = aArgs[0]; // Current AutoComplete instance\n\tvar elListItem = aArgs[1];  // the <li> element selected in the suggestion container\n\tvar oData = aArgs[2];\t\t// object literal of data for the result, Code and description\n\tvar code = oData[1];\n\tdocument.getElementById(\'escortcInputCode\').value=code; \n\t\t\n\t// Assign Code to hidden variable\n\t};\n\t//subscribe the handler to the event\n\tthis.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);\n\n\tvar refocus = function(sType, aArgs) {\n\t\tYAHOO.log(sType); // this is a string representing the event;\n\t\tvar oACInstance = aArgs[0]; // Current AutoComplete instance\n\t\tdocument.getElementById(\'escortInput\').focus(); // Assign Code to hidden variable\n\t};\n\t//this.oAutoComp.selectionEnforceEvent.subscribe(refocus); Mahesh commented\n\t\n};\n\nYAHOO.namespace(\"yuiData.DynamicList.attdBy\"); \nYAHOO.yuiData.DynamicList.attdBy.ACJson = new function(){\n    this.oACDS = new YAHOO.widget.DS_XHR(\"AMBGetJSON.jsp\", [\"sm_appl_user\",\"appl_user_name\",\"appl_user_id\"]);\n\tthis.oACDS.responseType = YAHOO.widget.DS_XHR.TYPE_JSON; \n    this.oACDS.queryMatchContains = true;\n\tthis.oACDS.scriptQueryParam = \"appl_user_name\";\n    this.oACDS.scriptQueryAppend = \"table=sm_appl_user\";\n \n    // Instantiate AutoComplete\n\tvar attdByInput = document.getElementById(\'attdByInput\');\n\tvar attdByContainer = document.getElementById(\'attdByContainer\');\n    this.oAutoComp = new YAHOO.widget.AutoComplete(attdByInput,attdByContainer, this.oACDS);\n    this.oAutoComp.useShadow = true;\n\tthis.oAutoComp.minQueryLength = 1;\n\tthis.oAutoComp.maxResultsDisplayed = 6;\n\tthis.oAutoComp.connTimeout = 3000;\n\tthis.oAutoComp.typeAhead = true;\n\tthis.oAutoComp.maxCacheEntries = 0;\n\tthis.oAutoComp.forceSelection = true; \n\n    this.oAutoComp.formatResult = function(oResultItem, sQuery){\n\t\t var sValue = oResultItem[0];  \n\t\t var sKey = oResultItem[1];  // Has the Code \n\t\t var aMarkup = [\"<div class=\'text-box\'><span class=\'text-box\'>\",sValue,\"</span></div>\"];\n\t\t return (aMarkup.join(\"\"));\n\t};\n\n\n\tthis.oAutoComp.doBeforeExpandContainer = function(oTextbox, oContainer, sQuery, aResults) {\n        var pos = YAHOO.util.Dom.getXY(oTextbox);\n        pos[1] += YAHOO.util.Dom.get(oTextbox).offsetHeight + 2;\n        YAHOO.util.Dom.setXY(oContainer,pos);\n        return true;\n    };\n\t//Define the itemSelect handler function: To assign the AttdBy code to hidden variable\n\tvar itemSelectHandler = function(sType, aArgs) {\n\tYAHOO.log(sType); // this is a string representing the event;\n\t\t\t\t      \n\tvar oACInstance = aArgs[0]; // Current AutoComplete instance\n\tvar elListItem = aArgs[1];  // the <li> element selected in the suggestion container\n\tvar oData = aArgs[2];\t\t// object literal of data for the result, Code and description\n\tvar code = oData[1];\n\tdocument.getElementById(\'attdByInputCode\').value=code; // Assign Code to hidden variable\n\t};\n\t//subscribe the handler to the event\n\tthis.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);\n\n/*\tvar refocus = function(sType, aArgs) {\n\t\tYAHOO.log(sType); // this is a string representing the event;\n\t\tvar oACInstance = aArgs[0]; // Current AutoComplete instance\n\t\tdocument.getElementById(\'attdByInput\').focus(); // Assign Code to hidden variable\n\t};\n\tthis.oAutoComp.selectionEnforceEvent.subscribe(refocus);\n\t*/\n};\n\nYAHOO.namespace(\"yuiData.DynamicList.Locn\"); \nYAHOO.yuiData.DynamicList.Locn.ACJson = new function(){\n    this.oACDS = new YAHOO.widget.DS_XHR(\"AMBGetJSON.jsp\", [\"mp_res_town\",\"short_desc\",\"res_town_code\"]);\n\tthis.oACDS.responseType = YAHOO.widget.DS_XHR.TYPE_JSON; \n    this.oACDS.queryMatchContains = true;\n\tthis.oACDS.scriptQueryParam = \"short_desc\";\n    this.oACDS.scriptQueryAppend = \"table=mp_res_town\";\n \n    // Instantiate AutoComplete\n\tvar locnInput = document.getElementById(\'locnInput\');\n\tvar locnContainer = document.getElementById(\'locnContainer\');\n    this.oAutoComp = new YAHOO.widget.AutoComplete(locnInput,locnContainer, this.oACDS);\n    this.oAutoComp.useShadow = true;\n\tthis.oAutoComp.minQueryLength = 1;\n\tthis.oAutoComp.maxResultsDisplayed = 10;\n\tthis.oAutoComp.connTimeout = 3000;\n\tthis.oAutoComp.typeAhead = true;\n\tthis.oAutoComp.maxCacheEntries = 0;\n\t//this.oAutoComp.forceSelection = true; \n\tthis.oAutoComp.autoHighlight  = true; \n\tthis.oAutoComp.useIFrame    = true; \n    this.oAutoComp.animVert  = true;\n\n\n\n    this.oAutoComp.formatResult = function(oResultItem, sQuery){\n\t\t var sValue = oResultItem[0];  \n\t\t var sKey = oResultItem[1];  // Has the Code \n\t\t var aMarkup = [\"<div class=\'text-box\'><span class=\'text-box\'>\",sValue,\"</span></div>\"];\n\t\t return (aMarkup.join(\"\"));\n\t};\n\n\n\tthis.oAutoComp.doBeforeExpandContainer = function(oTextbox, oContainer, sQuery, aResults) {\n        var pos = YAHOO.util.Dom.getXY(oTextbox);\n        pos[1] += YAHOO.util.Dom.get(oTextbox).offsetHeight + 2;\n        YAHOO.util.Dom.setXY(oContainer,pos);\n        return true;\n    };\n \n   //Define the itemSelect handler function: To assign the Locn code to hidden variable\n\tvar itemSelectHandler = function(sType, aArgs) {\n\tYAHOO.log(sType); // this is a string representing the event;\n\t\t\t\t      \n\tvar oACInstance = aArgs[0]; // Current AutoComplete instance\n\tvar elListItem = aArgs[1];  // the <li> element selected in the suggestion container\n\tvar oData = aArgs[2];\t\t// object literal of data for the result, Code and description\n\tvar code = oData[1];\n\tdocument.getElementById(\'locnInputCode\').value=trimString(code,\"\\\\n\"); // Assign Code to hidden variable\n\t};\n\t//subscribe the handler to the event\n\tthis.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);\n};\n\nYAHOO.namespace(\"yuiData.DynamicList.toLocn\"); \nYAHOO.yuiData.DynamicList.toLocn.ACJson = new function(){\n    this.oACDS = new YAHOO.widget.DS_XHR(\"AMBGetJSON.jsp\", [\"mp_res_town\",\"short_desc\",\"res_town_code\"]);\n\tthis.oACDS.responseType = YAHOO.widget.DS_XHR.TYPE_JSON; \n    this.oACDS.queryMatchContains = true;\n\tthis.oACDS.scriptQueryParam = \"short_desc\";\n    this.oACDS.scriptQueryAppend = \"table=mp_res_town\";\n \n    // Instantiate AutoComplete\n\tvar toLocnInput = document.getElementById(\'toLocnInput\');\n\tvar toLocnContainer = document.getElementById(\'toLocnContainer\');\n    this.oAutoComp = new YAHOO.widget.AutoComplete(toLocnInput,toLocnContainer, this.oACDS);\n    this.oAutoComp.useShadow = true;\n\tthis.oAutoComp.minQueryLength = 1;\n\tthis.oAutoComp.maxResultsDisplayed = 7;\n\tthis.oAutoComp.connTimeout = 3000;\n\tthis.oAutoComp.typeAhead = true;\n\tthis.oAutoComp.maxCacheEntries = 0;\n\t//this.oAutoComp.forceSelection = true; \n\n    this.oAutoComp.formatResult = function(oResultItem, sQuery){\n\t\t var sValue = oResultItem[0];  \n\t\t var sKey = oResultItem[1];  // Has the Code \n\t\t var aMarkup = [\"<div class=\'text-box\'><span class=\'text-box\'>\",sValue,\"</span></div>\"];\n\t\t return (aMarkup.join(\"\"));\n\t};\n\n\n\tthis.oAutoComp.doBeforeExpandContainer = function(oTextbox, oContainer, sQuery, aResults) {\n        var pos = YAHOO.util.Dom.getXY(oTextbox);\n        pos[1] += YAHOO.util.Dom.get(oTextbox).offsetHeight + 2;\n        YAHOO.util.Dom.setXY(oContainer,pos);\n        return true;\n    };\n \n\t//Define the itemSelect handler function: To assign the NOC code to hidden variable\n\tvar itemSelectHandler = function(sType, aArgs) {\n\tYAHOO.log(sType); // this is a string representing the event;\n\t\t\t\t      \n\tvar oACInstance = aArgs[0]; // Current AutoComplete instance\n\tvar elListItem = aArgs[1];  // the <li> element selected in the suggestion container\n\tvar oData = aArgs[2];\t\t// object literal of data for the result, Code and description\n\tvar code = oData[1];\n\tdocument.getElementById(\'tolocnInputCode\').value=trimString(code);// Assign Code to hidden variable\n\t};//subscribe the handler to the event\n\tthis.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);};\n\nYAHOO.namespace(\"yuiData.DynamicList.AMB\"); \nYAHOO.yuiData.DynamicList.AMB.ACJson = new function(){\n    this.oACDS = new YAHOO.widget.DS_XHR(\"AMBGetJSON.jsp\", [\"ae_amb_vehicle\",\"amb_vehicle_name\",\"amb_vehicle_id\"]);\n\tthis.oACDS.responseType = YAHOO.widget.DS_XHR.TYPE_JSON; \n    this.oACDS.queryMatchContains = true;\n\tthis.oACDS.scriptQueryParam  = \"amb_vehicle_name\";\n    this.oACDS.scriptQueryAppend = \"table=ae_amb_vehicle\";\n \n    // Instantiate AutoComplete\n\tvar ambInput = document.getElementById(\'ambInput\');\n\tvar ambContainer = document.getElementById(\'ambContainer\');\n    this.oAutoComp = new YAHOO.widget.AutoComplete(ambInput,ambContainer, this.oACDS);\n    this.oAutoComp.useShadow = true;\n\tthis.oAutoComp.minQueryLength = 1;\n\tthis.oAutoComp.maxResultsDisplayed = 10;\n\tthis.oAutoComp.connTimeout = 3000;\n\tthis.oAutoComp.typeAhead = true;\n\tthis.oAutoComp.maxCacheEntries = 0;\n\tthis.oAutoComp.forceSelection = true; \n\n    this.oAutoComp.formatResult = function(oResultItem, sQuery){\n\t\t var sValue = oResultItem[0];  \n\t\t var sKey = oResultItem[1];  // Has the Code \n\t\t var aMarkup = [\"<div class=\'text-box\'><span class=\'text-box\'>\",sValue,\"</span></div>\"];\n\t\t return (aMarkup.join(\"\"));\n\t};\n\n\n\tthis.oAutoComp.doBeforeExpandContainer = function(oTextbox, oContainer, sQuery, aResults) {\n        var pos = YAHOO.util.Dom.getXY(oTextbox);\n        pos[1] += YAHOO.util.Dom.get(oTextbox).offsetHeight + 2;\n        YAHOO.util.Dom.setXY(oContainer,pos);\n        return true;\n    };\n \n\t//Define the itemSelect handler function: To assign the Ambulance code to hidden variable\n\tvar itemSelectHandler = function(sType, aArgs) {\n\tYAHOO.log(sType); // this is a string representing the event;\n\t\t\t\t      \n\tvar oACInstance = aArgs[0]; // Current AutoComplete instance\n\tvar elListItem = aArgs[1];  // the <li> element selected in the suggestion container\n\tvar oData = aArgs[2];\t\t// object literal of data for the result, Code and description\n\tvar code = oData[1];\n\tdocument.getElementById(\'ambInputCode\').value=code; // Assign Code to hidden variable\n\tdrawVehicle();\n\t};\n\t//subscribe the handler to the event\n\tthis.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);\n\n\t/*var refocus = function(sType, aArgs) {\n\t\tYAHOO.log(sType); // this is a string representing the event;\n\t\tvar oACInstance = aArgs[0]; // Current AutoComplete instance\n\t\tdocument.getElementById(\'ambInput\').focus(); // Assign Code to hidden variable\n\t};\n\tthis.oAutoComp.selectionEnforceEvent.subscribe(refocus);*/\n };\n\nYAHOO.namespace(\"yuiData.DynamicList.AmbType\"); \nYAHOO.yuiData.DynamicList.AmbType.ACJson = new function(){\n    this.oACDS = new YAHOO.widget.DS_XHR(\"AMBGetJSON.jsp\", [\"ae_amb_service_type\",\"long_desc\",\"amb_service_type\"]);\n\tthis.oACDS.responseType = YAHOO.widget.DS_XHR.TYPE_JSON; \n    this.oACDS.queryMatchContains = true;\n\tthis.oACDS.scriptQueryParam  = \"long_desc\";\n    this.oACDS.scriptQueryAppend = \"table=ae_amb_service_type\";\n\n    // Instantiate AutoComplete\n\tvar ambTypeInput = document.getElementById(\'ambTypeInput\');\n\tvar ambTypeContainer = document.getElementById(\'ambTypeContainer\');\n    this.oAutoComp = new YAHOO.widget.AutoComplete(ambTypeInput,ambTypeContainer, this.oACDS);\n    this.oAutoComp.useShadow = true;\n\tthis.oAutoComp.minQueryLength = 1;\n\tthis.oAutoComp.maxResultsDisplayed = 10;\n\tthis.oAutoComp.connTimeout = 3000;\n\tthis.oAutoComp.typeAhead = true;\n\tthis.oAutoComp.maxCacheEntries = 0;\n\tthis.oAutoComp.forceSelection = true; \n\n    this.oAutoComp.formatResult = function(oResultItem, sQuery){\n\t\t var sValue = oResultItem[0];  \n\t\t var sKey = oResultItem[1];  // Has the Code \n\t\t var aMarkup = [\"<div class=\'text-box\'><span class=\'text-box\'>\",sValue,\"</span></div>\"];\n\t\t return (aMarkup.join(\"\"));\n\t};\n\n\n\tthis.oAutoComp.doBeforeExpandContainer = function(oTextbox, oContainer, sQuery, aResults) {\n        var pos = YAHOO.util.Dom.getXY(oTextbox);\n        pos[1] += YAHOO.util.Dom.get(oTextbox).offsetHeight + 2;\n        YAHOO.util.Dom.setXY(oContainer,pos);\n        return true;\n    };\n \n\t//Define the itemSelect handler function: To assign the Ambulance code to hidden variable\n\tvar itemSelectHandler = function(sType, aArgs) {\n\tYAHOO.log(sType); // this is a string representing the event;\n\t\t\t\t      \n\tvar oACInstance = aArgs[0]; // Current AutoComplete instance\n\tvar elListItem = aArgs[1];  // the <li> element selected in the suggestion container\n\tvar oData = aArgs[2];\t\t// object literal of data for the result, Code and description\n\tvar code = oData[1];\n\tdocument.getElementById(\'ambTypeInputCode\').value=code; // Assign Code to hidden variable\n\t};\n\t//subscribe the handler to the event\n\tthis.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);\n\n/*\tvar refocus = function(sType, aArgs) {\n\t\tYAHOO.log(sType); // this is a string representing the event;\n\t\tvar oACInstance = aArgs[0]; // Current AutoComplete instance\n\t\tdocument.getElementById(\'ambTypeInput\').focus(); // Assign Code to hidden variable\n\t};\n\tthis.oAutoComp.selectionEnforceEvent.subscribe(refocus);*/\n };\n\n\nYAHOO.namespace(\"yuiData.DynamicList.Resource\"); \nYAHOO.yuiData.DynamicList.Resource.ACJson = new function(){\n    this.oACDS = new YAHOO.widget.DS_XHR(\"AMBGetJSON.jsp\", [\"am_resource\",\"resource_desc\",\"resource_id\"]);\n\tthis.oACDS.responseType = YAHOO.widget.DS_XHR.TYPE_JSON; \n    this.oACDS.queryMatchContains = true;\n\tthis.oACDS.scriptQueryParam = \"resource_desc\";\n    this.oACDS.scriptQueryAppend = \"table=am_resource\";\n \n    // Instantiate AutoComplete\n\tvar rsrcInput = document.getElementById(\'rsrcInput\');\n\tvar rsrcContainer = document.getElementById(\'rsrcContainer\');\n    this.oAutoComp = new YAHOO.widget.AutoComplete(rsrcInput,rsrcContainer, this.oACDS);\n    this.oAutoComp.useShadow = true;\n\tthis.oAutoComp.minQueryLength = 1;\n\t//this.oAutoComp.queryDelay  = 1;\n\tthis.oAutoComp.maxResultsDisplayed = 5;\n\tthis.oAutoComp.connTimeout = 3000;\n\tthis.oAutoComp.typeAhead = true;\n\tthis.oAutoComp.maxCacheEntries = 0;\n\tthis.oAutoComp.forceSelection = true; \n\n    this.oAutoComp.formatResult = function(oResultItem, sQuery){\n\t\t var sValue = oResultItem[0];  \n\t\t var sKey = oResultItem[1];  // Has the Code \n\t\t var aMarkup = [\"<div><span class=\'text-box\'>\",sValue,\"</span></div>\"];\n\t\t return (aMarkup.join(\"\"));\n\t};\n\n\n\tthis.oAutoComp.doBeforeExpandContainer = function(oTextbox, oContainer, sQuery, aResults) {\n        var pos = YAHOO.util.Dom.getXY(oTextbox);\n        pos[1] += YAHOO.util.Dom.get(oTextbox).offsetHeight + 2;\n        YAHOO.util.Dom.setXY(oContainer,pos);\n        return true;\n    };\n \t\n\n\n   //Define the itemSelect handler function: To assign the Resource code to hidden variable\n\tvar itemSelectHandler = function(sType, aArgs) {\n\tYAHOO.log(sType); // this is a string representing the event;\n\t\n\tvar oACInstance = aArgs[0]; // Current AutoComplete instance\n\tvar elListItem = aArgs[1];  // the <li> element selected in the suggestion container\n\tvar oData = aArgs[2];\t\t// object literal of data for the result, Code and description\n\tvar data = oData[1].split(\'~\');// The position is appended to the Resource code\n\tvar code=data[0];\n\tvar position = data[1];\n\tvar positionVal = data[2];\n\tif (position==\'\') \n\t{\n\t\tposition=\'&nbsp\';\n\t}\n\n\tdocument.getElementById(\'rsrcInputCode\').value=code; // Assign Code to hidden variable\n\t/**\n\t   If already the resource is listed, skip from adding in to list.\n\t  */\n\t\tif (rsrcIdSelected.indexOf(\'`\'+code+\'~\') == -1 )\n\t\t{\n\t\t\tvar rowvar = document.getElementById(\"rsrcDiv\").insertRow();\n\t\t\t//rowvar.id = \"trRowId\"+rowNumber+noOfRows.value\n\t\t\tvar cellvar = rowvar.insertCell();\n\t\t\tcellvar.className=\t\"label\"\n\t\t\tcellvar.width=\'5%\';\n\t\t\tcellvar.insertAdjacentHTML(\"BeforeEnd\",\"<input type=\'checkbox\' id=\'rsrcChk\"+rowNumber+\"\' checked value=\'\"+code+\"~\"+positionVal+\"\' onclick=\'changeVal(this);\'>\");\n\t\t\tcellvar = rowvar.insertCell();\n\t\t\tcellvar.className=\t\"label\";\n\t\t\tcellvar.width=\'30%\';\n\t\t\tcellvar.noWrap=true;\n\t\t\tcellvar.insertAdjacentHTML(\"BeforeEnd\",elListItem.innerText);\n\t\t\tcellvar = rowvar.insertCell();\n\t\t\tcellvar.className=\t\"label\"\n\t\t\tcellvar.insertAdjacentHTML(\"BeforeEnd\",position);\n\t\t\trowNumber++;\n\t\t\trsrcIdSelected = rsrcIdSelected+code+\'~\'+positionVal+\'`\';\n\t\t\tdocument.getElementById(\"rsrcAllocated\").value = rsrcIdSelected;\n\t\t};\n\t\trsrcInput.value=\'\';\n\t\tif (rsrcIdSelected!=\'\')\n\t\tdocument.getElementById(\'ambInput\').className=\'text-box-mand\';\n\n\t};\n\t//subscribe the handler to the event\n\tthis.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);\n\n\t/*var refocus = function(sType, aArgs) {\n\t\tYAHOO.log(sType); // this is a string representing the event;\n\t\tvar oACInstance = aArgs[0]; // Current AutoComplete instance\n\t\tdocument.getElementById(\'rsrcInput\').focus(); // Assign Code to hidden variable\n\t};\n\tthis.oAutoComp.selectionEnforceEvent.subscribe(refocus);\n\t*/\n};\n \n\nfunction switchAgeUOM(){\n\tvar curVal = document.getElementById(\'YMD\').innerText;\n\tvar newVal = \'\';\n\tswitch (curVal)\n\t{\n\t\tcase \'Y\' : newVal =\'M\'; break;\n\t\tcase \'M\' : newVal =\'D\'; break;\n\t\tcase \'D\' : newVal =\'Y\'; break;\n\t}\n\tdocument.getElementById(\'YMD\').innerHTML = \'<b>\'+newVal+\'</b>\';\n\tdocument.getElementById(\'ageUom\').value = newVal;\n}\n\nfunction changeVal(obj)\n{\n\tif (obj.checked==true)\n\t{\n\t\tdocument.getElementById(\"rsrcAllocated\").value= document.getElementById(\"rsrcAllocated\").value+obj.value+\"`\";\n\t}\n\telse\n\t{\n\t\tval = document.getElementById(\"rsrcAllocated\").value;\n\t\tdocument.getElementById(\"rsrcAllocated\").value= val.replace(obj.value+\"`\",\"\")\n  \t}\n\n}\n\nfunction PrintLocnMap() {\nvar mapLocnRegn = document.getElementById(\'mapLocnRegn\').value;\n//mapLocnRegn=\'India,Karnataka,Bangalore\';\nvar mapWindow = window.open(\"http://maps.google.com/maps?f=d&hl=en&saddr=\"+mapLocnRegn+\",+,+++&daddr=,++++&ie=UTF8&om=1&z=16&z=16&pw=2\",\"mapWindow\",\"toolbar=1,resizable=1,scrollbars=1,width=\"+(window.screen.availWidth-50)+\",height=\"+(window.screen.availHeight-50)+\"\\\"\");\n}\n\n</SCRIPT>\n\n\n";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t</div>\n\t\t\n\t\t</div>\n\t\t<div id=\"dt-dlg\">   \n\t\t\t <span class=\"corner_tr\"></span>  \n\t\t\t <span class=\"corner_tl\"></span>  \n\t\t\t <span class=\"corner_br\"></span>  \n\t\t\t <span class=\"corner_bl\"></span>  \n\t\t\t <div class=\"hd\">   \n\t\t\t\t ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =":   \n\t\t\t </div>  \n\t\t\t <div id=\"dt-dlg-picker\" class=\"bd\">   \n\t\t\t </div>  \n\t\t </div>  \n\t\t<!----------------------------Variable which stores the current table column order--------------------------------------->\n\t\t\t<input type=\"hidden\" name=\"selOrder\" id=\"selOrder\" value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" />\n\t\t<!------------------------------------------------------------------------------------------------------------------------>\n\t\n\t\t<!----------------------------Variables for prev next function of left div ----------------------------------------------->\n\t\t\t<input type=\"hidden\" name=\"queStart\" id=\"queStart\" value=\"\" />\n\t\t\t<input type=\"hidden\" name=\"queEnd\" id=\"queEnd\" value=\"\" />\n\t\t<!------------------------------------------------------------------------------------------------------------------------>\n\t\t\n\t\t<!----------------------------Variables for prev next function of right div----------------------------------------------->\n\t\t\t<input type=\"hidden\" name=\"chartStart\" id=\"chartStart\" value=\"\" />\n\t\t\t<input type=\"hidden\" name=\"chartEnd\" id=\"chartEnd\" value=\"\" />\n\t\t<!------------------------------------------------------------------------------------------------------------------------>\n\n\t\t<!----------------------------Variable which decides which action to be done in servlet----------------------------------->\n\t\t\t<input type=\"hidden\" name=\"doAction\" id=\"doAction\" value=\"\" />\n\t\t<!------------------------------------------------------------------------------------------------------------------------>\n\t\t\n\t\t<!----------------------------Variable which stores the status of window-------------------------------------------------->\n\t\t\t<input type=\"hidden\" name=\"wStatus\" id=\"wStatus\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" />\n\t\t<!------------------------------------------------------------------------------------------------------------------------>\n        <input type=\"hidden\" name=\"pageString\" id=\"pageString\" value=\"\" />\n\t\t\n</form>\n</div> \n\n<div id=\"AlertDiv\"></div>\n<div id=\"dialog1\">\n<div class=\"hd\">";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =" </div>\n<div class=\"bd\">\n<form name=\"frmSetting\" id=\"frmSetting\" method=\"POST\" action=\"..\\..\\servlet\\eAE.AmbulanceManagementServlet\">\n<table>\n\t<tr>\n\t\t<td>\n\t\t<label for=\"txtName\">";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 =":</label>\n\t\t</td>\n\t\t<td>\n\t\t<input type=\"textbox\" id=\"txtId\" name=\"txtId\" id=\"txtId\" maxlength=\"5\" class=\"text-box\" onblur=\"ChangeUpperCase(txtId)\" onfocus=\'assignCurEle(this)\'/><br>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td>\n\t\t<label for=\"txtDesc\">";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 =":</label>\n\t\t</td>\n\t\t<td>\n\t\t<input type=\"textbox\" id=\"txtDesc\" name=\"txtDesc\" id=\"txtDesc\" maxlength=\'30\' class=\"text-box\" onfocus=\'assignCurEle(this)\'/>\n\t\t<input type=\"hidden\" name=\"doAction\" id=\"doAction\" value=\"saveSetting\" />\n\t\t<input type=\"hidden\" name=\"tblStng\" id=\"tblStng\" value=\"\" />\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td>\n\t\t<label for=\"check\">";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 =":</label>\n\t\t</td>\n\t\t<td>\n\t\t<input type=\"checkbox\" name=\"chkDefault\" id=\"chkDefault\" value=\"1\" onclick=\"setValueForCheckbox(chkDefault,hidDefault)\"/>\n\t\t<input type=\"hidden\" name=\"hidDefault\" id=\"hidDefault\" value=\"N\" />\n\t\t</td>\n\t</tr>\n</table>\n</form>\n</div>\n</div>\n</body>\n\n<script>\n\nYAHOO.namespace(\"example.container\");\n\nvar oPushButton1 = new YAHOO.widget.Button(\"btnRecB\");\noPushButton1.on(\"click\", onButtonClick); \nvar oPushButton2 = new YAHOO.widget.Button(\"btnRecM\");\noPushButton2.on(\"click\", onButtonClick); \nvar oPushButton3 = new YAHOO.widget.Button(\"btnRecA\");  \noPushButton3.on(\"click\", onButtonClick); \nvar oPushButton4 = new YAHOO.widget.Button(\"btnClB\"); \noPushButton4.on(\"click\", onButtonClick); \nvar oPushButton5 = new YAHOO.widget.Button(\"btnClM\"); \noPushButton5.on(\"click\", onButtonClick); \nvar oPushButton6 = new YAHOO.widget.Button(\"btnClA\");  \noPushButton6.on(\"click\", onButtonClick);\n\nfunction onButtonClick(p_oEvent) {   \n\tvar selID=this.get(\"id\");\n\tif(selID==\'btnClB\'){\n\t\tcloseEntryDiv(\'ambSatausB\')\n\t}else if(selID==\'btnClM\'){\n\t\tcloseEntryDiv(\'ambSatausM\')\n\t}else if(selID==\'btnClA\'){\n\t\tcloseEntryDiv(\'ambSatausA\')\n\t}else if(selID==\'btnRecB\'){\n\t\tRecordChartInfo(\'B\');\n\t}else if(selID==\'btnRecM\'){\n\t\tRecordChartInfo(\'M\');\n\t}else if(selID==\'btnRecA\'){\n\t\tRecordChartInfo(\'A\');\n\t}else if(selID==\'btnChartGo\'){\n\t\talert(\"Go  \"+selID)\n\t}\n}\n\nYAHOO.util.Event.addListener(window, \"load\", function() {  \n\n\t//-----------------------------------------Column orders list button-----------------------------------------------------------\n\n\t function onMenuItemClick(p_sType, p_aArgs, p_oItem) {\n\n            oMenuButton4.set(\"label\", p_oItem.cfg.getProperty(\"text\"));\n\t\t\tdocument.frmAmbMangmntSystem.selOrder.value=p_oItem.value;\n\t\t\treQueryPage();\n        }\n\n\t\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n      if(aMenuButton4Menu!=\"\"){\n        var oMenuButton4 = new YAHOO.widget.Button({ type: \"menu\", label: ";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 =", name: \"mymenubutton\", menu: aMenuButton4Menu, container: \"menubuttonsfromjavascript\" });    \n      }else{\n    \t  var oMenuButton4 =new YAHOO.widget.Button({ type: \"button\", label: ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 =", name: \"mymenubutton\",  container: \"menubuttonsfromjavascript\" }); \n      }\n//-----------------------------------------Save Seting-----------------------------------------------------------\n\t\n\tvar handleSubmit = function() {\n\t\tthis.submit();\n\t};\n\tvar handleCancel = function() {\n\t\tthis.cancel();\n\t};\n\tvar handleSuccess = function(o) {\n\t\tYAHOO.yui.container.alert(o.responseText,\'id\',\'Result\');\n\t\tgoRefreshPage();\n\t\n\t};\n\tvar handleFailure = function(o) {\n\t\talert(\"Submission failed: \");\n\t};\n\n\t// Instantiate the Dialog\n\tYAHOO.example.container.dialog1 = new YAHOO.widget.Dialog(\"dialog1\", \n\t\t\t\t\t\t\t{ width : \"25em\",\n\t\t\t\t\t\t\t  fixedcenter : true,\n\t\t\t\t\t\t\t  visible : false, \n\t\t\t\t\t\t\t  zIndex:500,\n\t\t\t\t\t\t\t  constraintoviewport : true,\n\t\t\t\t\t\t\t  buttons : [ { text:\"Submit\", handler:handleSubmit, isDefault:true },\n\t\t\t\t\t\t\t\t      { text:\"Cancel\", handler:handleCancel } ]\n\t\t\t\t\t\t\t});\n\n\t// Validate the entries in the form \n\tYAHOO.example.container.dialog1.validate = function() {\n\t\tvar data = this.getData();\n\t\tif(data.txtId.indexOf(\" \")!=-1){\n\t\t     alert(getMessage(\"SPACE_NOT_ALLOWED\",\"AE\"));\n\t\t\treturn false;\n\t\t}else if (data.txtId == \"\" || data.txtDesc == \"\") {\n\t\t    alert(getMessage(\"ETR_NAME_N_DES\",\"AE\"));\n\t\t\treturn false;\n\t\t} else {\n\t\t\treturn true;\n\t\t}\n\t};\n\n\tYAHOO.example.container.dialog1.render();\n\n\t// Wire up the success and failure handlers\n\tYAHOO.example.container.dialog1.callback = { success: handleSuccess,\n\t\t\t\t\t\t     failure: handleFailure };\n\n//-------------------------------Requested Queue All---------------------------------------------------------------\n//YAHOO.example.Basic = new function() {   \n  \n\t YAHOO.example.CustomFormatting1 = new function() {   \n\t\t\n\t\t this.myCustomFormatter = function(elCell, oRecord, oColumn, oData) { \n\t\t if(oColumn.getKey()==\"Status1\" && oColumn.hidden==false ){\n\t\t\telCell.parentNode.className=\"\";\n\t\t\tif(oData== \'R\' || oData== \"Requested\") {   \n\t\t\t //YAHOO.util.Dom.replaceClass(elCell.parentNode, elCell.parentNode.className, \"Requested\");   \n\t\t\t elCell.parentNode.className=\"Requested\";\n\t\t\t elCell.innerHTML = \"Requested&nbsp;\" ;\n\t\t\t                \n           }else if(oData== \'A\'  || oData== \"Assigned\") {   \n\t\t\t\t//YAHOO.util.Dom.replaceClass(elCell.parentNode,elCell.parentNode.className,\"Assigned\");  \n\t\t\t\t elCell.parentNode.className=\"Assigned\";\n                 elCell.innerHTML = \"&nbsp;&nbsp;Assigned&nbsp;\" ;\n\t\t\t}else if(oData== \'X\'  || oData== \"Cancelled\") {   \n              \t elCell.parentNode.className=\"Cancelled\";\n                 elCell.innerHTML = \"Cancelled\" ;\n            } else if(oData== \'C\'  || oData== \"Completed\") {   \n             \t  elCell.parentNode.className=\"Completed\";\n                 elCell.innerHTML = \"Completed\" ;\n            }   \n\t\t\t}\n\t\t\telCell.innerHTML= elCell.innerHTML+\"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\";\n\t\t };   \n\n\t\tYAHOO.widget.DataTable.Formatter.myCustom = this.myCustomFormatter;   \n         this.myDataSource = new YAHOO.util.DataSource(YAHOO.example.Data.ambReqstDataAll);   \n         this.myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSON;   \n\t\tthis.myDataSource.responseSchema = {resultsList : \"Response.Results\", fields: [{key:\"Name\",parser:\"string\"},{key:\"RequestedDate\",parser:\"YAHOO.widget.DataTable.formatDate\"},{key:\"Status1\",parser:\"myCustom\"},{key:\"Pickup\",parser:\"string\"},{key:\"Drop\",parser:\"string\"},{key:\"PickupAddress\",parser:\"string\"},{key:\"DropAddress\",parser:\"string\"},{key:\"AmbNo\",parser:\"string\"},{key:\"ambCaseStartDate\",parser:\"YAHOO.widget.DataTable.formatDate\"},{key:\"ambCaseEndDate\",parser:\"YAHOO.widget.DataTable.formatDate\"},{key:\"ambCallerName\",parser:\"string\"},{key:\"ambCallerContNo\",parser:\"string\"},{key:\"ambCallerRmrks\",parser:\"string\"},{key:\"natureCallDesc\",parser:\"string\"},{key:\"ambPriorityInd\",parser:\"string\"},{key:\"ambStartMileage\",parser:\"number\"},{key:\"ambEndMileage\",parser:\"number\"},{key:\"ambDispRemarks\",parser:\"string\"},{key:\"currentLocation\",parser:\"string\"},{key:\"ambVehicleName\",parser:\"string\"},{key:\"ambRegnNo\",parser:\"string\"},{key:\"ambLastMileage\",parser:\"number\"}]};        \n    \n\twindow.myDataTable = new YAHOO.widget.DataTable(\"ambRequstAll\",   \n        myColumnDefs, this.myDataSource, {scrollable:true, height:\"16em\",width:\"93em\",sortable:true,draggableColumns:true, paginator: new YAHOO.widget.Paginator({\n\t\t\t\tcontainers:\'dt-paginatorAll\',\n                rowsPerPage: 6,\t\t\t\t                \n                pageLinks: 5,\n\t\t\t\talwaysVisible :false,\n\t\t\t\tfirstPageLinkLabel:\'<img src=../../eAE/images/FirstPage.gif>\',\n\t\t\t\tpreviousPageLinkLabel:\'<img src=../../eAE/images/ADSprevious.gif>\',\n\t\t\t\tnextPageLinkLabel:\'<img src=../../eAE/images/ADSnext.gif>\',\n\t\t\t\tlastPageLinkLabel:\'<img src=../../eAE/images/LastPage.gif>\'\n            })});\n    /**************** Show, Hide Columns**********start**********/\t\n\t         // Shows dialog, creating one when necessary   \n         var newCols = true; \t\t \n\t\t var customizeColumns=new YAHOO.util.CustomEvent(\"customizeColumns\"); \n\t\t var showDlg = function(e) {   \n\t\t     YAHOO.util.Event.stopEvent(e);   \n                if(newCols) {   \n                 // Populate Dialog   \n                 // Using a template to create elements for the SimpleDialog   \n                 var allColumns = window.myDataTable.getColumnSet().keys;   \n                 var elPicker = YAHOO.util.Dom.get(\"dt-dlg-picker\");   \n                 var elTemplateCol = document.createElement(\"div\");   \n                 YAHOO.util.Dom.addClass(elTemplateCol, \"dt-dlg-pickercol\");   \n                 var elTemplateKey = elTemplateCol.appendChild(document.createElement(\"span\"));   \n                 YAHOO.util.Dom.addClass(elTemplateKey, \"dt-dlg-pickerkey\");   \n                 var elTemplateBtns = elTemplateCol.appendChild(document.createElement(\"span\"));   \n                 YAHOO.util.Dom.addClass(elTemplateBtns, \"dt-dlg-pickerbtns\");   \n                 var onclickObj = {fn:handleButtonClick, obj:this, scope:false };\n                \t\t\t \n                 // Create one section in the SimpleDialog for each Column   \n                 var elColumn, elKey, elButton, oButtonGrp,oGrpByButton;  \n\t\t\t\t\t\n\t\t\t\t\tfor(var i=0,l=allColumns.length;i<l;i++) {   \n\t\t\t\t\t\t var oColumn = allColumns[i];   \n\t\t\t\t\t\t // Use the template   \n\t\t\t\t\t\t elColumn = elTemplateCol.cloneNode(true);   \n\t\t\t\t\t\t\t\n\t\t\t\t\t\t // Write the Column key   \n\t\t\t\t\t\t elKey = elColumn.firstElementChild;  \n\t\t\t\t\t \n\t\t\t\t\t\t   //  elKey.innerHTML = oColumn.getKey();\t\t\t\t\t \n\t\t\t\t\t\t elKey.innerHTML = oColumn.label;\t\t\t\t\t \n\t\t\t\t\t\t\t\n\t\t\t\t\t\t // Create a ButtonGroup   \n\t\t\t\t\t\t oButtonGrp = new YAHOO.widget.ButtonGroup({    \n\t\t\t\t\t\t\t\t\t\t id: \"buttongrp\"+i,    \n\t\t\t\t\t\t\t\t\t\t name: oColumn.getKey(), \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t container: elKey.nextSibling\n\t\t\t\t\t\t });   \n\t\t\t\t\t\n\t\t\t\t\t\t oButtonGrp.addButtons([    \n\t\t\t\t\t\t\t { label: \"Show\", value: \"Show\", checked: ((!oColumn.hidden)), onclick: onclickObj},   \n\t\t\t\t\t\t\t { label: \"Hide\", value: \"Hide\", checked: ((oColumn.hidden)), onclick: onclickObj}\n\t\t\t\t\t\t ]);   \n\t\t\t\t\t\t\n\t\t\t\t\t\t elPicker.appendChild(elColumn); \t\t\t\n\t\t\t\t\t } \t\t \n                 newCols = false;   \n             } \n\t\t \n             myDlg.show();   \n         };   \n         var hideDlg = function(e) {   \n\t\t         this.hide();   \n         };  \n \n\t\t var PrevsKey=\"\";\t\n\t     var handleButtonClick = function(e, oSelf) {\n\t\t \tvar sKey = this.get(\"name\"); \t\t\t\t\n\t\t\tif(this.get(\"value\") == \"Hide\") {\n\t\t\t\twindow.myDataTable.hideColumn(sKey);\t\t\t\t\n\t\t\t}   \n\t\t\telse if(this.get(\"value\")==\"Show\"){ \t\t\t\n\t\t\t\twindow.myDataTable.showColumn(sKey);  \t\t\t\t\n\t\t\t} \t\n\t\t};  \n\t\n\twindow.myDataTable.subscribe(\"columnShowEvent\",function(oArgs){\n\t\t\tif(((oArgs.column).getKey()==\"Status1\") || (window.myDataTable.getColumn(\"Status1\").hidden==false)){\n\t\t\t\tvar allRows = window.myDataTable.getRecordSet(); \n\t\t\t\tfor(var j=0;j<allRows.getLength();j++){\n\t\t\t\t\toData=window.myDataTable.getRecord(j).getData(\"Status1\");\n\t\t\t\n\t\t\t\t\teTR=window.myDataTable.getTrEl(window.myDataTable.getRecord(j));\n\t\t\t\t\n\t\t\t\t\tif(oData !=null  && oData !=\"\" && oData !=\'undefined\'){\t\t\t\n\t\t\t\t\t\tif(oData== \'R\' || oData==\"Requested\") {\t\t\t\n\t\t\t\t\t\t\teTR.cells[(window.myDataTable.getColumn(\"Status1\")).getKeyIndex()].className=\"Requested\";\t\t\t\t\t\t\n\t\t\t\t\t\t\twindow.myDataTable.updateCell (window.myDataTable.getRecord(j), \"Status1\",\"Requested\");\t\n\t\t\t\t\t\t\n\t\t\t\t\t   }else if(oData== \'A\' || oData==\"Assigned\") {  \t\t\t\t\n\t\t\t\t\t\t\teTR.cells[(window.myDataTable.getColumn(\"Status1\")).getKeyIndex()].className=\"Assigned\";   \t\t\t\t\n\t\t\t\t\t\t\twindow.myDataTable.updateCell (window.myDataTable.getRecord(j),  \"Status1\",\"Assigned\");\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t}else if(oData== \'X\'  || oData==\"Cancelled\") {   \n\t\t\t\t\t\t\t eTR.cells[(window.myDataTable.getColumn(\"Status1\")).getKeyIndex()].className=\"Cancelled\";          \n\t\t\t\t\t\t\t window.myDataTable.updateCell (window.myDataTable.getRecord(j),  \"Status1\",\"Cancelled\");\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}else if(oData== \'C\'  || oData==\"Completed\") {   \n\t\t\t\t\t\t\teTR.cells[(window.myDataTable.getColumn(\"Status1\")).getKeyIndex()].className=\"Completed\";        \n\t\t\t\t\t\t\twindow.myDataTable.updateCell (window.myDataTable.getRecord(j), \"Status1\",\"Completed\");\n\t\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t\t\n\t\t\t}\t\n\t\t}\n\n\t},this,true)   ;\n\twindow.myDataTable.subscribe(\"columnHideEvent\",function(oArgs){\n\t\tif((oArgs.column).getKey()==\"Status1\" ){\n\t\t\t(oArgs.column).formatter=\"\";\n\t\t}else{\n\t\tif((window.myDataTable.getColumn(\"Status1\")).hidden==false){\n\t\t\tvar allRows = window.myDataTable.getRecordSet(); \n\t\t\tfor(var j=0;j<allRows.getLength();j++){\n\t\t\t\toData=window.myDataTable.getRecord(j).getData(\"Status1\");\n\t\t\t\teTR=window.myDataTable.getTrEl(window.myDataTable.getRecord(j));\n\t\t\t\n\t\t\t\tif(oData !=null  && oData !=\"\" && oData !=\'undefined\'){\t\t\t\n\t\t\t\tif(oData== \'R\' || oData==\"Requested\") {\t\t\t\n\t\t\t\t\teTR.cells[(window.myDataTable.getColumn(\"Status1\")).getKeyIndex()].className=\"Requested\";\t\n\t\t\t\t\n\t\t\t\t\twindow.myDataTable.updateCell (window.myDataTable.getRecord(j), \"Status1\",\"Requested\");\t\n\t\t\t\t\n\t\t\t   }else if(oData== \'A\' || oData==\"Assigned\") {  \t\t\t\t\n\t\t\t\t\teTR.cells[(window.myDataTable.getColumn(\"Status1\")).getKeyIndex()].className=\"Assigned\";   \t\t\t\t\n\t\t\t\t\twindow.myDataTable.updateCell (window.myDataTable.getRecord(j),  \"Status1\",\"Assigned\");\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t}else if(oData== \'X\'  || oData==\"Cancelled\") {   \n\t\t\t\t\t eTR.cells[(window.myDataTable.getColumn(\"Status1\")).getKeyIndex()].className=\"Cancelled\";          \n\t\t\t\t\t window.myDataTable.updateCell (window.myDataTable.getRecord(j),  \"Status1\",\"Cancelled\");\n\t\t\t\t\t\n\t\t\t\t}else if(oData== \'C\'  || oData==\"Completed\") {   \n\t\t\t\t\teTR.cells[(window.myDataTable.getColumn(\"Status1\")).getKeyIndex()].className=\"Completed\";        \n\t\t\t\t\twindow.myDataTable.updateCell (window.myDataTable.getRecord(j), \"Status1\",\"Completed\");\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t\n\t\t\t}\t\n\t\t\t}\n\t\t} \n\t},this,true)   ;\n\twindow.myDataTable.subscribe(\"columnSortEvent\",function(oArgs){\n\t\tif((window.myDataTable.getColumn(\"Status1\")).hidden==false){\n\t\t\tvar allRows = window.myDataTable.getRecordSet(); \n\t\t\tfor(var j=0;j<allRows.getLength();j++){\n\t\t\t\toData=window.myDataTable.getRecord(j).getData(\"Status1\");\n\t\t\t\teTR=window.myDataTable.getTrEl(window.myDataTable.getRecord(j));\n\t\t\t\n\t\t\t\tif(oData !=null  && oData !=\"\" && oData !=\'undefined\'){\t\t\t\n\t\t\t\tif(oData== \'R\' || oData==\"Requested\") {\t\t\t\n\t\t\t\t\teTR.cells[(window.myDataTable.getColumn(\"Status1\")).getKeyIndex()].className=\"Requested\";\t\t\t\t\t\n\t\t\t\t\twindow.myDataTable.updateCell (window.myDataTable.getRecord(j), \"Status1\",\"Requested\");\t\n\t\t\t\t\n\t\t\t   }else if(oData== \'A\' || oData==\"Assigned\") {  \t\t\t\t\n\t\t\t\t\teTR.cells[(window.myDataTable.getColumn(\"Status1\")).getKeyIndex()].className=\"Assigned\";   \t\t\t\t\n\t\t\t\t\twindow.myDataTable.updateCell (window.myDataTable.getRecord(j),  \"Status1\",\"Assigned\");\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t}else if(oData== \'X\'  || oData==\"Cancelled\") {   \n\t\t\t\t\t eTR.cells[(window.myDataTable.getColumn(\"Status1\")).getKeyIndex()].className=\"Cancelled\";          \n\t\t\t\t\t window.myDataTable.updateCell (window.myDataTable.getRecord(j),  \"Status1\",\"Cancelled\");\n\t\t\t\t\t\n\t\t\t\t}else if(oData== \'C\'  || oData==\"Completed\") {   \n\t\t\t\t\teTR.cells[(window.myDataTable.getColumn(\"Status1\")).getKeyIndex()].className=\"Completed\";        \n\t\t\t\t\twindow.myDataTable.updateCell (window.myDataTable.getRecord(j), \"Status1\",\"Completed\");\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t\n\t\t\t}\t\n\t\t\t}\t\n\t},this,true)   ;\t\n\t\n /**************** Show, Hide GroupColumns*******end*****/\t\n         // Create the SimpleDialog   \n         YAHOO.util.Dom.removeClass(\"dt-dlg\", \"inprogress\");   \n         var myDlg = new YAHOO.widget.SimpleDialog(\"dt-dlg\", {   \n                 width: \"30em\", \n\t\t\t\t  height:\"35em\",\t\t\t\t \n                 visible: false,   \n                 modal: true,   \n                 buttons: [                         \n                     { text:\"Close\",  handler:hideDlg }   \n                 ],   \n                 fixedcenter: true,   \n                 constrainToViewport: true  \n         });   \n        myDlg.render();   \n   \n         // Nulls out myDlg to force a new one to be created   \n         window.myDataTable.subscribe(\"columnReorderEvent\", function(){   \n             newCols = true;   \n            YAHOO.util.Event.purgeElement(\"dt-dlg-picker\", true);   \n             YAHOO.util.Dom.get(\"dt-dlg-picker\").innerHTML = \"\";   \n         }, this, true);   \n            \n         // Hook up the SimpleDialog to the link   \n\t\tcustomizeColumns.subscribe(showDlg);      \n\t\t \n\t\twindow.myDataTable.subscribe(\"rowMouseoverEvent\", window.myDataTable.onEventHighlightRow);\n        window.myDataTable.subscribe(\"rowMouseoutEvent\", window.myDataTable.onEventUnhighlightRow);\n        window.myDataTable.subscribe(\"rowClickEvent\", window.myDataTable.onEventSelectRow);\n\t\t\n\t\t/*this.myDataTable.subscribe(\"rowClickEvent\", function(oArgs){\n        var oRecord = this.getRecord(oArgs.target);\n        var pt_name =  YAHOO.lang.dump(oRecord.getData(\"Name\"));\n\t\tdocument.getElementById(\"pat_name\").value=pt_name;\n\t\tcallOnClick();\n\t\t});*/\n\n\t\twindow.myDataTable.subscribe(\"rowDblclickEvent\", function(oArgs){\n        var oRecord = this.getRecord(oArgs.target);\n        var tripSheetNo =  YAHOO.lang.dump(oRecord.getData(\"AmbNo\"));\n\t\t//document.getElementById(\"pat_name\").value=pt_name;\n\t\tcallOnClickRequested(tripSheetNo);\t\t\n\t\t});\n\n\n\t\tthis.onContextMenuClick = function(p_sType, p_aArgs, p_myDataTable) {\n\t\t\n\t\t\tswitch(p_aArgs[1].index){\n\n\t\t\t\tcase 0:\n\t\t\t\t\tvar elRow = this.contextEventTarget;   \n\t\t\t\t\telRow = p_myDataTable.getTrEl(elRow);   \n                    var oRecord = p_myDataTable.getRecord(elRow);   \n                    var trip_no=oRecord.getData(\"AmbNo\");\n\n\t\t\t\t\tleftVal = (screen.width-900) / 2;\n\t\t\t\t\ttopVal = (screen.height-630) / 2;\n\t\t\t\t\n\t\t\t\t    window.open(\"AmbPrintTripSheet.jsp?p_trip_no=\"+trip_no,\"reportWindow\",\"resizable=1,scrollbars=1,width=900,height=630,left=\"+leftVal+\",top=\"+topVal);\n\n\t\t\t\t\tbreak;\n\t\t\t\tcase 1:\n\t\t\t\t\tvar list = new Array();\n\t\t\t\t\tvar list1= new Array();\n\t\t\t\t\tlist=p_myDataTable.getColumnSet().getDefinitions();\n\t\t\t\t\tvar cs=p_myDataTable.getColumnSet();\n\t\t\t\t\tvar allColumnkeys = window.myDataTable.getColumnSet().keys;   \n\t\t\t\t\tvar chkHiddenCols;\n\t\t\t\t\tfor(var i=0;i<list.length;i++){\n\t\t\t\t\t\tcl=cs.getColumn(i);\n\t\t\t\t\t\tchkHiddenCols=allColumnkeys[i]\n\t\t\t\t\t\tif(chkHiddenCols.hidden==false){\n\t\t\t\t\t\t\tlist1[i]=cl.getKey();\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tdocument.frmSetting.tblStng.value=list1;\n\t\t\t\t\tdocument.frmSetting.txtId.value=\"\";\n\t\t\t\t\tdocument.frmSetting.txtDesc.value=\"\";\n\t\t\t\t\tdocument.frmSetting.chkDefault.checked=false;\n\t\t\t\t\tdocument.frmSetting.hidDefault.value=\"N\";\n\t\t\t\t\tYAHOO.example.container.dialog1.show();\n\t\t\t\t\t\n\t\t\t\t\tbreak;\n\t\t\t\tcase 2:\n\t\t\t\t\tcustomizeColumns.fire();\n\t\t\t\t\tbreak;\n\t\t\t}\n\t\t\t\n\t\t };\n\n\t\t\n\n        this.myContextMenu = new YAHOO.widget.ContextMenu(\"mycontextmenu\", {trigger:window.myDataTable.getTbodyEl()});\n        this.myContextMenu.addItem(\"Print\");\n\t\tthis.myContextMenu.addItem(\"Save Settings\");\n\t\tthis.myContextMenu.addItem(\"Customize Column Display\");\n\t    this.myContextMenu.render(\"ambRequstAll\");\n        this.myContextMenu.clickEvent.subscribe(this.onContextMenuClick, window.myDataTable);\n\t\t \n     };   \n\n   //-------------------------------Requested Queue Small---------------------------------------------------\n   /*YAHOO.example.CustomFormatting = new function() {   \n    \t this.myCustomFormatter1 = function(elCell, oRecord, oColumn, oData) {  \n\t\t\t \n\t\t\t// alert(oRecord.getData(\"Status2\"));\n            if(oRecord.getData(\"Status1\")== \'R\') {   \n                // YAHOO.util.Dom.replaceClass(elCell.parentNode,\"Assigned\", \"Requested\");  \n\t\t\t\telCell.parentNode.className=\"Requested\";\n\t\t\t\t elCell.innerHTML =\"Requested\" ;\n                \n            }else if(oRecord.getData(\"Status1\")== \'A\') {   \n              //  YAHOO.util.Dom.replaceClass(elCell.parentNode, \"Requested\",\"Assigned\");  \n\t\t\t  elCell.parentNode.className=\"Assigned\";\n                 elCell.innerHTML = \"Assigned\" ;\n            }  \n\t\t };   \n\n\t\t YAHOO.widget.DataTable.Formatter.myCustom1 = this.myCustomFormatter1;   \n       /*  var myColumnDefs1 = [   \n             {key:\"RequestedDate\",label:\"Requested Date\", formatter:YAHOO.widget.DataTable.formatDate, sortable:true, \n\t\t\t sortOptions:{defaultDir:YAHOO.widget.DataTable.CLASS_DESC},resizeable:true,width:120},   \n             {key:\"Name\", sortable:true, resizeable:true,width:130},       \n\t\t\t {key:\"Status2\",label:\"Status\", formatter:\"myCustom1\",sortable:true, resizeable:true,width:70},  \n\t\t\t {key:\"Pickup\", sortable:true, resizeable:true,width:95},   \n             {key:\"Drop\", sortable:true, resizeable:true,width:95} \n\t\t];   */\n\n\t\tYAHOO.example.CustomFormatting2 = new function() { \n\t\t\t\n\t\t\t this.myCustomFormatter = function(elCell, oRecord, oColumn, oData) {  \n\n            if(oRecord.getData(\"Status1\")== \'R\') {   \n                // YAHOO.util.Dom.replaceClass(elCell.parentNode,\"Assigned\", \"Requested\");  \n\t\t\t\telCell.parentNode.className=\"Requested\";\n\t\t\t\t elCell.innerHTML =\"Requested\" ;\n                \n            }else if(oRecord.getData(\"Status1\")== \'A\') {   \n              //  YAHOO.util.Dom.replaceClass(elCell.parentNode, \"Requested\",\"Assigned\");  \n\t\t\t\t elCell.parentNode.className=\"Assigned\";\n                 elCell.innerHTML = \"Assigned\" ;\n            }  \n\t\t };   \n \n         this.myDataSource = new YAHOO.util.DataSource(YAHOO.example.Data.ambReqstDataAll);   \n         this.myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSON;   \n\t\t\n      // this.myDataSource.responseSchema = {resultsList : \"Response.Results\",fields: [";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 =",\"AmbNo\"]   \n      this.myDataSource.responseSchema = {resultsList : \"Response.Results\",fields: [";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 =",{key:\"AmbNo\",parser:\"string\"}]}; \n\t//\t this.myDataSource.responseSchema = {resultsList : \"Response.Results\",fields: [{key:\"Name\",parser:\"string\"},{key:\"RequestedDate\",parser:\"YAHOO.widget.DataTable.formatDate\"},{key:\"ambCallerRmrks\",parser:\"string\"},{key:\"Pickup\",parser:\"string\"},{key:\"PickupAddress\",parser:\"string\"}]  } ;\n       \n\t//myColumnDefs1 = [{key:\"Name\", label:\"Name\",sortable:true, resizeable:false,width:93,minWidth:93,maxAutoWidth:93},{key:\"RequestedDate\",label:\"Requested Date\", formatter:YAHOO.widget.DataTable.formatDate, sortable:true, sortOptions:{defaultDir:YAHOO.widget.DataTable.CLASS_DESC},resizeable:false, width:104,minWidth:104,maxAutoWidth:104},{key:\"ambCallerRmrks\", label:\"Request Remarks\",formatter:\"string\",sortable:true, resizeable:false, width:93,minWidth:93,maxAutoWidth:93},{key:\"Pickup\", sortable:true, resizeable:false,width:93,minWidth:93,maxAutoWidth:93},{key:\"PickupAddress\", label:\"Pickup Address\",sortable:true, resizeable:false,width:93,minWidth:93,maxAutoWidth:93}];\n         this.myDataTable1 = new YAHOO.widget.DataTable(\"ambRequst\",   \n         myColumnDefs1, this.myDataSource, {scrollable:true, height:\"18em\", paginator: new YAHOO.widget.Paginator({\n\t\t\t   containers:\'dt-paginator\',     \n\t\t\t   rowsPerPage: 6,\n                pageLinks: 5,\n\t\t\t\talwaysVisible :false,\n\t\t\t\tfirstPageLinkLabel:\'<img  src=../../eAE/images/FirstPage.gif>\',\n\t\t\t\tpreviousPageLinkLabel:\'<img src=../../eAE/images/ADSprevious.gif>\',\n\t\t\t\tnextPageLinkLabel:\'<img src=../../eAE/images/ADSnext.gif>\',\n\t\t\t\tlastPageLinkLabel:\'<img src=../../eAE/images/LastPage.gif>\'\n            })}); \n\t\t \n\t\tthis.myDataTable1.subscribe(\"rowMouseoverEvent\", this.myDataTable1.onEventHighlightRow);\n        this.myDataTable1.subscribe(\"rowMouseoutEvent\", this.myDataTable1.onEventUnhighlightRow);\n        this.myDataTable1.subscribe(\"rowClickEvent\", this.myDataTable1.onEventSelectRow);\n        \n        this.myDataTable1.subscribe(\"columnSortEvent\",function(oArgs){\n    \t\tif((this.myDataTable1.getColumn(\"Status1\")).hidden==false){\n    \t\t\t\tvar allRows = this.myDataTable1.getRecordSet(); \n    \t\t\t\tfor(var j=0;j<allRows.getLength();j++){\n    \t\t\t\t\toData=this.myDataTable1.getRecord(j).getData(\"Status1\");\n    \t\t\t\t\teTR=this.myDataTable1.getTrEl(this.myDataTable1.getRecord(j));\n    \t\t\t\t\n    \t\t\t\t\tif(oData !=null  && oData !=\"\" && oData !=\'undefined\'){\t\t\t\n    \t\t\t\t\tif(oData== \'R\' || oData==\"Requested\") {\t\t\t\n    \t\t\t\t\t\teTR.cells[(this.myDataTable1.getColumn(\"Status1\")).getKeyIndex()].className=\"Requested\";\t\t\t\t\t\n    \t\t\t\t\t\tthis.myDataTable1.updateCell (this.myDataTable1.getRecord(j), \"Status1\",\"Requested\");\t\n    \t\t\t\t\t\n    \t\t\t\t   }else if(oData== \'A\' || oData==\"Assigned\") {  \t\t\t\t\n    \t\t\t\t\t\teTR.cells[(this.myDataTable1.getColumn(\"Status1\")).getKeyIndex()].className=\"Assigned\";   \t\t\t\t\n    \t\t\t\t\t\tthis.myDataTable1.updateCell (this.myDataTable1.getRecord(j),  \"Status1\",\"Assigned\");\t\t\t\t\t\n    \t\t\t\t\t\n    \t\t\t\t\t}else if(oData== \'X\'  || oData==\"Cancelled\") {   \n    \t\t\t\t\t\t eTR.cells[(this.myDataTable1.getColumn(\"Status1\")).getKeyIndex()].className=\"Cancelled\";          \n    \t\t\t\t\t\t this.myDataTable1.updateCell (this.myDataTable1.getRecord(j),  \"Status1\",\"Cancelled\");\n    \t\t\t\t\t\t\n    \t\t\t\t\t}else if(oData== \'C\'  || oData==\"Completed\") {   \n    \t\t\t\t\t\teTR.cells[(this.myDataTable1.getColumn(\"Status1\")).getKeyIndex()].className=\"Completed\";        \n    \t\t\t\t\t\tthis.myDataTable1.updateCell (this.myDataTable1.getRecord(j), \"Status1\",\"Completed\");\n    \t\t\t\t\t\t\n    \t\t\t\t\t}\n    \t\t\t\t\t}\n    \t\t\t\t\t\n    \t\t\t\t}\t\n    \t\t\t\t}\t\n    \t\t},this,true)   ;\n        \n        \n        \n        \n\t\t\n\t\tthis.myDataTable1.subscribe(\"rowDblclickEvent\", function(oArgs){\n        var oRecord = this.getRecord(oArgs.target);\n        var tripSheetNo =  YAHOO.lang.dump(oRecord.getData(\"AmbNo\"));\n\t\t//document.getElementById(\"pat_name\").value=pt_name;\n\t\tcallOnClickRequested(tripSheetNo);\n\t\t});\n\t//};   \n\n\n\t this.onContextMenuClick = function(p_sType, p_aArgs, p_myDataTable) {\n\n\t\t\t\n\t\t\t\t\tvar elRow = this.contextEventTarget;   \n\t\t\t\t\telRow = p_myDataTable.getTrEl(elRow);   \n                    var oRecord = p_myDataTable.getRecord(elRow);   \n                    var trip_no=oRecord.getData(\"AmbNo\");\n\n\t\t\t\t\tleftVal = (screen.width-900) / 2;\n\t\t\t\t\ttopVal = (screen.height-630) / 2;\n\t\t\t\t\n\t\t\t\t    window.open(\"AmbPrintTripSheet.jsp?p_trip_no=\"+trip_no,\"reportWindow\",\"resizable=1,scrollbars=1,width=900,height=630,left=\"+leftVal+\",top=\"+topVal);\n\t\t\t}\n\n\t\n\t\tthis.myContextMenu1 = new YAHOO.widget.ContextMenu(\"mycontextmenu1\",\n                {trigger:this.myDataTable1.getTbodyEl()});\n        this.myContextMenu1.addItem(\"Print\");\n\t\tthis.myContextMenu1.render(\"ambRequst\");\t\t\n\t    this.myContextMenu1.clickEvent.subscribe(this.onContextMenuClick, this.myDataTable1);\n\t\n\t};\n\n\n //-------------------------------Ambulance Chart---------------------------------------------------\n\tYAHOO.example.CustomFormatting3 = new function() {   \n    \t this.myCustomFormatter2 = function(elCell, oRecord, oColumn, oData) {   \n\t\t\t\n           var imgSRC;\n           switch(oRecord.getData(\"ambtype\")){\n\t\t\t   case \'R\':\n\t\t\t\t   imgSRC=\"<img src=\'../../eAE/images/Ambulance.gif\' height=25 width=35 />\";\n\t\t\t    break;\n\t\t\t\t\n\t\t\t\tcase \'M\':\n\t\t\t\t\timgSRC=\"<img src=\'../../eAE/images/boatambulance.gif\' height=25 width=35 />\";\n\t\t\t    break;\n\t\t\t\t\n\t\t\t\tcase \'A\':\n\t\t\t\t\timgSRC=\"<img src=\'../../eAE/images/airambulance.gif\' height=25 width=35 />\";\n\t\t\t    break;\n\t\t   }\n            \n\t\t\tif(oRecord.getData(\"Status3\")== \'M\') {   \n               \t elCell.parentNode.className=\"Maintance\";\n\t\t\t\t elCell.innerHTML = imgSRC//oData ;\n             }else if(oRecord.getData(\"Status3\")== \'B\') {   \n                 elCell.parentNode.className=\"Available\";\n                 elCell.innerHTML = imgSRC //oData ;\n            } else if(oRecord.getData(\"Status3\")== \'A\') {   \n                 elCell.parentNode.className=\"AssignedChart\";\n                 elCell.innerHTML = imgSRC //oData ;\n            }  \n\t\t };   \n\n\t\t YAHOO.widget.DataTable.Formatter.myCustom2 = this.myCustomFormatter2;   \n         var myColumnDefs2 = [ \n\t\t\t {key:\"Status3\",label:\"Status\", sortable:true, formatter:\"myCustom2\",resizeable:true,width:55},\n             {key:\"vehicleid\",label:\"Ambulance ID\", formatter:YAHOO.widget.DataTable.formatDate, sortable:true, \n\t\t\t sortOptions:{defaultDir:YAHOO.widget.DataTable.CLASS_DESC},resizeable:true,width:140},   \n             {key:\"vehiclename\",label:\"Description\", formatter:\"string\",sortable:true, resizeable:true,width:230},       \n\t\t\t {key:\"regnno\", label:\"Registration No\",formatter:\"string\",sortable:true, resizeable:true,width:160},  \n\t\t\t {key:\"modelno\", label:\"Make\",formatter:\"string\",sortable:true, resizeable:true,width:150},   \n             {key:\"ambContname\", label:\"Contact\", formatter:\"string\",sortable:true, resizeable:true,width:160} ,\n\t\t\t {key:\"lastmileage\", label:\"Last Mileage\", formatter:\"number\",sortable:true, resizeable:true,width:130}\n\t\t\t \n\t\t];   \n   \n         this.myDataSource = new YAHOO.util.DataSource(YAHOO.example.Data2.ambChartData);   \n         this.myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSON;   \n     //    this.myDataSource.responseSchema = {fields: [\"vehicleid\",\"vehiclename\",\"regnno\",\"modelno\",\"ambContname\",\"lastmileage\",\"Status3\",\"ambtype\",\"ambDiv\"]   \n         this.myDataSource.responseSchema = {resultsList : \"Response.Results\",fields: [{key:\"vehicleid\",parser:\"YAHOO.widget.DataTable.formatDate\"},{key:\"vehiclename\",parser:\"string\"},{key:\"regnno\",parser:\"string\"},{key:\"modelno\",parser:\"string\"},{key:\"ambContname\",parser:\"string\"},{key:\"lastmileage\",parser:\"number\"},{key:\"Status3\",parser:\"myCustom2\"},{key:\"ambtype\",parser:\"string\"},{key:\"ambDiv\",parser:\"string\"}]   };\n\n  \n   \n         this.myDataTable2 = new YAHOO.widget.DataTable(\"ambChartTable\",   \n         myColumnDefs2, this.myDataSource, {scrollable:true, height:\"18em\",width:\"93em\",paginator: new YAHOO.widget.Paginator({\n\t\t\t\tcontainers:\'dt-chartPaginator\',\n                rowsPerPage: 4,\n                pageLinks: 5,\n\t\t\t\talwaysVisible :false,\n\t\t\t\tfirstPageLinkLabel:\'<img  src=../../eAE/images/FirstPage.gif>\',\n\t\t\t\tpreviousPageLinkLabel:\'<img src=../../eAE/images/ADSprevious.gif>\',\n\t\t\t\tnextPageLinkLabel:\'<img src=../../eAE/images/ADSnext.gif>\',\n\t\t\t\tlastPageLinkLabel:\'<img src=../../eAE/images/LastPage.gif>\'\n            })}); \n         \n         \n         this.myDataTable2.subscribe(\"columnSortEvent\",function(oArgs){\n  \t\t\tif((this.myDataTable2.getColumn(\"Status3\")).hidden==false){\n  \t\t\t\tvar allRows = this.myDataTable2.getRecordSet(); \n  \t\t\t\tfor(var j=0;j<allRows.getLength();j++){\n  \t\t\t\t\toData=this.myDataTable2.getRecord(j).getData(\"Status3\");\n  \t\t\t\t\teTR=this.myDataTable2.getTrEl(this.myDataTable2.getRecord(j));\n  \t\t\t\t\tif(oData !=null  && oData !=\"\" && oData !=\'undefined\'){\t\t\t\n  \t\t\t\t\tif(oData== \'M\' || oData==\"Maintance\") {\t\t\t\n  \t\t\t\t\t\teTR.cells[(this.myDataTable2.getColumn(\"Status3\")).getKeyIndex()].className=\"Maintance\";\t\t\t\t\t\n  \t\t\t\t   }else if(oData== \'B\' || oData==\"Available\") {  \t\t\t\t\n  \t\t\t\t\t\teTR.cells[(this.myDataTable2.getColumn(\"Status3\")).getKeyIndex()].className=\"Available\";   \t\t\t\t\n  \t\t\t\t\t}else if(oData== \'A\'  || oData==\"AssignedChart\") {   \n  \t\t\t\t\t\t eTR.cells[(this.myDataTable2.getColumn(\"Status3\")).getKeyIndex()].className=\"AssignedChart\";          \n  \t\t\t\t\t}\n  \t\t\t\t\t}\n  \t\t\t\t}\t\n  \t\t\t\t}\t\n  \t\t},this,true)   ;\n \t\n         \n         \n         \n         \n\t\t\t\n\t\t\t\n\t\t \n\t\tthis.myDataTable2.subscribe(\"rowMouseoverEvent\", this.myDataTable2.onEventHighlightRow);\n        this.myDataTable2.subscribe(\"rowMouseoutEvent\", this.myDataTable2.onEventUnhighlightRow);\n        this.myDataTable2.subscribe(\"rowClickEvent\", this.myDataTable2.onEventSelectRow);\n\t\t\n\t\tthis.myDataTable2.subscribe(\"rowDblclickEvent\", function(oArgs){\n        var oRecord = this.getRecord(oArgs.target);\n      \tif(oRecord.getData(\'Status3\')!=\'M\' && document.getElementById(\'ambStartedYn\').checked != true){\n\t\tpopulateReqstdAmb(oRecord.getData(\"ambDiv\"));\n\t\t}\n\t\t//callOnClick();\n\t\t});\n\n\t\t//To Suppress right click in Ambulance Chart 5/25/2009\n\t\t/*this.myContextMenu2 = new YAHOO.widget.ContextMenu(\"mycontextmenu1\",\n                {trigger:this.myDataTable2.getTbodyEl()});\n        this.myContextMenu1.clickEvent.subscribe(this.onContextMenuClick, this.myDataTable2);\n\t\t*/\n\t};\n\t\n\n\t/* // Using Simple Dialog\n\tvar alertPanel = new YAHOO.widget.SimpleDialog(\'Alert\', {\n                fixedcenter: true,\n                visible: false,\n                modal: true,\n                width: \'300px\',\n                constraintoviewport: true, \n\t\t\t\tclose:true,  \n                icon: YAHOO.widget.SimpleDialog.ICON_WARN,\n\t\t\t\tBody:\"Test\",\n                buttons: [\n                    { text: \'OK\', handler: function() {\n                        alertPanel.hide();\n                    }, isDefault: true }\n                ]\n            });\n\t\t\talertPanel.setHeader(\'Alert\');\n            alertPanel.render(\"AlertDiv\");\n\t\n\tYAHOO.namespace(\"yuiData.app\"); \n\tYAHOO.yuiData.app.alert = function (msg){\n\t\t//Give the body something to render with\n\t\talertPanel.setBody(\'<div class=alert>\'+msg+\'</div>\');\n\t\t//Render the Dialog to the body\n\t\talertPanel.cfg.setProperty(\'icon\', YAHOO.widget.SimpleDialog.ICON_WARN); \n\t\t//Bring the dialog to the top \n\t\talertPanel.bringToTop(); \n\t\t//Show the panel \n\t\talertPanel.show();\n\t}\n*/\n\tYAHOO.namespace(\"yui.container\"); \n\t\tYAHOO.yui.container.overlay = new YAHOO.widget.Panel(\"Alert\", \n\t\t{\n\t\t\tvisible:false,iframe:true,modal:true,close:true,draggable:true,underlay:\"shadow\",zIndex:1000,fixedcenter:true,width:\'350px\',constraintoviewport:true\t\t\t\t\n\t\t} );\n/* To store the id to focus after callback */\n\t\tvar focusEle=\"\";\t\n\t\tYAHOO.yui.container.alert = function (msg,id,info){ \n\t\t\t//YAHOO.yui.container.overlay.setBody(\'<div class=alert><span><img src=\"../../eAE/images/process.gif\"></span><span>\'+msg+\'</span></div>\');\n\t\t\tvar arr = info.split(\"~\");\n\t\t\tif (arr[0]==\'Error\')\n\t\t\t{\n\t\t\t\tYAHOO.yui.container.overlay.setBody(\'<table><tr><td><img src=\"../../eAE/images/wdie_error.gif\"></td><td><div class=alert>\'+msg+\'</td></tr></table>\');\n\t\t\t\tYAHOO.yui.container.overlay.setHeader(\"Error\");\n\t\t\t}\n\t\t\telse if (arr[0]==\'Process\')\n\t\t\t{\n\t\t\t\tYAHOO.yui.container.overlay.configWidth=\'50px\';\n\t\t\t\tYAHOO.yui.container.overlay.close=false;\n\t\t\t\tYAHOO.yui.container.overlay.setBody(\'<img align src=\"../../eAE/images/process.gif\">\');\n\t\t\t\tYAHOO.yui.container.overlay.setBody(\'<table><tr><td><img src=\"../../eAE/images/process.gif\"></td><td><div class=\"process\" align=\"center\"> Please Wait.... </td></tr></table>\');\n\t\t\t\tYAHOO.yui.container.overlay.setHeader(\"Processing\");\n\t\t\t}else if(arr[0]==\'Result\'){\n\t\t\t\tYAHOO.yui.container.overlay.configWidth=\'50px\';\n\t\t\t\tYAHOO.yui.container.overlay.close=false;\n\t\t\t\tYAHOO.yui.container.overlay.setBody(\'<img align src=\"../../eAE/images/warn16_1.gif\"\">\');\n\t\t\t\tYAHOO.yui.container.overlay.setBody(\'<table><tr><td><img src=\"../../eAE/images/warn16_1.gif\"></td><td><div class=\"process\"> \'+msg+\'</div></td></tr></table>\');\n\t\t\t\tYAHOO.yui.container.overlay.setHeader(\"Result\");\n\t\t\t}\n\t\t\tYAHOO.yui.container.overlay.render(\"AlertDiv\");\n\t\t\tYAHOO.yui.container.overlay.show();\n\t\t\tfocusEle=id;\n\t\t\tYAHOO.yui.container.overlay.hideEvent.subscribe(focusElement);\n\t\t}\n\n\t\tfunction focusElement()\n\t\t{\n\t\t\tdocument.getElementById(focusEle).focus();\n\t\t}\n\n\t\t\n\t/* var myNewPanel = new YAHOO.widget.Panel(\"myNewPanel\", {\n\t constraintoviewport:true, x:10, y:10, draggable:true, width:\"400px\",\n\t modal:true, effect:\n\t {effect:YAHOO.widget.ContainerEffect.FADE,duration:0.25} } );\n\t myNewPanel.cfg.queueProperty(\"visible\",false);\n\t myNewPanel.setHeader(\"Overlay #3 from Script\");\n\t myNewPanel.setBody(\"<iframe style=\'width:100%;height:400px;\'></iframe>\");\n\t myNewPanel.setFooter(\"© copyright yui\");\n\t myNewPanel.render(\"AlertDiv\");\n\t\t\t myNewPanel.show(); */\n\n\n\tRounded(\"div#Layer5A\",\"ALICEBLUE\",\"#ADD8E6\");\n\tRounded(\"div#Layer6A\",\"ALICEBLUE\",\"#ADD8E6\");\n\tRounded(\"div#Layer4A\",\"ALICEBLUE\",\"#ADD8E6\");\n\n\n\t\n\t";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\tsetTimeout(\"expandHorizontaly(\'Layer5A\',\'Layer6A\',\'imgleft\',\'right\',\'1%\',\'98%\',\'1%\',\'54%\')\",3500);\n\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\tsetTimeout(\"expandHorizontaly(\'Layer6A\',\'Layer5A\',\'imgRight\',\'left\',\'1%\',\'98%\',\'55%\',\'44%\')\",3500);\n\t";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\n\t\n\n });   \n\n\n/*****************************************/\nYAHOO.example.container.submitForm = function() {\n\t//define success handler\n\tvar successHandler = function(o) {\n\t\tYAHOO.yui.container.alert(o.responseText,\'id\',\'Result\');\n\t\tgoRefreshPage();\n\t}\n\t//define failure handler\n\tvar failureHandler = function(o) {\n\t\tAlert(\"Error \" + o.status + \" : \" + o.statusText);\n\t}\n\t//define callback object\nvar callback = {\n\tsuccess:successHandler,\n\tfailure:failureHandler\n\t}\n\n\tvar form = document.getElementById(\"frmAmbMangmntSystem\");\n\tYAHOO.util.Connect.setForm(form);\n\tvar transaction = YAHOO.util.Connect.asyncRequest(\"POST\",\"../../servlet/eAE.AmbulanceManagementServlet\",callback );\n}\n\n\n\n   /*   (function() {   \n   \n         var dd, dd2, clickRadius = 46, startPos,   \n             Event=YAHOO.util.Event, Dom=YAHOO.util.Dom;   \n   \n         YAHOO.util.Event.onDOMReady(function() {   \n   \n             var el = Dom.get(\"ambChart1\");   \n             startPos = Dom.getXY(el);   \n             dd = new YAHOO.util.DDProxy(el); \n\t\t\n\n\t\t\t var el1 = Dom.get(\"ambChart2\");   \n             startPos1 = Dom.getXY(el1);   \n             dd3 = new YAHOO.util.DDProxy(el1); \n            \n\t\t\t dd.clickValidator = function(e) {   \n               var el = this.getEl();   \n               var region = Dom.getRegion(el);  \n\t           setSelctedAmbId(el.name);\n               var r = clickRadius;   \n               var x1 = Event.getPageX(e), y1 = Event.getPageY(e);   \n               var x2 = Math.round((region.right+region.left)/2);   \n               var y2 = Math.round((region.top+region.bottom)/2);   \n               return ( ((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)) <= r*r );   \n             };   \n   \n             dd.onDragDrop = function(e, id) {   \n                 Dom.setXY(this.getEl(), Dom.getXY(id));   \n\t\t\t\t populateReqstdAmb(document.frmAmbMangmntSystem.selAmbId.value);\n\t\t\t}   \n   \n             dd.onInvalidDrop = function(e) {   \n                 new YAHOO.util.Motion(    \n                     this.id, {    \n                         points: {    \n                             to: startPos   \n                         }   \n                     },    \n                     0.3,    \n                     YAHOO.util.Easing.easeOut    \n                 ).animate();   \n   \n             }   \n\n            dd2 = new YAHOO.util.DDTarget(\"bottomRight\");   \n   \n         });   \n   \n     })(); */\t \n\n </script>\n";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n</html>\n";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

java.util.Properties props = new java.util.Properties();

public void jspInit(){
	try{
				java.net.URL url=getServletConfig().getServletContext().getResource("/WEB-INF/classes/AmbTblColumnDef.properties");
				java.io.FileInputStream pin = new java.io.FileInputStream(url.getFile());
				
				if (pin!=null)props.load(pin);

		}catch(Exception ex){
			ex.printStackTrace();
		}
}

private synchronized void createDrggableObject(String divMv,int no,javax.servlet.jsp.JspWriter out1){
	try{
		int psNo=no;
		switch(no%6){
			case 0 :
				psNo=6;
			break;
			case 1 :
				psNo=1;
			break;
			case 2 :
				psNo=2;
			break;
			case 3 :
				psNo=3;
			break;
			case 4 :
				psNo=4;
			break;
			case 5 :
				psNo=5;
			break;
		}
		out1.println("<script>");
		out1.println("(function() {var clickRadius = 70, Event=YAHOO.util.Event, Dom=YAHOO.util.Dom;");
		out1.println("YAHOO.util.Event.onDOMReady(function() {");
		out1.println("var el"+no+" = Dom.get("+divMv+");    dd"+no+" = new YAHOO.util.DDProxy(el"+no+");");
		out1.println("dd"+no+".clickValidator = function(e) {if(!getSelctedAmbId()) return false;  return true;}; ");
		out1.println("dd"+no+".onDragDrop = function(e, id) {startPos"+no+" = Dom.getXY(Dom.get(el"+no+"));new YAHOO.util.Motion( this.id, {points: {to: startPos"+no+"}},0.3,YAHOO.util.Easing.easeOut).animate();setSelctedAmbId(this.getEl().id);populateReqstdAmb(this.getEl().name);}");
		out1.println("dd"+no+".onInvalidDrop = function(e) {startPos"+no+" = Dom.getXY(Dom.get(el"+no+"));new YAHOO.util.Motion( this.id, {points: {to: startPos"+no+"}},0.3,YAHOO.util.Easing.easeOut).animate();FnPosition();}");
		
		out1.println("dt = new YAHOO.util.DDTarget('bottomRight');});})(); ");
		out1.println("</script>");

		//var t=setTimeout(\"alert(eval('startPos'+"+no+"))\",1000);
		
	}catch(java.io.IOException e){
		e.printStackTrace();
	}
}

private String manipulateCheckBox(String chk,String code){
	return chk.equals(code)?"checked":"";
}
private String checkNull(String inputString){
		return (inputString==null)	?	""	:	inputString;
}

private String validateString(String str){
	if(str==null) return "";
	
	StringBuffer sb		=	new StringBuffer();
    int j=0;
	for(int i=0;i<str.length();i++){
		j=(int)str.charAt(i);
		if(j!=10 && j!=13) sb.append(str.charAt(i));
	}
	return sb.toString();
}

public static String truncate(String value, int length){
  if (value != null && value.length() > length){
    value = value.substring(0, length);
    value = value+"...";
  }
  return value;
}



    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, "AmbulanceManagementSystemError.jsp", true , 8192 , true );
        response.setHeader("Content-Type", "text/html;");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;");
            _bw.write(_wl_block0Bytes, _wl_block0);
try{
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

    //String qString=request.getQueryString() ;	
	//String bean_id				 = "AmbulanceManagementSystemBean";
 	//String bean_name			 = "eAE.AmbulanceManagementSystemBean";
	//AmbulanceManagementSystemBean bean	 =	(AmbulanceManagementSystemBean)getBeanObject(bean_id,bean_name, request ) ;	

	String cellData					=	"\"Response\" : { \"Results\" : [ ";
	String cellData1				=	"";
	String cellData2				=	"\"Response\" : { \"Results\" : [ ";
	String patient_name				=	""; 
	String reqtDate					=	""; 
	String status					=	""; 
	String pickup					=	""; 
	String drop						=	"";
	String age						=	""; 
	String sex						=	""; 
	String pickupAddr				=	""; 
	String dropAddr					=	""; 
	String ambNatureCallCode		=	"";
	String ambCaseNum				=	""; 
	String ambVehicleID				=	""; 
	String ambVehicleName			=	""; 
	String ambRegnNo				=	""; 
	String ambModelNo				=	""; 
	String ambDateManf				=	""; 
	String ambLastMileage			=	""; 
	String ambRemarks				=	""; 
	String ambStatus				=	""; 
	String chartClass				=	"";
	String ambContName              =	"";
	String ambContPhone             =	"";
	String ambType					=	"";
	String ambCaseNo				=	"";
	String ambPatDet				=	"";

	String to_date					=	"";
	String from_date				=	"";
	String aChecked					=	"";
	String bChecked					=	"";
	String mChecked					=	"";

	String reqChecked				=	"";
	String asnChecked				=	"";
	String comChecked				=	"";
	String canChecked				=	"";

	String  ambCaseStartDate		=	"";
	String	ambCaseEndDate			=	"";
	String	patientName				=	"";
	String	ambCallerName			=	"";
	String	ambCallerContNo			=	"";
	String	ambCallerRmrks			=	"";
	String	natureCallDesc			=	"";
	String	ambPriorityInd			=	"";
	String	ambStartMileage			=	"";
	String	ambEndMileage			=	"";
	String  ambDispRemarks			=	"";
	String	currentLocation			=	"";

	String mFlag					=	request.getParameter("mFlag")==null?"M":request.getParameter("mFlag");
	String aFlag					=	request.getParameter("aFlag")==null?"A":request.getParameter("aFlag");
	String bFlag					=	request.getParameter("bFlag")==null?"B":request.getParameter("bFlag");
	String reqFlag					=	request.getParameter("reqFlag")==null?"R":request.getParameter("reqFlag");
	String asnFlag					=	request.getParameter("asnFlag")==null?"A":request.getParameter("asnFlag");
	String comFlag					=	request.getParameter("comFlag")==null?"X":request.getParameter("comFlag");
	String canFlag					=	request.getParameter("canFlag")==null?"N":request.getParameter("canFlag");
	String selOrder					=	request.getParameter("selOrder")==null?"":request.getParameter("selOrder");
	String findText					=	request.getParameter("findText")==null?"":request.getParameter("findText").trim();
	String findTextTemp="";
	if(!findText.equals(""))
	findTextTemp="%"+findText+"%";


	/*int queStart					=	request.getParameter("queStart")==null?1:Integer.parseInt(request.getParameter("queStart"));
	int queEnd						=	request.getParameter("queEnd")==null?6:Integer.parseInt(request.getParameter("queEnd"));
	int chartStart					=	request.getParameter("chartStart")==null?1:Integer.parseInt(request.getParameter("chartStart"));
	int chartEnd					=	request.getParameter("chartEnd")==null?6:Integer.parseInt(request.getParameter("chartEnd"));*/

	String pageString				=	request.getParameter("pageString")==null?"":request.getParameter("pageString");
	String wStatus					=	request.getParameter("wStatus")==null?"":request.getParameter("wStatus");

	String err_msg					=	request.getParameter("err_msg")==null?"":request.getParameter("err_msg");

	from_date						=	request.getParameter("from_date");
	to_date							=	request.getParameter("to_date");

	int queTotal					=	0;
	int chartTotal					=	0;

	String ambDiv					=	"";

	
	
	    
	String facility_id				=	(String)session.getValue("facility_id");
	String user						=	(String)session.getValue("login_user");
	String ChkHiddenCols				=	"";
	String defaultOrder				=	"";
	String selOrderDesc				=	"";
	String selOrderId				=	"";
	StringBuffer clDef=new StringBuffer();
	StringBuffer clDef1=new StringBuffer();
	StringBuffer fields1=new StringBuffer();
	StringBuffer clmnOrdrs=new StringBuffer();

	PreparedStatement pstmt 	= null,pstmt1=null;
	Connection con				= null;
	ResultSet rs                = null,rs1=null;
	ArrayList list				= new ArrayList();
	ArrayList AmbChartDetList   = new ArrayList();

	ArrayList orderList			= new ArrayList();
	
	String query="";
	if(!findTextTemp.equals("")){
		query="SELECT A.FACILITY_ID FACILITY_ID,A.AMB_CASE_NO AMB_CASE_NO,to_char(A.AMB_CASE_BOOKED_DATE,'dd/mm/yyyy hh24:mi') AMB_CASE_BOOKED_DATE,A.AMB_VEHICLE_ID	AMB_VEHICLE_ID,	To_char(A.AMB_CASE_START_DATE,'dd/mm/yyyy hh24:mi')	AMB_CASE_START_DATE,to_char(A.AMB_CASE_END_DATE,'dd/mm/yyyy hh24:mi') AMB_CASE_END_DATE,A.PATIENT_ID PATIENT_ID ,nvl((select patient_name  || '/' ||  (case when sex='F' then 'F' when sex='M' then 'M' else 'U' end)  || '/' || get_age(date_of_birth)    from mp_patient where patient_id  =a.patient_id),patient_name  || '/' ||  (case when a.sex='F' then 'F' when a.sex='M' then 'M' else 'U' end)  || '/' || get_age(a.date_of_birth)  ) PATIENT_NAME , A.DATE_OF_BIRTH	DATE_OF_BIRTH,A.AGE AGE,A.SEX SEX,A.PICKUP_FROM_HOSP_YN PICKUP_FROM_HOSP_YN,A.PICKUP_LOCN_CODE PICKUP_LOCN_CODE,NVL((select LONG_DESC   from MP_RES_TOWN where RES_TOWN_CODE = A.PICKUP_LOCN_CODE and rownum <=1),PICKUP_LOCN_DESC) PICKUP_LOCN_DESC,A.PICKUP_ADDRESS	PICKUP_ADDRESS,	A.DESTN_LOCN_CODE DESTN_LOCN_CODE ,	NVL((select LONG_DESC   from MP_RES_TOWN where RES_TOWN_CODE = A.DESTN_LOCN_CODE and rownum <=1),A.DESTN_LOCN_DESC) DESTN_LOCN_DESC,A.DESTN_ADDRESS DESTN_ADDRESS ,	A.AMB_CALLER_NAME AMB_CALLER_NAME , A.AMB_CALLER_CONTACT_NO AMB_CALLER_CONTACT_NO, A.AMB_CALLER_REMARKS AMB_CALLER_REMARKS,	A.AMB_NATURE_CALL_CODE AMB_NATURE_CALL_CODE ,(SELECT LONG_DESC FROM AE_AMB_NATURE WHERE AMB_NATURE_CODE = A.AMB_NATURE_CALL_CODE) NATURE_CALL_DESC,	decode(A.AMB_PRIORITY_IND,'L','Low','H','High','M','Medium')  AMB_PRIORITY_IND,A.AMB_CASE_STATUS AMB_CASE_STATUS,A.AMB_START_MILEAGE AMB_START_MILEAGE,	A.AMB_END_MILEAGE AMB_END_MILEAGE,A.AMB_DISP_REMARKS AMB_DISP_REMARKS ,	C.AMB_CURRENT_LOCATION CURRENT_LOCATION ,B.AMB_VEHICLE_NAME AMB_VEHICLE_NAME,B.AMB_REGN_NO AMB_REGN_NO,	B.AMB_MODEL_NO AMB_MODEL_NO,B.AMB_DATE_MANUFCT AMB_DATE_MANUFCT,B.AMB_LAST_MILEAGE AMB_LAST_MILEAGE,B.AMB_REMARKS AMB_REMARKS FROM	AE_AMB_CASE_REQUEST A , AE_AMB_VEHICLE B,AE_AMB_OPEN_REQUEST C WHERE	A.FACILITY_ID = ? AND	TRUNC(A.AMB_CASE_BOOKED_DATE) between to_Date(?,'dd/mm/yyyy')  and to_Date(?,'dd/mm/yyyy')AND	A.AMB_CASE_STATUS IN ('A','R','C','X') AND	((? = 'R' and A.AMB_CASE_STATUS = 'R') OR (? = 'A' and A.AMB_CASE_STATUS = 'A' ) OR (? = 'C' and A.AMB_CASE_STATUS = 'C' ) OR (? = 'X' and A.AMB_CASE_STATUS = 'X' )) AND	A.FACILITY_ID = B.FACILITY_ID (+) AND	A.AMB_VEHICLE_ID = B.AMB_VEHICLE_ID (+)	AND	A.FACILITY_ID = C.FACILITY_ID (+) AND	A.AMB_CASE_NO = C.AMB_CASE_NO (+) and (upper(nvl((select patient_name  || '/' ||  (case when sex='F' then 'F' when sex='M' then 'M' else 'U' end)  || '/' || get_age(date_of_birth)    from mp_patient where patient_id  =a.patient_id),patient_name  || '/' ||  (case when a.sex='F' then 'F' when a.sex='M' then 'M' else 'U' end)  || '/' || get_age(a.date_of_birth)  )) like upper(?) OR upper(to_char(A.AMB_CASE_BOOKED_DATE,'dd/mm/yyyy hh24:mi')) like upper(?)  OR upper(A.AMB_CASE_STATUS) like upper(?) OR upper(NVL((select LONG_DESC   from MP_RES_TOWN where RES_TOWN_CODE = A.PICKUP_LOCN_CODE and rownum <=1),PICKUP_LOCN_DESC)) like upper(?) OR upper(NVL((select LONG_DESC   from MP_RES_TOWN where RES_TOWN_CODE = A.DESTN_LOCN_CODE and rownum <=1),A.DESTN_LOCN_DESC)) like upper(?) OR upper(A.PICKUP_ADDRESS) like upper(?) OR upper(A.DESTN_ADDRESS) like upper(?) OR upper(A.AMB_CASE_NO) like upper(?) OR upper(To_char(A.AMB_CASE_START_DATE,'dd/mm/yyyy hh24:mi')) like upper(?) OR upper(to_char(A.AMB_CASE_END_DATE,'dd/mm/yyyy hh24:mi')) like upper(?) OR upper(A.AMB_CALLER_NAME) like upper(?) OR upper(A.AMB_CALLER_CONTACT_NO ) like upper(?) OR upper(A.AMB_CALLER_REMARKS) like upper(?) OR upper((SELECT LONG_DESC FROM AE_AMB_NATURE WHERE AMB_NATURE_CODE = A.AMB_NATURE_CALL_CODE)) like upper(?) OR upper(decode(A.AMB_PRIORITY_IND,'L','Low','H','High','M','Medium') ) like upper(?) OR upper(A.AMB_START_MILEAGE) like upper(?) OR upper(A.AMB_END_MILEAGE) like upper(?) OR  upper(A.AMB_DISP_REMARKS) like upper(?) OR  upper(C.AMB_CURRENT_LOCATION) like upper(?) OR upper(B.AMB_VEHICLE_NAME) like upper(?) OR upper(B.AMB_REGN_NO) like upper(?) OR upper(B.AMB_LAST_MILEAGE) like upper(?)) order by AMB_PRIORITY_IND, AMB_CASE_BOOKED_DATE,ROWNUM";
}else{
	query="SELECT A.FACILITY_ID FACILITY_ID,A.AMB_CASE_NO AMB_CASE_NO,to_char(A.AMB_CASE_BOOKED_DATE,'dd/mm/yyyy hh24:mi') AMB_CASE_BOOKED_DATE,A.AMB_VEHICLE_ID	AMB_VEHICLE_ID,	To_char(A.AMB_CASE_START_DATE,'dd/mm/yyyy hh24:mi')	AMB_CASE_START_DATE,to_char(A.AMB_CASE_END_DATE,'dd/mm/yyyy hh24:mi') AMB_CASE_END_DATE,A.PATIENT_ID PATIENT_ID ,nvl((select patient_name  || '/' ||  (case when sex='F' then 'F' when sex='M' then 'M' else 'U' end)  || '/' || get_age(date_of_birth)    from mp_patient where patient_id  =a.patient_id),patient_name  || '/' ||  (case when a.sex='F' then 'F' when a.sex='M' then 'M' else 'U' end)  || '/' || get_age(a.date_of_birth)  ) PATIENT_NAME , A.DATE_OF_BIRTH	DATE_OF_BIRTH,A.AGE AGE,A.SEX SEX,A.PICKUP_FROM_HOSP_YN PICKUP_FROM_HOSP_YN,A.PICKUP_LOCN_CODE PICKUP_LOCN_CODE,NVL((select LONG_DESC   from MP_RES_TOWN where RES_TOWN_CODE = A.PICKUP_LOCN_CODE and rownum <=1),PICKUP_LOCN_DESC) PICKUP_LOCN_DESC,A.PICKUP_ADDRESS	PICKUP_ADDRESS,	A.DESTN_LOCN_CODE DESTN_LOCN_CODE ,	NVL((select LONG_DESC   from MP_RES_TOWN where RES_TOWN_CODE = A.DESTN_LOCN_CODE and rownum <=1),A.DESTN_LOCN_DESC) DESTN_LOCN_DESC,A.DESTN_ADDRESS DESTN_ADDRESS ,	A.AMB_CALLER_NAME AMB_CALLER_NAME , A.AMB_CALLER_CONTACT_NO AMB_CALLER_CONTACT_NO, A.AMB_CALLER_REMARKS AMB_CALLER_REMARKS,	A.AMB_NATURE_CALL_CODE AMB_NATURE_CALL_CODE ,(SELECT LONG_DESC FROM AE_AMB_NATURE WHERE AMB_NATURE_CODE = A.AMB_NATURE_CALL_CODE) NATURE_CALL_DESC,	decode(A.AMB_PRIORITY_IND,'L','Low','H','High','M','Medium')  AMB_PRIORITY_IND,A.AMB_CASE_STATUS AMB_CASE_STATUS,A.AMB_START_MILEAGE AMB_START_MILEAGE,	A.AMB_END_MILEAGE AMB_END_MILEAGE,A.AMB_DISP_REMARKS AMB_DISP_REMARKS ,	C.AMB_CURRENT_LOCATION CURRENT_LOCATION ,B.AMB_VEHICLE_NAME AMB_VEHICLE_NAME,B.AMB_REGN_NO AMB_REGN_NO,	B.AMB_MODEL_NO AMB_MODEL_NO,B.AMB_DATE_MANUFCT AMB_DATE_MANUFCT,B.AMB_LAST_MILEAGE AMB_LAST_MILEAGE,B.AMB_REMARKS AMB_REMARKS FROM	AE_AMB_CASE_REQUEST A , AE_AMB_VEHICLE B,AE_AMB_OPEN_REQUEST C WHERE	A.FACILITY_ID = ? AND	TRUNC(A.AMB_CASE_BOOKED_DATE) between to_Date(?,'dd/mm/yyyy')  and to_Date(?,'dd/mm/yyyy') AND	A.AMB_CASE_STATUS IN ('A','R','C','X') AND	((? = 'R' and A.AMB_CASE_STATUS = 'R') OR (? = 'A' and A.AMB_CASE_STATUS = 'A' ) OR (? = 'C' and A.AMB_CASE_STATUS = 'C' ) OR (? = 'X' and A.AMB_CASE_STATUS = 'X' )) AND	A.FACILITY_ID = B.FACILITY_ID (+) AND	A.AMB_VEHICLE_ID = B.AMB_VEHICLE_ID (+)	AND	A.FACILITY_ID = C.FACILITY_ID (+) AND	A.AMB_CASE_NO = C.AMB_CASE_NO (+) order by AMB_PRIORITY_IND, AMB_CASE_BOOKED_DATE,ROWNUM";
}

	String query3="select Count(*) FROM	AE_AMB_CASE_REQUEST A , AE_AMB_VEHICLE B,AE_AMB_OPEN_REQUEST C WHERE	A.FACILITY_ID = ? AND	TRUNC(A.AMB_CASE_BOOKED_DATE) between to_Date(?,'dd/mm/yyyy')  and to_Date(?,'dd/mm/yyyy')AND	A.AMB_CASE_STATUS IN ('A','R','C','X') AND	((? = 'R' and A.AMB_CASE_STATUS = 'R') OR (? = 'A' and A.AMB_CASE_STATUS = 'A' ) OR (? = 'C' and A.AMB_CASE_STATUS = 'C' ) OR (? = 'X' and A.AMB_CASE_STATUS = 'X' )) AND	A.FACILITY_ID = B.FACILITY_ID (+) AND	A.AMB_VEHICLE_ID = B.AMB_VEHICLE_ID (+)	AND	A.FACILITY_ID = C.FACILITY_ID (+) AND	A.AMB_CASE_NO = C.AMB_CASE_NO (+) order by A.AMB_PRIORITY_IND, A.AMB_CASE_BOOKED_DATE";
	
	String query1="SELECT A.AMB_VEHICLE_ID AMB_VEHICLE_ID, A.AMB_VEHICLE_NAME AMB_VEHICLE_NAME,A.AMB_REGN_NO AMB_REGN_NO,	A.AMB_MODEL_NO AMB_MODEL_NO,A.AMB_DATE_MANUFCT AMB_DATE_MANUFCT,A.AMB_LAST_MILEAGE AMB_LAST_MILEAGE,A.AMB_REMARKS AMB_REMARKS ,(CASE WHEN A.SUSPEND_MAINT_YN = 'Y' THEN 'M' ELSE   CASE WHEN A.SUSPEND_MAINT_YN = 'N' AND EXISTS (SELECT 'Y' FROM AE_AMB_OPEN_REQUEST WHERE FACILITY_ID = A.FACILITY_ID and AMB_VEHICLE_ID = A.AMB_VEHICLE_ID) THEN 'A' ELSE   CASE WHEN A.SUSPEND_MAINT_YN = 'N' AND NOT EXISTS (SELECT 'Y' FROM AE_AMB_OPEN_REQUEST WHERE FACILITY_ID = A.FACILITY_ID and AMB_VEHICLE_ID = A.AMB_VEHICLE_ID) THEN 'B' END END END)  AMB_STATUS, b.AMB_CASE_NO amb_Case_no ,(select PATIENT_NAME || '/' || sex  || '/'  || GET_AGE(DATE_OF_BIRTH)  from AE_AMB_CASE_REQUEST where facility_id = b.facility_id and  AMB_CASE_NO = b.AMB_CASE_NO )  Patient_dtls , A.AMB_LOCATION AMB_PARK_LOCATION , (select (select practitioner_name  from AM_PRACT_FOR_AMB_VW where practitioner_id = AMB_RESOURCE_ID and pract_source = AMB_RESOURCE_TYPE)  FROM  AE_AMB_VEHICLE_RESOURCE where facility_id = a.facility_id and AMB_VEHICLE_ID = a.AMB_VEHICLE_ID and CONTACT_DISPLY_YN = 'Y'  ) AMB_CONT_NAME, (select (select CONTACT_NO  from AM_PRACT_FOR_AMB_VW where practitioner_id = AMB_RESOURCE_ID and pract_source = AMB_RESOURCE_TYPE)  FROM  AE_AMB_VEHICLE_RESOURCE where facility_id = a.facility_id and AMB_VEHICLE_ID = a.AMB_VEHICLE_ID and CONTACT_DISPLY_YN = 'Y'  ) AMB_CONT_PHONE,AMB_VEHICLE_TYPE,(CASE WHEN  'Y' = (SELECT 'Y' FROM AE_AMB_OPEN_REQUEST WHERE FACILITY_ID = A.FACILITY_ID and AMB_VEHICLE_ID = A.AMB_VEHICLE_ID) THEN b.AMB_CURRENT_LOCATION  ELSE  a.AMB_LOCATION END) AMB_LOCATION  from	AE_AMB_VEHICLE A, AE_AMB_OPEN_REQUEST B WHERE	a.FACILITY_ID = ? and A.EFF_STATUS = 'E' and a.FACILITY_ID = b.FACILITY_ID (+) and a.AMB_VEHICLE_ID = b.AMB_VEHICLE_ID (+) and ( (? = 'M'  AND  'Y' = A.SUSPEND_MAINT_YN) OR  (? = 'A' and 'N' =  A.SUSPEND_MAINT_YN AND EXISTS (SELECT 'Y' FROM AE_AMB_OPEN_REQUEST WHERE FACILITY_ID = A.FACILITY_ID and AMB_VEHICLE_ID = A.AMB_VEHICLE_ID)  ) OR (? = 'B' and ('N' = A.SUSPEND_MAINT_YN AND NOT EXISTS (SELECT 'Y' FROM AE_AMB_OPEN_REQUEST WHERE FACILITY_ID = A.FACILITY_ID and AMB_VEHICLE_ID = A.AMB_VEHICLE_ID) ))) order by 1";

	String query2="select USER_DEFN_PAGE_ID,USER_DEFN_PAGE_DESC,DEFAULT_YN,USER_DEFN_MAIN_PAGE from AE_AMB_USER_DEFN_PAGE where APPL_USER_ID=? order by lower(USER_DEFN_PAGE_DESC) ";

	String query4="select count(*) from	AE_AMB_VEHICLE A, AE_AMB_OPEN_REQUEST B WHERE	a.FACILITY_ID = ? and A.EFF_STATUS = 'E' and a.FACILITY_ID = b.FACILITY_ID (+) and a.AMB_VEHICLE_ID = b.AMB_VEHICLE_ID (+) and ( (? = 'M'  AND  'Y' = A.SUSPEND_MAINT_YN) OR  (? = 'A' and 'N' =  A.SUSPEND_MAINT_YN AND EXISTS (SELECT 'Y' FROM AE_AMB_OPEN_REQUEST WHERE FACILITY_ID = A.FACILITY_ID and AMB_VEHICLE_ID = A.AMB_VEHICLE_ID)  ) OR (? = 'B' and ('N' = A.SUSPEND_MAINT_YN AND NOT EXISTS (SELECT 'Y' FROM AE_AMB_OPEN_REQUEST WHERE FACILITY_ID = A.FACILITY_ID and AMB_VEHICLE_ID = A.AMB_VEHICLE_ID) ))) order by 1";

	try{
        con = ConnectionManager.getConnection(request);

		/*pstmt = con.prepareStatement(query3); 
		pstmt.setString(1,facility_id);
		pstmt.setString(2,from_date);
		pstmt.setString(3,to_date);
		pstmt.setString(4,reqFlag);
		pstmt.setString(5,asnFlag);
		pstmt.setString(6,comFlag);
		pstmt.setString(7,canFlag);
		rs=pstmt.executeQuery();

		if(rs.next()){
			queTotal=rs.getInt(1);
		}*/

		/*pstmt = con.prepareStatement(query4); 
		pstmt.setString(1,facility_id);
		pstmt.setString(2,mFlag);
		pstmt.setString(3,aFlag);
		pstmt.setString(4,bFlag);

		rs=pstmt.executeQuery();

		if(rs.next()){
			chartTotal=rs.getInt(1);
		}*/

		
		/*if(pageString.equals("queNext")){
			queStart=queStart+6;
			if((queEnd+6)<queTotal)queEnd+=6; else queEnd=queTotal;
		}else if (pageString.equals("quePrev")){
			queStart=queStart-6;
			if(queEnd==queTotal)
				queEnd=(queTotal%6==0)?queEnd-6:queEnd-(queTotal%6);
			else
				queEnd-=6;
		}if(pageString.equals("chartNext")){
			chartStart=chartStart+6;
			if((chartEnd+6)<chartTotal)chartEnd+=6; else chartEnd=chartTotal;
		}else if (pageString.equals("chartPrev")){
			chartStart=chartStart-6;
			if(chartEnd==chartTotal) 
				chartEnd=(chartTotal%6==0)?chartEnd-6:chartEnd-(chartTotal%6);
			else
				chartEnd-=6;
		}else if(pageString.equals("")){
			/*if(queTotal<6)
				queEnd=queTotal;
			if(chartTotal<6)
				chartEnd=chartTotal;
		}*/

	
		pstmt = con.prepareStatement(query); 
		pstmt.setString(1,facility_id);
		pstmt.setString(2,from_date);
		pstmt.setString(3,to_date);
		pstmt.setString(4,reqFlag);
		pstmt.setString(5,asnFlag);
		pstmt.setString(6,comFlag);
		pstmt.setString(7,canFlag);
		if(!findTextTemp.equals("")){
			pstmt.setString(8,findTextTemp);
			pstmt.setString(9,findTextTemp);
			pstmt.setString(10,findTextTemp);
			pstmt.setString(11,findTextTemp);
			pstmt.setString(12,findTextTemp);
			pstmt.setString(13,findTextTemp);
			pstmt.setString(14,findTextTemp);
			pstmt.setString(15,findTextTemp);
			pstmt.setString(16,findTextTemp);
			pstmt.setString(17,findTextTemp);
			pstmt.setString(18,findTextTemp);
			pstmt.setString(19,findTextTemp);
			pstmt.setString(20,findTextTemp);
			pstmt.setString(21,findTextTemp);
			pstmt.setString(22,findTextTemp);
			pstmt.setString(23,findTextTemp);
			pstmt.setString(24,findTextTemp);
			pstmt.setString(25,findTextTemp);
			pstmt.setString(26,findTextTemp);
			pstmt.setString(27,findTextTemp);
			pstmt.setString(28,findTextTemp);
			pstmt.setString(29,findTextTemp);
		}
		//pstmt.setInt(8,queEnd);
		//pstmt.setInt(9,queStart);
		rs=pstmt.executeQuery();
		while(rs.next()){
			list.add(rs.getString("PATIENT_NAME"));	//-------------------------1
			list.add(rs.getString("AMB_CASE_BOOKED_DATE"));//------------------2       
			list.add(rs.getString("AMB_CASE_STATUS"));//-----------------------3
			list.add(rs.getString("PICKUP_LOCN_DESC"));//----------------------4
			list.add(rs.getString("destn_locn_desc"));//-----------------------5
			list.add(rs.getString("age"));//-----------------------------------6
			list.add(rs.getString("sex"));//-----------------------------------7
			list.add(rs.getString("pickup_address"));//------------------------8
			list.add(rs.getString("destn_address"));//-------------------------9
			list.add(rs.getString("amb_nature_call_code"));//------------------10
			list.add(rs.getString("amb_case_no"));//---------------------------11
			list.add(rs.getString("AMB_CASE_START_DATE"));//-------------------12
			list.add(rs.getString("AMB_CASE_END_DATE"));//---------------------13

			list.add(rs.getString("AMB_CALLER_NAME"));//-----------------------14
			list.add(rs.getString("AMB_CALLER_CONTACT_NO"));//-----------------15
			list.add(rs.getString("AMB_CALLER_REMARKS"));//--------------------16
			
			list.add(rs.getString("NATURE_CALL_DESC"));//-----------------------17
			list.add(rs.getString("AMB_PRIORITY_IND"));//-----------------------18
			list.add(rs.getString("AMB_START_MILEAGE"));//----------------------19
			list.add(rs.getString("AMB_END_MILEAGE"));//------------------------20
			list.add(rs.getString("AMB_DISP_REMARKS"));//-----------------------21

			list.add(rs.getString("CURRENT_LOCATION"));//-----------------------22
			list.add(rs.getString("AMB_VEHICLE_NAME"));//-----------------------23
			list.add(rs.getString("AMB_REGN_NO"));//----------------------------24
			list.add(rs.getString("AMB_LAST_MILEAGE"));//-----------------------25		
			
		}

		pstmt1=con.prepareStatement(query1);
		pstmt1.setString(1,facility_id);
		pstmt1.setString(2,mFlag);
		pstmt1.setString(3,aFlag);
		pstmt1.setString(4,bFlag);
		//pstmt1.setInt(5,chartEnd);
		//pstmt1.setInt(6,chartStart);
		rs1=pstmt1.executeQuery();
	
		while(rs1.next()){
			AmbChartDetList.add(rs1.getString("AMB_VEHICLE_ID"));
			AmbChartDetList.add(rs1.getString("AMB_VEHICLE_NAME"));
			AmbChartDetList.add(rs1.getString("AMB_REGN_NO"));
			AmbChartDetList.add(rs1.getString("AMB_MODEL_NO"));
			AmbChartDetList.add(rs1.getString("AMB_DATE_MANUFCT"));
			AmbChartDetList.add(rs1.getString("AMB_LAST_MILEAGE"));
			AmbChartDetList.add(rs1.getString("AMB_REMARKS"));
			AmbChartDetList.add(rs1.getString("AMB_STATUS"));
			AmbChartDetList.add(rs1.getString("AMB_CONT_NAME")==null?"":rs1.getString("AMB_CONT_NAME"));
			AmbChartDetList.add(rs1.getString("AMB_CONT_PHONE")==null?"":rs1.getString("AMB_CONT_PHONE"));
			AmbChartDetList.add(rs1.getString("AMB_VEHICLE_TYPE"));
			AmbChartDetList.add(rs1.getString("amb_Case_no"));
			AmbChartDetList.add(rs1.getString("Patient_dtls"));
			AmbChartDetList.add(rs1.getString("AMB_LOCATION")==null?"":rs1.getString("AMB_LOCATION"));
		}

		pstmt1=con.prepareStatement(query2);
		pstmt1.setString(1,user);
		rs1=pstmt1.executeQuery();

		boolean commaFlag=false;

		while(rs1.next() && rs1!=null){
			//defaultOrder=rs1.getString(4);
			if(!selOrder.equals("")){
				if(selOrder.equals(rs1.getString(1))){
					defaultOrder=rs1.getString(4);
					selOrderDesc=rs1.getString(2);
					selOrderId=selOrder;
				}
			}else{
				if((rs1.getString(3)==null?"":rs1.getString(3)).equals("Y")){
					defaultOrder=rs1.getString(4);
					selOrderDesc=rs1.getString(2);
					selOrderId=rs1.getString(1);
				}
			}

			if(commaFlag) clmnOrdrs.append(",");

			clmnOrdrs.append("{ text: '"+rs1.getString(2)+"', value: '"+rs1.getString(1)+"', onclick: { fn: onMenuItemClick } }");

			commaFlag=true;
			
		}
		ChkHiddenCols=props.getProperty("SystemDefault");
		if(defaultOrder==null) defaultOrder="";
		if(defaultOrder.equals("")){
			//clmnOrdrs.append("{ text: 'SystemDefault', value: 'SystemDefault', onclick: { fn: onMenuItemClick } }");
			selOrderDesc="System Defined";
			defaultOrder=ChkHiddenCols;
		
		}
	StringTokenizer stHdnCols=new StringTokenizer(ChkHiddenCols,",");
	StringTokenizer st=new StringTokenizer(defaultOrder,",");	
    int cNo=0;
	String strHdnCols="",strHdnColsVal="",str="",str1="",strAmbRequst="";
	ArrayList dbList=new ArrayList();

	while(st.hasMoreTokens()){	
		str=st.nextToken();
		dbList.add(str);
		str1=props.getProperty(str);
		//strAmbRequst=props.getProperty("AmbRequst_"+str);
		strAmbRequst=props.getProperty(str);
		if(cNo!=0) clDef.append(",");
		clDef.append(str1);
		if(cNo<4){
            if(cNo!=0) {fields1.append(",");clDef1.append(",");}
		
			if(str.equals("Status1"))
				fields1.append("{key:\""+str+"\",parser:\"myCustom\"}");
			else if(str.equals("RequestedDate") || str.equals("ambCaseStartDate") || str.equals("ambCaseEndDate"))
				fields1.append("{key:\""+str+"\",parser:\"YAHOO.widget.DataTable.formatDate\"}");
			else if(str.equals("ambStartMileage") || str.equals("ambEndMileage") ||  str.equals("ambLastMileage"))
				fields1.append("{key:\""+str+"\",parser:\"number\"}");
			else
				fields1.append("{key:\""+str+"\",parser:\"string\"}");
		
			//fields1.append("{key:\""+str+"\"}");
			clDef1.append(strAmbRequst);
		}
        cNo++;
	}
		
	if(cNo<22){
	while(stHdnCols.hasMoreTokens()){
		strHdnCols=stHdnCols.nextToken();
		if(!dbList.contains(strHdnCols)){	
			strHdnColsVal=props.getProperty("hidden_"+strHdnCols);	
			if(cNo!=0 && cNo!=22) clDef.append(",");					
			clDef.append(strHdnColsVal);				
			
			cNo++;
			}
			
		}
	}
	
	


	}catch(Exception e){
		//err_msg=java.net.URLEncoder.encode(e.toString());
		System.out.println("Exception in AmbulanceManagementSystemCode.jsp");
		e.printStackTrace();
		throw e;
	}
	finally {
		try{
			if(rs!=null) rs.close();
			if(rs1!=null) rs1.close();
			if( pstmt!=null ) pstmt.close(); 
			if( pstmt1!=null ) pstmt1.close(); 
			if( con!=null )
				ConnectionManager.returnConnection(con, request);
			rs=null;
			pstmt=null;
			rs1=null;
			pstmt1=null;
			con=null;
		}catch(Exception e){
			e.printStackTrace();			
		}
	}


	/*SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy");
	java.util.Calendar cal = java.util.Calendar.getInstance();
	to_date =sf.format(cal.getTime());
	cal.add(Calendar.DATE,-7);
	from_date=sf.format(cal.getTime());*/
	
	//ArrayList list=bean.getAmbulanceRequestDet();
	//ArrayList AmbChartDetList=bean.getAmbulanceChartDet(facility_id);

	
	
	for(int i=0;i<list.size();i+=25){

		patient_name		=	(String)list.get(i);
		reqtDate			=	(String)list.get(i+1);
		status				=	(String)list.get(i+2);
		pickup				=	list.get(i+3)==null?"":(String)list.get(i+3);
		drop				=	list.get(i+4)==null?"":(String)list.get(i+4);
		age					=	list.get(i+5)==null?"":(String)list.get(i+5);
		sex					=	list.get(i+6)==null?"":(String)list.get(i+6);
		pickupAddr			=	list.get(i+7)==null?"":(String)list.get(i+7);
		dropAddr			=	list.get(i+8)==null?"":(String)list.get(i+8);
		ambNatureCallCode	=	list.get(i+9)==null?"":(String)list.get(i+9);
		ambCaseNum			=	list.get(i+10)==null?"":(String)list.get(i+10);

		ambCaseStartDate	=	list.get(i+11)==null?"":(String)list.get(i+11);
		ambCaseEndDate		=	list.get(i+12)==null?"":(String)list.get(i+12);
		ambCallerName		=	list.get(i+13)==null?"":(String)list.get(i+13);
		ambCallerContNo		=	list.get(i+14)==null?"":(String)list.get(i+14);
		ambCallerRmrks		=	list.get(i+15)==null?"":(String)list.get(i+15);
		natureCallDesc		=	list.get(i+16)==null?"":(String)list.get(i+16);
		ambPriorityInd		=	list.get(i+17)==null?"":(String)list.get(i+17);
		ambStartMileage		=	list.get(i+18)==null?"":(String)list.get(i+18);
		ambEndMileage		=	list.get(i+19)==null?"":(String)list.get(i+19);
		ambDispRemarks		=	list.get(i+20)==null?"":(String)list.get(i+20);
		currentLocation		=	list.get(i+21)==null?"":(String)list.get(i+21);
		ambVehicleName		=	list.get(i+22)==null?"":(String)list.get(i+22);
		ambRegnNo			=	list.get(i+23)==null?"":(String)list.get(i+23);
		ambLastMileage		=	list.get(i+24)==null?"":(String)list.get(i+24);

		ambCallerRmrks=validateString(ambCallerRmrks);
		pickupAddr=validateString(pickupAddr);
		dropAddr=validateString(dropAddr);
		ambDispRemarks=validateString(ambDispRemarks);
		

		//cellData			=	cellData+"{Name:\""+patient_name+"\",RequestedDate:\""+reqtDate+"\",Status1:\""+status+"\",Pickup:\""+pickup+"\",Drop:\""+drop+"\",PickupAddress:\""+pickupAddr+"\",DropAddress:\""+dropAddr+"\",AmbNo:\""+ambCaseNum+"\",ambCaseStartDate:\""+ambCaseStartDate+"\",ambCaseEndDate:\""+ambCaseEndDate+"\",ambCallerName:\""+ambCallerName+"\",ambCallerContNo:\""+ambCallerContNo+"\",ambCallerRmrks:\""+ambCallerRmrks+"\",natureCallDesc:\""+natureCallDesc+"\",ambPriorityInd:\""+ambPriorityInd+"\",ambStartMileage:\""+ambStartMileage+"\",ambEndMileage:\""+ambEndMileage+"\",ambDispRemarks:\""+ambDispRemarks+"\",currentLocation:\""+currentLocation+"\",ambVehicleName:\""+ambVehicleName+"\",ambRegnNo:\""+ambRegnNo+"\",ambLastMileage:\""+ambLastMileage+"\"},";
		cellData			=	cellData+"{\"Name\":\""+truncate(patient_name,10)+"\",\"RequestedDate\":\""+reqtDate+"\",\"Status1\":\""+status+"\",\"Pickup\":\""+truncate(pickup,10)+"\",\"Drop\":\""+truncate(drop,10)+"\",\"PickupAddress\":\""+truncate(pickupAddr,11)+"\",\"DropAddress\":\""+truncate(dropAddr,14)+"\",\"AmbNo\":\""+ambCaseNum+"\",\"ambCaseStartDate\":\""+ambCaseStartDate+"\",\"ambCaseEndDate\":\""+ambCaseEndDate+"\",\"ambCallerName\":\""+truncate(ambCallerName,12)+"\",\"ambCallerContNo\":\""+truncate(ambCallerContNo,20)+"\",\"ambCallerRmrks\":\""+truncate(ambCallerRmrks,20)+"\",\"natureCallDesc\":\""+truncate(natureCallDesc,12)+"\",\"ambPriorityInd\":\""+ambPriorityInd+"\",\"ambStartMileage\":\""+truncate(ambStartMileage,15)+"\",\"ambEndMileage\":\""+truncate(ambEndMileage,15)+"\",\"ambDispRemarks\":\""+truncate(ambDispRemarks,20)+"\",\"currentLocation\":\""+currentLocation+"\",\"ambVehicleName\":\""+truncate(ambVehicleName,12)+"\",\"ambRegnNo\":\""+truncate(ambRegnNo,20)+"\",\"ambLastMileage\":\""+ambLastMileage+"\"},";

		

		//cellData1			=	cellData1+"{Name:\""+patient_name+"\",RequestedDate:\""+reqtDate+"\",Status2:\""+status+"\",Pickup:\""+pickup+"\",Drop:\""+drop+"\"},";
	}

	


	for(int i=0;i<AmbChartDetList.size();i+=14){
		ambVehicleID			=	(String)AmbChartDetList.get(i);
		ambVehicleName			=	(String)AmbChartDetList.get(i+1);
		ambRegnNo				=	AmbChartDetList.get(i+2)==null?"":(String)AmbChartDetList.get(i+2);
		ambModelNo				=	AmbChartDetList.get(i+3)==null?"":(String)AmbChartDetList.get(i+3);
		ambDateManf				=	AmbChartDetList.get(i+4)==null?"":(String)AmbChartDetList.get(i+4);
		ambLastMileage			=	AmbChartDetList.get(i+5)==null?"":(String)AmbChartDetList.get(i+5);
		ambRemarks				=	AmbChartDetList.get(i+6)==null?"":validateString((String)AmbChartDetList.get(i+6));
		ambStatus				=	(String)AmbChartDetList.get(i+7);
		ambContName				=   AmbChartDetList.get(i+8)==null?"":(String)AmbChartDetList.get(i+8);
		ambContPhone			=   AmbChartDetList.get(i+9)==null?"":(String)AmbChartDetList.get(i+9);
		ambType					=   AmbChartDetList.get(i+10)==null?"":(String)AmbChartDetList.get(i+10);

		 ambCaseNo=AmbChartDetList.get(i+11)==null?"":(String)AmbChartDetList.get(i+11);
		 ambPatDet=AmbChartDetList.get(i+12)==null?"&nbsp;":(String)AmbChartDetList.get(i+12);

		if(!ambContPhone.equals("")) ambContName=ambContName+"("+ambContPhone+")";
        
		ambDiv					=	ambStatus+"~"+ambType+"~"+AmbChartDetList.get(i+2)+"~"+AmbChartDetList.get(i)+"~"+AmbChartDetList.get(i+1)+"~"+AmbChartDetList.get(i+8)+"~"+AmbChartDetList.get(i+9)+"~"+ambCaseNo+"~"+ambPatDet+"~"+AmbChartDetList.get(i+13);
		
		
		cellData2			=cellData2+"{\"vehicleid\":\""+ambVehicleID+"\",\"vehiclename\":\""+truncate(ambVehicleName,30)+"\",\"regnno\":\""+truncate(ambRegnNo,20)+"\",\"modelno\":\""+truncate(ambModelNo,20)+"\",\"ambContname\":\""+truncate(ambContName,18)+"\",\"lastmileage\":\""+truncate(ambLastMileage,17)+"\",\"Status3\":\""+ambStatus+"\",\"ambtype\":\""+ambType+"\",\"ambDiv\":\""+ambDiv+"\"},";
	}
 


	cellData=(cellData.length()>0)?cellData.substring(0,cellData.length()-1):cellData;
	//cellData1=(cellData1.length()>0)?cellData1.substring(0,cellData1.length()-1):cellData1;
	cellData2=(cellData2.length()>0)?cellData2.substring(0,cellData2.length()-1):cellData2;
	cellData=cellData+"]}";
	cellData2=cellData2+"]}";
	

			

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block6Bytes, _wl_block6);

	
	out.println("<script>");
	out.println("YAHOO.example.Data =  {ambReqstDataAll: {"+cellData+"}}");
	//out.println("YAHOO.example.Data1 = {ambReqstData:	{"+cellData+"}}");
	out.println("YAHOO.example.Data2 = {ambChartData:	{"+cellData2+"}}");
	out.println("var myColumnDefs = ["+clDef+"];");
	out.println("var myColumnDefs1 = ["+clDef1+"];");
	//if(!err_msg.equals("")) out.println("alert(unescape('"+err_msg.replace('+',' ')+"'));");
	out.println("</script>");

	

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(manipulateCheckBox(reqFlag,"R")));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(manipulateCheckBox(asnFlag,"A")));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(manipulateCheckBox(comFlag,"C")));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(manipulateCheckBox(canFlag,"X")));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(to_date));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(to_date));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(to_date));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(findText));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(manipulateCheckBox(aFlag,"A")));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(manipulateCheckBox(mFlag,"M")));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(manipulateCheckBox(bFlag,"B")));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
if(AmbChartDetList.size()>84){
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block34Bytes, _wl_block34);

	String imgSRC="",dragVal="",alignString="",disp="";
	char ambtype;
	int y=0,chPage=0;
	for(int i=0,j=1;i<AmbChartDetList.size();i+=14,j++){
		ambStatus=(String)AmbChartDetList.get(i+7);
		ambType=AmbChartDetList.get(i+10)==null?"@":(String)AmbChartDetList.get(i+10);
		ambtype=ambType.charAt(0);

		ambCaseNo=AmbChartDetList.get(i+11)==null?"":(String)AmbChartDetList.get(i+11);
		ambPatDet=AmbChartDetList.get(i+12)==null?"&nbsp;":(String)AmbChartDetList.get(i+12);

		dragVal=ambStatus+"~"+ambType+"~"+AmbChartDetList.get(i+2)+"~"+AmbChartDetList.get(i)+"~"+AmbChartDetList.get(i+1)+"~"+AmbChartDetList.get(i+8)+"~"+AmbChartDetList.get(i+9)+"~"+ambCaseNo+"~"+ambPatDet+"~"+AmbChartDetList.get(i+13);

		alignString=((j%2)==0)?"right":"left";

		 switch(ambtype){
			   case 'R':
				   imgSRC="style=\"background-image:url('../../eAE/images/Ambulance.gif');background-repeat: no-repeat\"";
					break;
				
				case 'M':
					imgSRC="style=\"background-image:url('../../eAE/images/boatambulance.gif');\"";
					 break;
				
				case 'A':
					imgSRC="style=\"background-image:url('../../eAE/images/airambulance.gif');\"";
					 break;
	
				default:
					 imgSRC="style=\"background-image:url('../../eAE/images/Ambulance.gif');\"";
					 break;
		}
		if(ambStatus.equals("B")){
			chartClass="ambchartB";
		}else if(ambStatus.equals("A")){
			chartClass="ambchartA";
		}else if(ambStatus.equals("M")){
			chartClass="ambchartM";
		}
            _bw.write(_wl_block35Bytes, _wl_block35);
if(y%6==0){
		
	chPage++;
	if(y==0) disp="inline;";else disp="none;";
	
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(chPage));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(disp));
            _bw.write(_wl_block38Bytes, _wl_block38);
}
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(alignString));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(j));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(dragVal));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(chartClass));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(imgSRC));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(ambStatus));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(ambType));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(AmbChartDetList.get(i+2)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(AmbChartDetList.get(i)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(AmbChartDetList.get(i+8)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(AmbChartDetList.get(i+9)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(ambPatDet));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(ambCaseNo));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(AmbChartDetList.get(i+13)));
            _bw.write(_wl_block46Bytes, _wl_block46);
if(!AmbChartDetList.get(i+9).equals(""))
			out.println(AmbChartDetList.get(i)+"<br>"+AmbChartDetList.get(i+2)+"<br>"+AmbChartDetList.get(i+13)+"<br>"+AmbChartDetList.get(i+8)+"("+AmbChartDetList.get(i+9)+")<br>"+ambPatDet);
	  else	
			out.println(AmbChartDetList.get(i)+"<br>"+AmbChartDetList.get(i+2)+"<br>"+AmbChartDetList.get(i+13)+"<br>"+AmbChartDetList.get(i+8)+"<br>"+ambPatDet);
	
            _bw.write(_wl_block47Bytes, _wl_block47);

	if(!ambStatus.equals("M"))
			createDrggableObject("ambChart"+j,j,out);
	 
            _bw.write(_wl_block48Bytes, _wl_block48);
if((j%2)==0){
            _bw.write(_wl_block49Bytes, _wl_block49);
 if(j%6!=0){
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block35Bytes, _wl_block35);
}if(j%6==0 && y!=0  && AmbChartDetList.size()>84){
            _bw.write(_wl_block51Bytes, _wl_block51);

	}

	y++;}
            _bw.write(_wl_block35Bytes, _wl_block35);
if(AmbChartDetList.size()%84!=0 || AmbChartDetList.size()<=84){
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(chPage));
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block113Bytes, _wl_block113);
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(selOrderId));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(wStatus));
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);
out.println("var aMenuButton4Menu = ["+clmnOrdrs+"];");
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf("'"+selOrderDesc+"'"));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf("'"+selOrderDesc+"'"));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(fields1));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(fields1));
            _bw.write(_wl_block126Bytes, _wl_block126);
 if(wStatus.equals("leftExp")){
            _bw.write(_wl_block127Bytes, _wl_block127);
}else if(wStatus.equals("rightExp")){
            _bw.write(_wl_block128Bytes, _wl_block128);
}
            _bw.write(_wl_block129Bytes, _wl_block129);
//putObjectInBean(bean_id,bean,request);
            _bw.write(_wl_block130Bytes, _wl_block130);
}catch(Exception e){
System.out.println("@@@ Exception in AmbulanceManagementSystem.jsp="+e);
e.printStackTrace();
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.AmbulanceManagementDashboard.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.RequestedQueue.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Requested.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Assigned.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.completed.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancelled.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.find.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Go.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.AmbulanceChart.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Assigned.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.maintenance.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.available.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.RecordUnderMaintenanceDetails.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.currentlocation.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.UnderRepair.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag17 = null ;
        int __result__tag17 = 0 ;

        if (__tag17 == null ){
            __tag17 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag17);
        }
        __tag17.setPageContext(pageContext);
        __tag17.setParent(null);
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.periodfrom.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag17;
        __result__tag17 = __tag17.doStartTag();

        if (__result__tag17!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag17== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag17.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag17);
            return true;
        }
        _activeTag=__tag17.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag17);
        __tag17.release();
        return false;
    }

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(null);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Period.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag18;
        __result__tag18 = __tag18.doStartTag();

        if (__result__tag18!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag18== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag18.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag18);
            return true;
        }
        _activeTag=__tag18.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag18);
        __tag18.release();
        return false;
    }

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag19.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag19);
            return true;
        }
        _activeTag=__tag19.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag19);
        __tag19.release();
        return false;
    }

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.RevokeUnderMaintenanceDetails.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.currentlocation.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(null);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.periodfrom.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag22.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag22);
            return true;
        }
        _activeTag=__tag22.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag22);
        __tag22.release();
        return false;
    }

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(null);
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Period.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag23.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag23);
            return true;
        }
        _activeTag=__tag23.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag23);
        __tag23.release();
        return false;
    }

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(null);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag24.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag24);
            return true;
        }
        _activeTag=__tag24.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag24);
        __tag24.release();
        return false;
    }

    private boolean _jsp__tag25(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag25 = null ;
        int __result__tag25 = 0 ;

        if (__tag25 == null ){
            __tag25 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
        }
        __tag25.setPageContext(pageContext);
        __tag25.setParent(null);
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.RevokeMaintenance.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag25;
        __result__tag25 = __tag25.doStartTag();

        if (__result__tag25!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag25== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag25.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag25);
            return true;
        }
        _activeTag=__tag25.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag25);
        __tag25.release();
        return false;
    }

    private boolean _jsp__tag26(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag26 = null ;
        int __result__tag26 = 0 ;

        if (__tag26 == null ){
            __tag26 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
        }
        __tag26.setPageContext(pageContext);
        __tag26.setParent(null);
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.UpdateAmbulanceStatus.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag26;
        __result__tag26 = __tag26.doStartTag();

        if (__result__tag26!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag26== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag26.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag26);
            return true;
        }
        _activeTag=__tag26.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag26);
        __tag26.release();
        return false;
    }

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(null);
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.currentlocation.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag27;
        __result__tag27 = __tag27.doStartTag();

        if (__result__tag27!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag27== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag27.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag27);
            return true;
        }
        _activeTag=__tag27.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag27);
        __tag27.release();
        return false;
    }

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(null);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag28.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag28);
            return true;
        }
        _activeTag=__tag28.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag28);
        __tag28.release();
        return false;
    }

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(null);
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DistanceCovered.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag29.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag29);
            return true;
        }
        _activeTag=__tag29.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag29);
        __tag29.release();
        return false;
    }

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(null);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartTime.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag30.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag30);
            return true;
        }
        _activeTag=__tag30.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag30);
        __tag30.release();
        return false;
    }

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EndTime.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.StartingMeter.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.Endmeter.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestDetails.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.NatureOfCall.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PickupLocation.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.external.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Hospital.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Address.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PickupTime.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.Immediate.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PickupTime.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DroppingLocation.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.external.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Hospital.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Address.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.Escort.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.AttendedBy.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }

    private boolean _jsp__tag53(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag53 = null ;
        int __result__tag53 = 0 ;

        if (__tag53 == null ){
            __tag53 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag53);
        }
        __tag53.setPageContext(pageContext);
        __tag53.setParent(null);
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.RequesterName.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag53;
        __result__tag53 = __tag53.doStartTag();

        if (__result__tag53!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag53== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag53.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag53);
            return true;
        }
        _activeTag=__tag53.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag53);
        __tag53.release();
        return false;
    }

    private boolean _jsp__tag54(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag54 = null ;
        int __result__tag54 = 0 ;

        if (__tag54 == null ){
            __tag54 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag54);
        }
        __tag54.setPageContext(pageContext);
        __tag54.setParent(null);
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.contact.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag54;
        __result__tag54 = __tag54.doStartTag();

        if (__result__tag54!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag54== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag54.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag54);
            return true;
        }
        _activeTag=__tag54.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag54);
        __tag54.release();
        return false;
    }

    private boolean _jsp__tag55(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag55 = null ;
        int __result__tag55 = 0 ;

        if (__tag55 == null ){
            __tag55 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag55);
        }
        __tag55.setPageContext(pageContext);
        __tag55.setParent(null);
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag55;
        __result__tag55 = __tag55.doStartTag();

        if (__result__tag55!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag55== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag55.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag55);
            return true;
        }
        _activeTag=__tag55.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag55);
        __tag55.release();
        return false;
    }

    private boolean _jsp__tag56(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag56 = null ;
        int __result__tag56 = 0 ;

        if (__tag56 == null ){
            __tag56 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag56);
        }
        __tag56.setPageContext(pageContext);
        __tag56.setParent(null);
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.GoogleMap.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag56;
        __result__tag56 = __tag56.doStartTag();

        if (__result__tag56!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag56== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag56.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag56);
            return true;
        }
        _activeTag=__tag56.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag56);
        __tag56.release();
        return false;
    }

    private boolean _jsp__tag57(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag57 = null ;
        int __result__tag57 = 0 ;

        if (__tag57 == null ){
            __tag57 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag57);
        }
        __tag57.setPageContext(pageContext);
        __tag57.setParent(null);
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Ambulance.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag57;
        __result__tag57 = __tag57.doStartTag();

        if (__result__tag57!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag57== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag57.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag57);
            return true;
        }
        _activeTag=__tag57.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag57);
        __tag57.release();
        return false;
    }

    private boolean _jsp__tag58(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag58 = null ;
        int __result__tag58 = 0 ;

        if (__tag58 == null ){
            __tag58 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag58);
        }
        __tag58.setPageContext(pageContext);
        __tag58.setParent(null);
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.Dispatched.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag58;
        __result__tag58 = __tag58.doStartTag();

        if (__result__tag58!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag58== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag58.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag58);
            return true;
        }
        _activeTag=__tag58.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag58);
        __tag58.release();
        return false;
    }

    private boolean _jsp__tag59(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag59 = null ;
        int __result__tag59 = 0 ;

        if (__tag59 == null ){
            __tag59 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag59);
        }
        __tag59.setPageContext(pageContext);
        __tag59.setParent(null);
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag59;
        __result__tag59 = __tag59.doStartTag();

        if (__result__tag59!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag59== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag59.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag59);
            return true;
        }
        _activeTag=__tag59.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag59);
        __tag59.release();
        return false;
    }

    private boolean _jsp__tag60(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag60 = null ;
        int __result__tag60 = 0 ;

        if (__tag60 == null ){
            __tag60 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag60);
        }
        __tag60.setPageContext(pageContext);
        __tag60.setParent(null);
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag60;
        __result__tag60 = __tag60.doStartTag();

        if (__result__tag60!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag60== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag60.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag60);
            return true;
        }
        _activeTag=__tag60.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag60);
        __tag60.release();
        return false;
    }

    private boolean _jsp__tag61(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag61 = null ;
        int __result__tag61 = 0 ;

        if (__tag61 == null ){
            __tag61 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag61);
        }
        __tag61.setPageContext(pageContext);
        __tag61.setParent(null);
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.AmbulanceServiceType.label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag61;
        __result__tag61 = __tag61.doStartTag();

        if (__result__tag61!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag61== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag61.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag61);
            return true;
        }
        _activeTag=__tag61.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag61);
        __tag61.release();
        return false;
    }

    private boolean _jsp__tag62(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag62 = null ;
        int __result__tag62 = 0 ;

        if (__tag62 == null ){
            __tag62 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag62);
        }
        __tag62.setPageContext(pageContext);
        __tag62.setParent(null);
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.OdometerStart.label", java.lang.String .class,"key"));
        __tag62.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag62;
        __result__tag62 = __tag62.doStartTag();

        if (__result__tag62!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag62== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag62.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag62);
            return true;
        }
        _activeTag=__tag62.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag62);
        __tag62.release();
        return false;
    }

    private boolean _jsp__tag63(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag63 = null ;
        int __result__tag63 = 0 ;

        if (__tag63 == null ){
            __tag63 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag63);
        }
        __tag63.setPageContext(pageContext);
        __tag63.setParent(null);
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.ExpectedDistance.label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag63;
        __result__tag63 = __tag63.doStartTag();

        if (__result__tag63!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag63== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag63.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag63);
            return true;
        }
        _activeTag=__tag63.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag63);
        __tag63.release();
        return false;
    }

    private boolean _jsp__tag64(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag64 = null ;
        int __result__tag64 = 0 ;

        if (__tag64 == null ){
            __tag64 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag64);
        }
        __tag64.setPageContext(pageContext);
        __tag64.setParent(null);
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.StartDateTime.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag64;
        __result__tag64 = __tag64.doStartTag();

        if (__result__tag64!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag64== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag64.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag64);
            return true;
        }
        _activeTag=__tag64.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag64);
        __tag64.release();
        return false;
    }

    private boolean _jsp__tag65(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag65 = null ;
        int __result__tag65 = 0 ;

        if (__tag65 == null ){
            __tag65 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag65);
        }
        __tag65.setPageContext(pageContext);
        __tag65.setParent(null);
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.StartDateTime.label", java.lang.String .class,"key"));
        __tag65.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag65;
        __result__tag65 = __tag65.doStartTag();

        if (__result__tag65!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag65== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag65.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag65);
            return true;
        }
        _activeTag=__tag65.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag65);
        __tag65.release();
        return false;
    }

    private boolean _jsp__tag66(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag66 = null ;
        int __result__tag66 = 0 ;

        if (__tag66 == null ){
            __tag66 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag66);
        }
        __tag66.setPageContext(pageContext);
        __tag66.setParent(null);
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DistanceCovered.label", java.lang.String .class,"key"));
        __tag66.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag66;
        __result__tag66 = __tag66.doStartTag();

        if (__result__tag66!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag66== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag66.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag66);
            return true;
        }
        _activeTag=__tag66.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag66);
        __tag66.release();
        return false;
    }

    private boolean _jsp__tag67(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag67 = null ;
        int __result__tag67 = 0 ;

        if (__tag67 == null ){
            __tag67 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag67);
        }
        __tag67.setPageContext(pageContext);
        __tag67.setParent(null);
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.OdometerEnd.label", java.lang.String .class,"key"));
        __tag67.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag67;
        __result__tag67 = __tag67.doStartTag();

        if (__result__tag67!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag67== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag67.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag67);
            return true;
        }
        _activeTag=__tag67.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag67);
        __tag67.release();
        return false;
    }

    private boolean _jsp__tag68(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag68 = null ;
        int __result__tag68 = 0 ;

        if (__tag68 == null ){
            __tag68 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag68);
        }
        __tag68.setPageContext(pageContext);
        __tag68.setParent(null);
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EndDateTime.label", java.lang.String .class,"key"));
        __tag68.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag68;
        __result__tag68 = __tag68.doStartTag();

        if (__result__tag68!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag68== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag68.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag68);
            return true;
        }
        _activeTag=__tag68.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag68);
        __tag68.release();
        return false;
    }

    private boolean _jsp__tag69(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag69 = null ;
        int __result__tag69 = 0 ;

        if (__tag69 == null ){
            __tag69 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag69);
        }
        __tag69.setPageContext(pageContext);
        __tag69.setParent(null);
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DispatchRemarks.label", java.lang.String .class,"key"));
        __tag69.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag69;
        __result__tag69 = __tag69.doStartTag();

        if (__result__tag69!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag69== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag69.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag69);
            return true;
        }
        _activeTag=__tag69.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag69);
        __tag69.release();
        return false;
    }

    private boolean _jsp__tag70(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag70 = null ;
        int __result__tag70 = 0 ;

        if (__tag70 == null ){
            __tag70 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag70);
        }
        __tag70.setPageContext(pageContext);
        __tag70.setParent(null);
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resource.label", java.lang.String .class,"key"));
        __tag70.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag70;
        __result__tag70 = __tag70.doStartTag();

        if (__result__tag70!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag70== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag70.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag70);
            return true;
        }
        _activeTag=__tag70.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag70);
        __tag70.release();
        return false;
    }

    private boolean _jsp__tag71(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag71 = null ;
        int __result__tag71 = 0 ;

        if (__tag71 == null ){
            __tag71 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag71);
        }
        __tag71.setPageContext(pageContext);
        __tag71.setParent(null);
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.Choosewhichcolumnsyouwouldliketosee.label", java.lang.String .class,"key"));
        __tag71.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag71;
        __result__tag71 = __tag71.doStartTag();

        if (__result__tag71!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag71== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag71.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag71);
            return true;
        }
        _activeTag=__tag71.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag71);
        __tag71.release();
        return false;
    }

    private boolean _jsp__tag72(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag72 = null ;
        int __result__tag72 = 0 ;

        if (__tag72 == null ){
            __tag72 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag72);
        }
        __tag72.setPageContext(pageContext);
        __tag72.setParent(null);
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.CustomizedPositionforGridtable.label", java.lang.String .class,"key"));
        __tag72.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag72;
        __result__tag72 = __tag72.doStartTag();

        if (__result__tag72!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag72== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag72.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag72);
            return true;
        }
        _activeTag=__tag72.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag72);
        __tag72.release();
        return false;
    }

    private boolean _jsp__tag73(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag73 = null ;
        int __result__tag73 = 0 ;

        if (__tag73 == null ){
            __tag73 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag73);
        }
        __tag73.setPageContext(pageContext);
        __tag73.setParent(null);
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
        __tag73.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag73;
        __result__tag73 = __tag73.doStartTag();

        if (__result__tag73!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag73== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag73.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag73);
            return true;
        }
        _activeTag=__tag73.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag73);
        __tag73.release();
        return false;
    }

    private boolean _jsp__tag74(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag74 = null ;
        int __result__tag74 = 0 ;

        if (__tag74 == null ){
            __tag74 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag74);
        }
        __tag74.setPageContext(pageContext);
        __tag74.setParent(null);
        __tag74.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
        __tag74.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag74;
        __result__tag74 = __tag74.doStartTag();

        if (__result__tag74!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag74== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag74.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag74);
            return true;
        }
        _activeTag=__tag74.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag74);
        __tag74.release();
        return false;
    }

    private boolean _jsp__tag75(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag75 = null ;
        int __result__tag75 = 0 ;

        if (__tag75 == null ){
            __tag75 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag75);
        }
        __tag75.setPageContext(pageContext);
        __tag75.setParent(null);
        __tag75.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Default.label", java.lang.String .class,"key"));
        __tag75.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag75;
        __result__tag75 = __tag75.doStartTag();

        if (__result__tag75!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag75== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag75.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag75);
            return true;
        }
        _activeTag=__tag75.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag75);
        __tag75.release();
        return false;
    }
}
