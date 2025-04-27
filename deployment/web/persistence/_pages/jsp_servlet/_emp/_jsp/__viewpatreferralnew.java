package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.jsp.JspWriter;
import com.ehis.util.*;

public final class __viewpatreferralnew extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/ViewPatReferralNew.jsp", 1742534489472L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t \n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n     <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/messages.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n<!-- \t<script src=\'../../eMP/js/RegPatReferral.js\' language=\'javascript\'></script> -->\n\t<script src=\'../../eMP/js/RegPatReferral1.js\' language=\'javascript\'></script>\n\n\t<script language=\'javascript\'>\n\tasync function Clinical_Details(obj,calling_from,mode)\n\t{\n\n\t\tif(obj.name==\"clinical_details\")\n\t\t{\n\n\t\t\tvar retVal =    new String();\n\t\t\tvar dialogHeight= \"250px\" ;\n\t\t\tvar dialogWidth = \"700px\" ;\n\t\t\tvar status = \"no\";\n\t\t\t\n\t\t\t\n\t\t\tvar concat_vals=escape(document.forms[0].exm_clinical_find.value)+\"&\"+escape(document.forms[0].diagnosis.value)+\"&\"+escape(document.forms[0].treatment.value);\t\t\t\t\n\t\t\t\n\t\t\tvar arguments\t=concat_vals;\n\t\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t\t\tretVal = await window.showModalDialog( \"../../eMP/jsp/RegPatReferralClinicalDtls.jsp?calling_from=\"+calling_from+\"&mode=\"+mode,arguments,features);\n\n\t\t\tif(retVal != null)\n\t\t\t{\n\t\t\t\tvar arr = retVal.split(\"&\");\n\n\t\t\tdocument.forms[0].exm_clinical_find.value=unescape(arr[0]);\n\t\t\tdocument.forms[0].diagnosis.value=unescape(arr[1]);\n\t\t\tdocument.forms[0].treatment.value=unescape(arr[2]);\n\t\t\t}\n\n\n\t\t\t\t\n\t\t}\n\t}\n\n//This variable is let to show that by default on load Arrived tab is enabled.\nvar currentTab = new String();\ncurrentTab = \"rfrd_from\";\n\n// This function is used for calling the function for changing the tab img displays and also the function for corresponding page displays for that particular tab.\n\nfunction tab_click(objName){\nselectTab(objName)\n   \n\tif(objName == \"rfrd_from\"){\n    //changeTab(objName);\n\tmoveToTab(2);\n\t}\n\n\t\n\n\telse if(objName == \"rfrd_to\"){\n\t//\tchangeTab(objName);\n\t\tmoveToTab(3);\n\t}\n\n\n}\n\nfunction func1()\n{\n\tif(document.forms[0].otherDocAttached)\n\t{\n\tvar otherDocAttached=document.forms[0].otherDocAttached.value;\n\tdocument.forms[0].txt.value=otherDocAttached;\n\t}\n}\n\n// function to change the tab display images according to functionality.\n\n\n\nfunction moveToTab(TabIndex) {\n\nif ( TabIndex == 2 )\n\t{\n\t\t//setTimeout(\"parent.document.frames[1].document.getElementById(\"rfrdfrom\").scrollIntoView()\",300);\n       //setTimeout(\"parent.document.frames[1].document.getElementById(\"clinical_details\").foc/us()\",300);\n\t   document.getElementById(\'reftotable\').style.display=\'\';\n\t   document.getElementById(\'rfrdto1\').style.display=\'none\';\n\t   \n\t}\n    else if ( TabIndex == 3 )\n\t{\n\t\tdocument.getElementById(\'reftotable\').style.display=\'none\';\n\t   document.getElementById(\'rfrdto1\').style.display=\'\';\t//setTimeout(\"parent.document.frames[1].document.getElementById(\'rfrdto\').scrollIntoView()\",300);\n\t}\n}\n\nfunction tabFocus(){\n  \t//document.getElementById(\'ViewPatMain\').scrollIntoView();\n\tmoveToTab(0);\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t<style>\ntextarea {\n  resize: none;\n}\n</style>\n</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body  onKeyDown =\'lockKey()\' onLoad=\"window.toolbar=true;tab_click(\'rfrd_from\')\">\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<form name=\"ViewPatReferral_form\" id=\"ViewPatReferral_form\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" target=messageFrame method=post>\n<a name=\"ViewPatMain\" ></a> \n<table cellpadding=0 cellspacing=0 border=\"0\" width=\"100%\">\n<tr>\n<td colspan=\"4\">\n\t<table cellpadding=0 cellspacing=0 border=0 width=\"100%\" colspan=\"4\">\n\t\t<tr><td colspan=4 class=label height=5></td></tr>\n\t\t\t<tr>\n\t\t\t\t<td  width=\'24%\' class=label >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t</td><td  class=\'label\'   ><b>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</b></td>\n\t\t\t\t<td   class=label >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t</td><td  class=\'label\' width=\'262pt\' ><b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b></td>\n\t\t\t</tr>\n\t\t<tr><td colspan=4 class=label height=5></td></tr>\n\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t<td class=\'label\' width=\'204pt\'  >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t<td  class=\'label\' colspan=\'3\'  ><b>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&nbsp;";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</b> </td>\n\t\t\t</tr>\n\t\t<tr><td colspan=4 class=label height=5></td></tr>\n\t\t<tr>\n\t\t\t<td class=\'label\'   >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t<td  class=\'label\' ><B>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</B></td>\n\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n\t\t\t\t<td  class=label  >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t<td  class=label ><B>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</B> </td>\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t</tr>\n\t\t<tr><td colspan=4 class=label height=3></td></tr>\n<!-- \t</table>\n\n\t<table cellpadding=0 cellspacing=0 border=0 width=\"100%\"> -->\n\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\n\t\t<tr>\n \t\t\t<td  class=label   width=\'24%\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t<td  class=label  width=\'260pt\'><B>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</B>\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t<td  class=label width=\'205pt%\' >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t<td  class=label ><B>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</B></td>\n            </tr>\n\t\t\t<tr>\n\t\t\t<td  class=label  >";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t<td  class=label  ><B>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t<td  class=label  >";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</B></td>\n\t    </tr>\n\t\t\t<tr><td colspan=4 class=label height=5></td></tr>\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t<tr>\n\t\t\t<td  class=label  >";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t\t\n\t\t\t<td  class=label ><B>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</B></td>\n            </tr>\n           <tr>   \n\t\t\t<td  class=label >";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</B>\n\t\t\t</td>\n            \n\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</B></td>\n\t\t</tr>\n\n\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t<tr><td colspan=4 class=label height=3></td></tr>\n\t<tr><td colspan=4 class=label height=3></td></tr>\n\t<tr><td colspan=4 class=label height=3></td></tr>\n\n<!--  </table> -->\n<tr><td colspan=4>\n<table cellpadding=0 cellspacing=0 border=0 width=\"100%\" > \n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n<tr><td colspan=4 class=label height=5></td></tr>\t\t\n<tr>\n\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t<td  class=label >";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t<td  class=label  >";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td><td colspan=2></td>\n\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n</tr>\n<tr>\n<!--Modified by N Munisekhar on 07-Feb-2012 against ML-BRU-SCF-0690 [IN:037810]-->\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t<td  class=label><B>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</B>\t</td>\t\t\n\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t<td  class=label  ><B>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</B></td>\n\n\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t<td  class=label ><B>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</B></td>\n\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t<td colspan=2></td> \n\t</tr>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n<tr>\n\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t<td colspan=2></td>\n</tr>\n<tr>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</B></td>\t\t\n\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</B>&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</B></td>\n\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t<!--End of ML-BRU-SCF-0690 [IN:037810] \t-->\n\t\t<td colspan=2></td> \n\t</tr>\n\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" \n\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" \n \t</table>\n</td></tr>\n\t<!-- <table cellpadding=0 cellspacing=0 border=0 width=\"100%\" colspan=\"8\">  -->\n\t<tr><td colspan=4 class=label height=5></td></tr>\n\t<tr>\n\t\t<td  class=label width=\'24%\'>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td>\n\t\t<td  class=label  width=\'260pt\'><B>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</B></td>\n\n\t\t<td  class=label >";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t<td  class=label ><B>\n\t\t  ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t<b>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="<b>\n\t\t   ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t</B></td>\n\n\t\t</tr>\n\t\t<tr>\n\t\t<td  class=label >";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\n\t\t<td  class=label >\n\t\t<B>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</B></td>\n\n\t\t<td  class=label wrap>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\t\t<td  class=label ><B>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</B></td>\n\t\t<td colspan=2></td>\n\t</tr>\n\n\t<tr><td colspan=4 class=label height=5></td></tr>\n\n\t<tr>\n\t\t\n\t\t<td  class=label>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\n\t\t<td  class=label >\n\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t<B>";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</B>\n\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t</td>\n\n\t\t<td  class=label>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\n\t\t\t\n\n\t\t\t<B>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</B>\n\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\n\t\t</td>\n\t</tr>\n\t<tr><td colspan=4 class=label height=5></td></tr>\n\t<tr>\n\t\t<td  class=label >";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td>\n\t\t<td  class=label  ><B>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</B></td>\n     <tr>\n\t<tr>\n\t\t<td  class=label >";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</B></td>\n\t</tr>\n\t</table>\n\n</td>\n</tr>\n<tr><td colspan=4 class=label height=5></td></tr>\n</table>\n\n\n<script>prevTabObj=\'rfrd_from\'</script>\n<table border=\'0\' width=\'100%\' tabindex=-1>\n<tr ><td  class=\'white\' >\n <ul class=\"tablist\" style=\"padding-left:0px\">\n\t\t\t<li class=\"tablistitem\" title=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t\t\t\t<a onclick=\"tab_click(\'rfrd_from\')\" class=\"tabClicked\" id=\"rfrd_from\" tabindex=-1 >\n\t\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"rfrd_fromspan\">";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t\t<li class=\"tablistitem\" title=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t\t\t\t<a onclick=\"javascript:tab_click(\'rfrd_to\')\" id=\"rfrd_to\" class=\"tabA\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"rfrd_tospan\">";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t </ul>\n\t</td></tr>\n</table>\n\n<a name=\'start\' id=\'start\'></a>\n<table cellpadding=0 cellspacing=0 border=0 width=\"100%\" id=\'reftotable\' tabindex=-1 >\n<tr><td colspan=4 class=label >&nbsp;</td></tr>\n<tr>\n\t <td class=label width=\'24%\'>";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</td>\n\t<td  class=label   width=\'260pt\'><B>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</B></td>\n\t <td  class=label width=\'205pt\'>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</td>\n\t <td  class=label ><B>";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</B></td>\n    \n</tr>\n <tr><td colspan=4 class=label >&nbsp;</td></tr>\n\n  <tr>\n\t  <td class=label  >";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</td>\n      <td  class=label ><B>";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</B></td>\n\t  <td  class=label  >";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td>\n\t  <td  class=label ><B>";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</B>\t</td>\n </tr>\n  <tr><td colspan=4 class=label >&nbsp;</td></tr>\n\n  <tr>\n\t  <td  class=label   >";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</td>\n      <td  class=label  ><B>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</B></td>\n      <td  class=label   >";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="</td>\n\t  <td  class=label  ><B>";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\n\t  </B></td>\n  </tr>\n  <tr><td colspan=4 class=label >&nbsp;</td></tr>\n\n  <tr>\n      <td  class=label  >";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</td>\n\t  <td  class=label  > <B>";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</B></td>\n     <!-- <td  class=label  >";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</td> -->\n\t <!-- Below lines was added against ML-MMOH-SCF-0301 on 12-jan-2016 -->\n      <td  class=label  >";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t<img src=\'../../eCommon/images/more.gif\' name=\"lng_name\" id=\"lng_name\" align=center alt=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t</td>\n  </tr>\n  <tr><td colspan=4 class=label >&nbsp;</td></tr>\n\n  <tr>\n      <td  class=label  >";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</B></td> \n      <td colspan=2 align=right><input type=\'button\' class=\'button\' name=\'clinical_details\' id=\'clinical_details\' value=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' onclick=\"Clinical_Details(this,\'View_Referral\');\" >&nbsp;<input  type=\"button\" class=BUTTON value=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\' onClick=\"ref_note()\" onBlur=\"\" id=\'notes\' name=\'notes\' >\n\t  </td>\n  </tr> \n  <tr><td colspan=4 class=label >&nbsp;</td></tr>\n\n  <tr>\n  \t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="<td  class=label >";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</td>\n\t ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t<td  class=label><B>";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</b></td>\n\t\t\t<td  class=label >";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</b></td>\n\t   \t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t<td  class=label colspan=3 ><B>";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t<td  class=label >";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</td>\n\t\t\t<td  class=label colspan=\'3\'><B>";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t</tr>\n\n <!--   <table cellpadding=0 cellspacing=0 border=0 width=\"100%\" colspan=\"4\"> -->\n   <tr><td colspan=4 class=label >&nbsp;</td></tr>\n \n   <tr>\n\t    <td  class=label width=\'24%\'>";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</td>\n \t    <td  class=label   width=\'260pt\'><B>";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="</B></td> \n\t    <td  class=label width=\'200pt\' >";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="</td>\n\t    <td  class=label  ><B>";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="</B></td>\n     </tr>\n   <tr><td colspan=4 class=label >&nbsp;</td></tr>\n  \n   <tr>\n\t\t<td  class=label >";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="</td>\n \t    <td  class=label  ><B>";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</B></td> \n\t    <td  class=label>";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</td>\n\t    <td  class=label ><B>";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</B></td>\n    </tr>\n <!-- <tr><td colspan=18 class=label height=5></td></tr>  -->\n<!-- </table>\n\n<table cellpadding=0 cellspacing=0 border=0 width=\"100%\" colspan=\"4\"> -->\n  <tr>   <td colspan=4 class=columnheader><b>";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</b></td></tr>\n \n<!--      \n</table>\n\n\n<table cellpadding=0 cellspacing=0 border=0 width=\"100%\" colspan=\"4\" style=\'visibility:";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'> -->\n<tr><td colspan=4 class=label height=7></td></tr>\n<tr>\n\t <td  class=label width=\'24%\'  >";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</td>\n\t <td  colspan=\'2\'><textarea name=\"txt\" rows=\"3\" cols=\"56\" value=\'\' readOnly></textarea> </td>\n\t<td class=label height=5></td>\t\n</tr>\n<tr><td colspan=4 class=label height=8></td></tr>\n<tr>\n\t<td colspan=4 class=label height=5></td>\n\t\n</tr>\n<!-- </table> -->\n<tr><td colspan=4 class=label height=5></td></tr>\n</table>\n\n<a name=\'rfrdto\' id=\'rfrdto\' tabindex=\'\' >\n<table  cellpadding=4 cellspacing=0 border=0 width=\"100%\"  id=\'rfrdto1\'>\n  <tr>\n\t\n\t<td   class=label >";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="</td>\n\t<td  class=label  ><B>";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</B> </td>\n\t<td   class=label >";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="</B></td>\n </tr>\n\t<tr>\n\t<td  class=label >";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 =" </td>\n\t<td  class=label ><B>";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="</B></td>\n\t<td class=label>";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="</td>\n\t<td class=label><B>";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="</B></td>\n\t</tr>\n\t<tr> \n    <td  class=label >";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="</td>\n\t<td  class=label ><B>";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="</B></td>\t\n    ";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\n    <td  class=label  >";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="</B></td>\n  ";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n    <td  class=label  ></td>\n\t<td  class=label ><B></B></td>\n  \t\n\t";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n \n   </tr>\n   <tr>\n    <td   class=label >";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="</td>\n\t\n\t<!--Added by Suji Keerthi for NMC-JD-CRF-0130-->\n\t\n ";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\t\t\t\t\t<td  class=label ><B>";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 =" </B></td>";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 =" <!--Ended by Suji Keerthi for NMC-JD-CRF-0130-->\n\t\t\t\t\t<td  class=label ><B>\n";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\t\t\t\t</B></td>";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\n\t<td  class=label  >";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="</B></td>\n   </tr>\n    <tr>\n\t<td   class=label width=\'24%\'>";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="</td>\n\t<td  class=label   width=\'255pt\'><B>";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="</B> </td>\n\t<td   class=label   width=\'200pt\'>";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="</td>\n\t<td  class=label   ><B>";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="</B></td>\n    </tr>\n\t<tr>\n\t<td   class=label >";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="</td>\n\t<td  class=label colspan=3><B>";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="</B>\n\t\t ";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n</td>\n\t</tr>\n<tr><td colspan=\"4\">\n\n\t\n<table  cellpadding=2 cellspacing=0 border=0 width=\"100%\" colspan=\"4\">\n\n";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 =" \n\n\n<tr>\n<td class=\'columnheader\' >";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 =" </td>\n<td class=\'columnheader\'>";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="</td>\n<td class=\'columnheader\'>";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="</td>\n</tr>\n\t\t\n\t";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\t\n\t\t\n<tr>\n<td class=\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\'  ><font size=1>";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="</font></td>\n<td class=\'";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\' ><font size=1>";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\'><font size=1>";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="</font></td>\n</tr>\n\t\t";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\n\n</table>\n</td>\n</tr>\n</table>\n\n\n\t</a>\n\n<input type=\'hidden\' name=\'referral_notes\' id=\'referral_notes\' value = \"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\"  ></input>\n\n<input type=\'hidden\' name=\'otherDocAttached\' id=\'otherDocAttached\' value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\"></input>\n\n<input type=\'hidden\' name=\'exm_clinical_find\' id=\'exm_clinical_find\' value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\"></input>\n<input type=\'hidden\' name=\'concat_address_hidden\' id=\'concat_address_hidden\' value=\"\">\t\t\n<input type=\'hidden\' name=\'diagnosis\' id=\'diagnosis\' value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\"></input>\n<input type=\'hidden\' name=\'treatment\' id=\'treatment\' value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\"></input>\n<input type=\'hidden\' name=\'addr1_type\' id=\'addr1_type\' value=\'\'>\n<input type=\'hidden\' name=\'addr_line1\' id=\'addr_line1\' value=\'";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\' maxlength=\'30\'>\n<input type=\'hidden\' name=\'addr_line2\' id=\'addr_line2\' value=\'";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\' maxlength=\'30\'>\n<input type=\'hidden\' name=\'addr_line3\' id=\'addr_line3\' value=\'";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\' maxlength=\'30\'>\n<input type=\'hidden\' name=\'addr_line4\' id=\'addr_line4\' value=\'";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\' maxlength=\'30\'>\n<input type=\'hidden\' name=\'res_town_code\' id=\'res_town_code\' value=\'";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\' maxlength=\'6\'>\n<input type=\'hidden\' name=\'res_area_code\' id=\'res_area_code\' value=\'";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\' maxlength=\'6\'>\n<input type=\'hidden\' name=\'postal_code\' id=\'postal_code\' value=\'";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\' maxlength=\'8\'>\t\n<input type=\'hidden\' name=\'region_code\' id=\'region_code\' value=\'";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\' maxlength=\'8\'>\t\n<input type=\'hidden\' name=\'country_code\' id=\'country_code\' value=\'";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\' maxlength=\'4\'>\n<input type=\'hidden\' name=\'contact1_name\' id=\'contact1_name\' value=\'";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\'>\n<input type=\'hidden\' name=\'invalid1_yn\' id=\'invalid1_yn\' value=\'\'>\n\n<input type=\'hidden\' name=\'addr2_type\' id=\'addr2_type\' value=\'\'>\n<input type=\'hidden\' name=\'mail_addr_line1\' id=\'mail_addr_line1\' maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\'>\n<input type=\'hidden\' name=\'mail_addr_line2\' id=\'mail_addr_line2\' maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\'>\n<input type=\'hidden\' name=\'mail_addr_line3\' id=\'mail_addr_line3\' value=\'";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\'  maxlength=\'30\'>\n<input type=\'hidden\' name=\'mail_addr_line4\' id=\'mail_addr_line4\' value=\'";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\' maxlength=\'30\'>\n<input type=\'hidden\' name=\'mail_res_town_code\' id=\'mail_res_town_code\' value=\'";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\' maxlength=\'6\'>\n<input type=\'hidden\' name=\'mail_res_area_code\' id=\'mail_res_area_code\' value=\'";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\' maxlength=\'6\'>\n<input type=\'hidden\' name=\'mail_postal_code\' id=\'mail_postal_code\' value=\'";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\' maxlength=\'8\'>\n<input type=\'hidden\' name=\'mail_region_code\' id=\'mail_region_code\' value=\'";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\' maxlength=\'8\'>\n<input type=\'hidden\' name=\'mail_country_code\' id=\'mail_country_code\' value=\'";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\' maxlength=\'4\'>\n<input type=\'hidden\' name=\'contact2_name\' id=\'contact2_name\' value=\'";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\'>\n<input type=\'hidden\' name=\'invalid2_yn\' id=\'invalid2_yn\' value=\'\'>\n\n<input type=\'hidden\' name=\'ct_tab_name\' id=\'ct_tab_name\' > \n\n</form>\n</body>\n\n<script>\n\tfunc1();\n</script>\n\n";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\n\n</html>\n\n";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

