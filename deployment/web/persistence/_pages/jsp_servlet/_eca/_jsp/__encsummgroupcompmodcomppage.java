package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.*;
import eCA.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __encsummgroupcompmodcomppage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/EncSummGroupCompModCompPage.jsp", 1709115853044L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\nCreated By: D. Sethuraman\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/EncSummGroupComp.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\t\n\t\t\tvar fields = 0;\n\t        function cancelParent() {\t        \t\n\t        \twindow.close();\t        \t\n\t        }\t \n\t        function saveComponents()\n\t        {\t        \t\n\t        \tvar tempValue = 0;\n\t        \tvar tableValue = \"\";\n\t        \tvar ColumnValue = \"\";\n\t        \tvar ColumnLabel = \"\";\n\t        \tvar LineChartValue = \"\";\n\t        \tvar colno = 0;\n\t        \t\n\t        \tvar tableColumnCount = 0;\n\t        \t\n\t        \tvar esXaxisLabel = \"\";\n\t        \tvar esXaxisDatatype = \"\";\n\t        \tvar esYaxisLabel = \"\";\n\t        \tvar esYaxisDatatype = \"\";\t\n\t        \t\n\t        \tvar tableTypeValue = \"\";\n\t        \tvar ColumnTypeValue = \"\";\n\t        \tvar ColumnTypeLabel = \"\";\n\t        \t\n\t        \ttempValue = document.getElementById(\"es_comp_template\").value;\n\t        \t\n\t        \t//document.getElementById(\"es_table_details\").value = \"\";\n\t        \t//document.getElementById(\"es_LineChart_details\").value = \"\";\n\t        \t\n\t        \tfields = 0;\t        \t\n\t        \t\n\t        \tif (tempValue == \'2\')\n\t        \t{\n\t        \t\tColumnValue = \"\";\n\t        \t\tcolno = 0;\n\t        \t\ttableColumnCount = document.getElementById(\"es_comp_colcount\").value;\n\t        \t\tif (tableColumnCount > 5){\t\t\n\t\t        \t\talert(\"Table column cannot exceed 5. \");\n\t\t        \t\tdocument.getElementById(\"es_comp_colcount\").focus();\n\t\t        \t\treturn false;\t\t\n\t\t        \t}\n\t        \t\tif (tableColumnCount>0)\n\t        \t\t{\n\t        \t\t\ttableValue = \"<Column>\";\n\t        \t\t\twhile (fields<tableColumnCount)\t\n\t\t\t\t\t\t{\n\t        \t\t\t\tcolno = fields+1;\n\t        \t\t\t\tColumnValue = \"\";\n\t        \t\t\t\tColumnValue = document.getElementById(\"column\"+fields).value;\n\t        \t\t\t\tColumnLabel = \"<ColumnName\"+colno+\">\" +ColumnValue+ \"</ColumnName\"+colno+\">\";\t        \t\t\t\t\n\t        \t\t\t\ttableValue = tableValue + ColumnLabel;\n\t        \t\t\t\tfields++;\n\t\t\t\t\t\t}\n\t        \t\t\ttableValue = tableValue + \"</Column>\"; \n\t        \t\t\t\n\t        \t\t\tfields = 0;\t\n\t        \t\t\t\n\t        \t\t\ttableTypeValue = \"<ColumnType>\";\n\t        \t\t\twhile (fields<tableColumnCount)\t\n\t\t\t\t\t\t{\n\t        \t\t\t\tcolno = fields+1;\n\t        \t\t\t\tColumnTypeValue = \"\";\n\t        \t\t\t\tColumnTypeValue = document.getElementById(\"columnType\"+fields).value;\n\t        \t\t\t\tColumnTypeLabel = \"<ColumnType\"+colno+\">\" +ColumnTypeValue+ \"</ColumnType\"+colno+\">\";\t        \t\t\t\t\n\t        \t\t\t\ttableTypeValue = tableTypeValue + ColumnTypeLabel;\n\t        \t\t\t\tfields++;\n\t\t\t\t\t\t}\n\t        \t\t\ttableTypeValue = tableTypeValue + \"</ColumnType>\"; \n\t        \t\t\t\n\t        \t\t}\n\t        \t}\n\t        \telse if (tempValue == \'4\')\n\t        \t{\n\t        \t\tesXaxisLabel = document.getElementById(\"es_xaxis_label\").value;\n\t        \t\tesXaxisLabel = esXaxisLabel.replace(/^\\s+|\\s+$/g,\'\');\n\t        \t\tesXaxisDatatype = document.getElementById(\"es_xaxis_datatype\").value;\n\t        \t\t\n\t        \t\tesYaxisLabel = document.getElementById(\"es_yaxis_label\").value;\t \n\t        \t\tesYaxisLabel = esYaxisLabel.replace(/^\\s+|\\s+$/g,\'\');\n\t        \t\tesYaxisDatatype = document.getElementById(\"es_yaxis_datatype\").value;\n\t        \t\t\n\t        \t\tif (esXaxisDatatype == \'\')\n\t        \t\t\tesXaxisDatatype = \"D\";\n\t        \t\t\n\t        \t\tLineChartValue = \"<ValueRange dataPlot=\'3\' xAxisLabel=\'\"+esXaxisLabel+\"\' xDataType=\'\"+esXaxisDatatype+\"\' yAxisLabel=\'\"+esYaxisLabel+\"\'  yDataType=\'\"+esYaxisDatatype+\"\'>\";      \t\t\n\t        \t}\n\t        \telse\n\t        \t{\n\t        \t\ttableValue = \"\";\n\t\t        \tLineChartValue = \"\";\n\t        \t}\n\t        \t\n\t        \tdocument.getElementById(\"es_table_details\").value  = tableValue;\n\t        \tdocument.getElementById(\"es_columnType_details\").value  = tableTypeValue;\n\t        \tdocument.getElementById(\"es_LineChart_details\").value  = LineChartValue;\t        \t\n\t        \t\n\t        \t//window.close();\n\t        \tdocument.encSummCompModForm.action=\'../../servlet/eCA.EncSummGroupCompServlet\';\n\t        \tdocument.encSummCompModForm.target=\'messageFrame\';\n\t        \tdocument.encSummCompModForm.method=\'post\';\n\t        \tdocument.encSummCompModForm.submit();\t\n\t        \t\n\t        }\t        \n\t        \n\t        function addInput(obj) \n\t        {\n\t        \tvar colTypeName = \"\";\n\t        \tvar colName = \"\";\n\n\t        \tvar colValue = 0;\t        \t\n\t        \tcolValue = obj;\t   \n\t        \t\n\t        \tif (colValue > 5){\t\t\n\t        \t\talert(\"Table column cannot exceed 5. \");\n\t        \t\tdocument.getElementById(\"es_comp_colcount\").focus();\n\t        \t\treturn false;\t\t\n\t        \t}\n\t        \t\n\t\t\t\tif ( colValue > 0) {\n\t\t\t\t\twhile (fields<colValue)\t\n\t\t\t\t\t{\n\t\t\t\t\t\tvar newRow = document.all(\"columnTable\").insertRow();\t\t\t\t    \n\t\t\t\t\t    var colno = fields+1;\n\t\t\t\t\t    \n\t\t\t\t\t    var oCell = newRow.insertCell();\n\t\t\t\t\t    oCell.innerHTML = \" Column \"+colno;\n\t\t\t\t\t    oCell.className = \"label\"; \n\t\t\t\t\t    oCell.width = \"100px\"; \n\t\t\t\t\t    \n\t\t\t\t\t    colTypeName = \"columnType\"+fields;    \n\t\t\t\t\t    colName = \"column\"+fields;\t\t\t\t\t    \n\t\t\t\t\t    \n\t\t\t\t\t    var select = document.createElement(\"select\");   \n\t\t\t\t\t    select.setAttribute(\"name\", colTypeName);   \n\t\t\t\t\t    select.setAttribute(\"id\", colTypeName); \n\t\t\t\t\t    select.setAttribute(\"onchange\", function() {selectOptionChange(this)}); \n\t\t\t\t\t    //select.onchange = function() {selectOptionChange(this)};\n\t\t\t\t\t    \n\t\t\t\t\t    var option;  \n\t\t\t\t\t    option = document.createElement(\"option\");  \n\t\t\t\t\t    option.setAttribute(\"value\", \"\");  \n\t\t\t\t\t    option.innerHTML = \"Select\";  \n\t\t\t\t\t    select.appendChild(option);\n\t\t\t\t\t    \n\t\t\t\t\t    option = document.createElement(\"option\");  \n\t\t\t\t\t    option.setAttribute(\"value\", \"P\");  \n\t\t\t\t\t    option.innerHTML = \"Parameter\";  \n\t\t\t\t\t    select.appendChild(option);\n\n\t\t\t\t\t    option = document.createElement(\"option\");  \n\t\t\t\t\t    option.setAttribute(\"value\", \"U\");  \n\t\t\t\t\t    option.innerHTML = \"Units\";  \n\t\t\t\t\t    select.appendChild(option);\n\n\t\t\t\t\t    option = document.createElement(\"option\");  \n\t\t\t\t\t    option.setAttribute(\"value\", \"V\");  \n\t\t\t\t\t    option.innerHTML = \"Values\";  \n\t\t\t\t\t    select.appendChild(option);\n\n\t\t\t\t\t    option = document.createElement(\"option\");  \n\t\t\t\t\t    option.setAttribute(\"value\", \"Y\");  \n\t\t\t\t\t    option.innerHTML = \"Your value is \";  \n\t\t\t\t\t    select.appendChild(option);\n\n\t\t\t\t\t    option = document.createElement(\"option\");  \n\t\t\t\t\t    option.setAttribute(\"value\", \"R\");  \n\t\t\t\t\t    option.innerHTML = \"Reference\";  \n\t\t\t\t\t    select.appendChild(option);\n\t\t\t\t\t    \n\t\t\t\t\t    oCell = newRow.insertCell();\n\t\t\t\t\t    oCell.appendChild(select);\t\n\t\t\t\t\t    oCell.width = \"100px\";\n\t\t\t\t\t    \n\t\t\t\t\t    oCell = newRow.insertCell();\n\t\t\t\t\t    oCell.innerHTML = \'<input type=\"text\" name=\"column\'+fields+\'\" id=\"column\'+fields+\'\"  id=\"column\'+fields+\'\">\';\t\n\t\t\t\t\t    oCell.width = \"100px\";\n\t\t\t\t\t    fields++;\n\t\t\t\t\t}\t\t\t\t    \n\t\t\t\t   \t\t\t\t\n\t\t\t\t}\n\t        }\n\t        \n\t        function selectOptionChange(obj) \n\t        {\t        \t\n\t        \tvar colCount = 0;\n\t        \tvar colName = \"column\";\n\t    \t\tvar colTypeName = \"columnType\";  \t\n\t    \t\tvar objName = obj.name;\n\t    \t\tvar colTextName = \"\";\n\t    \t\t\n\t    \t\tcolCount = objName.substring(objName.length,objName.length-1);\t    \t\t\n\t    \t\tcolTextName = colName + colCount;\n\t    \t\t\n\t        \tif (obj.value == \'P\')\n\t        \t{\n\t        \t\tdocument.getElementById(colTextName).value = \'Parameter\';\n\t        \t}\n\t        \telse if (obj.value == \'U\')\n\t        \t{\n\t        \t\tdocument.getElementById(colTextName).value = \'Units\';\n\t        \t}\n\t        \telse if (obj.value == \'V\')\n\t        \t{\n\t        \t\tdocument.getElementById(colTextName).value = \'Values\';\n\t        \t}\n\t        \telse if (obj.value == \'Y\')\n\t        \t{\n\t        \t\tdocument.getElementById(colTextName).value = \'Your Value is \';\n\t        \t}\n\t        \telse if (obj.value == \'R\')\n\t        \t{\n\t        \t\tdocument.getElementById(colTextName).value = \'Reference\';\n\t        \t}\n\t        \t\n\t        }\n\n\t</script>\n</head>\n<body>\n\t<form name = \'encSummCompModForm\' >\n\t\t<div id=\"buttonDiv\" name=\"buttonDiv\" >\n\t\t\t<table class=\'grid\' cellpadding=\'3\' cellspacing=\'0\' border=\'1\' width=\'100%\'  align=\'center\'>\n\t\t\t\t<tr id=\'trcoll\'>\n\t\t\t\t\t<td class=\'columnHeader\' colspan=\'3\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\t\t\t\t\t\t\n\t\t\t\t\t<td class=\'columnHeader\' align=left colspan=\'1\'><input type=\'button\' name=\'saveBtn\' id=\'saveBtn\' class=\'button\' \n\t\t\t\t\t\t\t\t\t\t\tvalue = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'\n\t\t\t\t\t\t\t\t\t\t\tonclick=\'saveComponents()\'>\n\t\t\t\t\t</td>\t\t\t\t\t \t\t\t\t\t\n\t\t\t\t\t<td class=\'columnHeader\' align=left colspan=\'1\'><input type=\'button\' name=\'cancelBtn\' id=\'cancelBtn\' class=\'button\' \n\t\t\t\t\t\t\t\t\t\t\tvalue = \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'\n\t\t\t\t\t\t\t\t\t\t\tonclick=\'cancelParent()\'>\n\t\t\t\t\t</td>\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\t\n\t\t<div id=\"headerDiv\" name=\"headerDiv\" >\n\t\t\t<table width=\'100%\'  cellpadding=\'3\' cellspacing=0  align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=\"15%\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" </td>\n\t\t\t\t\t<td class=\'gridData\' width=\"15%\" >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\t\t\t\t\t\n\t\t\t\t\t<td class=\'label\' width=\"25%\" >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t<td class=\'gridData\' width=\"45%\" >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\t\t<div id=\"templateDiv\" name=\"templateDiv\" >\n\t\t\t<table width=\'100%\'  cellpadding=\'3\' cellspacing=0  align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="><select name=\'es_comp_template\' id=\'es_comp_template\'  id=\'es_comp_template\' onChange=\'changeTemplate(this.value)\'>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<option value=\"\">-----";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="-----</option>\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t<script>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tvar tempObjName = \'es_comp_template\';\t\n\t\t\t\t\t\tvar compTempValue = ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =";\n\t\t\t\t\t\tif (\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' > 0 )\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar selTempObj = document.getElementById(tempObjName);\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tfor(var i=0;i<selTempObj.options.length;i++){\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t            if (selTempObj.options[i].value == \'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\') {\n\t\t\t\t\t            \tselTempObj.selectedIndex = i;\n\t\t\t\t\t                break;\n\t\t\t\t\t            }\n\t\t\t\t\t        }\n\t\t\t\t\t\t}\t\t\t\t\t\t\n\t\t\t\t\t</script>\n\t\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\t\t<div id=\"tableDiv\" name=\"tableDiv\" style=\"display:none;\">\n\t\t\t<table class=\'grid\' cellpadding=\'3\' cellspacing=\'0\' border=\'1\' width=\'100%\'  align=\'center\'>\n\t\t\t\t<tr id=\'trcoll\'>\n\t\t\t\t\t<td class=\'columnHeader\' colspan=\'5\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table width=\'100%\'  cellpadding=\'3\' cellspacing=0  border=\'0\'  align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" align=\'center\'> <input type=\'text\' name=\'es_comp_colcount\' id=\'es_comp_colcount\'  id=\'es_comp_colcount\' size=2 value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" onBlur=\'addInput(this.value)\'> </td>\t\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table width=\'100%\'  cellpadding=\'3\' cellspacing=0  align=\'center\' id=\'columnTable\'>\t\n\t\t\t\t<tr id=\'trcoll\'>\n\t\t\t\t\t<td class=\'columnHeader\' colspan=\'5\'>Column Header Labels</td>\t\t\t\t\t\n\t\t\t\t</tr>\t\n\t\t\t\t<tr id=\'trcoll\'>\n\t\t\t\t\t<td class=\'columnHeader\' >Column No</td>\n\t\t\t\t\t<td class=\'columnHeader\' >Column Type</td>\n\t\t\t\t\t<td class=\'columnHeader\' >Column Title</td>\t\t\t\t\t\n\t\t\t\t</tr>\t\t\t\n\t\t\t</table>\n\t\t</div>\n\t\t<div id=\"lineGraphDiv\" name=\"lineGraphDiv\" style=\"display:none;\">\n\t\t\t<table class=\'grid\' cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'100%\'  align=\'center\'>\n\t\t\t\t<tr id=\'trcoll\'>\n\t\t\t\t\t<td class=\'columnHeader\' colspan=\'5\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" align=\'center\' > <input type=\'text\' name=\'es_xaxis_label\' id=\'es_xaxis_label\'  id=\'es_xaxis_label\' size=20 value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" > </td>\t\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=\'40%\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'60%\' align=\'center\'> \n\t\t\t\t\t\t<select name=\'es_xaxis_datatype\' id=\'es_xaxis_datatype\' id=\'es_xaxis_datatype\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t \t\t\t\t\t</select> \n\t \t\t\t\t</td>\t\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" align=\'center\'> <input type=\'text\' name=\'es_yaxis_label\' id=\'es_yaxis_label\'  id=\'es_yaxis_label\' size=20 value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" > </td>\t\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" align=\'center\'>\n\t\t\t\t\t\t<select name=\'es_yaxis_datatype\' id=\'es_yaxis_datatype\' id=\'es_yaxis_datatype\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t \t\t\t\t\t</select> \n\t\t\t\t\t</td>\t\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t<input type=\"hidden\" name=\"es_group_flag\" id=\"es_group_flag\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t<input type=\"hidden\" name=\"es_group_type\" id=\"es_group_type\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t<input type=\"hidden\" name=\"es_group_code\" id=\"es_group_code\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t<input type=\"hidden\" name=\"es_comp_flag\" id=\"es_comp_flag\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t\t<input type=\"hidden\" name=\"es_comp_type\" id=\"es_comp_type\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t<input type=\"hidden\" name=\"es_comp_code\" id=\"es_comp_code\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t<input type=\"hidden\" name=\"es_table_details\" id=\"es_table_details\" value=\"\">\n\t\t<input type=\"hidden\" name=\"es_LineChart_details\" id=\"es_LineChart_details\" value=\"\">\n\t\t<input type=\"hidden\" name=\"es_columnType_details\" id=\"es_columnType_details\" value=\"\">\n\t</form>\n\t\t\t\t\t<script>\t\t\t\t\t\t\t\n\t\t\t\t\t\tvar compTempValue = ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =";\n\t\t\t\t\t\tvar compColCount = ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =";\n\t\t\t\t\t\tvar compDef = \'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\';\n\t\t\t\t\t\tvar compColumnType = \'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\';\n\t\t\t\t\t\tchangeTemplate(compTempValue);\n\t\t\t\t\t\taddInput(compColCount);\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\tif (compTempValue == \'2\' || compTempValue == \'4\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\treturnCompDef(compTempValue, compColCount, compDef, compColumnType);\n\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

			
			String sStyle =
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			
			String mode = "", groupFlag = "", groupType = "", groupCode = "", comp_flag = "", comp_type = "", comp_code = "", comp_desc = "", comp_temp_def = "", comp_column_type = "";
			
			String comp_col_count = "", comp_col_name = "";
			
			String es_xaxis_label = "", es_xaxis_datatype = "", es_yaxis_label = "", es_yaxis_datatype = "";
			
			String columnWidth1 = "40%"; 
			String columnWidth2 = "60%";
			
			int comp_temp_int = 0;
			
			EncSummGroup summGrpDetails = new EncSummGroup();			 	
			
			List<EncSummTemplateTypeBean> oTempTypeList = null;
			EncSummTemplateTypeBean sTempTypeBean = null;
			
			int ntypeListSize = 0;
			String oTempType = "";
			
			oTempTypeList = new ArrayList<EncSummTemplateTypeBean>();
			sTempTypeBean = new EncSummTemplateTypeBean();
			
			sTempTypeBean.setRequest(request);
			oTempTypeList = summGrpDetails.getTemplateType(sTempTypeBean);		
			
			ntypeListSize = oTempTypeList.size();
			if (ntypeListSize>0){
				for (int i=0;i<ntypeListSize;i++){
					sTempTypeBean = oTempTypeList.get(i);
					oTempType = oTempType + "<Option value="+sTempTypeBean.getsTemplateType()+">" +sTempTypeBean.getsTemplateDesc()+ "</option>";
				}
			}
			
			mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
			groupFlag = request.getParameter("groupFlag") == null ? "" : request.getParameter("groupFlag");
			groupType = request.getParameter("groupType") == null ? "" : request.getParameter("groupType");	
			groupCode = request.getParameter("groupCode") == null ? "" : request.getParameter("groupCode");	
			
			comp_flag = request.getParameter("compFlag") == null ? "" : request.getParameter("compFlag");
			comp_type = request.getParameter("compType") == null ? "" : request.getParameter("compType");	
			comp_code = request.getParameter("compId") == null ? "" : request.getParameter("compId");
			comp_desc = request.getParameter("compDesc") == null ? "" : request.getParameter("compDesc");
			comp_col_count = request.getParameter("compColumns") == null ? "" : request.getParameter("compColumns");
			comp_temp_def = request.getParameter("compTempDef") == null ? "" : request.getParameter("compTempDef");
			
			comp_temp_int = Integer.parseInt(request.getParameter("compTemplate"));
			
			comp_column_type = request.getParameter("compColumnType") == null ? "" : request.getParameter("compColumnType");
			
			String comptypecode[] = {"","D","E","N","I","T"};
			String comptypedesc[]={"&nbsp;------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" -------&nbsp;",
													com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels"), 
													com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels"), 
													com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DecimalNumeric.label","common_labels"), 
													com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.IntegerNumeric.label","common_labels"), 
													com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")};
			
			   String sel	= "";
			
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Save.label","common_labels")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(comp_code));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(columnWidth1 ));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(columnWidth2 ));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(oTempType));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(comp_temp_int));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(comp_temp_int));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(comp_temp_int));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(columnWidth1 ));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(columnWidth2 ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(comp_col_count));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(columnWidth1 ));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(columnWidth2 ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(es_xaxis_label));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
 
							for(int k=0;k<comptypecode.length;k++)
							{								
								out.println("<option value='"+comptypecode[k]+"' "+sel+">"+comptypedesc[k]);
							}
						
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(columnWidth1 ));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(columnWidth2 ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(es_yaxis_label));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(columnWidth1 ));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(columnWidth2 ));
            _bw.write(_wl_block34Bytes, _wl_block34);
 
							for(int k=0;k<comptypecode.length;k++)
							{								
								out.println("<option value='"+comptypecode[k]+"' "+sel+">"+comptypedesc[k]);
							}
						
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(groupFlag));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(groupType));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(groupCode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(comp_flag));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(comp_type));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(comp_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(comp_temp_int));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(comp_col_count));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(comp_temp_def));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(comp_column_type));
            _bw.write(_wl_block46Bytes, _wl_block46);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ComponentDefinition.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ModifyComponents.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ComponentCode.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ComponentDescription.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.TemplateType.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ColumnDetails.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ColumnNumbers.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.LineChartdetails.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.XAxisLabel.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.XAxisLabelDataType.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.YAxisLabel.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.YAxisLabelDataType.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
