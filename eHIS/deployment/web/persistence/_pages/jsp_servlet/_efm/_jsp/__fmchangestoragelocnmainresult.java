package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmchangestoragelocnmainresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMChangeStorageLocnMainResult.jsp", 1742884453385L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tDeveloped by \t:\tPrakash.S\n\tCreated on \t\t:\t10/06/2002\n\tModule\t\t\t:\tFM - Assign File Store Location\n\tFunction\t\t:\tThis function is used for Search Result.\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMChangeStorageLocn.js\'></script>\n</head>\n<body  onMouseDown=\'CodeArrest()\' onLoad=\'checkAll(parent.frames[1].document.getElementById(\'locn_code\'));\' onKeyDown = \'lockKey();\'>\n<!-- <body  onLoad=\'dispRecord(); loadCurrPage();\' onMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey();\'> -->\n<form name=\'FMChngStrLocnMainResultForm\' id=\'FMChngStrLocnMainResultForm\' action=\'../../eFM/jsp/FMChangeStorageLocnMainResult.jsp\' method=\'post\'>\n<P>\n<table align=\'right\'>\n<tr>\n<td>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<A HREF=\'javascript:submitPrevNext(\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\",\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\",\"Previous\",\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\");\' text-decoration=\'none\' >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</A>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\",\"next\",\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</A>\n\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n</td>\n</tr>\n</table>\n\t<br><br>\n</P>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n <script>\n\tvar msg= \"\";\n var row_count=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";   \n\t if(row_count==0)\n\t\t\t{\n   parent.frames[0].document.forms[0].status.value=\"true\";\n\t\t\t}\n\tmsg=getMessage(\'FILE_IS_LOST\',\'FM\');\n\tif(msg != \"\")\n\t\t{\n\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg+\"&err_value=0\";\n\t\t\t}\t\n\t</script>\n\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n    <script>\n\t parent.frames[0].document.forms[0].status.value=\"true\";\n\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\n\t</script>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t<script>\t\t\t\n\t\t\tvar destin= \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t\tvar msg= \"\";\n\t\t\tvar row_count=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\t\t\tmsg=getMessage(\'FILE_IN_TRANSIT_CANNOT_PROCEED\',\'FM\');\n\t\t\tvar msg1=\" \"+getLabel(\"Common.to.label\",\"common\") + \" \" + getLabel(\"Common.Location.label\",\"common\")+\"-\" + \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\t\tmsg=msg.replace(\'.\',msg1);\n\t\t\tif(msg != \"\")\n\t\t\t{\n\t\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg+\"&err_value=0\";\n\t\t\t}\t\t\t\n\t\t\n\t\t\n\t\t</script>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<script>\t\t\t\n\t\tvar fs_locn=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n       var row_count=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n          var destin= \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\";\n\t\t\tvar fileno = \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\n\t\t\tvar msg= \"\";\n\t\t\tvar curr_file_status=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\t\t\n\t\t\t if(fs_locn==\"P\")\n\t\t\t\t{ \n\t\t\t  \n\t\t\t   if(curr_file_status==\"E\" || curr_file_status==\"R\" )\n\t\t\t\t\t{\n\t\t\t    \t\n\t\t\t\t\t if(row_count==0)\n\t\t\t\t\t{\n                  parent.frames[0].document.forms[0].status.value=\"true\";\n\t\t\t\t\t}\n\t\t\t\t\tmsg=getMessage(\'FILE_IN_TRANSIT_CANNOT_PROCEED\',\'FM\');\n\t\t\t\t\tvar msg1=\" \"+getLabel(\"Common.to.label\",\"common\") + \" \" + getLabel(\"Common.Location.label\",\"common\")+\"-\" + \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"; \n\t\t\t      msg=msg.replace(\'.\',msg1);\t\n\t\t\t\t\t}else{\n\t\t\t         if(row_count==0)\n\t\t\t\t\t{\n                parent.frames[0].document.forms[0].status.value=\"true\";\n\t\t\t\t\t}\n\t\t\t\t\tif(fileno==\"undefined\" || fileno==\"\" )\n\t\t\t\t\t\t{\n                         msg=\"\";\n\t\t\t\t\t\t}else{\n\t\t\t\t\tmsg=getMessage(\'PERMANENT_F_SLOCN_CANNOT_CHANGE\',\'FM\');\n\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\t if(fs_locn==\"C\")\n\t\t        {\n\t\t\t\t\t\t\n\t\t\t\t\tif(curr_file_status==\"E\" || curr_file_status==\"R\" )\n\t\t\t\t\t{\n\t\t\t     \t\t\t\t\t\n\t\t\t\t\tparent.frames[0].document.forms[0].status.value=\"true\";\n\t\t\t\t\tmsg=getMessage(\'FILE_IN_TRANSIT_CANNOT_PROCEED\',\'FM\');\n\t\t\t\t\tvar msg1=\" \"+getLabel(\"Common.to.label\",\"common\") + \" \" + getLabel(\"Common.Location.label\",\"common\")+\"-\" + \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"; \n\t\t\t      msg=msg.replace(\'.\',msg1);\t\n\t\t\t\t\t}else{\n\n\t\t\t\tif(row_count==0)\n\t\t\t\t{\n\t\t\t\tparent.frames[0].document.forms[0].status.value=\"true\";\n\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\t\t\t\n\t\t\t}\n\t\t\t\t//parent.frames[1].document.location.href = \"../../eCommon/html/blank.html\"\t\t\n\t\t\n\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t//\tvar msg1=\" \"+getLabel(\"Common.to.label\",\"common\") + \" \" + getLabel(\"Common.Location.label\",\"common\")+\"-\" + \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\n\t\t//\tmsg=msg.replace(\'.\',msg1);\n\t\t\tif(msg != \"\")\n\t\t\t{\n\t\t\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg+\"&err_value=0\";\n\t\t\t}\t\t\t\n\t\t</script>\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n <script>\t\t\t\n\t\tvar fs_locn=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n \n          var destin= \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\t\t  var row_count =\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\";\n\t\t\t if(fs_locn==\"P\")\n\t\t\t\t{ \n\t\t\t   if(curr_file_status==\"E\" || curr_file_status==\"R\")\n\t\t\t\t\t{\n\t\t\t\t   \t\t\t\t\t\n\t\t\t\t\tmsg=getMessage(\'FILE_IN_TRANSIT_CANNOT_PROCEED\',\'FM\');\n\t\t\t\t\tvar msg1=\" \"+getLabel(\"Common.to.label\",\"common\") + \" \" + getLabel(\"Common.Location.label\",\"common\")+\"-\" + \"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"; \n\t\t\t        msg=msg.replace(\'.\',msg1);\t\n\t\t\t\t\t}\n\t\t\t\t\n\t\t\t\t  }\n\t\t\t\t if(fs_locn==\"C\")\n\t\t           {\n\t\t\t\tvar fileno=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"\n\t\t\t\t \n\t\t\t\t if(curr_file_status==\"E\" || curr_file_status==\"R\")\n\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\n\t\t\t\t\tmsg=getMessage(\'FILE_IN_TRANSIT_CANNOT_PROCEED\',\'FM\');\n\t\t\t\t\tvar msg1=\" \"+getLabel(\"Common.to.label\",\"common\") + \" \" + getLabel(\"Common.Location.label\",\"common\")+\"-\" + \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"; \n\t\t\t        msg=msg.replace(\'.\',msg1);\t\n\t\t\t\t\t}else{\n                   \n\t\t\t\t\t  var added_temp1=((added_file_vol.Keys()).toArray()).toString();\n\t\t\t\t\t     if(row_count==0)\n\t\t\t\t\t\t{\n                          parent.frames[0].document.forms[0].status.value=\"true\";\n\t\t\t\t\t\t}else{\n                         parent.frames[0].document.forms[0].status.value=\"remone\";\n\t\t\t\t\t\t parent.frames[0].document.forms[0].fileno.value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\";\n                         parent.frames[0].document.forms[0].volno.value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\";\n\t\t\t\t\t\t}\n\n\t\t\t\t\tif(fileno==\"undefined\" || fileno==\"\" )\n\t\t\t\t\t\t{\n                         msg=\"\";\n\t\t\t\t\t\t}else{\n\t\t\t\t\t msg=getMessage(\'CURRENT_FS_LOCN_CANNOT_CHANGE\',\'FM\');\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t    }\n\t\t\t\t\n\t\t\t\t//\tvar msg1=\" \"+getLabel(\"Common.to.label\",\"common\") + \" \" + getLabel(\"Common.Location.label\",\"common\")+\"-\" + \"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\";\n\t\t//\tmsg=msg.replace(\'.\',msg1);\n\t\t\tif(msg != \"\")\n\t\t\t{\n\t\t\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg+\"&err_value=0\";\n\t\t\t}\t\t\t\n\t\t</script>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n<script>\t\t\t\t\t\t\n\t\t\t\t\n\t\t\t\tparent.frames[0].document.forms[0].status.value=\"true\";\n\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\t\t\t\n\t\t\t\t//parent.frames[1].document.location.href = \"../../eCommon/html/blank.html\"\t\t\n\t\t     \n\t\t</script>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t<script>\t\t\t\n\t\t\tvar fs_locn=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\";\n            var destin= \"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\";\n\t\t\t var fileno= \"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\t\t\tvar msg= \"\";\n\t\t\t//\tvar msg1=\" \"+getLabel(\"Common.to.label\",\"common\") + \" \" + getLabel(\"Common.Location.label\",\"common\")+\"-\" + \"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\";\n\t\t//\tmsg=msg.replace(\'.\',msg1);\n\t\t\tif(fs_locn==\"C\")\n\t\t\t\t{ \n\t\tif(fileno==\"undefined\" || fileno==\"\" )\n\t\t\t\t\t\t{\n                         msg=\"\";\n\t\t\t\t\t\t}else{\n\t\t\t\t\t msg=getMessage(\'CURRENT_FS_LOCN_CANNOT_CHANGE\',\'FM\');\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\n\t\t\t\t}\n\t\t\n\t\t\tif(msg != \"\")\n\t\t\t{\n\t\t\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg+\"&err_value=0\";\n\t\t\t}\t\t\t\n\t\t</script>\n\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\";\n           var destin= \"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\";\n\t\t\tvar fileno= \"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\";\n\t\t\tvar msg= \"\";\n\t\t\tif(fs_locn==\"P\")\n\t\t\t\t{ \n\t\t      if(fileno==\"undefined\" || fileno==\"\")\n\t\t\t\t\t\t{\n                         msg=\"\";\n\t\t\t\t\t\t}else{\n\t\t\t\t\tmsg=getMessage(\'PERMANENT_F_SLOCN_CANNOT_CHANGE\',\'FM\');\n\t\t\t\t\t}\n\t\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\n\t\t\tif(msg != \"\")\n\t\t\t{\n\t\t\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg+\"&err_value=0\";\n\t\t\t}\t\t\t\n\t\t</script>\n\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n     <script>\t\t\n\n\tvar fs_locn=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\";\n\tvar row_count =\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\";\n\t var fileno  =\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\";\n\t if(fs_locn==\"C\")\n\t\t\t\t{ \n\t\t\t if(row_count==0)\n\t\t\t{\n              parent.frames[0].document.forms[0].status.value=\"true\";\n\t\t\t}\n\t\t\tif(fileno==\"undefined\" || fileno==\"\")\n\t\t\t\t\t\t{\n                         msg=\"\";\n\t\t\t\t\t\t}else{\n\t\t\t\t\tmsg=getMessage(\'CURRENT_FS_LOCN_CANNOT_CHANGE\',\'FM\');\n\t\t\t\t\t}\n\t\t\t\t\t\t\t\n\t\t\t}else{\n\t         if(row_count==0)\n\t\t\t{\n             parent.frames[0].document.forms[0].status.value=\"true\";\n\t\t   }\n\t\n\t           if(fileno==\"undefined\" || fileno==\"\")\n\t\t\t\t\t\t{\n                         msg=\"\";\n\t\t\t\t\t\t}else{\n\t\t\t\t\t msg=getMessage(\'PERMANENT_F_SLOCN_CANNOT_CHANGE\',\'FM\');\n\t\t\t\t\t}\n\t     \n\t}\n\t\tif(msg != \"\")\n\t\t\t{\n\t\t\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg+\"&err_value=0\";\n\t\t\t}\t\n\n</script>\t\n\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\t\t\n\t\t<script>\t\t\t\t\t\t\n\t\t\t\t\n\t\t\t\tparent.frames[0].document.forms[0].status.value=\"true\";\n\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\t\t\t\n\t\t\t\t//parent.frames[1].document.location.href = \"../../eCommon/html/blank.html\"\t\t\n\t\t        \n\t\t</script>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n     <script>\t\t\n   var fs_locn=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\";\n\t var fileno =\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\";\n\t if(fs_locn==\"C\")\n\t\t\t\t{ \n\t\t\t  if(row_count==0)\n\t\t\t\t\t{\n                parent.frames[0].document.forms[0].status.value=\"true\";\n\t\t\t\t\t}\n\t\t\tif(fileno==\"undefined\" || fileno==\"\")\n\t\t\t\t\t\t{\n                         msg=\"\";\n\t\t\t\t\t\t}else{\n\t\t\t\t\tmsg=getMessage(\'CURRENT_FS_LOCN_CANNOT_CHANGE\',\'FM\');\n\t\t\t\t\t}\n\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t}else{\n\t   if(row_count==0)\n\t\t{\n         parent.frames[0].document.forms[0].status.value=\"true\";\n\t\t}\n\t  \n\t\tif(fileno==\"undefined\" || fileno==\"\")\n\t\t\t\t\t\t{\n                         msg=\"\";\n\t\t\t\t\t\t}else{\n\t\t\t\t\tmsg=getMessage(\'PERMANENT_F_SLOCN_CANNOT_CHANGE\',\'FM\');\n\t\t\t\t\t}\n\t \n\t   \n\t}\n\t\tif(msg != \"\")\n\t\t\t{\n\t\t\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg+\"&err_value=0\";\n\t\t\t}\t\n\n</script>\t\n\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\t\t\n\t\t<script>\t\t\t\t\t\t\n\t\t\t\tparent.frames[0].document.forms[0].status.value=\"true\";\n\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\t\t\t\n\t\t\t\t//parent.frames[1].document.location.href = \"../../eCommon/html/blank.html\"\t\t\n\t\t        \n\t\t</script>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n<table cellpadding=\'0\' cellspacing=\'0\' border=\'1\' width=\'100%\'>\n\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t<th width=\'40%\' class=\'columnheader\' style=\"text-align:left;\">";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</th>\n\t\t<th width=\'6%\' class=\'columnheader\' style=\"text-align:left;\">";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</th>\n\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</th>\n\t\t<th width=\'8%\' class=\'columnheader\' style=\"text-align:left;\">";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t<th width=\'12%\' nowrap class=\'columnheader\' style=\"text-align:left;\">";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</th> \n\t<th width=\'12%\' nowrap class=\'columnheader\' style=\"text-align:left;\">";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</th>\n\t<th width=\'12%\' class=\'columnheader\' style=\"text-align:left;\">";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</th>\n\t<th width=\'6%\' class=\'columnheader\' style=\"text-align:left;\">";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="?</th>\n\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t<tr id=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' ><font size=\'1\'><b>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</b></font><br>&nbsp;&nbsp;<font size=\'1\'>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</font></td>\n\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' ><font \tsize=\'1\'><CENTER>\n\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' ><font size=\'1\'>&nbsp;<font size=\'1\'>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' ><font \tsize=\'1\'><CENTER>\n\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</CENTER></font></td>\n\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' ><font size=\'1\'>";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</font></td>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' align=\'center\'><select name=\'fs_locn_code";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' id=\'fs_locn_code";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =" onChange=\'checkAssign(this, \"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\");\' onFocus=\'assignOnFocus(this);\' ><option value=\'\'>-------";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="------</option>";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t</select><input type=\'hidden\' name=\'default_code";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\' id=\'default_code";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n\t\t\t<input type=\'hidden\' name=\'other_code";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\' id=\'other_code";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'file_no";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\' id=\'file_no";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'volume_no";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' id=\'volume_no";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'>\n\t\t\t</td>\n\t\t<td class=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\' align=\'center\'><input type=\'checkbox\'  name=\'associate_yn";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' id=\'associate_yn";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =" value=\'Y\' ";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =" onClick=\'CBValue(this,\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\");\'></td>\n\t\t</tr>\n\t<!--\t<script>\t\t\t\n\t\t\t\tvar val=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\';\n\t\t\teval(\'document.forms[0].fs_locn_code\'+val).value=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\';\n\t\teval(\'document.forms[0].associate_yn\'+val).checked=true;\n\t\t</script>\t -->\n\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t<script>\t\t\t\n\t\t\t\tparent.frames[0].document.forms[0].patient_id.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].pat_search.disabled=false;\tparent.frames[0].document.forms[0].terminal_digit.disabled=false;\n\t\t\t\tif(parent.frames[0].document.forms[0].file_no != null)\n\t\t\t\tparent.frames[0].document.forms[0].file_no.disabled=false;\n\t\t\t\tif(parent.frames[0].document.forms[0].file_type_code != null)\n\t\t\t\tparent.frames[0].document.forms[0].file_type_code.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].fs_locn_code.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].tdlocn.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].file_date.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].search_dtl.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].reset1.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].row_cnt.value=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\';\n\t\t\t</script>\t\t\n\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n</table>\n<input type=\'hidden\' name=\'row_count\' id=\'row_count\' value=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\'>\n<input type=\'hidden\' name=\'whereClause\' id=\'whereClause\' value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n<input type=\'hidden\' name=\'fm_disp\' id=\'fm_disp\' value=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\'>\n<input type=\'hidden\' name=\'to_disp\' id=\'to_disp\' value=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'>\n<input type=\'hidden\' name=\'from_1\' id=\'from_1\' value=\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\'>\n<input type=\'hidden\' name=\'to_1\' id=\'to_1\' value=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'>\n<input type=\'hidden\' name=\'fs_locn\' id=\'fs_locn\' value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\'>\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\'>\n<input type=\'hidden\' name=\'file_type_appl_yn\' id=\'file_type_appl_yn\' value=\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'>\n\n\n</form>\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script language=\"JavaScript\">\n\nparent.parent.frames[1].frames[0].document.forms[0].patient_id.value=\'\';\nparent.parent.frames[1].frames[0].document.getElementById(\'patientid1\').onblur();\nparent.parent.frames[1].frames[0].document.forms[0].patient_id.focus();\n</script>\n";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );
 int row_count=0; 
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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
            webbeans.eCommon.RecordSet recordSet= null;synchronized(session){
                recordSet=(webbeans.eCommon.RecordSet)pageContext.getAttribute("recordSet",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(recordSet==null){
                    recordSet=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("recordSet",recordSet,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	
	
	Connection con				=	null;
	java.sql.Statement stmt		=	null;
	java.sql.Statement stmt1	=	null;
	java.sql.Statement stmt2	=	null;
	java.sql.Statement stmt3	=	null;
	java.sql.Statement stmt4	=	null;
	java.sql.Statement stmt5	=	null;
	
	ResultSet rs				=	null;
	ResultSet rs1				=	null;
	ResultSet rs3				=	null;
    ResultSet rs4				=	null;
	ResultSet rs5				=	null;
	HashMap		htRecord		=	null;
    HashMap		keepRecord		=	null;
	HashMap		pat_file_code		=	null;
	pat_file_code	= new HashMap();
	keepRecord	= new HashMap();
	 HashMap		keepRecord1		=	null;
	keepRecord1= new HashMap();
	String file_no				= "", patient_id = "", patient_name = "";
	String str = "";
	String associate_yn_prop = ""; 
	String tblrow_id			= "", classValue="",fs_locn_code="",fs_desc="",fn_locn_code="";
	String locn_identity		= "", narration_code="", holder_name="",fs_locn_disp="",pat_details="";
//	String header				= "";
	String fs_locn="",mr_pat_fs_locn_desc="", curr_fs_locn_desc="";
	String other_locn_code		= "", curr_fs_locn_identity = "";
	String curr_holder_name		= "", curr_mr_locn_yn = "",mr_locn_yn = "";
	String file_type_code		= "", volume_no = "",file_type_desc = "";
	String dissable_attribute	= "";
	String doc_folder_id		=	"", doc_type_code = "";
	String associate_yn			= "N";
	String sql_query			= "";
	String file_vol_fslocn="";
	int l=0;
	String sql1					= "";
	String destination			= "";
	String curr_facility_id1			= "";	
	String curr_file_status			= "";
	String file_creat_fac_id ="";
	String  sqlString ="";
	String curr_fs_locn_ident="";
	String curr_facility_id="";
	String str1 ="";
	StringBuffer result_query   = null;
	StringBuffer result_query1   = null;
	String old_fs_locn_code ="";
	String   old_fs_desc ="";
	String vol_no_key ="";
	String vol_no="";
	String fslocn_type_old="";
	//String sel=""; checkstyle changes - 35865
	String selected="";
	try
	{
		con		=	ConnectionManager.getConnection(request);
		stmt	=	con.createStatement();
		stmt1	=	con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

		int start		= 0 ;
		int end			= 0 ;
		int fm_disp		= 0, to_disp = 0;

		
		
		String facility_id			=   (String)session.getValue("facility_id");
		String from					=	request.getParameter( "from_1" ) ;
		String to					=	request.getParameter( "to_1" ) ;
		String mode					=	request.getParameter("mode") ;
		String file_type_appl_yn	=	request.getParameter("file_type_appl_yn") ;
		String fileno	=	request.getParameter("file_no") ;
		String volumeno	=	request.getParameter("volume_no") ;
		String volume_no1	=	request.getParameter("volume_no") ;
		String  fs_req_location    =	request.getParameter("file_type_code") ;
		String   patient_id1       =	request.getParameter("patient_id") ;
		String storage_locn=	request.getParameter("storage_locn") ;  	
	    String terminaldigit =	request.getParameter("terminaldigit") ;  
	    String fr =	request.getParameter("fr") ;  
	   String added_temp_code =	request.getParameter("added_temp_code") ;  
	 	String filevol_concat=""; 
		if(added_temp_code == null || added_temp_code.equals("null")) added_temp_code = "";
	  if(fr == null || fr.equals("null")) fr = "";
	 if(terminaldigit == null || terminaldigit.equals("null")) terminaldigit = "";
	  if(storage_locn == null || storage_locn.equals("null")) storage_locn = "";
		if(patient_id1 == null || patient_id1.equals("null")) patient_id1 = "";
		if(fs_req_location == null || fs_req_location.equals("null")) fs_req_location = "";
		if(fileno == null || fileno.equals("null")) fileno = "";

		if(volumeno == null || volumeno.equals("null")) volumeno = "";		
		if(file_type_appl_yn == null || file_type_appl_yn.equals("null")) file_type_appl_yn = "";
		if(mode == null || mode.equals("null")) mode="";
       if(volume_no1 == null || volume_no1.equals("null")) volume_no1 = "";
	
		if(!added_temp_code.equals("") && !patient_id1.equals(""))
		{
       StringTokenizer  	strToken	=  new StringTokenizer (added_temp_code,",");
      while(strToken.hasMoreTokens())
		{
	     if(strToken.hasMoreTokens())
		 file_vol_fslocn=strToken.nextToken() ;
		   StringTokenizer  	strToken1	=  new StringTokenizer (file_vol_fslocn,"`");
		while(strToken1.hasMoreTokens())
		{
		if(strToken1.hasMoreTokens())
		 vol_no_key    =strToken1.nextToken() ;
		  if(strToken1.hasMoreTokens())
		 vol_no	=strToken1.nextToken();
	       pat_file_code.put(vol_no_key ,vol_no);
		}
	}
		
		}
		
		if(from == null) start = 1 ;
		else start = Integer.parseInt(from) ;

		if(to == null) end = 11 ;
		else end = Integer.parseInt( to ) ;

		stmt3	=	con.createStatement();
	 
	  if(!patient_id1.equals(""))
		{
	  sqlString = "SELECT FACILITY_ID  FROM mr_pat_file_index WHERE  patient_id ='"+patient_id1+"' and file_no='"+fileno+"' and doc_folder_id is null ";
	
	  stmt4	=	con.createStatement();
	 rs4	=	stmt4.executeQuery(sqlString);
	  while(rs4 != null && rs4.next())
			{
			file_creat_fac_id=rs4.getString("FACILITY_ID");
			}
	    if(stmt4!=null) stmt4.close();
    	if(rs4!=null)	rs4.close(); 
	}
  
  if(!file_creat_fac_id.equals(""))
		{ 
        sql1 = "SELECT A.DEST_LOCN_IDENTITY || FM_GET_DESC.FM_STORAGE_LOCN(A.FACILITY_ID, A.DEST_FS_LOCN_CODE,'"+localeName+"','2') Destination FROM  fm_Transit_File a WHERE a.Facility_Id = '"+file_creat_fac_id+"'   AND a.File_No = '"+fileno+"'  AND a.Volume_No ='"+volumeno+"' ";
		rs3 = stmt3.executeQuery(sql1);				
			while(rs3 != null && rs3.next())
		{
			destination				=	rs3.getString("destination");
			}
			if(destination == null || destination.equals("null")) destination="";
		}
	
	    if(!destination.equals(""))
		  {
			switch(destination.charAt(0))
			{
				case 'D' : destination = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

				case 'C' : destination = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

				case 'N' : destination = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

				case 'T' : destination = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

				case 'X' : destination = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

				case 'E' : destination = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

				case 'Y' : destination = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
		
			}
		}
			

			if(rs3 != null) rs3.close();
			if(stmt3 != null) stmt3.close();

			fs_locn	=	request.getParameter("fs_locn");
			if(fs_locn == null) fs_locn = "P";
		
		if(mode.equals(""))
		{	
			 result_query	= new StringBuffer();
			 result_query1	= new StringBuffer();

			str = request.getParameter("whereClause");
			str1 = request.getParameter("whereClause1");
			
			if(str == null) str = "";
			if(str1 == null) str1 = "";
			fs_locn	=	request.getParameter("fs_locn");
			if(fs_locn == null) fs_locn = "P";
			if(!(str.equals(""))) recordSet.clearAll();
			if(str == null)str="";
			else str = str.replace('~','%');
			
			if(!file_creat_fac_id.equals(""))
			{
			result_query1.append("SELECT curr_file_status,curr_facility_id FROM fm_curr_locn a WHERE facility_id='"+file_creat_fac_id+"' and file_no='"+fileno+"' and volume_no='"+volumeno+"'  ");
		
			rs = stmt.executeQuery(result_query1.toString());
			while(rs != null && rs.next()){
				curr_file_status					=	rs.getString("curr_file_status");				
			   curr_facility_id1                   =	rs.getString("curr_facility_id");		
			} if(rs != null) rs.close();			
	
			if(curr_facility_id1==null) curr_facility_id1="";
			}
			
			 if(!file_creat_fac_id.equals(curr_facility_id1))
			{
	      stmt5	=	con.createStatement();
		    String sqlqry=" SELECT curr_fs_locn_identity  FROM fm_curr_locn WHERE  patient_id ='"+patient_id1+"' and facility_id='"+file_creat_fac_id+"' and curr_file_status='I' and volume_no='"+volume_no1+"' ";
		rs5	=	stmt5.executeQuery(sqlqry);	
		 while(rs5 != null && rs5.next())
			{
			curr_fs_locn_ident = rs5.getString("curr_fs_locn_identity");
      	   		}
	 
	   
		 if(curr_fs_locn_ident==null)	 curr_fs_locn_ident="";		
		if(stmt5!=null) stmt5.close();
    	if(rs5!=null)	rs5.close(); 	

		} 
			
			if(fs_locn.equals("P"))
			{
			
				if(file_type_appl_yn.equals("N"))
				{
					result_query.append("SELECT file_no, patient_id, file_type_code,volume_no, doc_type_code,doc_folder_id, mr_pat_fs_locn_code fs_locn_code, curr_fs_locn_code other_locn, curr_facility_id, get_patient_line(patient_id,'"+localeName+"') pat_details, mr_pat_locn_short_desc mr_pat_fs_locn_desc, curr_fs_locn_short_desc curr_fs_locn_desc, curr_fs_locn_identity, curr_holder_name, mr_locn_yn FROM fm_curr_locn_vw a") ;
				  
						if(!file_creat_fac_id.equals(facility_id) && !file_creat_fac_id.equals(""))
					{
					 result_query.append(" WHERE a.curr_file_status NOT IN ('T','R','E','O','I','L') ");
					}else{
					 result_query.append(" WHERE a.curr_file_status NOT IN ('T','R','E','L') AND a.facility_id='"+facility_id+"' ");
						}
					//}
				/*	if(!fileno.equals("") && !fileno.equals("undefined"))
					{
					result_query.append(" and patient_id='"+patient_id1+"' ");
					} */
					if((curr_file_status.equals("T") || curr_file_status.equals("E") || curr_file_status.equals("R")) && !terminaldigit.equals(""))
					{
					 result_query.append(str1);
				}else{
                      result_query.append(str);
  				}
				}
				else if(file_type_appl_yn.equals("Y"))
				{
					result_query.append("select file_no, patient_id, file_type_code,file_type_desc,volume_no,doc_type_code,doc_folder_id, mr_pat_fs_locn_code fs_locn_code, curr_fs_locn_code other_locn, curr_facility_id, get_patient_line(patient_id,'"+localeName+"') pat_details, mr_pat_locn_short_desc mr_pat_fs_locn_desc, curr_fs_locn_short_desc curr_fs_locn_desc, curr_fs_locn_identity, curr_holder_name, mr_locn_yn from fm_curr_locn_vw a ");
					
									
					if(!file_creat_fac_id.equals(facility_id) && !file_creat_fac_id.equals(""))
					{
					 result_query.append(" WHERE a.curr_file_status NOT IN ('T','R','E','O','I','L') ");
					}else{
					 result_query.append(" WHERE a.curr_file_status NOT IN ('T','R','E','L') AND a.facility_id='"+facility_id+"' ");
					}
					//}
				//	}
				/*	if(!fileno.equals("") && !fileno.equals("undefined"))
					{
					result_query.append(" and patient_id='"+patient_id1+"' ");
					} */
							
					if((curr_file_status.equals("T") || curr_file_status.equals("E") || curr_file_status.equals("R")) && !terminaldigit.equals(""))
					{
					 result_query.append(str1);
				}else{
                      result_query.append(str);
  				}
				}
			}
			else
			{
				if(file_type_appl_yn.equals("N"))
				{
					result_query.append("select file_no, patient_id, file_type_code,volume_no,doc_type_code,doc_folder_id, curr_fs_locn_code fs_locn_code, curr_facility_id, mr_pat_fs_locn_code other_locn, get_patient_line(patient_id,'"+localeName+"') pat_details, mr_pat_locn_short_desc mr_pat_fs_locn_desc, curr_fs_locn_short_desc curr_fs_locn_desc, curr_fs_locn_identity, curr_holder_name, mr_locn_yn from fm_curr_locn_vw a ")  ;
					
					if(!file_creat_fac_id.equals(facility_id))
					{
					result_query.append(" WHERE     a.curr_file_status NOT IN ('T','R','E','L') and a.curr_facility_id='"+facility_id+"'");
									 
					}else{
					 
					 if(!file_creat_fac_id.equals(curr_facility_id1) && curr_fs_locn_ident.equals("D"))
	                {
					 result_query.append(" WHERE a.curr_file_status NOT IN ('T','R','E','I','L') and a.curr_facility_id='"+facility_id+"' ");
				 	}else if(!file_creat_fac_id.equals(curr_facility_id1)){

					 result_query.append(" WHERE a.curr_file_status NOT IN ('T','R','E','O','L') and a.curr_facility_id='"+facility_id+"' ");
					}else{
                     result_query.append(" WHERE a.curr_file_status NOT IN ('T','R','E','L') and a.curr_facility_id='"+facility_id+"' ");
					}
					}
				
					/*if(!fileno.equals("") && !fileno.equals("undefined"))
					{
					result_query.append(" and patient_id='"+patient_id1+"' ");
					} */
				
					if((curr_file_status.equals("T") || curr_file_status.equals("E") || curr_file_status.equals("R")) && !terminaldigit.equals(""))
					{
					 result_query.append(str1);
								
				}else{
                      if(!curr_facility_id1.equals(facility_id) && curr_file_status.equals("I") &&  !terminaldigit.equals(""))
					{
					result_query.append(str1);
					}else{
					
					  result_query.append(str);
					}
				}
				}
				else if(file_type_appl_yn.equals("Y"))
				{
					result_query.append("select file_no, patient_id, file_type_code,file_type_desc,volume_no,doc_type_code,doc_folder_id,curr_fs_locn_code fs_locn_code, curr_facility_id, mr_pat_fs_locn_code other_locn, get_patient_line(patient_id,'"+localeName+"') pat_details, mr_pat_locn_short_desc mr_pat_fs_locn_desc, curr_fs_locn_short_desc curr_fs_locn_desc, curr_fs_locn_identity, curr_holder_name, mr_locn_yn from fm_curr_locn_vw a  ");
					
					if(!file_creat_fac_id.equals(facility_id))
					{
					result_query.append(" WHERE a.curr_file_status NOT IN ('T','R','E','L') and a.curr_facility_id='"+facility_id+"'");
					}else{
					 
					 if(!file_creat_fac_id.equals(curr_facility_id1) && curr_fs_locn_ident.equals("D"))
	                {
					 result_query.append(" WHERE a.curr_file_status NOT IN ('T','R','E','I','L') and a.curr_facility_id='"+facility_id+"' ");
				 	}else if(!file_creat_fac_id.equals(curr_facility_id1)){
		
			 result_query.append("WHERE a.curr_file_status NOT IN ('T','R','E','O','L') and a.curr_facility_id='"+facility_id+"' ");
					}else{
       
			 result_query.append(" WHERE a.curr_file_status NOT IN ('T','R','E','L') and a.curr_facility_id='"+facility_id+"' ");
					}
					}
				
				/*	if(!fileno.equals("") && !fileno.equals("undefined"))
					{
					result_query.append(" and patient_id='"+patient_id1+"' ");
					} */
					if((curr_file_status.equals("T") || curr_file_status.equals("E") || curr_file_status.equals("R")) && !terminaldigit.equals(""))
					{
					 result_query.append(str1);
				     }else{
                       if(!curr_facility_id1.equals(facility_id) && curr_file_status.equals("I") &&  !terminaldigit.equals(""))
					{
					result_query.append(str1);
					}else{
					  result_query.append(str);
					}
					  result_query.append(str);
  				}
				}
			}
			
			result_query.append("order by file_no,volume_no");
				
			rs = stmt.executeQuery(result_query.toString());
						
			associate_yn = "N";
			
			while(rs != null && rs.next())
			{
				file_no					=	rs.getString("file_no");
				patient_id				=	rs.getString("patient_id");
				file_type_code			=	rs.getString("file_type_code");
				volume_no				=	rs.getString("volume_no");
				doc_folder_id			=   rs.getString("doc_folder_id");
				doc_type_code			=   rs.getString("doc_type_code");

				if(file_type_appl_yn.equals("Y"))
				{
					file_type_desc			=	rs.getString("file_type_desc");
					
					if(file_type_desc!=null)
					file_type_desc			=file_type_desc + " / ";
					else
					file_type_desc="";		
					if(file_type_desc == null || file_type_desc.equals("null"))
					{
						file_type_desc = "&nbsp;";
					}
				}				
				fs_locn_disp			=	rs.getString("fs_locn_code");
				curr_facility_id			=	rs.getString("curr_facility_id");
				pat_details				=	rs.getString("pat_details").substring(0,rs.getString("pat_details").length()-6);
				other_locn_code			=	rs.getString("other_locn");
				mr_pat_fs_locn_desc		=	rs.getString("mr_pat_fs_locn_desc");
				curr_fs_locn_desc		=	rs.getString("curr_fs_locn_desc");
				curr_fs_locn_identity	=	rs.getString("curr_fs_locn_identity");
				curr_holder_name		=	rs.getString("curr_holder_name");
				curr_mr_locn_yn			=	rs.getString("mr_locn_yn");

				if(file_no == null || file_no.equals("null"))file_no="";
				if(patient_id == null || patient_id.equals("null"))patient_id="";
				if(file_type_code == null || file_type_code.equals("null"))file_type_code="";
				if(volume_no == null || volume_no.equals("null"))volume_no="";
				if(patient_name == null || patient_name.equals("null"))patient_name="";
				if(fs_locn_disp == null || fs_locn_disp.equals("null"))fs_locn_disp="";
				if(curr_facility_id == null || curr_facility_id.equals("null"))curr_facility_id="";
				if(pat_details == null || pat_details.equals("null"))pat_details="";
				if(mr_pat_fs_locn_desc == null || mr_pat_fs_locn_desc.equals("null"))mr_pat_fs_locn_desc="";
				if(curr_fs_locn_desc == null || curr_fs_locn_desc.equals("null"))curr_fs_locn_desc="";
				if(other_locn_code == null || other_locn_code.equals("null"))other_locn_code="";
				if(doc_folder_id == null || doc_folder_id.equals("null"))doc_folder_id="";
				if(doc_type_code== null || doc_type_code.equals("null"))doc_type_code="";

				if(curr_fs_locn_identity == null || curr_fs_locn_identity.equals("null"))curr_fs_locn_identity="";
				if(curr_holder_name == null || curr_holder_name.equals("null"))curr_holder_name="";
				if(curr_mr_locn_yn == null || curr_mr_locn_yn.equals("null")) curr_mr_locn_yn="";

				htRecord	= new HashMap();

				htRecord.put("file_no"		        ,file_no);
				htRecord.put("patient_id"	        ,patient_id);
				htRecord.put("file_type_code"       ,file_type_code);
				htRecord.put("volume_no"		    ,volume_no);
				htRecord.put("doc_type_code"		,doc_type_code);
				htRecord.put("doc_folder_id"	    ,doc_folder_id);
				htRecord.put("patient_name"	        ,patient_name);				
				htRecord.put("associate_yn"	        ,associate_yn);
				htRecord.put("fn_locn_code"	        ,fn_locn_code);
				htRecord.put("locn_identity"	    ,locn_identity);
				htRecord.put("narration_code"	    ,narration_code);
				htRecord.put("holder_name"		    ,holder_name);
				htRecord.put("mr_locn_yn"		    ,mr_locn_yn);
				htRecord.put("fs_locn_disp"		    ,fs_locn_disp);
				htRecord.put("curr_facility_id"		,curr_facility_id);
				htRecord.put("pat_details"		    ,pat_details);
				htRecord.put("mr_pat_fs_locn_desc"  ,mr_pat_fs_locn_desc);
				htRecord.put("curr_fs_locn_desc"    ,curr_fs_locn_desc);
				htRecord.put("other_locn_code"      ,other_locn_code);
				htRecord.put("curr_fs_locn_identity",curr_fs_locn_identity);
				htRecord.put("curr_holder_name"     ,curr_holder_name);
				htRecord.put("curr_mr_locn_yn"      ,curr_mr_locn_yn);
				htRecord.put("file_type_desc"      ,file_type_desc);

				recordSet.putObject(htRecord);
			} if(rs != null) rs.close();

			if((result_query != null) && (result_query.length() > 0))
			{
				result_query.delete(0,result_query.length());
			}
			
			row_count	=	recordSet.getSize();
			fm_disp		=	0;
			to_disp		=	7;

			if(to_disp > (row_count-1)) to_disp = (row_count-1);
			
		
		}
		fm_disp =	start-1;
		to_disp	=	end-1;
		if(to_disp > (row_count-1)) to_disp=(row_count-1); 
		

            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
		
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block1Bytes, _wl_block1);



if (!(start <= 1))
	{
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(start-11));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(end-11));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(fs_locn));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
	}
	if ( !( (start+11) > row_count ))
	{
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf((start+11)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf((end+11)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(fs_locn));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
}

            _bw.write(_wl_block15Bytes, _wl_block15);
	
	
if(curr_file_status.equals("L"))
		{ 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block17Bytes, _wl_block17);
	}else{

if(row_count==0 && (fileno.equals("") || fileno.equals("undefined")))
	{ 
            _bw.write(_wl_block18Bytes, _wl_block18);
}else{
if((curr_file_status.equals("R") && file_creat_fac_id.equals(curr_facility_id1) ) || curr_file_status.equals("T"))
		{
	
	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(destination));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(destination));
            _bw.write(_wl_block22Bytes, _wl_block22);

	}else if(curr_file_status.equals("E") || curr_file_status.equals("O") || curr_file_status.equals("R"))	{

 if(!file_creat_fac_id.equals(facility_id))
			{
 
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(fs_locn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(destination));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(fileno));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(curr_file_status));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(destination));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(destination));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(destination));
            _bw.write(_wl_block31Bytes, _wl_block31);
   }else if(!file_creat_fac_id.equals(curr_facility_id1) && file_creat_fac_id.equals(facility_id)){
      
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(fs_locn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(destination));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(curr_file_status));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(destination));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(fileno));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(destination));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(fileno));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(volume_no1));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(destination));
            _bw.write(_wl_block41Bytes, _wl_block41);

}else {

if(row_count==0)
{

            _bw.write(_wl_block42Bytes, _wl_block42);

}
}
	}else if(file_creat_fac_id.equals(facility_id) && curr_fs_locn_ident.equals("D"))
 	{
    if(curr_file_status.equals("I"))		
     {
   
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(fs_locn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(destination));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(fileno));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(destination));
            _bw.write(_wl_block47Bytes, _wl_block47);
 }
		}else if(!file_creat_fac_id.equals(curr_facility_id1) && curr_fs_locn_ident.equals("D")){
    if(curr_file_status.equals("I"))		
     {
   
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(fs_locn));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(destination));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(fileno));
            _bw.write(_wl_block50Bytes, _wl_block50);
 }
		}else{

if(row_count == 0)
		{
    if(!file_creat_fac_id.equals(facility_id))
	 {  
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(fs_locn));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(fileno ));
            _bw.write(_wl_block54Bytes, _wl_block54);
 }else{
	 
	 
            _bw.write(_wl_block55Bytes, _wl_block55);

			}
		}else
		{
    if(!file_creat_fac_id.equals(facility_id))
	 {  
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(fs_locn));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(fileno));
            _bw.write(_wl_block58Bytes, _wl_block58);
 }else{
	 if(row_count==0)
{
	 
            _bw.write(_wl_block59Bytes, _wl_block59);

			}
			}
		}
	}
}
		}

            _bw.write(_wl_block60Bytes, _wl_block60);

	/*if(fs_locn.equals("C")) 
		header="Current FS Location";
	else
	{
		header="Permanent FS Location";
	}*/
	if(row_count!=0){
	if(file_type_appl_yn.equals("N"))
	{
		
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

	}
	else if(file_type_appl_yn.equals("Y"))
	{
		
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

	}
	
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);

	}