public static String checkForNull(String inputString)
{
	return((inputString == null || inputString.equals("null")) ? "" : inputString);
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
            _bw.write(_wl_block5Bytes, _wl_block5);
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null ;
	PreparedStatement orgTypePstmt = null;
	ResultSet orgTypeRS = null;
	String org_type_data ="";
	String orderCatalog = "";
    //String facility_id		=	(String)		session.getValue("facility_id");
    String  action_date_time="";
    String action_type_desc="";
    String action_reason_desc="";
    String action_ref_id		="";
    String action_remarks	="";
    String  actioned_by		="";
    String or_install_yn="";
    String ordercatlogcode = request.getParameter("orderCatalogCode")==null ?"" :request.getParameter("orderCatalogCode");
	String referralid = checkForNull(request.getParameter("referral_id"));
	//String frame_name=	checkForNull(request.getParameter("frame_name"));
	String visibility_table="";
	/*if(frame_name.equals("first"))
		visibility_table="visible";
	else
		visibility_table="visible";*/
		
	//added for Bru-HIMS-CRF-380 Start
	String facility_id	= request.getParameter("facility_id");
	if(facility_id==null || facility_id.equals(""))//Modified by Thamizh selvi on 3rd July 2018 against MMS-DM-CRF-0115.3 
		facility_id = (String) session.getValue("facility_id");
	//added for Bru-HIMS-CRF-380 End
	


	String[] names			= new String[4] ;
    String[] name_prompts	= new String[4] ;
	String[] names_local	= new String[4] ;
    String[] name_prompts_local	= new String[4] ;
	StringBuffer sql		= new StringBuffer();
	String patient_id		= "";
	String patient_name		= "";
	String gender			= "";
	String agey				= "";
	String agem				= "";
	String aged				= "";
	String date_of_birth	= "";
	String nationality		= "";
	String addr_line1		= "";
	String addr_line2		= "";
	String addr_line3		= "";
	String addr_line4		= "";
	String contact1_no		= "";
	String contact2_no		= "";	
	String referral_date	= "";
	String referral_letter_no	= "";
	String preferred_treatment_date	= "";
	String referral_priority= "";
	String received_date	= "";
	String classValue="";
	String from_ref_type= "";
	String from_ref_type_desc="";
	String from_ref_locn_type="";
	String from_ref_locn_desc= "";
	String from_ref_pract_name= "";
	String to_speciality_desc= "";
	String to_service_desc= "";
	String to_ref_pract_name= "";
	String displaydata		= "";
	String prefix_prompt	= "";
	String prefix           = "";
	String suffix_prompt	= "";
	String suffix           = "";
	String first_name_prompt	= "";
	String first_name_order	= "";
	String first_name           = "";
	String second_name_prompt	= "";
	String second_name_order	= "";
	String second_name           = "";
	String third_name_prompt	= "";
	String third_name_order	= "";
	String third_name           = "";
	String family_name_prompt	= "";
	String family_name_order    ="";
	String family_name           = "";
	String status="";
	boolean citizen=true;
	String nationalIdNo="";
	String altIdTypeDescription[]=new String[4];
	String altIdType[]=new String[4];
	String altIdNo[]=new String[4];
	String othAltIdTypeDescription="";
	String othAltIdNo="";
	String mailAddress[]=new String[4];
	String mailResTownCode="";
	String mailResAreaCode="";
	String mailCountryCode="";
	String mailPostalCode="";
	String mailRegionCode="";
	String referralReason="";
	String otherDocAttached="";
	boolean legal=true;
	String raceDesc="";
	String toSpecialityDesc="";
	String examAndClinFindings="";
	String diagnosis="";
	String treatment="";
	String practitionerResTelNo="";
	String practitionerMobileNo="";
	String practitionerPagerNo="";
	String toRefType="";
	String toRefTypeDesc="";
	String toRefLocnDesc="";
	String toRefPractName="";
	String from_hcare_setting_desc	= "";
	String toHcareSettingDesc="";
	String referredForIP="";
	String resTownCode="";
	String resAreaCode="";
	String countryCode="";
	String regionCode="";
	String postalCode="";
	String nationalIDPrompt="";
	String Birth_place_desc="";
	String Race_desc="";
	String From_Splty_desc="";
	String Alt_ID1_date="";
	String Alt_ID2_date="";
	String Alt_ID3_date="";
	String Alt_ID4_date="";
	String Ref_source="";
	String ToRef_source="";

	String altIdTypeDesc1 = "";
	String altIdTypeDesc2 = "";
	String altIdTypeDesc3 = "";
	String altIdTypeDesc4 = "";

	String altIdNo1 = "";
	String altIdNo2 = "";
	String altIdNo3 = "";
	String altIdNo4 = "";
	String family_name_loc_lang="";
	String third_name_loc_lang="";
	String second_name_loc_lang="";
	String first_name_loc_lang="";
	String name_prefix_loc_lang="";
	String name_suffix_loc_lang="";
	String patient_name_loc_lang="";

	String name_prefix_loc_lang_prompt="";
	String first_name_loc_lang_prompt="";
	String second_name_loc_lang_prompt="";
	String third_name_loc_lang_prompt="";
	String family_name_loc_lang_prompt="";
	String name_suffix_loc_lang_prompt="";
	String names_in_oth_lang_yn="";
	String name_prefix_accept_yn="";
	String name_suffix_accept_yn="";
	String from_long_name="";
	String to_long_name="";

	Clob note = null;

	String exp_date_desc="Exp. Date";
	String to_locn_type_desc="";
	boolean NRICNamePrefixAvailable=true;
	boolean NRICFirstNameAvailable=true;
	boolean NRICSecondNameAvailable=true;
	boolean NRICThirdNameAvailable=true;
	boolean NRICFamilyNameAvailable=true;
	boolean NRICNameSuffixAvailable=true;

	for(int i=0;i<4;i++)
	{
		altIdTypeDescription[i]="";
		altIdType[i]="";
		altIdNo[i]="";
		mailAddress[i]="";
	}

	/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
	String called_from	= checkForNull(request.getParameter("called_from"));
	String RepDb		= checkForNull(request.getParameter("RepDb"));
	String clob_data	= checkForNull(request.getParameter("clob_data"));
	String cdrPatientId	= checkForNull(request.getParameter("cdrPatientId"));
	String sqlFinal		= "";
	/*End*/

            _bw.write(_wl_block8Bytes, _wl_block8);

	try
	{	
	con = ConnectionManager.getConnection(request);

     //Below Added by Suji Keerthi for NMC-JD-CRF-0130
        Boolean isReferralPriorityAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AM","REFERRAL_PRIORITY_DESC");
     //Ended by Suji Keerthi for NMC-JD-CRF-0130

	/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
	if(called_from.equals("CDR"))
		eMP.MPCommonBean.insReferralDataForCDR(con, cdrPatientId, RepDb);
	/*End*/


  // 	sql.append("select name_prefix_accept_yn, name_suffix_accept_yn,  nvl(name_prefix_prompt,'')name_prefix_prompt, first_name_accept_yn,  nvl(first_name_prompt,'')first_name_prompt, nvl(name_suffix_prompt,'')name_suffix_prompt, second_name_accept_yn, nvl(second_name_prompt,'')second_name_prompt, third_name_accept_yn, nvl(third_name_prompt,'')third_name_prompt, family_name_accept_yn, first_name_order, second_name_order, third_name_order, family_name_order,nvl(family_name_prompt,'')family_name_prompt,alternateID1.alt_id_type alternateIDType1,alternateID2.alt_id_type alternateIDType2,alternateID3.alt_id_type alternateIDType3,alternateID4.alt_id_type alternateIDType4, alternateID1.short_desc alternateID1desc, alternateID2.short_desc alternateID2desc, alternateID3.short_desc alternateID3desc, alternateID4.short_desc alternateID4desc, nvl(nat_id_prompt, 'NRIC No.') nat_id_prompt ,name_prefix_loc_lang_prompt,first_name_loc_lang_prompt,second_name_loc_lang_prompt,third_name_loc_lang_prompt,family_name_loc_lang_prompt,name_suffix_loc_lang_prompt,names_in_oth_lang_yn");
	//sql.append(" from mp_param, mp_alternate_id_type alternateID1, mp_alternate_id_type alternateID2, mp_alternate_id_type alternateID3, mp_alternate_id_type alternateID4 where alternateID1.alt_id_type = mp_param.alt_id1_type and alternateid2.alt_id_type(+) = mp_param.alt_id2_type  AND alternateid3.alt_id_type(+) = mp_param.alt_id3_type AND alternateid4.alt_id_type(+) = mp_param.alt_id4_type ");

	sql.append("select name_prefix_accept_yn, name_suffix_accept_yn,  nvl(name_prefix_prompt,'')name_prefix_prompt, first_name_accept_yn,  nvl(first_name_prompt,'')first_name_prompt, nvl(name_suffix_prompt,'')name_suffix_prompt, second_name_accept_yn, nvl(second_name_prompt,'')second_name_prompt, third_name_accept_yn, nvl(third_name_prompt,'')third_name_prompt, family_name_accept_yn, first_name_order, second_name_order, third_name_order, family_name_order,nvl(family_name_prompt,'')family_name_prompt,alternateID1.alt_id_type alternateIDType1,alternateID2.alt_id_type alternateIDType2,alternateID3.alt_id_type alternateIDType3,alternateID4.alt_id_type alternateIDType4,   mp_get_desc.MP_ALTERNATE_ID_TYPE ##REPDB##(alternateID1.alt_id_type,'"+localeName+"',1) alternateID1desc   ,mp_get_desc.MP_ALTERNATE_ID_TYPE ##REPDB##(alternateID2.alt_id_type,'"+localeName+"',2) alternateID2desc   ,mp_get_desc.MP_ALTERNATE_ID_TYPE ##REPDB##(alternateID3.alt_id_type,'"+localeName+"',2) alternateID3desc   ,mp_get_desc.MP_ALTERNATE_ID_TYPE ##REPDB##(alternateID4.alt_id_type,'"+localeName+"',2) alternateID4desc , nvl(nat_id_prompt, '"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NationalID.label","mp_labels")+"') nat_id_prompt ,name_prefix_loc_lang_prompt,first_name_loc_lang_prompt,second_name_loc_lang_prompt,third_name_loc_lang_prompt,family_name_loc_lang_prompt,name_suffix_loc_lang_prompt,names_in_oth_lang_yn");
	sql.append(" from mp_param_lang_vw ##REPDB##, mp_alternate_id_type ##REPDB## alternateID1, mp_alternate_id_type ##REPDB## alternateID2, mp_alternate_id_type ##REPDB## alternateID3, mp_alternate_id_type ##REPDB## alternateID4 where alternateID1.alt_id_type = alt_id1_type and alternateid2.alt_id_type(+) = alt_id2_type  AND alternateid3.alt_id_type(+) = alt_id3_type AND alternateid4.alt_id_type(+) = alt_id4_type AND module_id='MP' AND language_id='"+localeName+"' ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
	
	/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
	sqlFinal = sql.toString();
	sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
	/*End*/
	pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
	rs = pstmt.executeQuery();
    while(rs!=null &&rs.next())
		{
			name_prefix_accept_yn			= rs.getString("name_prefix_accept_yn");
		 if (name_prefix_accept_yn==null) name_prefix_accept_yn="N";
		 name_suffix_accept_yn			= rs.getString("name_suffix_accept_yn");
		 if (name_suffix_accept_yn==null) name_suffix_accept_yn="N";

		 prefix_prompt			= rs.getString("name_prefix_prompt");
		 if (prefix_prompt==null) prefix_prompt="";
		
		 suffix_prompt			= rs.getString("name_suffix_prompt");
		 if (suffix_prompt==null) suffix_prompt="";
		
		 first_name_prompt		= rs.getString("first_name_prompt");
		 if (first_name_prompt==null) first_name_prompt="";
		 first_name_order		= rs.getString("first_name_order");
		 if (first_name_order==null) first_name_order = "0";
		 second_name_prompt		= rs.getString("second_name_prompt");
		 if (second_name_prompt==null) second_name_prompt="";
		 second_name_order		= rs.getString("second_name_order");
		 if (second_name_order==null) second_name_order = "0";
		
		 third_name_prompt		= rs.getString("third_name_prompt");
		 if (third_name_prompt==null) third_name_prompt="";
		 third_name_order		= rs.getString("third_name_order");
		 if (third_name_order==null) third_name_order = "0";
		 family_name_prompt		= rs.getString("family_name_prompt");
		 if (family_name_prompt==null) family_name_prompt="";

		 names_in_oth_lang_yn		= rs.getString("names_in_oth_lang_yn");
		 if (names_in_oth_lang_yn==null) names_in_oth_lang_yn="N";

		 name_prefix_loc_lang_prompt			= rs.getString("name_prefix_loc_lang_prompt");
		 if (name_prefix_loc_lang_prompt==null) name_prefix_loc_lang_prompt="";
		
		 name_suffix_loc_lang_prompt			= rs.getString("name_suffix_loc_lang_prompt");
		 if (name_suffix_loc_lang_prompt==null) name_suffix_loc_lang_prompt="";
		
		 first_name_loc_lang_prompt		= rs.getString("first_name_loc_lang_prompt");
		 if (first_name_loc_lang_prompt==null) first_name_loc_lang_prompt="";

		 second_name_loc_lang_prompt		= rs.getString("second_name_loc_lang_prompt");
		 if (second_name_loc_lang_prompt==null) second_name_loc_lang_prompt="";
		
		 third_name_loc_lang_prompt		= rs.getString("third_name_loc_lang_prompt");
		 if (third_name_loc_lang_prompt==null) third_name_loc_lang_prompt="";
		 family_name_loc_lang_prompt		= rs.getString("family_name_loc_lang_prompt");
		 if (family_name_loc_lang_prompt==null) family_name_loc_lang_prompt="";	


		 family_name_order		= rs.getString("family_name_order");
		 if (family_name_order==null) family_name_order = "0";

		 nationalIDPrompt		= rs.getString("nat_id_prompt");
		 if(nationalIDPrompt==null) nationalIDPrompt="";

		 altIdTypeDesc1 = rs.getString("alternateID1desc");
			 if(altIdTypeDesc1 == null) altIdTypeDesc1="";
 		 altIdTypeDesc2 = rs.getString("alternateID2desc");
			 if(altIdTypeDesc2 == null) altIdTypeDesc2="";
		 altIdTypeDesc3 = rs.getString("alternateID3desc");
			 if(altIdTypeDesc3 == null) altIdTypeDesc3="";
		 altIdTypeDesc4 = rs.getString("alternateID4desc");
			if(altIdTypeDesc4 == null) altIdTypeDesc4="";

		for(int i=0;i<4;i++)
		{
			altIdType[i]=rs.getString("alternateIDType"+(i+1));
			if(altIdType[i]==null)	altIdType[i]="";
		}
		
	}
	
	if (rs!=null) rs.close();
    if (pstmt!=null) pstmt.close();

	sql.setLength(0);

   sql.append("select operational_yn from sm_modules_facility ##REPDB## where facility_id='"+facility_id+"' and module_id='OR'");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1

	/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
	sqlFinal = sql.toString();
	sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
	/*End*/
		
	pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
	rs = pstmt.executeQuery();   
	if (rs!=null && rs.next())	  {
		  or_install_yn = rs.getString("operational_yn");
	 }
	if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();
	if(or_install_yn.equals("Y"))
		{sql.setLength(0);
	     sql.append("select short_desc from or_order_catalog_lang_vw ##REPDB## where ORDER_CATALOG_CODE='"+ordercatlogcode+"' and language_id='"+localeName+"'");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
	
	/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
	sqlFinal = sql.toString();
	sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
	/*End*/
	pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
	rs = pstmt.executeQuery();
    while(rs!=null &&rs.next())
		{
		orderCatalog=rs.getString("short_desc"); 
	   
		}

	 if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();
	  
		}
	   
	 sql.setLength(0);
	   
	  // sql.append("select res_area_code, res_town_code, country_code, postal_code, region_code, mail_region_code, referred_for_ip, national_id_no, alt_id1_type, alt_id2_type,alt_id3_type, alt_id4_type, oth_alt_id_type, alt_id1_no, alt_id2_no,alt_id3_no, alt_id4_no, oth_alt_id_no, mail_addr_line1, mail_addr_line2,  mail_addr_line3, mail_res_town_code, mail_res_area_code, mail_country_code, mail_postal_code,  mail_addr_line4, race_desc, referral_reason, other_doc_att, exam_and_clin_findings, diagnosis, treatment, pract_res_tel_num, pract_mobile_num, pract_pager_num, patient_id,patient_name,sex gender, name_prefix,first_name,second_name,third_name,family_name,name_suffix,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),1)||'Y' agey,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),2)||'M' agem, calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),3)||'D' aged,to_char(date_of_birth,'dd/mm/yyyy') date_of_birth,nationality,addr_line1,addr_line2,addr_line3,addr_line4,	contact1_no,contact2_no,from_hcare_setting_desc, decode(from_ref_type,'X',from_ref_desc,from_facility_name) Ref_source,decode(to_ref_type,'X',to_ref_desc,to_facility_name) ToRef_source, to_hcare_setting_desc,to_char(referral_date,'dd/mm/yyyy') referral_date,referral_letter_no,to_char(preferred_treatment_date,'dd/mm/yyyy') preferred_treatment_date, referral_priority , to_char(received_date,'dd/mm/yyyy') received_date,from_ref_type, to_ref_type, from_locn_type  from_locn_type_desc, decode(from_ref_type,'X',from_ref_locn_desc, decode(from_locn_type,'C',from_clinic_desc,'E',from_clinic_desc,'D',from_clinic_desc,from_nurs_unit_desc)) from_ref_locn_desc, decode(to_ref_type,'X',to_ref_locn_desc,decode(to_locn_type,'C',to_clinic_desc,'E',to_clinic_desc,'Y',to_clinic_desc,'W',to_clinic_desc,to_nurs_unit_desc)) to_ref_locn_desc, to_locn_type to_locn_type_desc, decode(from_ref_type,'X',from_ref_pract_name, from_fcy_pract_name)from_ref_pract_name, decode(to_ref_type,'X',to_ref_pract_name,to_fcy_pract_name) to_ref_pract_name, to_speciality_desc, to_service_desc, ref_notes, status, decode(citizen_yn,'Y','true','false') citizen, decode(legal_illegal_yn,'Y','true','false') legal, mp_alternate_id_type.short_desc alternateIDdesc, NVL2(BIRTH_PLACE_CODE, BIRTH_PLACE_DESC, BIRTH_PLACE_DESCRIPTION) BIRTH_PLACE_DESC ,ETHNIC_GROUP_DESC , FROM_SPLTY_DESC ,			to_char(ALT_ID1_DATE,'dd/mm/yyyy') ALT_ID1_DATE,		to_char(ALT_ID2_DATE,'dd/mm/yyyy') ALT_ID2_DATE,	to_char(ALT_ID3_DATE,'dd/mm/yyyy') ALT_ID3_DATE,	to_char(ALT_ID4_DATE,'dd/mm/yyyy') ALT_ID4_DATE,family_name_loc_lang,third_name_loc_lang,second_name_loc_lang,first_name_loc_lang,name_prefix_loc_lang,name_suffix_loc_lang,patient_name_loc_lang  from pr_referral_register_vw, mp_alternate_id_type where  referral_id = ? and mp_alternate_id_type.alt_id_type (+) = nvl(pr_referral_register_vw.oth_alt_id_type, ?) " );

		sql.append("SELECT" );
		sql.append("  res_area_code " );
		sql.append("  , res_town_code " );
		sql.append("  , country_code " );
		sql.append("  , postal_code " );
		sql.append("  , region_code " );
		sql.append("  , mail_region_code " );
		sql.append("  , referred_for_ip " );
		sql.append("  , national_id_no " );
		sql.append("  , alt_id1_type " );
		sql.append("  , alt_id2_type " );
		sql.append("  ,alt_id3_type " );
		sql.append("  , alt_id4_type " );
		sql.append("  , oth_alt_id_type " );
		sql.append("  , alt_id1_no " );
		sql.append("  , alt_id2_no " );
		sql.append("  ,alt_id3_no " );
		sql.append("  , alt_id4_no " );
		sql.append("  , oth_alt_id_no " );
		sql.append("  , mail_addr_line1 " );
		sql.append("  , mail_addr_line2 " );
		sql.append("  , mail_addr_line3 " );
		sql.append("  , mail_res_town_code " );
		sql.append("  , mail_res_area_code " );
		sql.append("  , mail_country_code " );
		sql.append("  , mail_postal_code " );
		sql.append("  , mail_addr_line4 " );
		sql.append("  , mp_get_desc.MP_RACE ##REPDB##(RACE_CODE,'"+localeName+"',1) race_desc " );
		sql.append("  , am_get_desc.AM_CONTACT_REASON ##REPDB##(REFERRAL_REASON_CODE,'"+localeName+"',1) referral_reason " );
		sql.append("  , other_doc_att " );
		sql.append("  , exam_and_clin_findings " );
		sql.append("  , diagnosis " );
		sql.append("  , treatment " );
		sql.append("  , pract_res_tel_num " );
		sql.append("  , pract_mobile_num " );
		sql.append("  , pract_pager_num " );
		sql.append("  , patient_id " );
		sql.append("  ,decode('"+localeName+"', '"+localeName+"', patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name " );
		sql.append("  ,sex gender " );
		sql.append("  , name_prefix " );
		sql.append("  ,first_name " );
		sql.append("  ,second_name " );
		sql.append("  ,third_name " );
		sql.append("  ,family_name " );
		sql.append("  ,name_suffix " );
		sql.append("  ,calculate_age ##REPDB##(TO_CHAR(date_of_birth,'dd/mm/yyyy'),1)||'Y' agey " );
		sql.append("  ,calculate_age ##REPDB##(TO_CHAR(date_of_birth,'dd/mm/yyyy'),2)||'M' agem " );
		sql.append("  , calculate_age ##REPDB##(TO_CHAR(date_of_birth,'dd/mm/yyyy'),3)||'D' aged " );
		sql.append("  ,TO_CHAR(date_of_birth,'dd/mm/yyyy') date_of_birth " );
		sql.append("  ,mp_get_desc.MP_COUNTRY ##REPDB##(NATIONALITY_CODE,'"+localeName+"',1) nationality " );
		sql.append("  ,addr_line1 " );
		sql.append("  ,addr_line2 " );
		sql.append("  ,addr_line3 " );
		sql.append("  ,addr_line4 " );
		sql.append("  , contact1_no " );
		sql.append("  ,contact2_no " );
		sql.append("  ,am_get_desc.AM_HCARE_SETTING_TYPE ##REPDB##(FROM_HCARE_SETTING_TYPE,'"+localeName+"',2) from_hcare_setting_desc " );
		sql.append("  , decode(from_ref_type,'X',am_get_desc.AM_REFERRAL ##REPDB##(FROM_REF_CODE,'"+localeName+"',1),sm_get_desc.SM_FACILITY_PARAM ##REPDB##(FROM_FACILITY_ID,'"+localeName+"',1)) Ref_source " );
		sql.append("  , decode(from_ref_type,'X',am_get_desc.AM_REFERRAL ##REPDB##(FROM_REF_CODE,'"+localeName+"',3),'') from_long_name " );
		sql.append("  ,decode(to_ref_type,'X',am_get_desc.AM_REFERRAL ##REPDB##(TO_REF_CODE,'"+localeName+"',1),sm_get_desc.SM_FACILITY_PARAM ##REPDB##(TO_FACILITY_ID,'"+localeName+"',1)) ToRef_source " );
		sql.append("  , decode(to_ref_type,'X',am_get_desc.AM_REFERRAL ##REPDB##(TO_REF_CODE,'"+localeName+"',3),'') to_long_name " );
		sql.append("  , am_get_desc.AM_HCARE_SETTING_TYPE ##REPDB##(TO_HCARE_SETTING_TYPE,'"+localeName+"',2) to_hcare_setting_desc " );
		//sql.append("  ,TO_CHAR(referral_date,'dd/mm/yyyy') referral_date " );
		/*Modified By Dharma on 9th jan 2014 against MMS-SCF-0207 [IN:046319]*/
		sql.append("  ,TO_CHAR(referral_date,'dd/mm/yyyy hh24:mi') referral_date " );
		sql.append("  ,referral_letter_no " );
		sql.append("  ,TO_CHAR(preferred_treatment_date,'dd/mm/yyyy') preferred_treatment_date " );
		sql.append("  , referral_priority " );
		sql.append("  , TO_CHAR(received_date,'dd/mm/yyyy') received_date " );
		sql.append("  ,from_ref_type " );
		sql.append("  , to_ref_type " );
		sql.append("  , from_locn_type from_locn_type_desc " );
		sql.append("  , decode(from_ref_type,'X',FROM_LOCN_DESC, decode(from_locn_type,'N',ip_get_desc.IP_NURSING_UNIT ##REPDB##(FROM_FACILITY_ID,FROM_LOCN_CODE,'"+localeName+"',1),op_get_desc.OP_CLINIC ##REPDB##(FROM_FACILITY_ID,FROM_LOCN_CODE,'"+localeName+"',1))) from_ref_locn_desc " );
		sql.append("  , decode(to_ref_type,'X',TO_LOCN_DESC, decode(to_locn_type,'N',ip_get_desc.IP_NURSING_UNIT ##REPDB##(TO_FACILITY_ID,TO_LOCN_CODE,'"+localeName+"',1),op_get_desc.OP_CLINIC ##REPDB##(TO_FACILITY_ID,TO_LOCN_CODE,'"+localeName+"',1))) to_ref_locn_desc " );
		sql.append("  , to_locn_type to_locn_type_desc " );
		sql.append("  , decode(from_ref_type,'X',FROM_PRACT_NAME, am_get_desc.AM_PRACTITIONER ##REPDB##(FROM_PRACT_ID,'"+localeName+"',1)) from_ref_pract_name " );

	   sql.append(" ,(CASE WHEN to_pract_id IS NULL THEN to_pract_name ELSE DECODE (to_ref_type, 'X', am_get_desc.am_ext_practitioner ##REPDB##(to_pract_id, '"+localeName+"', 1 ), am_get_desc.am_practitioner ##REPDB##(to_pract_id, '"+localeName+"', 1)) END ) to_ref_pract_name ");

	//	sql.append("  , decode(to_ref_type,'X',TO_PRACT_NAME,am_get_desc.AM_PRACTITIONER(TO_PRACT_ID,'"+localeName+"',1)) to_ref_pract_name " );
		sql.append("  , am_get_desc.AM_SPECIALITY ##REPDB##(TO_SPECIALITY_CODE,'"+localeName+"',2) to_speciality_desc " );
		sql.append("  , am_get_desc.AM_SERVICE ##REPDB##(TO_SERVICE_CODE,'"+localeName+"',2) to_service_desc " );
		sql.append("  , ref_notes " );
		sql.append("  , status " );
		sql.append("  , decode(citizen_yn,'Y','true','false') citizen " );
		sql.append("  , decode(legal_illegal_yn,'Y','true','false') legal " );
		sql.append("  , mp_get_desc.mp_alternate_id_type ##REPDB##(oth_alt_id_type,'"+localeName+"',1) alternateIDdesc " );
		sql.append("  , NVL2(BIRTH_PLACE_CODE, mp_get_desc.MP_BIRTH_PLACE ##REPDB##(BIRTH_PLACE_CODE,'"+localeName+"',1), BIRTH_PLACE_DESC) BIRTH_PLACE_DESC " );
		sql.append("  ,mp_get_desc.MP_ETHNIC_GROUP ##REPDB##(ETHNIC_GRP_CODE,'"+localeName+"',1) ETHNIC_GROUP_DESC " );
		sql.append("  ,am_get_desc.AM_SPECIALITY ##REPDB##(FROM_SPECIALITY_CODE,'"+localeName+"',2) FROM_SPLTY_DESC " );
		sql.append("  , TO_CHAR(ALT_ID1_DATE,'dd/mm/yyyy') ALT_ID1_DATE " );
		sql.append("  , TO_CHAR(ALT_ID2_DATE,'dd/mm/yyyy') ALT_ID2_DATE " );
		sql.append("  , TO_CHAR(ALT_ID3_DATE,'dd/mm/yyyy') ALT_ID3_DATE " );
		sql.append("  , TO_CHAR(ALT_ID4_DATE,'dd/mm/yyyy') ALT_ID4_DATE " );
		sql.append("  ,family_name_loc_lang " );
		sql.append("  ,third_name_loc_lang " );
		sql.append("  ,second_name_loc_lang " );
		sql.append("  ,first_name_loc_lang " );
		sql.append("  ,name_prefix_loc_lang " );
		sql.append("  ,name_suffix_loc_lang " );
		sql.append("  ,patient_name_loc_lang " );
		sql.append("FROM" );
		sql.append("  pr_referral_register##CLOB## " );
		sql.append("WHERE referral_id = ? " );
		//Modified above query by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1

	/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
	sqlFinal = sql.toString();
	sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
	sqlFinal = sqlFinal.replaceAll("##CLOB##",clob_data);
	/*End*/
	pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
    pstmt.setString(1, referralid);
//	pstmt.setString(2, altIdType[0]);
	rs = pstmt.executeQuery();

	if(rs!=null)
	{
		if(rs.next())
		{
		patient_id				= rs.getString("patient_id");
		patient_name			= rs.getString("patient_name");
		prefix					= rs.getString("name_prefix");
		first_name				= rs.getString("first_name");
		second_name				= rs.getString("second_name");
		third_name				= rs.getString("third_name");
		family_name				= rs.getString("family_name");
		suffix					= rs.getString("name_suffix");
		gender					= rs.getString("gender");
		agey					= rs.getString("agey");
		agem					= rs.getString("agem");
		aged					= rs.getString("aged");
		date_of_birth			= rs.getString("date_of_birth");
		date_of_birth=DateUtils.convertDate(date_of_birth,"DMY","en",localeName);
		nationality				= rs.getString("nationality");
		addr_line1				= rs.getString("addr_line1");
		addr_line2				= rs.getString("addr_line2");
		addr_line3				= rs.getString("addr_line3");
		addr_line4				= rs.getString("addr_line4");
		contact1_no				= rs.getString("contact1_no");
		contact2_no				= rs.getString("contact2_no");
		from_hcare_setting_desc	= rs.getString("from_hcare_setting_desc");
		referral_date			= rs.getString("referral_date");
		//referral_date=DateUtils.convertDate(referral_date,"DMY","en",localeName);
		/*Modified By Dharma on 9th jan 2014 against MMS-SCF-0207 [IN:046319]*/
		referral_date=DateUtils.convertDate(referral_date,"DMYHM","en",localeName);
		referral_letter_no		= rs.getString("referral_letter_no");
		preferred_treatment_date= rs.getString("preferred_treatment_date");
		preferred_treatment_date=DateUtils.convertDate(preferred_treatment_date,"DMY","en",localeName);
		referral_priority		= rs.getString("referral_priority");
		
		received_date			= rs.getString("received_date");	received_date=DateUtils.convertDate(received_date,"DMY","en",localeName);
		
		from_ref_type			= rs.getString("from_ref_type");


		first_name_loc_lang			= rs.getString("first_name_loc_lang");
		if(first_name_loc_lang==null)
			first_name_loc_lang="";
		second_name_loc_lang			= rs.getString("second_name_loc_lang");
		if(second_name_loc_lang==null)
			second_name_loc_lang="";
		third_name_loc_lang			= rs.getString("third_name_loc_lang");
		if(third_name_loc_lang==null)
			third_name_loc_lang="";
		family_name_loc_lang			= rs.getString("family_name_loc_lang");
		if(family_name_loc_lang==null)
			family_name_loc_lang="";
		name_prefix_loc_lang			= rs.getString("name_prefix_loc_lang");
		if(name_prefix_loc_lang==null)
			name_prefix_loc_lang="";
		name_suffix_loc_lang			= rs.getString("name_suffix_loc_lang");
		if(name_suffix_loc_lang==null)
			name_suffix_loc_lang="";
		patient_name_loc_lang			= rs.getString("patient_name_loc_lang");
		if(patient_name_loc_lang==null)
			patient_name_loc_lang="";


		if (from_ref_type != null)
		{
			if (from_ref_type.equals("X"))
				from_ref_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels");
			else
			if (from_ref_type.equals("E"))
				from_ref_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enterprise.label","common_labels");
			else
			if (from_ref_type.equals("L"))
				from_ref_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.loginfacility.label","common_labels");
		}
		from_ref_locn_type			= rs.getString("from_locn_type_desc");
		if(from_ref_locn_type==null)
			from_ref_locn_type="";
	if(!from_ref_locn_type.equals(""))
			{
				switch (from_ref_locn_type.charAt(0))
				{
					case  'C' :
								from_ref_locn_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels") ;		
								break;
					case  'Y' :
								from_ref_locn_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
								break;
					case  'E' :
								from_ref_locn_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
								break;
					case  'N' :
								from_ref_locn_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
								break;
				}
			}
		from_ref_locn_desc		= rs.getString("from_ref_locn_desc");
		from_ref_pract_name		= rs.getString("from_ref_pract_name");
		to_speciality_desc			= rs.getString("to_speciality_desc");
		to_service_desc			= rs.getString("to_service_desc");
		to_ref_pract_name			= rs.getString("to_ref_pract_name");
		status							= rs.getString("status");
		citizen						= Boolean.valueOf(rs.getString("citizen")).booleanValue();
		nationalIdNo					= rs.getString("national_id_no");
		othAltIdTypeDescription	= rs.getString("alternateIDdesc");
		othAltIdNo					= rs.getString("oth_alt_id_no");
		mailResTownCode			= rs.getString("mail_res_town_code");
		mailResAreaCode			= rs.getString("mail_res_area_code");
		mailCountryCode		= rs.getString("mail_country_code");
		mailPostalCode			= rs.getString("mail_postal_code");
		mailRegionCode			= rs.getString("mail_region_code");
		referralReason			= rs.getString("referral_reason");
		otherDocAttached		= rs.getString("other_doc_att");
		legal					= Boolean.valueOf(rs.getString("legal")).booleanValue();
		raceDesc				= rs.getString("race_desc");
		examAndClinFindings		= rs.getString("exam_and_clin_findings");
		diagnosis				= rs.getString("diagnosis");
		treatment				= rs.getString("treatment");
		practitionerResTelNo	= rs.getString("pract_res_tel_num");
		practitionerMobileNo	= rs.getString("pract_mobile_num");
		practitionerPagerNo		= rs.getString("pract_pager_num");
		toRefType				= rs.getString("to_ref_type");
		if (toRefType != null)
		{
			if (toRefType.equals("X"))
				toRefTypeDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels");
			else
			if (toRefType.equals("E"))
				toRefTypeDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enterprise.label","common_labels");
			else
			if (toRefType.equals("L"))
				toRefTypeDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.loginfacility.label","common_labels");
		}
		toRefLocnDesc			= checkForNull(rs.getString("to_ref_locn_desc"));

		to_locn_type_desc       = checkForNull(rs.getString("to_locn_type_desc"));

	if(!to_locn_type_desc.equals("")) 
	{
		switch (to_locn_type_desc.charAt(0))
		{
			case  'C' :
						to_locn_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels") ;		
						break;
			case  'Y' :
						to_locn_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
						break;
			case  'E' :
						to_locn_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
						break;
			case  'N' :
						to_locn_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
						break;
			case  'W' :
						to_locn_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RadiologyWing.label","common_labels");
						break;
		}
	}
		toHcareSettingDesc		= rs.getString("to_hcare_setting_desc");
		referredForIP			= rs.getString("referred_for_ip");
		if(referredForIP == null) referredForIP="";
		else
		{
		if (referredForIP.equals("B"))
			referredForIP = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.booking.label","common_labels");
		else
		if (referredForIP.equals("A"))
			referredForIP = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels");
		}
//decode(referred_for_ip,'B','Booking','A','Admission','')
		resAreaCode				= rs.getString("res_area_code");
		resTownCode				= rs.getString("res_town_code");
		countryCode				= rs.getString("country_code");
		regionCode				= rs.getString("region_code");
		postalCode				= rs.getString("postal_code");
		Birth_place_desc		= rs.getString("BIRTH_PLACE_DESC");
		Race_desc				= rs.getString("ETHNIC_GROUP_DESC");
		From_Splty_desc			= rs.getString("FROM_SPLTY_DESC");
		Alt_ID1_date			= rs.getString("ALT_ID1_DATE");
		Alt_ID1_date=DateUtils.convertDate(Alt_ID1_date,"DMY","en",localeName);
		Alt_ID2_date			= rs.getString("ALT_ID2_DATE");
		Alt_ID2_date=DateUtils.convertDate(Alt_ID2_date,"DMY","en",localeName);
		Alt_ID3_date			= rs.getString("ALT_ID3_DATE");
		Alt_ID3_date=DateUtils.convertDate(Alt_ID3_date,"DMY","en",localeName);
		Alt_ID4_date			= rs.getString("ALT_ID4_DATE");
		Alt_ID4_date=DateUtils.convertDate(Alt_ID4_date,"DMY","en",localeName);
		Ref_source			= rs.getString("Ref_source");
		ToRef_source        = rs.getString("ToRef_source");
		from_long_name= checkForNull(rs.getString("from_long_name"));
		to_long_name= checkForNull(rs.getString("to_long_name"));


		altIdNo1 = rs.getString("alt_id1_no");
			if(altIdNo1==null || altIdTypeDesc1.equals("")) altIdNo1="";
		altIdNo2 = rs.getString("alt_id2_no");
			if(altIdNo2==null || altIdTypeDesc2.equals("")) altIdNo2="";
		altIdNo3 = rs.getString("alt_id3_no");
			if(altIdNo3==null || altIdTypeDesc3.equals("")) altIdNo3="";
		altIdNo4 = rs.getString("alt_id4_no");
			if(altIdNo4==null || altIdTypeDesc4.equals("")) altIdNo4="";

		for(int i=0;i<4;i++)
		{
			mailAddress[i]=rs.getString("mail_addr_line"+(i+1));
		}
		
		if (patient_id==null) patient_id ="";
		if (patient_name==null) patient_name ="";
		if (prefix==null){ prefix =""; NRICNamePrefixAvailable=false; }
		if (first_name==null){ first_name =""; NRICFirstNameAvailable=false; }
		if (second_name==null){ second_name =""; NRICSecondNameAvailable=false; }
		if (third_name==null){ third_name =""; NRICThirdNameAvailable=false; }
		if (family_name==null){ family_name =""; NRICFamilyNameAvailable=false; }
		if (suffix==null){ suffix =""; NRICNameSuffixAvailable=false; }
		if (gender==null) gender ="";
		if (agey==null) agey ="";
		if (agem==null) agem ="";
		if (aged==null) aged ="";
		if (date_of_birth==null) date_of_birth ="";
		if (nationality==null) nationality ="";
		if (addr_line1==null) addr_line1 ="";
		if (addr_line2==null) addr_line2 ="";
		if (addr_line3==null) addr_line3 ="";
		if (addr_line4==null) addr_line4 ="";
		if (contact1_no==null) contact1_no ="";
		if (contact2_no==null) contact2_no ="";
		if (from_hcare_setting_desc==null) from_hcare_setting_desc ="";
		if (referral_date==null) referral_date ="";
		if (referral_letter_no==null) referral_letter_no ="";
		if (from_ref_type==null) from_ref_type ="";
		  
		if (from_ref_locn_type==null) from_ref_locn_type ="";
		if (from_ref_locn_desc==null) from_ref_locn_desc ="";
		if (from_ref_pract_name==null) from_ref_pract_name ="";
		if (referral_priority==null) referral_priority ="";
		if (received_date==null) received_date ="";
		if (to_speciality_desc==null) to_speciality_desc ="";
		if (preferred_treatment_date==null) preferred_treatment_date ="";
		if (to_service_desc==null) to_service_desc ="";
		if (to_ref_pract_name==null) to_ref_pract_name ="";
		note=rs.getClob("REF_NOTES");
		if(note!=null)
		{
			java.io.BufferedReader r = new java.io.BufferedReader(note.getCharacterStream());
			String line = null;
			while((line=r.readLine()) != null) displaydata= displaydata+line+"\n";
		}

		if(status==null) status="";
		if(nationalIdNo==null) nationalIdNo="";
		if(othAltIdTypeDescription==null) {othAltIdTypeDescription=""; othAltIdNo="";}
		if(othAltIdNo==null) othAltIdNo="";
		if(mailResTownCode==null) mailResTownCode="";
		if(mailResAreaCode==null) mailResAreaCode="";
		if(mailCountryCode==null) mailCountryCode="";
		if(mailPostalCode==null) mailPostalCode="";
		if(mailRegionCode==null) mailRegionCode="";
		if(referralReason==null) referralReason="";
		if(otherDocAttached==null) otherDocAttached="";
		if(raceDesc==null) raceDesc="";
		if(toSpecialityDesc==null) toSpecialityDesc="";
		if(examAndClinFindings==null) examAndClinFindings="";
		if(diagnosis==null) diagnosis="";
		if(treatment==null) treatment="";

		
		if(practitionerResTelNo==null) practitionerResTelNo="";
		if(practitionerMobileNo==null) practitionerMobileNo="";
		if(practitionerPagerNo==null) practitionerPagerNo="";
		if(toRefType==null) toRefType="";
		if(toRefTypeDesc ==null) toRefTypeDesc ="";
		
		if(to_locn_type_desc==null)to_locn_type_desc="";

		if(!to_locn_type_desc.equals(""))
		{
		if(toRefLocnDesc!=null)
			toRefLocnDesc = toRefLocnDesc;
		}
		
		
		if(toRefLocnDesc==null) toRefLocnDesc="";

		if(toRefPractName==null) toRefPractName="";
		if(toHcareSettingDesc==null) toHcareSettingDesc="";
		if(resAreaCode==null) resAreaCode="";
		if(resTownCode==null) resTownCode="";
		if(countryCode==null) countryCode="";
		if(regionCode==null) regionCode="";
		if(postalCode==null) postalCode="";
		if(	Birth_place_desc==null) Birth_place_desc="";
		if(	Race_desc==null) Race_desc="";
		if(From_Splty_desc==null) From_Splty_desc="";
		if(Alt_ID1_date==null) Alt_ID1_date="";
		if(Alt_ID2_date==null) Alt_ID2_date="";
		if(Alt_ID3_date==null) Alt_ID3_date="";
		if(Alt_ID4_date==null) Alt_ID4_date="";
		if(Ref_source==null) Ref_source="";
		if(ToRef_source==null)ToRef_source="";

		for(int i=0;i<4;i++)
		{
			if(altIdNo[i]==null)
				altIdNo[i]="";

			if(mailAddress[i]==null)
				mailAddress[i]="";
			
			name_prompts[i]="";
			names[i]="";
			names_local[i]="";
			name_prompts_local[i]="";
		
		}
		
		if( first_name_order.equals("1") )
		{
			names[0]		=first_name  ;
			name_prompts[0] = first_name_prompt ;
			names_local[0]		=first_name_loc_lang  ;
			name_prompts_local[0] = first_name_loc_lang_prompt ;
		}
		else if(first_name_order.equals("2"))
		{
			names[1]		=first_name  ;
			name_prompts[1] = first_name_prompt;
			names_local[1]		=first_name_loc_lang  ;
			name_prompts_local[1] = first_name_loc_lang_prompt ;
		}
		else if(first_name_order.equals("3"))
		{
			names[2]		=first_name;
			name_prompts[2] = first_name_prompt;
			names_local[2]		=first_name_loc_lang  ;
			name_prompts_local[2] = first_name_loc_lang_prompt ;
		}
		else if(first_name_order.equals("4"))
		{
			names[3]		=first_name  ;
			name_prompts[3] = first_name_prompt;
			names_local[3]		=first_name_loc_lang  ;
			name_prompts_local[3] = first_name_loc_lang_prompt ;
		}

		if( second_name_order.equals("1") )
		{
			names[0]			 =second_name  ;
			name_prompts[0]		 = second_name_prompt ;
			names_local[0]		 =second_name_loc_lang  ;
			name_prompts_local[0]= second_name_loc_lang_prompt ;
		}
		else if(second_name_order.equals("2"))
		{
			names[1]		=second_name  ;
			name_prompts[1] = second_name_prompt;
			names_local[1]		 =second_name_loc_lang  ;
			name_prompts_local[1]= second_name_loc_lang_prompt ;
		}
		else if(second_name_order.equals("3"))
		{
			names[2]		=second_name  ;
			name_prompts[2] = second_name_prompt;
			names_local[2]		 =second_name_loc_lang  ;
			name_prompts_local[2]= second_name_loc_lang_prompt ;
		}
		else if(second_name_order.equals("4"))
		{
			names[3]		=second_name  ;
			name_prompts[3] = second_name_prompt;
			names_local[3]		 =second_name_loc_lang  ;
			name_prompts_local[3]= second_name_loc_lang_prompt ;
		}
	
		if( third_name_order.equals("1") )
		{
			names[0]		=third_name  ;
			name_prompts[0] = third_name_prompt ;
			names_local[0]		 =third_name_loc_lang  ;
			name_prompts_local[0]= third_name_loc_lang_prompt ;
		}
		else if(third_name_order.equals("2"))
		{
			names[1]		=third_name  ;
			name_prompts[1] = third_name_prompt;
			names_local[1]		 =third_name_loc_lang  ;
			name_prompts_local[1]= third_name_loc_lang_prompt ;
		}
		else if(third_name_order.equals("3"))
		{
			names[2]		=third_name  ;
			name_prompts[2] = third_name_prompt;
			names_local[2]		 =third_name_loc_lang  ;
			name_prompts_local[2]= third_name_loc_lang_prompt ;
		}
		else if(third_name_order.equals("4"))
		{
			names[3]		=third_name  ;
			name_prompts[3] = third_name_prompt;
			names_local[3]		 =third_name_loc_lang  ;
			name_prompts_local[3]= third_name_loc_lang_prompt ;
		}
	
		if( family_name_order.equals("1") )
		{
			names[0]		=family_name  ;
			name_prompts[0] = family_name_prompt ;
			names_local[0]		 =family_name_loc_lang  ;
			name_prompts_local[0]= family_name_loc_lang_prompt ;
		}
		else if(family_name_order.equals("2"))
		{
			names[1]		=family_name  ;
			name_prompts[1] = family_name_prompt;
			names_local[1]		 =family_name_loc_lang  ;
			name_prompts_local[1]= family_name_loc_lang_prompt ;
		}
		else if(family_name_order.equals("3"))
		{
			names[2]		=family_name  ;
			name_prompts[2] = family_name_prompt;
			names_local[2]		 =family_name_loc_lang  ;
			name_prompts_local[2]= family_name_loc_lang_prompt ;
		}
		else if(family_name_order.equals("4"))
		{
			names[3]		=family_name  ;
			name_prompts[3] = family_name_prompt;
			names_local[3]		 =family_name_loc_lang  ;
			name_prompts_local[3]= family_name_loc_lang_prompt ;
		}

		/*
		
		for(int i=0;i<4;i++)
		{
			if(name_prompts[i].equals(""))
			{
				names[i]="";
			}
			if(name_prompts_local[i].equals(""))
			{
				names_local[i]="";
			}
		}

		*/
    
	try{

	String orgTypeSQL ="select org_type from pr_referral_register##CLOB##, am_referral ##REPDB## where referral_id = ? and from_ref_code = referral_code";//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
	
	/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
	orgTypeSQL = orgTypeSQL.replaceAll("##REPDB##",RepDb);
	orgTypeSQL = orgTypeSQL.replaceAll("##CLOB##",clob_data);
	/*End*/
					orgTypePstmt = con.prepareStatement( orgTypeSQL );
	                orgTypePstmt.setString ( 1, referralid ) ;
					orgTypeRS = orgTypePstmt.executeQuery() ;
		            if(orgTypeRS.next()) {
						org_type_data = orgTypeRS.getString( "org_type");

					if(org_type_data!=null && org_type_data.equals("P"))  		
						org_type_data="P";
					else
						org_type_data="G";
					


					}else{
					
					org_type_data="G";
					}

					if(orgTypeRS != null) orgTypeRS.close();
					if(orgTypePstmt != null) orgTypePstmt.close();
	}
catch(Exception e){

e.printStackTrace();
}
 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(referralid));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(referralid));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_name_loc_lang));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(nationalIDPrompt));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(nationalIdNo));
            _bw.write(_wl_block19Bytes, _wl_block19);
if(!othAltIdNo.equals("")){
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(othAltIdTypeDescription));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(othAltIdNo));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block23Bytes, _wl_block23);
if(!altIdTypeDesc1.equals("") || !altIdTypeDesc2.equals("") )
		{
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(altIdTypeDesc1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(altIdNo1));
            _bw.write(_wl_block26Bytes, _wl_block26);
if(altIdTypeDesc1.equals("")){ exp_date_desc="";Alt_ID1_date="";}else exp_date_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(exp_date_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(Alt_ID1_date));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(altIdTypeDesc2));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(altIdNo2));
            _bw.write(_wl_block26Bytes, _wl_block26);
if(altIdTypeDesc2.equals("")){ exp_date_desc="";Alt_ID2_date="";}else exp_date_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(exp_date_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(Alt_ID2_date));
            _bw.write(_wl_block32Bytes, _wl_block32);

			}
		if( !altIdTypeDesc3.equals("") || !altIdTypeDesc4.equals(""))
		{
				
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(altIdTypeDesc3));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(altIdNo3));
            _bw.write(_wl_block26Bytes, _wl_block26);
if(altIdTypeDesc3.equals("")) {exp_date_desc="";Alt_ID3_date="";}else exp_date_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(exp_date_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(Alt_ID3_date));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(altIdTypeDesc4));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(altIdNo4));
            _bw.write(_wl_block36Bytes, _wl_block36);