try
{
/*	Properties prop	=	new Properties();
	prop.put("fs_locn",fs_locn);
	prop.put("Statement",stmt1);
	prop.put("facility_id",facility_id);
	rs1	=	eFM.FMUtilities.getStorageLocn(prop);*/

	if(fs_locn.equals("P"))
	{
		dissable_attribute = "disabled";
	}
	  	
	for(int i=fm_disp; i<=to_disp; i++)
	{
		classValue			=	( (i%2)==0 )? "QRYODD" : "QRYEVEN";
		htRecord			=	(HashMap)	recordSet.getObject(i);
		file_no				=	(String)	htRecord.get("file_no");
		patient_id			=	(String)	htRecord.get("patient_id");
		file_type_code		=	(String)	htRecord.get("file_type_code");
		volume_no			=	(String)	htRecord.get("volume_no");		
		associate_yn		=	(String)	htRecord.get("associate_yn");
		fs_locn_disp		=	(String)	htRecord.get("fs_locn_disp");
		pat_details			=	(String)	htRecord.get("pat_details");
		mr_pat_fs_locn_desc	=	(String)	htRecord.get("mr_pat_fs_locn_desc");
		curr_fs_locn_desc	=	(String)	htRecord.get("curr_fs_locn_desc");
		other_locn_code		=	(String)	htRecord.get("other_locn_code");
         filevol_concat=file_no+volume_no;
		tblrow_id	=	"tblrow_id"+i;
   
        fslocn_type_old =(String)pat_file_code.get(filevol_concat);
		if(fslocn_type_old == null || fslocn_type_old.equals("null")) fslocn_type_old = "";		
						
		if(associate_yn.equals("Y"))
		{
			associate_yn_prop = "CHECKED";
		}
		else
		{
			associate_yn_prop = " ";
		}

		if (file_type_appl_yn.equals("N"))
		{
			
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(((file_no.equals(""))?"&nbsp;":file_no)));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(((pat_details.equals(""))?"&nbsp;":pat_details)));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block75Bytes, _wl_block75);

		}
		else if (file_type_appl_yn.equals("Y"))
		{
		
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(((pat_details.equals(""))?"&nbsp;":pat_details)));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block77Bytes, _wl_block77);

			if(file_type_appl_yn.equals("Y"))
			{
				
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf((String)	htRecord.get("file_type_desc")));
            _bw.write(_wl_block79Bytes, _wl_block79);

			}
		}
		
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(((volume_no.equals(""))?"&nbsp;":volume_no)));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(((mr_pat_fs_locn_desc.equals(""))?"&nbsp;":mr_pat_fs_locn_desc)));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(((curr_fs_locn_desc.equals(""))?"&nbsp;":curr_fs_locn_desc)));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(dissable_attribute));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);

		
		int len =keepRecord.size();
		if(len==0)
		{
			stmt2	=	con.createStatement();			
				
			if(fs_locn.equals("C"))
				{
					//sql_query="select fs_locn_code, short_desc from fm_storage_locn where facility_id='"+facility_id+"' and eff_status='E' order by short_desc";
					sql_query = "SELECT  fs_Locn_Code , Short_desc  FROM  FM_STORAGE_LOCN_LANG_VW WHERE Facility_Id = '"+facility_id+"'  AND LANGUAGE_ID='"+localeName+"'    AND eff_Status = 'E' ORDER BY  Short_desc ";

				}
				else
				{
					
					//sql_query="select fs_locn_code, short_desc from fm_storage_locn where facility_id='"+facility_id+"' and permanent_file_area_yn ='Y' and eff_status='E' order by short_desc";
					sql_query = "SELECT fs_Locn_Code  , Short_desc FROM FM_STORAGE_LOCN_LANG_VW WHERE Facility_Id = '"+facility_id+"' AND Permanent_File_Area_yn = 'Y'  AND LANGUAGE_ID='"+localeName+"'     AND eff_Status = 'E' ORDER BY	 Short_desc ";

				}

				rs1		=	stmt2.executeQuery(sql_query);
				while(rs1 != null && rs1.next())
				{
					fs_locn_code	=	rs1.getString("fs_locn_code");
					fs_desc			=	rs1.getString("short_desc");

					keepRecord.put(l,fs_locn_code);
					keepRecord1.put(l,fs_desc);
									
					if(!fs_locn_code.equals(fs_locn_disp))
					{
					if(fs_locn_code.equals(fslocn_type_old))
						{
					  selected="selected";
						out.println("<option value="+fs_locn_code+" "+selected+" >"+fs_desc+"</option>");
						associate_yn_prop = " CHECKED ";
						}else{
					out.println("<option value="+fs_locn_code+">"+fs_desc+"</option>");
						}
					}
				l++;
				}
		     }  else{  		
										
				for(int k=0 ;k<=len; k++)
			   {
				   old_fs_locn_code =(String) keepRecord.get(k);
			       old_fs_desc=(String)	keepRecord1.get(k);
			 			if(old_fs_locn_code==null)	old_fs_locn_code="";   
				       if(old_fs_desc==null)	old_fs_desc="";  
					 
				   
				   if(!old_fs_locn_code.equals(fs_locn_disp) && len>0)
					{
									
					if(old_fs_locn_code.equals(fslocn_type_old))
						{
						 selected="selected";
						out.println("<option value="+old_fs_locn_code+" "+selected+">"+old_fs_desc+"</option>");
						associate_yn_prop = " CHECKED ";
						}else{
					
					out.println("<option value="+old_fs_locn_code+">"+old_fs_desc+"</option>");	
				   }
					}
				}
	        		
	}			
				if(rs1 != null) rs1.close();
				if(stmt2  != null) stmt2.close();
				
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(fs_locn_disp));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(other_locn_code));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(i));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(associate_yn_prop));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(dissable_attribute));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(fslocn_type_old));
            _bw.write(_wl_block106Bytes, _wl_block106);

		}
		
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block108Bytes, _wl_block108);

	}
	catch(Exception e)
	{
		out.println("Exception@2: "+e);
		e.printStackTrace();
	}

            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(str));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(fm_disp));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(to_disp));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(from));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(to));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(fs_locn));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(patient_id1));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block118Bytes, _wl_block118);

	if(rs1 != null) rs1.close();
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	if(stmt1 != null) stmt1 = null;
	if(stmt2 != null) stmt2.close();
}
catch(Exception e)
{
	out.println("Exception in fetching connection"+e.toString());
	e.printStackTrace();
}
finally
{	
	ConnectionManager.returnConnection(con,request);
//session.setAttribute("recordSet", recordSet);
}

            _bw.write(_wl_block119Bytes, _wl_block119);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FileNoPatientDetails.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.VolumeNo.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FileTypeVolumeNo.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.PermanentFSLocation.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.CurrentFSLocation.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FSLocation.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.change.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