if(altIdTypeDesc4.equals("")){ exp_date_desc="";Alt_ID4_date="";}else exp_date_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(exp_date_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(Alt_ID4_date));
            _bw.write(_wl_block37Bytes, _wl_block37);
}
	
            _bw.write(_wl_block38Bytes, _wl_block38);
if(NRICFirstNameAvailable || NRICSecondNameAvailable || NRICThirdNameAvailable || NRICFamilyNameAvailable){
            _bw.write(_wl_block39Bytes, _wl_block39);
if(name_prefix_accept_yn.equals("Y")){ 
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(prefix_prompt));
            _bw.write(_wl_block41Bytes, _wl_block41);
}for(int i=0;i<4;i++){
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(name_prompts[i]));
            _bw.write(_wl_block41Bytes, _wl_block41);
}if(name_suffix_accept_yn.equals("Y")){
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(suffix_prompt));
            _bw.write(_wl_block43Bytes, _wl_block43);
}
            _bw.write(_wl_block44Bytes, _wl_block44);
if(name_prefix_accept_yn.equals("Y")){ 
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(prefix));
            _bw.write(_wl_block46Bytes, _wl_block46);
}for(int i=0;i<4;i++) { 
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(names[i]));
            _bw.write(_wl_block48Bytes, _wl_block48);
}if(name_suffix_accept_yn.equals("Y")){
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(suffix));
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block51Bytes, _wl_block51);
if(names_in_oth_lang_yn.equals("Y")){
            _bw.write(_wl_block52Bytes, _wl_block52);
if(name_prefix_accept_yn.equals("Y")){
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(name_prefix_loc_lang_prompt));
            _bw.write(_wl_block41Bytes, _wl_block41);
}for(int i=0;i<4;i++){
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(name_prompts_local[i]));
            _bw.write(_wl_block41Bytes, _wl_block41);
}if(name_suffix_accept_yn.equals("Y")){
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(name_suffix_loc_lang_prompt));
            _bw.write(_wl_block41Bytes, _wl_block41);
}
            _bw.write(_wl_block53Bytes, _wl_block53);
if(name_prefix_accept_yn.equals("Y")){ 
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(name_prefix_loc_lang));
            _bw.write(_wl_block54Bytes, _wl_block54);
}for(int i=0;i<4;i++) { 
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(names_local[i]));
            _bw.write(_wl_block55Bytes, _wl_block55);
}if(name_suffix_accept_yn.equals("Y")){
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(name_suffix_loc_lang));
            _bw.write(_wl_block56Bytes, _wl_block56);
}
            _bw.write(_wl_block57Bytes, _wl_block57);
}
            _bw.write(_wl_block58Bytes, _wl_block58);
}
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(Birth_place_desc));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
if(gender.equals("M"))
			{  
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
}else if(gender.equals("F")){
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
}else if(gender.equals("U")){
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
}
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(agey));
            out.print( String.valueOf(agem));
            out.print( String.valueOf(aged));
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
if(citizen){
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
}else{
			
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
}
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);

			if(legal){
			
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);
}else{
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);
}
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(nationality));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(raceDesc));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(Race_desc));
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(referral_letter_no));
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(received_date));
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(referral_date));
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(preferred_treatment_date));
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(referralReason));
            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(from_ref_type_desc));
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(from_hcare_setting_desc));
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(Ref_source));
            _bw.write(_wl_block72Bytes, _wl_block72);
if(from_ref_type.equals("X") && ! from_long_name.equals("") && ! from_long_name.equals("--select--")){
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(from_long_name));
            _bw.write(_wl_block100Bytes, _wl_block100);
}
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(From_Splty_desc));
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);

	if(from_ref_type.equals("L") || from_ref_type.equals("E"))
		{
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
if(!from_ref_locn_desc.equals(""))
		{
		
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(from_ref_locn_type));
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(from_ref_locn_desc));
            _bw.write(_wl_block109Bytes, _wl_block109);

	  	}
		else
		{
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(from_ref_locn_type));
            _bw.write(_wl_block56Bytes, _wl_block56);

		}
		}
		else
		{
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(from_ref_locn_desc));
            _bw.write(_wl_block50Bytes, _wl_block50);

		}
			
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(from_ref_pract_name));
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(practitionerResTelNo));
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(practitionerMobileNo));
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(practitionerPagerNo));
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(visibility_table));
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(to_speciality_desc));
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(to_service_desc));
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(to_locn_type_desc));
            _bw.write(_wl_block129Bytes, _wl_block129);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(toRefLocnDesc));
            _bw.write(_wl_block131Bytes, _wl_block131);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(to_ref_pract_name));
            _bw.write(_wl_block133Bytes, _wl_block133);
if(or_install_yn.equals("Y"))
  {
            _bw.write(_wl_block134Bytes, _wl_block134);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(orderCatalog));
            _bw.write(_wl_block135Bytes, _wl_block135);
}else{
            _bw.write(_wl_block136Bytes, _wl_block136);
}
            _bw.write(_wl_block137Bytes, _wl_block137);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block138Bytes, _wl_block138);
 
                         if(isReferralPriorityAppl){ 	
                            	PreparedStatement prestmt			= null;      		
                   				ResultSet resultSet				= null;
                   				String ref_priority="";
                   				
                   				try 
                   				{				
                   				prestmt		= con.prepareStatement("SELECT PRIORITY_DESC FROM AM_REFERRAL_PRIORITY WHERE PRIORITY_CODE = (SELECT REFERRAL_PRIORITY FROM PR_REFERRAL_REGISTER WHERE REFERRAL_ID = ?)");
                   				prestmt.setString(1,referralid);			
                   						
                   				resultSet	= prestmt.executeQuery() ;
                   				if (resultSet !=null && resultSet.next())
                   				{
                   					ref_priority = resultSet.getString("PRIORITY_DESC");
                   				}
                   				}catch(Exception e){
                   					e.printStackTrace();
                   				}finally
                   				{
                   					if(resultSet!=null)resultSet.close();
                   					if(prestmt!=null)prestmt.close();
                   				}

            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(ref_priority));
            _bw.write(_wl_block140Bytes, _wl_block140);
	
						}else{   													

            _bw.write(_wl_block141Bytes, _wl_block141);

		if((referral_priority.equalsIgnoreCase("E"))) 
			  out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels"));
			if((referral_priority.equalsIgnoreCase("U"))) 
			 out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.semiemergency.label","common_labels"));
			if((referral_priority.equalsIgnoreCase("R")))
			 out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.for.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels"));
			if((referral_priority.equalsIgnoreCase("L")))
			 out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.elective.label","common_labels"));
						

            _bw.write(_wl_block142Bytes, _wl_block142);

					}
	 
            _bw.write(_wl_block143Bytes, _wl_block143);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(referredForIP));
            _bw.write(_wl_block144Bytes, _wl_block144);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(toRefTypeDesc));
            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(toHcareSettingDesc));
            _bw.write(_wl_block148Bytes, _wl_block148);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(ToRef_source));
            _bw.write(_wl_block150Bytes, _wl_block150);
if(toRefType.equals("X") && ! to_long_name.equals("") && ! from_long_name.equals("--select--")){
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(to_long_name));
            _bw.write(_wl_block100Bytes, _wl_block100);
}
            _bw.write(_wl_block151Bytes, _wl_block151);
int i=0;
    sql.setLength(0);
	sql.append("select to_char(a.ACTION_DATE_TIME,'dd/mm/yyyy hh24:mi:ss') action_date_time,DECODE(a.ACTION_TYPE,'AS', 'Appt Scheduled','AR', 'Appt Re-scheduled','AC', 'Appt Cancelled','RF', 'Follow-up','RR', 'Rejected','CO', 'Completed') ACTION_TYPE_DESC,b.CONTACT_REASON ACTION_REASON_DESC,a.ACTION_REF_ID,a.ACTION_REMARKS,a.ACTIONED_BY from PR_REFERRAL_REGISTER_ACTION ##REPDB## a, am_contact_reason ##REPDB## b where a.ACTION_REASON_CODE=b.CONTACT_REASON_CODE(+) and a.REFERRAL_ID='"+referralid +"' and a.FACILITY_ID='"+facility_id+"'order by a.ACTION_DATE_TIME desc");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
	
	/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
	sqlFinal = sql.toString();
	sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
	/*End*/
	pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
	rs = pstmt.executeQuery();
    
	int j=0;
	while(rs!=null &&rs.next())
		{
	       if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
	       else
		  	classValue = "QRYODD" ;
		
		 action_date_time			= rs.getString("action_date_time");
		 if (action_date_time!=null)
		{
			 action_date_time= DateUtils.convertDate(action_date_time,"DMYHMS","en",localeName);
		}
		else
			action_date_time="";
		
		 action_type_desc			= rs.getString("action_type_desc");
		 if (action_type_desc==null) action_type_desc="";
		
		 action_reason_desc		= rs.getString("action_reason_desc");
		 if (action_reason_desc==null) action_reason_desc = "";
		 action_ref_id		= rs.getString("action_ref_id");
		 if (action_ref_id==null) action_ref_id="";
		 action_remarks		= rs.getString("action_remarks");
		 if (action_remarks==null) action_remarks = "";
		
		 actioned_by		= rs.getString("actioned_by");
		 if (actioned_by==null) actioned_by="";
    if(j==0)
	{
		
            _bw.write(_wl_block152Bytes, _wl_block152);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block154Bytes, _wl_block154);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block155Bytes, _wl_block155);
j=1;}
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(action_date_time));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(action_type_desc));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(action_reason_desc));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(action_ref_id));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(action_remarks));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(actioned_by));
            _bw.write(_wl_block161Bytes, _wl_block161);
i++;}

if(rs!=null)rs.close();
if(pstmt!=null)pstmt.close();



            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(displaydata));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(otherDocAttached));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(examAndClinFindings));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(diagnosis));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(treatment));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(addr_line1));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(addr_line2));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(addr_line3));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(addr_line4));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(resTownCode));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(resAreaCode));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(postalCode));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(regionCode));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(countryCode));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(contact1_no));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(mailAddress[0]));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(mailAddress[1]));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(mailAddress[2]));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(mailAddress[3]));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(mailResTownCode));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(mailResAreaCode));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(mailPostalCode));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(mailRegionCode));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(mailCountryCode));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(contact2_no));
            _bw.write(_wl_block187Bytes, _wl_block187);

 }
}

  sql.setLength(0);
  if(rs!=null)	rs.close();
  if(pstmt!=null)	pstmt.close();

}catch(Exception e)
	{
		out.print(e.toString());
		e.printStackTrace();
		
	}finally
	{
	   if(con != null)         
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block188Bytes, _wl_block188);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthPlace.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.residency.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.citizen.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.noncitizen.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.LegalResident.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.IllegalResident.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.race.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ethnicity.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredFrom.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredFrom.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredTo.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredTo.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ReferralLetterNo.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReceivedDate.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredDate.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreferredDate.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.HealthcareSettingType.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredTo.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredFrom.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.clinicaldetails.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notes.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.telno.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MobileNo.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PagerNo.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otherDetails.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OtherDocAttached.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OrderableProcedure.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ReferredForIP.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.HealthcareSettingType.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredTo.label", java.lang.String .class,"key"));
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
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.action.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Reference.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ActionedBy.label", java.lang.String .class,"key"));
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
}
